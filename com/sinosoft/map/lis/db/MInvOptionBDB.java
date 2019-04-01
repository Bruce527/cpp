/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MInvOptionBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MInvOptionBSet;
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
/*      */ public class MInvOptionBDB extends MInvOptionBSchema
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
/*      */   public MInvOptionBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MInvOptionB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MInvOptionBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MInvOptionB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MInvOptionBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MInvOptionBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MInvOptionBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MInvOptionBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MInvOptionB WHERE  EdorNo = ?");
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
/*  107 */       tError.moduleName = "MInvOptionBDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MInvOptionB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , OptionID = ? , QuestionID = ? , Option = ? , OptionOrder = ? , State = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  EdorNo = ?");
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
/*  175 */       if ((getOptionID() == null) || (getOptionID().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getOptionID());
/*      */       }
/*  180 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getQuestionID());
/*      */       }
/*  185 */       if ((getOption() == null) || (getOption().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getOption());
/*      */       }
/*  190 */       pstmt.setInt(10, getOptionOrder());
/*  191 */       if ((getState() == null) || (getState().equals("null")))
/*  192 */         pstmt.setNull(11, 12);
/*      */       else {
/*  194 */         pstmt.setString(11, getState());
/*      */       }
/*  196 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  197 */         pstmt.setNull(12, 12);
/*      */       else {
/*  199 */         pstmt.setString(12, getVF01());
/*      */       }
/*  201 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  202 */         pstmt.setNull(13, 12);
/*      */       else {
/*  204 */         pstmt.setString(13, getNF01());
/*      */       }
/*  206 */       pstmt.setInt(14, getIF01());
/*  207 */       pstmt.setDouble(15, getDF02());
/*  208 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  209 */         pstmt.setNull(16, 91);
/*      */       else {
/*  211 */         pstmt.setDate(16, Date.valueOf(getDate01()));
/*      */       }
/*  213 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  214 */         pstmt.setNull(17, 12);
/*      */       else {
/*  216 */         pstmt.setString(17, getModifyOperator());
/*      */       }
/*  218 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  219 */         pstmt.setNull(18, 12);
/*      */       else {
/*  221 */         pstmt.setString(18, getOperator());
/*      */       }
/*  223 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  224 */         pstmt.setNull(19, 91);
/*      */       else {
/*  226 */         pstmt.setDate(19, Date.valueOf(getMakeDate()));
/*      */       }
/*  228 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  229 */         pstmt.setNull(20, 12);
/*      */       else {
/*  231 */         pstmt.setString(20, getMakeTime());
/*      */       }
/*  233 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  234 */         pstmt.setNull(21, 91);
/*      */       else {
/*  236 */         pstmt.setDate(21, Date.valueOf(getModifyDate()));
/*      */       }
/*  238 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  239 */         pstmt.setNull(22, 12);
/*      */       else {
/*  241 */         pstmt.setString(22, getModifyTime());
/*      */       }
/*      */ 
/*  244 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  245 */         pstmt.setNull(23, 12);
/*      */       else {
/*  247 */         pstmt.setString(23, getEdorNo());
/*      */       }
/*  249 */       pstmt.executeUpdate();
/*  250 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  253 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  254 */       CError tError = new CError();
/*  255 */       tError.moduleName = "MInvOptionBDB";
/*  256 */       tError.functionName = "update()";
/*  257 */       tError.errorMessage = ex.toString();
/*  258 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  261 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  264 */       if (!this.mflag)
/*      */         try {
/*  266 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  270 */       return false;
/*      */     }
/*      */ 
/*  273 */     if (!this.mflag)
/*      */       try {
/*  275 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  279 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  284 */     PreparedStatement pstmt = null;
/*      */ 
/*  286 */     if (!this.mflag) {
/*  287 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  292 */       pstmt = this.con.prepareStatement("INSERT INTO MInvOptionB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  293 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  294 */         pstmt.setNull(1, 12);
/*      */       else {
/*  296 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  298 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  299 */         pstmt.setNull(2, 12);
/*      */       else {
/*  301 */         pstmt.setString(2, getEdorType());
/*      */       }
/*  303 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  304 */         pstmt.setNull(3, 12);
/*      */       else {
/*  306 */         pstmt.setString(3, getEdorCase());
/*      */       }
/*  308 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  309 */         pstmt.setNull(4, 12);
/*      */       else {
/*  311 */         pstmt.setString(4, getOperator2());
/*      */       }
/*  313 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  314 */         pstmt.setNull(5, 91);
/*      */       else {
/*  316 */         pstmt.setDate(5, Date.valueOf(getMakeDate2()));
/*      */       }
/*  318 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  319 */         pstmt.setNull(6, 12);
/*      */       else {
/*  321 */         pstmt.setString(6, getMakeTime2());
/*      */       }
/*  323 */       if ((getOptionID() == null) || (getOptionID().equals("null")))
/*  324 */         pstmt.setNull(7, 12);
/*      */       else {
/*  326 */         pstmt.setString(7, getOptionID());
/*      */       }
/*  328 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  329 */         pstmt.setNull(8, 12);
/*      */       else {
/*  331 */         pstmt.setString(8, getQuestionID());
/*      */       }
/*  333 */       if ((getOption() == null) || (getOption().equals("null")))
/*  334 */         pstmt.setNull(9, 12);
/*      */       else {
/*  336 */         pstmt.setString(9, getOption());
/*      */       }
/*  338 */       pstmt.setInt(10, getOptionOrder());
/*  339 */       if ((getState() == null) || (getState().equals("null")))
/*  340 */         pstmt.setNull(11, 12);
/*      */       else {
/*  342 */         pstmt.setString(11, getState());
/*      */       }
/*  344 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  345 */         pstmt.setNull(12, 12);
/*      */       else {
/*  347 */         pstmt.setString(12, getVF01());
/*      */       }
/*  349 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  350 */         pstmt.setNull(13, 12);
/*      */       else {
/*  352 */         pstmt.setString(13, getNF01());
/*      */       }
/*  354 */       pstmt.setInt(14, getIF01());
/*  355 */       pstmt.setDouble(15, getDF02());
/*  356 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  357 */         pstmt.setNull(16, 91);
/*      */       else {
/*  359 */         pstmt.setDate(16, Date.valueOf(getDate01()));
/*      */       }
/*  361 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  362 */         pstmt.setNull(17, 12);
/*      */       else {
/*  364 */         pstmt.setString(17, getModifyOperator());
/*      */       }
/*  366 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  367 */         pstmt.setNull(18, 12);
/*      */       else {
/*  369 */         pstmt.setString(18, getOperator());
/*      */       }
/*  371 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  372 */         pstmt.setNull(19, 91);
/*      */       else {
/*  374 */         pstmt.setDate(19, Date.valueOf(getMakeDate()));
/*      */       }
/*  376 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  377 */         pstmt.setNull(20, 12);
/*      */       else {
/*  379 */         pstmt.setString(20, getMakeTime());
/*      */       }
/*  381 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  382 */         pstmt.setNull(21, 91);
/*      */       else {
/*  384 */         pstmt.setDate(21, Date.valueOf(getModifyDate()));
/*      */       }
/*  386 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  387 */         pstmt.setNull(22, 12);
/*      */       else {
/*  389 */         pstmt.setString(22, getModifyTime());
/*      */       }
/*      */ 
/*  392 */       pstmt.executeUpdate();
/*  393 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  396 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  397 */       CError tError = new CError();
/*  398 */       tError.moduleName = "MInvOptionBDB";
/*  399 */       tError.functionName = "insert()";
/*  400 */       tError.errorMessage = ex.toString();
/*  401 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  404 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  407 */       if (!this.mflag)
/*      */         try {
/*  409 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  413 */       return false;
/*      */     }
/*      */ 
/*  416 */     if (!this.mflag)
/*      */       try {
/*  418 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  422 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  427 */     PreparedStatement pstmt = null;
/*  428 */     ResultSet rs = null;
/*      */ 
/*  430 */     if (!this.mflag) {
/*  431 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  436 */       pstmt = this.con.prepareStatement("SELECT * FROM MInvOptionB WHERE  EdorNo = ?", 
/*  437 */         1003, 1007);
/*  438 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  439 */         pstmt.setNull(1, 12);
/*      */       else {
/*  441 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  443 */       rs = pstmt.executeQuery();
/*  444 */       int i = 0;
/*  445 */       if (rs.next())
/*      */       {
/*  447 */         i++;
/*  448 */         if (!setSchema(rs, i))
/*      */         {
/*  451 */           CError tError = new CError();
/*  452 */           tError.moduleName = "MInvOptionBDB";
/*  453 */           tError.functionName = "getInfo";
/*  454 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  455 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  457 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  460 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  464 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  468 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  472 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  475 */       if (i == 0)
/*      */       {
/*  477 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  481 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  485 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  491 */       CError tError = new CError();
/*  492 */       tError.moduleName = "MInvOptionBDB";
/*  493 */       tError.functionName = "getInfo";
/*  494 */       tError.errorMessage = e.toString();
/*  495 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  497 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  500 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  504 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  508 */       return false;
/*      */     }
/*      */ 
/*  511 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  515 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  520 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvOptionBSet query()
/*      */   {
/*  525 */     Statement stmt = null;
/*  526 */     ResultSet rs = null;
/*  527 */     MInvOptionBSet aMInvOptionBSet = new MInvOptionBSet();
/*      */ 
/*  529 */     if (!this.mflag) {
/*  530 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  535 */       stmt = this.con.createStatement(1003, 1007);
/*  536 */       SQLString sqlObj = new SQLString("MInvOptionB");
/*  537 */       MInvOptionBSchema aSchema = getSchema();
/*  538 */       sqlObj.setSQL(5, aSchema);
/*  539 */       String sql = sqlObj.getSQL();
/*      */ 
/*  541 */       rs = stmt.executeQuery(sql);
/*  542 */       int i = 0;
/*  543 */       while (rs.next())
/*      */       {
/*  545 */         i++;
/*  546 */         MInvOptionBSchema s1 = new MInvOptionBSchema();
/*  547 */         s1.setSchema(rs, i);
/*  548 */         aMInvOptionBSet.add(s1);
/*      */       }try {
/*  550 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  556 */       CError tError = new CError();
/*  557 */       tError.moduleName = "MInvOptionBDB";
/*  558 */       tError.functionName = "query";
/*  559 */       tError.errorMessage = e.toString();
/*  560 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  562 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  565 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  569 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  575 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  579 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  584 */     return aMInvOptionBSet;
/*      */   }
/*      */ 
/*      */   public MInvOptionBSet executeQuery(String sql)
/*      */   {
/*  589 */     Statement stmt = null;
/*  590 */     ResultSet rs = null;
/*  591 */     MInvOptionBSet aMInvOptionBSet = new MInvOptionBSet();
/*      */ 
/*  593 */     if (!this.mflag) {
/*  594 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  599 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  601 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  602 */       int i = 0;
/*  603 */       while (rs.next())
/*      */       {
/*  605 */         i++;
/*  606 */         MInvOptionBSchema s1 = new MInvOptionBSchema();
/*  607 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  610 */           CError tError = new CError();
/*  611 */           tError.moduleName = "MInvOptionBDB";
/*  612 */           tError.functionName = "executeQuery";
/*  613 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  614 */           this.mErrors.addOneError(tError);
/*      */         }
/*  616 */         aMInvOptionBSet.add(s1);
/*      */       }try {
/*  618 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  624 */       CError tError = new CError();
/*  625 */       tError.moduleName = "MInvOptionBDB";
/*  626 */       tError.functionName = "executeQuery";
/*  627 */       tError.errorMessage = e.toString();
/*  628 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  630 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  633 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  637 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  643 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  647 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  652 */     return aMInvOptionBSet;
/*      */   }
/*      */ 
/*      */   public MInvOptionBSet query(int nStart, int nCount)
/*      */   {
/*  657 */     Statement stmt = null;
/*  658 */     ResultSet rs = null;
/*  659 */     MInvOptionBSet aMInvOptionBSet = new MInvOptionBSet();
/*      */ 
/*  661 */     if (!this.mflag) {
/*  662 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  667 */       stmt = this.con.createStatement(1003, 1007);
/*  668 */       SQLString sqlObj = new SQLString("MInvOptionB");
/*  669 */       MInvOptionBSchema aSchema = getSchema();
/*  670 */       sqlObj.setSQL(5, aSchema);
/*  671 */       String sql = sqlObj.getSQL();
/*      */ 
/*  673 */       rs = stmt.executeQuery(sql);
/*  674 */       int i = 0;
/*  675 */       while (rs.next())
/*      */       {
/*  677 */         i++;
/*      */ 
/*  679 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  683 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  687 */         MInvOptionBSchema s1 = new MInvOptionBSchema();
/*  688 */         s1.setSchema(rs, i);
/*  689 */         aMInvOptionBSet.add(s1);
/*      */       }try {
/*  691 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  697 */       CError tError = new CError();
/*  698 */       tError.moduleName = "MInvOptionBDB";
/*  699 */       tError.functionName = "query";
/*  700 */       tError.errorMessage = e.toString();
/*  701 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  703 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  706 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  710 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  716 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  720 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  725 */     return aMInvOptionBSet;
/*      */   }
/*      */ 
/*      */   public MInvOptionBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  730 */     Statement stmt = null;
/*  731 */     ResultSet rs = null;
/*  732 */     MInvOptionBSet aMInvOptionBSet = new MInvOptionBSet();
/*      */ 
/*  734 */     if (!this.mflag) {
/*  735 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  740 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  742 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  743 */       int i = 0;
/*  744 */       while (rs.next())
/*      */       {
/*  746 */         i++;
/*      */ 
/*  748 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  752 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  756 */         MInvOptionBSchema s1 = new MInvOptionBSchema();
/*  757 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  760 */           CError tError = new CError();
/*  761 */           tError.moduleName = "MInvOptionBDB";
/*  762 */           tError.functionName = "executeQuery";
/*  763 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  764 */           this.mErrors.addOneError(tError);
/*      */         }
/*  766 */         aMInvOptionBSet.add(s1);
/*      */       }try {
/*  768 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  774 */       CError tError = new CError();
/*  775 */       tError.moduleName = "MInvOptionBDB";
/*  776 */       tError.functionName = "executeQuery";
/*  777 */       tError.errorMessage = e.toString();
/*  778 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  780 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  783 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  787 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  793 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  797 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  802 */     return aMInvOptionBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  807 */     Statement stmt = null;
/*      */ 
/*  809 */     if (!this.mflag) {
/*  810 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  815 */       stmt = this.con.createStatement(1003, 1007);
/*  816 */       SQLString sqlObj = new SQLString("MInvOptionB");
/*  817 */       MInvOptionBSchema aSchema = getSchema();
/*  818 */       sqlObj.setSQL(2, aSchema);
/*  819 */       String sql = "update MInvOptionB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  821 */       int operCount = stmt.executeUpdate(sql);
/*  822 */       if (operCount == 0)
/*      */       {
/*  825 */         CError tError = new CError();
/*  826 */         tError.moduleName = "MInvOptionBDB";
/*  827 */         tError.functionName = "update";
/*  828 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  829 */         this.mErrors.addOneError(tError);
/*      */ 
/*  831 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  835 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  839 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  845 */       CError tError = new CError();
/*  846 */       tError.moduleName = "MInvOptionBDB";
/*  847 */       tError.functionName = "update";
/*  848 */       tError.errorMessage = e.toString();
/*  849 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  851 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  853 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  857 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  861 */       return false;
/*      */     }
/*      */ 
/*  864 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  868 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  873 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  879 */     if (this.mResultSet != null)
/*      */     {
/*  882 */       CError tError = new CError();
/*  883 */       tError.moduleName = "MInvOptionBDB";
/*  884 */       tError.functionName = "prepareData";
/*  885 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  886 */       this.mErrors.addOneError(tError);
/*  887 */       return false;
/*      */     }
/*      */ 
/*  890 */     if (!this.mflag)
/*      */     {
/*  892 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  896 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  897 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  902 */       CError tError = new CError();
/*  903 */       tError.moduleName = "MInvOptionBDB";
/*  904 */       tError.functionName = "prepareData";
/*  905 */       tError.errorMessage = e.toString();
/*  906 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  909 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  915 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  919 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  923 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
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
/*      */   public boolean hasMoreData()
/*      */   {
/*  946 */     boolean flag = true;
/*  947 */     if (this.mResultSet == null)
/*      */     {
/*  949 */       CError tError = new CError();
/*  950 */       tError.moduleName = "MInvOptionBDB";
/*  951 */       tError.functionName = "hasMoreData";
/*  952 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  953 */       this.mErrors.addOneError(tError);
/*  954 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  958 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  962 */       CError tError = new CError();
/*  963 */       tError.moduleName = "MInvOptionBDB";
/*  964 */       tError.functionName = "hasMoreData";
/*  965 */       tError.errorMessage = ex.toString();
/*  966 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  969 */         this.mResultSet.close();
/*  970 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  976 */         this.mStatement.close();
/*  977 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  981 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  985 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  990 */       return false;
/*      */     }
/*  992 */     return flag;
/*      */   }
/*      */ 
/*      */   public MInvOptionBSet getData()
/*      */   {
/*  997 */     int tCount = 0;
/*  998 */     MInvOptionBSet tMInvOptionBSet = new MInvOptionBSet();
/*  999 */     MInvOptionBSchema tMInvOptionBSchema = null;
/* 1000 */     if (this.mResultSet == null)
/*      */     {
/* 1002 */       CError tError = new CError();
/* 1003 */       tError.moduleName = "MInvOptionBDB";
/* 1004 */       tError.functionName = "getData";
/* 1005 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1006 */       this.mErrors.addOneError(tError);
/* 1007 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1011 */       tCount = 1;
/* 1012 */       tMInvOptionBSchema = new MInvOptionBSchema();
/* 1013 */       tMInvOptionBSchema.setSchema(this.mResultSet, 1);
/* 1014 */       tMInvOptionBSet.add(tMInvOptionBSchema);
/*      */ 
/* 1016 */       while (tCount++ < 5000)
/*      */       {
/* 1018 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1020 */         tMInvOptionBSchema = new MInvOptionBSchema();
/* 1021 */         tMInvOptionBSchema.setSchema(this.mResultSet, 1);
/* 1022 */         tMInvOptionBSet.add(tMInvOptionBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1028 */       CError tError = new CError();
/* 1029 */       tError.moduleName = "MInvOptionBDB";
/* 1030 */       tError.functionName = "getData";
/* 1031 */       tError.errorMessage = ex.toString();
/* 1032 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1035 */         this.mResultSet.close();
/* 1036 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1042 */         this.mStatement.close();
/* 1043 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1047 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1051 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1056 */       return null;
/*      */     }
/* 1058 */     return tMInvOptionBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1063 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1066 */       if (this.mResultSet == null)
/*      */       {
/* 1068 */         CError tError = new CError();
/* 1069 */         tError.moduleName = "MInvOptionBDB";
/* 1070 */         tError.functionName = "closeData";
/* 1071 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1072 */         this.mErrors.addOneError(tError);
/* 1073 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1077 */         this.mResultSet.close();
/* 1078 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1083 */       CError tError = new CError();
/* 1084 */       tError.moduleName = "MInvOptionBDB";
/* 1085 */       tError.functionName = "closeData";
/* 1086 */       tError.errorMessage = ex2.toString();
/* 1087 */       this.mErrors.addOneError(tError);
/* 1088 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1092 */       if (this.mStatement == null)
/*      */       {
/* 1094 */         CError tError = new CError();
/* 1095 */         tError.moduleName = "MInvOptionBDB";
/* 1096 */         tError.functionName = "closeData";
/* 1097 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1098 */         this.mErrors.addOneError(tError);
/* 1099 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1103 */         this.mStatement.close();
/* 1104 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1109 */       CError tError = new CError();
/* 1110 */       tError.moduleName = "MInvOptionBDB";
/* 1111 */       tError.functionName = "closeData";
/* 1112 */       tError.errorMessage = ex3.toString();
/* 1113 */       this.mErrors.addOneError(tError);
/* 1114 */       flag = false;
/*      */     }
/* 1116 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MInvOptionBDB
 * JD-Core Version:    0.6.0
 */