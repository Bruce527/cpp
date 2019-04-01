/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MUserBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MUserBSet;
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
/*      */ public class MUserBDB extends MUserBSchema
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
/*      */   public MUserBDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MUserB");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MUserBDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MUserB");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MUserBSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MUserBDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MUserBSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MUserBDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MUserB WHERE  EdorNo = ?");
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
/*  106 */       tError.moduleName = "MUserBDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MUserB SET  UserCode = ? , UserName = ? , ManageCom = ? , BranchType = ? , Password = ? , PwdModifyDate = ? , UserDescription = ? , UserState = ? , SuperPopedomFlag = ? , ValidStartDate = ? , ValidEndDate = ? , StuffNo = ? , OfficePhone = ? , Phone = ? , EMail = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
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
/*  249 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  250 */         pstmt.setNull(22, 12);
/*      */       else {
/*  252 */         pstmt.setString(22, getEdorNo());
/*      */       }
/*  254 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  255 */         pstmt.setNull(23, 12);
/*      */       else {
/*  257 */         pstmt.setString(23, getEdorType());
/*      */       }
/*  259 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  260 */         pstmt.setNull(24, 12);
/*      */       else {
/*  262 */         pstmt.setString(24, getEdorCase());
/*      */       }
/*  264 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  265 */         pstmt.setNull(25, 12);
/*      */       else {
/*  267 */         pstmt.setString(25, getOperator2());
/*      */       }
/*  269 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  270 */         pstmt.setNull(26, 91);
/*      */       else {
/*  272 */         pstmt.setDate(26, Date.valueOf(getMakeDate2()));
/*      */       }
/*  274 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  275 */         pstmt.setNull(27, 12);
/*      */       else {
/*  277 */         pstmt.setString(27, getMakeTime2());
/*      */       }
/*      */ 
/*  280 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  281 */         pstmt.setNull(28, 12);
/*      */       else {
/*  283 */         pstmt.setString(28, getEdorNo());
/*      */       }
/*  285 */       pstmt.executeUpdate();
/*  286 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  289 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  290 */       CError tError = new CError();
/*  291 */       tError.moduleName = "MUserBDB";
/*  292 */       tError.functionName = "update()";
/*  293 */       tError.errorMessage = ex.toString();
/*  294 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  297 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  300 */       if (!this.mflag)
/*      */         try {
/*  302 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  306 */       return false;
/*      */     }
/*      */ 
/*  309 */     if (!this.mflag)
/*      */       try {
/*  311 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  315 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  320 */     PreparedStatement pstmt = null;
/*      */ 
/*  322 */     if (!this.mflag) {
/*  323 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  328 */       pstmt = this.con.prepareStatement("INSERT INTO MUserB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  329 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  330 */         pstmt.setNull(1, 12);
/*      */       else {
/*  332 */         pstmt.setString(1, getUserCode());
/*      */       }
/*  334 */       if ((getUserName() == null) || (getUserName().equals("null")))
/*  335 */         pstmt.setNull(2, 12);
/*      */       else {
/*  337 */         pstmt.setString(2, getUserName());
/*      */       }
/*  339 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  340 */         pstmt.setNull(3, 12);
/*      */       else {
/*  342 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  344 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  345 */         pstmt.setNull(4, 12);
/*      */       else {
/*  347 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  349 */       if ((getPassword() == null) || (getPassword().equals("null")))
/*  350 */         pstmt.setNull(5, 12);
/*      */       else {
/*  352 */         pstmt.setString(5, getPassword());
/*      */       }
/*  354 */       if ((getPwdModifyDate() == null) || (getPwdModifyDate().equals("null")))
/*  355 */         pstmt.setNull(6, 91);
/*      */       else {
/*  357 */         pstmt.setDate(6, Date.valueOf(getPwdModifyDate()));
/*      */       }
/*  359 */       if ((getUserDescription() == null) || (getUserDescription().equals("null")))
/*  360 */         pstmt.setNull(7, 12);
/*      */       else {
/*  362 */         pstmt.setString(7, getUserDescription());
/*      */       }
/*  364 */       if ((getUserState() == null) || (getUserState().equals("null")))
/*  365 */         pstmt.setNull(8, 12);
/*      */       else {
/*  367 */         pstmt.setString(8, getUserState());
/*      */       }
/*  369 */       if ((getSuperPopedomFlag() == null) || (getSuperPopedomFlag().equals("null")))
/*  370 */         pstmt.setNull(9, 12);
/*      */       else {
/*  372 */         pstmt.setString(9, getSuperPopedomFlag());
/*      */       }
/*  374 */       if ((getValidStartDate() == null) || (getValidStartDate().equals("null")))
/*  375 */         pstmt.setNull(10, 91);
/*      */       else {
/*  377 */         pstmt.setDate(10, Date.valueOf(getValidStartDate()));
/*      */       }
/*  379 */       if ((getValidEndDate() == null) || (getValidEndDate().equals("null")))
/*  380 */         pstmt.setNull(11, 91);
/*      */       else {
/*  382 */         pstmt.setDate(11, Date.valueOf(getValidEndDate()));
/*      */       }
/*  384 */       if ((getStuffNo() == null) || (getStuffNo().equals("null")))
/*  385 */         pstmt.setNull(12, 12);
/*      */       else {
/*  387 */         pstmt.setString(12, getStuffNo());
/*      */       }
/*  389 */       if ((getOfficePhone() == null) || (getOfficePhone().equals("null")))
/*  390 */         pstmt.setNull(13, 12);
/*      */       else {
/*  392 */         pstmt.setString(13, getOfficePhone());
/*      */       }
/*  394 */       if ((getPhone() == null) || (getPhone().equals("null")))
/*  395 */         pstmt.setNull(14, 12);
/*      */       else {
/*  397 */         pstmt.setString(14, getPhone());
/*      */       }
/*  399 */       if ((getEMail() == null) || (getEMail().equals("null")))
/*  400 */         pstmt.setNull(15, 12);
/*      */       else {
/*  402 */         pstmt.setString(15, getEMail());
/*      */       }
/*  404 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  405 */         pstmt.setNull(16, 12);
/*      */       else {
/*  407 */         pstmt.setString(16, getOperator());
/*      */       }
/*  409 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  410 */         pstmt.setNull(17, 12);
/*      */       else {
/*  412 */         pstmt.setString(17, getModifyOperator());
/*      */       }
/*  414 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  415 */         pstmt.setNull(18, 91);
/*      */       else {
/*  417 */         pstmt.setDate(18, Date.valueOf(getMakeDate()));
/*      */       }
/*  419 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  420 */         pstmt.setNull(19, 12);
/*      */       else {
/*  422 */         pstmt.setString(19, getMakeTime());
/*      */       }
/*  424 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  425 */         pstmt.setNull(20, 91);
/*      */       else {
/*  427 */         pstmt.setDate(20, Date.valueOf(getModifyDate()));
/*      */       }
/*  429 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  430 */         pstmt.setNull(21, 12);
/*      */       else {
/*  432 */         pstmt.setString(21, getModifyTime());
/*      */       }
/*  434 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  435 */         pstmt.setNull(22, 12);
/*      */       else {
/*  437 */         pstmt.setString(22, getEdorNo());
/*      */       }
/*  439 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  440 */         pstmt.setNull(23, 12);
/*      */       else {
/*  442 */         pstmt.setString(23, getEdorType());
/*      */       }
/*  444 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  445 */         pstmt.setNull(24, 12);
/*      */       else {
/*  447 */         pstmt.setString(24, getEdorCase());
/*      */       }
/*  449 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  450 */         pstmt.setNull(25, 12);
/*      */       else {
/*  452 */         pstmt.setString(25, getOperator2());
/*      */       }
/*  454 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  455 */         pstmt.setNull(26, 91);
/*      */       else {
/*  457 */         pstmt.setDate(26, Date.valueOf(getMakeDate2()));
/*      */       }
/*  459 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  460 */         pstmt.setNull(27, 12);
/*      */       else {
/*  462 */         pstmt.setString(27, getMakeTime2());
/*      */       }
/*      */ 
/*  465 */       pstmt.executeUpdate();
/*  466 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  469 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  470 */       CError tError = new CError();
/*  471 */       tError.moduleName = "MUserBDB";
/*  472 */       tError.functionName = "insert()";
/*  473 */       tError.errorMessage = ex.toString();
/*  474 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  477 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  480 */       if (!this.mflag)
/*      */         try {
/*  482 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  486 */       return false;
/*      */     }
/*      */ 
/*  489 */     if (!this.mflag)
/*      */       try {
/*  491 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  495 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  500 */     PreparedStatement pstmt = null;
/*  501 */     ResultSet rs = null;
/*      */ 
/*  503 */     if (!this.mflag) {
/*  504 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  509 */       pstmt = this.con.prepareStatement("SELECT * FROM MUserB WHERE  EdorNo = ?", 
/*  510 */         1003, 1007);
/*  511 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  512 */         pstmt.setNull(1, 12);
/*      */       else {
/*  514 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  516 */       rs = pstmt.executeQuery();
/*  517 */       int i = 0;
/*  518 */       if (rs.next())
/*      */       {
/*  520 */         i++;
/*  521 */         if (!setSchema(rs, i))
/*      */         {
/*  524 */           CError tError = new CError();
/*  525 */           tError.moduleName = "MUserBDB";
/*  526 */           tError.functionName = "getInfo";
/*  527 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  528 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  530 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  533 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  537 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  541 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  545 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  548 */       if (i == 0)
/*      */       {
/*  550 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  554 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  558 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  564 */       CError tError = new CError();
/*  565 */       tError.moduleName = "MUserBDB";
/*  566 */       tError.functionName = "getInfo";
/*  567 */       tError.errorMessage = e.toString();
/*  568 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  570 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  573 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  577 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  581 */       return false;
/*      */     }
/*      */ 
/*  584 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  588 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  593 */     return true;
/*      */   }
/*      */ 
/*      */   public MUserBSet query()
/*      */   {
/*  598 */     Statement stmt = null;
/*  599 */     ResultSet rs = null;
/*  600 */     MUserBSet aMUserBSet = new MUserBSet();
/*      */ 
/*  602 */     if (!this.mflag) {
/*  603 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  608 */       stmt = this.con.createStatement(1003, 1007);
/*  609 */       SQLString sqlObj = new SQLString("MUserB");
/*  610 */       MUserBSchema aSchema = getSchema();
/*  611 */       sqlObj.setSQL(5, aSchema);
/*  612 */       String sql = sqlObj.getSQL();
/*      */ 
/*  614 */       rs = stmt.executeQuery(sql);
/*  615 */       int i = 0;
/*  616 */       while (rs.next())
/*      */       {
/*  618 */         i++;
/*  619 */         MUserBSchema s1 = new MUserBSchema();
/*  620 */         s1.setSchema(rs, i);
/*  621 */         aMUserBSet.add(s1);
/*      */       }try {
/*  623 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  629 */       CError tError = new CError();
/*  630 */       tError.moduleName = "MUserBDB";
/*  631 */       tError.functionName = "query";
/*  632 */       tError.errorMessage = e.toString();
/*  633 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  635 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  638 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  642 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  648 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  652 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  657 */     return aMUserBSet;
/*      */   }
/*      */ 
/*      */   public MUserBSet executeQuery(String sql)
/*      */   {
/*  662 */     Statement stmt = null;
/*  663 */     ResultSet rs = null;
/*  664 */     MUserBSet aMUserBSet = new MUserBSet();
/*      */ 
/*  666 */     if (!this.mflag) {
/*  667 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  672 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  674 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  675 */       int i = 0;
/*  676 */       while (rs.next())
/*      */       {
/*  678 */         i++;
/*  679 */         MUserBSchema s1 = new MUserBSchema();
/*  680 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  683 */           CError tError = new CError();
/*  684 */           tError.moduleName = "MUserBDB";
/*  685 */           tError.functionName = "executeQuery";
/*  686 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  687 */           this.mErrors.addOneError(tError);
/*      */         }
/*  689 */         aMUserBSet.add(s1);
/*      */       }try {
/*  691 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  697 */       CError tError = new CError();
/*  698 */       tError.moduleName = "MUserBDB";
/*  699 */       tError.functionName = "executeQuery";
/*  700 */       tError.errorMessage = e.toString();
/*  701 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  703 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  706 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  710 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  716 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  720 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  725 */     return aMUserBSet;
/*      */   }
/*      */ 
/*      */   public MUserBSet query(int nStart, int nCount)
/*      */   {
/*  730 */     Statement stmt = null;
/*  731 */     ResultSet rs = null;
/*  732 */     MUserBSet aMUserBSet = new MUserBSet();
/*      */ 
/*  734 */     if (!this.mflag) {
/*  735 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  740 */       stmt = this.con.createStatement(1003, 1007);
/*  741 */       SQLString sqlObj = new SQLString("MUserB");
/*  742 */       MUserBSchema aSchema = getSchema();
/*  743 */       sqlObj.setSQL(5, aSchema);
/*  744 */       String sql = sqlObj.getSQL();
/*      */ 
/*  746 */       rs = stmt.executeQuery(sql);
/*  747 */       int i = 0;
/*  748 */       while (rs.next())
/*      */       {
/*  750 */         i++;
/*      */ 
/*  752 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  756 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  760 */         MUserBSchema s1 = new MUserBSchema();
/*  761 */         s1.setSchema(rs, i);
/*  762 */         aMUserBSet.add(s1);
/*      */       }try {
/*  764 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  770 */       CError tError = new CError();
/*  771 */       tError.moduleName = "MUserBDB";
/*  772 */       tError.functionName = "query";
/*  773 */       tError.errorMessage = e.toString();
/*  774 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  776 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  779 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  783 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  789 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  793 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  798 */     return aMUserBSet;
/*      */   }
/*      */ 
/*      */   public MUserBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  803 */     Statement stmt = null;
/*  804 */     ResultSet rs = null;
/*  805 */     MUserBSet aMUserBSet = new MUserBSet();
/*      */ 
/*  807 */     if (!this.mflag) {
/*  808 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  813 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  815 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  816 */       int i = 0;
/*  817 */       while (rs.next())
/*      */       {
/*  819 */         i++;
/*      */ 
/*  821 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  825 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  829 */         MUserBSchema s1 = new MUserBSchema();
/*  830 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  833 */           CError tError = new CError();
/*  834 */           tError.moduleName = "MUserBDB";
/*  835 */           tError.functionName = "executeQuery";
/*  836 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  837 */           this.mErrors.addOneError(tError);
/*      */         }
/*  839 */         aMUserBSet.add(s1);
/*      */       }try {
/*  841 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  847 */       CError tError = new CError();
/*  848 */       tError.moduleName = "MUserBDB";
/*  849 */       tError.functionName = "executeQuery";
/*  850 */       tError.errorMessage = e.toString();
/*  851 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  853 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  856 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  860 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  866 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  870 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  875 */     return aMUserBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  880 */     Statement stmt = null;
/*      */ 
/*  882 */     if (!this.mflag) {
/*  883 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  888 */       stmt = this.con.createStatement(1003, 1007);
/*  889 */       SQLString sqlObj = new SQLString("MUserB");
/*  890 */       MUserBSchema aSchema = getSchema();
/*  891 */       sqlObj.setSQL(2, aSchema);
/*  892 */       String sql = "update MUserB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  894 */       int operCount = stmt.executeUpdate(sql);
/*  895 */       if (operCount == 0)
/*      */       {
/*  898 */         CError tError = new CError();
/*  899 */         tError.moduleName = "MUserBDB";
/*  900 */         tError.functionName = "update";
/*  901 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  902 */         this.mErrors.addOneError(tError);
/*      */ 
/*  904 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  908 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  912 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  918 */       CError tError = new CError();
/*  919 */       tError.moduleName = "MUserBDB";
/*  920 */       tError.functionName = "update";
/*  921 */       tError.errorMessage = e.toString();
/*  922 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  924 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  926 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  930 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  934 */       return false;
/*      */     }
/*      */ 
/*  937 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  941 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  946 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  952 */     if (this.mResultSet != null)
/*      */     {
/*  955 */       CError tError = new CError();
/*  956 */       tError.moduleName = "MUserBDB";
/*  957 */       tError.functionName = "prepareData";
/*  958 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  959 */       this.mErrors.addOneError(tError);
/*  960 */       return false;
/*      */     }
/*      */ 
/*  963 */     if (!this.mflag)
/*      */     {
/*  965 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  969 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  970 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  975 */       CError tError = new CError();
/*  976 */       tError.moduleName = "MUserBDB";
/*  977 */       tError.functionName = "prepareData";
/*  978 */       tError.errorMessage = e.toString();
/*  979 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  982 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  988 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  992 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  996 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1001 */       return false;
/*      */     }
/*      */ 
/* 1004 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1008 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1013 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1019 */     boolean flag = true;
/* 1020 */     if (this.mResultSet == null)
/*      */     {
/* 1022 */       CError tError = new CError();
/* 1023 */       tError.moduleName = "MUserBDB";
/* 1024 */       tError.functionName = "hasMoreData";
/* 1025 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1026 */       this.mErrors.addOneError(tError);
/* 1027 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1031 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1035 */       CError tError = new CError();
/* 1036 */       tError.moduleName = "MUserBDB";
/* 1037 */       tError.functionName = "hasMoreData";
/* 1038 */       tError.errorMessage = ex.toString();
/* 1039 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1042 */         this.mResultSet.close();
/* 1043 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1049 */         this.mStatement.close();
/* 1050 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1054 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1058 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1063 */       return false;
/*      */     }
/* 1065 */     return flag;
/*      */   }
/*      */ 
/*      */   public MUserBSet getData()
/*      */   {
/* 1070 */     int tCount = 0;
/* 1071 */     MUserBSet tMUserBSet = new MUserBSet();
/* 1072 */     MUserBSchema tMUserBSchema = null;
/* 1073 */     if (this.mResultSet == null)
/*      */     {
/* 1075 */       CError tError = new CError();
/* 1076 */       tError.moduleName = "MUserBDB";
/* 1077 */       tError.functionName = "getData";
/* 1078 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1079 */       this.mErrors.addOneError(tError);
/* 1080 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1084 */       tCount = 1;
/* 1085 */       tMUserBSchema = new MUserBSchema();
/* 1086 */       tMUserBSchema.setSchema(this.mResultSet, 1);
/* 1087 */       tMUserBSet.add(tMUserBSchema);
/*      */ 
/* 1089 */       while (tCount++ < 5000)
/*      */       {
/* 1091 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1093 */         tMUserBSchema = new MUserBSchema();
/* 1094 */         tMUserBSchema.setSchema(this.mResultSet, 1);
/* 1095 */         tMUserBSet.add(tMUserBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1101 */       CError tError = new CError();
/* 1102 */       tError.moduleName = "MUserBDB";
/* 1103 */       tError.functionName = "getData";
/* 1104 */       tError.errorMessage = ex.toString();
/* 1105 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1108 */         this.mResultSet.close();
/* 1109 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1115 */         this.mStatement.close();
/* 1116 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1120 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1124 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1129 */       return null;
/*      */     }
/* 1131 */     return tMUserBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1136 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1139 */       if (this.mResultSet == null)
/*      */       {
/* 1141 */         CError tError = new CError();
/* 1142 */         tError.moduleName = "MUserBDB";
/* 1143 */         tError.functionName = "closeData";
/* 1144 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1145 */         this.mErrors.addOneError(tError);
/* 1146 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1150 */         this.mResultSet.close();
/* 1151 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1156 */       CError tError = new CError();
/* 1157 */       tError.moduleName = "MUserBDB";
/* 1158 */       tError.functionName = "closeData";
/* 1159 */       tError.errorMessage = ex2.toString();
/* 1160 */       this.mErrors.addOneError(tError);
/* 1161 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1165 */       if (this.mStatement == null)
/*      */       {
/* 1167 */         CError tError = new CError();
/* 1168 */         tError.moduleName = "MUserBDB";
/* 1169 */         tError.functionName = "closeData";
/* 1170 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1171 */         this.mErrors.addOneError(tError);
/* 1172 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1176 */         this.mStatement.close();
/* 1177 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1182 */       CError tError = new CError();
/* 1183 */       tError.moduleName = "MUserBDB";
/* 1184 */       tError.functionName = "closeData";
/* 1185 */       tError.errorMessage = ex3.toString();
/* 1186 */       this.mErrors.addOneError(tError);
/* 1187 */       flag = false;
/*      */     }
/* 1189 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MUserBDB
 * JD-Core Version:    0.6.0
 */