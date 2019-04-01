/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ public class FieldCarrier
/*     */ {
/*     */   private double Prem;
/*     */   private double Get;
/*     */   private double Mult;
/*     */   private int AppAge;
/*     */   private int AppAgeType;
/*     */   private String Sex;
/*     */   private String InsuredBirthday;
/*     */   private String Job;
/*     */   private String GDuty;
/*     */   private String DutyCode;
/*     */   private int Count;
/*     */   private int RnewFlag;
/*     */   private double AddRate;
/*     */   private String PolNo;
/*     */   private double Amnt;
/*     */   private double TopUpPrem;
/*     */   private double DeadAmntType;
/*     */   private double FloatRate;
/*     */   private String RiskCode;
/*     */   private String MainPolNo;
/*     */   private String OccupationType;
/*     */   private String StandbyFlag1;
/*     */   private String StandbyFlag2;
/*     */   private String StandbyFlag3;
/*     */   private String StandbyFlag4;
/*     */   private String EndDate;
/*     */   private String InsuredNo;
/*     */   private int AppntAge;
/*     */   private int AppntAgeType;
/*     */   private String ManageCom;
/*     */   private int PayIntv;
/*     */   private int GetIntv;
/*     */   private int PayEndYear;
/*     */   private String PayEndYearFlag;
/*     */   private int GetYear;
/*     */   private String GetYearFlag;
/*     */   private String GetDutyKind;
/*     */   private String StartDateCalRef;
/*     */   private int Years;
/*     */   private int InsuYear;
/*     */   private String InsuYearFlag;
/*     */   private int PayYears;
/*     */   private String PolTypeFlag;
/*     */   private double ManageFeeRate;
/*     */   private String GrpPolNo;
/*     */   private int Interval;
/*     */   private String EdorNo;
/*     */   private String EdorType;
/*     */   private String EdorValiDate;
/*     */   private double GetMoney;
/*     */   private String GetStartFlag;
/*     */   private String GetStartDate;
/*     */   private String CValiDate;
/*     */   private double GetBalance;
/*     */   private String InsuredName;
/*     */   private String IDNo;
/*     */   private String IDType;
/*     */   private String WorkType;
/*     */   private String GrpName;
/*     */   private String ContNo;
/*     */ 
/*     */   public int getAppAgeType()
/*     */   {
/* 136 */     return this.AppAgeType;
/*     */   }
/*     */ 
/*     */   public void setAppAgeType(int appAgeType) {
/* 140 */     this.AppAgeType = appAgeType;
/*     */   }
/*     */ 
/*     */   public double getTopUpPrem() {
/* 144 */     return this.TopUpPrem;
/*     */   }
/*     */ 
/*     */   public void setTopUpPrem(double topUpPrem) {
/* 148 */     this.TopUpPrem = topUpPrem;
/*     */   }
/*     */ 
/*     */   public double getDeadAmntType() {
/* 152 */     return this.DeadAmntType;
/*     */   }
/*     */ 
/*     */   public void setDeadAmntType(double deadAmntType) {
/* 156 */     this.DeadAmntType = deadAmntType;
/*     */   }
/*     */ 
/*     */   public int getAppntAgeType() {
/* 160 */     return this.AppntAgeType;
/*     */   }
/*     */ 
/*     */   public void setAppntAgeType(int appntAgeType) {
/* 164 */     this.AppntAgeType = appntAgeType;
/*     */   }
/*     */ 
/*     */   public void setContNo(String tContNo)
/*     */   {
/* 169 */     this.ContNo = tContNo;
/*     */   }
/*     */ 
/*     */   public String getContNo()
/*     */   {
/* 174 */     return this.ContNo;
/*     */   }
/*     */ 
/*     */   public void setPrem(double tPrem)
/*     */   {
/* 184 */     this.Prem = tPrem;
/*     */   }
/*     */ 
/*     */   public String getPrem()
/*     */   {
/* 189 */     return String.valueOf(this.Prem);
/*     */   }
/*     */ 
/*     */   public void setGet(double tGet)
/*     */   {
/* 194 */     this.Get = tGet;
/*     */   }
/*     */ 
/*     */   public String getGet()
/*     */   {
/* 199 */     return String.valueOf(this.Get);
/*     */   }
/*     */ 
/*     */   public void setAmnt(double tAmnt)
/*     */   {
/* 204 */     this.Amnt = tAmnt;
/*     */   }
/*     */ 
/*     */   public String getAmnt()
/*     */   {
/* 209 */     return String.valueOf(this.Amnt);
/*     */   }
/*     */ 
/*     */   public void setMult(double tMult)
/*     */   {
/* 214 */     this.Mult = tMult;
/*     */   }
/*     */ 
/*     */   public String getMult()
/*     */   {
/* 219 */     return String.valueOf(this.Mult);
/*     */   }
/*     */ 
/*     */   public void setFloatRate(double tFloatRate)
/*     */   {
/* 224 */     this.FloatRate = tFloatRate;
/*     */   }
/*     */ 
/*     */   public String getFloatRate()
/*     */   {
/* 229 */     return String.valueOf(this.FloatRate);
/*     */   }
/*     */ 
/*     */   public void setAddRate(double tAddRate)
/*     */   {
/* 234 */     this.AddRate = tAddRate;
/*     */   }
/*     */ 
/*     */   public String getAddRate()
/*     */   {
/* 239 */     return String.valueOf(this.AddRate);
/*     */   }
/*     */ 
/*     */   public void setPayIntv(int tPayIntv)
/*     */   {
/* 244 */     this.PayIntv = tPayIntv;
/*     */   }
/*     */ 
/*     */   public void setPolTypeFlag(String tPolTypeFlag) {
/* 248 */     this.PolTypeFlag = tPolTypeFlag;
/*     */   }
/*     */ 
/*     */   public void setManageFeeRate(double tManageFeeRate) {
/* 252 */     this.ManageFeeRate = tManageFeeRate;
/*     */   }
/*     */ 
/*     */   public String getPayIntv() {
/* 256 */     return String.valueOf(this.PayIntv);
/*     */   }
/*     */ 
/*     */   public void setGetIntv(int tGetIntv)
/*     */   {
/* 261 */     this.GetIntv = tGetIntv;
/*     */   }
/*     */ 
/*     */   public String getGetIntv()
/*     */   {
/* 266 */     return String.valueOf(this.GetIntv);
/*     */   }
/*     */ 
/*     */   public void setPayEndYear(int tPayEndYear)
/*     */   {
/* 271 */     this.PayEndYear = tPayEndYear;
/*     */   }
/*     */ 
/*     */   public String getPayEndYear()
/*     */   {
/* 276 */     return String.valueOf(this.PayEndYear);
/*     */   }
/*     */ 
/*     */   public void setGetYear(int tGetYear)
/*     */   {
/* 281 */     this.GetYear = tGetYear;
/*     */   }
/*     */ 
/*     */   public String getGetYear()
/*     */   {
/* 286 */     return String.valueOf(this.GetYear);
/*     */   }
/*     */ 
/*     */   public void setYears(int tYears)
/*     */   {
/* 291 */     this.Years = tYears;
/*     */   }
/*     */ 
/*     */   public String getYears()
/*     */   {
/* 296 */     return String.valueOf(this.Years);
/*     */   }
/*     */ 
/*     */   public void setInsuYear(int tInsuYear)
/*     */   {
/* 301 */     this.InsuYear = tInsuYear;
/*     */   }
/*     */ 
/*     */   public String getInsuYear()
/*     */   {
/* 306 */     return String.valueOf(this.InsuYear);
/*     */   }
/*     */ 
/*     */   public void setAppAge(int tAppAge)
/*     */   {
/* 311 */     this.AppAge = tAppAge;
/*     */   }
/*     */ 
/*     */   public String getAppAge()
/*     */   {
/* 316 */     return String.valueOf(this.AppAge);
/*     */   }
/*     */ 
/*     */   public void setCount(int tCount)
/*     */   {
/* 321 */     this.Count = tCount;
/*     */   }
/*     */ 
/*     */   public String getCount()
/*     */   {
/* 326 */     return String.valueOf(this.Count);
/*     */   }
/*     */ 
/*     */   public void setRnewFlag(int tRnewFlag)
/*     */   {
/* 331 */     this.RnewFlag = tRnewFlag;
/*     */   }
/*     */ 
/*     */   public String getRnewFlag()
/*     */   {
/* 336 */     return String.valueOf(this.RnewFlag);
/*     */   }
/*     */ 
/*     */   public void setSex(String tSex)
/*     */   {
/* 341 */     this.Sex = tSex;
/*     */   }
/*     */ 
/*     */   public String getSex()
/*     */   {
/* 346 */     return this.Sex;
/*     */   }
/*     */ 
/*     */   public void setInsuredBirthday(String tInsuredBirthday)
/*     */   {
/* 351 */     this.InsuredBirthday = tInsuredBirthday;
/*     */   }
/*     */ 
/*     */   public String getInsuredBirthday()
/*     */   {
/* 356 */     return this.InsuredBirthday;
/*     */   }
/*     */ 
/*     */   public void setInsuYearFlag(String tInsuYearFlag)
/*     */   {
/* 361 */     this.InsuYearFlag = tInsuYearFlag;
/*     */   }
/*     */ 
/*     */   public String getInsuYearFlag()
/*     */   {
/* 366 */     return this.InsuYearFlag;
/*     */   }
/*     */ 
/*     */   public void setPayYears(int tPayYears)
/*     */   {
/* 371 */     this.PayYears = tPayYears;
/*     */   }
/*     */ 
/*     */   public int getPayYears()
/*     */   {
/* 376 */     return this.PayYears;
/*     */   }
/*     */ 
/*     */   public void setPayEndYearFlag(String tPayEndYearFlag)
/*     */   {
/* 381 */     this.PayEndYearFlag = tPayEndYearFlag;
/*     */   }
/*     */ 
/*     */   public String getPayEndYearFlag()
/*     */   {
/* 386 */     return this.PayEndYearFlag;
/*     */   }
/*     */ 
/*     */   public void setGetYearFlag(String tGetYearFlag)
/*     */   {
/* 391 */     this.GetYearFlag = tGetYearFlag;
/*     */   }
/*     */ 
/*     */   public String getGetYearFlag()
/*     */   {
/* 396 */     return this.GetYearFlag;
/*     */   }
/*     */ 
/*     */   public void setGetDutyKind(String tGetDutyKind)
/*     */   {
/* 401 */     this.GetDutyKind = tGetDutyKind;
/*     */   }
/*     */ 
/*     */   public String getGetDutyKind()
/*     */   {
/* 406 */     return this.GetDutyKind;
/*     */   }
/*     */ 
/*     */   public void setStartDateCalRef(String tStartDateCalRef)
/*     */   {
/* 411 */     this.StartDateCalRef = tStartDateCalRef;
/*     */   }
/*     */ 
/*     */   public String getStartDateCalRef()
/*     */   {
/* 416 */     return this.StartDateCalRef;
/*     */   }
/*     */ 
/*     */   public void setJob(String tJob)
/*     */   {
/* 421 */     this.Job = tJob;
/*     */   }
/*     */ 
/*     */   public String getJob()
/*     */   {
/* 426 */     return this.Job;
/*     */   }
/*     */ 
/*     */   public void setGDuty(String tGDuty)
/*     */   {
/* 431 */     this.GDuty = tGDuty;
/*     */   }
/*     */ 
/*     */   public void setDutyCode(String tDutyCode) {
/* 435 */     this.DutyCode = tDutyCode;
/*     */   }
/*     */ 
/*     */   public String getGDuty() {
/* 439 */     return this.GDuty;
/*     */   }
/*     */ 
/*     */   public void setPolNo(String tPolNo)
/*     */   {
/* 444 */     this.PolNo = tPolNo;
/*     */   }
/*     */ 
/*     */   public String getPolNo()
/*     */   {
/* 449 */     return this.PolNo;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String tRiskCode)
/*     */   {
/* 454 */     this.RiskCode = tRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRiskCode()
/*     */   {
/* 459 */     return this.RiskCode;
/*     */   }
/*     */ 
/*     */   public void setMainPolNo(String tMainPolNo)
/*     */   {
/* 464 */     this.MainPolNo = tMainPolNo;
/*     */   }
/*     */ 
/*     */   public String getMainPolNo()
/*     */   {
/* 469 */     return this.MainPolNo;
/*     */   }
/*     */ 
/*     */   public void setOccupationType(String tOccupationType)
/*     */   {
/* 474 */     this.OccupationType = tOccupationType;
/*     */   }
/*     */ 
/*     */   public String getOccupationType()
/*     */   {
/* 479 */     return this.OccupationType;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag1(String tStandbyFlag1)
/*     */   {
/* 484 */     this.StandbyFlag1 = tStandbyFlag1;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag1()
/*     */   {
/* 489 */     return this.StandbyFlag1;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag2(String tStandbyFlag2)
/*     */   {
/* 494 */     this.StandbyFlag2 = tStandbyFlag2;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag2()
/*     */   {
/* 499 */     return this.StandbyFlag2;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag3(String tStandbyFlag3)
/*     */   {
/* 504 */     this.StandbyFlag3 = tStandbyFlag3;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag3()
/*     */   {
/* 509 */     return this.StandbyFlag3;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag4(String tStandbyFlag4)
/*     */   {
/* 514 */     this.StandbyFlag4 = tStandbyFlag4;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag4()
/*     */   {
/* 519 */     return this.StandbyFlag4;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String tEndDate)
/*     */   {
/* 524 */     this.EndDate = tEndDate;
/*     */   }
/*     */ 
/*     */   public String getEndDate()
/*     */   {
/* 529 */     return this.EndDate;
/*     */   }
/*     */ 
/*     */   public void setGrpPolNo(String tGrpPolNo)
/*     */   {
/* 534 */     this.GrpPolNo = tGrpPolNo;
/*     */   }
/*     */ 
/*     */   public String getGrpPolNo()
/*     */   {
/* 539 */     return this.GrpPolNo;
/*     */   }
/*     */ 
/*     */   public void setInterval(int tInterval)
/*     */   {
/* 544 */     this.Interval = tInterval;
/*     */   }
/*     */ 
/*     */   public String getInterval()
/*     */   {
/* 549 */     return String.valueOf(this.Interval);
/*     */   }
/*     */ 
/*     */   public void setEdorNo(String tEdorNo)
/*     */   {
/* 554 */     this.EdorNo = tEdorNo;
/*     */   }
/*     */ 
/*     */   public String getEdorNo()
/*     */   {
/* 559 */     return this.EdorNo;
/*     */   }
/*     */ 
/*     */   public void setEdorType(String tEdorType)
/*     */   {
/* 564 */     this.EdorType = tEdorType;
/*     */   }
/*     */ 
/*     */   public String getEdorType()
/*     */   {
/* 569 */     return this.EdorType;
/*     */   }
/*     */ 
/*     */   public void setGetMoney(double tGetMoney)
/*     */   {
/* 574 */     this.GetMoney = tGetMoney;
/*     */   }
/*     */ 
/*     */   public String getGetMoney()
/*     */   {
/* 579 */     return String.valueOf(this.GetMoney);
/*     */   }
/*     */ 
/*     */   public void setCValiDate(String tCValiDate)
/*     */   {
/* 584 */     this.CValiDate = tCValiDate;
/*     */   }
/*     */ 
/*     */   public String getCValiDate()
/*     */   {
/* 589 */     return this.CValiDate;
/*     */   }
/*     */ 
/*     */   public void setEdorValiDate(String tEdorValiDate)
/*     */   {
/* 594 */     this.EdorValiDate = tEdorValiDate;
/*     */   }
/*     */ 
/*     */   public String getEdorValiDate()
/*     */   {
/* 599 */     return this.EdorValiDate;
/*     */   }
/*     */ 
/*     */   public void setGetStartDate(String tGetStartDate)
/*     */   {
/* 604 */     this.GetStartDate = tGetStartDate;
/*     */   }
/*     */ 
/*     */   public String getGetStartDate()
/*     */   {
/* 609 */     return this.GetStartDate;
/*     */   }
/*     */ 
/*     */   public void setGetBalance(double tGetBalance)
/*     */   {
/* 614 */     this.GetBalance = tGetBalance;
/*     */   }
/*     */ 
/*     */   public String getGetBalance()
/*     */   {
/* 619 */     return String.valueOf(this.GetBalance);
/*     */   }
/*     */ 
/*     */   public void setGetStartFlag(String tGetStartFlag)
/*     */   {
/* 624 */     this.GetStartFlag = tGetStartFlag;
/*     */   }
/*     */ 
/*     */   public String getGetStartFlag()
/*     */   {
/* 629 */     return this.GetStartFlag;
/*     */   }
/*     */ 
/*     */   public void setIDNo(String tIDNo)
/*     */   {
/* 634 */     this.IDNo = tIDNo;
/*     */   }
/*     */ 
/*     */   public String getIDNo()
/*     */   {
/* 639 */     return this.IDNo;
/*     */   }
/*     */ 
/*     */   public void setIDType(String tIDType)
/*     */   {
/* 644 */     this.IDType = tIDType;
/*     */   }
/*     */ 
/*     */   public String getIDType()
/*     */   {
/* 649 */     return this.IDType;
/*     */   }
/*     */ 
/*     */   public void setWorkType(String tWorkType)
/*     */   {
/* 654 */     this.WorkType = tWorkType;
/*     */   }
/*     */ 
/*     */   public String getWorkType()
/*     */   {
/* 659 */     return this.WorkType;
/*     */   }
/*     */ 
/*     */   public void setGrpName(String tGrpName)
/*     */   {
/* 664 */     this.GrpName = tGrpName;
/*     */   }
/*     */ 
/*     */   public String getGrpName()
/*     */   {
/* 669 */     return this.GrpName;
/*     */   }
/*     */ 
/*     */   public void setInsuredName(String tInsuredName)
/*     */   {
/* 674 */     this.InsuredName = tInsuredName;
/*     */   }
/*     */ 
/*     */   public String getInsuredName()
/*     */   {
/* 679 */     return this.InsuredName;
/*     */   }
/*     */ 
/*     */   public String getPolTypeFlag()
/*     */   {
/* 686 */     return this.PolTypeFlag;
/*     */   }
/*     */ 
/*     */   public double getManageFeeRate()
/*     */   {
/* 692 */     return this.ManageFeeRate;
/*     */   }
/*     */ 
/*     */   public String getDutyCode()
/*     */   {
/* 698 */     return this.DutyCode;
/*     */   }
/*     */ 
/*     */   public String getInsuredNo()
/*     */   {
/* 705 */     return this.InsuredNo;
/*     */   }
/*     */ 
/*     */   public void setInsuredNo(String insuredNo)
/*     */   {
/* 710 */     this.InsuredNo = insuredNo;
/*     */   }
/*     */ 
/*     */   public String getManageCom()
/*     */   {
/* 715 */     return this.ManageCom;
/*     */   }
/*     */ 
/*     */   public void setManageCom(String manageCom)
/*     */   {
/* 720 */     this.ManageCom = manageCom;
/*     */   }
/*     */ 
/*     */   public int getAppntAge()
/*     */   {
/* 725 */     return this.AppntAge;
/*     */   }
/*     */ 
/*     */   public void setAppntAge(int appntAge)
/*     */   {
/* 730 */     this.AppntAge = appntAge;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.FieldCarrier
 * JD-Core Version:    0.6.0
 */