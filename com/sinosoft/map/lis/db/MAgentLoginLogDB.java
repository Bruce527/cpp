/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MAgentLoginLogSchema;
/*      */ import com.sinosoft.map.lis.vschema.MAgentLoginLogSet;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.DBConnPool;
/*      */ import com.sinosoft.map.utility.DBOper;
/*      */ import com.sinosoft.map.utility.SQLString;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class MAgentLoginLogDB extends MAgentLoginLogSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*   23 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   26 */   private ResultSet mResultSet = null;
/*   27 */   private Statement mStatement = null;
/*      */ 
/*      */   public MAgentLoginLogDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MAgentLoginLog");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MAgentLoginLogDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MAgentLoginLog");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MAgentLoginLogSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MAgentLoginLogDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MAgentLoginLogSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MAgentLoginLogDB";
/*   75 */       tError.functionName = "getCount";
/*   76 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   77 */       this.mErrors.addOneError(tError);
/*      */ 
/*   79 */       return -1;
/*      */     }
/*      */ 
/*   82 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   87 */     PreparedStatement pstmt = null;
/*      */ 
/*   89 */     if (!this.mflag) {
/*   90 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MAgentLoginLog WHERE  ID = ?");
/*   96 */       if ((getID() == null) || (getID().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getID());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MAgentLoginLogDB";
/*  108 */       tError.functionName = "delete()";
/*  109 */       tError.errorMessage = ex.toString();
/*  110 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  113 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  116 */       if (!this.mflag)
/*      */         try {
/*  118 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  122 */       return false;
/*      */     }
/*      */ 
/*  125 */     if (!this.mflag)
/*      */       try {
/*  127 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  131 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  136 */     PreparedStatement pstmt = null;
/*      */ 
/*  138 */     if (!this.mflag) {
/*  139 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MAgentLoginLog SET  ID = ? , AgentCode = ? , UserType = ? , ClientName = ? , ClientType = ? , ClientIP = ? , LoginDate = ? , LoginTime = ? , LogoutDate = ? , LogoutTime = ? WHERE  ID = ?");
/*  145 */       if ((getID() == null) || (getID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getID());
/*      */       }
/*  150 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  155 */       if ((getUserType() == null) || (getUserType().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getUserType());
/*      */       }
/*  160 */       if ((getClientName() == null) || (getClientName().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getClientName());
/*      */       }
/*  165 */       if ((getClientType() == null) || (getClientType().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getClientType());
/*      */       }
/*  170 */       if ((getClientIP() == null) || (getClientIP().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getClientIP());
/*      */       }
/*  175 */       if ((getLoginTime() == null) || (getLoginTime().equals("null")))
/*  176 */         pstmt.setNull(8, 12);
/*      */       else {
/*  178 */         pstmt.setString(8, getLoginTime());
/*      */       }
/*  180 */       if ((getLogoutTime() == null) || (getLogoutTime().equals("null")))
/*  181 */         pstmt.setNull(10, 12);
/*      */       else {
/*  183 */         pstmt.setString(10, getLogoutTime());
/*      */       }
/*      */ 
/*  186 */       if ((getID() == null) || (getID().equals("null")))
/*  187 */         pstmt.setNull(11, 12);
/*      */       else {
/*  189 */         pstmt.setString(11, getID());
/*      */       }
/*  191 */       pstmt.executeUpdate();
/*  192 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  195 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  196 */       CError tError = new CError();
/*  197 */       tError.moduleName = "MAgentLoginLogDB";
/*  198 */       tError.functionName = "update()";
/*  199 */       tError.errorMessage = ex.toString();
/*  200 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  203 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  206 */       if (!this.mflag)
/*      */         try {
/*  208 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  212 */       return false;
/*      */     }
/*      */ 
/*  215 */     if (!this.mflag)
/*      */       try {
/*  217 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  221 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  226 */     PreparedStatement pstmt = null;
/*      */ 
/*  228 */     if (!this.mflag) {
/*  229 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  234 */       pstmt = this.con.prepareStatement("INSERT INTO MAgentLoginLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  235 */       if ((getID() == null) || (getID().equals("null")))
/*  236 */         pstmt.setNull(1, 12);
/*      */       else {
/*  238 */         pstmt.setString(1, getID());
/*      */       }
/*  240 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  241 */         pstmt.setNull(2, 12);
/*      */       else {
/*  243 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  245 */       if ((getUserType() == null) || (getUserType().equals("null")))
/*  246 */         pstmt.setNull(3, 12);
/*      */       else {
/*  248 */         pstmt.setString(3, getUserType());
/*      */       }
/*  250 */       if ((getClientName() == null) || (getClientName().equals("null")))
/*  251 */         pstmt.setNull(4, 12);
/*      */       else {
/*  253 */         pstmt.setString(4, getClientName());
/*      */       }
/*  255 */       if ((getClientType() == null) || (getClientType().equals("null")))
/*  256 */         pstmt.setNull(5, 12);
/*      */       else {
/*  258 */         pstmt.setString(5, getClientType());
/*      */       }
/*  260 */       if ((getClientIP() == null) || (getClientIP().equals("null")))
/*  261 */         pstmt.setNull(6, 12);
/*      */       else {
/*  263 */         pstmt.setString(6, getClientIP());
/*      */       }
/*  265 */       if ((getLoginTime() == null) || (getLoginTime().equals("null")))
/*  266 */         pstmt.setNull(8, 12);
/*      */       else {
/*  268 */         pstmt.setString(8, getLoginTime());
/*      */       }
/*  270 */       if ((getLogoutTime() == null) || (getLogoutTime().equals("null")))
/*  271 */         pstmt.setNull(10, 12);
/*      */       else {
/*  273 */         pstmt.setString(10, getLogoutTime());
/*      */       }
/*      */ 
/*  276 */       pstmt.executeUpdate();
/*  277 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  280 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  281 */       CError tError = new CError();
/*  282 */       tError.moduleName = "MAgentLoginLogDB";
/*  283 */       tError.functionName = "insert()";
/*  284 */       tError.errorMessage = ex.toString();
/*  285 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  288 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  291 */       if (!this.mflag)
/*      */         try {
/*  293 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  297 */       return false;
/*      */     }
/*      */ 
/*  300 */     if (!this.mflag)
/*      */       try {
/*  302 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  306 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  311 */     PreparedStatement pstmt = null;
/*  312 */     ResultSet rs = null;
/*      */ 
/*  314 */     if (!this.mflag) {
/*  315 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  320 */       pstmt = this.con.prepareStatement("SELECT * FROM MAgentLoginLog WHERE  ID = ?", 
/*  321 */         1003, 1007);
/*  322 */       if ((getID() == null) || (getID().equals("null")))
/*  323 */         pstmt.setNull(1, 12);
/*      */       else {
/*  325 */         pstmt.setString(1, getID());
/*      */       }
/*  327 */       rs = pstmt.executeQuery();
/*  328 */       int i = 0;
/*  329 */       if (rs.next())
/*      */       {
/*  331 */         i++;
/*  332 */         if (!setSchema(rs, i))
/*      */         {
/*  335 */           CError tError = new CError();
/*  336 */           tError.moduleName = "MAgentLoginLogDB";
/*  337 */           tError.functionName = "getInfo";
/*  338 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  339 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  341 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  344 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  348 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  352 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  356 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  359 */       if (i == 0)
/*      */       {
/*  361 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  365 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  369 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  375 */       CError tError = new CError();
/*  376 */       tError.moduleName = "MAgentLoginLogDB";
/*  377 */       tError.functionName = "getInfo";
/*  378 */       tError.errorMessage = e.toString();
/*  379 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  381 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  384 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  388 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  392 */       return false;
/*      */     }
/*      */ 
/*  395 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  399 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  404 */     return true;
/*      */   }
/*      */ 
/*      */   public MAgentLoginLogSet query()
/*      */   {
/*  409 */     Statement stmt = null;
/*  410 */     ResultSet rs = null;
/*  411 */     MAgentLoginLogSet aMAgentLoginLogSet = new MAgentLoginLogSet();
/*      */ 
/*  413 */     if (!this.mflag) {
/*  414 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  419 */       stmt = this.con.createStatement(1003, 1007);
/*  420 */       SQLString sqlObj = new SQLString("MAgentLoginLog");
/*  421 */       MAgentLoginLogSchema aSchema = getSchema();
/*  422 */       sqlObj.setSQL(5, aSchema);
/*  423 */       String sql = sqlObj.getSQL();
/*      */ 
/*  425 */       rs = stmt.executeQuery(sql);
/*  426 */       int i = 0;
/*  427 */       while (rs.next())
/*      */       {
/*  429 */         i++;
/*  430 */         MAgentLoginLogSchema s1 = new MAgentLoginLogSchema();
/*  431 */         s1.setSchema(rs, i);
/*  432 */         aMAgentLoginLogSet.add(s1);
/*      */       }try {
/*  434 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  440 */       CError tError = new CError();
/*  441 */       tError.moduleName = "MAgentLoginLogDB";
/*  442 */       tError.functionName = "query";
/*  443 */       tError.errorMessage = e.toString();
/*  444 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  446 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  449 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  453 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  459 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  463 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  468 */     return aMAgentLoginLogSet;
/*      */   }
/*      */ 
/*      */   public MAgentLoginLogSet executeQuery(String sql)
/*      */   {
/*  473 */     Statement stmt = null;
/*  474 */     ResultSet rs = null;
/*  475 */     MAgentLoginLogSet aMAgentLoginLogSet = new MAgentLoginLogSet();
/*      */ 
/*  477 */     if (!this.mflag) {
/*  478 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  483 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  485 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  486 */       int i = 0;
/*  487 */       while (rs.next())
/*      */       {
/*  489 */         i++;
/*  490 */         MAgentLoginLogSchema s1 = new MAgentLoginLogSchema();
/*  491 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  494 */           CError tError = new CError();
/*  495 */           tError.moduleName = "MAgentLoginLogDB";
/*  496 */           tError.functionName = "executeQuery";
/*  497 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  498 */           this.mErrors.addOneError(tError);
/*      */         }
/*  500 */         aMAgentLoginLogSet.add(s1);
/*      */       }try {
/*  502 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  508 */       CError tError = new CError();
/*  509 */       tError.moduleName = "MAgentLoginLogDB";
/*  510 */       tError.functionName = "executeQuery";
/*  511 */       tError.errorMessage = e.toString();
/*  512 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  514 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  517 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  521 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  527 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  531 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  536 */     return aMAgentLoginLogSet;
/*      */   }
/*      */ 
/*      */   public MAgentLoginLogSet query(int nStart, int nCount)
/*      */   {
/*  541 */     Statement stmt = null;
/*  542 */     ResultSet rs = null;
/*  543 */     MAgentLoginLogSet aMAgentLoginLogSet = new MAgentLoginLogSet();
/*      */ 
/*  545 */     if (!this.mflag) {
/*  546 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  551 */       stmt = this.con.createStatement(1003, 1007);
/*  552 */       SQLString sqlObj = new SQLString("MAgentLoginLog");
/*  553 */       MAgentLoginLogSchema aSchema = getSchema();
/*  554 */       sqlObj.setSQL(5, aSchema);
/*  555 */       String sql = sqlObj.getSQL();
/*      */ 
/*  557 */       rs = stmt.executeQuery(sql);
/*  558 */       int i = 0;
/*  559 */       while (rs.next())
/*      */       {
/*  561 */         i++;
/*      */ 
/*  563 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  567 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  571 */         MAgentLoginLogSchema s1 = new MAgentLoginLogSchema();
/*  572 */         s1.setSchema(rs, i);
/*  573 */         aMAgentLoginLogSet.add(s1);
/*      */       }try {
/*  575 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  581 */       CError tError = new CError();
/*  582 */       tError.moduleName = "MAgentLoginLogDB";
/*  583 */       tError.functionName = "query";
/*  584 */       tError.errorMessage = e.toString();
/*  585 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  587 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  590 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  594 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  600 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  604 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  609 */     return aMAgentLoginLogSet;
/*      */   }
/*      */ 
/*      */   public MAgentLoginLogSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  614 */     Statement stmt = null;
/*  615 */     ResultSet rs = null;
/*  616 */     MAgentLoginLogSet aMAgentLoginLogSet = new MAgentLoginLogSet();
/*      */ 
/*  618 */     if (!this.mflag) {
/*  619 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  624 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  626 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  627 */       int i = 0;
/*  628 */       while (rs.next())
/*      */       {
/*  630 */         i++;
/*      */ 
/*  632 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  636 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  640 */         MAgentLoginLogSchema s1 = new MAgentLoginLogSchema();
/*  641 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  644 */           CError tError = new CError();
/*  645 */           tError.moduleName = "MAgentLoginLogDB";
/*  646 */           tError.functionName = "executeQuery";
/*  647 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  648 */           this.mErrors.addOneError(tError);
/*      */         }
/*  650 */         aMAgentLoginLogSet.add(s1);
/*      */       }try {
/*  652 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  658 */       CError tError = new CError();
/*  659 */       tError.moduleName = "MAgentLoginLogDB";
/*  660 */       tError.functionName = "executeQuery";
/*  661 */       tError.errorMessage = e.toString();
/*  662 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  664 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  667 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  671 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  677 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  681 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  686 */     return aMAgentLoginLogSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  691 */     Statement stmt = null;
/*      */ 
/*  693 */     if (!this.mflag) {
/*  694 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  699 */       stmt = this.con.createStatement(1003, 1007);
/*  700 */       SQLString sqlObj = new SQLString("MAgentLoginLog");
/*  701 */       MAgentLoginLogSchema aSchema = getSchema();
/*  702 */       sqlObj.setSQL(2, aSchema);
/*  703 */       String sql = "update MAgentLoginLog " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  705 */       int operCount = stmt.executeUpdate(sql);
/*  706 */       if (operCount == 0)
/*      */       {
/*  709 */         CError tError = new CError();
/*  710 */         tError.moduleName = "MAgentLoginLogDB";
/*  711 */         tError.functionName = "update";
/*  712 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  713 */         this.mErrors.addOneError(tError);
/*      */ 
/*  715 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  719 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  723 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  729 */       CError tError = new CError();
/*  730 */       tError.moduleName = "MAgentLoginLogDB";
/*  731 */       tError.functionName = "update";
/*  732 */       tError.errorMessage = e.toString();
/*  733 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  735 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  737 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  741 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  745 */       return false;
/*      */     }
/*      */ 
/*  748 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  752 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  757 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  763 */     if (this.mResultSet != null)
/*      */     {
/*  766 */       CError tError = new CError();
/*  767 */       tError.moduleName = "MAgentLoginLogDB";
/*  768 */       tError.functionName = "prepareData";
/*  769 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  770 */       this.mErrors.addOneError(tError);
/*  771 */       return false;
/*      */     }
/*      */ 
/*  774 */     if (!this.mflag)
/*      */     {
/*  776 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  780 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  781 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  786 */       CError tError = new CError();
/*  787 */       tError.moduleName = "MAgentLoginLogDB";
/*  788 */       tError.functionName = "prepareData";
/*  789 */       tError.errorMessage = e.toString();
/*  790 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  793 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  799 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  803 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  807 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  812 */       return false;
/*      */     }
/*      */ 
/*  815 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  819 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  824 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  830 */     boolean flag = true;
/*  831 */     if (this.mResultSet == null)
/*      */     {
/*  833 */       CError tError = new CError();
/*  834 */       tError.moduleName = "MAgentLoginLogDB";
/*  835 */       tError.functionName = "hasMoreData";
/*  836 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  837 */       this.mErrors.addOneError(tError);
/*  838 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  842 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  846 */       CError tError = new CError();
/*  847 */       tError.moduleName = "MAgentLoginLogDB";
/*  848 */       tError.functionName = "hasMoreData";
/*  849 */       tError.errorMessage = ex.toString();
/*  850 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  853 */         this.mResultSet.close();
/*  854 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  860 */         this.mStatement.close();
/*  861 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  865 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  869 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  874 */       return false;
/*      */     }
/*  876 */     return flag;
/*      */   }
/*      */ 
/*      */   public MAgentLoginLogSet getData()
/*      */   {
/*  881 */     int tCount = 0;
/*  882 */     MAgentLoginLogSet tMAgentLoginLogSet = new MAgentLoginLogSet();
/*  883 */     MAgentLoginLogSchema tMAgentLoginLogSchema = null;
/*  884 */     if (this.mResultSet == null)
/*      */     {
/*  886 */       CError tError = new CError();
/*  887 */       tError.moduleName = "MAgentLoginLogDB";
/*  888 */       tError.functionName = "getData";
/*  889 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  890 */       this.mErrors.addOneError(tError);
/*  891 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  895 */       tCount = 1;
/*  896 */       tMAgentLoginLogSchema = new MAgentLoginLogSchema();
/*  897 */       tMAgentLoginLogSchema.setSchema(this.mResultSet, 1);
/*  898 */       tMAgentLoginLogSet.add(tMAgentLoginLogSchema);
/*      */ 
/*  900 */       while (tCount++ < 5000)
/*      */       {
/*  902 */         if (!this.mResultSet.next())
/*      */           continue;
/*  904 */         tMAgentLoginLogSchema = new MAgentLoginLogSchema();
/*  905 */         tMAgentLoginLogSchema.setSchema(this.mResultSet, 1);
/*  906 */         tMAgentLoginLogSet.add(tMAgentLoginLogSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  912 */       CError tError = new CError();
/*  913 */       tError.moduleName = "MAgentLoginLogDB";
/*  914 */       tError.functionName = "getData";
/*  915 */       tError.errorMessage = ex.toString();
/*  916 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  919 */         this.mResultSet.close();
/*  920 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  926 */         this.mStatement.close();
/*  927 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  931 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  935 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  940 */       return null;
/*      */     }
/*  942 */     return tMAgentLoginLogSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  947 */     boolean flag = true;
/*      */     try
/*      */     {
/*  950 */       if (this.mResultSet == null)
/*      */       {
/*  952 */         CError tError = new CError();
/*  953 */         tError.moduleName = "MAgentLoginLogDB";
/*  954 */         tError.functionName = "closeData";
/*  955 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/*  956 */         this.mErrors.addOneError(tError);
/*  957 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  961 */         this.mResultSet.close();
/*  962 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/*  967 */       CError tError = new CError();
/*  968 */       tError.moduleName = "MAgentLoginLogDB";
/*  969 */       tError.functionName = "closeData";
/*  970 */       tError.errorMessage = ex2.toString();
/*  971 */       this.mErrors.addOneError(tError);
/*  972 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/*  976 */       if (this.mStatement == null)
/*      */       {
/*  978 */         CError tError = new CError();
/*  979 */         tError.moduleName = "MAgentLoginLogDB";
/*  980 */         tError.functionName = "closeData";
/*  981 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/*  982 */         this.mErrors.addOneError(tError);
/*  983 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  987 */         this.mStatement.close();
/*  988 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/*  993 */       CError tError = new CError();
/*  994 */       tError.moduleName = "MAgentLoginLogDB";
/*  995 */       tError.functionName = "closeData";
/*  996 */       tError.errorMessage = ex3.toString();
/*  997 */       this.mErrors.addOneError(tError);
/*  998 */       flag = false;
/*      */     }
/* 1000 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MAgentLoginLogDB
 * JD-Core Version:    0.6.0
 */