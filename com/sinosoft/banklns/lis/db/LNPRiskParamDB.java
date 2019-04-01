/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskParamSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskParamSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import com.sinosoft.banklns.utility.SQLString;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class LNPRiskParamDB extends LNPRiskParamSchema
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
/*      */   public LNPRiskParamDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPRiskParam");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPRiskParamDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPRiskParam");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPRiskParamSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPRiskParamDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPRiskParamSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPRiskParamDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskParam WHERE  Type = ? AND RiskCode = ? AND Param = ?");
/*   97 */       if ((getType() == null) || (getType().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getType());
/*      */       }
/*  102 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getRiskCode());
/*      */       }
/*  107 */       if ((getParam() == null) || (getParam().equals("null")))
/*  108 */         pstmt.setNull(3, 12);
/*      */       else {
/*  110 */         pstmt.setString(3, getParam());
/*      */       }
/*  112 */       pstmt.executeUpdate();
/*  113 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  116 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  117 */       CError tError = new CError();
/*  118 */       tError.moduleName = "LNPRiskParamDB";
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
/*  155 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskParam SET  Type = ? , RiskCode = ? , Param = ? , Expression = ? , Remark = ? WHERE  Type = ? AND RiskCode = ? AND Param = ?");
/*  156 */       if ((getType() == null) || (getType().equals("null")))
/*  157 */         pstmt.setNull(1, 12);
/*      */       else {
/*  159 */         pstmt.setString(1, getType());
/*      */       }
/*  161 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  162 */         pstmt.setNull(2, 12);
/*      */       else {
/*  164 */         pstmt.setString(2, getRiskCode());
/*      */       }
/*  166 */       if ((getParam() == null) || (getParam().equals("null")))
/*  167 */         pstmt.setNull(3, 12);
/*      */       else {
/*  169 */         pstmt.setString(3, getParam());
/*      */       }
/*  171 */       if ((getExpression() == null) || (getExpression().equals("null")))
/*  172 */         pstmt.setNull(4, 12);
/*      */       else {
/*  174 */         pstmt.setString(4, getExpression());
/*      */       }
/*  176 */       if ((getRemark() == null) || (getRemark().equals("null")))
/*  177 */         pstmt.setNull(5, 12);
/*      */       else {
/*  179 */         pstmt.setString(5, getRemark());
/*      */       }
/*      */ 
/*  182 */       if ((getType() == null) || (getType().equals("null")))
/*  183 */         pstmt.setNull(6, 12);
/*      */       else {
/*  185 */         pstmt.setString(6, getType());
/*      */       }
/*  187 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  188 */         pstmt.setNull(7, 12);
/*      */       else {
/*  190 */         pstmt.setString(7, getRiskCode());
/*      */       }
/*  192 */       if ((getParam() == null) || (getParam().equals("null")))
/*  193 */         pstmt.setNull(8, 12);
/*      */       else {
/*  195 */         pstmt.setString(8, getParam());
/*      */       }
/*  197 */       pstmt.executeUpdate();
/*  198 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  201 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  202 */       CError tError = new CError();
/*  203 */       tError.moduleName = "LNPRiskParamDB";
/*  204 */       tError.functionName = "update()";
/*  205 */       tError.errorMessage = ex.toString();
/*  206 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  209 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  212 */       if (!this.mflag)
/*      */         try {
/*  214 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  218 */       return false;
/*      */     }
/*      */ 
/*  221 */     if (!this.mflag)
/*      */       try {
/*  223 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  227 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  232 */     PreparedStatement pstmt = null;
/*      */ 
/*  234 */     if (!this.mflag) {
/*  235 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  240 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskParam VALUES( ? , ? , ? , ? , ?)");
/*  241 */       if ((getType() == null) || (getType().equals("null")))
/*  242 */         pstmt.setNull(1, 12);
/*      */       else {
/*  244 */         pstmt.setString(1, getType());
/*      */       }
/*  246 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  247 */         pstmt.setNull(2, 12);
/*      */       else {
/*  249 */         pstmt.setString(2, getRiskCode());
/*      */       }
/*  251 */       if ((getParam() == null) || (getParam().equals("null")))
/*  252 */         pstmt.setNull(3, 12);
/*      */       else {
/*  254 */         pstmt.setString(3, getParam());
/*      */       }
/*  256 */       if ((getExpression() == null) || (getExpression().equals("null")))
/*  257 */         pstmt.setNull(4, 12);
/*      */       else {
/*  259 */         pstmt.setString(4, getExpression());
/*      */       }
/*  261 */       if ((getRemark() == null) || (getRemark().equals("null")))
/*  262 */         pstmt.setNull(5, 12);
/*      */       else {
/*  264 */         pstmt.setString(5, getRemark());
/*      */       }
/*      */ 
/*  267 */       pstmt.executeUpdate();
/*  268 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  271 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  272 */       CError tError = new CError();
/*  273 */       tError.moduleName = "LNPRiskParamDB";
/*  274 */       tError.functionName = "insert()";
/*  275 */       tError.errorMessage = ex.toString();
/*  276 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  279 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  282 */       if (!this.mflag)
/*      */         try {
/*  284 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  288 */       return false;
/*      */     }
/*      */ 
/*  291 */     if (!this.mflag)
/*      */       try {
/*  293 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  297 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  302 */     PreparedStatement pstmt = null;
/*  303 */     ResultSet rs = null;
/*      */ 
/*  305 */     if (!this.mflag) {
/*  306 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  311 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRiskParam WHERE  Type = ? AND RiskCode = ? AND Param = ?", 
/*  312 */         1003, 1007);
/*  313 */       if ((getType() == null) || (getType().equals("null")))
/*  314 */         pstmt.setNull(1, 12);
/*      */       else {
/*  316 */         pstmt.setString(1, getType());
/*      */       }
/*  318 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  319 */         pstmt.setNull(2, 12);
/*      */       else {
/*  321 */         pstmt.setString(2, getRiskCode());
/*      */       }
/*  323 */       if ((getParam() == null) || (getParam().equals("null")))
/*  324 */         pstmt.setNull(3, 12);
/*      */       else {
/*  326 */         pstmt.setString(3, getParam());
/*      */       }
/*  328 */       rs = pstmt.executeQuery();
/*  329 */       int i = 0;
/*  330 */       if (rs.next())
/*      */       {
/*  332 */         i++;
/*  333 */         if (!setSchema(rs, i))
/*      */         {
/*  336 */           CError tError = new CError();
/*  337 */           tError.moduleName = "LNPRiskParamDB";
/*  338 */           tError.functionName = "getInfo";
/*  339 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  340 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  342 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  345 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  349 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  353 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  357 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  360 */       if (i == 0)
/*      */       {
/*  362 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  366 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  370 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  376 */       CError tError = new CError();
/*  377 */       tError.moduleName = "LNPRiskParamDB";
/*  378 */       tError.functionName = "getInfo";
/*  379 */       tError.errorMessage = e.toString();
/*  380 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  382 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  385 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  389 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  393 */       return false;
/*      */     }
/*      */ 
/*  396 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  400 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  405 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRiskParamSet query()
/*      */   {
/*  410 */     Statement stmt = null;
/*  411 */     ResultSet rs = null;
/*  412 */     LNPRiskParamSet aLNPRiskParamSet = new LNPRiskParamSet();
/*      */ 
/*  414 */     if (!this.mflag) {
/*  415 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  420 */       stmt = this.con.createStatement(1003, 1007);
/*  421 */       SQLString sqlObj = new SQLString("LNPRiskParam");
/*  422 */       LNPRiskParamSchema aSchema = getSchema();
/*  423 */       sqlObj.setSQL(5, aSchema);
/*  424 */       String sql = sqlObj.getSQL();
/*      */ 
/*  426 */       rs = stmt.executeQuery(sql);
/*  427 */       int i = 0;
/*  428 */       while (rs.next())
/*      */       {
/*  430 */         i++;
/*  431 */         LNPRiskParamSchema s1 = new LNPRiskParamSchema();
/*  432 */         s1.setSchema(rs, i);
/*  433 */         aLNPRiskParamSet.add(s1);
/*      */       }try {
/*  435 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  441 */       CError tError = new CError();
/*  442 */       tError.moduleName = "LNPRiskParamDB";
/*  443 */       tError.functionName = "query";
/*  444 */       tError.errorMessage = e.toString();
/*  445 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  447 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  450 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  454 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  460 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  464 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  469 */     return aLNPRiskParamSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskParamSet executeQuery(String sql)
/*      */   {
/*  474 */     Statement stmt = null;
/*  475 */     ResultSet rs = null;
/*  476 */     LNPRiskParamSet aLNPRiskParamSet = new LNPRiskParamSet();
/*      */ 
/*  478 */     if (!this.mflag) {
/*  479 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  484 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  486 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  487 */       int i = 0;
/*  488 */       while (rs.next())
/*      */       {
/*  490 */         i++;
/*  491 */         LNPRiskParamSchema s1 = new LNPRiskParamSchema();
/*  492 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  495 */           CError tError = new CError();
/*  496 */           tError.moduleName = "LNPRiskParamDB";
/*  497 */           tError.functionName = "executeQuery";
/*  498 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  499 */           this.mErrors.addOneError(tError);
/*      */         }
/*  501 */         aLNPRiskParamSet.add(s1);
/*      */       }try {
/*  503 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  509 */       CError tError = new CError();
/*  510 */       tError.moduleName = "LNPRiskParamDB";
/*  511 */       tError.functionName = "executeQuery";
/*  512 */       tError.errorMessage = e.toString();
/*  513 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  515 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  518 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  522 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  528 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  532 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  537 */     return aLNPRiskParamSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskParamSet query(int nStart, int nCount)
/*      */   {
/*  542 */     Statement stmt = null;
/*  543 */     ResultSet rs = null;
/*  544 */     LNPRiskParamSet aLNPRiskParamSet = new LNPRiskParamSet();
/*      */ 
/*  546 */     if (!this.mflag) {
/*  547 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  552 */       stmt = this.con.createStatement(1003, 1007);
/*  553 */       SQLString sqlObj = new SQLString("LNPRiskParam");
/*  554 */       LNPRiskParamSchema aSchema = getSchema();
/*  555 */       sqlObj.setSQL(5, aSchema);
/*  556 */       String sql = sqlObj.getSQL();
/*      */ 
/*  558 */       rs = stmt.executeQuery(sql);
/*  559 */       int i = 0;
/*  560 */       while (rs.next())
/*      */       {
/*  562 */         i++;
/*      */ 
/*  564 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  568 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  572 */         LNPRiskParamSchema s1 = new LNPRiskParamSchema();
/*  573 */         s1.setSchema(rs, i);
/*  574 */         aLNPRiskParamSet.add(s1);
/*      */       }try {
/*  576 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  582 */       CError tError = new CError();
/*  583 */       tError.moduleName = "LNPRiskParamDB";
/*  584 */       tError.functionName = "query";
/*  585 */       tError.errorMessage = e.toString();
/*  586 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  588 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  591 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  595 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  601 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  605 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  610 */     return aLNPRiskParamSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskParamSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  615 */     Statement stmt = null;
/*  616 */     ResultSet rs = null;
/*  617 */     LNPRiskParamSet aLNPRiskParamSet = new LNPRiskParamSet();
/*      */ 
/*  619 */     if (!this.mflag) {
/*  620 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  625 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  627 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  628 */       int i = 0;
/*  629 */       while (rs.next())
/*      */       {
/*  631 */         i++;
/*      */ 
/*  633 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  637 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  641 */         LNPRiskParamSchema s1 = new LNPRiskParamSchema();
/*  642 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  645 */           CError tError = new CError();
/*  646 */           tError.moduleName = "LNPRiskParamDB";
/*  647 */           tError.functionName = "executeQuery";
/*  648 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  649 */           this.mErrors.addOneError(tError);
/*      */         }
/*  651 */         aLNPRiskParamSet.add(s1);
/*      */       }try {
/*  653 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  659 */       CError tError = new CError();
/*  660 */       tError.moduleName = "LNPRiskParamDB";
/*  661 */       tError.functionName = "executeQuery";
/*  662 */       tError.errorMessage = e.toString();
/*  663 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  665 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  668 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  672 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  678 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  682 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  687 */     return aLNPRiskParamSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  692 */     Statement stmt = null;
/*      */ 
/*  694 */     if (!this.mflag) {
/*  695 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  700 */       stmt = this.con.createStatement(1003, 1007);
/*  701 */       SQLString sqlObj = new SQLString("LNPRiskParam");
/*  702 */       LNPRiskParamSchema aSchema = getSchema();
/*  703 */       sqlObj.setSQL(2, aSchema);
/*  704 */       String sql = "update LNPRiskParam " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  706 */       int operCount = stmt.executeUpdate(sql);
/*  707 */       if (operCount == 0)
/*      */       {
/*  710 */         CError tError = new CError();
/*  711 */         tError.moduleName = "LNPRiskParamDB";
/*  712 */         tError.functionName = "update";
/*  713 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  714 */         this.mErrors.addOneError(tError);
/*      */ 
/*  716 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  720 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  724 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  730 */       CError tError = new CError();
/*  731 */       tError.moduleName = "LNPRiskParamDB";
/*  732 */       tError.functionName = "update";
/*  733 */       tError.errorMessage = e.toString();
/*  734 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  736 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  738 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  742 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  746 */       return false;
/*      */     }
/*      */ 
/*  749 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  753 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  758 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  764 */     if (this.mResultSet != null)
/*      */     {
/*  767 */       CError tError = new CError();
/*  768 */       tError.moduleName = "LNPRiskParamDB";
/*  769 */       tError.functionName = "prepareData";
/*  770 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  771 */       this.mErrors.addOneError(tError);
/*  772 */       return false;
/*      */     }
/*      */ 
/*  775 */     if (!this.mflag)
/*      */     {
/*  777 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  781 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  782 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  787 */       CError tError = new CError();
/*  788 */       tError.moduleName = "LNPRiskParamDB";
/*  789 */       tError.functionName = "prepareData";
/*  790 */       tError.errorMessage = e.toString();
/*  791 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  794 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  800 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  804 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  808 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  813 */       return false;
/*      */     }
/*      */ 
/*  816 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  820 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  825 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  831 */     boolean flag = true;
/*  832 */     if (this.mResultSet == null)
/*      */     {
/*  834 */       CError tError = new CError();
/*  835 */       tError.moduleName = "LNPRiskParamDB";
/*  836 */       tError.functionName = "hasMoreData";
/*  837 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  838 */       this.mErrors.addOneError(tError);
/*  839 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  843 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  847 */       CError tError = new CError();
/*  848 */       tError.moduleName = "LNPRiskParamDB";
/*  849 */       tError.functionName = "hasMoreData";
/*  850 */       tError.errorMessage = ex.toString();
/*  851 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  854 */         this.mResultSet.close();
/*  855 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  861 */         this.mStatement.close();
/*  862 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  866 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  870 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  875 */       return false;
/*      */     }
/*  877 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPRiskParamSet getData()
/*      */   {
/*  882 */     int tCount = 0;
/*  883 */     LNPRiskParamSet tLNPRiskParamSet = new LNPRiskParamSet();
/*  884 */     LNPRiskParamSchema tLNPRiskParamSchema = null;
/*  885 */     if (this.mResultSet == null)
/*      */     {
/*  887 */       CError tError = new CError();
/*  888 */       tError.moduleName = "LNPRiskParamDB";
/*  889 */       tError.functionName = "getData";
/*  890 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  891 */       this.mErrors.addOneError(tError);
/*  892 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  896 */       tCount = 1;
/*  897 */       tLNPRiskParamSchema = new LNPRiskParamSchema();
/*  898 */       tLNPRiskParamSchema.setSchema(this.mResultSet, 1);
/*  899 */       tLNPRiskParamSet.add(tLNPRiskParamSchema);
/*      */ 
/*  901 */       while (tCount++ < 5000)
/*      */       {
/*  903 */         if (!this.mResultSet.next())
/*      */           continue;
/*  905 */         tLNPRiskParamSchema = new LNPRiskParamSchema();
/*  906 */         tLNPRiskParamSchema.setSchema(this.mResultSet, 1);
/*  907 */         tLNPRiskParamSet.add(tLNPRiskParamSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  913 */       CError tError = new CError();
/*  914 */       tError.moduleName = "LNPRiskParamDB";
/*  915 */       tError.functionName = "getData";
/*  916 */       tError.errorMessage = ex.toString();
/*  917 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  920 */         this.mResultSet.close();
/*  921 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  927 */         this.mStatement.close();
/*  928 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  932 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  936 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  941 */       return null;
/*      */     }
/*  943 */     return tLNPRiskParamSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  948 */     boolean flag = true;
/*      */     try
/*      */     {
/*  951 */       if (this.mResultSet == null)
/*      */       {
/*  953 */         CError tError = new CError();
/*  954 */         tError.moduleName = "LNPRiskParamDB";
/*  955 */         tError.functionName = "closeData";
/*  956 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/*  957 */         this.mErrors.addOneError(tError);
/*  958 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  962 */         this.mResultSet.close();
/*  963 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/*  968 */       CError tError = new CError();
/*  969 */       tError.moduleName = "LNPRiskParamDB";
/*  970 */       tError.functionName = "closeData";
/*  971 */       tError.errorMessage = ex2.toString();
/*  972 */       this.mErrors.addOneError(tError);
/*  973 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/*  977 */       if (this.mStatement == null)
/*      */       {
/*  979 */         CError tError = new CError();
/*  980 */         tError.moduleName = "LNPRiskParamDB";
/*  981 */         tError.functionName = "closeData";
/*  982 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/*  983 */         this.mErrors.addOneError(tError);
/*  984 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  988 */         this.mStatement.close();
/*  989 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/*  994 */       CError tError = new CError();
/*  995 */       tError.moduleName = "LNPRiskParamDB";
/*  996 */       tError.functionName = "closeData";
/*  997 */       tError.errorMessage = ex3.toString();
/*  998 */       this.mErrors.addOneError(tError);
/*  999 */       flag = false;
/*      */     }
/* 1001 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskParamDB
 * JD-Core Version:    0.6.0
 */