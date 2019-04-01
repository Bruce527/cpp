/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPPolDB;
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
/*      */ public class LNPPolSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String grpContNo;
/*      */   private String grpPolNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String polNo;
/*      */   private String proposalNo;
/*      */   private String prtNo;
/*      */   private String contType;
/*      */   private String polTypeFlag;
/*      */   private String mainPolNo;
/*      */   private String masterPolNo;
/*      */   private String kindCode;
/*      */   private String riskCode;
/*      */   private String riskVersion;
/*      */   private String manageCom;
/*      */   private String agentCom;
/*      */   private String agentType;
/*      */   private String agentCode;
/*      */   private String agentGroup;
/*      */   private String agentGroup1;
/*      */   private String agentCode1;
/*      */   private String saleChnl;
/*      */   private String handler;
/*      */   private String insuredNo;
/*      */   private String insuredId;
/*      */   private String insuredName;
/*      */   private String insuredSex;
/*      */   private Date insuredBirthday;
/*      */   private int insuredAppAge;
/*      */   private int insuredPeoples;
/*      */   private String occupationType;
/*      */   private String appntNo;
/*      */   private String appntName;
/*      */   private Date cValiDate;
/*      */   private String signCom;
/*      */   private Date signDate;
/*      */   private String signTime;
/*      */   private Date firstPayDate;
/*      */   private Date payEndDate;
/*      */   private Date paytoDate;
/*      */   private Date getStartDate;
/*      */   private Date endDate;
/*      */   private Date acciEndDate;
/*      */   private String getYearFlag;
/*      */   private int getYear;
/*      */   private String payEndYearFlag;
/*      */   private int payEndYear;
/*      */   private String insuYearFlag;
/*      */   private int insuYear;
/*      */   private String acciYearFlag;
/*      */   private int acciYear;
/*      */   private String getStartType;
/*      */   private String specifyValiDate;
/*      */   private String payMode;
/*      */   private String payLocation;
/*      */   private int payIntv;
/*      */   private int payYears;
/*      */   private int years;
/*      */   private double manageFeeRate;
/*      */   private double floatRate;
/*      */   private double premRate;
/*      */   private String premToAmnt;
/*      */   private double mult;
/*      */   private double standPrem;
/*      */   private double prem;
/*      */   private double sumPrem;
/*      */   private double amnt;
/*      */   private double riskAmnt;
/*      */   private double leavingMoney;
/*      */   private int endorseTimes;
/*      */   private int claimTimes;
/*      */   private int liveTimes;
/*      */   private int renewCount;
/*      */   private Date lastGetDate;
/*      */   private Date lastLoanDate;
/*      */   private Date lastRegetDate;
/*      */   private Date lastEdorDate;
/*      */   private Date lastRevDate;
/*      */   private String rnewFlag;
/*      */   private String stopFlag;
/*      */   private String expiryFlag;
/*      */   private String autoPayFlag;
/*      */   private String interestDifFlag;
/*      */   private String subFlag;
/*      */   private String bnfFlag;
/*      */   private String healthCheckFlag;
/*      */   private String impartFlag;
/*      */   private String reinsureFlag;
/*      */   private String agentPayFlag;
/*      */   private String agentGetFlag;
/*      */   private String liveGetMode;
/*      */   private String deadGetMode;
/*      */   private String bonusGetMode;
/*      */   private String deadAmntType;
/*      */   private double topUpPrem;
/*      */   private String bonusMan;
/*      */   private String deadFlag;
/*      */   private String smokeFlag;
/*      */   private String remark;
/*      */   private String approveFlag;
/*      */   private String approveCode;
/*      */   private Date approveDate;
/*      */   private String approveTime;
/*      */   private String uWFlag;
/*      */   private String uWCode;
/*      */   private Date uWDate;
/*      */   private String uWTime;
/*      */   private Date polApplyDate;
/*      */   private String appFlag;
/*      */   private String saleChnlDetail;
/*      */   private String polState;
/*      */   private String standbyFlag1;
/*      */   private String standbyFlag2;
/*      */   private String standbyFlag3;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 119;
/*      */   private static String[] PK;
/*  265 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPPolSchema()
/*      */   {
/*  272 */     this.mErrors = new CErrors();
/*      */ 
/*  274 */     String[] pk = new String[1];
/*  275 */     pk[0] = "PolNo";
/*      */ 
/*  277 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  284 */     LNPPolSchema cloned = (LNPPolSchema)super.clone();
/*  285 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  286 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  287 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  293 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo()
/*      */   {
/*  298 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  302 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getGrpPolNo() {
/*  306 */     return this.grpPolNo;
/*      */   }
/*      */ 
/*      */   public void setGrpPolNo(String aGrpPolNo) {
/*  310 */     this.grpPolNo = aGrpPolNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  314 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  318 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  322 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  326 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public String getPolNo() {
/*  330 */     return this.polNo;
/*      */   }
/*      */ 
/*      */   public void setPolNo(String aPolNo) {
/*  334 */     this.polNo = aPolNo;
/*      */   }
/*      */ 
/*      */   public String getProposalNo() {
/*  338 */     return this.proposalNo;
/*      */   }
/*      */ 
/*      */   public void setProposalNo(String aProposalNo) {
/*  342 */     this.proposalNo = aProposalNo;
/*      */   }
/*      */ 
/*      */   public String getPrtNo() {
/*  346 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setPrtNo(String aPrtNo) {
/*  350 */     this.prtNo = aPrtNo;
/*      */   }
/*      */ 
/*      */   public String getContType() {
/*  354 */     return this.contType;
/*      */   }
/*      */ 
/*      */   public void setContType(String aContType) {
/*  358 */     this.contType = aContType;
/*      */   }
/*      */ 
/*      */   public String getPolTypeFlag() {
/*  362 */     return this.polTypeFlag;
/*      */   }
/*      */ 
/*      */   public void setPolTypeFlag(String aPolTypeFlag) {
/*  366 */     this.polTypeFlag = aPolTypeFlag;
/*      */   }
/*      */ 
/*      */   public String getMainPolNo() {
/*  370 */     return this.mainPolNo;
/*      */   }
/*      */ 
/*      */   public void setMainPolNo(String aMainPolNo) {
/*  374 */     this.mainPolNo = aMainPolNo;
/*      */   }
/*      */ 
/*      */   public String getMasterPolNo() {
/*  378 */     return this.masterPolNo;
/*      */   }
/*      */ 
/*      */   public void setMasterPolNo(String aMasterPolNo) {
/*  382 */     this.masterPolNo = aMasterPolNo;
/*      */   }
/*      */ 
/*      */   public String getKindCode() {
/*  386 */     return this.kindCode;
/*      */   }
/*      */ 
/*      */   public void setKindCode(String aKindCode) {
/*  390 */     this.kindCode = aKindCode;
/*      */   }
/*      */ 
/*      */   public String getRiskCode() {
/*  394 */     return this.riskCode;
/*      */   }
/*      */ 
/*      */   public void setRiskCode(String aRiskCode) {
/*  398 */     this.riskCode = aRiskCode;
/*      */   }
/*      */ 
/*      */   public String getRiskVersion() {
/*  402 */     return this.riskVersion;
/*      */   }
/*      */ 
/*      */   public void setRiskVersion(String aRiskVersion) {
/*  406 */     this.riskVersion = aRiskVersion;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  410 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  414 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getAgentCom() {
/*  418 */     return this.agentCom;
/*      */   }
/*      */ 
/*      */   public void setAgentCom(String aAgentCom) {
/*  422 */     this.agentCom = aAgentCom;
/*      */   }
/*      */ 
/*      */   public String getAgentType() {
/*  426 */     return this.agentType;
/*      */   }
/*      */ 
/*      */   public void setAgentType(String aAgentType) {
/*  430 */     this.agentType = aAgentType;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  434 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  438 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getAgentGroup() {
/*  442 */     return this.agentGroup;
/*      */   }
/*      */ 
/*      */   public void setAgentGroup(String aAgentGroup) {
/*  446 */     this.agentGroup = aAgentGroup;
/*      */   }
/*      */ 
/*      */   public String getAgentGroup1() {
/*  450 */     return this.agentGroup1;
/*      */   }
/*      */ 
/*      */   public void setAgentGroup1(String aAgentGroup1) {
/*  454 */     this.agentGroup1 = aAgentGroup1;
/*      */   }
/*      */ 
/*      */   public String getAgentCode1() {
/*  458 */     return this.agentCode1;
/*      */   }
/*      */ 
/*      */   public void setAgentCode1(String aAgentCode1) {
/*  462 */     this.agentCode1 = aAgentCode1;
/*      */   }
/*      */ 
/*      */   public String getSaleChnl() {
/*  466 */     return this.saleChnl;
/*      */   }
/*      */ 
/*      */   public void setSaleChnl(String aSaleChnl) {
/*  470 */     this.saleChnl = aSaleChnl;
/*      */   }
/*      */ 
/*      */   public String getHandler() {
/*  474 */     return this.handler;
/*      */   }
/*      */ 
/*      */   public void setHandler(String aHandler) {
/*  478 */     this.handler = aHandler;
/*      */   }
/*      */ 
/*      */   public String getInsuredNo() {
/*  482 */     return this.insuredNo;
/*      */   }
/*      */ 
/*      */   public void setInsuredNo(String aInsuredNo) {
/*  486 */     this.insuredNo = aInsuredNo;
/*      */   }
/*      */ 
/*      */   public String getInsuredId() {
/*  490 */     return this.insuredId;
/*      */   }
/*      */ 
/*      */   public void setInsuredId(String aInsuredId) {
/*  494 */     this.insuredId = aInsuredId;
/*      */   }
/*      */ 
/*      */   public String getInsuredName() {
/*  498 */     return this.insuredName;
/*      */   }
/*      */ 
/*      */   public void setInsuredName(String aInsuredName) {
/*  502 */     this.insuredName = aInsuredName;
/*      */   }
/*      */ 
/*      */   public String getInsuredSex() {
/*  506 */     return this.insuredSex;
/*      */   }
/*      */ 
/*      */   public void setInsuredSex(String aInsuredSex) {
/*  510 */     this.insuredSex = aInsuredSex;
/*      */   }
/*      */ 
/*      */   public String getInsuredBirthday() {
/*  514 */     if (this.insuredBirthday != null) {
/*  515 */       return this.fDate.getString(this.insuredBirthday);
/*      */     }
/*  517 */     return null;
/*      */   }
/*      */ 
/*      */   public void setInsuredBirthday(Date aInsuredBirthday) {
/*  521 */     this.insuredBirthday = aInsuredBirthday;
/*      */   }
/*      */ 
/*      */   public void setInsuredBirthday(String aInsuredBirthday) {
/*  525 */     if ((aInsuredBirthday != null) && (!aInsuredBirthday.equals("")))
/*      */     {
/*  527 */       this.insuredBirthday = this.fDate.getDate(aInsuredBirthday);
/*      */     }
/*      */     else
/*  530 */       this.insuredBirthday = null;
/*      */   }
/*      */ 
/*      */   public int getInsuredAppAge()
/*      */   {
/*  535 */     return this.insuredAppAge;
/*      */   }
/*      */ 
/*      */   public void setInsuredAppAge(int aInsuredAppAge) {
/*  539 */     this.insuredAppAge = aInsuredAppAge;
/*      */   }
/*      */ 
/*      */   public void setInsuredAppAge(String aInsuredAppAge) {
/*  543 */     if ((aInsuredAppAge != null) && (!aInsuredAppAge.equals("")))
/*      */     {
/*  545 */       Integer tInteger = new Integer(aInsuredAppAge);
/*  546 */       int i = tInteger.intValue();
/*  547 */       this.insuredAppAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInsuredPeoples()
/*      */   {
/*  553 */     return this.insuredPeoples;
/*      */   }
/*      */ 
/*      */   public void setInsuredPeoples(int aInsuredPeoples) {
/*  557 */     this.insuredPeoples = aInsuredPeoples;
/*      */   }
/*      */ 
/*      */   public void setInsuredPeoples(String aInsuredPeoples) {
/*  561 */     if ((aInsuredPeoples != null) && (!aInsuredPeoples.equals("")))
/*      */     {
/*  563 */       Integer tInteger = new Integer(aInsuredPeoples);
/*  564 */       int i = tInteger.intValue();
/*  565 */       this.insuredPeoples = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOccupationType()
/*      */   {
/*  571 */     return this.occupationType;
/*      */   }
/*      */ 
/*      */   public void setOccupationType(String aOccupationType) {
/*  575 */     this.occupationType = aOccupationType;
/*      */   }
/*      */ 
/*      */   public String getAppntNo() {
/*  579 */     return this.appntNo;
/*      */   }
/*      */ 
/*      */   public void setAppntNo(String aAppntNo) {
/*  583 */     this.appntNo = aAppntNo;
/*      */   }
/*      */ 
/*      */   public String getAppntName() {
/*  587 */     return this.appntName;
/*      */   }
/*      */ 
/*      */   public void setAppntName(String aAppntName) {
/*  591 */     this.appntName = aAppntName;
/*      */   }
/*      */ 
/*      */   public String getCValiDate() {
/*  595 */     if (this.cValiDate != null) {
/*  596 */       return this.fDate.getString(this.cValiDate);
/*      */     }
/*  598 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCValiDate(Date aCValiDate) {
/*  602 */     this.cValiDate = aCValiDate;
/*      */   }
/*      */ 
/*      */   public void setCValiDate(String aCValiDate) {
/*  606 */     if ((aCValiDate != null) && (!aCValiDate.equals("")))
/*      */     {
/*  608 */       this.cValiDate = this.fDate.getDate(aCValiDate);
/*      */     }
/*      */     else
/*  611 */       this.cValiDate = null;
/*      */   }
/*      */ 
/*      */   public String getSignCom()
/*      */   {
/*  616 */     return this.signCom;
/*      */   }
/*      */ 
/*      */   public void setSignCom(String aSignCom) {
/*  620 */     this.signCom = aSignCom;
/*      */   }
/*      */ 
/*      */   public String getSignDate() {
/*  624 */     if (this.signDate != null) {
/*  625 */       return this.fDate.getString(this.signDate);
/*      */     }
/*  627 */     return null;
/*      */   }
/*      */ 
/*      */   public void setSignDate(Date aSignDate) {
/*  631 */     this.signDate = aSignDate;
/*      */   }
/*      */ 
/*      */   public void setSignDate(String aSignDate) {
/*  635 */     if ((aSignDate != null) && (!aSignDate.equals("")))
/*      */     {
/*  637 */       this.signDate = this.fDate.getDate(aSignDate);
/*      */     }
/*      */     else
/*  640 */       this.signDate = null;
/*      */   }
/*      */ 
/*      */   public String getSignTime()
/*      */   {
/*  645 */     return this.signTime;
/*      */   }
/*      */ 
/*      */   public void setSignTime(String aSignTime) {
/*  649 */     this.signTime = aSignTime;
/*      */   }
/*      */ 
/*      */   public String getFirstPayDate() {
/*  653 */     if (this.firstPayDate != null) {
/*  654 */       return this.fDate.getString(this.firstPayDate);
/*      */     }
/*  656 */     return null;
/*      */   }
/*      */ 
/*      */   public void setFirstPayDate(Date aFirstPayDate) {
/*  660 */     this.firstPayDate = aFirstPayDate;
/*      */   }
/*      */ 
/*      */   public void setFirstPayDate(String aFirstPayDate) {
/*  664 */     if ((aFirstPayDate != null) && (!aFirstPayDate.equals("")))
/*      */     {
/*  666 */       this.firstPayDate = this.fDate.getDate(aFirstPayDate);
/*      */     }
/*      */     else
/*  669 */       this.firstPayDate = null;
/*      */   }
/*      */ 
/*      */   public String getPayEndDate()
/*      */   {
/*  674 */     if (this.payEndDate != null) {
/*  675 */       return this.fDate.getString(this.payEndDate);
/*      */     }
/*  677 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPayEndDate(Date aPayEndDate) {
/*  681 */     this.payEndDate = aPayEndDate;
/*      */   }
/*      */ 
/*      */   public void setPayEndDate(String aPayEndDate) {
/*  685 */     if ((aPayEndDate != null) && (!aPayEndDate.equals("")))
/*      */     {
/*  687 */       this.payEndDate = this.fDate.getDate(aPayEndDate);
/*      */     }
/*      */     else
/*  690 */       this.payEndDate = null;
/*      */   }
/*      */ 
/*      */   public String getPaytoDate()
/*      */   {
/*  695 */     if (this.paytoDate != null) {
/*  696 */       return this.fDate.getString(this.paytoDate);
/*      */     }
/*  698 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPaytoDate(Date aPaytoDate) {
/*  702 */     this.paytoDate = aPaytoDate;
/*      */   }
/*      */ 
/*      */   public void setPaytoDate(String aPaytoDate) {
/*  706 */     if ((aPaytoDate != null) && (!aPaytoDate.equals("")))
/*      */     {
/*  708 */       this.paytoDate = this.fDate.getDate(aPaytoDate);
/*      */     }
/*      */     else
/*  711 */       this.paytoDate = null;
/*      */   }
/*      */ 
/*      */   public String getGetStartDate()
/*      */   {
/*  716 */     if (this.getStartDate != null) {
/*  717 */       return this.fDate.getString(this.getStartDate);
/*      */     }
/*  719 */     return null;
/*      */   }
/*      */ 
/*      */   public void setGetStartDate(Date aGetStartDate) {
/*  723 */     this.getStartDate = aGetStartDate;
/*      */   }
/*      */ 
/*      */   public void setGetStartDate(String aGetStartDate) {
/*  727 */     if ((aGetStartDate != null) && (!aGetStartDate.equals("")))
/*      */     {
/*  729 */       this.getStartDate = this.fDate.getDate(aGetStartDate);
/*      */     }
/*      */     else
/*  732 */       this.getStartDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  737 */     if (this.endDate != null) {
/*  738 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  740 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  744 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  748 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  750 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  753 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getAcciEndDate()
/*      */   {
/*  758 */     if (this.acciEndDate != null) {
/*  759 */       return this.fDate.getString(this.acciEndDate);
/*      */     }
/*  761 */     return null;
/*      */   }
/*      */ 
/*      */   public void setAcciEndDate(Date aAcciEndDate) {
/*  765 */     this.acciEndDate = aAcciEndDate;
/*      */   }
/*      */ 
/*      */   public void setAcciEndDate(String aAcciEndDate) {
/*  769 */     if ((aAcciEndDate != null) && (!aAcciEndDate.equals("")))
/*      */     {
/*  771 */       this.acciEndDate = this.fDate.getDate(aAcciEndDate);
/*      */     }
/*      */     else
/*  774 */       this.acciEndDate = null;
/*      */   }
/*      */ 
/*      */   public String getGetYearFlag()
/*      */   {
/*  779 */     return this.getYearFlag;
/*      */   }
/*      */ 
/*      */   public void setGetYearFlag(String aGetYearFlag) {
/*  783 */     this.getYearFlag = aGetYearFlag;
/*      */   }
/*      */ 
/*      */   public int getGetYear() {
/*  787 */     return this.getYear;
/*      */   }
/*      */ 
/*      */   public void setGetYear(int aGetYear) {
/*  791 */     this.getYear = aGetYear;
/*      */   }
/*      */ 
/*      */   public void setGetYear(String aGetYear) {
/*  795 */     if ((aGetYear != null) && (!aGetYear.equals("")))
/*      */     {
/*  797 */       Integer tInteger = new Integer(aGetYear);
/*  798 */       int i = tInteger.intValue();
/*  799 */       this.getYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPayEndYearFlag()
/*      */   {
/*  805 */     return this.payEndYearFlag;
/*      */   }
/*      */ 
/*      */   public void setPayEndYearFlag(String aPayEndYearFlag) {
/*  809 */     this.payEndYearFlag = aPayEndYearFlag;
/*      */   }
/*      */ 
/*      */   public int getPayEndYear() {
/*  813 */     return this.payEndYear;
/*      */   }
/*      */ 
/*      */   public void setPayEndYear(int aPayEndYear) {
/*  817 */     this.payEndYear = aPayEndYear;
/*      */   }
/*      */ 
/*      */   public void setPayEndYear(String aPayEndYear) {
/*  821 */     if ((aPayEndYear != null) && (!aPayEndYear.equals("")))
/*      */     {
/*  823 */       Integer tInteger = new Integer(aPayEndYear);
/*  824 */       int i = tInteger.intValue();
/*  825 */       this.payEndYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getInsuYearFlag()
/*      */   {
/*  831 */     return this.insuYearFlag;
/*      */   }
/*      */ 
/*      */   public void setInsuYearFlag(String aInsuYearFlag) {
/*  835 */     this.insuYearFlag = aInsuYearFlag;
/*      */   }
/*      */ 
/*      */   public int getInsuYear() {
/*  839 */     return this.insuYear;
/*      */   }
/*      */ 
/*      */   public void setInsuYear(int aInsuYear) {
/*  843 */     this.insuYear = aInsuYear;
/*      */   }
/*      */ 
/*      */   public void setInsuYear(String aInsuYear) {
/*  847 */     if ((aInsuYear != null) && (!aInsuYear.equals("")))
/*      */     {
/*  849 */       Integer tInteger = new Integer(aInsuYear);
/*  850 */       int i = tInteger.intValue();
/*  851 */       this.insuYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getAcciYearFlag()
/*      */   {
/*  857 */     return this.acciYearFlag;
/*      */   }
/*      */ 
/*      */   public void setAcciYearFlag(String aAcciYearFlag) {
/*  861 */     this.acciYearFlag = aAcciYearFlag;
/*      */   }
/*      */ 
/*      */   public int getAcciYear() {
/*  865 */     return this.acciYear;
/*      */   }
/*      */ 
/*      */   public void setAcciYear(int aAcciYear) {
/*  869 */     this.acciYear = aAcciYear;
/*      */   }
/*      */ 
/*      */   public void setAcciYear(String aAcciYear) {
/*  873 */     if ((aAcciYear != null) && (!aAcciYear.equals("")))
/*      */     {
/*  875 */       Integer tInteger = new Integer(aAcciYear);
/*  876 */       int i = tInteger.intValue();
/*  877 */       this.acciYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getGetStartType()
/*      */   {
/*  883 */     return this.getStartType;
/*      */   }
/*      */ 
/*      */   public void setGetStartType(String aGetStartType) {
/*  887 */     this.getStartType = aGetStartType;
/*      */   }
/*      */ 
/*      */   public String getSpecifyValiDate() {
/*  891 */     return this.specifyValiDate;
/*      */   }
/*      */ 
/*      */   public void setSpecifyValiDate(String aSpecifyValiDate) {
/*  895 */     this.specifyValiDate = aSpecifyValiDate;
/*      */   }
/*      */ 
/*      */   public String getPayMode() {
/*  899 */     return this.payMode;
/*      */   }
/*      */ 
/*      */   public void setPayMode(String aPayMode) {
/*  903 */     this.payMode = aPayMode;
/*      */   }
/*      */ 
/*      */   public String getPayLocation() {
/*  907 */     return this.payLocation;
/*      */   }
/*      */ 
/*      */   public void setPayLocation(String aPayLocation) {
/*  911 */     this.payLocation = aPayLocation;
/*      */   }
/*      */ 
/*      */   public int getPayIntv() {
/*  915 */     return this.payIntv;
/*      */   }
/*      */ 
/*      */   public void setPayIntv(int aPayIntv) {
/*  919 */     this.payIntv = aPayIntv;
/*      */   }
/*      */ 
/*      */   public void setPayIntv(String aPayIntv) {
/*  923 */     if ((aPayIntv != null) && (!aPayIntv.equals("")))
/*      */     {
/*  925 */       Integer tInteger = new Integer(aPayIntv);
/*  926 */       int i = tInteger.intValue();
/*  927 */       this.payIntv = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getPayYears()
/*      */   {
/*  933 */     return this.payYears;
/*      */   }
/*      */ 
/*      */   public void setPayYears(int aPayYears) {
/*  937 */     this.payYears = aPayYears;
/*      */   }
/*      */ 
/*      */   public void setPayYears(String aPayYears) {
/*  941 */     if ((aPayYears != null) && (!aPayYears.equals("")))
/*      */     {
/*  943 */       Integer tInteger = new Integer(aPayYears);
/*  944 */       int i = tInteger.intValue();
/*  945 */       this.payYears = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getYears()
/*      */   {
/*  951 */     return this.years;
/*      */   }
/*      */ 
/*      */   public void setYears(int aYears) {
/*  955 */     this.years = aYears;
/*      */   }
/*      */ 
/*      */   public void setYears(String aYears) {
/*  959 */     if ((aYears != null) && (!aYears.equals("")))
/*      */     {
/*  961 */       Integer tInteger = new Integer(aYears);
/*  962 */       int i = tInteger.intValue();
/*  963 */       this.years = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getManageFeeRate()
/*      */   {
/*  969 */     return this.manageFeeRate;
/*      */   }
/*      */ 
/*      */   public void setManageFeeRate(double aManageFeeRate) {
/*  973 */     this.manageFeeRate = aManageFeeRate;
/*      */   }
/*      */ 
/*      */   public void setManageFeeRate(String aManageFeeRate) {
/*  977 */     if ((aManageFeeRate != null) && (!aManageFeeRate.equals("")))
/*      */     {
/*  979 */       Double tDouble = new Double(aManageFeeRate);
/*  980 */       double d = tDouble.doubleValue();
/*  981 */       this.manageFeeRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getFloatRate()
/*      */   {
/*  987 */     return this.floatRate;
/*      */   }
/*      */ 
/*      */   public void setFloatRate(double aFloatRate) {
/*  991 */     this.floatRate = aFloatRate;
/*      */   }
/*      */ 
/*      */   public void setFloatRate(String aFloatRate) {
/*  995 */     if ((aFloatRate != null) && (!aFloatRate.equals("")))
/*      */     {
/*  997 */       Double tDouble = new Double(aFloatRate);
/*  998 */       double d = tDouble.doubleValue();
/*  999 */       this.floatRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getPremRate()
/*      */   {
/* 1005 */     return this.premRate;
/*      */   }
/*      */ 
/*      */   public void setPremRate(double aPremRate) {
/* 1009 */     this.premRate = aPremRate;
/*      */   }
/*      */ 
/*      */   public void setPremRate(String aPremRate) {
/* 1013 */     if ((aPremRate != null) && (!aPremRate.equals("")))
/*      */     {
/* 1015 */       Double tDouble = new Double(aPremRate);
/* 1016 */       double d = tDouble.doubleValue();
/* 1017 */       this.premRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPremToAmnt()
/*      */   {
/* 1023 */     return this.premToAmnt;
/*      */   }
/*      */ 
/*      */   public void setPremToAmnt(String aPremToAmnt) {
/* 1027 */     this.premToAmnt = aPremToAmnt;
/*      */   }
/*      */ 
/*      */   public double getMult() {
/* 1031 */     return this.mult;
/*      */   }
/*      */ 
/*      */   public void setMult(double aMult) {
/* 1035 */     this.mult = aMult;
/*      */   }
/*      */ 
/*      */   public void setMult(String aMult) {
/* 1039 */     if ((aMult != null) && (!aMult.equals("")))
/*      */     {
/* 1041 */       Double tDouble = new Double(aMult);
/* 1042 */       double d = tDouble.doubleValue();
/* 1043 */       this.mult = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getStandPrem()
/*      */   {
/* 1049 */     return this.standPrem;
/*      */   }
/*      */ 
/*      */   public void setStandPrem(double aStandPrem) {
/* 1053 */     this.standPrem = aStandPrem;
/*      */   }
/*      */ 
/*      */   public void setStandPrem(String aStandPrem) {
/* 1057 */     if ((aStandPrem != null) && (!aStandPrem.equals("")))
/*      */     {
/* 1059 */       Double tDouble = new Double(aStandPrem);
/* 1060 */       double d = tDouble.doubleValue();
/* 1061 */       this.standPrem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getPrem()
/*      */   {
/* 1067 */     return this.prem;
/*      */   }
/*      */ 
/*      */   public void setPrem(double aPrem) {
/* 1071 */     this.prem = aPrem;
/*      */   }
/*      */ 
/*      */   public void setPrem(String aPrem) {
/* 1075 */     if ((aPrem != null) && (!aPrem.equals("")))
/*      */     {
/* 1077 */       Double tDouble = new Double(aPrem);
/* 1078 */       double d = tDouble.doubleValue();
/* 1079 */       this.prem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSumPrem()
/*      */   {
/* 1085 */     return this.sumPrem;
/*      */   }
/*      */ 
/*      */   public void setSumPrem(double aSumPrem) {
/* 1089 */     this.sumPrem = aSumPrem;
/*      */   }
/*      */ 
/*      */   public void setSumPrem(String aSumPrem) {
/* 1093 */     if ((aSumPrem != null) && (!aSumPrem.equals("")))
/*      */     {
/* 1095 */       Double tDouble = new Double(aSumPrem);
/* 1096 */       double d = tDouble.doubleValue();
/* 1097 */       this.sumPrem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAmnt()
/*      */   {
/* 1103 */     return this.amnt;
/*      */   }
/*      */ 
/*      */   public void setAmnt(double aAmnt) {
/* 1107 */     this.amnt = aAmnt;
/*      */   }
/*      */ 
/*      */   public void setAmnt(String aAmnt) {
/* 1111 */     if ((aAmnt != null) && (!aAmnt.equals("")))
/*      */     {
/* 1113 */       Double tDouble = new Double(aAmnt);
/* 1114 */       double d = tDouble.doubleValue();
/* 1115 */       this.amnt = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getRiskAmnt()
/*      */   {
/* 1121 */     return this.riskAmnt;
/*      */   }
/*      */ 
/*      */   public void setRiskAmnt(double aRiskAmnt) {
/* 1125 */     this.riskAmnt = aRiskAmnt;
/*      */   }
/*      */ 
/*      */   public void setRiskAmnt(String aRiskAmnt) {
/* 1129 */     if ((aRiskAmnt != null) && (!aRiskAmnt.equals("")))
/*      */     {
/* 1131 */       Double tDouble = new Double(aRiskAmnt);
/* 1132 */       double d = tDouble.doubleValue();
/* 1133 */       this.riskAmnt = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLeavingMoney()
/*      */   {
/* 1139 */     return this.leavingMoney;
/*      */   }
/*      */ 
/*      */   public void setLeavingMoney(double aLeavingMoney) {
/* 1143 */     this.leavingMoney = aLeavingMoney;
/*      */   }
/*      */ 
/*      */   public void setLeavingMoney(String aLeavingMoney) {
/* 1147 */     if ((aLeavingMoney != null) && (!aLeavingMoney.equals("")))
/*      */     {
/* 1149 */       Double tDouble = new Double(aLeavingMoney);
/* 1150 */       double d = tDouble.doubleValue();
/* 1151 */       this.leavingMoney = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getEndorseTimes()
/*      */   {
/* 1157 */     return this.endorseTimes;
/*      */   }
/*      */ 
/*      */   public void setEndorseTimes(int aEndorseTimes) {
/* 1161 */     this.endorseTimes = aEndorseTimes;
/*      */   }
/*      */ 
/*      */   public void setEndorseTimes(String aEndorseTimes) {
/* 1165 */     if ((aEndorseTimes != null) && (!aEndorseTimes.equals("")))
/*      */     {
/* 1167 */       Integer tInteger = new Integer(aEndorseTimes);
/* 1168 */       int i = tInteger.intValue();
/* 1169 */       this.endorseTimes = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getClaimTimes()
/*      */   {
/* 1175 */     return this.claimTimes;
/*      */   }
/*      */ 
/*      */   public void setClaimTimes(int aClaimTimes) {
/* 1179 */     this.claimTimes = aClaimTimes;
/*      */   }
/*      */ 
/*      */   public void setClaimTimes(String aClaimTimes) {
/* 1183 */     if ((aClaimTimes != null) && (!aClaimTimes.equals("")))
/*      */     {
/* 1185 */       Integer tInteger = new Integer(aClaimTimes);
/* 1186 */       int i = tInteger.intValue();
/* 1187 */       this.claimTimes = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getLiveTimes()
/*      */   {
/* 1193 */     return this.liveTimes;
/*      */   }
/*      */ 
/*      */   public void setLiveTimes(int aLiveTimes) {
/* 1197 */     this.liveTimes = aLiveTimes;
/*      */   }
/*      */ 
/*      */   public void setLiveTimes(String aLiveTimes) {
/* 1201 */     if ((aLiveTimes != null) && (!aLiveTimes.equals("")))
/*      */     {
/* 1203 */       Integer tInteger = new Integer(aLiveTimes);
/* 1204 */       int i = tInteger.intValue();
/* 1205 */       this.liveTimes = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getRenewCount()
/*      */   {
/* 1211 */     return this.renewCount;
/*      */   }
/*      */ 
/*      */   public void setRenewCount(int aRenewCount) {
/* 1215 */     this.renewCount = aRenewCount;
/*      */   }
/*      */ 
/*      */   public void setRenewCount(String aRenewCount) {
/* 1219 */     if ((aRenewCount != null) && (!aRenewCount.equals("")))
/*      */     {
/* 1221 */       Integer tInteger = new Integer(aRenewCount);
/* 1222 */       int i = tInteger.intValue();
/* 1223 */       this.renewCount = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getLastGetDate()
/*      */   {
/* 1229 */     if (this.lastGetDate != null) {
/* 1230 */       return this.fDate.getString(this.lastGetDate);
/*      */     }
/* 1232 */     return null;
/*      */   }
/*      */ 
/*      */   public void setLastGetDate(Date aLastGetDate) {
/* 1236 */     this.lastGetDate = aLastGetDate;
/*      */   }
/*      */ 
/*      */   public void setLastGetDate(String aLastGetDate) {
/* 1240 */     if ((aLastGetDate != null) && (!aLastGetDate.equals("")))
/*      */     {
/* 1242 */       this.lastGetDate = this.fDate.getDate(aLastGetDate);
/*      */     }
/*      */     else
/* 1245 */       this.lastGetDate = null;
/*      */   }
/*      */ 
/*      */   public String getLastLoanDate()
/*      */   {
/* 1250 */     if (this.lastLoanDate != null) {
/* 1251 */       return this.fDate.getString(this.lastLoanDate);
/*      */     }
/* 1253 */     return null;
/*      */   }
/*      */ 
/*      */   public void setLastLoanDate(Date aLastLoanDate) {
/* 1257 */     this.lastLoanDate = aLastLoanDate;
/*      */   }
/*      */ 
/*      */   public void setLastLoanDate(String aLastLoanDate) {
/* 1261 */     if ((aLastLoanDate != null) && (!aLastLoanDate.equals("")))
/*      */     {
/* 1263 */       this.lastLoanDate = this.fDate.getDate(aLastLoanDate);
/*      */     }
/*      */     else
/* 1266 */       this.lastLoanDate = null;
/*      */   }
/*      */ 
/*      */   public String getLastRegetDate()
/*      */   {
/* 1271 */     if (this.lastRegetDate != null) {
/* 1272 */       return this.fDate.getString(this.lastRegetDate);
/*      */     }
/* 1274 */     return null;
/*      */   }
/*      */ 
/*      */   public void setLastRegetDate(Date aLastRegetDate) {
/* 1278 */     this.lastRegetDate = aLastRegetDate;
/*      */   }
/*      */ 
/*      */   public void setLastRegetDate(String aLastRegetDate) {
/* 1282 */     if ((aLastRegetDate != null) && (!aLastRegetDate.equals("")))
/*      */     {
/* 1284 */       this.lastRegetDate = this.fDate.getDate(aLastRegetDate);
/*      */     }
/*      */     else
/* 1287 */       this.lastRegetDate = null;
/*      */   }
/*      */ 
/*      */   public String getLastEdorDate()
/*      */   {
/* 1292 */     if (this.lastEdorDate != null) {
/* 1293 */       return this.fDate.getString(this.lastEdorDate);
/*      */     }
/* 1295 */     return null;
/*      */   }
/*      */ 
/*      */   public void setLastEdorDate(Date aLastEdorDate) {
/* 1299 */     this.lastEdorDate = aLastEdorDate;
/*      */   }
/*      */ 
/*      */   public void setLastEdorDate(String aLastEdorDate) {
/* 1303 */     if ((aLastEdorDate != null) && (!aLastEdorDate.equals("")))
/*      */     {
/* 1305 */       this.lastEdorDate = this.fDate.getDate(aLastEdorDate);
/*      */     }
/*      */     else
/* 1308 */       this.lastEdorDate = null;
/*      */   }
/*      */ 
/*      */   public String getLastRevDate()
/*      */   {
/* 1313 */     if (this.lastRevDate != null) {
/* 1314 */       return this.fDate.getString(this.lastRevDate);
/*      */     }
/* 1316 */     return null;
/*      */   }
/*      */ 
/*      */   public void setLastRevDate(Date aLastRevDate) {
/* 1320 */     this.lastRevDate = aLastRevDate;
/*      */   }
/*      */ 
/*      */   public void setLastRevDate(String aLastRevDate) {
/* 1324 */     if ((aLastRevDate != null) && (!aLastRevDate.equals("")))
/*      */     {
/* 1326 */       this.lastRevDate = this.fDate.getDate(aLastRevDate);
/*      */     }
/*      */     else
/* 1329 */       this.lastRevDate = null;
/*      */   }
/*      */ 
/*      */   public String getRnewFlag()
/*      */   {
/* 1334 */     return this.rnewFlag;
/*      */   }
/*      */ 
/*      */   public void setRnewFlag(String aRnewFlag) {
/* 1338 */     this.rnewFlag = aRnewFlag;
/*      */   }
/*      */ 
/*      */   public String getStopFlag() {
/* 1342 */     return this.stopFlag;
/*      */   }
/*      */ 
/*      */   public void setStopFlag(String aStopFlag) {
/* 1346 */     this.stopFlag = aStopFlag;
/*      */   }
/*      */ 
/*      */   public String getExpiryFlag() {
/* 1350 */     return this.expiryFlag;
/*      */   }
/*      */ 
/*      */   public void setExpiryFlag(String aExpiryFlag) {
/* 1354 */     this.expiryFlag = aExpiryFlag;
/*      */   }
/*      */ 
/*      */   public String getAutoPayFlag() {
/* 1358 */     return this.autoPayFlag;
/*      */   }
/*      */ 
/*      */   public void setAutoPayFlag(String aAutoPayFlag) {
/* 1362 */     this.autoPayFlag = aAutoPayFlag;
/*      */   }
/*      */ 
/*      */   public String getInterestDifFlag() {
/* 1366 */     return this.interestDifFlag;
/*      */   }
/*      */ 
/*      */   public void setInterestDifFlag(String aInterestDifFlag) {
/* 1370 */     this.interestDifFlag = aInterestDifFlag;
/*      */   }
/*      */ 
/*      */   public String getSubFlag() {
/* 1374 */     return this.subFlag;
/*      */   }
/*      */ 
/*      */   public void setSubFlag(String aSubFlag) {
/* 1378 */     this.subFlag = aSubFlag;
/*      */   }
/*      */ 
/*      */   public String getBnfFlag() {
/* 1382 */     return this.bnfFlag;
/*      */   }
/*      */ 
/*      */   public void setBnfFlag(String aBnfFlag) {
/* 1386 */     this.bnfFlag = aBnfFlag;
/*      */   }
/*      */ 
/*      */   public String getHealthCheckFlag() {
/* 1390 */     return this.healthCheckFlag;
/*      */   }
/*      */ 
/*      */   public void setHealthCheckFlag(String aHealthCheckFlag) {
/* 1394 */     this.healthCheckFlag = aHealthCheckFlag;
/*      */   }
/*      */ 
/*      */   public String getImpartFlag() {
/* 1398 */     return this.impartFlag;
/*      */   }
/*      */ 
/*      */   public void setImpartFlag(String aImpartFlag) {
/* 1402 */     this.impartFlag = aImpartFlag;
/*      */   }
/*      */ 
/*      */   public String getReinsureFlag() {
/* 1406 */     return this.reinsureFlag;
/*      */   }
/*      */ 
/*      */   public void setReinsureFlag(String aReinsureFlag) {
/* 1410 */     this.reinsureFlag = aReinsureFlag;
/*      */   }
/*      */ 
/*      */   public String getAgentPayFlag() {
/* 1414 */     return this.agentPayFlag;
/*      */   }
/*      */ 
/*      */   public void setAgentPayFlag(String aAgentPayFlag) {
/* 1418 */     this.agentPayFlag = aAgentPayFlag;
/*      */   }
/*      */ 
/*      */   public String getAgentGetFlag() {
/* 1422 */     return this.agentGetFlag;
/*      */   }
/*      */ 
/*      */   public void setAgentGetFlag(String aAgentGetFlag) {
/* 1426 */     this.agentGetFlag = aAgentGetFlag;
/*      */   }
/*      */ 
/*      */   public String getLiveGetMode() {
/* 1430 */     return this.liveGetMode;
/*      */   }
/*      */ 
/*      */   public void setLiveGetMode(String aLiveGetMode) {
/* 1434 */     this.liveGetMode = aLiveGetMode;
/*      */   }
/*      */ 
/*      */   public String getDeadGetMode() {
/* 1438 */     return this.deadGetMode;
/*      */   }
/*      */ 
/*      */   public void setDeadGetMode(String aDeadGetMode) {
/* 1442 */     this.deadGetMode = aDeadGetMode;
/*      */   }
/*      */ 
/*      */   public String getBonusGetMode() {
/* 1446 */     return this.bonusGetMode;
/*      */   }
/*      */ 
/*      */   public void setBonusGetMode(String aBonusGetMode) {
/* 1450 */     this.bonusGetMode = aBonusGetMode;
/*      */   }
/*      */ 
/*      */   public String getDeadAmntType() {
/* 1454 */     return this.deadAmntType;
/*      */   }
/*      */ 
/*      */   public void setDeadAmntType(String aDeadAmntType) {
/* 1458 */     this.deadAmntType = aDeadAmntType;
/*      */   }
/*      */ 
/*      */   public double getTopUpPrem() {
/* 1462 */     return this.topUpPrem;
/*      */   }
/*      */ 
/*      */   public void setTopUpPrem(double aTopUpPrem) {
/* 1466 */     this.topUpPrem = aTopUpPrem;
/*      */   }
/*      */ 
/*      */   public void setTopUpPrem(String aTopUpPrem) {
/* 1470 */     if ((aTopUpPrem != null) && (!aTopUpPrem.equals("")))
/*      */     {
/* 1472 */       Double tDouble = new Double(aTopUpPrem);
/* 1473 */       double d = tDouble.doubleValue();
/* 1474 */       this.topUpPrem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getBonusMan()
/*      */   {
/* 1480 */     return this.bonusMan;
/*      */   }
/*      */ 
/*      */   public void setBonusMan(String aBonusMan) {
/* 1484 */     this.bonusMan = aBonusMan;
/*      */   }
/*      */ 
/*      */   public String getDeadFlag() {
/* 1488 */     return this.deadFlag;
/*      */   }
/*      */ 
/*      */   public void setDeadFlag(String aDeadFlag) {
/* 1492 */     this.deadFlag = aDeadFlag;
/*      */   }
/*      */ 
/*      */   public String getSmokeFlag() {
/* 1496 */     return this.smokeFlag;
/*      */   }
/*      */ 
/*      */   public void setSmokeFlag(String aSmokeFlag) {
/* 1500 */     this.smokeFlag = aSmokeFlag;
/*      */   }
/*      */ 
/*      */   public String getRemark() {
/* 1504 */     return this.remark;
/*      */   }
/*      */ 
/*      */   public void setRemark(String aRemark) {
/* 1508 */     this.remark = aRemark;
/*      */   }
/*      */ 
/*      */   public String getApproveFlag() {
/* 1512 */     return this.approveFlag;
/*      */   }
/*      */ 
/*      */   public void setApproveFlag(String aApproveFlag) {
/* 1516 */     this.approveFlag = aApproveFlag;
/*      */   }
/*      */ 
/*      */   public String getApproveCode() {
/* 1520 */     return this.approveCode;
/*      */   }
/*      */ 
/*      */   public void setApproveCode(String aApproveCode) {
/* 1524 */     this.approveCode = aApproveCode;
/*      */   }
/*      */ 
/*      */   public String getApproveDate() {
/* 1528 */     if (this.approveDate != null) {
/* 1529 */       return this.fDate.getString(this.approveDate);
/*      */     }
/* 1531 */     return null;
/*      */   }
/*      */ 
/*      */   public void setApproveDate(Date aApproveDate) {
/* 1535 */     this.approveDate = aApproveDate;
/*      */   }
/*      */ 
/*      */   public void setApproveDate(String aApproveDate) {
/* 1539 */     if ((aApproveDate != null) && (!aApproveDate.equals("")))
/*      */     {
/* 1541 */       this.approveDate = this.fDate.getDate(aApproveDate);
/*      */     }
/*      */     else
/* 1544 */       this.approveDate = null;
/*      */   }
/*      */ 
/*      */   public String getApproveTime()
/*      */   {
/* 1549 */     return this.approveTime;
/*      */   }
/*      */ 
/*      */   public void setApproveTime(String aApproveTime) {
/* 1553 */     this.approveTime = aApproveTime;
/*      */   }
/*      */ 
/*      */   public String getUWFlag() {
/* 1557 */     return this.uWFlag;
/*      */   }
/*      */ 
/*      */   public void setUWFlag(String aUWFlag) {
/* 1561 */     this.uWFlag = aUWFlag;
/*      */   }
/*      */ 
/*      */   public String getUWCode() {
/* 1565 */     return this.uWCode;
/*      */   }
/*      */ 
/*      */   public void setUWCode(String aUWCode) {
/* 1569 */     this.uWCode = aUWCode;
/*      */   }
/*      */ 
/*      */   public String getUWDate() {
/* 1573 */     if (this.uWDate != null) {
/* 1574 */       return this.fDate.getString(this.uWDate);
/*      */     }
/* 1576 */     return null;
/*      */   }
/*      */ 
/*      */   public void setUWDate(Date aUWDate) {
/* 1580 */     this.uWDate = aUWDate;
/*      */   }
/*      */ 
/*      */   public void setUWDate(String aUWDate) {
/* 1584 */     if ((aUWDate != null) && (!aUWDate.equals("")))
/*      */     {
/* 1586 */       this.uWDate = this.fDate.getDate(aUWDate);
/*      */     }
/*      */     else
/* 1589 */       this.uWDate = null;
/*      */   }
/*      */ 
/*      */   public String getUWTime()
/*      */   {
/* 1594 */     return this.uWTime;
/*      */   }
/*      */ 
/*      */   public void setUWTime(String aUWTime) {
/* 1598 */     this.uWTime = aUWTime;
/*      */   }
/*      */ 
/*      */   public String getPolApplyDate() {
/* 1602 */     if (this.polApplyDate != null) {
/* 1603 */       return this.fDate.getString(this.polApplyDate);
/*      */     }
/* 1605 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPolApplyDate(Date aPolApplyDate) {
/* 1609 */     this.polApplyDate = aPolApplyDate;
/*      */   }
/*      */ 
/*      */   public void setPolApplyDate(String aPolApplyDate) {
/* 1613 */     if ((aPolApplyDate != null) && (!aPolApplyDate.equals("")))
/*      */     {
/* 1615 */       this.polApplyDate = this.fDate.getDate(aPolApplyDate);
/*      */     }
/*      */     else
/* 1618 */       this.polApplyDate = null;
/*      */   }
/*      */ 
/*      */   public String getAppFlag()
/*      */   {
/* 1623 */     return this.appFlag;
/*      */   }
/*      */ 
/*      */   public void setAppFlag(String aAppFlag) {
/* 1627 */     this.appFlag = aAppFlag;
/*      */   }
/*      */ 
/*      */   public String getSaleChnlDetail() {
/* 1631 */     return this.saleChnlDetail;
/*      */   }
/*      */ 
/*      */   public void setSaleChnlDetail(String aSaleChnlDetail) {
/* 1635 */     this.saleChnlDetail = aSaleChnlDetail;
/*      */   }
/*      */ 
/*      */   public String getPolState() {
/* 1639 */     return this.polState;
/*      */   }
/*      */ 
/*      */   public void setPolState(String aPolState) {
/* 1643 */     this.polState = aPolState;
/*      */   }
/*      */ 
/*      */   public String getStandbyFlag1() {
/* 1647 */     return this.standbyFlag1;
/*      */   }
/*      */ 
/*      */   public void setStandbyFlag1(String aStandbyFlag1) {
/* 1651 */     this.standbyFlag1 = aStandbyFlag1;
/*      */   }
/*      */ 
/*      */   public String getStandbyFlag2() {
/* 1655 */     return this.standbyFlag2;
/*      */   }
/*      */ 
/*      */   public void setStandbyFlag2(String aStandbyFlag2) {
/* 1659 */     this.standbyFlag2 = aStandbyFlag2;
/*      */   }
/*      */ 
/*      */   public String getStandbyFlag3() {
/* 1663 */     return this.standbyFlag3;
/*      */   }
/*      */ 
/*      */   public void setStandbyFlag3(String aStandbyFlag3) {
/* 1667 */     this.standbyFlag3 = aStandbyFlag3;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/* 1671 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/* 1675 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/* 1679 */     if (this.makeDate != null) {
/* 1680 */       return this.fDate.getString(this.makeDate);
/*      */     }
/* 1682 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/* 1686 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/* 1690 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/* 1692 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/* 1695 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/* 1700 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/* 1704 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/* 1708 */     if (this.modifyDate != null) {
/* 1709 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/* 1711 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/* 1715 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/* 1719 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/* 1721 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/* 1724 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/* 1729 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/* 1733 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPPolSchema aLNPPolSchema)
/*      */   {
/* 1739 */     this.grpContNo = aLNPPolSchema.getGrpContNo();
/* 1740 */     this.grpPolNo = aLNPPolSchema.getGrpPolNo();
/* 1741 */     this.contNo = aLNPPolSchema.getContNo();
/* 1742 */     this.proposalContNo = aLNPPolSchema.getProposalContNo();
/* 1743 */     this.polNo = aLNPPolSchema.getPolNo();
/* 1744 */     this.proposalNo = aLNPPolSchema.getProposalNo();
/* 1745 */     this.prtNo = aLNPPolSchema.getPrtNo();
/* 1746 */     this.contType = aLNPPolSchema.getContType();
/* 1747 */     this.polTypeFlag = aLNPPolSchema.getPolTypeFlag();
/* 1748 */     this.mainPolNo = aLNPPolSchema.getMainPolNo();
/* 1749 */     this.masterPolNo = aLNPPolSchema.getMasterPolNo();
/* 1750 */     this.kindCode = aLNPPolSchema.getKindCode();
/* 1751 */     this.riskCode = aLNPPolSchema.getRiskCode();
/* 1752 */     this.riskVersion = aLNPPolSchema.getRiskVersion();
/* 1753 */     this.manageCom = aLNPPolSchema.getManageCom();
/* 1754 */     this.agentCom = aLNPPolSchema.getAgentCom();
/* 1755 */     this.agentType = aLNPPolSchema.getAgentType();
/* 1756 */     this.agentCode = aLNPPolSchema.getAgentCode();
/* 1757 */     this.agentGroup = aLNPPolSchema.getAgentGroup();
/* 1758 */     this.agentGroup1 = aLNPPolSchema.getAgentGroup1();
/* 1759 */     this.agentCode1 = aLNPPolSchema.getAgentCode1();
/* 1760 */     this.saleChnl = aLNPPolSchema.getSaleChnl();
/* 1761 */     this.handler = aLNPPolSchema.getHandler();
/* 1762 */     this.insuredNo = aLNPPolSchema.getInsuredNo();
/* 1763 */     this.insuredId = aLNPPolSchema.getInsuredId();
/* 1764 */     this.insuredName = aLNPPolSchema.getInsuredName();
/* 1765 */     this.insuredSex = aLNPPolSchema.getInsuredSex();
/* 1766 */     this.insuredBirthday = this.fDate.getDate(aLNPPolSchema.getInsuredBirthday());
/* 1767 */     this.insuredAppAge = aLNPPolSchema.getInsuredAppAge();
/* 1768 */     this.insuredPeoples = aLNPPolSchema.getInsuredPeoples();
/* 1769 */     this.occupationType = aLNPPolSchema.getOccupationType();
/* 1770 */     this.appntNo = aLNPPolSchema.getAppntNo();
/* 1771 */     this.appntName = aLNPPolSchema.getAppntName();
/* 1772 */     this.cValiDate = this.fDate.getDate(aLNPPolSchema.getCValiDate());
/* 1773 */     this.signCom = aLNPPolSchema.getSignCom();
/* 1774 */     this.signDate = this.fDate.getDate(aLNPPolSchema.getSignDate());
/* 1775 */     this.signTime = aLNPPolSchema.getSignTime();
/* 1776 */     this.firstPayDate = this.fDate.getDate(aLNPPolSchema.getFirstPayDate());
/* 1777 */     this.payEndDate = this.fDate.getDate(aLNPPolSchema.getPayEndDate());
/* 1778 */     this.paytoDate = this.fDate.getDate(aLNPPolSchema.getPaytoDate());
/* 1779 */     this.getStartDate = this.fDate.getDate(aLNPPolSchema.getGetStartDate());
/* 1780 */     this.endDate = this.fDate.getDate(aLNPPolSchema.getEndDate());
/* 1781 */     this.acciEndDate = this.fDate.getDate(aLNPPolSchema.getAcciEndDate());
/* 1782 */     this.getYearFlag = aLNPPolSchema.getGetYearFlag();
/* 1783 */     this.getYear = aLNPPolSchema.getGetYear();
/* 1784 */     this.payEndYearFlag = aLNPPolSchema.getPayEndYearFlag();
/* 1785 */     this.payEndYear = aLNPPolSchema.getPayEndYear();
/* 1786 */     this.insuYearFlag = aLNPPolSchema.getInsuYearFlag();
/* 1787 */     this.insuYear = aLNPPolSchema.getInsuYear();
/* 1788 */     this.acciYearFlag = aLNPPolSchema.getAcciYearFlag();
/* 1789 */     this.acciYear = aLNPPolSchema.getAcciYear();
/* 1790 */     this.getStartType = aLNPPolSchema.getGetStartType();
/* 1791 */     this.specifyValiDate = aLNPPolSchema.getSpecifyValiDate();
/* 1792 */     this.payMode = aLNPPolSchema.getPayMode();
/* 1793 */     this.payLocation = aLNPPolSchema.getPayLocation();
/* 1794 */     this.payIntv = aLNPPolSchema.getPayIntv();
/* 1795 */     this.payYears = aLNPPolSchema.getPayYears();
/* 1796 */     this.years = aLNPPolSchema.getYears();
/* 1797 */     this.manageFeeRate = aLNPPolSchema.getManageFeeRate();
/* 1798 */     this.floatRate = aLNPPolSchema.getFloatRate();
/* 1799 */     this.premRate = aLNPPolSchema.getPremRate();
/* 1800 */     this.premToAmnt = aLNPPolSchema.getPremToAmnt();
/* 1801 */     this.mult = aLNPPolSchema.getMult();
/* 1802 */     this.standPrem = aLNPPolSchema.getStandPrem();
/* 1803 */     this.prem = aLNPPolSchema.getPrem();
/* 1804 */     this.sumPrem = aLNPPolSchema.getSumPrem();
/* 1805 */     this.amnt = aLNPPolSchema.getAmnt();
/* 1806 */     this.riskAmnt = aLNPPolSchema.getRiskAmnt();
/* 1807 */     this.leavingMoney = aLNPPolSchema.getLeavingMoney();
/* 1808 */     this.endorseTimes = aLNPPolSchema.getEndorseTimes();
/* 1809 */     this.claimTimes = aLNPPolSchema.getClaimTimes();
/* 1810 */     this.liveTimes = aLNPPolSchema.getLiveTimes();
/* 1811 */     this.renewCount = aLNPPolSchema.getRenewCount();
/* 1812 */     this.lastGetDate = this.fDate.getDate(aLNPPolSchema.getLastGetDate());
/* 1813 */     this.lastLoanDate = this.fDate.getDate(aLNPPolSchema.getLastLoanDate());
/* 1814 */     this.lastRegetDate = this.fDate.getDate(aLNPPolSchema.getLastRegetDate());
/* 1815 */     this.lastEdorDate = this.fDate.getDate(aLNPPolSchema.getLastEdorDate());
/* 1816 */     this.lastRevDate = this.fDate.getDate(aLNPPolSchema.getLastRevDate());
/* 1817 */     this.rnewFlag = aLNPPolSchema.getRnewFlag();
/* 1818 */     this.stopFlag = aLNPPolSchema.getStopFlag();
/* 1819 */     this.expiryFlag = aLNPPolSchema.getExpiryFlag();
/* 1820 */     this.autoPayFlag = aLNPPolSchema.getAutoPayFlag();
/* 1821 */     this.interestDifFlag = aLNPPolSchema.getInterestDifFlag();
/* 1822 */     this.subFlag = aLNPPolSchema.getSubFlag();
/* 1823 */     this.bnfFlag = aLNPPolSchema.getBnfFlag();
/* 1824 */     this.healthCheckFlag = aLNPPolSchema.getHealthCheckFlag();
/* 1825 */     this.impartFlag = aLNPPolSchema.getImpartFlag();
/* 1826 */     this.reinsureFlag = aLNPPolSchema.getReinsureFlag();
/* 1827 */     this.agentPayFlag = aLNPPolSchema.getAgentPayFlag();
/* 1828 */     this.agentGetFlag = aLNPPolSchema.getAgentGetFlag();
/* 1829 */     this.liveGetMode = aLNPPolSchema.getLiveGetMode();
/* 1830 */     this.deadGetMode = aLNPPolSchema.getDeadGetMode();
/* 1831 */     this.bonusGetMode = aLNPPolSchema.getBonusGetMode();
/* 1832 */     this.deadAmntType = aLNPPolSchema.getDeadAmntType();
/* 1833 */     this.topUpPrem = aLNPPolSchema.getTopUpPrem();
/* 1834 */     this.bonusMan = aLNPPolSchema.getBonusMan();
/* 1835 */     this.deadFlag = aLNPPolSchema.getDeadFlag();
/* 1836 */     this.smokeFlag = aLNPPolSchema.getSmokeFlag();
/* 1837 */     this.remark = aLNPPolSchema.getRemark();
/* 1838 */     this.approveFlag = aLNPPolSchema.getApproveFlag();
/* 1839 */     this.approveCode = aLNPPolSchema.getApproveCode();
/* 1840 */     this.approveDate = this.fDate.getDate(aLNPPolSchema.getApproveDate());
/* 1841 */     this.approveTime = aLNPPolSchema.getApproveTime();
/* 1842 */     this.uWFlag = aLNPPolSchema.getUWFlag();
/* 1843 */     this.uWCode = aLNPPolSchema.getUWCode();
/* 1844 */     this.uWDate = this.fDate.getDate(aLNPPolSchema.getUWDate());
/* 1845 */     this.uWTime = aLNPPolSchema.getUWTime();
/* 1846 */     this.polApplyDate = this.fDate.getDate(aLNPPolSchema.getPolApplyDate());
/* 1847 */     this.appFlag = aLNPPolSchema.getAppFlag();
/* 1848 */     this.saleChnlDetail = aLNPPolSchema.getSaleChnlDetail();
/* 1849 */     this.polState = aLNPPolSchema.getPolState();
/* 1850 */     this.standbyFlag1 = aLNPPolSchema.getStandbyFlag1();
/* 1851 */     this.standbyFlag2 = aLNPPolSchema.getStandbyFlag2();
/* 1852 */     this.standbyFlag3 = aLNPPolSchema.getStandbyFlag3();
/* 1853 */     this.operator = aLNPPolSchema.getOperator();
/* 1854 */     this.makeDate = this.fDate.getDate(aLNPPolSchema.getMakeDate());
/* 1855 */     this.makeTime = aLNPPolSchema.getMakeTime();
/* 1856 */     this.modifyDate = this.fDate.getDate(aLNPPolSchema.getModifyDate());
/* 1857 */     this.modifyTime = aLNPPolSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/* 1866 */       if (rs.getString("GrpContNo") == null)
/* 1867 */         this.grpContNo = null;
/*      */       else {
/* 1869 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/* 1871 */       if (rs.getString("GrpPolNo") == null)
/* 1872 */         this.grpPolNo = null;
/*      */       else {
/* 1874 */         this.grpPolNo = rs.getString("GrpPolNo").trim();
/*      */       }
/* 1876 */       if (rs.getString("ContNo") == null)
/* 1877 */         this.contNo = null;
/*      */       else {
/* 1879 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/* 1881 */       if (rs.getString("ProposalContNo") == null)
/* 1882 */         this.proposalContNo = null;
/*      */       else {
/* 1884 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/* 1886 */       if (rs.getString("PolNo") == null)
/* 1887 */         this.polNo = null;
/*      */       else {
/* 1889 */         this.polNo = rs.getString("PolNo").trim();
/*      */       }
/* 1891 */       if (rs.getString("ProposalNo") == null)
/* 1892 */         this.proposalNo = null;
/*      */       else {
/* 1894 */         this.proposalNo = rs.getString("ProposalNo").trim();
/*      */       }
/* 1896 */       if (rs.getString("PrtNo") == null)
/* 1897 */         this.prtNo = null;
/*      */       else {
/* 1899 */         this.prtNo = rs.getString("PrtNo").trim();
/*      */       }
/* 1901 */       if (rs.getString("ContType") == null)
/* 1902 */         this.contType = null;
/*      */       else {
/* 1904 */         this.contType = rs.getString("ContType").trim();
/*      */       }
/* 1906 */       if (rs.getString("PolTypeFlag") == null)
/* 1907 */         this.polTypeFlag = null;
/*      */       else {
/* 1909 */         this.polTypeFlag = rs.getString("PolTypeFlag").trim();
/*      */       }
/* 1911 */       if (rs.getString("MainPolNo") == null)
/* 1912 */         this.mainPolNo = null;
/*      */       else {
/* 1914 */         this.mainPolNo = rs.getString("MainPolNo").trim();
/*      */       }
/* 1916 */       if (rs.getString("MasterPolNo") == null)
/* 1917 */         this.masterPolNo = null;
/*      */       else {
/* 1919 */         this.masterPolNo = rs.getString("MasterPolNo").trim();
/*      */       }
/* 1921 */       if (rs.getString("KindCode") == null)
/* 1922 */         this.kindCode = null;
/*      */       else {
/* 1924 */         this.kindCode = rs.getString("KindCode").trim();
/*      */       }
/* 1926 */       if (rs.getString("RiskCode") == null)
/* 1927 */         this.riskCode = null;
/*      */       else {
/* 1929 */         this.riskCode = rs.getString("RiskCode").trim();
/*      */       }
/* 1931 */       if (rs.getString("RiskVersion") == null)
/* 1932 */         this.riskVersion = null;
/*      */       else {
/* 1934 */         this.riskVersion = rs.getString("RiskVersion").trim();
/*      */       }
/* 1936 */       if (rs.getString("ManageCom") == null)
/* 1937 */         this.manageCom = null;
/*      */       else {
/* 1939 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/* 1941 */       if (rs.getString("AgentCom") == null)
/* 1942 */         this.agentCom = null;
/*      */       else {
/* 1944 */         this.agentCom = rs.getString("AgentCom").trim();
/*      */       }
/* 1946 */       if (rs.getString("AgentType") == null)
/* 1947 */         this.agentType = null;
/*      */       else {
/* 1949 */         this.agentType = rs.getString("AgentType").trim();
/*      */       }
/* 1951 */       if (rs.getString("AgentCode") == null)
/* 1952 */         this.agentCode = null;
/*      */       else {
/* 1954 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/* 1956 */       if (rs.getString("AgentGroup") == null)
/* 1957 */         this.agentGroup = null;
/*      */       else {
/* 1959 */         this.agentGroup = rs.getString("AgentGroup").trim();
/*      */       }
/* 1961 */       if (rs.getString("AgentGroup1") == null)
/* 1962 */         this.agentGroup1 = null;
/*      */       else {
/* 1964 */         this.agentGroup1 = rs.getString("AgentGroup1").trim();
/*      */       }
/* 1966 */       if (rs.getString("AgentCode1") == null)
/* 1967 */         this.agentCode1 = null;
/*      */       else {
/* 1969 */         this.agentCode1 = rs.getString("AgentCode1").trim();
/*      */       }
/* 1971 */       if (rs.getString("SaleChnl") == null)
/* 1972 */         this.saleChnl = null;
/*      */       else {
/* 1974 */         this.saleChnl = rs.getString("SaleChnl").trim();
/*      */       }
/* 1976 */       if (rs.getString("Handler") == null)
/* 1977 */         this.handler = null;
/*      */       else {
/* 1979 */         this.handler = rs.getString("Handler").trim();
/*      */       }
/* 1981 */       if (rs.getString("InsuredNo") == null)
/* 1982 */         this.insuredNo = null;
/*      */       else {
/* 1984 */         this.insuredNo = rs.getString("InsuredNo").trim();
/*      */       }
/* 1986 */       if (rs.getString("InsuredId") == null)
/* 1987 */         this.insuredId = null;
/*      */       else {
/* 1989 */         this.insuredId = rs.getString("InsuredId").trim();
/*      */       }
/* 1991 */       if (rs.getString("InsuredName") == null)
/* 1992 */         this.insuredName = null;
/*      */       else {
/* 1994 */         this.insuredName = rs.getString("InsuredName").trim();
/*      */       }
/* 1996 */       if (rs.getString("InsuredSex") == null)
/* 1997 */         this.insuredSex = null;
/*      */       else {
/* 1999 */         this.insuredSex = rs.getString("InsuredSex").trim();
/*      */       }
/* 2001 */       this.insuredBirthday = rs.getDate("InsuredBirthday");
/* 2002 */       this.insuredAppAge = rs.getInt("InsuredAppAge");
/* 2003 */       this.insuredPeoples = rs.getInt("InsuredPeoples");
/* 2004 */       if (rs.getString("OccupationType") == null)
/* 2005 */         this.occupationType = null;
/*      */       else {
/* 2007 */         this.occupationType = rs.getString("OccupationType").trim();
/*      */       }
/* 2009 */       if (rs.getString("AppntNo") == null)
/* 2010 */         this.appntNo = null;
/*      */       else {
/* 2012 */         this.appntNo = rs.getString("AppntNo").trim();
/*      */       }
/* 2014 */       if (rs.getString("AppntName") == null)
/* 2015 */         this.appntName = null;
/*      */       else {
/* 2017 */         this.appntName = rs.getString("AppntName").trim();
/*      */       }
/* 2019 */       this.cValiDate = rs.getDate("CValiDate");
/* 2020 */       if (rs.getString("SignCom") == null)
/* 2021 */         this.signCom = null;
/*      */       else {
/* 2023 */         this.signCom = rs.getString("SignCom").trim();
/*      */       }
/* 2025 */       this.signDate = rs.getDate("SignDate");
/* 2026 */       if (rs.getString("SignTime") == null)
/* 2027 */         this.signTime = null;
/*      */       else {
/* 2029 */         this.signTime = rs.getString("SignTime").trim();
/*      */       }
/* 2031 */       this.firstPayDate = rs.getDate("FirstPayDate");
/* 2032 */       this.payEndDate = rs.getDate("PayEndDate");
/* 2033 */       this.paytoDate = rs.getDate("PaytoDate");
/* 2034 */       this.getStartDate = rs.getDate("GetStartDate");
/* 2035 */       this.endDate = rs.getDate("EndDate");
/* 2036 */       this.acciEndDate = rs.getDate("AcciEndDate");
/* 2037 */       if (rs.getString("GetYearFlag") == null)
/* 2038 */         this.getYearFlag = null;
/*      */       else {
/* 2040 */         this.getYearFlag = rs.getString("GetYearFlag").trim();
/*      */       }
/* 2042 */       this.getYear = rs.getInt("GetYear");
/* 2043 */       if (rs.getString("PayEndYearFlag") == null)
/* 2044 */         this.payEndYearFlag = null;
/*      */       else {
/* 2046 */         this.payEndYearFlag = rs.getString("PayEndYearFlag").trim();
/*      */       }
/* 2048 */       this.payEndYear = rs.getInt("PayEndYear");
/* 2049 */       if (rs.getString("InsuYearFlag") == null)
/* 2050 */         this.insuYearFlag = null;
/*      */       else {
/* 2052 */         this.insuYearFlag = rs.getString("InsuYearFlag").trim();
/*      */       }
/* 2054 */       this.insuYear = rs.getInt("InsuYear");
/* 2055 */       if (rs.getString("AcciYearFlag") == null)
/* 2056 */         this.acciYearFlag = null;
/*      */       else {
/* 2058 */         this.acciYearFlag = rs.getString("AcciYearFlag").trim();
/*      */       }
/* 2060 */       this.acciYear = rs.getInt("AcciYear");
/* 2061 */       if (rs.getString("GetStartType") == null)
/* 2062 */         this.getStartType = null;
/*      */       else {
/* 2064 */         this.getStartType = rs.getString("GetStartType").trim();
/*      */       }
/* 2066 */       if (rs.getString("SpecifyValiDate") == null)
/* 2067 */         this.specifyValiDate = null;
/*      */       else {
/* 2069 */         this.specifyValiDate = rs.getString("SpecifyValiDate").trim();
/*      */       }
/* 2071 */       if (rs.getString("PayMode") == null)
/* 2072 */         this.payMode = null;
/*      */       else {
/* 2074 */         this.payMode = rs.getString("PayMode").trim();
/*      */       }
/* 2076 */       if (rs.getString("PayLocation") == null)
/* 2077 */         this.payLocation = null;
/*      */       else {
/* 2079 */         this.payLocation = rs.getString("PayLocation").trim();
/*      */       }
/* 2081 */       this.payIntv = rs.getInt("PayIntv");
/* 2082 */       this.payYears = rs.getInt("PayYears");
/* 2083 */       this.years = rs.getInt("Years");
/* 2084 */       this.manageFeeRate = rs.getDouble("ManageFeeRate");
/* 2085 */       this.floatRate = rs.getDouble("FloatRate");
/* 2086 */       this.premRate = rs.getDouble("PremRate");
/* 2087 */       if (rs.getString("PremToAmnt") == null)
/* 2088 */         this.premToAmnt = null;
/*      */       else {
/* 2090 */         this.premToAmnt = rs.getString("PremToAmnt").trim();
/*      */       }
/* 2092 */       this.mult = rs.getDouble("Mult");
/* 2093 */       this.standPrem = rs.getDouble("StandPrem");
/* 2094 */       this.prem = rs.getDouble("Prem");
/* 2095 */       this.sumPrem = rs.getDouble("SumPrem");
/* 2096 */       this.amnt = rs.getDouble("Amnt");
/* 2097 */       this.riskAmnt = rs.getDouble("RiskAmnt");
/* 2098 */       this.leavingMoney = rs.getDouble("LeavingMoney");
/* 2099 */       this.endorseTimes = rs.getInt("EndorseTimes");
/* 2100 */       this.claimTimes = rs.getInt("ClaimTimes");
/* 2101 */       this.liveTimes = rs.getInt("LiveTimes");
/* 2102 */       this.renewCount = rs.getInt("RenewCount");
/* 2103 */       this.lastGetDate = rs.getDate("LastGetDate");
/* 2104 */       this.lastLoanDate = rs.getDate("LastLoanDate");
/* 2105 */       this.lastRegetDate = rs.getDate("LastRegetDate");
/* 2106 */       this.lastEdorDate = rs.getDate("LastEdorDate");
/* 2107 */       this.lastRevDate = rs.getDate("LastRevDate");
/* 2108 */       if (rs.getString("RnewFlag") == null)
/* 2109 */         this.rnewFlag = null;
/*      */       else {
/* 2111 */         this.rnewFlag = rs.getString("RnewFlag").trim();
/*      */       }
/* 2113 */       if (rs.getString("StopFlag") == null)
/* 2114 */         this.stopFlag = null;
/*      */       else {
/* 2116 */         this.stopFlag = rs.getString("StopFlag").trim();
/*      */       }
/* 2118 */       if (rs.getString("ExpiryFlag") == null)
/* 2119 */         this.expiryFlag = null;
/*      */       else {
/* 2121 */         this.expiryFlag = rs.getString("ExpiryFlag").trim();
/*      */       }
/* 2123 */       if (rs.getString("AutoPayFlag") == null)
/* 2124 */         this.autoPayFlag = null;
/*      */       else {
/* 2126 */         this.autoPayFlag = rs.getString("AutoPayFlag").trim();
/*      */       }
/* 2128 */       if (rs.getString("InterestDifFlag") == null)
/* 2129 */         this.interestDifFlag = null;
/*      */       else {
/* 2131 */         this.interestDifFlag = rs.getString("InterestDifFlag").trim();
/*      */       }
/* 2133 */       if (rs.getString("SubFlag") == null)
/* 2134 */         this.subFlag = null;
/*      */       else {
/* 2136 */         this.subFlag = rs.getString("SubFlag").trim();
/*      */       }
/* 2138 */       if (rs.getString("BnfFlag") == null)
/* 2139 */         this.bnfFlag = null;
/*      */       else {
/* 2141 */         this.bnfFlag = rs.getString("BnfFlag").trim();
/*      */       }
/* 2143 */       if (rs.getString("HealthCheckFlag") == null)
/* 2144 */         this.healthCheckFlag = null;
/*      */       else {
/* 2146 */         this.healthCheckFlag = rs.getString("HealthCheckFlag").trim();
/*      */       }
/* 2148 */       if (rs.getString("ImpartFlag") == null)
/* 2149 */         this.impartFlag = null;
/*      */       else {
/* 2151 */         this.impartFlag = rs.getString("ImpartFlag").trim();
/*      */       }
/* 2153 */       if (rs.getString("ReinsureFlag") == null)
/* 2154 */         this.reinsureFlag = null;
/*      */       else {
/* 2156 */         this.reinsureFlag = rs.getString("ReinsureFlag").trim();
/*      */       }
/* 2158 */       if (rs.getString("AgentPayFlag") == null)
/* 2159 */         this.agentPayFlag = null;
/*      */       else {
/* 2161 */         this.agentPayFlag = rs.getString("AgentPayFlag").trim();
/*      */       }
/* 2163 */       if (rs.getString("AgentGetFlag") == null)
/* 2164 */         this.agentGetFlag = null;
/*      */       else {
/* 2166 */         this.agentGetFlag = rs.getString("AgentGetFlag").trim();
/*      */       }
/* 2168 */       if (rs.getString("LiveGetMode") == null)
/* 2169 */         this.liveGetMode = null;
/*      */       else {
/* 2171 */         this.liveGetMode = rs.getString("LiveGetMode").trim();
/*      */       }
/* 2173 */       if (rs.getString("DeadGetMode") == null)
/* 2174 */         this.deadGetMode = null;
/*      */       else {
/* 2176 */         this.deadGetMode = rs.getString("DeadGetMode").trim();
/*      */       }
/* 2178 */       if (rs.getString("BonusGetMode") == null)
/* 2179 */         this.bonusGetMode = null;
/*      */       else {
/* 2181 */         this.bonusGetMode = rs.getString("BonusGetMode").trim();
/*      */       }
/* 2183 */       if (rs.getString("DeadAmntType") == null)
/* 2184 */         this.deadAmntType = null;
/*      */       else {
/* 2186 */         this.deadAmntType = rs.getString("DeadAmntType").trim();
/*      */       }
/* 2188 */       this.topUpPrem = rs.getDouble("TopUpPrem");
/* 2189 */       if (rs.getString("BonusMan") == null)
/* 2190 */         this.bonusMan = null;
/*      */       else {
/* 2192 */         this.bonusMan = rs.getString("BonusMan").trim();
/*      */       }
/* 2194 */       if (rs.getString("DeadFlag") == null)
/* 2195 */         this.deadFlag = null;
/*      */       else {
/* 2197 */         this.deadFlag = rs.getString("DeadFlag").trim();
/*      */       }
/* 2199 */       if (rs.getString("SmokeFlag") == null)
/* 2200 */         this.smokeFlag = null;
/*      */       else {
/* 2202 */         this.smokeFlag = rs.getString("SmokeFlag").trim();
/*      */       }
/* 2204 */       if (rs.getString("Remark") == null)
/* 2205 */         this.remark = null;
/*      */       else {
/* 2207 */         this.remark = rs.getString("Remark").trim();
/*      */       }
/* 2209 */       if (rs.getString("ApproveFlag") == null)
/* 2210 */         this.approveFlag = null;
/*      */       else {
/* 2212 */         this.approveFlag = rs.getString("ApproveFlag").trim();
/*      */       }
/* 2214 */       if (rs.getString("ApproveCode") == null)
/* 2215 */         this.approveCode = null;
/*      */       else {
/* 2217 */         this.approveCode = rs.getString("ApproveCode").trim();
/*      */       }
/* 2219 */       this.approveDate = rs.getDate("ApproveDate");
/* 2220 */       if (rs.getString("ApproveTime") == null)
/* 2221 */         this.approveTime = null;
/*      */       else {
/* 2223 */         this.approveTime = rs.getString("ApproveTime").trim();
/*      */       }
/* 2225 */       if (rs.getString("UWFlag") == null)
/* 2226 */         this.uWFlag = null;
/*      */       else {
/* 2228 */         this.uWFlag = rs.getString("UWFlag").trim();
/*      */       }
/* 2230 */       if (rs.getString("UWCode") == null)
/* 2231 */         this.uWCode = null;
/*      */       else {
/* 2233 */         this.uWCode = rs.getString("UWCode").trim();
/*      */       }
/* 2235 */       this.uWDate = rs.getDate("UWDate");
/* 2236 */       if (rs.getString("UWTime") == null)
/* 2237 */         this.uWTime = null;
/*      */       else {
/* 2239 */         this.uWTime = rs.getString("UWTime").trim();
/*      */       }
/* 2241 */       this.polApplyDate = rs.getDate("PolApplyDate");
/* 2242 */       if (rs.getString("AppFlag") == null)
/* 2243 */         this.appFlag = null;
/*      */       else {
/* 2245 */         this.appFlag = rs.getString("AppFlag").trim();
/*      */       }
/* 2247 */       if (rs.getString("SaleChnlDetail") == null)
/* 2248 */         this.saleChnlDetail = null;
/*      */       else {
/* 2250 */         this.saleChnlDetail = rs.getString("SaleChnlDetail").trim();
/*      */       }
/* 2252 */       if (rs.getString("PolState") == null)
/* 2253 */         this.polState = null;
/*      */       else {
/* 2255 */         this.polState = rs.getString("PolState").trim();
/*      */       }
/* 2257 */       if (rs.getString("StandbyFlag1") == null)
/* 2258 */         this.standbyFlag1 = null;
/*      */       else {
/* 2260 */         this.standbyFlag1 = rs.getString("StandbyFlag1").trim();
/*      */       }
/* 2262 */       if (rs.getString("StandbyFlag2") == null)
/* 2263 */         this.standbyFlag2 = null;
/*      */       else {
/* 2265 */         this.standbyFlag2 = rs.getString("StandbyFlag2").trim();
/*      */       }
/* 2267 */       if (rs.getString("StandbyFlag3") == null)
/* 2268 */         this.standbyFlag3 = null;
/*      */       else {
/* 2270 */         this.standbyFlag3 = rs.getString("StandbyFlag3").trim();
/*      */       }
/* 2272 */       if (rs.getString("Operator") == null)
/* 2273 */         this.operator = null;
/*      */       else {
/* 2275 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/* 2277 */       this.makeDate = rs.getDate("MakeDate");
/* 2278 */       if (rs.getString("MakeTime") == null)
/* 2279 */         this.makeTime = null;
/*      */       else {
/* 2281 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/* 2283 */       this.modifyDate = rs.getDate("ModifyDate");
/* 2284 */       if (rs.getString("ModifyTime") == null)
/* 2285 */         this.modifyTime = null;
/*      */       else {
/* 2287 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 2292 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPPol\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/* 2294 */       CError tError = new CError();
/* 2295 */       tError.moduleName = "LNPPolSchema";
/* 2296 */       tError.functionName = "setSchema";
/* 2297 */       tError.errorMessage = sqle.toString();
/* 2298 */       this.mErrors.addOneError(tError);
/* 2299 */       return false;
/*      */     }
/* 2301 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPPolSchema getSchema()
/*      */   {
/* 2306 */     LNPPolSchema aLNPPolSchema = new LNPPolSchema();
/* 2307 */     aLNPPolSchema.setSchema(this);
/* 2308 */     return aLNPPolSchema;
/*      */   }
/*      */ 
/*      */   public LNPPolDB getDB()
/*      */   {
/* 2313 */     LNPPolDB aDBOper = new LNPPolDB();
/* 2314 */     aDBOper.setSchema(this);
/* 2315 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 2322 */     StringBuffer strReturn = new StringBuffer(256);
/* 2323 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/* 2324 */     strReturn.append(StrTool.cTrim(this.grpPolNo)); strReturn.append("|");
/* 2325 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/* 2326 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/* 2327 */     strReturn.append(StrTool.cTrim(this.polNo)); strReturn.append("|");
/* 2328 */     strReturn.append(StrTool.cTrim(this.proposalNo)); strReturn.append("|");
/* 2329 */     strReturn.append(StrTool.cTrim(this.prtNo)); strReturn.append("|");
/* 2330 */     strReturn.append(StrTool.cTrim(this.contType)); strReturn.append("|");
/* 2331 */     strReturn.append(StrTool.cTrim(this.polTypeFlag)); strReturn.append("|");
/* 2332 */     strReturn.append(StrTool.cTrim(this.mainPolNo)); strReturn.append("|");
/* 2333 */     strReturn.append(StrTool.cTrim(this.masterPolNo)); strReturn.append("|");
/* 2334 */     strReturn.append(StrTool.cTrim(this.kindCode)); strReturn.append("|");
/* 2335 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/* 2336 */     strReturn.append(StrTool.cTrim(this.riskVersion)); strReturn.append("|");
/* 2337 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/* 2338 */     strReturn.append(StrTool.cTrim(this.agentCom)); strReturn.append("|");
/* 2339 */     strReturn.append(StrTool.cTrim(this.agentType)); strReturn.append("|");
/* 2340 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/* 2341 */     strReturn.append(StrTool.cTrim(this.agentGroup)); strReturn.append("|");
/* 2342 */     strReturn.append(StrTool.cTrim(this.agentGroup1)); strReturn.append("|");
/* 2343 */     strReturn.append(StrTool.cTrim(this.agentCode1)); strReturn.append("|");
/* 2344 */     strReturn.append(StrTool.cTrim(this.saleChnl)); strReturn.append("|");
/* 2345 */     strReturn.append(StrTool.cTrim(this.handler)); strReturn.append("|");
/* 2346 */     strReturn.append(StrTool.cTrim(this.insuredNo)); strReturn.append("|");
/* 2347 */     strReturn.append(StrTool.cTrim(this.insuredId)); strReturn.append("|");
/* 2348 */     strReturn.append(StrTool.cTrim(this.insuredName)); strReturn.append("|");
/* 2349 */     strReturn.append(StrTool.cTrim(this.insuredSex)); strReturn.append("|");
/* 2350 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.insuredBirthday))); strReturn.append("|");
/* 2351 */     strReturn.append(ChgData.chgData(this.insuredAppAge)); strReturn.append("|");
/* 2352 */     strReturn.append(ChgData.chgData(this.insuredPeoples)); strReturn.append("|");
/* 2353 */     strReturn.append(StrTool.cTrim(this.occupationType)); strReturn.append("|");
/* 2354 */     strReturn.append(StrTool.cTrim(this.appntNo)); strReturn.append("|");
/* 2355 */     strReturn.append(StrTool.cTrim(this.appntName)); strReturn.append("|");
/* 2356 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.cValiDate))); strReturn.append("|");
/* 2357 */     strReturn.append(StrTool.cTrim(this.signCom)); strReturn.append("|");
/* 2358 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.signDate))); strReturn.append("|");
/* 2359 */     strReturn.append(StrTool.cTrim(this.signTime)); strReturn.append("|");
/* 2360 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.firstPayDate))); strReturn.append("|");
/* 2361 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.payEndDate))); strReturn.append("|");
/* 2362 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.paytoDate))); strReturn.append("|");
/* 2363 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.getStartDate))); strReturn.append("|");
/* 2364 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/* 2365 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.acciEndDate))); strReturn.append("|");
/* 2366 */     strReturn.append(StrTool.cTrim(this.getYearFlag)); strReturn.append("|");
/* 2367 */     strReturn.append(ChgData.chgData(this.getYear)); strReturn.append("|");
/* 2368 */     strReturn.append(StrTool.cTrim(this.payEndYearFlag)); strReturn.append("|");
/* 2369 */     strReturn.append(ChgData.chgData(this.payEndYear)); strReturn.append("|");
/* 2370 */     strReturn.append(StrTool.cTrim(this.insuYearFlag)); strReturn.append("|");
/* 2371 */     strReturn.append(ChgData.chgData(this.insuYear)); strReturn.append("|");
/* 2372 */     strReturn.append(StrTool.cTrim(this.acciYearFlag)); strReturn.append("|");
/* 2373 */     strReturn.append(ChgData.chgData(this.acciYear)); strReturn.append("|");
/* 2374 */     strReturn.append(StrTool.cTrim(this.getStartType)); strReturn.append("|");
/* 2375 */     strReturn.append(StrTool.cTrim(this.specifyValiDate)); strReturn.append("|");
/* 2376 */     strReturn.append(StrTool.cTrim(this.payMode)); strReturn.append("|");
/* 2377 */     strReturn.append(StrTool.cTrim(this.payLocation)); strReturn.append("|");
/* 2378 */     strReturn.append(ChgData.chgData(this.payIntv)); strReturn.append("|");
/* 2379 */     strReturn.append(ChgData.chgData(this.payYears)); strReturn.append("|");
/* 2380 */     strReturn.append(ChgData.chgData(this.years)); strReturn.append("|");
/* 2381 */     strReturn.append(ChgData.chgData(this.manageFeeRate)); strReturn.append("|");
/* 2382 */     strReturn.append(ChgData.chgData(this.floatRate)); strReturn.append("|");
/* 2383 */     strReturn.append(ChgData.chgData(this.premRate)); strReturn.append("|");
/* 2384 */     strReturn.append(StrTool.cTrim(this.premToAmnt)); strReturn.append("|");
/* 2385 */     strReturn.append(ChgData.chgData(this.mult)); strReturn.append("|");
/* 2386 */     strReturn.append(ChgData.chgData(this.standPrem)); strReturn.append("|");
/* 2387 */     strReturn.append(ChgData.chgData(this.prem)); strReturn.append("|");
/* 2388 */     strReturn.append(ChgData.chgData(this.sumPrem)); strReturn.append("|");
/* 2389 */     strReturn.append(ChgData.chgData(this.amnt)); strReturn.append("|");
/* 2390 */     strReturn.append(ChgData.chgData(this.riskAmnt)); strReturn.append("|");
/* 2391 */     strReturn.append(ChgData.chgData(this.leavingMoney)); strReturn.append("|");
/* 2392 */     strReturn.append(ChgData.chgData(this.endorseTimes)); strReturn.append("|");
/* 2393 */     strReturn.append(ChgData.chgData(this.claimTimes)); strReturn.append("|");
/* 2394 */     strReturn.append(ChgData.chgData(this.liveTimes)); strReturn.append("|");
/* 2395 */     strReturn.append(ChgData.chgData(this.renewCount)); strReturn.append("|");
/* 2396 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.lastGetDate))); strReturn.append("|");
/* 2397 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.lastLoanDate))); strReturn.append("|");
/* 2398 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.lastRegetDate))); strReturn.append("|");
/* 2399 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.lastEdorDate))); strReturn.append("|");
/* 2400 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.lastRevDate))); strReturn.append("|");
/* 2401 */     strReturn.append(StrTool.cTrim(this.rnewFlag)); strReturn.append("|");
/* 2402 */     strReturn.append(StrTool.cTrim(this.stopFlag)); strReturn.append("|");
/* 2403 */     strReturn.append(StrTool.cTrim(this.expiryFlag)); strReturn.append("|");
/* 2404 */     strReturn.append(StrTool.cTrim(this.autoPayFlag)); strReturn.append("|");
/* 2405 */     strReturn.append(StrTool.cTrim(this.interestDifFlag)); strReturn.append("|");
/* 2406 */     strReturn.append(StrTool.cTrim(this.subFlag)); strReturn.append("|");
/* 2407 */     strReturn.append(StrTool.cTrim(this.bnfFlag)); strReturn.append("|");
/* 2408 */     strReturn.append(StrTool.cTrim(this.healthCheckFlag)); strReturn.append("|");
/* 2409 */     strReturn.append(StrTool.cTrim(this.impartFlag)); strReturn.append("|");
/* 2410 */     strReturn.append(StrTool.cTrim(this.reinsureFlag)); strReturn.append("|");
/* 2411 */     strReturn.append(StrTool.cTrim(this.agentPayFlag)); strReturn.append("|");
/* 2412 */     strReturn.append(StrTool.cTrim(this.agentGetFlag)); strReturn.append("|");
/* 2413 */     strReturn.append(StrTool.cTrim(this.liveGetMode)); strReturn.append("|");
/* 2414 */     strReturn.append(StrTool.cTrim(this.deadGetMode)); strReturn.append("|");
/* 2415 */     strReturn.append(StrTool.cTrim(this.bonusGetMode)); strReturn.append("|");
/* 2416 */     strReturn.append(StrTool.cTrim(this.deadAmntType)); strReturn.append("|");
/* 2417 */     strReturn.append(ChgData.chgData(this.topUpPrem)); strReturn.append("|");
/* 2418 */     strReturn.append(StrTool.cTrim(this.bonusMan)); strReturn.append("|");
/* 2419 */     strReturn.append(StrTool.cTrim(this.deadFlag)); strReturn.append("|");
/* 2420 */     strReturn.append(StrTool.cTrim(this.smokeFlag)); strReturn.append("|");
/* 2421 */     strReturn.append(StrTool.cTrim(this.remark)); strReturn.append("|");
/* 2422 */     strReturn.append(StrTool.cTrim(this.approveFlag)); strReturn.append("|");
/* 2423 */     strReturn.append(StrTool.cTrim(this.approveCode)); strReturn.append("|");
/* 2424 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.approveDate))); strReturn.append("|");
/* 2425 */     strReturn.append(StrTool.cTrim(this.approveTime)); strReturn.append("|");
/* 2426 */     strReturn.append(StrTool.cTrim(this.uWFlag)); strReturn.append("|");
/* 2427 */     strReturn.append(StrTool.cTrim(this.uWCode)); strReturn.append("|");
/* 2428 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.uWDate))); strReturn.append("|");
/* 2429 */     strReturn.append(StrTool.cTrim(this.uWTime)); strReturn.append("|");
/* 2430 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.polApplyDate))); strReturn.append("|");
/* 2431 */     strReturn.append(StrTool.cTrim(this.appFlag)); strReturn.append("|");
/* 2432 */     strReturn.append(StrTool.cTrim(this.saleChnlDetail)); strReturn.append("|");
/* 2433 */     strReturn.append(StrTool.cTrim(this.polState)); strReturn.append("|");
/* 2434 */     strReturn.append(StrTool.cTrim(this.standbyFlag1)); strReturn.append("|");
/* 2435 */     strReturn.append(StrTool.cTrim(this.standbyFlag2)); strReturn.append("|");
/* 2436 */     strReturn.append(StrTool.cTrim(this.standbyFlag3)); strReturn.append("|");
/* 2437 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 2438 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 2439 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 2440 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 2441 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/* 2442 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 2450 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 2451 */       this.grpPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 2452 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 2453 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 2454 */       this.polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 2455 */       this.proposalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 2456 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 2457 */       this.contType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 2458 */       this.polTypeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 2459 */       this.mainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 2460 */       this.masterPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 2461 */       this.kindCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 2462 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 2463 */       this.riskVersion = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 2464 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 2465 */       this.agentCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 2466 */       this.agentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 2467 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 2468 */       this.agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 2469 */       this.agentGroup1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 2470 */       this.agentCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 2471 */       this.saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 2472 */       this.handler = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 2473 */       this.insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 2474 */       this.insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 2475 */       this.insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 2476 */       this.insuredSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 2477 */       this.insuredBirthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
/* 2478 */       this.insuredAppAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|"))).intValue();
/* 2479 */       this.insuredPeoples = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 30, "|"))).intValue();
/* 2480 */       this.occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/* 2481 */       this.appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 2482 */       this.appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 2483 */       this.cValiDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|"));
/* 2484 */       this.signCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 2485 */       this.signDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|"));
/* 2486 */       this.signTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 2487 */       this.firstPayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|"));
/* 2488 */       this.payEndDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|"));
/* 2489 */       this.paytoDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|"));
/* 2490 */       this.getStartDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|"));
/* 2491 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|"));
/* 2492 */       this.acciEndDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|"));
/* 2493 */       this.getYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 2494 */       this.getYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 45, "|"))).intValue();
/* 2495 */       this.payEndYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 2496 */       this.payEndYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 47, "|"))).intValue();
/* 2497 */       this.insuYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 2498 */       this.insuYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 49, "|"))).intValue();
/* 2499 */       this.acciYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
/* 2500 */       this.acciYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 51, "|"))).intValue();
/* 2501 */       this.getStartType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
/* 2502 */       this.specifyValiDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
/* 2503 */       this.payMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
/* 2504 */       this.payLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
/* 2505 */       this.payIntv = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 56, "|"))).intValue();
/* 2506 */       this.payYears = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|"))).intValue();
/* 2507 */       this.years = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|"))).intValue();
/* 2508 */       this.manageFeeRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|"))).doubleValue();
/* 2509 */       this.floatRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|"))).doubleValue();
/* 2510 */       this.premRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|"))).doubleValue();
/* 2511 */       this.premToAmnt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 62, "|");
/* 2512 */       this.mult = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 63, "|"))).doubleValue();
/* 2513 */       this.standPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 64, "|"))).doubleValue();
/* 2514 */       this.prem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 65, "|"))).doubleValue();
/* 2515 */       this.sumPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 66, "|"))).doubleValue();
/* 2516 */       this.amnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 67, "|"))).doubleValue();
/* 2517 */       this.riskAmnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 68, "|"))).doubleValue();
/* 2518 */       this.leavingMoney = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 69, "|"))).doubleValue();
/* 2519 */       this.endorseTimes = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 70, "|"))).intValue();
/* 2520 */       this.claimTimes = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 71, "|"))).intValue();
/* 2521 */       this.liveTimes = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 72, "|"))).intValue();
/* 2522 */       this.renewCount = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 73, "|"))).intValue();
/* 2523 */       this.lastGetDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 74, "|"));
/* 2524 */       this.lastLoanDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 75, "|"));
/* 2525 */       this.lastRegetDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 76, "|"));
/* 2526 */       this.lastEdorDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 77, "|"));
/* 2527 */       this.lastRevDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 78, "|"));
/* 2528 */       this.rnewFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 79, "|");
/* 2529 */       this.stopFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 80, "|");
/* 2530 */       this.expiryFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 81, "|");
/* 2531 */       this.autoPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 82, "|");
/* 2532 */       this.interestDifFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 83, "|");
/* 2533 */       this.subFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 84, "|");
/* 2534 */       this.bnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 85, "|");
/* 2535 */       this.healthCheckFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 86, "|");
/* 2536 */       this.impartFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 87, "|");
/* 2537 */       this.reinsureFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 88, "|");
/* 2538 */       this.agentPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 89, "|");
/* 2539 */       this.agentGetFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 90, "|");
/* 2540 */       this.liveGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 91, "|");
/* 2541 */       this.deadGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 92, "|");
/* 2542 */       this.bonusGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 93, "|");
/* 2543 */       this.deadAmntType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 94, "|");
/* 2544 */       this.topUpPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 95, "|"))).doubleValue();
/* 2545 */       this.bonusMan = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 96, "|");
/* 2546 */       this.deadFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 97, "|");
/* 2547 */       this.smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 98, "|");
/* 2548 */       this.remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 99, "|");
/* 2549 */       this.approveFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 100, "|");
/* 2550 */       this.approveCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 101, "|");
/* 2551 */       this.approveDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 102, "|"));
/* 2552 */       this.approveTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 103, "|");
/* 2553 */       this.uWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 104, "|");
/* 2554 */       this.uWCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 105, "|");
/* 2555 */       this.uWDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 106, "|"));
/* 2556 */       this.uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 107, "|");
/* 2557 */       this.polApplyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 108, "|"));
/* 2558 */       this.appFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 109, "|");
/* 2559 */       this.saleChnlDetail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 110, "|");
/* 2560 */       this.polState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 111, "|");
/* 2561 */       this.standbyFlag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 112, "|");
/* 2562 */       this.standbyFlag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 113, "|");
/* 2563 */       this.standbyFlag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 114, "|");
/* 2564 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 115, "|");
/* 2565 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 116, "|"));
/* 2566 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 117, "|");
/* 2567 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 118, "|"));
/* 2568 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 119, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 2573 */       CError tError = new CError();
/* 2574 */       tError.moduleName = "LNPPolSchema";
/* 2575 */       tError.functionName = "decode";
/* 2576 */       tError.errorMessage = ex.toString();
/* 2577 */       this.mErrors.addOneError(tError);
/*      */ 
/* 2579 */       return false;
/*      */     }
/* 2581 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 2587 */     String strReturn = "";
/* 2588 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 2590 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/* 2592 */     if (FCode.equalsIgnoreCase("grpPolNo"))
/*      */     {
/* 2594 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpPolNo));
/*      */     }
/* 2596 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 2598 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/* 2600 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 2602 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/* 2604 */     if (FCode.equalsIgnoreCase("polNo"))
/*      */     {
/* 2606 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polNo));
/*      */     }
/* 2608 */     if (FCode.equalsIgnoreCase("proposalNo"))
/*      */     {
/* 2610 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalNo));
/*      */     }
/* 2612 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/* 2614 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/* 2616 */     if (FCode.equalsIgnoreCase("contType"))
/*      */     {
/* 2618 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contType));
/*      */     }
/* 2620 */     if (FCode.equalsIgnoreCase("polTypeFlag"))
/*      */     {
/* 2622 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polTypeFlag));
/*      */     }
/* 2624 */     if (FCode.equalsIgnoreCase("mainPolNo"))
/*      */     {
/* 2626 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mainPolNo));
/*      */     }
/* 2628 */     if (FCode.equalsIgnoreCase("masterPolNo"))
/*      */     {
/* 2630 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.masterPolNo));
/*      */     }
/* 2632 */     if (FCode.equalsIgnoreCase("kindCode"))
/*      */     {
/* 2634 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.kindCode));
/*      */     }
/* 2636 */     if (FCode.equalsIgnoreCase("riskCode"))
/*      */     {
/* 2638 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*      */     }
/* 2640 */     if (FCode.equalsIgnoreCase("riskVersion"))
/*      */     {
/* 2642 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskVersion));
/*      */     }
/* 2644 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 2646 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 2648 */     if (FCode.equalsIgnoreCase("agentCom"))
/*      */     {
/* 2650 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCom));
/*      */     }
/* 2652 */     if (FCode.equalsIgnoreCase("agentType"))
/*      */     {
/* 2654 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentType));
/*      */     }
/* 2656 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 2658 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/* 2660 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*      */     {
/* 2662 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup));
/*      */     }
/* 2664 */     if (FCode.equalsIgnoreCase("agentGroup1"))
/*      */     {
/* 2666 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup1));
/*      */     }
/* 2668 */     if (FCode.equalsIgnoreCase("agentCode1"))
/*      */     {
/* 2670 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode1));
/*      */     }
/* 2672 */     if (FCode.equalsIgnoreCase("saleChnl"))
/*      */     {
/* 2674 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.saleChnl));
/*      */     }
/* 2676 */     if (FCode.equalsIgnoreCase("handler"))
/*      */     {
/* 2678 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.handler));
/*      */     }
/* 2680 */     if (FCode.equalsIgnoreCase("insuredNo"))
/*      */     {
/* 2682 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredNo));
/*      */     }
/* 2684 */     if (FCode.equalsIgnoreCase("insuredId"))
/*      */     {
/* 2686 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredId));
/*      */     }
/* 2688 */     if (FCode.equalsIgnoreCase("insuredName"))
/*      */     {
/* 2690 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredName));
/*      */     }
/* 2692 */     if (FCode.equalsIgnoreCase("insuredSex"))
/*      */     {
/* 2694 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredSex));
/*      */     }
/* 2696 */     if (FCode.equalsIgnoreCase("insuredBirthday"))
/*      */     {
/* 2698 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getInsuredBirthday()));
/*      */     }
/* 2700 */     if (FCode.equalsIgnoreCase("insuredAppAge"))
/*      */     {
/* 2702 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredAppAge));
/*      */     }
/* 2704 */     if (FCode.equalsIgnoreCase("insuredPeoples"))
/*      */     {
/* 2706 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredPeoples));
/*      */     }
/* 2708 */     if (FCode.equalsIgnoreCase("occupationType"))
/*      */     {
/* 2710 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationType));
/*      */     }
/* 2712 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/* 2714 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntNo));
/*      */     }
/* 2716 */     if (FCode.equalsIgnoreCase("appntName"))
/*      */     {
/* 2718 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntName));
/*      */     }
/* 2720 */     if (FCode.equalsIgnoreCase("cValiDate"))
/*      */     {
/* 2722 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCValiDate()));
/*      */     }
/* 2724 */     if (FCode.equalsIgnoreCase("signCom"))
/*      */     {
/* 2726 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signCom));
/*      */     }
/* 2728 */     if (FCode.equalsIgnoreCase("signDate"))
/*      */     {
/* 2730 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
/*      */     }
/* 2732 */     if (FCode.equalsIgnoreCase("signTime"))
/*      */     {
/* 2734 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signTime));
/*      */     }
/* 2736 */     if (FCode.equalsIgnoreCase("firstPayDate"))
/*      */     {
/* 2738 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getFirstPayDate()));
/*      */     }
/* 2740 */     if (FCode.equalsIgnoreCase("payEndDate"))
/*      */     {
/* 2742 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPayEndDate()));
/*      */     }
/* 2744 */     if (FCode.equalsIgnoreCase("paytoDate"))
/*      */     {
/* 2746 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPaytoDate()));
/*      */     }
/* 2748 */     if (FCode.equalsIgnoreCase("getStartDate"))
/*      */     {
/* 2750 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getGetStartDate()));
/*      */     }
/* 2752 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 2754 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/* 2756 */     if (FCode.equalsIgnoreCase("acciEndDate"))
/*      */     {
/* 2758 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getAcciEndDate()));
/*      */     }
/* 2760 */     if (FCode.equalsIgnoreCase("getYearFlag"))
/*      */     {
/* 2762 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getYearFlag));
/*      */     }
/* 2764 */     if (FCode.equalsIgnoreCase("getYear"))
/*      */     {
/* 2766 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getYear));
/*      */     }
/* 2768 */     if (FCode.equalsIgnoreCase("payEndYearFlag"))
/*      */     {
/* 2770 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndYearFlag));
/*      */     }
/* 2772 */     if (FCode.equalsIgnoreCase("payEndYear"))
/*      */     {
/* 2774 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndYear));
/*      */     }
/* 2776 */     if (FCode.equalsIgnoreCase("insuYearFlag"))
/*      */     {
/* 2778 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuYearFlag));
/*      */     }
/* 2780 */     if (FCode.equalsIgnoreCase("insuYear"))
/*      */     {
/* 2782 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuYear));
/*      */     }
/* 2784 */     if (FCode.equalsIgnoreCase("acciYearFlag"))
/*      */     {
/* 2786 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.acciYearFlag));
/*      */     }
/* 2788 */     if (FCode.equalsIgnoreCase("acciYear"))
/*      */     {
/* 2790 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.acciYear));
/*      */     }
/* 2792 */     if (FCode.equalsIgnoreCase("getStartType"))
/*      */     {
/* 2794 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getStartType));
/*      */     }
/* 2796 */     if (FCode.equalsIgnoreCase("specifyValiDate"))
/*      */     {
/* 2798 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specifyValiDate));
/*      */     }
/* 2800 */     if (FCode.equalsIgnoreCase("payMode"))
/*      */     {
/* 2802 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payMode));
/*      */     }
/* 2804 */     if (FCode.equalsIgnoreCase("payLocation"))
/*      */     {
/* 2806 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payLocation));
/*      */     }
/* 2808 */     if (FCode.equalsIgnoreCase("payIntv"))
/*      */     {
/* 2810 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payIntv));
/*      */     }
/* 2812 */     if (FCode.equalsIgnoreCase("payYears"))
/*      */     {
/* 2814 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payYears));
/*      */     }
/* 2816 */     if (FCode.equalsIgnoreCase("years"))
/*      */     {
/* 2818 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.years));
/*      */     }
/* 2820 */     if (FCode.equalsIgnoreCase("manageFeeRate"))
/*      */     {
/* 2822 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageFeeRate));
/*      */     }
/* 2824 */     if (FCode.equalsIgnoreCase("floatRate"))
/*      */     {
/* 2826 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.floatRate));
/*      */     }
/* 2828 */     if (FCode.equalsIgnoreCase("premRate"))
/*      */     {
/* 2830 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.premRate));
/*      */     }
/* 2832 */     if (FCode.equalsIgnoreCase("premToAmnt"))
/*      */     {
/* 2834 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.premToAmnt));
/*      */     }
/* 2836 */     if (FCode.equalsIgnoreCase("mult"))
/*      */     {
/* 2838 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mult));
/*      */     }
/* 2840 */     if (FCode.equalsIgnoreCase("standPrem"))
/*      */     {
/* 2842 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.standPrem));
/*      */     }
/* 2844 */     if (FCode.equalsIgnoreCase("prem"))
/*      */     {
/* 2846 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prem));
/*      */     }
/* 2848 */     if (FCode.equalsIgnoreCase("sumPrem"))
/*      */     {
/* 2850 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sumPrem));
/*      */     }
/* 2852 */     if (FCode.equalsIgnoreCase("amnt"))
/*      */     {
/* 2854 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.amnt));
/*      */     }
/* 2856 */     if (FCode.equalsIgnoreCase("riskAmnt"))
/*      */     {
/* 2858 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskAmnt));
/*      */     }
/* 2860 */     if (FCode.equalsIgnoreCase("leavingMoney"))
/*      */     {
/* 2862 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.leavingMoney));
/*      */     }
/* 2864 */     if (FCode.equalsIgnoreCase("endorseTimes"))
/*      */     {
/* 2866 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endorseTimes));
/*      */     }
/* 2868 */     if (FCode.equalsIgnoreCase("claimTimes"))
/*      */     {
/* 2870 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.claimTimes));
/*      */     }
/* 2872 */     if (FCode.equalsIgnoreCase("liveTimes"))
/*      */     {
/* 2874 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.liveTimes));
/*      */     }
/* 2876 */     if (FCode.equalsIgnoreCase("renewCount"))
/*      */     {
/* 2878 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.renewCount));
/*      */     }
/* 2880 */     if (FCode.equalsIgnoreCase("lastGetDate"))
/*      */     {
/* 2882 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getLastGetDate()));
/*      */     }
/* 2884 */     if (FCode.equalsIgnoreCase("lastLoanDate"))
/*      */     {
/* 2886 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getLastLoanDate()));
/*      */     }
/* 2888 */     if (FCode.equalsIgnoreCase("lastRegetDate"))
/*      */     {
/* 2890 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getLastRegetDate()));
/*      */     }
/* 2892 */     if (FCode.equalsIgnoreCase("lastEdorDate"))
/*      */     {
/* 2894 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getLastEdorDate()));
/*      */     }
/* 2896 */     if (FCode.equalsIgnoreCase("lastRevDate"))
/*      */     {
/* 2898 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getLastRevDate()));
/*      */     }
/* 2900 */     if (FCode.equalsIgnoreCase("rnewFlag"))
/*      */     {
/* 2902 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rnewFlag));
/*      */     }
/* 2904 */     if (FCode.equalsIgnoreCase("stopFlag"))
/*      */     {
/* 2906 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stopFlag));
/*      */     }
/* 2908 */     if (FCode.equalsIgnoreCase("expiryFlag"))
/*      */     {
/* 2910 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.expiryFlag));
/*      */     }
/* 2912 */     if (FCode.equalsIgnoreCase("autoPayFlag"))
/*      */     {
/* 2914 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.autoPayFlag));
/*      */     }
/* 2916 */     if (FCode.equalsIgnoreCase("interestDifFlag"))
/*      */     {
/* 2918 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.interestDifFlag));
/*      */     }
/* 2920 */     if (FCode.equalsIgnoreCase("subFlag"))
/*      */     {
/* 2922 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.subFlag));
/*      */     }
/* 2924 */     if (FCode.equalsIgnoreCase("bnfFlag"))
/*      */     {
/* 2926 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfFlag));
/*      */     }
/* 2928 */     if (FCode.equalsIgnoreCase("healthCheckFlag"))
/*      */     {
/* 2930 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.healthCheckFlag));
/*      */     }
/* 2932 */     if (FCode.equalsIgnoreCase("impartFlag"))
/*      */     {
/* 2934 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartFlag));
/*      */     }
/* 2936 */     if (FCode.equalsIgnoreCase("reinsureFlag"))
/*      */     {
/* 2938 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.reinsureFlag));
/*      */     }
/* 2940 */     if (FCode.equalsIgnoreCase("agentPayFlag"))
/*      */     {
/* 2942 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentPayFlag));
/*      */     }
/* 2944 */     if (FCode.equalsIgnoreCase("agentGetFlag"))
/*      */     {
/* 2946 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGetFlag));
/*      */     }
/* 2948 */     if (FCode.equalsIgnoreCase("liveGetMode"))
/*      */     {
/* 2950 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.liveGetMode));
/*      */     }
/* 2952 */     if (FCode.equalsIgnoreCase("deadGetMode"))
/*      */     {
/* 2954 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.deadGetMode));
/*      */     }
/* 2956 */     if (FCode.equalsIgnoreCase("bonusGetMode"))
/*      */     {
/* 2958 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bonusGetMode));
/*      */     }
/* 2960 */     if (FCode.equalsIgnoreCase("deadAmntType"))
/*      */     {
/* 2962 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.deadAmntType));
/*      */     }
/* 2964 */     if (FCode.equalsIgnoreCase("topUpPrem"))
/*      */     {
/* 2966 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.topUpPrem));
/*      */     }
/* 2968 */     if (FCode.equalsIgnoreCase("bonusMan"))
/*      */     {
/* 2970 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bonusMan));
/*      */     }
/* 2972 */     if (FCode.equalsIgnoreCase("deadFlag"))
/*      */     {
/* 2974 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.deadFlag));
/*      */     }
/* 2976 */     if (FCode.equalsIgnoreCase("smokeFlag"))
/*      */     {
/* 2978 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.smokeFlag));
/*      */     }
/* 2980 */     if (FCode.equalsIgnoreCase("remark"))
/*      */     {
/* 2982 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark));
/*      */     }
/* 2984 */     if (FCode.equalsIgnoreCase("approveFlag"))
/*      */     {
/* 2986 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveFlag));
/*      */     }
/* 2988 */     if (FCode.equalsIgnoreCase("approveCode"))
/*      */     {
/* 2990 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveCode));
/*      */     }
/* 2992 */     if (FCode.equalsIgnoreCase("approveDate"))
/*      */     {
/* 2994 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getApproveDate()));
/*      */     }
/* 2996 */     if (FCode.equalsIgnoreCase("approveTime"))
/*      */     {
/* 2998 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveTime));
/*      */     }
/* 3000 */     if (FCode.equalsIgnoreCase("uWFlag"))
/*      */     {
/* 3002 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWFlag));
/*      */     }
/* 3004 */     if (FCode.equalsIgnoreCase("uWCode"))
/*      */     {
/* 3006 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWCode));
/*      */     }
/* 3008 */     if (FCode.equalsIgnoreCase("uWDate"))
/*      */     {
/* 3010 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
/*      */     }
/* 3012 */     if (FCode.equalsIgnoreCase("uWTime"))
/*      */     {
/* 3014 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWTime));
/*      */     }
/* 3016 */     if (FCode.equalsIgnoreCase("polApplyDate"))
/*      */     {
/* 3018 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPolApplyDate()));
/*      */     }
/* 3020 */     if (FCode.equalsIgnoreCase("appFlag"))
/*      */     {
/* 3022 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appFlag));
/*      */     }
/* 3024 */     if (FCode.equalsIgnoreCase("saleChnlDetail"))
/*      */     {
/* 3026 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.saleChnlDetail));
/*      */     }
/* 3028 */     if (FCode.equalsIgnoreCase("polState"))
/*      */     {
/* 3030 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polState));
/*      */     }
/* 3032 */     if (FCode.equalsIgnoreCase("standbyFlag1"))
/*      */     {
/* 3034 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.standbyFlag1));
/*      */     }
/* 3036 */     if (FCode.equalsIgnoreCase("standbyFlag2"))
/*      */     {
/* 3038 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.standbyFlag2));
/*      */     }
/* 3040 */     if (FCode.equalsIgnoreCase("standbyFlag3"))
/*      */     {
/* 3042 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.standbyFlag3));
/*      */     }
/* 3044 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 3046 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 3048 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 3050 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 3052 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 3054 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 3056 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 3058 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 3060 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 3062 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 3064 */     if (strReturn.equals(""))
/*      */     {
/* 3066 */       strReturn = "null";
/*      */     }
/*      */ 
/* 3069 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 3076 */     String strFieldValue = "";
/* 3077 */     switch (nFieldIndex) {
/*      */     case 0:
/* 3079 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/* 3080 */       break;
/*      */     case 1:
/* 3082 */       strFieldValue = StrTool.GBKToUnicode(this.grpPolNo);
/* 3083 */       break;
/*      */     case 2:
/* 3085 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 3086 */       break;
/*      */     case 3:
/* 3088 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/* 3089 */       break;
/*      */     case 4:
/* 3091 */       strFieldValue = StrTool.GBKToUnicode(this.polNo);
/* 3092 */       break;
/*      */     case 5:
/* 3094 */       strFieldValue = StrTool.GBKToUnicode(this.proposalNo);
/* 3095 */       break;
/*      */     case 6:
/* 3097 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/* 3098 */       break;
/*      */     case 7:
/* 3100 */       strFieldValue = StrTool.GBKToUnicode(this.contType);
/* 3101 */       break;
/*      */     case 8:
/* 3103 */       strFieldValue = StrTool.GBKToUnicode(this.polTypeFlag);
/* 3104 */       break;
/*      */     case 9:
/* 3106 */       strFieldValue = StrTool.GBKToUnicode(this.mainPolNo);
/* 3107 */       break;
/*      */     case 10:
/* 3109 */       strFieldValue = StrTool.GBKToUnicode(this.masterPolNo);
/* 3110 */       break;
/*      */     case 11:
/* 3112 */       strFieldValue = StrTool.GBKToUnicode(this.kindCode);
/* 3113 */       break;
/*      */     case 12:
/* 3115 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 3116 */       break;
/*      */     case 13:
/* 3118 */       strFieldValue = StrTool.GBKToUnicode(this.riskVersion);
/* 3119 */       break;
/*      */     case 14:
/* 3121 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 3122 */       break;
/*      */     case 15:
/* 3124 */       strFieldValue = StrTool.GBKToUnicode(this.agentCom);
/* 3125 */       break;
/*      */     case 16:
/* 3127 */       strFieldValue = StrTool.GBKToUnicode(this.agentType);
/* 3128 */       break;
/*      */     case 17:
/* 3130 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/* 3131 */       break;
/*      */     case 18:
/* 3133 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup);
/* 3134 */       break;
/*      */     case 19:
/* 3136 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup1);
/* 3137 */       break;
/*      */     case 20:
/* 3139 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode1);
/* 3140 */       break;
/*      */     case 21:
/* 3142 */       strFieldValue = StrTool.GBKToUnicode(this.saleChnl);
/* 3143 */       break;
/*      */     case 22:
/* 3145 */       strFieldValue = StrTool.GBKToUnicode(this.handler);
/* 3146 */       break;
/*      */     case 23:
/* 3148 */       strFieldValue = StrTool.GBKToUnicode(this.insuredNo);
/* 3149 */       break;
/*      */     case 24:
/* 3151 */       strFieldValue = StrTool.GBKToUnicode(this.insuredId);
/* 3152 */       break;
/*      */     case 25:
/* 3154 */       strFieldValue = StrTool.GBKToUnicode(this.insuredName);
/* 3155 */       break;
/*      */     case 26:
/* 3157 */       strFieldValue = StrTool.GBKToUnicode(this.insuredSex);
/* 3158 */       break;
/*      */     case 27:
/* 3160 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getInsuredBirthday()));
/* 3161 */       break;
/*      */     case 28:
/* 3163 */       strFieldValue = String.valueOf(this.insuredAppAge);
/* 3164 */       break;
/*      */     case 29:
/* 3166 */       strFieldValue = String.valueOf(this.insuredPeoples);
/* 3167 */       break;
/*      */     case 30:
/* 3169 */       strFieldValue = StrTool.GBKToUnicode(this.occupationType);
/* 3170 */       break;
/*      */     case 31:
/* 3172 */       strFieldValue = StrTool.GBKToUnicode(this.appntNo);
/* 3173 */       break;
/*      */     case 32:
/* 3175 */       strFieldValue = StrTool.GBKToUnicode(this.appntName);
/* 3176 */       break;
/*      */     case 33:
/* 3178 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCValiDate()));
/* 3179 */       break;
/*      */     case 34:
/* 3181 */       strFieldValue = StrTool.GBKToUnicode(this.signCom);
/* 3182 */       break;
/*      */     case 35:
/* 3184 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
/* 3185 */       break;
/*      */     case 36:
/* 3187 */       strFieldValue = StrTool.GBKToUnicode(this.signTime);
/* 3188 */       break;
/*      */     case 37:
/* 3190 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getFirstPayDate()));
/* 3191 */       break;
/*      */     case 38:
/* 3193 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPayEndDate()));
/* 3194 */       break;
/*      */     case 39:
/* 3196 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPaytoDate()));
/* 3197 */       break;
/*      */     case 40:
/* 3199 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getGetStartDate()));
/* 3200 */       break;
/*      */     case 41:
/* 3202 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/* 3203 */       break;
/*      */     case 42:
/* 3205 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getAcciEndDate()));
/* 3206 */       break;
/*      */     case 43:
/* 3208 */       strFieldValue = StrTool.GBKToUnicode(this.getYearFlag);
/* 3209 */       break;
/*      */     case 44:
/* 3211 */       strFieldValue = String.valueOf(this.getYear);
/* 3212 */       break;
/*      */     case 45:
/* 3214 */       strFieldValue = StrTool.GBKToUnicode(this.payEndYearFlag);
/* 3215 */       break;
/*      */     case 46:
/* 3217 */       strFieldValue = String.valueOf(this.payEndYear);
/* 3218 */       break;
/*      */     case 47:
/* 3220 */       strFieldValue = StrTool.GBKToUnicode(this.insuYearFlag);
/* 3221 */       break;
/*      */     case 48:
/* 3223 */       strFieldValue = String.valueOf(this.insuYear);
/* 3224 */       break;
/*      */     case 49:
/* 3226 */       strFieldValue = StrTool.GBKToUnicode(this.acciYearFlag);
/* 3227 */       break;
/*      */     case 50:
/* 3229 */       strFieldValue = String.valueOf(this.acciYear);
/* 3230 */       break;
/*      */     case 51:
/* 3232 */       strFieldValue = StrTool.GBKToUnicode(this.getStartType);
/* 3233 */       break;
/*      */     case 52:
/* 3235 */       strFieldValue = StrTool.GBKToUnicode(this.specifyValiDate);
/* 3236 */       break;
/*      */     case 53:
/* 3238 */       strFieldValue = StrTool.GBKToUnicode(this.payMode);
/* 3239 */       break;
/*      */     case 54:
/* 3241 */       strFieldValue = StrTool.GBKToUnicode(this.payLocation);
/* 3242 */       break;
/*      */     case 55:
/* 3244 */       strFieldValue = String.valueOf(this.payIntv);
/* 3245 */       break;
/*      */     case 56:
/* 3247 */       strFieldValue = String.valueOf(this.payYears);
/* 3248 */       break;
/*      */     case 57:
/* 3250 */       strFieldValue = String.valueOf(this.years);
/* 3251 */       break;
/*      */     case 58:
/* 3253 */       strFieldValue = String.valueOf(this.manageFeeRate);
/* 3254 */       break;
/*      */     case 59:
/* 3256 */       strFieldValue = String.valueOf(this.floatRate);
/* 3257 */       break;
/*      */     case 60:
/* 3259 */       strFieldValue = String.valueOf(this.premRate);
/* 3260 */       break;
/*      */     case 61:
/* 3262 */       strFieldValue = StrTool.GBKToUnicode(this.premToAmnt);
/* 3263 */       break;
/*      */     case 62:
/* 3265 */       strFieldValue = String.valueOf(this.mult);
/* 3266 */       break;
/*      */     case 63:
/* 3268 */       strFieldValue = String.valueOf(this.standPrem);
/* 3269 */       break;
/*      */     case 64:
/* 3271 */       strFieldValue = String.valueOf(this.prem);
/* 3272 */       break;
/*      */     case 65:
/* 3274 */       strFieldValue = String.valueOf(this.sumPrem);
/* 3275 */       break;
/*      */     case 66:
/* 3277 */       strFieldValue = String.valueOf(this.amnt);
/* 3278 */       break;
/*      */     case 67:
/* 3280 */       strFieldValue = String.valueOf(this.riskAmnt);
/* 3281 */       break;
/*      */     case 68:
/* 3283 */       strFieldValue = String.valueOf(this.leavingMoney);
/* 3284 */       break;
/*      */     case 69:
/* 3286 */       strFieldValue = String.valueOf(this.endorseTimes);
/* 3287 */       break;
/*      */     case 70:
/* 3289 */       strFieldValue = String.valueOf(this.claimTimes);
/* 3290 */       break;
/*      */     case 71:
/* 3292 */       strFieldValue = String.valueOf(this.liveTimes);
/* 3293 */       break;
/*      */     case 72:
/* 3295 */       strFieldValue = String.valueOf(this.renewCount);
/* 3296 */       break;
/*      */     case 73:
/* 3298 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLastGetDate()));
/* 3299 */       break;
/*      */     case 74:
/* 3301 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLastLoanDate()));
/* 3302 */       break;
/*      */     case 75:
/* 3304 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLastRegetDate()));
/* 3305 */       break;
/*      */     case 76:
/* 3307 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLastEdorDate()));
/* 3308 */       break;
/*      */     case 77:
/* 3310 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLastRevDate()));
/* 3311 */       break;
/*      */     case 78:
/* 3313 */       strFieldValue = StrTool.GBKToUnicode(this.rnewFlag);
/* 3314 */       break;
/*      */     case 79:
/* 3316 */       strFieldValue = StrTool.GBKToUnicode(this.stopFlag);
/* 3317 */       break;
/*      */     case 80:
/* 3319 */       strFieldValue = StrTool.GBKToUnicode(this.expiryFlag);
/* 3320 */       break;
/*      */     case 81:
/* 3322 */       strFieldValue = StrTool.GBKToUnicode(this.autoPayFlag);
/* 3323 */       break;
/*      */     case 82:
/* 3325 */       strFieldValue = StrTool.GBKToUnicode(this.interestDifFlag);
/* 3326 */       break;
/*      */     case 83:
/* 3328 */       strFieldValue = StrTool.GBKToUnicode(this.subFlag);
/* 3329 */       break;
/*      */     case 84:
/* 3331 */       strFieldValue = StrTool.GBKToUnicode(this.bnfFlag);
/* 3332 */       break;
/*      */     case 85:
/* 3334 */       strFieldValue = StrTool.GBKToUnicode(this.healthCheckFlag);
/* 3335 */       break;
/*      */     case 86:
/* 3337 */       strFieldValue = StrTool.GBKToUnicode(this.impartFlag);
/* 3338 */       break;
/*      */     case 87:
/* 3340 */       strFieldValue = StrTool.GBKToUnicode(this.reinsureFlag);
/* 3341 */       break;
/*      */     case 88:
/* 3343 */       strFieldValue = StrTool.GBKToUnicode(this.agentPayFlag);
/* 3344 */       break;
/*      */     case 89:
/* 3346 */       strFieldValue = StrTool.GBKToUnicode(this.agentGetFlag);
/* 3347 */       break;
/*      */     case 90:
/* 3349 */       strFieldValue = StrTool.GBKToUnicode(this.liveGetMode);
/* 3350 */       break;
/*      */     case 91:
/* 3352 */       strFieldValue = StrTool.GBKToUnicode(this.deadGetMode);
/* 3353 */       break;
/*      */     case 92:
/* 3355 */       strFieldValue = StrTool.GBKToUnicode(this.bonusGetMode);
/* 3356 */       break;
/*      */     case 93:
/* 3358 */       strFieldValue = StrTool.GBKToUnicode(this.deadAmntType);
/* 3359 */       break;
/*      */     case 94:
/* 3361 */       strFieldValue = String.valueOf(this.topUpPrem);
/* 3362 */       break;
/*      */     case 95:
/* 3364 */       strFieldValue = StrTool.GBKToUnicode(this.bonusMan);
/* 3365 */       break;
/*      */     case 96:
/* 3367 */       strFieldValue = StrTool.GBKToUnicode(this.deadFlag);
/* 3368 */       break;
/*      */     case 97:
/* 3370 */       strFieldValue = StrTool.GBKToUnicode(this.smokeFlag);
/* 3371 */       break;
/*      */     case 98:
/* 3373 */       strFieldValue = StrTool.GBKToUnicode(this.remark);
/* 3374 */       break;
/*      */     case 99:
/* 3376 */       strFieldValue = StrTool.GBKToUnicode(this.approveFlag);
/* 3377 */       break;
/*      */     case 100:
/* 3379 */       strFieldValue = StrTool.GBKToUnicode(this.approveCode);
/* 3380 */       break;
/*      */     case 101:
/* 3382 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getApproveDate()));
/* 3383 */       break;
/*      */     case 102:
/* 3385 */       strFieldValue = StrTool.GBKToUnicode(this.approveTime);
/* 3386 */       break;
/*      */     case 103:
/* 3388 */       strFieldValue = StrTool.GBKToUnicode(this.uWFlag);
/* 3389 */       break;
/*      */     case 104:
/* 3391 */       strFieldValue = StrTool.GBKToUnicode(this.uWCode);
/* 3392 */       break;
/*      */     case 105:
/* 3394 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
/* 3395 */       break;
/*      */     case 106:
/* 3397 */       strFieldValue = StrTool.GBKToUnicode(this.uWTime);
/* 3398 */       break;
/*      */     case 107:
/* 3400 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPolApplyDate()));
/* 3401 */       break;
/*      */     case 108:
/* 3403 */       strFieldValue = StrTool.GBKToUnicode(this.appFlag);
/* 3404 */       break;
/*      */     case 109:
/* 3406 */       strFieldValue = StrTool.GBKToUnicode(this.saleChnlDetail);
/* 3407 */       break;
/*      */     case 110:
/* 3409 */       strFieldValue = StrTool.GBKToUnicode(this.polState);
/* 3410 */       break;
/*      */     case 111:
/* 3412 */       strFieldValue = StrTool.GBKToUnicode(this.standbyFlag1);
/* 3413 */       break;
/*      */     case 112:
/* 3415 */       strFieldValue = StrTool.GBKToUnicode(this.standbyFlag2);
/* 3416 */       break;
/*      */     case 113:
/* 3418 */       strFieldValue = StrTool.GBKToUnicode(this.standbyFlag3);
/* 3419 */       break;
/*      */     case 114:
/* 3421 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 3422 */       break;
/*      */     case 115:
/* 3424 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 3425 */       break;
/*      */     case 116:
/* 3427 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 3428 */       break;
/*      */     case 117:
/* 3430 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 3431 */       break;
/*      */     case 118:
/* 3433 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 3434 */       break;
/*      */     default:
/* 3436 */       strFieldValue = "";
/*      */     }
/* 3438 */     if (strFieldValue.equals("")) {
/* 3439 */       strFieldValue = "null";
/*      */     }
/* 3441 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 3447 */     if (StrTool.cTrim(FCode).equals("")) {
/* 3448 */       return false;
/*      */     }
/* 3450 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 3452 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3454 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 3457 */         this.grpContNo = null;
/*      */     }
/* 3459 */     if (FCode.equalsIgnoreCase("grpPolNo"))
/*      */     {
/* 3461 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3463 */         this.grpPolNo = FValue.trim();
/*      */       }
/*      */       else
/* 3466 */         this.grpPolNo = null;
/*      */     }
/* 3468 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 3470 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3472 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 3475 */         this.contNo = null;
/*      */     }
/* 3477 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 3479 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3481 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 3484 */         this.proposalContNo = null;
/*      */     }
/* 3486 */     if (FCode.equalsIgnoreCase("polNo"))
/*      */     {
/* 3488 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3490 */         this.polNo = FValue.trim();
/*      */       }
/*      */       else
/* 3493 */         this.polNo = null;
/*      */     }
/* 3495 */     if (FCode.equalsIgnoreCase("proposalNo"))
/*      */     {
/* 3497 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3499 */         this.proposalNo = FValue.trim();
/*      */       }
/*      */       else
/* 3502 */         this.proposalNo = null;
/*      */     }
/* 3504 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/* 3506 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3508 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/* 3511 */         this.prtNo = null;
/*      */     }
/* 3513 */     if (FCode.equalsIgnoreCase("contType"))
/*      */     {
/* 3515 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3517 */         this.contType = FValue.trim();
/*      */       }
/*      */       else
/* 3520 */         this.contType = null;
/*      */     }
/* 3522 */     if (FCode.equalsIgnoreCase("polTypeFlag"))
/*      */     {
/* 3524 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3526 */         this.polTypeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3529 */         this.polTypeFlag = null;
/*      */     }
/* 3531 */     if (FCode.equalsIgnoreCase("mainPolNo"))
/*      */     {
/* 3533 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3535 */         this.mainPolNo = FValue.trim();
/*      */       }
/*      */       else
/* 3538 */         this.mainPolNo = null;
/*      */     }
/* 3540 */     if (FCode.equalsIgnoreCase("masterPolNo"))
/*      */     {
/* 3542 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3544 */         this.masterPolNo = FValue.trim();
/*      */       }
/*      */       else
/* 3547 */         this.masterPolNo = null;
/*      */     }
/* 3549 */     if (FCode.equalsIgnoreCase("kindCode"))
/*      */     {
/* 3551 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3553 */         this.kindCode = FValue.trim();
/*      */       }
/*      */       else
/* 3556 */         this.kindCode = null;
/*      */     }
/* 3558 */     if (FCode.equalsIgnoreCase("riskCode"))
/*      */     {
/* 3560 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3562 */         this.riskCode = FValue.trim();
/*      */       }
/*      */       else
/* 3565 */         this.riskCode = null;
/*      */     }
/* 3567 */     if (FCode.equalsIgnoreCase("riskVersion"))
/*      */     {
/* 3569 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3571 */         this.riskVersion = FValue.trim();
/*      */       }
/*      */       else
/* 3574 */         this.riskVersion = null;
/*      */     }
/* 3576 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 3578 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3580 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 3583 */         this.manageCom = null;
/*      */     }
/* 3585 */     if (FCode.equalsIgnoreCase("agentCom"))
/*      */     {
/* 3587 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3589 */         this.agentCom = FValue.trim();
/*      */       }
/*      */       else
/* 3592 */         this.agentCom = null;
/*      */     }
/* 3594 */     if (FCode.equalsIgnoreCase("agentType"))
/*      */     {
/* 3596 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3598 */         this.agentType = FValue.trim();
/*      */       }
/*      */       else
/* 3601 */         this.agentType = null;
/*      */     }
/* 3603 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 3605 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3607 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/* 3610 */         this.agentCode = null;
/*      */     }
/* 3612 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*      */     {
/* 3614 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3616 */         this.agentGroup = FValue.trim();
/*      */       }
/*      */       else
/* 3619 */         this.agentGroup = null;
/*      */     }
/* 3621 */     if (FCode.equalsIgnoreCase("agentGroup1"))
/*      */     {
/* 3623 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3625 */         this.agentGroup1 = FValue.trim();
/*      */       }
/*      */       else
/* 3628 */         this.agentGroup1 = null;
/*      */     }
/* 3630 */     if (FCode.equalsIgnoreCase("agentCode1"))
/*      */     {
/* 3632 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3634 */         this.agentCode1 = FValue.trim();
/*      */       }
/*      */       else
/* 3637 */         this.agentCode1 = null;
/*      */     }
/* 3639 */     if (FCode.equalsIgnoreCase("saleChnl"))
/*      */     {
/* 3641 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3643 */         this.saleChnl = FValue.trim();
/*      */       }
/*      */       else
/* 3646 */         this.saleChnl = null;
/*      */     }
/* 3648 */     if (FCode.equalsIgnoreCase("handler"))
/*      */     {
/* 3650 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3652 */         this.handler = FValue.trim();
/*      */       }
/*      */       else
/* 3655 */         this.handler = null;
/*      */     }
/* 3657 */     if (FCode.equalsIgnoreCase("insuredNo"))
/*      */     {
/* 3659 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3661 */         this.insuredNo = FValue.trim();
/*      */       }
/*      */       else
/* 3664 */         this.insuredNo = null;
/*      */     }
/* 3666 */     if (FCode.equalsIgnoreCase("insuredId"))
/*      */     {
/* 3668 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3670 */         this.insuredId = FValue.trim();
/*      */       }
/*      */       else
/* 3673 */         this.insuredId = null;
/*      */     }
/* 3675 */     if (FCode.equalsIgnoreCase("insuredName"))
/*      */     {
/* 3677 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3679 */         this.insuredName = FValue.trim();
/*      */       }
/*      */       else
/* 3682 */         this.insuredName = null;
/*      */     }
/* 3684 */     if (FCode.equalsIgnoreCase("insuredSex"))
/*      */     {
/* 3686 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3688 */         this.insuredSex = FValue.trim();
/*      */       }
/*      */       else
/* 3691 */         this.insuredSex = null;
/*      */     }
/* 3693 */     if (FCode.equalsIgnoreCase("insuredBirthday"))
/*      */     {
/* 3695 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3697 */         this.insuredBirthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3700 */         this.insuredBirthday = null;
/*      */     }
/* 3702 */     if (FCode.equalsIgnoreCase("insuredAppAge"))
/*      */     {
/* 3704 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3706 */         Integer tInteger = new Integer(FValue);
/* 3707 */         int i = tInteger.intValue();
/* 3708 */         this.insuredAppAge = i;
/*      */       }
/*      */     }
/* 3711 */     if (FCode.equalsIgnoreCase("insuredPeoples"))
/*      */     {
/* 3713 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3715 */         Integer tInteger = new Integer(FValue);
/* 3716 */         int i = tInteger.intValue();
/* 3717 */         this.insuredPeoples = i;
/*      */       }
/*      */     }
/* 3720 */     if (FCode.equalsIgnoreCase("occupationType"))
/*      */     {
/* 3722 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3724 */         this.occupationType = FValue.trim();
/*      */       }
/*      */       else
/* 3727 */         this.occupationType = null;
/*      */     }
/* 3729 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/* 3731 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3733 */         this.appntNo = FValue.trim();
/*      */       }
/*      */       else
/* 3736 */         this.appntNo = null;
/*      */     }
/* 3738 */     if (FCode.equalsIgnoreCase("appntName"))
/*      */     {
/* 3740 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3742 */         this.appntName = FValue.trim();
/*      */       }
/*      */       else
/* 3745 */         this.appntName = null;
/*      */     }
/* 3747 */     if (FCode.equalsIgnoreCase("cValiDate"))
/*      */     {
/* 3749 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3751 */         this.cValiDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3754 */         this.cValiDate = null;
/*      */     }
/* 3756 */     if (FCode.equalsIgnoreCase("signCom"))
/*      */     {
/* 3758 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3760 */         this.signCom = FValue.trim();
/*      */       }
/*      */       else
/* 3763 */         this.signCom = null;
/*      */     }
/* 3765 */     if (FCode.equalsIgnoreCase("signDate"))
/*      */     {
/* 3767 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3769 */         this.signDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3772 */         this.signDate = null;
/*      */     }
/* 3774 */     if (FCode.equalsIgnoreCase("signTime"))
/*      */     {
/* 3776 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3778 */         this.signTime = FValue.trim();
/*      */       }
/*      */       else
/* 3781 */         this.signTime = null;
/*      */     }
/* 3783 */     if (FCode.equalsIgnoreCase("firstPayDate"))
/*      */     {
/* 3785 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3787 */         this.firstPayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3790 */         this.firstPayDate = null;
/*      */     }
/* 3792 */     if (FCode.equalsIgnoreCase("payEndDate"))
/*      */     {
/* 3794 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3796 */         this.payEndDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3799 */         this.payEndDate = null;
/*      */     }
/* 3801 */     if (FCode.equalsIgnoreCase("paytoDate"))
/*      */     {
/* 3803 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3805 */         this.paytoDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3808 */         this.paytoDate = null;
/*      */     }
/* 3810 */     if (FCode.equalsIgnoreCase("getStartDate"))
/*      */     {
/* 3812 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3814 */         this.getStartDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3817 */         this.getStartDate = null;
/*      */     }
/* 3819 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 3821 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3823 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3826 */         this.endDate = null;
/*      */     }
/* 3828 */     if (FCode.equalsIgnoreCase("acciEndDate"))
/*      */     {
/* 3830 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3832 */         this.acciEndDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3835 */         this.acciEndDate = null;
/*      */     }
/* 3837 */     if (FCode.equalsIgnoreCase("getYearFlag"))
/*      */     {
/* 3839 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3841 */         this.getYearFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3844 */         this.getYearFlag = null;
/*      */     }
/* 3846 */     if (FCode.equalsIgnoreCase("getYear"))
/*      */     {
/* 3848 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3850 */         Integer tInteger = new Integer(FValue);
/* 3851 */         int i = tInteger.intValue();
/* 3852 */         this.getYear = i;
/*      */       }
/*      */     }
/* 3855 */     if (FCode.equalsIgnoreCase("payEndYearFlag"))
/*      */     {
/* 3857 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3859 */         this.payEndYearFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3862 */         this.payEndYearFlag = null;
/*      */     }
/* 3864 */     if (FCode.equalsIgnoreCase("payEndYear"))
/*      */     {
/* 3866 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3868 */         Integer tInteger = new Integer(FValue);
/* 3869 */         int i = tInteger.intValue();
/* 3870 */         this.payEndYear = i;
/*      */       }
/*      */     }
/* 3873 */     if (FCode.equalsIgnoreCase("insuYearFlag"))
/*      */     {
/* 3875 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3877 */         this.insuYearFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3880 */         this.insuYearFlag = null;
/*      */     }
/* 3882 */     if (FCode.equalsIgnoreCase("insuYear"))
/*      */     {
/* 3884 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3886 */         Integer tInteger = new Integer(FValue);
/* 3887 */         int i = tInteger.intValue();
/* 3888 */         this.insuYear = i;
/*      */       }
/*      */     }
/* 3891 */     if (FCode.equalsIgnoreCase("acciYearFlag"))
/*      */     {
/* 3893 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3895 */         this.acciYearFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3898 */         this.acciYearFlag = null;
/*      */     }
/* 3900 */     if (FCode.equalsIgnoreCase("acciYear"))
/*      */     {
/* 3902 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3904 */         Integer tInteger = new Integer(FValue);
/* 3905 */         int i = tInteger.intValue();
/* 3906 */         this.acciYear = i;
/*      */       }
/*      */     }
/* 3909 */     if (FCode.equalsIgnoreCase("getStartType"))
/*      */     {
/* 3911 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3913 */         this.getStartType = FValue.trim();
/*      */       }
/*      */       else
/* 3916 */         this.getStartType = null;
/*      */     }
/* 3918 */     if (FCode.equalsIgnoreCase("specifyValiDate"))
/*      */     {
/* 3920 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3922 */         this.specifyValiDate = FValue.trim();
/*      */       }
/*      */       else
/* 3925 */         this.specifyValiDate = null;
/*      */     }
/* 3927 */     if (FCode.equalsIgnoreCase("payMode"))
/*      */     {
/* 3929 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3931 */         this.payMode = FValue.trim();
/*      */       }
/*      */       else
/* 3934 */         this.payMode = null;
/*      */     }
/* 3936 */     if (FCode.equalsIgnoreCase("payLocation"))
/*      */     {
/* 3938 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3940 */         this.payLocation = FValue.trim();
/*      */       }
/*      */       else
/* 3943 */         this.payLocation = null;
/*      */     }
/* 3945 */     if (FCode.equalsIgnoreCase("payIntv"))
/*      */     {
/* 3947 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3949 */         Integer tInteger = new Integer(FValue);
/* 3950 */         int i = tInteger.intValue();
/* 3951 */         this.payIntv = i;
/*      */       }
/*      */     }
/* 3954 */     if (FCode.equalsIgnoreCase("payYears"))
/*      */     {
/* 3956 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3958 */         Integer tInteger = new Integer(FValue);
/* 3959 */         int i = tInteger.intValue();
/* 3960 */         this.payYears = i;
/*      */       }
/*      */     }
/* 3963 */     if (FCode.equalsIgnoreCase("years"))
/*      */     {
/* 3965 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3967 */         Integer tInteger = new Integer(FValue);
/* 3968 */         int i = tInteger.intValue();
/* 3969 */         this.years = i;
/*      */       }
/*      */     }
/* 3972 */     if (FCode.equalsIgnoreCase("manageFeeRate"))
/*      */     {
/* 3974 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3976 */         Double tDouble = new Double(FValue);
/* 3977 */         double d = tDouble.doubleValue();
/* 3978 */         this.manageFeeRate = d;
/*      */       }
/*      */     }
/* 3981 */     if (FCode.equalsIgnoreCase("floatRate"))
/*      */     {
/* 3983 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3985 */         Double tDouble = new Double(FValue);
/* 3986 */         double d = tDouble.doubleValue();
/* 3987 */         this.floatRate = d;
/*      */       }
/*      */     }
/* 3990 */     if (FCode.equalsIgnoreCase("premRate"))
/*      */     {
/* 3992 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3994 */         Double tDouble = new Double(FValue);
/* 3995 */         double d = tDouble.doubleValue();
/* 3996 */         this.premRate = d;
/*      */       }
/*      */     }
/* 3999 */     if (FCode.equalsIgnoreCase("premToAmnt"))
/*      */     {
/* 4001 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4003 */         this.premToAmnt = FValue.trim();
/*      */       }
/*      */       else
/* 4006 */         this.premToAmnt = null;
/*      */     }
/* 4008 */     if (FCode.equalsIgnoreCase("mult"))
/*      */     {
/* 4010 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4012 */         Double tDouble = new Double(FValue);
/* 4013 */         double d = tDouble.doubleValue();
/* 4014 */         this.mult = d;
/*      */       }
/*      */     }
/* 4017 */     if (FCode.equalsIgnoreCase("standPrem"))
/*      */     {
/* 4019 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4021 */         Double tDouble = new Double(FValue);
/* 4022 */         double d = tDouble.doubleValue();
/* 4023 */         this.standPrem = d;
/*      */       }
/*      */     }
/* 4026 */     if (FCode.equalsIgnoreCase("prem"))
/*      */     {
/* 4028 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4030 */         Double tDouble = new Double(FValue);
/* 4031 */         double d = tDouble.doubleValue();
/* 4032 */         this.prem = d;
/*      */       }
/*      */     }
/* 4035 */     if (FCode.equalsIgnoreCase("sumPrem"))
/*      */     {
/* 4037 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4039 */         Double tDouble = new Double(FValue);
/* 4040 */         double d = tDouble.doubleValue();
/* 4041 */         this.sumPrem = d;
/*      */       }
/*      */     }
/* 4044 */     if (FCode.equalsIgnoreCase("amnt"))
/*      */     {
/* 4046 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4048 */         Double tDouble = new Double(FValue);
/* 4049 */         double d = tDouble.doubleValue();
/* 4050 */         this.amnt = d;
/*      */       }
/*      */     }
/* 4053 */     if (FCode.equalsIgnoreCase("riskAmnt"))
/*      */     {
/* 4055 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4057 */         Double tDouble = new Double(FValue);
/* 4058 */         double d = tDouble.doubleValue();
/* 4059 */         this.riskAmnt = d;
/*      */       }
/*      */     }
/* 4062 */     if (FCode.equalsIgnoreCase("leavingMoney"))
/*      */     {
/* 4064 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4066 */         Double tDouble = new Double(FValue);
/* 4067 */         double d = tDouble.doubleValue();
/* 4068 */         this.leavingMoney = d;
/*      */       }
/*      */     }
/* 4071 */     if (FCode.equalsIgnoreCase("endorseTimes"))
/*      */     {
/* 4073 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4075 */         Integer tInteger = new Integer(FValue);
/* 4076 */         int i = tInteger.intValue();
/* 4077 */         this.endorseTimes = i;
/*      */       }
/*      */     }
/* 4080 */     if (FCode.equalsIgnoreCase("claimTimes"))
/*      */     {
/* 4082 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4084 */         Integer tInteger = new Integer(FValue);
/* 4085 */         int i = tInteger.intValue();
/* 4086 */         this.claimTimes = i;
/*      */       }
/*      */     }
/* 4089 */     if (FCode.equalsIgnoreCase("liveTimes"))
/*      */     {
/* 4091 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4093 */         Integer tInteger = new Integer(FValue);
/* 4094 */         int i = tInteger.intValue();
/* 4095 */         this.liveTimes = i;
/*      */       }
/*      */     }
/* 4098 */     if (FCode.equalsIgnoreCase("renewCount"))
/*      */     {
/* 4100 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4102 */         Integer tInteger = new Integer(FValue);
/* 4103 */         int i = tInteger.intValue();
/* 4104 */         this.renewCount = i;
/*      */       }
/*      */     }
/* 4107 */     if (FCode.equalsIgnoreCase("lastGetDate"))
/*      */     {
/* 4109 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4111 */         this.lastGetDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4114 */         this.lastGetDate = null;
/*      */     }
/* 4116 */     if (FCode.equalsIgnoreCase("lastLoanDate"))
/*      */     {
/* 4118 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4120 */         this.lastLoanDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4123 */         this.lastLoanDate = null;
/*      */     }
/* 4125 */     if (FCode.equalsIgnoreCase("lastRegetDate"))
/*      */     {
/* 4127 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4129 */         this.lastRegetDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4132 */         this.lastRegetDate = null;
/*      */     }
/* 4134 */     if (FCode.equalsIgnoreCase("lastEdorDate"))
/*      */     {
/* 4136 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4138 */         this.lastEdorDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4141 */         this.lastEdorDate = null;
/*      */     }
/* 4143 */     if (FCode.equalsIgnoreCase("lastRevDate"))
/*      */     {
/* 4145 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4147 */         this.lastRevDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4150 */         this.lastRevDate = null;
/*      */     }
/* 4152 */     if (FCode.equalsIgnoreCase("rnewFlag"))
/*      */     {
/* 4154 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4156 */         this.rnewFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4159 */         this.rnewFlag = null;
/*      */     }
/* 4161 */     if (FCode.equalsIgnoreCase("stopFlag"))
/*      */     {
/* 4163 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4165 */         this.stopFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4168 */         this.stopFlag = null;
/*      */     }
/* 4170 */     if (FCode.equalsIgnoreCase("expiryFlag"))
/*      */     {
/* 4172 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4174 */         this.expiryFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4177 */         this.expiryFlag = null;
/*      */     }
/* 4179 */     if (FCode.equalsIgnoreCase("autoPayFlag"))
/*      */     {
/* 4181 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4183 */         this.autoPayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4186 */         this.autoPayFlag = null;
/*      */     }
/* 4188 */     if (FCode.equalsIgnoreCase("interestDifFlag"))
/*      */     {
/* 4190 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4192 */         this.interestDifFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4195 */         this.interestDifFlag = null;
/*      */     }
/* 4197 */     if (FCode.equalsIgnoreCase("subFlag"))
/*      */     {
/* 4199 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4201 */         this.subFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4204 */         this.subFlag = null;
/*      */     }
/* 4206 */     if (FCode.equalsIgnoreCase("bnfFlag"))
/*      */     {
/* 4208 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4210 */         this.bnfFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4213 */         this.bnfFlag = null;
/*      */     }
/* 4215 */     if (FCode.equalsIgnoreCase("healthCheckFlag"))
/*      */     {
/* 4217 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4219 */         this.healthCheckFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4222 */         this.healthCheckFlag = null;
/*      */     }
/* 4224 */     if (FCode.equalsIgnoreCase("impartFlag"))
/*      */     {
/* 4226 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4228 */         this.impartFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4231 */         this.impartFlag = null;
/*      */     }
/* 4233 */     if (FCode.equalsIgnoreCase("reinsureFlag"))
/*      */     {
/* 4235 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4237 */         this.reinsureFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4240 */         this.reinsureFlag = null;
/*      */     }
/* 4242 */     if (FCode.equalsIgnoreCase("agentPayFlag"))
/*      */     {
/* 4244 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4246 */         this.agentPayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4249 */         this.agentPayFlag = null;
/*      */     }
/* 4251 */     if (FCode.equalsIgnoreCase("agentGetFlag"))
/*      */     {
/* 4253 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4255 */         this.agentGetFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4258 */         this.agentGetFlag = null;
/*      */     }
/* 4260 */     if (FCode.equalsIgnoreCase("liveGetMode"))
/*      */     {
/* 4262 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4264 */         this.liveGetMode = FValue.trim();
/*      */       }
/*      */       else
/* 4267 */         this.liveGetMode = null;
/*      */     }
/* 4269 */     if (FCode.equalsIgnoreCase("deadGetMode"))
/*      */     {
/* 4271 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4273 */         this.deadGetMode = FValue.trim();
/*      */       }
/*      */       else
/* 4276 */         this.deadGetMode = null;
/*      */     }
/* 4278 */     if (FCode.equalsIgnoreCase("bonusGetMode"))
/*      */     {
/* 4280 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4282 */         this.bonusGetMode = FValue.trim();
/*      */       }
/*      */       else
/* 4285 */         this.bonusGetMode = null;
/*      */     }
/* 4287 */     if (FCode.equalsIgnoreCase("deadAmntType"))
/*      */     {
/* 4289 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4291 */         this.deadAmntType = FValue.trim();
/*      */       }
/*      */       else
/* 4294 */         this.deadAmntType = null;
/*      */     }
/* 4296 */     if (FCode.equalsIgnoreCase("topUpPrem"))
/*      */     {
/* 4298 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4300 */         Double tDouble = new Double(FValue);
/* 4301 */         double d = tDouble.doubleValue();
/* 4302 */         this.topUpPrem = d;
/*      */       }
/*      */     }
/* 4305 */     if (FCode.equalsIgnoreCase("bonusMan"))
/*      */     {
/* 4307 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4309 */         this.bonusMan = FValue.trim();
/*      */       }
/*      */       else
/* 4312 */         this.bonusMan = null;
/*      */     }
/* 4314 */     if (FCode.equalsIgnoreCase("deadFlag"))
/*      */     {
/* 4316 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4318 */         this.deadFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4321 */         this.deadFlag = null;
/*      */     }
/* 4323 */     if (FCode.equalsIgnoreCase("smokeFlag"))
/*      */     {
/* 4325 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4327 */         this.smokeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4330 */         this.smokeFlag = null;
/*      */     }
/* 4332 */     if (FCode.equalsIgnoreCase("remark"))
/*      */     {
/* 4334 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4336 */         this.remark = FValue.trim();
/*      */       }
/*      */       else
/* 4339 */         this.remark = null;
/*      */     }
/* 4341 */     if (FCode.equalsIgnoreCase("approveFlag"))
/*      */     {
/* 4343 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4345 */         this.approveFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4348 */         this.approveFlag = null;
/*      */     }
/* 4350 */     if (FCode.equalsIgnoreCase("approveCode"))
/*      */     {
/* 4352 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4354 */         this.approveCode = FValue.trim();
/*      */       }
/*      */       else
/* 4357 */         this.approveCode = null;
/*      */     }
/* 4359 */     if (FCode.equalsIgnoreCase("approveDate"))
/*      */     {
/* 4361 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4363 */         this.approveDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4366 */         this.approveDate = null;
/*      */     }
/* 4368 */     if (FCode.equalsIgnoreCase("approveTime"))
/*      */     {
/* 4370 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4372 */         this.approveTime = FValue.trim();
/*      */       }
/*      */       else
/* 4375 */         this.approveTime = null;
/*      */     }
/* 4377 */     if (FCode.equalsIgnoreCase("uWFlag"))
/*      */     {
/* 4379 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4381 */         this.uWFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4384 */         this.uWFlag = null;
/*      */     }
/* 4386 */     if (FCode.equalsIgnoreCase("uWCode"))
/*      */     {
/* 4388 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4390 */         this.uWCode = FValue.trim();
/*      */       }
/*      */       else
/* 4393 */         this.uWCode = null;
/*      */     }
/* 4395 */     if (FCode.equalsIgnoreCase("uWDate"))
/*      */     {
/* 4397 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4399 */         this.uWDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4402 */         this.uWDate = null;
/*      */     }
/* 4404 */     if (FCode.equalsIgnoreCase("uWTime"))
/*      */     {
/* 4406 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4408 */         this.uWTime = FValue.trim();
/*      */       }
/*      */       else
/* 4411 */         this.uWTime = null;
/*      */     }
/* 4413 */     if (FCode.equalsIgnoreCase("polApplyDate"))
/*      */     {
/* 4415 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4417 */         this.polApplyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4420 */         this.polApplyDate = null;
/*      */     }
/* 4422 */     if (FCode.equalsIgnoreCase("appFlag"))
/*      */     {
/* 4424 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4426 */         this.appFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4429 */         this.appFlag = null;
/*      */     }
/* 4431 */     if (FCode.equalsIgnoreCase("saleChnlDetail"))
/*      */     {
/* 4433 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4435 */         this.saleChnlDetail = FValue.trim();
/*      */       }
/*      */       else
/* 4438 */         this.saleChnlDetail = null;
/*      */     }
/* 4440 */     if (FCode.equalsIgnoreCase("polState"))
/*      */     {
/* 4442 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4444 */         this.polState = FValue.trim();
/*      */       }
/*      */       else
/* 4447 */         this.polState = null;
/*      */     }
/* 4449 */     if (FCode.equalsIgnoreCase("standbyFlag1"))
/*      */     {
/* 4451 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4453 */         this.standbyFlag1 = FValue.trim();
/*      */       }
/*      */       else
/* 4456 */         this.standbyFlag1 = null;
/*      */     }
/* 4458 */     if (FCode.equalsIgnoreCase("standbyFlag2"))
/*      */     {
/* 4460 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4462 */         this.standbyFlag2 = FValue.trim();
/*      */       }
/*      */       else
/* 4465 */         this.standbyFlag2 = null;
/*      */     }
/* 4467 */     if (FCode.equalsIgnoreCase("standbyFlag3"))
/*      */     {
/* 4469 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4471 */         this.standbyFlag3 = FValue.trim();
/*      */       }
/*      */       else
/* 4474 */         this.standbyFlag3 = null;
/*      */     }
/* 4476 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 4478 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4480 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 4483 */         this.operator = null;
/*      */     }
/* 4485 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 4487 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4489 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4492 */         this.makeDate = null;
/*      */     }
/* 4494 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 4496 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4498 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 4501 */         this.makeTime = null;
/*      */     }
/* 4503 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 4505 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4507 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4510 */         this.modifyDate = null;
/*      */     }
/* 4512 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 4514 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4516 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 4519 */         this.modifyTime = null;
/*      */     }
/* 4521 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 4526 */     if (otherObject == null) return false;
/* 4527 */     if (this == otherObject) return true;
/* 4528 */     if (getClass() != otherObject.getClass()) return false;
/* 4529 */     LNPPolSchema other = (LNPPolSchema)otherObject;
/* 4530 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/* 4531 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/* 4532 */     if ((this.grpPolNo == null) && (other.getGrpPolNo() != null)) return false;
/* 4533 */     if ((this.grpPolNo != null) && (!this.grpPolNo.equals(other.getGrpPolNo()))) return false;
/* 4534 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/* 4535 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/* 4536 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/* 4537 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/* 4538 */     if ((this.polNo == null) && (other.getPolNo() != null)) return false;
/* 4539 */     if ((this.polNo != null) && (!this.polNo.equals(other.getPolNo()))) return false;
/* 4540 */     if ((this.proposalNo == null) && (other.getProposalNo() != null)) return false;
/* 4541 */     if ((this.proposalNo != null) && (!this.proposalNo.equals(other.getProposalNo()))) return false;
/* 4542 */     if ((this.prtNo == null) && (other.getPrtNo() != null)) return false;
/* 4543 */     if ((this.prtNo != null) && (!this.prtNo.equals(other.getPrtNo()))) return false;
/* 4544 */     if ((this.contType == null) && (other.getContType() != null)) return false;
/* 4545 */     if ((this.contType != null) && (!this.contType.equals(other.getContType()))) return false;
/* 4546 */     if ((this.polTypeFlag == null) && (other.getPolTypeFlag() != null)) return false;
/* 4547 */     if ((this.polTypeFlag != null) && (!this.polTypeFlag.equals(other.getPolTypeFlag()))) return false;
/* 4548 */     if ((this.mainPolNo == null) && (other.getMainPolNo() != null)) return false;
/* 4549 */     if ((this.mainPolNo != null) && (!this.mainPolNo.equals(other.getMainPolNo()))) return false;
/* 4550 */     if ((this.masterPolNo == null) && (other.getMasterPolNo() != null)) return false;
/* 4551 */     if ((this.masterPolNo != null) && (!this.masterPolNo.equals(other.getMasterPolNo()))) return false;
/* 4552 */     if ((this.kindCode == null) && (other.getKindCode() != null)) return false;
/* 4553 */     if ((this.kindCode != null) && (!this.kindCode.equals(other.getKindCode()))) return false;
/* 4554 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 4555 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/* 4556 */     if ((this.riskVersion == null) && (other.getRiskVersion() != null)) return false;
/* 4557 */     if ((this.riskVersion != null) && (!this.riskVersion.equals(other.getRiskVersion()))) return false;
/* 4558 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 4559 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 4560 */     if ((this.agentCom == null) && (other.getAgentCom() != null)) return false;
/* 4561 */     if ((this.agentCom != null) && (!this.agentCom.equals(other.getAgentCom()))) return false;
/* 4562 */     if ((this.agentType == null) && (other.getAgentType() != null)) return false;
/* 4563 */     if ((this.agentType != null) && (!this.agentType.equals(other.getAgentType()))) return false;
/* 4564 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/* 4565 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/* 4566 */     if ((this.agentGroup == null) && (other.getAgentGroup() != null)) return false;
/* 4567 */     if ((this.agentGroup != null) && (!this.agentGroup.equals(other.getAgentGroup()))) return false;
/* 4568 */     if ((this.agentGroup1 == null) && (other.getAgentGroup1() != null)) return false;
/* 4569 */     if ((this.agentGroup1 != null) && (!this.agentGroup1.equals(other.getAgentGroup1()))) return false;
/* 4570 */     if ((this.agentCode1 == null) && (other.getAgentCode1() != null)) return false;
/* 4571 */     if ((this.agentCode1 != null) && (!this.agentCode1.equals(other.getAgentCode1()))) return false;
/* 4572 */     if ((this.saleChnl == null) && (other.getSaleChnl() != null)) return false;
/* 4573 */     if ((this.saleChnl != null) && (!this.saleChnl.equals(other.getSaleChnl()))) return false;
/* 4574 */     if ((this.handler == null) && (other.getHandler() != null)) return false;
/* 4575 */     if ((this.handler != null) && (!this.handler.equals(other.getHandler()))) return false;
/* 4576 */     if ((this.insuredNo == null) && (other.getInsuredNo() != null)) return false;
/* 4577 */     if ((this.insuredNo != null) && (!this.insuredNo.equals(other.getInsuredNo()))) return false;
/* 4578 */     if ((this.insuredId == null) && (other.getInsuredId() != null)) return false;
/* 4579 */     if ((this.insuredId != null) && (!this.insuredId.equals(other.getInsuredId()))) return false;
/* 4580 */     if ((this.insuredName == null) && (other.getInsuredName() != null)) return false;
/* 4581 */     if ((this.insuredName != null) && (!this.insuredName.equals(other.getInsuredName()))) return false;
/* 4582 */     if ((this.insuredSex == null) && (other.getInsuredSex() != null)) return false;
/* 4583 */     if ((this.insuredSex != null) && (!this.insuredSex.equals(other.getInsuredSex()))) return false;
/* 4584 */     if ((this.insuredBirthday == null) && (other.getInsuredBirthday() != null)) return false;
/* 4585 */     if ((this.insuredBirthday != null) && (!this.fDate.getString(this.insuredBirthday).equals(other.getInsuredBirthday()))) return false;
/* 4586 */     if (this.insuredAppAge != other.getInsuredAppAge()) return false;
/* 4587 */     if (this.insuredPeoples != other.getInsuredPeoples()) return false;
/* 4588 */     if ((this.occupationType == null) && (other.getOccupationType() != null)) return false;
/* 4589 */     if ((this.occupationType != null) && (!this.occupationType.equals(other.getOccupationType()))) return false;
/* 4590 */     if ((this.appntNo == null) && (other.getAppntNo() != null)) return false;
/* 4591 */     if ((this.appntNo != null) && (!this.appntNo.equals(other.getAppntNo()))) return false;
/* 4592 */     if ((this.appntName == null) && (other.getAppntName() != null)) return false;
/* 4593 */     if ((this.appntName != null) && (!this.appntName.equals(other.getAppntName()))) return false;
/* 4594 */     if ((this.cValiDate == null) && (other.getCValiDate() != null)) return false;
/* 4595 */     if ((this.cValiDate != null) && (!this.fDate.getString(this.cValiDate).equals(other.getCValiDate()))) return false;
/* 4596 */     if ((this.signCom == null) && (other.getSignCom() != null)) return false;
/* 4597 */     if ((this.signCom != null) && (!this.signCom.equals(other.getSignCom()))) return false;
/* 4598 */     if ((this.signDate == null) && (other.getSignDate() != null)) return false;
/* 4599 */     if ((this.signDate != null) && (!this.fDate.getString(this.signDate).equals(other.getSignDate()))) return false;
/* 4600 */     if ((this.signTime == null) && (other.getSignTime() != null)) return false;
/* 4601 */     if ((this.signTime != null) && (!this.signTime.equals(other.getSignTime()))) return false;
/* 4602 */     if ((this.firstPayDate == null) && (other.getFirstPayDate() != null)) return false;
/* 4603 */     if ((this.firstPayDate != null) && (!this.fDate.getString(this.firstPayDate).equals(other.getFirstPayDate()))) return false;
/* 4604 */     if ((this.payEndDate == null) && (other.getPayEndDate() != null)) return false;
/* 4605 */     if ((this.payEndDate != null) && (!this.fDate.getString(this.payEndDate).equals(other.getPayEndDate()))) return false;
/* 4606 */     if ((this.paytoDate == null) && (other.getPaytoDate() != null)) return false;
/* 4607 */     if ((this.paytoDate != null) && (!this.fDate.getString(this.paytoDate).equals(other.getPaytoDate()))) return false;
/* 4608 */     if ((this.getStartDate == null) && (other.getGetStartDate() != null)) return false;
/* 4609 */     if ((this.getStartDate != null) && (!this.fDate.getString(this.getStartDate).equals(other.getGetStartDate()))) return false;
/* 4610 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 4611 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 4612 */     if ((this.acciEndDate == null) && (other.getAcciEndDate() != null)) return false;
/* 4613 */     if ((this.acciEndDate != null) && (!this.fDate.getString(this.acciEndDate).equals(other.getAcciEndDate()))) return false;
/* 4614 */     if ((this.getYearFlag == null) && (other.getGetYearFlag() != null)) return false;
/* 4615 */     if ((this.getYearFlag != null) && (!this.getYearFlag.equals(other.getGetYearFlag()))) return false;
/* 4616 */     if (this.getYear != other.getGetYear()) return false;
/* 4617 */     if ((this.payEndYearFlag == null) && (other.getPayEndYearFlag() != null)) return false;
/* 4618 */     if ((this.payEndYearFlag != null) && (!this.payEndYearFlag.equals(other.getPayEndYearFlag()))) return false;
/* 4619 */     if (this.payEndYear != other.getPayEndYear()) return false;
/* 4620 */     if ((this.insuYearFlag == null) && (other.getInsuYearFlag() != null)) return false;
/* 4621 */     if ((this.insuYearFlag != null) && (!this.insuYearFlag.equals(other.getInsuYearFlag()))) return false;
/* 4622 */     if (this.insuYear != other.getInsuYear()) return false;
/* 4623 */     if ((this.acciYearFlag == null) && (other.getAcciYearFlag() != null)) return false;
/* 4624 */     if ((this.acciYearFlag != null) && (!this.acciYearFlag.equals(other.getAcciYearFlag()))) return false;
/* 4625 */     if (this.acciYear != other.getAcciYear()) return false;
/* 4626 */     if ((this.getStartType == null) && (other.getGetStartType() != null)) return false;
/* 4627 */     if ((this.getStartType != null) && (!this.getStartType.equals(other.getGetStartType()))) return false;
/* 4628 */     if ((this.specifyValiDate == null) && (other.getSpecifyValiDate() != null)) return false;
/* 4629 */     if ((this.specifyValiDate != null) && (!this.specifyValiDate.equals(other.getSpecifyValiDate()))) return false;
/* 4630 */     if ((this.payMode == null) && (other.getPayMode() != null)) return false;
/* 4631 */     if ((this.payMode != null) && (!this.payMode.equals(other.getPayMode()))) return false;
/* 4632 */     if ((this.payLocation == null) && (other.getPayLocation() != null)) return false;
/* 4633 */     if ((this.payLocation != null) && (!this.payLocation.equals(other.getPayLocation()))) return false;
/* 4634 */     if (this.payIntv != other.getPayIntv()) return false;
/* 4635 */     if (this.payYears != other.getPayYears()) return false;
/* 4636 */     if (this.years != other.getYears()) return false;
/* 4637 */     if (Double.doubleToLongBits(this.manageFeeRate) != Double.doubleToLongBits(other.getManageFeeRate())) return false;
/* 4638 */     if (Double.doubleToLongBits(this.floatRate) != Double.doubleToLongBits(other.getFloatRate())) return false;
/* 4639 */     if (Double.doubleToLongBits(this.premRate) != Double.doubleToLongBits(other.getPremRate())) return false;
/* 4640 */     if ((this.premToAmnt == null) && (other.getPremToAmnt() != null)) return false;
/* 4641 */     if ((this.premToAmnt != null) && (!this.premToAmnt.equals(other.getPremToAmnt()))) return false;
/* 4642 */     if (Double.doubleToLongBits(this.mult) != Double.doubleToLongBits(other.getMult())) return false;
/* 4643 */     if (Double.doubleToLongBits(this.standPrem) != Double.doubleToLongBits(other.getStandPrem())) return false;
/* 4644 */     if (Double.doubleToLongBits(this.prem) != Double.doubleToLongBits(other.getPrem())) return false;
/* 4645 */     if (Double.doubleToLongBits(this.sumPrem) != Double.doubleToLongBits(other.getSumPrem())) return false;
/* 4646 */     if (Double.doubleToLongBits(this.amnt) != Double.doubleToLongBits(other.getAmnt())) return false;
/* 4647 */     if (Double.doubleToLongBits(this.riskAmnt) != Double.doubleToLongBits(other.getRiskAmnt())) return false;
/* 4648 */     if (Double.doubleToLongBits(this.leavingMoney) != Double.doubleToLongBits(other.getLeavingMoney())) return false;
/* 4649 */     if (this.endorseTimes != other.getEndorseTimes()) return false;
/* 4650 */     if (this.claimTimes != other.getClaimTimes()) return false;
/* 4651 */     if (this.liveTimes != other.getLiveTimes()) return false;
/* 4652 */     if (this.renewCount != other.getRenewCount()) return false;
/* 4653 */     if ((this.lastGetDate == null) && (other.getLastGetDate() != null)) return false;
/* 4654 */     if ((this.lastGetDate != null) && (!this.fDate.getString(this.lastGetDate).equals(other.getLastGetDate()))) return false;
/* 4655 */     if ((this.lastLoanDate == null) && (other.getLastLoanDate() != null)) return false;
/* 4656 */     if ((this.lastLoanDate != null) && (!this.fDate.getString(this.lastLoanDate).equals(other.getLastLoanDate()))) return false;
/* 4657 */     if ((this.lastRegetDate == null) && (other.getLastRegetDate() != null)) return false;
/* 4658 */     if ((this.lastRegetDate != null) && (!this.fDate.getString(this.lastRegetDate).equals(other.getLastRegetDate()))) return false;
/* 4659 */     if ((this.lastEdorDate == null) && (other.getLastEdorDate() != null)) return false;
/* 4660 */     if ((this.lastEdorDate != null) && (!this.fDate.getString(this.lastEdorDate).equals(other.getLastEdorDate()))) return false;
/* 4661 */     if ((this.lastRevDate == null) && (other.getLastRevDate() != null)) return false;
/* 4662 */     if ((this.lastRevDate != null) && (!this.fDate.getString(this.lastRevDate).equals(other.getLastRevDate()))) return false;
/* 4663 */     if ((this.rnewFlag == null) && (other.getRnewFlag() != null)) return false;
/* 4664 */     if ((this.rnewFlag != null) && (!this.rnewFlag.equals(other.getRnewFlag()))) return false;
/* 4665 */     if ((this.stopFlag == null) && (other.getStopFlag() != null)) return false;
/* 4666 */     if ((this.stopFlag != null) && (!this.stopFlag.equals(other.getStopFlag()))) return false;
/* 4667 */     if ((this.expiryFlag == null) && (other.getExpiryFlag() != null)) return false;
/* 4668 */     if ((this.expiryFlag != null) && (!this.expiryFlag.equals(other.getExpiryFlag()))) return false;
/* 4669 */     if ((this.autoPayFlag == null) && (other.getAutoPayFlag() != null)) return false;
/* 4670 */     if ((this.autoPayFlag != null) && (!this.autoPayFlag.equals(other.getAutoPayFlag()))) return false;
/* 4671 */     if ((this.interestDifFlag == null) && (other.getInterestDifFlag() != null)) return false;
/* 4672 */     if ((this.interestDifFlag != null) && (!this.interestDifFlag.equals(other.getInterestDifFlag()))) return false;
/* 4673 */     if ((this.subFlag == null) && (other.getSubFlag() != null)) return false;
/* 4674 */     if ((this.subFlag != null) && (!this.subFlag.equals(other.getSubFlag()))) return false;
/* 4675 */     if ((this.bnfFlag == null) && (other.getBnfFlag() != null)) return false;
/* 4676 */     if ((this.bnfFlag != null) && (!this.bnfFlag.equals(other.getBnfFlag()))) return false;
/* 4677 */     if ((this.healthCheckFlag == null) && (other.getHealthCheckFlag() != null)) return false;
/* 4678 */     if ((this.healthCheckFlag != null) && (!this.healthCheckFlag.equals(other.getHealthCheckFlag()))) return false;
/* 4679 */     if ((this.impartFlag == null) && (other.getImpartFlag() != null)) return false;
/* 4680 */     if ((this.impartFlag != null) && (!this.impartFlag.equals(other.getImpartFlag()))) return false;
/* 4681 */     if ((this.reinsureFlag == null) && (other.getReinsureFlag() != null)) return false;
/* 4682 */     if ((this.reinsureFlag != null) && (!this.reinsureFlag.equals(other.getReinsureFlag()))) return false;
/* 4683 */     if ((this.agentPayFlag == null) && (other.getAgentPayFlag() != null)) return false;
/* 4684 */     if ((this.agentPayFlag != null) && (!this.agentPayFlag.equals(other.getAgentPayFlag()))) return false;
/* 4685 */     if ((this.agentGetFlag == null) && (other.getAgentGetFlag() != null)) return false;
/* 4686 */     if ((this.agentGetFlag != null) && (!this.agentGetFlag.equals(other.getAgentGetFlag()))) return false;
/* 4687 */     if ((this.liveGetMode == null) && (other.getLiveGetMode() != null)) return false;
/* 4688 */     if ((this.liveGetMode != null) && (!this.liveGetMode.equals(other.getLiveGetMode()))) return false;
/* 4689 */     if ((this.deadGetMode == null) && (other.getDeadGetMode() != null)) return false;
/* 4690 */     if ((this.deadGetMode != null) && (!this.deadGetMode.equals(other.getDeadGetMode()))) return false;
/* 4691 */     if ((this.bonusGetMode == null) && (other.getBonusGetMode() != null)) return false;
/* 4692 */     if ((this.bonusGetMode != null) && (!this.bonusGetMode.equals(other.getBonusGetMode()))) return false;
/* 4693 */     if ((this.deadAmntType == null) && (other.getDeadAmntType() != null)) return false;
/* 4694 */     if ((this.deadAmntType != null) && (!this.deadAmntType.equals(other.getDeadAmntType()))) return false;
/* 4695 */     if (Double.doubleToLongBits(this.topUpPrem) != Double.doubleToLongBits(other.getTopUpPrem())) return false;
/* 4696 */     if ((this.bonusMan == null) && (other.getBonusMan() != null)) return false;
/* 4697 */     if ((this.bonusMan != null) && (!this.bonusMan.equals(other.getBonusMan()))) return false;
/* 4698 */     if ((this.deadFlag == null) && (other.getDeadFlag() != null)) return false;
/* 4699 */     if ((this.deadFlag != null) && (!this.deadFlag.equals(other.getDeadFlag()))) return false;
/* 4700 */     if ((this.smokeFlag == null) && (other.getSmokeFlag() != null)) return false;
/* 4701 */     if ((this.smokeFlag != null) && (!this.smokeFlag.equals(other.getSmokeFlag()))) return false;
/* 4702 */     if ((this.remark == null) && (other.getRemark() != null)) return false;
/* 4703 */     if ((this.remark != null) && (!this.remark.equals(other.getRemark()))) return false;
/* 4704 */     if ((this.approveFlag == null) && (other.getApproveFlag() != null)) return false;
/* 4705 */     if ((this.approveFlag != null) && (!this.approveFlag.equals(other.getApproveFlag()))) return false;
/* 4706 */     if ((this.approveCode == null) && (other.getApproveCode() != null)) return false;
/* 4707 */     if ((this.approveCode != null) && (!this.approveCode.equals(other.getApproveCode()))) return false;
/* 4708 */     if ((this.approveDate == null) && (other.getApproveDate() != null)) return false;
/* 4709 */     if ((this.approveDate != null) && (!this.fDate.getString(this.approveDate).equals(other.getApproveDate()))) return false;
/* 4710 */     if ((this.approveTime == null) && (other.getApproveTime() != null)) return false;
/* 4711 */     if ((this.approveTime != null) && (!this.approveTime.equals(other.getApproveTime()))) return false;
/* 4712 */     if ((this.uWFlag == null) && (other.getUWFlag() != null)) return false;
/* 4713 */     if ((this.uWFlag != null) && (!this.uWFlag.equals(other.getUWFlag()))) return false;
/* 4714 */     if ((this.uWCode == null) && (other.getUWCode() != null)) return false;
/* 4715 */     if ((this.uWCode != null) && (!this.uWCode.equals(other.getUWCode()))) return false;
/* 4716 */     if ((this.uWDate == null) && (other.getUWDate() != null)) return false;
/* 4717 */     if ((this.uWDate != null) && (!this.fDate.getString(this.uWDate).equals(other.getUWDate()))) return false;
/* 4718 */     if ((this.uWTime == null) && (other.getUWTime() != null)) return false;
/* 4719 */     if ((this.uWTime != null) && (!this.uWTime.equals(other.getUWTime()))) return false;
/* 4720 */     if ((this.polApplyDate == null) && (other.getPolApplyDate() != null)) return false;
/* 4721 */     if ((this.polApplyDate != null) && (!this.fDate.getString(this.polApplyDate).equals(other.getPolApplyDate()))) return false;
/* 4722 */     if ((this.appFlag == null) && (other.getAppFlag() != null)) return false;
/* 4723 */     if ((this.appFlag != null) && (!this.appFlag.equals(other.getAppFlag()))) return false;
/* 4724 */     if ((this.saleChnlDetail == null) && (other.getSaleChnlDetail() != null)) return false;
/* 4725 */     if ((this.saleChnlDetail != null) && (!this.saleChnlDetail.equals(other.getSaleChnlDetail()))) return false;
/* 4726 */     if ((this.polState == null) && (other.getPolState() != null)) return false;
/* 4727 */     if ((this.polState != null) && (!this.polState.equals(other.getPolState()))) return false;
/* 4728 */     if ((this.standbyFlag1 == null) && (other.getStandbyFlag1() != null)) return false;
/* 4729 */     if ((this.standbyFlag1 != null) && (!this.standbyFlag1.equals(other.getStandbyFlag1()))) return false;
/* 4730 */     if ((this.standbyFlag2 == null) && (other.getStandbyFlag2() != null)) return false;
/* 4731 */     if ((this.standbyFlag2 != null) && (!this.standbyFlag2.equals(other.getStandbyFlag2()))) return false;
/* 4732 */     if ((this.standbyFlag3 == null) && (other.getStandbyFlag3() != null)) return false;
/* 4733 */     if ((this.standbyFlag3 != null) && (!this.standbyFlag3.equals(other.getStandbyFlag3()))) return false;
/* 4734 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 4735 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 4736 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 4737 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 4738 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 4739 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 4740 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 4741 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 4742 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 4743 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 4750 */     return 119;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 4756 */     if (strFieldName.equals("grpContNo")) {
/* 4757 */       return 0;
/*      */     }
/* 4759 */     if (strFieldName.equals("grpPolNo")) {
/* 4760 */       return 1;
/*      */     }
/* 4762 */     if (strFieldName.equals("contNo")) {
/* 4763 */       return 2;
/*      */     }
/* 4765 */     if (strFieldName.equals("proposalContNo")) {
/* 4766 */       return 3;
/*      */     }
/* 4768 */     if (strFieldName.equals("polNo")) {
/* 4769 */       return 4;
/*      */     }
/* 4771 */     if (strFieldName.equals("proposalNo")) {
/* 4772 */       return 5;
/*      */     }
/* 4774 */     if (strFieldName.equals("prtNo")) {
/* 4775 */       return 6;
/*      */     }
/* 4777 */     if (strFieldName.equals("contType")) {
/* 4778 */       return 7;
/*      */     }
/* 4780 */     if (strFieldName.equals("polTypeFlag")) {
/* 4781 */       return 8;
/*      */     }
/* 4783 */     if (strFieldName.equals("mainPolNo")) {
/* 4784 */       return 9;
/*      */     }
/* 4786 */     if (strFieldName.equals("masterPolNo")) {
/* 4787 */       return 10;
/*      */     }
/* 4789 */     if (strFieldName.equals("kindCode")) {
/* 4790 */       return 11;
/*      */     }
/* 4792 */     if (strFieldName.equals("riskCode")) {
/* 4793 */       return 12;
/*      */     }
/* 4795 */     if (strFieldName.equals("riskVersion")) {
/* 4796 */       return 13;
/*      */     }
/* 4798 */     if (strFieldName.equals("manageCom")) {
/* 4799 */       return 14;
/*      */     }
/* 4801 */     if (strFieldName.equals("agentCom")) {
/* 4802 */       return 15;
/*      */     }
/* 4804 */     if (strFieldName.equals("agentType")) {
/* 4805 */       return 16;
/*      */     }
/* 4807 */     if (strFieldName.equals("agentCode")) {
/* 4808 */       return 17;
/*      */     }
/* 4810 */     if (strFieldName.equals("agentGroup")) {
/* 4811 */       return 18;
/*      */     }
/* 4813 */     if (strFieldName.equals("agentGroup1")) {
/* 4814 */       return 19;
/*      */     }
/* 4816 */     if (strFieldName.equals("agentCode1")) {
/* 4817 */       return 20;
/*      */     }
/* 4819 */     if (strFieldName.equals("saleChnl")) {
/* 4820 */       return 21;
/*      */     }
/* 4822 */     if (strFieldName.equals("handler")) {
/* 4823 */       return 22;
/*      */     }
/* 4825 */     if (strFieldName.equals("insuredNo")) {
/* 4826 */       return 23;
/*      */     }
/* 4828 */     if (strFieldName.equals("insuredId")) {
/* 4829 */       return 24;
/*      */     }
/* 4831 */     if (strFieldName.equals("insuredName")) {
/* 4832 */       return 25;
/*      */     }
/* 4834 */     if (strFieldName.equals("insuredSex")) {
/* 4835 */       return 26;
/*      */     }
/* 4837 */     if (strFieldName.equals("insuredBirthday")) {
/* 4838 */       return 27;
/*      */     }
/* 4840 */     if (strFieldName.equals("insuredAppAge")) {
/* 4841 */       return 28;
/*      */     }
/* 4843 */     if (strFieldName.equals("insuredPeoples")) {
/* 4844 */       return 29;
/*      */     }
/* 4846 */     if (strFieldName.equals("occupationType")) {
/* 4847 */       return 30;
/*      */     }
/* 4849 */     if (strFieldName.equals("appntNo")) {
/* 4850 */       return 31;
/*      */     }
/* 4852 */     if (strFieldName.equals("appntName")) {
/* 4853 */       return 32;
/*      */     }
/* 4855 */     if (strFieldName.equals("cValiDate")) {
/* 4856 */       return 33;
/*      */     }
/* 4858 */     if (strFieldName.equals("signCom")) {
/* 4859 */       return 34;
/*      */     }
/* 4861 */     if (strFieldName.equals("signDate")) {
/* 4862 */       return 35;
/*      */     }
/* 4864 */     if (strFieldName.equals("signTime")) {
/* 4865 */       return 36;
/*      */     }
/* 4867 */     if (strFieldName.equals("firstPayDate")) {
/* 4868 */       return 37;
/*      */     }
/* 4870 */     if (strFieldName.equals("payEndDate")) {
/* 4871 */       return 38;
/*      */     }
/* 4873 */     if (strFieldName.equals("paytoDate")) {
/* 4874 */       return 39;
/*      */     }
/* 4876 */     if (strFieldName.equals("getStartDate")) {
/* 4877 */       return 40;
/*      */     }
/* 4879 */     if (strFieldName.equals("endDate")) {
/* 4880 */       return 41;
/*      */     }
/* 4882 */     if (strFieldName.equals("acciEndDate")) {
/* 4883 */       return 42;
/*      */     }
/* 4885 */     if (strFieldName.equals("getYearFlag")) {
/* 4886 */       return 43;
/*      */     }
/* 4888 */     if (strFieldName.equals("getYear")) {
/* 4889 */       return 44;
/*      */     }
/* 4891 */     if (strFieldName.equals("payEndYearFlag")) {
/* 4892 */       return 45;
/*      */     }
/* 4894 */     if (strFieldName.equals("payEndYear")) {
/* 4895 */       return 46;
/*      */     }
/* 4897 */     if (strFieldName.equals("insuYearFlag")) {
/* 4898 */       return 47;
/*      */     }
/* 4900 */     if (strFieldName.equals("insuYear")) {
/* 4901 */       return 48;
/*      */     }
/* 4903 */     if (strFieldName.equals("acciYearFlag")) {
/* 4904 */       return 49;
/*      */     }
/* 4906 */     if (strFieldName.equals("acciYear")) {
/* 4907 */       return 50;
/*      */     }
/* 4909 */     if (strFieldName.equals("getStartType")) {
/* 4910 */       return 51;
/*      */     }
/* 4912 */     if (strFieldName.equals("specifyValiDate")) {
/* 4913 */       return 52;
/*      */     }
/* 4915 */     if (strFieldName.equals("payMode")) {
/* 4916 */       return 53;
/*      */     }
/* 4918 */     if (strFieldName.equals("payLocation")) {
/* 4919 */       return 54;
/*      */     }
/* 4921 */     if (strFieldName.equals("payIntv")) {
/* 4922 */       return 55;
/*      */     }
/* 4924 */     if (strFieldName.equals("payYears")) {
/* 4925 */       return 56;
/*      */     }
/* 4927 */     if (strFieldName.equals("years")) {
/* 4928 */       return 57;
/*      */     }
/* 4930 */     if (strFieldName.equals("manageFeeRate")) {
/* 4931 */       return 58;
/*      */     }
/* 4933 */     if (strFieldName.equals("floatRate")) {
/* 4934 */       return 59;
/*      */     }
/* 4936 */     if (strFieldName.equals("premRate")) {
/* 4937 */       return 60;
/*      */     }
/* 4939 */     if (strFieldName.equals("premToAmnt")) {
/* 4940 */       return 61;
/*      */     }
/* 4942 */     if (strFieldName.equals("mult")) {
/* 4943 */       return 62;
/*      */     }
/* 4945 */     if (strFieldName.equals("standPrem")) {
/* 4946 */       return 63;
/*      */     }
/* 4948 */     if (strFieldName.equals("prem")) {
/* 4949 */       return 64;
/*      */     }
/* 4951 */     if (strFieldName.equals("sumPrem")) {
/* 4952 */       return 65;
/*      */     }
/* 4954 */     if (strFieldName.equals("amnt")) {
/* 4955 */       return 66;
/*      */     }
/* 4957 */     if (strFieldName.equals("riskAmnt")) {
/* 4958 */       return 67;
/*      */     }
/* 4960 */     if (strFieldName.equals("leavingMoney")) {
/* 4961 */       return 68;
/*      */     }
/* 4963 */     if (strFieldName.equals("endorseTimes")) {
/* 4964 */       return 69;
/*      */     }
/* 4966 */     if (strFieldName.equals("claimTimes")) {
/* 4967 */       return 70;
/*      */     }
/* 4969 */     if (strFieldName.equals("liveTimes")) {
/* 4970 */       return 71;
/*      */     }
/* 4972 */     if (strFieldName.equals("renewCount")) {
/* 4973 */       return 72;
/*      */     }
/* 4975 */     if (strFieldName.equals("lastGetDate")) {
/* 4976 */       return 73;
/*      */     }
/* 4978 */     if (strFieldName.equals("lastLoanDate")) {
/* 4979 */       return 74;
/*      */     }
/* 4981 */     if (strFieldName.equals("lastRegetDate")) {
/* 4982 */       return 75;
/*      */     }
/* 4984 */     if (strFieldName.equals("lastEdorDate")) {
/* 4985 */       return 76;
/*      */     }
/* 4987 */     if (strFieldName.equals("lastRevDate")) {
/* 4988 */       return 77;
/*      */     }
/* 4990 */     if (strFieldName.equals("rnewFlag")) {
/* 4991 */       return 78;
/*      */     }
/* 4993 */     if (strFieldName.equals("stopFlag")) {
/* 4994 */       return 79;
/*      */     }
/* 4996 */     if (strFieldName.equals("expiryFlag")) {
/* 4997 */       return 80;
/*      */     }
/* 4999 */     if (strFieldName.equals("autoPayFlag")) {
/* 5000 */       return 81;
/*      */     }
/* 5002 */     if (strFieldName.equals("interestDifFlag")) {
/* 5003 */       return 82;
/*      */     }
/* 5005 */     if (strFieldName.equals("subFlag")) {
/* 5006 */       return 83;
/*      */     }
/* 5008 */     if (strFieldName.equals("bnfFlag")) {
/* 5009 */       return 84;
/*      */     }
/* 5011 */     if (strFieldName.equals("healthCheckFlag")) {
/* 5012 */       return 85;
/*      */     }
/* 5014 */     if (strFieldName.equals("impartFlag")) {
/* 5015 */       return 86;
/*      */     }
/* 5017 */     if (strFieldName.equals("reinsureFlag")) {
/* 5018 */       return 87;
/*      */     }
/* 5020 */     if (strFieldName.equals("agentPayFlag")) {
/* 5021 */       return 88;
/*      */     }
/* 5023 */     if (strFieldName.equals("agentGetFlag")) {
/* 5024 */       return 89;
/*      */     }
/* 5026 */     if (strFieldName.equals("liveGetMode")) {
/* 5027 */       return 90;
/*      */     }
/* 5029 */     if (strFieldName.equals("deadGetMode")) {
/* 5030 */       return 91;
/*      */     }
/* 5032 */     if (strFieldName.equals("bonusGetMode")) {
/* 5033 */       return 92;
/*      */     }
/* 5035 */     if (strFieldName.equals("deadAmntType")) {
/* 5036 */       return 93;
/*      */     }
/* 5038 */     if (strFieldName.equals("topUpPrem")) {
/* 5039 */       return 94;
/*      */     }
/* 5041 */     if (strFieldName.equals("bonusMan")) {
/* 5042 */       return 95;
/*      */     }
/* 5044 */     if (strFieldName.equals("deadFlag")) {
/* 5045 */       return 96;
/*      */     }
/* 5047 */     if (strFieldName.equals("smokeFlag")) {
/* 5048 */       return 97;
/*      */     }
/* 5050 */     if (strFieldName.equals("remark")) {
/* 5051 */       return 98;
/*      */     }
/* 5053 */     if (strFieldName.equals("approveFlag")) {
/* 5054 */       return 99;
/*      */     }
/* 5056 */     if (strFieldName.equals("approveCode")) {
/* 5057 */       return 100;
/*      */     }
/* 5059 */     if (strFieldName.equals("approveDate")) {
/* 5060 */       return 101;
/*      */     }
/* 5062 */     if (strFieldName.equals("approveTime")) {
/* 5063 */       return 102;
/*      */     }
/* 5065 */     if (strFieldName.equals("uWFlag")) {
/* 5066 */       return 103;
/*      */     }
/* 5068 */     if (strFieldName.equals("uWCode")) {
/* 5069 */       return 104;
/*      */     }
/* 5071 */     if (strFieldName.equals("uWDate")) {
/* 5072 */       return 105;
/*      */     }
/* 5074 */     if (strFieldName.equals("uWTime")) {
/* 5075 */       return 106;
/*      */     }
/* 5077 */     if (strFieldName.equals("polApplyDate")) {
/* 5078 */       return 107;
/*      */     }
/* 5080 */     if (strFieldName.equals("appFlag")) {
/* 5081 */       return 108;
/*      */     }
/* 5083 */     if (strFieldName.equals("saleChnlDetail")) {
/* 5084 */       return 109;
/*      */     }
/* 5086 */     if (strFieldName.equals("polState")) {
/* 5087 */       return 110;
/*      */     }
/* 5089 */     if (strFieldName.equals("standbyFlag1")) {
/* 5090 */       return 111;
/*      */     }
/* 5092 */     if (strFieldName.equals("standbyFlag2")) {
/* 5093 */       return 112;
/*      */     }
/* 5095 */     if (strFieldName.equals("standbyFlag3")) {
/* 5096 */       return 113;
/*      */     }
/* 5098 */     if (strFieldName.equals("operator")) {
/* 5099 */       return 114;
/*      */     }
/* 5101 */     if (strFieldName.equals("makeDate")) {
/* 5102 */       return 115;
/*      */     }
/* 5104 */     if (strFieldName.equals("makeTime")) {
/* 5105 */       return 116;
/*      */     }
/* 5107 */     if (strFieldName.equals("modifyDate")) {
/* 5108 */       return 117;
/*      */     }
/* 5110 */     if (strFieldName.equals("modifyTime")) {
/* 5111 */       return 118;
/*      */     }
/* 5113 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 5119 */     String strFieldName = "";
/* 5120 */     switch (nFieldIndex) {
/*      */     case 0:
/* 5122 */       strFieldName = "grpContNo";
/* 5123 */       break;
/*      */     case 1:
/* 5125 */       strFieldName = "grpPolNo";
/* 5126 */       break;
/*      */     case 2:
/* 5128 */       strFieldName = "contNo";
/* 5129 */       break;
/*      */     case 3:
/* 5131 */       strFieldName = "proposalContNo";
/* 5132 */       break;
/*      */     case 4:
/* 5134 */       strFieldName = "polNo";
/* 5135 */       break;
/*      */     case 5:
/* 5137 */       strFieldName = "proposalNo";
/* 5138 */       break;
/*      */     case 6:
/* 5140 */       strFieldName = "prtNo";
/* 5141 */       break;
/*      */     case 7:
/* 5143 */       strFieldName = "contType";
/* 5144 */       break;
/*      */     case 8:
/* 5146 */       strFieldName = "polTypeFlag";
/* 5147 */       break;
/*      */     case 9:
/* 5149 */       strFieldName = "mainPolNo";
/* 5150 */       break;
/*      */     case 10:
/* 5152 */       strFieldName = "masterPolNo";
/* 5153 */       break;
/*      */     case 11:
/* 5155 */       strFieldName = "kindCode";
/* 5156 */       break;
/*      */     case 12:
/* 5158 */       strFieldName = "riskCode";
/* 5159 */       break;
/*      */     case 13:
/* 5161 */       strFieldName = "riskVersion";
/* 5162 */       break;
/*      */     case 14:
/* 5164 */       strFieldName = "manageCom";
/* 5165 */       break;
/*      */     case 15:
/* 5167 */       strFieldName = "agentCom";
/* 5168 */       break;
/*      */     case 16:
/* 5170 */       strFieldName = "agentType";
/* 5171 */       break;
/*      */     case 17:
/* 5173 */       strFieldName = "agentCode";
/* 5174 */       break;
/*      */     case 18:
/* 5176 */       strFieldName = "agentGroup";
/* 5177 */       break;
/*      */     case 19:
/* 5179 */       strFieldName = "agentGroup1";
/* 5180 */       break;
/*      */     case 20:
/* 5182 */       strFieldName = "agentCode1";
/* 5183 */       break;
/*      */     case 21:
/* 5185 */       strFieldName = "saleChnl";
/* 5186 */       break;
/*      */     case 22:
/* 5188 */       strFieldName = "handler";
/* 5189 */       break;
/*      */     case 23:
/* 5191 */       strFieldName = "insuredNo";
/* 5192 */       break;
/*      */     case 24:
/* 5194 */       strFieldName = "insuredId";
/* 5195 */       break;
/*      */     case 25:
/* 5197 */       strFieldName = "insuredName";
/* 5198 */       break;
/*      */     case 26:
/* 5200 */       strFieldName = "insuredSex";
/* 5201 */       break;
/*      */     case 27:
/* 5203 */       strFieldName = "insuredBirthday";
/* 5204 */       break;
/*      */     case 28:
/* 5206 */       strFieldName = "insuredAppAge";
/* 5207 */       break;
/*      */     case 29:
/* 5209 */       strFieldName = "insuredPeoples";
/* 5210 */       break;
/*      */     case 30:
/* 5212 */       strFieldName = "occupationType";
/* 5213 */       break;
/*      */     case 31:
/* 5215 */       strFieldName = "appntNo";
/* 5216 */       break;
/*      */     case 32:
/* 5218 */       strFieldName = "appntName";
/* 5219 */       break;
/*      */     case 33:
/* 5221 */       strFieldName = "cValiDate";
/* 5222 */       break;
/*      */     case 34:
/* 5224 */       strFieldName = "signCom";
/* 5225 */       break;
/*      */     case 35:
/* 5227 */       strFieldName = "signDate";
/* 5228 */       break;
/*      */     case 36:
/* 5230 */       strFieldName = "signTime";
/* 5231 */       break;
/*      */     case 37:
/* 5233 */       strFieldName = "firstPayDate";
/* 5234 */       break;
/*      */     case 38:
/* 5236 */       strFieldName = "payEndDate";
/* 5237 */       break;
/*      */     case 39:
/* 5239 */       strFieldName = "paytoDate";
/* 5240 */       break;
/*      */     case 40:
/* 5242 */       strFieldName = "getStartDate";
/* 5243 */       break;
/*      */     case 41:
/* 5245 */       strFieldName = "endDate";
/* 5246 */       break;
/*      */     case 42:
/* 5248 */       strFieldName = "acciEndDate";
/* 5249 */       break;
/*      */     case 43:
/* 5251 */       strFieldName = "getYearFlag";
/* 5252 */       break;
/*      */     case 44:
/* 5254 */       strFieldName = "getYear";
/* 5255 */       break;
/*      */     case 45:
/* 5257 */       strFieldName = "payEndYearFlag";
/* 5258 */       break;
/*      */     case 46:
/* 5260 */       strFieldName = "payEndYear";
/* 5261 */       break;
/*      */     case 47:
/* 5263 */       strFieldName = "insuYearFlag";
/* 5264 */       break;
/*      */     case 48:
/* 5266 */       strFieldName = "insuYear";
/* 5267 */       break;
/*      */     case 49:
/* 5269 */       strFieldName = "acciYearFlag";
/* 5270 */       break;
/*      */     case 50:
/* 5272 */       strFieldName = "acciYear";
/* 5273 */       break;
/*      */     case 51:
/* 5275 */       strFieldName = "getStartType";
/* 5276 */       break;
/*      */     case 52:
/* 5278 */       strFieldName = "specifyValiDate";
/* 5279 */       break;
/*      */     case 53:
/* 5281 */       strFieldName = "payMode";
/* 5282 */       break;
/*      */     case 54:
/* 5284 */       strFieldName = "payLocation";
/* 5285 */       break;
/*      */     case 55:
/* 5287 */       strFieldName = "payIntv";
/* 5288 */       break;
/*      */     case 56:
/* 5290 */       strFieldName = "payYears";
/* 5291 */       break;
/*      */     case 57:
/* 5293 */       strFieldName = "years";
/* 5294 */       break;
/*      */     case 58:
/* 5296 */       strFieldName = "manageFeeRate";
/* 5297 */       break;
/*      */     case 59:
/* 5299 */       strFieldName = "floatRate";
/* 5300 */       break;
/*      */     case 60:
/* 5302 */       strFieldName = "premRate";
/* 5303 */       break;
/*      */     case 61:
/* 5305 */       strFieldName = "premToAmnt";
/* 5306 */       break;
/*      */     case 62:
/* 5308 */       strFieldName = "mult";
/* 5309 */       break;
/*      */     case 63:
/* 5311 */       strFieldName = "standPrem";
/* 5312 */       break;
/*      */     case 64:
/* 5314 */       strFieldName = "prem";
/* 5315 */       break;
/*      */     case 65:
/* 5317 */       strFieldName = "sumPrem";
/* 5318 */       break;
/*      */     case 66:
/* 5320 */       strFieldName = "amnt";
/* 5321 */       break;
/*      */     case 67:
/* 5323 */       strFieldName = "riskAmnt";
/* 5324 */       break;
/*      */     case 68:
/* 5326 */       strFieldName = "leavingMoney";
/* 5327 */       break;
/*      */     case 69:
/* 5329 */       strFieldName = "endorseTimes";
/* 5330 */       break;
/*      */     case 70:
/* 5332 */       strFieldName = "claimTimes";
/* 5333 */       break;
/*      */     case 71:
/* 5335 */       strFieldName = "liveTimes";
/* 5336 */       break;
/*      */     case 72:
/* 5338 */       strFieldName = "renewCount";
/* 5339 */       break;
/*      */     case 73:
/* 5341 */       strFieldName = "lastGetDate";
/* 5342 */       break;
/*      */     case 74:
/* 5344 */       strFieldName = "lastLoanDate";
/* 5345 */       break;
/*      */     case 75:
/* 5347 */       strFieldName = "lastRegetDate";
/* 5348 */       break;
/*      */     case 76:
/* 5350 */       strFieldName = "lastEdorDate";
/* 5351 */       break;
/*      */     case 77:
/* 5353 */       strFieldName = "lastRevDate";
/* 5354 */       break;
/*      */     case 78:
/* 5356 */       strFieldName = "rnewFlag";
/* 5357 */       break;
/*      */     case 79:
/* 5359 */       strFieldName = "stopFlag";
/* 5360 */       break;
/*      */     case 80:
/* 5362 */       strFieldName = "expiryFlag";
/* 5363 */       break;
/*      */     case 81:
/* 5365 */       strFieldName = "autoPayFlag";
/* 5366 */       break;
/*      */     case 82:
/* 5368 */       strFieldName = "interestDifFlag";
/* 5369 */       break;
/*      */     case 83:
/* 5371 */       strFieldName = "subFlag";
/* 5372 */       break;
/*      */     case 84:
/* 5374 */       strFieldName = "bnfFlag";
/* 5375 */       break;
/*      */     case 85:
/* 5377 */       strFieldName = "healthCheckFlag";
/* 5378 */       break;
/*      */     case 86:
/* 5380 */       strFieldName = "impartFlag";
/* 5381 */       break;
/*      */     case 87:
/* 5383 */       strFieldName = "reinsureFlag";
/* 5384 */       break;
/*      */     case 88:
/* 5386 */       strFieldName = "agentPayFlag";
/* 5387 */       break;
/*      */     case 89:
/* 5389 */       strFieldName = "agentGetFlag";
/* 5390 */       break;
/*      */     case 90:
/* 5392 */       strFieldName = "liveGetMode";
/* 5393 */       break;
/*      */     case 91:
/* 5395 */       strFieldName = "deadGetMode";
/* 5396 */       break;
/*      */     case 92:
/* 5398 */       strFieldName = "bonusGetMode";
/* 5399 */       break;
/*      */     case 93:
/* 5401 */       strFieldName = "deadAmntType";
/* 5402 */       break;
/*      */     case 94:
/* 5404 */       strFieldName = "topUpPrem";
/* 5405 */       break;
/*      */     case 95:
/* 5407 */       strFieldName = "bonusMan";
/* 5408 */       break;
/*      */     case 96:
/* 5410 */       strFieldName = "deadFlag";
/* 5411 */       break;
/*      */     case 97:
/* 5413 */       strFieldName = "smokeFlag";
/* 5414 */       break;
/*      */     case 98:
/* 5416 */       strFieldName = "remark";
/* 5417 */       break;
/*      */     case 99:
/* 5419 */       strFieldName = "approveFlag";
/* 5420 */       break;
/*      */     case 100:
/* 5422 */       strFieldName = "approveCode";
/* 5423 */       break;
/*      */     case 101:
/* 5425 */       strFieldName = "approveDate";
/* 5426 */       break;
/*      */     case 102:
/* 5428 */       strFieldName = "approveTime";
/* 5429 */       break;
/*      */     case 103:
/* 5431 */       strFieldName = "uWFlag";
/* 5432 */       break;
/*      */     case 104:
/* 5434 */       strFieldName = "uWCode";
/* 5435 */       break;
/*      */     case 105:
/* 5437 */       strFieldName = "uWDate";
/* 5438 */       break;
/*      */     case 106:
/* 5440 */       strFieldName = "uWTime";
/* 5441 */       break;
/*      */     case 107:
/* 5443 */       strFieldName = "polApplyDate";
/* 5444 */       break;
/*      */     case 108:
/* 5446 */       strFieldName = "appFlag";
/* 5447 */       break;
/*      */     case 109:
/* 5449 */       strFieldName = "saleChnlDetail";
/* 5450 */       break;
/*      */     case 110:
/* 5452 */       strFieldName = "polState";
/* 5453 */       break;
/*      */     case 111:
/* 5455 */       strFieldName = "standbyFlag1";
/* 5456 */       break;
/*      */     case 112:
/* 5458 */       strFieldName = "standbyFlag2";
/* 5459 */       break;
/*      */     case 113:
/* 5461 */       strFieldName = "standbyFlag3";
/* 5462 */       break;
/*      */     case 114:
/* 5464 */       strFieldName = "operator";
/* 5465 */       break;
/*      */     case 115:
/* 5467 */       strFieldName = "makeDate";
/* 5468 */       break;
/*      */     case 116:
/* 5470 */       strFieldName = "makeTime";
/* 5471 */       break;
/*      */     case 117:
/* 5473 */       strFieldName = "modifyDate";
/* 5474 */       break;
/*      */     case 118:
/* 5476 */       strFieldName = "modifyTime";
/* 5477 */       break;
/*      */     default:
/* 5479 */       strFieldName = "";
/*      */     }
/* 5481 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 5487 */     if (strFieldName.equals("grpContNo")) {
/* 5488 */       return 0;
/*      */     }
/* 5490 */     if (strFieldName.equals("grpPolNo")) {
/* 5491 */       return 0;
/*      */     }
/* 5493 */     if (strFieldName.equals("contNo")) {
/* 5494 */       return 0;
/*      */     }
/* 5496 */     if (strFieldName.equals("proposalContNo")) {
/* 5497 */       return 0;
/*      */     }
/* 5499 */     if (strFieldName.equals("polNo")) {
/* 5500 */       return 0;
/*      */     }
/* 5502 */     if (strFieldName.equals("proposalNo")) {
/* 5503 */       return 0;
/*      */     }
/* 5505 */     if (strFieldName.equals("prtNo")) {
/* 5506 */       return 0;
/*      */     }
/* 5508 */     if (strFieldName.equals("contType")) {
/* 5509 */       return 0;
/*      */     }
/* 5511 */     if (strFieldName.equals("polTypeFlag")) {
/* 5512 */       return 0;
/*      */     }
/* 5514 */     if (strFieldName.equals("mainPolNo")) {
/* 5515 */       return 0;
/*      */     }
/* 5517 */     if (strFieldName.equals("masterPolNo")) {
/* 5518 */       return 0;
/*      */     }
/* 5520 */     if (strFieldName.equals("kindCode")) {
/* 5521 */       return 0;
/*      */     }
/* 5523 */     if (strFieldName.equals("riskCode")) {
/* 5524 */       return 0;
/*      */     }
/* 5526 */     if (strFieldName.equals("riskVersion")) {
/* 5527 */       return 0;
/*      */     }
/* 5529 */     if (strFieldName.equals("manageCom")) {
/* 5530 */       return 0;
/*      */     }
/* 5532 */     if (strFieldName.equals("agentCom")) {
/* 5533 */       return 0;
/*      */     }
/* 5535 */     if (strFieldName.equals("agentType")) {
/* 5536 */       return 0;
/*      */     }
/* 5538 */     if (strFieldName.equals("agentCode")) {
/* 5539 */       return 0;
/*      */     }
/* 5541 */     if (strFieldName.equals("agentGroup")) {
/* 5542 */       return 0;
/*      */     }
/* 5544 */     if (strFieldName.equals("agentGroup1")) {
/* 5545 */       return 0;
/*      */     }
/* 5547 */     if (strFieldName.equals("agentCode1")) {
/* 5548 */       return 0;
/*      */     }
/* 5550 */     if (strFieldName.equals("saleChnl")) {
/* 5551 */       return 0;
/*      */     }
/* 5553 */     if (strFieldName.equals("handler")) {
/* 5554 */       return 0;
/*      */     }
/* 5556 */     if (strFieldName.equals("insuredNo")) {
/* 5557 */       return 0;
/*      */     }
/* 5559 */     if (strFieldName.equals("insuredId")) {
/* 5560 */       return 0;
/*      */     }
/* 5562 */     if (strFieldName.equals("insuredName")) {
/* 5563 */       return 0;
/*      */     }
/* 5565 */     if (strFieldName.equals("insuredSex")) {
/* 5566 */       return 0;
/*      */     }
/* 5568 */     if (strFieldName.equals("insuredBirthday")) {
/* 5569 */       return 1;
/*      */     }
/* 5571 */     if (strFieldName.equals("insuredAppAge")) {
/* 5572 */       return 3;
/*      */     }
/* 5574 */     if (strFieldName.equals("insuredPeoples")) {
/* 5575 */       return 3;
/*      */     }
/* 5577 */     if (strFieldName.equals("occupationType")) {
/* 5578 */       return 0;
/*      */     }
/* 5580 */     if (strFieldName.equals("appntNo")) {
/* 5581 */       return 0;
/*      */     }
/* 5583 */     if (strFieldName.equals("appntName")) {
/* 5584 */       return 0;
/*      */     }
/* 5586 */     if (strFieldName.equals("cValiDate")) {
/* 5587 */       return 1;
/*      */     }
/* 5589 */     if (strFieldName.equals("signCom")) {
/* 5590 */       return 0;
/*      */     }
/* 5592 */     if (strFieldName.equals("signDate")) {
/* 5593 */       return 1;
/*      */     }
/* 5595 */     if (strFieldName.equals("signTime")) {
/* 5596 */       return 0;
/*      */     }
/* 5598 */     if (strFieldName.equals("firstPayDate")) {
/* 5599 */       return 1;
/*      */     }
/* 5601 */     if (strFieldName.equals("payEndDate")) {
/* 5602 */       return 1;
/*      */     }
/* 5604 */     if (strFieldName.equals("paytoDate")) {
/* 5605 */       return 1;
/*      */     }
/* 5607 */     if (strFieldName.equals("getStartDate")) {
/* 5608 */       return 1;
/*      */     }
/* 5610 */     if (strFieldName.equals("endDate")) {
/* 5611 */       return 1;
/*      */     }
/* 5613 */     if (strFieldName.equals("acciEndDate")) {
/* 5614 */       return 1;
/*      */     }
/* 5616 */     if (strFieldName.equals("getYearFlag")) {
/* 5617 */       return 0;
/*      */     }
/* 5619 */     if (strFieldName.equals("getYear")) {
/* 5620 */       return 3;
/*      */     }
/* 5622 */     if (strFieldName.equals("payEndYearFlag")) {
/* 5623 */       return 0;
/*      */     }
/* 5625 */     if (strFieldName.equals("payEndYear")) {
/* 5626 */       return 3;
/*      */     }
/* 5628 */     if (strFieldName.equals("insuYearFlag")) {
/* 5629 */       return 0;
/*      */     }
/* 5631 */     if (strFieldName.equals("insuYear")) {
/* 5632 */       return 3;
/*      */     }
/* 5634 */     if (strFieldName.equals("acciYearFlag")) {
/* 5635 */       return 0;
/*      */     }
/* 5637 */     if (strFieldName.equals("acciYear")) {
/* 5638 */       return 3;
/*      */     }
/* 5640 */     if (strFieldName.equals("getStartType")) {
/* 5641 */       return 0;
/*      */     }
/* 5643 */     if (strFieldName.equals("specifyValiDate")) {
/* 5644 */       return 0;
/*      */     }
/* 5646 */     if (strFieldName.equals("payMode")) {
/* 5647 */       return 0;
/*      */     }
/* 5649 */     if (strFieldName.equals("payLocation")) {
/* 5650 */       return 0;
/*      */     }
/* 5652 */     if (strFieldName.equals("payIntv")) {
/* 5653 */       return 3;
/*      */     }
/* 5655 */     if (strFieldName.equals("payYears")) {
/* 5656 */       return 3;
/*      */     }
/* 5658 */     if (strFieldName.equals("years")) {
/* 5659 */       return 3;
/*      */     }
/* 5661 */     if (strFieldName.equals("manageFeeRate")) {
/* 5662 */       return 4;
/*      */     }
/* 5664 */     if (strFieldName.equals("floatRate")) {
/* 5665 */       return 4;
/*      */     }
/* 5667 */     if (strFieldName.equals("premRate")) {
/* 5668 */       return 4;
/*      */     }
/* 5670 */     if (strFieldName.equals("premToAmnt")) {
/* 5671 */       return 0;
/*      */     }
/* 5673 */     if (strFieldName.equals("mult")) {
/* 5674 */       return 4;
/*      */     }
/* 5676 */     if (strFieldName.equals("standPrem")) {
/* 5677 */       return 4;
/*      */     }
/* 5679 */     if (strFieldName.equals("prem")) {
/* 5680 */       return 4;
/*      */     }
/* 5682 */     if (strFieldName.equals("sumPrem")) {
/* 5683 */       return 4;
/*      */     }
/* 5685 */     if (strFieldName.equals("amnt")) {
/* 5686 */       return 4;
/*      */     }
/* 5688 */     if (strFieldName.equals("riskAmnt")) {
/* 5689 */       return 4;
/*      */     }
/* 5691 */     if (strFieldName.equals("leavingMoney")) {
/* 5692 */       return 4;
/*      */     }
/* 5694 */     if (strFieldName.equals("endorseTimes")) {
/* 5695 */       return 3;
/*      */     }
/* 5697 */     if (strFieldName.equals("claimTimes")) {
/* 5698 */       return 3;
/*      */     }
/* 5700 */     if (strFieldName.equals("liveTimes")) {
/* 5701 */       return 3;
/*      */     }
/* 5703 */     if (strFieldName.equals("renewCount")) {
/* 5704 */       return 3;
/*      */     }
/* 5706 */     if (strFieldName.equals("lastGetDate")) {
/* 5707 */       return 1;
/*      */     }
/* 5709 */     if (strFieldName.equals("lastLoanDate")) {
/* 5710 */       return 1;
/*      */     }
/* 5712 */     if (strFieldName.equals("lastRegetDate")) {
/* 5713 */       return 1;
/*      */     }
/* 5715 */     if (strFieldName.equals("lastEdorDate")) {
/* 5716 */       return 1;
/*      */     }
/* 5718 */     if (strFieldName.equals("lastRevDate")) {
/* 5719 */       return 1;
/*      */     }
/* 5721 */     if (strFieldName.equals("rnewFlag")) {
/* 5722 */       return 0;
/*      */     }
/* 5724 */     if (strFieldName.equals("stopFlag")) {
/* 5725 */       return 0;
/*      */     }
/* 5727 */     if (strFieldName.equals("expiryFlag")) {
/* 5728 */       return 0;
/*      */     }
/* 5730 */     if (strFieldName.equals("autoPayFlag")) {
/* 5731 */       return 0;
/*      */     }
/* 5733 */     if (strFieldName.equals("interestDifFlag")) {
/* 5734 */       return 0;
/*      */     }
/* 5736 */     if (strFieldName.equals("subFlag")) {
/* 5737 */       return 0;
/*      */     }
/* 5739 */     if (strFieldName.equals("bnfFlag")) {
/* 5740 */       return 0;
/*      */     }
/* 5742 */     if (strFieldName.equals("healthCheckFlag")) {
/* 5743 */       return 0;
/*      */     }
/* 5745 */     if (strFieldName.equals("impartFlag")) {
/* 5746 */       return 0;
/*      */     }
/* 5748 */     if (strFieldName.equals("reinsureFlag")) {
/* 5749 */       return 0;
/*      */     }
/* 5751 */     if (strFieldName.equals("agentPayFlag")) {
/* 5752 */       return 0;
/*      */     }
/* 5754 */     if (strFieldName.equals("agentGetFlag")) {
/* 5755 */       return 0;
/*      */     }
/* 5757 */     if (strFieldName.equals("liveGetMode")) {
/* 5758 */       return 0;
/*      */     }
/* 5760 */     if (strFieldName.equals("deadGetMode")) {
/* 5761 */       return 0;
/*      */     }
/* 5763 */     if (strFieldName.equals("bonusGetMode")) {
/* 5764 */       return 0;
/*      */     }
/* 5766 */     if (strFieldName.equals("deadAmntType")) {
/* 5767 */       return 0;
/*      */     }
/* 5769 */     if (strFieldName.equals("topUpPrem")) {
/* 5770 */       return 4;
/*      */     }
/* 5772 */     if (strFieldName.equals("bonusMan")) {
/* 5773 */       return 0;
/*      */     }
/* 5775 */     if (strFieldName.equals("deadFlag")) {
/* 5776 */       return 0;
/*      */     }
/* 5778 */     if (strFieldName.equals("smokeFlag")) {
/* 5779 */       return 0;
/*      */     }
/* 5781 */     if (strFieldName.equals("remark")) {
/* 5782 */       return 0;
/*      */     }
/* 5784 */     if (strFieldName.equals("approveFlag")) {
/* 5785 */       return 0;
/*      */     }
/* 5787 */     if (strFieldName.equals("approveCode")) {
/* 5788 */       return 0;
/*      */     }
/* 5790 */     if (strFieldName.equals("approveDate")) {
/* 5791 */       return 1;
/*      */     }
/* 5793 */     if (strFieldName.equals("approveTime")) {
/* 5794 */       return 0;
/*      */     }
/* 5796 */     if (strFieldName.equals("uWFlag")) {
/* 5797 */       return 0;
/*      */     }
/* 5799 */     if (strFieldName.equals("uWCode")) {
/* 5800 */       return 0;
/*      */     }
/* 5802 */     if (strFieldName.equals("uWDate")) {
/* 5803 */       return 1;
/*      */     }
/* 5805 */     if (strFieldName.equals("uWTime")) {
/* 5806 */       return 0;
/*      */     }
/* 5808 */     if (strFieldName.equals("polApplyDate")) {
/* 5809 */       return 1;
/*      */     }
/* 5811 */     if (strFieldName.equals("appFlag")) {
/* 5812 */       return 0;
/*      */     }
/* 5814 */     if (strFieldName.equals("saleChnlDetail")) {
/* 5815 */       return 0;
/*      */     }
/* 5817 */     if (strFieldName.equals("polState")) {
/* 5818 */       return 0;
/*      */     }
/* 5820 */     if (strFieldName.equals("standbyFlag1")) {
/* 5821 */       return 0;
/*      */     }
/* 5823 */     if (strFieldName.equals("standbyFlag2")) {
/* 5824 */       return 0;
/*      */     }
/* 5826 */     if (strFieldName.equals("standbyFlag3")) {
/* 5827 */       return 0;
/*      */     }
/* 5829 */     if (strFieldName.equals("operator")) {
/* 5830 */       return 0;
/*      */     }
/* 5832 */     if (strFieldName.equals("makeDate")) {
/* 5833 */       return 1;
/*      */     }
/* 5835 */     if (strFieldName.equals("makeTime")) {
/* 5836 */       return 0;
/*      */     }
/* 5838 */     if (strFieldName.equals("modifyDate")) {
/* 5839 */       return 1;
/*      */     }
/* 5841 */     if (strFieldName.equals("modifyTime")) {
/* 5842 */       return 0;
/*      */     }
/* 5844 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 5850 */     int nFieldType = -1;
/* 5851 */     switch (nFieldIndex) {
/*      */     case 0:
/* 5853 */       nFieldType = 0;
/* 5854 */       break;
/*      */     case 1:
/* 5856 */       nFieldType = 0;
/* 5857 */       break;
/*      */     case 2:
/* 5859 */       nFieldType = 0;
/* 5860 */       break;
/*      */     case 3:
/* 5862 */       nFieldType = 0;
/* 5863 */       break;
/*      */     case 4:
/* 5865 */       nFieldType = 0;
/* 5866 */       break;
/*      */     case 5:
/* 5868 */       nFieldType = 0;
/* 5869 */       break;
/*      */     case 6:
/* 5871 */       nFieldType = 0;
/* 5872 */       break;
/*      */     case 7:
/* 5874 */       nFieldType = 0;
/* 5875 */       break;
/*      */     case 8:
/* 5877 */       nFieldType = 0;
/* 5878 */       break;
/*      */     case 9:
/* 5880 */       nFieldType = 0;
/* 5881 */       break;
/*      */     case 10:
/* 5883 */       nFieldType = 0;
/* 5884 */       break;
/*      */     case 11:
/* 5886 */       nFieldType = 0;
/* 5887 */       break;
/*      */     case 12:
/* 5889 */       nFieldType = 0;
/* 5890 */       break;
/*      */     case 13:
/* 5892 */       nFieldType = 0;
/* 5893 */       break;
/*      */     case 14:
/* 5895 */       nFieldType = 0;
/* 5896 */       break;
/*      */     case 15:
/* 5898 */       nFieldType = 0;
/* 5899 */       break;
/*      */     case 16:
/* 5901 */       nFieldType = 0;
/* 5902 */       break;
/*      */     case 17:
/* 5904 */       nFieldType = 0;
/* 5905 */       break;
/*      */     case 18:
/* 5907 */       nFieldType = 0;
/* 5908 */       break;
/*      */     case 19:
/* 5910 */       nFieldType = 0;
/* 5911 */       break;
/*      */     case 20:
/* 5913 */       nFieldType = 0;
/* 5914 */       break;
/*      */     case 21:
/* 5916 */       nFieldType = 0;
/* 5917 */       break;
/*      */     case 22:
/* 5919 */       nFieldType = 0;
/* 5920 */       break;
/*      */     case 23:
/* 5922 */       nFieldType = 0;
/* 5923 */       break;
/*      */     case 24:
/* 5925 */       nFieldType = 0;
/* 5926 */       break;
/*      */     case 25:
/* 5928 */       nFieldType = 0;
/* 5929 */       break;
/*      */     case 26:
/* 5931 */       nFieldType = 0;
/* 5932 */       break;
/*      */     case 27:
/* 5934 */       nFieldType = 1;
/* 5935 */       break;
/*      */     case 28:
/* 5937 */       nFieldType = 3;
/* 5938 */       break;
/*      */     case 29:
/* 5940 */       nFieldType = 3;
/* 5941 */       break;
/*      */     case 30:
/* 5943 */       nFieldType = 0;
/* 5944 */       break;
/*      */     case 31:
/* 5946 */       nFieldType = 0;
/* 5947 */       break;
/*      */     case 32:
/* 5949 */       nFieldType = 0;
/* 5950 */       break;
/*      */     case 33:
/* 5952 */       nFieldType = 1;
/* 5953 */       break;
/*      */     case 34:
/* 5955 */       nFieldType = 0;
/* 5956 */       break;
/*      */     case 35:
/* 5958 */       nFieldType = 1;
/* 5959 */       break;
/*      */     case 36:
/* 5961 */       nFieldType = 0;
/* 5962 */       break;
/*      */     case 37:
/* 5964 */       nFieldType = 1;
/* 5965 */       break;
/*      */     case 38:
/* 5967 */       nFieldType = 1;
/* 5968 */       break;
/*      */     case 39:
/* 5970 */       nFieldType = 1;
/* 5971 */       break;
/*      */     case 40:
/* 5973 */       nFieldType = 1;
/* 5974 */       break;
/*      */     case 41:
/* 5976 */       nFieldType = 1;
/* 5977 */       break;
/*      */     case 42:
/* 5979 */       nFieldType = 1;
/* 5980 */       break;
/*      */     case 43:
/* 5982 */       nFieldType = 0;
/* 5983 */       break;
/*      */     case 44:
/* 5985 */       nFieldType = 3;
/* 5986 */       break;
/*      */     case 45:
/* 5988 */       nFieldType = 0;
/* 5989 */       break;
/*      */     case 46:
/* 5991 */       nFieldType = 3;
/* 5992 */       break;
/*      */     case 47:
/* 5994 */       nFieldType = 0;
/* 5995 */       break;
/*      */     case 48:
/* 5997 */       nFieldType = 3;
/* 5998 */       break;
/*      */     case 49:
/* 6000 */       nFieldType = 0;
/* 6001 */       break;
/*      */     case 50:
/* 6003 */       nFieldType = 3;
/* 6004 */       break;
/*      */     case 51:
/* 6006 */       nFieldType = 0;
/* 6007 */       break;
/*      */     case 52:
/* 6009 */       nFieldType = 0;
/* 6010 */       break;
/*      */     case 53:
/* 6012 */       nFieldType = 0;
/* 6013 */       break;
/*      */     case 54:
/* 6015 */       nFieldType = 0;
/* 6016 */       break;
/*      */     case 55:
/* 6018 */       nFieldType = 3;
/* 6019 */       break;
/*      */     case 56:
/* 6021 */       nFieldType = 3;
/* 6022 */       break;
/*      */     case 57:
/* 6024 */       nFieldType = 3;
/* 6025 */       break;
/*      */     case 58:
/* 6027 */       nFieldType = 4;
/* 6028 */       break;
/*      */     case 59:
/* 6030 */       nFieldType = 4;
/* 6031 */       break;
/*      */     case 60:
/* 6033 */       nFieldType = 4;
/* 6034 */       break;
/*      */     case 61:
/* 6036 */       nFieldType = 0;
/* 6037 */       break;
/*      */     case 62:
/* 6039 */       nFieldType = 4;
/* 6040 */       break;
/*      */     case 63:
/* 6042 */       nFieldType = 4;
/* 6043 */       break;
/*      */     case 64:
/* 6045 */       nFieldType = 4;
/* 6046 */       break;
/*      */     case 65:
/* 6048 */       nFieldType = 4;
/* 6049 */       break;
/*      */     case 66:
/* 6051 */       nFieldType = 4;
/* 6052 */       break;
/*      */     case 67:
/* 6054 */       nFieldType = 4;
/* 6055 */       break;
/*      */     case 68:
/* 6057 */       nFieldType = 4;
/* 6058 */       break;
/*      */     case 69:
/* 6060 */       nFieldType = 3;
/* 6061 */       break;
/*      */     case 70:
/* 6063 */       nFieldType = 3;
/* 6064 */       break;
/*      */     case 71:
/* 6066 */       nFieldType = 3;
/* 6067 */       break;
/*      */     case 72:
/* 6069 */       nFieldType = 3;
/* 6070 */       break;
/*      */     case 73:
/* 6072 */       nFieldType = 1;
/* 6073 */       break;
/*      */     case 74:
/* 6075 */       nFieldType = 1;
/* 6076 */       break;
/*      */     case 75:
/* 6078 */       nFieldType = 1;
/* 6079 */       break;
/*      */     case 76:
/* 6081 */       nFieldType = 1;
/* 6082 */       break;
/*      */     case 77:
/* 6084 */       nFieldType = 1;
/* 6085 */       break;
/*      */     case 78:
/* 6087 */       nFieldType = 0;
/* 6088 */       break;
/*      */     case 79:
/* 6090 */       nFieldType = 0;
/* 6091 */       break;
/*      */     case 80:
/* 6093 */       nFieldType = 0;
/* 6094 */       break;
/*      */     case 81:
/* 6096 */       nFieldType = 0;
/* 6097 */       break;
/*      */     case 82:
/* 6099 */       nFieldType = 0;
/* 6100 */       break;
/*      */     case 83:
/* 6102 */       nFieldType = 0;
/* 6103 */       break;
/*      */     case 84:
/* 6105 */       nFieldType = 0;
/* 6106 */       break;
/*      */     case 85:
/* 6108 */       nFieldType = 0;
/* 6109 */       break;
/*      */     case 86:
/* 6111 */       nFieldType = 0;
/* 6112 */       break;
/*      */     case 87:
/* 6114 */       nFieldType = 0;
/* 6115 */       break;
/*      */     case 88:
/* 6117 */       nFieldType = 0;
/* 6118 */       break;
/*      */     case 89:
/* 6120 */       nFieldType = 0;
/* 6121 */       break;
/*      */     case 90:
/* 6123 */       nFieldType = 0;
/* 6124 */       break;
/*      */     case 91:
/* 6126 */       nFieldType = 0;
/* 6127 */       break;
/*      */     case 92:
/* 6129 */       nFieldType = 0;
/* 6130 */       break;
/*      */     case 93:
/* 6132 */       nFieldType = 0;
/* 6133 */       break;
/*      */     case 94:
/* 6135 */       nFieldType = 4;
/* 6136 */       break;
/*      */     case 95:
/* 6138 */       nFieldType = 0;
/* 6139 */       break;
/*      */     case 96:
/* 6141 */       nFieldType = 0;
/* 6142 */       break;
/*      */     case 97:
/* 6144 */       nFieldType = 0;
/* 6145 */       break;
/*      */     case 98:
/* 6147 */       nFieldType = 0;
/* 6148 */       break;
/*      */     case 99:
/* 6150 */       nFieldType = 0;
/* 6151 */       break;
/*      */     case 100:
/* 6153 */       nFieldType = 0;
/* 6154 */       break;
/*      */     case 101:
/* 6156 */       nFieldType = 1;
/* 6157 */       break;
/*      */     case 102:
/* 6159 */       nFieldType = 0;
/* 6160 */       break;
/*      */     case 103:
/* 6162 */       nFieldType = 0;
/* 6163 */       break;
/*      */     case 104:
/* 6165 */       nFieldType = 0;
/* 6166 */       break;
/*      */     case 105:
/* 6168 */       nFieldType = 1;
/* 6169 */       break;
/*      */     case 106:
/* 6171 */       nFieldType = 0;
/* 6172 */       break;
/*      */     case 107:
/* 6174 */       nFieldType = 1;
/* 6175 */       break;
/*      */     case 108:
/* 6177 */       nFieldType = 0;
/* 6178 */       break;
/*      */     case 109:
/* 6180 */       nFieldType = 0;
/* 6181 */       break;
/*      */     case 110:
/* 6183 */       nFieldType = 0;
/* 6184 */       break;
/*      */     case 111:
/* 6186 */       nFieldType = 0;
/* 6187 */       break;
/*      */     case 112:
/* 6189 */       nFieldType = 0;
/* 6190 */       break;
/*      */     case 113:
/* 6192 */       nFieldType = 0;
/* 6193 */       break;
/*      */     case 114:
/* 6195 */       nFieldType = 0;
/* 6196 */       break;
/*      */     case 115:
/* 6198 */       nFieldType = 1;
/* 6199 */       break;
/*      */     case 116:
/* 6201 */       nFieldType = 0;
/* 6202 */       break;
/*      */     case 117:
/* 6204 */       nFieldType = 1;
/* 6205 */       break;
/*      */     case 118:
/* 6207 */       nFieldType = 0;
/* 6208 */       break;
/*      */     default:
/* 6210 */       nFieldType = -1;
/*      */     }
/* 6212 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPPolSchema
 * JD-Core Version:    0.6.0
 */