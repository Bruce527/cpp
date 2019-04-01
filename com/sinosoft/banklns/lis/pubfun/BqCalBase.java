/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ public class BqCalBase
/*     */ {
/*     */   private double Prem;
/*     */   private double Get;
/*     */   private double Mult;
/*     */   private int PayIntv;
/*     */   private int GetIntv;
/*     */   private String GetStartFlag;
/*     */   private String PayEndYearFlag;
/*     */   private int PayEndYear;
/*     */   private int GetStartYear;
/*     */   private int GetStartAge;
/*     */   private int GetAppYear;
/*     */   private int GetYear;
/*     */   private int GetAge;
/*     */   private int GetTimes;
/*     */   private int Years;
/*     */   private int AppAge;
/*     */   private int AppAgeType;
/*     */   private String Sex;
/*     */   private String Job;
/*     */   private String GDuty;
/*     */   private int Count;
/*     */   private double AddRate;
/*     */   private String PolNo;
/*     */   private String GrpPolNo;
/*     */   private int Interval;
/*     */   private String EdorNo;
/*     */   private String EdorType;
/*     */   private String EdorValiDate;
/*     */   private double GetMoney;
/*     */   private String GetStartDate;
/*     */   private String CValiDate;
/*     */   private double GetBalance;
/*     */   private String RiskCode;
/*     */ 
/*     */   public void setInterval(int tInterval)
/*     */   {
/*  57 */     this.Interval = tInterval;
/*     */   }
/*     */ 
/*     */   public String getInterval() {
/*  61 */     return String.valueOf(this.Interval);
/*     */   }
/*     */ 
/*     */   public void setPrem(double tPrem) {
/*  65 */     this.Prem = tPrem;
/*     */   }
/*     */ 
/*     */   public String getPrem() {
/*  69 */     return String.valueOf(this.Prem);
/*     */   }
/*     */ 
/*     */   public void setGet(double tGet)
/*     */   {
/*  74 */     this.Get = tGet;
/*     */   }
/*     */ 
/*     */   public String getGet() {
/*  78 */     return String.valueOf(this.Get);
/*     */   }
/*     */ 
/*     */   public void setMult(double tMult)
/*     */   {
/*  83 */     this.Mult = tMult;
/*     */   }
/*     */ 
/*     */   public String getMult() {
/*  87 */     return String.valueOf(this.Mult);
/*     */   }
/*     */ 
/*     */   public void setAddRate(double tAddRate)
/*     */   {
/*  92 */     this.AddRate = tAddRate;
/*     */   }
/*     */ 
/*     */   public String getAddRate() {
/*  96 */     return String.valueOf(this.AddRate);
/*     */   }
/*     */ 
/*     */   public void setPayIntv(int tPayIntv)
/*     */   {
/* 101 */     this.PayIntv = tPayIntv;
/*     */   }
/*     */ 
/*     */   public String getPayIntv() {
/* 105 */     return String.valueOf(this.PayIntv);
/*     */   }
/*     */ 
/*     */   public void setGetIntv(int tGetIntv)
/*     */   {
/* 110 */     this.GetIntv = tGetIntv;
/*     */   }
/*     */ 
/*     */   public String getGetIntv() {
/* 114 */     return String.valueOf(this.GetIntv);
/*     */   }
/*     */ 
/*     */   public void setPayEndYear(int tPayEndYear)
/*     */   {
/* 119 */     this.PayEndYear = tPayEndYear;
/*     */   }
/*     */ 
/*     */   public String getPayEndYear() {
/* 123 */     return String.valueOf(this.PayEndYear);
/*     */   }
/*     */ 
/*     */   public void setGetYear(int tGetYear)
/*     */   {
/* 128 */     this.GetYear = tGetYear;
/*     */   }
/*     */ 
/*     */   public String getGetYear() {
/* 132 */     return String.valueOf(this.GetYear);
/*     */   }
/*     */ 
/*     */   public void setGetAppYear(int tGetAppYear) {
/* 136 */     this.GetAppYear = tGetAppYear;
/*     */   }
/*     */ 
/*     */   public String getGetAppYear() {
/* 140 */     return String.valueOf(this.GetAppYear);
/*     */   }
/*     */ 
/*     */   public void setGetAge(int tGetAge) {
/* 144 */     this.GetAge = tGetAge;
/*     */   }
/*     */ 
/*     */   public String getGetAge() {
/* 148 */     return String.valueOf(this.GetAge);
/*     */   }
/*     */ 
/*     */   public void setGetStartYear(int tGetStartYear) {
/* 152 */     this.GetStartYear = tGetStartYear;
/*     */   }
/*     */ 
/*     */   public String getGetStartYear() {
/* 156 */     return String.valueOf(this.GetStartYear);
/*     */   }
/*     */ 
/*     */   public void setGetStartAge(int tGetStartAge) {
/* 160 */     this.GetStartAge = tGetStartAge;
/*     */   }
/*     */ 
/*     */   public String getGetStartAge() {
/* 164 */     return String.valueOf(this.GetStartAge);
/*     */   }
/*     */ 
/*     */   public void setGetTimes(int tGetTimes)
/*     */   {
/* 169 */     this.GetTimes = tGetTimes;
/*     */   }
/*     */ 
/*     */   public String getGetTimes() {
/* 173 */     return String.valueOf(this.GetTimes);
/*     */   }
/*     */ 
/*     */   public void setYears(int tYears)
/*     */   {
/* 178 */     this.Years = tYears;
/*     */   }
/*     */ 
/*     */   public String getYears() {
/* 182 */     return String.valueOf(this.Years);
/*     */   }
/*     */ 
/*     */   public void setAppAge(int tAppAge)
/*     */   {
/* 187 */     this.AppAge = tAppAge;
/*     */   }
/*     */ 
/*     */   public String getAppAge() {
/* 191 */     return String.valueOf(this.AppAge);
/*     */   }
/*     */ 
/*     */   public void setCount(int tCount)
/*     */   {
/* 196 */     this.Count = tCount;
/*     */   }
/*     */ 
/*     */   public String getCount() {
/* 200 */     return String.valueOf(this.Count);
/*     */   }
/*     */ 
/*     */   public void setSex(String tSex)
/*     */   {
/* 205 */     this.Sex = tSex;
/*     */   }
/*     */ 
/*     */   public String getSex() {
/* 209 */     return this.Sex;
/*     */   }
/*     */ 
/*     */   public void setJob(String tJob)
/*     */   {
/* 214 */     this.Job = tJob;
/*     */   }
/*     */ 
/*     */   public String getJob() {
/* 218 */     return this.Job;
/*     */   }
/*     */ 
/*     */   public void setGDuty(String tGDuty)
/*     */   {
/* 223 */     this.GDuty = tGDuty;
/*     */   }
/*     */ 
/*     */   public String getGDuty() {
/* 227 */     return this.GDuty;
/*     */   }
/*     */ 
/*     */   public void setPolNo(String tPolNo)
/*     */   {
/* 232 */     this.PolNo = tPolNo;
/*     */   }
/*     */ 
/*     */   public String getPolNo() {
/* 236 */     return this.PolNo;
/*     */   }
/*     */ 
/*     */   public void setGrpPolNo(String tGrpPolNo) {
/* 240 */     this.GrpPolNo = tGrpPolNo;
/*     */   }
/*     */ 
/*     */   public String getGrpPolNo() {
/* 244 */     return this.GrpPolNo;
/*     */   }
/*     */ 
/*     */   public void setEdorNo(String tEdorNo) {
/* 248 */     this.EdorNo = tEdorNo;
/*     */   }
/*     */ 
/*     */   public String getEdorNo() {
/* 252 */     return this.EdorNo;
/*     */   }
/*     */ 
/*     */   public void setEdorType(String tEdorType) {
/* 256 */     this.EdorType = tEdorType;
/*     */   }
/*     */ 
/*     */   public String getEdorType() {
/* 260 */     return this.EdorType;
/*     */   }
/*     */ 
/*     */   public void setGetMoney(double tGetMoney) {
/* 264 */     this.GetMoney = tGetMoney;
/*     */   }
/*     */ 
/*     */   public String getGetMoney() {
/* 268 */     return String.valueOf(this.GetMoney);
/*     */   }
/*     */ 
/*     */   public void setCValiDate(String tCValiDate) {
/* 272 */     this.CValiDate = tCValiDate;
/*     */   }
/*     */ 
/*     */   public String getCValiDate() {
/* 276 */     return this.CValiDate;
/*     */   }
/*     */ 
/*     */   public void setEdorValiDate(String tEdorValiDate) {
/* 280 */     this.EdorValiDate = tEdorValiDate;
/*     */   }
/*     */ 
/*     */   public String getEdorValiDate() {
/* 284 */     return this.EdorValiDate;
/*     */   }
/*     */ 
/*     */   public void setGetStartDate(String tGetStartDate) {
/* 288 */     this.GetStartDate = tGetStartDate;
/*     */   }
/*     */ 
/*     */   public String getGetStartDate() {
/* 292 */     return this.GetStartDate;
/*     */   }
/*     */ 
/*     */   public void setGetBalance(double tGetBalance) {
/* 296 */     this.GetBalance = tGetBalance;
/*     */   }
/*     */ 
/*     */   public String getGetBalance() {
/* 300 */     return String.valueOf(this.GetBalance);
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String tRiskCode) {
/* 304 */     this.RiskCode = tRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRiskCode() {
/* 308 */     return this.RiskCode;
/*     */   }
/*     */ 
/*     */   public void setPayEndYearFlag(String tPayEndYearFlag) {
/* 312 */     this.PayEndYearFlag = tPayEndYearFlag;
/*     */   }
/*     */ 
/*     */   public String getPayEndYearFlag() {
/* 316 */     return this.PayEndYearFlag;
/*     */   }
/*     */ 
/*     */   public void setGetStartFlag(String tGetStartFlag) {
/* 320 */     this.GetStartFlag = tGetStartFlag;
/*     */   }
/*     */ 
/*     */   public String getGetStartFlag() {
/* 324 */     return this.GetStartFlag;
/*     */   }
/*     */ 
/*     */   public int getAppAgeType() {
/* 328 */     return this.AppAgeType;
/*     */   }
/*     */ 
/*     */   public void setAppAgeType(int appAgeType) {
/* 332 */     this.AppAgeType = appAgeType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.BqCalBase
 * JD-Core Version:    0.6.0
 */