/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Hashtable;
/*     */ import java.util.Vector;
/*     */ import org.jdom.Element;
/*     */ 
/*     */ public class XMLDataList extends XMLDataObject
/*     */ {
/*  21 */   private Vector _VCols = new Vector();
/*  22 */   private Hashtable _HCols = new Hashtable();
/*  23 */   private Vector _VData = new Vector();
/*  24 */   private boolean _bAutoCol = true;
/*     */ 
/*     */   public XMLDataList()
/*     */   {
/*  28 */     this._VData.clear();
/*  29 */     setDataObjectID("");
/*     */   }
/*     */ 
/*     */   public XMLDataList(String strDataObjectID)
/*     */   {
/*  34 */     this();
/*  35 */     setDataObjectID(strDataObjectID);
/*     */   }
/*     */ 
/*     */   public boolean addColHead(String strColHead)
/*     */   {
/*  42 */     if (this._VData.size() != 0)
/*     */     {
/*  45 */       this._VData.clear();
/*  46 */       this._HCols.clear();
/*  47 */       this._VCols.clear();
/*     */     }
/*     */ 
/*  50 */     if (this._HCols.containsKey(strColHead))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */ 
/*  56 */     this._HCols.put(strColHead, "");
/*  57 */     this._VCols.add(strColHead);
/*  58 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean buildColHead()
/*     */   {
/*  66 */     this._VData.clear();
/*  67 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean setColValue(String strColName, String strValue)
/*     */   {
/*  74 */     if (!this._HCols.containsKey(strColName))
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */ 
/*  79 */     if ((strValue == null) || (strValue.equals("")))
/*     */     {
/*  81 */       this._HCols.put(strColName, "");
/*     */     }
/*     */     else
/*     */     {
/*  85 */       this._HCols.put(strColName, strValue);
/*     */     }
/*  87 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean setColValue(String strColName, int nValue)
/*     */   {
/*  94 */     if (!this._HCols.containsKey(strColName))
/*     */     {
/*  96 */       return false;
/*     */     }
/*     */ 
/*  99 */     this._HCols.put(strColName, String.valueOf(nValue));
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean setColValue(String strColName, float fValue)
/*     */   {
/* 107 */     if (!this._HCols.containsKey(strColName))
/*     */     {
/* 109 */       return false;
/*     */     }
/*     */ 
/* 112 */     this._HCols.put(strColName, String.valueOf(fValue));
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean setColValue(String strColName, double dValue)
/*     */   {
/* 120 */     if (!this._HCols.containsKey(strColName))
/*     */     {
/* 122 */       return false;
/*     */     }
/*     */ 
/* 125 */     this._HCols.put(strColName, String.valueOf(dValue));
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insertRow(int nFlag)
/*     */   {
/* 133 */     this._VData.add(this._HCols.clone());
/*     */ 
/* 135 */     for (Enumeration e = this._HCols.keys(); e.hasMoreElements(); )
/*     */     {
/* 137 */       this._HCols.put(e.nextElement(), "");
/*     */     }
/*     */ 
/* 140 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean setAutoCol(boolean bAutoCol)
/*     */   {
/* 147 */     this._bAutoCol = bAutoCol;
/* 148 */     return this._bAutoCol;
/*     */   }
/*     */ 
/*     */   public int getDataObjectType()
/*     */   {
/* 153 */     return 1;
/*     */   }
/*     */ 
/*     */   public boolean addDataTo(Element element)
/*     */   {
/* 158 */     Enumeration tEnumeration = null;
/*     */ 
/* 160 */     String str = "";
/* 161 */     String strColName = "";
/* 162 */     int nColNum = 0;
/*     */ 
/* 164 */     Element eleID = new Element(this._ID);
/* 165 */     element.addContent(eleID);
/*     */ 
/* 167 */     Element eleHead = new Element("HEAD");
/* 168 */     eleID.addContent(eleHead);
/*     */ 
/* 170 */     nColNum = 0;
/* 171 */     for (tEnumeration = this._VCols.elements(); tEnumeration.hasMoreElements(); )
/*     */     {
/* 173 */       str = (String)tEnumeration.nextElement();
/* 174 */       strColName = this._bAutoCol ? "COL0" + String.valueOf(nColNum++) : str;
/* 175 */       eleHead.addContent(new Element(strColName).addContent(str));
/*     */     }
/*     */ 
/* 178 */     Hashtable hash = null;
/*     */ 
/* 180 */     for (int nIndex = 0; nIndex < this._VData.size(); nIndex++)
/*     */     {
/* 182 */       Element eleRow = new Element("ROW");
/* 183 */       eleID.addContent(eleRow);
/* 184 */       hash = (Hashtable)this._VData.get(nIndex);
/*     */ 
/* 186 */       nColNum = 0;
/* 187 */       for (tEnumeration = this._VCols.elements(); tEnumeration.hasMoreElements(); )
/*     */       {
/* 189 */         str = (String)tEnumeration.nextElement();
/* 190 */         strColName = this._bAutoCol ? "COL0" + String.valueOf(nColNum++) : 
/* 191 */           str;
/* 192 */         eleRow.addContent(new Element(strColName).addContent(
/* 193 */           (String)hash.get(str)));
/*     */       }
/*     */     }
/* 196 */     return true;
/*     */   }
/*     */ 
/*     */   public static XMLDataList fromSchemaSet(SchemaSet schemaSet)
/*     */   {
/* 204 */     XMLDataList xmlDataList = new XMLDataList();
/*     */ 
/* 206 */     if (schemaSet == null)
/*     */     {
/* 208 */       return null;
/*     */     }
/*     */ 
/* 212 */     if (schemaSet.getClass().getSuperclass().getName().equals(
/* 212 */       "com.sinosoft.map.lis.SchemaSet"))
/*     */     {
/* 214 */       return null;
/*     */     }
/*     */ 
/* 217 */     String strClassName = schemaSet.getClass().getName();
/*     */ 
/* 220 */     strClassName = strClassName.substring(strClassName.lastIndexOf(".") + 1);
/*     */ 
/* 223 */     strClassName = strClassName.substring(0, strClassName.indexOf("Set"));
/*     */ 
/* 225 */     xmlDataList.setDataObjectID(strClassName);
/*     */ 
/* 228 */     strClassName = "com.sinosoft.map.lis.schema." + strClassName + "Schema";
/* 229 */     Field[] fields = null;
/*     */ 
/* 231 */     Vector vFields = new Vector();
/*     */     try
/*     */     {
/* 235 */       fields = Class.forName(strClassName).getDeclaredFields();
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 239 */       return null;
/*     */     }
/*     */ 
/* 243 */     for (int nIndex = 0; nIndex < fields.length; nIndex++)
/*     */     {
/* 245 */       String strFieldName = fields[nIndex].getName();
/*     */ 
/* 247 */       if ((strFieldName.equals("FIELDNUM")) || (strFieldName.equals("PK")) || 
/* 248 */         (strFieldName.equals("mErrors")) || 
/* 249 */         (strFieldName.equals("fDate")))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 255 */       xmlDataList.addColHead(strFieldName);
/* 256 */       vFields.add(fields[nIndex]);
/*     */     }
/*     */ 
/* 261 */     for (int nIndex = 0; nIndex < schemaSet.size(); nIndex++)
/*     */     {
/* 263 */       Schema schema = (Schema)schemaSet.getObj(nIndex + 1);
/*     */ 
/* 265 */       for (int nCols = 0; nCols < vFields.size(); nCols++)
/*     */       {
/* 267 */         String strFieldName = ((Field)vFields.get(nCols)).getName();
/* 268 */         String strFieldType = ((Field)vFields.get(nCols)).getType()
/* 269 */           .getName();
/* 270 */         String strFieldValue = schema.getV(strFieldName);
/*     */ 
/* 272 */         if ((strFieldType.equals("float")) && 
/* 273 */           (!strFieldValue.equals("-100.0")))
/*     */         {
/* 275 */           xmlDataList.setColValue(strFieldName, strFieldValue);
/*     */         }
/* 277 */         else if ((strFieldType.equals("int")) && 
/* 278 */           (!strFieldValue.equals("-100")))
/*     */         {
/* 280 */           xmlDataList.setColValue(strFieldName, strFieldValue);
/*     */         }
/* 282 */         else if ((strFieldType.equals("java.lang.String")) && 
/* 283 */           (!strFieldValue.equals("null")))
/*     */         {
/* 285 */           xmlDataList.setColValue(strFieldName, strFieldValue);
/*     */         }
/* 287 */         else if ((strFieldType.equals("java.util.Date")) && 
/* 288 */           (!strFieldValue.equals("null")))
/*     */         {
/* 290 */           if (strFieldValue.indexOf('-') != -1)
/*     */           {
/* 292 */             strFieldValue = strFieldValue.substring(0, 4) + "\u5E74" + 
/* 293 */               strFieldValue.substring(5, 7) + "\u6708" + 
/* 294 */               strFieldValue.substring(8, 10) + "\u65E5";
/*     */           }
/* 296 */           xmlDataList.setColValue(strFieldName, strFieldValue);
/*     */         }
/*     */         else
/*     */         {
/* 300 */           xmlDataList.setColValue(strFieldName, "");
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 305 */       xmlDataList.insertRow(0);
/*     */     }
/*     */ 
/* 308 */     return xmlDataList;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.XMLDataList
 * JD-Core Version:    0.6.0
 */