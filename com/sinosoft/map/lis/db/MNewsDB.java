/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MNewsSchema;
/*      */ import com.sinosoft.map.lis.vschema.MNewsSet;
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
/*      */ public class MNewsDB extends MNewsSchema
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
/*      */   public MNewsDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MNews");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MNewsDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MNews");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MNewsSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MNewsDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MNewsSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MNewsDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MNews WHERE  NewsID = ?");
/*   95 */       if ((getNewsID() == null) || (getNewsID().equals("null")))
/*   96 */         pstmt.setNull(1, 12);
/*      */       else {
/*   98 */         pstmt.setString(1, getNewsID());
/*      */       }
/*  100 */       pstmt.executeUpdate();
/*  101 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "MNewsDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MNews SET  NewsID = ? , ManageCom = ? , BranchType = ? , NewsType = ? , Title = ? , Subhead = ? , Brief = ? , Author = ? , StartDisplayDate = ? , EndDisplayDate = ? , StartDisplayTime = ? , EndDisplayTime = ? , StaticPageURL = ? , MinDisplayGrade = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , ClickRate = ? , FixedTop = ? WHERE  NewsID = ?");
/*  144 */       if ((getNewsID() == null) || (getNewsID().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getNewsID());
/*      */       }
/*  149 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getManageCom());
/*      */       }
/*  154 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getBranchType());
/*      */       }
/*  159 */       if ((getNewsType() == null) || (getNewsType().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getNewsType());
/*      */       }
/*  164 */       if ((getTitle() == null) || (getTitle().equals("null")))
/*  165 */         pstmt.setNull(5, 12);
/*      */       else {
/*  167 */         pstmt.setString(5, getTitle());
/*      */       }
/*  169 */       if ((getSubhead() == null) || (getSubhead().equals("null")))
/*  170 */         pstmt.setNull(6, 12);
/*      */       else {
/*  172 */         pstmt.setString(6, getSubhead());
/*      */       }
/*  174 */       if ((getBrief() == null) || (getBrief().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getBrief());
/*      */       }
/*  179 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  180 */         pstmt.setNull(8, 12);
/*      */       else {
/*  182 */         pstmt.setString(8, getAuthor());
/*      */       }
/*  184 */       if ((getStartDisplayDate() == null) || (getStartDisplayDate().equals("null")))
/*  185 */         pstmt.setNull(9, 91);
/*      */       else {
/*  187 */         pstmt.setDate(9, Date.valueOf(getStartDisplayDate()));
/*      */       }
/*  189 */       if ((getEndDisplayDate() == null) || (getEndDisplayDate().equals("null")))
/*  190 */         pstmt.setNull(10, 91);
/*      */       else {
/*  192 */         pstmt.setDate(10, Date.valueOf(getEndDisplayDate()));
/*      */       }
/*  194 */       if ((getStartDisplayTime() == null) || (getStartDisplayTime().equals("null")))
/*  195 */         pstmt.setNull(11, 12);
/*      */       else {
/*  197 */         pstmt.setString(11, getStartDisplayTime());
/*      */       }
/*  199 */       if ((getEndDisplayTime() == null) || (getEndDisplayTime().equals("null")))
/*  200 */         pstmt.setNull(12, 12);
/*      */       else {
/*  202 */         pstmt.setString(12, getEndDisplayTime());
/*      */       }
/*  204 */       if ((getStaticPageURL() == null) || (getStaticPageURL().equals("null")))
/*  205 */         pstmt.setNull(13, 12);
/*      */       else {
/*  207 */         pstmt.setString(13, getStaticPageURL());
/*      */       }
/*  209 */       if ((getMinDisplayGrade() == null) || (getMinDisplayGrade().equals("null")))
/*  210 */         pstmt.setNull(14, 12);
/*      */       else {
/*  212 */         pstmt.setString(14, getMinDisplayGrade());
/*      */       }
/*  214 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  215 */         pstmt.setNull(15, 12);
/*      */       else {
/*  217 */         pstmt.setString(15, getCheckState());
/*      */       }
/*  219 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  220 */         pstmt.setNull(16, 12);
/*      */       else {
/*  222 */         pstmt.setString(16, getCheckOperator());
/*      */       }
/*  224 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  225 */         pstmt.setNull(17, 12);
/*      */       else {
/*  227 */         pstmt.setString(17, getCheckReason());
/*      */       }
/*  229 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  230 */         pstmt.setNull(18, 91);
/*      */       else {
/*  232 */         pstmt.setDate(18, Date.valueOf(getCheckDate()));
/*      */       }
/*  234 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  235 */         pstmt.setNull(19, 12);
/*      */       else {
/*  237 */         pstmt.setString(19, getCheckTime());
/*      */       }
/*  239 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  240 */         pstmt.setNull(20, 12);
/*      */       else {
/*  242 */         pstmt.setString(20, getVF01());
/*      */       }
/*  244 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  245 */         pstmt.setNull(21, 12);
/*      */       else {
/*  247 */         pstmt.setString(21, getNF01());
/*      */       }
/*  249 */       pstmt.setInt(22, getIF01());
/*  250 */       pstmt.setDouble(23, getDF02());
/*  251 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  252 */         pstmt.setNull(24, 91);
/*      */       else {
/*  254 */         pstmt.setDate(24, Date.valueOf(getDate01()));
/*      */       }
/*  256 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  257 */         pstmt.setNull(25, 12);
/*      */       else {
/*  259 */         pstmt.setString(25, getModifyOperator());
/*      */       }
/*  261 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  262 */         pstmt.setNull(26, 12);
/*      */       else {
/*  264 */         pstmt.setString(26, getOperator());
/*      */       }
/*  266 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  267 */         pstmt.setNull(27, 91);
/*      */       else {
/*  269 */         pstmt.setDate(27, Date.valueOf(getMakeDate()));
/*      */       }
/*  271 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  272 */         pstmt.setNull(28, 12);
/*      */       else {
/*  274 */         pstmt.setString(28, getMakeTime());
/*      */       }
/*  276 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  277 */         pstmt.setNull(29, 91);
/*      */       else {
/*  279 */         pstmt.setDate(29, Date.valueOf(getModifyDate()));
/*      */       }
/*  281 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  282 */         pstmt.setNull(30, 12);
/*      */       else {
/*  284 */         pstmt.setString(30, getModifyTime());
/*      */       }
/*  286 */       pstmt.setInt(31, getClickRate());
/*  287 */       pstmt.setInt(32, getFixedTop());
/*      */ 
/*  289 */       if ((getNewsID() == null) || (getNewsID().equals("null")))
/*  290 */         pstmt.setNull(33, 12);
/*      */       else {
/*  292 */         pstmt.setString(33, getNewsID());
/*      */       }
/*  294 */       pstmt.executeUpdate();
/*  295 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  298 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  299 */       CError tError = new CError();
/*  300 */       tError.moduleName = "MNewsDB";
/*  301 */       tError.functionName = "update()";
/*  302 */       tError.errorMessage = ex.toString();
/*  303 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  306 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  309 */       if (!this.mflag)
/*      */         try {
/*  311 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  315 */       return false;
/*      */     }
/*      */ 
/*  318 */     if (!this.mflag)
/*      */       try {
/*  320 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  324 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  329 */     PreparedStatement pstmt = null;
/*      */ 
/*  331 */     if (!this.mflag) {
/*  332 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  337 */       pstmt = this.con.prepareStatement("INSERT INTO MNews VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  338 */       if ((getNewsID() == null) || (getNewsID().equals("null")))
/*  339 */         pstmt.setNull(1, 12);
/*      */       else {
/*  341 */         pstmt.setString(1, getNewsID());
/*      */       }
/*  343 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  344 */         pstmt.setNull(2, 12);
/*      */       else {
/*  346 */         pstmt.setString(2, getManageCom());
/*      */       }
/*  348 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  349 */         pstmt.setNull(3, 12);
/*      */       else {
/*  351 */         pstmt.setString(3, getBranchType());
/*      */       }
/*  353 */       if ((getNewsType() == null) || (getNewsType().equals("null")))
/*  354 */         pstmt.setNull(4, 12);
/*      */       else {
/*  356 */         pstmt.setString(4, getNewsType());
/*      */       }
/*  358 */       if ((getTitle() == null) || (getTitle().equals("null")))
/*  359 */         pstmt.setNull(5, 12);
/*      */       else {
/*  361 */         pstmt.setString(5, getTitle());
/*      */       }
/*  363 */       if ((getSubhead() == null) || (getSubhead().equals("null")))
/*  364 */         pstmt.setNull(6, 12);
/*      */       else {
/*  366 */         pstmt.setString(6, getSubhead());
/*      */       }
/*  368 */       if ((getBrief() == null) || (getBrief().equals("null")))
/*  369 */         pstmt.setNull(7, 12);
/*      */       else {
/*  371 */         pstmt.setString(7, getBrief());
/*      */       }
/*  373 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  374 */         pstmt.setNull(8, 12);
/*      */       else {
/*  376 */         pstmt.setString(8, getAuthor());
/*      */       }
/*  378 */       if ((getStartDisplayDate() == null) || (getStartDisplayDate().equals("null")))
/*  379 */         pstmt.setNull(9, 91);
/*      */       else {
/*  381 */         pstmt.setDate(9, Date.valueOf(getStartDisplayDate()));
/*      */       }
/*  383 */       if ((getEndDisplayDate() == null) || (getEndDisplayDate().equals("null")))
/*  384 */         pstmt.setNull(10, 91);
/*      */       else {
/*  386 */         pstmt.setDate(10, Date.valueOf(getEndDisplayDate()));
/*      */       }
/*  388 */       if ((getStartDisplayTime() == null) || (getStartDisplayTime().equals("null")))
/*  389 */         pstmt.setNull(11, 12);
/*      */       else {
/*  391 */         pstmt.setString(11, getStartDisplayTime());
/*      */       }
/*  393 */       if ((getEndDisplayTime() == null) || (getEndDisplayTime().equals("null")))
/*  394 */         pstmt.setNull(12, 12);
/*      */       else {
/*  396 */         pstmt.setString(12, getEndDisplayTime());
/*      */       }
/*  398 */       if ((getStaticPageURL() == null) || (getStaticPageURL().equals("null")))
/*  399 */         pstmt.setNull(13, 12);
/*      */       else {
/*  401 */         pstmt.setString(13, getStaticPageURL());
/*      */       }
/*  403 */       if ((getMinDisplayGrade() == null) || (getMinDisplayGrade().equals("null")))
/*  404 */         pstmt.setNull(14, 12);
/*      */       else {
/*  406 */         pstmt.setString(14, getMinDisplayGrade());
/*      */       }
/*  408 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  409 */         pstmt.setNull(15, 12);
/*      */       else {
/*  411 */         pstmt.setString(15, getCheckState());
/*      */       }
/*  413 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  414 */         pstmt.setNull(16, 12);
/*      */       else {
/*  416 */         pstmt.setString(16, getCheckOperator());
/*      */       }
/*  418 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  419 */         pstmt.setNull(17, 12);
/*      */       else {
/*  421 */         pstmt.setString(17, getCheckReason());
/*      */       }
/*  423 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  424 */         pstmt.setNull(18, 91);
/*      */       else {
/*  426 */         pstmt.setDate(18, Date.valueOf(getCheckDate()));
/*      */       }
/*  428 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  429 */         pstmt.setNull(19, 12);
/*      */       else {
/*  431 */         pstmt.setString(19, getCheckTime());
/*      */       }
/*  433 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  434 */         pstmt.setNull(20, 12);
/*      */       else {
/*  436 */         pstmt.setString(20, getVF01());
/*      */       }
/*  438 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  439 */         pstmt.setNull(21, 12);
/*      */       else {
/*  441 */         pstmt.setString(21, getNF01());
/*      */       }
/*  443 */       pstmt.setInt(22, getIF01());
/*  444 */       pstmt.setDouble(23, getDF02());
/*  445 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  446 */         pstmt.setNull(24, 91);
/*      */       else {
/*  448 */         pstmt.setDate(24, Date.valueOf(getDate01()));
/*      */       }
/*  450 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  451 */         pstmt.setNull(25, 12);
/*      */       else {
/*  453 */         pstmt.setString(25, getModifyOperator());
/*      */       }
/*  455 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  456 */         pstmt.setNull(26, 12);
/*      */       else {
/*  458 */         pstmt.setString(26, getOperator());
/*      */       }
/*  460 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  461 */         pstmt.setNull(27, 91);
/*      */       else {
/*  463 */         pstmt.setDate(27, Date.valueOf(getMakeDate()));
/*      */       }
/*  465 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  466 */         pstmt.setNull(28, 12);
/*      */       else {
/*  468 */         pstmt.setString(28, getMakeTime());
/*      */       }
/*  470 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  471 */         pstmt.setNull(29, 91);
/*      */       else {
/*  473 */         pstmt.setDate(29, Date.valueOf(getModifyDate()));
/*      */       }
/*  475 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  476 */         pstmt.setNull(30, 12);
/*      */       else {
/*  478 */         pstmt.setString(30, getModifyTime());
/*      */       }
/*  480 */       pstmt.setInt(31, getClickRate());
/*  481 */       pstmt.setInt(32, getFixedTop());
/*      */ 
/*  483 */       pstmt.executeUpdate();
/*  484 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  487 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  488 */       CError tError = new CError();
/*  489 */       tError.moduleName = "MNewsDB";
/*  490 */       tError.functionName = "insert()";
/*  491 */       tError.errorMessage = ex.toString();
/*  492 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  495 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  498 */       if (!this.mflag)
/*      */         try {
/*  500 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  504 */       return false;
/*      */     }
/*      */ 
/*  507 */     if (!this.mflag)
/*      */       try {
/*  509 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  513 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  518 */     PreparedStatement pstmt = null;
/*  519 */     ResultSet rs = null;
/*      */ 
/*  521 */     if (!this.mflag) {
/*  522 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  527 */       pstmt = this.con.prepareStatement("SELECT * FROM MNews WHERE  NewsID = ?", 
/*  528 */         1003, 1007);
/*  529 */       if ((getNewsID() == null) || (getNewsID().equals("null")))
/*  530 */         pstmt.setNull(1, 12);
/*      */       else {
/*  532 */         pstmt.setString(1, getNewsID());
/*      */       }
/*  534 */       rs = pstmt.executeQuery();
/*  535 */       int i = 0;
/*  536 */       if (rs.next())
/*      */       {
/*  538 */         i++;
/*  539 */         if (!setSchema(rs, i))
/*      */         {
/*  542 */           CError tError = new CError();
/*  543 */           tError.moduleName = "MNewsDB";
/*  544 */           tError.functionName = "getInfo";
/*  545 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  546 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  548 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  551 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  555 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  559 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  563 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  566 */       if (i == 0)
/*      */       {
/*  568 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  572 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  576 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  582 */       CError tError = new CError();
/*  583 */       tError.moduleName = "MNewsDB";
/*  584 */       tError.functionName = "getInfo";
/*  585 */       tError.errorMessage = e.toString();
/*  586 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  588 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  591 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  595 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  599 */       return false;
/*      */     }
/*      */ 
/*  602 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  606 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  611 */     return true;
/*      */   }
/*      */ 
/*      */   public MNewsSet query()
/*      */   {
/*  616 */     Statement stmt = null;
/*  617 */     ResultSet rs = null;
/*  618 */     MNewsSet aMNewsSet = new MNewsSet();
/*      */ 
/*  620 */     if (!this.mflag) {
/*  621 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  626 */       stmt = this.con.createStatement(1003, 1007);
/*  627 */       SQLString sqlObj = new SQLString("MNews");
/*  628 */       MNewsSchema aSchema = getSchema();
/*  629 */       sqlObj.setSQL(5, aSchema);
/*  630 */       String sql = sqlObj.getSQL();
/*      */ 
/*  632 */       rs = stmt.executeQuery(sql);
/*  633 */       int i = 0;
/*  634 */       while (rs.next())
/*      */       {
/*  636 */         i++;
/*  637 */         MNewsSchema s1 = new MNewsSchema();
/*  638 */         s1.setSchema(rs, i);
/*  639 */         aMNewsSet.add(s1);
/*      */       }try {
/*  641 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  647 */       CError tError = new CError();
/*  648 */       tError.moduleName = "MNewsDB";
/*  649 */       tError.functionName = "query";
/*  650 */       tError.errorMessage = e.toString();
/*  651 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  653 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  656 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  660 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  666 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  670 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  675 */     return aMNewsSet;
/*      */   }
/*      */ 
/*      */   public MNewsSet executeQuery(String sql)
/*      */   {
/*  680 */     Statement stmt = null;
/*  681 */     ResultSet rs = null;
/*  682 */     MNewsSet aMNewsSet = new MNewsSet();
/*      */ 
/*  684 */     if (!this.mflag) {
/*  685 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  690 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  692 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  693 */       int i = 0;
/*  694 */       while (rs.next())
/*      */       {
/*  696 */         i++;
/*  697 */         MNewsSchema s1 = new MNewsSchema();
/*  698 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  701 */           CError tError = new CError();
/*  702 */           tError.moduleName = "MNewsDB";
/*  703 */           tError.functionName = "executeQuery";
/*  704 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  705 */           this.mErrors.addOneError(tError);
/*      */         }
/*  707 */         aMNewsSet.add(s1);
/*      */       }try {
/*  709 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  715 */       CError tError = new CError();
/*  716 */       tError.moduleName = "MNewsDB";
/*  717 */       tError.functionName = "executeQuery";
/*  718 */       tError.errorMessage = e.toString();
/*  719 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  721 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  724 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  728 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  734 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  738 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  743 */     return aMNewsSet;
/*      */   }
/*      */ 
/*      */   public MNewsSet query(int nStart, int nCount)
/*      */   {
/*  748 */     Statement stmt = null;
/*  749 */     ResultSet rs = null;
/*  750 */     MNewsSet aMNewsSet = new MNewsSet();
/*      */ 
/*  752 */     if (!this.mflag) {
/*  753 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  758 */       stmt = this.con.createStatement(1003, 1007);
/*  759 */       SQLString sqlObj = new SQLString("MNews");
/*  760 */       MNewsSchema aSchema = getSchema();
/*  761 */       sqlObj.setSQL(5, aSchema);
/*  762 */       String sql = sqlObj.getSQL();
/*      */ 
/*  764 */       rs = stmt.executeQuery(sql);
/*  765 */       int i = 0;
/*  766 */       while (rs.next())
/*      */       {
/*  768 */         i++;
/*      */ 
/*  770 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  774 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  778 */         MNewsSchema s1 = new MNewsSchema();
/*  779 */         s1.setSchema(rs, i);
/*  780 */         aMNewsSet.add(s1);
/*      */       }try {
/*  782 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  788 */       CError tError = new CError();
/*  789 */       tError.moduleName = "MNewsDB";
/*  790 */       tError.functionName = "query";
/*  791 */       tError.errorMessage = e.toString();
/*  792 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  794 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  797 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  801 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  807 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  811 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  816 */     return aMNewsSet;
/*      */   }
/*      */ 
/*      */   public MNewsSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  821 */     Statement stmt = null;
/*  822 */     ResultSet rs = null;
/*  823 */     MNewsSet aMNewsSet = new MNewsSet();
/*      */ 
/*  825 */     if (!this.mflag) {
/*  826 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  831 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  833 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  834 */       int i = 0;
/*  835 */       while (rs.next())
/*      */       {
/*  837 */         i++;
/*      */ 
/*  839 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  843 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  847 */         MNewsSchema s1 = new MNewsSchema();
/*  848 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  851 */           CError tError = new CError();
/*  852 */           tError.moduleName = "MNewsDB";
/*  853 */           tError.functionName = "executeQuery";
/*  854 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  855 */           this.mErrors.addOneError(tError);
/*      */         }
/*  857 */         aMNewsSet.add(s1);
/*      */       }try {
/*  859 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  865 */       CError tError = new CError();
/*  866 */       tError.moduleName = "MNewsDB";
/*  867 */       tError.functionName = "executeQuery";
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
/*  893 */     return aMNewsSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  898 */     Statement stmt = null;
/*      */ 
/*  900 */     if (!this.mflag) {
/*  901 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  906 */       stmt = this.con.createStatement(1003, 1007);
/*  907 */       SQLString sqlObj = new SQLString("MNews");
/*  908 */       MNewsSchema aSchema = getSchema();
/*  909 */       sqlObj.setSQL(2, aSchema);
/*  910 */       String sql = "update MNews " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  912 */       int operCount = stmt.executeUpdate(sql);
/*  913 */       if (operCount == 0)
/*      */       {
/*  916 */         CError tError = new CError();
/*  917 */         tError.moduleName = "MNewsDB";
/*  918 */         tError.functionName = "update";
/*  919 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  920 */         this.mErrors.addOneError(tError);
/*      */ 
/*  922 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  926 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  930 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  936 */       CError tError = new CError();
/*  937 */       tError.moduleName = "MNewsDB";
/*  938 */       tError.functionName = "update";
/*  939 */       tError.errorMessage = e.toString();
/*  940 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  942 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  944 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  948 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  952 */       return false;
/*      */     }
/*      */ 
/*  955 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  959 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  964 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  970 */     if (this.mResultSet != null)
/*      */     {
/*  973 */       CError tError = new CError();
/*  974 */       tError.moduleName = "MNewsDB";
/*  975 */       tError.functionName = "prepareData";
/*  976 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  977 */       this.mErrors.addOneError(tError);
/*  978 */       return false;
/*      */     }
/*      */ 
/*  981 */     if (!this.mflag)
/*      */     {
/*  983 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  987 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  988 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  993 */       CError tError = new CError();
/*  994 */       tError.moduleName = "MNewsDB";
/*  995 */       tError.functionName = "prepareData";
/*  996 */       tError.errorMessage = e.toString();
/*  997 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1000 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1006 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1010 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1014 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1019 */       return false;
/*      */     }
/*      */ 
/* 1022 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1026 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1031 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1037 */     boolean flag = true;
/* 1038 */     if (this.mResultSet == null)
/*      */     {
/* 1040 */       CError tError = new CError();
/* 1041 */       tError.moduleName = "MNewsDB";
/* 1042 */       tError.functionName = "hasMoreData";
/* 1043 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1044 */       this.mErrors.addOneError(tError);
/* 1045 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1049 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1053 */       CError tError = new CError();
/* 1054 */       tError.moduleName = "MNewsDB";
/* 1055 */       tError.functionName = "hasMoreData";
/* 1056 */       tError.errorMessage = ex.toString();
/* 1057 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1060 */         this.mResultSet.close();
/* 1061 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1067 */         this.mStatement.close();
/* 1068 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1072 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1076 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1081 */       return false;
/*      */     }
/* 1083 */     return flag;
/*      */   }
/*      */ 
/*      */   public MNewsSet getData()
/*      */   {
/* 1088 */     int tCount = 0;
/* 1089 */     MNewsSet tMNewsSet = new MNewsSet();
/* 1090 */     MNewsSchema tMNewsSchema = null;
/* 1091 */     if (this.mResultSet == null)
/*      */     {
/* 1093 */       CError tError = new CError();
/* 1094 */       tError.moduleName = "MNewsDB";
/* 1095 */       tError.functionName = "getData";
/* 1096 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1097 */       this.mErrors.addOneError(tError);
/* 1098 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1102 */       tCount = 1;
/* 1103 */       tMNewsSchema = new MNewsSchema();
/* 1104 */       tMNewsSchema.setSchema(this.mResultSet, 1);
/* 1105 */       tMNewsSet.add(tMNewsSchema);
/*      */ 
/* 1107 */       while (tCount++ < 5000)
/*      */       {
/* 1109 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1111 */         tMNewsSchema = new MNewsSchema();
/* 1112 */         tMNewsSchema.setSchema(this.mResultSet, 1);
/* 1113 */         tMNewsSet.add(tMNewsSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1119 */       CError tError = new CError();
/* 1120 */       tError.moduleName = "MNewsDB";
/* 1121 */       tError.functionName = "getData";
/* 1122 */       tError.errorMessage = ex.toString();
/* 1123 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1126 */         this.mResultSet.close();
/* 1127 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1133 */         this.mStatement.close();
/* 1134 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1138 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1142 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1147 */       return null;
/*      */     }
/* 1149 */     return tMNewsSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1154 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1157 */       if (this.mResultSet == null)
/*      */       {
/* 1159 */         CError tError = new CError();
/* 1160 */         tError.moduleName = "MNewsDB";
/* 1161 */         tError.functionName = "closeData";
/* 1162 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1163 */         this.mErrors.addOneError(tError);
/* 1164 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1168 */         this.mResultSet.close();
/* 1169 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1174 */       CError tError = new CError();
/* 1175 */       tError.moduleName = "MNewsDB";
/* 1176 */       tError.functionName = "closeData";
/* 1177 */       tError.errorMessage = ex2.toString();
/* 1178 */       this.mErrors.addOneError(tError);
/* 1179 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1183 */       if (this.mStatement == null)
/*      */       {
/* 1185 */         CError tError = new CError();
/* 1186 */         tError.moduleName = "MNewsDB";
/* 1187 */         tError.functionName = "closeData";
/* 1188 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1189 */         this.mErrors.addOneError(tError);
/* 1190 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1194 */         this.mStatement.close();
/* 1195 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1200 */       CError tError = new CError();
/* 1201 */       tError.moduleName = "MNewsDB";
/* 1202 */       tError.functionName = "closeData";
/* 1203 */       tError.errorMessage = ex3.toString();
/* 1204 */       this.mErrors.addOneError(tError);
/* 1205 */       flag = false;
/*      */     }
/* 1207 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MNewsDB
 * JD-Core Version:    0.6.0
 */