/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPIndUWMasterDB;
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
/*      */ public class LNPIndUWMasterSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private int uWNo;
/*      */   private String manageCom;
/*      */   private String insuredId;
/*      */   private String insuredNo;
/*      */   private String insuredName;
/*      */   private String flagCaseDcl;
/*      */   private String highFaceAmount;
/*      */   private String uWMessages;
/*      */   private String appntId;
/*      */   private String appntNo;
/*      */   private String appntName;
/*      */   private String passFlag;
/*      */   private String uWIdea;
/*      */   private String uWGrade;
/*      */   private String appGrade;
/*      */   private String postponeDay;
/*      */   private Date postponeDate;
/*      */   private String autoUWFlag;
/*      */   private String state;
/*      */   private String upReportContent;
/*      */   private String healthFlag;
/*      */   private String quesFlag;
/*      */   private String specFlag;
/*      */   private String addPremFlag;
/*      */   private String addPremReason;
/*      */   private String reportFlag;
/*      */   private String specReason;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 35;
/*      */   private static String[] PK;
/*   97 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPIndUWMasterSchema()
/*      */   {
/*  104 */     this.mErrors = new CErrors();
/*      */ 
/*  106 */     String[] pk = new String[2];
/*  107 */     pk[0] = "ContNo";
/*  108 */     pk[1] = "InsuredId";
/*      */ 
/*  110 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  117 */     LNPIndUWMasterSchema cloned = (LNPIndUWMasterSchema)super.clone();
/*  118 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  119 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  120 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  126 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo()
/*      */   {
/*  131 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  135 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  139 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  143 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  147 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  151 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public int getUWNo() {
/*  155 */     return this.uWNo;
/*      */   }
/*      */ 
/*      */   public void setUWNo(int aUWNo) {
/*  159 */     this.uWNo = aUWNo;
/*      */   }
/*      */ 
/*      */   public void setUWNo(String aUWNo) {
/*  163 */     if ((aUWNo != null) && (!aUWNo.equals("")))
/*      */     {
/*  165 */       Integer tInteger = new Integer(aUWNo);
/*  166 */       int i = tInteger.intValue();
/*  167 */       this.uWNo = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getManageCom()
/*      */   {
/*  173 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  177 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getInsuredId() {
/*  181 */     return this.insuredId;
/*      */   }
/*      */ 
/*      */   public void setInsuredId(String aInsuredId) {
/*  185 */     this.insuredId = aInsuredId;
/*      */   }
/*      */ 
/*      */   public String getInsuredNo() {
/*  189 */     return this.insuredNo;
/*      */   }
/*      */ 
/*      */   public void setInsuredNo(String aInsuredNo) {
/*  193 */     this.insuredNo = aInsuredNo;
/*      */   }
/*      */ 
/*      */   public String getInsuredName() {
/*  197 */     return this.insuredName;
/*      */   }
/*      */ 
/*      */   public void setInsuredName(String aInsuredName) {
/*  201 */     this.insuredName = aInsuredName;
/*      */   }
/*      */ 
/*      */   public String getFlagCaseDcl() {
/*  205 */     return this.flagCaseDcl;
/*      */   }
/*      */ 
/*      */   public void setFlagCaseDcl(String aFlagCaseDcl) {
/*  209 */     this.flagCaseDcl = aFlagCaseDcl;
/*      */   }
/*      */ 
/*      */   public String getHighFaceAmount() {
/*  213 */     return this.highFaceAmount;
/*      */   }
/*      */ 
/*      */   public void setHighFaceAmount(String aHighFaceAmount) {
/*  217 */     this.highFaceAmount = aHighFaceAmount;
/*      */   }
/*      */ 
/*      */   public String getUWMessages() {
/*  221 */     return this.uWMessages;
/*      */   }
/*      */ 
/*      */   public void setUWMessages(String aUWMessages) {
/*  225 */     this.uWMessages = aUWMessages;
/*      */   }
/*      */ 
/*      */   public String getAppntId() {
/*  229 */     return this.appntId;
/*      */   }
/*      */ 
/*      */   public void setAppntId(String aAppntId) {
/*  233 */     this.appntId = aAppntId;
/*      */   }
/*      */ 
/*      */   public String getAppntNo() {
/*  237 */     return this.appntNo;
/*      */   }
/*      */ 
/*      */   public void setAppntNo(String aAppntNo) {
/*  241 */     this.appntNo = aAppntNo;
/*      */   }
/*      */ 
/*      */   public String getAppntName() {
/*  245 */     return this.appntName;
/*      */   }
/*      */ 
/*      */   public void setAppntName(String aAppntName) {
/*  249 */     this.appntName = aAppntName;
/*      */   }
/*      */ 
/*      */   public String getPassFlag() {
/*  253 */     return this.passFlag;
/*      */   }
/*      */ 
/*      */   public void setPassFlag(String aPassFlag) {
/*  257 */     this.passFlag = aPassFlag;
/*      */   }
/*      */ 
/*      */   public String getUWIdea() {
/*  261 */     return this.uWIdea;
/*      */   }
/*      */ 
/*      */   public void setUWIdea(String aUWIdea) {
/*  265 */     this.uWIdea = aUWIdea;
/*      */   }
/*      */ 
/*      */   public String getUWGrade() {
/*  269 */     return this.uWGrade;
/*      */   }
/*      */ 
/*      */   public void setUWGrade(String aUWGrade) {
/*  273 */     this.uWGrade = aUWGrade;
/*      */   }
/*      */ 
/*      */   public String getAppGrade() {
/*  277 */     return this.appGrade;
/*      */   }
/*      */ 
/*      */   public void setAppGrade(String aAppGrade) {
/*  281 */     this.appGrade = aAppGrade;
/*      */   }
/*      */ 
/*      */   public String getPostponeDay() {
/*  285 */     return this.postponeDay;
/*      */   }
/*      */ 
/*      */   public void setPostponeDay(String aPostponeDay) {
/*  289 */     this.postponeDay = aPostponeDay;
/*      */   }
/*      */ 
/*      */   public String getPostponeDate() {
/*  293 */     if (this.postponeDate != null) {
/*  294 */       return this.fDate.getString(this.postponeDate);
/*      */     }
/*  296 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPostponeDate(Date aPostponeDate) {
/*  300 */     this.postponeDate = aPostponeDate;
/*      */   }
/*      */ 
/*      */   public void setPostponeDate(String aPostponeDate) {
/*  304 */     if ((aPostponeDate != null) && (!aPostponeDate.equals("")))
/*      */     {
/*  306 */       this.postponeDate = this.fDate.getDate(aPostponeDate);
/*      */     }
/*      */     else
/*  309 */       this.postponeDate = null;
/*      */   }
/*      */ 
/*      */   public String getAutoUWFlag()
/*      */   {
/*  314 */     return this.autoUWFlag;
/*      */   }
/*      */ 
/*      */   public void setAutoUWFlag(String aAutoUWFlag) {
/*  318 */     this.autoUWFlag = aAutoUWFlag;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  322 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  326 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getUpReportContent() {
/*  330 */     return this.upReportContent;
/*      */   }
/*      */ 
/*      */   public void setUpReportContent(String aUpReportContent) {
/*  334 */     this.upReportContent = aUpReportContent;
/*      */   }
/*      */ 
/*      */   public String getHealthFlag() {
/*  338 */     return this.healthFlag;
/*      */   }
/*      */ 
/*      */   public void setHealthFlag(String aHealthFlag) {
/*  342 */     this.healthFlag = aHealthFlag;
/*      */   }
/*      */ 
/*      */   public String getQuesFlag() {
/*  346 */     return this.quesFlag;
/*      */   }
/*      */ 
/*      */   public void setQuesFlag(String aQuesFlag) {
/*  350 */     this.quesFlag = aQuesFlag;
/*      */   }
/*      */ 
/*      */   public String getSpecFlag() {
/*  354 */     return this.specFlag;
/*      */   }
/*      */ 
/*      */   public void setSpecFlag(String aSpecFlag) {
/*  358 */     this.specFlag = aSpecFlag;
/*      */   }
/*      */ 
/*      */   public String getAddPremFlag() {
/*  362 */     return this.addPremFlag;
/*      */   }
/*      */ 
/*      */   public void setAddPremFlag(String aAddPremFlag) {
/*  366 */     this.addPremFlag = aAddPremFlag;
/*      */   }
/*      */ 
/*      */   public String getAddPremReason() {
/*  370 */     return this.addPremReason;
/*      */   }
/*      */ 
/*      */   public void setAddPremReason(String aAddPremReason) {
/*  374 */     this.addPremReason = aAddPremReason;
/*      */   }
/*      */ 
/*      */   public String getReportFlag() {
/*  378 */     return this.reportFlag;
/*      */   }
/*      */ 
/*      */   public void setReportFlag(String aReportFlag) {
/*  382 */     this.reportFlag = aReportFlag;
/*      */   }
/*      */ 
/*      */   public String getSpecReason() {
/*  386 */     return this.specReason;
/*      */   }
/*      */ 
/*      */   public void setSpecReason(String aSpecReason) {
/*  390 */     this.specReason = aSpecReason;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  394 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  398 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  402 */     if (this.makeDate != null) {
/*  403 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  405 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  409 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  413 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  415 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  418 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  423 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  427 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  431 */     if (this.modifyDate != null) {
/*  432 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  434 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  438 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  442 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  444 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  447 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  452 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  456 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPIndUWMasterSchema aLNPIndUWMasterSchema)
/*      */   {
/*  462 */     this.grpContNo = aLNPIndUWMasterSchema.getGrpContNo();
/*  463 */     this.contNo = aLNPIndUWMasterSchema.getContNo();
/*  464 */     this.proposalContNo = aLNPIndUWMasterSchema.getProposalContNo();
/*  465 */     this.uWNo = aLNPIndUWMasterSchema.getUWNo();
/*  466 */     this.manageCom = aLNPIndUWMasterSchema.getManageCom();
/*  467 */     this.insuredId = aLNPIndUWMasterSchema.getInsuredId();
/*  468 */     this.insuredNo = aLNPIndUWMasterSchema.getInsuredNo();
/*  469 */     this.insuredName = aLNPIndUWMasterSchema.getInsuredName();
/*  470 */     this.flagCaseDcl = aLNPIndUWMasterSchema.getFlagCaseDcl();
/*  471 */     this.highFaceAmount = aLNPIndUWMasterSchema.getHighFaceAmount();
/*  472 */     this.uWMessages = aLNPIndUWMasterSchema.getUWMessages();
/*  473 */     this.appntId = aLNPIndUWMasterSchema.getAppntId();
/*  474 */     this.appntNo = aLNPIndUWMasterSchema.getAppntNo();
/*  475 */     this.appntName = aLNPIndUWMasterSchema.getAppntName();
/*  476 */     this.passFlag = aLNPIndUWMasterSchema.getPassFlag();
/*  477 */     this.uWIdea = aLNPIndUWMasterSchema.getUWIdea();
/*  478 */     this.uWGrade = aLNPIndUWMasterSchema.getUWGrade();
/*  479 */     this.appGrade = aLNPIndUWMasterSchema.getAppGrade();
/*  480 */     this.postponeDay = aLNPIndUWMasterSchema.getPostponeDay();
/*  481 */     this.postponeDate = this.fDate.getDate(aLNPIndUWMasterSchema.getPostponeDate());
/*  482 */     this.autoUWFlag = aLNPIndUWMasterSchema.getAutoUWFlag();
/*  483 */     this.state = aLNPIndUWMasterSchema.getState();
/*  484 */     this.upReportContent = aLNPIndUWMasterSchema.getUpReportContent();
/*  485 */     this.healthFlag = aLNPIndUWMasterSchema.getHealthFlag();
/*  486 */     this.quesFlag = aLNPIndUWMasterSchema.getQuesFlag();
/*  487 */     this.specFlag = aLNPIndUWMasterSchema.getSpecFlag();
/*  488 */     this.addPremFlag = aLNPIndUWMasterSchema.getAddPremFlag();
/*  489 */     this.addPremReason = aLNPIndUWMasterSchema.getAddPremReason();
/*  490 */     this.reportFlag = aLNPIndUWMasterSchema.getReportFlag();
/*  491 */     this.specReason = aLNPIndUWMasterSchema.getSpecReason();
/*  492 */     this.operator = aLNPIndUWMasterSchema.getOperator();
/*  493 */     this.makeDate = this.fDate.getDate(aLNPIndUWMasterSchema.getMakeDate());
/*  494 */     this.makeTime = aLNPIndUWMasterSchema.getMakeTime();
/*  495 */     this.modifyDate = this.fDate.getDate(aLNPIndUWMasterSchema.getModifyDate());
/*  496 */     this.modifyTime = aLNPIndUWMasterSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  505 */       if (rs.getString("GrpContNo") == null)
/*  506 */         this.grpContNo = null;
/*      */       else {
/*  508 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  510 */       if (rs.getString("ContNo") == null)
/*  511 */         this.contNo = null;
/*      */       else {
/*  513 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  515 */       if (rs.getString("ProposalContNo") == null)
/*  516 */         this.proposalContNo = null;
/*      */       else {
/*  518 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  520 */       this.uWNo = rs.getInt("UWNo");
/*  521 */       if (rs.getString("ManageCom") == null)
/*  522 */         this.manageCom = null;
/*      */       else {
/*  524 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  526 */       if (rs.getString("InsuredId") == null)
/*  527 */         this.insuredId = null;
/*      */       else {
/*  529 */         this.insuredId = rs.getString("InsuredId").trim();
/*      */       }
/*  531 */       if (rs.getString("InsuredNo") == null)
/*  532 */         this.insuredNo = null;
/*      */       else {
/*  534 */         this.insuredNo = rs.getString("InsuredNo").trim();
/*      */       }
/*  536 */       if (rs.getString("InsuredName") == null)
/*  537 */         this.insuredName = null;
/*      */       else {
/*  539 */         this.insuredName = rs.getString("InsuredName").trim();
/*      */       }
/*  541 */       if (rs.getString("FlagCaseDcl") == null)
/*  542 */         this.flagCaseDcl = null;
/*      */       else {
/*  544 */         this.flagCaseDcl = rs.getString("FlagCaseDcl").trim();
/*      */       }
/*  546 */       if (rs.getString("HighFaceAmount") == null)
/*  547 */         this.highFaceAmount = null;
/*      */       else {
/*  549 */         this.highFaceAmount = rs.getString("HighFaceAmount").trim();
/*      */       }
/*  551 */       if (rs.getString("UWMessages") == null)
/*  552 */         this.uWMessages = null;
/*      */       else {
/*  554 */         this.uWMessages = rs.getString("UWMessages").trim();
/*      */       }
/*  556 */       if (rs.getString("AppntId") == null)
/*  557 */         this.appntId = null;
/*      */       else {
/*  559 */         this.appntId = rs.getString("AppntId").trim();
/*      */       }
/*  561 */       if (rs.getString("AppntNo") == null)
/*  562 */         this.appntNo = null;
/*      */       else {
/*  564 */         this.appntNo = rs.getString("AppntNo").trim();
/*      */       }
/*  566 */       if (rs.getString("AppntName") == null)
/*  567 */         this.appntName = null;
/*      */       else {
/*  569 */         this.appntName = rs.getString("AppntName").trim();
/*      */       }
/*  571 */       if (rs.getString("PassFlag") == null)
/*  572 */         this.passFlag = null;
/*      */       else {
/*  574 */         this.passFlag = rs.getString("PassFlag").trim();
/*      */       }
/*  576 */       if (rs.getString("UWIdea") == null)
/*  577 */         this.uWIdea = null;
/*      */       else {
/*  579 */         this.uWIdea = rs.getString("UWIdea").trim();
/*      */       }
/*  581 */       if (rs.getString("UWGrade") == null)
/*  582 */         this.uWGrade = null;
/*      */       else {
/*  584 */         this.uWGrade = rs.getString("UWGrade").trim();
/*      */       }
/*  586 */       if (rs.getString("AppGrade") == null)
/*  587 */         this.appGrade = null;
/*      */       else {
/*  589 */         this.appGrade = rs.getString("AppGrade").trim();
/*      */       }
/*  591 */       if (rs.getString("PostponeDay") == null)
/*  592 */         this.postponeDay = null;
/*      */       else {
/*  594 */         this.postponeDay = rs.getString("PostponeDay").trim();
/*      */       }
/*  596 */       this.postponeDate = rs.getDate("PostponeDate");
/*  597 */       if (rs.getString("AutoUWFlag") == null)
/*  598 */         this.autoUWFlag = null;
/*      */       else {
/*  600 */         this.autoUWFlag = rs.getString("AutoUWFlag").trim();
/*      */       }
/*  602 */       if (rs.getString("State") == null)
/*  603 */         this.state = null;
/*      */       else {
/*  605 */         this.state = rs.getString("State").trim();
/*      */       }
/*  607 */       if (rs.getString("UpReportContent") == null)
/*  608 */         this.upReportContent = null;
/*      */       else {
/*  610 */         this.upReportContent = rs.getString("UpReportContent").trim();
/*      */       }
/*  612 */       if (rs.getString("HealthFlag") == null)
/*  613 */         this.healthFlag = null;
/*      */       else {
/*  615 */         this.healthFlag = rs.getString("HealthFlag").trim();
/*      */       }
/*  617 */       if (rs.getString("QuesFlag") == null)
/*  618 */         this.quesFlag = null;
/*      */       else {
/*  620 */         this.quesFlag = rs.getString("QuesFlag").trim();
/*      */       }
/*  622 */       if (rs.getString("SpecFlag") == null)
/*  623 */         this.specFlag = null;
/*      */       else {
/*  625 */         this.specFlag = rs.getString("SpecFlag").trim();
/*      */       }
/*  627 */       if (rs.getString("AddPremFlag") == null)
/*  628 */         this.addPremFlag = null;
/*      */       else {
/*  630 */         this.addPremFlag = rs.getString("AddPremFlag").trim();
/*      */       }
/*  632 */       if (rs.getString("AddPremReason") == null)
/*  633 */         this.addPremReason = null;
/*      */       else {
/*  635 */         this.addPremReason = rs.getString("AddPremReason").trim();
/*      */       }
/*  637 */       if (rs.getString("ReportFlag") == null)
/*  638 */         this.reportFlag = null;
/*      */       else {
/*  640 */         this.reportFlag = rs.getString("ReportFlag").trim();
/*      */       }
/*  642 */       if (rs.getString("SpecReason") == null)
/*  643 */         this.specReason = null;
/*      */       else {
/*  645 */         this.specReason = rs.getString("SpecReason").trim();
/*      */       }
/*  647 */       if (rs.getString("Operator") == null)
/*  648 */         this.operator = null;
/*      */       else {
/*  650 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  652 */       this.makeDate = rs.getDate("MakeDate");
/*  653 */       if (rs.getString("MakeTime") == null)
/*  654 */         this.makeTime = null;
/*      */       else {
/*  656 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  658 */       this.modifyDate = rs.getDate("ModifyDate");
/*  659 */       if (rs.getString("ModifyTime") == null)
/*  660 */         this.modifyTime = null;
/*      */       else {
/*  662 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  667 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPIndUWMaster\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/*  669 */       CError tError = new CError();
/*  670 */       tError.moduleName = "LNPIndUWMasterSchema";
/*  671 */       tError.functionName = "setSchema";
/*  672 */       tError.errorMessage = sqle.toString();
/*  673 */       this.mErrors.addOneError(tError);
/*  674 */       return false;
/*      */     }
/*  676 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPIndUWMasterSchema getSchema()
/*      */   {
/*  681 */     LNPIndUWMasterSchema aLNPIndUWMasterSchema = new LNPIndUWMasterSchema();
/*  682 */     aLNPIndUWMasterSchema.setSchema(this);
/*  683 */     return aLNPIndUWMasterSchema;
/*      */   }
/*      */ 
/*      */   public LNPIndUWMasterDB getDB()
/*      */   {
/*  688 */     LNPIndUWMasterDB aDBOper = new LNPIndUWMasterDB();
/*  689 */     aDBOper.setSchema(this);
/*  690 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  697 */     StringBuffer strReturn = new StringBuffer(256);
/*  698 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/*  699 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/*  700 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/*  701 */     strReturn.append(ChgData.chgData(this.uWNo)); strReturn.append("|");
/*  702 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  703 */     strReturn.append(StrTool.cTrim(this.insuredId)); strReturn.append("|");
/*  704 */     strReturn.append(StrTool.cTrim(this.insuredNo)); strReturn.append("|");
/*  705 */     strReturn.append(StrTool.cTrim(this.insuredName)); strReturn.append("|");
/*  706 */     strReturn.append(StrTool.cTrim(this.flagCaseDcl)); strReturn.append("|");
/*  707 */     strReturn.append(StrTool.cTrim(this.highFaceAmount)); strReturn.append("|");
/*  708 */     strReturn.append(StrTool.cTrim(this.uWMessages)); strReturn.append("|");
/*  709 */     strReturn.append(StrTool.cTrim(this.appntId)); strReturn.append("|");
/*  710 */     strReturn.append(StrTool.cTrim(this.appntNo)); strReturn.append("|");
/*  711 */     strReturn.append(StrTool.cTrim(this.appntName)); strReturn.append("|");
/*  712 */     strReturn.append(StrTool.cTrim(this.passFlag)); strReturn.append("|");
/*  713 */     strReturn.append(StrTool.cTrim(this.uWIdea)); strReturn.append("|");
/*  714 */     strReturn.append(StrTool.cTrim(this.uWGrade)); strReturn.append("|");
/*  715 */     strReturn.append(StrTool.cTrim(this.appGrade)); strReturn.append("|");
/*  716 */     strReturn.append(StrTool.cTrim(this.postponeDay)); strReturn.append("|");
/*  717 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.postponeDate))); strReturn.append("|");
/*  718 */     strReturn.append(StrTool.cTrim(this.autoUWFlag)); strReturn.append("|");
/*  719 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  720 */     strReturn.append(StrTool.cTrim(this.upReportContent)); strReturn.append("|");
/*  721 */     strReturn.append(StrTool.cTrim(this.healthFlag)); strReturn.append("|");
/*  722 */     strReturn.append(StrTool.cTrim(this.quesFlag)); strReturn.append("|");
/*  723 */     strReturn.append(StrTool.cTrim(this.specFlag)); strReturn.append("|");
/*  724 */     strReturn.append(StrTool.cTrim(this.addPremFlag)); strReturn.append("|");
/*  725 */     strReturn.append(StrTool.cTrim(this.addPremReason)); strReturn.append("|");
/*  726 */     strReturn.append(StrTool.cTrim(this.reportFlag)); strReturn.append("|");
/*  727 */     strReturn.append(StrTool.cTrim(this.specReason)); strReturn.append("|");
/*  728 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  729 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  730 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  731 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  732 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  733 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  741 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  742 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  743 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  744 */       this.uWNo = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|"))).intValue();
/*  745 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  746 */       this.insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  747 */       this.insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  748 */       this.insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  749 */       this.flagCaseDcl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  750 */       this.highFaceAmount = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  751 */       this.uWMessages = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  752 */       this.appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  753 */       this.appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  754 */       this.appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  755 */       this.passFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  756 */       this.uWIdea = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  757 */       this.uWGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  758 */       this.appGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  759 */       this.postponeDay = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  760 */       this.postponeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  761 */       this.autoUWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  762 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  763 */       this.upReportContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  764 */       this.healthFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  765 */       this.quesFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  766 */       this.specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  767 */       this.addPremFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  768 */       this.addPremReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*  769 */       this.reportFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*  770 */       this.specReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/*  771 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/*  772 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|"));
/*  773 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/*  774 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|"));
/*  775 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  780 */       CError tError = new CError();
/*  781 */       tError.moduleName = "LNPIndUWMasterSchema";
/*  782 */       tError.functionName = "decode";
/*  783 */       tError.errorMessage = ex.toString();
/*  784 */       this.mErrors.addOneError(tError);
/*      */ 
/*  786 */       return false;
/*      */     }
/*  788 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  794 */     String strReturn = "";
/*  795 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  797 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  799 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  801 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  803 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  805 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  807 */     if (FCode.equalsIgnoreCase("uWNo"))
/*      */     {
/*  809 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWNo));
/*      */     }
/*  811 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  813 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  815 */     if (FCode.equalsIgnoreCase("insuredId"))
/*      */     {
/*  817 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredId));
/*      */     }
/*  819 */     if (FCode.equalsIgnoreCase("insuredNo"))
/*      */     {
/*  821 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredNo));
/*      */     }
/*  823 */     if (FCode.equalsIgnoreCase("insuredName"))
/*      */     {
/*  825 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredName));
/*      */     }
/*  827 */     if (FCode.equalsIgnoreCase("flagCaseDcl"))
/*      */     {
/*  829 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.flagCaseDcl));
/*      */     }
/*  831 */     if (FCode.equalsIgnoreCase("highFaceAmount"))
/*      */     {
/*  833 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.highFaceAmount));
/*      */     }
/*  835 */     if (FCode.equalsIgnoreCase("uWMessages"))
/*      */     {
/*  837 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWMessages));
/*      */     }
/*  839 */     if (FCode.equalsIgnoreCase("appntId"))
/*      */     {
/*  841 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntId));
/*      */     }
/*  843 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/*  845 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntNo));
/*      */     }
/*  847 */     if (FCode.equalsIgnoreCase("appntName"))
/*      */     {
/*  849 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntName));
/*      */     }
/*  851 */     if (FCode.equalsIgnoreCase("passFlag"))
/*      */     {
/*  853 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.passFlag));
/*      */     }
/*  855 */     if (FCode.equalsIgnoreCase("uWIdea"))
/*      */     {
/*  857 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWIdea));
/*      */     }
/*  859 */     if (FCode.equalsIgnoreCase("uWGrade"))
/*      */     {
/*  861 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWGrade));
/*      */     }
/*  863 */     if (FCode.equalsIgnoreCase("appGrade"))
/*      */     {
/*  865 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appGrade));
/*      */     }
/*  867 */     if (FCode.equalsIgnoreCase("postponeDay"))
/*      */     {
/*  869 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.postponeDay));
/*      */     }
/*  871 */     if (FCode.equalsIgnoreCase("postponeDate"))
/*      */     {
/*  873 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPostponeDate()));
/*      */     }
/*  875 */     if (FCode.equalsIgnoreCase("autoUWFlag"))
/*      */     {
/*  877 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.autoUWFlag));
/*      */     }
/*  879 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  881 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  883 */     if (FCode.equalsIgnoreCase("upReportContent"))
/*      */     {
/*  885 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.upReportContent));
/*      */     }
/*  887 */     if (FCode.equalsIgnoreCase("healthFlag"))
/*      */     {
/*  889 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.healthFlag));
/*      */     }
/*  891 */     if (FCode.equalsIgnoreCase("quesFlag"))
/*      */     {
/*  893 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.quesFlag));
/*      */     }
/*  895 */     if (FCode.equalsIgnoreCase("specFlag"))
/*      */     {
/*  897 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specFlag));
/*      */     }
/*  899 */     if (FCode.equalsIgnoreCase("addPremFlag"))
/*      */     {
/*  901 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addPremFlag));
/*      */     }
/*  903 */     if (FCode.equalsIgnoreCase("addPremReason"))
/*      */     {
/*  905 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addPremReason));
/*      */     }
/*  907 */     if (FCode.equalsIgnoreCase("reportFlag"))
/*      */     {
/*  909 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.reportFlag));
/*      */     }
/*  911 */     if (FCode.equalsIgnoreCase("specReason"))
/*      */     {
/*  913 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specReason));
/*      */     }
/*  915 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  917 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  919 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  921 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  923 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  925 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  927 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  929 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  931 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  933 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  935 */     if (strReturn.equals(""))
/*      */     {
/*  937 */       strReturn = "null";
/*      */     }
/*      */ 
/*  940 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  947 */     String strFieldValue = "";
/*  948 */     switch (nFieldIndex) {
/*      */     case 0:
/*  950 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  951 */       break;
/*      */     case 1:
/*  953 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  954 */       break;
/*      */     case 2:
/*  956 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  957 */       break;
/*      */     case 3:
/*  959 */       strFieldValue = String.valueOf(this.uWNo);
/*  960 */       break;
/*      */     case 4:
/*  962 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  963 */       break;
/*      */     case 5:
/*  965 */       strFieldValue = StrTool.GBKToUnicode(this.insuredId);
/*  966 */       break;
/*      */     case 6:
/*  968 */       strFieldValue = StrTool.GBKToUnicode(this.insuredNo);
/*  969 */       break;
/*      */     case 7:
/*  971 */       strFieldValue = StrTool.GBKToUnicode(this.insuredName);
/*  972 */       break;
/*      */     case 8:
/*  974 */       strFieldValue = StrTool.GBKToUnicode(this.flagCaseDcl);
/*  975 */       break;
/*      */     case 9:
/*  977 */       strFieldValue = StrTool.GBKToUnicode(this.highFaceAmount);
/*  978 */       break;
/*      */     case 10:
/*  980 */       strFieldValue = StrTool.GBKToUnicode(this.uWMessages);
/*  981 */       break;
/*      */     case 11:
/*  983 */       strFieldValue = StrTool.GBKToUnicode(this.appntId);
/*  984 */       break;
/*      */     case 12:
/*  986 */       strFieldValue = StrTool.GBKToUnicode(this.appntNo);
/*  987 */       break;
/*      */     case 13:
/*  989 */       strFieldValue = StrTool.GBKToUnicode(this.appntName);
/*  990 */       break;
/*      */     case 14:
/*  992 */       strFieldValue = StrTool.GBKToUnicode(this.passFlag);
/*  993 */       break;
/*      */     case 15:
/*  995 */       strFieldValue = StrTool.GBKToUnicode(this.uWIdea);
/*  996 */       break;
/*      */     case 16:
/*  998 */       strFieldValue = StrTool.GBKToUnicode(this.uWGrade);
/*  999 */       break;
/*      */     case 17:
/* 1001 */       strFieldValue = StrTool.GBKToUnicode(this.appGrade);
/* 1002 */       break;
/*      */     case 18:
/* 1004 */       strFieldValue = StrTool.GBKToUnicode(this.postponeDay);
/* 1005 */       break;
/*      */     case 19:
/* 1007 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPostponeDate()));
/* 1008 */       break;
/*      */     case 20:
/* 1010 */       strFieldValue = StrTool.GBKToUnicode(this.autoUWFlag);
/* 1011 */       break;
/*      */     case 21:
/* 1013 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 1014 */       break;
/*      */     case 22:
/* 1016 */       strFieldValue = StrTool.GBKToUnicode(this.upReportContent);
/* 1017 */       break;
/*      */     case 23:
/* 1019 */       strFieldValue = StrTool.GBKToUnicode(this.healthFlag);
/* 1020 */       break;
/*      */     case 24:
/* 1022 */       strFieldValue = StrTool.GBKToUnicode(this.quesFlag);
/* 1023 */       break;
/*      */     case 25:
/* 1025 */       strFieldValue = StrTool.GBKToUnicode(this.specFlag);
/* 1026 */       break;
/*      */     case 26:
/* 1028 */       strFieldValue = StrTool.GBKToUnicode(this.addPremFlag);
/* 1029 */       break;
/*      */     case 27:
/* 1031 */       strFieldValue = StrTool.GBKToUnicode(this.addPremReason);
/* 1032 */       break;
/*      */     case 28:
/* 1034 */       strFieldValue = StrTool.GBKToUnicode(this.reportFlag);
/* 1035 */       break;
/*      */     case 29:
/* 1037 */       strFieldValue = StrTool.GBKToUnicode(this.specReason);
/* 1038 */       break;
/*      */     case 30:
/* 1040 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1041 */       break;
/*      */     case 31:
/* 1043 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1044 */       break;
/*      */     case 32:
/* 1046 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1047 */       break;
/*      */     case 33:
/* 1049 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1050 */       break;
/*      */     case 34:
/* 1052 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1053 */       break;
/*      */     default:
/* 1055 */       strFieldValue = "";
/*      */     }
/* 1057 */     if (strFieldValue.equals("")) {
/* 1058 */       strFieldValue = "null";
/*      */     }
/* 1060 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1066 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1067 */       return false;
/*      */     }
/* 1069 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 1071 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1073 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1076 */         this.grpContNo = null;
/*      */     }
/* 1078 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 1080 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1082 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 1085 */         this.contNo = null;
/*      */     }
/* 1087 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 1089 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1091 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1094 */         this.proposalContNo = null;
/*      */     }
/* 1096 */     if (FCode.equalsIgnoreCase("uWNo"))
/*      */     {
/* 1098 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1100 */         Integer tInteger = new Integer(FValue);
/* 1101 */         int i = tInteger.intValue();
/* 1102 */         this.uWNo = i;
/*      */       }
/*      */     }
/* 1105 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1107 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1109 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1112 */         this.manageCom = null;
/*      */     }
/* 1114 */     if (FCode.equalsIgnoreCase("insuredId"))
/*      */     {
/* 1116 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1118 */         this.insuredId = FValue.trim();
/*      */       }
/*      */       else
/* 1121 */         this.insuredId = null;
/*      */     }
/* 1123 */     if (FCode.equalsIgnoreCase("insuredNo"))
/*      */     {
/* 1125 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1127 */         this.insuredNo = FValue.trim();
/*      */       }
/*      */       else
/* 1130 */         this.insuredNo = null;
/*      */     }
/* 1132 */     if (FCode.equalsIgnoreCase("insuredName"))
/*      */     {
/* 1134 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1136 */         this.insuredName = FValue.trim();
/*      */       }
/*      */       else
/* 1139 */         this.insuredName = null;
/*      */     }
/* 1141 */     if (FCode.equalsIgnoreCase("flagCaseDcl"))
/*      */     {
/* 1143 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1145 */         this.flagCaseDcl = FValue.trim();
/*      */       }
/*      */       else
/* 1148 */         this.flagCaseDcl = null;
/*      */     }
/* 1150 */     if (FCode.equalsIgnoreCase("highFaceAmount"))
/*      */     {
/* 1152 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1154 */         this.highFaceAmount = FValue.trim();
/*      */       }
/*      */       else
/* 1157 */         this.highFaceAmount = null;
/*      */     }
/* 1159 */     if (FCode.equalsIgnoreCase("uWMessages"))
/*      */     {
/* 1161 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1163 */         this.uWMessages = FValue.trim();
/*      */       }
/*      */       else
/* 1166 */         this.uWMessages = null;
/*      */     }
/* 1168 */     if (FCode.equalsIgnoreCase("appntId"))
/*      */     {
/* 1170 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1172 */         this.appntId = FValue.trim();
/*      */       }
/*      */       else
/* 1175 */         this.appntId = null;
/*      */     }
/* 1177 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/* 1179 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1181 */         this.appntNo = FValue.trim();
/*      */       }
/*      */       else
/* 1184 */         this.appntNo = null;
/*      */     }
/* 1186 */     if (FCode.equalsIgnoreCase("appntName"))
/*      */     {
/* 1188 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1190 */         this.appntName = FValue.trim();
/*      */       }
/*      */       else
/* 1193 */         this.appntName = null;
/*      */     }
/* 1195 */     if (FCode.equalsIgnoreCase("passFlag"))
/*      */     {
/* 1197 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1199 */         this.passFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1202 */         this.passFlag = null;
/*      */     }
/* 1204 */     if (FCode.equalsIgnoreCase("uWIdea"))
/*      */     {
/* 1206 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1208 */         this.uWIdea = FValue.trim();
/*      */       }
/*      */       else
/* 1211 */         this.uWIdea = null;
/*      */     }
/* 1213 */     if (FCode.equalsIgnoreCase("uWGrade"))
/*      */     {
/* 1215 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1217 */         this.uWGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1220 */         this.uWGrade = null;
/*      */     }
/* 1222 */     if (FCode.equalsIgnoreCase("appGrade"))
/*      */     {
/* 1224 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1226 */         this.appGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1229 */         this.appGrade = null;
/*      */     }
/* 1231 */     if (FCode.equalsIgnoreCase("postponeDay"))
/*      */     {
/* 1233 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1235 */         this.postponeDay = FValue.trim();
/*      */       }
/*      */       else
/* 1238 */         this.postponeDay = null;
/*      */     }
/* 1240 */     if (FCode.equalsIgnoreCase("postponeDate"))
/*      */     {
/* 1242 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1244 */         this.postponeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1247 */         this.postponeDate = null;
/*      */     }
/* 1249 */     if (FCode.equalsIgnoreCase("autoUWFlag"))
/*      */     {
/* 1251 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1253 */         this.autoUWFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1256 */         this.autoUWFlag = null;
/*      */     }
/* 1258 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1260 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1262 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 1265 */         this.state = null;
/*      */     }
/* 1267 */     if (FCode.equalsIgnoreCase("upReportContent"))
/*      */     {
/* 1269 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1271 */         this.upReportContent = FValue.trim();
/*      */       }
/*      */       else
/* 1274 */         this.upReportContent = null;
/*      */     }
/* 1276 */     if (FCode.equalsIgnoreCase("healthFlag"))
/*      */     {
/* 1278 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1280 */         this.healthFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1283 */         this.healthFlag = null;
/*      */     }
/* 1285 */     if (FCode.equalsIgnoreCase("quesFlag"))
/*      */     {
/* 1287 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1289 */         this.quesFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1292 */         this.quesFlag = null;
/*      */     }
/* 1294 */     if (FCode.equalsIgnoreCase("specFlag"))
/*      */     {
/* 1296 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1298 */         this.specFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1301 */         this.specFlag = null;
/*      */     }
/* 1303 */     if (FCode.equalsIgnoreCase("addPremFlag"))
/*      */     {
/* 1305 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1307 */         this.addPremFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1310 */         this.addPremFlag = null;
/*      */     }
/* 1312 */     if (FCode.equalsIgnoreCase("addPremReason"))
/*      */     {
/* 1314 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1316 */         this.addPremReason = FValue.trim();
/*      */       }
/*      */       else
/* 1319 */         this.addPremReason = null;
/*      */     }
/* 1321 */     if (FCode.equalsIgnoreCase("reportFlag"))
/*      */     {
/* 1323 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1325 */         this.reportFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1328 */         this.reportFlag = null;
/*      */     }
/* 1330 */     if (FCode.equalsIgnoreCase("specReason"))
/*      */     {
/* 1332 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1334 */         this.specReason = FValue.trim();
/*      */       }
/*      */       else
/* 1337 */         this.specReason = null;
/*      */     }
/* 1339 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1341 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1343 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1346 */         this.operator = null;
/*      */     }
/* 1348 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1350 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1352 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1355 */         this.makeDate = null;
/*      */     }
/* 1357 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1359 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1361 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1364 */         this.makeTime = null;
/*      */     }
/* 1366 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1368 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1370 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1373 */         this.modifyDate = null;
/*      */     }
/* 1375 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1377 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1379 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1382 */         this.modifyTime = null;
/*      */     }
/* 1384 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1389 */     if (otherObject == null) return false;
/* 1390 */     if (this == otherObject) return true;
/* 1391 */     if (getClass() != otherObject.getClass()) return false;
/* 1392 */     LNPIndUWMasterSchema other = (LNPIndUWMasterSchema)otherObject;
/* 1393 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/* 1394 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/* 1395 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/* 1396 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/* 1397 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/* 1398 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/* 1399 */     if (this.uWNo != other.getUWNo()) return false;
/* 1400 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1401 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1402 */     if ((this.insuredId == null) && (other.getInsuredId() != null)) return false;
/* 1403 */     if ((this.insuredId != null) && (!this.insuredId.equals(other.getInsuredId()))) return false;
/* 1404 */     if ((this.insuredNo == null) && (other.getInsuredNo() != null)) return false;
/* 1405 */     if ((this.insuredNo != null) && (!this.insuredNo.equals(other.getInsuredNo()))) return false;
/* 1406 */     if ((this.insuredName == null) && (other.getInsuredName() != null)) return false;
/* 1407 */     if ((this.insuredName != null) && (!this.insuredName.equals(other.getInsuredName()))) return false;
/* 1408 */     if ((this.flagCaseDcl == null) && (other.getFlagCaseDcl() != null)) return false;
/* 1409 */     if ((this.flagCaseDcl != null) && (!this.flagCaseDcl.equals(other.getFlagCaseDcl()))) return false;
/* 1410 */     if ((this.highFaceAmount == null) && (other.getHighFaceAmount() != null)) return false;
/* 1411 */     if ((this.highFaceAmount != null) && (!this.highFaceAmount.equals(other.getHighFaceAmount()))) return false;
/* 1412 */     if ((this.uWMessages == null) && (other.getUWMessages() != null)) return false;
/* 1413 */     if ((this.uWMessages != null) && (!this.uWMessages.equals(other.getUWMessages()))) return false;
/* 1414 */     if ((this.appntId == null) && (other.getAppntId() != null)) return false;
/* 1415 */     if ((this.appntId != null) && (!this.appntId.equals(other.getAppntId()))) return false;
/* 1416 */     if ((this.appntNo == null) && (other.getAppntNo() != null)) return false;
/* 1417 */     if ((this.appntNo != null) && (!this.appntNo.equals(other.getAppntNo()))) return false;
/* 1418 */     if ((this.appntName == null) && (other.getAppntName() != null)) return false;
/* 1419 */     if ((this.appntName != null) && (!this.appntName.equals(other.getAppntName()))) return false;
/* 1420 */     if ((this.passFlag == null) && (other.getPassFlag() != null)) return false;
/* 1421 */     if ((this.passFlag != null) && (!this.passFlag.equals(other.getPassFlag()))) return false;
/* 1422 */     if ((this.uWIdea == null) && (other.getUWIdea() != null)) return false;
/* 1423 */     if ((this.uWIdea != null) && (!this.uWIdea.equals(other.getUWIdea()))) return false;
/* 1424 */     if ((this.uWGrade == null) && (other.getUWGrade() != null)) return false;
/* 1425 */     if ((this.uWGrade != null) && (!this.uWGrade.equals(other.getUWGrade()))) return false;
/* 1426 */     if ((this.appGrade == null) && (other.getAppGrade() != null)) return false;
/* 1427 */     if ((this.appGrade != null) && (!this.appGrade.equals(other.getAppGrade()))) return false;
/* 1428 */     if ((this.postponeDay == null) && (other.getPostponeDay() != null)) return false;
/* 1429 */     if ((this.postponeDay != null) && (!this.postponeDay.equals(other.getPostponeDay()))) return false;
/* 1430 */     if ((this.postponeDate == null) && (other.getPostponeDate() != null)) return false;
/* 1431 */     if ((this.postponeDate != null) && (!this.fDate.getString(this.postponeDate).equals(other.getPostponeDate()))) return false;
/* 1432 */     if ((this.autoUWFlag == null) && (other.getAutoUWFlag() != null)) return false;
/* 1433 */     if ((this.autoUWFlag != null) && (!this.autoUWFlag.equals(other.getAutoUWFlag()))) return false;
/* 1434 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1435 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1436 */     if ((this.upReportContent == null) && (other.getUpReportContent() != null)) return false;
/* 1437 */     if ((this.upReportContent != null) && (!this.upReportContent.equals(other.getUpReportContent()))) return false;
/* 1438 */     if ((this.healthFlag == null) && (other.getHealthFlag() != null)) return false;
/* 1439 */     if ((this.healthFlag != null) && (!this.healthFlag.equals(other.getHealthFlag()))) return false;
/* 1440 */     if ((this.quesFlag == null) && (other.getQuesFlag() != null)) return false;
/* 1441 */     if ((this.quesFlag != null) && (!this.quesFlag.equals(other.getQuesFlag()))) return false;
/* 1442 */     if ((this.specFlag == null) && (other.getSpecFlag() != null)) return false;
/* 1443 */     if ((this.specFlag != null) && (!this.specFlag.equals(other.getSpecFlag()))) return false;
/* 1444 */     if ((this.addPremFlag == null) && (other.getAddPremFlag() != null)) return false;
/* 1445 */     if ((this.addPremFlag != null) && (!this.addPremFlag.equals(other.getAddPremFlag()))) return false;
/* 1446 */     if ((this.addPremReason == null) && (other.getAddPremReason() != null)) return false;
/* 1447 */     if ((this.addPremReason != null) && (!this.addPremReason.equals(other.getAddPremReason()))) return false;
/* 1448 */     if ((this.reportFlag == null) && (other.getReportFlag() != null)) return false;
/* 1449 */     if ((this.reportFlag != null) && (!this.reportFlag.equals(other.getReportFlag()))) return false;
/* 1450 */     if ((this.specReason == null) && (other.getSpecReason() != null)) return false;
/* 1451 */     if ((this.specReason != null) && (!this.specReason.equals(other.getSpecReason()))) return false;
/* 1452 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1453 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1454 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1455 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1456 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1457 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1458 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1459 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1460 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1461 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1468 */     return 35;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1474 */     if (strFieldName.equals("grpContNo")) {
/* 1475 */       return 0;
/*      */     }
/* 1477 */     if (strFieldName.equals("contNo")) {
/* 1478 */       return 1;
/*      */     }
/* 1480 */     if (strFieldName.equals("proposalContNo")) {
/* 1481 */       return 2;
/*      */     }
/* 1483 */     if (strFieldName.equals("uWNo")) {
/* 1484 */       return 3;
/*      */     }
/* 1486 */     if (strFieldName.equals("manageCom")) {
/* 1487 */       return 4;
/*      */     }
/* 1489 */     if (strFieldName.equals("insuredId")) {
/* 1490 */       return 5;
/*      */     }
/* 1492 */     if (strFieldName.equals("insuredNo")) {
/* 1493 */       return 6;
/*      */     }
/* 1495 */     if (strFieldName.equals("insuredName")) {
/* 1496 */       return 7;
/*      */     }
/* 1498 */     if (strFieldName.equals("flagCaseDcl")) {
/* 1499 */       return 8;
/*      */     }
/* 1501 */     if (strFieldName.equals("highFaceAmount")) {
/* 1502 */       return 9;
/*      */     }
/* 1504 */     if (strFieldName.equals("uWMessages")) {
/* 1505 */       return 10;
/*      */     }
/* 1507 */     if (strFieldName.equals("appntId")) {
/* 1508 */       return 11;
/*      */     }
/* 1510 */     if (strFieldName.equals("appntNo")) {
/* 1511 */       return 12;
/*      */     }
/* 1513 */     if (strFieldName.equals("appntName")) {
/* 1514 */       return 13;
/*      */     }
/* 1516 */     if (strFieldName.equals("passFlag")) {
/* 1517 */       return 14;
/*      */     }
/* 1519 */     if (strFieldName.equals("uWIdea")) {
/* 1520 */       return 15;
/*      */     }
/* 1522 */     if (strFieldName.equals("uWGrade")) {
/* 1523 */       return 16;
/*      */     }
/* 1525 */     if (strFieldName.equals("appGrade")) {
/* 1526 */       return 17;
/*      */     }
/* 1528 */     if (strFieldName.equals("postponeDay")) {
/* 1529 */       return 18;
/*      */     }
/* 1531 */     if (strFieldName.equals("postponeDate")) {
/* 1532 */       return 19;
/*      */     }
/* 1534 */     if (strFieldName.equals("autoUWFlag")) {
/* 1535 */       return 20;
/*      */     }
/* 1537 */     if (strFieldName.equals("state")) {
/* 1538 */       return 21;
/*      */     }
/* 1540 */     if (strFieldName.equals("upReportContent")) {
/* 1541 */       return 22;
/*      */     }
/* 1543 */     if (strFieldName.equals("healthFlag")) {
/* 1544 */       return 23;
/*      */     }
/* 1546 */     if (strFieldName.equals("quesFlag")) {
/* 1547 */       return 24;
/*      */     }
/* 1549 */     if (strFieldName.equals("specFlag")) {
/* 1550 */       return 25;
/*      */     }
/* 1552 */     if (strFieldName.equals("addPremFlag")) {
/* 1553 */       return 26;
/*      */     }
/* 1555 */     if (strFieldName.equals("addPremReason")) {
/* 1556 */       return 27;
/*      */     }
/* 1558 */     if (strFieldName.equals("reportFlag")) {
/* 1559 */       return 28;
/*      */     }
/* 1561 */     if (strFieldName.equals("specReason")) {
/* 1562 */       return 29;
/*      */     }
/* 1564 */     if (strFieldName.equals("operator")) {
/* 1565 */       return 30;
/*      */     }
/* 1567 */     if (strFieldName.equals("makeDate")) {
/* 1568 */       return 31;
/*      */     }
/* 1570 */     if (strFieldName.equals("makeTime")) {
/* 1571 */       return 32;
/*      */     }
/* 1573 */     if (strFieldName.equals("modifyDate")) {
/* 1574 */       return 33;
/*      */     }
/* 1576 */     if (strFieldName.equals("modifyTime")) {
/* 1577 */       return 34;
/*      */     }
/* 1579 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1585 */     String strFieldName = "";
/* 1586 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1588 */       strFieldName = "grpContNo";
/* 1589 */       break;
/*      */     case 1:
/* 1591 */       strFieldName = "contNo";
/* 1592 */       break;
/*      */     case 2:
/* 1594 */       strFieldName = "proposalContNo";
/* 1595 */       break;
/*      */     case 3:
/* 1597 */       strFieldName = "uWNo";
/* 1598 */       break;
/*      */     case 4:
/* 1600 */       strFieldName = "manageCom";
/* 1601 */       break;
/*      */     case 5:
/* 1603 */       strFieldName = "insuredId";
/* 1604 */       break;
/*      */     case 6:
/* 1606 */       strFieldName = "insuredNo";
/* 1607 */       break;
/*      */     case 7:
/* 1609 */       strFieldName = "insuredName";
/* 1610 */       break;
/*      */     case 8:
/* 1612 */       strFieldName = "flagCaseDcl";
/* 1613 */       break;
/*      */     case 9:
/* 1615 */       strFieldName = "highFaceAmount";
/* 1616 */       break;
/*      */     case 10:
/* 1618 */       strFieldName = "uWMessages";
/* 1619 */       break;
/*      */     case 11:
/* 1621 */       strFieldName = "appntId";
/* 1622 */       break;
/*      */     case 12:
/* 1624 */       strFieldName = "appntNo";
/* 1625 */       break;
/*      */     case 13:
/* 1627 */       strFieldName = "appntName";
/* 1628 */       break;
/*      */     case 14:
/* 1630 */       strFieldName = "passFlag";
/* 1631 */       break;
/*      */     case 15:
/* 1633 */       strFieldName = "uWIdea";
/* 1634 */       break;
/*      */     case 16:
/* 1636 */       strFieldName = "uWGrade";
/* 1637 */       break;
/*      */     case 17:
/* 1639 */       strFieldName = "appGrade";
/* 1640 */       break;
/*      */     case 18:
/* 1642 */       strFieldName = "postponeDay";
/* 1643 */       break;
/*      */     case 19:
/* 1645 */       strFieldName = "postponeDate";
/* 1646 */       break;
/*      */     case 20:
/* 1648 */       strFieldName = "autoUWFlag";
/* 1649 */       break;
/*      */     case 21:
/* 1651 */       strFieldName = "state";
/* 1652 */       break;
/*      */     case 22:
/* 1654 */       strFieldName = "upReportContent";
/* 1655 */       break;
/*      */     case 23:
/* 1657 */       strFieldName = "healthFlag";
/* 1658 */       break;
/*      */     case 24:
/* 1660 */       strFieldName = "quesFlag";
/* 1661 */       break;
/*      */     case 25:
/* 1663 */       strFieldName = "specFlag";
/* 1664 */       break;
/*      */     case 26:
/* 1666 */       strFieldName = "addPremFlag";
/* 1667 */       break;
/*      */     case 27:
/* 1669 */       strFieldName = "addPremReason";
/* 1670 */       break;
/*      */     case 28:
/* 1672 */       strFieldName = "reportFlag";
/* 1673 */       break;
/*      */     case 29:
/* 1675 */       strFieldName = "specReason";
/* 1676 */       break;
/*      */     case 30:
/* 1678 */       strFieldName = "operator";
/* 1679 */       break;
/*      */     case 31:
/* 1681 */       strFieldName = "makeDate";
/* 1682 */       break;
/*      */     case 32:
/* 1684 */       strFieldName = "makeTime";
/* 1685 */       break;
/*      */     case 33:
/* 1687 */       strFieldName = "modifyDate";
/* 1688 */       break;
/*      */     case 34:
/* 1690 */       strFieldName = "modifyTime";
/* 1691 */       break;
/*      */     default:
/* 1693 */       strFieldName = "";
/*      */     }
/* 1695 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1701 */     if (strFieldName.equals("grpContNo")) {
/* 1702 */       return 0;
/*      */     }
/* 1704 */     if (strFieldName.equals("contNo")) {
/* 1705 */       return 0;
/*      */     }
/* 1707 */     if (strFieldName.equals("proposalContNo")) {
/* 1708 */       return 0;
/*      */     }
/* 1710 */     if (strFieldName.equals("uWNo")) {
/* 1711 */       return 3;
/*      */     }
/* 1713 */     if (strFieldName.equals("manageCom")) {
/* 1714 */       return 0;
/*      */     }
/* 1716 */     if (strFieldName.equals("insuredId")) {
/* 1717 */       return 0;
/*      */     }
/* 1719 */     if (strFieldName.equals("insuredNo")) {
/* 1720 */       return 0;
/*      */     }
/* 1722 */     if (strFieldName.equals("insuredName")) {
/* 1723 */       return 0;
/*      */     }
/* 1725 */     if (strFieldName.equals("flagCaseDcl")) {
/* 1726 */       return 0;
/*      */     }
/* 1728 */     if (strFieldName.equals("highFaceAmount")) {
/* 1729 */       return 0;
/*      */     }
/* 1731 */     if (strFieldName.equals("uWMessages")) {
/* 1732 */       return 0;
/*      */     }
/* 1734 */     if (strFieldName.equals("appntId")) {
/* 1735 */       return 0;
/*      */     }
/* 1737 */     if (strFieldName.equals("appntNo")) {
/* 1738 */       return 0;
/*      */     }
/* 1740 */     if (strFieldName.equals("appntName")) {
/* 1741 */       return 0;
/*      */     }
/* 1743 */     if (strFieldName.equals("passFlag")) {
/* 1744 */       return 0;
/*      */     }
/* 1746 */     if (strFieldName.equals("uWIdea")) {
/* 1747 */       return 0;
/*      */     }
/* 1749 */     if (strFieldName.equals("uWGrade")) {
/* 1750 */       return 0;
/*      */     }
/* 1752 */     if (strFieldName.equals("appGrade")) {
/* 1753 */       return 0;
/*      */     }
/* 1755 */     if (strFieldName.equals("postponeDay")) {
/* 1756 */       return 0;
/*      */     }
/* 1758 */     if (strFieldName.equals("postponeDate")) {
/* 1759 */       return 1;
/*      */     }
/* 1761 */     if (strFieldName.equals("autoUWFlag")) {
/* 1762 */       return 0;
/*      */     }
/* 1764 */     if (strFieldName.equals("state")) {
/* 1765 */       return 0;
/*      */     }
/* 1767 */     if (strFieldName.equals("upReportContent")) {
/* 1768 */       return 0;
/*      */     }
/* 1770 */     if (strFieldName.equals("healthFlag")) {
/* 1771 */       return 0;
/*      */     }
/* 1773 */     if (strFieldName.equals("quesFlag")) {
/* 1774 */       return 0;
/*      */     }
/* 1776 */     if (strFieldName.equals("specFlag")) {
/* 1777 */       return 0;
/*      */     }
/* 1779 */     if (strFieldName.equals("addPremFlag")) {
/* 1780 */       return 0;
/*      */     }
/* 1782 */     if (strFieldName.equals("addPremReason")) {
/* 1783 */       return 0;
/*      */     }
/* 1785 */     if (strFieldName.equals("reportFlag")) {
/* 1786 */       return 0;
/*      */     }
/* 1788 */     if (strFieldName.equals("specReason")) {
/* 1789 */       return 0;
/*      */     }
/* 1791 */     if (strFieldName.equals("operator")) {
/* 1792 */       return 0;
/*      */     }
/* 1794 */     if (strFieldName.equals("makeDate")) {
/* 1795 */       return 1;
/*      */     }
/* 1797 */     if (strFieldName.equals("makeTime")) {
/* 1798 */       return 0;
/*      */     }
/* 1800 */     if (strFieldName.equals("modifyDate")) {
/* 1801 */       return 1;
/*      */     }
/* 1803 */     if (strFieldName.equals("modifyTime")) {
/* 1804 */       return 0;
/*      */     }
/* 1806 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1812 */     int nFieldType = -1;
/* 1813 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1815 */       nFieldType = 0;
/* 1816 */       break;
/*      */     case 1:
/* 1818 */       nFieldType = 0;
/* 1819 */       break;
/*      */     case 2:
/* 1821 */       nFieldType = 0;
/* 1822 */       break;
/*      */     case 3:
/* 1824 */       nFieldType = 3;
/* 1825 */       break;
/*      */     case 4:
/* 1827 */       nFieldType = 0;
/* 1828 */       break;
/*      */     case 5:
/* 1830 */       nFieldType = 0;
/* 1831 */       break;
/*      */     case 6:
/* 1833 */       nFieldType = 0;
/* 1834 */       break;
/*      */     case 7:
/* 1836 */       nFieldType = 0;
/* 1837 */       break;
/*      */     case 8:
/* 1839 */       nFieldType = 0;
/* 1840 */       break;
/*      */     case 9:
/* 1842 */       nFieldType = 0;
/* 1843 */       break;
/*      */     case 10:
/* 1845 */       nFieldType = 0;
/* 1846 */       break;
/*      */     case 11:
/* 1848 */       nFieldType = 0;
/* 1849 */       break;
/*      */     case 12:
/* 1851 */       nFieldType = 0;
/* 1852 */       break;
/*      */     case 13:
/* 1854 */       nFieldType = 0;
/* 1855 */       break;
/*      */     case 14:
/* 1857 */       nFieldType = 0;
/* 1858 */       break;
/*      */     case 15:
/* 1860 */       nFieldType = 0;
/* 1861 */       break;
/*      */     case 16:
/* 1863 */       nFieldType = 0;
/* 1864 */       break;
/*      */     case 17:
/* 1866 */       nFieldType = 0;
/* 1867 */       break;
/*      */     case 18:
/* 1869 */       nFieldType = 0;
/* 1870 */       break;
/*      */     case 19:
/* 1872 */       nFieldType = 1;
/* 1873 */       break;
/*      */     case 20:
/* 1875 */       nFieldType = 0;
/* 1876 */       break;
/*      */     case 21:
/* 1878 */       nFieldType = 0;
/* 1879 */       break;
/*      */     case 22:
/* 1881 */       nFieldType = 0;
/* 1882 */       break;
/*      */     case 23:
/* 1884 */       nFieldType = 0;
/* 1885 */       break;
/*      */     case 24:
/* 1887 */       nFieldType = 0;
/* 1888 */       break;
/*      */     case 25:
/* 1890 */       nFieldType = 0;
/* 1891 */       break;
/*      */     case 26:
/* 1893 */       nFieldType = 0;
/* 1894 */       break;
/*      */     case 27:
/* 1896 */       nFieldType = 0;
/* 1897 */       break;
/*      */     case 28:
/* 1899 */       nFieldType = 0;
/* 1900 */       break;
/*      */     case 29:
/* 1902 */       nFieldType = 0;
/* 1903 */       break;
/*      */     case 30:
/* 1905 */       nFieldType = 0;
/* 1906 */       break;
/*      */     case 31:
/* 1908 */       nFieldType = 1;
/* 1909 */       break;
/*      */     case 32:
/* 1911 */       nFieldType = 0;
/* 1912 */       break;
/*      */     case 33:
/* 1914 */       nFieldType = 1;
/* 1915 */       break;
/*      */     case 34:
/* 1917 */       nFieldType = 0;
/* 1918 */       break;
/*      */     default:
/* 1920 */       nFieldType = -1;
/*      */     }
/* 1922 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPIndUWMasterSchema
 * JD-Core Version:    0.6.0
 */