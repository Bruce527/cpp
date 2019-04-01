/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPIndUWPEMasterSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPIndUWPEMasterSet;
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
/*      */ public class LNPIndUWPEMasterDB extends LNPIndUWPEMasterSchema
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
/*      */   public LNPIndUWPEMasterDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPIndUWPEMaster");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPIndUWPEMasterDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPIndUWPEMaster");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPIndUWPEMasterSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPIndUWPEMasterDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPIndUWPEMasterSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPIndUWPEMasterDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPIndUWPEMaster WHERE  ContNo = ? AND InsuredId = ? AND UWPENo = ?");
/*   97 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getContNo());
/*      */       }
/*  102 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getInsuredId());
/*      */       }
/*  107 */       if ((getUWPENo() == null) || (getUWPENo().equals("null")))
/*  108 */         pstmt.setNull(3, 12);
/*      */       else {
/*  110 */         pstmt.setString(3, getUWPENo());
/*      */       }
/*  112 */       pstmt.executeUpdate();
/*  113 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  116 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  117 */       CError tError = new CError();
/*  118 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  119 */       tError.functionName = "delete()";
/*  120 */       tError.errorMessage = ex.toString();
/*  121 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  124 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  127 */       if (!this.mflag)
/*      */         try {
/*  129 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  133 */       return false;
/*      */     }
/*      */ 
/*  136 */     if (!this.mflag)
/*      */       try {
/*  138 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  142 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  147 */     PreparedStatement pstmt = null;
/*      */ 
/*  149 */     if (!this.mflag) {
/*  150 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  155 */       pstmt = this.con.prepareStatement("UPDATE LNPIndUWPEMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , UWNo = ? , ManageCom = ? , UMDate = ? , UMTime = ? , InsuredId = ? , UWPENo = ? , PEName = ? , PECode = ? , PEStatus = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ? AND InsuredId = ? AND UWPENo = ?");
/*  156 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  157 */         pstmt.setNull(1, 12);
/*      */       else {
/*  159 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  161 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  162 */         pstmt.setNull(2, 12);
/*      */       else {
/*  164 */         pstmt.setString(2, getContNo());
/*      */       }
/*  166 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  167 */         pstmt.setNull(3, 12);
/*      */       else {
/*  169 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  171 */       pstmt.setInt(4, getUWNo());
/*  172 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  173 */         pstmt.setNull(5, 12);
/*      */       else {
/*  175 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  177 */       if ((getUMDate() == null) || (getUMDate().equals("null")))
/*  178 */         pstmt.setNull(6, 91);
/*      */       else {
/*  180 */         pstmt.setDate(6, Date.valueOf(getUMDate()));
/*      */       }
/*  182 */       if ((getUMTime() == null) || (getUMTime().equals("null")))
/*  183 */         pstmt.setNull(7, 12);
/*      */       else {
/*  185 */         pstmt.setString(7, getUMTime());
/*      */       }
/*  187 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  188 */         pstmt.setNull(8, 12);
/*      */       else {
/*  190 */         pstmt.setString(8, getInsuredId());
/*      */       }
/*  192 */       if ((getUWPENo() == null) || (getUWPENo().equals("null")))
/*  193 */         pstmt.setNull(9, 12);
/*      */       else {
/*  195 */         pstmt.setString(9, getUWPENo());
/*      */       }
/*  197 */       if ((getPEName() == null) || (getPEName().equals("null")))
/*  198 */         pstmt.setNull(10, 12);
/*      */       else {
/*  200 */         pstmt.setString(10, getPEName());
/*      */       }
/*  202 */       if ((getPECode() == null) || (getPECode().equals("null")))
/*  203 */         pstmt.setNull(11, 12);
/*      */       else {
/*  205 */         pstmt.setString(11, getPECode());
/*      */       }
/*  207 */       if ((getPEStatus() == null) || (getPEStatus().equals("null")))
/*  208 */         pstmt.setNull(12, 12);
/*      */       else {
/*  210 */         pstmt.setString(12, getPEStatus());
/*      */       }
/*  212 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  213 */         pstmt.setNull(13, 12);
/*      */       else {
/*  215 */         pstmt.setString(13, getOperator());
/*      */       }
/*  217 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  218 */         pstmt.setNull(14, 91);
/*      */       else {
/*  220 */         pstmt.setDate(14, Date.valueOf(getMakeDate()));
/*      */       }
/*  222 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  223 */         pstmt.setNull(15, 12);
/*      */       else {
/*  225 */         pstmt.setString(15, getMakeTime());
/*      */       }
/*  227 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  228 */         pstmt.setNull(16, 91);
/*      */       else {
/*  230 */         pstmt.setDate(16, Date.valueOf(getModifyDate()));
/*      */       }
/*  232 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  233 */         pstmt.setNull(17, 12);
/*      */       else {
/*  235 */         pstmt.setString(17, getModifyTime());
/*      */       }
/*      */ 
/*  238 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  239 */         pstmt.setNull(18, 12);
/*      */       else {
/*  241 */         pstmt.setString(18, getContNo());
/*      */       }
/*  243 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  244 */         pstmt.setNull(19, 12);
/*      */       else {
/*  246 */         pstmt.setString(19, getInsuredId());
/*      */       }
/*  248 */       if ((getUWPENo() == null) || (getUWPENo().equals("null")))
/*  249 */         pstmt.setNull(20, 12);
/*      */       else {
/*  251 */         pstmt.setString(20, getUWPENo());
/*      */       }
/*  253 */       pstmt.executeUpdate();
/*  254 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  257 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  258 */       CError tError = new CError();
/*  259 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  260 */       tError.functionName = "update()";
/*  261 */       tError.errorMessage = ex.toString();
/*  262 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  265 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  268 */       if (!this.mflag)
/*      */         try {
/*  270 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  274 */       return false;
/*      */     }
/*      */ 
/*  277 */     if (!this.mflag)
/*      */       try {
/*  279 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  283 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  288 */     PreparedStatement pstmt = null;
/*      */ 
/*  290 */     if (!this.mflag) {
/*  291 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  296 */       pstmt = this.con.prepareStatement("INSERT INTO LNPIndUWPEMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  297 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  298 */         pstmt.setNull(1, 12);
/*      */       else {
/*  300 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  302 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  303 */         pstmt.setNull(2, 12);
/*      */       else {
/*  305 */         pstmt.setString(2, getContNo());
/*      */       }
/*  307 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  308 */         pstmt.setNull(3, 12);
/*      */       else {
/*  310 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  312 */       pstmt.setInt(4, getUWNo());
/*  313 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  314 */         pstmt.setNull(5, 12);
/*      */       else {
/*  316 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  318 */       if ((getUMDate() == null) || (getUMDate().equals("null")))
/*  319 */         pstmt.setNull(6, 91);
/*      */       else {
/*  321 */         pstmt.setDate(6, Date.valueOf(getUMDate()));
/*      */       }
/*  323 */       if ((getUMTime() == null) || (getUMTime().equals("null")))
/*  324 */         pstmt.setNull(7, 12);
/*      */       else {
/*  326 */         pstmt.setString(7, getUMTime());
/*      */       }
/*  328 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  329 */         pstmt.setNull(8, 12);
/*      */       else {
/*  331 */         pstmt.setString(8, getInsuredId());
/*      */       }
/*  333 */       if ((getUWPENo() == null) || (getUWPENo().equals("null")))
/*  334 */         pstmt.setNull(9, 12);
/*      */       else {
/*  336 */         pstmt.setString(9, getUWPENo());
/*      */       }
/*  338 */       if ((getPEName() == null) || (getPEName().equals("null")))
/*  339 */         pstmt.setNull(10, 12);
/*      */       else {
/*  341 */         pstmt.setString(10, getPEName());
/*      */       }
/*  343 */       if ((getPECode() == null) || (getPECode().equals("null")))
/*  344 */         pstmt.setNull(11, 12);
/*      */       else {
/*  346 */         pstmt.setString(11, getPECode());
/*      */       }
/*  348 */       if ((getPEStatus() == null) || (getPEStatus().equals("null")))
/*  349 */         pstmt.setNull(12, 12);
/*      */       else {
/*  351 */         pstmt.setString(12, getPEStatus());
/*      */       }
/*  353 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  354 */         pstmt.setNull(13, 12);
/*      */       else {
/*  356 */         pstmt.setString(13, getOperator());
/*      */       }
/*  358 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  359 */         pstmt.setNull(14, 91);
/*      */       else {
/*  361 */         pstmt.setDate(14, Date.valueOf(getMakeDate()));
/*      */       }
/*  363 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  364 */         pstmt.setNull(15, 12);
/*      */       else {
/*  366 */         pstmt.setString(15, getMakeTime());
/*      */       }
/*  368 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  369 */         pstmt.setNull(16, 91);
/*      */       else {
/*  371 */         pstmt.setDate(16, Date.valueOf(getModifyDate()));
/*      */       }
/*  373 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  374 */         pstmt.setNull(17, 12);
/*      */       else {
/*  376 */         pstmt.setString(17, getModifyTime());
/*      */       }
/*      */ 
/*  379 */       pstmt.executeUpdate();
/*  380 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  383 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  384 */       CError tError = new CError();
/*  385 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  386 */       tError.functionName = "insert()";
/*  387 */       tError.errorMessage = ex.toString();
/*  388 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  391 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  394 */       if (!this.mflag)
/*      */         try {
/*  396 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  400 */       return false;
/*      */     }
/*      */ 
/*  403 */     if (!this.mflag)
/*      */       try {
/*  405 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  409 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  414 */     PreparedStatement pstmt = null;
/*  415 */     ResultSet rs = null;
/*      */ 
/*  417 */     if (!this.mflag) {
/*  418 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  423 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPIndUWPEMaster WHERE  ContNo = ? AND InsuredId = ? AND UWPENo = ?", 
/*  424 */         1003, 1007);
/*  425 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  426 */         pstmt.setNull(1, 12);
/*      */       else {
/*  428 */         pstmt.setString(1, getContNo());
/*      */       }
/*  430 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  431 */         pstmt.setNull(2, 12);
/*      */       else {
/*  433 */         pstmt.setString(2, getInsuredId());
/*      */       }
/*  435 */       if ((getUWPENo() == null) || (getUWPENo().equals("null")))
/*  436 */         pstmt.setNull(3, 12);
/*      */       else {
/*  438 */         pstmt.setString(3, getUWPENo());
/*      */       }
/*  440 */       rs = pstmt.executeQuery();
/*  441 */       int i = 0;
/*  442 */       if (rs.next())
/*      */       {
/*  444 */         i++;
/*  445 */         if (!setSchema(rs, i))
/*      */         {
/*  448 */           CError tError = new CError();
/*  449 */           tError.moduleName = "LNPIndUWPEMasterDB";
/*  450 */           tError.functionName = "getInfo";
/*  451 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  452 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  454 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  457 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  461 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  465 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  469 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  472 */       if (i == 0)
/*      */       {
/*  474 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  478 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  482 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  488 */       CError tError = new CError();
/*  489 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  490 */       tError.functionName = "getInfo";
/*  491 */       tError.errorMessage = e.toString();
/*  492 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  494 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  497 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  501 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  505 */       return false;
/*      */     }
/*      */ 
/*  508 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  512 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  517 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPIndUWPEMasterSet query()
/*      */   {
/*  522 */     Statement stmt = null;
/*  523 */     ResultSet rs = null;
/*  524 */     LNPIndUWPEMasterSet aLNPIndUWPEMasterSet = new LNPIndUWPEMasterSet();
/*      */ 
/*  526 */     if (!this.mflag) {
/*  527 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  532 */       stmt = this.con.createStatement(1003, 1007);
/*  533 */       SQLString sqlObj = new SQLString("LNPIndUWPEMaster");
/*  534 */       LNPIndUWPEMasterSchema aSchema = getSchema();
/*  535 */       sqlObj.setSQL(5, aSchema);
/*  536 */       String sql = sqlObj.getSQL();
/*      */ 
/*  538 */       rs = stmt.executeQuery(sql);
/*  539 */       int i = 0;
/*  540 */       while (rs.next())
/*      */       {
/*  542 */         i++;
/*  543 */         LNPIndUWPEMasterSchema s1 = new LNPIndUWPEMasterSchema();
/*  544 */         s1.setSchema(rs, i);
/*  545 */         aLNPIndUWPEMasterSet.add(s1);
/*      */       }try {
/*  547 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  553 */       CError tError = new CError();
/*  554 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  555 */       tError.functionName = "query";
/*  556 */       tError.errorMessage = e.toString();
/*  557 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  559 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  562 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  566 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  572 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  576 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  581 */     return aLNPIndUWPEMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPIndUWPEMasterSet executeQuery(String sql)
/*      */   {
/*  586 */     Statement stmt = null;
/*  587 */     ResultSet rs = null;
/*  588 */     LNPIndUWPEMasterSet aLNPIndUWPEMasterSet = new LNPIndUWPEMasterSet();
/*      */ 
/*  590 */     if (!this.mflag) {
/*  591 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  596 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  598 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  599 */       int i = 0;
/*  600 */       while (rs.next())
/*      */       {
/*  602 */         i++;
/*  603 */         LNPIndUWPEMasterSchema s1 = new LNPIndUWPEMasterSchema();
/*  604 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  607 */           CError tError = new CError();
/*  608 */           tError.moduleName = "LNPIndUWPEMasterDB";
/*  609 */           tError.functionName = "executeQuery";
/*  610 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  611 */           this.mErrors.addOneError(tError);
/*      */         }
/*  613 */         aLNPIndUWPEMasterSet.add(s1);
/*      */       }try {
/*  615 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  621 */       CError tError = new CError();
/*  622 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  623 */       tError.functionName = "executeQuery";
/*  624 */       tError.errorMessage = e.toString();
/*  625 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  627 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  630 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  634 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  640 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  644 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  649 */     return aLNPIndUWPEMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPIndUWPEMasterSet query(int nStart, int nCount)
/*      */   {
/*  654 */     Statement stmt = null;
/*  655 */     ResultSet rs = null;
/*  656 */     LNPIndUWPEMasterSet aLNPIndUWPEMasterSet = new LNPIndUWPEMasterSet();
/*      */ 
/*  658 */     if (!this.mflag) {
/*  659 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  664 */       stmt = this.con.createStatement(1003, 1007);
/*  665 */       SQLString sqlObj = new SQLString("LNPIndUWPEMaster");
/*  666 */       LNPIndUWPEMasterSchema aSchema = getSchema();
/*  667 */       sqlObj.setSQL(5, aSchema);
/*  668 */       String sql = sqlObj.getSQL();
/*      */ 
/*  670 */       rs = stmt.executeQuery(sql);
/*  671 */       int i = 0;
/*  672 */       while (rs.next())
/*      */       {
/*  674 */         i++;
/*      */ 
/*  676 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  680 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  684 */         LNPIndUWPEMasterSchema s1 = new LNPIndUWPEMasterSchema();
/*  685 */         s1.setSchema(rs, i);
/*  686 */         aLNPIndUWPEMasterSet.add(s1);
/*      */       }try {
/*  688 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  694 */       CError tError = new CError();
/*  695 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  696 */       tError.functionName = "query";
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
/*  722 */     return aLNPIndUWPEMasterSet;
/*      */   }
/*      */ 
/*      */   public LNPIndUWPEMasterSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  727 */     Statement stmt = null;
/*  728 */     ResultSet rs = null;
/*  729 */     LNPIndUWPEMasterSet aLNPIndUWPEMasterSet = new LNPIndUWPEMasterSet();
/*      */ 
/*  731 */     if (!this.mflag) {
/*  732 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  737 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  739 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  740 */       int i = 0;
/*  741 */       while (rs.next())
/*      */       {
/*  743 */         i++;
/*      */ 
/*  745 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  749 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  753 */         LNPIndUWPEMasterSchema s1 = new LNPIndUWPEMasterSchema();
/*  754 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  757 */           CError tError = new CError();
/*  758 */           tError.moduleName = "LNPIndUWPEMasterDB";
/*  759 */           tError.functionName = "executeQuery";
/*  760 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  761 */           this.mErrors.addOneError(tError);
/*      */         }
/*  763 */         aLNPIndUWPEMasterSet.add(s1);
/*      */       }try {
/*  765 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  771 */       CError tError = new CError();
/*  772 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  773 */       tError.functionName = "executeQuery";
/*  774 */       tError.errorMessage = e.toString();
/*  775 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  777 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  780 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  784 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  790 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  794 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  799 */     return aLNPIndUWPEMasterSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  804 */     Statement stmt = null;
/*      */ 
/*  806 */     if (!this.mflag) {
/*  807 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  812 */       stmt = this.con.createStatement(1003, 1007);
/*  813 */       SQLString sqlObj = new SQLString("LNPIndUWPEMaster");
/*  814 */       LNPIndUWPEMasterSchema aSchema = getSchema();
/*  815 */       sqlObj.setSQL(2, aSchema);
/*  816 */       String sql = "update LNPIndUWPEMaster " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  818 */       int operCount = stmt.executeUpdate(sql);
/*  819 */       if (operCount == 0)
/*      */       {
/*  822 */         CError tError = new CError();
/*  823 */         tError.moduleName = "LNPIndUWPEMasterDB";
/*  824 */         tError.functionName = "update";
/*  825 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  826 */         this.mErrors.addOneError(tError);
/*      */ 
/*  828 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  832 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  836 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  842 */       CError tError = new CError();
/*  843 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  844 */       tError.functionName = "update";
/*  845 */       tError.errorMessage = e.toString();
/*  846 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  848 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  850 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  854 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  858 */       return false;
/*      */     }
/*      */ 
/*  861 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  865 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  870 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  876 */     if (this.mResultSet != null)
/*      */     {
/*  879 */       CError tError = new CError();
/*  880 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  881 */       tError.functionName = "prepareData";
/*  882 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  883 */       this.mErrors.addOneError(tError);
/*  884 */       return false;
/*      */     }
/*      */ 
/*  887 */     if (!this.mflag)
/*      */     {
/*  889 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  893 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  894 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  899 */       CError tError = new CError();
/*  900 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  901 */       tError.functionName = "prepareData";
/*  902 */       tError.errorMessage = e.toString();
/*  903 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  906 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  912 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  916 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  920 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
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
/*      */   public boolean hasMoreData()
/*      */   {
/*  943 */     boolean flag = true;
/*  944 */     if (this.mResultSet == null)
/*      */     {
/*  946 */       CError tError = new CError();
/*  947 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  948 */       tError.functionName = "hasMoreData";
/*  949 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  950 */       this.mErrors.addOneError(tError);
/*  951 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  955 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  959 */       CError tError = new CError();
/*  960 */       tError.moduleName = "LNPIndUWPEMasterDB";
/*  961 */       tError.functionName = "hasMoreData";
/*  962 */       tError.errorMessage = ex.toString();
/*  963 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  966 */         this.mResultSet.close();
/*  967 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  973 */         this.mStatement.close();
/*  974 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  978 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  982 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  987 */       return false;
/*      */     }
/*  989 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPIndUWPEMasterSet getData()
/*      */   {
/*  994 */     int tCount = 0;
/*  995 */     LNPIndUWPEMasterSet tLNPIndUWPEMasterSet = new LNPIndUWPEMasterSet();
/*  996 */     LNPIndUWPEMasterSchema tLNPIndUWPEMasterSchema = null;
/*  997 */     if (this.mResultSet == null)
/*      */     {
/*  999 */       CError tError = new CError();
/* 1000 */       tError.moduleName = "LNPIndUWPEMasterDB";
/* 1001 */       tError.functionName = "getData";
/* 1002 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1003 */       this.mErrors.addOneError(tError);
/* 1004 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1008 */       tCount = 1;
/* 1009 */       tLNPIndUWPEMasterSchema = new LNPIndUWPEMasterSchema();
/* 1010 */       tLNPIndUWPEMasterSchema.setSchema(this.mResultSet, 1);
/* 1011 */       tLNPIndUWPEMasterSet.add(tLNPIndUWPEMasterSchema);
/*      */ 
/* 1013 */       while (tCount++ < 5000)
/*      */       {
/* 1015 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1017 */         tLNPIndUWPEMasterSchema = new LNPIndUWPEMasterSchema();
/* 1018 */         tLNPIndUWPEMasterSchema.setSchema(this.mResultSet, 1);
/* 1019 */         tLNPIndUWPEMasterSet.add(tLNPIndUWPEMasterSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1025 */       CError tError = new CError();
/* 1026 */       tError.moduleName = "LNPIndUWPEMasterDB";
/* 1027 */       tError.functionName = "getData";
/* 1028 */       tError.errorMessage = ex.toString();
/* 1029 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1032 */         this.mResultSet.close();
/* 1033 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1039 */         this.mStatement.close();
/* 1040 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1044 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1048 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1053 */       return null;
/*      */     }
/* 1055 */     return tLNPIndUWPEMasterSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1060 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1063 */       if (this.mResultSet == null)
/*      */       {
/* 1065 */         CError tError = new CError();
/* 1066 */         tError.moduleName = "LNPIndUWPEMasterDB";
/* 1067 */         tError.functionName = "closeData";
/* 1068 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1069 */         this.mErrors.addOneError(tError);
/* 1070 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1074 */         this.mResultSet.close();
/* 1075 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1080 */       CError tError = new CError();
/* 1081 */       tError.moduleName = "LNPIndUWPEMasterDB";
/* 1082 */       tError.functionName = "closeData";
/* 1083 */       tError.errorMessage = ex2.toString();
/* 1084 */       this.mErrors.addOneError(tError);
/* 1085 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1089 */       if (this.mStatement == null)
/*      */       {
/* 1091 */         CError tError = new CError();
/* 1092 */         tError.moduleName = "LNPIndUWPEMasterDB";
/* 1093 */         tError.functionName = "closeData";
/* 1094 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1095 */         this.mErrors.addOneError(tError);
/* 1096 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1100 */         this.mStatement.close();
/* 1101 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1106 */       CError tError = new CError();
/* 1107 */       tError.moduleName = "LNPIndUWPEMasterDB";
/* 1108 */       tError.functionName = "closeData";
/* 1109 */       tError.errorMessage = ex3.toString();
/* 1110 */       this.mErrors.addOneError(tError);
/* 1111 */       flag = false;
/*      */     }
/* 1113 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPIndUWPEMasterDB
 * JD-Core Version:    0.6.0
 */