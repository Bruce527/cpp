/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.LAIndexInfoNewSchema;
/*      */ import com.sinosoft.map.lis.vschema.LAIndexInfoNewSet;
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
/*      */ public class LAIndexInfoNewDB extends LAIndexInfoNewSchema
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
/*      */   public LAIndexInfoNewDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "LAIndexInfoNew");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoNewDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("LAIndexInfoNew");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     LAIndexInfoNewSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "LAIndexInfoNewDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     LAIndexInfoNewSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "LAIndexInfoNewDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM LAIndexInfoNew WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
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
/*  117 */       tError.moduleName = "LAIndexInfoNewDB";
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
/*  154 */       pstmt = this.con.prepareStatement("UPDATE LAIndexInfoNew SET  IndexCalNo = ? , IndexType = ? , ManageCom = ? , AgentGroup = ? , BranchAttr = ? , AgentCode = ? , AgentGrade = ? , AgentTitle = ? , QuaBgnMark = ? , PostMonths = ? , AssessMonth = ? , AgentGrade1 = ? , AgentTitle1 = ? , AgentGrade2 = ? , AgentTitle2 = ? , AgentGrade3 = ? , AgentTitle3 = ? , StartDate = ? , StartEnd = ? , StartDate1 = ? , StartEnd1 = ? , StartDate2 = ? , StartEnd2 = ? , StartDate3 = ? , StartEnd3 = ? , StartEnd4 = ? , StartDate4 = ? , ServerMonths = ? , NT01 = ? , NT02 = ? , NT03 = ? , NT04 = ? , NT05 = ? , NT06 = ? , NT07 = ? , NT08 = ? , NT09 = ? , NT10 = ? , NT11 = ? , NT12 = ? , NT13 = ? , NT14 = ? , NT15 = ? , NT16 = ? , NT17 = ? , NT18 = ? , NT19 = ? , NT20 = ? , NT21 = ? , NT22 = ? , NT23 = ? , NT24 = ? , NT25 = ? , NT26 = ? , NT27 = ? , NT28 = ? , NT29 = ? , NT30 = ? , NT31 = ? , NT32 = ? , NT33 = ? , NT34 = ? , NT35 = ? , NT36 = ? , NT37 = ? , NT38 = ? , NT39 = ? , NT40 = ? , NT41 = ? , NT42 = ? , NT43 = ? , NT44 = ? , NT45 = ? , NT46 = ? , NT47 = ? , NT48 = ? , NT49 = ? , NT50 = ? , NT51 = ? , NT52 = ? , NT53 = ? , NT54 = ? , NT55 = ? , NT56 = ? , NT57 = ? , NT58 = ? , NT59 = ? , NT60 = ? , NT61 = ? , NT62 = ? , NT63 = ? , NT64 = ? , NT65 = ? , NT66 = ? , NT67 = ? , NT68 = ? , NT69 = ? , NT70 = ? , NT71 = ? , NT72 = ? , NT73 = ? , NT74 = ? , NT75 = ? , NT76 = ? , NT77 = ? , NT78 = ? , NT79 = ? , NT80 = ? , NF01 = ? , NF02 = ? , NF03 = ? , NF04 = ? , NF05 = ? , NF06 = ? , NF07 = ? , NF08 = ? , NF09 = ? , NF10 = ? , NS01 = ? , NS02 = ? , NS03 = ? , NS04 = ? , NS05 = ? , NS06 = ? , NS07 = ? , NS08 = ? , NS09 = ? , NS10 = ? , INT01 = ? , INT02 = ? , INT03 = ? , INT04 = ? , INT05 = ? , INT06 = ? , INT07 = ? , INT08 = ? , INT09 = ? , INT10 = ? , INT11 = ? , INT12 = ? , INT13 = ? , INT14 = ? , INT15 = ? , INT16 = ? , INT17 = ? , INT18 = ? , INT19 = ? , INT20 = ? , INT21 = ? , INT22 = ? , INT23 = ? , INT24 = ? , INT25 = ? , V1 = ? , V2 = ? , V3 = ? , V4 = ? , V5 = ? , V6 = ? , V7 = ? , V8 = ? , V9 = ? , V10 = ? , V11 = ? , V12 = ? , V13 = ? , V14 = ? , V15 = ? , V16 = ? , V17 = ? , V18 = ? , V19 = ? , V20 = ? , VT1 = ? , VT2 = ? , VT3 = ? , VT4 = ? , VT5 = ? , VT6 = ? , VT7 = ? , VT8 = ? , VE1 = ? , VE2 = ? , VE3 = ? , VE4 = ? , VE5 = ? , VE6 = ? , VE7 = ? , VE8 = ? , VE9 = ? , VE10 = ? , D1 = ? , D2 = ? , D3 = ? , D4 = ? , D5 = ? , D6 = ? , D7 = ? , D8 = ? , D9 = ? , D10 = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
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
/*  165 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  166 */         pstmt.setNull(3, 12);
/*      */       else {
/*  168 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  170 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  171 */         pstmt.setNull(4, 12);
/*      */       else {
/*  173 */         pstmt.setString(4, getAgentGroup());
/*      */       }
/*  175 */       if ((getBranchAttr() == null) || (getBranchAttr().equals("null")))
/*  176 */         pstmt.setNull(5, 12);
/*      */       else {
/*  178 */         pstmt.setString(5, getBranchAttr());
/*      */       }
/*  180 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  181 */         pstmt.setNull(6, 12);
/*      */       else {
/*  183 */         pstmt.setString(6, getAgentCode());
/*      */       }
/*  185 */       if ((getAgentGrade() == null) || (getAgentGrade().equals("null")))
/*  186 */         pstmt.setNull(7, 12);
/*      */       else {
/*  188 */         pstmt.setString(7, getAgentGrade());
/*      */       }
/*  190 */       if ((getAgentTitle() == null) || (getAgentTitle().equals("null")))
/*  191 */         pstmt.setNull(8, 12);
/*      */       else {
/*  193 */         pstmt.setString(8, getAgentTitle());
/*      */       }
/*  195 */       pstmt.setInt(9, getQuaBgnMark());
/*  196 */       pstmt.setInt(10, getPostMonths());
/*  197 */       if ((getAssessMonth() == null) || (getAssessMonth().equals("null")))
/*  198 */         pstmt.setNull(11, 12);
/*      */       else {
/*  200 */         pstmt.setString(11, getAssessMonth());
/*      */       }
/*  202 */       if ((getAgentGrade1() == null) || (getAgentGrade1().equals("null")))
/*  203 */         pstmt.setNull(12, 12);
/*      */       else {
/*  205 */         pstmt.setString(12, getAgentGrade1());
/*      */       }
/*  207 */       if ((getAgentTitle1() == null) || (getAgentTitle1().equals("null")))
/*  208 */         pstmt.setNull(13, 12);
/*      */       else {
/*  210 */         pstmt.setString(13, getAgentTitle1());
/*      */       }
/*  212 */       if ((getAgentGrade2() == null) || (getAgentGrade2().equals("null")))
/*  213 */         pstmt.setNull(14, 12);
/*      */       else {
/*  215 */         pstmt.setString(14, getAgentGrade2());
/*      */       }
/*  217 */       if ((getAgentTitle2() == null) || (getAgentTitle2().equals("null")))
/*  218 */         pstmt.setNull(15, 12);
/*      */       else {
/*  220 */         pstmt.setString(15, getAgentTitle2());
/*      */       }
/*  222 */       if ((getAgentGrade3() == null) || (getAgentGrade3().equals("null")))
/*  223 */         pstmt.setNull(16, 12);
/*      */       else {
/*  225 */         pstmt.setString(16, getAgentGrade3());
/*      */       }
/*  227 */       if ((getAgentTitle3() == null) || (getAgentTitle3().equals("null")))
/*  228 */         pstmt.setNull(17, 12);
/*      */       else {
/*  230 */         pstmt.setString(17, getAgentTitle3());
/*      */       }
/*  232 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  233 */         pstmt.setNull(18, 91);
/*      */       else {
/*  235 */         pstmt.setDate(18, Date.valueOf(getStartDate()));
/*      */       }
/*  237 */       if ((getStartEnd() == null) || (getStartEnd().equals("null")))
/*  238 */         pstmt.setNull(19, 91);
/*      */       else {
/*  240 */         pstmt.setDate(19, Date.valueOf(getStartEnd()));
/*      */       }
/*  242 */       if ((getStartDate1() == null) || (getStartDate1().equals("null")))
/*  243 */         pstmt.setNull(20, 91);
/*      */       else {
/*  245 */         pstmt.setDate(20, Date.valueOf(getStartDate1()));
/*      */       }
/*  247 */       if ((getStartEnd1() == null) || (getStartEnd1().equals("null")))
/*  248 */         pstmt.setNull(21, 91);
/*      */       else {
/*  250 */         pstmt.setDate(21, Date.valueOf(getStartEnd1()));
/*      */       }
/*  252 */       if ((getStartDate2() == null) || (getStartDate2().equals("null")))
/*  253 */         pstmt.setNull(22, 91);
/*      */       else {
/*  255 */         pstmt.setDate(22, Date.valueOf(getStartDate2()));
/*      */       }
/*  257 */       if ((getStartEnd2() == null) || (getStartEnd2().equals("null")))
/*  258 */         pstmt.setNull(23, 91);
/*      */       else {
/*  260 */         pstmt.setDate(23, Date.valueOf(getStartEnd2()));
/*      */       }
/*  262 */       if ((getStartDate3() == null) || (getStartDate3().equals("null")))
/*  263 */         pstmt.setNull(24, 91);
/*      */       else {
/*  265 */         pstmt.setDate(24, Date.valueOf(getStartDate3()));
/*      */       }
/*  267 */       if ((getStartEnd3() == null) || (getStartEnd3().equals("null")))
/*  268 */         pstmt.setNull(25, 91);
/*      */       else {
/*  270 */         pstmt.setDate(25, Date.valueOf(getStartEnd3()));
/*      */       }
/*  272 */       if ((getStartEnd4() == null) || (getStartEnd4().equals("null")))
/*  273 */         pstmt.setNull(26, 91);
/*      */       else {
/*  275 */         pstmt.setDate(26, Date.valueOf(getStartEnd4()));
/*      */       }
/*  277 */       if ((getStartDate4() == null) || (getStartDate4().equals("null")))
/*  278 */         pstmt.setNull(27, 91);
/*      */       else {
/*  280 */         pstmt.setDate(27, Date.valueOf(getStartDate4()));
/*      */       }
/*  282 */       pstmt.setInt(28, getServerMonths());
/*  283 */       pstmt.setDouble(29, getNT01());
/*  284 */       pstmt.setDouble(30, getNT02());
/*  285 */       pstmt.setDouble(31, getNT03());
/*  286 */       pstmt.setDouble(32, getNT04());
/*  287 */       pstmt.setDouble(33, getNT05());
/*  288 */       pstmt.setDouble(34, getNT06());
/*  289 */       pstmt.setDouble(35, getNT07());
/*  290 */       pstmt.setDouble(36, getNT08());
/*  291 */       pstmt.setDouble(37, getNT09());
/*  292 */       pstmt.setDouble(38, getNT10());
/*  293 */       pstmt.setDouble(39, getNT11());
/*  294 */       pstmt.setDouble(40, getNT12());
/*  295 */       pstmt.setDouble(41, getNT13());
/*  296 */       pstmt.setDouble(42, getNT14());
/*  297 */       pstmt.setDouble(43, getNT15());
/*  298 */       pstmt.setDouble(44, getNT16());
/*  299 */       pstmt.setDouble(45, getNT17());
/*  300 */       pstmt.setDouble(46, getNT18());
/*  301 */       pstmt.setDouble(47, getNT19());
/*  302 */       pstmt.setDouble(48, getNT20());
/*  303 */       pstmt.setDouble(49, getNT21());
/*  304 */       pstmt.setDouble(50, getNT22());
/*  305 */       pstmt.setDouble(51, getNT23());
/*  306 */       pstmt.setDouble(52, getNT24());
/*  307 */       pstmt.setDouble(53, getNT25());
/*  308 */       pstmt.setDouble(54, getNT26());
/*  309 */       pstmt.setDouble(55, getNT27());
/*  310 */       pstmt.setDouble(56, getNT28());
/*  311 */       pstmt.setDouble(57, getNT29());
/*  312 */       pstmt.setDouble(58, getNT30());
/*  313 */       pstmt.setDouble(59, getNT31());
/*  314 */       pstmt.setDouble(60, getNT32());
/*  315 */       pstmt.setDouble(61, getNT33());
/*  316 */       pstmt.setDouble(62, getNT34());
/*  317 */       pstmt.setDouble(63, getNT35());
/*  318 */       pstmt.setDouble(64, getNT36());
/*  319 */       pstmt.setDouble(65, getNT37());
/*  320 */       pstmt.setDouble(66, getNT38());
/*  321 */       pstmt.setDouble(67, getNT39());
/*  322 */       pstmt.setDouble(68, getNT40());
/*  323 */       pstmt.setDouble(69, getNT41());
/*  324 */       pstmt.setDouble(70, getNT42());
/*  325 */       pstmt.setDouble(71, getNT43());
/*  326 */       pstmt.setDouble(72, getNT44());
/*  327 */       pstmt.setDouble(73, getNT45());
/*  328 */       pstmt.setDouble(74, getNT46());
/*  329 */       pstmt.setDouble(75, getNT47());
/*  330 */       pstmt.setDouble(76, getNT48());
/*  331 */       pstmt.setDouble(77, getNT49());
/*  332 */       pstmt.setDouble(78, getNT50());
/*  333 */       pstmt.setDouble(79, getNT51());
/*  334 */       pstmt.setDouble(80, getNT52());
/*  335 */       pstmt.setDouble(81, getNT53());
/*  336 */       pstmt.setDouble(82, getNT54());
/*  337 */       pstmt.setDouble(83, getNT55());
/*  338 */       pstmt.setDouble(84, getNT56());
/*  339 */       pstmt.setDouble(85, getNT57());
/*  340 */       pstmt.setDouble(86, getNT58());
/*  341 */       pstmt.setDouble(87, getNT59());
/*  342 */       pstmt.setDouble(88, getNT60());
/*  343 */       pstmt.setDouble(89, getNT61());
/*  344 */       pstmt.setDouble(90, getNT62());
/*  345 */       pstmt.setDouble(91, getNT63());
/*  346 */       pstmt.setDouble(92, getNT64());
/*  347 */       pstmt.setDouble(93, getNT65());
/*  348 */       pstmt.setDouble(94, getNT66());
/*  349 */       pstmt.setDouble(95, getNT67());
/*  350 */       pstmt.setDouble(96, getNT68());
/*  351 */       pstmt.setDouble(97, getNT69());
/*  352 */       pstmt.setDouble(98, getNT70());
/*  353 */       pstmt.setDouble(99, getNT71());
/*  354 */       pstmt.setDouble(100, getNT72());
/*  355 */       pstmt.setDouble(101, getNT73());
/*  356 */       pstmt.setDouble(102, getNT74());
/*  357 */       pstmt.setDouble(103, getNT75());
/*  358 */       pstmt.setDouble(104, getNT76());
/*  359 */       pstmt.setDouble(105, getNT77());
/*  360 */       pstmt.setDouble(106, getNT78());
/*  361 */       pstmt.setDouble(107, getNT79());
/*  362 */       pstmt.setDouble(108, getNT80());
/*  363 */       pstmt.setDouble(109, getNF01());
/*  364 */       pstmt.setDouble(110, getNF02());
/*  365 */       pstmt.setDouble(111, getNF03());
/*  366 */       pstmt.setDouble(112, getNF04());
/*  367 */       pstmt.setDouble(113, getNF05());
/*  368 */       pstmt.setDouble(114, getNF06());
/*  369 */       pstmt.setDouble(115, getNF07());
/*  370 */       pstmt.setDouble(116, getNF08());
/*  371 */       pstmt.setDouble(117, getNF09());
/*  372 */       pstmt.setDouble(118, getNF10());
/*  373 */       pstmt.setDouble(119, getNS01());
/*  374 */       pstmt.setDouble(120, getNS02());
/*  375 */       pstmt.setDouble(121, getNS03());
/*  376 */       pstmt.setDouble(122, getNS04());
/*  377 */       pstmt.setDouble(123, getNS05());
/*  378 */       pstmt.setDouble(124, getNS06());
/*  379 */       pstmt.setDouble(125, getNS07());
/*  380 */       pstmt.setDouble(126, getNS08());
/*  381 */       pstmt.setDouble(127, getNS09());
/*  382 */       pstmt.setDouble(128, getNS10());
/*  383 */       pstmt.setInt(129, getINT01());
/*  384 */       pstmt.setInt(130, getINT02());
/*  385 */       pstmt.setInt(131, getINT03());
/*  386 */       pstmt.setInt(132, getINT04());
/*  387 */       pstmt.setInt(133, getINT05());
/*  388 */       pstmt.setInt(134, getINT06());
/*  389 */       pstmt.setInt(135, getINT07());
/*  390 */       pstmt.setInt(136, getINT08());
/*  391 */       pstmt.setInt(137, getINT09());
/*  392 */       pstmt.setInt(138, getINT10());
/*  393 */       pstmt.setInt(139, getINT11());
/*  394 */       pstmt.setInt(140, getINT12());
/*  395 */       pstmt.setInt(141, getINT13());
/*  396 */       pstmt.setInt(142, getINT14());
/*  397 */       pstmt.setInt(143, getINT15());
/*  398 */       pstmt.setInt(144, getINT16());
/*  399 */       pstmt.setInt(145, getINT17());
/*  400 */       pstmt.setInt(146, getINT18());
/*  401 */       pstmt.setInt(147, getINT19());
/*  402 */       pstmt.setInt(148, getINT20());
/*  403 */       pstmt.setInt(149, getINT21());
/*  404 */       pstmt.setInt(150, getINT22());
/*  405 */       pstmt.setInt(151, getINT23());
/*  406 */       pstmt.setInt(152, getINT24());
/*  407 */       pstmt.setInt(153, getINT25());
/*  408 */       if ((getV1() == null) || (getV1().equals("null")))
/*  409 */         pstmt.setNull(154, 12);
/*      */       else {
/*  411 */         pstmt.setString(154, getV1());
/*      */       }
/*  413 */       if ((getV2() == null) || (getV2().equals("null")))
/*  414 */         pstmt.setNull(155, 12);
/*      */       else {
/*  416 */         pstmt.setString(155, getV2());
/*      */       }
/*  418 */       if ((getV3() == null) || (getV3().equals("null")))
/*  419 */         pstmt.setNull(156, 12);
/*      */       else {
/*  421 */         pstmt.setString(156, getV3());
/*      */       }
/*  423 */       if ((getV4() == null) || (getV4().equals("null")))
/*  424 */         pstmt.setNull(157, 12);
/*      */       else {
/*  426 */         pstmt.setString(157, getV4());
/*      */       }
/*  428 */       if ((getV5() == null) || (getV5().equals("null")))
/*  429 */         pstmt.setNull(158, 12);
/*      */       else {
/*  431 */         pstmt.setString(158, getV5());
/*      */       }
/*  433 */       if ((getV6() == null) || (getV6().equals("null")))
/*  434 */         pstmt.setNull(159, 12);
/*      */       else {
/*  436 */         pstmt.setString(159, getV6());
/*      */       }
/*  438 */       if ((getV7() == null) || (getV7().equals("null")))
/*  439 */         pstmt.setNull(160, 12);
/*      */       else {
/*  441 */         pstmt.setString(160, getV7());
/*      */       }
/*  443 */       if ((getV8() == null) || (getV8().equals("null")))
/*  444 */         pstmt.setNull(161, 12);
/*      */       else {
/*  446 */         pstmt.setString(161, getV8());
/*      */       }
/*  448 */       if ((getV9() == null) || (getV9().equals("null")))
/*  449 */         pstmt.setNull(162, 12);
/*      */       else {
/*  451 */         pstmt.setString(162, getV9());
/*      */       }
/*  453 */       if ((getV10() == null) || (getV10().equals("null")))
/*  454 */         pstmt.setNull(163, 12);
/*      */       else {
/*  456 */         pstmt.setString(163, getV10());
/*      */       }
/*  458 */       if ((getV11() == null) || (getV11().equals("null")))
/*  459 */         pstmt.setNull(164, 12);
/*      */       else {
/*  461 */         pstmt.setString(164, getV11());
/*      */       }
/*  463 */       if ((getV12() == null) || (getV12().equals("null")))
/*  464 */         pstmt.setNull(165, 12);
/*      */       else {
/*  466 */         pstmt.setString(165, getV12());
/*      */       }
/*  468 */       if ((getV13() == null) || (getV13().equals("null")))
/*  469 */         pstmt.setNull(166, 12);
/*      */       else {
/*  471 */         pstmt.setString(166, getV13());
/*      */       }
/*  473 */       if ((getV14() == null) || (getV14().equals("null")))
/*  474 */         pstmt.setNull(167, 12);
/*      */       else {
/*  476 */         pstmt.setString(167, getV14());
/*      */       }
/*  478 */       if ((getV15() == null) || (getV15().equals("null")))
/*  479 */         pstmt.setNull(168, 12);
/*      */       else {
/*  481 */         pstmt.setString(168, getV15());
/*      */       }
/*  483 */       if ((getV16() == null) || (getV16().equals("null")))
/*  484 */         pstmt.setNull(169, 12);
/*      */       else {
/*  486 */         pstmt.setString(169, getV16());
/*      */       }
/*  488 */       if ((getV17() == null) || (getV17().equals("null")))
/*  489 */         pstmt.setNull(170, 12);
/*      */       else {
/*  491 */         pstmt.setString(170, getV17());
/*      */       }
/*  493 */       if ((getV18() == null) || (getV18().equals("null")))
/*  494 */         pstmt.setNull(171, 12);
/*      */       else {
/*  496 */         pstmt.setString(171, getV18());
/*      */       }
/*  498 */       if ((getV19() == null) || (getV19().equals("null")))
/*  499 */         pstmt.setNull(172, 12);
/*      */       else {
/*  501 */         pstmt.setString(172, getV19());
/*      */       }
/*  503 */       if ((getV20() == null) || (getV20().equals("null")))
/*  504 */         pstmt.setNull(173, 12);
/*      */       else {
/*  506 */         pstmt.setString(173, getV20());
/*      */       }
/*  508 */       if ((getVT1() == null) || (getVT1().equals("null")))
/*  509 */         pstmt.setNull(174, 12);
/*      */       else {
/*  511 */         pstmt.setString(174, getVT1());
/*      */       }
/*  513 */       if ((getVT2() == null) || (getVT2().equals("null")))
/*  514 */         pstmt.setNull(175, 12);
/*      */       else {
/*  516 */         pstmt.setString(175, getVT2());
/*      */       }
/*  518 */       if ((getVT3() == null) || (getVT3().equals("null")))
/*  519 */         pstmt.setNull(176, 12);
/*      */       else {
/*  521 */         pstmt.setString(176, getVT3());
/*      */       }
/*  523 */       if ((getVT4() == null) || (getVT4().equals("null")))
/*  524 */         pstmt.setNull(177, 12);
/*      */       else {
/*  526 */         pstmt.setString(177, getVT4());
/*      */       }
/*  528 */       if ((getVT5() == null) || (getVT5().equals("null")))
/*  529 */         pstmt.setNull(178, 12);
/*      */       else {
/*  531 */         pstmt.setString(178, getVT5());
/*      */       }
/*  533 */       if ((getVT6() == null) || (getVT6().equals("null")))
/*  534 */         pstmt.setNull(179, 12);
/*      */       else {
/*  536 */         pstmt.setString(179, getVT6());
/*      */       }
/*  538 */       if ((getVT7() == null) || (getVT7().equals("null")))
/*  539 */         pstmt.setNull(180, 12);
/*      */       else {
/*  541 */         pstmt.setString(180, getVT7());
/*      */       }
/*  543 */       if ((getVT8() == null) || (getVT8().equals("null")))
/*  544 */         pstmt.setNull(181, 12);
/*      */       else {
/*  546 */         pstmt.setString(181, getVT8());
/*      */       }
/*  548 */       if ((getVE1() == null) || (getVE1().equals("null")))
/*  549 */         pstmt.setNull(182, 12);
/*      */       else {
/*  551 */         pstmt.setString(182, getVE1());
/*      */       }
/*  553 */       if ((getVE2() == null) || (getVE2().equals("null")))
/*  554 */         pstmt.setNull(183, 12);
/*      */       else {
/*  556 */         pstmt.setString(183, getVE2());
/*      */       }
/*  558 */       if ((getVE3() == null) || (getVE3().equals("null")))
/*  559 */         pstmt.setNull(184, 12);
/*      */       else {
/*  561 */         pstmt.setString(184, getVE3());
/*      */       }
/*  563 */       if ((getVE4() == null) || (getVE4().equals("null")))
/*  564 */         pstmt.setNull(185, 12);
/*      */       else {
/*  566 */         pstmt.setString(185, getVE4());
/*      */       }
/*  568 */       if ((getVE5() == null) || (getVE5().equals("null")))
/*  569 */         pstmt.setNull(186, 12);
/*      */       else {
/*  571 */         pstmt.setString(186, getVE5());
/*      */       }
/*  573 */       if ((getVE6() == null) || (getVE6().equals("null")))
/*  574 */         pstmt.setNull(187, 12);
/*      */       else {
/*  576 */         pstmt.setString(187, getVE6());
/*      */       }
/*  578 */       if ((getVE7() == null) || (getVE7().equals("null")))
/*  579 */         pstmt.setNull(188, 12);
/*      */       else {
/*  581 */         pstmt.setString(188, getVE7());
/*      */       }
/*  583 */       if ((getVE8() == null) || (getVE8().equals("null")))
/*  584 */         pstmt.setNull(189, 12);
/*      */       else {
/*  586 */         pstmt.setString(189, getVE8());
/*      */       }
/*  588 */       if ((getVE9() == null) || (getVE9().equals("null")))
/*  589 */         pstmt.setNull(190, 12);
/*      */       else {
/*  591 */         pstmt.setString(190, getVE9());
/*      */       }
/*  593 */       if ((getVE10() == null) || (getVE10().equals("null")))
/*  594 */         pstmt.setNull(191, 12);
/*      */       else {
/*  596 */         pstmt.setString(191, getVE10());
/*      */       }
/*  598 */       if ((getD1() == null) || (getD1().equals("null")))
/*  599 */         pstmt.setNull(192, 91);
/*      */       else {
/*  601 */         pstmt.setDate(192, Date.valueOf(getD1()));
/*      */       }
/*  603 */       if ((getD2() == null) || (getD2().equals("null")))
/*  604 */         pstmt.setNull(193, 91);
/*      */       else {
/*  606 */         pstmt.setDate(193, Date.valueOf(getD2()));
/*      */       }
/*  608 */       if ((getD3() == null) || (getD3().equals("null")))
/*  609 */         pstmt.setNull(194, 91);
/*      */       else {
/*  611 */         pstmt.setDate(194, Date.valueOf(getD3()));
/*      */       }
/*  613 */       if ((getD4() == null) || (getD4().equals("null")))
/*  614 */         pstmt.setNull(195, 91);
/*      */       else {
/*  616 */         pstmt.setDate(195, Date.valueOf(getD4()));
/*      */       }
/*  618 */       if ((getD5() == null) || (getD5().equals("null")))
/*  619 */         pstmt.setNull(196, 91);
/*      */       else {
/*  621 */         pstmt.setDate(196, Date.valueOf(getD5()));
/*      */       }
/*  623 */       if ((getD6() == null) || (getD6().equals("null")))
/*  624 */         pstmt.setNull(197, 91);
/*      */       else {
/*  626 */         pstmt.setDate(197, Date.valueOf(getD6()));
/*      */       }
/*  628 */       if ((getD7() == null) || (getD7().equals("null")))
/*  629 */         pstmt.setNull(198, 91);
/*      */       else {
/*  631 */         pstmt.setDate(198, Date.valueOf(getD7()));
/*      */       }
/*  633 */       if ((getD8() == null) || (getD8().equals("null")))
/*  634 */         pstmt.setNull(199, 91);
/*      */       else {
/*  636 */         pstmt.setDate(199, Date.valueOf(getD8()));
/*      */       }
/*  638 */       if ((getD9() == null) || (getD9().equals("null")))
/*  639 */         pstmt.setNull(200, 91);
/*      */       else {
/*  641 */         pstmt.setDate(200, Date.valueOf(getD9()));
/*      */       }
/*  643 */       if ((getD10() == null) || (getD10().equals("null")))
/*  644 */         pstmt.setNull(201, 91);
/*      */       else {
/*  646 */         pstmt.setDate(201, Date.valueOf(getD10()));
/*      */       }
/*  648 */       if ((getState() == null) || (getState().equals("null")))
/*  649 */         pstmt.setNull(202, 12);
/*      */       else {
/*  651 */         pstmt.setString(202, getState());
/*      */       }
/*  653 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  654 */         pstmt.setNull(203, 12);
/*      */       else {
/*  656 */         pstmt.setString(203, getOperator());
/*      */       }
/*  658 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  659 */         pstmt.setNull(204, 91);
/*      */       else {
/*  661 */         pstmt.setDate(204, Date.valueOf(getMakeDate()));
/*      */       }
/*  663 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  664 */         pstmt.setNull(205, 12);
/*      */       else {
/*  666 */         pstmt.setString(205, getMakeTime());
/*      */       }
/*  668 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  669 */         pstmt.setNull(206, 91);
/*      */       else {
/*  671 */         pstmt.setDate(206, Date.valueOf(getModifyDate()));
/*      */       }
/*  673 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  674 */         pstmt.setNull(207, 12);
/*      */       else {
/*  676 */         pstmt.setString(207, getModifyTime());
/*      */       }
/*      */ 
/*  679 */       if ((getIndexCalNo() == null) || (getIndexCalNo().equals("null")))
/*  680 */         pstmt.setNull(208, 12);
/*      */       else {
/*  682 */         pstmt.setString(208, getIndexCalNo());
/*      */       }
/*  684 */       if ((getIndexType() == null) || (getIndexType().equals("null")))
/*  685 */         pstmt.setNull(209, 12);
/*      */       else {
/*  687 */         pstmt.setString(209, getIndexType());
/*      */       }
/*  689 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  690 */         pstmt.setNull(210, 12);
/*      */       else {
/*  692 */         pstmt.setString(210, getAgentCode());
/*      */       }
/*  694 */       pstmt.executeUpdate();
/*  695 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  698 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  699 */       CError tError = new CError();
/*  700 */       tError.moduleName = "LAIndexInfoNewDB";
/*  701 */       tError.functionName = "update()";
/*  702 */       tError.errorMessage = ex.toString();
/*  703 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  706 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  709 */       if (!this.mflag)
/*      */         try {
/*  711 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  715 */       return false;
/*      */     }
/*      */ 
/*  718 */     if (!this.mflag)
/*      */       try {
/*  720 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  724 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  729 */     PreparedStatement pstmt = null;
/*      */ 
/*  731 */     if (!this.mflag) {
/*  732 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  737 */       pstmt = this.con.prepareStatement("INSERT INTO LAIndexInfoNew VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  738 */       if ((getIndexCalNo() == null) || (getIndexCalNo().equals("null")))
/*  739 */         pstmt.setNull(1, 12);
/*      */       else {
/*  741 */         pstmt.setString(1, getIndexCalNo());
/*      */       }
/*  743 */       if ((getIndexType() == null) || (getIndexType().equals("null")))
/*  744 */         pstmt.setNull(2, 12);
/*      */       else {
/*  746 */         pstmt.setString(2, getIndexType());
/*      */       }
/*  748 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  749 */         pstmt.setNull(3, 12);
/*      */       else {
/*  751 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  753 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  754 */         pstmt.setNull(4, 12);
/*      */       else {
/*  756 */         pstmt.setString(4, getAgentGroup());
/*      */       }
/*  758 */       if ((getBranchAttr() == null) || (getBranchAttr().equals("null")))
/*  759 */         pstmt.setNull(5, 12);
/*      */       else {
/*  761 */         pstmt.setString(5, getBranchAttr());
/*      */       }
/*  763 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  764 */         pstmt.setNull(6, 12);
/*      */       else {
/*  766 */         pstmt.setString(6, getAgentCode());
/*      */       }
/*  768 */       if ((getAgentGrade() == null) || (getAgentGrade().equals("null")))
/*  769 */         pstmt.setNull(7, 12);
/*      */       else {
/*  771 */         pstmt.setString(7, getAgentGrade());
/*      */       }
/*  773 */       if ((getAgentTitle() == null) || (getAgentTitle().equals("null")))
/*  774 */         pstmt.setNull(8, 12);
/*      */       else {
/*  776 */         pstmt.setString(8, getAgentTitle());
/*      */       }
/*  778 */       pstmt.setInt(9, getQuaBgnMark());
/*  779 */       pstmt.setInt(10, getPostMonths());
/*  780 */       if ((getAssessMonth() == null) || (getAssessMonth().equals("null")))
/*  781 */         pstmt.setNull(11, 12);
/*      */       else {
/*  783 */         pstmt.setString(11, getAssessMonth());
/*      */       }
/*  785 */       if ((getAgentGrade1() == null) || (getAgentGrade1().equals("null")))
/*  786 */         pstmt.setNull(12, 12);
/*      */       else {
/*  788 */         pstmt.setString(12, getAgentGrade1());
/*      */       }
/*  790 */       if ((getAgentTitle1() == null) || (getAgentTitle1().equals("null")))
/*  791 */         pstmt.setNull(13, 12);
/*      */       else {
/*  793 */         pstmt.setString(13, getAgentTitle1());
/*      */       }
/*  795 */       if ((getAgentGrade2() == null) || (getAgentGrade2().equals("null")))
/*  796 */         pstmt.setNull(14, 12);
/*      */       else {
/*  798 */         pstmt.setString(14, getAgentGrade2());
/*      */       }
/*  800 */       if ((getAgentTitle2() == null) || (getAgentTitle2().equals("null")))
/*  801 */         pstmt.setNull(15, 12);
/*      */       else {
/*  803 */         pstmt.setString(15, getAgentTitle2());
/*      */       }
/*  805 */       if ((getAgentGrade3() == null) || (getAgentGrade3().equals("null")))
/*  806 */         pstmt.setNull(16, 12);
/*      */       else {
/*  808 */         pstmt.setString(16, getAgentGrade3());
/*      */       }
/*  810 */       if ((getAgentTitle3() == null) || (getAgentTitle3().equals("null")))
/*  811 */         pstmt.setNull(17, 12);
/*      */       else {
/*  813 */         pstmt.setString(17, getAgentTitle3());
/*      */       }
/*  815 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  816 */         pstmt.setNull(18, 91);
/*      */       else {
/*  818 */         pstmt.setDate(18, Date.valueOf(getStartDate()));
/*      */       }
/*  820 */       if ((getStartEnd() == null) || (getStartEnd().equals("null")))
/*  821 */         pstmt.setNull(19, 91);
/*      */       else {
/*  823 */         pstmt.setDate(19, Date.valueOf(getStartEnd()));
/*      */       }
/*  825 */       if ((getStartDate1() == null) || (getStartDate1().equals("null")))
/*  826 */         pstmt.setNull(20, 91);
/*      */       else {
/*  828 */         pstmt.setDate(20, Date.valueOf(getStartDate1()));
/*      */       }
/*  830 */       if ((getStartEnd1() == null) || (getStartEnd1().equals("null")))
/*  831 */         pstmt.setNull(21, 91);
/*      */       else {
/*  833 */         pstmt.setDate(21, Date.valueOf(getStartEnd1()));
/*      */       }
/*  835 */       if ((getStartDate2() == null) || (getStartDate2().equals("null")))
/*  836 */         pstmt.setNull(22, 91);
/*      */       else {
/*  838 */         pstmt.setDate(22, Date.valueOf(getStartDate2()));
/*      */       }
/*  840 */       if ((getStartEnd2() == null) || (getStartEnd2().equals("null")))
/*  841 */         pstmt.setNull(23, 91);
/*      */       else {
/*  843 */         pstmt.setDate(23, Date.valueOf(getStartEnd2()));
/*      */       }
/*  845 */       if ((getStartDate3() == null) || (getStartDate3().equals("null")))
/*  846 */         pstmt.setNull(24, 91);
/*      */       else {
/*  848 */         pstmt.setDate(24, Date.valueOf(getStartDate3()));
/*      */       }
/*  850 */       if ((getStartEnd3() == null) || (getStartEnd3().equals("null")))
/*  851 */         pstmt.setNull(25, 91);
/*      */       else {
/*  853 */         pstmt.setDate(25, Date.valueOf(getStartEnd3()));
/*      */       }
/*  855 */       if ((getStartEnd4() == null) || (getStartEnd4().equals("null")))
/*  856 */         pstmt.setNull(26, 91);
/*      */       else {
/*  858 */         pstmt.setDate(26, Date.valueOf(getStartEnd4()));
/*      */       }
/*  860 */       if ((getStartDate4() == null) || (getStartDate4().equals("null")))
/*  861 */         pstmt.setNull(27, 91);
/*      */       else {
/*  863 */         pstmt.setDate(27, Date.valueOf(getStartDate4()));
/*      */       }
/*  865 */       pstmt.setInt(28, getServerMonths());
/*  866 */       pstmt.setDouble(29, getNT01());
/*  867 */       pstmt.setDouble(30, getNT02());
/*  868 */       pstmt.setDouble(31, getNT03());
/*  869 */       pstmt.setDouble(32, getNT04());
/*  870 */       pstmt.setDouble(33, getNT05());
/*  871 */       pstmt.setDouble(34, getNT06());
/*  872 */       pstmt.setDouble(35, getNT07());
/*  873 */       pstmt.setDouble(36, getNT08());
/*  874 */       pstmt.setDouble(37, getNT09());
/*  875 */       pstmt.setDouble(38, getNT10());
/*  876 */       pstmt.setDouble(39, getNT11());
/*  877 */       pstmt.setDouble(40, getNT12());
/*  878 */       pstmt.setDouble(41, getNT13());
/*  879 */       pstmt.setDouble(42, getNT14());
/*  880 */       pstmt.setDouble(43, getNT15());
/*  881 */       pstmt.setDouble(44, getNT16());
/*  882 */       pstmt.setDouble(45, getNT17());
/*  883 */       pstmt.setDouble(46, getNT18());
/*  884 */       pstmt.setDouble(47, getNT19());
/*  885 */       pstmt.setDouble(48, getNT20());
/*  886 */       pstmt.setDouble(49, getNT21());
/*  887 */       pstmt.setDouble(50, getNT22());
/*  888 */       pstmt.setDouble(51, getNT23());
/*  889 */       pstmt.setDouble(52, getNT24());
/*  890 */       pstmt.setDouble(53, getNT25());
/*  891 */       pstmt.setDouble(54, getNT26());
/*  892 */       pstmt.setDouble(55, getNT27());
/*  893 */       pstmt.setDouble(56, getNT28());
/*  894 */       pstmt.setDouble(57, getNT29());
/*  895 */       pstmt.setDouble(58, getNT30());
/*  896 */       pstmt.setDouble(59, getNT31());
/*  897 */       pstmt.setDouble(60, getNT32());
/*  898 */       pstmt.setDouble(61, getNT33());
/*  899 */       pstmt.setDouble(62, getNT34());
/*  900 */       pstmt.setDouble(63, getNT35());
/*  901 */       pstmt.setDouble(64, getNT36());
/*  902 */       pstmt.setDouble(65, getNT37());
/*  903 */       pstmt.setDouble(66, getNT38());
/*  904 */       pstmt.setDouble(67, getNT39());
/*  905 */       pstmt.setDouble(68, getNT40());
/*  906 */       pstmt.setDouble(69, getNT41());
/*  907 */       pstmt.setDouble(70, getNT42());
/*  908 */       pstmt.setDouble(71, getNT43());
/*  909 */       pstmt.setDouble(72, getNT44());
/*  910 */       pstmt.setDouble(73, getNT45());
/*  911 */       pstmt.setDouble(74, getNT46());
/*  912 */       pstmt.setDouble(75, getNT47());
/*  913 */       pstmt.setDouble(76, getNT48());
/*  914 */       pstmt.setDouble(77, getNT49());
/*  915 */       pstmt.setDouble(78, getNT50());
/*  916 */       pstmt.setDouble(79, getNT51());
/*  917 */       pstmt.setDouble(80, getNT52());
/*  918 */       pstmt.setDouble(81, getNT53());
/*  919 */       pstmt.setDouble(82, getNT54());
/*  920 */       pstmt.setDouble(83, getNT55());
/*  921 */       pstmt.setDouble(84, getNT56());
/*  922 */       pstmt.setDouble(85, getNT57());
/*  923 */       pstmt.setDouble(86, getNT58());
/*  924 */       pstmt.setDouble(87, getNT59());
/*  925 */       pstmt.setDouble(88, getNT60());
/*  926 */       pstmt.setDouble(89, getNT61());
/*  927 */       pstmt.setDouble(90, getNT62());
/*  928 */       pstmt.setDouble(91, getNT63());
/*  929 */       pstmt.setDouble(92, getNT64());
/*  930 */       pstmt.setDouble(93, getNT65());
/*  931 */       pstmt.setDouble(94, getNT66());
/*  932 */       pstmt.setDouble(95, getNT67());
/*  933 */       pstmt.setDouble(96, getNT68());
/*  934 */       pstmt.setDouble(97, getNT69());
/*  935 */       pstmt.setDouble(98, getNT70());
/*  936 */       pstmt.setDouble(99, getNT71());
/*  937 */       pstmt.setDouble(100, getNT72());
/*  938 */       pstmt.setDouble(101, getNT73());
/*  939 */       pstmt.setDouble(102, getNT74());
/*  940 */       pstmt.setDouble(103, getNT75());
/*  941 */       pstmt.setDouble(104, getNT76());
/*  942 */       pstmt.setDouble(105, getNT77());
/*  943 */       pstmt.setDouble(106, getNT78());
/*  944 */       pstmt.setDouble(107, getNT79());
/*  945 */       pstmt.setDouble(108, getNT80());
/*  946 */       pstmt.setDouble(109, getNF01());
/*  947 */       pstmt.setDouble(110, getNF02());
/*  948 */       pstmt.setDouble(111, getNF03());
/*  949 */       pstmt.setDouble(112, getNF04());
/*  950 */       pstmt.setDouble(113, getNF05());
/*  951 */       pstmt.setDouble(114, getNF06());
/*  952 */       pstmt.setDouble(115, getNF07());
/*  953 */       pstmt.setDouble(116, getNF08());
/*  954 */       pstmt.setDouble(117, getNF09());
/*  955 */       pstmt.setDouble(118, getNF10());
/*  956 */       pstmt.setDouble(119, getNS01());
/*  957 */       pstmt.setDouble(120, getNS02());
/*  958 */       pstmt.setDouble(121, getNS03());
/*  959 */       pstmt.setDouble(122, getNS04());
/*  960 */       pstmt.setDouble(123, getNS05());
/*  961 */       pstmt.setDouble(124, getNS06());
/*  962 */       pstmt.setDouble(125, getNS07());
/*  963 */       pstmt.setDouble(126, getNS08());
/*  964 */       pstmt.setDouble(127, getNS09());
/*  965 */       pstmt.setDouble(128, getNS10());
/*  966 */       pstmt.setInt(129, getINT01());
/*  967 */       pstmt.setInt(130, getINT02());
/*  968 */       pstmt.setInt(131, getINT03());
/*  969 */       pstmt.setInt(132, getINT04());
/*  970 */       pstmt.setInt(133, getINT05());
/*  971 */       pstmt.setInt(134, getINT06());
/*  972 */       pstmt.setInt(135, getINT07());
/*  973 */       pstmt.setInt(136, getINT08());
/*  974 */       pstmt.setInt(137, getINT09());
/*  975 */       pstmt.setInt(138, getINT10());
/*  976 */       pstmt.setInt(139, getINT11());
/*  977 */       pstmt.setInt(140, getINT12());
/*  978 */       pstmt.setInt(141, getINT13());
/*  979 */       pstmt.setInt(142, getINT14());
/*  980 */       pstmt.setInt(143, getINT15());
/*  981 */       pstmt.setInt(144, getINT16());
/*  982 */       pstmt.setInt(145, getINT17());
/*  983 */       pstmt.setInt(146, getINT18());
/*  984 */       pstmt.setInt(147, getINT19());
/*  985 */       pstmt.setInt(148, getINT20());
/*  986 */       pstmt.setInt(149, getINT21());
/*  987 */       pstmt.setInt(150, getINT22());
/*  988 */       pstmt.setInt(151, getINT23());
/*  989 */       pstmt.setInt(152, getINT24());
/*  990 */       pstmt.setInt(153, getINT25());
/*  991 */       if ((getV1() == null) || (getV1().equals("null")))
/*  992 */         pstmt.setNull(154, 12);
/*      */       else {
/*  994 */         pstmt.setString(154, getV1());
/*      */       }
/*  996 */       if ((getV2() == null) || (getV2().equals("null")))
/*  997 */         pstmt.setNull(155, 12);
/*      */       else {
/*  999 */         pstmt.setString(155, getV2());
/*      */       }
/* 1001 */       if ((getV3() == null) || (getV3().equals("null")))
/* 1002 */         pstmt.setNull(156, 12);
/*      */       else {
/* 1004 */         pstmt.setString(156, getV3());
/*      */       }
/* 1006 */       if ((getV4() == null) || (getV4().equals("null")))
/* 1007 */         pstmt.setNull(157, 12);
/*      */       else {
/* 1009 */         pstmt.setString(157, getV4());
/*      */       }
/* 1011 */       if ((getV5() == null) || (getV5().equals("null")))
/* 1012 */         pstmt.setNull(158, 12);
/*      */       else {
/* 1014 */         pstmt.setString(158, getV5());
/*      */       }
/* 1016 */       if ((getV6() == null) || (getV6().equals("null")))
/* 1017 */         pstmt.setNull(159, 12);
/*      */       else {
/* 1019 */         pstmt.setString(159, getV6());
/*      */       }
/* 1021 */       if ((getV7() == null) || (getV7().equals("null")))
/* 1022 */         pstmt.setNull(160, 12);
/*      */       else {
/* 1024 */         pstmt.setString(160, getV7());
/*      */       }
/* 1026 */       if ((getV8() == null) || (getV8().equals("null")))
/* 1027 */         pstmt.setNull(161, 12);
/*      */       else {
/* 1029 */         pstmt.setString(161, getV8());
/*      */       }
/* 1031 */       if ((getV9() == null) || (getV9().equals("null")))
/* 1032 */         pstmt.setNull(162, 12);
/*      */       else {
/* 1034 */         pstmt.setString(162, getV9());
/*      */       }
/* 1036 */       if ((getV10() == null) || (getV10().equals("null")))
/* 1037 */         pstmt.setNull(163, 12);
/*      */       else {
/* 1039 */         pstmt.setString(163, getV10());
/*      */       }
/* 1041 */       if ((getV11() == null) || (getV11().equals("null")))
/* 1042 */         pstmt.setNull(164, 12);
/*      */       else {
/* 1044 */         pstmt.setString(164, getV11());
/*      */       }
/* 1046 */       if ((getV12() == null) || (getV12().equals("null")))
/* 1047 */         pstmt.setNull(165, 12);
/*      */       else {
/* 1049 */         pstmt.setString(165, getV12());
/*      */       }
/* 1051 */       if ((getV13() == null) || (getV13().equals("null")))
/* 1052 */         pstmt.setNull(166, 12);
/*      */       else {
/* 1054 */         pstmt.setString(166, getV13());
/*      */       }
/* 1056 */       if ((getV14() == null) || (getV14().equals("null")))
/* 1057 */         pstmt.setNull(167, 12);
/*      */       else {
/* 1059 */         pstmt.setString(167, getV14());
/*      */       }
/* 1061 */       if ((getV15() == null) || (getV15().equals("null")))
/* 1062 */         pstmt.setNull(168, 12);
/*      */       else {
/* 1064 */         pstmt.setString(168, getV15());
/*      */       }
/* 1066 */       if ((getV16() == null) || (getV16().equals("null")))
/* 1067 */         pstmt.setNull(169, 12);
/*      */       else {
/* 1069 */         pstmt.setString(169, getV16());
/*      */       }
/* 1071 */       if ((getV17() == null) || (getV17().equals("null")))
/* 1072 */         pstmt.setNull(170, 12);
/*      */       else {
/* 1074 */         pstmt.setString(170, getV17());
/*      */       }
/* 1076 */       if ((getV18() == null) || (getV18().equals("null")))
/* 1077 */         pstmt.setNull(171, 12);
/*      */       else {
/* 1079 */         pstmt.setString(171, getV18());
/*      */       }
/* 1081 */       if ((getV19() == null) || (getV19().equals("null")))
/* 1082 */         pstmt.setNull(172, 12);
/*      */       else {
/* 1084 */         pstmt.setString(172, getV19());
/*      */       }
/* 1086 */       if ((getV20() == null) || (getV20().equals("null")))
/* 1087 */         pstmt.setNull(173, 12);
/*      */       else {
/* 1089 */         pstmt.setString(173, getV20());
/*      */       }
/* 1091 */       if ((getVT1() == null) || (getVT1().equals("null")))
/* 1092 */         pstmt.setNull(174, 12);
/*      */       else {
/* 1094 */         pstmt.setString(174, getVT1());
/*      */       }
/* 1096 */       if ((getVT2() == null) || (getVT2().equals("null")))
/* 1097 */         pstmt.setNull(175, 12);
/*      */       else {
/* 1099 */         pstmt.setString(175, getVT2());
/*      */       }
/* 1101 */       if ((getVT3() == null) || (getVT3().equals("null")))
/* 1102 */         pstmt.setNull(176, 12);
/*      */       else {
/* 1104 */         pstmt.setString(176, getVT3());
/*      */       }
/* 1106 */       if ((getVT4() == null) || (getVT4().equals("null")))
/* 1107 */         pstmt.setNull(177, 12);
/*      */       else {
/* 1109 */         pstmt.setString(177, getVT4());
/*      */       }
/* 1111 */       if ((getVT5() == null) || (getVT5().equals("null")))
/* 1112 */         pstmt.setNull(178, 12);
/*      */       else {
/* 1114 */         pstmt.setString(178, getVT5());
/*      */       }
/* 1116 */       if ((getVT6() == null) || (getVT6().equals("null")))
/* 1117 */         pstmt.setNull(179, 12);
/*      */       else {
/* 1119 */         pstmt.setString(179, getVT6());
/*      */       }
/* 1121 */       if ((getVT7() == null) || (getVT7().equals("null")))
/* 1122 */         pstmt.setNull(180, 12);
/*      */       else {
/* 1124 */         pstmt.setString(180, getVT7());
/*      */       }
/* 1126 */       if ((getVT8() == null) || (getVT8().equals("null")))
/* 1127 */         pstmt.setNull(181, 12);
/*      */       else {
/* 1129 */         pstmt.setString(181, getVT8());
/*      */       }
/* 1131 */       if ((getVE1() == null) || (getVE1().equals("null")))
/* 1132 */         pstmt.setNull(182, 12);
/*      */       else {
/* 1134 */         pstmt.setString(182, getVE1());
/*      */       }
/* 1136 */       if ((getVE2() == null) || (getVE2().equals("null")))
/* 1137 */         pstmt.setNull(183, 12);
/*      */       else {
/* 1139 */         pstmt.setString(183, getVE2());
/*      */       }
/* 1141 */       if ((getVE3() == null) || (getVE3().equals("null")))
/* 1142 */         pstmt.setNull(184, 12);
/*      */       else {
/* 1144 */         pstmt.setString(184, getVE3());
/*      */       }
/* 1146 */       if ((getVE4() == null) || (getVE4().equals("null")))
/* 1147 */         pstmt.setNull(185, 12);
/*      */       else {
/* 1149 */         pstmt.setString(185, getVE4());
/*      */       }
/* 1151 */       if ((getVE5() == null) || (getVE5().equals("null")))
/* 1152 */         pstmt.setNull(186, 12);
/*      */       else {
/* 1154 */         pstmt.setString(186, getVE5());
/*      */       }
/* 1156 */       if ((getVE6() == null) || (getVE6().equals("null")))
/* 1157 */         pstmt.setNull(187, 12);
/*      */       else {
/* 1159 */         pstmt.setString(187, getVE6());
/*      */       }
/* 1161 */       if ((getVE7() == null) || (getVE7().equals("null")))
/* 1162 */         pstmt.setNull(188, 12);
/*      */       else {
/* 1164 */         pstmt.setString(188, getVE7());
/*      */       }
/* 1166 */       if ((getVE8() == null) || (getVE8().equals("null")))
/* 1167 */         pstmt.setNull(189, 12);
/*      */       else {
/* 1169 */         pstmt.setString(189, getVE8());
/*      */       }
/* 1171 */       if ((getVE9() == null) || (getVE9().equals("null")))
/* 1172 */         pstmt.setNull(190, 12);
/*      */       else {
/* 1174 */         pstmt.setString(190, getVE9());
/*      */       }
/* 1176 */       if ((getVE10() == null) || (getVE10().equals("null")))
/* 1177 */         pstmt.setNull(191, 12);
/*      */       else {
/* 1179 */         pstmt.setString(191, getVE10());
/*      */       }
/* 1181 */       if ((getD1() == null) || (getD1().equals("null")))
/* 1182 */         pstmt.setNull(192, 91);
/*      */       else {
/* 1184 */         pstmt.setDate(192, Date.valueOf(getD1()));
/*      */       }
/* 1186 */       if ((getD2() == null) || (getD2().equals("null")))
/* 1187 */         pstmt.setNull(193, 91);
/*      */       else {
/* 1189 */         pstmt.setDate(193, Date.valueOf(getD2()));
/*      */       }
/* 1191 */       if ((getD3() == null) || (getD3().equals("null")))
/* 1192 */         pstmt.setNull(194, 91);
/*      */       else {
/* 1194 */         pstmt.setDate(194, Date.valueOf(getD3()));
/*      */       }
/* 1196 */       if ((getD4() == null) || (getD4().equals("null")))
/* 1197 */         pstmt.setNull(195, 91);
/*      */       else {
/* 1199 */         pstmt.setDate(195, Date.valueOf(getD4()));
/*      */       }
/* 1201 */       if ((getD5() == null) || (getD5().equals("null")))
/* 1202 */         pstmt.setNull(196, 91);
/*      */       else {
/* 1204 */         pstmt.setDate(196, Date.valueOf(getD5()));
/*      */       }
/* 1206 */       if ((getD6() == null) || (getD6().equals("null")))
/* 1207 */         pstmt.setNull(197, 91);
/*      */       else {
/* 1209 */         pstmt.setDate(197, Date.valueOf(getD6()));
/*      */       }
/* 1211 */       if ((getD7() == null) || (getD7().equals("null")))
/* 1212 */         pstmt.setNull(198, 91);
/*      */       else {
/* 1214 */         pstmt.setDate(198, Date.valueOf(getD7()));
/*      */       }
/* 1216 */       if ((getD8() == null) || (getD8().equals("null")))
/* 1217 */         pstmt.setNull(199, 91);
/*      */       else {
/* 1219 */         pstmt.setDate(199, Date.valueOf(getD8()));
/*      */       }
/* 1221 */       if ((getD9() == null) || (getD9().equals("null")))
/* 1222 */         pstmt.setNull(200, 91);
/*      */       else {
/* 1224 */         pstmt.setDate(200, Date.valueOf(getD9()));
/*      */       }
/* 1226 */       if ((getD10() == null) || (getD10().equals("null")))
/* 1227 */         pstmt.setNull(201, 91);
/*      */       else {
/* 1229 */         pstmt.setDate(201, Date.valueOf(getD10()));
/*      */       }
/* 1231 */       if ((getState() == null) || (getState().equals("null")))
/* 1232 */         pstmt.setNull(202, 12);
/*      */       else {
/* 1234 */         pstmt.setString(202, getState());
/*      */       }
/* 1236 */       if ((getOperator() == null) || (getOperator().equals("null")))
/* 1237 */         pstmt.setNull(203, 12);
/*      */       else {
/* 1239 */         pstmt.setString(203, getOperator());
/*      */       }
/* 1241 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/* 1242 */         pstmt.setNull(204, 91);
/*      */       else {
/* 1244 */         pstmt.setDate(204, Date.valueOf(getMakeDate()));
/*      */       }
/* 1246 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/* 1247 */         pstmt.setNull(205, 12);
/*      */       else {
/* 1249 */         pstmt.setString(205, getMakeTime());
/*      */       }
/* 1251 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/* 1252 */         pstmt.setNull(206, 91);
/*      */       else {
/* 1254 */         pstmt.setDate(206, Date.valueOf(getModifyDate()));
/*      */       }
/* 1256 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/* 1257 */         pstmt.setNull(207, 12);
/*      */       else {
/* 1259 */         pstmt.setString(207, getModifyTime());
/*      */       }
/*      */ 
/* 1262 */       pstmt.executeUpdate();
/* 1263 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/* 1266 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 1267 */       CError tError = new CError();
/* 1268 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1269 */       tError.functionName = "insert()";
/* 1270 */       tError.errorMessage = ex.toString();
/* 1271 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1274 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/* 1277 */       if (!this.mflag)
/*      */         try {
/* 1279 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/* 1283 */       return false;
/*      */     }
/*      */ 
/* 1286 */     if (!this.mflag)
/*      */       try {
/* 1288 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/* 1292 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/* 1297 */     PreparedStatement pstmt = null;
/* 1298 */     ResultSet rs = null;
/*      */ 
/* 1300 */     if (!this.mflag) {
/* 1301 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1306 */       pstmt = this.con.prepareStatement("SELECT * FROM LAIndexInfoNew WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?", 
/* 1307 */         1003, 1007);
/* 1308 */       if ((getIndexCalNo() == null) || (getIndexCalNo().equals("null")))
/* 1309 */         pstmt.setNull(1, 12);
/*      */       else {
/* 1311 */         pstmt.setString(1, getIndexCalNo());
/*      */       }
/* 1313 */       if ((getIndexType() == null) || (getIndexType().equals("null")))
/* 1314 */         pstmt.setNull(2, 12);
/*      */       else {
/* 1316 */         pstmt.setString(2, getIndexType());
/*      */       }
/* 1318 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/* 1319 */         pstmt.setNull(3, 12);
/*      */       else {
/* 1321 */         pstmt.setString(3, getAgentCode());
/*      */       }
/* 1323 */       rs = pstmt.executeQuery();
/* 1324 */       int i = 0;
/* 1325 */       if (rs.next())
/*      */       {
/* 1327 */         i++;
/* 1328 */         if (!setSchema(rs, i))
/*      */         {
/* 1331 */           CError tError = new CError();
/* 1332 */           tError.moduleName = "LAIndexInfoNewDB";
/* 1333 */           tError.functionName = "getInfo";
/* 1334 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/* 1335 */           this.mErrors.addOneError(tError);
/*      */           try {
/* 1337 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/* 1340 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/* 1344 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/* 1348 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/* 1352 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/* 1355 */       if (i == 0)
/*      */       {
/* 1357 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1361 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/* 1365 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1371 */       CError tError = new CError();
/* 1372 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1373 */       tError.functionName = "getInfo";
/* 1374 */       tError.errorMessage = e.toString();
/* 1375 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1377 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/* 1380 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1384 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/* 1388 */       return false;
/*      */     }
/*      */ 
/* 1391 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1395 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/* 1400 */     return true;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoNewSet query()
/*      */   {
/* 1405 */     Statement stmt = null;
/* 1406 */     ResultSet rs = null;
/* 1407 */     LAIndexInfoNewSet aLAIndexInfoNewSet = new LAIndexInfoNewSet();
/*      */ 
/* 1409 */     if (!this.mflag) {
/* 1410 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1415 */       stmt = this.con.createStatement(1003, 1007);
/* 1416 */       SQLString sqlObj = new SQLString("LAIndexInfoNew");
/* 1417 */       LAIndexInfoNewSchema aSchema = getSchema();
/* 1418 */       sqlObj.setSQL(5, aSchema);
/* 1419 */       String sql = sqlObj.getSQL();
/*      */ 
/* 1421 */       rs = stmt.executeQuery(sql);
/* 1422 */       int i = 0;
/* 1423 */       while (rs.next())
/*      */       {
/* 1425 */         i++;
/* 1426 */         LAIndexInfoNewSchema s1 = new LAIndexInfoNewSchema();
/* 1427 */         s1.setSchema(rs, i);
/* 1428 */         aLAIndexInfoNewSet.add(s1);
/*      */       }try {
/* 1430 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1436 */       CError tError = new CError();
/* 1437 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1438 */       tError.functionName = "query";
/* 1439 */       tError.errorMessage = e.toString();
/* 1440 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1442 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1445 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1449 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1455 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1459 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1464 */     return aLAIndexInfoNewSet;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoNewSet executeQuery(String sql)
/*      */   {
/* 1469 */     Statement stmt = null;
/* 1470 */     ResultSet rs = null;
/* 1471 */     LAIndexInfoNewSet aLAIndexInfoNewSet = new LAIndexInfoNewSet();
/*      */ 
/* 1473 */     if (!this.mflag) {
/* 1474 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1479 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1481 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1482 */       int i = 0;
/* 1483 */       while (rs.next())
/*      */       {
/* 1485 */         i++;
/* 1486 */         LAIndexInfoNewSchema s1 = new LAIndexInfoNewSchema();
/* 1487 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1490 */           CError tError = new CError();
/* 1491 */           tError.moduleName = "LAIndexInfoNewDB";
/* 1492 */           tError.functionName = "executeQuery";
/* 1493 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 1494 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1496 */         aLAIndexInfoNewSet.add(s1);
/*      */       }try {
/* 1498 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1504 */       CError tError = new CError();
/* 1505 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1506 */       tError.functionName = "executeQuery";
/* 1507 */       tError.errorMessage = e.toString();
/* 1508 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1510 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1513 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1517 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1523 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1527 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1532 */     return aLAIndexInfoNewSet;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoNewSet query(int nStart, int nCount)
/*      */   {
/* 1537 */     Statement stmt = null;
/* 1538 */     ResultSet rs = null;
/* 1539 */     LAIndexInfoNewSet aLAIndexInfoNewSet = new LAIndexInfoNewSet();
/*      */ 
/* 1541 */     if (!this.mflag) {
/* 1542 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1547 */       stmt = this.con.createStatement(1003, 1007);
/* 1548 */       SQLString sqlObj = new SQLString("LAIndexInfoNew");
/* 1549 */       LAIndexInfoNewSchema aSchema = getSchema();
/* 1550 */       sqlObj.setSQL(5, aSchema);
/* 1551 */       String sql = sqlObj.getSQL();
/*      */ 
/* 1553 */       rs = stmt.executeQuery(sql);
/* 1554 */       int i = 0;
/* 1555 */       while (rs.next())
/*      */       {
/* 1557 */         i++;
/*      */ 
/* 1559 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1563 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1567 */         LAIndexInfoNewSchema s1 = new LAIndexInfoNewSchema();
/* 1568 */         s1.setSchema(rs, i);
/* 1569 */         aLAIndexInfoNewSet.add(s1);
/*      */       }try {
/* 1571 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1577 */       CError tError = new CError();
/* 1578 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1579 */       tError.functionName = "query";
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
/* 1605 */     return aLAIndexInfoNewSet;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoNewSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/* 1610 */     Statement stmt = null;
/* 1611 */     ResultSet rs = null;
/* 1612 */     LAIndexInfoNewSet aLAIndexInfoNewSet = new LAIndexInfoNewSet();
/*      */ 
/* 1614 */     if (!this.mflag) {
/* 1615 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1620 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1622 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1623 */       int i = 0;
/* 1624 */       while (rs.next())
/*      */       {
/* 1626 */         i++;
/*      */ 
/* 1628 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1632 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1636 */         LAIndexInfoNewSchema s1 = new LAIndexInfoNewSchema();
/* 1637 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1640 */           CError tError = new CError();
/* 1641 */           tError.moduleName = "LAIndexInfoNewDB";
/* 1642 */           tError.functionName = "executeQuery";
/* 1643 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 1644 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1646 */         aLAIndexInfoNewSet.add(s1);
/*      */       }try {
/* 1648 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1654 */       CError tError = new CError();
/* 1655 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1656 */       tError.functionName = "executeQuery";
/* 1657 */       tError.errorMessage = e.toString();
/* 1658 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1660 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1663 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1667 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1673 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1677 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1682 */     return aLAIndexInfoNewSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1687 */     Statement stmt = null;
/*      */ 
/* 1689 */     if (!this.mflag) {
/* 1690 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1695 */       stmt = this.con.createStatement(1003, 1007);
/* 1696 */       SQLString sqlObj = new SQLString("LAIndexInfoNew");
/* 1697 */       LAIndexInfoNewSchema aSchema = getSchema();
/* 1698 */       sqlObj.setSQL(2, aSchema);
/* 1699 */       String sql = "update LAIndexInfoNew " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1701 */       int operCount = stmt.executeUpdate(sql);
/* 1702 */       if (operCount == 0)
/*      */       {
/* 1705 */         CError tError = new CError();
/* 1706 */         tError.moduleName = "LAIndexInfoNewDB";
/* 1707 */         tError.functionName = "update";
/* 1708 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/* 1709 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1711 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1715 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1719 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1725 */       CError tError = new CError();
/* 1726 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1727 */       tError.functionName = "update";
/* 1728 */       tError.errorMessage = e.toString();
/* 1729 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1731 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1733 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1737 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1741 */       return false;
/*      */     }
/*      */ 
/* 1744 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1748 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1753 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1759 */     if (this.mResultSet != null)
/*      */     {
/* 1762 */       CError tError = new CError();
/* 1763 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1764 */       tError.functionName = "prepareData";
/* 1765 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 1766 */       this.mErrors.addOneError(tError);
/* 1767 */       return false;
/*      */     }
/*      */ 
/* 1770 */     if (!this.mflag)
/*      */     {
/* 1772 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1776 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1777 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1782 */       CError tError = new CError();
/* 1783 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1784 */       tError.functionName = "prepareData";
/* 1785 */       tError.errorMessage = e.toString();
/* 1786 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1789 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1795 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1799 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1803 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1808 */       return false;
/*      */     }
/*      */ 
/* 1811 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1815 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1820 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1826 */     boolean flag = true;
/* 1827 */     if (this.mResultSet == null)
/*      */     {
/* 1829 */       CError tError = new CError();
/* 1830 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1831 */       tError.functionName = "hasMoreData";
/* 1832 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1833 */       this.mErrors.addOneError(tError);
/* 1834 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1838 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1842 */       CError tError = new CError();
/* 1843 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1844 */       tError.functionName = "hasMoreData";
/* 1845 */       tError.errorMessage = ex.toString();
/* 1846 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1849 */         this.mResultSet.close();
/* 1850 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1856 */         this.mStatement.close();
/* 1857 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1861 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1865 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1870 */       return false;
/*      */     }
/* 1872 */     return flag;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoNewSet getData()
/*      */   {
/* 1877 */     int tCount = 0;
/* 1878 */     LAIndexInfoNewSet tLAIndexInfoNewSet = new LAIndexInfoNewSet();
/* 1879 */     LAIndexInfoNewSchema tLAIndexInfoNewSchema = null;
/* 1880 */     if (this.mResultSet == null)
/*      */     {
/* 1882 */       CError tError = new CError();
/* 1883 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1884 */       tError.functionName = "getData";
/* 1885 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1886 */       this.mErrors.addOneError(tError);
/* 1887 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1891 */       tCount = 1;
/* 1892 */       tLAIndexInfoNewSchema = new LAIndexInfoNewSchema();
/* 1893 */       tLAIndexInfoNewSchema.setSchema(this.mResultSet, 1);
/* 1894 */       tLAIndexInfoNewSet.add(tLAIndexInfoNewSchema);
/*      */ 
/* 1896 */       while (tCount++ < 5000)
/*      */       {
/* 1898 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1900 */         tLAIndexInfoNewSchema = new LAIndexInfoNewSchema();
/* 1901 */         tLAIndexInfoNewSchema.setSchema(this.mResultSet, 1);
/* 1902 */         tLAIndexInfoNewSet.add(tLAIndexInfoNewSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1908 */       CError tError = new CError();
/* 1909 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1910 */       tError.functionName = "getData";
/* 1911 */       tError.errorMessage = ex.toString();
/* 1912 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1915 */         this.mResultSet.close();
/* 1916 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1922 */         this.mStatement.close();
/* 1923 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1927 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1931 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1936 */       return null;
/*      */     }
/* 1938 */     return tLAIndexInfoNewSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1943 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1946 */       if (this.mResultSet == null)
/*      */       {
/* 1948 */         CError tError = new CError();
/* 1949 */         tError.moduleName = "LAIndexInfoNewDB";
/* 1950 */         tError.functionName = "closeData";
/* 1951 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1952 */         this.mErrors.addOneError(tError);
/* 1953 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1957 */         this.mResultSet.close();
/* 1958 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1963 */       CError tError = new CError();
/* 1964 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1965 */       tError.functionName = "closeData";
/* 1966 */       tError.errorMessage = ex2.toString();
/* 1967 */       this.mErrors.addOneError(tError);
/* 1968 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1972 */       if (this.mStatement == null)
/*      */       {
/* 1974 */         CError tError = new CError();
/* 1975 */         tError.moduleName = "LAIndexInfoNewDB";
/* 1976 */         tError.functionName = "closeData";
/* 1977 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1978 */         this.mErrors.addOneError(tError);
/* 1979 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1983 */         this.mStatement.close();
/* 1984 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1989 */       CError tError = new CError();
/* 1990 */       tError.moduleName = "LAIndexInfoNewDB";
/* 1991 */       tError.functionName = "closeData";
/* 1992 */       tError.errorMessage = ex3.toString();
/* 1993 */       this.mErrors.addOneError(tError);
/* 1994 */       flag = false;
/*      */     }
/* 1996 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.LAIndexInfoNewDB
 * JD-Core Version:    0.6.0
 */