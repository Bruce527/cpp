/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MLPHonorSchema;
/*      */ import com.sinosoft.map.lis.vschema.MLPHonorSet;
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
/*      */ public class MLPHonorDB extends MLPHonorSchema
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
/*      */   public MLPHonorDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MLPHonor");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MLPHonorDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MLPHonor");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MLPHonorSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MLPHonorDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MLPHonorSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MLPHonorDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MLPHonor WHERE  StatYear = ? AND StatBatch = ? AND AgentCode = ?");
/*   96 */       if ((getStatYear() == null) || (getStatYear().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getStatYear());
/*      */       }
/*  101 */       if ((getStatBatch() == null) || (getStatBatch().equals("null")))
/*  102 */         pstmt.setNull(2, 12);
/*      */       else {
/*  104 */         pstmt.setString(2, getStatBatch());
/*      */       }
/*  106 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  107 */         pstmt.setNull(3, 12);
/*      */       else {
/*  109 */         pstmt.setString(3, getAgentCode());
/*      */       }
/*  111 */       pstmt.executeUpdate();
/*  112 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  115 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  116 */       CError tError = new CError();
/*  117 */       tError.moduleName = "MLPHonorDB";
/*  118 */       tError.functionName = "delete()";
/*  119 */       tError.errorMessage = ex.toString();
/*  120 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  123 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  126 */       if (!this.mflag)
/*      */         try {
/*  128 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  132 */       return false;
/*      */     }
/*      */ 
/*  135 */     if (!this.mflag)
/*      */       try {
/*  137 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  141 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  146 */     PreparedStatement pstmt = null;
/*      */ 
/*  148 */     if (!this.mflag) {
/*  149 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  154 */       pstmt = this.con.prepareStatement("UPDATE MLPHonor SET  StatYear = ? , StatBatch = ? , AgentCode = ? , ManageCom = ? , BranchType = ? , StartDate = ? , EndDate = ? , Name = ? , EmployDate = ? , BranchAttr = ? , AgentGrade = ? , SMManagerName = ? , AMManagerName = ? , RMManagerName = ? , T1 = ? , T2 = ? , T3 = ? , T4 = ? , T5 = ? , T6 = ? , T7 = ? , T8 = ? , T9 = ? , T10 = ? , T11 = ? , T12 = ? , AMManager = ? , RMManager = ? , SMManager = ? , T13 = ? , T14 = ? , T15 = ? , OutWorkDate = ? , T16 = ? , T17 = ? , T18 = ? , T19 = ? , T20 = ? , T21 = ? , T22 = ? , SMManager2 = ? , RMManager2 = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , C1 = ? , C2 = ? , C3 = ? , C4 = ? , C5 = ? , C6 = ? , C7 = ? , C8 = ? , C9 = ? , C10 = ? WHERE  StatYear = ? AND StatBatch = ? AND AgentCode = ?");
/*  155 */       if ((getStatYear() == null) || (getStatYear().equals("null")))
/*  156 */         pstmt.setNull(1, 12);
/*      */       else {
/*  158 */         pstmt.setString(1, getStatYear());
/*      */       }
/*  160 */       if ((getStatBatch() == null) || (getStatBatch().equals("null")))
/*  161 */         pstmt.setNull(2, 12);
/*      */       else {
/*  163 */         pstmt.setString(2, getStatBatch());
/*      */       }
/*  165 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  166 */         pstmt.setNull(3, 12);
/*      */       else {
/*  168 */         pstmt.setString(3, getAgentCode());
/*      */       }
/*  170 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  171 */         pstmt.setNull(4, 12);
/*      */       else {
/*  173 */         pstmt.setString(4, getManageCom());
/*      */       }
/*  175 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  176 */         pstmt.setNull(5, 12);
/*      */       else {
/*  178 */         pstmt.setString(5, getBranchType());
/*      */       }
/*  180 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  181 */         pstmt.setNull(6, 91);
/*      */       else {
/*  183 */         pstmt.setDate(6, Date.valueOf(getStartDate()));
/*      */       }
/*  185 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  186 */         pstmt.setNull(7, 91);
/*      */       else {
/*  188 */         pstmt.setDate(7, Date.valueOf(getEndDate()));
/*      */       }
/*  190 */       if ((getName() == null) || (getName().equals("null")))
/*  191 */         pstmt.setNull(8, 12);
/*      */       else {
/*  193 */         pstmt.setString(8, getName());
/*      */       }
/*  195 */       if ((getEmployDate() == null) || (getEmployDate().equals("null")))
/*  196 */         pstmt.setNull(9, 91);
/*      */       else {
/*  198 */         pstmt.setDate(9, Date.valueOf(getEmployDate()));
/*      */       }
/*  200 */       if ((getBranchAttr() == null) || (getBranchAttr().equals("null")))
/*  201 */         pstmt.setNull(10, 12);
/*      */       else {
/*  203 */         pstmt.setString(10, getBranchAttr());
/*      */       }
/*  205 */       if ((getAgentGrade() == null) || (getAgentGrade().equals("null")))
/*  206 */         pstmt.setNull(11, 12);
/*      */       else {
/*  208 */         pstmt.setString(11, getAgentGrade());
/*      */       }
/*  210 */       if ((getSMManagerName() == null) || (getSMManagerName().equals("null")))
/*  211 */         pstmt.setNull(12, 12);
/*      */       else {
/*  213 */         pstmt.setString(12, getSMManagerName());
/*      */       }
/*  215 */       if ((getAMManagerName() == null) || (getAMManagerName().equals("null")))
/*  216 */         pstmt.setNull(13, 12);
/*      */       else {
/*  218 */         pstmt.setString(13, getAMManagerName());
/*      */       }
/*  220 */       if ((getRMManagerName() == null) || (getRMManagerName().equals("null")))
/*  221 */         pstmt.setNull(14, 12);
/*      */       else {
/*  223 */         pstmt.setString(14, getRMManagerName());
/*      */       }
/*  225 */       pstmt.setDouble(15, getT1());
/*  226 */       pstmt.setDouble(16, getT2());
/*  227 */       pstmt.setDouble(17, getT3());
/*  228 */       pstmt.setDouble(18, getT4());
/*  229 */       pstmt.setDouble(19, getT5());
/*  230 */       pstmt.setDouble(20, getT6());
/*  231 */       if ((getT7() == null) || (getT7().equals("null")))
/*  232 */         pstmt.setNull(21, 12);
/*      */       else {
/*  234 */         pstmt.setString(21, getT7());
/*      */       }
/*  236 */       if ((getT8() == null) || (getT8().equals("null")))
/*  237 */         pstmt.setNull(22, 12);
/*      */       else {
/*  239 */         pstmt.setString(22, getT8());
/*      */       }
/*  241 */       if ((getT9() == null) || (getT9().equals("null")))
/*  242 */         pstmt.setNull(23, 12);
/*      */       else {
/*  244 */         pstmt.setString(23, getT9());
/*      */       }
/*  246 */       pstmt.setDouble(24, getT10());
/*  247 */       pstmt.setDouble(25, getT11());
/*  248 */       pstmt.setDouble(26, getT12());
/*  249 */       if ((getAMManager() == null) || (getAMManager().equals("null")))
/*  250 */         pstmt.setNull(27, 12);
/*      */       else {
/*  252 */         pstmt.setString(27, getAMManager());
/*      */       }
/*  254 */       if ((getRMManager() == null) || (getRMManager().equals("null")))
/*  255 */         pstmt.setNull(28, 12);
/*      */       else {
/*  257 */         pstmt.setString(28, getRMManager());
/*      */       }
/*  259 */       if ((getSMManager() == null) || (getSMManager().equals("null")))
/*  260 */         pstmt.setNull(29, 12);
/*      */       else {
/*  262 */         pstmt.setString(29, getSMManager());
/*      */       }
/*  264 */       if ((getT13() == null) || (getT13().equals("null")))
/*  265 */         pstmt.setNull(30, 12);
/*      */       else {
/*  267 */         pstmt.setString(30, getT13());
/*      */       }
/*  269 */       if ((getT14() == null) || (getT14().equals("null")))
/*  270 */         pstmt.setNull(31, 12);
/*      */       else {
/*  272 */         pstmt.setString(31, getT14());
/*      */       }
/*  274 */       pstmt.setDouble(32, getT15());
/*  275 */       if ((getOutWorkDate() == null) || (getOutWorkDate().equals("null")))
/*  276 */         pstmt.setNull(33, 91);
/*      */       else {
/*  278 */         pstmt.setDate(33, Date.valueOf(getOutWorkDate()));
/*      */       }
/*  280 */       pstmt.setDouble(34, getT16());
/*  281 */       pstmt.setDouble(35, getT17());
/*  282 */       pstmt.setDouble(36, getT18());
/*  283 */       if ((getT19() == null) || (getT19().equals("null")))
/*  284 */         pstmt.setNull(37, 12);
/*      */       else {
/*  286 */         pstmt.setString(37, getT19());
/*      */       }
/*  288 */       pstmt.setDouble(38, getT20());
/*  289 */       pstmt.setDouble(39, getT21());
/*  290 */       if ((getT22() == null) || (getT22().equals("null")))
/*  291 */         pstmt.setNull(40, 12);
/*      */       else {
/*  293 */         pstmt.setString(40, getT22());
/*      */       }
/*  295 */       if ((getSMManager2() == null) || (getSMManager2().equals("null")))
/*  296 */         pstmt.setNull(41, 12);
/*      */       else {
/*  298 */         pstmt.setString(41, getSMManager2());
/*      */       }
/*  300 */       if ((getRMManager2() == null) || (getRMManager2().equals("null")))
/*  301 */         pstmt.setNull(42, 12);
/*      */       else {
/*  303 */         pstmt.setString(42, getRMManager2());
/*      */       }
/*  305 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  306 */         pstmt.setNull(43, 12);
/*      */       else {
/*  308 */         pstmt.setString(43, getVF01());
/*      */       }
/*  310 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  311 */         pstmt.setNull(44, 12);
/*      */       else {
/*  313 */         pstmt.setString(44, getNF01());
/*      */       }
/*  315 */       pstmt.setInt(45, getIF01());
/*  316 */       pstmt.setDouble(46, getDF02());
/*  317 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  318 */         pstmt.setNull(47, 91);
/*      */       else {
/*  320 */         pstmt.setDate(47, Date.valueOf(getDate01()));
/*      */       }
/*  322 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  323 */         pstmt.setNull(48, 12);
/*      */       else {
/*  325 */         pstmt.setString(48, getModifyOperator());
/*      */       }
/*  327 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  328 */         pstmt.setNull(49, 12);
/*      */       else {
/*  330 */         pstmt.setString(49, getOperator());
/*      */       }
/*  332 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  333 */         pstmt.setNull(50, 91);
/*      */       else {
/*  335 */         pstmt.setDate(50, Date.valueOf(getMakeDate()));
/*      */       }
/*  337 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  338 */         pstmt.setNull(51, 12);
/*      */       else {
/*  340 */         pstmt.setString(51, getMakeTime());
/*      */       }
/*  342 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  343 */         pstmt.setNull(52, 91);
/*      */       else {
/*  345 */         pstmt.setDate(52, Date.valueOf(getModifyDate()));
/*      */       }
/*  347 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  348 */         pstmt.setNull(53, 12);
/*      */       else {
/*  350 */         pstmt.setString(53, getModifyTime());
/*      */       }
/*  352 */       pstmt.setDouble(54, getC1());
/*  353 */       pstmt.setDouble(55, getC2());
/*  354 */       pstmt.setDouble(56, getC3());
/*  355 */       pstmt.setDouble(57, getC4());
/*  356 */       pstmt.setDouble(58, getC5());
/*  357 */       pstmt.setDouble(59, getC6());
/*  358 */       pstmt.setDouble(60, getC7());
/*  359 */       pstmt.setDouble(61, getC8());
/*  360 */       pstmt.setDouble(62, getC9());
/*  361 */       pstmt.setDouble(63, getC10());
/*      */ 
/*  363 */       if ((getStatYear() == null) || (getStatYear().equals("null")))
/*  364 */         pstmt.setNull(64, 12);
/*      */       else {
/*  366 */         pstmt.setString(64, getStatYear());
/*      */       }
/*  368 */       if ((getStatBatch() == null) || (getStatBatch().equals("null")))
/*  369 */         pstmt.setNull(65, 12);
/*      */       else {
/*  371 */         pstmt.setString(65, getStatBatch());
/*      */       }
/*  373 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  374 */         pstmt.setNull(66, 12);
/*      */       else {
/*  376 */         pstmt.setString(66, getAgentCode());
/*      */       }
/*  378 */       pstmt.executeUpdate();
/*  379 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  382 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  383 */       CError tError = new CError();
/*  384 */       tError.moduleName = "MLPHonorDB";
/*  385 */       tError.functionName = "update()";
/*  386 */       tError.errorMessage = ex.toString();
/*  387 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  390 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  393 */       if (!this.mflag)
/*      */         try {
/*  395 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  399 */       return false;
/*      */     }
/*      */ 
/*  402 */     if (!this.mflag)
/*      */       try {
/*  404 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  408 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  413 */     PreparedStatement pstmt = null;
/*      */ 
/*  415 */     if (!this.mflag) {
/*  416 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  421 */       pstmt = this.con.prepareStatement("INSERT INTO MLPHonor VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  422 */       if ((getStatYear() == null) || (getStatYear().equals("null")))
/*  423 */         pstmt.setNull(1, 12);
/*      */       else {
/*  425 */         pstmt.setString(1, getStatYear());
/*      */       }
/*  427 */       if ((getStatBatch() == null) || (getStatBatch().equals("null")))
/*  428 */         pstmt.setNull(2, 12);
/*      */       else {
/*  430 */         pstmt.setString(2, getStatBatch());
/*      */       }
/*  432 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  433 */         pstmt.setNull(3, 12);
/*      */       else {
/*  435 */         pstmt.setString(3, getAgentCode());
/*      */       }
/*  437 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  438 */         pstmt.setNull(4, 12);
/*      */       else {
/*  440 */         pstmt.setString(4, getManageCom());
/*      */       }
/*  442 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  443 */         pstmt.setNull(5, 12);
/*      */       else {
/*  445 */         pstmt.setString(5, getBranchType());
/*      */       }
/*  447 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  448 */         pstmt.setNull(6, 91);
/*      */       else {
/*  450 */         pstmt.setDate(6, Date.valueOf(getStartDate()));
/*      */       }
/*  452 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  453 */         pstmt.setNull(7, 91);
/*      */       else {
/*  455 */         pstmt.setDate(7, Date.valueOf(getEndDate()));
/*      */       }
/*  457 */       if ((getName() == null) || (getName().equals("null")))
/*  458 */         pstmt.setNull(8, 12);
/*      */       else {
/*  460 */         pstmt.setString(8, getName());
/*      */       }
/*  462 */       if ((getEmployDate() == null) || (getEmployDate().equals("null")))
/*  463 */         pstmt.setNull(9, 91);
/*      */       else {
/*  465 */         pstmt.setDate(9, Date.valueOf(getEmployDate()));
/*      */       }
/*  467 */       if ((getBranchAttr() == null) || (getBranchAttr().equals("null")))
/*  468 */         pstmt.setNull(10, 12);
/*      */       else {
/*  470 */         pstmt.setString(10, getBranchAttr());
/*      */       }
/*  472 */       if ((getAgentGrade() == null) || (getAgentGrade().equals("null")))
/*  473 */         pstmt.setNull(11, 12);
/*      */       else {
/*  475 */         pstmt.setString(11, getAgentGrade());
/*      */       }
/*  477 */       if ((getSMManagerName() == null) || (getSMManagerName().equals("null")))
/*  478 */         pstmt.setNull(12, 12);
/*      */       else {
/*  480 */         pstmt.setString(12, getSMManagerName());
/*      */       }
/*  482 */       if ((getAMManagerName() == null) || (getAMManagerName().equals("null")))
/*  483 */         pstmt.setNull(13, 12);
/*      */       else {
/*  485 */         pstmt.setString(13, getAMManagerName());
/*      */       }
/*  487 */       if ((getRMManagerName() == null) || (getRMManagerName().equals("null")))
/*  488 */         pstmt.setNull(14, 12);
/*      */       else {
/*  490 */         pstmt.setString(14, getRMManagerName());
/*      */       }
/*  492 */       pstmt.setDouble(15, getT1());
/*  493 */       pstmt.setDouble(16, getT2());
/*  494 */       pstmt.setDouble(17, getT3());
/*  495 */       pstmt.setDouble(18, getT4());
/*  496 */       pstmt.setDouble(19, getT5());
/*  497 */       pstmt.setDouble(20, getT6());
/*  498 */       if ((getT7() == null) || (getT7().equals("null")))
/*  499 */         pstmt.setNull(21, 12);
/*      */       else {
/*  501 */         pstmt.setString(21, getT7());
/*      */       }
/*  503 */       if ((getT8() == null) || (getT8().equals("null")))
/*  504 */         pstmt.setNull(22, 12);
/*      */       else {
/*  506 */         pstmt.setString(22, getT8());
/*      */       }
/*  508 */       if ((getT9() == null) || (getT9().equals("null")))
/*  509 */         pstmt.setNull(23, 12);
/*      */       else {
/*  511 */         pstmt.setString(23, getT9());
/*      */       }
/*  513 */       pstmt.setDouble(24, getT10());
/*  514 */       pstmt.setDouble(25, getT11());
/*  515 */       pstmt.setDouble(26, getT12());
/*  516 */       if ((getAMManager() == null) || (getAMManager().equals("null")))
/*  517 */         pstmt.setNull(27, 12);
/*      */       else {
/*  519 */         pstmt.setString(27, getAMManager());
/*      */       }
/*  521 */       if ((getRMManager() == null) || (getRMManager().equals("null")))
/*  522 */         pstmt.setNull(28, 12);
/*      */       else {
/*  524 */         pstmt.setString(28, getRMManager());
/*      */       }
/*  526 */       if ((getSMManager() == null) || (getSMManager().equals("null")))
/*  527 */         pstmt.setNull(29, 12);
/*      */       else {
/*  529 */         pstmt.setString(29, getSMManager());
/*      */       }
/*  531 */       if ((getT13() == null) || (getT13().equals("null")))
/*  532 */         pstmt.setNull(30, 12);
/*      */       else {
/*  534 */         pstmt.setString(30, getT13());
/*      */       }
/*  536 */       if ((getT14() == null) || (getT14().equals("null")))
/*  537 */         pstmt.setNull(31, 12);
/*      */       else {
/*  539 */         pstmt.setString(31, getT14());
/*      */       }
/*  541 */       pstmt.setDouble(32, getT15());
/*  542 */       if ((getOutWorkDate() == null) || (getOutWorkDate().equals("null")))
/*  543 */         pstmt.setNull(33, 91);
/*      */       else {
/*  545 */         pstmt.setDate(33, Date.valueOf(getOutWorkDate()));
/*      */       }
/*  547 */       pstmt.setDouble(34, getT16());
/*  548 */       pstmt.setDouble(35, getT17());
/*  549 */       pstmt.setDouble(36, getT18());
/*  550 */       if ((getT19() == null) || (getT19().equals("null")))
/*  551 */         pstmt.setNull(37, 12);
/*      */       else {
/*  553 */         pstmt.setString(37, getT19());
/*      */       }
/*  555 */       pstmt.setDouble(38, getT20());
/*  556 */       pstmt.setDouble(39, getT21());
/*  557 */       if ((getT22() == null) || (getT22().equals("null")))
/*  558 */         pstmt.setNull(40, 12);
/*      */       else {
/*  560 */         pstmt.setString(40, getT22());
/*      */       }
/*  562 */       if ((getSMManager2() == null) || (getSMManager2().equals("null")))
/*  563 */         pstmt.setNull(41, 12);
/*      */       else {
/*  565 */         pstmt.setString(41, getSMManager2());
/*      */       }
/*  567 */       if ((getRMManager2() == null) || (getRMManager2().equals("null")))
/*  568 */         pstmt.setNull(42, 12);
/*      */       else {
/*  570 */         pstmt.setString(42, getRMManager2());
/*      */       }
/*  572 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  573 */         pstmt.setNull(43, 12);
/*      */       else {
/*  575 */         pstmt.setString(43, getVF01());
/*      */       }
/*  577 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  578 */         pstmt.setNull(44, 12);
/*      */       else {
/*  580 */         pstmt.setString(44, getNF01());
/*      */       }
/*  582 */       pstmt.setInt(45, getIF01());
/*  583 */       pstmt.setDouble(46, getDF02());
/*  584 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  585 */         pstmt.setNull(47, 91);
/*      */       else {
/*  587 */         pstmt.setDate(47, Date.valueOf(getDate01()));
/*      */       }
/*  589 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  590 */         pstmt.setNull(48, 12);
/*      */       else {
/*  592 */         pstmt.setString(48, getModifyOperator());
/*      */       }
/*  594 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  595 */         pstmt.setNull(49, 12);
/*      */       else {
/*  597 */         pstmt.setString(49, getOperator());
/*      */       }
/*  599 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  600 */         pstmt.setNull(50, 91);
/*      */       else {
/*  602 */         pstmt.setDate(50, Date.valueOf(getMakeDate()));
/*      */       }
/*  604 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  605 */         pstmt.setNull(51, 12);
/*      */       else {
/*  607 */         pstmt.setString(51, getMakeTime());
/*      */       }
/*  609 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  610 */         pstmt.setNull(52, 91);
/*      */       else {
/*  612 */         pstmt.setDate(52, Date.valueOf(getModifyDate()));
/*      */       }
/*  614 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  615 */         pstmt.setNull(53, 12);
/*      */       else {
/*  617 */         pstmt.setString(53, getModifyTime());
/*      */       }
/*  619 */       pstmt.setDouble(54, getC1());
/*  620 */       pstmt.setDouble(55, getC2());
/*  621 */       pstmt.setDouble(56, getC3());
/*  622 */       pstmt.setDouble(57, getC4());
/*  623 */       pstmt.setDouble(58, getC5());
/*  624 */       pstmt.setDouble(59, getC6());
/*  625 */       pstmt.setDouble(60, getC7());
/*  626 */       pstmt.setDouble(61, getC8());
/*  627 */       pstmt.setDouble(62, getC9());
/*  628 */       pstmt.setDouble(63, getC10());
/*      */ 
/*  630 */       pstmt.executeUpdate();
/*  631 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  634 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  635 */       CError tError = new CError();
/*  636 */       tError.moduleName = "MLPHonorDB";
/*  637 */       tError.functionName = "insert()";
/*  638 */       tError.errorMessage = ex.toString();
/*  639 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  642 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  645 */       if (!this.mflag)
/*      */         try {
/*  647 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  651 */       return false;
/*      */     }
/*      */ 
/*  654 */     if (!this.mflag)
/*      */       try {
/*  656 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  660 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  665 */     PreparedStatement pstmt = null;
/*  666 */     ResultSet rs = null;
/*      */ 
/*  668 */     if (!this.mflag) {
/*  669 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  674 */       pstmt = this.con.prepareStatement("SELECT * FROM MLPHonor WHERE  StatYear = ? AND StatBatch = ? AND AgentCode = ?", 
/*  675 */         1003, 1007);
/*  676 */       if ((getStatYear() == null) || (getStatYear().equals("null")))
/*  677 */         pstmt.setNull(1, 12);
/*      */       else {
/*  679 */         pstmt.setString(1, getStatYear());
/*      */       }
/*  681 */       if ((getStatBatch() == null) || (getStatBatch().equals("null")))
/*  682 */         pstmt.setNull(2, 12);
/*      */       else {
/*  684 */         pstmt.setString(2, getStatBatch());
/*      */       }
/*  686 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  687 */         pstmt.setNull(3, 12);
/*      */       else {
/*  689 */         pstmt.setString(3, getAgentCode());
/*      */       }
/*  691 */       rs = pstmt.executeQuery();
/*  692 */       int i = 0;
/*  693 */       if (rs.next())
/*      */       {
/*  695 */         i++;
/*  696 */         if (!setSchema(rs, i))
/*      */         {
/*  699 */           CError tError = new CError();
/*  700 */           tError.moduleName = "MLPHonorDB";
/*  701 */           tError.functionName = "getInfo";
/*  702 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  703 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  705 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  708 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  712 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  716 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  720 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  723 */       if (i == 0)
/*      */       {
/*  725 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  729 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  733 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  739 */       CError tError = new CError();
/*  740 */       tError.moduleName = "MLPHonorDB";
/*  741 */       tError.functionName = "getInfo";
/*  742 */       tError.errorMessage = e.toString();
/*  743 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  745 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  748 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  752 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  756 */       return false;
/*      */     }
/*      */ 
/*  759 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  763 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  768 */     return true;
/*      */   }
/*      */ 
/*      */   public MLPHonorSet query()
/*      */   {
/*  773 */     Statement stmt = null;
/*  774 */     ResultSet rs = null;
/*  775 */     MLPHonorSet aMLPHonorSet = new MLPHonorSet();
/*      */ 
/*  777 */     if (!this.mflag) {
/*  778 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  783 */       stmt = this.con.createStatement(1003, 1007);
/*  784 */       SQLString sqlObj = new SQLString("MLPHonor");
/*  785 */       MLPHonorSchema aSchema = getSchema();
/*  786 */       sqlObj.setSQL(5, aSchema);
/*  787 */       String sql = sqlObj.getSQL();
/*      */ 
/*  789 */       rs = stmt.executeQuery(sql);
/*  790 */       int i = 0;
/*  791 */       while (rs.next())
/*      */       {
/*  793 */         i++;
/*  794 */         MLPHonorSchema s1 = new MLPHonorSchema();
/*  795 */         s1.setSchema(rs, i);
/*  796 */         aMLPHonorSet.add(s1);
/*      */       }try {
/*  798 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  804 */       CError tError = new CError();
/*  805 */       tError.moduleName = "MLPHonorDB";
/*  806 */       tError.functionName = "query";
/*  807 */       tError.errorMessage = e.toString();
/*  808 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  810 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  813 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  817 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  823 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  827 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  832 */     return aMLPHonorSet;
/*      */   }
/*      */ 
/*      */   public MLPHonorSet executeQuery(String sql)
/*      */   {
/*  837 */     Statement stmt = null;
/*  838 */     ResultSet rs = null;
/*  839 */     MLPHonorSet aMLPHonorSet = new MLPHonorSet();
/*      */ 
/*  841 */     if (!this.mflag) {
/*  842 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  847 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  849 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  850 */       int i = 0;
/*  851 */       while (rs.next())
/*      */       {
/*  853 */         i++;
/*  854 */         MLPHonorSchema s1 = new MLPHonorSchema();
/*  855 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  858 */           CError tError = new CError();
/*  859 */           tError.moduleName = "MLPHonorDB";
/*  860 */           tError.functionName = "executeQuery";
/*  861 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  862 */           this.mErrors.addOneError(tError);
/*      */         }
/*  864 */         aMLPHonorSet.add(s1);
/*      */       }try {
/*  866 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  872 */       CError tError = new CError();
/*  873 */       tError.moduleName = "MLPHonorDB";
/*  874 */       tError.functionName = "executeQuery";
/*  875 */       tError.errorMessage = e.toString();
/*  876 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  878 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  881 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  885 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  891 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  895 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  900 */     return aMLPHonorSet;
/*      */   }
/*      */ 
/*      */   public MLPHonorSet query(int nStart, int nCount)
/*      */   {
/*  905 */     Statement stmt = null;
/*  906 */     ResultSet rs = null;
/*  907 */     MLPHonorSet aMLPHonorSet = new MLPHonorSet();
/*      */ 
/*  909 */     if (!this.mflag) {
/*  910 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  915 */       stmt = this.con.createStatement(1003, 1007);
/*  916 */       SQLString sqlObj = new SQLString("MLPHonor");
/*  917 */       MLPHonorSchema aSchema = getSchema();
/*  918 */       sqlObj.setSQL(5, aSchema);
/*  919 */       String sql = sqlObj.getSQL();
/*      */ 
/*  921 */       rs = stmt.executeQuery(sql);
/*  922 */       int i = 0;
/*  923 */       while (rs.next())
/*      */       {
/*  925 */         i++;
/*      */ 
/*  927 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  931 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  935 */         MLPHonorSchema s1 = new MLPHonorSchema();
/*  936 */         s1.setSchema(rs, i);
/*  937 */         aMLPHonorSet.add(s1);
/*      */       }try {
/*  939 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  945 */       CError tError = new CError();
/*  946 */       tError.moduleName = "MLPHonorDB";
/*  947 */       tError.functionName = "query";
/*  948 */       tError.errorMessage = e.toString();
/*  949 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  951 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  954 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  958 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  964 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  968 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  973 */     return aMLPHonorSet;
/*      */   }
/*      */ 
/*      */   public MLPHonorSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  978 */     Statement stmt = null;
/*  979 */     ResultSet rs = null;
/*  980 */     MLPHonorSet aMLPHonorSet = new MLPHonorSet();
/*      */ 
/*  982 */     if (!this.mflag) {
/*  983 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  988 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  990 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  991 */       int i = 0;
/*  992 */       while (rs.next())
/*      */       {
/*  994 */         i++;
/*      */ 
/*  996 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1000 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1004 */         MLPHonorSchema s1 = new MLPHonorSchema();
/* 1005 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1008 */           CError tError = new CError();
/* 1009 */           tError.moduleName = "MLPHonorDB";
/* 1010 */           tError.functionName = "executeQuery";
/* 1011 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 1012 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1014 */         aMLPHonorSet.add(s1);
/*      */       }try {
/* 1016 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1022 */       CError tError = new CError();
/* 1023 */       tError.moduleName = "MLPHonorDB";
/* 1024 */       tError.functionName = "executeQuery";
/* 1025 */       tError.errorMessage = e.toString();
/* 1026 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1028 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1031 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1035 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1041 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1045 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1050 */     return aMLPHonorSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1055 */     Statement stmt = null;
/*      */ 
/* 1057 */     if (!this.mflag) {
/* 1058 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1063 */       stmt = this.con.createStatement(1003, 1007);
/* 1064 */       SQLString sqlObj = new SQLString("MLPHonor");
/* 1065 */       MLPHonorSchema aSchema = getSchema();
/* 1066 */       sqlObj.setSQL(2, aSchema);
/* 1067 */       String sql = "update MLPHonor " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1069 */       int operCount = stmt.executeUpdate(sql);
/* 1070 */       if (operCount == 0)
/*      */       {
/* 1073 */         CError tError = new CError();
/* 1074 */         tError.moduleName = "MLPHonorDB";
/* 1075 */         tError.functionName = "update";
/* 1076 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/* 1077 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1079 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1083 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1087 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1093 */       CError tError = new CError();
/* 1094 */       tError.moduleName = "MLPHonorDB";
/* 1095 */       tError.functionName = "update";
/* 1096 */       tError.errorMessage = e.toString();
/* 1097 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1099 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1101 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1105 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1109 */       return false;
/*      */     }
/*      */ 
/* 1112 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1116 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1121 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1127 */     if (this.mResultSet != null)
/*      */     {
/* 1130 */       CError tError = new CError();
/* 1131 */       tError.moduleName = "MLPHonorDB";
/* 1132 */       tError.functionName = "prepareData";
/* 1133 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 1134 */       this.mErrors.addOneError(tError);
/* 1135 */       return false;
/*      */     }
/*      */ 
/* 1138 */     if (!this.mflag)
/*      */     {
/* 1140 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1144 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1145 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1150 */       CError tError = new CError();
/* 1151 */       tError.moduleName = "MLPHonorDB";
/* 1152 */       tError.functionName = "prepareData";
/* 1153 */       tError.errorMessage = e.toString();
/* 1154 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1157 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1163 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1167 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1171 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1176 */       return false;
/*      */     }
/*      */ 
/* 1179 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1183 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1188 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1194 */     boolean flag = true;
/* 1195 */     if (this.mResultSet == null)
/*      */     {
/* 1197 */       CError tError = new CError();
/* 1198 */       tError.moduleName = "MLPHonorDB";
/* 1199 */       tError.functionName = "hasMoreData";
/* 1200 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1201 */       this.mErrors.addOneError(tError);
/* 1202 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1206 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1210 */       CError tError = new CError();
/* 1211 */       tError.moduleName = "MLPHonorDB";
/* 1212 */       tError.functionName = "hasMoreData";
/* 1213 */       tError.errorMessage = ex.toString();
/* 1214 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1217 */         this.mResultSet.close();
/* 1218 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1224 */         this.mStatement.close();
/* 1225 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1229 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1233 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1238 */       return false;
/*      */     }
/* 1240 */     return flag;
/*      */   }
/*      */ 
/*      */   public MLPHonorSet getData()
/*      */   {
/* 1245 */     int tCount = 0;
/* 1246 */     MLPHonorSet tMLPHonorSet = new MLPHonorSet();
/* 1247 */     MLPHonorSchema tMLPHonorSchema = null;
/* 1248 */     if (this.mResultSet == null)
/*      */     {
/* 1250 */       CError tError = new CError();
/* 1251 */       tError.moduleName = "MLPHonorDB";
/* 1252 */       tError.functionName = "getData";
/* 1253 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1254 */       this.mErrors.addOneError(tError);
/* 1255 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1259 */       tCount = 1;
/* 1260 */       tMLPHonorSchema = new MLPHonorSchema();
/* 1261 */       tMLPHonorSchema.setSchema(this.mResultSet, 1);
/* 1262 */       tMLPHonorSet.add(tMLPHonorSchema);
/*      */ 
/* 1264 */       while (tCount++ < 5000)
/*      */       {
/* 1266 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1268 */         tMLPHonorSchema = new MLPHonorSchema();
/* 1269 */         tMLPHonorSchema.setSchema(this.mResultSet, 1);
/* 1270 */         tMLPHonorSet.add(tMLPHonorSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1276 */       CError tError = new CError();
/* 1277 */       tError.moduleName = "MLPHonorDB";
/* 1278 */       tError.functionName = "getData";
/* 1279 */       tError.errorMessage = ex.toString();
/* 1280 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1283 */         this.mResultSet.close();
/* 1284 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1290 */         this.mStatement.close();
/* 1291 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1295 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1299 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1304 */       return null;
/*      */     }
/* 1306 */     return tMLPHonorSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1311 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1314 */       if (this.mResultSet == null)
/*      */       {
/* 1316 */         CError tError = new CError();
/* 1317 */         tError.moduleName = "MLPHonorDB";
/* 1318 */         tError.functionName = "closeData";
/* 1319 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1320 */         this.mErrors.addOneError(tError);
/* 1321 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1325 */         this.mResultSet.close();
/* 1326 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1331 */       CError tError = new CError();
/* 1332 */       tError.moduleName = "MLPHonorDB";
/* 1333 */       tError.functionName = "closeData";
/* 1334 */       tError.errorMessage = ex2.toString();
/* 1335 */       this.mErrors.addOneError(tError);
/* 1336 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1340 */       if (this.mStatement == null)
/*      */       {
/* 1342 */         CError tError = new CError();
/* 1343 */         tError.moduleName = "MLPHonorDB";
/* 1344 */         tError.functionName = "closeData";
/* 1345 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1346 */         this.mErrors.addOneError(tError);
/* 1347 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1351 */         this.mStatement.close();
/* 1352 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1357 */       CError tError = new CError();
/* 1358 */       tError.moduleName = "MLPHonorDB";
/* 1359 */       tError.functionName = "closeData";
/* 1360 */       tError.errorMessage = ex3.toString();
/* 1361 */       this.mErrors.addOneError(tError);
/* 1362 */       flag = false;
/*      */     }
/* 1364 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MLPHonorDB
 * JD-Core Version:    0.6.0
 */