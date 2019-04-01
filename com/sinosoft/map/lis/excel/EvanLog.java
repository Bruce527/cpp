/*    */ package com.sinosoft.map.lis.excel;
/*    */ 
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class EvanLog
/*    */ {
/*  9 */   private static EvanLog logger = new EvanLog();
/*    */ 
/* 11 */   private static String filePath = "e:\\tmp\\log.txt";
/*    */ 
/*    */   public static EvanLog getLoger()
/*    */   {
/* 26 */     return logger;
/*    */   }
/*    */ 
/*    */   public void log(String message) {
/* 30 */     message = "[" + new Date() + "] " + message + "\n";
/*    */     try {
/* 32 */       OutputStream out = new FileOutputStream(filePath, true);
/* 33 */       out.write(message.getBytes());
/* 34 */       out.flush();
/* 35 */       out.close();
/*    */     } catch (IOException e) {
/* 37 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   protected void finalize()
/*    */     throws Throwable
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.excel.EvanLog
 * JD-Core Version:    0.6.0
 */