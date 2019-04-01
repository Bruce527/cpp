/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPCustImpResultSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPCustImpResultDBSet extends LNPCustImpResultSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPCustImpResultDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPCustImpResult");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPCustImpResultDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPCustImpResult");
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
/*  50 */     tError.moduleName = "LNPCustImpResultDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCustImpResult WHERE  ResultId = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getResultId());
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
/*  87 */       tError.moduleName = "LNPCustImpResultDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPCustImpResult SET  ResultId = ? , ImpartId = ? , QuestionId = ? , QuestionType = ? , QueInnerOrder = ? , GrpContNo = ? , ContNo = ? , ProposalContNo = ? , CustomerNo = ? , CustomerId = ? , OptionId = ? , Answer = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultId = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getResultId());
/*     */         }
/* 134 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getImpartId());
/*     */         }
/* 139 */         if ((get(i).getQuestionId() == null) || (get(i).getQuestionId().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getQuestionId());
/*     */         }
/* 144 */         if ((get(i).getQuestionType() == null) || (get(i).getQuestionType().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getQuestionType());
/*     */         }
/* 149 */         if ((get(i).getQueInnerOrder() == null) || (get(i).getQueInnerOrder().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getQueInnerOrder());
/*     */         }
/* 154 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 155 */           pstmt.setString(6, null);
/*     */         else {
/* 157 */           pstmt.setString(6, get(i).getGrpContNo());
/*     */         }
/* 159 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 160 */           pstmt.setString(7, null);
/*     */         else {
/* 162 */           pstmt.setString(7, get(i).getContNo());
/*     */         }
/* 164 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 165 */           pstmt.setString(8, null);
/*     */         else {
/* 167 */           pstmt.setString(8, get(i).getProposalContNo());
/*     */         }
/* 169 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 170 */           pstmt.setString(9, null);
/*     */         else {
/* 172 */           pstmt.setString(9, get(i).getCustomerNo());
/*     */         }
/* 174 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 175 */           pstmt.setString(10, null);
/*     */         else {
/* 177 */           pstmt.setString(10, get(i).getCustomerId());
/*     */         }
/* 179 */         if ((get(i).getOptionId() == null) || (get(i).getOptionId().equals("null")))
/* 180 */           pstmt.setString(11, null);
/*     */         else {
/* 182 */           pstmt.setString(11, get(i).getOptionId());
/*     */         }
/* 184 */         if ((get(i).getAnswer() == null) || (get(i).getAnswer().equals("null")))
/* 185 */           pstmt.setString(12, null);
/*     */         else {
/* 187 */           pstmt.setString(12, get(i).getAnswer());
/*     */         }
/* 189 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 190 */           pstmt.setString(13, null);
/*     */         else {
/* 192 */           pstmt.setString(13, get(i).getOperator());
/*     */         }
/* 194 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 195 */           pstmt.setString(14, null);
/*     */         else {
/* 197 */           pstmt.setString(14, get(i).getManageCom());
/*     */         }
/* 199 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 200 */           pstmt.setDate(15, null);
/*     */         else {
/* 202 */           pstmt.setDate(15, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 204 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 205 */           pstmt.setString(16, null);
/*     */         else {
/* 207 */           pstmt.setString(16, get(i).getMakeTime());
/*     */         }
/* 209 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 210 */           pstmt.setDate(17, null);
/*     */         else {
/* 212 */           pstmt.setDate(17, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 214 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 215 */           pstmt.setString(18, null);
/*     */         else {
/* 217 */           pstmt.setString(18, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 220 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/* 221 */           pstmt.setString(19, null);
/*     */         else {
/* 223 */           pstmt.setString(19, get(i).getResultId());
/*     */         }
/* 225 */         pstmt.addBatch();
/*     */       }
/* 227 */       pstmt.executeBatch();
/* 228 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 231 */       ex.printStackTrace();
/* 232 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 233 */       CError tError = new CError();
/* 234 */       tError.moduleName = "LNPCustImpResultDBSet";
/* 235 */       tError.functionName = "update()";
/* 236 */       tError.errorMessage = ex.toString();
/* 237 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 240 */         pstmt.close(); } catch (Exception e) {
/* 241 */         e.printStackTrace();
/*     */       }
/* 243 */       if (!this.mflag) {
/*     */         try {
/* 245 */           this.con.close(); } catch (Exception e) {
/* 246 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 249 */       return false;
/*     */     }
/*     */ 
/* 252 */     if (!this.mflag) {
/*     */       try {
/* 254 */         this.con.close(); } catch (Exception e) {
/* 255 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 258 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 264 */     PreparedStatement pstmt = null;
/*     */ 
/* 266 */     if (!this.mflag) {
/* 267 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 272 */       int tCount = size();
/* 273 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCustImpResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 274 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 276 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/* 277 */           pstmt.setString(1, null);
/*     */         else {
/* 279 */           pstmt.setString(1, get(i).getResultId());
/*     */         }
/* 281 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 282 */           pstmt.setString(2, null);
/*     */         else {
/* 284 */           pstmt.setString(2, get(i).getImpartId());
/*     */         }
/* 286 */         if ((get(i).getQuestionId() == null) || (get(i).getQuestionId().equals("null")))
/* 287 */           pstmt.setString(3, null);
/*     */         else {
/* 289 */           pstmt.setString(3, get(i).getQuestionId());
/*     */         }
/* 291 */         if ((get(i).getQuestionType() == null) || (get(i).getQuestionType().equals("null")))
/* 292 */           pstmt.setString(4, null);
/*     */         else {
/* 294 */           pstmt.setString(4, get(i).getQuestionType());
/*     */         }
/* 296 */         if ((get(i).getQueInnerOrder() == null) || (get(i).getQueInnerOrder().equals("null")))
/* 297 */           pstmt.setString(5, null);
/*     */         else {
/* 299 */           pstmt.setString(5, get(i).getQueInnerOrder());
/*     */         }
/* 301 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 302 */           pstmt.setString(6, null);
/*     */         else {
/* 304 */           pstmt.setString(6, get(i).getGrpContNo());
/*     */         }
/* 306 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 307 */           pstmt.setString(7, null);
/*     */         else {
/* 309 */           pstmt.setString(7, get(i).getContNo());
/*     */         }
/* 311 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 312 */           pstmt.setString(8, null);
/*     */         else {
/* 314 */           pstmt.setString(8, get(i).getProposalContNo());
/*     */         }
/* 316 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 317 */           pstmt.setString(9, null);
/*     */         else {
/* 319 */           pstmt.setString(9, get(i).getCustomerNo());
/*     */         }
/* 321 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 322 */           pstmt.setString(10, null);
/*     */         else {
/* 324 */           pstmt.setString(10, get(i).getCustomerId());
/*     */         }
/* 326 */         if ((get(i).getOptionId() == null) || (get(i).getOptionId().equals("null")))
/* 327 */           pstmt.setString(11, null);
/*     */         else {
/* 329 */           pstmt.setString(11, get(i).getOptionId());
/*     */         }
/* 331 */         if ((get(i).getAnswer() == null) || (get(i).getAnswer().equals("null")))
/* 332 */           pstmt.setString(12, null);
/*     */         else {
/* 334 */           pstmt.setString(12, get(i).getAnswer());
/*     */         }
/* 336 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 337 */           pstmt.setString(13, null);
/*     */         else {
/* 339 */           pstmt.setString(13, get(i).getOperator());
/*     */         }
/* 341 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 342 */           pstmt.setString(14, null);
/*     */         else {
/* 344 */           pstmt.setString(14, get(i).getManageCom());
/*     */         }
/* 346 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 347 */           pstmt.setDate(15, null);
/*     */         else {
/* 349 */           pstmt.setDate(15, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 351 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 352 */           pstmt.setString(16, null);
/*     */         else {
/* 354 */           pstmt.setString(16, get(i).getMakeTime());
/*     */         }
/* 356 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 357 */           pstmt.setDate(17, null);
/*     */         else {
/* 359 */           pstmt.setDate(17, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 361 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 362 */           pstmt.setString(18, null);
/*     */         else {
/* 364 */           pstmt.setString(18, get(i).getModifyTime());
/*     */         }
/* 366 */         pstmt.addBatch();
/*     */       }
/* 368 */       pstmt.executeBatch();
/* 369 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 372 */       ex.printStackTrace();
/* 373 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 374 */       CError tError = new CError();
/* 375 */       tError.moduleName = "LNPCustImpResultDBSet";
/* 376 */       tError.functionName = "insert()";
/* 377 */       tError.errorMessage = ex.toString();
/* 378 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 381 */         pstmt.close(); } catch (Exception e) {
/* 382 */         e.printStackTrace();
/*     */       }
/* 384 */       if (!this.mflag) {
/*     */         try {
/* 386 */           this.con.close(); } catch (Exception e) {
/* 387 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 390 */       return false;
/*     */     }
/*     */ 
/* 393 */     if (!this.mflag) {
/*     */       try {
/* 395 */         this.con.close(); } catch (Exception e) {
/* 396 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 399 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPCustImpResultDBSet
 * JD-Core Version:    0.6.0
 */