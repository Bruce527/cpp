/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MWebLoginLogSchema;
/*      */ import com.sinosoft.map.lis.vschema.MWebLoginLogSet;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.DBConnPool;
/*      */ import com.sinosoft.map.utility.DBOper;
/*      */ import com.sinosoft.map.utility.SQLString;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class MWebLoginLogDB extends MWebLoginLogSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*   23 */   public CErrors mErrors = new CErrors();
/*   24 */   private ResultSet mResultSet = null;
/*   25 */   private Statement mStatement = null;
/*      */ 
/*      */   public MWebLoginLogDB(Connection tConnection)
/*      */   {
/*   29 */     this.con = tConnection;
/*   30 */     this.db = new DBOper(this.con, "MWebLoginLog");
/*   31 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MWebLoginLogDB()
/*      */   {
/*   36 */     this.con = null;
/*   37 */     this.db = new DBOper("MWebLoginLog");
/*   38 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   44 */     MWebLoginLogSchema tSchema = getSchema();
/*   45 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   47 */       return true;
/*      */     }
/*      */ 
/*   52 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   53 */     CError tError = new CError();
/*   54 */     tError.moduleName = "MWebLoginLogDB";
/*   55 */     tError.functionName = "deleteSQL";
/*   56 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   57 */     this.mErrors.addOneError(tError);
/*   58 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   64 */     MWebLoginLogSchema tSchema = getSchema();
/*      */ 
/*   66 */     int tCount = this.db.getCount(tSchema);
/*   67 */     if (tCount < 0)
/*      */     {
/*   70 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   71 */       CError tError = new CError();
/*   72 */       tError.moduleName = "MWebLoginLogDB";
/*   73 */       tError.functionName = "getCount";
/*   74 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   75 */       this.mErrors.addOneError(tError);
/*      */ 
/*   77 */       return -1;
/*      */     }
/*      */ 
/*   80 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   85 */     PreparedStatement pstmt = null;
/*      */ 
/*   87 */     if (!this.mflag) {
/*   88 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   93 */       pstmt = this.con.prepareStatement("DELETE FROM MWebLoginLog WHERE  ID = ?");
/*   94 */       if ((getID() == null) || (getID().equals("null")))
/*   95 */         pstmt.setNull(1, 12);
/*      */       else {
/*   97 */         pstmt.setString(1, getID());
/*      */       }
/*   99 */       pstmt.executeUpdate();
/*  100 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  103 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  104 */       CError tError = new CError();
/*  105 */       tError.moduleName = "MWebLoginLogDB";
/*  106 */       tError.functionName = "delete()";
/*  107 */       tError.errorMessage = ex.toString();
/*  108 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  111 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  114 */       if (!this.mflag)
/*      */         try {
/*  116 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  120 */       return false;
/*      */     }
/*      */ 
/*  123 */     if (!this.mflag)
/*      */       try {
/*  125 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  129 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  134 */     PreparedStatement pstmt = null;
/*      */ 
/*  136 */     if (!this.mflag) {
/*  137 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  142 */       pstmt = this.con.prepareStatement("UPDATE MWebLoginLog SET  ID = ? , SessionId = ? , UserCode = ? , UserType = ? , ClientName = ? , ClientType = ? , ClientIP = ? , LoginDate = ? , LoginTime = ? , LogoutDate = ? , LogoutTime = ? WHERE  ID = ?");
/*  143 */       if ((getID() == null) || (getID().equals("null")))
/*  144 */         pstmt.setNull(1, 12);
/*      */       else {
/*  146 */         pstmt.setString(1, getID());
/*      */       }
/*  148 */       if ((getSessionId() == null) || (getSessionId().equals("null")))
/*  149 */         pstmt.setNull(2, 12);
/*      */       else {
/*  151 */         pstmt.setString(2, getSessionId());
/*      */       }
/*  153 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  154 */         pstmt.setNull(3, 12);
/*      */       else {
/*  156 */         pstmt.setString(3, getUserCode());
/*      */       }
/*  158 */       if ((getUserType() == null) || (getUserType().equals("null")))
/*  159 */         pstmt.setNull(4, 12);
/*      */       else {
/*  161 */         pstmt.setString(4, getUserType());
/*      */       }
/*  163 */       if ((getClientName() == null) || (getClientName().equals("null")))
/*  164 */         pstmt.setNull(5, 12);
/*      */       else {
/*  166 */         pstmt.setString(5, getClientName());
/*      */       }
/*  168 */       if ((getClientType() == null) || (getClientType().equals("null")))
/*  169 */         pstmt.setNull(6, 12);
/*      */       else {
/*  171 */         pstmt.setString(6, getClientType());
/*      */       }
/*  173 */       if ((getClientIP() == null) || (getClientIP().equals("null")))
/*  174 */         pstmt.setNull(7, 12);
/*      */       else {
/*  176 */         pstmt.setString(7, getClientIP());
/*      */       }
/*  178 */       if ((getLoginDate() == null) || (getLoginDate().equals("null")))
/*  179 */         pstmt.setNull(8, 91);
/*      */       else {
/*  181 */         pstmt.setDate(8, Date.valueOf(getLoginDate()));
/*      */       }
/*  183 */       if ((getLoginTime() == null) || (getLoginTime().equals("null")))
/*  184 */         pstmt.setNull(9, 12);
/*      */       else {
/*  186 */         pstmt.setString(9, getLoginTime());
/*      */       }
/*  188 */       if ((getLogoutDate() == null) || (getLogoutDate().equals("null")))
/*  189 */         pstmt.setNull(10, 91);
/*      */       else {
/*  191 */         pstmt.setDate(10, Date.valueOf(getLogoutDate()));
/*      */       }
/*  193 */       if ((getLogoutTime() == null) || (getLogoutTime().equals("null")))
/*  194 */         pstmt.setNull(11, 12);
/*      */       else {
/*  196 */         pstmt.setString(11, getLogoutTime());
/*      */       }
/*      */ 
/*  199 */       if ((getID() == null) || (getID().equals("null")))
/*  200 */         pstmt.setNull(12, 12);
/*      */       else {
/*  202 */         pstmt.setString(12, getID());
/*      */       }
/*  204 */       pstmt.executeUpdate();
/*  205 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  208 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  209 */       CError tError = new CError();
/*  210 */       tError.moduleName = "MWebLoginLogDB";
/*  211 */       tError.functionName = "update()";
/*  212 */       tError.errorMessage = ex.toString();
/*  213 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  216 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  219 */       if (!this.mflag)
/*      */         try {
/*  221 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  225 */       return false;
/*      */     }
/*      */ 
/*  228 */     if (!this.mflag)
/*      */       try {
/*  230 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  234 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  239 */     PreparedStatement pstmt = null;
/*      */ 
/*  241 */     if (!this.mflag) {
/*  242 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  247 */       pstmt = this.con.prepareStatement("INSERT INTO MWebLoginLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  248 */       if ((getID() == null) || (getID().equals("null")))
/*  249 */         pstmt.setNull(1, 12);
/*      */       else {
/*  251 */         pstmt.setString(1, getID());
/*      */       }
/*  253 */       if ((getSessionId() == null) || (getSessionId().equals("null")))
/*  254 */         pstmt.setNull(2, 12);
/*      */       else {
/*  256 */         pstmt.setString(2, getSessionId());
/*      */       }
/*  258 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  259 */         pstmt.setNull(3, 12);
/*      */       else {
/*  261 */         pstmt.setString(3, getUserCode());
/*      */       }
/*  263 */       if ((getUserType() == null) || (getUserType().equals("null")))
/*  264 */         pstmt.setNull(4, 12);
/*      */       else {
/*  266 */         pstmt.setString(4, getUserType());
/*      */       }
/*  268 */       if ((getClientName() == null) || (getClientName().equals("null")))
/*  269 */         pstmt.setNull(5, 12);
/*      */       else {
/*  271 */         pstmt.setString(5, getClientName());
/*      */       }
/*  273 */       if ((getClientType() == null) || (getClientType().equals("null")))
/*  274 */         pstmt.setNull(6, 12);
/*      */       else {
/*  276 */         pstmt.setString(6, getClientType());
/*      */       }
/*  278 */       if ((getClientIP() == null) || (getClientIP().equals("null")))
/*  279 */         pstmt.setNull(7, 12);
/*      */       else {
/*  281 */         pstmt.setString(7, getClientIP());
/*      */       }
/*  283 */       if ((getLoginDate() == null) || (getLoginDate().equals("null")))
/*  284 */         pstmt.setNull(8, 91);
/*      */       else {
/*  286 */         pstmt.setDate(8, Date.valueOf(getLoginDate()));
/*      */       }
/*  288 */       if ((getLoginTime() == null) || (getLoginTime().equals("null")))
/*  289 */         pstmt.setNull(9, 12);
/*      */       else {
/*  291 */         pstmt.setString(9, getLoginTime());
/*      */       }
/*  293 */       if ((getLogoutDate() == null) || (getLogoutDate().equals("null")))
/*  294 */         pstmt.setNull(10, 91);
/*      */       else {
/*  296 */         pstmt.setDate(10, Date.valueOf(getLogoutDate()));
/*      */       }
/*  298 */       if ((getLogoutTime() == null) || (getLogoutTime().equals("null")))
/*  299 */         pstmt.setNull(11, 12);
/*      */       else {
/*  301 */         pstmt.setString(11, getLogoutTime());
/*      */       }
/*      */ 
/*  304 */       pstmt.executeUpdate();
/*  305 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  308 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  309 */       CError tError = new CError();
/*  310 */       tError.moduleName = "MWebLoginLogDB";
/*  311 */       tError.functionName = "insert()";
/*  312 */       tError.errorMessage = ex.toString();
/*  313 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  316 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  319 */       if (!this.mflag)
/*      */         try {
/*  321 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  325 */       return false;
/*      */     }
/*      */ 
/*  328 */     if (!this.mflag)
/*      */       try {
/*  330 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  334 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  339 */     PreparedStatement pstmt = null;
/*  340 */     ResultSet rs = null;
/*      */ 
/*  342 */     if (!this.mflag) {
/*  343 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  348 */       pstmt = this.con.prepareStatement("SELECT * FROM MWebLoginLog WHERE  ID = ?", 
/*  349 */         1003, 1007);
/*  350 */       if ((getID() == null) || (getID().equals("null")))
/*  351 */         pstmt.setNull(1, 12);
/*      */       else {
/*  353 */         pstmt.setString(1, getID());
/*      */       }
/*  355 */       rs = pstmt.executeQuery();
/*  356 */       int i = 0;
/*  357 */       if (rs.next())
/*      */       {
/*  359 */         i++;
/*  360 */         if (!setSchema(rs, i))
/*      */         {
/*  363 */           CError tError = new CError();
/*  364 */           tError.moduleName = "MWebLoginLogDB";
/*  365 */           tError.functionName = "getInfo";
/*  366 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  367 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  369 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  372 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  376 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  380 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  384 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  387 */       if (i == 0)
/*      */       {
/*  389 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  393 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  397 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  403 */       CError tError = new CError();
/*  404 */       tError.moduleName = "MWebLoginLogDB";
/*  405 */       tError.functionName = "getInfo";
/*  406 */       tError.errorMessage = e.toString();
/*  407 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  409 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  412 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  416 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  420 */       return false;
/*      */     }
/*      */ 
/*  423 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  427 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  432 */     return true;
/*      */   }
/*      */ 
/*      */   public MWebLoginLogSet query()
/*      */   {
/*  437 */     Statement stmt = null;
/*  438 */     ResultSet rs = null;
/*  439 */     MWebLoginLogSet aMWebLoginLogSet = new MWebLoginLogSet();
/*      */ 
/*  441 */     if (!this.mflag) {
/*  442 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  447 */       stmt = this.con.createStatement(1003, 1007);
/*  448 */       SQLString sqlObj = new SQLString("MWebLoginLog");
/*  449 */       MWebLoginLogSchema aSchema = getSchema();
/*  450 */       sqlObj.setSQL(5, aSchema);
/*  451 */       String sql = sqlObj.getSQL();
/*      */ 
/*  453 */       rs = stmt.executeQuery(sql);
/*  454 */       int i = 0;
/*  455 */       while (rs.next())
/*      */       {
/*  457 */         i++;
/*  458 */         MWebLoginLogSchema s1 = new MWebLoginLogSchema();
/*  459 */         s1.setSchema(rs, i);
/*  460 */         aMWebLoginLogSet.add(s1);
/*      */       }try {
/*  462 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  468 */       CError tError = new CError();
/*  469 */       tError.moduleName = "MWebLoginLogDB";
/*  470 */       tError.functionName = "query";
/*  471 */       tError.errorMessage = e.toString();
/*  472 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  474 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  477 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  481 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  487 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  491 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  496 */     return aMWebLoginLogSet;
/*      */   }
/*      */ 
/*      */   public MWebLoginLogSet executeQuery(String sql)
/*      */   {
/*  501 */     Statement stmt = null;
/*  502 */     ResultSet rs = null;
/*  503 */     MWebLoginLogSet aMWebLoginLogSet = new MWebLoginLogSet();
/*      */ 
/*  505 */     if (!this.mflag) {
/*  506 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  511 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  513 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  514 */       int i = 0;
/*  515 */       while (rs.next())
/*      */       {
/*  517 */         i++;
/*  518 */         MWebLoginLogSchema s1 = new MWebLoginLogSchema();
/*  519 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  522 */           CError tError = new CError();
/*  523 */           tError.moduleName = "MWebLoginLogDB";
/*  524 */           tError.functionName = "executeQuery";
/*  525 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  526 */           this.mErrors.addOneError(tError);
/*      */         }
/*  528 */         aMWebLoginLogSet.add(s1);
/*      */       }try {
/*  530 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  536 */       CError tError = new CError();
/*  537 */       tError.moduleName = "MWebLoginLogDB";
/*  538 */       tError.functionName = "executeQuery";
/*  539 */       tError.errorMessage = e.toString();
/*  540 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  542 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  545 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  549 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  555 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  559 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  564 */     return aMWebLoginLogSet;
/*      */   }
/*      */ 
/*      */   public MWebLoginLogSet query(int nStart, int nCount)
/*      */   {
/*  569 */     Statement stmt = null;
/*  570 */     ResultSet rs = null;
/*  571 */     MWebLoginLogSet aMWebLoginLogSet = new MWebLoginLogSet();
/*      */ 
/*  573 */     if (!this.mflag) {
/*  574 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  579 */       stmt = this.con.createStatement(1003, 1007);
/*  580 */       SQLString sqlObj = new SQLString("MWebLoginLog");
/*  581 */       MWebLoginLogSchema aSchema = getSchema();
/*  582 */       sqlObj.setSQL(5, aSchema);
/*  583 */       String sql = sqlObj.getSQL();
/*      */ 
/*  585 */       rs = stmt.executeQuery(sql);
/*  586 */       int i = 0;
/*  587 */       while (rs.next())
/*      */       {
/*  589 */         i++;
/*      */ 
/*  591 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  595 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  599 */         MWebLoginLogSchema s1 = new MWebLoginLogSchema();
/*  600 */         s1.setSchema(rs, i);
/*  601 */         aMWebLoginLogSet.add(s1);
/*      */       }try {
/*  603 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  609 */       CError tError = new CError();
/*  610 */       tError.moduleName = "MWebLoginLogDB";
/*  611 */       tError.functionName = "query";
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
/*  637 */     return aMWebLoginLogSet;
/*      */   }
/*      */ 
/*      */   public MWebLoginLogSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  642 */     Statement stmt = null;
/*  643 */     ResultSet rs = null;
/*  644 */     MWebLoginLogSet aMWebLoginLogSet = new MWebLoginLogSet();
/*      */ 
/*  646 */     if (!this.mflag) {
/*  647 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  652 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  654 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  655 */       int i = 0;
/*  656 */       while (rs.next())
/*      */       {
/*  658 */         i++;
/*      */ 
/*  660 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  664 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  668 */         MWebLoginLogSchema s1 = new MWebLoginLogSchema();
/*  669 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  672 */           CError tError = new CError();
/*  673 */           tError.moduleName = "MWebLoginLogDB";
/*  674 */           tError.functionName = "executeQuery";
/*  675 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  676 */           this.mErrors.addOneError(tError);
/*      */         }
/*  678 */         aMWebLoginLogSet.add(s1);
/*      */       }try {
/*  680 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  686 */       CError tError = new CError();
/*  687 */       tError.moduleName = "MWebLoginLogDB";
/*  688 */       tError.functionName = "executeQuery";
/*  689 */       tError.errorMessage = e.toString();
/*  690 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  692 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  695 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  699 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  705 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  709 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  714 */     return aMWebLoginLogSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  719 */     Statement stmt = null;
/*      */ 
/*  721 */     if (!this.mflag) {
/*  722 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  727 */       stmt = this.con.createStatement(1003, 1007);
/*  728 */       SQLString sqlObj = new SQLString("MWebLoginLog");
/*  729 */       MWebLoginLogSchema aSchema = getSchema();
/*  730 */       sqlObj.setSQL(2, aSchema);
/*  731 */       String sql = "update MWebLoginLog " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  733 */       int operCount = stmt.executeUpdate(sql);
/*  734 */       if (operCount == 0)
/*      */       {
/*  737 */         CError tError = new CError();
/*  738 */         tError.moduleName = "MWebLoginLogDB";
/*  739 */         tError.functionName = "update";
/*  740 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  741 */         this.mErrors.addOneError(tError);
/*      */ 
/*  743 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  747 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  751 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  757 */       CError tError = new CError();
/*  758 */       tError.moduleName = "MWebLoginLogDB";
/*  759 */       tError.functionName = "update";
/*  760 */       tError.errorMessage = e.toString();
/*  761 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  763 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  765 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  769 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  773 */       return false;
/*      */     }
/*      */ 
/*  776 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  780 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  785 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  791 */     if (this.mResultSet != null)
/*      */     {
/*  794 */       CError tError = new CError();
/*  795 */       tError.moduleName = "MWebLoginLogDB";
/*  796 */       tError.functionName = "prepareData";
/*  797 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  798 */       this.mErrors.addOneError(tError);
/*  799 */       return false;
/*      */     }
/*      */ 
/*  802 */     if (!this.mflag)
/*      */     {
/*  804 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  808 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  809 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  814 */       CError tError = new CError();
/*  815 */       tError.moduleName = "MWebLoginLogDB";
/*  816 */       tError.functionName = "prepareData";
/*  817 */       tError.errorMessage = e.toString();
/*  818 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  821 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  827 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  831 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  835 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  840 */       return false;
/*      */     }
/*      */ 
/*  843 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  847 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  852 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  858 */     boolean flag = true;
/*  859 */     if (this.mResultSet == null)
/*      */     {
/*  861 */       CError tError = new CError();
/*  862 */       tError.moduleName = "MWebLoginLogDB";
/*  863 */       tError.functionName = "hasMoreData";
/*  864 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  865 */       this.mErrors.addOneError(tError);
/*  866 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  870 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  874 */       CError tError = new CError();
/*  875 */       tError.moduleName = "MWebLoginLogDB";
/*  876 */       tError.functionName = "hasMoreData";
/*  877 */       tError.errorMessage = ex.toString();
/*  878 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  881 */         this.mResultSet.close();
/*  882 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  888 */         this.mStatement.close();
/*  889 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  893 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  897 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  902 */       return false;
/*      */     }
/*  904 */     return flag;
/*      */   }
/*      */ 
/*      */   public MWebLoginLogSet getData()
/*      */   {
/*  909 */     int tCount = 0;
/*  910 */     MWebLoginLogSet tMWebLoginLogSet = new MWebLoginLogSet();
/*  911 */     MWebLoginLogSchema tMWebLoginLogSchema = null;
/*  912 */     if (this.mResultSet == null)
/*      */     {
/*  914 */       CError tError = new CError();
/*  915 */       tError.moduleName = "MWebLoginLogDB";
/*  916 */       tError.functionName = "getData";
/*  917 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  918 */       this.mErrors.addOneError(tError);
/*  919 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  923 */       tCount = 1;
/*  924 */       tMWebLoginLogSchema = new MWebLoginLogSchema();
/*  925 */       tMWebLoginLogSchema.setSchema(this.mResultSet, 1);
/*  926 */       tMWebLoginLogSet.add(tMWebLoginLogSchema);
/*      */ 
/*  928 */       while (tCount++ < 5000)
/*      */       {
/*  930 */         if (!this.mResultSet.next())
/*      */           continue;
/*  932 */         tMWebLoginLogSchema = new MWebLoginLogSchema();
/*  933 */         tMWebLoginLogSchema.setSchema(this.mResultSet, 1);
/*  934 */         tMWebLoginLogSet.add(tMWebLoginLogSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  940 */       CError tError = new CError();
/*  941 */       tError.moduleName = "MWebLoginLogDB";
/*  942 */       tError.functionName = "getData";
/*  943 */       tError.errorMessage = ex.toString();
/*  944 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  947 */         this.mResultSet.close();
/*  948 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  954 */         this.mStatement.close();
/*  955 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  959 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  963 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  968 */       return null;
/*      */     }
/*  970 */     return tMWebLoginLogSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  975 */     boolean flag = true;
/*      */     try
/*      */     {
/*  978 */       if (this.mResultSet == null)
/*      */       {
/*  980 */         CError tError = new CError();
/*  981 */         tError.moduleName = "MWebLoginLogDB";
/*  982 */         tError.functionName = "closeData";
/*  983 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/*  984 */         this.mErrors.addOneError(tError);
/*  985 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  989 */         this.mResultSet.close();
/*  990 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/*  995 */       CError tError = new CError();
/*  996 */       tError.moduleName = "MWebLoginLogDB";
/*  997 */       tError.functionName = "closeData";
/*  998 */       tError.errorMessage = ex2.toString();
/*  999 */       this.mErrors.addOneError(tError);
/* 1000 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1004 */       if (this.mStatement == null)
/*      */       {
/* 1006 */         CError tError = new CError();
/* 1007 */         tError.moduleName = "MWebLoginLogDB";
/* 1008 */         tError.functionName = "closeData";
/* 1009 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1010 */         this.mErrors.addOneError(tError);
/* 1011 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1015 */         this.mStatement.close();
/* 1016 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1021 */       CError tError = new CError();
/* 1022 */       tError.moduleName = "MWebLoginLogDB";
/* 1023 */       tError.functionName = "closeData";
/* 1024 */       tError.errorMessage = ex3.toString();
/* 1025 */       this.mErrors.addOneError(tError);
/* 1026 */       flag = false;
/*      */     }
/* 1028 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MWebLoginLogDB
 * JD-Core Version:    0.6.0
 */