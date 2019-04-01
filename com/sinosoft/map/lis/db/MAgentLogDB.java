/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MAgentLogSchema;
/*      */ import com.sinosoft.map.lis.vschema.MAgentLogSet;
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
/*      */ public class MAgentLogDB extends MAgentLogSchema
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
/*      */   public MAgentLogDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MAgentLog");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MAgentLogDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MAgentLog");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MAgentLogSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MAgentLogDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MAgentLogSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MAgentLogDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MAgentLog WHERE  ID = ?");
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
/*  107 */       tError.moduleName = "MAgentLogDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MAgentLog SET  ID = ? , AgentCode = ? , UserType = ? , TraceType = ? , MenuID = ? , MenuName = ? , Operation = ? , Discription = ? , CientIP = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
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
/*  160 */       if ((getTraceType() == null) || (getTraceType().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getTraceType());
/*      */       }
/*  165 */       if ((getMenuID() == null) || (getMenuID().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getMenuID());
/*      */       }
/*  170 */       if ((getMenuName() == null) || (getMenuName().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getMenuName());
/*      */       }
/*  175 */       if ((getOperation() == null) || (getOperation().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getOperation());
/*      */       }
/*  180 */       if ((getDiscription() == null) || (getDiscription().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getDiscription());
/*      */       }
/*  185 */       if ((getCientIP() == null) || (getCientIP().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getCientIP());
/*      */       }
/*  190 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  191 */         pstmt.setNull(10, 91);
/*      */       else {
/*  193 */         pstmt.setDate(10, Date.valueOf(getMakeDate()));
/*      */       }
/*  195 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  196 */         pstmt.setNull(11, 12);
/*      */       else {
/*  198 */         pstmt.setString(11, getMakeTime());
/*      */       }
/*      */ 
/*  201 */       if ((getID() == null) || (getID().equals("null")))
/*  202 */         pstmt.setNull(12, 12);
/*      */       else {
/*  204 */         pstmt.setString(12, getID());
/*      */       }
/*  206 */       pstmt.executeUpdate();
/*  207 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  210 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  211 */       CError tError = new CError();
/*  212 */       tError.moduleName = "MAgentLogDB";
/*  213 */       tError.functionName = "update()";
/*  214 */       tError.errorMessage = ex.toString();
/*  215 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  218 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  221 */       if (!this.mflag)
/*      */         try {
/*  223 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  227 */       return false;
/*      */     }
/*      */ 
/*  230 */     if (!this.mflag)
/*      */       try {
/*  232 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  236 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  241 */     PreparedStatement pstmt = null;
/*      */ 
/*  243 */     if (!this.mflag) {
/*  244 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  249 */       pstmt = this.con.prepareStatement("INSERT INTO MAgentLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  250 */       if ((getID() == null) || (getID().equals("null")))
/*  251 */         pstmt.setNull(1, 12);
/*      */       else {
/*  253 */         pstmt.setString(1, getID());
/*      */       }
/*  255 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  256 */         pstmt.setNull(2, 12);
/*      */       else {
/*  258 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  260 */       if ((getUserType() == null) || (getUserType().equals("null")))
/*  261 */         pstmt.setNull(3, 12);
/*      */       else {
/*  263 */         pstmt.setString(3, getUserType());
/*      */       }
/*  265 */       if ((getTraceType() == null) || (getTraceType().equals("null")))
/*  266 */         pstmt.setNull(4, 12);
/*      */       else {
/*  268 */         pstmt.setString(4, getTraceType());
/*      */       }
/*  270 */       if ((getMenuID() == null) || (getMenuID().equals("null")))
/*  271 */         pstmt.setNull(5, 12);
/*      */       else {
/*  273 */         pstmt.setString(5, getMenuID());
/*      */       }
/*  275 */       if ((getMenuName() == null) || (getMenuName().equals("null")))
/*  276 */         pstmt.setNull(6, 12);
/*      */       else {
/*  278 */         pstmt.setString(6, getMenuName());
/*      */       }
/*  280 */       if ((getOperation() == null) || (getOperation().equals("null")))
/*  281 */         pstmt.setNull(7, 12);
/*      */       else {
/*  283 */         pstmt.setString(7, getOperation());
/*      */       }
/*  285 */       if ((getDiscription() == null) || (getDiscription().equals("null")))
/*  286 */         pstmt.setNull(8, 12);
/*      */       else {
/*  288 */         pstmt.setString(8, getDiscription());
/*      */       }
/*  290 */       if ((getCientIP() == null) || (getCientIP().equals("null")))
/*  291 */         pstmt.setNull(9, 12);
/*      */       else {
/*  293 */         pstmt.setString(9, getCientIP());
/*      */       }
/*  295 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  296 */         pstmt.setNull(10, 91);
/*      */       else {
/*  298 */         pstmt.setDate(10, Date.valueOf(getMakeDate()));
/*      */       }
/*  300 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  301 */         pstmt.setNull(11, 12);
/*      */       else {
/*  303 */         pstmt.setString(11, getMakeTime());
/*      */       }
/*      */ 
/*  306 */       pstmt.executeUpdate();
/*  307 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  310 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  311 */       CError tError = new CError();
/*  312 */       tError.moduleName = "MAgentLogDB";
/*  313 */       tError.functionName = "insert()";
/*  314 */       tError.errorMessage = ex.toString();
/*  315 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  318 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  321 */       if (!this.mflag)
/*      */         try {
/*  323 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  327 */       return false;
/*      */     }
/*      */ 
/*  330 */     if (!this.mflag)
/*      */       try {
/*  332 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  336 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  341 */     PreparedStatement pstmt = null;
/*  342 */     ResultSet rs = null;
/*      */ 
/*  344 */     if (!this.mflag) {
/*  345 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  350 */       pstmt = this.con.prepareStatement("SELECT * FROM MAgentLog WHERE  ID = ?", 
/*  351 */         1003, 1007);
/*  352 */       if ((getID() == null) || (getID().equals("null")))
/*  353 */         pstmt.setNull(1, 12);
/*      */       else {
/*  355 */         pstmt.setString(1, getID());
/*      */       }
/*  357 */       rs = pstmt.executeQuery();
/*  358 */       int i = 0;
/*  359 */       if (rs.next())
/*      */       {
/*  361 */         i++;
/*  362 */         if (!setSchema(rs, i))
/*      */         {
/*  365 */           CError tError = new CError();
/*  366 */           tError.moduleName = "MAgentLogDB";
/*  367 */           tError.functionName = "getInfo";
/*  368 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  369 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  371 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  374 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  378 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  382 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  386 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  389 */       if (i == 0)
/*      */       {
/*  391 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  395 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  399 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  405 */       CError tError = new CError();
/*  406 */       tError.moduleName = "MAgentLogDB";
/*  407 */       tError.functionName = "getInfo";
/*  408 */       tError.errorMessage = e.toString();
/*  409 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  411 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  414 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  418 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  422 */       return false;
/*      */     }
/*      */ 
/*  425 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  429 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  434 */     return true;
/*      */   }
/*      */ 
/*      */   public MAgentLogSet query()
/*      */   {
/*  439 */     Statement stmt = null;
/*  440 */     ResultSet rs = null;
/*  441 */     MAgentLogSet aMAgentLogSet = new MAgentLogSet();
/*      */ 
/*  443 */     if (!this.mflag) {
/*  444 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  449 */       stmt = this.con.createStatement(1003, 1007);
/*  450 */       SQLString sqlObj = new SQLString("MAgentLog");
/*  451 */       MAgentLogSchema aSchema = getSchema();
/*  452 */       sqlObj.setSQL(5, aSchema);
/*  453 */       String sql = sqlObj.getSQL();
/*      */ 
/*  455 */       rs = stmt.executeQuery(sql);
/*  456 */       int i = 0;
/*  457 */       while (rs.next())
/*      */       {
/*  459 */         i++;
/*  460 */         MAgentLogSchema s1 = new MAgentLogSchema();
/*  461 */         s1.setSchema(rs, i);
/*  462 */         aMAgentLogSet.add(s1);
/*      */       }try {
/*  464 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  470 */       CError tError = new CError();
/*  471 */       tError.moduleName = "MAgentLogDB";
/*  472 */       tError.functionName = "query";
/*  473 */       tError.errorMessage = e.toString();
/*  474 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  476 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  479 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  483 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  489 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  493 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  498 */     return aMAgentLogSet;
/*      */   }
/*      */ 
/*      */   public MAgentLogSet executeQuery(String sql)
/*      */   {
/*  503 */     Statement stmt = null;
/*  504 */     ResultSet rs = null;
/*  505 */     MAgentLogSet aMAgentLogSet = new MAgentLogSet();
/*      */ 
/*  507 */     if (!this.mflag) {
/*  508 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  513 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  515 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  516 */       int i = 0;
/*  517 */       while (rs.next())
/*      */       {
/*  519 */         i++;
/*  520 */         MAgentLogSchema s1 = new MAgentLogSchema();
/*  521 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  524 */           CError tError = new CError();
/*  525 */           tError.moduleName = "MAgentLogDB";
/*  526 */           tError.functionName = "executeQuery";
/*  527 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  528 */           this.mErrors.addOneError(tError);
/*      */         }
/*  530 */         aMAgentLogSet.add(s1);
/*      */       }try {
/*  532 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  538 */       CError tError = new CError();
/*  539 */       tError.moduleName = "MAgentLogDB";
/*  540 */       tError.functionName = "executeQuery";
/*  541 */       tError.errorMessage = e.toString();
/*  542 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  544 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  547 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  551 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  557 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  561 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  566 */     return aMAgentLogSet;
/*      */   }
/*      */ 
/*      */   public MAgentLogSet query(int nStart, int nCount)
/*      */   {
/*  571 */     Statement stmt = null;
/*  572 */     ResultSet rs = null;
/*  573 */     MAgentLogSet aMAgentLogSet = new MAgentLogSet();
/*      */ 
/*  575 */     if (!this.mflag) {
/*  576 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  581 */       stmt = this.con.createStatement(1003, 1007);
/*  582 */       SQLString sqlObj = new SQLString("MAgentLog");
/*  583 */       MAgentLogSchema aSchema = getSchema();
/*  584 */       sqlObj.setSQL(5, aSchema);
/*  585 */       String sql = sqlObj.getSQL();
/*      */ 
/*  587 */       rs = stmt.executeQuery(sql);
/*  588 */       int i = 0;
/*  589 */       while (rs.next())
/*      */       {
/*  591 */         i++;
/*      */ 
/*  593 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  597 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  601 */         MAgentLogSchema s1 = new MAgentLogSchema();
/*  602 */         s1.setSchema(rs, i);
/*  603 */         aMAgentLogSet.add(s1);
/*      */       }try {
/*  605 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  611 */       CError tError = new CError();
/*  612 */       tError.moduleName = "MAgentLogDB";
/*  613 */       tError.functionName = "query";
/*  614 */       tError.errorMessage = e.toString();
/*  615 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  617 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  620 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  624 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  630 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  634 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  639 */     return aMAgentLogSet;
/*      */   }
/*      */ 
/*      */   public MAgentLogSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  644 */     Statement stmt = null;
/*  645 */     ResultSet rs = null;
/*  646 */     MAgentLogSet aMAgentLogSet = new MAgentLogSet();
/*      */ 
/*  648 */     if (!this.mflag) {
/*  649 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  654 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  656 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  657 */       int i = 0;
/*  658 */       while (rs.next())
/*      */       {
/*  660 */         i++;
/*      */ 
/*  662 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  666 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  670 */         MAgentLogSchema s1 = new MAgentLogSchema();
/*  671 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  674 */           CError tError = new CError();
/*  675 */           tError.moduleName = "MAgentLogDB";
/*  676 */           tError.functionName = "executeQuery";
/*  677 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  678 */           this.mErrors.addOneError(tError);
/*      */         }
/*  680 */         aMAgentLogSet.add(s1);
/*      */       }try {
/*  682 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  688 */       CError tError = new CError();
/*  689 */       tError.moduleName = "MAgentLogDB";
/*  690 */       tError.functionName = "executeQuery";
/*  691 */       tError.errorMessage = e.toString();
/*  692 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  694 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  697 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  701 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  707 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  711 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  716 */     return aMAgentLogSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  721 */     Statement stmt = null;
/*      */ 
/*  723 */     if (!this.mflag) {
/*  724 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  729 */       stmt = this.con.createStatement(1003, 1007);
/*  730 */       SQLString sqlObj = new SQLString("MAgentLog");
/*  731 */       MAgentLogSchema aSchema = getSchema();
/*  732 */       sqlObj.setSQL(2, aSchema);
/*  733 */       String sql = "update MAgentLog " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  735 */       int operCount = stmt.executeUpdate(sql);
/*  736 */       if (operCount == 0)
/*      */       {
/*  739 */         CError tError = new CError();
/*  740 */         tError.moduleName = "MAgentLogDB";
/*  741 */         tError.functionName = "update";
/*  742 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  743 */         this.mErrors.addOneError(tError);
/*      */ 
/*  745 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  749 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  753 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  759 */       CError tError = new CError();
/*  760 */       tError.moduleName = "MAgentLogDB";
/*  761 */       tError.functionName = "update";
/*  762 */       tError.errorMessage = e.toString();
/*  763 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  765 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  767 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  771 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  775 */       return false;
/*      */     }
/*      */ 
/*  778 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  782 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  787 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  793 */     if (this.mResultSet != null)
/*      */     {
/*  796 */       CError tError = new CError();
/*  797 */       tError.moduleName = "MAgentLogDB";
/*  798 */       tError.functionName = "prepareData";
/*  799 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  800 */       this.mErrors.addOneError(tError);
/*  801 */       return false;
/*      */     }
/*      */ 
/*  804 */     if (!this.mflag)
/*      */     {
/*  806 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  810 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  811 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  816 */       CError tError = new CError();
/*  817 */       tError.moduleName = "MAgentLogDB";
/*  818 */       tError.functionName = "prepareData";
/*  819 */       tError.errorMessage = e.toString();
/*  820 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  823 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  829 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  833 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  837 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  842 */       return false;
/*      */     }
/*      */ 
/*  845 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  849 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  854 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  860 */     boolean flag = true;
/*  861 */     if (this.mResultSet == null)
/*      */     {
/*  863 */       CError tError = new CError();
/*  864 */       tError.moduleName = "MAgentLogDB";
/*  865 */       tError.functionName = "hasMoreData";
/*  866 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  867 */       this.mErrors.addOneError(tError);
/*  868 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  872 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  876 */       CError tError = new CError();
/*  877 */       tError.moduleName = "MAgentLogDB";
/*  878 */       tError.functionName = "hasMoreData";
/*  879 */       tError.errorMessage = ex.toString();
/*  880 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  883 */         this.mResultSet.close();
/*  884 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  890 */         this.mStatement.close();
/*  891 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  895 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  899 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  904 */       return false;
/*      */     }
/*  906 */     return flag;
/*      */   }
/*      */ 
/*      */   public MAgentLogSet getData()
/*      */   {
/*  911 */     int tCount = 0;
/*  912 */     MAgentLogSet tMAgentLogSet = new MAgentLogSet();
/*  913 */     MAgentLogSchema tMAgentLogSchema = null;
/*  914 */     if (this.mResultSet == null)
/*      */     {
/*  916 */       CError tError = new CError();
/*  917 */       tError.moduleName = "MAgentLogDB";
/*  918 */       tError.functionName = "getData";
/*  919 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  920 */       this.mErrors.addOneError(tError);
/*  921 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  925 */       tCount = 1;
/*  926 */       tMAgentLogSchema = new MAgentLogSchema();
/*  927 */       tMAgentLogSchema.setSchema(this.mResultSet, 1);
/*  928 */       tMAgentLogSet.add(tMAgentLogSchema);
/*      */ 
/*  930 */       while (tCount++ < 5000)
/*      */       {
/*  932 */         if (!this.mResultSet.next())
/*      */           continue;
/*  934 */         tMAgentLogSchema = new MAgentLogSchema();
/*  935 */         tMAgentLogSchema.setSchema(this.mResultSet, 1);
/*  936 */         tMAgentLogSet.add(tMAgentLogSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  942 */       CError tError = new CError();
/*  943 */       tError.moduleName = "MAgentLogDB";
/*  944 */       tError.functionName = "getData";
/*  945 */       tError.errorMessage = ex.toString();
/*  946 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  949 */         this.mResultSet.close();
/*  950 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  956 */         this.mStatement.close();
/*  957 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  961 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  965 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  970 */       return null;
/*      */     }
/*  972 */     return tMAgentLogSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  977 */     boolean flag = true;
/*      */     try
/*      */     {
/*  980 */       if (this.mResultSet == null)
/*      */       {
/*  982 */         CError tError = new CError();
/*  983 */         tError.moduleName = "MAgentLogDB";
/*  984 */         tError.functionName = "closeData";
/*  985 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/*  986 */         this.mErrors.addOneError(tError);
/*  987 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  991 */         this.mResultSet.close();
/*  992 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/*  997 */       CError tError = new CError();
/*  998 */       tError.moduleName = "MAgentLogDB";
/*  999 */       tError.functionName = "closeData";
/* 1000 */       tError.errorMessage = ex2.toString();
/* 1001 */       this.mErrors.addOneError(tError);
/* 1002 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1006 */       if (this.mStatement == null)
/*      */       {
/* 1008 */         CError tError = new CError();
/* 1009 */         tError.moduleName = "MAgentLogDB";
/* 1010 */         tError.functionName = "closeData";
/* 1011 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1012 */         this.mErrors.addOneError(tError);
/* 1013 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1017 */         this.mStatement.close();
/* 1018 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1023 */       CError tError = new CError();
/* 1024 */       tError.moduleName = "MAgentLogDB";
/* 1025 */       tError.functionName = "closeData";
/* 1026 */       tError.errorMessage = ex3.toString();
/* 1027 */       this.mErrors.addOneError(tError);
/* 1028 */       flag = false;
/*      */     }
/* 1030 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MAgentLogDB
 * JD-Core Version:    0.6.0
 */