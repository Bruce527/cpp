/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.vschema.MCodeSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MCodeDBSet extends MCodeSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MCodeDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MCode");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MCodeDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MCode");
/*  35 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  40 */     if (this.db.deleteSQL(this))
/*     */     {
/*  42 */       return true;
/*     */     }
/*     */ 
/*  47 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  48 */     CError tError = new CError();
/*  49 */     tError.moduleName = "MCodeDBSet";
/*  50 */     tError.functionName = "deleteSQL";
/*  51 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  52 */     this.mErrors.addOneError(tError);
/*  53 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  60 */     PreparedStatement pstmt = null;
/*     */ 
/*  62 */     if (!this.mflag) {
/*  63 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  68 */       int tCount = size();
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MCode WHERE ");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         pstmt.addBatch();
/*     */       }
/*  74 */       pstmt.executeBatch();
/*  75 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  78 */       ex.printStackTrace();
/*  79 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  80 */       CError tError = new CError();
/*  81 */       tError.moduleName = "MCodeDBSet";
/*  82 */       tError.functionName = "delete()";
/*  83 */       tError.errorMessage = ex.toString();
/*  84 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  87 */         pstmt.close(); } catch (Exception e) {
/*  88 */         e.printStackTrace();
/*     */       }
/*  90 */       if (!this.mflag) {
/*     */         try {
/*  92 */           this.con.close(); } catch (Exception e) {
/*  93 */           e.printStackTrace();
/*     */         }
/*     */       }
/*  96 */       return false;
/*     */     }
/*     */ 
/*  99 */     if (!this.mflag) {
/*     */       try {
/* 101 */         this.con.close(); } catch (Exception e) {
/* 102 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 111 */     PreparedStatement pstmt = null;
/*     */ 
/* 113 */     if (!this.mflag) {
/* 114 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 119 */       int tCount = size();
/* 120 */       pstmt = this.con.prepareStatement("UPDATE MCode SET  CodeType = ? , Code = ? , CodeName = ? , CodeAlias = ? , ComCode = ? , OtherSign = ? , CodeOrder = ? WHERE ");
/* 121 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 124 */         pstmt.addBatch();
/*     */       }
/* 126 */       pstmt.executeBatch();
/* 127 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 130 */       ex.printStackTrace();
/* 131 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 132 */       CError tError = new CError();
/* 133 */       tError.moduleName = "MCodeDBSet";
/* 134 */       tError.functionName = "update()";
/* 135 */       tError.errorMessage = ex.toString();
/* 136 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 139 */         pstmt.close(); } catch (Exception e) {
/* 140 */         e.printStackTrace();
/*     */       }
/* 142 */       if (!this.mflag) {
/*     */         try {
/* 144 */           this.con.close(); } catch (Exception e) {
/* 145 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 148 */       return false;
/*     */     }
/*     */ 
/* 151 */     if (!this.mflag) {
/*     */       try {
/* 153 */         this.con.close(); } catch (Exception e) {
/* 154 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 157 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 163 */     PreparedStatement pstmt = null;
/*     */ 
/* 165 */     if (!this.mflag) {
/* 166 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 171 */       int tCount = size();
/* 172 */       pstmt = this.con.prepareStatement("INSERT INTO MCode VALUES( ? , ? , ? , ? , ? , ? , ?)");
/* 173 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 175 */         pstmt.addBatch();
/*     */       }
/* 177 */       pstmt.executeBatch();
/* 178 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 181 */       ex.printStackTrace();
/* 182 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 183 */       CError tError = new CError();
/* 184 */       tError.moduleName = "MCodeDBSet";
/* 185 */       tError.functionName = "insert()";
/* 186 */       tError.errorMessage = ex.toString();
/* 187 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 190 */         pstmt.close(); } catch (Exception e) {
/* 191 */         e.printStackTrace();
/*     */       }
/* 193 */       if (!this.mflag) {
/*     */         try {
/* 195 */           this.con.close(); } catch (Exception e) {
/* 196 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 199 */       return false;
/*     */     }
/*     */ 
/* 202 */     if (!this.mflag) {
/*     */       try {
/* 204 */         this.con.close(); } catch (Exception e) {
/* 205 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 208 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MCodeDBSet
 * JD-Core Version:    0.6.0
 */