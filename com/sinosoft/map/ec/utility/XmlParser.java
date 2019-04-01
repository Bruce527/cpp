/*    */ package com.sinosoft.map.ec.utility;
/*    */ 
/*    */ import com.sinosoft.map.common.logs.ErrorsLog;
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import javax.xml.parsers.DocumentBuilder;
/*    */ import javax.xml.parsers.DocumentBuilderFactory;
/*    */ import javax.xml.parsers.ParserConfigurationException;
/*    */ import javax.xml.transform.Transformer;
/*    */ import javax.xml.transform.TransformerConfigurationException;
/*    */ import javax.xml.transform.TransformerException;
/*    */ import javax.xml.transform.TransformerFactory;
/*    */ import javax.xml.transform.dom.DOMSource;
/*    */ import javax.xml.transform.stream.StreamResult;
/*    */ import org.w3c.dom.Document;
/*    */ import org.xml.sax.SAXException;
/*    */ 
/*    */ public class XmlParser
/*    */ {
/*    */   public static Document newDocument()
/*    */     throws ParserConfigurationException
/*    */   {
/* 28 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/* 29 */     DocumentBuilder builder = factory.newDocumentBuilder();
/* 30 */     return builder.newDocument();
/*    */   }
/*    */ 
/*    */   public static Document getDocument(String xmlPath)
/*    */     throws SAXException, IOException, ParserConfigurationException
/*    */   {
/* 36 */     return getDocument(new File(xmlPath));
/*    */   }
/*    */ 
/*    */   public static Document getDocument(File file)
/*    */     throws SAXException, IOException, ParserConfigurationException
/*    */   {
/* 42 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/* 43 */     DocumentBuilder builder = factory.newDocumentBuilder();
/* 44 */     return builder.parse(file);
/*    */   }
/*    */ 
/*    */   public static synchronized void saveDocument(Document doc, String xmlPath)
/*    */     throws TransformerConfigurationException, TransformerException
/*    */   {
/* 51 */     saveDocument(doc, new File(xmlPath));
/*    */   }
/*    */ 
/*    */   public static synchronized void saveDocument(Document doc, File file)
/*    */     throws TransformerConfigurationException, TransformerException
/*    */   {
/* 59 */     TransformerFactory tFactory = TransformerFactory.newInstance();
/* 60 */     Transformer transformer = tFactory.newTransformer();
/* 61 */     DOMSource source = new DOMSource(doc);
/*    */ 
/* 63 */     StreamResult result = new StreamResult();
/*    */     try {
/* 65 */       result.setOutputStream(new FileOutputStream(file.getPath()));
/*    */     }
/*    */     catch (Exception ex)
/*    */     {
/* 69 */       ErrorsLog.log("XmlParser:saveDocument:" + ex.getMessage());
/*    */     }
/*    */ 
/* 72 */     transformer.transform(source, result);
/*    */   }
/*    */ 
/*    */   public static synchronized void write(Document doc, Writer writer)
/*    */     throws TransformerConfigurationException, TransformerException
/*    */   {
/* 79 */     TransformerFactory tFactory = TransformerFactory.newInstance();
/* 80 */     Transformer transformer = tFactory.newTransformer();
/* 81 */     DOMSource source = new DOMSource(doc);
/* 82 */     StreamResult result = new StreamResult(writer);
/* 83 */     transformer.transform(source, result);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.ec.utility.XmlParser
 * JD-Core Version:    0.6.0
 */