/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPCUWMasterSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCUWMasterSet;
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
/*      */ public class LNPCUWMasterDB extends LNPCUWMasterSchema
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
/*      */   public LNPCUWMasterDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPCUWMaster");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPCUWMasterDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPCUWMaster");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPCUWMasterSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPCUWMasterDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPCUWMasterSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPCUWMasterDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCUWMaster WHERE  ContNo = ?");
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
/*  108 */       tError.moduleName = "LNPCUWMasterDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPCUWMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , UWNo = ? , ManageCom = ? , UWDate = ? , UWTime = ? , UWerName = ? , CheckStatus = ? , AppIsCompleted = ? , AppIsSubmitted = ? , AppDecision = ? , AutoUWFlag = ? , UWMessages = ? , UWGrade = ? , AppGrade = ? , State = ? , UpReportContent = ? , HealthFlag = ? , QuesFlag = ? , SpecFlag = ? , AddPremFlag = ? , AddPremReason = ? , SpecReason = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ?");
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
/*  161 */       pstmt.setInt(4, getUWNo());
/*  162 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  163 */         pstmt.setNull(5, 12);
/*      */       else {
/*  165 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  167 */       if ((getUWDate() == null) || (getUWDate().equals("null")))
/*  168 */         pstmt.setNull(6, 91);
/*      */       else {
/*  170 */         pstmt.setDate(6, Date.valueOf(getUWDate()));
/*      */       }
/*  172 */       if ((getUWTime() == null) || (getUWTime().equals("null")))
/*  173 */         pstmt.setNull(7, 12);
/*      */       else {
/*  175 */         pstmt.setString(7, getUWTime());
/*      */       }
/*  177 */       if ((getUWerName() == null) || (getUWerName().equals("null")))
/*  178 */         pstmt.setNull(8, 12);
/*      */       else {
/*  180 */         pstmt.setString(8, getUWerName());
/*      */       }
/*  182 */       if ((getCheckStatus() == null) || (getCheckStatus().equals("null")))
/*  183 */         pstmt.setNull(9, 12);
/*      */       else {
/*  185 */         pstmt.setString(9, getCheckStatus());
/*      */       }
/*  187 */       if ((getAppIsCompleted() == null) || (getAppIsCompleted().equals("null")))
/*  188 */         pstmt.setNull(10, 12);
/*      */       else {
/*  190 */         pstmt.setString(10, getAppIsCompleted());
/*      */       }
/*  192 */       if ((getAppIsSubmitted() == null) || (getAppIsSubmitted().equals("null")))
/*  193 */         pstmt.setNull(11, 12);
/*      */       else {
/*  195 */         pstmt.setString(11, getAppIsSubmitted());
/*      */       }
/*  197 */       if ((getAppDecision() == null) || (getAppDecision().equals("null")))
/*  198 */         pstmt.setNull(12, 12);
/*      */       else {
/*  200 */         pstmt.setString(12, getAppDecision());
/*      */       }
/*  202 */       if ((getAutoUWFlag() == null) || (getAutoUWFlag().equals("null")))
/*  203 */         pstmt.setNull(13, 12);
/*      */       else {
/*  205 */         pstmt.setString(13, getAutoUWFlag());
/*      */       }
/*  207 */       if ((getUWMessages() == null) || (getUWMessages().equals("null")))
/*  208 */         pstmt.setNull(14, 12);
/*      */       else {
/*  210 */         pstmt.setString(14, getUWMessages());
/*      */       }
/*  212 */       if ((getUWGrade() == null) || (getUWGrade().equals("null")))
/*  213 */         pstmt.setNull(15, 12);
/*      */       else {
/*  215 */         pstmt.setString(15, getUWGrade());
/*      */       }
/*  217 */       if ((getAppGrade() == null) || (getAppGrade().equals("null")))
/*  218 */         pstmt.setNull(16, 12);
/*      */       else {
/*  220 */         pstmt.setString(16, getAppGrade());
/*      */       }
/*  222 */       if ((getState() == null) || (getState().equals("null")))
/*  223 */         pstmt.setNull(17, 12);
/*      */       else {
/*  225 */         pstmt.setString(17, getState());
/*      */       }
/*  227 */       if ((getUpReportContent() == null) || (getUpReportContent().equals("null")))
/*  228 */         pstmt.setNull(18, 12);
/*      */       else {
/*  230 */         pstmt.setString(18, getUpReportContent());
/*      */       }
/*  232 */       if ((getHealthFlag() == null) || (getHealthFlag().equals("null")))
/*  233 */         pstmt.setNull(19, 12);
/*      */       else {
/*  235 */         pstmt.setString(19, getHealthFlag());
/*      */       }
/*  237 */       if ((getQuesFlag() == null) || (getQuesFlag().equals("null")))
/*  238 */         pstmt.setNull(20, 12);
/*      */       else {
/*  240 */         pstmt.setString(20, getQuesFlag());
/*      */       }
/*  242 */       if ((getSpecFlag() == null) || (getSpecFlag().equals("null")))
/*  243 */         pstmt.setNull(21, 12);
/*      */       else {
/*  245 */         pstmt.setString(21, getSpecFlag());
/*      */       }
/*  247 */       if ((getAddPremFlag() == null) || (getAddPremFlag().equals("null")))
/*  248 */         pstmt.setNull(22, 12);
/*      */       else {
/*  250 */         pstmt.setString(22, getAddPremFlag());
/*      */       }
/*  252 */       if ((getAddPremReason() == null) || (getAddPremReason().equals("null")))
/*  253 */         pstmt.setNull(23, 12);
/*      */       else {
/*  255 */         pstmt.setString(23, getAddPremReason());
/*      */       }
/*  257 */       if ((getSpecReason() == null) || (getSpecReason().equals("null")))
/*  258 */         pstmt.setNull(24, 12);
/*      */       else {
/*  260 */         pstmt.setString(24, getSpecReason());
/*      */       }
/*  262 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  263 */         pstmt.setNull(25, 12);
/*      */       else {
/*  265 */         pstmt.setString(25, getOperator());
/*      */       }
/*  267 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  268 */         pstmt.setNull(26, 91);
/*      */       else {
/*  270 */         pstmt.setDate(26, Date.valueOf(getMakeDate()));
/*      */       }
/*  272 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  273 */         pstmt.setNull(27, 12);
/*      */       else {
/*  275 */         pstmt.setString(27, getMakeTime());
/*      */       }
/*  277 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  278 */         pstmt.setNull(28, 91);
/*      */       else {
/*  280 */         pstmt.setDate(28, Date.valueOf(getModifyDate()));
/*      */       }
/*  282 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  283 */         pstmt.setNull(29, 12);
/*      */       else {
/*  285 */         pstmt.setString(29, getModifyTime());
/*      */       }
/*      */ 
/*  288 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  289 */         pstmt.setNull(30, 12);
/*      */       else {
/*  291 */         pstmt.setString(30, getContNo());
/*      */       }
/*  293 */       pstmt.executeUpdate();
/*  294 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  297 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  298 */       CError tError = new CError();
/*  299 */       tError.moduleName = "LNPCUWMasterDB";
/*  300 */       tError.functionName = "update()";
/*  301 */       tError.errorMessage = ex.toString();
/*  302 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  305 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  308 */       if (!this.mflag)
/*      */         try {
/*  310 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  314 */       return false;
/*      */     }
/*      */ 
/*  317 */     if (!this.mflag)
/*      */       try {
/*  319 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  323 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  328 */     PreparedStatement pstmt = null;
/*      */ 
/*  330 */     if (!this.mflag) {
/*  331 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  336 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCUWMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  337 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  338 */         pstmt.setNull(1, 12);
/*      */       else {
/*  340 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  342 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  343 */         pstmt.setNull(2, 12);
/*      */       else {
/*  345 */         pstmt.setString(2, getContNo());
/*      */       }
/*  347 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  348 */         pstmt.setNull(3, 12);
/*      */       else {
/*  350 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  352 */       pstmt.setInt(4, getUWNo());
/*  353 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  354 */         pstmt.setNull(5, 12);
/*      */       else {
/*  356 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  358 */       if ((getUWDate() == null) || (getUWDate().equals("null")))
/*  359 */         pstmt.setNull(6, 91);
/*      */       else {
/*  361 */         pstmt.setDate(6, Date.valueOf(getUWDate()));
/*      */       }
/*  363 */       if ((getUWTime() == null) || (getUWTime().equals("null")))
/*  364 */         pstmt.setNull(7, 12);
/*      */       else {
/*  366 */         pstmt.setString(7, getUWTime());
/*      */       }
/*  368 */       if ((getUWerName() == null) || (getUWerName().equals("null")))
/*  369 */         pstmt.setNull(8, 12);
/*      */       else {
/*  371 */         pstmt.setString(8, getUWerName());
/*      */       }
/*  373 */       if ((getCheckStatus() == null) || (getCheckStatus().equals("null")))
/*  374 */         pstmt.setNull(9, 12);
/*      */       else {
/*  376 */         pstmt.setString(9, getCheckStatus());
/*      */       }
/*  378 */       if ((getAppIsCompleted() == null) || (getAppIsCompleted().equals("null")))
/*  379 */         pstmt.setNull(10, 12);
/*      */       else {
/*  381 */         pstmt.setString(10, getAppIsCompleted());
/*      */       }
/*  383 */       if ((getAppIsSubmitted() == null) || (getAppIsSubmitted().equals("null")))
/*  384 */         pstmt.setNull(11, 12);
/*      */       else {
/*  386 */         pstmt.setString(11, getAppIsSubmitted());
/*      */       }
/*  388 */       if ((getAppDecision() == null) || (getAppDecision().equals("null")))
/*  389 */         pstmt.setNull(12, 12);
/*      */       else {
/*  391 */         pstmt.setString(12, getAppDecision());
/*      */       }
/*  393 */       if ((getAutoUWFlag() == null) || (getAutoUWFlag().equals("null")))
/*  394 */         pstmt.setNull(13, 12);
/*      */       else {
/*  396 */         pstmt.setString(13, getAutoUWFlag());
/*      */       }
/*  398 */       if ((getUWMessages() == null) || (getUWMessages().equals("null")))
/*  399 */         pstmt.setNull(14, 12);
/*      */       else {
/*  401 */         pstmt.setString(14, getUWMessages());
/*      */       }
/*  403 */       if ((getUWGrade() == null) || (getUWGrade().equals("null")))
/*  404 */         pstmt.setNull(15, 12);
/*      */       else {
/*  406 */         pstmt.setString(15, getUWGrade());
/*      */       }
/*  408 */       if ((getAppGrade() == null) || (getAppGrade().equals("null")))
/*  409 */         pstmt.setNull(16, 12);
/*      */       else {
/*  411 */         pstmt.setString(16, getAppGrade());
/*      */       }
/*  413 */       if ((getState() == null) || (getState().equals("null")))
/*  414 */         pstmt.setNull(17, 12);
/*      */       else {
/*  416 */         pstmt.setString(17, getState());
/*      */       }
/*  418 */       if ((getUpReportContent() == null) || (getUpReportContent().equals("null")))
/*  419 */         pstmt.setNull(18, 12);
/*      */       else {
/*  421 */         pstmt.setString(18, getUpReportContent());
/*      */       }
/*  423 */       if ((getHealthFlag() == null) || (getHealthFlag().equals("null")))
/*  424 */         pstmt.setNull(19, 12);
/*      */       else {
/*  426 */         pstmt.setString(19, getHealthFlag());
/*      */       }
/*  428 */       if ((getQuesFlag() == null) || (getQuesFlag().equals("null")))
/*  429 */         pstmt.setNull(20, 12);
/*      */       else {
/*  431 */         pstmt.setString(20, getQuesFlag());
/*      */       }
/*  433 */       if ((getSpecFlag() == null) || (getSpecFlag().equals("null")))
/*  434 */         pstmt.setNull(21, 12);
/*      */       else {
/*  436 */         pstmt.setString(21, getSpecFlag());
/*      */       }
/*  438 */       if ((getAddPremFlag() == null) || (getAddPremFlag().equals("null")))
/*  439 */         pstmt.setNull(22, 12);
/*      */       else {
/*  441 */         pstmt.setString(22, getAddPremFlag());
/*      */       }
/*  443 */       if ((getAddPremReason() == null) || (getAddPremReason().equals("null")))
/*  444 */         pstmt.setNull(23, 12);
/*      */       else {
/*  446 */         pstmt.setString(23, getAddPremReason());
/*      */       }
/*  448 */       if ((getSpecReason() == null) || (getSpecReason().equals("null")))
/*  449 */         pstmt.setNull(24, 12);
/*      */       else {
/*  451 */         pstmt.setString(24, getSpecReason());
/*      */       }
/*  453 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  454 */         pstmt.setNull(25, 12);
/*      */       else {
/*  456 */         pstmt.setString(25, getOperator());
/*      */       }
/*  458 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  459 */         pstmt.setNull(26, 91);
/*      */       else {
/*  461 */         pstmt.setDate(26, Date.valueOf(getMakeDate()));
/*      */       }
/*  463 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  464 */         pstmt.setNull(27, 12);
/*      */       else {
/*  466 */         pstmt.setString(27, getMakeTime());
/*      */       }
/*  468 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  469 */         pstmt.setNull(28, 91);
/*      */       else {
/*  471 */         pstmt.setDate(28, Date.valueOf(getModifyDate()));
/*      */       }
/*  473 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  474 */         pstmt.setNull(29, 12);
/*      */       else {
/*  476 */         pstmt.setString(29, getModifyTime());
/*      */       }
/*      */ 
/*  479 */       pstmt.executeUpdate();
/*  480 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  483 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  484 */       CError tError = new CError();
/*  485 */       tError.moduleName = "LNPCUWMasterDB";
/*  486 */       tError.functionName = "insert()";
/*  487 */       tError.errorMessage = ex.toString();
/*  488 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  491 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  494 */       if (!this.mflag)
/*      */         try {
/*  496 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  500 */       return false;
/*      */     }
/*      */ 
/*  503 */     if (!this.mflag)
/*      */       try {
/*  505 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  509 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  514 */     PreparedStatement pstmt = null;
/*  515 */     ResultSet rs = null;
/*      */ 
/*  517 */     if (!this.mflag) {
/*  518 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  523 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPCUWMaster WHERE  ContNo = ?", 
/*  524 */         1003, 1007);
/*  525 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  526 */         pstmt.setNull(1, 12);
/*      */       else {
/*  528 */         pstmt.setString(1, getContNo());
/*      */       }
/*  530 */       rs = pstmt.executeQuery();
/*  531 */       int i = 0;
/*  532 */       if (rs.next())
/*      */       {
/*  534 */         i++;
/*  535 */         if (!setSchema(rs, i))
/*      */         {
/*  538 */           CError tError = new CError();
/*  539 */           tError.moduleName = "LNPCUWMasterDB";
/*  540 */           tError.functionName = "getInfo";
/*  541 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  542 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  544 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  547 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  551 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  555 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  559 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  562 */       if (i == 0)
/*      */       {
/*  564 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  568 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  572 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  578 */       CError tError = new CError();
/*  579 */       tError.moduleName = "LNPCUWMasterDB";
/*  580 */       tError.functionName = "getInfo";
/*  581 */       tError.errorMessage = e.toString();
/*  582 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  584 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  587 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  591 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  595 */       return false;
/*      */     }
/*      */ 
/*  598 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  602 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  607 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPCUWMasterSet query()
/*      */   {
/*  612 */     Statement stmt = null;
/*  613 */     ResultSet rs = null;
/*  614 */     LNPCUWMasterSet aLNPCUWMasterSet = new LNPCUWMasterSet();
/*      */ 
/*  616 */     if (!this.mflag) {
/*  617 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  622 */       stmt = this.con.createStatement(1003, 1007);
/*  623 */       SQLString sqlObj = new SQLString("LNPCUWMaster");
/*  624 */       LNPCUWMasterSchema aSchema = getSchema();
/*  625 */       sqlObj.setSQL(5, aSchema);
/*  626 */       String sql = sqlObj.getSQL();
/*      */ 
/*  628 */       rs = stmt.executeQuery(sql);
/*  629 */       int i = 0;
/*  630 */       while (rs.next())
/*      */       {
/*  632 */         i++;
/*  633 */         LNPCUWMasterSchema s1 = new LNPCUWMasterSchema();
/*  634 */         s1.setSchema(rs, i);
/*  635 */         aLNPCUWMasterSet.add(s1);
/*      */       }try {
/*  637 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  643 */       CError tError = new CError();
/*  644 */       tError.moduleName = "LNPCUWMasterDB";
/*  645 */       tError.functionName = "query";
/*  646 */       tError.errorMessage = e.toString();
/*  647 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  649 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  652 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  656 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  662 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  666 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  671 */     return aLNPCUWMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPCUWMasterSet executeQuery(String sql)
/*      */   {
/*  676 */     Statement stmt = null;
/*  677 */     ResultSet rs = null;
/*  678 */     LNPCUWMasterSet aLNPCUWMasterSet = new LNPCUWMasterSet();
/*      */ 
/*  680 */     if (!this.mflag) {
/*  681 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  686 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  688 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  689 */       int i = 0;
/*  690 */       while (rs.next())
/*      */       {
/*  692 */         i++;
/*  693 */         LNPCUWMasterSchema s1 = new LNPCUWMasterSchema();
/*  694 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  697 */           CError tError = new CError();
/*  698 */           tError.moduleName = "LNPCUWMasterDB";
/*  699 */           tError.functionName = "executeQuery";
/*  700 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  701 */           this.mErrors.addOneError(tError);
/*      */         }
/*  703 */         aLNPCUWMasterSet.add(s1);
/*      */       }try {
/*  705 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  711 */       CError tError = new CError();
/*  712 */       tError.moduleName = "LNPCUWMasterDB";
/*  713 */       tError.functionName = "executeQuery";
/*  714 */       tError.errorMessage = e.toString();
/*  715 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  717 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  720 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  724 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  730 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  734 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  739 */     return aLNPCUWMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPCUWMasterSet query(int nStart, int nCount)
/*      */   {
/*  744 */     Statement stmt = null;
/*  745 */     ResultSet rs = null;
/*  746 */     LNPCUWMasterSet aLNPCUWMasterSet = new LNPCUWMasterSet();
/*      */ 
/*  748 */     if (!this.mflag) {
/*  749 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  754 */       stmt = this.con.createStatement(1003, 1007);
/*  755 */       SQLString sqlObj = new SQLString("LNPCUWMaster");
/*  756 */       LNPCUWMasterSchema aSchema = getSchema();
/*  757 */       sqlObj.setSQL(5, aSchema);
/*  758 */       String sql = sqlObj.getSQL();
/*      */ 
/*  760 */       rs = stmt.executeQuery(sql);
/*  761 */       int i = 0;
/*  762 */       while (rs.next())
/*      */       {
/*  764 */         i++;
/*      */ 
/*  766 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  770 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  774 */         LNPCUWMasterSchema s1 = new LNPCUWMasterSchema();
/*  775 */         s1.setSchema(rs, i);
/*  776 */         aLNPCUWMasterSet.add(s1);
/*      */       }try {
/*  778 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  784 */       CError tError = new CError();
/*  785 */       tError.moduleName = "LNPCUWMasterDB";
/*  786 */       tError.functionName = "query";
/*  787 */       tError.errorMessage = e.toString();
/*  788 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  790 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  793 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  797 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  803 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  807 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  812 */     return aLNPCUWMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPCUWMasterSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  817 */     Statement stmt = null;
/*  818 */     ResultSet rs = null;
/*  819 */     LNPCUWMasterSet aLNPCUWMasterSet = new LNPCUWMasterSet();
/*      */ 
/*  821 */     if (!this.mflag) {
/*  822 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  827 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  829 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  830 */       int i = 0;
/*  831 */       while (rs.next())
/*      */       {
/*  833 */         i++;
/*      */ 
/*  835 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  839 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  843 */         LNPCUWMasterSchema s1 = new LNPCUWMasterSchema();
/*  844 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  847 */           CError tError = new CError();
/*  848 */           tError.moduleName = "LNPCUWMasterDB";
/*  849 */           tError.functionName = "executeQuery";
/*  850 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  851 */           this.mErrors.addOneError(tError);
/*      */         }
/*  853 */         aLNPCUWMasterSet.add(s1);
/*      */       }try {
/*  855 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  861 */       CError tError = new CError();
/*  862 */       tError.moduleName = "LNPCUWMasterDB";
/*  863 */       tError.functionName = "executeQuery";
/*  864 */       tError.errorMessage = e.toString();
/*  865 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  867 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  870 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  874 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  880 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  884 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  889 */     return aLNPCUWMasterSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  894 */     Statement stmt = null;
/*      */ 
/*  896 */     if (!this.mflag) {
/*  897 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  902 */       stmt = this.con.createStatement(1003, 1007);
/*  903 */       SQLString sqlObj = new SQLString("LNPCUWMaster");
/*  904 */       LNPCUWMasterSchema aSchema = getSchema();
/*  905 */       sqlObj.setSQL(2, aSchema);
/*  906 */       String sql = "update LNPCUWMaster " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  908 */       int operCount = stmt.executeUpdate(sql);
/*  909 */       if (operCount == 0)
/*      */       {
/*  912 */         CError tError = new CError();
/*  913 */         tError.moduleName = "LNPCUWMasterDB";
/*  914 */         tError.functionName = "update";
/*  915 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  916 */         this.mErrors.addOneError(tError);
/*      */ 
/*  918 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  922 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  926 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  932 */       CError tError = new CError();
/*  933 */       tError.moduleName = "LNPCUWMasterDB";
/*  934 */       tError.functionName = "update";
/*  935 */       tError.errorMessage = e.toString();
/*  936 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  938 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  940 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  944 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  948 */       return false;
/*      */     }
/*      */ 
/*  951 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  955 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  960 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  966 */     if (this.mResultSet != null)
/*      */     {
/*  969 */       CError tError = new CError();
/*  970 */       tError.moduleName = "LNPCUWMasterDB";
/*  971 */       tError.functionName = "prepareData";
/*  972 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  973 */       this.mErrors.addOneError(tError);
/*  974 */       return false;
/*      */     }
/*      */ 
/*  977 */     if (!this.mflag)
/*      */     {
/*  979 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  983 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  984 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  989 */       CError tError = new CError();
/*  990 */       tError.moduleName = "LNPCUWMasterDB";
/*  991 */       tError.functionName = "prepareData";
/*  992 */       tError.errorMessage = e.toString();
/*  993 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  996 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1002 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1006 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1010 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1015 */       return false;
/*      */     }
/*      */ 
/* 1018 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1022 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1027 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1033 */     boolean flag = true;
/* 1034 */     if (this.mResultSet == null)
/*      */     {
/* 1036 */       CError tError = new CError();
/* 1037 */       tError.moduleName = "LNPCUWMasterDB";
/* 1038 */       tError.functionName = "hasMoreData";
/* 1039 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1040 */       this.mErrors.addOneError(tError);
/* 1041 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1045 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1049 */       CError tError = new CError();
/* 1050 */       tError.moduleName = "LNPCUWMasterDB";
/* 1051 */       tError.functionName = "hasMoreData";
/* 1052 */       tError.errorMessage = ex.toString();
/* 1053 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1056 */         this.mResultSet.close();
/* 1057 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1063 */         this.mStatement.close();
/* 1064 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1068 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1072 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1077 */       return false;
/*      */     }
/* 1079 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPCUWMasterSet getData()
/*      */   {
/* 1084 */     int tCount = 0;
/* 1085 */     LNPCUWMasterSet tLNPCUWMasterSet = new LNPCUWMasterSet();
/* 1086 */     LNPCUWMasterSchema tLNPCUWMasterSchema = null;
/* 1087 */     if (this.mResultSet == null)
/*      */     {
/* 1089 */       CError tError = new CError();
/* 1090 */       tError.moduleName = "LNPCUWMasterDB";
/* 1091 */       tError.functionName = "getData";
/* 1092 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1093 */       this.mErrors.addOneError(tError);
/* 1094 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1098 */       tCount = 1;
/* 1099 */       tLNPCUWMasterSchema = new LNPCUWMasterSchema();
/* 1100 */       tLNPCUWMasterSchema.setSchema(this.mResultSet, 1);
/* 1101 */       tLNPCUWMasterSet.add(tLNPCUWMasterSchema);
/*      */ 
/* 1103 */       while (tCount++ < 5000)
/*      */       {
/* 1105 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1107 */         tLNPCUWMasterSchema = new LNPCUWMasterSchema();
/* 1108 */         tLNPCUWMasterSchema.setSchema(this.mResultSet, 1);
/* 1109 */         tLNPCUWMasterSet.add(tLNPCUWMasterSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1115 */       CError tError = new CError();
/* 1116 */       tError.moduleName = "LNPCUWMasterDB";
/* 1117 */       tError.functionName = "getData";
/* 1118 */       tError.errorMessage = ex.toString();
/* 1119 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1122 */         this.mResultSet.close();
/* 1123 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1129 */         this.mStatement.close();
/* 1130 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1134 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1138 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1143 */       return null;
/*      */     }
/* 1145 */     return tLNPCUWMasterSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1150 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1153 */       if (this.mResultSet == null)
/*      */       {
/* 1155 */         CError tError = new CError();
/* 1156 */         tError.moduleName = "LNPCUWMasterDB";
/* 1157 */         tError.functionName = "closeData";
/* 1158 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1159 */         this.mErrors.addOneError(tError);
/* 1160 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1164 */         this.mResultSet.close();
/* 1165 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1170 */       CError tError = new CError();
/* 1171 */       tError.moduleName = "LNPCUWMasterDB";
/* 1172 */       tError.functionName = "closeData";
/* 1173 */       tError.errorMessage = ex2.toString();
/* 1174 */       this.mErrors.addOneError(tError);
/* 1175 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1179 */       if (this.mStatement == null)
/*      */       {
/* 1181 */         CError tError = new CError();
/* 1182 */         tError.moduleName = "LNPCUWMasterDB";
/* 1183 */         tError.functionName = "closeData";
/* 1184 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1185 */         this.mErrors.addOneError(tError);
/* 1186 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1190 */         this.mStatement.close();
/* 1191 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1196 */       CError tError = new CError();
/* 1197 */       tError.moduleName = "LNPCUWMasterDB";
/* 1198 */       tError.functionName = "closeData";
/* 1199 */       tError.errorMessage = ex3.toString();
/* 1200 */       this.mErrors.addOneError(tError);
/* 1201 */       flag = false;
/*      */     }
/* 1203 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPCUWMasterDB
 * JD-Core Version:    0.6.0
 */