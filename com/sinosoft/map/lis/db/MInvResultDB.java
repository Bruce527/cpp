/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MInvResultSchema;
/*      */ import com.sinosoft.map.lis.vschema.MInvResultSet;
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
/*      */ public class MInvResultDB extends MInvResultSchema
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
/*      */   public MInvResultDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MInvResult");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MInvResultDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MInvResult");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MInvResultSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MInvResultDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MInvResultSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MInvResultDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MInvResult WHERE  ResultID = ?");
/*   96 */       if ((getResultID() == null) || (getResultID().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getResultID());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MInvResultDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MInvResult SET  ResultID = ? , TopicID = ? , QuestionID = ? , OptionID = ? , OtherAnswer = ? , AgentCode = ? , ManageCom = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultID = ?");
/*  145 */       if ((getResultID() == null) || (getResultID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getResultID());
/*      */       }
/*  150 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getTopicID());
/*      */       }
/*  155 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getQuestionID());
/*      */       }
/*  160 */       if ((getOptionID() == null) || (getOptionID().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getOptionID());
/*      */       }
/*  165 */       if ((getOtherAnswer() == null) || (getOtherAnswer().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getOtherAnswer());
/*      */       }
/*  170 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getAgentCode());
/*      */       }
/*  175 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getManageCom());
/*      */       }
/*  180 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getVF01());
/*      */       }
/*  185 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getNF01());
/*      */       }
/*  190 */       pstmt.setInt(10, getIF01());
/*  191 */       pstmt.setDouble(11, getDF02());
/*  192 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  193 */         pstmt.setNull(12, 91);
/*      */       else {
/*  195 */         pstmt.setDate(12, Date.valueOf(getDate01()));
/*      */       }
/*  197 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  198 */         pstmt.setNull(13, 12);
/*      */       else {
/*  200 */         pstmt.setString(13, getModifyOperator());
/*      */       }
/*  202 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  203 */         pstmt.setNull(14, 12);
/*      */       else {
/*  205 */         pstmt.setString(14, getOperator());
/*      */       }
/*  207 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  208 */         pstmt.setNull(15, 91);
/*      */       else {
/*  210 */         pstmt.setDate(15, Date.valueOf(getMakeDate()));
/*      */       }
/*  212 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  213 */         pstmt.setNull(16, 12);
/*      */       else {
/*  215 */         pstmt.setString(16, getMakeTime());
/*      */       }
/*  217 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  218 */         pstmt.setNull(17, 91);
/*      */       else {
/*  220 */         pstmt.setDate(17, Date.valueOf(getModifyDate()));
/*      */       }
/*  222 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  223 */         pstmt.setNull(18, 12);
/*      */       else {
/*  225 */         pstmt.setString(18, getModifyTime());
/*      */       }
/*      */ 
/*  228 */       if ((getResultID() == null) || (getResultID().equals("null")))
/*  229 */         pstmt.setNull(19, 12);
/*      */       else {
/*  231 */         pstmt.setString(19, getResultID());
/*      */       }
/*  233 */       pstmt.executeUpdate();
/*  234 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  237 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  238 */       CError tError = new CError();
/*  239 */       tError.moduleName = "MInvResultDB";
/*  240 */       tError.functionName = "update()";
/*  241 */       tError.errorMessage = ex.toString();
/*  242 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  245 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  248 */       if (!this.mflag)
/*      */         try {
/*  250 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  254 */       return false;
/*      */     }
/*      */ 
/*  257 */     if (!this.mflag)
/*      */       try {
/*  259 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  263 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  268 */     PreparedStatement pstmt = null;
/*      */ 
/*  270 */     if (!this.mflag) {
/*  271 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  276 */       pstmt = this.con.prepareStatement("INSERT INTO MInvResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  277 */       if ((getResultID() == null) || (getResultID().equals("null")))
/*  278 */         pstmt.setNull(1, 12);
/*      */       else {
/*  280 */         pstmt.setString(1, getResultID());
/*      */       }
/*  282 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  283 */         pstmt.setNull(2, 12);
/*      */       else {
/*  285 */         pstmt.setString(2, getTopicID());
/*      */       }
/*  287 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  288 */         pstmt.setNull(3, 12);
/*      */       else {
/*  290 */         pstmt.setString(3, getQuestionID());
/*      */       }
/*  292 */       if ((getOptionID() == null) || (getOptionID().equals("null")))
/*  293 */         pstmt.setNull(4, 12);
/*      */       else {
/*  295 */         pstmt.setString(4, getOptionID());
/*      */       }
/*  297 */       if ((getOtherAnswer() == null) || (getOtherAnswer().equals("null")))
/*  298 */         pstmt.setNull(5, 12);
/*      */       else {
/*  300 */         pstmt.setString(5, getOtherAnswer());
/*      */       }
/*  302 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  303 */         pstmt.setNull(6, 12);
/*      */       else {
/*  305 */         pstmt.setString(6, getAgentCode());
/*      */       }
/*  307 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  308 */         pstmt.setNull(7, 12);
/*      */       else {
/*  310 */         pstmt.setString(7, getManageCom());
/*      */       }
/*  312 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  313 */         pstmt.setNull(8, 12);
/*      */       else {
/*  315 */         pstmt.setString(8, getVF01());
/*      */       }
/*  317 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  318 */         pstmt.setNull(9, 12);
/*      */       else {
/*  320 */         pstmt.setString(9, getNF01());
/*      */       }
/*  322 */       pstmt.setInt(10, getIF01());
/*  323 */       pstmt.setDouble(11, getDF02());
/*  324 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  325 */         pstmt.setNull(12, 91);
/*      */       else {
/*  327 */         pstmt.setDate(12, Date.valueOf(getDate01()));
/*      */       }
/*  329 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  330 */         pstmt.setNull(13, 12);
/*      */       else {
/*  332 */         pstmt.setString(13, getModifyOperator());
/*      */       }
/*  334 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  335 */         pstmt.setNull(14, 12);
/*      */       else {
/*  337 */         pstmt.setString(14, getOperator());
/*      */       }
/*  339 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  340 */         pstmt.setNull(15, 91);
/*      */       else {
/*  342 */         pstmt.setDate(15, Date.valueOf(getMakeDate()));
/*      */       }
/*  344 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  345 */         pstmt.setNull(16, 12);
/*      */       else {
/*  347 */         pstmt.setString(16, getMakeTime());
/*      */       }
/*  349 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  350 */         pstmt.setNull(17, 91);
/*      */       else {
/*  352 */         pstmt.setDate(17, Date.valueOf(getModifyDate()));
/*      */       }
/*  354 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  355 */         pstmt.setNull(18, 12);
/*      */       else {
/*  357 */         pstmt.setString(18, getModifyTime());
/*      */       }
/*      */ 
/*  360 */       pstmt.executeUpdate();
/*  361 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  364 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  365 */       CError tError = new CError();
/*  366 */       tError.moduleName = "MInvResultDB";
/*  367 */       tError.functionName = "insert()";
/*  368 */       tError.errorMessage = ex.toString();
/*  369 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  372 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  375 */       if (!this.mflag)
/*      */         try {
/*  377 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  381 */       return false;
/*      */     }
/*      */ 
/*  384 */     if (!this.mflag)
/*      */       try {
/*  386 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  390 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  395 */     PreparedStatement pstmt = null;
/*  396 */     ResultSet rs = null;
/*      */ 
/*  398 */     if (!this.mflag) {
/*  399 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  404 */       pstmt = this.con.prepareStatement("SELECT * FROM MInvResult WHERE  ResultID = ?", 
/*  405 */         1003, 1007);
/*  406 */       if ((getResultID() == null) || (getResultID().equals("null")))
/*  407 */         pstmt.setNull(1, 12);
/*      */       else {
/*  409 */         pstmt.setString(1, getResultID());
/*      */       }
/*  411 */       rs = pstmt.executeQuery();
/*  412 */       int i = 0;
/*  413 */       if (rs.next())
/*      */       {
/*  415 */         i++;
/*  416 */         if (!setSchema(rs, i))
/*      */         {
/*  419 */           CError tError = new CError();
/*  420 */           tError.moduleName = "MInvResultDB";
/*  421 */           tError.functionName = "getInfo";
/*  422 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  423 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  425 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  428 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  432 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  436 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  440 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  443 */       if (i == 0)
/*      */       {
/*  445 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  449 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  453 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  459 */       CError tError = new CError();
/*  460 */       tError.moduleName = "MInvResultDB";
/*  461 */       tError.functionName = "getInfo";
/*  462 */       tError.errorMessage = e.toString();
/*  463 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  465 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  468 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  472 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  476 */       return false;
/*      */     }
/*      */ 
/*  479 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  483 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  488 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvResultSet query()
/*      */   {
/*  493 */     Statement stmt = null;
/*  494 */     ResultSet rs = null;
/*  495 */     MInvResultSet aMInvResultSet = new MInvResultSet();
/*      */ 
/*  497 */     if (!this.mflag) {
/*  498 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  503 */       stmt = this.con.createStatement(1003, 1007);
/*  504 */       SQLString sqlObj = new SQLString("MInvResult");
/*  505 */       MInvResultSchema aSchema = getSchema();
/*  506 */       sqlObj.setSQL(5, aSchema);
/*  507 */       String sql = sqlObj.getSQL();
/*      */ 
/*  509 */       rs = stmt.executeQuery(sql);
/*  510 */       int i = 0;
/*  511 */       while (rs.next())
/*      */       {
/*  513 */         i++;
/*  514 */         MInvResultSchema s1 = new MInvResultSchema();
/*  515 */         s1.setSchema(rs, i);
/*  516 */         aMInvResultSet.add(s1);
/*      */       }try {
/*  518 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  524 */       CError tError = new CError();
/*  525 */       tError.moduleName = "MInvResultDB";
/*  526 */       tError.functionName = "query";
/*  527 */       tError.errorMessage = e.toString();
/*  528 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  530 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  533 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  537 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  543 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  547 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  552 */     return aMInvResultSet;
/*      */   }
/*      */ 
/*      */   public MInvResultSet executeQuery(String sql)
/*      */   {
/*  557 */     Statement stmt = null;
/*  558 */     ResultSet rs = null;
/*  559 */     MInvResultSet aMInvResultSet = new MInvResultSet();
/*      */ 
/*  561 */     if (!this.mflag) {
/*  562 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  567 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  569 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  570 */       int i = 0;
/*  571 */       while (rs.next())
/*      */       {
/*  573 */         i++;
/*  574 */         MInvResultSchema s1 = new MInvResultSchema();
/*  575 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  578 */           CError tError = new CError();
/*  579 */           tError.moduleName = "MInvResultDB";
/*  580 */           tError.functionName = "executeQuery";
/*  581 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  582 */           this.mErrors.addOneError(tError);
/*      */         }
/*  584 */         aMInvResultSet.add(s1);
/*      */       }try {
/*  586 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  592 */       CError tError = new CError();
/*  593 */       tError.moduleName = "MInvResultDB";
/*  594 */       tError.functionName = "executeQuery";
/*  595 */       tError.errorMessage = e.toString();
/*  596 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  598 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  601 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  605 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  611 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  615 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  620 */     return aMInvResultSet;
/*      */   }
/*      */ 
/*      */   public MInvResultSet query(int nStart, int nCount)
/*      */   {
/*  625 */     Statement stmt = null;
/*  626 */     ResultSet rs = null;
/*  627 */     MInvResultSet aMInvResultSet = new MInvResultSet();
/*      */ 
/*  629 */     if (!this.mflag) {
/*  630 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  635 */       stmt = this.con.createStatement(1003, 1007);
/*  636 */       SQLString sqlObj = new SQLString("MInvResult");
/*  637 */       MInvResultSchema aSchema = getSchema();
/*  638 */       sqlObj.setSQL(5, aSchema);
/*  639 */       String sql = sqlObj.getSQL();
/*      */ 
/*  641 */       rs = stmt.executeQuery(sql);
/*  642 */       int i = 0;
/*  643 */       while (rs.next())
/*      */       {
/*  645 */         i++;
/*      */ 
/*  647 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  651 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  655 */         MInvResultSchema s1 = new MInvResultSchema();
/*  656 */         s1.setSchema(rs, i);
/*  657 */         aMInvResultSet.add(s1);
/*      */       }try {
/*  659 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  665 */       CError tError = new CError();
/*  666 */       tError.moduleName = "MInvResultDB";
/*  667 */       tError.functionName = "query";
/*  668 */       tError.errorMessage = e.toString();
/*  669 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  671 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  674 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  678 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  684 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  688 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  693 */     return aMInvResultSet;
/*      */   }
/*      */ 
/*      */   public MInvResultSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  698 */     Statement stmt = null;
/*  699 */     ResultSet rs = null;
/*  700 */     MInvResultSet aMInvResultSet = new MInvResultSet();
/*      */ 
/*  702 */     if (!this.mflag) {
/*  703 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  708 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  710 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  711 */       int i = 0;
/*  712 */       while (rs.next())
/*      */       {
/*  714 */         i++;
/*      */ 
/*  716 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  720 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  724 */         MInvResultSchema s1 = new MInvResultSchema();
/*  725 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  728 */           CError tError = new CError();
/*  729 */           tError.moduleName = "MInvResultDB";
/*  730 */           tError.functionName = "executeQuery";
/*  731 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  732 */           this.mErrors.addOneError(tError);
/*      */         }
/*  734 */         aMInvResultSet.add(s1);
/*      */       }try {
/*  736 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  742 */       CError tError = new CError();
/*  743 */       tError.moduleName = "MInvResultDB";
/*  744 */       tError.functionName = "executeQuery";
/*  745 */       tError.errorMessage = e.toString();
/*  746 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  748 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  751 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  755 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  761 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  765 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  770 */     return aMInvResultSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  775 */     Statement stmt = null;
/*      */ 
/*  777 */     if (!this.mflag) {
/*  778 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  783 */       stmt = this.con.createStatement(1003, 1007);
/*  784 */       SQLString sqlObj = new SQLString("MInvResult");
/*  785 */       MInvResultSchema aSchema = getSchema();
/*  786 */       sqlObj.setSQL(2, aSchema);
/*  787 */       String sql = "update MInvResult " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  789 */       int operCount = stmt.executeUpdate(sql);
/*  790 */       if (operCount == 0)
/*      */       {
/*  793 */         CError tError = new CError();
/*  794 */         tError.moduleName = "MInvResultDB";
/*  795 */         tError.functionName = "update";
/*  796 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  797 */         this.mErrors.addOneError(tError);
/*      */ 
/*  799 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  803 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  807 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  813 */       CError tError = new CError();
/*  814 */       tError.moduleName = "MInvResultDB";
/*  815 */       tError.functionName = "update";
/*  816 */       tError.errorMessage = e.toString();
/*  817 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  819 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  821 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  825 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  829 */       return false;
/*      */     }
/*      */ 
/*  832 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  836 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  841 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  847 */     if (this.mResultSet != null)
/*      */     {
/*  850 */       CError tError = new CError();
/*  851 */       tError.moduleName = "MInvResultDB";
/*  852 */       tError.functionName = "prepareData";
/*  853 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  854 */       this.mErrors.addOneError(tError);
/*  855 */       return false;
/*      */     }
/*      */ 
/*  858 */     if (!this.mflag)
/*      */     {
/*  860 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  864 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  865 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  870 */       CError tError = new CError();
/*  871 */       tError.moduleName = "MInvResultDB";
/*  872 */       tError.functionName = "prepareData";
/*  873 */       tError.errorMessage = e.toString();
/*  874 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  877 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  883 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  887 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  891 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  896 */       return false;
/*      */     }
/*      */ 
/*  899 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  903 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  908 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  914 */     boolean flag = true;
/*  915 */     if (this.mResultSet == null)
/*      */     {
/*  917 */       CError tError = new CError();
/*  918 */       tError.moduleName = "MInvResultDB";
/*  919 */       tError.functionName = "hasMoreData";
/*  920 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  921 */       this.mErrors.addOneError(tError);
/*  922 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  926 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  930 */       CError tError = new CError();
/*  931 */       tError.moduleName = "MInvResultDB";
/*  932 */       tError.functionName = "hasMoreData";
/*  933 */       tError.errorMessage = ex.toString();
/*  934 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  937 */         this.mResultSet.close();
/*  938 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  944 */         this.mStatement.close();
/*  945 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  949 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  953 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  958 */       return false;
/*      */     }
/*  960 */     return flag;
/*      */   }
/*      */ 
/*      */   public MInvResultSet getData()
/*      */   {
/*  965 */     int tCount = 0;
/*  966 */     MInvResultSet tMInvResultSet = new MInvResultSet();
/*  967 */     MInvResultSchema tMInvResultSchema = null;
/*  968 */     if (this.mResultSet == null)
/*      */     {
/*  970 */       CError tError = new CError();
/*  971 */       tError.moduleName = "MInvResultDB";
/*  972 */       tError.functionName = "getData";
/*  973 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  974 */       this.mErrors.addOneError(tError);
/*  975 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  979 */       tCount = 1;
/*  980 */       tMInvResultSchema = new MInvResultSchema();
/*  981 */       tMInvResultSchema.setSchema(this.mResultSet, 1);
/*  982 */       tMInvResultSet.add(tMInvResultSchema);
/*      */ 
/*  984 */       while (tCount++ < 5000)
/*      */       {
/*  986 */         if (!this.mResultSet.next())
/*      */           continue;
/*  988 */         tMInvResultSchema = new MInvResultSchema();
/*  989 */         tMInvResultSchema.setSchema(this.mResultSet, 1);
/*  990 */         tMInvResultSet.add(tMInvResultSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  996 */       CError tError = new CError();
/*  997 */       tError.moduleName = "MInvResultDB";
/*  998 */       tError.functionName = "getData";
/*  999 */       tError.errorMessage = ex.toString();
/* 1000 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1003 */         this.mResultSet.close();
/* 1004 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1010 */         this.mStatement.close();
/* 1011 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1015 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1019 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1024 */       return null;
/*      */     }
/* 1026 */     return tMInvResultSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1031 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1034 */       if (this.mResultSet == null)
/*      */       {
/* 1036 */         CError tError = new CError();
/* 1037 */         tError.moduleName = "MInvResultDB";
/* 1038 */         tError.functionName = "closeData";
/* 1039 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1040 */         this.mErrors.addOneError(tError);
/* 1041 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1045 */         this.mResultSet.close();
/* 1046 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1051 */       CError tError = new CError();
/* 1052 */       tError.moduleName = "MInvResultDB";
/* 1053 */       tError.functionName = "closeData";
/* 1054 */       tError.errorMessage = ex2.toString();
/* 1055 */       this.mErrors.addOneError(tError);
/* 1056 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1060 */       if (this.mStatement == null)
/*      */       {
/* 1062 */         CError tError = new CError();
/* 1063 */         tError.moduleName = "MInvResultDB";
/* 1064 */         tError.functionName = "closeData";
/* 1065 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1066 */         this.mErrors.addOneError(tError);
/* 1067 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1071 */         this.mStatement.close();
/* 1072 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1077 */       CError tError = new CError();
/* 1078 */       tError.moduleName = "MInvResultDB";
/* 1079 */       tError.functionName = "closeData";
/* 1080 */       tError.errorMessage = ex3.toString();
/* 1081 */       this.mErrors.addOneError(tError);
/* 1082 */       flag = false;
/*      */     }
/* 1084 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MInvResultDB
 * JD-Core Version:    0.6.0
 */