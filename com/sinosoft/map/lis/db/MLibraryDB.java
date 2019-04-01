/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MLibrarySchema;
/*      */ import com.sinosoft.map.lis.vschema.MLibrarySet;
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
/*      */ public class MLibraryDB extends MLibrarySchema
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
/*      */   public MLibraryDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MLibrary");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MLibraryDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MLibrary");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MLibrarySchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MLibraryDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MLibrarySchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MLibraryDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MLibrary WHERE  FileID = ?");
/*   96 */       if ((getFileID() == null) || (getFileID().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getFileID());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MLibraryDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MLibrary SET  FileID = ? , Name = ? , DisplayName = ? , FileDescription = ? , ManageCom = ? , BranchType = ? , NodeID = ? , FileType = ? , FilePath = ? , DocumentType = ? , StartDisplayDate = ? , EndDisplayDate = ? , MinDisplayGrade = ? , StartDisplayTime = ? , EndDisplayTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , State = ? WHERE  FileID = ?");
/*  145 */       if ((getFileID() == null) || (getFileID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getFileID());
/*      */       }
/*  150 */       if ((getName() == null) || (getName().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getName());
/*      */       }
/*  155 */       if ((getDisplayName() == null) || (getDisplayName().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getDisplayName());
/*      */       }
/*  160 */       if ((getFileDescription() == null) || (getFileDescription().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getFileDescription());
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
/*  175 */       if ((getNodeID() == null) || (getNodeID().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getNodeID());
/*      */       }
/*  180 */       if ((getFileType() == null) || (getFileType().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getFileType());
/*      */       }
/*  185 */       if ((getFilePath() == null) || (getFilePath().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getFilePath());
/*      */       }
/*  190 */       if ((getDocumentType() == null) || (getDocumentType().equals("null")))
/*  191 */         pstmt.setNull(10, 12);
/*      */       else {
/*  193 */         pstmt.setString(10, getDocumentType());
/*      */       }
/*  195 */       if ((getStartDisplayDate() == null) || (getStartDisplayDate().equals("null")))
/*  196 */         pstmt.setNull(11, 91);
/*      */       else {
/*  198 */         pstmt.setDate(11, Date.valueOf(getStartDisplayDate()));
/*      */       }
/*  200 */       if ((getEndDisplayDate() == null) || (getEndDisplayDate().equals("null")))
/*  201 */         pstmt.setNull(12, 91);
/*      */       else {
/*  203 */         pstmt.setDate(12, Date.valueOf(getEndDisplayDate()));
/*      */       }
/*  205 */       if ((getMinDisplayGrade() == null) || (getMinDisplayGrade().equals("null")))
/*  206 */         pstmt.setNull(13, 12);
/*      */       else {
/*  208 */         pstmt.setString(13, getMinDisplayGrade());
/*      */       }
/*  210 */       if ((getStartDisplayTime() == null) || (getStartDisplayTime().equals("null")))
/*  211 */         pstmt.setNull(14, 12);
/*      */       else {
/*  213 */         pstmt.setString(14, getStartDisplayTime());
/*      */       }
/*  215 */       if ((getEndDisplayTime() == null) || (getEndDisplayTime().equals("null")))
/*  216 */         pstmt.setNull(15, 12);
/*      */       else {
/*  218 */         pstmt.setString(15, getEndDisplayTime());
/*      */       }
/*  220 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  221 */         pstmt.setNull(16, 12);
/*      */       else {
/*  223 */         pstmt.setString(16, getCheckState());
/*      */       }
/*  225 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  226 */         pstmt.setNull(17, 12);
/*      */       else {
/*  228 */         pstmt.setString(17, getCheckOperator());
/*      */       }
/*  230 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  231 */         pstmt.setNull(18, 12);
/*      */       else {
/*  233 */         pstmt.setString(18, getCheckReason());
/*      */       }
/*  235 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  236 */         pstmt.setNull(19, 91);
/*      */       else {
/*  238 */         pstmt.setDate(19, Date.valueOf(getCheckDate()));
/*      */       }
/*  240 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  241 */         pstmt.setNull(20, 12);
/*      */       else {
/*  243 */         pstmt.setString(20, getCheckTime());
/*      */       }
/*  245 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  246 */         pstmt.setNull(21, 12);
/*      */       else {
/*  248 */         pstmt.setString(21, getVF01());
/*      */       }
/*  250 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  251 */         pstmt.setNull(22, 12);
/*      */       else {
/*  253 */         pstmt.setString(22, getNF01());
/*      */       }
/*  255 */       pstmt.setInt(23, getIF01());
/*  256 */       pstmt.setDouble(24, getDF02());
/*  257 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  258 */         pstmt.setNull(25, 91);
/*      */       else {
/*  260 */         pstmt.setDate(25, Date.valueOf(getDate01()));
/*      */       }
/*  262 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  263 */         pstmt.setNull(26, 12);
/*      */       else {
/*  265 */         pstmt.setString(26, getModifyOperator());
/*      */       }
/*  267 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  268 */         pstmt.setNull(27, 12);
/*      */       else {
/*  270 */         pstmt.setString(27, getOperator());
/*      */       }
/*  272 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  273 */         pstmt.setNull(28, 91);
/*      */       else {
/*  275 */         pstmt.setDate(28, Date.valueOf(getMakeDate()));
/*      */       }
/*  277 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  278 */         pstmt.setNull(29, 12);
/*      */       else {
/*  280 */         pstmt.setString(29, getMakeTime());
/*      */       }
/*  282 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  283 */         pstmt.setNull(30, 91);
/*      */       else {
/*  285 */         pstmt.setDate(30, Date.valueOf(getModifyDate()));
/*      */       }
/*  287 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  288 */         pstmt.setNull(31, 12);
/*      */       else {
/*  290 */         pstmt.setString(31, getModifyTime());
/*      */       }
/*  292 */       if ((getState() == null) || (getState().equals("null")))
/*  293 */         pstmt.setNull(32, 12);
/*      */       else {
/*  295 */         pstmt.setString(32, getState());
/*      */       }
/*      */ 
/*  298 */       if ((getFileID() == null) || (getFileID().equals("null")))
/*  299 */         pstmt.setNull(33, 12);
/*      */       else {
/*  301 */         pstmt.setString(33, getFileID());
/*      */       }
/*  303 */       pstmt.executeUpdate();
/*  304 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  307 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  308 */       CError tError = new CError();
/*  309 */       tError.moduleName = "MLibraryDB";
/*  310 */       tError.functionName = "update()";
/*  311 */       tError.errorMessage = ex.toString();
/*  312 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  315 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  318 */       if (!this.mflag)
/*      */         try {
/*  320 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  324 */       return false;
/*      */     }
/*      */ 
/*  327 */     if (!this.mflag)
/*      */       try {
/*  329 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  333 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  338 */     PreparedStatement pstmt = null;
/*      */ 
/*  340 */     if (!this.mflag) {
/*  341 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  346 */       pstmt = this.con.prepareStatement("INSERT INTO MLibrary VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  347 */       if ((getFileID() == null) || (getFileID().equals("null")))
/*  348 */         pstmt.setNull(1, 12);
/*      */       else {
/*  350 */         pstmt.setString(1, getFileID());
/*      */       }
/*  352 */       if ((getName() == null) || (getName().equals("null")))
/*  353 */         pstmt.setNull(2, 12);
/*      */       else {
/*  355 */         pstmt.setString(2, getName());
/*      */       }
/*  357 */       if ((getDisplayName() == null) || (getDisplayName().equals("null")))
/*  358 */         pstmt.setNull(3, 12);
/*      */       else {
/*  360 */         pstmt.setString(3, getDisplayName());
/*      */       }
/*  362 */       if ((getFileDescription() == null) || (getFileDescription().equals("null")))
/*  363 */         pstmt.setNull(4, 12);
/*      */       else {
/*  365 */         pstmt.setString(4, getFileDescription());
/*      */       }
/*  367 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  368 */         pstmt.setNull(5, 12);
/*      */       else {
/*  370 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  372 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  373 */         pstmt.setNull(6, 12);
/*      */       else {
/*  375 */         pstmt.setString(6, getBranchType());
/*      */       }
/*  377 */       if ((getNodeID() == null) || (getNodeID().equals("null")))
/*  378 */         pstmt.setNull(7, 12);
/*      */       else {
/*  380 */         pstmt.setString(7, getNodeID());
/*      */       }
/*  382 */       if ((getFileType() == null) || (getFileType().equals("null")))
/*  383 */         pstmt.setNull(8, 12);
/*      */       else {
/*  385 */         pstmt.setString(8, getFileType());
/*      */       }
/*  387 */       if ((getFilePath() == null) || (getFilePath().equals("null")))
/*  388 */         pstmt.setNull(9, 12);
/*      */       else {
/*  390 */         pstmt.setString(9, getFilePath());
/*      */       }
/*  392 */       if ((getDocumentType() == null) || (getDocumentType().equals("null")))
/*  393 */         pstmt.setNull(10, 12);
/*      */       else {
/*  395 */         pstmt.setString(10, getDocumentType());
/*      */       }
/*  397 */       if ((getStartDisplayDate() == null) || (getStartDisplayDate().equals("null")))
/*  398 */         pstmt.setNull(11, 91);
/*      */       else {
/*  400 */         pstmt.setDate(11, Date.valueOf(getStartDisplayDate()));
/*      */       }
/*  402 */       if ((getEndDisplayDate() == null) || (getEndDisplayDate().equals("null")))
/*  403 */         pstmt.setNull(12, 91);
/*      */       else {
/*  405 */         pstmt.setDate(12, Date.valueOf(getEndDisplayDate()));
/*      */       }
/*  407 */       if ((getMinDisplayGrade() == null) || (getMinDisplayGrade().equals("null")))
/*  408 */         pstmt.setNull(13, 12);
/*      */       else {
/*  410 */         pstmt.setString(13, getMinDisplayGrade());
/*      */       }
/*  412 */       if ((getStartDisplayTime() == null) || (getStartDisplayTime().equals("null")))
/*  413 */         pstmt.setNull(14, 12);
/*      */       else {
/*  415 */         pstmt.setString(14, getStartDisplayTime());
/*      */       }
/*  417 */       if ((getEndDisplayTime() == null) || (getEndDisplayTime().equals("null")))
/*  418 */         pstmt.setNull(15, 12);
/*      */       else {
/*  420 */         pstmt.setString(15, getEndDisplayTime());
/*      */       }
/*  422 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  423 */         pstmt.setNull(16, 12);
/*      */       else {
/*  425 */         pstmt.setString(16, getCheckState());
/*      */       }
/*  427 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  428 */         pstmt.setNull(17, 12);
/*      */       else {
/*  430 */         pstmt.setString(17, getCheckOperator());
/*      */       }
/*  432 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  433 */         pstmt.setNull(18, 12);
/*      */       else {
/*  435 */         pstmt.setString(18, getCheckReason());
/*      */       }
/*  437 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  438 */         pstmt.setNull(19, 91);
/*      */       else {
/*  440 */         pstmt.setDate(19, Date.valueOf(getCheckDate()));
/*      */       }
/*  442 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  443 */         pstmt.setNull(20, 12);
/*      */       else {
/*  445 */         pstmt.setString(20, getCheckTime());
/*      */       }
/*  447 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  448 */         pstmt.setNull(21, 12);
/*      */       else {
/*  450 */         pstmt.setString(21, getVF01());
/*      */       }
/*  452 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  453 */         pstmt.setNull(22, 12);
/*      */       else {
/*  455 */         pstmt.setString(22, getNF01());
/*      */       }
/*  457 */       pstmt.setInt(23, getIF01());
/*  458 */       pstmt.setDouble(24, getDF02());
/*  459 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  460 */         pstmt.setNull(25, 91);
/*      */       else {
/*  462 */         pstmt.setDate(25, Date.valueOf(getDate01()));
/*      */       }
/*  464 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  465 */         pstmt.setNull(26, 12);
/*      */       else {
/*  467 */         pstmt.setString(26, getModifyOperator());
/*      */       }
/*  469 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  470 */         pstmt.setNull(27, 12);
/*      */       else {
/*  472 */         pstmt.setString(27, getOperator());
/*      */       }
/*  474 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  475 */         pstmt.setNull(28, 91);
/*      */       else {
/*  477 */         pstmt.setDate(28, Date.valueOf(getMakeDate()));
/*      */       }
/*  479 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  480 */         pstmt.setNull(29, 12);
/*      */       else {
/*  482 */         pstmt.setString(29, getMakeTime());
/*      */       }
/*  484 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  485 */         pstmt.setNull(30, 91);
/*      */       else {
/*  487 */         pstmt.setDate(30, Date.valueOf(getModifyDate()));
/*      */       }
/*  489 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  490 */         pstmt.setNull(31, 12);
/*      */       else {
/*  492 */         pstmt.setString(31, getModifyTime());
/*      */       }
/*  494 */       if ((getState() == null) || (getState().equals("null")))
/*  495 */         pstmt.setNull(32, 12);
/*      */       else {
/*  497 */         pstmt.setString(32, getState());
/*      */       }
/*      */ 
/*  500 */       pstmt.executeUpdate();
/*  501 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  504 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  505 */       CError tError = new CError();
/*  506 */       tError.moduleName = "MLibraryDB";
/*  507 */       tError.functionName = "insert()";
/*  508 */       tError.errorMessage = ex.toString();
/*  509 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  512 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  515 */       if (!this.mflag)
/*      */         try {
/*  517 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  521 */       return false;
/*      */     }
/*      */ 
/*  524 */     if (!this.mflag)
/*      */       try {
/*  526 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  530 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  535 */     PreparedStatement pstmt = null;
/*  536 */     ResultSet rs = null;
/*      */ 
/*  538 */     if (!this.mflag) {
/*  539 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  544 */       pstmt = this.con.prepareStatement("SELECT * FROM MLibrary WHERE  FileID = ?", 
/*  545 */         1003, 1007);
/*  546 */       if ((getFileID() == null) || (getFileID().equals("null")))
/*  547 */         pstmt.setNull(1, 12);
/*      */       else {
/*  549 */         pstmt.setString(1, getFileID());
/*      */       }
/*  551 */       rs = pstmt.executeQuery();
/*  552 */       int i = 0;
/*  553 */       if (rs.next())
/*      */       {
/*  555 */         i++;
/*  556 */         if (!setSchema(rs, i))
/*      */         {
/*  559 */           CError tError = new CError();
/*  560 */           tError.moduleName = "MLibraryDB";
/*  561 */           tError.functionName = "getInfo";
/*  562 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  563 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  565 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  568 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  572 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  576 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  580 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  583 */       if (i == 0)
/*      */       {
/*  585 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  589 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  593 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  599 */       CError tError = new CError();
/*  600 */       tError.moduleName = "MLibraryDB";
/*  601 */       tError.functionName = "getInfo";
/*  602 */       tError.errorMessage = e.toString();
/*  603 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  605 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  608 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  612 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  616 */       return false;
/*      */     }
/*      */ 
/*  619 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  623 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  628 */     return true;
/*      */   }
/*      */ 
/*      */   public MLibrarySet query()
/*      */   {
/*  633 */     Statement stmt = null;
/*  634 */     ResultSet rs = null;
/*  635 */     MLibrarySet aMLibrarySet = new MLibrarySet();
/*      */ 
/*  637 */     if (!this.mflag) {
/*  638 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  643 */       stmt = this.con.createStatement(1003, 1007);
/*  644 */       SQLString sqlObj = new SQLString("MLibrary");
/*  645 */       MLibrarySchema aSchema = getSchema();
/*  646 */       sqlObj.setSQL(5, aSchema);
/*  647 */       String sql = sqlObj.getSQL();
/*      */ 
/*  649 */       rs = stmt.executeQuery(sql);
/*  650 */       int i = 0;
/*  651 */       while (rs.next())
/*      */       {
/*  653 */         i++;
/*  654 */         MLibrarySchema s1 = new MLibrarySchema();
/*  655 */         s1.setSchema(rs, i);
/*  656 */         aMLibrarySet.add(s1);
/*      */       }try {
/*  658 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  664 */       CError tError = new CError();
/*  665 */       tError.moduleName = "MLibraryDB";
/*  666 */       tError.functionName = "query";
/*  667 */       tError.errorMessage = e.toString();
/*  668 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  670 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  673 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  677 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  683 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  687 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  692 */     return aMLibrarySet;
/*      */   }
/*      */ 
/*      */   public MLibrarySet executeQuery(String sql)
/*      */   {
/*  697 */     Statement stmt = null;
/*  698 */     ResultSet rs = null;
/*  699 */     MLibrarySet aMLibrarySet = new MLibrarySet();
/*      */ 
/*  701 */     if (!this.mflag) {
/*  702 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  707 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  709 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  710 */       int i = 0;
/*  711 */       while (rs.next())
/*      */       {
/*  713 */         i++;
/*  714 */         MLibrarySchema s1 = new MLibrarySchema();
/*  715 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  718 */           CError tError = new CError();
/*  719 */           tError.moduleName = "MLibraryDB";
/*  720 */           tError.functionName = "executeQuery";
/*  721 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  722 */           this.mErrors.addOneError(tError);
/*      */         }
/*  724 */         aMLibrarySet.add(s1);
/*      */       }try {
/*  726 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  732 */       CError tError = new CError();
/*  733 */       tError.moduleName = "MLibraryDB";
/*  734 */       tError.functionName = "executeQuery";
/*  735 */       tError.errorMessage = e.toString();
/*  736 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  738 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  741 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  745 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  751 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  755 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  760 */     return aMLibrarySet;
/*      */   }
/*      */ 
/*      */   public MLibrarySet query(int nStart, int nCount)
/*      */   {
/*  765 */     Statement stmt = null;
/*  766 */     ResultSet rs = null;
/*  767 */     MLibrarySet aMLibrarySet = new MLibrarySet();
/*      */ 
/*  769 */     if (!this.mflag) {
/*  770 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  775 */       stmt = this.con.createStatement(1003, 1007);
/*  776 */       SQLString sqlObj = new SQLString("MLibrary");
/*  777 */       MLibrarySchema aSchema = getSchema();
/*  778 */       sqlObj.setSQL(5, aSchema);
/*  779 */       String sql = sqlObj.getSQL();
/*      */ 
/*  781 */       rs = stmt.executeQuery(sql);
/*  782 */       int i = 0;
/*  783 */       while (rs.next())
/*      */       {
/*  785 */         i++;
/*      */ 
/*  787 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  791 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  795 */         MLibrarySchema s1 = new MLibrarySchema();
/*  796 */         s1.setSchema(rs, i);
/*  797 */         aMLibrarySet.add(s1);
/*      */       }try {
/*  799 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  805 */       CError tError = new CError();
/*  806 */       tError.moduleName = "MLibraryDB";
/*  807 */       tError.functionName = "query";
/*  808 */       tError.errorMessage = e.toString();
/*  809 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  811 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  814 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  818 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  824 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  828 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  833 */     return aMLibrarySet;
/*      */   }
/*      */ 
/*      */   public MLibrarySet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  838 */     Statement stmt = null;
/*  839 */     ResultSet rs = null;
/*  840 */     MLibrarySet aMLibrarySet = new MLibrarySet();
/*      */ 
/*  842 */     if (!this.mflag) {
/*  843 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  848 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  850 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  851 */       int i = 0;
/*  852 */       while (rs.next())
/*      */       {
/*  854 */         i++;
/*      */ 
/*  856 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  860 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  864 */         MLibrarySchema s1 = new MLibrarySchema();
/*  865 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  868 */           CError tError = new CError();
/*  869 */           tError.moduleName = "MLibraryDB";
/*  870 */           tError.functionName = "executeQuery";
/*  871 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  872 */           this.mErrors.addOneError(tError);
/*      */         }
/*  874 */         aMLibrarySet.add(s1);
/*      */       }try {
/*  876 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  882 */       CError tError = new CError();
/*  883 */       tError.moduleName = "MLibraryDB";
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
/*  910 */     return aMLibrarySet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  915 */     Statement stmt = null;
/*      */ 
/*  917 */     if (!this.mflag) {
/*  918 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  923 */       stmt = this.con.createStatement(1003, 1007);
/*  924 */       SQLString sqlObj = new SQLString("MLibrary");
/*  925 */       MLibrarySchema aSchema = getSchema();
/*  926 */       sqlObj.setSQL(2, aSchema);
/*  927 */       String sql = "update MLibrary " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  929 */       int operCount = stmt.executeUpdate(sql);
/*  930 */       if (operCount == 0)
/*      */       {
/*  933 */         CError tError = new CError();
/*  934 */         tError.moduleName = "MLibraryDB";
/*  935 */         tError.functionName = "update";
/*  936 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  937 */         this.mErrors.addOneError(tError);
/*      */ 
/*  939 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  943 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  947 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  953 */       CError tError = new CError();
/*  954 */       tError.moduleName = "MLibraryDB";
/*  955 */       tError.functionName = "update";
/*  956 */       tError.errorMessage = e.toString();
/*  957 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  959 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  961 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  965 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  969 */       return false;
/*      */     }
/*      */ 
/*  972 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  976 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  981 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  987 */     if (this.mResultSet != null)
/*      */     {
/*  990 */       CError tError = new CError();
/*  991 */       tError.moduleName = "MLibraryDB";
/*  992 */       tError.functionName = "prepareData";
/*  993 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  994 */       this.mErrors.addOneError(tError);
/*  995 */       return false;
/*      */     }
/*      */ 
/*  998 */     if (!this.mflag)
/*      */     {
/* 1000 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1004 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1005 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1010 */       CError tError = new CError();
/* 1011 */       tError.moduleName = "MLibraryDB";
/* 1012 */       tError.functionName = "prepareData";
/* 1013 */       tError.errorMessage = e.toString();
/* 1014 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1017 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1023 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1027 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1031 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1036 */       return false;
/*      */     }
/*      */ 
/* 1039 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1043 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1048 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1054 */     boolean flag = true;
/* 1055 */     if (this.mResultSet == null)
/*      */     {
/* 1057 */       CError tError = new CError();
/* 1058 */       tError.moduleName = "MLibraryDB";
/* 1059 */       tError.functionName = "hasMoreData";
/* 1060 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1061 */       this.mErrors.addOneError(tError);
/* 1062 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1066 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1070 */       CError tError = new CError();
/* 1071 */       tError.moduleName = "MLibraryDB";
/* 1072 */       tError.functionName = "hasMoreData";
/* 1073 */       tError.errorMessage = ex.toString();
/* 1074 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1077 */         this.mResultSet.close();
/* 1078 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1084 */         this.mStatement.close();
/* 1085 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1089 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1093 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1098 */       return false;
/*      */     }
/* 1100 */     return flag;
/*      */   }
/*      */ 
/*      */   public MLibrarySet getData()
/*      */   {
/* 1105 */     int tCount = 0;
/* 1106 */     MLibrarySet tMLibrarySet = new MLibrarySet();
/* 1107 */     MLibrarySchema tMLibrarySchema = null;
/* 1108 */     if (this.mResultSet == null)
/*      */     {
/* 1110 */       CError tError = new CError();
/* 1111 */       tError.moduleName = "MLibraryDB";
/* 1112 */       tError.functionName = "getData";
/* 1113 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1114 */       this.mErrors.addOneError(tError);
/* 1115 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1119 */       tCount = 1;
/* 1120 */       tMLibrarySchema = new MLibrarySchema();
/* 1121 */       tMLibrarySchema.setSchema(this.mResultSet, 1);
/* 1122 */       tMLibrarySet.add(tMLibrarySchema);
/*      */ 
/* 1124 */       while (tCount++ < 5000)
/*      */       {
/* 1126 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1128 */         tMLibrarySchema = new MLibrarySchema();
/* 1129 */         tMLibrarySchema.setSchema(this.mResultSet, 1);
/* 1130 */         tMLibrarySet.add(tMLibrarySchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1136 */       CError tError = new CError();
/* 1137 */       tError.moduleName = "MLibraryDB";
/* 1138 */       tError.functionName = "getData";
/* 1139 */       tError.errorMessage = ex.toString();
/* 1140 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1143 */         this.mResultSet.close();
/* 1144 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1150 */         this.mStatement.close();
/* 1151 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1155 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1159 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1164 */       return null;
/*      */     }
/* 1166 */     return tMLibrarySet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1171 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1174 */       if (this.mResultSet == null)
/*      */       {
/* 1176 */         CError tError = new CError();
/* 1177 */         tError.moduleName = "MLibraryDB";
/* 1178 */         tError.functionName = "closeData";
/* 1179 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1180 */         this.mErrors.addOneError(tError);
/* 1181 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1185 */         this.mResultSet.close();
/* 1186 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1191 */       CError tError = new CError();
/* 1192 */       tError.moduleName = "MLibraryDB";
/* 1193 */       tError.functionName = "closeData";
/* 1194 */       tError.errorMessage = ex2.toString();
/* 1195 */       this.mErrors.addOneError(tError);
/* 1196 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1200 */       if (this.mStatement == null)
/*      */       {
/* 1202 */         CError tError = new CError();
/* 1203 */         tError.moduleName = "MLibraryDB";
/* 1204 */         tError.functionName = "closeData";
/* 1205 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1206 */         this.mErrors.addOneError(tError);
/* 1207 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1211 */         this.mStatement.close();
/* 1212 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1217 */       CError tError = new CError();
/* 1218 */       tError.moduleName = "MLibraryDB";
/* 1219 */       tError.functionName = "closeData";
/* 1220 */       tError.errorMessage = ex3.toString();
/* 1221 */       this.mErrors.addOneError(tError);
/* 1222 */       flag = false;
/*      */     }
/* 1224 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MLibraryDB
 * JD-Core Version:    0.6.0
 */