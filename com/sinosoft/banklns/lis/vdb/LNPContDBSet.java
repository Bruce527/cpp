/*      */ package com.sinosoft.banklns.lis.vdb;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPContSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ 
/*      */ public class LNPContDBSet extends LNPContSet
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   24 */   private boolean mflag = false;
/*      */ 
/*      */   public LNPContDBSet(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "LNPCont");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPContDBSet()
/*      */   {
/*   37 */     this.db = new DBOper("LNPCont");
/*   38 */     this.con = this.db.getConnection();
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   43 */     if (this.db.deleteSQL(this))
/*      */     {
/*   45 */       return true;
/*      */     }
/*      */ 
/*   50 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   51 */     CError tError = new CError();
/*   52 */     tError.moduleName = "LNPContDBSet";
/*   53 */     tError.functionName = "deleteSQL";
/*   54 */     tError.errorMessage = "\u6709\u8BEF!";
/*   55 */     this.mErrors.addOneError(tError);
/*   56 */     return false;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   63 */     PreparedStatement pstmt = null;
/*      */ 
/*   65 */     if (!this.mflag) {
/*   66 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   71 */       int tCount = size();
/*   72 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCont WHERE  ContNo = ?");
/*   73 */       for (int i = 1; i <= tCount; i++)
/*      */       {
/*   75 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*   76 */           pstmt.setString(1, null);
/*      */         else {
/*   78 */           pstmt.setString(1, get(i).getContNo());
/*      */         }
/*   80 */         pstmt.addBatch();
/*      */       }
/*   82 */       pstmt.executeBatch();
/*   83 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*   86 */       ex.printStackTrace();
/*   87 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   88 */       CError tError = new CError();
/*   89 */       tError.moduleName = "LNPContDBSet";
/*   90 */       tError.functionName = "delete()";
/*   91 */       tError.errorMessage = ex.toString();
/*   92 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*   95 */         pstmt.close(); } catch (Exception e) {
/*   96 */         e.printStackTrace();
/*      */       }
/*   98 */       if (!this.mflag) {
/*      */         try {
/*  100 */           this.con.close(); } catch (Exception e) {
/*  101 */           e.printStackTrace();
/*      */         }
/*      */       }
/*  104 */       return false;
/*      */     }
/*      */ 
/*  107 */     if (!this.mflag) {
/*      */       try {
/*  109 */         this.con.close(); } catch (Exception e) {
/*  110 */         e.printStackTrace();
/*      */       }
/*      */     }
/*  113 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  119 */     PreparedStatement pstmt = null;
/*      */ 
/*  121 */     if (!this.mflag) {
/*  122 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  127 */       int tCount = size();
/*  128 */       pstmt = this.con.prepareStatement("UPDATE LNPCont SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , MainPolNo = ? , ContType = ? , FamilyType = ? , FamilyID = ? , PolType = ? , SugNo = ? , CardFlag = ? , ManageCom = ? , ExecuteCom = ? , AgentCom = ? , AgentCode = ? , AgentGroup = ? , AgentCode1 = ? , AgentGroup1 = ? , AgentType = ? , SaleChnl = ? , Handler = ? , Password = ? , AppntNo = ? , AppntId = ? , AppntName = ? , AppntSex = ? , AppntBirthday = ? , AppntIDType = ? , AppntIDNo = ? , InsuredNo = ? , InsuredId = ? , InsuredName = ? , InsuredSex = ? , InsuredBirthday = ? , InsuredIDType = ? , InsuredIDNo = ? , PayIntv = ? , PayMode = ? , PayLocation = ? , DisputedFlag = ? , OutPayFlag = ? , GetPolMode = ? , SignCom = ? , SignDate = ? , SignTime = ? , ConsignNo = ? , BankCode = ? , BankAccNo = ? , AccName = ? , PrintCount = ? , LostTimes = ? , Lang = ? , Currency = ? , Remark = ? , Peoples = ? , Mult = ? , Prem = ? , Amnt = ? , SumPrem = ? , Dif = ? , PaytoDate = ? , FirstPayDate = ? , CValiDate = ? , PSignDate = ? , PValiDate = ? , InputOperator = ? , InputDate = ? , InputTime = ? , ApproveFlag = ? , ApproveCode = ? , ApproveDate = ? , ApproveTime = ? , UWFlag = ? , UWOperator = ? , UWDate = ? , UWTime = ? , AppFlag = ? , PolApplyDate = ? , GetPolDate = ? , GetPolTime = ? , CustomGetPolDate = ? , State = ? , SaleChnlDetail = ? , ProposalType = ? , Editstate = ? , CInValiDate = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ?");
/*  129 */       for (int i = 1; i <= tCount; i++)
/*      */       {
/*  131 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/*  132 */           pstmt.setString(1, null);
/*      */         else {
/*  134 */           pstmt.setString(1, get(i).getGrpContNo());
/*      */         }
/*  136 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  137 */           pstmt.setString(2, null);
/*      */         else {
/*  139 */           pstmt.setString(2, get(i).getContNo());
/*      */         }
/*  141 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/*  142 */           pstmt.setString(3, null);
/*      */         else {
/*  144 */           pstmt.setString(3, get(i).getProposalContNo());
/*      */         }
/*  146 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/*  147 */           pstmt.setString(4, null);
/*      */         else {
/*  149 */           pstmt.setString(4, get(i).getPrtNo());
/*      */         }
/*  151 */         if ((get(i).getMainPolNo() == null) || (get(i).getMainPolNo().equals("null")))
/*  152 */           pstmt.setString(5, null);
/*      */         else {
/*  154 */           pstmt.setString(5, get(i).getMainPolNo());
/*      */         }
/*  156 */         if ((get(i).getContType() == null) || (get(i).getContType().equals("null")))
/*  157 */           pstmt.setString(6, null);
/*      */         else {
/*  159 */           pstmt.setString(6, get(i).getContType());
/*      */         }
/*  161 */         if ((get(i).getFamilyType() == null) || (get(i).getFamilyType().equals("null")))
/*  162 */           pstmt.setString(7, null);
/*      */         else {
/*  164 */           pstmt.setString(7, get(i).getFamilyType());
/*      */         }
/*  166 */         if ((get(i).getFamilyID() == null) || (get(i).getFamilyID().equals("null")))
/*  167 */           pstmt.setString(8, null);
/*      */         else {
/*  169 */           pstmt.setString(8, get(i).getFamilyID());
/*      */         }
/*  171 */         if ((get(i).getPolType() == null) || (get(i).getPolType().equals("null")))
/*  172 */           pstmt.setString(9, null);
/*      */         else {
/*  174 */           pstmt.setString(9, get(i).getPolType());
/*      */         }
/*  176 */         if ((get(i).getSugNo() == null) || (get(i).getSugNo().equals("null")))
/*  177 */           pstmt.setString(10, null);
/*      */         else {
/*  179 */           pstmt.setString(10, get(i).getSugNo());
/*      */         }
/*  181 */         if ((get(i).getCardFlag() == null) || (get(i).getCardFlag().equals("null")))
/*  182 */           pstmt.setString(11, null);
/*      */         else {
/*  184 */           pstmt.setString(11, get(i).getCardFlag());
/*      */         }
/*  186 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/*  187 */           pstmt.setString(12, null);
/*      */         else {
/*  189 */           pstmt.setString(12, get(i).getManageCom());
/*      */         }
/*  191 */         if ((get(i).getExecuteCom() == null) || (get(i).getExecuteCom().equals("null")))
/*  192 */           pstmt.setString(13, null);
/*      */         else {
/*  194 */           pstmt.setString(13, get(i).getExecuteCom());
/*      */         }
/*  196 */         if ((get(i).getAgentCom() == null) || (get(i).getAgentCom().equals("null")))
/*  197 */           pstmt.setString(14, null);
/*      */         else {
/*  199 */           pstmt.setString(14, get(i).getAgentCom());
/*      */         }
/*  201 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*  202 */           pstmt.setString(15, null);
/*      */         else {
/*  204 */           pstmt.setString(15, get(i).getAgentCode());
/*      */         }
/*  206 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/*  207 */           pstmt.setString(16, null);
/*      */         else {
/*  209 */           pstmt.setString(16, get(i).getAgentGroup());
/*      */         }
/*  211 */         if ((get(i).getAgentCode1() == null) || (get(i).getAgentCode1().equals("null")))
/*  212 */           pstmt.setString(17, null);
/*      */         else {
/*  214 */           pstmt.setString(17, get(i).getAgentCode1());
/*      */         }
/*  216 */         if ((get(i).getAgentGroup1() == null) || (get(i).getAgentGroup1().equals("null")))
/*  217 */           pstmt.setString(18, null);
/*      */         else {
/*  219 */           pstmt.setString(18, get(i).getAgentGroup1());
/*      */         }
/*  221 */         if ((get(i).getAgentType() == null) || (get(i).getAgentType().equals("null")))
/*  222 */           pstmt.setString(19, null);
/*      */         else {
/*  224 */           pstmt.setString(19, get(i).getAgentType());
/*      */         }
/*  226 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/*  227 */           pstmt.setString(20, null);
/*      */         else {
/*  229 */           pstmt.setString(20, get(i).getSaleChnl());
/*      */         }
/*  231 */         if ((get(i).getHandler() == null) || (get(i).getHandler().equals("null")))
/*  232 */           pstmt.setString(21, null);
/*      */         else {
/*  234 */           pstmt.setString(21, get(i).getHandler());
/*      */         }
/*  236 */         if ((get(i).getPassword() == null) || (get(i).getPassword().equals("null")))
/*  237 */           pstmt.setString(22, null);
/*      */         else {
/*  239 */           pstmt.setString(22, get(i).getPassword());
/*      */         }
/*  241 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/*  242 */           pstmt.setString(23, null);
/*      */         else {
/*  244 */           pstmt.setString(23, get(i).getAppntNo());
/*      */         }
/*  246 */         if ((get(i).getAppntId() == null) || (get(i).getAppntId().equals("null")))
/*  247 */           pstmt.setString(24, null);
/*      */         else {
/*  249 */           pstmt.setString(24, get(i).getAppntId());
/*      */         }
/*  251 */         if ((get(i).getAppntName() == null) || (get(i).getAppntName().equals("null")))
/*  252 */           pstmt.setString(25, null);
/*      */         else {
/*  254 */           pstmt.setString(25, get(i).getAppntName());
/*      */         }
/*  256 */         if ((get(i).getAppntSex() == null) || (get(i).getAppntSex().equals("null")))
/*  257 */           pstmt.setString(26, null);
/*      */         else {
/*  259 */           pstmt.setString(26, get(i).getAppntSex());
/*      */         }
/*  261 */         if ((get(i).getAppntBirthday() == null) || (get(i).getAppntBirthday().equals("null")))
/*  262 */           pstmt.setDate(27, null);
/*      */         else {
/*  264 */           pstmt.setDate(27, Date.valueOf(get(i).getAppntBirthday()));
/*      */         }
/*  266 */         if ((get(i).getAppntIDType() == null) || (get(i).getAppntIDType().equals("null")))
/*  267 */           pstmt.setString(28, null);
/*      */         else {
/*  269 */           pstmt.setString(28, get(i).getAppntIDType());
/*      */         }
/*  271 */         if ((get(i).getAppntIDNo() == null) || (get(i).getAppntIDNo().equals("null")))
/*  272 */           pstmt.setString(29, null);
/*      */         else {
/*  274 */           pstmt.setString(29, get(i).getAppntIDNo());
/*      */         }
/*  276 */         if ((get(i).getInsuredNo() == null) || (get(i).getInsuredNo().equals("null")))
/*  277 */           pstmt.setString(30, null);
/*      */         else {
/*  279 */           pstmt.setString(30, get(i).getInsuredNo());
/*      */         }
/*  281 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/*  282 */           pstmt.setString(31, null);
/*      */         else {
/*  284 */           pstmt.setString(31, get(i).getInsuredId());
/*      */         }
/*  286 */         if ((get(i).getInsuredName() == null) || (get(i).getInsuredName().equals("null")))
/*  287 */           pstmt.setString(32, null);
/*      */         else {
/*  289 */           pstmt.setString(32, get(i).getInsuredName());
/*      */         }
/*  291 */         if ((get(i).getInsuredSex() == null) || (get(i).getInsuredSex().equals("null")))
/*  292 */           pstmt.setString(33, null);
/*      */         else {
/*  294 */           pstmt.setString(33, get(i).getInsuredSex());
/*      */         }
/*  296 */         if ((get(i).getInsuredBirthday() == null) || (get(i).getInsuredBirthday().equals("null")))
/*  297 */           pstmt.setDate(34, null);
/*      */         else {
/*  299 */           pstmt.setDate(34, Date.valueOf(get(i).getInsuredBirthday()));
/*      */         }
/*  301 */         if ((get(i).getInsuredIDType() == null) || (get(i).getInsuredIDType().equals("null")))
/*  302 */           pstmt.setString(35, null);
/*      */         else {
/*  304 */           pstmt.setString(35, get(i).getInsuredIDType());
/*      */         }
/*  306 */         if ((get(i).getInsuredIDNo() == null) || (get(i).getInsuredIDNo().equals("null")))
/*  307 */           pstmt.setString(36, null);
/*      */         else {
/*  309 */           pstmt.setString(36, get(i).getInsuredIDNo());
/*      */         }
/*  311 */         pstmt.setInt(37, get(i).getPayIntv());
/*  312 */         if ((get(i).getPayMode() == null) || (get(i).getPayMode().equals("null")))
/*  313 */           pstmt.setString(38, null);
/*      */         else {
/*  315 */           pstmt.setString(38, get(i).getPayMode());
/*      */         }
/*  317 */         if ((get(i).getPayLocation() == null) || (get(i).getPayLocation().equals("null")))
/*  318 */           pstmt.setString(39, null);
/*      */         else {
/*  320 */           pstmt.setString(39, get(i).getPayLocation());
/*      */         }
/*  322 */         if ((get(i).getDisputedFlag() == null) || (get(i).getDisputedFlag().equals("null")))
/*  323 */           pstmt.setString(40, null);
/*      */         else {
/*  325 */           pstmt.setString(40, get(i).getDisputedFlag());
/*      */         }
/*  327 */         if ((get(i).getOutPayFlag() == null) || (get(i).getOutPayFlag().equals("null")))
/*  328 */           pstmt.setString(41, null);
/*      */         else {
/*  330 */           pstmt.setString(41, get(i).getOutPayFlag());
/*      */         }
/*  332 */         if ((get(i).getGetPolMode() == null) || (get(i).getGetPolMode().equals("null")))
/*  333 */           pstmt.setString(42, null);
/*      */         else {
/*  335 */           pstmt.setString(42, get(i).getGetPolMode());
/*      */         }
/*  337 */         if ((get(i).getSignCom() == null) || (get(i).getSignCom().equals("null")))
/*  338 */           pstmt.setString(43, null);
/*      */         else {
/*  340 */           pstmt.setString(43, get(i).getSignCom());
/*      */         }
/*  342 */         if ((get(i).getSignDate() == null) || (get(i).getSignDate().equals("null")))
/*  343 */           pstmt.setDate(44, null);
/*      */         else {
/*  345 */           pstmt.setDate(44, Date.valueOf(get(i).getSignDate()));
/*      */         }
/*  347 */         if ((get(i).getSignTime() == null) || (get(i).getSignTime().equals("null")))
/*  348 */           pstmt.setString(45, null);
/*      */         else {
/*  350 */           pstmt.setString(45, get(i).getSignTime());
/*      */         }
/*  352 */         if ((get(i).getConsignNo() == null) || (get(i).getConsignNo().equals("null")))
/*  353 */           pstmt.setString(46, null);
/*      */         else {
/*  355 */           pstmt.setString(46, get(i).getConsignNo());
/*      */         }
/*  357 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/*  358 */           pstmt.setString(47, null);
/*      */         else {
/*  360 */           pstmt.setString(47, get(i).getBankCode());
/*      */         }
/*  362 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/*  363 */           pstmt.setString(48, null);
/*      */         else {
/*  365 */           pstmt.setString(48, get(i).getBankAccNo());
/*      */         }
/*  367 */         if ((get(i).getAccName() == null) || (get(i).getAccName().equals("null")))
/*  368 */           pstmt.setString(49, null);
/*      */         else {
/*  370 */           pstmt.setString(49, get(i).getAccName());
/*      */         }
/*  372 */         pstmt.setInt(50, get(i).getPrintCount());
/*  373 */         pstmt.setInt(51, get(i).getLostTimes());
/*  374 */         if ((get(i).getLang() == null) || (get(i).getLang().equals("null")))
/*  375 */           pstmt.setString(52, null);
/*      */         else {
/*  377 */           pstmt.setString(52, get(i).getLang());
/*      */         }
/*  379 */         if ((get(i).getCurrency() == null) || (get(i).getCurrency().equals("null")))
/*  380 */           pstmt.setString(53, null);
/*      */         else {
/*  382 */           pstmt.setString(53, get(i).getCurrency());
/*      */         }
/*  384 */         if ((get(i).getRemark() == null) || (get(i).getRemark().equals("null")))
/*  385 */           pstmt.setString(54, null);
/*      */         else {
/*  387 */           pstmt.setString(54, get(i).getRemark());
/*      */         }
/*  389 */         pstmt.setInt(55, get(i).getPeoples());
/*  390 */         pstmt.setDouble(56, get(i).getMult());
/*  391 */         pstmt.setDouble(57, get(i).getPrem());
/*  392 */         pstmt.setDouble(58, get(i).getAmnt());
/*  393 */         pstmt.setDouble(59, get(i).getSumPrem());
/*  394 */         pstmt.setDouble(60, get(i).getDif());
/*  395 */         if ((get(i).getPaytoDate() == null) || (get(i).getPaytoDate().equals("null")))
/*  396 */           pstmt.setDate(61, null);
/*      */         else {
/*  398 */           pstmt.setDate(61, Date.valueOf(get(i).getPaytoDate()));
/*      */         }
/*  400 */         if ((get(i).getFirstPayDate() == null) || (get(i).getFirstPayDate().equals("null")))
/*  401 */           pstmt.setDate(62, null);
/*      */         else {
/*  403 */           pstmt.setDate(62, Date.valueOf(get(i).getFirstPayDate()));
/*      */         }
/*  405 */         if ((get(i).getCValiDate() == null) || (get(i).getCValiDate().equals("null")))
/*  406 */           pstmt.setDate(63, null);
/*      */         else {
/*  408 */           pstmt.setDate(63, Date.valueOf(get(i).getCValiDate()));
/*      */         }
/*  410 */         if ((get(i).getPSignDate() == null) || (get(i).getPSignDate().equals("null")))
/*  411 */           pstmt.setDate(64, null);
/*      */         else {
/*  413 */           pstmt.setDate(64, Date.valueOf(get(i).getPSignDate()));
/*      */         }
/*  415 */         if ((get(i).getPValiDate() == null) || (get(i).getPValiDate().equals("null")))
/*  416 */           pstmt.setDate(65, null);
/*      */         else {
/*  418 */           pstmt.setDate(65, Date.valueOf(get(i).getPValiDate()));
/*      */         }
/*  420 */         if ((get(i).getInputOperator() == null) || (get(i).getInputOperator().equals("null")))
/*  421 */           pstmt.setString(66, null);
/*      */         else {
/*  423 */           pstmt.setString(66, get(i).getInputOperator());
/*      */         }
/*  425 */         if ((get(i).getInputDate() == null) || (get(i).getInputDate().equals("null")))
/*  426 */           pstmt.setDate(67, null);
/*      */         else {
/*  428 */           pstmt.setDate(67, Date.valueOf(get(i).getInputDate()));
/*      */         }
/*  430 */         if ((get(i).getInputTime() == null) || (get(i).getInputTime().equals("null")))
/*  431 */           pstmt.setString(68, null);
/*      */         else {
/*  433 */           pstmt.setString(68, get(i).getInputTime());
/*      */         }
/*  435 */         if ((get(i).getApproveFlag() == null) || (get(i).getApproveFlag().equals("null")))
/*  436 */           pstmt.setString(69, null);
/*      */         else {
/*  438 */           pstmt.setString(69, get(i).getApproveFlag());
/*      */         }
/*  440 */         if ((get(i).getApproveCode() == null) || (get(i).getApproveCode().equals("null")))
/*  441 */           pstmt.setString(70, null);
/*      */         else {
/*  443 */           pstmt.setString(70, get(i).getApproveCode());
/*      */         }
/*  445 */         if ((get(i).getApproveDate() == null) || (get(i).getApproveDate().equals("null")))
/*  446 */           pstmt.setDate(71, null);
/*      */         else {
/*  448 */           pstmt.setDate(71, Date.valueOf(get(i).getApproveDate()));
/*      */         }
/*  450 */         if ((get(i).getApproveTime() == null) || (get(i).getApproveTime().equals("null")))
/*  451 */           pstmt.setString(72, null);
/*      */         else {
/*  453 */           pstmt.setString(72, get(i).getApproveTime());
/*      */         }
/*  455 */         if ((get(i).getUWFlag() == null) || (get(i).getUWFlag().equals("null")))
/*  456 */           pstmt.setString(73, null);
/*      */         else {
/*  458 */           pstmt.setString(73, get(i).getUWFlag());
/*      */         }
/*  460 */         if ((get(i).getUWOperator() == null) || (get(i).getUWOperator().equals("null")))
/*  461 */           pstmt.setString(74, null);
/*      */         else {
/*  463 */           pstmt.setString(74, get(i).getUWOperator());
/*      */         }
/*  465 */         if ((get(i).getUWDate() == null) || (get(i).getUWDate().equals("null")))
/*  466 */           pstmt.setDate(75, null);
/*      */         else {
/*  468 */           pstmt.setDate(75, Date.valueOf(get(i).getUWDate()));
/*      */         }
/*  470 */         if ((get(i).getUWTime() == null) || (get(i).getUWTime().equals("null")))
/*  471 */           pstmt.setString(76, null);
/*      */         else {
/*  473 */           pstmt.setString(76, get(i).getUWTime());
/*      */         }
/*  475 */         if ((get(i).getAppFlag() == null) || (get(i).getAppFlag().equals("null")))
/*  476 */           pstmt.setString(77, null);
/*      */         else {
/*  478 */           pstmt.setString(77, get(i).getAppFlag());
/*      */         }
/*  480 */         if ((get(i).getPolApplyDate() == null) || (get(i).getPolApplyDate().equals("null")))
/*  481 */           pstmt.setDate(78, null);
/*      */         else {
/*  483 */           pstmt.setDate(78, Date.valueOf(get(i).getPolApplyDate()));
/*      */         }
/*  485 */         if ((get(i).getGetPolDate() == null) || (get(i).getGetPolDate().equals("null")))
/*  486 */           pstmt.setDate(79, null);
/*      */         else {
/*  488 */           pstmt.setDate(79, Date.valueOf(get(i).getGetPolDate()));
/*      */         }
/*  490 */         if ((get(i).getGetPolTime() == null) || (get(i).getGetPolTime().equals("null")))
/*  491 */           pstmt.setString(80, null);
/*      */         else {
/*  493 */           pstmt.setString(80, get(i).getGetPolTime());
/*      */         }
/*  495 */         if ((get(i).getCustomGetPolDate() == null) || (get(i).getCustomGetPolDate().equals("null")))
/*  496 */           pstmt.setDate(81, null);
/*      */         else {
/*  498 */           pstmt.setDate(81, Date.valueOf(get(i).getCustomGetPolDate()));
/*      */         }
/*  500 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/*  501 */           pstmt.setString(82, null);
/*      */         else {
/*  503 */           pstmt.setString(82, get(i).getState());
/*      */         }
/*  505 */         if ((get(i).getSaleChnlDetail() == null) || (get(i).getSaleChnlDetail().equals("null")))
/*  506 */           pstmt.setString(83, null);
/*      */         else {
/*  508 */           pstmt.setString(83, get(i).getSaleChnlDetail());
/*      */         }
/*  510 */         if ((get(i).getProposalType() == null) || (get(i).getProposalType().equals("null")))
/*  511 */           pstmt.setString(84, null);
/*      */         else {
/*  513 */           pstmt.setString(84, get(i).getProposalType());
/*      */         }
/*  515 */         if ((get(i).getEditstate() == null) || (get(i).getEditstate().equals("null")))
/*  516 */           pstmt.setString(85, null);
/*      */         else {
/*  518 */           pstmt.setString(85, get(i).getEditstate());
/*      */         }
/*  520 */         if ((get(i).getCInValiDate() == null) || (get(i).getCInValiDate().equals("null")))
/*  521 */           pstmt.setDate(86, null);
/*      */         else {
/*  523 */           pstmt.setDate(86, Date.valueOf(get(i).getCInValiDate()));
/*      */         }
/*  525 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/*  526 */           pstmt.setString(87, null);
/*      */         else {
/*  528 */           pstmt.setString(87, get(i).getOperator());
/*      */         }
/*  530 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/*  531 */           pstmt.setDate(88, null);
/*      */         else {
/*  533 */           pstmt.setDate(88, Date.valueOf(get(i).getMakeDate()));
/*      */         }
/*  535 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/*  536 */           pstmt.setString(89, null);
/*      */         else {
/*  538 */           pstmt.setString(89, get(i).getMakeTime());
/*      */         }
/*  540 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/*  541 */           pstmt.setDate(90, null);
/*      */         else {
/*  543 */           pstmt.setDate(90, Date.valueOf(get(i).getModifyDate()));
/*      */         }
/*  545 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/*  546 */           pstmt.setString(91, null);
/*      */         else {
/*  548 */           pstmt.setString(91, get(i).getModifyTime());
/*      */         }
/*      */ 
/*  551 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  552 */           pstmt.setString(92, null);
/*      */         else {
/*  554 */           pstmt.setString(92, get(i).getContNo());
/*      */         }
/*  556 */         pstmt.addBatch();
/*      */       }
/*  558 */       pstmt.executeBatch();
/*  559 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  562 */       ex.printStackTrace();
/*  563 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  564 */       CError tError = new CError();
/*  565 */       tError.moduleName = "LNPContDBSet";
/*  566 */       tError.functionName = "update()";
/*  567 */       tError.errorMessage = ex.toString();
/*  568 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  571 */         pstmt.close(); } catch (Exception e) {
/*  572 */         e.printStackTrace();
/*      */       }
/*  574 */       if (!this.mflag) {
/*      */         try {
/*  576 */           this.con.close(); } catch (Exception e) {
/*  577 */           e.printStackTrace();
/*      */         }
/*      */       }
/*  580 */       return false;
/*      */     }
/*      */ 
/*  583 */     if (!this.mflag) {
/*      */       try {
/*  585 */         this.con.close(); } catch (Exception e) {
/*  586 */         e.printStackTrace();
/*      */       }
/*      */     }
/*  589 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  595 */     PreparedStatement pstmt = null;
/*      */ 
/*  597 */     if (!this.mflag) {
/*  598 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  603 */       int tCount = size();
/*  604 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCont VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  605 */       for (int i = 1; i <= tCount; i++)
/*      */       {
/*  607 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/*  608 */           pstmt.setString(1, null);
/*      */         else {
/*  610 */           pstmt.setString(1, get(i).getGrpContNo());
/*      */         }
/*  612 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  613 */           pstmt.setString(2, null);
/*      */         else {
/*  615 */           pstmt.setString(2, get(i).getContNo());
/*      */         }
/*  617 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/*  618 */           pstmt.setString(3, null);
/*      */         else {
/*  620 */           pstmt.setString(3, get(i).getProposalContNo());
/*      */         }
/*  622 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/*  623 */           pstmt.setString(4, null);
/*      */         else {
/*  625 */           pstmt.setString(4, get(i).getPrtNo());
/*      */         }
/*  627 */         if ((get(i).getMainPolNo() == null) || (get(i).getMainPolNo().equals("null")))
/*  628 */           pstmt.setString(5, null);
/*      */         else {
/*  630 */           pstmt.setString(5, get(i).getMainPolNo());
/*      */         }
/*  632 */         if ((get(i).getContType() == null) || (get(i).getContType().equals("null")))
/*  633 */           pstmt.setString(6, null);
/*      */         else {
/*  635 */           pstmt.setString(6, get(i).getContType());
/*      */         }
/*  637 */         if ((get(i).getFamilyType() == null) || (get(i).getFamilyType().equals("null")))
/*  638 */           pstmt.setString(7, null);
/*      */         else {
/*  640 */           pstmt.setString(7, get(i).getFamilyType());
/*      */         }
/*  642 */         if ((get(i).getFamilyID() == null) || (get(i).getFamilyID().equals("null")))
/*  643 */           pstmt.setString(8, null);
/*      */         else {
/*  645 */           pstmt.setString(8, get(i).getFamilyID());
/*      */         }
/*  647 */         if ((get(i).getPolType() == null) || (get(i).getPolType().equals("null")))
/*  648 */           pstmt.setString(9, null);
/*      */         else {
/*  650 */           pstmt.setString(9, get(i).getPolType());
/*      */         }
/*  652 */         if ((get(i).getSugNo() == null) || (get(i).getSugNo().equals("null")))
/*  653 */           pstmt.setString(10, null);
/*      */         else {
/*  655 */           pstmt.setString(10, get(i).getSugNo());
/*      */         }
/*  657 */         if ((get(i).getCardFlag() == null) || (get(i).getCardFlag().equals("null")))
/*  658 */           pstmt.setString(11, null);
/*      */         else {
/*  660 */           pstmt.setString(11, get(i).getCardFlag());
/*      */         }
/*  662 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/*  663 */           pstmt.setString(12, null);
/*      */         else {
/*  665 */           pstmt.setString(12, get(i).getManageCom());
/*      */         }
/*  667 */         if ((get(i).getExecuteCom() == null) || (get(i).getExecuteCom().equals("null")))
/*  668 */           pstmt.setString(13, null);
/*      */         else {
/*  670 */           pstmt.setString(13, get(i).getExecuteCom());
/*      */         }
/*  672 */         if ((get(i).getAgentCom() == null) || (get(i).getAgentCom().equals("null")))
/*  673 */           pstmt.setString(14, null);
/*      */         else {
/*  675 */           pstmt.setString(14, get(i).getAgentCom());
/*      */         }
/*  677 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*  678 */           pstmt.setString(15, null);
/*      */         else {
/*  680 */           pstmt.setString(15, get(i).getAgentCode());
/*      */         }
/*  682 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/*  683 */           pstmt.setString(16, null);
/*      */         else {
/*  685 */           pstmt.setString(16, get(i).getAgentGroup());
/*      */         }
/*  687 */         if ((get(i).getAgentCode1() == null) || (get(i).getAgentCode1().equals("null")))
/*  688 */           pstmt.setString(17, null);
/*      */         else {
/*  690 */           pstmt.setString(17, get(i).getAgentCode1());
/*      */         }
/*  692 */         if ((get(i).getAgentGroup1() == null) || (get(i).getAgentGroup1().equals("null")))
/*  693 */           pstmt.setString(18, null);
/*      */         else {
/*  695 */           pstmt.setString(18, get(i).getAgentGroup1());
/*      */         }
/*  697 */         if ((get(i).getAgentType() == null) || (get(i).getAgentType().equals("null")))
/*  698 */           pstmt.setString(19, null);
/*      */         else {
/*  700 */           pstmt.setString(19, get(i).getAgentType());
/*      */         }
/*  702 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/*  703 */           pstmt.setString(20, null);
/*      */         else {
/*  705 */           pstmt.setString(20, get(i).getSaleChnl());
/*      */         }
/*  707 */         if ((get(i).getHandler() == null) || (get(i).getHandler().equals("null")))
/*  708 */           pstmt.setString(21, null);
/*      */         else {
/*  710 */           pstmt.setString(21, get(i).getHandler());
/*      */         }
/*  712 */         if ((get(i).getPassword() == null) || (get(i).getPassword().equals("null")))
/*  713 */           pstmt.setString(22, null);
/*      */         else {
/*  715 */           pstmt.setString(22, get(i).getPassword());
/*      */         }
/*  717 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/*  718 */           pstmt.setString(23, null);
/*      */         else {
/*  720 */           pstmt.setString(23, get(i).getAppntNo());
/*      */         }
/*  722 */         if ((get(i).getAppntId() == null) || (get(i).getAppntId().equals("null")))
/*  723 */           pstmt.setString(24, null);
/*      */         else {
/*  725 */           pstmt.setString(24, get(i).getAppntId());
/*      */         }
/*  727 */         if ((get(i).getAppntName() == null) || (get(i).getAppntName().equals("null")))
/*  728 */           pstmt.setString(25, null);
/*      */         else {
/*  730 */           pstmt.setString(25, get(i).getAppntName());
/*      */         }
/*  732 */         if ((get(i).getAppntSex() == null) || (get(i).getAppntSex().equals("null")))
/*  733 */           pstmt.setString(26, null);
/*      */         else {
/*  735 */           pstmt.setString(26, get(i).getAppntSex());
/*      */         }
/*  737 */         if ((get(i).getAppntBirthday() == null) || (get(i).getAppntBirthday().equals("null")))
/*  738 */           pstmt.setDate(27, null);
/*      */         else {
/*  740 */           pstmt.setDate(27, Date.valueOf(get(i).getAppntBirthday()));
/*      */         }
/*  742 */         if ((get(i).getAppntIDType() == null) || (get(i).getAppntIDType().equals("null")))
/*  743 */           pstmt.setString(28, null);
/*      */         else {
/*  745 */           pstmt.setString(28, get(i).getAppntIDType());
/*      */         }
/*  747 */         if ((get(i).getAppntIDNo() == null) || (get(i).getAppntIDNo().equals("null")))
/*  748 */           pstmt.setString(29, null);
/*      */         else {
/*  750 */           pstmt.setString(29, get(i).getAppntIDNo());
/*      */         }
/*  752 */         if ((get(i).getInsuredNo() == null) || (get(i).getInsuredNo().equals("null")))
/*  753 */           pstmt.setString(30, null);
/*      */         else {
/*  755 */           pstmt.setString(30, get(i).getInsuredNo());
/*      */         }
/*  757 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/*  758 */           pstmt.setString(31, null);
/*      */         else {
/*  760 */           pstmt.setString(31, get(i).getInsuredId());
/*      */         }
/*  762 */         if ((get(i).getInsuredName() == null) || (get(i).getInsuredName().equals("null")))
/*  763 */           pstmt.setString(32, null);
/*      */         else {
/*  765 */           pstmt.setString(32, get(i).getInsuredName());
/*      */         }
/*  767 */         if ((get(i).getInsuredSex() == null) || (get(i).getInsuredSex().equals("null")))
/*  768 */           pstmt.setString(33, null);
/*      */         else {
/*  770 */           pstmt.setString(33, get(i).getInsuredSex());
/*      */         }
/*  772 */         if ((get(i).getInsuredBirthday() == null) || (get(i).getInsuredBirthday().equals("null")))
/*  773 */           pstmt.setDate(34, null);
/*      */         else {
/*  775 */           pstmt.setDate(34, Date.valueOf(get(i).getInsuredBirthday()));
/*      */         }
/*  777 */         if ((get(i).getInsuredIDType() == null) || (get(i).getInsuredIDType().equals("null")))
/*  778 */           pstmt.setString(35, null);
/*      */         else {
/*  780 */           pstmt.setString(35, get(i).getInsuredIDType());
/*      */         }
/*  782 */         if ((get(i).getInsuredIDNo() == null) || (get(i).getInsuredIDNo().equals("null")))
/*  783 */           pstmt.setString(36, null);
/*      */         else {
/*  785 */           pstmt.setString(36, get(i).getInsuredIDNo());
/*      */         }
/*  787 */         pstmt.setInt(37, get(i).getPayIntv());
/*  788 */         if ((get(i).getPayMode() == null) || (get(i).getPayMode().equals("null")))
/*  789 */           pstmt.setString(38, null);
/*      */         else {
/*  791 */           pstmt.setString(38, get(i).getPayMode());
/*      */         }
/*  793 */         if ((get(i).getPayLocation() == null) || (get(i).getPayLocation().equals("null")))
/*  794 */           pstmt.setString(39, null);
/*      */         else {
/*  796 */           pstmt.setString(39, get(i).getPayLocation());
/*      */         }
/*  798 */         if ((get(i).getDisputedFlag() == null) || (get(i).getDisputedFlag().equals("null")))
/*  799 */           pstmt.setString(40, null);
/*      */         else {
/*  801 */           pstmt.setString(40, get(i).getDisputedFlag());
/*      */         }
/*  803 */         if ((get(i).getOutPayFlag() == null) || (get(i).getOutPayFlag().equals("null")))
/*  804 */           pstmt.setString(41, null);
/*      */         else {
/*  806 */           pstmt.setString(41, get(i).getOutPayFlag());
/*      */         }
/*  808 */         if ((get(i).getGetPolMode() == null) || (get(i).getGetPolMode().equals("null")))
/*  809 */           pstmt.setString(42, null);
/*      */         else {
/*  811 */           pstmt.setString(42, get(i).getGetPolMode());
/*      */         }
/*  813 */         if ((get(i).getSignCom() == null) || (get(i).getSignCom().equals("null")))
/*  814 */           pstmt.setString(43, null);
/*      */         else {
/*  816 */           pstmt.setString(43, get(i).getSignCom());
/*      */         }
/*  818 */         if ((get(i).getSignDate() == null) || (get(i).getSignDate().equals("null")))
/*  819 */           pstmt.setDate(44, null);
/*      */         else {
/*  821 */           pstmt.setDate(44, Date.valueOf(get(i).getSignDate()));
/*      */         }
/*  823 */         if ((get(i).getSignTime() == null) || (get(i).getSignTime().equals("null")))
/*  824 */           pstmt.setString(45, null);
/*      */         else {
/*  826 */           pstmt.setString(45, get(i).getSignTime());
/*      */         }
/*  828 */         if ((get(i).getConsignNo() == null) || (get(i).getConsignNo().equals("null")))
/*  829 */           pstmt.setString(46, null);
/*      */         else {
/*  831 */           pstmt.setString(46, get(i).getConsignNo());
/*      */         }
/*  833 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/*  834 */           pstmt.setString(47, null);
/*      */         else {
/*  836 */           pstmt.setString(47, get(i).getBankCode());
/*      */         }
/*  838 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/*  839 */           pstmt.setString(48, null);
/*      */         else {
/*  841 */           pstmt.setString(48, get(i).getBankAccNo());
/*      */         }
/*  843 */         if ((get(i).getAccName() == null) || (get(i).getAccName().equals("null")))
/*  844 */           pstmt.setString(49, null);
/*      */         else {
/*  846 */           pstmt.setString(49, get(i).getAccName());
/*      */         }
/*  848 */         pstmt.setInt(50, get(i).getPrintCount());
/*  849 */         pstmt.setInt(51, get(i).getLostTimes());
/*  850 */         if ((get(i).getLang() == null) || (get(i).getLang().equals("null")))
/*  851 */           pstmt.setString(52, null);
/*      */         else {
/*  853 */           pstmt.setString(52, get(i).getLang());
/*      */         }
/*  855 */         if ((get(i).getCurrency() == null) || (get(i).getCurrency().equals("null")))
/*  856 */           pstmt.setString(53, null);
/*      */         else {
/*  858 */           pstmt.setString(53, get(i).getCurrency());
/*      */         }
/*  860 */         if ((get(i).getRemark() == null) || (get(i).getRemark().equals("null")))
/*  861 */           pstmt.setString(54, null);
/*      */         else {
/*  863 */           pstmt.setString(54, get(i).getRemark());
/*      */         }
/*  865 */         pstmt.setInt(55, get(i).getPeoples());
/*  866 */         pstmt.setDouble(56, get(i).getMult());
/*  867 */         pstmt.setDouble(57, get(i).getPrem());
/*  868 */         pstmt.setDouble(58, get(i).getAmnt());
/*  869 */         pstmt.setDouble(59, get(i).getSumPrem());
/*  870 */         pstmt.setDouble(60, get(i).getDif());
/*  871 */         if ((get(i).getPaytoDate() == null) || (get(i).getPaytoDate().equals("null")))
/*  872 */           pstmt.setDate(61, null);
/*      */         else {
/*  874 */           pstmt.setDate(61, Date.valueOf(get(i).getPaytoDate()));
/*      */         }
/*  876 */         if ((get(i).getFirstPayDate() == null) || (get(i).getFirstPayDate().equals("null")))
/*  877 */           pstmt.setDate(62, null);
/*      */         else {
/*  879 */           pstmt.setDate(62, Date.valueOf(get(i).getFirstPayDate()));
/*      */         }
/*  881 */         if ((get(i).getCValiDate() == null) || (get(i).getCValiDate().equals("null")))
/*  882 */           pstmt.setDate(63, null);
/*      */         else {
/*  884 */           pstmt.setDate(63, Date.valueOf(get(i).getCValiDate()));
/*      */         }
/*  886 */         if ((get(i).getPSignDate() == null) || (get(i).getPSignDate().equals("null")))
/*  887 */           pstmt.setDate(64, null);
/*      */         else {
/*  889 */           pstmt.setDate(64, Date.valueOf(get(i).getPSignDate()));
/*      */         }
/*  891 */         if ((get(i).getPValiDate() == null) || (get(i).getPValiDate().equals("null")))
/*  892 */           pstmt.setDate(65, null);
/*      */         else {
/*  894 */           pstmt.setDate(65, Date.valueOf(get(i).getPValiDate()));
/*      */         }
/*  896 */         if ((get(i).getInputOperator() == null) || (get(i).getInputOperator().equals("null")))
/*  897 */           pstmt.setString(66, null);
/*      */         else {
/*  899 */           pstmt.setString(66, get(i).getInputOperator());
/*      */         }
/*  901 */         if ((get(i).getInputDate() == null) || (get(i).getInputDate().equals("null")))
/*  902 */           pstmt.setDate(67, null);
/*      */         else {
/*  904 */           pstmt.setDate(67, Date.valueOf(get(i).getInputDate()));
/*      */         }
/*  906 */         if ((get(i).getInputTime() == null) || (get(i).getInputTime().equals("null")))
/*  907 */           pstmt.setString(68, null);
/*      */         else {
/*  909 */           pstmt.setString(68, get(i).getInputTime());
/*      */         }
/*  911 */         if ((get(i).getApproveFlag() == null) || (get(i).getApproveFlag().equals("null")))
/*  912 */           pstmt.setString(69, null);
/*      */         else {
/*  914 */           pstmt.setString(69, get(i).getApproveFlag());
/*      */         }
/*  916 */         if ((get(i).getApproveCode() == null) || (get(i).getApproveCode().equals("null")))
/*  917 */           pstmt.setString(70, null);
/*      */         else {
/*  919 */           pstmt.setString(70, get(i).getApproveCode());
/*      */         }
/*  921 */         if ((get(i).getApproveDate() == null) || (get(i).getApproveDate().equals("null")))
/*  922 */           pstmt.setDate(71, null);
/*      */         else {
/*  924 */           pstmt.setDate(71, Date.valueOf(get(i).getApproveDate()));
/*      */         }
/*  926 */         if ((get(i).getApproveTime() == null) || (get(i).getApproveTime().equals("null")))
/*  927 */           pstmt.setString(72, null);
/*      */         else {
/*  929 */           pstmt.setString(72, get(i).getApproveTime());
/*      */         }
/*  931 */         if ((get(i).getUWFlag() == null) || (get(i).getUWFlag().equals("null")))
/*  932 */           pstmt.setString(73, null);
/*      */         else {
/*  934 */           pstmt.setString(73, get(i).getUWFlag());
/*      */         }
/*  936 */         if ((get(i).getUWOperator() == null) || (get(i).getUWOperator().equals("null")))
/*  937 */           pstmt.setString(74, null);
/*      */         else {
/*  939 */           pstmt.setString(74, get(i).getUWOperator());
/*      */         }
/*  941 */         if ((get(i).getUWDate() == null) || (get(i).getUWDate().equals("null")))
/*  942 */           pstmt.setDate(75, null);
/*      */         else {
/*  944 */           pstmt.setDate(75, Date.valueOf(get(i).getUWDate()));
/*      */         }
/*  946 */         if ((get(i).getUWTime() == null) || (get(i).getUWTime().equals("null")))
/*  947 */           pstmt.setString(76, null);
/*      */         else {
/*  949 */           pstmt.setString(76, get(i).getUWTime());
/*      */         }
/*  951 */         if ((get(i).getAppFlag() == null) || (get(i).getAppFlag().equals("null")))
/*  952 */           pstmt.setString(77, null);
/*      */         else {
/*  954 */           pstmt.setString(77, get(i).getAppFlag());
/*      */         }
/*  956 */         if ((get(i).getPolApplyDate() == null) || (get(i).getPolApplyDate().equals("null")))
/*  957 */           pstmt.setDate(78, null);
/*      */         else {
/*  959 */           pstmt.setDate(78, Date.valueOf(get(i).getPolApplyDate()));
/*      */         }
/*  961 */         if ((get(i).getGetPolDate() == null) || (get(i).getGetPolDate().equals("null")))
/*  962 */           pstmt.setDate(79, null);
/*      */         else {
/*  964 */           pstmt.setDate(79, Date.valueOf(get(i).getGetPolDate()));
/*      */         }
/*  966 */         if ((get(i).getGetPolTime() == null) || (get(i).getGetPolTime().equals("null")))
/*  967 */           pstmt.setString(80, null);
/*      */         else {
/*  969 */           pstmt.setString(80, get(i).getGetPolTime());
/*      */         }
/*  971 */         if ((get(i).getCustomGetPolDate() == null) || (get(i).getCustomGetPolDate().equals("null")))
/*  972 */           pstmt.setDate(81, null);
/*      */         else {
/*  974 */           pstmt.setDate(81, Date.valueOf(get(i).getCustomGetPolDate()));
/*      */         }
/*  976 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/*  977 */           pstmt.setString(82, null);
/*      */         else {
/*  979 */           pstmt.setString(82, get(i).getState());
/*      */         }
/*  981 */         if ((get(i).getSaleChnlDetail() == null) || (get(i).getSaleChnlDetail().equals("null")))
/*  982 */           pstmt.setString(83, null);
/*      */         else {
/*  984 */           pstmt.setString(83, get(i).getSaleChnlDetail());
/*      */         }
/*  986 */         if ((get(i).getProposalType() == null) || (get(i).getProposalType().equals("null")))
/*  987 */           pstmt.setString(84, null);
/*      */         else {
/*  989 */           pstmt.setString(84, get(i).getProposalType());
/*      */         }
/*  991 */         if ((get(i).getEditstate() == null) || (get(i).getEditstate().equals("null")))
/*  992 */           pstmt.setString(85, null);
/*      */         else {
/*  994 */           pstmt.setString(85, get(i).getEditstate());
/*      */         }
/*  996 */         if ((get(i).getCInValiDate() == null) || (get(i).getCInValiDate().equals("null")))
/*  997 */           pstmt.setDate(86, null);
/*      */         else {
/*  999 */           pstmt.setDate(86, Date.valueOf(get(i).getCInValiDate()));
/*      */         }
/* 1001 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 1002 */           pstmt.setString(87, null);
/*      */         else {
/* 1004 */           pstmt.setString(87, get(i).getOperator());
/*      */         }
/* 1006 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 1007 */           pstmt.setDate(88, null);
/*      */         else {
/* 1009 */           pstmt.setDate(88, Date.valueOf(get(i).getMakeDate()));
/*      */         }
/* 1011 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 1012 */           pstmt.setString(89, null);
/*      */         else {
/* 1014 */           pstmt.setString(89, get(i).getMakeTime());
/*      */         }
/* 1016 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 1017 */           pstmt.setDate(90, null);
/*      */         else {
/* 1019 */           pstmt.setDate(90, Date.valueOf(get(i).getModifyDate()));
/*      */         }
/* 1021 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 1022 */           pstmt.setString(91, null);
/*      */         else {
/* 1024 */           pstmt.setString(91, get(i).getModifyTime());
/*      */         }
/* 1026 */         pstmt.addBatch();
/*      */       }
/* 1028 */       pstmt.executeBatch();
/* 1029 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/* 1032 */       ex.printStackTrace();
/* 1033 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 1034 */       CError tError = new CError();
/* 1035 */       tError.moduleName = "LNPContDBSet";
/* 1036 */       tError.functionName = "insert()";
/* 1037 */       tError.errorMessage = ex.toString();
/* 1038 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1041 */         pstmt.close(); } catch (Exception e) {
/* 1042 */         e.printStackTrace();
/*      */       }
/* 1044 */       if (!this.mflag) {
/*      */         try {
/* 1046 */           this.con.close(); } catch (Exception e) {
/* 1047 */           e.printStackTrace();
/*      */         }
/*      */       }
/* 1050 */       return false;
/*      */     }
/*      */ 
/* 1053 */     if (!this.mflag) {
/*      */       try {
/* 1055 */         this.con.close(); } catch (Exception e) {
/* 1056 */         e.printStackTrace();
/*      */       }
/*      */     }
/* 1059 */     return true;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPContDBSet
 * JD-Core Version:    0.6.0
 */