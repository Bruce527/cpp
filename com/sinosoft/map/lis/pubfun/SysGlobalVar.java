/*    */ package com.sinosoft.map.lis.pubfun;
/*    */ 
/*    */ import com.sinosoft.map.utility.ExeSQL;
/*    */ import java.io.PrintStream;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class SysGlobalVar
/*    */ {
/* 10 */   private static SysGlobalVar instance = null;
/* 11 */   private String currentDate = null;
/*    */ 
/*    */   private SysGlobalVar()
/*    */   {
/* 15 */     this.currentDate = getInitCurrentDate();
/*    */   }
/*    */ 
/*    */   public static synchronized SysGlobalVar getInstance()
/*    */   {
/* 20 */     if (instance == null)
/*    */     {
/* 22 */       System.out.println("...... instance is null ......");
/* 23 */       instance = new SysGlobalVar();
/*    */     }
/*    */ 
/* 26 */     return instance;
/*    */   }
/*    */ 
/*    */   private String getInitCurrentDate()
/*    */   {
/* 32 */     ExeSQL tExeSQL = new ExeSQL();
/* 33 */     String setupCurrentDate = tExeSQL.getOneValue("select sysvarvalue from ldsysvar where sysvar='changepubfundate'");
/* 34 */     System.out.println("...... init global var currentdate=" + setupCurrentDate + " ......");
/*    */ 
/* 38 */     String tString = "";
/* 39 */     if (setupCurrentDate.equals(""))
/*    */     {
/* 41 */       return tString;
/*    */     }
/*    */     try
/*    */     {
/* 45 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 46 */       Date str = sdf.parse(setupCurrentDate);
/* 47 */       tString = sdf.format(str);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 51 */       e.printStackTrace();
/*    */     }
/*    */ 
/* 56 */     return tString;
/*    */   }
/*    */ 
/*    */   public String getSetupCurrentDate()
/*    */   {
/* 61 */     return this.currentDate;
/*    */   }
/*    */ 
/*    */   public void clearObject()
/*    */   {
/* 66 */     if (instance != null)
/*    */     {
/* 68 */       instance = null;
/* 69 */       System.out.println("...... clear SysGlobalVar ......");
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.SysGlobalVar
 * JD-Core Version:    0.6.0
 */