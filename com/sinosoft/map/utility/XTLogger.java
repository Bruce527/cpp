/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ import org.apache.log4j.Logger;
/*    */ import org.apache.log4j.xml.DOMConfigurator;
/*    */ 
/*    */ public class XTLogger
/*    */ {
/*    */   static
/*    */   {
/* 20 */     DOMConfigurator.configure(XTLogger.class.getResource(
/* 21 */       "../../../AutoPayLog4j.xml"));
/*    */   }
/*    */ 
/*    */   public static Logger getLogger(String className)
/*    */   {
/* 32 */     return Logger.getLogger(className);
/*    */   }
/*    */ 
/*    */   public static Logger getLogger(Class className)
/*    */   {
/* 39 */     return Logger.getLogger(className);
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 45 */     XTLogger XTLogger1 = new XTLogger();
/* 46 */     Logger log = getLogger(XTLogger.class);
/* 47 */     log.info(".......");
/* 48 */     log.info(".......");
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.XTLogger
 * JD-Core Version:    0.6.0
 */