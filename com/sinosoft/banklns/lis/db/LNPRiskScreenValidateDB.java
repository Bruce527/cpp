/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskScreenValidateSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskScreenValidateSet;
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
/*      */ public class LNPRiskScreenValidateDB extends LNPRiskScreenValidateSchema
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
/*      */   public LNPRiskScreenValidateDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPRiskScreenValidate");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenValidateDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPRiskScreenValidate");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPRiskScreenValidateSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPRiskScreenValidateDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPRiskScreenValidateSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPRiskScreenValidateDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskScreenValidate WHERE  ControlId = ?");
/*   97 */       if ((getControlId() == null) || (getControlId().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getControlId());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPRiskScreenValidateDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskScreenValidate SET  ControlId = ? , RiskCode = ? , ControlCode = ? , ControlValue = ? , FunctionType = ? , RelaDivCode = ? , RelaDivShow = ? , RelaControlCode = ? , RelaControlType = ? , RelaValueSql = ? , CalCode = ? , Noti = ? WHERE  ControlId = ?");
/*  146 */       if ((getControlId() == null) || (getControlId().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getControlId());
/*      */       }
/*  151 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getRiskCode());
/*      */       }
/*  156 */       if ((getControlCode() == null) || (getControlCode().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getControlCode());
/*      */       }
/*  161 */       if ((getControlValue() == null) || (getControlValue().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getControlValue());
/*      */       }
/*  166 */       if ((getFunctionType() == null) || (getFunctionType().equals("null")))
/*  167 */         pstmt.setNull(5, 12);
/*      */       else {
/*  169 */         pstmt.setString(5, getFunctionType());
/*      */       }
/*  171 */       if ((getRelaDivCode() == null) || (getRelaDivCode().equals("null")))
/*  172 */         pstmt.setNull(6, 12);
/*      */       else {
/*  174 */         pstmt.setString(6, getRelaDivCode());
/*      */       }
/*  176 */       if ((getRelaDivShow() == null) || (getRelaDivShow().equals("null")))
/*  177 */         pstmt.setNull(7, 12);
/*      */       else {
/*  179 */         pstmt.setString(7, getRelaDivShow());
/*      */       }
/*  181 */       if ((getRelaControlCode() == null) || (getRelaControlCode().equals("null")))
/*  182 */         pstmt.setNull(8, 12);
/*      */       else {
/*  184 */         pstmt.setString(8, getRelaControlCode());
/*      */       }
/*  186 */       if ((getRelaControlType() == null) || (getRelaControlType().equals("null")))
/*  187 */         pstmt.setNull(9, 12);
/*      */       else {
/*  189 */         pstmt.setString(9, getRelaControlType());
/*      */       }
/*  191 */       if ((getRelaValueSql() == null) || (getRelaValueSql().equals("null")))
/*  192 */         pstmt.setNull(10, 12);
/*      */       else {
/*  194 */         pstmt.setString(10, getRelaValueSql());
/*      */       }
/*  196 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/*  197 */         pstmt.setNull(11, 12);
/*      */       else {
/*  199 */         pstmt.setString(11, getCalCode());
/*      */       }
/*  201 */       if ((getNoti() == null) || (getNoti().equals("null")))
/*  202 */         pstmt.setNull(12, 12);
/*      */       else {
/*  204 */         pstmt.setString(12, getNoti());
/*      */       }
/*      */ 
/*  207 */       if ((getControlId() == null) || (getControlId().equals("null")))
/*  208 */         pstmt.setNull(13, 12);
/*      */       else {
/*  210 */         pstmt.setString(13, getControlId());
/*      */       }
/*  212 */       pstmt.executeUpdate();
/*  213 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  216 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  217 */       CError tError = new CError();
/*  218 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  219 */       tError.functionName = "update()";
/*  220 */       tError.errorMessage = ex.toString();
/*  221 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  224 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  227 */       if (!this.mflag)
/*      */         try {
/*  229 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  233 */       return false;
/*      */     }
/*      */ 
/*  236 */     if (!this.mflag)
/*      */       try {
/*  238 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  242 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  247 */     PreparedStatement pstmt = null;
/*      */ 
/*  249 */     if (!this.mflag) {
/*  250 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  255 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskScreenValidate VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  256 */       if ((getControlId() == null) || (getControlId().equals("null")))
/*  257 */         pstmt.setNull(1, 12);
/*      */       else {
/*  259 */         pstmt.setString(1, getControlId());
/*      */       }
/*  261 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  262 */         pstmt.setNull(2, 12);
/*      */       else {
/*  264 */         pstmt.setString(2, getRiskCode());
/*      */       }
/*  266 */       if ((getControlCode() == null) || (getControlCode().equals("null")))
/*  267 */         pstmt.setNull(3, 12);
/*      */       else {
/*  269 */         pstmt.setString(3, getControlCode());
/*      */       }
/*  271 */       if ((getControlValue() == null) || (getControlValue().equals("null")))
/*  272 */         pstmt.setNull(4, 12);
/*      */       else {
/*  274 */         pstmt.setString(4, getControlValue());
/*      */       }
/*  276 */       if ((getFunctionType() == null) || (getFunctionType().equals("null")))
/*  277 */         pstmt.setNull(5, 12);
/*      */       else {
/*  279 */         pstmt.setString(5, getFunctionType());
/*      */       }
/*  281 */       if ((getRelaDivCode() == null) || (getRelaDivCode().equals("null")))
/*  282 */         pstmt.setNull(6, 12);
/*      */       else {
/*  284 */         pstmt.setString(6, getRelaDivCode());
/*      */       }
/*  286 */       if ((getRelaDivShow() == null) || (getRelaDivShow().equals("null")))
/*  287 */         pstmt.setNull(7, 12);
/*      */       else {
/*  289 */         pstmt.setString(7, getRelaDivShow());
/*      */       }
/*  291 */       if ((getRelaControlCode() == null) || (getRelaControlCode().equals("null")))
/*  292 */         pstmt.setNull(8, 12);
/*      */       else {
/*  294 */         pstmt.setString(8, getRelaControlCode());
/*      */       }
/*  296 */       if ((getRelaControlType() == null) || (getRelaControlType().equals("null")))
/*  297 */         pstmt.setNull(9, 12);
/*      */       else {
/*  299 */         pstmt.setString(9, getRelaControlType());
/*      */       }
/*  301 */       if ((getRelaValueSql() == null) || (getRelaValueSql().equals("null")))
/*  302 */         pstmt.setNull(10, 12);
/*      */       else {
/*  304 */         pstmt.setString(10, getRelaValueSql());
/*      */       }
/*  306 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/*  307 */         pstmt.setNull(11, 12);
/*      */       else {
/*  309 */         pstmt.setString(11, getCalCode());
/*      */       }
/*  311 */       if ((getNoti() == null) || (getNoti().equals("null")))
/*  312 */         pstmt.setNull(12, 12);
/*      */       else {
/*  314 */         pstmt.setString(12, getNoti());
/*      */       }
/*      */ 
/*  317 */       pstmt.executeUpdate();
/*  318 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  321 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  322 */       CError tError = new CError();
/*  323 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  324 */       tError.functionName = "insert()";
/*  325 */       tError.errorMessage = ex.toString();
/*  326 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  329 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  332 */       if (!this.mflag)
/*      */         try {
/*  334 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  338 */       return false;
/*      */     }
/*      */ 
/*  341 */     if (!this.mflag)
/*      */       try {
/*  343 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  347 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  352 */     PreparedStatement pstmt = null;
/*  353 */     ResultSet rs = null;
/*      */ 
/*  355 */     if (!this.mflag) {
/*  356 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  361 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRiskScreenValidate WHERE  ControlId = ?", 
/*  362 */         1003, 1007);
/*  363 */       if ((getControlId() == null) || (getControlId().equals("null")))
/*  364 */         pstmt.setNull(1, 12);
/*      */       else {
/*  366 */         pstmt.setString(1, getControlId());
/*      */       }
/*  368 */       rs = pstmt.executeQuery();
/*  369 */       int i = 0;
/*  370 */       if (rs.next())
/*      */       {
/*  372 */         i++;
/*  373 */         if (!setSchema(rs, i))
/*      */         {
/*  376 */           CError tError = new CError();
/*  377 */           tError.moduleName = "LNPRiskScreenValidateDB";
/*  378 */           tError.functionName = "getInfo";
/*  379 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  380 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  382 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  385 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  389 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  393 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  397 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  400 */       if (i == 0)
/*      */       {
/*  402 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  406 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  410 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  416 */       CError tError = new CError();
/*  417 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  418 */       tError.functionName = "getInfo";
/*  419 */       tError.errorMessage = e.toString();
/*  420 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  422 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  425 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  429 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  433 */       return false;
/*      */     }
/*      */ 
/*  436 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  440 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  445 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenValidateSet query()
/*      */   {
/*  450 */     Statement stmt = null;
/*  451 */     ResultSet rs = null;
/*  452 */     LNPRiskScreenValidateSet aLNPRiskScreenValidateSet = new LNPRiskScreenValidateSet();
/*      */ 
/*  454 */     if (!this.mflag) {
/*  455 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  460 */       stmt = this.con.createStatement(1003, 1007);
/*  461 */       SQLString sqlObj = new SQLString("LNPRiskScreenValidate");
/*  462 */       LNPRiskScreenValidateSchema aSchema = getSchema();
/*  463 */       sqlObj.setSQL(5, aSchema);
/*  464 */       String sql = sqlObj.getSQL();
/*      */ 
/*  466 */       rs = stmt.executeQuery(sql);
/*  467 */       int i = 0;
/*  468 */       while (rs.next())
/*      */       {
/*  470 */         i++;
/*  471 */         LNPRiskScreenValidateSchema s1 = new LNPRiskScreenValidateSchema();
/*  472 */         s1.setSchema(rs, i);
/*  473 */         aLNPRiskScreenValidateSet.add(s1);
/*      */       }try {
/*  475 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  481 */       CError tError = new CError();
/*  482 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  483 */       tError.functionName = "query";
/*  484 */       tError.errorMessage = e.toString();
/*  485 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  487 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  490 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  494 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  500 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  504 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  509 */     return aLNPRiskScreenValidateSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenValidateSet executeQuery(String sql)
/*      */   {
/*  514 */     Statement stmt = null;
/*  515 */     ResultSet rs = null;
/*  516 */     LNPRiskScreenValidateSet aLNPRiskScreenValidateSet = new LNPRiskScreenValidateSet();
/*      */ 
/*  518 */     if (!this.mflag) {
/*  519 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  524 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  526 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  527 */       int i = 0;
/*  528 */       while (rs.next())
/*      */       {
/*  530 */         i++;
/*  531 */         LNPRiskScreenValidateSchema s1 = new LNPRiskScreenValidateSchema();
/*  532 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  535 */           CError tError = new CError();
/*  536 */           tError.moduleName = "LNPRiskScreenValidateDB";
/*  537 */           tError.functionName = "executeQuery";
/*  538 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  539 */           this.mErrors.addOneError(tError);
/*      */         }
/*  541 */         aLNPRiskScreenValidateSet.add(s1);
/*      */       }try {
/*  543 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  549 */       CError tError = new CError();
/*  550 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  551 */       tError.functionName = "executeQuery";
/*  552 */       tError.errorMessage = e.toString();
/*  553 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  555 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  558 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  562 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  568 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  572 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  577 */     return aLNPRiskScreenValidateSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenValidateSet query(int nStart, int nCount)
/*      */   {
/*  582 */     Statement stmt = null;
/*  583 */     ResultSet rs = null;
/*  584 */     LNPRiskScreenValidateSet aLNPRiskScreenValidateSet = new LNPRiskScreenValidateSet();
/*      */ 
/*  586 */     if (!this.mflag) {
/*  587 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  592 */       stmt = this.con.createStatement(1003, 1007);
/*  593 */       SQLString sqlObj = new SQLString("LNPRiskScreenValidate");
/*  594 */       LNPRiskScreenValidateSchema aSchema = getSchema();
/*  595 */       sqlObj.setSQL(5, aSchema);
/*  596 */       String sql = sqlObj.getSQL();
/*      */ 
/*  598 */       rs = stmt.executeQuery(sql);
/*  599 */       int i = 0;
/*  600 */       while (rs.next())
/*      */       {
/*  602 */         i++;
/*      */ 
/*  604 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  608 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  612 */         LNPRiskScreenValidateSchema s1 = new LNPRiskScreenValidateSchema();
/*  613 */         s1.setSchema(rs, i);
/*  614 */         aLNPRiskScreenValidateSet.add(s1);
/*      */       }try {
/*  616 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  622 */       CError tError = new CError();
/*  623 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  624 */       tError.functionName = "query";
/*  625 */       tError.errorMessage = e.toString();
/*  626 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  628 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  631 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  635 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  641 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  645 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  650 */     return aLNPRiskScreenValidateSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenValidateSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  655 */     Statement stmt = null;
/*  656 */     ResultSet rs = null;
/*  657 */     LNPRiskScreenValidateSet aLNPRiskScreenValidateSet = new LNPRiskScreenValidateSet();
/*      */ 
/*  659 */     if (!this.mflag) {
/*  660 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  665 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  667 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  668 */       int i = 0;
/*  669 */       while (rs.next())
/*      */       {
/*  671 */         i++;
/*      */ 
/*  673 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  677 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  681 */         LNPRiskScreenValidateSchema s1 = new LNPRiskScreenValidateSchema();
/*  682 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  685 */           CError tError = new CError();
/*  686 */           tError.moduleName = "LNPRiskScreenValidateDB";
/*  687 */           tError.functionName = "executeQuery";
/*  688 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  689 */           this.mErrors.addOneError(tError);
/*      */         }
/*  691 */         aLNPRiskScreenValidateSet.add(s1);
/*      */       }try {
/*  693 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  699 */       CError tError = new CError();
/*  700 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  701 */       tError.functionName = "executeQuery";
/*  702 */       tError.errorMessage = e.toString();
/*  703 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  705 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  708 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  712 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  718 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  722 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  727 */     return aLNPRiskScreenValidateSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  732 */     Statement stmt = null;
/*      */ 
/*  734 */     if (!this.mflag) {
/*  735 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  740 */       stmt = this.con.createStatement(1003, 1007);
/*  741 */       SQLString sqlObj = new SQLString("LNPRiskScreenValidate");
/*  742 */       LNPRiskScreenValidateSchema aSchema = getSchema();
/*  743 */       sqlObj.setSQL(2, aSchema);
/*  744 */       String sql = "update LNPRiskScreenValidate " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  746 */       int operCount = stmt.executeUpdate(sql);
/*  747 */       if (operCount == 0)
/*      */       {
/*  750 */         CError tError = new CError();
/*  751 */         tError.moduleName = "LNPRiskScreenValidateDB";
/*  752 */         tError.functionName = "update";
/*  753 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  754 */         this.mErrors.addOneError(tError);
/*      */ 
/*  756 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  760 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  764 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  770 */       CError tError = new CError();
/*  771 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  772 */       tError.functionName = "update";
/*  773 */       tError.errorMessage = e.toString();
/*  774 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  776 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  778 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  782 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  786 */       return false;
/*      */     }
/*      */ 
/*  789 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  793 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  798 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  804 */     if (this.mResultSet != null)
/*      */     {
/*  807 */       CError tError = new CError();
/*  808 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  809 */       tError.functionName = "prepareData";
/*  810 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  811 */       this.mErrors.addOneError(tError);
/*  812 */       return false;
/*      */     }
/*      */ 
/*  815 */     if (!this.mflag)
/*      */     {
/*  817 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  821 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  822 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  827 */       CError tError = new CError();
/*  828 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  829 */       tError.functionName = "prepareData";
/*  830 */       tError.errorMessage = e.toString();
/*  831 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  834 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  840 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  844 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  848 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  853 */       return false;
/*      */     }
/*      */ 
/*  856 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  860 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  865 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  871 */     boolean flag = true;
/*  872 */     if (this.mResultSet == null)
/*      */     {
/*  874 */       CError tError = new CError();
/*  875 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  876 */       tError.functionName = "hasMoreData";
/*  877 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  878 */       this.mErrors.addOneError(tError);
/*  879 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  883 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  887 */       CError tError = new CError();
/*  888 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  889 */       tError.functionName = "hasMoreData";
/*  890 */       tError.errorMessage = ex.toString();
/*  891 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  894 */         this.mResultSet.close();
/*  895 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  901 */         this.mStatement.close();
/*  902 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  906 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  910 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  915 */       return false;
/*      */     }
/*  917 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenValidateSet getData()
/*      */   {
/*  922 */     int tCount = 0;
/*  923 */     LNPRiskScreenValidateSet tLNPRiskScreenValidateSet = new LNPRiskScreenValidateSet();
/*  924 */     LNPRiskScreenValidateSchema tLNPRiskScreenValidateSchema = null;
/*  925 */     if (this.mResultSet == null)
/*      */     {
/*  927 */       CError tError = new CError();
/*  928 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  929 */       tError.functionName = "getData";
/*  930 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  931 */       this.mErrors.addOneError(tError);
/*  932 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  936 */       tCount = 1;
/*  937 */       tLNPRiskScreenValidateSchema = new LNPRiskScreenValidateSchema();
/*  938 */       tLNPRiskScreenValidateSchema.setSchema(this.mResultSet, 1);
/*  939 */       tLNPRiskScreenValidateSet.add(tLNPRiskScreenValidateSchema);
/*      */ 
/*  941 */       while (tCount++ < 5000)
/*      */       {
/*  943 */         if (!this.mResultSet.next())
/*      */           continue;
/*  945 */         tLNPRiskScreenValidateSchema = new LNPRiskScreenValidateSchema();
/*  946 */         tLNPRiskScreenValidateSchema.setSchema(this.mResultSet, 1);
/*  947 */         tLNPRiskScreenValidateSet.add(tLNPRiskScreenValidateSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  953 */       CError tError = new CError();
/*  954 */       tError.moduleName = "LNPRiskScreenValidateDB";
/*  955 */       tError.functionName = "getData";
/*  956 */       tError.errorMessage = ex.toString();
/*  957 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  960 */         this.mResultSet.close();
/*  961 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  967 */         this.mStatement.close();
/*  968 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  972 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  976 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  981 */       return null;
/*      */     }
/*  983 */     return tLNPRiskScreenValidateSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  988 */     boolean flag = true;
/*      */     try
/*      */     {
/*  991 */       if (this.mResultSet == null)
/*      */       {
/*  993 */         CError tError = new CError();
/*  994 */         tError.moduleName = "LNPRiskScreenValidateDB";
/*  995 */         tError.functionName = "closeData";
/*  996 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/*  997 */         this.mErrors.addOneError(tError);
/*  998 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1002 */         this.mResultSet.close();
/* 1003 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1008 */       CError tError = new CError();
/* 1009 */       tError.moduleName = "LNPRiskScreenValidateDB";
/* 1010 */       tError.functionName = "closeData";
/* 1011 */       tError.errorMessage = ex2.toString();
/* 1012 */       this.mErrors.addOneError(tError);
/* 1013 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1017 */       if (this.mStatement == null)
/*      */       {
/* 1019 */         CError tError = new CError();
/* 1020 */         tError.moduleName = "LNPRiskScreenValidateDB";
/* 1021 */         tError.functionName = "closeData";
/* 1022 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1023 */         this.mErrors.addOneError(tError);
/* 1024 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1028 */         this.mStatement.close();
/* 1029 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1034 */       CError tError = new CError();
/* 1035 */       tError.moduleName = "LNPRiskScreenValidateDB";
/* 1036 */       tError.functionName = "closeData";
/* 1037 */       tError.errorMessage = ex3.toString();
/* 1038 */       this.mErrors.addOneError(tError);
/* 1039 */       flag = false;
/*      */     }
/* 1041 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskScreenValidateDB
 * JD-Core Version:    0.6.0
 */