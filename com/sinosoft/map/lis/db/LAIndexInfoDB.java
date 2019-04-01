/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.LAIndexInfoSchema;
/*      */ import com.sinosoft.map.lis.vschema.LAIndexInfoSet;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.DBConnPool;
/*      */ import com.sinosoft.map.utility.DBOper;
/*      */ import com.sinosoft.map.utility.SQLString;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class LAIndexInfoDB extends LAIndexInfoSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*   23 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   26 */   private ResultSet mResultSet = null;
/*   27 */   private Statement mStatement = null;
/*      */ 
/*      */   public LAIndexInfoDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "LAIndexInfo");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("LAIndexInfo");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     LAIndexInfoSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "LAIndexInfoDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     LAIndexInfoSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "LAIndexInfoDB";
/*   75 */       tError.functionName = "getCount";
/*   76 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   77 */       this.mErrors.addOneError(tError);
/*      */ 
/*   79 */       return -1;
/*      */     }
/*      */ 
/*   82 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   87 */     PreparedStatement pstmt = null;
/*      */ 
/*   89 */     if (!this.mflag) {
/*   90 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM LAIndexInfo WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
/*   96 */       if ((getIndexCalNo() == null) || (getIndexCalNo().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getIndexCalNo());
/*      */       }
/*  101 */       if ((getIndexType() == null) || (getIndexType().equals("null")))
/*  102 */         pstmt.setNull(2, 12);
/*      */       else {
/*  104 */         pstmt.setString(2, getIndexType());
/*      */       }
/*  106 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  107 */         pstmt.setNull(3, 12);
/*      */       else {
/*  109 */         pstmt.setString(3, getAgentCode());
/*      */       }
/*  111 */       pstmt.executeUpdate();
/*  112 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  115 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  116 */       CError tError = new CError();
/*  117 */       tError.moduleName = "LAIndexInfoDB";
/*  118 */       tError.functionName = "delete()";
/*  119 */       tError.errorMessage = ex.toString();
/*  120 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  123 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  126 */       if (!this.mflag)
/*      */         try {
/*  128 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  132 */       return false;
/*      */     }
/*      */ 
/*  135 */     if (!this.mflag)
/*      */       try {
/*  137 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  141 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  146 */     PreparedStatement pstmt = null;
/*      */ 
/*  148 */     if (!this.mflag) {
/*  149 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  154 */       pstmt = this.con.prepareStatement("UPDATE LAIndexInfo SET  IndexCalNo = ? , IndexType = ? , AgentCode = ? , AgentGroup = ? , ManageCom = ? , StartDate = ? , StartEnd = ? , QuaBgnMark = ? , ServerMonths = ? , PostMonths = ? , IndMonthFYC = ? , IndMonthSYC = ? , IndMonSignFYC = ? , IndMonSignAFYC = ? , IndMonSignNAFYC = ? , GrpMonSignNAFYC = ? , MonPolCnt = ? , MontCustCnt = ? , IndMonPCount = ? , SMmonPolContin = ? , SMmonProduct = ? , SMworkMon = ? , MonPCount = ? , WSMMonPCount = ? , LPMonForSMMP = ? , LPMonForAMMP = ? , LPpolContinute = ? , MonEligFLPCnt = ? , TSRmonAFYP = ? , TSRmonDedAFYP = ? , TSRmonCompAFYP = ? , TSRMonWorkDays = ? , MonManPower = ? , MonManCount = ? , MonSAFYPSum = ? , MonTLGrpSAFYPSum = ? , IndYearNAFYC = ? , B12IndEffectAFYC = ? , B12IndAllAFYC = ? , B24IndEffectAFYC = ? , B24IndAllAFYC = ? , IndQutFYC = ? , LPproductivity = ? , LPPPRate = ? , LPPPBonus = ? , LPFincSubsidy = ? , SubsidyRate = ? , B12TeamNAFYC = ? , SMOverride = ? , TeamMonAvgPCount = ? , SMBasicSalary = ? , SMproductivity = ? , SMpolContinute = ? , SMPPRate = ? , SMPPBonus = ? , B24TeamEffectAFYC = ? , B24TeamAllAFYC = ? , TeamQutPremSum = ? , SMRRBonus = ? , SMManPowerDBonus = ? , LPB12ForMPDBonus = ? , SMUsualALLCSum = ? , AMBasicSalary = ? , AMproductivity = ? , AMpolContinute = ? , AMPPRate = ? , AMPPBonus = ? , B12DepNAFYC = ? , AMOverride = ? , DepMonAvgPCount = ? , DepQutPremSum = ? , AMRRBonus = ? , AMManPowerDBonus = ? , ProductGrowth = ? , DepQuaFYCSum = ? , AMLiability = ? , ReviOpen = ? , T1 = ? , T2 = ? , T3 = ? , T4 = ? , T5 = ? , T6 = ? , T7 = ? , T8 = ? , T9 = ? , T10 = ? , T11 = ? , T12 = ? , T13 = ? , T14 = ? , T15 = ? , T16 = ? , T17 = ? , T18 = ? , T20 = ? , T19 = ? , MonthIndex = ? , TMonthIndex = ? , ASumIndex = ? , WSMMonthEligible = ? , LPQuaPCount = ? , LPQuaFYCSum = ? , B12LPPCount = ? , B12LPNAFYCSum = ? , WSMMonAFYC = ? , WSMTwoMonAFYC = ? , WSMB6AFYC = ? , WSMB6PCount = ? , NetLiveLPCount = ? , NetComLPCount = ? , WSMTwoMonPCount = ? , LPAllNAFYC = ? , LPAllPCount = ? , MonPerSAFYP = ? , TSRThrMonSAFYP = ? , TLThrMonPerSAFYP = ? , MonSubsistCnt = ? , ThrMonSubsistCnt = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , AssessMonth = ? , BranchAttr = ? , AgentGrade = ? , ClubPromBonus = ? , ClubGradeBonus = ? , ClubAssisBonus = ? , ClubSpecBonus = ? , AdddedMoney = ? , LastMoney = ? , ShouldMoney = ? , BusinessTax = ? , EduTax = ? , BuildTax = ? , BusiCharge = ? , IncomeTax = ? , SumMoney = ? , AfterTaxMoney = ? , OperInCome = ? , T21 = ? , T22 = ? , T23 = ? , T24 = ? , T25 = ? WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
/*  155 */       if ((getIndexCalNo() == null) || (getIndexCalNo().equals("null")))
/*  156 */         pstmt.setNull(1, 12);
/*      */       else {
/*  158 */         pstmt.setString(1, getIndexCalNo());
/*      */       }
/*  160 */       if ((getIndexType() == null) || (getIndexType().equals("null")))
/*  161 */         pstmt.setNull(2, 12);
/*      */       else {
/*  163 */         pstmt.setString(2, getIndexType());
/*      */       }
/*  165 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  166 */         pstmt.setNull(3, 12);
/*      */       else {
/*  168 */         pstmt.setString(3, getAgentCode());
/*      */       }
/*  170 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  171 */         pstmt.setNull(4, 12);
/*      */       else {
/*  173 */         pstmt.setString(4, getAgentGroup());
/*      */       }
/*  175 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  176 */         pstmt.setNull(5, 12);
/*      */       else {
/*  178 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  180 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  181 */         pstmt.setNull(6, 91);
/*      */       else {
/*  183 */         pstmt.setDate(6, Date.valueOf(getStartDate()));
/*      */       }
/*  185 */       if ((getStartEnd() == null) || (getStartEnd().equals("null")))
/*  186 */         pstmt.setNull(7, 91);
/*      */       else {
/*  188 */         pstmt.setDate(7, Date.valueOf(getStartEnd()));
/*      */       }
/*  190 */       pstmt.setInt(8, getQuaBgnMark());
/*  191 */       pstmt.setInt(9, getServerMonths());
/*  192 */       pstmt.setInt(10, getPostMonths());
/*  193 */       pstmt.setDouble(11, getIndMonthFYC());
/*  194 */       pstmt.setDouble(12, getIndMonthSYC());
/*  195 */       pstmt.setDouble(13, getIndMonSignFYC());
/*  196 */       pstmt.setDouble(14, getIndMonSignAFYC());
/*  197 */       pstmt.setDouble(15, getIndMonSignNAFYC());
/*  198 */       pstmt.setDouble(16, getGrpMonSignNAFYC());
/*  199 */       pstmt.setDouble(17, getMonPolCnt());
/*  200 */       pstmt.setDouble(18, getMontCustCnt());
/*  201 */       pstmt.setDouble(19, getIndMonPCount());
/*  202 */       pstmt.setDouble(20, getSMmonPolContin());
/*  203 */       pstmt.setDouble(21, getSMmonProduct());
/*  204 */       pstmt.setDouble(22, getSMworkMon());
/*  205 */       pstmt.setDouble(23, getMonPCount());
/*  206 */       pstmt.setDouble(24, getWSMMonPCount());
/*  207 */       pstmt.setDouble(25, getLPMonForSMMP());
/*  208 */       pstmt.setDouble(26, getLPMonForAMMP());
/*  209 */       pstmt.setDouble(27, getLPpolContinute());
/*  210 */       pstmt.setDouble(28, getMonEligFLPCnt());
/*  211 */       pstmt.setDouble(29, getTSRmonAFYP());
/*  212 */       pstmt.setDouble(30, getTSRmonDedAFYP());
/*  213 */       pstmt.setDouble(31, getTSRmonCompAFYP());
/*  214 */       pstmt.setDouble(32, getTSRMonWorkDays());
/*  215 */       pstmt.setDouble(33, getMonManPower());
/*  216 */       pstmt.setDouble(34, getMonManCount());
/*  217 */       pstmt.setDouble(35, getMonSAFYPSum());
/*  218 */       pstmt.setDouble(36, getMonTLGrpSAFYPSum());
/*  219 */       pstmt.setDouble(37, getIndYearNAFYC());
/*  220 */       pstmt.setDouble(38, getB12IndEffectAFYC());
/*  221 */       pstmt.setDouble(39, getB12IndAllAFYC());
/*  222 */       pstmt.setDouble(40, getB24IndEffectAFYC());
/*  223 */       pstmt.setDouble(41, getB24IndAllAFYC());
/*  224 */       pstmt.setDouble(42, getIndQutFYC());
/*  225 */       pstmt.setDouble(43, getLPproductivity());
/*  226 */       pstmt.setDouble(44, getLPPPRate());
/*  227 */       pstmt.setDouble(45, getLPPPBonus());
/*  228 */       pstmt.setDouble(46, getLPFincSubsidy());
/*  229 */       pstmt.setDouble(47, getSubsidyRate());
/*  230 */       pstmt.setDouble(48, getB12TeamNAFYC());
/*  231 */       pstmt.setDouble(49, getSMOverride());
/*  232 */       pstmt.setDouble(50, getTeamMonAvgPCount());
/*  233 */       pstmt.setDouble(51, getSMBasicSalary());
/*  234 */       pstmt.setDouble(52, getSMproductivity());
/*  235 */       pstmt.setDouble(53, getSMpolContinute());
/*  236 */       pstmt.setDouble(54, getSMPPRate());
/*  237 */       pstmt.setDouble(55, getSMPPBonus());
/*  238 */       pstmt.setDouble(56, getB24TeamEffectAFYC());
/*  239 */       pstmt.setDouble(57, getB24TeamAllAFYC());
/*  240 */       pstmt.setDouble(58, getTeamQutPremSum());
/*  241 */       pstmt.setDouble(59, getSMRRBonus());
/*  242 */       pstmt.setDouble(60, getSMManPowerDBonus());
/*  243 */       pstmt.setDouble(61, getLPB12ForMPDBonus());
/*  244 */       pstmt.setDouble(62, getSMUsualALLCSum());
/*  245 */       pstmt.setDouble(63, getAMBasicSalary());
/*  246 */       pstmt.setDouble(64, getAMproductivity());
/*  247 */       pstmt.setDouble(65, getAMpolContinute());
/*  248 */       pstmt.setDouble(66, getAMPPRate());
/*  249 */       pstmt.setDouble(67, getAMPPBonus());
/*  250 */       pstmt.setDouble(68, getB12DepNAFYC());
/*  251 */       pstmt.setDouble(69, getAMOverride());
/*  252 */       pstmt.setDouble(70, getDepMonAvgPCount());
/*  253 */       pstmt.setDouble(71, getDepQutPremSum());
/*  254 */       pstmt.setDouble(72, getAMRRBonus());
/*  255 */       pstmt.setDouble(73, getAMManPowerDBonus());
/*  256 */       pstmt.setDouble(74, getProductGrowth());
/*  257 */       pstmt.setDouble(75, getDepQuaFYCSum());
/*  258 */       pstmt.setDouble(76, getAMLiability());
/*  259 */       pstmt.setDouble(77, getReviOpen());
/*  260 */       pstmt.setDouble(78, getT1());
/*  261 */       pstmt.setDouble(79, getT2());
/*  262 */       pstmt.setDouble(80, getT3());
/*  263 */       pstmt.setDouble(81, getT4());
/*  264 */       pstmt.setDouble(82, getT5());
/*  265 */       pstmt.setDouble(83, getT6());
/*  266 */       pstmt.setDouble(84, getT7());
/*  267 */       pstmt.setDouble(85, getT8());
/*  268 */       pstmt.setDouble(86, getT9());
/*  269 */       pstmt.setDouble(87, getT10());
/*  270 */       pstmt.setDouble(88, getT11());
/*  271 */       pstmt.setDouble(89, getT12());
/*  272 */       pstmt.setDouble(90, getT13());
/*  273 */       pstmt.setDouble(91, getT14());
/*  274 */       pstmt.setDouble(92, getT15());
/*  275 */       pstmt.setDouble(93, getT16());
/*  276 */       pstmt.setDouble(94, getT17());
/*  277 */       pstmt.setDouble(95, getT18());
/*  278 */       pstmt.setDouble(96, getT20());
/*  279 */       pstmt.setDouble(97, getT19());
/*  280 */       pstmt.setDouble(98, getMonthIndex());
/*  281 */       pstmt.setDouble(99, getTMonthIndex());
/*  282 */       pstmt.setDouble(100, getASumIndex());
/*  283 */       pstmt.setDouble(101, getWSMMonthEligible());
/*  284 */       pstmt.setDouble(102, getLPQuaPCount());
/*  285 */       pstmt.setDouble(103, getLPQuaFYCSum());
/*  286 */       pstmt.setDouble(104, getB12LPPCount());
/*  287 */       pstmt.setDouble(105, getB12LPNAFYCSum());
/*  288 */       pstmt.setDouble(106, getWSMMonAFYC());
/*  289 */       pstmt.setDouble(107, getWSMTwoMonAFYC());
/*  290 */       pstmt.setDouble(108, getWSMB6AFYC());
/*  291 */       pstmt.setDouble(109, getWSMB6PCount());
/*  292 */       pstmt.setDouble(110, getNetLiveLPCount());
/*  293 */       pstmt.setDouble(111, getNetComLPCount());
/*  294 */       pstmt.setDouble(112, getWSMTwoMonPCount());
/*  295 */       pstmt.setDouble(113, getLPAllNAFYC());
/*  296 */       pstmt.setDouble(114, getLPAllPCount());
/*  297 */       pstmt.setDouble(115, getMonPerSAFYP());
/*  298 */       pstmt.setDouble(116, getTSRThrMonSAFYP());
/*  299 */       pstmt.setDouble(117, getTLThrMonPerSAFYP());
/*  300 */       pstmt.setDouble(118, getMonSubsistCnt());
/*  301 */       pstmt.setDouble(119, getThrMonSubsistCnt());
/*  302 */       if ((getState() == null) || (getState().equals("null")))
/*  303 */         pstmt.setNull(120, 12);
/*      */       else {
/*  305 */         pstmt.setString(120, getState());
/*      */       }
/*  307 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  308 */         pstmt.setNull(121, 12);
/*      */       else {
/*  310 */         pstmt.setString(121, getOperator());
/*      */       }
/*  312 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  313 */         pstmt.setNull(122, 91);
/*      */       else {
/*  315 */         pstmt.setDate(122, Date.valueOf(getMakeDate()));
/*      */       }
/*  317 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  318 */         pstmt.setNull(123, 12);
/*      */       else {
/*  320 */         pstmt.setString(123, getMakeTime());
/*      */       }
/*  322 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  323 */         pstmt.setNull(124, 91);
/*      */       else {
/*  325 */         pstmt.setDate(124, Date.valueOf(getModifyDate()));
/*      */       }
/*  327 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  328 */         pstmt.setNull(125, 12);
/*      */       else {
/*  330 */         pstmt.setString(125, getModifyTime());
/*      */       }
/*  332 */       if ((getAssessMonth() == null) || (getAssessMonth().equals("null")))
/*  333 */         pstmt.setNull(126, 12);
/*      */       else {
/*  335 */         pstmt.setString(126, getAssessMonth());
/*      */       }
/*  337 */       if ((getBranchAttr() == null) || (getBranchAttr().equals("null")))
/*  338 */         pstmt.setNull(127, 12);
/*      */       else {
/*  340 */         pstmt.setString(127, getBranchAttr());
/*      */       }
/*  342 */       if ((getAgentGrade() == null) || (getAgentGrade().equals("null")))
/*  343 */         pstmt.setNull(128, 12);
/*      */       else {
/*  345 */         pstmt.setString(128, getAgentGrade());
/*      */       }
/*  347 */       pstmt.setDouble(129, getClubPromBonus());
/*  348 */       pstmt.setDouble(130, getClubGradeBonus());
/*  349 */       pstmt.setDouble(131, getClubAssisBonus());
/*  350 */       pstmt.setDouble(132, getClubSpecBonus());
/*  351 */       pstmt.setDouble(133, getAdddedMoney());
/*  352 */       pstmt.setDouble(134, getLastMoney());
/*  353 */       pstmt.setDouble(135, getShouldMoney());
/*  354 */       pstmt.setDouble(136, getBusinessTax());
/*  355 */       pstmt.setDouble(137, getEduTax());
/*  356 */       pstmt.setDouble(138, getBuildTax());
/*  357 */       pstmt.setDouble(139, getBusiCharge());
/*  358 */       pstmt.setDouble(140, getIncomeTax());
/*  359 */       pstmt.setDouble(141, getSumMoney());
/*  360 */       pstmt.setDouble(142, getAfterTaxMoney());
/*  361 */       pstmt.setDouble(143, getOperInCome());
/*  362 */       pstmt.setDouble(144, getT21());
/*  363 */       pstmt.setDouble(145, getT22());
/*  364 */       pstmt.setDouble(146, getT23());
/*  365 */       pstmt.setDouble(147, getT24());
/*  366 */       pstmt.setDouble(148, getT25());
/*      */ 
/*  368 */       if ((getIndexCalNo() == null) || (getIndexCalNo().equals("null")))
/*  369 */         pstmt.setNull(149, 12);
/*      */       else {
/*  371 */         pstmt.setString(149, getIndexCalNo());
/*      */       }
/*  373 */       if ((getIndexType() == null) || (getIndexType().equals("null")))
/*  374 */         pstmt.setNull(150, 12);
/*      */       else {
/*  376 */         pstmt.setString(150, getIndexType());
/*      */       }
/*  378 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  379 */         pstmt.setNull(151, 12);
/*      */       else {
/*  381 */         pstmt.setString(151, getAgentCode());
/*      */       }
/*  383 */       pstmt.executeUpdate();
/*  384 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  387 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  388 */       CError tError = new CError();
/*  389 */       tError.moduleName = "LAIndexInfoDB";
/*  390 */       tError.functionName = "update()";
/*  391 */       tError.errorMessage = ex.toString();
/*  392 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  395 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  398 */       if (!this.mflag)
/*      */         try {
/*  400 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  404 */       return false;
/*      */     }
/*      */ 
/*  407 */     if (!this.mflag)
/*      */       try {
/*  409 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  413 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  418 */     PreparedStatement pstmt = null;
/*      */ 
/*  420 */     if (!this.mflag) {
/*  421 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  426 */       pstmt = this.con.prepareStatement("INSERT INTO LAIndexInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  427 */       if ((getIndexCalNo() == null) || (getIndexCalNo().equals("null")))
/*  428 */         pstmt.setNull(1, 12);
/*      */       else {
/*  430 */         pstmt.setString(1, getIndexCalNo());
/*      */       }
/*  432 */       if ((getIndexType() == null) || (getIndexType().equals("null")))
/*  433 */         pstmt.setNull(2, 12);
/*      */       else {
/*  435 */         pstmt.setString(2, getIndexType());
/*      */       }
/*  437 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  438 */         pstmt.setNull(3, 12);
/*      */       else {
/*  440 */         pstmt.setString(3, getAgentCode());
/*      */       }
/*  442 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  443 */         pstmt.setNull(4, 12);
/*      */       else {
/*  445 */         pstmt.setString(4, getAgentGroup());
/*      */       }
/*  447 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  448 */         pstmt.setNull(5, 12);
/*      */       else {
/*  450 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  452 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  453 */         pstmt.setNull(6, 91);
/*      */       else {
/*  455 */         pstmt.setDate(6, Date.valueOf(getStartDate()));
/*      */       }
/*  457 */       if ((getStartEnd() == null) || (getStartEnd().equals("null")))
/*  458 */         pstmt.setNull(7, 91);
/*      */       else {
/*  460 */         pstmt.setDate(7, Date.valueOf(getStartEnd()));
/*      */       }
/*  462 */       pstmt.setInt(8, getQuaBgnMark());
/*  463 */       pstmt.setInt(9, getServerMonths());
/*  464 */       pstmt.setInt(10, getPostMonths());
/*  465 */       pstmt.setDouble(11, getIndMonthFYC());
/*  466 */       pstmt.setDouble(12, getIndMonthSYC());
/*  467 */       pstmt.setDouble(13, getIndMonSignFYC());
/*  468 */       pstmt.setDouble(14, getIndMonSignAFYC());
/*  469 */       pstmt.setDouble(15, getIndMonSignNAFYC());
/*  470 */       pstmt.setDouble(16, getGrpMonSignNAFYC());
/*  471 */       pstmt.setDouble(17, getMonPolCnt());
/*  472 */       pstmt.setDouble(18, getMontCustCnt());
/*  473 */       pstmt.setDouble(19, getIndMonPCount());
/*  474 */       pstmt.setDouble(20, getSMmonPolContin());
/*  475 */       pstmt.setDouble(21, getSMmonProduct());
/*  476 */       pstmt.setDouble(22, getSMworkMon());
/*  477 */       pstmt.setDouble(23, getMonPCount());
/*  478 */       pstmt.setDouble(24, getWSMMonPCount());
/*  479 */       pstmt.setDouble(25, getLPMonForSMMP());
/*  480 */       pstmt.setDouble(26, getLPMonForAMMP());
/*  481 */       pstmt.setDouble(27, getLPpolContinute());
/*  482 */       pstmt.setDouble(28, getMonEligFLPCnt());
/*  483 */       pstmt.setDouble(29, getTSRmonAFYP());
/*  484 */       pstmt.setDouble(30, getTSRmonDedAFYP());
/*  485 */       pstmt.setDouble(31, getTSRmonCompAFYP());
/*  486 */       pstmt.setDouble(32, getTSRMonWorkDays());
/*  487 */       pstmt.setDouble(33, getMonManPower());
/*  488 */       pstmt.setDouble(34, getMonManCount());
/*  489 */       pstmt.setDouble(35, getMonSAFYPSum());
/*  490 */       pstmt.setDouble(36, getMonTLGrpSAFYPSum());
/*  491 */       pstmt.setDouble(37, getIndYearNAFYC());
/*  492 */       pstmt.setDouble(38, getB12IndEffectAFYC());
/*  493 */       pstmt.setDouble(39, getB12IndAllAFYC());
/*  494 */       pstmt.setDouble(40, getB24IndEffectAFYC());
/*  495 */       pstmt.setDouble(41, getB24IndAllAFYC());
/*  496 */       pstmt.setDouble(42, getIndQutFYC());
/*  497 */       pstmt.setDouble(43, getLPproductivity());
/*  498 */       pstmt.setDouble(44, getLPPPRate());
/*  499 */       pstmt.setDouble(45, getLPPPBonus());
/*  500 */       pstmt.setDouble(46, getLPFincSubsidy());
/*  501 */       pstmt.setDouble(47, getSubsidyRate());
/*  502 */       pstmt.setDouble(48, getB12TeamNAFYC());
/*  503 */       pstmt.setDouble(49, getSMOverride());
/*  504 */       pstmt.setDouble(50, getTeamMonAvgPCount());
/*  505 */       pstmt.setDouble(51, getSMBasicSalary());
/*  506 */       pstmt.setDouble(52, getSMproductivity());
/*  507 */       pstmt.setDouble(53, getSMpolContinute());
/*  508 */       pstmt.setDouble(54, getSMPPRate());
/*  509 */       pstmt.setDouble(55, getSMPPBonus());
/*  510 */       pstmt.setDouble(56, getB24TeamEffectAFYC());
/*  511 */       pstmt.setDouble(57, getB24TeamAllAFYC());
/*  512 */       pstmt.setDouble(58, getTeamQutPremSum());
/*  513 */       pstmt.setDouble(59, getSMRRBonus());
/*  514 */       pstmt.setDouble(60, getSMManPowerDBonus());
/*  515 */       pstmt.setDouble(61, getLPB12ForMPDBonus());
/*  516 */       pstmt.setDouble(62, getSMUsualALLCSum());
/*  517 */       pstmt.setDouble(63, getAMBasicSalary());
/*  518 */       pstmt.setDouble(64, getAMproductivity());
/*  519 */       pstmt.setDouble(65, getAMpolContinute());
/*  520 */       pstmt.setDouble(66, getAMPPRate());
/*  521 */       pstmt.setDouble(67, getAMPPBonus());
/*  522 */       pstmt.setDouble(68, getB12DepNAFYC());
/*  523 */       pstmt.setDouble(69, getAMOverride());
/*  524 */       pstmt.setDouble(70, getDepMonAvgPCount());
/*  525 */       pstmt.setDouble(71, getDepQutPremSum());
/*  526 */       pstmt.setDouble(72, getAMRRBonus());
/*  527 */       pstmt.setDouble(73, getAMManPowerDBonus());
/*  528 */       pstmt.setDouble(74, getProductGrowth());
/*  529 */       pstmt.setDouble(75, getDepQuaFYCSum());
/*  530 */       pstmt.setDouble(76, getAMLiability());
/*  531 */       pstmt.setDouble(77, getReviOpen());
/*  532 */       pstmt.setDouble(78, getT1());
/*  533 */       pstmt.setDouble(79, getT2());
/*  534 */       pstmt.setDouble(80, getT3());
/*  535 */       pstmt.setDouble(81, getT4());
/*  536 */       pstmt.setDouble(82, getT5());
/*  537 */       pstmt.setDouble(83, getT6());
/*  538 */       pstmt.setDouble(84, getT7());
/*  539 */       pstmt.setDouble(85, getT8());
/*  540 */       pstmt.setDouble(86, getT9());
/*  541 */       pstmt.setDouble(87, getT10());
/*  542 */       pstmt.setDouble(88, getT11());
/*  543 */       pstmt.setDouble(89, getT12());
/*  544 */       pstmt.setDouble(90, getT13());
/*  545 */       pstmt.setDouble(91, getT14());
/*  546 */       pstmt.setDouble(92, getT15());
/*  547 */       pstmt.setDouble(93, getT16());
/*  548 */       pstmt.setDouble(94, getT17());
/*  549 */       pstmt.setDouble(95, getT18());
/*  550 */       pstmt.setDouble(96, getT20());
/*  551 */       pstmt.setDouble(97, getT19());
/*  552 */       pstmt.setDouble(98, getMonthIndex());
/*  553 */       pstmt.setDouble(99, getTMonthIndex());
/*  554 */       pstmt.setDouble(100, getASumIndex());
/*  555 */       pstmt.setDouble(101, getWSMMonthEligible());
/*  556 */       pstmt.setDouble(102, getLPQuaPCount());
/*  557 */       pstmt.setDouble(103, getLPQuaFYCSum());
/*  558 */       pstmt.setDouble(104, getB12LPPCount());
/*  559 */       pstmt.setDouble(105, getB12LPNAFYCSum());
/*  560 */       pstmt.setDouble(106, getWSMMonAFYC());
/*  561 */       pstmt.setDouble(107, getWSMTwoMonAFYC());
/*  562 */       pstmt.setDouble(108, getWSMB6AFYC());
/*  563 */       pstmt.setDouble(109, getWSMB6PCount());
/*  564 */       pstmt.setDouble(110, getNetLiveLPCount());
/*  565 */       pstmt.setDouble(111, getNetComLPCount());
/*  566 */       pstmt.setDouble(112, getWSMTwoMonPCount());
/*  567 */       pstmt.setDouble(113, getLPAllNAFYC());
/*  568 */       pstmt.setDouble(114, getLPAllPCount());
/*  569 */       pstmt.setDouble(115, getMonPerSAFYP());
/*  570 */       pstmt.setDouble(116, getTSRThrMonSAFYP());
/*  571 */       pstmt.setDouble(117, getTLThrMonPerSAFYP());
/*  572 */       pstmt.setDouble(118, getMonSubsistCnt());
/*  573 */       pstmt.setDouble(119, getThrMonSubsistCnt());
/*  574 */       if ((getState() == null) || (getState().equals("null")))
/*  575 */         pstmt.setNull(120, 12);
/*      */       else {
/*  577 */         pstmt.setString(120, getState());
/*      */       }
/*  579 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  580 */         pstmt.setNull(121, 12);
/*      */       else {
/*  582 */         pstmt.setString(121, getOperator());
/*      */       }
/*  584 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  585 */         pstmt.setNull(122, 91);
/*      */       else {
/*  587 */         pstmt.setDate(122, Date.valueOf(getMakeDate()));
/*      */       }
/*  589 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  590 */         pstmt.setNull(123, 12);
/*      */       else {
/*  592 */         pstmt.setString(123, getMakeTime());
/*      */       }
/*  594 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  595 */         pstmt.setNull(124, 91);
/*      */       else {
/*  597 */         pstmt.setDate(124, Date.valueOf(getModifyDate()));
/*      */       }
/*  599 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  600 */         pstmt.setNull(125, 12);
/*      */       else {
/*  602 */         pstmt.setString(125, getModifyTime());
/*      */       }
/*  604 */       if ((getAssessMonth() == null) || (getAssessMonth().equals("null")))
/*  605 */         pstmt.setNull(126, 12);
/*      */       else {
/*  607 */         pstmt.setString(126, getAssessMonth());
/*      */       }
/*  609 */       if ((getBranchAttr() == null) || (getBranchAttr().equals("null")))
/*  610 */         pstmt.setNull(127, 12);
/*      */       else {
/*  612 */         pstmt.setString(127, getBranchAttr());
/*      */       }
/*  614 */       if ((getAgentGrade() == null) || (getAgentGrade().equals("null")))
/*  615 */         pstmt.setNull(128, 12);
/*      */       else {
/*  617 */         pstmt.setString(128, getAgentGrade());
/*      */       }
/*  619 */       pstmt.setDouble(129, getClubPromBonus());
/*  620 */       pstmt.setDouble(130, getClubGradeBonus());
/*  621 */       pstmt.setDouble(131, getClubAssisBonus());
/*  622 */       pstmt.setDouble(132, getClubSpecBonus());
/*  623 */       pstmt.setDouble(133, getAdddedMoney());
/*  624 */       pstmt.setDouble(134, getLastMoney());
/*  625 */       pstmt.setDouble(135, getShouldMoney());
/*  626 */       pstmt.setDouble(136, getBusinessTax());
/*  627 */       pstmt.setDouble(137, getEduTax());
/*  628 */       pstmt.setDouble(138, getBuildTax());
/*  629 */       pstmt.setDouble(139, getBusiCharge());
/*  630 */       pstmt.setDouble(140, getIncomeTax());
/*  631 */       pstmt.setDouble(141, getSumMoney());
/*  632 */       pstmt.setDouble(142, getAfterTaxMoney());
/*  633 */       pstmt.setDouble(143, getOperInCome());
/*  634 */       pstmt.setDouble(144, getT21());
/*  635 */       pstmt.setDouble(145, getT22());
/*  636 */       pstmt.setDouble(146, getT23());
/*  637 */       pstmt.setDouble(147, getT24());
/*  638 */       pstmt.setDouble(148, getT25());
/*      */ 
/*  640 */       pstmt.executeUpdate();
/*  641 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  644 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  645 */       CError tError = new CError();
/*  646 */       tError.moduleName = "LAIndexInfoDB";
/*  647 */       tError.functionName = "insert()";
/*  648 */       tError.errorMessage = ex.toString();
/*  649 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  652 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  655 */       if (!this.mflag)
/*      */         try {
/*  657 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  661 */       return false;
/*      */     }
/*      */ 
/*  664 */     if (!this.mflag)
/*      */       try {
/*  666 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  670 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  675 */     PreparedStatement pstmt = null;
/*  676 */     ResultSet rs = null;
/*      */ 
/*  678 */     if (!this.mflag) {
/*  679 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  684 */       pstmt = this.con.prepareStatement("SELECT * FROM LAIndexInfo WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?", 
/*  685 */         1003, 1007);
/*  686 */       if ((getIndexCalNo() == null) || (getIndexCalNo().equals("null")))
/*  687 */         pstmt.setNull(1, 12);
/*      */       else {
/*  689 */         pstmt.setString(1, getIndexCalNo());
/*      */       }
/*  691 */       if ((getIndexType() == null) || (getIndexType().equals("null")))
/*  692 */         pstmt.setNull(2, 12);
/*      */       else {
/*  694 */         pstmt.setString(2, getIndexType());
/*      */       }
/*  696 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  697 */         pstmt.setNull(3, 12);
/*      */       else {
/*  699 */         pstmt.setString(3, getAgentCode());
/*      */       }
/*  701 */       rs = pstmt.executeQuery();
/*  702 */       int i = 0;
/*  703 */       if (rs.next())
/*      */       {
/*  705 */         i++;
/*  706 */         if (!setSchema(rs, i))
/*      */         {
/*  709 */           CError tError = new CError();
/*  710 */           tError.moduleName = "LAIndexInfoDB";
/*  711 */           tError.functionName = "getInfo";
/*  712 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  713 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  715 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  718 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  722 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  726 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  730 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  733 */       if (i == 0)
/*      */       {
/*  735 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  739 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  743 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  749 */       CError tError = new CError();
/*  750 */       tError.moduleName = "LAIndexInfoDB";
/*  751 */       tError.functionName = "getInfo";
/*  752 */       tError.errorMessage = e.toString();
/*  753 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  755 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  758 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  762 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  766 */       return false;
/*      */     }
/*      */ 
/*  769 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  773 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  778 */     return true;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoSet query()
/*      */   {
/*  783 */     Statement stmt = null;
/*  784 */     ResultSet rs = null;
/*  785 */     LAIndexInfoSet aLAIndexInfoSet = new LAIndexInfoSet();
/*      */ 
/*  787 */     if (!this.mflag) {
/*  788 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  793 */       stmt = this.con.createStatement(1003, 1007);
/*  794 */       SQLString sqlObj = new SQLString("LAIndexInfo");
/*  795 */       LAIndexInfoSchema aSchema = getSchema();
/*  796 */       sqlObj.setSQL(5, aSchema);
/*  797 */       String sql = sqlObj.getSQL();
/*      */ 
/*  799 */       rs = stmt.executeQuery(sql);
/*  800 */       int i = 0;
/*  801 */       while (rs.next())
/*      */       {
/*  803 */         i++;
/*  804 */         LAIndexInfoSchema s1 = new LAIndexInfoSchema();
/*  805 */         s1.setSchema(rs, i);
/*  806 */         aLAIndexInfoSet.add(s1);
/*      */       }try {
/*  808 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  814 */       CError tError = new CError();
/*  815 */       tError.moduleName = "LAIndexInfoDB";
/*  816 */       tError.functionName = "query";
/*  817 */       tError.errorMessage = e.toString();
/*  818 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  820 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  823 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  827 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  833 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  837 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  842 */     return aLAIndexInfoSet;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoSet executeQuery(String sql)
/*      */   {
/*  847 */     Statement stmt = null;
/*  848 */     ResultSet rs = null;
/*  849 */     LAIndexInfoSet aLAIndexInfoSet = new LAIndexInfoSet();
/*      */ 
/*  851 */     if (!this.mflag) {
/*  852 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  857 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  859 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  860 */       int i = 0;
/*  861 */       while (rs.next())
/*      */       {
/*  863 */         i++;
/*  864 */         LAIndexInfoSchema s1 = new LAIndexInfoSchema();
/*  865 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  868 */           CError tError = new CError();
/*  869 */           tError.moduleName = "LAIndexInfoDB";
/*  870 */           tError.functionName = "executeQuery";
/*  871 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  872 */           this.mErrors.addOneError(tError);
/*      */         }
/*  874 */         aLAIndexInfoSet.add(s1);
/*      */       }try {
/*  876 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  882 */       CError tError = new CError();
/*  883 */       tError.moduleName = "LAIndexInfoDB";
/*  884 */       tError.functionName = "executeQuery";
/*  885 */       tError.errorMessage = e.toString();
/*  886 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  888 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  891 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  895 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  901 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  905 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  910 */     return aLAIndexInfoSet;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoSet query(int nStart, int nCount)
/*      */   {
/*  915 */     Statement stmt = null;
/*  916 */     ResultSet rs = null;
/*  917 */     LAIndexInfoSet aLAIndexInfoSet = new LAIndexInfoSet();
/*      */ 
/*  919 */     if (!this.mflag) {
/*  920 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  925 */       stmt = this.con.createStatement(1003, 1007);
/*  926 */       SQLString sqlObj = new SQLString("LAIndexInfo");
/*  927 */       LAIndexInfoSchema aSchema = getSchema();
/*  928 */       sqlObj.setSQL(5, aSchema);
/*  929 */       String sql = sqlObj.getSQL();
/*      */ 
/*  931 */       rs = stmt.executeQuery(sql);
/*  932 */       int i = 0;
/*  933 */       while (rs.next())
/*      */       {
/*  935 */         i++;
/*      */ 
/*  937 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  941 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  945 */         LAIndexInfoSchema s1 = new LAIndexInfoSchema();
/*  946 */         s1.setSchema(rs, i);
/*  947 */         aLAIndexInfoSet.add(s1);
/*      */       }try {
/*  949 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  955 */       CError tError = new CError();
/*  956 */       tError.moduleName = "LAIndexInfoDB";
/*  957 */       tError.functionName = "query";
/*  958 */       tError.errorMessage = e.toString();
/*  959 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  961 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  964 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  968 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  974 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  978 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  983 */     return aLAIndexInfoSet;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  988 */     Statement stmt = null;
/*  989 */     ResultSet rs = null;
/*  990 */     LAIndexInfoSet aLAIndexInfoSet = new LAIndexInfoSet();
/*      */ 
/*  992 */     if (!this.mflag) {
/*  993 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  998 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1000 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1001 */       int i = 0;
/* 1002 */       while (rs.next())
/*      */       {
/* 1004 */         i++;
/*      */ 
/* 1006 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1010 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1014 */         LAIndexInfoSchema s1 = new LAIndexInfoSchema();
/* 1015 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1018 */           CError tError = new CError();
/* 1019 */           tError.moduleName = "LAIndexInfoDB";
/* 1020 */           tError.functionName = "executeQuery";
/* 1021 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 1022 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1024 */         aLAIndexInfoSet.add(s1);
/*      */       }try {
/* 1026 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1032 */       CError tError = new CError();
/* 1033 */       tError.moduleName = "LAIndexInfoDB";
/* 1034 */       tError.functionName = "executeQuery";
/* 1035 */       tError.errorMessage = e.toString();
/* 1036 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1038 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1041 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1045 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1051 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1055 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1060 */     return aLAIndexInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1065 */     Statement stmt = null;
/*      */ 
/* 1067 */     if (!this.mflag) {
/* 1068 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1073 */       stmt = this.con.createStatement(1003, 1007);
/* 1074 */       SQLString sqlObj = new SQLString("LAIndexInfo");
/* 1075 */       LAIndexInfoSchema aSchema = getSchema();
/* 1076 */       sqlObj.setSQL(2, aSchema);
/* 1077 */       String sql = "update LAIndexInfo " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1079 */       int operCount = stmt.executeUpdate(sql);
/* 1080 */       if (operCount == 0)
/*      */       {
/* 1083 */         CError tError = new CError();
/* 1084 */         tError.moduleName = "LAIndexInfoDB";
/* 1085 */         tError.functionName = "update";
/* 1086 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/* 1087 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1089 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1093 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1097 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1103 */       CError tError = new CError();
/* 1104 */       tError.moduleName = "LAIndexInfoDB";
/* 1105 */       tError.functionName = "update";
/* 1106 */       tError.errorMessage = e.toString();
/* 1107 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1109 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1111 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1115 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1119 */       return false;
/*      */     }
/*      */ 
/* 1122 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1126 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1131 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1137 */     if (this.mResultSet != null)
/*      */     {
/* 1140 */       CError tError = new CError();
/* 1141 */       tError.moduleName = "LAIndexInfoDB";
/* 1142 */       tError.functionName = "prepareData";
/* 1143 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 1144 */       this.mErrors.addOneError(tError);
/* 1145 */       return false;
/*      */     }
/*      */ 
/* 1148 */     if (!this.mflag)
/*      */     {
/* 1150 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1154 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1155 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1160 */       CError tError = new CError();
/* 1161 */       tError.moduleName = "LAIndexInfoDB";
/* 1162 */       tError.functionName = "prepareData";
/* 1163 */       tError.errorMessage = e.toString();
/* 1164 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1167 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1173 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1177 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1181 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1186 */       return false;
/*      */     }
/*      */ 
/* 1189 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1193 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1198 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1204 */     boolean flag = true;
/* 1205 */     if (this.mResultSet == null)
/*      */     {
/* 1207 */       CError tError = new CError();
/* 1208 */       tError.moduleName = "LAIndexInfoDB";
/* 1209 */       tError.functionName = "hasMoreData";
/* 1210 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1211 */       this.mErrors.addOneError(tError);
/* 1212 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1216 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1220 */       CError tError = new CError();
/* 1221 */       tError.moduleName = "LAIndexInfoDB";
/* 1222 */       tError.functionName = "hasMoreData";
/* 1223 */       tError.errorMessage = ex.toString();
/* 1224 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1227 */         this.mResultSet.close();
/* 1228 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1234 */         this.mStatement.close();
/* 1235 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1239 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1243 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1248 */       return false;
/*      */     }
/* 1250 */     return flag;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoSet getData()
/*      */   {
/* 1255 */     int tCount = 0;
/* 1256 */     LAIndexInfoSet tLAIndexInfoSet = new LAIndexInfoSet();
/* 1257 */     LAIndexInfoSchema tLAIndexInfoSchema = null;
/* 1258 */     if (this.mResultSet == null)
/*      */     {
/* 1260 */       CError tError = new CError();
/* 1261 */       tError.moduleName = "LAIndexInfoDB";
/* 1262 */       tError.functionName = "getData";
/* 1263 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1264 */       this.mErrors.addOneError(tError);
/* 1265 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1269 */       tCount = 1;
/* 1270 */       tLAIndexInfoSchema = new LAIndexInfoSchema();
/* 1271 */       tLAIndexInfoSchema.setSchema(this.mResultSet, 1);
/* 1272 */       tLAIndexInfoSet.add(tLAIndexInfoSchema);
/*      */ 
/* 1274 */       while (tCount++ < 5000)
/*      */       {
/* 1276 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1278 */         tLAIndexInfoSchema = new LAIndexInfoSchema();
/* 1279 */         tLAIndexInfoSchema.setSchema(this.mResultSet, 1);
/* 1280 */         tLAIndexInfoSet.add(tLAIndexInfoSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1286 */       CError tError = new CError();
/* 1287 */       tError.moduleName = "LAIndexInfoDB";
/* 1288 */       tError.functionName = "getData";
/* 1289 */       tError.errorMessage = ex.toString();
/* 1290 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1293 */         this.mResultSet.close();
/* 1294 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1300 */         this.mStatement.close();
/* 1301 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1305 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1309 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1314 */       return null;
/*      */     }
/* 1316 */     return tLAIndexInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1321 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1324 */       if (this.mResultSet == null)
/*      */       {
/* 1326 */         CError tError = new CError();
/* 1327 */         tError.moduleName = "LAIndexInfoDB";
/* 1328 */         tError.functionName = "closeData";
/* 1329 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1330 */         this.mErrors.addOneError(tError);
/* 1331 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1335 */         this.mResultSet.close();
/* 1336 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1341 */       CError tError = new CError();
/* 1342 */       tError.moduleName = "LAIndexInfoDB";
/* 1343 */       tError.functionName = "closeData";
/* 1344 */       tError.errorMessage = ex2.toString();
/* 1345 */       this.mErrors.addOneError(tError);
/* 1346 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1350 */       if (this.mStatement == null)
/*      */       {
/* 1352 */         CError tError = new CError();
/* 1353 */         tError.moduleName = "LAIndexInfoDB";
/* 1354 */         tError.functionName = "closeData";
/* 1355 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1356 */         this.mErrors.addOneError(tError);
/* 1357 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1361 */         this.mStatement.close();
/* 1362 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1367 */       CError tError = new CError();
/* 1368 */       tError.moduleName = "LAIndexInfoDB";
/* 1369 */       tError.functionName = "closeData";
/* 1370 */       tError.errorMessage = ex3.toString();
/* 1371 */       this.mErrors.addOneError(tError);
/* 1372 */       flag = false;
/*      */     }
/* 1374 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.LAIndexInfoDB
 * JD-Core Version:    0.6.0
 */