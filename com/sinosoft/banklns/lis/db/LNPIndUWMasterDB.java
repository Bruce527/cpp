/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPIndUWMasterSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPIndUWMasterSet;
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
/*      */ public class LNPIndUWMasterDB extends LNPIndUWMasterSchema
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
/*      */   public LNPIndUWMasterDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPIndUWMaster");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPIndUWMasterDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPIndUWMaster");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPIndUWMasterSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPIndUWMasterDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPIndUWMasterSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPIndUWMasterDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPIndUWMaster WHERE  ContNo = ? AND InsuredId = ?");
/*   97 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getContNo());
/*      */       }
/*  102 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getInsuredId());
/*      */       }
/*  107 */       pstmt.executeUpdate();
/*  108 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  111 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  112 */       CError tError = new CError();
/*  113 */       tError.moduleName = "LNPIndUWMasterDB";
/*  114 */       tError.functionName = "delete()";
/*  115 */       tError.errorMessage = ex.toString();
/*  116 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  119 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  122 */       if (!this.mflag)
/*      */         try {
/*  124 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  128 */       return false;
/*      */     }
/*      */ 
/*  131 */     if (!this.mflag)
/*      */       try {
/*  133 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  137 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  142 */     PreparedStatement pstmt = null;
/*      */ 
/*  144 */     if (!this.mflag) {
/*  145 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  150 */       pstmt = this.con.prepareStatement("UPDATE LNPIndUWMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , UWNo = ? , ManageCom = ? , InsuredId = ? , InsuredNo = ? , InsuredName = ? , FlagCaseDcl = ? , HighFaceAmount = ? , UWMessages = ? , AppntId = ? , AppntNo = ? , AppntName = ? , PassFlag = ? , UWIdea = ? , UWGrade = ? , AppGrade = ? , PostponeDay = ? , PostponeDate = ? , AutoUWFlag = ? , State = ? , UpReportContent = ? , HealthFlag = ? , QuesFlag = ? , SpecFlag = ? , AddPremFlag = ? , AddPremReason = ? , ReportFlag = ? , SpecReason = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ? AND InsuredId = ?");
/*  151 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  152 */         pstmt.setNull(1, 12);
/*      */       else {
/*  154 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  156 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  157 */         pstmt.setNull(2, 12);
/*      */       else {
/*  159 */         pstmt.setString(2, getContNo());
/*      */       }
/*  161 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  162 */         pstmt.setNull(3, 12);
/*      */       else {
/*  164 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  166 */       pstmt.setInt(4, getUWNo());
/*  167 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  168 */         pstmt.setNull(5, 12);
/*      */       else {
/*  170 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  172 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  173 */         pstmt.setNull(6, 12);
/*      */       else {
/*  175 */         pstmt.setString(6, getInsuredId());
/*      */       }
/*  177 */       if ((getInsuredNo() == null) || (getInsuredNo().equals("null")))
/*  178 */         pstmt.setNull(7, 12);
/*      */       else {
/*  180 */         pstmt.setString(7, getInsuredNo());
/*      */       }
/*  182 */       if ((getInsuredName() == null) || (getInsuredName().equals("null")))
/*  183 */         pstmt.setNull(8, 12);
/*      */       else {
/*  185 */         pstmt.setString(8, getInsuredName());
/*      */       }
/*  187 */       if ((getFlagCaseDcl() == null) || (getFlagCaseDcl().equals("null")))
/*  188 */         pstmt.setNull(9, 12);
/*      */       else {
/*  190 */         pstmt.setString(9, getFlagCaseDcl());
/*      */       }
/*  192 */       if ((getHighFaceAmount() == null) || (getHighFaceAmount().equals("null")))
/*  193 */         pstmt.setNull(10, 12);
/*      */       else {
/*  195 */         pstmt.setString(10, getHighFaceAmount());
/*      */       }
/*  197 */       if ((getUWMessages() == null) || (getUWMessages().equals("null")))
/*  198 */         pstmt.setNull(11, 12);
/*      */       else {
/*  200 */         pstmt.setString(11, getUWMessages());
/*      */       }
/*  202 */       if ((getAppntId() == null) || (getAppntId().equals("null")))
/*  203 */         pstmt.setNull(12, 12);
/*      */       else {
/*  205 */         pstmt.setString(12, getAppntId());
/*      */       }
/*  207 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  208 */         pstmt.setNull(13, 12);
/*      */       else {
/*  210 */         pstmt.setString(13, getAppntNo());
/*      */       }
/*  212 */       if ((getAppntName() == null) || (getAppntName().equals("null")))
/*  213 */         pstmt.setNull(14, 12);
/*      */       else {
/*  215 */         pstmt.setString(14, getAppntName());
/*      */       }
/*  217 */       if ((getPassFlag() == null) || (getPassFlag().equals("null")))
/*  218 */         pstmt.setNull(15, 12);
/*      */       else {
/*  220 */         pstmt.setString(15, getPassFlag());
/*      */       }
/*  222 */       if ((getUWIdea() == null) || (getUWIdea().equals("null")))
/*  223 */         pstmt.setNull(16, 12);
/*      */       else {
/*  225 */         pstmt.setString(16, getUWIdea());
/*      */       }
/*  227 */       if ((getUWGrade() == null) || (getUWGrade().equals("null")))
/*  228 */         pstmt.setNull(17, 12);
/*      */       else {
/*  230 */         pstmt.setString(17, getUWGrade());
/*      */       }
/*  232 */       if ((getAppGrade() == null) || (getAppGrade().equals("null")))
/*  233 */         pstmt.setNull(18, 12);
/*      */       else {
/*  235 */         pstmt.setString(18, getAppGrade());
/*      */       }
/*  237 */       if ((getPostponeDay() == null) || (getPostponeDay().equals("null")))
/*  238 */         pstmt.setNull(19, 12);
/*      */       else {
/*  240 */         pstmt.setString(19, getPostponeDay());
/*      */       }
/*  242 */       if ((getPostponeDate() == null) || (getPostponeDate().equals("null")))
/*  243 */         pstmt.setNull(20, 91);
/*      */       else {
/*  245 */         pstmt.setDate(20, Date.valueOf(getPostponeDate()));
/*      */       }
/*  247 */       if ((getAutoUWFlag() == null) || (getAutoUWFlag().equals("null")))
/*  248 */         pstmt.setNull(21, 12);
/*      */       else {
/*  250 */         pstmt.setString(21, getAutoUWFlag());
/*      */       }
/*  252 */       if ((getState() == null) || (getState().equals("null")))
/*  253 */         pstmt.setNull(22, 12);
/*      */       else {
/*  255 */         pstmt.setString(22, getState());
/*      */       }
/*  257 */       if ((getUpReportContent() == null) || (getUpReportContent().equals("null")))
/*  258 */         pstmt.setNull(23, 12);
/*      */       else {
/*  260 */         pstmt.setString(23, getUpReportContent());
/*      */       }
/*  262 */       if ((getHealthFlag() == null) || (getHealthFlag().equals("null")))
/*  263 */         pstmt.setNull(24, 12);
/*      */       else {
/*  265 */         pstmt.setString(24, getHealthFlag());
/*      */       }
/*  267 */       if ((getQuesFlag() == null) || (getQuesFlag().equals("null")))
/*  268 */         pstmt.setNull(25, 12);
/*      */       else {
/*  270 */         pstmt.setString(25, getQuesFlag());
/*      */       }
/*  272 */       if ((getSpecFlag() == null) || (getSpecFlag().equals("null")))
/*  273 */         pstmt.setNull(26, 12);
/*      */       else {
/*  275 */         pstmt.setString(26, getSpecFlag());
/*      */       }
/*  277 */       if ((getAddPremFlag() == null) || (getAddPremFlag().equals("null")))
/*  278 */         pstmt.setNull(27, 12);
/*      */       else {
/*  280 */         pstmt.setString(27, getAddPremFlag());
/*      */       }
/*  282 */       if ((getAddPremReason() == null) || (getAddPremReason().equals("null")))
/*  283 */         pstmt.setNull(28, 12);
/*      */       else {
/*  285 */         pstmt.setString(28, getAddPremReason());
/*      */       }
/*  287 */       if ((getReportFlag() == null) || (getReportFlag().equals("null")))
/*  288 */         pstmt.setNull(29, 12);
/*      */       else {
/*  290 */         pstmt.setString(29, getReportFlag());
/*      */       }
/*  292 */       if ((getSpecReason() == null) || (getSpecReason().equals("null")))
/*  293 */         pstmt.setNull(30, 12);
/*      */       else {
/*  295 */         pstmt.setString(30, getSpecReason());
/*      */       }
/*  297 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  298 */         pstmt.setNull(31, 12);
/*      */       else {
/*  300 */         pstmt.setString(31, getOperator());
/*      */       }
/*  302 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  303 */         pstmt.setNull(32, 91);
/*      */       else {
/*  305 */         pstmt.setDate(32, Date.valueOf(getMakeDate()));
/*      */       }
/*  307 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  308 */         pstmt.setNull(33, 12);
/*      */       else {
/*  310 */         pstmt.setString(33, getMakeTime());
/*      */       }
/*  312 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  313 */         pstmt.setNull(34, 91);
/*      */       else {
/*  315 */         pstmt.setDate(34, Date.valueOf(getModifyDate()));
/*      */       }
/*  317 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  318 */         pstmt.setNull(35, 12);
/*      */       else {
/*  320 */         pstmt.setString(35, getModifyTime());
/*      */       }
/*      */ 
/*  323 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  324 */         pstmt.setNull(36, 12);
/*      */       else {
/*  326 */         pstmt.setString(36, getContNo());
/*      */       }
/*  328 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  329 */         pstmt.setNull(37, 12);
/*      */       else {
/*  331 */         pstmt.setString(37, getInsuredId());
/*      */       }
/*  333 */       pstmt.executeUpdate();
/*  334 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  337 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  338 */       CError tError = new CError();
/*  339 */       tError.moduleName = "LNPIndUWMasterDB";
/*  340 */       tError.functionName = "update()";
/*  341 */       tError.errorMessage = ex.toString();
/*  342 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  345 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  348 */       if (!this.mflag)
/*      */         try {
/*  350 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  354 */       return false;
/*      */     }
/*      */ 
/*  357 */     if (!this.mflag)
/*      */       try {
/*  359 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  363 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  368 */     PreparedStatement pstmt = null;
/*      */ 
/*  370 */     if (!this.mflag) {
/*  371 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  376 */       pstmt = this.con.prepareStatement("INSERT INTO LNPIndUWMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  377 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  378 */         pstmt.setNull(1, 12);
/*      */       else {
/*  380 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  382 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  383 */         pstmt.setNull(2, 12);
/*      */       else {
/*  385 */         pstmt.setString(2, getContNo());
/*      */       }
/*  387 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  388 */         pstmt.setNull(3, 12);
/*      */       else {
/*  390 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  392 */       pstmt.setInt(4, getUWNo());
/*  393 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  394 */         pstmt.setNull(5, 12);
/*      */       else {
/*  396 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  398 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  399 */         pstmt.setNull(6, 12);
/*      */       else {
/*  401 */         pstmt.setString(6, getInsuredId());
/*      */       }
/*  403 */       if ((getInsuredNo() == null) || (getInsuredNo().equals("null")))
/*  404 */         pstmt.setNull(7, 12);
/*      */       else {
/*  406 */         pstmt.setString(7, getInsuredNo());
/*      */       }
/*  408 */       if ((getInsuredName() == null) || (getInsuredName().equals("null")))
/*  409 */         pstmt.setNull(8, 12);
/*      */       else {
/*  411 */         pstmt.setString(8, getInsuredName());
/*      */       }
/*  413 */       if ((getFlagCaseDcl() == null) || (getFlagCaseDcl().equals("null")))
/*  414 */         pstmt.setNull(9, 12);
/*      */       else {
/*  416 */         pstmt.setString(9, getFlagCaseDcl());
/*      */       }
/*  418 */       if ((getHighFaceAmount() == null) || (getHighFaceAmount().equals("null")))
/*  419 */         pstmt.setNull(10, 12);
/*      */       else {
/*  421 */         pstmt.setString(10, getHighFaceAmount());
/*      */       }
/*  423 */       if ((getUWMessages() == null) || (getUWMessages().equals("null")))
/*  424 */         pstmt.setNull(11, 12);
/*      */       else {
/*  426 */         pstmt.setString(11, getUWMessages());
/*      */       }
/*  428 */       if ((getAppntId() == null) || (getAppntId().equals("null")))
/*  429 */         pstmt.setNull(12, 12);
/*      */       else {
/*  431 */         pstmt.setString(12, getAppntId());
/*      */       }
/*  433 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  434 */         pstmt.setNull(13, 12);
/*      */       else {
/*  436 */         pstmt.setString(13, getAppntNo());
/*      */       }
/*  438 */       if ((getAppntName() == null) || (getAppntName().equals("null")))
/*  439 */         pstmt.setNull(14, 12);
/*      */       else {
/*  441 */         pstmt.setString(14, getAppntName());
/*      */       }
/*  443 */       if ((getPassFlag() == null) || (getPassFlag().equals("null")))
/*  444 */         pstmt.setNull(15, 12);
/*      */       else {
/*  446 */         pstmt.setString(15, getPassFlag());
/*      */       }
/*  448 */       if ((getUWIdea() == null) || (getUWIdea().equals("null")))
/*  449 */         pstmt.setNull(16, 12);
/*      */       else {
/*  451 */         pstmt.setString(16, getUWIdea());
/*      */       }
/*  453 */       if ((getUWGrade() == null) || (getUWGrade().equals("null")))
/*  454 */         pstmt.setNull(17, 12);
/*      */       else {
/*  456 */         pstmt.setString(17, getUWGrade());
/*      */       }
/*  458 */       if ((getAppGrade() == null) || (getAppGrade().equals("null")))
/*  459 */         pstmt.setNull(18, 12);
/*      */       else {
/*  461 */         pstmt.setString(18, getAppGrade());
/*      */       }
/*  463 */       if ((getPostponeDay() == null) || (getPostponeDay().equals("null")))
/*  464 */         pstmt.setNull(19, 12);
/*      */       else {
/*  466 */         pstmt.setString(19, getPostponeDay());
/*      */       }
/*  468 */       if ((getPostponeDate() == null) || (getPostponeDate().equals("null")))
/*  469 */         pstmt.setNull(20, 91);
/*      */       else {
/*  471 */         pstmt.setDate(20, Date.valueOf(getPostponeDate()));
/*      */       }
/*  473 */       if ((getAutoUWFlag() == null) || (getAutoUWFlag().equals("null")))
/*  474 */         pstmt.setNull(21, 12);
/*      */       else {
/*  476 */         pstmt.setString(21, getAutoUWFlag());
/*      */       }
/*  478 */       if ((getState() == null) || (getState().equals("null")))
/*  479 */         pstmt.setNull(22, 12);
/*      */       else {
/*  481 */         pstmt.setString(22, getState());
/*      */       }
/*  483 */       if ((getUpReportContent() == null) || (getUpReportContent().equals("null")))
/*  484 */         pstmt.setNull(23, 12);
/*      */       else {
/*  486 */         pstmt.setString(23, getUpReportContent());
/*      */       }
/*  488 */       if ((getHealthFlag() == null) || (getHealthFlag().equals("null")))
/*  489 */         pstmt.setNull(24, 12);
/*      */       else {
/*  491 */         pstmt.setString(24, getHealthFlag());
/*      */       }
/*  493 */       if ((getQuesFlag() == null) || (getQuesFlag().equals("null")))
/*  494 */         pstmt.setNull(25, 12);
/*      */       else {
/*  496 */         pstmt.setString(25, getQuesFlag());
/*      */       }
/*  498 */       if ((getSpecFlag() == null) || (getSpecFlag().equals("null")))
/*  499 */         pstmt.setNull(26, 12);
/*      */       else {
/*  501 */         pstmt.setString(26, getSpecFlag());
/*      */       }
/*  503 */       if ((getAddPremFlag() == null) || (getAddPremFlag().equals("null")))
/*  504 */         pstmt.setNull(27, 12);
/*      */       else {
/*  506 */         pstmt.setString(27, getAddPremFlag());
/*      */       }
/*  508 */       if ((getAddPremReason() == null) || (getAddPremReason().equals("null")))
/*  509 */         pstmt.setNull(28, 12);
/*      */       else {
/*  511 */         pstmt.setString(28, getAddPremReason());
/*      */       }
/*  513 */       if ((getReportFlag() == null) || (getReportFlag().equals("null")))
/*  514 */         pstmt.setNull(29, 12);
/*      */       else {
/*  516 */         pstmt.setString(29, getReportFlag());
/*      */       }
/*  518 */       if ((getSpecReason() == null) || (getSpecReason().equals("null")))
/*  519 */         pstmt.setNull(30, 12);
/*      */       else {
/*  521 */         pstmt.setString(30, getSpecReason());
/*      */       }
/*  523 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  524 */         pstmt.setNull(31, 12);
/*      */       else {
/*  526 */         pstmt.setString(31, getOperator());
/*      */       }
/*  528 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  529 */         pstmt.setNull(32, 91);
/*      */       else {
/*  531 */         pstmt.setDate(32, Date.valueOf(getMakeDate()));
/*      */       }
/*  533 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  534 */         pstmt.setNull(33, 12);
/*      */       else {
/*  536 */         pstmt.setString(33, getMakeTime());
/*      */       }
/*  538 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  539 */         pstmt.setNull(34, 91);
/*      */       else {
/*  541 */         pstmt.setDate(34, Date.valueOf(getModifyDate()));
/*      */       }
/*  543 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  544 */         pstmt.setNull(35, 12);
/*      */       else {
/*  546 */         pstmt.setString(35, getModifyTime());
/*      */       }
/*      */ 
/*  549 */       pstmt.executeUpdate();
/*  550 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  553 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  554 */       CError tError = new CError();
/*  555 */       tError.moduleName = "LNPIndUWMasterDB";
/*  556 */       tError.functionName = "insert()";
/*  557 */       tError.errorMessage = ex.toString();
/*  558 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  561 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  564 */       if (!this.mflag)
/*      */         try {
/*  566 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  570 */       return false;
/*      */     }
/*      */ 
/*  573 */     if (!this.mflag)
/*      */       try {
/*  575 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  579 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  584 */     PreparedStatement pstmt = null;
/*  585 */     ResultSet rs = null;
/*      */ 
/*  587 */     if (!this.mflag) {
/*  588 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  593 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPIndUWMaster WHERE  ContNo = ? AND InsuredId = ?", 
/*  594 */         1003, 1007);
/*  595 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  596 */         pstmt.setNull(1, 12);
/*      */       else {
/*  598 */         pstmt.setString(1, getContNo());
/*      */       }
/*  600 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  601 */         pstmt.setNull(2, 12);
/*      */       else {
/*  603 */         pstmt.setString(2, getInsuredId());
/*      */       }
/*  605 */       rs = pstmt.executeQuery();
/*  606 */       int i = 0;
/*  607 */       if (rs.next())
/*      */       {
/*  609 */         i++;
/*  610 */         if (!setSchema(rs, i))
/*      */         {
/*  613 */           CError tError = new CError();
/*  614 */           tError.moduleName = "LNPIndUWMasterDB";
/*  615 */           tError.functionName = "getInfo";
/*  616 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  617 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  619 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  622 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  626 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  630 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  634 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  637 */       if (i == 0)
/*      */       {
/*  639 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  643 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  647 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  653 */       CError tError = new CError();
/*  654 */       tError.moduleName = "LNPIndUWMasterDB";
/*  655 */       tError.functionName = "getInfo";
/*  656 */       tError.errorMessage = e.toString();
/*  657 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  659 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  662 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  666 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  670 */       return false;
/*      */     }
/*      */ 
/*  673 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  677 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  682 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPIndUWMasterSet query()
/*      */   {
/*  687 */     Statement stmt = null;
/*  688 */     ResultSet rs = null;
/*  689 */     LNPIndUWMasterSet aLNPIndUWMasterSet = new LNPIndUWMasterSet();
/*      */ 
/*  691 */     if (!this.mflag) {
/*  692 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  697 */       stmt = this.con.createStatement(1003, 1007);
/*  698 */       SQLString sqlObj = new SQLString("LNPIndUWMaster");
/*  699 */       LNPIndUWMasterSchema aSchema = getSchema();
/*  700 */       sqlObj.setSQL(5, aSchema);
/*  701 */       String sql = sqlObj.getSQL();
/*      */ 
/*  703 */       rs = stmt.executeQuery(sql);
/*  704 */       int i = 0;
/*  705 */       while (rs.next())
/*      */       {
/*  707 */         i++;
/*  708 */         LNPIndUWMasterSchema s1 = new LNPIndUWMasterSchema();
/*  709 */         s1.setSchema(rs, i);
/*  710 */         aLNPIndUWMasterSet.add(s1);
/*      */       }try {
/*  712 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  718 */       CError tError = new CError();
/*  719 */       tError.moduleName = "LNPIndUWMasterDB";
/*  720 */       tError.functionName = "query";
/*  721 */       tError.errorMessage = e.toString();
/*  722 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  724 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  727 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  731 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  737 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  741 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  746 */     return aLNPIndUWMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPIndUWMasterSet executeQuery(String sql)
/*      */   {
/*  751 */     Statement stmt = null;
/*  752 */     ResultSet rs = null;
/*  753 */     LNPIndUWMasterSet aLNPIndUWMasterSet = new LNPIndUWMasterSet();
/*      */ 
/*  755 */     if (!this.mflag) {
/*  756 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  761 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  763 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  764 */       int i = 0;
/*  765 */       while (rs.next())
/*      */       {
/*  767 */         i++;
/*  768 */         LNPIndUWMasterSchema s1 = new LNPIndUWMasterSchema();
/*  769 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  772 */           CError tError = new CError();
/*  773 */           tError.moduleName = "LNPIndUWMasterDB";
/*  774 */           tError.functionName = "executeQuery";
/*  775 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  776 */           this.mErrors.addOneError(tError);
/*      */         }
/*  778 */         aLNPIndUWMasterSet.add(s1);
/*      */       }try {
/*  780 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  786 */       CError tError = new CError();
/*  787 */       tError.moduleName = "LNPIndUWMasterDB";
/*  788 */       tError.functionName = "executeQuery";
/*  789 */       tError.errorMessage = e.toString();
/*  790 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  792 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  795 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  799 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  805 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  809 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  814 */     return aLNPIndUWMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPIndUWMasterSet query(int nStart, int nCount)
/*      */   {
/*  819 */     Statement stmt = null;
/*  820 */     ResultSet rs = null;
/*  821 */     LNPIndUWMasterSet aLNPIndUWMasterSet = new LNPIndUWMasterSet();
/*      */ 
/*  823 */     if (!this.mflag) {
/*  824 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  829 */       stmt = this.con.createStatement(1003, 1007);
/*  830 */       SQLString sqlObj = new SQLString("LNPIndUWMaster");
/*  831 */       LNPIndUWMasterSchema aSchema = getSchema();
/*  832 */       sqlObj.setSQL(5, aSchema);
/*  833 */       String sql = sqlObj.getSQL();
/*      */ 
/*  835 */       rs = stmt.executeQuery(sql);
/*  836 */       int i = 0;
/*  837 */       while (rs.next())
/*      */       {
/*  839 */         i++;
/*      */ 
/*  841 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  845 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  849 */         LNPIndUWMasterSchema s1 = new LNPIndUWMasterSchema();
/*  850 */         s1.setSchema(rs, i);
/*  851 */         aLNPIndUWMasterSet.add(s1);
/*      */       }try {
/*  853 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  859 */       CError tError = new CError();
/*  860 */       tError.moduleName = "LNPIndUWMasterDB";
/*  861 */       tError.functionName = "query";
/*  862 */       tError.errorMessage = e.toString();
/*  863 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  865 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  868 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  872 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  878 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  882 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  887 */     return aLNPIndUWMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPIndUWMasterSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  892 */     Statement stmt = null;
/*  893 */     ResultSet rs = null;
/*  894 */     LNPIndUWMasterSet aLNPIndUWMasterSet = new LNPIndUWMasterSet();
/*      */ 
/*  896 */     if (!this.mflag) {
/*  897 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  902 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  904 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  905 */       int i = 0;
/*  906 */       while (rs.next())
/*      */       {
/*  908 */         i++;
/*      */ 
/*  910 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  914 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  918 */         LNPIndUWMasterSchema s1 = new LNPIndUWMasterSchema();
/*  919 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  922 */           CError tError = new CError();
/*  923 */           tError.moduleName = "LNPIndUWMasterDB";
/*  924 */           tError.functionName = "executeQuery";
/*  925 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  926 */           this.mErrors.addOneError(tError);
/*      */         }
/*  928 */         aLNPIndUWMasterSet.add(s1);
/*      */       }try {
/*  930 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  936 */       CError tError = new CError();
/*  937 */       tError.moduleName = "LNPIndUWMasterDB";
/*  938 */       tError.functionName = "executeQuery";
/*  939 */       tError.errorMessage = e.toString();
/*  940 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  942 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  945 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  949 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  955 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  959 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  964 */     return aLNPIndUWMasterSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  969 */     Statement stmt = null;
/*      */ 
/*  971 */     if (!this.mflag) {
/*  972 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  977 */       stmt = this.con.createStatement(1003, 1007);
/*  978 */       SQLString sqlObj = new SQLString("LNPIndUWMaster");
/*  979 */       LNPIndUWMasterSchema aSchema = getSchema();
/*  980 */       sqlObj.setSQL(2, aSchema);
/*  981 */       String sql = "update LNPIndUWMaster " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  983 */       int operCount = stmt.executeUpdate(sql);
/*  984 */       if (operCount == 0)
/*      */       {
/*  987 */         CError tError = new CError();
/*  988 */         tError.moduleName = "LNPIndUWMasterDB";
/*  989 */         tError.functionName = "update";
/*  990 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  991 */         this.mErrors.addOneError(tError);
/*      */ 
/*  993 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  997 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1001 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1007 */       CError tError = new CError();
/* 1008 */       tError.moduleName = "LNPIndUWMasterDB";
/* 1009 */       tError.functionName = "update";
/* 1010 */       tError.errorMessage = e.toString();
/* 1011 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1013 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1015 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1019 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1023 */       return false;
/*      */     }
/*      */ 
/* 1026 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1030 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1035 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1041 */     if (this.mResultSet != null)
/*      */     {
/* 1044 */       CError tError = new CError();
/* 1045 */       tError.moduleName = "LNPIndUWMasterDB";
/* 1046 */       tError.functionName = "prepareData";
/* 1047 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 1048 */       this.mErrors.addOneError(tError);
/* 1049 */       return false;
/*      */     }
/*      */ 
/* 1052 */     if (!this.mflag)
/*      */     {
/* 1054 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1058 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1059 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1064 */       CError tError = new CError();
/* 1065 */       tError.moduleName = "LNPIndUWMasterDB";
/* 1066 */       tError.functionName = "prepareData";
/* 1067 */       tError.errorMessage = e.toString();
/* 1068 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1071 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1077 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1081 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1085 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1090 */       return false;
/*      */     }
/*      */ 
/* 1093 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1097 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1102 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1108 */     boolean flag = true;
/* 1109 */     if (this.mResultSet == null)
/*      */     {
/* 1111 */       CError tError = new CError();
/* 1112 */       tError.moduleName = "LNPIndUWMasterDB";
/* 1113 */       tError.functionName = "hasMoreData";
/* 1114 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1115 */       this.mErrors.addOneError(tError);
/* 1116 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1120 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1124 */       CError tError = new CError();
/* 1125 */       tError.moduleName = "LNPIndUWMasterDB";
/* 1126 */       tError.functionName = "hasMoreData";
/* 1127 */       tError.errorMessage = ex.toString();
/* 1128 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1131 */         this.mResultSet.close();
/* 1132 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1138 */         this.mStatement.close();
/* 1139 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1143 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1147 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1152 */       return false;
/*      */     }
/* 1154 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPIndUWMasterSet getData()
/*      */   {
/* 1159 */     int tCount = 0;
/* 1160 */     LNPIndUWMasterSet tLNPIndUWMasterSet = new LNPIndUWMasterSet();
/* 1161 */     LNPIndUWMasterSchema tLNPIndUWMasterSchema = null;
/* 1162 */     if (this.mResultSet == null)
/*      */     {
/* 1164 */       CError tError = new CError();
/* 1165 */       tError.moduleName = "LNPIndUWMasterDB";
/* 1166 */       tError.functionName = "getData";
/* 1167 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1168 */       this.mErrors.addOneError(tError);
/* 1169 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1173 */       tCount = 1;
/* 1174 */       tLNPIndUWMasterSchema = new LNPIndUWMasterSchema();
/* 1175 */       tLNPIndUWMasterSchema.setSchema(this.mResultSet, 1);
/* 1176 */       tLNPIndUWMasterSet.add(tLNPIndUWMasterSchema);
/*      */ 
/* 1178 */       while (tCount++ < 5000)
/*      */       {
/* 1180 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1182 */         tLNPIndUWMasterSchema = new LNPIndUWMasterSchema();
/* 1183 */         tLNPIndUWMasterSchema.setSchema(this.mResultSet, 1);
/* 1184 */         tLNPIndUWMasterSet.add(tLNPIndUWMasterSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1190 */       CError tError = new CError();
/* 1191 */       tError.moduleName = "LNPIndUWMasterDB";
/* 1192 */       tError.functionName = "getData";
/* 1193 */       tError.errorMessage = ex.toString();
/* 1194 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1197 */         this.mResultSet.close();
/* 1198 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1204 */         this.mStatement.close();
/* 1205 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1209 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1213 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1218 */       return null;
/*      */     }
/* 1220 */     return tLNPIndUWMasterSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1225 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1228 */       if (this.mResultSet == null)
/*      */       {
/* 1230 */         CError tError = new CError();
/* 1231 */         tError.moduleName = "LNPIndUWMasterDB";
/* 1232 */         tError.functionName = "closeData";
/* 1233 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1234 */         this.mErrors.addOneError(tError);
/* 1235 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1239 */         this.mResultSet.close();
/* 1240 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1245 */       CError tError = new CError();
/* 1246 */       tError.moduleName = "LNPIndUWMasterDB";
/* 1247 */       tError.functionName = "closeData";
/* 1248 */       tError.errorMessage = ex2.toString();
/* 1249 */       this.mErrors.addOneError(tError);
/* 1250 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1254 */       if (this.mStatement == null)
/*      */       {
/* 1256 */         CError tError = new CError();
/* 1257 */         tError.moduleName = "LNPIndUWMasterDB";
/* 1258 */         tError.functionName = "closeData";
/* 1259 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1260 */         this.mErrors.addOneError(tError);
/* 1261 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1265 */         this.mStatement.close();
/* 1266 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1271 */       CError tError = new CError();
/* 1272 */       tError.moduleName = "LNPIndUWMasterDB";
/* 1273 */       tError.functionName = "closeData";
/* 1274 */       tError.errorMessage = ex3.toString();
/* 1275 */       this.mErrors.addOneError(tError);
/* 1276 */       flag = false;
/*      */     }
/* 1278 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPIndUWMasterDB
 * JD-Core Version:    0.6.0
 */