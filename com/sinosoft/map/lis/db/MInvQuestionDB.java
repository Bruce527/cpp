/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MInvQuestionSchema;
/*      */ import com.sinosoft.map.lis.vschema.MInvQuestionSet;
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
/*      */ public class MInvQuestionDB extends MInvQuestionSchema
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
/*      */   public MInvQuestionDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MInvQuestion");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MInvQuestionDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MInvQuestion");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MInvQuestionSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MInvQuestionDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MInvQuestionSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MInvQuestionDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MInvQuestion WHERE  QuestionID = ?");
/*   96 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getQuestionID());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MInvQuestionDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MInvQuestion SET  QuestionID = ? , TopicID = ? , Question = ? , Depiction = ? , QuestionType = ? , QuestionOrder = ? , ParentID = ? , State = ? , ChildFlag = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  QuestionID = ?");
/*  145 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getQuestionID());
/*      */       }
/*  150 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getTopicID());
/*      */       }
/*  155 */       if ((getQuestion() == null) || (getQuestion().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getQuestion());
/*      */       }
/*  160 */       if ((getDepiction() == null) || (getDepiction().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getDepiction());
/*      */       }
/*  165 */       if ((getQuestionType() == null) || (getQuestionType().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getQuestionType());
/*      */       }
/*  170 */       pstmt.setInt(6, getQuestionOrder());
/*  171 */       if ((getParentID() == null) || (getParentID().equals("null")))
/*  172 */         pstmt.setNull(7, 12);
/*      */       else {
/*  174 */         pstmt.setString(7, getParentID());
/*      */       }
/*  176 */       if ((getState() == null) || (getState().equals("null")))
/*  177 */         pstmt.setNull(8, 12);
/*      */       else {
/*  179 */         pstmt.setString(8, getState());
/*      */       }
/*  181 */       if ((getChildFlag() == null) || (getChildFlag().equals("null")))
/*  182 */         pstmt.setNull(9, 12);
/*      */       else {
/*  184 */         pstmt.setString(9, getChildFlag());
/*      */       }
/*  186 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  187 */         pstmt.setNull(10, 12);
/*      */       else {
/*  189 */         pstmt.setString(10, getVF01());
/*      */       }
/*  191 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  192 */         pstmt.setNull(11, 12);
/*      */       else {
/*  194 */         pstmt.setString(11, getNF01());
/*      */       }
/*  196 */       pstmt.setInt(12, getIF01());
/*  197 */       pstmt.setDouble(13, getDF02());
/*  198 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  199 */         pstmt.setNull(14, 91);
/*      */       else {
/*  201 */         pstmt.setDate(14, Date.valueOf(getDate01()));
/*      */       }
/*  203 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  204 */         pstmt.setNull(15, 12);
/*      */       else {
/*  206 */         pstmt.setString(15, getModifyOperator());
/*      */       }
/*  208 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  209 */         pstmt.setNull(16, 12);
/*      */       else {
/*  211 */         pstmt.setString(16, getOperator());
/*      */       }
/*  213 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  214 */         pstmt.setNull(17, 91);
/*      */       else {
/*  216 */         pstmt.setDate(17, Date.valueOf(getMakeDate()));
/*      */       }
/*  218 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  219 */         pstmt.setNull(18, 12);
/*      */       else {
/*  221 */         pstmt.setString(18, getMakeTime());
/*      */       }
/*  223 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  224 */         pstmt.setNull(19, 91);
/*      */       else {
/*  226 */         pstmt.setDate(19, Date.valueOf(getModifyDate()));
/*      */       }
/*  228 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  229 */         pstmt.setNull(20, 12);
/*      */       else {
/*  231 */         pstmt.setString(20, getModifyTime());
/*      */       }
/*      */ 
/*  234 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  235 */         pstmt.setNull(21, 12);
/*      */       else {
/*  237 */         pstmt.setString(21, getQuestionID());
/*      */       }
/*  239 */       pstmt.executeUpdate();
/*  240 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  243 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  244 */       CError tError = new CError();
/*  245 */       tError.moduleName = "MInvQuestionDB";
/*  246 */       tError.functionName = "update()";
/*  247 */       tError.errorMessage = ex.toString();
/*  248 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  251 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  254 */       if (!this.mflag)
/*      */         try {
/*  256 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  260 */       return false;
/*      */     }
/*      */ 
/*  263 */     if (!this.mflag)
/*      */       try {
/*  265 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  269 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  274 */     PreparedStatement pstmt = null;
/*      */ 
/*  276 */     if (!this.mflag) {
/*  277 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  282 */       pstmt = this.con.prepareStatement("INSERT INTO MInvQuestion VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  283 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  284 */         pstmt.setNull(1, 12);
/*      */       else {
/*  286 */         pstmt.setString(1, getQuestionID());
/*      */       }
/*  288 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  289 */         pstmt.setNull(2, 12);
/*      */       else {
/*  291 */         pstmt.setString(2, getTopicID());
/*      */       }
/*  293 */       if ((getQuestion() == null) || (getQuestion().equals("null")))
/*  294 */         pstmt.setNull(3, 12);
/*      */       else {
/*  296 */         pstmt.setString(3, getQuestion());
/*      */       }
/*  298 */       if ((getDepiction() == null) || (getDepiction().equals("null")))
/*  299 */         pstmt.setNull(4, 12);
/*      */       else {
/*  301 */         pstmt.setString(4, getDepiction());
/*      */       }
/*  303 */       if ((getQuestionType() == null) || (getQuestionType().equals("null")))
/*  304 */         pstmt.setNull(5, 12);
/*      */       else {
/*  306 */         pstmt.setString(5, getQuestionType());
/*      */       }
/*  308 */       pstmt.setInt(6, getQuestionOrder());
/*  309 */       if ((getParentID() == null) || (getParentID().equals("null")))
/*  310 */         pstmt.setNull(7, 12);
/*      */       else {
/*  312 */         pstmt.setString(7, getParentID());
/*      */       }
/*  314 */       if ((getState() == null) || (getState().equals("null")))
/*  315 */         pstmt.setNull(8, 12);
/*      */       else {
/*  317 */         pstmt.setString(8, getState());
/*      */       }
/*  319 */       if ((getChildFlag() == null) || (getChildFlag().equals("null")))
/*  320 */         pstmt.setNull(9, 12);
/*      */       else {
/*  322 */         pstmt.setString(9, getChildFlag());
/*      */       }
/*  324 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  325 */         pstmt.setNull(10, 12);
/*      */       else {
/*  327 */         pstmt.setString(10, getVF01());
/*      */       }
/*  329 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  330 */         pstmt.setNull(11, 12);
/*      */       else {
/*  332 */         pstmt.setString(11, getNF01());
/*      */       }
/*  334 */       pstmt.setInt(12, getIF01());
/*  335 */       pstmt.setDouble(13, getDF02());
/*  336 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  337 */         pstmt.setNull(14, 91);
/*      */       else {
/*  339 */         pstmt.setDate(14, Date.valueOf(getDate01()));
/*      */       }
/*  341 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  342 */         pstmt.setNull(15, 12);
/*      */       else {
/*  344 */         pstmt.setString(15, getModifyOperator());
/*      */       }
/*  346 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  347 */         pstmt.setNull(16, 12);
/*      */       else {
/*  349 */         pstmt.setString(16, getOperator());
/*      */       }
/*  351 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  352 */         pstmt.setNull(17, 91);
/*      */       else {
/*  354 */         pstmt.setDate(17, Date.valueOf(getMakeDate()));
/*      */       }
/*  356 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  357 */         pstmt.setNull(18, 12);
/*      */       else {
/*  359 */         pstmt.setString(18, getMakeTime());
/*      */       }
/*  361 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  362 */         pstmt.setNull(19, 91);
/*      */       else {
/*  364 */         pstmt.setDate(19, Date.valueOf(getModifyDate()));
/*      */       }
/*  366 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  367 */         pstmt.setNull(20, 12);
/*      */       else {
/*  369 */         pstmt.setString(20, getModifyTime());
/*      */       }
/*      */ 
/*  372 */       pstmt.executeUpdate();
/*  373 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  376 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  377 */       CError tError = new CError();
/*  378 */       tError.moduleName = "MInvQuestionDB";
/*  379 */       tError.functionName = "insert()";
/*  380 */       tError.errorMessage = ex.toString();
/*  381 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  384 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  387 */       if (!this.mflag)
/*      */         try {
/*  389 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  393 */       return false;
/*      */     }
/*      */ 
/*  396 */     if (!this.mflag)
/*      */       try {
/*  398 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  402 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  407 */     PreparedStatement pstmt = null;
/*  408 */     ResultSet rs = null;
/*      */ 
/*  410 */     if (!this.mflag) {
/*  411 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  416 */       pstmt = this.con.prepareStatement("SELECT * FROM MInvQuestion WHERE  QuestionID = ?", 
/*  417 */         1003, 1007);
/*  418 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  419 */         pstmt.setNull(1, 12);
/*      */       else {
/*  421 */         pstmt.setString(1, getQuestionID());
/*      */       }
/*  423 */       rs = pstmt.executeQuery();
/*  424 */       int i = 0;
/*  425 */       if (rs.next())
/*      */       {
/*  427 */         i++;
/*  428 */         if (!setSchema(rs, i))
/*      */         {
/*  431 */           CError tError = new CError();
/*  432 */           tError.moduleName = "MInvQuestionDB";
/*  433 */           tError.functionName = "getInfo";
/*  434 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  435 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  437 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  440 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  444 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  448 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  452 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  455 */       if (i == 0)
/*      */       {
/*  457 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  461 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  465 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  471 */       CError tError = new CError();
/*  472 */       tError.moduleName = "MInvQuestionDB";
/*  473 */       tError.functionName = "getInfo";
/*  474 */       tError.errorMessage = e.toString();
/*  475 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  477 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  480 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  484 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  488 */       return false;
/*      */     }
/*      */ 
/*  491 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  495 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  500 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvQuestionSet query()
/*      */   {
/*  505 */     Statement stmt = null;
/*  506 */     ResultSet rs = null;
/*  507 */     MInvQuestionSet aMInvQuestionSet = new MInvQuestionSet();
/*      */ 
/*  509 */     if (!this.mflag) {
/*  510 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  515 */       stmt = this.con.createStatement(1003, 1007);
/*  516 */       SQLString sqlObj = new SQLString("MInvQuestion");
/*  517 */       MInvQuestionSchema aSchema = getSchema();
/*  518 */       sqlObj.setSQL(5, aSchema);
/*  519 */       String sql = sqlObj.getSQL();
/*      */ 
/*  521 */       rs = stmt.executeQuery(sql);
/*  522 */       int i = 0;
/*  523 */       while (rs.next())
/*      */       {
/*  525 */         i++;
/*  526 */         MInvQuestionSchema s1 = new MInvQuestionSchema();
/*  527 */         s1.setSchema(rs, i);
/*  528 */         aMInvQuestionSet.add(s1);
/*      */       }try {
/*  530 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  536 */       CError tError = new CError();
/*  537 */       tError.moduleName = "MInvQuestionDB";
/*  538 */       tError.functionName = "query";
/*  539 */       tError.errorMessage = e.toString();
/*  540 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  542 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  545 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  549 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  555 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  559 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  564 */     return aMInvQuestionSet;
/*      */   }
/*      */ 
/*      */   public MInvQuestionSet executeQuery(String sql)
/*      */   {
/*  569 */     Statement stmt = null;
/*  570 */     ResultSet rs = null;
/*  571 */     MInvQuestionSet aMInvQuestionSet = new MInvQuestionSet();
/*      */ 
/*  573 */     if (!this.mflag) {
/*  574 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  579 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  581 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  582 */       int i = 0;
/*  583 */       while (rs.next())
/*      */       {
/*  585 */         i++;
/*  586 */         MInvQuestionSchema s1 = new MInvQuestionSchema();
/*  587 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  590 */           CError tError = new CError();
/*  591 */           tError.moduleName = "MInvQuestionDB";
/*  592 */           tError.functionName = "executeQuery";
/*  593 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  594 */           this.mErrors.addOneError(tError);
/*      */         }
/*  596 */         aMInvQuestionSet.add(s1);
/*      */       }try {
/*  598 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  604 */       CError tError = new CError();
/*  605 */       tError.moduleName = "MInvQuestionDB";
/*  606 */       tError.functionName = "executeQuery";
/*  607 */       tError.errorMessage = e.toString();
/*  608 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  610 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  613 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  617 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  623 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  627 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  632 */     return aMInvQuestionSet;
/*      */   }
/*      */ 
/*      */   public MInvQuestionSet query(int nStart, int nCount)
/*      */   {
/*  637 */     Statement stmt = null;
/*  638 */     ResultSet rs = null;
/*  639 */     MInvQuestionSet aMInvQuestionSet = new MInvQuestionSet();
/*      */ 
/*  641 */     if (!this.mflag) {
/*  642 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  647 */       stmt = this.con.createStatement(1003, 1007);
/*  648 */       SQLString sqlObj = new SQLString("MInvQuestion");
/*  649 */       MInvQuestionSchema aSchema = getSchema();
/*  650 */       sqlObj.setSQL(5, aSchema);
/*  651 */       String sql = sqlObj.getSQL();
/*      */ 
/*  653 */       rs = stmt.executeQuery(sql);
/*  654 */       int i = 0;
/*  655 */       while (rs.next())
/*      */       {
/*  657 */         i++;
/*      */ 
/*  659 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  663 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  667 */         MInvQuestionSchema s1 = new MInvQuestionSchema();
/*  668 */         s1.setSchema(rs, i);
/*  669 */         aMInvQuestionSet.add(s1);
/*      */       }try {
/*  671 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  677 */       CError tError = new CError();
/*  678 */       tError.moduleName = "MInvQuestionDB";
/*  679 */       tError.functionName = "query";
/*  680 */       tError.errorMessage = e.toString();
/*  681 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  683 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  686 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  690 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  696 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  700 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  705 */     return aMInvQuestionSet;
/*      */   }
/*      */ 
/*      */   public MInvQuestionSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  710 */     Statement stmt = null;
/*  711 */     ResultSet rs = null;
/*  712 */     MInvQuestionSet aMInvQuestionSet = new MInvQuestionSet();
/*      */ 
/*  714 */     if (!this.mflag) {
/*  715 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  720 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  722 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  723 */       int i = 0;
/*  724 */       while (rs.next())
/*      */       {
/*  726 */         i++;
/*      */ 
/*  728 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  732 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  736 */         MInvQuestionSchema s1 = new MInvQuestionSchema();
/*  737 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  740 */           CError tError = new CError();
/*  741 */           tError.moduleName = "MInvQuestionDB";
/*  742 */           tError.functionName = "executeQuery";
/*  743 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  744 */           this.mErrors.addOneError(tError);
/*      */         }
/*  746 */         aMInvQuestionSet.add(s1);
/*      */       }try {
/*  748 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  754 */       CError tError = new CError();
/*  755 */       tError.moduleName = "MInvQuestionDB";
/*  756 */       tError.functionName = "executeQuery";
/*  757 */       tError.errorMessage = e.toString();
/*  758 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  760 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  763 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  767 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  773 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  777 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  782 */     return aMInvQuestionSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  787 */     Statement stmt = null;
/*      */ 
/*  789 */     if (!this.mflag) {
/*  790 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  795 */       stmt = this.con.createStatement(1003, 1007);
/*  796 */       SQLString sqlObj = new SQLString("MInvQuestion");
/*  797 */       MInvQuestionSchema aSchema = getSchema();
/*  798 */       sqlObj.setSQL(2, aSchema);
/*  799 */       String sql = "update MInvQuestion " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  801 */       int operCount = stmt.executeUpdate(sql);
/*  802 */       if (operCount == 0)
/*      */       {
/*  805 */         CError tError = new CError();
/*  806 */         tError.moduleName = "MInvQuestionDB";
/*  807 */         tError.functionName = "update";
/*  808 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  809 */         this.mErrors.addOneError(tError);
/*      */ 
/*  811 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  815 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  819 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  825 */       CError tError = new CError();
/*  826 */       tError.moduleName = "MInvQuestionDB";
/*  827 */       tError.functionName = "update";
/*  828 */       tError.errorMessage = e.toString();
/*  829 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  831 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  833 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  837 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  841 */       return false;
/*      */     }
/*      */ 
/*  844 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  848 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  853 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  859 */     if (this.mResultSet != null)
/*      */     {
/*  862 */       CError tError = new CError();
/*  863 */       tError.moduleName = "MInvQuestionDB";
/*  864 */       tError.functionName = "prepareData";
/*  865 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  866 */       this.mErrors.addOneError(tError);
/*  867 */       return false;
/*      */     }
/*      */ 
/*  870 */     if (!this.mflag)
/*      */     {
/*  872 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  876 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  877 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  882 */       CError tError = new CError();
/*  883 */       tError.moduleName = "MInvQuestionDB";
/*  884 */       tError.functionName = "prepareData";
/*  885 */       tError.errorMessage = e.toString();
/*  886 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  889 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  895 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  899 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  903 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  908 */       return false;
/*      */     }
/*      */ 
/*  911 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  915 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  920 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  926 */     boolean flag = true;
/*  927 */     if (this.mResultSet == null)
/*      */     {
/*  929 */       CError tError = new CError();
/*  930 */       tError.moduleName = "MInvQuestionDB";
/*  931 */       tError.functionName = "hasMoreData";
/*  932 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  933 */       this.mErrors.addOneError(tError);
/*  934 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  938 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  942 */       CError tError = new CError();
/*  943 */       tError.moduleName = "MInvQuestionDB";
/*  944 */       tError.functionName = "hasMoreData";
/*  945 */       tError.errorMessage = ex.toString();
/*  946 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  949 */         this.mResultSet.close();
/*  950 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  956 */         this.mStatement.close();
/*  957 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  961 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  965 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  970 */       return false;
/*      */     }
/*  972 */     return flag;
/*      */   }
/*      */ 
/*      */   public MInvQuestionSet getData()
/*      */   {
/*  977 */     int tCount = 0;
/*  978 */     MInvQuestionSet tMInvQuestionSet = new MInvQuestionSet();
/*  979 */     MInvQuestionSchema tMInvQuestionSchema = null;
/*  980 */     if (this.mResultSet == null)
/*      */     {
/*  982 */       CError tError = new CError();
/*  983 */       tError.moduleName = "MInvQuestionDB";
/*  984 */       tError.functionName = "getData";
/*  985 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  986 */       this.mErrors.addOneError(tError);
/*  987 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  991 */       tCount = 1;
/*  992 */       tMInvQuestionSchema = new MInvQuestionSchema();
/*  993 */       tMInvQuestionSchema.setSchema(this.mResultSet, 1);
/*  994 */       tMInvQuestionSet.add(tMInvQuestionSchema);
/*      */ 
/*  996 */       while (tCount++ < 5000)
/*      */       {
/*  998 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1000 */         tMInvQuestionSchema = new MInvQuestionSchema();
/* 1001 */         tMInvQuestionSchema.setSchema(this.mResultSet, 1);
/* 1002 */         tMInvQuestionSet.add(tMInvQuestionSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1008 */       CError tError = new CError();
/* 1009 */       tError.moduleName = "MInvQuestionDB";
/* 1010 */       tError.functionName = "getData";
/* 1011 */       tError.errorMessage = ex.toString();
/* 1012 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1015 */         this.mResultSet.close();
/* 1016 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1022 */         this.mStatement.close();
/* 1023 */         this.mStatement = null;
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
/* 1036 */       return null;
/*      */     }
/* 1038 */     return tMInvQuestionSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1043 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1046 */       if (this.mResultSet == null)
/*      */       {
/* 1048 */         CError tError = new CError();
/* 1049 */         tError.moduleName = "MInvQuestionDB";
/* 1050 */         tError.functionName = "closeData";
/* 1051 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1052 */         this.mErrors.addOneError(tError);
/* 1053 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1057 */         this.mResultSet.close();
/* 1058 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1063 */       CError tError = new CError();
/* 1064 */       tError.moduleName = "MInvQuestionDB";
/* 1065 */       tError.functionName = "closeData";
/* 1066 */       tError.errorMessage = ex2.toString();
/* 1067 */       this.mErrors.addOneError(tError);
/* 1068 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1072 */       if (this.mStatement == null)
/*      */       {
/* 1074 */         CError tError = new CError();
/* 1075 */         tError.moduleName = "MInvQuestionDB";
/* 1076 */         tError.functionName = "closeData";
/* 1077 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1078 */         this.mErrors.addOneError(tError);
/* 1079 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1083 */         this.mStatement.close();
/* 1084 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1089 */       CError tError = new CError();
/* 1090 */       tError.moduleName = "MInvQuestionDB";
/* 1091 */       tError.functionName = "closeData";
/* 1092 */       tError.errorMessage = ex3.toString();
/* 1093 */       this.mErrors.addOneError(tError);
/* 1094 */       flag = false;
/*      */     }
/* 1096 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MInvQuestionDB
 * JD-Core Version:    0.6.0
 */