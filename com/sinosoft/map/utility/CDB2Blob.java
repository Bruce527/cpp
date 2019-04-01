/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Blob;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import org.jdom.Document;
/*     */ 
/*     */ public class CDB2Blob
/*     */ {
/*  21 */   private StringBuffer mSBql = new StringBuffer(256);
/*     */ 
/*     */   public boolean UpdateBlob(Document pInXmlDoc, String pTabName, String pUpdateField, String pGrpPolNo, Connection pConn)
/*     */   {
/*  32 */     PreparedStatement preparedStatement = null;
/*     */ 
/*  34 */     Statement stmt = null;
/*  35 */     if (pConn == null)
/*     */     {
/*  38 */       System.out.println("CDB2Blob\u6CA1\u6709\u4F20\u5165\u8FDE\u63A5\uFF01");
/*  39 */       return false;
/*     */     }
/*     */     try
/*     */     {
/*  43 */       stmt = pConn.createStatement();
/*  44 */       String szSQL = "SELECT " + pUpdateField + " FROM " + pTabName + 
/*  45 */         " WHERE MainPolNo = '" + pGrpPolNo + 
/*  46 */         "' FOR UPDATE";
/*  47 */       System.out.println("UpdateBlob :" + szSQL);
/*  48 */       preparedStatement = pConn.prepareStatement(szSQL);
/*  49 */       preparedStatement.executeQuery();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  53 */       ex.printStackTrace();
/*  54 */       System.out.print(ex.toString());
/*     */       try
/*     */       {
/*  57 */         if (stmt != null)
/*     */         {
/*  59 */           stmt.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*  65 */       return false;
/*     */     }
/*  67 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean UpdateBlob(InputStream pInStream, String pTabName, String pUpdateField, String pWhereSQL, Connection pConn)
/*     */   {
/*  75 */     Statement stmt = null;
/*  76 */     ResultSet rs = null;
/*  77 */     if (pConn == null)
/*     */     {
/*  80 */       System.out.println("COracleBlob\u6CA1\u6709\u4F20\u5165\u8FDE\u63A5\uFF01");
/*  81 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  86 */       stmt = pConn.createStatement(1003, 
/*  87 */         1008);
/*     */ 
/*  90 */       this.mSBql.append("SELECT ");
/*  91 */       this.mSBql.append(pUpdateField);
/*  92 */       this.mSBql.append(" FROM ");
/*  93 */       this.mSBql.append(pTabName);
/*  94 */       this.mSBql.append(" WHERE 1=1 ");
/*  95 */       this.mSBql.append(pWhereSQL);
/*     */ 
/*  97 */       rs = stmt.executeQuery(this.mSBql.toString());
/*  98 */       if (!rs.next())
/*     */       {
/* 100 */         System.out.println("COracleBlob\u8BE5\u67E5\u8BE2\u6761\u4EF6\u6CA1\u6709\u67E5\u8BE2\u5230\u8BB0\u5F55\uFF01SQL\u4E3A\uFF1A" + 
/* 101 */           this.mSBql.toString());
/* 102 */         rs.close();
/* 103 */         stmt.close();
/* 104 */         return false;
/*     */       }
/* 106 */       rs.close();
/*     */ 
/* 110 */       this.mSBql = new StringBuffer(256);
/*     */ 
/* 112 */       this.mSBql.append("UPDATE ");
/* 113 */       this.mSBql.append(pTabName);
/* 114 */       this.mSBql.append(" Set ");
/* 115 */       this.mSBql.append(pUpdateField);
/* 116 */       this.mSBql.append(" =? WHERE 1=1 ");
/* 117 */       this.mSBql.append(pWhereSQL);
/*     */ 
/* 119 */       PreparedStatement ps = pConn.prepareStatement(this.mSBql.toString());
/*     */ 
/* 121 */       ps.setBinaryStream(1, pInStream, pInStream.available());
/* 122 */       ps.execute();
/*     */ 
/* 124 */       ps.close();
/* 125 */       stmt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 129 */       ex.printStackTrace();
/*     */       try
/*     */       {
/* 132 */         if (rs != null)
/*     */         {
/* 134 */           rs.close();
/*     */         }
/* 136 */         if (stmt != null)
/*     */         {
/* 138 */           stmt.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1) {
/*     */       }
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean DeleteBlobRecord(String pDeleteSQL, Connection pConn)
/*     */   {
/* 152 */     Statement stmt = null;
/* 153 */     if (pConn == null)
/*     */     {
/* 156 */       System.out.println("CDB2Blob\u6CA1\u6709\u4F20\u5165\u8FDE\u63A5\uFF01");
/* 157 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 162 */       stmt = pConn.createStatement();
/* 163 */       String sDeleteSQL = pDeleteSQL.replaceFirst("DELETE", 
/* 164 */         "SELECT MAINPOLNO");
/* 165 */       ResultSet rs = stmt.executeQuery(sDeleteSQL);
/* 166 */       if (rs.next())
/*     */       {
/* 168 */         stmt.executeUpdate(pDeleteSQL);
/*     */       }
/* 170 */       stmt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 174 */       ex.printStackTrace();
/*     */       try
/*     */       {
/* 177 */         if (stmt != null)
/*     */         {
/* 179 */           stmt.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 185 */       return false;
/*     */     }
/* 187 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean InsertBlankBlobRecord(InputStream pis, String pInsertSQL, Connection pConn)
/*     */   {
/* 195 */     Statement stmt = null;
/* 196 */     if (pConn == null)
/*     */     {
/* 199 */       System.out.println("CDB2Blob\u6CA1\u6709\u4F20\u5165\u8FDE\u63A5\uFF01");
/* 200 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 204 */       System.out.println("DB2\u6570\u636E\u5E93Blob\u63D2\u5165\u64CD\u4F5Csql\uFF1A" + pInsertSQL);
/* 205 */       PreparedStatement ps = pConn.prepareStatement(pInsertSQL);
/* 206 */       ps.setBinaryStream(1, pis, pis.available());
/* 207 */       ps.execute();
/* 208 */       ps.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 212 */       ex.printStackTrace();
/*     */       try
/*     */       {
/* 215 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 220 */       return false;
/*     */     }
/* 222 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean SelectBlob(OutputStream pOutStream, String pTabName, String pSelectField, String pWhereSQL, Connection pConn)
/*     */   {
/* 230 */     return false;
/*     */   }
/*     */ 
/*     */   public Blob SelectBlob(String pTabName, String pSelectField, String pWhereSQL, Connection pConn)
/*     */   {
/* 238 */     Statement stmt = null;
/* 239 */     ResultSet rs = null;
/* 240 */     Blob tOutData = null;
/*     */ 
/* 242 */     if (pConn == null)
/*     */     {
/* 245 */       System.out.println("CDB2Blob\u6CA1\u6709\u4F20\u5165\u8FDE\u63A5\uFF01");
/* 246 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 250 */       stmt = pConn.createStatement();
/*     */ 
/* 255 */       this.mSBql.append("SELECT ");
/* 256 */       this.mSBql.append(pSelectField);
/* 257 */       this.mSBql.append(" FROM ");
/* 258 */       this.mSBql.append(pTabName);
/* 259 */       this.mSBql.append(" WHERE 1=1 ");
/* 260 */       this.mSBql.append(pWhereSQL);
/*     */ 
/* 262 */       rs = stmt.executeQuery(this.mSBql.toString());
/* 263 */       if (!rs.next())
/*     */       {
/* 265 */         System.out.println("\u627E\u4E0D\u5230\u6253\u5370\u6570\u636E,SQL\u4E3A\uFF1A" + this.mSBql.toString());
/* 266 */         rs.close();
/* 267 */         stmt.close();
/* 268 */         return null;
/*     */       }
/* 270 */       tOutData = rs.getBlob(1);
/* 271 */       rs.close();
/* 272 */       stmt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 276 */       ex.printStackTrace();
/*     */       try
/*     */       {
/* 279 */         if (rs != null)
/*     */         {
/* 281 */           rs.close();
/*     */         }
/* 283 */         if (stmt != null)
/*     */         {
/* 285 */           stmt.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 291 */       return null;
/*     */     }
/* 293 */     return tOutData;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.CDB2Blob
 * JD-Core Version:    0.6.0
 */