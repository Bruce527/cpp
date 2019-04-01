/*      */ package com.sinosoft.map.lis.vdb;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.LAIndexInfoNewSchema;
/*      */ import com.sinosoft.map.lis.vschema.LAIndexInfoNewSet;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.DBConnPool;
/*      */ import com.sinosoft.map.utility.DBOper;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ 
/*      */ public class LAIndexInfoNewDBSet extends LAIndexInfoNewSet
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*      */   public LAIndexInfoNewDBSet(Connection tConnection)
/*      */   {
/*   27 */     this.con = tConnection;
/*   28 */     this.db = new DBOper(this.con, "LAIndexInfoNew");
/*   29 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoNewDBSet()
/*      */   {
/*   34 */     this.db = new DBOper("LAIndexInfoNew");
/*   35 */     this.con = this.db.getConnection();
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   40 */     if (this.db.deleteSQL(this))
/*      */     {
/*   42 */       return true;
/*      */     }
/*      */ 
/*   47 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   48 */     CError tError = new CError();
/*   49 */     tError.moduleName = "LAIndexInfoNewDBSet";
/*   50 */     tError.functionName = "deleteSQL";
/*   51 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   52 */     this.mErrors.addOneError(tError);
/*   53 */     return false;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   60 */     PreparedStatement pstmt = null;
/*      */ 
/*   62 */     if (!this.mflag) {
/*   63 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   68 */       int tCount = size();
/*   69 */       pstmt = this.con.prepareStatement("DELETE FROM LAIndexInfoNew WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
/*   70 */       for (int i = 1; i <= tCount; i++)
/*      */       {
/*   72 */         if ((get(i).getIndexCalNo() == null) || (get(i).getIndexCalNo().equals("null")))
/*   73 */           pstmt.setString(1, null);
/*      */         else {
/*   75 */           pstmt.setString(1, get(i).getIndexCalNo());
/*      */         }
/*   77 */         if ((get(i).getIndexType() == null) || (get(i).getIndexType().equals("null")))
/*   78 */           pstmt.setString(2, null);
/*      */         else {
/*   80 */           pstmt.setString(2, get(i).getIndexType());
/*      */         }
/*   82 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*   83 */           pstmt.setString(3, null);
/*      */         else {
/*   85 */           pstmt.setString(3, get(i).getAgentCode());
/*      */         }
/*   87 */         pstmt.addBatch();
/*      */       }
/*   89 */       pstmt.executeBatch();
/*   90 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*   93 */       ex.printStackTrace();
/*   94 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   95 */       CError tError = new CError();
/*   96 */       tError.moduleName = "LAIndexInfoNewDBSet";
/*   97 */       tError.functionName = "delete()";
/*   98 */       tError.errorMessage = ex.toString();
/*   99 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  102 */         pstmt.close(); } catch (Exception e) {
/*  103 */         e.printStackTrace();
/*      */       }
/*  105 */       if (!this.mflag) {
/*      */         try {
/*  107 */           this.con.close(); } catch (Exception e) {
/*  108 */           e.printStackTrace();
/*      */         }
/*      */       }
/*  111 */       return false;
/*      */     }
/*      */ 
/*  114 */     if (!this.mflag) {
/*      */       try {
/*  116 */         this.con.close(); } catch (Exception e) {
/*  117 */         e.printStackTrace();
/*      */       }
/*      */     }
/*  120 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  126 */     PreparedStatement pstmt = null;
/*      */ 
/*  128 */     if (!this.mflag) {
/*  129 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  134 */       int tCount = size();
/*  135 */       pstmt = this.con.prepareStatement("UPDATE LAIndexInfoNew SET  IndexCalNo = ? , IndexType = ? , ManageCom = ? , AgentGroup = ? , BranchAttr = ? , AgentCode = ? , AgentGrade = ? , AgentTitle = ? , QuaBgnMark = ? , PostMonths = ? , AssessMonth = ? , AgentGrade1 = ? , AgentTitle1 = ? , AgentGrade2 = ? , AgentTitle2 = ? , AgentGrade3 = ? , AgentTitle3 = ? , StartDate = ? , StartEnd = ? , StartDate1 = ? , StartEnd1 = ? , StartDate2 = ? , StartEnd2 = ? , StartDate3 = ? , StartEnd3 = ? , StartEnd4 = ? , StartDate4 = ? , ServerMonths = ? , NT01 = ? , NT02 = ? , NT03 = ? , NT04 = ? , NT05 = ? , NT06 = ? , NT07 = ? , NT08 = ? , NT09 = ? , NT10 = ? , NT11 = ? , NT12 = ? , NT13 = ? , NT14 = ? , NT15 = ? , NT16 = ? , NT17 = ? , NT18 = ? , NT19 = ? , NT20 = ? , NT21 = ? , NT22 = ? , NT23 = ? , NT24 = ? , NT25 = ? , NT26 = ? , NT27 = ? , NT28 = ? , NT29 = ? , NT30 = ? , NT31 = ? , NT32 = ? , NT33 = ? , NT34 = ? , NT35 = ? , NT36 = ? , NT37 = ? , NT38 = ? , NT39 = ? , NT40 = ? , NT41 = ? , NT42 = ? , NT43 = ? , NT44 = ? , NT45 = ? , NT46 = ? , NT47 = ? , NT48 = ? , NT49 = ? , NT50 = ? , NT51 = ? , NT52 = ? , NT53 = ? , NT54 = ? , NT55 = ? , NT56 = ? , NT57 = ? , NT58 = ? , NT59 = ? , NT60 = ? , NT61 = ? , NT62 = ? , NT63 = ? , NT64 = ? , NT65 = ? , NT66 = ? , NT67 = ? , NT68 = ? , NT69 = ? , NT70 = ? , NT71 = ? , NT72 = ? , NT73 = ? , NT74 = ? , NT75 = ? , NT76 = ? , NT77 = ? , NT78 = ? , NT79 = ? , NT80 = ? , NF01 = ? , NF02 = ? , NF03 = ? , NF04 = ? , NF05 = ? , NF06 = ? , NF07 = ? , NF08 = ? , NF09 = ? , NF10 = ? , NS01 = ? , NS02 = ? , NS03 = ? , NS04 = ? , NS05 = ? , NS06 = ? , NS07 = ? , NS08 = ? , NS09 = ? , NS10 = ? , INT01 = ? , INT02 = ? , INT03 = ? , INT04 = ? , INT05 = ? , INT06 = ? , INT07 = ? , INT08 = ? , INT09 = ? , INT10 = ? , INT11 = ? , INT12 = ? , INT13 = ? , INT14 = ? , INT15 = ? , INT16 = ? , INT17 = ? , INT18 = ? , INT19 = ? , INT20 = ? , INT21 = ? , INT22 = ? , INT23 = ? , INT24 = ? , INT25 = ? , V1 = ? , V2 = ? , V3 = ? , V4 = ? , V5 = ? , V6 = ? , V7 = ? , V8 = ? , V9 = ? , V10 = ? , V11 = ? , V12 = ? , V13 = ? , V14 = ? , V15 = ? , V16 = ? , V17 = ? , V18 = ? , V19 = ? , V20 = ? , VT1 = ? , VT2 = ? , VT3 = ? , VT4 = ? , VT5 = ? , VT6 = ? , VT7 = ? , VT8 = ? , VE1 = ? , VE2 = ? , VE3 = ? , VE4 = ? , VE5 = ? , VE6 = ? , VE7 = ? , VE8 = ? , VE9 = ? , VE10 = ? , D1 = ? , D2 = ? , D3 = ? , D4 = ? , D5 = ? , D6 = ? , D7 = ? , D8 = ? , D9 = ? , D10 = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
/*  136 */       for (int i = 1; i <= tCount; i++)
/*      */       {
/*  138 */         if ((get(i).getIndexCalNo() == null) || (get(i).getIndexCalNo().equals("null")))
/*  139 */           pstmt.setString(1, null);
/*      */         else {
/*  141 */           pstmt.setString(1, get(i).getIndexCalNo());
/*      */         }
/*  143 */         if ((get(i).getIndexType() == null) || (get(i).getIndexType().equals("null")))
/*  144 */           pstmt.setString(2, null);
/*      */         else {
/*  146 */           pstmt.setString(2, get(i).getIndexType());
/*      */         }
/*  148 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/*  149 */           pstmt.setString(3, null);
/*      */         else {
/*  151 */           pstmt.setString(3, get(i).getManageCom());
/*      */         }
/*  153 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/*  154 */           pstmt.setString(4, null);
/*      */         else {
/*  156 */           pstmt.setString(4, get(i).getAgentGroup());
/*      */         }
/*  158 */         if ((get(i).getBranchAttr() == null) || (get(i).getBranchAttr().equals("null")))
/*  159 */           pstmt.setString(5, null);
/*      */         else {
/*  161 */           pstmt.setString(5, get(i).getBranchAttr());
/*      */         }
/*  163 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*  164 */           pstmt.setString(6, null);
/*      */         else {
/*  166 */           pstmt.setString(6, get(i).getAgentCode());
/*      */         }
/*  168 */         if ((get(i).getAgentGrade() == null) || (get(i).getAgentGrade().equals("null")))
/*  169 */           pstmt.setString(7, null);
/*      */         else {
/*  171 */           pstmt.setString(7, get(i).getAgentGrade());
/*      */         }
/*  173 */         if ((get(i).getAgentTitle() == null) || (get(i).getAgentTitle().equals("null")))
/*  174 */           pstmt.setString(8, null);
/*      */         else {
/*  176 */           pstmt.setString(8, get(i).getAgentTitle());
/*      */         }
/*  178 */         pstmt.setInt(9, get(i).getQuaBgnMark());
/*  179 */         pstmt.setInt(10, get(i).getPostMonths());
/*  180 */         if ((get(i).getAssessMonth() == null) || (get(i).getAssessMonth().equals("null")))
/*  181 */           pstmt.setString(11, null);
/*      */         else {
/*  183 */           pstmt.setString(11, get(i).getAssessMonth());
/*      */         }
/*  185 */         if ((get(i).getAgentGrade1() == null) || (get(i).getAgentGrade1().equals("null")))
/*  186 */           pstmt.setString(12, null);
/*      */         else {
/*  188 */           pstmt.setString(12, get(i).getAgentGrade1());
/*      */         }
/*  190 */         if ((get(i).getAgentTitle1() == null) || (get(i).getAgentTitle1().equals("null")))
/*  191 */           pstmt.setString(13, null);
/*      */         else {
/*  193 */           pstmt.setString(13, get(i).getAgentTitle1());
/*      */         }
/*  195 */         if ((get(i).getAgentGrade2() == null) || (get(i).getAgentGrade2().equals("null")))
/*  196 */           pstmt.setString(14, null);
/*      */         else {
/*  198 */           pstmt.setString(14, get(i).getAgentGrade2());
/*      */         }
/*  200 */         if ((get(i).getAgentTitle2() == null) || (get(i).getAgentTitle2().equals("null")))
/*  201 */           pstmt.setString(15, null);
/*      */         else {
/*  203 */           pstmt.setString(15, get(i).getAgentTitle2());
/*      */         }
/*  205 */         if ((get(i).getAgentGrade3() == null) || (get(i).getAgentGrade3().equals("null")))
/*  206 */           pstmt.setString(16, null);
/*      */         else {
/*  208 */           pstmt.setString(16, get(i).getAgentGrade3());
/*      */         }
/*  210 */         if ((get(i).getAgentTitle3() == null) || (get(i).getAgentTitle3().equals("null")))
/*  211 */           pstmt.setString(17, null);
/*      */         else {
/*  213 */           pstmt.setString(17, get(i).getAgentTitle3());
/*      */         }
/*  215 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/*  216 */           pstmt.setDate(18, null);
/*      */         else {
/*  218 */           pstmt.setDate(18, Date.valueOf(get(i).getStartDate()));
/*      */         }
/*  220 */         if ((get(i).getStartEnd() == null) || (get(i).getStartEnd().equals("null")))
/*  221 */           pstmt.setDate(19, null);
/*      */         else {
/*  223 */           pstmt.setDate(19, Date.valueOf(get(i).getStartEnd()));
/*      */         }
/*  225 */         if ((get(i).getStartDate1() == null) || (get(i).getStartDate1().equals("null")))
/*  226 */           pstmt.setDate(20, null);
/*      */         else {
/*  228 */           pstmt.setDate(20, Date.valueOf(get(i).getStartDate1()));
/*      */         }
/*  230 */         if ((get(i).getStartEnd1() == null) || (get(i).getStartEnd1().equals("null")))
/*  231 */           pstmt.setDate(21, null);
/*      */         else {
/*  233 */           pstmt.setDate(21, Date.valueOf(get(i).getStartEnd1()));
/*      */         }
/*  235 */         if ((get(i).getStartDate2() == null) || (get(i).getStartDate2().equals("null")))
/*  236 */           pstmt.setDate(22, null);
/*      */         else {
/*  238 */           pstmt.setDate(22, Date.valueOf(get(i).getStartDate2()));
/*      */         }
/*  240 */         if ((get(i).getStartEnd2() == null) || (get(i).getStartEnd2().equals("null")))
/*  241 */           pstmt.setDate(23, null);
/*      */         else {
/*  243 */           pstmt.setDate(23, Date.valueOf(get(i).getStartEnd2()));
/*      */         }
/*  245 */         if ((get(i).getStartDate3() == null) || (get(i).getStartDate3().equals("null")))
/*  246 */           pstmt.setDate(24, null);
/*      */         else {
/*  248 */           pstmt.setDate(24, Date.valueOf(get(i).getStartDate3()));
/*      */         }
/*  250 */         if ((get(i).getStartEnd3() == null) || (get(i).getStartEnd3().equals("null")))
/*  251 */           pstmt.setDate(25, null);
/*      */         else {
/*  253 */           pstmt.setDate(25, Date.valueOf(get(i).getStartEnd3()));
/*      */         }
/*  255 */         if ((get(i).getStartEnd4() == null) || (get(i).getStartEnd4().equals("null")))
/*  256 */           pstmt.setDate(26, null);
/*      */         else {
/*  258 */           pstmt.setDate(26, Date.valueOf(get(i).getStartEnd4()));
/*      */         }
/*  260 */         if ((get(i).getStartDate4() == null) || (get(i).getStartDate4().equals("null")))
/*  261 */           pstmt.setDate(27, null);
/*      */         else {
/*  263 */           pstmt.setDate(27, Date.valueOf(get(i).getStartDate4()));
/*      */         }
/*  265 */         pstmt.setInt(28, get(i).getServerMonths());
/*  266 */         pstmt.setDouble(29, get(i).getNT01());
/*  267 */         pstmt.setDouble(30, get(i).getNT02());
/*  268 */         pstmt.setDouble(31, get(i).getNT03());
/*  269 */         pstmt.setDouble(32, get(i).getNT04());
/*  270 */         pstmt.setDouble(33, get(i).getNT05());
/*  271 */         pstmt.setDouble(34, get(i).getNT06());
/*  272 */         pstmt.setDouble(35, get(i).getNT07());
/*  273 */         pstmt.setDouble(36, get(i).getNT08());
/*  274 */         pstmt.setDouble(37, get(i).getNT09());
/*  275 */         pstmt.setDouble(38, get(i).getNT10());
/*  276 */         pstmt.setDouble(39, get(i).getNT11());
/*  277 */         pstmt.setDouble(40, get(i).getNT12());
/*  278 */         pstmt.setDouble(41, get(i).getNT13());
/*  279 */         pstmt.setDouble(42, get(i).getNT14());
/*  280 */         pstmt.setDouble(43, get(i).getNT15());
/*  281 */         pstmt.setDouble(44, get(i).getNT16());
/*  282 */         pstmt.setDouble(45, get(i).getNT17());
/*  283 */         pstmt.setDouble(46, get(i).getNT18());
/*  284 */         pstmt.setDouble(47, get(i).getNT19());
/*  285 */         pstmt.setDouble(48, get(i).getNT20());
/*  286 */         pstmt.setDouble(49, get(i).getNT21());
/*  287 */         pstmt.setDouble(50, get(i).getNT22());
/*  288 */         pstmt.setDouble(51, get(i).getNT23());
/*  289 */         pstmt.setDouble(52, get(i).getNT24());
/*  290 */         pstmt.setDouble(53, get(i).getNT25());
/*  291 */         pstmt.setDouble(54, get(i).getNT26());
/*  292 */         pstmt.setDouble(55, get(i).getNT27());
/*  293 */         pstmt.setDouble(56, get(i).getNT28());
/*  294 */         pstmt.setDouble(57, get(i).getNT29());
/*  295 */         pstmt.setDouble(58, get(i).getNT30());
/*  296 */         pstmt.setDouble(59, get(i).getNT31());
/*  297 */         pstmt.setDouble(60, get(i).getNT32());
/*  298 */         pstmt.setDouble(61, get(i).getNT33());
/*  299 */         pstmt.setDouble(62, get(i).getNT34());
/*  300 */         pstmt.setDouble(63, get(i).getNT35());
/*  301 */         pstmt.setDouble(64, get(i).getNT36());
/*  302 */         pstmt.setDouble(65, get(i).getNT37());
/*  303 */         pstmt.setDouble(66, get(i).getNT38());
/*  304 */         pstmt.setDouble(67, get(i).getNT39());
/*  305 */         pstmt.setDouble(68, get(i).getNT40());
/*  306 */         pstmt.setDouble(69, get(i).getNT41());
/*  307 */         pstmt.setDouble(70, get(i).getNT42());
/*  308 */         pstmt.setDouble(71, get(i).getNT43());
/*  309 */         pstmt.setDouble(72, get(i).getNT44());
/*  310 */         pstmt.setDouble(73, get(i).getNT45());
/*  311 */         pstmt.setDouble(74, get(i).getNT46());
/*  312 */         pstmt.setDouble(75, get(i).getNT47());
/*  313 */         pstmt.setDouble(76, get(i).getNT48());
/*  314 */         pstmt.setDouble(77, get(i).getNT49());
/*  315 */         pstmt.setDouble(78, get(i).getNT50());
/*  316 */         pstmt.setDouble(79, get(i).getNT51());
/*  317 */         pstmt.setDouble(80, get(i).getNT52());
/*  318 */         pstmt.setDouble(81, get(i).getNT53());
/*  319 */         pstmt.setDouble(82, get(i).getNT54());
/*  320 */         pstmt.setDouble(83, get(i).getNT55());
/*  321 */         pstmt.setDouble(84, get(i).getNT56());
/*  322 */         pstmt.setDouble(85, get(i).getNT57());
/*  323 */         pstmt.setDouble(86, get(i).getNT58());
/*  324 */         pstmt.setDouble(87, get(i).getNT59());
/*  325 */         pstmt.setDouble(88, get(i).getNT60());
/*  326 */         pstmt.setDouble(89, get(i).getNT61());
/*  327 */         pstmt.setDouble(90, get(i).getNT62());
/*  328 */         pstmt.setDouble(91, get(i).getNT63());
/*  329 */         pstmt.setDouble(92, get(i).getNT64());
/*  330 */         pstmt.setDouble(93, get(i).getNT65());
/*  331 */         pstmt.setDouble(94, get(i).getNT66());
/*  332 */         pstmt.setDouble(95, get(i).getNT67());
/*  333 */         pstmt.setDouble(96, get(i).getNT68());
/*  334 */         pstmt.setDouble(97, get(i).getNT69());
/*  335 */         pstmt.setDouble(98, get(i).getNT70());
/*  336 */         pstmt.setDouble(99, get(i).getNT71());
/*  337 */         pstmt.setDouble(100, get(i).getNT72());
/*  338 */         pstmt.setDouble(101, get(i).getNT73());
/*  339 */         pstmt.setDouble(102, get(i).getNT74());
/*  340 */         pstmt.setDouble(103, get(i).getNT75());
/*  341 */         pstmt.setDouble(104, get(i).getNT76());
/*  342 */         pstmt.setDouble(105, get(i).getNT77());
/*  343 */         pstmt.setDouble(106, get(i).getNT78());
/*  344 */         pstmt.setDouble(107, get(i).getNT79());
/*  345 */         pstmt.setDouble(108, get(i).getNT80());
/*  346 */         pstmt.setDouble(109, get(i).getNF01());
/*  347 */         pstmt.setDouble(110, get(i).getNF02());
/*  348 */         pstmt.setDouble(111, get(i).getNF03());
/*  349 */         pstmt.setDouble(112, get(i).getNF04());
/*  350 */         pstmt.setDouble(113, get(i).getNF05());
/*  351 */         pstmt.setDouble(114, get(i).getNF06());
/*  352 */         pstmt.setDouble(115, get(i).getNF07());
/*  353 */         pstmt.setDouble(116, get(i).getNF08());
/*  354 */         pstmt.setDouble(117, get(i).getNF09());
/*  355 */         pstmt.setDouble(118, get(i).getNF10());
/*  356 */         pstmt.setDouble(119, get(i).getNS01());
/*  357 */         pstmt.setDouble(120, get(i).getNS02());
/*  358 */         pstmt.setDouble(121, get(i).getNS03());
/*  359 */         pstmt.setDouble(122, get(i).getNS04());
/*  360 */         pstmt.setDouble(123, get(i).getNS05());
/*  361 */         pstmt.setDouble(124, get(i).getNS06());
/*  362 */         pstmt.setDouble(125, get(i).getNS07());
/*  363 */         pstmt.setDouble(126, get(i).getNS08());
/*  364 */         pstmt.setDouble(127, get(i).getNS09());
/*  365 */         pstmt.setDouble(128, get(i).getNS10());
/*  366 */         pstmt.setInt(129, get(i).getINT01());
/*  367 */         pstmt.setInt(130, get(i).getINT02());
/*  368 */         pstmt.setInt(131, get(i).getINT03());
/*  369 */         pstmt.setInt(132, get(i).getINT04());
/*  370 */         pstmt.setInt(133, get(i).getINT05());
/*  371 */         pstmt.setInt(134, get(i).getINT06());
/*  372 */         pstmt.setInt(135, get(i).getINT07());
/*  373 */         pstmt.setInt(136, get(i).getINT08());
/*  374 */         pstmt.setInt(137, get(i).getINT09());
/*  375 */         pstmt.setInt(138, get(i).getINT10());
/*  376 */         pstmt.setInt(139, get(i).getINT11());
/*  377 */         pstmt.setInt(140, get(i).getINT12());
/*  378 */         pstmt.setInt(141, get(i).getINT13());
/*  379 */         pstmt.setInt(142, get(i).getINT14());
/*  380 */         pstmt.setInt(143, get(i).getINT15());
/*  381 */         pstmt.setInt(144, get(i).getINT16());
/*  382 */         pstmt.setInt(145, get(i).getINT17());
/*  383 */         pstmt.setInt(146, get(i).getINT18());
/*  384 */         pstmt.setInt(147, get(i).getINT19());
/*  385 */         pstmt.setInt(148, get(i).getINT20());
/*  386 */         pstmt.setInt(149, get(i).getINT21());
/*  387 */         pstmt.setInt(150, get(i).getINT22());
/*  388 */         pstmt.setInt(151, get(i).getINT23());
/*  389 */         pstmt.setInt(152, get(i).getINT24());
/*  390 */         pstmt.setInt(153, get(i).getINT25());
/*  391 */         if ((get(i).getV1() == null) || (get(i).getV1().equals("null")))
/*  392 */           pstmt.setString(154, null);
/*      */         else {
/*  394 */           pstmt.setString(154, get(i).getV1());
/*      */         }
/*  396 */         if ((get(i).getV2() == null) || (get(i).getV2().equals("null")))
/*  397 */           pstmt.setString(155, null);
/*      */         else {
/*  399 */           pstmt.setString(155, get(i).getV2());
/*      */         }
/*  401 */         if ((get(i).getV3() == null) || (get(i).getV3().equals("null")))
/*  402 */           pstmt.setString(156, null);
/*      */         else {
/*  404 */           pstmt.setString(156, get(i).getV3());
/*      */         }
/*  406 */         if ((get(i).getV4() == null) || (get(i).getV4().equals("null")))
/*  407 */           pstmt.setString(157, null);
/*      */         else {
/*  409 */           pstmt.setString(157, get(i).getV4());
/*      */         }
/*  411 */         if ((get(i).getV5() == null) || (get(i).getV5().equals("null")))
/*  412 */           pstmt.setString(158, null);
/*      */         else {
/*  414 */           pstmt.setString(158, get(i).getV5());
/*      */         }
/*  416 */         if ((get(i).getV6() == null) || (get(i).getV6().equals("null")))
/*  417 */           pstmt.setString(159, null);
/*      */         else {
/*  419 */           pstmt.setString(159, get(i).getV6());
/*      */         }
/*  421 */         if ((get(i).getV7() == null) || (get(i).getV7().equals("null")))
/*  422 */           pstmt.setString(160, null);
/*      */         else {
/*  424 */           pstmt.setString(160, get(i).getV7());
/*      */         }
/*  426 */         if ((get(i).getV8() == null) || (get(i).getV8().equals("null")))
/*  427 */           pstmt.setString(161, null);
/*      */         else {
/*  429 */           pstmt.setString(161, get(i).getV8());
/*      */         }
/*  431 */         if ((get(i).getV9() == null) || (get(i).getV9().equals("null")))
/*  432 */           pstmt.setString(162, null);
/*      */         else {
/*  434 */           pstmt.setString(162, get(i).getV9());
/*      */         }
/*  436 */         if ((get(i).getV10() == null) || (get(i).getV10().equals("null")))
/*  437 */           pstmt.setString(163, null);
/*      */         else {
/*  439 */           pstmt.setString(163, get(i).getV10());
/*      */         }
/*  441 */         if ((get(i).getV11() == null) || (get(i).getV11().equals("null")))
/*  442 */           pstmt.setString(164, null);
/*      */         else {
/*  444 */           pstmt.setString(164, get(i).getV11());
/*      */         }
/*  446 */         if ((get(i).getV12() == null) || (get(i).getV12().equals("null")))
/*  447 */           pstmt.setString(165, null);
/*      */         else {
/*  449 */           pstmt.setString(165, get(i).getV12());
/*      */         }
/*  451 */         if ((get(i).getV13() == null) || (get(i).getV13().equals("null")))
/*  452 */           pstmt.setString(166, null);
/*      */         else {
/*  454 */           pstmt.setString(166, get(i).getV13());
/*      */         }
/*  456 */         if ((get(i).getV14() == null) || (get(i).getV14().equals("null")))
/*  457 */           pstmt.setString(167, null);
/*      */         else {
/*  459 */           pstmt.setString(167, get(i).getV14());
/*      */         }
/*  461 */         if ((get(i).getV15() == null) || (get(i).getV15().equals("null")))
/*  462 */           pstmt.setString(168, null);
/*      */         else {
/*  464 */           pstmt.setString(168, get(i).getV15());
/*      */         }
/*  466 */         if ((get(i).getV16() == null) || (get(i).getV16().equals("null")))
/*  467 */           pstmt.setString(169, null);
/*      */         else {
/*  469 */           pstmt.setString(169, get(i).getV16());
/*      */         }
/*  471 */         if ((get(i).getV17() == null) || (get(i).getV17().equals("null")))
/*  472 */           pstmt.setString(170, null);
/*      */         else {
/*  474 */           pstmt.setString(170, get(i).getV17());
/*      */         }
/*  476 */         if ((get(i).getV18() == null) || (get(i).getV18().equals("null")))
/*  477 */           pstmt.setString(171, null);
/*      */         else {
/*  479 */           pstmt.setString(171, get(i).getV18());
/*      */         }
/*  481 */         if ((get(i).getV19() == null) || (get(i).getV19().equals("null")))
/*  482 */           pstmt.setString(172, null);
/*      */         else {
/*  484 */           pstmt.setString(172, get(i).getV19());
/*      */         }
/*  486 */         if ((get(i).getV20() == null) || (get(i).getV20().equals("null")))
/*  487 */           pstmt.setString(173, null);
/*      */         else {
/*  489 */           pstmt.setString(173, get(i).getV20());
/*      */         }
/*  491 */         if ((get(i).getVT1() == null) || (get(i).getVT1().equals("null")))
/*  492 */           pstmt.setString(174, null);
/*      */         else {
/*  494 */           pstmt.setString(174, get(i).getVT1());
/*      */         }
/*  496 */         if ((get(i).getVT2() == null) || (get(i).getVT2().equals("null")))
/*  497 */           pstmt.setString(175, null);
/*      */         else {
/*  499 */           pstmt.setString(175, get(i).getVT2());
/*      */         }
/*  501 */         if ((get(i).getVT3() == null) || (get(i).getVT3().equals("null")))
/*  502 */           pstmt.setString(176, null);
/*      */         else {
/*  504 */           pstmt.setString(176, get(i).getVT3());
/*      */         }
/*  506 */         if ((get(i).getVT4() == null) || (get(i).getVT4().equals("null")))
/*  507 */           pstmt.setString(177, null);
/*      */         else {
/*  509 */           pstmt.setString(177, get(i).getVT4());
/*      */         }
/*  511 */         if ((get(i).getVT5() == null) || (get(i).getVT5().equals("null")))
/*  512 */           pstmt.setString(178, null);
/*      */         else {
/*  514 */           pstmt.setString(178, get(i).getVT5());
/*      */         }
/*  516 */         if ((get(i).getVT6() == null) || (get(i).getVT6().equals("null")))
/*  517 */           pstmt.setString(179, null);
/*      */         else {
/*  519 */           pstmt.setString(179, get(i).getVT6());
/*      */         }
/*  521 */         if ((get(i).getVT7() == null) || (get(i).getVT7().equals("null")))
/*  522 */           pstmt.setString(180, null);
/*      */         else {
/*  524 */           pstmt.setString(180, get(i).getVT7());
/*      */         }
/*  526 */         if ((get(i).getVT8() == null) || (get(i).getVT8().equals("null")))
/*  527 */           pstmt.setString(181, null);
/*      */         else {
/*  529 */           pstmt.setString(181, get(i).getVT8());
/*      */         }
/*  531 */         if ((get(i).getVE1() == null) || (get(i).getVE1().equals("null")))
/*  532 */           pstmt.setString(182, null);
/*      */         else {
/*  534 */           pstmt.setString(182, get(i).getVE1());
/*      */         }
/*  536 */         if ((get(i).getVE2() == null) || (get(i).getVE2().equals("null")))
/*  537 */           pstmt.setString(183, null);
/*      */         else {
/*  539 */           pstmt.setString(183, get(i).getVE2());
/*      */         }
/*  541 */         if ((get(i).getVE3() == null) || (get(i).getVE3().equals("null")))
/*  542 */           pstmt.setString(184, null);
/*      */         else {
/*  544 */           pstmt.setString(184, get(i).getVE3());
/*      */         }
/*  546 */         if ((get(i).getVE4() == null) || (get(i).getVE4().equals("null")))
/*  547 */           pstmt.setString(185, null);
/*      */         else {
/*  549 */           pstmt.setString(185, get(i).getVE4());
/*      */         }
/*  551 */         if ((get(i).getVE5() == null) || (get(i).getVE5().equals("null")))
/*  552 */           pstmt.setString(186, null);
/*      */         else {
/*  554 */           pstmt.setString(186, get(i).getVE5());
/*      */         }
/*  556 */         if ((get(i).getVE6() == null) || (get(i).getVE6().equals("null")))
/*  557 */           pstmt.setString(187, null);
/*      */         else {
/*  559 */           pstmt.setString(187, get(i).getVE6());
/*      */         }
/*  561 */         if ((get(i).getVE7() == null) || (get(i).getVE7().equals("null")))
/*  562 */           pstmt.setString(188, null);
/*      */         else {
/*  564 */           pstmt.setString(188, get(i).getVE7());
/*      */         }
/*  566 */         if ((get(i).getVE8() == null) || (get(i).getVE8().equals("null")))
/*  567 */           pstmt.setString(189, null);
/*      */         else {
/*  569 */           pstmt.setString(189, get(i).getVE8());
/*      */         }
/*  571 */         if ((get(i).getVE9() == null) || (get(i).getVE9().equals("null")))
/*  572 */           pstmt.setString(190, null);
/*      */         else {
/*  574 */           pstmt.setString(190, get(i).getVE9());
/*      */         }
/*  576 */         if ((get(i).getVE10() == null) || (get(i).getVE10().equals("null")))
/*  577 */           pstmt.setString(191, null);
/*      */         else {
/*  579 */           pstmt.setString(191, get(i).getVE10());
/*      */         }
/*  581 */         if ((get(i).getD1() == null) || (get(i).getD1().equals("null")))
/*  582 */           pstmt.setDate(192, null);
/*      */         else {
/*  584 */           pstmt.setDate(192, Date.valueOf(get(i).getD1()));
/*      */         }
/*  586 */         if ((get(i).getD2() == null) || (get(i).getD2().equals("null")))
/*  587 */           pstmt.setDate(193, null);
/*      */         else {
/*  589 */           pstmt.setDate(193, Date.valueOf(get(i).getD2()));
/*      */         }
/*  591 */         if ((get(i).getD3() == null) || (get(i).getD3().equals("null")))
/*  592 */           pstmt.setDate(194, null);
/*      */         else {
/*  594 */           pstmt.setDate(194, Date.valueOf(get(i).getD3()));
/*      */         }
/*  596 */         if ((get(i).getD4() == null) || (get(i).getD4().equals("null")))
/*  597 */           pstmt.setDate(195, null);
/*      */         else {
/*  599 */           pstmt.setDate(195, Date.valueOf(get(i).getD4()));
/*      */         }
/*  601 */         if ((get(i).getD5() == null) || (get(i).getD5().equals("null")))
/*  602 */           pstmt.setDate(196, null);
/*      */         else {
/*  604 */           pstmt.setDate(196, Date.valueOf(get(i).getD5()));
/*      */         }
/*  606 */         if ((get(i).getD6() == null) || (get(i).getD6().equals("null")))
/*  607 */           pstmt.setDate(197, null);
/*      */         else {
/*  609 */           pstmt.setDate(197, Date.valueOf(get(i).getD6()));
/*      */         }
/*  611 */         if ((get(i).getD7() == null) || (get(i).getD7().equals("null")))
/*  612 */           pstmt.setDate(198, null);
/*      */         else {
/*  614 */           pstmt.setDate(198, Date.valueOf(get(i).getD7()));
/*      */         }
/*  616 */         if ((get(i).getD8() == null) || (get(i).getD8().equals("null")))
/*  617 */           pstmt.setDate(199, null);
/*      */         else {
/*  619 */           pstmt.setDate(199, Date.valueOf(get(i).getD8()));
/*      */         }
/*  621 */         if ((get(i).getD9() == null) || (get(i).getD9().equals("null")))
/*  622 */           pstmt.setDate(200, null);
/*      */         else {
/*  624 */           pstmt.setDate(200, Date.valueOf(get(i).getD9()));
/*      */         }
/*  626 */         if ((get(i).getD10() == null) || (get(i).getD10().equals("null")))
/*  627 */           pstmt.setDate(201, null);
/*      */         else {
/*  629 */           pstmt.setDate(201, Date.valueOf(get(i).getD10()));
/*      */         }
/*  631 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/*  632 */           pstmt.setString(202, null);
/*      */         else {
/*  634 */           pstmt.setString(202, get(i).getState());
/*      */         }
/*  636 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/*  637 */           pstmt.setString(203, null);
/*      */         else {
/*  639 */           pstmt.setString(203, get(i).getOperator());
/*      */         }
/*  641 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/*  642 */           pstmt.setDate(204, null);
/*      */         else {
/*  644 */           pstmt.setDate(204, Date.valueOf(get(i).getMakeDate()));
/*      */         }
/*  646 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/*  647 */           pstmt.setString(205, null);
/*      */         else {
/*  649 */           pstmt.setString(205, get(i).getMakeTime());
/*      */         }
/*  651 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/*  652 */           pstmt.setDate(206, null);
/*      */         else {
/*  654 */           pstmt.setDate(206, Date.valueOf(get(i).getModifyDate()));
/*      */         }
/*  656 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/*  657 */           pstmt.setString(207, null);
/*      */         else {
/*  659 */           pstmt.setString(207, get(i).getModifyTime());
/*      */         }
/*      */ 
/*  662 */         if ((get(i).getIndexCalNo() == null) || (get(i).getIndexCalNo().equals("null")))
/*  663 */           pstmt.setString(208, null);
/*      */         else {
/*  665 */           pstmt.setString(208, get(i).getIndexCalNo());
/*      */         }
/*  667 */         if ((get(i).getIndexType() == null) || (get(i).getIndexType().equals("null")))
/*  668 */           pstmt.setString(209, null);
/*      */         else {
/*  670 */           pstmt.setString(209, get(i).getIndexType());
/*      */         }
/*  672 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*  673 */           pstmt.setString(210, null);
/*      */         else {
/*  675 */           pstmt.setString(210, get(i).getAgentCode());
/*      */         }
/*  677 */         pstmt.addBatch();
/*      */       }
/*  679 */       pstmt.executeBatch();
/*  680 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  683 */       ex.printStackTrace();
/*  684 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  685 */       CError tError = new CError();
/*  686 */       tError.moduleName = "LAIndexInfoNewDBSet";
/*  687 */       tError.functionName = "update()";
/*  688 */       tError.errorMessage = ex.toString();
/*  689 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  692 */         pstmt.close(); } catch (Exception e) {
/*  693 */         e.printStackTrace();
/*      */       }
/*  695 */       if (!this.mflag) {
/*      */         try {
/*  697 */           this.con.close(); } catch (Exception e) {
/*  698 */           e.printStackTrace();
/*      */         }
/*      */       }
/*  701 */       return false;
/*      */     }
/*      */ 
/*  704 */     if (!this.mflag) {
/*      */       try {
/*  706 */         this.con.close(); } catch (Exception e) {
/*  707 */         e.printStackTrace();
/*      */       }
/*      */     }
/*  710 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  716 */     PreparedStatement pstmt = null;
/*      */ 
/*  718 */     if (!this.mflag) {
/*  719 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  724 */       int tCount = size();
/*  725 */       pstmt = this.con.prepareStatement("INSERT INTO LAIndexInfoNew VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  726 */       for (int i = 1; i <= tCount; i++)
/*      */       {
/*  728 */         if ((get(i).getIndexCalNo() == null) || (get(i).getIndexCalNo().equals("null")))
/*  729 */           pstmt.setString(1, null);
/*      */         else {
/*  731 */           pstmt.setString(1, get(i).getIndexCalNo());
/*      */         }
/*  733 */         if ((get(i).getIndexType() == null) || (get(i).getIndexType().equals("null")))
/*  734 */           pstmt.setString(2, null);
/*      */         else {
/*  736 */           pstmt.setString(2, get(i).getIndexType());
/*      */         }
/*  738 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/*  739 */           pstmt.setString(3, null);
/*      */         else {
/*  741 */           pstmt.setString(3, get(i).getManageCom());
/*      */         }
/*  743 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/*  744 */           pstmt.setString(4, null);
/*      */         else {
/*  746 */           pstmt.setString(4, get(i).getAgentGroup());
/*      */         }
/*  748 */         if ((get(i).getBranchAttr() == null) || (get(i).getBranchAttr().equals("null")))
/*  749 */           pstmt.setString(5, null);
/*      */         else {
/*  751 */           pstmt.setString(5, get(i).getBranchAttr());
/*      */         }
/*  753 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*  754 */           pstmt.setString(6, null);
/*      */         else {
/*  756 */           pstmt.setString(6, get(i).getAgentCode());
/*      */         }
/*  758 */         if ((get(i).getAgentGrade() == null) || (get(i).getAgentGrade().equals("null")))
/*  759 */           pstmt.setString(7, null);
/*      */         else {
/*  761 */           pstmt.setString(7, get(i).getAgentGrade());
/*      */         }
/*  763 */         if ((get(i).getAgentTitle() == null) || (get(i).getAgentTitle().equals("null")))
/*  764 */           pstmt.setString(8, null);
/*      */         else {
/*  766 */           pstmt.setString(8, get(i).getAgentTitle());
/*      */         }
/*  768 */         pstmt.setInt(9, get(i).getQuaBgnMark());
/*  769 */         pstmt.setInt(10, get(i).getPostMonths());
/*  770 */         if ((get(i).getAssessMonth() == null) || (get(i).getAssessMonth().equals("null")))
/*  771 */           pstmt.setString(11, null);
/*      */         else {
/*  773 */           pstmt.setString(11, get(i).getAssessMonth());
/*      */         }
/*  775 */         if ((get(i).getAgentGrade1() == null) || (get(i).getAgentGrade1().equals("null")))
/*  776 */           pstmt.setString(12, null);
/*      */         else {
/*  778 */           pstmt.setString(12, get(i).getAgentGrade1());
/*      */         }
/*  780 */         if ((get(i).getAgentTitle1() == null) || (get(i).getAgentTitle1().equals("null")))
/*  781 */           pstmt.setString(13, null);
/*      */         else {
/*  783 */           pstmt.setString(13, get(i).getAgentTitle1());
/*      */         }
/*  785 */         if ((get(i).getAgentGrade2() == null) || (get(i).getAgentGrade2().equals("null")))
/*  786 */           pstmt.setString(14, null);
/*      */         else {
/*  788 */           pstmt.setString(14, get(i).getAgentGrade2());
/*      */         }
/*  790 */         if ((get(i).getAgentTitle2() == null) || (get(i).getAgentTitle2().equals("null")))
/*  791 */           pstmt.setString(15, null);
/*      */         else {
/*  793 */           pstmt.setString(15, get(i).getAgentTitle2());
/*      */         }
/*  795 */         if ((get(i).getAgentGrade3() == null) || (get(i).getAgentGrade3().equals("null")))
/*  796 */           pstmt.setString(16, null);
/*      */         else {
/*  798 */           pstmt.setString(16, get(i).getAgentGrade3());
/*      */         }
/*  800 */         if ((get(i).getAgentTitle3() == null) || (get(i).getAgentTitle3().equals("null")))
/*  801 */           pstmt.setString(17, null);
/*      */         else {
/*  803 */           pstmt.setString(17, get(i).getAgentTitle3());
/*      */         }
/*  805 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/*  806 */           pstmt.setDate(18, null);
/*      */         else {
/*  808 */           pstmt.setDate(18, Date.valueOf(get(i).getStartDate()));
/*      */         }
/*  810 */         if ((get(i).getStartEnd() == null) || (get(i).getStartEnd().equals("null")))
/*  811 */           pstmt.setDate(19, null);
/*      */         else {
/*  813 */           pstmt.setDate(19, Date.valueOf(get(i).getStartEnd()));
/*      */         }
/*  815 */         if ((get(i).getStartDate1() == null) || (get(i).getStartDate1().equals("null")))
/*  816 */           pstmt.setDate(20, null);
/*      */         else {
/*  818 */           pstmt.setDate(20, Date.valueOf(get(i).getStartDate1()));
/*      */         }
/*  820 */         if ((get(i).getStartEnd1() == null) || (get(i).getStartEnd1().equals("null")))
/*  821 */           pstmt.setDate(21, null);
/*      */         else {
/*  823 */           pstmt.setDate(21, Date.valueOf(get(i).getStartEnd1()));
/*      */         }
/*  825 */         if ((get(i).getStartDate2() == null) || (get(i).getStartDate2().equals("null")))
/*  826 */           pstmt.setDate(22, null);
/*      */         else {
/*  828 */           pstmt.setDate(22, Date.valueOf(get(i).getStartDate2()));
/*      */         }
/*  830 */         if ((get(i).getStartEnd2() == null) || (get(i).getStartEnd2().equals("null")))
/*  831 */           pstmt.setDate(23, null);
/*      */         else {
/*  833 */           pstmt.setDate(23, Date.valueOf(get(i).getStartEnd2()));
/*      */         }
/*  835 */         if ((get(i).getStartDate3() == null) || (get(i).getStartDate3().equals("null")))
/*  836 */           pstmt.setDate(24, null);
/*      */         else {
/*  838 */           pstmt.setDate(24, Date.valueOf(get(i).getStartDate3()));
/*      */         }
/*  840 */         if ((get(i).getStartEnd3() == null) || (get(i).getStartEnd3().equals("null")))
/*  841 */           pstmt.setDate(25, null);
/*      */         else {
/*  843 */           pstmt.setDate(25, Date.valueOf(get(i).getStartEnd3()));
/*      */         }
/*  845 */         if ((get(i).getStartEnd4() == null) || (get(i).getStartEnd4().equals("null")))
/*  846 */           pstmt.setDate(26, null);
/*      */         else {
/*  848 */           pstmt.setDate(26, Date.valueOf(get(i).getStartEnd4()));
/*      */         }
/*  850 */         if ((get(i).getStartDate4() == null) || (get(i).getStartDate4().equals("null")))
/*  851 */           pstmt.setDate(27, null);
/*      */         else {
/*  853 */           pstmt.setDate(27, Date.valueOf(get(i).getStartDate4()));
/*      */         }
/*  855 */         pstmt.setInt(28, get(i).getServerMonths());
/*  856 */         pstmt.setDouble(29, get(i).getNT01());
/*  857 */         pstmt.setDouble(30, get(i).getNT02());
/*  858 */         pstmt.setDouble(31, get(i).getNT03());
/*  859 */         pstmt.setDouble(32, get(i).getNT04());
/*  860 */         pstmt.setDouble(33, get(i).getNT05());
/*  861 */         pstmt.setDouble(34, get(i).getNT06());
/*  862 */         pstmt.setDouble(35, get(i).getNT07());
/*  863 */         pstmt.setDouble(36, get(i).getNT08());
/*  864 */         pstmt.setDouble(37, get(i).getNT09());
/*  865 */         pstmt.setDouble(38, get(i).getNT10());
/*  866 */         pstmt.setDouble(39, get(i).getNT11());
/*  867 */         pstmt.setDouble(40, get(i).getNT12());
/*  868 */         pstmt.setDouble(41, get(i).getNT13());
/*  869 */         pstmt.setDouble(42, get(i).getNT14());
/*  870 */         pstmt.setDouble(43, get(i).getNT15());
/*  871 */         pstmt.setDouble(44, get(i).getNT16());
/*  872 */         pstmt.setDouble(45, get(i).getNT17());
/*  873 */         pstmt.setDouble(46, get(i).getNT18());
/*  874 */         pstmt.setDouble(47, get(i).getNT19());
/*  875 */         pstmt.setDouble(48, get(i).getNT20());
/*  876 */         pstmt.setDouble(49, get(i).getNT21());
/*  877 */         pstmt.setDouble(50, get(i).getNT22());
/*  878 */         pstmt.setDouble(51, get(i).getNT23());
/*  879 */         pstmt.setDouble(52, get(i).getNT24());
/*  880 */         pstmt.setDouble(53, get(i).getNT25());
/*  881 */         pstmt.setDouble(54, get(i).getNT26());
/*  882 */         pstmt.setDouble(55, get(i).getNT27());
/*  883 */         pstmt.setDouble(56, get(i).getNT28());
/*  884 */         pstmt.setDouble(57, get(i).getNT29());
/*  885 */         pstmt.setDouble(58, get(i).getNT30());
/*  886 */         pstmt.setDouble(59, get(i).getNT31());
/*  887 */         pstmt.setDouble(60, get(i).getNT32());
/*  888 */         pstmt.setDouble(61, get(i).getNT33());
/*  889 */         pstmt.setDouble(62, get(i).getNT34());
/*  890 */         pstmt.setDouble(63, get(i).getNT35());
/*  891 */         pstmt.setDouble(64, get(i).getNT36());
/*  892 */         pstmt.setDouble(65, get(i).getNT37());
/*  893 */         pstmt.setDouble(66, get(i).getNT38());
/*  894 */         pstmt.setDouble(67, get(i).getNT39());
/*  895 */         pstmt.setDouble(68, get(i).getNT40());
/*  896 */         pstmt.setDouble(69, get(i).getNT41());
/*  897 */         pstmt.setDouble(70, get(i).getNT42());
/*  898 */         pstmt.setDouble(71, get(i).getNT43());
/*  899 */         pstmt.setDouble(72, get(i).getNT44());
/*  900 */         pstmt.setDouble(73, get(i).getNT45());
/*  901 */         pstmt.setDouble(74, get(i).getNT46());
/*  902 */         pstmt.setDouble(75, get(i).getNT47());
/*  903 */         pstmt.setDouble(76, get(i).getNT48());
/*  904 */         pstmt.setDouble(77, get(i).getNT49());
/*  905 */         pstmt.setDouble(78, get(i).getNT50());
/*  906 */         pstmt.setDouble(79, get(i).getNT51());
/*  907 */         pstmt.setDouble(80, get(i).getNT52());
/*  908 */         pstmt.setDouble(81, get(i).getNT53());
/*  909 */         pstmt.setDouble(82, get(i).getNT54());
/*  910 */         pstmt.setDouble(83, get(i).getNT55());
/*  911 */         pstmt.setDouble(84, get(i).getNT56());
/*  912 */         pstmt.setDouble(85, get(i).getNT57());
/*  913 */         pstmt.setDouble(86, get(i).getNT58());
/*  914 */         pstmt.setDouble(87, get(i).getNT59());
/*  915 */         pstmt.setDouble(88, get(i).getNT60());
/*  916 */         pstmt.setDouble(89, get(i).getNT61());
/*  917 */         pstmt.setDouble(90, get(i).getNT62());
/*  918 */         pstmt.setDouble(91, get(i).getNT63());
/*  919 */         pstmt.setDouble(92, get(i).getNT64());
/*  920 */         pstmt.setDouble(93, get(i).getNT65());
/*  921 */         pstmt.setDouble(94, get(i).getNT66());
/*  922 */         pstmt.setDouble(95, get(i).getNT67());
/*  923 */         pstmt.setDouble(96, get(i).getNT68());
/*  924 */         pstmt.setDouble(97, get(i).getNT69());
/*  925 */         pstmt.setDouble(98, get(i).getNT70());
/*  926 */         pstmt.setDouble(99, get(i).getNT71());
/*  927 */         pstmt.setDouble(100, get(i).getNT72());
/*  928 */         pstmt.setDouble(101, get(i).getNT73());
/*  929 */         pstmt.setDouble(102, get(i).getNT74());
/*  930 */         pstmt.setDouble(103, get(i).getNT75());
/*  931 */         pstmt.setDouble(104, get(i).getNT76());
/*  932 */         pstmt.setDouble(105, get(i).getNT77());
/*  933 */         pstmt.setDouble(106, get(i).getNT78());
/*  934 */         pstmt.setDouble(107, get(i).getNT79());
/*  935 */         pstmt.setDouble(108, get(i).getNT80());
/*  936 */         pstmt.setDouble(109, get(i).getNF01());
/*  937 */         pstmt.setDouble(110, get(i).getNF02());
/*  938 */         pstmt.setDouble(111, get(i).getNF03());
/*  939 */         pstmt.setDouble(112, get(i).getNF04());
/*  940 */         pstmt.setDouble(113, get(i).getNF05());
/*  941 */         pstmt.setDouble(114, get(i).getNF06());
/*  942 */         pstmt.setDouble(115, get(i).getNF07());
/*  943 */         pstmt.setDouble(116, get(i).getNF08());
/*  944 */         pstmt.setDouble(117, get(i).getNF09());
/*  945 */         pstmt.setDouble(118, get(i).getNF10());
/*  946 */         pstmt.setDouble(119, get(i).getNS01());
/*  947 */         pstmt.setDouble(120, get(i).getNS02());
/*  948 */         pstmt.setDouble(121, get(i).getNS03());
/*  949 */         pstmt.setDouble(122, get(i).getNS04());
/*  950 */         pstmt.setDouble(123, get(i).getNS05());
/*  951 */         pstmt.setDouble(124, get(i).getNS06());
/*  952 */         pstmt.setDouble(125, get(i).getNS07());
/*  953 */         pstmt.setDouble(126, get(i).getNS08());
/*  954 */         pstmt.setDouble(127, get(i).getNS09());
/*  955 */         pstmt.setDouble(128, get(i).getNS10());
/*  956 */         pstmt.setInt(129, get(i).getINT01());
/*  957 */         pstmt.setInt(130, get(i).getINT02());
/*  958 */         pstmt.setInt(131, get(i).getINT03());
/*  959 */         pstmt.setInt(132, get(i).getINT04());
/*  960 */         pstmt.setInt(133, get(i).getINT05());
/*  961 */         pstmt.setInt(134, get(i).getINT06());
/*  962 */         pstmt.setInt(135, get(i).getINT07());
/*  963 */         pstmt.setInt(136, get(i).getINT08());
/*  964 */         pstmt.setInt(137, get(i).getINT09());
/*  965 */         pstmt.setInt(138, get(i).getINT10());
/*  966 */         pstmt.setInt(139, get(i).getINT11());
/*  967 */         pstmt.setInt(140, get(i).getINT12());
/*  968 */         pstmt.setInt(141, get(i).getINT13());
/*  969 */         pstmt.setInt(142, get(i).getINT14());
/*  970 */         pstmt.setInt(143, get(i).getINT15());
/*  971 */         pstmt.setInt(144, get(i).getINT16());
/*  972 */         pstmt.setInt(145, get(i).getINT17());
/*  973 */         pstmt.setInt(146, get(i).getINT18());
/*  974 */         pstmt.setInt(147, get(i).getINT19());
/*  975 */         pstmt.setInt(148, get(i).getINT20());
/*  976 */         pstmt.setInt(149, get(i).getINT21());
/*  977 */         pstmt.setInt(150, get(i).getINT22());
/*  978 */         pstmt.setInt(151, get(i).getINT23());
/*  979 */         pstmt.setInt(152, get(i).getINT24());
/*  980 */         pstmt.setInt(153, get(i).getINT25());
/*  981 */         if ((get(i).getV1() == null) || (get(i).getV1().equals("null")))
/*  982 */           pstmt.setString(154, null);
/*      */         else {
/*  984 */           pstmt.setString(154, get(i).getV1());
/*      */         }
/*  986 */         if ((get(i).getV2() == null) || (get(i).getV2().equals("null")))
/*  987 */           pstmt.setString(155, null);
/*      */         else {
/*  989 */           pstmt.setString(155, get(i).getV2());
/*      */         }
/*  991 */         if ((get(i).getV3() == null) || (get(i).getV3().equals("null")))
/*  992 */           pstmt.setString(156, null);
/*      */         else {
/*  994 */           pstmt.setString(156, get(i).getV3());
/*      */         }
/*  996 */         if ((get(i).getV4() == null) || (get(i).getV4().equals("null")))
/*  997 */           pstmt.setString(157, null);
/*      */         else {
/*  999 */           pstmt.setString(157, get(i).getV4());
/*      */         }
/* 1001 */         if ((get(i).getV5() == null) || (get(i).getV5().equals("null")))
/* 1002 */           pstmt.setString(158, null);
/*      */         else {
/* 1004 */           pstmt.setString(158, get(i).getV5());
/*      */         }
/* 1006 */         if ((get(i).getV6() == null) || (get(i).getV6().equals("null")))
/* 1007 */           pstmt.setString(159, null);
/*      */         else {
/* 1009 */           pstmt.setString(159, get(i).getV6());
/*      */         }
/* 1011 */         if ((get(i).getV7() == null) || (get(i).getV7().equals("null")))
/* 1012 */           pstmt.setString(160, null);
/*      */         else {
/* 1014 */           pstmt.setString(160, get(i).getV7());
/*      */         }
/* 1016 */         if ((get(i).getV8() == null) || (get(i).getV8().equals("null")))
/* 1017 */           pstmt.setString(161, null);
/*      */         else {
/* 1019 */           pstmt.setString(161, get(i).getV8());
/*      */         }
/* 1021 */         if ((get(i).getV9() == null) || (get(i).getV9().equals("null")))
/* 1022 */           pstmt.setString(162, null);
/*      */         else {
/* 1024 */           pstmt.setString(162, get(i).getV9());
/*      */         }
/* 1026 */         if ((get(i).getV10() == null) || (get(i).getV10().equals("null")))
/* 1027 */           pstmt.setString(163, null);
/*      */         else {
/* 1029 */           pstmt.setString(163, get(i).getV10());
/*      */         }
/* 1031 */         if ((get(i).getV11() == null) || (get(i).getV11().equals("null")))
/* 1032 */           pstmt.setString(164, null);
/*      */         else {
/* 1034 */           pstmt.setString(164, get(i).getV11());
/*      */         }
/* 1036 */         if ((get(i).getV12() == null) || (get(i).getV12().equals("null")))
/* 1037 */           pstmt.setString(165, null);
/*      */         else {
/* 1039 */           pstmt.setString(165, get(i).getV12());
/*      */         }
/* 1041 */         if ((get(i).getV13() == null) || (get(i).getV13().equals("null")))
/* 1042 */           pstmt.setString(166, null);
/*      */         else {
/* 1044 */           pstmt.setString(166, get(i).getV13());
/*      */         }
/* 1046 */         if ((get(i).getV14() == null) || (get(i).getV14().equals("null")))
/* 1047 */           pstmt.setString(167, null);
/*      */         else {
/* 1049 */           pstmt.setString(167, get(i).getV14());
/*      */         }
/* 1051 */         if ((get(i).getV15() == null) || (get(i).getV15().equals("null")))
/* 1052 */           pstmt.setString(168, null);
/*      */         else {
/* 1054 */           pstmt.setString(168, get(i).getV15());
/*      */         }
/* 1056 */         if ((get(i).getV16() == null) || (get(i).getV16().equals("null")))
/* 1057 */           pstmt.setString(169, null);
/*      */         else {
/* 1059 */           pstmt.setString(169, get(i).getV16());
/*      */         }
/* 1061 */         if ((get(i).getV17() == null) || (get(i).getV17().equals("null")))
/* 1062 */           pstmt.setString(170, null);
/*      */         else {
/* 1064 */           pstmt.setString(170, get(i).getV17());
/*      */         }
/* 1066 */         if ((get(i).getV18() == null) || (get(i).getV18().equals("null")))
/* 1067 */           pstmt.setString(171, null);
/*      */         else {
/* 1069 */           pstmt.setString(171, get(i).getV18());
/*      */         }
/* 1071 */         if ((get(i).getV19() == null) || (get(i).getV19().equals("null")))
/* 1072 */           pstmt.setString(172, null);
/*      */         else {
/* 1074 */           pstmt.setString(172, get(i).getV19());
/*      */         }
/* 1076 */         if ((get(i).getV20() == null) || (get(i).getV20().equals("null")))
/* 1077 */           pstmt.setString(173, null);
/*      */         else {
/* 1079 */           pstmt.setString(173, get(i).getV20());
/*      */         }
/* 1081 */         if ((get(i).getVT1() == null) || (get(i).getVT1().equals("null")))
/* 1082 */           pstmt.setString(174, null);
/*      */         else {
/* 1084 */           pstmt.setString(174, get(i).getVT1());
/*      */         }
/* 1086 */         if ((get(i).getVT2() == null) || (get(i).getVT2().equals("null")))
/* 1087 */           pstmt.setString(175, null);
/*      */         else {
/* 1089 */           pstmt.setString(175, get(i).getVT2());
/*      */         }
/* 1091 */         if ((get(i).getVT3() == null) || (get(i).getVT3().equals("null")))
/* 1092 */           pstmt.setString(176, null);
/*      */         else {
/* 1094 */           pstmt.setString(176, get(i).getVT3());
/*      */         }
/* 1096 */         if ((get(i).getVT4() == null) || (get(i).getVT4().equals("null")))
/* 1097 */           pstmt.setString(177, null);
/*      */         else {
/* 1099 */           pstmt.setString(177, get(i).getVT4());
/*      */         }
/* 1101 */         if ((get(i).getVT5() == null) || (get(i).getVT5().equals("null")))
/* 1102 */           pstmt.setString(178, null);
/*      */         else {
/* 1104 */           pstmt.setString(178, get(i).getVT5());
/*      */         }
/* 1106 */         if ((get(i).getVT6() == null) || (get(i).getVT6().equals("null")))
/* 1107 */           pstmt.setString(179, null);
/*      */         else {
/* 1109 */           pstmt.setString(179, get(i).getVT6());
/*      */         }
/* 1111 */         if ((get(i).getVT7() == null) || (get(i).getVT7().equals("null")))
/* 1112 */           pstmt.setString(180, null);
/*      */         else {
/* 1114 */           pstmt.setString(180, get(i).getVT7());
/*      */         }
/* 1116 */         if ((get(i).getVT8() == null) || (get(i).getVT8().equals("null")))
/* 1117 */           pstmt.setString(181, null);
/*      */         else {
/* 1119 */           pstmt.setString(181, get(i).getVT8());
/*      */         }
/* 1121 */         if ((get(i).getVE1() == null) || (get(i).getVE1().equals("null")))
/* 1122 */           pstmt.setString(182, null);
/*      */         else {
/* 1124 */           pstmt.setString(182, get(i).getVE1());
/*      */         }
/* 1126 */         if ((get(i).getVE2() == null) || (get(i).getVE2().equals("null")))
/* 1127 */           pstmt.setString(183, null);
/*      */         else {
/* 1129 */           pstmt.setString(183, get(i).getVE2());
/*      */         }
/* 1131 */         if ((get(i).getVE3() == null) || (get(i).getVE3().equals("null")))
/* 1132 */           pstmt.setString(184, null);
/*      */         else {
/* 1134 */           pstmt.setString(184, get(i).getVE3());
/*      */         }
/* 1136 */         if ((get(i).getVE4() == null) || (get(i).getVE4().equals("null")))
/* 1137 */           pstmt.setString(185, null);
/*      */         else {
/* 1139 */           pstmt.setString(185, get(i).getVE4());
/*      */         }
/* 1141 */         if ((get(i).getVE5() == null) || (get(i).getVE5().equals("null")))
/* 1142 */           pstmt.setString(186, null);
/*      */         else {
/* 1144 */           pstmt.setString(186, get(i).getVE5());
/*      */         }
/* 1146 */         if ((get(i).getVE6() == null) || (get(i).getVE6().equals("null")))
/* 1147 */           pstmt.setString(187, null);
/*      */         else {
/* 1149 */           pstmt.setString(187, get(i).getVE6());
/*      */         }
/* 1151 */         if ((get(i).getVE7() == null) || (get(i).getVE7().equals("null")))
/* 1152 */           pstmt.setString(188, null);
/*      */         else {
/* 1154 */           pstmt.setString(188, get(i).getVE7());
/*      */         }
/* 1156 */         if ((get(i).getVE8() == null) || (get(i).getVE8().equals("null")))
/* 1157 */           pstmt.setString(189, null);
/*      */         else {
/* 1159 */           pstmt.setString(189, get(i).getVE8());
/*      */         }
/* 1161 */         if ((get(i).getVE9() == null) || (get(i).getVE9().equals("null")))
/* 1162 */           pstmt.setString(190, null);
/*      */         else {
/* 1164 */           pstmt.setString(190, get(i).getVE9());
/*      */         }
/* 1166 */         if ((get(i).getVE10() == null) || (get(i).getVE10().equals("null")))
/* 1167 */           pstmt.setString(191, null);
/*      */         else {
/* 1169 */           pstmt.setString(191, get(i).getVE10());
/*      */         }
/* 1171 */         if ((get(i).getD1() == null) || (get(i).getD1().equals("null")))
/* 1172 */           pstmt.setDate(192, null);
/*      */         else {
/* 1174 */           pstmt.setDate(192, Date.valueOf(get(i).getD1()));
/*      */         }
/* 1176 */         if ((get(i).getD2() == null) || (get(i).getD2().equals("null")))
/* 1177 */           pstmt.setDate(193, null);
/*      */         else {
/* 1179 */           pstmt.setDate(193, Date.valueOf(get(i).getD2()));
/*      */         }
/* 1181 */         if ((get(i).getD3() == null) || (get(i).getD3().equals("null")))
/* 1182 */           pstmt.setDate(194, null);
/*      */         else {
/* 1184 */           pstmt.setDate(194, Date.valueOf(get(i).getD3()));
/*      */         }
/* 1186 */         if ((get(i).getD4() == null) || (get(i).getD4().equals("null")))
/* 1187 */           pstmt.setDate(195, null);
/*      */         else {
/* 1189 */           pstmt.setDate(195, Date.valueOf(get(i).getD4()));
/*      */         }
/* 1191 */         if ((get(i).getD5() == null) || (get(i).getD5().equals("null")))
/* 1192 */           pstmt.setDate(196, null);
/*      */         else {
/* 1194 */           pstmt.setDate(196, Date.valueOf(get(i).getD5()));
/*      */         }
/* 1196 */         if ((get(i).getD6() == null) || (get(i).getD6().equals("null")))
/* 1197 */           pstmt.setDate(197, null);
/*      */         else {
/* 1199 */           pstmt.setDate(197, Date.valueOf(get(i).getD6()));
/*      */         }
/* 1201 */         if ((get(i).getD7() == null) || (get(i).getD7().equals("null")))
/* 1202 */           pstmt.setDate(198, null);
/*      */         else {
/* 1204 */           pstmt.setDate(198, Date.valueOf(get(i).getD7()));
/*      */         }
/* 1206 */         if ((get(i).getD8() == null) || (get(i).getD8().equals("null")))
/* 1207 */           pstmt.setDate(199, null);
/*      */         else {
/* 1209 */           pstmt.setDate(199, Date.valueOf(get(i).getD8()));
/*      */         }
/* 1211 */         if ((get(i).getD9() == null) || (get(i).getD9().equals("null")))
/* 1212 */           pstmt.setDate(200, null);
/*      */         else {
/* 1214 */           pstmt.setDate(200, Date.valueOf(get(i).getD9()));
/*      */         }
/* 1216 */         if ((get(i).getD10() == null) || (get(i).getD10().equals("null")))
/* 1217 */           pstmt.setDate(201, null);
/*      */         else {
/* 1219 */           pstmt.setDate(201, Date.valueOf(get(i).getD10()));
/*      */         }
/* 1221 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 1222 */           pstmt.setString(202, null);
/*      */         else {
/* 1224 */           pstmt.setString(202, get(i).getState());
/*      */         }
/* 1226 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 1227 */           pstmt.setString(203, null);
/*      */         else {
/* 1229 */           pstmt.setString(203, get(i).getOperator());
/*      */         }
/* 1231 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 1232 */           pstmt.setDate(204, null);
/*      */         else {
/* 1234 */           pstmt.setDate(204, Date.valueOf(get(i).getMakeDate()));
/*      */         }
/* 1236 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 1237 */           pstmt.setString(205, null);
/*      */         else {
/* 1239 */           pstmt.setString(205, get(i).getMakeTime());
/*      */         }
/* 1241 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 1242 */           pstmt.setDate(206, null);
/*      */         else {
/* 1244 */           pstmt.setDate(206, Date.valueOf(get(i).getModifyDate()));
/*      */         }
/* 1246 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 1247 */           pstmt.setString(207, null);
/*      */         else {
/* 1249 */           pstmt.setString(207, get(i).getModifyTime());
/*      */         }
/* 1251 */         pstmt.addBatch();
/*      */       }
/* 1253 */       pstmt.executeBatch();
/* 1254 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/* 1257 */       ex.printStackTrace();
/* 1258 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 1259 */       CError tError = new CError();
/* 1260 */       tError.moduleName = "LAIndexInfoNewDBSet";
/* 1261 */       tError.functionName = "insert()";
/* 1262 */       tError.errorMessage = ex.toString();
/* 1263 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1266 */         pstmt.close(); } catch (Exception e) {
/* 1267 */         e.printStackTrace();
/*      */       }
/* 1269 */       if (!this.mflag) {
/*      */         try {
/* 1271 */           this.con.close(); } catch (Exception e) {
/* 1272 */           e.printStackTrace();
/*      */         }
/*      */       }
/* 1275 */       return false;
/*      */     }
/*      */ 
/* 1278 */     if (!this.mflag) {
/*      */       try {
/* 1280 */         this.con.close(); } catch (Exception e) {
/* 1281 */         e.printStackTrace();
/*      */       }
/*      */     }
/* 1284 */     return true;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.LAIndexInfoNewDBSet
 * JD-Core Version:    0.6.0
 */