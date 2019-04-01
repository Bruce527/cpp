/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPCUWMasterSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCUWMasterSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPCUWMasterDBSet extends LNPCUWMasterSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPCUWMasterDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPCUWMaster");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPCUWMasterDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPCUWMaster");
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
/*  50 */     tError.moduleName = "LNPCUWMasterDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCUWMaster WHERE  ContNo = ?");
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
/*  87 */       tError.moduleName = "LNPCUWMasterDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPCUWMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , UWNo = ? , ManageCom = ? , UWDate = ? , UWTime = ? , UWerName = ? , CheckStatus = ? , AppIsCompleted = ? , AppIsSubmitted = ? , AppDecision = ? , AutoUWFlag = ? , UWMessages = ? , UWGrade = ? , AppGrade = ? , State = ? , UpReportContent = ? , HealthFlag = ? , QuesFlag = ? , SpecFlag = ? , AddPremFlag = ? , AddPremReason = ? , SpecReason = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 134 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 139 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 144 */         pstmt.setInt(4, get(i).getUWNo());
/* 145 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 146 */           pstmt.setString(5, null);
/*     */         else {
/* 148 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 150 */         if ((get(i).getUWDate() == null) || (get(i).getUWDate().equals("null")))
/* 151 */           pstmt.setDate(6, null);
/*     */         else {
/* 153 */           pstmt.setDate(6, Date.valueOf(get(i).getUWDate()));
/*     */         }
/* 155 */         if ((get(i).getUWTime() == null) || (get(i).getUWTime().equals("null")))
/* 156 */           pstmt.setString(7, null);
/*     */         else {
/* 158 */           pstmt.setString(7, get(i).getUWTime());
/*     */         }
/* 160 */         if ((get(i).getUWerName() == null) || (get(i).getUWerName().equals("null")))
/* 161 */           pstmt.setString(8, null);
/*     */         else {
/* 163 */           pstmt.setString(8, get(i).getUWerName());
/*     */         }
/* 165 */         if ((get(i).getCheckStatus() == null) || (get(i).getCheckStatus().equals("null")))
/* 166 */           pstmt.setString(9, null);
/*     */         else {
/* 168 */           pstmt.setString(9, get(i).getCheckStatus());
/*     */         }
/* 170 */         if ((get(i).getAppIsCompleted() == null) || (get(i).getAppIsCompleted().equals("null")))
/* 171 */           pstmt.setString(10, null);
/*     */         else {
/* 173 */           pstmt.setString(10, get(i).getAppIsCompleted());
/*     */         }
/* 175 */         if ((get(i).getAppIsSubmitted() == null) || (get(i).getAppIsSubmitted().equals("null")))
/* 176 */           pstmt.setString(11, null);
/*     */         else {
/* 178 */           pstmt.setString(11, get(i).getAppIsSubmitted());
/*     */         }
/* 180 */         if ((get(i).getAppDecision() == null) || (get(i).getAppDecision().equals("null")))
/* 181 */           pstmt.setString(12, null);
/*     */         else {
/* 183 */           pstmt.setString(12, get(i).getAppDecision());
/*     */         }
/* 185 */         if ((get(i).getAutoUWFlag() == null) || (get(i).getAutoUWFlag().equals("null")))
/* 186 */           pstmt.setString(13, null);
/*     */         else {
/* 188 */           pstmt.setString(13, get(i).getAutoUWFlag());
/*     */         }
/* 190 */         if ((get(i).getUWMessages() == null) || (get(i).getUWMessages().equals("null")))
/* 191 */           pstmt.setString(14, null);
/*     */         else {
/* 193 */           pstmt.setString(14, get(i).getUWMessages());
/*     */         }
/* 195 */         if ((get(i).getUWGrade() == null) || (get(i).getUWGrade().equals("null")))
/* 196 */           pstmt.setString(15, null);
/*     */         else {
/* 198 */           pstmt.setString(15, get(i).getUWGrade());
/*     */         }
/* 200 */         if ((get(i).getAppGrade() == null) || (get(i).getAppGrade().equals("null")))
/* 201 */           pstmt.setString(16, null);
/*     */         else {
/* 203 */           pstmt.setString(16, get(i).getAppGrade());
/*     */         }
/* 205 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 206 */           pstmt.setString(17, null);
/*     */         else {
/* 208 */           pstmt.setString(17, get(i).getState());
/*     */         }
/* 210 */         if ((get(i).getUpReportContent() == null) || (get(i).getUpReportContent().equals("null")))
/* 211 */           pstmt.setString(18, null);
/*     */         else {
/* 213 */           pstmt.setString(18, get(i).getUpReportContent());
/*     */         }
/* 215 */         if ((get(i).getHealthFlag() == null) || (get(i).getHealthFlag().equals("null")))
/* 216 */           pstmt.setString(19, null);
/*     */         else {
/* 218 */           pstmt.setString(19, get(i).getHealthFlag());
/*     */         }
/* 220 */         if ((get(i).getQuesFlag() == null) || (get(i).getQuesFlag().equals("null")))
/* 221 */           pstmt.setString(20, null);
/*     */         else {
/* 223 */           pstmt.setString(20, get(i).getQuesFlag());
/*     */         }
/* 225 */         if ((get(i).getSpecFlag() == null) || (get(i).getSpecFlag().equals("null")))
/* 226 */           pstmt.setString(21, null);
/*     */         else {
/* 228 */           pstmt.setString(21, get(i).getSpecFlag());
/*     */         }
/* 230 */         if ((get(i).getAddPremFlag() == null) || (get(i).getAddPremFlag().equals("null")))
/* 231 */           pstmt.setString(22, null);
/*     */         else {
/* 233 */           pstmt.setString(22, get(i).getAddPremFlag());
/*     */         }
/* 235 */         if ((get(i).getAddPremReason() == null) || (get(i).getAddPremReason().equals("null")))
/* 236 */           pstmt.setString(23, null);
/*     */         else {
/* 238 */           pstmt.setString(23, get(i).getAddPremReason());
/*     */         }
/* 240 */         if ((get(i).getSpecReason() == null) || (get(i).getSpecReason().equals("null")))
/* 241 */           pstmt.setString(24, null);
/*     */         else {
/* 243 */           pstmt.setString(24, get(i).getSpecReason());
/*     */         }
/* 245 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 246 */           pstmt.setString(25, null);
/*     */         else {
/* 248 */           pstmt.setString(25, get(i).getOperator());
/*     */         }
/* 250 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 251 */           pstmt.setDate(26, null);
/*     */         else {
/* 253 */           pstmt.setDate(26, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 255 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 256 */           pstmt.setString(27, null);
/*     */         else {
/* 258 */           pstmt.setString(27, get(i).getMakeTime());
/*     */         }
/* 260 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 261 */           pstmt.setDate(28, null);
/*     */         else {
/* 263 */           pstmt.setDate(28, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 265 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 266 */           pstmt.setString(29, null);
/*     */         else {
/* 268 */           pstmt.setString(29, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 271 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 272 */           pstmt.setString(30, null);
/*     */         else {
/* 274 */           pstmt.setString(30, get(i).getContNo());
/*     */         }
/* 276 */         pstmt.addBatch();
/*     */       }
/* 278 */       pstmt.executeBatch();
/* 279 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 282 */       ex.printStackTrace();
/* 283 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 284 */       CError tError = new CError();
/* 285 */       tError.moduleName = "LNPCUWMasterDBSet";
/* 286 */       tError.functionName = "update()";
/* 287 */       tError.errorMessage = ex.toString();
/* 288 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 291 */         pstmt.close(); } catch (Exception e) {
/* 292 */         e.printStackTrace();
/*     */       }
/* 294 */       if (!this.mflag) {
/*     */         try {
/* 296 */           this.con.close(); } catch (Exception e) {
/* 297 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 300 */       return false;
/*     */     }
/*     */ 
/* 303 */     if (!this.mflag) {
/*     */       try {
/* 305 */         this.con.close(); } catch (Exception e) {
/* 306 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 309 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 315 */     PreparedStatement pstmt = null;
/*     */ 
/* 317 */     if (!this.mflag) {
/* 318 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 323 */       int tCount = size();
/* 324 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCUWMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 325 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 327 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 328 */           pstmt.setString(1, null);
/*     */         else {
/* 330 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 332 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 333 */           pstmt.setString(2, null);
/*     */         else {
/* 335 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 337 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 338 */           pstmt.setString(3, null);
/*     */         else {
/* 340 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 342 */         pstmt.setInt(4, get(i).getUWNo());
/* 343 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 344 */           pstmt.setString(5, null);
/*     */         else {
/* 346 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 348 */         if ((get(i).getUWDate() == null) || (get(i).getUWDate().equals("null")))
/* 349 */           pstmt.setDate(6, null);
/*     */         else {
/* 351 */           pstmt.setDate(6, Date.valueOf(get(i).getUWDate()));
/*     */         }
/* 353 */         if ((get(i).getUWTime() == null) || (get(i).getUWTime().equals("null")))
/* 354 */           pstmt.setString(7, null);
/*     */         else {
/* 356 */           pstmt.setString(7, get(i).getUWTime());
/*     */         }
/* 358 */         if ((get(i).getUWerName() == null) || (get(i).getUWerName().equals("null")))
/* 359 */           pstmt.setString(8, null);
/*     */         else {
/* 361 */           pstmt.setString(8, get(i).getUWerName());
/*     */         }
/* 363 */         if ((get(i).getCheckStatus() == null) || (get(i).getCheckStatus().equals("null")))
/* 364 */           pstmt.setString(9, null);
/*     */         else {
/* 366 */           pstmt.setString(9, get(i).getCheckStatus());
/*     */         }
/* 368 */         if ((get(i).getAppIsCompleted() == null) || (get(i).getAppIsCompleted().equals("null")))
/* 369 */           pstmt.setString(10, null);
/*     */         else {
/* 371 */           pstmt.setString(10, get(i).getAppIsCompleted());
/*     */         }
/* 373 */         if ((get(i).getAppIsSubmitted() == null) || (get(i).getAppIsSubmitted().equals("null")))
/* 374 */           pstmt.setString(11, null);
/*     */         else {
/* 376 */           pstmt.setString(11, get(i).getAppIsSubmitted());
/*     */         }
/* 378 */         if ((get(i).getAppDecision() == null) || (get(i).getAppDecision().equals("null")))
/* 379 */           pstmt.setString(12, null);
/*     */         else {
/* 381 */           pstmt.setString(12, get(i).getAppDecision());
/*     */         }
/* 383 */         if ((get(i).getAutoUWFlag() == null) || (get(i).getAutoUWFlag().equals("null")))
/* 384 */           pstmt.setString(13, null);
/*     */         else {
/* 386 */           pstmt.setString(13, get(i).getAutoUWFlag());
/*     */         }
/* 388 */         if ((get(i).getUWMessages() == null) || (get(i).getUWMessages().equals("null")))
/* 389 */           pstmt.setString(14, null);
/*     */         else {
/* 391 */           pstmt.setString(14, get(i).getUWMessages());
/*     */         }
/* 393 */         if ((get(i).getUWGrade() == null) || (get(i).getUWGrade().equals("null")))
/* 394 */           pstmt.setString(15, null);
/*     */         else {
/* 396 */           pstmt.setString(15, get(i).getUWGrade());
/*     */         }
/* 398 */         if ((get(i).getAppGrade() == null) || (get(i).getAppGrade().equals("null")))
/* 399 */           pstmt.setString(16, null);
/*     */         else {
/* 401 */           pstmt.setString(16, get(i).getAppGrade());
/*     */         }
/* 403 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 404 */           pstmt.setString(17, null);
/*     */         else {
/* 406 */           pstmt.setString(17, get(i).getState());
/*     */         }
/* 408 */         if ((get(i).getUpReportContent() == null) || (get(i).getUpReportContent().equals("null")))
/* 409 */           pstmt.setString(18, null);
/*     */         else {
/* 411 */           pstmt.setString(18, get(i).getUpReportContent());
/*     */         }
/* 413 */         if ((get(i).getHealthFlag() == null) || (get(i).getHealthFlag().equals("null")))
/* 414 */           pstmt.setString(19, null);
/*     */         else {
/* 416 */           pstmt.setString(19, get(i).getHealthFlag());
/*     */         }
/* 418 */         if ((get(i).getQuesFlag() == null) || (get(i).getQuesFlag().equals("null")))
/* 419 */           pstmt.setString(20, null);
/*     */         else {
/* 421 */           pstmt.setString(20, get(i).getQuesFlag());
/*     */         }
/* 423 */         if ((get(i).getSpecFlag() == null) || (get(i).getSpecFlag().equals("null")))
/* 424 */           pstmt.setString(21, null);
/*     */         else {
/* 426 */           pstmt.setString(21, get(i).getSpecFlag());
/*     */         }
/* 428 */         if ((get(i).getAddPremFlag() == null) || (get(i).getAddPremFlag().equals("null")))
/* 429 */           pstmt.setString(22, null);
/*     */         else {
/* 431 */           pstmt.setString(22, get(i).getAddPremFlag());
/*     */         }
/* 433 */         if ((get(i).getAddPremReason() == null) || (get(i).getAddPremReason().equals("null")))
/* 434 */           pstmt.setString(23, null);
/*     */         else {
/* 436 */           pstmt.setString(23, get(i).getAddPremReason());
/*     */         }
/* 438 */         if ((get(i).getSpecReason() == null) || (get(i).getSpecReason().equals("null")))
/* 439 */           pstmt.setString(24, null);
/*     */         else {
/* 441 */           pstmt.setString(24, get(i).getSpecReason());
/*     */         }
/* 443 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 444 */           pstmt.setString(25, null);
/*     */         else {
/* 446 */           pstmt.setString(25, get(i).getOperator());
/*     */         }
/* 448 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 449 */           pstmt.setDate(26, null);
/*     */         else {
/* 451 */           pstmt.setDate(26, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 453 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 454 */           pstmt.setString(27, null);
/*     */         else {
/* 456 */           pstmt.setString(27, get(i).getMakeTime());
/*     */         }
/* 458 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 459 */           pstmt.setDate(28, null);
/*     */         else {
/* 461 */           pstmt.setDate(28, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 463 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 464 */           pstmt.setString(29, null);
/*     */         else {
/* 466 */           pstmt.setString(29, get(i).getModifyTime());
/*     */         }
/* 468 */         pstmt.addBatch();
/*     */       }
/* 470 */       pstmt.executeBatch();
/* 471 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 474 */       ex.printStackTrace();
/* 475 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 476 */       CError tError = new CError();
/* 477 */       tError.moduleName = "LNPCUWMasterDBSet";
/* 478 */       tError.functionName = "insert()";
/* 479 */       tError.errorMessage = ex.toString();
/* 480 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 483 */         pstmt.close(); } catch (Exception e) {
/* 484 */         e.printStackTrace();
/*     */       }
/* 486 */       if (!this.mflag) {
/*     */         try {
/* 488 */           this.con.close(); } catch (Exception e) {
/* 489 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 492 */       return false;
/*     */     }
/*     */ 
/* 495 */     if (!this.mflag) {
/*     */       try {
/* 497 */         this.con.close(); } catch (Exception e) {
/* 498 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 501 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPCUWMasterDBSet
 * JD-Core Version:    0.6.0
 */