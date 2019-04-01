/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPAgentImpQueSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAgentImpQueSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import com.sinosoft.banklns.utility.SQLString;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class LNPAgentImpQueDB extends LNPAgentImpQueSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   22 */   private boolean mflag = false;
/*      */ 
/*   24 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   27 */   private ResultSet mResultSet = null;
/*   28 */   private Statement mStatement = null;
/*      */ 
/*      */   public LNPAgentImpQueDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPAgentImpQue");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpQueDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPAgentImpQue");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPAgentImpQueSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPAgentImpQueDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPAgentImpQueSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPAgentImpQueDB";
/*   76 */       tError.functionName = "getCount";
/*   77 */       tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   78 */       this.mErrors.addOneError(tError);
/*      */ 
/*   80 */       return -1;
/*      */     }
/*      */ 
/*   83 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   88 */     PreparedStatement pstmt = null;
/*      */ 
/*   90 */     if (!this.mflag) {
/*   91 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAgentImpQue WHERE  Questionid = ? AND InnerOrder = ?");
/*   97 */       if ((getQuestionid() == null) || (getQuestionid().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getQuestionid());
/*      */       }
/*  102 */       if ((getInnerOrder() == null) || (getInnerOrder().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getInnerOrder());
/*      */       }
/*  107 */       pstmt.executeUpdate();
/*  108 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  111 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  112 */       CError tError = new CError();
/*  113 */       tError.moduleName = "LNPAgentImpQueDB";
/*  114 */       tError.functionName = "delete()";
/*  115 */       tError.errorMessage = ex.toString();
/*  116 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  119 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  122 */       if (!this.mflag)
/*      */         try {
/*  124 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  128 */       return false;
/*      */     }
/*      */ 
/*  131 */     if (!this.mflag)
/*      */       try {
/*  133 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  137 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  142 */     PreparedStatement pstmt = null;
/*      */ 
/*  144 */     if (!this.mflag) {
/*  145 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  150 */       pstmt = this.con.prepareStatement("UPDATE LNPAgentImpQue SET  ImpartId = ? , Questionid = ? , QuestionType = ? , Content1 = ? , Content2 = ? , QueOrder = ? , InnerOrder = ? , OutQueId = ? , InnerQueNum = ? , ParentId = ? , ChildQueNum = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  Questionid = ? AND InnerOrder = ?");
/*  151 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  152 */         pstmt.setNull(1, 12);
/*      */       else {
/*  154 */         pstmt.setString(1, getImpartId());
/*      */       }
/*  156 */       if ((getQuestionid() == null) || (getQuestionid().equals("null")))
/*  157 */         pstmt.setNull(2, 12);
/*      */       else {
/*  159 */         pstmt.setString(2, getQuestionid());
/*      */       }
/*  161 */       if ((getQuestionType() == null) || (getQuestionType().equals("null")))
/*  162 */         pstmt.setNull(3, 12);
/*      */       else {
/*  164 */         pstmt.setString(3, getQuestionType());
/*      */       }
/*  166 */       if ((getContent1() == null) || (getContent1().equals("null")))
/*  167 */         pstmt.setNull(4, 12);
/*      */       else {
/*  169 */         pstmt.setString(4, getContent1());
/*      */       }
/*  171 */       if ((getContent2() == null) || (getContent2().equals("null")))
/*  172 */         pstmt.setNull(5, 12);
/*      */       else {
/*  174 */         pstmt.setString(5, getContent2());
/*      */       }
/*  176 */       if ((getQueOrder() == null) || (getQueOrder().equals("null")))
/*  177 */         pstmt.setNull(6, 12);
/*      */       else {
/*  179 */         pstmt.setString(6, getQueOrder());
/*      */       }
/*  181 */       if ((getInnerOrder() == null) || (getInnerOrder().equals("null")))
/*  182 */         pstmt.setNull(7, 12);
/*      */       else {
/*  184 */         pstmt.setString(7, getInnerOrder());
/*      */       }
/*  186 */       if ((getOutQueId() == null) || (getOutQueId().equals("null")))
/*  187 */         pstmt.setNull(8, 12);
/*      */       else {
/*  189 */         pstmt.setString(8, getOutQueId());
/*      */       }
/*  191 */       if ((getInnerQueNum() == null) || (getInnerQueNum().equals("null")))
/*  192 */         pstmt.setNull(9, 12);
/*      */       else {
/*  194 */         pstmt.setString(9, getInnerQueNum());
/*      */       }
/*  196 */       if ((getParentId() == null) || (getParentId().equals("null")))
/*  197 */         pstmt.setNull(10, 12);
/*      */       else {
/*  199 */         pstmt.setString(10, getParentId());
/*      */       }
/*  201 */       if ((getChildQueNum() == null) || (getChildQueNum().equals("null")))
/*  202 */         pstmt.setNull(11, 12);
/*      */       else {
/*  204 */         pstmt.setString(11, getChildQueNum());
/*      */       }
/*  206 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  207 */         pstmt.setNull(12, 12);
/*      */       else {
/*  209 */         pstmt.setString(12, getOperator());
/*      */       }
/*  211 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  212 */         pstmt.setNull(13, 12);
/*      */       else {
/*  214 */         pstmt.setString(13, getManageCom());
/*      */       }
/*  216 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  217 */         pstmt.setNull(14, 91);
/*      */       else {
/*  219 */         pstmt.setDate(14, Date.valueOf(getMakeDate()));
/*      */       }
/*  221 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  222 */         pstmt.setNull(15, 12);
/*      */       else {
/*  224 */         pstmt.setString(15, getMakeTime());
/*      */       }
/*  226 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  227 */         pstmt.setNull(16, 91);
/*      */       else {
/*  229 */         pstmt.setDate(16, Date.valueOf(getModifyDate()));
/*      */       }
/*  231 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  232 */         pstmt.setNull(17, 12);
/*      */       else {
/*  234 */         pstmt.setString(17, getModifyTime());
/*      */       }
/*      */ 
/*  237 */       if ((getQuestionid() == null) || (getQuestionid().equals("null")))
/*  238 */         pstmt.setNull(18, 12);
/*      */       else {
/*  240 */         pstmt.setString(18, getQuestionid());
/*      */       }
/*  242 */       if ((getInnerOrder() == null) || (getInnerOrder().equals("null")))
/*  243 */         pstmt.setNull(19, 12);
/*      */       else {
/*  245 */         pstmt.setString(19, getInnerOrder());
/*      */       }
/*  247 */       pstmt.executeUpdate();
/*  248 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  251 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  252 */       CError tError = new CError();
/*  253 */       tError.moduleName = "LNPAgentImpQueDB";
/*  254 */       tError.functionName = "update()";
/*  255 */       tError.errorMessage = ex.toString();
/*  256 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  259 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  262 */       if (!this.mflag)
/*      */         try {
/*  264 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  268 */       return false;
/*      */     }
/*      */ 
/*  271 */     if (!this.mflag)
/*      */       try {
/*  273 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  277 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  282 */     PreparedStatement pstmt = null;
/*      */ 
/*  284 */     if (!this.mflag) {
/*  285 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  290 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAgentImpQue VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  291 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  292 */         pstmt.setNull(1, 12);
/*      */       else {
/*  294 */         pstmt.setString(1, getImpartId());
/*      */       }
/*  296 */       if ((getQuestionid() == null) || (getQuestionid().equals("null")))
/*  297 */         pstmt.setNull(2, 12);
/*      */       else {
/*  299 */         pstmt.setString(2, getQuestionid());
/*      */       }
/*  301 */       if ((getQuestionType() == null) || (getQuestionType().equals("null")))
/*  302 */         pstmt.setNull(3, 12);
/*      */       else {
/*  304 */         pstmt.setString(3, getQuestionType());
/*      */       }
/*  306 */       if ((getContent1() == null) || (getContent1().equals("null")))
/*  307 */         pstmt.setNull(4, 12);
/*      */       else {
/*  309 */         pstmt.setString(4, getContent1());
/*      */       }
/*  311 */       if ((getContent2() == null) || (getContent2().equals("null")))
/*  312 */         pstmt.setNull(5, 12);
/*      */       else {
/*  314 */         pstmt.setString(5, getContent2());
/*      */       }
/*  316 */       if ((getQueOrder() == null) || (getQueOrder().equals("null")))
/*  317 */         pstmt.setNull(6, 12);
/*      */       else {
/*  319 */         pstmt.setString(6, getQueOrder());
/*      */       }
/*  321 */       if ((getInnerOrder() == null) || (getInnerOrder().equals("null")))
/*  322 */         pstmt.setNull(7, 12);
/*      */       else {
/*  324 */         pstmt.setString(7, getInnerOrder());
/*      */       }
/*  326 */       if ((getOutQueId() == null) || (getOutQueId().equals("null")))
/*  327 */         pstmt.setNull(8, 12);
/*      */       else {
/*  329 */         pstmt.setString(8, getOutQueId());
/*      */       }
/*  331 */       if ((getInnerQueNum() == null) || (getInnerQueNum().equals("null")))
/*  332 */         pstmt.setNull(9, 12);
/*      */       else {
/*  334 */         pstmt.setString(9, getInnerQueNum());
/*      */       }
/*  336 */       if ((getParentId() == null) || (getParentId().equals("null")))
/*  337 */         pstmt.setNull(10, 12);
/*      */       else {
/*  339 */         pstmt.setString(10, getParentId());
/*      */       }
/*  341 */       if ((getChildQueNum() == null) || (getChildQueNum().equals("null")))
/*  342 */         pstmt.setNull(11, 12);
/*      */       else {
/*  344 */         pstmt.setString(11, getChildQueNum());
/*      */       }
/*  346 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  347 */         pstmt.setNull(12, 12);
/*      */       else {
/*  349 */         pstmt.setString(12, getOperator());
/*      */       }
/*  351 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  352 */         pstmt.setNull(13, 12);
/*      */       else {
/*  354 */         pstmt.setString(13, getManageCom());
/*      */       }
/*  356 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  357 */         pstmt.setNull(14, 91);
/*      */       else {
/*  359 */         pstmt.setDate(14, Date.valueOf(getMakeDate()));
/*      */       }
/*  361 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  362 */         pstmt.setNull(15, 12);
/*      */       else {
/*  364 */         pstmt.setString(15, getMakeTime());
/*      */       }
/*  366 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  367 */         pstmt.setNull(16, 91);
/*      */       else {
/*  369 */         pstmt.setDate(16, Date.valueOf(getModifyDate()));
/*      */       }
/*  371 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  372 */         pstmt.setNull(17, 12);
/*      */       else {
/*  374 */         pstmt.setString(17, getModifyTime());
/*      */       }
/*      */ 
/*  377 */       pstmt.executeUpdate();
/*  378 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  381 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  382 */       CError tError = new CError();
/*  383 */       tError.moduleName = "LNPAgentImpQueDB";
/*  384 */       tError.functionName = "insert()";
/*  385 */       tError.errorMessage = ex.toString();
/*  386 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  389 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  392 */       if (!this.mflag)
/*      */         try {
/*  394 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  398 */       return false;
/*      */     }
/*      */ 
/*  401 */     if (!this.mflag)
/*      */       try {
/*  403 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  407 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  412 */     PreparedStatement pstmt = null;
/*  413 */     ResultSet rs = null;
/*      */ 
/*  415 */     if (!this.mflag) {
/*  416 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  421 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPAgentImpQue WHERE  Questionid = ? AND InnerOrder = ?", 
/*  422 */         1003, 1007);
/*  423 */       if ((getQuestionid() == null) || (getQuestionid().equals("null")))
/*  424 */         pstmt.setNull(1, 12);
/*      */       else {
/*  426 */         pstmt.setString(1, getQuestionid());
/*      */       }
/*  428 */       if ((getInnerOrder() == null) || (getInnerOrder().equals("null")))
/*  429 */         pstmt.setNull(2, 12);
/*      */       else {
/*  431 */         pstmt.setString(2, getInnerOrder());
/*      */       }
/*  433 */       rs = pstmt.executeQuery();
/*  434 */       int i = 0;
/*  435 */       if (rs.next())
/*      */       {
/*  437 */         i++;
/*  438 */         if (!setSchema(rs, i))
/*      */         {
/*  441 */           CError tError = new CError();
/*  442 */           tError.moduleName = "LNPAgentImpQueDB";
/*  443 */           tError.functionName = "getInfo";
/*  444 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  445 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  447 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  450 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  454 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  458 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  462 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  465 */       if (i == 0)
/*      */       {
/*  467 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  471 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  475 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  481 */       CError tError = new CError();
/*  482 */       tError.moduleName = "LNPAgentImpQueDB";
/*  483 */       tError.functionName = "getInfo";
/*  484 */       tError.errorMessage = e.toString();
/*  485 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  487 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  490 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  494 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  498 */       return false;
/*      */     }
/*      */ 
/*  501 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  505 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  510 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpQueSet query()
/*      */   {
/*  515 */     Statement stmt = null;
/*  516 */     ResultSet rs = null;
/*  517 */     LNPAgentImpQueSet aLNPAgentImpQueSet = new LNPAgentImpQueSet();
/*      */ 
/*  519 */     if (!this.mflag) {
/*  520 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  525 */       stmt = this.con.createStatement(1003, 1007);
/*  526 */       SQLString sqlObj = new SQLString("LNPAgentImpQue");
/*  527 */       LNPAgentImpQueSchema aSchema = getSchema();
/*  528 */       sqlObj.setSQL(5, aSchema);
/*  529 */       String sql = sqlObj.getSQL();
/*      */ 
/*  531 */       rs = stmt.executeQuery(sql);
/*  532 */       int i = 0;
/*  533 */       while (rs.next())
/*      */       {
/*  535 */         i++;
/*  536 */         LNPAgentImpQueSchema s1 = new LNPAgentImpQueSchema();
/*  537 */         s1.setSchema(rs, i);
/*  538 */         aLNPAgentImpQueSet.add(s1);
/*      */       }try {
/*  540 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  546 */       CError tError = new CError();
/*  547 */       tError.moduleName = "LNPAgentImpQueDB";
/*  548 */       tError.functionName = "query";
/*  549 */       tError.errorMessage = e.toString();
/*  550 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  552 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  555 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  559 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  565 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  569 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  574 */     return aLNPAgentImpQueSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpQueSet executeQuery(String sql)
/*      */   {
/*  579 */     Statement stmt = null;
/*  580 */     ResultSet rs = null;
/*  581 */     LNPAgentImpQueSet aLNPAgentImpQueSet = new LNPAgentImpQueSet();
/*      */ 
/*  583 */     if (!this.mflag) {
/*  584 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  589 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  591 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  592 */       int i = 0;
/*  593 */       while (rs.next())
/*      */       {
/*  595 */         i++;
/*  596 */         LNPAgentImpQueSchema s1 = new LNPAgentImpQueSchema();
/*  597 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  600 */           CError tError = new CError();
/*  601 */           tError.moduleName = "LNPAgentImpQueDB";
/*  602 */           tError.functionName = "executeQuery";
/*  603 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  604 */           this.mErrors.addOneError(tError);
/*      */         }
/*  606 */         aLNPAgentImpQueSet.add(s1);
/*      */       }try {
/*  608 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  614 */       CError tError = new CError();
/*  615 */       tError.moduleName = "LNPAgentImpQueDB";
/*  616 */       tError.functionName = "executeQuery";
/*  617 */       tError.errorMessage = e.toString();
/*  618 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  620 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  623 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  627 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  633 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  637 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  642 */     return aLNPAgentImpQueSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpQueSet query(int nStart, int nCount)
/*      */   {
/*  647 */     Statement stmt = null;
/*  648 */     ResultSet rs = null;
/*  649 */     LNPAgentImpQueSet aLNPAgentImpQueSet = new LNPAgentImpQueSet();
/*      */ 
/*  651 */     if (!this.mflag) {
/*  652 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  657 */       stmt = this.con.createStatement(1003, 1007);
/*  658 */       SQLString sqlObj = new SQLString("LNPAgentImpQue");
/*  659 */       LNPAgentImpQueSchema aSchema = getSchema();
/*  660 */       sqlObj.setSQL(5, aSchema);
/*  661 */       String sql = sqlObj.getSQL();
/*      */ 
/*  663 */       rs = stmt.executeQuery(sql);
/*  664 */       int i = 0;
/*  665 */       while (rs.next())
/*      */       {
/*  667 */         i++;
/*      */ 
/*  669 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  673 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  677 */         LNPAgentImpQueSchema s1 = new LNPAgentImpQueSchema();
/*  678 */         s1.setSchema(rs, i);
/*  679 */         aLNPAgentImpQueSet.add(s1);
/*      */       }try {
/*  681 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  687 */       CError tError = new CError();
/*  688 */       tError.moduleName = "LNPAgentImpQueDB";
/*  689 */       tError.functionName = "query";
/*  690 */       tError.errorMessage = e.toString();
/*  691 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  693 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  696 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  700 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  706 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  710 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  715 */     return aLNPAgentImpQueSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpQueSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  720 */     Statement stmt = null;
/*  721 */     ResultSet rs = null;
/*  722 */     LNPAgentImpQueSet aLNPAgentImpQueSet = new LNPAgentImpQueSet();
/*      */ 
/*  724 */     if (!this.mflag) {
/*  725 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  730 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  732 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  733 */       int i = 0;
/*  734 */       while (rs.next())
/*      */       {
/*  736 */         i++;
/*      */ 
/*  738 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  742 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  746 */         LNPAgentImpQueSchema s1 = new LNPAgentImpQueSchema();
/*  747 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  750 */           CError tError = new CError();
/*  751 */           tError.moduleName = "LNPAgentImpQueDB";
/*  752 */           tError.functionName = "executeQuery";
/*  753 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  754 */           this.mErrors.addOneError(tError);
/*      */         }
/*  756 */         aLNPAgentImpQueSet.add(s1);
/*      */       }try {
/*  758 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  764 */       CError tError = new CError();
/*  765 */       tError.moduleName = "LNPAgentImpQueDB";
/*  766 */       tError.functionName = "executeQuery";
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
/*  792 */     return aLNPAgentImpQueSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  797 */     Statement stmt = null;
/*      */ 
/*  799 */     if (!this.mflag) {
/*  800 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  805 */       stmt = this.con.createStatement(1003, 1007);
/*  806 */       SQLString sqlObj = new SQLString("LNPAgentImpQue");
/*  807 */       LNPAgentImpQueSchema aSchema = getSchema();
/*  808 */       sqlObj.setSQL(2, aSchema);
/*  809 */       String sql = "update LNPAgentImpQue " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  811 */       int operCount = stmt.executeUpdate(sql);
/*  812 */       if (operCount == 0)
/*      */       {
/*  815 */         CError tError = new CError();
/*  816 */         tError.moduleName = "LNPAgentImpQueDB";
/*  817 */         tError.functionName = "update";
/*  818 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  819 */         this.mErrors.addOneError(tError);
/*      */ 
/*  821 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  825 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  829 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  835 */       CError tError = new CError();
/*  836 */       tError.moduleName = "LNPAgentImpQueDB";
/*  837 */       tError.functionName = "update";
/*  838 */       tError.errorMessage = e.toString();
/*  839 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  841 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  843 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  847 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  851 */       return false;
/*      */     }
/*      */ 
/*  854 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  858 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  863 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  869 */     if (this.mResultSet != null)
/*      */     {
/*  872 */       CError tError = new CError();
/*  873 */       tError.moduleName = "LNPAgentImpQueDB";
/*  874 */       tError.functionName = "prepareData";
/*  875 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  876 */       this.mErrors.addOneError(tError);
/*  877 */       return false;
/*      */     }
/*      */ 
/*  880 */     if (!this.mflag)
/*      */     {
/*  882 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  886 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  887 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  892 */       CError tError = new CError();
/*  893 */       tError.moduleName = "LNPAgentImpQueDB";
/*  894 */       tError.functionName = "prepareData";
/*  895 */       tError.errorMessage = e.toString();
/*  896 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  899 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  905 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  909 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  913 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  918 */       return false;
/*      */     }
/*      */ 
/*  921 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  925 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  930 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  936 */     boolean flag = true;
/*  937 */     if (this.mResultSet == null)
/*      */     {
/*  939 */       CError tError = new CError();
/*  940 */       tError.moduleName = "LNPAgentImpQueDB";
/*  941 */       tError.functionName = "hasMoreData";
/*  942 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  943 */       this.mErrors.addOneError(tError);
/*  944 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  948 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  952 */       CError tError = new CError();
/*  953 */       tError.moduleName = "LNPAgentImpQueDB";
/*  954 */       tError.functionName = "hasMoreData";
/*  955 */       tError.errorMessage = ex.toString();
/*  956 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  959 */         this.mResultSet.close();
/*  960 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  966 */         this.mStatement.close();
/*  967 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  971 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  975 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  980 */       return false;
/*      */     }
/*  982 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpQueSet getData()
/*      */   {
/*  987 */     int tCount = 0;
/*  988 */     LNPAgentImpQueSet tLNPAgentImpQueSet = new LNPAgentImpQueSet();
/*  989 */     LNPAgentImpQueSchema tLNPAgentImpQueSchema = null;
/*  990 */     if (this.mResultSet == null)
/*      */     {
/*  992 */       CError tError = new CError();
/*  993 */       tError.moduleName = "LNPAgentImpQueDB";
/*  994 */       tError.functionName = "getData";
/*  995 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  996 */       this.mErrors.addOneError(tError);
/*  997 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1001 */       tCount = 1;
/* 1002 */       tLNPAgentImpQueSchema = new LNPAgentImpQueSchema();
/* 1003 */       tLNPAgentImpQueSchema.setSchema(this.mResultSet, 1);
/* 1004 */       tLNPAgentImpQueSet.add(tLNPAgentImpQueSchema);
/*      */ 
/* 1006 */       while (tCount++ < 5000)
/*      */       {
/* 1008 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1010 */         tLNPAgentImpQueSchema = new LNPAgentImpQueSchema();
/* 1011 */         tLNPAgentImpQueSchema.setSchema(this.mResultSet, 1);
/* 1012 */         tLNPAgentImpQueSet.add(tLNPAgentImpQueSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1018 */       CError tError = new CError();
/* 1019 */       tError.moduleName = "LNPAgentImpQueDB";
/* 1020 */       tError.functionName = "getData";
/* 1021 */       tError.errorMessage = ex.toString();
/* 1022 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1025 */         this.mResultSet.close();
/* 1026 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1032 */         this.mStatement.close();
/* 1033 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1037 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1041 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1046 */       return null;
/*      */     }
/* 1048 */     return tLNPAgentImpQueSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1053 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1056 */       if (this.mResultSet == null)
/*      */       {
/* 1058 */         CError tError = new CError();
/* 1059 */         tError.moduleName = "LNPAgentImpQueDB";
/* 1060 */         tError.functionName = "closeData";
/* 1061 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1062 */         this.mErrors.addOneError(tError);
/* 1063 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1067 */         this.mResultSet.close();
/* 1068 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1073 */       CError tError = new CError();
/* 1074 */       tError.moduleName = "LNPAgentImpQueDB";
/* 1075 */       tError.functionName = "closeData";
/* 1076 */       tError.errorMessage = ex2.toString();
/* 1077 */       this.mErrors.addOneError(tError);
/* 1078 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1082 */       if (this.mStatement == null)
/*      */       {
/* 1084 */         CError tError = new CError();
/* 1085 */         tError.moduleName = "LNPAgentImpQueDB";
/* 1086 */         tError.functionName = "closeData";
/* 1087 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1088 */         this.mErrors.addOneError(tError);
/* 1089 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1093 */         this.mStatement.close();
/* 1094 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1099 */       CError tError = new CError();
/* 1100 */       tError.moduleName = "LNPAgentImpQueDB";
/* 1101 */       tError.functionName = "closeData";
/* 1102 */       tError.errorMessage = ex3.toString();
/* 1103 */       this.mErrors.addOneError(tError);
/* 1104 */       flag = false;
/*      */     }
/* 1106 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPAgentImpQueDB
 * JD-Core Version:    0.6.0
 */