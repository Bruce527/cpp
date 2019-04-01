/*    */ package com.sinosoft.banklns.lnsmodel.util;
/*    */ 
/*    */ import com.sinosoft.banklns.utility.DBConnPool;
/*    */ import com.sinosoft.banklns.utility.ExeSQL;
/*    */ import com.sinosoft.banklns.utility.SSRS;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ public class EAIPropertiesFromDB
/*    */ {
/* 16 */   public static String XMLSavePath = null;
/*    */ 
/* 19 */   public static String ESBEnvelope_ns = null;
/*    */ 
/* 22 */   public static String ProcessMessage_ns = null;
/*    */ 
/* 25 */   public static String Default_ns = null;
/*    */ 
/* 28 */   public static String SoapAddress = null;
/*    */ 
/* 31 */   public static String SoapAction = null;
/*    */ 
/*    */   static
/*    */   {
/* 35 */     Connection conn = null;
/* 36 */     ExeSQL tExeSQL = null;
/* 37 */     SSRS tSSRS = null;
/* 38 */     String sql = null;
/*    */     try
/*    */     {
/* 41 */       conn = DBConnPool.getConnection();
/* 42 */       tExeSQL = new ExeSQL(conn);
/*    */ 
/* 45 */       sql = "select sysvarvalue from lnpsysvar where sysvar='tranfolder'";
/* 46 */       tSSRS = tExeSQL.execSQL(sql);
/* 47 */       XMLSavePath = tSSRS.GetText(1, 1);
/*    */ 
/* 50 */       sql = "select sysvarvalue from lnpsysvar where sysvar='ESBEnvelope_ns'";
/* 51 */       tSSRS = tExeSQL.execSQL(sql);
/* 52 */       ESBEnvelope_ns = tSSRS.GetText(1, 1);
/*    */ 
/* 55 */       sql = "select sysvarvalue from lnpsysvar where sysvar='ProcessMessage_ns'";
/* 56 */       tSSRS = tExeSQL.execSQL(sql);
/* 57 */       ProcessMessage_ns = tSSRS.GetText(1, 1);
/*    */ 
/* 60 */       sql = "select sysvarvalue from lnpsysvar where sysvar='Default_ns'";
/* 61 */       tSSRS = tExeSQL.execSQL(sql);
/* 62 */       Default_ns = tSSRS.GetText(1, 1);
/*    */ 
/* 65 */       sql = "select sysvarvalue from lnpsysvar where sysvar='SoapAddress'";
/* 66 */       tSSRS = tExeSQL.execSQL(sql);
/* 67 */       SoapAddress = tSSRS.GetText(1, 1);
/* 68 */       SoapAddress = "http://eai-a-sit.metlifechina.local/esbwebentry/ESBWebEntry.asmx";
/*    */ 
/* 71 */       System.out.println(SoapAddress);
/* 72 */       sql = "select sysvarvalue from lnpsysvar where sysvar='SoapAction'";
/* 73 */       tSSRS = tExeSQL.execSQL(sql);
/* 74 */       SoapAction = tSSRS.GetText(1, 1);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 78 */       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``EAIPropertiesFromDB erro:" + e.getLocalizedMessage());
/*    */       try
/*    */       {
/* 81 */         if (!conn.isClosed())
/* 82 */           conn.close();
/*    */       }
/*    */       catch (SQLException e) {
/* 85 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/*    */       try
/*    */       {
/* 81 */         if (!conn.isClosed())
/* 82 */           conn.close();
/*    */       }
/*    */       catch (SQLException e) {
/* 85 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.util.EAIPropertiesFromDB
 * JD-Core Version:    0.6.0
 */