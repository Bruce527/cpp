/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPDutySchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPDutySet;
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
/*      */ public class LNPDutyDB extends LNPDutySchema
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
/*      */   public LNPDutyDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPDuty");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPDutyDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPDuty");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPDutySchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPDutyDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPDutySchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPDutyDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPDuty WHERE  DutyCode = ?");
/*   97 */       if ((getDutyCode() == null) || (getDutyCode().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getDutyCode());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPDutyDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPDuty SET  DutyCode = ? , DutyName = ? , PayEndYear = ? , PayEndYearFlag = ? , PayEndDateCalRef = ? , PayEndDateCalMode = ? , GetYear = ? , GetYearFlag = ? , InsuYear = ? , InsuYearFlag = ? , AcciYear = ? , AcciYearFlag = ? , CalMode = ? , PayEndYearRela = ? , GetYearRela = ? , InsuYearRela = ? , BasicCalCode = ? , RiskCalCode = ? , AmntFlag = ? , VPU = ? , AddFeeFlag = ? , EndDateCalMode = ? WHERE  DutyCode = ?");
/*  146 */       if ((getDutyCode() == null) || (getDutyCode().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getDutyCode());
/*      */       }
/*  151 */       if ((getDutyName() == null) || (getDutyName().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getDutyName());
/*      */       }
/*  156 */       pstmt.setInt(3, getPayEndYear());
/*  157 */       if ((getPayEndYearFlag() == null) || (getPayEndYearFlag().equals("null")))
/*  158 */         pstmt.setNull(4, 12);
/*      */       else {
/*  160 */         pstmt.setString(4, getPayEndYearFlag());
/*      */       }
/*  162 */       if ((getPayEndDateCalRef() == null) || (getPayEndDateCalRef().equals("null")))
/*  163 */         pstmt.setNull(5, 12);
/*      */       else {
/*  165 */         pstmt.setString(5, getPayEndDateCalRef());
/*      */       }
/*  167 */       if ((getPayEndDateCalMode() == null) || (getPayEndDateCalMode().equals("null")))
/*  168 */         pstmt.setNull(6, 12);
/*      */       else {
/*  170 */         pstmt.setString(6, getPayEndDateCalMode());
/*      */       }
/*  172 */       pstmt.setInt(7, getGetYear());
/*  173 */       if ((getGetYearFlag() == null) || (getGetYearFlag().equals("null")))
/*  174 */         pstmt.setNull(8, 12);
/*      */       else {
/*  176 */         pstmt.setString(8, getGetYearFlag());
/*      */       }
/*  178 */       pstmt.setInt(9, getInsuYear());
/*  179 */       if ((getInsuYearFlag() == null) || (getInsuYearFlag().equals("null")))
/*  180 */         pstmt.setNull(10, 12);
/*      */       else {
/*  182 */         pstmt.setString(10, getInsuYearFlag());
/*      */       }
/*  184 */       pstmt.setInt(11, getAcciYear());
/*  185 */       if ((getAcciYearFlag() == null) || (getAcciYearFlag().equals("null")))
/*  186 */         pstmt.setNull(12, 12);
/*      */       else {
/*  188 */         pstmt.setString(12, getAcciYearFlag());
/*      */       }
/*  190 */       if ((getCalMode() == null) || (getCalMode().equals("null")))
/*  191 */         pstmt.setNull(13, 12);
/*      */       else {
/*  193 */         pstmt.setString(13, getCalMode());
/*      */       }
/*  195 */       if ((getPayEndYearRela() == null) || (getPayEndYearRela().equals("null")))
/*  196 */         pstmt.setNull(14, 12);
/*      */       else {
/*  198 */         pstmt.setString(14, getPayEndYearRela());
/*      */       }
/*  200 */       if ((getGetYearRela() == null) || (getGetYearRela().equals("null")))
/*  201 */         pstmt.setNull(15, 12);
/*      */       else {
/*  203 */         pstmt.setString(15, getGetYearRela());
/*      */       }
/*  205 */       if ((getInsuYearRela() == null) || (getInsuYearRela().equals("null")))
/*  206 */         pstmt.setNull(16, 12);
/*      */       else {
/*  208 */         pstmt.setString(16, getInsuYearRela());
/*      */       }
/*  210 */       if ((getBasicCalCode() == null) || (getBasicCalCode().equals("null")))
/*  211 */         pstmt.setNull(17, 12);
/*      */       else {
/*  213 */         pstmt.setString(17, getBasicCalCode());
/*      */       }
/*  215 */       if ((getRiskCalCode() == null) || (getRiskCalCode().equals("null")))
/*  216 */         pstmt.setNull(18, 12);
/*      */       else {
/*  218 */         pstmt.setString(18, getRiskCalCode());
/*      */       }
/*  220 */       if ((getAmntFlag() == null) || (getAmntFlag().equals("null")))
/*  221 */         pstmt.setNull(19, 12);
/*      */       else {
/*  223 */         pstmt.setString(19, getAmntFlag());
/*      */       }
/*  225 */       pstmt.setDouble(20, getVPU());
/*  226 */       if ((getAddFeeFlag() == null) || (getAddFeeFlag().equals("null")))
/*  227 */         pstmt.setNull(21, 12);
/*      */       else {
/*  229 */         pstmt.setString(21, getAddFeeFlag());
/*      */       }
/*  231 */       if ((getEndDateCalMode() == null) || (getEndDateCalMode().equals("null")))
/*  232 */         pstmt.setNull(22, 12);
/*      */       else {
/*  234 */         pstmt.setString(22, getEndDateCalMode());
/*      */       }
/*      */ 
/*  237 */       if ((getDutyCode() == null) || (getDutyCode().equals("null")))
/*  238 */         pstmt.setNull(23, 12);
/*      */       else {
/*  240 */         pstmt.setString(23, getDutyCode());
/*      */       }
/*  242 */       pstmt.executeUpdate();
/*  243 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  246 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  247 */       CError tError = new CError();
/*  248 */       tError.moduleName = "LNPDutyDB";
/*  249 */       tError.functionName = "update()";
/*  250 */       tError.errorMessage = ex.toString();
/*  251 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  254 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  257 */       if (!this.mflag)
/*      */         try {
/*  259 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  263 */       return false;
/*      */     }
/*      */ 
/*  266 */     if (!this.mflag)
/*      */       try {
/*  268 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  272 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  277 */     PreparedStatement pstmt = null;
/*      */ 
/*  279 */     if (!this.mflag) {
/*  280 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  285 */       pstmt = this.con.prepareStatement("INSERT INTO LNPDuty VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  286 */       if ((getDutyCode() == null) || (getDutyCode().equals("null")))
/*  287 */         pstmt.setNull(1, 12);
/*      */       else {
/*  289 */         pstmt.setString(1, getDutyCode());
/*      */       }
/*  291 */       if ((getDutyName() == null) || (getDutyName().equals("null")))
/*  292 */         pstmt.setNull(2, 12);
/*      */       else {
/*  294 */         pstmt.setString(2, getDutyName());
/*      */       }
/*  296 */       pstmt.setInt(3, getPayEndYear());
/*  297 */       if ((getPayEndYearFlag() == null) || (getPayEndYearFlag().equals("null")))
/*  298 */         pstmt.setNull(4, 12);
/*      */       else {
/*  300 */         pstmt.setString(4, getPayEndYearFlag());
/*      */       }
/*  302 */       if ((getPayEndDateCalRef() == null) || (getPayEndDateCalRef().equals("null")))
/*  303 */         pstmt.setNull(5, 12);
/*      */       else {
/*  305 */         pstmt.setString(5, getPayEndDateCalRef());
/*      */       }
/*  307 */       if ((getPayEndDateCalMode() == null) || (getPayEndDateCalMode().equals("null")))
/*  308 */         pstmt.setNull(6, 12);
/*      */       else {
/*  310 */         pstmt.setString(6, getPayEndDateCalMode());
/*      */       }
/*  312 */       pstmt.setInt(7, getGetYear());
/*  313 */       if ((getGetYearFlag() == null) || (getGetYearFlag().equals("null")))
/*  314 */         pstmt.setNull(8, 12);
/*      */       else {
/*  316 */         pstmt.setString(8, getGetYearFlag());
/*      */       }
/*  318 */       pstmt.setInt(9, getInsuYear());
/*  319 */       if ((getInsuYearFlag() == null) || (getInsuYearFlag().equals("null")))
/*  320 */         pstmt.setNull(10, 12);
/*      */       else {
/*  322 */         pstmt.setString(10, getInsuYearFlag());
/*      */       }
/*  324 */       pstmt.setInt(11, getAcciYear());
/*  325 */       if ((getAcciYearFlag() == null) || (getAcciYearFlag().equals("null")))
/*  326 */         pstmt.setNull(12, 12);
/*      */       else {
/*  328 */         pstmt.setString(12, getAcciYearFlag());
/*      */       }
/*  330 */       if ((getCalMode() == null) || (getCalMode().equals("null")))
/*  331 */         pstmt.setNull(13, 12);
/*      */       else {
/*  333 */         pstmt.setString(13, getCalMode());
/*      */       }
/*  335 */       if ((getPayEndYearRela() == null) || (getPayEndYearRela().equals("null")))
/*  336 */         pstmt.setNull(14, 12);
/*      */       else {
/*  338 */         pstmt.setString(14, getPayEndYearRela());
/*      */       }
/*  340 */       if ((getGetYearRela() == null) || (getGetYearRela().equals("null")))
/*  341 */         pstmt.setNull(15, 12);
/*      */       else {
/*  343 */         pstmt.setString(15, getGetYearRela());
/*      */       }
/*  345 */       if ((getInsuYearRela() == null) || (getInsuYearRela().equals("null")))
/*  346 */         pstmt.setNull(16, 12);
/*      */       else {
/*  348 */         pstmt.setString(16, getInsuYearRela());
/*      */       }
/*  350 */       if ((getBasicCalCode() == null) || (getBasicCalCode().equals("null")))
/*  351 */         pstmt.setNull(17, 12);
/*      */       else {
/*  353 */         pstmt.setString(17, getBasicCalCode());
/*      */       }
/*  355 */       if ((getRiskCalCode() == null) || (getRiskCalCode().equals("null")))
/*  356 */         pstmt.setNull(18, 12);
/*      */       else {
/*  358 */         pstmt.setString(18, getRiskCalCode());
/*      */       }
/*  360 */       if ((getAmntFlag() == null) || (getAmntFlag().equals("null")))
/*  361 */         pstmt.setNull(19, 12);
/*      */       else {
/*  363 */         pstmt.setString(19, getAmntFlag());
/*      */       }
/*  365 */       pstmt.setDouble(20, getVPU());
/*  366 */       if ((getAddFeeFlag() == null) || (getAddFeeFlag().equals("null")))
/*  367 */         pstmt.setNull(21, 12);
/*      */       else {
/*  369 */         pstmt.setString(21, getAddFeeFlag());
/*      */       }
/*  371 */       if ((getEndDateCalMode() == null) || (getEndDateCalMode().equals("null")))
/*  372 */         pstmt.setNull(22, 12);
/*      */       else {
/*  374 */         pstmt.setString(22, getEndDateCalMode());
/*      */       }
/*      */ 
/*  377 */       pstmt.executeUpdate();
/*  378 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  381 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  382 */       CError tError = new CError();
/*  383 */       tError.moduleName = "LNPDutyDB";
/*  384 */       tError.functionName = "insert()";
/*  385 */       tError.errorMessage = ex.toString();
/*  386 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  389 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  392 */       if (!this.mflag)
/*      */         try {
/*  394 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  398 */       return false;
/*      */     }
/*      */ 
/*  401 */     if (!this.mflag)
/*      */       try {
/*  403 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  407 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  412 */     PreparedStatement pstmt = null;
/*  413 */     ResultSet rs = null;
/*      */ 
/*  415 */     if (!this.mflag) {
/*  416 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  421 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPDuty WHERE  DutyCode = ?", 
/*  422 */         1003, 1007);
/*  423 */       if ((getDutyCode() == null) || (getDutyCode().equals("null")))
/*  424 */         pstmt.setNull(1, 12);
/*      */       else {
/*  426 */         pstmt.setString(1, getDutyCode());
/*      */       }
/*  428 */       rs = pstmt.executeQuery();
/*  429 */       int i = 0;
/*  430 */       if (rs.next())
/*      */       {
/*  432 */         i++;
/*  433 */         if (!setSchema(rs, i))
/*      */         {
/*  436 */           CError tError = new CError();
/*  437 */           tError.moduleName = "LNPDutyDB";
/*  438 */           tError.functionName = "getInfo";
/*  439 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  440 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  442 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  445 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  449 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  453 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  457 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  460 */       if (i == 0)
/*      */       {
/*  462 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  466 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  470 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  476 */       CError tError = new CError();
/*  477 */       tError.moduleName = "LNPDutyDB";
/*  478 */       tError.functionName = "getInfo";
/*  479 */       tError.errorMessage = e.toString();
/*  480 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  482 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  485 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  489 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  493 */       return false;
/*      */     }
/*      */ 
/*  496 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  500 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  505 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPDutySet query()
/*      */   {
/*  510 */     Statement stmt = null;
/*  511 */     ResultSet rs = null;
/*  512 */     LNPDutySet aLNPDutySet = new LNPDutySet();
/*      */ 
/*  514 */     if (!this.mflag) {
/*  515 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  520 */       stmt = this.con.createStatement(1003, 1007);
/*  521 */       SQLString sqlObj = new SQLString("LNPDuty");
/*  522 */       LNPDutySchema aSchema = getSchema();
/*  523 */       sqlObj.setSQL(5, aSchema);
/*  524 */       String sql = sqlObj.getSQL();
/*      */ 
/*  526 */       rs = stmt.executeQuery(sql);
/*  527 */       int i = 0;
/*  528 */       while (rs.next())
/*      */       {
/*  530 */         i++;
/*  531 */         LNPDutySchema s1 = new LNPDutySchema();
/*  532 */         s1.setSchema(rs, i);
/*  533 */         aLNPDutySet.add(s1);
/*      */       }try {
/*  535 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  541 */       CError tError = new CError();
/*  542 */       tError.moduleName = "LNPDutyDB";
/*  543 */       tError.functionName = "query";
/*  544 */       tError.errorMessage = e.toString();
/*  545 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  547 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  550 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  554 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  560 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  564 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  569 */     return aLNPDutySet;
/*      */   }
/*      */ 
/*      */   public LNPDutySet executeQuery(String sql)
/*      */   {
/*  574 */     Statement stmt = null;
/*  575 */     ResultSet rs = null;
/*  576 */     LNPDutySet aLNPDutySet = new LNPDutySet();
/*      */ 
/*  578 */     if (!this.mflag) {
/*  579 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  584 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  586 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  587 */       int i = 0;
/*  588 */       while (rs.next())
/*      */       {
/*  590 */         i++;
/*  591 */         LNPDutySchema s1 = new LNPDutySchema();
/*  592 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  595 */           CError tError = new CError();
/*  596 */           tError.moduleName = "LNPDutyDB";
/*  597 */           tError.functionName = "executeQuery";
/*  598 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  599 */           this.mErrors.addOneError(tError);
/*      */         }
/*  601 */         aLNPDutySet.add(s1);
/*      */       }try {
/*  603 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  609 */       CError tError = new CError();
/*  610 */       tError.moduleName = "LNPDutyDB";
/*  611 */       tError.functionName = "executeQuery";
/*  612 */       tError.errorMessage = e.toString();
/*  613 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  615 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  618 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  622 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  628 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  632 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  637 */     return aLNPDutySet;
/*      */   }
/*      */ 
/*      */   public LNPDutySet query(int nStart, int nCount)
/*      */   {
/*  642 */     Statement stmt = null;
/*  643 */     ResultSet rs = null;
/*  644 */     LNPDutySet aLNPDutySet = new LNPDutySet();
/*      */ 
/*  646 */     if (!this.mflag) {
/*  647 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  652 */       stmt = this.con.createStatement(1003, 1007);
/*  653 */       SQLString sqlObj = new SQLString("LNPDuty");
/*  654 */       LNPDutySchema aSchema = getSchema();
/*  655 */       sqlObj.setSQL(5, aSchema);
/*  656 */       String sql = sqlObj.getSQL();
/*      */ 
/*  658 */       rs = stmt.executeQuery(sql);
/*  659 */       int i = 0;
/*  660 */       while (rs.next())
/*      */       {
/*  662 */         i++;
/*      */ 
/*  664 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  668 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  672 */         LNPDutySchema s1 = new LNPDutySchema();
/*  673 */         s1.setSchema(rs, i);
/*  674 */         aLNPDutySet.add(s1);
/*      */       }try {
/*  676 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  682 */       CError tError = new CError();
/*  683 */       tError.moduleName = "LNPDutyDB";
/*  684 */       tError.functionName = "query";
/*  685 */       tError.errorMessage = e.toString();
/*  686 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  688 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  691 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  695 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  701 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  705 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  710 */     return aLNPDutySet;
/*      */   }
/*      */ 
/*      */   public LNPDutySet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  715 */     Statement stmt = null;
/*  716 */     ResultSet rs = null;
/*  717 */     LNPDutySet aLNPDutySet = new LNPDutySet();
/*      */ 
/*  719 */     if (!this.mflag) {
/*  720 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  725 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  727 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  728 */       int i = 0;
/*  729 */       while (rs.next())
/*      */       {
/*  731 */         i++;
/*      */ 
/*  733 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  737 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  741 */         LNPDutySchema s1 = new LNPDutySchema();
/*  742 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  745 */           CError tError = new CError();
/*  746 */           tError.moduleName = "LNPDutyDB";
/*  747 */           tError.functionName = "executeQuery";
/*  748 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  749 */           this.mErrors.addOneError(tError);
/*      */         }
/*  751 */         aLNPDutySet.add(s1);
/*      */       }try {
/*  753 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  759 */       CError tError = new CError();
/*  760 */       tError.moduleName = "LNPDutyDB";
/*  761 */       tError.functionName = "executeQuery";
/*  762 */       tError.errorMessage = e.toString();
/*  763 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  765 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  768 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  772 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  778 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  782 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  787 */     return aLNPDutySet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  792 */     Statement stmt = null;
/*      */ 
/*  794 */     if (!this.mflag) {
/*  795 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  800 */       stmt = this.con.createStatement(1003, 1007);
/*  801 */       SQLString sqlObj = new SQLString("LNPDuty");
/*  802 */       LNPDutySchema aSchema = getSchema();
/*  803 */       sqlObj.setSQL(2, aSchema);
/*  804 */       String sql = "update LNPDuty " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  806 */       int operCount = stmt.executeUpdate(sql);
/*  807 */       if (operCount == 0)
/*      */       {
/*  810 */         CError tError = new CError();
/*  811 */         tError.moduleName = "LNPDutyDB";
/*  812 */         tError.functionName = "update";
/*  813 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  814 */         this.mErrors.addOneError(tError);
/*      */ 
/*  816 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  820 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  824 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  830 */       CError tError = new CError();
/*  831 */       tError.moduleName = "LNPDutyDB";
/*  832 */       tError.functionName = "update";
/*  833 */       tError.errorMessage = e.toString();
/*  834 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  836 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  838 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  842 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  846 */       return false;
/*      */     }
/*      */ 
/*  849 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  853 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  858 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  864 */     if (this.mResultSet != null)
/*      */     {
/*  867 */       CError tError = new CError();
/*  868 */       tError.moduleName = "LNPDutyDB";
/*  869 */       tError.functionName = "prepareData";
/*  870 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  871 */       this.mErrors.addOneError(tError);
/*  872 */       return false;
/*      */     }
/*      */ 
/*  875 */     if (!this.mflag)
/*      */     {
/*  877 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  881 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  882 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  887 */       CError tError = new CError();
/*  888 */       tError.moduleName = "LNPDutyDB";
/*  889 */       tError.functionName = "prepareData";
/*  890 */       tError.errorMessage = e.toString();
/*  891 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  894 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  900 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  904 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  908 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  913 */       return false;
/*      */     }
/*      */ 
/*  916 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  920 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  925 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  931 */     boolean flag = true;
/*  932 */     if (this.mResultSet == null)
/*      */     {
/*  934 */       CError tError = new CError();
/*  935 */       tError.moduleName = "LNPDutyDB";
/*  936 */       tError.functionName = "hasMoreData";
/*  937 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  938 */       this.mErrors.addOneError(tError);
/*  939 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  943 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  947 */       CError tError = new CError();
/*  948 */       tError.moduleName = "LNPDutyDB";
/*  949 */       tError.functionName = "hasMoreData";
/*  950 */       tError.errorMessage = ex.toString();
/*  951 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  954 */         this.mResultSet.close();
/*  955 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  961 */         this.mStatement.close();
/*  962 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  966 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  970 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  975 */       return false;
/*      */     }
/*  977 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPDutySet getData()
/*      */   {
/*  982 */     int tCount = 0;
/*  983 */     LNPDutySet tLNPDutySet = new LNPDutySet();
/*  984 */     LNPDutySchema tLNPDutySchema = null;
/*  985 */     if (this.mResultSet == null)
/*      */     {
/*  987 */       CError tError = new CError();
/*  988 */       tError.moduleName = "LNPDutyDB";
/*  989 */       tError.functionName = "getData";
/*  990 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  991 */       this.mErrors.addOneError(tError);
/*  992 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  996 */       tCount = 1;
/*  997 */       tLNPDutySchema = new LNPDutySchema();
/*  998 */       tLNPDutySchema.setSchema(this.mResultSet, 1);
/*  999 */       tLNPDutySet.add(tLNPDutySchema);
/*      */ 
/* 1001 */       while (tCount++ < 5000)
/*      */       {
/* 1003 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1005 */         tLNPDutySchema = new LNPDutySchema();
/* 1006 */         tLNPDutySchema.setSchema(this.mResultSet, 1);
/* 1007 */         tLNPDutySet.add(tLNPDutySchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1013 */       CError tError = new CError();
/* 1014 */       tError.moduleName = "LNPDutyDB";
/* 1015 */       tError.functionName = "getData";
/* 1016 */       tError.errorMessage = ex.toString();
/* 1017 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1020 */         this.mResultSet.close();
/* 1021 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1027 */         this.mStatement.close();
/* 1028 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1032 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1036 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1041 */       return null;
/*      */     }
/* 1043 */     return tLNPDutySet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1048 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1051 */       if (this.mResultSet == null)
/*      */       {
/* 1053 */         CError tError = new CError();
/* 1054 */         tError.moduleName = "LNPDutyDB";
/* 1055 */         tError.functionName = "closeData";
/* 1056 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1057 */         this.mErrors.addOneError(tError);
/* 1058 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1062 */         this.mResultSet.close();
/* 1063 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1068 */       CError tError = new CError();
/* 1069 */       tError.moduleName = "LNPDutyDB";
/* 1070 */       tError.functionName = "closeData";
/* 1071 */       tError.errorMessage = ex2.toString();
/* 1072 */       this.mErrors.addOneError(tError);
/* 1073 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1077 */       if (this.mStatement == null)
/*      */       {
/* 1079 */         CError tError = new CError();
/* 1080 */         tError.moduleName = "LNPDutyDB";
/* 1081 */         tError.functionName = "closeData";
/* 1082 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1083 */         this.mErrors.addOneError(tError);
/* 1084 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1088 */         this.mStatement.close();
/* 1089 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1094 */       CError tError = new CError();
/* 1095 */       tError.moduleName = "LNPDutyDB";
/* 1096 */       tError.functionName = "closeData";
/* 1097 */       tError.errorMessage = ex3.toString();
/* 1098 */       this.mErrors.addOneError(tError);
/* 1099 */       flag = false;
/*      */     }
/* 1101 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPDutyDB
 * JD-Core Version:    0.6.0
 */