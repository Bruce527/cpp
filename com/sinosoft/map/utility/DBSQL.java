/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ public class DBSQL
/*     */ {
/*  19 */   private String mTable = null;
/*  20 */   private String mSQL = null;
/*  21 */   public CErrors mErrors = new CErrors();
/*     */ 
/*     */   public String getSQL()
/*     */   {
/*  29 */     System.out.println("mSQL" + this.mSQL);
/*  30 */     return this.mSQL;
/*     */   }
/*     */ 
/*     */   public void setTable(String aTable)
/*     */   {
/*  35 */     this.mTable = aTable;
/*     */   }
/*     */ 
/*     */   public boolean createSQL()
/*     */   {
/*  40 */     String tCont = "";
/*     */ 
/*  42 */     Connection conn = null;
/*  43 */     conn = DBConnPool.getConnection();
/*  44 */     if (conn == null)
/*     */     {
/*  47 */       CError tError = new CError();
/*  48 */       tError.moduleName = "LDCodeBLS";
/*  49 */       tError.functionName = "saveData";
/*  50 */       tError.errorMessage = "\u6570\u636E\u5E93\u8FDE\u63A5\u5931\u8D25!";
/*  51 */       this.mErrors.addOneError(tError);
/*  52 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  58 */       System.out.println("Start \u67E5\u8BE2...");
/*  59 */       Statement stat = conn.createStatement(1003, 
/*  60 */         1007);
/*  61 */       ResultSet rs = stat.executeQuery("select * from " + this.mTable);
/*  62 */       ResultSetMetaData meta = rs.getMetaData();
/*  63 */       String tColName = null;
/*  64 */       String tColType = null;
/*  65 */       String tColNull = "";
/*  66 */       String tPriKey = "";
/*     */ 
/*  68 */       for (int i = 1; i <= meta.getColumnCount(); i++)
/*     */       {
/*  71 */         tColName = meta.getColumnName(i);
/*  72 */         int dataType = meta.getColumnType(i);
/*  73 */         if (dataType == 2)
/*     */         {
/*  75 */           if ((meta.getPrecision(i) == 38) && (meta.getScale(i) == 0))
/*     */           {
/*  77 */             tColType = "INTEGER";
/*     */           }
/*  79 */           else if ((meta.getPrecision(i) == 126) && 
/*  80 */             (meta.getScale(i) == -127))
/*     */           {
/*  82 */             tColType = "FLOAT";
/*     */           }
/*     */           else
/*     */           {
/*  86 */             tColType = meta.getColumnTypeName(i) + "(" + 
/*  87 */               meta.getPrecision(i) + "," + meta.getScale(i) + 
/*  88 */               ")";
/*     */           }
/*     */         }
/*  91 */         else if ((dataType == 93) || (dataType == 91))
/*     */         {
/*  93 */           tColType = meta.getColumnTypeName(i);
/*     */         }
/*     */         else
/*     */         {
/*  97 */           tColType = meta.getColumnTypeName(i) + "(" + 
/*  98 */             meta.getColumnDisplaySize(i) + ")";
/*     */         }
/*     */ 
/* 101 */         if (meta.isNullable(i) == 0)
/*     */         {
/* 103 */           tColNull = "not null";
/*     */         }
/*     */         else
/*     */         {
/* 107 */           tColNull = "";
/*     */         }
/* 109 */         tCont = tCont + " " + tColName + " " + tColType + " " + 
/* 110 */           tColNull + ",";
/*     */       }
/*     */ 
/* 113 */       rs.close();
/* 114 */       stat.close();
/*     */ 
/* 116 */       DatabaseMetaData dbmd = conn.getMetaData();
/* 117 */       ResultSet pkrs = dbmd.getPrimaryKeys(null, null, this.mTable.toUpperCase());
/* 118 */       String tPriCont = null;
/* 119 */       int i = 0;
/* 120 */       while (pkrs.next())
/*     */       {
/* 122 */         i++;
/* 123 */         if (i == 1)
/*     */         {
/* 125 */           tPriKey = " constraint " + pkrs.getObject(6).toString() + 
/* 126 */             " primary key (";
/* 127 */           tPriCont = pkrs.getObject(4).toString();
/*     */         }
/*     */         else
/*     */         {
/* 131 */           tPriCont = tPriCont + ", " + pkrs.getObject(4).toString();
/*     */         }
/*     */       }
/*     */ 
/* 135 */       tPriKey = tPriKey + tPriCont + ")";
/* 136 */       conn.close();
/* 137 */       this.mSQL = ("create table " + this.mTable + " ( " + tCont + tPriKey + " ) ");
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 141 */       System.out.println(this.mTable + "\u8868\u4E0D\u5B58\u5728\uFF01");
/* 142 */       ex.printStackTrace();
/*     */ 
/* 144 */       CError tError = new CError();
/* 145 */       tError.moduleName = "LDCodeBLS";
/* 146 */       tError.functionName = "submitData";
/* 147 */       tError.errorMessage = ex.toString();
/* 148 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 151 */         conn.rollback();
/* 152 */         conn.close();
/*     */       }
/*     */       catch (Exception localException1) {
/*     */       }
/* 156 */       return false;
/*     */     }
/*     */ 
/* 159 */     return true;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.DBSQL
 * JD-Core Version:    0.6.0
 */