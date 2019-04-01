/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MInvTopicBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MInvTopicBSet;
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
/*      */ public class MInvTopicBDB extends MInvTopicBSchema
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
/*      */   public MInvTopicBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MInvTopicB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MInvTopicBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MInvTopicB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MInvTopicBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MInvTopicBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MInvTopicBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MInvTopicBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MInvTopicB WHERE  EdorNo = ?");
/*   96 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MInvTopicBDB";
/*  108 */       tError.functionName = "delete()";
/*  109 */       tError.errorMessage = ex.toString();
/*  110 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  113 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  116 */       if (!this.mflag)
/*      */         try {
/*  118 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  122 */       return false;
/*      */     }
/*      */ 
/*  125 */     if (!this.mflag)
/*      */       try {
/*  127 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  131 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  136 */     PreparedStatement pstmt = null;
/*      */ 
/*  138 */     if (!this.mflag) {
/*  139 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MInvTopicB SET  TopicID = ? , Topic = ? , ManageCom = ? , BranchType = ? , Depiction = ? , Author = ? , Population = ? , StartDate = ? , EndDate = ? , InvType = ? , State = ? , InvState = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/*  145 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getTopicID());
/*      */       }
/*  150 */       if ((getTopic() == null) || (getTopic().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getTopic());
/*      */       }
/*  155 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  160 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  165 */       if ((getDepiction() == null) || (getDepiction().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getDepiction());
/*      */       }
/*  170 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getAuthor());
/*      */       }
/*  175 */       pstmt.setInt(7, getPopulation());
/*  176 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  177 */         pstmt.setNull(8, 91);
/*      */       else {
/*  179 */         pstmt.setDate(8, Date.valueOf(getStartDate()));
/*      */       }
/*  181 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  182 */         pstmt.setNull(9, 91);
/*      */       else {
/*  184 */         pstmt.setDate(9, Date.valueOf(getEndDate()));
/*      */       }
/*  186 */       if ((getInvType() == null) || (getInvType().equals("null")))
/*  187 */         pstmt.setNull(10, 12);
/*      */       else {
/*  189 */         pstmt.setString(10, getInvType());
/*      */       }
/*  191 */       if ((getState() == null) || (getState().equals("null")))
/*  192 */         pstmt.setNull(11, 12);
/*      */       else {
/*  194 */         pstmt.setString(11, getState());
/*      */       }
/*  196 */       if ((getInvState() == null) || (getInvState().equals("null")))
/*  197 */         pstmt.setNull(12, 12);
/*      */       else {
/*  199 */         pstmt.setString(12, getInvState());
/*      */       }
/*  201 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  202 */         pstmt.setNull(13, 12);
/*      */       else {
/*  204 */         pstmt.setString(13, getCheckState());
/*      */       }
/*  206 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  207 */         pstmt.setNull(14, 12);
/*      */       else {
/*  209 */         pstmt.setString(14, getCheckOperator());
/*      */       }
/*  211 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  212 */         pstmt.setNull(15, 12);
/*      */       else {
/*  214 */         pstmt.setString(15, getCheckReason());
/*      */       }
/*  216 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  217 */         pstmt.setNull(16, 91);
/*      */       else {
/*  219 */         pstmt.setDate(16, Date.valueOf(getCheckDate()));
/*      */       }
/*  221 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  222 */         pstmt.setNull(17, 12);
/*      */       else {
/*  224 */         pstmt.setString(17, getCheckTime());
/*      */       }
/*  226 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  227 */         pstmt.setNull(18, 12);
/*      */       else {
/*  229 */         pstmt.setString(18, getVF01());
/*      */       }
/*  231 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  232 */         pstmt.setNull(19, 12);
/*      */       else {
/*  234 */         pstmt.setString(19, getNF01());
/*      */       }
/*  236 */       pstmt.setInt(20, getIF01());
/*  237 */       pstmt.setDouble(21, getDF02());
/*  238 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  239 */         pstmt.setNull(22, 91);
/*      */       else {
/*  241 */         pstmt.setDate(22, Date.valueOf(getDate01()));
/*      */       }
/*  243 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  244 */         pstmt.setNull(23, 12);
/*      */       else {
/*  246 */         pstmt.setString(23, getModifyOperator());
/*      */       }
/*  248 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  249 */         pstmt.setNull(24, 12);
/*      */       else {
/*  251 */         pstmt.setString(24, getOperator());
/*      */       }
/*  253 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  254 */         pstmt.setNull(25, 91);
/*      */       else {
/*  256 */         pstmt.setDate(25, Date.valueOf(getMakeDate()));
/*      */       }
/*  258 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  259 */         pstmt.setNull(26, 12);
/*      */       else {
/*  261 */         pstmt.setString(26, getMakeTime());
/*      */       }
/*  263 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  264 */         pstmt.setNull(27, 91);
/*      */       else {
/*  266 */         pstmt.setDate(27, Date.valueOf(getModifyDate()));
/*      */       }
/*  268 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  269 */         pstmt.setNull(28, 12);
/*      */       else {
/*  271 */         pstmt.setString(28, getModifyTime());
/*      */       }
/*  273 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  274 */         pstmt.setNull(29, 12);
/*      */       else {
/*  276 */         pstmt.setString(29, getEdorNo());
/*      */       }
/*  278 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  279 */         pstmt.setNull(30, 12);
/*      */       else {
/*  281 */         pstmt.setString(30, getEdorType());
/*      */       }
/*  283 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  284 */         pstmt.setNull(31, 12);
/*      */       else {
/*  286 */         pstmt.setString(31, getEdorCase());
/*      */       }
/*  288 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  289 */         pstmt.setNull(32, 12);
/*      */       else {
/*  291 */         pstmt.setString(32, getOperator2());
/*      */       }
/*  293 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  294 */         pstmt.setNull(33, 91);
/*      */       else {
/*  296 */         pstmt.setDate(33, Date.valueOf(getMakeDate2()));
/*      */       }
/*  298 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  299 */         pstmt.setNull(34, 12);
/*      */       else {
/*  301 */         pstmt.setString(34, getMakeTime2());
/*      */       }
/*      */ 
/*  304 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  305 */         pstmt.setNull(35, 12);
/*      */       else {
/*  307 */         pstmt.setString(35, getEdorNo());
/*      */       }
/*  309 */       pstmt.executeUpdate();
/*  310 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  313 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  314 */       CError tError = new CError();
/*  315 */       tError.moduleName = "MInvTopicBDB";
/*  316 */       tError.functionName = "update()";
/*  317 */       tError.errorMessage = ex.toString();
/*  318 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  321 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  324 */       if (!this.mflag)
/*      */         try {
/*  326 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  330 */       return false;
/*      */     }
/*      */ 
/*  333 */     if (!this.mflag)
/*      */       try {
/*  335 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  339 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  344 */     PreparedStatement pstmt = null;
/*      */ 
/*  346 */     if (!this.mflag) {
/*  347 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  352 */       pstmt = this.con.prepareStatement("INSERT INTO MInvTopicB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  353 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  354 */         pstmt.setNull(1, 12);
/*      */       else {
/*  356 */         pstmt.setString(1, getTopicID());
/*      */       }
/*  358 */       if ((getTopic() == null) || (getTopic().equals("null")))
/*  359 */         pstmt.setNull(2, 12);
/*      */       else {
/*  361 */         pstmt.setString(2, getTopic());
/*      */       }
/*  363 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  364 */         pstmt.setNull(3, 12);
/*      */       else {
/*  366 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  368 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  369 */         pstmt.setNull(4, 12);
/*      */       else {
/*  371 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  373 */       if ((getDepiction() == null) || (getDepiction().equals("null")))
/*  374 */         pstmt.setNull(5, 12);
/*      */       else {
/*  376 */         pstmt.setString(5, getDepiction());
/*      */       }
/*  378 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  379 */         pstmt.setNull(6, 12);
/*      */       else {
/*  381 */         pstmt.setString(6, getAuthor());
/*      */       }
/*  383 */       pstmt.setInt(7, getPopulation());
/*  384 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  385 */         pstmt.setNull(8, 91);
/*      */       else {
/*  387 */         pstmt.setDate(8, Date.valueOf(getStartDate()));
/*      */       }
/*  389 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  390 */         pstmt.setNull(9, 91);
/*      */       else {
/*  392 */         pstmt.setDate(9, Date.valueOf(getEndDate()));
/*      */       }
/*  394 */       if ((getInvType() == null) || (getInvType().equals("null")))
/*  395 */         pstmt.setNull(10, 12);
/*      */       else {
/*  397 */         pstmt.setString(10, getInvType());
/*      */       }
/*  399 */       if ((getState() == null) || (getState().equals("null")))
/*  400 */         pstmt.setNull(11, 12);
/*      */       else {
/*  402 */         pstmt.setString(11, getState());
/*      */       }
/*  404 */       if ((getInvState() == null) || (getInvState().equals("null")))
/*  405 */         pstmt.setNull(12, 12);
/*      */       else {
/*  407 */         pstmt.setString(12, getInvState());
/*      */       }
/*  409 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  410 */         pstmt.setNull(13, 12);
/*      */       else {
/*  412 */         pstmt.setString(13, getCheckState());
/*      */       }
/*  414 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  415 */         pstmt.setNull(14, 12);
/*      */       else {
/*  417 */         pstmt.setString(14, getCheckOperator());
/*      */       }
/*  419 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  420 */         pstmt.setNull(15, 12);
/*      */       else {
/*  422 */         pstmt.setString(15, getCheckReason());
/*      */       }
/*  424 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  425 */         pstmt.setNull(16, 91);
/*      */       else {
/*  427 */         pstmt.setDate(16, Date.valueOf(getCheckDate()));
/*      */       }
/*  429 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  430 */         pstmt.setNull(17, 12);
/*      */       else {
/*  432 */         pstmt.setString(17, getCheckTime());
/*      */       }
/*  434 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  435 */         pstmt.setNull(18, 12);
/*      */       else {
/*  437 */         pstmt.setString(18, getVF01());
/*      */       }
/*  439 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  440 */         pstmt.setNull(19, 12);
/*      */       else {
/*  442 */         pstmt.setString(19, getNF01());
/*      */       }
/*  444 */       pstmt.setInt(20, getIF01());
/*  445 */       pstmt.setDouble(21, getDF02());
/*  446 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  447 */         pstmt.setNull(22, 91);
/*      */       else {
/*  449 */         pstmt.setDate(22, Date.valueOf(getDate01()));
/*      */       }
/*  451 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  452 */         pstmt.setNull(23, 12);
/*      */       else {
/*  454 */         pstmt.setString(23, getModifyOperator());
/*      */       }
/*  456 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  457 */         pstmt.setNull(24, 12);
/*      */       else {
/*  459 */         pstmt.setString(24, getOperator());
/*      */       }
/*  461 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  462 */         pstmt.setNull(25, 91);
/*      */       else {
/*  464 */         pstmt.setDate(25, Date.valueOf(getMakeDate()));
/*      */       }
/*  466 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  467 */         pstmt.setNull(26, 12);
/*      */       else {
/*  469 */         pstmt.setString(26, getMakeTime());
/*      */       }
/*  471 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  472 */         pstmt.setNull(27, 91);
/*      */       else {
/*  474 */         pstmt.setDate(27, Date.valueOf(getModifyDate()));
/*      */       }
/*  476 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  477 */         pstmt.setNull(28, 12);
/*      */       else {
/*  479 */         pstmt.setString(28, getModifyTime());
/*      */       }
/*  481 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  482 */         pstmt.setNull(29, 12);
/*      */       else {
/*  484 */         pstmt.setString(29, getEdorNo());
/*      */       }
/*  486 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  487 */         pstmt.setNull(30, 12);
/*      */       else {
/*  489 */         pstmt.setString(30, getEdorType());
/*      */       }
/*  491 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  492 */         pstmt.setNull(31, 12);
/*      */       else {
/*  494 */         pstmt.setString(31, getEdorCase());
/*      */       }
/*  496 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  497 */         pstmt.setNull(32, 12);
/*      */       else {
/*  499 */         pstmt.setString(32, getOperator2());
/*      */       }
/*  501 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  502 */         pstmt.setNull(33, 91);
/*      */       else {
/*  504 */         pstmt.setDate(33, Date.valueOf(getMakeDate2()));
/*      */       }
/*  506 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  507 */         pstmt.setNull(34, 12);
/*      */       else {
/*  509 */         pstmt.setString(34, getMakeTime2());
/*      */       }
/*      */ 
/*  512 */       pstmt.executeUpdate();
/*  513 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  516 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  517 */       CError tError = new CError();
/*  518 */       tError.moduleName = "MInvTopicBDB";
/*  519 */       tError.functionName = "insert()";
/*  520 */       tError.errorMessage = ex.toString();
/*  521 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  524 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  527 */       if (!this.mflag)
/*      */         try {
/*  529 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  533 */       return false;
/*      */     }
/*      */ 
/*  536 */     if (!this.mflag)
/*      */       try {
/*  538 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  542 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  547 */     PreparedStatement pstmt = null;
/*  548 */     ResultSet rs = null;
/*      */ 
/*  550 */     if (!this.mflag) {
/*  551 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  556 */       pstmt = this.con.prepareStatement("SELECT * FROM MInvTopicB WHERE  EdorNo = ?", 
/*  557 */         1003, 1007);
/*  558 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  559 */         pstmt.setNull(1, 12);
/*      */       else {
/*  561 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  563 */       rs = pstmt.executeQuery();
/*  564 */       int i = 0;
/*  565 */       if (rs.next())
/*      */       {
/*  567 */         i++;
/*  568 */         if (!setSchema(rs, i))
/*      */         {
/*  571 */           CError tError = new CError();
/*  572 */           tError.moduleName = "MInvTopicBDB";
/*  573 */           tError.functionName = "getInfo";
/*  574 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  575 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  577 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  580 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  584 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  588 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  592 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  595 */       if (i == 0)
/*      */       {
/*  597 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  601 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  605 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  611 */       CError tError = new CError();
/*  612 */       tError.moduleName = "MInvTopicBDB";
/*  613 */       tError.functionName = "getInfo";
/*  614 */       tError.errorMessage = e.toString();
/*  615 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  617 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  620 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  624 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  628 */       return false;
/*      */     }
/*      */ 
/*  631 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  635 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  640 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvTopicBSet query()
/*      */   {
/*  645 */     Statement stmt = null;
/*  646 */     ResultSet rs = null;
/*  647 */     MInvTopicBSet aMInvTopicBSet = new MInvTopicBSet();
/*      */ 
/*  649 */     if (!this.mflag) {
/*  650 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  655 */       stmt = this.con.createStatement(1003, 1007);
/*  656 */       SQLString sqlObj = new SQLString("MInvTopicB");
/*  657 */       MInvTopicBSchema aSchema = getSchema();
/*  658 */       sqlObj.setSQL(5, aSchema);
/*  659 */       String sql = sqlObj.getSQL();
/*      */ 
/*  661 */       rs = stmt.executeQuery(sql);
/*  662 */       int i = 0;
/*  663 */       while (rs.next())
/*      */       {
/*  665 */         i++;
/*  666 */         MInvTopicBSchema s1 = new MInvTopicBSchema();
/*  667 */         s1.setSchema(rs, i);
/*  668 */         aMInvTopicBSet.add(s1);
/*      */       }try {
/*  670 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  676 */       CError tError = new CError();
/*  677 */       tError.moduleName = "MInvTopicBDB";
/*  678 */       tError.functionName = "query";
/*  679 */       tError.errorMessage = e.toString();
/*  680 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  682 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  685 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  689 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  695 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  699 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  704 */     return aMInvTopicBSet;
/*      */   }
/*      */ 
/*      */   public MInvTopicBSet executeQuery(String sql)
/*      */   {
/*  709 */     Statement stmt = null;
/*  710 */     ResultSet rs = null;
/*  711 */     MInvTopicBSet aMInvTopicBSet = new MInvTopicBSet();
/*      */ 
/*  713 */     if (!this.mflag) {
/*  714 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  719 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  721 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  722 */       int i = 0;
/*  723 */       while (rs.next())
/*      */       {
/*  725 */         i++;
/*  726 */         MInvTopicBSchema s1 = new MInvTopicBSchema();
/*  727 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  730 */           CError tError = new CError();
/*  731 */           tError.moduleName = "MInvTopicBDB";
/*  732 */           tError.functionName = "executeQuery";
/*  733 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  734 */           this.mErrors.addOneError(tError);
/*      */         }
/*  736 */         aMInvTopicBSet.add(s1);
/*      */       }try {
/*  738 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  744 */       CError tError = new CError();
/*  745 */       tError.moduleName = "MInvTopicBDB";
/*  746 */       tError.functionName = "executeQuery";
/*  747 */       tError.errorMessage = e.toString();
/*  748 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  750 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  753 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  757 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  763 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  767 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  772 */     return aMInvTopicBSet;
/*      */   }
/*      */ 
/*      */   public MInvTopicBSet query(int nStart, int nCount)
/*      */   {
/*  777 */     Statement stmt = null;
/*  778 */     ResultSet rs = null;
/*  779 */     MInvTopicBSet aMInvTopicBSet = new MInvTopicBSet();
/*      */ 
/*  781 */     if (!this.mflag) {
/*  782 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  787 */       stmt = this.con.createStatement(1003, 1007);
/*  788 */       SQLString sqlObj = new SQLString("MInvTopicB");
/*  789 */       MInvTopicBSchema aSchema = getSchema();
/*  790 */       sqlObj.setSQL(5, aSchema);
/*  791 */       String sql = sqlObj.getSQL();
/*      */ 
/*  793 */       rs = stmt.executeQuery(sql);
/*  794 */       int i = 0;
/*  795 */       while (rs.next())
/*      */       {
/*  797 */         i++;
/*      */ 
/*  799 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  803 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  807 */         MInvTopicBSchema s1 = new MInvTopicBSchema();
/*  808 */         s1.setSchema(rs, i);
/*  809 */         aMInvTopicBSet.add(s1);
/*      */       }try {
/*  811 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  817 */       CError tError = new CError();
/*  818 */       tError.moduleName = "MInvTopicBDB";
/*  819 */       tError.functionName = "query";
/*  820 */       tError.errorMessage = e.toString();
/*  821 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  823 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  826 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  830 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  836 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  840 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  845 */     return aMInvTopicBSet;
/*      */   }
/*      */ 
/*      */   public MInvTopicBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  850 */     Statement stmt = null;
/*  851 */     ResultSet rs = null;
/*  852 */     MInvTopicBSet aMInvTopicBSet = new MInvTopicBSet();
/*      */ 
/*  854 */     if (!this.mflag) {
/*  855 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  860 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  862 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  863 */       int i = 0;
/*  864 */       while (rs.next())
/*      */       {
/*  866 */         i++;
/*      */ 
/*  868 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  872 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  876 */         MInvTopicBSchema s1 = new MInvTopicBSchema();
/*  877 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  880 */           CError tError = new CError();
/*  881 */           tError.moduleName = "MInvTopicBDB";
/*  882 */           tError.functionName = "executeQuery";
/*  883 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  884 */           this.mErrors.addOneError(tError);
/*      */         }
/*  886 */         aMInvTopicBSet.add(s1);
/*      */       }try {
/*  888 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  894 */       CError tError = new CError();
/*  895 */       tError.moduleName = "MInvTopicBDB";
/*  896 */       tError.functionName = "executeQuery";
/*  897 */       tError.errorMessage = e.toString();
/*  898 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  900 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  903 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  907 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  913 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  917 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  922 */     return aMInvTopicBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  927 */     Statement stmt = null;
/*      */ 
/*  929 */     if (!this.mflag) {
/*  930 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  935 */       stmt = this.con.createStatement(1003, 1007);
/*  936 */       SQLString sqlObj = new SQLString("MInvTopicB");
/*  937 */       MInvTopicBSchema aSchema = getSchema();
/*  938 */       sqlObj.setSQL(2, aSchema);
/*  939 */       String sql = "update MInvTopicB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  941 */       int operCount = stmt.executeUpdate(sql);
/*  942 */       if (operCount == 0)
/*      */       {
/*  945 */         CError tError = new CError();
/*  946 */         tError.moduleName = "MInvTopicBDB";
/*  947 */         tError.functionName = "update";
/*  948 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  949 */         this.mErrors.addOneError(tError);
/*      */ 
/*  951 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  955 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  959 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  965 */       CError tError = new CError();
/*  966 */       tError.moduleName = "MInvTopicBDB";
/*  967 */       tError.functionName = "update";
/*  968 */       tError.errorMessage = e.toString();
/*  969 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  971 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  973 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  977 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  981 */       return false;
/*      */     }
/*      */ 
/*  984 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  988 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  993 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  999 */     if (this.mResultSet != null)
/*      */     {
/* 1002 */       CError tError = new CError();
/* 1003 */       tError.moduleName = "MInvTopicBDB";
/* 1004 */       tError.functionName = "prepareData";
/* 1005 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 1006 */       this.mErrors.addOneError(tError);
/* 1007 */       return false;
/*      */     }
/*      */ 
/* 1010 */     if (!this.mflag)
/*      */     {
/* 1012 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1016 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1017 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1022 */       CError tError = new CError();
/* 1023 */       tError.moduleName = "MInvTopicBDB";
/* 1024 */       tError.functionName = "prepareData";
/* 1025 */       tError.errorMessage = e.toString();
/* 1026 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1029 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1035 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1039 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1043 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1048 */       return false;
/*      */     }
/*      */ 
/* 1051 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1055 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1060 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1066 */     boolean flag = true;
/* 1067 */     if (this.mResultSet == null)
/*      */     {
/* 1069 */       CError tError = new CError();
/* 1070 */       tError.moduleName = "MInvTopicBDB";
/* 1071 */       tError.functionName = "hasMoreData";
/* 1072 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1073 */       this.mErrors.addOneError(tError);
/* 1074 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1078 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1082 */       CError tError = new CError();
/* 1083 */       tError.moduleName = "MInvTopicBDB";
/* 1084 */       tError.functionName = "hasMoreData";
/* 1085 */       tError.errorMessage = ex.toString();
/* 1086 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1089 */         this.mResultSet.close();
/* 1090 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1096 */         this.mStatement.close();
/* 1097 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1101 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1105 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1110 */       return false;
/*      */     }
/* 1112 */     return flag;
/*      */   }
/*      */ 
/*      */   public MInvTopicBSet getData()
/*      */   {
/* 1117 */     int tCount = 0;
/* 1118 */     MInvTopicBSet tMInvTopicBSet = new MInvTopicBSet();
/* 1119 */     MInvTopicBSchema tMInvTopicBSchema = null;
/* 1120 */     if (this.mResultSet == null)
/*      */     {
/* 1122 */       CError tError = new CError();
/* 1123 */       tError.moduleName = "MInvTopicBDB";
/* 1124 */       tError.functionName = "getData";
/* 1125 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1126 */       this.mErrors.addOneError(tError);
/* 1127 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1131 */       tCount = 1;
/* 1132 */       tMInvTopicBSchema = new MInvTopicBSchema();
/* 1133 */       tMInvTopicBSchema.setSchema(this.mResultSet, 1);
/* 1134 */       tMInvTopicBSet.add(tMInvTopicBSchema);
/*      */ 
/* 1136 */       while (tCount++ < 5000)
/*      */       {
/* 1138 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1140 */         tMInvTopicBSchema = new MInvTopicBSchema();
/* 1141 */         tMInvTopicBSchema.setSchema(this.mResultSet, 1);
/* 1142 */         tMInvTopicBSet.add(tMInvTopicBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1148 */       CError tError = new CError();
/* 1149 */       tError.moduleName = "MInvTopicBDB";
/* 1150 */       tError.functionName = "getData";
/* 1151 */       tError.errorMessage = ex.toString();
/* 1152 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1155 */         this.mResultSet.close();
/* 1156 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1162 */         this.mStatement.close();
/* 1163 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1167 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1171 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1176 */       return null;
/*      */     }
/* 1178 */     return tMInvTopicBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1183 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1186 */       if (this.mResultSet == null)
/*      */       {
/* 1188 */         CError tError = new CError();
/* 1189 */         tError.moduleName = "MInvTopicBDB";
/* 1190 */         tError.functionName = "closeData";
/* 1191 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1192 */         this.mErrors.addOneError(tError);
/* 1193 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1197 */         this.mResultSet.close();
/* 1198 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1203 */       CError tError = new CError();
/* 1204 */       tError.moduleName = "MInvTopicBDB";
/* 1205 */       tError.functionName = "closeData";
/* 1206 */       tError.errorMessage = ex2.toString();
/* 1207 */       this.mErrors.addOneError(tError);
/* 1208 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1212 */       if (this.mStatement == null)
/*      */       {
/* 1214 */         CError tError = new CError();
/* 1215 */         tError.moduleName = "MInvTopicBDB";
/* 1216 */         tError.functionName = "closeData";
/* 1217 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1218 */         this.mErrors.addOneError(tError);
/* 1219 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1223 */         this.mStatement.close();
/* 1224 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1229 */       CError tError = new CError();
/* 1230 */       tError.moduleName = "MInvTopicBDB";
/* 1231 */       tError.functionName = "closeData";
/* 1232 */       tError.errorMessage = ex3.toString();
/* 1233 */       this.mErrors.addOneError(tError);
/* 1234 */       flag = false;
/*      */     }
/* 1236 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MInvTopicBDB
 * JD-Core Version:    0.6.0
 */