/*    */ package com.sinosoft.map.lis.excel;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ class DownloadUtil
/*    */ {
/*    */   private static void writeTo(OutputStream out, InputStream in)
/*    */   {
/*    */     try
/*    */     {
/* 20 */       out.flush();
/*    */     } catch (IOException e) {
/* 22 */       e.printStackTrace();
/*    */     }
/* 24 */     int aRead = 0;
/*    */     try
/*    */     {
/*    */       do
/*    */       {
/* 29 */         out.write(aRead);
/*    */ 
/* 28 */         if ((aRead = in.read()) == -1) break; 
/* 28 */       }while (in != null);
/*    */     }
/*    */     catch (IOException e)
/*    */     {
/* 34 */       System.out.println("\u6587\u4EF6\u4E0B\u8F7D\u5F02\u5E38---" + e.getMessage());
/* 35 */       System.out.println("\u53EF\u80FD\u662F\u56E0\u4E3A\u4E0B\u8F7D\u88AB\u53D6\u6D88");
/*    */     }
/*    */     try
/*    */     {
/* 39 */       out.flush();
/*    */     } catch (IOException e) {
/* 41 */       System.out.println("\u6587\u4EF6\u4E0B\u8F7D\u5F02\u5E38---" + e.getMessage());
/* 42 */       System.out.println("\u53EF\u80FD\u662F\u56E0\u4E3A\u4E0B\u8F7D\u88AB\u53D6\u6D88");
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void writeTo(OutputStream out, String filePath)
/*    */   {
/* 50 */     InputStream in = null;
/*    */     try {
/* 52 */       in = new FileInputStream(filePath);
/* 53 */       if (in != null)
/* 54 */         writeTo(out, in);
/*    */     }
/*    */     catch (FileNotFoundException e) {
/* 57 */       System.out.println("\u6587\u4EF6\u4E0B\u8F7D\u5F02\u5E38---" + e.getMessage());
/* 58 */       System.out.println("\u53EF\u80FD\u662F\u56E0\u4E3A\u4E0B\u8F7D\u88AB\u53D6\u6D88");
/*    */ 
/* 61 */       if (in != null)
/*    */         try {
/* 63 */           in.close();
/*    */         } catch (IOException e) {
/* 65 */           System.out.println("\u6587\u4EF6\u4E0B\u8F7D\u5F02\u5E38---" + e.getMessage());
/* 66 */           System.out.println("\u53EF\u80FD\u662F\u56E0\u4E3A\u4E0B\u8F7D\u88AB\u53D6\u6D88");
/*    */         }
/*    */     }
/*    */     finally
/*    */     {
/* 61 */       if (in != null)
/*    */         try {
/* 63 */           in.close();
/*    */         } catch (IOException e) {
/* 65 */           System.out.println("\u6587\u4EF6\u4E0B\u8F7D\u5F02\u5E38---" + e.getMessage());
/* 66 */           System.out.println("\u53EF\u80FD\u662F\u56E0\u4E3A\u4E0B\u8F7D\u88AB\u53D6\u6D88");
/*    */         }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.excel.DownloadUtil
 * JD-Core Version:    0.6.0
 */