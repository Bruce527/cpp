/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MMapv2LoginLogSchema;
/*      */ import com.sinosoft.map.lis.vschema.MMapv2LoginLogSet;
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
/*      */ public class MMapv2LoginLogDB extends MMapv2LoginLogSchema
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
/*      */   public MMapv2LoginLogDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MMapv2LoginLog");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MMapv2LoginLogDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MMapv2LoginLog");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MMapv2LoginLogSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MMapv2LoginLogDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MMapv2LoginLogSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MMapv2LoginLogDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MMapv2LoginLog WHERE  ID = ?");
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
/*  107 */       tError.moduleName = "MMapv2LoginLogDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MMapv2LoginLog SET  ID = ? , UserCode = ? , UserType = ? , ClientName = ? , ClientType = ? , ClientIP = ? , LoginDate = ? , LoginTime = ? , LogoutDate = ? , LogoutTime = ? WHERE  ID = ?");
/*  145 */       if ((getID() == null) || (getID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getID());
/*      */       }
/*  150 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getUserCode());
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
/*  175 */       if ((getLoginDate() == null) || (getLoginDate().equals("null")))
/*  176 */         pstmt.setNull(7, 91);
/*      */       else {
/*  178 */         pstmt.setDate(7, Date.valueOf(getLoginDate()));
/*      */       }
/*  180 */       if ((getLoginTime() == null) || (getLoginTime().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getLoginTime());
/*      */       }
/*  185 */       if ((getLogoutDate() == null) || (getLogoutDate().equals("null")))
/*  186 */         pstmt.setNull(9, 91);
/*      */       else {
/*  188 */         pstmt.setDate(9, Date.valueOf(getLogoutDate()));
/*      */       }
/*  190 */       if ((getLogoutTime() == null) || (getLogoutTime().equals("null")))
/*  191 */         pstmt.setNull(10, 12);
/*      */       else {
/*  193 */         pstmt.setString(10, getLogoutTime());
/*      */       }
/*      */ 
/*  196 */       if ((getID() == null) || (getID().equals("null")))
/*  197 */         pstmt.setNull(11, 12);
/*      */       else {
/*  199 */         pstmt.setString(11, getID());
/*      */       }
/*  201 */       pstmt.executeUpdate();
/*  202 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  205 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  206 */       CError tError = new CError();
/*  207 */       tError.moduleName = "MMapv2LoginLogDB";
/*  208 */       tError.functionName = "update()";
/*  209 */       tError.errorMessage = ex.toString();
/*  210 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  213 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  216 */       if (!this.mflag)
/*      */         try {
/*  218 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  222 */       return false;
/*      */     }
/*      */ 
/*  225 */     if (!this.mflag)
/*      */       try {
/*  227 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  231 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  236 */     PreparedStatement pstmt = null;
/*      */ 
/*  238 */     if (!this.mflag) {
/*  239 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  244 */       pstmt = this.con.prepareStatement("INSERT INTO MMapv2LoginLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  245 */       if ((getID() == null) || (getID().equals("null")))
/*  246 */         pstmt.setNull(1, 12);
/*      */       else {
/*  248 */         pstmt.setString(1, getID());
/*      */       }
/*  250 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  251 */         pstmt.setNull(2, 12);
/*      */       else {
/*  253 */         pstmt.setString(2, getUserCode());
/*      */       }
/*  255 */       if ((getUserType() == null) || (getUserType().equals("null")))
/*  256 */         pstmt.setNull(3, 12);
/*      */       else {
/*  258 */         pstmt.setString(3, getUserType());
/*      */       }
/*  260 */       if ((getClientName() == null) || (getClientName().equals("null")))
/*  261 */         pstmt.setNull(4, 12);
/*      */       else {
/*  263 */         pstmt.setString(4, getClientName());
/*      */       }
/*  265 */       if ((getClientType() == null) || (getClientType().equals("null")))
/*  266 */         pstmt.setNull(5, 12);
/*      */       else {
/*  268 */         pstmt.setString(5, getClientType());
/*      */       }
/*  270 */       if ((getClientIP() == null) || (getClientIP().equals("null")))
/*  271 */         pstmt.setNull(6, 12);
/*      */       else {
/*  273 */         pstmt.setString(6, getClientIP());
/*      */       }
/*  275 */       if ((getLoginDate() == null) || (getLoginDate().equals("null")))
/*  276 */         pstmt.setNull(7, 91);
/*      */       else {
/*  278 */         pstmt.setDate(7, Date.valueOf(getLoginDate()));
/*      */       }
/*  280 */       if ((getLoginTime() == null) || (getLoginTime().equals("null")))
/*  281 */         pstmt.setNull(8, 12);
/*      */       else {
/*  283 */         pstmt.setString(8, getLoginTime());
/*      */       }
/*  285 */       if ((getLogoutDate() == null) || (getLogoutDate().equals("null")))
/*  286 */         pstmt.setNull(9, 91);
/*      */       else {
/*  288 */         pstmt.setDate(9, Date.valueOf(getLogoutDate()));
/*      */       }
/*  290 */       if ((getLogoutTime() == null) || (getLogoutTime().equals("null")))
/*  291 */         pstmt.setNull(10, 12);
/*      */       else {
/*  293 */         pstmt.setString(10, getLogoutTime());
/*      */       }
/*      */ 
/*  296 */       pstmt.executeUpdate();
/*  297 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  300 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  301 */       CError tError = new CError();
/*  302 */       tError.moduleName = "MMapv2LoginLogDB";
/*  303 */       tError.functionName = "insert()";
/*  304 */       tError.errorMessage = ex.toString();
/*  305 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  308 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  311 */       if (!this.mflag)
/*      */         try {
/*  313 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  317 */       return false;
/*      */     }
/*      */ 
/*  320 */     if (!this.mflag)
/*      */       try {
/*  322 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  326 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  331 */     PreparedStatement pstmt = null;
/*  332 */     ResultSet rs = null;
/*      */ 
/*  334 */     if (!this.mflag) {
/*  335 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  340 */       pstmt = this.con.prepareStatement("SELECT * FROM MMapv2LoginLog WHERE  ID = ?", 
/*  341 */         1003, 1007);
/*  342 */       if ((getID() == null) || (getID().equals("null")))
/*  343 */         pstmt.setNull(1, 12);
/*      */       else {
/*  345 */         pstmt.setString(1, getID());
/*      */       }
/*  347 */       rs = pstmt.executeQuery();
/*  348 */       int i = 0;
/*  349 */       if (rs.next())
/*      */       {
/*  351 */         i++;
/*  352 */         if (!setSchema(rs, i))
/*      */         {
/*  355 */           CError tError = new CError();
/*  356 */           tError.moduleName = "MMapv2LoginLogDB";
/*  357 */           tError.functionName = "getInfo";
/*  358 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  359 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  361 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  364 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  368 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  372 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  376 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  379 */       if (i == 0)
/*      */       {
/*  381 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  385 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  389 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  395 */       CError tError = new CError();
/*  396 */       tError.moduleName = "MMapv2LoginLogDB";
/*  397 */       tError.functionName = "getInfo";
/*  398 */       tError.errorMessage = e.toString();
/*  399 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  401 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  404 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  408 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  412 */       return false;
/*      */     }
/*      */ 
/*  415 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  419 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  424 */     return true;
/*      */   }
/*      */ 
/*      */   public MMapv2LoginLogSet query()
/*      */   {
/*  429 */     Statement stmt = null;
/*  430 */     ResultSet rs = null;
/*  431 */     MMapv2LoginLogSet aMMapv2LoginLogSet = new MMapv2LoginLogSet();
/*      */ 
/*  433 */     if (!this.mflag) {
/*  434 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  439 */       stmt = this.con.createStatement(1003, 1007);
/*  440 */       SQLString sqlObj = new SQLString("MMapv2LoginLog");
/*  441 */       MMapv2LoginLogSchema aSchema = getSchema();
/*  442 */       sqlObj.setSQL(5, aSchema);
/*  443 */       String sql = sqlObj.getSQL();
/*      */ 
/*  445 */       rs = stmt.executeQuery(sql);
/*  446 */       int i = 0;
/*  447 */       while (rs.next())
/*      */       {
/*  449 */         i++;
/*  450 */         MMapv2LoginLogSchema s1 = new MMapv2LoginLogSchema();
/*  451 */         s1.setSchema(rs, i);
/*  452 */         aMMapv2LoginLogSet.add(s1);
/*      */       }try {
/*  454 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  460 */       CError tError = new CError();
/*  461 */       tError.moduleName = "MMapv2LoginLogDB";
/*  462 */       tError.functionName = "query";
/*  463 */       tError.errorMessage = e.toString();
/*  464 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  466 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  469 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  473 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  479 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  483 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  488 */     return aMMapv2LoginLogSet;
/*      */   }
/*      */ 
/*      */   public MMapv2LoginLogSet executeQuery(String sql)
/*      */   {
/*  493 */     Statement stmt = null;
/*  494 */     ResultSet rs = null;
/*  495 */     MMapv2LoginLogSet aMMapv2LoginLogSet = new MMapv2LoginLogSet();
/*      */ 
/*  497 */     if (!this.mflag) {
/*  498 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  503 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  505 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  506 */       int i = 0;
/*  507 */       while (rs.next())
/*      */       {
/*  509 */         i++;
/*  510 */         MMapv2LoginLogSchema s1 = new MMapv2LoginLogSchema();
/*  511 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  514 */           CError tError = new CError();
/*  515 */           tError.moduleName = "MMapv2LoginLogDB";
/*  516 */           tError.functionName = "executeQuery";
/*  517 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  518 */           this.mErrors.addOneError(tError);
/*      */         }
/*  520 */         aMMapv2LoginLogSet.add(s1);
/*      */       }try {
/*  522 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  528 */       CError tError = new CError();
/*  529 */       tError.moduleName = "MMapv2LoginLogDB";
/*  530 */       tError.functionName = "executeQuery";
/*  531 */       tError.errorMessage = e.toString();
/*  532 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  534 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  537 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  541 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  547 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  551 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  556 */     return aMMapv2LoginLogSet;
/*      */   }
/*      */ 
/*      */   public MMapv2LoginLogSet query(int nStart, int nCount)
/*      */   {
/*  561 */     Statement stmt = null;
/*  562 */     ResultSet rs = null;
/*  563 */     MMapv2LoginLogSet aMMapv2LoginLogSet = new MMapv2LoginLogSet();
/*      */ 
/*  565 */     if (!this.mflag) {
/*  566 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  571 */       stmt = this.con.createStatement(1003, 1007);
/*  572 */       SQLString sqlObj = new SQLString("MMapv2LoginLog");
/*  573 */       MMapv2LoginLogSchema aSchema = getSchema();
/*  574 */       sqlObj.setSQL(5, aSchema);
/*  575 */       String sql = sqlObj.getSQL();
/*      */ 
/*  577 */       rs = stmt.executeQuery(sql);
/*  578 */       int i = 0;
/*  579 */       while (rs.next())
/*      */       {
/*  581 */         i++;
/*      */ 
/*  583 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  587 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  591 */         MMapv2LoginLogSchema s1 = new MMapv2LoginLogSchema();
/*  592 */         s1.setSchema(rs, i);
/*  593 */         aMMapv2LoginLogSet.add(s1);
/*      */       }try {
/*  595 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  601 */       CError tError = new CError();
/*  602 */       tError.moduleName = "MMapv2LoginLogDB";
/*  603 */       tError.functionName = "query";
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
/*  629 */     return aMMapv2LoginLogSet;
/*      */   }
/*      */ 
/*      */   public MMapv2LoginLogSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  634 */     Statement stmt = null;
/*  635 */     ResultSet rs = null;
/*  636 */     MMapv2LoginLogSet aMMapv2LoginLogSet = new MMapv2LoginLogSet();
/*      */ 
/*  638 */     if (!this.mflag) {
/*  639 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  644 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  646 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  647 */       int i = 0;
/*  648 */       while (rs.next())
/*      */       {
/*  650 */         i++;
/*      */ 
/*  652 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  656 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  660 */         MMapv2LoginLogSchema s1 = new MMapv2LoginLogSchema();
/*  661 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  664 */           CError tError = new CError();
/*  665 */           tError.moduleName = "MMapv2LoginLogDB";
/*  666 */           tError.functionName = "executeQuery";
/*  667 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  668 */           this.mErrors.addOneError(tError);
/*      */         }
/*  670 */         aMMapv2LoginLogSet.add(s1);
/*      */       }try {
/*  672 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  678 */       CError tError = new CError();
/*  679 */       tError.moduleName = "MMapv2LoginLogDB";
/*  680 */       tError.functionName = "executeQuery";
/*  681 */       tError.errorMessage = e.toString();
/*  682 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  684 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  687 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  691 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  697 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  701 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  706 */     return aMMapv2LoginLogSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  711 */     Statement stmt = null;
/*      */ 
/*  713 */     if (!this.mflag) {
/*  714 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  719 */       stmt = this.con.createStatement(1003, 1007);
/*  720 */       SQLString sqlObj = new SQLString("MMapv2LoginLog");
/*  721 */       MMapv2LoginLogSchema aSchema = getSchema();
/*  722 */       sqlObj.setSQL(2, aSchema);
/*  723 */       String sql = "update MMapv2LoginLog " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  725 */       int operCount = stmt.executeUpdate(sql);
/*  726 */       if (operCount == 0)
/*      */       {
/*  729 */         CError tError = new CError();
/*  730 */         tError.moduleName = "MMapv2LoginLogDB";
/*  731 */         tError.functionName = "update";
/*  732 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  733 */         this.mErrors.addOneError(tError);
/*      */ 
/*  735 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  739 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  743 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  749 */       CError tError = new CError();
/*  750 */       tError.moduleName = "MMapv2LoginLogDB";
/*  751 */       tError.functionName = "update";
/*  752 */       tError.errorMessage = e.toString();
/*  753 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  755 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  757 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  761 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  765 */       return false;
/*      */     }
/*      */ 
/*  768 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  772 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  777 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  783 */     if (this.mResultSet != null)
/*      */     {
/*  786 */       CError tError = new CError();
/*  787 */       tError.moduleName = "MMapv2LoginLogDB";
/*  788 */       tError.functionName = "prepareData";
/*  789 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  790 */       this.mErrors.addOneError(tError);
/*  791 */       return false;
/*      */     }
/*      */ 
/*  794 */     if (!this.mflag)
/*      */     {
/*  796 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  800 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  801 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  806 */       CError tError = new CError();
/*  807 */       tError.moduleName = "MMapv2LoginLogDB";
/*  808 */       tError.functionName = "prepareData";
/*  809 */       tError.errorMessage = e.toString();
/*  810 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  813 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  819 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  823 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  827 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  832 */       return false;
/*      */     }
/*      */ 
/*  835 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  839 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  844 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  850 */     boolean flag = true;
/*  851 */     if (this.mResultSet == null)
/*      */     {
/*  853 */       CError tError = new CError();
/*  854 */       tError.moduleName = "MMapv2LoginLogDB";
/*  855 */       tError.functionName = "hasMoreData";
/*  856 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  857 */       this.mErrors.addOneError(tError);
/*  858 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  862 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  866 */       CError tError = new CError();
/*  867 */       tError.moduleName = "MMapv2LoginLogDB";
/*  868 */       tError.functionName = "hasMoreData";
/*  869 */       tError.errorMessage = ex.toString();
/*  870 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  873 */         this.mResultSet.close();
/*  874 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  880 */         this.mStatement.close();
/*  881 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  885 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  889 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  894 */       return false;
/*      */     }
/*  896 */     return flag;
/*      */   }
/*      */ 
/*      */   public MMapv2LoginLogSet getData()
/*      */   {
/*  901 */     int tCount = 0;
/*  902 */     MMapv2LoginLogSet tMMapv2LoginLogSet = new MMapv2LoginLogSet();
/*  903 */     MMapv2LoginLogSchema tMMapv2LoginLogSchema = null;
/*  904 */     if (this.mResultSet == null)
/*      */     {
/*  906 */       CError tError = new CError();
/*  907 */       tError.moduleName = "MMapv2LoginLogDB";
/*  908 */       tError.functionName = "getData";
/*  909 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  910 */       this.mErrors.addOneError(tError);
/*  911 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  915 */       tCount = 1;
/*  916 */       tMMapv2LoginLogSchema = new MMapv2LoginLogSchema();
/*  917 */       tMMapv2LoginLogSchema.setSchema(this.mResultSet, 1);
/*  918 */       tMMapv2LoginLogSet.add(tMMapv2LoginLogSchema);
/*      */ 
/*  920 */       while (tCount++ < 5000)
/*      */       {
/*  922 */         if (!this.mResultSet.next())
/*      */           continue;
/*  924 */         tMMapv2LoginLogSchema = new MMapv2LoginLogSchema();
/*  925 */         tMMapv2LoginLogSchema.setSchema(this.mResultSet, 1);
/*  926 */         tMMapv2LoginLogSet.add(tMMapv2LoginLogSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  932 */       CError tError = new CError();
/*  933 */       tError.moduleName = "MMapv2LoginLogDB";
/*  934 */       tError.functionName = "getData";
/*  935 */       tError.errorMessage = ex.toString();
/*  936 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  939 */         this.mResultSet.close();
/*  940 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  946 */         this.mStatement.close();
/*  947 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  951 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  955 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  960 */       return null;
/*      */     }
/*  962 */     return tMMapv2LoginLogSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  967 */     boolean flag = true;
/*      */     try
/*      */     {
/*  970 */       if (this.mResultSet == null)
/*      */       {
/*  972 */         CError tError = new CError();
/*  973 */         tError.moduleName = "MMapv2LoginLogDB";
/*  974 */         tError.functionName = "closeData";
/*  975 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/*  976 */         this.mErrors.addOneError(tError);
/*  977 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  981 */         this.mResultSet.close();
/*  982 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/*  987 */       CError tError = new CError();
/*  988 */       tError.moduleName = "MMapv2LoginLogDB";
/*  989 */       tError.functionName = "closeData";
/*  990 */       tError.errorMessage = ex2.toString();
/*  991 */       this.mErrors.addOneError(tError);
/*  992 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/*  996 */       if (this.mStatement == null)
/*      */       {
/*  998 */         CError tError = new CError();
/*  999 */         tError.moduleName = "MMapv2LoginLogDB";
/* 1000 */         tError.functionName = "closeData";
/* 1001 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1002 */         this.mErrors.addOneError(tError);
/* 1003 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1007 */         this.mStatement.close();
/* 1008 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1013 */       CError tError = new CError();
/* 1014 */       tError.moduleName = "MMapv2LoginLogDB";
/* 1015 */       tError.functionName = "closeData";
/* 1016 */       tError.errorMessage = ex3.toString();
/* 1017 */       this.mErrors.addOneError(tError);
/* 1018 */       flag = false;
/*      */     }
/* 1020 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MMapv2LoginLogDB
 * JD-Core Version:    0.6.0
 */