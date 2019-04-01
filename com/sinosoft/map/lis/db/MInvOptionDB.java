/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MInvOptionSchema;
/*      */ import com.sinosoft.map.lis.vschema.MInvOptionSet;
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
/*      */ public class MInvOptionDB extends MInvOptionSchema
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
/*      */   public MInvOptionDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MInvOption");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MInvOptionDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MInvOption");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MInvOptionSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MInvOptionDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MInvOptionSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MInvOptionDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MInvOption WHERE  OptionID = ?");
/*   96 */       if ((getOptionID() == null) || (getOptionID().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getOptionID());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MInvOptionDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MInvOption SET  OptionID = ? , QuestionID = ? , Option = ? , OptionOrder = ? , State = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  OptionID = ?");
/*  145 */       if ((getOptionID() == null) || (getOptionID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getOptionID());
/*      */       }
/*  150 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getQuestionID());
/*      */       }
/*  155 */       if ((getOption() == null) || (getOption().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getOption());
/*      */       }
/*  160 */       pstmt.setInt(4, getOptionOrder());
/*  161 */       if ((getState() == null) || (getState().equals("null")))
/*  162 */         pstmt.setNull(5, 12);
/*      */       else {
/*  164 */         pstmt.setString(5, getState());
/*      */       }
/*  166 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  167 */         pstmt.setNull(6, 12);
/*      */       else {
/*  169 */         pstmt.setString(6, getVF01());
/*      */       }
/*  171 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  172 */         pstmt.setNull(7, 12);
/*      */       else {
/*  174 */         pstmt.setString(7, getNF01());
/*      */       }
/*  176 */       pstmt.setInt(8, getIF01());
/*  177 */       pstmt.setDouble(9, getDF02());
/*  178 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  179 */         pstmt.setNull(10, 91);
/*      */       else {
/*  181 */         pstmt.setDate(10, Date.valueOf(getDate01()));
/*      */       }
/*  183 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  184 */         pstmt.setNull(11, 12);
/*      */       else {
/*  186 */         pstmt.setString(11, getModifyOperator());
/*      */       }
/*  188 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  189 */         pstmt.setNull(12, 12);
/*      */       else {
/*  191 */         pstmt.setString(12, getOperator());
/*      */       }
/*  193 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  194 */         pstmt.setNull(13, 91);
/*      */       else {
/*  196 */         pstmt.setDate(13, Date.valueOf(getMakeDate()));
/*      */       }
/*  198 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  199 */         pstmt.setNull(14, 12);
/*      */       else {
/*  201 */         pstmt.setString(14, getMakeTime());
/*      */       }
/*  203 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  204 */         pstmt.setNull(15, 91);
/*      */       else {
/*  206 */         pstmt.setDate(15, Date.valueOf(getModifyDate()));
/*      */       }
/*  208 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  209 */         pstmt.setNull(16, 12);
/*      */       else {
/*  211 */         pstmt.setString(16, getModifyTime());
/*      */       }
/*      */ 
/*  214 */       if ((getOptionID() == null) || (getOptionID().equals("null")))
/*  215 */         pstmt.setNull(17, 12);
/*      */       else {
/*  217 */         pstmt.setString(17, getOptionID());
/*      */       }
/*  219 */       pstmt.executeUpdate();
/*  220 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  223 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  224 */       CError tError = new CError();
/*  225 */       tError.moduleName = "MInvOptionDB";
/*  226 */       tError.functionName = "update()";
/*  227 */       tError.errorMessage = ex.toString();
/*  228 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  231 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  234 */       if (!this.mflag)
/*      */         try {
/*  236 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  240 */       return false;
/*      */     }
/*      */ 
/*  243 */     if (!this.mflag)
/*      */       try {
/*  245 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  249 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  254 */     PreparedStatement pstmt = null;
/*      */ 
/*  256 */     if (!this.mflag) {
/*  257 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  262 */       pstmt = this.con.prepareStatement("INSERT INTO MInvOption VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  263 */       if ((getOptionID() == null) || (getOptionID().equals("null")))
/*  264 */         pstmt.setNull(1, 12);
/*      */       else {
/*  266 */         pstmt.setString(1, getOptionID());
/*      */       }
/*  268 */       if ((getQuestionID() == null) || (getQuestionID().equals("null")))
/*  269 */         pstmt.setNull(2, 12);
/*      */       else {
/*  271 */         pstmt.setString(2, getQuestionID());
/*      */       }
/*  273 */       if ((getOption() == null) || (getOption().equals("null")))
/*  274 */         pstmt.setNull(3, 12);
/*      */       else {
/*  276 */         pstmt.setString(3, getOption());
/*      */       }
/*  278 */       pstmt.setInt(4, getOptionOrder());
/*  279 */       if ((getState() == null) || (getState().equals("null")))
/*  280 */         pstmt.setNull(5, 12);
/*      */       else {
/*  282 */         pstmt.setString(5, getState());
/*      */       }
/*  284 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  285 */         pstmt.setNull(6, 12);
/*      */       else {
/*  287 */         pstmt.setString(6, getVF01());
/*      */       }
/*  289 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  290 */         pstmt.setNull(7, 12);
/*      */       else {
/*  292 */         pstmt.setString(7, getNF01());
/*      */       }
/*  294 */       pstmt.setInt(8, getIF01());
/*  295 */       pstmt.setDouble(9, getDF02());
/*  296 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  297 */         pstmt.setNull(10, 91);
/*      */       else {
/*  299 */         pstmt.setDate(10, Date.valueOf(getDate01()));
/*      */       }
/*  301 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  302 */         pstmt.setNull(11, 12);
/*      */       else {
/*  304 */         pstmt.setString(11, getModifyOperator());
/*      */       }
/*  306 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  307 */         pstmt.setNull(12, 12);
/*      */       else {
/*  309 */         pstmt.setString(12, getOperator());
/*      */       }
/*  311 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  312 */         pstmt.setNull(13, 91);
/*      */       else {
/*  314 */         pstmt.setDate(13, Date.valueOf(getMakeDate()));
/*      */       }
/*  316 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  317 */         pstmt.setNull(14, 12);
/*      */       else {
/*  319 */         pstmt.setString(14, getMakeTime());
/*      */       }
/*  321 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  322 */         pstmt.setNull(15, 91);
/*      */       else {
/*  324 */         pstmt.setDate(15, Date.valueOf(getModifyDate()));
/*      */       }
/*  326 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  327 */         pstmt.setNull(16, 12);
/*      */       else {
/*  329 */         pstmt.setString(16, getModifyTime());
/*      */       }
/*      */ 
/*  332 */       pstmt.executeUpdate();
/*  333 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  336 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  337 */       CError tError = new CError();
/*  338 */       tError.moduleName = "MInvOptionDB";
/*  339 */       tError.functionName = "insert()";
/*  340 */       tError.errorMessage = ex.toString();
/*  341 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  344 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  347 */       if (!this.mflag)
/*      */         try {
/*  349 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  353 */       return false;
/*      */     }
/*      */ 
/*  356 */     if (!this.mflag)
/*      */       try {
/*  358 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  362 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  367 */     PreparedStatement pstmt = null;
/*  368 */     ResultSet rs = null;
/*      */ 
/*  370 */     if (!this.mflag) {
/*  371 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  376 */       pstmt = this.con.prepareStatement("SELECT * FROM MInvOption WHERE  OptionID = ?", 
/*  377 */         1003, 1007);
/*  378 */       if ((getOptionID() == null) || (getOptionID().equals("null")))
/*  379 */         pstmt.setNull(1, 12);
/*      */       else {
/*  381 */         pstmt.setString(1, getOptionID());
/*      */       }
/*  383 */       rs = pstmt.executeQuery();
/*  384 */       int i = 0;
/*  385 */       if (rs.next())
/*      */       {
/*  387 */         i++;
/*  388 */         if (!setSchema(rs, i))
/*      */         {
/*  391 */           CError tError = new CError();
/*  392 */           tError.moduleName = "MInvOptionDB";
/*  393 */           tError.functionName = "getInfo";
/*  394 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  395 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  397 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  400 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  404 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  408 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  412 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  415 */       if (i == 0)
/*      */       {
/*  417 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  421 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  425 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  431 */       CError tError = new CError();
/*  432 */       tError.moduleName = "MInvOptionDB";
/*  433 */       tError.functionName = "getInfo";
/*  434 */       tError.errorMessage = e.toString();
/*  435 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  437 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  440 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  444 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  448 */       return false;
/*      */     }
/*      */ 
/*  451 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  455 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  460 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvOptionSet query()
/*      */   {
/*  465 */     Statement stmt = null;
/*  466 */     ResultSet rs = null;
/*  467 */     MInvOptionSet aMInvOptionSet = new MInvOptionSet();
/*      */ 
/*  469 */     if (!this.mflag) {
/*  470 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  475 */       stmt = this.con.createStatement(1003, 1007);
/*  476 */       SQLString sqlObj = new SQLString("MInvOption");
/*  477 */       MInvOptionSchema aSchema = getSchema();
/*  478 */       sqlObj.setSQL(5, aSchema);
/*  479 */       String sql = sqlObj.getSQL();
/*      */ 
/*  481 */       rs = stmt.executeQuery(sql);
/*  482 */       int i = 0;
/*  483 */       while (rs.next())
/*      */       {
/*  485 */         i++;
/*  486 */         MInvOptionSchema s1 = new MInvOptionSchema();
/*  487 */         s1.setSchema(rs, i);
/*  488 */         aMInvOptionSet.add(s1);
/*      */       }try {
/*  490 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  496 */       CError tError = new CError();
/*  497 */       tError.moduleName = "MInvOptionDB";
/*  498 */       tError.functionName = "query";
/*  499 */       tError.errorMessage = e.toString();
/*  500 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  502 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  505 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  509 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  515 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  519 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  524 */     return aMInvOptionSet;
/*      */   }
/*      */ 
/*      */   public MInvOptionSet executeQuery(String sql)
/*      */   {
/*  529 */     Statement stmt = null;
/*  530 */     ResultSet rs = null;
/*  531 */     MInvOptionSet aMInvOptionSet = new MInvOptionSet();
/*      */ 
/*  533 */     if (!this.mflag) {
/*  534 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  539 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  541 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  542 */       int i = 0;
/*  543 */       while (rs.next())
/*      */       {
/*  545 */         i++;
/*  546 */         MInvOptionSchema s1 = new MInvOptionSchema();
/*  547 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  550 */           CError tError = new CError();
/*  551 */           tError.moduleName = "MInvOptionDB";
/*  552 */           tError.functionName = "executeQuery";
/*  553 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  554 */           this.mErrors.addOneError(tError);
/*      */         }
/*  556 */         aMInvOptionSet.add(s1);
/*      */       }try {
/*  558 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  564 */       CError tError = new CError();
/*  565 */       tError.moduleName = "MInvOptionDB";
/*  566 */       tError.functionName = "executeQuery";
/*  567 */       tError.errorMessage = e.toString();
/*  568 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  570 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  573 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  577 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  583 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  587 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  592 */     return aMInvOptionSet;
/*      */   }
/*      */ 
/*      */   public MInvOptionSet query(int nStart, int nCount)
/*      */   {
/*  597 */     Statement stmt = null;
/*  598 */     ResultSet rs = null;
/*  599 */     MInvOptionSet aMInvOptionSet = new MInvOptionSet();
/*      */ 
/*  601 */     if (!this.mflag) {
/*  602 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  607 */       stmt = this.con.createStatement(1003, 1007);
/*  608 */       SQLString sqlObj = new SQLString("MInvOption");
/*  609 */       MInvOptionSchema aSchema = getSchema();
/*  610 */       sqlObj.setSQL(5, aSchema);
/*  611 */       String sql = sqlObj.getSQL();
/*      */ 
/*  613 */       rs = stmt.executeQuery(sql);
/*  614 */       int i = 0;
/*  615 */       while (rs.next())
/*      */       {
/*  617 */         i++;
/*      */ 
/*  619 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  623 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  627 */         MInvOptionSchema s1 = new MInvOptionSchema();
/*  628 */         s1.setSchema(rs, i);
/*  629 */         aMInvOptionSet.add(s1);
/*      */       }try {
/*  631 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  637 */       CError tError = new CError();
/*  638 */       tError.moduleName = "MInvOptionDB";
/*  639 */       tError.functionName = "query";
/*  640 */       tError.errorMessage = e.toString();
/*  641 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  643 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  646 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  650 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  656 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  660 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  665 */     return aMInvOptionSet;
/*      */   }
/*      */ 
/*      */   public MInvOptionSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  670 */     Statement stmt = null;
/*  671 */     ResultSet rs = null;
/*  672 */     MInvOptionSet aMInvOptionSet = new MInvOptionSet();
/*      */ 
/*  674 */     if (!this.mflag) {
/*  675 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  680 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  682 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  683 */       int i = 0;
/*  684 */       while (rs.next())
/*      */       {
/*  686 */         i++;
/*      */ 
/*  688 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  692 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  696 */         MInvOptionSchema s1 = new MInvOptionSchema();
/*  697 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  700 */           CError tError = new CError();
/*  701 */           tError.moduleName = "MInvOptionDB";
/*  702 */           tError.functionName = "executeQuery";
/*  703 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  704 */           this.mErrors.addOneError(tError);
/*      */         }
/*  706 */         aMInvOptionSet.add(s1);
/*      */       }try {
/*  708 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  714 */       CError tError = new CError();
/*  715 */       tError.moduleName = "MInvOptionDB";
/*  716 */       tError.functionName = "executeQuery";
/*  717 */       tError.errorMessage = e.toString();
/*  718 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  720 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  723 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  727 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  733 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  737 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  742 */     return aMInvOptionSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  747 */     Statement stmt = null;
/*      */ 
/*  749 */     if (!this.mflag) {
/*  750 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  755 */       stmt = this.con.createStatement(1003, 1007);
/*  756 */       SQLString sqlObj = new SQLString("MInvOption");
/*  757 */       MInvOptionSchema aSchema = getSchema();
/*  758 */       sqlObj.setSQL(2, aSchema);
/*  759 */       String sql = "update MInvOption " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  761 */       int operCount = stmt.executeUpdate(sql);
/*  762 */       if (operCount == 0)
/*      */       {
/*  765 */         CError tError = new CError();
/*  766 */         tError.moduleName = "MInvOptionDB";
/*  767 */         tError.functionName = "update";
/*  768 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  769 */         this.mErrors.addOneError(tError);
/*      */ 
/*  771 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  775 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  779 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  785 */       CError tError = new CError();
/*  786 */       tError.moduleName = "MInvOptionDB";
/*  787 */       tError.functionName = "update";
/*  788 */       tError.errorMessage = e.toString();
/*  789 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  791 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  793 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  797 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  801 */       return false;
/*      */     }
/*      */ 
/*  804 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  808 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  813 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  819 */     if (this.mResultSet != null)
/*      */     {
/*  822 */       CError tError = new CError();
/*  823 */       tError.moduleName = "MInvOptionDB";
/*  824 */       tError.functionName = "prepareData";
/*  825 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  826 */       this.mErrors.addOneError(tError);
/*  827 */       return false;
/*      */     }
/*      */ 
/*  830 */     if (!this.mflag)
/*      */     {
/*  832 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  836 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  837 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  842 */       CError tError = new CError();
/*  843 */       tError.moduleName = "MInvOptionDB";
/*  844 */       tError.functionName = "prepareData";
/*  845 */       tError.errorMessage = e.toString();
/*  846 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  849 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  855 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  859 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  863 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  868 */       return false;
/*      */     }
/*      */ 
/*  871 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  875 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  880 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  886 */     boolean flag = true;
/*  887 */     if (this.mResultSet == null)
/*      */     {
/*  889 */       CError tError = new CError();
/*  890 */       tError.moduleName = "MInvOptionDB";
/*  891 */       tError.functionName = "hasMoreData";
/*  892 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  893 */       this.mErrors.addOneError(tError);
/*  894 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  898 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  902 */       CError tError = new CError();
/*  903 */       tError.moduleName = "MInvOptionDB";
/*  904 */       tError.functionName = "hasMoreData";
/*  905 */       tError.errorMessage = ex.toString();
/*  906 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  909 */         this.mResultSet.close();
/*  910 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  916 */         this.mStatement.close();
/*  917 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  921 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  925 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  930 */       return false;
/*      */     }
/*  932 */     return flag;
/*      */   }
/*      */ 
/*      */   public MInvOptionSet getData()
/*      */   {
/*  937 */     int tCount = 0;
/*  938 */     MInvOptionSet tMInvOptionSet = new MInvOptionSet();
/*  939 */     MInvOptionSchema tMInvOptionSchema = null;
/*  940 */     if (this.mResultSet == null)
/*      */     {
/*  942 */       CError tError = new CError();
/*  943 */       tError.moduleName = "MInvOptionDB";
/*  944 */       tError.functionName = "getData";
/*  945 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  946 */       this.mErrors.addOneError(tError);
/*  947 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  951 */       tCount = 1;
/*  952 */       tMInvOptionSchema = new MInvOptionSchema();
/*  953 */       tMInvOptionSchema.setSchema(this.mResultSet, 1);
/*  954 */       tMInvOptionSet.add(tMInvOptionSchema);
/*      */ 
/*  956 */       while (tCount++ < 5000)
/*      */       {
/*  958 */         if (!this.mResultSet.next())
/*      */           continue;
/*  960 */         tMInvOptionSchema = new MInvOptionSchema();
/*  961 */         tMInvOptionSchema.setSchema(this.mResultSet, 1);
/*  962 */         tMInvOptionSet.add(tMInvOptionSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  968 */       CError tError = new CError();
/*  969 */       tError.moduleName = "MInvOptionDB";
/*  970 */       tError.functionName = "getData";
/*  971 */       tError.errorMessage = ex.toString();
/*  972 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  975 */         this.mResultSet.close();
/*  976 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  982 */         this.mStatement.close();
/*  983 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  987 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  991 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  996 */       return null;
/*      */     }
/*  998 */     return tMInvOptionSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1003 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1006 */       if (this.mResultSet == null)
/*      */       {
/* 1008 */         CError tError = new CError();
/* 1009 */         tError.moduleName = "MInvOptionDB";
/* 1010 */         tError.functionName = "closeData";
/* 1011 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1012 */         this.mErrors.addOneError(tError);
/* 1013 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1017 */         this.mResultSet.close();
/* 1018 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1023 */       CError tError = new CError();
/* 1024 */       tError.moduleName = "MInvOptionDB";
/* 1025 */       tError.functionName = "closeData";
/* 1026 */       tError.errorMessage = ex2.toString();
/* 1027 */       this.mErrors.addOneError(tError);
/* 1028 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1032 */       if (this.mStatement == null)
/*      */       {
/* 1034 */         CError tError = new CError();
/* 1035 */         tError.moduleName = "MInvOptionDB";
/* 1036 */         tError.functionName = "closeData";
/* 1037 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1038 */         this.mErrors.addOneError(tError);
/* 1039 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1043 */         this.mStatement.close();
/* 1044 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1049 */       CError tError = new CError();
/* 1050 */       tError.moduleName = "MInvOptionDB";
/* 1051 */       tError.functionName = "closeData";
/* 1052 */       tError.errorMessage = ex3.toString();
/* 1053 */       this.mErrors.addOneError(tError);
/* 1054 */       flag = false;
/*      */     }
/* 1056 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MInvOptionDB
 * JD-Core Version:    0.6.0
 */