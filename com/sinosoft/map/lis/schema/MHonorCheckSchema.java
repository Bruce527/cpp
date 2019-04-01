/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MHonorCheckDB;
/*      */ import com.sinosoft.map.lis.pubfun.FDate;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.Schema;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class MHonorCheckSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String checkID;
/*      */   private String dataType;
/*      */   private String statYear;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String statBatch;
/*      */   private Date startDate;
/*      */   private Date endDate;
/*      */   private String checkState;
/*      */   private String inputState;
/*      */   private String checkOperator;
/*      */   private String checkReason;
/*      */   private Date checkDate;
/*      */   private String checkTime;
/*      */   private String modifyOperator;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 20;
/*      */   private static String[] PK;
/*   64 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MHonorCheckSchema()
/*      */   {
/*   71 */     this.mErrors = new CErrors();
/*      */ 
/*   73 */     String[] pk = new String[1];
/*   74 */     pk[0] = "CheckID";
/*      */ 
/*   76 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   83 */     MHonorCheckSchema cloned = (MHonorCheckSchema)super.clone();
/*   84 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   85 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   86 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   92 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getCheckID()
/*      */   {
/*   97 */     return this.checkID;
/*      */   }
/*      */ 
/*      */   public void setCheckID(String aCheckID) {
/*  101 */     this.checkID = aCheckID;
/*      */   }
/*      */ 
/*      */   public String getDataType() {
/*  105 */     return this.dataType;
/*      */   }
/*      */ 
/*      */   public void setDataType(String aDataType) {
/*  109 */     this.dataType = aDataType;
/*      */   }
/*      */ 
/*      */   public String getStatYear() {
/*  113 */     return this.statYear;
/*      */   }
/*      */ 
/*      */   public void setStatYear(String aStatYear) {
/*  117 */     this.statYear = aStatYear;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  121 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  125 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  129 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  133 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getStatBatch() {
/*  137 */     return this.statBatch;
/*      */   }
/*      */ 
/*      */   public void setStatBatch(String aStatBatch) {
/*  141 */     this.statBatch = aStatBatch;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  145 */     if (this.startDate != null) {
/*  146 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  148 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  152 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  156 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  158 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  161 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  166 */     if (this.endDate != null) {
/*  167 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  169 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  173 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  177 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  179 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  182 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckState()
/*      */   {
/*  187 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  191 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getInputState() {
/*  195 */     return this.inputState;
/*      */   }
/*      */ 
/*      */   public void setInputState(String aInputState) {
/*  199 */     this.inputState = aInputState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  203 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  207 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  211 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  215 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  219 */     if (this.checkDate != null) {
/*  220 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  222 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  226 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  230 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  232 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  235 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  240 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  244 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator() {
/*  248 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  252 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  256 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  260 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  264 */     if (this.makeDate != null) {
/*  265 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  267 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  271 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  275 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  277 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  280 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  285 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  289 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  293 */     if (this.modifyDate != null) {
/*  294 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  296 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  300 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  304 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  306 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  309 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  314 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  318 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MHonorCheckSchema aMHonorCheckSchema)
/*      */   {
/*  324 */     this.checkID = aMHonorCheckSchema.getCheckID();
/*  325 */     this.dataType = aMHonorCheckSchema.getDataType();
/*  326 */     this.statYear = aMHonorCheckSchema.getStatYear();
/*  327 */     this.manageCom = aMHonorCheckSchema.getManageCom();
/*  328 */     this.branchType = aMHonorCheckSchema.getBranchType();
/*  329 */     this.statBatch = aMHonorCheckSchema.getStatBatch();
/*  330 */     this.startDate = this.fDate.getDate(aMHonorCheckSchema.getStartDate());
/*  331 */     this.endDate = this.fDate.getDate(aMHonorCheckSchema.getEndDate());
/*  332 */     this.checkState = aMHonorCheckSchema.getCheckState();
/*  333 */     this.inputState = aMHonorCheckSchema.getInputState();
/*  334 */     this.checkOperator = aMHonorCheckSchema.getCheckOperator();
/*  335 */     this.checkReason = aMHonorCheckSchema.getCheckReason();
/*  336 */     this.checkDate = this.fDate.getDate(aMHonorCheckSchema.getCheckDate());
/*  337 */     this.checkTime = aMHonorCheckSchema.getCheckTime();
/*  338 */     this.modifyOperator = aMHonorCheckSchema.getModifyOperator();
/*  339 */     this.operator = aMHonorCheckSchema.getOperator();
/*  340 */     this.makeDate = this.fDate.getDate(aMHonorCheckSchema.getMakeDate());
/*  341 */     this.makeTime = aMHonorCheckSchema.getMakeTime();
/*  342 */     this.modifyDate = this.fDate.getDate(aMHonorCheckSchema.getModifyDate());
/*  343 */     this.modifyTime = aMHonorCheckSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  352 */       if (rs.getString("CheckID") == null)
/*  353 */         this.checkID = null;
/*      */       else {
/*  355 */         this.checkID = rs.getString("CheckID").trim();
/*      */       }
/*  357 */       if (rs.getString("DataType") == null)
/*  358 */         this.dataType = null;
/*      */       else {
/*  360 */         this.dataType = rs.getString("DataType").trim();
/*      */       }
/*  362 */       if (rs.getString("StatYear") == null)
/*  363 */         this.statYear = null;
/*      */       else {
/*  365 */         this.statYear = rs.getString("StatYear").trim();
/*      */       }
/*  367 */       if (rs.getString("ManageCom") == null)
/*  368 */         this.manageCom = null;
/*      */       else {
/*  370 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  372 */       if (rs.getString("BranchType") == null)
/*  373 */         this.branchType = null;
/*      */       else {
/*  375 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  377 */       if (rs.getString("StatBatch") == null)
/*  378 */         this.statBatch = null;
/*      */       else {
/*  380 */         this.statBatch = rs.getString("StatBatch").trim();
/*      */       }
/*  382 */       this.startDate = rs.getDate("StartDate");
/*  383 */       this.endDate = rs.getDate("EndDate");
/*  384 */       if (rs.getString("CheckState") == null)
/*  385 */         this.checkState = null;
/*      */       else {
/*  387 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  389 */       if (rs.getString("InputState") == null)
/*  390 */         this.inputState = null;
/*      */       else {
/*  392 */         this.inputState = rs.getString("InputState").trim();
/*      */       }
/*  394 */       if (rs.getString("CheckOperator") == null)
/*  395 */         this.checkOperator = null;
/*      */       else {
/*  397 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  399 */       if (rs.getString("CheckReason") == null)
/*  400 */         this.checkReason = null;
/*      */       else {
/*  402 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  404 */       this.checkDate = rs.getDate("CheckDate");
/*  405 */       if (rs.getString("CheckTime") == null)
/*  406 */         this.checkTime = null;
/*      */       else {
/*  408 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  410 */       if (rs.getString("ModifyOperator") == null)
/*  411 */         this.modifyOperator = null;
/*      */       else {
/*  413 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  415 */       if (rs.getString("Operator") == null)
/*  416 */         this.operator = null;
/*      */       else {
/*  418 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  420 */       this.makeDate = rs.getDate("MakeDate");
/*  421 */       if (rs.getString("MakeTime") == null)
/*  422 */         this.makeTime = null;
/*      */       else {
/*  424 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  426 */       this.modifyDate = rs.getDate("ModifyDate");
/*  427 */       if (rs.getString("ModifyTime") == null)
/*  428 */         this.modifyTime = null;
/*      */       else {
/*  430 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  435 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MHonorCheck\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  437 */       CError tError = new CError();
/*  438 */       tError.moduleName = "MHonorCheckSchema";
/*  439 */       tError.functionName = "setSchema";
/*  440 */       tError.errorMessage = sqle.toString();
/*  441 */       this.mErrors.addOneError(tError);
/*  442 */       return false;
/*      */     }
/*  444 */     return true;
/*      */   }
/*      */ 
/*      */   public MHonorCheckSchema getSchema()
/*      */   {
/*  449 */     MHonorCheckSchema aMHonorCheckSchema = new MHonorCheckSchema();
/*  450 */     aMHonorCheckSchema.setSchema(this);
/*  451 */     return aMHonorCheckSchema;
/*      */   }
/*      */ 
/*      */   public MHonorCheckDB getDB()
/*      */   {
/*  456 */     MHonorCheckDB aDBOper = new MHonorCheckDB();
/*  457 */     aDBOper.setSchema(this);
/*  458 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  465 */     StringBuffer strReturn = new StringBuffer(256);
/*  466 */     strReturn.append(StrTool.cTrim(this.checkID)); strReturn.append("|");
/*  467 */     strReturn.append(StrTool.cTrim(this.dataType)); strReturn.append("|");
/*  468 */     strReturn.append(StrTool.cTrim(this.statYear)); strReturn.append("|");
/*  469 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  470 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  471 */     strReturn.append(StrTool.cTrim(this.statBatch)); strReturn.append("|");
/*  472 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  473 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  474 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  475 */     strReturn.append(StrTool.cTrim(this.inputState)); strReturn.append("|");
/*  476 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  477 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  478 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  479 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  480 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  481 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  482 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  483 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  484 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  485 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  486 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  494 */       this.checkID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  495 */       this.dataType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  496 */       this.statYear = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  497 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  498 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  499 */       this.statBatch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  500 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
/*  501 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/*  502 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  503 */       this.inputState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  504 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  505 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  506 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
/*  507 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  508 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  509 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  510 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  511 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  512 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
/*  513 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  518 */       CError tError = new CError();
/*  519 */       tError.moduleName = "MHonorCheckSchema";
/*  520 */       tError.functionName = "decode";
/*  521 */       tError.errorMessage = ex.toString();
/*  522 */       this.mErrors.addOneError(tError);
/*      */ 
/*  524 */       return false;
/*      */     }
/*  526 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  532 */     String strReturn = "";
/*  533 */     if (FCode.equalsIgnoreCase("checkID"))
/*      */     {
/*  535 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkID));
/*      */     }
/*  537 */     if (FCode.equalsIgnoreCase("dataType"))
/*      */     {
/*  539 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dataType));
/*      */     }
/*  541 */     if (FCode.equalsIgnoreCase("statYear"))
/*      */     {
/*  543 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.statYear));
/*      */     }
/*  545 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  547 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  549 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  551 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  553 */     if (FCode.equalsIgnoreCase("statBatch"))
/*      */     {
/*  555 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.statBatch));
/*      */     }
/*  557 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  559 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  561 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  563 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  565 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  567 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  569 */     if (FCode.equalsIgnoreCase("inputState"))
/*      */     {
/*  571 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.inputState));
/*      */     }
/*  573 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  575 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  577 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  579 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  581 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  583 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  585 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  587 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  589 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  591 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  593 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  595 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  597 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  599 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  601 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  603 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  605 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  607 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  609 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  611 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  613 */     if (strReturn.equals(""))
/*      */     {
/*  615 */       strReturn = "null";
/*      */     }
/*      */ 
/*  618 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  625 */     String strFieldValue = "";
/*  626 */     switch (nFieldIndex) {
/*      */     case 0:
/*  628 */       strFieldValue = StrTool.GBKToUnicode(this.checkID);
/*  629 */       break;
/*      */     case 1:
/*  631 */       strFieldValue = StrTool.GBKToUnicode(this.dataType);
/*  632 */       break;
/*      */     case 2:
/*  634 */       strFieldValue = StrTool.GBKToUnicode(this.statYear);
/*  635 */       break;
/*      */     case 3:
/*  637 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  638 */       break;
/*      */     case 4:
/*  640 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  641 */       break;
/*      */     case 5:
/*  643 */       strFieldValue = StrTool.GBKToUnicode(this.statBatch);
/*  644 */       break;
/*      */     case 6:
/*  646 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  647 */       break;
/*      */     case 7:
/*  649 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*  650 */       break;
/*      */     case 8:
/*  652 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/*  653 */       break;
/*      */     case 9:
/*  655 */       strFieldValue = StrTool.GBKToUnicode(this.inputState);
/*  656 */       break;
/*      */     case 10:
/*  658 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/*  659 */       break;
/*      */     case 11:
/*  661 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/*  662 */       break;
/*      */     case 12:
/*  664 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*  665 */       break;
/*      */     case 13:
/*  667 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/*  668 */       break;
/*      */     case 14:
/*  670 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  671 */       break;
/*      */     case 15:
/*  673 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  674 */       break;
/*      */     case 16:
/*  676 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  677 */       break;
/*      */     case 17:
/*  679 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  680 */       break;
/*      */     case 18:
/*  682 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  683 */       break;
/*      */     case 19:
/*  685 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  686 */       break;
/*      */     default:
/*  688 */       strFieldValue = "";
/*      */     }
/*  690 */     if (strFieldValue.equals("")) {
/*  691 */       strFieldValue = "null";
/*      */     }
/*  693 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  699 */     if (StrTool.cTrim(FCode).equals("")) {
/*  700 */       return false;
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("checkID"))
/*      */     {
/*  704 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  706 */         this.checkID = FValue.trim();
/*      */       }
/*      */       else
/*  709 */         this.checkID = null;
/*      */     }
/*  711 */     if (FCode.equalsIgnoreCase("dataType"))
/*      */     {
/*  713 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  715 */         this.dataType = FValue.trim();
/*      */       }
/*      */       else
/*  718 */         this.dataType = null;
/*      */     }
/*  720 */     if (FCode.equalsIgnoreCase("statYear"))
/*      */     {
/*  722 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  724 */         this.statYear = FValue.trim();
/*      */       }
/*      */       else
/*  727 */         this.statYear = null;
/*      */     }
/*  729 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  731 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  733 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  736 */         this.manageCom = null;
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  740 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  742 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  745 */         this.branchType = null;
/*      */     }
/*  747 */     if (FCode.equalsIgnoreCase("statBatch"))
/*      */     {
/*  749 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  751 */         this.statBatch = FValue.trim();
/*      */       }
/*      */       else
/*  754 */         this.statBatch = null;
/*      */     }
/*  756 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  758 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  760 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  763 */         this.startDate = null;
/*      */     }
/*  765 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  767 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  769 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  772 */         this.endDate = null;
/*      */     }
/*  774 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  776 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  778 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/*  781 */         this.checkState = null;
/*      */     }
/*  783 */     if (FCode.equalsIgnoreCase("inputState"))
/*      */     {
/*  785 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  787 */         this.inputState = FValue.trim();
/*      */       }
/*      */       else
/*  790 */         this.inputState = null;
/*      */     }
/*  792 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  794 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  796 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/*  799 */         this.checkOperator = null;
/*      */     }
/*  801 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  803 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  805 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/*  808 */         this.checkReason = null;
/*      */     }
/*  810 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  812 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  814 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  817 */         this.checkDate = null;
/*      */     }
/*  819 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  821 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  823 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/*  826 */         this.checkTime = null;
/*      */     }
/*  828 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  830 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  832 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  835 */         this.modifyOperator = null;
/*      */     }
/*  837 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  839 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  841 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  844 */         this.operator = null;
/*      */     }
/*  846 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  848 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  850 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  853 */         this.makeDate = null;
/*      */     }
/*  855 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  857 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  859 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  862 */         this.makeTime = null;
/*      */     }
/*  864 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  866 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  868 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  871 */         this.modifyDate = null;
/*      */     }
/*  873 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  875 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  877 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  880 */         this.modifyTime = null;
/*      */     }
/*  882 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  887 */     if (otherObject == null) return false;
/*  888 */     if (this == otherObject) return true;
/*  889 */     if (getClass() != otherObject.getClass()) return false;
/*  890 */     MHonorCheckSchema other = (MHonorCheckSchema)otherObject;
/*  891 */     if ((this.checkID == null) && (other.getCheckID() != null)) return false;
/*  892 */     if ((this.checkID != null) && (!this.checkID.equals(other.getCheckID()))) return false;
/*  893 */     if ((this.dataType == null) && (other.getDataType() != null)) return false;
/*  894 */     if ((this.dataType != null) && (!this.dataType.equals(other.getDataType()))) return false;
/*  895 */     if ((this.statYear == null) && (other.getStatYear() != null)) return false;
/*  896 */     if ((this.statYear != null) && (!this.statYear.equals(other.getStatYear()))) return false;
/*  897 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/*  898 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/*  899 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/*  900 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/*  901 */     if ((this.statBatch == null) && (other.getStatBatch() != null)) return false;
/*  902 */     if ((this.statBatch != null) && (!this.statBatch.equals(other.getStatBatch()))) return false;
/*  903 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/*  904 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/*  905 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/*  906 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/*  907 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/*  908 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/*  909 */     if ((this.inputState == null) && (other.getInputState() != null)) return false;
/*  910 */     if ((this.inputState != null) && (!this.inputState.equals(other.getInputState()))) return false;
/*  911 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/*  912 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/*  913 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/*  914 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/*  915 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/*  916 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/*  917 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/*  918 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/*  919 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/*  920 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/*  921 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  922 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  923 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  924 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  925 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  926 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  927 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  928 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  929 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  930 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  937 */     return 20;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  943 */     if (strFieldName.equals("checkID")) {
/*  944 */       return 0;
/*      */     }
/*  946 */     if (strFieldName.equals("dataType")) {
/*  947 */       return 1;
/*      */     }
/*  949 */     if (strFieldName.equals("statYear")) {
/*  950 */       return 2;
/*      */     }
/*  952 */     if (strFieldName.equals("manageCom")) {
/*  953 */       return 3;
/*      */     }
/*  955 */     if (strFieldName.equals("branchType")) {
/*  956 */       return 4;
/*      */     }
/*  958 */     if (strFieldName.equals("statBatch")) {
/*  959 */       return 5;
/*      */     }
/*  961 */     if (strFieldName.equals("startDate")) {
/*  962 */       return 6;
/*      */     }
/*  964 */     if (strFieldName.equals("endDate")) {
/*  965 */       return 7;
/*      */     }
/*  967 */     if (strFieldName.equals("checkState")) {
/*  968 */       return 8;
/*      */     }
/*  970 */     if (strFieldName.equals("inputState")) {
/*  971 */       return 9;
/*      */     }
/*  973 */     if (strFieldName.equals("checkOperator")) {
/*  974 */       return 10;
/*      */     }
/*  976 */     if (strFieldName.equals("checkReason")) {
/*  977 */       return 11;
/*      */     }
/*  979 */     if (strFieldName.equals("checkDate")) {
/*  980 */       return 12;
/*      */     }
/*  982 */     if (strFieldName.equals("checkTime")) {
/*  983 */       return 13;
/*      */     }
/*  985 */     if (strFieldName.equals("modifyOperator")) {
/*  986 */       return 14;
/*      */     }
/*  988 */     if (strFieldName.equals("operator")) {
/*  989 */       return 15;
/*      */     }
/*  991 */     if (strFieldName.equals("makeDate")) {
/*  992 */       return 16;
/*      */     }
/*  994 */     if (strFieldName.equals("makeTime")) {
/*  995 */       return 17;
/*      */     }
/*  997 */     if (strFieldName.equals("modifyDate")) {
/*  998 */       return 18;
/*      */     }
/* 1000 */     if (strFieldName.equals("modifyTime")) {
/* 1001 */       return 19;
/*      */     }
/* 1003 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1009 */     String strFieldName = "";
/* 1010 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1012 */       strFieldName = "checkID";
/* 1013 */       break;
/*      */     case 1:
/* 1015 */       strFieldName = "dataType";
/* 1016 */       break;
/*      */     case 2:
/* 1018 */       strFieldName = "statYear";
/* 1019 */       break;
/*      */     case 3:
/* 1021 */       strFieldName = "manageCom";
/* 1022 */       break;
/*      */     case 4:
/* 1024 */       strFieldName = "branchType";
/* 1025 */       break;
/*      */     case 5:
/* 1027 */       strFieldName = "statBatch";
/* 1028 */       break;
/*      */     case 6:
/* 1030 */       strFieldName = "startDate";
/* 1031 */       break;
/*      */     case 7:
/* 1033 */       strFieldName = "endDate";
/* 1034 */       break;
/*      */     case 8:
/* 1036 */       strFieldName = "checkState";
/* 1037 */       break;
/*      */     case 9:
/* 1039 */       strFieldName = "inputState";
/* 1040 */       break;
/*      */     case 10:
/* 1042 */       strFieldName = "checkOperator";
/* 1043 */       break;
/*      */     case 11:
/* 1045 */       strFieldName = "checkReason";
/* 1046 */       break;
/*      */     case 12:
/* 1048 */       strFieldName = "checkDate";
/* 1049 */       break;
/*      */     case 13:
/* 1051 */       strFieldName = "checkTime";
/* 1052 */       break;
/*      */     case 14:
/* 1054 */       strFieldName = "modifyOperator";
/* 1055 */       break;
/*      */     case 15:
/* 1057 */       strFieldName = "operator";
/* 1058 */       break;
/*      */     case 16:
/* 1060 */       strFieldName = "makeDate";
/* 1061 */       break;
/*      */     case 17:
/* 1063 */       strFieldName = "makeTime";
/* 1064 */       break;
/*      */     case 18:
/* 1066 */       strFieldName = "modifyDate";
/* 1067 */       break;
/*      */     case 19:
/* 1069 */       strFieldName = "modifyTime";
/* 1070 */       break;
/*      */     default:
/* 1072 */       strFieldName = "";
/*      */     }
/* 1074 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1080 */     if (strFieldName.equals("checkID")) {
/* 1081 */       return 0;
/*      */     }
/* 1083 */     if (strFieldName.equals("dataType")) {
/* 1084 */       return 0;
/*      */     }
/* 1086 */     if (strFieldName.equals("statYear")) {
/* 1087 */       return 0;
/*      */     }
/* 1089 */     if (strFieldName.equals("manageCom")) {
/* 1090 */       return 0;
/*      */     }
/* 1092 */     if (strFieldName.equals("branchType")) {
/* 1093 */       return 0;
/*      */     }
/* 1095 */     if (strFieldName.equals("statBatch")) {
/* 1096 */       return 0;
/*      */     }
/* 1098 */     if (strFieldName.equals("startDate")) {
/* 1099 */       return 1;
/*      */     }
/* 1101 */     if (strFieldName.equals("endDate")) {
/* 1102 */       return 1;
/*      */     }
/* 1104 */     if (strFieldName.equals("checkState")) {
/* 1105 */       return 0;
/*      */     }
/* 1107 */     if (strFieldName.equals("inputState")) {
/* 1108 */       return 0;
/*      */     }
/* 1110 */     if (strFieldName.equals("checkOperator")) {
/* 1111 */       return 0;
/*      */     }
/* 1113 */     if (strFieldName.equals("checkReason")) {
/* 1114 */       return 0;
/*      */     }
/* 1116 */     if (strFieldName.equals("checkDate")) {
/* 1117 */       return 1;
/*      */     }
/* 1119 */     if (strFieldName.equals("checkTime")) {
/* 1120 */       return 0;
/*      */     }
/* 1122 */     if (strFieldName.equals("modifyOperator")) {
/* 1123 */       return 0;
/*      */     }
/* 1125 */     if (strFieldName.equals("operator")) {
/* 1126 */       return 0;
/*      */     }
/* 1128 */     if (strFieldName.equals("makeDate")) {
/* 1129 */       return 1;
/*      */     }
/* 1131 */     if (strFieldName.equals("makeTime")) {
/* 1132 */       return 0;
/*      */     }
/* 1134 */     if (strFieldName.equals("modifyDate")) {
/* 1135 */       return 1;
/*      */     }
/* 1137 */     if (strFieldName.equals("modifyTime")) {
/* 1138 */       return 0;
/*      */     }
/* 1140 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1146 */     int nFieldType = -1;
/* 1147 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1149 */       nFieldType = 0;
/* 1150 */       break;
/*      */     case 1:
/* 1152 */       nFieldType = 0;
/* 1153 */       break;
/*      */     case 2:
/* 1155 */       nFieldType = 0;
/* 1156 */       break;
/*      */     case 3:
/* 1158 */       nFieldType = 0;
/* 1159 */       break;
/*      */     case 4:
/* 1161 */       nFieldType = 0;
/* 1162 */       break;
/*      */     case 5:
/* 1164 */       nFieldType = 0;
/* 1165 */       break;
/*      */     case 6:
/* 1167 */       nFieldType = 1;
/* 1168 */       break;
/*      */     case 7:
/* 1170 */       nFieldType = 1;
/* 1171 */       break;
/*      */     case 8:
/* 1173 */       nFieldType = 0;
/* 1174 */       break;
/*      */     case 9:
/* 1176 */       nFieldType = 0;
/* 1177 */       break;
/*      */     case 10:
/* 1179 */       nFieldType = 0;
/* 1180 */       break;
/*      */     case 11:
/* 1182 */       nFieldType = 0;
/* 1183 */       break;
/*      */     case 12:
/* 1185 */       nFieldType = 1;
/* 1186 */       break;
/*      */     case 13:
/* 1188 */       nFieldType = 0;
/* 1189 */       break;
/*      */     case 14:
/* 1191 */       nFieldType = 0;
/* 1192 */       break;
/*      */     case 15:
/* 1194 */       nFieldType = 0;
/* 1195 */       break;
/*      */     case 16:
/* 1197 */       nFieldType = 1;
/* 1198 */       break;
/*      */     case 17:
/* 1200 */       nFieldType = 0;
/* 1201 */       break;
/*      */     case 18:
/* 1203 */       nFieldType = 1;
/* 1204 */       break;
/*      */     case 19:
/* 1206 */       nFieldType = 0;
/* 1207 */       break;
/*      */     default:
/* 1209 */       nFieldType = -1;
/*      */     }
/* 1211 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MHonorCheckSchema
 * JD-Core Version:    0.6.0
 */