/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskComCtrlSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskComCtrlSet;
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
/*      */ public class LNPRiskComCtrlDB extends LNPRiskComCtrlSchema
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
/*      */   public LNPRiskComCtrlDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPRiskComCtrl");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPRiskComCtrlDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPRiskComCtrl");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPRiskComCtrlSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPRiskComCtrlDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPRiskComCtrlSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPRiskComCtrlDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskComCtrl WHERE  RiskCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
/*   97 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  102 */       if ((getManageComGrp() == null) || (getManageComGrp().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getManageComGrp());
/*      */       }
/*  107 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  108 */         pstmt.setNull(3, 12);
/*      */       else {
/*  110 */         pstmt.setString(3, getSaleChnl());
/*      */       }
/*  112 */       pstmt.executeUpdate();
/*  113 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  116 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  117 */       CError tError = new CError();
/*  118 */       tError.moduleName = "LNPRiskComCtrlDB";
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
/*  155 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskComCtrl SET  RiskCode = ? , ManageComGrp = ? , SaleChnl = ? , StartDate = ? , EndDate = ? , MAXAmnt = ? , MAXMult = ? , MAXPrem = ? , MINAmnt = ? , MINMult = ? , MINPrem = ? WHERE  RiskCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
/*  156 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  157 */         pstmt.setNull(1, 12);
/*      */       else {
/*  159 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  161 */       if ((getManageComGrp() == null) || (getManageComGrp().equals("null")))
/*  162 */         pstmt.setNull(2, 12);
/*      */       else {
/*  164 */         pstmt.setString(2, getManageComGrp());
/*      */       }
/*  166 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  167 */         pstmt.setNull(3, 12);
/*      */       else {
/*  169 */         pstmt.setString(3, getSaleChnl());
/*      */       }
/*  171 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  172 */         pstmt.setNull(4, 91);
/*      */       else {
/*  174 */         pstmt.setDate(4, Date.valueOf(getStartDate()));
/*      */       }
/*  176 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  177 */         pstmt.setNull(5, 91);
/*      */       else {
/*  179 */         pstmt.setDate(5, Date.valueOf(getEndDate()));
/*      */       }
/*  181 */       pstmt.setDouble(6, getMAXAmnt());
/*  182 */       pstmt.setDouble(7, getMAXMult());
/*  183 */       pstmt.setDouble(8, getMAXPrem());
/*  184 */       pstmt.setDouble(9, getMINAmnt());
/*  185 */       pstmt.setDouble(10, getMINMult());
/*  186 */       pstmt.setDouble(11, getMINPrem());
/*      */ 
/*  188 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  189 */         pstmt.setNull(12, 12);
/*      */       else {
/*  191 */         pstmt.setString(12, getRiskCode());
/*      */       }
/*  193 */       if ((getManageComGrp() == null) || (getManageComGrp().equals("null")))
/*  194 */         pstmt.setNull(13, 12);
/*      */       else {
/*  196 */         pstmt.setString(13, getManageComGrp());
/*      */       }
/*  198 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  199 */         pstmt.setNull(14, 12);
/*      */       else {
/*  201 */         pstmt.setString(14, getSaleChnl());
/*      */       }
/*  203 */       pstmt.executeUpdate();
/*  204 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  207 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  208 */       CError tError = new CError();
/*  209 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  210 */       tError.functionName = "update()";
/*  211 */       tError.errorMessage = ex.toString();
/*  212 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  215 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  218 */       if (!this.mflag)
/*      */         try {
/*  220 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  224 */       return false;
/*      */     }
/*      */ 
/*  227 */     if (!this.mflag)
/*      */       try {
/*  229 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  233 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  238 */     PreparedStatement pstmt = null;
/*      */ 
/*  240 */     if (!this.mflag) {
/*  241 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  246 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskComCtrl VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  247 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  248 */         pstmt.setNull(1, 12);
/*      */       else {
/*  250 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  252 */       if ((getManageComGrp() == null) || (getManageComGrp().equals("null")))
/*  253 */         pstmt.setNull(2, 12);
/*      */       else {
/*  255 */         pstmt.setString(2, getManageComGrp());
/*      */       }
/*  257 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  258 */         pstmt.setNull(3, 12);
/*      */       else {
/*  260 */         pstmt.setString(3, getSaleChnl());
/*      */       }
/*  262 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  263 */         pstmt.setNull(4, 91);
/*      */       else {
/*  265 */         pstmt.setDate(4, Date.valueOf(getStartDate()));
/*      */       }
/*  267 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  268 */         pstmt.setNull(5, 91);
/*      */       else {
/*  270 */         pstmt.setDate(5, Date.valueOf(getEndDate()));
/*      */       }
/*  272 */       pstmt.setDouble(6, getMAXAmnt());
/*  273 */       pstmt.setDouble(7, getMAXMult());
/*  274 */       pstmt.setDouble(8, getMAXPrem());
/*  275 */       pstmt.setDouble(9, getMINAmnt());
/*  276 */       pstmt.setDouble(10, getMINMult());
/*  277 */       pstmt.setDouble(11, getMINPrem());
/*      */ 
/*  279 */       pstmt.executeUpdate();
/*  280 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  283 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  284 */       CError tError = new CError();
/*  285 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  286 */       tError.functionName = "insert()";
/*  287 */       tError.errorMessage = ex.toString();
/*  288 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  291 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  294 */       if (!this.mflag)
/*      */         try {
/*  296 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  300 */       return false;
/*      */     }
/*      */ 
/*  303 */     if (!this.mflag)
/*      */       try {
/*  305 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  309 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  314 */     PreparedStatement pstmt = null;
/*  315 */     ResultSet rs = null;
/*      */ 
/*  317 */     if (!this.mflag) {
/*  318 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  323 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRiskComCtrl WHERE  RiskCode = ? AND ManageComGrp = ? AND SaleChnl = ?", 
/*  324 */         1003, 1007);
/*  325 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  326 */         pstmt.setNull(1, 12);
/*      */       else {
/*  328 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  330 */       if ((getManageComGrp() == null) || (getManageComGrp().equals("null")))
/*  331 */         pstmt.setNull(2, 12);
/*      */       else {
/*  333 */         pstmt.setString(2, getManageComGrp());
/*      */       }
/*  335 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  336 */         pstmt.setNull(3, 12);
/*      */       else {
/*  338 */         pstmt.setString(3, getSaleChnl());
/*      */       }
/*  340 */       rs = pstmt.executeQuery();
/*  341 */       int i = 0;
/*  342 */       if (rs.next())
/*      */       {
/*  344 */         i++;
/*  345 */         if (!setSchema(rs, i))
/*      */         {
/*  348 */           CError tError = new CError();
/*  349 */           tError.moduleName = "LNPRiskComCtrlDB";
/*  350 */           tError.functionName = "getInfo";
/*  351 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  352 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  354 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  357 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  361 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  365 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  369 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  372 */       if (i == 0)
/*      */       {
/*  374 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  378 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  382 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  388 */       CError tError = new CError();
/*  389 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  390 */       tError.functionName = "getInfo";
/*  391 */       tError.errorMessage = e.toString();
/*  392 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  394 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  397 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  401 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  405 */       return false;
/*      */     }
/*      */ 
/*  408 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  412 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  417 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRiskComCtrlSet query()
/*      */   {
/*  422 */     Statement stmt = null;
/*  423 */     ResultSet rs = null;
/*  424 */     LNPRiskComCtrlSet aLNPRiskComCtrlSet = new LNPRiskComCtrlSet();
/*      */ 
/*  426 */     if (!this.mflag) {
/*  427 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  432 */       stmt = this.con.createStatement(1003, 1007);
/*  433 */       SQLString sqlObj = new SQLString("LNPRiskComCtrl");
/*  434 */       LNPRiskComCtrlSchema aSchema = getSchema();
/*  435 */       sqlObj.setSQL(5, aSchema);
/*  436 */       String sql = sqlObj.getSQL();
/*      */ 
/*  438 */       rs = stmt.executeQuery(sql);
/*  439 */       int i = 0;
/*  440 */       while (rs.next())
/*      */       {
/*  442 */         i++;
/*  443 */         LNPRiskComCtrlSchema s1 = new LNPRiskComCtrlSchema();
/*  444 */         s1.setSchema(rs, i);
/*  445 */         aLNPRiskComCtrlSet.add(s1);
/*      */       }try {
/*  447 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  453 */       CError tError = new CError();
/*  454 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  455 */       tError.functionName = "query";
/*  456 */       tError.errorMessage = e.toString();
/*  457 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  459 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  462 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  466 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  472 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  476 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  481 */     return aLNPRiskComCtrlSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskComCtrlSet executeQuery(String sql)
/*      */   {
/*  486 */     Statement stmt = null;
/*  487 */     ResultSet rs = null;
/*  488 */     LNPRiskComCtrlSet aLNPRiskComCtrlSet = new LNPRiskComCtrlSet();
/*      */ 
/*  490 */     if (!this.mflag) {
/*  491 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  496 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  498 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  499 */       int i = 0;
/*  500 */       while (rs.next())
/*      */       {
/*  502 */         i++;
/*  503 */         LNPRiskComCtrlSchema s1 = new LNPRiskComCtrlSchema();
/*  504 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  507 */           CError tError = new CError();
/*  508 */           tError.moduleName = "LNPRiskComCtrlDB";
/*  509 */           tError.functionName = "executeQuery";
/*  510 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  511 */           this.mErrors.addOneError(tError);
/*      */         }
/*  513 */         aLNPRiskComCtrlSet.add(s1);
/*      */       }try {
/*  515 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  521 */       CError tError = new CError();
/*  522 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  523 */       tError.functionName = "executeQuery";
/*  524 */       tError.errorMessage = e.toString();
/*  525 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  527 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  530 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  534 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  540 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  544 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  549 */     return aLNPRiskComCtrlSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskComCtrlSet query(int nStart, int nCount)
/*      */   {
/*  554 */     Statement stmt = null;
/*  555 */     ResultSet rs = null;
/*  556 */     LNPRiskComCtrlSet aLNPRiskComCtrlSet = new LNPRiskComCtrlSet();
/*      */ 
/*  558 */     if (!this.mflag) {
/*  559 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  564 */       stmt = this.con.createStatement(1003, 1007);
/*  565 */       SQLString sqlObj = new SQLString("LNPRiskComCtrl");
/*  566 */       LNPRiskComCtrlSchema aSchema = getSchema();
/*  567 */       sqlObj.setSQL(5, aSchema);
/*  568 */       String sql = sqlObj.getSQL();
/*      */ 
/*  570 */       rs = stmt.executeQuery(sql);
/*  571 */       int i = 0;
/*  572 */       while (rs.next())
/*      */       {
/*  574 */         i++;
/*      */ 
/*  576 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  580 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  584 */         LNPRiskComCtrlSchema s1 = new LNPRiskComCtrlSchema();
/*  585 */         s1.setSchema(rs, i);
/*  586 */         aLNPRiskComCtrlSet.add(s1);
/*      */       }try {
/*  588 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  594 */       CError tError = new CError();
/*  595 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  596 */       tError.functionName = "query";
/*  597 */       tError.errorMessage = e.toString();
/*  598 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  600 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  603 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  607 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  613 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  617 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  622 */     return aLNPRiskComCtrlSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskComCtrlSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  627 */     Statement stmt = null;
/*  628 */     ResultSet rs = null;
/*  629 */     LNPRiskComCtrlSet aLNPRiskComCtrlSet = new LNPRiskComCtrlSet();
/*      */ 
/*  631 */     if (!this.mflag) {
/*  632 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  637 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  639 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  640 */       int i = 0;
/*  641 */       while (rs.next())
/*      */       {
/*  643 */         i++;
/*      */ 
/*  645 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  649 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  653 */         LNPRiskComCtrlSchema s1 = new LNPRiskComCtrlSchema();
/*  654 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  657 */           CError tError = new CError();
/*  658 */           tError.moduleName = "LNPRiskComCtrlDB";
/*  659 */           tError.functionName = "executeQuery";
/*  660 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  661 */           this.mErrors.addOneError(tError);
/*      */         }
/*  663 */         aLNPRiskComCtrlSet.add(s1);
/*      */       }try {
/*  665 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  671 */       CError tError = new CError();
/*  672 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  673 */       tError.functionName = "executeQuery";
/*  674 */       tError.errorMessage = e.toString();
/*  675 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  677 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  680 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  684 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  690 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  694 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  699 */     return aLNPRiskComCtrlSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  704 */     Statement stmt = null;
/*      */ 
/*  706 */     if (!this.mflag) {
/*  707 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  712 */       stmt = this.con.createStatement(1003, 1007);
/*  713 */       SQLString sqlObj = new SQLString("LNPRiskComCtrl");
/*  714 */       LNPRiskComCtrlSchema aSchema = getSchema();
/*  715 */       sqlObj.setSQL(2, aSchema);
/*  716 */       String sql = "update LNPRiskComCtrl " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  718 */       int operCount = stmt.executeUpdate(sql);
/*  719 */       if (operCount == 0)
/*      */       {
/*  722 */         CError tError = new CError();
/*  723 */         tError.moduleName = "LNPRiskComCtrlDB";
/*  724 */         tError.functionName = "update";
/*  725 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  726 */         this.mErrors.addOneError(tError);
/*      */ 
/*  728 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  732 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  736 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  742 */       CError tError = new CError();
/*  743 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  744 */       tError.functionName = "update";
/*  745 */       tError.errorMessage = e.toString();
/*  746 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  748 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  750 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  754 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  758 */       return false;
/*      */     }
/*      */ 
/*  761 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  765 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  770 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  776 */     if (this.mResultSet != null)
/*      */     {
/*  779 */       CError tError = new CError();
/*  780 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  781 */       tError.functionName = "prepareData";
/*  782 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  783 */       this.mErrors.addOneError(tError);
/*  784 */       return false;
/*      */     }
/*      */ 
/*  787 */     if (!this.mflag)
/*      */     {
/*  789 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  793 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  794 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  799 */       CError tError = new CError();
/*  800 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  801 */       tError.functionName = "prepareData";
/*  802 */       tError.errorMessage = e.toString();
/*  803 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  806 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  812 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  816 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  820 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  825 */       return false;
/*      */     }
/*      */ 
/*  828 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  832 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  837 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  843 */     boolean flag = true;
/*  844 */     if (this.mResultSet == null)
/*      */     {
/*  846 */       CError tError = new CError();
/*  847 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  848 */       tError.functionName = "hasMoreData";
/*  849 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  850 */       this.mErrors.addOneError(tError);
/*  851 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  855 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  859 */       CError tError = new CError();
/*  860 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  861 */       tError.functionName = "hasMoreData";
/*  862 */       tError.errorMessage = ex.toString();
/*  863 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  866 */         this.mResultSet.close();
/*  867 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  873 */         this.mStatement.close();
/*  874 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  878 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  882 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  887 */       return false;
/*      */     }
/*  889 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPRiskComCtrlSet getData()
/*      */   {
/*  894 */     int tCount = 0;
/*  895 */     LNPRiskComCtrlSet tLNPRiskComCtrlSet = new LNPRiskComCtrlSet();
/*  896 */     LNPRiskComCtrlSchema tLNPRiskComCtrlSchema = null;
/*  897 */     if (this.mResultSet == null)
/*      */     {
/*  899 */       CError tError = new CError();
/*  900 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  901 */       tError.functionName = "getData";
/*  902 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  903 */       this.mErrors.addOneError(tError);
/*  904 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  908 */       tCount = 1;
/*  909 */       tLNPRiskComCtrlSchema = new LNPRiskComCtrlSchema();
/*  910 */       tLNPRiskComCtrlSchema.setSchema(this.mResultSet, 1);
/*  911 */       tLNPRiskComCtrlSet.add(tLNPRiskComCtrlSchema);
/*      */ 
/*  913 */       while (tCount++ < 5000)
/*      */       {
/*  915 */         if (!this.mResultSet.next())
/*      */           continue;
/*  917 */         tLNPRiskComCtrlSchema = new LNPRiskComCtrlSchema();
/*  918 */         tLNPRiskComCtrlSchema.setSchema(this.mResultSet, 1);
/*  919 */         tLNPRiskComCtrlSet.add(tLNPRiskComCtrlSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  925 */       CError tError = new CError();
/*  926 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  927 */       tError.functionName = "getData";
/*  928 */       tError.errorMessage = ex.toString();
/*  929 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  932 */         this.mResultSet.close();
/*  933 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  939 */         this.mStatement.close();
/*  940 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  944 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  948 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  953 */       return null;
/*      */     }
/*  955 */     return tLNPRiskComCtrlSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  960 */     boolean flag = true;
/*      */     try
/*      */     {
/*  963 */       if (this.mResultSet == null)
/*      */       {
/*  965 */         CError tError = new CError();
/*  966 */         tError.moduleName = "LNPRiskComCtrlDB";
/*  967 */         tError.functionName = "closeData";
/*  968 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/*  969 */         this.mErrors.addOneError(tError);
/*  970 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  974 */         this.mResultSet.close();
/*  975 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/*  980 */       CError tError = new CError();
/*  981 */       tError.moduleName = "LNPRiskComCtrlDB";
/*  982 */       tError.functionName = "closeData";
/*  983 */       tError.errorMessage = ex2.toString();
/*  984 */       this.mErrors.addOneError(tError);
/*  985 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/*  989 */       if (this.mStatement == null)
/*      */       {
/*  991 */         CError tError = new CError();
/*  992 */         tError.moduleName = "LNPRiskComCtrlDB";
/*  993 */         tError.functionName = "closeData";
/*  994 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/*  995 */         this.mErrors.addOneError(tError);
/*  996 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1000 */         this.mStatement.close();
/* 1001 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1006 */       CError tError = new CError();
/* 1007 */       tError.moduleName = "LNPRiskComCtrlDB";
/* 1008 */       tError.functionName = "closeData";
/* 1009 */       tError.errorMessage = ex3.toString();
/* 1010 */       this.mErrors.addOneError(tError);
/* 1011 */       flag = false;
/*      */     }
/* 1013 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskComCtrlDB
 * JD-Core Version:    0.6.0
 */