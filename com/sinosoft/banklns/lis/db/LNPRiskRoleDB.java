/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskRoleSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskRoleSet;
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
/*      */ public class LNPRiskRoleDB extends LNPRiskRoleSchema
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
/*      */   public LNPRiskRoleDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPRiskRole");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPRiskRoleDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPRiskRole");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPRiskRoleSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPRiskRoleDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPRiskRoleSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPRiskRoleDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskRole WHERE  RiskCode = ? AND RiskRole = ? AND RiskRoleSex = ? AND RiskRoleNo = ?");
/*   97 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  102 */       if ((getRiskRole() == null) || (getRiskRole().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getRiskRole());
/*      */       }
/*  107 */       if ((getRiskRoleSex() == null) || (getRiskRoleSex().equals("null")))
/*  108 */         pstmt.setNull(3, 12);
/*      */       else {
/*  110 */         pstmt.setString(3, getRiskRoleSex());
/*      */       }
/*  112 */       if ((getRiskRoleNo() == null) || (getRiskRoleNo().equals("null")))
/*  113 */         pstmt.setNull(4, 12);
/*      */       else {
/*  115 */         pstmt.setString(4, getRiskRoleNo());
/*      */       }
/*  117 */       pstmt.executeUpdate();
/*  118 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  121 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  122 */       CError tError = new CError();
/*  123 */       tError.moduleName = "LNPRiskRoleDB";
/*  124 */       tError.functionName = "delete()";
/*  125 */       tError.errorMessage = ex.toString();
/*  126 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  129 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  132 */       if (!this.mflag)
/*      */         try {
/*  134 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  138 */       return false;
/*      */     }
/*      */ 
/*  141 */     if (!this.mflag)
/*      */       try {
/*  143 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  147 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  152 */     PreparedStatement pstmt = null;
/*      */ 
/*  154 */     if (!this.mflag) {
/*  155 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  160 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskRole SET  RiskCode = ? , RiskVer = ? , RiskRole = ? , RiskRoleSex = ? , RiskRoleNo = ? , MinAppAgeFlag = ? , MinAppAge = ? , MAXAppAgeFlag = ? , MAXAppAge = ? WHERE  RiskCode = ? AND RiskRole = ? AND RiskRoleSex = ? AND RiskRoleNo = ?");
/*  161 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  162 */         pstmt.setNull(1, 12);
/*      */       else {
/*  164 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  166 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/*  167 */         pstmt.setNull(2, 12);
/*      */       else {
/*  169 */         pstmt.setString(2, getRiskVer());
/*      */       }
/*  171 */       if ((getRiskRole() == null) || (getRiskRole().equals("null")))
/*  172 */         pstmt.setNull(3, 12);
/*      */       else {
/*  174 */         pstmt.setString(3, getRiskRole());
/*      */       }
/*  176 */       if ((getRiskRoleSex() == null) || (getRiskRoleSex().equals("null")))
/*  177 */         pstmt.setNull(4, 12);
/*      */       else {
/*  179 */         pstmt.setString(4, getRiskRoleSex());
/*      */       }
/*  181 */       if ((getRiskRoleNo() == null) || (getRiskRoleNo().equals("null")))
/*  182 */         pstmt.setNull(5, 12);
/*      */       else {
/*  184 */         pstmt.setString(5, getRiskRoleNo());
/*      */       }
/*  186 */       if ((getMinAppAgeFlag() == null) || (getMinAppAgeFlag().equals("null")))
/*  187 */         pstmt.setNull(6, 12);
/*      */       else {
/*  189 */         pstmt.setString(6, getMinAppAgeFlag());
/*      */       }
/*  191 */       pstmt.setInt(7, getMinAppAge());
/*  192 */       if ((getMAXAppAgeFlag() == null) || (getMAXAppAgeFlag().equals("null")))
/*  193 */         pstmt.setNull(8, 12);
/*      */       else {
/*  195 */         pstmt.setString(8, getMAXAppAgeFlag());
/*      */       }
/*  197 */       pstmt.setInt(9, getMAXAppAge());
/*      */ 
/*  199 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  200 */         pstmt.setNull(10, 12);
/*      */       else {
/*  202 */         pstmt.setString(10, getRiskCode());
/*      */       }
/*  204 */       if ((getRiskRole() == null) || (getRiskRole().equals("null")))
/*  205 */         pstmt.setNull(11, 12);
/*      */       else {
/*  207 */         pstmt.setString(11, getRiskRole());
/*      */       }
/*  209 */       if ((getRiskRoleSex() == null) || (getRiskRoleSex().equals("null")))
/*  210 */         pstmt.setNull(12, 12);
/*      */       else {
/*  212 */         pstmt.setString(12, getRiskRoleSex());
/*      */       }
/*  214 */       if ((getRiskRoleNo() == null) || (getRiskRoleNo().equals("null")))
/*  215 */         pstmt.setNull(13, 12);
/*      */       else {
/*  217 */         pstmt.setString(13, getRiskRoleNo());
/*      */       }
/*  219 */       pstmt.executeUpdate();
/*  220 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  223 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  224 */       CError tError = new CError();
/*  225 */       tError.moduleName = "LNPRiskRoleDB";
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
/*  262 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskRole VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  263 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  264 */         pstmt.setNull(1, 12);
/*      */       else {
/*  266 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  268 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/*  269 */         pstmt.setNull(2, 12);
/*      */       else {
/*  271 */         pstmt.setString(2, getRiskVer());
/*      */       }
/*  273 */       if ((getRiskRole() == null) || (getRiskRole().equals("null")))
/*  274 */         pstmt.setNull(3, 12);
/*      */       else {
/*  276 */         pstmt.setString(3, getRiskRole());
/*      */       }
/*  278 */       if ((getRiskRoleSex() == null) || (getRiskRoleSex().equals("null")))
/*  279 */         pstmt.setNull(4, 12);
/*      */       else {
/*  281 */         pstmt.setString(4, getRiskRoleSex());
/*      */       }
/*  283 */       if ((getRiskRoleNo() == null) || (getRiskRoleNo().equals("null")))
/*  284 */         pstmt.setNull(5, 12);
/*      */       else {
/*  286 */         pstmt.setString(5, getRiskRoleNo());
/*      */       }
/*  288 */       if ((getMinAppAgeFlag() == null) || (getMinAppAgeFlag().equals("null")))
/*  289 */         pstmt.setNull(6, 12);
/*      */       else {
/*  291 */         pstmt.setString(6, getMinAppAgeFlag());
/*      */       }
/*  293 */       pstmt.setInt(7, getMinAppAge());
/*  294 */       if ((getMAXAppAgeFlag() == null) || (getMAXAppAgeFlag().equals("null")))
/*  295 */         pstmt.setNull(8, 12);
/*      */       else {
/*  297 */         pstmt.setString(8, getMAXAppAgeFlag());
/*      */       }
/*  299 */       pstmt.setInt(9, getMAXAppAge());
/*      */ 
/*  301 */       pstmt.executeUpdate();
/*  302 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  305 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  306 */       CError tError = new CError();
/*  307 */       tError.moduleName = "LNPRiskRoleDB";
/*  308 */       tError.functionName = "insert()";
/*  309 */       tError.errorMessage = ex.toString();
/*  310 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  313 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  316 */       if (!this.mflag)
/*      */         try {
/*  318 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  322 */       return false;
/*      */     }
/*      */ 
/*  325 */     if (!this.mflag)
/*      */       try {
/*  327 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  331 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  336 */     PreparedStatement pstmt = null;
/*  337 */     ResultSet rs = null;
/*      */ 
/*  339 */     if (!this.mflag) {
/*  340 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  345 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRiskRole WHERE  RiskCode = ? AND RiskRole = ? AND RiskRoleSex = ? AND RiskRoleNo = ?", 
/*  346 */         1003, 1007);
/*  347 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  348 */         pstmt.setNull(1, 12);
/*      */       else {
/*  350 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  352 */       if ((getRiskRole() == null) || (getRiskRole().equals("null")))
/*  353 */         pstmt.setNull(2, 12);
/*      */       else {
/*  355 */         pstmt.setString(2, getRiskRole());
/*      */       }
/*  357 */       if ((getRiskRoleSex() == null) || (getRiskRoleSex().equals("null")))
/*  358 */         pstmt.setNull(3, 12);
/*      */       else {
/*  360 */         pstmt.setString(3, getRiskRoleSex());
/*      */       }
/*  362 */       if ((getRiskRoleNo() == null) || (getRiskRoleNo().equals("null")))
/*  363 */         pstmt.setNull(4, 12);
/*      */       else {
/*  365 */         pstmt.setString(4, getRiskRoleNo());
/*      */       }
/*  367 */       rs = pstmt.executeQuery();
/*  368 */       int i = 0;
/*  369 */       if (rs.next())
/*      */       {
/*  371 */         i++;
/*  372 */         if (!setSchema(rs, i))
/*      */         {
/*  375 */           CError tError = new CError();
/*  376 */           tError.moduleName = "LNPRiskRoleDB";
/*  377 */           tError.functionName = "getInfo";
/*  378 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  379 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  381 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  384 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  388 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  392 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  396 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  399 */       if (i == 0)
/*      */       {
/*  401 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  405 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  409 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  415 */       CError tError = new CError();
/*  416 */       tError.moduleName = "LNPRiskRoleDB";
/*  417 */       tError.functionName = "getInfo";
/*  418 */       tError.errorMessage = e.toString();
/*  419 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  421 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  424 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  428 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  432 */       return false;
/*      */     }
/*      */ 
/*  435 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  439 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  444 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRiskRoleSet query()
/*      */   {
/*  449 */     Statement stmt = null;
/*  450 */     ResultSet rs = null;
/*  451 */     LNPRiskRoleSet aLNPRiskRoleSet = new LNPRiskRoleSet();
/*      */ 
/*  453 */     if (!this.mflag) {
/*  454 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  459 */       stmt = this.con.createStatement(1003, 1007);
/*  460 */       SQLString sqlObj = new SQLString("LNPRiskRole");
/*  461 */       LNPRiskRoleSchema aSchema = getSchema();
/*  462 */       sqlObj.setSQL(5, aSchema);
/*  463 */       String sql = sqlObj.getSQL();
/*      */ 
/*  465 */       rs = stmt.executeQuery(sql);
/*  466 */       int i = 0;
/*  467 */       while (rs.next())
/*      */       {
/*  469 */         i++;
/*  470 */         LNPRiskRoleSchema s1 = new LNPRiskRoleSchema();
/*  471 */         s1.setSchema(rs, i);
/*  472 */         aLNPRiskRoleSet.add(s1);
/*      */       }try {
/*  474 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  480 */       CError tError = new CError();
/*  481 */       tError.moduleName = "LNPRiskRoleDB";
/*  482 */       tError.functionName = "query";
/*  483 */       tError.errorMessage = e.toString();
/*  484 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  486 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  489 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  493 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  499 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  503 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  508 */     return aLNPRiskRoleSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskRoleSet executeQuery(String sql)
/*      */   {
/*  513 */     Statement stmt = null;
/*  514 */     ResultSet rs = null;
/*  515 */     LNPRiskRoleSet aLNPRiskRoleSet = new LNPRiskRoleSet();
/*      */ 
/*  517 */     if (!this.mflag) {
/*  518 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  523 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  525 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  526 */       int i = 0;
/*  527 */       while (rs.next())
/*      */       {
/*  529 */         i++;
/*  530 */         LNPRiskRoleSchema s1 = new LNPRiskRoleSchema();
/*  531 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  534 */           CError tError = new CError();
/*  535 */           tError.moduleName = "LNPRiskRoleDB";
/*  536 */           tError.functionName = "executeQuery";
/*  537 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  538 */           this.mErrors.addOneError(tError);
/*      */         }
/*  540 */         aLNPRiskRoleSet.add(s1);
/*      */       }try {
/*  542 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  548 */       CError tError = new CError();
/*  549 */       tError.moduleName = "LNPRiskRoleDB";
/*  550 */       tError.functionName = "executeQuery";
/*  551 */       tError.errorMessage = e.toString();
/*  552 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  554 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  557 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  561 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  567 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  571 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  576 */     return aLNPRiskRoleSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskRoleSet query(int nStart, int nCount)
/*      */   {
/*  581 */     Statement stmt = null;
/*  582 */     ResultSet rs = null;
/*  583 */     LNPRiskRoleSet aLNPRiskRoleSet = new LNPRiskRoleSet();
/*      */ 
/*  585 */     if (!this.mflag) {
/*  586 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  591 */       stmt = this.con.createStatement(1003, 1007);
/*  592 */       SQLString sqlObj = new SQLString("LNPRiskRole");
/*  593 */       LNPRiskRoleSchema aSchema = getSchema();
/*  594 */       sqlObj.setSQL(5, aSchema);
/*  595 */       String sql = sqlObj.getSQL();
/*      */ 
/*  597 */       rs = stmt.executeQuery(sql);
/*  598 */       int i = 0;
/*  599 */       while (rs.next())
/*      */       {
/*  601 */         i++;
/*      */ 
/*  603 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  607 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  611 */         LNPRiskRoleSchema s1 = new LNPRiskRoleSchema();
/*  612 */         s1.setSchema(rs, i);
/*  613 */         aLNPRiskRoleSet.add(s1);
/*      */       }try {
/*  615 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  621 */       CError tError = new CError();
/*  622 */       tError.moduleName = "LNPRiskRoleDB";
/*  623 */       tError.functionName = "query";
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
/*  649 */     return aLNPRiskRoleSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskRoleSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  654 */     Statement stmt = null;
/*  655 */     ResultSet rs = null;
/*  656 */     LNPRiskRoleSet aLNPRiskRoleSet = new LNPRiskRoleSet();
/*      */ 
/*  658 */     if (!this.mflag) {
/*  659 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  664 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  666 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  667 */       int i = 0;
/*  668 */       while (rs.next())
/*      */       {
/*  670 */         i++;
/*      */ 
/*  672 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  676 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  680 */         LNPRiskRoleSchema s1 = new LNPRiskRoleSchema();
/*  681 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  684 */           CError tError = new CError();
/*  685 */           tError.moduleName = "LNPRiskRoleDB";
/*  686 */           tError.functionName = "executeQuery";
/*  687 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  688 */           this.mErrors.addOneError(tError);
/*      */         }
/*  690 */         aLNPRiskRoleSet.add(s1);
/*      */       }try {
/*  692 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  698 */       CError tError = new CError();
/*  699 */       tError.moduleName = "LNPRiskRoleDB";
/*  700 */       tError.functionName = "executeQuery";
/*  701 */       tError.errorMessage = e.toString();
/*  702 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  704 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  707 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  711 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  717 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  721 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  726 */     return aLNPRiskRoleSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  731 */     Statement stmt = null;
/*      */ 
/*  733 */     if (!this.mflag) {
/*  734 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  739 */       stmt = this.con.createStatement(1003, 1007);
/*  740 */       SQLString sqlObj = new SQLString("LNPRiskRole");
/*  741 */       LNPRiskRoleSchema aSchema = getSchema();
/*  742 */       sqlObj.setSQL(2, aSchema);
/*  743 */       String sql = "update LNPRiskRole " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  745 */       int operCount = stmt.executeUpdate(sql);
/*  746 */       if (operCount == 0)
/*      */       {
/*  749 */         CError tError = new CError();
/*  750 */         tError.moduleName = "LNPRiskRoleDB";
/*  751 */         tError.functionName = "update";
/*  752 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  753 */         this.mErrors.addOneError(tError);
/*      */ 
/*  755 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  759 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  763 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  769 */       CError tError = new CError();
/*  770 */       tError.moduleName = "LNPRiskRoleDB";
/*  771 */       tError.functionName = "update";
/*  772 */       tError.errorMessage = e.toString();
/*  773 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  775 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  777 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  781 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  785 */       return false;
/*      */     }
/*      */ 
/*  788 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  792 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  797 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  803 */     if (this.mResultSet != null)
/*      */     {
/*  806 */       CError tError = new CError();
/*  807 */       tError.moduleName = "LNPRiskRoleDB";
/*  808 */       tError.functionName = "prepareData";
/*  809 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  810 */       this.mErrors.addOneError(tError);
/*  811 */       return false;
/*      */     }
/*      */ 
/*  814 */     if (!this.mflag)
/*      */     {
/*  816 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  820 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  821 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  826 */       CError tError = new CError();
/*  827 */       tError.moduleName = "LNPRiskRoleDB";
/*  828 */       tError.functionName = "prepareData";
/*  829 */       tError.errorMessage = e.toString();
/*  830 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  833 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  839 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  843 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  847 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  852 */       return false;
/*      */     }
/*      */ 
/*  855 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  859 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  864 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  870 */     boolean flag = true;
/*  871 */     if (this.mResultSet == null)
/*      */     {
/*  873 */       CError tError = new CError();
/*  874 */       tError.moduleName = "LNPRiskRoleDB";
/*  875 */       tError.functionName = "hasMoreData";
/*  876 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  877 */       this.mErrors.addOneError(tError);
/*  878 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  882 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  886 */       CError tError = new CError();
/*  887 */       tError.moduleName = "LNPRiskRoleDB";
/*  888 */       tError.functionName = "hasMoreData";
/*  889 */       tError.errorMessage = ex.toString();
/*  890 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  893 */         this.mResultSet.close();
/*  894 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  900 */         this.mStatement.close();
/*  901 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  905 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  909 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  914 */       return false;
/*      */     }
/*  916 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPRiskRoleSet getData()
/*      */   {
/*  921 */     int tCount = 0;
/*  922 */     LNPRiskRoleSet tLNPRiskRoleSet = new LNPRiskRoleSet();
/*  923 */     LNPRiskRoleSchema tLNPRiskRoleSchema = null;
/*  924 */     if (this.mResultSet == null)
/*      */     {
/*  926 */       CError tError = new CError();
/*  927 */       tError.moduleName = "LNPRiskRoleDB";
/*  928 */       tError.functionName = "getData";
/*  929 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  930 */       this.mErrors.addOneError(tError);
/*  931 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  935 */       tCount = 1;
/*  936 */       tLNPRiskRoleSchema = new LNPRiskRoleSchema();
/*  937 */       tLNPRiskRoleSchema.setSchema(this.mResultSet, 1);
/*  938 */       tLNPRiskRoleSet.add(tLNPRiskRoleSchema);
/*      */ 
/*  940 */       while (tCount++ < 5000)
/*      */       {
/*  942 */         if (!this.mResultSet.next())
/*      */           continue;
/*  944 */         tLNPRiskRoleSchema = new LNPRiskRoleSchema();
/*  945 */         tLNPRiskRoleSchema.setSchema(this.mResultSet, 1);
/*  946 */         tLNPRiskRoleSet.add(tLNPRiskRoleSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  952 */       CError tError = new CError();
/*  953 */       tError.moduleName = "LNPRiskRoleDB";
/*  954 */       tError.functionName = "getData";
/*  955 */       tError.errorMessage = ex.toString();
/*  956 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  959 */         this.mResultSet.close();
/*  960 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  966 */         this.mStatement.close();
/*  967 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  971 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  975 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  980 */       return null;
/*      */     }
/*  982 */     return tLNPRiskRoleSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  987 */     boolean flag = true;
/*      */     try
/*      */     {
/*  990 */       if (this.mResultSet == null)
/*      */       {
/*  992 */         CError tError = new CError();
/*  993 */         tError.moduleName = "LNPRiskRoleDB";
/*  994 */         tError.functionName = "closeData";
/*  995 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/*  996 */         this.mErrors.addOneError(tError);
/*  997 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1001 */         this.mResultSet.close();
/* 1002 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1007 */       CError tError = new CError();
/* 1008 */       tError.moduleName = "LNPRiskRoleDB";
/* 1009 */       tError.functionName = "closeData";
/* 1010 */       tError.errorMessage = ex2.toString();
/* 1011 */       this.mErrors.addOneError(tError);
/* 1012 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1016 */       if (this.mStatement == null)
/*      */       {
/* 1018 */         CError tError = new CError();
/* 1019 */         tError.moduleName = "LNPRiskRoleDB";
/* 1020 */         tError.functionName = "closeData";
/* 1021 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1022 */         this.mErrors.addOneError(tError);
/* 1023 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1027 */         this.mStatement.close();
/* 1028 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1033 */       CError tError = new CError();
/* 1034 */       tError.moduleName = "LNPRiskRoleDB";
/* 1035 */       tError.functionName = "closeData";
/* 1036 */       tError.errorMessage = ex3.toString();
/* 1037 */       this.mErrors.addOneError(tError);
/* 1038 */       flag = false;
/*      */     }
/* 1040 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskRoleDB
 * JD-Core Version:    0.6.0
 */