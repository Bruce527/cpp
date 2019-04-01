/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MLibraryStructBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MLibraryStructBSet;
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
/*      */ public class MLibraryStructBDB extends MLibraryStructBSchema
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
/*      */   public MLibraryStructBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MLibraryStructB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MLibraryStructBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MLibraryStructB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MLibraryStructBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MLibraryStructBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MLibraryStructBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MLibraryStructBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MLibraryStructB WHERE  EdorNo = ?");
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
/*  107 */       tError.moduleName = "MLibraryStructBDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MLibraryStructB SET  NodeID = ? , Name = ? , ParentID = ? , Discription = ? , ManageCom = ? , BranchType = ? , Position = ? , Operation = ? , DirFlag = ? , FileFlag = ? , ChildDirNum = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/*  145 */       if ((getNodeID() == null) || (getNodeID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getNodeID());
/*      */       }
/*  150 */       if ((getName() == null) || (getName().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getName());
/*      */       }
/*  155 */       if ((getParentID() == null) || (getParentID().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getParentID());
/*      */       }
/*  160 */       if ((getDiscription() == null) || (getDiscription().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getDiscription());
/*      */       }
/*  165 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  170 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getBranchType());
/*      */       }
/*  175 */       pstmt.setInt(7, getPosition());
/*  176 */       if ((getOperation() == null) || (getOperation().equals("null")))
/*  177 */         pstmt.setNull(8, 12);
/*      */       else {
/*  179 */         pstmt.setString(8, getOperation());
/*      */       }
/*  181 */       if ((getDirFlag() == null) || (getDirFlag().equals("null")))
/*  182 */         pstmt.setNull(9, 12);
/*      */       else {
/*  184 */         pstmt.setString(9, getDirFlag());
/*      */       }
/*  186 */       if ((getFileFlag() == null) || (getFileFlag().equals("null")))
/*  187 */         pstmt.setNull(10, 12);
/*      */       else {
/*  189 */         pstmt.setString(10, getFileFlag());
/*      */       }
/*  191 */       pstmt.setInt(11, getChildDirNum());
/*  192 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  193 */         pstmt.setNull(12, 12);
/*      */       else {
/*  195 */         pstmt.setString(12, getCheckState());
/*      */       }
/*  197 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  198 */         pstmt.setNull(13, 12);
/*      */       else {
/*  200 */         pstmt.setString(13, getCheckOperator());
/*      */       }
/*  202 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  203 */         pstmt.setNull(14, 12);
/*      */       else {
/*  205 */         pstmt.setString(14, getCheckReason());
/*      */       }
/*  207 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  208 */         pstmt.setNull(15, 91);
/*      */       else {
/*  210 */         pstmt.setDate(15, Date.valueOf(getCheckDate()));
/*      */       }
/*  212 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  213 */         pstmt.setNull(16, 12);
/*      */       else {
/*  215 */         pstmt.setString(16, getCheckTime());
/*      */       }
/*  217 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  218 */         pstmt.setNull(17, 12);
/*      */       else {
/*  220 */         pstmt.setString(17, getVF01());
/*      */       }
/*  222 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  223 */         pstmt.setNull(18, 12);
/*      */       else {
/*  225 */         pstmt.setString(18, getNF01());
/*      */       }
/*  227 */       pstmt.setInt(19, getIF01());
/*  228 */       pstmt.setDouble(20, getDF02());
/*  229 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  230 */         pstmt.setNull(21, 91);
/*      */       else {
/*  232 */         pstmt.setDate(21, Date.valueOf(getDate01()));
/*      */       }
/*  234 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  235 */         pstmt.setNull(22, 12);
/*      */       else {
/*  237 */         pstmt.setString(22, getModifyOperator());
/*      */       }
/*  239 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  240 */         pstmt.setNull(23, 12);
/*      */       else {
/*  242 */         pstmt.setString(23, getOperator());
/*      */       }
/*  244 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  245 */         pstmt.setNull(24, 91);
/*      */       else {
/*  247 */         pstmt.setDate(24, Date.valueOf(getMakeDate()));
/*      */       }
/*  249 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  250 */         pstmt.setNull(25, 12);
/*      */       else {
/*  252 */         pstmt.setString(25, getMakeTime());
/*      */       }
/*  254 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  255 */         pstmt.setNull(26, 91);
/*      */       else {
/*  257 */         pstmt.setDate(26, Date.valueOf(getModifyDate()));
/*      */       }
/*  259 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  260 */         pstmt.setNull(27, 12);
/*      */       else {
/*  262 */         pstmt.setString(27, getModifyTime());
/*      */       }
/*  264 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  265 */         pstmt.setNull(28, 12);
/*      */       else {
/*  267 */         pstmt.setString(28, getEdorNo());
/*      */       }
/*  269 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  270 */         pstmt.setNull(29, 12);
/*      */       else {
/*  272 */         pstmt.setString(29, getEdorType());
/*      */       }
/*  274 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  275 */         pstmt.setNull(30, 12);
/*      */       else {
/*  277 */         pstmt.setString(30, getEdorCase());
/*      */       }
/*  279 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  280 */         pstmt.setNull(31, 12);
/*      */       else {
/*  282 */         pstmt.setString(31, getOperator2());
/*      */       }
/*  284 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  285 */         pstmt.setNull(32, 91);
/*      */       else {
/*  287 */         pstmt.setDate(32, Date.valueOf(getMakeDate2()));
/*      */       }
/*  289 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  290 */         pstmt.setNull(33, 12);
/*      */       else {
/*  292 */         pstmt.setString(33, getMakeTime2());
/*      */       }
/*      */ 
/*  295 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  296 */         pstmt.setNull(34, 12);
/*      */       else {
/*  298 */         pstmt.setString(34, getEdorNo());
/*      */       }
/*  300 */       pstmt.executeUpdate();
/*  301 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  304 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  305 */       CError tError = new CError();
/*  306 */       tError.moduleName = "MLibraryStructBDB";
/*  307 */       tError.functionName = "update()";
/*  308 */       tError.errorMessage = ex.toString();
/*  309 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  312 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  315 */       if (!this.mflag)
/*      */         try {
/*  317 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  321 */       return false;
/*      */     }
/*      */ 
/*  324 */     if (!this.mflag)
/*      */       try {
/*  326 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  330 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  335 */     PreparedStatement pstmt = null;
/*      */ 
/*  337 */     if (!this.mflag) {
/*  338 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  343 */       pstmt = this.con.prepareStatement("INSERT INTO MLibraryStructB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  344 */       if ((getNodeID() == null) || (getNodeID().equals("null")))
/*  345 */         pstmt.setNull(1, 12);
/*      */       else {
/*  347 */         pstmt.setString(1, getNodeID());
/*      */       }
/*  349 */       if ((getName() == null) || (getName().equals("null")))
/*  350 */         pstmt.setNull(2, 12);
/*      */       else {
/*  352 */         pstmt.setString(2, getName());
/*      */       }
/*  354 */       if ((getParentID() == null) || (getParentID().equals("null")))
/*  355 */         pstmt.setNull(3, 12);
/*      */       else {
/*  357 */         pstmt.setString(3, getParentID());
/*      */       }
/*  359 */       if ((getDiscription() == null) || (getDiscription().equals("null")))
/*  360 */         pstmt.setNull(4, 12);
/*      */       else {
/*  362 */         pstmt.setString(4, getDiscription());
/*      */       }
/*  364 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  365 */         pstmt.setNull(5, 12);
/*      */       else {
/*  367 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  369 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  370 */         pstmt.setNull(6, 12);
/*      */       else {
/*  372 */         pstmt.setString(6, getBranchType());
/*      */       }
/*  374 */       pstmt.setInt(7, getPosition());
/*  375 */       if ((getOperation() == null) || (getOperation().equals("null")))
/*  376 */         pstmt.setNull(8, 12);
/*      */       else {
/*  378 */         pstmt.setString(8, getOperation());
/*      */       }
/*  380 */       if ((getDirFlag() == null) || (getDirFlag().equals("null")))
/*  381 */         pstmt.setNull(9, 12);
/*      */       else {
/*  383 */         pstmt.setString(9, getDirFlag());
/*      */       }
/*  385 */       if ((getFileFlag() == null) || (getFileFlag().equals("null")))
/*  386 */         pstmt.setNull(10, 12);
/*      */       else {
/*  388 */         pstmt.setString(10, getFileFlag());
/*      */       }
/*  390 */       pstmt.setInt(11, getChildDirNum());
/*  391 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  392 */         pstmt.setNull(12, 12);
/*      */       else {
/*  394 */         pstmt.setString(12, getCheckState());
/*      */       }
/*  396 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  397 */         pstmt.setNull(13, 12);
/*      */       else {
/*  399 */         pstmt.setString(13, getCheckOperator());
/*      */       }
/*  401 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  402 */         pstmt.setNull(14, 12);
/*      */       else {
/*  404 */         pstmt.setString(14, getCheckReason());
/*      */       }
/*  406 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  407 */         pstmt.setNull(15, 91);
/*      */       else {
/*  409 */         pstmt.setDate(15, Date.valueOf(getCheckDate()));
/*      */       }
/*  411 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  412 */         pstmt.setNull(16, 12);
/*      */       else {
/*  414 */         pstmt.setString(16, getCheckTime());
/*      */       }
/*  416 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  417 */         pstmt.setNull(17, 12);
/*      */       else {
/*  419 */         pstmt.setString(17, getVF01());
/*      */       }
/*  421 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  422 */         pstmt.setNull(18, 12);
/*      */       else {
/*  424 */         pstmt.setString(18, getNF01());
/*      */       }
/*  426 */       pstmt.setInt(19, getIF01());
/*  427 */       pstmt.setDouble(20, getDF02());
/*  428 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  429 */         pstmt.setNull(21, 91);
/*      */       else {
/*  431 */         pstmt.setDate(21, Date.valueOf(getDate01()));
/*      */       }
/*  433 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  434 */         pstmt.setNull(22, 12);
/*      */       else {
/*  436 */         pstmt.setString(22, getModifyOperator());
/*      */       }
/*  438 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  439 */         pstmt.setNull(23, 12);
/*      */       else {
/*  441 */         pstmt.setString(23, getOperator());
/*      */       }
/*  443 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  444 */         pstmt.setNull(24, 91);
/*      */       else {
/*  446 */         pstmt.setDate(24, Date.valueOf(getMakeDate()));
/*      */       }
/*  448 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  449 */         pstmt.setNull(25, 12);
/*      */       else {
/*  451 */         pstmt.setString(25, getMakeTime());
/*      */       }
/*  453 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  454 */         pstmt.setNull(26, 91);
/*      */       else {
/*  456 */         pstmt.setDate(26, Date.valueOf(getModifyDate()));
/*      */       }
/*  458 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  459 */         pstmt.setNull(27, 12);
/*      */       else {
/*  461 */         pstmt.setString(27, getModifyTime());
/*      */       }
/*  463 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  464 */         pstmt.setNull(28, 12);
/*      */       else {
/*  466 */         pstmt.setString(28, getEdorNo());
/*      */       }
/*  468 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  469 */         pstmt.setNull(29, 12);
/*      */       else {
/*  471 */         pstmt.setString(29, getEdorType());
/*      */       }
/*  473 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  474 */         pstmt.setNull(30, 12);
/*      */       else {
/*  476 */         pstmt.setString(30, getEdorCase());
/*      */       }
/*  478 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  479 */         pstmt.setNull(31, 12);
/*      */       else {
/*  481 */         pstmt.setString(31, getOperator2());
/*      */       }
/*  483 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  484 */         pstmt.setNull(32, 91);
/*      */       else {
/*  486 */         pstmt.setDate(32, Date.valueOf(getMakeDate2()));
/*      */       }
/*  488 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  489 */         pstmt.setNull(33, 12);
/*      */       else {
/*  491 */         pstmt.setString(33, getMakeTime2());
/*      */       }
/*      */ 
/*  494 */       pstmt.executeUpdate();
/*  495 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  498 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  499 */       CError tError = new CError();
/*  500 */       tError.moduleName = "MLibraryStructBDB";
/*  501 */       tError.functionName = "insert()";
/*  502 */       tError.errorMessage = ex.toString();
/*  503 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  506 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  509 */       if (!this.mflag)
/*      */         try {
/*  511 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  515 */       return false;
/*      */     }
/*      */ 
/*  518 */     if (!this.mflag)
/*      */       try {
/*  520 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  524 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  529 */     PreparedStatement pstmt = null;
/*  530 */     ResultSet rs = null;
/*      */ 
/*  532 */     if (!this.mflag) {
/*  533 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  538 */       pstmt = this.con.prepareStatement("SELECT * FROM MLibraryStructB WHERE  EdorNo = ?", 
/*  539 */         1003, 1007);
/*  540 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  541 */         pstmt.setNull(1, 12);
/*      */       else {
/*  543 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  545 */       rs = pstmt.executeQuery();
/*  546 */       int i = 0;
/*  547 */       if (rs.next())
/*      */       {
/*  549 */         i++;
/*  550 */         if (!setSchema(rs, i))
/*      */         {
/*  553 */           CError tError = new CError();
/*  554 */           tError.moduleName = "MLibraryStructBDB";
/*  555 */           tError.functionName = "getInfo";
/*  556 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  557 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  559 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  562 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  566 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  570 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  574 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  577 */       if (i == 0)
/*      */       {
/*  579 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  583 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  587 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  593 */       CError tError = new CError();
/*  594 */       tError.moduleName = "MLibraryStructBDB";
/*  595 */       tError.functionName = "getInfo";
/*  596 */       tError.errorMessage = e.toString();
/*  597 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  599 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  602 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  606 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  610 */       return false;
/*      */     }
/*      */ 
/*  613 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  617 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  622 */     return true;
/*      */   }
/*      */ 
/*      */   public MLibraryStructBSet query()
/*      */   {
/*  627 */     Statement stmt = null;
/*  628 */     ResultSet rs = null;
/*  629 */     MLibraryStructBSet aMLibraryStructBSet = new MLibraryStructBSet();
/*      */ 
/*  631 */     if (!this.mflag) {
/*  632 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  637 */       stmt = this.con.createStatement(1003, 1007);
/*  638 */       SQLString sqlObj = new SQLString("MLibraryStructB");
/*  639 */       MLibraryStructBSchema aSchema = getSchema();
/*  640 */       sqlObj.setSQL(5, aSchema);
/*  641 */       String sql = sqlObj.getSQL();
/*      */ 
/*  643 */       rs = stmt.executeQuery(sql);
/*  644 */       int i = 0;
/*  645 */       while (rs.next())
/*      */       {
/*  647 */         i++;
/*  648 */         MLibraryStructBSchema s1 = new MLibraryStructBSchema();
/*  649 */         s1.setSchema(rs, i);
/*  650 */         aMLibraryStructBSet.add(s1);
/*      */       }try {
/*  652 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  658 */       CError tError = new CError();
/*  659 */       tError.moduleName = "MLibraryStructBDB";
/*  660 */       tError.functionName = "query";
/*  661 */       tError.errorMessage = e.toString();
/*  662 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  664 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  667 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  671 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  677 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  681 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  686 */     return aMLibraryStructBSet;
/*      */   }
/*      */ 
/*      */   public MLibraryStructBSet executeQuery(String sql)
/*      */   {
/*  691 */     Statement stmt = null;
/*  692 */     ResultSet rs = null;
/*  693 */     MLibraryStructBSet aMLibraryStructBSet = new MLibraryStructBSet();
/*      */ 
/*  695 */     if (!this.mflag) {
/*  696 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  701 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  703 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  704 */       int i = 0;
/*  705 */       while (rs.next())
/*      */       {
/*  707 */         i++;
/*  708 */         MLibraryStructBSchema s1 = new MLibraryStructBSchema();
/*  709 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  712 */           CError tError = new CError();
/*  713 */           tError.moduleName = "MLibraryStructBDB";
/*  714 */           tError.functionName = "executeQuery";
/*  715 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  716 */           this.mErrors.addOneError(tError);
/*      */         }
/*  718 */         aMLibraryStructBSet.add(s1);
/*      */       }try {
/*  720 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  726 */       CError tError = new CError();
/*  727 */       tError.moduleName = "MLibraryStructBDB";
/*  728 */       tError.functionName = "executeQuery";
/*  729 */       tError.errorMessage = e.toString();
/*  730 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  732 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  735 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  739 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  745 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  749 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  754 */     return aMLibraryStructBSet;
/*      */   }
/*      */ 
/*      */   public MLibraryStructBSet query(int nStart, int nCount)
/*      */   {
/*  759 */     Statement stmt = null;
/*  760 */     ResultSet rs = null;
/*  761 */     MLibraryStructBSet aMLibraryStructBSet = new MLibraryStructBSet();
/*      */ 
/*  763 */     if (!this.mflag) {
/*  764 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  769 */       stmt = this.con.createStatement(1003, 1007);
/*  770 */       SQLString sqlObj = new SQLString("MLibraryStructB");
/*  771 */       MLibraryStructBSchema aSchema = getSchema();
/*  772 */       sqlObj.setSQL(5, aSchema);
/*  773 */       String sql = sqlObj.getSQL();
/*      */ 
/*  775 */       rs = stmt.executeQuery(sql);
/*  776 */       int i = 0;
/*  777 */       while (rs.next())
/*      */       {
/*  779 */         i++;
/*      */ 
/*  781 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  785 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  789 */         MLibraryStructBSchema s1 = new MLibraryStructBSchema();
/*  790 */         s1.setSchema(rs, i);
/*  791 */         aMLibraryStructBSet.add(s1);
/*      */       }try {
/*  793 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  799 */       CError tError = new CError();
/*  800 */       tError.moduleName = "MLibraryStructBDB";
/*  801 */       tError.functionName = "query";
/*  802 */       tError.errorMessage = e.toString();
/*  803 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  805 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  808 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  812 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  818 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  822 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  827 */     return aMLibraryStructBSet;
/*      */   }
/*      */ 
/*      */   public MLibraryStructBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  832 */     Statement stmt = null;
/*  833 */     ResultSet rs = null;
/*  834 */     MLibraryStructBSet aMLibraryStructBSet = new MLibraryStructBSet();
/*      */ 
/*  836 */     if (!this.mflag) {
/*  837 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  842 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  844 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  845 */       int i = 0;
/*  846 */       while (rs.next())
/*      */       {
/*  848 */         i++;
/*      */ 
/*  850 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  854 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  858 */         MLibraryStructBSchema s1 = new MLibraryStructBSchema();
/*  859 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  862 */           CError tError = new CError();
/*  863 */           tError.moduleName = "MLibraryStructBDB";
/*  864 */           tError.functionName = "executeQuery";
/*  865 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  866 */           this.mErrors.addOneError(tError);
/*      */         }
/*  868 */         aMLibraryStructBSet.add(s1);
/*      */       }try {
/*  870 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  876 */       CError tError = new CError();
/*  877 */       tError.moduleName = "MLibraryStructBDB";
/*  878 */       tError.functionName = "executeQuery";
/*  879 */       tError.errorMessage = e.toString();
/*  880 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  882 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  885 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  889 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  895 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  899 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  904 */     return aMLibraryStructBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  909 */     Statement stmt = null;
/*      */ 
/*  911 */     if (!this.mflag) {
/*  912 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  917 */       stmt = this.con.createStatement(1003, 1007);
/*  918 */       SQLString sqlObj = new SQLString("MLibraryStructB");
/*  919 */       MLibraryStructBSchema aSchema = getSchema();
/*  920 */       sqlObj.setSQL(2, aSchema);
/*  921 */       String sql = "update MLibraryStructB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  923 */       int operCount = stmt.executeUpdate(sql);
/*  924 */       if (operCount == 0)
/*      */       {
/*  927 */         CError tError = new CError();
/*  928 */         tError.moduleName = "MLibraryStructBDB";
/*  929 */         tError.functionName = "update";
/*  930 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  931 */         this.mErrors.addOneError(tError);
/*      */ 
/*  933 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  937 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  941 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  947 */       CError tError = new CError();
/*  948 */       tError.moduleName = "MLibraryStructBDB";
/*  949 */       tError.functionName = "update";
/*  950 */       tError.errorMessage = e.toString();
/*  951 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  953 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  955 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  959 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  963 */       return false;
/*      */     }
/*      */ 
/*  966 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  970 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  975 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  981 */     if (this.mResultSet != null)
/*      */     {
/*  984 */       CError tError = new CError();
/*  985 */       tError.moduleName = "MLibraryStructBDB";
/*  986 */       tError.functionName = "prepareData";
/*  987 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  988 */       this.mErrors.addOneError(tError);
/*  989 */       return false;
/*      */     }
/*      */ 
/*  992 */     if (!this.mflag)
/*      */     {
/*  994 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  998 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  999 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1004 */       CError tError = new CError();
/* 1005 */       tError.moduleName = "MLibraryStructBDB";
/* 1006 */       tError.functionName = "prepareData";
/* 1007 */       tError.errorMessage = e.toString();
/* 1008 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1011 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1017 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1021 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1025 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1030 */       return false;
/*      */     }
/*      */ 
/* 1033 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1037 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1042 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1048 */     boolean flag = true;
/* 1049 */     if (this.mResultSet == null)
/*      */     {
/* 1051 */       CError tError = new CError();
/* 1052 */       tError.moduleName = "MLibraryStructBDB";
/* 1053 */       tError.functionName = "hasMoreData";
/* 1054 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1055 */       this.mErrors.addOneError(tError);
/* 1056 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1060 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1064 */       CError tError = new CError();
/* 1065 */       tError.moduleName = "MLibraryStructBDB";
/* 1066 */       tError.functionName = "hasMoreData";
/* 1067 */       tError.errorMessage = ex.toString();
/* 1068 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1071 */         this.mResultSet.close();
/* 1072 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1078 */         this.mStatement.close();
/* 1079 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1083 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1087 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1092 */       return false;
/*      */     }
/* 1094 */     return flag;
/*      */   }
/*      */ 
/*      */   public MLibraryStructBSet getData()
/*      */   {
/* 1099 */     int tCount = 0;
/* 1100 */     MLibraryStructBSet tMLibraryStructBSet = new MLibraryStructBSet();
/* 1101 */     MLibraryStructBSchema tMLibraryStructBSchema = null;
/* 1102 */     if (this.mResultSet == null)
/*      */     {
/* 1104 */       CError tError = new CError();
/* 1105 */       tError.moduleName = "MLibraryStructBDB";
/* 1106 */       tError.functionName = "getData";
/* 1107 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1108 */       this.mErrors.addOneError(tError);
/* 1109 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1113 */       tCount = 1;
/* 1114 */       tMLibraryStructBSchema = new MLibraryStructBSchema();
/* 1115 */       tMLibraryStructBSchema.setSchema(this.mResultSet, 1);
/* 1116 */       tMLibraryStructBSet.add(tMLibraryStructBSchema);
/*      */ 
/* 1118 */       while (tCount++ < 5000)
/*      */       {
/* 1120 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1122 */         tMLibraryStructBSchema = new MLibraryStructBSchema();
/* 1123 */         tMLibraryStructBSchema.setSchema(this.mResultSet, 1);
/* 1124 */         tMLibraryStructBSet.add(tMLibraryStructBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1130 */       CError tError = new CError();
/* 1131 */       tError.moduleName = "MLibraryStructBDB";
/* 1132 */       tError.functionName = "getData";
/* 1133 */       tError.errorMessage = ex.toString();
/* 1134 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1137 */         this.mResultSet.close();
/* 1138 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1144 */         this.mStatement.close();
/* 1145 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1149 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1153 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1158 */       return null;
/*      */     }
/* 1160 */     return tMLibraryStructBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1165 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1168 */       if (this.mResultSet == null)
/*      */       {
/* 1170 */         CError tError = new CError();
/* 1171 */         tError.moduleName = "MLibraryStructBDB";
/* 1172 */         tError.functionName = "closeData";
/* 1173 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1174 */         this.mErrors.addOneError(tError);
/* 1175 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1179 */         this.mResultSet.close();
/* 1180 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1185 */       CError tError = new CError();
/* 1186 */       tError.moduleName = "MLibraryStructBDB";
/* 1187 */       tError.functionName = "closeData";
/* 1188 */       tError.errorMessage = ex2.toString();
/* 1189 */       this.mErrors.addOneError(tError);
/* 1190 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1194 */       if (this.mStatement == null)
/*      */       {
/* 1196 */         CError tError = new CError();
/* 1197 */         tError.moduleName = "MLibraryStructBDB";
/* 1198 */         tError.functionName = "closeData";
/* 1199 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1200 */         this.mErrors.addOneError(tError);
/* 1201 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1205 */         this.mStatement.close();
/* 1206 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1211 */       CError tError = new CError();
/* 1212 */       tError.moduleName = "MLibraryStructBDB";
/* 1213 */       tError.functionName = "closeData";
/* 1214 */       tError.errorMessage = ex3.toString();
/* 1215 */       this.mErrors.addOneError(tError);
/* 1216 */       flag = false;
/*      */     }
/* 1218 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MLibraryStructBDB
 * JD-Core Version:    0.6.0
 */