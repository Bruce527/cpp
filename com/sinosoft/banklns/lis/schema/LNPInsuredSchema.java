/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
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
/*      */ public class LNPInsuredSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String insuredNo;
/*      */   private String insuredId;
/*      */   private String prtNo;
/*      */   private String appntNo;
/*      */   private String appntId;
/*      */   private String manageCom;
/*      */   private String signCity;
/*      */   private String executeCom;
/*      */   private String familyID;
/*      */   private String relationToMainInsured;
/*      */   private String relationToAppnt;
/*      */   private String addressNo;
/*      */   private String sequenceNo;
/*      */   private String name;
/*      */   private String appellation;
/*      */   private String sex;
/*      */   private Date birthday;
/*      */   private int appAge;
/*      */   private String appAgeType;
/*      */   private String iDType;
/*      */   private String iDNo;
/*      */   private Date iDValidity;
/*      */   private String iDPerpetual;
/*      */   private String nativePlace;
/*      */   private String nationality;
/*      */   private String rgtAddress;
/*      */   private String marriage;
/*      */   private Date marriageDate;
/*      */   private String health;
/*      */   private double stature;
/*      */   private double avoirdupois;
/*      */   private String degree;
/*      */   private String creditGrade;
/*      */   private String bankCode;
/*      */   private String bankAccNo;
/*      */   private String accName;
/*      */   private Date joinCompanyDate;
/*      */   private Date startWorkDate;
/*      */   private String position;
/*      */   private double salary;
/*      */   private String occupationType;
/*      */   private String occupationCode;
/*      */   private String partOccupationType;
/*      */   private String partOccupationCode;
/*      */   private String workType;
/*      */   private String pluralityType;
/*      */   private String smokeFlag;
/*      */   private String contPlanCode;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private int insuredPeoples;
/*      */   public static final int FIELDNUM = 57;
/*      */   private static String[] PK;
/*  141 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPInsuredSchema()
/*      */   {
/*  148 */     this.mErrors = new CErrors();
/*      */ 
/*  150 */     String[] pk = new String[2];
/*  151 */     pk[0] = "ContNo";
/*  152 */     pk[1] = "InsuredId";
/*      */ 
/*  154 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  161 */     LNPInsuredSchema cloned = (LNPInsuredSchema)super.clone();
/*  162 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  163 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  164 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  170 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo()
/*      */   {
/*  175 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  179 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  183 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  187 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  191 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  195 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public String getInsuredNo() {
/*  199 */     return this.insuredNo;
/*      */   }
/*      */ 
/*      */   public void setInsuredNo(String aInsuredNo) {
/*  203 */     this.insuredNo = aInsuredNo;
/*      */   }
/*      */ 
/*      */   public String getInsuredId() {
/*  207 */     return this.insuredId;
/*      */   }
/*      */ 
/*      */   public void setInsuredId(String aInsuredId) {
/*  211 */     this.insuredId = aInsuredId;
/*      */   }
/*      */ 
/*      */   public String getPrtNo() {
/*  215 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setPrtNo(String aPrtNo) {
/*  219 */     this.prtNo = aPrtNo;
/*      */   }
/*      */ 
/*      */   public String getAppntNo() {
/*  223 */     return this.appntNo;
/*      */   }
/*      */ 
/*      */   public void setAppntNo(String aAppntNo) {
/*  227 */     this.appntNo = aAppntNo;
/*      */   }
/*      */ 
/*      */   public String getAppntId() {
/*  231 */     return this.appntId;
/*      */   }
/*      */ 
/*      */   public void setAppntId(String aAppntId) {
/*  235 */     this.appntId = aAppntId;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  239 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  243 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getSignCity() {
/*  247 */     return this.signCity;
/*      */   }
/*      */ 
/*      */   public void setSignCity(String aSignCity) {
/*  251 */     this.signCity = aSignCity;
/*      */   }
/*      */ 
/*      */   public String getExecuteCom() {
/*  255 */     return this.executeCom;
/*      */   }
/*      */ 
/*      */   public void setExecuteCom(String aExecuteCom) {
/*  259 */     this.executeCom = aExecuteCom;
/*      */   }
/*      */ 
/*      */   public String getFamilyID() {
/*  263 */     return this.familyID;
/*      */   }
/*      */ 
/*      */   public void setFamilyID(String aFamilyID) {
/*  267 */     this.familyID = aFamilyID;
/*      */   }
/*      */ 
/*      */   public String getRelationToMainInsured() {
/*  271 */     return this.relationToMainInsured;
/*      */   }
/*      */ 
/*      */   public void setRelationToMainInsured(String aRelationToMainInsured) {
/*  275 */     this.relationToMainInsured = aRelationToMainInsured;
/*      */   }
/*      */ 
/*      */   public String getRelationToAppnt() {
/*  279 */     return this.relationToAppnt;
/*      */   }
/*      */ 
/*      */   public void setRelationToAppnt(String aRelationToAppnt) {
/*  283 */     this.relationToAppnt = aRelationToAppnt;
/*      */   }
/*      */ 
/*      */   public String getAddressNo() {
/*  287 */     return this.addressNo;
/*      */   }
/*      */ 
/*      */   public void setAddressNo(String aAddressNo) {
/*  291 */     this.addressNo = aAddressNo;
/*      */   }
/*      */ 
/*      */   public String getSequenceNo() {
/*  295 */     return this.sequenceNo;
/*      */   }
/*      */ 
/*      */   public void setSequenceNo(String aSequenceNo) {
/*  299 */     this.sequenceNo = aSequenceNo;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  303 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  307 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getAppellation() {
/*  311 */     return this.appellation;
/*      */   }
/*      */ 
/*      */   public void setAppellation(String aAppellation) {
/*  315 */     this.appellation = aAppellation;
/*      */   }
/*      */ 
/*      */   public String getSex() {
/*  319 */     return this.sex;
/*      */   }
/*      */ 
/*      */   public void setSex(String aSex) {
/*  323 */     this.sex = aSex;
/*      */   }
/*      */ 
/*      */   public String getBirthday() {
/*  327 */     if (this.birthday != null) {
/*  328 */       return this.fDate.getString(this.birthday);
/*      */     }
/*  330 */     return null;
/*      */   }
/*      */ 
/*      */   public void setBirthday(Date aBirthday) {
/*  334 */     this.birthday = aBirthday;
/*      */   }
/*      */ 
/*      */   public void setBirthday(String aBirthday) {
/*  338 */     if ((aBirthday != null) && (!aBirthday.equals("")))
/*      */     {
/*  340 */       this.birthday = this.fDate.getDate(aBirthday);
/*      */     }
/*      */     else
/*  343 */       this.birthday = null;
/*      */   }
/*      */ 
/*      */   public int getAppAge()
/*      */   {
/*  348 */     return this.appAge;
/*      */   }
/*      */ 
/*      */   public void setAppAge(int aAppAge) {
/*  352 */     this.appAge = aAppAge;
/*      */   }
/*      */ 
/*      */   public void setAppAge(String aAppAge) {
/*  356 */     if ((aAppAge != null) && (!aAppAge.equals("")))
/*      */     {
/*  358 */       Integer tInteger = new Integer(aAppAge);
/*  359 */       int i = tInteger.intValue();
/*  360 */       this.appAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getAppAgeType()
/*      */   {
/*  366 */     return this.appAgeType;
/*      */   }
/*      */ 
/*      */   public void setAppAgeType(String aAppAgeType) {
/*  370 */     this.appAgeType = aAppAgeType;
/*      */   }
/*      */ 
/*      */   public String getIDType() {
/*  374 */     return this.iDType;
/*      */   }
/*      */ 
/*      */   public void setIDType(String aIDType) {
/*  378 */     this.iDType = aIDType;
/*      */   }
/*      */ 
/*      */   public String getIDNo() {
/*  382 */     return this.iDNo;
/*      */   }
/*      */ 
/*      */   public void setIDNo(String aIDNo) {
/*  386 */     this.iDNo = aIDNo;
/*      */   }
/*      */ 
/*      */   public String getIDValidity() {
/*  390 */     if (this.iDValidity != null) {
/*  391 */       return this.fDate.getString(this.iDValidity);
/*      */     }
/*  393 */     return null;
/*      */   }
/*      */ 
/*      */   public void setIDValidity(Date aIDValidity) {
/*  397 */     this.iDValidity = aIDValidity;
/*      */   }
/*      */ 
/*      */   public void setIDValidity(String aIDValidity) {
/*  401 */     if ((aIDValidity != null) && (!aIDValidity.equals("")))
/*      */     {
/*  403 */       this.iDValidity = this.fDate.getDate(aIDValidity);
/*      */     }
/*      */     else
/*  406 */       this.iDValidity = null;
/*      */   }
/*      */ 
/*      */   public String getIDPerpetual()
/*      */   {
/*  411 */     return this.iDPerpetual;
/*      */   }
/*      */ 
/*      */   public void setIDPerpetual(String aIDPerpetual) {
/*  415 */     this.iDPerpetual = aIDPerpetual;
/*      */   }
/*      */ 
/*      */   public String getNativePlace() {
/*  419 */     return this.nativePlace;
/*      */   }
/*      */ 
/*      */   public void setNativePlace(String aNativePlace) {
/*  423 */     this.nativePlace = aNativePlace;
/*      */   }
/*      */ 
/*      */   public String getNationality() {
/*  427 */     return this.nationality;
/*      */   }
/*      */ 
/*      */   public void setNationality(String aNationality) {
/*  431 */     this.nationality = aNationality;
/*      */   }
/*      */ 
/*      */   public String getRgtAddress() {
/*  435 */     return this.rgtAddress;
/*      */   }
/*      */ 
/*      */   public void setRgtAddress(String aRgtAddress) {
/*  439 */     this.rgtAddress = aRgtAddress;
/*      */   }
/*      */ 
/*      */   public String getMarriage() {
/*  443 */     return this.marriage;
/*      */   }
/*      */ 
/*      */   public void setMarriage(String aMarriage) {
/*  447 */     this.marriage = aMarriage;
/*      */   }
/*      */ 
/*      */   public String getMarriageDate() {
/*  451 */     if (this.marriageDate != null) {
/*  452 */       return this.fDate.getString(this.marriageDate);
/*      */     }
/*  454 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMarriageDate(Date aMarriageDate) {
/*  458 */     this.marriageDate = aMarriageDate;
/*      */   }
/*      */ 
/*      */   public void setMarriageDate(String aMarriageDate) {
/*  462 */     if ((aMarriageDate != null) && (!aMarriageDate.equals("")))
/*      */     {
/*  464 */       this.marriageDate = this.fDate.getDate(aMarriageDate);
/*      */     }
/*      */     else
/*  467 */       this.marriageDate = null;
/*      */   }
/*      */ 
/*      */   public String getHealth()
/*      */   {
/*  472 */     return this.health;
/*      */   }
/*      */ 
/*      */   public void setHealth(String aHealth) {
/*  476 */     this.health = aHealth;
/*      */   }
/*      */ 
/*      */   public double getStature() {
/*  480 */     return this.stature;
/*      */   }
/*      */ 
/*      */   public void setStature(double aStature) {
/*  484 */     this.stature = aStature;
/*      */   }
/*      */ 
/*      */   public void setStature(String aStature) {
/*  488 */     if ((aStature != null) && (!aStature.equals("")))
/*      */     {
/*  490 */       Double tDouble = new Double(aStature);
/*  491 */       double d = tDouble.doubleValue();
/*  492 */       this.stature = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAvoirdupois()
/*      */   {
/*  498 */     return this.avoirdupois;
/*      */   }
/*      */ 
/*      */   public void setAvoirdupois(double aAvoirdupois) {
/*  502 */     this.avoirdupois = aAvoirdupois;
/*      */   }
/*      */ 
/*      */   public void setAvoirdupois(String aAvoirdupois) {
/*  506 */     if ((aAvoirdupois != null) && (!aAvoirdupois.equals("")))
/*      */     {
/*  508 */       Double tDouble = new Double(aAvoirdupois);
/*  509 */       double d = tDouble.doubleValue();
/*  510 */       this.avoirdupois = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDegree()
/*      */   {
/*  516 */     return this.degree;
/*      */   }
/*      */ 
/*      */   public void setDegree(String aDegree) {
/*  520 */     this.degree = aDegree;
/*      */   }
/*      */ 
/*      */   public String getCreditGrade() {
/*  524 */     return this.creditGrade;
/*      */   }
/*      */ 
/*      */   public void setCreditGrade(String aCreditGrade) {
/*  528 */     this.creditGrade = aCreditGrade;
/*      */   }
/*      */ 
/*      */   public String getBankCode() {
/*  532 */     return this.bankCode;
/*      */   }
/*      */ 
/*      */   public void setBankCode(String aBankCode) {
/*  536 */     this.bankCode = aBankCode;
/*      */   }
/*      */ 
/*      */   public String getBankAccNo() {
/*  540 */     return this.bankAccNo;
/*      */   }
/*      */ 
/*      */   public void setBankAccNo(String aBankAccNo) {
/*  544 */     this.bankAccNo = aBankAccNo;
/*      */   }
/*      */ 
/*      */   public String getAccName() {
/*  548 */     return this.accName;
/*      */   }
/*      */ 
/*      */   public void setAccName(String aAccName) {
/*  552 */     this.accName = aAccName;
/*      */   }
/*      */ 
/*      */   public String getJoinCompanyDate() {
/*  556 */     if (this.joinCompanyDate != null) {
/*  557 */       return this.fDate.getString(this.joinCompanyDate);
/*      */     }
/*  559 */     return null;
/*      */   }
/*      */ 
/*      */   public void setJoinCompanyDate(Date aJoinCompanyDate) {
/*  563 */     this.joinCompanyDate = aJoinCompanyDate;
/*      */   }
/*      */ 
/*      */   public void setJoinCompanyDate(String aJoinCompanyDate) {
/*  567 */     if ((aJoinCompanyDate != null) && (!aJoinCompanyDate.equals("")))
/*      */     {
/*  569 */       this.joinCompanyDate = this.fDate.getDate(aJoinCompanyDate);
/*      */     }
/*      */     else
/*  572 */       this.joinCompanyDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartWorkDate()
/*      */   {
/*  577 */     if (this.startWorkDate != null) {
/*  578 */       return this.fDate.getString(this.startWorkDate);
/*      */     }
/*  580 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartWorkDate(Date aStartWorkDate) {
/*  584 */     this.startWorkDate = aStartWorkDate;
/*      */   }
/*      */ 
/*      */   public void setStartWorkDate(String aStartWorkDate) {
/*  588 */     if ((aStartWorkDate != null) && (!aStartWorkDate.equals("")))
/*      */     {
/*  590 */       this.startWorkDate = this.fDate.getDate(aStartWorkDate);
/*      */     }
/*      */     else
/*  593 */       this.startWorkDate = null;
/*      */   }
/*      */ 
/*      */   public String getPosition()
/*      */   {
/*  598 */     return this.position;
/*      */   }
/*      */ 
/*      */   public void setPosition(String aPosition) {
/*  602 */     this.position = aPosition;
/*      */   }
/*      */ 
/*      */   public double getSalary() {
/*  606 */     return this.salary;
/*      */   }
/*      */ 
/*      */   public void setSalary(double aSalary) {
/*  610 */     this.salary = aSalary;
/*      */   }
/*      */ 
/*      */   public void setSalary(String aSalary) {
/*  614 */     if ((aSalary != null) && (!aSalary.equals("")))
/*      */     {
/*  616 */       Double tDouble = new Double(aSalary);
/*  617 */       double d = tDouble.doubleValue();
/*  618 */       this.salary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOccupationType()
/*      */   {
/*  624 */     return this.occupationType;
/*      */   }
/*      */ 
/*      */   public void setOccupationType(String aOccupationType) {
/*  628 */     this.occupationType = aOccupationType;
/*      */   }
/*      */ 
/*      */   public String getOccupationCode() {
/*  632 */     return this.occupationCode;
/*      */   }
/*      */ 
/*      */   public void setOccupationCode(String aOccupationCode) {
/*  636 */     this.occupationCode = aOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getPartOccupationType() {
/*  640 */     return this.partOccupationType;
/*      */   }
/*      */ 
/*      */   public void setPartOccupationType(String aPartOccupationType) {
/*  644 */     this.partOccupationType = aPartOccupationType;
/*      */   }
/*      */ 
/*      */   public String getPartOccupationCode() {
/*  648 */     return this.partOccupationCode;
/*      */   }
/*      */ 
/*      */   public void setPartOccupationCode(String aPartOccupationCode) {
/*  652 */     this.partOccupationCode = aPartOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getWorkType() {
/*  656 */     return this.workType;
/*      */   }
/*      */ 
/*      */   public void setWorkType(String aWorkType) {
/*  660 */     this.workType = aWorkType;
/*      */   }
/*      */ 
/*      */   public String getPluralityType() {
/*  664 */     return this.pluralityType;
/*      */   }
/*      */ 
/*      */   public void setPluralityType(String aPluralityType) {
/*  668 */     this.pluralityType = aPluralityType;
/*      */   }
/*      */ 
/*      */   public String getSmokeFlag() {
/*  672 */     return this.smokeFlag;
/*      */   }
/*      */ 
/*      */   public void setSmokeFlag(String aSmokeFlag) {
/*  676 */     this.smokeFlag = aSmokeFlag;
/*      */   }
/*      */ 
/*      */   public String getContPlanCode() {
/*  680 */     return this.contPlanCode;
/*      */   }
/*      */ 
/*      */   public void setContPlanCode(String aContPlanCode) {
/*  684 */     this.contPlanCode = aContPlanCode;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  688 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  692 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  696 */     if (this.makeDate != null) {
/*  697 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  699 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  703 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  707 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  709 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  712 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  717 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  721 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  725 */     if (this.modifyDate != null) {
/*  726 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  728 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  732 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  736 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  738 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  741 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  746 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  750 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public int getInsuredPeoples() {
/*  754 */     return this.insuredPeoples;
/*      */   }
/*      */ 
/*      */   public void setInsuredPeoples(int aInsuredPeoples) {
/*  758 */     this.insuredPeoples = aInsuredPeoples;
/*      */   }
/*      */ 
/*      */   public void setInsuredPeoples(String aInsuredPeoples) {
/*  762 */     if ((aInsuredPeoples != null) && (!aInsuredPeoples.equals("")))
/*      */     {
/*  764 */       Integer tInteger = new Integer(aInsuredPeoples);
/*  765 */       int i = tInteger.intValue();
/*  766 */       this.insuredPeoples = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPInsuredSchema aLNPInsuredSchema)
/*      */   {
/*  774 */     this.grpContNo = aLNPInsuredSchema.getGrpContNo();
/*  775 */     this.contNo = aLNPInsuredSchema.getContNo();
/*  776 */     this.proposalContNo = aLNPInsuredSchema.getProposalContNo();
/*  777 */     this.insuredNo = aLNPInsuredSchema.getInsuredNo();
/*  778 */     this.insuredId = aLNPInsuredSchema.getInsuredId();
/*  779 */     this.prtNo = aLNPInsuredSchema.getPrtNo();
/*  780 */     this.appntNo = aLNPInsuredSchema.getAppntNo();
/*  781 */     this.appntId = aLNPInsuredSchema.getAppntId();
/*  782 */     this.manageCom = aLNPInsuredSchema.getManageCom();
/*  783 */     this.signCity = aLNPInsuredSchema.getSignCity();
/*  784 */     this.executeCom = aLNPInsuredSchema.getExecuteCom();
/*  785 */     this.familyID = aLNPInsuredSchema.getFamilyID();
/*  786 */     this.relationToMainInsured = aLNPInsuredSchema.getRelationToMainInsured();
/*  787 */     this.relationToAppnt = aLNPInsuredSchema.getRelationToAppnt();
/*  788 */     this.addressNo = aLNPInsuredSchema.getAddressNo();
/*  789 */     this.sequenceNo = aLNPInsuredSchema.getSequenceNo();
/*  790 */     this.name = aLNPInsuredSchema.getName();
/*  791 */     this.appellation = aLNPInsuredSchema.getAppellation();
/*  792 */     this.sex = aLNPInsuredSchema.getSex();
/*  793 */     this.birthday = this.fDate.getDate(aLNPInsuredSchema.getBirthday());
/*  794 */     this.appAge = aLNPInsuredSchema.getAppAge();
/*  795 */     this.appAgeType = aLNPInsuredSchema.getAppAgeType();
/*  796 */     this.iDType = aLNPInsuredSchema.getIDType();
/*  797 */     this.iDNo = aLNPInsuredSchema.getIDNo();
/*  798 */     this.iDValidity = this.fDate.getDate(aLNPInsuredSchema.getIDValidity());
/*  799 */     this.iDPerpetual = aLNPInsuredSchema.getIDPerpetual();
/*  800 */     this.nativePlace = aLNPInsuredSchema.getNativePlace();
/*  801 */     this.nationality = aLNPInsuredSchema.getNationality();
/*  802 */     this.rgtAddress = aLNPInsuredSchema.getRgtAddress();
/*  803 */     this.marriage = aLNPInsuredSchema.getMarriage();
/*  804 */     this.marriageDate = this.fDate.getDate(aLNPInsuredSchema.getMarriageDate());
/*  805 */     this.health = aLNPInsuredSchema.getHealth();
/*  806 */     this.stature = aLNPInsuredSchema.getStature();
/*  807 */     this.avoirdupois = aLNPInsuredSchema.getAvoirdupois();
/*  808 */     this.degree = aLNPInsuredSchema.getDegree();
/*  809 */     this.creditGrade = aLNPInsuredSchema.getCreditGrade();
/*  810 */     this.bankCode = aLNPInsuredSchema.getBankCode();
/*  811 */     this.bankAccNo = aLNPInsuredSchema.getBankAccNo();
/*  812 */     this.accName = aLNPInsuredSchema.getAccName();
/*  813 */     this.joinCompanyDate = this.fDate.getDate(aLNPInsuredSchema.getJoinCompanyDate());
/*  814 */     this.startWorkDate = this.fDate.getDate(aLNPInsuredSchema.getStartWorkDate());
/*  815 */     this.position = aLNPInsuredSchema.getPosition();
/*  816 */     this.salary = aLNPInsuredSchema.getSalary();
/*  817 */     this.occupationType = aLNPInsuredSchema.getOccupationType();
/*  818 */     this.occupationCode = aLNPInsuredSchema.getOccupationCode();
/*  819 */     this.partOccupationType = aLNPInsuredSchema.getPartOccupationType();
/*  820 */     this.partOccupationCode = aLNPInsuredSchema.getPartOccupationCode();
/*  821 */     this.workType = aLNPInsuredSchema.getWorkType();
/*  822 */     this.pluralityType = aLNPInsuredSchema.getPluralityType();
/*  823 */     this.smokeFlag = aLNPInsuredSchema.getSmokeFlag();
/*  824 */     this.contPlanCode = aLNPInsuredSchema.getContPlanCode();
/*  825 */     this.operator = aLNPInsuredSchema.getOperator();
/*  826 */     this.makeDate = this.fDate.getDate(aLNPInsuredSchema.getMakeDate());
/*  827 */     this.makeTime = aLNPInsuredSchema.getMakeTime();
/*  828 */     this.modifyDate = this.fDate.getDate(aLNPInsuredSchema.getModifyDate());
/*  829 */     this.modifyTime = aLNPInsuredSchema.getModifyTime();
/*  830 */     this.insuredPeoples = aLNPInsuredSchema.getInsuredPeoples();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  839 */       if (rs.getString("GrpContNo") == null)
/*  840 */         this.grpContNo = null;
/*      */       else {
/*  842 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  844 */       if (rs.getString("ContNo") == null)
/*  845 */         this.contNo = null;
/*      */       else {
/*  847 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  849 */       if (rs.getString("ProposalContNo") == null)
/*  850 */         this.proposalContNo = null;
/*      */       else {
/*  852 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  854 */       if (rs.getString("InsuredNo") == null)
/*  855 */         this.insuredNo = null;
/*      */       else {
/*  857 */         this.insuredNo = rs.getString("InsuredNo").trim();
/*      */       }
/*  859 */       if (rs.getString("InsuredId") == null)
/*  860 */         this.insuredId = null;
/*      */       else {
/*  862 */         this.insuredId = rs.getString("InsuredId").trim();
/*      */       }
/*  864 */       if (rs.getString("PrtNo") == null)
/*  865 */         this.prtNo = null;
/*      */       else {
/*  867 */         this.prtNo = rs.getString("PrtNo").trim();
/*      */       }
/*  869 */       if (rs.getString("AppntNo") == null)
/*  870 */         this.appntNo = null;
/*      */       else {
/*  872 */         this.appntNo = rs.getString("AppntNo").trim();
/*      */       }
/*  874 */       if (rs.getString("AppntId") == null)
/*  875 */         this.appntId = null;
/*      */       else {
/*  877 */         this.appntId = rs.getString("AppntId").trim();
/*      */       }
/*  879 */       if (rs.getString("ManageCom") == null)
/*  880 */         this.manageCom = null;
/*      */       else {
/*  882 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  884 */       if (rs.getString("SignCity") == null)
/*  885 */         this.signCity = null;
/*      */       else {
/*  887 */         this.signCity = rs.getString("SignCity").trim();
/*      */       }
/*  889 */       if (rs.getString("ExecuteCom") == null)
/*  890 */         this.executeCom = null;
/*      */       else {
/*  892 */         this.executeCom = rs.getString("ExecuteCom").trim();
/*      */       }
/*  894 */       if (rs.getString("FamilyID") == null)
/*  895 */         this.familyID = null;
/*      */       else {
/*  897 */         this.familyID = rs.getString("FamilyID").trim();
/*      */       }
/*  899 */       if (rs.getString("RelationToMainInsured") == null)
/*  900 */         this.relationToMainInsured = null;
/*      */       else {
/*  902 */         this.relationToMainInsured = rs.getString("RelationToMainInsured").trim();
/*      */       }
/*  904 */       if (rs.getString("RelationToAppnt") == null)
/*  905 */         this.relationToAppnt = null;
/*      */       else {
/*  907 */         this.relationToAppnt = rs.getString("RelationToAppnt").trim();
/*      */       }
/*  909 */       if (rs.getString("AddressNo") == null)
/*  910 */         this.addressNo = null;
/*      */       else {
/*  912 */         this.addressNo = rs.getString("AddressNo").trim();
/*      */       }
/*  914 */       if (rs.getString("SequenceNo") == null)
/*  915 */         this.sequenceNo = null;
/*      */       else {
/*  917 */         this.sequenceNo = rs.getString("SequenceNo").trim();
/*      */       }
/*  919 */       if (rs.getString("Name") == null)
/*  920 */         this.name = null;
/*      */       else {
/*  922 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  924 */       if (rs.getString("Appellation") == null)
/*  925 */         this.appellation = null;
/*      */       else {
/*  927 */         this.appellation = rs.getString("Appellation").trim();
/*      */       }
/*  929 */       if (rs.getString("Sex") == null)
/*  930 */         this.sex = null;
/*      */       else {
/*  932 */         this.sex = rs.getString("Sex").trim();
/*      */       }
/*  934 */       this.birthday = rs.getDate("Birthday");
/*  935 */       this.appAge = rs.getInt("AppAge");
/*  936 */       if (rs.getString("AppAgeType") == null)
/*  937 */         this.appAgeType = null;
/*      */       else {
/*  939 */         this.appAgeType = rs.getString("AppAgeType").trim();
/*      */       }
/*  941 */       if (rs.getString("IDType") == null)
/*  942 */         this.iDType = null;
/*      */       else {
/*  944 */         this.iDType = rs.getString("IDType").trim();
/*      */       }
/*  946 */       if (rs.getString("IDNo") == null)
/*  947 */         this.iDNo = null;
/*      */       else {
/*  949 */         this.iDNo = rs.getString("IDNo").trim();
/*      */       }
/*  951 */       this.iDValidity = rs.getDate("IDValidity");
/*  952 */       if (rs.getString("IDPerpetual") == null)
/*  953 */         this.iDPerpetual = null;
/*      */       else {
/*  955 */         this.iDPerpetual = rs.getString("IDPerpetual").trim();
/*      */       }
/*  957 */       if (rs.getString("NativePlace") == null)
/*  958 */         this.nativePlace = null;
/*      */       else {
/*  960 */         this.nativePlace = rs.getString("NativePlace").trim();
/*      */       }
/*  962 */       if (rs.getString("Nationality") == null)
/*  963 */         this.nationality = null;
/*      */       else {
/*  965 */         this.nationality = rs.getString("Nationality").trim();
/*      */       }
/*  967 */       if (rs.getString("RgtAddress") == null)
/*  968 */         this.rgtAddress = null;
/*      */       else {
/*  970 */         this.rgtAddress = rs.getString("RgtAddress").trim();
/*      */       }
/*  972 */       if (rs.getString("Marriage") == null)
/*  973 */         this.marriage = null;
/*      */       else {
/*  975 */         this.marriage = rs.getString("Marriage").trim();
/*      */       }
/*  977 */       this.marriageDate = rs.getDate("MarriageDate");
/*  978 */       if (rs.getString("Health") == null)
/*  979 */         this.health = null;
/*      */       else {
/*  981 */         this.health = rs.getString("Health").trim();
/*      */       }
/*  983 */       this.stature = rs.getDouble("Stature");
/*  984 */       this.avoirdupois = rs.getDouble("Avoirdupois");
/*  985 */       if (rs.getString("Degree") == null)
/*  986 */         this.degree = null;
/*      */       else {
/*  988 */         this.degree = rs.getString("Degree").trim();
/*      */       }
/*  990 */       if (rs.getString("CreditGrade") == null)
/*  991 */         this.creditGrade = null;
/*      */       else {
/*  993 */         this.creditGrade = rs.getString("CreditGrade").trim();
/*      */       }
/*  995 */       if (rs.getString("BankCode") == null)
/*  996 */         this.bankCode = null;
/*      */       else {
/*  998 */         this.bankCode = rs.getString("BankCode").trim();
/*      */       }
/* 1000 */       if (rs.getString("BankAccNo") == null)
/* 1001 */         this.bankAccNo = null;
/*      */       else {
/* 1003 */         this.bankAccNo = rs.getString("BankAccNo").trim();
/*      */       }
/* 1005 */       if (rs.getString("AccName") == null)
/* 1006 */         this.accName = null;
/*      */       else {
/* 1008 */         this.accName = rs.getString("AccName").trim();
/*      */       }
/* 1010 */       this.joinCompanyDate = rs.getDate("JoinCompanyDate");
/* 1011 */       this.startWorkDate = rs.getDate("StartWorkDate");
/* 1012 */       if (rs.getString("Position") == null)
/* 1013 */         this.position = null;
/*      */       else {
/* 1015 */         this.position = rs.getString("Position").trim();
/*      */       }
/* 1017 */       this.salary = rs.getDouble("Salary");
/* 1018 */       if (rs.getString("OccupationType") == null)
/* 1019 */         this.occupationType = null;
/*      */       else {
/* 1021 */         this.occupationType = rs.getString("OccupationType").trim();
/*      */       }
/* 1023 */       if (rs.getString("OccupationCode") == null)
/* 1024 */         this.occupationCode = null;
/*      */       else {
/* 1026 */         this.occupationCode = rs.getString("OccupationCode").trim();
/*      */       }
/* 1028 */       if (rs.getString("PartOccupationType") == null)
/* 1029 */         this.partOccupationType = null;
/*      */       else {
/* 1031 */         this.partOccupationType = rs.getString("PartOccupationType").trim();
/*      */       }
/* 1033 */       if (rs.getString("PartOccupationCode") == null)
/* 1034 */         this.partOccupationCode = null;
/*      */       else {
/* 1036 */         this.partOccupationCode = rs.getString("PartOccupationCode").trim();
/*      */       }
/* 1038 */       if (rs.getString("WorkType") == null)
/* 1039 */         this.workType = null;
/*      */       else {
/* 1041 */         this.workType = rs.getString("WorkType").trim();
/*      */       }
/* 1043 */       if (rs.getString("PluralityType") == null)
/* 1044 */         this.pluralityType = null;
/*      */       else {
/* 1046 */         this.pluralityType = rs.getString("PluralityType").trim();
/*      */       }
/* 1048 */       if (rs.getString("SmokeFlag") == null)
/* 1049 */         this.smokeFlag = null;
/*      */       else {
/* 1051 */         this.smokeFlag = rs.getString("SmokeFlag").trim();
/*      */       }
/* 1053 */       if (rs.getString("ContPlanCode") == null)
/* 1054 */         this.contPlanCode = null;
/*      */       else {
/* 1056 */         this.contPlanCode = rs.getString("ContPlanCode").trim();
/*      */       }
/* 1058 */       if (rs.getString("Operator") == null)
/* 1059 */         this.operator = null;
/*      */       else {
/* 1061 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/* 1063 */       this.makeDate = rs.getDate("MakeDate");
/* 1064 */       if (rs.getString("MakeTime") == null)
/* 1065 */         this.makeTime = null;
/*      */       else {
/* 1067 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/* 1069 */       this.modifyDate = rs.getDate("ModifyDate");
/* 1070 */       if (rs.getString("ModifyTime") == null)
/* 1071 */         this.modifyTime = null;
/*      */       else {
/* 1073 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/* 1075 */       this.insuredPeoples = rs.getInt("InsuredPeoples");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1079 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPInsured\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/* 1081 */       CError tError = new CError();
/* 1082 */       tError.moduleName = "LNPInsuredSchema";
/* 1083 */       tError.functionName = "setSchema";
/* 1084 */       tError.errorMessage = sqle.toString();
/* 1085 */       this.mErrors.addOneError(tError);
/* 1086 */       return false;
/*      */     }
/* 1088 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInsuredSchema getSchema()
/*      */   {
/* 1093 */     LNPInsuredSchema aLNPInsuredSchema = new LNPInsuredSchema();
/* 1094 */     aLNPInsuredSchema.setSchema(this);
/* 1095 */     return aLNPInsuredSchema;
/*      */   }
/*      */ 
/*      */   public LNPInsuredDB getDB()
/*      */   {
/* 1100 */     LNPInsuredDB aDBOper = new LNPInsuredDB();
/* 1101 */     aDBOper.setSchema(this);
/* 1102 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1109 */     StringBuffer strReturn = new StringBuffer(256);
/* 1110 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/* 1111 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/* 1112 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/* 1113 */     strReturn.append(StrTool.cTrim(this.insuredNo)); strReturn.append("|");
/* 1114 */     strReturn.append(StrTool.cTrim(this.insuredId)); strReturn.append("|");
/* 1115 */     strReturn.append(StrTool.cTrim(this.prtNo)); strReturn.append("|");
/* 1116 */     strReturn.append(StrTool.cTrim(this.appntNo)); strReturn.append("|");
/* 1117 */     strReturn.append(StrTool.cTrim(this.appntId)); strReturn.append("|");
/* 1118 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/* 1119 */     strReturn.append(StrTool.cTrim(this.signCity)); strReturn.append("|");
/* 1120 */     strReturn.append(StrTool.cTrim(this.executeCom)); strReturn.append("|");
/* 1121 */     strReturn.append(StrTool.cTrim(this.familyID)); strReturn.append("|");
/* 1122 */     strReturn.append(StrTool.cTrim(this.relationToMainInsured)); strReturn.append("|");
/* 1123 */     strReturn.append(StrTool.cTrim(this.relationToAppnt)); strReturn.append("|");
/* 1124 */     strReturn.append(StrTool.cTrim(this.addressNo)); strReturn.append("|");
/* 1125 */     strReturn.append(StrTool.cTrim(this.sequenceNo)); strReturn.append("|");
/* 1126 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/* 1127 */     strReturn.append(StrTool.cTrim(this.appellation)); strReturn.append("|");
/* 1128 */     strReturn.append(StrTool.cTrim(this.sex)); strReturn.append("|");
/* 1129 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.birthday))); strReturn.append("|");
/* 1130 */     strReturn.append(ChgData.chgData(this.appAge)); strReturn.append("|");
/* 1131 */     strReturn.append(StrTool.cTrim(this.appAgeType)); strReturn.append("|");
/* 1132 */     strReturn.append(StrTool.cTrim(this.iDType)); strReturn.append("|");
/* 1133 */     strReturn.append(StrTool.cTrim(this.iDNo)); strReturn.append("|");
/* 1134 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.iDValidity))); strReturn.append("|");
/* 1135 */     strReturn.append(StrTool.cTrim(this.iDPerpetual)); strReturn.append("|");
/* 1136 */     strReturn.append(StrTool.cTrim(this.nativePlace)); strReturn.append("|");
/* 1137 */     strReturn.append(StrTool.cTrim(this.nationality)); strReturn.append("|");
/* 1138 */     strReturn.append(StrTool.cTrim(this.rgtAddress)); strReturn.append("|");
/* 1139 */     strReturn.append(StrTool.cTrim(this.marriage)); strReturn.append("|");
/* 1140 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.marriageDate))); strReturn.append("|");
/* 1141 */     strReturn.append(StrTool.cTrim(this.health)); strReturn.append("|");
/* 1142 */     strReturn.append(ChgData.chgData(this.stature)); strReturn.append("|");
/* 1143 */     strReturn.append(ChgData.chgData(this.avoirdupois)); strReturn.append("|");
/* 1144 */     strReturn.append(StrTool.cTrim(this.degree)); strReturn.append("|");
/* 1145 */     strReturn.append(StrTool.cTrim(this.creditGrade)); strReturn.append("|");
/* 1146 */     strReturn.append(StrTool.cTrim(this.bankCode)); strReturn.append("|");
/* 1147 */     strReturn.append(StrTool.cTrim(this.bankAccNo)); strReturn.append("|");
/* 1148 */     strReturn.append(StrTool.cTrim(this.accName)); strReturn.append("|");
/* 1149 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.joinCompanyDate))); strReturn.append("|");
/* 1150 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startWorkDate))); strReturn.append("|");
/* 1151 */     strReturn.append(StrTool.cTrim(this.position)); strReturn.append("|");
/* 1152 */     strReturn.append(ChgData.chgData(this.salary)); strReturn.append("|");
/* 1153 */     strReturn.append(StrTool.cTrim(this.occupationType)); strReturn.append("|");
/* 1154 */     strReturn.append(StrTool.cTrim(this.occupationCode)); strReturn.append("|");
/* 1155 */     strReturn.append(StrTool.cTrim(this.partOccupationType)); strReturn.append("|");
/* 1156 */     strReturn.append(StrTool.cTrim(this.partOccupationCode)); strReturn.append("|");
/* 1157 */     strReturn.append(StrTool.cTrim(this.workType)); strReturn.append("|");
/* 1158 */     strReturn.append(StrTool.cTrim(this.pluralityType)); strReturn.append("|");
/* 1159 */     strReturn.append(StrTool.cTrim(this.smokeFlag)); strReturn.append("|");
/* 1160 */     strReturn.append(StrTool.cTrim(this.contPlanCode)); strReturn.append("|");
/* 1161 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 1162 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 1163 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 1164 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 1165 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/* 1166 */     strReturn.append(ChgData.chgData(this.insuredPeoples));
/* 1167 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1175 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1176 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1177 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1178 */       this.insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1179 */       this.insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1180 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1181 */       this.appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1182 */       this.appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1183 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1184 */       this.signCity = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1185 */       this.executeCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1186 */       this.familyID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1187 */       this.relationToMainInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1188 */       this.relationToAppnt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1189 */       this.addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1190 */       this.sequenceNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1191 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1192 */       this.appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1193 */       this.sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1194 */       this.birthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/* 1195 */       this.appAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|"))).intValue();
/* 1196 */       this.appAgeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 1197 */       this.iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 1198 */       this.iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1199 */       this.iDValidity = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
/* 1200 */       this.iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1201 */       this.nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1202 */       this.nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1203 */       this.rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 1204 */       this.marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1205 */       this.marriageDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|"));
/* 1206 */       this.health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 1207 */       this.stature = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 33, "|"))).doubleValue();
/* 1208 */       this.avoirdupois = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 34, "|"))).doubleValue();
/* 1209 */       this.degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 1210 */       this.creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
/* 1211 */       this.bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 1212 */       this.bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/* 1213 */       this.accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/* 1214 */       this.joinCompanyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|"));
/* 1215 */       this.startWorkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|"));
/* 1216 */       this.position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1217 */       this.salary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 43, "|"))).doubleValue();
/* 1218 */       this.occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1219 */       this.occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 1220 */       this.partOccupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 1221 */       this.partOccupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 1222 */       this.workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 1223 */       this.pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/* 1224 */       this.smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
/* 1225 */       this.contPlanCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
/* 1226 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
/* 1227 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|"));
/* 1228 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
/* 1229 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|"));
/* 1230 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
/* 1231 */       this.insuredPeoples = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|"))).intValue();
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1236 */       CError tError = new CError();
/* 1237 */       tError.moduleName = "LNPInsuredSchema";
/* 1238 */       tError.functionName = "decode";
/* 1239 */       tError.errorMessage = ex.toString();
/* 1240 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1242 */       return false;
/*      */     }
/* 1244 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1250 */     String strReturn = "";
/* 1251 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 1253 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/* 1255 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 1257 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/* 1259 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 1261 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/* 1263 */     if (FCode.equalsIgnoreCase("insuredNo"))
/*      */     {
/* 1265 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredNo));
/*      */     }
/* 1267 */     if (FCode.equalsIgnoreCase("insuredId"))
/*      */     {
/* 1269 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredId));
/*      */     }
/* 1271 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/* 1273 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/* 1275 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/* 1277 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntNo));
/*      */     }
/* 1279 */     if (FCode.equalsIgnoreCase("appntId"))
/*      */     {
/* 1281 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntId));
/*      */     }
/* 1283 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1285 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 1287 */     if (FCode.equalsIgnoreCase("signCity"))
/*      */     {
/* 1289 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signCity));
/*      */     }
/* 1291 */     if (FCode.equalsIgnoreCase("executeCom"))
/*      */     {
/* 1293 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.executeCom));
/*      */     }
/* 1295 */     if (FCode.equalsIgnoreCase("familyID"))
/*      */     {
/* 1297 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.familyID));
/*      */     }
/* 1299 */     if (FCode.equalsIgnoreCase("relationToMainInsured"))
/*      */     {
/* 1301 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relationToMainInsured));
/*      */     }
/* 1303 */     if (FCode.equalsIgnoreCase("relationToAppnt"))
/*      */     {
/* 1305 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relationToAppnt));
/*      */     }
/* 1307 */     if (FCode.equalsIgnoreCase("addressNo"))
/*      */     {
/* 1309 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addressNo));
/*      */     }
/* 1311 */     if (FCode.equalsIgnoreCase("sequenceNo"))
/*      */     {
/* 1313 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sequenceNo));
/*      */     }
/* 1315 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/* 1317 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/* 1319 */     if (FCode.equalsIgnoreCase("appellation"))
/*      */     {
/* 1321 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appellation));
/*      */     }
/* 1323 */     if (FCode.equalsIgnoreCase("sex"))
/*      */     {
/* 1325 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sex));
/*      */     }
/* 1327 */     if (FCode.equalsIgnoreCase("birthday"))
/*      */     {
/* 1329 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
/*      */     }
/* 1331 */     if (FCode.equalsIgnoreCase("appAge"))
/*      */     {
/* 1333 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appAge));
/*      */     }
/* 1335 */     if (FCode.equalsIgnoreCase("appAgeType"))
/*      */     {
/* 1337 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appAgeType));
/*      */     }
/* 1339 */     if (FCode.equalsIgnoreCase("iDType"))
/*      */     {
/* 1341 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDType));
/*      */     }
/* 1343 */     if (FCode.equalsIgnoreCase("iDNo"))
/*      */     {
/* 1345 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDNo));
/*      */     }
/* 1347 */     if (FCode.equalsIgnoreCase("iDValidity"))
/*      */     {
/* 1349 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getIDValidity()));
/*      */     }
/* 1351 */     if (FCode.equalsIgnoreCase("iDPerpetual"))
/*      */     {
/* 1353 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDPerpetual));
/*      */     }
/* 1355 */     if (FCode.equalsIgnoreCase("nativePlace"))
/*      */     {
/* 1357 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nativePlace));
/*      */     }
/* 1359 */     if (FCode.equalsIgnoreCase("nationality"))
/*      */     {
/* 1361 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nationality));
/*      */     }
/* 1363 */     if (FCode.equalsIgnoreCase("rgtAddress"))
/*      */     {
/* 1365 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rgtAddress));
/*      */     }
/* 1367 */     if (FCode.equalsIgnoreCase("marriage"))
/*      */     {
/* 1369 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.marriage));
/*      */     }
/* 1371 */     if (FCode.equalsIgnoreCase("marriageDate"))
/*      */     {
/* 1373 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
/*      */     }
/* 1375 */     if (FCode.equalsIgnoreCase("health"))
/*      */     {
/* 1377 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.health));
/*      */     }
/* 1379 */     if (FCode.equalsIgnoreCase("stature"))
/*      */     {
/* 1381 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stature));
/*      */     }
/* 1383 */     if (FCode.equalsIgnoreCase("avoirdupois"))
/*      */     {
/* 1385 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.avoirdupois));
/*      */     }
/* 1387 */     if (FCode.equalsIgnoreCase("degree"))
/*      */     {
/* 1389 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.degree));
/*      */     }
/* 1391 */     if (FCode.equalsIgnoreCase("creditGrade"))
/*      */     {
/* 1393 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.creditGrade));
/*      */     }
/* 1395 */     if (FCode.equalsIgnoreCase("bankCode"))
/*      */     {
/* 1397 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankCode));
/*      */     }
/* 1399 */     if (FCode.equalsIgnoreCase("bankAccNo"))
/*      */     {
/* 1401 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankAccNo));
/*      */     }
/* 1403 */     if (FCode.equalsIgnoreCase("accName"))
/*      */     {
/* 1405 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.accName));
/*      */     }
/* 1407 */     if (FCode.equalsIgnoreCase("joinCompanyDate"))
/*      */     {
/* 1409 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
/*      */     }
/* 1411 */     if (FCode.equalsIgnoreCase("startWorkDate"))
/*      */     {
/* 1413 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
/*      */     }
/* 1415 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/* 1417 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.position));
/*      */     }
/* 1419 */     if (FCode.equalsIgnoreCase("salary"))
/*      */     {
/* 1421 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.salary));
/*      */     }
/* 1423 */     if (FCode.equalsIgnoreCase("occupationType"))
/*      */     {
/* 1425 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationType));
/*      */     }
/* 1427 */     if (FCode.equalsIgnoreCase("occupationCode"))
/*      */     {
/* 1429 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationCode));
/*      */     }
/* 1431 */     if (FCode.equalsIgnoreCase("partOccupationType"))
/*      */     {
/* 1433 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.partOccupationType));
/*      */     }
/* 1435 */     if (FCode.equalsIgnoreCase("partOccupationCode"))
/*      */     {
/* 1437 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.partOccupationCode));
/*      */     }
/* 1439 */     if (FCode.equalsIgnoreCase("workType"))
/*      */     {
/* 1441 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.workType));
/*      */     }
/* 1443 */     if (FCode.equalsIgnoreCase("pluralityType"))
/*      */     {
/* 1445 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pluralityType));
/*      */     }
/* 1447 */     if (FCode.equalsIgnoreCase("smokeFlag"))
/*      */     {
/* 1449 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.smokeFlag));
/*      */     }
/* 1451 */     if (FCode.equalsIgnoreCase("contPlanCode"))
/*      */     {
/* 1453 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contPlanCode));
/*      */     }
/* 1455 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1457 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1459 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1461 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 1463 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1465 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1467 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1469 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 1471 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1473 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1475 */     if (FCode.equalsIgnoreCase("insuredPeoples"))
/*      */     {
/* 1477 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredPeoples));
/*      */     }
/* 1479 */     if (strReturn.equals(""))
/*      */     {
/* 1481 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1484 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1491 */     String strFieldValue = "";
/* 1492 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1494 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/* 1495 */       break;
/*      */     case 1:
/* 1497 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 1498 */       break;
/*      */     case 2:
/* 1500 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/* 1501 */       break;
/*      */     case 3:
/* 1503 */       strFieldValue = StrTool.GBKToUnicode(this.insuredNo);
/* 1504 */       break;
/*      */     case 4:
/* 1506 */       strFieldValue = StrTool.GBKToUnicode(this.insuredId);
/* 1507 */       break;
/*      */     case 5:
/* 1509 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/* 1510 */       break;
/*      */     case 6:
/* 1512 */       strFieldValue = StrTool.GBKToUnicode(this.appntNo);
/* 1513 */       break;
/*      */     case 7:
/* 1515 */       strFieldValue = StrTool.GBKToUnicode(this.appntId);
/* 1516 */       break;
/*      */     case 8:
/* 1518 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1519 */       break;
/*      */     case 9:
/* 1521 */       strFieldValue = StrTool.GBKToUnicode(this.signCity);
/* 1522 */       break;
/*      */     case 10:
/* 1524 */       strFieldValue = StrTool.GBKToUnicode(this.executeCom);
/* 1525 */       break;
/*      */     case 11:
/* 1527 */       strFieldValue = StrTool.GBKToUnicode(this.familyID);
/* 1528 */       break;
/*      */     case 12:
/* 1530 */       strFieldValue = StrTool.GBKToUnicode(this.relationToMainInsured);
/* 1531 */       break;
/*      */     case 13:
/* 1533 */       strFieldValue = StrTool.GBKToUnicode(this.relationToAppnt);
/* 1534 */       break;
/*      */     case 14:
/* 1536 */       strFieldValue = StrTool.GBKToUnicode(this.addressNo);
/* 1537 */       break;
/*      */     case 15:
/* 1539 */       strFieldValue = StrTool.GBKToUnicode(this.sequenceNo);
/* 1540 */       break;
/*      */     case 16:
/* 1542 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/* 1543 */       break;
/*      */     case 17:
/* 1545 */       strFieldValue = StrTool.GBKToUnicode(this.appellation);
/* 1546 */       break;
/*      */     case 18:
/* 1548 */       strFieldValue = StrTool.GBKToUnicode(this.sex);
/* 1549 */       break;
/*      */     case 19:
/* 1551 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
/* 1552 */       break;
/*      */     case 20:
/* 1554 */       strFieldValue = String.valueOf(this.appAge);
/* 1555 */       break;
/*      */     case 21:
/* 1557 */       strFieldValue = StrTool.GBKToUnicode(this.appAgeType);
/* 1558 */       break;
/*      */     case 22:
/* 1560 */       strFieldValue = StrTool.GBKToUnicode(this.iDType);
/* 1561 */       break;
/*      */     case 23:
/* 1563 */       strFieldValue = StrTool.GBKToUnicode(this.iDNo);
/* 1564 */       break;
/*      */     case 24:
/* 1566 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getIDValidity()));
/* 1567 */       break;
/*      */     case 25:
/* 1569 */       strFieldValue = StrTool.GBKToUnicode(this.iDPerpetual);
/* 1570 */       break;
/*      */     case 26:
/* 1572 */       strFieldValue = StrTool.GBKToUnicode(this.nativePlace);
/* 1573 */       break;
/*      */     case 27:
/* 1575 */       strFieldValue = StrTool.GBKToUnicode(this.nationality);
/* 1576 */       break;
/*      */     case 28:
/* 1578 */       strFieldValue = StrTool.GBKToUnicode(this.rgtAddress);
/* 1579 */       break;
/*      */     case 29:
/* 1581 */       strFieldValue = StrTool.GBKToUnicode(this.marriage);
/* 1582 */       break;
/*      */     case 30:
/* 1584 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
/* 1585 */       break;
/*      */     case 31:
/* 1587 */       strFieldValue = StrTool.GBKToUnicode(this.health);
/* 1588 */       break;
/*      */     case 32:
/* 1590 */       strFieldValue = String.valueOf(this.stature);
/* 1591 */       break;
/*      */     case 33:
/* 1593 */       strFieldValue = String.valueOf(this.avoirdupois);
/* 1594 */       break;
/*      */     case 34:
/* 1596 */       strFieldValue = StrTool.GBKToUnicode(this.degree);
/* 1597 */       break;
/*      */     case 35:
/* 1599 */       strFieldValue = StrTool.GBKToUnicode(this.creditGrade);
/* 1600 */       break;
/*      */     case 36:
/* 1602 */       strFieldValue = StrTool.GBKToUnicode(this.bankCode);
/* 1603 */       break;
/*      */     case 37:
/* 1605 */       strFieldValue = StrTool.GBKToUnicode(this.bankAccNo);
/* 1606 */       break;
/*      */     case 38:
/* 1608 */       strFieldValue = StrTool.GBKToUnicode(this.accName);
/* 1609 */       break;
/*      */     case 39:
/* 1611 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
/* 1612 */       break;
/*      */     case 40:
/* 1614 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
/* 1615 */       break;
/*      */     case 41:
/* 1617 */       strFieldValue = StrTool.GBKToUnicode(this.position);
/* 1618 */       break;
/*      */     case 42:
/* 1620 */       strFieldValue = String.valueOf(this.salary);
/* 1621 */       break;
/*      */     case 43:
/* 1623 */       strFieldValue = StrTool.GBKToUnicode(this.occupationType);
/* 1624 */       break;
/*      */     case 44:
/* 1626 */       strFieldValue = StrTool.GBKToUnicode(this.occupationCode);
/* 1627 */       break;
/*      */     case 45:
/* 1629 */       strFieldValue = StrTool.GBKToUnicode(this.partOccupationType);
/* 1630 */       break;
/*      */     case 46:
/* 1632 */       strFieldValue = StrTool.GBKToUnicode(this.partOccupationCode);
/* 1633 */       break;
/*      */     case 47:
/* 1635 */       strFieldValue = StrTool.GBKToUnicode(this.workType);
/* 1636 */       break;
/*      */     case 48:
/* 1638 */       strFieldValue = StrTool.GBKToUnicode(this.pluralityType);
/* 1639 */       break;
/*      */     case 49:
/* 1641 */       strFieldValue = StrTool.GBKToUnicode(this.smokeFlag);
/* 1642 */       break;
/*      */     case 50:
/* 1644 */       strFieldValue = StrTool.GBKToUnicode(this.contPlanCode);
/* 1645 */       break;
/*      */     case 51:
/* 1647 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1648 */       break;
/*      */     case 52:
/* 1650 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1651 */       break;
/*      */     case 53:
/* 1653 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1654 */       break;
/*      */     case 54:
/* 1656 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1657 */       break;
/*      */     case 55:
/* 1659 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1660 */       break;
/*      */     case 56:
/* 1662 */       strFieldValue = String.valueOf(this.insuredPeoples);
/* 1663 */       break;
/*      */     default:
/* 1665 */       strFieldValue = "";
/*      */     }
/* 1667 */     if (strFieldValue.equals("")) {
/* 1668 */       strFieldValue = "null";
/*      */     }
/* 1670 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1676 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1677 */       return false;
/*      */     }
/* 1679 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 1681 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1683 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1686 */         this.grpContNo = null;
/*      */     }
/* 1688 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 1690 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1692 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 1695 */         this.contNo = null;
/*      */     }
/* 1697 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 1699 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1701 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1704 */         this.proposalContNo = null;
/*      */     }
/* 1706 */     if (FCode.equalsIgnoreCase("insuredNo"))
/*      */     {
/* 1708 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1710 */         this.insuredNo = FValue.trim();
/*      */       }
/*      */       else
/* 1713 */         this.insuredNo = null;
/*      */     }
/* 1715 */     if (FCode.equalsIgnoreCase("insuredId"))
/*      */     {
/* 1717 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1719 */         this.insuredId = FValue.trim();
/*      */       }
/*      */       else
/* 1722 */         this.insuredId = null;
/*      */     }
/* 1724 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/* 1726 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1728 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/* 1731 */         this.prtNo = null;
/*      */     }
/* 1733 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/* 1735 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1737 */         this.appntNo = FValue.trim();
/*      */       }
/*      */       else
/* 1740 */         this.appntNo = null;
/*      */     }
/* 1742 */     if (FCode.equalsIgnoreCase("appntId"))
/*      */     {
/* 1744 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1746 */         this.appntId = FValue.trim();
/*      */       }
/*      */       else
/* 1749 */         this.appntId = null;
/*      */     }
/* 1751 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1753 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1755 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1758 */         this.manageCom = null;
/*      */     }
/* 1760 */     if (FCode.equalsIgnoreCase("signCity"))
/*      */     {
/* 1762 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1764 */         this.signCity = FValue.trim();
/*      */       }
/*      */       else
/* 1767 */         this.signCity = null;
/*      */     }
/* 1769 */     if (FCode.equalsIgnoreCase("executeCom"))
/*      */     {
/* 1771 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1773 */         this.executeCom = FValue.trim();
/*      */       }
/*      */       else
/* 1776 */         this.executeCom = null;
/*      */     }
/* 1778 */     if (FCode.equalsIgnoreCase("familyID"))
/*      */     {
/* 1780 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1782 */         this.familyID = FValue.trim();
/*      */       }
/*      */       else
/* 1785 */         this.familyID = null;
/*      */     }
/* 1787 */     if (FCode.equalsIgnoreCase("relationToMainInsured"))
/*      */     {
/* 1789 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1791 */         this.relationToMainInsured = FValue.trim();
/*      */       }
/*      */       else
/* 1794 */         this.relationToMainInsured = null;
/*      */     }
/* 1796 */     if (FCode.equalsIgnoreCase("relationToAppnt"))
/*      */     {
/* 1798 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1800 */         this.relationToAppnt = FValue.trim();
/*      */       }
/*      */       else
/* 1803 */         this.relationToAppnt = null;
/*      */     }
/* 1805 */     if (FCode.equalsIgnoreCase("addressNo"))
/*      */     {
/* 1807 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1809 */         this.addressNo = FValue.trim();
/*      */       }
/*      */       else
/* 1812 */         this.addressNo = null;
/*      */     }
/* 1814 */     if (FCode.equalsIgnoreCase("sequenceNo"))
/*      */     {
/* 1816 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1818 */         this.sequenceNo = FValue.trim();
/*      */       }
/*      */       else
/* 1821 */         this.sequenceNo = null;
/*      */     }
/* 1823 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/* 1825 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1827 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/* 1830 */         this.name = null;
/*      */     }
/* 1832 */     if (FCode.equalsIgnoreCase("appellation"))
/*      */     {
/* 1834 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1836 */         this.appellation = FValue.trim();
/*      */       }
/*      */       else
/* 1839 */         this.appellation = null;
/*      */     }
/* 1841 */     if (FCode.equalsIgnoreCase("sex"))
/*      */     {
/* 1843 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1845 */         this.sex = FValue.trim();
/*      */       }
/*      */       else
/* 1848 */         this.sex = null;
/*      */     }
/* 1850 */     if (FCode.equalsIgnoreCase("birthday"))
/*      */     {
/* 1852 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1854 */         this.birthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1857 */         this.birthday = null;
/*      */     }
/* 1859 */     if (FCode.equalsIgnoreCase("appAge"))
/*      */     {
/* 1861 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1863 */         Integer tInteger = new Integer(FValue);
/* 1864 */         int i = tInteger.intValue();
/* 1865 */         this.appAge = i;
/*      */       }
/*      */     }
/* 1868 */     if (FCode.equalsIgnoreCase("appAgeType"))
/*      */     {
/* 1870 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1872 */         this.appAgeType = FValue.trim();
/*      */       }
/*      */       else
/* 1875 */         this.appAgeType = null;
/*      */     }
/* 1877 */     if (FCode.equalsIgnoreCase("iDType"))
/*      */     {
/* 1879 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1881 */         this.iDType = FValue.trim();
/*      */       }
/*      */       else
/* 1884 */         this.iDType = null;
/*      */     }
/* 1886 */     if (FCode.equalsIgnoreCase("iDNo"))
/*      */     {
/* 1888 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1890 */         this.iDNo = FValue.trim();
/*      */       }
/*      */       else
/* 1893 */         this.iDNo = null;
/*      */     }
/* 1895 */     if (FCode.equalsIgnoreCase("iDValidity"))
/*      */     {
/* 1897 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1899 */         this.iDValidity = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1902 */         this.iDValidity = null;
/*      */     }
/* 1904 */     if (FCode.equalsIgnoreCase("iDPerpetual"))
/*      */     {
/* 1906 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1908 */         this.iDPerpetual = FValue.trim();
/*      */       }
/*      */       else
/* 1911 */         this.iDPerpetual = null;
/*      */     }
/* 1913 */     if (FCode.equalsIgnoreCase("nativePlace"))
/*      */     {
/* 1915 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1917 */         this.nativePlace = FValue.trim();
/*      */       }
/*      */       else
/* 1920 */         this.nativePlace = null;
/*      */     }
/* 1922 */     if (FCode.equalsIgnoreCase("nationality"))
/*      */     {
/* 1924 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1926 */         this.nationality = FValue.trim();
/*      */       }
/*      */       else
/* 1929 */         this.nationality = null;
/*      */     }
/* 1931 */     if (FCode.equalsIgnoreCase("rgtAddress"))
/*      */     {
/* 1933 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1935 */         this.rgtAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1938 */         this.rgtAddress = null;
/*      */     }
/* 1940 */     if (FCode.equalsIgnoreCase("marriage"))
/*      */     {
/* 1942 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1944 */         this.marriage = FValue.trim();
/*      */       }
/*      */       else
/* 1947 */         this.marriage = null;
/*      */     }
/* 1949 */     if (FCode.equalsIgnoreCase("marriageDate"))
/*      */     {
/* 1951 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1953 */         this.marriageDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1956 */         this.marriageDate = null;
/*      */     }
/* 1958 */     if (FCode.equalsIgnoreCase("health"))
/*      */     {
/* 1960 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1962 */         this.health = FValue.trim();
/*      */       }
/*      */       else
/* 1965 */         this.health = null;
/*      */     }
/* 1967 */     if (FCode.equalsIgnoreCase("stature"))
/*      */     {
/* 1969 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1971 */         Double tDouble = new Double(FValue);
/* 1972 */         double d = tDouble.doubleValue();
/* 1973 */         this.stature = d;
/*      */       }
/*      */     }
/* 1976 */     if (FCode.equalsIgnoreCase("avoirdupois"))
/*      */     {
/* 1978 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1980 */         Double tDouble = new Double(FValue);
/* 1981 */         double d = tDouble.doubleValue();
/* 1982 */         this.avoirdupois = d;
/*      */       }
/*      */     }
/* 1985 */     if (FCode.equalsIgnoreCase("degree"))
/*      */     {
/* 1987 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1989 */         this.degree = FValue.trim();
/*      */       }
/*      */       else
/* 1992 */         this.degree = null;
/*      */     }
/* 1994 */     if (FCode.equalsIgnoreCase("creditGrade"))
/*      */     {
/* 1996 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1998 */         this.creditGrade = FValue.trim();
/*      */       }
/*      */       else
/* 2001 */         this.creditGrade = null;
/*      */     }
/* 2003 */     if (FCode.equalsIgnoreCase("bankCode"))
/*      */     {
/* 2005 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2007 */         this.bankCode = FValue.trim();
/*      */       }
/*      */       else
/* 2010 */         this.bankCode = null;
/*      */     }
/* 2012 */     if (FCode.equalsIgnoreCase("bankAccNo"))
/*      */     {
/* 2014 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2016 */         this.bankAccNo = FValue.trim();
/*      */       }
/*      */       else
/* 2019 */         this.bankAccNo = null;
/*      */     }
/* 2021 */     if (FCode.equalsIgnoreCase("accName"))
/*      */     {
/* 2023 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2025 */         this.accName = FValue.trim();
/*      */       }
/*      */       else
/* 2028 */         this.accName = null;
/*      */     }
/* 2030 */     if (FCode.equalsIgnoreCase("joinCompanyDate"))
/*      */     {
/* 2032 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2034 */         this.joinCompanyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2037 */         this.joinCompanyDate = null;
/*      */     }
/* 2039 */     if (FCode.equalsIgnoreCase("startWorkDate"))
/*      */     {
/* 2041 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2043 */         this.startWorkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2046 */         this.startWorkDate = null;
/*      */     }
/* 2048 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/* 2050 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2052 */         this.position = FValue.trim();
/*      */       }
/*      */       else
/* 2055 */         this.position = null;
/*      */     }
/* 2057 */     if (FCode.equalsIgnoreCase("salary"))
/*      */     {
/* 2059 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2061 */         Double tDouble = new Double(FValue);
/* 2062 */         double d = tDouble.doubleValue();
/* 2063 */         this.salary = d;
/*      */       }
/*      */     }
/* 2066 */     if (FCode.equalsIgnoreCase("occupationType"))
/*      */     {
/* 2068 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2070 */         this.occupationType = FValue.trim();
/*      */       }
/*      */       else
/* 2073 */         this.occupationType = null;
/*      */     }
/* 2075 */     if (FCode.equalsIgnoreCase("occupationCode"))
/*      */     {
/* 2077 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2079 */         this.occupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 2082 */         this.occupationCode = null;
/*      */     }
/* 2084 */     if (FCode.equalsIgnoreCase("partOccupationType"))
/*      */     {
/* 2086 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2088 */         this.partOccupationType = FValue.trim();
/*      */       }
/*      */       else
/* 2091 */         this.partOccupationType = null;
/*      */     }
/* 2093 */     if (FCode.equalsIgnoreCase("partOccupationCode"))
/*      */     {
/* 2095 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2097 */         this.partOccupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 2100 */         this.partOccupationCode = null;
/*      */     }
/* 2102 */     if (FCode.equalsIgnoreCase("workType"))
/*      */     {
/* 2104 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2106 */         this.workType = FValue.trim();
/*      */       }
/*      */       else
/* 2109 */         this.workType = null;
/*      */     }
/* 2111 */     if (FCode.equalsIgnoreCase("pluralityType"))
/*      */     {
/* 2113 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2115 */         this.pluralityType = FValue.trim();
/*      */       }
/*      */       else
/* 2118 */         this.pluralityType = null;
/*      */     }
/* 2120 */     if (FCode.equalsIgnoreCase("smokeFlag"))
/*      */     {
/* 2122 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2124 */         this.smokeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2127 */         this.smokeFlag = null;
/*      */     }
/* 2129 */     if (FCode.equalsIgnoreCase("contPlanCode"))
/*      */     {
/* 2131 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2133 */         this.contPlanCode = FValue.trim();
/*      */       }
/*      */       else
/* 2136 */         this.contPlanCode = null;
/*      */     }
/* 2138 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 2140 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2142 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 2145 */         this.operator = null;
/*      */     }
/* 2147 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 2149 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2151 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2154 */         this.makeDate = null;
/*      */     }
/* 2156 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 2158 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2160 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 2163 */         this.makeTime = null;
/*      */     }
/* 2165 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 2167 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2169 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2172 */         this.modifyDate = null;
/*      */     }
/* 2174 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 2176 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2178 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 2181 */         this.modifyTime = null;
/*      */     }
/* 2183 */     if (FCode.equalsIgnoreCase("insuredPeoples"))
/*      */     {
/* 2185 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2187 */         Integer tInteger = new Integer(FValue);
/* 2188 */         int i = tInteger.intValue();
/* 2189 */         this.insuredPeoples = i;
/*      */       }
/*      */     }
/* 2192 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 2197 */     if (otherObject == null) return false;
/* 2198 */     if (this == otherObject) return true;
/* 2199 */     if (getClass() != otherObject.getClass()) return false;
/* 2200 */     LNPInsuredSchema other = (LNPInsuredSchema)otherObject;
/* 2201 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/* 2202 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/* 2203 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/* 2204 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/* 2205 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/* 2206 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/* 2207 */     if ((this.insuredNo == null) && (other.getInsuredNo() != null)) return false;
/* 2208 */     if ((this.insuredNo != null) && (!this.insuredNo.equals(other.getInsuredNo()))) return false;
/* 2209 */     if ((this.insuredId == null) && (other.getInsuredId() != null)) return false;
/* 2210 */     if ((this.insuredId != null) && (!this.insuredId.equals(other.getInsuredId()))) return false;
/* 2211 */     if ((this.prtNo == null) && (other.getPrtNo() != null)) return false;
/* 2212 */     if ((this.prtNo != null) && (!this.prtNo.equals(other.getPrtNo()))) return false;
/* 2213 */     if ((this.appntNo == null) && (other.getAppntNo() != null)) return false;
/* 2214 */     if ((this.appntNo != null) && (!this.appntNo.equals(other.getAppntNo()))) return false;
/* 2215 */     if ((this.appntId == null) && (other.getAppntId() != null)) return false;
/* 2216 */     if ((this.appntId != null) && (!this.appntId.equals(other.getAppntId()))) return false;
/* 2217 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 2218 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 2219 */     if ((this.signCity == null) && (other.getSignCity() != null)) return false;
/* 2220 */     if ((this.signCity != null) && (!this.signCity.equals(other.getSignCity()))) return false;
/* 2221 */     if ((this.executeCom == null) && (other.getExecuteCom() != null)) return false;
/* 2222 */     if ((this.executeCom != null) && (!this.executeCom.equals(other.getExecuteCom()))) return false;
/* 2223 */     if ((this.familyID == null) && (other.getFamilyID() != null)) return false;
/* 2224 */     if ((this.familyID != null) && (!this.familyID.equals(other.getFamilyID()))) return false;
/* 2225 */     if ((this.relationToMainInsured == null) && (other.getRelationToMainInsured() != null)) return false;
/* 2226 */     if ((this.relationToMainInsured != null) && (!this.relationToMainInsured.equals(other.getRelationToMainInsured()))) return false;
/* 2227 */     if ((this.relationToAppnt == null) && (other.getRelationToAppnt() != null)) return false;
/* 2228 */     if ((this.relationToAppnt != null) && (!this.relationToAppnt.equals(other.getRelationToAppnt()))) return false;
/* 2229 */     if ((this.addressNo == null) && (other.getAddressNo() != null)) return false;
/* 2230 */     if ((this.addressNo != null) && (!this.addressNo.equals(other.getAddressNo()))) return false;
/* 2231 */     if ((this.sequenceNo == null) && (other.getSequenceNo() != null)) return false;
/* 2232 */     if ((this.sequenceNo != null) && (!this.sequenceNo.equals(other.getSequenceNo()))) return false;
/* 2233 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 2234 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 2235 */     if ((this.appellation == null) && (other.getAppellation() != null)) return false;
/* 2236 */     if ((this.appellation != null) && (!this.appellation.equals(other.getAppellation()))) return false;
/* 2237 */     if ((this.sex == null) && (other.getSex() != null)) return false;
/* 2238 */     if ((this.sex != null) && (!this.sex.equals(other.getSex()))) return false;
/* 2239 */     if ((this.birthday == null) && (other.getBirthday() != null)) return false;
/* 2240 */     if ((this.birthday != null) && (!this.fDate.getString(this.birthday).equals(other.getBirthday()))) return false;
/* 2241 */     if (this.appAge != other.getAppAge()) return false;
/* 2242 */     if ((this.appAgeType == null) && (other.getAppAgeType() != null)) return false;
/* 2243 */     if ((this.appAgeType != null) && (!this.appAgeType.equals(other.getAppAgeType()))) return false;
/* 2244 */     if ((this.iDType == null) && (other.getIDType() != null)) return false;
/* 2245 */     if ((this.iDType != null) && (!this.iDType.equals(other.getIDType()))) return false;
/* 2246 */     if ((this.iDNo == null) && (other.getIDNo() != null)) return false;
/* 2247 */     if ((this.iDNo != null) && (!this.iDNo.equals(other.getIDNo()))) return false;
/* 2248 */     if ((this.iDValidity == null) && (other.getIDValidity() != null)) return false;
/* 2249 */     if ((this.iDValidity != null) && (!this.fDate.getString(this.iDValidity).equals(other.getIDValidity()))) return false;
/* 2250 */     if ((this.iDPerpetual == null) && (other.getIDPerpetual() != null)) return false;
/* 2251 */     if ((this.iDPerpetual != null) && (!this.iDPerpetual.equals(other.getIDPerpetual()))) return false;
/* 2252 */     if ((this.nativePlace == null) && (other.getNativePlace() != null)) return false;
/* 2253 */     if ((this.nativePlace != null) && (!this.nativePlace.equals(other.getNativePlace()))) return false;
/* 2254 */     if ((this.nationality == null) && (other.getNationality() != null)) return false;
/* 2255 */     if ((this.nationality != null) && (!this.nationality.equals(other.getNationality()))) return false;
/* 2256 */     if ((this.rgtAddress == null) && (other.getRgtAddress() != null)) return false;
/* 2257 */     if ((this.rgtAddress != null) && (!this.rgtAddress.equals(other.getRgtAddress()))) return false;
/* 2258 */     if ((this.marriage == null) && (other.getMarriage() != null)) return false;
/* 2259 */     if ((this.marriage != null) && (!this.marriage.equals(other.getMarriage()))) return false;
/* 2260 */     if ((this.marriageDate == null) && (other.getMarriageDate() != null)) return false;
/* 2261 */     if ((this.marriageDate != null) && (!this.fDate.getString(this.marriageDate).equals(other.getMarriageDate()))) return false;
/* 2262 */     if ((this.health == null) && (other.getHealth() != null)) return false;
/* 2263 */     if ((this.health != null) && (!this.health.equals(other.getHealth()))) return false;
/* 2264 */     if (Double.doubleToLongBits(this.stature) != Double.doubleToLongBits(other.getStature())) return false;
/* 2265 */     if (Double.doubleToLongBits(this.avoirdupois) != Double.doubleToLongBits(other.getAvoirdupois())) return false;
/* 2266 */     if ((this.degree == null) && (other.getDegree() != null)) return false;
/* 2267 */     if ((this.degree != null) && (!this.degree.equals(other.getDegree()))) return false;
/* 2268 */     if ((this.creditGrade == null) && (other.getCreditGrade() != null)) return false;
/* 2269 */     if ((this.creditGrade != null) && (!this.creditGrade.equals(other.getCreditGrade()))) return false;
/* 2270 */     if ((this.bankCode == null) && (other.getBankCode() != null)) return false;
/* 2271 */     if ((this.bankCode != null) && (!this.bankCode.equals(other.getBankCode()))) return false;
/* 2272 */     if ((this.bankAccNo == null) && (other.getBankAccNo() != null)) return false;
/* 2273 */     if ((this.bankAccNo != null) && (!this.bankAccNo.equals(other.getBankAccNo()))) return false;
/* 2274 */     if ((this.accName == null) && (other.getAccName() != null)) return false;
/* 2275 */     if ((this.accName != null) && (!this.accName.equals(other.getAccName()))) return false;
/* 2276 */     if ((this.joinCompanyDate == null) && (other.getJoinCompanyDate() != null)) return false;
/* 2277 */     if ((this.joinCompanyDate != null) && (!this.fDate.getString(this.joinCompanyDate).equals(other.getJoinCompanyDate()))) return false;
/* 2278 */     if ((this.startWorkDate == null) && (other.getStartWorkDate() != null)) return false;
/* 2279 */     if ((this.startWorkDate != null) && (!this.fDate.getString(this.startWorkDate).equals(other.getStartWorkDate()))) return false;
/* 2280 */     if ((this.position == null) && (other.getPosition() != null)) return false;
/* 2281 */     if ((this.position != null) && (!this.position.equals(other.getPosition()))) return false;
/* 2282 */     if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.getSalary())) return false;
/* 2283 */     if ((this.occupationType == null) && (other.getOccupationType() != null)) return false;
/* 2284 */     if ((this.occupationType != null) && (!this.occupationType.equals(other.getOccupationType()))) return false;
/* 2285 */     if ((this.occupationCode == null) && (other.getOccupationCode() != null)) return false;
/* 2286 */     if ((this.occupationCode != null) && (!this.occupationCode.equals(other.getOccupationCode()))) return false;
/* 2287 */     if ((this.partOccupationType == null) && (other.getPartOccupationType() != null)) return false;
/* 2288 */     if ((this.partOccupationType != null) && (!this.partOccupationType.equals(other.getPartOccupationType()))) return false;
/* 2289 */     if ((this.partOccupationCode == null) && (other.getPartOccupationCode() != null)) return false;
/* 2290 */     if ((this.partOccupationCode != null) && (!this.partOccupationCode.equals(other.getPartOccupationCode()))) return false;
/* 2291 */     if ((this.workType == null) && (other.getWorkType() != null)) return false;
/* 2292 */     if ((this.workType != null) && (!this.workType.equals(other.getWorkType()))) return false;
/* 2293 */     if ((this.pluralityType == null) && (other.getPluralityType() != null)) return false;
/* 2294 */     if ((this.pluralityType != null) && (!this.pluralityType.equals(other.getPluralityType()))) return false;
/* 2295 */     if ((this.smokeFlag == null) && (other.getSmokeFlag() != null)) return false;
/* 2296 */     if ((this.smokeFlag != null) && (!this.smokeFlag.equals(other.getSmokeFlag()))) return false;
/* 2297 */     if ((this.contPlanCode == null) && (other.getContPlanCode() != null)) return false;
/* 2298 */     if ((this.contPlanCode != null) && (!this.contPlanCode.equals(other.getContPlanCode()))) return false;
/* 2299 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 2300 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 2301 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 2302 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 2303 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 2304 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 2305 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 2306 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 2307 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 2308 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 2309 */     return this.insuredPeoples == other.getInsuredPeoples();
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2316 */     return 57;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2322 */     if (strFieldName.equals("grpContNo")) {
/* 2323 */       return 0;
/*      */     }
/* 2325 */     if (strFieldName.equals("contNo")) {
/* 2326 */       return 1;
/*      */     }
/* 2328 */     if (strFieldName.equals("proposalContNo")) {
/* 2329 */       return 2;
/*      */     }
/* 2331 */     if (strFieldName.equals("insuredNo")) {
/* 2332 */       return 3;
/*      */     }
/* 2334 */     if (strFieldName.equals("insuredId")) {
/* 2335 */       return 4;
/*      */     }
/* 2337 */     if (strFieldName.equals("prtNo")) {
/* 2338 */       return 5;
/*      */     }
/* 2340 */     if (strFieldName.equals("appntNo")) {
/* 2341 */       return 6;
/*      */     }
/* 2343 */     if (strFieldName.equals("appntId")) {
/* 2344 */       return 7;
/*      */     }
/* 2346 */     if (strFieldName.equals("manageCom")) {
/* 2347 */       return 8;
/*      */     }
/* 2349 */     if (strFieldName.equals("signCity")) {
/* 2350 */       return 9;
/*      */     }
/* 2352 */     if (strFieldName.equals("executeCom")) {
/* 2353 */       return 10;
/*      */     }
/* 2355 */     if (strFieldName.equals("familyID")) {
/* 2356 */       return 11;
/*      */     }
/* 2358 */     if (strFieldName.equals("relationToMainInsured")) {
/* 2359 */       return 12;
/*      */     }
/* 2361 */     if (strFieldName.equals("relationToAppnt")) {
/* 2362 */       return 13;
/*      */     }
/* 2364 */     if (strFieldName.equals("addressNo")) {
/* 2365 */       return 14;
/*      */     }
/* 2367 */     if (strFieldName.equals("sequenceNo")) {
/* 2368 */       return 15;
/*      */     }
/* 2370 */     if (strFieldName.equals("name")) {
/* 2371 */       return 16;
/*      */     }
/* 2373 */     if (strFieldName.equals("appellation")) {
/* 2374 */       return 17;
/*      */     }
/* 2376 */     if (strFieldName.equals("sex")) {
/* 2377 */       return 18;
/*      */     }
/* 2379 */     if (strFieldName.equals("birthday")) {
/* 2380 */       return 19;
/*      */     }
/* 2382 */     if (strFieldName.equals("appAge")) {
/* 2383 */       return 20;
/*      */     }
/* 2385 */     if (strFieldName.equals("appAgeType")) {
/* 2386 */       return 21;
/*      */     }
/* 2388 */     if (strFieldName.equals("iDType")) {
/* 2389 */       return 22;
/*      */     }
/* 2391 */     if (strFieldName.equals("iDNo")) {
/* 2392 */       return 23;
/*      */     }
/* 2394 */     if (strFieldName.equals("iDValidity")) {
/* 2395 */       return 24;
/*      */     }
/* 2397 */     if (strFieldName.equals("iDPerpetual")) {
/* 2398 */       return 25;
/*      */     }
/* 2400 */     if (strFieldName.equals("nativePlace")) {
/* 2401 */       return 26;
/*      */     }
/* 2403 */     if (strFieldName.equals("nationality")) {
/* 2404 */       return 27;
/*      */     }
/* 2406 */     if (strFieldName.equals("rgtAddress")) {
/* 2407 */       return 28;
/*      */     }
/* 2409 */     if (strFieldName.equals("marriage")) {
/* 2410 */       return 29;
/*      */     }
/* 2412 */     if (strFieldName.equals("marriageDate")) {
/* 2413 */       return 30;
/*      */     }
/* 2415 */     if (strFieldName.equals("health")) {
/* 2416 */       return 31;
/*      */     }
/* 2418 */     if (strFieldName.equals("stature")) {
/* 2419 */       return 32;
/*      */     }
/* 2421 */     if (strFieldName.equals("avoirdupois")) {
/* 2422 */       return 33;
/*      */     }
/* 2424 */     if (strFieldName.equals("degree")) {
/* 2425 */       return 34;
/*      */     }
/* 2427 */     if (strFieldName.equals("creditGrade")) {
/* 2428 */       return 35;
/*      */     }
/* 2430 */     if (strFieldName.equals("bankCode")) {
/* 2431 */       return 36;
/*      */     }
/* 2433 */     if (strFieldName.equals("bankAccNo")) {
/* 2434 */       return 37;
/*      */     }
/* 2436 */     if (strFieldName.equals("accName")) {
/* 2437 */       return 38;
/*      */     }
/* 2439 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2440 */       return 39;
/*      */     }
/* 2442 */     if (strFieldName.equals("startWorkDate")) {
/* 2443 */       return 40;
/*      */     }
/* 2445 */     if (strFieldName.equals("position")) {
/* 2446 */       return 41;
/*      */     }
/* 2448 */     if (strFieldName.equals("salary")) {
/* 2449 */       return 42;
/*      */     }
/* 2451 */     if (strFieldName.equals("occupationType")) {
/* 2452 */       return 43;
/*      */     }
/* 2454 */     if (strFieldName.equals("occupationCode")) {
/* 2455 */       return 44;
/*      */     }
/* 2457 */     if (strFieldName.equals("partOccupationType")) {
/* 2458 */       return 45;
/*      */     }
/* 2460 */     if (strFieldName.equals("partOccupationCode")) {
/* 2461 */       return 46;
/*      */     }
/* 2463 */     if (strFieldName.equals("workType")) {
/* 2464 */       return 47;
/*      */     }
/* 2466 */     if (strFieldName.equals("pluralityType")) {
/* 2467 */       return 48;
/*      */     }
/* 2469 */     if (strFieldName.equals("smokeFlag")) {
/* 2470 */       return 49;
/*      */     }
/* 2472 */     if (strFieldName.equals("contPlanCode")) {
/* 2473 */       return 50;
/*      */     }
/* 2475 */     if (strFieldName.equals("operator")) {
/* 2476 */       return 51;
/*      */     }
/* 2478 */     if (strFieldName.equals("makeDate")) {
/* 2479 */       return 52;
/*      */     }
/* 2481 */     if (strFieldName.equals("makeTime")) {
/* 2482 */       return 53;
/*      */     }
/* 2484 */     if (strFieldName.equals("modifyDate")) {
/* 2485 */       return 54;
/*      */     }
/* 2487 */     if (strFieldName.equals("modifyTime")) {
/* 2488 */       return 55;
/*      */     }
/* 2490 */     if (strFieldName.equals("insuredPeoples")) {
/* 2491 */       return 56;
/*      */     }
/* 2493 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2499 */     String strFieldName = "";
/* 2500 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2502 */       strFieldName = "grpContNo";
/* 2503 */       break;
/*      */     case 1:
/* 2505 */       strFieldName = "contNo";
/* 2506 */       break;
/*      */     case 2:
/* 2508 */       strFieldName = "proposalContNo";
/* 2509 */       break;
/*      */     case 3:
/* 2511 */       strFieldName = "insuredNo";
/* 2512 */       break;
/*      */     case 4:
/* 2514 */       strFieldName = "insuredId";
/* 2515 */       break;
/*      */     case 5:
/* 2517 */       strFieldName = "prtNo";
/* 2518 */       break;
/*      */     case 6:
/* 2520 */       strFieldName = "appntNo";
/* 2521 */       break;
/*      */     case 7:
/* 2523 */       strFieldName = "appntId";
/* 2524 */       break;
/*      */     case 8:
/* 2526 */       strFieldName = "manageCom";
/* 2527 */       break;
/*      */     case 9:
/* 2529 */       strFieldName = "signCity";
/* 2530 */       break;
/*      */     case 10:
/* 2532 */       strFieldName = "executeCom";
/* 2533 */       break;
/*      */     case 11:
/* 2535 */       strFieldName = "familyID";
/* 2536 */       break;
/*      */     case 12:
/* 2538 */       strFieldName = "relationToMainInsured";
/* 2539 */       break;
/*      */     case 13:
/* 2541 */       strFieldName = "relationToAppnt";
/* 2542 */       break;
/*      */     case 14:
/* 2544 */       strFieldName = "addressNo";
/* 2545 */       break;
/*      */     case 15:
/* 2547 */       strFieldName = "sequenceNo";
/* 2548 */       break;
/*      */     case 16:
/* 2550 */       strFieldName = "name";
/* 2551 */       break;
/*      */     case 17:
/* 2553 */       strFieldName = "appellation";
/* 2554 */       break;
/*      */     case 18:
/* 2556 */       strFieldName = "sex";
/* 2557 */       break;
/*      */     case 19:
/* 2559 */       strFieldName = "birthday";
/* 2560 */       break;
/*      */     case 20:
/* 2562 */       strFieldName = "appAge";
/* 2563 */       break;
/*      */     case 21:
/* 2565 */       strFieldName = "appAgeType";
/* 2566 */       break;
/*      */     case 22:
/* 2568 */       strFieldName = "iDType";
/* 2569 */       break;
/*      */     case 23:
/* 2571 */       strFieldName = "iDNo";
/* 2572 */       break;
/*      */     case 24:
/* 2574 */       strFieldName = "iDValidity";
/* 2575 */       break;
/*      */     case 25:
/* 2577 */       strFieldName = "iDPerpetual";
/* 2578 */       break;
/*      */     case 26:
/* 2580 */       strFieldName = "nativePlace";
/* 2581 */       break;
/*      */     case 27:
/* 2583 */       strFieldName = "nationality";
/* 2584 */       break;
/*      */     case 28:
/* 2586 */       strFieldName = "rgtAddress";
/* 2587 */       break;
/*      */     case 29:
/* 2589 */       strFieldName = "marriage";
/* 2590 */       break;
/*      */     case 30:
/* 2592 */       strFieldName = "marriageDate";
/* 2593 */       break;
/*      */     case 31:
/* 2595 */       strFieldName = "health";
/* 2596 */       break;
/*      */     case 32:
/* 2598 */       strFieldName = "stature";
/* 2599 */       break;
/*      */     case 33:
/* 2601 */       strFieldName = "avoirdupois";
/* 2602 */       break;
/*      */     case 34:
/* 2604 */       strFieldName = "degree";
/* 2605 */       break;
/*      */     case 35:
/* 2607 */       strFieldName = "creditGrade";
/* 2608 */       break;
/*      */     case 36:
/* 2610 */       strFieldName = "bankCode";
/* 2611 */       break;
/*      */     case 37:
/* 2613 */       strFieldName = "bankAccNo";
/* 2614 */       break;
/*      */     case 38:
/* 2616 */       strFieldName = "accName";
/* 2617 */       break;
/*      */     case 39:
/* 2619 */       strFieldName = "joinCompanyDate";
/* 2620 */       break;
/*      */     case 40:
/* 2622 */       strFieldName = "startWorkDate";
/* 2623 */       break;
/*      */     case 41:
/* 2625 */       strFieldName = "position";
/* 2626 */       break;
/*      */     case 42:
/* 2628 */       strFieldName = "salary";
/* 2629 */       break;
/*      */     case 43:
/* 2631 */       strFieldName = "occupationType";
/* 2632 */       break;
/*      */     case 44:
/* 2634 */       strFieldName = "occupationCode";
/* 2635 */       break;
/*      */     case 45:
/* 2637 */       strFieldName = "partOccupationType";
/* 2638 */       break;
/*      */     case 46:
/* 2640 */       strFieldName = "partOccupationCode";
/* 2641 */       break;
/*      */     case 47:
/* 2643 */       strFieldName = "workType";
/* 2644 */       break;
/*      */     case 48:
/* 2646 */       strFieldName = "pluralityType";
/* 2647 */       break;
/*      */     case 49:
/* 2649 */       strFieldName = "smokeFlag";
/* 2650 */       break;
/*      */     case 50:
/* 2652 */       strFieldName = "contPlanCode";
/* 2653 */       break;
/*      */     case 51:
/* 2655 */       strFieldName = "operator";
/* 2656 */       break;
/*      */     case 52:
/* 2658 */       strFieldName = "makeDate";
/* 2659 */       break;
/*      */     case 53:
/* 2661 */       strFieldName = "makeTime";
/* 2662 */       break;
/*      */     case 54:
/* 2664 */       strFieldName = "modifyDate";
/* 2665 */       break;
/*      */     case 55:
/* 2667 */       strFieldName = "modifyTime";
/* 2668 */       break;
/*      */     case 56:
/* 2670 */       strFieldName = "insuredPeoples";
/* 2671 */       break;
/*      */     default:
/* 2673 */       strFieldName = "";
/*      */     }
/* 2675 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2681 */     if (strFieldName.equals("grpContNo")) {
/* 2682 */       return 0;
/*      */     }
/* 2684 */     if (strFieldName.equals("contNo")) {
/* 2685 */       return 0;
/*      */     }
/* 2687 */     if (strFieldName.equals("proposalContNo")) {
/* 2688 */       return 0;
/*      */     }
/* 2690 */     if (strFieldName.equals("insuredNo")) {
/* 2691 */       return 0;
/*      */     }
/* 2693 */     if (strFieldName.equals("insuredId")) {
/* 2694 */       return 0;
/*      */     }
/* 2696 */     if (strFieldName.equals("prtNo")) {
/* 2697 */       return 0;
/*      */     }
/* 2699 */     if (strFieldName.equals("appntNo")) {
/* 2700 */       return 0;
/*      */     }
/* 2702 */     if (strFieldName.equals("appntId")) {
/* 2703 */       return 0;
/*      */     }
/* 2705 */     if (strFieldName.equals("manageCom")) {
/* 2706 */       return 0;
/*      */     }
/* 2708 */     if (strFieldName.equals("signCity")) {
/* 2709 */       return 0;
/*      */     }
/* 2711 */     if (strFieldName.equals("executeCom")) {
/* 2712 */       return 0;
/*      */     }
/* 2714 */     if (strFieldName.equals("familyID")) {
/* 2715 */       return 0;
/*      */     }
/* 2717 */     if (strFieldName.equals("relationToMainInsured")) {
/* 2718 */       return 0;
/*      */     }
/* 2720 */     if (strFieldName.equals("relationToAppnt")) {
/* 2721 */       return 0;
/*      */     }
/* 2723 */     if (strFieldName.equals("addressNo")) {
/* 2724 */       return 0;
/*      */     }
/* 2726 */     if (strFieldName.equals("sequenceNo")) {
/* 2727 */       return 0;
/*      */     }
/* 2729 */     if (strFieldName.equals("name")) {
/* 2730 */       return 0;
/*      */     }
/* 2732 */     if (strFieldName.equals("appellation")) {
/* 2733 */       return 0;
/*      */     }
/* 2735 */     if (strFieldName.equals("sex")) {
/* 2736 */       return 0;
/*      */     }
/* 2738 */     if (strFieldName.equals("birthday")) {
/* 2739 */       return 1;
/*      */     }
/* 2741 */     if (strFieldName.equals("appAge")) {
/* 2742 */       return 3;
/*      */     }
/* 2744 */     if (strFieldName.equals("appAgeType")) {
/* 2745 */       return 0;
/*      */     }
/* 2747 */     if (strFieldName.equals("iDType")) {
/* 2748 */       return 0;
/*      */     }
/* 2750 */     if (strFieldName.equals("iDNo")) {
/* 2751 */       return 0;
/*      */     }
/* 2753 */     if (strFieldName.equals("iDValidity")) {
/* 2754 */       return 1;
/*      */     }
/* 2756 */     if (strFieldName.equals("iDPerpetual")) {
/* 2757 */       return 0;
/*      */     }
/* 2759 */     if (strFieldName.equals("nativePlace")) {
/* 2760 */       return 0;
/*      */     }
/* 2762 */     if (strFieldName.equals("nationality")) {
/* 2763 */       return 0;
/*      */     }
/* 2765 */     if (strFieldName.equals("rgtAddress")) {
/* 2766 */       return 0;
/*      */     }
/* 2768 */     if (strFieldName.equals("marriage")) {
/* 2769 */       return 0;
/*      */     }
/* 2771 */     if (strFieldName.equals("marriageDate")) {
/* 2772 */       return 1;
/*      */     }
/* 2774 */     if (strFieldName.equals("health")) {
/* 2775 */       return 0;
/*      */     }
/* 2777 */     if (strFieldName.equals("stature")) {
/* 2778 */       return 4;
/*      */     }
/* 2780 */     if (strFieldName.equals("avoirdupois")) {
/* 2781 */       return 4;
/*      */     }
/* 2783 */     if (strFieldName.equals("degree")) {
/* 2784 */       return 0;
/*      */     }
/* 2786 */     if (strFieldName.equals("creditGrade")) {
/* 2787 */       return 0;
/*      */     }
/* 2789 */     if (strFieldName.equals("bankCode")) {
/* 2790 */       return 0;
/*      */     }
/* 2792 */     if (strFieldName.equals("bankAccNo")) {
/* 2793 */       return 0;
/*      */     }
/* 2795 */     if (strFieldName.equals("accName")) {
/* 2796 */       return 0;
/*      */     }
/* 2798 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2799 */       return 1;
/*      */     }
/* 2801 */     if (strFieldName.equals("startWorkDate")) {
/* 2802 */       return 1;
/*      */     }
/* 2804 */     if (strFieldName.equals("position")) {
/* 2805 */       return 0;
/*      */     }
/* 2807 */     if (strFieldName.equals("salary")) {
/* 2808 */       return 4;
/*      */     }
/* 2810 */     if (strFieldName.equals("occupationType")) {
/* 2811 */       return 0;
/*      */     }
/* 2813 */     if (strFieldName.equals("occupationCode")) {
/* 2814 */       return 0;
/*      */     }
/* 2816 */     if (strFieldName.equals("partOccupationType")) {
/* 2817 */       return 0;
/*      */     }
/* 2819 */     if (strFieldName.equals("partOccupationCode")) {
/* 2820 */       return 0;
/*      */     }
/* 2822 */     if (strFieldName.equals("workType")) {
/* 2823 */       return 0;
/*      */     }
/* 2825 */     if (strFieldName.equals("pluralityType")) {
/* 2826 */       return 0;
/*      */     }
/* 2828 */     if (strFieldName.equals("smokeFlag")) {
/* 2829 */       return 0;
/*      */     }
/* 2831 */     if (strFieldName.equals("contPlanCode")) {
/* 2832 */       return 0;
/*      */     }
/* 2834 */     if (strFieldName.equals("operator")) {
/* 2835 */       return 0;
/*      */     }
/* 2837 */     if (strFieldName.equals("makeDate")) {
/* 2838 */       return 1;
/*      */     }
/* 2840 */     if (strFieldName.equals("makeTime")) {
/* 2841 */       return 0;
/*      */     }
/* 2843 */     if (strFieldName.equals("modifyDate")) {
/* 2844 */       return 1;
/*      */     }
/* 2846 */     if (strFieldName.equals("modifyTime")) {
/* 2847 */       return 0;
/*      */     }
/* 2849 */     if (strFieldName.equals("insuredPeoples")) {
/* 2850 */       return 3;
/*      */     }
/* 2852 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 2858 */     int nFieldType = -1;
/* 2859 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2861 */       nFieldType = 0;
/* 2862 */       break;
/*      */     case 1:
/* 2864 */       nFieldType = 0;
/* 2865 */       break;
/*      */     case 2:
/* 2867 */       nFieldType = 0;
/* 2868 */       break;
/*      */     case 3:
/* 2870 */       nFieldType = 0;
/* 2871 */       break;
/*      */     case 4:
/* 2873 */       nFieldType = 0;
/* 2874 */       break;
/*      */     case 5:
/* 2876 */       nFieldType = 0;
/* 2877 */       break;
/*      */     case 6:
/* 2879 */       nFieldType = 0;
/* 2880 */       break;
/*      */     case 7:
/* 2882 */       nFieldType = 0;
/* 2883 */       break;
/*      */     case 8:
/* 2885 */       nFieldType = 0;
/* 2886 */       break;
/*      */     case 9:
/* 2888 */       nFieldType = 0;
/* 2889 */       break;
/*      */     case 10:
/* 2891 */       nFieldType = 0;
/* 2892 */       break;
/*      */     case 11:
/* 2894 */       nFieldType = 0;
/* 2895 */       break;
/*      */     case 12:
/* 2897 */       nFieldType = 0;
/* 2898 */       break;
/*      */     case 13:
/* 2900 */       nFieldType = 0;
/* 2901 */       break;
/*      */     case 14:
/* 2903 */       nFieldType = 0;
/* 2904 */       break;
/*      */     case 15:
/* 2906 */       nFieldType = 0;
/* 2907 */       break;
/*      */     case 16:
/* 2909 */       nFieldType = 0;
/* 2910 */       break;
/*      */     case 17:
/* 2912 */       nFieldType = 0;
/* 2913 */       break;
/*      */     case 18:
/* 2915 */       nFieldType = 0;
/* 2916 */       break;
/*      */     case 19:
/* 2918 */       nFieldType = 1;
/* 2919 */       break;
/*      */     case 20:
/* 2921 */       nFieldType = 3;
/* 2922 */       break;
/*      */     case 21:
/* 2924 */       nFieldType = 0;
/* 2925 */       break;
/*      */     case 22:
/* 2927 */       nFieldType = 0;
/* 2928 */       break;
/*      */     case 23:
/* 2930 */       nFieldType = 0;
/* 2931 */       break;
/*      */     case 24:
/* 2933 */       nFieldType = 1;
/* 2934 */       break;
/*      */     case 25:
/* 2936 */       nFieldType = 0;
/* 2937 */       break;
/*      */     case 26:
/* 2939 */       nFieldType = 0;
/* 2940 */       break;
/*      */     case 27:
/* 2942 */       nFieldType = 0;
/* 2943 */       break;
/*      */     case 28:
/* 2945 */       nFieldType = 0;
/* 2946 */       break;
/*      */     case 29:
/* 2948 */       nFieldType = 0;
/* 2949 */       break;
/*      */     case 30:
/* 2951 */       nFieldType = 1;
/* 2952 */       break;
/*      */     case 31:
/* 2954 */       nFieldType = 0;
/* 2955 */       break;
/*      */     case 32:
/* 2957 */       nFieldType = 4;
/* 2958 */       break;
/*      */     case 33:
/* 2960 */       nFieldType = 4;
/* 2961 */       break;
/*      */     case 34:
/* 2963 */       nFieldType = 0;
/* 2964 */       break;
/*      */     case 35:
/* 2966 */       nFieldType = 0;
/* 2967 */       break;
/*      */     case 36:
/* 2969 */       nFieldType = 0;
/* 2970 */       break;
/*      */     case 37:
/* 2972 */       nFieldType = 0;
/* 2973 */       break;
/*      */     case 38:
/* 2975 */       nFieldType = 0;
/* 2976 */       break;
/*      */     case 39:
/* 2978 */       nFieldType = 1;
/* 2979 */       break;
/*      */     case 40:
/* 2981 */       nFieldType = 1;
/* 2982 */       break;
/*      */     case 41:
/* 2984 */       nFieldType = 0;
/* 2985 */       break;
/*      */     case 42:
/* 2987 */       nFieldType = 4;
/* 2988 */       break;
/*      */     case 43:
/* 2990 */       nFieldType = 0;
/* 2991 */       break;
/*      */     case 44:
/* 2993 */       nFieldType = 0;
/* 2994 */       break;
/*      */     case 45:
/* 2996 */       nFieldType = 0;
/* 2997 */       break;
/*      */     case 46:
/* 2999 */       nFieldType = 0;
/* 3000 */       break;
/*      */     case 47:
/* 3002 */       nFieldType = 0;
/* 3003 */       break;
/*      */     case 48:
/* 3005 */       nFieldType = 0;
/* 3006 */       break;
/*      */     case 49:
/* 3008 */       nFieldType = 0;
/* 3009 */       break;
/*      */     case 50:
/* 3011 */       nFieldType = 0;
/* 3012 */       break;
/*      */     case 51:
/* 3014 */       nFieldType = 0;
/* 3015 */       break;
/*      */     case 52:
/* 3017 */       nFieldType = 1;
/* 3018 */       break;
/*      */     case 53:
/* 3020 */       nFieldType = 0;
/* 3021 */       break;
/*      */     case 54:
/* 3023 */       nFieldType = 1;
/* 3024 */       break;
/*      */     case 55:
/* 3026 */       nFieldType = 0;
/* 3027 */       break;
/*      */     case 56:
/* 3029 */       nFieldType = 3;
/* 3030 */       break;
/*      */     default:
/* 3032 */       nFieldType = -1;
/*      */     }
/* 3034 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPInsuredSchema
 * JD-Core Version:    0.6.0
 */