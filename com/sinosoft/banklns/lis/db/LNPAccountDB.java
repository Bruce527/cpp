/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPAccountSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAccountSet;
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
/*      */ public class LNPAccountDB extends LNPAccountSchema
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
/*      */   public LNPAccountDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPAccount");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPAccountDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPAccount");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPAccountSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPAccountDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPAccountSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPAccountDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAccount WHERE  CustomerNo = ? AND BankCode = ? AND BankAccNo = ?");
/*   97 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getCustomerNo());
/*      */       }
/*  102 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getBankCode());
/*      */       }
/*  107 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  108 */         pstmt.setNull(3, 12);
/*      */       else {
/*  110 */         pstmt.setString(3, getBankAccNo());
/*      */       }
/*  112 */       pstmt.executeUpdate();
/*  113 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  116 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  117 */       CError tError = new CError();
/*  118 */       tError.moduleName = "LNPAccountDB";
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
/*  155 */       pstmt = this.con.prepareStatement("UPDATE LNPAccount SET  CustomerId = ? , CustomerNo = ? , AccKind = ? , BankCode = ? , BankAccNo = ? , AccName = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  CustomerNo = ? AND BankCode = ? AND BankAccNo = ?");
/*  156 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  157 */         pstmt.setNull(1, 12);
/*      */       else {
/*  159 */         pstmt.setString(1, getCustomerId());
/*      */       }
/*  161 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  162 */         pstmt.setNull(2, 12);
/*      */       else {
/*  164 */         pstmt.setString(2, getCustomerNo());
/*      */       }
/*  166 */       if ((getAccKind() == null) || (getAccKind().equals("null")))
/*  167 */         pstmt.setNull(3, 12);
/*      */       else {
/*  169 */         pstmt.setString(3, getAccKind());
/*      */       }
/*  171 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  172 */         pstmt.setNull(4, 12);
/*      */       else {
/*  174 */         pstmt.setString(4, getBankCode());
/*      */       }
/*  176 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  177 */         pstmt.setNull(5, 12);
/*      */       else {
/*  179 */         pstmt.setString(5, getBankAccNo());
/*      */       }
/*  181 */       if ((getAccName() == null) || (getAccName().equals("null")))
/*  182 */         pstmt.setNull(6, 12);
/*      */       else {
/*  184 */         pstmt.setString(6, getAccName());
/*      */       }
/*  186 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  187 */         pstmt.setNull(7, 12);
/*      */       else {
/*  189 */         pstmt.setString(7, getOperator());
/*      */       }
/*  191 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  192 */         pstmt.setNull(8, 91);
/*      */       else {
/*  194 */         pstmt.setDate(8, Date.valueOf(getMakeDate()));
/*      */       }
/*  196 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  197 */         pstmt.setNull(9, 12);
/*      */       else {
/*  199 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  201 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  202 */         pstmt.setNull(10, 91);
/*      */       else {
/*  204 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  206 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  207 */         pstmt.setNull(11, 12);
/*      */       else {
/*  209 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*      */ 
/*  212 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  213 */         pstmt.setNull(12, 12);
/*      */       else {
/*  215 */         pstmt.setString(12, getCustomerNo());
/*      */       }
/*  217 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  218 */         pstmt.setNull(13, 12);
/*      */       else {
/*  220 */         pstmt.setString(13, getBankCode());
/*      */       }
/*  222 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  223 */         pstmt.setNull(14, 12);
/*      */       else {
/*  225 */         pstmt.setString(14, getBankAccNo());
/*      */       }
/*  227 */       pstmt.executeUpdate();
/*  228 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  231 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  232 */       CError tError = new CError();
/*  233 */       tError.moduleName = "LNPAccountDB";
/*  234 */       tError.functionName = "update()";
/*  235 */       tError.errorMessage = ex.toString();
/*  236 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  239 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  242 */       if (!this.mflag)
/*      */         try {
/*  244 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  248 */       return false;
/*      */     }
/*      */ 
/*  251 */     if (!this.mflag)
/*      */       try {
/*  253 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  257 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  262 */     PreparedStatement pstmt = null;
/*      */ 
/*  264 */     if (!this.mflag) {
/*  265 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  270 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAccount VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  271 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  272 */         pstmt.setNull(1, 12);
/*      */       else {
/*  274 */         pstmt.setString(1, getCustomerId());
/*      */       }
/*  276 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  277 */         pstmt.setNull(2, 12);
/*      */       else {
/*  279 */         pstmt.setString(2, getCustomerNo());
/*      */       }
/*  281 */       if ((getAccKind() == null) || (getAccKind().equals("null")))
/*  282 */         pstmt.setNull(3, 12);
/*      */       else {
/*  284 */         pstmt.setString(3, getAccKind());
/*      */       }
/*  286 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  287 */         pstmt.setNull(4, 12);
/*      */       else {
/*  289 */         pstmt.setString(4, getBankCode());
/*      */       }
/*  291 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  292 */         pstmt.setNull(5, 12);
/*      */       else {
/*  294 */         pstmt.setString(5, getBankAccNo());
/*      */       }
/*  296 */       if ((getAccName() == null) || (getAccName().equals("null")))
/*  297 */         pstmt.setNull(6, 12);
/*      */       else {
/*  299 */         pstmt.setString(6, getAccName());
/*      */       }
/*  301 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  302 */         pstmt.setNull(7, 12);
/*      */       else {
/*  304 */         pstmt.setString(7, getOperator());
/*      */       }
/*  306 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  307 */         pstmt.setNull(8, 91);
/*      */       else {
/*  309 */         pstmt.setDate(8, Date.valueOf(getMakeDate()));
/*      */       }
/*  311 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  312 */         pstmt.setNull(9, 12);
/*      */       else {
/*  314 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  316 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  317 */         pstmt.setNull(10, 91);
/*      */       else {
/*  319 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  321 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  322 */         pstmt.setNull(11, 12);
/*      */       else {
/*  324 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*      */ 
/*  327 */       pstmt.executeUpdate();
/*  328 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  331 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  332 */       CError tError = new CError();
/*  333 */       tError.moduleName = "LNPAccountDB";
/*  334 */       tError.functionName = "insert()";
/*  335 */       tError.errorMessage = ex.toString();
/*  336 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  339 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  342 */       if (!this.mflag)
/*      */         try {
/*  344 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  348 */       return false;
/*      */     }
/*      */ 
/*  351 */     if (!this.mflag)
/*      */       try {
/*  353 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  357 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  362 */     PreparedStatement pstmt = null;
/*  363 */     ResultSet rs = null;
/*      */ 
/*  365 */     if (!this.mflag) {
/*  366 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  371 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPAccount WHERE  CustomerNo = ? AND BankCode = ? AND BankAccNo = ?", 
/*  372 */         1003, 1007);
/*  373 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  374 */         pstmt.setNull(1, 12);
/*      */       else {
/*  376 */         pstmt.setString(1, getCustomerNo());
/*      */       }
/*  378 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  379 */         pstmt.setNull(2, 12);
/*      */       else {
/*  381 */         pstmt.setString(2, getBankCode());
/*      */       }
/*  383 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  384 */         pstmt.setNull(3, 12);
/*      */       else {
/*  386 */         pstmt.setString(3, getBankAccNo());
/*      */       }
/*  388 */       rs = pstmt.executeQuery();
/*  389 */       int i = 0;
/*  390 */       if (rs.next())
/*      */       {
/*  392 */         i++;
/*  393 */         if (!setSchema(rs, i))
/*      */         {
/*  396 */           CError tError = new CError();
/*  397 */           tError.moduleName = "LNPAccountDB";
/*  398 */           tError.functionName = "getInfo";
/*  399 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  400 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  402 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  405 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  409 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  413 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  417 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  420 */       if (i == 0)
/*      */       {
/*  422 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  426 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  430 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  436 */       CError tError = new CError();
/*  437 */       tError.moduleName = "LNPAccountDB";
/*  438 */       tError.functionName = "getInfo";
/*  439 */       tError.errorMessage = e.toString();
/*  440 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  442 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  445 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  449 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  453 */       return false;
/*      */     }
/*      */ 
/*  456 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  460 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  465 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAccountSet query()
/*      */   {
/*  470 */     Statement stmt = null;
/*  471 */     ResultSet rs = null;
/*  472 */     LNPAccountSet aLNPAccountSet = new LNPAccountSet();
/*      */ 
/*  474 */     if (!this.mflag) {
/*  475 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  480 */       stmt = this.con.createStatement(1003, 1007);
/*  481 */       SQLString sqlObj = new SQLString("LNPAccount");
/*  482 */       LNPAccountSchema aSchema = getSchema();
/*  483 */       sqlObj.setSQL(5, aSchema);
/*  484 */       String sql = sqlObj.getSQL();
/*      */ 
/*  486 */       rs = stmt.executeQuery(sql);
/*  487 */       int i = 0;
/*  488 */       while (rs.next())
/*      */       {
/*  490 */         i++;
/*  491 */         LNPAccountSchema s1 = new LNPAccountSchema();
/*  492 */         s1.setSchema(rs, i);
/*  493 */         aLNPAccountSet.add(s1);
/*      */       }try {
/*  495 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  501 */       CError tError = new CError();
/*  502 */       tError.moduleName = "LNPAccountDB";
/*  503 */       tError.functionName = "query";
/*  504 */       tError.errorMessage = e.toString();
/*  505 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  507 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  510 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  514 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  520 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  524 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  529 */     return aLNPAccountSet;
/*      */   }
/*      */ 
/*      */   public LNPAccountSet executeQuery(String sql)
/*      */   {
/*  534 */     Statement stmt = null;
/*  535 */     ResultSet rs = null;
/*  536 */     LNPAccountSet aLNPAccountSet = new LNPAccountSet();
/*      */ 
/*  538 */     if (!this.mflag) {
/*  539 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  544 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  546 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  547 */       int i = 0;
/*  548 */       while (rs.next())
/*      */       {
/*  550 */         i++;
/*  551 */         LNPAccountSchema s1 = new LNPAccountSchema();
/*  552 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  555 */           CError tError = new CError();
/*  556 */           tError.moduleName = "LNPAccountDB";
/*  557 */           tError.functionName = "executeQuery";
/*  558 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  559 */           this.mErrors.addOneError(tError);
/*      */         }
/*  561 */         aLNPAccountSet.add(s1);
/*      */       }try {
/*  563 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  569 */       CError tError = new CError();
/*  570 */       tError.moduleName = "LNPAccountDB";
/*  571 */       tError.functionName = "executeQuery";
/*  572 */       tError.errorMessage = e.toString();
/*  573 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  575 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  578 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  582 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  588 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  592 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  597 */     return aLNPAccountSet;
/*      */   }
/*      */ 
/*      */   public LNPAccountSet query(int nStart, int nCount)
/*      */   {
/*  602 */     Statement stmt = null;
/*  603 */     ResultSet rs = null;
/*  604 */     LNPAccountSet aLNPAccountSet = new LNPAccountSet();
/*      */ 
/*  606 */     if (!this.mflag) {
/*  607 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  612 */       stmt = this.con.createStatement(1003, 1007);
/*  613 */       SQLString sqlObj = new SQLString("LNPAccount");
/*  614 */       LNPAccountSchema aSchema = getSchema();
/*  615 */       sqlObj.setSQL(5, aSchema);
/*  616 */       String sql = sqlObj.getSQL();
/*      */ 
/*  618 */       rs = stmt.executeQuery(sql);
/*  619 */       int i = 0;
/*  620 */       while (rs.next())
/*      */       {
/*  622 */         i++;
/*      */ 
/*  624 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  628 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  632 */         LNPAccountSchema s1 = new LNPAccountSchema();
/*  633 */         s1.setSchema(rs, i);
/*  634 */         aLNPAccountSet.add(s1);
/*      */       }try {
/*  636 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  642 */       CError tError = new CError();
/*  643 */       tError.moduleName = "LNPAccountDB";
/*  644 */       tError.functionName = "query";
/*  645 */       tError.errorMessage = e.toString();
/*  646 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  648 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  651 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  655 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  661 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  665 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  670 */     return aLNPAccountSet;
/*      */   }
/*      */ 
/*      */   public LNPAccountSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  675 */     Statement stmt = null;
/*  676 */     ResultSet rs = null;
/*  677 */     LNPAccountSet aLNPAccountSet = new LNPAccountSet();
/*      */ 
/*  679 */     if (!this.mflag) {
/*  680 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  685 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  687 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  688 */       int i = 0;
/*  689 */       while (rs.next())
/*      */       {
/*  691 */         i++;
/*      */ 
/*  693 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  697 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  701 */         LNPAccountSchema s1 = new LNPAccountSchema();
/*  702 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  705 */           CError tError = new CError();
/*  706 */           tError.moduleName = "LNPAccountDB";
/*  707 */           tError.functionName = "executeQuery";
/*  708 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  709 */           this.mErrors.addOneError(tError);
/*      */         }
/*  711 */         aLNPAccountSet.add(s1);
/*      */       }try {
/*  713 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  719 */       CError tError = new CError();
/*  720 */       tError.moduleName = "LNPAccountDB";
/*  721 */       tError.functionName = "executeQuery";
/*  722 */       tError.errorMessage = e.toString();
/*  723 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  725 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  728 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  732 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  738 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  742 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  747 */     return aLNPAccountSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  752 */     Statement stmt = null;
/*      */ 
/*  754 */     if (!this.mflag) {
/*  755 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  760 */       stmt = this.con.createStatement(1003, 1007);
/*  761 */       SQLString sqlObj = new SQLString("LNPAccount");
/*  762 */       LNPAccountSchema aSchema = getSchema();
/*  763 */       sqlObj.setSQL(2, aSchema);
/*  764 */       String sql = "update LNPAccount " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  766 */       int operCount = stmt.executeUpdate(sql);
/*  767 */       if (operCount == 0)
/*      */       {
/*  770 */         CError tError = new CError();
/*  771 */         tError.moduleName = "LNPAccountDB";
/*  772 */         tError.functionName = "update";
/*  773 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  774 */         this.mErrors.addOneError(tError);
/*      */ 
/*  776 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  780 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  784 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  790 */       CError tError = new CError();
/*  791 */       tError.moduleName = "LNPAccountDB";
/*  792 */       tError.functionName = "update";
/*  793 */       tError.errorMessage = e.toString();
/*  794 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  796 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  798 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  802 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  806 */       return false;
/*      */     }
/*      */ 
/*  809 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  813 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  818 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  824 */     if (this.mResultSet != null)
/*      */     {
/*  827 */       CError tError = new CError();
/*  828 */       tError.moduleName = "LNPAccountDB";
/*  829 */       tError.functionName = "prepareData";
/*  830 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u53E7\u95C2\uE168\u7D12";
/*  831 */       this.mErrors.addOneError(tError);
/*  832 */       return false;
/*      */     }
/*      */ 
/*  835 */     if (!this.mflag)
/*      */     {
/*  837 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  841 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  842 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  846 */       CError tError = new CError();
/*  847 */       tError.moduleName = "LNPAccountDB";
/*  848 */       tError.functionName = "prepareData";
/*  849 */       tError.errorMessage = e.toString();
/*  850 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  853 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  859 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  863 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  867 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  872 */       return false;
/*      */     }
/*      */ 
/*  875 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  879 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  884 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  889 */     boolean flag = true;
/*  890 */     if (this.mResultSet == null)
/*      */     {
/*  892 */       CError tError = new CError();
/*  893 */       tError.moduleName = "LNPAccountDB";
/*  894 */       tError.functionName = "hasMoreData";
/*  895 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  896 */       this.mErrors.addOneError(tError);
/*  897 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  901 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  905 */       CError tError = new CError();
/*  906 */       tError.moduleName = "LNPAccountDB";
/*  907 */       tError.functionName = "hasMoreData";
/*  908 */       tError.errorMessage = ex.toString();
/*  909 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  912 */         this.mResultSet.close();
/*  913 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  919 */         this.mStatement.close();
/*  920 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  924 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  928 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  933 */       return false;
/*      */     }
/*  935 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPAccountSet getData() {
/*  939 */     int tCount = 0;
/*  940 */     LNPAccountSet tLNPAccountSet = new LNPAccountSet();
/*  941 */     LNPAccountSchema tLNPAccountSchema = null;
/*  942 */     if (this.mResultSet == null)
/*      */     {
/*  944 */       CError tError = new CError();
/*  945 */       tError.moduleName = "LNPAccountDB";
/*  946 */       tError.functionName = "getData";
/*  947 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  948 */       this.mErrors.addOneError(tError);
/*  949 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  953 */       tCount = 1;
/*  954 */       tLNPAccountSchema = new LNPAccountSchema();
/*  955 */       tLNPAccountSchema.setSchema(this.mResultSet, 1);
/*  956 */       tLNPAccountSet.add(tLNPAccountSchema);
/*      */ 
/*  958 */       while (tCount++ < 5000)
/*      */       {
/*  960 */         if (!this.mResultSet.next())
/*      */           continue;
/*  962 */         tLNPAccountSchema = new LNPAccountSchema();
/*  963 */         tLNPAccountSchema.setSchema(this.mResultSet, 1);
/*  964 */         tLNPAccountSet.add(tLNPAccountSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  970 */       CError tError = new CError();
/*  971 */       tError.moduleName = "LNPAccountDB";
/*  972 */       tError.functionName = "getData";
/*  973 */       tError.errorMessage = ex.toString();
/*  974 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  977 */         this.mResultSet.close();
/*  978 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  984 */         this.mStatement.close();
/*  985 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  989 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  993 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  998 */       return null;
/*      */     }
/* 1000 */     return tLNPAccountSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData() {
/* 1004 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1007 */       if (this.mResultSet == null)
/*      */       {
/* 1009 */         CError tError = new CError();
/* 1010 */         tError.moduleName = "LNPAccountDB";
/* 1011 */         tError.functionName = "closeData";
/* 1012 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1013 */         this.mErrors.addOneError(tError);
/* 1014 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1018 */         this.mResultSet.close();
/* 1019 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1024 */       CError tError = new CError();
/* 1025 */       tError.moduleName = "LNPAccountDB";
/* 1026 */       tError.functionName = "closeData";
/* 1027 */       tError.errorMessage = ex2.toString();
/* 1028 */       this.mErrors.addOneError(tError);
/* 1029 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1033 */       if (this.mStatement == null)
/*      */       {
/* 1035 */         CError tError = new CError();
/* 1036 */         tError.moduleName = "LNPAccountDB";
/* 1037 */         tError.functionName = "closeData";
/* 1038 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1039 */         this.mErrors.addOneError(tError);
/* 1040 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1044 */         this.mStatement.close();
/* 1045 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1050 */       CError tError = new CError();
/* 1051 */       tError.moduleName = "LNPAccountDB";
/* 1052 */       tError.functionName = "closeData";
/* 1053 */       tError.errorMessage = ex3.toString();
/* 1054 */       this.mErrors.addOneError(tError);
/* 1055 */       flag = false;
/*      */     }
/* 1057 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPAccountDB
 * JD-Core Version:    0.6.0
 */