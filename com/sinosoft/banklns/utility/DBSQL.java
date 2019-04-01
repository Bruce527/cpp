/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ public class DBSQL
/*     */ {
/*   7 */   private String mTable = null;
/*     */ 
/*   9 */   public CErrors mErrors = new CErrors();
/*     */ 
/*     */   public void setTable(String aTable)
/*     */   {
/*  16 */     this.mTable = aTable;
/*     */   }
/*     */ 
/*     */   public boolean dealData(String[] aSQL, String aSQLTYPE)
/*     */   {
/*  21 */     String tCrtSQL = null;
/*  22 */     String tSelSQL = null;
/*  23 */     Connection conn = null;
/*  24 */     Statement stmt = null;
/*     */     try
/*     */     {
/*  27 */       conn = DBConnPool.getConnection();
/*     */       CError tError;
/*  28 */       if (conn == null)
/*     */       {
/*  31 */         tError = new CError();
/*  32 */         tError.moduleName = "DBSQL";
/*  33 */         tError.functionName = "isExist";
/*  34 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83D8\u951F\u7D63\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  35 */         this.mErrors.addOneError(tError);
/*  36 */         return false;
/*     */       }
/*  38 */       stmt = conn.createStatement();
/*     */ 
/*  40 */       if (!isExist())
/*     */       {
/*  43 */         tCrtSQL = transferSQL(aSQL[0]);
/*     */ 
/*  46 */         tError = stmt.executeUpdate(StrTool.GBKToUnicode(tCrtSQL));
/*     */       }
/*     */ 
/*  50 */       if (aSQLTYPE.trim().equals("00"))
/*     */       {
/*  52 */         tSelSQL = "delete" + aSQL[1].substring(aSQL[1].lastIndexOf("*") + 1);
/*  53 */         tError = stmt.executeUpdate(StrTool.GBKToUnicode(tSelSQL));
/*     */       }
/*  55 */       stmt.close();
/*  56 */       conn.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  60 */       e.printStackTrace();
/*     */ 
/*  62 */       CError tError = new CError();
/*  63 */       tError.moduleName = "ExeSQL";
/*  64 */       tError.functionName = "execUpdateSQL";
/*  65 */       tError.errorMessage = e.toString();
/*  66 */       this.mErrors.addOneError(tError);
/*  67 */       return false;
/*     */     }
/*  69 */     return true;
/*     */   }
/*     */ 
/*     */   private String transferSQL(String aSQL)
/*     */   {
/*  76 */     String tSQL = aSQL.toUpperCase();
/*  77 */     JdbcUrl ju = new JdbcUrl();
/*  78 */     String DBType = ju.getDBType();
/*  79 */     if (DBType.trim().equals("MYSQL"))
/*     */     {
/*  81 */       tSQL = StrTool.replace(tSQL, "VARCHAR2", "VARCHAR");
/*  82 */       tSQL = StrTool.replace(tSQL, "NUMBER", "NUMERIC");
/*  83 */       tSQL = StrTool.replace(tSQL, "INTEGER", "INT");
/*  84 */       tSQL = StrTool.replace(tSQL, "BOOLEAN", "TINGINT(1)");
/*     */     }
/*  86 */     return tSQL;
/*     */   }
/*     */ 
/*     */   private boolean isExist()
/*     */   {
/*  91 */     boolean flag = false;
/*  92 */     Connection conn = null;
/*  93 */     conn = DBConnPool.getConnection();
/*  94 */     if (conn == null)
/*     */     {
/*  97 */       CError tError = new CError();
/*  98 */       tError.moduleName = "DBSQL";
/*  99 */       tError.functionName = "isExist";
/* 100 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83D8\u951F\u7D63\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/* 101 */       this.mErrors.addOneError(tError);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 107 */       DatabaseMetaData dbmd = conn.getMetaData();
/* 108 */       ResultSet mrs = dbmd.getTables(null, null, this.mTable, new String[] { "TABLE" });
/* 109 */       while (mrs.next())
/*     */       {
/* 111 */         flag = true;
/*     */       }
/* 113 */       conn.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 118 */       CError tError = new CError();
/* 119 */       tError.moduleName = "DBSQL";
/* 120 */       tError.functionName = "isExist";
/* 121 */       tError.errorMessage = ex.toString();
/* 122 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 124 */         conn.rollback();
/* 125 */         conn.close();
/*     */       }
/*     */       catch (Exception localException1) {
/*     */       }
/*     */     }
/* 130 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean createSQL()
/*     */   {
/* 135 */     String tCont = "";
/*     */ 
/* 137 */     Connection conn = null;
/* 138 */     conn = DBConnPool.getConnection();
/* 139 */     if (conn == null)
/*     */     {
/* 142 */       CError tError = new CError();
/* 143 */       tError.moduleName = "LDCodeBLS";
/* 144 */       tError.functionName = "saveData";
/* 145 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83D8\u951F\u7D63\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/* 146 */       this.mErrors.addOneError(tError);
/* 147 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 152 */       Statement stat = conn.createStatement(1003, 1007);
/* 153 */       ResultSet rs = stat.executeQuery("select * from " + this.mTable);
/* 154 */       ResultSetMetaData meta = rs.getMetaData();
/* 155 */       String tColName = null;
/* 156 */       String tColType = null;
/* 157 */       String tColNull = "";
/* 158 */       String tPriKey = "";
/*     */ 
/* 160 */       for (int i = 1; i <= meta.getColumnCount(); i++)
/*     */       {
/* 162 */         tColName = meta.getColumnName(i);
/* 163 */         int dataType = meta.getColumnType(i);
/* 164 */         if (dataType == 2)
/*     */         {
/* 166 */           if ((meta.getPrecision(i) == 38) && (meta.getScale(i) == 0))
/*     */           {
/* 168 */             tColType = "INTEGER";
/*     */           }
/* 170 */           else if ((meta.getPrecision(i) == 126) && (meta.getScale(i) == -127))
/*     */           {
/* 172 */             tColType = "FLOAT";
/*     */           }
/*     */           else
/*     */           {
/* 176 */             tColType = meta.getColumnTypeName(i) + "(" + meta.getPrecision(i) + "," + meta.getScale(i) + ")";
/*     */           }
/*     */         }
/* 179 */         else if ((dataType == 93) || (dataType == 91))
/*     */         {
/* 181 */           tColType = meta.getColumnTypeName(i);
/*     */         }
/*     */         else
/*     */         {
/* 185 */           tColType = meta.getColumnTypeName(i) + "(" + meta.getColumnDisplaySize(i) + ")";
/*     */         }
/*     */ 
/* 188 */         if (meta.isNullable(i) == 0)
/*     */         {
/* 190 */           tColNull = "not null";
/*     */         }
/*     */         else
/*     */         {
/* 194 */           tColNull = "";
/*     */         }
/* 196 */         tCont = tCont + " " + tColName + " " + tColType + " " + tColNull + ",";
/*     */       }
/*     */ 
/* 199 */       rs.close();
/* 200 */       stat.close();
/* 201 */       DatabaseMetaData dbmd = conn.getMetaData();
/* 202 */       ResultSet pkrs = dbmd.getPrimaryKeys(null, null, this.mTable.toUpperCase());
/* 203 */       String tPriCont = null;
/* 204 */       int i = 0;
/* 205 */       while (pkrs.next()) {
/* 206 */         i++;
/* 207 */         if (i == 1)
/*     */         {
/* 209 */           tPriKey = " constraint " + pkrs.getObject(6).toString() + " primary key (";
/* 210 */           tPriCont = pkrs.getObject(4).toString();
/*     */         }
/*     */         else
/*     */         {
/* 214 */           tPriCont = tPriCont + ", " + pkrs.getObject(4).toString();
/*     */         }
/*     */       }
/*     */ 
/* 218 */       tPriKey = tPriKey + tPriCont + ")";
/* 219 */       conn.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 225 */       CError tError = new CError();
/* 226 */       tError.moduleName = "LDCodeBLS";
/* 227 */       tError.functionName = "submitData";
/* 228 */       tError.errorMessage = ex.toString();
/* 229 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 231 */         conn.rollback();
/* 232 */         conn.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 235 */       return false;
/*     */     }
/*     */ 
/* 238 */     return true;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 242 */     DBSQL DBSQL1 = new DBSQL();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.DBSQL
 * JD-Core Version:    0.6.0
 */