/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPInvestRiskDataSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestRiskDataSet;
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
/*      */ public class LNPInvestRiskDataDB extends LNPInvestRiskDataSchema
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
/*      */   public LNPInvestRiskDataDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPInvestRiskData");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPInvestRiskDataDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPInvestRiskData");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPInvestRiskDataSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPInvestRiskDataDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPInvestRiskDataSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPInvestRiskDataDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPInvestRiskData WHERE  Dataid = ?");
/*   97 */       if ((getDataid() == null) || (getDataid().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getDataid());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPInvestRiskDataDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPInvestRiskData SET  Dataid = ? , Signno = ? , Type = ? , Serialno = ? , Age = ? , Degree = ? , Value = ? , Protagonist = ? , exponent = ? , banlance = ? , solidity = ? , prevent = ? , remark1 = ? , remark2 = ? , remark3 = ? , remark4 = ? WHERE  Dataid = ?");
/*  146 */       if ((getDataid() == null) || (getDataid().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getDataid());
/*      */       }
/*  151 */       if ((getSignno() == null) || (getSignno().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getSignno());
/*      */       }
/*  156 */       if ((getType() == null) || (getType().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getType());
/*      */       }
/*  161 */       pstmt.setInt(4, getSerialno());
/*  162 */       pstmt.setInt(5, getAge());
/*  163 */       pstmt.setInt(6, getDegree());
/*  164 */       pstmt.setDouble(7, getValue());
/*  165 */       pstmt.setInt(8, getProtagonist());
/*  166 */       pstmt.setInt(9, getExponent());
/*  167 */       pstmt.setInt(10, getBanlance());
/*  168 */       pstmt.setInt(11, getSolidity());
/*  169 */       pstmt.setInt(12, getPrevent());
/*  170 */       if ((getRemark1() == null) || (getRemark1().equals("null")))
/*  171 */         pstmt.setNull(13, 12);
/*      */       else {
/*  173 */         pstmt.setString(13, getRemark1());
/*      */       }
/*  175 */       if ((getRemark2() == null) || (getRemark2().equals("null")))
/*  176 */         pstmt.setNull(14, 12);
/*      */       else {
/*  178 */         pstmt.setString(14, getRemark2());
/*      */       }
/*  180 */       if ((getRemark3() == null) || (getRemark3().equals("null")))
/*  181 */         pstmt.setNull(15, 12);
/*      */       else {
/*  183 */         pstmt.setString(15, getRemark3());
/*      */       }
/*  185 */       if ((getRemark4() == null) || (getRemark4().equals("null")))
/*  186 */         pstmt.setNull(16, 12);
/*      */       else {
/*  188 */         pstmt.setString(16, getRemark4());
/*      */       }
/*      */ 
/*  191 */       if ((getDataid() == null) || (getDataid().equals("null")))
/*  192 */         pstmt.setNull(17, 12);
/*      */       else {
/*  194 */         pstmt.setString(17, getDataid());
/*      */       }
/*  196 */       pstmt.executeUpdate();
/*  197 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  200 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  201 */       CError tError = new CError();
/*  202 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  203 */       tError.functionName = "update()";
/*  204 */       tError.errorMessage = ex.toString();
/*  205 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  208 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  211 */       if (!this.mflag)
/*      */         try {
/*  213 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  217 */       return false;
/*      */     }
/*      */ 
/*  220 */     if (!this.mflag)
/*      */       try {
/*  222 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  226 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  231 */     PreparedStatement pstmt = null;
/*      */ 
/*  233 */     if (!this.mflag) {
/*  234 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  239 */       pstmt = this.con.prepareStatement("INSERT INTO LNPInvestRiskData VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  240 */       if ((getDataid() == null) || (getDataid().equals("null")))
/*  241 */         pstmt.setNull(1, 12);
/*      */       else {
/*  243 */         pstmt.setString(1, getDataid());
/*      */       }
/*  245 */       if ((getSignno() == null) || (getSignno().equals("null")))
/*  246 */         pstmt.setNull(2, 12);
/*      */       else {
/*  248 */         pstmt.setString(2, getSignno());
/*      */       }
/*  250 */       if ((getType() == null) || (getType().equals("null")))
/*  251 */         pstmt.setNull(3, 12);
/*      */       else {
/*  253 */         pstmt.setString(3, getType());
/*      */       }
/*  255 */       pstmt.setInt(4, getSerialno());
/*  256 */       pstmt.setInt(5, getAge());
/*  257 */       pstmt.setInt(6, getDegree());
/*  258 */       pstmt.setDouble(7, getValue());
/*  259 */       pstmt.setInt(8, getProtagonist());
/*  260 */       pstmt.setInt(9, getExponent());
/*  261 */       pstmt.setInt(10, getBanlance());
/*  262 */       pstmt.setInt(11, getSolidity());
/*  263 */       pstmt.setInt(12, getPrevent());
/*  264 */       if ((getRemark1() == null) || (getRemark1().equals("null")))
/*  265 */         pstmt.setNull(13, 12);
/*      */       else {
/*  267 */         pstmt.setString(13, getRemark1());
/*      */       }
/*  269 */       if ((getRemark2() == null) || (getRemark2().equals("null")))
/*  270 */         pstmt.setNull(14, 12);
/*      */       else {
/*  272 */         pstmt.setString(14, getRemark2());
/*      */       }
/*  274 */       if ((getRemark3() == null) || (getRemark3().equals("null")))
/*  275 */         pstmt.setNull(15, 12);
/*      */       else {
/*  277 */         pstmt.setString(15, getRemark3());
/*      */       }
/*  279 */       if ((getRemark4() == null) || (getRemark4().equals("null")))
/*  280 */         pstmt.setNull(16, 12);
/*      */       else {
/*  282 */         pstmt.setString(16, getRemark4());
/*      */       }
/*      */ 
/*  285 */       pstmt.executeUpdate();
/*  286 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  289 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  290 */       CError tError = new CError();
/*  291 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  292 */       tError.functionName = "insert()";
/*  293 */       tError.errorMessage = ex.toString();
/*  294 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  297 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  300 */       if (!this.mflag)
/*      */         try {
/*  302 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  306 */       return false;
/*      */     }
/*      */ 
/*  309 */     if (!this.mflag)
/*      */       try {
/*  311 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  315 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  320 */     PreparedStatement pstmt = null;
/*  321 */     ResultSet rs = null;
/*      */ 
/*  323 */     if (!this.mflag) {
/*  324 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  329 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPInvestRiskData WHERE  Dataid = ?", 
/*  330 */         1003, 1007);
/*  331 */       if ((getDataid() == null) || (getDataid().equals("null")))
/*  332 */         pstmt.setNull(1, 12);
/*      */       else {
/*  334 */         pstmt.setString(1, getDataid());
/*      */       }
/*  336 */       rs = pstmt.executeQuery();
/*  337 */       int i = 0;
/*  338 */       if (rs.next())
/*      */       {
/*  340 */         i++;
/*  341 */         if (!setSchema(rs, i))
/*      */         {
/*  344 */           CError tError = new CError();
/*  345 */           tError.moduleName = "LNPInvestRiskDataDB";
/*  346 */           tError.functionName = "getInfo";
/*  347 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  348 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  350 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  353 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  357 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  361 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  365 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  368 */       if (i == 0)
/*      */       {
/*  370 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  374 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  378 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  384 */       CError tError = new CError();
/*  385 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  386 */       tError.functionName = "getInfo";
/*  387 */       tError.errorMessage = e.toString();
/*  388 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  390 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  393 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  397 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  401 */       return false;
/*      */     }
/*      */ 
/*  404 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  408 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  413 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInvestRiskDataSet query()
/*      */   {
/*  418 */     Statement stmt = null;
/*  419 */     ResultSet rs = null;
/*  420 */     LNPInvestRiskDataSet aLNPInvestRiskDataSet = new LNPInvestRiskDataSet();
/*      */ 
/*  422 */     if (!this.mflag) {
/*  423 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  428 */       stmt = this.con.createStatement(1003, 1007);
/*  429 */       SQLString sqlObj = new SQLString("LNPInvestRiskData");
/*  430 */       LNPInvestRiskDataSchema aSchema = getSchema();
/*  431 */       sqlObj.setSQL(5, aSchema);
/*  432 */       String sql = sqlObj.getSQL();
/*      */ 
/*  434 */       rs = stmt.executeQuery(sql);
/*  435 */       int i = 0;
/*  436 */       while (rs.next())
/*      */       {
/*  438 */         i++;
/*  439 */         LNPInvestRiskDataSchema s1 = new LNPInvestRiskDataSchema();
/*  440 */         s1.setSchema(rs, i);
/*  441 */         aLNPInvestRiskDataSet.add(s1);
/*      */       }try {
/*  443 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  449 */       CError tError = new CError();
/*  450 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  451 */       tError.functionName = "query";
/*  452 */       tError.errorMessage = e.toString();
/*  453 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  455 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  458 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  462 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  468 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  472 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  477 */     return aLNPInvestRiskDataSet;
/*      */   }
/*      */ 
/*      */   public LNPInvestRiskDataSet executeQuery(String sql)
/*      */   {
/*  482 */     Statement stmt = null;
/*  483 */     ResultSet rs = null;
/*  484 */     LNPInvestRiskDataSet aLNPInvestRiskDataSet = new LNPInvestRiskDataSet();
/*      */ 
/*  486 */     if (!this.mflag) {
/*  487 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  492 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  494 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  495 */       int i = 0;
/*  496 */       while (rs.next())
/*      */       {
/*  498 */         i++;
/*  499 */         LNPInvestRiskDataSchema s1 = new LNPInvestRiskDataSchema();
/*  500 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  503 */           CError tError = new CError();
/*  504 */           tError.moduleName = "LNPInvestRiskDataDB";
/*  505 */           tError.functionName = "executeQuery";
/*  506 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  507 */           this.mErrors.addOneError(tError);
/*      */         }
/*  509 */         aLNPInvestRiskDataSet.add(s1);
/*      */       }try {
/*  511 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  517 */       CError tError = new CError();
/*  518 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  519 */       tError.functionName = "executeQuery";
/*  520 */       tError.errorMessage = e.toString();
/*  521 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  523 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  526 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  530 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  536 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  540 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  545 */     return aLNPInvestRiskDataSet;
/*      */   }
/*      */ 
/*      */   public LNPInvestRiskDataSet query(int nStart, int nCount)
/*      */   {
/*  550 */     Statement stmt = null;
/*  551 */     ResultSet rs = null;
/*  552 */     LNPInvestRiskDataSet aLNPInvestRiskDataSet = new LNPInvestRiskDataSet();
/*      */ 
/*  554 */     if (!this.mflag) {
/*  555 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  560 */       stmt = this.con.createStatement(1003, 1007);
/*  561 */       SQLString sqlObj = new SQLString("LNPInvestRiskData");
/*  562 */       LNPInvestRiskDataSchema aSchema = getSchema();
/*  563 */       sqlObj.setSQL(5, aSchema);
/*  564 */       String sql = sqlObj.getSQL();
/*      */ 
/*  566 */       rs = stmt.executeQuery(sql);
/*  567 */       int i = 0;
/*  568 */       while (rs.next())
/*      */       {
/*  570 */         i++;
/*      */ 
/*  572 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  576 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  580 */         LNPInvestRiskDataSchema s1 = new LNPInvestRiskDataSchema();
/*  581 */         s1.setSchema(rs, i);
/*  582 */         aLNPInvestRiskDataSet.add(s1);
/*      */       }try {
/*  584 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  590 */       CError tError = new CError();
/*  591 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  592 */       tError.functionName = "query";
/*  593 */       tError.errorMessage = e.toString();
/*  594 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  596 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  599 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  603 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  609 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  613 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  618 */     return aLNPInvestRiskDataSet;
/*      */   }
/*      */ 
/*      */   public LNPInvestRiskDataSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  623 */     Statement stmt = null;
/*  624 */     ResultSet rs = null;
/*  625 */     LNPInvestRiskDataSet aLNPInvestRiskDataSet = new LNPInvestRiskDataSet();
/*      */ 
/*  627 */     if (!this.mflag) {
/*  628 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  633 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  635 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  636 */       int i = 0;
/*  637 */       while (rs.next())
/*      */       {
/*  639 */         i++;
/*      */ 
/*  641 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  645 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  649 */         LNPInvestRiskDataSchema s1 = new LNPInvestRiskDataSchema();
/*  650 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  653 */           CError tError = new CError();
/*  654 */           tError.moduleName = "LNPInvestRiskDataDB";
/*  655 */           tError.functionName = "executeQuery";
/*  656 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  657 */           this.mErrors.addOneError(tError);
/*      */         }
/*  659 */         aLNPInvestRiskDataSet.add(s1);
/*      */       }try {
/*  661 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  667 */       CError tError = new CError();
/*  668 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  669 */       tError.functionName = "executeQuery";
/*  670 */       tError.errorMessage = e.toString();
/*  671 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  673 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  676 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  680 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  686 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  690 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  695 */     return aLNPInvestRiskDataSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  700 */     Statement stmt = null;
/*      */ 
/*  702 */     if (!this.mflag) {
/*  703 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  708 */       stmt = this.con.createStatement(1003, 1007);
/*  709 */       SQLString sqlObj = new SQLString("LNPInvestRiskData");
/*  710 */       LNPInvestRiskDataSchema aSchema = getSchema();
/*  711 */       sqlObj.setSQL(2, aSchema);
/*  712 */       String sql = "update LNPInvestRiskData " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  714 */       int operCount = stmt.executeUpdate(sql);
/*  715 */       if (operCount == 0)
/*      */       {
/*  718 */         CError tError = new CError();
/*  719 */         tError.moduleName = "LNPInvestRiskDataDB";
/*  720 */         tError.functionName = "update";
/*  721 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  722 */         this.mErrors.addOneError(tError);
/*      */ 
/*  724 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  728 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  732 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  738 */       CError tError = new CError();
/*  739 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  740 */       tError.functionName = "update";
/*  741 */       tError.errorMessage = e.toString();
/*  742 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  744 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  746 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  750 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  754 */       return false;
/*      */     }
/*      */ 
/*  757 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  761 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  766 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  772 */     if (this.mResultSet != null)
/*      */     {
/*  775 */       CError tError = new CError();
/*  776 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  777 */       tError.functionName = "prepareData";
/*  778 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  779 */       this.mErrors.addOneError(tError);
/*  780 */       return false;
/*      */     }
/*      */ 
/*  783 */     if (!this.mflag)
/*      */     {
/*  785 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  789 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  790 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  795 */       CError tError = new CError();
/*  796 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  797 */       tError.functionName = "prepareData";
/*  798 */       tError.errorMessage = e.toString();
/*  799 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  802 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  808 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  812 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  816 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  821 */       return false;
/*      */     }
/*      */ 
/*  824 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  828 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  833 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  839 */     boolean flag = true;
/*  840 */     if (this.mResultSet == null)
/*      */     {
/*  842 */       CError tError = new CError();
/*  843 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  844 */       tError.functionName = "hasMoreData";
/*  845 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  846 */       this.mErrors.addOneError(tError);
/*  847 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  851 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  855 */       CError tError = new CError();
/*  856 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  857 */       tError.functionName = "hasMoreData";
/*  858 */       tError.errorMessage = ex.toString();
/*  859 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  862 */         this.mResultSet.close();
/*  863 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  869 */         this.mStatement.close();
/*  870 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  874 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  878 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  883 */       return false;
/*      */     }
/*  885 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPInvestRiskDataSet getData()
/*      */   {
/*  890 */     int tCount = 0;
/*  891 */     LNPInvestRiskDataSet tLNPInvestRiskDataSet = new LNPInvestRiskDataSet();
/*  892 */     LNPInvestRiskDataSchema tLNPInvestRiskDataSchema = null;
/*  893 */     if (this.mResultSet == null)
/*      */     {
/*  895 */       CError tError = new CError();
/*  896 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  897 */       tError.functionName = "getData";
/*  898 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  899 */       this.mErrors.addOneError(tError);
/*  900 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  904 */       tCount = 1;
/*  905 */       tLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
/*  906 */       tLNPInvestRiskDataSchema.setSchema(this.mResultSet, 1);
/*  907 */       tLNPInvestRiskDataSet.add(tLNPInvestRiskDataSchema);
/*      */ 
/*  909 */       while (tCount++ < 5000)
/*      */       {
/*  911 */         if (!this.mResultSet.next())
/*      */           continue;
/*  913 */         tLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
/*  914 */         tLNPInvestRiskDataSchema.setSchema(this.mResultSet, 1);
/*  915 */         tLNPInvestRiskDataSet.add(tLNPInvestRiskDataSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  921 */       CError tError = new CError();
/*  922 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  923 */       tError.functionName = "getData";
/*  924 */       tError.errorMessage = ex.toString();
/*  925 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  928 */         this.mResultSet.close();
/*  929 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  935 */         this.mStatement.close();
/*  936 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  940 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  944 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  949 */       return null;
/*      */     }
/*  951 */     return tLNPInvestRiskDataSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  956 */     boolean flag = true;
/*      */     try
/*      */     {
/*  959 */       if (this.mResultSet == null)
/*      */       {
/*  961 */         CError tError = new CError();
/*  962 */         tError.moduleName = "LNPInvestRiskDataDB";
/*  963 */         tError.functionName = "closeData";
/*  964 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/*  965 */         this.mErrors.addOneError(tError);
/*  966 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  970 */         this.mResultSet.close();
/*  971 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/*  976 */       CError tError = new CError();
/*  977 */       tError.moduleName = "LNPInvestRiskDataDB";
/*  978 */       tError.functionName = "closeData";
/*  979 */       tError.errorMessage = ex2.toString();
/*  980 */       this.mErrors.addOneError(tError);
/*  981 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/*  985 */       if (this.mStatement == null)
/*      */       {
/*  987 */         CError tError = new CError();
/*  988 */         tError.moduleName = "LNPInvestRiskDataDB";
/*  989 */         tError.functionName = "closeData";
/*  990 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/*  991 */         this.mErrors.addOneError(tError);
/*  992 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  996 */         this.mStatement.close();
/*  997 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1002 */       CError tError = new CError();
/* 1003 */       tError.moduleName = "LNPInvestRiskDataDB";
/* 1004 */       tError.functionName = "closeData";
/* 1005 */       tError.errorMessage = ex3.toString();
/* 1006 */       this.mErrors.addOneError(tError);
/* 1007 */       flag = false;
/*      */     }
/* 1009 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPInvestRiskDataDB
 * JD-Core Version:    0.6.0
 */