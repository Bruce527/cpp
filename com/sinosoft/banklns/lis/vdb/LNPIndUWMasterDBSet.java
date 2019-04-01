/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPIndUWMasterSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPIndUWMasterSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPIndUWMasterDBSet extends LNPIndUWMasterSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPIndUWMasterDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPIndUWMaster");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPIndUWMasterDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPIndUWMaster");
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
/*  50 */     tError.moduleName = "LNPIndUWMasterDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPIndUWMaster WHERE  ContNo = ? AND InsuredId = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/*  78 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getInsuredId());
/*     */         }
/*  83 */         pstmt.addBatch();
/*     */       }
/*  85 */       pstmt.executeBatch();
/*  86 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  89 */       ex.printStackTrace();
/*  90 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  91 */       CError tError = new CError();
/*  92 */       tError.moduleName = "LNPIndUWMasterDBSet";
/*  93 */       tError.functionName = "delete()";
/*  94 */       tError.errorMessage = ex.toString();
/*  95 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  98 */         pstmt.close(); } catch (Exception e) {
/*  99 */         e.printStackTrace();
/*     */       }
/* 101 */       if (!this.mflag) {
/*     */         try {
/* 103 */           this.con.close(); } catch (Exception e) {
/* 104 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 107 */       return false;
/*     */     }
/*     */ 
/* 110 */     if (!this.mflag) {
/*     */       try {
/* 112 */         this.con.close(); } catch (Exception e) {
/* 113 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 122 */     PreparedStatement pstmt = null;
/*     */ 
/* 124 */     if (!this.mflag) {
/* 125 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 130 */       int tCount = size();
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPIndUWMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , UWNo = ? , ManageCom = ? , InsuredId = ? , InsuredNo = ? , InsuredName = ? , FlagCaseDcl = ? , HighFaceAmount = ? , UWMessages = ? , AppntId = ? , AppntNo = ? , AppntName = ? , PassFlag = ? , UWIdea = ? , UWGrade = ? , AppGrade = ? , PostponeDay = ? , PostponeDate = ? , AutoUWFlag = ? , State = ? , UpReportContent = ? , HealthFlag = ? , QuesFlag = ? , SpecFlag = ? , AddPremFlag = ? , AddPremReason = ? , ReportFlag = ? , SpecReason = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ? AND InsuredId = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 139 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 144 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 145 */           pstmt.setString(3, null);
/*     */         else {
/* 147 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 149 */         pstmt.setInt(4, get(i).getUWNo());
/* 150 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 151 */           pstmt.setString(5, null);
/*     */         else {
/* 153 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 155 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/* 156 */           pstmt.setString(6, null);
/*     */         else {
/* 158 */           pstmt.setString(6, get(i).getInsuredId());
/*     */         }
/* 160 */         if ((get(i).getInsuredNo() == null) || (get(i).getInsuredNo().equals("null")))
/* 161 */           pstmt.setString(7, null);
/*     */         else {
/* 163 */           pstmt.setString(7, get(i).getInsuredNo());
/*     */         }
/* 165 */         if ((get(i).getInsuredName() == null) || (get(i).getInsuredName().equals("null")))
/* 166 */           pstmt.setString(8, null);
/*     */         else {
/* 168 */           pstmt.setString(8, get(i).getInsuredName());
/*     */         }
/* 170 */         if ((get(i).getFlagCaseDcl() == null) || (get(i).getFlagCaseDcl().equals("null")))
/* 171 */           pstmt.setString(9, null);
/*     */         else {
/* 173 */           pstmt.setString(9, get(i).getFlagCaseDcl());
/*     */         }
/* 175 */         if ((get(i).getHighFaceAmount() == null) || (get(i).getHighFaceAmount().equals("null")))
/* 176 */           pstmt.setString(10, null);
/*     */         else {
/* 178 */           pstmt.setString(10, get(i).getHighFaceAmount());
/*     */         }
/* 180 */         if ((get(i).getUWMessages() == null) || (get(i).getUWMessages().equals("null")))
/* 181 */           pstmt.setString(11, null);
/*     */         else {
/* 183 */           pstmt.setString(11, get(i).getUWMessages());
/*     */         }
/* 185 */         if ((get(i).getAppntId() == null) || (get(i).getAppntId().equals("null")))
/* 186 */           pstmt.setString(12, null);
/*     */         else {
/* 188 */           pstmt.setString(12, get(i).getAppntId());
/*     */         }
/* 190 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/* 191 */           pstmt.setString(13, null);
/*     */         else {
/* 193 */           pstmt.setString(13, get(i).getAppntNo());
/*     */         }
/* 195 */         if ((get(i).getAppntName() == null) || (get(i).getAppntName().equals("null")))
/* 196 */           pstmt.setString(14, null);
/*     */         else {
/* 198 */           pstmt.setString(14, get(i).getAppntName());
/*     */         }
/* 200 */         if ((get(i).getPassFlag() == null) || (get(i).getPassFlag().equals("null")))
/* 201 */           pstmt.setString(15, null);
/*     */         else {
/* 203 */           pstmt.setString(15, get(i).getPassFlag());
/*     */         }
/* 205 */         if ((get(i).getUWIdea() == null) || (get(i).getUWIdea().equals("null")))
/* 206 */           pstmt.setString(16, null);
/*     */         else {
/* 208 */           pstmt.setString(16, get(i).getUWIdea());
/*     */         }
/* 210 */         if ((get(i).getUWGrade() == null) || (get(i).getUWGrade().equals("null")))
/* 211 */           pstmt.setString(17, null);
/*     */         else {
/* 213 */           pstmt.setString(17, get(i).getUWGrade());
/*     */         }
/* 215 */         if ((get(i).getAppGrade() == null) || (get(i).getAppGrade().equals("null")))
/* 216 */           pstmt.setString(18, null);
/*     */         else {
/* 218 */           pstmt.setString(18, get(i).getAppGrade());
/*     */         }
/* 220 */         if ((get(i).getPostponeDay() == null) || (get(i).getPostponeDay().equals("null")))
/* 221 */           pstmt.setString(19, null);
/*     */         else {
/* 223 */           pstmt.setString(19, get(i).getPostponeDay());
/*     */         }
/* 225 */         if ((get(i).getPostponeDate() == null) || (get(i).getPostponeDate().equals("null")))
/* 226 */           pstmt.setDate(20, null);
/*     */         else {
/* 228 */           pstmt.setDate(20, Date.valueOf(get(i).getPostponeDate()));
/*     */         }
/* 230 */         if ((get(i).getAutoUWFlag() == null) || (get(i).getAutoUWFlag().equals("null")))
/* 231 */           pstmt.setString(21, null);
/*     */         else {
/* 233 */           pstmt.setString(21, get(i).getAutoUWFlag());
/*     */         }
/* 235 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 236 */           pstmt.setString(22, null);
/*     */         else {
/* 238 */           pstmt.setString(22, get(i).getState());
/*     */         }
/* 240 */         if ((get(i).getUpReportContent() == null) || (get(i).getUpReportContent().equals("null")))
/* 241 */           pstmt.setString(23, null);
/*     */         else {
/* 243 */           pstmt.setString(23, get(i).getUpReportContent());
/*     */         }
/* 245 */         if ((get(i).getHealthFlag() == null) || (get(i).getHealthFlag().equals("null")))
/* 246 */           pstmt.setString(24, null);
/*     */         else {
/* 248 */           pstmt.setString(24, get(i).getHealthFlag());
/*     */         }
/* 250 */         if ((get(i).getQuesFlag() == null) || (get(i).getQuesFlag().equals("null")))
/* 251 */           pstmt.setString(25, null);
/*     */         else {
/* 253 */           pstmt.setString(25, get(i).getQuesFlag());
/*     */         }
/* 255 */         if ((get(i).getSpecFlag() == null) || (get(i).getSpecFlag().equals("null")))
/* 256 */           pstmt.setString(26, null);
/*     */         else {
/* 258 */           pstmt.setString(26, get(i).getSpecFlag());
/*     */         }
/* 260 */         if ((get(i).getAddPremFlag() == null) || (get(i).getAddPremFlag().equals("null")))
/* 261 */           pstmt.setString(27, null);
/*     */         else {
/* 263 */           pstmt.setString(27, get(i).getAddPremFlag());
/*     */         }
/* 265 */         if ((get(i).getAddPremReason() == null) || (get(i).getAddPremReason().equals("null")))
/* 266 */           pstmt.setString(28, null);
/*     */         else {
/* 268 */           pstmt.setString(28, get(i).getAddPremReason());
/*     */         }
/* 270 */         if ((get(i).getReportFlag() == null) || (get(i).getReportFlag().equals("null")))
/* 271 */           pstmt.setString(29, null);
/*     */         else {
/* 273 */           pstmt.setString(29, get(i).getReportFlag());
/*     */         }
/* 275 */         if ((get(i).getSpecReason() == null) || (get(i).getSpecReason().equals("null")))
/* 276 */           pstmt.setString(30, null);
/*     */         else {
/* 278 */           pstmt.setString(30, get(i).getSpecReason());
/*     */         }
/* 280 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 281 */           pstmt.setString(31, null);
/*     */         else {
/* 283 */           pstmt.setString(31, get(i).getOperator());
/*     */         }
/* 285 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 286 */           pstmt.setDate(32, null);
/*     */         else {
/* 288 */           pstmt.setDate(32, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 290 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 291 */           pstmt.setString(33, null);
/*     */         else {
/* 293 */           pstmt.setString(33, get(i).getMakeTime());
/*     */         }
/* 295 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 296 */           pstmt.setDate(34, null);
/*     */         else {
/* 298 */           pstmt.setDate(34, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 300 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 301 */           pstmt.setString(35, null);
/*     */         else {
/* 303 */           pstmt.setString(35, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 306 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 307 */           pstmt.setString(36, null);
/*     */         else {
/* 309 */           pstmt.setString(36, get(i).getContNo());
/*     */         }
/* 311 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/* 312 */           pstmt.setString(37, null);
/*     */         else {
/* 314 */           pstmt.setString(37, get(i).getInsuredId());
/*     */         }
/* 316 */         pstmt.addBatch();
/*     */       }
/* 318 */       pstmt.executeBatch();
/* 319 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 322 */       ex.printStackTrace();
/* 323 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 324 */       CError tError = new CError();
/* 325 */       tError.moduleName = "LNPIndUWMasterDBSet";
/* 326 */       tError.functionName = "update()";
/* 327 */       tError.errorMessage = ex.toString();
/* 328 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 331 */         pstmt.close(); } catch (Exception e) {
/* 332 */         e.printStackTrace();
/*     */       }
/* 334 */       if (!this.mflag) {
/*     */         try {
/* 336 */           this.con.close(); } catch (Exception e) {
/* 337 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 340 */       return false;
/*     */     }
/*     */ 
/* 343 */     if (!this.mflag) {
/*     */       try {
/* 345 */         this.con.close(); } catch (Exception e) {
/* 346 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 349 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 355 */     PreparedStatement pstmt = null;
/*     */ 
/* 357 */     if (!this.mflag) {
/* 358 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 363 */       int tCount = size();
/* 364 */       pstmt = this.con.prepareStatement("INSERT INTO LNPIndUWMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 365 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 367 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 368 */           pstmt.setString(1, null);
/*     */         else {
/* 370 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 372 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 373 */           pstmt.setString(2, null);
/*     */         else {
/* 375 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 377 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 378 */           pstmt.setString(3, null);
/*     */         else {
/* 380 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 382 */         pstmt.setInt(4, get(i).getUWNo());
/* 383 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 384 */           pstmt.setString(5, null);
/*     */         else {
/* 386 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 388 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/* 389 */           pstmt.setString(6, null);
/*     */         else {
/* 391 */           pstmt.setString(6, get(i).getInsuredId());
/*     */         }
/* 393 */         if ((get(i).getInsuredNo() == null) || (get(i).getInsuredNo().equals("null")))
/* 394 */           pstmt.setString(7, null);
/*     */         else {
/* 396 */           pstmt.setString(7, get(i).getInsuredNo());
/*     */         }
/* 398 */         if ((get(i).getInsuredName() == null) || (get(i).getInsuredName().equals("null")))
/* 399 */           pstmt.setString(8, null);
/*     */         else {
/* 401 */           pstmt.setString(8, get(i).getInsuredName());
/*     */         }
/* 403 */         if ((get(i).getFlagCaseDcl() == null) || (get(i).getFlagCaseDcl().equals("null")))
/* 404 */           pstmt.setString(9, null);
/*     */         else {
/* 406 */           pstmt.setString(9, get(i).getFlagCaseDcl());
/*     */         }
/* 408 */         if ((get(i).getHighFaceAmount() == null) || (get(i).getHighFaceAmount().equals("null")))
/* 409 */           pstmt.setString(10, null);
/*     */         else {
/* 411 */           pstmt.setString(10, get(i).getHighFaceAmount());
/*     */         }
/* 413 */         if ((get(i).getUWMessages() == null) || (get(i).getUWMessages().equals("null")))
/* 414 */           pstmt.setString(11, null);
/*     */         else {
/* 416 */           pstmt.setString(11, get(i).getUWMessages());
/*     */         }
/* 418 */         if ((get(i).getAppntId() == null) || (get(i).getAppntId().equals("null")))
/* 419 */           pstmt.setString(12, null);
/*     */         else {
/* 421 */           pstmt.setString(12, get(i).getAppntId());
/*     */         }
/* 423 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/* 424 */           pstmt.setString(13, null);
/*     */         else {
/* 426 */           pstmt.setString(13, get(i).getAppntNo());
/*     */         }
/* 428 */         if ((get(i).getAppntName() == null) || (get(i).getAppntName().equals("null")))
/* 429 */           pstmt.setString(14, null);
/*     */         else {
/* 431 */           pstmt.setString(14, get(i).getAppntName());
/*     */         }
/* 433 */         if ((get(i).getPassFlag() == null) || (get(i).getPassFlag().equals("null")))
/* 434 */           pstmt.setString(15, null);
/*     */         else {
/* 436 */           pstmt.setString(15, get(i).getPassFlag());
/*     */         }
/* 438 */         if ((get(i).getUWIdea() == null) || (get(i).getUWIdea().equals("null")))
/* 439 */           pstmt.setString(16, null);
/*     */         else {
/* 441 */           pstmt.setString(16, get(i).getUWIdea());
/*     */         }
/* 443 */         if ((get(i).getUWGrade() == null) || (get(i).getUWGrade().equals("null")))
/* 444 */           pstmt.setString(17, null);
/*     */         else {
/* 446 */           pstmt.setString(17, get(i).getUWGrade());
/*     */         }
/* 448 */         if ((get(i).getAppGrade() == null) || (get(i).getAppGrade().equals("null")))
/* 449 */           pstmt.setString(18, null);
/*     */         else {
/* 451 */           pstmt.setString(18, get(i).getAppGrade());
/*     */         }
/* 453 */         if ((get(i).getPostponeDay() == null) || (get(i).getPostponeDay().equals("null")))
/* 454 */           pstmt.setString(19, null);
/*     */         else {
/* 456 */           pstmt.setString(19, get(i).getPostponeDay());
/*     */         }
/* 458 */         if ((get(i).getPostponeDate() == null) || (get(i).getPostponeDate().equals("null")))
/* 459 */           pstmt.setDate(20, null);
/*     */         else {
/* 461 */           pstmt.setDate(20, Date.valueOf(get(i).getPostponeDate()));
/*     */         }
/* 463 */         if ((get(i).getAutoUWFlag() == null) || (get(i).getAutoUWFlag().equals("null")))
/* 464 */           pstmt.setString(21, null);
/*     */         else {
/* 466 */           pstmt.setString(21, get(i).getAutoUWFlag());
/*     */         }
/* 468 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 469 */           pstmt.setString(22, null);
/*     */         else {
/* 471 */           pstmt.setString(22, get(i).getState());
/*     */         }
/* 473 */         if ((get(i).getUpReportContent() == null) || (get(i).getUpReportContent().equals("null")))
/* 474 */           pstmt.setString(23, null);
/*     */         else {
/* 476 */           pstmt.setString(23, get(i).getUpReportContent());
/*     */         }
/* 478 */         if ((get(i).getHealthFlag() == null) || (get(i).getHealthFlag().equals("null")))
/* 479 */           pstmt.setString(24, null);
/*     */         else {
/* 481 */           pstmt.setString(24, get(i).getHealthFlag());
/*     */         }
/* 483 */         if ((get(i).getQuesFlag() == null) || (get(i).getQuesFlag().equals("null")))
/* 484 */           pstmt.setString(25, null);
/*     */         else {
/* 486 */           pstmt.setString(25, get(i).getQuesFlag());
/*     */         }
/* 488 */         if ((get(i).getSpecFlag() == null) || (get(i).getSpecFlag().equals("null")))
/* 489 */           pstmt.setString(26, null);
/*     */         else {
/* 491 */           pstmt.setString(26, get(i).getSpecFlag());
/*     */         }
/* 493 */         if ((get(i).getAddPremFlag() == null) || (get(i).getAddPremFlag().equals("null")))
/* 494 */           pstmt.setString(27, null);
/*     */         else {
/* 496 */           pstmt.setString(27, get(i).getAddPremFlag());
/*     */         }
/* 498 */         if ((get(i).getAddPremReason() == null) || (get(i).getAddPremReason().equals("null")))
/* 499 */           pstmt.setString(28, null);
/*     */         else {
/* 501 */           pstmt.setString(28, get(i).getAddPremReason());
/*     */         }
/* 503 */         if ((get(i).getReportFlag() == null) || (get(i).getReportFlag().equals("null")))
/* 504 */           pstmt.setString(29, null);
/*     */         else {
/* 506 */           pstmt.setString(29, get(i).getReportFlag());
/*     */         }
/* 508 */         if ((get(i).getSpecReason() == null) || (get(i).getSpecReason().equals("null")))
/* 509 */           pstmt.setString(30, null);
/*     */         else {
/* 511 */           pstmt.setString(30, get(i).getSpecReason());
/*     */         }
/* 513 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 514 */           pstmt.setString(31, null);
/*     */         else {
/* 516 */           pstmt.setString(31, get(i).getOperator());
/*     */         }
/* 518 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 519 */           pstmt.setDate(32, null);
/*     */         else {
/* 521 */           pstmt.setDate(32, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 523 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 524 */           pstmt.setString(33, null);
/*     */         else {
/* 526 */           pstmt.setString(33, get(i).getMakeTime());
/*     */         }
/* 528 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 529 */           pstmt.setDate(34, null);
/*     */         else {
/* 531 */           pstmt.setDate(34, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 533 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 534 */           pstmt.setString(35, null);
/*     */         else {
/* 536 */           pstmt.setString(35, get(i).getModifyTime());
/*     */         }
/* 538 */         pstmt.addBatch();
/*     */       }
/* 540 */       pstmt.executeBatch();
/* 541 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 544 */       ex.printStackTrace();
/* 545 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 546 */       CError tError = new CError();
/* 547 */       tError.moduleName = "LNPIndUWMasterDBSet";
/* 548 */       tError.functionName = "insert()";
/* 549 */       tError.errorMessage = ex.toString();
/* 550 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 553 */         pstmt.close(); } catch (Exception e) {
/* 554 */         e.printStackTrace();
/*     */       }
/* 556 */       if (!this.mflag) {
/*     */         try {
/* 558 */           this.con.close(); } catch (Exception e) {
/* 559 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 562 */       return false;
/*     */     }
/*     */ 
/* 565 */     if (!this.mflag) {
/*     */       try {
/* 567 */         this.con.close(); } catch (Exception e) {
/* 568 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 571 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPIndUWMasterDBSet
 * JD-Core Version:    0.6.0
 */