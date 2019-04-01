/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MPublicMessageBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MPublicMessageBSet;
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
/*      */ public class MPublicMessageBDB extends MPublicMessageBSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*   23 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   25 */   private ResultSet mResultSet = null;
/*   26 */   private Statement mStatement = null;
/*      */ 
/*      */   public MPublicMessageBDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MPublicMessageB");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MPublicMessageBDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MPublicMessageB");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MPublicMessageBSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MPublicMessageBDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MPublicMessageBSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MPublicMessageBDB";
/*   74 */       tError.functionName = "getCount";
/*   75 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   76 */       this.mErrors.addOneError(tError);
/*      */ 
/*   78 */       return -1;
/*      */     }
/*      */ 
/*   81 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   86 */     PreparedStatement pstmt = null;
/*      */ 
/*   88 */     if (!this.mflag) {
/*   89 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MPublicMessageB WHERE  EdorNo = ?");
/*   95 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*   96 */         pstmt.setNull(1, 12);
/*      */       else {
/*   98 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  100 */       pstmt.executeUpdate();
/*  101 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "MPublicMessageBDB";
/*  107 */       tError.functionName = "delete()";
/*  108 */       tError.errorMessage = ex.toString();
/*  109 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  112 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  115 */       if (!this.mflag)
/*      */         try {
/*  117 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  121 */       return false;
/*      */     }
/*      */ 
/*  124 */     if (!this.mflag)
/*      */       try {
/*  126 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  130 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  135 */     PreparedStatement pstmt = null;
/*      */ 
/*  137 */     if (!this.mflag) {
/*  138 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MPublicMessageB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , ID = ? , ReceiveBranch = ? , ManageCom = ? , BranchType = ? , Message = ? , Type = ? , Author = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? WHERE  EdorNo = ?");
/*  144 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  149 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getEdorType());
/*      */       }
/*  154 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getEdorCase());
/*      */       }
/*  159 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getOperator2());
/*      */       }
/*  164 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  165 */         pstmt.setNull(5, 91);
/*      */       else {
/*  167 */         pstmt.setDate(5, Date.valueOf(getMakeDate2()));
/*      */       }
/*  169 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  170 */         pstmt.setNull(6, 12);
/*      */       else {
/*  172 */         pstmt.setString(6, getMakeTime2());
/*      */       }
/*  174 */       if ((getID() == null) || (getID().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getID());
/*      */       }
/*  179 */       if ((getReceiveBranch() == null) || (getReceiveBranch().equals("null")))
/*  180 */         pstmt.setNull(8, 12);
/*      */       else {
/*  182 */         pstmt.setString(8, getReceiveBranch());
/*      */       }
/*  184 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  185 */         pstmt.setNull(9, 12);
/*      */       else {
/*  187 */         pstmt.setString(9, getManageCom());
/*      */       }
/*  189 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  190 */         pstmt.setNull(10, 12);
/*      */       else {
/*  192 */         pstmt.setString(10, getBranchType());
/*      */       }
/*  194 */       if ((getMessage() == null) || (getMessage().equals("null")))
/*  195 */         pstmt.setNull(11, 12);
/*      */       else {
/*  197 */         pstmt.setString(11, getMessage());
/*      */       }
/*  199 */       if ((getType() == null) || (getType().equals("null")))
/*  200 */         pstmt.setNull(12, 12);
/*      */       else {
/*  202 */         pstmt.setString(12, getType());
/*      */       }
/*  204 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  205 */         pstmt.setNull(13, 12);
/*      */       else {
/*  207 */         pstmt.setString(13, getAuthor());
/*      */       }
/*  209 */       if ((getState() == null) || (getState().equals("null")))
/*  210 */         pstmt.setNull(14, 12);
/*      */       else {
/*  212 */         pstmt.setString(14, getState());
/*      */       }
/*  214 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  215 */         pstmt.setNull(15, 91);
/*      */       else {
/*  217 */         pstmt.setDate(15, Date.valueOf(getStartDate()));
/*      */       }
/*  219 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  220 */         pstmt.setNull(16, 91);
/*      */       else {
/*  222 */         pstmt.setDate(16, Date.valueOf(getEndDate()));
/*      */       }
/*  224 */       if ((getStartTime() == null) || (getStartTime().equals("null")))
/*  225 */         pstmt.setNull(17, 12);
/*      */       else {
/*  227 */         pstmt.setString(17, getStartTime());
/*      */       }
/*  229 */       if ((getEndTime() == null) || (getEndTime().equals("null")))
/*  230 */         pstmt.setNull(18, 12);
/*      */       else {
/*  232 */         pstmt.setString(18, getEndTime());
/*      */       }
/*  234 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  235 */         pstmt.setNull(19, 12);
/*      */       else {
/*  237 */         pstmt.setString(19, getVF01());
/*      */       }
/*  239 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  240 */         pstmt.setNull(20, 12);
/*      */       else {
/*  242 */         pstmt.setString(20, getNF01());
/*      */       }
/*  244 */       pstmt.setInt(21, getIF01());
/*  245 */       pstmt.setDouble(22, getDF02());
/*  246 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  247 */         pstmt.setNull(23, 91);
/*      */       else {
/*  249 */         pstmt.setDate(23, Date.valueOf(getDate01()));
/*      */       }
/*  251 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  252 */         pstmt.setNull(24, 12);
/*      */       else {
/*  254 */         pstmt.setString(24, getOperator());
/*      */       }
/*  256 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  257 */         pstmt.setNull(25, 12);
/*      */       else {
/*  259 */         pstmt.setString(25, getModifyOperator());
/*      */       }
/*  261 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  262 */         pstmt.setNull(26, 91);
/*      */       else {
/*  264 */         pstmt.setDate(26, Date.valueOf(getMakeDate()));
/*      */       }
/*  266 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  267 */         pstmt.setNull(27, 12);
/*      */       else {
/*  269 */         pstmt.setString(27, getMakeTime());
/*      */       }
/*  271 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  272 */         pstmt.setNull(28, 91);
/*      */       else {
/*  274 */         pstmt.setDate(28, Date.valueOf(getModifyDate()));
/*      */       }
/*  276 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  277 */         pstmt.setNull(29, 12);
/*      */       else {
/*  279 */         pstmt.setString(29, getModifyTime());
/*      */       }
/*  281 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  282 */         pstmt.setNull(30, 12);
/*      */       else {
/*  284 */         pstmt.setString(30, getCheckState());
/*      */       }
/*  286 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  287 */         pstmt.setNull(31, 12);
/*      */       else {
/*  289 */         pstmt.setString(31, getCheckOperator());
/*      */       }
/*  291 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  292 */         pstmt.setNull(32, 12);
/*      */       else {
/*  294 */         pstmt.setString(32, getCheckReason());
/*      */       }
/*  296 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  297 */         pstmt.setNull(33, 91);
/*      */       else {
/*  299 */         pstmt.setDate(33, Date.valueOf(getCheckDate()));
/*      */       }
/*  301 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  302 */         pstmt.setNull(34, 12);
/*      */       else {
/*  304 */         pstmt.setString(34, getCheckTime());
/*      */       }
/*      */ 
/*  307 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  308 */         pstmt.setNull(35, 12);
/*      */       else {
/*  310 */         pstmt.setString(35, getEdorNo());
/*      */       }
/*  312 */       pstmt.executeUpdate();
/*  313 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  316 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  317 */       CError tError = new CError();
/*  318 */       tError.moduleName = "MPublicMessageBDB";
/*  319 */       tError.functionName = "update()";
/*  320 */       tError.errorMessage = ex.toString();
/*  321 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  324 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  327 */       if (!this.mflag)
/*      */         try {
/*  329 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  333 */       return false;
/*      */     }
/*      */ 
/*  336 */     if (!this.mflag)
/*      */       try {
/*  338 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  342 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  347 */     PreparedStatement pstmt = null;
/*      */ 
/*  349 */     if (!this.mflag) {
/*  350 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  355 */       pstmt = this.con.prepareStatement("INSERT INTO MPublicMessageB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  356 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  357 */         pstmt.setNull(1, 12);
/*      */       else {
/*  359 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  361 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  362 */         pstmt.setNull(2, 12);
/*      */       else {
/*  364 */         pstmt.setString(2, getEdorType());
/*      */       }
/*  366 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  367 */         pstmt.setNull(3, 12);
/*      */       else {
/*  369 */         pstmt.setString(3, getEdorCase());
/*      */       }
/*  371 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  372 */         pstmt.setNull(4, 12);
/*      */       else {
/*  374 */         pstmt.setString(4, getOperator2());
/*      */       }
/*  376 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  377 */         pstmt.setNull(5, 91);
/*      */       else {
/*  379 */         pstmt.setDate(5, Date.valueOf(getMakeDate2()));
/*      */       }
/*  381 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  382 */         pstmt.setNull(6, 12);
/*      */       else {
/*  384 */         pstmt.setString(6, getMakeTime2());
/*      */       }
/*  386 */       if ((getID() == null) || (getID().equals("null")))
/*  387 */         pstmt.setNull(7, 12);
/*      */       else {
/*  389 */         pstmt.setString(7, getID());
/*      */       }
/*  391 */       if ((getReceiveBranch() == null) || (getReceiveBranch().equals("null")))
/*  392 */         pstmt.setNull(8, 12);
/*      */       else {
/*  394 */         pstmt.setString(8, getReceiveBranch());
/*      */       }
/*  396 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  397 */         pstmt.setNull(9, 12);
/*      */       else {
/*  399 */         pstmt.setString(9, getManageCom());
/*      */       }
/*  401 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  402 */         pstmt.setNull(10, 12);
/*      */       else {
/*  404 */         pstmt.setString(10, getBranchType());
/*      */       }
/*  406 */       if ((getMessage() == null) || (getMessage().equals("null")))
/*  407 */         pstmt.setNull(11, 12);
/*      */       else {
/*  409 */         pstmt.setString(11, getMessage());
/*      */       }
/*  411 */       if ((getType() == null) || (getType().equals("null")))
/*  412 */         pstmt.setNull(12, 12);
/*      */       else {
/*  414 */         pstmt.setString(12, getType());
/*      */       }
/*  416 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  417 */         pstmt.setNull(13, 12);
/*      */       else {
/*  419 */         pstmt.setString(13, getAuthor());
/*      */       }
/*  421 */       if ((getState() == null) || (getState().equals("null")))
/*  422 */         pstmt.setNull(14, 12);
/*      */       else {
/*  424 */         pstmt.setString(14, getState());
/*      */       }
/*  426 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  427 */         pstmt.setNull(15, 91);
/*      */       else {
/*  429 */         pstmt.setDate(15, Date.valueOf(getStartDate()));
/*      */       }
/*  431 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  432 */         pstmt.setNull(16, 91);
/*      */       else {
/*  434 */         pstmt.setDate(16, Date.valueOf(getEndDate()));
/*      */       }
/*  436 */       if ((getStartTime() == null) || (getStartTime().equals("null")))
/*  437 */         pstmt.setNull(17, 12);
/*      */       else {
/*  439 */         pstmt.setString(17, getStartTime());
/*      */       }
/*  441 */       if ((getEndTime() == null) || (getEndTime().equals("null")))
/*  442 */         pstmt.setNull(18, 12);
/*      */       else {
/*  444 */         pstmt.setString(18, getEndTime());
/*      */       }
/*  446 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  447 */         pstmt.setNull(19, 12);
/*      */       else {
/*  449 */         pstmt.setString(19, getVF01());
/*      */       }
/*  451 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  452 */         pstmt.setNull(20, 12);
/*      */       else {
/*  454 */         pstmt.setString(20, getNF01());
/*      */       }
/*  456 */       pstmt.setInt(21, getIF01());
/*  457 */       pstmt.setDouble(22, getDF02());
/*  458 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  459 */         pstmt.setNull(23, 91);
/*      */       else {
/*  461 */         pstmt.setDate(23, Date.valueOf(getDate01()));
/*      */       }
/*  463 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  464 */         pstmt.setNull(24, 12);
/*      */       else {
/*  466 */         pstmt.setString(24, getOperator());
/*      */       }
/*  468 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  469 */         pstmt.setNull(25, 12);
/*      */       else {
/*  471 */         pstmt.setString(25, getModifyOperator());
/*      */       }
/*  473 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  474 */         pstmt.setNull(26, 91);
/*      */       else {
/*  476 */         pstmt.setDate(26, Date.valueOf(getMakeDate()));
/*      */       }
/*  478 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  479 */         pstmt.setNull(27, 12);
/*      */       else {
/*  481 */         pstmt.setString(27, getMakeTime());
/*      */       }
/*  483 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  484 */         pstmt.setNull(28, 91);
/*      */       else {
/*  486 */         pstmt.setDate(28, Date.valueOf(getModifyDate()));
/*      */       }
/*  488 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  489 */         pstmt.setNull(29, 12);
/*      */       else {
/*  491 */         pstmt.setString(29, getModifyTime());
/*      */       }
/*  493 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  494 */         pstmt.setNull(30, 12);
/*      */       else {
/*  496 */         pstmt.setString(30, getCheckState());
/*      */       }
/*  498 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  499 */         pstmt.setNull(31, 12);
/*      */       else {
/*  501 */         pstmt.setString(31, getCheckOperator());
/*      */       }
/*  503 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  504 */         pstmt.setNull(32, 12);
/*      */       else {
/*  506 */         pstmt.setString(32, getCheckReason());
/*      */       }
/*  508 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  509 */         pstmt.setNull(33, 91);
/*      */       else {
/*  511 */         pstmt.setDate(33, Date.valueOf(getCheckDate()));
/*      */       }
/*  513 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  514 */         pstmt.setNull(34, 12);
/*      */       else {
/*  516 */         pstmt.setString(34, getCheckTime());
/*      */       }
/*      */ 
/*  519 */       pstmt.executeUpdate();
/*  520 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  523 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  524 */       CError tError = new CError();
/*  525 */       tError.moduleName = "MPublicMessageBDB";
/*  526 */       tError.functionName = "insert()";
/*  527 */       tError.errorMessage = ex.toString();
/*  528 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  531 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  534 */       if (!this.mflag)
/*      */         try {
/*  536 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  540 */       return false;
/*      */     }
/*      */ 
/*  543 */     if (!this.mflag)
/*      */       try {
/*  545 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  549 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  554 */     PreparedStatement pstmt = null;
/*  555 */     ResultSet rs = null;
/*      */ 
/*  557 */     if (!this.mflag) {
/*  558 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  563 */       pstmt = this.con.prepareStatement("SELECT * FROM MPublicMessageB WHERE  EdorNo = ?", 
/*  564 */         1003, 1007);
/*  565 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  566 */         pstmt.setNull(1, 12);
/*      */       else {
/*  568 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  570 */       rs = pstmt.executeQuery();
/*  571 */       int i = 0;
/*  572 */       if (rs.next())
/*      */       {
/*  574 */         i++;
/*  575 */         if (!setSchema(rs, i))
/*      */         {
/*  578 */           CError tError = new CError();
/*  579 */           tError.moduleName = "MPublicMessageBDB";
/*  580 */           tError.functionName = "getInfo";
/*  581 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  582 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  584 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  587 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  591 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  595 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  599 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  602 */       if (i == 0)
/*      */       {
/*  604 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  608 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  612 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  618 */       CError tError = new CError();
/*  619 */       tError.moduleName = "MPublicMessageBDB";
/*  620 */       tError.functionName = "getInfo";
/*  621 */       tError.errorMessage = e.toString();
/*  622 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  624 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  627 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  631 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  635 */       return false;
/*      */     }
/*      */ 
/*  638 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  642 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  647 */     return true;
/*      */   }
/*      */ 
/*      */   public MPublicMessageBSet query()
/*      */   {
/*  652 */     Statement stmt = null;
/*  653 */     ResultSet rs = null;
/*  654 */     MPublicMessageBSet aMPublicMessageBSet = new MPublicMessageBSet();
/*      */ 
/*  656 */     if (!this.mflag) {
/*  657 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  662 */       stmt = this.con.createStatement(1003, 1007);
/*  663 */       SQLString sqlObj = new SQLString("MPublicMessageB");
/*  664 */       MPublicMessageBSchema aSchema = getSchema();
/*  665 */       sqlObj.setSQL(5, aSchema);
/*  666 */       String sql = sqlObj.getSQL();
/*      */ 
/*  668 */       rs = stmt.executeQuery(sql);
/*  669 */       int i = 0;
/*  670 */       while (rs.next())
/*      */       {
/*  672 */         i++;
/*  673 */         MPublicMessageBSchema s1 = new MPublicMessageBSchema();
/*  674 */         s1.setSchema(rs, i);
/*  675 */         aMPublicMessageBSet.add(s1);
/*      */       }try {
/*  677 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  683 */       CError tError = new CError();
/*  684 */       tError.moduleName = "MPublicMessageBDB";
/*  685 */       tError.functionName = "query";
/*  686 */       tError.errorMessage = e.toString();
/*  687 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  689 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  692 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  696 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  702 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  706 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  711 */     return aMPublicMessageBSet;
/*      */   }
/*      */ 
/*      */   public MPublicMessageBSet executeQuery(String sql)
/*      */   {
/*  716 */     Statement stmt = null;
/*  717 */     ResultSet rs = null;
/*  718 */     MPublicMessageBSet aMPublicMessageBSet = new MPublicMessageBSet();
/*      */ 
/*  720 */     if (!this.mflag) {
/*  721 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  726 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  728 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  729 */       int i = 0;
/*  730 */       while (rs.next())
/*      */       {
/*  732 */         i++;
/*  733 */         MPublicMessageBSchema s1 = new MPublicMessageBSchema();
/*  734 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  737 */           CError tError = new CError();
/*  738 */           tError.moduleName = "MPublicMessageBDB";
/*  739 */           tError.functionName = "executeQuery";
/*  740 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  741 */           this.mErrors.addOneError(tError);
/*      */         }
/*  743 */         aMPublicMessageBSet.add(s1);
/*      */       }try {
/*  745 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  751 */       CError tError = new CError();
/*  752 */       tError.moduleName = "MPublicMessageBDB";
/*  753 */       tError.functionName = "executeQuery";
/*  754 */       tError.errorMessage = e.toString();
/*  755 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  757 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  760 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  764 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  770 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  774 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  779 */     return aMPublicMessageBSet;
/*      */   }
/*      */ 
/*      */   public MPublicMessageBSet query(int nStart, int nCount)
/*      */   {
/*  784 */     Statement stmt = null;
/*  785 */     ResultSet rs = null;
/*  786 */     MPublicMessageBSet aMPublicMessageBSet = new MPublicMessageBSet();
/*      */ 
/*  788 */     if (!this.mflag) {
/*  789 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  794 */       stmt = this.con.createStatement(1003, 1007);
/*  795 */       SQLString sqlObj = new SQLString("MPublicMessageB");
/*  796 */       MPublicMessageBSchema aSchema = getSchema();
/*  797 */       sqlObj.setSQL(5, aSchema);
/*  798 */       String sql = sqlObj.getSQL();
/*      */ 
/*  800 */       rs = stmt.executeQuery(sql);
/*  801 */       int i = 0;
/*  802 */       while (rs.next())
/*      */       {
/*  804 */         i++;
/*      */ 
/*  806 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  810 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  814 */         MPublicMessageBSchema s1 = new MPublicMessageBSchema();
/*  815 */         s1.setSchema(rs, i);
/*  816 */         aMPublicMessageBSet.add(s1);
/*      */       }try {
/*  818 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  824 */       CError tError = new CError();
/*  825 */       tError.moduleName = "MPublicMessageBDB";
/*  826 */       tError.functionName = "query";
/*  827 */       tError.errorMessage = e.toString();
/*  828 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  830 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  833 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  837 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  843 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  847 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  852 */     return aMPublicMessageBSet;
/*      */   }
/*      */ 
/*      */   public MPublicMessageBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  857 */     Statement stmt = null;
/*  858 */     ResultSet rs = null;
/*  859 */     MPublicMessageBSet aMPublicMessageBSet = new MPublicMessageBSet();
/*      */ 
/*  861 */     if (!this.mflag) {
/*  862 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  867 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  869 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  870 */       int i = 0;
/*  871 */       while (rs.next())
/*      */       {
/*  873 */         i++;
/*      */ 
/*  875 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  879 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  883 */         MPublicMessageBSchema s1 = new MPublicMessageBSchema();
/*  884 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  887 */           CError tError = new CError();
/*  888 */           tError.moduleName = "MPublicMessageBDB";
/*  889 */           tError.functionName = "executeQuery";
/*  890 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  891 */           this.mErrors.addOneError(tError);
/*      */         }
/*  893 */         aMPublicMessageBSet.add(s1);
/*      */       }try {
/*  895 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  901 */       CError tError = new CError();
/*  902 */       tError.moduleName = "MPublicMessageBDB";
/*  903 */       tError.functionName = "executeQuery";
/*  904 */       tError.errorMessage = e.toString();
/*  905 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  907 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  910 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  914 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  920 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  924 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  929 */     return aMPublicMessageBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  934 */     Statement stmt = null;
/*      */ 
/*  936 */     if (!this.mflag) {
/*  937 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  942 */       stmt = this.con.createStatement(1003, 1007);
/*  943 */       SQLString sqlObj = new SQLString("MPublicMessageB");
/*  944 */       MPublicMessageBSchema aSchema = getSchema();
/*  945 */       sqlObj.setSQL(2, aSchema);
/*  946 */       String sql = "update MPublicMessageB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  948 */       int operCount = stmt.executeUpdate(sql);
/*  949 */       if (operCount == 0)
/*      */       {
/*  952 */         CError tError = new CError();
/*  953 */         tError.moduleName = "MPublicMessageBDB";
/*  954 */         tError.functionName = "update";
/*  955 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  956 */         this.mErrors.addOneError(tError);
/*      */ 
/*  958 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  962 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  966 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  972 */       CError tError = new CError();
/*  973 */       tError.moduleName = "MPublicMessageBDB";
/*  974 */       tError.functionName = "update";
/*  975 */       tError.errorMessage = e.toString();
/*  976 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  978 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  980 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  984 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  988 */       return false;
/*      */     }
/*      */ 
/*  991 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  995 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1000 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1006 */     if (this.mResultSet != null)
/*      */     {
/* 1009 */       CError tError = new CError();
/* 1010 */       tError.moduleName = "MPublicMessageBDB";
/* 1011 */       tError.functionName = "prepareData";
/* 1012 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/* 1013 */       this.mErrors.addOneError(tError);
/* 1014 */       return false;
/*      */     }
/*      */ 
/* 1017 */     if (!this.mflag)
/*      */     {
/* 1019 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1023 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1024 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1029 */       CError tError = new CError();
/* 1030 */       tError.moduleName = "MPublicMessageBDB";
/* 1031 */       tError.functionName = "prepareData";
/* 1032 */       tError.errorMessage = e.toString();
/* 1033 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1036 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1042 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1046 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1050 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1055 */       return false;
/*      */     }
/*      */ 
/* 1058 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1062 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1067 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1073 */     boolean flag = true;
/* 1074 */     if (this.mResultSet == null)
/*      */     {
/* 1076 */       CError tError = new CError();
/* 1077 */       tError.moduleName = "MPublicMessageBDB";
/* 1078 */       tError.functionName = "hasMoreData";
/* 1079 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1080 */       this.mErrors.addOneError(tError);
/* 1081 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1085 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1089 */       CError tError = new CError();
/* 1090 */       tError.moduleName = "MPublicMessageBDB";
/* 1091 */       tError.functionName = "hasMoreData";
/* 1092 */       tError.errorMessage = ex.toString();
/* 1093 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1096 */         this.mResultSet.close();
/* 1097 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1103 */         this.mStatement.close();
/* 1104 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1108 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1112 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1117 */       return false;
/*      */     }
/* 1119 */     return flag;
/*      */   }
/*      */ 
/*      */   public MPublicMessageBSet getData()
/*      */   {
/* 1124 */     int tCount = 0;
/* 1125 */     MPublicMessageBSet tMPublicMessageBSet = new MPublicMessageBSet();
/* 1126 */     MPublicMessageBSchema tMPublicMessageBSchema = null;
/* 1127 */     if (this.mResultSet == null)
/*      */     {
/* 1129 */       CError tError = new CError();
/* 1130 */       tError.moduleName = "MPublicMessageBDB";
/* 1131 */       tError.functionName = "getData";
/* 1132 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1133 */       this.mErrors.addOneError(tError);
/* 1134 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1138 */       tCount = 1;
/* 1139 */       tMPublicMessageBSchema = new MPublicMessageBSchema();
/* 1140 */       tMPublicMessageBSchema.setSchema(this.mResultSet, 1);
/* 1141 */       tMPublicMessageBSet.add(tMPublicMessageBSchema);
/*      */ 
/* 1143 */       while (tCount++ < 5000)
/*      */       {
/* 1145 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1147 */         tMPublicMessageBSchema = new MPublicMessageBSchema();
/* 1148 */         tMPublicMessageBSchema.setSchema(this.mResultSet, 1);
/* 1149 */         tMPublicMessageBSet.add(tMPublicMessageBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1155 */       CError tError = new CError();
/* 1156 */       tError.moduleName = "MPublicMessageBDB";
/* 1157 */       tError.functionName = "getData";
/* 1158 */       tError.errorMessage = ex.toString();
/* 1159 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1162 */         this.mResultSet.close();
/* 1163 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1169 */         this.mStatement.close();
/* 1170 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1174 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1178 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1183 */       return null;
/*      */     }
/* 1185 */     return tMPublicMessageBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1190 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1193 */       if (this.mResultSet == null)
/*      */       {
/* 1195 */         CError tError = new CError();
/* 1196 */         tError.moduleName = "MPublicMessageBDB";
/* 1197 */         tError.functionName = "closeData";
/* 1198 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1199 */         this.mErrors.addOneError(tError);
/* 1200 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1204 */         this.mResultSet.close();
/* 1205 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1210 */       CError tError = new CError();
/* 1211 */       tError.moduleName = "MPublicMessageBDB";
/* 1212 */       tError.functionName = "closeData";
/* 1213 */       tError.errorMessage = ex2.toString();
/* 1214 */       this.mErrors.addOneError(tError);
/* 1215 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1219 */       if (this.mStatement == null)
/*      */       {
/* 1221 */         CError tError = new CError();
/* 1222 */         tError.moduleName = "MPublicMessageBDB";
/* 1223 */         tError.functionName = "closeData";
/* 1224 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1225 */         this.mErrors.addOneError(tError);
/* 1226 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1230 */         this.mStatement.close();
/* 1231 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1236 */       CError tError = new CError();
/* 1237 */       tError.moduleName = "MPublicMessageBDB";
/* 1238 */       tError.functionName = "closeData";
/* 1239 */       tError.errorMessage = ex3.toString();
/* 1240 */       this.mErrors.addOneError(tError);
/* 1241 */       flag = false;
/*      */     }
/* 1243 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MPublicMessageBDB
 * JD-Core Version:    0.6.0
 */