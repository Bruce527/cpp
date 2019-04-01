/*      */ package com.sinosoft.banklns.lis.vdb;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ 
/*      */ public class LNPPolDBSet extends LNPPolSet
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   22 */   private boolean mflag = false;
/*      */ 
/*      */   public LNPPolDBSet(Connection tConnection)
/*      */   {
/*   28 */     this.con = tConnection;
/*   29 */     this.db = new DBOper(this.con, "LNPPol");
/*   30 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPPolDBSet()
/*      */   {
/*   35 */     this.db = new DBOper("LNPPol");
/*   36 */     this.con = this.db.getConnection();
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   41 */     if (this.db.deleteSQL(this))
/*      */     {
/*   43 */       return true;
/*      */     }
/*      */ 
/*   48 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   49 */     CError tError = new CError();
/*   50 */     tError.moduleName = "LNPPolDBSet";
/*   51 */     tError.functionName = "deleteSQL";
/*   52 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   53 */     this.mErrors.addOneError(tError);
/*   54 */     return false;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   61 */     PreparedStatement pstmt = null;
/*      */ 
/*   63 */     if (!this.mflag) {
/*   64 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   69 */       int tCount = size();
/*   70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPPol WHERE  PolNo = ?");
/*   71 */       for (int i = 1; i <= tCount; i++)
/*      */       {
/*   73 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/*   74 */           pstmt.setString(1, null);
/*      */         else {
/*   76 */           pstmt.setString(1, get(i).getPolNo());
/*      */         }
/*   78 */         pstmt.addBatch();
/*      */       }
/*   80 */       pstmt.executeBatch();
/*   81 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*   84 */       ex.printStackTrace();
/*   85 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   86 */       CError tError = new CError();
/*   87 */       tError.moduleName = "LNPPolDBSet";
/*   88 */       tError.functionName = "delete()";
/*   89 */       tError.errorMessage = ex.toString();
/*   90 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*   93 */         pstmt.close(); } catch (Exception e) {
/*   94 */         e.printStackTrace();
/*      */       }
/*   96 */       if (!this.mflag) {
/*      */         try {
/*   98 */           this.con.close(); } catch (Exception e) {
/*   99 */           e.printStackTrace();
/*      */         }
/*      */       }
/*  102 */       return false;
/*      */     }
/*      */ 
/*  105 */     if (!this.mflag) {
/*      */       try {
/*  107 */         this.con.close(); } catch (Exception e) {
/*  108 */         e.printStackTrace();
/*      */       }
/*      */     }
/*  111 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  117 */     PreparedStatement pstmt = null;
/*      */ 
/*  119 */     if (!this.mflag) {
/*  120 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  125 */       int tCount = size();
/*  126 */       pstmt = this.con.prepareStatement("UPDATE LNPPol SET  GrpContNo = ? , GrpPolNo = ? , ContNo = ? , ProposalContNo = ? , PolNo = ? , ProposalNo = ? , PrtNo = ? , ContType = ? , PolTypeFlag = ? , MainPolNo = ? , MasterPolNo = ? , KindCode = ? , RiskCode = ? , RiskVersion = ? , ManageCom = ? , AgentCom = ? , AgentType = ? , AgentCode = ? , AgentGroup = ? , AgentGroup1 = ? , AgentCode1 = ? , SaleChnl = ? , Handler = ? , InsuredNo = ? , InsuredId = ? , InsuredName = ? , InsuredSex = ? , InsuredBirthday = ? , InsuredAppAge = ? , InsuredPeoples = ? , OccupationType = ? , AppntNo = ? , AppntName = ? , CValiDate = ? , SignCom = ? , SignDate = ? , SignTime = ? , FirstPayDate = ? , PayEndDate = ? , PaytoDate = ? , GetStartDate = ? , EndDate = ? , AcciEndDate = ? , GetYearFlag = ? , GetYear = ? , PayEndYearFlag = ? , PayEndYear = ? , InsuYearFlag = ? , InsuYear = ? , AcciYearFlag = ? , AcciYear = ? , GetStartType = ? , SpecifyValiDate = ? , PayMode = ? , PayLocation = ? , PayIntv = ? , PayYears = ? , Years = ? , ManageFeeRate = ? , FloatRate = ? , PremRate = ? , PremToAmnt = ? , Mult = ? , StandPrem = ? , Prem = ? , SumPrem = ? , Amnt = ? , RiskAmnt = ? , LeavingMoney = ? , EndorseTimes = ? , ClaimTimes = ? , LiveTimes = ? , RenewCount = ? , LastGetDate = ? , LastLoanDate = ? , LastRegetDate = ? , LastEdorDate = ? , LastRevDate = ? , RnewFlag = ? , StopFlag = ? , ExpiryFlag = ? , AutoPayFlag = ? , InterestDifFlag = ? , SubFlag = ? , BnfFlag = ? , HealthCheckFlag = ? , ImpartFlag = ? , ReinsureFlag = ? , AgentPayFlag = ? , AgentGetFlag = ? , LiveGetMode = ? , DeadGetMode = ? , BonusGetMode = ? , DeadAmntType = ? , TopUpPrem = ? , BonusMan = ? , DeadFlag = ? , SmokeFlag = ? , Remark = ? , ApproveFlag = ? , ApproveCode = ? , ApproveDate = ? , ApproveTime = ? , UWFlag = ? , UWCode = ? , UWDate = ? , UWTime = ? , PolApplyDate = ? , AppFlag = ? , SaleChnlDetail = ? , PolState = ? , StandbyFlag1 = ? , StandbyFlag2 = ? , StandbyFlag3 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  PolNo = ?");
/*  127 */       for (int i = 1; i <= tCount; i++)
/*      */       {
/*  129 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/*  130 */           pstmt.setString(1, null);
/*      */         else {
/*  132 */           pstmt.setString(1, get(i).getGrpContNo());
/*      */         }
/*  134 */         if ((get(i).getGrpPolNo() == null) || (get(i).getGrpPolNo().equals("null")))
/*  135 */           pstmt.setString(2, null);
/*      */         else {
/*  137 */           pstmt.setString(2, get(i).getGrpPolNo());
/*      */         }
/*  139 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  140 */           pstmt.setString(3, null);
/*      */         else {
/*  142 */           pstmt.setString(3, get(i).getContNo());
/*      */         }
/*  144 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/*  145 */           pstmt.setString(4, null);
/*      */         else {
/*  147 */           pstmt.setString(4, get(i).getProposalContNo());
/*      */         }
/*  149 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/*  150 */           pstmt.setString(5, null);
/*      */         else {
/*  152 */           pstmt.setString(5, get(i).getPolNo());
/*      */         }
/*  154 */         if ((get(i).getProposalNo() == null) || (get(i).getProposalNo().equals("null")))
/*  155 */           pstmt.setString(6, null);
/*      */         else {
/*  157 */           pstmt.setString(6, get(i).getProposalNo());
/*      */         }
/*  159 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/*  160 */           pstmt.setString(7, null);
/*      */         else {
/*  162 */           pstmt.setString(7, get(i).getPrtNo());
/*      */         }
/*  164 */         if ((get(i).getContType() == null) || (get(i).getContType().equals("null")))
/*  165 */           pstmt.setString(8, null);
/*      */         else {
/*  167 */           pstmt.setString(8, get(i).getContType());
/*      */         }
/*  169 */         if ((get(i).getPolTypeFlag() == null) || (get(i).getPolTypeFlag().equals("null")))
/*  170 */           pstmt.setString(9, null);
/*      */         else {
/*  172 */           pstmt.setString(9, get(i).getPolTypeFlag());
/*      */         }
/*  174 */         if ((get(i).getMainPolNo() == null) || (get(i).getMainPolNo().equals("null")))
/*  175 */           pstmt.setString(10, null);
/*      */         else {
/*  177 */           pstmt.setString(10, get(i).getMainPolNo());
/*      */         }
/*  179 */         if ((get(i).getMasterPolNo() == null) || (get(i).getMasterPolNo().equals("null")))
/*  180 */           pstmt.setString(11, null);
/*      */         else {
/*  182 */           pstmt.setString(11, get(i).getMasterPolNo());
/*      */         }
/*  184 */         if ((get(i).getKindCode() == null) || (get(i).getKindCode().equals("null")))
/*  185 */           pstmt.setString(12, null);
/*      */         else {
/*  187 */           pstmt.setString(12, get(i).getKindCode());
/*      */         }
/*  189 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  190 */           pstmt.setString(13, null);
/*      */         else {
/*  192 */           pstmt.setString(13, get(i).getRiskCode());
/*      */         }
/*  194 */         if ((get(i).getRiskVersion() == null) || (get(i).getRiskVersion().equals("null")))
/*  195 */           pstmt.setString(14, null);
/*      */         else {
/*  197 */           pstmt.setString(14, get(i).getRiskVersion());
/*      */         }
/*  199 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/*  200 */           pstmt.setString(15, null);
/*      */         else {
/*  202 */           pstmt.setString(15, get(i).getManageCom());
/*      */         }
/*  204 */         if ((get(i).getAgentCom() == null) || (get(i).getAgentCom().equals("null")))
/*  205 */           pstmt.setString(16, null);
/*      */         else {
/*  207 */           pstmt.setString(16, get(i).getAgentCom());
/*      */         }
/*  209 */         if ((get(i).getAgentType() == null) || (get(i).getAgentType().equals("null")))
/*  210 */           pstmt.setString(17, null);
/*      */         else {
/*  212 */           pstmt.setString(17, get(i).getAgentType());
/*      */         }
/*  214 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*  215 */           pstmt.setString(18, null);
/*      */         else {
/*  217 */           pstmt.setString(18, get(i).getAgentCode());
/*      */         }
/*  219 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/*  220 */           pstmt.setString(19, null);
/*      */         else {
/*  222 */           pstmt.setString(19, get(i).getAgentGroup());
/*      */         }
/*  224 */         if ((get(i).getAgentGroup1() == null) || (get(i).getAgentGroup1().equals("null")))
/*  225 */           pstmt.setString(20, null);
/*      */         else {
/*  227 */           pstmt.setString(20, get(i).getAgentGroup1());
/*      */         }
/*  229 */         if ((get(i).getAgentCode1() == null) || (get(i).getAgentCode1().equals("null")))
/*  230 */           pstmt.setString(21, null);
/*      */         else {
/*  232 */           pstmt.setString(21, get(i).getAgentCode1());
/*      */         }
/*  234 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/*  235 */           pstmt.setString(22, null);
/*      */         else {
/*  237 */           pstmt.setString(22, get(i).getSaleChnl());
/*      */         }
/*  239 */         if ((get(i).getHandler() == null) || (get(i).getHandler().equals("null")))
/*  240 */           pstmt.setString(23, null);
/*      */         else {
/*  242 */           pstmt.setString(23, get(i).getHandler());
/*      */         }
/*  244 */         if ((get(i).getInsuredNo() == null) || (get(i).getInsuredNo().equals("null")))
/*  245 */           pstmt.setString(24, null);
/*      */         else {
/*  247 */           pstmt.setString(24, get(i).getInsuredNo());
/*      */         }
/*  249 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/*  250 */           pstmt.setString(25, null);
/*      */         else {
/*  252 */           pstmt.setString(25, get(i).getInsuredId());
/*      */         }
/*  254 */         if ((get(i).getInsuredName() == null) || (get(i).getInsuredName().equals("null")))
/*  255 */           pstmt.setString(26, null);
/*      */         else {
/*  257 */           pstmt.setString(26, get(i).getInsuredName());
/*      */         }
/*  259 */         if ((get(i).getInsuredSex() == null) || (get(i).getInsuredSex().equals("null")))
/*  260 */           pstmt.setString(27, null);
/*      */         else {
/*  262 */           pstmt.setString(27, get(i).getInsuredSex());
/*      */         }
/*  264 */         if ((get(i).getInsuredBirthday() == null) || (get(i).getInsuredBirthday().equals("null")))
/*  265 */           pstmt.setDate(28, null);
/*      */         else {
/*  267 */           pstmt.setDate(28, Date.valueOf(get(i).getInsuredBirthday()));
/*      */         }
/*  269 */         pstmt.setInt(29, get(i).getInsuredAppAge());
/*  270 */         pstmt.setInt(30, get(i).getInsuredPeoples());
/*  271 */         if ((get(i).getOccupationType() == null) || (get(i).getOccupationType().equals("null")))
/*  272 */           pstmt.setString(31, null);
/*      */         else {
/*  274 */           pstmt.setString(31, get(i).getOccupationType());
/*      */         }
/*  276 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/*  277 */           pstmt.setString(32, null);
/*      */         else {
/*  279 */           pstmt.setString(32, get(i).getAppntNo());
/*      */         }
/*  281 */         if ((get(i).getAppntName() == null) || (get(i).getAppntName().equals("null")))
/*  282 */           pstmt.setString(33, null);
/*      */         else {
/*  284 */           pstmt.setString(33, get(i).getAppntName());
/*      */         }
/*  286 */         if ((get(i).getCValiDate() == null) || (get(i).getCValiDate().equals("null")))
/*  287 */           pstmt.setDate(34, null);
/*      */         else {
/*  289 */           pstmt.setDate(34, Date.valueOf(get(i).getCValiDate()));
/*      */         }
/*  291 */         if ((get(i).getSignCom() == null) || (get(i).getSignCom().equals("null")))
/*  292 */           pstmt.setString(35, null);
/*      */         else {
/*  294 */           pstmt.setString(35, get(i).getSignCom());
/*      */         }
/*  296 */         if ((get(i).getSignDate() == null) || (get(i).getSignDate().equals("null")))
/*  297 */           pstmt.setDate(36, null);
/*      */         else {
/*  299 */           pstmt.setDate(36, Date.valueOf(get(i).getSignDate()));
/*      */         }
/*  301 */         if ((get(i).getSignTime() == null) || (get(i).getSignTime().equals("null")))
/*  302 */           pstmt.setString(37, null);
/*      */         else {
/*  304 */           pstmt.setString(37, get(i).getSignTime());
/*      */         }
/*  306 */         if ((get(i).getFirstPayDate() == null) || (get(i).getFirstPayDate().equals("null")))
/*  307 */           pstmt.setDate(38, null);
/*      */         else {
/*  309 */           pstmt.setDate(38, Date.valueOf(get(i).getFirstPayDate()));
/*      */         }
/*  311 */         if ((get(i).getPayEndDate() == null) || (get(i).getPayEndDate().equals("null")))
/*  312 */           pstmt.setDate(39, null);
/*      */         else {
/*  314 */           pstmt.setDate(39, Date.valueOf(get(i).getPayEndDate()));
/*      */         }
/*  316 */         if ((get(i).getPaytoDate() == null) || (get(i).getPaytoDate().equals("null")))
/*  317 */           pstmt.setDate(40, null);
/*      */         else {
/*  319 */           pstmt.setDate(40, Date.valueOf(get(i).getPaytoDate()));
/*      */         }
/*  321 */         if ((get(i).getGetStartDate() == null) || (get(i).getGetStartDate().equals("null")))
/*  322 */           pstmt.setDate(41, null);
/*      */         else {
/*  324 */           pstmt.setDate(41, Date.valueOf(get(i).getGetStartDate()));
/*      */         }
/*  326 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/*  327 */           pstmt.setDate(42, null);
/*      */         else {
/*  329 */           pstmt.setDate(42, Date.valueOf(get(i).getEndDate()));
/*      */         }
/*  331 */         if ((get(i).getAcciEndDate() == null) || (get(i).getAcciEndDate().equals("null")))
/*  332 */           pstmt.setDate(43, null);
/*      */         else {
/*  334 */           pstmt.setDate(43, Date.valueOf(get(i).getAcciEndDate()));
/*      */         }
/*  336 */         if ((get(i).getGetYearFlag() == null) || (get(i).getGetYearFlag().equals("null")))
/*  337 */           pstmt.setString(44, null);
/*      */         else {
/*  339 */           pstmt.setString(44, get(i).getGetYearFlag());
/*      */         }
/*  341 */         pstmt.setInt(45, get(i).getGetYear());
/*  342 */         if ((get(i).getPayEndYearFlag() == null) || (get(i).getPayEndYearFlag().equals("null")))
/*  343 */           pstmt.setString(46, null);
/*      */         else {
/*  345 */           pstmt.setString(46, get(i).getPayEndYearFlag());
/*      */         }
/*  347 */         pstmt.setInt(47, get(i).getPayEndYear());
/*  348 */         if ((get(i).getInsuYearFlag() == null) || (get(i).getInsuYearFlag().equals("null")))
/*  349 */           pstmt.setString(48, null);
/*      */         else {
/*  351 */           pstmt.setString(48, get(i).getInsuYearFlag());
/*      */         }
/*  353 */         pstmt.setInt(49, get(i).getInsuYear());
/*  354 */         if ((get(i).getAcciYearFlag() == null) || (get(i).getAcciYearFlag().equals("null")))
/*  355 */           pstmt.setString(50, null);
/*      */         else {
/*  357 */           pstmt.setString(50, get(i).getAcciYearFlag());
/*      */         }
/*  359 */         pstmt.setInt(51, get(i).getAcciYear());
/*  360 */         if ((get(i).getGetStartType() == null) || (get(i).getGetStartType().equals("null")))
/*  361 */           pstmt.setString(52, null);
/*      */         else {
/*  363 */           pstmt.setString(52, get(i).getGetStartType());
/*      */         }
/*  365 */         if ((get(i).getSpecifyValiDate() == null) || (get(i).getSpecifyValiDate().equals("null")))
/*  366 */           pstmt.setString(53, null);
/*      */         else {
/*  368 */           pstmt.setString(53, get(i).getSpecifyValiDate());
/*      */         }
/*  370 */         if ((get(i).getPayMode() == null) || (get(i).getPayMode().equals("null")))
/*  371 */           pstmt.setString(54, null);
/*      */         else {
/*  373 */           pstmt.setString(54, get(i).getPayMode());
/*      */         }
/*  375 */         if ((get(i).getPayLocation() == null) || (get(i).getPayLocation().equals("null")))
/*  376 */           pstmt.setString(55, null);
/*      */         else {
/*  378 */           pstmt.setString(55, get(i).getPayLocation());
/*      */         }
/*  380 */         pstmt.setInt(56, get(i).getPayIntv());
/*  381 */         pstmt.setInt(57, get(i).getPayYears());
/*  382 */         pstmt.setInt(58, get(i).getYears());
/*  383 */         pstmt.setDouble(59, get(i).getManageFeeRate());
/*  384 */         pstmt.setDouble(60, get(i).getFloatRate());
/*  385 */         pstmt.setDouble(61, get(i).getPremRate());
/*  386 */         if ((get(i).getPremToAmnt() == null) || (get(i).getPremToAmnt().equals("null")))
/*  387 */           pstmt.setString(62, null);
/*      */         else {
/*  389 */           pstmt.setString(62, get(i).getPremToAmnt());
/*      */         }
/*  391 */         pstmt.setDouble(63, get(i).getMult());
/*  392 */         pstmt.setDouble(64, get(i).getStandPrem());
/*  393 */         pstmt.setDouble(65, get(i).getPrem());
/*  394 */         pstmt.setDouble(66, get(i).getSumPrem());
/*  395 */         pstmt.setDouble(67, get(i).getAmnt());
/*  396 */         pstmt.setDouble(68, get(i).getRiskAmnt());
/*  397 */         pstmt.setDouble(69, get(i).getLeavingMoney());
/*  398 */         pstmt.setInt(70, get(i).getEndorseTimes());
/*  399 */         pstmt.setInt(71, get(i).getClaimTimes());
/*  400 */         pstmt.setInt(72, get(i).getLiveTimes());
/*  401 */         pstmt.setInt(73, get(i).getRenewCount());
/*  402 */         if ((get(i).getLastGetDate() == null) || (get(i).getLastGetDate().equals("null")))
/*  403 */           pstmt.setDate(74, null);
/*      */         else {
/*  405 */           pstmt.setDate(74, Date.valueOf(get(i).getLastGetDate()));
/*      */         }
/*  407 */         if ((get(i).getLastLoanDate() == null) || (get(i).getLastLoanDate().equals("null")))
/*  408 */           pstmt.setDate(75, null);
/*      */         else {
/*  410 */           pstmt.setDate(75, Date.valueOf(get(i).getLastLoanDate()));
/*      */         }
/*  412 */         if ((get(i).getLastRegetDate() == null) || (get(i).getLastRegetDate().equals("null")))
/*  413 */           pstmt.setDate(76, null);
/*      */         else {
/*  415 */           pstmt.setDate(76, Date.valueOf(get(i).getLastRegetDate()));
/*      */         }
/*  417 */         if ((get(i).getLastEdorDate() == null) || (get(i).getLastEdorDate().equals("null")))
/*  418 */           pstmt.setDate(77, null);
/*      */         else {
/*  420 */           pstmt.setDate(77, Date.valueOf(get(i).getLastEdorDate()));
/*      */         }
/*  422 */         if ((get(i).getLastRevDate() == null) || (get(i).getLastRevDate().equals("null")))
/*  423 */           pstmt.setDate(78, null);
/*      */         else {
/*  425 */           pstmt.setDate(78, Date.valueOf(get(i).getLastRevDate()));
/*      */         }
/*  427 */         if ((get(i).getRnewFlag() == null) || (get(i).getRnewFlag().equals("null")))
/*  428 */           pstmt.setString(79, null);
/*      */         else {
/*  430 */           pstmt.setString(79, get(i).getRnewFlag());
/*      */         }
/*  432 */         if ((get(i).getStopFlag() == null) || (get(i).getStopFlag().equals("null")))
/*  433 */           pstmt.setString(80, null);
/*      */         else {
/*  435 */           pstmt.setString(80, get(i).getStopFlag());
/*      */         }
/*  437 */         if ((get(i).getExpiryFlag() == null) || (get(i).getExpiryFlag().equals("null")))
/*  438 */           pstmt.setString(81, null);
/*      */         else {
/*  440 */           pstmt.setString(81, get(i).getExpiryFlag());
/*      */         }
/*  442 */         if ((get(i).getAutoPayFlag() == null) || (get(i).getAutoPayFlag().equals("null")))
/*  443 */           pstmt.setString(82, null);
/*      */         else {
/*  445 */           pstmt.setString(82, get(i).getAutoPayFlag());
/*      */         }
/*  447 */         if ((get(i).getInterestDifFlag() == null) || (get(i).getInterestDifFlag().equals("null")))
/*  448 */           pstmt.setString(83, null);
/*      */         else {
/*  450 */           pstmt.setString(83, get(i).getInterestDifFlag());
/*      */         }
/*  452 */         if ((get(i).getSubFlag() == null) || (get(i).getSubFlag().equals("null")))
/*  453 */           pstmt.setString(84, null);
/*      */         else {
/*  455 */           pstmt.setString(84, get(i).getSubFlag());
/*      */         }
/*  457 */         if ((get(i).getBnfFlag() == null) || (get(i).getBnfFlag().equals("null")))
/*  458 */           pstmt.setString(85, null);
/*      */         else {
/*  460 */           pstmt.setString(85, get(i).getBnfFlag());
/*      */         }
/*  462 */         if ((get(i).getHealthCheckFlag() == null) || (get(i).getHealthCheckFlag().equals("null")))
/*  463 */           pstmt.setString(86, null);
/*      */         else {
/*  465 */           pstmt.setString(86, get(i).getHealthCheckFlag());
/*      */         }
/*  467 */         if ((get(i).getImpartFlag() == null) || (get(i).getImpartFlag().equals("null")))
/*  468 */           pstmt.setString(87, null);
/*      */         else {
/*  470 */           pstmt.setString(87, get(i).getImpartFlag());
/*      */         }
/*  472 */         if ((get(i).getReinsureFlag() == null) || (get(i).getReinsureFlag().equals("null")))
/*  473 */           pstmt.setString(88, null);
/*      */         else {
/*  475 */           pstmt.setString(88, get(i).getReinsureFlag());
/*      */         }
/*  477 */         if ((get(i).getAgentPayFlag() == null) || (get(i).getAgentPayFlag().equals("null")))
/*  478 */           pstmt.setString(89, null);
/*      */         else {
/*  480 */           pstmt.setString(89, get(i).getAgentPayFlag());
/*      */         }
/*  482 */         if ((get(i).getAgentGetFlag() == null) || (get(i).getAgentGetFlag().equals("null")))
/*  483 */           pstmt.setString(90, null);
/*      */         else {
/*  485 */           pstmt.setString(90, get(i).getAgentGetFlag());
/*      */         }
/*  487 */         if ((get(i).getLiveGetMode() == null) || (get(i).getLiveGetMode().equals("null")))
/*  488 */           pstmt.setString(91, null);
/*      */         else {
/*  490 */           pstmt.setString(91, get(i).getLiveGetMode());
/*      */         }
/*  492 */         if ((get(i).getDeadGetMode() == null) || (get(i).getDeadGetMode().equals("null")))
/*  493 */           pstmt.setString(92, null);
/*      */         else {
/*  495 */           pstmt.setString(92, get(i).getDeadGetMode());
/*      */         }
/*  497 */         if ((get(i).getBonusGetMode() == null) || (get(i).getBonusGetMode().equals("null")))
/*  498 */           pstmt.setString(93, null);
/*      */         else {
/*  500 */           pstmt.setString(93, get(i).getBonusGetMode());
/*      */         }
/*  502 */         if ((get(i).getDeadAmntType() == null) || (get(i).getDeadAmntType().equals("null")))
/*  503 */           pstmt.setString(94, null);
/*      */         else {
/*  505 */           pstmt.setString(94, get(i).getDeadAmntType());
/*      */         }
/*  507 */         pstmt.setDouble(95, get(i).getTopUpPrem());
/*  508 */         if ((get(i).getBonusMan() == null) || (get(i).getBonusMan().equals("null")))
/*  509 */           pstmt.setString(96, null);
/*      */         else {
/*  511 */           pstmt.setString(96, get(i).getBonusMan());
/*      */         }
/*  513 */         if ((get(i).getDeadFlag() == null) || (get(i).getDeadFlag().equals("null")))
/*  514 */           pstmt.setString(97, null);
/*      */         else {
/*  516 */           pstmt.setString(97, get(i).getDeadFlag());
/*      */         }
/*  518 */         if ((get(i).getSmokeFlag() == null) || (get(i).getSmokeFlag().equals("null")))
/*  519 */           pstmt.setString(98, null);
/*      */         else {
/*  521 */           pstmt.setString(98, get(i).getSmokeFlag());
/*      */         }
/*  523 */         if ((get(i).getRemark() == null) || (get(i).getRemark().equals("null")))
/*  524 */           pstmt.setString(99, null);
/*      */         else {
/*  526 */           pstmt.setString(99, get(i).getRemark());
/*      */         }
/*  528 */         if ((get(i).getApproveFlag() == null) || (get(i).getApproveFlag().equals("null")))
/*  529 */           pstmt.setString(100, null);
/*      */         else {
/*  531 */           pstmt.setString(100, get(i).getApproveFlag());
/*      */         }
/*  533 */         if ((get(i).getApproveCode() == null) || (get(i).getApproveCode().equals("null")))
/*  534 */           pstmt.setString(101, null);
/*      */         else {
/*  536 */           pstmt.setString(101, get(i).getApproveCode());
/*      */         }
/*  538 */         if ((get(i).getApproveDate() == null) || (get(i).getApproveDate().equals("null")))
/*  539 */           pstmt.setDate(102, null);
/*      */         else {
/*  541 */           pstmt.setDate(102, Date.valueOf(get(i).getApproveDate()));
/*      */         }
/*  543 */         if ((get(i).getApproveTime() == null) || (get(i).getApproveTime().equals("null")))
/*  544 */           pstmt.setString(103, null);
/*      */         else {
/*  546 */           pstmt.setString(103, get(i).getApproveTime());
/*      */         }
/*  548 */         if ((get(i).getUWFlag() == null) || (get(i).getUWFlag().equals("null")))
/*  549 */           pstmt.setString(104, null);
/*      */         else {
/*  551 */           pstmt.setString(104, get(i).getUWFlag());
/*      */         }
/*  553 */         if ((get(i).getUWCode() == null) || (get(i).getUWCode().equals("null")))
/*  554 */           pstmt.setString(105, null);
/*      */         else {
/*  556 */           pstmt.setString(105, get(i).getUWCode());
/*      */         }
/*  558 */         if ((get(i).getUWDate() == null) || (get(i).getUWDate().equals("null")))
/*  559 */           pstmt.setDate(106, null);
/*      */         else {
/*  561 */           pstmt.setDate(106, Date.valueOf(get(i).getUWDate()));
/*      */         }
/*  563 */         if ((get(i).getUWTime() == null) || (get(i).getUWTime().equals("null")))
/*  564 */           pstmt.setString(107, null);
/*      */         else {
/*  566 */           pstmt.setString(107, get(i).getUWTime());
/*      */         }
/*  568 */         if ((get(i).getPolApplyDate() == null) || (get(i).getPolApplyDate().equals("null")))
/*  569 */           pstmt.setDate(108, null);
/*      */         else {
/*  571 */           pstmt.setDate(108, Date.valueOf(get(i).getPolApplyDate()));
/*      */         }
/*  573 */         if ((get(i).getAppFlag() == null) || (get(i).getAppFlag().equals("null")))
/*  574 */           pstmt.setString(109, null);
/*      */         else {
/*  576 */           pstmt.setString(109, get(i).getAppFlag());
/*      */         }
/*  578 */         if ((get(i).getSaleChnlDetail() == null) || (get(i).getSaleChnlDetail().equals("null")))
/*  579 */           pstmt.setString(110, null);
/*      */         else {
/*  581 */           pstmt.setString(110, get(i).getSaleChnlDetail());
/*      */         }
/*  583 */         if ((get(i).getPolState() == null) || (get(i).getPolState().equals("null")))
/*  584 */           pstmt.setString(111, null);
/*      */         else {
/*  586 */           pstmt.setString(111, get(i).getPolState());
/*      */         }
/*  588 */         if ((get(i).getStandbyFlag1() == null) || (get(i).getStandbyFlag1().equals("null")))
/*  589 */           pstmt.setString(112, null);
/*      */         else {
/*  591 */           pstmt.setString(112, get(i).getStandbyFlag1());
/*      */         }
/*  593 */         if ((get(i).getStandbyFlag2() == null) || (get(i).getStandbyFlag2().equals("null")))
/*  594 */           pstmt.setString(113, null);
/*      */         else {
/*  596 */           pstmt.setString(113, get(i).getStandbyFlag2());
/*      */         }
/*  598 */         if ((get(i).getStandbyFlag3() == null) || (get(i).getStandbyFlag3().equals("null")))
/*  599 */           pstmt.setString(114, null);
/*      */         else {
/*  601 */           pstmt.setString(114, get(i).getStandbyFlag3());
/*      */         }
/*  603 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/*  604 */           pstmt.setString(115, null);
/*      */         else {
/*  606 */           pstmt.setString(115, get(i).getOperator());
/*      */         }
/*  608 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/*  609 */           pstmt.setDate(116, null);
/*      */         else {
/*  611 */           pstmt.setDate(116, Date.valueOf(get(i).getMakeDate()));
/*      */         }
/*  613 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/*  614 */           pstmt.setString(117, null);
/*      */         else {
/*  616 */           pstmt.setString(117, get(i).getMakeTime());
/*      */         }
/*  618 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/*  619 */           pstmt.setDate(118, null);
/*      */         else {
/*  621 */           pstmt.setDate(118, Date.valueOf(get(i).getModifyDate()));
/*      */         }
/*  623 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/*  624 */           pstmt.setString(119, null);
/*      */         else {
/*  626 */           pstmt.setString(119, get(i).getModifyTime());
/*      */         }
/*      */ 
/*  629 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/*  630 */           pstmt.setString(120, null);
/*      */         else {
/*  632 */           pstmt.setString(120, get(i).getPolNo());
/*      */         }
/*  634 */         pstmt.addBatch();
/*      */       }
/*  636 */       pstmt.executeBatch();
/*  637 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  640 */       ex.printStackTrace();
/*  641 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  642 */       CError tError = new CError();
/*  643 */       tError.moduleName = "LNPPolDBSet";
/*  644 */       tError.functionName = "update()";
/*  645 */       tError.errorMessage = ex.toString();
/*  646 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  649 */         pstmt.close(); } catch (Exception e) {
/*  650 */         e.printStackTrace();
/*      */       }
/*  652 */       if (!this.mflag) {
/*      */         try {
/*  654 */           this.con.close(); } catch (Exception e) {
/*  655 */           e.printStackTrace();
/*      */         }
/*      */       }
/*  658 */       return false;
/*      */     }
/*      */ 
/*  661 */     if (!this.mflag) {
/*      */       try {
/*  663 */         this.con.close(); } catch (Exception e) {
/*  664 */         e.printStackTrace();
/*      */       }
/*      */     }
/*  667 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  673 */     PreparedStatement pstmt = null;
/*      */ 
/*  675 */     if (!this.mflag) {
/*  676 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  681 */       int tCount = size();
/*  682 */       pstmt = this.con.prepareStatement("INSERT INTO LNPPol VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  683 */       for (int i = 1; i <= tCount; i++)
/*      */       {
/*  685 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/*  686 */           pstmt.setString(1, null);
/*      */         else {
/*  688 */           pstmt.setString(1, get(i).getGrpContNo());
/*      */         }
/*  690 */         if ((get(i).getGrpPolNo() == null) || (get(i).getGrpPolNo().equals("null")))
/*  691 */           pstmt.setString(2, null);
/*      */         else {
/*  693 */           pstmt.setString(2, get(i).getGrpPolNo());
/*      */         }
/*  695 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  696 */           pstmt.setString(3, null);
/*      */         else {
/*  698 */           pstmt.setString(3, get(i).getContNo());
/*      */         }
/*  700 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/*  701 */           pstmt.setString(4, null);
/*      */         else {
/*  703 */           pstmt.setString(4, get(i).getProposalContNo());
/*      */         }
/*  705 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/*  706 */           pstmt.setString(5, null);
/*      */         else {
/*  708 */           pstmt.setString(5, get(i).getPolNo());
/*      */         }
/*  710 */         if ((get(i).getProposalNo() == null) || (get(i).getProposalNo().equals("null")))
/*  711 */           pstmt.setString(6, null);
/*      */         else {
/*  713 */           pstmt.setString(6, get(i).getProposalNo());
/*      */         }
/*  715 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/*  716 */           pstmt.setString(7, null);
/*      */         else {
/*  718 */           pstmt.setString(7, get(i).getPrtNo());
/*      */         }
/*  720 */         if ((get(i).getContType() == null) || (get(i).getContType().equals("null")))
/*  721 */           pstmt.setString(8, null);
/*      */         else {
/*  723 */           pstmt.setString(8, get(i).getContType());
/*      */         }
/*  725 */         if ((get(i).getPolTypeFlag() == null) || (get(i).getPolTypeFlag().equals("null")))
/*  726 */           pstmt.setString(9, null);
/*      */         else {
/*  728 */           pstmt.setString(9, get(i).getPolTypeFlag());
/*      */         }
/*  730 */         if ((get(i).getMainPolNo() == null) || (get(i).getMainPolNo().equals("null")))
/*  731 */           pstmt.setString(10, null);
/*      */         else {
/*  733 */           pstmt.setString(10, get(i).getMainPolNo());
/*      */         }
/*  735 */         if ((get(i).getMasterPolNo() == null) || (get(i).getMasterPolNo().equals("null")))
/*  736 */           pstmt.setString(11, null);
/*      */         else {
/*  738 */           pstmt.setString(11, get(i).getMasterPolNo());
/*      */         }
/*  740 */         if ((get(i).getKindCode() == null) || (get(i).getKindCode().equals("null")))
/*  741 */           pstmt.setString(12, null);
/*      */         else {
/*  743 */           pstmt.setString(12, get(i).getKindCode());
/*      */         }
/*  745 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  746 */           pstmt.setString(13, null);
/*      */         else {
/*  748 */           pstmt.setString(13, get(i).getRiskCode());
/*      */         }
/*  750 */         if ((get(i).getRiskVersion() == null) || (get(i).getRiskVersion().equals("null")))
/*  751 */           pstmt.setString(14, null);
/*      */         else {
/*  753 */           pstmt.setString(14, get(i).getRiskVersion());
/*      */         }
/*  755 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/*  756 */           pstmt.setString(15, null);
/*      */         else {
/*  758 */           pstmt.setString(15, get(i).getManageCom());
/*      */         }
/*  760 */         if ((get(i).getAgentCom() == null) || (get(i).getAgentCom().equals("null")))
/*  761 */           pstmt.setString(16, null);
/*      */         else {
/*  763 */           pstmt.setString(16, get(i).getAgentCom());
/*      */         }
/*  765 */         if ((get(i).getAgentType() == null) || (get(i).getAgentType().equals("null")))
/*  766 */           pstmt.setString(17, null);
/*      */         else {
/*  768 */           pstmt.setString(17, get(i).getAgentType());
/*      */         }
/*  770 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*  771 */           pstmt.setString(18, null);
/*      */         else {
/*  773 */           pstmt.setString(18, get(i).getAgentCode());
/*      */         }
/*  775 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/*  776 */           pstmt.setString(19, null);
/*      */         else {
/*  778 */           pstmt.setString(19, get(i).getAgentGroup());
/*      */         }
/*  780 */         if ((get(i).getAgentGroup1() == null) || (get(i).getAgentGroup1().equals("null")))
/*  781 */           pstmt.setString(20, null);
/*      */         else {
/*  783 */           pstmt.setString(20, get(i).getAgentGroup1());
/*      */         }
/*  785 */         if ((get(i).getAgentCode1() == null) || (get(i).getAgentCode1().equals("null")))
/*  786 */           pstmt.setString(21, null);
/*      */         else {
/*  788 */           pstmt.setString(21, get(i).getAgentCode1());
/*      */         }
/*  790 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/*  791 */           pstmt.setString(22, null);
/*      */         else {
/*  793 */           pstmt.setString(22, get(i).getSaleChnl());
/*      */         }
/*  795 */         if ((get(i).getHandler() == null) || (get(i).getHandler().equals("null")))
/*  796 */           pstmt.setString(23, null);
/*      */         else {
/*  798 */           pstmt.setString(23, get(i).getHandler());
/*      */         }
/*  800 */         if ((get(i).getInsuredNo() == null) || (get(i).getInsuredNo().equals("null")))
/*  801 */           pstmt.setString(24, null);
/*      */         else {
/*  803 */           pstmt.setString(24, get(i).getInsuredNo());
/*      */         }
/*  805 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/*  806 */           pstmt.setString(25, null);
/*      */         else {
/*  808 */           pstmt.setString(25, get(i).getInsuredId());
/*      */         }
/*  810 */         if ((get(i).getInsuredName() == null) || (get(i).getInsuredName().equals("null")))
/*  811 */           pstmt.setString(26, null);
/*      */         else {
/*  813 */           pstmt.setString(26, get(i).getInsuredName());
/*      */         }
/*  815 */         if ((get(i).getInsuredSex() == null) || (get(i).getInsuredSex().equals("null")))
/*  816 */           pstmt.setString(27, null);
/*      */         else {
/*  818 */           pstmt.setString(27, get(i).getInsuredSex());
/*      */         }
/*  820 */         if ((get(i).getInsuredBirthday() == null) || (get(i).getInsuredBirthday().equals("null")))
/*  821 */           pstmt.setDate(28, null);
/*      */         else {
/*  823 */           pstmt.setDate(28, Date.valueOf(get(i).getInsuredBirthday()));
/*      */         }
/*  825 */         pstmt.setInt(29, get(i).getInsuredAppAge());
/*  826 */         pstmt.setInt(30, get(i).getInsuredPeoples());
/*  827 */         if ((get(i).getOccupationType() == null) || (get(i).getOccupationType().equals("null")))
/*  828 */           pstmt.setString(31, null);
/*      */         else {
/*  830 */           pstmt.setString(31, get(i).getOccupationType());
/*      */         }
/*  832 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/*  833 */           pstmt.setString(32, null);
/*      */         else {
/*  835 */           pstmt.setString(32, get(i).getAppntNo());
/*      */         }
/*  837 */         if ((get(i).getAppntName() == null) || (get(i).getAppntName().equals("null")))
/*  838 */           pstmt.setString(33, null);
/*      */         else {
/*  840 */           pstmt.setString(33, get(i).getAppntName());
/*      */         }
/*  842 */         if ((get(i).getCValiDate() == null) || (get(i).getCValiDate().equals("null")))
/*  843 */           pstmt.setDate(34, null);
/*      */         else {
/*  845 */           pstmt.setDate(34, Date.valueOf(get(i).getCValiDate()));
/*      */         }
/*  847 */         if ((get(i).getSignCom() == null) || (get(i).getSignCom().equals("null")))
/*  848 */           pstmt.setString(35, null);
/*      */         else {
/*  850 */           pstmt.setString(35, get(i).getSignCom());
/*      */         }
/*  852 */         if ((get(i).getSignDate() == null) || (get(i).getSignDate().equals("null")))
/*  853 */           pstmt.setDate(36, null);
/*      */         else {
/*  855 */           pstmt.setDate(36, Date.valueOf(get(i).getSignDate()));
/*      */         }
/*  857 */         if ((get(i).getSignTime() == null) || (get(i).getSignTime().equals("null")))
/*  858 */           pstmt.setString(37, null);
/*      */         else {
/*  860 */           pstmt.setString(37, get(i).getSignTime());
/*      */         }
/*  862 */         if ((get(i).getFirstPayDate() == null) || (get(i).getFirstPayDate().equals("null")))
/*  863 */           pstmt.setDate(38, null);
/*      */         else {
/*  865 */           pstmt.setDate(38, Date.valueOf(get(i).getFirstPayDate()));
/*      */         }
/*  867 */         if ((get(i).getPayEndDate() == null) || (get(i).getPayEndDate().equals("null")))
/*  868 */           pstmt.setDate(39, null);
/*      */         else {
/*  870 */           pstmt.setDate(39, Date.valueOf(get(i).getPayEndDate()));
/*      */         }
/*  872 */         if ((get(i).getPaytoDate() == null) || (get(i).getPaytoDate().equals("null")))
/*  873 */           pstmt.setDate(40, null);
/*      */         else {
/*  875 */           pstmt.setDate(40, Date.valueOf(get(i).getPaytoDate()));
/*      */         }
/*  877 */         if ((get(i).getGetStartDate() == null) || (get(i).getGetStartDate().equals("null")))
/*  878 */           pstmt.setDate(41, null);
/*      */         else {
/*  880 */           pstmt.setDate(41, Date.valueOf(get(i).getGetStartDate()));
/*      */         }
/*  882 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/*  883 */           pstmt.setDate(42, null);
/*      */         else {
/*  885 */           pstmt.setDate(42, Date.valueOf(get(i).getEndDate()));
/*      */         }
/*  887 */         if ((get(i).getAcciEndDate() == null) || (get(i).getAcciEndDate().equals("null")))
/*  888 */           pstmt.setDate(43, null);
/*      */         else {
/*  890 */           pstmt.setDate(43, Date.valueOf(get(i).getAcciEndDate()));
/*      */         }
/*  892 */         if ((get(i).getGetYearFlag() == null) || (get(i).getGetYearFlag().equals("null")))
/*  893 */           pstmt.setString(44, null);
/*      */         else {
/*  895 */           pstmt.setString(44, get(i).getGetYearFlag());
/*      */         }
/*  897 */         pstmt.setInt(45, get(i).getGetYear());
/*  898 */         if ((get(i).getPayEndYearFlag() == null) || (get(i).getPayEndYearFlag().equals("null")))
/*  899 */           pstmt.setString(46, null);
/*      */         else {
/*  901 */           pstmt.setString(46, get(i).getPayEndYearFlag());
/*      */         }
/*  903 */         pstmt.setInt(47, get(i).getPayEndYear());
/*  904 */         if ((get(i).getInsuYearFlag() == null) || (get(i).getInsuYearFlag().equals("null")))
/*  905 */           pstmt.setString(48, null);
/*      */         else {
/*  907 */           pstmt.setString(48, get(i).getInsuYearFlag());
/*      */         }
/*  909 */         pstmt.setInt(49, get(i).getInsuYear());
/*  910 */         if ((get(i).getAcciYearFlag() == null) || (get(i).getAcciYearFlag().equals("null")))
/*  911 */           pstmt.setString(50, null);
/*      */         else {
/*  913 */           pstmt.setString(50, get(i).getAcciYearFlag());
/*      */         }
/*  915 */         pstmt.setInt(51, get(i).getAcciYear());
/*  916 */         if ((get(i).getGetStartType() == null) || (get(i).getGetStartType().equals("null")))
/*  917 */           pstmt.setString(52, null);
/*      */         else {
/*  919 */           pstmt.setString(52, get(i).getGetStartType());
/*      */         }
/*  921 */         if ((get(i).getSpecifyValiDate() == null) || (get(i).getSpecifyValiDate().equals("null")))
/*  922 */           pstmt.setString(53, null);
/*      */         else {
/*  924 */           pstmt.setString(53, get(i).getSpecifyValiDate());
/*      */         }
/*  926 */         if ((get(i).getPayMode() == null) || (get(i).getPayMode().equals("null")))
/*  927 */           pstmt.setString(54, null);
/*      */         else {
/*  929 */           pstmt.setString(54, get(i).getPayMode());
/*      */         }
/*  931 */         if ((get(i).getPayLocation() == null) || (get(i).getPayLocation().equals("null")))
/*  932 */           pstmt.setString(55, null);
/*      */         else {
/*  934 */           pstmt.setString(55, get(i).getPayLocation());
/*      */         }
/*  936 */         pstmt.setInt(56, get(i).getPayIntv());
/*  937 */         pstmt.setInt(57, get(i).getPayYears());
/*  938 */         pstmt.setInt(58, get(i).getYears());
/*  939 */         pstmt.setDouble(59, get(i).getManageFeeRate());
/*  940 */         pstmt.setDouble(60, get(i).getFloatRate());
/*  941 */         pstmt.setDouble(61, get(i).getPremRate());
/*  942 */         if ((get(i).getPremToAmnt() == null) || (get(i).getPremToAmnt().equals("null")))
/*  943 */           pstmt.setString(62, null);
/*      */         else {
/*  945 */           pstmt.setString(62, get(i).getPremToAmnt());
/*      */         }
/*  947 */         pstmt.setDouble(63, get(i).getMult());
/*  948 */         pstmt.setDouble(64, get(i).getStandPrem());
/*  949 */         pstmt.setDouble(65, get(i).getPrem());
/*  950 */         pstmt.setDouble(66, get(i).getSumPrem());
/*  951 */         pstmt.setDouble(67, get(i).getAmnt());
/*  952 */         pstmt.setDouble(68, get(i).getRiskAmnt());
/*  953 */         pstmt.setDouble(69, get(i).getLeavingMoney());
/*  954 */         pstmt.setInt(70, get(i).getEndorseTimes());
/*  955 */         pstmt.setInt(71, get(i).getClaimTimes());
/*  956 */         pstmt.setInt(72, get(i).getLiveTimes());
/*  957 */         pstmt.setInt(73, get(i).getRenewCount());
/*  958 */         if ((get(i).getLastGetDate() == null) || (get(i).getLastGetDate().equals("null")))
/*  959 */           pstmt.setDate(74, null);
/*      */         else {
/*  961 */           pstmt.setDate(74, Date.valueOf(get(i).getLastGetDate()));
/*      */         }
/*  963 */         if ((get(i).getLastLoanDate() == null) || (get(i).getLastLoanDate().equals("null")))
/*  964 */           pstmt.setDate(75, null);
/*      */         else {
/*  966 */           pstmt.setDate(75, Date.valueOf(get(i).getLastLoanDate()));
/*      */         }
/*  968 */         if ((get(i).getLastRegetDate() == null) || (get(i).getLastRegetDate().equals("null")))
/*  969 */           pstmt.setDate(76, null);
/*      */         else {
/*  971 */           pstmt.setDate(76, Date.valueOf(get(i).getLastRegetDate()));
/*      */         }
/*  973 */         if ((get(i).getLastEdorDate() == null) || (get(i).getLastEdorDate().equals("null")))
/*  974 */           pstmt.setDate(77, null);
/*      */         else {
/*  976 */           pstmt.setDate(77, Date.valueOf(get(i).getLastEdorDate()));
/*      */         }
/*  978 */         if ((get(i).getLastRevDate() == null) || (get(i).getLastRevDate().equals("null")))
/*  979 */           pstmt.setDate(78, null);
/*      */         else {
/*  981 */           pstmt.setDate(78, Date.valueOf(get(i).getLastRevDate()));
/*      */         }
/*  983 */         if ((get(i).getRnewFlag() == null) || (get(i).getRnewFlag().equals("null")))
/*  984 */           pstmt.setString(79, null);
/*      */         else {
/*  986 */           pstmt.setString(79, get(i).getRnewFlag());
/*      */         }
/*  988 */         if ((get(i).getStopFlag() == null) || (get(i).getStopFlag().equals("null")))
/*  989 */           pstmt.setString(80, null);
/*      */         else {
/*  991 */           pstmt.setString(80, get(i).getStopFlag());
/*      */         }
/*  993 */         if ((get(i).getExpiryFlag() == null) || (get(i).getExpiryFlag().equals("null")))
/*  994 */           pstmt.setString(81, null);
/*      */         else {
/*  996 */           pstmt.setString(81, get(i).getExpiryFlag());
/*      */         }
/*  998 */         if ((get(i).getAutoPayFlag() == null) || (get(i).getAutoPayFlag().equals("null")))
/*  999 */           pstmt.setString(82, null);
/*      */         else {
/* 1001 */           pstmt.setString(82, get(i).getAutoPayFlag());
/*      */         }
/* 1003 */         if ((get(i).getInterestDifFlag() == null) || (get(i).getInterestDifFlag().equals("null")))
/* 1004 */           pstmt.setString(83, null);
/*      */         else {
/* 1006 */           pstmt.setString(83, get(i).getInterestDifFlag());
/*      */         }
/* 1008 */         if ((get(i).getSubFlag() == null) || (get(i).getSubFlag().equals("null")))
/* 1009 */           pstmt.setString(84, null);
/*      */         else {
/* 1011 */           pstmt.setString(84, get(i).getSubFlag());
/*      */         }
/* 1013 */         if ((get(i).getBnfFlag() == null) || (get(i).getBnfFlag().equals("null")))
/* 1014 */           pstmt.setString(85, null);
/*      */         else {
/* 1016 */           pstmt.setString(85, get(i).getBnfFlag());
/*      */         }
/* 1018 */         if ((get(i).getHealthCheckFlag() == null) || (get(i).getHealthCheckFlag().equals("null")))
/* 1019 */           pstmt.setString(86, null);
/*      */         else {
/* 1021 */           pstmt.setString(86, get(i).getHealthCheckFlag());
/*      */         }
/* 1023 */         if ((get(i).getImpartFlag() == null) || (get(i).getImpartFlag().equals("null")))
/* 1024 */           pstmt.setString(87, null);
/*      */         else {
/* 1026 */           pstmt.setString(87, get(i).getImpartFlag());
/*      */         }
/* 1028 */         if ((get(i).getReinsureFlag() == null) || (get(i).getReinsureFlag().equals("null")))
/* 1029 */           pstmt.setString(88, null);
/*      */         else {
/* 1031 */           pstmt.setString(88, get(i).getReinsureFlag());
/*      */         }
/* 1033 */         if ((get(i).getAgentPayFlag() == null) || (get(i).getAgentPayFlag().equals("null")))
/* 1034 */           pstmt.setString(89, null);
/*      */         else {
/* 1036 */           pstmt.setString(89, get(i).getAgentPayFlag());
/*      */         }
/* 1038 */         if ((get(i).getAgentGetFlag() == null) || (get(i).getAgentGetFlag().equals("null")))
/* 1039 */           pstmt.setString(90, null);
/*      */         else {
/* 1041 */           pstmt.setString(90, get(i).getAgentGetFlag());
/*      */         }
/* 1043 */         if ((get(i).getLiveGetMode() == null) || (get(i).getLiveGetMode().equals("null")))
/* 1044 */           pstmt.setString(91, null);
/*      */         else {
/* 1046 */           pstmt.setString(91, get(i).getLiveGetMode());
/*      */         }
/* 1048 */         if ((get(i).getDeadGetMode() == null) || (get(i).getDeadGetMode().equals("null")))
/* 1049 */           pstmt.setString(92, null);
/*      */         else {
/* 1051 */           pstmt.setString(92, get(i).getDeadGetMode());
/*      */         }
/* 1053 */         if ((get(i).getBonusGetMode() == null) || (get(i).getBonusGetMode().equals("null")))
/* 1054 */           pstmt.setString(93, null);
/*      */         else {
/* 1056 */           pstmt.setString(93, get(i).getBonusGetMode());
/*      */         }
/* 1058 */         if ((get(i).getDeadAmntType() == null) || (get(i).getDeadAmntType().equals("null")))
/* 1059 */           pstmt.setString(94, null);
/*      */         else {
/* 1061 */           pstmt.setString(94, get(i).getDeadAmntType());
/*      */         }
/* 1063 */         pstmt.setDouble(95, get(i).getTopUpPrem());
/* 1064 */         if ((get(i).getBonusMan() == null) || (get(i).getBonusMan().equals("null")))
/* 1065 */           pstmt.setString(96, null);
/*      */         else {
/* 1067 */           pstmt.setString(96, get(i).getBonusMan());
/*      */         }
/* 1069 */         if ((get(i).getDeadFlag() == null) || (get(i).getDeadFlag().equals("null")))
/* 1070 */           pstmt.setString(97, null);
/*      */         else {
/* 1072 */           pstmt.setString(97, get(i).getDeadFlag());
/*      */         }
/* 1074 */         if ((get(i).getSmokeFlag() == null) || (get(i).getSmokeFlag().equals("null")))
/* 1075 */           pstmt.setString(98, null);
/*      */         else {
/* 1077 */           pstmt.setString(98, get(i).getSmokeFlag());
/*      */         }
/* 1079 */         if ((get(i).getRemark() == null) || (get(i).getRemark().equals("null")))
/* 1080 */           pstmt.setString(99, null);
/*      */         else {
/* 1082 */           pstmt.setString(99, get(i).getRemark());
/*      */         }
/* 1084 */         if ((get(i).getApproveFlag() == null) || (get(i).getApproveFlag().equals("null")))
/* 1085 */           pstmt.setString(100, null);
/*      */         else {
/* 1087 */           pstmt.setString(100, get(i).getApproveFlag());
/*      */         }
/* 1089 */         if ((get(i).getApproveCode() == null) || (get(i).getApproveCode().equals("null")))
/* 1090 */           pstmt.setString(101, null);
/*      */         else {
/* 1092 */           pstmt.setString(101, get(i).getApproveCode());
/*      */         }
/* 1094 */         if ((get(i).getApproveDate() == null) || (get(i).getApproveDate().equals("null")))
/* 1095 */           pstmt.setDate(102, null);
/*      */         else {
/* 1097 */           pstmt.setDate(102, Date.valueOf(get(i).getApproveDate()));
/*      */         }
/* 1099 */         if ((get(i).getApproveTime() == null) || (get(i).getApproveTime().equals("null")))
/* 1100 */           pstmt.setString(103, null);
/*      */         else {
/* 1102 */           pstmt.setString(103, get(i).getApproveTime());
/*      */         }
/* 1104 */         if ((get(i).getUWFlag() == null) || (get(i).getUWFlag().equals("null")))
/* 1105 */           pstmt.setString(104, null);
/*      */         else {
/* 1107 */           pstmt.setString(104, get(i).getUWFlag());
/*      */         }
/* 1109 */         if ((get(i).getUWCode() == null) || (get(i).getUWCode().equals("null")))
/* 1110 */           pstmt.setString(105, null);
/*      */         else {
/* 1112 */           pstmt.setString(105, get(i).getUWCode());
/*      */         }
/* 1114 */         if ((get(i).getUWDate() == null) || (get(i).getUWDate().equals("null")))
/* 1115 */           pstmt.setDate(106, null);
/*      */         else {
/* 1117 */           pstmt.setDate(106, Date.valueOf(get(i).getUWDate()));
/*      */         }
/* 1119 */         if ((get(i).getUWTime() == null) || (get(i).getUWTime().equals("null")))
/* 1120 */           pstmt.setString(107, null);
/*      */         else {
/* 1122 */           pstmt.setString(107, get(i).getUWTime());
/*      */         }
/* 1124 */         if ((get(i).getPolApplyDate() == null) || (get(i).getPolApplyDate().equals("null")))
/* 1125 */           pstmt.setDate(108, null);
/*      */         else {
/* 1127 */           pstmt.setDate(108, Date.valueOf(get(i).getPolApplyDate()));
/*      */         }
/* 1129 */         if ((get(i).getAppFlag() == null) || (get(i).getAppFlag().equals("null")))
/* 1130 */           pstmt.setString(109, null);
/*      */         else {
/* 1132 */           pstmt.setString(109, get(i).getAppFlag());
/*      */         }
/* 1134 */         if ((get(i).getSaleChnlDetail() == null) || (get(i).getSaleChnlDetail().equals("null")))
/* 1135 */           pstmt.setString(110, null);
/*      */         else {
/* 1137 */           pstmt.setString(110, get(i).getSaleChnlDetail());
/*      */         }
/* 1139 */         if ((get(i).getPolState() == null) || (get(i).getPolState().equals("null")))
/* 1140 */           pstmt.setString(111, null);
/*      */         else {
/* 1142 */           pstmt.setString(111, get(i).getPolState());
/*      */         }
/* 1144 */         if ((get(i).getStandbyFlag1() == null) || (get(i).getStandbyFlag1().equals("null")))
/* 1145 */           pstmt.setString(112, null);
/*      */         else {
/* 1147 */           pstmt.setString(112, get(i).getStandbyFlag1());
/*      */         }
/* 1149 */         if ((get(i).getStandbyFlag2() == null) || (get(i).getStandbyFlag2().equals("null")))
/* 1150 */           pstmt.setString(113, null);
/*      */         else {
/* 1152 */           pstmt.setString(113, get(i).getStandbyFlag2());
/*      */         }
/* 1154 */         if ((get(i).getStandbyFlag3() == null) || (get(i).getStandbyFlag3().equals("null")))
/* 1155 */           pstmt.setString(114, null);
/*      */         else {
/* 1157 */           pstmt.setString(114, get(i).getStandbyFlag3());
/*      */         }
/* 1159 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 1160 */           pstmt.setString(115, null);
/*      */         else {
/* 1162 */           pstmt.setString(115, get(i).getOperator());
/*      */         }
/* 1164 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 1165 */           pstmt.setDate(116, null);
/*      */         else {
/* 1167 */           pstmt.setDate(116, Date.valueOf(get(i).getMakeDate()));
/*      */         }
/* 1169 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 1170 */           pstmt.setString(117, null);
/*      */         else {
/* 1172 */           pstmt.setString(117, get(i).getMakeTime());
/*      */         }
/* 1174 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 1175 */           pstmt.setDate(118, null);
/*      */         else {
/* 1177 */           pstmt.setDate(118, Date.valueOf(get(i).getModifyDate()));
/*      */         }
/* 1179 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 1180 */           pstmt.setString(119, null);
/*      */         else {
/* 1182 */           pstmt.setString(119, get(i).getModifyTime());
/*      */         }
/* 1184 */         pstmt.addBatch();
/*      */       }
/* 1186 */       pstmt.executeBatch();
/* 1187 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/* 1190 */       ex.printStackTrace();
/* 1191 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 1192 */       CError tError = new CError();
/* 1193 */       tError.moduleName = "LNPPolDBSet";
/* 1194 */       tError.functionName = "insert()";
/* 1195 */       tError.errorMessage = ex.toString();
/* 1196 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1199 */         pstmt.close(); } catch (Exception e) {
/* 1200 */         e.printStackTrace();
/*      */       }
/* 1202 */       if (!this.mflag) {
/*      */         try {
/* 1204 */           this.con.close(); } catch (Exception e) {
/* 1205 */           e.printStackTrace();
/*      */         }
/*      */       }
/* 1208 */       return false;
/*      */     }
/*      */ 
/* 1211 */     if (!this.mflag) {
/*      */       try {
/* 1213 */         this.con.close(); } catch (Exception e) {
/* 1214 */         e.printStackTrace();
/*      */       }
/*      */     }
/* 1217 */     return true;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPPolDBSet
 * JD-Core Version:    0.6.0
 */