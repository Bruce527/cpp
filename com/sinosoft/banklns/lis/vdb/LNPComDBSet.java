/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.vschema.LNPComSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPComDBSet extends LNPComSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPComDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPCom");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPComDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPCom");
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
/*  50 */     tError.moduleName = "LNPComDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCom WHERE ");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         pstmt.addBatch();
/*     */       }
/*  75 */       pstmt.executeBatch();
/*  76 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  79 */       ex.printStackTrace();
/*  80 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  81 */       CError tError = new CError();
/*  82 */       tError.moduleName = "LNPComDBSet";
/*  83 */       tError.functionName = "delete()";
/*  84 */       tError.errorMessage = ex.toString();
/*  85 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  88 */         pstmt.close(); } catch (Exception e) {
/*  89 */         e.printStackTrace();
/*     */       }
/*  91 */       if (!this.mflag) {
/*     */         try {
/*  93 */           this.con.close(); } catch (Exception e) {
/*  94 */           e.printStackTrace();
/*     */         }
/*     */       }
/*  97 */       return false;
/*     */     }
/*     */ 
/* 100 */     if (!this.mflag) {
/*     */       try {
/* 102 */         this.con.close(); } catch (Exception e) {
/* 103 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 112 */     PreparedStatement pstmt = null;
/*     */ 
/* 114 */     if (!this.mflag) {
/* 115 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 120 */       int tCount = size();
/* 121 */       pstmt = this.con.prepareStatement("UPDATE LNPCom SET  ComCode = ? , OutComCode = ? , Name = ? , ShortName = ? , Address = ? , ZipCode = ? , Phone = ? , Fax = ? , EMail = ? , WebAddress = ? , SatrapName = ? , InsuMonitorCode = ? , InsureID = ? , SignID = ? , Country = ? , Province = ? , City = ? , ComNature = ? , ValidCode = ? , Sign = ? WHERE ");
/* 122 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 125 */         pstmt.addBatch();
/*     */       }
/* 127 */       pstmt.executeBatch();
/* 128 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 131 */       ex.printStackTrace();
/* 132 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 133 */       CError tError = new CError();
/* 134 */       tError.moduleName = "LNPComDBSet";
/* 135 */       tError.functionName = "update()";
/* 136 */       tError.errorMessage = ex.toString();
/* 137 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 140 */         pstmt.close(); } catch (Exception e) {
/* 141 */         e.printStackTrace();
/*     */       }
/* 143 */       if (!this.mflag) {
/*     */         try {
/* 145 */           this.con.close(); } catch (Exception e) {
/* 146 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 149 */       return false;
/*     */     }
/*     */ 
/* 152 */     if (!this.mflag) {
/*     */       try {
/* 154 */         this.con.close(); } catch (Exception e) {
/* 155 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 164 */     PreparedStatement pstmt = null;
/*     */ 
/* 166 */     if (!this.mflag) {
/* 167 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 172 */       int tCount = size();
/* 173 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCom VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 174 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 176 */         pstmt.addBatch();
/*     */       }
/* 178 */       pstmt.executeBatch();
/* 179 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 182 */       ex.printStackTrace();
/* 183 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 184 */       CError tError = new CError();
/* 185 */       tError.moduleName = "LNPComDBSet";
/* 186 */       tError.functionName = "insert()";
/* 187 */       tError.errorMessage = ex.toString();
/* 188 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 191 */         pstmt.close(); } catch (Exception e) {
/* 192 */         e.printStackTrace();
/*     */       }
/* 194 */       if (!this.mflag) {
/*     */         try {
/* 196 */           this.con.close(); } catch (Exception e) {
/* 197 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 200 */       return false;
/*     */     }
/*     */ 
/* 203 */     if (!this.mflag) {
/*     */       try {
/* 205 */         this.con.close(); } catch (Exception e) {
/* 206 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 209 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPComDBSet
 * JD-Core Version:    0.6.0
 */