/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.apache.xpath.XPathAPI;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class XMLPathTool
/*     */ {
/*     */   private Document sourceDom;
/*     */   private String fileName;
/*     */ 
/*     */   public XMLPathTool(String fileName)
/*     */   {
/*  28 */     this.fileName = fileName;
/*     */     try
/*     */     {
/*  31 */       if (this.sourceDom == null)
/*     */       {
/*  33 */         this.sourceDom = getDocument(fileName);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  38 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public XMLPathTool(InputStream in)
/*     */   {
/*  46 */     this.fileName = "";
/*     */     try
/*     */     {
/*  49 */       DocumentBuilderFactory dfactory = 
/*  50 */         DocumentBuilderFactory.newInstance();
/*  51 */       dfactory.setNamespaceAware(true);
/*  52 */       this.sourceDom = dfactory.newDocumentBuilder().parse(new InputSource(in));
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  57 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private static Document getDocument(String fileName)
/*     */     throws ParserConfigurationException, SAXException, IOException
/*     */   {
/*  65 */     InputSource in = new InputSource(new FileInputStream(fileName));
/*  66 */     DocumentBuilderFactory dfactory = 
/*  67 */       DocumentBuilderFactory.newInstance();
/*  68 */     dfactory.setNamespaceAware(true);
/*  69 */     Document doc = dfactory.newDocumentBuilder().parse(in);
/*     */ 
/*  71 */     return doc;
/*     */   }
/*     */ 
/*     */   public Node parseX(String xpathString)
/*     */   {
/*     */     try
/*     */     {
/*  78 */       if (this.sourceDom == null)
/*     */       {
/*  80 */         this.sourceDom = getDocument(this.fileName);
/*     */       }
/*     */ 
/*  83 */       return XPathAPI.selectSingleNode(this.sourceDom.getDocumentElement(), 
/*  84 */         xpathString);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  89 */       ex.printStackTrace();
/*  90 */     }return null;
/*     */   }
/*     */ 
/*     */   public NodeList parseN(String xpathString)
/*     */   {
/*     */     try
/*     */     {
/* 100 */       if (this.sourceDom == null)
/*     */       {
/* 102 */         this.sourceDom = getDocument(this.fileName);
/*     */       }
/*     */ 
/* 105 */       return XPathAPI.selectNodeList(this.sourceDom.getDocumentElement(), 
/* 106 */         xpathString);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 111 */       ex.printStackTrace();
/* 112 */     }return null;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 118 */     XMLPathTool xmlPathTool = new XMLPathTool("2.xml");
/*     */ 
/* 120 */     Node node = xmlPathTool.parseX("/DATASET/CONTROL/TEMPLATE");
/*     */ 
/* 122 */     System.out.println(node.getFirstChild().getNodeValue());
/*     */ 
/* 124 */     NodeList nodeList = xmlPathTool.parseN("/DATASET/TABLE1/ROW/COL1");
/*     */ 
/* 126 */     String[] nVal = null;
/* 127 */     if (nodeList == null)
/*     */     {
/* 129 */       nVal = new String[0];
/*     */     }
/*     */     else
/*     */     {
/* 133 */       nVal = new String[nodeList.getLength()];
/*     */     }
/*     */ 
/* 136 */     for (int i = 0; i < nVal.length; i++)
/*     */     {
/* 138 */       nVal[i] = nodeList.item(i).getFirstChild().getNodeValue();
/*     */     }
/*     */ 
/* 141 */     for (int i = 0; i < nVal.length; i++)
/*     */     {
/* 143 */       System.out.println(nVal[i]);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.XMLPathTool
 * JD-Core Version:    0.6.0
 */