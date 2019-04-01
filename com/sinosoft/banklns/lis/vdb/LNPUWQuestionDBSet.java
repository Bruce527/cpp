/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPUWQuestionSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPUWQuestionSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPUWQuestionDBSet extends LNPUWQuestionSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPUWQuestionDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPUWQuestion");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPUWQuestionDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPUWQuestion");
/*  36 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  41 */     if (this.db.deleteSQL(this))
/*     */     {
/*  43 */       return true;
/*     */     }
/*     */ 
/*  48 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  49 */     CError tError = new CError();
/*  50 */     tError.moduleName = "LNPUWQuestionDBSet";
/*  51 */     tError.functionName = "deleteSQL";
/*  52 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  53 */     this.mErrors.addOneError(tError);
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  61 */     PreparedStatement pstmt = null;
/*     */ 
/*  63 */     if (!this.mflag) {
/*  64 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  69 */       int tCount = size();
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPUWQuestion WHERE  ContNo = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/*  78 */         pstmt.addBatch();
/*     */       }
/*  80 */       pstmt.executeBatch();
/*  81 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  84 */       ex.printStackTrace();
/*  85 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  86 */       CError tError = new CError();
/*  87 */       tError.moduleName = "LNPUWQuestionDBSet";
/*  88 */       tError.functionName = "delete()";
/*  89 */       tError.errorMessage = ex.toString();
/*  90 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  93 */         pstmt.close(); } catch (Exception e) {
/*  94 */         e.printStackTrace();
/*     */       }
/*  96 */       if (!this.mflag) {
/*     */         try {
/*  98 */           this.con.close(); } catch (Exception e) {
/*  99 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 102 */       return false;
/*     */     }
/*     */ 
/* 105 */     if (!this.mflag) {
/*     */       try {
/* 107 */         this.con.close(); } catch (Exception e) {
/* 108 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 117 */     PreparedStatement pstmt = null;
/*     */ 
/* 119 */     if (!this.mflag) {
/* 120 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 125 */       int tCount = size();
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPUWQuestion SET  ContNo = ? , URL = ? WHERE  ContNo = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/* 134 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getURL());
/*     */         }
/*     */ 
/* 140 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 141 */           pstmt.setString(3, null);
/*     */         else {
/* 143 */           pstmt.setString(3, get(i).getContNo());
/*     */         }
/* 145 */         pstmt.addBatch();
/*     */       }
/* 147 */       pstmt.executeBatch();
/* 148 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 151 */       ex.printStackTrace();
/* 152 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 153 */       CError tError = new CError();
/* 154 */       tError.moduleName = "LNPUWQuestionDBSet";
/* 155 */       tError.functionName = "update()";
/* 156 */       tError.errorMessage = ex.toString();
/* 157 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 160 */         pstmt.close(); } catch (Exception e) {
/* 161 */         e.printStackTrace();
/*     */       }
/* 163 */       if (!this.mflag) {
/*     */         try {
/* 165 */           this.con.close(); } catch (Exception e) {
/* 166 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 169 */       return false;
/*     */     }
/*     */ 
/* 172 */     if (!this.mflag) {
/*     */       try {
/* 174 */         this.con.close(); } catch (Exception e) {
/* 175 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 178 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 184 */     PreparedStatement pstmt = null;
/*     */ 
/* 186 */     if (!this.mflag) {
/* 187 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 192 */       int tCount = size();
/* 193 */       pstmt = this.con.prepareStatement("INSERT INTO LNPUWQuestion VALUES( ? , ?)");
/* 194 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 196 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 197 */           pstmt.setString(1, null);
/*     */         else {
/* 199 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/* 201 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 202 */           pstmt.setString(2, null);
/*     */         else {
/* 204 */           pstmt.setString(2, get(i).getURL());
/*     */         }
/* 206 */         pstmt.addBatch();
/*     */       }
/* 208 */       pstmt.executeBatch();
/* 209 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 212 */       ex.printStackTrace();
/* 213 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 214 */       CError tError = new CError();
/* 215 */       tError.moduleName = "LNPUWQuestionDBSet";
/* 216 */       tError.functionName = "insert()";
/* 217 */       tError.errorMessage = ex.toString();
/* 218 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 221 */         pstmt.close(); } catch (Exception e) {
/* 222 */         e.printStackTrace();
/*     */       }
/* 224 */       if (!this.mflag) {
/*     */         try {
/* 226 */           this.con.close(); } catch (Exception e) {
/* 227 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 230 */       return false;
/*     */     }
/*     */ 
/* 233 */     if (!this.mflag) {
/*     */       try {
/* 235 */         this.con.close(); } catch (Exception e) {
/* 236 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 239 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPUWQuestionDBSet
 * JD-Core Version:    0.6.0
 */