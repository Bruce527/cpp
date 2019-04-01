/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MLibraryBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MLibraryBSet;
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
/*      */ public class MLibraryBDB extends MLibraryBSchema
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
/*      */   public MLibraryBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MLibraryB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MLibraryBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MLibraryB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MLibraryBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MLibraryBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MLibraryBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MLibraryBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MLibraryB WHERE  EdorNo = ?");
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
/*  107 */       tError.moduleName = "MLibraryBDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MLibraryB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , FileID = ? , Name = ? , DisplayName = ? , FileDescription = ? , ManageCom = ? , BranchType = ? , NodeID = ? , FileType = ? , FilePath = ? , DocumentType = ? , StartDisplayDate = ? , EndDisplayDate = ? , MinDisplayGrade = ? , StartDisplayTime = ? , EndDisplayTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , State = ? WHERE  EdorNo = ?");
/*  145 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  150 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getEdorType());
/*      */       }
/*  155 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getEdorCase());
/*      */       }
/*  160 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getOperator2());
/*      */       }
/*  165 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  166 */         pstmt.setNull(5, 91);
/*      */       else {
/*  168 */         pstmt.setDate(5, Date.valueOf(getMakeDate2()));
/*      */       }
/*  170 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getMakeTime2());
/*      */       }
/*  175 */       if ((getFileID() == null) || (getFileID().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getFileID());
/*      */       }
/*  180 */       if ((getName() == null) || (getName().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getName());
/*      */       }
/*  185 */       if ((getDisplayName() == null) || (getDisplayName().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getDisplayName());
/*      */       }
/*  190 */       if ((getFileDescription() == null) || (getFileDescription().equals("null")))
/*  191 */         pstmt.setNull(10, 12);
/*      */       else {
/*  193 */         pstmt.setString(10, getFileDescription());
/*      */       }
/*  195 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  196 */         pstmt.setNull(11, 12);
/*      */       else {
/*  198 */         pstmt.setString(11, getManageCom());
/*      */       }
/*  200 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  201 */         pstmt.setNull(12, 12);
/*      */       else {
/*  203 */         pstmt.setString(12, getBranchType());
/*      */       }
/*  205 */       if ((getNodeID() == null) || (getNodeID().equals("null")))
/*  206 */         pstmt.setNull(13, 12);
/*      */       else {
/*  208 */         pstmt.setString(13, getNodeID());
/*      */       }
/*  210 */       if ((getFileType() == null) || (getFileType().equals("null")))
/*  211 */         pstmt.setNull(14, 12);
/*      */       else {
/*  213 */         pstmt.setString(14, getFileType());
/*      */       }
/*  215 */       if ((getFilePath() == null) || (getFilePath().equals("null")))
/*  216 */         pstmt.setNull(15, 12);
/*      */       else {
/*  218 */         pstmt.setString(15, getFilePath());
/*      */       }
/*  220 */       if ((getDocumentType() == null) || (getDocumentType().equals("null")))
/*  221 */         pstmt.setNull(16, 12);
/*      */       else {
/*  223 */         pstmt.setString(16, getDocumentType());
/*      */       }
/*  225 */       if ((getStartDisplayDate() == null) || (getStartDisplayDate().equals("null")))
/*  226 */         pstmt.setNull(17, 91);
/*      */       else {
/*  228 */         pstmt.setDate(17, Date.valueOf(getStartDisplayDate()));
/*      */       }
/*  230 */       if ((getEndDisplayDate() == null) || (getEndDisplayDate().equals("null")))
/*  231 */         pstmt.setNull(18, 91);
/*      */       else {
/*  233 */         pstmt.setDate(18, Date.valueOf(getEndDisplayDate()));
/*      */       }
/*  235 */       if ((getMinDisplayGrade() == null) || (getMinDisplayGrade().equals("null")))
/*  236 */         pstmt.setNull(19, 12);
/*      */       else {
/*  238 */         pstmt.setString(19, getMinDisplayGrade());
/*      */       }
/*  240 */       if ((getStartDisplayTime() == null) || (getStartDisplayTime().equals("null")))
/*  241 */         pstmt.setNull(20, 12);
/*      */       else {
/*  243 */         pstmt.setString(20, getStartDisplayTime());
/*      */       }
/*  245 */       if ((getEndDisplayTime() == null) || (getEndDisplayTime().equals("null")))
/*  246 */         pstmt.setNull(21, 12);
/*      */       else {
/*  248 */         pstmt.setString(21, getEndDisplayTime());
/*      */       }
/*  250 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  251 */         pstmt.setNull(22, 12);
/*      */       else {
/*  253 */         pstmt.setString(22, getCheckState());
/*      */       }
/*  255 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  256 */         pstmt.setNull(23, 12);
/*      */       else {
/*  258 */         pstmt.setString(23, getCheckOperator());
/*      */       }
/*  260 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  261 */         pstmt.setNull(24, 12);
/*      */       else {
/*  263 */         pstmt.setString(24, getCheckReason());
/*      */       }
/*  265 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  266 */         pstmt.setNull(25, 91);
/*      */       else {
/*  268 */         pstmt.setDate(25, Date.valueOf(getCheckDate()));
/*      */       }
/*  270 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  271 */         pstmt.setNull(26, 12);
/*      */       else {
/*  273 */         pstmt.setString(26, getCheckTime());
/*      */       }
/*  275 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  276 */         pstmt.setNull(27, 12);
/*      */       else {
/*  278 */         pstmt.setString(27, getVF01());
/*      */       }
/*  280 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  281 */         pstmt.setNull(28, 12);
/*      */       else {
/*  283 */         pstmt.setString(28, getNF01());
/*      */       }
/*  285 */       pstmt.setInt(29, getIF01());
/*  286 */       pstmt.setDouble(30, getDF02());
/*  287 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  288 */         pstmt.setNull(31, 91);
/*      */       else {
/*  290 */         pstmt.setDate(31, Date.valueOf(getDate01()));
/*      */       }
/*  292 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  293 */         pstmt.setNull(32, 12);
/*      */       else {
/*  295 */         pstmt.setString(32, getModifyOperator());
/*      */       }
/*  297 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  298 */         pstmt.setNull(33, 12);
/*      */       else {
/*  300 */         pstmt.setString(33, getOperator());
/*      */       }
/*  302 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  303 */         pstmt.setNull(34, 91);
/*      */       else {
/*  305 */         pstmt.setDate(34, Date.valueOf(getMakeDate()));
/*      */       }
/*  307 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  308 */         pstmt.setNull(35, 12);
/*      */       else {
/*  310 */         pstmt.setString(35, getMakeTime());
/*      */       }
/*  312 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  313 */         pstmt.setNull(36, 91);
/*      */       else {
/*  315 */         pstmt.setDate(36, Date.valueOf(getModifyDate()));
/*      */       }
/*  317 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  318 */         pstmt.setNull(37, 12);
/*      */       else {
/*  320 */         pstmt.setString(37, getModifyTime());
/*      */       }
/*  322 */       if ((getState() == null) || (getState().equals("null")))
/*  323 */         pstmt.setNull(38, 12);
/*      */       else {
/*  325 */         pstmt.setString(38, getState());
/*      */       }
/*      */ 
/*  328 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  329 */         pstmt.setNull(39, 12);
/*      */       else {
/*  331 */         pstmt.setString(39, getEdorNo());
/*      */       }
/*  333 */       pstmt.executeUpdate();
/*  334 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  337 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  338 */       CError tError = new CError();
/*  339 */       tError.moduleName = "MLibraryBDB";
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
/*  376 */       pstmt = this.con.prepareStatement("INSERT INTO MLibraryB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  377 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  378 */         pstmt.setNull(1, 12);
/*      */       else {
/*  380 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  382 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  383 */         pstmt.setNull(2, 12);
/*      */       else {
/*  385 */         pstmt.setString(2, getEdorType());
/*      */       }
/*  387 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  388 */         pstmt.setNull(3, 12);
/*      */       else {
/*  390 */         pstmt.setString(3, getEdorCase());
/*      */       }
/*  392 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  393 */         pstmt.setNull(4, 12);
/*      */       else {
/*  395 */         pstmt.setString(4, getOperator2());
/*      */       }
/*  397 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  398 */         pstmt.setNull(5, 91);
/*      */       else {
/*  400 */         pstmt.setDate(5, Date.valueOf(getMakeDate2()));
/*      */       }
/*  402 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  403 */         pstmt.setNull(6, 12);
/*      */       else {
/*  405 */         pstmt.setString(6, getMakeTime2());
/*      */       }
/*  407 */       if ((getFileID() == null) || (getFileID().equals("null")))
/*  408 */         pstmt.setNull(7, 12);
/*      */       else {
/*  410 */         pstmt.setString(7, getFileID());
/*      */       }
/*  412 */       if ((getName() == null) || (getName().equals("null")))
/*  413 */         pstmt.setNull(8, 12);
/*      */       else {
/*  415 */         pstmt.setString(8, getName());
/*      */       }
/*  417 */       if ((getDisplayName() == null) || (getDisplayName().equals("null")))
/*  418 */         pstmt.setNull(9, 12);
/*      */       else {
/*  420 */         pstmt.setString(9, getDisplayName());
/*      */       }
/*  422 */       if ((getFileDescription() == null) || (getFileDescription().equals("null")))
/*  423 */         pstmt.setNull(10, 12);
/*      */       else {
/*  425 */         pstmt.setString(10, getFileDescription());
/*      */       }
/*  427 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  428 */         pstmt.setNull(11, 12);
/*      */       else {
/*  430 */         pstmt.setString(11, getManageCom());
/*      */       }
/*  432 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  433 */         pstmt.setNull(12, 12);
/*      */       else {
/*  435 */         pstmt.setString(12, getBranchType());
/*      */       }
/*  437 */       if ((getNodeID() == null) || (getNodeID().equals("null")))
/*  438 */         pstmt.setNull(13, 12);
/*      */       else {
/*  440 */         pstmt.setString(13, getNodeID());
/*      */       }
/*  442 */       if ((getFileType() == null) || (getFileType().equals("null")))
/*  443 */         pstmt.setNull(14, 12);
/*      */       else {
/*  445 */         pstmt.setString(14, getFileType());
/*      */       }
/*  447 */       if ((getFilePath() == null) || (getFilePath().equals("null")))
/*  448 */         pstmt.setNull(15, 12);
/*      */       else {
/*  450 */         pstmt.setString(15, getFilePath());
/*      */       }
/*  452 */       if ((getDocumentType() == null) || (getDocumentType().equals("null")))
/*  453 */         pstmt.setNull(16, 12);
/*      */       else {
/*  455 */         pstmt.setString(16, getDocumentType());
/*      */       }
/*  457 */       if ((getStartDisplayDate() == null) || (getStartDisplayDate().equals("null")))
/*  458 */         pstmt.setNull(17, 91);
/*      */       else {
/*  460 */         pstmt.setDate(17, Date.valueOf(getStartDisplayDate()));
/*      */       }
/*  462 */       if ((getEndDisplayDate() == null) || (getEndDisplayDate().equals("null")))
/*  463 */         pstmt.setNull(18, 91);
/*      */       else {
/*  465 */         pstmt.setDate(18, Date.valueOf(getEndDisplayDate()));
/*      */       }
/*  467 */       if ((getMinDisplayGrade() == null) || (getMinDisplayGrade().equals("null")))
/*  468 */         pstmt.setNull(19, 12);
/*      */       else {
/*  470 */         pstmt.setString(19, getMinDisplayGrade());
/*      */       }
/*  472 */       if ((getStartDisplayTime() == null) || (getStartDisplayTime().equals("null")))
/*  473 */         pstmt.setNull(20, 12);
/*      */       else {
/*  475 */         pstmt.setString(20, getStartDisplayTime());
/*      */       }
/*  477 */       if ((getEndDisplayTime() == null) || (getEndDisplayTime().equals("null")))
/*  478 */         pstmt.setNull(21, 12);
/*      */       else {
/*  480 */         pstmt.setString(21, getEndDisplayTime());
/*      */       }
/*  482 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  483 */         pstmt.setNull(22, 12);
/*      */       else {
/*  485 */         pstmt.setString(22, getCheckState());
/*      */       }
/*  487 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  488 */         pstmt.setNull(23, 12);
/*      */       else {
/*  490 */         pstmt.setString(23, getCheckOperator());
/*      */       }
/*  492 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  493 */         pstmt.setNull(24, 12);
/*      */       else {
/*  495 */         pstmt.setString(24, getCheckReason());
/*      */       }
/*  497 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  498 */         pstmt.setNull(25, 91);
/*      */       else {
/*  500 */         pstmt.setDate(25, Date.valueOf(getCheckDate()));
/*      */       }
/*  502 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  503 */         pstmt.setNull(26, 12);
/*      */       else {
/*  505 */         pstmt.setString(26, getCheckTime());
/*      */       }
/*  507 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  508 */         pstmt.setNull(27, 12);
/*      */       else {
/*  510 */         pstmt.setString(27, getVF01());
/*      */       }
/*  512 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  513 */         pstmt.setNull(28, 12);
/*      */       else {
/*  515 */         pstmt.setString(28, getNF01());
/*      */       }
/*  517 */       pstmt.setInt(29, getIF01());
/*  518 */       pstmt.setDouble(30, getDF02());
/*  519 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  520 */         pstmt.setNull(31, 91);
/*      */       else {
/*  522 */         pstmt.setDate(31, Date.valueOf(getDate01()));
/*      */       }
/*  524 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  525 */         pstmt.setNull(32, 12);
/*      */       else {
/*  527 */         pstmt.setString(32, getModifyOperator());
/*      */       }
/*  529 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  530 */         pstmt.setNull(33, 12);
/*      */       else {
/*  532 */         pstmt.setString(33, getOperator());
/*      */       }
/*  534 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  535 */         pstmt.setNull(34, 91);
/*      */       else {
/*  537 */         pstmt.setDate(34, Date.valueOf(getMakeDate()));
/*      */       }
/*  539 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  540 */         pstmt.setNull(35, 12);
/*      */       else {
/*  542 */         pstmt.setString(35, getMakeTime());
/*      */       }
/*  544 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  545 */         pstmt.setNull(36, 91);
/*      */       else {
/*  547 */         pstmt.setDate(36, Date.valueOf(getModifyDate()));
/*      */       }
/*  549 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  550 */         pstmt.setNull(37, 12);
/*      */       else {
/*  552 */         pstmt.setString(37, getModifyTime());
/*      */       }
/*  554 */       if ((getState() == null) || (getState().equals("null")))
/*  555 */         pstmt.setNull(38, 12);
/*      */       else {
/*  557 */         pstmt.setString(38, getState());
/*      */       }
/*      */ 
/*  560 */       pstmt.executeUpdate();
/*  561 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  564 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  565 */       CError tError = new CError();
/*  566 */       tError.moduleName = "MLibraryBDB";
/*  567 */       tError.functionName = "insert()";
/*  568 */       tError.errorMessage = ex.toString();
/*  569 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  572 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  575 */       if (!this.mflag)
/*      */         try {
/*  577 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  581 */       return false;
/*      */     }
/*      */ 
/*  584 */     if (!this.mflag)
/*      */       try {
/*  586 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  590 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  595 */     PreparedStatement pstmt = null;
/*  596 */     ResultSet rs = null;
/*      */ 
/*  598 */     if (!this.mflag) {
/*  599 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  604 */       pstmt = this.con.prepareStatement("SELECT * FROM MLibraryB WHERE  EdorNo = ?", 
/*  605 */         1003, 1007);
/*  606 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  607 */         pstmt.setNull(1, 12);
/*      */       else {
/*  609 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  611 */       rs = pstmt.executeQuery();
/*  612 */       int i = 0;
/*  613 */       if (rs.next())
/*      */       {
/*  615 */         i++;
/*  616 */         if (!setSchema(rs, i))
/*      */         {
/*  619 */           CError tError = new CError();
/*  620 */           tError.moduleName = "MLibraryBDB";
/*  621 */           tError.functionName = "getInfo";
/*  622 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  623 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  625 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  628 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  632 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  636 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  640 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  643 */       if (i == 0)
/*      */       {
/*  645 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  649 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  653 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  659 */       CError tError = new CError();
/*  660 */       tError.moduleName = "MLibraryBDB";
/*  661 */       tError.functionName = "getInfo";
/*  662 */       tError.errorMessage = e.toString();
/*  663 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  665 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  668 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  672 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  676 */       return false;
/*      */     }
/*      */ 
/*  679 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  683 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  688 */     return true;
/*      */   }
/*      */ 
/*      */   public MLibraryBSet query()
/*      */   {
/*  693 */     Statement stmt = null;
/*  694 */     ResultSet rs = null;
/*  695 */     MLibraryBSet aMLibraryBSet = new MLibraryBSet();
/*      */ 
/*  697 */     if (!this.mflag) {
/*  698 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  703 */       stmt = this.con.createStatement(1003, 1007);
/*  704 */       SQLString sqlObj = new SQLString("MLibraryB");
/*  705 */       MLibraryBSchema aSchema = getSchema();
/*  706 */       sqlObj.setSQL(5, aSchema);
/*  707 */       String sql = sqlObj.getSQL();
/*      */ 
/*  709 */       rs = stmt.executeQuery(sql);
/*  710 */       int i = 0;
/*  711 */       while (rs.next())
/*      */       {
/*  713 */         i++;
/*  714 */         MLibraryBSchema s1 = new MLibraryBSchema();
/*  715 */         s1.setSchema(rs, i);
/*  716 */         aMLibraryBSet.add(s1);
/*      */       }try {
/*  718 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  724 */       CError tError = new CError();
/*  725 */       tError.moduleName = "MLibraryBDB";
/*  726 */       tError.functionName = "query";
/*  727 */       tError.errorMessage = e.toString();
/*  728 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  730 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  733 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  737 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  743 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  747 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  752 */     return aMLibraryBSet;
/*      */   }
/*      */ 
/*      */   public MLibraryBSet executeQuery(String sql)
/*      */   {
/*  757 */     Statement stmt = null;
/*  758 */     ResultSet rs = null;
/*  759 */     MLibraryBSet aMLibraryBSet = new MLibraryBSet();
/*      */ 
/*  761 */     if (!this.mflag) {
/*  762 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  767 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  769 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  770 */       int i = 0;
/*  771 */       while (rs.next())
/*      */       {
/*  773 */         i++;
/*  774 */         MLibraryBSchema s1 = new MLibraryBSchema();
/*  775 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  778 */           CError tError = new CError();
/*  779 */           tError.moduleName = "MLibraryBDB";
/*  780 */           tError.functionName = "executeQuery";
/*  781 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  782 */           this.mErrors.addOneError(tError);
/*      */         }
/*  784 */         aMLibraryBSet.add(s1);
/*      */       }try {
/*  786 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  792 */       CError tError = new CError();
/*  793 */       tError.moduleName = "MLibraryBDB";
/*  794 */       tError.functionName = "executeQuery";
/*  795 */       tError.errorMessage = e.toString();
/*  796 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  798 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  801 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  805 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  811 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  815 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  820 */     return aMLibraryBSet;
/*      */   }
/*      */ 
/*      */   public MLibraryBSet query(int nStart, int nCount)
/*      */   {
/*  825 */     Statement stmt = null;
/*  826 */     ResultSet rs = null;
/*  827 */     MLibraryBSet aMLibraryBSet = new MLibraryBSet();
/*      */ 
/*  829 */     if (!this.mflag) {
/*  830 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  835 */       stmt = this.con.createStatement(1003, 1007);
/*  836 */       SQLString sqlObj = new SQLString("MLibraryB");
/*  837 */       MLibraryBSchema aSchema = getSchema();
/*  838 */       sqlObj.setSQL(5, aSchema);
/*  839 */       String sql = sqlObj.getSQL();
/*      */ 
/*  841 */       rs = stmt.executeQuery(sql);
/*  842 */       int i = 0;
/*  843 */       while (rs.next())
/*      */       {
/*  845 */         i++;
/*      */ 
/*  847 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  851 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  855 */         MLibraryBSchema s1 = new MLibraryBSchema();
/*  856 */         s1.setSchema(rs, i);
/*  857 */         aMLibraryBSet.add(s1);
/*      */       }try {
/*  859 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  865 */       CError tError = new CError();
/*  866 */       tError.moduleName = "MLibraryBDB";
/*  867 */       tError.functionName = "query";
/*  868 */       tError.errorMessage = e.toString();
/*  869 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  871 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  874 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  878 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  884 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  888 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  893 */     return aMLibraryBSet;
/*      */   }
/*      */ 
/*      */   public MLibraryBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  898 */     Statement stmt = null;
/*  899 */     ResultSet rs = null;
/*  900 */     MLibraryBSet aMLibraryBSet = new MLibraryBSet();
/*      */ 
/*  902 */     if (!this.mflag) {
/*  903 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  908 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  910 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  911 */       int i = 0;
/*  912 */       while (rs.next())
/*      */       {
/*  914 */         i++;
/*      */ 
/*  916 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  920 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  924 */         MLibraryBSchema s1 = new MLibraryBSchema();
/*  925 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  928 */           CError tError = new CError();
/*  929 */           tError.moduleName = "MLibraryBDB";
/*  930 */           tError.functionName = "executeQuery";
/*  931 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  932 */           this.mErrors.addOneError(tError);
/*      */         }
/*  934 */         aMLibraryBSet.add(s1);
/*      */       }try {
/*  936 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  942 */       CError tError = new CError();
/*  943 */       tError.moduleName = "MLibraryBDB";
/*  944 */       tError.functionName = "executeQuery";
/*  945 */       tError.errorMessage = e.toString();
/*  946 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  948 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  951 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  955 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  961 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  965 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  970 */     return aMLibraryBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  975 */     Statement stmt = null;
/*      */ 
/*  977 */     if (!this.mflag) {
/*  978 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  983 */       stmt = this.con.createStatement(1003, 1007);
/*  984 */       SQLString sqlObj = new SQLString("MLibraryB");
/*  985 */       MLibraryBSchema aSchema = getSchema();
/*  986 */       sqlObj.setSQL(2, aSchema);
/*  987 */       String sql = "update MLibraryB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  989 */       int operCount = stmt.executeUpdate(sql);
/*  990 */       if (operCount == 0)
/*      */       {
/*  993 */         CError tError = new CError();
/*  994 */         tError.moduleName = "MLibraryBDB";
/*  995 */         tError.functionName = "update";
/*  996 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  997 */         this.mErrors.addOneError(tError);
/*      */ 
/*  999 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1003 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1007 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1013 */       CError tError = new CError();
/* 1014 */       tError.moduleName = "MLibraryBDB";
/* 1015 */       tError.functionName = "update";
/* 1016 */       tError.errorMessage = e.toString();
/* 1017 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1019 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1021 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1025 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1029 */       return false;
/*      */     }
/*      */ 
/* 1032 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1036 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1041 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1047 */     if (this.mResultSet != null)
/*      */     {
/* 1050 */       CError tError = new CError();
/* 1051 */       tError.moduleName = "MLibraryBDB";
/* 1052 */       tError.functionName = "prepareData";
/* 1053 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 1054 */       this.mErrors.addOneError(tError);
/* 1055 */       return false;
/*      */     }
/*      */ 
/* 1058 */     if (!this.mflag)
/*      */     {
/* 1060 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1064 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1065 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1070 */       CError tError = new CError();
/* 1071 */       tError.moduleName = "MLibraryBDB";
/* 1072 */       tError.functionName = "prepareData";
/* 1073 */       tError.errorMessage = e.toString();
/* 1074 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1077 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1083 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1087 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1091 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1096 */       return false;
/*      */     }
/*      */ 
/* 1099 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1103 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1108 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1114 */     boolean flag = true;
/* 1115 */     if (this.mResultSet == null)
/*      */     {
/* 1117 */       CError tError = new CError();
/* 1118 */       tError.moduleName = "MLibraryBDB";
/* 1119 */       tError.functionName = "hasMoreData";
/* 1120 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1121 */       this.mErrors.addOneError(tError);
/* 1122 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1126 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1130 */       CError tError = new CError();
/* 1131 */       tError.moduleName = "MLibraryBDB";
/* 1132 */       tError.functionName = "hasMoreData";
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
/* 1158 */       return false;
/*      */     }
/* 1160 */     return flag;
/*      */   }
/*      */ 
/*      */   public MLibraryBSet getData()
/*      */   {
/* 1165 */     int tCount = 0;
/* 1166 */     MLibraryBSet tMLibraryBSet = new MLibraryBSet();
/* 1167 */     MLibraryBSchema tMLibraryBSchema = null;
/* 1168 */     if (this.mResultSet == null)
/*      */     {
/* 1170 */       CError tError = new CError();
/* 1171 */       tError.moduleName = "MLibraryBDB";
/* 1172 */       tError.functionName = "getData";
/* 1173 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1174 */       this.mErrors.addOneError(tError);
/* 1175 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1179 */       tCount = 1;
/* 1180 */       tMLibraryBSchema = new MLibraryBSchema();
/* 1181 */       tMLibraryBSchema.setSchema(this.mResultSet, 1);
/* 1182 */       tMLibraryBSet.add(tMLibraryBSchema);
/*      */ 
/* 1184 */       while (tCount++ < 5000)
/*      */       {
/* 1186 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1188 */         tMLibraryBSchema = new MLibraryBSchema();
/* 1189 */         tMLibraryBSchema.setSchema(this.mResultSet, 1);
/* 1190 */         tMLibraryBSet.add(tMLibraryBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1196 */       CError tError = new CError();
/* 1197 */       tError.moduleName = "MLibraryBDB";
/* 1198 */       tError.functionName = "getData";
/* 1199 */       tError.errorMessage = ex.toString();
/* 1200 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1203 */         this.mResultSet.close();
/* 1204 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1210 */         this.mStatement.close();
/* 1211 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1215 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1219 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1224 */       return null;
/*      */     }
/* 1226 */     return tMLibraryBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1231 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1234 */       if (this.mResultSet == null)
/*      */       {
/* 1236 */         CError tError = new CError();
/* 1237 */         tError.moduleName = "MLibraryBDB";
/* 1238 */         tError.functionName = "closeData";
/* 1239 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1240 */         this.mErrors.addOneError(tError);
/* 1241 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1245 */         this.mResultSet.close();
/* 1246 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1251 */       CError tError = new CError();
/* 1252 */       tError.moduleName = "MLibraryBDB";
/* 1253 */       tError.functionName = "closeData";
/* 1254 */       tError.errorMessage = ex2.toString();
/* 1255 */       this.mErrors.addOneError(tError);
/* 1256 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1260 */       if (this.mStatement == null)
/*      */       {
/* 1262 */         CError tError = new CError();
/* 1263 */         tError.moduleName = "MLibraryBDB";
/* 1264 */         tError.functionName = "closeData";
/* 1265 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1266 */         this.mErrors.addOneError(tError);
/* 1267 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1271 */         this.mStatement.close();
/* 1272 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1277 */       CError tError = new CError();
/* 1278 */       tError.moduleName = "MLibraryBDB";
/* 1279 */       tError.functionName = "closeData";
/* 1280 */       tError.errorMessage = ex3.toString();
/* 1281 */       this.mErrors.addOneError(tError);
/* 1282 */       flag = false;
/*      */     }
/* 1284 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MLibraryBDB
 * JD-Core Version:    0.6.0
 */