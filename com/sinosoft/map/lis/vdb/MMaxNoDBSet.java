/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MMaxNoSchema;
/*     */ import com.sinosoft.map.lis.vschema.MMaxNoSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MMaxNoDBSet extends MMaxNoSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MMaxNoDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MMaxNo");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MMaxNoDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MMaxNo");
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
/*  49 */     tError.moduleName = "MMaxNoDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MMaxNo WHERE  NoType = ? AND NoLimit = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getNoType() == null) || (get(i).getNoType().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getNoType());
/*     */         }
/*  77 */         if ((get(i).getNoLimit() == null) || (get(i).getNoLimit().equals("null")))
/*  78 */           pstmt.setString(2, null);
/*     */         else {
/*  80 */           pstmt.setString(2, get(i).getNoLimit());
/*     */         }
/*  82 */         pstmt.addBatch();
/*     */       }
/*  84 */       pstmt.executeBatch();
/*  85 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  88 */       ex.printStackTrace();
/*  89 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  90 */       CError tError = new CError();
/*  91 */       tError.moduleName = "MMaxNoDBSet";
/*  92 */       tError.functionName = "delete()";
/*  93 */       tError.errorMessage = ex.toString();
/*  94 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  97 */         pstmt.close(); } catch (Exception e) {
/*  98 */         e.printStackTrace();
/*     */       }
/* 100 */       if (!this.mflag) {
/*     */         try {
/* 102 */           this.con.close(); } catch (Exception e) {
/* 103 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 106 */       return false;
/*     */     }
/*     */ 
/* 109 */     if (!this.mflag) {
/*     */       try {
/* 111 */         this.con.close(); } catch (Exception e) {
/* 112 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 115 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 121 */     PreparedStatement pstmt = null;
/*     */ 
/* 123 */     if (!this.mflag) {
/* 124 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 129 */       int tCount = size();
/* 130 */       pstmt = this.con.prepareStatement("UPDATE MMaxNo SET  NoType = ? , NoLimit = ? , MaxNo = ? WHERE  NoType = ? AND NoLimit = ?");
/* 131 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 133 */         if ((get(i).getNoType() == null) || (get(i).getNoType().equals("null")))
/* 134 */           pstmt.setString(1, null);
/*     */         else {
/* 136 */           pstmt.setString(1, get(i).getNoType());
/*     */         }
/* 138 */         if ((get(i).getNoLimit() == null) || (get(i).getNoLimit().equals("null")))
/* 139 */           pstmt.setString(2, null);
/*     */         else {
/* 141 */           pstmt.setString(2, get(i).getNoLimit());
/*     */         }
/* 143 */         pstmt.setInt(3, get(i).getMaxNo());
/*     */ 
/* 145 */         if ((get(i).getNoType() == null) || (get(i).getNoType().equals("null")))
/* 146 */           pstmt.setString(4, null);
/*     */         else {
/* 148 */           pstmt.setString(4, get(i).getNoType());
/*     */         }
/* 150 */         if ((get(i).getNoLimit() == null) || (get(i).getNoLimit().equals("null")))
/* 151 */           pstmt.setString(5, null);
/*     */         else {
/* 153 */           pstmt.setString(5, get(i).getNoLimit());
/*     */         }
/* 155 */         pstmt.addBatch();
/*     */       }
/* 157 */       pstmt.executeBatch();
/* 158 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 161 */       ex.printStackTrace();
/* 162 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 163 */       CError tError = new CError();
/* 164 */       tError.moduleName = "MMaxNoDBSet";
/* 165 */       tError.functionName = "update()";
/* 166 */       tError.errorMessage = ex.toString();
/* 167 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 170 */         pstmt.close(); } catch (Exception e) {
/* 171 */         e.printStackTrace();
/*     */       }
/* 173 */       if (!this.mflag) {
/*     */         try {
/* 175 */           this.con.close(); } catch (Exception e) {
/* 176 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 179 */       return false;
/*     */     }
/*     */ 
/* 182 */     if (!this.mflag) {
/*     */       try {
/* 184 */         this.con.close(); } catch (Exception e) {
/* 185 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 188 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 194 */     PreparedStatement pstmt = null;
/*     */ 
/* 196 */     if (!this.mflag) {
/* 197 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 202 */       int tCount = size();
/* 203 */       pstmt = this.con.prepareStatement("INSERT INTO MMaxNo VALUES( ? , ? , ?)");
/* 204 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 206 */         if ((get(i).getNoType() == null) || (get(i).getNoType().equals("null")))
/* 207 */           pstmt.setString(1, null);
/*     */         else {
/* 209 */           pstmt.setString(1, get(i).getNoType());
/*     */         }
/* 211 */         if ((get(i).getNoLimit() == null) || (get(i).getNoLimit().equals("null")))
/* 212 */           pstmt.setString(2, null);
/*     */         else {
/* 214 */           pstmt.setString(2, get(i).getNoLimit());
/*     */         }
/* 216 */         pstmt.setInt(3, get(i).getMaxNo());
/* 217 */         pstmt.addBatch();
/*     */       }
/* 219 */       pstmt.executeBatch();
/* 220 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 223 */       ex.printStackTrace();
/* 224 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 225 */       CError tError = new CError();
/* 226 */       tError.moduleName = "MMaxNoDBSet";
/* 227 */       tError.functionName = "insert()";
/* 228 */       tError.errorMessage = ex.toString();
/* 229 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 232 */         pstmt.close(); } catch (Exception e) {
/* 233 */         e.printStackTrace();
/*     */       }
/* 235 */       if (!this.mflag) {
/*     */         try {
/* 237 */           this.con.close(); } catch (Exception e) {
/* 238 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 241 */       return false;
/*     */     }
/*     */ 
/* 244 */     if (!this.mflag) {
/*     */       try {
/* 246 */         this.con.close(); } catch (Exception e) {
/* 247 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 250 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MMaxNoDBSet
 * JD-Core Version:    0.6.0
 */