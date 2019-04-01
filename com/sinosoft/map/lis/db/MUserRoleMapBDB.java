/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MUserRoleMapBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MUserRoleMapBSet;
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
/*      */ public class MUserRoleMapBDB extends MUserRoleMapBSchema
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
/*      */   public MUserRoleMapBDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MUserRoleMapB");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapBDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MUserRoleMapB");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MUserRoleMapBSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MUserRoleMapBDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MUserRoleMapBSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MUserRoleMapBDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MUserRoleMapB WHERE  EdorNo = ?");
/*   95 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*   96 */         pstmt.setNull(1, 12);
/*      */       else {
/*   98 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  100 */       pstmt.executeUpdate();
/*  101 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "MUserRoleMapBDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MUserRoleMapB SET  ID = ? , UserCode = ? , RoleID = ? , Type = ? , StartDate = ? , EndDate = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
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
/*  160 */         pstmt.setNull(4, 1);
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
/*  211 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  212 */         pstmt.setNull(16, 12);
/*      */       else {
/*  214 */         pstmt.setString(16, getEdorNo());
/*      */       }
/*  216 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  217 */         pstmt.setNull(17, 12);
/*      */       else {
/*  219 */         pstmt.setString(17, getEdorType());
/*      */       }
/*  221 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  222 */         pstmt.setNull(18, 12);
/*      */       else {
/*  224 */         pstmt.setString(18, getEdorCase());
/*      */       }
/*  226 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  227 */         pstmt.setNull(19, 12);
/*      */       else {
/*  229 */         pstmt.setString(19, getOperator2());
/*      */       }
/*  231 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  232 */         pstmt.setNull(20, 91);
/*      */       else {
/*  234 */         pstmt.setDate(20, Date.valueOf(getMakeDate2()));
/*      */       }
/*  236 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  237 */         pstmt.setNull(21, 12);
/*      */       else {
/*  239 */         pstmt.setString(21, getMakeTime2());
/*      */       }
/*      */ 
/*  242 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  243 */         pstmt.setNull(22, 12);
/*      */       else {
/*  245 */         pstmt.setString(22, getEdorNo());
/*      */       }
/*  247 */       pstmt.executeUpdate();
/*  248 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  251 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  252 */       CError tError = new CError();
/*  253 */       tError.moduleName = "MUserRoleMapBDB";
/*  254 */       tError.functionName = "update()";
/*  255 */       tError.errorMessage = ex.toString();
/*  256 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  259 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  262 */       if (!this.mflag)
/*      */         try {
/*  264 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  268 */       return false;
/*      */     }
/*      */ 
/*  271 */     if (!this.mflag)
/*      */       try {
/*  273 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  277 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  282 */     PreparedStatement pstmt = null;
/*      */ 
/*  284 */     if (!this.mflag) {
/*  285 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  290 */       pstmt = this.con.prepareStatement("INSERT INTO MUserRoleMapB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  291 */       if ((getID() == null) || (getID().equals("null")))
/*  292 */         pstmt.setNull(1, 12);
/*      */       else {
/*  294 */         pstmt.setString(1, getID());
/*      */       }
/*  296 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  297 */         pstmt.setNull(2, 12);
/*      */       else {
/*  299 */         pstmt.setString(2, getUserCode());
/*      */       }
/*  301 */       if ((getRoleID() == null) || (getRoleID().equals("null")))
/*  302 */         pstmt.setNull(3, 12);
/*      */       else {
/*  304 */         pstmt.setString(3, getRoleID());
/*      */       }
/*  306 */       if ((getType() == null) || (getType().equals("null")))
/*  307 */         pstmt.setNull(4, 1);
/*      */       else {
/*  309 */         pstmt.setString(4, getType());
/*      */       }
/*  311 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  312 */         pstmt.setNull(5, 91);
/*      */       else {
/*  314 */         pstmt.setDate(5, Date.valueOf(getStartDate()));
/*      */       }
/*  316 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  317 */         pstmt.setNull(6, 91);
/*      */       else {
/*  319 */         pstmt.setDate(6, Date.valueOf(getEndDate()));
/*      */       }
/*  321 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  322 */         pstmt.setNull(7, 12);
/*      */       else {
/*  324 */         pstmt.setString(7, getOperator());
/*      */       }
/*  326 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  327 */         pstmt.setNull(8, 91);
/*      */       else {
/*  329 */         pstmt.setDate(8, Date.valueOf(getMakeDate()));
/*      */       }
/*  331 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  332 */         pstmt.setNull(9, 12);
/*      */       else {
/*  334 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  336 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  337 */         pstmt.setNull(10, 91);
/*      */       else {
/*  339 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  341 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  342 */         pstmt.setNull(11, 12);
/*      */       else {
/*  344 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*  346 */       pstmt.setInt(12, getInt1());
/*  347 */       pstmt.setInt(13, getInt2());
/*  348 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  349 */         pstmt.setNull(14, 12);
/*      */       else {
/*  351 */         pstmt.setString(14, getVarc1());
/*      */       }
/*  353 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  354 */         pstmt.setNull(15, 12);
/*      */       else {
/*  356 */         pstmt.setString(15, getVarc2());
/*      */       }
/*  358 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  359 */         pstmt.setNull(16, 12);
/*      */       else {
/*  361 */         pstmt.setString(16, getEdorNo());
/*      */       }
/*  363 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  364 */         pstmt.setNull(17, 12);
/*      */       else {
/*  366 */         pstmt.setString(17, getEdorType());
/*      */       }
/*  368 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  369 */         pstmt.setNull(18, 12);
/*      */       else {
/*  371 */         pstmt.setString(18, getEdorCase());
/*      */       }
/*  373 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  374 */         pstmt.setNull(19, 12);
/*      */       else {
/*  376 */         pstmt.setString(19, getOperator2());
/*      */       }
/*  378 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  379 */         pstmt.setNull(20, 91);
/*      */       else {
/*  381 */         pstmt.setDate(20, Date.valueOf(getMakeDate2()));
/*      */       }
/*  383 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  384 */         pstmt.setNull(21, 12);
/*      */       else {
/*  386 */         pstmt.setString(21, getMakeTime2());
/*      */       }
/*      */ 
/*  389 */       pstmt.executeUpdate();
/*  390 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  393 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  394 */       CError tError = new CError();
/*  395 */       tError.moduleName = "MUserRoleMapBDB";
/*  396 */       tError.functionName = "insert()";
/*  397 */       tError.errorMessage = ex.toString();
/*  398 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  401 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  404 */       if (!this.mflag)
/*      */         try {
/*  406 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  410 */       return false;
/*      */     }
/*      */ 
/*  413 */     if (!this.mflag)
/*      */       try {
/*  415 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  419 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  424 */     PreparedStatement pstmt = null;
/*  425 */     ResultSet rs = null;
/*      */ 
/*  427 */     if (!this.mflag) {
/*  428 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  433 */       pstmt = this.con.prepareStatement("SELECT * FROM MUserRoleMapB WHERE  EdorNo = ?", 
/*  434 */         1003, 1007);
/*  435 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  436 */         pstmt.setNull(1, 12);
/*      */       else {
/*  438 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  440 */       rs = pstmt.executeQuery();
/*  441 */       int i = 0;
/*  442 */       if (rs.next())
/*      */       {
/*  444 */         i++;
/*  445 */         if (!setSchema(rs, i))
/*      */         {
/*  448 */           CError tError = new CError();
/*  449 */           tError.moduleName = "MUserRoleMapBDB";
/*  450 */           tError.functionName = "getInfo";
/*  451 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  452 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  454 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  457 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  461 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  465 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  469 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  472 */       if (i == 0)
/*      */       {
/*  474 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  478 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  482 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  488 */       CError tError = new CError();
/*  489 */       tError.moduleName = "MUserRoleMapBDB";
/*  490 */       tError.functionName = "getInfo";
/*  491 */       tError.errorMessage = e.toString();
/*  492 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  494 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  497 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  501 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  505 */       return false;
/*      */     }
/*      */ 
/*  508 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  512 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  517 */     return true;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapBSet query()
/*      */   {
/*  522 */     Statement stmt = null;
/*  523 */     ResultSet rs = null;
/*  524 */     MUserRoleMapBSet aMUserRoleMapBSet = new MUserRoleMapBSet();
/*      */ 
/*  526 */     if (!this.mflag) {
/*  527 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  532 */       stmt = this.con.createStatement(1003, 1007);
/*  533 */       SQLString sqlObj = new SQLString("MUserRoleMapB");
/*  534 */       MUserRoleMapBSchema aSchema = getSchema();
/*  535 */       sqlObj.setSQL(5, aSchema);
/*  536 */       String sql = sqlObj.getSQL();
/*      */ 
/*  538 */       rs = stmt.executeQuery(sql);
/*  539 */       int i = 0;
/*  540 */       while (rs.next())
/*      */       {
/*  542 */         i++;
/*  543 */         MUserRoleMapBSchema s1 = new MUserRoleMapBSchema();
/*  544 */         s1.setSchema(rs, i);
/*  545 */         aMUserRoleMapBSet.add(s1);
/*      */       }try {
/*  547 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  553 */       CError tError = new CError();
/*  554 */       tError.moduleName = "MUserRoleMapBDB";
/*  555 */       tError.functionName = "query";
/*  556 */       tError.errorMessage = e.toString();
/*  557 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  559 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  562 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  566 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  572 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  576 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  581 */     return aMUserRoleMapBSet;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapBSet executeQuery(String sql)
/*      */   {
/*  586 */     Statement stmt = null;
/*  587 */     ResultSet rs = null;
/*  588 */     MUserRoleMapBSet aMUserRoleMapBSet = new MUserRoleMapBSet();
/*      */ 
/*  590 */     if (!this.mflag) {
/*  591 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  596 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  598 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  599 */       int i = 0;
/*  600 */       while (rs.next())
/*      */       {
/*  602 */         i++;
/*  603 */         MUserRoleMapBSchema s1 = new MUserRoleMapBSchema();
/*  604 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  607 */           CError tError = new CError();
/*  608 */           tError.moduleName = "MUserRoleMapBDB";
/*  609 */           tError.functionName = "executeQuery";
/*  610 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  611 */           this.mErrors.addOneError(tError);
/*      */         }
/*  613 */         aMUserRoleMapBSet.add(s1);
/*      */       }try {
/*  615 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  621 */       CError tError = new CError();
/*  622 */       tError.moduleName = "MUserRoleMapBDB";
/*  623 */       tError.functionName = "executeQuery";
/*  624 */       tError.errorMessage = e.toString();
/*  625 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  627 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  630 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  634 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  640 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  644 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  649 */     return aMUserRoleMapBSet;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapBSet query(int nStart, int nCount)
/*      */   {
/*  654 */     Statement stmt = null;
/*  655 */     ResultSet rs = null;
/*  656 */     MUserRoleMapBSet aMUserRoleMapBSet = new MUserRoleMapBSet();
/*      */ 
/*  658 */     if (!this.mflag) {
/*  659 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  664 */       stmt = this.con.createStatement(1003, 1007);
/*  665 */       SQLString sqlObj = new SQLString("MUserRoleMapB");
/*  666 */       MUserRoleMapBSchema aSchema = getSchema();
/*  667 */       sqlObj.setSQL(5, aSchema);
/*  668 */       String sql = sqlObj.getSQL();
/*      */ 
/*  670 */       rs = stmt.executeQuery(sql);
/*  671 */       int i = 0;
/*  672 */       while (rs.next())
/*      */       {
/*  674 */         i++;
/*      */ 
/*  676 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  680 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  684 */         MUserRoleMapBSchema s1 = new MUserRoleMapBSchema();
/*  685 */         s1.setSchema(rs, i);
/*  686 */         aMUserRoleMapBSet.add(s1);
/*      */       }try {
/*  688 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  694 */       CError tError = new CError();
/*  695 */       tError.moduleName = "MUserRoleMapBDB";
/*  696 */       tError.functionName = "query";
/*  697 */       tError.errorMessage = e.toString();
/*  698 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  700 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  703 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  707 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  713 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  717 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  722 */     return aMUserRoleMapBSet;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  727 */     Statement stmt = null;
/*  728 */     ResultSet rs = null;
/*  729 */     MUserRoleMapBSet aMUserRoleMapBSet = new MUserRoleMapBSet();
/*      */ 
/*  731 */     if (!this.mflag) {
/*  732 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  737 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  739 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  740 */       int i = 0;
/*  741 */       while (rs.next())
/*      */       {
/*  743 */         i++;
/*      */ 
/*  745 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  749 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  753 */         MUserRoleMapBSchema s1 = new MUserRoleMapBSchema();
/*  754 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  757 */           CError tError = new CError();
/*  758 */           tError.moduleName = "MUserRoleMapBDB";
/*  759 */           tError.functionName = "executeQuery";
/*  760 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  761 */           this.mErrors.addOneError(tError);
/*      */         }
/*  763 */         aMUserRoleMapBSet.add(s1);
/*      */       }try {
/*  765 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  771 */       CError tError = new CError();
/*  772 */       tError.moduleName = "MUserRoleMapBDB";
/*  773 */       tError.functionName = "executeQuery";
/*  774 */       tError.errorMessage = e.toString();
/*  775 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  777 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  780 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  784 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  790 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  794 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  799 */     return aMUserRoleMapBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  804 */     Statement stmt = null;
/*      */ 
/*  806 */     if (!this.mflag) {
/*  807 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  812 */       stmt = this.con.createStatement(1003, 1007);
/*  813 */       SQLString sqlObj = new SQLString("MUserRoleMapB");
/*  814 */       MUserRoleMapBSchema aSchema = getSchema();
/*  815 */       sqlObj.setSQL(2, aSchema);
/*  816 */       String sql = "update MUserRoleMapB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  818 */       int operCount = stmt.executeUpdate(sql);
/*  819 */       if (operCount == 0)
/*      */       {
/*  822 */         CError tError = new CError();
/*  823 */         tError.moduleName = "MUserRoleMapBDB";
/*  824 */         tError.functionName = "update";
/*  825 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  826 */         this.mErrors.addOneError(tError);
/*      */ 
/*  828 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  832 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  836 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  842 */       CError tError = new CError();
/*  843 */       tError.moduleName = "MUserRoleMapBDB";
/*  844 */       tError.functionName = "update";
/*  845 */       tError.errorMessage = e.toString();
/*  846 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  848 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  850 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  854 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  858 */       return false;
/*      */     }
/*      */ 
/*  861 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  865 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  870 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  876 */     if (this.mResultSet != null)
/*      */     {
/*  879 */       CError tError = new CError();
/*  880 */       tError.moduleName = "MUserRoleMapBDB";
/*  881 */       tError.functionName = "prepareData";
/*  882 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  883 */       this.mErrors.addOneError(tError);
/*  884 */       return false;
/*      */     }
/*      */ 
/*  887 */     if (!this.mflag)
/*      */     {
/*  889 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  893 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  894 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  899 */       CError tError = new CError();
/*  900 */       tError.moduleName = "MUserRoleMapBDB";
/*  901 */       tError.functionName = "prepareData";
/*  902 */       tError.errorMessage = e.toString();
/*  903 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  906 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  912 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  916 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  920 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  925 */       return false;
/*      */     }
/*      */ 
/*  928 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  932 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  937 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  943 */     boolean flag = true;
/*  944 */     if (this.mResultSet == null)
/*      */     {
/*  946 */       CError tError = new CError();
/*  947 */       tError.moduleName = "MUserRoleMapBDB";
/*  948 */       tError.functionName = "hasMoreData";
/*  949 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  950 */       this.mErrors.addOneError(tError);
/*  951 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  955 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  959 */       CError tError = new CError();
/*  960 */       tError.moduleName = "MUserRoleMapBDB";
/*  961 */       tError.functionName = "hasMoreData";
/*  962 */       tError.errorMessage = ex.toString();
/*  963 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  966 */         this.mResultSet.close();
/*  967 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  973 */         this.mStatement.close();
/*  974 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  978 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  982 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  987 */       return false;
/*      */     }
/*  989 */     return flag;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapBSet getData()
/*      */   {
/*  994 */     int tCount = 0;
/*  995 */     MUserRoleMapBSet tMUserRoleMapBSet = new MUserRoleMapBSet();
/*  996 */     MUserRoleMapBSchema tMUserRoleMapBSchema = null;
/*  997 */     if (this.mResultSet == null)
/*      */     {
/*  999 */       CError tError = new CError();
/* 1000 */       tError.moduleName = "MUserRoleMapBDB";
/* 1001 */       tError.functionName = "getData";
/* 1002 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1003 */       this.mErrors.addOneError(tError);
/* 1004 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1008 */       tCount = 1;
/* 1009 */       tMUserRoleMapBSchema = new MUserRoleMapBSchema();
/* 1010 */       tMUserRoleMapBSchema.setSchema(this.mResultSet, 1);
/* 1011 */       tMUserRoleMapBSet.add(tMUserRoleMapBSchema);
/*      */ 
/* 1013 */       while (tCount++ < 5000)
/*      */       {
/* 1015 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1017 */         tMUserRoleMapBSchema = new MUserRoleMapBSchema();
/* 1018 */         tMUserRoleMapBSchema.setSchema(this.mResultSet, 1);
/* 1019 */         tMUserRoleMapBSet.add(tMUserRoleMapBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1025 */       CError tError = new CError();
/* 1026 */       tError.moduleName = "MUserRoleMapBDB";
/* 1027 */       tError.functionName = "getData";
/* 1028 */       tError.errorMessage = ex.toString();
/* 1029 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1032 */         this.mResultSet.close();
/* 1033 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1039 */         this.mStatement.close();
/* 1040 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1044 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1048 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1053 */       return null;
/*      */     }
/* 1055 */     return tMUserRoleMapBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1060 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1063 */       if (this.mResultSet == null)
/*      */       {
/* 1065 */         CError tError = new CError();
/* 1066 */         tError.moduleName = "MUserRoleMapBDB";
/* 1067 */         tError.functionName = "closeData";
/* 1068 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1069 */         this.mErrors.addOneError(tError);
/* 1070 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1074 */         this.mResultSet.close();
/* 1075 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1080 */       CError tError = new CError();
/* 1081 */       tError.moduleName = "MUserRoleMapBDB";
/* 1082 */       tError.functionName = "closeData";
/* 1083 */       tError.errorMessage = ex2.toString();
/* 1084 */       this.mErrors.addOneError(tError);
/* 1085 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1089 */       if (this.mStatement == null)
/*      */       {
/* 1091 */         CError tError = new CError();
/* 1092 */         tError.moduleName = "MUserRoleMapBDB";
/* 1093 */         tError.functionName = "closeData";
/* 1094 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1095 */         this.mErrors.addOneError(tError);
/* 1096 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1100 */         this.mStatement.close();
/* 1101 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1106 */       CError tError = new CError();
/* 1107 */       tError.moduleName = "MUserRoleMapBDB";
/* 1108 */       tError.functionName = "closeData";
/* 1109 */       tError.errorMessage = ex3.toString();
/* 1110 */       this.mErrors.addOneError(tError);
/* 1111 */       flag = false;
/*      */     }
/* 1113 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MUserRoleMapBDB
 * JD-Core Version:    0.6.0
 */