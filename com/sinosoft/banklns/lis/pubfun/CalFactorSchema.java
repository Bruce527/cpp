/*      */ package com.sinosoft.banklns.lis.pubfun;
/*      */ 
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ 
/*      */ public class CalFactorSchema
/*      */   implements Cloneable
/*      */ {
/*      */   private String Name;
/*      */   private String Sex;
/*      */   private String Birthday;
/*      */   private String IDNo;
/*      */   private String IDType;
/*      */   private String OccupationType;
/*      */   private String GetKind;
/*      */   private String Prem;
/*      */   private String TopUpPrem;
/*      */   private String DeadAmntType;
/*      */   private String Get;
/*      */   private String PayMode;
/*      */   private double FloatRate;
/*      */   private double Mult;
/*      */   private int PayIntv;
/*      */   private int GetIntv;
/*      */   private int PayEndYear;
/*      */   private String PayEndYearFlag;
/*      */   private int GetYear;
/*      */   private String GetYearFlag;
/*      */   private String GetDutyKind;
/*      */   private String StartDateCalRef;
/*      */   private int Years;
/*      */   private int InsuYear;
/*      */   private String InsuYearFlag;
/*      */   private int AppAge;
/*      */   private int AppAgeType;
/*      */   private String Job;
/*      */   private int AppntAgeType;
/*      */   private int AppntAge;
/*      */   private String GDuty;
/*      */   private int Count;
/*      */   private int RnewFlag;
/*      */   private double AddRate;
/*      */   private String ContNo;
/*      */   private String GrpPolNo;
/*      */   private double Amnt;
/*      */   private double RiskAmnt;
/*      */   private String GrpContNo;
/*      */   private String PolNo;
/*      */   private String RiskCode;
/*      */   private String PayLocation;
/*      */   private String GetStartType;
/*      */   private String LiveGetMode;
/*      */   private String RelFlag;
/*      */   private String SubRiskFlag;
/*      */   private String StandbyFlag2;
/*      */   private String StandbyFlag3;
/*      */   private String StandbyFlag1;
/*      */   private String BonusGetMode;
/*      */   private String AppntNo;
/*      */   private int PayYears;
/*      */   private String EdorNo;
/*      */   private String CalType;
/*      */   private double GetLimit;
/*      */   private double GetRate;
/*      */   private String SSFlag;
/*      */   private double PeakLine;
/*      */   private String CValiDate;
/*      */   private double SuppRiskScore;
/*      */   private double FirstScore;
/*      */   private double SecondScore;
/*      */   private String DutyCode;
/*      */   private String VPU;
/*      */   private String SecondInsuredNo;
/*      */   private String InsuredNo;
/*      */   private String MainPolNo;
/*      */   private String AppAg2;
/*      */   private String AppAg2Type;
/*      */   private double HusbandScore;
/*      */   private double WifeScore;
/*      */   private String LSumDangerAmnt;
/*      */   private String DSumDangerAmnt;
/*      */   private String ASumDangerAmnt;
/*      */   private String MSumDangerAmnt;
/*      */   private String SSumDangerAmnt;
/*      */   private String ManageCom;
/*      */   private String AppntJob;
/*      */   private String MainRiskGet;
/*      */   private String RiskSort;
/*      */   private String CustomerNo;
/*      */   private String Occupation;
/*      */   private String MAmnt;
/*      */   private String AppAge2;
/*      */   private String AppAge2Type;
/*      */   private String RiskChannel;
/*      */   private String LifeFlag;
/*      */   private String RelationToAppnt;
/*      */   private String AppntNativePlace;
/*      */   private String InsuredNativePlace;
/*      */ 
/*      */   public Object clone()
/*      */   {
/*  134 */     Object o = null;
/*      */     try {
/*  136 */       o = (CalFactorSchema)super.clone();
/*      */     }
/*      */     catch (CloneNotSupportedException e)
/*      */     {
/*  141 */       System.out.println(e.toString());
/*      */     }
/*  143 */     return o;
/*      */   }
/*      */ 
/*      */   public String getTopUpPrem()
/*      */   {
/*  149 */     return this.TopUpPrem;
/*      */   }
/*      */ 
/*      */   public void setTopUpPrem(String topUpPrem)
/*      */   {
/*  155 */     this.TopUpPrem = topUpPrem;
/*      */   }
/*      */ 
/*      */   public String getDeadAmntType()
/*      */   {
/*  161 */     return this.DeadAmntType;
/*      */   }
/*      */ 
/*      */   public void setDeadAmntType(String deadAmntType)
/*      */   {
/*  167 */     this.DeadAmntType = deadAmntType;
/*      */   }
/*      */ 
/*      */   public int getAppAgeType()
/*      */   {
/*  173 */     return this.AppAgeType;
/*      */   }
/*      */ 
/*      */   public void setAppAgeType(int appAgeType)
/*      */   {
/*  179 */     this.AppAgeType = appAgeType;
/*      */   }
/*      */ 
/*      */   public int getAppntAgeType()
/*      */   {
/*  185 */     return this.AppntAgeType;
/*      */   }
/*      */ 
/*      */   public void setAppntAgeType(int appntAgeType)
/*      */   {
/*  191 */     this.AppntAgeType = appntAgeType;
/*      */   }
/*      */ 
/*      */   public String getAppAg2Type()
/*      */   {
/*  197 */     return this.AppAg2Type;
/*      */   }
/*      */ 
/*      */   public void setAppAg2Type(String appAg2Type)
/*      */   {
/*  203 */     this.AppAg2Type = appAg2Type;
/*      */   }
/*      */ 
/*      */   public String getAppAge2Type()
/*      */   {
/*  209 */     return this.AppAge2Type;
/*      */   }
/*      */ 
/*      */   public void setAppAge2Type(String appAge2Type)
/*      */   {
/*  215 */     this.AppAge2Type = appAge2Type;
/*      */   }
/*      */ 
/*      */   public void setLiveGetMode(String tLiveGetMode)
/*      */   {
/*  222 */     this.LiveGetMode = tLiveGetMode;
/*      */   }
/*      */ 
/*      */   public String getLiveGetMode() {
/*  226 */     return this.LiveGetMode;
/*      */   }
/*      */ 
/*      */   public void setMainPolNo(String tMainPolNo) {
/*  230 */     this.MainPolNo = tMainPolNo;
/*      */   }
/*      */ 
/*      */   public String getMainPolNo() {
/*  234 */     return this.MainPolNo;
/*      */   }
/*      */ 
/*      */   public void setGetStartType(String tGetStartType) {
/*  238 */     this.GetStartType = tGetStartType;
/*      */   }
/*      */ 
/*      */   public String getGetStartType() {
/*  242 */     return this.GetStartType;
/*      */   }
/*      */ 
/*      */   public void setPayLocation(String tPayLocation)
/*      */   {
/*  247 */     this.PayLocation = tPayLocation;
/*      */   }
/*      */ 
/*      */   public String getPayLocation() {
/*  251 */     return this.PayLocation;
/*      */   }
/*      */ 
/*      */   public void setName(String tName)
/*      */   {
/*  256 */     this.Name = tName;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  260 */     return this.Name;
/*      */   }
/*      */ 
/*      */   public void setSex(String tSex)
/*      */   {
/*  265 */     this.Sex = tSex;
/*      */   }
/*      */ 
/*      */   public String getSex() {
/*  269 */     return this.Sex;
/*      */   }
/*      */ 
/*      */   public void setInsuredNo(String tInsuredNo) {
/*  273 */     this.InsuredNo = tInsuredNo;
/*      */   }
/*      */ 
/*      */   public String getInsuredNo() {
/*  277 */     return this.InsuredNo;
/*      */   }
/*      */ 
/*      */   public void setAppntNo(String tAppntNo) {
/*  281 */     this.AppntNo = tAppntNo;
/*      */   }
/*      */ 
/*      */   public String getAppntNo() {
/*  285 */     return this.AppntNo;
/*      */   }
/*      */ 
/*      */   public void setBirthday(String tBirthday)
/*      */   {
/*  290 */     this.Birthday = tBirthday;
/*      */   }
/*      */ 
/*      */   public String getBirthday() {
/*  294 */     return this.Birthday;
/*      */   }
/*      */ 
/*      */   public void setIDNo(String tIDNo)
/*      */   {
/*  299 */     this.IDNo = tIDNo;
/*      */   }
/*      */ 
/*      */   public String getIDNo() {
/*  303 */     return this.IDNo;
/*      */   }
/*      */ 
/*      */   public void setIDType(String tIDType)
/*      */   {
/*  308 */     this.IDType = tIDType;
/*      */   }
/*      */ 
/*      */   public String getIDType() {
/*  312 */     return this.IDType;
/*      */   }
/*      */ 
/*      */   public void setBonusGetMode(String getMode)
/*      */   {
/*  317 */     this.BonusGetMode = getMode;
/*      */   }
/*      */ 
/*      */   public String getBonusGetMode() {
/*  321 */     return this.BonusGetMode;
/*      */   }
/*      */ 
/*      */   public void setOccupationType(String tOccupationType)
/*      */   {
/*  326 */     this.OccupationType = tOccupationType;
/*      */   }
/*      */ 
/*      */   public String getOccupationType() {
/*  330 */     return this.OccupationType;
/*      */   }
/*      */ 
/*      */   public void setCValiDate(String tCValiDate) {
/*  334 */     this.CValiDate = tCValiDate;
/*      */   }
/*      */ 
/*      */   public String getCValiDate() {
/*  338 */     return this.CValiDate;
/*      */   }
/*      */ 
/*      */   public void setGetKind(String tGetKind)
/*      */   {
/*  343 */     this.GetKind = tGetKind;
/*      */   }
/*      */ 
/*      */   public String getGetKind() {
/*  347 */     return this.GetKind;
/*      */   }
/*      */ 
/*      */   public void setPrem(String tPrem)
/*      */   {
/*  352 */     this.Prem = tPrem;
/*      */   }
/*      */ 
/*      */   public String getPrem() {
/*  356 */     return this.Prem;
/*      */   }
/*      */ 
/*      */   public void setGet(String tGet)
/*      */   {
/*  361 */     this.Get = tGet;
/*      */   }
/*      */ 
/*      */   public String getGet() {
/*  365 */     return this.Get;
/*      */   }
/*      */ 
/*      */   public void setPayMode(String tPayMode)
/*      */   {
/*  370 */     this.PayMode = tPayMode;
/*      */   }
/*      */ 
/*      */   public String getPayMode() {
/*  374 */     return this.PayMode;
/*      */   }
/*      */ 
/*      */   public void setFloatRate(double tFloatRate)
/*      */   {
/*  379 */     this.FloatRate = tFloatRate;
/*      */   }
/*      */ 
/*      */   public void setFloatRate(String aFloatRate) {
/*  383 */     if ((aFloatRate != null) && (!aFloatRate.equals(""))) {
/*  384 */       Double tDouble = new Double(aFloatRate);
/*  385 */       double d = tDouble.doubleValue();
/*  386 */       this.FloatRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getFloatRate() {
/*  391 */     return this.FloatRate;
/*      */   }
/*      */ 
/*      */   public void setAmnt(double tAmnt)
/*      */   {
/*  396 */     this.Amnt = tAmnt;
/*      */   }
/*      */ 
/*      */   public String getAmnt() {
/*  400 */     return String.valueOf(this.Amnt);
/*      */   }
/*      */ 
/*      */   public void setRiskAmnt(double tAmnt)
/*      */   {
/*  405 */     this.RiskAmnt = tAmnt;
/*      */   }
/*      */ 
/*      */   public String getRiskAmnt() {
/*  409 */     return String.valueOf(this.RiskAmnt);
/*      */   }
/*      */ 
/*      */   public void setMult(double tMult) {
/*  413 */     this.Mult = tMult;
/*      */   }
/*      */ 
/*      */   public String getMult() {
/*  417 */     return String.valueOf(this.Mult);
/*      */   }
/*      */ 
/*      */   public void setAddRate(double tAddRate) {
/*  421 */     this.AddRate = tAddRate;
/*      */   }
/*      */ 
/*      */   public String getAddRate() {
/*  425 */     return String.valueOf(this.AddRate);
/*      */   }
/*      */ 
/*      */   public void setPayIntv(int tPayIntv) {
/*  429 */     this.PayIntv = tPayIntv;
/*      */   }
/*      */ 
/*      */   public String getPayIntv() {
/*  433 */     return String.valueOf(this.PayIntv);
/*      */   }
/*      */ 
/*      */   public void setGetIntv(int tGetIntv) {
/*  437 */     this.GetIntv = tGetIntv;
/*      */   }
/*      */ 
/*      */   public String getGetIntv() {
/*  441 */     return String.valueOf(this.GetIntv);
/*      */   }
/*      */ 
/*      */   public void setPayEndYear(int tPayEndYear) {
/*  445 */     this.PayEndYear = tPayEndYear;
/*      */   }
/*      */ 
/*      */   public String getPayEndYear() {
/*  449 */     return String.valueOf(this.PayEndYear);
/*      */   }
/*      */ 
/*      */   public void setGetYear(int tGetYear) {
/*  453 */     this.GetYear = tGetYear;
/*      */   }
/*      */ 
/*      */   public String getGetYear() {
/*  457 */     return String.valueOf(this.GetYear);
/*      */   }
/*      */ 
/*      */   public void setYears(int tYears) {
/*  461 */     this.Years = tYears;
/*      */   }
/*      */ 
/*      */   public String getYears() {
/*  465 */     return String.valueOf(this.Years);
/*      */   }
/*      */ 
/*      */   public void setInsuYear(int tInsuYear) {
/*  469 */     this.InsuYear = tInsuYear;
/*      */   }
/*      */ 
/*      */   public String getInsuYear() {
/*  473 */     return String.valueOf(this.InsuYear);
/*      */   }
/*      */ 
/*      */   public void setPayYears(int tPayYears) {
/*  477 */     this.PayYears = tPayYears;
/*      */   }
/*      */ 
/*      */   public String getPayYears() {
/*  481 */     return String.valueOf(this.PayYears);
/*      */   }
/*      */ 
/*      */   public void setAppAge(int tAppAge) {
/*  485 */     this.AppAge = tAppAge;
/*      */   }
/*      */ 
/*      */   public String getAppAge() {
/*  489 */     return String.valueOf(this.AppAge);
/*      */   }
/*      */ 
/*      */   public void setCount(int tCount) {
/*  493 */     this.Count = tCount;
/*      */   }
/*      */ 
/*      */   public String getCount() {
/*  497 */     return String.valueOf(this.Count);
/*      */   }
/*      */ 
/*      */   public void setRnewFlag(int tRnewFlag) {
/*  501 */     this.RnewFlag = tRnewFlag;
/*      */   }
/*      */ 
/*      */   public String getRnewFlag() {
/*  505 */     return String.valueOf(this.RnewFlag);
/*      */   }
/*      */ 
/*      */   public void setInsuYearFlag(String tInsuYearFlag) {
/*  509 */     this.InsuYearFlag = tInsuYearFlag;
/*      */   }
/*      */ 
/*      */   public String getInsuYearFlag() {
/*  513 */     return this.InsuYearFlag;
/*      */   }
/*      */ 
/*      */   public void setPayEndYearFlag(String tPayEndYearFlag) {
/*  517 */     this.PayEndYearFlag = tPayEndYearFlag;
/*      */   }
/*      */ 
/*      */   public String getPayEndYearFlag() {
/*  521 */     return this.PayEndYearFlag;
/*      */   }
/*      */ 
/*      */   public void setGetYearFlag(String tGetYearFlag) {
/*  525 */     this.GetYearFlag = tGetYearFlag;
/*      */   }
/*      */ 
/*      */   public String getGetYearFlag() {
/*  529 */     return this.GetYearFlag;
/*      */   }
/*      */ 
/*      */   public void setGetDutyKind(String tGetDutyKind) {
/*  533 */     this.GetDutyKind = tGetDutyKind;
/*      */   }
/*      */ 
/*      */   public String getGetDutyKind() {
/*  537 */     return this.GetDutyKind;
/*      */   }
/*      */ 
/*      */   public void setStartDateCalRef(String tStartDateCalRef) {
/*  541 */     this.StartDateCalRef = tStartDateCalRef;
/*      */   }
/*      */ 
/*      */   public String getStartDateCalRef() {
/*  545 */     return this.StartDateCalRef;
/*      */   }
/*      */ 
/*      */   public void setJob(String tJob) {
/*  549 */     this.Job = tJob;
/*      */   }
/*      */ 
/*      */   public String getJob() {
/*  553 */     return this.Job;
/*      */   }
/*      */ 
/*      */   public void setGDuty(String tGDuty) {
/*  557 */     this.GDuty = tGDuty;
/*      */   }
/*      */ 
/*      */   public String getGDuty() {
/*  561 */     return this.GDuty;
/*      */   }
/*      */ 
/*      */   public void setContNo(String tContNo) {
/*  565 */     this.ContNo = tContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  569 */     return this.ContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpPolNo(String tGrpPolNo) {
/*  573 */     this.GrpPolNo = tGrpPolNo;
/*      */   }
/*      */ 
/*      */   public String getGrpPolNo() {
/*  577 */     return this.GrpPolNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String tGrpContNo) {
/*  581 */     this.GrpContNo = tGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getPolNo() {
/*  585 */     return this.PolNo;
/*      */   }
/*      */ 
/*      */   public void setPolNo(String tPolNo) {
/*  589 */     this.PolNo = tPolNo;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo() {
/*  593 */     return this.GrpContNo;
/*      */   }
/*      */ 
/*      */   public void setRiskCode(String tRiskCode) {
/*  597 */     this.RiskCode = tRiskCode;
/*      */   }
/*      */ 
/*      */   public String getRiskCode() {
/*  601 */     return this.RiskCode;
/*      */   }
/*      */ 
/*      */   public void setRelFlag(String tRelFlag)
/*      */   {
/*  606 */     this.RelFlag = tRelFlag;
/*      */   }
/*      */ 
/*      */   public String getRelFlag() {
/*  610 */     return this.RelFlag;
/*      */   }
/*      */ 
/*      */   public void setSubRiskFlag(String tSubRiskFlag)
/*      */   {
/*  615 */     this.SubRiskFlag = tSubRiskFlag;
/*      */   }
/*      */ 
/*      */   public String getSubRiskFlag() {
/*  619 */     return this.SubRiskFlag;
/*      */   }
/*      */ 
/*      */   public void setStandbyFlag1(String tStandbyFlag1) {
/*  623 */     this.StandbyFlag1 = tStandbyFlag1;
/*      */   }
/*      */ 
/*      */   public String getStandbyFlag1() {
/*  627 */     return this.StandbyFlag1;
/*      */   }
/*      */ 
/*      */   public void setStandbyFlag2(String tStandbyFlag2) {
/*  631 */     this.StandbyFlag2 = tStandbyFlag2;
/*      */   }
/*      */ 
/*      */   public String getStandbyFlag2() {
/*  635 */     return this.StandbyFlag2;
/*      */   }
/*      */ 
/*      */   public void setStandbyFlag3(String tStandbyFlag3) {
/*  639 */     this.StandbyFlag3 = tStandbyFlag3;
/*      */   }
/*      */ 
/*      */   public String getStandbyFlag3() {
/*  643 */     return this.StandbyFlag3;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue) {
/*  647 */     if (StrTool.cTrim(FCode).equals("")) {
/*  648 */       return false;
/*      */     }
/*      */ 
/*  651 */     if (FCode.equals("Name")) {
/*  652 */       if ((FValue != null) && (!FValue.equals("")))
/*  653 */         this.Name = FValue.trim();
/*      */       else {
/*  655 */         this.Name = null;
/*      */       }
/*      */     }
/*      */ 
/*  659 */     if (FCode.equals("Sex")) {
/*  660 */       if ((FValue != null) && (!FValue.equals("")))
/*  661 */         this.Sex = FValue.trim();
/*      */       else {
/*  663 */         this.Sex = null;
/*      */       }
/*      */     }
/*      */ 
/*  667 */     if (FCode.equals("Birthday")) {
/*  668 */       if ((FValue != null) && (!FValue.equals("")))
/*  669 */         this.Birthday = FValue.trim();
/*      */       else {
/*  671 */         this.Birthday = null;
/*      */       }
/*      */     }
/*      */ 
/*  675 */     if (FCode.equals("IDNo")) {
/*  676 */       if ((FValue != null) && (!FValue.equals("")))
/*  677 */         this.IDNo = FValue.trim();
/*      */       else {
/*  679 */         this.IDNo = null;
/*      */       }
/*      */     }
/*      */ 
/*  683 */     if (FCode.equals("IDType")) {
/*  684 */       if ((FValue != null) && (!FValue.equals("")))
/*  685 */         this.IDType = FValue.trim();
/*      */       else {
/*  687 */         this.IDType = null;
/*      */       }
/*      */     }
/*      */ 
/*  691 */     if (FCode.equals("OccupationType")) {
/*  692 */       if ((FValue != null) && (!FValue.equals("")))
/*  693 */         this.OccupationType = FValue.trim();
/*      */       else {
/*  695 */         this.OccupationType = null;
/*      */       }
/*      */     }
/*      */ 
/*  699 */     if (FCode.equals("CValiDate")) {
/*  700 */       if ((FValue != null) && (!FValue.equals("")))
/*  701 */         this.CValiDate = FValue.trim();
/*      */       else {
/*  703 */         this.CValiDate = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  708 */     if (FCode.equals("GetKind")) {
/*  709 */       if ((FValue != null) && (!FValue.equals("")))
/*  710 */         this.GetKind = FValue.trim();
/*      */       else {
/*  712 */         this.GetKind = null;
/*      */       }
/*      */     }
/*      */ 
/*  716 */     if (FCode.equals("Prem")) {
/*  717 */       if ((FValue != null) && (!FValue.equals("")))
/*  718 */         this.Prem = FValue.trim();
/*      */       else {
/*  720 */         this.Prem = null;
/*      */       }
/*      */     }
/*      */ 
/*  724 */     if (FCode.equals("Get")) {
/*  725 */       if ((FValue != null) && (!FValue.equals("")))
/*  726 */         this.Get = FValue.trim();
/*      */       else {
/*  728 */         this.Get = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  733 */     if (FCode.equals("PayMode")) {
/*  734 */       if ((FValue != null) && (!FValue.equals("")))
/*  735 */         this.PayMode = FValue.trim();
/*      */       else {
/*  737 */         this.PayMode = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  742 */     if ((FCode.equals("FloatRate")) && 
/*  743 */       (FValue != null) && (!FValue.equals(""))) {
/*  744 */       Double tDouble = new Double(FValue);
/*  745 */       double d = tDouble.doubleValue();
/*  746 */       this.FloatRate = d;
/*      */     }
/*      */ 
/*  751 */     if ((FCode.equals("Mult")) && 
/*  752 */       (FValue != null) && (!FValue.equals(""))) {
/*  753 */       Double tDouble = new Double(FValue);
/*  754 */       double d = tDouble.doubleValue();
/*  755 */       this.Mult = d;
/*      */     }
/*      */ 
/*  760 */     if ((FCode.equals("PayIntv")) && 
/*  761 */       (FValue != null) && (!FValue.equals(""))) {
/*  762 */       Integer tInteger = new Integer(FValue);
/*  763 */       int i = tInteger.intValue();
/*  764 */       this.PayIntv = i;
/*      */     }
/*      */ 
/*  769 */     if ((FCode.equals("GetIntv")) && 
/*  770 */       (FValue != null) && (!FValue.equals(""))) {
/*  771 */       Integer tInteger = new Integer(FValue);
/*  772 */       int i = tInteger.intValue();
/*  773 */       this.GetIntv = i;
/*      */     }
/*      */ 
/*  777 */     if ((FCode.equals("PayEndYear")) && 
/*  778 */       (FValue != null) && (!FValue.equals(""))) {
/*  779 */       Integer tInteger = new Integer(FValue);
/*  780 */       int i = tInteger.intValue();
/*  781 */       this.PayEndYear = i;
/*      */     }
/*      */ 
/*  785 */     if (FCode.equals("PayEndYearFlag")) {
/*  786 */       if ((FValue != null) && (!FValue.equals("")))
/*  787 */         this.PayEndYearFlag = FValue.trim();
/*      */       else {
/*  789 */         this.PayEndYearFlag = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  794 */     if ((FCode.equals("GetYear")) && 
/*  795 */       (FValue != null) && (!FValue.equals(""))) {
/*  796 */       Integer tInteger = new Integer(FValue);
/*  797 */       int i = tInteger.intValue();
/*  798 */       this.GetYear = i;
/*      */     }
/*      */ 
/*  802 */     if (FCode.equals("GetYearFlag")) {
/*  803 */       if ((FValue != null) && (!FValue.equals("")))
/*  804 */         this.GetYearFlag = FValue.trim();
/*      */       else {
/*  806 */         this.GetYearFlag = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  811 */     if (FCode.equals("GetDutyKind")) {
/*  812 */       if ((FValue != null) && (!FValue.equals("")))
/*  813 */         this.GetDutyKind = FValue.trim();
/*      */       else {
/*  815 */         this.GetDutyKind = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  820 */     if (FCode.equals("StartDateCalRef")) {
/*  821 */       if ((FValue != null) && (!FValue.equals("")))
/*  822 */         this.StartDateCalRef = FValue.trim();
/*      */       else {
/*  824 */         this.StartDateCalRef = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  829 */     if ((FCode.equals("Years")) && 
/*  830 */       (FValue != null) && (!FValue.equals(""))) {
/*  831 */       Integer tInteger = new Integer(FValue);
/*  832 */       int i = tInteger.intValue();
/*  833 */       this.Years = i;
/*      */     }
/*      */ 
/*  838 */     if ((FCode.equals("InsuYear")) && 
/*  839 */       (FValue != null) && (!FValue.equals(""))) {
/*  840 */       Integer tInteger = new Integer(FValue);
/*  841 */       int i = tInteger.intValue();
/*  842 */       this.InsuYear = i;
/*      */     }
/*      */ 
/*  847 */     if (FCode.equals("InsuYearFlag")) {
/*  848 */       if ((FValue != null) && (!FValue.equals("")))
/*  849 */         this.InsuYearFlag = FValue.trim();
/*      */       else {
/*  851 */         this.InsuYearFlag = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  856 */     if ((FCode.equals("AppAge")) && 
/*  857 */       (FValue != null) && (!FValue.equals(""))) {
/*  858 */       Integer tInteger = new Integer(FValue);
/*  859 */       int i = tInteger.intValue();
/*  860 */       this.AppAge = i;
/*      */     }
/*      */ 
/*  865 */     if (FCode.equals("Job")) {
/*  866 */       if ((FValue != null) && (!FValue.equals("")))
/*  867 */         this.Job = FValue.trim();
/*      */       else {
/*  869 */         this.Job = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  874 */     if (FCode.equals("GDuty")) {
/*  875 */       if ((FValue != null) && (!FValue.equals("")))
/*  876 */         this.GDuty = FValue.trim();
/*      */       else {
/*  878 */         this.GDuty = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  883 */     if ((FCode.equals("Count")) && 
/*  884 */       (FValue != null) && (!FValue.equals(""))) {
/*  885 */       Integer tInteger = new Integer(FValue);
/*  886 */       int i = tInteger.intValue();
/*  887 */       this.Count = i;
/*      */     }
/*      */ 
/*  892 */     if ((FCode.equals("RnewFlag")) && 
/*  893 */       (FValue != null) && (!FValue.equals(""))) {
/*  894 */       Integer tInteger = new Integer(FValue);
/*  895 */       int i = tInteger.intValue();
/*  896 */       this.RnewFlag = i;
/*      */     }
/*      */ 
/*  901 */     if ((FCode.equals("AddRate")) && 
/*  902 */       (FValue != null) && (!FValue.equals(""))) {
/*  903 */       Double tDouble = new Double(FValue);
/*  904 */       double d = tDouble.doubleValue();
/*  905 */       this.AddRate = d;
/*      */     }
/*      */ 
/*  910 */     if (FCode.equals("ContNo")) {
/*  911 */       if ((FValue != null) && (!FValue.equals("")))
/*  912 */         this.ContNo = FValue.trim();
/*      */       else {
/*  914 */         this.ContNo = null;
/*      */       }
/*      */     }
/*      */ 
/*  918 */     if (FCode.equals("GrpContNo")) {
/*  919 */       if ((FValue != null) && (!FValue.equals("")))
/*  920 */         this.GrpContNo = FValue.trim();
/*      */       else {
/*  922 */         this.GrpContNo = null;
/*      */       }
/*      */     }
/*      */ 
/*  926 */     if (FCode.equals("GrpPolNo")) {
/*  927 */       if ((FValue != null) && (!FValue.equals("")))
/*  928 */         this.GrpPolNo = FValue.trim();
/*      */       else {
/*  930 */         this.GrpPolNo = null;
/*      */       }
/*      */     }
/*      */ 
/*  934 */     if (FCode.equals("PolNo")) {
/*  935 */       if ((FValue != null) && (!FValue.equals("")))
/*  936 */         this.PolNo = FValue.trim();
/*      */       else {
/*  938 */         this.PolNo = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  944 */     if ((FCode.equals("Amnt")) && 
/*  945 */       (FValue != null) && (!FValue.equals(""))) {
/*  946 */       Double tDouble = new Double(FValue);
/*  947 */       double d = tDouble.doubleValue();
/*  948 */       this.Amnt = d;
/*      */     }
/*      */ 
/*  953 */     if (FCode.equals("RiskCode")) {
/*  954 */       if ((FValue != null) && (!FValue.equals("")))
/*  955 */         this.RiskCode = FValue.trim();
/*      */       else {
/*  957 */         this.RiskCode = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  962 */     if (FCode.equals("PayLocation")) {
/*  963 */       if ((FValue != null) && (!FValue.equals("")))
/*  964 */         this.PayLocation = FValue.trim();
/*      */       else {
/*  966 */         this.PayLocation = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  971 */     if (FCode.equals("GetStartType")) {
/*  972 */       if ((FValue != null) && (!FValue.equals("")))
/*  973 */         this.GetStartType = FValue.trim();
/*      */       else {
/*  975 */         this.GetStartType = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  980 */     if (FCode.equals("LiveGetMode")) {
/*  981 */       if ((FValue != null) && (!FValue.equals("")))
/*  982 */         this.LiveGetMode = FValue.trim();
/*      */       else {
/*  984 */         this.LiveGetMode = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  989 */     if (FCode.equals("RelFlag")) {
/*  990 */       if ((FValue != null) && (!FValue.equals("")))
/*  991 */         this.RelFlag = FValue.trim();
/*      */       else {
/*  993 */         this.RelFlag = null;
/*      */       }
/*      */     }
/*      */ 
/*  997 */     if (FCode.equals("SubRiskFlag")) {
/*  998 */       if ((FValue != null) && (!FValue.equals("")))
/*  999 */         this.SubRiskFlag = FValue.trim();
/*      */       else {
/* 1001 */         this.SubRiskFlag = null;
/*      */       }
/*      */     }
/*      */ 
/* 1005 */     if (FCode.equals("MainPolNo")) {
/* 1006 */       if ((FValue != null) && (!FValue.equals("")))
/* 1007 */         this.MainPolNo = FValue.trim();
/*      */       else {
/* 1009 */         this.MainPolNo = null;
/*      */       }
/*      */     }
/*      */ 
/* 1013 */     if (FCode.equals("InsuredNo")) {
/* 1014 */       if ((FValue != null) && (!FValue.equals("")))
/* 1015 */         this.InsuredNo = FValue.trim();
/*      */       else {
/* 1017 */         this.InsuredNo = null;
/*      */       }
/*      */     }
/* 1020 */     if (FCode.equals("AppntNo")) {
/* 1021 */       if ((FValue != null) && (!FValue.equals("")))
/* 1022 */         this.AppntNo = FValue.trim();
/*      */       else {
/* 1024 */         this.AppntNo = null;
/*      */       }
/*      */     }
/* 1027 */     if (FCode.equals("StandbyFlag1")) {
/* 1028 */       if ((FValue != null) && (!FValue.equals("")))
/* 1029 */         this.StandbyFlag1 = FValue.trim();
/*      */       else {
/* 1031 */         this.StandbyFlag1 = null;
/*      */       }
/*      */     }
/* 1034 */     if (FCode.equals("StandbyFlag2")) {
/* 1035 */       if ((FValue != null) && (!FValue.equals("")))
/* 1036 */         this.StandbyFlag2 = FValue.trim();
/*      */       else {
/* 1038 */         this.StandbyFlag2 = null;
/*      */       }
/*      */     }
/* 1041 */     if (FCode.equals("StandbyFlag3")) {
/* 1042 */       if ((FValue != null) && (!FValue.equals("")))
/* 1043 */         this.StandbyFlag3 = FValue.trim();
/*      */       else {
/* 1045 */         this.StandbyFlag3 = null;
/*      */       }
/*      */     }
/*      */ 
/* 1049 */     return true;
/*      */   }
/*      */ 
/*      */   public String getAppAg2()
/*      */   {
/* 1054 */     return this.AppAg2;
/*      */   }
/*      */ 
/*      */   public void setAppAg2(String appAg2)
/*      */   {
/* 1059 */     this.AppAg2 = appAg2;
/*      */   }
/*      */ 
/*      */   public String getAppAge2()
/*      */   {
/* 1064 */     return this.AppAge2;
/*      */   }
/*      */ 
/*      */   public void setAppAge2(String appAge2)
/*      */   {
/* 1069 */     this.AppAge2 = appAge2;
/*      */   }
/*      */ 
/*      */   public String getAppntJob()
/*      */   {
/* 1074 */     return this.AppntJob;
/*      */   }
/*      */ 
/*      */   public void setAppntJob(String appntJob)
/*      */   {
/* 1079 */     this.AppntJob = appntJob;
/*      */   }
/*      */ 
/*      */   public String getAppntNativePlace()
/*      */   {
/* 1084 */     return this.AppntNativePlace;
/*      */   }
/*      */ 
/*      */   public void setAppntNativePlace(String appntNativePlace)
/*      */   {
/* 1089 */     this.AppntNativePlace = appntNativePlace;
/*      */   }
/*      */ 
/*      */   public String getASumDangerAmnt()
/*      */   {
/* 1094 */     return this.ASumDangerAmnt;
/*      */   }
/*      */ 
/*      */   public void setASumDangerAmnt(String sumDangerAmnt)
/*      */   {
/* 1099 */     this.ASumDangerAmnt = sumDangerAmnt;
/*      */   }
/*      */ 
/*      */   public String getCalType()
/*      */   {
/* 1104 */     return this.CalType;
/*      */   }
/*      */ 
/*      */   public void setCalType(String calType)
/*      */   {
/* 1109 */     this.CalType = calType;
/*      */   }
/*      */ 
/*      */   public String getCustomerNo()
/*      */   {
/* 1114 */     return this.CustomerNo;
/*      */   }
/*      */ 
/*      */   public void setCustomerNo(String customerNo)
/*      */   {
/* 1119 */     this.CustomerNo = customerNo;
/*      */   }
/*      */ 
/*      */   public String getDSumDangerAmnt()
/*      */   {
/* 1124 */     return this.DSumDangerAmnt;
/*      */   }
/*      */ 
/*      */   public void setDSumDangerAmnt(String sumDangerAmnt)
/*      */   {
/* 1129 */     this.DSumDangerAmnt = sumDangerAmnt;
/*      */   }
/*      */ 
/*      */   public String getDutyCode()
/*      */   {
/* 1134 */     return this.DutyCode;
/*      */   }
/*      */ 
/*      */   public void setDutyCode(String dutyCode)
/*      */   {
/* 1139 */     this.DutyCode = dutyCode;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/* 1144 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String edorNo)
/*      */   {
/* 1149 */     this.EdorNo = edorNo;
/*      */   }
/*      */ 
/*      */   public double getFirstScore()
/*      */   {
/* 1154 */     return this.FirstScore;
/*      */   }
/*      */ 
/*      */   public void setFirstScore(double firstScore)
/*      */   {
/* 1159 */     this.FirstScore = firstScore;
/*      */   }
/*      */ 
/*      */   public double getGetLimit()
/*      */   {
/* 1164 */     return this.GetLimit;
/*      */   }
/*      */ 
/*      */   public void setGetLimit(double getLimit)
/*      */   {
/* 1169 */     this.GetLimit = getLimit;
/*      */   }
/*      */ 
/*      */   public double getGetRate()
/*      */   {
/* 1174 */     return this.GetRate;
/*      */   }
/*      */ 
/*      */   public void setGetRate(double getRate)
/*      */   {
/* 1179 */     this.GetRate = getRate;
/*      */   }
/*      */ 
/*      */   public double getHusbandScore()
/*      */   {
/* 1184 */     return this.HusbandScore;
/*      */   }
/*      */ 
/*      */   public void setHusbandScore(double husbandScore)
/*      */   {
/* 1189 */     this.HusbandScore = husbandScore;
/*      */   }
/*      */ 
/*      */   public String getInsuredNativePlace()
/*      */   {
/* 1194 */     return this.InsuredNativePlace;
/*      */   }
/*      */ 
/*      */   public void setInsuredNativePlace(String insuredNativePlace)
/*      */   {
/* 1199 */     this.InsuredNativePlace = insuredNativePlace;
/*      */   }
/*      */ 
/*      */   public String getLifeFlag()
/*      */   {
/* 1204 */     return this.LifeFlag;
/*      */   }
/*      */ 
/*      */   public void setLifeFlag(String lifeFlag)
/*      */   {
/* 1209 */     this.LifeFlag = lifeFlag;
/*      */   }
/*      */ 
/*      */   public String getLSumDangerAmnt()
/*      */   {
/* 1214 */     return this.LSumDangerAmnt;
/*      */   }
/*      */ 
/*      */   public void setLSumDangerAmnt(String sumDangerAmnt)
/*      */   {
/* 1219 */     this.LSumDangerAmnt = sumDangerAmnt;
/*      */   }
/*      */ 
/*      */   public String getMainRiskGet()
/*      */   {
/* 1224 */     return this.MainRiskGet;
/*      */   }
/*      */ 
/*      */   public void setMainRiskGet(String mainRiskGet)
/*      */   {
/* 1229 */     this.MainRiskGet = mainRiskGet;
/*      */   }
/*      */ 
/*      */   public String getMAmnt()
/*      */   {
/* 1234 */     return this.MAmnt;
/*      */   }
/*      */ 
/*      */   public void setMAmnt(String amnt)
/*      */   {
/* 1239 */     this.MAmnt = amnt;
/*      */   }
/*      */ 
/*      */   public String getManageCom()
/*      */   {
/* 1244 */     return this.ManageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String manageCom)
/*      */   {
/* 1249 */     this.ManageCom = manageCom;
/*      */   }
/*      */ 
/*      */   public String getMSumDangerAmnt()
/*      */   {
/* 1254 */     return this.MSumDangerAmnt;
/*      */   }
/*      */ 
/*      */   public void setMSumDangerAmnt(String sumDangerAmnt)
/*      */   {
/* 1259 */     this.MSumDangerAmnt = sumDangerAmnt;
/*      */   }
/*      */ 
/*      */   public String getOccupation()
/*      */   {
/* 1264 */     return this.Occupation;
/*      */   }
/*      */ 
/*      */   public void setOccupation(String occupation)
/*      */   {
/* 1269 */     this.Occupation = occupation;
/*      */   }
/*      */ 
/*      */   public double getPeakLine()
/*      */   {
/* 1274 */     return this.PeakLine;
/*      */   }
/*      */ 
/*      */   public void setPeakLine(double peakLine)
/*      */   {
/* 1279 */     this.PeakLine = peakLine;
/*      */   }
/*      */ 
/*      */   public String getRelationToAppnt()
/*      */   {
/* 1284 */     return this.RelationToAppnt;
/*      */   }
/*      */ 
/*      */   public void setRelationToAppnt(String relationToAppnt)
/*      */   {
/* 1289 */     this.RelationToAppnt = relationToAppnt;
/*      */   }
/*      */ 
/*      */   public String getRiskChannel()
/*      */   {
/* 1294 */     return this.RiskChannel;
/*      */   }
/*      */ 
/*      */   public void setRiskChannel(String riskChannel)
/*      */   {
/* 1299 */     this.RiskChannel = riskChannel;
/*      */   }
/*      */ 
/*      */   public String getRiskSort()
/*      */   {
/* 1304 */     return this.RiskSort;
/*      */   }
/*      */ 
/*      */   public void setRiskSort(String riskSort)
/*      */   {
/* 1309 */     this.RiskSort = riskSort;
/*      */   }
/*      */ 
/*      */   public String getSecondInsuredNo()
/*      */   {
/* 1314 */     return this.SecondInsuredNo;
/*      */   }
/*      */ 
/*      */   public void setSecondInsuredNo(String secondInsuredNo)
/*      */   {
/* 1319 */     this.SecondInsuredNo = secondInsuredNo;
/*      */   }
/*      */ 
/*      */   public double getSecondScore()
/*      */   {
/* 1324 */     return this.SecondScore;
/*      */   }
/*      */ 
/*      */   public void setSecondScore(double secondScore)
/*      */   {
/* 1329 */     this.SecondScore = secondScore;
/*      */   }
/*      */ 
/*      */   public String getSSFlag()
/*      */   {
/* 1334 */     return this.SSFlag;
/*      */   }
/*      */ 
/*      */   public void setSSFlag(String flag)
/*      */   {
/* 1339 */     this.SSFlag = flag;
/*      */   }
/*      */ 
/*      */   public String getSSumDangerAmnt()
/*      */   {
/* 1344 */     return this.SSumDangerAmnt;
/*      */   }
/*      */ 
/*      */   public void setSSumDangerAmnt(String sumDangerAmnt)
/*      */   {
/* 1349 */     this.SSumDangerAmnt = sumDangerAmnt;
/*      */   }
/*      */ 
/*      */   public double getSuppRiskScore()
/*      */   {
/* 1354 */     return this.SuppRiskScore;
/*      */   }
/*      */ 
/*      */   public void setSuppRiskScore(double suppRiskScore)
/*      */   {
/* 1359 */     this.SuppRiskScore = suppRiskScore;
/*      */   }
/*      */ 
/*      */   public String getVPU()
/*      */   {
/* 1364 */     return this.VPU;
/*      */   }
/*      */ 
/*      */   public void setVPU(String vpu)
/*      */   {
/* 1369 */     this.VPU = vpu;
/*      */   }
/*      */ 
/*      */   public double getWifeScore()
/*      */   {
/* 1374 */     return this.WifeScore;
/*      */   }
/*      */ 
/*      */   public void setWifeScore(double wifeScore)
/*      */   {
/* 1379 */     this.WifeScore = wifeScore;
/*      */   }
/*      */ 
/*      */   public int getAppntAge()
/*      */   {
/* 1384 */     return this.AppntAge;
/*      */   }
/*      */ 
/*      */   public void setAppntAge(int appntAge)
/*      */   {
/* 1389 */     this.AppntAge = appntAge;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.CalFactorSchema
 * JD-Core Version:    0.6.0
 */