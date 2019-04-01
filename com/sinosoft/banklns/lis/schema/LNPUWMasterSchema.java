/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPUWMasterDB;
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
/*      */ public class LNPUWMasterSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String polNo;
/*      */   private String proposalNo;
/*      */   private int uWNo;
/*      */   private String insuredNo;
/*      */   private String insuredName;
/*      */   private String appntNo;
/*      */   private String appntName;
/*      */   private String planCode;
/*      */   private String planName;
/*      */   private String riderName;
/*      */   private String riderCode;
/*      */   private String uWDid;
/*      */   private String faceAmount;
/*      */   private String term;
/*      */   private String healthDeb;
/*      */   private String healthFe;
/*      */   private String healthFed;
/*      */   private String occupationFactor;
/*      */   private String occupationFe;
/*      */   private String occupationFed;
/*      */   private String exclusions;
/*      */   private String declinedCode;
/*      */   private String declinedReason;
/*      */   private String passFlag;
/*      */   private String uWIdea;
/*      */   private String uWGrade;
/*      */   private String appGrade;
/*      */   private String postponeDay;
/*      */   private Date postponeDate;
/*      */   private String autoUWFlag;
/*      */   private String state;
/*      */   private String manageCom;
/*      */   private String upReportContent;
/*      */   private String operator;
/*      */   private String healthFlag;
/*      */   private String quesFlag;
/*      */   private String specFlag;
/*      */   private String addPremFlag;
/*      */   private String addPremReason;
/*      */   private String reportFlag;
/*      */   private String printFlag;
/*      */   private String printFlag2;
/*      */   private String changePolFlag;
/*      */   private String changePolReason;
/*      */   private String specReason;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String sugPassFlag;
/*      */   private String sugUWIdea;
/*      */   public static final int FIELDNUM = 54;
/*      */   private static String[] PK;
/*  133 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPUWMasterSchema()
/*      */   {
/*  140 */     this.mErrors = new CErrors();
/*      */ 
/*  142 */     String[] pk = new String[1];
/*  143 */     pk[0] = "PolNo";
/*      */ 
/*  145 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  152 */     LNPUWMasterSchema cloned = (LNPUWMasterSchema)super.clone();
/*  153 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  154 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  155 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  161 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo()
/*      */   {
/*  166 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  170 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  174 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  178 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  182 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  186 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public String getPolNo() {
/*  190 */     return this.polNo;
/*      */   }
/*      */ 
/*      */   public void setPolNo(String aPolNo) {
/*  194 */     this.polNo = aPolNo;
/*      */   }
/*      */ 
/*      */   public String getProposalNo() {
/*  198 */     return this.proposalNo;
/*      */   }
/*      */ 
/*      */   public void setProposalNo(String aProposalNo) {
/*  202 */     this.proposalNo = aProposalNo;
/*      */   }
/*      */ 
/*      */   public int getUWNo() {
/*  206 */     return this.uWNo;
/*      */   }
/*      */ 
/*      */   public void setUWNo(int aUWNo) {
/*  210 */     this.uWNo = aUWNo;
/*      */   }
/*      */ 
/*      */   public void setUWNo(String aUWNo) {
/*  214 */     if ((aUWNo != null) && (!aUWNo.equals("")))
/*      */     {
/*  216 */       Integer tInteger = new Integer(aUWNo);
/*  217 */       int i = tInteger.intValue();
/*  218 */       this.uWNo = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getInsuredNo()
/*      */   {
/*  224 */     return this.insuredNo;
/*      */   }
/*      */ 
/*      */   public void setInsuredNo(String aInsuredNo) {
/*  228 */     this.insuredNo = aInsuredNo;
/*      */   }
/*      */ 
/*      */   public String getInsuredName() {
/*  232 */     return this.insuredName;
/*      */   }
/*      */ 
/*      */   public void setInsuredName(String aInsuredName) {
/*  236 */     this.insuredName = aInsuredName;
/*      */   }
/*      */ 
/*      */   public String getAppntNo() {
/*  240 */     return this.appntNo;
/*      */   }
/*      */ 
/*      */   public void setAppntNo(String aAppntNo) {
/*  244 */     this.appntNo = aAppntNo;
/*      */   }
/*      */ 
/*      */   public String getAppntName() {
/*  248 */     return this.appntName;
/*      */   }
/*      */ 
/*      */   public void setAppntName(String aAppntName) {
/*  252 */     this.appntName = aAppntName;
/*      */   }
/*      */ 
/*      */   public String getPlanCode() {
/*  256 */     return this.planCode;
/*      */   }
/*      */ 
/*      */   public void setPlanCode(String aPlanCode) {
/*  260 */     this.planCode = aPlanCode;
/*      */   }
/*      */ 
/*      */   public String getPlanName() {
/*  264 */     return this.planName;
/*      */   }
/*      */ 
/*      */   public void setPlanName(String aPlanName) {
/*  268 */     this.planName = aPlanName;
/*      */   }
/*      */ 
/*      */   public String getRiderName() {
/*  272 */     return this.riderName;
/*      */   }
/*      */ 
/*      */   public void setRiderName(String aRiderName) {
/*  276 */     this.riderName = aRiderName;
/*      */   }
/*      */ 
/*      */   public String getRiderCode() {
/*  280 */     return this.riderCode;
/*      */   }
/*      */ 
/*      */   public void setRiderCode(String aRiderCode) {
/*  284 */     this.riderCode = aRiderCode;
/*      */   }
/*      */ 
/*      */   public String getUWDid() {
/*  288 */     return this.uWDid;
/*      */   }
/*      */ 
/*      */   public void setUWDid(String aUWDid) {
/*  292 */     this.uWDid = aUWDid;
/*      */   }
/*      */ 
/*      */   public String getFaceAmount() {
/*  296 */     return this.faceAmount;
/*      */   }
/*      */ 
/*      */   public void setFaceAmount(String aFaceAmount) {
/*  300 */     this.faceAmount = aFaceAmount;
/*      */   }
/*      */ 
/*      */   public String getTerm() {
/*  304 */     return this.term;
/*      */   }
/*      */ 
/*      */   public void setTerm(String aTerm) {
/*  308 */     this.term = aTerm;
/*      */   }
/*      */ 
/*      */   public String getHealthDeb() {
/*  312 */     return this.healthDeb;
/*      */   }
/*      */ 
/*      */   public void setHealthDeb(String aHealthDeb) {
/*  316 */     this.healthDeb = aHealthDeb;
/*      */   }
/*      */ 
/*      */   public String getHealthFe() {
/*  320 */     return this.healthFe;
/*      */   }
/*      */ 
/*      */   public void setHealthFe(String aHealthFe) {
/*  324 */     this.healthFe = aHealthFe;
/*      */   }
/*      */ 
/*      */   public String getHealthFed() {
/*  328 */     return this.healthFed;
/*      */   }
/*      */ 
/*      */   public void setHealthFed(String aHealthFed) {
/*  332 */     this.healthFed = aHealthFed;
/*      */   }
/*      */ 
/*      */   public String getOccupationFactor() {
/*  336 */     return this.occupationFactor;
/*      */   }
/*      */ 
/*      */   public void setOccupationFactor(String aOccupationFactor) {
/*  340 */     this.occupationFactor = aOccupationFactor;
/*      */   }
/*      */ 
/*      */   public String getOccupationFe() {
/*  344 */     return this.occupationFe;
/*      */   }
/*      */ 
/*      */   public void setOccupationFe(String aOccupationFe) {
/*  348 */     this.occupationFe = aOccupationFe;
/*      */   }
/*      */ 
/*      */   public String getOccupationFed() {
/*  352 */     return this.occupationFed;
/*      */   }
/*      */ 
/*      */   public void setOccupationFed(String aOccupationFed) {
/*  356 */     this.occupationFed = aOccupationFed;
/*      */   }
/*      */ 
/*      */   public String getExclusions() {
/*  360 */     return this.exclusions;
/*      */   }
/*      */ 
/*      */   public void setExclusions(String aExclusions) {
/*  364 */     this.exclusions = aExclusions;
/*      */   }
/*      */ 
/*      */   public String getDeclinedCode() {
/*  368 */     return this.declinedCode;
/*      */   }
/*      */ 
/*      */   public void setDeclinedCode(String aDeclinedCode) {
/*  372 */     this.declinedCode = aDeclinedCode;
/*      */   }
/*      */ 
/*      */   public String getDeclinedReason() {
/*  376 */     return this.declinedReason;
/*      */   }
/*      */ 
/*      */   public void setDeclinedReason(String aDeclinedReason) {
/*  380 */     this.declinedReason = aDeclinedReason;
/*      */   }
/*      */ 
/*      */   public String getPassFlag() {
/*  384 */     return this.passFlag;
/*      */   }
/*      */ 
/*      */   public void setPassFlag(String aPassFlag) {
/*  388 */     this.passFlag = aPassFlag;
/*      */   }
/*      */ 
/*      */   public String getUWIdea() {
/*  392 */     return this.uWIdea;
/*      */   }
/*      */ 
/*      */   public void setUWIdea(String aUWIdea) {
/*  396 */     this.uWIdea = aUWIdea;
/*      */   }
/*      */ 
/*      */   public String getUWGrade() {
/*  400 */     return this.uWGrade;
/*      */   }
/*      */ 
/*      */   public void setUWGrade(String aUWGrade) {
/*  404 */     this.uWGrade = aUWGrade;
/*      */   }
/*      */ 
/*      */   public String getAppGrade() {
/*  408 */     return this.appGrade;
/*      */   }
/*      */ 
/*      */   public void setAppGrade(String aAppGrade) {
/*  412 */     this.appGrade = aAppGrade;
/*      */   }
/*      */ 
/*      */   public String getPostponeDay() {
/*  416 */     return this.postponeDay;
/*      */   }
/*      */ 
/*      */   public void setPostponeDay(String aPostponeDay) {
/*  420 */     this.postponeDay = aPostponeDay;
/*      */   }
/*      */ 
/*      */   public String getPostponeDate() {
/*  424 */     if (this.postponeDate != null) {
/*  425 */       return this.fDate.getString(this.postponeDate);
/*      */     }
/*  427 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPostponeDate(Date aPostponeDate) {
/*  431 */     this.postponeDate = aPostponeDate;
/*      */   }
/*      */ 
/*      */   public void setPostponeDate(String aPostponeDate) {
/*  435 */     if ((aPostponeDate != null) && (!aPostponeDate.equals("")))
/*      */     {
/*  437 */       this.postponeDate = this.fDate.getDate(aPostponeDate);
/*      */     }
/*      */     else
/*  440 */       this.postponeDate = null;
/*      */   }
/*      */ 
/*      */   public String getAutoUWFlag()
/*      */   {
/*  445 */     return this.autoUWFlag;
/*      */   }
/*      */ 
/*      */   public void setAutoUWFlag(String aAutoUWFlag) {
/*  449 */     this.autoUWFlag = aAutoUWFlag;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  453 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  457 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  461 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  465 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getUpReportContent() {
/*  469 */     return this.upReportContent;
/*      */   }
/*      */ 
/*      */   public void setUpReportContent(String aUpReportContent) {
/*  473 */     this.upReportContent = aUpReportContent;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  477 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  481 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getHealthFlag() {
/*  485 */     return this.healthFlag;
/*      */   }
/*      */ 
/*      */   public void setHealthFlag(String aHealthFlag) {
/*  489 */     this.healthFlag = aHealthFlag;
/*      */   }
/*      */ 
/*      */   public String getQuesFlag() {
/*  493 */     return this.quesFlag;
/*      */   }
/*      */ 
/*      */   public void setQuesFlag(String aQuesFlag) {
/*  497 */     this.quesFlag = aQuesFlag;
/*      */   }
/*      */ 
/*      */   public String getSpecFlag() {
/*  501 */     return this.specFlag;
/*      */   }
/*      */ 
/*      */   public void setSpecFlag(String aSpecFlag) {
/*  505 */     this.specFlag = aSpecFlag;
/*      */   }
/*      */ 
/*      */   public String getAddPremFlag() {
/*  509 */     return this.addPremFlag;
/*      */   }
/*      */ 
/*      */   public void setAddPremFlag(String aAddPremFlag) {
/*  513 */     this.addPremFlag = aAddPremFlag;
/*      */   }
/*      */ 
/*      */   public String getAddPremReason() {
/*  517 */     return this.addPremReason;
/*      */   }
/*      */ 
/*      */   public void setAddPremReason(String aAddPremReason) {
/*  521 */     this.addPremReason = aAddPremReason;
/*      */   }
/*      */ 
/*      */   public String getReportFlag() {
/*  525 */     return this.reportFlag;
/*      */   }
/*      */ 
/*      */   public void setReportFlag(String aReportFlag) {
/*  529 */     this.reportFlag = aReportFlag;
/*      */   }
/*      */ 
/*      */   public String getPrintFlag() {
/*  533 */     return this.printFlag;
/*      */   }
/*      */ 
/*      */   public void setPrintFlag(String aPrintFlag) {
/*  537 */     this.printFlag = aPrintFlag;
/*      */   }
/*      */ 
/*      */   public String getPrintFlag2() {
/*  541 */     return this.printFlag2;
/*      */   }
/*      */ 
/*      */   public void setPrintFlag2(String aPrintFlag2) {
/*  545 */     this.printFlag2 = aPrintFlag2;
/*      */   }
/*      */ 
/*      */   public String getChangePolFlag() {
/*  549 */     return this.changePolFlag;
/*      */   }
/*      */ 
/*      */   public void setChangePolFlag(String aChangePolFlag) {
/*  553 */     this.changePolFlag = aChangePolFlag;
/*      */   }
/*      */ 
/*      */   public String getChangePolReason() {
/*  557 */     return this.changePolReason;
/*      */   }
/*      */ 
/*      */   public void setChangePolReason(String aChangePolReason) {
/*  561 */     this.changePolReason = aChangePolReason;
/*      */   }
/*      */ 
/*      */   public String getSpecReason() {
/*  565 */     return this.specReason;
/*      */   }
/*      */ 
/*      */   public void setSpecReason(String aSpecReason) {
/*  569 */     this.specReason = aSpecReason;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  573 */     if (this.makeDate != null) {
/*  574 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  576 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  580 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  584 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  586 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  589 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  594 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  598 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  602 */     if (this.modifyDate != null) {
/*  603 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  605 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  609 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  613 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  615 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  618 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  623 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  627 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getSugPassFlag() {
/*  631 */     return this.sugPassFlag;
/*      */   }
/*      */ 
/*      */   public void setSugPassFlag(String aSugPassFlag) {
/*  635 */     this.sugPassFlag = aSugPassFlag;
/*      */   }
/*      */ 
/*      */   public String getSugUWIdea() {
/*  639 */     return this.sugUWIdea;
/*      */   }
/*      */ 
/*      */   public void setSugUWIdea(String aSugUWIdea) {
/*  643 */     this.sugUWIdea = aSugUWIdea;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPUWMasterSchema aLNPUWMasterSchema)
/*      */   {
/*  649 */     this.grpContNo = aLNPUWMasterSchema.getGrpContNo();
/*  650 */     this.contNo = aLNPUWMasterSchema.getContNo();
/*  651 */     this.proposalContNo = aLNPUWMasterSchema.getProposalContNo();
/*  652 */     this.polNo = aLNPUWMasterSchema.getPolNo();
/*  653 */     this.proposalNo = aLNPUWMasterSchema.getProposalNo();
/*  654 */     this.uWNo = aLNPUWMasterSchema.getUWNo();
/*  655 */     this.insuredNo = aLNPUWMasterSchema.getInsuredNo();
/*  656 */     this.insuredName = aLNPUWMasterSchema.getInsuredName();
/*  657 */     this.appntNo = aLNPUWMasterSchema.getAppntNo();
/*  658 */     this.appntName = aLNPUWMasterSchema.getAppntName();
/*  659 */     this.planCode = aLNPUWMasterSchema.getPlanCode();
/*  660 */     this.planName = aLNPUWMasterSchema.getPlanName();
/*  661 */     this.riderName = aLNPUWMasterSchema.getRiderName();
/*  662 */     this.riderCode = aLNPUWMasterSchema.getRiderCode();
/*  663 */     this.uWDid = aLNPUWMasterSchema.getUWDid();
/*  664 */     this.faceAmount = aLNPUWMasterSchema.getFaceAmount();
/*  665 */     this.term = aLNPUWMasterSchema.getTerm();
/*  666 */     this.healthDeb = aLNPUWMasterSchema.getHealthDeb();
/*  667 */     this.healthFe = aLNPUWMasterSchema.getHealthFe();
/*  668 */     this.healthFed = aLNPUWMasterSchema.getHealthFed();
/*  669 */     this.occupationFactor = aLNPUWMasterSchema.getOccupationFactor();
/*  670 */     this.occupationFe = aLNPUWMasterSchema.getOccupationFe();
/*  671 */     this.occupationFed = aLNPUWMasterSchema.getOccupationFed();
/*  672 */     this.exclusions = aLNPUWMasterSchema.getExclusions();
/*  673 */     this.declinedCode = aLNPUWMasterSchema.getDeclinedCode();
/*  674 */     this.declinedReason = aLNPUWMasterSchema.getDeclinedReason();
/*  675 */     this.passFlag = aLNPUWMasterSchema.getPassFlag();
/*  676 */     this.uWIdea = aLNPUWMasterSchema.getUWIdea();
/*  677 */     this.uWGrade = aLNPUWMasterSchema.getUWGrade();
/*  678 */     this.appGrade = aLNPUWMasterSchema.getAppGrade();
/*  679 */     this.postponeDay = aLNPUWMasterSchema.getPostponeDay();
/*  680 */     this.postponeDate = this.fDate.getDate(aLNPUWMasterSchema.getPostponeDate());
/*  681 */     this.autoUWFlag = aLNPUWMasterSchema.getAutoUWFlag();
/*  682 */     this.state = aLNPUWMasterSchema.getState();
/*  683 */     this.manageCom = aLNPUWMasterSchema.getManageCom();
/*  684 */     this.upReportContent = aLNPUWMasterSchema.getUpReportContent();
/*  685 */     this.operator = aLNPUWMasterSchema.getOperator();
/*  686 */     this.healthFlag = aLNPUWMasterSchema.getHealthFlag();
/*  687 */     this.quesFlag = aLNPUWMasterSchema.getQuesFlag();
/*  688 */     this.specFlag = aLNPUWMasterSchema.getSpecFlag();
/*  689 */     this.addPremFlag = aLNPUWMasterSchema.getAddPremFlag();
/*  690 */     this.addPremReason = aLNPUWMasterSchema.getAddPremReason();
/*  691 */     this.reportFlag = aLNPUWMasterSchema.getReportFlag();
/*  692 */     this.printFlag = aLNPUWMasterSchema.getPrintFlag();
/*  693 */     this.printFlag2 = aLNPUWMasterSchema.getPrintFlag2();
/*  694 */     this.changePolFlag = aLNPUWMasterSchema.getChangePolFlag();
/*  695 */     this.changePolReason = aLNPUWMasterSchema.getChangePolReason();
/*  696 */     this.specReason = aLNPUWMasterSchema.getSpecReason();
/*  697 */     this.makeDate = this.fDate.getDate(aLNPUWMasterSchema.getMakeDate());
/*  698 */     this.makeTime = aLNPUWMasterSchema.getMakeTime();
/*  699 */     this.modifyDate = this.fDate.getDate(aLNPUWMasterSchema.getModifyDate());
/*  700 */     this.modifyTime = aLNPUWMasterSchema.getModifyTime();
/*  701 */     this.sugPassFlag = aLNPUWMasterSchema.getSugPassFlag();
/*  702 */     this.sugUWIdea = aLNPUWMasterSchema.getSugUWIdea();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  711 */       if (rs.getString("GrpContNo") == null)
/*  712 */         this.grpContNo = null;
/*      */       else {
/*  714 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  716 */       if (rs.getString("ContNo") == null)
/*  717 */         this.contNo = null;
/*      */       else {
/*  719 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  721 */       if (rs.getString("ProposalContNo") == null)
/*  722 */         this.proposalContNo = null;
/*      */       else {
/*  724 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  726 */       if (rs.getString("PolNo") == null)
/*  727 */         this.polNo = null;
/*      */       else {
/*  729 */         this.polNo = rs.getString("PolNo").trim();
/*      */       }
/*  731 */       if (rs.getString("ProposalNo") == null)
/*  732 */         this.proposalNo = null;
/*      */       else {
/*  734 */         this.proposalNo = rs.getString("ProposalNo").trim();
/*      */       }
/*  736 */       this.uWNo = rs.getInt("UWNo");
/*  737 */       if (rs.getString("InsuredNo") == null)
/*  738 */         this.insuredNo = null;
/*      */       else {
/*  740 */         this.insuredNo = rs.getString("InsuredNo").trim();
/*      */       }
/*  742 */       if (rs.getString("InsuredName") == null)
/*  743 */         this.insuredName = null;
/*      */       else {
/*  745 */         this.insuredName = rs.getString("InsuredName").trim();
/*      */       }
/*  747 */       if (rs.getString("AppntNo") == null)
/*  748 */         this.appntNo = null;
/*      */       else {
/*  750 */         this.appntNo = rs.getString("AppntNo").trim();
/*      */       }
/*  752 */       if (rs.getString("AppntName") == null)
/*  753 */         this.appntName = null;
/*      */       else {
/*  755 */         this.appntName = rs.getString("AppntName").trim();
/*      */       }
/*  757 */       if (rs.getString("PlanCode") == null)
/*  758 */         this.planCode = null;
/*      */       else {
/*  760 */         this.planCode = rs.getString("PlanCode").trim();
/*      */       }
/*  762 */       if (rs.getString("PlanName") == null)
/*  763 */         this.planName = null;
/*      */       else {
/*  765 */         this.planName = rs.getString("PlanName").trim();
/*      */       }
/*  767 */       if (rs.getString("RiderName") == null)
/*  768 */         this.riderName = null;
/*      */       else {
/*  770 */         this.riderName = rs.getString("RiderName").trim();
/*      */       }
/*  772 */       if (rs.getString("RiderCode") == null)
/*  773 */         this.riderCode = null;
/*      */       else {
/*  775 */         this.riderCode = rs.getString("RiderCode").trim();
/*      */       }
/*  777 */       if (rs.getString("UWDid") == null)
/*  778 */         this.uWDid = null;
/*      */       else {
/*  780 */         this.uWDid = rs.getString("UWDid").trim();
/*      */       }
/*  782 */       if (rs.getString("FaceAmount") == null)
/*  783 */         this.faceAmount = null;
/*      */       else {
/*  785 */         this.faceAmount = rs.getString("FaceAmount").trim();
/*      */       }
/*  787 */       if (rs.getString("Term") == null)
/*  788 */         this.term = null;
/*      */       else {
/*  790 */         this.term = rs.getString("Term").trim();
/*      */       }
/*  792 */       if (rs.getString("HealthDeb") == null)
/*  793 */         this.healthDeb = null;
/*      */       else {
/*  795 */         this.healthDeb = rs.getString("HealthDeb").trim();
/*      */       }
/*  797 */       if (rs.getString("HealthFe") == null)
/*  798 */         this.healthFe = null;
/*      */       else {
/*  800 */         this.healthFe = rs.getString("HealthFe").trim();
/*      */       }
/*  802 */       if (rs.getString("HealthFed") == null)
/*  803 */         this.healthFed = null;
/*      */       else {
/*  805 */         this.healthFed = rs.getString("HealthFed").trim();
/*      */       }
/*  807 */       if (rs.getString("OccupationFactor") == null)
/*  808 */         this.occupationFactor = null;
/*      */       else {
/*  810 */         this.occupationFactor = rs.getString("OccupationFactor").trim();
/*      */       }
/*  812 */       if (rs.getString("OccupationFe") == null)
/*  813 */         this.occupationFe = null;
/*      */       else {
/*  815 */         this.occupationFe = rs.getString("OccupationFe").trim();
/*      */       }
/*  817 */       if (rs.getString("OccupationFed") == null)
/*  818 */         this.occupationFed = null;
/*      */       else {
/*  820 */         this.occupationFed = rs.getString("OccupationFed").trim();
/*      */       }
/*  822 */       if (rs.getString("Exclusions") == null)
/*  823 */         this.exclusions = null;
/*      */       else {
/*  825 */         this.exclusions = rs.getString("Exclusions").trim();
/*      */       }
/*  827 */       if (rs.getString("DeclinedCode") == null)
/*  828 */         this.declinedCode = null;
/*      */       else {
/*  830 */         this.declinedCode = rs.getString("DeclinedCode").trim();
/*      */       }
/*  832 */       if (rs.getString("DeclinedReason") == null)
/*  833 */         this.declinedReason = null;
/*      */       else {
/*  835 */         this.declinedReason = rs.getString("DeclinedReason").trim();
/*      */       }
/*  837 */       if (rs.getString("PassFlag") == null)
/*  838 */         this.passFlag = null;
/*      */       else {
/*  840 */         this.passFlag = rs.getString("PassFlag").trim();
/*      */       }
/*  842 */       if (rs.getString("UWIdea") == null)
/*  843 */         this.uWIdea = null;
/*      */       else {
/*  845 */         this.uWIdea = rs.getString("UWIdea").trim();
/*      */       }
/*  847 */       if (rs.getString("UWGrade") == null)
/*  848 */         this.uWGrade = null;
/*      */       else {
/*  850 */         this.uWGrade = rs.getString("UWGrade").trim();
/*      */       }
/*  852 */       if (rs.getString("AppGrade") == null)
/*  853 */         this.appGrade = null;
/*      */       else {
/*  855 */         this.appGrade = rs.getString("AppGrade").trim();
/*      */       }
/*  857 */       if (rs.getString("PostponeDay") == null)
/*  858 */         this.postponeDay = null;
/*      */       else {
/*  860 */         this.postponeDay = rs.getString("PostponeDay").trim();
/*      */       }
/*  862 */       this.postponeDate = rs.getDate("PostponeDate");
/*  863 */       if (rs.getString("AutoUWFlag") == null)
/*  864 */         this.autoUWFlag = null;
/*      */       else {
/*  866 */         this.autoUWFlag = rs.getString("AutoUWFlag").trim();
/*      */       }
/*  868 */       if (rs.getString("State") == null)
/*  869 */         this.state = null;
/*      */       else {
/*  871 */         this.state = rs.getString("State").trim();
/*      */       }
/*  873 */       if (rs.getString("ManageCom") == null)
/*  874 */         this.manageCom = null;
/*      */       else {
/*  876 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  878 */       if (rs.getString("UpReportContent") == null)
/*  879 */         this.upReportContent = null;
/*      */       else {
/*  881 */         this.upReportContent = rs.getString("UpReportContent").trim();
/*      */       }
/*  883 */       if (rs.getString("Operator") == null)
/*  884 */         this.operator = null;
/*      */       else {
/*  886 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  888 */       if (rs.getString("HealthFlag") == null)
/*  889 */         this.healthFlag = null;
/*      */       else {
/*  891 */         this.healthFlag = rs.getString("HealthFlag").trim();
/*      */       }
/*  893 */       if (rs.getString("QuesFlag") == null)
/*  894 */         this.quesFlag = null;
/*      */       else {
/*  896 */         this.quesFlag = rs.getString("QuesFlag").trim();
/*      */       }
/*  898 */       if (rs.getString("SpecFlag") == null)
/*  899 */         this.specFlag = null;
/*      */       else {
/*  901 */         this.specFlag = rs.getString("SpecFlag").trim();
/*      */       }
/*  903 */       if (rs.getString("AddPremFlag") == null)
/*  904 */         this.addPremFlag = null;
/*      */       else {
/*  906 */         this.addPremFlag = rs.getString("AddPremFlag").trim();
/*      */       }
/*  908 */       if (rs.getString("AddPremReason") == null)
/*  909 */         this.addPremReason = null;
/*      */       else {
/*  911 */         this.addPremReason = rs.getString("AddPremReason").trim();
/*      */       }
/*  913 */       if (rs.getString("ReportFlag") == null)
/*  914 */         this.reportFlag = null;
/*      */       else {
/*  916 */         this.reportFlag = rs.getString("ReportFlag").trim();
/*      */       }
/*  918 */       if (rs.getString("PrintFlag") == null)
/*  919 */         this.printFlag = null;
/*      */       else {
/*  921 */         this.printFlag = rs.getString("PrintFlag").trim();
/*      */       }
/*  923 */       if (rs.getString("PrintFlag2") == null)
/*  924 */         this.printFlag2 = null;
/*      */       else {
/*  926 */         this.printFlag2 = rs.getString("PrintFlag2").trim();
/*      */       }
/*  928 */       if (rs.getString("ChangePolFlag") == null)
/*  929 */         this.changePolFlag = null;
/*      */       else {
/*  931 */         this.changePolFlag = rs.getString("ChangePolFlag").trim();
/*      */       }
/*  933 */       if (rs.getString("ChangePolReason") == null)
/*  934 */         this.changePolReason = null;
/*      */       else {
/*  936 */         this.changePolReason = rs.getString("ChangePolReason").trim();
/*      */       }
/*  938 */       if (rs.getString("SpecReason") == null)
/*  939 */         this.specReason = null;
/*      */       else {
/*  941 */         this.specReason = rs.getString("SpecReason").trim();
/*      */       }
/*  943 */       this.makeDate = rs.getDate("MakeDate");
/*  944 */       if (rs.getString("MakeTime") == null)
/*  945 */         this.makeTime = null;
/*      */       else {
/*  947 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  949 */       this.modifyDate = rs.getDate("ModifyDate");
/*  950 */       if (rs.getString("ModifyTime") == null)
/*  951 */         this.modifyTime = null;
/*      */       else {
/*  953 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  955 */       if (rs.getString("SugPassFlag") == null)
/*  956 */         this.sugPassFlag = null;
/*      */       else {
/*  958 */         this.sugPassFlag = rs.getString("SugPassFlag").trim();
/*      */       }
/*  960 */       if (rs.getString("SugUWIdea") == null)
/*  961 */         this.sugUWIdea = null;
/*      */       else {
/*  963 */         this.sugUWIdea = rs.getString("SugUWIdea").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  968 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPUWMaster\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/*  970 */       CError tError = new CError();
/*  971 */       tError.moduleName = "LNPUWMasterSchema";
/*  972 */       tError.functionName = "setSchema";
/*  973 */       tError.errorMessage = sqle.toString();
/*  974 */       this.mErrors.addOneError(tError);
/*  975 */       return false;
/*      */     }
/*  977 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPUWMasterSchema getSchema()
/*      */   {
/*  982 */     LNPUWMasterSchema aLNPUWMasterSchema = new LNPUWMasterSchema();
/*  983 */     aLNPUWMasterSchema.setSchema(this);
/*  984 */     return aLNPUWMasterSchema;
/*      */   }
/*      */ 
/*      */   public LNPUWMasterDB getDB()
/*      */   {
/*  989 */     LNPUWMasterDB aDBOper = new LNPUWMasterDB();
/*  990 */     aDBOper.setSchema(this);
/*  991 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  998 */     StringBuffer strReturn = new StringBuffer(256);
/*  999 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/* 1000 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/* 1001 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/* 1002 */     strReturn.append(StrTool.cTrim(this.polNo)); strReturn.append("|");
/* 1003 */     strReturn.append(StrTool.cTrim(this.proposalNo)); strReturn.append("|");
/* 1004 */     strReturn.append(ChgData.chgData(this.uWNo)); strReturn.append("|");
/* 1005 */     strReturn.append(StrTool.cTrim(this.insuredNo)); strReturn.append("|");
/* 1006 */     strReturn.append(StrTool.cTrim(this.insuredName)); strReturn.append("|");
/* 1007 */     strReturn.append(StrTool.cTrim(this.appntNo)); strReturn.append("|");
/* 1008 */     strReturn.append(StrTool.cTrim(this.appntName)); strReturn.append("|");
/* 1009 */     strReturn.append(StrTool.cTrim(this.planCode)); strReturn.append("|");
/* 1010 */     strReturn.append(StrTool.cTrim(this.planName)); strReturn.append("|");
/* 1011 */     strReturn.append(StrTool.cTrim(this.riderName)); strReturn.append("|");
/* 1012 */     strReturn.append(StrTool.cTrim(this.riderCode)); strReturn.append("|");
/* 1013 */     strReturn.append(StrTool.cTrim(this.uWDid)); strReturn.append("|");
/* 1014 */     strReturn.append(StrTool.cTrim(this.faceAmount)); strReturn.append("|");
/* 1015 */     strReturn.append(StrTool.cTrim(this.term)); strReturn.append("|");
/* 1016 */     strReturn.append(StrTool.cTrim(this.healthDeb)); strReturn.append("|");
/* 1017 */     strReturn.append(StrTool.cTrim(this.healthFe)); strReturn.append("|");
/* 1018 */     strReturn.append(StrTool.cTrim(this.healthFed)); strReturn.append("|");
/* 1019 */     strReturn.append(StrTool.cTrim(this.occupationFactor)); strReturn.append("|");
/* 1020 */     strReturn.append(StrTool.cTrim(this.occupationFe)); strReturn.append("|");
/* 1021 */     strReturn.append(StrTool.cTrim(this.occupationFed)); strReturn.append("|");
/* 1022 */     strReturn.append(StrTool.cTrim(this.exclusions)); strReturn.append("|");
/* 1023 */     strReturn.append(StrTool.cTrim(this.declinedCode)); strReturn.append("|");
/* 1024 */     strReturn.append(StrTool.cTrim(this.declinedReason)); strReturn.append("|");
/* 1025 */     strReturn.append(StrTool.cTrim(this.passFlag)); strReturn.append("|");
/* 1026 */     strReturn.append(StrTool.cTrim(this.uWIdea)); strReturn.append("|");
/* 1027 */     strReturn.append(StrTool.cTrim(this.uWGrade)); strReturn.append("|");
/* 1028 */     strReturn.append(StrTool.cTrim(this.appGrade)); strReturn.append("|");
/* 1029 */     strReturn.append(StrTool.cTrim(this.postponeDay)); strReturn.append("|");
/* 1030 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.postponeDate))); strReturn.append("|");
/* 1031 */     strReturn.append(StrTool.cTrim(this.autoUWFlag)); strReturn.append("|");
/* 1032 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/* 1033 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/* 1034 */     strReturn.append(StrTool.cTrim(this.upReportContent)); strReturn.append("|");
/* 1035 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 1036 */     strReturn.append(StrTool.cTrim(this.healthFlag)); strReturn.append("|");
/* 1037 */     strReturn.append(StrTool.cTrim(this.quesFlag)); strReturn.append("|");
/* 1038 */     strReturn.append(StrTool.cTrim(this.specFlag)); strReturn.append("|");
/* 1039 */     strReturn.append(StrTool.cTrim(this.addPremFlag)); strReturn.append("|");
/* 1040 */     strReturn.append(StrTool.cTrim(this.addPremReason)); strReturn.append("|");
/* 1041 */     strReturn.append(StrTool.cTrim(this.reportFlag)); strReturn.append("|");
/* 1042 */     strReturn.append(StrTool.cTrim(this.printFlag)); strReturn.append("|");
/* 1043 */     strReturn.append(StrTool.cTrim(this.printFlag2)); strReturn.append("|");
/* 1044 */     strReturn.append(StrTool.cTrim(this.changePolFlag)); strReturn.append("|");
/* 1045 */     strReturn.append(StrTool.cTrim(this.changePolReason)); strReturn.append("|");
/* 1046 */     strReturn.append(StrTool.cTrim(this.specReason)); strReturn.append("|");
/* 1047 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 1048 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 1049 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 1050 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/* 1051 */     strReturn.append(StrTool.cTrim(this.sugPassFlag)); strReturn.append("|");
/* 1052 */     strReturn.append(StrTool.cTrim(this.sugUWIdea));
/* 1053 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1061 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1062 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1063 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1064 */       this.polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1065 */       this.proposalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1066 */       this.uWNo = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/* 1067 */       this.insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1068 */       this.insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1069 */       this.appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1070 */       this.appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1071 */       this.planCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1072 */       this.planName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1073 */       this.riderName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1074 */       this.riderCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1075 */       this.uWDid = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1076 */       this.faceAmount = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1077 */       this.term = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1078 */       this.healthDeb = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1079 */       this.healthFe = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1080 */       this.healthFed = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 1081 */       this.occupationFactor = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1082 */       this.occupationFe = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 1083 */       this.occupationFed = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 1084 */       this.exclusions = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1085 */       this.declinedCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1086 */       this.declinedReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1087 */       this.passFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1088 */       this.uWIdea = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1089 */       this.uWGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 1090 */       this.appGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1091 */       this.postponeDay = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/* 1092 */       this.postponeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|"));
/* 1093 */       this.autoUWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 1094 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/* 1095 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 1096 */       this.upReportContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
/* 1097 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 1098 */       this.healthFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/* 1099 */       this.quesFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/* 1100 */       this.specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1101 */       this.addPremFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1102 */       this.addPremReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1103 */       this.reportFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 1104 */       this.printFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1105 */       this.printFlag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 1106 */       this.changePolFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 1107 */       this.changePolReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 1108 */       this.specReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 1109 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|"));
/* 1110 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
/* 1111 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|"));
/* 1112 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
/* 1113 */       this.sugPassFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
/* 1114 */       this.sugUWIdea = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1119 */       CError tError = new CError();
/* 1120 */       tError.moduleName = "LNPUWMasterSchema";
/* 1121 */       tError.functionName = "decode";
/* 1122 */       tError.errorMessage = ex.toString();
/* 1123 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1125 */       return false;
/*      */     }
/* 1127 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1133 */     String strReturn = "";
/* 1134 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 1136 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/* 1138 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 1140 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/* 1142 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 1144 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/* 1146 */     if (FCode.equalsIgnoreCase("polNo"))
/*      */     {
/* 1148 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polNo));
/*      */     }
/* 1150 */     if (FCode.equalsIgnoreCase("proposalNo"))
/*      */     {
/* 1152 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalNo));
/*      */     }
/* 1154 */     if (FCode.equalsIgnoreCase("uWNo"))
/*      */     {
/* 1156 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWNo));
/*      */     }
/* 1158 */     if (FCode.equalsIgnoreCase("insuredNo"))
/*      */     {
/* 1160 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredNo));
/*      */     }
/* 1162 */     if (FCode.equalsIgnoreCase("insuredName"))
/*      */     {
/* 1164 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredName));
/*      */     }
/* 1166 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/* 1168 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntNo));
/*      */     }
/* 1170 */     if (FCode.equalsIgnoreCase("appntName"))
/*      */     {
/* 1172 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntName));
/*      */     }
/* 1174 */     if (FCode.equalsIgnoreCase("planCode"))
/*      */     {
/* 1176 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.planCode));
/*      */     }
/* 1178 */     if (FCode.equalsIgnoreCase("planName"))
/*      */     {
/* 1180 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.planName));
/*      */     }
/* 1182 */     if (FCode.equalsIgnoreCase("riderName"))
/*      */     {
/* 1184 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riderName));
/*      */     }
/* 1186 */     if (FCode.equalsIgnoreCase("riderCode"))
/*      */     {
/* 1188 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riderCode));
/*      */     }
/* 1190 */     if (FCode.equalsIgnoreCase("uWDid"))
/*      */     {
/* 1192 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWDid));
/*      */     }
/* 1194 */     if (FCode.equalsIgnoreCase("faceAmount"))
/*      */     {
/* 1196 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.faceAmount));
/*      */     }
/* 1198 */     if (FCode.equalsIgnoreCase("term"))
/*      */     {
/* 1200 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.term));
/*      */     }
/* 1202 */     if (FCode.equalsIgnoreCase("healthDeb"))
/*      */     {
/* 1204 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.healthDeb));
/*      */     }
/* 1206 */     if (FCode.equalsIgnoreCase("healthFe"))
/*      */     {
/* 1208 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.healthFe));
/*      */     }
/* 1210 */     if (FCode.equalsIgnoreCase("healthFed"))
/*      */     {
/* 1212 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.healthFed));
/*      */     }
/* 1214 */     if (FCode.equalsIgnoreCase("occupationFactor"))
/*      */     {
/* 1216 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationFactor));
/*      */     }
/* 1218 */     if (FCode.equalsIgnoreCase("occupationFe"))
/*      */     {
/* 1220 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationFe));
/*      */     }
/* 1222 */     if (FCode.equalsIgnoreCase("occupationFed"))
/*      */     {
/* 1224 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationFed));
/*      */     }
/* 1226 */     if (FCode.equalsIgnoreCase("exclusions"))
/*      */     {
/* 1228 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.exclusions));
/*      */     }
/* 1230 */     if (FCode.equalsIgnoreCase("declinedCode"))
/*      */     {
/* 1232 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.declinedCode));
/*      */     }
/* 1234 */     if (FCode.equalsIgnoreCase("declinedReason"))
/*      */     {
/* 1236 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.declinedReason));
/*      */     }
/* 1238 */     if (FCode.equalsIgnoreCase("passFlag"))
/*      */     {
/* 1240 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.passFlag));
/*      */     }
/* 1242 */     if (FCode.equalsIgnoreCase("uWIdea"))
/*      */     {
/* 1244 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWIdea));
/*      */     }
/* 1246 */     if (FCode.equalsIgnoreCase("uWGrade"))
/*      */     {
/* 1248 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWGrade));
/*      */     }
/* 1250 */     if (FCode.equalsIgnoreCase("appGrade"))
/*      */     {
/* 1252 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appGrade));
/*      */     }
/* 1254 */     if (FCode.equalsIgnoreCase("postponeDay"))
/*      */     {
/* 1256 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.postponeDay));
/*      */     }
/* 1258 */     if (FCode.equalsIgnoreCase("postponeDate"))
/*      */     {
/* 1260 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPostponeDate()));
/*      */     }
/* 1262 */     if (FCode.equalsIgnoreCase("autoUWFlag"))
/*      */     {
/* 1264 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.autoUWFlag));
/*      */     }
/* 1266 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1268 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/* 1270 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1272 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 1274 */     if (FCode.equalsIgnoreCase("upReportContent"))
/*      */     {
/* 1276 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.upReportContent));
/*      */     }
/* 1278 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1280 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1282 */     if (FCode.equalsIgnoreCase("healthFlag"))
/*      */     {
/* 1284 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.healthFlag));
/*      */     }
/* 1286 */     if (FCode.equalsIgnoreCase("quesFlag"))
/*      */     {
/* 1288 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.quesFlag));
/*      */     }
/* 1290 */     if (FCode.equalsIgnoreCase("specFlag"))
/*      */     {
/* 1292 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specFlag));
/*      */     }
/* 1294 */     if (FCode.equalsIgnoreCase("addPremFlag"))
/*      */     {
/* 1296 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addPremFlag));
/*      */     }
/* 1298 */     if (FCode.equalsIgnoreCase("addPremReason"))
/*      */     {
/* 1300 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addPremReason));
/*      */     }
/* 1302 */     if (FCode.equalsIgnoreCase("reportFlag"))
/*      */     {
/* 1304 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.reportFlag));
/*      */     }
/* 1306 */     if (FCode.equalsIgnoreCase("printFlag"))
/*      */     {
/* 1308 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.printFlag));
/*      */     }
/* 1310 */     if (FCode.equalsIgnoreCase("printFlag2"))
/*      */     {
/* 1312 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.printFlag2));
/*      */     }
/* 1314 */     if (FCode.equalsIgnoreCase("changePolFlag"))
/*      */     {
/* 1316 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.changePolFlag));
/*      */     }
/* 1318 */     if (FCode.equalsIgnoreCase("changePolReason"))
/*      */     {
/* 1320 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.changePolReason));
/*      */     }
/* 1322 */     if (FCode.equalsIgnoreCase("specReason"))
/*      */     {
/* 1324 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specReason));
/*      */     }
/* 1326 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1328 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 1330 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1332 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1334 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1336 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 1338 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1340 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1342 */     if (FCode.equalsIgnoreCase("sugPassFlag"))
/*      */     {
/* 1344 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sugPassFlag));
/*      */     }
/* 1346 */     if (FCode.equalsIgnoreCase("sugUWIdea"))
/*      */     {
/* 1348 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sugUWIdea));
/*      */     }
/* 1350 */     if (strReturn.equals(""))
/*      */     {
/* 1352 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1355 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1362 */     String strFieldValue = "";
/* 1363 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1365 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/* 1366 */       break;
/*      */     case 1:
/* 1368 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 1369 */       break;
/*      */     case 2:
/* 1371 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/* 1372 */       break;
/*      */     case 3:
/* 1374 */       strFieldValue = StrTool.GBKToUnicode(this.polNo);
/* 1375 */       break;
/*      */     case 4:
/* 1377 */       strFieldValue = StrTool.GBKToUnicode(this.proposalNo);
/* 1378 */       break;
/*      */     case 5:
/* 1380 */       strFieldValue = String.valueOf(this.uWNo);
/* 1381 */       break;
/*      */     case 6:
/* 1383 */       strFieldValue = StrTool.GBKToUnicode(this.insuredNo);
/* 1384 */       break;
/*      */     case 7:
/* 1386 */       strFieldValue = StrTool.GBKToUnicode(this.insuredName);
/* 1387 */       break;
/*      */     case 8:
/* 1389 */       strFieldValue = StrTool.GBKToUnicode(this.appntNo);
/* 1390 */       break;
/*      */     case 9:
/* 1392 */       strFieldValue = StrTool.GBKToUnicode(this.appntName);
/* 1393 */       break;
/*      */     case 10:
/* 1395 */       strFieldValue = StrTool.GBKToUnicode(this.planCode);
/* 1396 */       break;
/*      */     case 11:
/* 1398 */       strFieldValue = StrTool.GBKToUnicode(this.planName);
/* 1399 */       break;
/*      */     case 12:
/* 1401 */       strFieldValue = StrTool.GBKToUnicode(this.riderName);
/* 1402 */       break;
/*      */     case 13:
/* 1404 */       strFieldValue = StrTool.GBKToUnicode(this.riderCode);
/* 1405 */       break;
/*      */     case 14:
/* 1407 */       strFieldValue = StrTool.GBKToUnicode(this.uWDid);
/* 1408 */       break;
/*      */     case 15:
/* 1410 */       strFieldValue = StrTool.GBKToUnicode(this.faceAmount);
/* 1411 */       break;
/*      */     case 16:
/* 1413 */       strFieldValue = StrTool.GBKToUnicode(this.term);
/* 1414 */       break;
/*      */     case 17:
/* 1416 */       strFieldValue = StrTool.GBKToUnicode(this.healthDeb);
/* 1417 */       break;
/*      */     case 18:
/* 1419 */       strFieldValue = StrTool.GBKToUnicode(this.healthFe);
/* 1420 */       break;
/*      */     case 19:
/* 1422 */       strFieldValue = StrTool.GBKToUnicode(this.healthFed);
/* 1423 */       break;
/*      */     case 20:
/* 1425 */       strFieldValue = StrTool.GBKToUnicode(this.occupationFactor);
/* 1426 */       break;
/*      */     case 21:
/* 1428 */       strFieldValue = StrTool.GBKToUnicode(this.occupationFe);
/* 1429 */       break;
/*      */     case 22:
/* 1431 */       strFieldValue = StrTool.GBKToUnicode(this.occupationFed);
/* 1432 */       break;
/*      */     case 23:
/* 1434 */       strFieldValue = StrTool.GBKToUnicode(this.exclusions);
/* 1435 */       break;
/*      */     case 24:
/* 1437 */       strFieldValue = StrTool.GBKToUnicode(this.declinedCode);
/* 1438 */       break;
/*      */     case 25:
/* 1440 */       strFieldValue = StrTool.GBKToUnicode(this.declinedReason);
/* 1441 */       break;
/*      */     case 26:
/* 1443 */       strFieldValue = StrTool.GBKToUnicode(this.passFlag);
/* 1444 */       break;
/*      */     case 27:
/* 1446 */       strFieldValue = StrTool.GBKToUnicode(this.uWIdea);
/* 1447 */       break;
/*      */     case 28:
/* 1449 */       strFieldValue = StrTool.GBKToUnicode(this.uWGrade);
/* 1450 */       break;
/*      */     case 29:
/* 1452 */       strFieldValue = StrTool.GBKToUnicode(this.appGrade);
/* 1453 */       break;
/*      */     case 30:
/* 1455 */       strFieldValue = StrTool.GBKToUnicode(this.postponeDay);
/* 1456 */       break;
/*      */     case 31:
/* 1458 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPostponeDate()));
/* 1459 */       break;
/*      */     case 32:
/* 1461 */       strFieldValue = StrTool.GBKToUnicode(this.autoUWFlag);
/* 1462 */       break;
/*      */     case 33:
/* 1464 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 1465 */       break;
/*      */     case 34:
/* 1467 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1468 */       break;
/*      */     case 35:
/* 1470 */       strFieldValue = StrTool.GBKToUnicode(this.upReportContent);
/* 1471 */       break;
/*      */     case 36:
/* 1473 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1474 */       break;
/*      */     case 37:
/* 1476 */       strFieldValue = StrTool.GBKToUnicode(this.healthFlag);
/* 1477 */       break;
/*      */     case 38:
/* 1479 */       strFieldValue = StrTool.GBKToUnicode(this.quesFlag);
/* 1480 */       break;
/*      */     case 39:
/* 1482 */       strFieldValue = StrTool.GBKToUnicode(this.specFlag);
/* 1483 */       break;
/*      */     case 40:
/* 1485 */       strFieldValue = StrTool.GBKToUnicode(this.addPremFlag);
/* 1486 */       break;
/*      */     case 41:
/* 1488 */       strFieldValue = StrTool.GBKToUnicode(this.addPremReason);
/* 1489 */       break;
/*      */     case 42:
/* 1491 */       strFieldValue = StrTool.GBKToUnicode(this.reportFlag);
/* 1492 */       break;
/*      */     case 43:
/* 1494 */       strFieldValue = StrTool.GBKToUnicode(this.printFlag);
/* 1495 */       break;
/*      */     case 44:
/* 1497 */       strFieldValue = StrTool.GBKToUnicode(this.printFlag2);
/* 1498 */       break;
/*      */     case 45:
/* 1500 */       strFieldValue = StrTool.GBKToUnicode(this.changePolFlag);
/* 1501 */       break;
/*      */     case 46:
/* 1503 */       strFieldValue = StrTool.GBKToUnicode(this.changePolReason);
/* 1504 */       break;
/*      */     case 47:
/* 1506 */       strFieldValue = StrTool.GBKToUnicode(this.specReason);
/* 1507 */       break;
/*      */     case 48:
/* 1509 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1510 */       break;
/*      */     case 49:
/* 1512 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1513 */       break;
/*      */     case 50:
/* 1515 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1516 */       break;
/*      */     case 51:
/* 1518 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1519 */       break;
/*      */     case 52:
/* 1521 */       strFieldValue = StrTool.GBKToUnicode(this.sugPassFlag);
/* 1522 */       break;
/*      */     case 53:
/* 1524 */       strFieldValue = StrTool.GBKToUnicode(this.sugUWIdea);
/* 1525 */       break;
/*      */     default:
/* 1527 */       strFieldValue = "";
/*      */     }
/* 1529 */     if (strFieldValue.equals("")) {
/* 1530 */       strFieldValue = "null";
/*      */     }
/* 1532 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1538 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1539 */       return false;
/*      */     }
/* 1541 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 1543 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1545 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1548 */         this.grpContNo = null;
/*      */     }
/* 1550 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 1552 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1554 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 1557 */         this.contNo = null;
/*      */     }
/* 1559 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 1561 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1563 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1566 */         this.proposalContNo = null;
/*      */     }
/* 1568 */     if (FCode.equalsIgnoreCase("polNo"))
/*      */     {
/* 1570 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1572 */         this.polNo = FValue.trim();
/*      */       }
/*      */       else
/* 1575 */         this.polNo = null;
/*      */     }
/* 1577 */     if (FCode.equalsIgnoreCase("proposalNo"))
/*      */     {
/* 1579 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1581 */         this.proposalNo = FValue.trim();
/*      */       }
/*      */       else
/* 1584 */         this.proposalNo = null;
/*      */     }
/* 1586 */     if (FCode.equalsIgnoreCase("uWNo"))
/*      */     {
/* 1588 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1590 */         Integer tInteger = new Integer(FValue);
/* 1591 */         int i = tInteger.intValue();
/* 1592 */         this.uWNo = i;
/*      */       }
/*      */     }
/* 1595 */     if (FCode.equalsIgnoreCase("insuredNo"))
/*      */     {
/* 1597 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1599 */         this.insuredNo = FValue.trim();
/*      */       }
/*      */       else
/* 1602 */         this.insuredNo = null;
/*      */     }
/* 1604 */     if (FCode.equalsIgnoreCase("insuredName"))
/*      */     {
/* 1606 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1608 */         this.insuredName = FValue.trim();
/*      */       }
/*      */       else
/* 1611 */         this.insuredName = null;
/*      */     }
/* 1613 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/* 1615 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1617 */         this.appntNo = FValue.trim();
/*      */       }
/*      */       else
/* 1620 */         this.appntNo = null;
/*      */     }
/* 1622 */     if (FCode.equalsIgnoreCase("appntName"))
/*      */     {
/* 1624 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1626 */         this.appntName = FValue.trim();
/*      */       }
/*      */       else
/* 1629 */         this.appntName = null;
/*      */     }
/* 1631 */     if (FCode.equalsIgnoreCase("planCode"))
/*      */     {
/* 1633 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1635 */         this.planCode = FValue.trim();
/*      */       }
/*      */       else
/* 1638 */         this.planCode = null;
/*      */     }
/* 1640 */     if (FCode.equalsIgnoreCase("planName"))
/*      */     {
/* 1642 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1644 */         this.planName = FValue.trim();
/*      */       }
/*      */       else
/* 1647 */         this.planName = null;
/*      */     }
/* 1649 */     if (FCode.equalsIgnoreCase("riderName"))
/*      */     {
/* 1651 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1653 */         this.riderName = FValue.trim();
/*      */       }
/*      */       else
/* 1656 */         this.riderName = null;
/*      */     }
/* 1658 */     if (FCode.equalsIgnoreCase("riderCode"))
/*      */     {
/* 1660 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1662 */         this.riderCode = FValue.trim();
/*      */       }
/*      */       else
/* 1665 */         this.riderCode = null;
/*      */     }
/* 1667 */     if (FCode.equalsIgnoreCase("uWDid"))
/*      */     {
/* 1669 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1671 */         this.uWDid = FValue.trim();
/*      */       }
/*      */       else
/* 1674 */         this.uWDid = null;
/*      */     }
/* 1676 */     if (FCode.equalsIgnoreCase("faceAmount"))
/*      */     {
/* 1678 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1680 */         this.faceAmount = FValue.trim();
/*      */       }
/*      */       else
/* 1683 */         this.faceAmount = null;
/*      */     }
/* 1685 */     if (FCode.equalsIgnoreCase("term"))
/*      */     {
/* 1687 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1689 */         this.term = FValue.trim();
/*      */       }
/*      */       else
/* 1692 */         this.term = null;
/*      */     }
/* 1694 */     if (FCode.equalsIgnoreCase("healthDeb"))
/*      */     {
/* 1696 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1698 */         this.healthDeb = FValue.trim();
/*      */       }
/*      */       else
/* 1701 */         this.healthDeb = null;
/*      */     }
/* 1703 */     if (FCode.equalsIgnoreCase("healthFe"))
/*      */     {
/* 1705 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1707 */         this.healthFe = FValue.trim();
/*      */       }
/*      */       else
/* 1710 */         this.healthFe = null;
/*      */     }
/* 1712 */     if (FCode.equalsIgnoreCase("healthFed"))
/*      */     {
/* 1714 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1716 */         this.healthFed = FValue.trim();
/*      */       }
/*      */       else
/* 1719 */         this.healthFed = null;
/*      */     }
/* 1721 */     if (FCode.equalsIgnoreCase("occupationFactor"))
/*      */     {
/* 1723 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1725 */         this.occupationFactor = FValue.trim();
/*      */       }
/*      */       else
/* 1728 */         this.occupationFactor = null;
/*      */     }
/* 1730 */     if (FCode.equalsIgnoreCase("occupationFe"))
/*      */     {
/* 1732 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1734 */         this.occupationFe = FValue.trim();
/*      */       }
/*      */       else
/* 1737 */         this.occupationFe = null;
/*      */     }
/* 1739 */     if (FCode.equalsIgnoreCase("occupationFed"))
/*      */     {
/* 1741 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1743 */         this.occupationFed = FValue.trim();
/*      */       }
/*      */       else
/* 1746 */         this.occupationFed = null;
/*      */     }
/* 1748 */     if (FCode.equalsIgnoreCase("exclusions"))
/*      */     {
/* 1750 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1752 */         this.exclusions = FValue.trim();
/*      */       }
/*      */       else
/* 1755 */         this.exclusions = null;
/*      */     }
/* 1757 */     if (FCode.equalsIgnoreCase("declinedCode"))
/*      */     {
/* 1759 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1761 */         this.declinedCode = FValue.trim();
/*      */       }
/*      */       else
/* 1764 */         this.declinedCode = null;
/*      */     }
/* 1766 */     if (FCode.equalsIgnoreCase("declinedReason"))
/*      */     {
/* 1768 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1770 */         this.declinedReason = FValue.trim();
/*      */       }
/*      */       else
/* 1773 */         this.declinedReason = null;
/*      */     }
/* 1775 */     if (FCode.equalsIgnoreCase("passFlag"))
/*      */     {
/* 1777 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1779 */         this.passFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1782 */         this.passFlag = null;
/*      */     }
/* 1784 */     if (FCode.equalsIgnoreCase("uWIdea"))
/*      */     {
/* 1786 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1788 */         this.uWIdea = FValue.trim();
/*      */       }
/*      */       else
/* 1791 */         this.uWIdea = null;
/*      */     }
/* 1793 */     if (FCode.equalsIgnoreCase("uWGrade"))
/*      */     {
/* 1795 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1797 */         this.uWGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1800 */         this.uWGrade = null;
/*      */     }
/* 1802 */     if (FCode.equalsIgnoreCase("appGrade"))
/*      */     {
/* 1804 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1806 */         this.appGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1809 */         this.appGrade = null;
/*      */     }
/* 1811 */     if (FCode.equalsIgnoreCase("postponeDay"))
/*      */     {
/* 1813 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1815 */         this.postponeDay = FValue.trim();
/*      */       }
/*      */       else
/* 1818 */         this.postponeDay = null;
/*      */     }
/* 1820 */     if (FCode.equalsIgnoreCase("postponeDate"))
/*      */     {
/* 1822 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1824 */         this.postponeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1827 */         this.postponeDate = null;
/*      */     }
/* 1829 */     if (FCode.equalsIgnoreCase("autoUWFlag"))
/*      */     {
/* 1831 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1833 */         this.autoUWFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1836 */         this.autoUWFlag = null;
/*      */     }
/* 1838 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1840 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1842 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 1845 */         this.state = null;
/*      */     }
/* 1847 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1849 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1851 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1854 */         this.manageCom = null;
/*      */     }
/* 1856 */     if (FCode.equalsIgnoreCase("upReportContent"))
/*      */     {
/* 1858 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1860 */         this.upReportContent = FValue.trim();
/*      */       }
/*      */       else
/* 1863 */         this.upReportContent = null;
/*      */     }
/* 1865 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1867 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1869 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1872 */         this.operator = null;
/*      */     }
/* 1874 */     if (FCode.equalsIgnoreCase("healthFlag"))
/*      */     {
/* 1876 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1878 */         this.healthFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1881 */         this.healthFlag = null;
/*      */     }
/* 1883 */     if (FCode.equalsIgnoreCase("quesFlag"))
/*      */     {
/* 1885 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1887 */         this.quesFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1890 */         this.quesFlag = null;
/*      */     }
/* 1892 */     if (FCode.equalsIgnoreCase("specFlag"))
/*      */     {
/* 1894 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1896 */         this.specFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1899 */         this.specFlag = null;
/*      */     }
/* 1901 */     if (FCode.equalsIgnoreCase("addPremFlag"))
/*      */     {
/* 1903 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1905 */         this.addPremFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1908 */         this.addPremFlag = null;
/*      */     }
/* 1910 */     if (FCode.equalsIgnoreCase("addPremReason"))
/*      */     {
/* 1912 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1914 */         this.addPremReason = FValue.trim();
/*      */       }
/*      */       else
/* 1917 */         this.addPremReason = null;
/*      */     }
/* 1919 */     if (FCode.equalsIgnoreCase("reportFlag"))
/*      */     {
/* 1921 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1923 */         this.reportFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1926 */         this.reportFlag = null;
/*      */     }
/* 1928 */     if (FCode.equalsIgnoreCase("printFlag"))
/*      */     {
/* 1930 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1932 */         this.printFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1935 */         this.printFlag = null;
/*      */     }
/* 1937 */     if (FCode.equalsIgnoreCase("printFlag2"))
/*      */     {
/* 1939 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1941 */         this.printFlag2 = FValue.trim();
/*      */       }
/*      */       else
/* 1944 */         this.printFlag2 = null;
/*      */     }
/* 1946 */     if (FCode.equalsIgnoreCase("changePolFlag"))
/*      */     {
/* 1948 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1950 */         this.changePolFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1953 */         this.changePolFlag = null;
/*      */     }
/* 1955 */     if (FCode.equalsIgnoreCase("changePolReason"))
/*      */     {
/* 1957 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1959 */         this.changePolReason = FValue.trim();
/*      */       }
/*      */       else
/* 1962 */         this.changePolReason = null;
/*      */     }
/* 1964 */     if (FCode.equalsIgnoreCase("specReason"))
/*      */     {
/* 1966 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1968 */         this.specReason = FValue.trim();
/*      */       }
/*      */       else
/* 1971 */         this.specReason = null;
/*      */     }
/* 1973 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1975 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1977 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1980 */         this.makeDate = null;
/*      */     }
/* 1982 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1984 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1986 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1989 */         this.makeTime = null;
/*      */     }
/* 1991 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1993 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1995 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1998 */         this.modifyDate = null;
/*      */     }
/* 2000 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 2002 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2004 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 2007 */         this.modifyTime = null;
/*      */     }
/* 2009 */     if (FCode.equalsIgnoreCase("sugPassFlag"))
/*      */     {
/* 2011 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2013 */         this.sugPassFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2016 */         this.sugPassFlag = null;
/*      */     }
/* 2018 */     if (FCode.equalsIgnoreCase("sugUWIdea"))
/*      */     {
/* 2020 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2022 */         this.sugUWIdea = FValue.trim();
/*      */       }
/*      */       else
/* 2025 */         this.sugUWIdea = null;
/*      */     }
/* 2027 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 2032 */     if (otherObject == null) return false;
/* 2033 */     if (this == otherObject) return true;
/* 2034 */     if (getClass() != otherObject.getClass()) return false;
/* 2035 */     LNPUWMasterSchema other = (LNPUWMasterSchema)otherObject;
/* 2036 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/* 2037 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/* 2038 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/* 2039 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/* 2040 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/* 2041 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/* 2042 */     if ((this.polNo == null) && (other.getPolNo() != null)) return false;
/* 2043 */     if ((this.polNo != null) && (!this.polNo.equals(other.getPolNo()))) return false;
/* 2044 */     if ((this.proposalNo == null) && (other.getProposalNo() != null)) return false;
/* 2045 */     if ((this.proposalNo != null) && (!this.proposalNo.equals(other.getProposalNo()))) return false;
/* 2046 */     if (this.uWNo != other.getUWNo()) return false;
/* 2047 */     if ((this.insuredNo == null) && (other.getInsuredNo() != null)) return false;
/* 2048 */     if ((this.insuredNo != null) && (!this.insuredNo.equals(other.getInsuredNo()))) return false;
/* 2049 */     if ((this.insuredName == null) && (other.getInsuredName() != null)) return false;
/* 2050 */     if ((this.insuredName != null) && (!this.insuredName.equals(other.getInsuredName()))) return false;
/* 2051 */     if ((this.appntNo == null) && (other.getAppntNo() != null)) return false;
/* 2052 */     if ((this.appntNo != null) && (!this.appntNo.equals(other.getAppntNo()))) return false;
/* 2053 */     if ((this.appntName == null) && (other.getAppntName() != null)) return false;
/* 2054 */     if ((this.appntName != null) && (!this.appntName.equals(other.getAppntName()))) return false;
/* 2055 */     if ((this.planCode == null) && (other.getPlanCode() != null)) return false;
/* 2056 */     if ((this.planCode != null) && (!this.planCode.equals(other.getPlanCode()))) return false;
/* 2057 */     if ((this.planName == null) && (other.getPlanName() != null)) return false;
/* 2058 */     if ((this.planName != null) && (!this.planName.equals(other.getPlanName()))) return false;
/* 2059 */     if ((this.riderName == null) && (other.getRiderName() != null)) return false;
/* 2060 */     if ((this.riderName != null) && (!this.riderName.equals(other.getRiderName()))) return false;
/* 2061 */     if ((this.riderCode == null) && (other.getRiderCode() != null)) return false;
/* 2062 */     if ((this.riderCode != null) && (!this.riderCode.equals(other.getRiderCode()))) return false;
/* 2063 */     if ((this.uWDid == null) && (other.getUWDid() != null)) return false;
/* 2064 */     if ((this.uWDid != null) && (!this.uWDid.equals(other.getUWDid()))) return false;
/* 2065 */     if ((this.faceAmount == null) && (other.getFaceAmount() != null)) return false;
/* 2066 */     if ((this.faceAmount != null) && (!this.faceAmount.equals(other.getFaceAmount()))) return false;
/* 2067 */     if ((this.term == null) && (other.getTerm() != null)) return false;
/* 2068 */     if ((this.term != null) && (!this.term.equals(other.getTerm()))) return false;
/* 2069 */     if ((this.healthDeb == null) && (other.getHealthDeb() != null)) return false;
/* 2070 */     if ((this.healthDeb != null) && (!this.healthDeb.equals(other.getHealthDeb()))) return false;
/* 2071 */     if ((this.healthFe == null) && (other.getHealthFe() != null)) return false;
/* 2072 */     if ((this.healthFe != null) && (!this.healthFe.equals(other.getHealthFe()))) return false;
/* 2073 */     if ((this.healthFed == null) && (other.getHealthFed() != null)) return false;
/* 2074 */     if ((this.healthFed != null) && (!this.healthFed.equals(other.getHealthFed()))) return false;
/* 2075 */     if ((this.occupationFactor == null) && (other.getOccupationFactor() != null)) return false;
/* 2076 */     if ((this.occupationFactor != null) && (!this.occupationFactor.equals(other.getOccupationFactor()))) return false;
/* 2077 */     if ((this.occupationFe == null) && (other.getOccupationFe() != null)) return false;
/* 2078 */     if ((this.occupationFe != null) && (!this.occupationFe.equals(other.getOccupationFe()))) return false;
/* 2079 */     if ((this.occupationFed == null) && (other.getOccupationFed() != null)) return false;
/* 2080 */     if ((this.occupationFed != null) && (!this.occupationFed.equals(other.getOccupationFed()))) return false;
/* 2081 */     if ((this.exclusions == null) && (other.getExclusions() != null)) return false;
/* 2082 */     if ((this.exclusions != null) && (!this.exclusions.equals(other.getExclusions()))) return false;
/* 2083 */     if ((this.declinedCode == null) && (other.getDeclinedCode() != null)) return false;
/* 2084 */     if ((this.declinedCode != null) && (!this.declinedCode.equals(other.getDeclinedCode()))) return false;
/* 2085 */     if ((this.declinedReason == null) && (other.getDeclinedReason() != null)) return false;
/* 2086 */     if ((this.declinedReason != null) && (!this.declinedReason.equals(other.getDeclinedReason()))) return false;
/* 2087 */     if ((this.passFlag == null) && (other.getPassFlag() != null)) return false;
/* 2088 */     if ((this.passFlag != null) && (!this.passFlag.equals(other.getPassFlag()))) return false;
/* 2089 */     if ((this.uWIdea == null) && (other.getUWIdea() != null)) return false;
/* 2090 */     if ((this.uWIdea != null) && (!this.uWIdea.equals(other.getUWIdea()))) return false;
/* 2091 */     if ((this.uWGrade == null) && (other.getUWGrade() != null)) return false;
/* 2092 */     if ((this.uWGrade != null) && (!this.uWGrade.equals(other.getUWGrade()))) return false;
/* 2093 */     if ((this.appGrade == null) && (other.getAppGrade() != null)) return false;
/* 2094 */     if ((this.appGrade != null) && (!this.appGrade.equals(other.getAppGrade()))) return false;
/* 2095 */     if ((this.postponeDay == null) && (other.getPostponeDay() != null)) return false;
/* 2096 */     if ((this.postponeDay != null) && (!this.postponeDay.equals(other.getPostponeDay()))) return false;
/* 2097 */     if ((this.postponeDate == null) && (other.getPostponeDate() != null)) return false;
/* 2098 */     if ((this.postponeDate != null) && (!this.fDate.getString(this.postponeDate).equals(other.getPostponeDate()))) return false;
/* 2099 */     if ((this.autoUWFlag == null) && (other.getAutoUWFlag() != null)) return false;
/* 2100 */     if ((this.autoUWFlag != null) && (!this.autoUWFlag.equals(other.getAutoUWFlag()))) return false;
/* 2101 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 2102 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 2103 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 2104 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 2105 */     if ((this.upReportContent == null) && (other.getUpReportContent() != null)) return false;
/* 2106 */     if ((this.upReportContent != null) && (!this.upReportContent.equals(other.getUpReportContent()))) return false;
/* 2107 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 2108 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 2109 */     if ((this.healthFlag == null) && (other.getHealthFlag() != null)) return false;
/* 2110 */     if ((this.healthFlag != null) && (!this.healthFlag.equals(other.getHealthFlag()))) return false;
/* 2111 */     if ((this.quesFlag == null) && (other.getQuesFlag() != null)) return false;
/* 2112 */     if ((this.quesFlag != null) && (!this.quesFlag.equals(other.getQuesFlag()))) return false;
/* 2113 */     if ((this.specFlag == null) && (other.getSpecFlag() != null)) return false;
/* 2114 */     if ((this.specFlag != null) && (!this.specFlag.equals(other.getSpecFlag()))) return false;
/* 2115 */     if ((this.addPremFlag == null) && (other.getAddPremFlag() != null)) return false;
/* 2116 */     if ((this.addPremFlag != null) && (!this.addPremFlag.equals(other.getAddPremFlag()))) return false;
/* 2117 */     if ((this.addPremReason == null) && (other.getAddPremReason() != null)) return false;
/* 2118 */     if ((this.addPremReason != null) && (!this.addPremReason.equals(other.getAddPremReason()))) return false;
/* 2119 */     if ((this.reportFlag == null) && (other.getReportFlag() != null)) return false;
/* 2120 */     if ((this.reportFlag != null) && (!this.reportFlag.equals(other.getReportFlag()))) return false;
/* 2121 */     if ((this.printFlag == null) && (other.getPrintFlag() != null)) return false;
/* 2122 */     if ((this.printFlag != null) && (!this.printFlag.equals(other.getPrintFlag()))) return false;
/* 2123 */     if ((this.printFlag2 == null) && (other.getPrintFlag2() != null)) return false;
/* 2124 */     if ((this.printFlag2 != null) && (!this.printFlag2.equals(other.getPrintFlag2()))) return false;
/* 2125 */     if ((this.changePolFlag == null) && (other.getChangePolFlag() != null)) return false;
/* 2126 */     if ((this.changePolFlag != null) && (!this.changePolFlag.equals(other.getChangePolFlag()))) return false;
/* 2127 */     if ((this.changePolReason == null) && (other.getChangePolReason() != null)) return false;
/* 2128 */     if ((this.changePolReason != null) && (!this.changePolReason.equals(other.getChangePolReason()))) return false;
/* 2129 */     if ((this.specReason == null) && (other.getSpecReason() != null)) return false;
/* 2130 */     if ((this.specReason != null) && (!this.specReason.equals(other.getSpecReason()))) return false;
/* 2131 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 2132 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 2133 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 2134 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 2135 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 2136 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 2137 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 2138 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 2139 */     if ((this.sugPassFlag == null) && (other.getSugPassFlag() != null)) return false;
/* 2140 */     if ((this.sugPassFlag != null) && (!this.sugPassFlag.equals(other.getSugPassFlag()))) return false;
/* 2141 */     if ((this.sugUWIdea == null) && (other.getSugUWIdea() != null)) return false;
/* 2142 */     return (this.sugUWIdea == null) || (this.sugUWIdea.equals(other.getSugUWIdea()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2149 */     return 54;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2155 */     if (strFieldName.equals("grpContNo")) {
/* 2156 */       return 0;
/*      */     }
/* 2158 */     if (strFieldName.equals("contNo")) {
/* 2159 */       return 1;
/*      */     }
/* 2161 */     if (strFieldName.equals("proposalContNo")) {
/* 2162 */       return 2;
/*      */     }
/* 2164 */     if (strFieldName.equals("polNo")) {
/* 2165 */       return 3;
/*      */     }
/* 2167 */     if (strFieldName.equals("proposalNo")) {
/* 2168 */       return 4;
/*      */     }
/* 2170 */     if (strFieldName.equals("uWNo")) {
/* 2171 */       return 5;
/*      */     }
/* 2173 */     if (strFieldName.equals("insuredNo")) {
/* 2174 */       return 6;
/*      */     }
/* 2176 */     if (strFieldName.equals("insuredName")) {
/* 2177 */       return 7;
/*      */     }
/* 2179 */     if (strFieldName.equals("appntNo")) {
/* 2180 */       return 8;
/*      */     }
/* 2182 */     if (strFieldName.equals("appntName")) {
/* 2183 */       return 9;
/*      */     }
/* 2185 */     if (strFieldName.equals("planCode")) {
/* 2186 */       return 10;
/*      */     }
/* 2188 */     if (strFieldName.equals("planName")) {
/* 2189 */       return 11;
/*      */     }
/* 2191 */     if (strFieldName.equals("riderName")) {
/* 2192 */       return 12;
/*      */     }
/* 2194 */     if (strFieldName.equals("riderCode")) {
/* 2195 */       return 13;
/*      */     }
/* 2197 */     if (strFieldName.equals("uWDid")) {
/* 2198 */       return 14;
/*      */     }
/* 2200 */     if (strFieldName.equals("faceAmount")) {
/* 2201 */       return 15;
/*      */     }
/* 2203 */     if (strFieldName.equals("term")) {
/* 2204 */       return 16;
/*      */     }
/* 2206 */     if (strFieldName.equals("healthDeb")) {
/* 2207 */       return 17;
/*      */     }
/* 2209 */     if (strFieldName.equals("healthFe")) {
/* 2210 */       return 18;
/*      */     }
/* 2212 */     if (strFieldName.equals("healthFed")) {
/* 2213 */       return 19;
/*      */     }
/* 2215 */     if (strFieldName.equals("occupationFactor")) {
/* 2216 */       return 20;
/*      */     }
/* 2218 */     if (strFieldName.equals("occupationFe")) {
/* 2219 */       return 21;
/*      */     }
/* 2221 */     if (strFieldName.equals("occupationFed")) {
/* 2222 */       return 22;
/*      */     }
/* 2224 */     if (strFieldName.equals("exclusions")) {
/* 2225 */       return 23;
/*      */     }
/* 2227 */     if (strFieldName.equals("declinedCode")) {
/* 2228 */       return 24;
/*      */     }
/* 2230 */     if (strFieldName.equals("declinedReason")) {
/* 2231 */       return 25;
/*      */     }
/* 2233 */     if (strFieldName.equals("passFlag")) {
/* 2234 */       return 26;
/*      */     }
/* 2236 */     if (strFieldName.equals("uWIdea")) {
/* 2237 */       return 27;
/*      */     }
/* 2239 */     if (strFieldName.equals("uWGrade")) {
/* 2240 */       return 28;
/*      */     }
/* 2242 */     if (strFieldName.equals("appGrade")) {
/* 2243 */       return 29;
/*      */     }
/* 2245 */     if (strFieldName.equals("postponeDay")) {
/* 2246 */       return 30;
/*      */     }
/* 2248 */     if (strFieldName.equals("postponeDate")) {
/* 2249 */       return 31;
/*      */     }
/* 2251 */     if (strFieldName.equals("autoUWFlag")) {
/* 2252 */       return 32;
/*      */     }
/* 2254 */     if (strFieldName.equals("state")) {
/* 2255 */       return 33;
/*      */     }
/* 2257 */     if (strFieldName.equals("manageCom")) {
/* 2258 */       return 34;
/*      */     }
/* 2260 */     if (strFieldName.equals("upReportContent")) {
/* 2261 */       return 35;
/*      */     }
/* 2263 */     if (strFieldName.equals("operator")) {
/* 2264 */       return 36;
/*      */     }
/* 2266 */     if (strFieldName.equals("healthFlag")) {
/* 2267 */       return 37;
/*      */     }
/* 2269 */     if (strFieldName.equals("quesFlag")) {
/* 2270 */       return 38;
/*      */     }
/* 2272 */     if (strFieldName.equals("specFlag")) {
/* 2273 */       return 39;
/*      */     }
/* 2275 */     if (strFieldName.equals("addPremFlag")) {
/* 2276 */       return 40;
/*      */     }
/* 2278 */     if (strFieldName.equals("addPremReason")) {
/* 2279 */       return 41;
/*      */     }
/* 2281 */     if (strFieldName.equals("reportFlag")) {
/* 2282 */       return 42;
/*      */     }
/* 2284 */     if (strFieldName.equals("printFlag")) {
/* 2285 */       return 43;
/*      */     }
/* 2287 */     if (strFieldName.equals("printFlag2")) {
/* 2288 */       return 44;
/*      */     }
/* 2290 */     if (strFieldName.equals("changePolFlag")) {
/* 2291 */       return 45;
/*      */     }
/* 2293 */     if (strFieldName.equals("changePolReason")) {
/* 2294 */       return 46;
/*      */     }
/* 2296 */     if (strFieldName.equals("specReason")) {
/* 2297 */       return 47;
/*      */     }
/* 2299 */     if (strFieldName.equals("makeDate")) {
/* 2300 */       return 48;
/*      */     }
/* 2302 */     if (strFieldName.equals("makeTime")) {
/* 2303 */       return 49;
/*      */     }
/* 2305 */     if (strFieldName.equals("modifyDate")) {
/* 2306 */       return 50;
/*      */     }
/* 2308 */     if (strFieldName.equals("modifyTime")) {
/* 2309 */       return 51;
/*      */     }
/* 2311 */     if (strFieldName.equals("sugPassFlag")) {
/* 2312 */       return 52;
/*      */     }
/* 2314 */     if (strFieldName.equals("sugUWIdea")) {
/* 2315 */       return 53;
/*      */     }
/* 2317 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2323 */     String strFieldName = "";
/* 2324 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2326 */       strFieldName = "grpContNo";
/* 2327 */       break;
/*      */     case 1:
/* 2329 */       strFieldName = "contNo";
/* 2330 */       break;
/*      */     case 2:
/* 2332 */       strFieldName = "proposalContNo";
/* 2333 */       break;
/*      */     case 3:
/* 2335 */       strFieldName = "polNo";
/* 2336 */       break;
/*      */     case 4:
/* 2338 */       strFieldName = "proposalNo";
/* 2339 */       break;
/*      */     case 5:
/* 2341 */       strFieldName = "uWNo";
/* 2342 */       break;
/*      */     case 6:
/* 2344 */       strFieldName = "insuredNo";
/* 2345 */       break;
/*      */     case 7:
/* 2347 */       strFieldName = "insuredName";
/* 2348 */       break;
/*      */     case 8:
/* 2350 */       strFieldName = "appntNo";
/* 2351 */       break;
/*      */     case 9:
/* 2353 */       strFieldName = "appntName";
/* 2354 */       break;
/*      */     case 10:
/* 2356 */       strFieldName = "planCode";
/* 2357 */       break;
/*      */     case 11:
/* 2359 */       strFieldName = "planName";
/* 2360 */       break;
/*      */     case 12:
/* 2362 */       strFieldName = "riderName";
/* 2363 */       break;
/*      */     case 13:
/* 2365 */       strFieldName = "riderCode";
/* 2366 */       break;
/*      */     case 14:
/* 2368 */       strFieldName = "uWDid";
/* 2369 */       break;
/*      */     case 15:
/* 2371 */       strFieldName = "faceAmount";
/* 2372 */       break;
/*      */     case 16:
/* 2374 */       strFieldName = "term";
/* 2375 */       break;
/*      */     case 17:
/* 2377 */       strFieldName = "healthDeb";
/* 2378 */       break;
/*      */     case 18:
/* 2380 */       strFieldName = "healthFe";
/* 2381 */       break;
/*      */     case 19:
/* 2383 */       strFieldName = "healthFed";
/* 2384 */       break;
/*      */     case 20:
/* 2386 */       strFieldName = "occupationFactor";
/* 2387 */       break;
/*      */     case 21:
/* 2389 */       strFieldName = "occupationFe";
/* 2390 */       break;
/*      */     case 22:
/* 2392 */       strFieldName = "occupationFed";
/* 2393 */       break;
/*      */     case 23:
/* 2395 */       strFieldName = "exclusions";
/* 2396 */       break;
/*      */     case 24:
/* 2398 */       strFieldName = "declinedCode";
/* 2399 */       break;
/*      */     case 25:
/* 2401 */       strFieldName = "declinedReason";
/* 2402 */       break;
/*      */     case 26:
/* 2404 */       strFieldName = "passFlag";
/* 2405 */       break;
/*      */     case 27:
/* 2407 */       strFieldName = "uWIdea";
/* 2408 */       break;
/*      */     case 28:
/* 2410 */       strFieldName = "uWGrade";
/* 2411 */       break;
/*      */     case 29:
/* 2413 */       strFieldName = "appGrade";
/* 2414 */       break;
/*      */     case 30:
/* 2416 */       strFieldName = "postponeDay";
/* 2417 */       break;
/*      */     case 31:
/* 2419 */       strFieldName = "postponeDate";
/* 2420 */       break;
/*      */     case 32:
/* 2422 */       strFieldName = "autoUWFlag";
/* 2423 */       break;
/*      */     case 33:
/* 2425 */       strFieldName = "state";
/* 2426 */       break;
/*      */     case 34:
/* 2428 */       strFieldName = "manageCom";
/* 2429 */       break;
/*      */     case 35:
/* 2431 */       strFieldName = "upReportContent";
/* 2432 */       break;
/*      */     case 36:
/* 2434 */       strFieldName = "operator";
/* 2435 */       break;
/*      */     case 37:
/* 2437 */       strFieldName = "healthFlag";
/* 2438 */       break;
/*      */     case 38:
/* 2440 */       strFieldName = "quesFlag";
/* 2441 */       break;
/*      */     case 39:
/* 2443 */       strFieldName = "specFlag";
/* 2444 */       break;
/*      */     case 40:
/* 2446 */       strFieldName = "addPremFlag";
/* 2447 */       break;
/*      */     case 41:
/* 2449 */       strFieldName = "addPremReason";
/* 2450 */       break;
/*      */     case 42:
/* 2452 */       strFieldName = "reportFlag";
/* 2453 */       break;
/*      */     case 43:
/* 2455 */       strFieldName = "printFlag";
/* 2456 */       break;
/*      */     case 44:
/* 2458 */       strFieldName = "printFlag2";
/* 2459 */       break;
/*      */     case 45:
/* 2461 */       strFieldName = "changePolFlag";
/* 2462 */       break;
/*      */     case 46:
/* 2464 */       strFieldName = "changePolReason";
/* 2465 */       break;
/*      */     case 47:
/* 2467 */       strFieldName = "specReason";
/* 2468 */       break;
/*      */     case 48:
/* 2470 */       strFieldName = "makeDate";
/* 2471 */       break;
/*      */     case 49:
/* 2473 */       strFieldName = "makeTime";
/* 2474 */       break;
/*      */     case 50:
/* 2476 */       strFieldName = "modifyDate";
/* 2477 */       break;
/*      */     case 51:
/* 2479 */       strFieldName = "modifyTime";
/* 2480 */       break;
/*      */     case 52:
/* 2482 */       strFieldName = "sugPassFlag";
/* 2483 */       break;
/*      */     case 53:
/* 2485 */       strFieldName = "sugUWIdea";
/* 2486 */       break;
/*      */     default:
/* 2488 */       strFieldName = "";
/*      */     }
/* 2490 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2496 */     if (strFieldName.equals("grpContNo")) {
/* 2497 */       return 0;
/*      */     }
/* 2499 */     if (strFieldName.equals("contNo")) {
/* 2500 */       return 0;
/*      */     }
/* 2502 */     if (strFieldName.equals("proposalContNo")) {
/* 2503 */       return 0;
/*      */     }
/* 2505 */     if (strFieldName.equals("polNo")) {
/* 2506 */       return 0;
/*      */     }
/* 2508 */     if (strFieldName.equals("proposalNo")) {
/* 2509 */       return 0;
/*      */     }
/* 2511 */     if (strFieldName.equals("uWNo")) {
/* 2512 */       return 3;
/*      */     }
/* 2514 */     if (strFieldName.equals("insuredNo")) {
/* 2515 */       return 0;
/*      */     }
/* 2517 */     if (strFieldName.equals("insuredName")) {
/* 2518 */       return 0;
/*      */     }
/* 2520 */     if (strFieldName.equals("appntNo")) {
/* 2521 */       return 0;
/*      */     }
/* 2523 */     if (strFieldName.equals("appntName")) {
/* 2524 */       return 0;
/*      */     }
/* 2526 */     if (strFieldName.equals("planCode")) {
/* 2527 */       return 0;
/*      */     }
/* 2529 */     if (strFieldName.equals("planName")) {
/* 2530 */       return 0;
/*      */     }
/* 2532 */     if (strFieldName.equals("riderName")) {
/* 2533 */       return 0;
/*      */     }
/* 2535 */     if (strFieldName.equals("riderCode")) {
/* 2536 */       return 0;
/*      */     }
/* 2538 */     if (strFieldName.equals("uWDid")) {
/* 2539 */       return 0;
/*      */     }
/* 2541 */     if (strFieldName.equals("faceAmount")) {
/* 2542 */       return 0;
/*      */     }
/* 2544 */     if (strFieldName.equals("term")) {
/* 2545 */       return 0;
/*      */     }
/* 2547 */     if (strFieldName.equals("healthDeb")) {
/* 2548 */       return 0;
/*      */     }
/* 2550 */     if (strFieldName.equals("healthFe")) {
/* 2551 */       return 0;
/*      */     }
/* 2553 */     if (strFieldName.equals("healthFed")) {
/* 2554 */       return 0;
/*      */     }
/* 2556 */     if (strFieldName.equals("occupationFactor")) {
/* 2557 */       return 0;
/*      */     }
/* 2559 */     if (strFieldName.equals("occupationFe")) {
/* 2560 */       return 0;
/*      */     }
/* 2562 */     if (strFieldName.equals("occupationFed")) {
/* 2563 */       return 0;
/*      */     }
/* 2565 */     if (strFieldName.equals("exclusions")) {
/* 2566 */       return 0;
/*      */     }
/* 2568 */     if (strFieldName.equals("declinedCode")) {
/* 2569 */       return 0;
/*      */     }
/* 2571 */     if (strFieldName.equals("declinedReason")) {
/* 2572 */       return 0;
/*      */     }
/* 2574 */     if (strFieldName.equals("passFlag")) {
/* 2575 */       return 0;
/*      */     }
/* 2577 */     if (strFieldName.equals("uWIdea")) {
/* 2578 */       return 0;
/*      */     }
/* 2580 */     if (strFieldName.equals("uWGrade")) {
/* 2581 */       return 0;
/*      */     }
/* 2583 */     if (strFieldName.equals("appGrade")) {
/* 2584 */       return 0;
/*      */     }
/* 2586 */     if (strFieldName.equals("postponeDay")) {
/* 2587 */       return 0;
/*      */     }
/* 2589 */     if (strFieldName.equals("postponeDate")) {
/* 2590 */       return 1;
/*      */     }
/* 2592 */     if (strFieldName.equals("autoUWFlag")) {
/* 2593 */       return 0;
/*      */     }
/* 2595 */     if (strFieldName.equals("state")) {
/* 2596 */       return 0;
/*      */     }
/* 2598 */     if (strFieldName.equals("manageCom")) {
/* 2599 */       return 0;
/*      */     }
/* 2601 */     if (strFieldName.equals("upReportContent")) {
/* 2602 */       return 0;
/*      */     }
/* 2604 */     if (strFieldName.equals("operator")) {
/* 2605 */       return 0;
/*      */     }
/* 2607 */     if (strFieldName.equals("healthFlag")) {
/* 2608 */       return 0;
/*      */     }
/* 2610 */     if (strFieldName.equals("quesFlag")) {
/* 2611 */       return 0;
/*      */     }
/* 2613 */     if (strFieldName.equals("specFlag")) {
/* 2614 */       return 0;
/*      */     }
/* 2616 */     if (strFieldName.equals("addPremFlag")) {
/* 2617 */       return 0;
/*      */     }
/* 2619 */     if (strFieldName.equals("addPremReason")) {
/* 2620 */       return 0;
/*      */     }
/* 2622 */     if (strFieldName.equals("reportFlag")) {
/* 2623 */       return 0;
/*      */     }
/* 2625 */     if (strFieldName.equals("printFlag")) {
/* 2626 */       return 0;
/*      */     }
/* 2628 */     if (strFieldName.equals("printFlag2")) {
/* 2629 */       return 0;
/*      */     }
/* 2631 */     if (strFieldName.equals("changePolFlag")) {
/* 2632 */       return 0;
/*      */     }
/* 2634 */     if (strFieldName.equals("changePolReason")) {
/* 2635 */       return 0;
/*      */     }
/* 2637 */     if (strFieldName.equals("specReason")) {
/* 2638 */       return 0;
/*      */     }
/* 2640 */     if (strFieldName.equals("makeDate")) {
/* 2641 */       return 1;
/*      */     }
/* 2643 */     if (strFieldName.equals("makeTime")) {
/* 2644 */       return 0;
/*      */     }
/* 2646 */     if (strFieldName.equals("modifyDate")) {
/* 2647 */       return 1;
/*      */     }
/* 2649 */     if (strFieldName.equals("modifyTime")) {
/* 2650 */       return 0;
/*      */     }
/* 2652 */     if (strFieldName.equals("sugPassFlag")) {
/* 2653 */       return 0;
/*      */     }
/* 2655 */     if (strFieldName.equals("sugUWIdea")) {
/* 2656 */       return 0;
/*      */     }
/* 2658 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 2664 */     int nFieldType = -1;
/* 2665 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2667 */       nFieldType = 0;
/* 2668 */       break;
/*      */     case 1:
/* 2670 */       nFieldType = 0;
/* 2671 */       break;
/*      */     case 2:
/* 2673 */       nFieldType = 0;
/* 2674 */       break;
/*      */     case 3:
/* 2676 */       nFieldType = 0;
/* 2677 */       break;
/*      */     case 4:
/* 2679 */       nFieldType = 0;
/* 2680 */       break;
/*      */     case 5:
/* 2682 */       nFieldType = 3;
/* 2683 */       break;
/*      */     case 6:
/* 2685 */       nFieldType = 0;
/* 2686 */       break;
/*      */     case 7:
/* 2688 */       nFieldType = 0;
/* 2689 */       break;
/*      */     case 8:
/* 2691 */       nFieldType = 0;
/* 2692 */       break;
/*      */     case 9:
/* 2694 */       nFieldType = 0;
/* 2695 */       break;
/*      */     case 10:
/* 2697 */       nFieldType = 0;
/* 2698 */       break;
/*      */     case 11:
/* 2700 */       nFieldType = 0;
/* 2701 */       break;
/*      */     case 12:
/* 2703 */       nFieldType = 0;
/* 2704 */       break;
/*      */     case 13:
/* 2706 */       nFieldType = 0;
/* 2707 */       break;
/*      */     case 14:
/* 2709 */       nFieldType = 0;
/* 2710 */       break;
/*      */     case 15:
/* 2712 */       nFieldType = 0;
/* 2713 */       break;
/*      */     case 16:
/* 2715 */       nFieldType = 0;
/* 2716 */       break;
/*      */     case 17:
/* 2718 */       nFieldType = 0;
/* 2719 */       break;
/*      */     case 18:
/* 2721 */       nFieldType = 0;
/* 2722 */       break;
/*      */     case 19:
/* 2724 */       nFieldType = 0;
/* 2725 */       break;
/*      */     case 20:
/* 2727 */       nFieldType = 0;
/* 2728 */       break;
/*      */     case 21:
/* 2730 */       nFieldType = 0;
/* 2731 */       break;
/*      */     case 22:
/* 2733 */       nFieldType = 0;
/* 2734 */       break;
/*      */     case 23:
/* 2736 */       nFieldType = 0;
/* 2737 */       break;
/*      */     case 24:
/* 2739 */       nFieldType = 0;
/* 2740 */       break;
/*      */     case 25:
/* 2742 */       nFieldType = 0;
/* 2743 */       break;
/*      */     case 26:
/* 2745 */       nFieldType = 0;
/* 2746 */       break;
/*      */     case 27:
/* 2748 */       nFieldType = 0;
/* 2749 */       break;
/*      */     case 28:
/* 2751 */       nFieldType = 0;
/* 2752 */       break;
/*      */     case 29:
/* 2754 */       nFieldType = 0;
/* 2755 */       break;
/*      */     case 30:
/* 2757 */       nFieldType = 0;
/* 2758 */       break;
/*      */     case 31:
/* 2760 */       nFieldType = 1;
/* 2761 */       break;
/*      */     case 32:
/* 2763 */       nFieldType = 0;
/* 2764 */       break;
/*      */     case 33:
/* 2766 */       nFieldType = 0;
/* 2767 */       break;
/*      */     case 34:
/* 2769 */       nFieldType = 0;
/* 2770 */       break;
/*      */     case 35:
/* 2772 */       nFieldType = 0;
/* 2773 */       break;
/*      */     case 36:
/* 2775 */       nFieldType = 0;
/* 2776 */       break;
/*      */     case 37:
/* 2778 */       nFieldType = 0;
/* 2779 */       break;
/*      */     case 38:
/* 2781 */       nFieldType = 0;
/* 2782 */       break;
/*      */     case 39:
/* 2784 */       nFieldType = 0;
/* 2785 */       break;
/*      */     case 40:
/* 2787 */       nFieldType = 0;
/* 2788 */       break;
/*      */     case 41:
/* 2790 */       nFieldType = 0;
/* 2791 */       break;
/*      */     case 42:
/* 2793 */       nFieldType = 0;
/* 2794 */       break;
/*      */     case 43:
/* 2796 */       nFieldType = 0;
/* 2797 */       break;
/*      */     case 44:
/* 2799 */       nFieldType = 0;
/* 2800 */       break;
/*      */     case 45:
/* 2802 */       nFieldType = 0;
/* 2803 */       break;
/*      */     case 46:
/* 2805 */       nFieldType = 0;
/* 2806 */       break;
/*      */     case 47:
/* 2808 */       nFieldType = 0;
/* 2809 */       break;
/*      */     case 48:
/* 2811 */       nFieldType = 1;
/* 2812 */       break;
/*      */     case 49:
/* 2814 */       nFieldType = 0;
/* 2815 */       break;
/*      */     case 50:
/* 2817 */       nFieldType = 1;
/* 2818 */       break;
/*      */     case 51:
/* 2820 */       nFieldType = 0;
/* 2821 */       break;
/*      */     case 52:
/* 2823 */       nFieldType = 0;
/* 2824 */       break;
/*      */     case 53:
/* 2826 */       nFieldType = 0;
/* 2827 */       break;
/*      */     default:
/* 2829 */       nFieldType = -1;
/*      */     }
/* 2831 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPUWMasterSchema
 * JD-Core Version:    0.6.0
 */