/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MHonorCheckBDB;
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
/*      */ public class MHonorCheckBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String checkID;
/*      */   private String dataType;
/*      */   private String statYear;
/*      */   private String statBatch;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private Date startDate;
/*      */   private Date endDate;
/*      */   private String checkState;
/*      */   private String inputState;
/*      */   private String checkOperator;
/*      */   private String checkReason;
/*      */   private Date checkDate;
/*      */   private String checkTime;
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   private String modifyOperator;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 26;
/*      */   private static String[] PK;
/*   76 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MHonorCheckBSchema()
/*      */   {
/*   83 */     this.mErrors = new CErrors();
/*      */ 
/*   85 */     String[] pk = new String[1];
/*   86 */     pk[0] = "EdorNo";
/*      */ 
/*   88 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   95 */     MHonorCheckBSchema cloned = (MHonorCheckBSchema)super.clone();
/*   96 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   97 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   98 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  104 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getCheckID()
/*      */   {
/*  109 */     return this.checkID;
/*      */   }
/*      */ 
/*      */   public void setCheckID(String aCheckID) {
/*  113 */     this.checkID = aCheckID;
/*      */   }
/*      */ 
/*      */   public String getDataType() {
/*  117 */     return this.dataType;
/*      */   }
/*      */ 
/*      */   public void setDataType(String aDataType) {
/*  121 */     this.dataType = aDataType;
/*      */   }
/*      */ 
/*      */   public String getStatYear() {
/*  125 */     return this.statYear;
/*      */   }
/*      */ 
/*      */   public void setStatYear(String aStatYear) {
/*  129 */     this.statYear = aStatYear;
/*      */   }
/*      */ 
/*      */   public String getStatBatch() {
/*  133 */     return this.statBatch;
/*      */   }
/*      */ 
/*      */   public void setStatBatch(String aStatBatch) {
/*  137 */     this.statBatch = aStatBatch;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  141 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  145 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  149 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  153 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  157 */     if (this.startDate != null) {
/*  158 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  160 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  164 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  168 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  170 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  173 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  178 */     if (this.endDate != null) {
/*  179 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  181 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  185 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  189 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  191 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  194 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckState()
/*      */   {
/*  199 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  203 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getInputState() {
/*  207 */     return this.inputState;
/*      */   }
/*      */ 
/*      */   public void setInputState(String aInputState) {
/*  211 */     this.inputState = aInputState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  215 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  219 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  223 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  227 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  231 */     if (this.checkDate != null) {
/*  232 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  234 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  238 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  242 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  244 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  247 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  252 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  256 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  260 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  264 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  268 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  272 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  276 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  280 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  284 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  288 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  292 */     if (this.makeDate2 != null) {
/*  293 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  295 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  299 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  303 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  305 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  308 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  313 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  317 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator() {
/*  321 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  325 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  329 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  333 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  337 */     if (this.makeDate != null) {
/*  338 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  340 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  344 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  348 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  350 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  353 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  358 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  362 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  366 */     if (this.modifyDate != null) {
/*  367 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  369 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  373 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  377 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  379 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  382 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  387 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  391 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MHonorCheckBSchema aMHonorCheckBSchema)
/*      */   {
/*  397 */     this.checkID = aMHonorCheckBSchema.getCheckID();
/*  398 */     this.dataType = aMHonorCheckBSchema.getDataType();
/*  399 */     this.statYear = aMHonorCheckBSchema.getStatYear();
/*  400 */     this.statBatch = aMHonorCheckBSchema.getStatBatch();
/*  401 */     this.manageCom = aMHonorCheckBSchema.getManageCom();
/*  402 */     this.branchType = aMHonorCheckBSchema.getBranchType();
/*  403 */     this.startDate = this.fDate.getDate(aMHonorCheckBSchema.getStartDate());
/*  404 */     this.endDate = this.fDate.getDate(aMHonorCheckBSchema.getEndDate());
/*  405 */     this.checkState = aMHonorCheckBSchema.getCheckState();
/*  406 */     this.inputState = aMHonorCheckBSchema.getInputState();
/*  407 */     this.checkOperator = aMHonorCheckBSchema.getCheckOperator();
/*  408 */     this.checkReason = aMHonorCheckBSchema.getCheckReason();
/*  409 */     this.checkDate = this.fDate.getDate(aMHonorCheckBSchema.getCheckDate());
/*  410 */     this.checkTime = aMHonorCheckBSchema.getCheckTime();
/*  411 */     this.edorNo = aMHonorCheckBSchema.getEdorNo();
/*  412 */     this.edorType = aMHonorCheckBSchema.getEdorType();
/*  413 */     this.edorCase = aMHonorCheckBSchema.getEdorCase();
/*  414 */     this.operator2 = aMHonorCheckBSchema.getOperator2();
/*  415 */     this.makeDate2 = this.fDate.getDate(aMHonorCheckBSchema.getMakeDate2());
/*  416 */     this.makeTime2 = aMHonorCheckBSchema.getMakeTime2();
/*  417 */     this.modifyOperator = aMHonorCheckBSchema.getModifyOperator();
/*  418 */     this.operator = aMHonorCheckBSchema.getOperator();
/*  419 */     this.makeDate = this.fDate.getDate(aMHonorCheckBSchema.getMakeDate());
/*  420 */     this.makeTime = aMHonorCheckBSchema.getMakeTime();
/*  421 */     this.modifyDate = this.fDate.getDate(aMHonorCheckBSchema.getModifyDate());
/*  422 */     this.modifyTime = aMHonorCheckBSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  431 */       if (rs.getString("CheckID") == null)
/*  432 */         this.checkID = null;
/*      */       else {
/*  434 */         this.checkID = rs.getString("CheckID").trim();
/*      */       }
/*  436 */       if (rs.getString("DataType") == null)
/*  437 */         this.dataType = null;
/*      */       else {
/*  439 */         this.dataType = rs.getString("DataType").trim();
/*      */       }
/*  441 */       if (rs.getString("StatYear") == null)
/*  442 */         this.statYear = null;
/*      */       else {
/*  444 */         this.statYear = rs.getString("StatYear").trim();
/*      */       }
/*  446 */       if (rs.getString("StatBatch") == null)
/*  447 */         this.statBatch = null;
/*      */       else {
/*  449 */         this.statBatch = rs.getString("StatBatch").trim();
/*      */       }
/*  451 */       if (rs.getString("ManageCom") == null)
/*  452 */         this.manageCom = null;
/*      */       else {
/*  454 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  456 */       if (rs.getString("BranchType") == null)
/*  457 */         this.branchType = null;
/*      */       else {
/*  459 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  461 */       this.startDate = rs.getDate("StartDate");
/*  462 */       this.endDate = rs.getDate("EndDate");
/*  463 */       if (rs.getString("CheckState") == null)
/*  464 */         this.checkState = null;
/*      */       else {
/*  466 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  468 */       if (rs.getString("InputState") == null)
/*  469 */         this.inputState = null;
/*      */       else {
/*  471 */         this.inputState = rs.getString("InputState").trim();
/*      */       }
/*  473 */       if (rs.getString("CheckOperator") == null)
/*  474 */         this.checkOperator = null;
/*      */       else {
/*  476 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  478 */       if (rs.getString("CheckReason") == null)
/*  479 */         this.checkReason = null;
/*      */       else {
/*  481 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  483 */       this.checkDate = rs.getDate("CheckDate");
/*  484 */       if (rs.getString("CheckTime") == null)
/*  485 */         this.checkTime = null;
/*      */       else {
/*  487 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  489 */       if (rs.getString("EdorNo") == null)
/*  490 */         this.edorNo = null;
/*      */       else {
/*  492 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  494 */       if (rs.getString("EdorType") == null)
/*  495 */         this.edorType = null;
/*      */       else {
/*  497 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  499 */       if (rs.getString("EdorCase") == null)
/*  500 */         this.edorCase = null;
/*      */       else {
/*  502 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  504 */       if (rs.getString("Operator2") == null)
/*  505 */         this.operator2 = null;
/*      */       else {
/*  507 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  509 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  510 */       if (rs.getString("MakeTime2") == null)
/*  511 */         this.makeTime2 = null;
/*      */       else {
/*  513 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*  515 */       if (rs.getString("ModifyOperator") == null)
/*  516 */         this.modifyOperator = null;
/*      */       else {
/*  518 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  520 */       if (rs.getString("Operator") == null)
/*  521 */         this.operator = null;
/*      */       else {
/*  523 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  525 */       this.makeDate = rs.getDate("MakeDate");
/*  526 */       if (rs.getString("MakeTime") == null)
/*  527 */         this.makeTime = null;
/*      */       else {
/*  529 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  531 */       this.modifyDate = rs.getDate("ModifyDate");
/*  532 */       if (rs.getString("ModifyTime") == null)
/*  533 */         this.modifyTime = null;
/*      */       else {
/*  535 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  540 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MHonorCheckB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  542 */       CError tError = new CError();
/*  543 */       tError.moduleName = "MHonorCheckBSchema";
/*  544 */       tError.functionName = "setSchema";
/*  545 */       tError.errorMessage = sqle.toString();
/*  546 */       this.mErrors.addOneError(tError);
/*  547 */       return false;
/*      */     }
/*  549 */     return true;
/*      */   }
/*      */ 
/*      */   public MHonorCheckBSchema getSchema()
/*      */   {
/*  554 */     MHonorCheckBSchema aMHonorCheckBSchema = new MHonorCheckBSchema();
/*  555 */     aMHonorCheckBSchema.setSchema(this);
/*  556 */     return aMHonorCheckBSchema;
/*      */   }
/*      */ 
/*      */   public MHonorCheckBDB getDB()
/*      */   {
/*  561 */     MHonorCheckBDB aDBOper = new MHonorCheckBDB();
/*  562 */     aDBOper.setSchema(this);
/*  563 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  570 */     StringBuffer strReturn = new StringBuffer(256);
/*  571 */     strReturn.append(StrTool.cTrim(this.checkID)); strReturn.append("|");
/*  572 */     strReturn.append(StrTool.cTrim(this.dataType)); strReturn.append("|");
/*  573 */     strReturn.append(StrTool.cTrim(this.statYear)); strReturn.append("|");
/*  574 */     strReturn.append(StrTool.cTrim(this.statBatch)); strReturn.append("|");
/*  575 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  576 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  577 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  578 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  579 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  580 */     strReturn.append(StrTool.cTrim(this.inputState)); strReturn.append("|");
/*  581 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  582 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  583 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  584 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  585 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  586 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  587 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  588 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  589 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  590 */     strReturn.append(StrTool.cTrim(this.makeTime2)); strReturn.append("|");
/*  591 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  592 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  593 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  594 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  595 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  596 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  597 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  605 */       this.checkID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  606 */       this.dataType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  607 */       this.statYear = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  608 */       this.statBatch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  609 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  610 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  611 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
/*  612 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/*  613 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  614 */       this.inputState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  615 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  616 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  617 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
/*  618 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  619 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  620 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  621 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  622 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  623 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
/*  624 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  625 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  626 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  627 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
/*  628 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  629 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
/*  630 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  635 */       CError tError = new CError();
/*  636 */       tError.moduleName = "MHonorCheckBSchema";
/*  637 */       tError.functionName = "decode";
/*  638 */       tError.errorMessage = ex.toString();
/*  639 */       this.mErrors.addOneError(tError);
/*      */ 
/*  641 */       return false;
/*      */     }
/*  643 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  649 */     String strReturn = "";
/*  650 */     if (FCode.equalsIgnoreCase("checkID"))
/*      */     {
/*  652 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkID));
/*      */     }
/*  654 */     if (FCode.equalsIgnoreCase("dataType"))
/*      */     {
/*  656 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dataType));
/*      */     }
/*  658 */     if (FCode.equalsIgnoreCase("statYear"))
/*      */     {
/*  660 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.statYear));
/*      */     }
/*  662 */     if (FCode.equalsIgnoreCase("statBatch"))
/*      */     {
/*  664 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.statBatch));
/*      */     }
/*  666 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  668 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  670 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  672 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  676 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  678 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  680 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  682 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  684 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  686 */     if (FCode.equalsIgnoreCase("inputState"))
/*      */     {
/*  688 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.inputState));
/*      */     }
/*  690 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  692 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  694 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  696 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  698 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  700 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  704 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  706 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  708 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  712 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  714 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  716 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  718 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  720 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  722 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  724 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  726 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  728 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  730 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  732 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  734 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  736 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  740 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  742 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  744 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  748 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  750 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  752 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  754 */     if (strReturn.equals(""))
/*      */     {
/*  756 */       strReturn = "null";
/*      */     }
/*      */ 
/*  759 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  766 */     String strFieldValue = "";
/*  767 */     switch (nFieldIndex) {
/*      */     case 0:
/*  769 */       strFieldValue = StrTool.GBKToUnicode(this.checkID);
/*  770 */       break;
/*      */     case 1:
/*  772 */       strFieldValue = StrTool.GBKToUnicode(this.dataType);
/*  773 */       break;
/*      */     case 2:
/*  775 */       strFieldValue = StrTool.GBKToUnicode(this.statYear);
/*  776 */       break;
/*      */     case 3:
/*  778 */       strFieldValue = StrTool.GBKToUnicode(this.statBatch);
/*  779 */       break;
/*      */     case 4:
/*  781 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  782 */       break;
/*      */     case 5:
/*  784 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  785 */       break;
/*      */     case 6:
/*  787 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  788 */       break;
/*      */     case 7:
/*  790 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*  791 */       break;
/*      */     case 8:
/*  793 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/*  794 */       break;
/*      */     case 9:
/*  796 */       strFieldValue = StrTool.GBKToUnicode(this.inputState);
/*  797 */       break;
/*      */     case 10:
/*  799 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/*  800 */       break;
/*      */     case 11:
/*  802 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/*  803 */       break;
/*      */     case 12:
/*  805 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*  806 */       break;
/*      */     case 13:
/*  808 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/*  809 */       break;
/*      */     case 14:
/*  811 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  812 */       break;
/*      */     case 15:
/*  814 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  815 */       break;
/*      */     case 16:
/*  817 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  818 */       break;
/*      */     case 17:
/*  820 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  821 */       break;
/*      */     case 18:
/*  823 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  824 */       break;
/*      */     case 19:
/*  826 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  827 */       break;
/*      */     case 20:
/*  829 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  830 */       break;
/*      */     case 21:
/*  832 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  833 */       break;
/*      */     case 22:
/*  835 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  836 */       break;
/*      */     case 23:
/*  838 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  839 */       break;
/*      */     case 24:
/*  841 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  842 */       break;
/*      */     case 25:
/*  844 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  845 */       break;
/*      */     default:
/*  847 */       strFieldValue = "";
/*      */     }
/*  849 */     if (strFieldValue.equals("")) {
/*  850 */       strFieldValue = "null";
/*      */     }
/*  852 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  858 */     if (StrTool.cTrim(FCode).equals("")) {
/*  859 */       return false;
/*      */     }
/*  861 */     if (FCode.equalsIgnoreCase("checkID"))
/*      */     {
/*  863 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  865 */         this.checkID = FValue.trim();
/*      */       }
/*      */       else
/*  868 */         this.checkID = null;
/*      */     }
/*  870 */     if (FCode.equalsIgnoreCase("dataType"))
/*      */     {
/*  872 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  874 */         this.dataType = FValue.trim();
/*      */       }
/*      */       else
/*  877 */         this.dataType = null;
/*      */     }
/*  879 */     if (FCode.equalsIgnoreCase("statYear"))
/*      */     {
/*  881 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  883 */         this.statYear = FValue.trim();
/*      */       }
/*      */       else
/*  886 */         this.statYear = null;
/*      */     }
/*  888 */     if (FCode.equalsIgnoreCase("statBatch"))
/*      */     {
/*  890 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  892 */         this.statBatch = FValue.trim();
/*      */       }
/*      */       else
/*  895 */         this.statBatch = null;
/*      */     }
/*  897 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  899 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  901 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  904 */         this.manageCom = null;
/*      */     }
/*  906 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  908 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  910 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  913 */         this.branchType = null;
/*      */     }
/*  915 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  917 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  919 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  922 */         this.startDate = null;
/*      */     }
/*  924 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  926 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  928 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  931 */         this.endDate = null;
/*      */     }
/*  933 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  935 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  937 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/*  940 */         this.checkState = null;
/*      */     }
/*  942 */     if (FCode.equalsIgnoreCase("inputState"))
/*      */     {
/*  944 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  946 */         this.inputState = FValue.trim();
/*      */       }
/*      */       else
/*  949 */         this.inputState = null;
/*      */     }
/*  951 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  953 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  955 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/*  958 */         this.checkOperator = null;
/*      */     }
/*  960 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  962 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  964 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/*  967 */         this.checkReason = null;
/*      */     }
/*  969 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  971 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  973 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  976 */         this.checkDate = null;
/*      */     }
/*  978 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  980 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  982 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/*  985 */         this.checkTime = null;
/*      */     }
/*  987 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  989 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  991 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/*  994 */         this.edorNo = null;
/*      */     }
/*  996 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  998 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1000 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1003 */         this.edorType = null;
/*      */     }
/* 1005 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1007 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1009 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1012 */         this.edorCase = null;
/*      */     }
/* 1014 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1016 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1018 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1021 */         this.operator2 = null;
/*      */     }
/* 1023 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1025 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1027 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1030 */         this.makeDate2 = null;
/*      */     }
/* 1032 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1034 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1036 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1039 */         this.makeTime2 = null;
/*      */     }
/* 1041 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1043 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1045 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1048 */         this.modifyOperator = null;
/*      */     }
/* 1050 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1052 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1054 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1057 */         this.operator = null;
/*      */     }
/* 1059 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1061 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1063 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1066 */         this.makeDate = null;
/*      */     }
/* 1068 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1070 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1072 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1075 */         this.makeTime = null;
/*      */     }
/* 1077 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1079 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1081 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1084 */         this.modifyDate = null;
/*      */     }
/* 1086 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1088 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1090 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1093 */         this.modifyTime = null;
/*      */     }
/* 1095 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1100 */     if (otherObject == null) return false;
/* 1101 */     if (this == otherObject) return true;
/* 1102 */     if (getClass() != otherObject.getClass()) return false;
/* 1103 */     MHonorCheckBSchema other = (MHonorCheckBSchema)otherObject;
/* 1104 */     if ((this.checkID == null) && (other.getCheckID() != null)) return false;
/* 1105 */     if ((this.checkID != null) && (!this.checkID.equals(other.getCheckID()))) return false;
/* 1106 */     if ((this.dataType == null) && (other.getDataType() != null)) return false;
/* 1107 */     if ((this.dataType != null) && (!this.dataType.equals(other.getDataType()))) return false;
/* 1108 */     if ((this.statYear == null) && (other.getStatYear() != null)) return false;
/* 1109 */     if ((this.statYear != null) && (!this.statYear.equals(other.getStatYear()))) return false;
/* 1110 */     if ((this.statBatch == null) && (other.getStatBatch() != null)) return false;
/* 1111 */     if ((this.statBatch != null) && (!this.statBatch.equals(other.getStatBatch()))) return false;
/* 1112 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1113 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1114 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1115 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1116 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 1117 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 1118 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 1119 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 1120 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1121 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1122 */     if ((this.inputState == null) && (other.getInputState() != null)) return false;
/* 1123 */     if ((this.inputState != null) && (!this.inputState.equals(other.getInputState()))) return false;
/* 1124 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1125 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1126 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1127 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1128 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1129 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1130 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1131 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1132 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1133 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1134 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1135 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1136 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1137 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1138 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1139 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1140 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1141 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1142 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1143 */     if ((this.makeTime2 != null) && (!this.makeTime2.equals(other.getMakeTime2()))) return false;
/* 1144 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1145 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1146 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1147 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1148 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1149 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1150 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1151 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1152 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1153 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1154 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1155 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1162 */     return 26;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1168 */     if (strFieldName.equals("checkID")) {
/* 1169 */       return 0;
/*      */     }
/* 1171 */     if (strFieldName.equals("dataType")) {
/* 1172 */       return 1;
/*      */     }
/* 1174 */     if (strFieldName.equals("statYear")) {
/* 1175 */       return 2;
/*      */     }
/* 1177 */     if (strFieldName.equals("statBatch")) {
/* 1178 */       return 3;
/*      */     }
/* 1180 */     if (strFieldName.equals("manageCom")) {
/* 1181 */       return 4;
/*      */     }
/* 1183 */     if (strFieldName.equals("branchType")) {
/* 1184 */       return 5;
/*      */     }
/* 1186 */     if (strFieldName.equals("startDate")) {
/* 1187 */       return 6;
/*      */     }
/* 1189 */     if (strFieldName.equals("endDate")) {
/* 1190 */       return 7;
/*      */     }
/* 1192 */     if (strFieldName.equals("checkState")) {
/* 1193 */       return 8;
/*      */     }
/* 1195 */     if (strFieldName.equals("inputState")) {
/* 1196 */       return 9;
/*      */     }
/* 1198 */     if (strFieldName.equals("checkOperator")) {
/* 1199 */       return 10;
/*      */     }
/* 1201 */     if (strFieldName.equals("checkReason")) {
/* 1202 */       return 11;
/*      */     }
/* 1204 */     if (strFieldName.equals("checkDate")) {
/* 1205 */       return 12;
/*      */     }
/* 1207 */     if (strFieldName.equals("checkTime")) {
/* 1208 */       return 13;
/*      */     }
/* 1210 */     if (strFieldName.equals("edorNo")) {
/* 1211 */       return 14;
/*      */     }
/* 1213 */     if (strFieldName.equals("edorType")) {
/* 1214 */       return 15;
/*      */     }
/* 1216 */     if (strFieldName.equals("edorCase")) {
/* 1217 */       return 16;
/*      */     }
/* 1219 */     if (strFieldName.equals("operator2")) {
/* 1220 */       return 17;
/*      */     }
/* 1222 */     if (strFieldName.equals("makeDate2")) {
/* 1223 */       return 18;
/*      */     }
/* 1225 */     if (strFieldName.equals("makeTime2")) {
/* 1226 */       return 19;
/*      */     }
/* 1228 */     if (strFieldName.equals("modifyOperator")) {
/* 1229 */       return 20;
/*      */     }
/* 1231 */     if (strFieldName.equals("operator")) {
/* 1232 */       return 21;
/*      */     }
/* 1234 */     if (strFieldName.equals("makeDate")) {
/* 1235 */       return 22;
/*      */     }
/* 1237 */     if (strFieldName.equals("makeTime")) {
/* 1238 */       return 23;
/*      */     }
/* 1240 */     if (strFieldName.equals("modifyDate")) {
/* 1241 */       return 24;
/*      */     }
/* 1243 */     if (strFieldName.equals("modifyTime")) {
/* 1244 */       return 25;
/*      */     }
/* 1246 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1252 */     String strFieldName = "";
/* 1253 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1255 */       strFieldName = "checkID";
/* 1256 */       break;
/*      */     case 1:
/* 1258 */       strFieldName = "dataType";
/* 1259 */       break;
/*      */     case 2:
/* 1261 */       strFieldName = "statYear";
/* 1262 */       break;
/*      */     case 3:
/* 1264 */       strFieldName = "statBatch";
/* 1265 */       break;
/*      */     case 4:
/* 1267 */       strFieldName = "manageCom";
/* 1268 */       break;
/*      */     case 5:
/* 1270 */       strFieldName = "branchType";
/* 1271 */       break;
/*      */     case 6:
/* 1273 */       strFieldName = "startDate";
/* 1274 */       break;
/*      */     case 7:
/* 1276 */       strFieldName = "endDate";
/* 1277 */       break;
/*      */     case 8:
/* 1279 */       strFieldName = "checkState";
/* 1280 */       break;
/*      */     case 9:
/* 1282 */       strFieldName = "inputState";
/* 1283 */       break;
/*      */     case 10:
/* 1285 */       strFieldName = "checkOperator";
/* 1286 */       break;
/*      */     case 11:
/* 1288 */       strFieldName = "checkReason";
/* 1289 */       break;
/*      */     case 12:
/* 1291 */       strFieldName = "checkDate";
/* 1292 */       break;
/*      */     case 13:
/* 1294 */       strFieldName = "checkTime";
/* 1295 */       break;
/*      */     case 14:
/* 1297 */       strFieldName = "edorNo";
/* 1298 */       break;
/*      */     case 15:
/* 1300 */       strFieldName = "edorType";
/* 1301 */       break;
/*      */     case 16:
/* 1303 */       strFieldName = "edorCase";
/* 1304 */       break;
/*      */     case 17:
/* 1306 */       strFieldName = "operator2";
/* 1307 */       break;
/*      */     case 18:
/* 1309 */       strFieldName = "makeDate2";
/* 1310 */       break;
/*      */     case 19:
/* 1312 */       strFieldName = "makeTime2";
/* 1313 */       break;
/*      */     case 20:
/* 1315 */       strFieldName = "modifyOperator";
/* 1316 */       break;
/*      */     case 21:
/* 1318 */       strFieldName = "operator";
/* 1319 */       break;
/*      */     case 22:
/* 1321 */       strFieldName = "makeDate";
/* 1322 */       break;
/*      */     case 23:
/* 1324 */       strFieldName = "makeTime";
/* 1325 */       break;
/*      */     case 24:
/* 1327 */       strFieldName = "modifyDate";
/* 1328 */       break;
/*      */     case 25:
/* 1330 */       strFieldName = "modifyTime";
/* 1331 */       break;
/*      */     default:
/* 1333 */       strFieldName = "";
/*      */     }
/* 1335 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1341 */     if (strFieldName.equals("checkID")) {
/* 1342 */       return 0;
/*      */     }
/* 1344 */     if (strFieldName.equals("dataType")) {
/* 1345 */       return 0;
/*      */     }
/* 1347 */     if (strFieldName.equals("statYear")) {
/* 1348 */       return 0;
/*      */     }
/* 1350 */     if (strFieldName.equals("statBatch")) {
/* 1351 */       return 0;
/*      */     }
/* 1353 */     if (strFieldName.equals("manageCom")) {
/* 1354 */       return 0;
/*      */     }
/* 1356 */     if (strFieldName.equals("branchType")) {
/* 1357 */       return 0;
/*      */     }
/* 1359 */     if (strFieldName.equals("startDate")) {
/* 1360 */       return 1;
/*      */     }
/* 1362 */     if (strFieldName.equals("endDate")) {
/* 1363 */       return 1;
/*      */     }
/* 1365 */     if (strFieldName.equals("checkState")) {
/* 1366 */       return 0;
/*      */     }
/* 1368 */     if (strFieldName.equals("inputState")) {
/* 1369 */       return 0;
/*      */     }
/* 1371 */     if (strFieldName.equals("checkOperator")) {
/* 1372 */       return 0;
/*      */     }
/* 1374 */     if (strFieldName.equals("checkReason")) {
/* 1375 */       return 0;
/*      */     }
/* 1377 */     if (strFieldName.equals("checkDate")) {
/* 1378 */       return 1;
/*      */     }
/* 1380 */     if (strFieldName.equals("checkTime")) {
/* 1381 */       return 0;
/*      */     }
/* 1383 */     if (strFieldName.equals("edorNo")) {
/* 1384 */       return 0;
/*      */     }
/* 1386 */     if (strFieldName.equals("edorType")) {
/* 1387 */       return 0;
/*      */     }
/* 1389 */     if (strFieldName.equals("edorCase")) {
/* 1390 */       return 0;
/*      */     }
/* 1392 */     if (strFieldName.equals("operator2")) {
/* 1393 */       return 0;
/*      */     }
/* 1395 */     if (strFieldName.equals("makeDate2")) {
/* 1396 */       return 1;
/*      */     }
/* 1398 */     if (strFieldName.equals("makeTime2")) {
/* 1399 */       return 0;
/*      */     }
/* 1401 */     if (strFieldName.equals("modifyOperator")) {
/* 1402 */       return 0;
/*      */     }
/* 1404 */     if (strFieldName.equals("operator")) {
/* 1405 */       return 0;
/*      */     }
/* 1407 */     if (strFieldName.equals("makeDate")) {
/* 1408 */       return 1;
/*      */     }
/* 1410 */     if (strFieldName.equals("makeTime")) {
/* 1411 */       return 0;
/*      */     }
/* 1413 */     if (strFieldName.equals("modifyDate")) {
/* 1414 */       return 1;
/*      */     }
/* 1416 */     if (strFieldName.equals("modifyTime")) {
/* 1417 */       return 0;
/*      */     }
/* 1419 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1425 */     int nFieldType = -1;
/* 1426 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1428 */       nFieldType = 0;
/* 1429 */       break;
/*      */     case 1:
/* 1431 */       nFieldType = 0;
/* 1432 */       break;
/*      */     case 2:
/* 1434 */       nFieldType = 0;
/* 1435 */       break;
/*      */     case 3:
/* 1437 */       nFieldType = 0;
/* 1438 */       break;
/*      */     case 4:
/* 1440 */       nFieldType = 0;
/* 1441 */       break;
/*      */     case 5:
/* 1443 */       nFieldType = 0;
/* 1444 */       break;
/*      */     case 6:
/* 1446 */       nFieldType = 1;
/* 1447 */       break;
/*      */     case 7:
/* 1449 */       nFieldType = 1;
/* 1450 */       break;
/*      */     case 8:
/* 1452 */       nFieldType = 0;
/* 1453 */       break;
/*      */     case 9:
/* 1455 */       nFieldType = 0;
/* 1456 */       break;
/*      */     case 10:
/* 1458 */       nFieldType = 0;
/* 1459 */       break;
/*      */     case 11:
/* 1461 */       nFieldType = 0;
/* 1462 */       break;
/*      */     case 12:
/* 1464 */       nFieldType = 1;
/* 1465 */       break;
/*      */     case 13:
/* 1467 */       nFieldType = 0;
/* 1468 */       break;
/*      */     case 14:
/* 1470 */       nFieldType = 0;
/* 1471 */       break;
/*      */     case 15:
/* 1473 */       nFieldType = 0;
/* 1474 */       break;
/*      */     case 16:
/* 1476 */       nFieldType = 0;
/* 1477 */       break;
/*      */     case 17:
/* 1479 */       nFieldType = 0;
/* 1480 */       break;
/*      */     case 18:
/* 1482 */       nFieldType = 1;
/* 1483 */       break;
/*      */     case 19:
/* 1485 */       nFieldType = 0;
/* 1486 */       break;
/*      */     case 20:
/* 1488 */       nFieldType = 0;
/* 1489 */       break;
/*      */     case 21:
/* 1491 */       nFieldType = 0;
/* 1492 */       break;
/*      */     case 22:
/* 1494 */       nFieldType = 1;
/* 1495 */       break;
/*      */     case 23:
/* 1497 */       nFieldType = 0;
/* 1498 */       break;
/*      */     case 24:
/* 1500 */       nFieldType = 1;
/* 1501 */       break;
/*      */     case 25:
/* 1503 */       nFieldType = 0;
/* 1504 */       break;
/*      */     default:
/* 1506 */       nFieldType = -1;
/*      */     }
/* 1508 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MHonorCheckBSchema
 * JD-Core Version:    0.6.0
 */