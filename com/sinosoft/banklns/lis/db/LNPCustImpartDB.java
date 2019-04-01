/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPCustImpartSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCustImpartSet;
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
/*      */ public class LNPCustImpartDB extends LNPCustImpartSchema
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
/*      */   public LNPCustImpartDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPCustImpart");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPCustImpartDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPCustImpart");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPCustImpartSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPCustImpartDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPCustImpartSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPCustImpartDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCustImpart WHERE  ImpartId = ?");
/*   97 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getImpartId());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPCustImpartDB";
/*  109 */       tError.functionName = "delete()";
/*  110 */       tError.errorMessage = ex.toString();
/*  111 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  114 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  117 */       if (!this.mflag)
/*      */         try {
/*  119 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  123 */       return false;
/*      */     }
/*      */ 
/*  126 */     if (!this.mflag)
/*      */       try {
/*  128 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  132 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  137 */     PreparedStatement pstmt = null;
/*      */ 
/*  139 */     if (!this.mflag) {
/*  140 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPCustImpart SET  ImpartId = ? , ProposalType = ? , ImpartName = ? , ImpartVer = ? , ImpartContent = ? , QuestionSum = ? , Operator = ? , ManageCom = ? , MakeTime = ? , MakeDate = ? , ModifyDate = ? , ModifyTime = ? , p1 = ? , p2 = ? , p3 = ? , p4 = ? WHERE  ImpartId = ?");
/*  146 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getImpartId());
/*      */       }
/*  151 */       if ((getProposalType() == null) || (getProposalType().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getProposalType());
/*      */       }
/*  156 */       if ((getImpartName() == null) || (getImpartName().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getImpartName());
/*      */       }
/*  161 */       if ((getImpartVer() == null) || (getImpartVer().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getImpartVer());
/*      */       }
/*  166 */       if ((getImpartContent() == null) || (getImpartContent().equals("null")))
/*  167 */         pstmt.setNull(5, 12);
/*      */       else {
/*  169 */         pstmt.setString(5, getImpartContent());
/*      */       }
/*  171 */       pstmt.setInt(6, getQuestionSum());
/*  172 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  173 */         pstmt.setNull(7, 12);
/*      */       else {
/*  175 */         pstmt.setString(7, getOperator());
/*      */       }
/*  177 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  178 */         pstmt.setNull(8, 12);
/*      */       else {
/*  180 */         pstmt.setString(8, getManageCom());
/*      */       }
/*  182 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  183 */         pstmt.setNull(9, 12);
/*      */       else {
/*  185 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  187 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  188 */         pstmt.setNull(10, 91);
/*      */       else {
/*  190 */         pstmt.setDate(10, Date.valueOf(getMakeDate()));
/*      */       }
/*  192 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  193 */         pstmt.setNull(11, 91);
/*      */       else {
/*  195 */         pstmt.setDate(11, Date.valueOf(getModifyDate()));
/*      */       }
/*  197 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  198 */         pstmt.setNull(12, 12);
/*      */       else {
/*  200 */         pstmt.setString(12, getModifyTime());
/*      */       }
/*  202 */       if ((getP1() == null) || (getP1().equals("null")))
/*  203 */         pstmt.setNull(13, 12);
/*      */       else {
/*  205 */         pstmt.setString(13, getP1());
/*      */       }
/*  207 */       if ((getP2() == null) || (getP2().equals("null")))
/*  208 */         pstmt.setNull(14, 12);
/*      */       else {
/*  210 */         pstmt.setString(14, getP2());
/*      */       }
/*  212 */       if ((getP3() == null) || (getP3().equals("null")))
/*  213 */         pstmt.setNull(15, 12);
/*      */       else {
/*  215 */         pstmt.setString(15, getP3());
/*      */       }
/*  217 */       if ((getP4() == null) || (getP4().equals("null")))
/*  218 */         pstmt.setNull(16, 12);
/*      */       else {
/*  220 */         pstmt.setString(16, getP4());
/*      */       }
/*      */ 
/*  223 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  224 */         pstmt.setNull(17, 12);
/*      */       else {
/*  226 */         pstmt.setString(17, getImpartId());
/*      */       }
/*  228 */       pstmt.executeUpdate();
/*  229 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  232 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  233 */       CError tError = new CError();
/*  234 */       tError.moduleName = "LNPCustImpartDB";
/*  235 */       tError.functionName = "update()";
/*  236 */       tError.errorMessage = ex.toString();
/*  237 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  240 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  243 */       if (!this.mflag)
/*      */         try {
/*  245 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  249 */       return false;
/*      */     }
/*      */ 
/*  252 */     if (!this.mflag)
/*      */       try {
/*  254 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  258 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  263 */     PreparedStatement pstmt = null;
/*      */ 
/*  265 */     if (!this.mflag) {
/*  266 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  271 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCustImpart VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  272 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  273 */         pstmt.setNull(1, 12);
/*      */       else {
/*  275 */         pstmt.setString(1, getImpartId());
/*      */       }
/*  277 */       if ((getProposalType() == null) || (getProposalType().equals("null")))
/*  278 */         pstmt.setNull(2, 12);
/*      */       else {
/*  280 */         pstmt.setString(2, getProposalType());
/*      */       }
/*  282 */       if ((getImpartName() == null) || (getImpartName().equals("null")))
/*  283 */         pstmt.setNull(3, 12);
/*      */       else {
/*  285 */         pstmt.setString(3, getImpartName());
/*      */       }
/*  287 */       if ((getImpartVer() == null) || (getImpartVer().equals("null")))
/*  288 */         pstmt.setNull(4, 12);
/*      */       else {
/*  290 */         pstmt.setString(4, getImpartVer());
/*      */       }
/*  292 */       if ((getImpartContent() == null) || (getImpartContent().equals("null")))
/*  293 */         pstmt.setNull(5, 12);
/*      */       else {
/*  295 */         pstmt.setString(5, getImpartContent());
/*      */       }
/*  297 */       pstmt.setInt(6, getQuestionSum());
/*  298 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  299 */         pstmt.setNull(7, 12);
/*      */       else {
/*  301 */         pstmt.setString(7, getOperator());
/*      */       }
/*  303 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  304 */         pstmt.setNull(8, 12);
/*      */       else {
/*  306 */         pstmt.setString(8, getManageCom());
/*      */       }
/*  308 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  309 */         pstmt.setNull(9, 12);
/*      */       else {
/*  311 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  313 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  314 */         pstmt.setNull(10, 91);
/*      */       else {
/*  316 */         pstmt.setDate(10, Date.valueOf(getMakeDate()));
/*      */       }
/*  318 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  319 */         pstmt.setNull(11, 91);
/*      */       else {
/*  321 */         pstmt.setDate(11, Date.valueOf(getModifyDate()));
/*      */       }
/*  323 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  324 */         pstmt.setNull(12, 12);
/*      */       else {
/*  326 */         pstmt.setString(12, getModifyTime());
/*      */       }
/*  328 */       if ((getP1() == null) || (getP1().equals("null")))
/*  329 */         pstmt.setNull(13, 12);
/*      */       else {
/*  331 */         pstmt.setString(13, getP1());
/*      */       }
/*  333 */       if ((getP2() == null) || (getP2().equals("null")))
/*  334 */         pstmt.setNull(14, 12);
/*      */       else {
/*  336 */         pstmt.setString(14, getP2());
/*      */       }
/*  338 */       if ((getP3() == null) || (getP3().equals("null")))
/*  339 */         pstmt.setNull(15, 12);
/*      */       else {
/*  341 */         pstmt.setString(15, getP3());
/*      */       }
/*  343 */       if ((getP4() == null) || (getP4().equals("null")))
/*  344 */         pstmt.setNull(16, 12);
/*      */       else {
/*  346 */         pstmt.setString(16, getP4());
/*      */       }
/*      */ 
/*  349 */       pstmt.executeUpdate();
/*  350 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  353 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  354 */       CError tError = new CError();
/*  355 */       tError.moduleName = "LNPCustImpartDB";
/*  356 */       tError.functionName = "insert()";
/*  357 */       tError.errorMessage = ex.toString();
/*  358 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  361 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  364 */       if (!this.mflag)
/*      */         try {
/*  366 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  370 */       return false;
/*      */     }
/*      */ 
/*  373 */     if (!this.mflag)
/*      */       try {
/*  375 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  379 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  384 */     PreparedStatement pstmt = null;
/*  385 */     ResultSet rs = null;
/*      */ 
/*  387 */     if (!this.mflag) {
/*  388 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  393 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPCustImpart WHERE  ImpartId = ?", 
/*  394 */         1003, 1007);
/*  395 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  396 */         pstmt.setNull(1, 12);
/*      */       else {
/*  398 */         pstmt.setString(1, getImpartId());
/*      */       }
/*  400 */       rs = pstmt.executeQuery();
/*  401 */       int i = 0;
/*  402 */       if (rs.next())
/*      */       {
/*  404 */         i++;
/*  405 */         if (!setSchema(rs, i))
/*      */         {
/*  408 */           CError tError = new CError();
/*  409 */           tError.moduleName = "LNPCustImpartDB";
/*  410 */           tError.functionName = "getInfo";
/*  411 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  412 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  414 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  417 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  421 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  425 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  429 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  432 */       if (i == 0)
/*      */       {
/*  434 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  438 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  442 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  448 */       CError tError = new CError();
/*  449 */       tError.moduleName = "LNPCustImpartDB";
/*  450 */       tError.functionName = "getInfo";
/*  451 */       tError.errorMessage = e.toString();
/*  452 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  454 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  457 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  461 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  465 */       return false;
/*      */     }
/*      */ 
/*  468 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  472 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  477 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPCustImpartSet query()
/*      */   {
/*  482 */     Statement stmt = null;
/*  483 */     ResultSet rs = null;
/*  484 */     LNPCustImpartSet aLNPCustImpartSet = new LNPCustImpartSet();
/*      */ 
/*  486 */     if (!this.mflag) {
/*  487 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  492 */       stmt = this.con.createStatement(1003, 1007);
/*  493 */       SQLString sqlObj = new SQLString("LNPCustImpart");
/*  494 */       LNPCustImpartSchema aSchema = getSchema();
/*  495 */       sqlObj.setSQL(5, aSchema);
/*  496 */       String sql = sqlObj.getSQL();
/*      */ 
/*  498 */       rs = stmt.executeQuery(sql);
/*  499 */       int i = 0;
/*  500 */       while (rs.next())
/*      */       {
/*  502 */         i++;
/*  503 */         LNPCustImpartSchema s1 = new LNPCustImpartSchema();
/*  504 */         s1.setSchema(rs, i);
/*  505 */         aLNPCustImpartSet.add(s1);
/*      */       }try {
/*  507 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  513 */       CError tError = new CError();
/*  514 */       tError.moduleName = "LNPCustImpartDB";
/*  515 */       tError.functionName = "query";
/*  516 */       tError.errorMessage = e.toString();
/*  517 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  519 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  522 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  526 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  532 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  536 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  541 */     return aLNPCustImpartSet;
/*      */   }
/*      */ 
/*      */   public LNPCustImpartSet executeQuery(String sql)
/*      */   {
/*  546 */     Statement stmt = null;
/*  547 */     ResultSet rs = null;
/*  548 */     LNPCustImpartSet aLNPCustImpartSet = new LNPCustImpartSet();
/*      */ 
/*  550 */     if (!this.mflag) {
/*  551 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  556 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  558 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  559 */       int i = 0;
/*  560 */       while (rs.next())
/*      */       {
/*  562 */         i++;
/*  563 */         LNPCustImpartSchema s1 = new LNPCustImpartSchema();
/*  564 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  567 */           CError tError = new CError();
/*  568 */           tError.moduleName = "LNPCustImpartDB";
/*  569 */           tError.functionName = "executeQuery";
/*  570 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  571 */           this.mErrors.addOneError(tError);
/*      */         }
/*  573 */         aLNPCustImpartSet.add(s1);
/*      */       }try {
/*  575 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  581 */       CError tError = new CError();
/*  582 */       tError.moduleName = "LNPCustImpartDB";
/*  583 */       tError.functionName = "executeQuery";
/*  584 */       tError.errorMessage = e.toString();
/*  585 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  587 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  590 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  594 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  600 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  604 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  609 */     return aLNPCustImpartSet;
/*      */   }
/*      */ 
/*      */   public LNPCustImpartSet query(int nStart, int nCount)
/*      */   {
/*  614 */     Statement stmt = null;
/*  615 */     ResultSet rs = null;
/*  616 */     LNPCustImpartSet aLNPCustImpartSet = new LNPCustImpartSet();
/*      */ 
/*  618 */     if (!this.mflag) {
/*  619 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  624 */       stmt = this.con.createStatement(1003, 1007);
/*  625 */       SQLString sqlObj = new SQLString("LNPCustImpart");
/*  626 */       LNPCustImpartSchema aSchema = getSchema();
/*  627 */       sqlObj.setSQL(5, aSchema);
/*  628 */       String sql = sqlObj.getSQL();
/*      */ 
/*  630 */       rs = stmt.executeQuery(sql);
/*  631 */       int i = 0;
/*  632 */       while (rs.next())
/*      */       {
/*  634 */         i++;
/*      */ 
/*  636 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  640 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  644 */         LNPCustImpartSchema s1 = new LNPCustImpartSchema();
/*  645 */         s1.setSchema(rs, i);
/*  646 */         aLNPCustImpartSet.add(s1);
/*      */       }try {
/*  648 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  654 */       CError tError = new CError();
/*  655 */       tError.moduleName = "LNPCustImpartDB";
/*  656 */       tError.functionName = "query";
/*  657 */       tError.errorMessage = e.toString();
/*  658 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  660 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  663 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  667 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  673 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  677 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  682 */     return aLNPCustImpartSet;
/*      */   }
/*      */ 
/*      */   public LNPCustImpartSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  687 */     Statement stmt = null;
/*  688 */     ResultSet rs = null;
/*  689 */     LNPCustImpartSet aLNPCustImpartSet = new LNPCustImpartSet();
/*      */ 
/*  691 */     if (!this.mflag) {
/*  692 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  697 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  699 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  700 */       int i = 0;
/*  701 */       while (rs.next())
/*      */       {
/*  703 */         i++;
/*      */ 
/*  705 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  709 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  713 */         LNPCustImpartSchema s1 = new LNPCustImpartSchema();
/*  714 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  717 */           CError tError = new CError();
/*  718 */           tError.moduleName = "LNPCustImpartDB";
/*  719 */           tError.functionName = "executeQuery";
/*  720 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  721 */           this.mErrors.addOneError(tError);
/*      */         }
/*  723 */         aLNPCustImpartSet.add(s1);
/*      */       }try {
/*  725 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  731 */       CError tError = new CError();
/*  732 */       tError.moduleName = "LNPCustImpartDB";
/*  733 */       tError.functionName = "executeQuery";
/*  734 */       tError.errorMessage = e.toString();
/*  735 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  737 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  740 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  744 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  750 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  754 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  759 */     return aLNPCustImpartSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  764 */     Statement stmt = null;
/*      */ 
/*  766 */     if (!this.mflag) {
/*  767 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  772 */       stmt = this.con.createStatement(1003, 1007);
/*  773 */       SQLString sqlObj = new SQLString("LNPCustImpart");
/*  774 */       LNPCustImpartSchema aSchema = getSchema();
/*  775 */       sqlObj.setSQL(2, aSchema);
/*  776 */       String sql = "update LNPCustImpart " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  778 */       int operCount = stmt.executeUpdate(sql);
/*  779 */       if (operCount == 0)
/*      */       {
/*  782 */         CError tError = new CError();
/*  783 */         tError.moduleName = "LNPCustImpartDB";
/*  784 */         tError.functionName = "update";
/*  785 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  786 */         this.mErrors.addOneError(tError);
/*      */ 
/*  788 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  792 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  796 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  802 */       CError tError = new CError();
/*  803 */       tError.moduleName = "LNPCustImpartDB";
/*  804 */       tError.functionName = "update";
/*  805 */       tError.errorMessage = e.toString();
/*  806 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  808 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  810 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  814 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  818 */       return false;
/*      */     }
/*      */ 
/*  821 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  825 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  830 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  836 */     if (this.mResultSet != null)
/*      */     {
/*  839 */       CError tError = new CError();
/*  840 */       tError.moduleName = "LNPCustImpartDB";
/*  841 */       tError.functionName = "prepareData";
/*  842 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  843 */       this.mErrors.addOneError(tError);
/*  844 */       return false;
/*      */     }
/*      */ 
/*  847 */     if (!this.mflag)
/*      */     {
/*  849 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  853 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  854 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  859 */       CError tError = new CError();
/*  860 */       tError.moduleName = "LNPCustImpartDB";
/*  861 */       tError.functionName = "prepareData";
/*  862 */       tError.errorMessage = e.toString();
/*  863 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  866 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  872 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  876 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  880 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  885 */       return false;
/*      */     }
/*      */ 
/*  888 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  892 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  897 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  903 */     boolean flag = true;
/*  904 */     if (this.mResultSet == null)
/*      */     {
/*  906 */       CError tError = new CError();
/*  907 */       tError.moduleName = "LNPCustImpartDB";
/*  908 */       tError.functionName = "hasMoreData";
/*  909 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  910 */       this.mErrors.addOneError(tError);
/*  911 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  915 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  919 */       CError tError = new CError();
/*  920 */       tError.moduleName = "LNPCustImpartDB";
/*  921 */       tError.functionName = "hasMoreData";
/*  922 */       tError.errorMessage = ex.toString();
/*  923 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  926 */         this.mResultSet.close();
/*  927 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  933 */         this.mStatement.close();
/*  934 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  938 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  942 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  947 */       return false;
/*      */     }
/*  949 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPCustImpartSet getData()
/*      */   {
/*  954 */     int tCount = 0;
/*  955 */     LNPCustImpartSet tLNPCustImpartSet = new LNPCustImpartSet();
/*  956 */     LNPCustImpartSchema tLNPCustImpartSchema = null;
/*  957 */     if (this.mResultSet == null)
/*      */     {
/*  959 */       CError tError = new CError();
/*  960 */       tError.moduleName = "LNPCustImpartDB";
/*  961 */       tError.functionName = "getData";
/*  962 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  963 */       this.mErrors.addOneError(tError);
/*  964 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  968 */       tCount = 1;
/*  969 */       tLNPCustImpartSchema = new LNPCustImpartSchema();
/*  970 */       tLNPCustImpartSchema.setSchema(this.mResultSet, 1);
/*  971 */       tLNPCustImpartSet.add(tLNPCustImpartSchema);
/*      */ 
/*  973 */       while (tCount++ < 5000)
/*      */       {
/*  975 */         if (!this.mResultSet.next())
/*      */           continue;
/*  977 */         tLNPCustImpartSchema = new LNPCustImpartSchema();
/*  978 */         tLNPCustImpartSchema.setSchema(this.mResultSet, 1);
/*  979 */         tLNPCustImpartSet.add(tLNPCustImpartSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  985 */       CError tError = new CError();
/*  986 */       tError.moduleName = "LNPCustImpartDB";
/*  987 */       tError.functionName = "getData";
/*  988 */       tError.errorMessage = ex.toString();
/*  989 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  992 */         this.mResultSet.close();
/*  993 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  999 */         this.mStatement.close();
/* 1000 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1004 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1008 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1013 */       return null;
/*      */     }
/* 1015 */     return tLNPCustImpartSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1020 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1023 */       if (this.mResultSet == null)
/*      */       {
/* 1025 */         CError tError = new CError();
/* 1026 */         tError.moduleName = "LNPCustImpartDB";
/* 1027 */         tError.functionName = "closeData";
/* 1028 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1029 */         this.mErrors.addOneError(tError);
/* 1030 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1034 */         this.mResultSet.close();
/* 1035 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1040 */       CError tError = new CError();
/* 1041 */       tError.moduleName = "LNPCustImpartDB";
/* 1042 */       tError.functionName = "closeData";
/* 1043 */       tError.errorMessage = ex2.toString();
/* 1044 */       this.mErrors.addOneError(tError);
/* 1045 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1049 */       if (this.mStatement == null)
/*      */       {
/* 1051 */         CError tError = new CError();
/* 1052 */         tError.moduleName = "LNPCustImpartDB";
/* 1053 */         tError.functionName = "closeData";
/* 1054 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1055 */         this.mErrors.addOneError(tError);
/* 1056 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1060 */         this.mStatement.close();
/* 1061 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1066 */       CError tError = new CError();
/* 1067 */       tError.moduleName = "LNPCustImpartDB";
/* 1068 */       tError.functionName = "closeData";
/* 1069 */       tError.errorMessage = ex3.toString();
/* 1070 */       this.mErrors.addOneError(tError);
/* 1071 */       flag = false;
/*      */     }
/* 1073 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPCustImpartDB
 * JD-Core Version:    0.6.0
 */