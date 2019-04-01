/*    */ package com.sinosoft.banklns.lnsmodel;
/*    */ 
/*    */ import com.sinosoft.banklns.utility.ExeSQL;
/*    */ import com.sinosoft.banklns.utility.JdbcUrl;
/*    */ import com.sinosoft.banklns.utility.SSRS;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class BankGetIconDSource
/*    */ {
/* 16 */   private static Map<String, String> dSourceMap = new HashMap();
/*    */ 
/*    */   static
/*    */   {
/* 23 */     dSourceMap.clear();
/* 24 */     dSourceMap = initDsource("icon_%");
/*    */   }
/*    */ 
/*    */   private static Map<String, String> initDsource(String sysVar)
/*    */   {
/* 29 */     Map tDSourceMap = new HashMap();
/*    */     try {
/* 31 */       ExeSQL execSQL = new ExeSQL();
/* 32 */       String sql = "select SysVar, SysVarType,SysVarValue from LNPSysVar where SysVar like '" + sysVar + "'";
/* 33 */       SSRS ssrs = execSQL.execSQL(sql);
/* 34 */       for (int i = 1; i <= ssrs.MaxRow; i++) {
/* 35 */         String key = ssrs.GetText(i, 1) + ssrs.GetText(i, 2);
/* 36 */         String val = ssrs.GetText(i, 3);
/*    */ 
/* 38 */         tDSourceMap.put(key, val);
/*    */       }
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/* 44 */     return tDSourceMap;
/*    */   }
/*    */ 
/*    */   public static Connection getConn(Map<String, String> keyList) {
/* 48 */     Connection conn = null;
/* 49 */     if (keyList != null) {
/*    */       try {
/* 51 */         JdbcUrl jdbcUrl = new JdbcUrl();
/* 52 */         jdbcUrl.setDBType((String)dSourceMap.get(keyList.get("dbtype")));
/* 53 */         jdbcUrl.setDBName((String)dSourceMap.get(keyList.get("dbname")));
/* 54 */         jdbcUrl.setPort((String)dSourceMap.get(keyList.get("dbport")));
/* 55 */         jdbcUrl.setUser((String)dSourceMap.get(keyList.get("dbuser")));
/* 56 */         jdbcUrl.setPassWord((String)dSourceMap.get(keyList.get("dbpwd")));
/* 57 */         jdbcUrl.setIP((String)dSourceMap.get(keyList.get("dbip")));
/* 58 */         Class.forName((String)dSourceMap.get(keyList.get("dbdriver")));
/* 59 */         conn = DriverManager.getConnection(jdbcUrl.getJdbcUrl(), jdbcUrl.getUserName(), jdbcUrl.getPassWord());
/*    */       }
/*    */       catch (Exception e)
/*    */       {
/*    */         try {
/* 64 */           if ((conn != null) && (!conn.isClosed()))
/* 65 */             conn.close();
/*    */         }
/*    */         catch (SQLException ex) {
/* 68 */           ex.printStackTrace();
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 73 */     return conn;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BankGetIconDSource
 * JD-Core Version:    0.6.0
 */