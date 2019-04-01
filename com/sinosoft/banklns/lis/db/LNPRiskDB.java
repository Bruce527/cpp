/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskSet;
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
/*      */ public class LNPRiskDB extends LNPRiskSchema
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
/*      */   public LNPRiskDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPRisk");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPRiskDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPRisk");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPRiskSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPRiskDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPRiskSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPRiskDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRisk WHERE  RiskCode = ?");
/*   97 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPRiskDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPRisk SET  RiskCode = ? , RiskVer = ? , RiskName = ? , RiskShortName = ? , RiskEnName = ? , RiskEnShortName = ? , ChoDutyFlag = ? , CPayFlag = ? , GetFlag = ? , EdorFlag = ? , RnewFlag = ? , UWFlag = ? , RinsFlag = ? , InsuAccFlag = ? , DestRate = ? , OrigRiskCode = ? , SubRiskVer = ? , RiskStatName = ? WHERE  RiskCode = ?");
/*  146 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  151 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getRiskVer());
/*      */       }
/*  156 */       if ((getRiskName() == null) || (getRiskName().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getRiskName());
/*      */       }
/*  161 */       if ((getRiskShortName() == null) || (getRiskShortName().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getRiskShortName());
/*      */       }
/*  166 */       if ((getRiskEnName() == null) || (getRiskEnName().equals("null")))
/*  167 */         pstmt.setNull(5, 12);
/*      */       else {
/*  169 */         pstmt.setString(5, getRiskEnName());
/*      */       }
/*  171 */       if ((getRiskEnShortName() == null) || (getRiskEnShortName().equals("null")))
/*  172 */         pstmt.setNull(6, 12);
/*      */       else {
/*  174 */         pstmt.setString(6, getRiskEnShortName());
/*      */       }
/*  176 */       if ((getChoDutyFlag() == null) || (getChoDutyFlag().equals("null")))
/*  177 */         pstmt.setNull(7, 12);
/*      */       else {
/*  179 */         pstmt.setString(7, getChoDutyFlag());
/*      */       }
/*  181 */       if ((getCPayFlag() == null) || (getCPayFlag().equals("null")))
/*  182 */         pstmt.setNull(8, 12);
/*      */       else {
/*  184 */         pstmt.setString(8, getCPayFlag());
/*      */       }
/*  186 */       if ((getGetFlag() == null) || (getGetFlag().equals("null")))
/*  187 */         pstmt.setNull(9, 12);
/*      */       else {
/*  189 */         pstmt.setString(9, getGetFlag());
/*      */       }
/*  191 */       if ((getEdorFlag() == null) || (getEdorFlag().equals("null")))
/*  192 */         pstmt.setNull(10, 12);
/*      */       else {
/*  194 */         pstmt.setString(10, getEdorFlag());
/*      */       }
/*  196 */       if ((getRnewFlag() == null) || (getRnewFlag().equals("null")))
/*  197 */         pstmt.setNull(11, 12);
/*      */       else {
/*  199 */         pstmt.setString(11, getRnewFlag());
/*      */       }
/*  201 */       if ((getUWFlag() == null) || (getUWFlag().equals("null")))
/*  202 */         pstmt.setNull(12, 12);
/*      */       else {
/*  204 */         pstmt.setString(12, getUWFlag());
/*      */       }
/*  206 */       if ((getRinsFlag() == null) || (getRinsFlag().equals("null")))
/*  207 */         pstmt.setNull(13, 12);
/*      */       else {
/*  209 */         pstmt.setString(13, getRinsFlag());
/*      */       }
/*  211 */       if ((getInsuAccFlag() == null) || (getInsuAccFlag().equals("null")))
/*  212 */         pstmt.setNull(14, 12);
/*      */       else {
/*  214 */         pstmt.setString(14, getInsuAccFlag());
/*      */       }
/*  216 */       pstmt.setDouble(15, getDestRate());
/*  217 */       if ((getOrigRiskCode() == null) || (getOrigRiskCode().equals("null")))
/*  218 */         pstmt.setNull(16, 12);
/*      */       else {
/*  220 */         pstmt.setString(16, getOrigRiskCode());
/*      */       }
/*  222 */       if ((getSubRiskVer() == null) || (getSubRiskVer().equals("null")))
/*  223 */         pstmt.setNull(17, 12);
/*      */       else {
/*  225 */         pstmt.setString(17, getSubRiskVer());
/*      */       }
/*  227 */       if ((getRiskStatName() == null) || (getRiskStatName().equals("null")))
/*  228 */         pstmt.setNull(18, 12);
/*      */       else {
/*  230 */         pstmt.setString(18, getRiskStatName());
/*      */       }
/*      */ 
/*  233 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  234 */         pstmt.setNull(19, 12);
/*      */       else {
/*  236 */         pstmt.setString(19, getRiskCode());
/*      */       }
/*  238 */       pstmt.executeUpdate();
/*  239 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  242 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  243 */       CError tError = new CError();
/*  244 */       tError.moduleName = "LNPRiskDB";
/*  245 */       tError.functionName = "update()";
/*  246 */       tError.errorMessage = ex.toString();
/*  247 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  250 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  253 */       if (!this.mflag)
/*      */         try {
/*  255 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  259 */       return false;
/*      */     }
/*      */ 
/*  262 */     if (!this.mflag)
/*      */       try {
/*  264 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  268 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  273 */     PreparedStatement pstmt = null;
/*      */ 
/*  275 */     if (!this.mflag) {
/*  276 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  281 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRisk VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  282 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  283 */         pstmt.setNull(1, 12);
/*      */       else {
/*  285 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  287 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/*  288 */         pstmt.setNull(2, 12);
/*      */       else {
/*  290 */         pstmt.setString(2, getRiskVer());
/*      */       }
/*  292 */       if ((getRiskName() == null) || (getRiskName().equals("null")))
/*  293 */         pstmt.setNull(3, 12);
/*      */       else {
/*  295 */         pstmt.setString(3, getRiskName());
/*      */       }
/*  297 */       if ((getRiskShortName() == null) || (getRiskShortName().equals("null")))
/*  298 */         pstmt.setNull(4, 12);
/*      */       else {
/*  300 */         pstmt.setString(4, getRiskShortName());
/*      */       }
/*  302 */       if ((getRiskEnName() == null) || (getRiskEnName().equals("null")))
/*  303 */         pstmt.setNull(5, 12);
/*      */       else {
/*  305 */         pstmt.setString(5, getRiskEnName());
/*      */       }
/*  307 */       if ((getRiskEnShortName() == null) || (getRiskEnShortName().equals("null")))
/*  308 */         pstmt.setNull(6, 12);
/*      */       else {
/*  310 */         pstmt.setString(6, getRiskEnShortName());
/*      */       }
/*  312 */       if ((getChoDutyFlag() == null) || (getChoDutyFlag().equals("null")))
/*  313 */         pstmt.setNull(7, 12);
/*      */       else {
/*  315 */         pstmt.setString(7, getChoDutyFlag());
/*      */       }
/*  317 */       if ((getCPayFlag() == null) || (getCPayFlag().equals("null")))
/*  318 */         pstmt.setNull(8, 12);
/*      */       else {
/*  320 */         pstmt.setString(8, getCPayFlag());
/*      */       }
/*  322 */       if ((getGetFlag() == null) || (getGetFlag().equals("null")))
/*  323 */         pstmt.setNull(9, 12);
/*      */       else {
/*  325 */         pstmt.setString(9, getGetFlag());
/*      */       }
/*  327 */       if ((getEdorFlag() == null) || (getEdorFlag().equals("null")))
/*  328 */         pstmt.setNull(10, 12);
/*      */       else {
/*  330 */         pstmt.setString(10, getEdorFlag());
/*      */       }
/*  332 */       if ((getRnewFlag() == null) || (getRnewFlag().equals("null")))
/*  333 */         pstmt.setNull(11, 12);
/*      */       else {
/*  335 */         pstmt.setString(11, getRnewFlag());
/*      */       }
/*  337 */       if ((getUWFlag() == null) || (getUWFlag().equals("null")))
/*  338 */         pstmt.setNull(12, 12);
/*      */       else {
/*  340 */         pstmt.setString(12, getUWFlag());
/*      */       }
/*  342 */       if ((getRinsFlag() == null) || (getRinsFlag().equals("null")))
/*  343 */         pstmt.setNull(13, 12);
/*      */       else {
/*  345 */         pstmt.setString(13, getRinsFlag());
/*      */       }
/*  347 */       if ((getInsuAccFlag() == null) || (getInsuAccFlag().equals("null")))
/*  348 */         pstmt.setNull(14, 12);
/*      */       else {
/*  350 */         pstmt.setString(14, getInsuAccFlag());
/*      */       }
/*  352 */       pstmt.setDouble(15, getDestRate());
/*  353 */       if ((getOrigRiskCode() == null) || (getOrigRiskCode().equals("null")))
/*  354 */         pstmt.setNull(16, 12);
/*      */       else {
/*  356 */         pstmt.setString(16, getOrigRiskCode());
/*      */       }
/*  358 */       if ((getSubRiskVer() == null) || (getSubRiskVer().equals("null")))
/*  359 */         pstmt.setNull(17, 12);
/*      */       else {
/*  361 */         pstmt.setString(17, getSubRiskVer());
/*      */       }
/*  363 */       if ((getRiskStatName() == null) || (getRiskStatName().equals("null")))
/*  364 */         pstmt.setNull(18, 12);
/*      */       else {
/*  366 */         pstmt.setString(18, getRiskStatName());
/*      */       }
/*      */ 
/*  369 */       pstmt.executeUpdate();
/*  370 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  373 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  374 */       CError tError = new CError();
/*  375 */       tError.moduleName = "LNPRiskDB";
/*  376 */       tError.functionName = "insert()";
/*  377 */       tError.errorMessage = ex.toString();
/*  378 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  381 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  384 */       if (!this.mflag)
/*      */         try {
/*  386 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  390 */       return false;
/*      */     }
/*      */ 
/*  393 */     if (!this.mflag)
/*      */       try {
/*  395 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  399 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  404 */     PreparedStatement pstmt = null;
/*  405 */     ResultSet rs = null;
/*      */ 
/*  407 */     if (!this.mflag) {
/*  408 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  413 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRisk WHERE  RiskCode = ?", 
/*  414 */         1003, 1007);
/*  415 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  416 */         pstmt.setNull(1, 12);
/*      */       else {
/*  418 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  420 */       rs = pstmt.executeQuery();
/*  421 */       int i = 0;
/*  422 */       if (rs.next())
/*      */       {
/*  424 */         i++;
/*  425 */         if (!setSchema(rs, i))
/*      */         {
/*  428 */           CError tError = new CError();
/*  429 */           tError.moduleName = "LNPRiskDB";
/*  430 */           tError.functionName = "getInfo";
/*  431 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  432 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  434 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  437 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  441 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  445 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  449 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  452 */       if (i == 0)
/*      */       {
/*  454 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  458 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  462 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  468 */       CError tError = new CError();
/*  469 */       tError.moduleName = "LNPRiskDB";
/*  470 */       tError.functionName = "getInfo";
/*  471 */       tError.errorMessage = e.toString();
/*  472 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  474 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  477 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  481 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  485 */       return false;
/*      */     }
/*      */ 
/*  488 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  492 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  497 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRiskSet query()
/*      */   {
/*  502 */     Statement stmt = null;
/*  503 */     ResultSet rs = null;
/*  504 */     LNPRiskSet aLNPRiskSet = new LNPRiskSet();
/*      */ 
/*  506 */     if (!this.mflag) {
/*  507 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  512 */       stmt = this.con.createStatement(1003, 1007);
/*  513 */       SQLString sqlObj = new SQLString("LNPRisk");
/*  514 */       LNPRiskSchema aSchema = getSchema();
/*  515 */       sqlObj.setSQL(5, aSchema);
/*  516 */       String sql = sqlObj.getSQL();
/*      */ 
/*  518 */       rs = stmt.executeQuery(sql);
/*  519 */       int i = 0;
/*  520 */       while (rs.next())
/*      */       {
/*  522 */         i++;
/*  523 */         LNPRiskSchema s1 = new LNPRiskSchema();
/*  524 */         s1.setSchema(rs, i);
/*  525 */         aLNPRiskSet.add(s1);
/*      */       }try {
/*  527 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  533 */       CError tError = new CError();
/*  534 */       tError.moduleName = "LNPRiskDB";
/*  535 */       tError.functionName = "query";
/*  536 */       tError.errorMessage = e.toString();
/*  537 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  539 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  542 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  546 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  552 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  556 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  561 */     return aLNPRiskSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskSet executeQuery(String sql)
/*      */   {
/*  566 */     Statement stmt = null;
/*  567 */     ResultSet rs = null;
/*  568 */     LNPRiskSet aLNPRiskSet = new LNPRiskSet();
/*      */ 
/*  570 */     if (!this.mflag) {
/*  571 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  576 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  578 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  579 */       int i = 0;
/*  580 */       while (rs.next())
/*      */       {
/*  582 */         i++;
/*  583 */         LNPRiskSchema s1 = new LNPRiskSchema();
/*  584 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  587 */           CError tError = new CError();
/*  588 */           tError.moduleName = "LNPRiskDB";
/*  589 */           tError.functionName = "executeQuery";
/*  590 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  591 */           this.mErrors.addOneError(tError);
/*      */         }
/*  593 */         aLNPRiskSet.add(s1);
/*      */       }try {
/*  595 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  601 */       CError tError = new CError();
/*  602 */       tError.moduleName = "LNPRiskDB";
/*  603 */       tError.functionName = "executeQuery";
/*  604 */       tError.errorMessage = e.toString();
/*  605 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  607 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  610 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  614 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  620 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  624 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  629 */     return aLNPRiskSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskSet query(int nStart, int nCount)
/*      */   {
/*  634 */     Statement stmt = null;
/*  635 */     ResultSet rs = null;
/*  636 */     LNPRiskSet aLNPRiskSet = new LNPRiskSet();
/*      */ 
/*  638 */     if (!this.mflag) {
/*  639 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  644 */       stmt = this.con.createStatement(1003, 1007);
/*  645 */       SQLString sqlObj = new SQLString("LNPRisk");
/*  646 */       LNPRiskSchema aSchema = getSchema();
/*  647 */       sqlObj.setSQL(5, aSchema);
/*  648 */       String sql = sqlObj.getSQL();
/*      */ 
/*  650 */       rs = stmt.executeQuery(sql);
/*  651 */       int i = 0;
/*  652 */       while (rs.next())
/*      */       {
/*  654 */         i++;
/*      */ 
/*  656 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  660 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  664 */         LNPRiskSchema s1 = new LNPRiskSchema();
/*  665 */         s1.setSchema(rs, i);
/*  666 */         aLNPRiskSet.add(s1);
/*      */       }try {
/*  668 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  674 */       CError tError = new CError();
/*  675 */       tError.moduleName = "LNPRiskDB";
/*  676 */       tError.functionName = "query";
/*  677 */       tError.errorMessage = e.toString();
/*  678 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  680 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  683 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  687 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  693 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  697 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  702 */     return aLNPRiskSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  707 */     Statement stmt = null;
/*  708 */     ResultSet rs = null;
/*  709 */     LNPRiskSet aLNPRiskSet = new LNPRiskSet();
/*      */ 
/*  711 */     if (!this.mflag) {
/*  712 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  717 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  719 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  720 */       int i = 0;
/*  721 */       while (rs.next())
/*      */       {
/*  723 */         i++;
/*      */ 
/*  725 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  729 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  733 */         LNPRiskSchema s1 = new LNPRiskSchema();
/*  734 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  737 */           CError tError = new CError();
/*  738 */           tError.moduleName = "LNPRiskDB";
/*  739 */           tError.functionName = "executeQuery";
/*  740 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  741 */           this.mErrors.addOneError(tError);
/*      */         }
/*  743 */         aLNPRiskSet.add(s1);
/*      */       }try {
/*  745 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  751 */       CError tError = new CError();
/*  752 */       tError.moduleName = "LNPRiskDB";
/*  753 */       tError.functionName = "executeQuery";
/*  754 */       tError.errorMessage = e.toString();
/*  755 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  757 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  760 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  764 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  770 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  774 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  779 */     return aLNPRiskSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  784 */     Statement stmt = null;
/*      */ 
/*  786 */     if (!this.mflag) {
/*  787 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  792 */       stmt = this.con.createStatement(1003, 1007);
/*  793 */       SQLString sqlObj = new SQLString("LNPRisk");
/*  794 */       LNPRiskSchema aSchema = getSchema();
/*  795 */       sqlObj.setSQL(2, aSchema);
/*  796 */       String sql = "update LNPRisk " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  798 */       int operCount = stmt.executeUpdate(sql);
/*  799 */       if (operCount == 0)
/*      */       {
/*  802 */         CError tError = new CError();
/*  803 */         tError.moduleName = "LNPRiskDB";
/*  804 */         tError.functionName = "update";
/*  805 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  806 */         this.mErrors.addOneError(tError);
/*      */ 
/*  808 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  812 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  816 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  822 */       CError tError = new CError();
/*  823 */       tError.moduleName = "LNPRiskDB";
/*  824 */       tError.functionName = "update";
/*  825 */       tError.errorMessage = e.toString();
/*  826 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  828 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  830 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  834 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  838 */       return false;
/*      */     }
/*      */ 
/*  841 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  845 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  850 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  856 */     if (this.mResultSet != null)
/*      */     {
/*  859 */       CError tError = new CError();
/*  860 */       tError.moduleName = "LNPRiskDB";
/*  861 */       tError.functionName = "prepareData";
/*  862 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  863 */       this.mErrors.addOneError(tError);
/*  864 */       return false;
/*      */     }
/*      */ 
/*  867 */     if (!this.mflag)
/*      */     {
/*  869 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  873 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  874 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  879 */       CError tError = new CError();
/*  880 */       tError.moduleName = "LNPRiskDB";
/*  881 */       tError.functionName = "prepareData";
/*  882 */       tError.errorMessage = e.toString();
/*  883 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  886 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  892 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  896 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  900 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  905 */       return false;
/*      */     }
/*      */ 
/*  908 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  912 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  917 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  923 */     boolean flag = true;
/*  924 */     if (this.mResultSet == null)
/*      */     {
/*  926 */       CError tError = new CError();
/*  927 */       tError.moduleName = "LNPRiskDB";
/*  928 */       tError.functionName = "hasMoreData";
/*  929 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  930 */       this.mErrors.addOneError(tError);
/*  931 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  935 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  939 */       CError tError = new CError();
/*  940 */       tError.moduleName = "LNPRiskDB";
/*  941 */       tError.functionName = "hasMoreData";
/*  942 */       tError.errorMessage = ex.toString();
/*  943 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  946 */         this.mResultSet.close();
/*  947 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  953 */         this.mStatement.close();
/*  954 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  958 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  962 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  967 */       return false;
/*      */     }
/*  969 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPRiskSet getData()
/*      */   {
/*  974 */     int tCount = 0;
/*  975 */     LNPRiskSet tLNPRiskSet = new LNPRiskSet();
/*  976 */     LNPRiskSchema tLNPRiskSchema = null;
/*  977 */     if (this.mResultSet == null)
/*      */     {
/*  979 */       CError tError = new CError();
/*  980 */       tError.moduleName = "LNPRiskDB";
/*  981 */       tError.functionName = "getData";
/*  982 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  983 */       this.mErrors.addOneError(tError);
/*  984 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  988 */       tCount = 1;
/*  989 */       tLNPRiskSchema = new LNPRiskSchema();
/*  990 */       tLNPRiskSchema.setSchema(this.mResultSet, 1);
/*  991 */       tLNPRiskSet.add(tLNPRiskSchema);
/*      */ 
/*  993 */       while (tCount++ < 5000)
/*      */       {
/*  995 */         if (!this.mResultSet.next())
/*      */           continue;
/*  997 */         tLNPRiskSchema = new LNPRiskSchema();
/*  998 */         tLNPRiskSchema.setSchema(this.mResultSet, 1);
/*  999 */         tLNPRiskSet.add(tLNPRiskSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1005 */       CError tError = new CError();
/* 1006 */       tError.moduleName = "LNPRiskDB";
/* 1007 */       tError.functionName = "getData";
/* 1008 */       tError.errorMessage = ex.toString();
/* 1009 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1012 */         this.mResultSet.close();
/* 1013 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1019 */         this.mStatement.close();
/* 1020 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1024 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1028 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1033 */       return null;
/*      */     }
/* 1035 */     return tLNPRiskSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1040 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1043 */       if (this.mResultSet == null)
/*      */       {
/* 1045 */         CError tError = new CError();
/* 1046 */         tError.moduleName = "LNPRiskDB";
/* 1047 */         tError.functionName = "closeData";
/* 1048 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1049 */         this.mErrors.addOneError(tError);
/* 1050 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1054 */         this.mResultSet.close();
/* 1055 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1060 */       CError tError = new CError();
/* 1061 */       tError.moduleName = "LNPRiskDB";
/* 1062 */       tError.functionName = "closeData";
/* 1063 */       tError.errorMessage = ex2.toString();
/* 1064 */       this.mErrors.addOneError(tError);
/* 1065 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1069 */       if (this.mStatement == null)
/*      */       {
/* 1071 */         CError tError = new CError();
/* 1072 */         tError.moduleName = "LNPRiskDB";
/* 1073 */         tError.functionName = "closeData";
/* 1074 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1075 */         this.mErrors.addOneError(tError);
/* 1076 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1080 */         this.mStatement.close();
/* 1081 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1086 */       CError tError = new CError();
/* 1087 */       tError.moduleName = "LNPRiskDB";
/* 1088 */       tError.functionName = "closeData";
/* 1089 */       tError.errorMessage = ex3.toString();
/* 1090 */       this.mErrors.addOneError(tError);
/* 1091 */       flag = false;
/*      */     }
/* 1093 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskDB
 * JD-Core Version:    0.6.0
 */