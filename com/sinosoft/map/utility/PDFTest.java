/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.pubfun.XMLByJDOM;
/*    */ import java.io.PrintStream;
/*    */ import org.jdom.Document;
/*    */ import org.jdom.JDOMException;
/*    */ import org.jdom.xpath.XPath;
/*    */ import org.w3c.dom.Element;
/*    */ 
/*    */ public class PDFTest
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 17 */     XMLByJDOM tXMLByJDOM = new XMLByJDOM();
/*    */ 
/* 22 */     Document returnDoc = tXMLByJDOM.loadXMLFileByJDOM("D:\\temp\\634160189696156422923.xml");
/*    */     try
/*    */     {
/* 27 */       Element tProductCodeElement = (Element)XPath.selectSingleNode(returnDoc, "//Report/Body/Table/TableRows/TableRow/TableCells/TableCell/Value");
/* 28 */       tProductCodeElement = (Element)XPath.selectSingleNode(returnDoc, "//Report/ReportProperties/Print/PageSettings/PaperSize/Name");
/*    */ 
/* 30 */       System.out.println("\u951F\u65A4\u62F7\u951F\u79F8\u618B\u62F7\u951F\u65A4\u62F7" + tProductCodeElement.getTextContent());
/*    */     }
/*    */     catch (JDOMException e)
/*    */     {
/* 35 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.PDFTest
 * JD-Core Version:    0.6.0
 */