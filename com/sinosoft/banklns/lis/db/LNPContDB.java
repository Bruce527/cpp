/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPContSet;
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
/*      */ public class LNPContDB extends LNPContSchema
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
/*      */   public LNPContDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPCont");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPContDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPCont");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPContSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPContDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPContSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPContDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCont WHERE  ContNo = ?");
/*   97 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getContNo());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPContDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPCont SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , MainPolNo = ? , ContType = ? , FamilyType = ? , FamilyID = ? , PolType = ? , SugNo = ? , CardFlag = ? , ManageCom = ? , ExecuteCom = ? , AgentCom = ? , AgentCode = ? , AgentGroup = ? , AgentCode1 = ? , AgentGroup1 = ? , AgentType = ? , SaleChnl = ? , Handler = ? , Password = ? , AppntNo = ? , AppntId = ? , AppntName = ? , AppntSex = ? , AppntBirthday = ? , AppntIDType = ? , AppntIDNo = ? , InsuredNo = ? , InsuredId = ? , InsuredName = ? , InsuredSex = ? , InsuredBirthday = ? , InsuredIDType = ? , InsuredIDNo = ? , PayIntv = ? , PayMode = ? , PayLocation = ? , DisputedFlag = ? , OutPayFlag = ? , GetPolMode = ? , SignCom = ? , SignDate = ? , SignTime = ? , ConsignNo = ? , BankCode = ? , BankAccNo = ? , AccName = ? , PrintCount = ? , LostTimes = ? , Lang = ? , Currency = ? , Remark = ? , Peoples = ? , Mult = ? , Prem = ? , Amnt = ? , SumPrem = ? , Dif = ? , PaytoDate = ? , FirstPayDate = ? , CValiDate = ? , PSignDate = ? , PValiDate = ? , InputOperator = ? , InputDate = ? , InputTime = ? , ApproveFlag = ? , ApproveCode = ? , ApproveDate = ? , ApproveTime = ? , UWFlag = ? , UWOperator = ? , UWDate = ? , UWTime = ? , AppFlag = ? , PolApplyDate = ? , GetPolDate = ? , GetPolTime = ? , CustomGetPolDate = ? , State = ? , SaleChnlDetail = ? , ProposalType = ? , Editstate = ? , CInValiDate = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ?");
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
/*  161 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getPrtNo());
/*      */       }
/*  166 */       if ((getMainPolNo() == null) || (getMainPolNo().equals("null")))
/*  167 */         pstmt.setNull(5, 12);
/*      */       else {
/*  169 */         pstmt.setString(5, getMainPolNo());
/*      */       }
/*  171 */       if ((getContType() == null) || (getContType().equals("null")))
/*  172 */         pstmt.setNull(6, 12);
/*      */       else {
/*  174 */         pstmt.setString(6, getContType());
/*      */       }
/*  176 */       if ((getFamilyType() == null) || (getFamilyType().equals("null")))
/*  177 */         pstmt.setNull(7, 12);
/*      */       else {
/*  179 */         pstmt.setString(7, getFamilyType());
/*      */       }
/*  181 */       if ((getFamilyID() == null) || (getFamilyID().equals("null")))
/*  182 */         pstmt.setNull(8, 12);
/*      */       else {
/*  184 */         pstmt.setString(8, getFamilyID());
/*      */       }
/*  186 */       if ((getPolType() == null) || (getPolType().equals("null")))
/*  187 */         pstmt.setNull(9, 12);
/*      */       else {
/*  189 */         pstmt.setString(9, getPolType());
/*      */       }
/*  191 */       if ((getSugNo() == null) || (getSugNo().equals("null")))
/*  192 */         pstmt.setNull(10, 12);
/*      */       else {
/*  194 */         pstmt.setString(10, getSugNo());
/*      */       }
/*  196 */       if ((getCardFlag() == null) || (getCardFlag().equals("null")))
/*  197 */         pstmt.setNull(11, 12);
/*      */       else {
/*  199 */         pstmt.setString(11, getCardFlag());
/*      */       }
/*  201 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  202 */         pstmt.setNull(12, 12);
/*      */       else {
/*  204 */         pstmt.setString(12, getManageCom());
/*      */       }
/*  206 */       if ((getExecuteCom() == null) || (getExecuteCom().equals("null")))
/*  207 */         pstmt.setNull(13, 12);
/*      */       else {
/*  209 */         pstmt.setString(13, getExecuteCom());
/*      */       }
/*  211 */       if ((getAgentCom() == null) || (getAgentCom().equals("null")))
/*  212 */         pstmt.setNull(14, 12);
/*      */       else {
/*  214 */         pstmt.setString(14, getAgentCom());
/*      */       }
/*  216 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  217 */         pstmt.setNull(15, 12);
/*      */       else {
/*  219 */         pstmt.setString(15, getAgentCode());
/*      */       }
/*  221 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  222 */         pstmt.setNull(16, 12);
/*      */       else {
/*  224 */         pstmt.setString(16, getAgentGroup());
/*      */       }
/*  226 */       if ((getAgentCode1() == null) || (getAgentCode1().equals("null")))
/*  227 */         pstmt.setNull(17, 12);
/*      */       else {
/*  229 */         pstmt.setString(17, getAgentCode1());
/*      */       }
/*  231 */       if ((getAgentGroup1() == null) || (getAgentGroup1().equals("null")))
/*  232 */         pstmt.setNull(18, 12);
/*      */       else {
/*  234 */         pstmt.setString(18, getAgentGroup1());
/*      */       }
/*  236 */       if ((getAgentType() == null) || (getAgentType().equals("null")))
/*  237 */         pstmt.setNull(19, 12);
/*      */       else {
/*  239 */         pstmt.setString(19, getAgentType());
/*      */       }
/*  241 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  242 */         pstmt.setNull(20, 12);
/*      */       else {
/*  244 */         pstmt.setString(20, getSaleChnl());
/*      */       }
/*  246 */       if ((getHandler() == null) || (getHandler().equals("null")))
/*  247 */         pstmt.setNull(21, 12);
/*      */       else {
/*  249 */         pstmt.setString(21, getHandler());
/*      */       }
/*  251 */       if ((getPassword() == null) || (getPassword().equals("null")))
/*  252 */         pstmt.setNull(22, 12);
/*      */       else {
/*  254 */         pstmt.setString(22, getPassword());
/*      */       }
/*  256 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  257 */         pstmt.setNull(23, 12);
/*      */       else {
/*  259 */         pstmt.setString(23, getAppntNo());
/*      */       }
/*  261 */       if ((getAppntId() == null) || (getAppntId().equals("null")))
/*  262 */         pstmt.setNull(24, 12);
/*      */       else {
/*  264 */         pstmt.setString(24, getAppntId());
/*      */       }
/*  266 */       if ((getAppntName() == null) || (getAppntName().equals("null")))
/*  267 */         pstmt.setNull(25, 12);
/*      */       else {
/*  269 */         pstmt.setString(25, getAppntName());
/*      */       }
/*  271 */       if ((getAppntSex() == null) || (getAppntSex().equals("null")))
/*  272 */         pstmt.setNull(26, 12);
/*      */       else {
/*  274 */         pstmt.setString(26, getAppntSex());
/*      */       }
/*  276 */       if ((getAppntBirthday() == null) || (getAppntBirthday().equals("null")))
/*  277 */         pstmt.setNull(27, 91);
/*      */       else {
/*  279 */         pstmt.setDate(27, Date.valueOf(getAppntBirthday()));
/*      */       }
/*  281 */       if ((getAppntIDType() == null) || (getAppntIDType().equals("null")))
/*  282 */         pstmt.setNull(28, 12);
/*      */       else {
/*  284 */         pstmt.setString(28, getAppntIDType());
/*      */       }
/*  286 */       if ((getAppntIDNo() == null) || (getAppntIDNo().equals("null")))
/*  287 */         pstmt.setNull(29, 12);
/*      */       else {
/*  289 */         pstmt.setString(29, getAppntIDNo());
/*      */       }
/*  291 */       if ((getInsuredNo() == null) || (getInsuredNo().equals("null")))
/*  292 */         pstmt.setNull(30, 12);
/*      */       else {
/*  294 */         pstmt.setString(30, getInsuredNo());
/*      */       }
/*  296 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  297 */         pstmt.setNull(31, 12);
/*      */       else {
/*  299 */         pstmt.setString(31, getInsuredId());
/*      */       }
/*  301 */       if ((getInsuredName() == null) || (getInsuredName().equals("null")))
/*  302 */         pstmt.setNull(32, 12);
/*      */       else {
/*  304 */         pstmt.setString(32, getInsuredName());
/*      */       }
/*  306 */       if ((getInsuredSex() == null) || (getInsuredSex().equals("null")))
/*  307 */         pstmt.setNull(33, 12);
/*      */       else {
/*  309 */         pstmt.setString(33, getInsuredSex());
/*      */       }
/*  311 */       if ((getInsuredBirthday() == null) || (getInsuredBirthday().equals("null")))
/*  312 */         pstmt.setNull(34, 91);
/*      */       else {
/*  314 */         pstmt.setDate(34, Date.valueOf(getInsuredBirthday()));
/*      */       }
/*  316 */       if ((getInsuredIDType() == null) || (getInsuredIDType().equals("null")))
/*  317 */         pstmt.setNull(35, 12);
/*      */       else {
/*  319 */         pstmt.setString(35, getInsuredIDType());
/*      */       }
/*  321 */       if ((getInsuredIDNo() == null) || (getInsuredIDNo().equals("null")))
/*  322 */         pstmt.setNull(36, 12);
/*      */       else {
/*  324 */         pstmt.setString(36, getInsuredIDNo());
/*      */       }
/*  326 */       pstmt.setInt(37, getPayIntv());
/*  327 */       if ((getPayMode() == null) || (getPayMode().equals("null")))
/*  328 */         pstmt.setNull(38, 12);
/*      */       else {
/*  330 */         pstmt.setString(38, getPayMode());
/*      */       }
/*  332 */       if ((getPayLocation() == null) || (getPayLocation().equals("null")))
/*  333 */         pstmt.setNull(39, 12);
/*      */       else {
/*  335 */         pstmt.setString(39, getPayLocation());
/*      */       }
/*  337 */       if ((getDisputedFlag() == null) || (getDisputedFlag().equals("null")))
/*  338 */         pstmt.setNull(40, 12);
/*      */       else {
/*  340 */         pstmt.setString(40, getDisputedFlag());
/*      */       }
/*  342 */       if ((getOutPayFlag() == null) || (getOutPayFlag().equals("null")))
/*  343 */         pstmt.setNull(41, 12);
/*      */       else {
/*  345 */         pstmt.setString(41, getOutPayFlag());
/*      */       }
/*  347 */       if ((getGetPolMode() == null) || (getGetPolMode().equals("null")))
/*  348 */         pstmt.setNull(42, 12);
/*      */       else {
/*  350 */         pstmt.setString(42, getGetPolMode());
/*      */       }
/*  352 */       if ((getSignCom() == null) || (getSignCom().equals("null")))
/*  353 */         pstmt.setNull(43, 12);
/*      */       else {
/*  355 */         pstmt.setString(43, getSignCom());
/*      */       }
/*  357 */       if ((getSignDate() == null) || (getSignDate().equals("null")))
/*  358 */         pstmt.setNull(44, 91);
/*      */       else {
/*  360 */         pstmt.setDate(44, Date.valueOf(getSignDate()));
/*      */       }
/*  362 */       if ((getSignTime() == null) || (getSignTime().equals("null")))
/*  363 */         pstmt.setNull(45, 12);
/*      */       else {
/*  365 */         pstmt.setString(45, getSignTime());
/*      */       }
/*  367 */       if ((getConsignNo() == null) || (getConsignNo().equals("null")))
/*  368 */         pstmt.setNull(46, 12);
/*      */       else {
/*  370 */         pstmt.setString(46, getConsignNo());
/*      */       }
/*  372 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  373 */         pstmt.setNull(47, 12);
/*      */       else {
/*  375 */         pstmt.setString(47, getBankCode());
/*      */       }
/*  377 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  378 */         pstmt.setNull(48, 12);
/*      */       else {
/*  380 */         pstmt.setString(48, getBankAccNo());
/*      */       }
/*  382 */       if ((getAccName() == null) || (getAccName().equals("null")))
/*  383 */         pstmt.setNull(49, 12);
/*      */       else {
/*  385 */         pstmt.setString(49, getAccName());
/*      */       }
/*  387 */       pstmt.setInt(50, getPrintCount());
/*  388 */       pstmt.setInt(51, getLostTimes());
/*  389 */       if ((getLang() == null) || (getLang().equals("null")))
/*  390 */         pstmt.setNull(52, 12);
/*      */       else {
/*  392 */         pstmt.setString(52, getLang());
/*      */       }
/*  394 */       if ((getCurrency() == null) || (getCurrency().equals("null")))
/*  395 */         pstmt.setNull(53, 12);
/*      */       else {
/*  397 */         pstmt.setString(53, getCurrency());
/*      */       }
/*  399 */       if ((getRemark() == null) || (getRemark().equals("null")))
/*  400 */         pstmt.setNull(54, 12);
/*      */       else {
/*  402 */         pstmt.setString(54, getRemark());
/*      */       }
/*  404 */       pstmt.setInt(55, getPeoples());
/*  405 */       pstmt.setDouble(56, getMult());
/*  406 */       pstmt.setDouble(57, getPrem());
/*  407 */       pstmt.setDouble(58, getAmnt());
/*  408 */       pstmt.setDouble(59, getSumPrem());
/*  409 */       pstmt.setDouble(60, getDif());
/*  410 */       if ((getPaytoDate() == null) || (getPaytoDate().equals("null")))
/*  411 */         pstmt.setNull(61, 91);
/*      */       else {
/*  413 */         pstmt.setDate(61, Date.valueOf(getPaytoDate()));
/*      */       }
/*  415 */       if ((getFirstPayDate() == null) || (getFirstPayDate().equals("null")))
/*  416 */         pstmt.setNull(62, 91);
/*      */       else {
/*  418 */         pstmt.setDate(62, Date.valueOf(getFirstPayDate()));
/*      */       }
/*  420 */       if ((getCValiDate() == null) || (getCValiDate().equals("null")))
/*  421 */         pstmt.setNull(63, 91);
/*      */       else {
/*  423 */         pstmt.setDate(63, Date.valueOf(getCValiDate()));
/*      */       }
/*  425 */       if ((getPSignDate() == null) || (getPSignDate().equals("null")))
/*  426 */         pstmt.setNull(64, 91);
/*      */       else {
/*  428 */         pstmt.setDate(64, Date.valueOf(getPSignDate()));
/*      */       }
/*  430 */       if ((getPValiDate() == null) || (getPValiDate().equals("null")))
/*  431 */         pstmt.setNull(65, 91);
/*      */       else {
/*  433 */         pstmt.setDate(65, Date.valueOf(getPValiDate()));
/*      */       }
/*  435 */       if ((getInputOperator() == null) || (getInputOperator().equals("null")))
/*  436 */         pstmt.setNull(66, 12);
/*      */       else {
/*  438 */         pstmt.setString(66, getInputOperator());
/*      */       }
/*  440 */       if ((getInputDate() == null) || (getInputDate().equals("null")))
/*  441 */         pstmt.setNull(67, 91);
/*      */       else {
/*  443 */         pstmt.setDate(67, Date.valueOf(getInputDate()));
/*      */       }
/*  445 */       if ((getInputTime() == null) || (getInputTime().equals("null")))
/*  446 */         pstmt.setNull(68, 12);
/*      */       else {
/*  448 */         pstmt.setString(68, getInputTime());
/*      */       }
/*  450 */       if ((getApproveFlag() == null) || (getApproveFlag().equals("null")))
/*  451 */         pstmt.setNull(69, 12);
/*      */       else {
/*  453 */         pstmt.setString(69, getApproveFlag());
/*      */       }
/*  455 */       if ((getApproveCode() == null) || (getApproveCode().equals("null")))
/*  456 */         pstmt.setNull(70, 12);
/*      */       else {
/*  458 */         pstmt.setString(70, getApproveCode());
/*      */       }
/*  460 */       if ((getApproveDate() == null) || (getApproveDate().equals("null")))
/*  461 */         pstmt.setNull(71, 91);
/*      */       else {
/*  463 */         pstmt.setDate(71, Date.valueOf(getApproveDate()));
/*      */       }
/*  465 */       if ((getApproveTime() == null) || (getApproveTime().equals("null")))
/*  466 */         pstmt.setNull(72, 12);
/*      */       else {
/*  468 */         pstmt.setString(72, getApproveTime());
/*      */       }
/*  470 */       if ((getUWFlag() == null) || (getUWFlag().equals("null")))
/*  471 */         pstmt.setNull(73, 12);
/*      */       else {
/*  473 */         pstmt.setString(73, getUWFlag());
/*      */       }
/*  475 */       if ((getUWOperator() == null) || (getUWOperator().equals("null")))
/*  476 */         pstmt.setNull(74, 12);
/*      */       else {
/*  478 */         pstmt.setString(74, getUWOperator());
/*      */       }
/*  480 */       if ((getUWDate() == null) || (getUWDate().equals("null")))
/*  481 */         pstmt.setNull(75, 91);
/*      */       else {
/*  483 */         pstmt.setDate(75, Date.valueOf(getUWDate()));
/*      */       }
/*  485 */       if ((getUWTime() == null) || (getUWTime().equals("null")))
/*  486 */         pstmt.setNull(76, 12);
/*      */       else {
/*  488 */         pstmt.setString(76, getUWTime());
/*      */       }
/*  490 */       if ((getAppFlag() == null) || (getAppFlag().equals("null")))
/*  491 */         pstmt.setNull(77, 12);
/*      */       else {
/*  493 */         pstmt.setString(77, getAppFlag());
/*      */       }
/*  495 */       if ((getPolApplyDate() == null) || (getPolApplyDate().equals("null")))
/*  496 */         pstmt.setNull(78, 91);
/*      */       else {
/*  498 */         pstmt.setDate(78, Date.valueOf(getPolApplyDate()));
/*      */       }
/*  500 */       if ((getGetPolDate() == null) || (getGetPolDate().equals("null")))
/*  501 */         pstmt.setNull(79, 91);
/*      */       else {
/*  503 */         pstmt.setDate(79, Date.valueOf(getGetPolDate()));
/*      */       }
/*  505 */       if ((getGetPolTime() == null) || (getGetPolTime().equals("null")))
/*  506 */         pstmt.setNull(80, 12);
/*      */       else {
/*  508 */         pstmt.setString(80, getGetPolTime());
/*      */       }
/*  510 */       if ((getCustomGetPolDate() == null) || (getCustomGetPolDate().equals("null")))
/*  511 */         pstmt.setNull(81, 91);
/*      */       else {
/*  513 */         pstmt.setDate(81, Date.valueOf(getCustomGetPolDate()));
/*      */       }
/*  515 */       if ((getState() == null) || (getState().equals("null")))
/*  516 */         pstmt.setNull(82, 12);
/*      */       else {
/*  518 */         pstmt.setString(82, getState());
/*      */       }
/*  520 */       if ((getSaleChnlDetail() == null) || (getSaleChnlDetail().equals("null")))
/*  521 */         pstmt.setNull(83, 12);
/*      */       else {
/*  523 */         pstmt.setString(83, getSaleChnlDetail());
/*      */       }
/*  525 */       if ((getProposalType() == null) || (getProposalType().equals("null")))
/*  526 */         pstmt.setNull(84, 12);
/*      */       else {
/*  528 */         pstmt.setString(84, getProposalType());
/*      */       }
/*  530 */       if ((getEditstate() == null) || (getEditstate().equals("null")))
/*  531 */         pstmt.setNull(85, 12);
/*      */       else {
/*  533 */         pstmt.setString(85, getEditstate());
/*      */       }
/*  535 */       if ((getCInValiDate() == null) || (getCInValiDate().equals("null")))
/*  536 */         pstmt.setNull(86, 91);
/*      */       else {
/*  538 */         pstmt.setDate(86, Date.valueOf(getCInValiDate()));
/*      */       }
/*  540 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  541 */         pstmt.setNull(87, 12);
/*      */       else {
/*  543 */         pstmt.setString(87, getOperator());
/*      */       }
/*  545 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  546 */         pstmt.setNull(88, 91);
/*      */       else {
/*  548 */         pstmt.setDate(88, Date.valueOf(getMakeDate()));
/*      */       }
/*  550 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  551 */         pstmt.setNull(89, 12);
/*      */       else {
/*  553 */         pstmt.setString(89, getMakeTime());
/*      */       }
/*  555 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  556 */         pstmt.setNull(90, 91);
/*      */       else {
/*  558 */         pstmt.setDate(90, Date.valueOf(getModifyDate()));
/*      */       }
/*  560 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  561 */         pstmt.setNull(91, 12);
/*      */       else {
/*  563 */         pstmt.setString(91, getModifyTime());
/*      */       }
/*      */ 
/*  566 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  567 */         pstmt.setNull(92, 12);
/*      */       else {
/*  569 */         pstmt.setString(92, getContNo());
/*      */       }
/*  571 */       pstmt.executeUpdate();
/*  572 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  575 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  576 */       CError tError = new CError();
/*  577 */       tError.moduleName = "LNPContDB";
/*  578 */       tError.functionName = "update()";
/*  579 */       tError.errorMessage = ex.toString();
/*  580 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  583 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  586 */       if (!this.mflag)
/*      */         try {
/*  588 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  592 */       return false;
/*      */     }
/*      */ 
/*  595 */     if (!this.mflag)
/*      */       try {
/*  597 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  601 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  606 */     PreparedStatement pstmt = null;
/*      */ 
/*  608 */     if (!this.mflag) {
/*  609 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  614 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCont VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  615 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  616 */         pstmt.setNull(1, 12);
/*      */       else {
/*  618 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  620 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  621 */         pstmt.setNull(2, 12);
/*      */       else {
/*  623 */         pstmt.setString(2, getContNo());
/*      */       }
/*  625 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  626 */         pstmt.setNull(3, 12);
/*      */       else {
/*  628 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  630 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  631 */         pstmt.setNull(4, 12);
/*      */       else {
/*  633 */         pstmt.setString(4, getPrtNo());
/*      */       }
/*  635 */       if ((getMainPolNo() == null) || (getMainPolNo().equals("null")))
/*  636 */         pstmt.setNull(5, 12);
/*      */       else {
/*  638 */         pstmt.setString(5, getMainPolNo());
/*      */       }
/*  640 */       if ((getContType() == null) || (getContType().equals("null")))
/*  641 */         pstmt.setNull(6, 12);
/*      */       else {
/*  643 */         pstmt.setString(6, getContType());
/*      */       }
/*  645 */       if ((getFamilyType() == null) || (getFamilyType().equals("null")))
/*  646 */         pstmt.setNull(7, 12);
/*      */       else {
/*  648 */         pstmt.setString(7, getFamilyType());
/*      */       }
/*  650 */       if ((getFamilyID() == null) || (getFamilyID().equals("null")))
/*  651 */         pstmt.setNull(8, 12);
/*      */       else {
/*  653 */         pstmt.setString(8, getFamilyID());
/*      */       }
/*  655 */       if ((getPolType() == null) || (getPolType().equals("null")))
/*  656 */         pstmt.setNull(9, 12);
/*      */       else {
/*  658 */         pstmt.setString(9, getPolType());
/*      */       }
/*  660 */       if ((getSugNo() == null) || (getSugNo().equals("null")))
/*  661 */         pstmt.setNull(10, 12);
/*      */       else {
/*  663 */         pstmt.setString(10, getSugNo());
/*      */       }
/*  665 */       if ((getCardFlag() == null) || (getCardFlag().equals("null")))
/*  666 */         pstmt.setNull(11, 12);
/*      */       else {
/*  668 */         pstmt.setString(11, getCardFlag());
/*      */       }
/*  670 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  671 */         pstmt.setNull(12, 12);
/*      */       else {
/*  673 */         pstmt.setString(12, getManageCom());
/*      */       }
/*  675 */       if ((getExecuteCom() == null) || (getExecuteCom().equals("null")))
/*  676 */         pstmt.setNull(13, 12);
/*      */       else {
/*  678 */         pstmt.setString(13, getExecuteCom());
/*      */       }
/*  680 */       if ((getAgentCom() == null) || (getAgentCom().equals("null")))
/*  681 */         pstmt.setNull(14, 12);
/*      */       else {
/*  683 */         pstmt.setString(14, getAgentCom());
/*      */       }
/*  685 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  686 */         pstmt.setNull(15, 12);
/*      */       else {
/*  688 */         pstmt.setString(15, getAgentCode());
/*      */       }
/*  690 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  691 */         pstmt.setNull(16, 12);
/*      */       else {
/*  693 */         pstmt.setString(16, getAgentGroup());
/*      */       }
/*  695 */       if ((getAgentCode1() == null) || (getAgentCode1().equals("null")))
/*  696 */         pstmt.setNull(17, 12);
/*      */       else {
/*  698 */         pstmt.setString(17, getAgentCode1());
/*      */       }
/*  700 */       if ((getAgentGroup1() == null) || (getAgentGroup1().equals("null")))
/*  701 */         pstmt.setNull(18, 12);
/*      */       else {
/*  703 */         pstmt.setString(18, getAgentGroup1());
/*      */       }
/*  705 */       if ((getAgentType() == null) || (getAgentType().equals("null")))
/*  706 */         pstmt.setNull(19, 12);
/*      */       else {
/*  708 */         pstmt.setString(19, getAgentType());
/*      */       }
/*  710 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  711 */         pstmt.setNull(20, 12);
/*      */       else {
/*  713 */         pstmt.setString(20, getSaleChnl());
/*      */       }
/*  715 */       if ((getHandler() == null) || (getHandler().equals("null")))
/*  716 */         pstmt.setNull(21, 12);
/*      */       else {
/*  718 */         pstmt.setString(21, getHandler());
/*      */       }
/*  720 */       if ((getPassword() == null) || (getPassword().equals("null")))
/*  721 */         pstmt.setNull(22, 12);
/*      */       else {
/*  723 */         pstmt.setString(22, getPassword());
/*      */       }
/*  725 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  726 */         pstmt.setNull(23, 12);
/*      */       else {
/*  728 */         pstmt.setString(23, getAppntNo());
/*      */       }
/*  730 */       if ((getAppntId() == null) || (getAppntId().equals("null")))
/*  731 */         pstmt.setNull(24, 12);
/*      */       else {
/*  733 */         pstmt.setString(24, getAppntId());
/*      */       }
/*  735 */       if ((getAppntName() == null) || (getAppntName().equals("null")))
/*  736 */         pstmt.setNull(25, 12);
/*      */       else {
/*  738 */         pstmt.setString(25, getAppntName());
/*      */       }
/*  740 */       if ((getAppntSex() == null) || (getAppntSex().equals("null")))
/*  741 */         pstmt.setNull(26, 12);
/*      */       else {
/*  743 */         pstmt.setString(26, getAppntSex());
/*      */       }
/*  745 */       if ((getAppntBirthday() == null) || (getAppntBirthday().equals("null")))
/*  746 */         pstmt.setNull(27, 91);
/*      */       else {
/*  748 */         pstmt.setDate(27, Date.valueOf(getAppntBirthday()));
/*      */       }
/*  750 */       if ((getAppntIDType() == null) || (getAppntIDType().equals("null")))
/*  751 */         pstmt.setNull(28, 12);
/*      */       else {
/*  753 */         pstmt.setString(28, getAppntIDType());
/*      */       }
/*  755 */       if ((getAppntIDNo() == null) || (getAppntIDNo().equals("null")))
/*  756 */         pstmt.setNull(29, 12);
/*      */       else {
/*  758 */         pstmt.setString(29, getAppntIDNo());
/*      */       }
/*  760 */       if ((getInsuredNo() == null) || (getInsuredNo().equals("null")))
/*  761 */         pstmt.setNull(30, 12);
/*      */       else {
/*  763 */         pstmt.setString(30, getInsuredNo());
/*      */       }
/*  765 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  766 */         pstmt.setNull(31, 12);
/*      */       else {
/*  768 */         pstmt.setString(31, getInsuredId());
/*      */       }
/*  770 */       if ((getInsuredName() == null) || (getInsuredName().equals("null")))
/*  771 */         pstmt.setNull(32, 12);
/*      */       else {
/*  773 */         pstmt.setString(32, getInsuredName());
/*      */       }
/*  775 */       if ((getInsuredSex() == null) || (getInsuredSex().equals("null")))
/*  776 */         pstmt.setNull(33, 12);
/*      */       else {
/*  778 */         pstmt.setString(33, getInsuredSex());
/*      */       }
/*  780 */       if ((getInsuredBirthday() == null) || (getInsuredBirthday().equals("null")))
/*  781 */         pstmt.setNull(34, 91);
/*      */       else {
/*  783 */         pstmt.setDate(34, Date.valueOf(getInsuredBirthday()));
/*      */       }
/*  785 */       if ((getInsuredIDType() == null) || (getInsuredIDType().equals("null")))
/*  786 */         pstmt.setNull(35, 12);
/*      */       else {
/*  788 */         pstmt.setString(35, getInsuredIDType());
/*      */       }
/*  790 */       if ((getInsuredIDNo() == null) || (getInsuredIDNo().equals("null")))
/*  791 */         pstmt.setNull(36, 12);
/*      */       else {
/*  793 */         pstmt.setString(36, getInsuredIDNo());
/*      */       }
/*  795 */       pstmt.setInt(37, getPayIntv());
/*  796 */       if ((getPayMode() == null) || (getPayMode().equals("null")))
/*  797 */         pstmt.setNull(38, 12);
/*      */       else {
/*  799 */         pstmt.setString(38, getPayMode());
/*      */       }
/*  801 */       if ((getPayLocation() == null) || (getPayLocation().equals("null")))
/*  802 */         pstmt.setNull(39, 12);
/*      */       else {
/*  804 */         pstmt.setString(39, getPayLocation());
/*      */       }
/*  806 */       if ((getDisputedFlag() == null) || (getDisputedFlag().equals("null")))
/*  807 */         pstmt.setNull(40, 12);
/*      */       else {
/*  809 */         pstmt.setString(40, getDisputedFlag());
/*      */       }
/*  811 */       if ((getOutPayFlag() == null) || (getOutPayFlag().equals("null")))
/*  812 */         pstmt.setNull(41, 12);
/*      */       else {
/*  814 */         pstmt.setString(41, getOutPayFlag());
/*      */       }
/*  816 */       if ((getGetPolMode() == null) || (getGetPolMode().equals("null")))
/*  817 */         pstmt.setNull(42, 12);
/*      */       else {
/*  819 */         pstmt.setString(42, getGetPolMode());
/*      */       }
/*  821 */       if ((getSignCom() == null) || (getSignCom().equals("null")))
/*  822 */         pstmt.setNull(43, 12);
/*      */       else {
/*  824 */         pstmt.setString(43, getSignCom());
/*      */       }
/*  826 */       if ((getSignDate() == null) || (getSignDate().equals("null")))
/*  827 */         pstmt.setNull(44, 91);
/*      */       else {
/*  829 */         pstmt.setDate(44, Date.valueOf(getSignDate()));
/*      */       }
/*  831 */       if ((getSignTime() == null) || (getSignTime().equals("null")))
/*  832 */         pstmt.setNull(45, 12);
/*      */       else {
/*  834 */         pstmt.setString(45, getSignTime());
/*      */       }
/*  836 */       if ((getConsignNo() == null) || (getConsignNo().equals("null")))
/*  837 */         pstmt.setNull(46, 12);
/*      */       else {
/*  839 */         pstmt.setString(46, getConsignNo());
/*      */       }
/*  841 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  842 */         pstmt.setNull(47, 12);
/*      */       else {
/*  844 */         pstmt.setString(47, getBankCode());
/*      */       }
/*  846 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  847 */         pstmt.setNull(48, 12);
/*      */       else {
/*  849 */         pstmt.setString(48, getBankAccNo());
/*      */       }
/*  851 */       if ((getAccName() == null) || (getAccName().equals("null")))
/*  852 */         pstmt.setNull(49, 12);
/*      */       else {
/*  854 */         pstmt.setString(49, getAccName());
/*      */       }
/*  856 */       pstmt.setInt(50, getPrintCount());
/*  857 */       pstmt.setInt(51, getLostTimes());
/*  858 */       if ((getLang() == null) || (getLang().equals("null")))
/*  859 */         pstmt.setNull(52, 12);
/*      */       else {
/*  861 */         pstmt.setString(52, getLang());
/*      */       }
/*  863 */       if ((getCurrency() == null) || (getCurrency().equals("null")))
/*  864 */         pstmt.setNull(53, 12);
/*      */       else {
/*  866 */         pstmt.setString(53, getCurrency());
/*      */       }
/*  868 */       if ((getRemark() == null) || (getRemark().equals("null")))
/*  869 */         pstmt.setNull(54, 12);
/*      */       else {
/*  871 */         pstmt.setString(54, getRemark());
/*      */       }
/*  873 */       pstmt.setInt(55, getPeoples());
/*  874 */       pstmt.setDouble(56, getMult());
/*  875 */       pstmt.setDouble(57, getPrem());
/*  876 */       pstmt.setDouble(58, getAmnt());
/*  877 */       pstmt.setDouble(59, getSumPrem());
/*  878 */       pstmt.setDouble(60, getDif());
/*  879 */       if ((getPaytoDate() == null) || (getPaytoDate().equals("null")))
/*  880 */         pstmt.setNull(61, 91);
/*      */       else {
/*  882 */         pstmt.setDate(61, Date.valueOf(getPaytoDate()));
/*      */       }
/*  884 */       if ((getFirstPayDate() == null) || (getFirstPayDate().equals("null")))
/*  885 */         pstmt.setNull(62, 91);
/*      */       else {
/*  887 */         pstmt.setDate(62, Date.valueOf(getFirstPayDate()));
/*      */       }
/*  889 */       if ((getCValiDate() == null) || (getCValiDate().equals("null")))
/*  890 */         pstmt.setNull(63, 91);
/*      */       else {
/*  892 */         pstmt.setDate(63, Date.valueOf(getCValiDate()));
/*      */       }
/*  894 */       if ((getPSignDate() == null) || (getPSignDate().equals("null")))
/*  895 */         pstmt.setNull(64, 91);
/*      */       else {
/*  897 */         pstmt.setDate(64, Date.valueOf(getPSignDate()));
/*      */       }
/*  899 */       if ((getPValiDate() == null) || (getPValiDate().equals("null")))
/*  900 */         pstmt.setNull(65, 91);
/*      */       else {
/*  902 */         pstmt.setDate(65, Date.valueOf(getPValiDate()));
/*      */       }
/*  904 */       if ((getInputOperator() == null) || (getInputOperator().equals("null")))
/*  905 */         pstmt.setNull(66, 12);
/*      */       else {
/*  907 */         pstmt.setString(66, getInputOperator());
/*      */       }
/*  909 */       if ((getInputDate() == null) || (getInputDate().equals("null")))
/*  910 */         pstmt.setNull(67, 91);
/*      */       else {
/*  912 */         pstmt.setDate(67, Date.valueOf(getInputDate()));
/*      */       }
/*  914 */       if ((getInputTime() == null) || (getInputTime().equals("null")))
/*  915 */         pstmt.setNull(68, 12);
/*      */       else {
/*  917 */         pstmt.setString(68, getInputTime());
/*      */       }
/*  919 */       if ((getApproveFlag() == null) || (getApproveFlag().equals("null")))
/*  920 */         pstmt.setNull(69, 12);
/*      */       else {
/*  922 */         pstmt.setString(69, getApproveFlag());
/*      */       }
/*  924 */       if ((getApproveCode() == null) || (getApproveCode().equals("null")))
/*  925 */         pstmt.setNull(70, 12);
/*      */       else {
/*  927 */         pstmt.setString(70, getApproveCode());
/*      */       }
/*  929 */       if ((getApproveDate() == null) || (getApproveDate().equals("null")))
/*  930 */         pstmt.setNull(71, 91);
/*      */       else {
/*  932 */         pstmt.setDate(71, Date.valueOf(getApproveDate()));
/*      */       }
/*  934 */       if ((getApproveTime() == null) || (getApproveTime().equals("null")))
/*  935 */         pstmt.setNull(72, 12);
/*      */       else {
/*  937 */         pstmt.setString(72, getApproveTime());
/*      */       }
/*  939 */       if ((getUWFlag() == null) || (getUWFlag().equals("null")))
/*  940 */         pstmt.setNull(73, 12);
/*      */       else {
/*  942 */         pstmt.setString(73, getUWFlag());
/*      */       }
/*  944 */       if ((getUWOperator() == null) || (getUWOperator().equals("null")))
/*  945 */         pstmt.setNull(74, 12);
/*      */       else {
/*  947 */         pstmt.setString(74, getUWOperator());
/*      */       }
/*  949 */       if ((getUWDate() == null) || (getUWDate().equals("null")))
/*  950 */         pstmt.setNull(75, 91);
/*      */       else {
/*  952 */         pstmt.setDate(75, Date.valueOf(getUWDate()));
/*      */       }
/*  954 */       if ((getUWTime() == null) || (getUWTime().equals("null")))
/*  955 */         pstmt.setNull(76, 12);
/*      */       else {
/*  957 */         pstmt.setString(76, getUWTime());
/*      */       }
/*  959 */       if ((getAppFlag() == null) || (getAppFlag().equals("null")))
/*  960 */         pstmt.setNull(77, 12);
/*      */       else {
/*  962 */         pstmt.setString(77, getAppFlag());
/*      */       }
/*  964 */       if ((getPolApplyDate() == null) || (getPolApplyDate().equals("null")))
/*  965 */         pstmt.setNull(78, 91);
/*      */       else {
/*  967 */         pstmt.setDate(78, Date.valueOf(getPolApplyDate()));
/*      */       }
/*  969 */       if ((getGetPolDate() == null) || (getGetPolDate().equals("null")))
/*  970 */         pstmt.setNull(79, 91);
/*      */       else {
/*  972 */         pstmt.setDate(79, Date.valueOf(getGetPolDate()));
/*      */       }
/*  974 */       if ((getGetPolTime() == null) || (getGetPolTime().equals("null")))
/*  975 */         pstmt.setNull(80, 12);
/*      */       else {
/*  977 */         pstmt.setString(80, getGetPolTime());
/*      */       }
/*  979 */       if ((getCustomGetPolDate() == null) || (getCustomGetPolDate().equals("null")))
/*  980 */         pstmt.setNull(81, 91);
/*      */       else {
/*  982 */         pstmt.setDate(81, Date.valueOf(getCustomGetPolDate()));
/*      */       }
/*  984 */       if ((getState() == null) || (getState().equals("null")))
/*  985 */         pstmt.setNull(82, 12);
/*      */       else {
/*  987 */         pstmt.setString(82, getState());
/*      */       }
/*  989 */       if ((getSaleChnlDetail() == null) || (getSaleChnlDetail().equals("null")))
/*  990 */         pstmt.setNull(83, 12);
/*      */       else {
/*  992 */         pstmt.setString(83, getSaleChnlDetail());
/*      */       }
/*  994 */       if ((getProposalType() == null) || (getProposalType().equals("null")))
/*  995 */         pstmt.setNull(84, 12);
/*      */       else {
/*  997 */         pstmt.setString(84, getProposalType());
/*      */       }
/*  999 */       if ((getEditstate() == null) || (getEditstate().equals("null")))
/* 1000 */         pstmt.setNull(85, 12);
/*      */       else {
/* 1002 */         pstmt.setString(85, getEditstate());
/*      */       }
/* 1004 */       if ((getCInValiDate() == null) || (getCInValiDate().equals("null")))
/* 1005 */         pstmt.setNull(86, 91);
/*      */       else {
/* 1007 */         pstmt.setDate(86, Date.valueOf(getCInValiDate()));
/*      */       }
/* 1009 */       if ((getOperator() == null) || (getOperator().equals("null")))
/* 1010 */         pstmt.setNull(87, 12);
/*      */       else {
/* 1012 */         pstmt.setString(87, getOperator());
/*      */       }
/* 1014 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/* 1015 */         pstmt.setNull(88, 91);
/*      */       else {
/* 1017 */         pstmt.setDate(88, Date.valueOf(getMakeDate()));
/*      */       }
/* 1019 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/* 1020 */         pstmt.setNull(89, 12);
/*      */       else {
/* 1022 */         pstmt.setString(89, getMakeTime());
/*      */       }
/* 1024 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/* 1025 */         pstmt.setNull(90, 91);
/*      */       else {
/* 1027 */         pstmt.setDate(90, Date.valueOf(getModifyDate()));
/*      */       }
/* 1029 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/* 1030 */         pstmt.setNull(91, 12);
/*      */       else {
/* 1032 */         pstmt.setString(91, getModifyTime());
/*      */       }
/*      */ 
/* 1035 */       pstmt.executeUpdate();
/* 1036 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/* 1039 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 1040 */       CError tError = new CError();
/* 1041 */       tError.moduleName = "LNPContDB";
/* 1042 */       tError.functionName = "insert()";
/* 1043 */       tError.errorMessage = ex.toString();
/* 1044 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1047 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/* 1050 */       if (!this.mflag)
/*      */         try {
/* 1052 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/* 1056 */       return false;
/*      */     }
/*      */ 
/* 1059 */     if (!this.mflag)
/*      */       try {
/* 1061 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/* 1065 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/* 1070 */     PreparedStatement pstmt = null;
/* 1071 */     ResultSet rs = null;
/*      */ 
/* 1073 */     if (!this.mflag) {
/* 1074 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1079 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPCont WHERE  ContNo = ?", 
/* 1080 */         1003, 1007);
/* 1081 */       if ((getContNo() == null) || (getContNo().equals("null")))
/* 1082 */         pstmt.setNull(1, 12);
/*      */       else {
/* 1084 */         pstmt.setString(1, getContNo());
/*      */       }
/* 1086 */       rs = pstmt.executeQuery();
/* 1087 */       int i = 0;
/* 1088 */       if (rs.next())
/*      */       {
/* 1090 */         i++;
/* 1091 */         if (!setSchema(rs, i))
/*      */         {
/* 1094 */           CError tError = new CError();
/* 1095 */           tError.moduleName = "LNPContDB";
/* 1096 */           tError.functionName = "getInfo";
/* 1097 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/* 1098 */           this.mErrors.addOneError(tError);
/*      */           try {
/* 1100 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/* 1103 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/* 1107 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/* 1111 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/* 1115 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/* 1118 */       if (i == 0)
/*      */       {
/* 1120 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1124 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/* 1128 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1134 */       CError tError = new CError();
/* 1135 */       tError.moduleName = "LNPContDB";
/* 1136 */       tError.functionName = "getInfo";
/* 1137 */       tError.errorMessage = e.toString();
/* 1138 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1140 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/* 1143 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1147 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/* 1151 */       return false;
/*      */     }
/*      */ 
/* 1154 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1158 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/* 1163 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPContSet query()
/*      */   {
/* 1168 */     Statement stmt = null;
/* 1169 */     ResultSet rs = null;
/* 1170 */     LNPContSet aLNPContSet = new LNPContSet();
/*      */ 
/* 1172 */     if (!this.mflag) {
/* 1173 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1178 */       stmt = this.con.createStatement(1003, 1007);
/* 1179 */       SQLString sqlObj = new SQLString("LNPCont");
/* 1180 */       LNPContSchema aSchema = getSchema();
/* 1181 */       sqlObj.setSQL(5, aSchema);
/* 1182 */       String sql = sqlObj.getSQL();
/*      */ 
/* 1184 */       rs = stmt.executeQuery(sql);
/* 1185 */       int i = 0;
/* 1186 */       while (rs.next())
/*      */       {
/* 1188 */         i++;
/* 1189 */         LNPContSchema s1 = new LNPContSchema();
/* 1190 */         s1.setSchema(rs, i);
/* 1191 */         aLNPContSet.add(s1);
/*      */       }try {
/* 1193 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1199 */       CError tError = new CError();
/* 1200 */       tError.moduleName = "LNPContDB";
/* 1201 */       tError.functionName = "query";
/* 1202 */       tError.errorMessage = e.toString();
/* 1203 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1205 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1208 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1212 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1218 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1222 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1227 */     return aLNPContSet;
/*      */   }
/*      */ 
/*      */   public LNPContSet executeQuery(String sql)
/*      */   {
/* 1232 */     Statement stmt = null;
/* 1233 */     ResultSet rs = null;
/* 1234 */     LNPContSet aLNPContSet = new LNPContSet();
/*      */ 
/* 1236 */     if (!this.mflag) {
/* 1237 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1242 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1244 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1245 */       int i = 0;
/* 1246 */       while (rs.next())
/*      */       {
/* 1248 */         i++;
/* 1249 */         LNPContSchema s1 = new LNPContSchema();
/* 1250 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1253 */           CError tError = new CError();
/* 1254 */           tError.moduleName = "LNPContDB";
/* 1255 */           tError.functionName = "executeQuery";
/* 1256 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 1257 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1259 */         aLNPContSet.add(s1);
/*      */       }try {
/* 1261 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1267 */       CError tError = new CError();
/* 1268 */       tError.moduleName = "LNPContDB";
/* 1269 */       tError.functionName = "executeQuery";
/* 1270 */       tError.errorMessage = e.toString();
/* 1271 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1273 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1276 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1280 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1286 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1290 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1295 */     return aLNPContSet;
/*      */   }
/*      */ 
/*      */   public LNPContSet query(int nStart, int nCount)
/*      */   {
/* 1300 */     Statement stmt = null;
/* 1301 */     ResultSet rs = null;
/* 1302 */     LNPContSet aLNPContSet = new LNPContSet();
/*      */ 
/* 1304 */     if (!this.mflag) {
/* 1305 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1310 */       stmt = this.con.createStatement(1003, 1007);
/* 1311 */       SQLString sqlObj = new SQLString("LNPCont");
/* 1312 */       LNPContSchema aSchema = getSchema();
/* 1313 */       sqlObj.setSQL(5, aSchema);
/* 1314 */       String sql = sqlObj.getSQL();
/*      */ 
/* 1316 */       rs = stmt.executeQuery(sql);
/* 1317 */       int i = 0;
/* 1318 */       while (rs.next())
/*      */       {
/* 1320 */         i++;
/*      */ 
/* 1322 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1326 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1330 */         LNPContSchema s1 = new LNPContSchema();
/* 1331 */         s1.setSchema(rs, i);
/* 1332 */         aLNPContSet.add(s1);
/*      */       }try {
/* 1334 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1340 */       CError tError = new CError();
/* 1341 */       tError.moduleName = "LNPContDB";
/* 1342 */       tError.functionName = "query";
/* 1343 */       tError.errorMessage = e.toString();
/* 1344 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1346 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1349 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1353 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1359 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1363 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1368 */     return aLNPContSet;
/*      */   }
/*      */ 
/*      */   public LNPContSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/* 1373 */     Statement stmt = null;
/* 1374 */     ResultSet rs = null;
/* 1375 */     LNPContSet aLNPContSet = new LNPContSet();
/*      */ 
/* 1377 */     if (!this.mflag) {
/* 1378 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1383 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1385 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1386 */       int i = 0;
/* 1387 */       while (rs.next())
/*      */       {
/* 1389 */         i++;
/*      */ 
/* 1391 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1395 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1399 */         LNPContSchema s1 = new LNPContSchema();
/* 1400 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1403 */           CError tError = new CError();
/* 1404 */           tError.moduleName = "LNPContDB";
/* 1405 */           tError.functionName = "executeQuery";
/* 1406 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 1407 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1409 */         aLNPContSet.add(s1);
/*      */       }try {
/* 1411 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1417 */       CError tError = new CError();
/* 1418 */       tError.moduleName = "LNPContDB";
/* 1419 */       tError.functionName = "executeQuery";
/* 1420 */       tError.errorMessage = e.toString();
/* 1421 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1423 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1426 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1430 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1436 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1440 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1445 */     return aLNPContSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1450 */     Statement stmt = null;
/*      */ 
/* 1452 */     if (!this.mflag) {
/* 1453 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1458 */       stmt = this.con.createStatement(1003, 1007);
/* 1459 */       SQLString sqlObj = new SQLString("LNPCont");
/* 1460 */       LNPContSchema aSchema = getSchema();
/* 1461 */       sqlObj.setSQL(2, aSchema);
/* 1462 */       String sql = "update LNPCont " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1464 */       int operCount = stmt.executeUpdate(sql);
/* 1465 */       if (operCount == 0)
/*      */       {
/* 1468 */         CError tError = new CError();
/* 1469 */         tError.moduleName = "LNPContDB";
/* 1470 */         tError.functionName = "update";
/* 1471 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 1472 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1474 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1478 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1482 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1488 */       CError tError = new CError();
/* 1489 */       tError.moduleName = "LNPContDB";
/* 1490 */       tError.functionName = "update";
/* 1491 */       tError.errorMessage = e.toString();
/* 1492 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1494 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1496 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1500 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1504 */       return false;
/*      */     }
/*      */ 
/* 1507 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1511 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1516 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1522 */     if (this.mResultSet != null)
/*      */     {
/* 1525 */       CError tError = new CError();
/* 1526 */       tError.moduleName = "LNPContDB";
/* 1527 */       tError.functionName = "prepareData";
/* 1528 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 1529 */       this.mErrors.addOneError(tError);
/* 1530 */       return false;
/*      */     }
/*      */ 
/* 1533 */     if (!this.mflag)
/*      */     {
/* 1535 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1539 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1540 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1545 */       CError tError = new CError();
/* 1546 */       tError.moduleName = "LNPContDB";
/* 1547 */       tError.functionName = "prepareData";
/* 1548 */       tError.errorMessage = e.toString();
/* 1549 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1552 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1558 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1562 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1566 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1571 */       return false;
/*      */     }
/*      */ 
/* 1574 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1578 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1583 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1589 */     boolean flag = true;
/* 1590 */     if (this.mResultSet == null)
/*      */     {
/* 1592 */       CError tError = new CError();
/* 1593 */       tError.moduleName = "LNPContDB";
/* 1594 */       tError.functionName = "hasMoreData";
/* 1595 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1596 */       this.mErrors.addOneError(tError);
/* 1597 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1601 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1605 */       CError tError = new CError();
/* 1606 */       tError.moduleName = "LNPContDB";
/* 1607 */       tError.functionName = "hasMoreData";
/* 1608 */       tError.errorMessage = ex.toString();
/* 1609 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1612 */         this.mResultSet.close();
/* 1613 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1619 */         this.mStatement.close();
/* 1620 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1624 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1628 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1633 */       return false;
/*      */     }
/* 1635 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPContSet getData()
/*      */   {
/* 1640 */     int tCount = 0;
/* 1641 */     LNPContSet tLNPContSet = new LNPContSet();
/* 1642 */     LNPContSchema tLNPContSchema = null;
/* 1643 */     if (this.mResultSet == null)
/*      */     {
/* 1645 */       CError tError = new CError();
/* 1646 */       tError.moduleName = "LNPContDB";
/* 1647 */       tError.functionName = "getData";
/* 1648 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1649 */       this.mErrors.addOneError(tError);
/* 1650 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1654 */       tCount = 1;
/* 1655 */       tLNPContSchema = new LNPContSchema();
/* 1656 */       tLNPContSchema.setSchema(this.mResultSet, 1);
/* 1657 */       tLNPContSet.add(tLNPContSchema);
/*      */ 
/* 1659 */       while (tCount++ < 5000)
/*      */       {
/* 1661 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1663 */         tLNPContSchema = new LNPContSchema();
/* 1664 */         tLNPContSchema.setSchema(this.mResultSet, 1);
/* 1665 */         tLNPContSet.add(tLNPContSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1671 */       CError tError = new CError();
/* 1672 */       tError.moduleName = "LNPContDB";
/* 1673 */       tError.functionName = "getData";
/* 1674 */       tError.errorMessage = ex.toString();
/* 1675 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1678 */         this.mResultSet.close();
/* 1679 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1685 */         this.mStatement.close();
/* 1686 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1690 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1694 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1699 */       return null;
/*      */     }
/* 1701 */     return tLNPContSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1706 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1709 */       if (this.mResultSet == null)
/*      */       {
/* 1711 */         CError tError = new CError();
/* 1712 */         tError.moduleName = "LNPContDB";
/* 1713 */         tError.functionName = "closeData";
/* 1714 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1715 */         this.mErrors.addOneError(tError);
/* 1716 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1720 */         this.mResultSet.close();
/* 1721 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1726 */       CError tError = new CError();
/* 1727 */       tError.moduleName = "LNPContDB";
/* 1728 */       tError.functionName = "closeData";
/* 1729 */       tError.errorMessage = ex2.toString();
/* 1730 */       this.mErrors.addOneError(tError);
/* 1731 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1735 */       if (this.mStatement == null)
/*      */       {
/* 1737 */         CError tError = new CError();
/* 1738 */         tError.moduleName = "LNPContDB";
/* 1739 */         tError.functionName = "closeData";
/* 1740 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1741 */         this.mErrors.addOneError(tError);
/* 1742 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1746 */         this.mStatement.close();
/* 1747 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1752 */       CError tError = new CError();
/* 1753 */       tError.moduleName = "LNPContDB";
/* 1754 */       tError.functionName = "closeData";
/* 1755 */       tError.errorMessage = ex3.toString();
/* 1756 */       this.mErrors.addOneError(tError);
/* 1757 */       flag = false;
/*      */     }
/* 1759 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPContDB
 * JD-Core Version:    0.6.0
 */