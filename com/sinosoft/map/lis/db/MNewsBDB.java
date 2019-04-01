/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MNewsBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MNewsBSet;
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
/*      */ public class MNewsBDB extends MNewsBSchema
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
/*      */   public MNewsBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MNewsB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MNewsBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MNewsB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MNewsBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MNewsBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MNewsBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MNewsBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MNewsB WHERE  EdorNo = ?");
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
/*  107 */       tError.moduleName = "MNewsBDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MNewsB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , NewsID = ? , ManageCom = ? , BranchType = ? , NewsType = ? , Title = ? , Subhead = ? , Brief = ? , Author = ? , StartDisplayDate = ? , EndDisplayDate = ? , StartDisplayTime = ? , EndDisplayTime = ? , StaticPageURL = ? , MinDisplayGrade = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , ClickRate = ? , FixedTop = ? WHERE  EdorNo = ?");
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
/*  175 */       if ((getNewsID() == null) || (getNewsID().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getNewsID());
/*      */       }
/*  180 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getManageCom());
/*      */       }
/*  185 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getBranchType());
/*      */       }
/*  190 */       if ((getNewsType() == null) || (getNewsType().equals("null")))
/*  191 */         pstmt.setNull(10, 12);
/*      */       else {
/*  193 */         pstmt.setString(10, getNewsType());
/*      */       }
/*  195 */       if ((getTitle() == null) || (getTitle().equals("null")))
/*  196 */         pstmt.setNull(11, 12);
/*      */       else {
/*  198 */         pstmt.setString(11, getTitle());
/*      */       }
/*  200 */       if ((getSubhead() == null) || (getSubhead().equals("null")))
/*  201 */         pstmt.setNull(12, 12);
/*      */       else {
/*  203 */         pstmt.setString(12, getSubhead());
/*      */       }
/*  205 */       if ((getBrief() == null) || (getBrief().equals("null")))
/*  206 */         pstmt.setNull(13, 12);
/*      */       else {
/*  208 */         pstmt.setString(13, getBrief());
/*      */       }
/*  210 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  211 */         pstmt.setNull(14, 12);
/*      */       else {
/*  213 */         pstmt.setString(14, getAuthor());
/*      */       }
/*  215 */       if ((getStartDisplayDate() == null) || (getStartDisplayDate().equals("null")))
/*  216 */         pstmt.setNull(15, 91);
/*      */       else {
/*  218 */         pstmt.setDate(15, Date.valueOf(getStartDisplayDate()));
/*      */       }
/*  220 */       if ((getEndDisplayDate() == null) || (getEndDisplayDate().equals("null")))
/*  221 */         pstmt.setNull(16, 91);
/*      */       else {
/*  223 */         pstmt.setDate(16, Date.valueOf(getEndDisplayDate()));
/*      */       }
/*  225 */       if ((getStartDisplayTime() == null) || (getStartDisplayTime().equals("null")))
/*  226 */         pstmt.setNull(17, 12);
/*      */       else {
/*  228 */         pstmt.setString(17, getStartDisplayTime());
/*      */       }
/*  230 */       if ((getEndDisplayTime() == null) || (getEndDisplayTime().equals("null")))
/*  231 */         pstmt.setNull(18, 12);
/*      */       else {
/*  233 */         pstmt.setString(18, getEndDisplayTime());
/*      */       }
/*  235 */       if ((getStaticPageURL() == null) || (getStaticPageURL().equals("null")))
/*  236 */         pstmt.setNull(19, 12);
/*      */       else {
/*  238 */         pstmt.setString(19, getStaticPageURL());
/*      */       }
/*  240 */       if ((getMinDisplayGrade() == null) || (getMinDisplayGrade().equals("null")))
/*  241 */         pstmt.setNull(20, 12);
/*      */       else {
/*  243 */         pstmt.setString(20, getMinDisplayGrade());
/*      */       }
/*  245 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  246 */         pstmt.setNull(21, 12);
/*      */       else {
/*  248 */         pstmt.setString(21, getCheckState());
/*      */       }
/*  250 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  251 */         pstmt.setNull(22, 12);
/*      */       else {
/*  253 */         pstmt.setString(22, getCheckOperator());
/*      */       }
/*  255 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  256 */         pstmt.setNull(23, 12);
/*      */       else {
/*  258 */         pstmt.setString(23, getCheckReason());
/*      */       }
/*  260 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  261 */         pstmt.setNull(24, 91);
/*      */       else {
/*  263 */         pstmt.setDate(24, Date.valueOf(getCheckDate()));
/*      */       }
/*  265 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  266 */         pstmt.setNull(25, 12);
/*      */       else {
/*  268 */         pstmt.setString(25, getCheckTime());
/*      */       }
/*  270 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  271 */         pstmt.setNull(26, 12);
/*      */       else {
/*  273 */         pstmt.setString(26, getVF01());
/*      */       }
/*  275 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  276 */         pstmt.setNull(27, 12);
/*      */       else {
/*  278 */         pstmt.setString(27, getNF01());
/*      */       }
/*  280 */       pstmt.setInt(28, getIF01());
/*  281 */       pstmt.setDouble(29, getDF02());
/*  282 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  283 */         pstmt.setNull(30, 91);
/*      */       else {
/*  285 */         pstmt.setDate(30, Date.valueOf(getDate01()));
/*      */       }
/*  287 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  288 */         pstmt.setNull(31, 12);
/*      */       else {
/*  290 */         pstmt.setString(31, getModifyOperator());
/*      */       }
/*  292 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  293 */         pstmt.setNull(32, 12);
/*      */       else {
/*  295 */         pstmt.setString(32, getOperator());
/*      */       }
/*  297 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  298 */         pstmt.setNull(33, 91);
/*      */       else {
/*  300 */         pstmt.setDate(33, Date.valueOf(getMakeDate()));
/*      */       }
/*  302 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  303 */         pstmt.setNull(34, 12);
/*      */       else {
/*  305 */         pstmt.setString(34, getMakeTime());
/*      */       }
/*  307 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  308 */         pstmt.setNull(35, 91);
/*      */       else {
/*  310 */         pstmt.setDate(35, Date.valueOf(getModifyDate()));
/*      */       }
/*  312 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  313 */         pstmt.setNull(36, 12);
/*      */       else {
/*  315 */         pstmt.setString(36, getModifyTime());
/*      */       }
/*  317 */       pstmt.setInt(37, getClickRate());
/*  318 */       pstmt.setInt(38, getFixedTop());
/*      */ 
/*  320 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  321 */         pstmt.setNull(39, 12);
/*      */       else {
/*  323 */         pstmt.setString(39, getEdorNo());
/*      */       }
/*  325 */       pstmt.executeUpdate();
/*  326 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  329 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  330 */       CError tError = new CError();
/*  331 */       tError.moduleName = "MNewsBDB";
/*  332 */       tError.functionName = "update()";
/*  333 */       tError.errorMessage = ex.toString();
/*  334 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  337 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  340 */       if (!this.mflag)
/*      */         try {
/*  342 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  346 */       return false;
/*      */     }
/*      */ 
/*  349 */     if (!this.mflag)
/*      */       try {
/*  351 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  355 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  360 */     PreparedStatement pstmt = null;
/*      */ 
/*  362 */     if (!this.mflag) {
/*  363 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  368 */       pstmt = this.con.prepareStatement("INSERT INTO MNewsB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  369 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  370 */         pstmt.setNull(1, 12);
/*      */       else {
/*  372 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  374 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  375 */         pstmt.setNull(2, 12);
/*      */       else {
/*  377 */         pstmt.setString(2, getEdorType());
/*      */       }
/*  379 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  380 */         pstmt.setNull(3, 12);
/*      */       else {
/*  382 */         pstmt.setString(3, getEdorCase());
/*      */       }
/*  384 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  385 */         pstmt.setNull(4, 12);
/*      */       else {
/*  387 */         pstmt.setString(4, getOperator2());
/*      */       }
/*  389 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  390 */         pstmt.setNull(5, 91);
/*      */       else {
/*  392 */         pstmt.setDate(5, Date.valueOf(getMakeDate2()));
/*      */       }
/*  394 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  395 */         pstmt.setNull(6, 12);
/*      */       else {
/*  397 */         pstmt.setString(6, getMakeTime2());
/*      */       }
/*  399 */       if ((getNewsID() == null) || (getNewsID().equals("null")))
/*  400 */         pstmt.setNull(7, 12);
/*      */       else {
/*  402 */         pstmt.setString(7, getNewsID());
/*      */       }
/*  404 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  405 */         pstmt.setNull(8, 12);
/*      */       else {
/*  407 */         pstmt.setString(8, getManageCom());
/*      */       }
/*  409 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  410 */         pstmt.setNull(9, 12);
/*      */       else {
/*  412 */         pstmt.setString(9, getBranchType());
/*      */       }
/*  414 */       if ((getNewsType() == null) || (getNewsType().equals("null")))
/*  415 */         pstmt.setNull(10, 12);
/*      */       else {
/*  417 */         pstmt.setString(10, getNewsType());
/*      */       }
/*  419 */       if ((getTitle() == null) || (getTitle().equals("null")))
/*  420 */         pstmt.setNull(11, 12);
/*      */       else {
/*  422 */         pstmt.setString(11, getTitle());
/*      */       }
/*  424 */       if ((getSubhead() == null) || (getSubhead().equals("null")))
/*  425 */         pstmt.setNull(12, 12);
/*      */       else {
/*  427 */         pstmt.setString(12, getSubhead());
/*      */       }
/*  429 */       if ((getBrief() == null) || (getBrief().equals("null")))
/*  430 */         pstmt.setNull(13, 12);
/*      */       else {
/*  432 */         pstmt.setString(13, getBrief());
/*      */       }
/*  434 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  435 */         pstmt.setNull(14, 12);
/*      */       else {
/*  437 */         pstmt.setString(14, getAuthor());
/*      */       }
/*  439 */       if ((getStartDisplayDate() == null) || (getStartDisplayDate().equals("null")))
/*  440 */         pstmt.setNull(15, 91);
/*      */       else {
/*  442 */         pstmt.setDate(15, Date.valueOf(getStartDisplayDate()));
/*      */       }
/*  444 */       if ((getEndDisplayDate() == null) || (getEndDisplayDate().equals("null")))
/*  445 */         pstmt.setNull(16, 91);
/*      */       else {
/*  447 */         pstmt.setDate(16, Date.valueOf(getEndDisplayDate()));
/*      */       }
/*  449 */       if ((getStartDisplayTime() == null) || (getStartDisplayTime().equals("null")))
/*  450 */         pstmt.setNull(17, 12);
/*      */       else {
/*  452 */         pstmt.setString(17, getStartDisplayTime());
/*      */       }
/*  454 */       if ((getEndDisplayTime() == null) || (getEndDisplayTime().equals("null")))
/*  455 */         pstmt.setNull(18, 12);
/*      */       else {
/*  457 */         pstmt.setString(18, getEndDisplayTime());
/*      */       }
/*  459 */       if ((getStaticPageURL() == null) || (getStaticPageURL().equals("null")))
/*  460 */         pstmt.setNull(19, 12);
/*      */       else {
/*  462 */         pstmt.setString(19, getStaticPageURL());
/*      */       }
/*  464 */       if ((getMinDisplayGrade() == null) || (getMinDisplayGrade().equals("null")))
/*  465 */         pstmt.setNull(20, 12);
/*      */       else {
/*  467 */         pstmt.setString(20, getMinDisplayGrade());
/*      */       }
/*  469 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  470 */         pstmt.setNull(21, 12);
/*      */       else {
/*  472 */         pstmt.setString(21, getCheckState());
/*      */       }
/*  474 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  475 */         pstmt.setNull(22, 12);
/*      */       else {
/*  477 */         pstmt.setString(22, getCheckOperator());
/*      */       }
/*  479 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  480 */         pstmt.setNull(23, 12);
/*      */       else {
/*  482 */         pstmt.setString(23, getCheckReason());
/*      */       }
/*  484 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  485 */         pstmt.setNull(24, 91);
/*      */       else {
/*  487 */         pstmt.setDate(24, Date.valueOf(getCheckDate()));
/*      */       }
/*  489 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  490 */         pstmt.setNull(25, 12);
/*      */       else {
/*  492 */         pstmt.setString(25, getCheckTime());
/*      */       }
/*  494 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  495 */         pstmt.setNull(26, 12);
/*      */       else {
/*  497 */         pstmt.setString(26, getVF01());
/*      */       }
/*  499 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  500 */         pstmt.setNull(27, 12);
/*      */       else {
/*  502 */         pstmt.setString(27, getNF01());
/*      */       }
/*  504 */       pstmt.setInt(28, getIF01());
/*  505 */       pstmt.setDouble(29, getDF02());
/*  506 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  507 */         pstmt.setNull(30, 91);
/*      */       else {
/*  509 */         pstmt.setDate(30, Date.valueOf(getDate01()));
/*      */       }
/*  511 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  512 */         pstmt.setNull(31, 12);
/*      */       else {
/*  514 */         pstmt.setString(31, getModifyOperator());
/*      */       }
/*  516 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  517 */         pstmt.setNull(32, 12);
/*      */       else {
/*  519 */         pstmt.setString(32, getOperator());
/*      */       }
/*  521 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  522 */         pstmt.setNull(33, 91);
/*      */       else {
/*  524 */         pstmt.setDate(33, Date.valueOf(getMakeDate()));
/*      */       }
/*  526 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  527 */         pstmt.setNull(34, 12);
/*      */       else {
/*  529 */         pstmt.setString(34, getMakeTime());
/*      */       }
/*  531 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  532 */         pstmt.setNull(35, 91);
/*      */       else {
/*  534 */         pstmt.setDate(35, Date.valueOf(getModifyDate()));
/*      */       }
/*  536 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  537 */         pstmt.setNull(36, 12);
/*      */       else {
/*  539 */         pstmt.setString(36, getModifyTime());
/*      */       }
/*  541 */       pstmt.setInt(37, getClickRate());
/*  542 */       pstmt.setInt(38, getFixedTop());
/*      */ 
/*  544 */       pstmt.executeUpdate();
/*  545 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  548 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  549 */       CError tError = new CError();
/*  550 */       tError.moduleName = "MNewsBDB";
/*  551 */       tError.functionName = "insert()";
/*  552 */       tError.errorMessage = ex.toString();
/*  553 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  556 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  559 */       if (!this.mflag)
/*      */         try {
/*  561 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  565 */       return false;
/*      */     }
/*      */ 
/*  568 */     if (!this.mflag)
/*      */       try {
/*  570 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  574 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  579 */     PreparedStatement pstmt = null;
/*  580 */     ResultSet rs = null;
/*      */ 
/*  582 */     if (!this.mflag) {
/*  583 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  588 */       pstmt = this.con.prepareStatement("SELECT * FROM MNewsB WHERE  EdorNo = ?", 
/*  589 */         1003, 1007);
/*  590 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  591 */         pstmt.setNull(1, 12);
/*      */       else {
/*  593 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  595 */       rs = pstmt.executeQuery();
/*  596 */       int i = 0;
/*  597 */       if (rs.next())
/*      */       {
/*  599 */         i++;
/*  600 */         if (!setSchema(rs, i))
/*      */         {
/*  603 */           CError tError = new CError();
/*  604 */           tError.moduleName = "MNewsBDB";
/*  605 */           tError.functionName = "getInfo";
/*  606 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  607 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  609 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  612 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  616 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  620 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  624 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  627 */       if (i == 0)
/*      */       {
/*  629 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  633 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  637 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  643 */       CError tError = new CError();
/*  644 */       tError.moduleName = "MNewsBDB";
/*  645 */       tError.functionName = "getInfo";
/*  646 */       tError.errorMessage = e.toString();
/*  647 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  649 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  652 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  656 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  660 */       return false;
/*      */     }
/*      */ 
/*  663 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  667 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  672 */     return true;
/*      */   }
/*      */ 
/*      */   public MNewsBSet query()
/*      */   {
/*  677 */     Statement stmt = null;
/*  678 */     ResultSet rs = null;
/*  679 */     MNewsBSet aMNewsBSet = new MNewsBSet();
/*      */ 
/*  681 */     if (!this.mflag) {
/*  682 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  687 */       stmt = this.con.createStatement(1003, 1007);
/*  688 */       SQLString sqlObj = new SQLString("MNewsB");
/*  689 */       MNewsBSchema aSchema = getSchema();
/*  690 */       sqlObj.setSQL(5, aSchema);
/*  691 */       String sql = sqlObj.getSQL();
/*      */ 
/*  693 */       rs = stmt.executeQuery(sql);
/*  694 */       int i = 0;
/*  695 */       while (rs.next())
/*      */       {
/*  697 */         i++;
/*  698 */         MNewsBSchema s1 = new MNewsBSchema();
/*  699 */         s1.setSchema(rs, i);
/*  700 */         aMNewsBSet.add(s1);
/*      */       }try {
/*  702 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  708 */       CError tError = new CError();
/*  709 */       tError.moduleName = "MNewsBDB";
/*  710 */       tError.functionName = "query";
/*  711 */       tError.errorMessage = e.toString();
/*  712 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  714 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  717 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  721 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  727 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  731 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  736 */     return aMNewsBSet;
/*      */   }
/*      */ 
/*      */   public MNewsBSet executeQuery(String sql)
/*      */   {
/*  741 */     Statement stmt = null;
/*  742 */     ResultSet rs = null;
/*  743 */     MNewsBSet aMNewsBSet = new MNewsBSet();
/*      */ 
/*  745 */     if (!this.mflag) {
/*  746 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  751 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  753 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  754 */       int i = 0;
/*  755 */       while (rs.next())
/*      */       {
/*  757 */         i++;
/*  758 */         MNewsBSchema s1 = new MNewsBSchema();
/*  759 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  762 */           CError tError = new CError();
/*  763 */           tError.moduleName = "MNewsBDB";
/*  764 */           tError.functionName = "executeQuery";
/*  765 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  766 */           this.mErrors.addOneError(tError);
/*      */         }
/*  768 */         aMNewsBSet.add(s1);
/*      */       }try {
/*  770 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  776 */       CError tError = new CError();
/*  777 */       tError.moduleName = "MNewsBDB";
/*  778 */       tError.functionName = "executeQuery";
/*  779 */       tError.errorMessage = e.toString();
/*  780 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  782 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  785 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  789 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  795 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  799 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  804 */     return aMNewsBSet;
/*      */   }
/*      */ 
/*      */   public MNewsBSet query(int nStart, int nCount)
/*      */   {
/*  809 */     Statement stmt = null;
/*  810 */     ResultSet rs = null;
/*  811 */     MNewsBSet aMNewsBSet = new MNewsBSet();
/*      */ 
/*  813 */     if (!this.mflag) {
/*  814 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  819 */       stmt = this.con.createStatement(1003, 1007);
/*  820 */       SQLString sqlObj = new SQLString("MNewsB");
/*  821 */       MNewsBSchema aSchema = getSchema();
/*  822 */       sqlObj.setSQL(5, aSchema);
/*  823 */       String sql = sqlObj.getSQL();
/*      */ 
/*  825 */       rs = stmt.executeQuery(sql);
/*  826 */       int i = 0;
/*  827 */       while (rs.next())
/*      */       {
/*  829 */         i++;
/*      */ 
/*  831 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  835 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  839 */         MNewsBSchema s1 = new MNewsBSchema();
/*  840 */         s1.setSchema(rs, i);
/*  841 */         aMNewsBSet.add(s1);
/*      */       }try {
/*  843 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  849 */       CError tError = new CError();
/*  850 */       tError.moduleName = "MNewsBDB";
/*  851 */       tError.functionName = "query";
/*  852 */       tError.errorMessage = e.toString();
/*  853 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  855 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  858 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  862 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  868 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  872 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  877 */     return aMNewsBSet;
/*      */   }
/*      */ 
/*      */   public MNewsBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  882 */     Statement stmt = null;
/*  883 */     ResultSet rs = null;
/*  884 */     MNewsBSet aMNewsBSet = new MNewsBSet();
/*      */ 
/*  886 */     if (!this.mflag) {
/*  887 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  892 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  894 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  895 */       int i = 0;
/*  896 */       while (rs.next())
/*      */       {
/*  898 */         i++;
/*      */ 
/*  900 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  904 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  908 */         MNewsBSchema s1 = new MNewsBSchema();
/*  909 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  912 */           CError tError = new CError();
/*  913 */           tError.moduleName = "MNewsBDB";
/*  914 */           tError.functionName = "executeQuery";
/*  915 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  916 */           this.mErrors.addOneError(tError);
/*      */         }
/*  918 */         aMNewsBSet.add(s1);
/*      */       }try {
/*  920 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  926 */       CError tError = new CError();
/*  927 */       tError.moduleName = "MNewsBDB";
/*  928 */       tError.functionName = "executeQuery";
/*  929 */       tError.errorMessage = e.toString();
/*  930 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  932 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  935 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  939 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  945 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  949 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  954 */     return aMNewsBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  959 */     Statement stmt = null;
/*      */ 
/*  961 */     if (!this.mflag) {
/*  962 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  967 */       stmt = this.con.createStatement(1003, 1007);
/*  968 */       SQLString sqlObj = new SQLString("MNewsB");
/*  969 */       MNewsBSchema aSchema = getSchema();
/*  970 */       sqlObj.setSQL(2, aSchema);
/*  971 */       String sql = "update MNewsB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  973 */       int operCount = stmt.executeUpdate(sql);
/*  974 */       if (operCount == 0)
/*      */       {
/*  977 */         CError tError = new CError();
/*  978 */         tError.moduleName = "MNewsBDB";
/*  979 */         tError.functionName = "update";
/*  980 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  981 */         this.mErrors.addOneError(tError);
/*      */ 
/*  983 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  987 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  991 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  997 */       CError tError = new CError();
/*  998 */       tError.moduleName = "MNewsBDB";
/*  999 */       tError.functionName = "update";
/* 1000 */       tError.errorMessage = e.toString();
/* 1001 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1003 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1005 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1009 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1013 */       return false;
/*      */     }
/*      */ 
/* 1016 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1020 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1025 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1031 */     if (this.mResultSet != null)
/*      */     {
/* 1034 */       CError tError = new CError();
/* 1035 */       tError.moduleName = "MNewsBDB";
/* 1036 */       tError.functionName = "prepareData";
/* 1037 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 1038 */       this.mErrors.addOneError(tError);
/* 1039 */       return false;
/*      */     }
/*      */ 
/* 1042 */     if (!this.mflag)
/*      */     {
/* 1044 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1048 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1049 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1054 */       CError tError = new CError();
/* 1055 */       tError.moduleName = "MNewsBDB";
/* 1056 */       tError.functionName = "prepareData";
/* 1057 */       tError.errorMessage = e.toString();
/* 1058 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1061 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1067 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1071 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1075 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1080 */       return false;
/*      */     }
/*      */ 
/* 1083 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1087 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1092 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1098 */     boolean flag = true;
/* 1099 */     if (this.mResultSet == null)
/*      */     {
/* 1101 */       CError tError = new CError();
/* 1102 */       tError.moduleName = "MNewsBDB";
/* 1103 */       tError.functionName = "hasMoreData";
/* 1104 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1105 */       this.mErrors.addOneError(tError);
/* 1106 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1110 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1114 */       CError tError = new CError();
/* 1115 */       tError.moduleName = "MNewsBDB";
/* 1116 */       tError.functionName = "hasMoreData";
/* 1117 */       tError.errorMessage = ex.toString();
/* 1118 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1121 */         this.mResultSet.close();
/* 1122 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1128 */         this.mStatement.close();
/* 1129 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1133 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1137 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1142 */       return false;
/*      */     }
/* 1144 */     return flag;
/*      */   }
/*      */ 
/*      */   public MNewsBSet getData()
/*      */   {
/* 1149 */     int tCount = 0;
/* 1150 */     MNewsBSet tMNewsBSet = new MNewsBSet();
/* 1151 */     MNewsBSchema tMNewsBSchema = null;
/* 1152 */     if (this.mResultSet == null)
/*      */     {
/* 1154 */       CError tError = new CError();
/* 1155 */       tError.moduleName = "MNewsBDB";
/* 1156 */       tError.functionName = "getData";
/* 1157 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1158 */       this.mErrors.addOneError(tError);
/* 1159 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1163 */       tCount = 1;
/* 1164 */       tMNewsBSchema = new MNewsBSchema();
/* 1165 */       tMNewsBSchema.setSchema(this.mResultSet, 1);
/* 1166 */       tMNewsBSet.add(tMNewsBSchema);
/*      */ 
/* 1168 */       while (tCount++ < 5000)
/*      */       {
/* 1170 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1172 */         tMNewsBSchema = new MNewsBSchema();
/* 1173 */         tMNewsBSchema.setSchema(this.mResultSet, 1);
/* 1174 */         tMNewsBSet.add(tMNewsBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1180 */       CError tError = new CError();
/* 1181 */       tError.moduleName = "MNewsBDB";
/* 1182 */       tError.functionName = "getData";
/* 1183 */       tError.errorMessage = ex.toString();
/* 1184 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1187 */         this.mResultSet.close();
/* 1188 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1194 */         this.mStatement.close();
/* 1195 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1199 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1203 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1208 */       return null;
/*      */     }
/* 1210 */     return tMNewsBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1215 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1218 */       if (this.mResultSet == null)
/*      */       {
/* 1220 */         CError tError = new CError();
/* 1221 */         tError.moduleName = "MNewsBDB";
/* 1222 */         tError.functionName = "closeData";
/* 1223 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1224 */         this.mErrors.addOneError(tError);
/* 1225 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1229 */         this.mResultSet.close();
/* 1230 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1235 */       CError tError = new CError();
/* 1236 */       tError.moduleName = "MNewsBDB";
/* 1237 */       tError.functionName = "closeData";
/* 1238 */       tError.errorMessage = ex2.toString();
/* 1239 */       this.mErrors.addOneError(tError);
/* 1240 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1244 */       if (this.mStatement == null)
/*      */       {
/* 1246 */         CError tError = new CError();
/* 1247 */         tError.moduleName = "MNewsBDB";
/* 1248 */         tError.functionName = "closeData";
/* 1249 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1250 */         this.mErrors.addOneError(tError);
/* 1251 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1255 */         this.mStatement.close();
/* 1256 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1261 */       CError tError = new CError();
/* 1262 */       tError.moduleName = "MNewsBDB";
/* 1263 */       tError.functionName = "closeData";
/* 1264 */       tError.errorMessage = ex3.toString();
/* 1265 */       this.mErrors.addOneError(tError);
/* 1266 */       flag = false;
/*      */     }
/* 1268 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MNewsBDB
 * JD-Core Version:    0.6.0
 */