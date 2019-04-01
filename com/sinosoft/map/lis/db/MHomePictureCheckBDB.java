/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MHomePictureCheckBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MHomePictureCheckBSet;
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
/*      */ public class MHomePictureCheckBDB extends MHomePictureCheckBSchema
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
/*      */   public MHomePictureCheckBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MHomePictureCheckB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MHomePictureCheckB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MHomePictureCheckBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MHomePictureCheckBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MHomePictureCheckBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MHomePictureCheckBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MHomePictureCheckB WHERE  EdorNo = ?");
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
/*  107 */       tError.moduleName = "MHomePictureCheckBDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MHomePictureCheckB SET  ID = ? , URL = ? , RefURL = ? , Name = ? , Alt = ? , PicOrder = ? , DisplayFlag = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/*  145 */       if ((getID() == null) || (getID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getID());
/*      */       }
/*  150 */       if ((getURL() == null) || (getURL().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getURL());
/*      */       }
/*  155 */       if ((getRefURL() == null) || (getRefURL().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getRefURL());
/*      */       }
/*  160 */       if ((getName() == null) || (getName().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getName());
/*      */       }
/*  165 */       if ((getAlt() == null) || (getAlt().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getAlt());
/*      */       }
/*  170 */       pstmt.setInt(6, getPicOrder());
/*  171 */       if ((getDisplayFlag() == null) || (getDisplayFlag().equals("null")))
/*  172 */         pstmt.setNull(7, 12);
/*      */       else {
/*  174 */         pstmt.setString(7, getDisplayFlag());
/*      */       }
/*  176 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  177 */         pstmt.setNull(8, 12);
/*      */       else {
/*  179 */         pstmt.setString(8, getCheckState());
/*      */       }
/*  181 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  182 */         pstmt.setNull(9, 12);
/*      */       else {
/*  184 */         pstmt.setString(9, getCheckOperator());
/*      */       }
/*  186 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  187 */         pstmt.setNull(10, 12);
/*      */       else {
/*  189 */         pstmt.setString(10, getCheckReason());
/*      */       }
/*  191 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  192 */         pstmt.setNull(11, 91);
/*      */       else {
/*  194 */         pstmt.setDate(11, Date.valueOf(getCheckDate()));
/*      */       }
/*  196 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  197 */         pstmt.setNull(12, 12);
/*      */       else {
/*  199 */         pstmt.setString(12, getCheckTime());
/*      */       }
/*  201 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  202 */         pstmt.setNull(13, 12);
/*      */       else {
/*  204 */         pstmt.setString(13, getVF01());
/*      */       }
/*  206 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  207 */         pstmt.setNull(14, 12);
/*      */       else {
/*  209 */         pstmt.setString(14, getNF01());
/*      */       }
/*  211 */       pstmt.setInt(15, getIF01());
/*  212 */       pstmt.setDouble(16, getDF02());
/*  213 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  214 */         pstmt.setNull(17, 91);
/*      */       else {
/*  216 */         pstmt.setDate(17, Date.valueOf(getDate01()));
/*      */       }
/*  218 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  219 */         pstmt.setNull(18, 12);
/*      */       else {
/*  221 */         pstmt.setString(18, getModifyOperator());
/*      */       }
/*  223 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  224 */         pstmt.setNull(19, 12);
/*      */       else {
/*  226 */         pstmt.setString(19, getOperator());
/*      */       }
/*  228 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  229 */         pstmt.setNull(20, 91);
/*      */       else {
/*  231 */         pstmt.setDate(20, Date.valueOf(getMakeDate()));
/*      */       }
/*  233 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  234 */         pstmt.setNull(21, 12);
/*      */       else {
/*  236 */         pstmt.setString(21, getMakeTime());
/*      */       }
/*  238 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  239 */         pstmt.setNull(22, 91);
/*      */       else {
/*  241 */         pstmt.setDate(22, Date.valueOf(getModifyDate()));
/*      */       }
/*  243 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  244 */         pstmt.setNull(23, 12);
/*      */       else {
/*  246 */         pstmt.setString(23, getModifyTime());
/*      */       }
/*  248 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  249 */         pstmt.setNull(24, 12);
/*      */       else {
/*  251 */         pstmt.setString(24, getEdorNo());
/*      */       }
/*  253 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  254 */         pstmt.setNull(25, 12);
/*      */       else {
/*  256 */         pstmt.setString(25, getEdorType());
/*      */       }
/*  258 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  259 */         pstmt.setNull(26, 12);
/*      */       else {
/*  261 */         pstmt.setString(26, getEdorCase());
/*      */       }
/*  263 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  264 */         pstmt.setNull(27, 12);
/*      */       else {
/*  266 */         pstmt.setString(27, getOperator2());
/*      */       }
/*  268 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  269 */         pstmt.setNull(28, 91);
/*      */       else {
/*  271 */         pstmt.setDate(28, Date.valueOf(getMakeDate2()));
/*      */       }
/*  273 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  274 */         pstmt.setNull(29, 12);
/*      */       else {
/*  276 */         pstmt.setString(29, getMakeTime2());
/*      */       }
/*      */ 
/*  279 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  280 */         pstmt.setNull(30, 12);
/*      */       else {
/*  282 */         pstmt.setString(30, getEdorNo());
/*      */       }
/*  284 */       pstmt.executeUpdate();
/*  285 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  288 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  289 */       CError tError = new CError();
/*  290 */       tError.moduleName = "MHomePictureCheckBDB";
/*  291 */       tError.functionName = "update()";
/*  292 */       tError.errorMessage = ex.toString();
/*  293 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  296 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  299 */       if (!this.mflag)
/*      */         try {
/*  301 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  305 */       return false;
/*      */     }
/*      */ 
/*  308 */     if (!this.mflag)
/*      */       try {
/*  310 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  314 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  319 */     PreparedStatement pstmt = null;
/*      */ 
/*  321 */     if (!this.mflag) {
/*  322 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  327 */       pstmt = this.con.prepareStatement("INSERT INTO MHomePictureCheckB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  328 */       if ((getID() == null) || (getID().equals("null")))
/*  329 */         pstmt.setNull(1, 12);
/*      */       else {
/*  331 */         pstmt.setString(1, getID());
/*      */       }
/*  333 */       if ((getURL() == null) || (getURL().equals("null")))
/*  334 */         pstmt.setNull(2, 12);
/*      */       else {
/*  336 */         pstmt.setString(2, getURL());
/*      */       }
/*  338 */       if ((getRefURL() == null) || (getRefURL().equals("null")))
/*  339 */         pstmt.setNull(3, 12);
/*      */       else {
/*  341 */         pstmt.setString(3, getRefURL());
/*      */       }
/*  343 */       if ((getName() == null) || (getName().equals("null")))
/*  344 */         pstmt.setNull(4, 12);
/*      */       else {
/*  346 */         pstmt.setString(4, getName());
/*      */       }
/*  348 */       if ((getAlt() == null) || (getAlt().equals("null")))
/*  349 */         pstmt.setNull(5, 12);
/*      */       else {
/*  351 */         pstmt.setString(5, getAlt());
/*      */       }
/*  353 */       pstmt.setInt(6, getPicOrder());
/*  354 */       if ((getDisplayFlag() == null) || (getDisplayFlag().equals("null")))
/*  355 */         pstmt.setNull(7, 12);
/*      */       else {
/*  357 */         pstmt.setString(7, getDisplayFlag());
/*      */       }
/*  359 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  360 */         pstmt.setNull(8, 12);
/*      */       else {
/*  362 */         pstmt.setString(8, getCheckState());
/*      */       }
/*  364 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  365 */         pstmt.setNull(9, 12);
/*      */       else {
/*  367 */         pstmt.setString(9, getCheckOperator());
/*      */       }
/*  369 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  370 */         pstmt.setNull(10, 12);
/*      */       else {
/*  372 */         pstmt.setString(10, getCheckReason());
/*      */       }
/*  374 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  375 */         pstmt.setNull(11, 91);
/*      */       else {
/*  377 */         pstmt.setDate(11, Date.valueOf(getCheckDate()));
/*      */       }
/*  379 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  380 */         pstmt.setNull(12, 12);
/*      */       else {
/*  382 */         pstmt.setString(12, getCheckTime());
/*      */       }
/*  384 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  385 */         pstmt.setNull(13, 12);
/*      */       else {
/*  387 */         pstmt.setString(13, getVF01());
/*      */       }
/*  389 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  390 */         pstmt.setNull(14, 12);
/*      */       else {
/*  392 */         pstmt.setString(14, getNF01());
/*      */       }
/*  394 */       pstmt.setInt(15, getIF01());
/*  395 */       pstmt.setDouble(16, getDF02());
/*  396 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  397 */         pstmt.setNull(17, 91);
/*      */       else {
/*  399 */         pstmt.setDate(17, Date.valueOf(getDate01()));
/*      */       }
/*  401 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  402 */         pstmt.setNull(18, 12);
/*      */       else {
/*  404 */         pstmt.setString(18, getModifyOperator());
/*      */       }
/*  406 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  407 */         pstmt.setNull(19, 12);
/*      */       else {
/*  409 */         pstmt.setString(19, getOperator());
/*      */       }
/*  411 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  412 */         pstmt.setNull(20, 91);
/*      */       else {
/*  414 */         pstmt.setDate(20, Date.valueOf(getMakeDate()));
/*      */       }
/*  416 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  417 */         pstmt.setNull(21, 12);
/*      */       else {
/*  419 */         pstmt.setString(21, getMakeTime());
/*      */       }
/*  421 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  422 */         pstmt.setNull(22, 91);
/*      */       else {
/*  424 */         pstmt.setDate(22, Date.valueOf(getModifyDate()));
/*      */       }
/*  426 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  427 */         pstmt.setNull(23, 12);
/*      */       else {
/*  429 */         pstmt.setString(23, getModifyTime());
/*      */       }
/*  431 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  432 */         pstmt.setNull(24, 12);
/*      */       else {
/*  434 */         pstmt.setString(24, getEdorNo());
/*      */       }
/*  436 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  437 */         pstmt.setNull(25, 12);
/*      */       else {
/*  439 */         pstmt.setString(25, getEdorType());
/*      */       }
/*  441 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  442 */         pstmt.setNull(26, 12);
/*      */       else {
/*  444 */         pstmt.setString(26, getEdorCase());
/*      */       }
/*  446 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  447 */         pstmt.setNull(27, 12);
/*      */       else {
/*  449 */         pstmt.setString(27, getOperator2());
/*      */       }
/*  451 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  452 */         pstmt.setNull(28, 91);
/*      */       else {
/*  454 */         pstmt.setDate(28, Date.valueOf(getMakeDate2()));
/*      */       }
/*  456 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  457 */         pstmt.setNull(29, 12);
/*      */       else {
/*  459 */         pstmt.setString(29, getMakeTime2());
/*      */       }
/*      */ 
/*  462 */       pstmt.executeUpdate();
/*  463 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  466 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  467 */       CError tError = new CError();
/*  468 */       tError.moduleName = "MHomePictureCheckBDB";
/*  469 */       tError.functionName = "insert()";
/*  470 */       tError.errorMessage = ex.toString();
/*  471 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  474 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  477 */       if (!this.mflag)
/*      */         try {
/*  479 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  483 */       return false;
/*      */     }
/*      */ 
/*  486 */     if (!this.mflag)
/*      */       try {
/*  488 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  492 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  497 */     PreparedStatement pstmt = null;
/*  498 */     ResultSet rs = null;
/*      */ 
/*  500 */     if (!this.mflag) {
/*  501 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  506 */       pstmt = this.con.prepareStatement("SELECT * FROM MHomePictureCheckB WHERE  EdorNo = ?", 
/*  507 */         1003, 1007);
/*  508 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  509 */         pstmt.setNull(1, 12);
/*      */       else {
/*  511 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  513 */       rs = pstmt.executeQuery();
/*  514 */       int i = 0;
/*  515 */       if (rs.next())
/*      */       {
/*  517 */         i++;
/*  518 */         if (!setSchema(rs, i))
/*      */         {
/*  521 */           CError tError = new CError();
/*  522 */           tError.moduleName = "MHomePictureCheckBDB";
/*  523 */           tError.functionName = "getInfo";
/*  524 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  525 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  527 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  530 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  534 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  538 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  542 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  545 */       if (i == 0)
/*      */       {
/*  547 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  551 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  555 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  561 */       CError tError = new CError();
/*  562 */       tError.moduleName = "MHomePictureCheckBDB";
/*  563 */       tError.functionName = "getInfo";
/*  564 */       tError.errorMessage = e.toString();
/*  565 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  567 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  570 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  574 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  578 */       return false;
/*      */     }
/*      */ 
/*  581 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  585 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  590 */     return true;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckBSet query()
/*      */   {
/*  595 */     Statement stmt = null;
/*  596 */     ResultSet rs = null;
/*  597 */     MHomePictureCheckBSet aMHomePictureCheckBSet = new MHomePictureCheckBSet();
/*      */ 
/*  599 */     if (!this.mflag) {
/*  600 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  605 */       stmt = this.con.createStatement(1003, 1007);
/*  606 */       SQLString sqlObj = new SQLString("MHomePictureCheckB");
/*  607 */       MHomePictureCheckBSchema aSchema = getSchema();
/*  608 */       sqlObj.setSQL(5, aSchema);
/*  609 */       String sql = sqlObj.getSQL();
/*      */ 
/*  611 */       rs = stmt.executeQuery(sql);
/*  612 */       int i = 0;
/*  613 */       while (rs.next())
/*      */       {
/*  615 */         i++;
/*  616 */         MHomePictureCheckBSchema s1 = new MHomePictureCheckBSchema();
/*  617 */         s1.setSchema(rs, i);
/*  618 */         aMHomePictureCheckBSet.add(s1);
/*      */       }try {
/*  620 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  626 */       CError tError = new CError();
/*  627 */       tError.moduleName = "MHomePictureCheckBDB";
/*  628 */       tError.functionName = "query";
/*  629 */       tError.errorMessage = e.toString();
/*  630 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  632 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  635 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  639 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  645 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  649 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  654 */     return aMHomePictureCheckBSet;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckBSet executeQuery(String sql)
/*      */   {
/*  659 */     Statement stmt = null;
/*  660 */     ResultSet rs = null;
/*  661 */     MHomePictureCheckBSet aMHomePictureCheckBSet = new MHomePictureCheckBSet();
/*      */ 
/*  663 */     if (!this.mflag) {
/*  664 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  669 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  671 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  672 */       int i = 0;
/*  673 */       while (rs.next())
/*      */       {
/*  675 */         i++;
/*  676 */         MHomePictureCheckBSchema s1 = new MHomePictureCheckBSchema();
/*  677 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  680 */           CError tError = new CError();
/*  681 */           tError.moduleName = "MHomePictureCheckBDB";
/*  682 */           tError.functionName = "executeQuery";
/*  683 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  684 */           this.mErrors.addOneError(tError);
/*      */         }
/*  686 */         aMHomePictureCheckBSet.add(s1);
/*      */       }try {
/*  688 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  694 */       CError tError = new CError();
/*  695 */       tError.moduleName = "MHomePictureCheckBDB";
/*  696 */       tError.functionName = "executeQuery";
/*  697 */       tError.errorMessage = e.toString();
/*  698 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  700 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  703 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  707 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  713 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  717 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  722 */     return aMHomePictureCheckBSet;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckBSet query(int nStart, int nCount)
/*      */   {
/*  727 */     Statement stmt = null;
/*  728 */     ResultSet rs = null;
/*  729 */     MHomePictureCheckBSet aMHomePictureCheckBSet = new MHomePictureCheckBSet();
/*      */ 
/*  731 */     if (!this.mflag) {
/*  732 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  737 */       stmt = this.con.createStatement(1003, 1007);
/*  738 */       SQLString sqlObj = new SQLString("MHomePictureCheckB");
/*  739 */       MHomePictureCheckBSchema aSchema = getSchema();
/*  740 */       sqlObj.setSQL(5, aSchema);
/*  741 */       String sql = sqlObj.getSQL();
/*      */ 
/*  743 */       rs = stmt.executeQuery(sql);
/*  744 */       int i = 0;
/*  745 */       while (rs.next())
/*      */       {
/*  747 */         i++;
/*      */ 
/*  749 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  753 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  757 */         MHomePictureCheckBSchema s1 = new MHomePictureCheckBSchema();
/*  758 */         s1.setSchema(rs, i);
/*  759 */         aMHomePictureCheckBSet.add(s1);
/*      */       }try {
/*  761 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  767 */       CError tError = new CError();
/*  768 */       tError.moduleName = "MHomePictureCheckBDB";
/*  769 */       tError.functionName = "query";
/*  770 */       tError.errorMessage = e.toString();
/*  771 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  773 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  776 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  780 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  786 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  790 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  795 */     return aMHomePictureCheckBSet;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  800 */     Statement stmt = null;
/*  801 */     ResultSet rs = null;
/*  802 */     MHomePictureCheckBSet aMHomePictureCheckBSet = new MHomePictureCheckBSet();
/*      */ 
/*  804 */     if (!this.mflag) {
/*  805 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  810 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  812 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  813 */       int i = 0;
/*  814 */       while (rs.next())
/*      */       {
/*  816 */         i++;
/*      */ 
/*  818 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  822 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  826 */         MHomePictureCheckBSchema s1 = new MHomePictureCheckBSchema();
/*  827 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  830 */           CError tError = new CError();
/*  831 */           tError.moduleName = "MHomePictureCheckBDB";
/*  832 */           tError.functionName = "executeQuery";
/*  833 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  834 */           this.mErrors.addOneError(tError);
/*      */         }
/*  836 */         aMHomePictureCheckBSet.add(s1);
/*      */       }try {
/*  838 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  844 */       CError tError = new CError();
/*  845 */       tError.moduleName = "MHomePictureCheckBDB";
/*  846 */       tError.functionName = "executeQuery";
/*  847 */       tError.errorMessage = e.toString();
/*  848 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  850 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  853 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  857 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  863 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  867 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  872 */     return aMHomePictureCheckBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  877 */     Statement stmt = null;
/*      */ 
/*  879 */     if (!this.mflag) {
/*  880 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  885 */       stmt = this.con.createStatement(1003, 1007);
/*  886 */       SQLString sqlObj = new SQLString("MHomePictureCheckB");
/*  887 */       MHomePictureCheckBSchema aSchema = getSchema();
/*  888 */       sqlObj.setSQL(2, aSchema);
/*  889 */       String sql = "update MHomePictureCheckB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  891 */       int operCount = stmt.executeUpdate(sql);
/*  892 */       if (operCount == 0)
/*      */       {
/*  895 */         CError tError = new CError();
/*  896 */         tError.moduleName = "MHomePictureCheckBDB";
/*  897 */         tError.functionName = "update";
/*  898 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  899 */         this.mErrors.addOneError(tError);
/*      */ 
/*  901 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  905 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  909 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  915 */       CError tError = new CError();
/*  916 */       tError.moduleName = "MHomePictureCheckBDB";
/*  917 */       tError.functionName = "update";
/*  918 */       tError.errorMessage = e.toString();
/*  919 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  921 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  923 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  927 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  931 */       return false;
/*      */     }
/*      */ 
/*  934 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  938 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  943 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  949 */     if (this.mResultSet != null)
/*      */     {
/*  952 */       CError tError = new CError();
/*  953 */       tError.moduleName = "MHomePictureCheckBDB";
/*  954 */       tError.functionName = "prepareData";
/*  955 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  956 */       this.mErrors.addOneError(tError);
/*  957 */       return false;
/*      */     }
/*      */ 
/*  960 */     if (!this.mflag)
/*      */     {
/*  962 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  966 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  967 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  972 */       CError tError = new CError();
/*  973 */       tError.moduleName = "MHomePictureCheckBDB";
/*  974 */       tError.functionName = "prepareData";
/*  975 */       tError.errorMessage = e.toString();
/*  976 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  979 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  985 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  989 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  993 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  998 */       return false;
/*      */     }
/*      */ 
/* 1001 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1005 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1010 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1016 */     boolean flag = true;
/* 1017 */     if (this.mResultSet == null)
/*      */     {
/* 1019 */       CError tError = new CError();
/* 1020 */       tError.moduleName = "MHomePictureCheckBDB";
/* 1021 */       tError.functionName = "hasMoreData";
/* 1022 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1023 */       this.mErrors.addOneError(tError);
/* 1024 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1028 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1032 */       CError tError = new CError();
/* 1033 */       tError.moduleName = "MHomePictureCheckBDB";
/* 1034 */       tError.functionName = "hasMoreData";
/* 1035 */       tError.errorMessage = ex.toString();
/* 1036 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1039 */         this.mResultSet.close();
/* 1040 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1046 */         this.mStatement.close();
/* 1047 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1051 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1055 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1060 */       return false;
/*      */     }
/* 1062 */     return flag;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckBSet getData()
/*      */   {
/* 1067 */     int tCount = 0;
/* 1068 */     MHomePictureCheckBSet tMHomePictureCheckBSet = new MHomePictureCheckBSet();
/* 1069 */     MHomePictureCheckBSchema tMHomePictureCheckBSchema = null;
/* 1070 */     if (this.mResultSet == null)
/*      */     {
/* 1072 */       CError tError = new CError();
/* 1073 */       tError.moduleName = "MHomePictureCheckBDB";
/* 1074 */       tError.functionName = "getData";
/* 1075 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1076 */       this.mErrors.addOneError(tError);
/* 1077 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1081 */       tCount = 1;
/* 1082 */       tMHomePictureCheckBSchema = new MHomePictureCheckBSchema();
/* 1083 */       tMHomePictureCheckBSchema.setSchema(this.mResultSet, 1);
/* 1084 */       tMHomePictureCheckBSet.add(tMHomePictureCheckBSchema);
/*      */ 
/* 1086 */       while (tCount++ < 5000)
/*      */       {
/* 1088 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1090 */         tMHomePictureCheckBSchema = new MHomePictureCheckBSchema();
/* 1091 */         tMHomePictureCheckBSchema.setSchema(this.mResultSet, 1);
/* 1092 */         tMHomePictureCheckBSet.add(tMHomePictureCheckBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1098 */       CError tError = new CError();
/* 1099 */       tError.moduleName = "MHomePictureCheckBDB";
/* 1100 */       tError.functionName = "getData";
/* 1101 */       tError.errorMessage = ex.toString();
/* 1102 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1105 */         this.mResultSet.close();
/* 1106 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1112 */         this.mStatement.close();
/* 1113 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1117 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1121 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1126 */       return null;
/*      */     }
/* 1128 */     return tMHomePictureCheckBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1133 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1136 */       if (this.mResultSet == null)
/*      */       {
/* 1138 */         CError tError = new CError();
/* 1139 */         tError.moduleName = "MHomePictureCheckBDB";
/* 1140 */         tError.functionName = "closeData";
/* 1141 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1142 */         this.mErrors.addOneError(tError);
/* 1143 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1147 */         this.mResultSet.close();
/* 1148 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1153 */       CError tError = new CError();
/* 1154 */       tError.moduleName = "MHomePictureCheckBDB";
/* 1155 */       tError.functionName = "closeData";
/* 1156 */       tError.errorMessage = ex2.toString();
/* 1157 */       this.mErrors.addOneError(tError);
/* 1158 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1162 */       if (this.mStatement == null)
/*      */       {
/* 1164 */         CError tError = new CError();
/* 1165 */         tError.moduleName = "MHomePictureCheckBDB";
/* 1166 */         tError.functionName = "closeData";
/* 1167 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1168 */         this.mErrors.addOneError(tError);
/* 1169 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1173 */         this.mStatement.close();
/* 1174 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1179 */       CError tError = new CError();
/* 1180 */       tError.moduleName = "MHomePictureCheckBDB";
/* 1181 */       tError.functionName = "closeData";
/* 1182 */       tError.errorMessage = ex3.toString();
/* 1183 */       this.mErrors.addOneError(tError);
/* 1184 */       flag = false;
/*      */     }
/* 1186 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MHomePictureCheckBDB
 * JD-Core Version:    0.6.0
 */