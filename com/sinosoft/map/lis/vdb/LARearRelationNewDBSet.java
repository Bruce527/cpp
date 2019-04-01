/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.LARearRelationNewSchema;
/*     */ import com.sinosoft.map.lis.vschema.LARearRelationNewSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LARearRelationNewDBSet extends LARearRelationNewSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public LARearRelationNewDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "LARearRelationNew");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LARearRelationNewDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("LARearRelationNew");
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
/*  49 */     tError.moduleName = "LARearRelationNewDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM LARearRelationNew WHERE  AgentCode = ? AND RAgentCode = ? AND Type = ? AND Deep = ? AND State = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getAgentCode());
/*     */         }
/*  77 */         if ((get(i).getRAgentCode() == null) || (get(i).getRAgentCode().equals("null")))
/*  78 */           pstmt.setString(2, null);
/*     */         else {
/*  80 */           pstmt.setString(2, get(i).getRAgentCode());
/*     */         }
/*  82 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/*  83 */           pstmt.setString(3, null);
/*     */         else {
/*  85 */           pstmt.setString(3, get(i).getType());
/*     */         }
/*  87 */         pstmt.setInt(4, get(i).getDeep());
/*  88 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/*  89 */           pstmt.setString(5, null);
/*     */         else {
/*  91 */           pstmt.setString(5, get(i).getState());
/*     */         }
/*  93 */         pstmt.addBatch();
/*     */       }
/*  95 */       pstmt.executeBatch();
/*  96 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  99 */       ex.printStackTrace();
/* 100 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 101 */       CError tError = new CError();
/* 102 */       tError.moduleName = "LARearRelationNewDBSet";
/* 103 */       tError.functionName = "delete()";
/* 104 */       tError.errorMessage = ex.toString();
/* 105 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 108 */         pstmt.close(); } catch (Exception e) {
/* 109 */         e.printStackTrace();
/*     */       }
/* 111 */       if (!this.mflag) {
/*     */         try {
/* 113 */           this.con.close(); } catch (Exception e) {
/* 114 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 117 */       return false;
/*     */     }
/*     */ 
/* 120 */     if (!this.mflag) {
/*     */       try {
/* 122 */         this.con.close(); } catch (Exception e) {
/* 123 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 132 */     PreparedStatement pstmt = null;
/*     */ 
/* 134 */     if (!this.mflag) {
/* 135 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 140 */       int tCount = size();
/* 141 */       pstmt = this.con.prepareStatement("UPDATE LARearRelationNew SET  ManageCom = ? , AgentCode = ? , AgentGrade = ? , AgentGroup = ? , SMAgentCode = ? , AMAgentCode = ? , RAgentCode = ? , AgentTitle = ? , RAgentGrade = ? , RAgentTitle = ? , RAgentGroup = ? , RBranchAttr = ? , Type = ? , Deep = ? , StartDate = ? , BreakDate = ? , PBreakDate = ? , BreakType = ? , State = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Operator = ? WHERE  AgentCode = ? AND RAgentCode = ? AND Type = ? AND Deep = ? AND State = ?");
/* 142 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 144 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 145 */           pstmt.setString(1, null);
/*     */         else {
/* 147 */           pstmt.setString(1, get(i).getManageCom());
/*     */         }
/* 149 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 150 */           pstmt.setString(2, null);
/*     */         else {
/* 152 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 154 */         if ((get(i).getAgentGrade() == null) || (get(i).getAgentGrade().equals("null")))
/* 155 */           pstmt.setString(3, null);
/*     */         else {
/* 157 */           pstmt.setString(3, get(i).getAgentGrade());
/*     */         }
/* 159 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/* 160 */           pstmt.setString(4, null);
/*     */         else {
/* 162 */           pstmt.setString(4, get(i).getAgentGroup());
/*     */         }
/* 164 */         if ((get(i).getSMAgentCode() == null) || (get(i).getSMAgentCode().equals("null")))
/* 165 */           pstmt.setString(5, null);
/*     */         else {
/* 167 */           pstmt.setString(5, get(i).getSMAgentCode());
/*     */         }
/* 169 */         if ((get(i).getAMAgentCode() == null) || (get(i).getAMAgentCode().equals("null")))
/* 170 */           pstmt.setString(6, null);
/*     */         else {
/* 172 */           pstmt.setString(6, get(i).getAMAgentCode());
/*     */         }
/* 174 */         if ((get(i).getRAgentCode() == null) || (get(i).getRAgentCode().equals("null")))
/* 175 */           pstmt.setString(7, null);
/*     */         else {
/* 177 */           pstmt.setString(7, get(i).getRAgentCode());
/*     */         }
/* 179 */         if ((get(i).getAgentTitle() == null) || (get(i).getAgentTitle().equals("null")))
/* 180 */           pstmt.setString(8, null);
/*     */         else {
/* 182 */           pstmt.setString(8, get(i).getAgentTitle());
/*     */         }
/* 184 */         if ((get(i).getRAgentGrade() == null) || (get(i).getRAgentGrade().equals("null")))
/* 185 */           pstmt.setString(9, null);
/*     */         else {
/* 187 */           pstmt.setString(9, get(i).getRAgentGrade());
/*     */         }
/* 189 */         if ((get(i).getRAgentTitle() == null) || (get(i).getRAgentTitle().equals("null")))
/* 190 */           pstmt.setString(10, null);
/*     */         else {
/* 192 */           pstmt.setString(10, get(i).getRAgentTitle());
/*     */         }
/* 194 */         if ((get(i).getRAgentGroup() == null) || (get(i).getRAgentGroup().equals("null")))
/* 195 */           pstmt.setString(11, null);
/*     */         else {
/* 197 */           pstmt.setString(11, get(i).getRAgentGroup());
/*     */         }
/* 199 */         if ((get(i).getRBranchAttr() == null) || (get(i).getRBranchAttr().equals("null")))
/* 200 */           pstmt.setString(12, null);
/*     */         else {
/* 202 */           pstmt.setString(12, get(i).getRBranchAttr());
/*     */         }
/* 204 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 205 */           pstmt.setString(13, null);
/*     */         else {
/* 207 */           pstmt.setString(13, get(i).getType());
/*     */         }
/* 209 */         pstmt.setInt(14, get(i).getDeep());
/* 210 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 211 */           pstmt.setDate(15, null);
/*     */         else {
/* 213 */           pstmt.setDate(15, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 215 */         if ((get(i).getBreakDate() == null) || (get(i).getBreakDate().equals("null")))
/* 216 */           pstmt.setDate(16, null);
/*     */         else {
/* 218 */           pstmt.setDate(16, Date.valueOf(get(i).getBreakDate()));
/*     */         }
/* 220 */         if ((get(i).getPBreakDate() == null) || (get(i).getPBreakDate().equals("null")))
/* 221 */           pstmt.setDate(17, null);
/*     */         else {
/* 223 */           pstmt.setDate(17, Date.valueOf(get(i).getPBreakDate()));
/*     */         }
/* 225 */         if ((get(i).getBreakType() == null) || (get(i).getBreakType().equals("null")))
/* 226 */           pstmt.setString(18, null);
/*     */         else {
/* 228 */           pstmt.setString(18, get(i).getBreakType());
/*     */         }
/* 230 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 231 */           pstmt.setString(19, null);
/*     */         else {
/* 233 */           pstmt.setString(19, get(i).getState());
/*     */         }
/* 235 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 236 */           pstmt.setDate(20, null);
/*     */         else {
/* 238 */           pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 240 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 241 */           pstmt.setString(21, null);
/*     */         else {
/* 243 */           pstmt.setString(21, get(i).getMakeTime());
/*     */         }
/* 245 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 246 */           pstmt.setDate(22, null);
/*     */         else {
/* 248 */           pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 250 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 251 */           pstmt.setString(23, null);
/*     */         else {
/* 253 */           pstmt.setString(23, get(i).getModifyTime());
/*     */         }
/* 255 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 256 */           pstmt.setString(24, null);
/*     */         else {
/* 258 */           pstmt.setString(24, get(i).getOperator());
/*     */         }
/*     */ 
/* 261 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 262 */           pstmt.setString(25, null);
/*     */         else {
/* 264 */           pstmt.setString(25, get(i).getAgentCode());
/*     */         }
/* 266 */         if ((get(i).getRAgentCode() == null) || (get(i).getRAgentCode().equals("null")))
/* 267 */           pstmt.setString(26, null);
/*     */         else {
/* 269 */           pstmt.setString(26, get(i).getRAgentCode());
/*     */         }
/* 271 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 272 */           pstmt.setString(27, null);
/*     */         else {
/* 274 */           pstmt.setString(27, get(i).getType());
/*     */         }
/* 276 */         pstmt.setInt(28, get(i).getDeep());
/* 277 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 278 */           pstmt.setString(29, null);
/*     */         else {
/* 280 */           pstmt.setString(29, get(i).getState());
/*     */         }
/* 282 */         pstmt.addBatch();
/*     */       }
/* 284 */       pstmt.executeBatch();
/* 285 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 288 */       ex.printStackTrace();
/* 289 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 290 */       CError tError = new CError();
/* 291 */       tError.moduleName = "LARearRelationNewDBSet";
/* 292 */       tError.functionName = "update()";
/* 293 */       tError.errorMessage = ex.toString();
/* 294 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 297 */         pstmt.close(); } catch (Exception e) {
/* 298 */         e.printStackTrace();
/*     */       }
/* 300 */       if (!this.mflag) {
/*     */         try {
/* 302 */           this.con.close(); } catch (Exception e) {
/* 303 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 306 */       return false;
/*     */     }
/*     */ 
/* 309 */     if (!this.mflag) {
/*     */       try {
/* 311 */         this.con.close(); } catch (Exception e) {
/* 312 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 315 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 321 */     PreparedStatement pstmt = null;
/*     */ 
/* 323 */     if (!this.mflag) {
/* 324 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 329 */       int tCount = size();
/* 330 */       pstmt = this.con.prepareStatement("INSERT INTO LARearRelationNew VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 331 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 333 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 334 */           pstmt.setString(1, null);
/*     */         else {
/* 336 */           pstmt.setString(1, get(i).getManageCom());
/*     */         }
/* 338 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 339 */           pstmt.setString(2, null);
/*     */         else {
/* 341 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 343 */         if ((get(i).getAgentGrade() == null) || (get(i).getAgentGrade().equals("null")))
/* 344 */           pstmt.setString(3, null);
/*     */         else {
/* 346 */           pstmt.setString(3, get(i).getAgentGrade());
/*     */         }
/* 348 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/* 349 */           pstmt.setString(4, null);
/*     */         else {
/* 351 */           pstmt.setString(4, get(i).getAgentGroup());
/*     */         }
/* 353 */         if ((get(i).getSMAgentCode() == null) || (get(i).getSMAgentCode().equals("null")))
/* 354 */           pstmt.setString(5, null);
/*     */         else {
/* 356 */           pstmt.setString(5, get(i).getSMAgentCode());
/*     */         }
/* 358 */         if ((get(i).getAMAgentCode() == null) || (get(i).getAMAgentCode().equals("null")))
/* 359 */           pstmt.setString(6, null);
/*     */         else {
/* 361 */           pstmt.setString(6, get(i).getAMAgentCode());
/*     */         }
/* 363 */         if ((get(i).getRAgentCode() == null) || (get(i).getRAgentCode().equals("null")))
/* 364 */           pstmt.setString(7, null);
/*     */         else {
/* 366 */           pstmt.setString(7, get(i).getRAgentCode());
/*     */         }
/* 368 */         if ((get(i).getAgentTitle() == null) || (get(i).getAgentTitle().equals("null")))
/* 369 */           pstmt.setString(8, null);
/*     */         else {
/* 371 */           pstmt.setString(8, get(i).getAgentTitle());
/*     */         }
/* 373 */         if ((get(i).getRAgentGrade() == null) || (get(i).getRAgentGrade().equals("null")))
/* 374 */           pstmt.setString(9, null);
/*     */         else {
/* 376 */           pstmt.setString(9, get(i).getRAgentGrade());
/*     */         }
/* 378 */         if ((get(i).getRAgentTitle() == null) || (get(i).getRAgentTitle().equals("null")))
/* 379 */           pstmt.setString(10, null);
/*     */         else {
/* 381 */           pstmt.setString(10, get(i).getRAgentTitle());
/*     */         }
/* 383 */         if ((get(i).getRAgentGroup() == null) || (get(i).getRAgentGroup().equals("null")))
/* 384 */           pstmt.setString(11, null);
/*     */         else {
/* 386 */           pstmt.setString(11, get(i).getRAgentGroup());
/*     */         }
/* 388 */         if ((get(i).getRBranchAttr() == null) || (get(i).getRBranchAttr().equals("null")))
/* 389 */           pstmt.setString(12, null);
/*     */         else {
/* 391 */           pstmt.setString(12, get(i).getRBranchAttr());
/*     */         }
/* 393 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 394 */           pstmt.setString(13, null);
/*     */         else {
/* 396 */           pstmt.setString(13, get(i).getType());
/*     */         }
/* 398 */         pstmt.setInt(14, get(i).getDeep());
/* 399 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 400 */           pstmt.setDate(15, null);
/*     */         else {
/* 402 */           pstmt.setDate(15, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 404 */         if ((get(i).getBreakDate() == null) || (get(i).getBreakDate().equals("null")))
/* 405 */           pstmt.setDate(16, null);
/*     */         else {
/* 407 */           pstmt.setDate(16, Date.valueOf(get(i).getBreakDate()));
/*     */         }
/* 409 */         if ((get(i).getPBreakDate() == null) || (get(i).getPBreakDate().equals("null")))
/* 410 */           pstmt.setDate(17, null);
/*     */         else {
/* 412 */           pstmt.setDate(17, Date.valueOf(get(i).getPBreakDate()));
/*     */         }
/* 414 */         if ((get(i).getBreakType() == null) || (get(i).getBreakType().equals("null")))
/* 415 */           pstmt.setString(18, null);
/*     */         else {
/* 417 */           pstmt.setString(18, get(i).getBreakType());
/*     */         }
/* 419 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 420 */           pstmt.setString(19, null);
/*     */         else {
/* 422 */           pstmt.setString(19, get(i).getState());
/*     */         }
/* 424 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 425 */           pstmt.setDate(20, null);
/*     */         else {
/* 427 */           pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 429 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 430 */           pstmt.setString(21, null);
/*     */         else {
/* 432 */           pstmt.setString(21, get(i).getMakeTime());
/*     */         }
/* 434 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 435 */           pstmt.setDate(22, null);
/*     */         else {
/* 437 */           pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 439 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 440 */           pstmt.setString(23, null);
/*     */         else {
/* 442 */           pstmt.setString(23, get(i).getModifyTime());
/*     */         }
/* 444 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 445 */           pstmt.setString(24, null);
/*     */         else {
/* 447 */           pstmt.setString(24, get(i).getOperator());
/*     */         }
/* 449 */         pstmt.addBatch();
/*     */       }
/* 451 */       pstmt.executeBatch();
/* 452 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 455 */       ex.printStackTrace();
/* 456 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 457 */       CError tError = new CError();
/* 458 */       tError.moduleName = "LARearRelationNewDBSet";
/* 459 */       tError.functionName = "insert()";
/* 460 */       tError.errorMessage = ex.toString();
/* 461 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 464 */         pstmt.close(); } catch (Exception e) {
/* 465 */         e.printStackTrace();
/*     */       }
/* 467 */       if (!this.mflag) {
/*     */         try {
/* 469 */           this.con.close(); } catch (Exception e) {
/* 470 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 473 */       return false;
/*     */     }
/*     */ 
/* 476 */     if (!this.mflag) {
/*     */       try {
/* 478 */         this.con.close(); } catch (Exception e) {
/* 479 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 482 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.LARearRelationNewDBSet
 * JD-Core Version:    0.6.0
 */