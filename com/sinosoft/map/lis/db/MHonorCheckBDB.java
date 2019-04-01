/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MHonorCheckBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MHonorCheckBSet;
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
/*      */ public class MHonorCheckBDB extends MHonorCheckBSchema
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
/*      */   public MHonorCheckBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MHonorCheckB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MHonorCheckBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MHonorCheckB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MHonorCheckBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MHonorCheckBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MHonorCheckBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MHonorCheckBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MHonorCheckB WHERE  EdorNo = ?");
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
/*  107 */       tError.moduleName = "MHonorCheckBDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MHonorCheckB SET  CheckID = ? , DataType = ? , StatYear = ? , StatBatch = ? , ManageCom = ? , BranchType = ? , StartDate = ? , EndDate = ? , CheckState = ? , InputState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  EdorNo = ?");
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
/*  160 */       if ((getStatBatch() == null) || (getStatBatch().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getStatBatch());
/*      */       }
/*  165 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  170 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getBranchType());
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
/*  215 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  216 */         pstmt.setNull(15, 12);
/*      */       else {
/*  218 */         pstmt.setString(15, getEdorNo());
/*      */       }
/*  220 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  221 */         pstmt.setNull(16, 12);
/*      */       else {
/*  223 */         pstmt.setString(16, getEdorType());
/*      */       }
/*  225 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  226 */         pstmt.setNull(17, 12);
/*      */       else {
/*  228 */         pstmt.setString(17, getEdorCase());
/*      */       }
/*  230 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  231 */         pstmt.setNull(18, 12);
/*      */       else {
/*  233 */         pstmt.setString(18, getOperator2());
/*      */       }
/*  235 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  236 */         pstmt.setNull(19, 91);
/*      */       else {
/*  238 */         pstmt.setDate(19, Date.valueOf(getMakeDate2()));
/*      */       }
/*  240 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  241 */         pstmt.setNull(20, 12);
/*      */       else {
/*  243 */         pstmt.setString(20, getMakeTime2());
/*      */       }
/*  245 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  246 */         pstmt.setNull(21, 12);
/*      */       else {
/*  248 */         pstmt.setString(21, getModifyOperator());
/*      */       }
/*  250 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  251 */         pstmt.setNull(22, 12);
/*      */       else {
/*  253 */         pstmt.setString(22, getOperator());
/*      */       }
/*  255 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  256 */         pstmt.setNull(23, 91);
/*      */       else {
/*  258 */         pstmt.setDate(23, Date.valueOf(getMakeDate()));
/*      */       }
/*  260 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  261 */         pstmt.setNull(24, 12);
/*      */       else {
/*  263 */         pstmt.setString(24, getMakeTime());
/*      */       }
/*  265 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  266 */         pstmt.setNull(25, 91);
/*      */       else {
/*  268 */         pstmt.setDate(25, Date.valueOf(getModifyDate()));
/*      */       }
/*  270 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  271 */         pstmt.setNull(26, 12);
/*      */       else {
/*  273 */         pstmt.setString(26, getModifyTime());
/*      */       }
/*      */ 
/*  276 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  277 */         pstmt.setNull(27, 12);
/*      */       else {
/*  279 */         pstmt.setString(27, getEdorNo());
/*      */       }
/*  281 */       pstmt.executeUpdate();
/*  282 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  285 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  286 */       CError tError = new CError();
/*  287 */       tError.moduleName = "MHonorCheckBDB";
/*  288 */       tError.functionName = "update()";
/*  289 */       tError.errorMessage = ex.toString();
/*  290 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  293 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  296 */       if (!this.mflag)
/*      */         try {
/*  298 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  302 */       return false;
/*      */     }
/*      */ 
/*  305 */     if (!this.mflag)
/*      */       try {
/*  307 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  311 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  316 */     PreparedStatement pstmt = null;
/*      */ 
/*  318 */     if (!this.mflag) {
/*  319 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  324 */       pstmt = this.con.prepareStatement("INSERT INTO MHonorCheckB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  325 */       if ((getCheckID() == null) || (getCheckID().equals("null")))
/*  326 */         pstmt.setNull(1, 12);
/*      */       else {
/*  328 */         pstmt.setString(1, getCheckID());
/*      */       }
/*  330 */       if ((getDataType() == null) || (getDataType().equals("null")))
/*  331 */         pstmt.setNull(2, 12);
/*      */       else {
/*  333 */         pstmt.setString(2, getDataType());
/*      */       }
/*  335 */       if ((getStatYear() == null) || (getStatYear().equals("null")))
/*  336 */         pstmt.setNull(3, 12);
/*      */       else {
/*  338 */         pstmt.setString(3, getStatYear());
/*      */       }
/*  340 */       if ((getStatBatch() == null) || (getStatBatch().equals("null")))
/*  341 */         pstmt.setNull(4, 12);
/*      */       else {
/*  343 */         pstmt.setString(4, getStatBatch());
/*      */       }
/*  345 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  346 */         pstmt.setNull(5, 12);
/*      */       else {
/*  348 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  350 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  351 */         pstmt.setNull(6, 12);
/*      */       else {
/*  353 */         pstmt.setString(6, getBranchType());
/*      */       }
/*  355 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  356 */         pstmt.setNull(7, 91);
/*      */       else {
/*  358 */         pstmt.setDate(7, Date.valueOf(getStartDate()));
/*      */       }
/*  360 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  361 */         pstmt.setNull(8, 91);
/*      */       else {
/*  363 */         pstmt.setDate(8, Date.valueOf(getEndDate()));
/*      */       }
/*  365 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  366 */         pstmt.setNull(9, 12);
/*      */       else {
/*  368 */         pstmt.setString(9, getCheckState());
/*      */       }
/*  370 */       if ((getInputState() == null) || (getInputState().equals("null")))
/*  371 */         pstmt.setNull(10, 12);
/*      */       else {
/*  373 */         pstmt.setString(10, getInputState());
/*      */       }
/*  375 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  376 */         pstmt.setNull(11, 12);
/*      */       else {
/*  378 */         pstmt.setString(11, getCheckOperator());
/*      */       }
/*  380 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  381 */         pstmt.setNull(12, 12);
/*      */       else {
/*  383 */         pstmt.setString(12, getCheckReason());
/*      */       }
/*  385 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  386 */         pstmt.setNull(13, 91);
/*      */       else {
/*  388 */         pstmt.setDate(13, Date.valueOf(getCheckDate()));
/*      */       }
/*  390 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  391 */         pstmt.setNull(14, 12);
/*      */       else {
/*  393 */         pstmt.setString(14, getCheckTime());
/*      */       }
/*  395 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  396 */         pstmt.setNull(15, 12);
/*      */       else {
/*  398 */         pstmt.setString(15, getEdorNo());
/*      */       }
/*  400 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  401 */         pstmt.setNull(16, 12);
/*      */       else {
/*  403 */         pstmt.setString(16, getEdorType());
/*      */       }
/*  405 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  406 */         pstmt.setNull(17, 12);
/*      */       else {
/*  408 */         pstmt.setString(17, getEdorCase());
/*      */       }
/*  410 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  411 */         pstmt.setNull(18, 12);
/*      */       else {
/*  413 */         pstmt.setString(18, getOperator2());
/*      */       }
/*  415 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  416 */         pstmt.setNull(19, 91);
/*      */       else {
/*  418 */         pstmt.setDate(19, Date.valueOf(getMakeDate2()));
/*      */       }
/*  420 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  421 */         pstmt.setNull(20, 12);
/*      */       else {
/*  423 */         pstmt.setString(20, getMakeTime2());
/*      */       }
/*  425 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  426 */         pstmt.setNull(21, 12);
/*      */       else {
/*  428 */         pstmt.setString(21, getModifyOperator());
/*      */       }
/*  430 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  431 */         pstmt.setNull(22, 12);
/*      */       else {
/*  433 */         pstmt.setString(22, getOperator());
/*      */       }
/*  435 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  436 */         pstmt.setNull(23, 91);
/*      */       else {
/*  438 */         pstmt.setDate(23, Date.valueOf(getMakeDate()));
/*      */       }
/*  440 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  441 */         pstmt.setNull(24, 12);
/*      */       else {
/*  443 */         pstmt.setString(24, getMakeTime());
/*      */       }
/*  445 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  446 */         pstmt.setNull(25, 91);
/*      */       else {
/*  448 */         pstmt.setDate(25, Date.valueOf(getModifyDate()));
/*      */       }
/*  450 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  451 */         pstmt.setNull(26, 12);
/*      */       else {
/*  453 */         pstmt.setString(26, getModifyTime());
/*      */       }
/*      */ 
/*  456 */       pstmt.executeUpdate();
/*  457 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  460 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  461 */       CError tError = new CError();
/*  462 */       tError.moduleName = "MHonorCheckBDB";
/*  463 */       tError.functionName = "insert()";
/*  464 */       tError.errorMessage = ex.toString();
/*  465 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  468 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  471 */       if (!this.mflag)
/*      */         try {
/*  473 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  477 */       return false;
/*      */     }
/*      */ 
/*  480 */     if (!this.mflag)
/*      */       try {
/*  482 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  486 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  491 */     PreparedStatement pstmt = null;
/*  492 */     ResultSet rs = null;
/*      */ 
/*  494 */     if (!this.mflag) {
/*  495 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  500 */       pstmt = this.con.prepareStatement("SELECT * FROM MHonorCheckB WHERE  EdorNo = ?", 
/*  501 */         1003, 1007);
/*  502 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  503 */         pstmt.setNull(1, 12);
/*      */       else {
/*  505 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  507 */       rs = pstmt.executeQuery();
/*  508 */       int i = 0;
/*  509 */       if (rs.next())
/*      */       {
/*  511 */         i++;
/*  512 */         if (!setSchema(rs, i))
/*      */         {
/*  515 */           CError tError = new CError();
/*  516 */           tError.moduleName = "MHonorCheckBDB";
/*  517 */           tError.functionName = "getInfo";
/*  518 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  519 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  521 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  524 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  528 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  532 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  536 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  539 */       if (i == 0)
/*      */       {
/*  541 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  545 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  549 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  555 */       CError tError = new CError();
/*  556 */       tError.moduleName = "MHonorCheckBDB";
/*  557 */       tError.functionName = "getInfo";
/*  558 */       tError.errorMessage = e.toString();
/*  559 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  561 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  564 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  568 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  572 */       return false;
/*      */     }
/*      */ 
/*  575 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  579 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  584 */     return true;
/*      */   }
/*      */ 
/*      */   public MHonorCheckBSet query()
/*      */   {
/*  589 */     Statement stmt = null;
/*  590 */     ResultSet rs = null;
/*  591 */     MHonorCheckBSet aMHonorCheckBSet = new MHonorCheckBSet();
/*      */ 
/*  593 */     if (!this.mflag) {
/*  594 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  599 */       stmt = this.con.createStatement(1003, 1007);
/*  600 */       SQLString sqlObj = new SQLString("MHonorCheckB");
/*  601 */       MHonorCheckBSchema aSchema = getSchema();
/*  602 */       sqlObj.setSQL(5, aSchema);
/*  603 */       String sql = sqlObj.getSQL();
/*      */ 
/*  605 */       rs = stmt.executeQuery(sql);
/*  606 */       int i = 0;
/*  607 */       while (rs.next())
/*      */       {
/*  609 */         i++;
/*  610 */         MHonorCheckBSchema s1 = new MHonorCheckBSchema();
/*  611 */         s1.setSchema(rs, i);
/*  612 */         aMHonorCheckBSet.add(s1);
/*      */       }try {
/*  614 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  620 */       CError tError = new CError();
/*  621 */       tError.moduleName = "MHonorCheckBDB";
/*  622 */       tError.functionName = "query";
/*  623 */       tError.errorMessage = e.toString();
/*  624 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  626 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  629 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  633 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  639 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  643 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  648 */     return aMHonorCheckBSet;
/*      */   }
/*      */ 
/*      */   public MHonorCheckBSet executeQuery(String sql)
/*      */   {
/*  653 */     Statement stmt = null;
/*  654 */     ResultSet rs = null;
/*  655 */     MHonorCheckBSet aMHonorCheckBSet = new MHonorCheckBSet();
/*      */ 
/*  657 */     if (!this.mflag) {
/*  658 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  663 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  665 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  666 */       int i = 0;
/*  667 */       while (rs.next())
/*      */       {
/*  669 */         i++;
/*  670 */         MHonorCheckBSchema s1 = new MHonorCheckBSchema();
/*  671 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  674 */           CError tError = new CError();
/*  675 */           tError.moduleName = "MHonorCheckBDB";
/*  676 */           tError.functionName = "executeQuery";
/*  677 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  678 */           this.mErrors.addOneError(tError);
/*      */         }
/*  680 */         aMHonorCheckBSet.add(s1);
/*      */       }try {
/*  682 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  688 */       CError tError = new CError();
/*  689 */       tError.moduleName = "MHonorCheckBDB";
/*  690 */       tError.functionName = "executeQuery";
/*  691 */       tError.errorMessage = e.toString();
/*  692 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  694 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  697 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  701 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  707 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  711 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  716 */     return aMHonorCheckBSet;
/*      */   }
/*      */ 
/*      */   public MHonorCheckBSet query(int nStart, int nCount)
/*      */   {
/*  721 */     Statement stmt = null;
/*  722 */     ResultSet rs = null;
/*  723 */     MHonorCheckBSet aMHonorCheckBSet = new MHonorCheckBSet();
/*      */ 
/*  725 */     if (!this.mflag) {
/*  726 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  731 */       stmt = this.con.createStatement(1003, 1007);
/*  732 */       SQLString sqlObj = new SQLString("MHonorCheckB");
/*  733 */       MHonorCheckBSchema aSchema = getSchema();
/*  734 */       sqlObj.setSQL(5, aSchema);
/*  735 */       String sql = sqlObj.getSQL();
/*      */ 
/*  737 */       rs = stmt.executeQuery(sql);
/*  738 */       int i = 0;
/*  739 */       while (rs.next())
/*      */       {
/*  741 */         i++;
/*      */ 
/*  743 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  747 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  751 */         MHonorCheckBSchema s1 = new MHonorCheckBSchema();
/*  752 */         s1.setSchema(rs, i);
/*  753 */         aMHonorCheckBSet.add(s1);
/*      */       }try {
/*  755 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  761 */       CError tError = new CError();
/*  762 */       tError.moduleName = "MHonorCheckBDB";
/*  763 */       tError.functionName = "query";
/*  764 */       tError.errorMessage = e.toString();
/*  765 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  767 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  770 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  774 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  780 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  784 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  789 */     return aMHonorCheckBSet;
/*      */   }
/*      */ 
/*      */   public MHonorCheckBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  794 */     Statement stmt = null;
/*  795 */     ResultSet rs = null;
/*  796 */     MHonorCheckBSet aMHonorCheckBSet = new MHonorCheckBSet();
/*      */ 
/*  798 */     if (!this.mflag) {
/*  799 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  804 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  806 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  807 */       int i = 0;
/*  808 */       while (rs.next())
/*      */       {
/*  810 */         i++;
/*      */ 
/*  812 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  816 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  820 */         MHonorCheckBSchema s1 = new MHonorCheckBSchema();
/*  821 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  824 */           CError tError = new CError();
/*  825 */           tError.moduleName = "MHonorCheckBDB";
/*  826 */           tError.functionName = "executeQuery";
/*  827 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  828 */           this.mErrors.addOneError(tError);
/*      */         }
/*  830 */         aMHonorCheckBSet.add(s1);
/*      */       }try {
/*  832 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  838 */       CError tError = new CError();
/*  839 */       tError.moduleName = "MHonorCheckBDB";
/*  840 */       tError.functionName = "executeQuery";
/*  841 */       tError.errorMessage = e.toString();
/*  842 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  844 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  847 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  851 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  857 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  861 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  866 */     return aMHonorCheckBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  871 */     Statement stmt = null;
/*      */ 
/*  873 */     if (!this.mflag) {
/*  874 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  879 */       stmt = this.con.createStatement(1003, 1007);
/*  880 */       SQLString sqlObj = new SQLString("MHonorCheckB");
/*  881 */       MHonorCheckBSchema aSchema = getSchema();
/*  882 */       sqlObj.setSQL(2, aSchema);
/*  883 */       String sql = "update MHonorCheckB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  885 */       int operCount = stmt.executeUpdate(sql);
/*  886 */       if (operCount == 0)
/*      */       {
/*  889 */         CError tError = new CError();
/*  890 */         tError.moduleName = "MHonorCheckBDB";
/*  891 */         tError.functionName = "update";
/*  892 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  893 */         this.mErrors.addOneError(tError);
/*      */ 
/*  895 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  899 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  903 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  909 */       CError tError = new CError();
/*  910 */       tError.moduleName = "MHonorCheckBDB";
/*  911 */       tError.functionName = "update";
/*  912 */       tError.errorMessage = e.toString();
/*  913 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  915 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  917 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  921 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  925 */       return false;
/*      */     }
/*      */ 
/*  928 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  932 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  937 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  943 */     if (this.mResultSet != null)
/*      */     {
/*  946 */       CError tError = new CError();
/*  947 */       tError.moduleName = "MHonorCheckBDB";
/*  948 */       tError.functionName = "prepareData";
/*  949 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  950 */       this.mErrors.addOneError(tError);
/*  951 */       return false;
/*      */     }
/*      */ 
/*  954 */     if (!this.mflag)
/*      */     {
/*  956 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  960 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  961 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  966 */       CError tError = new CError();
/*  967 */       tError.moduleName = "MHonorCheckBDB";
/*  968 */       tError.functionName = "prepareData";
/*  969 */       tError.errorMessage = e.toString();
/*  970 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  973 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  979 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  983 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  987 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  992 */       return false;
/*      */     }
/*      */ 
/*  995 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  999 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1004 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1010 */     boolean flag = true;
/* 1011 */     if (this.mResultSet == null)
/*      */     {
/* 1013 */       CError tError = new CError();
/* 1014 */       tError.moduleName = "MHonorCheckBDB";
/* 1015 */       tError.functionName = "hasMoreData";
/* 1016 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1017 */       this.mErrors.addOneError(tError);
/* 1018 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1022 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1026 */       CError tError = new CError();
/* 1027 */       tError.moduleName = "MHonorCheckBDB";
/* 1028 */       tError.functionName = "hasMoreData";
/* 1029 */       tError.errorMessage = ex.toString();
/* 1030 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1033 */         this.mResultSet.close();
/* 1034 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1040 */         this.mStatement.close();
/* 1041 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1045 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1049 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1054 */       return false;
/*      */     }
/* 1056 */     return flag;
/*      */   }
/*      */ 
/*      */   public MHonorCheckBSet getData()
/*      */   {
/* 1061 */     int tCount = 0;
/* 1062 */     MHonorCheckBSet tMHonorCheckBSet = new MHonorCheckBSet();
/* 1063 */     MHonorCheckBSchema tMHonorCheckBSchema = null;
/* 1064 */     if (this.mResultSet == null)
/*      */     {
/* 1066 */       CError tError = new CError();
/* 1067 */       tError.moduleName = "MHonorCheckBDB";
/* 1068 */       tError.functionName = "getData";
/* 1069 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1070 */       this.mErrors.addOneError(tError);
/* 1071 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1075 */       tCount = 1;
/* 1076 */       tMHonorCheckBSchema = new MHonorCheckBSchema();
/* 1077 */       tMHonorCheckBSchema.setSchema(this.mResultSet, 1);
/* 1078 */       tMHonorCheckBSet.add(tMHonorCheckBSchema);
/*      */ 
/* 1080 */       while (tCount++ < 5000)
/*      */       {
/* 1082 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1084 */         tMHonorCheckBSchema = new MHonorCheckBSchema();
/* 1085 */         tMHonorCheckBSchema.setSchema(this.mResultSet, 1);
/* 1086 */         tMHonorCheckBSet.add(tMHonorCheckBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1092 */       CError tError = new CError();
/* 1093 */       tError.moduleName = "MHonorCheckBDB";
/* 1094 */       tError.functionName = "getData";
/* 1095 */       tError.errorMessage = ex.toString();
/* 1096 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1099 */         this.mResultSet.close();
/* 1100 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1106 */         this.mStatement.close();
/* 1107 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1111 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1115 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1120 */       return null;
/*      */     }
/* 1122 */     return tMHonorCheckBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1127 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1130 */       if (this.mResultSet == null)
/*      */       {
/* 1132 */         CError tError = new CError();
/* 1133 */         tError.moduleName = "MHonorCheckBDB";
/* 1134 */         tError.functionName = "closeData";
/* 1135 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1136 */         this.mErrors.addOneError(tError);
/* 1137 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1141 */         this.mResultSet.close();
/* 1142 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1147 */       CError tError = new CError();
/* 1148 */       tError.moduleName = "MHonorCheckBDB";
/* 1149 */       tError.functionName = "closeData";
/* 1150 */       tError.errorMessage = ex2.toString();
/* 1151 */       this.mErrors.addOneError(tError);
/* 1152 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1156 */       if (this.mStatement == null)
/*      */       {
/* 1158 */         CError tError = new CError();
/* 1159 */         tError.moduleName = "MHonorCheckBDB";
/* 1160 */         tError.functionName = "closeData";
/* 1161 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1162 */         this.mErrors.addOneError(tError);
/* 1163 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1167 */         this.mStatement.close();
/* 1168 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1173 */       CError tError = new CError();
/* 1174 */       tError.moduleName = "MHonorCheckBDB";
/* 1175 */       tError.functionName = "closeData";
/* 1176 */       tError.errorMessage = ex3.toString();
/* 1177 */       this.mErrors.addOneError(tError);
/* 1178 */       flag = false;
/*      */     }
/* 1180 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MHonorCheckBDB
 * JD-Core Version:    0.6.0
 */