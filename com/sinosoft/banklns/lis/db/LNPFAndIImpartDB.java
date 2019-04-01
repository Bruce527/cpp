/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPFAndIImpartSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPFAndIImpartSet;
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
/*      */ public class LNPFAndIImpartDB extends LNPFAndIImpartSchema
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
/*      */   public LNPFAndIImpartDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPFAndIImpart");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpartDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPFAndIImpart");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPFAndIImpartSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPFAndIImpartDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPFAndIImpartSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPFAndIImpartDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPFAndIImpart WHERE  ImpartId = ?");
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
/*  108 */       tError.moduleName = "LNPFAndIImpartDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPFAndIImpart SET  ImpartId = ? , ImpartName = ? , ImpartVer = ? , ImpartContent = ? , QuestionSum = ? , Operator = ? , ManageCom = ? , MakeTime = ? , MakeDate = ? , ModifyDate = ? , ModifyTime = ? , p1 = ? , p2 = ? , p3 = ? , p4 = ? WHERE  ImpartId = ?");
/*  146 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getImpartId());
/*      */       }
/*  151 */       if ((getImpartName() == null) || (getImpartName().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getImpartName());
/*      */       }
/*  156 */       if ((getImpartVer() == null) || (getImpartVer().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getImpartVer());
/*      */       }
/*  161 */       if ((getImpartContent() == null) || (getImpartContent().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getImpartContent());
/*      */       }
/*  166 */       pstmt.setInt(5, getQuestionSum());
/*  167 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  168 */         pstmt.setNull(6, 12);
/*      */       else {
/*  170 */         pstmt.setString(6, getOperator());
/*      */       }
/*  172 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  173 */         pstmt.setNull(7, 12);
/*      */       else {
/*  175 */         pstmt.setString(7, getManageCom());
/*      */       }
/*  177 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  178 */         pstmt.setNull(8, 12);
/*      */       else {
/*  180 */         pstmt.setString(8, getMakeTime());
/*      */       }
/*  182 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  183 */         pstmt.setNull(9, 91);
/*      */       else {
/*  185 */         pstmt.setDate(9, Date.valueOf(getMakeDate()));
/*      */       }
/*  187 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  188 */         pstmt.setNull(10, 91);
/*      */       else {
/*  190 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  192 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  193 */         pstmt.setNull(11, 12);
/*      */       else {
/*  195 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*  197 */       if ((getP1() == null) || (getP1().equals("null")))
/*  198 */         pstmt.setNull(12, 12);
/*      */       else {
/*  200 */         pstmt.setString(12, getP1());
/*      */       }
/*  202 */       if ((getP2() == null) || (getP2().equals("null")))
/*  203 */         pstmt.setNull(13, 12);
/*      */       else {
/*  205 */         pstmt.setString(13, getP2());
/*      */       }
/*  207 */       if ((getP3() == null) || (getP3().equals("null")))
/*  208 */         pstmt.setNull(14, 12);
/*      */       else {
/*  210 */         pstmt.setString(14, getP3());
/*      */       }
/*  212 */       if ((getP4() == null) || (getP4().equals("null")))
/*  213 */         pstmt.setNull(15, 12);
/*      */       else {
/*  215 */         pstmt.setString(15, getP4());
/*      */       }
/*      */ 
/*  218 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  219 */         pstmt.setNull(16, 12);
/*      */       else {
/*  221 */         pstmt.setString(16, getImpartId());
/*      */       }
/*  223 */       pstmt.executeUpdate();
/*  224 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  227 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  228 */       CError tError = new CError();
/*  229 */       tError.moduleName = "LNPFAndIImpartDB";
/*  230 */       tError.functionName = "update()";
/*  231 */       tError.errorMessage = ex.toString();
/*  232 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  235 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  238 */       if (!this.mflag)
/*      */         try {
/*  240 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  244 */       return false;
/*      */     }
/*      */ 
/*  247 */     if (!this.mflag)
/*      */       try {
/*  249 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  253 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  258 */     PreparedStatement pstmt = null;
/*      */ 
/*  260 */     if (!this.mflag) {
/*  261 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  266 */       pstmt = this.con.prepareStatement("INSERT INTO LNPFAndIImpart VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  267 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  268 */         pstmt.setNull(1, 12);
/*      */       else {
/*  270 */         pstmt.setString(1, getImpartId());
/*      */       }
/*  272 */       if ((getImpartName() == null) || (getImpartName().equals("null")))
/*  273 */         pstmt.setNull(2, 12);
/*      */       else {
/*  275 */         pstmt.setString(2, getImpartName());
/*      */       }
/*  277 */       if ((getImpartVer() == null) || (getImpartVer().equals("null")))
/*  278 */         pstmt.setNull(3, 12);
/*      */       else {
/*  280 */         pstmt.setString(3, getImpartVer());
/*      */       }
/*  282 */       if ((getImpartContent() == null) || (getImpartContent().equals("null")))
/*  283 */         pstmt.setNull(4, 12);
/*      */       else {
/*  285 */         pstmt.setString(4, getImpartContent());
/*      */       }
/*  287 */       pstmt.setInt(5, getQuestionSum());
/*  288 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  289 */         pstmt.setNull(6, 12);
/*      */       else {
/*  291 */         pstmt.setString(6, getOperator());
/*      */       }
/*  293 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  294 */         pstmt.setNull(7, 12);
/*      */       else {
/*  296 */         pstmt.setString(7, getManageCom());
/*      */       }
/*  298 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  299 */         pstmt.setNull(8, 12);
/*      */       else {
/*  301 */         pstmt.setString(8, getMakeTime());
/*      */       }
/*  303 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  304 */         pstmt.setNull(9, 91);
/*      */       else {
/*  306 */         pstmt.setDate(9, Date.valueOf(getMakeDate()));
/*      */       }
/*  308 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  309 */         pstmt.setNull(10, 91);
/*      */       else {
/*  311 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  313 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  314 */         pstmt.setNull(11, 12);
/*      */       else {
/*  316 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*  318 */       if ((getP1() == null) || (getP1().equals("null")))
/*  319 */         pstmt.setNull(12, 12);
/*      */       else {
/*  321 */         pstmt.setString(12, getP1());
/*      */       }
/*  323 */       if ((getP2() == null) || (getP2().equals("null")))
/*  324 */         pstmt.setNull(13, 12);
/*      */       else {
/*  326 */         pstmt.setString(13, getP2());
/*      */       }
/*  328 */       if ((getP3() == null) || (getP3().equals("null")))
/*  329 */         pstmt.setNull(14, 12);
/*      */       else {
/*  331 */         pstmt.setString(14, getP3());
/*      */       }
/*  333 */       if ((getP4() == null) || (getP4().equals("null")))
/*  334 */         pstmt.setNull(15, 12);
/*      */       else {
/*  336 */         pstmt.setString(15, getP4());
/*      */       }
/*      */ 
/*  339 */       pstmt.executeUpdate();
/*  340 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  343 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  344 */       CError tError = new CError();
/*  345 */       tError.moduleName = "LNPFAndIImpartDB";
/*  346 */       tError.functionName = "insert()";
/*  347 */       tError.errorMessage = ex.toString();
/*  348 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  351 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  354 */       if (!this.mflag)
/*      */         try {
/*  356 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  360 */       return false;
/*      */     }
/*      */ 
/*  363 */     if (!this.mflag)
/*      */       try {
/*  365 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  369 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  374 */     PreparedStatement pstmt = null;
/*  375 */     ResultSet rs = null;
/*      */ 
/*  377 */     if (!this.mflag) {
/*  378 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  383 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPFAndIImpart WHERE  ImpartId = ?", 
/*  384 */         1003, 1007);
/*  385 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  386 */         pstmt.setNull(1, 12);
/*      */       else {
/*  388 */         pstmt.setString(1, getImpartId());
/*      */       }
/*  390 */       rs = pstmt.executeQuery();
/*  391 */       int i = 0;
/*  392 */       if (rs.next())
/*      */       {
/*  394 */         i++;
/*  395 */         if (!setSchema(rs, i))
/*      */         {
/*  398 */           CError tError = new CError();
/*  399 */           tError.moduleName = "LNPFAndIImpartDB";
/*  400 */           tError.functionName = "getInfo";
/*  401 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  402 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  404 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  407 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  411 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  415 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  419 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  422 */       if (i == 0)
/*      */       {
/*  424 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  428 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  432 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  438 */       CError tError = new CError();
/*  439 */       tError.moduleName = "LNPFAndIImpartDB";
/*  440 */       tError.functionName = "getInfo";
/*  441 */       tError.errorMessage = e.toString();
/*  442 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  444 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  447 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  451 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  455 */       return false;
/*      */     }
/*      */ 
/*  458 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  462 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  467 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpartSet query()
/*      */   {
/*  472 */     Statement stmt = null;
/*  473 */     ResultSet rs = null;
/*  474 */     LNPFAndIImpartSet aLNPFAndIImpartSet = new LNPFAndIImpartSet();
/*      */ 
/*  476 */     if (!this.mflag) {
/*  477 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  482 */       stmt = this.con.createStatement(1003, 1007);
/*  483 */       SQLString sqlObj = new SQLString("LNPFAndIImpart");
/*  484 */       LNPFAndIImpartSchema aSchema = getSchema();
/*  485 */       sqlObj.setSQL(5, aSchema);
/*  486 */       String sql = sqlObj.getSQL();
/*      */ 
/*  488 */       rs = stmt.executeQuery(sql);
/*  489 */       int i = 0;
/*  490 */       while (rs.next())
/*      */       {
/*  492 */         i++;
/*  493 */         LNPFAndIImpartSchema s1 = new LNPFAndIImpartSchema();
/*  494 */         s1.setSchema(rs, i);
/*  495 */         aLNPFAndIImpartSet.add(s1);
/*      */       }try {
/*  497 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  503 */       CError tError = new CError();
/*  504 */       tError.moduleName = "LNPFAndIImpartDB";
/*  505 */       tError.functionName = "query";
/*  506 */       tError.errorMessage = e.toString();
/*  507 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  509 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  512 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  516 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  522 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  526 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  531 */     return aLNPFAndIImpartSet;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpartSet executeQuery(String sql)
/*      */   {
/*  536 */     Statement stmt = null;
/*  537 */     ResultSet rs = null;
/*  538 */     LNPFAndIImpartSet aLNPFAndIImpartSet = new LNPFAndIImpartSet();
/*      */ 
/*  540 */     if (!this.mflag) {
/*  541 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  546 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  548 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  549 */       int i = 0;
/*  550 */       while (rs.next())
/*      */       {
/*  552 */         i++;
/*  553 */         LNPFAndIImpartSchema s1 = new LNPFAndIImpartSchema();
/*  554 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  557 */           CError tError = new CError();
/*  558 */           tError.moduleName = "LNPFAndIImpartDB";
/*  559 */           tError.functionName = "executeQuery";
/*  560 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  561 */           this.mErrors.addOneError(tError);
/*      */         }
/*  563 */         aLNPFAndIImpartSet.add(s1);
/*      */       }try {
/*  565 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  571 */       CError tError = new CError();
/*  572 */       tError.moduleName = "LNPFAndIImpartDB";
/*  573 */       tError.functionName = "executeQuery";
/*  574 */       tError.errorMessage = e.toString();
/*  575 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  577 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  580 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  584 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  590 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  594 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  599 */     return aLNPFAndIImpartSet;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpartSet query(int nStart, int nCount)
/*      */   {
/*  604 */     Statement stmt = null;
/*  605 */     ResultSet rs = null;
/*  606 */     LNPFAndIImpartSet aLNPFAndIImpartSet = new LNPFAndIImpartSet();
/*      */ 
/*  608 */     if (!this.mflag) {
/*  609 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  614 */       stmt = this.con.createStatement(1003, 1007);
/*  615 */       SQLString sqlObj = new SQLString("LNPFAndIImpart");
/*  616 */       LNPFAndIImpartSchema aSchema = getSchema();
/*  617 */       sqlObj.setSQL(5, aSchema);
/*  618 */       String sql = sqlObj.getSQL();
/*      */ 
/*  620 */       rs = stmt.executeQuery(sql);
/*  621 */       int i = 0;
/*  622 */       while (rs.next())
/*      */       {
/*  624 */         i++;
/*      */ 
/*  626 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  630 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  634 */         LNPFAndIImpartSchema s1 = new LNPFAndIImpartSchema();
/*  635 */         s1.setSchema(rs, i);
/*  636 */         aLNPFAndIImpartSet.add(s1);
/*      */       }try {
/*  638 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  644 */       CError tError = new CError();
/*  645 */       tError.moduleName = "LNPFAndIImpartDB";
/*  646 */       tError.functionName = "query";
/*  647 */       tError.errorMessage = e.toString();
/*  648 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  650 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  653 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  657 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  663 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  667 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  672 */     return aLNPFAndIImpartSet;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpartSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  677 */     Statement stmt = null;
/*  678 */     ResultSet rs = null;
/*  679 */     LNPFAndIImpartSet aLNPFAndIImpartSet = new LNPFAndIImpartSet();
/*      */ 
/*  681 */     if (!this.mflag) {
/*  682 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  687 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  689 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  690 */       int i = 0;
/*  691 */       while (rs.next())
/*      */       {
/*  693 */         i++;
/*      */ 
/*  695 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  699 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  703 */         LNPFAndIImpartSchema s1 = new LNPFAndIImpartSchema();
/*  704 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  707 */           CError tError = new CError();
/*  708 */           tError.moduleName = "LNPFAndIImpartDB";
/*  709 */           tError.functionName = "executeQuery";
/*  710 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  711 */           this.mErrors.addOneError(tError);
/*      */         }
/*  713 */         aLNPFAndIImpartSet.add(s1);
/*      */       }try {
/*  715 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  721 */       CError tError = new CError();
/*  722 */       tError.moduleName = "LNPFAndIImpartDB";
/*  723 */       tError.functionName = "executeQuery";
/*  724 */       tError.errorMessage = e.toString();
/*  725 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  727 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  730 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  734 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  740 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  744 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  749 */     return aLNPFAndIImpartSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  754 */     Statement stmt = null;
/*      */ 
/*  756 */     if (!this.mflag) {
/*  757 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  762 */       stmt = this.con.createStatement(1003, 1007);
/*  763 */       SQLString sqlObj = new SQLString("LNPFAndIImpart");
/*  764 */       LNPFAndIImpartSchema aSchema = getSchema();
/*  765 */       sqlObj.setSQL(2, aSchema);
/*  766 */       String sql = "update LNPFAndIImpart " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  768 */       int operCount = stmt.executeUpdate(sql);
/*  769 */       if (operCount == 0)
/*      */       {
/*  772 */         CError tError = new CError();
/*  773 */         tError.moduleName = "LNPFAndIImpartDB";
/*  774 */         tError.functionName = "update";
/*  775 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  776 */         this.mErrors.addOneError(tError);
/*      */ 
/*  778 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  782 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  786 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  792 */       CError tError = new CError();
/*  793 */       tError.moduleName = "LNPFAndIImpartDB";
/*  794 */       tError.functionName = "update";
/*  795 */       tError.errorMessage = e.toString();
/*  796 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  798 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  800 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  804 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  808 */       return false;
/*      */     }
/*      */ 
/*  811 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  815 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  820 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  826 */     if (this.mResultSet != null)
/*      */     {
/*  829 */       CError tError = new CError();
/*  830 */       tError.moduleName = "LNPFAndIImpartDB";
/*  831 */       tError.functionName = "prepareData";
/*  832 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  833 */       this.mErrors.addOneError(tError);
/*  834 */       return false;
/*      */     }
/*      */ 
/*  837 */     if (!this.mflag)
/*      */     {
/*  839 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  843 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  844 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  849 */       CError tError = new CError();
/*  850 */       tError.moduleName = "LNPFAndIImpartDB";
/*  851 */       tError.functionName = "prepareData";
/*  852 */       tError.errorMessage = e.toString();
/*  853 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  856 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  862 */         this.mStatement.close();
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
/*      */ 
/*  878 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  882 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  887 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  893 */     boolean flag = true;
/*  894 */     if (this.mResultSet == null)
/*      */     {
/*  896 */       CError tError = new CError();
/*  897 */       tError.moduleName = "LNPFAndIImpartDB";
/*  898 */       tError.functionName = "hasMoreData";
/*  899 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  900 */       this.mErrors.addOneError(tError);
/*  901 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  905 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  909 */       CError tError = new CError();
/*  910 */       tError.moduleName = "LNPFAndIImpartDB";
/*  911 */       tError.functionName = "hasMoreData";
/*  912 */       tError.errorMessage = ex.toString();
/*  913 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  916 */         this.mResultSet.close();
/*  917 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  923 */         this.mStatement.close();
/*  924 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  928 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  932 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  937 */       return false;
/*      */     }
/*  939 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpartSet getData()
/*      */   {
/*  944 */     int tCount = 0;
/*  945 */     LNPFAndIImpartSet tLNPFAndIImpartSet = new LNPFAndIImpartSet();
/*  946 */     LNPFAndIImpartSchema tLNPFAndIImpartSchema = null;
/*  947 */     if (this.mResultSet == null)
/*      */     {
/*  949 */       CError tError = new CError();
/*  950 */       tError.moduleName = "LNPFAndIImpartDB";
/*  951 */       tError.functionName = "getData";
/*  952 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  953 */       this.mErrors.addOneError(tError);
/*  954 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  958 */       tCount = 1;
/*  959 */       tLNPFAndIImpartSchema = new LNPFAndIImpartSchema();
/*  960 */       tLNPFAndIImpartSchema.setSchema(this.mResultSet, 1);
/*  961 */       tLNPFAndIImpartSet.add(tLNPFAndIImpartSchema);
/*      */ 
/*  963 */       while (tCount++ < 5000)
/*      */       {
/*  965 */         if (!this.mResultSet.next())
/*      */           continue;
/*  967 */         tLNPFAndIImpartSchema = new LNPFAndIImpartSchema();
/*  968 */         tLNPFAndIImpartSchema.setSchema(this.mResultSet, 1);
/*  969 */         tLNPFAndIImpartSet.add(tLNPFAndIImpartSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  975 */       CError tError = new CError();
/*  976 */       tError.moduleName = "LNPFAndIImpartDB";
/*  977 */       tError.functionName = "getData";
/*  978 */       tError.errorMessage = ex.toString();
/*  979 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  982 */         this.mResultSet.close();
/*  983 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  989 */         this.mStatement.close();
/*  990 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  994 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  998 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1003 */       return null;
/*      */     }
/* 1005 */     return tLNPFAndIImpartSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1010 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1013 */       if (this.mResultSet == null)
/*      */       {
/* 1015 */         CError tError = new CError();
/* 1016 */         tError.moduleName = "LNPFAndIImpartDB";
/* 1017 */         tError.functionName = "closeData";
/* 1018 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1019 */         this.mErrors.addOneError(tError);
/* 1020 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1024 */         this.mResultSet.close();
/* 1025 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1030 */       CError tError = new CError();
/* 1031 */       tError.moduleName = "LNPFAndIImpartDB";
/* 1032 */       tError.functionName = "closeData";
/* 1033 */       tError.errorMessage = ex2.toString();
/* 1034 */       this.mErrors.addOneError(tError);
/* 1035 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1039 */       if (this.mStatement == null)
/*      */       {
/* 1041 */         CError tError = new CError();
/* 1042 */         tError.moduleName = "LNPFAndIImpartDB";
/* 1043 */         tError.functionName = "closeData";
/* 1044 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1045 */         this.mErrors.addOneError(tError);
/* 1046 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1050 */         this.mStatement.close();
/* 1051 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1056 */       CError tError = new CError();
/* 1057 */       tError.moduleName = "LNPFAndIImpartDB";
/* 1058 */       tError.functionName = "closeData";
/* 1059 */       tError.errorMessage = ex3.toString();
/* 1060 */       this.mErrors.addOneError(tError);
/* 1061 */       flag = false;
/*      */     }
/* 1063 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPFAndIImpartDB
 * JD-Core Version:    0.6.0
 */