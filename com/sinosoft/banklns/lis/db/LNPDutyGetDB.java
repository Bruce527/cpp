/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPDutyGetSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPDutyGetSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import com.sinosoft.banklns.utility.SQLString;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class LNPDutyGetDB extends LNPDutyGetSchema
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
/*      */   public LNPDutyGetDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPDutyGet");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPDutyGetDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPDutyGet");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPDutyGetSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPDutyGetDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPDutyGetSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPDutyGetDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPDutyGet WHERE  GetDutyCode = ?");
/*   97 */       if ((getGetDutyCode() == null) || (getGetDutyCode().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getGetDutyCode());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPDutyGetDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPDutyGet SET  GetDutyCode = ? , GetDutyName = ? , Type = ? , GetIntv = ? , DefaultVal = ? , CalCode = ? , CnterCalCode = ? , OthCalCode = ? , GetYear = ? , GetYearFlag = ? , StartDateCalRef = ? , StartDateCalMode = ? , MinGetStartPeriod = ? , GetEndPeriod = ? , GetEndUnit = ? , EndDateCalRef = ? , EndDateCalMode = ? , MaxGetEndPeriod = ? , AddFlag = ? , SexRelaFlag = ? , UnitAppRelaFlag = ? , AddAmntFlag = ? , DiscntFlag = ? , InterestFlag = ? , ShareFlag = ? , InpFlag = ? , BnfFlag = ? , UrgeGetFlag = ? , DeadValiFlag = ? , GetInitFlag = ? , GetLimit = ? , MaxGet = ? , GetRate = ? , NeedAcc = ? , CanGet = ? , NeedCancelAcc = ? , GetType1 = ? , ZeroFlag = ? , GetType2 = ? WHERE  GetDutyCode = ?");
/*  146 */       if ((getGetDutyCode() == null) || (getGetDutyCode().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getGetDutyCode());
/*      */       }
/*  151 */       if ((getGetDutyName() == null) || (getGetDutyName().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getGetDutyName());
/*      */       }
/*  156 */       if ((getType() == null) || (getType().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getType());
/*      */       }
/*  161 */       pstmt.setInt(4, getGetIntv());
/*  162 */       pstmt.setDouble(5, getDefaultVal());
/*  163 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/*  164 */         pstmt.setNull(6, 12);
/*      */       else {
/*  166 */         pstmt.setString(6, getCalCode());
/*      */       }
/*  168 */       if ((getCnterCalCode() == null) || (getCnterCalCode().equals("null")))
/*  169 */         pstmt.setNull(7, 12);
/*      */       else {
/*  171 */         pstmt.setString(7, getCnterCalCode());
/*      */       }
/*  173 */       if ((getOthCalCode() == null) || (getOthCalCode().equals("null")))
/*  174 */         pstmt.setNull(8, 12);
/*      */       else {
/*  176 */         pstmt.setString(8, getOthCalCode());
/*      */       }
/*  178 */       pstmt.setInt(9, getGetYear());
/*  179 */       if ((getGetYearFlag() == null) || (getGetYearFlag().equals("null")))
/*  180 */         pstmt.setNull(10, 12);
/*      */       else {
/*  182 */         pstmt.setString(10, getGetYearFlag());
/*      */       }
/*  184 */       if ((getStartDateCalRef() == null) || (getStartDateCalRef().equals("null")))
/*  185 */         pstmt.setNull(11, 12);
/*      */       else {
/*  187 */         pstmt.setString(11, getStartDateCalRef());
/*      */       }
/*  189 */       if ((getStartDateCalMode() == null) || (getStartDateCalMode().equals("null")))
/*  190 */         pstmt.setNull(12, 12);
/*      */       else {
/*  192 */         pstmt.setString(12, getStartDateCalMode());
/*      */       }
/*  194 */       pstmt.setInt(13, getMinGetStartPeriod());
/*  195 */       pstmt.setInt(14, getGetEndPeriod());
/*  196 */       if ((getGetEndUnit() == null) || (getGetEndUnit().equals("null")))
/*  197 */         pstmt.setNull(15, 12);
/*      */       else {
/*  199 */         pstmt.setString(15, getGetEndUnit());
/*      */       }
/*  201 */       if ((getEndDateCalRef() == null) || (getEndDateCalRef().equals("null")))
/*  202 */         pstmt.setNull(16, 12);
/*      */       else {
/*  204 */         pstmt.setString(16, getEndDateCalRef());
/*      */       }
/*  206 */       if ((getEndDateCalMode() == null) || (getEndDateCalMode().equals("null")))
/*  207 */         pstmt.setNull(17, 12);
/*      */       else {
/*  209 */         pstmt.setString(17, getEndDateCalMode());
/*      */       }
/*  211 */       pstmt.setInt(18, getMaxGetEndPeriod());
/*  212 */       if ((getAddFlag() == null) || (getAddFlag().equals("null")))
/*  213 */         pstmt.setNull(19, 12);
/*      */       else {
/*  215 */         pstmt.setString(19, getAddFlag());
/*      */       }
/*  217 */       if ((getSexRelaFlag() == null) || (getSexRelaFlag().equals("null")))
/*  218 */         pstmt.setNull(20, 12);
/*      */       else {
/*  220 */         pstmt.setString(20, getSexRelaFlag());
/*      */       }
/*  222 */       if ((getUnitAppRelaFlag() == null) || (getUnitAppRelaFlag().equals("null")))
/*  223 */         pstmt.setNull(21, 12);
/*      */       else {
/*  225 */         pstmt.setString(21, getUnitAppRelaFlag());
/*      */       }
/*  227 */       if ((getAddAmntFlag() == null) || (getAddAmntFlag().equals("null")))
/*  228 */         pstmt.setNull(22, 12);
/*      */       else {
/*  230 */         pstmt.setString(22, getAddAmntFlag());
/*      */       }
/*  232 */       if ((getDiscntFlag() == null) || (getDiscntFlag().equals("null")))
/*  233 */         pstmt.setNull(23, 12);
/*      */       else {
/*  235 */         pstmt.setString(23, getDiscntFlag());
/*      */       }
/*  237 */       if ((getInterestFlag() == null) || (getInterestFlag().equals("null")))
/*  238 */         pstmt.setNull(24, 12);
/*      */       else {
/*  240 */         pstmt.setString(24, getInterestFlag());
/*      */       }
/*  242 */       if ((getShareFlag() == null) || (getShareFlag().equals("null")))
/*  243 */         pstmt.setNull(25, 12);
/*      */       else {
/*  245 */         pstmt.setString(25, getShareFlag());
/*      */       }
/*  247 */       if ((getInpFlag() == null) || (getInpFlag().equals("null")))
/*  248 */         pstmt.setNull(26, 12);
/*      */       else {
/*  250 */         pstmt.setString(26, getInpFlag());
/*      */       }
/*  252 */       if ((getBnfFlag() == null) || (getBnfFlag().equals("null")))
/*  253 */         pstmt.setNull(27, 12);
/*      */       else {
/*  255 */         pstmt.setString(27, getBnfFlag());
/*      */       }
/*  257 */       if ((getUrgeGetFlag() == null) || (getUrgeGetFlag().equals("null")))
/*  258 */         pstmt.setNull(28, 12);
/*      */       else {
/*  260 */         pstmt.setString(28, getUrgeGetFlag());
/*      */       }
/*  262 */       if ((getDeadValiFlag() == null) || (getDeadValiFlag().equals("null")))
/*  263 */         pstmt.setNull(29, 12);
/*      */       else {
/*  265 */         pstmt.setString(29, getDeadValiFlag());
/*      */       }
/*  267 */       if ((getGetInitFlag() == null) || (getGetInitFlag().equals("null")))
/*  268 */         pstmt.setNull(30, 12);
/*      */       else {
/*  270 */         pstmt.setString(30, getGetInitFlag());
/*      */       }
/*  272 */       pstmt.setDouble(31, getGetLimit());
/*  273 */       pstmt.setDouble(32, getMaxGet());
/*  274 */       pstmt.setDouble(33, getGetRate());
/*  275 */       if ((getNeedAcc() == null) || (getNeedAcc().equals("null")))
/*  276 */         pstmt.setNull(34, 12);
/*      */       else {
/*  278 */         pstmt.setString(34, getNeedAcc());
/*      */       }
/*  280 */       if ((getCanGet() == null) || (getCanGet().equals("null")))
/*  281 */         pstmt.setNull(35, 12);
/*      */       else {
/*  283 */         pstmt.setString(35, getCanGet());
/*      */       }
/*  285 */       if ((getNeedCancelAcc() == null) || (getNeedCancelAcc().equals("null")))
/*  286 */         pstmt.setNull(36, 12);
/*      */       else {
/*  288 */         pstmt.setString(36, getNeedCancelAcc());
/*      */       }
/*  290 */       if ((getGetType1() == null) || (getGetType1().equals("null")))
/*  291 */         pstmt.setNull(37, 12);
/*      */       else {
/*  293 */         pstmt.setString(37, getGetType1());
/*      */       }
/*  295 */       if ((getZeroFlag() == null) || (getZeroFlag().equals("null")))
/*  296 */         pstmt.setNull(38, 12);
/*      */       else {
/*  298 */         pstmt.setString(38, getZeroFlag());
/*      */       }
/*  300 */       if ((getGetType2() == null) || (getGetType2().equals("null")))
/*  301 */         pstmt.setNull(39, 12);
/*      */       else {
/*  303 */         pstmt.setString(39, getGetType2());
/*      */       }
/*      */ 
/*  306 */       if ((getGetDutyCode() == null) || (getGetDutyCode().equals("null")))
/*  307 */         pstmt.setNull(40, 12);
/*      */       else {
/*  309 */         pstmt.setString(40, getGetDutyCode());
/*      */       }
/*  311 */       pstmt.executeUpdate();
/*  312 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  315 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  316 */       CError tError = new CError();
/*  317 */       tError.moduleName = "LNPDutyGetDB";
/*  318 */       tError.functionName = "update()";
/*  319 */       tError.errorMessage = ex.toString();
/*  320 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  323 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  326 */       if (!this.mflag)
/*      */         try {
/*  328 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  332 */       return false;
/*      */     }
/*      */ 
/*  335 */     if (!this.mflag)
/*      */       try {
/*  337 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  341 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  346 */     PreparedStatement pstmt = null;
/*      */ 
/*  348 */     if (!this.mflag) {
/*  349 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  354 */       pstmt = this.con.prepareStatement("INSERT INTO LNPDutyGet VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  355 */       if ((getGetDutyCode() == null) || (getGetDutyCode().equals("null")))
/*  356 */         pstmt.setNull(1, 12);
/*      */       else {
/*  358 */         pstmt.setString(1, getGetDutyCode());
/*      */       }
/*  360 */       if ((getGetDutyName() == null) || (getGetDutyName().equals("null")))
/*  361 */         pstmt.setNull(2, 12);
/*      */       else {
/*  363 */         pstmt.setString(2, getGetDutyName());
/*      */       }
/*  365 */       if ((getType() == null) || (getType().equals("null")))
/*  366 */         pstmt.setNull(3, 12);
/*      */       else {
/*  368 */         pstmt.setString(3, getType());
/*      */       }
/*  370 */       pstmt.setInt(4, getGetIntv());
/*  371 */       pstmt.setDouble(5, getDefaultVal());
/*  372 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/*  373 */         pstmt.setNull(6, 12);
/*      */       else {
/*  375 */         pstmt.setString(6, getCalCode());
/*      */       }
/*  377 */       if ((getCnterCalCode() == null) || (getCnterCalCode().equals("null")))
/*  378 */         pstmt.setNull(7, 12);
/*      */       else {
/*  380 */         pstmt.setString(7, getCnterCalCode());
/*      */       }
/*  382 */       if ((getOthCalCode() == null) || (getOthCalCode().equals("null")))
/*  383 */         pstmt.setNull(8, 12);
/*      */       else {
/*  385 */         pstmt.setString(8, getOthCalCode());
/*      */       }
/*  387 */       pstmt.setInt(9, getGetYear());
/*  388 */       if ((getGetYearFlag() == null) || (getGetYearFlag().equals("null")))
/*  389 */         pstmt.setNull(10, 12);
/*      */       else {
/*  391 */         pstmt.setString(10, getGetYearFlag());
/*      */       }
/*  393 */       if ((getStartDateCalRef() == null) || (getStartDateCalRef().equals("null")))
/*  394 */         pstmt.setNull(11, 12);
/*      */       else {
/*  396 */         pstmt.setString(11, getStartDateCalRef());
/*      */       }
/*  398 */       if ((getStartDateCalMode() == null) || (getStartDateCalMode().equals("null")))
/*  399 */         pstmt.setNull(12, 12);
/*      */       else {
/*  401 */         pstmt.setString(12, getStartDateCalMode());
/*      */       }
/*  403 */       pstmt.setInt(13, getMinGetStartPeriod());
/*  404 */       pstmt.setInt(14, getGetEndPeriod());
/*  405 */       if ((getGetEndUnit() == null) || (getGetEndUnit().equals("null")))
/*  406 */         pstmt.setNull(15, 12);
/*      */       else {
/*  408 */         pstmt.setString(15, getGetEndUnit());
/*      */       }
/*  410 */       if ((getEndDateCalRef() == null) || (getEndDateCalRef().equals("null")))
/*  411 */         pstmt.setNull(16, 12);
/*      */       else {
/*  413 */         pstmt.setString(16, getEndDateCalRef());
/*      */       }
/*  415 */       if ((getEndDateCalMode() == null) || (getEndDateCalMode().equals("null")))
/*  416 */         pstmt.setNull(17, 12);
/*      */       else {
/*  418 */         pstmt.setString(17, getEndDateCalMode());
/*      */       }
/*  420 */       pstmt.setInt(18, getMaxGetEndPeriod());
/*  421 */       if ((getAddFlag() == null) || (getAddFlag().equals("null")))
/*  422 */         pstmt.setNull(19, 12);
/*      */       else {
/*  424 */         pstmt.setString(19, getAddFlag());
/*      */       }
/*  426 */       if ((getSexRelaFlag() == null) || (getSexRelaFlag().equals("null")))
/*  427 */         pstmt.setNull(20, 12);
/*      */       else {
/*  429 */         pstmt.setString(20, getSexRelaFlag());
/*      */       }
/*  431 */       if ((getUnitAppRelaFlag() == null) || (getUnitAppRelaFlag().equals("null")))
/*  432 */         pstmt.setNull(21, 12);
/*      */       else {
/*  434 */         pstmt.setString(21, getUnitAppRelaFlag());
/*      */       }
/*  436 */       if ((getAddAmntFlag() == null) || (getAddAmntFlag().equals("null")))
/*  437 */         pstmt.setNull(22, 12);
/*      */       else {
/*  439 */         pstmt.setString(22, getAddAmntFlag());
/*      */       }
/*  441 */       if ((getDiscntFlag() == null) || (getDiscntFlag().equals("null")))
/*  442 */         pstmt.setNull(23, 12);
/*      */       else {
/*  444 */         pstmt.setString(23, getDiscntFlag());
/*      */       }
/*  446 */       if ((getInterestFlag() == null) || (getInterestFlag().equals("null")))
/*  447 */         pstmt.setNull(24, 12);
/*      */       else {
/*  449 */         pstmt.setString(24, getInterestFlag());
/*      */       }
/*  451 */       if ((getShareFlag() == null) || (getShareFlag().equals("null")))
/*  452 */         pstmt.setNull(25, 12);
/*      */       else {
/*  454 */         pstmt.setString(25, getShareFlag());
/*      */       }
/*  456 */       if ((getInpFlag() == null) || (getInpFlag().equals("null")))
/*  457 */         pstmt.setNull(26, 12);
/*      */       else {
/*  459 */         pstmt.setString(26, getInpFlag());
/*      */       }
/*  461 */       if ((getBnfFlag() == null) || (getBnfFlag().equals("null")))
/*  462 */         pstmt.setNull(27, 12);
/*      */       else {
/*  464 */         pstmt.setString(27, getBnfFlag());
/*      */       }
/*  466 */       if ((getUrgeGetFlag() == null) || (getUrgeGetFlag().equals("null")))
/*  467 */         pstmt.setNull(28, 12);
/*      */       else {
/*  469 */         pstmt.setString(28, getUrgeGetFlag());
/*      */       }
/*  471 */       if ((getDeadValiFlag() == null) || (getDeadValiFlag().equals("null")))
/*  472 */         pstmt.setNull(29, 12);
/*      */       else {
/*  474 */         pstmt.setString(29, getDeadValiFlag());
/*      */       }
/*  476 */       if ((getGetInitFlag() == null) || (getGetInitFlag().equals("null")))
/*  477 */         pstmt.setNull(30, 12);
/*      */       else {
/*  479 */         pstmt.setString(30, getGetInitFlag());
/*      */       }
/*  481 */       pstmt.setDouble(31, getGetLimit());
/*  482 */       pstmt.setDouble(32, getMaxGet());
/*  483 */       pstmt.setDouble(33, getGetRate());
/*  484 */       if ((getNeedAcc() == null) || (getNeedAcc().equals("null")))
/*  485 */         pstmt.setNull(34, 12);
/*      */       else {
/*  487 */         pstmt.setString(34, getNeedAcc());
/*      */       }
/*  489 */       if ((getCanGet() == null) || (getCanGet().equals("null")))
/*  490 */         pstmt.setNull(35, 12);
/*      */       else {
/*  492 */         pstmt.setString(35, getCanGet());
/*      */       }
/*  494 */       if ((getNeedCancelAcc() == null) || (getNeedCancelAcc().equals("null")))
/*  495 */         pstmt.setNull(36, 12);
/*      */       else {
/*  497 */         pstmt.setString(36, getNeedCancelAcc());
/*      */       }
/*  499 */       if ((getGetType1() == null) || (getGetType1().equals("null")))
/*  500 */         pstmt.setNull(37, 12);
/*      */       else {
/*  502 */         pstmt.setString(37, getGetType1());
/*      */       }
/*  504 */       if ((getZeroFlag() == null) || (getZeroFlag().equals("null")))
/*  505 */         pstmt.setNull(38, 12);
/*      */       else {
/*  507 */         pstmt.setString(38, getZeroFlag());
/*      */       }
/*  509 */       if ((getGetType2() == null) || (getGetType2().equals("null")))
/*  510 */         pstmt.setNull(39, 12);
/*      */       else {
/*  512 */         pstmt.setString(39, getGetType2());
/*      */       }
/*      */ 
/*  515 */       pstmt.executeUpdate();
/*  516 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  519 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  520 */       CError tError = new CError();
/*  521 */       tError.moduleName = "LNPDutyGetDB";
/*  522 */       tError.functionName = "insert()";
/*  523 */       tError.errorMessage = ex.toString();
/*  524 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  527 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  530 */       if (!this.mflag)
/*      */         try {
/*  532 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  536 */       return false;
/*      */     }
/*      */ 
/*  539 */     if (!this.mflag)
/*      */       try {
/*  541 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  545 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  550 */     PreparedStatement pstmt = null;
/*  551 */     ResultSet rs = null;
/*      */ 
/*  553 */     if (!this.mflag) {
/*  554 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  559 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPDutyGet WHERE  GetDutyCode = ?", 
/*  560 */         1003, 1007);
/*  561 */       if ((getGetDutyCode() == null) || (getGetDutyCode().equals("null")))
/*  562 */         pstmt.setNull(1, 12);
/*      */       else {
/*  564 */         pstmt.setString(1, getGetDutyCode());
/*      */       }
/*  566 */       rs = pstmt.executeQuery();
/*  567 */       int i = 0;
/*  568 */       if (rs.next())
/*      */       {
/*  570 */         i++;
/*  571 */         if (!setSchema(rs, i))
/*      */         {
/*  574 */           CError tError = new CError();
/*  575 */           tError.moduleName = "LNPDutyGetDB";
/*  576 */           tError.functionName = "getInfo";
/*  577 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  578 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  580 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  583 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  587 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  591 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  595 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  598 */       if (i == 0)
/*      */       {
/*  600 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  604 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  608 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  614 */       CError tError = new CError();
/*  615 */       tError.moduleName = "LNPDutyGetDB";
/*  616 */       tError.functionName = "getInfo";
/*  617 */       tError.errorMessage = e.toString();
/*  618 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  620 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  623 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  627 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  631 */       return false;
/*      */     }
/*      */ 
/*  634 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  638 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  643 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPDutyGetSet query()
/*      */   {
/*  648 */     Statement stmt = null;
/*  649 */     ResultSet rs = null;
/*  650 */     LNPDutyGetSet aLNPDutyGetSet = new LNPDutyGetSet();
/*      */ 
/*  652 */     if (!this.mflag) {
/*  653 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  658 */       stmt = this.con.createStatement(1003, 1007);
/*  659 */       SQLString sqlObj = new SQLString("LNPDutyGet");
/*  660 */       LNPDutyGetSchema aSchema = getSchema();
/*  661 */       sqlObj.setSQL(5, aSchema);
/*  662 */       String sql = sqlObj.getSQL();
/*      */ 
/*  664 */       rs = stmt.executeQuery(sql);
/*  665 */       int i = 0;
/*  666 */       while (rs.next())
/*      */       {
/*  668 */         i++;
/*  669 */         LNPDutyGetSchema s1 = new LNPDutyGetSchema();
/*  670 */         s1.setSchema(rs, i);
/*  671 */         aLNPDutyGetSet.add(s1);
/*      */       }try {
/*  673 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  679 */       CError tError = new CError();
/*  680 */       tError.moduleName = "LNPDutyGetDB";
/*  681 */       tError.functionName = "query";
/*  682 */       tError.errorMessage = e.toString();
/*  683 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  685 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  688 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  692 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  698 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  702 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  707 */     return aLNPDutyGetSet;
/*      */   }
/*      */ 
/*      */   public LNPDutyGetSet executeQuery(String sql)
/*      */   {
/*  712 */     Statement stmt = null;
/*  713 */     ResultSet rs = null;
/*  714 */     LNPDutyGetSet aLNPDutyGetSet = new LNPDutyGetSet();
/*      */ 
/*  716 */     if (!this.mflag) {
/*  717 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  722 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  724 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  725 */       int i = 0;
/*  726 */       while (rs.next())
/*      */       {
/*  728 */         i++;
/*  729 */         LNPDutyGetSchema s1 = new LNPDutyGetSchema();
/*  730 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  733 */           CError tError = new CError();
/*  734 */           tError.moduleName = "LNPDutyGetDB";
/*  735 */           tError.functionName = "executeQuery";
/*  736 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  737 */           this.mErrors.addOneError(tError);
/*      */         }
/*  739 */         aLNPDutyGetSet.add(s1);
/*      */       }try {
/*  741 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  747 */       CError tError = new CError();
/*  748 */       tError.moduleName = "LNPDutyGetDB";
/*  749 */       tError.functionName = "executeQuery";
/*  750 */       tError.errorMessage = e.toString();
/*  751 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  753 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  756 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  760 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  766 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  770 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  775 */     return aLNPDutyGetSet;
/*      */   }
/*      */ 
/*      */   public LNPDutyGetSet query(int nStart, int nCount)
/*      */   {
/*  780 */     Statement stmt = null;
/*  781 */     ResultSet rs = null;
/*  782 */     LNPDutyGetSet aLNPDutyGetSet = new LNPDutyGetSet();
/*      */ 
/*  784 */     if (!this.mflag) {
/*  785 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  790 */       stmt = this.con.createStatement(1003, 1007);
/*  791 */       SQLString sqlObj = new SQLString("LNPDutyGet");
/*  792 */       LNPDutyGetSchema aSchema = getSchema();
/*  793 */       sqlObj.setSQL(5, aSchema);
/*  794 */       String sql = sqlObj.getSQL();
/*      */ 
/*  796 */       rs = stmt.executeQuery(sql);
/*  797 */       int i = 0;
/*  798 */       while (rs.next())
/*      */       {
/*  800 */         i++;
/*      */ 
/*  802 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  806 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  810 */         LNPDutyGetSchema s1 = new LNPDutyGetSchema();
/*  811 */         s1.setSchema(rs, i);
/*  812 */         aLNPDutyGetSet.add(s1);
/*      */       }try {
/*  814 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  820 */       CError tError = new CError();
/*  821 */       tError.moduleName = "LNPDutyGetDB";
/*  822 */       tError.functionName = "query";
/*  823 */       tError.errorMessage = e.toString();
/*  824 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  826 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  829 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  833 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  839 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  843 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  848 */     return aLNPDutyGetSet;
/*      */   }
/*      */ 
/*      */   public LNPDutyGetSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  853 */     Statement stmt = null;
/*  854 */     ResultSet rs = null;
/*  855 */     LNPDutyGetSet aLNPDutyGetSet = new LNPDutyGetSet();
/*      */ 
/*  857 */     if (!this.mflag) {
/*  858 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  863 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  865 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  866 */       int i = 0;
/*  867 */       while (rs.next())
/*      */       {
/*  869 */         i++;
/*      */ 
/*  871 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  875 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  879 */         LNPDutyGetSchema s1 = new LNPDutyGetSchema();
/*  880 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  883 */           CError tError = new CError();
/*  884 */           tError.moduleName = "LNPDutyGetDB";
/*  885 */           tError.functionName = "executeQuery";
/*  886 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  887 */           this.mErrors.addOneError(tError);
/*      */         }
/*  889 */         aLNPDutyGetSet.add(s1);
/*      */       }try {
/*  891 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  897 */       CError tError = new CError();
/*  898 */       tError.moduleName = "LNPDutyGetDB";
/*  899 */       tError.functionName = "executeQuery";
/*  900 */       tError.errorMessage = e.toString();
/*  901 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  903 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  906 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  910 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  916 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  920 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  925 */     return aLNPDutyGetSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  930 */     Statement stmt = null;
/*      */ 
/*  932 */     if (!this.mflag) {
/*  933 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  938 */       stmt = this.con.createStatement(1003, 1007);
/*  939 */       SQLString sqlObj = new SQLString("LNPDutyGet");
/*  940 */       LNPDutyGetSchema aSchema = getSchema();
/*  941 */       sqlObj.setSQL(2, aSchema);
/*  942 */       String sql = "update LNPDutyGet " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  944 */       int operCount = stmt.executeUpdate(sql);
/*  945 */       if (operCount == 0)
/*      */       {
/*  948 */         CError tError = new CError();
/*  949 */         tError.moduleName = "LNPDutyGetDB";
/*  950 */         tError.functionName = "update";
/*  951 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  952 */         this.mErrors.addOneError(tError);
/*      */ 
/*  954 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  958 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  962 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  968 */       CError tError = new CError();
/*  969 */       tError.moduleName = "LNPDutyGetDB";
/*  970 */       tError.functionName = "update";
/*  971 */       tError.errorMessage = e.toString();
/*  972 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  974 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  976 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  980 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  984 */       return false;
/*      */     }
/*      */ 
/*  987 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  991 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  996 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1002 */     if (this.mResultSet != null)
/*      */     {
/* 1005 */       CError tError = new CError();
/* 1006 */       tError.moduleName = "LNPDutyGetDB";
/* 1007 */       tError.functionName = "prepareData";
/* 1008 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 1009 */       this.mErrors.addOneError(tError);
/* 1010 */       return false;
/*      */     }
/*      */ 
/* 1013 */     if (!this.mflag)
/*      */     {
/* 1015 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1019 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1020 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1025 */       CError tError = new CError();
/* 1026 */       tError.moduleName = "LNPDutyGetDB";
/* 1027 */       tError.functionName = "prepareData";
/* 1028 */       tError.errorMessage = e.toString();
/* 1029 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1032 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1038 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1042 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1046 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1051 */       return false;
/*      */     }
/*      */ 
/* 1054 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1058 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1063 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1069 */     boolean flag = true;
/* 1070 */     if (this.mResultSet == null)
/*      */     {
/* 1072 */       CError tError = new CError();
/* 1073 */       tError.moduleName = "LNPDutyGetDB";
/* 1074 */       tError.functionName = "hasMoreData";
/* 1075 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1076 */       this.mErrors.addOneError(tError);
/* 1077 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1081 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1085 */       CError tError = new CError();
/* 1086 */       tError.moduleName = "LNPDutyGetDB";
/* 1087 */       tError.functionName = "hasMoreData";
/* 1088 */       tError.errorMessage = ex.toString();
/* 1089 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1092 */         this.mResultSet.close();
/* 1093 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1099 */         this.mStatement.close();
/* 1100 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1104 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1108 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1113 */       return false;
/*      */     }
/* 1115 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPDutyGetSet getData()
/*      */   {
/* 1120 */     int tCount = 0;
/* 1121 */     LNPDutyGetSet tLNPDutyGetSet = new LNPDutyGetSet();
/* 1122 */     LNPDutyGetSchema tLNPDutyGetSchema = null;
/* 1123 */     if (this.mResultSet == null)
/*      */     {
/* 1125 */       CError tError = new CError();
/* 1126 */       tError.moduleName = "LNPDutyGetDB";
/* 1127 */       tError.functionName = "getData";
/* 1128 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1129 */       this.mErrors.addOneError(tError);
/* 1130 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1134 */       tCount = 1;
/* 1135 */       tLNPDutyGetSchema = new LNPDutyGetSchema();
/* 1136 */       tLNPDutyGetSchema.setSchema(this.mResultSet, 1);
/* 1137 */       tLNPDutyGetSet.add(tLNPDutyGetSchema);
/*      */ 
/* 1139 */       while (tCount++ < 5000)
/*      */       {
/* 1141 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1143 */         tLNPDutyGetSchema = new LNPDutyGetSchema();
/* 1144 */         tLNPDutyGetSchema.setSchema(this.mResultSet, 1);
/* 1145 */         tLNPDutyGetSet.add(tLNPDutyGetSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1151 */       CError tError = new CError();
/* 1152 */       tError.moduleName = "LNPDutyGetDB";
/* 1153 */       tError.functionName = "getData";
/* 1154 */       tError.errorMessage = ex.toString();
/* 1155 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1158 */         this.mResultSet.close();
/* 1159 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1165 */         this.mStatement.close();
/* 1166 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1170 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1174 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1179 */       return null;
/*      */     }
/* 1181 */     return tLNPDutyGetSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1186 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1189 */       if (this.mResultSet == null)
/*      */       {
/* 1191 */         CError tError = new CError();
/* 1192 */         tError.moduleName = "LNPDutyGetDB";
/* 1193 */         tError.functionName = "closeData";
/* 1194 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1195 */         this.mErrors.addOneError(tError);
/* 1196 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1200 */         this.mResultSet.close();
/* 1201 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1206 */       CError tError = new CError();
/* 1207 */       tError.moduleName = "LNPDutyGetDB";
/* 1208 */       tError.functionName = "closeData";
/* 1209 */       tError.errorMessage = ex2.toString();
/* 1210 */       this.mErrors.addOneError(tError);
/* 1211 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1215 */       if (this.mStatement == null)
/*      */       {
/* 1217 */         CError tError = new CError();
/* 1218 */         tError.moduleName = "LNPDutyGetDB";
/* 1219 */         tError.functionName = "closeData";
/* 1220 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1221 */         this.mErrors.addOneError(tError);
/* 1222 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1226 */         this.mStatement.close();
/* 1227 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1232 */       CError tError = new CError();
/* 1233 */       tError.moduleName = "LNPDutyGetDB";
/* 1234 */       tError.functionName = "closeData";
/* 1235 */       tError.errorMessage = ex3.toString();
/* 1236 */       this.mErrors.addOneError(tError);
/* 1237 */       flag = false;
/*      */     }
/* 1239 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPDutyGetDB
 * JD-Core Version:    0.6.0
 */