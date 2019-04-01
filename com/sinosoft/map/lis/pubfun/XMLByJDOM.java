/*    */ package com.sinosoft.map.lis.pubfun;
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
/* 17 */     Document document = null;
/*    */     try {
/* 19 */       SAXBuilder builder = new SAXBuilder();
/* 20 */       document = builder.build(new File(tFileName));
/*    */     } catch (Exception e) {
/* 22 */       e.printStackTrace();
/* 23 */       return null;
/*    */     }
/* 25 */     return document;
/*    */   }
/*    */ 
/*    */   public String transformXMLToString(Document document)
/*    */   {
/*    */     try {
/* 31 */       XMLOutputter xmlout = new XMLOutputter();
/* 32 */       Format tFormat = Format.getPrettyFormat();
/* 33 */       tFormat.setEncoding("GBK");
/* 34 */       xmlout.setFormat(tFormat);
/* 35 */       ByteArrayOutputStream bo = new ByteArrayOutputStream();
/* 36 */       xmlout.output(document, bo);
/* 37 */       String xmlStr = bo.toString();
/* 38 */       return xmlStr;
/*    */     } catch (Exception e) {
/* 40 */       e.printStackTrace();
/* 41 */     }return null;
/*    */   }
/*    */ 
/*    */   public Document stringToXML(String xmlStr)
/*    */   {
/*    */     try
/*    */     {
/* 48 */       StringReader sr = new StringReader(xmlStr);
/* 49 */       InputSource is = new InputSource(sr);
/* 50 */       Document doc = new SAXBuilder().build(is);
/* 51 */       return doc;
/*    */     } catch (Exception e) {
/* 53 */       e.printStackTrace();
/* 54 */     }return null;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.XMLByJDOM
 * JD-Core Version:    0.6.0
 */