/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class CalBase
/*     */ {
/*     */   private double Prem;
/*     */   private double Get;
/*     */   private double Mult;
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
/*     */   private int AppAge;
/*     */   private String Sex;
/*     */   private String Job;
/*     */   private String GDuty;
/*     */   private int Count;
/*     */   private int RnewFlag;
/*     */   private double AddRate;
/*     */   private String ContNo;
/*     */   private String PolNo;
/*     */   private double Amnt;
/*     */   private double FloatRate;
/*     */   private String RiskCode;
/*     */   private String StandbyFlag1;
/*     */   private String StandbyFlag2;
/*     */   private String StandbyFlag3;
/*     */   private String GrpContNo;
/*     */   private String GrpPolNo;
/*     */   private String EdorNo;
/*     */   private String CalType;
/*     */   private double GetLimit;
/*     */   private double GetRate;
/*     */   private String SSFlag;
/*     */   private double PeakLine;
/*     */   private String CValiDate;
/*     */   private double SuppRiskScore;
/*     */   private double FirstScore;
/*     */   private double SecondScore;
/*     */   private String DutyCode;
/*     */   private String VPU;
/*     */   private String SecondInsuredNo;
/*     */   private String InsuredNo;
/*     */   private String MainPolNo;
/*     */   private String AppAg2;
/*     */   private double HusbandScore;
/*     */   private double WifeScore;
/*     */   private String LSumDangerAmnt;
/*     */   private String DSumDangerAmnt;
/*     */   private String ASumDangerAmnt;
/*     */   private String MSumDangerAmnt;
/*     */   private String SSumDangerAmnt;
/*     */   private String ManageCom;
/*     */   private String AppntJob;
/*     */   private String MainRiskGet;
/*     */   private String RiskSort;
/*     */   private String CustomerNo;
/*     */   private String Occupation;
/*     */   private String MAmnt;
/*     */   private String AppAge2;
/*     */   private String ContPlanCode;
/*     */   private String GetStartType;
/*     */   private String PolTypeFlag;
/*     */   private double ManageFee;
/*     */   private String PayTerm;
/*     */   private Date Birthday;
/*     */   private Date strBirthday;
/*     */   private String PolTerm;
/*     */   private String IniAmnt;
/*     */   private String GiveIntv;
/*     */   private String DrawYear;
/*     */   private String CalSql;
/*     */ 
/*     */   public void setPolTypeFlag(String tPolTypeFlag)
/*     */   {
/* 194 */     this.PolTypeFlag = tPolTypeFlag;
/*     */   }
/*     */ 
/*     */   public String getPolTypeFlag()
/*     */   {
/* 199 */     return String.valueOf(this.PolTypeFlag);
/*     */   }
/*     */ 
/*     */   public void setAppAge2(String tAppAge2)
/*     */   {
/* 204 */     this.AppAge2 = tAppAge2;
/*     */   }
/*     */ 
/*     */   public String getAppAge2()
/*     */   {
/* 209 */     return String.valueOf(this.AppAge2);
/*     */   }
/*     */ 
/*     */   public void setGetStartType(String tGetStartType) {
/* 213 */     this.GetStartType = tGetStartType;
/*     */   }
/*     */ 
/*     */   public String getGetStartType()
/*     */   {
/* 218 */     return String.valueOf(this.GetStartType);
/*     */   }
/*     */ 
/*     */   public void setContPlanCode(String tContPlanCode)
/*     */   {
/* 223 */     this.ContPlanCode = tContPlanCode;
/*     */   }
/*     */ 
/*     */   public String getContPlanCode()
/*     */   {
/* 228 */     return String.valueOf(this.ContPlanCode);
/*     */   }
/*     */ 
/*     */   public void setContNo(String tContNo)
/*     */   {
/* 235 */     this.ContNo = tContNo;
/*     */   }
/*     */ 
/*     */   public void setLSumDangerAmnt(String tLSumDangerAmnt)
/*     */   {
/* 241 */     this.LSumDangerAmnt = tLSumDangerAmnt;
/*     */   }
/*     */ 
/*     */   public String getLSumDangerAmnt()
/*     */   {
/* 246 */     return String.valueOf(this.LSumDangerAmnt);
/*     */   }
/*     */ 
/*     */   public void setSSumDangerAmnt(String tLSumDangerAmnt)
/*     */   {
/* 251 */     this.LSumDangerAmnt = tLSumDangerAmnt;
/*     */   }
/*     */ 
/*     */   public String getSSumDangerAmnt()
/*     */   {
/* 256 */     return String.valueOf(this.LSumDangerAmnt);
/*     */   }
/*     */ 
/*     */   public void setMAmnt(String tMAmnt)
/*     */   {
/* 262 */     this.MAmnt = tMAmnt;
/*     */   }
/*     */ 
/*     */   public String getMAmnt()
/*     */   {
/* 267 */     return String.valueOf(this.MAmnt);
/*     */   }
/*     */ 
/*     */   public void setDSumDangerAmnt(String tDSumDangerAmnt)
/*     */   {
/* 272 */     this.DSumDangerAmnt = tDSumDangerAmnt;
/*     */   }
/*     */ 
/*     */   public String getDSumDangerAmnt()
/*     */   {
/* 277 */     return String.valueOf(this.DSumDangerAmnt);
/*     */   }
/*     */ 
/*     */   public void setASumDangerAmnt(String tASumDangerAmnt)
/*     */   {
/* 282 */     this.ASumDangerAmnt = tASumDangerAmnt;
/*     */   }
/*     */ 
/*     */   public String getASumDangerAmnt()
/*     */   {
/* 287 */     return String.valueOf(this.ASumDangerAmnt);
/*     */   }
/*     */ 
/*     */   public void setMSumDangerAmnt(String tMSumDangerAmnt)
/*     */   {
/* 292 */     this.MSumDangerAmnt = tMSumDangerAmnt;
/*     */   }
/*     */ 
/*     */   public String getMSumDangerAmnt()
/*     */   {
/* 297 */     return String.valueOf(this.MSumDangerAmnt);
/*     */   }
/*     */ 
/*     */   public void setManageCom(String tManageCom)
/*     */   {
/* 302 */     this.ManageCom = tManageCom;
/*     */   }
/*     */ 
/*     */   public String getManageCom()
/*     */   {
/* 307 */     return String.valueOf(this.ManageCom);
/*     */   }
/*     */ 
/*     */   public void setAppntJob(String tAppntJob)
/*     */   {
/* 312 */     this.AppntJob = tAppntJob;
/*     */   }
/*     */ 
/*     */   public String getAppntJob()
/*     */   {
/* 317 */     return String.valueOf(this.AppntJob);
/*     */   }
/*     */ 
/*     */   public void setMainRiskGet(String tMainRiskGet)
/*     */   {
/* 322 */     this.MainRiskGet = tMainRiskGet;
/*     */   }
/*     */ 
/*     */   public String getMainRiskGet()
/*     */   {
/* 327 */     return String.valueOf(this.MainRiskGet);
/*     */   }
/*     */ 
/*     */   public void setRiskSort(String tRiskSort)
/*     */   {
/* 332 */     this.RiskSort = tRiskSort;
/*     */   }
/*     */ 
/*     */   public String getRiskSort()
/*     */   {
/* 337 */     return String.valueOf(this.RiskSort);
/*     */   }
/*     */ 
/*     */   public void setCustomerNo(String tCustomerNo)
/*     */   {
/* 342 */     this.CustomerNo = tCustomerNo;
/*     */   }
/*     */ 
/*     */   public String getCustomerNo()
/*     */   {
/* 347 */     return String.valueOf(this.CustomerNo);
/*     */   }
/*     */ 
/*     */   public void setOccupation(String tOccupation)
/*     */   {
/* 352 */     this.Occupation = tOccupation;
/*     */   }
/*     */ 
/*     */   public String getOccupation()
/*     */   {
/* 357 */     return String.valueOf(this.Occupation);
/*     */   }
/*     */ 
/*     */   public void setGrpContNo(String tGrpContNo)
/*     */   {
/* 363 */     this.GrpContNo = tGrpContNo;
/*     */   }
/*     */ 
/*     */   public void setPrem(double tPrem)
/*     */   {
/* 368 */     this.Prem = tPrem;
/*     */   }
/*     */ 
/*     */   public String getPrem()
/*     */   {
/* 373 */     return String.valueOf(this.Prem);
/*     */   }
/*     */ 
/*     */   public void setGet(double tGet)
/*     */   {
/* 378 */     this.Get = tGet;
/*     */   }
/*     */ 
/*     */   public String getGet()
/*     */   {
/* 383 */     return String.valueOf(this.Get);
/*     */   }
/*     */ 
/*     */   public void setAmnt(double tAmnt)
/*     */   {
/* 388 */     this.Amnt = tAmnt;
/*     */   }
/*     */ 
/*     */   public String getAmnt()
/*     */   {
/* 393 */     return String.valueOf(this.Amnt);
/*     */   }
/*     */ 
/*     */   public void setMult(double tMult)
/*     */   {
/* 398 */     this.Mult = tMult;
/*     */   }
/*     */ 
/*     */   public String getMult()
/*     */   {
/* 403 */     return String.valueOf(this.Mult);
/*     */   }
/*     */ 
/*     */   public void setFloatRate(double tFloatRate)
/*     */   {
/* 408 */     this.FloatRate = tFloatRate;
/*     */   }
/*     */ 
/*     */   public String getFloatRate()
/*     */   {
/* 413 */     return String.valueOf(this.FloatRate);
/*     */   }
/*     */ 
/*     */   public void setAddRate(double tAddRate)
/*     */   {
/* 418 */     this.AddRate = tAddRate;
/*     */   }
/*     */ 
/*     */   public String getContNo()
/*     */   {
/* 423 */     return this.ContNo;
/*     */   }
/*     */ 
/*     */   public String getGrpContNo()
/*     */   {
/* 428 */     return this.GrpContNo;
/*     */   }
/*     */ 
/*     */   public String getAddRate()
/*     */   {
/* 433 */     return String.valueOf(this.AddRate);
/*     */   }
/*     */ 
/*     */   public void setPayIntv(int tPayIntv)
/*     */   {
/* 438 */     this.PayIntv = tPayIntv;
/*     */   }
/*     */ 
/*     */   public String getPayIntv()
/*     */   {
/* 443 */     return String.valueOf(this.PayIntv);
/*     */   }
/*     */ 
/*     */   public void setGetIntv(int tGetIntv)
/*     */   {
/* 448 */     this.GetIntv = tGetIntv;
/*     */   }
/*     */ 
/*     */   public String getGetIntv()
/*     */   {
/* 453 */     return String.valueOf(this.GetIntv);
/*     */   }
/*     */ 
/*     */   public void setPayEndYear(int tPayEndYear)
/*     */   {
/* 459 */     this.PayEndYear = tPayEndYear;
/*     */   }
/*     */ 
/*     */   public String getPayEndYear()
/*     */   {
/* 464 */     return String.valueOf(this.PayEndYear);
/*     */   }
/*     */ 
/*     */   public void setGetYear(int tGetYear)
/*     */   {
/* 469 */     this.GetYear = tGetYear;
/*     */   }
/*     */ 
/*     */   public String getGetYear()
/*     */   {
/* 474 */     return String.valueOf(this.GetYear);
/*     */   }
/*     */ 
/*     */   public void setYears(int tYears)
/*     */   {
/* 479 */     this.Years = tYears;
/*     */   }
/*     */ 
/*     */   public String getYears()
/*     */   {
/* 484 */     return String.valueOf(this.Years);
/*     */   }
/*     */ 
/*     */   public void setInsuYear(int tInsuYear)
/*     */   {
/* 489 */     this.InsuYear = tInsuYear;
/*     */   }
/*     */ 
/*     */   public String getInsuYear()
/*     */   {
/* 494 */     return String.valueOf(this.InsuYear);
/*     */   }
/*     */ 
/*     */   public void setAppAge(int tAppAge)
/*     */   {
/* 499 */     this.AppAge = tAppAge;
/*     */   }
/*     */ 
/*     */   public String getAppAge()
/*     */   {
/* 504 */     return String.valueOf(this.AppAge);
/*     */   }
/*     */ 
/*     */   public void setCount(int tCount)
/*     */   {
/* 509 */     this.Count = tCount;
/*     */   }
/*     */ 
/*     */   public String getCount()
/*     */   {
/* 514 */     return String.valueOf(this.Count);
/*     */   }
/*     */ 
/*     */   public void setRnewFlag(int tRnewFlag)
/*     */   {
/* 519 */     this.RnewFlag = tRnewFlag;
/*     */   }
/*     */ 
/*     */   public String getRnewFlag()
/*     */   {
/* 524 */     return String.valueOf(this.RnewFlag);
/*     */   }
/*     */ 
/*     */   public void setSex(String tSex)
/*     */   {
/* 529 */     this.Sex = tSex;
/*     */   }
/*     */ 
/*     */   public String getSex()
/*     */   {
/* 534 */     return this.Sex;
/*     */   }
/*     */ 
/*     */   public void setInsuYearFlag(String tInsuYearFlag)
/*     */   {
/* 539 */     this.InsuYearFlag = tInsuYearFlag;
/*     */   }
/*     */ 
/*     */   public String getInsuYearFlag()
/*     */   {
/* 544 */     return this.InsuYearFlag;
/*     */   }
/*     */ 
/*     */   public void setPayEndYearFlag(String tPayEndYearFlag)
/*     */   {
/* 549 */     this.PayEndYearFlag = tPayEndYearFlag;
/*     */   }
/*     */ 
/*     */   public String getPayEndYearFlag()
/*     */   {
/* 554 */     return this.PayEndYearFlag;
/*     */   }
/*     */ 
/*     */   public void setGetYearFlag(String tGetYearFlag)
/*     */   {
/* 559 */     this.GetYearFlag = tGetYearFlag;
/*     */   }
/*     */ 
/*     */   public String getGetYearFlag()
/*     */   {
/* 564 */     return this.GetYearFlag;
/*     */   }
/*     */ 
/*     */   public void setGetDutyKind(String tGetDutyKind)
/*     */   {
/* 569 */     this.GetDutyKind = tGetDutyKind;
/*     */   }
/*     */ 
/*     */   public String getGetDutyKind()
/*     */   {
/* 574 */     return this.GetDutyKind;
/*     */   }
/*     */ 
/*     */   public void setStartDateCalRef(String tStartDateCalRef)
/*     */   {
/* 579 */     this.StartDateCalRef = tStartDateCalRef;
/*     */   }
/*     */ 
/*     */   public String getStartDateCalRef()
/*     */   {
/* 584 */     return this.StartDateCalRef;
/*     */   }
/*     */ 
/*     */   public void setJob(String tJob)
/*     */   {
/* 589 */     this.Job = tJob;
/*     */   }
/*     */ 
/*     */   public String getJob()
/*     */   {
/* 594 */     return this.Job;
/*     */   }
/*     */ 
/*     */   public void setGDuty(String tGDuty)
/*     */   {
/* 599 */     this.GDuty = tGDuty;
/*     */   }
/*     */ 
/*     */   public String getGDuty()
/*     */   {
/* 604 */     return this.GDuty;
/*     */   }
/*     */ 
/*     */   public void setPolNo(String tPolNo)
/*     */   {
/* 609 */     this.PolNo = tPolNo;
/*     */   }
/*     */ 
/*     */   public String getPolNo()
/*     */   {
/* 614 */     return this.PolNo;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String tRiskCode)
/*     */   {
/* 619 */     this.RiskCode = tRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRiskCode()
/*     */   {
/* 624 */     return this.RiskCode;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag1(String tStandbyFlag1)
/*     */   {
/* 629 */     this.StandbyFlag1 = tStandbyFlag1;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag1()
/*     */   {
/* 634 */     return this.StandbyFlag1;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag2(String tStandbyFlag2)
/*     */   {
/* 639 */     this.StandbyFlag2 = tStandbyFlag2;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag2()
/*     */   {
/* 644 */     return this.StandbyFlag2;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag3(String tStandbyFlag3)
/*     */   {
/* 649 */     this.StandbyFlag3 = tStandbyFlag3;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag3()
/*     */   {
/* 654 */     return this.StandbyFlag3;
/*     */   }
/*     */ 
/*     */   public void setGrpPolNo(String tGrpPolNo)
/*     */   {
/* 659 */     this.GrpPolNo = tGrpPolNo;
/*     */   }
/*     */ 
/*     */   public String getGrpPolNo()
/*     */   {
/* 664 */     return this.GrpPolNo;
/*     */   }
/*     */ 
/*     */   public void setEdorNo(String tEdorNo)
/*     */   {
/* 669 */     this.EdorNo = tEdorNo;
/*     */   }
/*     */ 
/*     */   public String getEdorNo()
/*     */   {
/* 674 */     return this.EdorNo;
/*     */   }
/*     */ 
/*     */   public void setCalType(String tCalType)
/*     */   {
/* 679 */     this.CalType = tCalType;
/*     */   }
/*     */ 
/*     */   public String getCalType()
/*     */   {
/* 684 */     return this.CalType;
/*     */   }
/*     */ 
/*     */   public void setGetLimit(double tGetLimit)
/*     */   {
/* 689 */     this.GetLimit = tGetLimit;
/*     */   }
/*     */ 
/*     */   public String getGetLimit()
/*     */   {
/* 694 */     return String.valueOf(this.GetLimit);
/*     */   }
/*     */ 
/*     */   public void setGetRate(double tGetRate)
/*     */   {
/* 699 */     this.GetRate = tGetRate;
/*     */   }
/*     */ 
/*     */   public String getGetRate()
/*     */   {
/* 704 */     return String.valueOf(this.GetRate);
/*     */   }
/*     */ 
/*     */   public void setSSFlag(String tSSFlag)
/*     */   {
/* 709 */     this.SSFlag = tSSFlag;
/*     */   }
/*     */ 
/*     */   public String getSSFlag()
/*     */   {
/* 714 */     return this.SSFlag;
/*     */   }
/*     */ 
/*     */   public void setPeakLine(double tPeakLine)
/*     */   {
/* 719 */     this.PeakLine = tPeakLine;
/*     */   }
/*     */ 
/*     */   public String getPeakLine()
/*     */   {
/* 724 */     return String.valueOf(this.PeakLine);
/*     */   }
/*     */ 
/*     */   public void setCValiDate(String tCValiDate)
/*     */   {
/* 729 */     this.CValiDate = tCValiDate;
/*     */   }
/*     */ 
/*     */   public String getCValiDate()
/*     */   {
/* 734 */     return this.CValiDate;
/*     */   }
/*     */ 
/*     */   public void setSuppRiskScore(double tSuppRiskScore)
/*     */   {
/* 739 */     this.SuppRiskScore = tSuppRiskScore;
/*     */   }
/*     */ 
/*     */   public String getSuppRiskScore()
/*     */   {
/* 744 */     return String.valueOf(this.SuppRiskScore);
/*     */   }
/*     */ 
/*     */   public String getDutyCode()
/*     */   {
/* 750 */     return this.DutyCode;
/*     */   }
/*     */ 
/*     */   public void setDutyCode(String tDutyCode)
/*     */   {
/* 755 */     this.DutyCode = tDutyCode;
/*     */   }
/*     */ 
/*     */   public void setFirstScore(double tFirstScore)
/*     */   {
/* 760 */     this.FirstScore = tFirstScore;
/*     */   }
/*     */ 
/*     */   public String getFirstScore()
/*     */   {
/* 766 */     return String.valueOf(this.FirstScore);
/*     */   }
/*     */ 
/*     */   public void setSecondScore(double tSecondScore)
/*     */   {
/* 771 */     this.SecondScore = tSecondScore;
/*     */   }
/*     */ 
/*     */   public String getSecondScore()
/*     */   {
/* 776 */     return String.valueOf(this.SecondScore);
/*     */   }
/*     */ 
/*     */   public void setVPU(String tVPU)
/*     */   {
/* 781 */     this.VPU = tVPU;
/*     */   }
/*     */ 
/*     */   public void setSecondInsuredNo(String tSecondInsuredNo)
/*     */   {
/* 786 */     this.SecondInsuredNo = tSecondInsuredNo;
/*     */   }
/*     */ 
/*     */   public String getSecondInsuredNo()
/*     */   {
/* 791 */     return this.SecondInsuredNo;
/*     */   }
/*     */ 
/*     */   public void setInsuredNo(String tInsuredNo)
/*     */   {
/* 796 */     this.InsuredNo = tInsuredNo;
/*     */   }
/*     */ 
/*     */   public String getInsuredNo()
/*     */   {
/* 801 */     return this.InsuredNo;
/*     */   }
/*     */ 
/*     */   public String getVPU()
/*     */   {
/* 807 */     return this.VPU;
/*     */   }
/*     */ 
/*     */   public void setMainPolNo(String tMainPolNo)
/*     */   {
/* 812 */     this.MainPolNo = tMainPolNo;
/*     */   }
/*     */ 
/*     */   public String getMainPolNo()
/*     */   {
/* 817 */     return this.MainPolNo;
/*     */   }
/*     */ 
/*     */   public void setAppAg2(String tAppAg2)
/*     */   {
/* 822 */     this.AppAg2 = tAppAg2;
/*     */   }
/*     */ 
/*     */   public String getAppAg2()
/*     */   {
/* 827 */     return this.AppAg2;
/*     */   }
/*     */ 
/*     */   public void setHusbandScore(double tHusbandScore)
/*     */   {
/* 832 */     this.HusbandScore = tHusbandScore;
/*     */   }
/*     */ 
/*     */   public String getHusbandScore()
/*     */   {
/* 838 */     return String.valueOf(this.HusbandScore);
/*     */   }
/*     */ 
/*     */   public void setWifeScore(double tWifeScore)
/*     */   {
/* 843 */     this.WifeScore = tWifeScore;
/*     */   }
/*     */ 
/*     */   public String getWifeScore()
/*     */   {
/* 849 */     return String.valueOf(this.WifeScore);
/*     */   }
/*     */ 
/*     */   public void setManageFee(double tManageFee) {
/* 853 */     this.ManageFee = tManageFee;
/*     */   }
/*     */ 
/*     */   public String getManageFee() {
/* 857 */     return String.valueOf(this.ManageFee);
/*     */   }
/*     */ 
/*     */   public String getPayTerm()
/*     */   {
/* 862 */     return this.PayTerm;
/*     */   }
/*     */ 
/*     */   public void setPayTerm(String payTerm)
/*     */   {
/* 867 */     this.PayTerm = payTerm;
/*     */   }
/*     */ 
/*     */   public Date getBirthday()
/*     */   {
/* 872 */     return this.Birthday;
/*     */   }
/*     */ 
/*     */   public void setBirthday(Date birthday)
/*     */   {
/* 877 */     this.Birthday = birthday;
/*     */   }
/*     */ 
/*     */   public String getPolTerm()
/*     */   {
/* 882 */     return this.PolTerm;
/*     */   }
/*     */ 
/*     */   public void setPolTerm(String polTerm)
/*     */   {
/* 887 */     this.PolTerm = polTerm;
/*     */   }
/*     */ 
/*     */   public String getIniAmnt()
/*     */   {
/* 892 */     return this.IniAmnt;
/*     */   }
/*     */ 
/*     */   public void setIniAmnt(String iniAmnt)
/*     */   {
/* 897 */     this.IniAmnt = iniAmnt;
/*     */   }
/*     */ 
/*     */   public String getGiveIntv()
/*     */   {
/* 902 */     return this.GiveIntv;
/*     */   }
/*     */ 
/*     */   public void setGiveIntv(String giveIntv)
/*     */   {
/* 907 */     this.GiveIntv = giveIntv;
/*     */   }
/*     */ 
/*     */   public String getDrawYear()
/*     */   {
/* 912 */     return this.DrawYear;
/*     */   }
/*     */ 
/*     */   public void setDrawYear(String drawYear)
/*     */   {
/* 917 */     this.DrawYear = drawYear;
/*     */   }
/*     */ 
/*     */   public String getCalSql()
/*     */   {
/* 922 */     return this.CalSql;
/*     */   }
/*     */ 
/*     */   public void setCalSql(String calSql)
/*     */   {
/* 927 */     this.CalSql = calSql;
/*     */   }
/*     */ 
/*     */   public String getStrBirthday()
/*     */   {
/* 932 */     FDate fDate = new FDate();
/* 933 */     if (this.strBirthday != null) {
/* 934 */       return fDate.getString(this.strBirthday);
/*     */     }
/* 936 */     return null;
/*     */   }
/*     */ 
/*     */   public void setStrBirthday(String strBirthday) {
/* 940 */     FDate fDate = new FDate();
/* 941 */     if ((strBirthday != null) && (!"".equals(strBirthday))) {
/* 942 */       this.strBirthday = fDate.getDate(strBirthday);
/*     */     }
/*     */     else
/* 945 */       this.strBirthday = null;
/*     */   }
/*     */ 
/*     */   public void setStrBirthday(Date strBirthday)
/*     */   {
/* 950 */     this.strBirthday = strBirthday;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.CalBase
 * JD-Core Version:    0.6.0
 */