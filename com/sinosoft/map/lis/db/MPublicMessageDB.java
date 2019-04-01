/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MPublicMessageSchema;
/*      */ import com.sinosoft.map.lis.vschema.MPublicMessageSet;
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
/*      */ public class MPublicMessageDB extends MPublicMessageSchema
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
/*      */   public MPublicMessageDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MPublicMessage");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MPublicMessageDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MPublicMessage");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MPublicMessageSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MPublicMessageDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MPublicMessageSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MPublicMessageDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MPublicMessage WHERE  ID = ?");
/*   95 */       if ((getID() == null) || (getID().equals("null")))
/*   96 */         pstmt.setNull(1, 12);
/*      */       else {
/*   98 */         pstmt.setString(1, getID());
/*      */       }
/*  100 */       pstmt.executeUpdate();
/*  101 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "MPublicMessageDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MPublicMessage SET  ID = ? , ManageCom = ? , ReceiveBranch = ? , BranchType = ? , Message = ? , Type = ? , Author = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? WHERE  ID = ?");
/*  144 */       if ((getID() == null) || (getID().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getID());
/*      */       }
/*  149 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getManageCom());
/*      */       }
/*  154 */       if ((getReceiveBranch() == null) || (getReceiveBranch().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getReceiveBranch());
/*      */       }
/*  159 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  164 */       if ((getMessage() == null) || (getMessage().equals("null")))
/*  165 */         pstmt.setNull(5, 12);
/*      */       else {
/*  167 */         pstmt.setString(5, getMessage());
/*      */       }
/*  169 */       if ((getType() == null) || (getType().equals("null")))
/*  170 */         pstmt.setNull(6, 12);
/*      */       else {
/*  172 */         pstmt.setString(6, getType());
/*      */       }
/*  174 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getAuthor());
/*      */       }
/*  179 */       if ((getState() == null) || (getState().equals("null")))
/*  180 */         pstmt.setNull(8, 12);
/*      */       else {
/*  182 */         pstmt.setString(8, getState());
/*      */       }
/*  184 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  185 */         pstmt.setNull(9, 91);
/*      */       else {
/*  187 */         pstmt.setDate(9, Date.valueOf(getStartDate()));
/*      */       }
/*  189 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  190 */         pstmt.setNull(10, 91);
/*      */       else {
/*  192 */         pstmt.setDate(10, Date.valueOf(getEndDate()));
/*      */       }
/*  194 */       if ((getStartTime() == null) || (getStartTime().equals("null")))
/*  195 */         pstmt.setNull(11, 12);
/*      */       else {
/*  197 */         pstmt.setString(11, getStartTime());
/*      */       }
/*  199 */       if ((getEndTime() == null) || (getEndTime().equals("null")))
/*  200 */         pstmt.setNull(12, 12);
/*      */       else {
/*  202 */         pstmt.setString(12, getEndTime());
/*      */       }
/*  204 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  205 */         pstmt.setNull(13, 12);
/*      */       else {
/*  207 */         pstmt.setString(13, getVF01());
/*      */       }
/*  209 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  210 */         pstmt.setNull(14, 12);
/*      */       else {
/*  212 */         pstmt.setString(14, getNF01());
/*      */       }
/*  214 */       pstmt.setInt(15, getIF01());
/*  215 */       pstmt.setDouble(16, getDF02());
/*  216 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  217 */         pstmt.setNull(17, 91);
/*      */       else {
/*  219 */         pstmt.setDate(17, Date.valueOf(getDate01()));
/*      */       }
/*  221 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  222 */         pstmt.setNull(18, 12);
/*      */       else {
/*  224 */         pstmt.setString(18, getOperator());
/*      */       }
/*  226 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  227 */         pstmt.setNull(19, 12);
/*      */       else {
/*  229 */         pstmt.setString(19, getModifyOperator());
/*      */       }
/*  231 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  232 */         pstmt.setNull(20, 91);
/*      */       else {
/*  234 */         pstmt.setDate(20, Date.valueOf(getMakeDate()));
/*      */       }
/*  236 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  237 */         pstmt.setNull(21, 12);
/*      */       else {
/*  239 */         pstmt.setString(21, getMakeTime());
/*      */       }
/*  241 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  242 */         pstmt.setNull(22, 91);
/*      */       else {
/*  244 */         pstmt.setDate(22, Date.valueOf(getModifyDate()));
/*      */       }
/*  246 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  247 */         pstmt.setNull(23, 12);
/*      */       else {
/*  249 */         pstmt.setString(23, getModifyTime());
/*      */       }
/*  251 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  252 */         pstmt.setNull(24, 12);
/*      */       else {
/*  254 */         pstmt.setString(24, getCheckState());
/*      */       }
/*  256 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  257 */         pstmt.setNull(25, 12);
/*      */       else {
/*  259 */         pstmt.setString(25, getCheckOperator());
/*      */       }
/*  261 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  262 */         pstmt.setNull(26, 12);
/*      */       else {
/*  264 */         pstmt.setString(26, getCheckReason());
/*      */       }
/*  266 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  267 */         pstmt.setNull(27, 91);
/*      */       else {
/*  269 */         pstmt.setDate(27, Date.valueOf(getCheckDate()));
/*      */       }
/*  271 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  272 */         pstmt.setNull(28, 12);
/*      */       else {
/*  274 */         pstmt.setString(28, getCheckTime());
/*      */       }
/*      */ 
/*  277 */       if ((getID() == null) || (getID().equals("null")))
/*  278 */         pstmt.setNull(29, 12);
/*      */       else {
/*  280 */         pstmt.setString(29, getID());
/*      */       }
/*  282 */       pstmt.executeUpdate();
/*  283 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  286 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  287 */       CError tError = new CError();
/*  288 */       tError.moduleName = "MPublicMessageDB";
/*  289 */       tError.functionName = "update()";
/*  290 */       tError.errorMessage = ex.toString();
/*  291 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  294 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  297 */       if (!this.mflag)
/*      */         try {
/*  299 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  303 */       return false;
/*      */     }
/*      */ 
/*  306 */     if (!this.mflag)
/*      */       try {
/*  308 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  312 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  317 */     PreparedStatement pstmt = null;
/*      */ 
/*  319 */     if (!this.mflag) {
/*  320 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  325 */       pstmt = this.con.prepareStatement("INSERT INTO MPublicMessage VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  326 */       if ((getID() == null) || (getID().equals("null")))
/*  327 */         pstmt.setNull(1, 12);
/*      */       else {
/*  329 */         pstmt.setString(1, getID());
/*      */       }
/*  331 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  332 */         pstmt.setNull(2, 12);
/*      */       else {
/*  334 */         pstmt.setString(2, getManageCom());
/*      */       }
/*  336 */       if ((getReceiveBranch() == null) || (getReceiveBranch().equals("null")))
/*  337 */         pstmt.setNull(3, 12);
/*      */       else {
/*  339 */         pstmt.setString(3, getReceiveBranch());
/*      */       }
/*  341 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  342 */         pstmt.setNull(4, 12);
/*      */       else {
/*  344 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  346 */       if ((getMessage() == null) || (getMessage().equals("null")))
/*  347 */         pstmt.setNull(5, 12);
/*      */       else {
/*  349 */         pstmt.setString(5, getMessage());
/*      */       }
/*  351 */       if ((getType() == null) || (getType().equals("null")))
/*  352 */         pstmt.setNull(6, 12);
/*      */       else {
/*  354 */         pstmt.setString(6, getType());
/*      */       }
/*  356 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  357 */         pstmt.setNull(7, 12);
/*      */       else {
/*  359 */         pstmt.setString(7, getAuthor());
/*      */       }
/*  361 */       if ((getState() == null) || (getState().equals("null")))
/*  362 */         pstmt.setNull(8, 12);
/*      */       else {
/*  364 */         pstmt.setString(8, getState());
/*      */       }
/*  366 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  367 */         pstmt.setNull(9, 91);
/*      */       else {
/*  369 */         pstmt.setDate(9, Date.valueOf(getStartDate()));
/*      */       }
/*  371 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  372 */         pstmt.setNull(10, 91);
/*      */       else {
/*  374 */         pstmt.setDate(10, Date.valueOf(getEndDate()));
/*      */       }
/*  376 */       if ((getStartTime() == null) || (getStartTime().equals("null")))
/*  377 */         pstmt.setNull(11, 12);
/*      */       else {
/*  379 */         pstmt.setString(11, getStartTime());
/*      */       }
/*  381 */       if ((getEndTime() == null) || (getEndTime().equals("null")))
/*  382 */         pstmt.setNull(12, 12);
/*      */       else {
/*  384 */         pstmt.setString(12, getEndTime());
/*      */       }
/*  386 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  387 */         pstmt.setNull(13, 12);
/*      */       else {
/*  389 */         pstmt.setString(13, getVF01());
/*      */       }
/*  391 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  392 */         pstmt.setNull(14, 12);
/*      */       else {
/*  394 */         pstmt.setString(14, getNF01());
/*      */       }
/*  396 */       pstmt.setInt(15, getIF01());
/*  397 */       pstmt.setDouble(16, getDF02());
/*  398 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  399 */         pstmt.setNull(17, 91);
/*      */       else {
/*  401 */         pstmt.setDate(17, Date.valueOf(getDate01()));
/*      */       }
/*  403 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  404 */         pstmt.setNull(18, 12);
/*      */       else {
/*  406 */         pstmt.setString(18, getOperator());
/*      */       }
/*  408 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  409 */         pstmt.setNull(19, 12);
/*      */       else {
/*  411 */         pstmt.setString(19, getModifyOperator());
/*      */       }
/*  413 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  414 */         pstmt.setNull(20, 91);
/*      */       else {
/*  416 */         pstmt.setDate(20, Date.valueOf(getMakeDate()));
/*      */       }
/*  418 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  419 */         pstmt.setNull(21, 12);
/*      */       else {
/*  421 */         pstmt.setString(21, getMakeTime());
/*      */       }
/*  423 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  424 */         pstmt.setNull(22, 91);
/*      */       else {
/*  426 */         pstmt.setDate(22, Date.valueOf(getModifyDate()));
/*      */       }
/*  428 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  429 */         pstmt.setNull(23, 12);
/*      */       else {
/*  431 */         pstmt.setString(23, getModifyTime());
/*      */       }
/*  433 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  434 */         pstmt.setNull(24, 12);
/*      */       else {
/*  436 */         pstmt.setString(24, getCheckState());
/*      */       }
/*  438 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  439 */         pstmt.setNull(25, 12);
/*      */       else {
/*  441 */         pstmt.setString(25, getCheckOperator());
/*      */       }
/*  443 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  444 */         pstmt.setNull(26, 12);
/*      */       else {
/*  446 */         pstmt.setString(26, getCheckReason());
/*      */       }
/*  448 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  449 */         pstmt.setNull(27, 91);
/*      */       else {
/*  451 */         pstmt.setDate(27, Date.valueOf(getCheckDate()));
/*      */       }
/*  453 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  454 */         pstmt.setNull(28, 12);
/*      */       else {
/*  456 */         pstmt.setString(28, getCheckTime());
/*      */       }
/*      */ 
/*  459 */       pstmt.executeUpdate();
/*  460 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  463 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  464 */       CError tError = new CError();
/*  465 */       tError.moduleName = "MPublicMessageDB";
/*  466 */       tError.functionName = "insert()";
/*  467 */       tError.errorMessage = ex.toString();
/*  468 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  471 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  474 */       if (!this.mflag)
/*      */         try {
/*  476 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  480 */       return false;
/*      */     }
/*      */ 
/*  483 */     if (!this.mflag)
/*      */       try {
/*  485 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  489 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  494 */     PreparedStatement pstmt = null;
/*  495 */     ResultSet rs = null;
/*      */ 
/*  497 */     if (!this.mflag) {
/*  498 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  503 */       pstmt = this.con.prepareStatement("SELECT * FROM MPublicMessage WHERE  ID = ?", 
/*  504 */         1003, 1007);
/*  505 */       if ((getID() == null) || (getID().equals("null")))
/*  506 */         pstmt.setNull(1, 12);
/*      */       else {
/*  508 */         pstmt.setString(1, getID());
/*      */       }
/*  510 */       rs = pstmt.executeQuery();
/*  511 */       int i = 0;
/*  512 */       if (rs.next())
/*      */       {
/*  514 */         i++;
/*  515 */         if (!setSchema(rs, i))
/*      */         {
/*  518 */           CError tError = new CError();
/*  519 */           tError.moduleName = "MPublicMessageDB";
/*  520 */           tError.functionName = "getInfo";
/*  521 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  522 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  524 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  527 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  531 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  535 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  539 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  542 */       if (i == 0)
/*      */       {
/*  544 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  548 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  552 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  558 */       CError tError = new CError();
/*  559 */       tError.moduleName = "MPublicMessageDB";
/*  560 */       tError.functionName = "getInfo";
/*  561 */       tError.errorMessage = e.toString();
/*  562 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  564 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  567 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  571 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  575 */       return false;
/*      */     }
/*      */ 
/*  578 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  582 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  587 */     return true;
/*      */   }
/*      */ 
/*      */   public MPublicMessageSet query()
/*      */   {
/*  592 */     Statement stmt = null;
/*  593 */     ResultSet rs = null;
/*  594 */     MPublicMessageSet aMPublicMessageSet = new MPublicMessageSet();
/*      */ 
/*  596 */     if (!this.mflag) {
/*  597 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  602 */       stmt = this.con.createStatement(1003, 1007);
/*  603 */       SQLString sqlObj = new SQLString("MPublicMessage");
/*  604 */       MPublicMessageSchema aSchema = getSchema();
/*  605 */       sqlObj.setSQL(5, aSchema);
/*  606 */       String sql = sqlObj.getSQL();
/*      */ 
/*  608 */       rs = stmt.executeQuery(sql);
/*  609 */       int i = 0;
/*  610 */       while (rs.next())
/*      */       {
/*  612 */         i++;
/*  613 */         MPublicMessageSchema s1 = new MPublicMessageSchema();
/*  614 */         s1.setSchema(rs, i);
/*  615 */         aMPublicMessageSet.add(s1);
/*      */       }try {
/*  617 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  623 */       CError tError = new CError();
/*  624 */       tError.moduleName = "MPublicMessageDB";
/*  625 */       tError.functionName = "query";
/*  626 */       tError.errorMessage = e.toString();
/*  627 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  629 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  632 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  636 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  642 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  646 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  651 */     return aMPublicMessageSet;
/*      */   }
/*      */ 
/*      */   public MPublicMessageSet executeQuery(String sql)
/*      */   {
/*  656 */     Statement stmt = null;
/*  657 */     ResultSet rs = null;
/*  658 */     MPublicMessageSet aMPublicMessageSet = new MPublicMessageSet();
/*      */ 
/*  660 */     if (!this.mflag) {
/*  661 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  666 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  668 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  669 */       int i = 0;
/*  670 */       while (rs.next())
/*      */       {
/*  672 */         i++;
/*  673 */         MPublicMessageSchema s1 = new MPublicMessageSchema();
/*  674 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  677 */           CError tError = new CError();
/*  678 */           tError.moduleName = "MPublicMessageDB";
/*  679 */           tError.functionName = "executeQuery";
/*  680 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  681 */           this.mErrors.addOneError(tError);
/*      */         }
/*  683 */         aMPublicMessageSet.add(s1);
/*      */       }try {
/*  685 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  691 */       CError tError = new CError();
/*  692 */       tError.moduleName = "MPublicMessageDB";
/*  693 */       tError.functionName = "executeQuery";
/*  694 */       tError.errorMessage = e.toString();
/*  695 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  697 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  700 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  704 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  710 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  714 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  719 */     return aMPublicMessageSet;
/*      */   }
/*      */ 
/*      */   public MPublicMessageSet query(int nStart, int nCount)
/*      */   {
/*  724 */     Statement stmt = null;
/*  725 */     ResultSet rs = null;
/*  726 */     MPublicMessageSet aMPublicMessageSet = new MPublicMessageSet();
/*      */ 
/*  728 */     if (!this.mflag) {
/*  729 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  734 */       stmt = this.con.createStatement(1003, 1007);
/*  735 */       SQLString sqlObj = new SQLString("MPublicMessage");
/*  736 */       MPublicMessageSchema aSchema = getSchema();
/*  737 */       sqlObj.setSQL(5, aSchema);
/*  738 */       String sql = sqlObj.getSQL();
/*      */ 
/*  740 */       rs = stmt.executeQuery(sql);
/*  741 */       int i = 0;
/*  742 */       while (rs.next())
/*      */       {
/*  744 */         i++;
/*      */ 
/*  746 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  750 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  754 */         MPublicMessageSchema s1 = new MPublicMessageSchema();
/*  755 */         s1.setSchema(rs, i);
/*  756 */         aMPublicMessageSet.add(s1);
/*      */       }try {
/*  758 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  764 */       CError tError = new CError();
/*  765 */       tError.moduleName = "MPublicMessageDB";
/*  766 */       tError.functionName = "query";
/*  767 */       tError.errorMessage = e.toString();
/*  768 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  770 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  773 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  777 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  783 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  787 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  792 */     return aMPublicMessageSet;
/*      */   }
/*      */ 
/*      */   public MPublicMessageSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  797 */     Statement stmt = null;
/*  798 */     ResultSet rs = null;
/*  799 */     MPublicMessageSet aMPublicMessageSet = new MPublicMessageSet();
/*      */ 
/*  801 */     if (!this.mflag) {
/*  802 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  807 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  809 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  810 */       int i = 0;
/*  811 */       while (rs.next())
/*      */       {
/*  813 */         i++;
/*      */ 
/*  815 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  819 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  823 */         MPublicMessageSchema s1 = new MPublicMessageSchema();
/*  824 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  827 */           CError tError = new CError();
/*  828 */           tError.moduleName = "MPublicMessageDB";
/*  829 */           tError.functionName = "executeQuery";
/*  830 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  831 */           this.mErrors.addOneError(tError);
/*      */         }
/*  833 */         aMPublicMessageSet.add(s1);
/*      */       }try {
/*  835 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  841 */       CError tError = new CError();
/*  842 */       tError.moduleName = "MPublicMessageDB";
/*  843 */       tError.functionName = "executeQuery";
/*  844 */       tError.errorMessage = e.toString();
/*  845 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  847 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  850 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  854 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  860 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  864 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  869 */     return aMPublicMessageSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  874 */     Statement stmt = null;
/*      */ 
/*  876 */     if (!this.mflag) {
/*  877 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  882 */       stmt = this.con.createStatement(1003, 1007);
/*  883 */       SQLString sqlObj = new SQLString("MPublicMessage");
/*  884 */       MPublicMessageSchema aSchema = getSchema();
/*  885 */       sqlObj.setSQL(2, aSchema);
/*  886 */       String sql = "update MPublicMessage " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  888 */       int operCount = stmt.executeUpdate(sql);
/*  889 */       if (operCount == 0)
/*      */       {
/*  892 */         CError tError = new CError();
/*  893 */         tError.moduleName = "MPublicMessageDB";
/*  894 */         tError.functionName = "update";
/*  895 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  896 */         this.mErrors.addOneError(tError);
/*      */ 
/*  898 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  902 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  906 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  912 */       CError tError = new CError();
/*  913 */       tError.moduleName = "MPublicMessageDB";
/*  914 */       tError.functionName = "update";
/*  915 */       tError.errorMessage = e.toString();
/*  916 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  918 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  920 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  924 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  928 */       return false;
/*      */     }
/*      */ 
/*  931 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  935 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  940 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  946 */     if (this.mResultSet != null)
/*      */     {
/*  949 */       CError tError = new CError();
/*  950 */       tError.moduleName = "MPublicMessageDB";
/*  951 */       tError.functionName = "prepareData";
/*  952 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  953 */       this.mErrors.addOneError(tError);
/*  954 */       return false;
/*      */     }
/*      */ 
/*  957 */     if (!this.mflag)
/*      */     {
/*  959 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  963 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  964 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  969 */       CError tError = new CError();
/*  970 */       tError.moduleName = "MPublicMessageDB";
/*  971 */       tError.functionName = "prepareData";
/*  972 */       tError.errorMessage = e.toString();
/*  973 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  976 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  982 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  986 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  990 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  995 */       return false;
/*      */     }
/*      */ 
/*  998 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1002 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1007 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1013 */     boolean flag = true;
/* 1014 */     if (this.mResultSet == null)
/*      */     {
/* 1016 */       CError tError = new CError();
/* 1017 */       tError.moduleName = "MPublicMessageDB";
/* 1018 */       tError.functionName = "hasMoreData";
/* 1019 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1020 */       this.mErrors.addOneError(tError);
/* 1021 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1025 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1029 */       CError tError = new CError();
/* 1030 */       tError.moduleName = "MPublicMessageDB";
/* 1031 */       tError.functionName = "hasMoreData";
/* 1032 */       tError.errorMessage = ex.toString();
/* 1033 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1036 */         this.mResultSet.close();
/* 1037 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1043 */         this.mStatement.close();
/* 1044 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1048 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1052 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1057 */       return false;
/*      */     }
/* 1059 */     return flag;
/*      */   }
/*      */ 
/*      */   public MPublicMessageSet getData()
/*      */   {
/* 1064 */     int tCount = 0;
/* 1065 */     MPublicMessageSet tMPublicMessageSet = new MPublicMessageSet();
/* 1066 */     MPublicMessageSchema tMPublicMessageSchema = null;
/* 1067 */     if (this.mResultSet == null)
/*      */     {
/* 1069 */       CError tError = new CError();
/* 1070 */       tError.moduleName = "MPublicMessageDB";
/* 1071 */       tError.functionName = "getData";
/* 1072 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1073 */       this.mErrors.addOneError(tError);
/* 1074 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1078 */       tCount = 1;
/* 1079 */       tMPublicMessageSchema = new MPublicMessageSchema();
/* 1080 */       tMPublicMessageSchema.setSchema(this.mResultSet, 1);
/* 1081 */       tMPublicMessageSet.add(tMPublicMessageSchema);
/*      */ 
/* 1083 */       while (tCount++ < 5000)
/*      */       {
/* 1085 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1087 */         tMPublicMessageSchema = new MPublicMessageSchema();
/* 1088 */         tMPublicMessageSchema.setSchema(this.mResultSet, 1);
/* 1089 */         tMPublicMessageSet.add(tMPublicMessageSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1095 */       CError tError = new CError();
/* 1096 */       tError.moduleName = "MPublicMessageDB";
/* 1097 */       tError.functionName = "getData";
/* 1098 */       tError.errorMessage = ex.toString();
/* 1099 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1102 */         this.mResultSet.close();
/* 1103 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1109 */         this.mStatement.close();
/* 1110 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1114 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1118 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1123 */       return null;
/*      */     }
/* 1125 */     return tMPublicMessageSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1130 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1133 */       if (this.mResultSet == null)
/*      */       {
/* 1135 */         CError tError = new CError();
/* 1136 */         tError.moduleName = "MPublicMessageDB";
/* 1137 */         tError.functionName = "closeData";
/* 1138 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1139 */         this.mErrors.addOneError(tError);
/* 1140 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1144 */         this.mResultSet.close();
/* 1145 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1150 */       CError tError = new CError();
/* 1151 */       tError.moduleName = "MPublicMessageDB";
/* 1152 */       tError.functionName = "closeData";
/* 1153 */       tError.errorMessage = ex2.toString();
/* 1154 */       this.mErrors.addOneError(tError);
/* 1155 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1159 */       if (this.mStatement == null)
/*      */       {
/* 1161 */         CError tError = new CError();
/* 1162 */         tError.moduleName = "MPublicMessageDB";
/* 1163 */         tError.functionName = "closeData";
/* 1164 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1165 */         this.mErrors.addOneError(tError);
/* 1166 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1170 */         this.mStatement.close();
/* 1171 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1176 */       CError tError = new CError();
/* 1177 */       tError.moduleName = "MPublicMessageDB";
/* 1178 */       tError.functionName = "closeData";
/* 1179 */       tError.errorMessage = ex3.toString();
/* 1180 */       this.mErrors.addOneError(tError);
/* 1181 */       flag = false;
/*      */     }
/* 1183 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MPublicMessageDB
 * JD-Core Version:    0.6.0
 */