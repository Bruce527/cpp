/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ public class CheckBase
/*     */ {
/*     */   private double Prem;
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
/*     */   private String OccupationType;
/*     */   private String GDuty;
/*     */   private String MainPolNo;
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
/*     */   private String LiveGetMode;
/*     */   private String CValiDate;
/*     */   private String DutyCode;
/*     */   private String BonusGetMode;
/*     */ 
/*     */   public String getBonusGetMode()
/*     */   {
/*  90 */     return this.BonusGetMode;
/*     */   }
/*     */ 
/*     */   public void setBonusGetMode(String bonusGetMode)
/*     */   {
/*  95 */     this.BonusGetMode = bonusGetMode;
/*     */   }
/*     */ 
/*     */   public int getAppAgeType() {
/*  99 */     return this.AppAgeType;
/*     */   }
/*     */ 
/*     */   public void setAppAgeType(int appAgeType) {
/* 103 */     this.AppAgeType = appAgeType;
/*     */   }
/*     */ 
/*     */   public String getDutyCode()
/*     */   {
/* 108 */     return this.DutyCode;
/*     */   }
/*     */ 
/*     */   public void setDutyCode(String dutyCode)
/*     */   {
/* 113 */     this.DutyCode = dutyCode;
/*     */   }
/*     */ 
/*     */   public void setPrem(double tPrem)
/*     */   {
/* 122 */     this.Prem = tPrem;
/*     */   }
/*     */ 
/*     */   public String getCValiDate() {
/* 126 */     return String.valueOf(this.CValiDate);
/*     */   }
/*     */ 
/*     */   public void setCValiDate(String CValiDate) {
/* 130 */     CValiDate = CValiDate;
/*     */   }
/*     */ 
/*     */   public String getPrem() {
/* 134 */     return String.valueOf(this.Prem);
/*     */   }
/*     */ 
/*     */   public void setContNo(String tContNo) {
/* 138 */     this.ContNo = tContNo;
/*     */   }
/*     */ 
/*     */   public String getContNo() {
/* 142 */     return this.ContNo;
/*     */   }
/*     */ 
/*     */   public void setLiveGetMode(String LiveGetMode) {
/* 146 */     LiveGetMode = LiveGetMode;
/*     */   }
/*     */ 
/*     */   public String getLiveGetMode() {
/* 150 */     return this.LiveGetMode;
/*     */   }
/*     */ 
/*     */   public void setAmnt(double tAmnt)
/*     */   {
/* 163 */     this.Amnt = tAmnt;
/*     */   }
/*     */ 
/*     */   public String getAmnt() {
/* 167 */     return String.valueOf(this.Amnt);
/*     */   }
/*     */ 
/*     */   public void setMult(double tMult) {
/* 171 */     this.Mult = tMult;
/*     */   }
/*     */ 
/*     */   public String getMult() {
/* 175 */     return String.valueOf(this.Mult);
/*     */   }
/*     */ 
/*     */   public void setFloatRate(double tFloatRate) {
/* 179 */     this.FloatRate = tFloatRate;
/*     */   }
/*     */ 
/*     */   public String getFloatRate() {
/* 183 */     return String.valueOf(this.FloatRate);
/*     */   }
/*     */ 
/*     */   public void setAddRate(double tAddRate) {
/* 187 */     this.AddRate = tAddRate;
/*     */   }
/*     */ 
/*     */   public String getAddRate() {
/* 191 */     return String.valueOf(this.AddRate);
/*     */   }
/*     */ 
/*     */   public void setPayIntv(int tPayIntv) {
/* 195 */     this.PayIntv = tPayIntv;
/*     */   }
/*     */ 
/*     */   public String getPayIntv() {
/* 199 */     return String.valueOf(this.PayIntv);
/*     */   }
/*     */ 
/*     */   public void setGetIntv(int tGetIntv) {
/* 203 */     this.GetIntv = tGetIntv;
/*     */   }
/*     */ 
/*     */   public String getGetIntv() {
/* 207 */     return String.valueOf(this.GetIntv);
/*     */   }
/*     */ 
/*     */   public void setPayEndYear(int tPayEndYear) {
/* 211 */     this.PayEndYear = tPayEndYear;
/*     */   }
/*     */ 
/*     */   public String getPayEndYear() {
/* 215 */     return String.valueOf(this.PayEndYear);
/*     */   }
/*     */ 
/*     */   public void setGetYear(int tGetYear) {
/* 219 */     this.GetYear = tGetYear;
/*     */   }
/*     */ 
/*     */   public String getGetYear() {
/* 223 */     return String.valueOf(this.GetYear);
/*     */   }
/*     */ 
/*     */   public void setYears(int tYears) {
/* 227 */     this.Years = tYears;
/*     */   }
/*     */ 
/*     */   public String getYears() {
/* 231 */     return String.valueOf(this.Years);
/*     */   }
/*     */ 
/*     */   public void setInsuYear(int tInsuYear) {
/* 235 */     this.InsuYear = tInsuYear;
/*     */   }
/*     */ 
/*     */   public String getInsuYear() {
/* 239 */     return String.valueOf(this.InsuYear);
/*     */   }
/*     */ 
/*     */   public void setAppAge(int tAppAge) {
/* 243 */     this.AppAge = tAppAge;
/*     */   }
/*     */ 
/*     */   public String getAppAge() {
/* 247 */     return String.valueOf(this.AppAge);
/*     */   }
/*     */ 
/*     */   public void setCount(int tCount) {
/* 251 */     this.Count = tCount;
/*     */   }
/*     */ 
/*     */   public String getCount() {
/* 255 */     return String.valueOf(this.Count);
/*     */   }
/*     */ 
/*     */   public void setRnewFlag(int tRnewFlag) {
/* 259 */     this.RnewFlag = tRnewFlag;
/*     */   }
/*     */ 
/*     */   public String getRnewFlag() {
/* 263 */     return String.valueOf(this.RnewFlag);
/*     */   }
/*     */ 
/*     */   public void setSex(String tSex) {
/* 267 */     this.Sex = tSex;
/*     */   }
/*     */ 
/*     */   public String getSex() {
/* 271 */     return this.Sex;
/*     */   }
/*     */ 
/*     */   public void setInsuYearFlag(String tInsuYearFlag) {
/* 275 */     this.InsuYearFlag = tInsuYearFlag;
/*     */   }
/*     */ 
/*     */   public String getInsuYearFlag() {
/* 279 */     return this.InsuYearFlag;
/*     */   }
/*     */ 
/*     */   public void setPayEndYearFlag(String tPayEndYearFlag) {
/* 283 */     this.PayEndYearFlag = tPayEndYearFlag;
/*     */   }
/*     */ 
/*     */   public String getPayEndYearFlag() {
/* 287 */     return this.PayEndYearFlag;
/*     */   }
/*     */ 
/*     */   public void setGetYearFlag(String tGetYearFlag) {
/* 291 */     this.GetYearFlag = tGetYearFlag;
/*     */   }
/*     */ 
/*     */   public String getGetYearFlag() {
/* 295 */     return this.GetYearFlag;
/*     */   }
/*     */ 
/*     */   public void setGetDutyKind(String tGetDutyKind) {
/* 299 */     this.GetDutyKind = tGetDutyKind;
/*     */   }
/*     */ 
/*     */   public String getGetDutyKind() {
/* 303 */     return this.GetDutyKind;
/*     */   }
/*     */ 
/*     */   public void setStartDateCalRef(String tStartDateCalRef) {
/* 307 */     this.StartDateCalRef = tStartDateCalRef;
/*     */   }
/*     */ 
/*     */   public String getStartDateCalRef() {
/* 311 */     return this.StartDateCalRef;
/*     */   }
/*     */ 
/*     */   public void setOccupationType(String tOccupationType) {
/* 315 */     this.OccupationType = tOccupationType;
/*     */   }
/*     */ 
/*     */   public String getOccupationType() {
/* 319 */     return this.OccupationType;
/*     */   }
/*     */ 
/*     */   public void setGDuty(String tGDuty) {
/* 323 */     this.GDuty = tGDuty;
/*     */   }
/*     */ 
/*     */   public String getGDuty() {
/* 327 */     return this.GDuty;
/*     */   }
/*     */ 
/*     */   public void setPolNo(String tPolNo) {
/* 331 */     this.PolNo = tPolNo;
/*     */   }
/*     */ 
/*     */   public String getPolNo() {
/* 335 */     return this.PolNo;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String tRiskCode) {
/* 339 */     this.RiskCode = tRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRiskCode() {
/* 343 */     return this.RiskCode;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag1(String tStandbyFlag1) {
/* 347 */     this.StandbyFlag1 = tStandbyFlag1;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag1() {
/* 351 */     return this.StandbyFlag1;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag2(String tStandbyFlag2) {
/* 355 */     this.StandbyFlag2 = tStandbyFlag2;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag2() {
/* 359 */     return this.StandbyFlag2;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag3(String tStandbyFlag3) {
/* 363 */     this.StandbyFlag3 = tStandbyFlag3;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag3() {
/* 367 */     return this.StandbyFlag3;
/*     */   }
/*     */ 
/*     */   public void setGrpPolNo(String tGrpPolNo) {
/* 371 */     this.GrpPolNo = tGrpPolNo;
/*     */   }
/*     */ 
/*     */   public String getGrpPolNo() {
/* 375 */     return this.GrpPolNo;
/*     */   }
/*     */ 
/*     */   public void setEdorNo(String tEdorNo) {
/* 379 */     this.EdorNo = tEdorNo;
/*     */   }
/*     */ 
/*     */   public String getEdorNo() {
/* 383 */     return this.EdorNo;
/*     */   }
/*     */ 
/*     */   public void setGetLimit(double tGetLimit)
/*     */   {
/* 388 */     this.GetLimit = tGetLimit;
/*     */   }
/*     */ 
/*     */   public String getGetLimit() {
/* 392 */     return String.valueOf(this.GetLimit);
/*     */   }
/*     */ 
/*     */   public void setGetRate(double tGetRate) {
/* 396 */     this.GetRate = tGetRate;
/*     */   }
/*     */ 
/*     */   public String getGetRate() {
/* 400 */     return String.valueOf(this.GetRate);
/*     */   }
/*     */ 
/*     */   public String getMainPolNo()
/*     */   {
/* 406 */     return this.MainPolNo;
/*     */   }
/*     */ 
/*     */   public void setMainPolNo(String mainPolNo) {
/* 410 */     this.MainPolNo = mainPolNo;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.CheckBase
 * JD-Core Version:    0.6.0
 */