/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MUserSchema;
/*      */ import com.sinosoft.map.lis.vschema.MUserSet;
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
/*      */ public class MUserDB extends MUserSchema
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
/*      */   public MUserDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MUser");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MUserDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MUser");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MUserSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MUserDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MUserSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MUserDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MUser WHERE  UserCode = ?");
/*   95 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*   96 */         pstmt.setNull(1, 12);
/*      */       else {
/*   98 */         pstmt.setString(1, getUserCode());
/*      */       }
/*  100 */       pstmt.executeUpdate();
/*  101 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "MUserDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MUser SET  UserCode = ? , UserName = ? , ManageCom = ? , BranchType = ? , Password = ? , PwdModifyDate = ? , UserDescription = ? , UserState = ? , SuperPopedomFlag = ? , ValidStartDate = ? , ValidEndDate = ? , StuffNo = ? , OfficePhone = ? , Phone = ? , EMail = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  UserCode = ?");
/*  144 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getUserCode());
/*      */       }
/*  149 */       if ((getUserName() == null) || (getUserName().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getUserName());
/*      */       }
/*  154 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  159 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  164 */       if ((getPassword() == null) || (getPassword().equals("null")))
/*  165 */         pstmt.setNull(5, 12);
/*      */       else {
/*  167 */         pstmt.setString(5, getPassword());
/*      */       }
/*  169 */       if ((getPwdModifyDate() == null) || (getPwdModifyDate().equals("null")))
/*  170 */         pstmt.setNull(6, 91);
/*      */       else {
/*  172 */         pstmt.setDate(6, Date.valueOf(getPwdModifyDate()));
/*      */       }
/*  174 */       if ((getUserDescription() == null) || (getUserDescription().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getUserDescription());
/*      */       }
/*  179 */       if ((getUserState() == null) || (getUserState().equals("null")))
/*  180 */         pstmt.setNull(8, 12);
/*      */       else {
/*  182 */         pstmt.setString(8, getUserState());
/*      */       }
/*  184 */       if ((getSuperPopedomFlag() == null) || (getSuperPopedomFlag().equals("null")))
/*  185 */         pstmt.setNull(9, 12);
/*      */       else {
/*  187 */         pstmt.setString(9, getSuperPopedomFlag());
/*      */       }
/*  189 */       if ((getValidStartDate() == null) || (getValidStartDate().equals("null")))
/*  190 */         pstmt.setNull(10, 91);
/*      */       else {
/*  192 */         pstmt.setDate(10, Date.valueOf(getValidStartDate()));
/*      */       }
/*  194 */       if ((getValidEndDate() == null) || (getValidEndDate().equals("null")))
/*  195 */         pstmt.setNull(11, 91);
/*      */       else {
/*  197 */         pstmt.setDate(11, Date.valueOf(getValidEndDate()));
/*      */       }
/*  199 */       if ((getStuffNo() == null) || (getStuffNo().equals("null")))
/*  200 */         pstmt.setNull(12, 12);
/*      */       else {
/*  202 */         pstmt.setString(12, getStuffNo());
/*      */       }
/*  204 */       if ((getOfficePhone() == null) || (getOfficePhone().equals("null")))
/*  205 */         pstmt.setNull(13, 12);
/*      */       else {
/*  207 */         pstmt.setString(13, getOfficePhone());
/*      */       }
/*  209 */       if ((getPhone() == null) || (getPhone().equals("null")))
/*  210 */         pstmt.setNull(14, 12);
/*      */       else {
/*  212 */         pstmt.setString(14, getPhone());
/*      */       }
/*  214 */       if ((getEMail() == null) || (getEMail().equals("null")))
/*  215 */         pstmt.setNull(15, 12);
/*      */       else {
/*  217 */         pstmt.setString(15, getEMail());
/*      */       }
/*  219 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  220 */         pstmt.setNull(16, 12);
/*      */       else {
/*  222 */         pstmt.setString(16, getOperator());
/*      */       }
/*  224 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  225 */         pstmt.setNull(17, 12);
/*      */       else {
/*  227 */         pstmt.setString(17, getModifyOperator());
/*      */       }
/*  229 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  230 */         pstmt.setNull(18, 91);
/*      */       else {
/*  232 */         pstmt.setDate(18, Date.valueOf(getMakeDate()));
/*      */       }
/*  234 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  235 */         pstmt.setNull(19, 12);
/*      */       else {
/*  237 */         pstmt.setString(19, getMakeTime());
/*      */       }
/*  239 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  240 */         pstmt.setNull(20, 91);
/*      */       else {
/*  242 */         pstmt.setDate(20, Date.valueOf(getModifyDate()));
/*      */       }
/*  244 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  245 */         pstmt.setNull(21, 12);
/*      */       else {
/*  247 */         pstmt.setString(21, getModifyTime());
/*      */       }
/*      */ 
/*  250 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  251 */         pstmt.setNull(22, 12);
/*      */       else {
/*  253 */         pstmt.setString(22, getUserCode());
/*      */       }
/*  255 */       pstmt.executeUpdate();
/*  256 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  259 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  260 */       CError tError = new CError();
/*  261 */       tError.moduleName = "MUserDB";
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
/*  298 */       pstmt = this.con.prepareStatement("INSERT INTO MUser VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  299 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  300 */         pstmt.setNull(1, 12);
/*      */       else {
/*  302 */         pstmt.setString(1, getUserCode());
/*      */       }
/*  304 */       if ((getUserName() == null) || (getUserName().equals("null")))
/*  305 */         pstmt.setNull(2, 12);
/*      */       else {
/*  307 */         pstmt.setString(2, getUserName());
/*      */       }
/*  309 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  310 */         pstmt.setNull(3, 12);
/*      */       else {
/*  312 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  314 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  315 */         pstmt.setNull(4, 12);
/*      */       else {
/*  317 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  319 */       if ((getPassword() == null) || (getPassword().equals("null")))
/*  320 */         pstmt.setNull(5, 12);
/*      */       else {
/*  322 */         pstmt.setString(5, getPassword());
/*      */       }
/*  324 */       if ((getPwdModifyDate() == null) || (getPwdModifyDate().equals("null")))
/*  325 */         pstmt.setNull(6, 91);
/*      */       else {
/*  327 */         pstmt.setDate(6, Date.valueOf(getPwdModifyDate()));
/*      */       }
/*  329 */       if ((getUserDescription() == null) || (getUserDescription().equals("null")))
/*  330 */         pstmt.setNull(7, 12);
/*      */       else {
/*  332 */         pstmt.setString(7, getUserDescription());
/*      */       }
/*  334 */       if ((getUserState() == null) || (getUserState().equals("null")))
/*  335 */         pstmt.setNull(8, 12);
/*      */       else {
/*  337 */         pstmt.setString(8, getUserState());
/*      */       }
/*  339 */       if ((getSuperPopedomFlag() == null) || (getSuperPopedomFlag().equals("null")))
/*  340 */         pstmt.setNull(9, 12);
/*      */       else {
/*  342 */         pstmt.setString(9, getSuperPopedomFlag());
/*      */       }
/*  344 */       if ((getValidStartDate() == null) || (getValidStartDate().equals("null")))
/*  345 */         pstmt.setNull(10, 91);
/*      */       else {
/*  347 */         pstmt.setDate(10, Date.valueOf(getValidStartDate()));
/*      */       }
/*  349 */       if ((getValidEndDate() == null) || (getValidEndDate().equals("null")))
/*  350 */         pstmt.setNull(11, 91);
/*      */       else {
/*  352 */         pstmt.setDate(11, Date.valueOf(getValidEndDate()));
/*      */       }
/*  354 */       if ((getStuffNo() == null) || (getStuffNo().equals("null")))
/*  355 */         pstmt.setNull(12, 12);
/*      */       else {
/*  357 */         pstmt.setString(12, getStuffNo());
/*      */       }
/*  359 */       if ((getOfficePhone() == null) || (getOfficePhone().equals("null")))
/*  360 */         pstmt.setNull(13, 12);
/*      */       else {
/*  362 */         pstmt.setString(13, getOfficePhone());
/*      */       }
/*  364 */       if ((getPhone() == null) || (getPhone().equals("null")))
/*  365 */         pstmt.setNull(14, 12);
/*      */       else {
/*  367 */         pstmt.setString(14, getPhone());
/*      */       }
/*  369 */       if ((getEMail() == null) || (getEMail().equals("null")))
/*  370 */         pstmt.setNull(15, 12);
/*      */       else {
/*  372 */         pstmt.setString(15, getEMail());
/*      */       }
/*  374 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  375 */         pstmt.setNull(16, 12);
/*      */       else {
/*  377 */         pstmt.setString(16, getOperator());
/*      */       }
/*  379 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  380 */         pstmt.setNull(17, 12);
/*      */       else {
/*  382 */         pstmt.setString(17, getModifyOperator());
/*      */       }
/*  384 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  385 */         pstmt.setNull(18, 91);
/*      */       else {
/*  387 */         pstmt.setDate(18, Date.valueOf(getMakeDate()));
/*      */       }
/*  389 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  390 */         pstmt.setNull(19, 12);
/*      */       else {
/*  392 */         pstmt.setString(19, getMakeTime());
/*      */       }
/*  394 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  395 */         pstmt.setNull(20, 91);
/*      */       else {
/*  397 */         pstmt.setDate(20, Date.valueOf(getModifyDate()));
/*      */       }
/*  399 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  400 */         pstmt.setNull(21, 12);
/*      */       else {
/*  402 */         pstmt.setString(21, getModifyTime());
/*      */       }
/*      */ 
/*  405 */       pstmt.executeUpdate();
/*  406 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  409 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  410 */       CError tError = new CError();
/*  411 */       tError.moduleName = "MUserDB";
/*  412 */       tError.functionName = "insert()";
/*  413 */       tError.errorMessage = ex.toString();
/*  414 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  417 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  420 */       if (!this.mflag)
/*      */         try {
/*  422 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  426 */       return false;
/*      */     }
/*      */ 
/*  429 */     if (!this.mflag)
/*      */       try {
/*  431 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  435 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  440 */     PreparedStatement pstmt = null;
/*  441 */     ResultSet rs = null;
/*      */ 
/*  443 */     if (!this.mflag) {
/*  444 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  449 */       pstmt = this.con.prepareStatement("SELECT * FROM MUser WHERE  UserCode = ?", 
/*  450 */         1003, 1007);
/*  451 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  452 */         pstmt.setNull(1, 12);
/*      */       else {
/*  454 */         pstmt.setString(1, getUserCode());
/*      */       }
/*  456 */       rs = pstmt.executeQuery();
/*  457 */       int i = 0;
/*  458 */       if (rs.next())
/*      */       {
/*  460 */         i++;
/*  461 */         if (!setSchema(rs, i))
/*      */         {
/*  464 */           CError tError = new CError();
/*  465 */           tError.moduleName = "MUserDB";
/*  466 */           tError.functionName = "getInfo";
/*  467 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  468 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  470 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  473 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  477 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  481 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  485 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  488 */       if (i == 0)
/*      */       {
/*  490 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  494 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  498 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  504 */       CError tError = new CError();
/*  505 */       tError.moduleName = "MUserDB";
/*  506 */       tError.functionName = "getInfo";
/*  507 */       tError.errorMessage = e.toString();
/*  508 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  510 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  513 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  517 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  521 */       return false;
/*      */     }
/*      */ 
/*  524 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  528 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  533 */     return true;
/*      */   }
/*      */ 
/*      */   public MUserSet query()
/*      */   {
/*  538 */     Statement stmt = null;
/*  539 */     ResultSet rs = null;
/*  540 */     MUserSet aMUserSet = new MUserSet();
/*      */ 
/*  542 */     if (!this.mflag) {
/*  543 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  548 */       stmt = this.con.createStatement(1003, 1007);
/*  549 */       SQLString sqlObj = new SQLString("MUser");
/*  550 */       MUserSchema aSchema = getSchema();
/*  551 */       sqlObj.setSQL(5, aSchema);
/*  552 */       String sql = sqlObj.getSQL();
/*      */ 
/*  554 */       rs = stmt.executeQuery(sql);
/*  555 */       int i = 0;
/*  556 */       while (rs.next())
/*      */       {
/*  558 */         i++;
/*  559 */         MUserSchema s1 = new MUserSchema();
/*  560 */         s1.setSchema(rs, i);
/*  561 */         aMUserSet.add(s1);
/*      */       }try {
/*  563 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  569 */       CError tError = new CError();
/*  570 */       tError.moduleName = "MUserDB";
/*  571 */       tError.functionName = "query";
/*  572 */       tError.errorMessage = e.toString();
/*  573 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  575 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  578 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  582 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  588 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  592 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  597 */     return aMUserSet;
/*      */   }
/*      */ 
/*      */   public MUserSet executeQuery(String sql)
/*      */   {
/*  602 */     Statement stmt = null;
/*  603 */     ResultSet rs = null;
/*  604 */     MUserSet aMUserSet = new MUserSet();
/*      */ 
/*  606 */     if (!this.mflag) {
/*  607 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  612 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  614 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  615 */       int i = 0;
/*  616 */       while (rs.next())
/*      */       {
/*  618 */         i++;
/*  619 */         MUserSchema s1 = new MUserSchema();
/*  620 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  623 */           CError tError = new CError();
/*  624 */           tError.moduleName = "MUserDB";
/*  625 */           tError.functionName = "executeQuery";
/*  626 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  627 */           this.mErrors.addOneError(tError);
/*      */         }
/*  629 */         aMUserSet.add(s1);
/*      */       }try {
/*  631 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  637 */       CError tError = new CError();
/*  638 */       tError.moduleName = "MUserDB";
/*  639 */       tError.functionName = "executeQuery";
/*  640 */       tError.errorMessage = e.toString();
/*  641 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  643 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  646 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  650 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  656 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  660 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  665 */     return aMUserSet;
/*      */   }
/*      */ 
/*      */   public MUserSet query(int nStart, int nCount)
/*      */   {
/*  670 */     Statement stmt = null;
/*  671 */     ResultSet rs = null;
/*  672 */     MUserSet aMUserSet = new MUserSet();
/*      */ 
/*  674 */     if (!this.mflag) {
/*  675 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  680 */       stmt = this.con.createStatement(1003, 1007);
/*  681 */       SQLString sqlObj = new SQLString("MUser");
/*  682 */       MUserSchema aSchema = getSchema();
/*  683 */       sqlObj.setSQL(5, aSchema);
/*  684 */       String sql = sqlObj.getSQL();
/*      */ 
/*  686 */       rs = stmt.executeQuery(sql);
/*  687 */       int i = 0;
/*  688 */       while (rs.next())
/*      */       {
/*  690 */         i++;
/*      */ 
/*  692 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  696 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  700 */         MUserSchema s1 = new MUserSchema();
/*  701 */         s1.setSchema(rs, i);
/*  702 */         aMUserSet.add(s1);
/*      */       }try {
/*  704 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  710 */       CError tError = new CError();
/*  711 */       tError.moduleName = "MUserDB";
/*  712 */       tError.functionName = "query";
/*  713 */       tError.errorMessage = e.toString();
/*  714 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  716 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  719 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  723 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  729 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  733 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  738 */     return aMUserSet;
/*      */   }
/*      */ 
/*      */   public MUserSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  743 */     Statement stmt = null;
/*  744 */     ResultSet rs = null;
/*  745 */     MUserSet aMUserSet = new MUserSet();
/*      */ 
/*  747 */     if (!this.mflag) {
/*  748 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  753 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  755 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  756 */       int i = 0;
/*  757 */       while (rs.next())
/*      */       {
/*  759 */         i++;
/*      */ 
/*  761 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  765 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  769 */         MUserSchema s1 = new MUserSchema();
/*  770 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  773 */           CError tError = new CError();
/*  774 */           tError.moduleName = "MUserDB";
/*  775 */           tError.functionName = "executeQuery";
/*  776 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  777 */           this.mErrors.addOneError(tError);
/*      */         }
/*  779 */         aMUserSet.add(s1);
/*      */       }try {
/*  781 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  787 */       CError tError = new CError();
/*  788 */       tError.moduleName = "MUserDB";
/*  789 */       tError.functionName = "executeQuery";
/*  790 */       tError.errorMessage = e.toString();
/*  791 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  793 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  796 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  800 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  806 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  810 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  815 */     return aMUserSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  820 */     Statement stmt = null;
/*      */ 
/*  822 */     if (!this.mflag) {
/*  823 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  828 */       stmt = this.con.createStatement(1003, 1007);
/*  829 */       SQLString sqlObj = new SQLString("MUser");
/*  830 */       MUserSchema aSchema = getSchema();
/*  831 */       sqlObj.setSQL(2, aSchema);
/*  832 */       String sql = "update MUser " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  834 */       int operCount = stmt.executeUpdate(sql);
/*  835 */       if (operCount == 0)
/*      */       {
/*  838 */         CError tError = new CError();
/*  839 */         tError.moduleName = "MUserDB";
/*  840 */         tError.functionName = "update";
/*  841 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  842 */         this.mErrors.addOneError(tError);
/*      */ 
/*  844 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  848 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  852 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  858 */       CError tError = new CError();
/*  859 */       tError.moduleName = "MUserDB";
/*  860 */       tError.functionName = "update";
/*  861 */       tError.errorMessage = e.toString();
/*  862 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  864 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  866 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  870 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  874 */       return false;
/*      */     }
/*      */ 
/*  877 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  881 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  886 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  892 */     if (this.mResultSet != null)
/*      */     {
/*  895 */       CError tError = new CError();
/*  896 */       tError.moduleName = "MUserDB";
/*  897 */       tError.functionName = "prepareData";
/*  898 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  899 */       this.mErrors.addOneError(tError);
/*  900 */       return false;
/*      */     }
/*      */ 
/*  903 */     if (!this.mflag)
/*      */     {
/*  905 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  909 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  910 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  915 */       CError tError = new CError();
/*  916 */       tError.moduleName = "MUserDB";
/*  917 */       tError.functionName = "prepareData";
/*  918 */       tError.errorMessage = e.toString();
/*  919 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  922 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  928 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  932 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  936 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  941 */       return false;
/*      */     }
/*      */ 
/*  944 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  948 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  953 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  959 */     boolean flag = true;
/*  960 */     if (this.mResultSet == null)
/*      */     {
/*  962 */       CError tError = new CError();
/*  963 */       tError.moduleName = "MUserDB";
/*  964 */       tError.functionName = "hasMoreData";
/*  965 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  966 */       this.mErrors.addOneError(tError);
/*  967 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  971 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  975 */       CError tError = new CError();
/*  976 */       tError.moduleName = "MUserDB";
/*  977 */       tError.functionName = "hasMoreData";
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
/* 1003 */       return false;
/*      */     }
/* 1005 */     return flag;
/*      */   }
/*      */ 
/*      */   public MUserSet getData()
/*      */   {
/* 1010 */     int tCount = 0;
/* 1011 */     MUserSet tMUserSet = new MUserSet();
/* 1012 */     MUserSchema tMUserSchema = null;
/* 1013 */     if (this.mResultSet == null)
/*      */     {
/* 1015 */       CError tError = new CError();
/* 1016 */       tError.moduleName = "MUserDB";
/* 1017 */       tError.functionName = "getData";
/* 1018 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1019 */       this.mErrors.addOneError(tError);
/* 1020 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1024 */       tCount = 1;
/* 1025 */       tMUserSchema = new MUserSchema();
/* 1026 */       tMUserSchema.setSchema(this.mResultSet, 1);
/* 1027 */       tMUserSet.add(tMUserSchema);
/*      */ 
/* 1029 */       while (tCount++ < 5000)
/*      */       {
/* 1031 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1033 */         tMUserSchema = new MUserSchema();
/* 1034 */         tMUserSchema.setSchema(this.mResultSet, 1);
/* 1035 */         tMUserSet.add(tMUserSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1041 */       CError tError = new CError();
/* 1042 */       tError.moduleName = "MUserDB";
/* 1043 */       tError.functionName = "getData";
/* 1044 */       tError.errorMessage = ex.toString();
/* 1045 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1048 */         this.mResultSet.close();
/* 1049 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1055 */         this.mStatement.close();
/* 1056 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1060 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1064 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1069 */       return null;
/*      */     }
/* 1071 */     return tMUserSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1076 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1079 */       if (this.mResultSet == null)
/*      */       {
/* 1081 */         CError tError = new CError();
/* 1082 */         tError.moduleName = "MUserDB";
/* 1083 */         tError.functionName = "closeData";
/* 1084 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1085 */         this.mErrors.addOneError(tError);
/* 1086 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1090 */         this.mResultSet.close();
/* 1091 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1096 */       CError tError = new CError();
/* 1097 */       tError.moduleName = "MUserDB";
/* 1098 */       tError.functionName = "closeData";
/* 1099 */       tError.errorMessage = ex2.toString();
/* 1100 */       this.mErrors.addOneError(tError);
/* 1101 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1105 */       if (this.mStatement == null)
/*      */       {
/* 1107 */         CError tError = new CError();
/* 1108 */         tError.moduleName = "MUserDB";
/* 1109 */         tError.functionName = "closeData";
/* 1110 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1111 */         this.mErrors.addOneError(tError);
/* 1112 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1116 */         this.mStatement.close();
/* 1117 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1122 */       CError tError = new CError();
/* 1123 */       tError.moduleName = "MUserDB";
/* 1124 */       tError.functionName = "closeData";
/* 1125 */       tError.errorMessage = ex3.toString();
/* 1126 */       this.mErrors.addOneError(tError);
/* 1127 */       flag = false;
/*      */     }
/* 1129 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MUserDB
 * JD-Core Version:    0.6.0
 */