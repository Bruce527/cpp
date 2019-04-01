/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPUWMasterSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPUWMasterSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import com.sinosoft.banklns.utility.SQLString;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class LNPUWMasterDB extends LNPUWMasterSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   22 */   private boolean mflag = false;
/*      */ 
/*   24 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   27 */   private ResultSet mResultSet = null;
/*   28 */   private Statement mStatement = null;
/*      */ 
/*      */   public LNPUWMasterDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPUWMaster");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPUWMasterDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPUWMaster");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPUWMasterSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPUWMasterDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPUWMasterSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPUWMasterDB";
/*   76 */       tError.functionName = "getCount";
/*   77 */       tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   78 */       this.mErrors.addOneError(tError);
/*      */ 
/*   80 */       return -1;
/*      */     }
/*      */ 
/*   83 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   88 */     PreparedStatement pstmt = null;
/*      */ 
/*   90 */     if (!this.mflag) {
/*   91 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPUWMaster WHERE  PolNo = ?");
/*   97 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getPolNo());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPUWMasterDB";
/*  109 */       tError.functionName = "delete()";
/*  110 */       tError.errorMessage = ex.toString();
/*  111 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  114 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  117 */       if (!this.mflag)
/*      */         try {
/*  119 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  123 */       return false;
/*      */     }
/*      */ 
/*  126 */     if (!this.mflag)
/*      */       try {
/*  128 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  132 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  137 */     PreparedStatement pstmt = null;
/*      */ 
/*  139 */     if (!this.mflag) {
/*  140 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPUWMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PolNo = ? , ProposalNo = ? , UWNo = ? , InsuredNo = ? , InsuredName = ? , AppntNo = ? , AppntName = ? , PlanCode = ? , PlanName = ? , RiderName = ? , RiderCode = ? , UWDid = ? , FaceAmount = ? , Term = ? , HealthDeb = ? , HealthFe = ? , HealthFed = ? , OccupationFactor = ? , OccupationFe = ? , OccupationFed = ? , Exclusions = ? , DeclinedCode = ? , DeclinedReason = ? , PassFlag = ? , UWIdea = ? , UWGrade = ? , AppGrade = ? , PostponeDay = ? , PostponeDate = ? , AutoUWFlag = ? , State = ? , ManageCom = ? , UpReportContent = ? , Operator = ? , HealthFlag = ? , QuesFlag = ? , SpecFlag = ? , AddPremFlag = ? , AddPremReason = ? , ReportFlag = ? , PrintFlag = ? , PrintFlag2 = ? , ChangePolFlag = ? , ChangePolReason = ? , SpecReason = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , SugPassFlag = ? , SugUWIdea = ? WHERE  PolNo = ?");
/*  146 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  151 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getContNo());
/*      */       }
/*  156 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  161 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getPolNo());
/*      */       }
/*  166 */       if ((getProposalNo() == null) || (getProposalNo().equals("null")))
/*  167 */         pstmt.setNull(5, 12);
/*      */       else {
/*  169 */         pstmt.setString(5, getProposalNo());
/*      */       }
/*  171 */       pstmt.setInt(6, getUWNo());
/*  172 */       if ((getInsuredNo() == null) || (getInsuredNo().equals("null")))
/*  173 */         pstmt.setNull(7, 12);
/*      */       else {
/*  175 */         pstmt.setString(7, getInsuredNo());
/*      */       }
/*  177 */       if ((getInsuredName() == null) || (getInsuredName().equals("null")))
/*  178 */         pstmt.setNull(8, 12);
/*      */       else {
/*  180 */         pstmt.setString(8, getInsuredName());
/*      */       }
/*  182 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  183 */         pstmt.setNull(9, 12);
/*      */       else {
/*  185 */         pstmt.setString(9, getAppntNo());
/*      */       }
/*  187 */       if ((getAppntName() == null) || (getAppntName().equals("null")))
/*  188 */         pstmt.setNull(10, 12);
/*      */       else {
/*  190 */         pstmt.setString(10, getAppntName());
/*      */       }
/*  192 */       if ((getPlanCode() == null) || (getPlanCode().equals("null")))
/*  193 */         pstmt.setNull(11, 12);
/*      */       else {
/*  195 */         pstmt.setString(11, getPlanCode());
/*      */       }
/*  197 */       if ((getPlanName() == null) || (getPlanName().equals("null")))
/*  198 */         pstmt.setNull(12, 12);
/*      */       else {
/*  200 */         pstmt.setString(12, getPlanName());
/*      */       }
/*  202 */       if ((getRiderName() == null) || (getRiderName().equals("null")))
/*  203 */         pstmt.setNull(13, 12);
/*      */       else {
/*  205 */         pstmt.setString(13, getRiderName());
/*      */       }
/*  207 */       if ((getRiderCode() == null) || (getRiderCode().equals("null")))
/*  208 */         pstmt.setNull(14, 12);
/*      */       else {
/*  210 */         pstmt.setString(14, getRiderCode());
/*      */       }
/*  212 */       if ((getUWDid() == null) || (getUWDid().equals("null")))
/*  213 */         pstmt.setNull(15, 12);
/*      */       else {
/*  215 */         pstmt.setString(15, getUWDid());
/*      */       }
/*  217 */       if ((getFaceAmount() == null) || (getFaceAmount().equals("null")))
/*  218 */         pstmt.setNull(16, 12);
/*      */       else {
/*  220 */         pstmt.setString(16, getFaceAmount());
/*      */       }
/*  222 */       if ((getTerm() == null) || (getTerm().equals("null")))
/*  223 */         pstmt.setNull(17, 12);
/*      */       else {
/*  225 */         pstmt.setString(17, getTerm());
/*      */       }
/*  227 */       if ((getHealthDeb() == null) || (getHealthDeb().equals("null")))
/*  228 */         pstmt.setNull(18, 12);
/*      */       else {
/*  230 */         pstmt.setString(18, getHealthDeb());
/*      */       }
/*  232 */       if ((getHealthFe() == null) || (getHealthFe().equals("null")))
/*  233 */         pstmt.setNull(19, 12);
/*      */       else {
/*  235 */         pstmt.setString(19, getHealthFe());
/*      */       }
/*  237 */       if ((getHealthFed() == null) || (getHealthFed().equals("null")))
/*  238 */         pstmt.setNull(20, 12);
/*      */       else {
/*  240 */         pstmt.setString(20, getHealthFed());
/*      */       }
/*  242 */       if ((getOccupationFactor() == null) || (getOccupationFactor().equals("null")))
/*  243 */         pstmt.setNull(21, 12);
/*      */       else {
/*  245 */         pstmt.setString(21, getOccupationFactor());
/*      */       }
/*  247 */       if ((getOccupationFe() == null) || (getOccupationFe().equals("null")))
/*  248 */         pstmt.setNull(22, 12);
/*      */       else {
/*  250 */         pstmt.setString(22, getOccupationFe());
/*      */       }
/*  252 */       if ((getOccupationFed() == null) || (getOccupationFed().equals("null")))
/*  253 */         pstmt.setNull(23, 12);
/*      */       else {
/*  255 */         pstmt.setString(23, getOccupationFed());
/*      */       }
/*  257 */       if ((getExclusions() == null) || (getExclusions().equals("null")))
/*  258 */         pstmt.setNull(24, 12);
/*      */       else {
/*  260 */         pstmt.setString(24, getExclusions());
/*      */       }
/*  262 */       if ((getDeclinedCode() == null) || (getDeclinedCode().equals("null")))
/*  263 */         pstmt.setNull(25, 12);
/*      */       else {
/*  265 */         pstmt.setString(25, getDeclinedCode());
/*      */       }
/*  267 */       if ((getDeclinedReason() == null) || (getDeclinedReason().equals("null")))
/*  268 */         pstmt.setNull(26, 12);
/*      */       else {
/*  270 */         pstmt.setString(26, getDeclinedReason());
/*      */       }
/*  272 */       if ((getPassFlag() == null) || (getPassFlag().equals("null")))
/*  273 */         pstmt.setNull(27, 12);
/*      */       else {
/*  275 */         pstmt.setString(27, getPassFlag());
/*      */       }
/*  277 */       if ((getUWIdea() == null) || (getUWIdea().equals("null")))
/*  278 */         pstmt.setNull(28, 12);
/*      */       else {
/*  280 */         pstmt.setString(28, getUWIdea());
/*      */       }
/*  282 */       if ((getUWGrade() == null) || (getUWGrade().equals("null")))
/*  283 */         pstmt.setNull(29, 12);
/*      */       else {
/*  285 */         pstmt.setString(29, getUWGrade());
/*      */       }
/*  287 */       if ((getAppGrade() == null) || (getAppGrade().equals("null")))
/*  288 */         pstmt.setNull(30, 12);
/*      */       else {
/*  290 */         pstmt.setString(30, getAppGrade());
/*      */       }
/*  292 */       if ((getPostponeDay() == null) || (getPostponeDay().equals("null")))
/*  293 */         pstmt.setNull(31, 12);
/*      */       else {
/*  295 */         pstmt.setString(31, getPostponeDay());
/*      */       }
/*  297 */       if ((getPostponeDate() == null) || (getPostponeDate().equals("null")))
/*  298 */         pstmt.setNull(32, 91);
/*      */       else {
/*  300 */         pstmt.setDate(32, Date.valueOf(getPostponeDate()));
/*      */       }
/*  302 */       if ((getAutoUWFlag() == null) || (getAutoUWFlag().equals("null")))
/*  303 */         pstmt.setNull(33, 12);
/*      */       else {
/*  305 */         pstmt.setString(33, getAutoUWFlag());
/*      */       }
/*  307 */       if ((getState() == null) || (getState().equals("null")))
/*  308 */         pstmt.setNull(34, 12);
/*      */       else {
/*  310 */         pstmt.setString(34, getState());
/*      */       }
/*  312 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  313 */         pstmt.setNull(35, 12);
/*      */       else {
/*  315 */         pstmt.setString(35, getManageCom());
/*      */       }
/*  317 */       if ((getUpReportContent() == null) || (getUpReportContent().equals("null")))
/*  318 */         pstmt.setNull(36, 12);
/*      */       else {
/*  320 */         pstmt.setString(36, getUpReportContent());
/*      */       }
/*  322 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  323 */         pstmt.setNull(37, 12);
/*      */       else {
/*  325 */         pstmt.setString(37, getOperator());
/*      */       }
/*  327 */       if ((getHealthFlag() == null) || (getHealthFlag().equals("null")))
/*  328 */         pstmt.setNull(38, 12);
/*      */       else {
/*  330 */         pstmt.setString(38, getHealthFlag());
/*      */       }
/*  332 */       if ((getQuesFlag() == null) || (getQuesFlag().equals("null")))
/*  333 */         pstmt.setNull(39, 12);
/*      */       else {
/*  335 */         pstmt.setString(39, getQuesFlag());
/*      */       }
/*  337 */       if ((getSpecFlag() == null) || (getSpecFlag().equals("null")))
/*  338 */         pstmt.setNull(40, 12);
/*      */       else {
/*  340 */         pstmt.setString(40, getSpecFlag());
/*      */       }
/*  342 */       if ((getAddPremFlag() == null) || (getAddPremFlag().equals("null")))
/*  343 */         pstmt.setNull(41, 12);
/*      */       else {
/*  345 */         pstmt.setString(41, getAddPremFlag());
/*      */       }
/*  347 */       if ((getAddPremReason() == null) || (getAddPremReason().equals("null")))
/*  348 */         pstmt.setNull(42, 12);
/*      */       else {
/*  350 */         pstmt.setString(42, getAddPremReason());
/*      */       }
/*  352 */       if ((getReportFlag() == null) || (getReportFlag().equals("null")))
/*  353 */         pstmt.setNull(43, 12);
/*      */       else {
/*  355 */         pstmt.setString(43, getReportFlag());
/*      */       }
/*  357 */       if ((getPrintFlag() == null) || (getPrintFlag().equals("null")))
/*  358 */         pstmt.setNull(44, 12);
/*      */       else {
/*  360 */         pstmt.setString(44, getPrintFlag());
/*      */       }
/*  362 */       if ((getPrintFlag2() == null) || (getPrintFlag2().equals("null")))
/*  363 */         pstmt.setNull(45, 12);
/*      */       else {
/*  365 */         pstmt.setString(45, getPrintFlag2());
/*      */       }
/*  367 */       if ((getChangePolFlag() == null) || (getChangePolFlag().equals("null")))
/*  368 */         pstmt.setNull(46, 12);
/*      */       else {
/*  370 */         pstmt.setString(46, getChangePolFlag());
/*      */       }
/*  372 */       if ((getChangePolReason() == null) || (getChangePolReason().equals("null")))
/*  373 */         pstmt.setNull(47, 12);
/*      */       else {
/*  375 */         pstmt.setString(47, getChangePolReason());
/*      */       }
/*  377 */       if ((getSpecReason() == null) || (getSpecReason().equals("null")))
/*  378 */         pstmt.setNull(48, 12);
/*      */       else {
/*  380 */         pstmt.setString(48, getSpecReason());
/*      */       }
/*  382 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  383 */         pstmt.setNull(49, 91);
/*      */       else {
/*  385 */         pstmt.setDate(49, Date.valueOf(getMakeDate()));
/*      */       }
/*  387 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  388 */         pstmt.setNull(50, 12);
/*      */       else {
/*  390 */         pstmt.setString(50, getMakeTime());
/*      */       }
/*  392 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  393 */         pstmt.setNull(51, 91);
/*      */       else {
/*  395 */         pstmt.setDate(51, Date.valueOf(getModifyDate()));
/*      */       }
/*  397 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  398 */         pstmt.setNull(52, 12);
/*      */       else {
/*  400 */         pstmt.setString(52, getModifyTime());
/*      */       }
/*  402 */       if ((getSugPassFlag() == null) || (getSugPassFlag().equals("null")))
/*  403 */         pstmt.setNull(53, 12);
/*      */       else {
/*  405 */         pstmt.setString(53, getSugPassFlag());
/*      */       }
/*  407 */       if ((getSugUWIdea() == null) || (getSugUWIdea().equals("null")))
/*  408 */         pstmt.setNull(54, 12);
/*      */       else {
/*  410 */         pstmt.setString(54, getSugUWIdea());
/*      */       }
/*      */ 
/*  413 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  414 */         pstmt.setNull(55, 12);
/*      */       else {
/*  416 */         pstmt.setString(55, getPolNo());
/*      */       }
/*  418 */       pstmt.executeUpdate();
/*  419 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  422 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  423 */       CError tError = new CError();
/*  424 */       tError.moduleName = "LNPUWMasterDB";
/*  425 */       tError.functionName = "update()";
/*  426 */       tError.errorMessage = ex.toString();
/*  427 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  430 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  433 */       if (!this.mflag)
/*      */         try {
/*  435 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  439 */       return false;
/*      */     }
/*      */ 
/*  442 */     if (!this.mflag)
/*      */       try {
/*  444 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  448 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  453 */     PreparedStatement pstmt = null;
/*      */ 
/*  455 */     if (!this.mflag) {
/*  456 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  461 */       pstmt = this.con.prepareStatement("INSERT INTO LNPUWMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  462 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  463 */         pstmt.setNull(1, 12);
/*      */       else {
/*  465 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  467 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  468 */         pstmt.setNull(2, 12);
/*      */       else {
/*  470 */         pstmt.setString(2, getContNo());
/*      */       }
/*  472 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  473 */         pstmt.setNull(3, 12);
/*      */       else {
/*  475 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  477 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  478 */         pstmt.setNull(4, 12);
/*      */       else {
/*  480 */         pstmt.setString(4, getPolNo());
/*      */       }
/*  482 */       if ((getProposalNo() == null) || (getProposalNo().equals("null")))
/*  483 */         pstmt.setNull(5, 12);
/*      */       else {
/*  485 */         pstmt.setString(5, getProposalNo());
/*      */       }
/*  487 */       pstmt.setInt(6, getUWNo());
/*  488 */       if ((getInsuredNo() == null) || (getInsuredNo().equals("null")))
/*  489 */         pstmt.setNull(7, 12);
/*      */       else {
/*  491 */         pstmt.setString(7, getInsuredNo());
/*      */       }
/*  493 */       if ((getInsuredName() == null) || (getInsuredName().equals("null")))
/*  494 */         pstmt.setNull(8, 12);
/*      */       else {
/*  496 */         pstmt.setString(8, getInsuredName());
/*      */       }
/*  498 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  499 */         pstmt.setNull(9, 12);
/*      */       else {
/*  501 */         pstmt.setString(9, getAppntNo());
/*      */       }
/*  503 */       if ((getAppntName() == null) || (getAppntName().equals("null")))
/*  504 */         pstmt.setNull(10, 12);
/*      */       else {
/*  506 */         pstmt.setString(10, getAppntName());
/*      */       }
/*  508 */       if ((getPlanCode() == null) || (getPlanCode().equals("null")))
/*  509 */         pstmt.setNull(11, 12);
/*      */       else {
/*  511 */         pstmt.setString(11, getPlanCode());
/*      */       }
/*  513 */       if ((getPlanName() == null) || (getPlanName().equals("null")))
/*  514 */         pstmt.setNull(12, 12);
/*      */       else {
/*  516 */         pstmt.setString(12, getPlanName());
/*      */       }
/*  518 */       if ((getRiderName() == null) || (getRiderName().equals("null")))
/*  519 */         pstmt.setNull(13, 12);
/*      */       else {
/*  521 */         pstmt.setString(13, getRiderName());
/*      */       }
/*  523 */       if ((getRiderCode() == null) || (getRiderCode().equals("null")))
/*  524 */         pstmt.setNull(14, 12);
/*      */       else {
/*  526 */         pstmt.setString(14, getRiderCode());
/*      */       }
/*  528 */       if ((getUWDid() == null) || (getUWDid().equals("null")))
/*  529 */         pstmt.setNull(15, 12);
/*      */       else {
/*  531 */         pstmt.setString(15, getUWDid());
/*      */       }
/*  533 */       if ((getFaceAmount() == null) || (getFaceAmount().equals("null")))
/*  534 */         pstmt.setNull(16, 12);
/*      */       else {
/*  536 */         pstmt.setString(16, getFaceAmount());
/*      */       }
/*  538 */       if ((getTerm() == null) || (getTerm().equals("null")))
/*  539 */         pstmt.setNull(17, 12);
/*      */       else {
/*  541 */         pstmt.setString(17, getTerm());
/*      */       }
/*  543 */       if ((getHealthDeb() == null) || (getHealthDeb().equals("null")))
/*  544 */         pstmt.setNull(18, 12);
/*      */       else {
/*  546 */         pstmt.setString(18, getHealthDeb());
/*      */       }
/*  548 */       if ((getHealthFe() == null) || (getHealthFe().equals("null")))
/*  549 */         pstmt.setNull(19, 12);
/*      */       else {
/*  551 */         pstmt.setString(19, getHealthFe());
/*      */       }
/*  553 */       if ((getHealthFed() == null) || (getHealthFed().equals("null")))
/*  554 */         pstmt.setNull(20, 12);
/*      */       else {
/*  556 */         pstmt.setString(20, getHealthFed());
/*      */       }
/*  558 */       if ((getOccupationFactor() == null) || (getOccupationFactor().equals("null")))
/*  559 */         pstmt.setNull(21, 12);
/*      */       else {
/*  561 */         pstmt.setString(21, getOccupationFactor());
/*      */       }
/*  563 */       if ((getOccupationFe() == null) || (getOccupationFe().equals("null")))
/*  564 */         pstmt.setNull(22, 12);
/*      */       else {
/*  566 */         pstmt.setString(22, getOccupationFe());
/*      */       }
/*  568 */       if ((getOccupationFed() == null) || (getOccupationFed().equals("null")))
/*  569 */         pstmt.setNull(23, 12);
/*      */       else {
/*  571 */         pstmt.setString(23, getOccupationFed());
/*      */       }
/*  573 */       if ((getExclusions() == null) || (getExclusions().equals("null")))
/*  574 */         pstmt.setNull(24, 12);
/*      */       else {
/*  576 */         pstmt.setString(24, getExclusions());
/*      */       }
/*  578 */       if ((getDeclinedCode() == null) || (getDeclinedCode().equals("null")))
/*  579 */         pstmt.setNull(25, 12);
/*      */       else {
/*  581 */         pstmt.setString(25, getDeclinedCode());
/*      */       }
/*  583 */       if ((getDeclinedReason() == null) || (getDeclinedReason().equals("null")))
/*  584 */         pstmt.setNull(26, 12);
/*      */       else {
/*  586 */         pstmt.setString(26, getDeclinedReason());
/*      */       }
/*  588 */       if ((getPassFlag() == null) || (getPassFlag().equals("null")))
/*  589 */         pstmt.setNull(27, 12);
/*      */       else {
/*  591 */         pstmt.setString(27, getPassFlag());
/*      */       }
/*  593 */       if ((getUWIdea() == null) || (getUWIdea().equals("null")))
/*  594 */         pstmt.setNull(28, 12);
/*      */       else {
/*  596 */         pstmt.setString(28, getUWIdea());
/*      */       }
/*  598 */       if ((getUWGrade() == null) || (getUWGrade().equals("null")))
/*  599 */         pstmt.setNull(29, 12);
/*      */       else {
/*  601 */         pstmt.setString(29, getUWGrade());
/*      */       }
/*  603 */       if ((getAppGrade() == null) || (getAppGrade().equals("null")))
/*  604 */         pstmt.setNull(30, 12);
/*      */       else {
/*  606 */         pstmt.setString(30, getAppGrade());
/*      */       }
/*  608 */       if ((getPostponeDay() == null) || (getPostponeDay().equals("null")))
/*  609 */         pstmt.setNull(31, 12);
/*      */       else {
/*  611 */         pstmt.setString(31, getPostponeDay());
/*      */       }
/*  613 */       if ((getPostponeDate() == null) || (getPostponeDate().equals("null")))
/*  614 */         pstmt.setNull(32, 91);
/*      */       else {
/*  616 */         pstmt.setDate(32, Date.valueOf(getPostponeDate()));
/*      */       }
/*  618 */       if ((getAutoUWFlag() == null) || (getAutoUWFlag().equals("null")))
/*  619 */         pstmt.setNull(33, 12);
/*      */       else {
/*  621 */         pstmt.setString(33, getAutoUWFlag());
/*      */       }
/*  623 */       if ((getState() == null) || (getState().equals("null")))
/*  624 */         pstmt.setNull(34, 12);
/*      */       else {
/*  626 */         pstmt.setString(34, getState());
/*      */       }
/*  628 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  629 */         pstmt.setNull(35, 12);
/*      */       else {
/*  631 */         pstmt.setString(35, getManageCom());
/*      */       }
/*  633 */       if ((getUpReportContent() == null) || (getUpReportContent().equals("null")))
/*  634 */         pstmt.setNull(36, 12);
/*      */       else {
/*  636 */         pstmt.setString(36, getUpReportContent());
/*      */       }
/*  638 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  639 */         pstmt.setNull(37, 12);
/*      */       else {
/*  641 */         pstmt.setString(37, getOperator());
/*      */       }
/*  643 */       if ((getHealthFlag() == null) || (getHealthFlag().equals("null")))
/*  644 */         pstmt.setNull(38, 12);
/*      */       else {
/*  646 */         pstmt.setString(38, getHealthFlag());
/*      */       }
/*  648 */       if ((getQuesFlag() == null) || (getQuesFlag().equals("null")))
/*  649 */         pstmt.setNull(39, 12);
/*      */       else {
/*  651 */         pstmt.setString(39, getQuesFlag());
/*      */       }
/*  653 */       if ((getSpecFlag() == null) || (getSpecFlag().equals("null")))
/*  654 */         pstmt.setNull(40, 12);
/*      */       else {
/*  656 */         pstmt.setString(40, getSpecFlag());
/*      */       }
/*  658 */       if ((getAddPremFlag() == null) || (getAddPremFlag().equals("null")))
/*  659 */         pstmt.setNull(41, 12);
/*      */       else {
/*  661 */         pstmt.setString(41, getAddPremFlag());
/*      */       }
/*  663 */       if ((getAddPremReason() == null) || (getAddPremReason().equals("null")))
/*  664 */         pstmt.setNull(42, 12);
/*      */       else {
/*  666 */         pstmt.setString(42, getAddPremReason());
/*      */       }
/*  668 */       if ((getReportFlag() == null) || (getReportFlag().equals("null")))
/*  669 */         pstmt.setNull(43, 12);
/*      */       else {
/*  671 */         pstmt.setString(43, getReportFlag());
/*      */       }
/*  673 */       if ((getPrintFlag() == null) || (getPrintFlag().equals("null")))
/*  674 */         pstmt.setNull(44, 12);
/*      */       else {
/*  676 */         pstmt.setString(44, getPrintFlag());
/*      */       }
/*  678 */       if ((getPrintFlag2() == null) || (getPrintFlag2().equals("null")))
/*  679 */         pstmt.setNull(45, 12);
/*      */       else {
/*  681 */         pstmt.setString(45, getPrintFlag2());
/*      */       }
/*  683 */       if ((getChangePolFlag() == null) || (getChangePolFlag().equals("null")))
/*  684 */         pstmt.setNull(46, 12);
/*      */       else {
/*  686 */         pstmt.setString(46, getChangePolFlag());
/*      */       }
/*  688 */       if ((getChangePolReason() == null) || (getChangePolReason().equals("null")))
/*  689 */         pstmt.setNull(47, 12);
/*      */       else {
/*  691 */         pstmt.setString(47, getChangePolReason());
/*      */       }
/*  693 */       if ((getSpecReason() == null) || (getSpecReason().equals("null")))
/*  694 */         pstmt.setNull(48, 12);
/*      */       else {
/*  696 */         pstmt.setString(48, getSpecReason());
/*      */       }
/*  698 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  699 */         pstmt.setNull(49, 91);
/*      */       else {
/*  701 */         pstmt.setDate(49, Date.valueOf(getMakeDate()));
/*      */       }
/*  703 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  704 */         pstmt.setNull(50, 12);
/*      */       else {
/*  706 */         pstmt.setString(50, getMakeTime());
/*      */       }
/*  708 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  709 */         pstmt.setNull(51, 91);
/*      */       else {
/*  711 */         pstmt.setDate(51, Date.valueOf(getModifyDate()));
/*      */       }
/*  713 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  714 */         pstmt.setNull(52, 12);
/*      */       else {
/*  716 */         pstmt.setString(52, getModifyTime());
/*      */       }
/*  718 */       if ((getSugPassFlag() == null) || (getSugPassFlag().equals("null")))
/*  719 */         pstmt.setNull(53, 12);
/*      */       else {
/*  721 */         pstmt.setString(53, getSugPassFlag());
/*      */       }
/*  723 */       if ((getSugUWIdea() == null) || (getSugUWIdea().equals("null")))
/*  724 */         pstmt.setNull(54, 12);
/*      */       else {
/*  726 */         pstmt.setString(54, getSugUWIdea());
/*      */       }
/*      */ 
/*  729 */       pstmt.executeUpdate();
/*  730 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  733 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  734 */       CError tError = new CError();
/*  735 */       tError.moduleName = "LNPUWMasterDB";
/*  736 */       tError.functionName = "insert()";
/*  737 */       tError.errorMessage = ex.toString();
/*  738 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  741 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  744 */       if (!this.mflag)
/*      */         try {
/*  746 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  750 */       return false;
/*      */     }
/*      */ 
/*  753 */     if (!this.mflag)
/*      */       try {
/*  755 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  759 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  764 */     PreparedStatement pstmt = null;
/*  765 */     ResultSet rs = null;
/*      */ 
/*  767 */     if (!this.mflag) {
/*  768 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  773 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPUWMaster WHERE  PolNo = ?", 
/*  774 */         1003, 1007);
/*  775 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  776 */         pstmt.setNull(1, 12);
/*      */       else {
/*  778 */         pstmt.setString(1, getPolNo());
/*      */       }
/*  780 */       rs = pstmt.executeQuery();
/*  781 */       int i = 0;
/*  782 */       if (rs.next())
/*      */       {
/*  784 */         i++;
/*  785 */         if (!setSchema(rs, i))
/*      */         {
/*  788 */           CError tError = new CError();
/*  789 */           tError.moduleName = "LNPUWMasterDB";
/*  790 */           tError.functionName = "getInfo";
/*  791 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  792 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  794 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  797 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  801 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  805 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  809 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  812 */       if (i == 0)
/*      */       {
/*  814 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  818 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  822 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  828 */       CError tError = new CError();
/*  829 */       tError.moduleName = "LNPUWMasterDB";
/*  830 */       tError.functionName = "getInfo";
/*  831 */       tError.errorMessage = e.toString();
/*  832 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  834 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  837 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  841 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  845 */       return false;
/*      */     }
/*      */ 
/*  848 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  852 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  857 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPUWMasterSet query()
/*      */   {
/*  862 */     Statement stmt = null;
/*  863 */     ResultSet rs = null;
/*  864 */     LNPUWMasterSet aLNPUWMasterSet = new LNPUWMasterSet();
/*      */ 
/*  866 */     if (!this.mflag) {
/*  867 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  872 */       stmt = this.con.createStatement(1003, 1007);
/*  873 */       SQLString sqlObj = new SQLString("LNPUWMaster");
/*  874 */       LNPUWMasterSchema aSchema = getSchema();
/*  875 */       sqlObj.setSQL(5, aSchema);
/*  876 */       String sql = sqlObj.getSQL();
/*      */ 
/*  878 */       rs = stmt.executeQuery(sql);
/*  879 */       int i = 0;
/*  880 */       while (rs.next())
/*      */       {
/*  882 */         i++;
/*  883 */         LNPUWMasterSchema s1 = new LNPUWMasterSchema();
/*  884 */         s1.setSchema(rs, i);
/*  885 */         aLNPUWMasterSet.add(s1);
/*      */       }try {
/*  887 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  893 */       CError tError = new CError();
/*  894 */       tError.moduleName = "LNPUWMasterDB";
/*  895 */       tError.functionName = "query";
/*  896 */       tError.errorMessage = e.toString();
/*  897 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  899 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  902 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  906 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  912 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  916 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  921 */     return aLNPUWMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPUWMasterSet executeQuery(String sql)
/*      */   {
/*  926 */     Statement stmt = null;
/*  927 */     ResultSet rs = null;
/*  928 */     LNPUWMasterSet aLNPUWMasterSet = new LNPUWMasterSet();
/*      */ 
/*  930 */     if (!this.mflag) {
/*  931 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  936 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  938 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  939 */       int i = 0;
/*  940 */       while (rs.next())
/*      */       {
/*  942 */         i++;
/*  943 */         LNPUWMasterSchema s1 = new LNPUWMasterSchema();
/*  944 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  947 */           CError tError = new CError();
/*  948 */           tError.moduleName = "LNPUWMasterDB";
/*  949 */           tError.functionName = "executeQuery";
/*  950 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  951 */           this.mErrors.addOneError(tError);
/*      */         }
/*  953 */         aLNPUWMasterSet.add(s1);
/*      */       }try {
/*  955 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  961 */       CError tError = new CError();
/*  962 */       tError.moduleName = "LNPUWMasterDB";
/*  963 */       tError.functionName = "executeQuery";
/*  964 */       tError.errorMessage = e.toString();
/*  965 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  967 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  970 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  974 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  980 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  984 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  989 */     return aLNPUWMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPUWMasterSet query(int nStart, int nCount)
/*      */   {
/*  994 */     Statement stmt = null;
/*  995 */     ResultSet rs = null;
/*  996 */     LNPUWMasterSet aLNPUWMasterSet = new LNPUWMasterSet();
/*      */ 
/*  998 */     if (!this.mflag) {
/*  999 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1004 */       stmt = this.con.createStatement(1003, 1007);
/* 1005 */       SQLString sqlObj = new SQLString("LNPUWMaster");
/* 1006 */       LNPUWMasterSchema aSchema = getSchema();
/* 1007 */       sqlObj.setSQL(5, aSchema);
/* 1008 */       String sql = sqlObj.getSQL();
/*      */ 
/* 1010 */       rs = stmt.executeQuery(sql);
/* 1011 */       int i = 0;
/* 1012 */       while (rs.next())
/*      */       {
/* 1014 */         i++;
/*      */ 
/* 1016 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1020 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1024 */         LNPUWMasterSchema s1 = new LNPUWMasterSchema();
/* 1025 */         s1.setSchema(rs, i);
/* 1026 */         aLNPUWMasterSet.add(s1);
/*      */       }try {
/* 1028 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1034 */       CError tError = new CError();
/* 1035 */       tError.moduleName = "LNPUWMasterDB";
/* 1036 */       tError.functionName = "query";
/* 1037 */       tError.errorMessage = e.toString();
/* 1038 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1040 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1043 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1047 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1053 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1057 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1062 */     return aLNPUWMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPUWMasterSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/* 1067 */     Statement stmt = null;
/* 1068 */     ResultSet rs = null;
/* 1069 */     LNPUWMasterSet aLNPUWMasterSet = new LNPUWMasterSet();
/*      */ 
/* 1071 */     if (!this.mflag) {
/* 1072 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1077 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1079 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1080 */       int i = 0;
/* 1081 */       while (rs.next())
/*      */       {
/* 1083 */         i++;
/*      */ 
/* 1085 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1089 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1093 */         LNPUWMasterSchema s1 = new LNPUWMasterSchema();
/* 1094 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1097 */           CError tError = new CError();
/* 1098 */           tError.moduleName = "LNPUWMasterDB";
/* 1099 */           tError.functionName = "executeQuery";
/* 1100 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 1101 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1103 */         aLNPUWMasterSet.add(s1);
/*      */       }try {
/* 1105 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1111 */       CError tError = new CError();
/* 1112 */       tError.moduleName = "LNPUWMasterDB";
/* 1113 */       tError.functionName = "executeQuery";
/* 1114 */       tError.errorMessage = e.toString();
/* 1115 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1117 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1120 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1124 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1130 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1134 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1139 */     return aLNPUWMasterSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1144 */     Statement stmt = null;
/*      */ 
/* 1146 */     if (!this.mflag) {
/* 1147 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1152 */       stmt = this.con.createStatement(1003, 1007);
/* 1153 */       SQLString sqlObj = new SQLString("LNPUWMaster");
/* 1154 */       LNPUWMasterSchema aSchema = getSchema();
/* 1155 */       sqlObj.setSQL(2, aSchema);
/* 1156 */       String sql = "update LNPUWMaster " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1158 */       int operCount = stmt.executeUpdate(sql);
/* 1159 */       if (operCount == 0)
/*      */       {
/* 1162 */         CError tError = new CError();
/* 1163 */         tError.moduleName = "LNPUWMasterDB";
/* 1164 */         tError.functionName = "update";
/* 1165 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 1166 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1168 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1172 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1176 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1182 */       CError tError = new CError();
/* 1183 */       tError.moduleName = "LNPUWMasterDB";
/* 1184 */       tError.functionName = "update";
/* 1185 */       tError.errorMessage = e.toString();
/* 1186 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1188 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1190 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1194 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1198 */       return false;
/*      */     }
/*      */ 
/* 1201 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1205 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1210 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1216 */     if (this.mResultSet != null)
/*      */     {
/* 1219 */       CError tError = new CError();
/* 1220 */       tError.moduleName = "LNPUWMasterDB";
/* 1221 */       tError.functionName = "prepareData";
/* 1222 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 1223 */       this.mErrors.addOneError(tError);
/* 1224 */       return false;
/*      */     }
/*      */ 
/* 1227 */     if (!this.mflag)
/*      */     {
/* 1229 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1233 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1234 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1239 */       CError tError = new CError();
/* 1240 */       tError.moduleName = "LNPUWMasterDB";
/* 1241 */       tError.functionName = "prepareData";
/* 1242 */       tError.errorMessage = e.toString();
/* 1243 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1246 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1252 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1256 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1260 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1265 */       return false;
/*      */     }
/*      */ 
/* 1268 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1272 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1277 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1283 */     boolean flag = true;
/* 1284 */     if (this.mResultSet == null)
/*      */     {
/* 1286 */       CError tError = new CError();
/* 1287 */       tError.moduleName = "LNPUWMasterDB";
/* 1288 */       tError.functionName = "hasMoreData";
/* 1289 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1290 */       this.mErrors.addOneError(tError);
/* 1291 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1295 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1299 */       CError tError = new CError();
/* 1300 */       tError.moduleName = "LNPUWMasterDB";
/* 1301 */       tError.functionName = "hasMoreData";
/* 1302 */       tError.errorMessage = ex.toString();
/* 1303 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1306 */         this.mResultSet.close();
/* 1307 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1313 */         this.mStatement.close();
/* 1314 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1318 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1322 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1327 */       return false;
/*      */     }
/* 1329 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPUWMasterSet getData()
/*      */   {
/* 1334 */     int tCount = 0;
/* 1335 */     LNPUWMasterSet tLNPUWMasterSet = new LNPUWMasterSet();
/* 1336 */     LNPUWMasterSchema tLNPUWMasterSchema = null;
/* 1337 */     if (this.mResultSet == null)
/*      */     {
/* 1339 */       CError tError = new CError();
/* 1340 */       tError.moduleName = "LNPUWMasterDB";
/* 1341 */       tError.functionName = "getData";
/* 1342 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1343 */       this.mErrors.addOneError(tError);
/* 1344 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1348 */       tCount = 1;
/* 1349 */       tLNPUWMasterSchema = new LNPUWMasterSchema();
/* 1350 */       tLNPUWMasterSchema.setSchema(this.mResultSet, 1);
/* 1351 */       tLNPUWMasterSet.add(tLNPUWMasterSchema);
/*      */ 
/* 1353 */       while (tCount++ < 5000)
/*      */       {
/* 1355 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1357 */         tLNPUWMasterSchema = new LNPUWMasterSchema();
/* 1358 */         tLNPUWMasterSchema.setSchema(this.mResultSet, 1);
/* 1359 */         tLNPUWMasterSet.add(tLNPUWMasterSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1365 */       CError tError = new CError();
/* 1366 */       tError.moduleName = "LNPUWMasterDB";
/* 1367 */       tError.functionName = "getData";
/* 1368 */       tError.errorMessage = ex.toString();
/* 1369 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1372 */         this.mResultSet.close();
/* 1373 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1379 */         this.mStatement.close();
/* 1380 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1384 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1388 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1393 */       return null;
/*      */     }
/* 1395 */     return tLNPUWMasterSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1400 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1403 */       if (this.mResultSet == null)
/*      */       {
/* 1405 */         CError tError = new CError();
/* 1406 */         tError.moduleName = "LNPUWMasterDB";
/* 1407 */         tError.functionName = "closeData";
/* 1408 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1409 */         this.mErrors.addOneError(tError);
/* 1410 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1414 */         this.mResultSet.close();
/* 1415 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1420 */       CError tError = new CError();
/* 1421 */       tError.moduleName = "LNPUWMasterDB";
/* 1422 */       tError.functionName = "closeData";
/* 1423 */       tError.errorMessage = ex2.toString();
/* 1424 */       this.mErrors.addOneError(tError);
/* 1425 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1429 */       if (this.mStatement == null)
/*      */       {
/* 1431 */         CError tError = new CError();
/* 1432 */         tError.moduleName = "LNPUWMasterDB";
/* 1433 */         tError.functionName = "closeData";
/* 1434 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1435 */         this.mErrors.addOneError(tError);
/* 1436 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1440 */         this.mStatement.close();
/* 1441 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1446 */       CError tError = new CError();
/* 1447 */       tError.moduleName = "LNPUWMasterDB";
/* 1448 */       tError.functionName = "closeData";
/* 1449 */       tError.errorMessage = ex3.toString();
/* 1450 */       this.mErrors.addOneError(tError);
/* 1451 */       flag = false;
/*      */     }
/* 1453 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPUWMasterDB
 * JD-Core Version:    0.6.0
 */