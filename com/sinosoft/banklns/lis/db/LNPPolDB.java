/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
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
/*      */ public class LNPPolDB extends LNPPolSchema
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
/*      */   public LNPPolDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPPol");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPPolDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPPol");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPPolSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPPolDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPPolSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPPolDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPPol WHERE  PolNo = ?");
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
/*  108 */       tError.moduleName = "LNPPolDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPPol SET  GrpContNo = ? , GrpPolNo = ? , ContNo = ? , ProposalContNo = ? , PolNo = ? , ProposalNo = ? , PrtNo = ? , ContType = ? , PolTypeFlag = ? , MainPolNo = ? , MasterPolNo = ? , KindCode = ? , RiskCode = ? , RiskVersion = ? , ManageCom = ? , AgentCom = ? , AgentType = ? , AgentCode = ? , AgentGroup = ? , AgentGroup1 = ? , AgentCode1 = ? , SaleChnl = ? , Handler = ? , InsuredNo = ? , InsuredId = ? , InsuredName = ? , InsuredSex = ? , InsuredBirthday = ? , InsuredAppAge = ? , InsuredPeoples = ? , OccupationType = ? , AppntNo = ? , AppntName = ? , CValiDate = ? , SignCom = ? , SignDate = ? , SignTime = ? , FirstPayDate = ? , PayEndDate = ? , PaytoDate = ? , GetStartDate = ? , EndDate = ? , AcciEndDate = ? , GetYearFlag = ? , GetYear = ? , PayEndYearFlag = ? , PayEndYear = ? , InsuYearFlag = ? , InsuYear = ? , AcciYearFlag = ? , AcciYear = ? , GetStartType = ? , SpecifyValiDate = ? , PayMode = ? , PayLocation = ? , PayIntv = ? , PayYears = ? , Years = ? , ManageFeeRate = ? , FloatRate = ? , PremRate = ? , PremToAmnt = ? , Mult = ? , StandPrem = ? , Prem = ? , SumPrem = ? , Amnt = ? , RiskAmnt = ? , LeavingMoney = ? , EndorseTimes = ? , ClaimTimes = ? , LiveTimes = ? , RenewCount = ? , LastGetDate = ? , LastLoanDate = ? , LastRegetDate = ? , LastEdorDate = ? , LastRevDate = ? , RnewFlag = ? , StopFlag = ? , ExpiryFlag = ? , AutoPayFlag = ? , InterestDifFlag = ? , SubFlag = ? , BnfFlag = ? , HealthCheckFlag = ? , ImpartFlag = ? , ReinsureFlag = ? , AgentPayFlag = ? , AgentGetFlag = ? , LiveGetMode = ? , DeadGetMode = ? , BonusGetMode = ? , DeadAmntType = ? , TopUpPrem = ? , BonusMan = ? , DeadFlag = ? , SmokeFlag = ? , Remark = ? , ApproveFlag = ? , ApproveCode = ? , ApproveDate = ? , ApproveTime = ? , UWFlag = ? , UWCode = ? , UWDate = ? , UWTime = ? , PolApplyDate = ? , AppFlag = ? , SaleChnlDetail = ? , PolState = ? , StandbyFlag1 = ? , StandbyFlag2 = ? , StandbyFlag3 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  PolNo = ?");
/*  146 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  151 */       if ((getGrpPolNo() == null) || (getGrpPolNo().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getGrpPolNo());
/*      */       }
/*  156 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getContNo());
/*      */       }
/*  161 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getProposalContNo());
/*      */       }
/*  166 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  167 */         pstmt.setNull(5, 12);
/*      */       else {
/*  169 */         pstmt.setString(5, getPolNo());
/*      */       }
/*  171 */       if ((getProposalNo() == null) || (getProposalNo().equals("null")))
/*  172 */         pstmt.setNull(6, 12);
/*      */       else {
/*  174 */         pstmt.setString(6, getProposalNo());
/*      */       }
/*  176 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  177 */         pstmt.setNull(7, 12);
/*      */       else {
/*  179 */         pstmt.setString(7, getPrtNo());
/*      */       }
/*  181 */       if ((getContType() == null) || (getContType().equals("null")))
/*  182 */         pstmt.setNull(8, 12);
/*      */       else {
/*  184 */         pstmt.setString(8, getContType());
/*      */       }
/*  186 */       if ((getPolTypeFlag() == null) || (getPolTypeFlag().equals("null")))
/*  187 */         pstmt.setNull(9, 12);
/*      */       else {
/*  189 */         pstmt.setString(9, getPolTypeFlag());
/*      */       }
/*  191 */       if ((getMainPolNo() == null) || (getMainPolNo().equals("null")))
/*  192 */         pstmt.setNull(10, 12);
/*      */       else {
/*  194 */         pstmt.setString(10, getMainPolNo());
/*      */       }
/*  196 */       if ((getMasterPolNo() == null) || (getMasterPolNo().equals("null")))
/*  197 */         pstmt.setNull(11, 12);
/*      */       else {
/*  199 */         pstmt.setString(11, getMasterPolNo());
/*      */       }
/*  201 */       if ((getKindCode() == null) || (getKindCode().equals("null")))
/*  202 */         pstmt.setNull(12, 12);
/*      */       else {
/*  204 */         pstmt.setString(12, getKindCode());
/*      */       }
/*  206 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  207 */         pstmt.setNull(13, 12);
/*      */       else {
/*  209 */         pstmt.setString(13, getRiskCode());
/*      */       }
/*  211 */       if ((getRiskVersion() == null) || (getRiskVersion().equals("null")))
/*  212 */         pstmt.setNull(14, 12);
/*      */       else {
/*  214 */         pstmt.setString(14, getRiskVersion());
/*      */       }
/*  216 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  217 */         pstmt.setNull(15, 12);
/*      */       else {
/*  219 */         pstmt.setString(15, getManageCom());
/*      */       }
/*  221 */       if ((getAgentCom() == null) || (getAgentCom().equals("null")))
/*  222 */         pstmt.setNull(16, 12);
/*      */       else {
/*  224 */         pstmt.setString(16, getAgentCom());
/*      */       }
/*  226 */       if ((getAgentType() == null) || (getAgentType().equals("null")))
/*  227 */         pstmt.setNull(17, 12);
/*      */       else {
/*  229 */         pstmt.setString(17, getAgentType());
/*      */       }
/*  231 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  232 */         pstmt.setNull(18, 12);
/*      */       else {
/*  234 */         pstmt.setString(18, getAgentCode());
/*      */       }
/*  236 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  237 */         pstmt.setNull(19, 12);
/*      */       else {
/*  239 */         pstmt.setString(19, getAgentGroup());
/*      */       }
/*  241 */       if ((getAgentGroup1() == null) || (getAgentGroup1().equals("null")))
/*  242 */         pstmt.setNull(20, 12);
/*      */       else {
/*  244 */         pstmt.setString(20, getAgentGroup1());
/*      */       }
/*  246 */       if ((getAgentCode1() == null) || (getAgentCode1().equals("null")))
/*  247 */         pstmt.setNull(21, 12);
/*      */       else {
/*  249 */         pstmt.setString(21, getAgentCode1());
/*      */       }
/*  251 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  252 */         pstmt.setNull(22, 12);
/*      */       else {
/*  254 */         pstmt.setString(22, getSaleChnl());
/*      */       }
/*  256 */       if ((getHandler() == null) || (getHandler().equals("null")))
/*  257 */         pstmt.setNull(23, 12);
/*      */       else {
/*  259 */         pstmt.setString(23, getHandler());
/*      */       }
/*  261 */       if ((getInsuredNo() == null) || (getInsuredNo().equals("null")))
/*  262 */         pstmt.setNull(24, 12);
/*      */       else {
/*  264 */         pstmt.setString(24, getInsuredNo());
/*      */       }
/*  266 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  267 */         pstmt.setNull(25, 12);
/*      */       else {
/*  269 */         pstmt.setString(25, getInsuredId());
/*      */       }
/*  271 */       if ((getInsuredName() == null) || (getInsuredName().equals("null")))
/*  272 */         pstmt.setNull(26, 12);
/*      */       else {
/*  274 */         pstmt.setString(26, getInsuredName());
/*      */       }
/*  276 */       if ((getInsuredSex() == null) || (getInsuredSex().equals("null")))
/*  277 */         pstmt.setNull(27, 12);
/*      */       else {
/*  279 */         pstmt.setString(27, getInsuredSex());
/*      */       }
/*  281 */       if ((getInsuredBirthday() == null) || (getInsuredBirthday().equals("null")))
/*  282 */         pstmt.setNull(28, 91);
/*      */       else {
/*  284 */         pstmt.setDate(28, Date.valueOf(getInsuredBirthday()));
/*      */       }
/*  286 */       pstmt.setInt(29, getInsuredAppAge());
/*  287 */       pstmt.setInt(30, getInsuredPeoples());
/*  288 */       if ((getOccupationType() == null) || (getOccupationType().equals("null")))
/*  289 */         pstmt.setNull(31, 12);
/*      */       else {
/*  291 */         pstmt.setString(31, getOccupationType());
/*      */       }
/*  293 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  294 */         pstmt.setNull(32, 12);
/*      */       else {
/*  296 */         pstmt.setString(32, getAppntNo());
/*      */       }
/*  298 */       if ((getAppntName() == null) || (getAppntName().equals("null")))
/*  299 */         pstmt.setNull(33, 12);
/*      */       else {
/*  301 */         pstmt.setString(33, getAppntName());
/*      */       }
/*  303 */       if ((getCValiDate() == null) || (getCValiDate().equals("null")))
/*  304 */         pstmt.setNull(34, 91);
/*      */       else {
/*  306 */         pstmt.setDate(34, Date.valueOf(getCValiDate()));
/*      */       }
/*  308 */       if ((getSignCom() == null) || (getSignCom().equals("null")))
/*  309 */         pstmt.setNull(35, 12);
/*      */       else {
/*  311 */         pstmt.setString(35, getSignCom());
/*      */       }
/*  313 */       if ((getSignDate() == null) || (getSignDate().equals("null")))
/*  314 */         pstmt.setNull(36, 91);
/*      */       else {
/*  316 */         pstmt.setDate(36, Date.valueOf(getSignDate()));
/*      */       }
/*  318 */       if ((getSignTime() == null) || (getSignTime().equals("null")))
/*  319 */         pstmt.setNull(37, 12);
/*      */       else {
/*  321 */         pstmt.setString(37, getSignTime());
/*      */       }
/*  323 */       if ((getFirstPayDate() == null) || (getFirstPayDate().equals("null")))
/*  324 */         pstmt.setNull(38, 91);
/*      */       else {
/*  326 */         pstmt.setDate(38, Date.valueOf(getFirstPayDate()));
/*      */       }
/*  328 */       if ((getPayEndDate() == null) || (getPayEndDate().equals("null")))
/*  329 */         pstmt.setNull(39, 91);
/*      */       else {
/*  331 */         pstmt.setDate(39, Date.valueOf(getPayEndDate()));
/*      */       }
/*  333 */       if ((getPaytoDate() == null) || (getPaytoDate().equals("null")))
/*  334 */         pstmt.setNull(40, 91);
/*      */       else {
/*  336 */         pstmt.setDate(40, Date.valueOf(getPaytoDate()));
/*      */       }
/*  338 */       if ((getGetStartDate() == null) || (getGetStartDate().equals("null")))
/*  339 */         pstmt.setNull(41, 91);
/*      */       else {
/*  341 */         pstmt.setDate(41, Date.valueOf(getGetStartDate()));
/*      */       }
/*  343 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  344 */         pstmt.setNull(42, 91);
/*      */       else {
/*  346 */         pstmt.setDate(42, Date.valueOf(getEndDate()));
/*      */       }
/*  348 */       if ((getAcciEndDate() == null) || (getAcciEndDate().equals("null")))
/*  349 */         pstmt.setNull(43, 91);
/*      */       else {
/*  351 */         pstmt.setDate(43, Date.valueOf(getAcciEndDate()));
/*      */       }
/*  353 */       if ((getGetYearFlag() == null) || (getGetYearFlag().equals("null")))
/*  354 */         pstmt.setNull(44, 12);
/*      */       else {
/*  356 */         pstmt.setString(44, getGetYearFlag());
/*      */       }
/*  358 */       pstmt.setInt(45, getGetYear());
/*  359 */       if ((getPayEndYearFlag() == null) || (getPayEndYearFlag().equals("null")))
/*  360 */         pstmt.setNull(46, 12);
/*      */       else {
/*  362 */         pstmt.setString(46, getPayEndYearFlag());
/*      */       }
/*  364 */       pstmt.setInt(47, getPayEndYear());
/*  365 */       if ((getInsuYearFlag() == null) || (getInsuYearFlag().equals("null")))
/*  366 */         pstmt.setNull(48, 12);
/*      */       else {
/*  368 */         pstmt.setString(48, getInsuYearFlag());
/*      */       }
/*  370 */       pstmt.setInt(49, getInsuYear());
/*  371 */       if ((getAcciYearFlag() == null) || (getAcciYearFlag().equals("null")))
/*  372 */         pstmt.setNull(50, 12);
/*      */       else {
/*  374 */         pstmt.setString(50, getAcciYearFlag());
/*      */       }
/*  376 */       pstmt.setInt(51, getAcciYear());
/*  377 */       if ((getGetStartType() == null) || (getGetStartType().equals("null")))
/*  378 */         pstmt.setNull(52, 12);
/*      */       else {
/*  380 */         pstmt.setString(52, getGetStartType());
/*      */       }
/*  382 */       if ((getSpecifyValiDate() == null) || (getSpecifyValiDate().equals("null")))
/*  383 */         pstmt.setNull(53, 12);
/*      */       else {
/*  385 */         pstmt.setString(53, getSpecifyValiDate());
/*      */       }
/*  387 */       if ((getPayMode() == null) || (getPayMode().equals("null")))
/*  388 */         pstmt.setNull(54, 12);
/*      */       else {
/*  390 */         pstmt.setString(54, getPayMode());
/*      */       }
/*  392 */       if ((getPayLocation() == null) || (getPayLocation().equals("null")))
/*  393 */         pstmt.setNull(55, 12);
/*      */       else {
/*  395 */         pstmt.setString(55, getPayLocation());
/*      */       }
/*  397 */       pstmt.setInt(56, getPayIntv());
/*  398 */       pstmt.setInt(57, getPayYears());
/*  399 */       pstmt.setInt(58, getYears());
/*  400 */       pstmt.setDouble(59, getManageFeeRate());
/*  401 */       pstmt.setDouble(60, getFloatRate());
/*  402 */       pstmt.setDouble(61, getPremRate());
/*  403 */       if ((getPremToAmnt() == null) || (getPremToAmnt().equals("null")))
/*  404 */         pstmt.setNull(62, 12);
/*      */       else {
/*  406 */         pstmt.setString(62, getPremToAmnt());
/*      */       }
/*  408 */       pstmt.setDouble(63, getMult());
/*  409 */       pstmt.setDouble(64, getStandPrem());
/*  410 */       pstmt.setDouble(65, getPrem());
/*  411 */       pstmt.setDouble(66, getSumPrem());
/*  412 */       pstmt.setDouble(67, getAmnt());
/*  413 */       pstmt.setDouble(68, getRiskAmnt());
/*  414 */       pstmt.setDouble(69, getLeavingMoney());
/*  415 */       pstmt.setInt(70, getEndorseTimes());
/*  416 */       pstmt.setInt(71, getClaimTimes());
/*  417 */       pstmt.setInt(72, getLiveTimes());
/*  418 */       pstmt.setInt(73, getRenewCount());
/*  419 */       if ((getLastGetDate() == null) || (getLastGetDate().equals("null")))
/*  420 */         pstmt.setNull(74, 91);
/*      */       else {
/*  422 */         pstmt.setDate(74, Date.valueOf(getLastGetDate()));
/*      */       }
/*  424 */       if ((getLastLoanDate() == null) || (getLastLoanDate().equals("null")))
/*  425 */         pstmt.setNull(75, 91);
/*      */       else {
/*  427 */         pstmt.setDate(75, Date.valueOf(getLastLoanDate()));
/*      */       }
/*  429 */       if ((getLastRegetDate() == null) || (getLastRegetDate().equals("null")))
/*  430 */         pstmt.setNull(76, 91);
/*      */       else {
/*  432 */         pstmt.setDate(76, Date.valueOf(getLastRegetDate()));
/*      */       }
/*  434 */       if ((getLastEdorDate() == null) || (getLastEdorDate().equals("null")))
/*  435 */         pstmt.setNull(77, 91);
/*      */       else {
/*  437 */         pstmt.setDate(77, Date.valueOf(getLastEdorDate()));
/*      */       }
/*  439 */       if ((getLastRevDate() == null) || (getLastRevDate().equals("null")))
/*  440 */         pstmt.setNull(78, 91);
/*      */       else {
/*  442 */         pstmt.setDate(78, Date.valueOf(getLastRevDate()));
/*      */       }
/*  444 */       if ((getRnewFlag() == null) || (getRnewFlag().equals("null")))
/*  445 */         pstmt.setNull(79, 12);
/*      */       else {
/*  447 */         pstmt.setString(79, getRnewFlag());
/*      */       }
/*  449 */       if ((getStopFlag() == null) || (getStopFlag().equals("null")))
/*  450 */         pstmt.setNull(80, 12);
/*      */       else {
/*  452 */         pstmt.setString(80, getStopFlag());
/*      */       }
/*  454 */       if ((getExpiryFlag() == null) || (getExpiryFlag().equals("null")))
/*  455 */         pstmt.setNull(81, 12);
/*      */       else {
/*  457 */         pstmt.setString(81, getExpiryFlag());
/*      */       }
/*  459 */       if ((getAutoPayFlag() == null) || (getAutoPayFlag().equals("null")))
/*  460 */         pstmt.setNull(82, 12);
/*      */       else {
/*  462 */         pstmt.setString(82, getAutoPayFlag());
/*      */       }
/*  464 */       if ((getInterestDifFlag() == null) || (getInterestDifFlag().equals("null")))
/*  465 */         pstmt.setNull(83, 12);
/*      */       else {
/*  467 */         pstmt.setString(83, getInterestDifFlag());
/*      */       }
/*  469 */       if ((getSubFlag() == null) || (getSubFlag().equals("null")))
/*  470 */         pstmt.setNull(84, 12);
/*      */       else {
/*  472 */         pstmt.setString(84, getSubFlag());
/*      */       }
/*  474 */       if ((getBnfFlag() == null) || (getBnfFlag().equals("null")))
/*  475 */         pstmt.setNull(85, 12);
/*      */       else {
/*  477 */         pstmt.setString(85, getBnfFlag());
/*      */       }
/*  479 */       if ((getHealthCheckFlag() == null) || (getHealthCheckFlag().equals("null")))
/*  480 */         pstmt.setNull(86, 12);
/*      */       else {
/*  482 */         pstmt.setString(86, getHealthCheckFlag());
/*      */       }
/*  484 */       if ((getImpartFlag() == null) || (getImpartFlag().equals("null")))
/*  485 */         pstmt.setNull(87, 12);
/*      */       else {
/*  487 */         pstmt.setString(87, getImpartFlag());
/*      */       }
/*  489 */       if ((getReinsureFlag() == null) || (getReinsureFlag().equals("null")))
/*  490 */         pstmt.setNull(88, 12);
/*      */       else {
/*  492 */         pstmt.setString(88, getReinsureFlag());
/*      */       }
/*  494 */       if ((getAgentPayFlag() == null) || (getAgentPayFlag().equals("null")))
/*  495 */         pstmt.setNull(89, 12);
/*      */       else {
/*  497 */         pstmt.setString(89, getAgentPayFlag());
/*      */       }
/*  499 */       if ((getAgentGetFlag() == null) || (getAgentGetFlag().equals("null")))
/*  500 */         pstmt.setNull(90, 12);
/*      */       else {
/*  502 */         pstmt.setString(90, getAgentGetFlag());
/*      */       }
/*  504 */       if ((getLiveGetMode() == null) || (getLiveGetMode().equals("null")))
/*  505 */         pstmt.setNull(91, 12);
/*      */       else {
/*  507 */         pstmt.setString(91, getLiveGetMode());
/*      */       }
/*  509 */       if ((getDeadGetMode() == null) || (getDeadGetMode().equals("null")))
/*  510 */         pstmt.setNull(92, 12);
/*      */       else {
/*  512 */         pstmt.setString(92, getDeadGetMode());
/*      */       }
/*  514 */       if ((getBonusGetMode() == null) || (getBonusGetMode().equals("null")))
/*  515 */         pstmt.setNull(93, 12);
/*      */       else {
/*  517 */         pstmt.setString(93, getBonusGetMode());
/*      */       }
/*  519 */       if ((getDeadAmntType() == null) || (getDeadAmntType().equals("null")))
/*  520 */         pstmt.setNull(94, 12);
/*      */       else {
/*  522 */         pstmt.setString(94, getDeadAmntType());
/*      */       }
/*  524 */       pstmt.setDouble(95, getTopUpPrem());
/*  525 */       if ((getBonusMan() == null) || (getBonusMan().equals("null")))
/*  526 */         pstmt.setNull(96, 12);
/*      */       else {
/*  528 */         pstmt.setString(96, getBonusMan());
/*      */       }
/*  530 */       if ((getDeadFlag() == null) || (getDeadFlag().equals("null")))
/*  531 */         pstmt.setNull(97, 12);
/*      */       else {
/*  533 */         pstmt.setString(97, getDeadFlag());
/*      */       }
/*  535 */       if ((getSmokeFlag() == null) || (getSmokeFlag().equals("null")))
/*  536 */         pstmt.setNull(98, 12);
/*      */       else {
/*  538 */         pstmt.setString(98, getSmokeFlag());
/*      */       }
/*  540 */       if ((getRemark() == null) || (getRemark().equals("null")))
/*  541 */         pstmt.setNull(99, 12);
/*      */       else {
/*  543 */         pstmt.setString(99, getRemark());
/*      */       }
/*  545 */       if ((getApproveFlag() == null) || (getApproveFlag().equals("null")))
/*  546 */         pstmt.setNull(100, 12);
/*      */       else {
/*  548 */         pstmt.setString(100, getApproveFlag());
/*      */       }
/*  550 */       if ((getApproveCode() == null) || (getApproveCode().equals("null")))
/*  551 */         pstmt.setNull(101, 12);
/*      */       else {
/*  553 */         pstmt.setString(101, getApproveCode());
/*      */       }
/*  555 */       if ((getApproveDate() == null) || (getApproveDate().equals("null")))
/*  556 */         pstmt.setNull(102, 91);
/*      */       else {
/*  558 */         pstmt.setDate(102, Date.valueOf(getApproveDate()));
/*      */       }
/*  560 */       if ((getApproveTime() == null) || (getApproveTime().equals("null")))
/*  561 */         pstmt.setNull(103, 12);
/*      */       else {
/*  563 */         pstmt.setString(103, getApproveTime());
/*      */       }
/*  565 */       if ((getUWFlag() == null) || (getUWFlag().equals("null")))
/*  566 */         pstmt.setNull(104, 12);
/*      */       else {
/*  568 */         pstmt.setString(104, getUWFlag());
/*      */       }
/*  570 */       if ((getUWCode() == null) || (getUWCode().equals("null")))
/*  571 */         pstmt.setNull(105, 12);
/*      */       else {
/*  573 */         pstmt.setString(105, getUWCode());
/*      */       }
/*  575 */       if ((getUWDate() == null) || (getUWDate().equals("null")))
/*  576 */         pstmt.setNull(106, 91);
/*      */       else {
/*  578 */         pstmt.setDate(106, Date.valueOf(getUWDate()));
/*      */       }
/*  580 */       if ((getUWTime() == null) || (getUWTime().equals("null")))
/*  581 */         pstmt.setNull(107, 12);
/*      */       else {
/*  583 */         pstmt.setString(107, getUWTime());
/*      */       }
/*  585 */       if ((getPolApplyDate() == null) || (getPolApplyDate().equals("null")))
/*  586 */         pstmt.setNull(108, 91);
/*      */       else {
/*  588 */         pstmt.setDate(108, Date.valueOf(getPolApplyDate()));
/*      */       }
/*  590 */       if ((getAppFlag() == null) || (getAppFlag().equals("null")))
/*  591 */         pstmt.setNull(109, 12);
/*      */       else {
/*  593 */         pstmt.setString(109, getAppFlag());
/*      */       }
/*  595 */       if ((getSaleChnlDetail() == null) || (getSaleChnlDetail().equals("null")))
/*  596 */         pstmt.setNull(110, 12);
/*      */       else {
/*  598 */         pstmt.setString(110, getSaleChnlDetail());
/*      */       }
/*  600 */       if ((getPolState() == null) || (getPolState().equals("null")))
/*  601 */         pstmt.setNull(111, 12);
/*      */       else {
/*  603 */         pstmt.setString(111, getPolState());
/*      */       }
/*  605 */       if ((getStandbyFlag1() == null) || (getStandbyFlag1().equals("null")))
/*  606 */         pstmt.setNull(112, 12);
/*      */       else {
/*  608 */         pstmt.setString(112, getStandbyFlag1());
/*      */       }
/*  610 */       if ((getStandbyFlag2() == null) || (getStandbyFlag2().equals("null")))
/*  611 */         pstmt.setNull(113, 12);
/*      */       else {
/*  613 */         pstmt.setString(113, getStandbyFlag2());
/*      */       }
/*  615 */       if ((getStandbyFlag3() == null) || (getStandbyFlag3().equals("null")))
/*  616 */         pstmt.setNull(114, 12);
/*      */       else {
/*  618 */         pstmt.setString(114, getStandbyFlag3());
/*      */       }
/*  620 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  621 */         pstmt.setNull(115, 12);
/*      */       else {
/*  623 */         pstmt.setString(115, getOperator());
/*      */       }
/*  625 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  626 */         pstmt.setNull(116, 91);
/*      */       else {
/*  628 */         pstmt.setDate(116, Date.valueOf(getMakeDate()));
/*      */       }
/*  630 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  631 */         pstmt.setNull(117, 12);
/*      */       else {
/*  633 */         pstmt.setString(117, getMakeTime());
/*      */       }
/*  635 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  636 */         pstmt.setNull(118, 91);
/*      */       else {
/*  638 */         pstmt.setDate(118, Date.valueOf(getModifyDate()));
/*      */       }
/*  640 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  641 */         pstmt.setNull(119, 12);
/*      */       else {
/*  643 */         pstmt.setString(119, getModifyTime());
/*      */       }
/*      */ 
/*  646 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  647 */         pstmt.setNull(120, 12);
/*      */       else {
/*  649 */         pstmt.setString(120, getPolNo());
/*      */       }
/*  651 */       pstmt.executeUpdate();
/*  652 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  655 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  656 */       CError tError = new CError();
/*  657 */       tError.moduleName = "LNPPolDB";
/*  658 */       tError.functionName = "update()";
/*  659 */       tError.errorMessage = ex.toString();
/*  660 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  663 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  666 */       if (!this.mflag)
/*      */         try {
/*  668 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  672 */       return false;
/*      */     }
/*      */ 
/*  675 */     if (!this.mflag)
/*      */       try {
/*  677 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  681 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  686 */     PreparedStatement pstmt = null;
/*      */ 
/*  688 */     if (!this.mflag) {
/*  689 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  694 */       pstmt = this.con.prepareStatement("INSERT INTO LNPPol VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  695 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  696 */         pstmt.setNull(1, 12);
/*      */       else {
/*  698 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  700 */       if ((getGrpPolNo() == null) || (getGrpPolNo().equals("null")))
/*  701 */         pstmt.setNull(2, 12);
/*      */       else {
/*  703 */         pstmt.setString(2, getGrpPolNo());
/*      */       }
/*  705 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  706 */         pstmt.setNull(3, 12);
/*      */       else {
/*  708 */         pstmt.setString(3, getContNo());
/*      */       }
/*  710 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  711 */         pstmt.setNull(4, 12);
/*      */       else {
/*  713 */         pstmt.setString(4, getProposalContNo());
/*      */       }
/*  715 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  716 */         pstmt.setNull(5, 12);
/*      */       else {
/*  718 */         pstmt.setString(5, getPolNo());
/*      */       }
/*  720 */       if ((getProposalNo() == null) || (getProposalNo().equals("null")))
/*  721 */         pstmt.setNull(6, 12);
/*      */       else {
/*  723 */         pstmt.setString(6, getProposalNo());
/*      */       }
/*  725 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  726 */         pstmt.setNull(7, 12);
/*      */       else {
/*  728 */         pstmt.setString(7, getPrtNo());
/*      */       }
/*  730 */       if ((getContType() == null) || (getContType().equals("null")))
/*  731 */         pstmt.setNull(8, 12);
/*      */       else {
/*  733 */         pstmt.setString(8, getContType());
/*      */       }
/*  735 */       if ((getPolTypeFlag() == null) || (getPolTypeFlag().equals("null")))
/*  736 */         pstmt.setNull(9, 12);
/*      */       else {
/*  738 */         pstmt.setString(9, getPolTypeFlag());
/*      */       }
/*  740 */       if ((getMainPolNo() == null) || (getMainPolNo().equals("null")))
/*  741 */         pstmt.setNull(10, 12);
/*      */       else {
/*  743 */         pstmt.setString(10, getMainPolNo());
/*      */       }
/*  745 */       if ((getMasterPolNo() == null) || (getMasterPolNo().equals("null")))
/*  746 */         pstmt.setNull(11, 12);
/*      */       else {
/*  748 */         pstmt.setString(11, getMasterPolNo());
/*      */       }
/*  750 */       if ((getKindCode() == null) || (getKindCode().equals("null")))
/*  751 */         pstmt.setNull(12, 12);
/*      */       else {
/*  753 */         pstmt.setString(12, getKindCode());
/*      */       }
/*  755 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  756 */         pstmt.setNull(13, 12);
/*      */       else {
/*  758 */         pstmt.setString(13, getRiskCode());
/*      */       }
/*  760 */       if ((getRiskVersion() == null) || (getRiskVersion().equals("null")))
/*  761 */         pstmt.setNull(14, 12);
/*      */       else {
/*  763 */         pstmt.setString(14, getRiskVersion());
/*      */       }
/*  765 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  766 */         pstmt.setNull(15, 12);
/*      */       else {
/*  768 */         pstmt.setString(15, getManageCom());
/*      */       }
/*  770 */       if ((getAgentCom() == null) || (getAgentCom().equals("null")))
/*  771 */         pstmt.setNull(16, 12);
/*      */       else {
/*  773 */         pstmt.setString(16, getAgentCom());
/*      */       }
/*  775 */       if ((getAgentType() == null) || (getAgentType().equals("null")))
/*  776 */         pstmt.setNull(17, 12);
/*      */       else {
/*  778 */         pstmt.setString(17, getAgentType());
/*      */       }
/*  780 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  781 */         pstmt.setNull(18, 12);
/*      */       else {
/*  783 */         pstmt.setString(18, getAgentCode());
/*      */       }
/*  785 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  786 */         pstmt.setNull(19, 12);
/*      */       else {
/*  788 */         pstmt.setString(19, getAgentGroup());
/*      */       }
/*  790 */       if ((getAgentGroup1() == null) || (getAgentGroup1().equals("null")))
/*  791 */         pstmt.setNull(20, 12);
/*      */       else {
/*  793 */         pstmt.setString(20, getAgentGroup1());
/*      */       }
/*  795 */       if ((getAgentCode1() == null) || (getAgentCode1().equals("null")))
/*  796 */         pstmt.setNull(21, 12);
/*      */       else {
/*  798 */         pstmt.setString(21, getAgentCode1());
/*      */       }
/*  800 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  801 */         pstmt.setNull(22, 12);
/*      */       else {
/*  803 */         pstmt.setString(22, getSaleChnl());
/*      */       }
/*  805 */       if ((getHandler() == null) || (getHandler().equals("null")))
/*  806 */         pstmt.setNull(23, 12);
/*      */       else {
/*  808 */         pstmt.setString(23, getHandler());
/*      */       }
/*  810 */       if ((getInsuredNo() == null) || (getInsuredNo().equals("null")))
/*  811 */         pstmt.setNull(24, 12);
/*      */       else {
/*  813 */         pstmt.setString(24, getInsuredNo());
/*      */       }
/*  815 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  816 */         pstmt.setNull(25, 12);
/*      */       else {
/*  818 */         pstmt.setString(25, getInsuredId());
/*      */       }
/*  820 */       if ((getInsuredName() == null) || (getInsuredName().equals("null")))
/*  821 */         pstmt.setNull(26, 12);
/*      */       else {
/*  823 */         pstmt.setString(26, getInsuredName());
/*      */       }
/*  825 */       if ((getInsuredSex() == null) || (getInsuredSex().equals("null")))
/*  826 */         pstmt.setNull(27, 12);
/*      */       else {
/*  828 */         pstmt.setString(27, getInsuredSex());
/*      */       }
/*  830 */       if ((getInsuredBirthday() == null) || (getInsuredBirthday().equals("null")))
/*  831 */         pstmt.setNull(28, 91);
/*      */       else {
/*  833 */         pstmt.setDate(28, Date.valueOf(getInsuredBirthday()));
/*      */       }
/*  835 */       pstmt.setInt(29, getInsuredAppAge());
/*  836 */       pstmt.setInt(30, getInsuredPeoples());
/*  837 */       if ((getOccupationType() == null) || (getOccupationType().equals("null")))
/*  838 */         pstmt.setNull(31, 12);
/*      */       else {
/*  840 */         pstmt.setString(31, getOccupationType());
/*      */       }
/*  842 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  843 */         pstmt.setNull(32, 12);
/*      */       else {
/*  845 */         pstmt.setString(32, getAppntNo());
/*      */       }
/*  847 */       if ((getAppntName() == null) || (getAppntName().equals("null")))
/*  848 */         pstmt.setNull(33, 12);
/*      */       else {
/*  850 */         pstmt.setString(33, getAppntName());
/*      */       }
/*  852 */       if ((getCValiDate() == null) || (getCValiDate().equals("null")))
/*  853 */         pstmt.setNull(34, 91);
/*      */       else {
/*  855 */         pstmt.setDate(34, Date.valueOf(getCValiDate()));
/*      */       }
/*  857 */       if ((getSignCom() == null) || (getSignCom().equals("null")))
/*  858 */         pstmt.setNull(35, 12);
/*      */       else {
/*  860 */         pstmt.setString(35, getSignCom());
/*      */       }
/*  862 */       if ((getSignDate() == null) || (getSignDate().equals("null")))
/*  863 */         pstmt.setNull(36, 91);
/*      */       else {
/*  865 */         pstmt.setDate(36, Date.valueOf(getSignDate()));
/*      */       }
/*  867 */       if ((getSignTime() == null) || (getSignTime().equals("null")))
/*  868 */         pstmt.setNull(37, 12);
/*      */       else {
/*  870 */         pstmt.setString(37, getSignTime());
/*      */       }
/*  872 */       if ((getFirstPayDate() == null) || (getFirstPayDate().equals("null")))
/*  873 */         pstmt.setNull(38, 91);
/*      */       else {
/*  875 */         pstmt.setDate(38, Date.valueOf(getFirstPayDate()));
/*      */       }
/*  877 */       if ((getPayEndDate() == null) || (getPayEndDate().equals("null")))
/*  878 */         pstmt.setNull(39, 91);
/*      */       else {
/*  880 */         pstmt.setDate(39, Date.valueOf(getPayEndDate()));
/*      */       }
/*  882 */       if ((getPaytoDate() == null) || (getPaytoDate().equals("null")))
/*  883 */         pstmt.setNull(40, 91);
/*      */       else {
/*  885 */         pstmt.setDate(40, Date.valueOf(getPaytoDate()));
/*      */       }
/*  887 */       if ((getGetStartDate() == null) || (getGetStartDate().equals("null")))
/*  888 */         pstmt.setNull(41, 91);
/*      */       else {
/*  890 */         pstmt.setDate(41, Date.valueOf(getGetStartDate()));
/*      */       }
/*  892 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  893 */         pstmt.setNull(42, 91);
/*      */       else {
/*  895 */         pstmt.setDate(42, Date.valueOf(getEndDate()));
/*      */       }
/*  897 */       if ((getAcciEndDate() == null) || (getAcciEndDate().equals("null")))
/*  898 */         pstmt.setNull(43, 91);
/*      */       else {
/*  900 */         pstmt.setDate(43, Date.valueOf(getAcciEndDate()));
/*      */       }
/*  902 */       if ((getGetYearFlag() == null) || (getGetYearFlag().equals("null")))
/*  903 */         pstmt.setNull(44, 12);
/*      */       else {
/*  905 */         pstmt.setString(44, getGetYearFlag());
/*      */       }
/*  907 */       pstmt.setInt(45, getGetYear());
/*  908 */       if ((getPayEndYearFlag() == null) || (getPayEndYearFlag().equals("null")))
/*  909 */         pstmt.setNull(46, 12);
/*      */       else {
/*  911 */         pstmt.setString(46, getPayEndYearFlag());
/*      */       }
/*  913 */       pstmt.setInt(47, getPayEndYear());
/*  914 */       if ((getInsuYearFlag() == null) || (getInsuYearFlag().equals("null")))
/*  915 */         pstmt.setNull(48, 12);
/*      */       else {
/*  917 */         pstmt.setString(48, getInsuYearFlag());
/*      */       }
/*  919 */       pstmt.setInt(49, getInsuYear());
/*  920 */       if ((getAcciYearFlag() == null) || (getAcciYearFlag().equals("null")))
/*  921 */         pstmt.setNull(50, 12);
/*      */       else {
/*  923 */         pstmt.setString(50, getAcciYearFlag());
/*      */       }
/*  925 */       pstmt.setInt(51, getAcciYear());
/*  926 */       if ((getGetStartType() == null) || (getGetStartType().equals("null")))
/*  927 */         pstmt.setNull(52, 12);
/*      */       else {
/*  929 */         pstmt.setString(52, getGetStartType());
/*      */       }
/*  931 */       if ((getSpecifyValiDate() == null) || (getSpecifyValiDate().equals("null")))
/*  932 */         pstmt.setNull(53, 12);
/*      */       else {
/*  934 */         pstmt.setString(53, getSpecifyValiDate());
/*      */       }
/*  936 */       if ((getPayMode() == null) || (getPayMode().equals("null")))
/*  937 */         pstmt.setNull(54, 12);
/*      */       else {
/*  939 */         pstmt.setString(54, getPayMode());
/*      */       }
/*  941 */       if ((getPayLocation() == null) || (getPayLocation().equals("null")))
/*  942 */         pstmt.setNull(55, 12);
/*      */       else {
/*  944 */         pstmt.setString(55, getPayLocation());
/*      */       }
/*  946 */       pstmt.setInt(56, getPayIntv());
/*  947 */       pstmt.setInt(57, getPayYears());
/*  948 */       pstmt.setInt(58, getYears());
/*  949 */       pstmt.setDouble(59, getManageFeeRate());
/*  950 */       pstmt.setDouble(60, getFloatRate());
/*  951 */       pstmt.setDouble(61, getPremRate());
/*  952 */       if ((getPremToAmnt() == null) || (getPremToAmnt().equals("null")))
/*  953 */         pstmt.setNull(62, 12);
/*      */       else {
/*  955 */         pstmt.setString(62, getPremToAmnt());
/*      */       }
/*  957 */       pstmt.setDouble(63, getMult());
/*  958 */       pstmt.setDouble(64, getStandPrem());
/*  959 */       pstmt.setDouble(65, getPrem());
/*  960 */       pstmt.setDouble(66, getSumPrem());
/*  961 */       pstmt.setDouble(67, getAmnt());
/*  962 */       pstmt.setDouble(68, getRiskAmnt());
/*  963 */       pstmt.setDouble(69, getLeavingMoney());
/*  964 */       pstmt.setInt(70, getEndorseTimes());
/*  965 */       pstmt.setInt(71, getClaimTimes());
/*  966 */       pstmt.setInt(72, getLiveTimes());
/*  967 */       pstmt.setInt(73, getRenewCount());
/*  968 */       if ((getLastGetDate() == null) || (getLastGetDate().equals("null")))
/*  969 */         pstmt.setNull(74, 91);
/*      */       else {
/*  971 */         pstmt.setDate(74, Date.valueOf(getLastGetDate()));
/*      */       }
/*  973 */       if ((getLastLoanDate() == null) || (getLastLoanDate().equals("null")))
/*  974 */         pstmt.setNull(75, 91);
/*      */       else {
/*  976 */         pstmt.setDate(75, Date.valueOf(getLastLoanDate()));
/*      */       }
/*  978 */       if ((getLastRegetDate() == null) || (getLastRegetDate().equals("null")))
/*  979 */         pstmt.setNull(76, 91);
/*      */       else {
/*  981 */         pstmt.setDate(76, Date.valueOf(getLastRegetDate()));
/*      */       }
/*  983 */       if ((getLastEdorDate() == null) || (getLastEdorDate().equals("null")))
/*  984 */         pstmt.setNull(77, 91);
/*      */       else {
/*  986 */         pstmt.setDate(77, Date.valueOf(getLastEdorDate()));
/*      */       }
/*  988 */       if ((getLastRevDate() == null) || (getLastRevDate().equals("null")))
/*  989 */         pstmt.setNull(78, 91);
/*      */       else {
/*  991 */         pstmt.setDate(78, Date.valueOf(getLastRevDate()));
/*      */       }
/*  993 */       if ((getRnewFlag() == null) || (getRnewFlag().equals("null")))
/*  994 */         pstmt.setNull(79, 12);
/*      */       else {
/*  996 */         pstmt.setString(79, getRnewFlag());
/*      */       }
/*  998 */       if ((getStopFlag() == null) || (getStopFlag().equals("null")))
/*  999 */         pstmt.setNull(80, 12);
/*      */       else {
/* 1001 */         pstmt.setString(80, getStopFlag());
/*      */       }
/* 1003 */       if ((getExpiryFlag() == null) || (getExpiryFlag().equals("null")))
/* 1004 */         pstmt.setNull(81, 12);
/*      */       else {
/* 1006 */         pstmt.setString(81, getExpiryFlag());
/*      */       }
/* 1008 */       if ((getAutoPayFlag() == null) || (getAutoPayFlag().equals("null")))
/* 1009 */         pstmt.setNull(82, 12);
/*      */       else {
/* 1011 */         pstmt.setString(82, getAutoPayFlag());
/*      */       }
/* 1013 */       if ((getInterestDifFlag() == null) || (getInterestDifFlag().equals("null")))
/* 1014 */         pstmt.setNull(83, 12);
/*      */       else {
/* 1016 */         pstmt.setString(83, getInterestDifFlag());
/*      */       }
/* 1018 */       if ((getSubFlag() == null) || (getSubFlag().equals("null")))
/* 1019 */         pstmt.setNull(84, 12);
/*      */       else {
/* 1021 */         pstmt.setString(84, getSubFlag());
/*      */       }
/* 1023 */       if ((getBnfFlag() == null) || (getBnfFlag().equals("null")))
/* 1024 */         pstmt.setNull(85, 12);
/*      */       else {
/* 1026 */         pstmt.setString(85, getBnfFlag());
/*      */       }
/* 1028 */       if ((getHealthCheckFlag() == null) || (getHealthCheckFlag().equals("null")))
/* 1029 */         pstmt.setNull(86, 12);
/*      */       else {
/* 1031 */         pstmt.setString(86, getHealthCheckFlag());
/*      */       }
/* 1033 */       if ((getImpartFlag() == null) || (getImpartFlag().equals("null")))
/* 1034 */         pstmt.setNull(87, 12);
/*      */       else {
/* 1036 */         pstmt.setString(87, getImpartFlag());
/*      */       }
/* 1038 */       if ((getReinsureFlag() == null) || (getReinsureFlag().equals("null")))
/* 1039 */         pstmt.setNull(88, 12);
/*      */       else {
/* 1041 */         pstmt.setString(88, getReinsureFlag());
/*      */       }
/* 1043 */       if ((getAgentPayFlag() == null) || (getAgentPayFlag().equals("null")))
/* 1044 */         pstmt.setNull(89, 12);
/*      */       else {
/* 1046 */         pstmt.setString(89, getAgentPayFlag());
/*      */       }
/* 1048 */       if ((getAgentGetFlag() == null) || (getAgentGetFlag().equals("null")))
/* 1049 */         pstmt.setNull(90, 12);
/*      */       else {
/* 1051 */         pstmt.setString(90, getAgentGetFlag());
/*      */       }
/* 1053 */       if ((getLiveGetMode() == null) || (getLiveGetMode().equals("null")))
/* 1054 */         pstmt.setNull(91, 12);
/*      */       else {
/* 1056 */         pstmt.setString(91, getLiveGetMode());
/*      */       }
/* 1058 */       if ((getDeadGetMode() == null) || (getDeadGetMode().equals("null")))
/* 1059 */         pstmt.setNull(92, 12);
/*      */       else {
/* 1061 */         pstmt.setString(92, getDeadGetMode());
/*      */       }
/* 1063 */       if ((getBonusGetMode() == null) || (getBonusGetMode().equals("null")))
/* 1064 */         pstmt.setNull(93, 12);
/*      */       else {
/* 1066 */         pstmt.setString(93, getBonusGetMode());
/*      */       }
/* 1068 */       if ((getDeadAmntType() == null) || (getDeadAmntType().equals("null")))
/* 1069 */         pstmt.setNull(94, 12);
/*      */       else {
/* 1071 */         pstmt.setString(94, getDeadAmntType());
/*      */       }
/* 1073 */       pstmt.setDouble(95, getTopUpPrem());
/* 1074 */       if ((getBonusMan() == null) || (getBonusMan().equals("null")))
/* 1075 */         pstmt.setNull(96, 12);
/*      */       else {
/* 1077 */         pstmt.setString(96, getBonusMan());
/*      */       }
/* 1079 */       if ((getDeadFlag() == null) || (getDeadFlag().equals("null")))
/* 1080 */         pstmt.setNull(97, 12);
/*      */       else {
/* 1082 */         pstmt.setString(97, getDeadFlag());
/*      */       }
/* 1084 */       if ((getSmokeFlag() == null) || (getSmokeFlag().equals("null")))
/* 1085 */         pstmt.setNull(98, 12);
/*      */       else {
/* 1087 */         pstmt.setString(98, getSmokeFlag());
/*      */       }
/* 1089 */       if ((getRemark() == null) || (getRemark().equals("null")))
/* 1090 */         pstmt.setNull(99, 12);
/*      */       else {
/* 1092 */         pstmt.setString(99, getRemark());
/*      */       }
/* 1094 */       if ((getApproveFlag() == null) || (getApproveFlag().equals("null")))
/* 1095 */         pstmt.setNull(100, 12);
/*      */       else {
/* 1097 */         pstmt.setString(100, getApproveFlag());
/*      */       }
/* 1099 */       if ((getApproveCode() == null) || (getApproveCode().equals("null")))
/* 1100 */         pstmt.setNull(101, 12);
/*      */       else {
/* 1102 */         pstmt.setString(101, getApproveCode());
/*      */       }
/* 1104 */       if ((getApproveDate() == null) || (getApproveDate().equals("null")))
/* 1105 */         pstmt.setNull(102, 91);
/*      */       else {
/* 1107 */         pstmt.setDate(102, Date.valueOf(getApproveDate()));
/*      */       }
/* 1109 */       if ((getApproveTime() == null) || (getApproveTime().equals("null")))
/* 1110 */         pstmt.setNull(103, 12);
/*      */       else {
/* 1112 */         pstmt.setString(103, getApproveTime());
/*      */       }
/* 1114 */       if ((getUWFlag() == null) || (getUWFlag().equals("null")))
/* 1115 */         pstmt.setNull(104, 12);
/*      */       else {
/* 1117 */         pstmt.setString(104, getUWFlag());
/*      */       }
/* 1119 */       if ((getUWCode() == null) || (getUWCode().equals("null")))
/* 1120 */         pstmt.setNull(105, 12);
/*      */       else {
/* 1122 */         pstmt.setString(105, getUWCode());
/*      */       }
/* 1124 */       if ((getUWDate() == null) || (getUWDate().equals("null")))
/* 1125 */         pstmt.setNull(106, 91);
/*      */       else {
/* 1127 */         pstmt.setDate(106, Date.valueOf(getUWDate()));
/*      */       }
/* 1129 */       if ((getUWTime() == null) || (getUWTime().equals("null")))
/* 1130 */         pstmt.setNull(107, 12);
/*      */       else {
/* 1132 */         pstmt.setString(107, getUWTime());
/*      */       }
/* 1134 */       if ((getPolApplyDate() == null) || (getPolApplyDate().equals("null")))
/* 1135 */         pstmt.setNull(108, 91);
/*      */       else {
/* 1137 */         pstmt.setDate(108, Date.valueOf(getPolApplyDate()));
/*      */       }
/* 1139 */       if ((getAppFlag() == null) || (getAppFlag().equals("null")))
/* 1140 */         pstmt.setNull(109, 12);
/*      */       else {
/* 1142 */         pstmt.setString(109, getAppFlag());
/*      */       }
/* 1144 */       if ((getSaleChnlDetail() == null) || (getSaleChnlDetail().equals("null")))
/* 1145 */         pstmt.setNull(110, 12);
/*      */       else {
/* 1147 */         pstmt.setString(110, getSaleChnlDetail());
/*      */       }
/* 1149 */       if ((getPolState() == null) || (getPolState().equals("null")))
/* 1150 */         pstmt.setNull(111, 12);
/*      */       else {
/* 1152 */         pstmt.setString(111, getPolState());
/*      */       }
/* 1154 */       if ((getStandbyFlag1() == null) || (getStandbyFlag1().equals("null")))
/* 1155 */         pstmt.setNull(112, 12);
/*      */       else {
/* 1157 */         pstmt.setString(112, getStandbyFlag1());
/*      */       }
/* 1159 */       if ((getStandbyFlag2() == null) || (getStandbyFlag2().equals("null")))
/* 1160 */         pstmt.setNull(113, 12);
/*      */       else {
/* 1162 */         pstmt.setString(113, getStandbyFlag2());
/*      */       }
/* 1164 */       if ((getStandbyFlag3() == null) || (getStandbyFlag3().equals("null")))
/* 1165 */         pstmt.setNull(114, 12);
/*      */       else {
/* 1167 */         pstmt.setString(114, getStandbyFlag3());
/*      */       }
/* 1169 */       if ((getOperator() == null) || (getOperator().equals("null")))
/* 1170 */         pstmt.setNull(115, 12);
/*      */       else {
/* 1172 */         pstmt.setString(115, getOperator());
/*      */       }
/* 1174 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/* 1175 */         pstmt.setNull(116, 91);
/*      */       else {
/* 1177 */         pstmt.setDate(116, Date.valueOf(getMakeDate()));
/*      */       }
/* 1179 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/* 1180 */         pstmt.setNull(117, 12);
/*      */       else {
/* 1182 */         pstmt.setString(117, getMakeTime());
/*      */       }
/* 1184 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/* 1185 */         pstmt.setNull(118, 91);
/*      */       else {
/* 1187 */         pstmt.setDate(118, Date.valueOf(getModifyDate()));
/*      */       }
/* 1189 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/* 1190 */         pstmt.setNull(119, 12);
/*      */       else {
/* 1192 */         pstmt.setString(119, getModifyTime());
/*      */       }
/*      */ 
/* 1195 */       pstmt.executeUpdate();
/* 1196 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/* 1199 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 1200 */       CError tError = new CError();
/* 1201 */       tError.moduleName = "LNPPolDB";
/* 1202 */       tError.functionName = "insert()";
/* 1203 */       tError.errorMessage = ex.toString();
/* 1204 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1207 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/* 1210 */       if (!this.mflag)
/*      */         try {
/* 1212 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/* 1216 */       return false;
/*      */     }
/*      */ 
/* 1219 */     if (!this.mflag)
/*      */       try {
/* 1221 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/* 1225 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/* 1230 */     PreparedStatement pstmt = null;
/* 1231 */     ResultSet rs = null;
/*      */ 
/* 1233 */     if (!this.mflag) {
/* 1234 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1239 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPPol WHERE  PolNo = ?", 
/* 1240 */         1003, 1007);
/* 1241 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/* 1242 */         pstmt.setNull(1, 12);
/*      */       else {
/* 1244 */         pstmt.setString(1, getPolNo());
/*      */       }
/* 1246 */       rs = pstmt.executeQuery();
/* 1247 */       int i = 0;
/* 1248 */       if (rs.next())
/*      */       {
/* 1250 */         i++;
/* 1251 */         if (!setSchema(rs, i))
/*      */         {
/* 1254 */           CError tError = new CError();
/* 1255 */           tError.moduleName = "LNPPolDB";
/* 1256 */           tError.functionName = "getInfo";
/* 1257 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/* 1258 */           this.mErrors.addOneError(tError);
/*      */           try {
/* 1260 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/* 1263 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/* 1267 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/* 1271 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/* 1275 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/* 1278 */       if (i == 0)
/*      */       {
/* 1280 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1284 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/* 1288 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1294 */       CError tError = new CError();
/* 1295 */       tError.moduleName = "LNPPolDB";
/* 1296 */       tError.functionName = "getInfo";
/* 1297 */       tError.errorMessage = e.toString();
/* 1298 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1300 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/* 1303 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1307 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/* 1311 */       return false;
/*      */     }
/*      */ 
/* 1314 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1318 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/* 1323 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPPolSet query()
/*      */   {
/* 1328 */     Statement stmt = null;
/* 1329 */     ResultSet rs = null;
/* 1330 */     LNPPolSet aLNPPolSet = new LNPPolSet();
/*      */ 
/* 1332 */     if (!this.mflag) {
/* 1333 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1338 */       stmt = this.con.createStatement(1003, 1007);
/* 1339 */       SQLString sqlObj = new SQLString("LNPPol");
/* 1340 */       LNPPolSchema aSchema = getSchema();
/* 1341 */       sqlObj.setSQL(5, aSchema);
/* 1342 */       String sql = sqlObj.getSQL();
/*      */ 
/* 1344 */       rs = stmt.executeQuery(sql);
/* 1345 */       int i = 0;
/* 1346 */       while (rs.next())
/*      */       {
/* 1348 */         i++;
/* 1349 */         LNPPolSchema s1 = new LNPPolSchema();
/* 1350 */         s1.setSchema(rs, i);
/* 1351 */         aLNPPolSet.add(s1);
/*      */       }try {
/* 1353 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1359 */       CError tError = new CError();
/* 1360 */       tError.moduleName = "LNPPolDB";
/* 1361 */       tError.functionName = "query";
/* 1362 */       tError.errorMessage = e.toString();
/* 1363 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1365 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1368 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1372 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1378 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1382 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1387 */     return aLNPPolSet;
/*      */   }
/*      */ 
/*      */   public LNPPolSet executeQuery(String sql)
/*      */   {
/* 1392 */     Statement stmt = null;
/* 1393 */     ResultSet rs = null;
/* 1394 */     LNPPolSet aLNPPolSet = new LNPPolSet();
/*      */ 
/* 1396 */     if (!this.mflag) {
/* 1397 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1402 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1404 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1405 */       int i = 0;
/* 1406 */       while (rs.next())
/*      */       {
/* 1408 */         i++;
/* 1409 */         LNPPolSchema s1 = new LNPPolSchema();
/* 1410 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1413 */           CError tError = new CError();
/* 1414 */           tError.moduleName = "LNPPolDB";
/* 1415 */           tError.functionName = "executeQuery";
/* 1416 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 1417 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1419 */         aLNPPolSet.add(s1);
/*      */       }try {
/* 1421 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1427 */       CError tError = new CError();
/* 1428 */       tError.moduleName = "LNPPolDB";
/* 1429 */       tError.functionName = "executeQuery";
/* 1430 */       tError.errorMessage = e.toString();
/* 1431 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1433 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1436 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1440 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1446 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1450 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1455 */     return aLNPPolSet;
/*      */   }
/*      */ 
/*      */   public LNPPolSet query(int nStart, int nCount)
/*      */   {
/* 1460 */     Statement stmt = null;
/* 1461 */     ResultSet rs = null;
/* 1462 */     LNPPolSet aLNPPolSet = new LNPPolSet();
/*      */ 
/* 1464 */     if (!this.mflag) {
/* 1465 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1470 */       stmt = this.con.createStatement(1003, 1007);
/* 1471 */       SQLString sqlObj = new SQLString("LNPPol");
/* 1472 */       LNPPolSchema aSchema = getSchema();
/* 1473 */       sqlObj.setSQL(5, aSchema);
/* 1474 */       String sql = sqlObj.getSQL();
/*      */ 
/* 1476 */       rs = stmt.executeQuery(sql);
/* 1477 */       int i = 0;
/* 1478 */       while (rs.next())
/*      */       {
/* 1480 */         i++;
/*      */ 
/* 1482 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1486 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1490 */         LNPPolSchema s1 = new LNPPolSchema();
/* 1491 */         s1.setSchema(rs, i);
/* 1492 */         aLNPPolSet.add(s1);
/*      */       }try {
/* 1494 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1500 */       CError tError = new CError();
/* 1501 */       tError.moduleName = "LNPPolDB";
/* 1502 */       tError.functionName = "query";
/* 1503 */       tError.errorMessage = e.toString();
/* 1504 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1506 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1509 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1513 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1519 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1523 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1528 */     return aLNPPolSet;
/*      */   }
/*      */ 
/*      */   public LNPPolSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/* 1533 */     Statement stmt = null;
/* 1534 */     ResultSet rs = null;
/* 1535 */     LNPPolSet aLNPPolSet = new LNPPolSet();
/*      */ 
/* 1537 */     if (!this.mflag) {
/* 1538 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1543 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1545 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1546 */       int i = 0;
/* 1547 */       while (rs.next())
/*      */       {
/* 1549 */         i++;
/*      */ 
/* 1551 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1555 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1559 */         LNPPolSchema s1 = new LNPPolSchema();
/* 1560 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1563 */           CError tError = new CError();
/* 1564 */           tError.moduleName = "LNPPolDB";
/* 1565 */           tError.functionName = "executeQuery";
/* 1566 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 1567 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1569 */         aLNPPolSet.add(s1);
/*      */       }try {
/* 1571 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1577 */       CError tError = new CError();
/* 1578 */       tError.moduleName = "LNPPolDB";
/* 1579 */       tError.functionName = "executeQuery";
/* 1580 */       tError.errorMessage = e.toString();
/* 1581 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1583 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1586 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1590 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1596 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1600 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1605 */     return aLNPPolSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1610 */     Statement stmt = null;
/*      */ 
/* 1612 */     if (!this.mflag) {
/* 1613 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1618 */       stmt = this.con.createStatement(1003, 1007);
/* 1619 */       SQLString sqlObj = new SQLString("LNPPol");
/* 1620 */       LNPPolSchema aSchema = getSchema();
/* 1621 */       sqlObj.setSQL(2, aSchema);
/* 1622 */       String sql = "update LNPPol " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1624 */       int operCount = stmt.executeUpdate(sql);
/* 1625 */       if (operCount == 0)
/*      */       {
/* 1628 */         CError tError = new CError();
/* 1629 */         tError.moduleName = "LNPPolDB";
/* 1630 */         tError.functionName = "update";
/* 1631 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 1632 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1634 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1638 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1642 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1648 */       CError tError = new CError();
/* 1649 */       tError.moduleName = "LNPPolDB";
/* 1650 */       tError.functionName = "update";
/* 1651 */       tError.errorMessage = e.toString();
/* 1652 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1654 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1656 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1660 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1664 */       return false;
/*      */     }
/*      */ 
/* 1667 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1671 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1676 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1682 */     if (this.mResultSet != null)
/*      */     {
/* 1685 */       CError tError = new CError();
/* 1686 */       tError.moduleName = "LNPPolDB";
/* 1687 */       tError.functionName = "prepareData";
/* 1688 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 1689 */       this.mErrors.addOneError(tError);
/* 1690 */       return false;
/*      */     }
/*      */ 
/* 1693 */     if (!this.mflag)
/*      */     {
/* 1695 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1699 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1700 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1705 */       CError tError = new CError();
/* 1706 */       tError.moduleName = "LNPPolDB";
/* 1707 */       tError.functionName = "prepareData";
/* 1708 */       tError.errorMessage = e.toString();
/* 1709 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1712 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1718 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1722 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1726 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1731 */       return false;
/*      */     }
/*      */ 
/* 1734 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1738 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1743 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1749 */     boolean flag = true;
/* 1750 */     if (this.mResultSet == null)
/*      */     {
/* 1752 */       CError tError = new CError();
/* 1753 */       tError.moduleName = "LNPPolDB";
/* 1754 */       tError.functionName = "hasMoreData";
/* 1755 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1756 */       this.mErrors.addOneError(tError);
/* 1757 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1761 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1765 */       CError tError = new CError();
/* 1766 */       tError.moduleName = "LNPPolDB";
/* 1767 */       tError.functionName = "hasMoreData";
/* 1768 */       tError.errorMessage = ex.toString();
/* 1769 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1772 */         this.mResultSet.close();
/* 1773 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1779 */         this.mStatement.close();
/* 1780 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1784 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1788 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1793 */       return false;
/*      */     }
/* 1795 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPPolSet getData()
/*      */   {
/* 1800 */     int tCount = 0;
/* 1801 */     LNPPolSet tLNPPolSet = new LNPPolSet();
/* 1802 */     LNPPolSchema tLNPPolSchema = null;
/* 1803 */     if (this.mResultSet == null)
/*      */     {
/* 1805 */       CError tError = new CError();
/* 1806 */       tError.moduleName = "LNPPolDB";
/* 1807 */       tError.functionName = "getData";
/* 1808 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1809 */       this.mErrors.addOneError(tError);
/* 1810 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1814 */       tCount = 1;
/* 1815 */       tLNPPolSchema = new LNPPolSchema();
/* 1816 */       tLNPPolSchema.setSchema(this.mResultSet, 1);
/* 1817 */       tLNPPolSet.add(tLNPPolSchema);
/*      */ 
/* 1819 */       while (tCount++ < 5000)
/*      */       {
/* 1821 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1823 */         tLNPPolSchema = new LNPPolSchema();
/* 1824 */         tLNPPolSchema.setSchema(this.mResultSet, 1);
/* 1825 */         tLNPPolSet.add(tLNPPolSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1831 */       CError tError = new CError();
/* 1832 */       tError.moduleName = "LNPPolDB";
/* 1833 */       tError.functionName = "getData";
/* 1834 */       tError.errorMessage = ex.toString();
/* 1835 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1838 */         this.mResultSet.close();
/* 1839 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1845 */         this.mStatement.close();
/* 1846 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1850 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1854 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1859 */       return null;
/*      */     }
/* 1861 */     return tLNPPolSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1866 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1869 */       if (this.mResultSet == null)
/*      */       {
/* 1871 */         CError tError = new CError();
/* 1872 */         tError.moduleName = "LNPPolDB";
/* 1873 */         tError.functionName = "closeData";
/* 1874 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1875 */         this.mErrors.addOneError(tError);
/* 1876 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1880 */         this.mResultSet.close();
/* 1881 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1886 */       CError tError = new CError();
/* 1887 */       tError.moduleName = "LNPPolDB";
/* 1888 */       tError.functionName = "closeData";
/* 1889 */       tError.errorMessage = ex2.toString();
/* 1890 */       this.mErrors.addOneError(tError);
/* 1891 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1895 */       if (this.mStatement == null)
/*      */       {
/* 1897 */         CError tError = new CError();
/* 1898 */         tError.moduleName = "LNPPolDB";
/* 1899 */         tError.functionName = "closeData";
/* 1900 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1901 */         this.mErrors.addOneError(tError);
/* 1902 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1906 */         this.mStatement.close();
/* 1907 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1912 */       CError tError = new CError();
/* 1913 */       tError.moduleName = "LNPPolDB";
/* 1914 */       tError.functionName = "closeData";
/* 1915 */       tError.errorMessage = ex3.toString();
/* 1916 */       this.mErrors.addOneError(tError);
/* 1917 */       flag = false;
/*      */     }
/* 1919 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPPolDB
 * JD-Core Version:    0.6.0
 */