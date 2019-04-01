/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPCUWMasterDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPCUWMasterSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private int uWNo;
/*      */   private String manageCom;
/*      */   private Date uWDate;
/*      */   private String uWTime;
/*      */   private String uWerName;
/*      */   private String checkStatus;
/*      */   private String appIsCompleted;
/*      */   private String appIsSubmitted;
/*      */   private String appDecision;
/*      */   private String autoUWFlag;
/*      */   private String uWMessages;
/*      */   private String uWGrade;
/*      */   private String appGrade;
/*      */   private String state;
/*      */   private String upReportContent;
/*      */   private String healthFlag;
/*      */   private String quesFlag;
/*      */   private String specFlag;
/*      */   private String addPremFlag;
/*      */   private String addPremReason;
/*      */   private String specReason;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 29;
/*      */   private static String[] PK;
/*   85 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPCUWMasterSchema()
/*      */   {
/*   92 */     this.mErrors = new CErrors();
/*      */ 
/*   94 */     String[] pk = new String[1];
/*   95 */     pk[0] = "ContNo";
/*      */ 
/*   97 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  104 */     LNPCUWMasterSchema cloned = (LNPCUWMasterSchema)super.clone();
/*  105 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  106 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  107 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  113 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo()
/*      */   {
/*  118 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  122 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  126 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  130 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  134 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  138 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public int getUWNo() {
/*  142 */     return this.uWNo;
/*      */   }
/*      */ 
/*      */   public void setUWNo(int aUWNo) {
/*  146 */     this.uWNo = aUWNo;
/*      */   }
/*      */ 
/*      */   public void setUWNo(String aUWNo) {
/*  150 */     if ((aUWNo != null) && (!aUWNo.equals("")))
/*      */     {
/*  152 */       Integer tInteger = new Integer(aUWNo);
/*  153 */       int i = tInteger.intValue();
/*  154 */       this.uWNo = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getManageCom()
/*      */   {
/*  160 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  164 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getUWDate() {
/*  168 */     if (this.uWDate != null) {
/*  169 */       return this.fDate.getString(this.uWDate);
/*      */     }
/*  171 */     return null;
/*      */   }
/*      */ 
/*      */   public void setUWDate(Date aUWDate) {
/*  175 */     this.uWDate = aUWDate;
/*      */   }
/*      */ 
/*      */   public void setUWDate(String aUWDate) {
/*  179 */     if ((aUWDate != null) && (!aUWDate.equals("")))
/*      */     {
/*  181 */       this.uWDate = this.fDate.getDate(aUWDate);
/*      */     }
/*      */     else
/*  184 */       this.uWDate = null;
/*      */   }
/*      */ 
/*      */   public String getUWTime()
/*      */   {
/*  189 */     return this.uWTime;
/*      */   }
/*      */ 
/*      */   public void setUWTime(String aUWTime) {
/*  193 */     this.uWTime = aUWTime;
/*      */   }
/*      */ 
/*      */   public String getUWerName() {
/*  197 */     return this.uWerName;
/*      */   }
/*      */ 
/*      */   public void setUWerName(String aUWerName) {
/*  201 */     this.uWerName = aUWerName;
/*      */   }
/*      */ 
/*      */   public String getCheckStatus() {
/*  205 */     return this.checkStatus;
/*      */   }
/*      */ 
/*      */   public void setCheckStatus(String aCheckStatus) {
/*  209 */     this.checkStatus = aCheckStatus;
/*      */   }
/*      */ 
/*      */   public String getAppIsCompleted() {
/*  213 */     return this.appIsCompleted;
/*      */   }
/*      */ 
/*      */   public void setAppIsCompleted(String aAppIsCompleted) {
/*  217 */     this.appIsCompleted = aAppIsCompleted;
/*      */   }
/*      */ 
/*      */   public String getAppIsSubmitted() {
/*  221 */     return this.appIsSubmitted;
/*      */   }
/*      */ 
/*      */   public void setAppIsSubmitted(String aAppIsSubmitted) {
/*  225 */     this.appIsSubmitted = aAppIsSubmitted;
/*      */   }
/*      */ 
/*      */   public String getAppDecision() {
/*  229 */     return this.appDecision;
/*      */   }
/*      */ 
/*      */   public void setAppDecision(String aAppDecision) {
/*  233 */     this.appDecision = aAppDecision;
/*      */   }
/*      */ 
/*      */   public String getAutoUWFlag() {
/*  237 */     return this.autoUWFlag;
/*      */   }
/*      */ 
/*      */   public void setAutoUWFlag(String aAutoUWFlag) {
/*  241 */     this.autoUWFlag = aAutoUWFlag;
/*      */   }
/*      */ 
/*      */   public String getUWMessages() {
/*  245 */     return this.uWMessages;
/*      */   }
/*      */ 
/*      */   public void setUWMessages(String aUWMessages) {
/*  249 */     this.uWMessages = aUWMessages;
/*      */   }
/*      */ 
/*      */   public String getUWGrade() {
/*  253 */     return this.uWGrade;
/*      */   }
/*      */ 
/*      */   public void setUWGrade(String aUWGrade) {
/*  257 */     this.uWGrade = aUWGrade;
/*      */   }
/*      */ 
/*      */   public String getAppGrade() {
/*  261 */     return this.appGrade;
/*      */   }
/*      */ 
/*      */   public void setAppGrade(String aAppGrade) {
/*  265 */     this.appGrade = aAppGrade;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  269 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  273 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getUpReportContent() {
/*  277 */     return this.upReportContent;
/*      */   }
/*      */ 
/*      */   public void setUpReportContent(String aUpReportContent) {
/*  281 */     this.upReportContent = aUpReportContent;
/*      */   }
/*      */ 
/*      */   public String getHealthFlag() {
/*  285 */     return this.healthFlag;
/*      */   }
/*      */ 
/*      */   public void setHealthFlag(String aHealthFlag) {
/*  289 */     this.healthFlag = aHealthFlag;
/*      */   }
/*      */ 
/*      */   public String getQuesFlag() {
/*  293 */     return this.quesFlag;
/*      */   }
/*      */ 
/*      */   public void setQuesFlag(String aQuesFlag) {
/*  297 */     this.quesFlag = aQuesFlag;
/*      */   }
/*      */ 
/*      */   public String getSpecFlag() {
/*  301 */     return this.specFlag;
/*      */   }
/*      */ 
/*      */   public void setSpecFlag(String aSpecFlag) {
/*  305 */     this.specFlag = aSpecFlag;
/*      */   }
/*      */ 
/*      */   public String getAddPremFlag() {
/*  309 */     return this.addPremFlag;
/*      */   }
/*      */ 
/*      */   public void setAddPremFlag(String aAddPremFlag) {
/*  313 */     this.addPremFlag = aAddPremFlag;
/*      */   }
/*      */ 
/*      */   public String getAddPremReason() {
/*  317 */     return this.addPremReason;
/*      */   }
/*      */ 
/*      */   public void setAddPremReason(String aAddPremReason) {
/*  321 */     this.addPremReason = aAddPremReason;
/*      */   }
/*      */ 
/*      */   public String getSpecReason() {
/*  325 */     return this.specReason;
/*      */   }
/*      */ 
/*      */   public void setSpecReason(String aSpecReason) {
/*  329 */     this.specReason = aSpecReason;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  333 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  337 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  341 */     if (this.makeDate != null) {
/*  342 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  344 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  348 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  352 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  354 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  357 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  362 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  366 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  370 */     if (this.modifyDate != null) {
/*  371 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  373 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  377 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  381 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  383 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  386 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  391 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  395 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPCUWMasterSchema aLNPCUWMasterSchema)
/*      */   {
/*  401 */     this.grpContNo = aLNPCUWMasterSchema.getGrpContNo();
/*  402 */     this.contNo = aLNPCUWMasterSchema.getContNo();
/*  403 */     this.proposalContNo = aLNPCUWMasterSchema.getProposalContNo();
/*  404 */     this.uWNo = aLNPCUWMasterSchema.getUWNo();
/*  405 */     this.manageCom = aLNPCUWMasterSchema.getManageCom();
/*  406 */     this.uWDate = this.fDate.getDate(aLNPCUWMasterSchema.getUWDate());
/*  407 */     this.uWTime = aLNPCUWMasterSchema.getUWTime();
/*  408 */     this.uWerName = aLNPCUWMasterSchema.getUWerName();
/*  409 */     this.checkStatus = aLNPCUWMasterSchema.getCheckStatus();
/*  410 */     this.appIsCompleted = aLNPCUWMasterSchema.getAppIsCompleted();
/*  411 */     this.appIsSubmitted = aLNPCUWMasterSchema.getAppIsSubmitted();
/*  412 */     this.appDecision = aLNPCUWMasterSchema.getAppDecision();
/*  413 */     this.autoUWFlag = aLNPCUWMasterSchema.getAutoUWFlag();
/*  414 */     this.uWMessages = aLNPCUWMasterSchema.getUWMessages();
/*  415 */     this.uWGrade = aLNPCUWMasterSchema.getUWGrade();
/*  416 */     this.appGrade = aLNPCUWMasterSchema.getAppGrade();
/*  417 */     this.state = aLNPCUWMasterSchema.getState();
/*  418 */     this.upReportContent = aLNPCUWMasterSchema.getUpReportContent();
/*  419 */     this.healthFlag = aLNPCUWMasterSchema.getHealthFlag();
/*  420 */     this.quesFlag = aLNPCUWMasterSchema.getQuesFlag();
/*  421 */     this.specFlag = aLNPCUWMasterSchema.getSpecFlag();
/*  422 */     this.addPremFlag = aLNPCUWMasterSchema.getAddPremFlag();
/*  423 */     this.addPremReason = aLNPCUWMasterSchema.getAddPremReason();
/*  424 */     this.specReason = aLNPCUWMasterSchema.getSpecReason();
/*  425 */     this.operator = aLNPCUWMasterSchema.getOperator();
/*  426 */     this.makeDate = this.fDate.getDate(aLNPCUWMasterSchema.getMakeDate());
/*  427 */     this.makeTime = aLNPCUWMasterSchema.getMakeTime();
/*  428 */     this.modifyDate = this.fDate.getDate(aLNPCUWMasterSchema.getModifyDate());
/*  429 */     this.modifyTime = aLNPCUWMasterSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  438 */       if (rs.getString("GrpContNo") == null)
/*  439 */         this.grpContNo = null;
/*      */       else {
/*  441 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  443 */       if (rs.getString("ContNo") == null)
/*  444 */         this.contNo = null;
/*      */       else {
/*  446 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  448 */       if (rs.getString("ProposalContNo") == null)
/*  449 */         this.proposalContNo = null;
/*      */       else {
/*  451 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  453 */       this.uWNo = rs.getInt("UWNo");
/*  454 */       if (rs.getString("ManageCom") == null)
/*  455 */         this.manageCom = null;
/*      */       else {
/*  457 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  459 */       this.uWDate = rs.getDate("UWDate");
/*  460 */       if (rs.getString("UWTime") == null)
/*  461 */         this.uWTime = null;
/*      */       else {
/*  463 */         this.uWTime = rs.getString("UWTime").trim();
/*      */       }
/*  465 */       if (rs.getString("UWerName") == null)
/*  466 */         this.uWerName = null;
/*      */       else {
/*  468 */         this.uWerName = rs.getString("UWerName").trim();
/*      */       }
/*  470 */       if (rs.getString("CheckStatus") == null)
/*  471 */         this.checkStatus = null;
/*      */       else {
/*  473 */         this.checkStatus = rs.getString("CheckStatus").trim();
/*      */       }
/*  475 */       if (rs.getString("AppIsCompleted") == null)
/*  476 */         this.appIsCompleted = null;
/*      */       else {
/*  478 */         this.appIsCompleted = rs.getString("AppIsCompleted").trim();
/*      */       }
/*  480 */       if (rs.getString("AppIsSubmitted") == null)
/*  481 */         this.appIsSubmitted = null;
/*      */       else {
/*  483 */         this.appIsSubmitted = rs.getString("AppIsSubmitted").trim();
/*      */       }
/*  485 */       if (rs.getString("AppDecision") == null)
/*  486 */         this.appDecision = null;
/*      */       else {
/*  488 */         this.appDecision = rs.getString("AppDecision").trim();
/*      */       }
/*  490 */       if (rs.getString("AutoUWFlag") == null)
/*  491 */         this.autoUWFlag = null;
/*      */       else {
/*  493 */         this.autoUWFlag = rs.getString("AutoUWFlag").trim();
/*      */       }
/*  495 */       if (rs.getString("UWMessages") == null)
/*  496 */         this.uWMessages = null;
/*      */       else {
/*  498 */         this.uWMessages = rs.getString("UWMessages").trim();
/*      */       }
/*  500 */       if (rs.getString("UWGrade") == null)
/*  501 */         this.uWGrade = null;
/*      */       else {
/*  503 */         this.uWGrade = rs.getString("UWGrade").trim();
/*      */       }
/*  505 */       if (rs.getString("AppGrade") == null)
/*  506 */         this.appGrade = null;
/*      */       else {
/*  508 */         this.appGrade = rs.getString("AppGrade").trim();
/*      */       }
/*  510 */       if (rs.getString("State") == null)
/*  511 */         this.state = null;
/*      */       else {
/*  513 */         this.state = rs.getString("State").trim();
/*      */       }
/*  515 */       if (rs.getString("UpReportContent") == null)
/*  516 */         this.upReportContent = null;
/*      */       else {
/*  518 */         this.upReportContent = rs.getString("UpReportContent").trim();
/*      */       }
/*  520 */       if (rs.getString("HealthFlag") == null)
/*  521 */         this.healthFlag = null;
/*      */       else {
/*  523 */         this.healthFlag = rs.getString("HealthFlag").trim();
/*      */       }
/*  525 */       if (rs.getString("QuesFlag") == null)
/*  526 */         this.quesFlag = null;
/*      */       else {
/*  528 */         this.quesFlag = rs.getString("QuesFlag").trim();
/*      */       }
/*  530 */       if (rs.getString("SpecFlag") == null)
/*  531 */         this.specFlag = null;
/*      */       else {
/*  533 */         this.specFlag = rs.getString("SpecFlag").trim();
/*      */       }
/*  535 */       if (rs.getString("AddPremFlag") == null)
/*  536 */         this.addPremFlag = null;
/*      */       else {
/*  538 */         this.addPremFlag = rs.getString("AddPremFlag").trim();
/*      */       }
/*  540 */       if (rs.getString("AddPremReason") == null)
/*  541 */         this.addPremReason = null;
/*      */       else {
/*  543 */         this.addPremReason = rs.getString("AddPremReason").trim();
/*      */       }
/*  545 */       if (rs.getString("SpecReason") == null)
/*  546 */         this.specReason = null;
/*      */       else {
/*  548 */         this.specReason = rs.getString("SpecReason").trim();
/*      */       }
/*  550 */       if (rs.getString("Operator") == null)
/*  551 */         this.operator = null;
/*      */       else {
/*  553 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  555 */       this.makeDate = rs.getDate("MakeDate");
/*  556 */       if (rs.getString("MakeTime") == null)
/*  557 */         this.makeTime = null;
/*      */       else {
/*  559 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  561 */       this.modifyDate = rs.getDate("ModifyDate");
/*  562 */       if (rs.getString("ModifyTime") == null)
/*  563 */         this.modifyTime = null;
/*      */       else {
/*  565 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  570 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPCUWMaster\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/*  572 */       CError tError = new CError();
/*  573 */       tError.moduleName = "LNPCUWMasterSchema";
/*  574 */       tError.functionName = "setSchema";
/*  575 */       tError.errorMessage = sqle.toString();
/*  576 */       this.mErrors.addOneError(tError);
/*  577 */       return false;
/*      */     }
/*  579 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPCUWMasterSchema getSchema()
/*      */   {
/*  584 */     LNPCUWMasterSchema aLNPCUWMasterSchema = new LNPCUWMasterSchema();
/*  585 */     aLNPCUWMasterSchema.setSchema(this);
/*  586 */     return aLNPCUWMasterSchema;
/*      */   }
/*      */ 
/*      */   public LNPCUWMasterDB getDB()
/*      */   {
/*  591 */     LNPCUWMasterDB aDBOper = new LNPCUWMasterDB();
/*  592 */     aDBOper.setSchema(this);
/*  593 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  600 */     StringBuffer strReturn = new StringBuffer(256);
/*  601 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/*  602 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/*  603 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/*  604 */     strReturn.append(ChgData.chgData(this.uWNo)); strReturn.append("|");
/*  605 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  606 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.uWDate))); strReturn.append("|");
/*  607 */     strReturn.append(StrTool.cTrim(this.uWTime)); strReturn.append("|");
/*  608 */     strReturn.append(StrTool.cTrim(this.uWerName)); strReturn.append("|");
/*  609 */     strReturn.append(StrTool.cTrim(this.checkStatus)); strReturn.append("|");
/*  610 */     strReturn.append(StrTool.cTrim(this.appIsCompleted)); strReturn.append("|");
/*  611 */     strReturn.append(StrTool.cTrim(this.appIsSubmitted)); strReturn.append("|");
/*  612 */     strReturn.append(StrTool.cTrim(this.appDecision)); strReturn.append("|");
/*  613 */     strReturn.append(StrTool.cTrim(this.autoUWFlag)); strReturn.append("|");
/*  614 */     strReturn.append(StrTool.cTrim(this.uWMessages)); strReturn.append("|");
/*  615 */     strReturn.append(StrTool.cTrim(this.uWGrade)); strReturn.append("|");
/*  616 */     strReturn.append(StrTool.cTrim(this.appGrade)); strReturn.append("|");
/*  617 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  618 */     strReturn.append(StrTool.cTrim(this.upReportContent)); strReturn.append("|");
/*  619 */     strReturn.append(StrTool.cTrim(this.healthFlag)); strReturn.append("|");
/*  620 */     strReturn.append(StrTool.cTrim(this.quesFlag)); strReturn.append("|");
/*  621 */     strReturn.append(StrTool.cTrim(this.specFlag)); strReturn.append("|");
/*  622 */     strReturn.append(StrTool.cTrim(this.addPremFlag)); strReturn.append("|");
/*  623 */     strReturn.append(StrTool.cTrim(this.addPremReason)); strReturn.append("|");
/*  624 */     strReturn.append(StrTool.cTrim(this.specReason)); strReturn.append("|");
/*  625 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  626 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  627 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  628 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  629 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  630 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  638 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  639 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  640 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  641 */       this.uWNo = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|"))).intValue();
/*  642 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  643 */       this.uWDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/*  644 */       this.uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  645 */       this.uWerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  646 */       this.checkStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  647 */       this.appIsCompleted = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  648 */       this.appIsSubmitted = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  649 */       this.appDecision = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  650 */       this.autoUWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  651 */       this.uWMessages = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  652 */       this.uWGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  653 */       this.appGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  654 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  655 */       this.upReportContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  656 */       this.healthFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  657 */       this.quesFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  658 */       this.specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  659 */       this.addPremFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  660 */       this.addPremReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  661 */       this.specReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  662 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  663 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|"));
/*  664 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  665 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
/*  666 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  671 */       CError tError = new CError();
/*  672 */       tError.moduleName = "LNPCUWMasterSchema";
/*  673 */       tError.functionName = "decode";
/*  674 */       tError.errorMessage = ex.toString();
/*  675 */       this.mErrors.addOneError(tError);
/*      */ 
/*  677 */       return false;
/*      */     }
/*  679 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  685 */     String strReturn = "";
/*  686 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  688 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  690 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  692 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  694 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  696 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  698 */     if (FCode.equalsIgnoreCase("uWNo"))
/*      */     {
/*  700 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWNo));
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  704 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  706 */     if (FCode.equalsIgnoreCase("uWDate"))
/*      */     {
/*  708 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("uWTime"))
/*      */     {
/*  712 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWTime));
/*      */     }
/*  714 */     if (FCode.equalsIgnoreCase("uWerName"))
/*      */     {
/*  716 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWerName));
/*      */     }
/*  718 */     if (FCode.equalsIgnoreCase("checkStatus"))
/*      */     {
/*  720 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkStatus));
/*      */     }
/*  722 */     if (FCode.equalsIgnoreCase("appIsCompleted"))
/*      */     {
/*  724 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appIsCompleted));
/*      */     }
/*  726 */     if (FCode.equalsIgnoreCase("appIsSubmitted"))
/*      */     {
/*  728 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appIsSubmitted));
/*      */     }
/*  730 */     if (FCode.equalsIgnoreCase("appDecision"))
/*      */     {
/*  732 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appDecision));
/*      */     }
/*  734 */     if (FCode.equalsIgnoreCase("autoUWFlag"))
/*      */     {
/*  736 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.autoUWFlag));
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("uWMessages"))
/*      */     {
/*  740 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWMessages));
/*      */     }
/*  742 */     if (FCode.equalsIgnoreCase("uWGrade"))
/*      */     {
/*  744 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWGrade));
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("appGrade"))
/*      */     {
/*  748 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appGrade));
/*      */     }
/*  750 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  752 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  754 */     if (FCode.equalsIgnoreCase("upReportContent"))
/*      */     {
/*  756 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.upReportContent));
/*      */     }
/*  758 */     if (FCode.equalsIgnoreCase("healthFlag"))
/*      */     {
/*  760 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.healthFlag));
/*      */     }
/*  762 */     if (FCode.equalsIgnoreCase("quesFlag"))
/*      */     {
/*  764 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.quesFlag));
/*      */     }
/*  766 */     if (FCode.equalsIgnoreCase("specFlag"))
/*      */     {
/*  768 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specFlag));
/*      */     }
/*  770 */     if (FCode.equalsIgnoreCase("addPremFlag"))
/*      */     {
/*  772 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addPremFlag));
/*      */     }
/*  774 */     if (FCode.equalsIgnoreCase("addPremReason"))
/*      */     {
/*  776 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addPremReason));
/*      */     }
/*  778 */     if (FCode.equalsIgnoreCase("specReason"))
/*      */     {
/*  780 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specReason));
/*      */     }
/*  782 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  784 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  786 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  788 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  790 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  792 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  794 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  796 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  798 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  800 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  802 */     if (strReturn.equals(""))
/*      */     {
/*  804 */       strReturn = "null";
/*      */     }
/*      */ 
/*  807 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  814 */     String strFieldValue = "";
/*  815 */     switch (nFieldIndex) {
/*      */     case 0:
/*  817 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  818 */       break;
/*      */     case 1:
/*  820 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  821 */       break;
/*      */     case 2:
/*  823 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  824 */       break;
/*      */     case 3:
/*  826 */       strFieldValue = String.valueOf(this.uWNo);
/*  827 */       break;
/*      */     case 4:
/*  829 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  830 */       break;
/*      */     case 5:
/*  832 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
/*  833 */       break;
/*      */     case 6:
/*  835 */       strFieldValue = StrTool.GBKToUnicode(this.uWTime);
/*  836 */       break;
/*      */     case 7:
/*  838 */       strFieldValue = StrTool.GBKToUnicode(this.uWerName);
/*  839 */       break;
/*      */     case 8:
/*  841 */       strFieldValue = StrTool.GBKToUnicode(this.checkStatus);
/*  842 */       break;
/*      */     case 9:
/*  844 */       strFieldValue = StrTool.GBKToUnicode(this.appIsCompleted);
/*  845 */       break;
/*      */     case 10:
/*  847 */       strFieldValue = StrTool.GBKToUnicode(this.appIsSubmitted);
/*  848 */       break;
/*      */     case 11:
/*  850 */       strFieldValue = StrTool.GBKToUnicode(this.appDecision);
/*  851 */       break;
/*      */     case 12:
/*  853 */       strFieldValue = StrTool.GBKToUnicode(this.autoUWFlag);
/*  854 */       break;
/*      */     case 13:
/*  856 */       strFieldValue = StrTool.GBKToUnicode(this.uWMessages);
/*  857 */       break;
/*      */     case 14:
/*  859 */       strFieldValue = StrTool.GBKToUnicode(this.uWGrade);
/*  860 */       break;
/*      */     case 15:
/*  862 */       strFieldValue = StrTool.GBKToUnicode(this.appGrade);
/*  863 */       break;
/*      */     case 16:
/*  865 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  866 */       break;
/*      */     case 17:
/*  868 */       strFieldValue = StrTool.GBKToUnicode(this.upReportContent);
/*  869 */       break;
/*      */     case 18:
/*  871 */       strFieldValue = StrTool.GBKToUnicode(this.healthFlag);
/*  872 */       break;
/*      */     case 19:
/*  874 */       strFieldValue = StrTool.GBKToUnicode(this.quesFlag);
/*  875 */       break;
/*      */     case 20:
/*  877 */       strFieldValue = StrTool.GBKToUnicode(this.specFlag);
/*  878 */       break;
/*      */     case 21:
/*  880 */       strFieldValue = StrTool.GBKToUnicode(this.addPremFlag);
/*  881 */       break;
/*      */     case 22:
/*  883 */       strFieldValue = StrTool.GBKToUnicode(this.addPremReason);
/*  884 */       break;
/*      */     case 23:
/*  886 */       strFieldValue = StrTool.GBKToUnicode(this.specReason);
/*  887 */       break;
/*      */     case 24:
/*  889 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  890 */       break;
/*      */     case 25:
/*  892 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  893 */       break;
/*      */     case 26:
/*  895 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  896 */       break;
/*      */     case 27:
/*  898 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  899 */       break;
/*      */     case 28:
/*  901 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  902 */       break;
/*      */     default:
/*  904 */       strFieldValue = "";
/*      */     }
/*  906 */     if (strFieldValue.equals("")) {
/*  907 */       strFieldValue = "null";
/*      */     }
/*  909 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  915 */     if (StrTool.cTrim(FCode).equals("")) {
/*  916 */       return false;
/*      */     }
/*  918 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  920 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  922 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/*  925 */         this.grpContNo = null;
/*      */     }
/*  927 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  929 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  931 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/*  934 */         this.contNo = null;
/*      */     }
/*  936 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  938 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  940 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/*  943 */         this.proposalContNo = null;
/*      */     }
/*  945 */     if (FCode.equalsIgnoreCase("uWNo"))
/*      */     {
/*  947 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  949 */         Integer tInteger = new Integer(FValue);
/*  950 */         int i = tInteger.intValue();
/*  951 */         this.uWNo = i;
/*      */       }
/*      */     }
/*  954 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  956 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  958 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  961 */         this.manageCom = null;
/*      */     }
/*  963 */     if (FCode.equalsIgnoreCase("uWDate"))
/*      */     {
/*  965 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  967 */         this.uWDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  970 */         this.uWDate = null;
/*      */     }
/*  972 */     if (FCode.equalsIgnoreCase("uWTime"))
/*      */     {
/*  974 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  976 */         this.uWTime = FValue.trim();
/*      */       }
/*      */       else
/*  979 */         this.uWTime = null;
/*      */     }
/*  981 */     if (FCode.equalsIgnoreCase("uWerName"))
/*      */     {
/*  983 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  985 */         this.uWerName = FValue.trim();
/*      */       }
/*      */       else
/*  988 */         this.uWerName = null;
/*      */     }
/*  990 */     if (FCode.equalsIgnoreCase("checkStatus"))
/*      */     {
/*  992 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  994 */         this.checkStatus = FValue.trim();
/*      */       }
/*      */       else
/*  997 */         this.checkStatus = null;
/*      */     }
/*  999 */     if (FCode.equalsIgnoreCase("appIsCompleted"))
/*      */     {
/* 1001 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1003 */         this.appIsCompleted = FValue.trim();
/*      */       }
/*      */       else
/* 1006 */         this.appIsCompleted = null;
/*      */     }
/* 1008 */     if (FCode.equalsIgnoreCase("appIsSubmitted"))
/*      */     {
/* 1010 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1012 */         this.appIsSubmitted = FValue.trim();
/*      */       }
/*      */       else
/* 1015 */         this.appIsSubmitted = null;
/*      */     }
/* 1017 */     if (FCode.equalsIgnoreCase("appDecision"))
/*      */     {
/* 1019 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1021 */         this.appDecision = FValue.trim();
/*      */       }
/*      */       else
/* 1024 */         this.appDecision = null;
/*      */     }
/* 1026 */     if (FCode.equalsIgnoreCase("autoUWFlag"))
/*      */     {
/* 1028 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1030 */         this.autoUWFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1033 */         this.autoUWFlag = null;
/*      */     }
/* 1035 */     if (FCode.equalsIgnoreCase("uWMessages"))
/*      */     {
/* 1037 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1039 */         this.uWMessages = FValue.trim();
/*      */       }
/*      */       else
/* 1042 */         this.uWMessages = null;
/*      */     }
/* 1044 */     if (FCode.equalsIgnoreCase("uWGrade"))
/*      */     {
/* 1046 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1048 */         this.uWGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1051 */         this.uWGrade = null;
/*      */     }
/* 1053 */     if (FCode.equalsIgnoreCase("appGrade"))
/*      */     {
/* 1055 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1057 */         this.appGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1060 */         this.appGrade = null;
/*      */     }
/* 1062 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1064 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1066 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 1069 */         this.state = null;
/*      */     }
/* 1071 */     if (FCode.equalsIgnoreCase("upReportContent"))
/*      */     {
/* 1073 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1075 */         this.upReportContent = FValue.trim();
/*      */       }
/*      */       else
/* 1078 */         this.upReportContent = null;
/*      */     }
/* 1080 */     if (FCode.equalsIgnoreCase("healthFlag"))
/*      */     {
/* 1082 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1084 */         this.healthFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1087 */         this.healthFlag = null;
/*      */     }
/* 1089 */     if (FCode.equalsIgnoreCase("quesFlag"))
/*      */     {
/* 1091 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1093 */         this.quesFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1096 */         this.quesFlag = null;
/*      */     }
/* 1098 */     if (FCode.equalsIgnoreCase("specFlag"))
/*      */     {
/* 1100 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1102 */         this.specFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1105 */         this.specFlag = null;
/*      */     }
/* 1107 */     if (FCode.equalsIgnoreCase("addPremFlag"))
/*      */     {
/* 1109 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1111 */         this.addPremFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1114 */         this.addPremFlag = null;
/*      */     }
/* 1116 */     if (FCode.equalsIgnoreCase("addPremReason"))
/*      */     {
/* 1118 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1120 */         this.addPremReason = FValue.trim();
/*      */       }
/*      */       else
/* 1123 */         this.addPremReason = null;
/*      */     }
/* 1125 */     if (FCode.equalsIgnoreCase("specReason"))
/*      */     {
/* 1127 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1129 */         this.specReason = FValue.trim();
/*      */       }
/*      */       else
/* 1132 */         this.specReason = null;
/*      */     }
/* 1134 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1136 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1138 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1141 */         this.operator = null;
/*      */     }
/* 1143 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1145 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1147 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1150 */         this.makeDate = null;
/*      */     }
/* 1152 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1154 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1156 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1159 */         this.makeTime = null;
/*      */     }
/* 1161 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1163 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1165 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1168 */         this.modifyDate = null;
/*      */     }
/* 1170 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1172 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1174 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1177 */         this.modifyTime = null;
/*      */     }
/* 1179 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1184 */     if (otherObject == null) return false;
/* 1185 */     if (this == otherObject) return true;
/* 1186 */     if (getClass() != otherObject.getClass()) return false;
/* 1187 */     LNPCUWMasterSchema other = (LNPCUWMasterSchema)otherObject;
/* 1188 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/* 1189 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/* 1190 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/* 1191 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/* 1192 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/* 1193 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/* 1194 */     if (this.uWNo != other.getUWNo()) return false;
/* 1195 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1196 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1197 */     if ((this.uWDate == null) && (other.getUWDate() != null)) return false;
/* 1198 */     if ((this.uWDate != null) && (!this.fDate.getString(this.uWDate).equals(other.getUWDate()))) return false;
/* 1199 */     if ((this.uWTime == null) && (other.getUWTime() != null)) return false;
/* 1200 */     if ((this.uWTime != null) && (!this.uWTime.equals(other.getUWTime()))) return false;
/* 1201 */     if ((this.uWerName == null) && (other.getUWerName() != null)) return false;
/* 1202 */     if ((this.uWerName != null) && (!this.uWerName.equals(other.getUWerName()))) return false;
/* 1203 */     if ((this.checkStatus == null) && (other.getCheckStatus() != null)) return false;
/* 1204 */     if ((this.checkStatus != null) && (!this.checkStatus.equals(other.getCheckStatus()))) return false;
/* 1205 */     if ((this.appIsCompleted == null) && (other.getAppIsCompleted() != null)) return false;
/* 1206 */     if ((this.appIsCompleted != null) && (!this.appIsCompleted.equals(other.getAppIsCompleted()))) return false;
/* 1207 */     if ((this.appIsSubmitted == null) && (other.getAppIsSubmitted() != null)) return false;
/* 1208 */     if ((this.appIsSubmitted != null) && (!this.appIsSubmitted.equals(other.getAppIsSubmitted()))) return false;
/* 1209 */     if ((this.appDecision == null) && (other.getAppDecision() != null)) return false;
/* 1210 */     if ((this.appDecision != null) && (!this.appDecision.equals(other.getAppDecision()))) return false;
/* 1211 */     if ((this.autoUWFlag == null) && (other.getAutoUWFlag() != null)) return false;
/* 1212 */     if ((this.autoUWFlag != null) && (!this.autoUWFlag.equals(other.getAutoUWFlag()))) return false;
/* 1213 */     if ((this.uWMessages == null) && (other.getUWMessages() != null)) return false;
/* 1214 */     if ((this.uWMessages != null) && (!this.uWMessages.equals(other.getUWMessages()))) return false;
/* 1215 */     if ((this.uWGrade == null) && (other.getUWGrade() != null)) return false;
/* 1216 */     if ((this.uWGrade != null) && (!this.uWGrade.equals(other.getUWGrade()))) return false;
/* 1217 */     if ((this.appGrade == null) && (other.getAppGrade() != null)) return false;
/* 1218 */     if ((this.appGrade != null) && (!this.appGrade.equals(other.getAppGrade()))) return false;
/* 1219 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1220 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1221 */     if ((this.upReportContent == null) && (other.getUpReportContent() != null)) return false;
/* 1222 */     if ((this.upReportContent != null) && (!this.upReportContent.equals(other.getUpReportContent()))) return false;
/* 1223 */     if ((this.healthFlag == null) && (other.getHealthFlag() != null)) return false;
/* 1224 */     if ((this.healthFlag != null) && (!this.healthFlag.equals(other.getHealthFlag()))) return false;
/* 1225 */     if ((this.quesFlag == null) && (other.getQuesFlag() != null)) return false;
/* 1226 */     if ((this.quesFlag != null) && (!this.quesFlag.equals(other.getQuesFlag()))) return false;
/* 1227 */     if ((this.specFlag == null) && (other.getSpecFlag() != null)) return false;
/* 1228 */     if ((this.specFlag != null) && (!this.specFlag.equals(other.getSpecFlag()))) return false;
/* 1229 */     if ((this.addPremFlag == null) && (other.getAddPremFlag() != null)) return false;
/* 1230 */     if ((this.addPremFlag != null) && (!this.addPremFlag.equals(other.getAddPremFlag()))) return false;
/* 1231 */     if ((this.addPremReason == null) && (other.getAddPremReason() != null)) return false;
/* 1232 */     if ((this.addPremReason != null) && (!this.addPremReason.equals(other.getAddPremReason()))) return false;
/* 1233 */     if ((this.specReason == null) && (other.getSpecReason() != null)) return false;
/* 1234 */     if ((this.specReason != null) && (!this.specReason.equals(other.getSpecReason()))) return false;
/* 1235 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1236 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1237 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1238 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1239 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1240 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1241 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1242 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1243 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1244 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1251 */     return 29;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1257 */     if (strFieldName.equals("grpContNo")) {
/* 1258 */       return 0;
/*      */     }
/* 1260 */     if (strFieldName.equals("contNo")) {
/* 1261 */       return 1;
/*      */     }
/* 1263 */     if (strFieldName.equals("proposalContNo")) {
/* 1264 */       return 2;
/*      */     }
/* 1266 */     if (strFieldName.equals("uWNo")) {
/* 1267 */       return 3;
/*      */     }
/* 1269 */     if (strFieldName.equals("manageCom")) {
/* 1270 */       return 4;
/*      */     }
/* 1272 */     if (strFieldName.equals("uWDate")) {
/* 1273 */       return 5;
/*      */     }
/* 1275 */     if (strFieldName.equals("uWTime")) {
/* 1276 */       return 6;
/*      */     }
/* 1278 */     if (strFieldName.equals("uWerName")) {
/* 1279 */       return 7;
/*      */     }
/* 1281 */     if (strFieldName.equals("checkStatus")) {
/* 1282 */       return 8;
/*      */     }
/* 1284 */     if (strFieldName.equals("appIsCompleted")) {
/* 1285 */       return 9;
/*      */     }
/* 1287 */     if (strFieldName.equals("appIsSubmitted")) {
/* 1288 */       return 10;
/*      */     }
/* 1290 */     if (strFieldName.equals("appDecision")) {
/* 1291 */       return 11;
/*      */     }
/* 1293 */     if (strFieldName.equals("autoUWFlag")) {
/* 1294 */       return 12;
/*      */     }
/* 1296 */     if (strFieldName.equals("uWMessages")) {
/* 1297 */       return 13;
/*      */     }
/* 1299 */     if (strFieldName.equals("uWGrade")) {
/* 1300 */       return 14;
/*      */     }
/* 1302 */     if (strFieldName.equals("appGrade")) {
/* 1303 */       return 15;
/*      */     }
/* 1305 */     if (strFieldName.equals("state")) {
/* 1306 */       return 16;
/*      */     }
/* 1308 */     if (strFieldName.equals("upReportContent")) {
/* 1309 */       return 17;
/*      */     }
/* 1311 */     if (strFieldName.equals("healthFlag")) {
/* 1312 */       return 18;
/*      */     }
/* 1314 */     if (strFieldName.equals("quesFlag")) {
/* 1315 */       return 19;
/*      */     }
/* 1317 */     if (strFieldName.equals("specFlag")) {
/* 1318 */       return 20;
/*      */     }
/* 1320 */     if (strFieldName.equals("addPremFlag")) {
/* 1321 */       return 21;
/*      */     }
/* 1323 */     if (strFieldName.equals("addPremReason")) {
/* 1324 */       return 22;
/*      */     }
/* 1326 */     if (strFieldName.equals("specReason")) {
/* 1327 */       return 23;
/*      */     }
/* 1329 */     if (strFieldName.equals("operator")) {
/* 1330 */       return 24;
/*      */     }
/* 1332 */     if (strFieldName.equals("makeDate")) {
/* 1333 */       return 25;
/*      */     }
/* 1335 */     if (strFieldName.equals("makeTime")) {
/* 1336 */       return 26;
/*      */     }
/* 1338 */     if (strFieldName.equals("modifyDate")) {
/* 1339 */       return 27;
/*      */     }
/* 1341 */     if (strFieldName.equals("modifyTime")) {
/* 1342 */       return 28;
/*      */     }
/* 1344 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1350 */     String strFieldName = "";
/* 1351 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1353 */       strFieldName = "grpContNo";
/* 1354 */       break;
/*      */     case 1:
/* 1356 */       strFieldName = "contNo";
/* 1357 */       break;
/*      */     case 2:
/* 1359 */       strFieldName = "proposalContNo";
/* 1360 */       break;
/*      */     case 3:
/* 1362 */       strFieldName = "uWNo";
/* 1363 */       break;
/*      */     case 4:
/* 1365 */       strFieldName = "manageCom";
/* 1366 */       break;
/*      */     case 5:
/* 1368 */       strFieldName = "uWDate";
/* 1369 */       break;
/*      */     case 6:
/* 1371 */       strFieldName = "uWTime";
/* 1372 */       break;
/*      */     case 7:
/* 1374 */       strFieldName = "uWerName";
/* 1375 */       break;
/*      */     case 8:
/* 1377 */       strFieldName = "checkStatus";
/* 1378 */       break;
/*      */     case 9:
/* 1380 */       strFieldName = "appIsCompleted";
/* 1381 */       break;
/*      */     case 10:
/* 1383 */       strFieldName = "appIsSubmitted";
/* 1384 */       break;
/*      */     case 11:
/* 1386 */       strFieldName = "appDecision";
/* 1387 */       break;
/*      */     case 12:
/* 1389 */       strFieldName = "autoUWFlag";
/* 1390 */       break;
/*      */     case 13:
/* 1392 */       strFieldName = "uWMessages";
/* 1393 */       break;
/*      */     case 14:
/* 1395 */       strFieldName = "uWGrade";
/* 1396 */       break;
/*      */     case 15:
/* 1398 */       strFieldName = "appGrade";
/* 1399 */       break;
/*      */     case 16:
/* 1401 */       strFieldName = "state";
/* 1402 */       break;
/*      */     case 17:
/* 1404 */       strFieldName = "upReportContent";
/* 1405 */       break;
/*      */     case 18:
/* 1407 */       strFieldName = "healthFlag";
/* 1408 */       break;
/*      */     case 19:
/* 1410 */       strFieldName = "quesFlag";
/* 1411 */       break;
/*      */     case 20:
/* 1413 */       strFieldName = "specFlag";
/* 1414 */       break;
/*      */     case 21:
/* 1416 */       strFieldName = "addPremFlag";
/* 1417 */       break;
/*      */     case 22:
/* 1419 */       strFieldName = "addPremReason";
/* 1420 */       break;
/*      */     case 23:
/* 1422 */       strFieldName = "specReason";
/* 1423 */       break;
/*      */     case 24:
/* 1425 */       strFieldName = "operator";
/* 1426 */       break;
/*      */     case 25:
/* 1428 */       strFieldName = "makeDate";
/* 1429 */       break;
/*      */     case 26:
/* 1431 */       strFieldName = "makeTime";
/* 1432 */       break;
/*      */     case 27:
/* 1434 */       strFieldName = "modifyDate";
/* 1435 */       break;
/*      */     case 28:
/* 1437 */       strFieldName = "modifyTime";
/* 1438 */       break;
/*      */     default:
/* 1440 */       strFieldName = "";
/*      */     }
/* 1442 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1448 */     if (strFieldName.equals("grpContNo")) {
/* 1449 */       return 0;
/*      */     }
/* 1451 */     if (strFieldName.equals("contNo")) {
/* 1452 */       return 0;
/*      */     }
/* 1454 */     if (strFieldName.equals("proposalContNo")) {
/* 1455 */       return 0;
/*      */     }
/* 1457 */     if (strFieldName.equals("uWNo")) {
/* 1458 */       return 3;
/*      */     }
/* 1460 */     if (strFieldName.equals("manageCom")) {
/* 1461 */       return 0;
/*      */     }
/* 1463 */     if (strFieldName.equals("uWDate")) {
/* 1464 */       return 1;
/*      */     }
/* 1466 */     if (strFieldName.equals("uWTime")) {
/* 1467 */       return 0;
/*      */     }
/* 1469 */     if (strFieldName.equals("uWerName")) {
/* 1470 */       return 0;
/*      */     }
/* 1472 */     if (strFieldName.equals("checkStatus")) {
/* 1473 */       return 0;
/*      */     }
/* 1475 */     if (strFieldName.equals("appIsCompleted")) {
/* 1476 */       return 0;
/*      */     }
/* 1478 */     if (strFieldName.equals("appIsSubmitted")) {
/* 1479 */       return 0;
/*      */     }
/* 1481 */     if (strFieldName.equals("appDecision")) {
/* 1482 */       return 0;
/*      */     }
/* 1484 */     if (strFieldName.equals("autoUWFlag")) {
/* 1485 */       return 0;
/*      */     }
/* 1487 */     if (strFieldName.equals("uWMessages")) {
/* 1488 */       return 0;
/*      */     }
/* 1490 */     if (strFieldName.equals("uWGrade")) {
/* 1491 */       return 0;
/*      */     }
/* 1493 */     if (strFieldName.equals("appGrade")) {
/* 1494 */       return 0;
/*      */     }
/* 1496 */     if (strFieldName.equals("state")) {
/* 1497 */       return 0;
/*      */     }
/* 1499 */     if (strFieldName.equals("upReportContent")) {
/* 1500 */       return 0;
/*      */     }
/* 1502 */     if (strFieldName.equals("healthFlag")) {
/* 1503 */       return 0;
/*      */     }
/* 1505 */     if (strFieldName.equals("quesFlag")) {
/* 1506 */       return 0;
/*      */     }
/* 1508 */     if (strFieldName.equals("specFlag")) {
/* 1509 */       return 0;
/*      */     }
/* 1511 */     if (strFieldName.equals("addPremFlag")) {
/* 1512 */       return 0;
/*      */     }
/* 1514 */     if (strFieldName.equals("addPremReason")) {
/* 1515 */       return 0;
/*      */     }
/* 1517 */     if (strFieldName.equals("specReason")) {
/* 1518 */       return 0;
/*      */     }
/* 1520 */     if (strFieldName.equals("operator")) {
/* 1521 */       return 0;
/*      */     }
/* 1523 */     if (strFieldName.equals("makeDate")) {
/* 1524 */       return 1;
/*      */     }
/* 1526 */     if (strFieldName.equals("makeTime")) {
/* 1527 */       return 0;
/*      */     }
/* 1529 */     if (strFieldName.equals("modifyDate")) {
/* 1530 */       return 1;
/*      */     }
/* 1532 */     if (strFieldName.equals("modifyTime")) {
/* 1533 */       return 0;
/*      */     }
/* 1535 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1541 */     int nFieldType = -1;
/* 1542 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1544 */       nFieldType = 0;
/* 1545 */       break;
/*      */     case 1:
/* 1547 */       nFieldType = 0;
/* 1548 */       break;
/*      */     case 2:
/* 1550 */       nFieldType = 0;
/* 1551 */       break;
/*      */     case 3:
/* 1553 */       nFieldType = 3;
/* 1554 */       break;
/*      */     case 4:
/* 1556 */       nFieldType = 0;
/* 1557 */       break;
/*      */     case 5:
/* 1559 */       nFieldType = 1;
/* 1560 */       break;
/*      */     case 6:
/* 1562 */       nFieldType = 0;
/* 1563 */       break;
/*      */     case 7:
/* 1565 */       nFieldType = 0;
/* 1566 */       break;
/*      */     case 8:
/* 1568 */       nFieldType = 0;
/* 1569 */       break;
/*      */     case 9:
/* 1571 */       nFieldType = 0;
/* 1572 */       break;
/*      */     case 10:
/* 1574 */       nFieldType = 0;
/* 1575 */       break;
/*      */     case 11:
/* 1577 */       nFieldType = 0;
/* 1578 */       break;
/*      */     case 12:
/* 1580 */       nFieldType = 0;
/* 1581 */       break;
/*      */     case 13:
/* 1583 */       nFieldType = 0;
/* 1584 */       break;
/*      */     case 14:
/* 1586 */       nFieldType = 0;
/* 1587 */       break;
/*      */     case 15:
/* 1589 */       nFieldType = 0;
/* 1590 */       break;
/*      */     case 16:
/* 1592 */       nFieldType = 0;
/* 1593 */       break;
/*      */     case 17:
/* 1595 */       nFieldType = 0;
/* 1596 */       break;
/*      */     case 18:
/* 1598 */       nFieldType = 0;
/* 1599 */       break;
/*      */     case 19:
/* 1601 */       nFieldType = 0;
/* 1602 */       break;
/*      */     case 20:
/* 1604 */       nFieldType = 0;
/* 1605 */       break;
/*      */     case 21:
/* 1607 */       nFieldType = 0;
/* 1608 */       break;
/*      */     case 22:
/* 1610 */       nFieldType = 0;
/* 1611 */       break;
/*      */     case 23:
/* 1613 */       nFieldType = 0;
/* 1614 */       break;
/*      */     case 24:
/* 1616 */       nFieldType = 0;
/* 1617 */       break;
/*      */     case 25:
/* 1619 */       nFieldType = 1;
/* 1620 */       break;
/*      */     case 26:
/* 1622 */       nFieldType = 0;
/* 1623 */       break;
/*      */     case 27:
/* 1625 */       nFieldType = 1;
/* 1626 */       break;
/*      */     case 28:
/* 1628 */       nFieldType = 0;
/* 1629 */       break;
/*      */     default:
/* 1631 */       nFieldType = -1;
/*      */     }
/* 1633 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPCUWMasterSchema
 * JD-Core Version:    0.6.0
 */