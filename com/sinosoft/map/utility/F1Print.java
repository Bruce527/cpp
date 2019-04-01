/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class F1Print
/*     */ {
/*     */   private String strXMLFileName;
/*     */   private XMLPathTool aTest;
/*  20 */   private Node m_nodeMultiRow = null;
/*  21 */   private boolean m_bBOF = false;
/*     */ 
/*     */   public F1Print()
/*     */   {
/*     */   }
/*     */ 
/*     */   public F1Print(String argXMLFile)
/*     */   {
/*  30 */     setFileName(argXMLFile);
/*     */   }
/*     */ 
/*     */   public F1Print(InputStream in)
/*     */   {
/*  36 */     this.strXMLFileName = "";
/*  37 */     this.aTest = new XMLPathTool(in);
/*     */   }
/*     */ 
/*     */   public void setFileName(String argFileName)
/*     */   {
/*  43 */     this.strXMLFileName = argFileName;
/*  44 */     this.aTest = new XMLPathTool(this.strXMLFileName);
/*     */   }
/*     */ 
/*     */   public String getTemplate()
/*     */   {
/*  49 */     Node node = this.aTest.parseX("/DATASET/CONTROL/TEMPLATE");
/*  50 */     return getNodeValue(node);
/*     */   }
/*     */ 
/*     */   public String getNodeValue(String argXPath)
/*     */   {
/*  55 */     Node node = this.aTest.parseX(argXPath);
/*  56 */     return getNodeValue(node);
/*     */   }
/*     */ 
/*     */   public String getDisplayControl(String strName)
/*     */   {
/*  61 */     Node node = this.aTest.parseX("/DATASET/CONTROL/DISPLAY" + strName);
/*  62 */     return getNodeValue(node);
/*     */   }
/*     */ 
/*     */   public String[] getNodeListValue(String argXPath, String argChildPath)
/*     */   {
/*  67 */     NodeList nodeList = this.aTest.parseN(argXPath + "/" + argChildPath);
/*  68 */     String[] nVal = null;
/*     */ 
/*  70 */     if (nodeList == null)
/*     */     {
/*  72 */       nVal = new String[0];
/*     */     }
/*     */     else
/*     */     {
/*  76 */       nVal = new String[nodeList.getLength()];
/*  77 */       for (int i = 0; i < nodeList.getLength(); i++)
/*     */       {
/*  81 */         if (nodeList.item(i).getFirstChild().equals("null"))
/*     */         {
/*  83 */           nVal[i] = "";
/*     */         }
/*     */         else
/*     */         {
/*  87 */           nVal[i] = nodeList.item(i).getFirstChild().getNodeValue();
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  92 */     return nVal;
/*     */   }
/*     */ 
/*     */   public void query(String argXPath)
/*     */   {
/*  98 */     this.m_nodeMultiRow = this.aTest.parseX(argXPath);
/*  99 */     this.m_bBOF = true;
/*     */   }
/*     */ 
/*     */   public boolean next()
/*     */   {
/* 104 */     boolean bReturn = true;
/*     */ 
/* 106 */     if (this.m_nodeMultiRow == null)
/*     */     {
/* 108 */       bReturn = false;
/*     */     }
/* 112 */     else if (this.m_bBOF)
/*     */     {
/* 115 */       bReturn = true;
/* 116 */       this.m_bBOF = false;
/*     */     }
/*     */     else
/*     */     {
/* 122 */       bReturn = false;
/*     */ 
/* 124 */       this.m_nodeMultiRow = this.m_nodeMultiRow.getNextSibling();
/*     */ 
/* 126 */       while (this.m_nodeMultiRow != null)
/*     */       {
/* 128 */         if (this.m_nodeMultiRow.getNodeType() == 1)
/*     */         {
/* 130 */           bReturn = true;
/* 131 */           break;
/*     */         }
/* 133 */         this.m_nodeMultiRow = this.m_nodeMultiRow.getNextSibling();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 138 */     return bReturn;
/*     */   }
/*     */ 
/*     */   public String getString(String strChildPath)
/*     */   {
/* 144 */     String strReturn = "";
/*     */ 
/* 146 */     if (this.m_nodeMultiRow == null)
/*     */     {
/* 148 */       return "";
/*     */     }
/*     */ 
/* 151 */     Node node = null;
/* 152 */     NodeList nodeList = this.m_nodeMultiRow.getChildNodes();
/*     */ 
/* 154 */     for (int i = 0; i < nodeList.getLength(); i++)
/*     */     {
/* 156 */       node = nodeList.item(i);
/* 157 */       if (!node.getNodeName().equals(strChildPath)) {
/*     */         continue;
/*     */       }
/* 160 */       node = node.getFirstChild();
/*     */ 
/* 162 */       if (node != null)
/*     */       {
/* 164 */         strReturn = node.getNodeValue();
/* 165 */         break;
/*     */       }
/*     */ 
/* 168 */       strReturn = "";
/*     */ 
/* 170 */       break;
/*     */     }
/*     */ 
/* 174 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getString(int nIndex)
/*     */   {
/* 180 */     String strReturn = "";
/*     */ 
/* 182 */     if ((nIndex < 0) || (this.m_nodeMultiRow == null))
/*     */     {
/* 184 */       return "";
/*     */     }
/*     */ 
/* 187 */     Node node = this.m_nodeMultiRow.getChildNodes().item(nIndex);
/* 188 */     NodeList nodeList = this.m_nodeMultiRow.getChildNodes();
/*     */ 
/* 190 */     int nItem = 0;
/* 191 */     for (int nCount = 0; nCount < nodeList.getLength(); nCount++)
/*     */     {
/* 193 */       node = nodeList.item(nCount);
/*     */ 
/* 195 */       if (node.getNodeType() != 1)
/*     */         continue;
/* 197 */       if (nItem == nIndex)
/*     */       {
/*     */         break;
/*     */       }
/*     */ 
/* 203 */       nItem++;
/*     */     }
/*     */ 
/* 208 */     node = node.getFirstChild();
/*     */ 
/* 210 */     if (node != null)
/*     */     {
/* 212 */       strReturn = node.getNodeValue();
/*     */     }
/*     */     else
/*     */     {
/* 216 */       strReturn = "";
/*     */     }
/*     */ 
/* 219 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public int getColCount()
/*     */   {
/* 225 */     if (this.m_nodeMultiRow == null)
/*     */     {
/* 227 */       return -1;
/*     */     }
/*     */ 
/* 230 */     Node node = null;
/* 231 */     NodeList nodeList = this.m_nodeMultiRow.getChildNodes();
/*     */ 
/* 233 */     if (nodeList == null)
/*     */     {
/* 235 */       return -1;
/*     */     }
/*     */ 
/* 238 */     int nCount = 0;
/*     */ 
/* 240 */     for (int nIndex = 0; nIndex < nodeList.getLength(); nIndex++)
/*     */     {
/* 242 */       if (nodeList.item(nIndex).getNodeType() != 1)
/*     */         continue;
/* 244 */       nCount++;
/*     */     }
/*     */ 
/* 248 */     return nCount;
/*     */   }
/*     */ 
/*     */   public int getColIndex(String strChildPath)
/*     */   {
/* 254 */     if (this.m_nodeMultiRow == null)
/*     */     {
/* 256 */       return -1;
/*     */     }
/*     */ 
/* 259 */     Node node = null;
/* 260 */     NodeList nodeList = this.m_nodeMultiRow.getChildNodes();
/*     */ 
/* 262 */     boolean bFound = false;
/* 263 */     int nIndex = -1;
/*     */ 
/* 265 */     for (int i = 0; i < nodeList.getLength(); i++)
/*     */     {
/* 267 */       node = nodeList.item(i);
/*     */ 
/* 269 */       if (node.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 274 */       nIndex++;
/*     */ 
/* 276 */       if (!node.getNodeName().equals(strChildPath))
/*     */         continue;
/* 278 */       bFound = true;
/* 279 */       break;
/*     */     }
/*     */ 
/* 283 */     if (!bFound)
/*     */     {
/* 285 */       nIndex = -1;
/*     */     }
/*     */ 
/* 288 */     return nIndex;
/*     */   }
/*     */ 
/*     */   public String getNodeValue(Node node)
/*     */   {
/* 293 */     if (node == null)
/*     */     {
/* 295 */       return "";
/*     */     }
/*     */ 
/* 298 */     if (node.getFirstChild() == null)
/*     */     {
/* 300 */       return "";
/*     */     }
/*     */ 
/* 303 */     return node.getFirstChild().getNodeValue();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.F1Print
 * JD-Core Version:    0.6.0
 */