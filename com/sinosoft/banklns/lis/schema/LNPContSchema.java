/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPContDB;
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
/*      */ public class LNPContSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String prtNo;
/*      */   private String mainPolNo;
/*      */   private String contType;
/*      */   private String familyType;
/*      */   private String familyID;
/*      */   private String polType;
/*      */   private String sugNo;
/*      */   private String cardFlag;
/*      */   private String manageCom;
/*      */   private String executeCom;
/*      */   private String agentCom;
/*      */   private String agentCode;
/*      */   private String agentGroup;
/*      */   private String agentCode1;
/*      */   private String agentGroup1;
/*      */   private String agentType;
/*      */   private String saleChnl;
/*      */   private String handler;
/*      */   private String password;
/*      */   private String appntNo;
/*      */   private String appntId;
/*      */   private String appntName;
/*      */   private String appntSex;
/*      */   private Date appntBirthday;
/*      */   private String appntIDType;
/*      */   private String appntIDNo;
/*      */   private String insuredNo;
/*      */   private String insuredId;
/*      */   private String insuredName;
/*      */   private String insuredSex;
/*      */   private Date insuredBirthday;
/*      */   private String insuredIDType;
/*      */   private String insuredIDNo;
/*      */   private int payIntv;
/*      */   private String payMode;
/*      */   private String payLocation;
/*      */   private String disputedFlag;
/*      */   private String outPayFlag;
/*      */   private String getPolMode;
/*      */   private String signCom;
/*      */   private Date signDate;
/*      */   private String signTime;
/*      */   private String consignNo;
/*      */   private String bankCode;
/*      */   private String bankAccNo;
/*      */   private String accName;
/*      */   private int printCount;
/*      */   private int lostTimes;
/*      */   private String lang;
/*      */   private String currency;
/*      */   private String remark;
/*      */   private int peoples;
/*      */   private double mult;
/*      */   private double prem;
/*      */   private double amnt;
/*      */   private double sumPrem;
/*      */   private double dif;
/*      */   private Date paytoDate;
/*      */   private Date firstPayDate;
/*      */   private Date cValiDate;
/*      */   private Date pSignDate;
/*      */   private Date pValiDate;
/*      */   private String inputOperator;
/*      */   private Date inputDate;
/*      */   private String inputTime;
/*      */   private String approveFlag;
/*      */   private String approveCode;
/*      */   private Date approveDate;
/*      */   private String approveTime;
/*      */   private String uWFlag;
/*      */   private String uWOperator;
/*      */   private Date uWDate;
/*      */   private String uWTime;
/*      */   private String appFlag;
/*      */   private Date polApplyDate;
/*      */   private Date getPolDate;
/*      */   private String getPolTime;
/*      */   private Date customGetPolDate;
/*      */   private String state;
/*      */   private String saleChnlDetail;
/*      */   private String proposalType;
/*      */   private String editstate;
/*      */   private Date cInValiDate;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 91;
/*      */   private static String[] PK;
/*  209 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPContSchema()
/*      */   {
/*  216 */     this.mErrors = new CErrors();
/*      */ 
/*  218 */     String[] pk = new String[1];
/*  219 */     pk[0] = "ContNo";
/*      */ 
/*  221 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  228 */     LNPContSchema cloned = (LNPContSchema)super.clone();
/*  229 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  230 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  231 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  237 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo()
/*      */   {
/*  242 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  246 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  250 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  254 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  258 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  262 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public String getPrtNo() {
/*  266 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setPrtNo(String aPrtNo) {
/*  270 */     this.prtNo = aPrtNo;
/*      */   }
/*      */ 
/*      */   public String getMainPolNo() {
/*  274 */     return this.mainPolNo;
/*      */   }
/*      */ 
/*      */   public void setMainPolNo(String aMainPolNo) {
/*  278 */     this.mainPolNo = aMainPolNo;
/*      */   }
/*      */ 
/*      */   public String getContType() {
/*  282 */     return this.contType;
/*      */   }
/*      */ 
/*      */   public void setContType(String aContType) {
/*  286 */     this.contType = aContType;
/*      */   }
/*      */ 
/*      */   public String getFamilyType() {
/*  290 */     return this.familyType;
/*      */   }
/*      */ 
/*      */   public void setFamilyType(String aFamilyType) {
/*  294 */     this.familyType = aFamilyType;
/*      */   }
/*      */ 
/*      */   public String getFamilyID() {
/*  298 */     return this.familyID;
/*      */   }
/*      */ 
/*      */   public void setFamilyID(String aFamilyID) {
/*  302 */     this.familyID = aFamilyID;
/*      */   }
/*      */ 
/*      */   public String getPolType() {
/*  306 */     return this.polType;
/*      */   }
/*      */ 
/*      */   public void setPolType(String aPolType) {
/*  310 */     this.polType = aPolType;
/*      */   }
/*      */ 
/*      */   public String getSugNo() {
/*  314 */     return this.sugNo;
/*      */   }
/*      */ 
/*      */   public void setSugNo(String aSugNo) {
/*  318 */     this.sugNo = aSugNo;
/*      */   }
/*      */ 
/*      */   public String getCardFlag() {
/*  322 */     return this.cardFlag;
/*      */   }
/*      */ 
/*      */   public void setCardFlag(String aCardFlag) {
/*  326 */     this.cardFlag = aCardFlag;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  330 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  334 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getExecuteCom() {
/*  338 */     return this.executeCom;
/*      */   }
/*      */ 
/*      */   public void setExecuteCom(String aExecuteCom) {
/*  342 */     this.executeCom = aExecuteCom;
/*      */   }
/*      */ 
/*      */   public String getAgentCom() {
/*  346 */     return this.agentCom;
/*      */   }
/*      */ 
/*      */   public void setAgentCom(String aAgentCom) {
/*  350 */     this.agentCom = aAgentCom;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  354 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  358 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getAgentGroup() {
/*  362 */     return this.agentGroup;
/*      */   }
/*      */ 
/*      */   public void setAgentGroup(String aAgentGroup) {
/*  366 */     this.agentGroup = aAgentGroup;
/*      */   }
/*      */ 
/*      */   public String getAgentCode1() {
/*  370 */     return this.agentCode1;
/*      */   }
/*      */ 
/*      */   public void setAgentCode1(String aAgentCode1) {
/*  374 */     this.agentCode1 = aAgentCode1;
/*      */   }
/*      */ 
/*      */   public String getAgentGroup1() {
/*  378 */     return this.agentGroup1;
/*      */   }
/*      */ 
/*      */   public void setAgentGroup1(String aAgentGroup1) {
/*  382 */     this.agentGroup1 = aAgentGroup1;
/*      */   }
/*      */ 
/*      */   public String getAgentType() {
/*  386 */     return this.agentType;
/*      */   }
/*      */ 
/*      */   public void setAgentType(String aAgentType) {
/*  390 */     this.agentType = aAgentType;
/*      */   }
/*      */ 
/*      */   public String getSaleChnl() {
/*  394 */     return this.saleChnl;
/*      */   }
/*      */ 
/*      */   public void setSaleChnl(String aSaleChnl) {
/*  398 */     this.saleChnl = aSaleChnl;
/*      */   }
/*      */ 
/*      */   public String getHandler() {
/*  402 */     return this.handler;
/*      */   }
/*      */ 
/*      */   public void setHandler(String aHandler) {
/*  406 */     this.handler = aHandler;
/*      */   }
/*      */ 
/*      */   public String getPassword() {
/*  410 */     return this.password;
/*      */   }
/*      */ 
/*      */   public void setPassword(String aPassword) {
/*  414 */     this.password = aPassword;
/*      */   }
/*      */ 
/*      */   public String getAppntNo() {
/*  418 */     return this.appntNo;
/*      */   }
/*      */ 
/*      */   public void setAppntNo(String aAppntNo) {
/*  422 */     this.appntNo = aAppntNo;
/*      */   }
/*      */ 
/*      */   public String getAppntId() {
/*  426 */     return this.appntId;
/*      */   }
/*      */ 
/*      */   public void setAppntId(String aAppntId) {
/*  430 */     this.appntId = aAppntId;
/*      */   }
/*      */ 
/*      */   public String getAppntName() {
/*  434 */     return this.appntName;
/*      */   }
/*      */ 
/*      */   public void setAppntName(String aAppntName) {
/*  438 */     this.appntName = aAppntName;
/*      */   }
/*      */ 
/*      */   public String getAppntSex() {
/*  442 */     return this.appntSex;
/*      */   }
/*      */ 
/*      */   public void setAppntSex(String aAppntSex) {
/*  446 */     this.appntSex = aAppntSex;
/*      */   }
/*      */ 
/*      */   public String getAppntBirthday() {
/*  450 */     if (this.appntBirthday != null) {
/*  451 */       return this.fDate.getString(this.appntBirthday);
/*      */     }
/*  453 */     return null;
/*      */   }
/*      */ 
/*      */   public void setAppntBirthday(Date aAppntBirthday) {
/*  457 */     this.appntBirthday = aAppntBirthday;
/*      */   }
/*      */ 
/*      */   public void setAppntBirthday(String aAppntBirthday) {
/*  461 */     if ((aAppntBirthday != null) && (!aAppntBirthday.equals("")))
/*      */     {
/*  463 */       this.appntBirthday = this.fDate.getDate(aAppntBirthday);
/*      */     }
/*      */     else
/*  466 */       this.appntBirthday = null;
/*      */   }
/*      */ 
/*      */   public String getAppntIDType()
/*      */   {
/*  471 */     return this.appntIDType;
/*      */   }
/*      */ 
/*      */   public void setAppntIDType(String aAppntIDType) {
/*  475 */     this.appntIDType = aAppntIDType;
/*      */   }
/*      */ 
/*      */   public String getAppntIDNo() {
/*  479 */     return this.appntIDNo;
/*      */   }
/*      */ 
/*      */   public void setAppntIDNo(String aAppntIDNo) {
/*  483 */     this.appntIDNo = aAppntIDNo;
/*      */   }
/*      */ 
/*      */   public String getInsuredNo() {
/*  487 */     return this.insuredNo;
/*      */   }
/*      */ 
/*      */   public void setInsuredNo(String aInsuredNo) {
/*  491 */     this.insuredNo = aInsuredNo;
/*      */   }
/*      */ 
/*      */   public String getInsuredId() {
/*  495 */     return this.insuredId;
/*      */   }
/*      */ 
/*      */   public void setInsuredId(String aInsuredId) {
/*  499 */     this.insuredId = aInsuredId;
/*      */   }
/*      */ 
/*      */   public String getInsuredName() {
/*  503 */     return this.insuredName;
/*      */   }
/*      */ 
/*      */   public void setInsuredName(String aInsuredName) {
/*  507 */     this.insuredName = aInsuredName;
/*      */   }
/*      */ 
/*      */   public String getInsuredSex() {
/*  511 */     return this.insuredSex;
/*      */   }
/*      */ 
/*      */   public void setInsuredSex(String aInsuredSex) {
/*  515 */     this.insuredSex = aInsuredSex;
/*      */   }
/*      */ 
/*      */   public String getInsuredBirthday() {
/*  519 */     if (this.insuredBirthday != null) {
/*  520 */       return this.fDate.getString(this.insuredBirthday);
/*      */     }
/*  522 */     return null;
/*      */   }
/*      */ 
/*      */   public void setInsuredBirthday(Date aInsuredBirthday) {
/*  526 */     this.insuredBirthday = aInsuredBirthday;
/*      */   }
/*      */ 
/*      */   public void setInsuredBirthday(String aInsuredBirthday) {
/*  530 */     if ((aInsuredBirthday != null) && (!aInsuredBirthday.equals("")))
/*      */     {
/*  532 */       this.insuredBirthday = this.fDate.getDate(aInsuredBirthday);
/*      */     }
/*      */     else
/*  535 */       this.insuredBirthday = null;
/*      */   }
/*      */ 
/*      */   public String getInsuredIDType()
/*      */   {
/*  540 */     return this.insuredIDType;
/*      */   }
/*      */ 
/*      */   public void setInsuredIDType(String aInsuredIDType) {
/*  544 */     this.insuredIDType = aInsuredIDType;
/*      */   }
/*      */ 
/*      */   public String getInsuredIDNo() {
/*  548 */     return this.insuredIDNo;
/*      */   }
/*      */ 
/*      */   public void setInsuredIDNo(String aInsuredIDNo) {
/*  552 */     this.insuredIDNo = aInsuredIDNo;
/*      */   }
/*      */ 
/*      */   public int getPayIntv() {
/*  556 */     return this.payIntv;
/*      */   }
/*      */ 
/*      */   public void setPayIntv(int aPayIntv) {
/*  560 */     this.payIntv = aPayIntv;
/*      */   }
/*      */ 
/*      */   public void setPayIntv(String aPayIntv) {
/*  564 */     if ((aPayIntv != null) && (!aPayIntv.equals("")))
/*      */     {
/*  566 */       Integer tInteger = new Integer(aPayIntv);
/*  567 */       int i = tInteger.intValue();
/*  568 */       this.payIntv = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPayMode()
/*      */   {
/*  574 */     return this.payMode;
/*      */   }
/*      */ 
/*      */   public void setPayMode(String aPayMode) {
/*  578 */     this.payMode = aPayMode;
/*      */   }
/*      */ 
/*      */   public String getPayLocation() {
/*  582 */     return this.payLocation;
/*      */   }
/*      */ 
/*      */   public void setPayLocation(String aPayLocation) {
/*  586 */     this.payLocation = aPayLocation;
/*      */   }
/*      */ 
/*      */   public String getDisputedFlag() {
/*  590 */     return this.disputedFlag;
/*      */   }
/*      */ 
/*      */   public void setDisputedFlag(String aDisputedFlag) {
/*  594 */     this.disputedFlag = aDisputedFlag;
/*      */   }
/*      */ 
/*      */   public String getOutPayFlag() {
/*  598 */     return this.outPayFlag;
/*      */   }
/*      */ 
/*      */   public void setOutPayFlag(String aOutPayFlag) {
/*  602 */     this.outPayFlag = aOutPayFlag;
/*      */   }
/*      */ 
/*      */   public String getGetPolMode() {
/*  606 */     return this.getPolMode;
/*      */   }
/*      */ 
/*      */   public void setGetPolMode(String aGetPolMode) {
/*  610 */     this.getPolMode = aGetPolMode;
/*      */   }
/*      */ 
/*      */   public String getSignCom() {
/*  614 */     return this.signCom;
/*      */   }
/*      */ 
/*      */   public void setSignCom(String aSignCom) {
/*  618 */     this.signCom = aSignCom;
/*      */   }
/*      */ 
/*      */   public String getSignDate() {
/*  622 */     if (this.signDate != null) {
/*  623 */       return this.fDate.getString(this.signDate);
/*      */     }
/*  625 */     return null;
/*      */   }
/*      */ 
/*      */   public void setSignDate(Date aSignDate) {
/*  629 */     this.signDate = aSignDate;
/*      */   }
/*      */ 
/*      */   public void setSignDate(String aSignDate) {
/*  633 */     if ((aSignDate != null) && (!aSignDate.equals("")))
/*      */     {
/*  635 */       this.signDate = this.fDate.getDate(aSignDate);
/*      */     }
/*      */     else
/*  638 */       this.signDate = null;
/*      */   }
/*      */ 
/*      */   public String getSignTime()
/*      */   {
/*  643 */     return this.signTime;
/*      */   }
/*      */ 
/*      */   public void setSignTime(String aSignTime) {
/*  647 */     this.signTime = aSignTime;
/*      */   }
/*      */ 
/*      */   public String getConsignNo() {
/*  651 */     return this.consignNo;
/*      */   }
/*      */ 
/*      */   public void setConsignNo(String aConsignNo) {
/*  655 */     this.consignNo = aConsignNo;
/*      */   }
/*      */ 
/*      */   public String getBankCode() {
/*  659 */     return this.bankCode;
/*      */   }
/*      */ 
/*      */   public void setBankCode(String aBankCode) {
/*  663 */     this.bankCode = aBankCode;
/*      */   }
/*      */ 
/*      */   public String getBankAccNo() {
/*  667 */     return this.bankAccNo;
/*      */   }
/*      */ 
/*      */   public void setBankAccNo(String aBankAccNo) {
/*  671 */     this.bankAccNo = aBankAccNo;
/*      */   }
/*      */ 
/*      */   public String getAccName() {
/*  675 */     return this.accName;
/*      */   }
/*      */ 
/*      */   public void setAccName(String aAccName) {
/*  679 */     this.accName = aAccName;
/*      */   }
/*      */ 
/*      */   public int getPrintCount() {
/*  683 */     return this.printCount;
/*      */   }
/*      */ 
/*      */   public void setPrintCount(int aPrintCount) {
/*  687 */     this.printCount = aPrintCount;
/*      */   }
/*      */ 
/*      */   public void setPrintCount(String aPrintCount) {
/*  691 */     if ((aPrintCount != null) && (!aPrintCount.equals("")))
/*      */     {
/*  693 */       Integer tInteger = new Integer(aPrintCount);
/*  694 */       int i = tInteger.intValue();
/*  695 */       this.printCount = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getLostTimes()
/*      */   {
/*  701 */     return this.lostTimes;
/*      */   }
/*      */ 
/*      */   public void setLostTimes(int aLostTimes) {
/*  705 */     this.lostTimes = aLostTimes;
/*      */   }
/*      */ 
/*      */   public void setLostTimes(String aLostTimes) {
/*  709 */     if ((aLostTimes != null) && (!aLostTimes.equals("")))
/*      */     {
/*  711 */       Integer tInteger = new Integer(aLostTimes);
/*  712 */       int i = tInteger.intValue();
/*  713 */       this.lostTimes = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getLang()
/*      */   {
/*  719 */     return this.lang;
/*      */   }
/*      */ 
/*      */   public void setLang(String aLang) {
/*  723 */     this.lang = aLang;
/*      */   }
/*      */ 
/*      */   public String getCurrency() {
/*  727 */     return this.currency;
/*      */   }
/*      */ 
/*      */   public void setCurrency(String aCurrency) {
/*  731 */     this.currency = aCurrency;
/*      */   }
/*      */ 
/*      */   public String getRemark() {
/*  735 */     return this.remark;
/*      */   }
/*      */ 
/*      */   public void setRemark(String aRemark) {
/*  739 */     this.remark = aRemark;
/*      */   }
/*      */ 
/*      */   public int getPeoples() {
/*  743 */     return this.peoples;
/*      */   }
/*      */ 
/*      */   public void setPeoples(int aPeoples) {
/*  747 */     this.peoples = aPeoples;
/*      */   }
/*      */ 
/*      */   public void setPeoples(String aPeoples) {
/*  751 */     if ((aPeoples != null) && (!aPeoples.equals("")))
/*      */     {
/*  753 */       Integer tInteger = new Integer(aPeoples);
/*  754 */       int i = tInteger.intValue();
/*  755 */       this.peoples = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMult()
/*      */   {
/*  761 */     return this.mult;
/*      */   }
/*      */ 
/*      */   public void setMult(double aMult) {
/*  765 */     this.mult = aMult;
/*      */   }
/*      */ 
/*      */   public void setMult(String aMult) {
/*  769 */     if ((aMult != null) && (!aMult.equals("")))
/*      */     {
/*  771 */       Double tDouble = new Double(aMult);
/*  772 */       double d = tDouble.doubleValue();
/*  773 */       this.mult = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getPrem()
/*      */   {
/*  779 */     return this.prem;
/*      */   }
/*      */ 
/*      */   public void setPrem(double aPrem) {
/*  783 */     this.prem = aPrem;
/*      */   }
/*      */ 
/*      */   public void setPrem(String aPrem) {
/*  787 */     if ((aPrem != null) && (!aPrem.equals("")))
/*      */     {
/*  789 */       Double tDouble = new Double(aPrem);
/*  790 */       double d = tDouble.doubleValue();
/*  791 */       this.prem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAmnt()
/*      */   {
/*  797 */     return this.amnt;
/*      */   }
/*      */ 
/*      */   public void setAmnt(double aAmnt) {
/*  801 */     this.amnt = aAmnt;
/*      */   }
/*      */ 
/*      */   public void setAmnt(String aAmnt) {
/*  805 */     if ((aAmnt != null) && (!aAmnt.equals("")))
/*      */     {
/*  807 */       Double tDouble = new Double(aAmnt);
/*  808 */       double d = tDouble.doubleValue();
/*  809 */       this.amnt = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSumPrem()
/*      */   {
/*  815 */     return this.sumPrem;
/*      */   }
/*      */ 
/*      */   public void setSumPrem(double aSumPrem) {
/*  819 */     this.sumPrem = aSumPrem;
/*      */   }
/*      */ 
/*      */   public void setSumPrem(String aSumPrem) {
/*  823 */     if ((aSumPrem != null) && (!aSumPrem.equals("")))
/*      */     {
/*  825 */       Double tDouble = new Double(aSumPrem);
/*  826 */       double d = tDouble.doubleValue();
/*  827 */       this.sumPrem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDif()
/*      */   {
/*  833 */     return this.dif;
/*      */   }
/*      */ 
/*      */   public void setDif(double aDif) {
/*  837 */     this.dif = aDif;
/*      */   }
/*      */ 
/*      */   public void setDif(String aDif) {
/*  841 */     if ((aDif != null) && (!aDif.equals("")))
/*      */     {
/*  843 */       Double tDouble = new Double(aDif);
/*  844 */       double d = tDouble.doubleValue();
/*  845 */       this.dif = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPaytoDate()
/*      */   {
/*  851 */     if (this.paytoDate != null) {
/*  852 */       return this.fDate.getString(this.paytoDate);
/*      */     }
/*  854 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPaytoDate(Date aPaytoDate) {
/*  858 */     this.paytoDate = aPaytoDate;
/*      */   }
/*      */ 
/*      */   public void setPaytoDate(String aPaytoDate) {
/*  862 */     if ((aPaytoDate != null) && (!aPaytoDate.equals("")))
/*      */     {
/*  864 */       this.paytoDate = this.fDate.getDate(aPaytoDate);
/*      */     }
/*      */     else
/*  867 */       this.paytoDate = null;
/*      */   }
/*      */ 
/*      */   public String getFirstPayDate()
/*      */   {
/*  872 */     if (this.firstPayDate != null) {
/*  873 */       return this.fDate.getString(this.firstPayDate);
/*      */     }
/*  875 */     return null;
/*      */   }
/*      */ 
/*      */   public void setFirstPayDate(Date aFirstPayDate) {
/*  879 */     this.firstPayDate = aFirstPayDate;
/*      */   }
/*      */ 
/*      */   public void setFirstPayDate(String aFirstPayDate) {
/*  883 */     if ((aFirstPayDate != null) && (!aFirstPayDate.equals("")))
/*      */     {
/*  885 */       this.firstPayDate = this.fDate.getDate(aFirstPayDate);
/*      */     }
/*      */     else
/*  888 */       this.firstPayDate = null;
/*      */   }
/*      */ 
/*      */   public String getCValiDate()
/*      */   {
/*  893 */     if (this.cValiDate != null) {
/*  894 */       return this.fDate.getString(this.cValiDate);
/*      */     }
/*  896 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCValiDate(Date aCValiDate) {
/*  900 */     this.cValiDate = aCValiDate;
/*      */   }
/*      */ 
/*      */   public void setCValiDate(String aCValiDate) {
/*  904 */     if ((aCValiDate != null) && (!aCValiDate.equals("")))
/*      */     {
/*  906 */       this.cValiDate = this.fDate.getDate(aCValiDate);
/*      */     }
/*      */     else
/*  909 */       this.cValiDate = null;
/*      */   }
/*      */ 
/*      */   public String getPSignDate()
/*      */   {
/*  914 */     if (this.pSignDate != null) {
/*  915 */       return this.fDate.getString(this.pSignDate);
/*      */     }
/*  917 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPSignDate(Date aPSignDate) {
/*  921 */     this.pSignDate = aPSignDate;
/*      */   }
/*      */ 
/*      */   public void setPSignDate(String aPSignDate) {
/*  925 */     if ((aPSignDate != null) && (!aPSignDate.equals("")))
/*      */     {
/*  927 */       this.pSignDate = this.fDate.getDate(aPSignDate);
/*      */     }
/*      */     else
/*  930 */       this.pSignDate = null;
/*      */   }
/*      */ 
/*      */   public String getPValiDate()
/*      */   {
/*  935 */     if (this.pValiDate != null) {
/*  936 */       return this.fDate.getString(this.pValiDate);
/*      */     }
/*  938 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPValiDate(Date aPValiDate) {
/*  942 */     this.pValiDate = aPValiDate;
/*      */   }
/*      */ 
/*      */   public void setPValiDate(String aPValiDate) {
/*  946 */     if ((aPValiDate != null) && (!aPValiDate.equals("")))
/*      */     {
/*  948 */       this.pValiDate = this.fDate.getDate(aPValiDate);
/*      */     }
/*      */     else
/*  951 */       this.pValiDate = null;
/*      */   }
/*      */ 
/*      */   public String getInputOperator()
/*      */   {
/*  956 */     return this.inputOperator;
/*      */   }
/*      */ 
/*      */   public void setInputOperator(String aInputOperator) {
/*  960 */     this.inputOperator = aInputOperator;
/*      */   }
/*      */ 
/*      */   public String getInputDate() {
/*  964 */     if (this.inputDate != null) {
/*  965 */       return this.fDate.getString(this.inputDate);
/*      */     }
/*  967 */     return null;
/*      */   }
/*      */ 
/*      */   public void setInputDate(Date aInputDate) {
/*  971 */     this.inputDate = aInputDate;
/*      */   }
/*      */ 
/*      */   public void setInputDate(String aInputDate) {
/*  975 */     if ((aInputDate != null) && (!aInputDate.equals("")))
/*      */     {
/*  977 */       this.inputDate = this.fDate.getDate(aInputDate);
/*      */     }
/*      */     else
/*  980 */       this.inputDate = null;
/*      */   }
/*      */ 
/*      */   public String getInputTime()
/*      */   {
/*  985 */     return this.inputTime;
/*      */   }
/*      */ 
/*      */   public void setInputTime(String aInputTime) {
/*  989 */     this.inputTime = aInputTime;
/*      */   }
/*      */ 
/*      */   public String getApproveFlag() {
/*  993 */     return this.approveFlag;
/*      */   }
/*      */ 
/*      */   public void setApproveFlag(String aApproveFlag) {
/*  997 */     this.approveFlag = aApproveFlag;
/*      */   }
/*      */ 
/*      */   public String getApproveCode() {
/* 1001 */     return this.approveCode;
/*      */   }
/*      */ 
/*      */   public void setApproveCode(String aApproveCode) {
/* 1005 */     this.approveCode = aApproveCode;
/*      */   }
/*      */ 
/*      */   public String getApproveDate() {
/* 1009 */     if (this.approveDate != null) {
/* 1010 */       return this.fDate.getString(this.approveDate);
/*      */     }
/* 1012 */     return null;
/*      */   }
/*      */ 
/*      */   public void setApproveDate(Date aApproveDate) {
/* 1016 */     this.approveDate = aApproveDate;
/*      */   }
/*      */ 
/*      */   public void setApproveDate(String aApproveDate) {
/* 1020 */     if ((aApproveDate != null) && (!aApproveDate.equals("")))
/*      */     {
/* 1022 */       this.approveDate = this.fDate.getDate(aApproveDate);
/*      */     }
/*      */     else
/* 1025 */       this.approveDate = null;
/*      */   }
/*      */ 
/*      */   public String getApproveTime()
/*      */   {
/* 1030 */     return this.approveTime;
/*      */   }
/*      */ 
/*      */   public void setApproveTime(String aApproveTime) {
/* 1034 */     this.approveTime = aApproveTime;
/*      */   }
/*      */ 
/*      */   public String getUWFlag() {
/* 1038 */     return this.uWFlag;
/*      */   }
/*      */ 
/*      */   public void setUWFlag(String aUWFlag) {
/* 1042 */     this.uWFlag = aUWFlag;
/*      */   }
/*      */ 
/*      */   public String getUWOperator() {
/* 1046 */     return this.uWOperator;
/*      */   }
/*      */ 
/*      */   public void setUWOperator(String aUWOperator) {
/* 1050 */     this.uWOperator = aUWOperator;
/*      */   }
/*      */ 
/*      */   public String getUWDate() {
/* 1054 */     if (this.uWDate != null) {
/* 1055 */       return this.fDate.getString(this.uWDate);
/*      */     }
/* 1057 */     return null;
/*      */   }
/*      */ 
/*      */   public void setUWDate(Date aUWDate) {
/* 1061 */     this.uWDate = aUWDate;
/*      */   }
/*      */ 
/*      */   public void setUWDate(String aUWDate) {
/* 1065 */     if ((aUWDate != null) && (!aUWDate.equals("")))
/*      */     {
/* 1067 */       this.uWDate = this.fDate.getDate(aUWDate);
/*      */     }
/*      */     else
/* 1070 */       this.uWDate = null;
/*      */   }
/*      */ 
/*      */   public String getUWTime()
/*      */   {
/* 1075 */     return this.uWTime;
/*      */   }
/*      */ 
/*      */   public void setUWTime(String aUWTime) {
/* 1079 */     this.uWTime = aUWTime;
/*      */   }
/*      */ 
/*      */   public String getAppFlag() {
/* 1083 */     return this.appFlag;
/*      */   }
/*      */ 
/*      */   public void setAppFlag(String aAppFlag) {
/* 1087 */     this.appFlag = aAppFlag;
/*      */   }
/*      */ 
/*      */   public String getPolApplyDate() {
/* 1091 */     if (this.polApplyDate != null) {
/* 1092 */       return this.fDate.getString(this.polApplyDate);
/*      */     }
/* 1094 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPolApplyDate(Date aPolApplyDate) {
/* 1098 */     this.polApplyDate = aPolApplyDate;
/*      */   }
/*      */ 
/*      */   public void setPolApplyDate(String aPolApplyDate) {
/* 1102 */     if ((aPolApplyDate != null) && (!aPolApplyDate.equals("")))
/*      */     {
/* 1104 */       this.polApplyDate = this.fDate.getDate(aPolApplyDate);
/*      */     }
/*      */     else
/* 1107 */       this.polApplyDate = null;
/*      */   }
/*      */ 
/*      */   public String getGetPolDate()
/*      */   {
/* 1112 */     if (this.getPolDate != null) {
/* 1113 */       return this.fDate.getString(this.getPolDate);
/*      */     }
/* 1115 */     return null;
/*      */   }
/*      */ 
/*      */   public void setGetPolDate(Date aGetPolDate) {
/* 1119 */     this.getPolDate = aGetPolDate;
/*      */   }
/*      */ 
/*      */   public void setGetPolDate(String aGetPolDate) {
/* 1123 */     if ((aGetPolDate != null) && (!aGetPolDate.equals("")))
/*      */     {
/* 1125 */       this.getPolDate = this.fDate.getDate(aGetPolDate);
/*      */     }
/*      */     else
/* 1128 */       this.getPolDate = null;
/*      */   }
/*      */ 
/*      */   public String getGetPolTime()
/*      */   {
/* 1133 */     return this.getPolTime;
/*      */   }
/*      */ 
/*      */   public void setGetPolTime(String aGetPolTime) {
/* 1137 */     this.getPolTime = aGetPolTime;
/*      */   }
/*      */ 
/*      */   public String getCustomGetPolDate() {
/* 1141 */     if (this.customGetPolDate != null) {
/* 1142 */       return this.fDate.getString(this.customGetPolDate);
/*      */     }
/* 1144 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCustomGetPolDate(Date aCustomGetPolDate) {
/* 1148 */     this.customGetPolDate = aCustomGetPolDate;
/*      */   }
/*      */ 
/*      */   public void setCustomGetPolDate(String aCustomGetPolDate) {
/* 1152 */     if ((aCustomGetPolDate != null) && (!aCustomGetPolDate.equals("")))
/*      */     {
/* 1154 */       this.customGetPolDate = this.fDate.getDate(aCustomGetPolDate);
/*      */     }
/*      */     else
/* 1157 */       this.customGetPolDate = null;
/*      */   }
/*      */ 
/*      */   public String getState()
/*      */   {
/* 1162 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/* 1166 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getSaleChnlDetail() {
/* 1170 */     return this.saleChnlDetail;
/*      */   }
/*      */ 
/*      */   public void setSaleChnlDetail(String aSaleChnlDetail) {
/* 1174 */     this.saleChnlDetail = aSaleChnlDetail;
/*      */   }
/*      */ 
/*      */   public String getProposalType() {
/* 1178 */     return this.proposalType;
/*      */   }
/*      */ 
/*      */   public void setProposalType(String aProposalType) {
/* 1182 */     this.proposalType = aProposalType;
/*      */   }
/*      */ 
/*      */   public String getEditstate() {
/* 1186 */     return this.editstate;
/*      */   }
/*      */ 
/*      */   public void setEditstate(String aEditstate) {
/* 1190 */     this.editstate = aEditstate;
/*      */   }
/*      */ 
/*      */   public String getCInValiDate() {
/* 1194 */     if (this.cInValiDate != null) {
/* 1195 */       return this.fDate.getString(this.cInValiDate);
/*      */     }
/* 1197 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCInValiDate(Date aCInValiDate) {
/* 1201 */     this.cInValiDate = aCInValiDate;
/*      */   }
/*      */ 
/*      */   public void setCInValiDate(String aCInValiDate) {
/* 1205 */     if ((aCInValiDate != null) && (!aCInValiDate.equals("")))
/*      */     {
/* 1207 */       this.cInValiDate = this.fDate.getDate(aCInValiDate);
/*      */     }
/*      */     else
/* 1210 */       this.cInValiDate = null;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/* 1215 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/* 1219 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/* 1223 */     if (this.makeDate != null) {
/* 1224 */       return this.fDate.getString(this.makeDate);
/*      */     }
/* 1226 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/* 1230 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/* 1234 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/* 1236 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/* 1239 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/* 1244 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/* 1248 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/* 1252 */     if (this.modifyDate != null) {
/* 1253 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/* 1255 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/* 1259 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/* 1263 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/* 1265 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/* 1268 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/* 1273 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/* 1277 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPContSchema aLNPContSchema)
/*      */   {
/* 1283 */     this.grpContNo = aLNPContSchema.getGrpContNo();
/* 1284 */     this.contNo = aLNPContSchema.getContNo();
/* 1285 */     this.proposalContNo = aLNPContSchema.getProposalContNo();
/* 1286 */     this.prtNo = aLNPContSchema.getPrtNo();
/* 1287 */     this.mainPolNo = aLNPContSchema.getMainPolNo();
/* 1288 */     this.contType = aLNPContSchema.getContType();
/* 1289 */     this.familyType = aLNPContSchema.getFamilyType();
/* 1290 */     this.familyID = aLNPContSchema.getFamilyID();
/* 1291 */     this.polType = aLNPContSchema.getPolType();
/* 1292 */     this.sugNo = aLNPContSchema.getSugNo();
/* 1293 */     this.cardFlag = aLNPContSchema.getCardFlag();
/* 1294 */     this.manageCom = aLNPContSchema.getManageCom();
/* 1295 */     this.executeCom = aLNPContSchema.getExecuteCom();
/* 1296 */     this.agentCom = aLNPContSchema.getAgentCom();
/* 1297 */     this.agentCode = aLNPContSchema.getAgentCode();
/* 1298 */     this.agentGroup = aLNPContSchema.getAgentGroup();
/* 1299 */     this.agentCode1 = aLNPContSchema.getAgentCode1();
/* 1300 */     this.agentGroup1 = aLNPContSchema.getAgentGroup1();
/* 1301 */     this.agentType = aLNPContSchema.getAgentType();
/* 1302 */     this.saleChnl = aLNPContSchema.getSaleChnl();
/* 1303 */     this.handler = aLNPContSchema.getHandler();
/* 1304 */     this.password = aLNPContSchema.getPassword();
/* 1305 */     this.appntNo = aLNPContSchema.getAppntNo();
/* 1306 */     this.appntId = aLNPContSchema.getAppntId();
/* 1307 */     this.appntName = aLNPContSchema.getAppntName();
/* 1308 */     this.appntSex = aLNPContSchema.getAppntSex();
/* 1309 */     this.appntBirthday = this.fDate.getDate(aLNPContSchema.getAppntBirthday());
/* 1310 */     this.appntIDType = aLNPContSchema.getAppntIDType();
/* 1311 */     this.appntIDNo = aLNPContSchema.getAppntIDNo();
/* 1312 */     this.insuredNo = aLNPContSchema.getInsuredNo();
/* 1313 */     this.insuredId = aLNPContSchema.getInsuredId();
/* 1314 */     this.insuredName = aLNPContSchema.getInsuredName();
/* 1315 */     this.insuredSex = aLNPContSchema.getInsuredSex();
/* 1316 */     this.insuredBirthday = this.fDate.getDate(aLNPContSchema.getInsuredBirthday());
/* 1317 */     this.insuredIDType = aLNPContSchema.getInsuredIDType();
/* 1318 */     this.insuredIDNo = aLNPContSchema.getInsuredIDNo();
/* 1319 */     this.payIntv = aLNPContSchema.getPayIntv();
/* 1320 */     this.payMode = aLNPContSchema.getPayMode();
/* 1321 */     this.payLocation = aLNPContSchema.getPayLocation();
/* 1322 */     this.disputedFlag = aLNPContSchema.getDisputedFlag();
/* 1323 */     this.outPayFlag = aLNPContSchema.getOutPayFlag();
/* 1324 */     this.getPolMode = aLNPContSchema.getGetPolMode();
/* 1325 */     this.signCom = aLNPContSchema.getSignCom();
/* 1326 */     this.signDate = this.fDate.getDate(aLNPContSchema.getSignDate());
/* 1327 */     this.signTime = aLNPContSchema.getSignTime();
/* 1328 */     this.consignNo = aLNPContSchema.getConsignNo();
/* 1329 */     this.bankCode = aLNPContSchema.getBankCode();
/* 1330 */     this.bankAccNo = aLNPContSchema.getBankAccNo();
/* 1331 */     this.accName = aLNPContSchema.getAccName();
/* 1332 */     this.printCount = aLNPContSchema.getPrintCount();
/* 1333 */     this.lostTimes = aLNPContSchema.getLostTimes();
/* 1334 */     this.lang = aLNPContSchema.getLang();
/* 1335 */     this.currency = aLNPContSchema.getCurrency();
/* 1336 */     this.remark = aLNPContSchema.getRemark();
/* 1337 */     this.peoples = aLNPContSchema.getPeoples();
/* 1338 */     this.mult = aLNPContSchema.getMult();
/* 1339 */     this.prem = aLNPContSchema.getPrem();
/* 1340 */     this.amnt = aLNPContSchema.getAmnt();
/* 1341 */     this.sumPrem = aLNPContSchema.getSumPrem();
/* 1342 */     this.dif = aLNPContSchema.getDif();
/* 1343 */     this.paytoDate = this.fDate.getDate(aLNPContSchema.getPaytoDate());
/* 1344 */     this.firstPayDate = this.fDate.getDate(aLNPContSchema.getFirstPayDate());
/* 1345 */     this.cValiDate = this.fDate.getDate(aLNPContSchema.getCValiDate());
/* 1346 */     this.pSignDate = this.fDate.getDate(aLNPContSchema.getPSignDate());
/* 1347 */     this.pValiDate = this.fDate.getDate(aLNPContSchema.getPValiDate());
/* 1348 */     this.inputOperator = aLNPContSchema.getInputOperator();
/* 1349 */     this.inputDate = this.fDate.getDate(aLNPContSchema.getInputDate());
/* 1350 */     this.inputTime = aLNPContSchema.getInputTime();
/* 1351 */     this.approveFlag = aLNPContSchema.getApproveFlag();
/* 1352 */     this.approveCode = aLNPContSchema.getApproveCode();
/* 1353 */     this.approveDate = this.fDate.getDate(aLNPContSchema.getApproveDate());
/* 1354 */     this.approveTime = aLNPContSchema.getApproveTime();
/* 1355 */     this.uWFlag = aLNPContSchema.getUWFlag();
/* 1356 */     this.uWOperator = aLNPContSchema.getUWOperator();
/* 1357 */     this.uWDate = this.fDate.getDate(aLNPContSchema.getUWDate());
/* 1358 */     this.uWTime = aLNPContSchema.getUWTime();
/* 1359 */     this.appFlag = aLNPContSchema.getAppFlag();
/* 1360 */     this.polApplyDate = this.fDate.getDate(aLNPContSchema.getPolApplyDate());
/* 1361 */     this.getPolDate = this.fDate.getDate(aLNPContSchema.getGetPolDate());
/* 1362 */     this.getPolTime = aLNPContSchema.getGetPolTime();
/* 1363 */     this.customGetPolDate = this.fDate.getDate(aLNPContSchema.getCustomGetPolDate());
/* 1364 */     this.state = aLNPContSchema.getState();
/* 1365 */     this.saleChnlDetail = aLNPContSchema.getSaleChnlDetail();
/* 1366 */     this.proposalType = aLNPContSchema.getProposalType();
/* 1367 */     this.editstate = aLNPContSchema.getEditstate();
/* 1368 */     this.cInValiDate = this.fDate.getDate(aLNPContSchema.getCInValiDate());
/* 1369 */     this.operator = aLNPContSchema.getOperator();
/* 1370 */     this.makeDate = this.fDate.getDate(aLNPContSchema.getMakeDate());
/* 1371 */     this.makeTime = aLNPContSchema.getMakeTime();
/* 1372 */     this.modifyDate = this.fDate.getDate(aLNPContSchema.getModifyDate());
/* 1373 */     this.modifyTime = aLNPContSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/* 1382 */       if (rs.getString("GrpContNo") == null)
/* 1383 */         this.grpContNo = null;
/*      */       else {
/* 1385 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/* 1387 */       if (rs.getString("ContNo") == null)
/* 1388 */         this.contNo = null;
/*      */       else {
/* 1390 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/* 1392 */       if (rs.getString("ProposalContNo") == null)
/* 1393 */         this.proposalContNo = null;
/*      */       else {
/* 1395 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/* 1397 */       if (rs.getString("PrtNo") == null)
/* 1398 */         this.prtNo = null;
/*      */       else {
/* 1400 */         this.prtNo = rs.getString("PrtNo").trim();
/*      */       }
/* 1402 */       if (rs.getString("MainPolNo") == null)
/* 1403 */         this.mainPolNo = null;
/*      */       else {
/* 1405 */         this.mainPolNo = rs.getString("MainPolNo").trim();
/*      */       }
/* 1407 */       if (rs.getString("ContType") == null)
/* 1408 */         this.contType = null;
/*      */       else {
/* 1410 */         this.contType = rs.getString("ContType").trim();
/*      */       }
/* 1412 */       if (rs.getString("FamilyType") == null)
/* 1413 */         this.familyType = null;
/*      */       else {
/* 1415 */         this.familyType = rs.getString("FamilyType").trim();
/*      */       }
/* 1417 */       if (rs.getString("FamilyID") == null)
/* 1418 */         this.familyID = null;
/*      */       else {
/* 1420 */         this.familyID = rs.getString("FamilyID").trim();
/*      */       }
/* 1422 */       if (rs.getString("PolType") == null)
/* 1423 */         this.polType = null;
/*      */       else {
/* 1425 */         this.polType = rs.getString("PolType").trim();
/*      */       }
/* 1427 */       if (rs.getString("SugNo") == null)
/* 1428 */         this.sugNo = null;
/*      */       else {
/* 1430 */         this.sugNo = rs.getString("SugNo").trim();
/*      */       }
/* 1432 */       if (rs.getString("CardFlag") == null)
/* 1433 */         this.cardFlag = null;
/*      */       else {
/* 1435 */         this.cardFlag = rs.getString("CardFlag").trim();
/*      */       }
/* 1437 */       if (rs.getString("ManageCom") == null)
/* 1438 */         this.manageCom = null;
/*      */       else {
/* 1440 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/* 1442 */       if (rs.getString("ExecuteCom") == null)
/* 1443 */         this.executeCom = null;
/*      */       else {
/* 1445 */         this.executeCom = rs.getString("ExecuteCom").trim();
/*      */       }
/* 1447 */       if (rs.getString("AgentCom") == null)
/* 1448 */         this.agentCom = null;
/*      */       else {
/* 1450 */         this.agentCom = rs.getString("AgentCom").trim();
/*      */       }
/* 1452 */       if (rs.getString("AgentCode") == null)
/* 1453 */         this.agentCode = null;
/*      */       else {
/* 1455 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/* 1457 */       if (rs.getString("AgentGroup") == null)
/* 1458 */         this.agentGroup = null;
/*      */       else {
/* 1460 */         this.agentGroup = rs.getString("AgentGroup").trim();
/*      */       }
/* 1462 */       if (rs.getString("AgentCode1") == null)
/* 1463 */         this.agentCode1 = null;
/*      */       else {
/* 1465 */         this.agentCode1 = rs.getString("AgentCode1").trim();
/*      */       }
/* 1467 */       if (rs.getString("AgentGroup1") == null)
/* 1468 */         this.agentGroup1 = null;
/*      */       else {
/* 1470 */         this.agentGroup1 = rs.getString("AgentGroup1").trim();
/*      */       }
/* 1472 */       if (rs.getString("AgentType") == null)
/* 1473 */         this.agentType = null;
/*      */       else {
/* 1475 */         this.agentType = rs.getString("AgentType").trim();
/*      */       }
/* 1477 */       if (rs.getString("SaleChnl") == null)
/* 1478 */         this.saleChnl = null;
/*      */       else {
/* 1480 */         this.saleChnl = rs.getString("SaleChnl").trim();
/*      */       }
/* 1482 */       if (rs.getString("Handler") == null)
/* 1483 */         this.handler = null;
/*      */       else {
/* 1485 */         this.handler = rs.getString("Handler").trim();
/*      */       }
/* 1487 */       if (rs.getString("Password") == null)
/* 1488 */         this.password = null;
/*      */       else {
/* 1490 */         this.password = rs.getString("Password").trim();
/*      */       }
/* 1492 */       if (rs.getString("AppntNo") == null)
/* 1493 */         this.appntNo = null;
/*      */       else {
/* 1495 */         this.appntNo = rs.getString("AppntNo").trim();
/*      */       }
/* 1497 */       if (rs.getString("AppntId") == null)
/* 1498 */         this.appntId = null;
/*      */       else {
/* 1500 */         this.appntId = rs.getString("AppntId").trim();
/*      */       }
/* 1502 */       if (rs.getString("AppntName") == null)
/* 1503 */         this.appntName = null;
/*      */       else {
/* 1505 */         this.appntName = rs.getString("AppntName").trim();
/*      */       }
/* 1507 */       if (rs.getString("AppntSex") == null)
/* 1508 */         this.appntSex = null;
/*      */       else {
/* 1510 */         this.appntSex = rs.getString("AppntSex").trim();
/*      */       }
/* 1512 */       this.appntBirthday = rs.getDate("AppntBirthday");
/* 1513 */       if (rs.getString("AppntIDType") == null)
/* 1514 */         this.appntIDType = null;
/*      */       else {
/* 1516 */         this.appntIDType = rs.getString("AppntIDType").trim();
/*      */       }
/* 1518 */       if (rs.getString("AppntIDNo") == null)
/* 1519 */         this.appntIDNo = null;
/*      */       else {
/* 1521 */         this.appntIDNo = rs.getString("AppntIDNo").trim();
/*      */       }
/* 1523 */       if (rs.getString("InsuredNo") == null)
/* 1524 */         this.insuredNo = null;
/*      */       else {
/* 1526 */         this.insuredNo = rs.getString("InsuredNo").trim();
/*      */       }
/* 1528 */       if (rs.getString("InsuredId") == null)
/* 1529 */         this.insuredId = null;
/*      */       else {
/* 1531 */         this.insuredId = rs.getString("InsuredId").trim();
/*      */       }
/* 1533 */       if (rs.getString("InsuredName") == null)
/* 1534 */         this.insuredName = null;
/*      */       else {
/* 1536 */         this.insuredName = rs.getString("InsuredName").trim();
/*      */       }
/* 1538 */       if (rs.getString("InsuredSex") == null)
/* 1539 */         this.insuredSex = null;
/*      */       else {
/* 1541 */         this.insuredSex = rs.getString("InsuredSex").trim();
/*      */       }
/* 1543 */       this.insuredBirthday = rs.getDate("InsuredBirthday");
/* 1544 */       if (rs.getString("InsuredIDType") == null)
/* 1545 */         this.insuredIDType = null;
/*      */       else {
/* 1547 */         this.insuredIDType = rs.getString("InsuredIDType").trim();
/*      */       }
/* 1549 */       if (rs.getString("InsuredIDNo") == null)
/* 1550 */         this.insuredIDNo = null;
/*      */       else {
/* 1552 */         this.insuredIDNo = rs.getString("InsuredIDNo").trim();
/*      */       }
/* 1554 */       this.payIntv = rs.getInt("PayIntv");
/* 1555 */       if (rs.getString("PayMode") == null)
/* 1556 */         this.payMode = null;
/*      */       else {
/* 1558 */         this.payMode = rs.getString("PayMode").trim();
/*      */       }
/* 1560 */       if (rs.getString("PayLocation") == null)
/* 1561 */         this.payLocation = null;
/*      */       else {
/* 1563 */         this.payLocation = rs.getString("PayLocation").trim();
/*      */       }
/* 1565 */       if (rs.getString("DisputedFlag") == null)
/* 1566 */         this.disputedFlag = null;
/*      */       else {
/* 1568 */         this.disputedFlag = rs.getString("DisputedFlag").trim();
/*      */       }
/* 1570 */       if (rs.getString("OutPayFlag") == null)
/* 1571 */         this.outPayFlag = null;
/*      */       else {
/* 1573 */         this.outPayFlag = rs.getString("OutPayFlag").trim();
/*      */       }
/* 1575 */       if (rs.getString("GetPolMode") == null)
/* 1576 */         this.getPolMode = null;
/*      */       else {
/* 1578 */         this.getPolMode = rs.getString("GetPolMode").trim();
/*      */       }
/* 1580 */       if (rs.getString("SignCom") == null)
/* 1581 */         this.signCom = null;
/*      */       else {
/* 1583 */         this.signCom = rs.getString("SignCom").trim();
/*      */       }
/* 1585 */       this.signDate = rs.getDate("SignDate");
/* 1586 */       if (rs.getString("SignTime") == null)
/* 1587 */         this.signTime = null;
/*      */       else {
/* 1589 */         this.signTime = rs.getString("SignTime").trim();
/*      */       }
/* 1591 */       if (rs.getString("ConsignNo") == null)
/* 1592 */         this.consignNo = null;
/*      */       else {
/* 1594 */         this.consignNo = rs.getString("ConsignNo").trim();
/*      */       }
/* 1596 */       if (rs.getString("BankCode") == null)
/* 1597 */         this.bankCode = null;
/*      */       else {
/* 1599 */         this.bankCode = rs.getString("BankCode").trim();
/*      */       }
/* 1601 */       if (rs.getString("BankAccNo") == null)
/* 1602 */         this.bankAccNo = null;
/*      */       else {
/* 1604 */         this.bankAccNo = rs.getString("BankAccNo").trim();
/*      */       }
/* 1606 */       if (rs.getString("AccName") == null)
/* 1607 */         this.accName = null;
/*      */       else {
/* 1609 */         this.accName = rs.getString("AccName").trim();
/*      */       }
/* 1611 */       this.printCount = rs.getInt("PrintCount");
/* 1612 */       this.lostTimes = rs.getInt("LostTimes");
/* 1613 */       if (rs.getString("Lang") == null)
/* 1614 */         this.lang = null;
/*      */       else {
/* 1616 */         this.lang = rs.getString("Lang").trim();
/*      */       }
/* 1618 */       if (rs.getString("Currency") == null)
/* 1619 */         this.currency = null;
/*      */       else {
/* 1621 */         this.currency = rs.getString("Currency").trim();
/*      */       }
/* 1623 */       if (rs.getString("Remark") == null)
/* 1624 */         this.remark = null;
/*      */       else {
/* 1626 */         this.remark = rs.getString("Remark").trim();
/*      */       }
/* 1628 */       this.peoples = rs.getInt("Peoples");
/* 1629 */       this.mult = rs.getDouble("Mult");
/* 1630 */       this.prem = rs.getDouble("Prem");
/* 1631 */       this.amnt = rs.getDouble("Amnt");
/* 1632 */       this.sumPrem = rs.getDouble("SumPrem");
/* 1633 */       this.dif = rs.getDouble("Dif");
/* 1634 */       this.paytoDate = rs.getDate("PaytoDate");
/* 1635 */       this.firstPayDate = rs.getDate("FirstPayDate");
/* 1636 */       this.cValiDate = rs.getDate("CValiDate");
/* 1637 */       this.pSignDate = rs.getDate("PSignDate");
/* 1638 */       this.pValiDate = rs.getDate("PValiDate");
/* 1639 */       if (rs.getString("InputOperator") == null)
/* 1640 */         this.inputOperator = null;
/*      */       else {
/* 1642 */         this.inputOperator = rs.getString("InputOperator").trim();
/*      */       }
/* 1644 */       this.inputDate = rs.getDate("InputDate");
/* 1645 */       if (rs.getString("InputTime") == null)
/* 1646 */         this.inputTime = null;
/*      */       else {
/* 1648 */         this.inputTime = rs.getString("InputTime").trim();
/*      */       }
/* 1650 */       if (rs.getString("ApproveFlag") == null)
/* 1651 */         this.approveFlag = null;
/*      */       else {
/* 1653 */         this.approveFlag = rs.getString("ApproveFlag").trim();
/*      */       }
/* 1655 */       if (rs.getString("ApproveCode") == null)
/* 1656 */         this.approveCode = null;
/*      */       else {
/* 1658 */         this.approveCode = rs.getString("ApproveCode").trim();
/*      */       }
/* 1660 */       this.approveDate = rs.getDate("ApproveDate");
/* 1661 */       if (rs.getString("ApproveTime") == null)
/* 1662 */         this.approveTime = null;
/*      */       else {
/* 1664 */         this.approveTime = rs.getString("ApproveTime").trim();
/*      */       }
/* 1666 */       if (rs.getString("UWFlag") == null)
/* 1667 */         this.uWFlag = null;
/*      */       else {
/* 1669 */         this.uWFlag = rs.getString("UWFlag").trim();
/*      */       }
/* 1671 */       if (rs.getString("UWOperator") == null)
/* 1672 */         this.uWOperator = null;
/*      */       else {
/* 1674 */         this.uWOperator = rs.getString("UWOperator").trim();
/*      */       }
/* 1676 */       this.uWDate = rs.getDate("UWDate");
/* 1677 */       if (rs.getString("UWTime") == null)
/* 1678 */         this.uWTime = null;
/*      */       else {
/* 1680 */         this.uWTime = rs.getString("UWTime").trim();
/*      */       }
/* 1682 */       if (rs.getString("AppFlag") == null)
/* 1683 */         this.appFlag = null;
/*      */       else {
/* 1685 */         this.appFlag = rs.getString("AppFlag").trim();
/*      */       }
/* 1687 */       this.polApplyDate = rs.getDate("PolApplyDate");
/* 1688 */       this.getPolDate = rs.getDate("GetPolDate");
/* 1689 */       if (rs.getString("GetPolTime") == null)
/* 1690 */         this.getPolTime = null;
/*      */       else {
/* 1692 */         this.getPolTime = rs.getString("GetPolTime").trim();
/*      */       }
/* 1694 */       this.customGetPolDate = rs.getDate("CustomGetPolDate");
/* 1695 */       if (rs.getString("State") == null)
/* 1696 */         this.state = null;
/*      */       else {
/* 1698 */         this.state = rs.getString("State").trim();
/*      */       }
/* 1700 */       if (rs.getString("SaleChnlDetail") == null)
/* 1701 */         this.saleChnlDetail = null;
/*      */       else {
/* 1703 */         this.saleChnlDetail = rs.getString("SaleChnlDetail").trim();
/*      */       }
/* 1705 */       if (rs.getString("ProposalType") == null)
/* 1706 */         this.proposalType = null;
/*      */       else {
/* 1708 */         this.proposalType = rs.getString("ProposalType").trim();
/*      */       }
/* 1710 */       if (rs.getString("Editstate") == null)
/* 1711 */         this.editstate = null;
/*      */       else {
/* 1713 */         this.editstate = rs.getString("Editstate").trim();
/*      */       }
/* 1715 */       this.cInValiDate = rs.getDate("CInValiDate");
/* 1716 */       if (rs.getString("Operator") == null)
/* 1717 */         this.operator = null;
/*      */       else {
/* 1719 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/* 1721 */       this.makeDate = rs.getDate("MakeDate");
/* 1722 */       if (rs.getString("MakeTime") == null)
/* 1723 */         this.makeTime = null;
/*      */       else {
/* 1725 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/* 1727 */       this.modifyDate = rs.getDate("ModifyDate");
/* 1728 */       if (rs.getString("ModifyTime") == null)
/* 1729 */         this.modifyTime = null;
/*      */       else {
/* 1731 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1736 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPCont\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/* 1738 */       CError tError = new CError();
/* 1739 */       tError.moduleName = "LNPContSchema";
/* 1740 */       tError.functionName = "setSchema";
/* 1741 */       tError.errorMessage = sqle.toString();
/* 1742 */       this.mErrors.addOneError(tError);
/* 1743 */       return false;
/*      */     }
/* 1745 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPContSchema getSchema()
/*      */   {
/* 1750 */     LNPContSchema aLNPContSchema = new LNPContSchema();
/* 1751 */     aLNPContSchema.setSchema(this);
/* 1752 */     return aLNPContSchema;
/*      */   }
/*      */ 
/*      */   public LNPContDB getDB()
/*      */   {
/* 1757 */     LNPContDB aDBOper = new LNPContDB();
/* 1758 */     aDBOper.setSchema(this);
/* 1759 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1766 */     StringBuffer strReturn = new StringBuffer(256);
/* 1767 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/* 1768 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/* 1769 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/* 1770 */     strReturn.append(StrTool.cTrim(this.prtNo)); strReturn.append("|");
/* 1771 */     strReturn.append(StrTool.cTrim(this.mainPolNo)); strReturn.append("|");
/* 1772 */     strReturn.append(StrTool.cTrim(this.contType)); strReturn.append("|");
/* 1773 */     strReturn.append(StrTool.cTrim(this.familyType)); strReturn.append("|");
/* 1774 */     strReturn.append(StrTool.cTrim(this.familyID)); strReturn.append("|");
/* 1775 */     strReturn.append(StrTool.cTrim(this.polType)); strReturn.append("|");
/* 1776 */     strReturn.append(StrTool.cTrim(this.sugNo)); strReturn.append("|");
/* 1777 */     strReturn.append(StrTool.cTrim(this.cardFlag)); strReturn.append("|");
/* 1778 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/* 1779 */     strReturn.append(StrTool.cTrim(this.executeCom)); strReturn.append("|");
/* 1780 */     strReturn.append(StrTool.cTrim(this.agentCom)); strReturn.append("|");
/* 1781 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/* 1782 */     strReturn.append(StrTool.cTrim(this.agentGroup)); strReturn.append("|");
/* 1783 */     strReturn.append(StrTool.cTrim(this.agentCode1)); strReturn.append("|");
/* 1784 */     strReturn.append(StrTool.cTrim(this.agentGroup1)); strReturn.append("|");
/* 1785 */     strReturn.append(StrTool.cTrim(this.agentType)); strReturn.append("|");
/* 1786 */     strReturn.append(StrTool.cTrim(this.saleChnl)); strReturn.append("|");
/* 1787 */     strReturn.append(StrTool.cTrim(this.handler)); strReturn.append("|");
/* 1788 */     strReturn.append(StrTool.cTrim(this.password)); strReturn.append("|");
/* 1789 */     strReturn.append(StrTool.cTrim(this.appntNo)); strReturn.append("|");
/* 1790 */     strReturn.append(StrTool.cTrim(this.appntId)); strReturn.append("|");
/* 1791 */     strReturn.append(StrTool.cTrim(this.appntName)); strReturn.append("|");
/* 1792 */     strReturn.append(StrTool.cTrim(this.appntSex)); strReturn.append("|");
/* 1793 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.appntBirthday))); strReturn.append("|");
/* 1794 */     strReturn.append(StrTool.cTrim(this.appntIDType)); strReturn.append("|");
/* 1795 */     strReturn.append(StrTool.cTrim(this.appntIDNo)); strReturn.append("|");
/* 1796 */     strReturn.append(StrTool.cTrim(this.insuredNo)); strReturn.append("|");
/* 1797 */     strReturn.append(StrTool.cTrim(this.insuredId)); strReturn.append("|");
/* 1798 */     strReturn.append(StrTool.cTrim(this.insuredName)); strReturn.append("|");
/* 1799 */     strReturn.append(StrTool.cTrim(this.insuredSex)); strReturn.append("|");
/* 1800 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.insuredBirthday))); strReturn.append("|");
/* 1801 */     strReturn.append(StrTool.cTrim(this.insuredIDType)); strReturn.append("|");
/* 1802 */     strReturn.append(StrTool.cTrim(this.insuredIDNo)); strReturn.append("|");
/* 1803 */     strReturn.append(ChgData.chgData(this.payIntv)); strReturn.append("|");
/* 1804 */     strReturn.append(StrTool.cTrim(this.payMode)); strReturn.append("|");
/* 1805 */     strReturn.append(StrTool.cTrim(this.payLocation)); strReturn.append("|");
/* 1806 */     strReturn.append(StrTool.cTrim(this.disputedFlag)); strReturn.append("|");
/* 1807 */     strReturn.append(StrTool.cTrim(this.outPayFlag)); strReturn.append("|");
/* 1808 */     strReturn.append(StrTool.cTrim(this.getPolMode)); strReturn.append("|");
/* 1809 */     strReturn.append(StrTool.cTrim(this.signCom)); strReturn.append("|");
/* 1810 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.signDate))); strReturn.append("|");
/* 1811 */     strReturn.append(StrTool.cTrim(this.signTime)); strReturn.append("|");
/* 1812 */     strReturn.append(StrTool.cTrim(this.consignNo)); strReturn.append("|");
/* 1813 */     strReturn.append(StrTool.cTrim(this.bankCode)); strReturn.append("|");
/* 1814 */     strReturn.append(StrTool.cTrim(this.bankAccNo)); strReturn.append("|");
/* 1815 */     strReturn.append(StrTool.cTrim(this.accName)); strReturn.append("|");
/* 1816 */     strReturn.append(ChgData.chgData(this.printCount)); strReturn.append("|");
/* 1817 */     strReturn.append(ChgData.chgData(this.lostTimes)); strReturn.append("|");
/* 1818 */     strReturn.append(StrTool.cTrim(this.lang)); strReturn.append("|");
/* 1819 */     strReturn.append(StrTool.cTrim(this.currency)); strReturn.append("|");
/* 1820 */     strReturn.append(StrTool.cTrim(this.remark)); strReturn.append("|");
/* 1821 */     strReturn.append(ChgData.chgData(this.peoples)); strReturn.append("|");
/* 1822 */     strReturn.append(ChgData.chgData(this.mult)); strReturn.append("|");
/* 1823 */     strReturn.append(ChgData.chgData(this.prem)); strReturn.append("|");
/* 1824 */     strReturn.append(ChgData.chgData(this.amnt)); strReturn.append("|");
/* 1825 */     strReturn.append(ChgData.chgData(this.sumPrem)); strReturn.append("|");
/* 1826 */     strReturn.append(ChgData.chgData(this.dif)); strReturn.append("|");
/* 1827 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.paytoDate))); strReturn.append("|");
/* 1828 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.firstPayDate))); strReturn.append("|");
/* 1829 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.cValiDate))); strReturn.append("|");
/* 1830 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.pSignDate))); strReturn.append("|");
/* 1831 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.pValiDate))); strReturn.append("|");
/* 1832 */     strReturn.append(StrTool.cTrim(this.inputOperator)); strReturn.append("|");
/* 1833 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.inputDate))); strReturn.append("|");
/* 1834 */     strReturn.append(StrTool.cTrim(this.inputTime)); strReturn.append("|");
/* 1835 */     strReturn.append(StrTool.cTrim(this.approveFlag)); strReturn.append("|");
/* 1836 */     strReturn.append(StrTool.cTrim(this.approveCode)); strReturn.append("|");
/* 1837 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.approveDate))); strReturn.append("|");
/* 1838 */     strReturn.append(StrTool.cTrim(this.approveTime)); strReturn.append("|");
/* 1839 */     strReturn.append(StrTool.cTrim(this.uWFlag)); strReturn.append("|");
/* 1840 */     strReturn.append(StrTool.cTrim(this.uWOperator)); strReturn.append("|");
/* 1841 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.uWDate))); strReturn.append("|");
/* 1842 */     strReturn.append(StrTool.cTrim(this.uWTime)); strReturn.append("|");
/* 1843 */     strReturn.append(StrTool.cTrim(this.appFlag)); strReturn.append("|");
/* 1844 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.polApplyDate))); strReturn.append("|");
/* 1845 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.getPolDate))); strReturn.append("|");
/* 1846 */     strReturn.append(StrTool.cTrim(this.getPolTime)); strReturn.append("|");
/* 1847 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.customGetPolDate))); strReturn.append("|");
/* 1848 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/* 1849 */     strReturn.append(StrTool.cTrim(this.saleChnlDetail)); strReturn.append("|");
/* 1850 */     strReturn.append(StrTool.cTrim(this.proposalType)); strReturn.append("|");
/* 1851 */     strReturn.append(StrTool.cTrim(this.editstate)); strReturn.append("|");
/* 1852 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.cInValiDate))); strReturn.append("|");
/* 1853 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 1854 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 1855 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 1856 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 1857 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/* 1858 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1866 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1867 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1868 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1869 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1870 */       this.mainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1871 */       this.contType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1872 */       this.familyType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1873 */       this.familyID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1874 */       this.polType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1875 */       this.sugNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1876 */       this.cardFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1877 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1878 */       this.executeCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1879 */       this.agentCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1880 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1881 */       this.agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1882 */       this.agentCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1883 */       this.agentGroup1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1884 */       this.agentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1885 */       this.saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 1886 */       this.handler = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1887 */       this.password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 1888 */       this.appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 1889 */       this.appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1890 */       this.appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1891 */       this.appntSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1892 */       this.appntBirthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
/* 1893 */       this.appntIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1894 */       this.appntIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 1895 */       this.insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1896 */       this.insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/* 1897 */       this.insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 1898 */       this.insuredSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 1899 */       this.insuredBirthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|"));
/* 1900 */       this.insuredIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 1901 */       this.insuredIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
/* 1902 */       this.payIntv = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 37, "|"))).intValue();
/* 1903 */       this.payMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/* 1904 */       this.payLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/* 1905 */       this.disputedFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1906 */       this.outPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1907 */       this.getPolMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1908 */       this.signCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 1909 */       this.signDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|"));
/* 1910 */       this.signTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 1911 */       this.consignNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 1912 */       this.bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 1913 */       this.bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 1914 */       this.accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/* 1915 */       this.printCount = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 50, "|"))).intValue();
/* 1916 */       this.lostTimes = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 51, "|"))).intValue();
/* 1917 */       this.lang = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
/* 1918 */       this.currency = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
/* 1919 */       this.remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
/* 1920 */       this.peoples = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 55, "|"))).intValue();
/* 1921 */       this.mult = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 56, "|"))).doubleValue();
/* 1922 */       this.prem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|"))).doubleValue();
/* 1923 */       this.amnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|"))).doubleValue();
/* 1924 */       this.sumPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|"))).doubleValue();
/* 1925 */       this.dif = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|"))).doubleValue();
/* 1926 */       this.paytoDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 61, "|"));
/* 1927 */       this.firstPayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 62, "|"));
/* 1928 */       this.cValiDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 63, "|"));
/* 1929 */       this.pSignDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 64, "|"));
/* 1930 */       this.pValiDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 65, "|"));
/* 1931 */       this.inputOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 66, "|");
/* 1932 */       this.inputDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 67, "|"));
/* 1933 */       this.inputTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 68, "|");
/* 1934 */       this.approveFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 69, "|");
/* 1935 */       this.approveCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 70, "|");
/* 1936 */       this.approveDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 71, "|"));
/* 1937 */       this.approveTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 72, "|");
/* 1938 */       this.uWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 73, "|");
/* 1939 */       this.uWOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 74, "|");
/* 1940 */       this.uWDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 75, "|"));
/* 1941 */       this.uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 76, "|");
/* 1942 */       this.appFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 77, "|");
/* 1943 */       this.polApplyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 78, "|"));
/* 1944 */       this.getPolDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 79, "|"));
/* 1945 */       this.getPolTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 80, "|");
/* 1946 */       this.customGetPolDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 81, "|"));
/* 1947 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 82, "|");
/* 1948 */       this.saleChnlDetail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 83, "|");
/* 1949 */       this.proposalType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 84, "|");
/* 1950 */       this.editstate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 85, "|");
/* 1951 */       this.cInValiDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 86, "|"));
/* 1952 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 87, "|");
/* 1953 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 88, "|"));
/* 1954 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 89, "|");
/* 1955 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 90, "|"));
/* 1956 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 91, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1961 */       CError tError = new CError();
/* 1962 */       tError.moduleName = "LNPContSchema";
/* 1963 */       tError.functionName = "decode";
/* 1964 */       tError.errorMessage = ex.toString();
/* 1965 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1967 */       return false;
/*      */     }
/* 1969 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1975 */     String strReturn = "";
/* 1976 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 1978 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/* 1980 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 1982 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/* 1984 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 1986 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/* 1988 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/* 1990 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/* 1992 */     if (FCode.equalsIgnoreCase("mainPolNo"))
/*      */     {
/* 1994 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mainPolNo));
/*      */     }
/* 1996 */     if (FCode.equalsIgnoreCase("contType"))
/*      */     {
/* 1998 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contType));
/*      */     }
/* 2000 */     if (FCode.equalsIgnoreCase("familyType"))
/*      */     {
/* 2002 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.familyType));
/*      */     }
/* 2004 */     if (FCode.equalsIgnoreCase("familyID"))
/*      */     {
/* 2006 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.familyID));
/*      */     }
/* 2008 */     if (FCode.equalsIgnoreCase("polType"))
/*      */     {
/* 2010 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polType));
/*      */     }
/* 2012 */     if (FCode.equalsIgnoreCase("sugNo"))
/*      */     {
/* 2014 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sugNo));
/*      */     }
/* 2016 */     if (FCode.equalsIgnoreCase("cardFlag"))
/*      */     {
/* 2018 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.cardFlag));
/*      */     }
/* 2020 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 2022 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 2024 */     if (FCode.equalsIgnoreCase("executeCom"))
/*      */     {
/* 2026 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.executeCom));
/*      */     }
/* 2028 */     if (FCode.equalsIgnoreCase("agentCom"))
/*      */     {
/* 2030 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCom));
/*      */     }
/* 2032 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 2034 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/* 2036 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*      */     {
/* 2038 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup));
/*      */     }
/* 2040 */     if (FCode.equalsIgnoreCase("agentCode1"))
/*      */     {
/* 2042 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode1));
/*      */     }
/* 2044 */     if (FCode.equalsIgnoreCase("agentGroup1"))
/*      */     {
/* 2046 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup1));
/*      */     }
/* 2048 */     if (FCode.equalsIgnoreCase("agentType"))
/*      */     {
/* 2050 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentType));
/*      */     }
/* 2052 */     if (FCode.equalsIgnoreCase("saleChnl"))
/*      */     {
/* 2054 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.saleChnl));
/*      */     }
/* 2056 */     if (FCode.equalsIgnoreCase("handler"))
/*      */     {
/* 2058 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.handler));
/*      */     }
/* 2060 */     if (FCode.equalsIgnoreCase("password"))
/*      */     {
/* 2062 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.password));
/*      */     }
/* 2064 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/* 2066 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntNo));
/*      */     }
/* 2068 */     if (FCode.equalsIgnoreCase("appntId"))
/*      */     {
/* 2070 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntId));
/*      */     }
/* 2072 */     if (FCode.equalsIgnoreCase("appntName"))
/*      */     {
/* 2074 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntName));
/*      */     }
/* 2076 */     if (FCode.equalsIgnoreCase("appntSex"))
/*      */     {
/* 2078 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntSex));
/*      */     }
/* 2080 */     if (FCode.equalsIgnoreCase("appntBirthday"))
/*      */     {
/* 2082 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getAppntBirthday()));
/*      */     }
/* 2084 */     if (FCode.equalsIgnoreCase("appntIDType"))
/*      */     {
/* 2086 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntIDType));
/*      */     }
/* 2088 */     if (FCode.equalsIgnoreCase("appntIDNo"))
/*      */     {
/* 2090 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntIDNo));
/*      */     }
/* 2092 */     if (FCode.equalsIgnoreCase("insuredNo"))
/*      */     {
/* 2094 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredNo));
/*      */     }
/* 2096 */     if (FCode.equalsIgnoreCase("insuredId"))
/*      */     {
/* 2098 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredId));
/*      */     }
/* 2100 */     if (FCode.equalsIgnoreCase("insuredName"))
/*      */     {
/* 2102 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredName));
/*      */     }
/* 2104 */     if (FCode.equalsIgnoreCase("insuredSex"))
/*      */     {
/* 2106 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredSex));
/*      */     }
/* 2108 */     if (FCode.equalsIgnoreCase("insuredBirthday"))
/*      */     {
/* 2110 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getInsuredBirthday()));
/*      */     }
/* 2112 */     if (FCode.equalsIgnoreCase("insuredIDType"))
/*      */     {
/* 2114 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredIDType));
/*      */     }
/* 2116 */     if (FCode.equalsIgnoreCase("insuredIDNo"))
/*      */     {
/* 2118 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredIDNo));
/*      */     }
/* 2120 */     if (FCode.equalsIgnoreCase("payIntv"))
/*      */     {
/* 2122 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payIntv));
/*      */     }
/* 2124 */     if (FCode.equalsIgnoreCase("payMode"))
/*      */     {
/* 2126 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payMode));
/*      */     }
/* 2128 */     if (FCode.equalsIgnoreCase("payLocation"))
/*      */     {
/* 2130 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payLocation));
/*      */     }
/* 2132 */     if (FCode.equalsIgnoreCase("disputedFlag"))
/*      */     {
/* 2134 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.disputedFlag));
/*      */     }
/* 2136 */     if (FCode.equalsIgnoreCase("outPayFlag"))
/*      */     {
/* 2138 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.outPayFlag));
/*      */     }
/* 2140 */     if (FCode.equalsIgnoreCase("getPolMode"))
/*      */     {
/* 2142 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getPolMode));
/*      */     }
/* 2144 */     if (FCode.equalsIgnoreCase("signCom"))
/*      */     {
/* 2146 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signCom));
/*      */     }
/* 2148 */     if (FCode.equalsIgnoreCase("signDate"))
/*      */     {
/* 2150 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
/*      */     }
/* 2152 */     if (FCode.equalsIgnoreCase("signTime"))
/*      */     {
/* 2154 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signTime));
/*      */     }
/* 2156 */     if (FCode.equalsIgnoreCase("consignNo"))
/*      */     {
/* 2158 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.consignNo));
/*      */     }
/* 2160 */     if (FCode.equalsIgnoreCase("bankCode"))
/*      */     {
/* 2162 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankCode));
/*      */     }
/* 2164 */     if (FCode.equalsIgnoreCase("bankAccNo"))
/*      */     {
/* 2166 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankAccNo));
/*      */     }
/* 2168 */     if (FCode.equalsIgnoreCase("accName"))
/*      */     {
/* 2170 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.accName));
/*      */     }
/* 2172 */     if (FCode.equalsIgnoreCase("printCount"))
/*      */     {
/* 2174 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.printCount));
/*      */     }
/* 2176 */     if (FCode.equalsIgnoreCase("lostTimes"))
/*      */     {
/* 2178 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lostTimes));
/*      */     }
/* 2180 */     if (FCode.equalsIgnoreCase("lang"))
/*      */     {
/* 2182 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lang));
/*      */     }
/* 2184 */     if (FCode.equalsIgnoreCase("currency"))
/*      */     {
/* 2186 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.currency));
/*      */     }
/* 2188 */     if (FCode.equalsIgnoreCase("remark"))
/*      */     {
/* 2190 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark));
/*      */     }
/* 2192 */     if (FCode.equalsIgnoreCase("peoples"))
/*      */     {
/* 2194 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.peoples));
/*      */     }
/* 2196 */     if (FCode.equalsIgnoreCase("mult"))
/*      */     {
/* 2198 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mult));
/*      */     }
/* 2200 */     if (FCode.equalsIgnoreCase("prem"))
/*      */     {
/* 2202 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prem));
/*      */     }
/* 2204 */     if (FCode.equalsIgnoreCase("amnt"))
/*      */     {
/* 2206 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.amnt));
/*      */     }
/* 2208 */     if (FCode.equalsIgnoreCase("sumPrem"))
/*      */     {
/* 2210 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sumPrem));
/*      */     }
/* 2212 */     if (FCode.equalsIgnoreCase("dif"))
/*      */     {
/* 2214 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dif));
/*      */     }
/* 2216 */     if (FCode.equalsIgnoreCase("paytoDate"))
/*      */     {
/* 2218 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPaytoDate()));
/*      */     }
/* 2220 */     if (FCode.equalsIgnoreCase("firstPayDate"))
/*      */     {
/* 2222 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getFirstPayDate()));
/*      */     }
/* 2224 */     if (FCode.equalsIgnoreCase("cValiDate"))
/*      */     {
/* 2226 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCValiDate()));
/*      */     }
/* 2228 */     if (FCode.equalsIgnoreCase("pSignDate"))
/*      */     {
/* 2230 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPSignDate()));
/*      */     }
/* 2232 */     if (FCode.equalsIgnoreCase("pValiDate"))
/*      */     {
/* 2234 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPValiDate()));
/*      */     }
/* 2236 */     if (FCode.equalsIgnoreCase("inputOperator"))
/*      */     {
/* 2238 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.inputOperator));
/*      */     }
/* 2240 */     if (FCode.equalsIgnoreCase("inputDate"))
/*      */     {
/* 2242 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getInputDate()));
/*      */     }
/* 2244 */     if (FCode.equalsIgnoreCase("inputTime"))
/*      */     {
/* 2246 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.inputTime));
/*      */     }
/* 2248 */     if (FCode.equalsIgnoreCase("approveFlag"))
/*      */     {
/* 2250 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveFlag));
/*      */     }
/* 2252 */     if (FCode.equalsIgnoreCase("approveCode"))
/*      */     {
/* 2254 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveCode));
/*      */     }
/* 2256 */     if (FCode.equalsIgnoreCase("approveDate"))
/*      */     {
/* 2258 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getApproveDate()));
/*      */     }
/* 2260 */     if (FCode.equalsIgnoreCase("approveTime"))
/*      */     {
/* 2262 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveTime));
/*      */     }
/* 2264 */     if (FCode.equalsIgnoreCase("uWFlag"))
/*      */     {
/* 2266 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWFlag));
/*      */     }
/* 2268 */     if (FCode.equalsIgnoreCase("uWOperator"))
/*      */     {
/* 2270 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWOperator));
/*      */     }
/* 2272 */     if (FCode.equalsIgnoreCase("uWDate"))
/*      */     {
/* 2274 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
/*      */     }
/* 2276 */     if (FCode.equalsIgnoreCase("uWTime"))
/*      */     {
/* 2278 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWTime));
/*      */     }
/* 2280 */     if (FCode.equalsIgnoreCase("appFlag"))
/*      */     {
/* 2282 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appFlag));
/*      */     }
/* 2284 */     if (FCode.equalsIgnoreCase("polApplyDate"))
/*      */     {
/* 2286 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPolApplyDate()));
/*      */     }
/* 2288 */     if (FCode.equalsIgnoreCase("getPolDate"))
/*      */     {
/* 2290 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getGetPolDate()));
/*      */     }
/* 2292 */     if (FCode.equalsIgnoreCase("getPolTime"))
/*      */     {
/* 2294 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getPolTime));
/*      */     }
/* 2296 */     if (FCode.equalsIgnoreCase("customGetPolDate"))
/*      */     {
/* 2298 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCustomGetPolDate()));
/*      */     }
/* 2300 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 2302 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/* 2304 */     if (FCode.equalsIgnoreCase("saleChnlDetail"))
/*      */     {
/* 2306 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.saleChnlDetail));
/*      */     }
/* 2308 */     if (FCode.equalsIgnoreCase("proposalType"))
/*      */     {
/* 2310 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalType));
/*      */     }
/* 2312 */     if (FCode.equalsIgnoreCase("editstate"))
/*      */     {
/* 2314 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.editstate));
/*      */     }
/* 2316 */     if (FCode.equalsIgnoreCase("cInValiDate"))
/*      */     {
/* 2318 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCInValiDate()));
/*      */     }
/* 2320 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 2322 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 2324 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 2326 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 2328 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 2330 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 2332 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 2334 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 2336 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 2338 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 2340 */     if (strReturn.equals(""))
/*      */     {
/* 2342 */       strReturn = "null";
/*      */     }
/*      */ 
/* 2345 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 2352 */     String strFieldValue = "";
/* 2353 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2355 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/* 2356 */       break;
/*      */     case 1:
/* 2358 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 2359 */       break;
/*      */     case 2:
/* 2361 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/* 2362 */       break;
/*      */     case 3:
/* 2364 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/* 2365 */       break;
/*      */     case 4:
/* 2367 */       strFieldValue = StrTool.GBKToUnicode(this.mainPolNo);
/* 2368 */       break;
/*      */     case 5:
/* 2370 */       strFieldValue = StrTool.GBKToUnicode(this.contType);
/* 2371 */       break;
/*      */     case 6:
/* 2373 */       strFieldValue = StrTool.GBKToUnicode(this.familyType);
/* 2374 */       break;
/*      */     case 7:
/* 2376 */       strFieldValue = StrTool.GBKToUnicode(this.familyID);
/* 2377 */       break;
/*      */     case 8:
/* 2379 */       strFieldValue = StrTool.GBKToUnicode(this.polType);
/* 2380 */       break;
/*      */     case 9:
/* 2382 */       strFieldValue = StrTool.GBKToUnicode(this.sugNo);
/* 2383 */       break;
/*      */     case 10:
/* 2385 */       strFieldValue = StrTool.GBKToUnicode(this.cardFlag);
/* 2386 */       break;
/*      */     case 11:
/* 2388 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 2389 */       break;
/*      */     case 12:
/* 2391 */       strFieldValue = StrTool.GBKToUnicode(this.executeCom);
/* 2392 */       break;
/*      */     case 13:
/* 2394 */       strFieldValue = StrTool.GBKToUnicode(this.agentCom);
/* 2395 */       break;
/*      */     case 14:
/* 2397 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/* 2398 */       break;
/*      */     case 15:
/* 2400 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup);
/* 2401 */       break;
/*      */     case 16:
/* 2403 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode1);
/* 2404 */       break;
/*      */     case 17:
/* 2406 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup1);
/* 2407 */       break;
/*      */     case 18:
/* 2409 */       strFieldValue = StrTool.GBKToUnicode(this.agentType);
/* 2410 */       break;
/*      */     case 19:
/* 2412 */       strFieldValue = StrTool.GBKToUnicode(this.saleChnl);
/* 2413 */       break;
/*      */     case 20:
/* 2415 */       strFieldValue = StrTool.GBKToUnicode(this.handler);
/* 2416 */       break;
/*      */     case 21:
/* 2418 */       strFieldValue = StrTool.GBKToUnicode(this.password);
/* 2419 */       break;
/*      */     case 22:
/* 2421 */       strFieldValue = StrTool.GBKToUnicode(this.appntNo);
/* 2422 */       break;
/*      */     case 23:
/* 2424 */       strFieldValue = StrTool.GBKToUnicode(this.appntId);
/* 2425 */       break;
/*      */     case 24:
/* 2427 */       strFieldValue = StrTool.GBKToUnicode(this.appntName);
/* 2428 */       break;
/*      */     case 25:
/* 2430 */       strFieldValue = StrTool.GBKToUnicode(this.appntSex);
/* 2431 */       break;
/*      */     case 26:
/* 2433 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getAppntBirthday()));
/* 2434 */       break;
/*      */     case 27:
/* 2436 */       strFieldValue = StrTool.GBKToUnicode(this.appntIDType);
/* 2437 */       break;
/*      */     case 28:
/* 2439 */       strFieldValue = StrTool.GBKToUnicode(this.appntIDNo);
/* 2440 */       break;
/*      */     case 29:
/* 2442 */       strFieldValue = StrTool.GBKToUnicode(this.insuredNo);
/* 2443 */       break;
/*      */     case 30:
/* 2445 */       strFieldValue = StrTool.GBKToUnicode(this.insuredId);
/* 2446 */       break;
/*      */     case 31:
/* 2448 */       strFieldValue = StrTool.GBKToUnicode(this.insuredName);
/* 2449 */       break;
/*      */     case 32:
/* 2451 */       strFieldValue = StrTool.GBKToUnicode(this.insuredSex);
/* 2452 */       break;
/*      */     case 33:
/* 2454 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getInsuredBirthday()));
/* 2455 */       break;
/*      */     case 34:
/* 2457 */       strFieldValue = StrTool.GBKToUnicode(this.insuredIDType);
/* 2458 */       break;
/*      */     case 35:
/* 2460 */       strFieldValue = StrTool.GBKToUnicode(this.insuredIDNo);
/* 2461 */       break;
/*      */     case 36:
/* 2463 */       strFieldValue = String.valueOf(this.payIntv);
/* 2464 */       break;
/*      */     case 37:
/* 2466 */       strFieldValue = StrTool.GBKToUnicode(this.payMode);
/* 2467 */       break;
/*      */     case 38:
/* 2469 */       strFieldValue = StrTool.GBKToUnicode(this.payLocation);
/* 2470 */       break;
/*      */     case 39:
/* 2472 */       strFieldValue = StrTool.GBKToUnicode(this.disputedFlag);
/* 2473 */       break;
/*      */     case 40:
/* 2475 */       strFieldValue = StrTool.GBKToUnicode(this.outPayFlag);
/* 2476 */       break;
/*      */     case 41:
/* 2478 */       strFieldValue = StrTool.GBKToUnicode(this.getPolMode);
/* 2479 */       break;
/*      */     case 42:
/* 2481 */       strFieldValue = StrTool.GBKToUnicode(this.signCom);
/* 2482 */       break;
/*      */     case 43:
/* 2484 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
/* 2485 */       break;
/*      */     case 44:
/* 2487 */       strFieldValue = StrTool.GBKToUnicode(this.signTime);
/* 2488 */       break;
/*      */     case 45:
/* 2490 */       strFieldValue = StrTool.GBKToUnicode(this.consignNo);
/* 2491 */       break;
/*      */     case 46:
/* 2493 */       strFieldValue = StrTool.GBKToUnicode(this.bankCode);
/* 2494 */       break;
/*      */     case 47:
/* 2496 */       strFieldValue = StrTool.GBKToUnicode(this.bankAccNo);
/* 2497 */       break;
/*      */     case 48:
/* 2499 */       strFieldValue = StrTool.GBKToUnicode(this.accName);
/* 2500 */       break;
/*      */     case 49:
/* 2502 */       strFieldValue = String.valueOf(this.printCount);
/* 2503 */       break;
/*      */     case 50:
/* 2505 */       strFieldValue = String.valueOf(this.lostTimes);
/* 2506 */       break;
/*      */     case 51:
/* 2508 */       strFieldValue = StrTool.GBKToUnicode(this.lang);
/* 2509 */       break;
/*      */     case 52:
/* 2511 */       strFieldValue = StrTool.GBKToUnicode(this.currency);
/* 2512 */       break;
/*      */     case 53:
/* 2514 */       strFieldValue = StrTool.GBKToUnicode(this.remark);
/* 2515 */       break;
/*      */     case 54:
/* 2517 */       strFieldValue = String.valueOf(this.peoples);
/* 2518 */       break;
/*      */     case 55:
/* 2520 */       strFieldValue = String.valueOf(this.mult);
/* 2521 */       break;
/*      */     case 56:
/* 2523 */       strFieldValue = String.valueOf(this.prem);
/* 2524 */       break;
/*      */     case 57:
/* 2526 */       strFieldValue = String.valueOf(this.amnt);
/* 2527 */       break;
/*      */     case 58:
/* 2529 */       strFieldValue = String.valueOf(this.sumPrem);
/* 2530 */       break;
/*      */     case 59:
/* 2532 */       strFieldValue = String.valueOf(this.dif);
/* 2533 */       break;
/*      */     case 60:
/* 2535 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPaytoDate()));
/* 2536 */       break;
/*      */     case 61:
/* 2538 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getFirstPayDate()));
/* 2539 */       break;
/*      */     case 62:
/* 2541 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCValiDate()));
/* 2542 */       break;
/*      */     case 63:
/* 2544 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPSignDate()));
/* 2545 */       break;
/*      */     case 64:
/* 2547 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPValiDate()));
/* 2548 */       break;
/*      */     case 65:
/* 2550 */       strFieldValue = StrTool.GBKToUnicode(this.inputOperator);
/* 2551 */       break;
/*      */     case 66:
/* 2553 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getInputDate()));
/* 2554 */       break;
/*      */     case 67:
/* 2556 */       strFieldValue = StrTool.GBKToUnicode(this.inputTime);
/* 2557 */       break;
/*      */     case 68:
/* 2559 */       strFieldValue = StrTool.GBKToUnicode(this.approveFlag);
/* 2560 */       break;
/*      */     case 69:
/* 2562 */       strFieldValue = StrTool.GBKToUnicode(this.approveCode);
/* 2563 */       break;
/*      */     case 70:
/* 2565 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getApproveDate()));
/* 2566 */       break;
/*      */     case 71:
/* 2568 */       strFieldValue = StrTool.GBKToUnicode(this.approveTime);
/* 2569 */       break;
/*      */     case 72:
/* 2571 */       strFieldValue = StrTool.GBKToUnicode(this.uWFlag);
/* 2572 */       break;
/*      */     case 73:
/* 2574 */       strFieldValue = StrTool.GBKToUnicode(this.uWOperator);
/* 2575 */       break;
/*      */     case 74:
/* 2577 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
/* 2578 */       break;
/*      */     case 75:
/* 2580 */       strFieldValue = StrTool.GBKToUnicode(this.uWTime);
/* 2581 */       break;
/*      */     case 76:
/* 2583 */       strFieldValue = StrTool.GBKToUnicode(this.appFlag);
/* 2584 */       break;
/*      */     case 77:
/* 2586 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPolApplyDate()));
/* 2587 */       break;
/*      */     case 78:
/* 2589 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getGetPolDate()));
/* 2590 */       break;
/*      */     case 79:
/* 2592 */       strFieldValue = StrTool.GBKToUnicode(this.getPolTime);
/* 2593 */       break;
/*      */     case 80:
/* 2595 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCustomGetPolDate()));
/* 2596 */       break;
/*      */     case 81:
/* 2598 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 2599 */       break;
/*      */     case 82:
/* 2601 */       strFieldValue = StrTool.GBKToUnicode(this.saleChnlDetail);
/* 2602 */       break;
/*      */     case 83:
/* 2604 */       strFieldValue = StrTool.GBKToUnicode(this.proposalType);
/* 2605 */       break;
/*      */     case 84:
/* 2607 */       strFieldValue = StrTool.GBKToUnicode(this.editstate);
/* 2608 */       break;
/*      */     case 85:
/* 2610 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCInValiDate()));
/* 2611 */       break;
/*      */     case 86:
/* 2613 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 2614 */       break;
/*      */     case 87:
/* 2616 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 2617 */       break;
/*      */     case 88:
/* 2619 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 2620 */       break;
/*      */     case 89:
/* 2622 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 2623 */       break;
/*      */     case 90:
/* 2625 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 2626 */       break;
/*      */     default:
/* 2628 */       strFieldValue = "";
/*      */     }
/* 2630 */     if (strFieldValue.equals("")) {
/* 2631 */       strFieldValue = "null";
/*      */     }
/* 2633 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 2639 */     if (StrTool.cTrim(FCode).equals("")) {
/* 2640 */       return false;
/*      */     }
/* 2642 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 2644 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2646 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 2649 */         this.grpContNo = null;
/*      */     }
/* 2651 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 2653 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2655 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 2658 */         this.contNo = null;
/*      */     }
/* 2660 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 2662 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2664 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 2667 */         this.proposalContNo = null;
/*      */     }
/* 2669 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/* 2671 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2673 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/* 2676 */         this.prtNo = null;
/*      */     }
/* 2678 */     if (FCode.equalsIgnoreCase("mainPolNo"))
/*      */     {
/* 2680 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2682 */         this.mainPolNo = FValue.trim();
/*      */       }
/*      */       else
/* 2685 */         this.mainPolNo = null;
/*      */     }
/* 2687 */     if (FCode.equalsIgnoreCase("contType"))
/*      */     {
/* 2689 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2691 */         this.contType = FValue.trim();
/*      */       }
/*      */       else
/* 2694 */         this.contType = null;
/*      */     }
/* 2696 */     if (FCode.equalsIgnoreCase("familyType"))
/*      */     {
/* 2698 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2700 */         this.familyType = FValue.trim();
/*      */       }
/*      */       else
/* 2703 */         this.familyType = null;
/*      */     }
/* 2705 */     if (FCode.equalsIgnoreCase("familyID"))
/*      */     {
/* 2707 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2709 */         this.familyID = FValue.trim();
/*      */       }
/*      */       else
/* 2712 */         this.familyID = null;
/*      */     }
/* 2714 */     if (FCode.equalsIgnoreCase("polType"))
/*      */     {
/* 2716 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2718 */         this.polType = FValue.trim();
/*      */       }
/*      */       else
/* 2721 */         this.polType = null;
/*      */     }
/* 2723 */     if (FCode.equalsIgnoreCase("sugNo"))
/*      */     {
/* 2725 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2727 */         this.sugNo = FValue.trim();
/*      */       }
/*      */       else
/* 2730 */         this.sugNo = null;
/*      */     }
/* 2732 */     if (FCode.equalsIgnoreCase("cardFlag"))
/*      */     {
/* 2734 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2736 */         this.cardFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2739 */         this.cardFlag = null;
/*      */     }
/* 2741 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 2743 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2745 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 2748 */         this.manageCom = null;
/*      */     }
/* 2750 */     if (FCode.equalsIgnoreCase("executeCom"))
/*      */     {
/* 2752 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2754 */         this.executeCom = FValue.trim();
/*      */       }
/*      */       else
/* 2757 */         this.executeCom = null;
/*      */     }
/* 2759 */     if (FCode.equalsIgnoreCase("agentCom"))
/*      */     {
/* 2761 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2763 */         this.agentCom = FValue.trim();
/*      */       }
/*      */       else
/* 2766 */         this.agentCom = null;
/*      */     }
/* 2768 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 2770 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2772 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/* 2775 */         this.agentCode = null;
/*      */     }
/* 2777 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*      */     {
/* 2779 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2781 */         this.agentGroup = FValue.trim();
/*      */       }
/*      */       else
/* 2784 */         this.agentGroup = null;
/*      */     }
/* 2786 */     if (FCode.equalsIgnoreCase("agentCode1"))
/*      */     {
/* 2788 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2790 */         this.agentCode1 = FValue.trim();
/*      */       }
/*      */       else
/* 2793 */         this.agentCode1 = null;
/*      */     }
/* 2795 */     if (FCode.equalsIgnoreCase("agentGroup1"))
/*      */     {
/* 2797 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2799 */         this.agentGroup1 = FValue.trim();
/*      */       }
/*      */       else
/* 2802 */         this.agentGroup1 = null;
/*      */     }
/* 2804 */     if (FCode.equalsIgnoreCase("agentType"))
/*      */     {
/* 2806 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2808 */         this.agentType = FValue.trim();
/*      */       }
/*      */       else
/* 2811 */         this.agentType = null;
/*      */     }
/* 2813 */     if (FCode.equalsIgnoreCase("saleChnl"))
/*      */     {
/* 2815 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2817 */         this.saleChnl = FValue.trim();
/*      */       }
/*      */       else
/* 2820 */         this.saleChnl = null;
/*      */     }
/* 2822 */     if (FCode.equalsIgnoreCase("handler"))
/*      */     {
/* 2824 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2826 */         this.handler = FValue.trim();
/*      */       }
/*      */       else
/* 2829 */         this.handler = null;
/*      */     }
/* 2831 */     if (FCode.equalsIgnoreCase("password"))
/*      */     {
/* 2833 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2835 */         this.password = FValue.trim();
/*      */       }
/*      */       else
/* 2838 */         this.password = null;
/*      */     }
/* 2840 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/* 2842 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2844 */         this.appntNo = FValue.trim();
/*      */       }
/*      */       else
/* 2847 */         this.appntNo = null;
/*      */     }
/* 2849 */     if (FCode.equalsIgnoreCase("appntId"))
/*      */     {
/* 2851 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2853 */         this.appntId = FValue.trim();
/*      */       }
/*      */       else
/* 2856 */         this.appntId = null;
/*      */     }
/* 2858 */     if (FCode.equalsIgnoreCase("appntName"))
/*      */     {
/* 2860 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2862 */         this.appntName = FValue.trim();
/*      */       }
/*      */       else
/* 2865 */         this.appntName = null;
/*      */     }
/* 2867 */     if (FCode.equalsIgnoreCase("appntSex"))
/*      */     {
/* 2869 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2871 */         this.appntSex = FValue.trim();
/*      */       }
/*      */       else
/* 2874 */         this.appntSex = null;
/*      */     }
/* 2876 */     if (FCode.equalsIgnoreCase("appntBirthday"))
/*      */     {
/* 2878 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2880 */         this.appntBirthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2883 */         this.appntBirthday = null;
/*      */     }
/* 2885 */     if (FCode.equalsIgnoreCase("appntIDType"))
/*      */     {
/* 2887 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2889 */         this.appntIDType = FValue.trim();
/*      */       }
/*      */       else
/* 2892 */         this.appntIDType = null;
/*      */     }
/* 2894 */     if (FCode.equalsIgnoreCase("appntIDNo"))
/*      */     {
/* 2896 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2898 */         this.appntIDNo = FValue.trim();
/*      */       }
/*      */       else
/* 2901 */         this.appntIDNo = null;
/*      */     }
/* 2903 */     if (FCode.equalsIgnoreCase("insuredNo"))
/*      */     {
/* 2905 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2907 */         this.insuredNo = FValue.trim();
/*      */       }
/*      */       else
/* 2910 */         this.insuredNo = null;
/*      */     }
/* 2912 */     if (FCode.equalsIgnoreCase("insuredId"))
/*      */     {
/* 2914 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2916 */         this.insuredId = FValue.trim();
/*      */       }
/*      */       else
/* 2919 */         this.insuredId = null;
/*      */     }
/* 2921 */     if (FCode.equalsIgnoreCase("insuredName"))
/*      */     {
/* 2923 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2925 */         this.insuredName = FValue.trim();
/*      */       }
/*      */       else
/* 2928 */         this.insuredName = null;
/*      */     }
/* 2930 */     if (FCode.equalsIgnoreCase("insuredSex"))
/*      */     {
/* 2932 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2934 */         this.insuredSex = FValue.trim();
/*      */       }
/*      */       else
/* 2937 */         this.insuredSex = null;
/*      */     }
/* 2939 */     if (FCode.equalsIgnoreCase("insuredBirthday"))
/*      */     {
/* 2941 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2943 */         this.insuredBirthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2946 */         this.insuredBirthday = null;
/*      */     }
/* 2948 */     if (FCode.equalsIgnoreCase("insuredIDType"))
/*      */     {
/* 2950 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2952 */         this.insuredIDType = FValue.trim();
/*      */       }
/*      */       else
/* 2955 */         this.insuredIDType = null;
/*      */     }
/* 2957 */     if (FCode.equalsIgnoreCase("insuredIDNo"))
/*      */     {
/* 2959 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2961 */         this.insuredIDNo = FValue.trim();
/*      */       }
/*      */       else
/* 2964 */         this.insuredIDNo = null;
/*      */     }
/* 2966 */     if (FCode.equalsIgnoreCase("payIntv"))
/*      */     {
/* 2968 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2970 */         Integer tInteger = new Integer(FValue);
/* 2971 */         int i = tInteger.intValue();
/* 2972 */         this.payIntv = i;
/*      */       }
/*      */     }
/* 2975 */     if (FCode.equalsIgnoreCase("payMode"))
/*      */     {
/* 2977 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2979 */         this.payMode = FValue.trim();
/*      */       }
/*      */       else
/* 2982 */         this.payMode = null;
/*      */     }
/* 2984 */     if (FCode.equalsIgnoreCase("payLocation"))
/*      */     {
/* 2986 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2988 */         this.payLocation = FValue.trim();
/*      */       }
/*      */       else
/* 2991 */         this.payLocation = null;
/*      */     }
/* 2993 */     if (FCode.equalsIgnoreCase("disputedFlag"))
/*      */     {
/* 2995 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2997 */         this.disputedFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3000 */         this.disputedFlag = null;
/*      */     }
/* 3002 */     if (FCode.equalsIgnoreCase("outPayFlag"))
/*      */     {
/* 3004 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3006 */         this.outPayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3009 */         this.outPayFlag = null;
/*      */     }
/* 3011 */     if (FCode.equalsIgnoreCase("getPolMode"))
/*      */     {
/* 3013 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3015 */         this.getPolMode = FValue.trim();
/*      */       }
/*      */       else
/* 3018 */         this.getPolMode = null;
/*      */     }
/* 3020 */     if (FCode.equalsIgnoreCase("signCom"))
/*      */     {
/* 3022 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3024 */         this.signCom = FValue.trim();
/*      */       }
/*      */       else
/* 3027 */         this.signCom = null;
/*      */     }
/* 3029 */     if (FCode.equalsIgnoreCase("signDate"))
/*      */     {
/* 3031 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3033 */         this.signDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3036 */         this.signDate = null;
/*      */     }
/* 3038 */     if (FCode.equalsIgnoreCase("signTime"))
/*      */     {
/* 3040 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3042 */         this.signTime = FValue.trim();
/*      */       }
/*      */       else
/* 3045 */         this.signTime = null;
/*      */     }
/* 3047 */     if (FCode.equalsIgnoreCase("consignNo"))
/*      */     {
/* 3049 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3051 */         this.consignNo = FValue.trim();
/*      */       }
/*      */       else
/* 3054 */         this.consignNo = null;
/*      */     }
/* 3056 */     if (FCode.equalsIgnoreCase("bankCode"))
/*      */     {
/* 3058 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3060 */         this.bankCode = FValue.trim();
/*      */       }
/*      */       else
/* 3063 */         this.bankCode = null;
/*      */     }
/* 3065 */     if (FCode.equalsIgnoreCase("bankAccNo"))
/*      */     {
/* 3067 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3069 */         this.bankAccNo = FValue.trim();
/*      */       }
/*      */       else
/* 3072 */         this.bankAccNo = null;
/*      */     }
/* 3074 */     if (FCode.equalsIgnoreCase("accName"))
/*      */     {
/* 3076 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3078 */         this.accName = FValue.trim();
/*      */       }
/*      */       else
/* 3081 */         this.accName = null;
/*      */     }
/* 3083 */     if (FCode.equalsIgnoreCase("printCount"))
/*      */     {
/* 3085 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3087 */         Integer tInteger = new Integer(FValue);
/* 3088 */         int i = tInteger.intValue();
/* 3089 */         this.printCount = i;
/*      */       }
/*      */     }
/* 3092 */     if (FCode.equalsIgnoreCase("lostTimes"))
/*      */     {
/* 3094 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3096 */         Integer tInteger = new Integer(FValue);
/* 3097 */         int i = tInteger.intValue();
/* 3098 */         this.lostTimes = i;
/*      */       }
/*      */     }
/* 3101 */     if (FCode.equalsIgnoreCase("lang"))
/*      */     {
/* 3103 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3105 */         this.lang = FValue.trim();
/*      */       }
/*      */       else
/* 3108 */         this.lang = null;
/*      */     }
/* 3110 */     if (FCode.equalsIgnoreCase("currency"))
/*      */     {
/* 3112 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3114 */         this.currency = FValue.trim();
/*      */       }
/*      */       else
/* 3117 */         this.currency = null;
/*      */     }
/* 3119 */     if (FCode.equalsIgnoreCase("remark"))
/*      */     {
/* 3121 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3123 */         this.remark = FValue.trim();
/*      */       }
/*      */       else
/* 3126 */         this.remark = null;
/*      */     }
/* 3128 */     if (FCode.equalsIgnoreCase("peoples"))
/*      */     {
/* 3130 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3132 */         Integer tInteger = new Integer(FValue);
/* 3133 */         int i = tInteger.intValue();
/* 3134 */         this.peoples = i;
/*      */       }
/*      */     }
/* 3137 */     if (FCode.equalsIgnoreCase("mult"))
/*      */     {
/* 3139 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3141 */         Double tDouble = new Double(FValue);
/* 3142 */         double d = tDouble.doubleValue();
/* 3143 */         this.mult = d;
/*      */       }
/*      */     }
/* 3146 */     if (FCode.equalsIgnoreCase("prem"))
/*      */     {
/* 3148 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3150 */         Double tDouble = new Double(FValue);
/* 3151 */         double d = tDouble.doubleValue();
/* 3152 */         this.prem = d;
/*      */       }
/*      */     }
/* 3155 */     if (FCode.equalsIgnoreCase("amnt"))
/*      */     {
/* 3157 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3159 */         Double tDouble = new Double(FValue);
/* 3160 */         double d = tDouble.doubleValue();
/* 3161 */         this.amnt = d;
/*      */       }
/*      */     }
/* 3164 */     if (FCode.equalsIgnoreCase("sumPrem"))
/*      */     {
/* 3166 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3168 */         Double tDouble = new Double(FValue);
/* 3169 */         double d = tDouble.doubleValue();
/* 3170 */         this.sumPrem = d;
/*      */       }
/*      */     }
/* 3173 */     if (FCode.equalsIgnoreCase("dif"))
/*      */     {
/* 3175 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3177 */         Double tDouble = new Double(FValue);
/* 3178 */         double d = tDouble.doubleValue();
/* 3179 */         this.dif = d;
/*      */       }
/*      */     }
/* 3182 */     if (FCode.equalsIgnoreCase("paytoDate"))
/*      */     {
/* 3184 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3186 */         this.paytoDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3189 */         this.paytoDate = null;
/*      */     }
/* 3191 */     if (FCode.equalsIgnoreCase("firstPayDate"))
/*      */     {
/* 3193 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3195 */         this.firstPayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3198 */         this.firstPayDate = null;
/*      */     }
/* 3200 */     if (FCode.equalsIgnoreCase("cValiDate"))
/*      */     {
/* 3202 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3204 */         this.cValiDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3207 */         this.cValiDate = null;
/*      */     }
/* 3209 */     if (FCode.equalsIgnoreCase("pSignDate"))
/*      */     {
/* 3211 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3213 */         this.pSignDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3216 */         this.pSignDate = null;
/*      */     }
/* 3218 */     if (FCode.equalsIgnoreCase("pValiDate"))
/*      */     {
/* 3220 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3222 */         this.pValiDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3225 */         this.pValiDate = null;
/*      */     }
/* 3227 */     if (FCode.equalsIgnoreCase("inputOperator"))
/*      */     {
/* 3229 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3231 */         this.inputOperator = FValue.trim();
/*      */       }
/*      */       else
/* 3234 */         this.inputOperator = null;
/*      */     }
/* 3236 */     if (FCode.equalsIgnoreCase("inputDate"))
/*      */     {
/* 3238 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3240 */         this.inputDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3243 */         this.inputDate = null;
/*      */     }
/* 3245 */     if (FCode.equalsIgnoreCase("inputTime"))
/*      */     {
/* 3247 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3249 */         this.inputTime = FValue.trim();
/*      */       }
/*      */       else
/* 3252 */         this.inputTime = null;
/*      */     }
/* 3254 */     if (FCode.equalsIgnoreCase("approveFlag"))
/*      */     {
/* 3256 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3258 */         this.approveFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3261 */         this.approveFlag = null;
/*      */     }
/* 3263 */     if (FCode.equalsIgnoreCase("approveCode"))
/*      */     {
/* 3265 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3267 */         this.approveCode = FValue.trim();
/*      */       }
/*      */       else
/* 3270 */         this.approveCode = null;
/*      */     }
/* 3272 */     if (FCode.equalsIgnoreCase("approveDate"))
/*      */     {
/* 3274 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3276 */         this.approveDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3279 */         this.approveDate = null;
/*      */     }
/* 3281 */     if (FCode.equalsIgnoreCase("approveTime"))
/*      */     {
/* 3283 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3285 */         this.approveTime = FValue.trim();
/*      */       }
/*      */       else
/* 3288 */         this.approveTime = null;
/*      */     }
/* 3290 */     if (FCode.equalsIgnoreCase("uWFlag"))
/*      */     {
/* 3292 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3294 */         this.uWFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3297 */         this.uWFlag = null;
/*      */     }
/* 3299 */     if (FCode.equalsIgnoreCase("uWOperator"))
/*      */     {
/* 3301 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3303 */         this.uWOperator = FValue.trim();
/*      */       }
/*      */       else
/* 3306 */         this.uWOperator = null;
/*      */     }
/* 3308 */     if (FCode.equalsIgnoreCase("uWDate"))
/*      */     {
/* 3310 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3312 */         this.uWDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3315 */         this.uWDate = null;
/*      */     }
/* 3317 */     if (FCode.equalsIgnoreCase("uWTime"))
/*      */     {
/* 3319 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3321 */         this.uWTime = FValue.trim();
/*      */       }
/*      */       else
/* 3324 */         this.uWTime = null;
/*      */     }
/* 3326 */     if (FCode.equalsIgnoreCase("appFlag"))
/*      */     {
/* 3328 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3330 */         this.appFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3333 */         this.appFlag = null;
/*      */     }
/* 3335 */     if (FCode.equalsIgnoreCase("polApplyDate"))
/*      */     {
/* 3337 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3339 */         this.polApplyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3342 */         this.polApplyDate = null;
/*      */     }
/* 3344 */     if (FCode.equalsIgnoreCase("getPolDate"))
/*      */     {
/* 3346 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3348 */         this.getPolDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3351 */         this.getPolDate = null;
/*      */     }
/* 3353 */     if (FCode.equalsIgnoreCase("getPolTime"))
/*      */     {
/* 3355 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3357 */         this.getPolTime = FValue.trim();
/*      */       }
/*      */       else
/* 3360 */         this.getPolTime = null;
/*      */     }
/* 3362 */     if (FCode.equalsIgnoreCase("customGetPolDate"))
/*      */     {
/* 3364 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3366 */         this.customGetPolDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3369 */         this.customGetPolDate = null;
/*      */     }
/* 3371 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 3373 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3375 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 3378 */         this.state = null;
/*      */     }
/* 3380 */     if (FCode.equalsIgnoreCase("saleChnlDetail"))
/*      */     {
/* 3382 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3384 */         this.saleChnlDetail = FValue.trim();
/*      */       }
/*      */       else
/* 3387 */         this.saleChnlDetail = null;
/*      */     }
/* 3389 */     if (FCode.equalsIgnoreCase("proposalType"))
/*      */     {
/* 3391 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3393 */         this.proposalType = FValue.trim();
/*      */       }
/*      */       else
/* 3396 */         this.proposalType = null;
/*      */     }
/* 3398 */     if (FCode.equalsIgnoreCase("editstate"))
/*      */     {
/* 3400 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3402 */         this.editstate = FValue.trim();
/*      */       }
/*      */       else
/* 3405 */         this.editstate = null;
/*      */     }
/* 3407 */     if (FCode.equalsIgnoreCase("cInValiDate"))
/*      */     {
/* 3409 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3411 */         this.cInValiDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3414 */         this.cInValiDate = null;
/*      */     }
/* 3416 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 3418 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3420 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 3423 */         this.operator = null;
/*      */     }
/* 3425 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 3427 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3429 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3432 */         this.makeDate = null;
/*      */     }
/* 3434 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 3436 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3438 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 3441 */         this.makeTime = null;
/*      */     }
/* 3443 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 3445 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3447 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3450 */         this.modifyDate = null;
/*      */     }
/* 3452 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 3454 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3456 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 3459 */         this.modifyTime = null;
/*      */     }
/* 3461 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 3466 */     if (otherObject == null) return false;
/* 3467 */     if (this == otherObject) return true;
/* 3468 */     if (getClass() != otherObject.getClass()) return false;
/* 3469 */     LNPContSchema other = (LNPContSchema)otherObject;
/* 3470 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/* 3471 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/* 3472 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/* 3473 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/* 3474 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/* 3475 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/* 3476 */     if ((this.prtNo == null) && (other.getPrtNo() != null)) return false;
/* 3477 */     if ((this.prtNo != null) && (!this.prtNo.equals(other.getPrtNo()))) return false;
/* 3478 */     if ((this.mainPolNo == null) && (other.getMainPolNo() != null)) return false;
/* 3479 */     if ((this.mainPolNo != null) && (!this.mainPolNo.equals(other.getMainPolNo()))) return false;
/* 3480 */     if ((this.contType == null) && (other.getContType() != null)) return false;
/* 3481 */     if ((this.contType != null) && (!this.contType.equals(other.getContType()))) return false;
/* 3482 */     if ((this.familyType == null) && (other.getFamilyType() != null)) return false;
/* 3483 */     if ((this.familyType != null) && (!this.familyType.equals(other.getFamilyType()))) return false;
/* 3484 */     if ((this.familyID == null) && (other.getFamilyID() != null)) return false;
/* 3485 */     if ((this.familyID != null) && (!this.familyID.equals(other.getFamilyID()))) return false;
/* 3486 */     if ((this.polType == null) && (other.getPolType() != null)) return false;
/* 3487 */     if ((this.polType != null) && (!this.polType.equals(other.getPolType()))) return false;
/* 3488 */     if ((this.sugNo == null) && (other.getSugNo() != null)) return false;
/* 3489 */     if ((this.sugNo != null) && (!this.sugNo.equals(other.getSugNo()))) return false;
/* 3490 */     if ((this.cardFlag == null) && (other.getCardFlag() != null)) return false;
/* 3491 */     if ((this.cardFlag != null) && (!this.cardFlag.equals(other.getCardFlag()))) return false;
/* 3492 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 3493 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 3494 */     if ((this.executeCom == null) && (other.getExecuteCom() != null)) return false;
/* 3495 */     if ((this.executeCom != null) && (!this.executeCom.equals(other.getExecuteCom()))) return false;
/* 3496 */     if ((this.agentCom == null) && (other.getAgentCom() != null)) return false;
/* 3497 */     if ((this.agentCom != null) && (!this.agentCom.equals(other.getAgentCom()))) return false;
/* 3498 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/* 3499 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/* 3500 */     if ((this.agentGroup == null) && (other.getAgentGroup() != null)) return false;
/* 3501 */     if ((this.agentGroup != null) && (!this.agentGroup.equals(other.getAgentGroup()))) return false;
/* 3502 */     if ((this.agentCode1 == null) && (other.getAgentCode1() != null)) return false;
/* 3503 */     if ((this.agentCode1 != null) && (!this.agentCode1.equals(other.getAgentCode1()))) return false;
/* 3504 */     if ((this.agentGroup1 == null) && (other.getAgentGroup1() != null)) return false;
/* 3505 */     if ((this.agentGroup1 != null) && (!this.agentGroup1.equals(other.getAgentGroup1()))) return false;
/* 3506 */     if ((this.agentType == null) && (other.getAgentType() != null)) return false;
/* 3507 */     if ((this.agentType != null) && (!this.agentType.equals(other.getAgentType()))) return false;
/* 3508 */     if ((this.saleChnl == null) && (other.getSaleChnl() != null)) return false;
/* 3509 */     if ((this.saleChnl != null) && (!this.saleChnl.equals(other.getSaleChnl()))) return false;
/* 3510 */     if ((this.handler == null) && (other.getHandler() != null)) return false;
/* 3511 */     if ((this.handler != null) && (!this.handler.equals(other.getHandler()))) return false;
/* 3512 */     if ((this.password == null) && (other.getPassword() != null)) return false;
/* 3513 */     if ((this.password != null) && (!this.password.equals(other.getPassword()))) return false;
/* 3514 */     if ((this.appntNo == null) && (other.getAppntNo() != null)) return false;
/* 3515 */     if ((this.appntNo != null) && (!this.appntNo.equals(other.getAppntNo()))) return false;
/* 3516 */     if ((this.appntId == null) && (other.getAppntId() != null)) return false;
/* 3517 */     if ((this.appntId != null) && (!this.appntId.equals(other.getAppntId()))) return false;
/* 3518 */     if ((this.appntName == null) && (other.getAppntName() != null)) return false;
/* 3519 */     if ((this.appntName != null) && (!this.appntName.equals(other.getAppntName()))) return false;
/* 3520 */     if ((this.appntSex == null) && (other.getAppntSex() != null)) return false;
/* 3521 */     if ((this.appntSex != null) && (!this.appntSex.equals(other.getAppntSex()))) return false;
/* 3522 */     if ((this.appntBirthday == null) && (other.getAppntBirthday() != null)) return false;
/* 3523 */     if ((this.appntBirthday != null) && (!this.fDate.getString(this.appntBirthday).equals(other.getAppntBirthday()))) return false;
/* 3524 */     if ((this.appntIDType == null) && (other.getAppntIDType() != null)) return false;
/* 3525 */     if ((this.appntIDType != null) && (!this.appntIDType.equals(other.getAppntIDType()))) return false;
/* 3526 */     if ((this.appntIDNo == null) && (other.getAppntIDNo() != null)) return false;
/* 3527 */     if ((this.appntIDNo != null) && (!this.appntIDNo.equals(other.getAppntIDNo()))) return false;
/* 3528 */     if ((this.insuredNo == null) && (other.getInsuredNo() != null)) return false;
/* 3529 */     if ((this.insuredNo != null) && (!this.insuredNo.equals(other.getInsuredNo()))) return false;
/* 3530 */     if ((this.insuredId == null) && (other.getInsuredId() != null)) return false;
/* 3531 */     if ((this.insuredId != null) && (!this.insuredId.equals(other.getInsuredId()))) return false;
/* 3532 */     if ((this.insuredName == null) && (other.getInsuredName() != null)) return false;
/* 3533 */     if ((this.insuredName != null) && (!this.insuredName.equals(other.getInsuredName()))) return false;
/* 3534 */     if ((this.insuredSex == null) && (other.getInsuredSex() != null)) return false;
/* 3535 */     if ((this.insuredSex != null) && (!this.insuredSex.equals(other.getInsuredSex()))) return false;
/* 3536 */     if ((this.insuredBirthday == null) && (other.getInsuredBirthday() != null)) return false;
/* 3537 */     if ((this.insuredBirthday != null) && (!this.fDate.getString(this.insuredBirthday).equals(other.getInsuredBirthday()))) return false;
/* 3538 */     if ((this.insuredIDType == null) && (other.getInsuredIDType() != null)) return false;
/* 3539 */     if ((this.insuredIDType != null) && (!this.insuredIDType.equals(other.getInsuredIDType()))) return false;
/* 3540 */     if ((this.insuredIDNo == null) && (other.getInsuredIDNo() != null)) return false;
/* 3541 */     if ((this.insuredIDNo != null) && (!this.insuredIDNo.equals(other.getInsuredIDNo()))) return false;
/* 3542 */     if (this.payIntv != other.getPayIntv()) return false;
/* 3543 */     if ((this.payMode == null) && (other.getPayMode() != null)) return false;
/* 3544 */     if ((this.payMode != null) && (!this.payMode.equals(other.getPayMode()))) return false;
/* 3545 */     if ((this.payLocation == null) && (other.getPayLocation() != null)) return false;
/* 3546 */     if ((this.payLocation != null) && (!this.payLocation.equals(other.getPayLocation()))) return false;
/* 3547 */     if ((this.disputedFlag == null) && (other.getDisputedFlag() != null)) return false;
/* 3548 */     if ((this.disputedFlag != null) && (!this.disputedFlag.equals(other.getDisputedFlag()))) return false;
/* 3549 */     if ((this.outPayFlag == null) && (other.getOutPayFlag() != null)) return false;
/* 3550 */     if ((this.outPayFlag != null) && (!this.outPayFlag.equals(other.getOutPayFlag()))) return false;
/* 3551 */     if ((this.getPolMode == null) && (other.getGetPolMode() != null)) return false;
/* 3552 */     if ((this.getPolMode != null) && (!this.getPolMode.equals(other.getGetPolMode()))) return false;
/* 3553 */     if ((this.signCom == null) && (other.getSignCom() != null)) return false;
/* 3554 */     if ((this.signCom != null) && (!this.signCom.equals(other.getSignCom()))) return false;
/* 3555 */     if ((this.signDate == null) && (other.getSignDate() != null)) return false;
/* 3556 */     if ((this.signDate != null) && (!this.fDate.getString(this.signDate).equals(other.getSignDate()))) return false;
/* 3557 */     if ((this.signTime == null) && (other.getSignTime() != null)) return false;
/* 3558 */     if ((this.signTime != null) && (!this.signTime.equals(other.getSignTime()))) return false;
/* 3559 */     if ((this.consignNo == null) && (other.getConsignNo() != null)) return false;
/* 3560 */     if ((this.consignNo != null) && (!this.consignNo.equals(other.getConsignNo()))) return false;
/* 3561 */     if ((this.bankCode == null) && (other.getBankCode() != null)) return false;
/* 3562 */     if ((this.bankCode != null) && (!this.bankCode.equals(other.getBankCode()))) return false;
/* 3563 */     if ((this.bankAccNo == null) && (other.getBankAccNo() != null)) return false;
/* 3564 */     if ((this.bankAccNo != null) && (!this.bankAccNo.equals(other.getBankAccNo()))) return false;
/* 3565 */     if ((this.accName == null) && (other.getAccName() != null)) return false;
/* 3566 */     if ((this.accName != null) && (!this.accName.equals(other.getAccName()))) return false;
/* 3567 */     if (this.printCount != other.getPrintCount()) return false;
/* 3568 */     if (this.lostTimes != other.getLostTimes()) return false;
/* 3569 */     if ((this.lang == null) && (other.getLang() != null)) return false;
/* 3570 */     if ((this.lang != null) && (!this.lang.equals(other.getLang()))) return false;
/* 3571 */     if ((this.currency == null) && (other.getCurrency() != null)) return false;
/* 3572 */     if ((this.currency != null) && (!this.currency.equals(other.getCurrency()))) return false;
/* 3573 */     if ((this.remark == null) && (other.getRemark() != null)) return false;
/* 3574 */     if ((this.remark != null) && (!this.remark.equals(other.getRemark()))) return false;
/* 3575 */     if (this.peoples != other.getPeoples()) return false;
/* 3576 */     if (Double.doubleToLongBits(this.mult) != Double.doubleToLongBits(other.getMult())) return false;
/* 3577 */     if (Double.doubleToLongBits(this.prem) != Double.doubleToLongBits(other.getPrem())) return false;
/* 3578 */     if (Double.doubleToLongBits(this.amnt) != Double.doubleToLongBits(other.getAmnt())) return false;
/* 3579 */     if (Double.doubleToLongBits(this.sumPrem) != Double.doubleToLongBits(other.getSumPrem())) return false;
/* 3580 */     if (Double.doubleToLongBits(this.dif) != Double.doubleToLongBits(other.getDif())) return false;
/* 3581 */     if ((this.paytoDate == null) && (other.getPaytoDate() != null)) return false;
/* 3582 */     if ((this.paytoDate != null) && (!this.fDate.getString(this.paytoDate).equals(other.getPaytoDate()))) return false;
/* 3583 */     if ((this.firstPayDate == null) && (other.getFirstPayDate() != null)) return false;
/* 3584 */     if ((this.firstPayDate != null) && (!this.fDate.getString(this.firstPayDate).equals(other.getFirstPayDate()))) return false;
/* 3585 */     if ((this.cValiDate == null) && (other.getCValiDate() != null)) return false;
/* 3586 */     if ((this.cValiDate != null) && (!this.fDate.getString(this.cValiDate).equals(other.getCValiDate()))) return false;
/* 3587 */     if ((this.pSignDate == null) && (other.getPSignDate() != null)) return false;
/* 3588 */     if ((this.pSignDate != null) && (!this.fDate.getString(this.pSignDate).equals(other.getPSignDate()))) return false;
/* 3589 */     if ((this.pValiDate == null) && (other.getPValiDate() != null)) return false;
/* 3590 */     if ((this.pValiDate != null) && (!this.fDate.getString(this.pValiDate).equals(other.getPValiDate()))) return false;
/* 3591 */     if ((this.inputOperator == null) && (other.getInputOperator() != null)) return false;
/* 3592 */     if ((this.inputOperator != null) && (!this.inputOperator.equals(other.getInputOperator()))) return false;
/* 3593 */     if ((this.inputDate == null) && (other.getInputDate() != null)) return false;
/* 3594 */     if ((this.inputDate != null) && (!this.fDate.getString(this.inputDate).equals(other.getInputDate()))) return false;
/* 3595 */     if ((this.inputTime == null) && (other.getInputTime() != null)) return false;
/* 3596 */     if ((this.inputTime != null) && (!this.inputTime.equals(other.getInputTime()))) return false;
/* 3597 */     if ((this.approveFlag == null) && (other.getApproveFlag() != null)) return false;
/* 3598 */     if ((this.approveFlag != null) && (!this.approveFlag.equals(other.getApproveFlag()))) return false;
/* 3599 */     if ((this.approveCode == null) && (other.getApproveCode() != null)) return false;
/* 3600 */     if ((this.approveCode != null) && (!this.approveCode.equals(other.getApproveCode()))) return false;
/* 3601 */     if ((this.approveDate == null) && (other.getApproveDate() != null)) return false;
/* 3602 */     if ((this.approveDate != null) && (!this.fDate.getString(this.approveDate).equals(other.getApproveDate()))) return false;
/* 3603 */     if ((this.approveTime == null) && (other.getApproveTime() != null)) return false;
/* 3604 */     if ((this.approveTime != null) && (!this.approveTime.equals(other.getApproveTime()))) return false;
/* 3605 */     if ((this.uWFlag == null) && (other.getUWFlag() != null)) return false;
/* 3606 */     if ((this.uWFlag != null) && (!this.uWFlag.equals(other.getUWFlag()))) return false;
/* 3607 */     if ((this.uWOperator == null) && (other.getUWOperator() != null)) return false;
/* 3608 */     if ((this.uWOperator != null) && (!this.uWOperator.equals(other.getUWOperator()))) return false;
/* 3609 */     if ((this.uWDate == null) && (other.getUWDate() != null)) return false;
/* 3610 */     if ((this.uWDate != null) && (!this.fDate.getString(this.uWDate).equals(other.getUWDate()))) return false;
/* 3611 */     if ((this.uWTime == null) && (other.getUWTime() != null)) return false;
/* 3612 */     if ((this.uWTime != null) && (!this.uWTime.equals(other.getUWTime()))) return false;
/* 3613 */     if ((this.appFlag == null) && (other.getAppFlag() != null)) return false;
/* 3614 */     if ((this.appFlag != null) && (!this.appFlag.equals(other.getAppFlag()))) return false;
/* 3615 */     if ((this.polApplyDate == null) && (other.getPolApplyDate() != null)) return false;
/* 3616 */     if ((this.polApplyDate != null) && (!this.fDate.getString(this.polApplyDate).equals(other.getPolApplyDate()))) return false;
/* 3617 */     if ((this.getPolDate == null) && (other.getGetPolDate() != null)) return false;
/* 3618 */     if ((this.getPolDate != null) && (!this.fDate.getString(this.getPolDate).equals(other.getGetPolDate()))) return false;
/* 3619 */     if ((this.getPolTime == null) && (other.getGetPolTime() != null)) return false;
/* 3620 */     if ((this.getPolTime != null) && (!this.getPolTime.equals(other.getGetPolTime()))) return false;
/* 3621 */     if ((this.customGetPolDate == null) && (other.getCustomGetPolDate() != null)) return false;
/* 3622 */     if ((this.customGetPolDate != null) && (!this.fDate.getString(this.customGetPolDate).equals(other.getCustomGetPolDate()))) return false;
/* 3623 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 3624 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 3625 */     if ((this.saleChnlDetail == null) && (other.getSaleChnlDetail() != null)) return false;
/* 3626 */     if ((this.saleChnlDetail != null) && (!this.saleChnlDetail.equals(other.getSaleChnlDetail()))) return false;
/* 3627 */     if ((this.proposalType == null) && (other.getProposalType() != null)) return false;
/* 3628 */     if ((this.proposalType != null) && (!this.proposalType.equals(other.getProposalType()))) return false;
/* 3629 */     if ((this.editstate == null) && (other.getEditstate() != null)) return false;
/* 3630 */     if ((this.editstate != null) && (!this.editstate.equals(other.getEditstate()))) return false;
/* 3631 */     if ((this.cInValiDate == null) && (other.getCInValiDate() != null)) return false;
/* 3632 */     if ((this.cInValiDate != null) && (!this.fDate.getString(this.cInValiDate).equals(other.getCInValiDate()))) return false;
/* 3633 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 3634 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 3635 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 3636 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 3637 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 3638 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 3639 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 3640 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 3641 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 3642 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 3649 */     return 91;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 3655 */     if (strFieldName.equals("grpContNo")) {
/* 3656 */       return 0;
/*      */     }
/* 3658 */     if (strFieldName.equals("contNo")) {
/* 3659 */       return 1;
/*      */     }
/* 3661 */     if (strFieldName.equals("proposalContNo")) {
/* 3662 */       return 2;
/*      */     }
/* 3664 */     if (strFieldName.equals("prtNo")) {
/* 3665 */       return 3;
/*      */     }
/* 3667 */     if (strFieldName.equals("mainPolNo")) {
/* 3668 */       return 4;
/*      */     }
/* 3670 */     if (strFieldName.equals("contType")) {
/* 3671 */       return 5;
/*      */     }
/* 3673 */     if (strFieldName.equals("familyType")) {
/* 3674 */       return 6;
/*      */     }
/* 3676 */     if (strFieldName.equals("familyID")) {
/* 3677 */       return 7;
/*      */     }
/* 3679 */     if (strFieldName.equals("polType")) {
/* 3680 */       return 8;
/*      */     }
/* 3682 */     if (strFieldName.equals("sugNo")) {
/* 3683 */       return 9;
/*      */     }
/* 3685 */     if (strFieldName.equals("cardFlag")) {
/* 3686 */       return 10;
/*      */     }
/* 3688 */     if (strFieldName.equals("manageCom")) {
/* 3689 */       return 11;
/*      */     }
/* 3691 */     if (strFieldName.equals("executeCom")) {
/* 3692 */       return 12;
/*      */     }
/* 3694 */     if (strFieldName.equals("agentCom")) {
/* 3695 */       return 13;
/*      */     }
/* 3697 */     if (strFieldName.equals("agentCode")) {
/* 3698 */       return 14;
/*      */     }
/* 3700 */     if (strFieldName.equals("agentGroup")) {
/* 3701 */       return 15;
/*      */     }
/* 3703 */     if (strFieldName.equals("agentCode1")) {
/* 3704 */       return 16;
/*      */     }
/* 3706 */     if (strFieldName.equals("agentGroup1")) {
/* 3707 */       return 17;
/*      */     }
/* 3709 */     if (strFieldName.equals("agentType")) {
/* 3710 */       return 18;
/*      */     }
/* 3712 */     if (strFieldName.equals("saleChnl")) {
/* 3713 */       return 19;
/*      */     }
/* 3715 */     if (strFieldName.equals("handler")) {
/* 3716 */       return 20;
/*      */     }
/* 3718 */     if (strFieldName.equals("password")) {
/* 3719 */       return 21;
/*      */     }
/* 3721 */     if (strFieldName.equals("appntNo")) {
/* 3722 */       return 22;
/*      */     }
/* 3724 */     if (strFieldName.equals("appntId")) {
/* 3725 */       return 23;
/*      */     }
/* 3727 */     if (strFieldName.equals("appntName")) {
/* 3728 */       return 24;
/*      */     }
/* 3730 */     if (strFieldName.equals("appntSex")) {
/* 3731 */       return 25;
/*      */     }
/* 3733 */     if (strFieldName.equals("appntBirthday")) {
/* 3734 */       return 26;
/*      */     }
/* 3736 */     if (strFieldName.equals("appntIDType")) {
/* 3737 */       return 27;
/*      */     }
/* 3739 */     if (strFieldName.equals("appntIDNo")) {
/* 3740 */       return 28;
/*      */     }
/* 3742 */     if (strFieldName.equals("insuredNo")) {
/* 3743 */       return 29;
/*      */     }
/* 3745 */     if (strFieldName.equals("insuredId")) {
/* 3746 */       return 30;
/*      */     }
/* 3748 */     if (strFieldName.equals("insuredName")) {
/* 3749 */       return 31;
/*      */     }
/* 3751 */     if (strFieldName.equals("insuredSex")) {
/* 3752 */       return 32;
/*      */     }
/* 3754 */     if (strFieldName.equals("insuredBirthday")) {
/* 3755 */       return 33;
/*      */     }
/* 3757 */     if (strFieldName.equals("insuredIDType")) {
/* 3758 */       return 34;
/*      */     }
/* 3760 */     if (strFieldName.equals("insuredIDNo")) {
/* 3761 */       return 35;
/*      */     }
/* 3763 */     if (strFieldName.equals("payIntv")) {
/* 3764 */       return 36;
/*      */     }
/* 3766 */     if (strFieldName.equals("payMode")) {
/* 3767 */       return 37;
/*      */     }
/* 3769 */     if (strFieldName.equals("payLocation")) {
/* 3770 */       return 38;
/*      */     }
/* 3772 */     if (strFieldName.equals("disputedFlag")) {
/* 3773 */       return 39;
/*      */     }
/* 3775 */     if (strFieldName.equals("outPayFlag")) {
/* 3776 */       return 40;
/*      */     }
/* 3778 */     if (strFieldName.equals("getPolMode")) {
/* 3779 */       return 41;
/*      */     }
/* 3781 */     if (strFieldName.equals("signCom")) {
/* 3782 */       return 42;
/*      */     }
/* 3784 */     if (strFieldName.equals("signDate")) {
/* 3785 */       return 43;
/*      */     }
/* 3787 */     if (strFieldName.equals("signTime")) {
/* 3788 */       return 44;
/*      */     }
/* 3790 */     if (strFieldName.equals("consignNo")) {
/* 3791 */       return 45;
/*      */     }
/* 3793 */     if (strFieldName.equals("bankCode")) {
/* 3794 */       return 46;
/*      */     }
/* 3796 */     if (strFieldName.equals("bankAccNo")) {
/* 3797 */       return 47;
/*      */     }
/* 3799 */     if (strFieldName.equals("accName")) {
/* 3800 */       return 48;
/*      */     }
/* 3802 */     if (strFieldName.equals("printCount")) {
/* 3803 */       return 49;
/*      */     }
/* 3805 */     if (strFieldName.equals("lostTimes")) {
/* 3806 */       return 50;
/*      */     }
/* 3808 */     if (strFieldName.equals("lang")) {
/* 3809 */       return 51;
/*      */     }
/* 3811 */     if (strFieldName.equals("currency")) {
/* 3812 */       return 52;
/*      */     }
/* 3814 */     if (strFieldName.equals("remark")) {
/* 3815 */       return 53;
/*      */     }
/* 3817 */     if (strFieldName.equals("peoples")) {
/* 3818 */       return 54;
/*      */     }
/* 3820 */     if (strFieldName.equals("mult")) {
/* 3821 */       return 55;
/*      */     }
/* 3823 */     if (strFieldName.equals("prem")) {
/* 3824 */       return 56;
/*      */     }
/* 3826 */     if (strFieldName.equals("amnt")) {
/* 3827 */       return 57;
/*      */     }
/* 3829 */     if (strFieldName.equals("sumPrem")) {
/* 3830 */       return 58;
/*      */     }
/* 3832 */     if (strFieldName.equals("dif")) {
/* 3833 */       return 59;
/*      */     }
/* 3835 */     if (strFieldName.equals("paytoDate")) {
/* 3836 */       return 60;
/*      */     }
/* 3838 */     if (strFieldName.equals("firstPayDate")) {
/* 3839 */       return 61;
/*      */     }
/* 3841 */     if (strFieldName.equals("cValiDate")) {
/* 3842 */       return 62;
/*      */     }
/* 3844 */     if (strFieldName.equals("pSignDate")) {
/* 3845 */       return 63;
/*      */     }
/* 3847 */     if (strFieldName.equals("pValiDate")) {
/* 3848 */       return 64;
/*      */     }
/* 3850 */     if (strFieldName.equals("inputOperator")) {
/* 3851 */       return 65;
/*      */     }
/* 3853 */     if (strFieldName.equals("inputDate")) {
/* 3854 */       return 66;
/*      */     }
/* 3856 */     if (strFieldName.equals("inputTime")) {
/* 3857 */       return 67;
/*      */     }
/* 3859 */     if (strFieldName.equals("approveFlag")) {
/* 3860 */       return 68;
/*      */     }
/* 3862 */     if (strFieldName.equals("approveCode")) {
/* 3863 */       return 69;
/*      */     }
/* 3865 */     if (strFieldName.equals("approveDate")) {
/* 3866 */       return 70;
/*      */     }
/* 3868 */     if (strFieldName.equals("approveTime")) {
/* 3869 */       return 71;
/*      */     }
/* 3871 */     if (strFieldName.equals("uWFlag")) {
/* 3872 */       return 72;
/*      */     }
/* 3874 */     if (strFieldName.equals("uWOperator")) {
/* 3875 */       return 73;
/*      */     }
/* 3877 */     if (strFieldName.equals("uWDate")) {
/* 3878 */       return 74;
/*      */     }
/* 3880 */     if (strFieldName.equals("uWTime")) {
/* 3881 */       return 75;
/*      */     }
/* 3883 */     if (strFieldName.equals("appFlag")) {
/* 3884 */       return 76;
/*      */     }
/* 3886 */     if (strFieldName.equals("polApplyDate")) {
/* 3887 */       return 77;
/*      */     }
/* 3889 */     if (strFieldName.equals("getPolDate")) {
/* 3890 */       return 78;
/*      */     }
/* 3892 */     if (strFieldName.equals("getPolTime")) {
/* 3893 */       return 79;
/*      */     }
/* 3895 */     if (strFieldName.equals("customGetPolDate")) {
/* 3896 */       return 80;
/*      */     }
/* 3898 */     if (strFieldName.equals("state")) {
/* 3899 */       return 81;
/*      */     }
/* 3901 */     if (strFieldName.equals("saleChnlDetail")) {
/* 3902 */       return 82;
/*      */     }
/* 3904 */     if (strFieldName.equals("proposalType")) {
/* 3905 */       return 83;
/*      */     }
/* 3907 */     if (strFieldName.equals("editstate")) {
/* 3908 */       return 84;
/*      */     }
/* 3910 */     if (strFieldName.equals("cInValiDate")) {
/* 3911 */       return 85;
/*      */     }
/* 3913 */     if (strFieldName.equals("operator")) {
/* 3914 */       return 86;
/*      */     }
/* 3916 */     if (strFieldName.equals("makeDate")) {
/* 3917 */       return 87;
/*      */     }
/* 3919 */     if (strFieldName.equals("makeTime")) {
/* 3920 */       return 88;
/*      */     }
/* 3922 */     if (strFieldName.equals("modifyDate")) {
/* 3923 */       return 89;
/*      */     }
/* 3925 */     if (strFieldName.equals("modifyTime")) {
/* 3926 */       return 90;
/*      */     }
/* 3928 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 3934 */     String strFieldName = "";
/* 3935 */     switch (nFieldIndex) {
/*      */     case 0:
/* 3937 */       strFieldName = "grpContNo";
/* 3938 */       break;
/*      */     case 1:
/* 3940 */       strFieldName = "contNo";
/* 3941 */       break;
/*      */     case 2:
/* 3943 */       strFieldName = "proposalContNo";
/* 3944 */       break;
/*      */     case 3:
/* 3946 */       strFieldName = "prtNo";
/* 3947 */       break;
/*      */     case 4:
/* 3949 */       strFieldName = "mainPolNo";
/* 3950 */       break;
/*      */     case 5:
/* 3952 */       strFieldName = "contType";
/* 3953 */       break;
/*      */     case 6:
/* 3955 */       strFieldName = "familyType";
/* 3956 */       break;
/*      */     case 7:
/* 3958 */       strFieldName = "familyID";
/* 3959 */       break;
/*      */     case 8:
/* 3961 */       strFieldName = "polType";
/* 3962 */       break;
/*      */     case 9:
/* 3964 */       strFieldName = "sugNo";
/* 3965 */       break;
/*      */     case 10:
/* 3967 */       strFieldName = "cardFlag";
/* 3968 */       break;
/*      */     case 11:
/* 3970 */       strFieldName = "manageCom";
/* 3971 */       break;
/*      */     case 12:
/* 3973 */       strFieldName = "executeCom";
/* 3974 */       break;
/*      */     case 13:
/* 3976 */       strFieldName = "agentCom";
/* 3977 */       break;
/*      */     case 14:
/* 3979 */       strFieldName = "agentCode";
/* 3980 */       break;
/*      */     case 15:
/* 3982 */       strFieldName = "agentGroup";
/* 3983 */       break;
/*      */     case 16:
/* 3985 */       strFieldName = "agentCode1";
/* 3986 */       break;
/*      */     case 17:
/* 3988 */       strFieldName = "agentGroup1";
/* 3989 */       break;
/*      */     case 18:
/* 3991 */       strFieldName = "agentType";
/* 3992 */       break;
/*      */     case 19:
/* 3994 */       strFieldName = "saleChnl";
/* 3995 */       break;
/*      */     case 20:
/* 3997 */       strFieldName = "handler";
/* 3998 */       break;
/*      */     case 21:
/* 4000 */       strFieldName = "password";
/* 4001 */       break;
/*      */     case 22:
/* 4003 */       strFieldName = "appntNo";
/* 4004 */       break;
/*      */     case 23:
/* 4006 */       strFieldName = "appntId";
/* 4007 */       break;
/*      */     case 24:
/* 4009 */       strFieldName = "appntName";
/* 4010 */       break;
/*      */     case 25:
/* 4012 */       strFieldName = "appntSex";
/* 4013 */       break;
/*      */     case 26:
/* 4015 */       strFieldName = "appntBirthday";
/* 4016 */       break;
/*      */     case 27:
/* 4018 */       strFieldName = "appntIDType";
/* 4019 */       break;
/*      */     case 28:
/* 4021 */       strFieldName = "appntIDNo";
/* 4022 */       break;
/*      */     case 29:
/* 4024 */       strFieldName = "insuredNo";
/* 4025 */       break;
/*      */     case 30:
/* 4027 */       strFieldName = "insuredId";
/* 4028 */       break;
/*      */     case 31:
/* 4030 */       strFieldName = "insuredName";
/* 4031 */       break;
/*      */     case 32:
/* 4033 */       strFieldName = "insuredSex";
/* 4034 */       break;
/*      */     case 33:
/* 4036 */       strFieldName = "insuredBirthday";
/* 4037 */       break;
/*      */     case 34:
/* 4039 */       strFieldName = "insuredIDType";
/* 4040 */       break;
/*      */     case 35:
/* 4042 */       strFieldName = "insuredIDNo";
/* 4043 */       break;
/*      */     case 36:
/* 4045 */       strFieldName = "payIntv";
/* 4046 */       break;
/*      */     case 37:
/* 4048 */       strFieldName = "payMode";
/* 4049 */       break;
/*      */     case 38:
/* 4051 */       strFieldName = "payLocation";
/* 4052 */       break;
/*      */     case 39:
/* 4054 */       strFieldName = "disputedFlag";
/* 4055 */       break;
/*      */     case 40:
/* 4057 */       strFieldName = "outPayFlag";
/* 4058 */       break;
/*      */     case 41:
/* 4060 */       strFieldName = "getPolMode";
/* 4061 */       break;
/*      */     case 42:
/* 4063 */       strFieldName = "signCom";
/* 4064 */       break;
/*      */     case 43:
/* 4066 */       strFieldName = "signDate";
/* 4067 */       break;
/*      */     case 44:
/* 4069 */       strFieldName = "signTime";
/* 4070 */       break;
/*      */     case 45:
/* 4072 */       strFieldName = "consignNo";
/* 4073 */       break;
/*      */     case 46:
/* 4075 */       strFieldName = "bankCode";
/* 4076 */       break;
/*      */     case 47:
/* 4078 */       strFieldName = "bankAccNo";
/* 4079 */       break;
/*      */     case 48:
/* 4081 */       strFieldName = "accName";
/* 4082 */       break;
/*      */     case 49:
/* 4084 */       strFieldName = "printCount";
/* 4085 */       break;
/*      */     case 50:
/* 4087 */       strFieldName = "lostTimes";
/* 4088 */       break;
/*      */     case 51:
/* 4090 */       strFieldName = "lang";
/* 4091 */       break;
/*      */     case 52:
/* 4093 */       strFieldName = "currency";
/* 4094 */       break;
/*      */     case 53:
/* 4096 */       strFieldName = "remark";
/* 4097 */       break;
/*      */     case 54:
/* 4099 */       strFieldName = "peoples";
/* 4100 */       break;
/*      */     case 55:
/* 4102 */       strFieldName = "mult";
/* 4103 */       break;
/*      */     case 56:
/* 4105 */       strFieldName = "prem";
/* 4106 */       break;
/*      */     case 57:
/* 4108 */       strFieldName = "amnt";
/* 4109 */       break;
/*      */     case 58:
/* 4111 */       strFieldName = "sumPrem";
/* 4112 */       break;
/*      */     case 59:
/* 4114 */       strFieldName = "dif";
/* 4115 */       break;
/*      */     case 60:
/* 4117 */       strFieldName = "paytoDate";
/* 4118 */       break;
/*      */     case 61:
/* 4120 */       strFieldName = "firstPayDate";
/* 4121 */       break;
/*      */     case 62:
/* 4123 */       strFieldName = "cValiDate";
/* 4124 */       break;
/*      */     case 63:
/* 4126 */       strFieldName = "pSignDate";
/* 4127 */       break;
/*      */     case 64:
/* 4129 */       strFieldName = "pValiDate";
/* 4130 */       break;
/*      */     case 65:
/* 4132 */       strFieldName = "inputOperator";
/* 4133 */       break;
/*      */     case 66:
/* 4135 */       strFieldName = "inputDate";
/* 4136 */       break;
/*      */     case 67:
/* 4138 */       strFieldName = "inputTime";
/* 4139 */       break;
/*      */     case 68:
/* 4141 */       strFieldName = "approveFlag";
/* 4142 */       break;
/*      */     case 69:
/* 4144 */       strFieldName = "approveCode";
/* 4145 */       break;
/*      */     case 70:
/* 4147 */       strFieldName = "approveDate";
/* 4148 */       break;
/*      */     case 71:
/* 4150 */       strFieldName = "approveTime";
/* 4151 */       break;
/*      */     case 72:
/* 4153 */       strFieldName = "uWFlag";
/* 4154 */       break;
/*      */     case 73:
/* 4156 */       strFieldName = "uWOperator";
/* 4157 */       break;
/*      */     case 74:
/* 4159 */       strFieldName = "uWDate";
/* 4160 */       break;
/*      */     case 75:
/* 4162 */       strFieldName = "uWTime";
/* 4163 */       break;
/*      */     case 76:
/* 4165 */       strFieldName = "appFlag";
/* 4166 */       break;
/*      */     case 77:
/* 4168 */       strFieldName = "polApplyDate";
/* 4169 */       break;
/*      */     case 78:
/* 4171 */       strFieldName = "getPolDate";
/* 4172 */       break;
/*      */     case 79:
/* 4174 */       strFieldName = "getPolTime";
/* 4175 */       break;
/*      */     case 80:
/* 4177 */       strFieldName = "customGetPolDate";
/* 4178 */       break;
/*      */     case 81:
/* 4180 */       strFieldName = "state";
/* 4181 */       break;
/*      */     case 82:
/* 4183 */       strFieldName = "saleChnlDetail";
/* 4184 */       break;
/*      */     case 83:
/* 4186 */       strFieldName = "proposalType";
/* 4187 */       break;
/*      */     case 84:
/* 4189 */       strFieldName = "editstate";
/* 4190 */       break;
/*      */     case 85:
/* 4192 */       strFieldName = "cInValiDate";
/* 4193 */       break;
/*      */     case 86:
/* 4195 */       strFieldName = "operator";
/* 4196 */       break;
/*      */     case 87:
/* 4198 */       strFieldName = "makeDate";
/* 4199 */       break;
/*      */     case 88:
/* 4201 */       strFieldName = "makeTime";
/* 4202 */       break;
/*      */     case 89:
/* 4204 */       strFieldName = "modifyDate";
/* 4205 */       break;
/*      */     case 90:
/* 4207 */       strFieldName = "modifyTime";
/* 4208 */       break;
/*      */     default:
/* 4210 */       strFieldName = "";
/*      */     }
/* 4212 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 4218 */     if (strFieldName.equals("grpContNo")) {
/* 4219 */       return 0;
/*      */     }
/* 4221 */     if (strFieldName.equals("contNo")) {
/* 4222 */       return 0;
/*      */     }
/* 4224 */     if (strFieldName.equals("proposalContNo")) {
/* 4225 */       return 0;
/*      */     }
/* 4227 */     if (strFieldName.equals("prtNo")) {
/* 4228 */       return 0;
/*      */     }
/* 4230 */     if (strFieldName.equals("mainPolNo")) {
/* 4231 */       return 0;
/*      */     }
/* 4233 */     if (strFieldName.equals("contType")) {
/* 4234 */       return 0;
/*      */     }
/* 4236 */     if (strFieldName.equals("familyType")) {
/* 4237 */       return 0;
/*      */     }
/* 4239 */     if (strFieldName.equals("familyID")) {
/* 4240 */       return 0;
/*      */     }
/* 4242 */     if (strFieldName.equals("polType")) {
/* 4243 */       return 0;
/*      */     }
/* 4245 */     if (strFieldName.equals("sugNo")) {
/* 4246 */       return 0;
/*      */     }
/* 4248 */     if (strFieldName.equals("cardFlag")) {
/* 4249 */       return 0;
/*      */     }
/* 4251 */     if (strFieldName.equals("manageCom")) {
/* 4252 */       return 0;
/*      */     }
/* 4254 */     if (strFieldName.equals("executeCom")) {
/* 4255 */       return 0;
/*      */     }
/* 4257 */     if (strFieldName.equals("agentCom")) {
/* 4258 */       return 0;
/*      */     }
/* 4260 */     if (strFieldName.equals("agentCode")) {
/* 4261 */       return 0;
/*      */     }
/* 4263 */     if (strFieldName.equals("agentGroup")) {
/* 4264 */       return 0;
/*      */     }
/* 4266 */     if (strFieldName.equals("agentCode1")) {
/* 4267 */       return 0;
/*      */     }
/* 4269 */     if (strFieldName.equals("agentGroup1")) {
/* 4270 */       return 0;
/*      */     }
/* 4272 */     if (strFieldName.equals("agentType")) {
/* 4273 */       return 0;
/*      */     }
/* 4275 */     if (strFieldName.equals("saleChnl")) {
/* 4276 */       return 0;
/*      */     }
/* 4278 */     if (strFieldName.equals("handler")) {
/* 4279 */       return 0;
/*      */     }
/* 4281 */     if (strFieldName.equals("password")) {
/* 4282 */       return 0;
/*      */     }
/* 4284 */     if (strFieldName.equals("appntNo")) {
/* 4285 */       return 0;
/*      */     }
/* 4287 */     if (strFieldName.equals("appntId")) {
/* 4288 */       return 0;
/*      */     }
/* 4290 */     if (strFieldName.equals("appntName")) {
/* 4291 */       return 0;
/*      */     }
/* 4293 */     if (strFieldName.equals("appntSex")) {
/* 4294 */       return 0;
/*      */     }
/* 4296 */     if (strFieldName.equals("appntBirthday")) {
/* 4297 */       return 1;
/*      */     }
/* 4299 */     if (strFieldName.equals("appntIDType")) {
/* 4300 */       return 0;
/*      */     }
/* 4302 */     if (strFieldName.equals("appntIDNo")) {
/* 4303 */       return 0;
/*      */     }
/* 4305 */     if (strFieldName.equals("insuredNo")) {
/* 4306 */       return 0;
/*      */     }
/* 4308 */     if (strFieldName.equals("insuredId")) {
/* 4309 */       return 0;
/*      */     }
/* 4311 */     if (strFieldName.equals("insuredName")) {
/* 4312 */       return 0;
/*      */     }
/* 4314 */     if (strFieldName.equals("insuredSex")) {
/* 4315 */       return 0;
/*      */     }
/* 4317 */     if (strFieldName.equals("insuredBirthday")) {
/* 4318 */       return 1;
/*      */     }
/* 4320 */     if (strFieldName.equals("insuredIDType")) {
/* 4321 */       return 0;
/*      */     }
/* 4323 */     if (strFieldName.equals("insuredIDNo")) {
/* 4324 */       return 0;
/*      */     }
/* 4326 */     if (strFieldName.equals("payIntv")) {
/* 4327 */       return 3;
/*      */     }
/* 4329 */     if (strFieldName.equals("payMode")) {
/* 4330 */       return 0;
/*      */     }
/* 4332 */     if (strFieldName.equals("payLocation")) {
/* 4333 */       return 0;
/*      */     }
/* 4335 */     if (strFieldName.equals("disputedFlag")) {
/* 4336 */       return 0;
/*      */     }
/* 4338 */     if (strFieldName.equals("outPayFlag")) {
/* 4339 */       return 0;
/*      */     }
/* 4341 */     if (strFieldName.equals("getPolMode")) {
/* 4342 */       return 0;
/*      */     }
/* 4344 */     if (strFieldName.equals("signCom")) {
/* 4345 */       return 0;
/*      */     }
/* 4347 */     if (strFieldName.equals("signDate")) {
/* 4348 */       return 1;
/*      */     }
/* 4350 */     if (strFieldName.equals("signTime")) {
/* 4351 */       return 0;
/*      */     }
/* 4353 */     if (strFieldName.equals("consignNo")) {
/* 4354 */       return 0;
/*      */     }
/* 4356 */     if (strFieldName.equals("bankCode")) {
/* 4357 */       return 0;
/*      */     }
/* 4359 */     if (strFieldName.equals("bankAccNo")) {
/* 4360 */       return 0;
/*      */     }
/* 4362 */     if (strFieldName.equals("accName")) {
/* 4363 */       return 0;
/*      */     }
/* 4365 */     if (strFieldName.equals("printCount")) {
/* 4366 */       return 3;
/*      */     }
/* 4368 */     if (strFieldName.equals("lostTimes")) {
/* 4369 */       return 3;
/*      */     }
/* 4371 */     if (strFieldName.equals("lang")) {
/* 4372 */       return 0;
/*      */     }
/* 4374 */     if (strFieldName.equals("currency")) {
/* 4375 */       return 0;
/*      */     }
/* 4377 */     if (strFieldName.equals("remark")) {
/* 4378 */       return 0;
/*      */     }
/* 4380 */     if (strFieldName.equals("peoples")) {
/* 4381 */       return 3;
/*      */     }
/* 4383 */     if (strFieldName.equals("mult")) {
/* 4384 */       return 4;
/*      */     }
/* 4386 */     if (strFieldName.equals("prem")) {
/* 4387 */       return 4;
/*      */     }
/* 4389 */     if (strFieldName.equals("amnt")) {
/* 4390 */       return 4;
/*      */     }
/* 4392 */     if (strFieldName.equals("sumPrem")) {
/* 4393 */       return 4;
/*      */     }
/* 4395 */     if (strFieldName.equals("dif")) {
/* 4396 */       return 4;
/*      */     }
/* 4398 */     if (strFieldName.equals("paytoDate")) {
/* 4399 */       return 1;
/*      */     }
/* 4401 */     if (strFieldName.equals("firstPayDate")) {
/* 4402 */       return 1;
/*      */     }
/* 4404 */     if (strFieldName.equals("cValiDate")) {
/* 4405 */       return 1;
/*      */     }
/* 4407 */     if (strFieldName.equals("pSignDate")) {
/* 4408 */       return 1;
/*      */     }
/* 4410 */     if (strFieldName.equals("pValiDate")) {
/* 4411 */       return 1;
/*      */     }
/* 4413 */     if (strFieldName.equals("inputOperator")) {
/* 4414 */       return 0;
/*      */     }
/* 4416 */     if (strFieldName.equals("inputDate")) {
/* 4417 */       return 1;
/*      */     }
/* 4419 */     if (strFieldName.equals("inputTime")) {
/* 4420 */       return 0;
/*      */     }
/* 4422 */     if (strFieldName.equals("approveFlag")) {
/* 4423 */       return 0;
/*      */     }
/* 4425 */     if (strFieldName.equals("approveCode")) {
/* 4426 */       return 0;
/*      */     }
/* 4428 */     if (strFieldName.equals("approveDate")) {
/* 4429 */       return 1;
/*      */     }
/* 4431 */     if (strFieldName.equals("approveTime")) {
/* 4432 */       return 0;
/*      */     }
/* 4434 */     if (strFieldName.equals("uWFlag")) {
/* 4435 */       return 0;
/*      */     }
/* 4437 */     if (strFieldName.equals("uWOperator")) {
/* 4438 */       return 0;
/*      */     }
/* 4440 */     if (strFieldName.equals("uWDate")) {
/* 4441 */       return 1;
/*      */     }
/* 4443 */     if (strFieldName.equals("uWTime")) {
/* 4444 */       return 0;
/*      */     }
/* 4446 */     if (strFieldName.equals("appFlag")) {
/* 4447 */       return 0;
/*      */     }
/* 4449 */     if (strFieldName.equals("polApplyDate")) {
/* 4450 */       return 1;
/*      */     }
/* 4452 */     if (strFieldName.equals("getPolDate")) {
/* 4453 */       return 1;
/*      */     }
/* 4455 */     if (strFieldName.equals("getPolTime")) {
/* 4456 */       return 0;
/*      */     }
/* 4458 */     if (strFieldName.equals("customGetPolDate")) {
/* 4459 */       return 1;
/*      */     }
/* 4461 */     if (strFieldName.equals("state")) {
/* 4462 */       return 0;
/*      */     }
/* 4464 */     if (strFieldName.equals("saleChnlDetail")) {
/* 4465 */       return 0;
/*      */     }
/* 4467 */     if (strFieldName.equals("proposalType")) {
/* 4468 */       return 0;
/*      */     }
/* 4470 */     if (strFieldName.equals("editstate")) {
/* 4471 */       return 0;
/*      */     }
/* 4473 */     if (strFieldName.equals("cInValiDate")) {
/* 4474 */       return 1;
/*      */     }
/* 4476 */     if (strFieldName.equals("operator")) {
/* 4477 */       return 0;
/*      */     }
/* 4479 */     if (strFieldName.equals("makeDate")) {
/* 4480 */       return 1;
/*      */     }
/* 4482 */     if (strFieldName.equals("makeTime")) {
/* 4483 */       return 0;
/*      */     }
/* 4485 */     if (strFieldName.equals("modifyDate")) {
/* 4486 */       return 1;
/*      */     }
/* 4488 */     if (strFieldName.equals("modifyTime")) {
/* 4489 */       return 0;
/*      */     }
/* 4491 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 4497 */     int nFieldType = -1;
/* 4498 */     switch (nFieldIndex) {
/*      */     case 0:
/* 4500 */       nFieldType = 0;
/* 4501 */       break;
/*      */     case 1:
/* 4503 */       nFieldType = 0;
/* 4504 */       break;
/*      */     case 2:
/* 4506 */       nFieldType = 0;
/* 4507 */       break;
/*      */     case 3:
/* 4509 */       nFieldType = 0;
/* 4510 */       break;
/*      */     case 4:
/* 4512 */       nFieldType = 0;
/* 4513 */       break;
/*      */     case 5:
/* 4515 */       nFieldType = 0;
/* 4516 */       break;
/*      */     case 6:
/* 4518 */       nFieldType = 0;
/* 4519 */       break;
/*      */     case 7:
/* 4521 */       nFieldType = 0;
/* 4522 */       break;
/*      */     case 8:
/* 4524 */       nFieldType = 0;
/* 4525 */       break;
/*      */     case 9:
/* 4527 */       nFieldType = 0;
/* 4528 */       break;
/*      */     case 10:
/* 4530 */       nFieldType = 0;
/* 4531 */       break;
/*      */     case 11:
/* 4533 */       nFieldType = 0;
/* 4534 */       break;
/*      */     case 12:
/* 4536 */       nFieldType = 0;
/* 4537 */       break;
/*      */     case 13:
/* 4539 */       nFieldType = 0;
/* 4540 */       break;
/*      */     case 14:
/* 4542 */       nFieldType = 0;
/* 4543 */       break;
/*      */     case 15:
/* 4545 */       nFieldType = 0;
/* 4546 */       break;
/*      */     case 16:
/* 4548 */       nFieldType = 0;
/* 4549 */       break;
/*      */     case 17:
/* 4551 */       nFieldType = 0;
/* 4552 */       break;
/*      */     case 18:
/* 4554 */       nFieldType = 0;
/* 4555 */       break;
/*      */     case 19:
/* 4557 */       nFieldType = 0;
/* 4558 */       break;
/*      */     case 20:
/* 4560 */       nFieldType = 0;
/* 4561 */       break;
/*      */     case 21:
/* 4563 */       nFieldType = 0;
/* 4564 */       break;
/*      */     case 22:
/* 4566 */       nFieldType = 0;
/* 4567 */       break;
/*      */     case 23:
/* 4569 */       nFieldType = 0;
/* 4570 */       break;
/*      */     case 24:
/* 4572 */       nFieldType = 0;
/* 4573 */       break;
/*      */     case 25:
/* 4575 */       nFieldType = 0;
/* 4576 */       break;
/*      */     case 26:
/* 4578 */       nFieldType = 1;
/* 4579 */       break;
/*      */     case 27:
/* 4581 */       nFieldType = 0;
/* 4582 */       break;
/*      */     case 28:
/* 4584 */       nFieldType = 0;
/* 4585 */       break;
/*      */     case 29:
/* 4587 */       nFieldType = 0;
/* 4588 */       break;
/*      */     case 30:
/* 4590 */       nFieldType = 0;
/* 4591 */       break;
/*      */     case 31:
/* 4593 */       nFieldType = 0;
/* 4594 */       break;
/*      */     case 32:
/* 4596 */       nFieldType = 0;
/* 4597 */       break;
/*      */     case 33:
/* 4599 */       nFieldType = 1;
/* 4600 */       break;
/*      */     case 34:
/* 4602 */       nFieldType = 0;
/* 4603 */       break;
/*      */     case 35:
/* 4605 */       nFieldType = 0;
/* 4606 */       break;
/*      */     case 36:
/* 4608 */       nFieldType = 3;
/* 4609 */       break;
/*      */     case 37:
/* 4611 */       nFieldType = 0;
/* 4612 */       break;
/*      */     case 38:
/* 4614 */       nFieldType = 0;
/* 4615 */       break;
/*      */     case 39:
/* 4617 */       nFieldType = 0;
/* 4618 */       break;
/*      */     case 40:
/* 4620 */       nFieldType = 0;
/* 4621 */       break;
/*      */     case 41:
/* 4623 */       nFieldType = 0;
/* 4624 */       break;
/*      */     case 42:
/* 4626 */       nFieldType = 0;
/* 4627 */       break;
/*      */     case 43:
/* 4629 */       nFieldType = 1;
/* 4630 */       break;
/*      */     case 44:
/* 4632 */       nFieldType = 0;
/* 4633 */       break;
/*      */     case 45:
/* 4635 */       nFieldType = 0;
/* 4636 */       break;
/*      */     case 46:
/* 4638 */       nFieldType = 0;
/* 4639 */       break;
/*      */     case 47:
/* 4641 */       nFieldType = 0;
/* 4642 */       break;
/*      */     case 48:
/* 4644 */       nFieldType = 0;
/* 4645 */       break;
/*      */     case 49:
/* 4647 */       nFieldType = 3;
/* 4648 */       break;
/*      */     case 50:
/* 4650 */       nFieldType = 3;
/* 4651 */       break;
/*      */     case 51:
/* 4653 */       nFieldType = 0;
/* 4654 */       break;
/*      */     case 52:
/* 4656 */       nFieldType = 0;
/* 4657 */       break;
/*      */     case 53:
/* 4659 */       nFieldType = 0;
/* 4660 */       break;
/*      */     case 54:
/* 4662 */       nFieldType = 3;
/* 4663 */       break;
/*      */     case 55:
/* 4665 */       nFieldType = 4;
/* 4666 */       break;
/*      */     case 56:
/* 4668 */       nFieldType = 4;
/* 4669 */       break;
/*      */     case 57:
/* 4671 */       nFieldType = 4;
/* 4672 */       break;
/*      */     case 58:
/* 4674 */       nFieldType = 4;
/* 4675 */       break;
/*      */     case 59:
/* 4677 */       nFieldType = 4;
/* 4678 */       break;
/*      */     case 60:
/* 4680 */       nFieldType = 1;
/* 4681 */       break;
/*      */     case 61:
/* 4683 */       nFieldType = 1;
/* 4684 */       break;
/*      */     case 62:
/* 4686 */       nFieldType = 1;
/* 4687 */       break;
/*      */     case 63:
/* 4689 */       nFieldType = 1;
/* 4690 */       break;
/*      */     case 64:
/* 4692 */       nFieldType = 1;
/* 4693 */       break;
/*      */     case 65:
/* 4695 */       nFieldType = 0;
/* 4696 */       break;
/*      */     case 66:
/* 4698 */       nFieldType = 1;
/* 4699 */       break;
/*      */     case 67:
/* 4701 */       nFieldType = 0;
/* 4702 */       break;
/*      */     case 68:
/* 4704 */       nFieldType = 0;
/* 4705 */       break;
/*      */     case 69:
/* 4707 */       nFieldType = 0;
/* 4708 */       break;
/*      */     case 70:
/* 4710 */       nFieldType = 1;
/* 4711 */       break;
/*      */     case 71:
/* 4713 */       nFieldType = 0;
/* 4714 */       break;
/*      */     case 72:
/* 4716 */       nFieldType = 0;
/* 4717 */       break;
/*      */     case 73:
/* 4719 */       nFieldType = 0;
/* 4720 */       break;
/*      */     case 74:
/* 4722 */       nFieldType = 1;
/* 4723 */       break;
/*      */     case 75:
/* 4725 */       nFieldType = 0;
/* 4726 */       break;
/*      */     case 76:
/* 4728 */       nFieldType = 0;
/* 4729 */       break;
/*      */     case 77:
/* 4731 */       nFieldType = 1;
/* 4732 */       break;
/*      */     case 78:
/* 4734 */       nFieldType = 1;
/* 4735 */       break;
/*      */     case 79:
/* 4737 */       nFieldType = 0;
/* 4738 */       break;
/*      */     case 80:
/* 4740 */       nFieldType = 1;
/* 4741 */       break;
/*      */     case 81:
/* 4743 */       nFieldType = 0;
/* 4744 */       break;
/*      */     case 82:
/* 4746 */       nFieldType = 0;
/* 4747 */       break;
/*      */     case 83:
/* 4749 */       nFieldType = 0;
/* 4750 */       break;
/*      */     case 84:
/* 4752 */       nFieldType = 0;
/* 4753 */       break;
/*      */     case 85:
/* 4755 */       nFieldType = 1;
/* 4756 */       break;
/*      */     case 86:
/* 4758 */       nFieldType = 0;
/* 4759 */       break;
/*      */     case 87:
/* 4761 */       nFieldType = 1;
/* 4762 */       break;
/*      */     case 88:
/* 4764 */       nFieldType = 0;
/* 4765 */       break;
/*      */     case 89:
/* 4767 */       nFieldType = 1;
/* 4768 */       break;
/*      */     case 90:
/* 4770 */       nFieldType = 0;
/* 4771 */       break;
/*      */     default:
/* 4773 */       nFieldType = -1;
/*      */     }
/* 4775 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPContSchema
 * JD-Core Version:    0.6.0
 */