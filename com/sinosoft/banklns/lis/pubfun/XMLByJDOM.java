/*    */ package com.sinosoft.banklns.lis.pubfun;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.File;
/*    */ import java.io.StringReader;
/*    */ import org.jdom.Document;
/*    */ import org.jdom.input.SAXBuilder;
/*    */ import org.jdom.output.Format;
/*    */ import org.jdom.output.XMLOutputter;
/*    */ import org.xml.sax.InputSource;
/*    */ 
/*    */ public class XMLByJDOM
/*    */ {
/*    */   public Document loadXMLFileByJDOM(String tFileName)
/*    */   {
/* 16 */     Document document = null;
/*    */     try {
/* 18 */       SAXBuilder builder = new SAXBuilder();
/* 19 */       document = builder.build(new File(tFileName));
/*    */     } catch (Exception e) {
/* 21 */       e.printStackTrace();
/* 22 */       return null;
/*    */     }
/* 24 */     return document;
/*    */   }
/*    */ 
/*    */   public String transformXMLToString(Document document) {
/*    */     try {
/* 29 */       XMLOutputter xmlout = new XMLOutputter();
/* 30 */       Format tFormat = Format.getPrettyFormat();
/*    */ 
/* 33 */       ByteArrayOutputStream bo = new ByteArrayOutputStream();
/* 34 */       xmlout.output(document, bo);
/* 35 */       String xmlStr = bo.toString();
/* 36 */       return xmlStr;
/*    */     } catch (Exception e) {
/* 38 */       e.printStackTrace();
/* 39 */     }return null;
/*    */   }
/*    */ 
/*    */   public Document stringToXML(String xmlStr)
/*    */   {
/*    */     try {
/* 45 */       StringReader sr = new StringReader(xmlStr);
/* 46 */       InputSource is = new InputSource(sr);
/* 47 */       Document doc = new SAXBuilder().build(is);
/* 48 */       return doc;
/*    */     } catch (Exception e) {
/* 50 */       e.printStackTrace();
/* 51 */     }return null;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.XMLByJDOM
 * JD-Core Version:    0.6.0
 */