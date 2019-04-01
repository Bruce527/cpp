/*      */ package com.sinosoft.map.lis.pubfun;
/*      */ 
/*      */ public class BqCalBase
/*      */ {
/*      */   private double Prem;
/*      */   private double SumPrem;
/*      */   private double Get;
/*      */   private double Mult;
/*      */   private int PayIntv;
/*      */   private int GetIntv;
/*      */   private String GetStartFlag;
/*      */   private String PayEndYearFlag;
/*      */   private int PayEndYear;
/*      */   private int GetStartYear;
/*      */   private int GetStartAge;
/*      */   private int GetAppYear;
/*      */   private int GetYear;
/*      */   private int GetAge;
/*      */   private int GetTimes;
/*      */   private int Years;
/*      */   private int AppAge;
/*      */   private String Sex;
/*      */   private String Job;
/*      */   private String GDuty;
/*      */   private int Count;
/*      */   private double AddRate;
/*      */   private String PolNo;
/*      */   private String GrpPolNo;
/*      */   private String ContNo;
/*      */   private String GrpContNo;
/*      */   private String AppntNo;
/*      */   private String InsuredNo;
/*      */   private int Interval;
/*      */   private int LimitDay;
/*      */   private int PolValiFlag;
/*      */   private double LoanMoney;
/*      */   private double TrayMoney;
/*      */   private String Operator;
/*      */   private String EdorAcceptNo;
/*      */   private String EdorNo;
/*      */   private String EdorType;
/*      */   private String EdorValiDate;
/*      */   private double GetMoney;
/*      */   private String GetStartDate;
/*      */   private String CValiDate;
/*      */   private double GetBalance;
/*      */   private String RiskCode;
/*      */   private double FloatRate;
/*      */   private int InsuYear;
/*      */   private String InsuYearFlag;
/*      */   private String StandByFlag1;
/*      */   private String DownPolYears;
/*      */   private String UpPolYears;
/*      */   private double LastPrem;
/*      */   private String ZTPoint;
/*      */   private String PayToDate;
/*      */   private String EndDate;
/*      */   private String EdorAppDate;
/*      */   private double NewPrem;
/*      */   private String CalType;
/*      */   private int RemainYear;
/*      */   private String StartDate;
/*      */   private String AAYears;
/*      */   private double SumDangerAmnt;
/*      */   private double SumInvaliAmnt;
/*      */   private String GetDutyCode;
/*      */   private String GetDutyKind;
/*      */   private int GetCount;
/*      */   private double SumGet;
/*      */   private double CashValue;
/*      */   private double AvailableAmnt;
/*      */   private double FinalBonus;
/*      */   private int IntvMonth;
/*      */   private String DutyCode;
/*      */   private double Amnt;
/*      */   private double VPU;
/*      */   private double SumAmntBonus;
/*      */   private double TotalPrem;
/*      */   private int PayTimes;
/*      */   private String NSMonths;
/*      */   private String BonusRate;
/*      */   private String ForceDVFlag;
/*      */   private String CashFlag;
/*      */   private String HesitateFlag;
/*      */   private double ContSumLoan;
/*      */   private int InsuYearT1;
/*      */   private int InsuYearT2;
/*      */   private String MainPolNo;
/*      */   private String ManageCom;
/*      */   private String EdorTypeCal;
/*      */   private String BnfType;
/*      */   private String CalMode;
/*      */   private String PlanCode;
/*      */ 
/*      */   public void setEdorAppDate(String tEdorAppDate)
/*      */   {
/*  202 */     this.EdorAppDate = tEdorAppDate;
/*      */   }
/*      */ 
/*      */   public String getEdorAppDate()
/*      */   {
/*  207 */     return this.EdorAppDate;
/*      */   }
/*      */ 
/*      */   public void setDownPolYears(String tDownPolYears)
/*      */   {
/*  212 */     this.DownPolYears = tDownPolYears;
/*      */   }
/*      */ 
/*      */   public String getDownPolYears()
/*      */   {
/*  217 */     return this.DownPolYears;
/*      */   }
/*      */ 
/*      */   public void setUpPolYears(String tUpPolYears)
/*      */   {
/*  222 */     this.UpPolYears = tUpPolYears;
/*      */   }
/*      */ 
/*      */   public String getUpPolYears()
/*      */   {
/*  227 */     return this.UpPolYears;
/*      */   }
/*      */ 
/*      */   public void setZTPoint(String tZTPoint)
/*      */   {
/*  232 */     this.ZTPoint = tZTPoint;
/*      */   }
/*      */ 
/*      */   public String getZTPoint()
/*      */   {
/*  237 */     return this.ZTPoint;
/*      */   }
/*      */ 
/*      */   public void setPayToDate(String tPayToDate)
/*      */   {
/*  242 */     this.PayToDate = tPayToDate;
/*      */   }
/*      */ 
/*      */   public String getPayToDate()
/*      */   {
/*  247 */     return this.PayToDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String tEndDate) {
/*  251 */     this.EndDate = tEndDate;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  256 */     return this.EndDate;
/*      */   }
/*      */ 
/*      */   public void setInsuYear(int tInsuYear)
/*      */   {
/*  261 */     this.InsuYear = tInsuYear;
/*      */   }
/*      */ 
/*      */   public String getInsuYear()
/*      */   {
/*  266 */     return String.valueOf(this.InsuYear);
/*      */   }
/*      */ 
/*      */   public void setInsuYearFlag(String tInsuYearFlag)
/*      */   {
/*  271 */     this.InsuYearFlag = tInsuYearFlag;
/*      */   }
/*      */ 
/*      */   public String getInsuYearFlag()
/*      */   {
/*  276 */     return this.InsuYearFlag;
/*      */   }
/*      */ 
/*      */   public void setInterval(int tInterval)
/*      */   {
/*  281 */     this.Interval = tInterval;
/*      */   }
/*      */ 
/*      */   public String getInterval()
/*      */   {
/*  286 */     return String.valueOf(this.Interval);
/*      */   }
/*      */ 
/*      */   public void setLimitDay(int tLimitDay)
/*      */   {
/*  291 */     this.LimitDay = tLimitDay;
/*      */   }
/*      */ 
/*      */   public String getLimitDay()
/*      */   {
/*  296 */     return String.valueOf(this.LimitDay);
/*      */   }
/*      */ 
/*      */   public void setPolValiFlag(int tPolValiFlag)
/*      */   {
/*  301 */     this.PolValiFlag = tPolValiFlag;
/*      */   }
/*      */ 
/*      */   public String getPolValiFlag()
/*      */   {
/*  306 */     return String.valueOf(this.PolValiFlag);
/*      */   }
/*      */ 
/*      */   public String getLoanMoney()
/*      */   {
/*  312 */     return String.valueOf(this.LoanMoney);
/*      */   }
/*      */ 
/*      */   public void setLoanMoney(double tLoanMoney)
/*      */   {
/*  317 */     this.LoanMoney = tLoanMoney;
/*      */   }
/*      */ 
/*      */   public String getContSumLoan()
/*      */   {
/*  322 */     return String.valueOf(this.ContSumLoan);
/*      */   }
/*      */ 
/*      */   public void setContSumLoan(double tContSumLoan)
/*      */   {
/*  327 */     this.ContSumLoan = tContSumLoan;
/*      */   }
/*      */ 
/*      */   public String getTrayMoney()
/*      */   {
/*  332 */     return String.valueOf(this.TrayMoney);
/*      */   }
/*      */ 
/*      */   public void setTrayMoney(double tTrayMoney)
/*      */   {
/*  337 */     this.TrayMoney = tTrayMoney;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  342 */     return String.valueOf(this.Operator);
/*      */   }
/*      */ 
/*      */   public void setOperator(String tOperator)
/*      */   {
/*  347 */     this.Operator = tOperator;
/*      */   }
/*      */ 
/*      */   public void setPrem(double tPrem)
/*      */   {
/*  353 */     this.Prem = tPrem;
/*      */   }
/*      */ 
/*      */   public String getPrem()
/*      */   {
/*  358 */     return String.valueOf(this.Prem);
/*      */   }
/*      */ 
/*      */   public void setSumPrem(double tSumPrem)
/*      */   {
/*  363 */     this.SumPrem = tSumPrem;
/*      */   }
/*      */ 
/*      */   public String getSumPrem()
/*      */   {
/*  368 */     return String.valueOf(this.SumPrem);
/*      */   }
/*      */ 
/*      */   public void setGet(double tGet)
/*      */   {
/*  373 */     this.Get = tGet;
/*      */   }
/*      */ 
/*      */   public String getGet()
/*      */   {
/*  378 */     return String.valueOf(this.Get);
/*      */   }
/*      */ 
/*      */   public void setMult(double tMult)
/*      */   {
/*  383 */     this.Mult = tMult;
/*      */   }
/*      */ 
/*      */   public String getMult()
/*      */   {
/*  388 */     return String.valueOf(this.Mult);
/*      */   }
/*      */ 
/*      */   public void setAddRate(double tAddRate)
/*      */   {
/*  393 */     this.AddRate = tAddRate;
/*      */   }
/*      */ 
/*      */   public String getAddRate()
/*      */   {
/*  398 */     return String.valueOf(this.AddRate);
/*      */   }
/*      */ 
/*      */   public void setPayIntv(int tPayIntv)
/*      */   {
/*  403 */     this.PayIntv = tPayIntv;
/*      */   }
/*      */ 
/*      */   public String getPayIntv()
/*      */   {
/*  408 */     return String.valueOf(this.PayIntv);
/*      */   }
/*      */ 
/*      */   public void setGetIntv(int tGetIntv)
/*      */   {
/*  413 */     this.GetIntv = tGetIntv;
/*      */   }
/*      */ 
/*      */   public String getGetIntv()
/*      */   {
/*  418 */     return String.valueOf(this.GetIntv);
/*      */   }
/*      */ 
/*      */   public void setPayEndYear(int tPayEndYear)
/*      */   {
/*  423 */     this.PayEndYear = tPayEndYear;
/*      */   }
/*      */ 
/*      */   public String getPayEndYear()
/*      */   {
/*  428 */     return String.valueOf(this.PayEndYear);
/*      */   }
/*      */ 
/*      */   public void setGetYear(int tGetYear)
/*      */   {
/*  433 */     this.GetYear = tGetYear;
/*      */   }
/*      */ 
/*      */   public String getGetYear()
/*      */   {
/*  438 */     return String.valueOf(this.GetYear);
/*      */   }
/*      */ 
/*      */   public void setGetAppYear(int tGetAppYear)
/*      */   {
/*  443 */     this.GetAppYear = tGetAppYear;
/*      */   }
/*      */ 
/*      */   public String getGetAppYear()
/*      */   {
/*  448 */     return String.valueOf(this.GetAppYear);
/*      */   }
/*      */ 
/*      */   public void setGetAge(int tGetAge)
/*      */   {
/*  453 */     this.GetAge = tGetAge;
/*      */   }
/*      */ 
/*      */   public String getGetAge()
/*      */   {
/*  458 */     return String.valueOf(this.GetAge);
/*      */   }
/*      */ 
/*      */   public void setGetStartYear(int tGetStartYear)
/*      */   {
/*  463 */     this.GetStartYear = tGetStartYear;
/*      */   }
/*      */ 
/*      */   public String getGetStartYear()
/*      */   {
/*  468 */     return String.valueOf(this.GetStartYear);
/*      */   }
/*      */ 
/*      */   public void setGetStartAge(int tGetStartAge)
/*      */   {
/*  473 */     this.GetStartAge = tGetStartAge;
/*      */   }
/*      */ 
/*      */   public String getGetStartAge()
/*      */   {
/*  478 */     return String.valueOf(this.GetStartAge);
/*      */   }
/*      */ 
/*      */   public void setGetTimes(int tGetTimes)
/*      */   {
/*  483 */     this.GetTimes = tGetTimes;
/*      */   }
/*      */ 
/*      */   public String getGetTimes()
/*      */   {
/*  488 */     return String.valueOf(this.GetTimes);
/*      */   }
/*      */ 
/*      */   public void setYears(int tYears)
/*      */   {
/*  493 */     this.Years = tYears;
/*      */   }
/*      */ 
/*      */   public String getYears()
/*      */   {
/*  498 */     return String.valueOf(this.Years);
/*      */   }
/*      */ 
/*      */   public void setAppAge(int tAppAge)
/*      */   {
/*  503 */     this.AppAge = tAppAge;
/*      */   }
/*      */ 
/*      */   public String getAppAge()
/*      */   {
/*  508 */     return String.valueOf(this.AppAge);
/*      */   }
/*      */ 
/*      */   public void setCount(int tCount)
/*      */   {
/*  513 */     this.Count = tCount;
/*      */   }
/*      */ 
/*      */   public String getCount()
/*      */   {
/*  518 */     return String.valueOf(this.Count);
/*      */   }
/*      */ 
/*      */   public void setSex(String tSex)
/*      */   {
/*  523 */     this.Sex = tSex;
/*      */   }
/*      */ 
/*      */   public String getSex()
/*      */   {
/*  528 */     return this.Sex;
/*      */   }
/*      */ 
/*      */   public void setJob(String tJob)
/*      */   {
/*  533 */     this.Job = tJob;
/*      */   }
/*      */ 
/*      */   public String getJob()
/*      */   {
/*  538 */     return this.Job;
/*      */   }
/*      */ 
/*      */   public void setGDuty(String tGDuty)
/*      */   {
/*  543 */     this.GDuty = tGDuty;
/*      */   }
/*      */ 
/*      */   public String getGDuty()
/*      */   {
/*  548 */     return this.GDuty;
/*      */   }
/*      */ 
/*      */   public void setPolNo(String tPolNo)
/*      */   {
/*  553 */     this.PolNo = tPolNo;
/*      */   }
/*      */ 
/*      */   public String getPolNo()
/*      */   {
/*  558 */     return this.PolNo;
/*      */   }
/*      */ 
/*      */   public void setGrpPolNo(String tGrpPolNo)
/*      */   {
/*  563 */     this.GrpPolNo = tGrpPolNo;
/*      */   }
/*      */ 
/*      */   public String getGrpPolNo()
/*      */   {
/*  568 */     return this.GrpPolNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String tContNo)
/*      */   {
/*  573 */     this.ContNo = tContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo()
/*      */   {
/*  578 */     return this.ContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String tGrpContNo)
/*      */   {
/*  583 */     this.GrpContNo = tGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo()
/*      */   {
/*  588 */     return this.GrpContNo;
/*      */   }
/*      */ 
/*      */   public void setAppntNo(String tAppntNo)
/*      */   {
/*  593 */     this.AppntNo = tAppntNo;
/*      */   }
/*      */ 
/*      */   public String getAppntNo()
/*      */   {
/*  598 */     return this.AppntNo;
/*      */   }
/*      */ 
/*      */   public void setInsuredNo(String tInsuredNo)
/*      */   {
/*  603 */     this.InsuredNo = tInsuredNo;
/*      */   }
/*      */ 
/*      */   public String getInsuredNo()
/*      */   {
/*  608 */     return this.InsuredNo;
/*      */   }
/*      */ 
/*      */   public void setEdorAcceptNo(String tEdorAcceptNo)
/*      */   {
/*  613 */     this.EdorAcceptNo = tEdorAcceptNo;
/*      */   }
/*      */ 
/*      */   public String getEdorAcceptNo()
/*      */   {
/*  618 */     return this.EdorAcceptNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String tEdorNo)
/*      */   {
/*  623 */     this.EdorNo = tEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  628 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String tEdorType)
/*      */   {
/*  633 */     this.EdorType = tEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorType()
/*      */   {
/*  639 */     return this.EdorType;
/*      */   }
/*      */ 
/*      */   public void setGetMoney(double tGetMoney)
/*      */   {
/*  644 */     this.GetMoney = tGetMoney;
/*      */   }
/*      */ 
/*      */   public String getGetMoney()
/*      */   {
/*  649 */     return String.valueOf(this.GetMoney);
/*      */   }
/*      */ 
/*      */   public void setCValiDate(String tCValiDate)
/*      */   {
/*  654 */     this.CValiDate = tCValiDate;
/*      */   }
/*      */ 
/*      */   public String getCValiDate()
/*      */   {
/*  659 */     return this.CValiDate;
/*      */   }
/*      */ 
/*      */   public void setEdorValiDate(String tEdorValiDate)
/*      */   {
/*  664 */     this.EdorValiDate = tEdorValiDate;
/*      */   }
/*      */ 
/*      */   public String getEdorValiDate()
/*      */   {
/*  669 */     return this.EdorValiDate;
/*      */   }
/*      */ 
/*      */   public void setGetStartDate(String tGetStartDate)
/*      */   {
/*  674 */     this.GetStartDate = tGetStartDate;
/*      */   }
/*      */ 
/*      */   public String getGetStartDate()
/*      */   {
/*  679 */     return this.GetStartDate;
/*      */   }
/*      */ 
/*      */   public void setGetBalance(double tGetBalance)
/*      */   {
/*  684 */     this.GetBalance = tGetBalance;
/*      */   }
/*      */ 
/*      */   public String getGetBalance()
/*      */   {
/*  689 */     return String.valueOf(this.GetBalance);
/*      */   }
/*      */ 
/*      */   public void setRiskCode(String tRiskCode)
/*      */   {
/*  694 */     this.RiskCode = tRiskCode;
/*      */   }
/*      */ 
/*      */   public String getRiskCode()
/*      */   {
/*  699 */     return this.RiskCode;
/*      */   }
/*      */ 
/*      */   public void setPayEndYearFlag(String tPayEndYearFlag)
/*      */   {
/*  704 */     this.PayEndYearFlag = tPayEndYearFlag;
/*      */   }
/*      */ 
/*      */   public String getPayEndYearFlag()
/*      */   {
/*  709 */     return this.PayEndYearFlag;
/*      */   }
/*      */ 
/*      */   public void setGetStartFlag(String tGetStartFlag)
/*      */   {
/*  714 */     this.GetStartFlag = tGetStartFlag;
/*      */   }
/*      */ 
/*      */   public String getGetStartFlag()
/*      */   {
/*  719 */     return this.GetStartFlag;
/*      */   }
/*      */ 
/*      */   public void setFloatRate(double tFloatRate)
/*      */   {
/*  724 */     this.FloatRate = tFloatRate;
/*      */   }
/*      */ 
/*      */   public String getFloatRate()
/*      */   {
/*  729 */     return String.valueOf(this.FloatRate);
/*      */   }
/*      */ 
/*      */   public void setStandByFlag1(String tStandByFlag1)
/*      */   {
/*  734 */     this.StandByFlag1 = tStandByFlag1;
/*      */   }
/*      */ 
/*      */   public String getStandByFlag1()
/*      */   {
/*  739 */     return this.StandByFlag1;
/*      */   }
/*      */ 
/*      */   public void setNewPrem(double tNewPrem)
/*      */   {
/*  744 */     this.NewPrem = tNewPrem;
/*      */   }
/*      */ 
/*      */   public String getNewPrem()
/*      */   {
/*  749 */     return String.valueOf(this.NewPrem);
/*      */   }
/*      */ 
/*      */   public void setCalType(String tCalType)
/*      */   {
/*  754 */     this.CalType = tCalType;
/*      */   }
/*      */ 
/*      */   public String getCalType()
/*      */   {
/*  759 */     return this.CalType;
/*      */   }
/*      */ 
/*      */   public void setRemainYear(int tRemainYear)
/*      */   {
/*  764 */     this.RemainYear = tRemainYear;
/*      */   }
/*      */ 
/*      */   public String getRemainYear()
/*      */   {
/*  769 */     return String.valueOf(this.RemainYear);
/*      */   }
/*      */ 
/*      */   public void setStartDate(String tStartDate)
/*      */   {
/*  774 */     this.StartDate = tStartDate;
/*      */   }
/*      */ 
/*      */   public String getStartDate()
/*      */   {
/*  779 */     return this.StartDate;
/*      */   }
/*      */ 
/*      */   public void setAAYears(String tAAYears)
/*      */   {
/*  784 */     this.AAYears = tAAYears;
/*      */   }
/*      */ 
/*      */   public String getAAYears()
/*      */   {
/*  789 */     return this.AAYears;
/*      */   }
/*      */ 
/*      */   public void setSumDangerAmnt(double tSumDangerAmnt)
/*      */   {
/*  794 */     this.SumDangerAmnt = tSumDangerAmnt;
/*      */   }
/*      */ 
/*      */   public String getSumDangerAmnt()
/*      */   {
/*  799 */     return String.valueOf(this.SumDangerAmnt);
/*      */   }
/*      */ 
/*      */   public void setSumInvaliAmnt(double tSumInvaliAmnt)
/*      */   {
/*  804 */     this.SumInvaliAmnt = tSumInvaliAmnt;
/*      */   }
/*      */ 
/*      */   public String getSumInvaliAmnt()
/*      */   {
/*  809 */     return String.valueOf(this.SumInvaliAmnt);
/*      */   }
/*      */ 
/*      */   public void setGetDutyCode(String tGetDutyCode)
/*      */   {
/*  814 */     this.GetDutyCode = tGetDutyCode;
/*      */   }
/*      */ 
/*      */   public String getGetDutyCode() {
/*  818 */     return this.GetDutyCode;
/*      */   }
/*      */ 
/*      */   public void setGetCount(int tGetCount)
/*      */   {
/*  823 */     this.GetCount = tGetCount;
/*      */   }
/*      */ 
/*      */   public String getGetCount() {
/*  827 */     return String.valueOf(this.GetCount);
/*      */   }
/*      */ 
/*      */   public void setSumGet(double tSumGet)
/*      */   {
/*  832 */     this.SumGet = tSumGet;
/*      */   }
/*      */ 
/*      */   public String getSumGet() {
/*  836 */     return String.valueOf(this.SumGet);
/*      */   }
/*      */ 
/*      */   public void setCashValue(double tCashValue)
/*      */   {
/*  841 */     this.CashValue = tCashValue;
/*      */   }
/*      */ 
/*      */   public String getCashValue() {
/*  845 */     return String.valueOf(this.CashValue);
/*      */   }
/*      */ 
/*      */   public void setAvailableAmnt(double tAvailableAmnt)
/*      */   {
/*  850 */     this.AvailableAmnt = tAvailableAmnt;
/*      */   }
/*      */ 
/*      */   public String getAvailableAmnt() {
/*  854 */     return String.valueOf(this.AvailableAmnt);
/*      */   }
/*      */ 
/*      */   public void setFinalBonus(double tFinalBonus)
/*      */   {
/*  859 */     this.FinalBonus = tFinalBonus;
/*      */   }
/*      */ 
/*      */   public String getFinalBonus() {
/*  863 */     return String.valueOf(this.FinalBonus);
/*      */   }
/*      */ 
/*      */   public void setDutyCode(String tDutyCode)
/*      */   {
/*  868 */     this.DutyCode = tDutyCode;
/*      */   }
/*      */ 
/*      */   public String getDutyCode() {
/*  872 */     return this.DutyCode;
/*      */   }
/*      */ 
/*      */   public void setAmnt(double tAmnt)
/*      */   {
/*  877 */     this.Amnt = tAmnt;
/*      */   }
/*      */ 
/*      */   public String getAmnt() {
/*  881 */     return String.valueOf(this.Amnt);
/*      */   }
/*      */ 
/*      */   public void setVPU(double tVPU)
/*      */   {
/*  886 */     this.VPU = tVPU;
/*      */   }
/*      */ 
/*      */   public String getVPU() {
/*  890 */     return String.valueOf(this.VPU);
/*      */   }
/*      */ 
/*      */   public void setSumAmntBonus(double tSumAmntBonus)
/*      */   {
/*  895 */     this.SumAmntBonus = tSumAmntBonus;
/*      */   }
/*      */ 
/*      */   public String getSumAmntBonus() {
/*  899 */     return String.valueOf(this.SumAmntBonus);
/*      */   }
/*      */ 
/*      */   public void setTotalPrem(double tTotalPrem)
/*      */   {
/*  904 */     this.TotalPrem = tTotalPrem;
/*      */   }
/*      */ 
/*      */   public String getTotalPrem() {
/*  908 */     return String.valueOf(this.TotalPrem);
/*      */   }
/*      */ 
/*      */   public void setGetDutyKind(String tGetDutyKind)
/*      */   {
/*  913 */     this.GetDutyKind = tGetDutyKind;
/*      */   }
/*      */ 
/*      */   public String getGetDutyKind() {
/*  917 */     return this.GetDutyKind;
/*      */   }
/*      */ 
/*      */   public void setPayTimes(int tPayTimes)
/*      */   {
/*  922 */     this.PayTimes = tPayTimes;
/*      */   }
/*      */ 
/*      */   public String getPayTimes() {
/*  926 */     return String.valueOf(this.PayTimes);
/*      */   }
/*      */ 
/*      */   public void setNSMonths(int aNSMonths) {
/*  930 */     this.NSMonths = String.valueOf(aNSMonths);
/*      */   }
/*      */ 
/*      */   public String getNSMonths() {
/*  934 */     return this.NSMonths;
/*      */   }
/*      */ 
/*      */   public void setBonusRate(double aBonusRate) {
/*  938 */     this.BonusRate = String.valueOf(aBonusRate);
/*      */   }
/*      */ 
/*      */   public String getBonusRate() {
/*  942 */     return this.BonusRate;
/*      */   }
/*      */ 
/*      */   public void setForceDVFlag(String aForceDVFlag) {
/*  946 */     this.ForceDVFlag = aForceDVFlag;
/*      */   }
/*      */ 
/*      */   public String getForceDVFlag() {
/*  950 */     return this.ForceDVFlag;
/*      */   }
/*      */ 
/*      */   public void setCashFlag(String tCashFlag)
/*      */   {
/*  955 */     this.CashFlag = tCashFlag;
/*      */   }
/*      */ 
/*      */   public String getCashFlag() {
/*  959 */     return this.CashFlag;
/*      */   }
/*      */ 
/*      */   public void setHesitateFlag(String aHesitateFlag) {
/*  963 */     this.HesitateFlag = aHesitateFlag;
/*      */   }
/*      */ 
/*      */   public String getHesitateFlag() {
/*  967 */     return this.HesitateFlag;
/*      */   }
/*      */ 
/*      */   public void setIntvMonth(int aIntvMonth) {
/*  971 */     this.IntvMonth = aIntvMonth;
/*      */   }
/*      */ 
/*      */   public String getIntvMonth() {
/*  975 */     return String.valueOf(this.IntvMonth);
/*      */   }
/*      */ 
/*      */   public void setInsuYearT1(int aInsuYearT1) {
/*  979 */     this.InsuYearT1 = aInsuYearT1;
/*      */   }
/*      */ 
/*      */   public String getInsuYearT1() {
/*  983 */     return String.valueOf(this.InsuYearT1);
/*      */   }
/*      */ 
/*      */   public void setInsuYearT2(int aInsuYearT2) {
/*  987 */     this.InsuYearT2 = aInsuYearT2;
/*      */   }
/*      */ 
/*      */   public String getInsuYearT2() {
/*  991 */     return String.valueOf(this.InsuYearT2);
/*      */   }
/*      */ 
/*      */   public void setLastPrem(double aLastPrem) {
/*  995 */     this.LastPrem = aLastPrem;
/*      */   }
/*      */ 
/*      */   public String getLastPrem() {
/*  999 */     return String.valueOf(this.LastPrem);
/*      */   }
/*      */ 
/*      */   public void setMainPolNo(String tMainPolNo) {
/* 1003 */     this.MainPolNo = tMainPolNo;
/*      */   }
/*      */ 
/*      */   public String getMainPolNo()
/*      */   {
/* 1008 */     return this.MainPolNo;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String tManageCom)
/*      */   {
/* 1013 */     this.ManageCom = tManageCom;
/*      */   }
/*      */ 
/*      */   public String getManageCom()
/*      */   {
/* 1018 */     return String.valueOf(this.ManageCom);
/*      */   }
/*      */ 
/*      */   public void setEdorTypeCal(String tEdorTypeCal) {
/* 1022 */     this.EdorTypeCal = tEdorTypeCal;
/*      */   }
/*      */ 
/*      */   public String getEdorTypeCal()
/*      */   {
/* 1027 */     return String.valueOf(this.EdorTypeCal);
/*      */   }
/*      */ 
/*      */   public void setBnfType(String tBnfType) {
/* 1031 */     this.BnfType = tBnfType;
/*      */   }
/*      */ 
/*      */   public String getBnfType()
/*      */   {
/* 1036 */     return String.valueOf(this.BnfType);
/*      */   }
/*      */ 
/*      */   public void setCalMode(String tCalMode)
/*      */   {
/* 1042 */     this.CalMode = tCalMode;
/*      */   }
/*      */ 
/*      */   public String getCalMode() {
/* 1046 */     return String.valueOf(this.CalMode);
/*      */   }
/*      */ 
/*      */   public void setPlanCode(String tPlanCode) {
/* 1050 */     this.PlanCode = tPlanCode;
/*      */   }
/*      */ 
/*      */   public String getPlanCode() {
/* 1054 */     return String.valueOf(this.PlanCode);
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.BqCalBase
 * JD-Core Version:    0.6.0
 */