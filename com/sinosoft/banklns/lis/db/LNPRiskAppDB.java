/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskAppSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskAppSet;
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
/*      */ public class LNPRiskAppDB extends LNPRiskAppSchema
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
/*      */   public LNPRiskAppDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPRiskApp");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPRiskAppDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPRiskApp");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPRiskAppSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPRiskAppDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPRiskAppSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPRiskAppDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskApp WHERE  RiskCode = ?");
/*   97 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPRiskAppDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskApp SET  RiskCode = ? , RiskVer = ? , RiskName = ? , KindCode = ? , RiskType = ? , RiskType1 = ? , RiskType2 = ? , RiskProp = ? , RiskPeriod = ? , RiskTypeDetail = ? , RiskFlag = ? , PolType = ? , InvestFlag = ? , BonusFlag = ? , BonusMode = ? , ListFlag = ? , SubRiskFlag = ? , CalDigital = ? , CalChoMode = ? , RiskAmntMult = ? , InsuPeriodFlag = ? , MaxEndPeriod = ? , AgeLmt = ? , SignDateCalMode = ? , ProtocolFlag = ? , GetChgFlag = ? , ProtocolPayFlag = ? , EnsuPlanFlag = ? , EnsuPlanAdjFlag = ? , StartDate = ? , EndDate = ? , MinAppntAge = ? , MaxAppntAge = ? , MaxInsuredAge = ? , MinInsuredAge = ? , AppInterest = ? , AppPremRate = ? , InsuredFlag = ? , ShareFlag = ? , BnfFlag = ? , TempPayFlag = ? , InpPayPlan = ? , ImpartFlag = ? , InsuExpeFlag = ? , LoanFalg = ? , MortagageFlag = ? , IDifReturnFlag = ? , CutAmntStopPay = ? , RinsRate = ? , SaleFlag = ? , FileAppFlag = ? , MngCom = ? , AutoPayFlag = ? , NeedPrintHospital = ? , NeedPrintGet = ? , RiskType3 = ? , RiskType4 = ? , RiskType5 = ? , NotPrintPol = ? , NeedGetPolDate = ? , NeedReReadBank = ? , SpecFlag = ? , InterestDifFlag = ? WHERE  RiskCode = ?");
/*  146 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  151 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getRiskVer());
/*      */       }
/*  156 */       if ((getRiskName() == null) || (getRiskName().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getRiskName());
/*      */       }
/*  161 */       if ((getKindCode() == null) || (getKindCode().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getKindCode());
/*      */       }
/*  166 */       if ((getRiskType() == null) || (getRiskType().equals("null")))
/*  167 */         pstmt.setNull(5, 12);
/*      */       else {
/*  169 */         pstmt.setString(5, getRiskType());
/*      */       }
/*  171 */       if ((getRiskType1() == null) || (getRiskType1().equals("null")))
/*  172 */         pstmt.setNull(6, 12);
/*      */       else {
/*  174 */         pstmt.setString(6, getRiskType1());
/*      */       }
/*  176 */       if ((getRiskType2() == null) || (getRiskType2().equals("null")))
/*  177 */         pstmt.setNull(7, 12);
/*      */       else {
/*  179 */         pstmt.setString(7, getRiskType2());
/*      */       }
/*  181 */       if ((getRiskProp() == null) || (getRiskProp().equals("null")))
/*  182 */         pstmt.setNull(8, 12);
/*      */       else {
/*  184 */         pstmt.setString(8, getRiskProp());
/*      */       }
/*  186 */       if ((getRiskPeriod() == null) || (getRiskPeriod().equals("null")))
/*  187 */         pstmt.setNull(9, 12);
/*      */       else {
/*  189 */         pstmt.setString(9, getRiskPeriod());
/*      */       }
/*  191 */       if ((getRiskTypeDetail() == null) || (getRiskTypeDetail().equals("null")))
/*  192 */         pstmt.setNull(10, 12);
/*      */       else {
/*  194 */         pstmt.setString(10, getRiskTypeDetail());
/*      */       }
/*  196 */       if ((getRiskFlag() == null) || (getRiskFlag().equals("null")))
/*  197 */         pstmt.setNull(11, 12);
/*      */       else {
/*  199 */         pstmt.setString(11, getRiskFlag());
/*      */       }
/*  201 */       if ((getPolType() == null) || (getPolType().equals("null")))
/*  202 */         pstmt.setNull(12, 12);
/*      */       else {
/*  204 */         pstmt.setString(12, getPolType());
/*      */       }
/*  206 */       if ((getInvestFlag() == null) || (getInvestFlag().equals("null")))
/*  207 */         pstmt.setNull(13, 12);
/*      */       else {
/*  209 */         pstmt.setString(13, getInvestFlag());
/*      */       }
/*  211 */       if ((getBonusFlag() == null) || (getBonusFlag().equals("null")))
/*  212 */         pstmt.setNull(14, 12);
/*      */       else {
/*  214 */         pstmt.setString(14, getBonusFlag());
/*      */       }
/*  216 */       if ((getBonusMode() == null) || (getBonusMode().equals("null")))
/*  217 */         pstmt.setNull(15, 12);
/*      */       else {
/*  219 */         pstmt.setString(15, getBonusMode());
/*      */       }
/*  221 */       if ((getListFlag() == null) || (getListFlag().equals("null")))
/*  222 */         pstmt.setNull(16, 12);
/*      */       else {
/*  224 */         pstmt.setString(16, getListFlag());
/*      */       }
/*  226 */       if ((getSubRiskFlag() == null) || (getSubRiskFlag().equals("null")))
/*  227 */         pstmt.setNull(17, 12);
/*      */       else {
/*  229 */         pstmt.setString(17, getSubRiskFlag());
/*      */       }
/*  231 */       pstmt.setInt(18, getCalDigital());
/*  232 */       if ((getCalChoMode() == null) || (getCalChoMode().equals("null")))
/*  233 */         pstmt.setNull(19, 12);
/*      */       else {
/*  235 */         pstmt.setString(19, getCalChoMode());
/*      */       }
/*  237 */       pstmt.setInt(20, getRiskAmntMult());
/*  238 */       if ((getInsuPeriodFlag() == null) || (getInsuPeriodFlag().equals("null")))
/*  239 */         pstmt.setNull(21, 12);
/*      */       else {
/*  241 */         pstmt.setString(21, getInsuPeriodFlag());
/*      */       }
/*  243 */       pstmt.setInt(22, getMaxEndPeriod());
/*  244 */       pstmt.setInt(23, getAgeLmt());
/*  245 */       pstmt.setInt(24, getSignDateCalMode());
/*  246 */       if ((getProtocolFlag() == null) || (getProtocolFlag().equals("null")))
/*  247 */         pstmt.setNull(25, 12);
/*      */       else {
/*  249 */         pstmt.setString(25, getProtocolFlag());
/*      */       }
/*  251 */       if ((getGetChgFlag() == null) || (getGetChgFlag().equals("null")))
/*  252 */         pstmt.setNull(26, 12);
/*      */       else {
/*  254 */         pstmt.setString(26, getGetChgFlag());
/*      */       }
/*  256 */       if ((getProtocolPayFlag() == null) || (getProtocolPayFlag().equals("null")))
/*  257 */         pstmt.setNull(27, 12);
/*      */       else {
/*  259 */         pstmt.setString(27, getProtocolPayFlag());
/*      */       }
/*  261 */       if ((getEnsuPlanFlag() == null) || (getEnsuPlanFlag().equals("null")))
/*  262 */         pstmt.setNull(28, 12);
/*      */       else {
/*  264 */         pstmt.setString(28, getEnsuPlanFlag());
/*      */       }
/*  266 */       if ((getEnsuPlanAdjFlag() == null) || (getEnsuPlanAdjFlag().equals("null")))
/*  267 */         pstmt.setNull(29, 12);
/*      */       else {
/*  269 */         pstmt.setString(29, getEnsuPlanAdjFlag());
/*      */       }
/*  271 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  272 */         pstmt.setNull(30, 91);
/*      */       else {
/*  274 */         pstmt.setDate(30, Date.valueOf(getStartDate()));
/*      */       }
/*  276 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  277 */         pstmt.setNull(31, 91);
/*      */       else {
/*  279 */         pstmt.setDate(31, Date.valueOf(getEndDate()));
/*      */       }
/*  281 */       pstmt.setInt(32, getMinAppntAge());
/*  282 */       pstmt.setInt(33, getMaxAppntAge());
/*  283 */       pstmt.setInt(34, getMaxInsuredAge());
/*  284 */       pstmt.setInt(35, getMinInsuredAge());
/*  285 */       pstmt.setDouble(36, getAppInterest());
/*  286 */       pstmt.setDouble(37, getAppPremRate());
/*  287 */       if ((getInsuredFlag() == null) || (getInsuredFlag().equals("null")))
/*  288 */         pstmt.setNull(38, 12);
/*      */       else {
/*  290 */         pstmt.setString(38, getInsuredFlag());
/*      */       }
/*  292 */       if ((getShareFlag() == null) || (getShareFlag().equals("null")))
/*  293 */         pstmt.setNull(39, 12);
/*      */       else {
/*  295 */         pstmt.setString(39, getShareFlag());
/*      */       }
/*  297 */       if ((getBnfFlag() == null) || (getBnfFlag().equals("null")))
/*  298 */         pstmt.setNull(40, 12);
/*      */       else {
/*  300 */         pstmt.setString(40, getBnfFlag());
/*      */       }
/*  302 */       if ((getTempPayFlag() == null) || (getTempPayFlag().equals("null")))
/*  303 */         pstmt.setNull(41, 12);
/*      */       else {
/*  305 */         pstmt.setString(41, getTempPayFlag());
/*      */       }
/*  307 */       if ((getInpPayPlan() == null) || (getInpPayPlan().equals("null")))
/*  308 */         pstmt.setNull(42, 12);
/*      */       else {
/*  310 */         pstmt.setString(42, getInpPayPlan());
/*      */       }
/*  312 */       if ((getImpartFlag() == null) || (getImpartFlag().equals("null")))
/*  313 */         pstmt.setNull(43, 12);
/*      */       else {
/*  315 */         pstmt.setString(43, getImpartFlag());
/*      */       }
/*  317 */       if ((getInsuExpeFlag() == null) || (getInsuExpeFlag().equals("null")))
/*  318 */         pstmt.setNull(44, 12);
/*      */       else {
/*  320 */         pstmt.setString(44, getInsuExpeFlag());
/*      */       }
/*  322 */       if ((getLoanFalg() == null) || (getLoanFalg().equals("null")))
/*  323 */         pstmt.setNull(45, 12);
/*      */       else {
/*  325 */         pstmt.setString(45, getLoanFalg());
/*      */       }
/*  327 */       if ((getMortagageFlag() == null) || (getMortagageFlag().equals("null")))
/*  328 */         pstmt.setNull(46, 12);
/*      */       else {
/*  330 */         pstmt.setString(46, getMortagageFlag());
/*      */       }
/*  332 */       if ((getIDifReturnFlag() == null) || (getIDifReturnFlag().equals("null")))
/*  333 */         pstmt.setNull(47, 12);
/*      */       else {
/*  335 */         pstmt.setString(47, getIDifReturnFlag());
/*      */       }
/*  337 */       if ((getCutAmntStopPay() == null) || (getCutAmntStopPay().equals("null")))
/*  338 */         pstmt.setNull(48, 12);
/*      */       else {
/*  340 */         pstmt.setString(48, getCutAmntStopPay());
/*      */       }
/*  342 */       pstmt.setDouble(49, getRinsRate());
/*  343 */       if ((getSaleFlag() == null) || (getSaleFlag().equals("null")))
/*  344 */         pstmt.setNull(50, 12);
/*      */       else {
/*  346 */         pstmt.setString(50, getSaleFlag());
/*      */       }
/*  348 */       if ((getFileAppFlag() == null) || (getFileAppFlag().equals("null")))
/*  349 */         pstmt.setNull(51, 12);
/*      */       else {
/*  351 */         pstmt.setString(51, getFileAppFlag());
/*      */       }
/*  353 */       if ((getMngCom() == null) || (getMngCom().equals("null")))
/*  354 */         pstmt.setNull(52, 12);
/*      */       else {
/*  356 */         pstmt.setString(52, getMngCom());
/*      */       }
/*  358 */       if ((getAutoPayFlag() == null) || (getAutoPayFlag().equals("null")))
/*  359 */         pstmt.setNull(53, 12);
/*      */       else {
/*  361 */         pstmt.setString(53, getAutoPayFlag());
/*      */       }
/*  363 */       if ((getNeedPrintHospital() == null) || (getNeedPrintHospital().equals("null")))
/*  364 */         pstmt.setNull(54, 12);
/*      */       else {
/*  366 */         pstmt.setString(54, getNeedPrintHospital());
/*      */       }
/*  368 */       if ((getNeedPrintGet() == null) || (getNeedPrintGet().equals("null")))
/*  369 */         pstmt.setNull(55, 12);
/*      */       else {
/*  371 */         pstmt.setString(55, getNeedPrintGet());
/*      */       }
/*  373 */       if ((getRiskType3() == null) || (getRiskType3().equals("null")))
/*  374 */         pstmt.setNull(56, 12);
/*      */       else {
/*  376 */         pstmt.setString(56, getRiskType3());
/*      */       }
/*  378 */       if ((getRiskType4() == null) || (getRiskType4().equals("null")))
/*  379 */         pstmt.setNull(57, 12);
/*      */       else {
/*  381 */         pstmt.setString(57, getRiskType4());
/*      */       }
/*  383 */       if ((getRiskType5() == null) || (getRiskType5().equals("null")))
/*  384 */         pstmt.setNull(58, 12);
/*      */       else {
/*  386 */         pstmt.setString(58, getRiskType5());
/*      */       }
/*  388 */       if ((getNotPrintPol() == null) || (getNotPrintPol().equals("null")))
/*  389 */         pstmt.setNull(59, 12);
/*      */       else {
/*  391 */         pstmt.setString(59, getNotPrintPol());
/*      */       }
/*  393 */       if ((getNeedGetPolDate() == null) || (getNeedGetPolDate().equals("null")))
/*  394 */         pstmt.setNull(60, 12);
/*      */       else {
/*  396 */         pstmt.setString(60, getNeedGetPolDate());
/*      */       }
/*  398 */       if ((getNeedReReadBank() == null) || (getNeedReReadBank().equals("null")))
/*  399 */         pstmt.setNull(61, 12);
/*      */       else {
/*  401 */         pstmt.setString(61, getNeedReReadBank());
/*      */       }
/*  403 */       if ((getSpecFlag() == null) || (getSpecFlag().equals("null")))
/*  404 */         pstmt.setNull(62, 12);
/*      */       else {
/*  406 */         pstmt.setString(62, getSpecFlag());
/*      */       }
/*  408 */       if ((getInterestDifFlag() == null) || (getInterestDifFlag().equals("null")))
/*  409 */         pstmt.setNull(63, 12);
/*      */       else {
/*  411 */         pstmt.setString(63, getInterestDifFlag());
/*      */       }
/*      */ 
/*  414 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  415 */         pstmt.setNull(64, 12);
/*      */       else {
/*  417 */         pstmt.setString(64, getRiskCode());
/*      */       }
/*  419 */       pstmt.executeUpdate();
/*  420 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  423 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  424 */       CError tError = new CError();
/*  425 */       tError.moduleName = "LNPRiskAppDB";
/*  426 */       tError.functionName = "update()";
/*  427 */       tError.errorMessage = ex.toString();
/*  428 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  431 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  434 */       if (!this.mflag)
/*      */         try {
/*  436 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  440 */       return false;
/*      */     }
/*      */ 
/*  443 */     if (!this.mflag)
/*      */       try {
/*  445 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  449 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  454 */     PreparedStatement pstmt = null;
/*      */ 
/*  456 */     if (!this.mflag) {
/*  457 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  462 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskApp VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  463 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  464 */         pstmt.setNull(1, 12);
/*      */       else {
/*  466 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  468 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/*  469 */         pstmt.setNull(2, 12);
/*      */       else {
/*  471 */         pstmt.setString(2, getRiskVer());
/*      */       }
/*  473 */       if ((getRiskName() == null) || (getRiskName().equals("null")))
/*  474 */         pstmt.setNull(3, 12);
/*      */       else {
/*  476 */         pstmt.setString(3, getRiskName());
/*      */       }
/*  478 */       if ((getKindCode() == null) || (getKindCode().equals("null")))
/*  479 */         pstmt.setNull(4, 12);
/*      */       else {
/*  481 */         pstmt.setString(4, getKindCode());
/*      */       }
/*  483 */       if ((getRiskType() == null) || (getRiskType().equals("null")))
/*  484 */         pstmt.setNull(5, 12);
/*      */       else {
/*  486 */         pstmt.setString(5, getRiskType());
/*      */       }
/*  488 */       if ((getRiskType1() == null) || (getRiskType1().equals("null")))
/*  489 */         pstmt.setNull(6, 12);
/*      */       else {
/*  491 */         pstmt.setString(6, getRiskType1());
/*      */       }
/*  493 */       if ((getRiskType2() == null) || (getRiskType2().equals("null")))
/*  494 */         pstmt.setNull(7, 12);
/*      */       else {
/*  496 */         pstmt.setString(7, getRiskType2());
/*      */       }
/*  498 */       if ((getRiskProp() == null) || (getRiskProp().equals("null")))
/*  499 */         pstmt.setNull(8, 12);
/*      */       else {
/*  501 */         pstmt.setString(8, getRiskProp());
/*      */       }
/*  503 */       if ((getRiskPeriod() == null) || (getRiskPeriod().equals("null")))
/*  504 */         pstmt.setNull(9, 12);
/*      */       else {
/*  506 */         pstmt.setString(9, getRiskPeriod());
/*      */       }
/*  508 */       if ((getRiskTypeDetail() == null) || (getRiskTypeDetail().equals("null")))
/*  509 */         pstmt.setNull(10, 12);
/*      */       else {
/*  511 */         pstmt.setString(10, getRiskTypeDetail());
/*      */       }
/*  513 */       if ((getRiskFlag() == null) || (getRiskFlag().equals("null")))
/*  514 */         pstmt.setNull(11, 12);
/*      */       else {
/*  516 */         pstmt.setString(11, getRiskFlag());
/*      */       }
/*  518 */       if ((getPolType() == null) || (getPolType().equals("null")))
/*  519 */         pstmt.setNull(12, 12);
/*      */       else {
/*  521 */         pstmt.setString(12, getPolType());
/*      */       }
/*  523 */       if ((getInvestFlag() == null) || (getInvestFlag().equals("null")))
/*  524 */         pstmt.setNull(13, 12);
/*      */       else {
/*  526 */         pstmt.setString(13, getInvestFlag());
/*      */       }
/*  528 */       if ((getBonusFlag() == null) || (getBonusFlag().equals("null")))
/*  529 */         pstmt.setNull(14, 12);
/*      */       else {
/*  531 */         pstmt.setString(14, getBonusFlag());
/*      */       }
/*  533 */       if ((getBonusMode() == null) || (getBonusMode().equals("null")))
/*  534 */         pstmt.setNull(15, 12);
/*      */       else {
/*  536 */         pstmt.setString(15, getBonusMode());
/*      */       }
/*  538 */       if ((getListFlag() == null) || (getListFlag().equals("null")))
/*  539 */         pstmt.setNull(16, 12);
/*      */       else {
/*  541 */         pstmt.setString(16, getListFlag());
/*      */       }
/*  543 */       if ((getSubRiskFlag() == null) || (getSubRiskFlag().equals("null")))
/*  544 */         pstmt.setNull(17, 12);
/*      */       else {
/*  546 */         pstmt.setString(17, getSubRiskFlag());
/*      */       }
/*  548 */       pstmt.setInt(18, getCalDigital());
/*  549 */       if ((getCalChoMode() == null) || (getCalChoMode().equals("null")))
/*  550 */         pstmt.setNull(19, 12);
/*      */       else {
/*  552 */         pstmt.setString(19, getCalChoMode());
/*      */       }
/*  554 */       pstmt.setInt(20, getRiskAmntMult());
/*  555 */       if ((getInsuPeriodFlag() == null) || (getInsuPeriodFlag().equals("null")))
/*  556 */         pstmt.setNull(21, 12);
/*      */       else {
/*  558 */         pstmt.setString(21, getInsuPeriodFlag());
/*      */       }
/*  560 */       pstmt.setInt(22, getMaxEndPeriod());
/*  561 */       pstmt.setInt(23, getAgeLmt());
/*  562 */       pstmt.setInt(24, getSignDateCalMode());
/*  563 */       if ((getProtocolFlag() == null) || (getProtocolFlag().equals("null")))
/*  564 */         pstmt.setNull(25, 12);
/*      */       else {
/*  566 */         pstmt.setString(25, getProtocolFlag());
/*      */       }
/*  568 */       if ((getGetChgFlag() == null) || (getGetChgFlag().equals("null")))
/*  569 */         pstmt.setNull(26, 12);
/*      */       else {
/*  571 */         pstmt.setString(26, getGetChgFlag());
/*      */       }
/*  573 */       if ((getProtocolPayFlag() == null) || (getProtocolPayFlag().equals("null")))
/*  574 */         pstmt.setNull(27, 12);
/*      */       else {
/*  576 */         pstmt.setString(27, getProtocolPayFlag());
/*      */       }
/*  578 */       if ((getEnsuPlanFlag() == null) || (getEnsuPlanFlag().equals("null")))
/*  579 */         pstmt.setNull(28, 12);
/*      */       else {
/*  581 */         pstmt.setString(28, getEnsuPlanFlag());
/*      */       }
/*  583 */       if ((getEnsuPlanAdjFlag() == null) || (getEnsuPlanAdjFlag().equals("null")))
/*  584 */         pstmt.setNull(29, 12);
/*      */       else {
/*  586 */         pstmt.setString(29, getEnsuPlanAdjFlag());
/*      */       }
/*  588 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  589 */         pstmt.setNull(30, 91);
/*      */       else {
/*  591 */         pstmt.setDate(30, Date.valueOf(getStartDate()));
/*      */       }
/*  593 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  594 */         pstmt.setNull(31, 91);
/*      */       else {
/*  596 */         pstmt.setDate(31, Date.valueOf(getEndDate()));
/*      */       }
/*  598 */       pstmt.setInt(32, getMinAppntAge());
/*  599 */       pstmt.setInt(33, getMaxAppntAge());
/*  600 */       pstmt.setInt(34, getMaxInsuredAge());
/*  601 */       pstmt.setInt(35, getMinInsuredAge());
/*  602 */       pstmt.setDouble(36, getAppInterest());
/*  603 */       pstmt.setDouble(37, getAppPremRate());
/*  604 */       if ((getInsuredFlag() == null) || (getInsuredFlag().equals("null")))
/*  605 */         pstmt.setNull(38, 12);
/*      */       else {
/*  607 */         pstmt.setString(38, getInsuredFlag());
/*      */       }
/*  609 */       if ((getShareFlag() == null) || (getShareFlag().equals("null")))
/*  610 */         pstmt.setNull(39, 12);
/*      */       else {
/*  612 */         pstmt.setString(39, getShareFlag());
/*      */       }
/*  614 */       if ((getBnfFlag() == null) || (getBnfFlag().equals("null")))
/*  615 */         pstmt.setNull(40, 12);
/*      */       else {
/*  617 */         pstmt.setString(40, getBnfFlag());
/*      */       }
/*  619 */       if ((getTempPayFlag() == null) || (getTempPayFlag().equals("null")))
/*  620 */         pstmt.setNull(41, 12);
/*      */       else {
/*  622 */         pstmt.setString(41, getTempPayFlag());
/*      */       }
/*  624 */       if ((getInpPayPlan() == null) || (getInpPayPlan().equals("null")))
/*  625 */         pstmt.setNull(42, 12);
/*      */       else {
/*  627 */         pstmt.setString(42, getInpPayPlan());
/*      */       }
/*  629 */       if ((getImpartFlag() == null) || (getImpartFlag().equals("null")))
/*  630 */         pstmt.setNull(43, 12);
/*      */       else {
/*  632 */         pstmt.setString(43, getImpartFlag());
/*      */       }
/*  634 */       if ((getInsuExpeFlag() == null) || (getInsuExpeFlag().equals("null")))
/*  635 */         pstmt.setNull(44, 12);
/*      */       else {
/*  637 */         pstmt.setString(44, getInsuExpeFlag());
/*      */       }
/*  639 */       if ((getLoanFalg() == null) || (getLoanFalg().equals("null")))
/*  640 */         pstmt.setNull(45, 12);
/*      */       else {
/*  642 */         pstmt.setString(45, getLoanFalg());
/*      */       }
/*  644 */       if ((getMortagageFlag() == null) || (getMortagageFlag().equals("null")))
/*  645 */         pstmt.setNull(46, 12);
/*      */       else {
/*  647 */         pstmt.setString(46, getMortagageFlag());
/*      */       }
/*  649 */       if ((getIDifReturnFlag() == null) || (getIDifReturnFlag().equals("null")))
/*  650 */         pstmt.setNull(47, 12);
/*      */       else {
/*  652 */         pstmt.setString(47, getIDifReturnFlag());
/*      */       }
/*  654 */       if ((getCutAmntStopPay() == null) || (getCutAmntStopPay().equals("null")))
/*  655 */         pstmt.setNull(48, 12);
/*      */       else {
/*  657 */         pstmt.setString(48, getCutAmntStopPay());
/*      */       }
/*  659 */       pstmt.setDouble(49, getRinsRate());
/*  660 */       if ((getSaleFlag() == null) || (getSaleFlag().equals("null")))
/*  661 */         pstmt.setNull(50, 12);
/*      */       else {
/*  663 */         pstmt.setString(50, getSaleFlag());
/*      */       }
/*  665 */       if ((getFileAppFlag() == null) || (getFileAppFlag().equals("null")))
/*  666 */         pstmt.setNull(51, 12);
/*      */       else {
/*  668 */         pstmt.setString(51, getFileAppFlag());
/*      */       }
/*  670 */       if ((getMngCom() == null) || (getMngCom().equals("null")))
/*  671 */         pstmt.setNull(52, 12);
/*      */       else {
/*  673 */         pstmt.setString(52, getMngCom());
/*      */       }
/*  675 */       if ((getAutoPayFlag() == null) || (getAutoPayFlag().equals("null")))
/*  676 */         pstmt.setNull(53, 12);
/*      */       else {
/*  678 */         pstmt.setString(53, getAutoPayFlag());
/*      */       }
/*  680 */       if ((getNeedPrintHospital() == null) || (getNeedPrintHospital().equals("null")))
/*  681 */         pstmt.setNull(54, 12);
/*      */       else {
/*  683 */         pstmt.setString(54, getNeedPrintHospital());
/*      */       }
/*  685 */       if ((getNeedPrintGet() == null) || (getNeedPrintGet().equals("null")))
/*  686 */         pstmt.setNull(55, 12);
/*      */       else {
/*  688 */         pstmt.setString(55, getNeedPrintGet());
/*      */       }
/*  690 */       if ((getRiskType3() == null) || (getRiskType3().equals("null")))
/*  691 */         pstmt.setNull(56, 12);
/*      */       else {
/*  693 */         pstmt.setString(56, getRiskType3());
/*      */       }
/*  695 */       if ((getRiskType4() == null) || (getRiskType4().equals("null")))
/*  696 */         pstmt.setNull(57, 12);
/*      */       else {
/*  698 */         pstmt.setString(57, getRiskType4());
/*      */       }
/*  700 */       if ((getRiskType5() == null) || (getRiskType5().equals("null")))
/*  701 */         pstmt.setNull(58, 12);
/*      */       else {
/*  703 */         pstmt.setString(58, getRiskType5());
/*      */       }
/*  705 */       if ((getNotPrintPol() == null) || (getNotPrintPol().equals("null")))
/*  706 */         pstmt.setNull(59, 12);
/*      */       else {
/*  708 */         pstmt.setString(59, getNotPrintPol());
/*      */       }
/*  710 */       if ((getNeedGetPolDate() == null) || (getNeedGetPolDate().equals("null")))
/*  711 */         pstmt.setNull(60, 12);
/*      */       else {
/*  713 */         pstmt.setString(60, getNeedGetPolDate());
/*      */       }
/*  715 */       if ((getNeedReReadBank() == null) || (getNeedReReadBank().equals("null")))
/*  716 */         pstmt.setNull(61, 12);
/*      */       else {
/*  718 */         pstmt.setString(61, getNeedReReadBank());
/*      */       }
/*  720 */       if ((getSpecFlag() == null) || (getSpecFlag().equals("null")))
/*  721 */         pstmt.setNull(62, 12);
/*      */       else {
/*  723 */         pstmt.setString(62, getSpecFlag());
/*      */       }
/*  725 */       if ((getInterestDifFlag() == null) || (getInterestDifFlag().equals("null")))
/*  726 */         pstmt.setNull(63, 12);
/*      */       else {
/*  728 */         pstmt.setString(63, getInterestDifFlag());
/*      */       }
/*      */ 
/*  731 */       pstmt.executeUpdate();
/*  732 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  735 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  736 */       CError tError = new CError();
/*  737 */       tError.moduleName = "LNPRiskAppDB";
/*  738 */       tError.functionName = "insert()";
/*  739 */       tError.errorMessage = ex.toString();
/*  740 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  743 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  746 */       if (!this.mflag)
/*      */         try {
/*  748 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  752 */       return false;
/*      */     }
/*      */ 
/*  755 */     if (!this.mflag)
/*      */       try {
/*  757 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  761 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  766 */     PreparedStatement pstmt = null;
/*  767 */     ResultSet rs = null;
/*      */ 
/*  769 */     if (!this.mflag) {
/*  770 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  775 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRiskApp WHERE  RiskCode = ?", 
/*  776 */         1003, 1007);
/*  777 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  778 */         pstmt.setNull(1, 12);
/*      */       else {
/*  780 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  782 */       rs = pstmt.executeQuery();
/*  783 */       int i = 0;
/*  784 */       if (rs.next())
/*      */       {
/*  786 */         i++;
/*  787 */         if (!setSchema(rs, i))
/*      */         {
/*  790 */           CError tError = new CError();
/*  791 */           tError.moduleName = "LNPRiskAppDB";
/*  792 */           tError.functionName = "getInfo";
/*  793 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  794 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  796 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  799 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  803 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  807 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  811 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  814 */       if (i == 0)
/*      */       {
/*  816 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  820 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  824 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  830 */       CError tError = new CError();
/*  831 */       tError.moduleName = "LNPRiskAppDB";
/*  832 */       tError.functionName = "getInfo";
/*  833 */       tError.errorMessage = e.toString();
/*  834 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  836 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  839 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  843 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  847 */       return false;
/*      */     }
/*      */ 
/*  850 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  854 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  859 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRiskAppSet query()
/*      */   {
/*  864 */     Statement stmt = null;
/*  865 */     ResultSet rs = null;
/*  866 */     LNPRiskAppSet aLNPRiskAppSet = new LNPRiskAppSet();
/*      */ 
/*  868 */     if (!this.mflag) {
/*  869 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  874 */       stmt = this.con.createStatement(1003, 1007);
/*  875 */       SQLString sqlObj = new SQLString("LNPRiskApp");
/*  876 */       LNPRiskAppSchema aSchema = getSchema();
/*  877 */       sqlObj.setSQL(5, aSchema);
/*  878 */       String sql = sqlObj.getSQL();
/*      */ 
/*  880 */       rs = stmt.executeQuery(sql);
/*  881 */       int i = 0;
/*  882 */       while (rs.next())
/*      */       {
/*  884 */         i++;
/*  885 */         LNPRiskAppSchema s1 = new LNPRiskAppSchema();
/*  886 */         s1.setSchema(rs, i);
/*  887 */         aLNPRiskAppSet.add(s1);
/*      */       }try {
/*  889 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  895 */       CError tError = new CError();
/*  896 */       tError.moduleName = "LNPRiskAppDB";
/*  897 */       tError.functionName = "query";
/*  898 */       tError.errorMessage = e.toString();
/*  899 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  901 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  904 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  908 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  914 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  918 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  923 */     return aLNPRiskAppSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskAppSet executeQuery(String sql)
/*      */   {
/*  928 */     Statement stmt = null;
/*  929 */     ResultSet rs = null;
/*  930 */     LNPRiskAppSet aLNPRiskAppSet = new LNPRiskAppSet();
/*      */ 
/*  932 */     if (!this.mflag) {
/*  933 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  938 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  940 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  941 */       int i = 0;
/*  942 */       while (rs.next())
/*      */       {
/*  944 */         i++;
/*  945 */         LNPRiskAppSchema s1 = new LNPRiskAppSchema();
/*  946 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  949 */           CError tError = new CError();
/*  950 */           tError.moduleName = "LNPRiskAppDB";
/*  951 */           tError.functionName = "executeQuery";
/*  952 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  953 */           this.mErrors.addOneError(tError);
/*      */         }
/*  955 */         aLNPRiskAppSet.add(s1);
/*      */       }try {
/*  957 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  963 */       CError tError = new CError();
/*  964 */       tError.moduleName = "LNPRiskAppDB";
/*  965 */       tError.functionName = "executeQuery";
/*  966 */       tError.errorMessage = e.toString();
/*  967 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  969 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  972 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  976 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  982 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  986 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  991 */     return aLNPRiskAppSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskAppSet query(int nStart, int nCount)
/*      */   {
/*  996 */     Statement stmt = null;
/*  997 */     ResultSet rs = null;
/*  998 */     LNPRiskAppSet aLNPRiskAppSet = new LNPRiskAppSet();
/*      */ 
/* 1000 */     if (!this.mflag) {
/* 1001 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1006 */       stmt = this.con.createStatement(1003, 1007);
/* 1007 */       SQLString sqlObj = new SQLString("LNPRiskApp");
/* 1008 */       LNPRiskAppSchema aSchema = getSchema();
/* 1009 */       sqlObj.setSQL(5, aSchema);
/* 1010 */       String sql = sqlObj.getSQL();
/*      */ 
/* 1012 */       rs = stmt.executeQuery(sql);
/* 1013 */       int i = 0;
/* 1014 */       while (rs.next())
/*      */       {
/* 1016 */         i++;
/*      */ 
/* 1018 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1022 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1026 */         LNPRiskAppSchema s1 = new LNPRiskAppSchema();
/* 1027 */         s1.setSchema(rs, i);
/* 1028 */         aLNPRiskAppSet.add(s1);
/*      */       }try {
/* 1030 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1036 */       CError tError = new CError();
/* 1037 */       tError.moduleName = "LNPRiskAppDB";
/* 1038 */       tError.functionName = "query";
/* 1039 */       tError.errorMessage = e.toString();
/* 1040 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1042 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1045 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1049 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1055 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1059 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1064 */     return aLNPRiskAppSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskAppSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/* 1069 */     Statement stmt = null;
/* 1070 */     ResultSet rs = null;
/* 1071 */     LNPRiskAppSet aLNPRiskAppSet = new LNPRiskAppSet();
/*      */ 
/* 1073 */     if (!this.mflag) {
/* 1074 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1079 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1081 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1082 */       int i = 0;
/* 1083 */       while (rs.next())
/*      */       {
/* 1085 */         i++;
/*      */ 
/* 1087 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1091 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1095 */         LNPRiskAppSchema s1 = new LNPRiskAppSchema();
/* 1096 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1099 */           CError tError = new CError();
/* 1100 */           tError.moduleName = "LNPRiskAppDB";
/* 1101 */           tError.functionName = "executeQuery";
/* 1102 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 1103 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1105 */         aLNPRiskAppSet.add(s1);
/*      */       }try {
/* 1107 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1113 */       CError tError = new CError();
/* 1114 */       tError.moduleName = "LNPRiskAppDB";
/* 1115 */       tError.functionName = "executeQuery";
/* 1116 */       tError.errorMessage = e.toString();
/* 1117 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1119 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1122 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1126 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1132 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1136 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1141 */     return aLNPRiskAppSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1146 */     Statement stmt = null;
/*      */ 
/* 1148 */     if (!this.mflag) {
/* 1149 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1154 */       stmt = this.con.createStatement(1003, 1007);
/* 1155 */       SQLString sqlObj = new SQLString("LNPRiskApp");
/* 1156 */       LNPRiskAppSchema aSchema = getSchema();
/* 1157 */       sqlObj.setSQL(2, aSchema);
/* 1158 */       String sql = "update LNPRiskApp " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1160 */       int operCount = stmt.executeUpdate(sql);
/* 1161 */       if (operCount == 0)
/*      */       {
/* 1164 */         CError tError = new CError();
/* 1165 */         tError.moduleName = "LNPRiskAppDB";
/* 1166 */         tError.functionName = "update";
/* 1167 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 1168 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1170 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1174 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1178 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1184 */       CError tError = new CError();
/* 1185 */       tError.moduleName = "LNPRiskAppDB";
/* 1186 */       tError.functionName = "update";
/* 1187 */       tError.errorMessage = e.toString();
/* 1188 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1190 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1192 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1196 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1200 */       return false;
/*      */     }
/*      */ 
/* 1203 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1207 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1212 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1218 */     if (this.mResultSet != null)
/*      */     {
/* 1221 */       CError tError = new CError();
/* 1222 */       tError.moduleName = "LNPRiskAppDB";
/* 1223 */       tError.functionName = "prepareData";
/* 1224 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 1225 */       this.mErrors.addOneError(tError);
/* 1226 */       return false;
/*      */     }
/*      */ 
/* 1229 */     if (!this.mflag)
/*      */     {
/* 1231 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1235 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1236 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1241 */       CError tError = new CError();
/* 1242 */       tError.moduleName = "LNPRiskAppDB";
/* 1243 */       tError.functionName = "prepareData";
/* 1244 */       tError.errorMessage = e.toString();
/* 1245 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1248 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1254 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1258 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1262 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1267 */       return false;
/*      */     }
/*      */ 
/* 1270 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1274 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1279 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1285 */     boolean flag = true;
/* 1286 */     if (this.mResultSet == null)
/*      */     {
/* 1288 */       CError tError = new CError();
/* 1289 */       tError.moduleName = "LNPRiskAppDB";
/* 1290 */       tError.functionName = "hasMoreData";
/* 1291 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1292 */       this.mErrors.addOneError(tError);
/* 1293 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1297 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1301 */       CError tError = new CError();
/* 1302 */       tError.moduleName = "LNPRiskAppDB";
/* 1303 */       tError.functionName = "hasMoreData";
/* 1304 */       tError.errorMessage = ex.toString();
/* 1305 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1308 */         this.mResultSet.close();
/* 1309 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1315 */         this.mStatement.close();
/* 1316 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1320 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1324 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1329 */       return false;
/*      */     }
/* 1331 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPRiskAppSet getData()
/*      */   {
/* 1336 */     int tCount = 0;
/* 1337 */     LNPRiskAppSet tLNPRiskAppSet = new LNPRiskAppSet();
/* 1338 */     LNPRiskAppSchema tLNPRiskAppSchema = null;
/* 1339 */     if (this.mResultSet == null)
/*      */     {
/* 1341 */       CError tError = new CError();
/* 1342 */       tError.moduleName = "LNPRiskAppDB";
/* 1343 */       tError.functionName = "getData";
/* 1344 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1345 */       this.mErrors.addOneError(tError);
/* 1346 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1350 */       tCount = 1;
/* 1351 */       tLNPRiskAppSchema = new LNPRiskAppSchema();
/* 1352 */       tLNPRiskAppSchema.setSchema(this.mResultSet, 1);
/* 1353 */       tLNPRiskAppSet.add(tLNPRiskAppSchema);
/*      */ 
/* 1355 */       while (tCount++ < 5000)
/*      */       {
/* 1357 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1359 */         tLNPRiskAppSchema = new LNPRiskAppSchema();
/* 1360 */         tLNPRiskAppSchema.setSchema(this.mResultSet, 1);
/* 1361 */         tLNPRiskAppSet.add(tLNPRiskAppSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1367 */       CError tError = new CError();
/* 1368 */       tError.moduleName = "LNPRiskAppDB";
/* 1369 */       tError.functionName = "getData";
/* 1370 */       tError.errorMessage = ex.toString();
/* 1371 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1374 */         this.mResultSet.close();
/* 1375 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1381 */         this.mStatement.close();
/* 1382 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1386 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1390 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1395 */       return null;
/*      */     }
/* 1397 */     return tLNPRiskAppSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1402 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1405 */       if (this.mResultSet == null)
/*      */       {
/* 1407 */         CError tError = new CError();
/* 1408 */         tError.moduleName = "LNPRiskAppDB";
/* 1409 */         tError.functionName = "closeData";
/* 1410 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1411 */         this.mErrors.addOneError(tError);
/* 1412 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1416 */         this.mResultSet.close();
/* 1417 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1422 */       CError tError = new CError();
/* 1423 */       tError.moduleName = "LNPRiskAppDB";
/* 1424 */       tError.functionName = "closeData";
/* 1425 */       tError.errorMessage = ex2.toString();
/* 1426 */       this.mErrors.addOneError(tError);
/* 1427 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1431 */       if (this.mStatement == null)
/*      */       {
/* 1433 */         CError tError = new CError();
/* 1434 */         tError.moduleName = "LNPRiskAppDB";
/* 1435 */         tError.functionName = "closeData";
/* 1436 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1437 */         this.mErrors.addOneError(tError);
/* 1438 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1442 */         this.mStatement.close();
/* 1443 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1448 */       CError tError = new CError();
/* 1449 */       tError.moduleName = "LNPRiskAppDB";
/* 1450 */       tError.functionName = "closeData";
/* 1451 */       tError.errorMessage = ex3.toString();
/* 1452 */       this.mErrors.addOneError(tError);
/* 1453 */       flag = false;
/*      */     }
/* 1455 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskAppDB
 * JD-Core Version:    0.6.0
 */