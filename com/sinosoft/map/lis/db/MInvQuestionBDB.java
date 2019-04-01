/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MInvQuestionBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MInvQuestionBSet;
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
/*      */ public class MInvQuestionBDB extends MInvQuestionBSchema
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
/*      */   public MInvQuestionBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MInvQuestionB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MInvQuestionBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MInvQuestionB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MInvQuestionBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MInvQuestionBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MInvQuestionBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MInvQuestionBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MInvQuestionB WHERE  EdorNo = ?");
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
/*  107 */       tError.moduleName = "MInvQuestionBDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MInvQuestionB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , QuestionID = ? , TopicID = ? , Question = ? , Depiction = ? , QuestionType = ? , QuestionOrder = ? , ParentID = ? , State = ? , ChildFlag = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  EdorNo = ?");
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
/*  175 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getQuestionID());
/*      */       }
/*  180 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getTopicID());
/*      */       }
/*  185 */       if ((getQuestion() == null) || (getQuestion().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getQuestion());
/*      */       }
/*  190 */       if ((getDepiction() == null) || (getDepiction().equals("null")))
/*  191 */         pstmt.setNull(10, 12);
/*      */       else {
/*  193 */         pstmt.setString(10, getDepiction());
/*      */       }
/*  195 */       if ((getQuestionType() == null) || (getQuestionType().equals("null")))
/*  196 */         pstmt.setNull(11, 12);
/*      */       else {
/*  198 */         pstmt.setString(11, getQuestionType());
/*      */       }
/*  200 */       pstmt.setInt(12, getQuestionOrder());
/*  201 */       if ((getParentID() == null) || (getParentID().equals("null")))
/*  202 */         pstmt.setNull(13, 12);
/*      */       else {
/*  204 */         pstmt.setString(13, getParentID());
/*      */       }
/*  206 */       if ((getState() == null) || (getState().equals("null")))
/*  207 */         pstmt.setNull(14, 12);
/*      */       else {
/*  209 */         pstmt.setString(14, getState());
/*      */       }
/*  211 */       if ((getChildFlag() == null) || (getChildFlag().equals("null")))
/*  212 */         pstmt.setNull(15, 12);
/*      */       else {
/*  214 */         pstmt.setString(15, getChildFlag());
/*      */       }
/*  216 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  217 */         pstmt.setNull(16, 12);
/*      */       else {
/*  219 */         pstmt.setString(16, getVF01());
/*      */       }
/*  221 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  222 */         pstmt.setNull(17, 12);
/*      */       else {
/*  224 */         pstmt.setString(17, getNF01());
/*      */       }
/*  226 */       pstmt.setInt(18, getIF01());
/*  227 */       pstmt.setDouble(19, getDF02());
/*  228 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  229 */         pstmt.setNull(20, 91);
/*      */       else {
/*  231 */         pstmt.setDate(20, Date.valueOf(getDate01()));
/*      */       }
/*  233 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  234 */         pstmt.setNull(21, 12);
/*      */       else {
/*  236 */         pstmt.setString(21, getModifyOperator());
/*      */       }
/*  238 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  239 */         pstmt.setNull(22, 12);
/*      */       else {
/*  241 */         pstmt.setString(22, getOperator());
/*      */       }
/*  243 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  244 */         pstmt.setNull(23, 91);
/*      */       else {
/*  246 */         pstmt.setDate(23, Date.valueOf(getMakeDate()));
/*      */       }
/*  248 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  249 */         pstmt.setNull(24, 12);
/*      */       else {
/*  251 */         pstmt.setString(24, getMakeTime());
/*      */       }
/*  253 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  254 */         pstmt.setNull(25, 91);
/*      */       else {
/*  256 */         pstmt.setDate(25, Date.valueOf(getModifyDate()));
/*      */       }
/*  258 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  259 */         pstmt.setNull(26, 12);
/*      */       else {
/*  261 */         pstmt.setString(26, getModifyTime());
/*      */       }
/*      */ 
/*  264 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  265 */         pstmt.setNull(27, 12);
/*      */       else {
/*  267 */         pstmt.setString(27, getEdorNo());
/*      */       }
/*  269 */       pstmt.executeUpdate();
/*  270 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  273 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  274 */       CError tError = new CError();
/*  275 */       tError.moduleName = "MInvQuestionBDB";
/*  276 */       tError.functionName = "update()";
/*  277 */       tError.errorMessage = ex.toString();
/*  278 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  281 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  284 */       if (!this.mflag)
/*      */         try {
/*  286 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  290 */       return false;
/*      */     }
/*      */ 
/*  293 */     if (!this.mflag)
/*      */       try {
/*  295 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  299 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  304 */     PreparedStatement pstmt = null;
/*      */ 
/*  306 */     if (!this.mflag) {
/*  307 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  312 */       pstmt = this.con.prepareStatement("INSERT INTO MInvQuestionB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  313 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  314 */         pstmt.setNull(1, 12);
/*      */       else {
/*  316 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  318 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  319 */         pstmt.setNull(2, 12);
/*      */       else {
/*  321 */         pstmt.setString(2, getEdorType());
/*      */       }
/*  323 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  324 */         pstmt.setNull(3, 12);
/*      */       else {
/*  326 */         pstmt.setString(3, getEdorCase());
/*      */       }
/*  328 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  329 */         pstmt.setNull(4, 12);
/*      */       else {
/*  331 */         pstmt.setString(4, getOperator2());
/*      */       }
/*  333 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  334 */         pstmt.setNull(5, 91);
/*      */       else {
/*  336 */         pstmt.setDate(5, Date.valueOf(getMakeDate2()));
/*      */       }
/*  338 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  339 */         pstmt.setNull(6, 12);
/*      */       else {
/*  341 */         pstmt.setString(6, getMakeTime2());
/*      */       }
/*  343 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  344 */         pstmt.setNull(7, 12);
/*      */       else {
/*  346 */         pstmt.setString(7, getQuestionID());
/*      */       }
/*  348 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  349 */         pstmt.setNull(8, 12);
/*      */       else {
/*  351 */         pstmt.setString(8, getTopicID());
/*      */       }
/*  353 */       if ((getQuestion() == null) || (getQuestion().equals("null")))
/*  354 */         pstmt.setNull(9, 12);
/*      */       else {
/*  356 */         pstmt.setString(9, getQuestion());
/*      */       }
/*  358 */       if ((getDepiction() == null) || (getDepiction().equals("null")))
/*  359 */         pstmt.setNull(10, 12);
/*      */       else {
/*  361 */         pstmt.setString(10, getDepiction());
/*      */       }
/*  363 */       if ((getQuestionType() == null) || (getQuestionType().equals("null")))
/*  364 */         pstmt.setNull(11, 12);
/*      */       else {
/*  366 */         pstmt.setString(11, getQuestionType());
/*      */       }
/*  368 */       pstmt.setInt(12, getQuestionOrder());
/*  369 */       if ((getParentID() == null) || (getParentID().equals("null")))
/*  370 */         pstmt.setNull(13, 12);
/*      */       else {
/*  372 */         pstmt.setString(13, getParentID());
/*      */       }
/*  374 */       if ((getState() == null) || (getState().equals("null")))
/*  375 */         pstmt.setNull(14, 12);
/*      */       else {
/*  377 */         pstmt.setString(14, getState());
/*      */       }
/*  379 */       if ((getChildFlag() == null) || (getChildFlag().equals("null")))
/*  380 */         pstmt.setNull(15, 12);
/*      */       else {
/*  382 */         pstmt.setString(15, getChildFlag());
/*      */       }
/*  384 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  385 */         pstmt.setNull(16, 12);
/*      */       else {
/*  387 */         pstmt.setString(16, getVF01());
/*      */       }
/*  389 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  390 */         pstmt.setNull(17, 12);
/*      */       else {
/*  392 */         pstmt.setString(17, getNF01());
/*      */       }
/*  394 */       pstmt.setInt(18, getIF01());
/*  395 */       pstmt.setDouble(19, getDF02());
/*  396 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  397 */         pstmt.setNull(20, 91);
/*      */       else {
/*  399 */         pstmt.setDate(20, Date.valueOf(getDate01()));
/*      */       }
/*  401 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  402 */         pstmt.setNull(21, 12);
/*      */       else {
/*  404 */         pstmt.setString(21, getModifyOperator());
/*      */       }
/*  406 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  407 */         pstmt.setNull(22, 12);
/*      */       else {
/*  409 */         pstmt.setString(22, getOperator());
/*      */       }
/*  411 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  412 */         pstmt.setNull(23, 91);
/*      */       else {
/*  414 */         pstmt.setDate(23, Date.valueOf(getMakeDate()));
/*      */       }
/*  416 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  417 */         pstmt.setNull(24, 12);
/*      */       else {
/*  419 */         pstmt.setString(24, getMakeTime());
/*      */       }
/*  421 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  422 */         pstmt.setNull(25, 91);
/*      */       else {
/*  424 */         pstmt.setDate(25, Date.valueOf(getModifyDate()));
/*      */       }
/*  426 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  427 */         pstmt.setNull(26, 12);
/*      */       else {
/*  429 */         pstmt.setString(26, getModifyTime());
/*      */       }
/*      */ 
/*  432 */       pstmt.executeUpdate();
/*  433 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  436 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  437 */       CError tError = new CError();
/*  438 */       tError.moduleName = "MInvQuestionBDB";
/*  439 */       tError.functionName = "insert()";
/*  440 */       tError.errorMessage = ex.toString();
/*  441 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  444 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  447 */       if (!this.mflag)
/*      */         try {
/*  449 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  453 */       return false;
/*      */     }
/*      */ 
/*  456 */     if (!this.mflag)
/*      */       try {
/*  458 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  462 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  467 */     PreparedStatement pstmt = null;
/*  468 */     ResultSet rs = null;
/*      */ 
/*  470 */     if (!this.mflag) {
/*  471 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  476 */       pstmt = this.con.prepareStatement("SELECT * FROM MInvQuestionB WHERE  EdorNo = ?", 
/*  477 */         1003, 1007);
/*  478 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  479 */         pstmt.setNull(1, 12);
/*      */       else {
/*  481 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  483 */       rs = pstmt.executeQuery();
/*  484 */       int i = 0;
/*  485 */       if (rs.next())
/*      */       {
/*  487 */         i++;
/*  488 */         if (!setSchema(rs, i))
/*      */         {
/*  491 */           CError tError = new CError();
/*  492 */           tError.moduleName = "MInvQuestionBDB";
/*  493 */           tError.functionName = "getInfo";
/*  494 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  495 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  497 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  500 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  504 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  508 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  512 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  515 */       if (i == 0)
/*      */       {
/*  517 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  521 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  525 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  531 */       CError tError = new CError();
/*  532 */       tError.moduleName = "MInvQuestionBDB";
/*  533 */       tError.functionName = "getInfo";
/*  534 */       tError.errorMessage = e.toString();
/*  535 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  537 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  540 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  544 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  548 */       return false;
/*      */     }
/*      */ 
/*  551 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  555 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  560 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvQuestionBSet query()
/*      */   {
/*  565 */     Statement stmt = null;
/*  566 */     ResultSet rs = null;
/*  567 */     MInvQuestionBSet aMInvQuestionBSet = new MInvQuestionBSet();
/*      */ 
/*  569 */     if (!this.mflag) {
/*  570 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  575 */       stmt = this.con.createStatement(1003, 1007);
/*  576 */       SQLString sqlObj = new SQLString("MInvQuestionB");
/*  577 */       MInvQuestionBSchema aSchema = getSchema();
/*  578 */       sqlObj.setSQL(5, aSchema);
/*  579 */       String sql = sqlObj.getSQL();
/*      */ 
/*  581 */       rs = stmt.executeQuery(sql);
/*  582 */       int i = 0;
/*  583 */       while (rs.next())
/*      */       {
/*  585 */         i++;
/*  586 */         MInvQuestionBSchema s1 = new MInvQuestionBSchema();
/*  587 */         s1.setSchema(rs, i);
/*  588 */         aMInvQuestionBSet.add(s1);
/*      */       }try {
/*  590 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  596 */       CError tError = new CError();
/*  597 */       tError.moduleName = "MInvQuestionBDB";
/*  598 */       tError.functionName = "query";
/*  599 */       tError.errorMessage = e.toString();
/*  600 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  602 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  605 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  609 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  615 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  619 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  624 */     return aMInvQuestionBSet;
/*      */   }
/*      */ 
/*      */   public MInvQuestionBSet executeQuery(String sql)
/*      */   {
/*  629 */     Statement stmt = null;
/*  630 */     ResultSet rs = null;
/*  631 */     MInvQuestionBSet aMInvQuestionBSet = new MInvQuestionBSet();
/*      */ 
/*  633 */     if (!this.mflag) {
/*  634 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  639 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  641 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  642 */       int i = 0;
/*  643 */       while (rs.next())
/*      */       {
/*  645 */         i++;
/*  646 */         MInvQuestionBSchema s1 = new MInvQuestionBSchema();
/*  647 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  650 */           CError tError = new CError();
/*  651 */           tError.moduleName = "MInvQuestionBDB";
/*  652 */           tError.functionName = "executeQuery";
/*  653 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  654 */           this.mErrors.addOneError(tError);
/*      */         }
/*  656 */         aMInvQuestionBSet.add(s1);
/*      */       }try {
/*  658 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  664 */       CError tError = new CError();
/*  665 */       tError.moduleName = "MInvQuestionBDB";
/*  666 */       tError.functionName = "executeQuery";
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
/*  692 */     return aMInvQuestionBSet;
/*      */   }
/*      */ 
/*      */   public MInvQuestionBSet query(int nStart, int nCount)
/*      */   {
/*  697 */     Statement stmt = null;
/*  698 */     ResultSet rs = null;
/*  699 */     MInvQuestionBSet aMInvQuestionBSet = new MInvQuestionBSet();
/*      */ 
/*  701 */     if (!this.mflag) {
/*  702 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  707 */       stmt = this.con.createStatement(1003, 1007);
/*  708 */       SQLString sqlObj = new SQLString("MInvQuestionB");
/*  709 */       MInvQuestionBSchema aSchema = getSchema();
/*  710 */       sqlObj.setSQL(5, aSchema);
/*  711 */       String sql = sqlObj.getSQL();
/*      */ 
/*  713 */       rs = stmt.executeQuery(sql);
/*  714 */       int i = 0;
/*  715 */       while (rs.next())
/*      */       {
/*  717 */         i++;
/*      */ 
/*  719 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  723 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  727 */         MInvQuestionBSchema s1 = new MInvQuestionBSchema();
/*  728 */         s1.setSchema(rs, i);
/*  729 */         aMInvQuestionBSet.add(s1);
/*      */       }try {
/*  731 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  737 */       CError tError = new CError();
/*  738 */       tError.moduleName = "MInvQuestionBDB";
/*  739 */       tError.functionName = "query";
/*  740 */       tError.errorMessage = e.toString();
/*  741 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  743 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  746 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  750 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  756 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  760 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  765 */     return aMInvQuestionBSet;
/*      */   }
/*      */ 
/*      */   public MInvQuestionBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  770 */     Statement stmt = null;
/*  771 */     ResultSet rs = null;
/*  772 */     MInvQuestionBSet aMInvQuestionBSet = new MInvQuestionBSet();
/*      */ 
/*  774 */     if (!this.mflag) {
/*  775 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  780 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  782 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  783 */       int i = 0;
/*  784 */       while (rs.next())
/*      */       {
/*  786 */         i++;
/*      */ 
/*  788 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  792 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  796 */         MInvQuestionBSchema s1 = new MInvQuestionBSchema();
/*  797 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  800 */           CError tError = new CError();
/*  801 */           tError.moduleName = "MInvQuestionBDB";
/*  802 */           tError.functionName = "executeQuery";
/*  803 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  804 */           this.mErrors.addOneError(tError);
/*      */         }
/*  806 */         aMInvQuestionBSet.add(s1);
/*      */       }try {
/*  808 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  814 */       CError tError = new CError();
/*  815 */       tError.moduleName = "MInvQuestionBDB";
/*  816 */       tError.functionName = "executeQuery";
/*  817 */       tError.errorMessage = e.toString();
/*  818 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  820 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  823 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  827 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  833 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  837 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  842 */     return aMInvQuestionBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  847 */     Statement stmt = null;
/*      */ 
/*  849 */     if (!this.mflag) {
/*  850 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  855 */       stmt = this.con.createStatement(1003, 1007);
/*  856 */       SQLString sqlObj = new SQLString("MInvQuestionB");
/*  857 */       MInvQuestionBSchema aSchema = getSchema();
/*  858 */       sqlObj.setSQL(2, aSchema);
/*  859 */       String sql = "update MInvQuestionB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  861 */       int operCount = stmt.executeUpdate(sql);
/*  862 */       if (operCount == 0)
/*      */       {
/*  865 */         CError tError = new CError();
/*  866 */         tError.moduleName = "MInvQuestionBDB";
/*  867 */         tError.functionName = "update";
/*  868 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  869 */         this.mErrors.addOneError(tError);
/*      */ 
/*  871 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  875 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  879 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  885 */       CError tError = new CError();
/*  886 */       tError.moduleName = "MInvQuestionBDB";
/*  887 */       tError.functionName = "update";
/*  888 */       tError.errorMessage = e.toString();
/*  889 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  891 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  893 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  897 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  901 */       return false;
/*      */     }
/*      */ 
/*  904 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  908 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  913 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  919 */     if (this.mResultSet != null)
/*      */     {
/*  922 */       CError tError = new CError();
/*  923 */       tError.moduleName = "MInvQuestionBDB";
/*  924 */       tError.functionName = "prepareData";
/*  925 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  926 */       this.mErrors.addOneError(tError);
/*  927 */       return false;
/*      */     }
/*      */ 
/*  930 */     if (!this.mflag)
/*      */     {
/*  932 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  936 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  937 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  942 */       CError tError = new CError();
/*  943 */       tError.moduleName = "MInvQuestionBDB";
/*  944 */       tError.functionName = "prepareData";
/*  945 */       tError.errorMessage = e.toString();
/*  946 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  949 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  955 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  959 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  963 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  968 */       return false;
/*      */     }
/*      */ 
/*  971 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  975 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  980 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  986 */     boolean flag = true;
/*  987 */     if (this.mResultSet == null)
/*      */     {
/*  989 */       CError tError = new CError();
/*  990 */       tError.moduleName = "MInvQuestionBDB";
/*  991 */       tError.functionName = "hasMoreData";
/*  992 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  993 */       this.mErrors.addOneError(tError);
/*  994 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  998 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1002 */       CError tError = new CError();
/* 1003 */       tError.moduleName = "MInvQuestionBDB";
/* 1004 */       tError.functionName = "hasMoreData";
/* 1005 */       tError.errorMessage = ex.toString();
/* 1006 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1009 */         this.mResultSet.close();
/* 1010 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1016 */         this.mStatement.close();
/* 1017 */         this.mStatement = null;
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
/* 1032 */     return flag;
/*      */   }
/*      */ 
/*      */   public MInvQuestionBSet getData()
/*      */   {
/* 1037 */     int tCount = 0;
/* 1038 */     MInvQuestionBSet tMInvQuestionBSet = new MInvQuestionBSet();
/* 1039 */     MInvQuestionBSchema tMInvQuestionBSchema = null;
/* 1040 */     if (this.mResultSet == null)
/*      */     {
/* 1042 */       CError tError = new CError();
/* 1043 */       tError.moduleName = "MInvQuestionBDB";
/* 1044 */       tError.functionName = "getData";
/* 1045 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1046 */       this.mErrors.addOneError(tError);
/* 1047 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1051 */       tCount = 1;
/* 1052 */       tMInvQuestionBSchema = new MInvQuestionBSchema();
/* 1053 */       tMInvQuestionBSchema.setSchema(this.mResultSet, 1);
/* 1054 */       tMInvQuestionBSet.add(tMInvQuestionBSchema);
/*      */ 
/* 1056 */       while (tCount++ < 5000)
/*      */       {
/* 1058 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1060 */         tMInvQuestionBSchema = new MInvQuestionBSchema();
/* 1061 */         tMInvQuestionBSchema.setSchema(this.mResultSet, 1);
/* 1062 */         tMInvQuestionBSet.add(tMInvQuestionBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1068 */       CError tError = new CError();
/* 1069 */       tError.moduleName = "MInvQuestionBDB";
/* 1070 */       tError.functionName = "getData";
/* 1071 */       tError.errorMessage = ex.toString();
/* 1072 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1075 */         this.mResultSet.close();
/* 1076 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1082 */         this.mStatement.close();
/* 1083 */         this.mStatement = null;
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
/* 1096 */       return null;
/*      */     }
/* 1098 */     return tMInvQuestionBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1103 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1106 */       if (this.mResultSet == null)
/*      */       {
/* 1108 */         CError tError = new CError();
/* 1109 */         tError.moduleName = "MInvQuestionBDB";
/* 1110 */         tError.functionName = "closeData";
/* 1111 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1112 */         this.mErrors.addOneError(tError);
/* 1113 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1117 */         this.mResultSet.close();
/* 1118 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1123 */       CError tError = new CError();
/* 1124 */       tError.moduleName = "MInvQuestionBDB";
/* 1125 */       tError.functionName = "closeData";
/* 1126 */       tError.errorMessage = ex2.toString();
/* 1127 */       this.mErrors.addOneError(tError);
/* 1128 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1132 */       if (this.mStatement == null)
/*      */       {
/* 1134 */         CError tError = new CError();
/* 1135 */         tError.moduleName = "MInvQuestionBDB";
/* 1136 */         tError.functionName = "closeData";
/* 1137 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1138 */         this.mErrors.addOneError(tError);
/* 1139 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1143 */         this.mStatement.close();
/* 1144 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1149 */       CError tError = new CError();
/* 1150 */       tError.moduleName = "MInvQuestionBDB";
/* 1151 */       tError.functionName = "closeData";
/* 1152 */       tError.errorMessage = ex3.toString();
/* 1153 */       this.mErrors.addOneError(tError);
/* 1154 */       flag = false;
/*      */     }
/* 1156 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MInvQuestionBDB
 * JD-Core Version:    0.6.0
 */