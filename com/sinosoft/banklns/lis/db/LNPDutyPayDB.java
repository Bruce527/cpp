/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPDutyPaySchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPDutyPaySet;
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
/*      */ public class LNPDutyPayDB extends LNPDutyPaySchema
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
/*      */   public LNPDutyPayDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPDutyPay");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPDutyPayDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPDutyPay");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPDutyPaySchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPDutyPayDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPDutyPaySchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPDutyPayDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPDutyPay WHERE  PayPlanCode = ?");
/*   97 */       if ((getPayPlanCode() == null) || (getPayPlanCode().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getPayPlanCode());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPDutyPayDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPDutyPay SET  PayPlanCode = ? , PayPlanName = ? , Type = ? , PayIntv = ? , PayEndYearFlag = ? , PayEndYear = ? , PayEndDateCalRef = ? , PayEndDateCalMode = ? , DefaultVal = ? , CalCode = ? , CnterCalCode = ? , OthCalCode = ? , Rate = ? , MinPay = ? , AssuYield = ? , FeeRate = ? , PayToDateCalMode = ? , UrgePayFlag = ? , PayLackFlag = ? , PayOverFlag = ? , PayOverDeal = ? , AvoidPayFlag = ? , GracePeriod = ? , PubFlag = ? , ZeroFlag = ? , NeedAcc = ? , PayAimClass = ? WHERE  PayPlanCode = ?");
/*  146 */       if ((getPayPlanCode() == null) || (getPayPlanCode().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getPayPlanCode());
/*      */       }
/*  151 */       if ((getPayPlanName() == null) || (getPayPlanName().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getPayPlanName());
/*      */       }
/*  156 */       if ((getType() == null) || (getType().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getType());
/*      */       }
/*  161 */       pstmt.setInt(4, getPayIntv());
/*  162 */       if ((getPayEndYearFlag() == null) || (getPayEndYearFlag().equals("null")))
/*  163 */         pstmt.setNull(5, 12);
/*      */       else {
/*  165 */         pstmt.setString(5, getPayEndYearFlag());
/*      */       }
/*  167 */       pstmt.setInt(6, getPayEndYear());
/*  168 */       if ((getPayEndDateCalRef() == null) || (getPayEndDateCalRef().equals("null")))
/*  169 */         pstmt.setNull(7, 12);
/*      */       else {
/*  171 */         pstmt.setString(7, getPayEndDateCalRef());
/*      */       }
/*  173 */       if ((getPayEndDateCalMode() == null) || (getPayEndDateCalMode().equals("null")))
/*  174 */         pstmt.setNull(8, 12);
/*      */       else {
/*  176 */         pstmt.setString(8, getPayEndDateCalMode());
/*      */       }
/*  178 */       pstmt.setDouble(9, getDefaultVal());
/*  179 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/*  180 */         pstmt.setNull(10, 12);
/*      */       else {
/*  182 */         pstmt.setString(10, getCalCode());
/*      */       }
/*  184 */       if ((getCnterCalCode() == null) || (getCnterCalCode().equals("null")))
/*  185 */         pstmt.setNull(11, 12);
/*      */       else {
/*  187 */         pstmt.setString(11, getCnterCalCode());
/*      */       }
/*  189 */       if ((getOthCalCode() == null) || (getOthCalCode().equals("null")))
/*  190 */         pstmt.setNull(12, 12);
/*      */       else {
/*  192 */         pstmt.setString(12, getOthCalCode());
/*      */       }
/*  194 */       pstmt.setDouble(13, getRate());
/*  195 */       pstmt.setDouble(14, getMinPay());
/*  196 */       pstmt.setDouble(15, getAssuYield());
/*  197 */       pstmt.setDouble(16, getFeeRate());
/*  198 */       if ((getPayToDateCalMode() == null) || (getPayToDateCalMode().equals("null")))
/*  199 */         pstmt.setNull(17, 12);
/*      */       else {
/*  201 */         pstmt.setString(17, getPayToDateCalMode());
/*      */       }
/*  203 */       if ((getUrgePayFlag() == null) || (getUrgePayFlag().equals("null")))
/*  204 */         pstmt.setNull(18, 12);
/*      */       else {
/*  206 */         pstmt.setString(18, getUrgePayFlag());
/*      */       }
/*  208 */       if ((getPayLackFlag() == null) || (getPayLackFlag().equals("null")))
/*  209 */         pstmt.setNull(19, 12);
/*      */       else {
/*  211 */         pstmt.setString(19, getPayLackFlag());
/*      */       }
/*  213 */       if ((getPayOverFlag() == null) || (getPayOverFlag().equals("null")))
/*  214 */         pstmt.setNull(20, 12);
/*      */       else {
/*  216 */         pstmt.setString(20, getPayOverFlag());
/*      */       }
/*  218 */       if ((getPayOverDeal() == null) || (getPayOverDeal().equals("null")))
/*  219 */         pstmt.setNull(21, 12);
/*      */       else {
/*  221 */         pstmt.setString(21, getPayOverDeal());
/*      */       }
/*  223 */       if ((getAvoidPayFlag() == null) || (getAvoidPayFlag().equals("null")))
/*  224 */         pstmt.setNull(22, 12);
/*      */       else {
/*  226 */         pstmt.setString(22, getAvoidPayFlag());
/*      */       }
/*  228 */       pstmt.setInt(23, getGracePeriod());
/*  229 */       if ((getPubFlag() == null) || (getPubFlag().equals("null")))
/*  230 */         pstmt.setNull(24, 12);
/*      */       else {
/*  232 */         pstmt.setString(24, getPubFlag());
/*      */       }
/*  234 */       if ((getZeroFlag() == null) || (getZeroFlag().equals("null")))
/*  235 */         pstmt.setNull(25, 12);
/*      */       else {
/*  237 */         pstmt.setString(25, getZeroFlag());
/*      */       }
/*  239 */       if ((getNeedAcc() == null) || (getNeedAcc().equals("null")))
/*  240 */         pstmt.setNull(26, 12);
/*      */       else {
/*  242 */         pstmt.setString(26, getNeedAcc());
/*      */       }
/*  244 */       if ((getPayAimClass() == null) || (getPayAimClass().equals("null")))
/*  245 */         pstmt.setNull(27, 12);
/*      */       else {
/*  247 */         pstmt.setString(27, getPayAimClass());
/*      */       }
/*      */ 
/*  250 */       if ((getPayPlanCode() == null) || (getPayPlanCode().equals("null")))
/*  251 */         pstmt.setNull(28, 12);
/*      */       else {
/*  253 */         pstmt.setString(28, getPayPlanCode());
/*      */       }
/*  255 */       pstmt.executeUpdate();
/*  256 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  259 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  260 */       CError tError = new CError();
/*  261 */       tError.moduleName = "LNPDutyPayDB";
/*  262 */       tError.functionName = "update()";
/*  263 */       tError.errorMessage = ex.toString();
/*  264 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  267 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  270 */       if (!this.mflag)
/*      */         try {
/*  272 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  276 */       return false;
/*      */     }
/*      */ 
/*  279 */     if (!this.mflag)
/*      */       try {
/*  281 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  285 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  290 */     PreparedStatement pstmt = null;
/*      */ 
/*  292 */     if (!this.mflag) {
/*  293 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  298 */       pstmt = this.con.prepareStatement("INSERT INTO LNPDutyPay VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  299 */       if ((getPayPlanCode() == null) || (getPayPlanCode().equals("null")))
/*  300 */         pstmt.setNull(1, 12);
/*      */       else {
/*  302 */         pstmt.setString(1, getPayPlanCode());
/*      */       }
/*  304 */       if ((getPayPlanName() == null) || (getPayPlanName().equals("null")))
/*  305 */         pstmt.setNull(2, 12);
/*      */       else {
/*  307 */         pstmt.setString(2, getPayPlanName());
/*      */       }
/*  309 */       if ((getType() == null) || (getType().equals("null")))
/*  310 */         pstmt.setNull(3, 12);
/*      */       else {
/*  312 */         pstmt.setString(3, getType());
/*      */       }
/*  314 */       pstmt.setInt(4, getPayIntv());
/*  315 */       if ((getPayEndYearFlag() == null) || (getPayEndYearFlag().equals("null")))
/*  316 */         pstmt.setNull(5, 12);
/*      */       else {
/*  318 */         pstmt.setString(5, getPayEndYearFlag());
/*      */       }
/*  320 */       pstmt.setInt(6, getPayEndYear());
/*  321 */       if ((getPayEndDateCalRef() == null) || (getPayEndDateCalRef().equals("null")))
/*  322 */         pstmt.setNull(7, 12);
/*      */       else {
/*  324 */         pstmt.setString(7, getPayEndDateCalRef());
/*      */       }
/*  326 */       if ((getPayEndDateCalMode() == null) || (getPayEndDateCalMode().equals("null")))
/*  327 */         pstmt.setNull(8, 12);
/*      */       else {
/*  329 */         pstmt.setString(8, getPayEndDateCalMode());
/*      */       }
/*  331 */       pstmt.setDouble(9, getDefaultVal());
/*  332 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/*  333 */         pstmt.setNull(10, 12);
/*      */       else {
/*  335 */         pstmt.setString(10, getCalCode());
/*      */       }
/*  337 */       if ((getCnterCalCode() == null) || (getCnterCalCode().equals("null")))
/*  338 */         pstmt.setNull(11, 12);
/*      */       else {
/*  340 */         pstmt.setString(11, getCnterCalCode());
/*      */       }
/*  342 */       if ((getOthCalCode() == null) || (getOthCalCode().equals("null")))
/*  343 */         pstmt.setNull(12, 12);
/*      */       else {
/*  345 */         pstmt.setString(12, getOthCalCode());
/*      */       }
/*  347 */       pstmt.setDouble(13, getRate());
/*  348 */       pstmt.setDouble(14, getMinPay());
/*  349 */       pstmt.setDouble(15, getAssuYield());
/*  350 */       pstmt.setDouble(16, getFeeRate());
/*  351 */       if ((getPayToDateCalMode() == null) || (getPayToDateCalMode().equals("null")))
/*  352 */         pstmt.setNull(17, 12);
/*      */       else {
/*  354 */         pstmt.setString(17, getPayToDateCalMode());
/*      */       }
/*  356 */       if ((getUrgePayFlag() == null) || (getUrgePayFlag().equals("null")))
/*  357 */         pstmt.setNull(18, 12);
/*      */       else {
/*  359 */         pstmt.setString(18, getUrgePayFlag());
/*      */       }
/*  361 */       if ((getPayLackFlag() == null) || (getPayLackFlag().equals("null")))
/*  362 */         pstmt.setNull(19, 12);
/*      */       else {
/*  364 */         pstmt.setString(19, getPayLackFlag());
/*      */       }
/*  366 */       if ((getPayOverFlag() == null) || (getPayOverFlag().equals("null")))
/*  367 */         pstmt.setNull(20, 12);
/*      */       else {
/*  369 */         pstmt.setString(20, getPayOverFlag());
/*      */       }
/*  371 */       if ((getPayOverDeal() == null) || (getPayOverDeal().equals("null")))
/*  372 */         pstmt.setNull(21, 12);
/*      */       else {
/*  374 */         pstmt.setString(21, getPayOverDeal());
/*      */       }
/*  376 */       if ((getAvoidPayFlag() == null) || (getAvoidPayFlag().equals("null")))
/*  377 */         pstmt.setNull(22, 12);
/*      */       else {
/*  379 */         pstmt.setString(22, getAvoidPayFlag());
/*      */       }
/*  381 */       pstmt.setInt(23, getGracePeriod());
/*  382 */       if ((getPubFlag() == null) || (getPubFlag().equals("null")))
/*  383 */         pstmt.setNull(24, 12);
/*      */       else {
/*  385 */         pstmt.setString(24, getPubFlag());
/*      */       }
/*  387 */       if ((getZeroFlag() == null) || (getZeroFlag().equals("null")))
/*  388 */         pstmt.setNull(25, 12);
/*      */       else {
/*  390 */         pstmt.setString(25, getZeroFlag());
/*      */       }
/*  392 */       if ((getNeedAcc() == null) || (getNeedAcc().equals("null")))
/*  393 */         pstmt.setNull(26, 12);
/*      */       else {
/*  395 */         pstmt.setString(26, getNeedAcc());
/*      */       }
/*  397 */       if ((getPayAimClass() == null) || (getPayAimClass().equals("null")))
/*  398 */         pstmt.setNull(27, 12);
/*      */       else {
/*  400 */         pstmt.setString(27, getPayAimClass());
/*      */       }
/*      */ 
/*  403 */       pstmt.executeUpdate();
/*  404 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  407 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  408 */       CError tError = new CError();
/*  409 */       tError.moduleName = "LNPDutyPayDB";
/*  410 */       tError.functionName = "insert()";
/*  411 */       tError.errorMessage = ex.toString();
/*  412 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  415 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  418 */       if (!this.mflag)
/*      */         try {
/*  420 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  424 */       return false;
/*      */     }
/*      */ 
/*  427 */     if (!this.mflag)
/*      */       try {
/*  429 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  433 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  438 */     PreparedStatement pstmt = null;
/*  439 */     ResultSet rs = null;
/*      */ 
/*  441 */     if (!this.mflag) {
/*  442 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  447 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPDutyPay WHERE  PayPlanCode = ?", 
/*  448 */         1003, 1007);
/*  449 */       if ((getPayPlanCode() == null) || (getPayPlanCode().equals("null")))
/*  450 */         pstmt.setNull(1, 12);
/*      */       else {
/*  452 */         pstmt.setString(1, getPayPlanCode());
/*      */       }
/*  454 */       rs = pstmt.executeQuery();
/*  455 */       int i = 0;
/*  456 */       if (rs.next())
/*      */       {
/*  458 */         i++;
/*  459 */         if (!setSchema(rs, i))
/*      */         {
/*  462 */           CError tError = new CError();
/*  463 */           tError.moduleName = "LNPDutyPayDB";
/*  464 */           tError.functionName = "getInfo";
/*  465 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  466 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  468 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  471 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  475 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  479 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  483 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  486 */       if (i == 0)
/*      */       {
/*  488 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  492 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  496 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  502 */       CError tError = new CError();
/*  503 */       tError.moduleName = "LNPDutyPayDB";
/*  504 */       tError.functionName = "getInfo";
/*  505 */       tError.errorMessage = e.toString();
/*  506 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  508 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  511 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  515 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  519 */       return false;
/*      */     }
/*      */ 
/*  522 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  526 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  531 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPDutyPaySet query()
/*      */   {
/*  536 */     Statement stmt = null;
/*  537 */     ResultSet rs = null;
/*  538 */     LNPDutyPaySet aLNPDutyPaySet = new LNPDutyPaySet();
/*      */ 
/*  540 */     if (!this.mflag) {
/*  541 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  546 */       stmt = this.con.createStatement(1003, 1007);
/*  547 */       SQLString sqlObj = new SQLString("LNPDutyPay");
/*  548 */       LNPDutyPaySchema aSchema = getSchema();
/*  549 */       sqlObj.setSQL(5, aSchema);
/*  550 */       String sql = sqlObj.getSQL();
/*      */ 
/*  552 */       rs = stmt.executeQuery(sql);
/*  553 */       int i = 0;
/*  554 */       while (rs.next())
/*      */       {
/*  556 */         i++;
/*  557 */         LNPDutyPaySchema s1 = new LNPDutyPaySchema();
/*  558 */         s1.setSchema(rs, i);
/*  559 */         aLNPDutyPaySet.add(s1);
/*      */       }try {
/*  561 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  567 */       CError tError = new CError();
/*  568 */       tError.moduleName = "LNPDutyPayDB";
/*  569 */       tError.functionName = "query";
/*  570 */       tError.errorMessage = e.toString();
/*  571 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  573 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  576 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  580 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  586 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  590 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  595 */     return aLNPDutyPaySet;
/*      */   }
/*      */ 
/*      */   public LNPDutyPaySet executeQuery(String sql)
/*      */   {
/*  600 */     Statement stmt = null;
/*  601 */     ResultSet rs = null;
/*  602 */     LNPDutyPaySet aLNPDutyPaySet = new LNPDutyPaySet();
/*      */ 
/*  604 */     if (!this.mflag) {
/*  605 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  610 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  612 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  613 */       int i = 0;
/*  614 */       while (rs.next())
/*      */       {
/*  616 */         i++;
/*  617 */         LNPDutyPaySchema s1 = new LNPDutyPaySchema();
/*  618 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  621 */           CError tError = new CError();
/*  622 */           tError.moduleName = "LNPDutyPayDB";
/*  623 */           tError.functionName = "executeQuery";
/*  624 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  625 */           this.mErrors.addOneError(tError);
/*      */         }
/*  627 */         aLNPDutyPaySet.add(s1);
/*      */       }try {
/*  629 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  635 */       CError tError = new CError();
/*  636 */       tError.moduleName = "LNPDutyPayDB";
/*  637 */       tError.functionName = "executeQuery";
/*  638 */       tError.errorMessage = e.toString();
/*  639 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  641 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  644 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  648 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  654 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  658 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  663 */     return aLNPDutyPaySet;
/*      */   }
/*      */ 
/*      */   public LNPDutyPaySet query(int nStart, int nCount)
/*      */   {
/*  668 */     Statement stmt = null;
/*  669 */     ResultSet rs = null;
/*  670 */     LNPDutyPaySet aLNPDutyPaySet = new LNPDutyPaySet();
/*      */ 
/*  672 */     if (!this.mflag) {
/*  673 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  678 */       stmt = this.con.createStatement(1003, 1007);
/*  679 */       SQLString sqlObj = new SQLString("LNPDutyPay");
/*  680 */       LNPDutyPaySchema aSchema = getSchema();
/*  681 */       sqlObj.setSQL(5, aSchema);
/*  682 */       String sql = sqlObj.getSQL();
/*      */ 
/*  684 */       rs = stmt.executeQuery(sql);
/*  685 */       int i = 0;
/*  686 */       while (rs.next())
/*      */       {
/*  688 */         i++;
/*      */ 
/*  690 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  694 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  698 */         LNPDutyPaySchema s1 = new LNPDutyPaySchema();
/*  699 */         s1.setSchema(rs, i);
/*  700 */         aLNPDutyPaySet.add(s1);
/*      */       }try {
/*  702 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  708 */       CError tError = new CError();
/*  709 */       tError.moduleName = "LNPDutyPayDB";
/*  710 */       tError.functionName = "query";
/*  711 */       tError.errorMessage = e.toString();
/*  712 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  714 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  717 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  721 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  727 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  731 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  736 */     return aLNPDutyPaySet;
/*      */   }
/*      */ 
/*      */   public LNPDutyPaySet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  741 */     Statement stmt = null;
/*  742 */     ResultSet rs = null;
/*  743 */     LNPDutyPaySet aLNPDutyPaySet = new LNPDutyPaySet();
/*      */ 
/*  745 */     if (!this.mflag) {
/*  746 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  751 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  753 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  754 */       int i = 0;
/*  755 */       while (rs.next())
/*      */       {
/*  757 */         i++;
/*      */ 
/*  759 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  763 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  767 */         LNPDutyPaySchema s1 = new LNPDutyPaySchema();
/*  768 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  771 */           CError tError = new CError();
/*  772 */           tError.moduleName = "LNPDutyPayDB";
/*  773 */           tError.functionName = "executeQuery";
/*  774 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  775 */           this.mErrors.addOneError(tError);
/*      */         }
/*  777 */         aLNPDutyPaySet.add(s1);
/*      */       }try {
/*  779 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  785 */       CError tError = new CError();
/*  786 */       tError.moduleName = "LNPDutyPayDB";
/*  787 */       tError.functionName = "executeQuery";
/*  788 */       tError.errorMessage = e.toString();
/*  789 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  791 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  794 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  798 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  804 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  808 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  813 */     return aLNPDutyPaySet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  818 */     Statement stmt = null;
/*      */ 
/*  820 */     if (!this.mflag) {
/*  821 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  826 */       stmt = this.con.createStatement(1003, 1007);
/*  827 */       SQLString sqlObj = new SQLString("LNPDutyPay");
/*  828 */       LNPDutyPaySchema aSchema = getSchema();
/*  829 */       sqlObj.setSQL(2, aSchema);
/*  830 */       String sql = "update LNPDutyPay " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  832 */       int operCount = stmt.executeUpdate(sql);
/*  833 */       if (operCount == 0)
/*      */       {
/*  836 */         CError tError = new CError();
/*  837 */         tError.moduleName = "LNPDutyPayDB";
/*  838 */         tError.functionName = "update";
/*  839 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  840 */         this.mErrors.addOneError(tError);
/*      */ 
/*  842 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  846 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  850 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  856 */       CError tError = new CError();
/*  857 */       tError.moduleName = "LNPDutyPayDB";
/*  858 */       tError.functionName = "update";
/*  859 */       tError.errorMessage = e.toString();
/*  860 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  862 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  864 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  868 */           this.con.close();
/*      */         } catch (Exception localException3) {
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
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  890 */     if (this.mResultSet != null)
/*      */     {
/*  893 */       CError tError = new CError();
/*  894 */       tError.moduleName = "LNPDutyPayDB";
/*  895 */       tError.functionName = "prepareData";
/*  896 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  897 */       this.mErrors.addOneError(tError);
/*  898 */       return false;
/*      */     }
/*      */ 
/*  901 */     if (!this.mflag)
/*      */     {
/*  903 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  907 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  908 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  913 */       CError tError = new CError();
/*  914 */       tError.moduleName = "LNPDutyPayDB";
/*  915 */       tError.functionName = "prepareData";
/*  916 */       tError.errorMessage = e.toString();
/*  917 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  920 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  926 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  930 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  934 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  939 */       return false;
/*      */     }
/*      */ 
/*  942 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  946 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  951 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  957 */     boolean flag = true;
/*  958 */     if (this.mResultSet == null)
/*      */     {
/*  960 */       CError tError = new CError();
/*  961 */       tError.moduleName = "LNPDutyPayDB";
/*  962 */       tError.functionName = "hasMoreData";
/*  963 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  964 */       this.mErrors.addOneError(tError);
/*  965 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  969 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  973 */       CError tError = new CError();
/*  974 */       tError.moduleName = "LNPDutyPayDB";
/*  975 */       tError.functionName = "hasMoreData";
/*  976 */       tError.errorMessage = ex.toString();
/*  977 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  980 */         this.mResultSet.close();
/*  981 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  987 */         this.mStatement.close();
/*  988 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  992 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  996 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1001 */       return false;
/*      */     }
/* 1003 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPDutyPaySet getData()
/*      */   {
/* 1008 */     int tCount = 0;
/* 1009 */     LNPDutyPaySet tLNPDutyPaySet = new LNPDutyPaySet();
/* 1010 */     LNPDutyPaySchema tLNPDutyPaySchema = null;
/* 1011 */     if (this.mResultSet == null)
/*      */     {
/* 1013 */       CError tError = new CError();
/* 1014 */       tError.moduleName = "LNPDutyPayDB";
/* 1015 */       tError.functionName = "getData";
/* 1016 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1017 */       this.mErrors.addOneError(tError);
/* 1018 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1022 */       tCount = 1;
/* 1023 */       tLNPDutyPaySchema = new LNPDutyPaySchema();
/* 1024 */       tLNPDutyPaySchema.setSchema(this.mResultSet, 1);
/* 1025 */       tLNPDutyPaySet.add(tLNPDutyPaySchema);
/*      */ 
/* 1027 */       while (tCount++ < 5000)
/*      */       {
/* 1029 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1031 */         tLNPDutyPaySchema = new LNPDutyPaySchema();
/* 1032 */         tLNPDutyPaySchema.setSchema(this.mResultSet, 1);
/* 1033 */         tLNPDutyPaySet.add(tLNPDutyPaySchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1039 */       CError tError = new CError();
/* 1040 */       tError.moduleName = "LNPDutyPayDB";
/* 1041 */       tError.functionName = "getData";
/* 1042 */       tError.errorMessage = ex.toString();
/* 1043 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1046 */         this.mResultSet.close();
/* 1047 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1053 */         this.mStatement.close();
/* 1054 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1058 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1062 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1067 */       return null;
/*      */     }
/* 1069 */     return tLNPDutyPaySet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1074 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1077 */       if (this.mResultSet == null)
/*      */       {
/* 1079 */         CError tError = new CError();
/* 1080 */         tError.moduleName = "LNPDutyPayDB";
/* 1081 */         tError.functionName = "closeData";
/* 1082 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1083 */         this.mErrors.addOneError(tError);
/* 1084 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1088 */         this.mResultSet.close();
/* 1089 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1094 */       CError tError = new CError();
/* 1095 */       tError.moduleName = "LNPDutyPayDB";
/* 1096 */       tError.functionName = "closeData";
/* 1097 */       tError.errorMessage = ex2.toString();
/* 1098 */       this.mErrors.addOneError(tError);
/* 1099 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1103 */       if (this.mStatement == null)
/*      */       {
/* 1105 */         CError tError = new CError();
/* 1106 */         tError.moduleName = "LNPDutyPayDB";
/* 1107 */         tError.functionName = "closeData";
/* 1108 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1109 */         this.mErrors.addOneError(tError);
/* 1110 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1114 */         this.mStatement.close();
/* 1115 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1120 */       CError tError = new CError();
/* 1121 */       tError.moduleName = "LNPDutyPayDB";
/* 1122 */       tError.functionName = "closeData";
/* 1123 */       tError.errorMessage = ex3.toString();
/* 1124 */       this.mErrors.addOneError(tError);
/* 1125 */       flag = false;
/*      */     }
/* 1127 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPDutyPayDB
 * JD-Core Version:    0.6.0
 */