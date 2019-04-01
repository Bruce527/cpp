/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPAgentTraceSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAgentTraceSet;
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
/*      */ public class LNPAgentTraceDB extends LNPAgentTraceSchema
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
/*      */   public LNPAgentTraceDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPAgentTrace");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPAgentTraceDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPAgentTrace");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPAgentTraceSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPAgentTraceDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPAgentTraceSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPAgentTraceDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAgentTrace WHERE  ID = ?");
/*   97 */       if ((getID() == null) || (getID().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getID());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPAgentTraceDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPAgentTrace SET  ID = ? , Contno = ? , Operator = ? , OperatorDate = ? , OperatorTime = ? , OperatorType = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc5 = ? , Varc3 = ? , Varc4 = ? , Varc6 = ? , Date1 = ? , Date2 = ? WHERE  ID = ?");
/*  146 */       if ((getID() == null) || (getID().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getID());
/*      */       }
/*  151 */       if ((getContno() == null) || (getContno().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getContno());
/*      */       }
/*  156 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getOperator());
/*      */       }
/*  161 */       if ((getOperatorDate() == null) || (getOperatorDate().equals("null")))
/*  162 */         pstmt.setNull(4, 91);
/*      */       else {
/*  164 */         pstmt.setDate(4, Date.valueOf(getOperatorDate()));
/*      */       }
/*  166 */       if ((getOperatorTime() == null) || (getOperatorTime().equals("null")))
/*  167 */         pstmt.setNull(5, 12);
/*      */       else {
/*  169 */         pstmt.setString(5, getOperatorTime());
/*      */       }
/*  171 */       if ((getOperatorType() == null) || (getOperatorType().equals("null")))
/*  172 */         pstmt.setNull(6, 12);
/*      */       else {
/*  174 */         pstmt.setString(6, getOperatorType());
/*      */       }
/*  176 */       pstmt.setInt(7, getInt1());
/*  177 */       pstmt.setInt(8, getInt2());
/*  178 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  179 */         pstmt.setNull(9, 12);
/*      */       else {
/*  181 */         pstmt.setString(9, getVarc1());
/*      */       }
/*  183 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  184 */         pstmt.setNull(10, 12);
/*      */       else {
/*  186 */         pstmt.setString(10, getVarc2());
/*      */       }
/*  188 */       if ((getVarc5() == null) || (getVarc5().equals("null")))
/*  189 */         pstmt.setNull(11, 12);
/*      */       else {
/*  191 */         pstmt.setString(11, getVarc5());
/*      */       }
/*  193 */       if ((getVarc3() == null) || (getVarc3().equals("null")))
/*  194 */         pstmt.setNull(12, 12);
/*      */       else {
/*  196 */         pstmt.setString(12, getVarc3());
/*      */       }
/*  198 */       if ((getVarc4() == null) || (getVarc4().equals("null")))
/*  199 */         pstmt.setNull(13, 12);
/*      */       else {
/*  201 */         pstmt.setString(13, getVarc4());
/*      */       }
/*  203 */       if ((getVarc6() == null) || (getVarc6().equals("null")))
/*  204 */         pstmt.setNull(14, 12);
/*      */       else {
/*  206 */         pstmt.setString(14, getVarc6());
/*      */       }
/*  208 */       if ((getDate1() == null) || (getDate1().equals("null")))
/*  209 */         pstmt.setNull(15, 91);
/*      */       else {
/*  211 */         pstmt.setDate(15, Date.valueOf(getDate1()));
/*      */       }
/*  213 */       if ((getDate2() == null) || (getDate2().equals("null")))
/*  214 */         pstmt.setNull(16, 91);
/*      */       else {
/*  216 */         pstmt.setDate(16, Date.valueOf(getDate2()));
/*      */       }
/*      */ 
/*  219 */       if ((getID() == null) || (getID().equals("null")))
/*  220 */         pstmt.setNull(17, 12);
/*      */       else {
/*  222 */         pstmt.setString(17, getID());
/*      */       }
/*  224 */       pstmt.executeUpdate();
/*  225 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  228 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  229 */       CError tError = new CError();
/*  230 */       tError.moduleName = "LNPAgentTraceDB";
/*  231 */       tError.functionName = "update()";
/*  232 */       tError.errorMessage = ex.toString();
/*  233 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  236 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  239 */       if (!this.mflag)
/*      */         try {
/*  241 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  245 */       return false;
/*      */     }
/*      */ 
/*  248 */     if (!this.mflag)
/*      */       try {
/*  250 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  254 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  259 */     PreparedStatement pstmt = null;
/*      */ 
/*  261 */     if (!this.mflag) {
/*  262 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  267 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAgentTrace VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  268 */       if ((getID() == null) || (getID().equals("null")))
/*  269 */         pstmt.setNull(1, 12);
/*      */       else {
/*  271 */         pstmt.setString(1, getID());
/*      */       }
/*  273 */       if ((getContno() == null) || (getContno().equals("null")))
/*  274 */         pstmt.setNull(2, 12);
/*      */       else {
/*  276 */         pstmt.setString(2, getContno());
/*      */       }
/*  278 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  279 */         pstmt.setNull(3, 12);
/*      */       else {
/*  281 */         pstmt.setString(3, getOperator());
/*      */       }
/*  283 */       if ((getOperatorDate() == null) || (getOperatorDate().equals("null")))
/*  284 */         pstmt.setNull(4, 91);
/*      */       else {
/*  286 */         pstmt.setDate(4, Date.valueOf(getOperatorDate()));
/*      */       }
/*  288 */       if ((getOperatorTime() == null) || (getOperatorTime().equals("null")))
/*  289 */         pstmt.setNull(5, 12);
/*      */       else {
/*  291 */         pstmt.setString(5, getOperatorTime());
/*      */       }
/*  293 */       if ((getOperatorType() == null) || (getOperatorType().equals("null")))
/*  294 */         pstmt.setNull(6, 12);
/*      */       else {
/*  296 */         pstmt.setString(6, getOperatorType());
/*      */       }
/*  298 */       pstmt.setInt(7, getInt1());
/*  299 */       pstmt.setInt(8, getInt2());
/*  300 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  301 */         pstmt.setNull(9, 12);
/*      */       else {
/*  303 */         pstmt.setString(9, getVarc1());
/*      */       }
/*  305 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  306 */         pstmt.setNull(10, 12);
/*      */       else {
/*  308 */         pstmt.setString(10, getVarc2());
/*      */       }
/*  310 */       if ((getVarc5() == null) || (getVarc5().equals("null")))
/*  311 */         pstmt.setNull(11, 12);
/*      */       else {
/*  313 */         pstmt.setString(11, getVarc5());
/*      */       }
/*  315 */       if ((getVarc3() == null) || (getVarc3().equals("null")))
/*  316 */         pstmt.setNull(12, 12);
/*      */       else {
/*  318 */         pstmt.setString(12, getVarc3());
/*      */       }
/*  320 */       if ((getVarc4() == null) || (getVarc4().equals("null")))
/*  321 */         pstmt.setNull(13, 12);
/*      */       else {
/*  323 */         pstmt.setString(13, getVarc4());
/*      */       }
/*  325 */       if ((getVarc6() == null) || (getVarc6().equals("null")))
/*  326 */         pstmt.setNull(14, 12);
/*      */       else {
/*  328 */         pstmt.setString(14, getVarc6());
/*      */       }
/*  330 */       if ((getDate1() == null) || (getDate1().equals("null")))
/*  331 */         pstmt.setNull(15, 91);
/*      */       else {
/*  333 */         pstmt.setDate(15, Date.valueOf(getDate1()));
/*      */       }
/*  335 */       if ((getDate2() == null) || (getDate2().equals("null")))
/*  336 */         pstmt.setNull(16, 91);
/*      */       else {
/*  338 */         pstmt.setDate(16, Date.valueOf(getDate2()));
/*      */       }
/*      */ 
/*  341 */       pstmt.executeUpdate();
/*  342 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  345 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  346 */       CError tError = new CError();
/*  347 */       tError.moduleName = "LNPAgentTraceDB";
/*  348 */       tError.functionName = "insert()";
/*  349 */       tError.errorMessage = ex.toString();
/*  350 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  353 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  356 */       if (!this.mflag)
/*      */         try {
/*  358 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  362 */       return false;
/*      */     }
/*      */ 
/*  365 */     if (!this.mflag)
/*      */       try {
/*  367 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  371 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  376 */     PreparedStatement pstmt = null;
/*  377 */     ResultSet rs = null;
/*      */ 
/*  379 */     if (!this.mflag) {
/*  380 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  385 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPAgentTrace WHERE  ID = ?", 
/*  386 */         1003, 1007);
/*  387 */       if ((getID() == null) || (getID().equals("null")))
/*  388 */         pstmt.setNull(1, 12);
/*      */       else {
/*  390 */         pstmt.setString(1, getID());
/*      */       }
/*  392 */       rs = pstmt.executeQuery();
/*  393 */       int i = 0;
/*  394 */       if (rs.next())
/*      */       {
/*  396 */         i++;
/*  397 */         if (!setSchema(rs, i))
/*      */         {
/*  400 */           CError tError = new CError();
/*  401 */           tError.moduleName = "LNPAgentTraceDB";
/*  402 */           tError.functionName = "getInfo";
/*  403 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  404 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  406 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  409 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  413 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  417 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  421 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  424 */       if (i == 0)
/*      */       {
/*  426 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  430 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  434 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  440 */       CError tError = new CError();
/*  441 */       tError.moduleName = "LNPAgentTraceDB";
/*  442 */       tError.functionName = "getInfo";
/*  443 */       tError.errorMessage = e.toString();
/*  444 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  446 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  449 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  453 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  457 */       return false;
/*      */     }
/*      */ 
/*  460 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  464 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  469 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAgentTraceSet query()
/*      */   {
/*  474 */     Statement stmt = null;
/*  475 */     ResultSet rs = null;
/*  476 */     LNPAgentTraceSet aLNPAgentTraceSet = new LNPAgentTraceSet();
/*      */ 
/*  478 */     if (!this.mflag) {
/*  479 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  484 */       stmt = this.con.createStatement(1003, 1007);
/*  485 */       SQLString sqlObj = new SQLString("LNPAgentTrace");
/*  486 */       LNPAgentTraceSchema aSchema = getSchema();
/*  487 */       sqlObj.setSQL(5, aSchema);
/*  488 */       String sql = sqlObj.getSQL();
/*      */ 
/*  490 */       rs = stmt.executeQuery(sql);
/*  491 */       int i = 0;
/*  492 */       while (rs.next())
/*      */       {
/*  494 */         i++;
/*  495 */         LNPAgentTraceSchema s1 = new LNPAgentTraceSchema();
/*  496 */         s1.setSchema(rs, i);
/*  497 */         aLNPAgentTraceSet.add(s1);
/*      */       }try {
/*  499 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  505 */       CError tError = new CError();
/*  506 */       tError.moduleName = "LNPAgentTraceDB";
/*  507 */       tError.functionName = "query";
/*  508 */       tError.errorMessage = e.toString();
/*  509 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  511 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  514 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  518 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  524 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  528 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  533 */     return aLNPAgentTraceSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentTraceSet executeQuery(String sql)
/*      */   {
/*  538 */     Statement stmt = null;
/*  539 */     ResultSet rs = null;
/*  540 */     LNPAgentTraceSet aLNPAgentTraceSet = new LNPAgentTraceSet();
/*      */ 
/*  542 */     if (!this.mflag) {
/*  543 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  548 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  550 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  551 */       int i = 0;
/*  552 */       while (rs.next())
/*      */       {
/*  554 */         i++;
/*  555 */         LNPAgentTraceSchema s1 = new LNPAgentTraceSchema();
/*  556 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  559 */           CError tError = new CError();
/*  560 */           tError.moduleName = "LNPAgentTraceDB";
/*  561 */           tError.functionName = "executeQuery";
/*  562 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  563 */           this.mErrors.addOneError(tError);
/*      */         }
/*  565 */         aLNPAgentTraceSet.add(s1);
/*      */       }try {
/*  567 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  573 */       CError tError = new CError();
/*  574 */       tError.moduleName = "LNPAgentTraceDB";
/*  575 */       tError.functionName = "executeQuery";
/*  576 */       tError.errorMessage = e.toString();
/*  577 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  579 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  582 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  586 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  592 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  596 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  601 */     return aLNPAgentTraceSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentTraceSet query(int nStart, int nCount)
/*      */   {
/*  606 */     Statement stmt = null;
/*  607 */     ResultSet rs = null;
/*  608 */     LNPAgentTraceSet aLNPAgentTraceSet = new LNPAgentTraceSet();
/*      */ 
/*  610 */     if (!this.mflag) {
/*  611 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  616 */       stmt = this.con.createStatement(1003, 1007);
/*  617 */       SQLString sqlObj = new SQLString("LNPAgentTrace");
/*  618 */       LNPAgentTraceSchema aSchema = getSchema();
/*  619 */       sqlObj.setSQL(5, aSchema);
/*  620 */       String sql = sqlObj.getSQL();
/*      */ 
/*  622 */       rs = stmt.executeQuery(sql);
/*  623 */       int i = 0;
/*  624 */       while (rs.next())
/*      */       {
/*  626 */         i++;
/*      */ 
/*  628 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  632 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  636 */         LNPAgentTraceSchema s1 = new LNPAgentTraceSchema();
/*  637 */         s1.setSchema(rs, i);
/*  638 */         aLNPAgentTraceSet.add(s1);
/*      */       }try {
/*  640 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  646 */       CError tError = new CError();
/*  647 */       tError.moduleName = "LNPAgentTraceDB";
/*  648 */       tError.functionName = "query";
/*  649 */       tError.errorMessage = e.toString();
/*  650 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  652 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  655 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  659 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  665 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  669 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  674 */     return aLNPAgentTraceSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentTraceSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  679 */     Statement stmt = null;
/*  680 */     ResultSet rs = null;
/*  681 */     LNPAgentTraceSet aLNPAgentTraceSet = new LNPAgentTraceSet();
/*      */ 
/*  683 */     if (!this.mflag) {
/*  684 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  689 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  691 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  692 */       int i = 0;
/*  693 */       while (rs.next())
/*      */       {
/*  695 */         i++;
/*      */ 
/*  697 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  701 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  705 */         LNPAgentTraceSchema s1 = new LNPAgentTraceSchema();
/*  706 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  709 */           CError tError = new CError();
/*  710 */           tError.moduleName = "LNPAgentTraceDB";
/*  711 */           tError.functionName = "executeQuery";
/*  712 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  713 */           this.mErrors.addOneError(tError);
/*      */         }
/*  715 */         aLNPAgentTraceSet.add(s1);
/*      */       }try {
/*  717 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  723 */       CError tError = new CError();
/*  724 */       tError.moduleName = "LNPAgentTraceDB";
/*  725 */       tError.functionName = "executeQuery";
/*  726 */       tError.errorMessage = e.toString();
/*  727 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  729 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  732 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  736 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  742 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  746 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  751 */     return aLNPAgentTraceSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  756 */     Statement stmt = null;
/*      */ 
/*  758 */     if (!this.mflag) {
/*  759 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  764 */       stmt = this.con.createStatement(1003, 1007);
/*  765 */       SQLString sqlObj = new SQLString("LNPAgentTrace");
/*  766 */       LNPAgentTraceSchema aSchema = getSchema();
/*  767 */       sqlObj.setSQL(2, aSchema);
/*  768 */       String sql = "update LNPAgentTrace " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  770 */       int operCount = stmt.executeUpdate(sql);
/*  771 */       if (operCount == 0)
/*      */       {
/*  774 */         CError tError = new CError();
/*  775 */         tError.moduleName = "LNPAgentTraceDB";
/*  776 */         tError.functionName = "update";
/*  777 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  778 */         this.mErrors.addOneError(tError);
/*      */ 
/*  780 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  784 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  788 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  794 */       CError tError = new CError();
/*  795 */       tError.moduleName = "LNPAgentTraceDB";
/*  796 */       tError.functionName = "update";
/*  797 */       tError.errorMessage = e.toString();
/*  798 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  800 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  802 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  806 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  810 */       return false;
/*      */     }
/*      */ 
/*  813 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  817 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  822 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  828 */     if (this.mResultSet != null)
/*      */     {
/*  831 */       CError tError = new CError();
/*  832 */       tError.moduleName = "LNPAgentTraceDB";
/*  833 */       tError.functionName = "prepareData";
/*  834 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  835 */       this.mErrors.addOneError(tError);
/*  836 */       return false;
/*      */     }
/*      */ 
/*  839 */     if (!this.mflag)
/*      */     {
/*  841 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  845 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  846 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  851 */       CError tError = new CError();
/*  852 */       tError.moduleName = "LNPAgentTraceDB";
/*  853 */       tError.functionName = "prepareData";
/*  854 */       tError.errorMessage = e.toString();
/*  855 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  858 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  864 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  868 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  872 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  877 */       return false;
/*      */     }
/*      */ 
/*  880 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  884 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  889 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  895 */     boolean flag = true;
/*  896 */     if (this.mResultSet == null)
/*      */     {
/*  898 */       CError tError = new CError();
/*  899 */       tError.moduleName = "LNPAgentTraceDB";
/*  900 */       tError.functionName = "hasMoreData";
/*  901 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  902 */       this.mErrors.addOneError(tError);
/*  903 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  907 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  911 */       CError tError = new CError();
/*  912 */       tError.moduleName = "LNPAgentTraceDB";
/*  913 */       tError.functionName = "hasMoreData";
/*  914 */       tError.errorMessage = ex.toString();
/*  915 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  918 */         this.mResultSet.close();
/*  919 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  925 */         this.mStatement.close();
/*  926 */         this.mStatement = null;
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
/*  941 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPAgentTraceSet getData()
/*      */   {
/*  946 */     int tCount = 0;
/*  947 */     LNPAgentTraceSet tLNPAgentTraceSet = new LNPAgentTraceSet();
/*  948 */     LNPAgentTraceSchema tLNPAgentTraceSchema = null;
/*  949 */     if (this.mResultSet == null)
/*      */     {
/*  951 */       CError tError = new CError();
/*  952 */       tError.moduleName = "LNPAgentTraceDB";
/*  953 */       tError.functionName = "getData";
/*  954 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  955 */       this.mErrors.addOneError(tError);
/*  956 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  960 */       tCount = 1;
/*  961 */       tLNPAgentTraceSchema = new LNPAgentTraceSchema();
/*  962 */       tLNPAgentTraceSchema.setSchema(this.mResultSet, 1);
/*  963 */       tLNPAgentTraceSet.add(tLNPAgentTraceSchema);
/*      */ 
/*  965 */       while (tCount++ < 5000)
/*      */       {
/*  967 */         if (!this.mResultSet.next())
/*      */           continue;
/*  969 */         tLNPAgentTraceSchema = new LNPAgentTraceSchema();
/*  970 */         tLNPAgentTraceSchema.setSchema(this.mResultSet, 1);
/*  971 */         tLNPAgentTraceSet.add(tLNPAgentTraceSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  977 */       CError tError = new CError();
/*  978 */       tError.moduleName = "LNPAgentTraceDB";
/*  979 */       tError.functionName = "getData";
/*  980 */       tError.errorMessage = ex.toString();
/*  981 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  984 */         this.mResultSet.close();
/*  985 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  991 */         this.mStatement.close();
/*  992 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  996 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1000 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1005 */       return null;
/*      */     }
/* 1007 */     return tLNPAgentTraceSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1012 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1015 */       if (this.mResultSet == null)
/*      */       {
/* 1017 */         CError tError = new CError();
/* 1018 */         tError.moduleName = "LNPAgentTraceDB";
/* 1019 */         tError.functionName = "closeData";
/* 1020 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1021 */         this.mErrors.addOneError(tError);
/* 1022 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1026 */         this.mResultSet.close();
/* 1027 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1032 */       CError tError = new CError();
/* 1033 */       tError.moduleName = "LNPAgentTraceDB";
/* 1034 */       tError.functionName = "closeData";
/* 1035 */       tError.errorMessage = ex2.toString();
/* 1036 */       this.mErrors.addOneError(tError);
/* 1037 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1041 */       if (this.mStatement == null)
/*      */       {
/* 1043 */         CError tError = new CError();
/* 1044 */         tError.moduleName = "LNPAgentTraceDB";
/* 1045 */         tError.functionName = "closeData";
/* 1046 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1047 */         this.mErrors.addOneError(tError);
/* 1048 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1052 */         this.mStatement.close();
/* 1053 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1058 */       CError tError = new CError();
/* 1059 */       tError.moduleName = "LNPAgentTraceDB";
/* 1060 */       tError.functionName = "closeData";
/* 1061 */       tError.errorMessage = ex3.toString();
/* 1062 */       this.mErrors.addOneError(tError);
/* 1063 */       flag = false;
/*      */     }
/* 1065 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPAgentTraceDB
 * JD-Core Version:    0.6.0
 */