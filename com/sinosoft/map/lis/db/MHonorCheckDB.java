/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MHonorCheckSchema;
/*      */ import com.sinosoft.map.lis.vschema.MHonorCheckSet;
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
/*      */ public class MHonorCheckDB extends MHonorCheckSchema
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
/*      */   public MHonorCheckDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MHonorCheck");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MHonorCheckDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MHonorCheck");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MHonorCheckSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MHonorCheckDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MHonorCheckSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MHonorCheckDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MHonorCheck WHERE  CheckID = ?");
/*   96 */       if ((getCheckID() == null) || (getCheckID().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getCheckID());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MHonorCheckDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MHonorCheck SET  CheckID = ? , DataType = ? , StatYear = ? , ManageCom = ? , BranchType = ? , StatBatch = ? , StartDate = ? , EndDate = ? , CheckState = ? , InputState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  CheckID = ?");
/*  145 */       if ((getCheckID() == null) || (getCheckID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getCheckID());
/*      */       }
/*  150 */       if ((getDataType() == null) || (getDataType().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getDataType());
/*      */       }
/*  155 */       if ((getStatYear() == null) || (getStatYear().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getStatYear());
/*      */       }
/*  160 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getManageCom());
/*      */       }
/*  165 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getBranchType());
/*      */       }
/*  170 */       if ((getStatBatch() == null) || (getStatBatch().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getStatBatch());
/*      */       }
/*  175 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  176 */         pstmt.setNull(7, 91);
/*      */       else {
/*  178 */         pstmt.setDate(7, Date.valueOf(getStartDate()));
/*      */       }
/*  180 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  181 */         pstmt.setNull(8, 91);
/*      */       else {
/*  183 */         pstmt.setDate(8, Date.valueOf(getEndDate()));
/*      */       }
/*  185 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getCheckState());
/*      */       }
/*  190 */       if ((getInputState() == null) || (getInputState().equals("null")))
/*  191 */         pstmt.setNull(10, 12);
/*      */       else {
/*  193 */         pstmt.setString(10, getInputState());
/*      */       }
/*  195 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  196 */         pstmt.setNull(11, 12);
/*      */       else {
/*  198 */         pstmt.setString(11, getCheckOperator());
/*      */       }
/*  200 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  201 */         pstmt.setNull(12, 12);
/*      */       else {
/*  203 */         pstmt.setString(12, getCheckReason());
/*      */       }
/*  205 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  206 */         pstmt.setNull(13, 91);
/*      */       else {
/*  208 */         pstmt.setDate(13, Date.valueOf(getCheckDate()));
/*      */       }
/*  210 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  211 */         pstmt.setNull(14, 12);
/*      */       else {
/*  213 */         pstmt.setString(14, getCheckTime());
/*      */       }
/*  215 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  216 */         pstmt.setNull(15, 12);
/*      */       else {
/*  218 */         pstmt.setString(15, getModifyOperator());
/*      */       }
/*  220 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  221 */         pstmt.setNull(16, 12);
/*      */       else {
/*  223 */         pstmt.setString(16, getOperator());
/*      */       }
/*  225 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  226 */         pstmt.setNull(17, 91);
/*      */       else {
/*  228 */         pstmt.setDate(17, Date.valueOf(getMakeDate()));
/*      */       }
/*  230 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  231 */         pstmt.setNull(18, 12);
/*      */       else {
/*  233 */         pstmt.setString(18, getMakeTime());
/*      */       }
/*  235 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  236 */         pstmt.setNull(19, 91);
/*      */       else {
/*  238 */         pstmt.setDate(19, Date.valueOf(getModifyDate()));
/*      */       }
/*  240 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  241 */         pstmt.setNull(20, 12);
/*      */       else {
/*  243 */         pstmt.setString(20, getModifyTime());
/*      */       }
/*      */ 
/*  246 */       if ((getCheckID() == null) || (getCheckID().equals("null")))
/*  247 */         pstmt.setNull(21, 12);
/*      */       else {
/*  249 */         pstmt.setString(21, getCheckID());
/*      */       }
/*  251 */       pstmt.executeUpdate();
/*  252 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  255 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  256 */       CError tError = new CError();
/*  257 */       tError.moduleName = "MHonorCheckDB";
/*  258 */       tError.functionName = "update()";
/*  259 */       tError.errorMessage = ex.toString();
/*  260 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  263 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  266 */       if (!this.mflag)
/*      */         try {
/*  268 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  272 */       return false;
/*      */     }
/*      */ 
/*  275 */     if (!this.mflag)
/*      */       try {
/*  277 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  281 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  286 */     PreparedStatement pstmt = null;
/*      */ 
/*  288 */     if (!this.mflag) {
/*  289 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  294 */       pstmt = this.con.prepareStatement("INSERT INTO MHonorCheck VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  295 */       if ((getCheckID() == null) || (getCheckID().equals("null")))
/*  296 */         pstmt.setNull(1, 12);
/*      */       else {
/*  298 */         pstmt.setString(1, getCheckID());
/*      */       }
/*  300 */       if ((getDataType() == null) || (getDataType().equals("null")))
/*  301 */         pstmt.setNull(2, 12);
/*      */       else {
/*  303 */         pstmt.setString(2, getDataType());
/*      */       }
/*  305 */       if ((getStatYear() == null) || (getStatYear().equals("null")))
/*  306 */         pstmt.setNull(3, 12);
/*      */       else {
/*  308 */         pstmt.setString(3, getStatYear());
/*      */       }
/*  310 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  311 */         pstmt.setNull(4, 12);
/*      */       else {
/*  313 */         pstmt.setString(4, getManageCom());
/*      */       }
/*  315 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  316 */         pstmt.setNull(5, 12);
/*      */       else {
/*  318 */         pstmt.setString(5, getBranchType());
/*      */       }
/*  320 */       if ((getStatBatch() == null) || (getStatBatch().equals("null")))
/*  321 */         pstmt.setNull(6, 12);
/*      */       else {
/*  323 */         pstmt.setString(6, getStatBatch());
/*      */       }
/*  325 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  326 */         pstmt.setNull(7, 91);
/*      */       else {
/*  328 */         pstmt.setDate(7, Date.valueOf(getStartDate()));
/*      */       }
/*  330 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  331 */         pstmt.setNull(8, 91);
/*      */       else {
/*  333 */         pstmt.setDate(8, Date.valueOf(getEndDate()));
/*      */       }
/*  335 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  336 */         pstmt.setNull(9, 12);
/*      */       else {
/*  338 */         pstmt.setString(9, getCheckState());
/*      */       }
/*  340 */       if ((getInputState() == null) || (getInputState().equals("null")))
/*  341 */         pstmt.setNull(10, 12);
/*      */       else {
/*  343 */         pstmt.setString(10, getInputState());
/*      */       }
/*  345 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  346 */         pstmt.setNull(11, 12);
/*      */       else {
/*  348 */         pstmt.setString(11, getCheckOperator());
/*      */       }
/*  350 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  351 */         pstmt.setNull(12, 12);
/*      */       else {
/*  353 */         pstmt.setString(12, getCheckReason());
/*      */       }
/*  355 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  356 */         pstmt.setNull(13, 91);
/*      */       else {
/*  358 */         pstmt.setDate(13, Date.valueOf(getCheckDate()));
/*      */       }
/*  360 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  361 */         pstmt.setNull(14, 12);
/*      */       else {
/*  363 */         pstmt.setString(14, getCheckTime());
/*      */       }
/*  365 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  366 */         pstmt.setNull(15, 12);
/*      */       else {
/*  368 */         pstmt.setString(15, getModifyOperator());
/*      */       }
/*  370 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  371 */         pstmt.setNull(16, 12);
/*      */       else {
/*  373 */         pstmt.setString(16, getOperator());
/*      */       }
/*  375 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  376 */         pstmt.setNull(17, 91);
/*      */       else {
/*  378 */         pstmt.setDate(17, Date.valueOf(getMakeDate()));
/*      */       }
/*  380 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  381 */         pstmt.setNull(18, 12);
/*      */       else {
/*  383 */         pstmt.setString(18, getMakeTime());
/*      */       }
/*  385 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  386 */         pstmt.setNull(19, 91);
/*      */       else {
/*  388 */         pstmt.setDate(19, Date.valueOf(getModifyDate()));
/*      */       }
/*  390 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  391 */         pstmt.setNull(20, 12);
/*      */       else {
/*  393 */         pstmt.setString(20, getModifyTime());
/*      */       }
/*      */ 
/*  396 */       pstmt.executeUpdate();
/*  397 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  400 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  401 */       CError tError = new CError();
/*  402 */       tError.moduleName = "MHonorCheckDB";
/*  403 */       tError.functionName = "insert()";
/*  404 */       tError.errorMessage = ex.toString();
/*  405 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  408 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  411 */       if (!this.mflag)
/*      */         try {
/*  413 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  417 */       return false;
/*      */     }
/*      */ 
/*  420 */     if (!this.mflag)
/*      */       try {
/*  422 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  426 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  431 */     PreparedStatement pstmt = null;
/*  432 */     ResultSet rs = null;
/*      */ 
/*  434 */     if (!this.mflag) {
/*  435 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  440 */       pstmt = this.con.prepareStatement("SELECT * FROM MHonorCheck WHERE  CheckID = ?", 
/*  441 */         1003, 1007);
/*  442 */       if ((getCheckID() == null) || (getCheckID().equals("null")))
/*  443 */         pstmt.setNull(1, 12);
/*      */       else {
/*  445 */         pstmt.setString(1, getCheckID());
/*      */       }
/*  447 */       rs = pstmt.executeQuery();
/*  448 */       int i = 0;
/*  449 */       if (rs.next())
/*      */       {
/*  451 */         i++;
/*  452 */         if (!setSchema(rs, i))
/*      */         {
/*  455 */           CError tError = new CError();
/*  456 */           tError.moduleName = "MHonorCheckDB";
/*  457 */           tError.functionName = "getInfo";
/*  458 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  459 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  461 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  464 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  468 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  472 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  476 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  479 */       if (i == 0)
/*      */       {
/*  481 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  485 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  489 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  495 */       CError tError = new CError();
/*  496 */       tError.moduleName = "MHonorCheckDB";
/*  497 */       tError.functionName = "getInfo";
/*  498 */       tError.errorMessage = e.toString();
/*  499 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  501 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  504 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  508 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  512 */       return false;
/*      */     }
/*      */ 
/*  515 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  519 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  524 */     return true;
/*      */   }
/*      */ 
/*      */   public MHonorCheckSet query()
/*      */   {
/*  529 */     Statement stmt = null;
/*  530 */     ResultSet rs = null;
/*  531 */     MHonorCheckSet aMHonorCheckSet = new MHonorCheckSet();
/*      */ 
/*  533 */     if (!this.mflag) {
/*  534 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  539 */       stmt = this.con.createStatement(1003, 1007);
/*  540 */       SQLString sqlObj = new SQLString("MHonorCheck");
/*  541 */       MHonorCheckSchema aSchema = getSchema();
/*  542 */       sqlObj.setSQL(5, aSchema);
/*  543 */       String sql = sqlObj.getSQL();
/*      */ 
/*  545 */       rs = stmt.executeQuery(sql);
/*  546 */       int i = 0;
/*  547 */       while (rs.next())
/*      */       {
/*  549 */         i++;
/*  550 */         MHonorCheckSchema s1 = new MHonorCheckSchema();
/*  551 */         s1.setSchema(rs, i);
/*  552 */         aMHonorCheckSet.add(s1);
/*      */       }try {
/*  554 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  560 */       CError tError = new CError();
/*  561 */       tError.moduleName = "MHonorCheckDB";
/*  562 */       tError.functionName = "query";
/*  563 */       tError.errorMessage = e.toString();
/*  564 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  566 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  569 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  573 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  579 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  583 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  588 */     return aMHonorCheckSet;
/*      */   }
/*      */ 
/*      */   public MHonorCheckSet executeQuery(String sql)
/*      */   {
/*  593 */     Statement stmt = null;
/*  594 */     ResultSet rs = null;
/*  595 */     MHonorCheckSet aMHonorCheckSet = new MHonorCheckSet();
/*      */ 
/*  597 */     if (!this.mflag) {
/*  598 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  603 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  605 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  606 */       int i = 0;
/*  607 */       while (rs.next())
/*      */       {
/*  609 */         i++;
/*  610 */         MHonorCheckSchema s1 = new MHonorCheckSchema();
/*  611 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  614 */           CError tError = new CError();
/*  615 */           tError.moduleName = "MHonorCheckDB";
/*  616 */           tError.functionName = "executeQuery";
/*  617 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  618 */           this.mErrors.addOneError(tError);
/*      */         }
/*  620 */         aMHonorCheckSet.add(s1);
/*      */       }try {
/*  622 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  628 */       CError tError = new CError();
/*  629 */       tError.moduleName = "MHonorCheckDB";
/*  630 */       tError.functionName = "executeQuery";
/*  631 */       tError.errorMessage = e.toString();
/*  632 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  634 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  637 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  641 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  647 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  651 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  656 */     return aMHonorCheckSet;
/*      */   }
/*      */ 
/*      */   public MHonorCheckSet query(int nStart, int nCount)
/*      */   {
/*  661 */     Statement stmt = null;
/*  662 */     ResultSet rs = null;
/*  663 */     MHonorCheckSet aMHonorCheckSet = new MHonorCheckSet();
/*      */ 
/*  665 */     if (!this.mflag) {
/*  666 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  671 */       stmt = this.con.createStatement(1003, 1007);
/*  672 */       SQLString sqlObj = new SQLString("MHonorCheck");
/*  673 */       MHonorCheckSchema aSchema = getSchema();
/*  674 */       sqlObj.setSQL(5, aSchema);
/*  675 */       String sql = sqlObj.getSQL();
/*      */ 
/*  677 */       rs = stmt.executeQuery(sql);
/*  678 */       int i = 0;
/*  679 */       while (rs.next())
/*      */       {
/*  681 */         i++;
/*      */ 
/*  683 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  687 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  691 */         MHonorCheckSchema s1 = new MHonorCheckSchema();
/*  692 */         s1.setSchema(rs, i);
/*  693 */         aMHonorCheckSet.add(s1);
/*      */       }try {
/*  695 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  701 */       CError tError = new CError();
/*  702 */       tError.moduleName = "MHonorCheckDB";
/*  703 */       tError.functionName = "query";
/*  704 */       tError.errorMessage = e.toString();
/*  705 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  707 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  710 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  714 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  720 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  724 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  729 */     return aMHonorCheckSet;
/*      */   }
/*      */ 
/*      */   public MHonorCheckSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  734 */     Statement stmt = null;
/*  735 */     ResultSet rs = null;
/*  736 */     MHonorCheckSet aMHonorCheckSet = new MHonorCheckSet();
/*      */ 
/*  738 */     if (!this.mflag) {
/*  739 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  744 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  746 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  747 */       int i = 0;
/*  748 */       while (rs.next())
/*      */       {
/*  750 */         i++;
/*      */ 
/*  752 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  756 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  760 */         MHonorCheckSchema s1 = new MHonorCheckSchema();
/*  761 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  764 */           CError tError = new CError();
/*  765 */           tError.moduleName = "MHonorCheckDB";
/*  766 */           tError.functionName = "executeQuery";
/*  767 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  768 */           this.mErrors.addOneError(tError);
/*      */         }
/*  770 */         aMHonorCheckSet.add(s1);
/*      */       }try {
/*  772 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  778 */       CError tError = new CError();
/*  779 */       tError.moduleName = "MHonorCheckDB";
/*  780 */       tError.functionName = "executeQuery";
/*  781 */       tError.errorMessage = e.toString();
/*  782 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  784 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  787 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  791 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  797 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  801 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  806 */     return aMHonorCheckSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  811 */     Statement stmt = null;
/*      */ 
/*  813 */     if (!this.mflag) {
/*  814 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  819 */       stmt = this.con.createStatement(1003, 1007);
/*  820 */       SQLString sqlObj = new SQLString("MHonorCheck");
/*  821 */       MHonorCheckSchema aSchema = getSchema();
/*  822 */       sqlObj.setSQL(2, aSchema);
/*  823 */       String sql = "update MHonorCheck " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  825 */       int operCount = stmt.executeUpdate(sql);
/*  826 */       if (operCount == 0)
/*      */       {
/*  829 */         CError tError = new CError();
/*  830 */         tError.moduleName = "MHonorCheckDB";
/*  831 */         tError.functionName = "update";
/*  832 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  833 */         this.mErrors.addOneError(tError);
/*      */ 
/*  835 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  839 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  843 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  849 */       CError tError = new CError();
/*  850 */       tError.moduleName = "MHonorCheckDB";
/*  851 */       tError.functionName = "update";
/*  852 */       tError.errorMessage = e.toString();
/*  853 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  855 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  857 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  861 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  865 */       return false;
/*      */     }
/*      */ 
/*  868 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  872 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  877 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  883 */     if (this.mResultSet != null)
/*      */     {
/*  886 */       CError tError = new CError();
/*  887 */       tError.moduleName = "MHonorCheckDB";
/*  888 */       tError.functionName = "prepareData";
/*  889 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  890 */       this.mErrors.addOneError(tError);
/*  891 */       return false;
/*      */     }
/*      */ 
/*  894 */     if (!this.mflag)
/*      */     {
/*  896 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  900 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  901 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  906 */       CError tError = new CError();
/*  907 */       tError.moduleName = "MHonorCheckDB";
/*  908 */       tError.functionName = "prepareData";
/*  909 */       tError.errorMessage = e.toString();
/*  910 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  913 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  919 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  923 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  927 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  932 */       return false;
/*      */     }
/*      */ 
/*  935 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  939 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  944 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  950 */     boolean flag = true;
/*  951 */     if (this.mResultSet == null)
/*      */     {
/*  953 */       CError tError = new CError();
/*  954 */       tError.moduleName = "MHonorCheckDB";
/*  955 */       tError.functionName = "hasMoreData";
/*  956 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  957 */       this.mErrors.addOneError(tError);
/*  958 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  962 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  966 */       CError tError = new CError();
/*  967 */       tError.moduleName = "MHonorCheckDB";
/*  968 */       tError.functionName = "hasMoreData";
/*  969 */       tError.errorMessage = ex.toString();
/*  970 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  973 */         this.mResultSet.close();
/*  974 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  980 */         this.mStatement.close();
/*  981 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  985 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  989 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  994 */       return false;
/*      */     }
/*  996 */     return flag;
/*      */   }
/*      */ 
/*      */   public MHonorCheckSet getData()
/*      */   {
/* 1001 */     int tCount = 0;
/* 1002 */     MHonorCheckSet tMHonorCheckSet = new MHonorCheckSet();
/* 1003 */     MHonorCheckSchema tMHonorCheckSchema = null;
/* 1004 */     if (this.mResultSet == null)
/*      */     {
/* 1006 */       CError tError = new CError();
/* 1007 */       tError.moduleName = "MHonorCheckDB";
/* 1008 */       tError.functionName = "getData";
/* 1009 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1010 */       this.mErrors.addOneError(tError);
/* 1011 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1015 */       tCount = 1;
/* 1016 */       tMHonorCheckSchema = new MHonorCheckSchema();
/* 1017 */       tMHonorCheckSchema.setSchema(this.mResultSet, 1);
/* 1018 */       tMHonorCheckSet.add(tMHonorCheckSchema);
/*      */ 
/* 1020 */       while (tCount++ < 5000)
/*      */       {
/* 1022 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1024 */         tMHonorCheckSchema = new MHonorCheckSchema();
/* 1025 */         tMHonorCheckSchema.setSchema(this.mResultSet, 1);
/* 1026 */         tMHonorCheckSet.add(tMHonorCheckSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1032 */       CError tError = new CError();
/* 1033 */       tError.moduleName = "MHonorCheckDB";
/* 1034 */       tError.functionName = "getData";
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
/* 1060 */       return null;
/*      */     }
/* 1062 */     return tMHonorCheckSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1067 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1070 */       if (this.mResultSet == null)
/*      */       {
/* 1072 */         CError tError = new CError();
/* 1073 */         tError.moduleName = "MHonorCheckDB";
/* 1074 */         tError.functionName = "closeData";
/* 1075 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1076 */         this.mErrors.addOneError(tError);
/* 1077 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1081 */         this.mResultSet.close();
/* 1082 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1087 */       CError tError = new CError();
/* 1088 */       tError.moduleName = "MHonorCheckDB";
/* 1089 */       tError.functionName = "closeData";
/* 1090 */       tError.errorMessage = ex2.toString();
/* 1091 */       this.mErrors.addOneError(tError);
/* 1092 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1096 */       if (this.mStatement == null)
/*      */       {
/* 1098 */         CError tError = new CError();
/* 1099 */         tError.moduleName = "MHonorCheckDB";
/* 1100 */         tError.functionName = "closeData";
/* 1101 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1102 */         this.mErrors.addOneError(tError);
/* 1103 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1107 */         this.mStatement.close();
/* 1108 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1113 */       CError tError = new CError();
/* 1114 */       tError.moduleName = "MHonorCheckDB";
/* 1115 */       tError.functionName = "closeData";
/* 1116 */       tError.errorMessage = ex3.toString();
/* 1117 */       this.mErrors.addOneError(tError);
/* 1118 */       flag = false;
/*      */     }
/* 1120 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MHonorCheckDB
 * JD-Core Version:    0.6.0
 */