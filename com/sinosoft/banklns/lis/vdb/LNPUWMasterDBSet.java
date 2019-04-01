/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPUWMasterSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPUWMasterSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPUWMasterDBSet extends LNPUWMasterSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPUWMasterDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPUWMaster");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPUWMasterDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPUWMaster");
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
/*  50 */     tError.moduleName = "LNPUWMasterDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPUWMaster WHERE  PolNo = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getPolNo());
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
/*  87 */       tError.moduleName = "LNPUWMasterDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPUWMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PolNo = ? , ProposalNo = ? , UWNo = ? , InsuredNo = ? , InsuredName = ? , AppntNo = ? , AppntName = ? , PlanCode = ? , PlanName = ? , RiderName = ? , RiderCode = ? , UWDid = ? , FaceAmount = ? , Term = ? , HealthDeb = ? , HealthFe = ? , HealthFed = ? , OccupationFactor = ? , OccupationFe = ? , OccupationFed = ? , Exclusions = ? , DeclinedCode = ? , DeclinedReason = ? , PassFlag = ? , UWIdea = ? , UWGrade = ? , AppGrade = ? , PostponeDay = ? , PostponeDate = ? , AutoUWFlag = ? , State = ? , ManageCom = ? , UpReportContent = ? , Operator = ? , HealthFlag = ? , QuesFlag = ? , SpecFlag = ? , AddPremFlag = ? , AddPremReason = ? , ReportFlag = ? , PrintFlag = ? , PrintFlag2 = ? , ChangePolFlag = ? , ChangePolReason = ? , SpecReason = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , SugPassFlag = ? , SugUWIdea = ? WHERE  PolNo = ?");
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
/* 144 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getPolNo());
/*     */         }
/* 149 */         if ((get(i).getProposalNo() == null) || (get(i).getProposalNo().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getProposalNo());
/*     */         }
/* 154 */         pstmt.setInt(6, get(i).getUWNo());
/* 155 */         if ((get(i).getInsuredNo() == null) || (get(i).getInsuredNo().equals("null")))
/* 156 */           pstmt.setString(7, null);
/*     */         else {
/* 158 */           pstmt.setString(7, get(i).getInsuredNo());
/*     */         }
/* 160 */         if ((get(i).getInsuredName() == null) || (get(i).getInsuredName().equals("null")))
/* 161 */           pstmt.setString(8, null);
/*     */         else {
/* 163 */           pstmt.setString(8, get(i).getInsuredName());
/*     */         }
/* 165 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/* 166 */           pstmt.setString(9, null);
/*     */         else {
/* 168 */           pstmt.setString(9, get(i).getAppntNo());
/*     */         }
/* 170 */         if ((get(i).getAppntName() == null) || (get(i).getAppntName().equals("null")))
/* 171 */           pstmt.setString(10, null);
/*     */         else {
/* 173 */           pstmt.setString(10, get(i).getAppntName());
/*     */         }
/* 175 */         if ((get(i).getPlanCode() == null) || (get(i).getPlanCode().equals("null")))
/* 176 */           pstmt.setString(11, null);
/*     */         else {
/* 178 */           pstmt.setString(11, get(i).getPlanCode());
/*     */         }
/* 180 */         if ((get(i).getPlanName() == null) || (get(i).getPlanName().equals("null")))
/* 181 */           pstmt.setString(12, null);
/*     */         else {
/* 183 */           pstmt.setString(12, get(i).getPlanName());
/*     */         }
/* 185 */         if ((get(i).getRiderName() == null) || (get(i).getRiderName().equals("null")))
/* 186 */           pstmt.setString(13, null);
/*     */         else {
/* 188 */           pstmt.setString(13, get(i).getRiderName());
/*     */         }
/* 190 */         if ((get(i).getRiderCode() == null) || (get(i).getRiderCode().equals("null")))
/* 191 */           pstmt.setString(14, null);
/*     */         else {
/* 193 */           pstmt.setString(14, get(i).getRiderCode());
/*     */         }
/* 195 */         if ((get(i).getUWDid() == null) || (get(i).getUWDid().equals("null")))
/* 196 */           pstmt.setString(15, null);
/*     */         else {
/* 198 */           pstmt.setString(15, get(i).getUWDid());
/*     */         }
/* 200 */         if ((get(i).getFaceAmount() == null) || (get(i).getFaceAmount().equals("null")))
/* 201 */           pstmt.setString(16, null);
/*     */         else {
/* 203 */           pstmt.setString(16, get(i).getFaceAmount());
/*     */         }
/* 205 */         if ((get(i).getTerm() == null) || (get(i).getTerm().equals("null")))
/* 206 */           pstmt.setString(17, null);
/*     */         else {
/* 208 */           pstmt.setString(17, get(i).getTerm());
/*     */         }
/* 210 */         if ((get(i).getHealthDeb() == null) || (get(i).getHealthDeb().equals("null")))
/* 211 */           pstmt.setString(18, null);
/*     */         else {
/* 213 */           pstmt.setString(18, get(i).getHealthDeb());
/*     */         }
/* 215 */         if ((get(i).getHealthFe() == null) || (get(i).getHealthFe().equals("null")))
/* 216 */           pstmt.setString(19, null);
/*     */         else {
/* 218 */           pstmt.setString(19, get(i).getHealthFe());
/*     */         }
/* 220 */         if ((get(i).getHealthFed() == null) || (get(i).getHealthFed().equals("null")))
/* 221 */           pstmt.setString(20, null);
/*     */         else {
/* 223 */           pstmt.setString(20, get(i).getHealthFed());
/*     */         }
/* 225 */         if ((get(i).getOccupationFactor() == null) || (get(i).getOccupationFactor().equals("null")))
/* 226 */           pstmt.setString(21, null);
/*     */         else {
/* 228 */           pstmt.setString(21, get(i).getOccupationFactor());
/*     */         }
/* 230 */         if ((get(i).getOccupationFe() == null) || (get(i).getOccupationFe().equals("null")))
/* 231 */           pstmt.setString(22, null);
/*     */         else {
/* 233 */           pstmt.setString(22, get(i).getOccupationFe());
/*     */         }
/* 235 */         if ((get(i).getOccupationFed() == null) || (get(i).getOccupationFed().equals("null")))
/* 236 */           pstmt.setString(23, null);
/*     */         else {
/* 238 */           pstmt.setString(23, get(i).getOccupationFed());
/*     */         }
/* 240 */         if ((get(i).getExclusions() == null) || (get(i).getExclusions().equals("null")))
/* 241 */           pstmt.setString(24, null);
/*     */         else {
/* 243 */           pstmt.setString(24, get(i).getExclusions());
/*     */         }
/* 245 */         if ((get(i).getDeclinedCode() == null) || (get(i).getDeclinedCode().equals("null")))
/* 246 */           pstmt.setString(25, null);
/*     */         else {
/* 248 */           pstmt.setString(25, get(i).getDeclinedCode());
/*     */         }
/* 250 */         if ((get(i).getDeclinedReason() == null) || (get(i).getDeclinedReason().equals("null")))
/* 251 */           pstmt.setString(26, null);
/*     */         else {
/* 253 */           pstmt.setString(26, get(i).getDeclinedReason());
/*     */         }
/* 255 */         if ((get(i).getPassFlag() == null) || (get(i).getPassFlag().equals("null")))
/* 256 */           pstmt.setString(27, null);
/*     */         else {
/* 258 */           pstmt.setString(27, get(i).getPassFlag());
/*     */         }
/* 260 */         if ((get(i).getUWIdea() == null) || (get(i).getUWIdea().equals("null")))
/* 261 */           pstmt.setString(28, null);
/*     */         else {
/* 263 */           pstmt.setString(28, get(i).getUWIdea());
/*     */         }
/* 265 */         if ((get(i).getUWGrade() == null) || (get(i).getUWGrade().equals("null")))
/* 266 */           pstmt.setString(29, null);
/*     */         else {
/* 268 */           pstmt.setString(29, get(i).getUWGrade());
/*     */         }
/* 270 */         if ((get(i).getAppGrade() == null) || (get(i).getAppGrade().equals("null")))
/* 271 */           pstmt.setString(30, null);
/*     */         else {
/* 273 */           pstmt.setString(30, get(i).getAppGrade());
/*     */         }
/* 275 */         if ((get(i).getPostponeDay() == null) || (get(i).getPostponeDay().equals("null")))
/* 276 */           pstmt.setString(31, null);
/*     */         else {
/* 278 */           pstmt.setString(31, get(i).getPostponeDay());
/*     */         }
/* 280 */         if ((get(i).getPostponeDate() == null) || (get(i).getPostponeDate().equals("null")))
/* 281 */           pstmt.setDate(32, null);
/*     */         else {
/* 283 */           pstmt.setDate(32, Date.valueOf(get(i).getPostponeDate()));
/*     */         }
/* 285 */         if ((get(i).getAutoUWFlag() == null) || (get(i).getAutoUWFlag().equals("null")))
/* 286 */           pstmt.setString(33, null);
/*     */         else {
/* 288 */           pstmt.setString(33, get(i).getAutoUWFlag());
/*     */         }
/* 290 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 291 */           pstmt.setString(34, null);
/*     */         else {
/* 293 */           pstmt.setString(34, get(i).getState());
/*     */         }
/* 295 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 296 */           pstmt.setString(35, null);
/*     */         else {
/* 298 */           pstmt.setString(35, get(i).getManageCom());
/*     */         }
/* 300 */         if ((get(i).getUpReportContent() == null) || (get(i).getUpReportContent().equals("null")))
/* 301 */           pstmt.setString(36, null);
/*     */         else {
/* 303 */           pstmt.setString(36, get(i).getUpReportContent());
/*     */         }
/* 305 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 306 */           pstmt.setString(37, null);
/*     */         else {
/* 308 */           pstmt.setString(37, get(i).getOperator());
/*     */         }
/* 310 */         if ((get(i).getHealthFlag() == null) || (get(i).getHealthFlag().equals("null")))
/* 311 */           pstmt.setString(38, null);
/*     */         else {
/* 313 */           pstmt.setString(38, get(i).getHealthFlag());
/*     */         }
/* 315 */         if ((get(i).getQuesFlag() == null) || (get(i).getQuesFlag().equals("null")))
/* 316 */           pstmt.setString(39, null);
/*     */         else {
/* 318 */           pstmt.setString(39, get(i).getQuesFlag());
/*     */         }
/* 320 */         if ((get(i).getSpecFlag() == null) || (get(i).getSpecFlag().equals("null")))
/* 321 */           pstmt.setString(40, null);
/*     */         else {
/* 323 */           pstmt.setString(40, get(i).getSpecFlag());
/*     */         }
/* 325 */         if ((get(i).getAddPremFlag() == null) || (get(i).getAddPremFlag().equals("null")))
/* 326 */           pstmt.setString(41, null);
/*     */         else {
/* 328 */           pstmt.setString(41, get(i).getAddPremFlag());
/*     */         }
/* 330 */         if ((get(i).getAddPremReason() == null) || (get(i).getAddPremReason().equals("null")))
/* 331 */           pstmt.setString(42, null);
/*     */         else {
/* 333 */           pstmt.setString(42, get(i).getAddPremReason());
/*     */         }
/* 335 */         if ((get(i).getReportFlag() == null) || (get(i).getReportFlag().equals("null")))
/* 336 */           pstmt.setString(43, null);
/*     */         else {
/* 338 */           pstmt.setString(43, get(i).getReportFlag());
/*     */         }
/* 340 */         if ((get(i).getPrintFlag() == null) || (get(i).getPrintFlag().equals("null")))
/* 341 */           pstmt.setString(44, null);
/*     */         else {
/* 343 */           pstmt.setString(44, get(i).getPrintFlag());
/*     */         }
/* 345 */         if ((get(i).getPrintFlag2() == null) || (get(i).getPrintFlag2().equals("null")))
/* 346 */           pstmt.setString(45, null);
/*     */         else {
/* 348 */           pstmt.setString(45, get(i).getPrintFlag2());
/*     */         }
/* 350 */         if ((get(i).getChangePolFlag() == null) || (get(i).getChangePolFlag().equals("null")))
/* 351 */           pstmt.setString(46, null);
/*     */         else {
/* 353 */           pstmt.setString(46, get(i).getChangePolFlag());
/*     */         }
/* 355 */         if ((get(i).getChangePolReason() == null) || (get(i).getChangePolReason().equals("null")))
/* 356 */           pstmt.setString(47, null);
/*     */         else {
/* 358 */           pstmt.setString(47, get(i).getChangePolReason());
/*     */         }
/* 360 */         if ((get(i).getSpecReason() == null) || (get(i).getSpecReason().equals("null")))
/* 361 */           pstmt.setString(48, null);
/*     */         else {
/* 363 */           pstmt.setString(48, get(i).getSpecReason());
/*     */         }
/* 365 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 366 */           pstmt.setDate(49, null);
/*     */         else {
/* 368 */           pstmt.setDate(49, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 370 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 371 */           pstmt.setString(50, null);
/*     */         else {
/* 373 */           pstmt.setString(50, get(i).getMakeTime());
/*     */         }
/* 375 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 376 */           pstmt.setDate(51, null);
/*     */         else {
/* 378 */           pstmt.setDate(51, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 380 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 381 */           pstmt.setString(52, null);
/*     */         else {
/* 383 */           pstmt.setString(52, get(i).getModifyTime());
/*     */         }
/* 385 */         if ((get(i).getSugPassFlag() == null) || (get(i).getSugPassFlag().equals("null")))
/* 386 */           pstmt.setString(53, null);
/*     */         else {
/* 388 */           pstmt.setString(53, get(i).getSugPassFlag());
/*     */         }
/* 390 */         if ((get(i).getSugUWIdea() == null) || (get(i).getSugUWIdea().equals("null")))
/* 391 */           pstmt.setString(54, null);
/*     */         else {
/* 393 */           pstmt.setString(54, get(i).getSugUWIdea());
/*     */         }
/*     */ 
/* 396 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/* 397 */           pstmt.setString(55, null);
/*     */         else {
/* 399 */           pstmt.setString(55, get(i).getPolNo());
/*     */         }
/* 401 */         pstmt.addBatch();
/*     */       }
/* 403 */       pstmt.executeBatch();
/* 404 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 407 */       ex.printStackTrace();
/* 408 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 409 */       CError tError = new CError();
/* 410 */       tError.moduleName = "LNPUWMasterDBSet";
/* 411 */       tError.functionName = "update()";
/* 412 */       tError.errorMessage = ex.toString();
/* 413 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 416 */         pstmt.close(); } catch (Exception e) {
/* 417 */         e.printStackTrace();
/*     */       }
/* 419 */       if (!this.mflag) {
/*     */         try {
/* 421 */           this.con.close(); } catch (Exception e) {
/* 422 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 425 */       return false;
/*     */     }
/*     */ 
/* 428 */     if (!this.mflag) {
/*     */       try {
/* 430 */         this.con.close(); } catch (Exception e) {
/* 431 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 434 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 440 */     PreparedStatement pstmt = null;
/*     */ 
/* 442 */     if (!this.mflag) {
/* 443 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 448 */       int tCount = size();
/* 449 */       pstmt = this.con.prepareStatement("INSERT INTO LNPUWMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 450 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 452 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 453 */           pstmt.setString(1, null);
/*     */         else {
/* 455 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 457 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 458 */           pstmt.setString(2, null);
/*     */         else {
/* 460 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 462 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 463 */           pstmt.setString(3, null);
/*     */         else {
/* 465 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 467 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/* 468 */           pstmt.setString(4, null);
/*     */         else {
/* 470 */           pstmt.setString(4, get(i).getPolNo());
/*     */         }
/* 472 */         if ((get(i).getProposalNo() == null) || (get(i).getProposalNo().equals("null")))
/* 473 */           pstmt.setString(5, null);
/*     */         else {
/* 475 */           pstmt.setString(5, get(i).getProposalNo());
/*     */         }
/* 477 */         pstmt.setInt(6, get(i).getUWNo());
/* 478 */         if ((get(i).getInsuredNo() == null) || (get(i).getInsuredNo().equals("null")))
/* 479 */           pstmt.setString(7, null);
/*     */         else {
/* 481 */           pstmt.setString(7, get(i).getInsuredNo());
/*     */         }
/* 483 */         if ((get(i).getInsuredName() == null) || (get(i).getInsuredName().equals("null")))
/* 484 */           pstmt.setString(8, null);
/*     */         else {
/* 486 */           pstmt.setString(8, get(i).getInsuredName());
/*     */         }
/* 488 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/* 489 */           pstmt.setString(9, null);
/*     */         else {
/* 491 */           pstmt.setString(9, get(i).getAppntNo());
/*     */         }
/* 493 */         if ((get(i).getAppntName() == null) || (get(i).getAppntName().equals("null")))
/* 494 */           pstmt.setString(10, null);
/*     */         else {
/* 496 */           pstmt.setString(10, get(i).getAppntName());
/*     */         }
/* 498 */         if ((get(i).getPlanCode() == null) || (get(i).getPlanCode().equals("null")))
/* 499 */           pstmt.setString(11, null);
/*     */         else {
/* 501 */           pstmt.setString(11, get(i).getPlanCode());
/*     */         }
/* 503 */         if ((get(i).getPlanName() == null) || (get(i).getPlanName().equals("null")))
/* 504 */           pstmt.setString(12, null);
/*     */         else {
/* 506 */           pstmt.setString(12, get(i).getPlanName());
/*     */         }
/* 508 */         if ((get(i).getRiderName() == null) || (get(i).getRiderName().equals("null")))
/* 509 */           pstmt.setString(13, null);
/*     */         else {
/* 511 */           pstmt.setString(13, get(i).getRiderName());
/*     */         }
/* 513 */         if ((get(i).getRiderCode() == null) || (get(i).getRiderCode().equals("null")))
/* 514 */           pstmt.setString(14, null);
/*     */         else {
/* 516 */           pstmt.setString(14, get(i).getRiderCode());
/*     */         }
/* 518 */         if ((get(i).getUWDid() == null) || (get(i).getUWDid().equals("null")))
/* 519 */           pstmt.setString(15, null);
/*     */         else {
/* 521 */           pstmt.setString(15, get(i).getUWDid());
/*     */         }
/* 523 */         if ((get(i).getFaceAmount() == null) || (get(i).getFaceAmount().equals("null")))
/* 524 */           pstmt.setString(16, null);
/*     */         else {
/* 526 */           pstmt.setString(16, get(i).getFaceAmount());
/*     */         }
/* 528 */         if ((get(i).getTerm() == null) || (get(i).getTerm().equals("null")))
/* 529 */           pstmt.setString(17, null);
/*     */         else {
/* 531 */           pstmt.setString(17, get(i).getTerm());
/*     */         }
/* 533 */         if ((get(i).getHealthDeb() == null) || (get(i).getHealthDeb().equals("null")))
/* 534 */           pstmt.setString(18, null);
/*     */         else {
/* 536 */           pstmt.setString(18, get(i).getHealthDeb());
/*     */         }
/* 538 */         if ((get(i).getHealthFe() == null) || (get(i).getHealthFe().equals("null")))
/* 539 */           pstmt.setString(19, null);
/*     */         else {
/* 541 */           pstmt.setString(19, get(i).getHealthFe());
/*     */         }
/* 543 */         if ((get(i).getHealthFed() == null) || (get(i).getHealthFed().equals("null")))
/* 544 */           pstmt.setString(20, null);
/*     */         else {
/* 546 */           pstmt.setString(20, get(i).getHealthFed());
/*     */         }
/* 548 */         if ((get(i).getOccupationFactor() == null) || (get(i).getOccupationFactor().equals("null")))
/* 549 */           pstmt.setString(21, null);
/*     */         else {
/* 551 */           pstmt.setString(21, get(i).getOccupationFactor());
/*     */         }
/* 553 */         if ((get(i).getOccupationFe() == null) || (get(i).getOccupationFe().equals("null")))
/* 554 */           pstmt.setString(22, null);
/*     */         else {
/* 556 */           pstmt.setString(22, get(i).getOccupationFe());
/*     */         }
/* 558 */         if ((get(i).getOccupationFed() == null) || (get(i).getOccupationFed().equals("null")))
/* 559 */           pstmt.setString(23, null);
/*     */         else {
/* 561 */           pstmt.setString(23, get(i).getOccupationFed());
/*     */         }
/* 563 */         if ((get(i).getExclusions() == null) || (get(i).getExclusions().equals("null")))
/* 564 */           pstmt.setString(24, null);
/*     */         else {
/* 566 */           pstmt.setString(24, get(i).getExclusions());
/*     */         }
/* 568 */         if ((get(i).getDeclinedCode() == null) || (get(i).getDeclinedCode().equals("null")))
/* 569 */           pstmt.setString(25, null);
/*     */         else {
/* 571 */           pstmt.setString(25, get(i).getDeclinedCode());
/*     */         }
/* 573 */         if ((get(i).getDeclinedReason() == null) || (get(i).getDeclinedReason().equals("null")))
/* 574 */           pstmt.setString(26, null);
/*     */         else {
/* 576 */           pstmt.setString(26, get(i).getDeclinedReason());
/*     */         }
/* 578 */         if ((get(i).getPassFlag() == null) || (get(i).getPassFlag().equals("null")))
/* 579 */           pstmt.setString(27, null);
/*     */         else {
/* 581 */           pstmt.setString(27, get(i).getPassFlag());
/*     */         }
/* 583 */         if ((get(i).getUWIdea() == null) || (get(i).getUWIdea().equals("null")))
/* 584 */           pstmt.setString(28, null);
/*     */         else {
/* 586 */           pstmt.setString(28, get(i).getUWIdea());
/*     */         }
/* 588 */         if ((get(i).getUWGrade() == null) || (get(i).getUWGrade().equals("null")))
/* 589 */           pstmt.setString(29, null);
/*     */         else {
/* 591 */           pstmt.setString(29, get(i).getUWGrade());
/*     */         }
/* 593 */         if ((get(i).getAppGrade() == null) || (get(i).getAppGrade().equals("null")))
/* 594 */           pstmt.setString(30, null);
/*     */         else {
/* 596 */           pstmt.setString(30, get(i).getAppGrade());
/*     */         }
/* 598 */         if ((get(i).getPostponeDay() == null) || (get(i).getPostponeDay().equals("null")))
/* 599 */           pstmt.setString(31, null);
/*     */         else {
/* 601 */           pstmt.setString(31, get(i).getPostponeDay());
/*     */         }
/* 603 */         if ((get(i).getPostponeDate() == null) || (get(i).getPostponeDate().equals("null")))
/* 604 */           pstmt.setDate(32, null);
/*     */         else {
/* 606 */           pstmt.setDate(32, Date.valueOf(get(i).getPostponeDate()));
/*     */         }
/* 608 */         if ((get(i).getAutoUWFlag() == null) || (get(i).getAutoUWFlag().equals("null")))
/* 609 */           pstmt.setString(33, null);
/*     */         else {
/* 611 */           pstmt.setString(33, get(i).getAutoUWFlag());
/*     */         }
/* 613 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 614 */           pstmt.setString(34, null);
/*     */         else {
/* 616 */           pstmt.setString(34, get(i).getState());
/*     */         }
/* 618 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 619 */           pstmt.setString(35, null);
/*     */         else {
/* 621 */           pstmt.setString(35, get(i).getManageCom());
/*     */         }
/* 623 */         if ((get(i).getUpReportContent() == null) || (get(i).getUpReportContent().equals("null")))
/* 624 */           pstmt.setString(36, null);
/*     */         else {
/* 626 */           pstmt.setString(36, get(i).getUpReportContent());
/*     */         }
/* 628 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 629 */           pstmt.setString(37, null);
/*     */         else {
/* 631 */           pstmt.setString(37, get(i).getOperator());
/*     */         }
/* 633 */         if ((get(i).getHealthFlag() == null) || (get(i).getHealthFlag().equals("null")))
/* 634 */           pstmt.setString(38, null);
/*     */         else {
/* 636 */           pstmt.setString(38, get(i).getHealthFlag());
/*     */         }
/* 638 */         if ((get(i).getQuesFlag() == null) || (get(i).getQuesFlag().equals("null")))
/* 639 */           pstmt.setString(39, null);
/*     */         else {
/* 641 */           pstmt.setString(39, get(i).getQuesFlag());
/*     */         }
/* 643 */         if ((get(i).getSpecFlag() == null) || (get(i).getSpecFlag().equals("null")))
/* 644 */           pstmt.setString(40, null);
/*     */         else {
/* 646 */           pstmt.setString(40, get(i).getSpecFlag());
/*     */         }
/* 648 */         if ((get(i).getAddPremFlag() == null) || (get(i).getAddPremFlag().equals("null")))
/* 649 */           pstmt.setString(41, null);
/*     */         else {
/* 651 */           pstmt.setString(41, get(i).getAddPremFlag());
/*     */         }
/* 653 */         if ((get(i).getAddPremReason() == null) || (get(i).getAddPremReason().equals("null")))
/* 654 */           pstmt.setString(42, null);
/*     */         else {
/* 656 */           pstmt.setString(42, get(i).getAddPremReason());
/*     */         }
/* 658 */         if ((get(i).getReportFlag() == null) || (get(i).getReportFlag().equals("null")))
/* 659 */           pstmt.setString(43, null);
/*     */         else {
/* 661 */           pstmt.setString(43, get(i).getReportFlag());
/*     */         }
/* 663 */         if ((get(i).getPrintFlag() == null) || (get(i).getPrintFlag().equals("null")))
/* 664 */           pstmt.setString(44, null);
/*     */         else {
/* 666 */           pstmt.setString(44, get(i).getPrintFlag());
/*     */         }
/* 668 */         if ((get(i).getPrintFlag2() == null) || (get(i).getPrintFlag2().equals("null")))
/* 669 */           pstmt.setString(45, null);
/*     */         else {
/* 671 */           pstmt.setString(45, get(i).getPrintFlag2());
/*     */         }
/* 673 */         if ((get(i).getChangePolFlag() == null) || (get(i).getChangePolFlag().equals("null")))
/* 674 */           pstmt.setString(46, null);
/*     */         else {
/* 676 */           pstmt.setString(46, get(i).getChangePolFlag());
/*     */         }
/* 678 */         if ((get(i).getChangePolReason() == null) || (get(i).getChangePolReason().equals("null")))
/* 679 */           pstmt.setString(47, null);
/*     */         else {
/* 681 */           pstmt.setString(47, get(i).getChangePolReason());
/*     */         }
/* 683 */         if ((get(i).getSpecReason() == null) || (get(i).getSpecReason().equals("null")))
/* 684 */           pstmt.setString(48, null);
/*     */         else {
/* 686 */           pstmt.setString(48, get(i).getSpecReason());
/*     */         }
/* 688 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 689 */           pstmt.setDate(49, null);
/*     */         else {
/* 691 */           pstmt.setDate(49, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 693 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 694 */           pstmt.setString(50, null);
/*     */         else {
/* 696 */           pstmt.setString(50, get(i).getMakeTime());
/*     */         }
/* 698 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 699 */           pstmt.setDate(51, null);
/*     */         else {
/* 701 */           pstmt.setDate(51, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 703 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 704 */           pstmt.setString(52, null);
/*     */         else {
/* 706 */           pstmt.setString(52, get(i).getModifyTime());
/*     */         }
/* 708 */         if ((get(i).getSugPassFlag() == null) || (get(i).getSugPassFlag().equals("null")))
/* 709 */           pstmt.setString(53, null);
/*     */         else {
/* 711 */           pstmt.setString(53, get(i).getSugPassFlag());
/*     */         }
/* 713 */         if ((get(i).getSugUWIdea() == null) || (get(i).getSugUWIdea().equals("null")))
/* 714 */           pstmt.setString(54, null);
/*     */         else {
/* 716 */           pstmt.setString(54, get(i).getSugUWIdea());
/*     */         }
/* 718 */         pstmt.addBatch();
/*     */       }
/* 720 */       pstmt.executeBatch();
/* 721 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 724 */       ex.printStackTrace();
/* 725 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 726 */       CError tError = new CError();
/* 727 */       tError.moduleName = "LNPUWMasterDBSet";
/* 728 */       tError.functionName = "insert()";
/* 729 */       tError.errorMessage = ex.toString();
/* 730 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 733 */         pstmt.close(); } catch (Exception e) {
/* 734 */         e.printStackTrace();
/*     */       }
/* 736 */       if (!this.mflag) {
/*     */         try {
/* 738 */           this.con.close(); } catch (Exception e) {
/* 739 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 742 */       return false;
/*     */     }
/*     */ 
/* 745 */     if (!this.mflag) {
/*     */       try {
/* 747 */         this.con.close(); } catch (Exception e) {
/* 748 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 751 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPUWMasterDBSet
 * JD-Core Version:    0.6.0
 */