/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Blob;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import oracle.sql.BLOB;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.output.Format;
/*     */ import org.jdom.output.XMLOutputter;
/*     */ 
/*     */ public class COracleBlob
/*     */ {
/*  22 */   private StringBuffer mSBql = new StringBuffer(256);
/*     */ 
/*     */   public boolean UpdateBlob(Document pInXmlDoc, String pTabName, String pUpdateField, String pWhereSQL, Connection pConn)
/*     */   {
/*  35 */     Statement stmt = null;
/*  36 */     ResultSet rs = null;
/*  37 */     if (pConn == null)
/*     */     {
/*  39 */       System.out.println("COracleBlob\u6CA1\u6709\u4F20\u5165\u8FDE\u63A5\uFF01");
/*  40 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  45 */       stmt = pConn.createStatement(1003, 
/*  46 */         1008);
/*     */ 
/*  49 */       this.mSBql.append("SELECT ");
/*  50 */       this.mSBql.append(pUpdateField);
/*  51 */       this.mSBql.append(" FROM ");
/*  52 */       this.mSBql.append(pTabName);
/*  53 */       this.mSBql.append(" WHERE 1=1 ");
/*  54 */       this.mSBql.append(pWhereSQL);
/*  55 */       this.mSBql.append(" FOR UPDATE");
/*     */ 
/*  57 */       rs = stmt.executeQuery(this.mSBql.toString());
/*  58 */       if (!rs.next())
/*     */       {
/*  60 */         System.out.println("COracleBlob\u8BE5\u67E5\u8BE2\u6761\u4EF6\u6CA1\u6709\u67E5\u8BE2\u5230\u8BB0\u5F55\uFF01SQL\u4E3A\uFF1A" + 
/*  61 */           this.mSBql.toString());
/*  62 */         rs.close();
/*  63 */         stmt.close();
/*  64 */         return false;
/*     */       }
/*     */ 
/*  67 */       Blob blob = rs.getBlob(pUpdateField);
/*  68 */       OutputStream os = ((BLOB)blob).getBinaryOutputStream();
/*     */ 
/*  73 */       XMLOutputter outputter = new XMLOutputter();
/*  74 */       Format tFormat = Format.getPrettyFormat();
/*  75 */       tFormat.setEncoding("UTF-8");
/*  76 */       outputter.setFormat(tFormat);
/*     */ 
/*  81 */       outputter.output(pInXmlDoc, os);
/*     */ 
/*  83 */       os.flush();
/*  84 */       os.close();
/*     */ 
/*  86 */       rs.close();
/*  87 */       stmt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  91 */       ex.printStackTrace();
/*     */       try
/*     */       {
/*  94 */         if (rs != null)
/*     */         {
/*  96 */           rs.close();
/*     */         }
/*  98 */         if (stmt != null)
/*     */         {
/* 100 */           stmt.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1) {
/*     */       }
/* 105 */       return false;
/*     */     }
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean UpdateBlob(InputStream pInStream, String pTabName, String pUpdateField, String pWhereSQL, Connection pConn)
/*     */   {
/* 116 */     Statement stmt = null;
/* 117 */     ResultSet rs = null;
/* 118 */     if (pConn == null)
/*     */     {
/* 120 */       System.out.println("COracleBlob\u6CA1\u6709\u4F20\u5165\u8FDE\u63A5\uFF01");
/* 121 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 126 */       stmt = pConn.createStatement(1003, 
/* 127 */         1008);
/*     */ 
/* 130 */       this.mSBql.append("SELECT ");
/* 131 */       this.mSBql.append(pUpdateField);
/* 132 */       this.mSBql.append(" FROM ");
/* 133 */       this.mSBql.append(pTabName);
/* 134 */       this.mSBql.append(" WHERE 1=1 ");
/* 135 */       this.mSBql.append(pWhereSQL);
/* 136 */       this.mSBql.append(" FOR UPDATE");
/*     */ 
/* 138 */       rs = stmt.executeQuery(this.mSBql.toString());
/* 139 */       if (!rs.next())
/*     */       {
/* 141 */         System.out.println("COracleBlob\u8BE5\u67E5\u8BE2\u6761\u4EF6\u6CA1\u6709\u67E5\u8BE2\u5230\u8BB0\u5F55\uFF01SQL\u4E3A\uFF1A" + 
/* 142 */           this.mSBql.toString());
/* 143 */         rs.close();
/* 144 */         stmt.close();
/* 145 */         return false;
/*     */       }
/*     */ 
/* 148 */       Blob blob = rs.getBlob(pUpdateField);
/* 149 */       OutputStream os = ((BLOB)blob).getBinaryOutputStream();
/* 150 */       InputStream ins = pInStream;
/* 151 */       int inData = 0;
/* 152 */       while ((inData = ins.read()) != -1)
/*     */       {
/* 154 */         os.write(inData);
/*     */       }
/*     */ 
/* 157 */       os.flush();
/* 158 */       os.close();
/*     */ 
/* 160 */       rs.close();
/* 161 */       stmt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 165 */       ex.printStackTrace();
/*     */       try
/*     */       {
/* 168 */         if (rs != null)
/*     */         {
/* 170 */           rs.close();
/*     */         }
/* 172 */         if (stmt != null)
/*     */         {
/* 174 */           stmt.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1) {
/*     */       }
/* 179 */       return false;
/*     */     }
/* 181 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean DeleteBlobRecord(String pDeleteSQL, Connection pConn)
/*     */   {
/* 188 */     Statement stmt = null;
/* 189 */     if (pConn == null)
/*     */     {
/* 191 */       System.out.println("COracleBlob\u6CA1\u6709\u4F20\u5165\u8FDE\u63A5\uFF01");
/* 192 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 197 */       stmt = pConn.createStatement(1003, 
/* 198 */         1008);
/* 199 */       String szSQL = pDeleteSQL;
/* 200 */       stmt.executeUpdate(szSQL);
/* 201 */       stmt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 205 */       ex.printStackTrace();
/*     */       try
/*     */       {
/* 208 */         if (stmt != null)
/*     */         {
/* 210 */           stmt.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1) {
/*     */       }
/* 215 */       return false;
/*     */     }
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean InsertBlankBlobRecord(String pInsertSQL, Connection pConn)
/*     */   {
/* 224 */     Statement stmt = null;
/* 225 */     if (pConn == null)
/*     */     {
/* 227 */       System.out.println("COracleBlob\u6CA1\u6709\u4F20\u5165\u8FDE\u63A5\uFF01");
/* 228 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 233 */       stmt = pConn.createStatement(1003, 
/* 234 */         1008);
/* 235 */       String szSQL = pInsertSQL;
/* 236 */       stmt.executeUpdate(szSQL);
/* 237 */       stmt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 241 */       ex.printStackTrace();
/*     */       try
/*     */       {
/* 244 */         if (stmt != null)
/*     */         {
/* 246 */           stmt.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1) {
/*     */       }
/* 251 */       return false;
/*     */     }
/* 253 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean SelectBlob(OutputStream pOutStream, String pTabName, String pSelectField, String pWhereSQL, Connection pConn)
/*     */   {
/* 262 */     return false;
/*     */   }
/*     */ 
/*     */   public Blob SelectBlob(String pTabName, String pSelectField, String pWhereSQL, Connection pConn)
/*     */   {
/* 270 */     Statement stmt = null;
/* 271 */     ResultSet rs = null;
/* 272 */     Blob tOutData = null;
/* 273 */     if (pConn == null)
/*     */     {
/* 275 */       System.out.println("COracleBlob\u6CA1\u6709\u4F20\u5165\u8FDE\u63A5\uFF01");
/* 276 */       return null;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 281 */       stmt = pConn.createStatement();
/*     */ 
/* 285 */       this.mSBql.append("SELECT ");
/* 286 */       this.mSBql.append(pSelectField);
/* 287 */       this.mSBql.append(" FROM ");
/* 288 */       this.mSBql.append(pTabName);
/* 289 */       this.mSBql.append(" WHERE 1=1 ");
/* 290 */       this.mSBql.append(pWhereSQL);
/*     */ 
/* 292 */       rs = stmt.executeQuery(this.mSBql.toString());
/*     */ 
/* 294 */       if (!rs.next())
/*     */       {
/* 296 */         System.out.println("\u627E\u4E0D\u5230\u6253\u5370\u6570\u636E,SQL\u4E3A\uFF1A" + this.mSBql.toString());
/* 297 */         rs.close();
/* 298 */         stmt.close();
/* 299 */         return null;
/*     */       }
/*     */ 
/* 302 */       tOutData = rs.getBlob(pSelectField);
/* 303 */       rs.close();
/* 304 */       stmt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 308 */       ex.printStackTrace();
/*     */       try
/*     */       {
/* 311 */         if (rs != null)
/*     */         {
/* 313 */           rs.close();
/*     */         }
/* 315 */         if (stmt != null)
/*     */         {
/* 317 */           stmt.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1) {
/*     */       }
/* 322 */       return null;
/*     */     }
/* 324 */     return tOutData;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.COracleBlob
 * JD-Core Version:    0.6.0
 */