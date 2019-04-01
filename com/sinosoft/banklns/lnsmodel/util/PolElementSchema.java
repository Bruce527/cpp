/*     */ package com.sinosoft.banklns.lnsmodel.util;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class PolElementSchema
/*     */   implements Cloneable
/*     */ {
/*  12 */   private FDate fDate = new FDate();
/*     */   private String GrpContNo;
/*     */   private String GrpPolNo;
/*     */   private String PrtNo;
/*     */   private String ContType;
/*     */   private String InsuredNo;
/*     */   private String InsuredId;
/*     */   private String Name;
/*     */   private String Sex;
/*     */   private String Birthday;
/*     */   private String OccupationCode;
/*     */   private String AppAgeType;
/*     */   private int AppAge;
/*     */   private String RelationToAppnt;
/*     */   private String InsuredNativePlace;
/*     */   private String InsuredNo2;
/*     */   private String AppAge2Type;
/*     */   private String AppAge2;
/*     */   private String AppntNo;
/*     */   private String AppntId;
/*     */   private String AppntNativePlace;
/*     */   private String AppntOccupationCode;
/*     */   private String AppntAgeType;
/*     */   private int AppntAge;
/*     */   private String AppntSex;
/*     */   private String AgentCode;
/*     */   private String RiskChannel;
/*     */   private String ManageCom;
/*     */   private String MainPolNo;
/*     */   private String MasterPolNo;
/*     */   private String MainPolAmnt;
/*     */   private String ContNo;
/*     */   private String DutyCode;
/*     */   private String RiskCode;
/*     */   private String PolNo;
/*     */   private double Amnt;
/*     */   private double Get;
/*     */   private double Mult;
/*     */   private double Prem;
/*     */   private double StandardPrem;
/*     */   private String VPU;
/*     */   private int PayEndYear;
/*     */   private String PayEndYearFlag;
/*     */   private int GetYear;
/*     */   private String GetYearFlag;
/*     */   private int InsuYear;
/*     */   private String InsuYearFlag;
/*     */   private int PayIntv;
/*     */   private int GetIntv;
/*     */   private int Years;
/*     */   private int PayYears;
/*     */   private String LiveGetMode;
/*     */   private String SubRiskFlag;
/*     */   private String BonusGetMode;
/*     */   private String StandbyFlag1;
/*     */   private String StandbyFlag2;
/*     */   private String StandbyFlag3;
/*     */   private double RiskAmnt;
/*     */   private double SumLifeRiskAmnt;
/*     */   private double SumAccRiskAmnt;
/*     */   private double SumDeaRiskAmnt;
/*     */   private double SumDeaDutyRiskAmnt;
/*     */   private double SumBodRiskAmnt;
/*     */   private Date MakeDate;
/*     */   private String MakeTime;
/*     */   private String ProposalContNo;
/*     */   private String ProposalNo;
/*     */   private String BranchType;
/*     */   private double TopUpPrem;
/*     */   private String DeadAmntType;
/*     */   private String PValiDate;
/*     */ 
/*     */   public String getPValiDate()
/*     */   {
/* 226 */     return this.PValiDate;
/*     */   }
/*     */   public void setPValiDate(String valiDate) {
/* 229 */     this.PValiDate = valiDate;
/*     */   }
/*     */   public String getAppAgeType() {
/* 232 */     return this.AppAgeType;
/*     */   }
/*     */   public void setAppAgeType(String appAgeType) {
/* 235 */     this.AppAgeType = appAgeType;
/*     */   }
/*     */   public String getAppAge2Type() {
/* 238 */     return this.AppAge2Type;
/*     */   }
/*     */   public void setAppAge2Type(String appAge2Type) {
/* 241 */     this.AppAge2Type = appAge2Type;
/*     */   }
/*     */   public String getAppntAgeType() {
/* 244 */     return this.AppntAgeType;
/*     */   }
/*     */   public void setAppntAgeType(String appntAgeType) {
/* 247 */     this.AppntAgeType = appntAgeType;
/*     */   }
/*     */   public double getTopUpPrem() {
/* 250 */     return this.TopUpPrem;
/*     */   }
/*     */   public void setTopUpPrem(double topUpPrem) {
/* 253 */     this.TopUpPrem = topUpPrem;
/*     */   }
/*     */ 
/*     */   public String getDeadAmntType() {
/* 257 */     return this.DeadAmntType;
/*     */   }
/*     */   public void setDeadAmntType(String deadAmntType) {
/* 260 */     this.DeadAmntType = deadAmntType;
/*     */   }
/*     */   public String getBranchType() {
/* 263 */     return this.BranchType;
/*     */   }
/*     */   public void setBranchType(String branchType) {
/* 266 */     this.BranchType = branchType;
/*     */   }
/*     */   public String getInsuredId() {
/* 269 */     return this.InsuredId;
/*     */   }
/*     */   public void setInsuredId(String insuredId) {
/* 272 */     this.InsuredId = insuredId;
/*     */   }
/*     */   public String getAppntId() {
/* 275 */     return this.AppntId;
/*     */   }
/*     */   public void setAppntId(String appntId) {
/* 278 */     this.AppntId = appntId;
/*     */   }
/*     */   public String getGrpContNo() {
/* 281 */     return this.GrpContNo;
/*     */   }
/*     */   public void setGrpContNo(String grpContNo) {
/* 284 */     this.GrpContNo = grpContNo;
/*     */   }
/*     */   public String getGrpPolNo() {
/* 287 */     return this.GrpPolNo;
/*     */   }
/*     */   public void setGrpPolNo(String grpPolNo) {
/* 290 */     this.GrpPolNo = grpPolNo;
/*     */   }
/*     */   public String getPrtNo() {
/* 293 */     return this.PrtNo;
/*     */   }
/*     */   public void setPrtNo(String prtNo) {
/* 296 */     this.PrtNo = prtNo;
/*     */   }
/*     */   public String getContType() {
/* 299 */     return this.ContType;
/*     */   }
/*     */   public void setContType(String contType) {
/* 302 */     this.ContType = contType;
/*     */   }
/*     */   public String getMasterPolNo() {
/* 305 */     return this.MasterPolNo;
/*     */   }
/*     */   public void setMasterPolNo(String masterPolNo) {
/* 308 */     this.MasterPolNo = masterPolNo;
/*     */   }
/*     */   public String getProposalContNo() {
/* 311 */     return this.ProposalContNo;
/*     */   }
/*     */   public void setProposalContNo(String proposalContNo) {
/* 314 */     this.ProposalContNo = proposalContNo;
/*     */   }
/*     */   public String getProposalNo() {
/* 317 */     return this.ProposalNo;
/*     */   }
/*     */   public void setProposalNo(String proposalNo) {
/* 320 */     this.ProposalNo = proposalNo;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 324 */     if (this.MakeDate != null) {
/* 325 */       return this.fDate.getString(this.MakeDate);
/*     */     }
/* 327 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 331 */     this.MakeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 335 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 337 */       this.MakeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 340 */       this.MakeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 345 */     return this.MakeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 349 */     this.MakeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public double getAmnt() {
/* 353 */     return this.Amnt;
/*     */   }
/*     */ 
/*     */   public void setAmnt(double amnt) {
/* 357 */     this.Amnt = amnt;
/*     */   }
/*     */ 
/*     */   public int getAppAge() {
/* 361 */     return this.AppAge;
/*     */   }
/*     */ 
/*     */   public void setAppAge(int appAge) {
/* 365 */     this.AppAge = appAge;
/*     */   }
/*     */ 
/*     */   public String getAppAge2() {
/* 369 */     return this.AppAge2;
/*     */   }
/*     */ 
/*     */   public void setAppAge2(String appAge2) {
/* 373 */     this.AppAge2 = appAge2;
/*     */   }
/*     */ 
/*     */   public int getAppntAge() {
/* 377 */     return this.AppntAge;
/*     */   }
/*     */ 
/*     */   public void setAppntAge(int appntAge) {
/* 381 */     this.AppntAge = appntAge;
/*     */   }
/*     */ 
/*     */   public String getAppntNativePlace() {
/* 385 */     return this.AppntNativePlace;
/*     */   }
/*     */ 
/*     */   public void setAppntNativePlace(String appntNativePlace) {
/* 389 */     this.AppntNativePlace = appntNativePlace;
/*     */   }
/*     */ 
/*     */   public String getAppntNo() {
/* 393 */     return this.AppntNo;
/*     */   }
/*     */ 
/*     */   public void setAppntNo(String appntNo) {
/* 397 */     this.AppntNo = appntNo;
/*     */   }
/*     */ 
/*     */   public String getAppntOccupationCode() {
/* 401 */     return this.AppntOccupationCode;
/*     */   }
/*     */ 
/*     */   public void setAppntOccupationCode(String appntOccupationCode) {
/* 405 */     this.AppntOccupationCode = appntOccupationCode;
/*     */   }
/*     */ 
/*     */   public String getBirthday() {
/* 409 */     return this.Birthday;
/*     */   }
/*     */ 
/*     */   public void setBirthday(String birthday) {
/* 413 */     this.Birthday = birthday;
/*     */   }
/*     */ 
/*     */   public String getBonusGetMode() {
/* 417 */     return this.BonusGetMode;
/*     */   }
/*     */ 
/*     */   public void setBonusGetMode(String bonusGetMode) {
/* 421 */     this.BonusGetMode = bonusGetMode;
/*     */   }
/*     */ 
/*     */   public String getContNo() {
/* 425 */     return this.ContNo;
/*     */   }
/*     */ 
/*     */   public void setContNo(String contNo) {
/* 429 */     this.ContNo = contNo;
/*     */   }
/*     */ 
/*     */   public String getDutyCode() {
/* 433 */     return this.DutyCode;
/*     */   }
/*     */ 
/*     */   public void setDutyCode(String dutyCode) {
/* 437 */     this.DutyCode = dutyCode;
/*     */   }
/*     */ 
/*     */   public double getGet() {
/* 441 */     return this.Get;
/*     */   }
/*     */ 
/*     */   public void setGet(double get) {
/* 445 */     this.Get = get;
/*     */   }
/*     */ 
/*     */   public int getGetIntv() {
/* 449 */     return this.GetIntv;
/*     */   }
/*     */ 
/*     */   public void setGetIntv(int getIntv) {
/* 453 */     this.GetIntv = getIntv;
/*     */   }
/*     */ 
/*     */   public int getGetYear() {
/* 457 */     return this.GetYear;
/*     */   }
/*     */ 
/*     */   public void setGetYear(int getYear) {
/* 461 */     this.GetYear = getYear;
/*     */   }
/*     */ 
/*     */   public String getGetYearFlag() {
/* 465 */     return this.GetYearFlag;
/*     */   }
/*     */ 
/*     */   public void setGetYearFlag(String getYearFlag) {
/* 469 */     this.GetYearFlag = getYearFlag;
/*     */   }
/*     */ 
/*     */   public String getInsuredNativePlace() {
/* 473 */     return this.InsuredNativePlace;
/*     */   }
/*     */ 
/*     */   public void setInsuredNativePlace(String insuredNativePlace) {
/* 477 */     this.InsuredNativePlace = insuredNativePlace;
/*     */   }
/*     */ 
/*     */   public String getInsuredNo() {
/* 481 */     return this.InsuredNo;
/*     */   }
/*     */ 
/*     */   public void setInsuredNo(String insuredNo) {
/* 485 */     this.InsuredNo = insuredNo;
/*     */   }
/*     */ 
/*     */   public String getInsuredNo2() {
/* 489 */     return this.InsuredNo2;
/*     */   }
/*     */ 
/*     */   public void setInsuredNo2(String insuredNo2) {
/* 493 */     this.InsuredNo2 = insuredNo2;
/*     */   }
/*     */ 
/*     */   public int getInsuYear() {
/* 497 */     return this.InsuYear;
/*     */   }
/*     */ 
/*     */   public void setInsuYear(int insuYear) {
/* 501 */     this.InsuYear = insuYear;
/*     */   }
/*     */ 
/*     */   public String getInsuYearFlag() {
/* 505 */     return this.InsuYearFlag;
/*     */   }
/*     */ 
/*     */   public void setInsuYearFlag(String insuYearFlag) {
/* 509 */     this.InsuYearFlag = insuYearFlag;
/*     */   }
/*     */ 
/*     */   public String getLiveGetMode() {
/* 513 */     return this.LiveGetMode;
/*     */   }
/*     */ 
/*     */   public void setLiveGetMode(String liveGetMode) {
/* 517 */     this.LiveGetMode = liveGetMode;
/*     */   }
/*     */ 
/*     */   public String getMainPolAmnt() {
/* 521 */     return this.MainPolAmnt;
/*     */   }
/*     */ 
/*     */   public void setMainPolAmnt(String mainPolAmnt) {
/* 525 */     this.MainPolAmnt = mainPolAmnt;
/*     */   }
/*     */ 
/*     */   public String getMainPolNo() {
/* 529 */     return this.MainPolNo;
/*     */   }
/*     */ 
/*     */   public void setMainPolNo(String mainPolNo) {
/* 533 */     this.MainPolNo = mainPolNo;
/*     */   }
/*     */ 
/*     */   public String getManageCom() {
/* 537 */     return this.ManageCom;
/*     */   }
/*     */ 
/*     */   public void setManageCom(String manageCom) {
/* 541 */     this.ManageCom = manageCom;
/*     */   }
/*     */ 
/*     */   public double getMult() {
/* 545 */     return this.Mult;
/*     */   }
/*     */ 
/*     */   public void setMult(double mult) {
/* 549 */     this.Mult = mult;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 553 */     return this.Name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 557 */     this.Name = name;
/*     */   }
/*     */ 
/*     */   public String getOccupationCode() {
/* 561 */     return this.OccupationCode;
/*     */   }
/*     */ 
/*     */   public void setOccupationCode(String occupationCode) {
/* 565 */     this.OccupationCode = occupationCode;
/*     */   }
/*     */ 
/*     */   public int getPayEndYear() {
/* 569 */     return this.PayEndYear;
/*     */   }
/*     */ 
/*     */   public void setPayEndYear(int payEndYear) {
/* 573 */     this.PayEndYear = payEndYear;
/*     */   }
/*     */ 
/*     */   public String getPayEndYearFlag() {
/* 577 */     return this.PayEndYearFlag;
/*     */   }
/*     */ 
/*     */   public void setPayEndYearFlag(String payEndYearFlag) {
/* 581 */     this.PayEndYearFlag = payEndYearFlag;
/*     */   }
/*     */ 
/*     */   public int getPayIntv() {
/* 585 */     return this.PayIntv;
/*     */   }
/*     */ 
/*     */   public void setPayIntv(int payIntv) {
/* 589 */     this.PayIntv = payIntv;
/*     */   }
/*     */ 
/*     */   public int getPayYears() {
/* 593 */     return this.PayYears;
/*     */   }
/*     */ 
/*     */   public void setPayYears(int payYears) {
/* 597 */     this.PayYears = payYears;
/*     */   }
/*     */ 
/*     */   public String getPolNo() {
/* 601 */     return this.PolNo;
/*     */   }
/*     */ 
/*     */   public void setPolNo(String polNo) {
/* 605 */     this.PolNo = polNo;
/*     */   }
/*     */ 
/*     */   public double getPrem() {
/* 609 */     return this.Prem;
/*     */   }
/*     */ 
/*     */   public void setPrem(double prem) {
/* 613 */     this.Prem = prem;
/*     */   }
/*     */ 
/*     */   public String getRelationToAppnt() {
/* 617 */     return this.RelationToAppnt;
/*     */   }
/*     */ 
/*     */   public void setRelationToAppnt(String relationToAppnt) {
/* 621 */     this.RelationToAppnt = relationToAppnt;
/*     */   }
/*     */ 
/*     */   public double getRiskAmnt() {
/* 625 */     return this.RiskAmnt;
/*     */   }
/*     */ 
/*     */   public void setRiskAmnt(double riskAmnt) {
/* 629 */     this.RiskAmnt = riskAmnt;
/*     */   }
/*     */ 
/*     */   public String getRiskChannel() {
/* 633 */     return this.RiskChannel;
/*     */   }
/*     */ 
/*     */   public void setRiskChannel(String riskChannel) {
/* 637 */     this.RiskChannel = riskChannel;
/*     */   }
/*     */ 
/*     */   public String getRiskCode() {
/* 641 */     return this.RiskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String riskCode) {
/* 645 */     this.RiskCode = riskCode;
/*     */   }
/*     */ 
/*     */   public String getSex() {
/* 649 */     return this.Sex;
/*     */   }
/*     */ 
/*     */   public void setSex(String sex) {
/* 653 */     this.Sex = sex;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag1() {
/* 657 */     return this.StandbyFlag1;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag1(String standbyFlag1) {
/* 661 */     this.StandbyFlag1 = standbyFlag1;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag2() {
/* 665 */     return this.StandbyFlag2;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag2(String standbyFlag2) {
/* 669 */     this.StandbyFlag2 = standbyFlag2;
/*     */   }
/*     */ 
/*     */   public String getStandbyFlag3() {
/* 673 */     return this.StandbyFlag3;
/*     */   }
/*     */ 
/*     */   public void setStandbyFlag3(String standbyFlag3) {
/* 677 */     this.StandbyFlag3 = standbyFlag3;
/*     */   }
/*     */ 
/*     */   public String getSubRiskFlag() {
/* 681 */     return this.SubRiskFlag;
/*     */   }
/*     */ 
/*     */   public void setSubRiskFlag(String subRiskFlag) {
/* 685 */     this.SubRiskFlag = subRiskFlag;
/*     */   }
/*     */ 
/*     */   public double getSumAccRiskAmnt() {
/* 689 */     return this.SumAccRiskAmnt;
/*     */   }
/*     */ 
/*     */   public void setSumAccRiskAmnt(double sumAccRiskAmnt) {
/* 693 */     this.SumAccRiskAmnt = sumAccRiskAmnt;
/*     */   }
/*     */ 
/*     */   public double getSumBodRiskAmnt() {
/* 697 */     return this.SumBodRiskAmnt;
/*     */   }
/*     */ 
/*     */   public void setSumBodRiskAmnt(double sumBodRiskAmnt) {
/* 701 */     this.SumBodRiskAmnt = sumBodRiskAmnt;
/*     */   }
/*     */ 
/*     */   public double getSumDeaRiskAmnt() {
/* 705 */     return this.SumDeaRiskAmnt;
/*     */   }
/*     */ 
/*     */   public void setSumDeaRiskAmnt(double sumDeaRiskAmnt) {
/* 709 */     this.SumDeaRiskAmnt = sumDeaRiskAmnt;
/*     */   }
/*     */ 
/*     */   public double getSumLifeRiskAmnt() {
/* 713 */     return this.SumLifeRiskAmnt;
/*     */   }
/*     */ 
/*     */   public void setSumLifeRiskAmnt(double sumLifeRiskAmnt) {
/* 717 */     this.SumLifeRiskAmnt = sumLifeRiskAmnt;
/*     */   }
/*     */ 
/*     */   public String getVPU() {
/* 721 */     return this.VPU;
/*     */   }
/*     */ 
/*     */   public void setVPU(String vpu) {
/* 725 */     this.VPU = vpu;
/*     */   }
/*     */ 
/*     */   public int getYears() {
/* 729 */     return this.Years;
/*     */   }
/*     */ 
/*     */   public void setYears(int years) {
/* 733 */     this.Years = years;
/*     */   }
/*     */ 
/*     */   public String getAgentCode() {
/* 737 */     return this.AgentCode;
/*     */   }
/*     */ 
/*     */   public void setAgentCode(String agentCode) {
/* 741 */     this.AgentCode = agentCode;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */   {
/* 747 */     PolElementSchema cloned = null;
/*     */     try {
/* 749 */       cloned = (PolElementSchema)super.clone();
/*     */     } catch (Exception e) {
/* 751 */       e.printStackTrace();
/*     */     }
/* 753 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String getAppntSex() {
/* 757 */     return this.AppntSex;
/*     */   }
/*     */ 
/*     */   public void setAppntSex(String appntSex) {
/* 761 */     this.AppntSex = appntSex;
/*     */   }
/*     */ 
/*     */   public double getStandardPrem() {
/* 765 */     return this.StandardPrem;
/*     */   }
/*     */ 
/*     */   public void setStandardPrem(double standardPrem) {
/* 769 */     this.StandardPrem = standardPrem;
/*     */   }
/*     */ 
/*     */   public double getSumDeaDutyRiskAmnt() {
/* 773 */     return this.SumDeaDutyRiskAmnt;
/*     */   }
/*     */ 
/*     */   public void setSumDeaDutyRiskAmnt(double sumDeaDutyRiskAmnt) {
/* 777 */     this.SumDeaDutyRiskAmnt = sumDeaDutyRiskAmnt;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.util.PolElementSchema
 * JD-Core Version:    0.6.0
 */