/*    */ package com.sinosoft.map.lis.excel;
/*    */ 
/*    */ import com.sinosoft.map.utility.ExeSQL;
/*    */ import com.sinosoft.map.utility.SSRS;
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ class SingletonConfig
/*    */ {
/*    */   private SingletonConfig config;
/*    */   private String templetPath;
/*    */   private String workPath;
/*    */ 
/*    */   private SingletonConfig()
/*    */   {
/* 19 */     this.templetPath = getTempletPath();
/*    */   }
/*    */ 
/*    */   public static String getTempletPath() {
/* 23 */     String tmp = get("templetPath");
/* 24 */     if (tmp == null) {
/* 25 */       System.out.println("\u8DEF\u5F84\u914D\u7F6E\u5728\u6587\u4EF6\u4E2D");
/* 26 */       tmp = Config2.getTempletPath();
/*    */     }
/*    */ 
/* 29 */     return tmp.replace('/', File.separatorChar);
/*    */   }
/*    */ 
/*    */   public static String getWorkPath()
/*    */   {
/* 36 */     String tmp = get("reportPath");
/* 37 */     if (tmp == null) {
/* 38 */       System.out.println("\u8DEF\u5F84\u914D\u7F6E\u5728\u6587\u4EF6\u4E2D");
/* 39 */       tmp = Config2.getWorkPath();
/*    */     }
/*    */ 
/* 48 */     return tmp.replace('/', File.separatorChar);
/*    */   }
/*    */ 
/*    */   public static String get(String sysvar)
/*    */   {
/* 54 */     String valuestr = "";
/* 55 */     ExeSQL aExeSQL = new ExeSQL();
/* 56 */     SSRS aSSRS = new SSRS();
/* 57 */     String strSQL = "select sysvarvalue from ldsysvar where sysvar = '" + 
/* 58 */       sysvar + "hahahaha'";
/* 59 */     aSSRS = aExeSQL.execSQL(strSQL);
/* 60 */     if ((aSSRS.MaxRow > 0) && (!aSSRS.GetText(1, 1).equals(""))) {
/* 61 */       System.out.println("\u8DEF\u5F84\u914D\u7F6E\u5728\u6570\u636E\u5E93\u4E2D");
/* 62 */       valuestr = aSSRS.GetText(1, 1);
/* 63 */       return valuestr;
/*    */     }
/* 65 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.excel.SingletonConfig
 * JD-Core Version:    0.6.0
 */