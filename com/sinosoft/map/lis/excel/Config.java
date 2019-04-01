/*    */ package com.sinosoft.map.lis.excel;
/*    */ 
/*    */ import com.sinosoft.map.utility.ExeSQL;
/*    */ import com.sinosoft.map.utility.SSRS;
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ class Config
/*    */ {
/*    */   public static String getTempletPath()
/*    */   {
/* 11 */     String tmp = get("templetPath");
/* 12 */     if (tmp == null) {
/* 13 */       System.out.println("\u8DEF\u5F84\u914D\u7F6E\u5728\u6587\u4EF6\u4E2D");
/* 14 */       tmp = Config2.getTempletPath();
/*    */     }
/*    */ 
/* 17 */     return tmp.replace('/', File.separatorChar);
/*    */   }
/*    */ 
/*    */   public static String getWorkPath()
/*    */   {
/* 22 */     String tmp = get("reportPath");
/* 23 */     if (tmp == null) {
/* 24 */       System.out.println("\u8DEF\u5F84\u914D\u7F6E\u5728\u6587\u4EF6\u4E2D");
/* 25 */       tmp = Config2.getWorkPath();
/*    */     }
/*    */ 
/* 34 */     return tmp.replace('/', File.separatorChar);
/*    */   }
/*    */ 
/*    */   public static String get(String sysvar)
/*    */   {
/* 40 */     String valuestr = "";
/* 41 */     ExeSQL aExeSQL = new ExeSQL();
/* 42 */     SSRS aSSRS = new SSRS();
/* 43 */     String strSQL = "select varvalue from msysvar where vartype = '" + 
/* 44 */       sysvar + "'";
/* 45 */     aSSRS = aExeSQL.execSQL(strSQL);
/* 46 */     if ((aSSRS.MaxRow > 0) && (!aSSRS.GetText(1, 1).equals(""))) {
/* 47 */       System.out.println("\u8DEF\u5F84\u914D\u7F6E\u5728\u6570\u636E\u5E93\u4E2D");
/* 48 */       valuestr = aSSRS.GetText(1, 1);
/* 49 */       return valuestr;
/*    */     }
/* 51 */     return null;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 59 */     String tmp = "e:/tmp/org/com";
/* 60 */     String tmp2 = tmp.replace('/', File.separatorChar);
/* 61 */     System.out.println(tmp);
/* 62 */     System.out.println(tmp2);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.excel.Config
 * JD-Core Version:    0.6.0
 */