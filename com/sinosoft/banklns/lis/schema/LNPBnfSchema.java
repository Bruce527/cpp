/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPBnfDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class LNPBnfSchema
/*      */   implements Schema
/*      */ {
/*      */   private String ContNo;
/*      */   private String PolNo;
/*      */   private String InsuredNo;
/*      */   private String InsuredId;
/*      */   private String BenefitType;
/*      */   private int BnfOrder;
/*      */   private String BnfGrade;
/*      */   private double BenefitRate;
/*      */   private String BenefitOrder;
/*      */   private String BnfNo;
/*      */   private String BnfId;
/*      */   private String Appellation;
/*      */   private String BnfName;
/*      */   private String BnfSex;
/*      */   private String BnfBirthday;
/*      */   private int BnfAge;
/*      */   private String RelationToInsured;
/*      */   private String AddressNo;
/*      */   private String IDType;
/*      */   private String IDNo;
/*      */   private String IDValidity;
/*      */   private String IDPerpetual;
/*      */   private String NativePlace;
/*      */   private String Nationality;
/*      */   private String RgtAddress;
/*      */   private String Marriage;
/*      */   private String MarriageDate;
/*      */   private String Health;
/*      */   private double Stature;
/*      */   private double Avoirdupois;
/*      */   private String Degree;
/*      */   private String CreditGrade;
/*      */   private String BankCode;
/*      */   private String BankAccNo;
/*      */   private String AccName;
/*      */   private String JoinCompanyDate;
/*      */   private String StartWorkDate;
/*      */   private String Position;
/*      */   private double Salary;
/*      */   private String OccupationType;
/*      */   private String OccupationCode;
/*      */   private String WorkType;
/*      */   private String PluralityType;
/*      */   private String SmokeFlag;
/*      */   private String BnfFlag;
/*      */   private String Operator;
/*      */   private String ManageCom;
/*      */   private String MakeDate;
/*      */   private String MakeTime;
/*      */   private String ModifyDate;
/*      */   private String ModifyTime;
/*      */   private String newbnfname;
/*      */   private String newbnfbirthday;
/*      */   public static final int FIELDNUM = 53;
/*      */   private static String[] PK;
/*  137 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPBnfSchema()
/*      */   {
/*  144 */     this.mErrors = new CErrors();
/*      */ 
/*  146 */     String[] pk = new String[5];
/*  147 */     pk[0] = "ContNo";
/*  148 */     pk[1] = "InsuredId";
/*  149 */     pk[2] = "BenefitType";
/*  150 */     pk[3] = "BnfOrder";
/*  151 */     pk[4] = "BnfId";
/*      */ 
/*  153 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  159 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getContNo()
/*      */   {
/*  164 */     if (this.ContNo != null) this.ContNo.equals("");
/*      */ 
/*  168 */     return this.ContNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  172 */     this.ContNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getPolNo() {
/*  176 */     if (this.PolNo != null) this.PolNo.equals("");
/*      */ 
/*  180 */     return this.PolNo;
/*      */   }
/*      */ 
/*      */   public void setPolNo(String aPolNo) {
/*  184 */     this.PolNo = aPolNo;
/*      */   }
/*      */ 
/*      */   public String getInsuredNo() {
/*  188 */     if (this.InsuredNo != null) this.InsuredNo.equals("");
/*      */ 
/*  192 */     return this.InsuredNo;
/*      */   }
/*      */ 
/*      */   public void setInsuredNo(String aInsuredNo) {
/*  196 */     this.InsuredNo = aInsuredNo;
/*      */   }
/*      */ 
/*      */   public String getInsuredId() {
/*  200 */     if (this.InsuredId != null) this.InsuredId.equals("");
/*      */ 
/*  204 */     return this.InsuredId;
/*      */   }
/*      */ 
/*      */   public void setInsuredId(String aInsuredId) {
/*  208 */     this.InsuredId = aInsuredId;
/*      */   }
/*      */ 
/*      */   public String getBenefitType() {
/*  212 */     if (this.BenefitType != null) this.BenefitType.equals("");
/*      */ 
/*  216 */     return this.BenefitType;
/*      */   }
/*      */ 
/*      */   public void setBenefitType(String aBenefitType) {
/*  220 */     this.BenefitType = aBenefitType;
/*      */   }
/*      */ 
/*      */   public int getBnfOrder() {
/*  224 */     return this.BnfOrder;
/*      */   }
/*      */ 
/*      */   public void setBnfOrder(int aBnfOrder) {
/*  228 */     this.BnfOrder = aBnfOrder;
/*      */   }
/*      */ 
/*      */   public void setBnfOrder(String aBnfOrder) {
/*  232 */     if ((aBnfOrder != null) && (!aBnfOrder.equals("")))
/*      */     {
/*  234 */       Integer tInteger = new Integer(aBnfOrder);
/*  235 */       int i = tInteger.intValue();
/*  236 */       this.BnfOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getBnfGrade()
/*      */   {
/*  242 */     if (this.BnfGrade != null) this.BnfGrade.equals("");
/*      */ 
/*  246 */     return this.BnfGrade;
/*      */   }
/*      */ 
/*      */   public void setBnfGrade(String aBnfGrade) {
/*  250 */     this.BnfGrade = aBnfGrade;
/*      */   }
/*      */ 
/*      */   public double getBenefitRate() {
/*  254 */     return this.BenefitRate;
/*      */   }
/*      */ 
/*      */   public void setBenefitRate(double aBenefitRate) {
/*  258 */     this.BenefitRate = aBenefitRate;
/*      */   }
/*      */ 
/*      */   public void setBenefitRate(String aBenefitRate) {
/*  262 */     if ((aBenefitRate != null) && (!aBenefitRate.equals("")))
/*      */     {
/*  264 */       Double tDouble = new Double(aBenefitRate);
/*  265 */       double d = tDouble.doubleValue();
/*  266 */       this.BenefitRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getBenefitOrder()
/*      */   {
/*  272 */     if (this.BenefitOrder != null) this.BenefitOrder.equals("");
/*      */ 
/*  276 */     return this.BenefitOrder;
/*      */   }
/*      */ 
/*      */   public void setBenefitOrder(String aBenefitOrder) {
/*  280 */     this.BenefitOrder = aBenefitOrder;
/*      */   }
/*      */ 
/*      */   public String getBnfNo() {
/*  284 */     if (this.BnfNo != null) this.BnfNo.equals("");
/*      */ 
/*  288 */     return this.BnfNo;
/*      */   }
/*      */ 
/*      */   public void setBnfNo(String aBnfNo) {
/*  292 */     this.BnfNo = aBnfNo;
/*      */   }
/*      */ 
/*      */   public String getBnfId() {
/*  296 */     if (this.BnfId != null) this.BnfId.equals("");
/*      */ 
/*  300 */     return this.BnfId;
/*      */   }
/*      */ 
/*      */   public void setBnfId(String aBnfId) {
/*  304 */     this.BnfId = aBnfId;
/*      */   }
/*      */ 
/*      */   public String getAppellation() {
/*  308 */     if (this.Appellation != null) this.Appellation.equals("");
/*      */ 
/*  312 */     return this.Appellation;
/*      */   }
/*      */ 
/*      */   public void setAppellation(String aAppellation) {
/*  316 */     this.Appellation = aAppellation;
/*      */   }
/*      */ 
/*      */   public String getBnfName() {
/*  320 */     if (this.BnfName != null) this.BnfName.equals("");
/*      */ 
/*  324 */     return this.BnfName;
/*      */   }
/*      */ 
/*      */   public void setBnfName(String aBnfName) {
/*  328 */     this.BnfName = aBnfName;
/*      */   }
/*      */ 
/*      */   public String getBnfSex() {
/*  332 */     if (this.BnfSex != null) this.BnfSex.equals("");
/*      */ 
/*  336 */     return this.BnfSex;
/*      */   }
/*      */ 
/*      */   public void setBnfSex(String aBnfSex) {
/*  340 */     this.BnfSex = aBnfSex;
/*      */   }
/*      */ 
/*      */   public String getBnfBirthday() {
/*  344 */     if (this.BnfBirthday != null) this.BnfBirthday.equals("");
/*      */ 
/*  348 */     return this.BnfBirthday;
/*      */   }
/*      */ 
/*      */   public void setBnfBirthday(String aBnfBirthday) {
/*  352 */     this.BnfBirthday = aBnfBirthday;
/*      */   }
/*      */ 
/*      */   public int getBnfAge() {
/*  356 */     return this.BnfAge;
/*      */   }
/*      */ 
/*      */   public void setBnfAge(int aBnfAge) {
/*  360 */     this.BnfAge = aBnfAge;
/*      */   }
/*      */ 
/*      */   public void setBnfAge(String aBnfAge) {
/*  364 */     if ((aBnfAge != null) && (!aBnfAge.equals("")))
/*      */     {
/*  366 */       Integer tInteger = new Integer(aBnfAge);
/*  367 */       int i = tInteger.intValue();
/*  368 */       this.BnfAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getRelationToInsured()
/*      */   {
/*  374 */     if (this.RelationToInsured != null) this.RelationToInsured.equals("");
/*      */ 
/*  378 */     return this.RelationToInsured;
/*      */   }
/*      */ 
/*      */   public void setRelationToInsured(String aRelationToInsured) {
/*  382 */     this.RelationToInsured = aRelationToInsured;
/*      */   }
/*      */ 
/*      */   public String getAddressNo() {
/*  386 */     if (this.AddressNo != null) this.AddressNo.equals("");
/*      */ 
/*  390 */     return this.AddressNo;
/*      */   }
/*      */ 
/*      */   public void setAddressNo(String aAddressNo) {
/*  394 */     this.AddressNo = aAddressNo;
/*      */   }
/*      */ 
/*      */   public String getIDType() {
/*  398 */     if (this.IDType != null) this.IDType.equals("");
/*      */ 
/*  402 */     return this.IDType;
/*      */   }
/*      */ 
/*      */   public void setIDType(String aIDType) {
/*  406 */     this.IDType = aIDType;
/*      */   }
/*      */ 
/*      */   public String getIDNo() {
/*  410 */     if (this.IDNo != null) this.IDNo.equals("");
/*      */ 
/*  414 */     return this.IDNo;
/*      */   }
/*      */ 
/*      */   public void setIDNo(String aIDNo) {
/*  418 */     this.IDNo = aIDNo;
/*      */   }
/*      */ 
/*      */   public String getIDValidity() {
/*  422 */     if (this.IDValidity != null) this.IDValidity.equals("");
/*      */ 
/*  426 */     return this.IDValidity;
/*      */   }
/*      */ 
/*      */   public void setIDValidity(String aIDValidity) {
/*  430 */     this.IDValidity = aIDValidity;
/*      */   }
/*      */ 
/*      */   public String getIDPerpetual() {
/*  434 */     if (this.IDPerpetual != null) this.IDPerpetual.equals("");
/*      */ 
/*  438 */     return this.IDPerpetual;
/*      */   }
/*      */ 
/*      */   public void setIDPerpetual(String aIDPerpetual) {
/*  442 */     this.IDPerpetual = aIDPerpetual;
/*      */   }
/*      */ 
/*      */   public String getNativePlace() {
/*  446 */     if (this.NativePlace != null) this.NativePlace.equals("");
/*      */ 
/*  450 */     return this.NativePlace;
/*      */   }
/*      */ 
/*      */   public void setNativePlace(String aNativePlace) {
/*  454 */     this.NativePlace = aNativePlace;
/*      */   }
/*      */ 
/*      */   public String getNationality() {
/*  458 */     if (this.Nationality != null) this.Nationality.equals("");
/*      */ 
/*  462 */     return this.Nationality;
/*      */   }
/*      */ 
/*      */   public void setNationality(String aNationality) {
/*  466 */     this.Nationality = aNationality;
/*      */   }
/*      */ 
/*      */   public String getRgtAddress() {
/*  470 */     if (this.RgtAddress != null) this.RgtAddress.equals("");
/*      */ 
/*  474 */     return this.RgtAddress;
/*      */   }
/*      */ 
/*      */   public void setRgtAddress(String aRgtAddress) {
/*  478 */     this.RgtAddress = aRgtAddress;
/*      */   }
/*      */ 
/*      */   public String getMarriage() {
/*  482 */     if (this.Marriage != null) this.Marriage.equals("");
/*      */ 
/*  486 */     return this.Marriage;
/*      */   }
/*      */ 
/*      */   public void setMarriage(String aMarriage) {
/*  490 */     this.Marriage = aMarriage;
/*      */   }
/*      */ 
/*      */   public String getMarriageDate() {
/*  494 */     if (this.MarriageDate != null) this.MarriageDate.equals("");
/*      */ 
/*  498 */     return this.MarriageDate;
/*      */   }
/*      */ 
/*      */   public void setMarriageDate(String aMarriageDate) {
/*  502 */     this.MarriageDate = aMarriageDate;
/*      */   }
/*      */ 
/*      */   public String getHealth() {
/*  506 */     if (this.Health != null) this.Health.equals("");
/*      */ 
/*  510 */     return this.Health;
/*      */   }
/*      */ 
/*      */   public void setHealth(String aHealth) {
/*  514 */     this.Health = aHealth;
/*      */   }
/*      */ 
/*      */   public double getStature() {
/*  518 */     return this.Stature;
/*      */   }
/*      */ 
/*      */   public void setStature(double aStature) {
/*  522 */     this.Stature = aStature;
/*      */   }
/*      */ 
/*      */   public void setStature(String aStature) {
/*  526 */     if ((aStature != null) && (!aStature.equals("")))
/*      */     {
/*  528 */       Double tDouble = new Double(aStature);
/*  529 */       double d = tDouble.doubleValue();
/*  530 */       this.Stature = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAvoirdupois()
/*      */   {
/*  536 */     return this.Avoirdupois;
/*      */   }
/*      */ 
/*      */   public void setAvoirdupois(double aAvoirdupois) {
/*  540 */     this.Avoirdupois = aAvoirdupois;
/*      */   }
/*      */ 
/*      */   public void setAvoirdupois(String aAvoirdupois) {
/*  544 */     if ((aAvoirdupois != null) && (!aAvoirdupois.equals("")))
/*      */     {
/*  546 */       Double tDouble = new Double(aAvoirdupois);
/*  547 */       double d = tDouble.doubleValue();
/*  548 */       this.Avoirdupois = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDegree()
/*      */   {
/*  554 */     if (this.Degree != null) this.Degree.equals("");
/*      */ 
/*  558 */     return this.Degree;
/*      */   }
/*      */ 
/*      */   public void setDegree(String aDegree) {
/*  562 */     this.Degree = aDegree;
/*      */   }
/*      */ 
/*      */   public String getCreditGrade() {
/*  566 */     if (this.CreditGrade != null) this.CreditGrade.equals("");
/*      */ 
/*  570 */     return this.CreditGrade;
/*      */   }
/*      */ 
/*      */   public void setCreditGrade(String aCreditGrade) {
/*  574 */     this.CreditGrade = aCreditGrade;
/*      */   }
/*      */ 
/*      */   public String getBankCode() {
/*  578 */     if (this.BankCode != null) this.BankCode.equals("");
/*      */ 
/*  582 */     return this.BankCode;
/*      */   }
/*      */ 
/*      */   public void setBankCode(String aBankCode) {
/*  586 */     this.BankCode = aBankCode;
/*      */   }
/*      */ 
/*      */   public String getBankAccNo() {
/*  590 */     if (this.BankAccNo != null) this.BankAccNo.equals("");
/*      */ 
/*  594 */     return this.BankAccNo;
/*      */   }
/*      */ 
/*      */   public void setBankAccNo(String aBankAccNo) {
/*  598 */     this.BankAccNo = aBankAccNo;
/*      */   }
/*      */ 
/*      */   public String getAccName() {
/*  602 */     if (this.AccName != null) this.AccName.equals("");
/*      */ 
/*  606 */     return this.AccName;
/*      */   }
/*      */ 
/*      */   public void setAccName(String aAccName) {
/*  610 */     this.AccName = aAccName;
/*      */   }
/*      */ 
/*      */   public String getJoinCompanyDate() {
/*  614 */     if (this.JoinCompanyDate != null) this.JoinCompanyDate.equals("");
/*      */ 
/*  618 */     return this.JoinCompanyDate;
/*      */   }
/*      */ 
/*      */   public void setJoinCompanyDate(String aJoinCompanyDate) {
/*  622 */     this.JoinCompanyDate = aJoinCompanyDate;
/*      */   }
/*      */ 
/*      */   public String getStartWorkDate() {
/*  626 */     if (this.StartWorkDate != null) this.StartWorkDate.equals("");
/*      */ 
/*  630 */     return this.StartWorkDate;
/*      */   }
/*      */ 
/*      */   public void setStartWorkDate(String aStartWorkDate) {
/*  634 */     this.StartWorkDate = aStartWorkDate;
/*      */   }
/*      */ 
/*      */   public String getPosition() {
/*  638 */     if (this.Position != null) this.Position.equals("");
/*      */ 
/*  642 */     return this.Position;
/*      */   }
/*      */ 
/*      */   public void setPosition(String aPosition) {
/*  646 */     this.Position = aPosition;
/*      */   }
/*      */ 
/*      */   public double getSalary() {
/*  650 */     return this.Salary;
/*      */   }
/*      */ 
/*      */   public void setSalary(double aSalary) {
/*  654 */     this.Salary = aSalary;
/*      */   }
/*      */ 
/*      */   public void setSalary(String aSalary) {
/*  658 */     if ((aSalary != null) && (!aSalary.equals("")))
/*      */     {
/*  660 */       Double tDouble = new Double(aSalary);
/*  661 */       double d = tDouble.doubleValue();
/*  662 */       this.Salary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOccupationType()
/*      */   {
/*  668 */     if (this.OccupationType != null) this.OccupationType.equals("");
/*      */ 
/*  672 */     return this.OccupationType;
/*      */   }
/*      */ 
/*      */   public void setOccupationType(String aOccupationType) {
/*  676 */     this.OccupationType = aOccupationType;
/*      */   }
/*      */ 
/*      */   public String getOccupationCode() {
/*  680 */     if (this.OccupationCode != null) this.OccupationCode.equals("");
/*      */ 
/*  684 */     return this.OccupationCode;
/*      */   }
/*      */ 
/*      */   public void setOccupationCode(String aOccupationCode) {
/*  688 */     this.OccupationCode = aOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getWorkType() {
/*  692 */     if (this.WorkType != null) this.WorkType.equals("");
/*      */ 
/*  696 */     return this.WorkType;
/*      */   }
/*      */ 
/*      */   public void setWorkType(String aWorkType) {
/*  700 */     this.WorkType = aWorkType;
/*      */   }
/*      */ 
/*      */   public String getPluralityType() {
/*  704 */     if (this.PluralityType != null) this.PluralityType.equals("");
/*      */ 
/*  708 */     return this.PluralityType;
/*      */   }
/*      */ 
/*      */   public void setPluralityType(String aPluralityType) {
/*  712 */     this.PluralityType = aPluralityType;
/*      */   }
/*      */ 
/*      */   public String getSmokeFlag() {
/*  716 */     if (this.SmokeFlag != null) this.SmokeFlag.equals("");
/*      */ 
/*  720 */     return this.SmokeFlag;
/*      */   }
/*      */ 
/*      */   public void setSmokeFlag(String aSmokeFlag) {
/*  724 */     this.SmokeFlag = aSmokeFlag;
/*      */   }
/*      */ 
/*      */   public String getBnfFlag() {
/*  728 */     if (this.BnfFlag != null) this.BnfFlag.equals("");
/*      */ 
/*  732 */     return this.BnfFlag;
/*      */   }
/*      */ 
/*      */   public void setBnfFlag(String aBnfFlag) {
/*  736 */     this.BnfFlag = aBnfFlag;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  740 */     if (this.Operator != null) this.Operator.equals("");
/*      */ 
/*  744 */     return this.Operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  748 */     this.Operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  752 */     if (this.ManageCom != null) this.ManageCom.equals("");
/*      */ 
/*  756 */     return this.ManageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  760 */     this.ManageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  764 */     if (this.MakeDate != null) this.MakeDate.equals("");
/*      */ 
/*  768 */     return this.MakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  772 */     this.MakeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public String getMakeTime() {
/*  776 */     if (this.MakeTime != null) this.MakeTime.equals("");
/*      */ 
/*  780 */     return this.MakeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  784 */     this.MakeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  788 */     if (this.ModifyDate != null) this.ModifyDate.equals("");
/*      */ 
/*  792 */     return this.ModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  796 */     this.ModifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public String getModifyTime() {
/*  800 */     if (this.ModifyTime != null) this.ModifyTime.equals("");
/*      */ 
/*  804 */     return this.ModifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  808 */     this.ModifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getnewbnfname() {
/*  812 */     if (this.newbnfname != null) this.newbnfname.equals("");
/*      */ 
/*  816 */     return this.newbnfname;
/*      */   }
/*      */ 
/*      */   public void setnewbnfname(String anewbnfname) {
/*  820 */     this.newbnfname = anewbnfname;
/*      */   }
/*      */ 
/*      */   public String getnewbnfbirthday() {
/*  824 */     if (this.newbnfbirthday != null) this.newbnfbirthday.equals("");
/*      */ 
/*  828 */     return this.newbnfbirthday;
/*      */   }
/*      */ 
/*      */   public void setnewbnfbirthday(String anewbnfbirthday) {
/*  832 */     this.newbnfbirthday = anewbnfbirthday;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPBnfSchema aLNPBnfSchema)
/*      */   {
/*  838 */     this.ContNo = aLNPBnfSchema.getContNo();
/*  839 */     this.PolNo = aLNPBnfSchema.getPolNo();
/*  840 */     this.InsuredNo = aLNPBnfSchema.getInsuredNo();
/*  841 */     this.InsuredId = aLNPBnfSchema.getInsuredId();
/*  842 */     this.BenefitType = aLNPBnfSchema.getBenefitType();
/*  843 */     this.BnfOrder = aLNPBnfSchema.getBnfOrder();
/*  844 */     this.BnfGrade = aLNPBnfSchema.getBnfGrade();
/*  845 */     this.BenefitRate = aLNPBnfSchema.getBenefitRate();
/*  846 */     this.BenefitOrder = aLNPBnfSchema.getBenefitOrder();
/*  847 */     this.BnfNo = aLNPBnfSchema.getBnfNo();
/*  848 */     this.BnfId = aLNPBnfSchema.getBnfId();
/*  849 */     this.Appellation = aLNPBnfSchema.getAppellation();
/*  850 */     this.BnfName = aLNPBnfSchema.getBnfName();
/*  851 */     this.BnfSex = aLNPBnfSchema.getBnfSex();
/*  852 */     this.BnfBirthday = aLNPBnfSchema.getBnfBirthday();
/*  853 */     this.BnfAge = aLNPBnfSchema.getBnfAge();
/*  854 */     this.RelationToInsured = aLNPBnfSchema.getRelationToInsured();
/*  855 */     this.AddressNo = aLNPBnfSchema.getAddressNo();
/*  856 */     this.IDType = aLNPBnfSchema.getIDType();
/*  857 */     this.IDNo = aLNPBnfSchema.getIDNo();
/*  858 */     this.IDValidity = aLNPBnfSchema.getIDValidity();
/*  859 */     this.IDPerpetual = aLNPBnfSchema.getIDPerpetual();
/*  860 */     this.NativePlace = aLNPBnfSchema.getNativePlace();
/*  861 */     this.Nationality = aLNPBnfSchema.getNationality();
/*  862 */     this.RgtAddress = aLNPBnfSchema.getRgtAddress();
/*  863 */     this.Marriage = aLNPBnfSchema.getMarriage();
/*  864 */     this.MarriageDate = aLNPBnfSchema.getMarriageDate();
/*  865 */     this.Health = aLNPBnfSchema.getHealth();
/*  866 */     this.Stature = aLNPBnfSchema.getStature();
/*  867 */     this.Avoirdupois = aLNPBnfSchema.getAvoirdupois();
/*  868 */     this.Degree = aLNPBnfSchema.getDegree();
/*  869 */     this.CreditGrade = aLNPBnfSchema.getCreditGrade();
/*  870 */     this.BankCode = aLNPBnfSchema.getBankCode();
/*  871 */     this.BankAccNo = aLNPBnfSchema.getBankAccNo();
/*  872 */     this.AccName = aLNPBnfSchema.getAccName();
/*  873 */     this.JoinCompanyDate = aLNPBnfSchema.getJoinCompanyDate();
/*  874 */     this.StartWorkDate = aLNPBnfSchema.getStartWorkDate();
/*  875 */     this.Position = aLNPBnfSchema.getPosition();
/*  876 */     this.Salary = aLNPBnfSchema.getSalary();
/*  877 */     this.OccupationType = aLNPBnfSchema.getOccupationType();
/*  878 */     this.OccupationCode = aLNPBnfSchema.getOccupationCode();
/*  879 */     this.WorkType = aLNPBnfSchema.getWorkType();
/*  880 */     this.PluralityType = aLNPBnfSchema.getPluralityType();
/*  881 */     this.SmokeFlag = aLNPBnfSchema.getSmokeFlag();
/*  882 */     this.BnfFlag = aLNPBnfSchema.getBnfFlag();
/*  883 */     this.Operator = aLNPBnfSchema.getOperator();
/*  884 */     this.ManageCom = aLNPBnfSchema.getManageCom();
/*  885 */     this.MakeDate = aLNPBnfSchema.getMakeDate();
/*  886 */     this.MakeTime = aLNPBnfSchema.getMakeTime();
/*  887 */     this.ModifyDate = aLNPBnfSchema.getModifyDate();
/*  888 */     this.ModifyTime = aLNPBnfSchema.getModifyTime();
/*  889 */     this.newbnfname = aLNPBnfSchema.getnewbnfname();
/*  890 */     this.newbnfbirthday = aLNPBnfSchema.getnewbnfbirthday();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  899 */       if (rs.getString("ContNo") == null)
/*  900 */         this.ContNo = null;
/*      */       else {
/*  902 */         this.ContNo = rs.getString("ContNo").trim();
/*      */       }
/*  904 */       if (rs.getString("PolNo") == null)
/*  905 */         this.PolNo = null;
/*      */       else {
/*  907 */         this.PolNo = rs.getString("PolNo").trim();
/*      */       }
/*  909 */       if (rs.getString("InsuredNo") == null)
/*  910 */         this.InsuredNo = null;
/*      */       else {
/*  912 */         this.InsuredNo = rs.getString("InsuredNo").trim();
/*      */       }
/*  914 */       if (rs.getString("InsuredId") == null)
/*  915 */         this.InsuredId = null;
/*      */       else {
/*  917 */         this.InsuredId = rs.getString("InsuredId").trim();
/*      */       }
/*  919 */       if (rs.getString("BenefitType") == null)
/*  920 */         this.BenefitType = null;
/*      */       else {
/*  922 */         this.BenefitType = rs.getString("BenefitType").trim();
/*      */       }
/*  924 */       this.BnfOrder = rs.getInt("BnfOrder");
/*  925 */       if (rs.getString("BnfGrade") == null)
/*  926 */         this.BnfGrade = null;
/*      */       else {
/*  928 */         this.BnfGrade = rs.getString("BnfGrade").trim();
/*      */       }
/*  930 */       this.BenefitRate = rs.getDouble("BenefitRate");
/*  931 */       if (rs.getString("BenefitOrder") == null)
/*  932 */         this.BenefitOrder = null;
/*      */       else {
/*  934 */         this.BenefitOrder = rs.getString("BenefitOrder").trim();
/*      */       }
/*  936 */       if (rs.getString("BnfNo") == null)
/*  937 */         this.BnfNo = null;
/*      */       else {
/*  939 */         this.BnfNo = rs.getString("BnfNo").trim();
/*      */       }
/*  941 */       if (rs.getString("BnfId") == null)
/*  942 */         this.BnfId = null;
/*      */       else {
/*  944 */         this.BnfId = rs.getString("BnfId").trim();
/*      */       }
/*  946 */       if (rs.getString("Appellation") == null)
/*  947 */         this.Appellation = null;
/*      */       else {
/*  949 */         this.Appellation = rs.getString("Appellation").trim();
/*      */       }
/*  951 */       if (rs.getString("BnfName") == null)
/*  952 */         this.BnfName = null;
/*      */       else {
/*  954 */         this.BnfName = rs.getString("BnfName").trim();
/*      */       }
/*  956 */       if (rs.getString("BnfSex") == null)
/*  957 */         this.BnfSex = null;
/*      */       else {
/*  959 */         this.BnfSex = rs.getString("BnfSex").trim();
/*      */       }
/*  961 */       if (rs.getString("BnfBirthday") == null)
/*  962 */         this.BnfBirthday = null;
/*      */       else {
/*  964 */         this.BnfBirthday = rs.getString("BnfBirthday").trim();
/*      */       }
/*  966 */       this.BnfAge = rs.getInt("BnfAge");
/*  967 */       if (rs.getString("RelationToInsured") == null)
/*  968 */         this.RelationToInsured = null;
/*      */       else {
/*  970 */         this.RelationToInsured = rs.getString("RelationToInsured").trim();
/*      */       }
/*  972 */       if (rs.getString("AddressNo") == null)
/*  973 */         this.AddressNo = null;
/*      */       else {
/*  975 */         this.AddressNo = rs.getString("AddressNo").trim();
/*      */       }
/*  977 */       if (rs.getString("IDType") == null)
/*  978 */         this.IDType = null;
/*      */       else {
/*  980 */         this.IDType = rs.getString("IDType").trim();
/*      */       }
/*  982 */       if (rs.getString("IDNo") == null)
/*  983 */         this.IDNo = null;
/*      */       else {
/*  985 */         this.IDNo = rs.getString("IDNo").trim();
/*      */       }
/*  987 */       if (rs.getString("IDValidity") == null)
/*  988 */         this.IDValidity = null;
/*      */       else {
/*  990 */         this.IDValidity = rs.getString("IDValidity").trim();
/*      */       }
/*  992 */       if (rs.getString("IDPerpetual") == null)
/*  993 */         this.IDPerpetual = null;
/*      */       else {
/*  995 */         this.IDPerpetual = rs.getString("IDPerpetual").trim();
/*      */       }
/*  997 */       if (rs.getString("NativePlace") == null)
/*  998 */         this.NativePlace = null;
/*      */       else {
/* 1000 */         this.NativePlace = rs.getString("NativePlace").trim();
/*      */       }
/* 1002 */       if (rs.getString("Nationality") == null)
/* 1003 */         this.Nationality = null;
/*      */       else {
/* 1005 */         this.Nationality = rs.getString("Nationality").trim();
/*      */       }
/* 1007 */       if (rs.getString("RgtAddress") == null)
/* 1008 */         this.RgtAddress = null;
/*      */       else {
/* 1010 */         this.RgtAddress = rs.getString("RgtAddress").trim();
/*      */       }
/* 1012 */       if (rs.getString("Marriage") == null)
/* 1013 */         this.Marriage = null;
/*      */       else {
/* 1015 */         this.Marriage = rs.getString("Marriage").trim();
/*      */       }
/* 1017 */       if (rs.getString("MarriageDate") == null)
/* 1018 */         this.MarriageDate = null;
/*      */       else {
/* 1020 */         this.MarriageDate = rs.getString("MarriageDate").trim();
/*      */       }
/* 1022 */       if (rs.getString("Health") == null)
/* 1023 */         this.Health = null;
/*      */       else {
/* 1025 */         this.Health = rs.getString("Health").trim();
/*      */       }
/* 1027 */       this.Stature = rs.getDouble("Stature");
/* 1028 */       this.Avoirdupois = rs.getDouble("Avoirdupois");
/* 1029 */       if (rs.getString("Degree") == null)
/* 1030 */         this.Degree = null;
/*      */       else {
/* 1032 */         this.Degree = rs.getString("Degree").trim();
/*      */       }
/* 1034 */       if (rs.getString("CreditGrade") == null)
/* 1035 */         this.CreditGrade = null;
/*      */       else {
/* 1037 */         this.CreditGrade = rs.getString("CreditGrade").trim();
/*      */       }
/* 1039 */       if (rs.getString("BankCode") == null)
/* 1040 */         this.BankCode = null;
/*      */       else {
/* 1042 */         this.BankCode = rs.getString("BankCode").trim();
/*      */       }
/* 1044 */       if (rs.getString("BankAccNo") == null)
/* 1045 */         this.BankAccNo = null;
/*      */       else {
/* 1047 */         this.BankAccNo = rs.getString("BankAccNo").trim();
/*      */       }
/* 1049 */       if (rs.getString("AccName") == null)
/* 1050 */         this.AccName = null;
/*      */       else {
/* 1052 */         this.AccName = rs.getString("AccName").trim();
/*      */       }
/* 1054 */       if (rs.getString("JoinCompanyDate") == null)
/* 1055 */         this.JoinCompanyDate = null;
/*      */       else {
/* 1057 */         this.JoinCompanyDate = rs.getString("JoinCompanyDate").trim();
/*      */       }
/* 1059 */       if (rs.getString("StartWorkDate") == null)
/* 1060 */         this.StartWorkDate = null;
/*      */       else {
/* 1062 */         this.StartWorkDate = rs.getString("StartWorkDate").trim();
/*      */       }
/* 1064 */       if (rs.getString("Position") == null)
/* 1065 */         this.Position = null;
/*      */       else {
/* 1067 */         this.Position = rs.getString("Position").trim();
/*      */       }
/* 1069 */       this.Salary = rs.getDouble("Salary");
/* 1070 */       if (rs.getString("OccupationType") == null)
/* 1071 */         this.OccupationType = null;
/*      */       else {
/* 1073 */         this.OccupationType = rs.getString("OccupationType").trim();
/*      */       }
/* 1075 */       if (rs.getString("OccupationCode") == null)
/* 1076 */         this.OccupationCode = null;
/*      */       else {
/* 1078 */         this.OccupationCode = rs.getString("OccupationCode").trim();
/*      */       }
/* 1080 */       if (rs.getString("WorkType") == null)
/* 1081 */         this.WorkType = null;
/*      */       else {
/* 1083 */         this.WorkType = rs.getString("WorkType").trim();
/*      */       }
/* 1085 */       if (rs.getString("PluralityType") == null)
/* 1086 */         this.PluralityType = null;
/*      */       else {
/* 1088 */         this.PluralityType = rs.getString("PluralityType").trim();
/*      */       }
/* 1090 */       if (rs.getString("SmokeFlag") == null)
/* 1091 */         this.SmokeFlag = null;
/*      */       else {
/* 1093 */         this.SmokeFlag = rs.getString("SmokeFlag").trim();
/*      */       }
/* 1095 */       if (rs.getString("BnfFlag") == null)
/* 1096 */         this.BnfFlag = null;
/*      */       else {
/* 1098 */         this.BnfFlag = rs.getString("BnfFlag").trim();
/*      */       }
/* 1100 */       if (rs.getString("Operator") == null)
/* 1101 */         this.Operator = null;
/*      */       else {
/* 1103 */         this.Operator = rs.getString("Operator").trim();
/*      */       }
/* 1105 */       if (rs.getString("ManageCom") == null)
/* 1106 */         this.ManageCom = null;
/*      */       else {
/* 1108 */         this.ManageCom = rs.getString("ManageCom").trim();
/*      */       }
/* 1110 */       if (rs.getString("MakeDate") == null)
/* 1111 */         this.MakeDate = null;
/*      */       else {
/* 1113 */         this.MakeDate = rs.getString("MakeDate").trim();
/*      */       }
/* 1115 */       if (rs.getString("MakeTime") == null)
/* 1116 */         this.MakeTime = null;
/*      */       else {
/* 1118 */         this.MakeTime = rs.getString("MakeTime").trim();
/*      */       }
/* 1120 */       if (rs.getString("ModifyDate") == null)
/* 1121 */         this.ModifyDate = null;
/*      */       else {
/* 1123 */         this.ModifyDate = rs.getString("ModifyDate").trim();
/*      */       }
/* 1125 */       if (rs.getString("ModifyTime") == null)
/* 1126 */         this.ModifyTime = null;
/*      */       else {
/* 1128 */         this.ModifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/* 1130 */       if (rs.getString("newbnfname") == null)
/* 1131 */         this.newbnfname = null;
/*      */       else {
/* 1133 */         this.newbnfname = rs.getString("newbnfname").trim();
/*      */       }
/* 1135 */       if (rs.getString("newbnfbirthday") == null)
/* 1136 */         this.newbnfbirthday = null;
/*      */       else {
/* 1138 */         this.newbnfbirthday = rs.getString("newbnfbirthday").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1144 */       CError tError = new CError();
/* 1145 */       tError.moduleName = "LNPBnfSchema";
/* 1146 */       tError.functionName = "setSchema";
/* 1147 */       tError.errorMessage = sqle.toString();
/* 1148 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1150 */       return false;
/*      */     }
/* 1152 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPBnfSchema getSchema()
/*      */   {
/* 1157 */     LNPBnfSchema aLNPBnfSchema = new LNPBnfSchema();
/* 1158 */     aLNPBnfSchema.setSchema(this);
/* 1159 */     return aLNPBnfSchema;
/*      */   }
/*      */ 
/*      */   public LNPBnfDB getDB()
/*      */   {
/* 1164 */     LNPBnfDB aDBOper = new LNPBnfDB();
/* 1165 */     aDBOper.setSchema(this);
/* 1166 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1173 */     String strReturn = "";
/* 1174 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.ContNo)) + "|" + 
/* 1175 */       StrTool.cTrim(StrTool.unicodeToGBK(this.PolNo)) + "|" + 
/* 1176 */       StrTool.cTrim(StrTool.unicodeToGBK(this.InsuredNo)) + "|" + 
/* 1177 */       StrTool.cTrim(StrTool.unicodeToGBK(this.InsuredId)) + "|" + 
/* 1178 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BenefitType)) + "|" + 
/* 1179 */       ChgData.chgData(this.BnfOrder) + "|" + 
/* 1180 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BnfGrade)) + "|" + 
/* 1181 */       ChgData.chgData(this.BenefitRate) + "|" + 
/* 1182 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BenefitOrder)) + "|" + 
/* 1183 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BnfNo)) + "|" + 
/* 1184 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BnfId)) + "|" + 
/* 1185 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Appellation)) + "|" + 
/* 1186 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BnfName)) + "|" + 
/* 1187 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BnfSex)) + "|" + 
/* 1188 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BnfBirthday)) + "|" + 
/* 1189 */       ChgData.chgData(this.BnfAge) + "|" + 
/* 1190 */       StrTool.cTrim(StrTool.unicodeToGBK(this.RelationToInsured)) + "|" + 
/* 1191 */       StrTool.cTrim(StrTool.unicodeToGBK(this.AddressNo)) + "|" + 
/* 1192 */       StrTool.cTrim(StrTool.unicodeToGBK(this.IDType)) + "|" + 
/* 1193 */       StrTool.cTrim(StrTool.unicodeToGBK(this.IDNo)) + "|" + 
/* 1194 */       StrTool.cTrim(StrTool.unicodeToGBK(this.IDValidity)) + "|" + 
/* 1195 */       StrTool.cTrim(StrTool.unicodeToGBK(this.IDPerpetual)) + "|" + 
/* 1196 */       StrTool.cTrim(StrTool.unicodeToGBK(this.NativePlace)) + "|" + 
/* 1197 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Nationality)) + "|" + 
/* 1198 */       StrTool.cTrim(StrTool.unicodeToGBK(this.RgtAddress)) + "|" + 
/* 1199 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Marriage)) + "|" + 
/* 1200 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MarriageDate)) + "|" + 
/* 1201 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Health)) + "|" + 
/* 1202 */       ChgData.chgData(this.Stature) + "|" + 
/* 1203 */       ChgData.chgData(this.Avoirdupois) + "|" + 
/* 1204 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Degree)) + "|" + 
/* 1205 */       StrTool.cTrim(StrTool.unicodeToGBK(this.CreditGrade)) + "|" + 
/* 1206 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BankCode)) + "|" + 
/* 1207 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BankAccNo)) + "|" + 
/* 1208 */       StrTool.cTrim(StrTool.unicodeToGBK(this.AccName)) + "|" + 
/* 1209 */       StrTool.cTrim(StrTool.unicodeToGBK(this.JoinCompanyDate)) + "|" + 
/* 1210 */       StrTool.cTrim(StrTool.unicodeToGBK(this.StartWorkDate)) + "|" + 
/* 1211 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Position)) + "|" + 
/* 1212 */       ChgData.chgData(this.Salary) + "|" + 
/* 1213 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OccupationType)) + "|" + 
/* 1214 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OccupationCode)) + "|" + 
/* 1215 */       StrTool.cTrim(StrTool.unicodeToGBK(this.WorkType)) + "|" + 
/* 1216 */       StrTool.cTrim(StrTool.unicodeToGBK(this.PluralityType)) + "|" + 
/* 1217 */       StrTool.cTrim(StrTool.unicodeToGBK(this.SmokeFlag)) + "|" + 
/* 1218 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BnfFlag)) + "|" + 
/* 1219 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Operator)) + "|" + 
/* 1220 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ManageCom)) + "|" + 
/* 1221 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeDate)) + "|" + 
/* 1222 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeTime)) + "|" + 
/* 1223 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyDate)) + "|" + 
/* 1224 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyTime)) + "|" + 
/* 1225 */       StrTool.cTrim(StrTool.unicodeToGBK(this.newbnfname)) + "|" + 
/* 1226 */       StrTool.cTrim(StrTool.unicodeToGBK(this.newbnfbirthday));
/* 1227 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1235 */       this.ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1236 */       this.PolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1237 */       this.InsuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1238 */       this.InsuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1239 */       this.BenefitType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1240 */       this.BnfOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/* 1241 */       this.BnfGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1242 */       this.BenefitRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).doubleValue();
/* 1243 */       this.BenefitOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1244 */       this.BnfNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1245 */       this.BnfId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1246 */       this.Appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1247 */       this.BnfName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1248 */       this.BnfSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1249 */       this.BnfBirthday = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1250 */       this.BnfAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|"))).intValue();
/* 1251 */       this.RelationToInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1252 */       this.AddressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1253 */       this.IDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1254 */       this.IDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 1255 */       this.IDValidity = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1256 */       this.IDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 1257 */       this.NativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 1258 */       this.Nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1259 */       this.RgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1260 */       this.Marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1261 */       this.MarriageDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1262 */       this.Health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1263 */       this.Stature = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|"))).doubleValue();
/* 1264 */       this.Avoirdupois = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 30, "|"))).doubleValue();
/* 1265 */       this.Degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/* 1266 */       this.CreditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 1267 */       this.BankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 1268 */       this.BankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/* 1269 */       this.AccName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 1270 */       this.JoinCompanyDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
/* 1271 */       this.StartWorkDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 1272 */       this.Position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/* 1273 */       this.Salary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|"))).doubleValue();
/* 1274 */       this.OccupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1275 */       this.OccupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1276 */       this.WorkType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1277 */       this.PluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 1278 */       this.SmokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1279 */       this.BnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 1280 */       this.Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 1281 */       this.ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 1282 */       this.MakeDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 1283 */       this.MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/* 1284 */       this.ModifyDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
/* 1285 */       this.ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
/* 1286 */       this.newbnfname = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
/* 1287 */       this.newbnfbirthday = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1292 */       CError tError = new CError();
/* 1293 */       tError.moduleName = "LNPBnfSchema";
/* 1294 */       tError.functionName = "decode";
/* 1295 */       tError.errorMessage = ex.toString();
/* 1296 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1298 */       return false;
/*      */     }
/* 1300 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1306 */     String strReturn = "";
/* 1307 */     if (FCode.equals("ContNo"))
/*      */     {
/* 1309 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ContNo));
/*      */     }
/* 1311 */     if (FCode.equals("PolNo"))
/*      */     {
/* 1313 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.PolNo));
/*      */     }
/* 1315 */     if (FCode.equals("InsuredNo"))
/*      */     {
/* 1317 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.InsuredNo));
/*      */     }
/* 1319 */     if (FCode.equals("InsuredId"))
/*      */     {
/* 1321 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.InsuredId));
/*      */     }
/* 1323 */     if (FCode.equals("BenefitType"))
/*      */     {
/* 1325 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BenefitType));
/*      */     }
/* 1327 */     if (FCode.equals("BnfOrder"))
/*      */     {
/* 1329 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BnfOrder));
/*      */     }
/* 1331 */     if (FCode.equals("BnfGrade"))
/*      */     {
/* 1333 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BnfGrade));
/*      */     }
/* 1335 */     if (FCode.equals("BenefitRate"))
/*      */     {
/* 1337 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BenefitRate));
/*      */     }
/* 1339 */     if (FCode.equals("BenefitOrder"))
/*      */     {
/* 1341 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BenefitOrder));
/*      */     }
/* 1343 */     if (FCode.equals("BnfNo"))
/*      */     {
/* 1345 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BnfNo));
/*      */     }
/* 1347 */     if (FCode.equals("BnfId"))
/*      */     {
/* 1349 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BnfId));
/*      */     }
/* 1351 */     if (FCode.equals("Appellation"))
/*      */     {
/* 1353 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Appellation));
/*      */     }
/* 1355 */     if (FCode.equals("BnfName"))
/*      */     {
/* 1357 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BnfName));
/*      */     }
/* 1359 */     if (FCode.equals("BnfSex"))
/*      */     {
/* 1361 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BnfSex));
/*      */     }
/* 1363 */     if (FCode.equals("BnfBirthday"))
/*      */     {
/* 1365 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BnfBirthday));
/*      */     }
/* 1367 */     if (FCode.equals("BnfAge"))
/*      */     {
/* 1369 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BnfAge));
/*      */     }
/* 1371 */     if (FCode.equals("RelationToInsured"))
/*      */     {
/* 1373 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.RelationToInsured));
/*      */     }
/* 1375 */     if (FCode.equals("AddressNo"))
/*      */     {
/* 1377 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.AddressNo));
/*      */     }
/* 1379 */     if (FCode.equals("IDType"))
/*      */     {
/* 1381 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.IDType));
/*      */     }
/* 1383 */     if (FCode.equals("IDNo"))
/*      */     {
/* 1385 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.IDNo));
/*      */     }
/* 1387 */     if (FCode.equals("IDValidity"))
/*      */     {
/* 1389 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.IDValidity));
/*      */     }
/* 1391 */     if (FCode.equals("IDPerpetual"))
/*      */     {
/* 1393 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.IDPerpetual));
/*      */     }
/* 1395 */     if (FCode.equals("NativePlace"))
/*      */     {
/* 1397 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.NativePlace));
/*      */     }
/* 1399 */     if (FCode.equals("Nationality"))
/*      */     {
/* 1401 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Nationality));
/*      */     }
/* 1403 */     if (FCode.equals("RgtAddress"))
/*      */     {
/* 1405 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.RgtAddress));
/*      */     }
/* 1407 */     if (FCode.equals("Marriage"))
/*      */     {
/* 1409 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Marriage));
/*      */     }
/* 1411 */     if (FCode.equals("MarriageDate"))
/*      */     {
/* 1413 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MarriageDate));
/*      */     }
/* 1415 */     if (FCode.equals("Health"))
/*      */     {
/* 1417 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Health));
/*      */     }
/* 1419 */     if (FCode.equals("Stature"))
/*      */     {
/* 1421 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Stature));
/*      */     }
/* 1423 */     if (FCode.equals("Avoirdupois"))
/*      */     {
/* 1425 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Avoirdupois));
/*      */     }
/* 1427 */     if (FCode.equals("Degree"))
/*      */     {
/* 1429 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Degree));
/*      */     }
/* 1431 */     if (FCode.equals("CreditGrade"))
/*      */     {
/* 1433 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.CreditGrade));
/*      */     }
/* 1435 */     if (FCode.equals("BankCode"))
/*      */     {
/* 1437 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BankCode));
/*      */     }
/* 1439 */     if (FCode.equals("BankAccNo"))
/*      */     {
/* 1441 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BankAccNo));
/*      */     }
/* 1443 */     if (FCode.equals("AccName"))
/*      */     {
/* 1445 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.AccName));
/*      */     }
/* 1447 */     if (FCode.equals("JoinCompanyDate"))
/*      */     {
/* 1449 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.JoinCompanyDate));
/*      */     }
/* 1451 */     if (FCode.equals("StartWorkDate"))
/*      */     {
/* 1453 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.StartWorkDate));
/*      */     }
/* 1455 */     if (FCode.equals("Position"))
/*      */     {
/* 1457 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Position));
/*      */     }
/* 1459 */     if (FCode.equals("Salary"))
/*      */     {
/* 1461 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Salary));
/*      */     }
/* 1463 */     if (FCode.equals("OccupationType"))
/*      */     {
/* 1465 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OccupationType));
/*      */     }
/* 1467 */     if (FCode.equals("OccupationCode"))
/*      */     {
/* 1469 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OccupationCode));
/*      */     }
/* 1471 */     if (FCode.equals("WorkType"))
/*      */     {
/* 1473 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.WorkType));
/*      */     }
/* 1475 */     if (FCode.equals("PluralityType"))
/*      */     {
/* 1477 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.PluralityType));
/*      */     }
/* 1479 */     if (FCode.equals("SmokeFlag"))
/*      */     {
/* 1481 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.SmokeFlag));
/*      */     }
/* 1483 */     if (FCode.equals("BnfFlag"))
/*      */     {
/* 1485 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BnfFlag));
/*      */     }
/* 1487 */     if (FCode.equals("Operator"))
/*      */     {
/* 1489 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Operator));
/*      */     }
/* 1491 */     if (FCode.equals("ManageCom"))
/*      */     {
/* 1493 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ManageCom));
/*      */     }
/* 1495 */     if (FCode.equals("MakeDate"))
/*      */     {
/* 1497 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeDate));
/*      */     }
/* 1499 */     if (FCode.equals("MakeTime"))
/*      */     {
/* 1501 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeTime));
/*      */     }
/* 1503 */     if (FCode.equals("ModifyDate"))
/*      */     {
/* 1505 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyDate));
/*      */     }
/* 1507 */     if (FCode.equals("ModifyTime"))
/*      */     {
/* 1509 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyTime));
/*      */     }
/* 1511 */     if (FCode.equals("newbnfname"))
/*      */     {
/* 1513 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.newbnfname));
/*      */     }
/* 1515 */     if (FCode.equals("newbnfbirthday"))
/*      */     {
/* 1517 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.newbnfbirthday));
/*      */     }
/* 1519 */     if (strReturn.equals(""))
/*      */     {
/* 1521 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1524 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1531 */     String strFieldValue = "";
/* 1532 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1534 */       strFieldValue = StrTool.GBKToUnicode(this.ContNo);
/* 1535 */       break;
/*      */     case 1:
/* 1537 */       strFieldValue = StrTool.GBKToUnicode(this.PolNo);
/* 1538 */       break;
/*      */     case 2:
/* 1540 */       strFieldValue = StrTool.GBKToUnicode(this.InsuredNo);
/* 1541 */       break;
/*      */     case 3:
/* 1543 */       strFieldValue = StrTool.GBKToUnicode(this.InsuredId);
/* 1544 */       break;
/*      */     case 4:
/* 1546 */       strFieldValue = StrTool.GBKToUnicode(this.BenefitType);
/* 1547 */       break;
/*      */     case 5:
/* 1549 */       strFieldValue = String.valueOf(this.BnfOrder);
/* 1550 */       break;
/*      */     case 6:
/* 1552 */       strFieldValue = StrTool.GBKToUnicode(this.BnfGrade);
/* 1553 */       break;
/*      */     case 7:
/* 1555 */       strFieldValue = String.valueOf(this.BenefitRate);
/* 1556 */       break;
/*      */     case 8:
/* 1558 */       strFieldValue = StrTool.GBKToUnicode(this.BenefitOrder);
/* 1559 */       break;
/*      */     case 9:
/* 1561 */       strFieldValue = StrTool.GBKToUnicode(this.BnfNo);
/* 1562 */       break;
/*      */     case 10:
/* 1564 */       strFieldValue = StrTool.GBKToUnicode(this.BnfId);
/* 1565 */       break;
/*      */     case 11:
/* 1567 */       strFieldValue = StrTool.GBKToUnicode(this.Appellation);
/* 1568 */       break;
/*      */     case 12:
/* 1570 */       strFieldValue = StrTool.GBKToUnicode(this.BnfName);
/* 1571 */       break;
/*      */     case 13:
/* 1573 */       strFieldValue = StrTool.GBKToUnicode(this.BnfSex);
/* 1574 */       break;
/*      */     case 14:
/* 1576 */       strFieldValue = StrTool.GBKToUnicode(this.BnfBirthday);
/* 1577 */       break;
/*      */     case 15:
/* 1579 */       strFieldValue = String.valueOf(this.BnfAge);
/* 1580 */       break;
/*      */     case 16:
/* 1582 */       strFieldValue = StrTool.GBKToUnicode(this.RelationToInsured);
/* 1583 */       break;
/*      */     case 17:
/* 1585 */       strFieldValue = StrTool.GBKToUnicode(this.AddressNo);
/* 1586 */       break;
/*      */     case 18:
/* 1588 */       strFieldValue = StrTool.GBKToUnicode(this.IDType);
/* 1589 */       break;
/*      */     case 19:
/* 1591 */       strFieldValue = StrTool.GBKToUnicode(this.IDNo);
/* 1592 */       break;
/*      */     case 20:
/* 1594 */       strFieldValue = StrTool.GBKToUnicode(this.IDValidity);
/* 1595 */       break;
/*      */     case 21:
/* 1597 */       strFieldValue = StrTool.GBKToUnicode(this.IDPerpetual);
/* 1598 */       break;
/*      */     case 22:
/* 1600 */       strFieldValue = StrTool.GBKToUnicode(this.NativePlace);
/* 1601 */       break;
/*      */     case 23:
/* 1603 */       strFieldValue = StrTool.GBKToUnicode(this.Nationality);
/* 1604 */       break;
/*      */     case 24:
/* 1606 */       strFieldValue = StrTool.GBKToUnicode(this.RgtAddress);
/* 1607 */       break;
/*      */     case 25:
/* 1609 */       strFieldValue = StrTool.GBKToUnicode(this.Marriage);
/* 1610 */       break;
/*      */     case 26:
/* 1612 */       strFieldValue = StrTool.GBKToUnicode(this.MarriageDate);
/* 1613 */       break;
/*      */     case 27:
/* 1615 */       strFieldValue = StrTool.GBKToUnicode(this.Health);
/* 1616 */       break;
/*      */     case 28:
/* 1618 */       strFieldValue = String.valueOf(this.Stature);
/* 1619 */       break;
/*      */     case 29:
/* 1621 */       strFieldValue = String.valueOf(this.Avoirdupois);
/* 1622 */       break;
/*      */     case 30:
/* 1624 */       strFieldValue = StrTool.GBKToUnicode(this.Degree);
/* 1625 */       break;
/*      */     case 31:
/* 1627 */       strFieldValue = StrTool.GBKToUnicode(this.CreditGrade);
/* 1628 */       break;
/*      */     case 32:
/* 1630 */       strFieldValue = StrTool.GBKToUnicode(this.BankCode);
/* 1631 */       break;
/*      */     case 33:
/* 1633 */       strFieldValue = StrTool.GBKToUnicode(this.BankAccNo);
/* 1634 */       break;
/*      */     case 34:
/* 1636 */       strFieldValue = StrTool.GBKToUnicode(this.AccName);
/* 1637 */       break;
/*      */     case 35:
/* 1639 */       strFieldValue = StrTool.GBKToUnicode(this.JoinCompanyDate);
/* 1640 */       break;
/*      */     case 36:
/* 1642 */       strFieldValue = StrTool.GBKToUnicode(this.StartWorkDate);
/* 1643 */       break;
/*      */     case 37:
/* 1645 */       strFieldValue = StrTool.GBKToUnicode(this.Position);
/* 1646 */       break;
/*      */     case 38:
/* 1648 */       strFieldValue = String.valueOf(this.Salary);
/* 1649 */       break;
/*      */     case 39:
/* 1651 */       strFieldValue = StrTool.GBKToUnicode(this.OccupationType);
/* 1652 */       break;
/*      */     case 40:
/* 1654 */       strFieldValue = StrTool.GBKToUnicode(this.OccupationCode);
/* 1655 */       break;
/*      */     case 41:
/* 1657 */       strFieldValue = StrTool.GBKToUnicode(this.WorkType);
/* 1658 */       break;
/*      */     case 42:
/* 1660 */       strFieldValue = StrTool.GBKToUnicode(this.PluralityType);
/* 1661 */       break;
/*      */     case 43:
/* 1663 */       strFieldValue = StrTool.GBKToUnicode(this.SmokeFlag);
/* 1664 */       break;
/*      */     case 44:
/* 1666 */       strFieldValue = StrTool.GBKToUnicode(this.BnfFlag);
/* 1667 */       break;
/*      */     case 45:
/* 1669 */       strFieldValue = StrTool.GBKToUnicode(this.Operator);
/* 1670 */       break;
/*      */     case 46:
/* 1672 */       strFieldValue = StrTool.GBKToUnicode(this.ManageCom);
/* 1673 */       break;
/*      */     case 47:
/* 1675 */       strFieldValue = StrTool.GBKToUnicode(this.MakeDate);
/* 1676 */       break;
/*      */     case 48:
/* 1678 */       strFieldValue = StrTool.GBKToUnicode(this.MakeTime);
/* 1679 */       break;
/*      */     case 49:
/* 1681 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyDate);
/* 1682 */       break;
/*      */     case 50:
/* 1684 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyTime);
/* 1685 */       break;
/*      */     case 51:
/* 1687 */       strFieldValue = StrTool.GBKToUnicode(this.newbnfname);
/* 1688 */       break;
/*      */     case 52:
/* 1690 */       strFieldValue = StrTool.GBKToUnicode(this.newbnfbirthday);
/* 1691 */       break;
/*      */     default:
/* 1693 */       strFieldValue = "";
/*      */     }
/* 1695 */     if (strFieldValue.equals("")) {
/* 1696 */       strFieldValue = "null";
/*      */     }
/* 1698 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1704 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1705 */       return false;
/*      */     }
/* 1707 */     if (FCode.equals("ContNo"))
/*      */     {
/* 1709 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1711 */         this.ContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1714 */         this.ContNo = null;
/*      */     }
/* 1716 */     if (FCode.equals("PolNo"))
/*      */     {
/* 1718 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1720 */         this.PolNo = FValue.trim();
/*      */       }
/*      */       else
/* 1723 */         this.PolNo = null;
/*      */     }
/* 1725 */     if (FCode.equals("InsuredNo"))
/*      */     {
/* 1727 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1729 */         this.InsuredNo = FValue.trim();
/*      */       }
/*      */       else
/* 1732 */         this.InsuredNo = null;
/*      */     }
/* 1734 */     if (FCode.equals("InsuredId"))
/*      */     {
/* 1736 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1738 */         this.InsuredId = FValue.trim();
/*      */       }
/*      */       else
/* 1741 */         this.InsuredId = null;
/*      */     }
/* 1743 */     if (FCode.equals("BenefitType"))
/*      */     {
/* 1745 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1747 */         this.BenefitType = FValue.trim();
/*      */       }
/*      */       else
/* 1750 */         this.BenefitType = null;
/*      */     }
/* 1752 */     if (FCode.equals("BnfOrder"))
/*      */     {
/* 1754 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1756 */         Integer tInteger = new Integer(FValue);
/* 1757 */         int i = tInteger.intValue();
/* 1758 */         this.BnfOrder = i;
/*      */       }
/*      */     }
/* 1761 */     if (FCode.equals("BnfGrade"))
/*      */     {
/* 1763 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1765 */         this.BnfGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1768 */         this.BnfGrade = null;
/*      */     }
/* 1770 */     if (FCode.equals("BenefitRate"))
/*      */     {
/* 1772 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1774 */         Double tDouble = new Double(FValue);
/* 1775 */         double d = tDouble.doubleValue();
/* 1776 */         this.BenefitRate = d;
/*      */       }
/*      */     }
/* 1779 */     if (FCode.equals("BenefitOrder"))
/*      */     {
/* 1781 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1783 */         this.BenefitOrder = FValue.trim();
/*      */       }
/*      */       else
/* 1786 */         this.BenefitOrder = null;
/*      */     }
/* 1788 */     if (FCode.equals("BnfNo"))
/*      */     {
/* 1790 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1792 */         this.BnfNo = FValue.trim();
/*      */       }
/*      */       else
/* 1795 */         this.BnfNo = null;
/*      */     }
/* 1797 */     if (FCode.equals("BnfId"))
/*      */     {
/* 1799 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1801 */         this.BnfId = FValue.trim();
/*      */       }
/*      */       else
/* 1804 */         this.BnfId = null;
/*      */     }
/* 1806 */     if (FCode.equals("Appellation"))
/*      */     {
/* 1808 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1810 */         this.Appellation = FValue.trim();
/*      */       }
/*      */       else
/* 1813 */         this.Appellation = null;
/*      */     }
/* 1815 */     if (FCode.equals("BnfName"))
/*      */     {
/* 1817 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1819 */         this.BnfName = FValue.trim();
/*      */       }
/*      */       else
/* 1822 */         this.BnfName = null;
/*      */     }
/* 1824 */     if (FCode.equals("BnfSex"))
/*      */     {
/* 1826 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1828 */         this.BnfSex = FValue.trim();
/*      */       }
/*      */       else
/* 1831 */         this.BnfSex = null;
/*      */     }
/* 1833 */     if (FCode.equals("BnfBirthday"))
/*      */     {
/* 1835 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1837 */         this.BnfBirthday = FValue.trim();
/*      */       }
/*      */       else
/* 1840 */         this.BnfBirthday = null;
/*      */     }
/* 1842 */     if (FCode.equals("BnfAge"))
/*      */     {
/* 1844 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1846 */         Integer tInteger = new Integer(FValue);
/* 1847 */         int i = tInteger.intValue();
/* 1848 */         this.BnfAge = i;
/*      */       }
/*      */     }
/* 1851 */     if (FCode.equals("RelationToInsured"))
/*      */     {
/* 1853 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1855 */         this.RelationToInsured = FValue.trim();
/*      */       }
/*      */       else
/* 1858 */         this.RelationToInsured = null;
/*      */     }
/* 1860 */     if (FCode.equals("AddressNo"))
/*      */     {
/* 1862 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1864 */         this.AddressNo = FValue.trim();
/*      */       }
/*      */       else
/* 1867 */         this.AddressNo = null;
/*      */     }
/* 1869 */     if (FCode.equals("IDType"))
/*      */     {
/* 1871 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1873 */         this.IDType = FValue.trim();
/*      */       }
/*      */       else
/* 1876 */         this.IDType = null;
/*      */     }
/* 1878 */     if (FCode.equals("IDNo"))
/*      */     {
/* 1880 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1882 */         this.IDNo = FValue.trim();
/*      */       }
/*      */       else
/* 1885 */         this.IDNo = null;
/*      */     }
/* 1887 */     if (FCode.equals("IDValidity"))
/*      */     {
/* 1889 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1891 */         this.IDValidity = FValue.trim();
/*      */       }
/*      */       else
/* 1894 */         this.IDValidity = null;
/*      */     }
/* 1896 */     if (FCode.equals("IDPerpetual"))
/*      */     {
/* 1898 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1900 */         this.IDPerpetual = FValue.trim();
/*      */       }
/*      */       else
/* 1903 */         this.IDPerpetual = null;
/*      */     }
/* 1905 */     if (FCode.equals("NativePlace"))
/*      */     {
/* 1907 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1909 */         this.NativePlace = FValue.trim();
/*      */       }
/*      */       else
/* 1912 */         this.NativePlace = null;
/*      */     }
/* 1914 */     if (FCode.equals("Nationality"))
/*      */     {
/* 1916 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1918 */         this.Nationality = FValue.trim();
/*      */       }
/*      */       else
/* 1921 */         this.Nationality = null;
/*      */     }
/* 1923 */     if (FCode.equals("RgtAddress"))
/*      */     {
/* 1925 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1927 */         this.RgtAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1930 */         this.RgtAddress = null;
/*      */     }
/* 1932 */     if (FCode.equals("Marriage"))
/*      */     {
/* 1934 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1936 */         this.Marriage = FValue.trim();
/*      */       }
/*      */       else
/* 1939 */         this.Marriage = null;
/*      */     }
/* 1941 */     if (FCode.equals("MarriageDate"))
/*      */     {
/* 1943 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1945 */         this.MarriageDate = FValue.trim();
/*      */       }
/*      */       else
/* 1948 */         this.MarriageDate = null;
/*      */     }
/* 1950 */     if (FCode.equals("Health"))
/*      */     {
/* 1952 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1954 */         this.Health = FValue.trim();
/*      */       }
/*      */       else
/* 1957 */         this.Health = null;
/*      */     }
/* 1959 */     if (FCode.equals("Stature"))
/*      */     {
/* 1961 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1963 */         Double tDouble = new Double(FValue);
/* 1964 */         double d = tDouble.doubleValue();
/* 1965 */         this.Stature = d;
/*      */       }
/*      */     }
/* 1968 */     if (FCode.equals("Avoirdupois"))
/*      */     {
/* 1970 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1972 */         Double tDouble = new Double(FValue);
/* 1973 */         double d = tDouble.doubleValue();
/* 1974 */         this.Avoirdupois = d;
/*      */       }
/*      */     }
/* 1977 */     if (FCode.equals("Degree"))
/*      */     {
/* 1979 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1981 */         this.Degree = FValue.trim();
/*      */       }
/*      */       else
/* 1984 */         this.Degree = null;
/*      */     }
/* 1986 */     if (FCode.equals("CreditGrade"))
/*      */     {
/* 1988 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1990 */         this.CreditGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1993 */         this.CreditGrade = null;
/*      */     }
/* 1995 */     if (FCode.equals("BankCode"))
/*      */     {
/* 1997 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1999 */         this.BankCode = FValue.trim();
/*      */       }
/*      */       else
/* 2002 */         this.BankCode = null;
/*      */     }
/* 2004 */     if (FCode.equals("BankAccNo"))
/*      */     {
/* 2006 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2008 */         this.BankAccNo = FValue.trim();
/*      */       }
/*      */       else
/* 2011 */         this.BankAccNo = null;
/*      */     }
/* 2013 */     if (FCode.equals("AccName"))
/*      */     {
/* 2015 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2017 */         this.AccName = FValue.trim();
/*      */       }
/*      */       else
/* 2020 */         this.AccName = null;
/*      */     }
/* 2022 */     if (FCode.equals("JoinCompanyDate"))
/*      */     {
/* 2024 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2026 */         this.JoinCompanyDate = FValue.trim();
/*      */       }
/*      */       else
/* 2029 */         this.JoinCompanyDate = null;
/*      */     }
/* 2031 */     if (FCode.equals("StartWorkDate"))
/*      */     {
/* 2033 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2035 */         this.StartWorkDate = FValue.trim();
/*      */       }
/*      */       else
/* 2038 */         this.StartWorkDate = null;
/*      */     }
/* 2040 */     if (FCode.equals("Position"))
/*      */     {
/* 2042 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2044 */         this.Position = FValue.trim();
/*      */       }
/*      */       else
/* 2047 */         this.Position = null;
/*      */     }
/* 2049 */     if (FCode.equals("Salary"))
/*      */     {
/* 2051 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2053 */         Double tDouble = new Double(FValue);
/* 2054 */         double d = tDouble.doubleValue();
/* 2055 */         this.Salary = d;
/*      */       }
/*      */     }
/* 2058 */     if (FCode.equals("OccupationType"))
/*      */     {
/* 2060 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2062 */         this.OccupationType = FValue.trim();
/*      */       }
/*      */       else
/* 2065 */         this.OccupationType = null;
/*      */     }
/* 2067 */     if (FCode.equals("OccupationCode"))
/*      */     {
/* 2069 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2071 */         this.OccupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 2074 */         this.OccupationCode = null;
/*      */     }
/* 2076 */     if (FCode.equals("WorkType"))
/*      */     {
/* 2078 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2080 */         this.WorkType = FValue.trim();
/*      */       }
/*      */       else
/* 2083 */         this.WorkType = null;
/*      */     }
/* 2085 */     if (FCode.equals("PluralityType"))
/*      */     {
/* 2087 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2089 */         this.PluralityType = FValue.trim();
/*      */       }
/*      */       else
/* 2092 */         this.PluralityType = null;
/*      */     }
/* 2094 */     if (FCode.equals("SmokeFlag"))
/*      */     {
/* 2096 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2098 */         this.SmokeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2101 */         this.SmokeFlag = null;
/*      */     }
/* 2103 */     if (FCode.equals("BnfFlag"))
/*      */     {
/* 2105 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2107 */         this.BnfFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2110 */         this.BnfFlag = null;
/*      */     }
/* 2112 */     if (FCode.equals("Operator"))
/*      */     {
/* 2114 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2116 */         this.Operator = FValue.trim();
/*      */       }
/*      */       else
/* 2119 */         this.Operator = null;
/*      */     }
/* 2121 */     if (FCode.equals("ManageCom"))
/*      */     {
/* 2123 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2125 */         this.ManageCom = FValue.trim();
/*      */       }
/*      */       else
/* 2128 */         this.ManageCom = null;
/*      */     }
/* 2130 */     if (FCode.equals("MakeDate"))
/*      */     {
/* 2132 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2134 */         this.MakeDate = FValue.trim();
/*      */       }
/*      */       else
/* 2137 */         this.MakeDate = null;
/*      */     }
/* 2139 */     if (FCode.equals("MakeTime"))
/*      */     {
/* 2141 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2143 */         this.MakeTime = FValue.trim();
/*      */       }
/*      */       else
/* 2146 */         this.MakeTime = null;
/*      */     }
/* 2148 */     if (FCode.equals("ModifyDate"))
/*      */     {
/* 2150 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2152 */         this.ModifyDate = FValue.trim();
/*      */       }
/*      */       else
/* 2155 */         this.ModifyDate = null;
/*      */     }
/* 2157 */     if (FCode.equals("ModifyTime"))
/*      */     {
/* 2159 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2161 */         this.ModifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 2164 */         this.ModifyTime = null;
/*      */     }
/* 2166 */     if (FCode.equals("newbnfname"))
/*      */     {
/* 2168 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2170 */         this.newbnfname = FValue.trim();
/*      */       }
/*      */       else
/* 2173 */         this.newbnfname = null;
/*      */     }
/* 2175 */     if (FCode.equals("newbnfbirthday"))
/*      */     {
/* 2177 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2179 */         this.newbnfbirthday = FValue.trim();
/*      */       }
/*      */       else
/* 2182 */         this.newbnfbirthday = null;
/*      */     }
/* 2184 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 2189 */     if (this == otherObject) return true;
/* 2190 */     if (otherObject == null) return false;
/* 2191 */     if (getClass() != otherObject.getClass()) return false;
/* 2192 */     LNPBnfSchema other = (LNPBnfSchema)otherObject;
/* 2193 */     return 
/* 2194 */       (this.ContNo.equals(other.getContNo())) && 
/* 2195 */       (this.PolNo.equals(other.getPolNo())) && 
/* 2196 */       (this.InsuredNo.equals(other.getInsuredNo())) && 
/* 2197 */       (this.InsuredId.equals(other.getInsuredId())) && 
/* 2198 */       (this.BenefitType.equals(other.getBenefitType())) && 
/* 2199 */       (this.BnfOrder == other.getBnfOrder()) && 
/* 2200 */       (this.BnfGrade.equals(other.getBnfGrade())) && 
/* 2201 */       (this.BenefitRate == other.getBenefitRate()) && 
/* 2202 */       (this.BenefitOrder.equals(other.getBenefitOrder())) && 
/* 2203 */       (this.BnfNo.equals(other.getBnfNo())) && 
/* 2204 */       (this.BnfId.equals(other.getBnfId())) && 
/* 2205 */       (this.Appellation.equals(other.getAppellation())) && 
/* 2206 */       (this.BnfName.equals(other.getBnfName())) && 
/* 2207 */       (this.BnfSex.equals(other.getBnfSex())) && 
/* 2208 */       (this.BnfBirthday.equals(other.getBnfBirthday())) && 
/* 2209 */       (this.BnfAge == other.getBnfAge()) && 
/* 2210 */       (this.RelationToInsured.equals(other.getRelationToInsured())) && 
/* 2211 */       (this.AddressNo.equals(other.getAddressNo())) && 
/* 2212 */       (this.IDType.equals(other.getIDType())) && 
/* 2213 */       (this.IDNo.equals(other.getIDNo())) && 
/* 2214 */       (this.IDValidity.equals(other.getIDValidity())) && 
/* 2215 */       (this.IDPerpetual.equals(other.getIDPerpetual())) && 
/* 2216 */       (this.NativePlace.equals(other.getNativePlace())) && 
/* 2217 */       (this.Nationality.equals(other.getNationality())) && 
/* 2218 */       (this.RgtAddress.equals(other.getRgtAddress())) && 
/* 2219 */       (this.Marriage.equals(other.getMarriage())) && 
/* 2220 */       (this.MarriageDate.equals(other.getMarriageDate())) && 
/* 2221 */       (this.Health.equals(other.getHealth())) && 
/* 2222 */       (this.Stature == other.getStature()) && 
/* 2223 */       (this.Avoirdupois == other.getAvoirdupois()) && 
/* 2224 */       (this.Degree.equals(other.getDegree())) && 
/* 2225 */       (this.CreditGrade.equals(other.getCreditGrade())) && 
/* 2226 */       (this.BankCode.equals(other.getBankCode())) && 
/* 2227 */       (this.BankAccNo.equals(other.getBankAccNo())) && 
/* 2228 */       (this.AccName.equals(other.getAccName())) && 
/* 2229 */       (this.JoinCompanyDate.equals(other.getJoinCompanyDate())) && 
/* 2230 */       (this.StartWorkDate.equals(other.getStartWorkDate())) && 
/* 2231 */       (this.Position.equals(other.getPosition())) && 
/* 2232 */       (this.Salary == other.getSalary()) && 
/* 2233 */       (this.OccupationType.equals(other.getOccupationType())) && 
/* 2234 */       (this.OccupationCode.equals(other.getOccupationCode())) && 
/* 2235 */       (this.WorkType.equals(other.getWorkType())) && 
/* 2236 */       (this.PluralityType.equals(other.getPluralityType())) && 
/* 2237 */       (this.SmokeFlag.equals(other.getSmokeFlag())) && 
/* 2238 */       (this.BnfFlag.equals(other.getBnfFlag())) && 
/* 2239 */       (this.Operator.equals(other.getOperator())) && 
/* 2240 */       (this.ManageCom.equals(other.getManageCom())) && 
/* 2241 */       (this.MakeDate.equals(other.getMakeDate())) && 
/* 2242 */       (this.MakeTime.equals(other.getMakeTime())) && 
/* 2243 */       (this.ModifyDate.equals(other.getModifyDate())) && 
/* 2244 */       (this.ModifyTime.equals(other.getModifyTime())) && 
/* 2245 */       (this.newbnfname.equals(other.getnewbnfname())) && 
/* 2246 */       (this.newbnfbirthday.equals(other.getnewbnfbirthday()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2252 */     return 53;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2258 */     if (strFieldName.equals("ContNo")) {
/* 2259 */       return 0;
/*      */     }
/* 2261 */     if (strFieldName.equals("PolNo")) {
/* 2262 */       return 1;
/*      */     }
/* 2264 */     if (strFieldName.equals("InsuredNo")) {
/* 2265 */       return 2;
/*      */     }
/* 2267 */     if (strFieldName.equals("InsuredId")) {
/* 2268 */       return 3;
/*      */     }
/* 2270 */     if (strFieldName.equals("BenefitType")) {
/* 2271 */       return 4;
/*      */     }
/* 2273 */     if (strFieldName.equals("BnfOrder")) {
/* 2274 */       return 5;
/*      */     }
/* 2276 */     if (strFieldName.equals("BnfGrade")) {
/* 2277 */       return 6;
/*      */     }
/* 2279 */     if (strFieldName.equals("BenefitRate")) {
/* 2280 */       return 7;
/*      */     }
/* 2282 */     if (strFieldName.equals("BenefitOrder")) {
/* 2283 */       return 8;
/*      */     }
/* 2285 */     if (strFieldName.equals("BnfNo")) {
/* 2286 */       return 9;
/*      */     }
/* 2288 */     if (strFieldName.equals("BnfId")) {
/* 2289 */       return 10;
/*      */     }
/* 2291 */     if (strFieldName.equals("Appellation")) {
/* 2292 */       return 11;
/*      */     }
/* 2294 */     if (strFieldName.equals("BnfName")) {
/* 2295 */       return 12;
/*      */     }
/* 2297 */     if (strFieldName.equals("BnfSex")) {
/* 2298 */       return 13;
/*      */     }
/* 2300 */     if (strFieldName.equals("BnfBirthday")) {
/* 2301 */       return 14;
/*      */     }
/* 2303 */     if (strFieldName.equals("BnfAge")) {
/* 2304 */       return 15;
/*      */     }
/* 2306 */     if (strFieldName.equals("RelationToInsured")) {
/* 2307 */       return 16;
/*      */     }
/* 2309 */     if (strFieldName.equals("AddressNo")) {
/* 2310 */       return 17;
/*      */     }
/* 2312 */     if (strFieldName.equals("IDType")) {
/* 2313 */       return 18;
/*      */     }
/* 2315 */     if (strFieldName.equals("IDNo")) {
/* 2316 */       return 19;
/*      */     }
/* 2318 */     if (strFieldName.equals("IDValidity")) {
/* 2319 */       return 20;
/*      */     }
/* 2321 */     if (strFieldName.equals("IDPerpetual")) {
/* 2322 */       return 21;
/*      */     }
/* 2324 */     if (strFieldName.equals("NativePlace")) {
/* 2325 */       return 22;
/*      */     }
/* 2327 */     if (strFieldName.equals("Nationality")) {
/* 2328 */       return 23;
/*      */     }
/* 2330 */     if (strFieldName.equals("RgtAddress")) {
/* 2331 */       return 24;
/*      */     }
/* 2333 */     if (strFieldName.equals("Marriage")) {
/* 2334 */       return 25;
/*      */     }
/* 2336 */     if (strFieldName.equals("MarriageDate")) {
/* 2337 */       return 26;
/*      */     }
/* 2339 */     if (strFieldName.equals("Health")) {
/* 2340 */       return 27;
/*      */     }
/* 2342 */     if (strFieldName.equals("Stature")) {
/* 2343 */       return 28;
/*      */     }
/* 2345 */     if (strFieldName.equals("Avoirdupois")) {
/* 2346 */       return 29;
/*      */     }
/* 2348 */     if (strFieldName.equals("Degree")) {
/* 2349 */       return 30;
/*      */     }
/* 2351 */     if (strFieldName.equals("CreditGrade")) {
/* 2352 */       return 31;
/*      */     }
/* 2354 */     if (strFieldName.equals("BankCode")) {
/* 2355 */       return 32;
/*      */     }
/* 2357 */     if (strFieldName.equals("BankAccNo")) {
/* 2358 */       return 33;
/*      */     }
/* 2360 */     if (strFieldName.equals("AccName")) {
/* 2361 */       return 34;
/*      */     }
/* 2363 */     if (strFieldName.equals("JoinCompanyDate")) {
/* 2364 */       return 35;
/*      */     }
/* 2366 */     if (strFieldName.equals("StartWorkDate")) {
/* 2367 */       return 36;
/*      */     }
/* 2369 */     if (strFieldName.equals("Position")) {
/* 2370 */       return 37;
/*      */     }
/* 2372 */     if (strFieldName.equals("Salary")) {
/* 2373 */       return 38;
/*      */     }
/* 2375 */     if (strFieldName.equals("OccupationType")) {
/* 2376 */       return 39;
/*      */     }
/* 2378 */     if (strFieldName.equals("OccupationCode")) {
/* 2379 */       return 40;
/*      */     }
/* 2381 */     if (strFieldName.equals("WorkType")) {
/* 2382 */       return 41;
/*      */     }
/* 2384 */     if (strFieldName.equals("PluralityType")) {
/* 2385 */       return 42;
/*      */     }
/* 2387 */     if (strFieldName.equals("SmokeFlag")) {
/* 2388 */       return 43;
/*      */     }
/* 2390 */     if (strFieldName.equals("BnfFlag")) {
/* 2391 */       return 44;
/*      */     }
/* 2393 */     if (strFieldName.equals("Operator")) {
/* 2394 */       return 45;
/*      */     }
/* 2396 */     if (strFieldName.equals("ManageCom")) {
/* 2397 */       return 46;
/*      */     }
/* 2399 */     if (strFieldName.equals("MakeDate")) {
/* 2400 */       return 47;
/*      */     }
/* 2402 */     if (strFieldName.equals("MakeTime")) {
/* 2403 */       return 48;
/*      */     }
/* 2405 */     if (strFieldName.equals("ModifyDate")) {
/* 2406 */       return 49;
/*      */     }
/* 2408 */     if (strFieldName.equals("ModifyTime")) {
/* 2409 */       return 50;
/*      */     }
/* 2411 */     if (strFieldName.equals("newbnfname")) {
/* 2412 */       return 51;
/*      */     }
/* 2414 */     if (strFieldName.equals("newbnfbirthday")) {
/* 2415 */       return 52;
/*      */     }
/* 2417 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2423 */     String strFieldName = "";
/* 2424 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2426 */       strFieldName = "ContNo";
/* 2427 */       break;
/*      */     case 1:
/* 2429 */       strFieldName = "PolNo";
/* 2430 */       break;
/*      */     case 2:
/* 2432 */       strFieldName = "InsuredNo";
/* 2433 */       break;
/*      */     case 3:
/* 2435 */       strFieldName = "InsuredId";
/* 2436 */       break;
/*      */     case 4:
/* 2438 */       strFieldName = "BenefitType";
/* 2439 */       break;
/*      */     case 5:
/* 2441 */       strFieldName = "BnfOrder";
/* 2442 */       break;
/*      */     case 6:
/* 2444 */       strFieldName = "BnfGrade";
/* 2445 */       break;
/*      */     case 7:
/* 2447 */       strFieldName = "BenefitRate";
/* 2448 */       break;
/*      */     case 8:
/* 2450 */       strFieldName = "BenefitOrder";
/* 2451 */       break;
/*      */     case 9:
/* 2453 */       strFieldName = "BnfNo";
/* 2454 */       break;
/*      */     case 10:
/* 2456 */       strFieldName = "BnfId";
/* 2457 */       break;
/*      */     case 11:
/* 2459 */       strFieldName = "Appellation";
/* 2460 */       break;
/*      */     case 12:
/* 2462 */       strFieldName = "BnfName";
/* 2463 */       break;
/*      */     case 13:
/* 2465 */       strFieldName = "BnfSex";
/* 2466 */       break;
/*      */     case 14:
/* 2468 */       strFieldName = "BnfBirthday";
/* 2469 */       break;
/*      */     case 15:
/* 2471 */       strFieldName = "BnfAge";
/* 2472 */       break;
/*      */     case 16:
/* 2474 */       strFieldName = "RelationToInsured";
/* 2475 */       break;
/*      */     case 17:
/* 2477 */       strFieldName = "AddressNo";
/* 2478 */       break;
/*      */     case 18:
/* 2480 */       strFieldName = "IDType";
/* 2481 */       break;
/*      */     case 19:
/* 2483 */       strFieldName = "IDNo";
/* 2484 */       break;
/*      */     case 20:
/* 2486 */       strFieldName = "IDValidity";
/* 2487 */       break;
/*      */     case 21:
/* 2489 */       strFieldName = "IDPerpetual";
/* 2490 */       break;
/*      */     case 22:
/* 2492 */       strFieldName = "NativePlace";
/* 2493 */       break;
/*      */     case 23:
/* 2495 */       strFieldName = "Nationality";
/* 2496 */       break;
/*      */     case 24:
/* 2498 */       strFieldName = "RgtAddress";
/* 2499 */       break;
/*      */     case 25:
/* 2501 */       strFieldName = "Marriage";
/* 2502 */       break;
/*      */     case 26:
/* 2504 */       strFieldName = "MarriageDate";
/* 2505 */       break;
/*      */     case 27:
/* 2507 */       strFieldName = "Health";
/* 2508 */       break;
/*      */     case 28:
/* 2510 */       strFieldName = "Stature";
/* 2511 */       break;
/*      */     case 29:
/* 2513 */       strFieldName = "Avoirdupois";
/* 2514 */       break;
/*      */     case 30:
/* 2516 */       strFieldName = "Degree";
/* 2517 */       break;
/*      */     case 31:
/* 2519 */       strFieldName = "CreditGrade";
/* 2520 */       break;
/*      */     case 32:
/* 2522 */       strFieldName = "BankCode";
/* 2523 */       break;
/*      */     case 33:
/* 2525 */       strFieldName = "BankAccNo";
/* 2526 */       break;
/*      */     case 34:
/* 2528 */       strFieldName = "AccName";
/* 2529 */       break;
/*      */     case 35:
/* 2531 */       strFieldName = "JoinCompanyDate";
/* 2532 */       break;
/*      */     case 36:
/* 2534 */       strFieldName = "StartWorkDate";
/* 2535 */       break;
/*      */     case 37:
/* 2537 */       strFieldName = "Position";
/* 2538 */       break;
/*      */     case 38:
/* 2540 */       strFieldName = "Salary";
/* 2541 */       break;
/*      */     case 39:
/* 2543 */       strFieldName = "OccupationType";
/* 2544 */       break;
/*      */     case 40:
/* 2546 */       strFieldName = "OccupationCode";
/* 2547 */       break;
/*      */     case 41:
/* 2549 */       strFieldName = "WorkType";
/* 2550 */       break;
/*      */     case 42:
/* 2552 */       strFieldName = "PluralityType";
/* 2553 */       break;
/*      */     case 43:
/* 2555 */       strFieldName = "SmokeFlag";
/* 2556 */       break;
/*      */     case 44:
/* 2558 */       strFieldName = "BnfFlag";
/* 2559 */       break;
/*      */     case 45:
/* 2561 */       strFieldName = "Operator";
/* 2562 */       break;
/*      */     case 46:
/* 2564 */       strFieldName = "ManageCom";
/* 2565 */       break;
/*      */     case 47:
/* 2567 */       strFieldName = "MakeDate";
/* 2568 */       break;
/*      */     case 48:
/* 2570 */       strFieldName = "MakeTime";
/* 2571 */       break;
/*      */     case 49:
/* 2573 */       strFieldName = "ModifyDate";
/* 2574 */       break;
/*      */     case 50:
/* 2576 */       strFieldName = "ModifyTime";
/* 2577 */       break;
/*      */     case 51:
/* 2579 */       strFieldName = "newbnfname";
/* 2580 */       break;
/*      */     case 52:
/* 2582 */       strFieldName = "newbnfbirthday";
/* 2583 */       break;
/*      */     default:
/* 2585 */       strFieldName = "";
/*      */     }
/* 2587 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2593 */     if (strFieldName.equals("ContNo")) {
/* 2594 */       return 0;
/*      */     }
/* 2596 */     if (strFieldName.equals("PolNo")) {
/* 2597 */       return 0;
/*      */     }
/* 2599 */     if (strFieldName.equals("InsuredNo")) {
/* 2600 */       return 0;
/*      */     }
/* 2602 */     if (strFieldName.equals("InsuredId")) {
/* 2603 */       return 0;
/*      */     }
/* 2605 */     if (strFieldName.equals("BenefitType")) {
/* 2606 */       return 0;
/*      */     }
/* 2608 */     if (strFieldName.equals("BnfOrder")) {
/* 2609 */       return 3;
/*      */     }
/* 2611 */     if (strFieldName.equals("BnfGrade")) {
/* 2612 */       return 0;
/*      */     }
/* 2614 */     if (strFieldName.equals("BenefitRate")) {
/* 2615 */       return 4;
/*      */     }
/* 2617 */     if (strFieldName.equals("BenefitOrder")) {
/* 2618 */       return 0;
/*      */     }
/* 2620 */     if (strFieldName.equals("BnfNo")) {
/* 2621 */       return 0;
/*      */     }
/* 2623 */     if (strFieldName.equals("BnfId")) {
/* 2624 */       return 0;
/*      */     }
/* 2626 */     if (strFieldName.equals("Appellation")) {
/* 2627 */       return 0;
/*      */     }
/* 2629 */     if (strFieldName.equals("BnfName")) {
/* 2630 */       return 0;
/*      */     }
/* 2632 */     if (strFieldName.equals("BnfSex")) {
/* 2633 */       return 0;
/*      */     }
/* 2635 */     if (strFieldName.equals("BnfBirthday")) {
/* 2636 */       return 0;
/*      */     }
/* 2638 */     if (strFieldName.equals("BnfAge")) {
/* 2639 */       return 3;
/*      */     }
/* 2641 */     if (strFieldName.equals("RelationToInsured")) {
/* 2642 */       return 0;
/*      */     }
/* 2644 */     if (strFieldName.equals("AddressNo")) {
/* 2645 */       return 0;
/*      */     }
/* 2647 */     if (strFieldName.equals("IDType")) {
/* 2648 */       return 0;
/*      */     }
/* 2650 */     if (strFieldName.equals("IDNo")) {
/* 2651 */       return 0;
/*      */     }
/* 2653 */     if (strFieldName.equals("IDValidity")) {
/* 2654 */       return 0;
/*      */     }
/* 2656 */     if (strFieldName.equals("IDPerpetual")) {
/* 2657 */       return 0;
/*      */     }
/* 2659 */     if (strFieldName.equals("NativePlace")) {
/* 2660 */       return 0;
/*      */     }
/* 2662 */     if (strFieldName.equals("Nationality")) {
/* 2663 */       return 0;
/*      */     }
/* 2665 */     if (strFieldName.equals("RgtAddress")) {
/* 2666 */       return 0;
/*      */     }
/* 2668 */     if (strFieldName.equals("Marriage")) {
/* 2669 */       return 0;
/*      */     }
/* 2671 */     if (strFieldName.equals("MarriageDate")) {
/* 2672 */       return 0;
/*      */     }
/* 2674 */     if (strFieldName.equals("Health")) {
/* 2675 */       return 0;
/*      */     }
/* 2677 */     if (strFieldName.equals("Stature")) {
/* 2678 */       return 4;
/*      */     }
/* 2680 */     if (strFieldName.equals("Avoirdupois")) {
/* 2681 */       return 4;
/*      */     }
/* 2683 */     if (strFieldName.equals("Degree")) {
/* 2684 */       return 0;
/*      */     }
/* 2686 */     if (strFieldName.equals("CreditGrade")) {
/* 2687 */       return 0;
/*      */     }
/* 2689 */     if (strFieldName.equals("BankCode")) {
/* 2690 */       return 0;
/*      */     }
/* 2692 */     if (strFieldName.equals("BankAccNo")) {
/* 2693 */       return 0;
/*      */     }
/* 2695 */     if (strFieldName.equals("AccName")) {
/* 2696 */       return 0;
/*      */     }
/* 2698 */     if (strFieldName.equals("JoinCompanyDate")) {
/* 2699 */       return 0;
/*      */     }
/* 2701 */     if (strFieldName.equals("StartWorkDate")) {
/* 2702 */       return 0;
/*      */     }
/* 2704 */     if (strFieldName.equals("Position")) {
/* 2705 */       return 0;
/*      */     }
/* 2707 */     if (strFieldName.equals("Salary")) {
/* 2708 */       return 4;
/*      */     }
/* 2710 */     if (strFieldName.equals("OccupationType")) {
/* 2711 */       return 0;
/*      */     }
/* 2713 */     if (strFieldName.equals("OccupationCode")) {
/* 2714 */       return 0;
/*      */     }
/* 2716 */     if (strFieldName.equals("WorkType")) {
/* 2717 */       return 0;
/*      */     }
/* 2719 */     if (strFieldName.equals("PluralityType")) {
/* 2720 */       return 0;
/*      */     }
/* 2722 */     if (strFieldName.equals("SmokeFlag")) {
/* 2723 */       return 0;
/*      */     }
/* 2725 */     if (strFieldName.equals("BnfFlag")) {
/* 2726 */       return 0;
/*      */     }
/* 2728 */     if (strFieldName.equals("Operator")) {
/* 2729 */       return 0;
/*      */     }
/* 2731 */     if (strFieldName.equals("ManageCom")) {
/* 2732 */       return 0;
/*      */     }
/* 2734 */     if (strFieldName.equals("MakeDate")) {
/* 2735 */       return 0;
/*      */     }
/* 2737 */     if (strFieldName.equals("MakeTime")) {
/* 2738 */       return 0;
/*      */     }
/* 2740 */     if (strFieldName.equals("ModifyDate")) {
/* 2741 */       return 0;
/*      */     }
/* 2743 */     if (strFieldName.equals("ModifyTime")) {
/* 2744 */       return 0;
/*      */     }
/* 2746 */     if (strFieldName.equals("newbnfname")) {
/* 2747 */       return 0;
/*      */     }
/* 2749 */     if (strFieldName.equals("newbnfbirthday")) {
/* 2750 */       return 0;
/*      */     }
/* 2752 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 2758 */     int nFieldType = -1;
/* 2759 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2761 */       nFieldType = 0;
/* 2762 */       break;
/*      */     case 1:
/* 2764 */       nFieldType = 0;
/* 2765 */       break;
/*      */     case 2:
/* 2767 */       nFieldType = 0;
/* 2768 */       break;
/*      */     case 3:
/* 2770 */       nFieldType = 0;
/* 2771 */       break;
/*      */     case 4:
/* 2773 */       nFieldType = 0;
/* 2774 */       break;
/*      */     case 5:
/* 2776 */       nFieldType = 3;
/* 2777 */       break;
/*      */     case 6:
/* 2779 */       nFieldType = 0;
/* 2780 */       break;
/*      */     case 7:
/* 2782 */       nFieldType = 4;
/* 2783 */       break;
/*      */     case 8:
/* 2785 */       nFieldType = 0;
/* 2786 */       break;
/*      */     case 9:
/* 2788 */       nFieldType = 0;
/* 2789 */       break;
/*      */     case 10:
/* 2791 */       nFieldType = 0;
/* 2792 */       break;
/*      */     case 11:
/* 2794 */       nFieldType = 0;
/* 2795 */       break;
/*      */     case 12:
/* 2797 */       nFieldType = 0;
/* 2798 */       break;
/*      */     case 13:
/* 2800 */       nFieldType = 0;
/* 2801 */       break;
/*      */     case 14:
/* 2803 */       nFieldType = 0;
/* 2804 */       break;
/*      */     case 15:
/* 2806 */       nFieldType = 3;
/* 2807 */       break;
/*      */     case 16:
/* 2809 */       nFieldType = 0;
/* 2810 */       break;
/*      */     case 17:
/* 2812 */       nFieldType = 0;
/* 2813 */       break;
/*      */     case 18:
/* 2815 */       nFieldType = 0;
/* 2816 */       break;
/*      */     case 19:
/* 2818 */       nFieldType = 0;
/* 2819 */       break;
/*      */     case 20:
/* 2821 */       nFieldType = 0;
/* 2822 */       break;
/*      */     case 21:
/* 2824 */       nFieldType = 0;
/* 2825 */       break;
/*      */     case 22:
/* 2827 */       nFieldType = 0;
/* 2828 */       break;
/*      */     case 23:
/* 2830 */       nFieldType = 0;
/* 2831 */       break;
/*      */     case 24:
/* 2833 */       nFieldType = 0;
/* 2834 */       break;
/*      */     case 25:
/* 2836 */       nFieldType = 0;
/* 2837 */       break;
/*      */     case 26:
/* 2839 */       nFieldType = 0;
/* 2840 */       break;
/*      */     case 27:
/* 2842 */       nFieldType = 0;
/* 2843 */       break;
/*      */     case 28:
/* 2845 */       nFieldType = 4;
/* 2846 */       break;
/*      */     case 29:
/* 2848 */       nFieldType = 4;
/* 2849 */       break;
/*      */     case 30:
/* 2851 */       nFieldType = 0;
/* 2852 */       break;
/*      */     case 31:
/* 2854 */       nFieldType = 0;
/* 2855 */       break;
/*      */     case 32:
/* 2857 */       nFieldType = 0;
/* 2858 */       break;
/*      */     case 33:
/* 2860 */       nFieldType = 0;
/* 2861 */       break;
/*      */     case 34:
/* 2863 */       nFieldType = 0;
/* 2864 */       break;
/*      */     case 35:
/* 2866 */       nFieldType = 0;
/* 2867 */       break;
/*      */     case 36:
/* 2869 */       nFieldType = 0;
/* 2870 */       break;
/*      */     case 37:
/* 2872 */       nFieldType = 0;
/* 2873 */       break;
/*      */     case 38:
/* 2875 */       nFieldType = 4;
/* 2876 */       break;
/*      */     case 39:
/* 2878 */       nFieldType = 0;
/* 2879 */       break;
/*      */     case 40:
/* 2881 */       nFieldType = 0;
/* 2882 */       break;
/*      */     case 41:
/* 2884 */       nFieldType = 0;
/* 2885 */       break;
/*      */     case 42:
/* 2887 */       nFieldType = 0;
/* 2888 */       break;
/*      */     case 43:
/* 2890 */       nFieldType = 0;
/* 2891 */       break;
/*      */     case 44:
/* 2893 */       nFieldType = 0;
/* 2894 */       break;
/*      */     case 45:
/* 2896 */       nFieldType = 0;
/* 2897 */       break;
/*      */     case 46:
/* 2899 */       nFieldType = 0;
/* 2900 */       break;
/*      */     case 47:
/* 2902 */       nFieldType = 0;
/* 2903 */       break;
/*      */     case 48:
/* 2905 */       nFieldType = 0;
/* 2906 */       break;
/*      */     case 49:
/* 2908 */       nFieldType = 0;
/* 2909 */       break;
/*      */     case 50:
/* 2911 */       nFieldType = 0;
/* 2912 */       break;
/*      */     case 51:
/* 2914 */       nFieldType = 0;
/* 2915 */       break;
/*      */     case 52:
/* 2917 */       nFieldType = 0;
/* 2918 */       break;
/*      */     default:
/* 2920 */       nFieldType = -1;
/*      */     }
/* 2922 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPBnfSchema
 * JD-Core Version:    0.6.0
 */