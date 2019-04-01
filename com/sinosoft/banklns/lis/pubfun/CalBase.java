/*     */ package com.sinosoft.banklns.lis.pubfun;
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
/*     */   private int AppAgeType;
/*     */   private String Sex;
/*     */   private String Job;
/*     */   private String GDuty;
/*     */   private int Count;
/*     */   private int RnewFlag;
/*     */   private double AddRate;
/*     */   private String PolNo;
/*     */   private double Amnt;
/*     */   private double FloatRate;
/*     */   private String RiskCode;
/*     */   private String StandbyFlag1;
/*     */   private String StandbyFlag2;
/*     */   private String StandbyFlag3;
/*     */   private String GrpPolNo;
/*     */   private String EdorNo;
/*     */   private double GetLimit;
/*     */   private double GetRate;
/*     */   private String ContNo;
/*     */ 
/*     */   public void setPrem(double tPrem)
/*     */   {
/*  51 */     this.Prem = tPrem;
/*     */   }
/*     */ 
/*     */   public String getPrem() {
/*  55 */     return String.valueOf(this.Prem);
/*     */   }
/*     */ 
/*     */   public void setContNo(String tContNo) {
/*  59 */     this.ContNo = tContNo;
/*     */   }
/*     */ 
/*     */   public String getContNo() {
/*  63 */     return this.ContNo;
/*     */   }
/*     */ 
/*     */   public void setGet(double tGet) {
/*  67 */     this.Get = tGet;
/*     */   }
/*     */ 
/*     */   public String getGet() {
/*  71 */     return String.valueOf(this.Get);
/*     */   }
/*     */ 
/*     */   public void setAmnt(double tAmnt)
/*     */   {
/*  76 */     this.Amnt = tAmnt;
/*     */   }
/*     */ 
/*     */   public String getAmnt() {
/*  80 */     return String.valueOf(this.Amnt);
/*     */   }
/*     */ 
/*     */   public void setMult(double tMult)
/*     */   {
/*  85 */     this.Mult = tMult;
/*     */   }
/*     */ 
/*     */   public String getMult() {
/*  89 */     return String.valueOf(this.Mult);
/*     */   }
/*     */ 
/*     */   public void setFloatRate(double tFloatRate)
/*     */   {
/*  94 */     this.FloatRate = tFloatRate;
/*     */   }
/*     */ 
/*     */   public String getFloatRate() {
/*  98 */     return String.valueOf(this.FloatRate);
/*     */   }
/*     */ 
/*     */   public void setAddRate(double tAddRate)
/*     */   {
/* 103 */     this.AddRate = tAddRate;
/*     */   }
/*     */ 
/*     */   public String getAddRate() {
/* 107 */     return String.valueOf(this.AddRate);
/*     */   }
/*     */ 
/*     */   public void setPayIntv(int tPayIntv)
/*     */   {
/* 112 */     this.PayIntv = tPayIntv;
/*     */   }
/*     */ 
/*     */   public String getPayIntv() {
/* 116 */     return String.valueOf(this.PayIntv);
/*     */   }
/*     */ 
/*     */   public void setGetIntv(int tGetIntv)
/*     */   {
/* 121 */     this.GetIntv = tGetIntv;
/*     */   }
/*     */ 
/*     */   public String getGetIntv() {
/* 125 */     return String.valueOf(this.GetIntv);
/*     */   }
/*     */ 
/*     */   public void setPayEndYear(int tPayEndYear)
/*     */   {
/* 130 */     this.PayEndYear = tPayEndYear;
/*     */   }
/*     */ 
/*     */   public String getPayEndYear() {
/* 134 */     return String.valueOf(this.PayEndYear);
/*     */   }
/*     */ 
/*     */   public void setGetYear(int tGetYear)
/*     */   {
/* 139 */     this.GetYear = tGetYear;
/*     */   }
/*     */ 
/*     */   public String getGetYear() {
/* 143 */     return String.valueOf(this.GetYear);
/*     */   }
/*     */ 
/*     */   public void setYears(int tYears)
/*     */   {
/* 148 */     this.Years = tYears;
/*     */   }
/*     */ 
/*     */   public String getYears() {
/* 152 */     return String.valueOf(this.Years);
/*     */   }
/*     */ 
/*     */   public void setInsuYear(int tInsuYear)
/*     */   {
/* 157 */     this.InsuYear = tInsuYear;
/*     */   }
/*     */ 
/*     */   public String getInsuYear() {
/* 161 */     return String.valueOf(this.InsuYear);
/*     */   }
/*     */ 
/*     */   public void setAppAge(int tAppAge)
/*     */   {
/* 166 */     this.AppAge = tAppAge;
/*     */   }
/*     */ 
/*     */   public String getAppAge() {
/* 170 */     return String.valueOf(this.AppAge);
/*     */   }
/*     */ 
/*     */   public void setCount(int tCount)
/*     */   {
/* 175 */     this.Count = tCount;
/*     */   }
/*     */ 
/*     */   public String getCount() {
/* 179 */     return String.valueOf(this.Count);
/*     */   }
/*     */ 
/*     */   public void setRnewFlag(int tRnewFlag)
/*     */   {
/* 184 */     this.RnewFlag = tRnewFlag;
/*     */   }
/*     */ 
/*     */   public String getRnewFlag() {
/* 188 */     return String.valueOf(this.RnewFlag);
/*     */   }
/*     */ 
/*     */   public void setSex(String tSex)
/*     */   {
/* 193 */     this.Sex = tSex;
/*     */   }
/*     */ 
/*     */   public String getSex() {
/* 197 */     return this.Sex;
/*     */   }
/*     */ 
/*     */   public void setInsuYearFlag(String tInsuYearFlag)
/*     */   {
/* 202 */     this.InsuYearFlag = tInsuYearFlag;
/*     */   }
/*     */ 
/*     */   public String getInsuYearFlag() {
/* 206 */     return this.InsuYearFlag;
/*     */   }
/*     */ 
/*     */   public void setPayEndYearFlag(String tPayEndYearFlag)
/*     */   {
/* 211 */     this.PayEndYearFlag = tPayEndYearFlag;
/*     */   }
/*     */ 
/*     */   public String getPayEndYearFlag() {
/* 215 */     return this.PayEndYearFlag;
/*     */   }
/*     */ 
/*     */   public void setGetYearFlag(String tGetYearFlag)
/*     */   {
/* 220 */     this.GetYearFlag = tGetYearFlag;
/*     */   }
/*     */ 
/*     */   public String getGetYearFlag() {
/* 224 */     return this.GetYearFlag;
/*     */   }
/*     */ 
/*     */   public void setGetDutyKind(String tGetDutyKind)
/*     */   {
/* 229 */     this.GetDutyKind = tGetDutyKind;
/*     */   }
/*     */ 
/*     */   public String getGetDutyKind() {
/* 233 */     return this.GetDutyKind;
/*     */   }
/*     */ 
/*     */   public void setStartDateCalRef(String tStartDateCalRef)
/*     */   {
/* 238 */     this.StartDateCalRef = tStartDateCalRef;
/*     */   }
/*     */ 
/*     */   public String getStartDateCalRef() {
/* 242 */     return this.StartDateCalRef;
/*     */   }
/*     */ 
/*     */   public void setJob(String tJob)
/*     */   {
/* 247 */     this.Job = tJob;
/*     */   }
/*     */ 
/*     */   public String getJob() {
/* 251 */     return this.Job;
/*     */   }
/*     */ 
/*     */   public void setGDuty(String tGDuty)
/*     */   {
/* 256 */     this.GDuty = tGDuty;
/*     */   }
/*     */ 
/*     */   public String getGDuty() {
/* 260 */     return this.GDuty;
/*     */   }
/*     */ 
/*     */   public void setPolNo(String tPolNo)
/*     */   {
/* 265 */     this.PolNo = tPolNo;
/*     */   }
/*     */ 
/*     */   public String getPolNo() {
/* 269 */     return this.PolNo;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String tRiskCode)
/*     */   {
/* 274 */     this.RiskCode = tRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRiskCode() {
/* 278 */     return this.RiskCode;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag1(String tStandbyFlag1)
/*     */   {
/* 283 */     this.StandbyFlag1 = tStandbyFlag1;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag1() {
/* 287 */     return this.StandbyFlag1;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag2(String tStandbyFlag2)
/*     */   {
/* 292 */     this.StandbyFlag2 = tStandbyFlag2;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag2() {
/* 296 */     return this.StandbyFlag2;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag3(String tStandbyFlag3)
/*     */   {
/* 301 */     this.StandbyFlag3 = tStandbyFlag3;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag3() {
/* 305 */     return this.StandbyFlag3;
/*     */   }
/*     */ 
/*     */   public void setGrpPolNo(String tGrpPolNo)
/*     */   {
/* 310 */     this.GrpPolNo = tGrpPolNo;
/*     */   }
/*     */ 
/*     */   public String getGrpPolNo() {
/* 314 */     return this.GrpPolNo;
/*     */   }
/*     */ 
/*     */   public void setEdorNo(String tEdorNo)
/*     */   {
/* 319 */     this.EdorNo = tEdorNo;
/*     */   }
/*     */ 
/*     */   public String getEdorNo() {
/* 323 */     return this.EdorNo;
/*     */   }
/*     */ 
/*     */   public void setGetLimit(double tGetLimit)
/*     */   {
/* 328 */     this.GetLimit = tGetLimit;
/*     */   }
/*     */ 
/*     */   public String getGetLimit() {
/* 332 */     return String.valueOf(this.GetLimit);
/*     */   }
/*     */ 
/*     */   public void setGetRate(double tGetRate)
/*     */   {
/* 337 */     this.GetRate = tGetRate;
/*     */   }
/*     */ 
/*     */   public String getGetRate() {
/* 341 */     return String.valueOf(this.GetRate);
/*     */   }
/*     */ 
/*     */   public int getAppAgeType()
/*     */   {
/* 346 */     return this.AppAgeType;
/*     */   }
/*     */ 
/*     */   public void setAppAgeType(int appAgeType) {
/* 350 */     this.AppAgeType = appAgeType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.CalBase
 * JD-Core Version:    0.6.0
 */