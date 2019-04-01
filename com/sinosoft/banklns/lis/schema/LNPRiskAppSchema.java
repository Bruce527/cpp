/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskAppDB;
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
/*      */ public class LNPRiskAppSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String riskCode;
/*      */   private String riskVer;
/*      */   private String riskName;
/*      */   private String kindCode;
/*      */   private String riskType;
/*      */   private String riskType1;
/*      */   private String riskType2;
/*      */   private String riskProp;
/*      */   private String riskPeriod;
/*      */   private String riskTypeDetail;
/*      */   private String riskFlag;
/*      */   private String polType;
/*      */   private String investFlag;
/*      */   private String bonusFlag;
/*      */   private String bonusMode;
/*      */   private String listFlag;
/*      */   private String subRiskFlag;
/*      */   private int calDigital;
/*      */   private String calChoMode;
/*      */   private int riskAmntMult;
/*      */   private String insuPeriodFlag;
/*      */   private int maxEndPeriod;
/*      */   private int ageLmt;
/*      */   private int signDateCalMode;
/*      */   private String protocolFlag;
/*      */   private String getChgFlag;
/*      */   private String protocolPayFlag;
/*      */   private String ensuPlanFlag;
/*      */   private String ensuPlanAdjFlag;
/*      */   private Date startDate;
/*      */   private Date endDate;
/*      */   private int minAppntAge;
/*      */   private int maxAppntAge;
/*      */   private int maxInsuredAge;
/*      */   private int minInsuredAge;
/*      */   private double appInterest;
/*      */   private double appPremRate;
/*      */   private String insuredFlag;
/*      */   private String shareFlag;
/*      */   private String bnfFlag;
/*      */   private String tempPayFlag;
/*      */   private String inpPayPlan;
/*      */   private String impartFlag;
/*      */   private String insuExpeFlag;
/*      */   private String loanFalg;
/*      */   private String mortagageFlag;
/*      */   private String iDifReturnFlag;
/*      */   private String cutAmntStopPay;
/*      */   private double rinsRate;
/*      */   private String saleFlag;
/*      */   private String fileAppFlag;
/*      */   private String mngCom;
/*      */   private String autoPayFlag;
/*      */   private String needPrintHospital;
/*      */   private String needPrintGet;
/*      */   private String riskType3;
/*      */   private String riskType4;
/*      */   private String riskType5;
/*      */   private String notPrintPol;
/*      */   private String needGetPolDate;
/*      */   private String needReReadBank;
/*      */   private String specFlag;
/*      */   private String interestDifFlag;
/*      */   public static final int FIELDNUM = 63;
/*      */   private static String[] PK;
/*  153 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPRiskAppSchema()
/*      */   {
/*  160 */     this.mErrors = new CErrors();
/*      */ 
/*  162 */     String[] pk = new String[1];
/*  163 */     pk[0] = "RiskCode";
/*      */ 
/*  165 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  172 */     LNPRiskAppSchema cloned = (LNPRiskAppSchema)super.clone();
/*  173 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  174 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  175 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  181 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getRiskCode()
/*      */   {
/*  186 */     return this.riskCode;
/*      */   }
/*      */ 
/*      */   public void setRiskCode(String aRiskCode) {
/*  190 */     this.riskCode = aRiskCode;
/*      */   }
/*      */ 
/*      */   public String getRiskVer() {
/*  194 */     return this.riskVer;
/*      */   }
/*      */ 
/*      */   public void setRiskVer(String aRiskVer) {
/*  198 */     this.riskVer = aRiskVer;
/*      */   }
/*      */ 
/*      */   public String getRiskName() {
/*  202 */     return this.riskName;
/*      */   }
/*      */ 
/*      */   public void setRiskName(String aRiskName) {
/*  206 */     this.riskName = aRiskName;
/*      */   }
/*      */ 
/*      */   public String getKindCode() {
/*  210 */     return this.kindCode;
/*      */   }
/*      */ 
/*      */   public void setKindCode(String aKindCode) {
/*  214 */     this.kindCode = aKindCode;
/*      */   }
/*      */ 
/*      */   public String getRiskType() {
/*  218 */     return this.riskType;
/*      */   }
/*      */ 
/*      */   public void setRiskType(String aRiskType) {
/*  222 */     this.riskType = aRiskType;
/*      */   }
/*      */ 
/*      */   public String getRiskType1() {
/*  226 */     return this.riskType1;
/*      */   }
/*      */ 
/*      */   public void setRiskType1(String aRiskType1) {
/*  230 */     this.riskType1 = aRiskType1;
/*      */   }
/*      */ 
/*      */   public String getRiskType2() {
/*  234 */     return this.riskType2;
/*      */   }
/*      */ 
/*      */   public void setRiskType2(String aRiskType2) {
/*  238 */     this.riskType2 = aRiskType2;
/*      */   }
/*      */ 
/*      */   public String getRiskProp() {
/*  242 */     return this.riskProp;
/*      */   }
/*      */ 
/*      */   public void setRiskProp(String aRiskProp) {
/*  246 */     this.riskProp = aRiskProp;
/*      */   }
/*      */ 
/*      */   public String getRiskPeriod() {
/*  250 */     return this.riskPeriod;
/*      */   }
/*      */ 
/*      */   public void setRiskPeriod(String aRiskPeriod) {
/*  254 */     this.riskPeriod = aRiskPeriod;
/*      */   }
/*      */ 
/*      */   public String getRiskTypeDetail() {
/*  258 */     return this.riskTypeDetail;
/*      */   }
/*      */ 
/*      */   public void setRiskTypeDetail(String aRiskTypeDetail) {
/*  262 */     this.riskTypeDetail = aRiskTypeDetail;
/*      */   }
/*      */ 
/*      */   public String getRiskFlag() {
/*  266 */     return this.riskFlag;
/*      */   }
/*      */ 
/*      */   public void setRiskFlag(String aRiskFlag) {
/*  270 */     this.riskFlag = aRiskFlag;
/*      */   }
/*      */ 
/*      */   public String getPolType() {
/*  274 */     return this.polType;
/*      */   }
/*      */ 
/*      */   public void setPolType(String aPolType) {
/*  278 */     this.polType = aPolType;
/*      */   }
/*      */ 
/*      */   public String getInvestFlag() {
/*  282 */     return this.investFlag;
/*      */   }
/*      */ 
/*      */   public void setInvestFlag(String aInvestFlag) {
/*  286 */     this.investFlag = aInvestFlag;
/*      */   }
/*      */ 
/*      */   public String getBonusFlag() {
/*  290 */     return this.bonusFlag;
/*      */   }
/*      */ 
/*      */   public void setBonusFlag(String aBonusFlag) {
/*  294 */     this.bonusFlag = aBonusFlag;
/*      */   }
/*      */ 
/*      */   public String getBonusMode() {
/*  298 */     return this.bonusMode;
/*      */   }
/*      */ 
/*      */   public void setBonusMode(String aBonusMode) {
/*  302 */     this.bonusMode = aBonusMode;
/*      */   }
/*      */ 
/*      */   public String getListFlag() {
/*  306 */     return this.listFlag;
/*      */   }
/*      */ 
/*      */   public void setListFlag(String aListFlag) {
/*  310 */     this.listFlag = aListFlag;
/*      */   }
/*      */ 
/*      */   public String getSubRiskFlag() {
/*  314 */     return this.subRiskFlag;
/*      */   }
/*      */ 
/*      */   public void setSubRiskFlag(String aSubRiskFlag) {
/*  318 */     this.subRiskFlag = aSubRiskFlag;
/*      */   }
/*      */ 
/*      */   public int getCalDigital() {
/*  322 */     return this.calDigital;
/*      */   }
/*      */ 
/*      */   public void setCalDigital(int aCalDigital) {
/*  326 */     this.calDigital = aCalDigital;
/*      */   }
/*      */ 
/*      */   public void setCalDigital(String aCalDigital) {
/*  330 */     if ((aCalDigital != null) && (!aCalDigital.equals("")))
/*      */     {
/*  332 */       Integer tInteger = new Integer(aCalDigital);
/*  333 */       int i = tInteger.intValue();
/*  334 */       this.calDigital = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getCalChoMode()
/*      */   {
/*  340 */     return this.calChoMode;
/*      */   }
/*      */ 
/*      */   public void setCalChoMode(String aCalChoMode) {
/*  344 */     this.calChoMode = aCalChoMode;
/*      */   }
/*      */ 
/*      */   public int getRiskAmntMult() {
/*  348 */     return this.riskAmntMult;
/*      */   }
/*      */ 
/*      */   public void setRiskAmntMult(int aRiskAmntMult) {
/*  352 */     this.riskAmntMult = aRiskAmntMult;
/*      */   }
/*      */ 
/*      */   public void setRiskAmntMult(String aRiskAmntMult) {
/*  356 */     if ((aRiskAmntMult != null) && (!aRiskAmntMult.equals("")))
/*      */     {
/*  358 */       Integer tInteger = new Integer(aRiskAmntMult);
/*  359 */       int i = tInteger.intValue();
/*  360 */       this.riskAmntMult = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getInsuPeriodFlag()
/*      */   {
/*  366 */     return this.insuPeriodFlag;
/*      */   }
/*      */ 
/*      */   public void setInsuPeriodFlag(String aInsuPeriodFlag) {
/*  370 */     this.insuPeriodFlag = aInsuPeriodFlag;
/*      */   }
/*      */ 
/*      */   public int getMaxEndPeriod() {
/*  374 */     return this.maxEndPeriod;
/*      */   }
/*      */ 
/*      */   public void setMaxEndPeriod(int aMaxEndPeriod) {
/*  378 */     this.maxEndPeriod = aMaxEndPeriod;
/*      */   }
/*      */ 
/*      */   public void setMaxEndPeriod(String aMaxEndPeriod) {
/*  382 */     if ((aMaxEndPeriod != null) && (!aMaxEndPeriod.equals("")))
/*      */     {
/*  384 */       Integer tInteger = new Integer(aMaxEndPeriod);
/*  385 */       int i = tInteger.intValue();
/*  386 */       this.maxEndPeriod = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getAgeLmt()
/*      */   {
/*  392 */     return this.ageLmt;
/*      */   }
/*      */ 
/*      */   public void setAgeLmt(int aAgeLmt) {
/*  396 */     this.ageLmt = aAgeLmt;
/*      */   }
/*      */ 
/*      */   public void setAgeLmt(String aAgeLmt) {
/*  400 */     if ((aAgeLmt != null) && (!aAgeLmt.equals("")))
/*      */     {
/*  402 */       Integer tInteger = new Integer(aAgeLmt);
/*  403 */       int i = tInteger.intValue();
/*  404 */       this.ageLmt = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getSignDateCalMode()
/*      */   {
/*  410 */     return this.signDateCalMode;
/*      */   }
/*      */ 
/*      */   public void setSignDateCalMode(int aSignDateCalMode) {
/*  414 */     this.signDateCalMode = aSignDateCalMode;
/*      */   }
/*      */ 
/*      */   public void setSignDateCalMode(String aSignDateCalMode) {
/*  418 */     if ((aSignDateCalMode != null) && (!aSignDateCalMode.equals("")))
/*      */     {
/*  420 */       Integer tInteger = new Integer(aSignDateCalMode);
/*  421 */       int i = tInteger.intValue();
/*  422 */       this.signDateCalMode = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getProtocolFlag()
/*      */   {
/*  428 */     return this.protocolFlag;
/*      */   }
/*      */ 
/*      */   public void setProtocolFlag(String aProtocolFlag) {
/*  432 */     this.protocolFlag = aProtocolFlag;
/*      */   }
/*      */ 
/*      */   public String getGetChgFlag() {
/*  436 */     return this.getChgFlag;
/*      */   }
/*      */ 
/*      */   public void setGetChgFlag(String aGetChgFlag) {
/*  440 */     this.getChgFlag = aGetChgFlag;
/*      */   }
/*      */ 
/*      */   public String getProtocolPayFlag() {
/*  444 */     return this.protocolPayFlag;
/*      */   }
/*      */ 
/*      */   public void setProtocolPayFlag(String aProtocolPayFlag) {
/*  448 */     this.protocolPayFlag = aProtocolPayFlag;
/*      */   }
/*      */ 
/*      */   public String getEnsuPlanFlag() {
/*  452 */     return this.ensuPlanFlag;
/*      */   }
/*      */ 
/*      */   public void setEnsuPlanFlag(String aEnsuPlanFlag) {
/*  456 */     this.ensuPlanFlag = aEnsuPlanFlag;
/*      */   }
/*      */ 
/*      */   public String getEnsuPlanAdjFlag() {
/*  460 */     return this.ensuPlanAdjFlag;
/*      */   }
/*      */ 
/*      */   public void setEnsuPlanAdjFlag(String aEnsuPlanAdjFlag) {
/*  464 */     this.ensuPlanAdjFlag = aEnsuPlanAdjFlag;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  468 */     if (this.startDate != null) {
/*  469 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  471 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  475 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  479 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  481 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  484 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  489 */     if (this.endDate != null) {
/*  490 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  492 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  496 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  500 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  502 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  505 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public int getMinAppntAge()
/*      */   {
/*  510 */     return this.minAppntAge;
/*      */   }
/*      */ 
/*      */   public void setMinAppntAge(int aMinAppntAge) {
/*  514 */     this.minAppntAge = aMinAppntAge;
/*      */   }
/*      */ 
/*      */   public void setMinAppntAge(String aMinAppntAge) {
/*  518 */     if ((aMinAppntAge != null) && (!aMinAppntAge.equals("")))
/*      */     {
/*  520 */       Integer tInteger = new Integer(aMinAppntAge);
/*  521 */       int i = tInteger.intValue();
/*  522 */       this.minAppntAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getMaxAppntAge()
/*      */   {
/*  528 */     return this.maxAppntAge;
/*      */   }
/*      */ 
/*      */   public void setMaxAppntAge(int aMaxAppntAge) {
/*  532 */     this.maxAppntAge = aMaxAppntAge;
/*      */   }
/*      */ 
/*      */   public void setMaxAppntAge(String aMaxAppntAge) {
/*  536 */     if ((aMaxAppntAge != null) && (!aMaxAppntAge.equals("")))
/*      */     {
/*  538 */       Integer tInteger = new Integer(aMaxAppntAge);
/*  539 */       int i = tInteger.intValue();
/*  540 */       this.maxAppntAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getMaxInsuredAge()
/*      */   {
/*  546 */     return this.maxInsuredAge;
/*      */   }
/*      */ 
/*      */   public void setMaxInsuredAge(int aMaxInsuredAge) {
/*  550 */     this.maxInsuredAge = aMaxInsuredAge;
/*      */   }
/*      */ 
/*      */   public void setMaxInsuredAge(String aMaxInsuredAge) {
/*  554 */     if ((aMaxInsuredAge != null) && (!aMaxInsuredAge.equals("")))
/*      */     {
/*  556 */       Integer tInteger = new Integer(aMaxInsuredAge);
/*  557 */       int i = tInteger.intValue();
/*  558 */       this.maxInsuredAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getMinInsuredAge()
/*      */   {
/*  564 */     return this.minInsuredAge;
/*      */   }
/*      */ 
/*      */   public void setMinInsuredAge(int aMinInsuredAge) {
/*  568 */     this.minInsuredAge = aMinInsuredAge;
/*      */   }
/*      */ 
/*      */   public void setMinInsuredAge(String aMinInsuredAge) {
/*  572 */     if ((aMinInsuredAge != null) && (!aMinInsuredAge.equals("")))
/*      */     {
/*  574 */       Integer tInteger = new Integer(aMinInsuredAge);
/*  575 */       int i = tInteger.intValue();
/*  576 */       this.minInsuredAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAppInterest()
/*      */   {
/*  582 */     return this.appInterest;
/*      */   }
/*      */ 
/*      */   public void setAppInterest(double aAppInterest) {
/*  586 */     this.appInterest = aAppInterest;
/*      */   }
/*      */ 
/*      */   public void setAppInterest(String aAppInterest) {
/*  590 */     if ((aAppInterest != null) && (!aAppInterest.equals("")))
/*      */     {
/*  592 */       Double tDouble = new Double(aAppInterest);
/*  593 */       double d = tDouble.doubleValue();
/*  594 */       this.appInterest = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAppPremRate()
/*      */   {
/*  600 */     return this.appPremRate;
/*      */   }
/*      */ 
/*      */   public void setAppPremRate(double aAppPremRate) {
/*  604 */     this.appPremRate = aAppPremRate;
/*      */   }
/*      */ 
/*      */   public void setAppPremRate(String aAppPremRate) {
/*  608 */     if ((aAppPremRate != null) && (!aAppPremRate.equals("")))
/*      */     {
/*  610 */       Double tDouble = new Double(aAppPremRate);
/*  611 */       double d = tDouble.doubleValue();
/*  612 */       this.appPremRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getInsuredFlag()
/*      */   {
/*  618 */     return this.insuredFlag;
/*      */   }
/*      */ 
/*      */   public void setInsuredFlag(String aInsuredFlag) {
/*  622 */     this.insuredFlag = aInsuredFlag;
/*      */   }
/*      */ 
/*      */   public String getShareFlag() {
/*  626 */     return this.shareFlag;
/*      */   }
/*      */ 
/*      */   public void setShareFlag(String aShareFlag) {
/*  630 */     this.shareFlag = aShareFlag;
/*      */   }
/*      */ 
/*      */   public String getBnfFlag() {
/*  634 */     return this.bnfFlag;
/*      */   }
/*      */ 
/*      */   public void setBnfFlag(String aBnfFlag) {
/*  638 */     this.bnfFlag = aBnfFlag;
/*      */   }
/*      */ 
/*      */   public String getTempPayFlag() {
/*  642 */     return this.tempPayFlag;
/*      */   }
/*      */ 
/*      */   public void setTempPayFlag(String aTempPayFlag) {
/*  646 */     this.tempPayFlag = aTempPayFlag;
/*      */   }
/*      */ 
/*      */   public String getInpPayPlan() {
/*  650 */     return this.inpPayPlan;
/*      */   }
/*      */ 
/*      */   public void setInpPayPlan(String aInpPayPlan) {
/*  654 */     this.inpPayPlan = aInpPayPlan;
/*      */   }
/*      */ 
/*      */   public String getImpartFlag() {
/*  658 */     return this.impartFlag;
/*      */   }
/*      */ 
/*      */   public void setImpartFlag(String aImpartFlag) {
/*  662 */     this.impartFlag = aImpartFlag;
/*      */   }
/*      */ 
/*      */   public String getInsuExpeFlag() {
/*  666 */     return this.insuExpeFlag;
/*      */   }
/*      */ 
/*      */   public void setInsuExpeFlag(String aInsuExpeFlag) {
/*  670 */     this.insuExpeFlag = aInsuExpeFlag;
/*      */   }
/*      */ 
/*      */   public String getLoanFalg() {
/*  674 */     return this.loanFalg;
/*      */   }
/*      */ 
/*      */   public void setLoanFalg(String aLoanFalg) {
/*  678 */     this.loanFalg = aLoanFalg;
/*      */   }
/*      */ 
/*      */   public String getMortagageFlag() {
/*  682 */     return this.mortagageFlag;
/*      */   }
/*      */ 
/*      */   public void setMortagageFlag(String aMortagageFlag) {
/*  686 */     this.mortagageFlag = aMortagageFlag;
/*      */   }
/*      */ 
/*      */   public String getIDifReturnFlag() {
/*  690 */     return this.iDifReturnFlag;
/*      */   }
/*      */ 
/*      */   public void setIDifReturnFlag(String aIDifReturnFlag) {
/*  694 */     this.iDifReturnFlag = aIDifReturnFlag;
/*      */   }
/*      */ 
/*      */   public String getCutAmntStopPay() {
/*  698 */     return this.cutAmntStopPay;
/*      */   }
/*      */ 
/*      */   public void setCutAmntStopPay(String aCutAmntStopPay) {
/*  702 */     this.cutAmntStopPay = aCutAmntStopPay;
/*      */   }
/*      */ 
/*      */   public double getRinsRate() {
/*  706 */     return this.rinsRate;
/*      */   }
/*      */ 
/*      */   public void setRinsRate(double aRinsRate) {
/*  710 */     this.rinsRate = aRinsRate;
/*      */   }
/*      */ 
/*      */   public void setRinsRate(String aRinsRate) {
/*  714 */     if ((aRinsRate != null) && (!aRinsRate.equals("")))
/*      */     {
/*  716 */       Double tDouble = new Double(aRinsRate);
/*  717 */       double d = tDouble.doubleValue();
/*  718 */       this.rinsRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getSaleFlag()
/*      */   {
/*  724 */     return this.saleFlag;
/*      */   }
/*      */ 
/*      */   public void setSaleFlag(String aSaleFlag) {
/*  728 */     this.saleFlag = aSaleFlag;
/*      */   }
/*      */ 
/*      */   public String getFileAppFlag() {
/*  732 */     return this.fileAppFlag;
/*      */   }
/*      */ 
/*      */   public void setFileAppFlag(String aFileAppFlag) {
/*  736 */     this.fileAppFlag = aFileAppFlag;
/*      */   }
/*      */ 
/*      */   public String getMngCom() {
/*  740 */     return this.mngCom;
/*      */   }
/*      */ 
/*      */   public void setMngCom(String aMngCom) {
/*  744 */     this.mngCom = aMngCom;
/*      */   }
/*      */ 
/*      */   public String getAutoPayFlag() {
/*  748 */     return this.autoPayFlag;
/*      */   }
/*      */ 
/*      */   public void setAutoPayFlag(String aAutoPayFlag) {
/*  752 */     this.autoPayFlag = aAutoPayFlag;
/*      */   }
/*      */ 
/*      */   public String getNeedPrintHospital() {
/*  756 */     return this.needPrintHospital;
/*      */   }
/*      */ 
/*      */   public void setNeedPrintHospital(String aNeedPrintHospital) {
/*  760 */     this.needPrintHospital = aNeedPrintHospital;
/*      */   }
/*      */ 
/*      */   public String getNeedPrintGet() {
/*  764 */     return this.needPrintGet;
/*      */   }
/*      */ 
/*      */   public void setNeedPrintGet(String aNeedPrintGet) {
/*  768 */     this.needPrintGet = aNeedPrintGet;
/*      */   }
/*      */ 
/*      */   public String getRiskType3() {
/*  772 */     return this.riskType3;
/*      */   }
/*      */ 
/*      */   public void setRiskType3(String aRiskType3) {
/*  776 */     this.riskType3 = aRiskType3;
/*      */   }
/*      */ 
/*      */   public String getRiskType4() {
/*  780 */     return this.riskType4;
/*      */   }
/*      */ 
/*      */   public void setRiskType4(String aRiskType4) {
/*  784 */     this.riskType4 = aRiskType4;
/*      */   }
/*      */ 
/*      */   public String getRiskType5() {
/*  788 */     return this.riskType5;
/*      */   }
/*      */ 
/*      */   public void setRiskType5(String aRiskType5) {
/*  792 */     this.riskType5 = aRiskType5;
/*      */   }
/*      */ 
/*      */   public String getNotPrintPol() {
/*  796 */     return this.notPrintPol;
/*      */   }
/*      */ 
/*      */   public void setNotPrintPol(String aNotPrintPol) {
/*  800 */     this.notPrintPol = aNotPrintPol;
/*      */   }
/*      */ 
/*      */   public String getNeedGetPolDate() {
/*  804 */     return this.needGetPolDate;
/*      */   }
/*      */ 
/*      */   public void setNeedGetPolDate(String aNeedGetPolDate) {
/*  808 */     this.needGetPolDate = aNeedGetPolDate;
/*      */   }
/*      */ 
/*      */   public String getNeedReReadBank() {
/*  812 */     return this.needReReadBank;
/*      */   }
/*      */ 
/*      */   public void setNeedReReadBank(String aNeedReReadBank) {
/*  816 */     this.needReReadBank = aNeedReReadBank;
/*      */   }
/*      */ 
/*      */   public String getSpecFlag() {
/*  820 */     return this.specFlag;
/*      */   }
/*      */ 
/*      */   public void setSpecFlag(String aSpecFlag) {
/*  824 */     this.specFlag = aSpecFlag;
/*      */   }
/*      */ 
/*      */   public String getInterestDifFlag() {
/*  828 */     return this.interestDifFlag;
/*      */   }
/*      */ 
/*      */   public void setInterestDifFlag(String aInterestDifFlag) {
/*  832 */     this.interestDifFlag = aInterestDifFlag;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPRiskAppSchema aLNPRiskAppSchema)
/*      */   {
/*  838 */     this.riskCode = aLNPRiskAppSchema.getRiskCode();
/*  839 */     this.riskVer = aLNPRiskAppSchema.getRiskVer();
/*  840 */     this.riskName = aLNPRiskAppSchema.getRiskName();
/*  841 */     this.kindCode = aLNPRiskAppSchema.getKindCode();
/*  842 */     this.riskType = aLNPRiskAppSchema.getRiskType();
/*  843 */     this.riskType1 = aLNPRiskAppSchema.getRiskType1();
/*  844 */     this.riskType2 = aLNPRiskAppSchema.getRiskType2();
/*  845 */     this.riskProp = aLNPRiskAppSchema.getRiskProp();
/*  846 */     this.riskPeriod = aLNPRiskAppSchema.getRiskPeriod();
/*  847 */     this.riskTypeDetail = aLNPRiskAppSchema.getRiskTypeDetail();
/*  848 */     this.riskFlag = aLNPRiskAppSchema.getRiskFlag();
/*  849 */     this.polType = aLNPRiskAppSchema.getPolType();
/*  850 */     this.investFlag = aLNPRiskAppSchema.getInvestFlag();
/*  851 */     this.bonusFlag = aLNPRiskAppSchema.getBonusFlag();
/*  852 */     this.bonusMode = aLNPRiskAppSchema.getBonusMode();
/*  853 */     this.listFlag = aLNPRiskAppSchema.getListFlag();
/*  854 */     this.subRiskFlag = aLNPRiskAppSchema.getSubRiskFlag();
/*  855 */     this.calDigital = aLNPRiskAppSchema.getCalDigital();
/*  856 */     this.calChoMode = aLNPRiskAppSchema.getCalChoMode();
/*  857 */     this.riskAmntMult = aLNPRiskAppSchema.getRiskAmntMult();
/*  858 */     this.insuPeriodFlag = aLNPRiskAppSchema.getInsuPeriodFlag();
/*  859 */     this.maxEndPeriod = aLNPRiskAppSchema.getMaxEndPeriod();
/*  860 */     this.ageLmt = aLNPRiskAppSchema.getAgeLmt();
/*  861 */     this.signDateCalMode = aLNPRiskAppSchema.getSignDateCalMode();
/*  862 */     this.protocolFlag = aLNPRiskAppSchema.getProtocolFlag();
/*  863 */     this.getChgFlag = aLNPRiskAppSchema.getGetChgFlag();
/*  864 */     this.protocolPayFlag = aLNPRiskAppSchema.getProtocolPayFlag();
/*  865 */     this.ensuPlanFlag = aLNPRiskAppSchema.getEnsuPlanFlag();
/*  866 */     this.ensuPlanAdjFlag = aLNPRiskAppSchema.getEnsuPlanAdjFlag();
/*  867 */     this.startDate = this.fDate.getDate(aLNPRiskAppSchema.getStartDate());
/*  868 */     this.endDate = this.fDate.getDate(aLNPRiskAppSchema.getEndDate());
/*  869 */     this.minAppntAge = aLNPRiskAppSchema.getMinAppntAge();
/*  870 */     this.maxAppntAge = aLNPRiskAppSchema.getMaxAppntAge();
/*  871 */     this.maxInsuredAge = aLNPRiskAppSchema.getMaxInsuredAge();
/*  872 */     this.minInsuredAge = aLNPRiskAppSchema.getMinInsuredAge();
/*  873 */     this.appInterest = aLNPRiskAppSchema.getAppInterest();
/*  874 */     this.appPremRate = aLNPRiskAppSchema.getAppPremRate();
/*  875 */     this.insuredFlag = aLNPRiskAppSchema.getInsuredFlag();
/*  876 */     this.shareFlag = aLNPRiskAppSchema.getShareFlag();
/*  877 */     this.bnfFlag = aLNPRiskAppSchema.getBnfFlag();
/*  878 */     this.tempPayFlag = aLNPRiskAppSchema.getTempPayFlag();
/*  879 */     this.inpPayPlan = aLNPRiskAppSchema.getInpPayPlan();
/*  880 */     this.impartFlag = aLNPRiskAppSchema.getImpartFlag();
/*  881 */     this.insuExpeFlag = aLNPRiskAppSchema.getInsuExpeFlag();
/*  882 */     this.loanFalg = aLNPRiskAppSchema.getLoanFalg();
/*  883 */     this.mortagageFlag = aLNPRiskAppSchema.getMortagageFlag();
/*  884 */     this.iDifReturnFlag = aLNPRiskAppSchema.getIDifReturnFlag();
/*  885 */     this.cutAmntStopPay = aLNPRiskAppSchema.getCutAmntStopPay();
/*  886 */     this.rinsRate = aLNPRiskAppSchema.getRinsRate();
/*  887 */     this.saleFlag = aLNPRiskAppSchema.getSaleFlag();
/*  888 */     this.fileAppFlag = aLNPRiskAppSchema.getFileAppFlag();
/*  889 */     this.mngCom = aLNPRiskAppSchema.getMngCom();
/*  890 */     this.autoPayFlag = aLNPRiskAppSchema.getAutoPayFlag();
/*  891 */     this.needPrintHospital = aLNPRiskAppSchema.getNeedPrintHospital();
/*  892 */     this.needPrintGet = aLNPRiskAppSchema.getNeedPrintGet();
/*  893 */     this.riskType3 = aLNPRiskAppSchema.getRiskType3();
/*  894 */     this.riskType4 = aLNPRiskAppSchema.getRiskType4();
/*  895 */     this.riskType5 = aLNPRiskAppSchema.getRiskType5();
/*  896 */     this.notPrintPol = aLNPRiskAppSchema.getNotPrintPol();
/*  897 */     this.needGetPolDate = aLNPRiskAppSchema.getNeedGetPolDate();
/*  898 */     this.needReReadBank = aLNPRiskAppSchema.getNeedReReadBank();
/*  899 */     this.specFlag = aLNPRiskAppSchema.getSpecFlag();
/*  900 */     this.interestDifFlag = aLNPRiskAppSchema.getInterestDifFlag();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  909 */       if (rs.getString("RiskCode") == null)
/*  910 */         this.riskCode = null;
/*      */       else {
/*  912 */         this.riskCode = rs.getString("RiskCode").trim();
/*      */       }
/*  914 */       if (rs.getString("RiskVer") == null)
/*  915 */         this.riskVer = null;
/*      */       else {
/*  917 */         this.riskVer = rs.getString("RiskVer").trim();
/*      */       }
/*  919 */       if (rs.getString("RiskName") == null)
/*  920 */         this.riskName = null;
/*      */       else {
/*  922 */         this.riskName = rs.getString("RiskName").trim();
/*      */       }
/*  924 */       if (rs.getString("KindCode") == null)
/*  925 */         this.kindCode = null;
/*      */       else {
/*  927 */         this.kindCode = rs.getString("KindCode").trim();
/*      */       }
/*  929 */       if (rs.getString("RiskType") == null)
/*  930 */         this.riskType = null;
/*      */       else {
/*  932 */         this.riskType = rs.getString("RiskType").trim();
/*      */       }
/*  934 */       if (rs.getString("RiskType1") == null)
/*  935 */         this.riskType1 = null;
/*      */       else {
/*  937 */         this.riskType1 = rs.getString("RiskType1").trim();
/*      */       }
/*  939 */       if (rs.getString("RiskType2") == null)
/*  940 */         this.riskType2 = null;
/*      */       else {
/*  942 */         this.riskType2 = rs.getString("RiskType2").trim();
/*      */       }
/*  944 */       if (rs.getString("RiskProp") == null)
/*  945 */         this.riskProp = null;
/*      */       else {
/*  947 */         this.riskProp = rs.getString("RiskProp").trim();
/*      */       }
/*  949 */       if (rs.getString("RiskPeriod") == null)
/*  950 */         this.riskPeriod = null;
/*      */       else {
/*  952 */         this.riskPeriod = rs.getString("RiskPeriod").trim();
/*      */       }
/*  954 */       if (rs.getString("RiskTypeDetail") == null)
/*  955 */         this.riskTypeDetail = null;
/*      */       else {
/*  957 */         this.riskTypeDetail = rs.getString("RiskTypeDetail").trim();
/*      */       }
/*  959 */       if (rs.getString("RiskFlag") == null)
/*  960 */         this.riskFlag = null;
/*      */       else {
/*  962 */         this.riskFlag = rs.getString("RiskFlag").trim();
/*      */       }
/*  964 */       if (rs.getString("PolType") == null)
/*  965 */         this.polType = null;
/*      */       else {
/*  967 */         this.polType = rs.getString("PolType").trim();
/*      */       }
/*  969 */       if (rs.getString("InvestFlag") == null)
/*  970 */         this.investFlag = null;
/*      */       else {
/*  972 */         this.investFlag = rs.getString("InvestFlag").trim();
/*      */       }
/*  974 */       if (rs.getString("BonusFlag") == null)
/*  975 */         this.bonusFlag = null;
/*      */       else {
/*  977 */         this.bonusFlag = rs.getString("BonusFlag").trim();
/*      */       }
/*  979 */       if (rs.getString("BonusMode") == null)
/*  980 */         this.bonusMode = null;
/*      */       else {
/*  982 */         this.bonusMode = rs.getString("BonusMode").trim();
/*      */       }
/*  984 */       if (rs.getString("ListFlag") == null)
/*  985 */         this.listFlag = null;
/*      */       else {
/*  987 */         this.listFlag = rs.getString("ListFlag").trim();
/*      */       }
/*  989 */       if (rs.getString("SubRiskFlag") == null)
/*  990 */         this.subRiskFlag = null;
/*      */       else {
/*  992 */         this.subRiskFlag = rs.getString("SubRiskFlag").trim();
/*      */       }
/*  994 */       this.calDigital = rs.getInt("CalDigital");
/*  995 */       if (rs.getString("CalChoMode") == null)
/*  996 */         this.calChoMode = null;
/*      */       else {
/*  998 */         this.calChoMode = rs.getString("CalChoMode").trim();
/*      */       }
/* 1000 */       this.riskAmntMult = rs.getInt("RiskAmntMult");
/* 1001 */       if (rs.getString("InsuPeriodFlag") == null)
/* 1002 */         this.insuPeriodFlag = null;
/*      */       else {
/* 1004 */         this.insuPeriodFlag = rs.getString("InsuPeriodFlag").trim();
/*      */       }
/* 1006 */       this.maxEndPeriod = rs.getInt("MaxEndPeriod");
/* 1007 */       this.ageLmt = rs.getInt("AgeLmt");
/* 1008 */       this.signDateCalMode = rs.getInt("SignDateCalMode");
/* 1009 */       if (rs.getString("ProtocolFlag") == null)
/* 1010 */         this.protocolFlag = null;
/*      */       else {
/* 1012 */         this.protocolFlag = rs.getString("ProtocolFlag").trim();
/*      */       }
/* 1014 */       if (rs.getString("GetChgFlag") == null)
/* 1015 */         this.getChgFlag = null;
/*      */       else {
/* 1017 */         this.getChgFlag = rs.getString("GetChgFlag").trim();
/*      */       }
/* 1019 */       if (rs.getString("ProtocolPayFlag") == null)
/* 1020 */         this.protocolPayFlag = null;
/*      */       else {
/* 1022 */         this.protocolPayFlag = rs.getString("ProtocolPayFlag").trim();
/*      */       }
/* 1024 */       if (rs.getString("EnsuPlanFlag") == null)
/* 1025 */         this.ensuPlanFlag = null;
/*      */       else {
/* 1027 */         this.ensuPlanFlag = rs.getString("EnsuPlanFlag").trim();
/*      */       }
/* 1029 */       if (rs.getString("EnsuPlanAdjFlag") == null)
/* 1030 */         this.ensuPlanAdjFlag = null;
/*      */       else {
/* 1032 */         this.ensuPlanAdjFlag = rs.getString("EnsuPlanAdjFlag").trim();
/*      */       }
/* 1034 */       this.startDate = rs.getDate("StartDate");
/* 1035 */       this.endDate = rs.getDate("EndDate");
/* 1036 */       this.minAppntAge = rs.getInt("MinAppntAge");
/* 1037 */       this.maxAppntAge = rs.getInt("MaxAppntAge");
/* 1038 */       this.maxInsuredAge = rs.getInt("MaxInsuredAge");
/* 1039 */       this.minInsuredAge = rs.getInt("MinInsuredAge");
/* 1040 */       this.appInterest = rs.getDouble("AppInterest");
/* 1041 */       this.appPremRate = rs.getDouble("AppPremRate");
/* 1042 */       if (rs.getString("InsuredFlag") == null)
/* 1043 */         this.insuredFlag = null;
/*      */       else {
/* 1045 */         this.insuredFlag = rs.getString("InsuredFlag").trim();
/*      */       }
/* 1047 */       if (rs.getString("ShareFlag") == null)
/* 1048 */         this.shareFlag = null;
/*      */       else {
/* 1050 */         this.shareFlag = rs.getString("ShareFlag").trim();
/*      */       }
/* 1052 */       if (rs.getString("BnfFlag") == null)
/* 1053 */         this.bnfFlag = null;
/*      */       else {
/* 1055 */         this.bnfFlag = rs.getString("BnfFlag").trim();
/*      */       }
/* 1057 */       if (rs.getString("TempPayFlag") == null)
/* 1058 */         this.tempPayFlag = null;
/*      */       else {
/* 1060 */         this.tempPayFlag = rs.getString("TempPayFlag").trim();
/*      */       }
/* 1062 */       if (rs.getString("InpPayPlan") == null)
/* 1063 */         this.inpPayPlan = null;
/*      */       else {
/* 1065 */         this.inpPayPlan = rs.getString("InpPayPlan").trim();
/*      */       }
/* 1067 */       if (rs.getString("ImpartFlag") == null)
/* 1068 */         this.impartFlag = null;
/*      */       else {
/* 1070 */         this.impartFlag = rs.getString("ImpartFlag").trim();
/*      */       }
/* 1072 */       if (rs.getString("InsuExpeFlag") == null)
/* 1073 */         this.insuExpeFlag = null;
/*      */       else {
/* 1075 */         this.insuExpeFlag = rs.getString("InsuExpeFlag").trim();
/*      */       }
/* 1077 */       if (rs.getString("LoanFalg") == null)
/* 1078 */         this.loanFalg = null;
/*      */       else {
/* 1080 */         this.loanFalg = rs.getString("LoanFalg").trim();
/*      */       }
/* 1082 */       if (rs.getString("MortagageFlag") == null)
/* 1083 */         this.mortagageFlag = null;
/*      */       else {
/* 1085 */         this.mortagageFlag = rs.getString("MortagageFlag").trim();
/*      */       }
/* 1087 */       if (rs.getString("IDifReturnFlag") == null)
/* 1088 */         this.iDifReturnFlag = null;
/*      */       else {
/* 1090 */         this.iDifReturnFlag = rs.getString("IDifReturnFlag").trim();
/*      */       }
/* 1092 */       if (rs.getString("CutAmntStopPay") == null)
/* 1093 */         this.cutAmntStopPay = null;
/*      */       else {
/* 1095 */         this.cutAmntStopPay = rs.getString("CutAmntStopPay").trim();
/*      */       }
/* 1097 */       this.rinsRate = rs.getDouble("RinsRate");
/* 1098 */       if (rs.getString("SaleFlag") == null)
/* 1099 */         this.saleFlag = null;
/*      */       else {
/* 1101 */         this.saleFlag = rs.getString("SaleFlag").trim();
/*      */       }
/* 1103 */       if (rs.getString("FileAppFlag") == null)
/* 1104 */         this.fileAppFlag = null;
/*      */       else {
/* 1106 */         this.fileAppFlag = rs.getString("FileAppFlag").trim();
/*      */       }
/* 1108 */       if (rs.getString("MngCom") == null)
/* 1109 */         this.mngCom = null;
/*      */       else {
/* 1111 */         this.mngCom = rs.getString("MngCom").trim();
/*      */       }
/* 1113 */       if (rs.getString("AutoPayFlag") == null)
/* 1114 */         this.autoPayFlag = null;
/*      */       else {
/* 1116 */         this.autoPayFlag = rs.getString("AutoPayFlag").trim();
/*      */       }
/* 1118 */       if (rs.getString("NeedPrintHospital") == null)
/* 1119 */         this.needPrintHospital = null;
/*      */       else {
/* 1121 */         this.needPrintHospital = rs.getString("NeedPrintHospital").trim();
/*      */       }
/* 1123 */       if (rs.getString("NeedPrintGet") == null)
/* 1124 */         this.needPrintGet = null;
/*      */       else {
/* 1126 */         this.needPrintGet = rs.getString("NeedPrintGet").trim();
/*      */       }
/* 1128 */       if (rs.getString("RiskType3") == null)
/* 1129 */         this.riskType3 = null;
/*      */       else {
/* 1131 */         this.riskType3 = rs.getString("RiskType3").trim();
/*      */       }
/* 1133 */       if (rs.getString("RiskType4") == null)
/* 1134 */         this.riskType4 = null;
/*      */       else {
/* 1136 */         this.riskType4 = rs.getString("RiskType4").trim();
/*      */       }
/* 1138 */       if (rs.getString("RiskType5") == null)
/* 1139 */         this.riskType5 = null;
/*      */       else {
/* 1141 */         this.riskType5 = rs.getString("RiskType5").trim();
/*      */       }
/* 1143 */       if (rs.getString("NotPrintPol") == null)
/* 1144 */         this.notPrintPol = null;
/*      */       else {
/* 1146 */         this.notPrintPol = rs.getString("NotPrintPol").trim();
/*      */       }
/* 1148 */       if (rs.getString("NeedGetPolDate") == null)
/* 1149 */         this.needGetPolDate = null;
/*      */       else {
/* 1151 */         this.needGetPolDate = rs.getString("NeedGetPolDate").trim();
/*      */       }
/* 1153 */       if (rs.getString("NeedReReadBank") == null)
/* 1154 */         this.needReReadBank = null;
/*      */       else {
/* 1156 */         this.needReReadBank = rs.getString("NeedReReadBank").trim();
/*      */       }
/* 1158 */       if (rs.getString("SpecFlag") == null)
/* 1159 */         this.specFlag = null;
/*      */       else {
/* 1161 */         this.specFlag = rs.getString("SpecFlag").trim();
/*      */       }
/* 1163 */       if (rs.getString("InterestDifFlag") == null)
/* 1164 */         this.interestDifFlag = null;
/*      */       else {
/* 1166 */         this.interestDifFlag = rs.getString("InterestDifFlag").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1171 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRiskApp\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/* 1173 */       CError tError = new CError();
/* 1174 */       tError.moduleName = "LNPRiskAppSchema";
/* 1175 */       tError.functionName = "setSchema";
/* 1176 */       tError.errorMessage = sqle.toString();
/* 1177 */       this.mErrors.addOneError(tError);
/* 1178 */       return false;
/*      */     }
/* 1180 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRiskAppSchema getSchema()
/*      */   {
/* 1185 */     LNPRiskAppSchema aLNPRiskAppSchema = new LNPRiskAppSchema();
/* 1186 */     aLNPRiskAppSchema.setSchema(this);
/* 1187 */     return aLNPRiskAppSchema;
/*      */   }
/*      */ 
/*      */   public LNPRiskAppDB getDB()
/*      */   {
/* 1192 */     LNPRiskAppDB aDBOper = new LNPRiskAppDB();
/* 1193 */     aDBOper.setSchema(this);
/* 1194 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1201 */     StringBuffer strReturn = new StringBuffer(256);
/* 1202 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/* 1203 */     strReturn.append(StrTool.cTrim(this.riskVer)); strReturn.append("|");
/* 1204 */     strReturn.append(StrTool.cTrim(this.riskName)); strReturn.append("|");
/* 1205 */     strReturn.append(StrTool.cTrim(this.kindCode)); strReturn.append("|");
/* 1206 */     strReturn.append(StrTool.cTrim(this.riskType)); strReturn.append("|");
/* 1207 */     strReturn.append(StrTool.cTrim(this.riskType1)); strReturn.append("|");
/* 1208 */     strReturn.append(StrTool.cTrim(this.riskType2)); strReturn.append("|");
/* 1209 */     strReturn.append(StrTool.cTrim(this.riskProp)); strReturn.append("|");
/* 1210 */     strReturn.append(StrTool.cTrim(this.riskPeriod)); strReturn.append("|");
/* 1211 */     strReturn.append(StrTool.cTrim(this.riskTypeDetail)); strReturn.append("|");
/* 1212 */     strReturn.append(StrTool.cTrim(this.riskFlag)); strReturn.append("|");
/* 1213 */     strReturn.append(StrTool.cTrim(this.polType)); strReturn.append("|");
/* 1214 */     strReturn.append(StrTool.cTrim(this.investFlag)); strReturn.append("|");
/* 1215 */     strReturn.append(StrTool.cTrim(this.bonusFlag)); strReturn.append("|");
/* 1216 */     strReturn.append(StrTool.cTrim(this.bonusMode)); strReturn.append("|");
/* 1217 */     strReturn.append(StrTool.cTrim(this.listFlag)); strReturn.append("|");
/* 1218 */     strReturn.append(StrTool.cTrim(this.subRiskFlag)); strReturn.append("|");
/* 1219 */     strReturn.append(ChgData.chgData(this.calDigital)); strReturn.append("|");
/* 1220 */     strReturn.append(StrTool.cTrim(this.calChoMode)); strReturn.append("|");
/* 1221 */     strReturn.append(ChgData.chgData(this.riskAmntMult)); strReturn.append("|");
/* 1222 */     strReturn.append(StrTool.cTrim(this.insuPeriodFlag)); strReturn.append("|");
/* 1223 */     strReturn.append(ChgData.chgData(this.maxEndPeriod)); strReturn.append("|");
/* 1224 */     strReturn.append(ChgData.chgData(this.ageLmt)); strReturn.append("|");
/* 1225 */     strReturn.append(ChgData.chgData(this.signDateCalMode)); strReturn.append("|");
/* 1226 */     strReturn.append(StrTool.cTrim(this.protocolFlag)); strReturn.append("|");
/* 1227 */     strReturn.append(StrTool.cTrim(this.getChgFlag)); strReturn.append("|");
/* 1228 */     strReturn.append(StrTool.cTrim(this.protocolPayFlag)); strReturn.append("|");
/* 1229 */     strReturn.append(StrTool.cTrim(this.ensuPlanFlag)); strReturn.append("|");
/* 1230 */     strReturn.append(StrTool.cTrim(this.ensuPlanAdjFlag)); strReturn.append("|");
/* 1231 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/* 1232 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/* 1233 */     strReturn.append(ChgData.chgData(this.minAppntAge)); strReturn.append("|");
/* 1234 */     strReturn.append(ChgData.chgData(this.maxAppntAge)); strReturn.append("|");
/* 1235 */     strReturn.append(ChgData.chgData(this.maxInsuredAge)); strReturn.append("|");
/* 1236 */     strReturn.append(ChgData.chgData(this.minInsuredAge)); strReturn.append("|");
/* 1237 */     strReturn.append(ChgData.chgData(this.appInterest)); strReturn.append("|");
/* 1238 */     strReturn.append(ChgData.chgData(this.appPremRate)); strReturn.append("|");
/* 1239 */     strReturn.append(StrTool.cTrim(this.insuredFlag)); strReturn.append("|");
/* 1240 */     strReturn.append(StrTool.cTrim(this.shareFlag)); strReturn.append("|");
/* 1241 */     strReturn.append(StrTool.cTrim(this.bnfFlag)); strReturn.append("|");
/* 1242 */     strReturn.append(StrTool.cTrim(this.tempPayFlag)); strReturn.append("|");
/* 1243 */     strReturn.append(StrTool.cTrim(this.inpPayPlan)); strReturn.append("|");
/* 1244 */     strReturn.append(StrTool.cTrim(this.impartFlag)); strReturn.append("|");
/* 1245 */     strReturn.append(StrTool.cTrim(this.insuExpeFlag)); strReturn.append("|");
/* 1246 */     strReturn.append(StrTool.cTrim(this.loanFalg)); strReturn.append("|");
/* 1247 */     strReturn.append(StrTool.cTrim(this.mortagageFlag)); strReturn.append("|");
/* 1248 */     strReturn.append(StrTool.cTrim(this.iDifReturnFlag)); strReturn.append("|");
/* 1249 */     strReturn.append(StrTool.cTrim(this.cutAmntStopPay)); strReturn.append("|");
/* 1250 */     strReturn.append(ChgData.chgData(this.rinsRate)); strReturn.append("|");
/* 1251 */     strReturn.append(StrTool.cTrim(this.saleFlag)); strReturn.append("|");
/* 1252 */     strReturn.append(StrTool.cTrim(this.fileAppFlag)); strReturn.append("|");
/* 1253 */     strReturn.append(StrTool.cTrim(this.mngCom)); strReturn.append("|");
/* 1254 */     strReturn.append(StrTool.cTrim(this.autoPayFlag)); strReturn.append("|");
/* 1255 */     strReturn.append(StrTool.cTrim(this.needPrintHospital)); strReturn.append("|");
/* 1256 */     strReturn.append(StrTool.cTrim(this.needPrintGet)); strReturn.append("|");
/* 1257 */     strReturn.append(StrTool.cTrim(this.riskType3)); strReturn.append("|");
/* 1258 */     strReturn.append(StrTool.cTrim(this.riskType4)); strReturn.append("|");
/* 1259 */     strReturn.append(StrTool.cTrim(this.riskType5)); strReturn.append("|");
/* 1260 */     strReturn.append(StrTool.cTrim(this.notPrintPol)); strReturn.append("|");
/* 1261 */     strReturn.append(StrTool.cTrim(this.needGetPolDate)); strReturn.append("|");
/* 1262 */     strReturn.append(StrTool.cTrim(this.needReReadBank)); strReturn.append("|");
/* 1263 */     strReturn.append(StrTool.cTrim(this.specFlag)); strReturn.append("|");
/* 1264 */     strReturn.append(StrTool.cTrim(this.interestDifFlag));
/* 1265 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1273 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1274 */       this.riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1275 */       this.riskName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1276 */       this.kindCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1277 */       this.riskType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1278 */       this.riskType1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1279 */       this.riskType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1280 */       this.riskProp = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1281 */       this.riskPeriod = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1282 */       this.riskTypeDetail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1283 */       this.riskFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1284 */       this.polType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1285 */       this.investFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1286 */       this.bonusFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1287 */       this.bonusMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1288 */       this.listFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1289 */       this.subRiskFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1290 */       this.calDigital = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|"))).intValue();
/* 1291 */       this.calChoMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1292 */       this.riskAmntMult = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).intValue();
/* 1293 */       this.insuPeriodFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1294 */       this.maxEndPeriod = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 22, "|"))).intValue();
/* 1295 */       this.ageLmt = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|"))).intValue();
/* 1296 */       this.signDateCalMode = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 24, "|"))).intValue();
/* 1297 */       this.protocolFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1298 */       this.getChgFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1299 */       this.protocolPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1300 */       this.ensuPlanFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1301 */       this.ensuPlanAdjFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 1302 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|"));
/* 1303 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|"));
/* 1304 */       this.minAppntAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|"))).intValue();
/* 1305 */       this.maxAppntAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 33, "|"))).intValue();
/* 1306 */       this.maxInsuredAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 34, "|"))).intValue();
/* 1307 */       this.minInsuredAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 35, "|"))).intValue();
/* 1308 */       this.appInterest = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|"))).doubleValue();
/* 1309 */       this.appPremRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 37, "|"))).doubleValue();
/* 1310 */       this.insuredFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/* 1311 */       this.shareFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/* 1312 */       this.bnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1313 */       this.tempPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1314 */       this.inpPayPlan = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1315 */       this.impartFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 1316 */       this.insuExpeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1317 */       this.loanFalg = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 1318 */       this.mortagageFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 1319 */       this.iDifReturnFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 1320 */       this.cutAmntStopPay = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 1321 */       this.rinsRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 49, "|"))).doubleValue();
/* 1322 */       this.saleFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
/* 1323 */       this.fileAppFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
/* 1324 */       this.mngCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
/* 1325 */       this.autoPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
/* 1326 */       this.needPrintHospital = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
/* 1327 */       this.needPrintGet = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
/* 1328 */       this.riskType3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
/* 1329 */       this.riskType4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, "|");
/* 1330 */       this.riskType5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 58, "|");
/* 1331 */       this.notPrintPol = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 59, "|");
/* 1332 */       this.needGetPolDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 60, "|");
/* 1333 */       this.needReReadBank = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 61, "|");
/* 1334 */       this.specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 62, "|");
/* 1335 */       this.interestDifFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 63, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1340 */       CError tError = new CError();
/* 1341 */       tError.moduleName = "LNPRiskAppSchema";
/* 1342 */       tError.functionName = "decode";
/* 1343 */       tError.errorMessage = ex.toString();
/* 1344 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1346 */       return false;
/*      */     }
/* 1348 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1354 */     String strReturn = "";
/* 1355 */     if (FCode.equalsIgnoreCase("riskCode"))
/*      */     {
/* 1357 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*      */     }
/* 1359 */     if (FCode.equalsIgnoreCase("riskVer"))
/*      */     {
/* 1361 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskVer));
/*      */     }
/* 1363 */     if (FCode.equalsIgnoreCase("riskName"))
/*      */     {
/* 1365 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskName));
/*      */     }
/* 1367 */     if (FCode.equalsIgnoreCase("kindCode"))
/*      */     {
/* 1369 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.kindCode));
/*      */     }
/* 1371 */     if (FCode.equalsIgnoreCase("riskType"))
/*      */     {
/* 1373 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskType));
/*      */     }
/* 1375 */     if (FCode.equalsIgnoreCase("riskType1"))
/*      */     {
/* 1377 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskType1));
/*      */     }
/* 1379 */     if (FCode.equalsIgnoreCase("riskType2"))
/*      */     {
/* 1381 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskType2));
/*      */     }
/* 1383 */     if (FCode.equalsIgnoreCase("riskProp"))
/*      */     {
/* 1385 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskProp));
/*      */     }
/* 1387 */     if (FCode.equalsIgnoreCase("riskPeriod"))
/*      */     {
/* 1389 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskPeriod));
/*      */     }
/* 1391 */     if (FCode.equalsIgnoreCase("riskTypeDetail"))
/*      */     {
/* 1393 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskTypeDetail));
/*      */     }
/* 1395 */     if (FCode.equalsIgnoreCase("riskFlag"))
/*      */     {
/* 1397 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskFlag));
/*      */     }
/* 1399 */     if (FCode.equalsIgnoreCase("polType"))
/*      */     {
/* 1401 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polType));
/*      */     }
/* 1403 */     if (FCode.equalsIgnoreCase("investFlag"))
/*      */     {
/* 1405 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.investFlag));
/*      */     }
/* 1407 */     if (FCode.equalsIgnoreCase("bonusFlag"))
/*      */     {
/* 1409 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bonusFlag));
/*      */     }
/* 1411 */     if (FCode.equalsIgnoreCase("bonusMode"))
/*      */     {
/* 1413 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bonusMode));
/*      */     }
/* 1415 */     if (FCode.equalsIgnoreCase("listFlag"))
/*      */     {
/* 1417 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.listFlag));
/*      */     }
/* 1419 */     if (FCode.equalsIgnoreCase("subRiskFlag"))
/*      */     {
/* 1421 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.subRiskFlag));
/*      */     }
/* 1423 */     if (FCode.equalsIgnoreCase("calDigital"))
/*      */     {
/* 1425 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.calDigital));
/*      */     }
/* 1427 */     if (FCode.equalsIgnoreCase("calChoMode"))
/*      */     {
/* 1429 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.calChoMode));
/*      */     }
/* 1431 */     if (FCode.equalsIgnoreCase("riskAmntMult"))
/*      */     {
/* 1433 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskAmntMult));
/*      */     }
/* 1435 */     if (FCode.equalsIgnoreCase("insuPeriodFlag"))
/*      */     {
/* 1437 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuPeriodFlag));
/*      */     }
/* 1439 */     if (FCode.equalsIgnoreCase("maxEndPeriod"))
/*      */     {
/* 1441 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.maxEndPeriod));
/*      */     }
/* 1443 */     if (FCode.equalsIgnoreCase("ageLmt"))
/*      */     {
/* 1445 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ageLmt));
/*      */     }
/* 1447 */     if (FCode.equalsIgnoreCase("signDateCalMode"))
/*      */     {
/* 1449 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signDateCalMode));
/*      */     }
/* 1451 */     if (FCode.equalsIgnoreCase("protocolFlag"))
/*      */     {
/* 1453 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.protocolFlag));
/*      */     }
/* 1455 */     if (FCode.equalsIgnoreCase("getChgFlag"))
/*      */     {
/* 1457 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getChgFlag));
/*      */     }
/* 1459 */     if (FCode.equalsIgnoreCase("protocolPayFlag"))
/*      */     {
/* 1461 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.protocolPayFlag));
/*      */     }
/* 1463 */     if (FCode.equalsIgnoreCase("ensuPlanFlag"))
/*      */     {
/* 1465 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ensuPlanFlag));
/*      */     }
/* 1467 */     if (FCode.equalsIgnoreCase("ensuPlanAdjFlag"))
/*      */     {
/* 1469 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ensuPlanAdjFlag));
/*      */     }
/* 1471 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/* 1473 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/* 1475 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 1477 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/* 1479 */     if (FCode.equalsIgnoreCase("minAppntAge"))
/*      */     {
/* 1481 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minAppntAge));
/*      */     }
/* 1483 */     if (FCode.equalsIgnoreCase("maxAppntAge"))
/*      */     {
/* 1485 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.maxAppntAge));
/*      */     }
/* 1487 */     if (FCode.equalsIgnoreCase("maxInsuredAge"))
/*      */     {
/* 1489 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.maxInsuredAge));
/*      */     }
/* 1491 */     if (FCode.equalsIgnoreCase("minInsuredAge"))
/*      */     {
/* 1493 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minInsuredAge));
/*      */     }
/* 1495 */     if (FCode.equalsIgnoreCase("appInterest"))
/*      */     {
/* 1497 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appInterest));
/*      */     }
/* 1499 */     if (FCode.equalsIgnoreCase("appPremRate"))
/*      */     {
/* 1501 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appPremRate));
/*      */     }
/* 1503 */     if (FCode.equalsIgnoreCase("insuredFlag"))
/*      */     {
/* 1505 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredFlag));
/*      */     }
/* 1507 */     if (FCode.equalsIgnoreCase("shareFlag"))
/*      */     {
/* 1509 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.shareFlag));
/*      */     }
/* 1511 */     if (FCode.equalsIgnoreCase("bnfFlag"))
/*      */     {
/* 1513 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfFlag));
/*      */     }
/* 1515 */     if (FCode.equalsIgnoreCase("tempPayFlag"))
/*      */     {
/* 1517 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.tempPayFlag));
/*      */     }
/* 1519 */     if (FCode.equalsIgnoreCase("inpPayPlan"))
/*      */     {
/* 1521 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.inpPayPlan));
/*      */     }
/* 1523 */     if (FCode.equalsIgnoreCase("impartFlag"))
/*      */     {
/* 1525 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartFlag));
/*      */     }
/* 1527 */     if (FCode.equalsIgnoreCase("insuExpeFlag"))
/*      */     {
/* 1529 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuExpeFlag));
/*      */     }
/* 1531 */     if (FCode.equalsIgnoreCase("loanFalg"))
/*      */     {
/* 1533 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.loanFalg));
/*      */     }
/* 1535 */     if (FCode.equalsIgnoreCase("mortagageFlag"))
/*      */     {
/* 1537 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mortagageFlag));
/*      */     }
/* 1539 */     if (FCode.equalsIgnoreCase("iDifReturnFlag"))
/*      */     {
/* 1541 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDifReturnFlag));
/*      */     }
/* 1543 */     if (FCode.equalsIgnoreCase("cutAmntStopPay"))
/*      */     {
/* 1545 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.cutAmntStopPay));
/*      */     }
/* 1547 */     if (FCode.equalsIgnoreCase("rinsRate"))
/*      */     {
/* 1549 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rinsRate));
/*      */     }
/* 1551 */     if (FCode.equalsIgnoreCase("saleFlag"))
/*      */     {
/* 1553 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.saleFlag));
/*      */     }
/* 1555 */     if (FCode.equalsIgnoreCase("fileAppFlag"))
/*      */     {
/* 1557 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fileAppFlag));
/*      */     }
/* 1559 */     if (FCode.equalsIgnoreCase("mngCom"))
/*      */     {
/* 1561 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mngCom));
/*      */     }
/* 1563 */     if (FCode.equalsIgnoreCase("autoPayFlag"))
/*      */     {
/* 1565 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.autoPayFlag));
/*      */     }
/* 1567 */     if (FCode.equalsIgnoreCase("needPrintHospital"))
/*      */     {
/* 1569 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.needPrintHospital));
/*      */     }
/* 1571 */     if (FCode.equalsIgnoreCase("needPrintGet"))
/*      */     {
/* 1573 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.needPrintGet));
/*      */     }
/* 1575 */     if (FCode.equalsIgnoreCase("riskType3"))
/*      */     {
/* 1577 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskType3));
/*      */     }
/* 1579 */     if (FCode.equalsIgnoreCase("riskType4"))
/*      */     {
/* 1581 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskType4));
/*      */     }
/* 1583 */     if (FCode.equalsIgnoreCase("riskType5"))
/*      */     {
/* 1585 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskType5));
/*      */     }
/* 1587 */     if (FCode.equalsIgnoreCase("notPrintPol"))
/*      */     {
/* 1589 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.notPrintPol));
/*      */     }
/* 1591 */     if (FCode.equalsIgnoreCase("needGetPolDate"))
/*      */     {
/* 1593 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.needGetPolDate));
/*      */     }
/* 1595 */     if (FCode.equalsIgnoreCase("needReReadBank"))
/*      */     {
/* 1597 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.needReReadBank));
/*      */     }
/* 1599 */     if (FCode.equalsIgnoreCase("specFlag"))
/*      */     {
/* 1601 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specFlag));
/*      */     }
/* 1603 */     if (FCode.equalsIgnoreCase("interestDifFlag"))
/*      */     {
/* 1605 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.interestDifFlag));
/*      */     }
/* 1607 */     if (strReturn.equals(""))
/*      */     {
/* 1609 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1612 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1619 */     String strFieldValue = "";
/* 1620 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1622 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 1623 */       break;
/*      */     case 1:
/* 1625 */       strFieldValue = StrTool.GBKToUnicode(this.riskVer);
/* 1626 */       break;
/*      */     case 2:
/* 1628 */       strFieldValue = StrTool.GBKToUnicode(this.riskName);
/* 1629 */       break;
/*      */     case 3:
/* 1631 */       strFieldValue = StrTool.GBKToUnicode(this.kindCode);
/* 1632 */       break;
/*      */     case 4:
/* 1634 */       strFieldValue = StrTool.GBKToUnicode(this.riskType);
/* 1635 */       break;
/*      */     case 5:
/* 1637 */       strFieldValue = StrTool.GBKToUnicode(this.riskType1);
/* 1638 */       break;
/*      */     case 6:
/* 1640 */       strFieldValue = StrTool.GBKToUnicode(this.riskType2);
/* 1641 */       break;
/*      */     case 7:
/* 1643 */       strFieldValue = StrTool.GBKToUnicode(this.riskProp);
/* 1644 */       break;
/*      */     case 8:
/* 1646 */       strFieldValue = StrTool.GBKToUnicode(this.riskPeriod);
/* 1647 */       break;
/*      */     case 9:
/* 1649 */       strFieldValue = StrTool.GBKToUnicode(this.riskTypeDetail);
/* 1650 */       break;
/*      */     case 10:
/* 1652 */       strFieldValue = StrTool.GBKToUnicode(this.riskFlag);
/* 1653 */       break;
/*      */     case 11:
/* 1655 */       strFieldValue = StrTool.GBKToUnicode(this.polType);
/* 1656 */       break;
/*      */     case 12:
/* 1658 */       strFieldValue = StrTool.GBKToUnicode(this.investFlag);
/* 1659 */       break;
/*      */     case 13:
/* 1661 */       strFieldValue = StrTool.GBKToUnicode(this.bonusFlag);
/* 1662 */       break;
/*      */     case 14:
/* 1664 */       strFieldValue = StrTool.GBKToUnicode(this.bonusMode);
/* 1665 */       break;
/*      */     case 15:
/* 1667 */       strFieldValue = StrTool.GBKToUnicode(this.listFlag);
/* 1668 */       break;
/*      */     case 16:
/* 1670 */       strFieldValue = StrTool.GBKToUnicode(this.subRiskFlag);
/* 1671 */       break;
/*      */     case 17:
/* 1673 */       strFieldValue = String.valueOf(this.calDigital);
/* 1674 */       break;
/*      */     case 18:
/* 1676 */       strFieldValue = StrTool.GBKToUnicode(this.calChoMode);
/* 1677 */       break;
/*      */     case 19:
/* 1679 */       strFieldValue = String.valueOf(this.riskAmntMult);
/* 1680 */       break;
/*      */     case 20:
/* 1682 */       strFieldValue = StrTool.GBKToUnicode(this.insuPeriodFlag);
/* 1683 */       break;
/*      */     case 21:
/* 1685 */       strFieldValue = String.valueOf(this.maxEndPeriod);
/* 1686 */       break;
/*      */     case 22:
/* 1688 */       strFieldValue = String.valueOf(this.ageLmt);
/* 1689 */       break;
/*      */     case 23:
/* 1691 */       strFieldValue = String.valueOf(this.signDateCalMode);
/* 1692 */       break;
/*      */     case 24:
/* 1694 */       strFieldValue = StrTool.GBKToUnicode(this.protocolFlag);
/* 1695 */       break;
/*      */     case 25:
/* 1697 */       strFieldValue = StrTool.GBKToUnicode(this.getChgFlag);
/* 1698 */       break;
/*      */     case 26:
/* 1700 */       strFieldValue = StrTool.GBKToUnicode(this.protocolPayFlag);
/* 1701 */       break;
/*      */     case 27:
/* 1703 */       strFieldValue = StrTool.GBKToUnicode(this.ensuPlanFlag);
/* 1704 */       break;
/*      */     case 28:
/* 1706 */       strFieldValue = StrTool.GBKToUnicode(this.ensuPlanAdjFlag);
/* 1707 */       break;
/*      */     case 29:
/* 1709 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/* 1710 */       break;
/*      */     case 30:
/* 1712 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/* 1713 */       break;
/*      */     case 31:
/* 1715 */       strFieldValue = String.valueOf(this.minAppntAge);
/* 1716 */       break;
/*      */     case 32:
/* 1718 */       strFieldValue = String.valueOf(this.maxAppntAge);
/* 1719 */       break;
/*      */     case 33:
/* 1721 */       strFieldValue = String.valueOf(this.maxInsuredAge);
/* 1722 */       break;
/*      */     case 34:
/* 1724 */       strFieldValue = String.valueOf(this.minInsuredAge);
/* 1725 */       break;
/*      */     case 35:
/* 1727 */       strFieldValue = String.valueOf(this.appInterest);
/* 1728 */       break;
/*      */     case 36:
/* 1730 */       strFieldValue = String.valueOf(this.appPremRate);
/* 1731 */       break;
/*      */     case 37:
/* 1733 */       strFieldValue = StrTool.GBKToUnicode(this.insuredFlag);
/* 1734 */       break;
/*      */     case 38:
/* 1736 */       strFieldValue = StrTool.GBKToUnicode(this.shareFlag);
/* 1737 */       break;
/*      */     case 39:
/* 1739 */       strFieldValue = StrTool.GBKToUnicode(this.bnfFlag);
/* 1740 */       break;
/*      */     case 40:
/* 1742 */       strFieldValue = StrTool.GBKToUnicode(this.tempPayFlag);
/* 1743 */       break;
/*      */     case 41:
/* 1745 */       strFieldValue = StrTool.GBKToUnicode(this.inpPayPlan);
/* 1746 */       break;
/*      */     case 42:
/* 1748 */       strFieldValue = StrTool.GBKToUnicode(this.impartFlag);
/* 1749 */       break;
/*      */     case 43:
/* 1751 */       strFieldValue = StrTool.GBKToUnicode(this.insuExpeFlag);
/* 1752 */       break;
/*      */     case 44:
/* 1754 */       strFieldValue = StrTool.GBKToUnicode(this.loanFalg);
/* 1755 */       break;
/*      */     case 45:
/* 1757 */       strFieldValue = StrTool.GBKToUnicode(this.mortagageFlag);
/* 1758 */       break;
/*      */     case 46:
/* 1760 */       strFieldValue = StrTool.GBKToUnicode(this.iDifReturnFlag);
/* 1761 */       break;
/*      */     case 47:
/* 1763 */       strFieldValue = StrTool.GBKToUnicode(this.cutAmntStopPay);
/* 1764 */       break;
/*      */     case 48:
/* 1766 */       strFieldValue = String.valueOf(this.rinsRate);
/* 1767 */       break;
/*      */     case 49:
/* 1769 */       strFieldValue = StrTool.GBKToUnicode(this.saleFlag);
/* 1770 */       break;
/*      */     case 50:
/* 1772 */       strFieldValue = StrTool.GBKToUnicode(this.fileAppFlag);
/* 1773 */       break;
/*      */     case 51:
/* 1775 */       strFieldValue = StrTool.GBKToUnicode(this.mngCom);
/* 1776 */       break;
/*      */     case 52:
/* 1778 */       strFieldValue = StrTool.GBKToUnicode(this.autoPayFlag);
/* 1779 */       break;
/*      */     case 53:
/* 1781 */       strFieldValue = StrTool.GBKToUnicode(this.needPrintHospital);
/* 1782 */       break;
/*      */     case 54:
/* 1784 */       strFieldValue = StrTool.GBKToUnicode(this.needPrintGet);
/* 1785 */       break;
/*      */     case 55:
/* 1787 */       strFieldValue = StrTool.GBKToUnicode(this.riskType3);
/* 1788 */       break;
/*      */     case 56:
/* 1790 */       strFieldValue = StrTool.GBKToUnicode(this.riskType4);
/* 1791 */       break;
/*      */     case 57:
/* 1793 */       strFieldValue = StrTool.GBKToUnicode(this.riskType5);
/* 1794 */       break;
/*      */     case 58:
/* 1796 */       strFieldValue = StrTool.GBKToUnicode(this.notPrintPol);
/* 1797 */       break;
/*      */     case 59:
/* 1799 */       strFieldValue = StrTool.GBKToUnicode(this.needGetPolDate);
/* 1800 */       break;
/*      */     case 60:
/* 1802 */       strFieldValue = StrTool.GBKToUnicode(this.needReReadBank);
/* 1803 */       break;
/*      */     case 61:
/* 1805 */       strFieldValue = StrTool.GBKToUnicode(this.specFlag);
/* 1806 */       break;
/*      */     case 62:
/* 1808 */       strFieldValue = StrTool.GBKToUnicode(this.interestDifFlag);
/* 1809 */       break;
/*      */     default:
/* 1811 */       strFieldValue = "";
/*      */     }
/* 1813 */     if (strFieldValue.equals("")) {
/* 1814 */       strFieldValue = "null";
/*      */     }
/* 1816 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1822 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1823 */       return false;
/*      */     }
/* 1825 */     if (FCode.equalsIgnoreCase("riskCode"))
/*      */     {
/* 1827 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1829 */         this.riskCode = FValue.trim();
/*      */       }
/*      */       else
/* 1832 */         this.riskCode = null;
/*      */     }
/* 1834 */     if (FCode.equalsIgnoreCase("riskVer"))
/*      */     {
/* 1836 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1838 */         this.riskVer = FValue.trim();
/*      */       }
/*      */       else
/* 1841 */         this.riskVer = null;
/*      */     }
/* 1843 */     if (FCode.equalsIgnoreCase("riskName"))
/*      */     {
/* 1845 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1847 */         this.riskName = FValue.trim();
/*      */       }
/*      */       else
/* 1850 */         this.riskName = null;
/*      */     }
/* 1852 */     if (FCode.equalsIgnoreCase("kindCode"))
/*      */     {
/* 1854 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1856 */         this.kindCode = FValue.trim();
/*      */       }
/*      */       else
/* 1859 */         this.kindCode = null;
/*      */     }
/* 1861 */     if (FCode.equalsIgnoreCase("riskType"))
/*      */     {
/* 1863 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1865 */         this.riskType = FValue.trim();
/*      */       }
/*      */       else
/* 1868 */         this.riskType = null;
/*      */     }
/* 1870 */     if (FCode.equalsIgnoreCase("riskType1"))
/*      */     {
/* 1872 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1874 */         this.riskType1 = FValue.trim();
/*      */       }
/*      */       else
/* 1877 */         this.riskType1 = null;
/*      */     }
/* 1879 */     if (FCode.equalsIgnoreCase("riskType2"))
/*      */     {
/* 1881 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1883 */         this.riskType2 = FValue.trim();
/*      */       }
/*      */       else
/* 1886 */         this.riskType2 = null;
/*      */     }
/* 1888 */     if (FCode.equalsIgnoreCase("riskProp"))
/*      */     {
/* 1890 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1892 */         this.riskProp = FValue.trim();
/*      */       }
/*      */       else
/* 1895 */         this.riskProp = null;
/*      */     }
/* 1897 */     if (FCode.equalsIgnoreCase("riskPeriod"))
/*      */     {
/* 1899 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1901 */         this.riskPeriod = FValue.trim();
/*      */       }
/*      */       else
/* 1904 */         this.riskPeriod = null;
/*      */     }
/* 1906 */     if (FCode.equalsIgnoreCase("riskTypeDetail"))
/*      */     {
/* 1908 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1910 */         this.riskTypeDetail = FValue.trim();
/*      */       }
/*      */       else
/* 1913 */         this.riskTypeDetail = null;
/*      */     }
/* 1915 */     if (FCode.equalsIgnoreCase("riskFlag"))
/*      */     {
/* 1917 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1919 */         this.riskFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1922 */         this.riskFlag = null;
/*      */     }
/* 1924 */     if (FCode.equalsIgnoreCase("polType"))
/*      */     {
/* 1926 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1928 */         this.polType = FValue.trim();
/*      */       }
/*      */       else
/* 1931 */         this.polType = null;
/*      */     }
/* 1933 */     if (FCode.equalsIgnoreCase("investFlag"))
/*      */     {
/* 1935 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1937 */         this.investFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1940 */         this.investFlag = null;
/*      */     }
/* 1942 */     if (FCode.equalsIgnoreCase("bonusFlag"))
/*      */     {
/* 1944 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1946 */         this.bonusFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1949 */         this.bonusFlag = null;
/*      */     }
/* 1951 */     if (FCode.equalsIgnoreCase("bonusMode"))
/*      */     {
/* 1953 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1955 */         this.bonusMode = FValue.trim();
/*      */       }
/*      */       else
/* 1958 */         this.bonusMode = null;
/*      */     }
/* 1960 */     if (FCode.equalsIgnoreCase("listFlag"))
/*      */     {
/* 1962 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1964 */         this.listFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1967 */         this.listFlag = null;
/*      */     }
/* 1969 */     if (FCode.equalsIgnoreCase("subRiskFlag"))
/*      */     {
/* 1971 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1973 */         this.subRiskFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1976 */         this.subRiskFlag = null;
/*      */     }
/* 1978 */     if (FCode.equalsIgnoreCase("calDigital"))
/*      */     {
/* 1980 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1982 */         Integer tInteger = new Integer(FValue);
/* 1983 */         int i = tInteger.intValue();
/* 1984 */         this.calDigital = i;
/*      */       }
/*      */     }
/* 1987 */     if (FCode.equalsIgnoreCase("calChoMode"))
/*      */     {
/* 1989 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1991 */         this.calChoMode = FValue.trim();
/*      */       }
/*      */       else
/* 1994 */         this.calChoMode = null;
/*      */     }
/* 1996 */     if (FCode.equalsIgnoreCase("riskAmntMult"))
/*      */     {
/* 1998 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2000 */         Integer tInteger = new Integer(FValue);
/* 2001 */         int i = tInteger.intValue();
/* 2002 */         this.riskAmntMult = i;
/*      */       }
/*      */     }
/* 2005 */     if (FCode.equalsIgnoreCase("insuPeriodFlag"))
/*      */     {
/* 2007 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2009 */         this.insuPeriodFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2012 */         this.insuPeriodFlag = null;
/*      */     }
/* 2014 */     if (FCode.equalsIgnoreCase("maxEndPeriod"))
/*      */     {
/* 2016 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2018 */         Integer tInteger = new Integer(FValue);
/* 2019 */         int i = tInteger.intValue();
/* 2020 */         this.maxEndPeriod = i;
/*      */       }
/*      */     }
/* 2023 */     if (FCode.equalsIgnoreCase("ageLmt"))
/*      */     {
/* 2025 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2027 */         Integer tInteger = new Integer(FValue);
/* 2028 */         int i = tInteger.intValue();
/* 2029 */         this.ageLmt = i;
/*      */       }
/*      */     }
/* 2032 */     if (FCode.equalsIgnoreCase("signDateCalMode"))
/*      */     {
/* 2034 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2036 */         Integer tInteger = new Integer(FValue);
/* 2037 */         int i = tInteger.intValue();
/* 2038 */         this.signDateCalMode = i;
/*      */       }
/*      */     }
/* 2041 */     if (FCode.equalsIgnoreCase("protocolFlag"))
/*      */     {
/* 2043 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2045 */         this.protocolFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2048 */         this.protocolFlag = null;
/*      */     }
/* 2050 */     if (FCode.equalsIgnoreCase("getChgFlag"))
/*      */     {
/* 2052 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2054 */         this.getChgFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2057 */         this.getChgFlag = null;
/*      */     }
/* 2059 */     if (FCode.equalsIgnoreCase("protocolPayFlag"))
/*      */     {
/* 2061 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2063 */         this.protocolPayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2066 */         this.protocolPayFlag = null;
/*      */     }
/* 2068 */     if (FCode.equalsIgnoreCase("ensuPlanFlag"))
/*      */     {
/* 2070 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2072 */         this.ensuPlanFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2075 */         this.ensuPlanFlag = null;
/*      */     }
/* 2077 */     if (FCode.equalsIgnoreCase("ensuPlanAdjFlag"))
/*      */     {
/* 2079 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2081 */         this.ensuPlanAdjFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2084 */         this.ensuPlanAdjFlag = null;
/*      */     }
/* 2086 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/* 2088 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2090 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2093 */         this.startDate = null;
/*      */     }
/* 2095 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 2097 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2099 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2102 */         this.endDate = null;
/*      */     }
/* 2104 */     if (FCode.equalsIgnoreCase("minAppntAge"))
/*      */     {
/* 2106 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2108 */         Integer tInteger = new Integer(FValue);
/* 2109 */         int i = tInteger.intValue();
/* 2110 */         this.minAppntAge = i;
/*      */       }
/*      */     }
/* 2113 */     if (FCode.equalsIgnoreCase("maxAppntAge"))
/*      */     {
/* 2115 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2117 */         Integer tInteger = new Integer(FValue);
/* 2118 */         int i = tInteger.intValue();
/* 2119 */         this.maxAppntAge = i;
/*      */       }
/*      */     }
/* 2122 */     if (FCode.equalsIgnoreCase("maxInsuredAge"))
/*      */     {
/* 2124 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2126 */         Integer tInteger = new Integer(FValue);
/* 2127 */         int i = tInteger.intValue();
/* 2128 */         this.maxInsuredAge = i;
/*      */       }
/*      */     }
/* 2131 */     if (FCode.equalsIgnoreCase("minInsuredAge"))
/*      */     {
/* 2133 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2135 */         Integer tInteger = new Integer(FValue);
/* 2136 */         int i = tInteger.intValue();
/* 2137 */         this.minInsuredAge = i;
/*      */       }
/*      */     }
/* 2140 */     if (FCode.equalsIgnoreCase("appInterest"))
/*      */     {
/* 2142 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2144 */         Double tDouble = new Double(FValue);
/* 2145 */         double d = tDouble.doubleValue();
/* 2146 */         this.appInterest = d;
/*      */       }
/*      */     }
/* 2149 */     if (FCode.equalsIgnoreCase("appPremRate"))
/*      */     {
/* 2151 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2153 */         Double tDouble = new Double(FValue);
/* 2154 */         double d = tDouble.doubleValue();
/* 2155 */         this.appPremRate = d;
/*      */       }
/*      */     }
/* 2158 */     if (FCode.equalsIgnoreCase("insuredFlag"))
/*      */     {
/* 2160 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2162 */         this.insuredFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2165 */         this.insuredFlag = null;
/*      */     }
/* 2167 */     if (FCode.equalsIgnoreCase("shareFlag"))
/*      */     {
/* 2169 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2171 */         this.shareFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2174 */         this.shareFlag = null;
/*      */     }
/* 2176 */     if (FCode.equalsIgnoreCase("bnfFlag"))
/*      */     {
/* 2178 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2180 */         this.bnfFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2183 */         this.bnfFlag = null;
/*      */     }
/* 2185 */     if (FCode.equalsIgnoreCase("tempPayFlag"))
/*      */     {
/* 2187 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2189 */         this.tempPayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2192 */         this.tempPayFlag = null;
/*      */     }
/* 2194 */     if (FCode.equalsIgnoreCase("inpPayPlan"))
/*      */     {
/* 2196 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2198 */         this.inpPayPlan = FValue.trim();
/*      */       }
/*      */       else
/* 2201 */         this.inpPayPlan = null;
/*      */     }
/* 2203 */     if (FCode.equalsIgnoreCase("impartFlag"))
/*      */     {
/* 2205 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2207 */         this.impartFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2210 */         this.impartFlag = null;
/*      */     }
/* 2212 */     if (FCode.equalsIgnoreCase("insuExpeFlag"))
/*      */     {
/* 2214 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2216 */         this.insuExpeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2219 */         this.insuExpeFlag = null;
/*      */     }
/* 2221 */     if (FCode.equalsIgnoreCase("loanFalg"))
/*      */     {
/* 2223 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2225 */         this.loanFalg = FValue.trim();
/*      */       }
/*      */       else
/* 2228 */         this.loanFalg = null;
/*      */     }
/* 2230 */     if (FCode.equalsIgnoreCase("mortagageFlag"))
/*      */     {
/* 2232 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2234 */         this.mortagageFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2237 */         this.mortagageFlag = null;
/*      */     }
/* 2239 */     if (FCode.equalsIgnoreCase("iDifReturnFlag"))
/*      */     {
/* 2241 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2243 */         this.iDifReturnFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2246 */         this.iDifReturnFlag = null;
/*      */     }
/* 2248 */     if (FCode.equalsIgnoreCase("cutAmntStopPay"))
/*      */     {
/* 2250 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2252 */         this.cutAmntStopPay = FValue.trim();
/*      */       }
/*      */       else
/* 2255 */         this.cutAmntStopPay = null;
/*      */     }
/* 2257 */     if (FCode.equalsIgnoreCase("rinsRate"))
/*      */     {
/* 2259 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2261 */         Double tDouble = new Double(FValue);
/* 2262 */         double d = tDouble.doubleValue();
/* 2263 */         this.rinsRate = d;
/*      */       }
/*      */     }
/* 2266 */     if (FCode.equalsIgnoreCase("saleFlag"))
/*      */     {
/* 2268 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2270 */         this.saleFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2273 */         this.saleFlag = null;
/*      */     }
/* 2275 */     if (FCode.equalsIgnoreCase("fileAppFlag"))
/*      */     {
/* 2277 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2279 */         this.fileAppFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2282 */         this.fileAppFlag = null;
/*      */     }
/* 2284 */     if (FCode.equalsIgnoreCase("mngCom"))
/*      */     {
/* 2286 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2288 */         this.mngCom = FValue.trim();
/*      */       }
/*      */       else
/* 2291 */         this.mngCom = null;
/*      */     }
/* 2293 */     if (FCode.equalsIgnoreCase("autoPayFlag"))
/*      */     {
/* 2295 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2297 */         this.autoPayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2300 */         this.autoPayFlag = null;
/*      */     }
/* 2302 */     if (FCode.equalsIgnoreCase("needPrintHospital"))
/*      */     {
/* 2304 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2306 */         this.needPrintHospital = FValue.trim();
/*      */       }
/*      */       else
/* 2309 */         this.needPrintHospital = null;
/*      */     }
/* 2311 */     if (FCode.equalsIgnoreCase("needPrintGet"))
/*      */     {
/* 2313 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2315 */         this.needPrintGet = FValue.trim();
/*      */       }
/*      */       else
/* 2318 */         this.needPrintGet = null;
/*      */     }
/* 2320 */     if (FCode.equalsIgnoreCase("riskType3"))
/*      */     {
/* 2322 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2324 */         this.riskType3 = FValue.trim();
/*      */       }
/*      */       else
/* 2327 */         this.riskType3 = null;
/*      */     }
/* 2329 */     if (FCode.equalsIgnoreCase("riskType4"))
/*      */     {
/* 2331 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2333 */         this.riskType4 = FValue.trim();
/*      */       }
/*      */       else
/* 2336 */         this.riskType4 = null;
/*      */     }
/* 2338 */     if (FCode.equalsIgnoreCase("riskType5"))
/*      */     {
/* 2340 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2342 */         this.riskType5 = FValue.trim();
/*      */       }
/*      */       else
/* 2345 */         this.riskType5 = null;
/*      */     }
/* 2347 */     if (FCode.equalsIgnoreCase("notPrintPol"))
/*      */     {
/* 2349 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2351 */         this.notPrintPol = FValue.trim();
/*      */       }
/*      */       else
/* 2354 */         this.notPrintPol = null;
/*      */     }
/* 2356 */     if (FCode.equalsIgnoreCase("needGetPolDate"))
/*      */     {
/* 2358 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2360 */         this.needGetPolDate = FValue.trim();
/*      */       }
/*      */       else
/* 2363 */         this.needGetPolDate = null;
/*      */     }
/* 2365 */     if (FCode.equalsIgnoreCase("needReReadBank"))
/*      */     {
/* 2367 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2369 */         this.needReReadBank = FValue.trim();
/*      */       }
/*      */       else
/* 2372 */         this.needReReadBank = null;
/*      */     }
/* 2374 */     if (FCode.equalsIgnoreCase("specFlag"))
/*      */     {
/* 2376 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2378 */         this.specFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2381 */         this.specFlag = null;
/*      */     }
/* 2383 */     if (FCode.equalsIgnoreCase("interestDifFlag"))
/*      */     {
/* 2385 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2387 */         this.interestDifFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2390 */         this.interestDifFlag = null;
/*      */     }
/* 2392 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 2397 */     if (otherObject == null) return false;
/* 2398 */     if (this == otherObject) return true;
/* 2399 */     if (getClass() != otherObject.getClass()) return false;
/* 2400 */     LNPRiskAppSchema other = (LNPRiskAppSchema)otherObject;
/* 2401 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 2402 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/* 2403 */     if ((this.riskVer == null) && (other.getRiskVer() != null)) return false;
/* 2404 */     if ((this.riskVer != null) && (!this.riskVer.equals(other.getRiskVer()))) return false;
/* 2405 */     if ((this.riskName == null) && (other.getRiskName() != null)) return false;
/* 2406 */     if ((this.riskName != null) && (!this.riskName.equals(other.getRiskName()))) return false;
/* 2407 */     if ((this.kindCode == null) && (other.getKindCode() != null)) return false;
/* 2408 */     if ((this.kindCode != null) && (!this.kindCode.equals(other.getKindCode()))) return false;
/* 2409 */     if ((this.riskType == null) && (other.getRiskType() != null)) return false;
/* 2410 */     if ((this.riskType != null) && (!this.riskType.equals(other.getRiskType()))) return false;
/* 2411 */     if ((this.riskType1 == null) && (other.getRiskType1() != null)) return false;
/* 2412 */     if ((this.riskType1 != null) && (!this.riskType1.equals(other.getRiskType1()))) return false;
/* 2413 */     if ((this.riskType2 == null) && (other.getRiskType2() != null)) return false;
/* 2414 */     if ((this.riskType2 != null) && (!this.riskType2.equals(other.getRiskType2()))) return false;
/* 2415 */     if ((this.riskProp == null) && (other.getRiskProp() != null)) return false;
/* 2416 */     if ((this.riskProp != null) && (!this.riskProp.equals(other.getRiskProp()))) return false;
/* 2417 */     if ((this.riskPeriod == null) && (other.getRiskPeriod() != null)) return false;
/* 2418 */     if ((this.riskPeriod != null) && (!this.riskPeriod.equals(other.getRiskPeriod()))) return false;
/* 2419 */     if ((this.riskTypeDetail == null) && (other.getRiskTypeDetail() != null)) return false;
/* 2420 */     if ((this.riskTypeDetail != null) && (!this.riskTypeDetail.equals(other.getRiskTypeDetail()))) return false;
/* 2421 */     if ((this.riskFlag == null) && (other.getRiskFlag() != null)) return false;
/* 2422 */     if ((this.riskFlag != null) && (!this.riskFlag.equals(other.getRiskFlag()))) return false;
/* 2423 */     if ((this.polType == null) && (other.getPolType() != null)) return false;
/* 2424 */     if ((this.polType != null) && (!this.polType.equals(other.getPolType()))) return false;
/* 2425 */     if ((this.investFlag == null) && (other.getInvestFlag() != null)) return false;
/* 2426 */     if ((this.investFlag != null) && (!this.investFlag.equals(other.getInvestFlag()))) return false;
/* 2427 */     if ((this.bonusFlag == null) && (other.getBonusFlag() != null)) return false;
/* 2428 */     if ((this.bonusFlag != null) && (!this.bonusFlag.equals(other.getBonusFlag()))) return false;
/* 2429 */     if ((this.bonusMode == null) && (other.getBonusMode() != null)) return false;
/* 2430 */     if ((this.bonusMode != null) && (!this.bonusMode.equals(other.getBonusMode()))) return false;
/* 2431 */     if ((this.listFlag == null) && (other.getListFlag() != null)) return false;
/* 2432 */     if ((this.listFlag != null) && (!this.listFlag.equals(other.getListFlag()))) return false;
/* 2433 */     if ((this.subRiskFlag == null) && (other.getSubRiskFlag() != null)) return false;
/* 2434 */     if ((this.subRiskFlag != null) && (!this.subRiskFlag.equals(other.getSubRiskFlag()))) return false;
/* 2435 */     if (this.calDigital != other.getCalDigital()) return false;
/* 2436 */     if ((this.calChoMode == null) && (other.getCalChoMode() != null)) return false;
/* 2437 */     if ((this.calChoMode != null) && (!this.calChoMode.equals(other.getCalChoMode()))) return false;
/* 2438 */     if (this.riskAmntMult != other.getRiskAmntMult()) return false;
/* 2439 */     if ((this.insuPeriodFlag == null) && (other.getInsuPeriodFlag() != null)) return false;
/* 2440 */     if ((this.insuPeriodFlag != null) && (!this.insuPeriodFlag.equals(other.getInsuPeriodFlag()))) return false;
/* 2441 */     if (this.maxEndPeriod != other.getMaxEndPeriod()) return false;
/* 2442 */     if (this.ageLmt != other.getAgeLmt()) return false;
/* 2443 */     if (this.signDateCalMode != other.getSignDateCalMode()) return false;
/* 2444 */     if ((this.protocolFlag == null) && (other.getProtocolFlag() != null)) return false;
/* 2445 */     if ((this.protocolFlag != null) && (!this.protocolFlag.equals(other.getProtocolFlag()))) return false;
/* 2446 */     if ((this.getChgFlag == null) && (other.getGetChgFlag() != null)) return false;
/* 2447 */     if ((this.getChgFlag != null) && (!this.getChgFlag.equals(other.getGetChgFlag()))) return false;
/* 2448 */     if ((this.protocolPayFlag == null) && (other.getProtocolPayFlag() != null)) return false;
/* 2449 */     if ((this.protocolPayFlag != null) && (!this.protocolPayFlag.equals(other.getProtocolPayFlag()))) return false;
/* 2450 */     if ((this.ensuPlanFlag == null) && (other.getEnsuPlanFlag() != null)) return false;
/* 2451 */     if ((this.ensuPlanFlag != null) && (!this.ensuPlanFlag.equals(other.getEnsuPlanFlag()))) return false;
/* 2452 */     if ((this.ensuPlanAdjFlag == null) && (other.getEnsuPlanAdjFlag() != null)) return false;
/* 2453 */     if ((this.ensuPlanAdjFlag != null) && (!this.ensuPlanAdjFlag.equals(other.getEnsuPlanAdjFlag()))) return false;
/* 2454 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 2455 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 2456 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 2457 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 2458 */     if (this.minAppntAge != other.getMinAppntAge()) return false;
/* 2459 */     if (this.maxAppntAge != other.getMaxAppntAge()) return false;
/* 2460 */     if (this.maxInsuredAge != other.getMaxInsuredAge()) return false;
/* 2461 */     if (this.minInsuredAge != other.getMinInsuredAge()) return false;
/* 2462 */     if (Double.doubleToLongBits(this.appInterest) != Double.doubleToLongBits(other.getAppInterest())) return false;
/* 2463 */     if (Double.doubleToLongBits(this.appPremRate) != Double.doubleToLongBits(other.getAppPremRate())) return false;
/* 2464 */     if ((this.insuredFlag == null) && (other.getInsuredFlag() != null)) return false;
/* 2465 */     if ((this.insuredFlag != null) && (!this.insuredFlag.equals(other.getInsuredFlag()))) return false;
/* 2466 */     if ((this.shareFlag == null) && (other.getShareFlag() != null)) return false;
/* 2467 */     if ((this.shareFlag != null) && (!this.shareFlag.equals(other.getShareFlag()))) return false;
/* 2468 */     if ((this.bnfFlag == null) && (other.getBnfFlag() != null)) return false;
/* 2469 */     if ((this.bnfFlag != null) && (!this.bnfFlag.equals(other.getBnfFlag()))) return false;
/* 2470 */     if ((this.tempPayFlag == null) && (other.getTempPayFlag() != null)) return false;
/* 2471 */     if ((this.tempPayFlag != null) && (!this.tempPayFlag.equals(other.getTempPayFlag()))) return false;
/* 2472 */     if ((this.inpPayPlan == null) && (other.getInpPayPlan() != null)) return false;
/* 2473 */     if ((this.inpPayPlan != null) && (!this.inpPayPlan.equals(other.getInpPayPlan()))) return false;
/* 2474 */     if ((this.impartFlag == null) && (other.getImpartFlag() != null)) return false;
/* 2475 */     if ((this.impartFlag != null) && (!this.impartFlag.equals(other.getImpartFlag()))) return false;
/* 2476 */     if ((this.insuExpeFlag == null) && (other.getInsuExpeFlag() != null)) return false;
/* 2477 */     if ((this.insuExpeFlag != null) && (!this.insuExpeFlag.equals(other.getInsuExpeFlag()))) return false;
/* 2478 */     if ((this.loanFalg == null) && (other.getLoanFalg() != null)) return false;
/* 2479 */     if ((this.loanFalg != null) && (!this.loanFalg.equals(other.getLoanFalg()))) return false;
/* 2480 */     if ((this.mortagageFlag == null) && (other.getMortagageFlag() != null)) return false;
/* 2481 */     if ((this.mortagageFlag != null) && (!this.mortagageFlag.equals(other.getMortagageFlag()))) return false;
/* 2482 */     if ((this.iDifReturnFlag == null) && (other.getIDifReturnFlag() != null)) return false;
/* 2483 */     if ((this.iDifReturnFlag != null) && (!this.iDifReturnFlag.equals(other.getIDifReturnFlag()))) return false;
/* 2484 */     if ((this.cutAmntStopPay == null) && (other.getCutAmntStopPay() != null)) return false;
/* 2485 */     if ((this.cutAmntStopPay != null) && (!this.cutAmntStopPay.equals(other.getCutAmntStopPay()))) return false;
/* 2486 */     if (Double.doubleToLongBits(this.rinsRate) != Double.doubleToLongBits(other.getRinsRate())) return false;
/* 2487 */     if ((this.saleFlag == null) && (other.getSaleFlag() != null)) return false;
/* 2488 */     if ((this.saleFlag != null) && (!this.saleFlag.equals(other.getSaleFlag()))) return false;
/* 2489 */     if ((this.fileAppFlag == null) && (other.getFileAppFlag() != null)) return false;
/* 2490 */     if ((this.fileAppFlag != null) && (!this.fileAppFlag.equals(other.getFileAppFlag()))) return false;
/* 2491 */     if ((this.mngCom == null) && (other.getMngCom() != null)) return false;
/* 2492 */     if ((this.mngCom != null) && (!this.mngCom.equals(other.getMngCom()))) return false;
/* 2493 */     if ((this.autoPayFlag == null) && (other.getAutoPayFlag() != null)) return false;
/* 2494 */     if ((this.autoPayFlag != null) && (!this.autoPayFlag.equals(other.getAutoPayFlag()))) return false;
/* 2495 */     if ((this.needPrintHospital == null) && (other.getNeedPrintHospital() != null)) return false;
/* 2496 */     if ((this.needPrintHospital != null) && (!this.needPrintHospital.equals(other.getNeedPrintHospital()))) return false;
/* 2497 */     if ((this.needPrintGet == null) && (other.getNeedPrintGet() != null)) return false;
/* 2498 */     if ((this.needPrintGet != null) && (!this.needPrintGet.equals(other.getNeedPrintGet()))) return false;
/* 2499 */     if ((this.riskType3 == null) && (other.getRiskType3() != null)) return false;
/* 2500 */     if ((this.riskType3 != null) && (!this.riskType3.equals(other.getRiskType3()))) return false;
/* 2501 */     if ((this.riskType4 == null) && (other.getRiskType4() != null)) return false;
/* 2502 */     if ((this.riskType4 != null) && (!this.riskType4.equals(other.getRiskType4()))) return false;
/* 2503 */     if ((this.riskType5 == null) && (other.getRiskType5() != null)) return false;
/* 2504 */     if ((this.riskType5 != null) && (!this.riskType5.equals(other.getRiskType5()))) return false;
/* 2505 */     if ((this.notPrintPol == null) && (other.getNotPrintPol() != null)) return false;
/* 2506 */     if ((this.notPrintPol != null) && (!this.notPrintPol.equals(other.getNotPrintPol()))) return false;
/* 2507 */     if ((this.needGetPolDate == null) && (other.getNeedGetPolDate() != null)) return false;
/* 2508 */     if ((this.needGetPolDate != null) && (!this.needGetPolDate.equals(other.getNeedGetPolDate()))) return false;
/* 2509 */     if ((this.needReReadBank == null) && (other.getNeedReReadBank() != null)) return false;
/* 2510 */     if ((this.needReReadBank != null) && (!this.needReReadBank.equals(other.getNeedReReadBank()))) return false;
/* 2511 */     if ((this.specFlag == null) && (other.getSpecFlag() != null)) return false;
/* 2512 */     if ((this.specFlag != null) && (!this.specFlag.equals(other.getSpecFlag()))) return false;
/* 2513 */     if ((this.interestDifFlag == null) && (other.getInterestDifFlag() != null)) return false;
/* 2514 */     return (this.interestDifFlag == null) || (this.interestDifFlag.equals(other.getInterestDifFlag()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2521 */     return 63;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2527 */     if (strFieldName.equals("riskCode")) {
/* 2528 */       return 0;
/*      */     }
/* 2530 */     if (strFieldName.equals("riskVer")) {
/* 2531 */       return 1;
/*      */     }
/* 2533 */     if (strFieldName.equals("riskName")) {
/* 2534 */       return 2;
/*      */     }
/* 2536 */     if (strFieldName.equals("kindCode")) {
/* 2537 */       return 3;
/*      */     }
/* 2539 */     if (strFieldName.equals("riskType")) {
/* 2540 */       return 4;
/*      */     }
/* 2542 */     if (strFieldName.equals("riskType1")) {
/* 2543 */       return 5;
/*      */     }
/* 2545 */     if (strFieldName.equals("riskType2")) {
/* 2546 */       return 6;
/*      */     }
/* 2548 */     if (strFieldName.equals("riskProp")) {
/* 2549 */       return 7;
/*      */     }
/* 2551 */     if (strFieldName.equals("riskPeriod")) {
/* 2552 */       return 8;
/*      */     }
/* 2554 */     if (strFieldName.equals("riskTypeDetail")) {
/* 2555 */       return 9;
/*      */     }
/* 2557 */     if (strFieldName.equals("riskFlag")) {
/* 2558 */       return 10;
/*      */     }
/* 2560 */     if (strFieldName.equals("polType")) {
/* 2561 */       return 11;
/*      */     }
/* 2563 */     if (strFieldName.equals("investFlag")) {
/* 2564 */       return 12;
/*      */     }
/* 2566 */     if (strFieldName.equals("bonusFlag")) {
/* 2567 */       return 13;
/*      */     }
/* 2569 */     if (strFieldName.equals("bonusMode")) {
/* 2570 */       return 14;
/*      */     }
/* 2572 */     if (strFieldName.equals("listFlag")) {
/* 2573 */       return 15;
/*      */     }
/* 2575 */     if (strFieldName.equals("subRiskFlag")) {
/* 2576 */       return 16;
/*      */     }
/* 2578 */     if (strFieldName.equals("calDigital")) {
/* 2579 */       return 17;
/*      */     }
/* 2581 */     if (strFieldName.equals("calChoMode")) {
/* 2582 */       return 18;
/*      */     }
/* 2584 */     if (strFieldName.equals("riskAmntMult")) {
/* 2585 */       return 19;
/*      */     }
/* 2587 */     if (strFieldName.equals("insuPeriodFlag")) {
/* 2588 */       return 20;
/*      */     }
/* 2590 */     if (strFieldName.equals("maxEndPeriod")) {
/* 2591 */       return 21;
/*      */     }
/* 2593 */     if (strFieldName.equals("ageLmt")) {
/* 2594 */       return 22;
/*      */     }
/* 2596 */     if (strFieldName.equals("signDateCalMode")) {
/* 2597 */       return 23;
/*      */     }
/* 2599 */     if (strFieldName.equals("protocolFlag")) {
/* 2600 */       return 24;
/*      */     }
/* 2602 */     if (strFieldName.equals("getChgFlag")) {
/* 2603 */       return 25;
/*      */     }
/* 2605 */     if (strFieldName.equals("protocolPayFlag")) {
/* 2606 */       return 26;
/*      */     }
/* 2608 */     if (strFieldName.equals("ensuPlanFlag")) {
/* 2609 */       return 27;
/*      */     }
/* 2611 */     if (strFieldName.equals("ensuPlanAdjFlag")) {
/* 2612 */       return 28;
/*      */     }
/* 2614 */     if (strFieldName.equals("startDate")) {
/* 2615 */       return 29;
/*      */     }
/* 2617 */     if (strFieldName.equals("endDate")) {
/* 2618 */       return 30;
/*      */     }
/* 2620 */     if (strFieldName.equals("minAppntAge")) {
/* 2621 */       return 31;
/*      */     }
/* 2623 */     if (strFieldName.equals("maxAppntAge")) {
/* 2624 */       return 32;
/*      */     }
/* 2626 */     if (strFieldName.equals("maxInsuredAge")) {
/* 2627 */       return 33;
/*      */     }
/* 2629 */     if (strFieldName.equals("minInsuredAge")) {
/* 2630 */       return 34;
/*      */     }
/* 2632 */     if (strFieldName.equals("appInterest")) {
/* 2633 */       return 35;
/*      */     }
/* 2635 */     if (strFieldName.equals("appPremRate")) {
/* 2636 */       return 36;
/*      */     }
/* 2638 */     if (strFieldName.equals("insuredFlag")) {
/* 2639 */       return 37;
/*      */     }
/* 2641 */     if (strFieldName.equals("shareFlag")) {
/* 2642 */       return 38;
/*      */     }
/* 2644 */     if (strFieldName.equals("bnfFlag")) {
/* 2645 */       return 39;
/*      */     }
/* 2647 */     if (strFieldName.equals("tempPayFlag")) {
/* 2648 */       return 40;
/*      */     }
/* 2650 */     if (strFieldName.equals("inpPayPlan")) {
/* 2651 */       return 41;
/*      */     }
/* 2653 */     if (strFieldName.equals("impartFlag")) {
/* 2654 */       return 42;
/*      */     }
/* 2656 */     if (strFieldName.equals("insuExpeFlag")) {
/* 2657 */       return 43;
/*      */     }
/* 2659 */     if (strFieldName.equals("loanFalg")) {
/* 2660 */       return 44;
/*      */     }
/* 2662 */     if (strFieldName.equals("mortagageFlag")) {
/* 2663 */       return 45;
/*      */     }
/* 2665 */     if (strFieldName.equals("iDifReturnFlag")) {
/* 2666 */       return 46;
/*      */     }
/* 2668 */     if (strFieldName.equals("cutAmntStopPay")) {
/* 2669 */       return 47;
/*      */     }
/* 2671 */     if (strFieldName.equals("rinsRate")) {
/* 2672 */       return 48;
/*      */     }
/* 2674 */     if (strFieldName.equals("saleFlag")) {
/* 2675 */       return 49;
/*      */     }
/* 2677 */     if (strFieldName.equals("fileAppFlag")) {
/* 2678 */       return 50;
/*      */     }
/* 2680 */     if (strFieldName.equals("mngCom")) {
/* 2681 */       return 51;
/*      */     }
/* 2683 */     if (strFieldName.equals("autoPayFlag")) {
/* 2684 */       return 52;
/*      */     }
/* 2686 */     if (strFieldName.equals("needPrintHospital")) {
/* 2687 */       return 53;
/*      */     }
/* 2689 */     if (strFieldName.equals("needPrintGet")) {
/* 2690 */       return 54;
/*      */     }
/* 2692 */     if (strFieldName.equals("riskType3")) {
/* 2693 */       return 55;
/*      */     }
/* 2695 */     if (strFieldName.equals("riskType4")) {
/* 2696 */       return 56;
/*      */     }
/* 2698 */     if (strFieldName.equals("riskType5")) {
/* 2699 */       return 57;
/*      */     }
/* 2701 */     if (strFieldName.equals("notPrintPol")) {
/* 2702 */       return 58;
/*      */     }
/* 2704 */     if (strFieldName.equals("needGetPolDate")) {
/* 2705 */       return 59;
/*      */     }
/* 2707 */     if (strFieldName.equals("needReReadBank")) {
/* 2708 */       return 60;
/*      */     }
/* 2710 */     if (strFieldName.equals("specFlag")) {
/* 2711 */       return 61;
/*      */     }
/* 2713 */     if (strFieldName.equals("interestDifFlag")) {
/* 2714 */       return 62;
/*      */     }
/* 2716 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2722 */     String strFieldName = "";
/* 2723 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2725 */       strFieldName = "riskCode";
/* 2726 */       break;
/*      */     case 1:
/* 2728 */       strFieldName = "riskVer";
/* 2729 */       break;
/*      */     case 2:
/* 2731 */       strFieldName = "riskName";
/* 2732 */       break;
/*      */     case 3:
/* 2734 */       strFieldName = "kindCode";
/* 2735 */       break;
/*      */     case 4:
/* 2737 */       strFieldName = "riskType";
/* 2738 */       break;
/*      */     case 5:
/* 2740 */       strFieldName = "riskType1";
/* 2741 */       break;
/*      */     case 6:
/* 2743 */       strFieldName = "riskType2";
/* 2744 */       break;
/*      */     case 7:
/* 2746 */       strFieldName = "riskProp";
/* 2747 */       break;
/*      */     case 8:
/* 2749 */       strFieldName = "riskPeriod";
/* 2750 */       break;
/*      */     case 9:
/* 2752 */       strFieldName = "riskTypeDetail";
/* 2753 */       break;
/*      */     case 10:
/* 2755 */       strFieldName = "riskFlag";
/* 2756 */       break;
/*      */     case 11:
/* 2758 */       strFieldName = "polType";
/* 2759 */       break;
/*      */     case 12:
/* 2761 */       strFieldName = "investFlag";
/* 2762 */       break;
/*      */     case 13:
/* 2764 */       strFieldName = "bonusFlag";
/* 2765 */       break;
/*      */     case 14:
/* 2767 */       strFieldName = "bonusMode";
/* 2768 */       break;
/*      */     case 15:
/* 2770 */       strFieldName = "listFlag";
/* 2771 */       break;
/*      */     case 16:
/* 2773 */       strFieldName = "subRiskFlag";
/* 2774 */       break;
/*      */     case 17:
/* 2776 */       strFieldName = "calDigital";
/* 2777 */       break;
/*      */     case 18:
/* 2779 */       strFieldName = "calChoMode";
/* 2780 */       break;
/*      */     case 19:
/* 2782 */       strFieldName = "riskAmntMult";
/* 2783 */       break;
/*      */     case 20:
/* 2785 */       strFieldName = "insuPeriodFlag";
/* 2786 */       break;
/*      */     case 21:
/* 2788 */       strFieldName = "maxEndPeriod";
/* 2789 */       break;
/*      */     case 22:
/* 2791 */       strFieldName = "ageLmt";
/* 2792 */       break;
/*      */     case 23:
/* 2794 */       strFieldName = "signDateCalMode";
/* 2795 */       break;
/*      */     case 24:
/* 2797 */       strFieldName = "protocolFlag";
/* 2798 */       break;
/*      */     case 25:
/* 2800 */       strFieldName = "getChgFlag";
/* 2801 */       break;
/*      */     case 26:
/* 2803 */       strFieldName = "protocolPayFlag";
/* 2804 */       break;
/*      */     case 27:
/* 2806 */       strFieldName = "ensuPlanFlag";
/* 2807 */       break;
/*      */     case 28:
/* 2809 */       strFieldName = "ensuPlanAdjFlag";
/* 2810 */       break;
/*      */     case 29:
/* 2812 */       strFieldName = "startDate";
/* 2813 */       break;
/*      */     case 30:
/* 2815 */       strFieldName = "endDate";
/* 2816 */       break;
/*      */     case 31:
/* 2818 */       strFieldName = "minAppntAge";
/* 2819 */       break;
/*      */     case 32:
/* 2821 */       strFieldName = "maxAppntAge";
/* 2822 */       break;
/*      */     case 33:
/* 2824 */       strFieldName = "maxInsuredAge";
/* 2825 */       break;
/*      */     case 34:
/* 2827 */       strFieldName = "minInsuredAge";
/* 2828 */       break;
/*      */     case 35:
/* 2830 */       strFieldName = "appInterest";
/* 2831 */       break;
/*      */     case 36:
/* 2833 */       strFieldName = "appPremRate";
/* 2834 */       break;
/*      */     case 37:
/* 2836 */       strFieldName = "insuredFlag";
/* 2837 */       break;
/*      */     case 38:
/* 2839 */       strFieldName = "shareFlag";
/* 2840 */       break;
/*      */     case 39:
/* 2842 */       strFieldName = "bnfFlag";
/* 2843 */       break;
/*      */     case 40:
/* 2845 */       strFieldName = "tempPayFlag";
/* 2846 */       break;
/*      */     case 41:
/* 2848 */       strFieldName = "inpPayPlan";
/* 2849 */       break;
/*      */     case 42:
/* 2851 */       strFieldName = "impartFlag";
/* 2852 */       break;
/*      */     case 43:
/* 2854 */       strFieldName = "insuExpeFlag";
/* 2855 */       break;
/*      */     case 44:
/* 2857 */       strFieldName = "loanFalg";
/* 2858 */       break;
/*      */     case 45:
/* 2860 */       strFieldName = "mortagageFlag";
/* 2861 */       break;
/*      */     case 46:
/* 2863 */       strFieldName = "iDifReturnFlag";
/* 2864 */       break;
/*      */     case 47:
/* 2866 */       strFieldName = "cutAmntStopPay";
/* 2867 */       break;
/*      */     case 48:
/* 2869 */       strFieldName = "rinsRate";
/* 2870 */       break;
/*      */     case 49:
/* 2872 */       strFieldName = "saleFlag";
/* 2873 */       break;
/*      */     case 50:
/* 2875 */       strFieldName = "fileAppFlag";
/* 2876 */       break;
/*      */     case 51:
/* 2878 */       strFieldName = "mngCom";
/* 2879 */       break;
/*      */     case 52:
/* 2881 */       strFieldName = "autoPayFlag";
/* 2882 */       break;
/*      */     case 53:
/* 2884 */       strFieldName = "needPrintHospital";
/* 2885 */       break;
/*      */     case 54:
/* 2887 */       strFieldName = "needPrintGet";
/* 2888 */       break;
/*      */     case 55:
/* 2890 */       strFieldName = "riskType3";
/* 2891 */       break;
/*      */     case 56:
/* 2893 */       strFieldName = "riskType4";
/* 2894 */       break;
/*      */     case 57:
/* 2896 */       strFieldName = "riskType5";
/* 2897 */       break;
/*      */     case 58:
/* 2899 */       strFieldName = "notPrintPol";
/* 2900 */       break;
/*      */     case 59:
/* 2902 */       strFieldName = "needGetPolDate";
/* 2903 */       break;
/*      */     case 60:
/* 2905 */       strFieldName = "needReReadBank";
/* 2906 */       break;
/*      */     case 61:
/* 2908 */       strFieldName = "specFlag";
/* 2909 */       break;
/*      */     case 62:
/* 2911 */       strFieldName = "interestDifFlag";
/* 2912 */       break;
/*      */     default:
/* 2914 */       strFieldName = "";
/*      */     }
/* 2916 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2922 */     if (strFieldName.equals("riskCode")) {
/* 2923 */       return 0;
/*      */     }
/* 2925 */     if (strFieldName.equals("riskVer")) {
/* 2926 */       return 0;
/*      */     }
/* 2928 */     if (strFieldName.equals("riskName")) {
/* 2929 */       return 0;
/*      */     }
/* 2931 */     if (strFieldName.equals("kindCode")) {
/* 2932 */       return 0;
/*      */     }
/* 2934 */     if (strFieldName.equals("riskType")) {
/* 2935 */       return 0;
/*      */     }
/* 2937 */     if (strFieldName.equals("riskType1")) {
/* 2938 */       return 0;
/*      */     }
/* 2940 */     if (strFieldName.equals("riskType2")) {
/* 2941 */       return 0;
/*      */     }
/* 2943 */     if (strFieldName.equals("riskProp")) {
/* 2944 */       return 0;
/*      */     }
/* 2946 */     if (strFieldName.equals("riskPeriod")) {
/* 2947 */       return 0;
/*      */     }
/* 2949 */     if (strFieldName.equals("riskTypeDetail")) {
/* 2950 */       return 0;
/*      */     }
/* 2952 */     if (strFieldName.equals("riskFlag")) {
/* 2953 */       return 0;
/*      */     }
/* 2955 */     if (strFieldName.equals("polType")) {
/* 2956 */       return 0;
/*      */     }
/* 2958 */     if (strFieldName.equals("investFlag")) {
/* 2959 */       return 0;
/*      */     }
/* 2961 */     if (strFieldName.equals("bonusFlag")) {
/* 2962 */       return 0;
/*      */     }
/* 2964 */     if (strFieldName.equals("bonusMode")) {
/* 2965 */       return 0;
/*      */     }
/* 2967 */     if (strFieldName.equals("listFlag")) {
/* 2968 */       return 0;
/*      */     }
/* 2970 */     if (strFieldName.equals("subRiskFlag")) {
/* 2971 */       return 0;
/*      */     }
/* 2973 */     if (strFieldName.equals("calDigital")) {
/* 2974 */       return 3;
/*      */     }
/* 2976 */     if (strFieldName.equals("calChoMode")) {
/* 2977 */       return 0;
/*      */     }
/* 2979 */     if (strFieldName.equals("riskAmntMult")) {
/* 2980 */       return 3;
/*      */     }
/* 2982 */     if (strFieldName.equals("insuPeriodFlag")) {
/* 2983 */       return 0;
/*      */     }
/* 2985 */     if (strFieldName.equals("maxEndPeriod")) {
/* 2986 */       return 3;
/*      */     }
/* 2988 */     if (strFieldName.equals("ageLmt")) {
/* 2989 */       return 3;
/*      */     }
/* 2991 */     if (strFieldName.equals("signDateCalMode")) {
/* 2992 */       return 3;
/*      */     }
/* 2994 */     if (strFieldName.equals("protocolFlag")) {
/* 2995 */       return 0;
/*      */     }
/* 2997 */     if (strFieldName.equals("getChgFlag")) {
/* 2998 */       return 0;
/*      */     }
/* 3000 */     if (strFieldName.equals("protocolPayFlag")) {
/* 3001 */       return 0;
/*      */     }
/* 3003 */     if (strFieldName.equals("ensuPlanFlag")) {
/* 3004 */       return 0;
/*      */     }
/* 3006 */     if (strFieldName.equals("ensuPlanAdjFlag")) {
/* 3007 */       return 0;
/*      */     }
/* 3009 */     if (strFieldName.equals("startDate")) {
/* 3010 */       return 1;
/*      */     }
/* 3012 */     if (strFieldName.equals("endDate")) {
/* 3013 */       return 1;
/*      */     }
/* 3015 */     if (strFieldName.equals("minAppntAge")) {
/* 3016 */       return 3;
/*      */     }
/* 3018 */     if (strFieldName.equals("maxAppntAge")) {
/* 3019 */       return 3;
/*      */     }
/* 3021 */     if (strFieldName.equals("maxInsuredAge")) {
/* 3022 */       return 3;
/*      */     }
/* 3024 */     if (strFieldName.equals("minInsuredAge")) {
/* 3025 */       return 3;
/*      */     }
/* 3027 */     if (strFieldName.equals("appInterest")) {
/* 3028 */       return 4;
/*      */     }
/* 3030 */     if (strFieldName.equals("appPremRate")) {
/* 3031 */       return 4;
/*      */     }
/* 3033 */     if (strFieldName.equals("insuredFlag")) {
/* 3034 */       return 0;
/*      */     }
/* 3036 */     if (strFieldName.equals("shareFlag")) {
/* 3037 */       return 0;
/*      */     }
/* 3039 */     if (strFieldName.equals("bnfFlag")) {
/* 3040 */       return 0;
/*      */     }
/* 3042 */     if (strFieldName.equals("tempPayFlag")) {
/* 3043 */       return 0;
/*      */     }
/* 3045 */     if (strFieldName.equals("inpPayPlan")) {
/* 3046 */       return 0;
/*      */     }
/* 3048 */     if (strFieldName.equals("impartFlag")) {
/* 3049 */       return 0;
/*      */     }
/* 3051 */     if (strFieldName.equals("insuExpeFlag")) {
/* 3052 */       return 0;
/*      */     }
/* 3054 */     if (strFieldName.equals("loanFalg")) {
/* 3055 */       return 0;
/*      */     }
/* 3057 */     if (strFieldName.equals("mortagageFlag")) {
/* 3058 */       return 0;
/*      */     }
/* 3060 */     if (strFieldName.equals("iDifReturnFlag")) {
/* 3061 */       return 0;
/*      */     }
/* 3063 */     if (strFieldName.equals("cutAmntStopPay")) {
/* 3064 */       return 0;
/*      */     }
/* 3066 */     if (strFieldName.equals("rinsRate")) {
/* 3067 */       return 4;
/*      */     }
/* 3069 */     if (strFieldName.equals("saleFlag")) {
/* 3070 */       return 0;
/*      */     }
/* 3072 */     if (strFieldName.equals("fileAppFlag")) {
/* 3073 */       return 0;
/*      */     }
/* 3075 */     if (strFieldName.equals("mngCom")) {
/* 3076 */       return 0;
/*      */     }
/* 3078 */     if (strFieldName.equals("autoPayFlag")) {
/* 3079 */       return 0;
/*      */     }
/* 3081 */     if (strFieldName.equals("needPrintHospital")) {
/* 3082 */       return 0;
/*      */     }
/* 3084 */     if (strFieldName.equals("needPrintGet")) {
/* 3085 */       return 0;
/*      */     }
/* 3087 */     if (strFieldName.equals("riskType3")) {
/* 3088 */       return 0;
/*      */     }
/* 3090 */     if (strFieldName.equals("riskType4")) {
/* 3091 */       return 0;
/*      */     }
/* 3093 */     if (strFieldName.equals("riskType5")) {
/* 3094 */       return 0;
/*      */     }
/* 3096 */     if (strFieldName.equals("notPrintPol")) {
/* 3097 */       return 0;
/*      */     }
/* 3099 */     if (strFieldName.equals("needGetPolDate")) {
/* 3100 */       return 0;
/*      */     }
/* 3102 */     if (strFieldName.equals("needReReadBank")) {
/* 3103 */       return 0;
/*      */     }
/* 3105 */     if (strFieldName.equals("specFlag")) {
/* 3106 */       return 0;
/*      */     }
/* 3108 */     if (strFieldName.equals("interestDifFlag")) {
/* 3109 */       return 0;
/*      */     }
/* 3111 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 3117 */     int nFieldType = -1;
/* 3118 */     switch (nFieldIndex) {
/*      */     case 0:
/* 3120 */       nFieldType = 0;
/* 3121 */       break;
/*      */     case 1:
/* 3123 */       nFieldType = 0;
/* 3124 */       break;
/*      */     case 2:
/* 3126 */       nFieldType = 0;
/* 3127 */       break;
/*      */     case 3:
/* 3129 */       nFieldType = 0;
/* 3130 */       break;
/*      */     case 4:
/* 3132 */       nFieldType = 0;
/* 3133 */       break;
/*      */     case 5:
/* 3135 */       nFieldType = 0;
/* 3136 */       break;
/*      */     case 6:
/* 3138 */       nFieldType = 0;
/* 3139 */       break;
/*      */     case 7:
/* 3141 */       nFieldType = 0;
/* 3142 */       break;
/*      */     case 8:
/* 3144 */       nFieldType = 0;
/* 3145 */       break;
/*      */     case 9:
/* 3147 */       nFieldType = 0;
/* 3148 */       break;
/*      */     case 10:
/* 3150 */       nFieldType = 0;
/* 3151 */       break;
/*      */     case 11:
/* 3153 */       nFieldType = 0;
/* 3154 */       break;
/*      */     case 12:
/* 3156 */       nFieldType = 0;
/* 3157 */       break;
/*      */     case 13:
/* 3159 */       nFieldType = 0;
/* 3160 */       break;
/*      */     case 14:
/* 3162 */       nFieldType = 0;
/* 3163 */       break;
/*      */     case 15:
/* 3165 */       nFieldType = 0;
/* 3166 */       break;
/*      */     case 16:
/* 3168 */       nFieldType = 0;
/* 3169 */       break;
/*      */     case 17:
/* 3171 */       nFieldType = 3;
/* 3172 */       break;
/*      */     case 18:
/* 3174 */       nFieldType = 0;
/* 3175 */       break;
/*      */     case 19:
/* 3177 */       nFieldType = 3;
/* 3178 */       break;
/*      */     case 20:
/* 3180 */       nFieldType = 0;
/* 3181 */       break;
/*      */     case 21:
/* 3183 */       nFieldType = 3;
/* 3184 */       break;
/*      */     case 22:
/* 3186 */       nFieldType = 3;
/* 3187 */       break;
/*      */     case 23:
/* 3189 */       nFieldType = 3;
/* 3190 */       break;
/*      */     case 24:
/* 3192 */       nFieldType = 0;
/* 3193 */       break;
/*      */     case 25:
/* 3195 */       nFieldType = 0;
/* 3196 */       break;
/*      */     case 26:
/* 3198 */       nFieldType = 0;
/* 3199 */       break;
/*      */     case 27:
/* 3201 */       nFieldType = 0;
/* 3202 */       break;
/*      */     case 28:
/* 3204 */       nFieldType = 0;
/* 3205 */       break;
/*      */     case 29:
/* 3207 */       nFieldType = 1;
/* 3208 */       break;
/*      */     case 30:
/* 3210 */       nFieldType = 1;
/* 3211 */       break;
/*      */     case 31:
/* 3213 */       nFieldType = 3;
/* 3214 */       break;
/*      */     case 32:
/* 3216 */       nFieldType = 3;
/* 3217 */       break;
/*      */     case 33:
/* 3219 */       nFieldType = 3;
/* 3220 */       break;
/*      */     case 34:
/* 3222 */       nFieldType = 3;
/* 3223 */       break;
/*      */     case 35:
/* 3225 */       nFieldType = 4;
/* 3226 */       break;
/*      */     case 36:
/* 3228 */       nFieldType = 4;
/* 3229 */       break;
/*      */     case 37:
/* 3231 */       nFieldType = 0;
/* 3232 */       break;
/*      */     case 38:
/* 3234 */       nFieldType = 0;
/* 3235 */       break;
/*      */     case 39:
/* 3237 */       nFieldType = 0;
/* 3238 */       break;
/*      */     case 40:
/* 3240 */       nFieldType = 0;
/* 3241 */       break;
/*      */     case 41:
/* 3243 */       nFieldType = 0;
/* 3244 */       break;
/*      */     case 42:
/* 3246 */       nFieldType = 0;
/* 3247 */       break;
/*      */     case 43:
/* 3249 */       nFieldType = 0;
/* 3250 */       break;
/*      */     case 44:
/* 3252 */       nFieldType = 0;
/* 3253 */       break;
/*      */     case 45:
/* 3255 */       nFieldType = 0;
/* 3256 */       break;
/*      */     case 46:
/* 3258 */       nFieldType = 0;
/* 3259 */       break;
/*      */     case 47:
/* 3261 */       nFieldType = 0;
/* 3262 */       break;
/*      */     case 48:
/* 3264 */       nFieldType = 4;
/* 3265 */       break;
/*      */     case 49:
/* 3267 */       nFieldType = 0;
/* 3268 */       break;
/*      */     case 50:
/* 3270 */       nFieldType = 0;
/* 3271 */       break;
/*      */     case 51:
/* 3273 */       nFieldType = 0;
/* 3274 */       break;
/*      */     case 52:
/* 3276 */       nFieldType = 0;
/* 3277 */       break;
/*      */     case 53:
/* 3279 */       nFieldType = 0;
/* 3280 */       break;
/*      */     case 54:
/* 3282 */       nFieldType = 0;
/* 3283 */       break;
/*      */     case 55:
/* 3285 */       nFieldType = 0;
/* 3286 */       break;
/*      */     case 56:
/* 3288 */       nFieldType = 0;
/* 3289 */       break;
/*      */     case 57:
/* 3291 */       nFieldType = 0;
/* 3292 */       break;
/*      */     case 58:
/* 3294 */       nFieldType = 0;
/* 3295 */       break;
/*      */     case 59:
/* 3297 */       nFieldType = 0;
/* 3298 */       break;
/*      */     case 60:
/* 3300 */       nFieldType = 0;
/* 3301 */       break;
/*      */     case 61:
/* 3303 */       nFieldType = 0;
/* 3304 */       break;
/*      */     case 62:
/* 3306 */       nFieldType = 0;
/* 3307 */       break;
/*      */     default:
/* 3309 */       nFieldType = -1;
/*      */     }
/* 3311 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskAppSchema
 * JD-Core Version:    0.6.0
 */