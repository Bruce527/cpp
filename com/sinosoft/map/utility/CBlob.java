/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Blob;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ public class CBlob
/*     */ {
/*     */   public static boolean BlobInsert(InputStream pIns, String[] pStr, Connection pConn)
/*     */   {
/*  23 */     StringBuffer mSBql = new StringBuffer(256);
/*     */ 
/*  26 */     if ("ORACLE".compareTo("DB2") == 0)
/*     */     {
/*  32 */       mSBql.append(pStr[0].substring(0, pStr[0].indexOf("empty_blob()")));
/*  33 */       mSBql.append("?");
/*  34 */       mSBql.append(pStr[0].substring(pStr[0].indexOf("empty_blob()") + 12, pStr[0].length()));
/*     */ 
/*  37 */       CDB2Blob tCDB2Blob = new CDB2Blob();
/*  38 */       if (!tCDB2Blob.InsertBlankBlobRecord(pIns, mSBql.toString(), pConn))
/*     */       {
/*  41 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  47 */       COracleBlob tCOracleBlob = new COracleBlob();
/*  48 */       if (!tCOracleBlob.InsertBlankBlobRecord(pStr[0], pConn))
/*     */       {
/*  51 */         return false;
/*     */       }
/*  53 */       if (!tCOracleBlob.UpdateBlob(pIns, pStr[1], pStr[2], pStr[3], pConn))
/*     */       {
/*  56 */         return false;
/*     */       }
/*     */     }
/*     */ 
/*  60 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean BlobUpdate(InputStream pIns, String[] pStr, Connection pConn)
/*     */   {
/*  66 */     if ("ORACLE".compareTo("DB2") == 0)
/*     */     {
/*  69 */       CDB2Blob tCDB2Blob = new CDB2Blob();
/*  70 */       if (!tCDB2Blob.UpdateBlob(pIns, pStr[1], pStr[2], pStr[3], pConn))
/*     */       {
/*  73 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  79 */       COracleBlob tCOracleBlob = new COracleBlob();
/*  80 */       if (!tCOracleBlob.UpdateBlob(pIns, pStr[1], pStr[2], pStr[3], pConn))
/*     */       {
/*  83 */         return false;
/*     */       }
/*     */     }
/*  86 */     return true;
/*     */   }
/*     */ 
/*     */   public static Blob SelectBlob(String cTabName, String cSelectField, String cWhereSQL, Connection cConn)
/*     */   {
/*  93 */     StringBuffer mSBql = new StringBuffer(256);
/*     */ 
/*  95 */     Statement tStatement = null;
/*  96 */     ResultSet tResultSet = null;
/*  97 */     Blob tBlob = null;
/*     */ 
/*  99 */     if (cConn == null)
/*     */     {
/* 102 */       System.out.println("CBlob\u6CA1\u6709\u4F20\u5165\u8FDE\u63A5\uFF01");
/* 103 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 107 */       tStatement = cConn.createStatement();
/*     */ 
/* 111 */       mSBql.append("SELECT ");
/* 112 */       mSBql.append(cSelectField);
/* 113 */       mSBql.append(" FROM ");
/* 114 */       mSBql.append(cTabName);
/* 115 */       mSBql.append(" WHERE 1=1 ");
/* 116 */       mSBql.append(cWhereSQL);
/*     */ 
/* 118 */       tResultSet = tStatement.executeQuery(mSBql.toString());
/* 119 */       if (!tResultSet.next())
/*     */       {
/* 121 */         System.out.println("\u627E\u4E0D\u5230\u6253\u5370\u6570\u636E,SQL\u4E3A\uFF1A" + mSBql.toString());
/* 122 */         tResultSet.close();
/* 123 */         tStatement.close();
/* 124 */         return null;
/*     */       }
/*     */ 
/* 127 */       tBlob = tResultSet.getBlob(1);
/* 128 */       tResultSet.close();
/* 129 */       tStatement.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 134 */       ex.printStackTrace();
/*     */       try
/*     */       {
/* 138 */         if (tResultSet != null)
/*     */         {
/* 140 */           tResultSet.close();
/*     */         }
/* 142 */         if (tStatement != null)
/*     */         {
/* 144 */           tStatement.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 150 */       return null;
/*     */     }
/* 152 */     return tBlob;
/*     */   }
/*     */ 
/*     */   public static void BlobDelete()
/*     */   {
/* 158 */     "ORACLE".compareTo("DB2");
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.CBlob
 * JD-Core Version:    0.6.0
 */