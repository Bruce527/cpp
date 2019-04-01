/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MUserRoleMapSchema;
/*      */ import com.sinosoft.map.lis.vschema.MUserRoleMapSet;
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
/*      */ public class MUserRoleMapDB extends MUserRoleMapSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*   23 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   25 */   private ResultSet mResultSet = null;
/*   26 */   private Statement mStatement = null;
/*      */ 
/*      */   public MUserRoleMapDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MUserRoleMap");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MUserRoleMap");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MUserRoleMapSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MUserRoleMapDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MUserRoleMapSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MUserRoleMapDB";
/*   74 */       tError.functionName = "getCount";
/*   75 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   76 */       this.mErrors.addOneError(tError);
/*      */ 
/*   78 */       return -1;
/*      */     }
/*      */ 
/*   81 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   86 */     PreparedStatement pstmt = null;
/*      */ 
/*   88 */     if (!this.mflag) {
/*   89 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MUserRoleMap WHERE  ID = ?");
/*   95 */       if ((getID() == null) || (getID().equals("null")))
/*   96 */         pstmt.setNull(1, 12);
/*      */       else {
/*   98 */         pstmt.setString(1, getID());
/*      */       }
/*  100 */       pstmt.executeUpdate();
/*  101 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "MUserRoleMapDB";
/*  107 */       tError.functionName = "delete()";
/*  108 */       tError.errorMessage = ex.toString();
/*  109 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  112 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  115 */       if (!this.mflag)
/*      */         try {
/*  117 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  121 */       return false;
/*      */     }
/*      */ 
/*  124 */     if (!this.mflag)
/*      */       try {
/*  126 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  130 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  135 */     PreparedStatement pstmt = null;
/*      */ 
/*  137 */     if (!this.mflag) {
/*  138 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MUserRoleMap SET  ID = ? , UserCode = ? , RoleID = ? , Type = ? , StartDate = ? , EndDate = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? WHERE  ID = ?");
/*  144 */       if ((getID() == null) || (getID().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getID());
/*      */       }
/*  149 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getUserCode());
/*      */       }
/*  154 */       if ((getRoleID() == null) || (getRoleID().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getRoleID());
/*      */       }
/*  159 */       if ((getType() == null) || (getType().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getType());
/*      */       }
/*  164 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  165 */         pstmt.setNull(5, 91);
/*      */       else {
/*  167 */         pstmt.setDate(5, Date.valueOf(getStartDate()));
/*      */       }
/*  169 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  170 */         pstmt.setNull(6, 91);
/*      */       else {
/*  172 */         pstmt.setDate(6, Date.valueOf(getEndDate()));
/*      */       }
/*  174 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getOperator());
/*      */       }
/*  179 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  180 */         pstmt.setNull(8, 91);
/*      */       else {
/*  182 */         pstmt.setDate(8, Date.valueOf(getMakeDate()));
/*      */       }
/*  184 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  185 */         pstmt.setNull(9, 12);
/*      */       else {
/*  187 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  189 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  190 */         pstmt.setNull(10, 91);
/*      */       else {
/*  192 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  194 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  195 */         pstmt.setNull(11, 12);
/*      */       else {
/*  197 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*  199 */       pstmt.setInt(12, getInt1());
/*  200 */       pstmt.setInt(13, getInt2());
/*  201 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  202 */         pstmt.setNull(14, 12);
/*      */       else {
/*  204 */         pstmt.setString(14, getVarc1());
/*      */       }
/*  206 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  207 */         pstmt.setNull(15, 12);
/*      */       else {
/*  209 */         pstmt.setString(15, getVarc2());
/*      */       }
/*      */ 
/*  212 */       if ((getID() == null) || (getID().equals("null")))
/*  213 */         pstmt.setNull(16, 12);
/*      */       else {
/*  215 */         pstmt.setString(16, getID());
/*      */       }
/*  217 */       pstmt.executeUpdate();
/*  218 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  221 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  222 */       CError tError = new CError();
/*  223 */       tError.moduleName = "MUserRoleMapDB";
/*  224 */       tError.functionName = "update()";
/*  225 */       tError.errorMessage = ex.toString();
/*  226 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  229 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  232 */       if (!this.mflag)
/*      */         try {
/*  234 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  238 */       return false;
/*      */     }
/*      */ 
/*  241 */     if (!this.mflag)
/*      */       try {
/*  243 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  247 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  252 */     PreparedStatement pstmt = null;
/*      */ 
/*  254 */     if (!this.mflag) {
/*  255 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  260 */       pstmt = this.con.prepareStatement("INSERT INTO MUserRoleMap VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  261 */       if ((getID() == null) || (getID().equals("null")))
/*  262 */         pstmt.setNull(1, 12);
/*      */       else {
/*  264 */         pstmt.setString(1, getID());
/*      */       }
/*  266 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  267 */         pstmt.setNull(2, 12);
/*      */       else {
/*  269 */         pstmt.setString(2, getUserCode());
/*      */       }
/*  271 */       if ((getRoleID() == null) || (getRoleID().equals("null")))
/*  272 */         pstmt.setNull(3, 12);
/*      */       else {
/*  274 */         pstmt.setString(3, getRoleID());
/*      */       }
/*  276 */       if ((getType() == null) || (getType().equals("null")))
/*  277 */         pstmt.setNull(4, 12);
/*      */       else {
/*  279 */         pstmt.setString(4, getType());
/*      */       }
/*  281 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  282 */         pstmt.setNull(5, 91);
/*      */       else {
/*  284 */         pstmt.setDate(5, Date.valueOf(getStartDate()));
/*      */       }
/*  286 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  287 */         pstmt.setNull(6, 91);
/*      */       else {
/*  289 */         pstmt.setDate(6, Date.valueOf(getEndDate()));
/*      */       }
/*  291 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  292 */         pstmt.setNull(7, 12);
/*      */       else {
/*  294 */         pstmt.setString(7, getOperator());
/*      */       }
/*  296 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  297 */         pstmt.setNull(8, 91);
/*      */       else {
/*  299 */         pstmt.setDate(8, Date.valueOf(getMakeDate()));
/*      */       }
/*  301 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  302 */         pstmt.setNull(9, 12);
/*      */       else {
/*  304 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  306 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  307 */         pstmt.setNull(10, 91);
/*      */       else {
/*  309 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  311 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  312 */         pstmt.setNull(11, 12);
/*      */       else {
/*  314 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*  316 */       pstmt.setInt(12, getInt1());
/*  317 */       pstmt.setInt(13, getInt2());
/*  318 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  319 */         pstmt.setNull(14, 12);
/*      */       else {
/*  321 */         pstmt.setString(14, getVarc1());
/*      */       }
/*  323 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  324 */         pstmt.setNull(15, 12);
/*      */       else {
/*  326 */         pstmt.setString(15, getVarc2());
/*      */       }
/*      */ 
/*  329 */       pstmt.executeUpdate();
/*  330 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  333 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  334 */       CError tError = new CError();
/*  335 */       tError.moduleName = "MUserRoleMapDB";
/*  336 */       tError.functionName = "insert()";
/*  337 */       tError.errorMessage = ex.toString();
/*  338 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  341 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  344 */       if (!this.mflag)
/*      */         try {
/*  346 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  350 */       return false;
/*      */     }
/*      */ 
/*  353 */     if (!this.mflag)
/*      */       try {
/*  355 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  359 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  364 */     PreparedStatement pstmt = null;
/*  365 */     ResultSet rs = null;
/*      */ 
/*  367 */     if (!this.mflag) {
/*  368 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  373 */       pstmt = this.con.prepareStatement("SELECT * FROM MUserRoleMap WHERE  ID = ?", 
/*  374 */         1003, 1007);
/*  375 */       if ((getID() == null) || (getID().equals("null")))
/*  376 */         pstmt.setNull(1, 12);
/*      */       else {
/*  378 */         pstmt.setString(1, getID());
/*      */       }
/*  380 */       rs = pstmt.executeQuery();
/*  381 */       int i = 0;
/*  382 */       if (rs.next())
/*      */       {
/*  384 */         i++;
/*  385 */         if (!setSchema(rs, i))
/*      */         {
/*  388 */           CError tError = new CError();
/*  389 */           tError.moduleName = "MUserRoleMapDB";
/*  390 */           tError.functionName = "getInfo";
/*  391 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  392 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  394 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  397 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  401 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  405 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  409 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  412 */       if (i == 0)
/*      */       {
/*  414 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  418 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  422 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  428 */       CError tError = new CError();
/*  429 */       tError.moduleName = "MUserRoleMapDB";
/*  430 */       tError.functionName = "getInfo";
/*  431 */       tError.errorMessage = e.toString();
/*  432 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  434 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  437 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  441 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  445 */       return false;
/*      */     }
/*      */ 
/*  448 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  452 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  457 */     return true;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapSet query()
/*      */   {
/*  462 */     Statement stmt = null;
/*  463 */     ResultSet rs = null;
/*  464 */     MUserRoleMapSet aMUserRoleMapSet = new MUserRoleMapSet();
/*      */ 
/*  466 */     if (!this.mflag) {
/*  467 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  472 */       stmt = this.con.createStatement(1003, 1007);
/*  473 */       SQLString sqlObj = new SQLString("MUserRoleMap");
/*  474 */       MUserRoleMapSchema aSchema = getSchema();
/*  475 */       sqlObj.setSQL(5, aSchema);
/*  476 */       String sql = sqlObj.getSQL();
/*      */ 
/*  478 */       rs = stmt.executeQuery(sql);
/*  479 */       int i = 0;
/*  480 */       while (rs.next())
/*      */       {
/*  482 */         i++;
/*  483 */         MUserRoleMapSchema s1 = new MUserRoleMapSchema();
/*  484 */         s1.setSchema(rs, i);
/*  485 */         aMUserRoleMapSet.add(s1);
/*      */       }try {
/*  487 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  493 */       CError tError = new CError();
/*  494 */       tError.moduleName = "MUserRoleMapDB";
/*  495 */       tError.functionName = "query";
/*  496 */       tError.errorMessage = e.toString();
/*  497 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  499 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  502 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  506 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  512 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  516 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  521 */     return aMUserRoleMapSet;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapSet executeQuery(String sql)
/*      */   {
/*  526 */     Statement stmt = null;
/*  527 */     ResultSet rs = null;
/*  528 */     MUserRoleMapSet aMUserRoleMapSet = new MUserRoleMapSet();
/*      */ 
/*  530 */     if (!this.mflag) {
/*  531 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  536 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  538 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  539 */       int i = 0;
/*  540 */       while (rs.next())
/*      */       {
/*  542 */         i++;
/*  543 */         MUserRoleMapSchema s1 = new MUserRoleMapSchema();
/*  544 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  547 */           CError tError = new CError();
/*  548 */           tError.moduleName = "MUserRoleMapDB";
/*  549 */           tError.functionName = "executeQuery";
/*  550 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  551 */           this.mErrors.addOneError(tError);
/*      */         }
/*  553 */         aMUserRoleMapSet.add(s1);
/*      */       }try {
/*  555 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  561 */       CError tError = new CError();
/*  562 */       tError.moduleName = "MUserRoleMapDB";
/*  563 */       tError.functionName = "executeQuery";
/*  564 */       tError.errorMessage = e.toString();
/*  565 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  567 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  570 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  574 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  580 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  584 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  589 */     return aMUserRoleMapSet;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapSet query(int nStart, int nCount)
/*      */   {
/*  594 */     Statement stmt = null;
/*  595 */     ResultSet rs = null;
/*  596 */     MUserRoleMapSet aMUserRoleMapSet = new MUserRoleMapSet();
/*      */ 
/*  598 */     if (!this.mflag) {
/*  599 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  604 */       stmt = this.con.createStatement(1003, 1007);
/*  605 */       SQLString sqlObj = new SQLString("MUserRoleMap");
/*  606 */       MUserRoleMapSchema aSchema = getSchema();
/*  607 */       sqlObj.setSQL(5, aSchema);
/*  608 */       String sql = sqlObj.getSQL();
/*      */ 
/*  610 */       rs = stmt.executeQuery(sql);
/*  611 */       int i = 0;
/*  612 */       while (rs.next())
/*      */       {
/*  614 */         i++;
/*      */ 
/*  616 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  620 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  624 */         MUserRoleMapSchema s1 = new MUserRoleMapSchema();
/*  625 */         s1.setSchema(rs, i);
/*  626 */         aMUserRoleMapSet.add(s1);
/*      */       }try {
/*  628 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  634 */       CError tError = new CError();
/*  635 */       tError.moduleName = "MUserRoleMapDB";
/*  636 */       tError.functionName = "query";
/*  637 */       tError.errorMessage = e.toString();
/*  638 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  640 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  643 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  647 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  653 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  657 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  662 */     return aMUserRoleMapSet;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  667 */     Statement stmt = null;
/*  668 */     ResultSet rs = null;
/*  669 */     MUserRoleMapSet aMUserRoleMapSet = new MUserRoleMapSet();
/*      */ 
/*  671 */     if (!this.mflag) {
/*  672 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  677 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  679 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  680 */       int i = 0;
/*  681 */       while (rs.next())
/*      */       {
/*  683 */         i++;
/*      */ 
/*  685 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  689 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  693 */         MUserRoleMapSchema s1 = new MUserRoleMapSchema();
/*  694 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  697 */           CError tError = new CError();
/*  698 */           tError.moduleName = "MUserRoleMapDB";
/*  699 */           tError.functionName = "executeQuery";
/*  700 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  701 */           this.mErrors.addOneError(tError);
/*      */         }
/*  703 */         aMUserRoleMapSet.add(s1);
/*      */       }try {
/*  705 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  711 */       CError tError = new CError();
/*  712 */       tError.moduleName = "MUserRoleMapDB";
/*  713 */       tError.functionName = "executeQuery";
/*  714 */       tError.errorMessage = e.toString();
/*  715 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  717 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  720 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  724 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  730 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  734 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  739 */     return aMUserRoleMapSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  744 */     Statement stmt = null;
/*      */ 
/*  746 */     if (!this.mflag) {
/*  747 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  752 */       stmt = this.con.createStatement(1003, 1007);
/*  753 */       SQLString sqlObj = new SQLString("MUserRoleMap");
/*  754 */       MUserRoleMapSchema aSchema = getSchema();
/*  755 */       sqlObj.setSQL(2, aSchema);
/*  756 */       String sql = "update MUserRoleMap " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  758 */       int operCount = stmt.executeUpdate(sql);
/*  759 */       if (operCount == 0)
/*      */       {
/*  762 */         CError tError = new CError();
/*  763 */         tError.moduleName = "MUserRoleMapDB";
/*  764 */         tError.functionName = "update";
/*  765 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  766 */         this.mErrors.addOneError(tError);
/*      */ 
/*  768 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  772 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  776 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  782 */       CError tError = new CError();
/*  783 */       tError.moduleName = "MUserRoleMapDB";
/*  784 */       tError.functionName = "update";
/*  785 */       tError.errorMessage = e.toString();
/*  786 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  788 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  790 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  794 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  798 */       return false;
/*      */     }
/*      */ 
/*  801 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  805 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  810 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  816 */     if (this.mResultSet != null)
/*      */     {
/*  819 */       CError tError = new CError();
/*  820 */       tError.moduleName = "MUserRoleMapDB";
/*  821 */       tError.functionName = "prepareData";
/*  822 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  823 */       this.mErrors.addOneError(tError);
/*  824 */       return false;
/*      */     }
/*      */ 
/*  827 */     if (!this.mflag)
/*      */     {
/*  829 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  833 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  834 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  839 */       CError tError = new CError();
/*  840 */       tError.moduleName = "MUserRoleMapDB";
/*  841 */       tError.functionName = "prepareData";
/*  842 */       tError.errorMessage = e.toString();
/*  843 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  846 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  852 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  856 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  860 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  865 */       return false;
/*      */     }
/*      */ 
/*  868 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  872 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  877 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  883 */     boolean flag = true;
/*  884 */     if (this.mResultSet == null)
/*      */     {
/*  886 */       CError tError = new CError();
/*  887 */       tError.moduleName = "MUserRoleMapDB";
/*  888 */       tError.functionName = "hasMoreData";
/*  889 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  890 */       this.mErrors.addOneError(tError);
/*  891 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  895 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  899 */       CError tError = new CError();
/*  900 */       tError.moduleName = "MUserRoleMapDB";
/*  901 */       tError.functionName = "hasMoreData";
/*  902 */       tError.errorMessage = ex.toString();
/*  903 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  906 */         this.mResultSet.close();
/*  907 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  913 */         this.mStatement.close();
/*  914 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  918 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  922 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  927 */       return false;
/*      */     }
/*  929 */     return flag;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapSet getData()
/*      */   {
/*  934 */     int tCount = 0;
/*  935 */     MUserRoleMapSet tMUserRoleMapSet = new MUserRoleMapSet();
/*  936 */     MUserRoleMapSchema tMUserRoleMapSchema = null;
/*  937 */     if (this.mResultSet == null)
/*      */     {
/*  939 */       CError tError = new CError();
/*  940 */       tError.moduleName = "MUserRoleMapDB";
/*  941 */       tError.functionName = "getData";
/*  942 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  943 */       this.mErrors.addOneError(tError);
/*  944 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  948 */       tCount = 1;
/*  949 */       tMUserRoleMapSchema = new MUserRoleMapSchema();
/*  950 */       tMUserRoleMapSchema.setSchema(this.mResultSet, 1);
/*  951 */       tMUserRoleMapSet.add(tMUserRoleMapSchema);
/*      */ 
/*  953 */       while (tCount++ < 5000)
/*      */       {
/*  955 */         if (!this.mResultSet.next())
/*      */           continue;
/*  957 */         tMUserRoleMapSchema = new MUserRoleMapSchema();
/*  958 */         tMUserRoleMapSchema.setSchema(this.mResultSet, 1);
/*  959 */         tMUserRoleMapSet.add(tMUserRoleMapSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  965 */       CError tError = new CError();
/*  966 */       tError.moduleName = "MUserRoleMapDB";
/*  967 */       tError.functionName = "getData";
/*  968 */       tError.errorMessage = ex.toString();
/*  969 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  972 */         this.mResultSet.close();
/*  973 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  979 */         this.mStatement.close();
/*  980 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  984 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  988 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  993 */       return null;
/*      */     }
/*  995 */     return tMUserRoleMapSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1000 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1003 */       if (this.mResultSet == null)
/*      */       {
/* 1005 */         CError tError = new CError();
/* 1006 */         tError.moduleName = "MUserRoleMapDB";
/* 1007 */         tError.functionName = "closeData";
/* 1008 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1009 */         this.mErrors.addOneError(tError);
/* 1010 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1014 */         this.mResultSet.close();
/* 1015 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1020 */       CError tError = new CError();
/* 1021 */       tError.moduleName = "MUserRoleMapDB";
/* 1022 */       tError.functionName = "closeData";
/* 1023 */       tError.errorMessage = ex2.toString();
/* 1024 */       this.mErrors.addOneError(tError);
/* 1025 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1029 */       if (this.mStatement == null)
/*      */       {
/* 1031 */         CError tError = new CError();
/* 1032 */         tError.moduleName = "MUserRoleMapDB";
/* 1033 */         tError.functionName = "closeData";
/* 1034 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1035 */         this.mErrors.addOneError(tError);
/* 1036 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1040 */         this.mStatement.close();
/* 1041 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1046 */       CError tError = new CError();
/* 1047 */       tError.moduleName = "MUserRoleMapDB";
/* 1048 */       tError.functionName = "closeData";
/* 1049 */       tError.errorMessage = ex3.toString();
/* 1050 */       this.mErrors.addOneError(tError);
/* 1051 */       flag = false;
/*      */     }
/* 1053 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MUserRoleMapDB
 * JD-Core Version:    0.6.0
 */