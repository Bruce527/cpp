/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MInvResultBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MInvResultBSet;
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
/*      */ public class MInvResultBDB extends MInvResultBSchema
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
/*      */   public MInvResultBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MInvResultB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MInvResultBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MInvResultB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MInvResultBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MInvResultBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MInvResultBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MInvResultBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MInvResultB WHERE  EdorNo = ?");
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
/*  107 */       tError.moduleName = "MInvResultBDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MInvResultB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , ResultID = ? , TopicID = ? , QuestionID = ? , OptionID = ? , OtherAnswer = ? , AgentCode = ? , ManageCom = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  EdorNo = ?");
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
/*  175 */       if ((getResultID() == null) || (getResultID().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getResultID());
/*      */       }
/*  180 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getTopicID());
/*      */       }
/*  185 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getQuestionID());
/*      */       }
/*  190 */       if ((getOptionID() == null) || (getOptionID().equals("null")))
/*  191 */         pstmt.setNull(10, 12);
/*      */       else {
/*  193 */         pstmt.setString(10, getOptionID());
/*      */       }
/*  195 */       if ((getOtherAnswer() == null) || (getOtherAnswer().equals("null")))
/*  196 */         pstmt.setNull(11, 12);
/*      */       else {
/*  198 */         pstmt.setString(11, getOtherAnswer());
/*      */       }
/*  200 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  201 */         pstmt.setNull(12, 12);
/*      */       else {
/*  203 */         pstmt.setString(12, getAgentCode());
/*      */       }
/*  205 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  206 */         pstmt.setNull(13, 12);
/*      */       else {
/*  208 */         pstmt.setString(13, getManageCom());
/*      */       }
/*  210 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  211 */         pstmt.setNull(14, 12);
/*      */       else {
/*  213 */         pstmt.setString(14, getVF01());
/*      */       }
/*  215 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  216 */         pstmt.setNull(15, 12);
/*      */       else {
/*  218 */         pstmt.setString(15, getNF01());
/*      */       }
/*  220 */       pstmt.setInt(16, getIF01());
/*  221 */       pstmt.setDouble(17, getDF02());
/*  222 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  223 */         pstmt.setNull(18, 91);
/*      */       else {
/*  225 */         pstmt.setDate(18, Date.valueOf(getDate01()));
/*      */       }
/*  227 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  228 */         pstmt.setNull(19, 12);
/*      */       else {
/*  230 */         pstmt.setString(19, getModifyOperator());
/*      */       }
/*  232 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  233 */         pstmt.setNull(20, 12);
/*      */       else {
/*  235 */         pstmt.setString(20, getOperator());
/*      */       }
/*  237 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  238 */         pstmt.setNull(21, 91);
/*      */       else {
/*  240 */         pstmt.setDate(21, Date.valueOf(getMakeDate()));
/*      */       }
/*  242 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  243 */         pstmt.setNull(22, 12);
/*      */       else {
/*  245 */         pstmt.setString(22, getMakeTime());
/*      */       }
/*  247 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  248 */         pstmt.setNull(23, 91);
/*      */       else {
/*  250 */         pstmt.setDate(23, Date.valueOf(getModifyDate()));
/*      */       }
/*  252 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  253 */         pstmt.setNull(24, 12);
/*      */       else {
/*  255 */         pstmt.setString(24, getModifyTime());
/*      */       }
/*      */ 
/*  258 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  259 */         pstmt.setNull(25, 12);
/*      */       else {
/*  261 */         pstmt.setString(25, getEdorNo());
/*      */       }
/*  263 */       pstmt.executeUpdate();
/*  264 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  267 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  268 */       CError tError = new CError();
/*  269 */       tError.moduleName = "MInvResultBDB";
/*  270 */       tError.functionName = "update()";
/*  271 */       tError.errorMessage = ex.toString();
/*  272 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  275 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  278 */       if (!this.mflag)
/*      */         try {
/*  280 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  284 */       return false;
/*      */     }
/*      */ 
/*  287 */     if (!this.mflag)
/*      */       try {
/*  289 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  293 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  298 */     PreparedStatement pstmt = null;
/*      */ 
/*  300 */     if (!this.mflag) {
/*  301 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  306 */       pstmt = this.con.prepareStatement("INSERT INTO MInvResultB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  307 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  308 */         pstmt.setNull(1, 12);
/*      */       else {
/*  310 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  312 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  313 */         pstmt.setNull(2, 12);
/*      */       else {
/*  315 */         pstmt.setString(2, getEdorType());
/*      */       }
/*  317 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  318 */         pstmt.setNull(3, 12);
/*      */       else {
/*  320 */         pstmt.setString(3, getEdorCase());
/*      */       }
/*  322 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  323 */         pstmt.setNull(4, 12);
/*      */       else {
/*  325 */         pstmt.setString(4, getOperator2());
/*      */       }
/*  327 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  328 */         pstmt.setNull(5, 91);
/*      */       else {
/*  330 */         pstmt.setDate(5, Date.valueOf(getMakeDate2()));
/*      */       }
/*  332 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  333 */         pstmt.setNull(6, 12);
/*      */       else {
/*  335 */         pstmt.setString(6, getMakeTime2());
/*      */       }
/*  337 */       if ((getResultID() == null) || (getResultID().equals("null")))
/*  338 */         pstmt.setNull(7, 12);
/*      */       else {
/*  340 */         pstmt.setString(7, getResultID());
/*      */       }
/*  342 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  343 */         pstmt.setNull(8, 12);
/*      */       else {
/*  345 */         pstmt.setString(8, getTopicID());
/*      */       }
/*  347 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  348 */         pstmt.setNull(9, 12);
/*      */       else {
/*  350 */         pstmt.setString(9, getQuestionID());
/*      */       }
/*  352 */       if ((getOptionID() == null) || (getOptionID().equals("null")))
/*  353 */         pstmt.setNull(10, 12);
/*      */       else {
/*  355 */         pstmt.setString(10, getOptionID());
/*      */       }
/*  357 */       if ((getOtherAnswer() == null) || (getOtherAnswer().equals("null")))
/*  358 */         pstmt.setNull(11, 12);
/*      */       else {
/*  360 */         pstmt.setString(11, getOtherAnswer());
/*      */       }
/*  362 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  363 */         pstmt.setNull(12, 12);
/*      */       else {
/*  365 */         pstmt.setString(12, getAgentCode());
/*      */       }
/*  367 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  368 */         pstmt.setNull(13, 12);
/*      */       else {
/*  370 */         pstmt.setString(13, getManageCom());
/*      */       }
/*  372 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  373 */         pstmt.setNull(14, 12);
/*      */       else {
/*  375 */         pstmt.setString(14, getVF01());
/*      */       }
/*  377 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  378 */         pstmt.setNull(15, 12);
/*      */       else {
/*  380 */         pstmt.setString(15, getNF01());
/*      */       }
/*  382 */       pstmt.setInt(16, getIF01());
/*  383 */       pstmt.setDouble(17, getDF02());
/*  384 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  385 */         pstmt.setNull(18, 91);
/*      */       else {
/*  387 */         pstmt.setDate(18, Date.valueOf(getDate01()));
/*      */       }
/*  389 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  390 */         pstmt.setNull(19, 12);
/*      */       else {
/*  392 */         pstmt.setString(19, getModifyOperator());
/*      */       }
/*  394 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  395 */         pstmt.setNull(20, 12);
/*      */       else {
/*  397 */         pstmt.setString(20, getOperator());
/*      */       }
/*  399 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  400 */         pstmt.setNull(21, 91);
/*      */       else {
/*  402 */         pstmt.setDate(21, Date.valueOf(getMakeDate()));
/*      */       }
/*  404 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  405 */         pstmt.setNull(22, 12);
/*      */       else {
/*  407 */         pstmt.setString(22, getMakeTime());
/*      */       }
/*  409 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  410 */         pstmt.setNull(23, 91);
/*      */       else {
/*  412 */         pstmt.setDate(23, Date.valueOf(getModifyDate()));
/*      */       }
/*  414 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  415 */         pstmt.setNull(24, 12);
/*      */       else {
/*  417 */         pstmt.setString(24, getModifyTime());
/*      */       }
/*      */ 
/*  420 */       pstmt.executeUpdate();
/*  421 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  424 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  425 */       CError tError = new CError();
/*  426 */       tError.moduleName = "MInvResultBDB";
/*  427 */       tError.functionName = "insert()";
/*  428 */       tError.errorMessage = ex.toString();
/*  429 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  432 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  435 */       if (!this.mflag)
/*      */         try {
/*  437 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  441 */       return false;
/*      */     }
/*      */ 
/*  444 */     if (!this.mflag)
/*      */       try {
/*  446 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  450 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  455 */     PreparedStatement pstmt = null;
/*  456 */     ResultSet rs = null;
/*      */ 
/*  458 */     if (!this.mflag) {
/*  459 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  464 */       pstmt = this.con.prepareStatement("SELECT * FROM MInvResultB WHERE  EdorNo = ?", 
/*  465 */         1003, 1007);
/*  466 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  467 */         pstmt.setNull(1, 12);
/*      */       else {
/*  469 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  471 */       rs = pstmt.executeQuery();
/*  472 */       int i = 0;
/*  473 */       if (rs.next())
/*      */       {
/*  475 */         i++;
/*  476 */         if (!setSchema(rs, i))
/*      */         {
/*  479 */           CError tError = new CError();
/*  480 */           tError.moduleName = "MInvResultBDB";
/*  481 */           tError.functionName = "getInfo";
/*  482 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  483 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  485 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  488 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  492 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  496 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  500 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  503 */       if (i == 0)
/*      */       {
/*  505 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  509 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  513 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  519 */       CError tError = new CError();
/*  520 */       tError.moduleName = "MInvResultBDB";
/*  521 */       tError.functionName = "getInfo";
/*  522 */       tError.errorMessage = e.toString();
/*  523 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  525 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  528 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  532 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  536 */       return false;
/*      */     }
/*      */ 
/*  539 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  543 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  548 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvResultBSet query()
/*      */   {
/*  553 */     Statement stmt = null;
/*  554 */     ResultSet rs = null;
/*  555 */     MInvResultBSet aMInvResultBSet = new MInvResultBSet();
/*      */ 
/*  557 */     if (!this.mflag) {
/*  558 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  563 */       stmt = this.con.createStatement(1003, 1007);
/*  564 */       SQLString sqlObj = new SQLString("MInvResultB");
/*  565 */       MInvResultBSchema aSchema = getSchema();
/*  566 */       sqlObj.setSQL(5, aSchema);
/*  567 */       String sql = sqlObj.getSQL();
/*      */ 
/*  569 */       rs = stmt.executeQuery(sql);
/*  570 */       int i = 0;
/*  571 */       while (rs.next())
/*      */       {
/*  573 */         i++;
/*  574 */         MInvResultBSchema s1 = new MInvResultBSchema();
/*  575 */         s1.setSchema(rs, i);
/*  576 */         aMInvResultBSet.add(s1);
/*      */       }try {
/*  578 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  584 */       CError tError = new CError();
/*  585 */       tError.moduleName = "MInvResultBDB";
/*  586 */       tError.functionName = "query";
/*  587 */       tError.errorMessage = e.toString();
/*  588 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  590 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  593 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  597 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  603 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  607 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  612 */     return aMInvResultBSet;
/*      */   }
/*      */ 
/*      */   public MInvResultBSet executeQuery(String sql)
/*      */   {
/*  617 */     Statement stmt = null;
/*  618 */     ResultSet rs = null;
/*  619 */     MInvResultBSet aMInvResultBSet = new MInvResultBSet();
/*      */ 
/*  621 */     if (!this.mflag) {
/*  622 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  627 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  629 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  630 */       int i = 0;
/*  631 */       while (rs.next())
/*      */       {
/*  633 */         i++;
/*  634 */         MInvResultBSchema s1 = new MInvResultBSchema();
/*  635 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  638 */           CError tError = new CError();
/*  639 */           tError.moduleName = "MInvResultBDB";
/*  640 */           tError.functionName = "executeQuery";
/*  641 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  642 */           this.mErrors.addOneError(tError);
/*      */         }
/*  644 */         aMInvResultBSet.add(s1);
/*      */       }try {
/*  646 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  652 */       CError tError = new CError();
/*  653 */       tError.moduleName = "MInvResultBDB";
/*  654 */       tError.functionName = "executeQuery";
/*  655 */       tError.errorMessage = e.toString();
/*  656 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  658 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  661 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  665 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  671 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  675 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  680 */     return aMInvResultBSet;
/*      */   }
/*      */ 
/*      */   public MInvResultBSet query(int nStart, int nCount)
/*      */   {
/*  685 */     Statement stmt = null;
/*  686 */     ResultSet rs = null;
/*  687 */     MInvResultBSet aMInvResultBSet = new MInvResultBSet();
/*      */ 
/*  689 */     if (!this.mflag) {
/*  690 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  695 */       stmt = this.con.createStatement(1003, 1007);
/*  696 */       SQLString sqlObj = new SQLString("MInvResultB");
/*  697 */       MInvResultBSchema aSchema = getSchema();
/*  698 */       sqlObj.setSQL(5, aSchema);
/*  699 */       String sql = sqlObj.getSQL();
/*      */ 
/*  701 */       rs = stmt.executeQuery(sql);
/*  702 */       int i = 0;
/*  703 */       while (rs.next())
/*      */       {
/*  705 */         i++;
/*      */ 
/*  707 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  711 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  715 */         MInvResultBSchema s1 = new MInvResultBSchema();
/*  716 */         s1.setSchema(rs, i);
/*  717 */         aMInvResultBSet.add(s1);
/*      */       }try {
/*  719 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  725 */       CError tError = new CError();
/*  726 */       tError.moduleName = "MInvResultBDB";
/*  727 */       tError.functionName = "query";
/*  728 */       tError.errorMessage = e.toString();
/*  729 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  731 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  734 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  738 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  744 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  748 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  753 */     return aMInvResultBSet;
/*      */   }
/*      */ 
/*      */   public MInvResultBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  758 */     Statement stmt = null;
/*  759 */     ResultSet rs = null;
/*  760 */     MInvResultBSet aMInvResultBSet = new MInvResultBSet();
/*      */ 
/*  762 */     if (!this.mflag) {
/*  763 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  768 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  770 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  771 */       int i = 0;
/*  772 */       while (rs.next())
/*      */       {
/*  774 */         i++;
/*      */ 
/*  776 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  780 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  784 */         MInvResultBSchema s1 = new MInvResultBSchema();
/*  785 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  788 */           CError tError = new CError();
/*  789 */           tError.moduleName = "MInvResultBDB";
/*  790 */           tError.functionName = "executeQuery";
/*  791 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  792 */           this.mErrors.addOneError(tError);
/*      */         }
/*  794 */         aMInvResultBSet.add(s1);
/*      */       }try {
/*  796 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  802 */       CError tError = new CError();
/*  803 */       tError.moduleName = "MInvResultBDB";
/*  804 */       tError.functionName = "executeQuery";
/*  805 */       tError.errorMessage = e.toString();
/*  806 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  808 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  811 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  815 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  821 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  825 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  830 */     return aMInvResultBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  835 */     Statement stmt = null;
/*      */ 
/*  837 */     if (!this.mflag) {
/*  838 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  843 */       stmt = this.con.createStatement(1003, 1007);
/*  844 */       SQLString sqlObj = new SQLString("MInvResultB");
/*  845 */       MInvResultBSchema aSchema = getSchema();
/*  846 */       sqlObj.setSQL(2, aSchema);
/*  847 */       String sql = "update MInvResultB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  849 */       int operCount = stmt.executeUpdate(sql);
/*  850 */       if (operCount == 0)
/*      */       {
/*  853 */         CError tError = new CError();
/*  854 */         tError.moduleName = "MInvResultBDB";
/*  855 */         tError.functionName = "update";
/*  856 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  857 */         this.mErrors.addOneError(tError);
/*      */ 
/*  859 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  863 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  867 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  873 */       CError tError = new CError();
/*  874 */       tError.moduleName = "MInvResultBDB";
/*  875 */       tError.functionName = "update";
/*  876 */       tError.errorMessage = e.toString();
/*  877 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  879 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  881 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  885 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  889 */       return false;
/*      */     }
/*      */ 
/*  892 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  896 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  901 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  907 */     if (this.mResultSet != null)
/*      */     {
/*  910 */       CError tError = new CError();
/*  911 */       tError.moduleName = "MInvResultBDB";
/*  912 */       tError.functionName = "prepareData";
/*  913 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  914 */       this.mErrors.addOneError(tError);
/*  915 */       return false;
/*      */     }
/*      */ 
/*  918 */     if (!this.mflag)
/*      */     {
/*  920 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  924 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  925 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  930 */       CError tError = new CError();
/*  931 */       tError.moduleName = "MInvResultBDB";
/*  932 */       tError.functionName = "prepareData";
/*  933 */       tError.errorMessage = e.toString();
/*  934 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  937 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  943 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  947 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  951 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  956 */       return false;
/*      */     }
/*      */ 
/*  959 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  963 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  968 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  974 */     boolean flag = true;
/*  975 */     if (this.mResultSet == null)
/*      */     {
/*  977 */       CError tError = new CError();
/*  978 */       tError.moduleName = "MInvResultBDB";
/*  979 */       tError.functionName = "hasMoreData";
/*  980 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  981 */       this.mErrors.addOneError(tError);
/*  982 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  986 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  990 */       CError tError = new CError();
/*  991 */       tError.moduleName = "MInvResultBDB";
/*  992 */       tError.functionName = "hasMoreData";
/*  993 */       tError.errorMessage = ex.toString();
/*  994 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  997 */         this.mResultSet.close();
/*  998 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1004 */         this.mStatement.close();
/* 1005 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1009 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1013 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1018 */       return false;
/*      */     }
/* 1020 */     return flag;
/*      */   }
/*      */ 
/*      */   public MInvResultBSet getData()
/*      */   {
/* 1025 */     int tCount = 0;
/* 1026 */     MInvResultBSet tMInvResultBSet = new MInvResultBSet();
/* 1027 */     MInvResultBSchema tMInvResultBSchema = null;
/* 1028 */     if (this.mResultSet == null)
/*      */     {
/* 1030 */       CError tError = new CError();
/* 1031 */       tError.moduleName = "MInvResultBDB";
/* 1032 */       tError.functionName = "getData";
/* 1033 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1034 */       this.mErrors.addOneError(tError);
/* 1035 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1039 */       tCount = 1;
/* 1040 */       tMInvResultBSchema = new MInvResultBSchema();
/* 1041 */       tMInvResultBSchema.setSchema(this.mResultSet, 1);
/* 1042 */       tMInvResultBSet.add(tMInvResultBSchema);
/*      */ 
/* 1044 */       while (tCount++ < 5000)
/*      */       {
/* 1046 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1048 */         tMInvResultBSchema = new MInvResultBSchema();
/* 1049 */         tMInvResultBSchema.setSchema(this.mResultSet, 1);
/* 1050 */         tMInvResultBSet.add(tMInvResultBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1056 */       CError tError = new CError();
/* 1057 */       tError.moduleName = "MInvResultBDB";
/* 1058 */       tError.functionName = "getData";
/* 1059 */       tError.errorMessage = ex.toString();
/* 1060 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1063 */         this.mResultSet.close();
/* 1064 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1070 */         this.mStatement.close();
/* 1071 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1075 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1079 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1084 */       return null;
/*      */     }
/* 1086 */     return tMInvResultBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1091 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1094 */       if (this.mResultSet == null)
/*      */       {
/* 1096 */         CError tError = new CError();
/* 1097 */         tError.moduleName = "MInvResultBDB";
/* 1098 */         tError.functionName = "closeData";
/* 1099 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1100 */         this.mErrors.addOneError(tError);
/* 1101 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1105 */         this.mResultSet.close();
/* 1106 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1111 */       CError tError = new CError();
/* 1112 */       tError.moduleName = "MInvResultBDB";
/* 1113 */       tError.functionName = "closeData";
/* 1114 */       tError.errorMessage = ex2.toString();
/* 1115 */       this.mErrors.addOneError(tError);
/* 1116 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1120 */       if (this.mStatement == null)
/*      */       {
/* 1122 */         CError tError = new CError();
/* 1123 */         tError.moduleName = "MInvResultBDB";
/* 1124 */         tError.functionName = "closeData";
/* 1125 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1126 */         this.mErrors.addOneError(tError);
/* 1127 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1131 */         this.mStatement.close();
/* 1132 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1137 */       CError tError = new CError();
/* 1138 */       tError.moduleName = "MInvResultBDB";
/* 1139 */       tError.functionName = "closeData";
/* 1140 */       tError.errorMessage = ex3.toString();
/* 1141 */       this.mErrors.addOneError(tError);
/* 1142 */       flag = false;
/*      */     }
/* 1144 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MInvResultBDB
 * JD-Core Version:    0.6.0
 */