/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPPersonDB;
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
/*      */ public class LNPPersonSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String customerId;
/*      */   private String agentCode;
/*      */   private String customerNo;
/*      */   private String appellation;
/*      */   private String name;
/*      */   private String sex;
/*      */   private Date birthday;
/*      */   private int age;
/*      */   private String ageType;
/*      */   private String appntType;
/*      */   private String iDType;
/*      */   private String iDNo;
/*      */   private Date iDValidity;
/*      */   private String iDPerpetual;
/*      */   private String password;
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
/*      */   private String othIDType;
/*      */   private String othIDNo;
/*      */   private String iCNo;
/*      */   private String grpNo;
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
/*      */   private Date deathDate;
/*      */   private String smokeFlag;
/*      */   private String blacklistFlag;
/*      */   private String proterty;
/*      */   private String remark;
/*      */   private String state;
/*      */   private String vIPValue;
/*      */   private String operator;
/*      */   private String manageCom;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String grpName;
/*      */   public static final int FIELDNUM = 56;
/*      */   private static String[] PK;
/*  139 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPPersonSchema()
/*      */   {
/*  146 */     this.mErrors = new CErrors();
/*      */ 
/*  148 */     String[] pk = new String[2];
/*  149 */     pk[0] = "CustomerId";
/*  150 */     pk[1] = "AgentCode";
/*      */ 
/*  152 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  159 */     LNPPersonSchema cloned = (LNPPersonSchema)super.clone();
/*  160 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  161 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  162 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  168 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getCustomerId()
/*      */   {
/*  173 */     return this.customerId;
/*      */   }
/*      */ 
/*      */   public void setCustomerId(String aCustomerId) {
/*  177 */     this.customerId = aCustomerId;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  181 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  185 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getCustomerNo() {
/*  189 */     return this.customerNo;
/*      */   }
/*      */ 
/*      */   public void setCustomerNo(String aCustomerNo) {
/*  193 */     this.customerNo = aCustomerNo;
/*      */   }
/*      */ 
/*      */   public String getAppellation() {
/*  197 */     return this.appellation;
/*      */   }
/*      */ 
/*      */   public void setAppellation(String aAppellation) {
/*  201 */     this.appellation = aAppellation;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  205 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  209 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getSex() {
/*  213 */     return this.sex;
/*      */   }
/*      */ 
/*      */   public void setSex(String aSex) {
/*  217 */     this.sex = aSex;
/*      */   }
/*      */ 
/*      */   public String getBirthday() {
/*  221 */     if (this.birthday != null) {
/*  222 */       return this.fDate.getString(this.birthday);
/*      */     }
/*  224 */     return null;
/*      */   }
/*      */ 
/*      */   public void setBirthday(Date aBirthday) {
/*  228 */     this.birthday = aBirthday;
/*      */   }
/*      */ 
/*      */   public void setBirthday(String aBirthday) {
/*  232 */     if ((aBirthday != null) && (!aBirthday.equals("")))
/*      */     {
/*  234 */       this.birthday = this.fDate.getDate(aBirthday);
/*      */     }
/*      */     else
/*  237 */       this.birthday = null;
/*      */   }
/*      */ 
/*      */   public int getAge()
/*      */   {
/*  242 */     return this.age;
/*      */   }
/*      */ 
/*      */   public void setAge(int aAge) {
/*  246 */     this.age = aAge;
/*      */   }
/*      */ 
/*      */   public void setAge(String aAge) {
/*  250 */     if ((aAge != null) && (!aAge.equals("")))
/*      */     {
/*  252 */       Integer tInteger = new Integer(aAge);
/*  253 */       int i = tInteger.intValue();
/*  254 */       this.age = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getAgeType()
/*      */   {
/*  260 */     return this.ageType;
/*      */   }
/*      */ 
/*      */   public void setAgeType(String aAgeType) {
/*  264 */     this.ageType = aAgeType;
/*      */   }
/*      */ 
/*      */   public String getAppntType() {
/*  268 */     return this.appntType;
/*      */   }
/*      */ 
/*      */   public void setAppntType(String aAppntType) {
/*  272 */     this.appntType = aAppntType;
/*      */   }
/*      */ 
/*      */   public String getIDType() {
/*  276 */     return this.iDType;
/*      */   }
/*      */ 
/*      */   public void setIDType(String aIDType) {
/*  280 */     this.iDType = aIDType;
/*      */   }
/*      */ 
/*      */   public String getIDNo() {
/*  284 */     return this.iDNo;
/*      */   }
/*      */ 
/*      */   public void setIDNo(String aIDNo) {
/*  288 */     this.iDNo = aIDNo;
/*      */   }
/*      */ 
/*      */   public String getIDValidity() {
/*  292 */     if (this.iDValidity != null) {
/*  293 */       return this.fDate.getString(this.iDValidity);
/*      */     }
/*  295 */     return null;
/*      */   }
/*      */ 
/*      */   public void setIDValidity(Date aIDValidity) {
/*  299 */     this.iDValidity = aIDValidity;
/*      */   }
/*      */ 
/*      */   public void setIDValidity(String aIDValidity) {
/*  303 */     if ((aIDValidity != null) && (!aIDValidity.equals("")))
/*      */     {
/*  305 */       this.iDValidity = this.fDate.getDate(aIDValidity);
/*      */     }
/*      */     else
/*  308 */       this.iDValidity = null;
/*      */   }
/*      */ 
/*      */   public String getIDPerpetual()
/*      */   {
/*  313 */     return this.iDPerpetual;
/*      */   }
/*      */ 
/*      */   public void setIDPerpetual(String aIDPerpetual) {
/*  317 */     this.iDPerpetual = aIDPerpetual;
/*      */   }
/*      */ 
/*      */   public String getPassword() {
/*  321 */     return this.password;
/*      */   }
/*      */ 
/*      */   public void setPassword(String aPassword) {
/*  325 */     this.password = aPassword;
/*      */   }
/*      */ 
/*      */   public String getNativePlace() {
/*  329 */     return this.nativePlace;
/*      */   }
/*      */ 
/*      */   public void setNativePlace(String aNativePlace) {
/*  333 */     this.nativePlace = aNativePlace;
/*      */   }
/*      */ 
/*      */   public String getNationality() {
/*  337 */     return this.nationality;
/*      */   }
/*      */ 
/*      */   public void setNationality(String aNationality) {
/*  341 */     this.nationality = aNationality;
/*      */   }
/*      */ 
/*      */   public String getRgtAddress() {
/*  345 */     return this.rgtAddress;
/*      */   }
/*      */ 
/*      */   public void setRgtAddress(String aRgtAddress) {
/*  349 */     this.rgtAddress = aRgtAddress;
/*      */   }
/*      */ 
/*      */   public String getMarriage() {
/*  353 */     return this.marriage;
/*      */   }
/*      */ 
/*      */   public void setMarriage(String aMarriage) {
/*  357 */     this.marriage = aMarriage;
/*      */   }
/*      */ 
/*      */   public String getMarriageDate() {
/*  361 */     if (this.marriageDate != null) {
/*  362 */       return this.fDate.getString(this.marriageDate);
/*      */     }
/*  364 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMarriageDate(Date aMarriageDate) {
/*  368 */     this.marriageDate = aMarriageDate;
/*      */   }
/*      */ 
/*      */   public void setMarriageDate(String aMarriageDate) {
/*  372 */     if ((aMarriageDate != null) && (!aMarriageDate.equals("")))
/*      */     {
/*  374 */       this.marriageDate = this.fDate.getDate(aMarriageDate);
/*      */     }
/*      */     else
/*  377 */       this.marriageDate = null;
/*      */   }
/*      */ 
/*      */   public String getHealth()
/*      */   {
/*  382 */     return this.health;
/*      */   }
/*      */ 
/*      */   public void setHealth(String aHealth) {
/*  386 */     this.health = aHealth;
/*      */   }
/*      */ 
/*      */   public double getStature() {
/*  390 */     return this.stature;
/*      */   }
/*      */ 
/*      */   public void setStature(double aStature) {
/*  394 */     this.stature = aStature;
/*      */   }
/*      */ 
/*      */   public void setStature(String aStature) {
/*  398 */     if ((aStature != null) && (!aStature.equals("")))
/*      */     {
/*  400 */       Double tDouble = new Double(aStature);
/*  401 */       double d = tDouble.doubleValue();
/*  402 */       this.stature = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAvoirdupois()
/*      */   {
/*  408 */     return this.avoirdupois;
/*      */   }
/*      */ 
/*      */   public void setAvoirdupois(double aAvoirdupois) {
/*  412 */     this.avoirdupois = aAvoirdupois;
/*      */   }
/*      */ 
/*      */   public void setAvoirdupois(String aAvoirdupois) {
/*  416 */     if ((aAvoirdupois != null) && (!aAvoirdupois.equals("")))
/*      */     {
/*  418 */       Double tDouble = new Double(aAvoirdupois);
/*  419 */       double d = tDouble.doubleValue();
/*  420 */       this.avoirdupois = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDegree()
/*      */   {
/*  426 */     return this.degree;
/*      */   }
/*      */ 
/*      */   public void setDegree(String aDegree) {
/*  430 */     this.degree = aDegree;
/*      */   }
/*      */ 
/*      */   public String getCreditGrade() {
/*  434 */     return this.creditGrade;
/*      */   }
/*      */ 
/*      */   public void setCreditGrade(String aCreditGrade) {
/*  438 */     this.creditGrade = aCreditGrade;
/*      */   }
/*      */ 
/*      */   public String getBankCode() {
/*  442 */     return this.bankCode;
/*      */   }
/*      */ 
/*      */   public void setBankCode(String aBankCode) {
/*  446 */     this.bankCode = aBankCode;
/*      */   }
/*      */ 
/*      */   public String getBankAccNo() {
/*  450 */     return this.bankAccNo;
/*      */   }
/*      */ 
/*      */   public void setBankAccNo(String aBankAccNo) {
/*  454 */     this.bankAccNo = aBankAccNo;
/*      */   }
/*      */ 
/*      */   public String getAccName() {
/*  458 */     return this.accName;
/*      */   }
/*      */ 
/*      */   public void setAccName(String aAccName) {
/*  462 */     this.accName = aAccName;
/*      */   }
/*      */ 
/*      */   public String getOthIDType() {
/*  466 */     return this.othIDType;
/*      */   }
/*      */ 
/*      */   public void setOthIDType(String aOthIDType) {
/*  470 */     this.othIDType = aOthIDType;
/*      */   }
/*      */ 
/*      */   public String getOthIDNo() {
/*  474 */     return this.othIDNo;
/*      */   }
/*      */ 
/*      */   public void setOthIDNo(String aOthIDNo) {
/*  478 */     this.othIDNo = aOthIDNo;
/*      */   }
/*      */ 
/*      */   public String getICNo() {
/*  482 */     return this.iCNo;
/*      */   }
/*      */ 
/*      */   public void setICNo(String aICNo) {
/*  486 */     this.iCNo = aICNo;
/*      */   }
/*      */ 
/*      */   public String getGrpNo() {
/*  490 */     return this.grpNo;
/*      */   }
/*      */ 
/*      */   public void setGrpNo(String aGrpNo) {
/*  494 */     this.grpNo = aGrpNo;
/*      */   }
/*      */ 
/*      */   public String getJoinCompanyDate() {
/*  498 */     if (this.joinCompanyDate != null) {
/*  499 */       return this.fDate.getString(this.joinCompanyDate);
/*      */     }
/*  501 */     return null;
/*      */   }
/*      */ 
/*      */   public void setJoinCompanyDate(Date aJoinCompanyDate) {
/*  505 */     this.joinCompanyDate = aJoinCompanyDate;
/*      */   }
/*      */ 
/*      */   public void setJoinCompanyDate(String aJoinCompanyDate) {
/*  509 */     if ((aJoinCompanyDate != null) && (!aJoinCompanyDate.equals("")))
/*      */     {
/*  511 */       this.joinCompanyDate = this.fDate.getDate(aJoinCompanyDate);
/*      */     }
/*      */     else
/*  514 */       this.joinCompanyDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartWorkDate()
/*      */   {
/*  519 */     if (this.startWorkDate != null) {
/*  520 */       return this.fDate.getString(this.startWorkDate);
/*      */     }
/*  522 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartWorkDate(Date aStartWorkDate) {
/*  526 */     this.startWorkDate = aStartWorkDate;
/*      */   }
/*      */ 
/*      */   public void setStartWorkDate(String aStartWorkDate) {
/*  530 */     if ((aStartWorkDate != null) && (!aStartWorkDate.equals("")))
/*      */     {
/*  532 */       this.startWorkDate = this.fDate.getDate(aStartWorkDate);
/*      */     }
/*      */     else
/*  535 */       this.startWorkDate = null;
/*      */   }
/*      */ 
/*      */   public String getPosition()
/*      */   {
/*  540 */     return this.position;
/*      */   }
/*      */ 
/*      */   public void setPosition(String aPosition) {
/*  544 */     this.position = aPosition;
/*      */   }
/*      */ 
/*      */   public double getSalary() {
/*  548 */     return this.salary;
/*      */   }
/*      */ 
/*      */   public void setSalary(double aSalary) {
/*  552 */     this.salary = aSalary;
/*      */   }
/*      */ 
/*      */   public void setSalary(String aSalary) {
/*  556 */     if ((aSalary != null) && (!aSalary.equals("")))
/*      */     {
/*  558 */       Double tDouble = new Double(aSalary);
/*  559 */       double d = tDouble.doubleValue();
/*  560 */       this.salary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOccupationType()
/*      */   {
/*  566 */     return this.occupationType;
/*      */   }
/*      */ 
/*      */   public void setOccupationType(String aOccupationType) {
/*  570 */     this.occupationType = aOccupationType;
/*      */   }
/*      */ 
/*      */   public String getOccupationCode() {
/*  574 */     return this.occupationCode;
/*      */   }
/*      */ 
/*      */   public void setOccupationCode(String aOccupationCode) {
/*  578 */     this.occupationCode = aOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getPartOccupationType() {
/*  582 */     return this.partOccupationType;
/*      */   }
/*      */ 
/*      */   public void setPartOccupationType(String aPartOccupationType) {
/*  586 */     this.partOccupationType = aPartOccupationType;
/*      */   }
/*      */ 
/*      */   public String getPartOccupationCode() {
/*  590 */     return this.partOccupationCode;
/*      */   }
/*      */ 
/*      */   public void setPartOccupationCode(String aPartOccupationCode) {
/*  594 */     this.partOccupationCode = aPartOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getWorkType() {
/*  598 */     return this.workType;
/*      */   }
/*      */ 
/*      */   public void setWorkType(String aWorkType) {
/*  602 */     this.workType = aWorkType;
/*      */   }
/*      */ 
/*      */   public String getPluralityType() {
/*  606 */     return this.pluralityType;
/*      */   }
/*      */ 
/*      */   public void setPluralityType(String aPluralityType) {
/*  610 */     this.pluralityType = aPluralityType;
/*      */   }
/*      */ 
/*      */   public String getDeathDate() {
/*  614 */     if (this.deathDate != null) {
/*  615 */       return this.fDate.getString(this.deathDate);
/*      */     }
/*  617 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDeathDate(Date aDeathDate) {
/*  621 */     this.deathDate = aDeathDate;
/*      */   }
/*      */ 
/*      */   public void setDeathDate(String aDeathDate) {
/*  625 */     if ((aDeathDate != null) && (!aDeathDate.equals("")))
/*      */     {
/*  627 */       this.deathDate = this.fDate.getDate(aDeathDate);
/*      */     }
/*      */     else
/*  630 */       this.deathDate = null;
/*      */   }
/*      */ 
/*      */   public String getSmokeFlag()
/*      */   {
/*  635 */     return this.smokeFlag;
/*      */   }
/*      */ 
/*      */   public void setSmokeFlag(String aSmokeFlag) {
/*  639 */     this.smokeFlag = aSmokeFlag;
/*      */   }
/*      */ 
/*      */   public String getBlacklistFlag() {
/*  643 */     return this.blacklistFlag;
/*      */   }
/*      */ 
/*      */   public void setBlacklistFlag(String aBlacklistFlag) {
/*  647 */     this.blacklistFlag = aBlacklistFlag;
/*      */   }
/*      */ 
/*      */   public String getProterty() {
/*  651 */     return this.proterty;
/*      */   }
/*      */ 
/*      */   public void setProterty(String aProterty) {
/*  655 */     this.proterty = aProterty;
/*      */   }
/*      */ 
/*      */   public String getRemark() {
/*  659 */     return this.remark;
/*      */   }
/*      */ 
/*      */   public void setRemark(String aRemark) {
/*  663 */     this.remark = aRemark;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  667 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  671 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getVIPValue() {
/*  675 */     return this.vIPValue;
/*      */   }
/*      */ 
/*      */   public void setVIPValue(String aVIPValue) {
/*  679 */     this.vIPValue = aVIPValue;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  683 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  687 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  691 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  695 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  699 */     if (this.makeDate != null) {
/*  700 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  702 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  706 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  710 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  712 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  715 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  720 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  724 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  728 */     if (this.modifyDate != null) {
/*  729 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  731 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  735 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  739 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  741 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  744 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  749 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  753 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getGrpName() {
/*  757 */     return this.grpName;
/*      */   }
/*      */ 
/*      */   public void setGrpName(String aGrpName) {
/*  761 */     this.grpName = aGrpName;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPPersonSchema aLNPPersonSchema)
/*      */   {
/*  767 */     this.customerId = aLNPPersonSchema.getCustomerId();
/*  768 */     this.agentCode = aLNPPersonSchema.getAgentCode();
/*  769 */     this.customerNo = aLNPPersonSchema.getCustomerNo();
/*  770 */     this.appellation = aLNPPersonSchema.getAppellation();
/*  771 */     this.name = aLNPPersonSchema.getName();
/*  772 */     this.sex = aLNPPersonSchema.getSex();
/*  773 */     this.birthday = this.fDate.getDate(aLNPPersonSchema.getBirthday());
/*  774 */     this.age = aLNPPersonSchema.getAge();
/*  775 */     this.ageType = aLNPPersonSchema.getAgeType();
/*  776 */     this.appntType = aLNPPersonSchema.getAppntType();
/*  777 */     this.iDType = aLNPPersonSchema.getIDType();
/*  778 */     this.iDNo = aLNPPersonSchema.getIDNo();
/*  779 */     this.iDValidity = this.fDate.getDate(aLNPPersonSchema.getIDValidity());
/*  780 */     this.iDPerpetual = aLNPPersonSchema.getIDPerpetual();
/*  781 */     this.password = aLNPPersonSchema.getPassword();
/*  782 */     this.nativePlace = aLNPPersonSchema.getNativePlace();
/*  783 */     this.nationality = aLNPPersonSchema.getNationality();
/*  784 */     this.rgtAddress = aLNPPersonSchema.getRgtAddress();
/*  785 */     this.marriage = aLNPPersonSchema.getMarriage();
/*  786 */     this.marriageDate = this.fDate.getDate(aLNPPersonSchema.getMarriageDate());
/*  787 */     this.health = aLNPPersonSchema.getHealth();
/*  788 */     this.stature = aLNPPersonSchema.getStature();
/*  789 */     this.avoirdupois = aLNPPersonSchema.getAvoirdupois();
/*  790 */     this.degree = aLNPPersonSchema.getDegree();
/*  791 */     this.creditGrade = aLNPPersonSchema.getCreditGrade();
/*  792 */     this.bankCode = aLNPPersonSchema.getBankCode();
/*  793 */     this.bankAccNo = aLNPPersonSchema.getBankAccNo();
/*  794 */     this.accName = aLNPPersonSchema.getAccName();
/*  795 */     this.othIDType = aLNPPersonSchema.getOthIDType();
/*  796 */     this.othIDNo = aLNPPersonSchema.getOthIDNo();
/*  797 */     this.iCNo = aLNPPersonSchema.getICNo();
/*  798 */     this.grpNo = aLNPPersonSchema.getGrpNo();
/*  799 */     this.joinCompanyDate = this.fDate.getDate(aLNPPersonSchema.getJoinCompanyDate());
/*  800 */     this.startWorkDate = this.fDate.getDate(aLNPPersonSchema.getStartWorkDate());
/*  801 */     this.position = aLNPPersonSchema.getPosition();
/*  802 */     this.salary = aLNPPersonSchema.getSalary();
/*  803 */     this.occupationType = aLNPPersonSchema.getOccupationType();
/*  804 */     this.occupationCode = aLNPPersonSchema.getOccupationCode();
/*  805 */     this.partOccupationType = aLNPPersonSchema.getPartOccupationType();
/*  806 */     this.partOccupationCode = aLNPPersonSchema.getPartOccupationCode();
/*  807 */     this.workType = aLNPPersonSchema.getWorkType();
/*  808 */     this.pluralityType = aLNPPersonSchema.getPluralityType();
/*  809 */     this.deathDate = this.fDate.getDate(aLNPPersonSchema.getDeathDate());
/*  810 */     this.smokeFlag = aLNPPersonSchema.getSmokeFlag();
/*  811 */     this.blacklistFlag = aLNPPersonSchema.getBlacklistFlag();
/*  812 */     this.proterty = aLNPPersonSchema.getProterty();
/*  813 */     this.remark = aLNPPersonSchema.getRemark();
/*  814 */     this.state = aLNPPersonSchema.getState();
/*  815 */     this.vIPValue = aLNPPersonSchema.getVIPValue();
/*  816 */     this.operator = aLNPPersonSchema.getOperator();
/*  817 */     this.manageCom = aLNPPersonSchema.getManageCom();
/*  818 */     this.makeDate = this.fDate.getDate(aLNPPersonSchema.getMakeDate());
/*  819 */     this.makeTime = aLNPPersonSchema.getMakeTime();
/*  820 */     this.modifyDate = this.fDate.getDate(aLNPPersonSchema.getModifyDate());
/*  821 */     this.modifyTime = aLNPPersonSchema.getModifyTime();
/*  822 */     this.grpName = aLNPPersonSchema.getGrpName();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  831 */       if (rs.getString("CustomerId") == null)
/*  832 */         this.customerId = null;
/*      */       else {
/*  834 */         this.customerId = rs.getString("CustomerId").trim();
/*      */       }
/*  836 */       if (rs.getString("AgentCode") == null)
/*  837 */         this.agentCode = null;
/*      */       else {
/*  839 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/*  841 */       if (rs.getString("CustomerNo") == null)
/*  842 */         this.customerNo = null;
/*      */       else {
/*  844 */         this.customerNo = rs.getString("CustomerNo").trim();
/*      */       }
/*  846 */       if (rs.getString("Appellation") == null)
/*  847 */         this.appellation = null;
/*      */       else {
/*  849 */         this.appellation = rs.getString("Appellation").trim();
/*      */       }
/*  851 */       if (rs.getString("Name") == null)
/*  852 */         this.name = null;
/*      */       else {
/*  854 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  856 */       if (rs.getString("Sex") == null)
/*  857 */         this.sex = null;
/*      */       else {
/*  859 */         this.sex = rs.getString("Sex").trim();
/*      */       }
/*  861 */       this.birthday = rs.getDate("Birthday");
/*  862 */       this.age = rs.getInt("Age");
/*  863 */       if (rs.getString("AgeType") == null)
/*  864 */         this.ageType = null;
/*      */       else {
/*  866 */         this.ageType = rs.getString("AgeType").trim();
/*      */       }
/*  868 */       if (rs.getString("AppntType") == null)
/*  869 */         this.appntType = null;
/*      */       else {
/*  871 */         this.appntType = rs.getString("AppntType").trim();
/*      */       }
/*  873 */       if (rs.getString("IDType") == null)
/*  874 */         this.iDType = null;
/*      */       else {
/*  876 */         this.iDType = rs.getString("IDType").trim();
/*      */       }
/*  878 */       if (rs.getString("IDNo") == null)
/*  879 */         this.iDNo = null;
/*      */       else {
/*  881 */         this.iDNo = rs.getString("IDNo").trim();
/*      */       }
/*  883 */       this.iDValidity = rs.getDate("IDValidity");
/*  884 */       if (rs.getString("IDPerpetual") == null)
/*  885 */         this.iDPerpetual = null;
/*      */       else {
/*  887 */         this.iDPerpetual = rs.getString("IDPerpetual").trim();
/*      */       }
/*  889 */       if (rs.getString("Password") == null)
/*  890 */         this.password = null;
/*      */       else {
/*  892 */         this.password = rs.getString("Password").trim();
/*      */       }
/*  894 */       if (rs.getString("NativePlace") == null)
/*  895 */         this.nativePlace = null;
/*      */       else {
/*  897 */         this.nativePlace = rs.getString("NativePlace").trim();
/*      */       }
/*  899 */       if (rs.getString("Nationality") == null)
/*  900 */         this.nationality = null;
/*      */       else {
/*  902 */         this.nationality = rs.getString("Nationality").trim();
/*      */       }
/*  904 */       if (rs.getString("RgtAddress") == null)
/*  905 */         this.rgtAddress = null;
/*      */       else {
/*  907 */         this.rgtAddress = rs.getString("RgtAddress").trim();
/*      */       }
/*  909 */       if (rs.getString("Marriage") == null)
/*  910 */         this.marriage = null;
/*      */       else {
/*  912 */         this.marriage = rs.getString("Marriage").trim();
/*      */       }
/*  914 */       this.marriageDate = rs.getDate("MarriageDate");
/*  915 */       if (rs.getString("Health") == null)
/*  916 */         this.health = null;
/*      */       else {
/*  918 */         this.health = rs.getString("Health").trim();
/*      */       }
/*  920 */       this.stature = rs.getDouble("Stature");
/*  921 */       this.avoirdupois = rs.getDouble("Avoirdupois");
/*  922 */       if (rs.getString("Degree") == null)
/*  923 */         this.degree = null;
/*      */       else {
/*  925 */         this.degree = rs.getString("Degree").trim();
/*      */       }
/*  927 */       if (rs.getString("CreditGrade") == null)
/*  928 */         this.creditGrade = null;
/*      */       else {
/*  930 */         this.creditGrade = rs.getString("CreditGrade").trim();
/*      */       }
/*  932 */       if (rs.getString("BankCode") == null)
/*  933 */         this.bankCode = null;
/*      */       else {
/*  935 */         this.bankCode = rs.getString("BankCode").trim();
/*      */       }
/*  937 */       if (rs.getString("BankAccNo") == null)
/*  938 */         this.bankAccNo = null;
/*      */       else {
/*  940 */         this.bankAccNo = rs.getString("BankAccNo").trim();
/*      */       }
/*  942 */       if (rs.getString("AccName") == null)
/*  943 */         this.accName = null;
/*      */       else {
/*  945 */         this.accName = rs.getString("AccName").trim();
/*      */       }
/*  947 */       if (rs.getString("OthIDType") == null)
/*  948 */         this.othIDType = null;
/*      */       else {
/*  950 */         this.othIDType = rs.getString("OthIDType").trim();
/*      */       }
/*  952 */       if (rs.getString("OthIDNo") == null)
/*  953 */         this.othIDNo = null;
/*      */       else {
/*  955 */         this.othIDNo = rs.getString("OthIDNo").trim();
/*      */       }
/*  957 */       if (rs.getString("ICNo") == null)
/*  958 */         this.iCNo = null;
/*      */       else {
/*  960 */         this.iCNo = rs.getString("ICNo").trim();
/*      */       }
/*  962 */       if (rs.getString("GrpNo") == null)
/*  963 */         this.grpNo = null;
/*      */       else {
/*  965 */         this.grpNo = rs.getString("GrpNo").trim();
/*      */       }
/*  967 */       this.joinCompanyDate = rs.getDate("JoinCompanyDate");
/*  968 */       this.startWorkDate = rs.getDate("StartWorkDate");
/*  969 */       if (rs.getString("Position") == null)
/*  970 */         this.position = null;
/*      */       else {
/*  972 */         this.position = rs.getString("Position").trim();
/*      */       }
/*  974 */       this.salary = rs.getDouble("Salary");
/*  975 */       if (rs.getString("OccupationType") == null)
/*  976 */         this.occupationType = null;
/*      */       else {
/*  978 */         this.occupationType = rs.getString("OccupationType").trim();
/*      */       }
/*  980 */       if (rs.getString("OccupationCode") == null)
/*  981 */         this.occupationCode = null;
/*      */       else {
/*  983 */         this.occupationCode = rs.getString("OccupationCode").trim();
/*      */       }
/*  985 */       if (rs.getString("PartOccupationType") == null)
/*  986 */         this.partOccupationType = null;
/*      */       else {
/*  988 */         this.partOccupationType = rs.getString("PartOccupationType").trim();
/*      */       }
/*  990 */       if (rs.getString("PartOccupationCode") == null)
/*  991 */         this.partOccupationCode = null;
/*      */       else {
/*  993 */         this.partOccupationCode = rs.getString("PartOccupationCode").trim();
/*      */       }
/*  995 */       if (rs.getString("WorkType") == null)
/*  996 */         this.workType = null;
/*      */       else {
/*  998 */         this.workType = rs.getString("WorkType").trim();
/*      */       }
/* 1000 */       if (rs.getString("PluralityType") == null)
/* 1001 */         this.pluralityType = null;
/*      */       else {
/* 1003 */         this.pluralityType = rs.getString("PluralityType").trim();
/*      */       }
/* 1005 */       this.deathDate = rs.getDate("DeathDate");
/* 1006 */       if (rs.getString("SmokeFlag") == null)
/* 1007 */         this.smokeFlag = null;
/*      */       else {
/* 1009 */         this.smokeFlag = rs.getString("SmokeFlag").trim();
/*      */       }
/* 1011 */       if (rs.getString("BlacklistFlag") == null)
/* 1012 */         this.blacklistFlag = null;
/*      */       else {
/* 1014 */         this.blacklistFlag = rs.getString("BlacklistFlag").trim();
/*      */       }
/* 1016 */       if (rs.getString("Proterty") == null)
/* 1017 */         this.proterty = null;
/*      */       else {
/* 1019 */         this.proterty = rs.getString("Proterty").trim();
/*      */       }
/* 1021 */       if (rs.getString("Remark") == null)
/* 1022 */         this.remark = null;
/*      */       else {
/* 1024 */         this.remark = rs.getString("Remark").trim();
/*      */       }
/* 1026 */       if (rs.getString("State") == null)
/* 1027 */         this.state = null;
/*      */       else {
/* 1029 */         this.state = rs.getString("State").trim();
/*      */       }
/* 1031 */       if (rs.getString("VIPValue") == null)
/* 1032 */         this.vIPValue = null;
/*      */       else {
/* 1034 */         this.vIPValue = rs.getString("VIPValue").trim();
/*      */       }
/* 1036 */       if (rs.getString("Operator") == null)
/* 1037 */         this.operator = null;
/*      */       else {
/* 1039 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/* 1041 */       if (rs.getString("ManageCom") == null)
/* 1042 */         this.manageCom = null;
/*      */       else {
/* 1044 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/* 1046 */       this.makeDate = rs.getDate("MakeDate");
/* 1047 */       if (rs.getString("MakeTime") == null)
/* 1048 */         this.makeTime = null;
/*      */       else {
/* 1050 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/* 1052 */       this.modifyDate = rs.getDate("ModifyDate");
/* 1053 */       if (rs.getString("ModifyTime") == null)
/* 1054 */         this.modifyTime = null;
/*      */       else {
/* 1056 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/* 1058 */       if (rs.getString("GrpName") == null)
/* 1059 */         this.grpName = null;
/*      */       else {
/* 1061 */         this.grpName = rs.getString("GrpName").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1066 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPPerson\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/* 1068 */       CError tError = new CError();
/* 1069 */       tError.moduleName = "LNPPersonSchema";
/* 1070 */       tError.functionName = "setSchema";
/* 1071 */       tError.errorMessage = sqle.toString();
/* 1072 */       this.mErrors.addOneError(tError);
/* 1073 */       return false;
/*      */     }
/* 1075 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPPersonSchema getSchema()
/*      */   {
/* 1080 */     LNPPersonSchema aLNPPersonSchema = new LNPPersonSchema();
/* 1081 */     aLNPPersonSchema.setSchema(this);
/* 1082 */     return aLNPPersonSchema;
/*      */   }
/*      */ 
/*      */   public LNPPersonDB getDB()
/*      */   {
/* 1087 */     LNPPersonDB aDBOper = new LNPPersonDB();
/* 1088 */     aDBOper.setSchema(this);
/* 1089 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1096 */     StringBuffer strReturn = new StringBuffer(256);
/* 1097 */     strReturn.append(StrTool.cTrim(this.customerId)); strReturn.append("|");
/* 1098 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/* 1099 */     strReturn.append(StrTool.cTrim(this.customerNo)); strReturn.append("|");
/* 1100 */     strReturn.append(StrTool.cTrim(this.appellation)); strReturn.append("|");
/* 1101 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/* 1102 */     strReturn.append(StrTool.cTrim(this.sex)); strReturn.append("|");
/* 1103 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.birthday))); strReturn.append("|");
/* 1104 */     strReturn.append(ChgData.chgData(this.age)); strReturn.append("|");
/* 1105 */     strReturn.append(StrTool.cTrim(this.ageType)); strReturn.append("|");
/* 1106 */     strReturn.append(StrTool.cTrim(this.appntType)); strReturn.append("|");
/* 1107 */     strReturn.append(StrTool.cTrim(this.iDType)); strReturn.append("|");
/* 1108 */     strReturn.append(StrTool.cTrim(this.iDNo)); strReturn.append("|");
/* 1109 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.iDValidity))); strReturn.append("|");
/* 1110 */     strReturn.append(StrTool.cTrim(this.iDPerpetual)); strReturn.append("|");
/* 1111 */     strReturn.append(StrTool.cTrim(this.password)); strReturn.append("|");
/* 1112 */     strReturn.append(StrTool.cTrim(this.nativePlace)); strReturn.append("|");
/* 1113 */     strReturn.append(StrTool.cTrim(this.nationality)); strReturn.append("|");
/* 1114 */     strReturn.append(StrTool.cTrim(this.rgtAddress)); strReturn.append("|");
/* 1115 */     strReturn.append(StrTool.cTrim(this.marriage)); strReturn.append("|");
/* 1116 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.marriageDate))); strReturn.append("|");
/* 1117 */     strReturn.append(StrTool.cTrim(this.health)); strReturn.append("|");
/* 1118 */     strReturn.append(ChgData.chgData(this.stature)); strReturn.append("|");
/* 1119 */     strReturn.append(ChgData.chgData(this.avoirdupois)); strReturn.append("|");
/* 1120 */     strReturn.append(StrTool.cTrim(this.degree)); strReturn.append("|");
/* 1121 */     strReturn.append(StrTool.cTrim(this.creditGrade)); strReturn.append("|");
/* 1122 */     strReturn.append(StrTool.cTrim(this.bankCode)); strReturn.append("|");
/* 1123 */     strReturn.append(StrTool.cTrim(this.bankAccNo)); strReturn.append("|");
/* 1124 */     strReturn.append(StrTool.cTrim(this.accName)); strReturn.append("|");
/* 1125 */     strReturn.append(StrTool.cTrim(this.othIDType)); strReturn.append("|");
/* 1126 */     strReturn.append(StrTool.cTrim(this.othIDNo)); strReturn.append("|");
/* 1127 */     strReturn.append(StrTool.cTrim(this.iCNo)); strReturn.append("|");
/* 1128 */     strReturn.append(StrTool.cTrim(this.grpNo)); strReturn.append("|");
/* 1129 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.joinCompanyDate))); strReturn.append("|");
/* 1130 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startWorkDate))); strReturn.append("|");
/* 1131 */     strReturn.append(StrTool.cTrim(this.position)); strReturn.append("|");
/* 1132 */     strReturn.append(ChgData.chgData(this.salary)); strReturn.append("|");
/* 1133 */     strReturn.append(StrTool.cTrim(this.occupationType)); strReturn.append("|");
/* 1134 */     strReturn.append(StrTool.cTrim(this.occupationCode)); strReturn.append("|");
/* 1135 */     strReturn.append(StrTool.cTrim(this.partOccupationType)); strReturn.append("|");
/* 1136 */     strReturn.append(StrTool.cTrim(this.partOccupationCode)); strReturn.append("|");
/* 1137 */     strReturn.append(StrTool.cTrim(this.workType)); strReturn.append("|");
/* 1138 */     strReturn.append(StrTool.cTrim(this.pluralityType)); strReturn.append("|");
/* 1139 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.deathDate))); strReturn.append("|");
/* 1140 */     strReturn.append(StrTool.cTrim(this.smokeFlag)); strReturn.append("|");
/* 1141 */     strReturn.append(StrTool.cTrim(this.blacklistFlag)); strReturn.append("|");
/* 1142 */     strReturn.append(StrTool.cTrim(this.proterty)); strReturn.append("|");
/* 1143 */     strReturn.append(StrTool.cTrim(this.remark)); strReturn.append("|");
/* 1144 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/* 1145 */     strReturn.append(StrTool.cTrim(this.vIPValue)); strReturn.append("|");
/* 1146 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 1147 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/* 1148 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 1149 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 1150 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 1151 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/* 1152 */     strReturn.append(StrTool.cTrim(this.grpName));
/* 1153 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1161 */       this.customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1162 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1163 */       this.customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1164 */       this.appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1165 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1166 */       this.sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1167 */       this.birthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
/* 1168 */       this.age = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).intValue();
/* 1169 */       this.ageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1170 */       this.appntType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1171 */       this.iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1172 */       this.iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1173 */       this.iDValidity = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
/* 1174 */       this.iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1175 */       this.password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1176 */       this.nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1177 */       this.nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1178 */       this.rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1179 */       this.marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1180 */       this.marriageDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/* 1181 */       this.health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1182 */       this.stature = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 22, "|"))).doubleValue();
/* 1183 */       this.avoirdupois = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|"))).doubleValue();
/* 1184 */       this.degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1185 */       this.creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1186 */       this.bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1187 */       this.bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1188 */       this.accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1189 */       this.othIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 1190 */       this.othIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1191 */       this.iCNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/* 1192 */       this.grpNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 1193 */       this.joinCompanyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|"));
/* 1194 */       this.startWorkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|"));
/* 1195 */       this.position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 1196 */       this.salary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|"))).doubleValue();
/* 1197 */       this.occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 1198 */       this.occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/* 1199 */       this.partOccupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/* 1200 */       this.partOccupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1201 */       this.workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1202 */       this.pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1203 */       this.deathDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|"));
/* 1204 */       this.smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1205 */       this.blacklistFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 1206 */       this.proterty = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 1207 */       this.remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 1208 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 1209 */       this.vIPValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/* 1210 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
/* 1211 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
/* 1212 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|"));
/* 1213 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
/* 1214 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|"));
/* 1215 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
/* 1216 */       this.grpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1221 */       CError tError = new CError();
/* 1222 */       tError.moduleName = "LNPPersonSchema";
/* 1223 */       tError.functionName = "decode";
/* 1224 */       tError.errorMessage = ex.toString();
/* 1225 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1227 */       return false;
/*      */     }
/* 1229 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1235 */     String strReturn = "";
/* 1236 */     if (FCode.equalsIgnoreCase("customerId"))
/*      */     {
/* 1238 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerId));
/*      */     }
/* 1240 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 1242 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/* 1244 */     if (FCode.equalsIgnoreCase("customerNo"))
/*      */     {
/* 1246 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerNo));
/*      */     }
/* 1248 */     if (FCode.equalsIgnoreCase("appellation"))
/*      */     {
/* 1250 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appellation));
/*      */     }
/* 1252 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/* 1254 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/* 1256 */     if (FCode.equalsIgnoreCase("sex"))
/*      */     {
/* 1258 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sex));
/*      */     }
/* 1260 */     if (FCode.equalsIgnoreCase("birthday"))
/*      */     {
/* 1262 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
/*      */     }
/* 1264 */     if (FCode.equalsIgnoreCase("age"))
/*      */     {
/* 1266 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.age));
/*      */     }
/* 1268 */     if (FCode.equalsIgnoreCase("ageType"))
/*      */     {
/* 1270 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ageType));
/*      */     }
/* 1272 */     if (FCode.equalsIgnoreCase("appntType"))
/*      */     {
/* 1274 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntType));
/*      */     }
/* 1276 */     if (FCode.equalsIgnoreCase("iDType"))
/*      */     {
/* 1278 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDType));
/*      */     }
/* 1280 */     if (FCode.equalsIgnoreCase("iDNo"))
/*      */     {
/* 1282 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDNo));
/*      */     }
/* 1284 */     if (FCode.equalsIgnoreCase("iDValidity"))
/*      */     {
/* 1286 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getIDValidity()));
/*      */     }
/* 1288 */     if (FCode.equalsIgnoreCase("iDPerpetual"))
/*      */     {
/* 1290 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDPerpetual));
/*      */     }
/* 1292 */     if (FCode.equalsIgnoreCase("password"))
/*      */     {
/* 1294 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.password));
/*      */     }
/* 1296 */     if (FCode.equalsIgnoreCase("nativePlace"))
/*      */     {
/* 1298 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nativePlace));
/*      */     }
/* 1300 */     if (FCode.equalsIgnoreCase("nationality"))
/*      */     {
/* 1302 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nationality));
/*      */     }
/* 1304 */     if (FCode.equalsIgnoreCase("rgtAddress"))
/*      */     {
/* 1306 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rgtAddress));
/*      */     }
/* 1308 */     if (FCode.equalsIgnoreCase("marriage"))
/*      */     {
/* 1310 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.marriage));
/*      */     }
/* 1312 */     if (FCode.equalsIgnoreCase("marriageDate"))
/*      */     {
/* 1314 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
/*      */     }
/* 1316 */     if (FCode.equalsIgnoreCase("health"))
/*      */     {
/* 1318 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.health));
/*      */     }
/* 1320 */     if (FCode.equalsIgnoreCase("stature"))
/*      */     {
/* 1322 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stature));
/*      */     }
/* 1324 */     if (FCode.equalsIgnoreCase("avoirdupois"))
/*      */     {
/* 1326 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.avoirdupois));
/*      */     }
/* 1328 */     if (FCode.equalsIgnoreCase("degree"))
/*      */     {
/* 1330 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.degree));
/*      */     }
/* 1332 */     if (FCode.equalsIgnoreCase("creditGrade"))
/*      */     {
/* 1334 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.creditGrade));
/*      */     }
/* 1336 */     if (FCode.equalsIgnoreCase("bankCode"))
/*      */     {
/* 1338 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankCode));
/*      */     }
/* 1340 */     if (FCode.equalsIgnoreCase("bankAccNo"))
/*      */     {
/* 1342 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankAccNo));
/*      */     }
/* 1344 */     if (FCode.equalsIgnoreCase("accName"))
/*      */     {
/* 1346 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.accName));
/*      */     }
/* 1348 */     if (FCode.equalsIgnoreCase("othIDType"))
/*      */     {
/* 1350 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.othIDType));
/*      */     }
/* 1352 */     if (FCode.equalsIgnoreCase("othIDNo"))
/*      */     {
/* 1354 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.othIDNo));
/*      */     }
/* 1356 */     if (FCode.equalsIgnoreCase("iCNo"))
/*      */     {
/* 1358 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iCNo));
/*      */     }
/* 1360 */     if (FCode.equalsIgnoreCase("grpNo"))
/*      */     {
/* 1362 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpNo));
/*      */     }
/* 1364 */     if (FCode.equalsIgnoreCase("joinCompanyDate"))
/*      */     {
/* 1366 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
/*      */     }
/* 1368 */     if (FCode.equalsIgnoreCase("startWorkDate"))
/*      */     {
/* 1370 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
/*      */     }
/* 1372 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/* 1374 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.position));
/*      */     }
/* 1376 */     if (FCode.equalsIgnoreCase("salary"))
/*      */     {
/* 1378 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.salary));
/*      */     }
/* 1380 */     if (FCode.equalsIgnoreCase("occupationType"))
/*      */     {
/* 1382 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationType));
/*      */     }
/* 1384 */     if (FCode.equalsIgnoreCase("occupationCode"))
/*      */     {
/* 1386 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationCode));
/*      */     }
/* 1388 */     if (FCode.equalsIgnoreCase("partOccupationType"))
/*      */     {
/* 1390 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.partOccupationType));
/*      */     }
/* 1392 */     if (FCode.equalsIgnoreCase("partOccupationCode"))
/*      */     {
/* 1394 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.partOccupationCode));
/*      */     }
/* 1396 */     if (FCode.equalsIgnoreCase("workType"))
/*      */     {
/* 1398 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.workType));
/*      */     }
/* 1400 */     if (FCode.equalsIgnoreCase("pluralityType"))
/*      */     {
/* 1402 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pluralityType));
/*      */     }
/* 1404 */     if (FCode.equalsIgnoreCase("deathDate"))
/*      */     {
/* 1406 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDeathDate()));
/*      */     }
/* 1408 */     if (FCode.equalsIgnoreCase("smokeFlag"))
/*      */     {
/* 1410 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.smokeFlag));
/*      */     }
/* 1412 */     if (FCode.equalsIgnoreCase("blacklistFlag"))
/*      */     {
/* 1414 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.blacklistFlag));
/*      */     }
/* 1416 */     if (FCode.equalsIgnoreCase("proterty"))
/*      */     {
/* 1418 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proterty));
/*      */     }
/* 1420 */     if (FCode.equalsIgnoreCase("remark"))
/*      */     {
/* 1422 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark));
/*      */     }
/* 1424 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1426 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/* 1428 */     if (FCode.equalsIgnoreCase("vIPValue"))
/*      */     {
/* 1430 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vIPValue));
/*      */     }
/* 1432 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1434 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1436 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1438 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 1440 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1442 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 1444 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1446 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1448 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1450 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 1452 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1454 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1456 */     if (FCode.equalsIgnoreCase("grpName"))
/*      */     {
/* 1458 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpName));
/*      */     }
/* 1460 */     if (strReturn.equals(""))
/*      */     {
/* 1462 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1465 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1472 */     String strFieldValue = "";
/* 1473 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1475 */       strFieldValue = StrTool.GBKToUnicode(this.customerId);
/* 1476 */       break;
/*      */     case 1:
/* 1478 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/* 1479 */       break;
/*      */     case 2:
/* 1481 */       strFieldValue = StrTool.GBKToUnicode(this.customerNo);
/* 1482 */       break;
/*      */     case 3:
/* 1484 */       strFieldValue = StrTool.GBKToUnicode(this.appellation);
/* 1485 */       break;
/*      */     case 4:
/* 1487 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/* 1488 */       break;
/*      */     case 5:
/* 1490 */       strFieldValue = StrTool.GBKToUnicode(this.sex);
/* 1491 */       break;
/*      */     case 6:
/* 1493 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
/* 1494 */       break;
/*      */     case 7:
/* 1496 */       strFieldValue = String.valueOf(this.age);
/* 1497 */       break;
/*      */     case 8:
/* 1499 */       strFieldValue = StrTool.GBKToUnicode(this.ageType);
/* 1500 */       break;
/*      */     case 9:
/* 1502 */       strFieldValue = StrTool.GBKToUnicode(this.appntType);
/* 1503 */       break;
/*      */     case 10:
/* 1505 */       strFieldValue = StrTool.GBKToUnicode(this.iDType);
/* 1506 */       break;
/*      */     case 11:
/* 1508 */       strFieldValue = StrTool.GBKToUnicode(this.iDNo);
/* 1509 */       break;
/*      */     case 12:
/* 1511 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getIDValidity()));
/* 1512 */       break;
/*      */     case 13:
/* 1514 */       strFieldValue = StrTool.GBKToUnicode(this.iDPerpetual);
/* 1515 */       break;
/*      */     case 14:
/* 1517 */       strFieldValue = StrTool.GBKToUnicode(this.password);
/* 1518 */       break;
/*      */     case 15:
/* 1520 */       strFieldValue = StrTool.GBKToUnicode(this.nativePlace);
/* 1521 */       break;
/*      */     case 16:
/* 1523 */       strFieldValue = StrTool.GBKToUnicode(this.nationality);
/* 1524 */       break;
/*      */     case 17:
/* 1526 */       strFieldValue = StrTool.GBKToUnicode(this.rgtAddress);
/* 1527 */       break;
/*      */     case 18:
/* 1529 */       strFieldValue = StrTool.GBKToUnicode(this.marriage);
/* 1530 */       break;
/*      */     case 19:
/* 1532 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
/* 1533 */       break;
/*      */     case 20:
/* 1535 */       strFieldValue = StrTool.GBKToUnicode(this.health);
/* 1536 */       break;
/*      */     case 21:
/* 1538 */       strFieldValue = String.valueOf(this.stature);
/* 1539 */       break;
/*      */     case 22:
/* 1541 */       strFieldValue = String.valueOf(this.avoirdupois);
/* 1542 */       break;
/*      */     case 23:
/* 1544 */       strFieldValue = StrTool.GBKToUnicode(this.degree);
/* 1545 */       break;
/*      */     case 24:
/* 1547 */       strFieldValue = StrTool.GBKToUnicode(this.creditGrade);
/* 1548 */       break;
/*      */     case 25:
/* 1550 */       strFieldValue = StrTool.GBKToUnicode(this.bankCode);
/* 1551 */       break;
/*      */     case 26:
/* 1553 */       strFieldValue = StrTool.GBKToUnicode(this.bankAccNo);
/* 1554 */       break;
/*      */     case 27:
/* 1556 */       strFieldValue = StrTool.GBKToUnicode(this.accName);
/* 1557 */       break;
/*      */     case 28:
/* 1559 */       strFieldValue = StrTool.GBKToUnicode(this.othIDType);
/* 1560 */       break;
/*      */     case 29:
/* 1562 */       strFieldValue = StrTool.GBKToUnicode(this.othIDNo);
/* 1563 */       break;
/*      */     case 30:
/* 1565 */       strFieldValue = StrTool.GBKToUnicode(this.iCNo);
/* 1566 */       break;
/*      */     case 31:
/* 1568 */       strFieldValue = StrTool.GBKToUnicode(this.grpNo);
/* 1569 */       break;
/*      */     case 32:
/* 1571 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
/* 1572 */       break;
/*      */     case 33:
/* 1574 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
/* 1575 */       break;
/*      */     case 34:
/* 1577 */       strFieldValue = StrTool.GBKToUnicode(this.position);
/* 1578 */       break;
/*      */     case 35:
/* 1580 */       strFieldValue = String.valueOf(this.salary);
/* 1581 */       break;
/*      */     case 36:
/* 1583 */       strFieldValue = StrTool.GBKToUnicode(this.occupationType);
/* 1584 */       break;
/*      */     case 37:
/* 1586 */       strFieldValue = StrTool.GBKToUnicode(this.occupationCode);
/* 1587 */       break;
/*      */     case 38:
/* 1589 */       strFieldValue = StrTool.GBKToUnicode(this.partOccupationType);
/* 1590 */       break;
/*      */     case 39:
/* 1592 */       strFieldValue = StrTool.GBKToUnicode(this.partOccupationCode);
/* 1593 */       break;
/*      */     case 40:
/* 1595 */       strFieldValue = StrTool.GBKToUnicode(this.workType);
/* 1596 */       break;
/*      */     case 41:
/* 1598 */       strFieldValue = StrTool.GBKToUnicode(this.pluralityType);
/* 1599 */       break;
/*      */     case 42:
/* 1601 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDeathDate()));
/* 1602 */       break;
/*      */     case 43:
/* 1604 */       strFieldValue = StrTool.GBKToUnicode(this.smokeFlag);
/* 1605 */       break;
/*      */     case 44:
/* 1607 */       strFieldValue = StrTool.GBKToUnicode(this.blacklistFlag);
/* 1608 */       break;
/*      */     case 45:
/* 1610 */       strFieldValue = StrTool.GBKToUnicode(this.proterty);
/* 1611 */       break;
/*      */     case 46:
/* 1613 */       strFieldValue = StrTool.GBKToUnicode(this.remark);
/* 1614 */       break;
/*      */     case 47:
/* 1616 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 1617 */       break;
/*      */     case 48:
/* 1619 */       strFieldValue = StrTool.GBKToUnicode(this.vIPValue);
/* 1620 */       break;
/*      */     case 49:
/* 1622 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1623 */       break;
/*      */     case 50:
/* 1625 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1626 */       break;
/*      */     case 51:
/* 1628 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1629 */       break;
/*      */     case 52:
/* 1631 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1632 */       break;
/*      */     case 53:
/* 1634 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1635 */       break;
/*      */     case 54:
/* 1637 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1638 */       break;
/*      */     case 55:
/* 1640 */       strFieldValue = StrTool.GBKToUnicode(this.grpName);
/* 1641 */       break;
/*      */     default:
/* 1643 */       strFieldValue = "";
/*      */     }
/* 1645 */     if (strFieldValue.equals("")) {
/* 1646 */       strFieldValue = "null";
/*      */     }
/* 1648 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1654 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1655 */       return false;
/*      */     }
/* 1657 */     if (FCode.equalsIgnoreCase("customerId"))
/*      */     {
/* 1659 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1661 */         this.customerId = FValue.trim();
/*      */       }
/*      */       else
/* 1664 */         this.customerId = null;
/*      */     }
/* 1666 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 1668 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1670 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/* 1673 */         this.agentCode = null;
/*      */     }
/* 1675 */     if (FCode.equalsIgnoreCase("customerNo"))
/*      */     {
/* 1677 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1679 */         this.customerNo = FValue.trim();
/*      */       }
/*      */       else
/* 1682 */         this.customerNo = null;
/*      */     }
/* 1684 */     if (FCode.equalsIgnoreCase("appellation"))
/*      */     {
/* 1686 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1688 */         this.appellation = FValue.trim();
/*      */       }
/*      */       else
/* 1691 */         this.appellation = null;
/*      */     }
/* 1693 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/* 1695 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1697 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/* 1700 */         this.name = null;
/*      */     }
/* 1702 */     if (FCode.equalsIgnoreCase("sex"))
/*      */     {
/* 1704 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1706 */         this.sex = FValue.trim();
/*      */       }
/*      */       else
/* 1709 */         this.sex = null;
/*      */     }
/* 1711 */     if (FCode.equalsIgnoreCase("birthday"))
/*      */     {
/* 1713 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1715 */         this.birthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1718 */         this.birthday = null;
/*      */     }
/* 1720 */     if (FCode.equalsIgnoreCase("age"))
/*      */     {
/* 1722 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1724 */         Integer tInteger = new Integer(FValue);
/* 1725 */         int i = tInteger.intValue();
/* 1726 */         this.age = i;
/*      */       }
/*      */     }
/* 1729 */     if (FCode.equalsIgnoreCase("ageType"))
/*      */     {
/* 1731 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1733 */         this.ageType = FValue.trim();
/*      */       }
/*      */       else
/* 1736 */         this.ageType = null;
/*      */     }
/* 1738 */     if (FCode.equalsIgnoreCase("appntType"))
/*      */     {
/* 1740 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1742 */         this.appntType = FValue.trim();
/*      */       }
/*      */       else
/* 1745 */         this.appntType = null;
/*      */     }
/* 1747 */     if (FCode.equalsIgnoreCase("iDType"))
/*      */     {
/* 1749 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1751 */         this.iDType = FValue.trim();
/*      */       }
/*      */       else
/* 1754 */         this.iDType = null;
/*      */     }
/* 1756 */     if (FCode.equalsIgnoreCase("iDNo"))
/*      */     {
/* 1758 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1760 */         this.iDNo = FValue.trim();
/*      */       }
/*      */       else
/* 1763 */         this.iDNo = null;
/*      */     }
/* 1765 */     if (FCode.equalsIgnoreCase("iDValidity"))
/*      */     {
/* 1767 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1769 */         this.iDValidity = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1772 */         this.iDValidity = null;
/*      */     }
/* 1774 */     if (FCode.equalsIgnoreCase("iDPerpetual"))
/*      */     {
/* 1776 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1778 */         this.iDPerpetual = FValue.trim();
/*      */       }
/*      */       else
/* 1781 */         this.iDPerpetual = null;
/*      */     }
/* 1783 */     if (FCode.equalsIgnoreCase("password"))
/*      */     {
/* 1785 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1787 */         this.password = FValue.trim();
/*      */       }
/*      */       else
/* 1790 */         this.password = null;
/*      */     }
/* 1792 */     if (FCode.equalsIgnoreCase("nativePlace"))
/*      */     {
/* 1794 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1796 */         this.nativePlace = FValue.trim();
/*      */       }
/*      */       else
/* 1799 */         this.nativePlace = null;
/*      */     }
/* 1801 */     if (FCode.equalsIgnoreCase("nationality"))
/*      */     {
/* 1803 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1805 */         this.nationality = FValue.trim();
/*      */       }
/*      */       else
/* 1808 */         this.nationality = null;
/*      */     }
/* 1810 */     if (FCode.equalsIgnoreCase("rgtAddress"))
/*      */     {
/* 1812 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1814 */         this.rgtAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1817 */         this.rgtAddress = null;
/*      */     }
/* 1819 */     if (FCode.equalsIgnoreCase("marriage"))
/*      */     {
/* 1821 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1823 */         this.marriage = FValue.trim();
/*      */       }
/*      */       else
/* 1826 */         this.marriage = null;
/*      */     }
/* 1828 */     if (FCode.equalsIgnoreCase("marriageDate"))
/*      */     {
/* 1830 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1832 */         this.marriageDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1835 */         this.marriageDate = null;
/*      */     }
/* 1837 */     if (FCode.equalsIgnoreCase("health"))
/*      */     {
/* 1839 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1841 */         this.health = FValue.trim();
/*      */       }
/*      */       else
/* 1844 */         this.health = null;
/*      */     }
/* 1846 */     if (FCode.equalsIgnoreCase("stature"))
/*      */     {
/* 1848 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1850 */         Double tDouble = new Double(FValue);
/* 1851 */         double d = tDouble.doubleValue();
/* 1852 */         this.stature = d;
/*      */       }
/*      */     }
/* 1855 */     if (FCode.equalsIgnoreCase("avoirdupois"))
/*      */     {
/* 1857 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1859 */         Double tDouble = new Double(FValue);
/* 1860 */         double d = tDouble.doubleValue();
/* 1861 */         this.avoirdupois = d;
/*      */       }
/*      */     }
/* 1864 */     if (FCode.equalsIgnoreCase("degree"))
/*      */     {
/* 1866 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1868 */         this.degree = FValue.trim();
/*      */       }
/*      */       else
/* 1871 */         this.degree = null;
/*      */     }
/* 1873 */     if (FCode.equalsIgnoreCase("creditGrade"))
/*      */     {
/* 1875 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1877 */         this.creditGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1880 */         this.creditGrade = null;
/*      */     }
/* 1882 */     if (FCode.equalsIgnoreCase("bankCode"))
/*      */     {
/* 1884 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1886 */         this.bankCode = FValue.trim();
/*      */       }
/*      */       else
/* 1889 */         this.bankCode = null;
/*      */     }
/* 1891 */     if (FCode.equalsIgnoreCase("bankAccNo"))
/*      */     {
/* 1893 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1895 */         this.bankAccNo = FValue.trim();
/*      */       }
/*      */       else
/* 1898 */         this.bankAccNo = null;
/*      */     }
/* 1900 */     if (FCode.equalsIgnoreCase("accName"))
/*      */     {
/* 1902 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1904 */         this.accName = FValue.trim();
/*      */       }
/*      */       else
/* 1907 */         this.accName = null;
/*      */     }
/* 1909 */     if (FCode.equalsIgnoreCase("othIDType"))
/*      */     {
/* 1911 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1913 */         this.othIDType = FValue.trim();
/*      */       }
/*      */       else
/* 1916 */         this.othIDType = null;
/*      */     }
/* 1918 */     if (FCode.equalsIgnoreCase("othIDNo"))
/*      */     {
/* 1920 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1922 */         this.othIDNo = FValue.trim();
/*      */       }
/*      */       else
/* 1925 */         this.othIDNo = null;
/*      */     }
/* 1927 */     if (FCode.equalsIgnoreCase("iCNo"))
/*      */     {
/* 1929 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1931 */         this.iCNo = FValue.trim();
/*      */       }
/*      */       else
/* 1934 */         this.iCNo = null;
/*      */     }
/* 1936 */     if (FCode.equalsIgnoreCase("grpNo"))
/*      */     {
/* 1938 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1940 */         this.grpNo = FValue.trim();
/*      */       }
/*      */       else
/* 1943 */         this.grpNo = null;
/*      */     }
/* 1945 */     if (FCode.equalsIgnoreCase("joinCompanyDate"))
/*      */     {
/* 1947 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1949 */         this.joinCompanyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1952 */         this.joinCompanyDate = null;
/*      */     }
/* 1954 */     if (FCode.equalsIgnoreCase("startWorkDate"))
/*      */     {
/* 1956 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1958 */         this.startWorkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1961 */         this.startWorkDate = null;
/*      */     }
/* 1963 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/* 1965 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1967 */         this.position = FValue.trim();
/*      */       }
/*      */       else
/* 1970 */         this.position = null;
/*      */     }
/* 1972 */     if (FCode.equalsIgnoreCase("salary"))
/*      */     {
/* 1974 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1976 */         Double tDouble = new Double(FValue);
/* 1977 */         double d = tDouble.doubleValue();
/* 1978 */         this.salary = d;
/*      */       }
/*      */     }
/* 1981 */     if (FCode.equalsIgnoreCase("occupationType"))
/*      */     {
/* 1983 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1985 */         this.occupationType = FValue.trim();
/*      */       }
/*      */       else
/* 1988 */         this.occupationType = null;
/*      */     }
/* 1990 */     if (FCode.equalsIgnoreCase("occupationCode"))
/*      */     {
/* 1992 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1994 */         this.occupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 1997 */         this.occupationCode = null;
/*      */     }
/* 1999 */     if (FCode.equalsIgnoreCase("partOccupationType"))
/*      */     {
/* 2001 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2003 */         this.partOccupationType = FValue.trim();
/*      */       }
/*      */       else
/* 2006 */         this.partOccupationType = null;
/*      */     }
/* 2008 */     if (FCode.equalsIgnoreCase("partOccupationCode"))
/*      */     {
/* 2010 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2012 */         this.partOccupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 2015 */         this.partOccupationCode = null;
/*      */     }
/* 2017 */     if (FCode.equalsIgnoreCase("workType"))
/*      */     {
/* 2019 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2021 */         this.workType = FValue.trim();
/*      */       }
/*      */       else
/* 2024 */         this.workType = null;
/*      */     }
/* 2026 */     if (FCode.equalsIgnoreCase("pluralityType"))
/*      */     {
/* 2028 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2030 */         this.pluralityType = FValue.trim();
/*      */       }
/*      */       else
/* 2033 */         this.pluralityType = null;
/*      */     }
/* 2035 */     if (FCode.equalsIgnoreCase("deathDate"))
/*      */     {
/* 2037 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2039 */         this.deathDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2042 */         this.deathDate = null;
/*      */     }
/* 2044 */     if (FCode.equalsIgnoreCase("smokeFlag"))
/*      */     {
/* 2046 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2048 */         this.smokeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2051 */         this.smokeFlag = null;
/*      */     }
/* 2053 */     if (FCode.equalsIgnoreCase("blacklistFlag"))
/*      */     {
/* 2055 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2057 */         this.blacklistFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2060 */         this.blacklistFlag = null;
/*      */     }
/* 2062 */     if (FCode.equalsIgnoreCase("proterty"))
/*      */     {
/* 2064 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2066 */         this.proterty = FValue.trim();
/*      */       }
/*      */       else
/* 2069 */         this.proterty = null;
/*      */     }
/* 2071 */     if (FCode.equalsIgnoreCase("remark"))
/*      */     {
/* 2073 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2075 */         this.remark = FValue.trim();
/*      */       }
/*      */       else
/* 2078 */         this.remark = null;
/*      */     }
/* 2080 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 2082 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2084 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 2087 */         this.state = null;
/*      */     }
/* 2089 */     if (FCode.equalsIgnoreCase("vIPValue"))
/*      */     {
/* 2091 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2093 */         this.vIPValue = FValue.trim();
/*      */       }
/*      */       else
/* 2096 */         this.vIPValue = null;
/*      */     }
/* 2098 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 2100 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2102 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 2105 */         this.operator = null;
/*      */     }
/* 2107 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 2109 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2111 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 2114 */         this.manageCom = null;
/*      */     }
/* 2116 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 2118 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2120 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2123 */         this.makeDate = null;
/*      */     }
/* 2125 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 2127 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2129 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 2132 */         this.makeTime = null;
/*      */     }
/* 2134 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 2136 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2138 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2141 */         this.modifyDate = null;
/*      */     }
/* 2143 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 2145 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2147 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 2150 */         this.modifyTime = null;
/*      */     }
/* 2152 */     if (FCode.equalsIgnoreCase("grpName"))
/*      */     {
/* 2154 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2156 */         this.grpName = FValue.trim();
/*      */       }
/*      */       else
/* 2159 */         this.grpName = null;
/*      */     }
/* 2161 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 2166 */     if (otherObject == null) return false;
/* 2167 */     if (this == otherObject) return true;
/* 2168 */     if (getClass() != otherObject.getClass()) return false;
/* 2169 */     LNPPersonSchema other = (LNPPersonSchema)otherObject;
/* 2170 */     if ((this.customerId == null) && (other.getCustomerId() != null)) return false;
/* 2171 */     if ((this.customerId != null) && (!this.customerId.equals(other.getCustomerId()))) return false;
/* 2172 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/* 2173 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/* 2174 */     if ((this.customerNo == null) && (other.getCustomerNo() != null)) return false;
/* 2175 */     if ((this.customerNo != null) && (!this.customerNo.equals(other.getCustomerNo()))) return false;
/* 2176 */     if ((this.appellation == null) && (other.getAppellation() != null)) return false;
/* 2177 */     if ((this.appellation != null) && (!this.appellation.equals(other.getAppellation()))) return false;
/* 2178 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 2179 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 2180 */     if ((this.sex == null) && (other.getSex() != null)) return false;
/* 2181 */     if ((this.sex != null) && (!this.sex.equals(other.getSex()))) return false;
/* 2182 */     if ((this.birthday == null) && (other.getBirthday() != null)) return false;
/* 2183 */     if ((this.birthday != null) && (!this.fDate.getString(this.birthday).equals(other.getBirthday()))) return false;
/* 2184 */     if (this.age != other.getAge()) return false;
/* 2185 */     if ((this.ageType == null) && (other.getAgeType() != null)) return false;
/* 2186 */     if ((this.ageType != null) && (!this.ageType.equals(other.getAgeType()))) return false;
/* 2187 */     if ((this.appntType == null) && (other.getAppntType() != null)) return false;
/* 2188 */     if ((this.appntType != null) && (!this.appntType.equals(other.getAppntType()))) return false;
/* 2189 */     if ((this.iDType == null) && (other.getIDType() != null)) return false;
/* 2190 */     if ((this.iDType != null) && (!this.iDType.equals(other.getIDType()))) return false;
/* 2191 */     if ((this.iDNo == null) && (other.getIDNo() != null)) return false;
/* 2192 */     if ((this.iDNo != null) && (!this.iDNo.equals(other.getIDNo()))) return false;
/* 2193 */     if ((this.iDValidity == null) && (other.getIDValidity() != null)) return false;
/* 2194 */     if ((this.iDValidity != null) && (!this.fDate.getString(this.iDValidity).equals(other.getIDValidity()))) return false;
/* 2195 */     if ((this.iDPerpetual == null) && (other.getIDPerpetual() != null)) return false;
/* 2196 */     if ((this.iDPerpetual != null) && (!this.iDPerpetual.equals(other.getIDPerpetual()))) return false;
/* 2197 */     if ((this.password == null) && (other.getPassword() != null)) return false;
/* 2198 */     if ((this.password != null) && (!this.password.equals(other.getPassword()))) return false;
/* 2199 */     if ((this.nativePlace == null) && (other.getNativePlace() != null)) return false;
/* 2200 */     if ((this.nativePlace != null) && (!this.nativePlace.equals(other.getNativePlace()))) return false;
/* 2201 */     if ((this.nationality == null) && (other.getNationality() != null)) return false;
/* 2202 */     if ((this.nationality != null) && (!this.nationality.equals(other.getNationality()))) return false;
/* 2203 */     if ((this.rgtAddress == null) && (other.getRgtAddress() != null)) return false;
/* 2204 */     if ((this.rgtAddress != null) && (!this.rgtAddress.equals(other.getRgtAddress()))) return false;
/* 2205 */     if ((this.marriage == null) && (other.getMarriage() != null)) return false;
/* 2206 */     if ((this.marriage != null) && (!this.marriage.equals(other.getMarriage()))) return false;
/* 2207 */     if ((this.marriageDate == null) && (other.getMarriageDate() != null)) return false;
/* 2208 */     if ((this.marriageDate != null) && (!this.fDate.getString(this.marriageDate).equals(other.getMarriageDate()))) return false;
/* 2209 */     if ((this.health == null) && (other.getHealth() != null)) return false;
/* 2210 */     if ((this.health != null) && (!this.health.equals(other.getHealth()))) return false;
/* 2211 */     if (Double.doubleToLongBits(this.stature) != Double.doubleToLongBits(other.getStature())) return false;
/* 2212 */     if (Double.doubleToLongBits(this.avoirdupois) != Double.doubleToLongBits(other.getAvoirdupois())) return false;
/* 2213 */     if ((this.degree == null) && (other.getDegree() != null)) return false;
/* 2214 */     if ((this.degree != null) && (!this.degree.equals(other.getDegree()))) return false;
/* 2215 */     if ((this.creditGrade == null) && (other.getCreditGrade() != null)) return false;
/* 2216 */     if ((this.creditGrade != null) && (!this.creditGrade.equals(other.getCreditGrade()))) return false;
/* 2217 */     if ((this.bankCode == null) && (other.getBankCode() != null)) return false;
/* 2218 */     if ((this.bankCode != null) && (!this.bankCode.equals(other.getBankCode()))) return false;
/* 2219 */     if ((this.bankAccNo == null) && (other.getBankAccNo() != null)) return false;
/* 2220 */     if ((this.bankAccNo != null) && (!this.bankAccNo.equals(other.getBankAccNo()))) return false;
/* 2221 */     if ((this.accName == null) && (other.getAccName() != null)) return false;
/* 2222 */     if ((this.accName != null) && (!this.accName.equals(other.getAccName()))) return false;
/* 2223 */     if ((this.othIDType == null) && (other.getOthIDType() != null)) return false;
/* 2224 */     if ((this.othIDType != null) && (!this.othIDType.equals(other.getOthIDType()))) return false;
/* 2225 */     if ((this.othIDNo == null) && (other.getOthIDNo() != null)) return false;
/* 2226 */     if ((this.othIDNo != null) && (!this.othIDNo.equals(other.getOthIDNo()))) return false;
/* 2227 */     if ((this.iCNo == null) && (other.getICNo() != null)) return false;
/* 2228 */     if ((this.iCNo != null) && (!this.iCNo.equals(other.getICNo()))) return false;
/* 2229 */     if ((this.grpNo == null) && (other.getGrpNo() != null)) return false;
/* 2230 */     if ((this.grpNo != null) && (!this.grpNo.equals(other.getGrpNo()))) return false;
/* 2231 */     if ((this.joinCompanyDate == null) && (other.getJoinCompanyDate() != null)) return false;
/* 2232 */     if ((this.joinCompanyDate != null) && (!this.fDate.getString(this.joinCompanyDate).equals(other.getJoinCompanyDate()))) return false;
/* 2233 */     if ((this.startWorkDate == null) && (other.getStartWorkDate() != null)) return false;
/* 2234 */     if ((this.startWorkDate != null) && (!this.fDate.getString(this.startWorkDate).equals(other.getStartWorkDate()))) return false;
/* 2235 */     if ((this.position == null) && (other.getPosition() != null)) return false;
/* 2236 */     if ((this.position != null) && (!this.position.equals(other.getPosition()))) return false;
/* 2237 */     if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.getSalary())) return false;
/* 2238 */     if ((this.occupationType == null) && (other.getOccupationType() != null)) return false;
/* 2239 */     if ((this.occupationType != null) && (!this.occupationType.equals(other.getOccupationType()))) return false;
/* 2240 */     if ((this.occupationCode == null) && (other.getOccupationCode() != null)) return false;
/* 2241 */     if ((this.occupationCode != null) && (!this.occupationCode.equals(other.getOccupationCode()))) return false;
/* 2242 */     if ((this.partOccupationType == null) && (other.getPartOccupationType() != null)) return false;
/* 2243 */     if ((this.partOccupationType != null) && (!this.partOccupationType.equals(other.getPartOccupationType()))) return false;
/* 2244 */     if ((this.partOccupationCode == null) && (other.getPartOccupationCode() != null)) return false;
/* 2245 */     if ((this.partOccupationCode != null) && (!this.partOccupationCode.equals(other.getPartOccupationCode()))) return false;
/* 2246 */     if ((this.workType == null) && (other.getWorkType() != null)) return false;
/* 2247 */     if ((this.workType != null) && (!this.workType.equals(other.getWorkType()))) return false;
/* 2248 */     if ((this.pluralityType == null) && (other.getPluralityType() != null)) return false;
/* 2249 */     if ((this.pluralityType != null) && (!this.pluralityType.equals(other.getPluralityType()))) return false;
/* 2250 */     if ((this.deathDate == null) && (other.getDeathDate() != null)) return false;
/* 2251 */     if ((this.deathDate != null) && (!this.fDate.getString(this.deathDate).equals(other.getDeathDate()))) return false;
/* 2252 */     if ((this.smokeFlag == null) && (other.getSmokeFlag() != null)) return false;
/* 2253 */     if ((this.smokeFlag != null) && (!this.smokeFlag.equals(other.getSmokeFlag()))) return false;
/* 2254 */     if ((this.blacklistFlag == null) && (other.getBlacklistFlag() != null)) return false;
/* 2255 */     if ((this.blacklistFlag != null) && (!this.blacklistFlag.equals(other.getBlacklistFlag()))) return false;
/* 2256 */     if ((this.proterty == null) && (other.getProterty() != null)) return false;
/* 2257 */     if ((this.proterty != null) && (!this.proterty.equals(other.getProterty()))) return false;
/* 2258 */     if ((this.remark == null) && (other.getRemark() != null)) return false;
/* 2259 */     if ((this.remark != null) && (!this.remark.equals(other.getRemark()))) return false;
/* 2260 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 2261 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 2262 */     if ((this.vIPValue == null) && (other.getVIPValue() != null)) return false;
/* 2263 */     if ((this.vIPValue != null) && (!this.vIPValue.equals(other.getVIPValue()))) return false;
/* 2264 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 2265 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 2266 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 2267 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 2268 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 2269 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 2270 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 2271 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 2272 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 2273 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 2274 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 2275 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 2276 */     if ((this.grpName == null) && (other.getGrpName() != null)) return false;
/* 2277 */     return (this.grpName == null) || (this.grpName.equals(other.getGrpName()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2284 */     return 56;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2290 */     if (strFieldName.equals("customerId")) {
/* 2291 */       return 0;
/*      */     }
/* 2293 */     if (strFieldName.equals("agentCode")) {
/* 2294 */       return 1;
/*      */     }
/* 2296 */     if (strFieldName.equals("customerNo")) {
/* 2297 */       return 2;
/*      */     }
/* 2299 */     if (strFieldName.equals("appellation")) {
/* 2300 */       return 3;
/*      */     }
/* 2302 */     if (strFieldName.equals("name")) {
/* 2303 */       return 4;
/*      */     }
/* 2305 */     if (strFieldName.equals("sex")) {
/* 2306 */       return 5;
/*      */     }
/* 2308 */     if (strFieldName.equals("birthday")) {
/* 2309 */       return 6;
/*      */     }
/* 2311 */     if (strFieldName.equals("age")) {
/* 2312 */       return 7;
/*      */     }
/* 2314 */     if (strFieldName.equals("ageType")) {
/* 2315 */       return 8;
/*      */     }
/* 2317 */     if (strFieldName.equals("appntType")) {
/* 2318 */       return 9;
/*      */     }
/* 2320 */     if (strFieldName.equals("iDType")) {
/* 2321 */       return 10;
/*      */     }
/* 2323 */     if (strFieldName.equals("iDNo")) {
/* 2324 */       return 11;
/*      */     }
/* 2326 */     if (strFieldName.equals("iDValidity")) {
/* 2327 */       return 12;
/*      */     }
/* 2329 */     if (strFieldName.equals("iDPerpetual")) {
/* 2330 */       return 13;
/*      */     }
/* 2332 */     if (strFieldName.equals("password")) {
/* 2333 */       return 14;
/*      */     }
/* 2335 */     if (strFieldName.equals("nativePlace")) {
/* 2336 */       return 15;
/*      */     }
/* 2338 */     if (strFieldName.equals("nationality")) {
/* 2339 */       return 16;
/*      */     }
/* 2341 */     if (strFieldName.equals("rgtAddress")) {
/* 2342 */       return 17;
/*      */     }
/* 2344 */     if (strFieldName.equals("marriage")) {
/* 2345 */       return 18;
/*      */     }
/* 2347 */     if (strFieldName.equals("marriageDate")) {
/* 2348 */       return 19;
/*      */     }
/* 2350 */     if (strFieldName.equals("health")) {
/* 2351 */       return 20;
/*      */     }
/* 2353 */     if (strFieldName.equals("stature")) {
/* 2354 */       return 21;
/*      */     }
/* 2356 */     if (strFieldName.equals("avoirdupois")) {
/* 2357 */       return 22;
/*      */     }
/* 2359 */     if (strFieldName.equals("degree")) {
/* 2360 */       return 23;
/*      */     }
/* 2362 */     if (strFieldName.equals("creditGrade")) {
/* 2363 */       return 24;
/*      */     }
/* 2365 */     if (strFieldName.equals("bankCode")) {
/* 2366 */       return 25;
/*      */     }
/* 2368 */     if (strFieldName.equals("bankAccNo")) {
/* 2369 */       return 26;
/*      */     }
/* 2371 */     if (strFieldName.equals("accName")) {
/* 2372 */       return 27;
/*      */     }
/* 2374 */     if (strFieldName.equals("othIDType")) {
/* 2375 */       return 28;
/*      */     }
/* 2377 */     if (strFieldName.equals("othIDNo")) {
/* 2378 */       return 29;
/*      */     }
/* 2380 */     if (strFieldName.equals("iCNo")) {
/* 2381 */       return 30;
/*      */     }
/* 2383 */     if (strFieldName.equals("grpNo")) {
/* 2384 */       return 31;
/*      */     }
/* 2386 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2387 */       return 32;
/*      */     }
/* 2389 */     if (strFieldName.equals("startWorkDate")) {
/* 2390 */       return 33;
/*      */     }
/* 2392 */     if (strFieldName.equals("position")) {
/* 2393 */       return 34;
/*      */     }
/* 2395 */     if (strFieldName.equals("salary")) {
/* 2396 */       return 35;
/*      */     }
/* 2398 */     if (strFieldName.equals("occupationType")) {
/* 2399 */       return 36;
/*      */     }
/* 2401 */     if (strFieldName.equals("occupationCode")) {
/* 2402 */       return 37;
/*      */     }
/* 2404 */     if (strFieldName.equals("partOccupationType")) {
/* 2405 */       return 38;
/*      */     }
/* 2407 */     if (strFieldName.equals("partOccupationCode")) {
/* 2408 */       return 39;
/*      */     }
/* 2410 */     if (strFieldName.equals("workType")) {
/* 2411 */       return 40;
/*      */     }
/* 2413 */     if (strFieldName.equals("pluralityType")) {
/* 2414 */       return 41;
/*      */     }
/* 2416 */     if (strFieldName.equals("deathDate")) {
/* 2417 */       return 42;
/*      */     }
/* 2419 */     if (strFieldName.equals("smokeFlag")) {
/* 2420 */       return 43;
/*      */     }
/* 2422 */     if (strFieldName.equals("blacklistFlag")) {
/* 2423 */       return 44;
/*      */     }
/* 2425 */     if (strFieldName.equals("proterty")) {
/* 2426 */       return 45;
/*      */     }
/* 2428 */     if (strFieldName.equals("remark")) {
/* 2429 */       return 46;
/*      */     }
/* 2431 */     if (strFieldName.equals("state")) {
/* 2432 */       return 47;
/*      */     }
/* 2434 */     if (strFieldName.equals("vIPValue")) {
/* 2435 */       return 48;
/*      */     }
/* 2437 */     if (strFieldName.equals("operator")) {
/* 2438 */       return 49;
/*      */     }
/* 2440 */     if (strFieldName.equals("manageCom")) {
/* 2441 */       return 50;
/*      */     }
/* 2443 */     if (strFieldName.equals("makeDate")) {
/* 2444 */       return 51;
/*      */     }
/* 2446 */     if (strFieldName.equals("makeTime")) {
/* 2447 */       return 52;
/*      */     }
/* 2449 */     if (strFieldName.equals("modifyDate")) {
/* 2450 */       return 53;
/*      */     }
/* 2452 */     if (strFieldName.equals("modifyTime")) {
/* 2453 */       return 54;
/*      */     }
/* 2455 */     if (strFieldName.equals("grpName")) {
/* 2456 */       return 55;
/*      */     }
/* 2458 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2464 */     String strFieldName = "";
/* 2465 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2467 */       strFieldName = "customerId";
/* 2468 */       break;
/*      */     case 1:
/* 2470 */       strFieldName = "agentCode";
/* 2471 */       break;
/*      */     case 2:
/* 2473 */       strFieldName = "customerNo";
/* 2474 */       break;
/*      */     case 3:
/* 2476 */       strFieldName = "appellation";
/* 2477 */       break;
/*      */     case 4:
/* 2479 */       strFieldName = "name";
/* 2480 */       break;
/*      */     case 5:
/* 2482 */       strFieldName = "sex";
/* 2483 */       break;
/*      */     case 6:
/* 2485 */       strFieldName = "birthday";
/* 2486 */       break;
/*      */     case 7:
/* 2488 */       strFieldName = "age";
/* 2489 */       break;
/*      */     case 8:
/* 2491 */       strFieldName = "ageType";
/* 2492 */       break;
/*      */     case 9:
/* 2494 */       strFieldName = "appntType";
/* 2495 */       break;
/*      */     case 10:
/* 2497 */       strFieldName = "iDType";
/* 2498 */       break;
/*      */     case 11:
/* 2500 */       strFieldName = "iDNo";
/* 2501 */       break;
/*      */     case 12:
/* 2503 */       strFieldName = "iDValidity";
/* 2504 */       break;
/*      */     case 13:
/* 2506 */       strFieldName = "iDPerpetual";
/* 2507 */       break;
/*      */     case 14:
/* 2509 */       strFieldName = "password";
/* 2510 */       break;
/*      */     case 15:
/* 2512 */       strFieldName = "nativePlace";
/* 2513 */       break;
/*      */     case 16:
/* 2515 */       strFieldName = "nationality";
/* 2516 */       break;
/*      */     case 17:
/* 2518 */       strFieldName = "rgtAddress";
/* 2519 */       break;
/*      */     case 18:
/* 2521 */       strFieldName = "marriage";
/* 2522 */       break;
/*      */     case 19:
/* 2524 */       strFieldName = "marriageDate";
/* 2525 */       break;
/*      */     case 20:
/* 2527 */       strFieldName = "health";
/* 2528 */       break;
/*      */     case 21:
/* 2530 */       strFieldName = "stature";
/* 2531 */       break;
/*      */     case 22:
/* 2533 */       strFieldName = "avoirdupois";
/* 2534 */       break;
/*      */     case 23:
/* 2536 */       strFieldName = "degree";
/* 2537 */       break;
/*      */     case 24:
/* 2539 */       strFieldName = "creditGrade";
/* 2540 */       break;
/*      */     case 25:
/* 2542 */       strFieldName = "bankCode";
/* 2543 */       break;
/*      */     case 26:
/* 2545 */       strFieldName = "bankAccNo";
/* 2546 */       break;
/*      */     case 27:
/* 2548 */       strFieldName = "accName";
/* 2549 */       break;
/*      */     case 28:
/* 2551 */       strFieldName = "othIDType";
/* 2552 */       break;
/*      */     case 29:
/* 2554 */       strFieldName = "othIDNo";
/* 2555 */       break;
/*      */     case 30:
/* 2557 */       strFieldName = "iCNo";
/* 2558 */       break;
/*      */     case 31:
/* 2560 */       strFieldName = "grpNo";
/* 2561 */       break;
/*      */     case 32:
/* 2563 */       strFieldName = "joinCompanyDate";
/* 2564 */       break;
/*      */     case 33:
/* 2566 */       strFieldName = "startWorkDate";
/* 2567 */       break;
/*      */     case 34:
/* 2569 */       strFieldName = "position";
/* 2570 */       break;
/*      */     case 35:
/* 2572 */       strFieldName = "salary";
/* 2573 */       break;
/*      */     case 36:
/* 2575 */       strFieldName = "occupationType";
/* 2576 */       break;
/*      */     case 37:
/* 2578 */       strFieldName = "occupationCode";
/* 2579 */       break;
/*      */     case 38:
/* 2581 */       strFieldName = "partOccupationType";
/* 2582 */       break;
/*      */     case 39:
/* 2584 */       strFieldName = "partOccupationCode";
/* 2585 */       break;
/*      */     case 40:
/* 2587 */       strFieldName = "workType";
/* 2588 */       break;
/*      */     case 41:
/* 2590 */       strFieldName = "pluralityType";
/* 2591 */       break;
/*      */     case 42:
/* 2593 */       strFieldName = "deathDate";
/* 2594 */       break;
/*      */     case 43:
/* 2596 */       strFieldName = "smokeFlag";
/* 2597 */       break;
/*      */     case 44:
/* 2599 */       strFieldName = "blacklistFlag";
/* 2600 */       break;
/*      */     case 45:
/* 2602 */       strFieldName = "proterty";
/* 2603 */       break;
/*      */     case 46:
/* 2605 */       strFieldName = "remark";
/* 2606 */       break;
/*      */     case 47:
/* 2608 */       strFieldName = "state";
/* 2609 */       break;
/*      */     case 48:
/* 2611 */       strFieldName = "vIPValue";
/* 2612 */       break;
/*      */     case 49:
/* 2614 */       strFieldName = "operator";
/* 2615 */       break;
/*      */     case 50:
/* 2617 */       strFieldName = "manageCom";
/* 2618 */       break;
/*      */     case 51:
/* 2620 */       strFieldName = "makeDate";
/* 2621 */       break;
/*      */     case 52:
/* 2623 */       strFieldName = "makeTime";
/* 2624 */       break;
/*      */     case 53:
/* 2626 */       strFieldName = "modifyDate";
/* 2627 */       break;
/*      */     case 54:
/* 2629 */       strFieldName = "modifyTime";
/* 2630 */       break;
/*      */     case 55:
/* 2632 */       strFieldName = "grpName";
/* 2633 */       break;
/*      */     default:
/* 2635 */       strFieldName = "";
/*      */     }
/* 2637 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2643 */     if (strFieldName.equals("customerId")) {
/* 2644 */       return 0;
/*      */     }
/* 2646 */     if (strFieldName.equals("agentCode")) {
/* 2647 */       return 0;
/*      */     }
/* 2649 */     if (strFieldName.equals("customerNo")) {
/* 2650 */       return 0;
/*      */     }
/* 2652 */     if (strFieldName.equals("appellation")) {
/* 2653 */       return 0;
/*      */     }
/* 2655 */     if (strFieldName.equals("name")) {
/* 2656 */       return 0;
/*      */     }
/* 2658 */     if (strFieldName.equals("sex")) {
/* 2659 */       return 0;
/*      */     }
/* 2661 */     if (strFieldName.equals("birthday")) {
/* 2662 */       return 1;
/*      */     }
/* 2664 */     if (strFieldName.equals("age")) {
/* 2665 */       return 3;
/*      */     }
/* 2667 */     if (strFieldName.equals("ageType")) {
/* 2668 */       return 0;
/*      */     }
/* 2670 */     if (strFieldName.equals("appntType")) {
/* 2671 */       return 0;
/*      */     }
/* 2673 */     if (strFieldName.equals("iDType")) {
/* 2674 */       return 0;
/*      */     }
/* 2676 */     if (strFieldName.equals("iDNo")) {
/* 2677 */       return 0;
/*      */     }
/* 2679 */     if (strFieldName.equals("iDValidity")) {
/* 2680 */       return 1;
/*      */     }
/* 2682 */     if (strFieldName.equals("iDPerpetual")) {
/* 2683 */       return 0;
/*      */     }
/* 2685 */     if (strFieldName.equals("password")) {
/* 2686 */       return 0;
/*      */     }
/* 2688 */     if (strFieldName.equals("nativePlace")) {
/* 2689 */       return 0;
/*      */     }
/* 2691 */     if (strFieldName.equals("nationality")) {
/* 2692 */       return 0;
/*      */     }
/* 2694 */     if (strFieldName.equals("rgtAddress")) {
/* 2695 */       return 0;
/*      */     }
/* 2697 */     if (strFieldName.equals("marriage")) {
/* 2698 */       return 0;
/*      */     }
/* 2700 */     if (strFieldName.equals("marriageDate")) {
/* 2701 */       return 1;
/*      */     }
/* 2703 */     if (strFieldName.equals("health")) {
/* 2704 */       return 0;
/*      */     }
/* 2706 */     if (strFieldName.equals("stature")) {
/* 2707 */       return 4;
/*      */     }
/* 2709 */     if (strFieldName.equals("avoirdupois")) {
/* 2710 */       return 4;
/*      */     }
/* 2712 */     if (strFieldName.equals("degree")) {
/* 2713 */       return 0;
/*      */     }
/* 2715 */     if (strFieldName.equals("creditGrade")) {
/* 2716 */       return 0;
/*      */     }
/* 2718 */     if (strFieldName.equals("bankCode")) {
/* 2719 */       return 0;
/*      */     }
/* 2721 */     if (strFieldName.equals("bankAccNo")) {
/* 2722 */       return 0;
/*      */     }
/* 2724 */     if (strFieldName.equals("accName")) {
/* 2725 */       return 0;
/*      */     }
/* 2727 */     if (strFieldName.equals("othIDType")) {
/* 2728 */       return 0;
/*      */     }
/* 2730 */     if (strFieldName.equals("othIDNo")) {
/* 2731 */       return 0;
/*      */     }
/* 2733 */     if (strFieldName.equals("iCNo")) {
/* 2734 */       return 0;
/*      */     }
/* 2736 */     if (strFieldName.equals("grpNo")) {
/* 2737 */       return 0;
/*      */     }
/* 2739 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2740 */       return 1;
/*      */     }
/* 2742 */     if (strFieldName.equals("startWorkDate")) {
/* 2743 */       return 1;
/*      */     }
/* 2745 */     if (strFieldName.equals("position")) {
/* 2746 */       return 0;
/*      */     }
/* 2748 */     if (strFieldName.equals("salary")) {
/* 2749 */       return 4;
/*      */     }
/* 2751 */     if (strFieldName.equals("occupationType")) {
/* 2752 */       return 0;
/*      */     }
/* 2754 */     if (strFieldName.equals("occupationCode")) {
/* 2755 */       return 0;
/*      */     }
/* 2757 */     if (strFieldName.equals("partOccupationType")) {
/* 2758 */       return 0;
/*      */     }
/* 2760 */     if (strFieldName.equals("partOccupationCode")) {
/* 2761 */       return 0;
/*      */     }
/* 2763 */     if (strFieldName.equals("workType")) {
/* 2764 */       return 0;
/*      */     }
/* 2766 */     if (strFieldName.equals("pluralityType")) {
/* 2767 */       return 0;
/*      */     }
/* 2769 */     if (strFieldName.equals("deathDate")) {
/* 2770 */       return 1;
/*      */     }
/* 2772 */     if (strFieldName.equals("smokeFlag")) {
/* 2773 */       return 0;
/*      */     }
/* 2775 */     if (strFieldName.equals("blacklistFlag")) {
/* 2776 */       return 0;
/*      */     }
/* 2778 */     if (strFieldName.equals("proterty")) {
/* 2779 */       return 0;
/*      */     }
/* 2781 */     if (strFieldName.equals("remark")) {
/* 2782 */       return 0;
/*      */     }
/* 2784 */     if (strFieldName.equals("state")) {
/* 2785 */       return 0;
/*      */     }
/* 2787 */     if (strFieldName.equals("vIPValue")) {
/* 2788 */       return 0;
/*      */     }
/* 2790 */     if (strFieldName.equals("operator")) {
/* 2791 */       return 0;
/*      */     }
/* 2793 */     if (strFieldName.equals("manageCom")) {
/* 2794 */       return 0;
/*      */     }
/* 2796 */     if (strFieldName.equals("makeDate")) {
/* 2797 */       return 1;
/*      */     }
/* 2799 */     if (strFieldName.equals("makeTime")) {
/* 2800 */       return 0;
/*      */     }
/* 2802 */     if (strFieldName.equals("modifyDate")) {
/* 2803 */       return 1;
/*      */     }
/* 2805 */     if (strFieldName.equals("modifyTime")) {
/* 2806 */       return 0;
/*      */     }
/* 2808 */     if (strFieldName.equals("grpName")) {
/* 2809 */       return 0;
/*      */     }
/* 2811 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 2817 */     int nFieldType = -1;
/* 2818 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2820 */       nFieldType = 0;
/* 2821 */       break;
/*      */     case 1:
/* 2823 */       nFieldType = 0;
/* 2824 */       break;
/*      */     case 2:
/* 2826 */       nFieldType = 0;
/* 2827 */       break;
/*      */     case 3:
/* 2829 */       nFieldType = 0;
/* 2830 */       break;
/*      */     case 4:
/* 2832 */       nFieldType = 0;
/* 2833 */       break;
/*      */     case 5:
/* 2835 */       nFieldType = 0;
/* 2836 */       break;
/*      */     case 6:
/* 2838 */       nFieldType = 1;
/* 2839 */       break;
/*      */     case 7:
/* 2841 */       nFieldType = 3;
/* 2842 */       break;
/*      */     case 8:
/* 2844 */       nFieldType = 0;
/* 2845 */       break;
/*      */     case 9:
/* 2847 */       nFieldType = 0;
/* 2848 */       break;
/*      */     case 10:
/* 2850 */       nFieldType = 0;
/* 2851 */       break;
/*      */     case 11:
/* 2853 */       nFieldType = 0;
/* 2854 */       break;
/*      */     case 12:
/* 2856 */       nFieldType = 1;
/* 2857 */       break;
/*      */     case 13:
/* 2859 */       nFieldType = 0;
/* 2860 */       break;
/*      */     case 14:
/* 2862 */       nFieldType = 0;
/* 2863 */       break;
/*      */     case 15:
/* 2865 */       nFieldType = 0;
/* 2866 */       break;
/*      */     case 16:
/* 2868 */       nFieldType = 0;
/* 2869 */       break;
/*      */     case 17:
/* 2871 */       nFieldType = 0;
/* 2872 */       break;
/*      */     case 18:
/* 2874 */       nFieldType = 0;
/* 2875 */       break;
/*      */     case 19:
/* 2877 */       nFieldType = 1;
/* 2878 */       break;
/*      */     case 20:
/* 2880 */       nFieldType = 0;
/* 2881 */       break;
/*      */     case 21:
/* 2883 */       nFieldType = 4;
/* 2884 */       break;
/*      */     case 22:
/* 2886 */       nFieldType = 4;
/* 2887 */       break;
/*      */     case 23:
/* 2889 */       nFieldType = 0;
/* 2890 */       break;
/*      */     case 24:
/* 2892 */       nFieldType = 0;
/* 2893 */       break;
/*      */     case 25:
/* 2895 */       nFieldType = 0;
/* 2896 */       break;
/*      */     case 26:
/* 2898 */       nFieldType = 0;
/* 2899 */       break;
/*      */     case 27:
/* 2901 */       nFieldType = 0;
/* 2902 */       break;
/*      */     case 28:
/* 2904 */       nFieldType = 0;
/* 2905 */       break;
/*      */     case 29:
/* 2907 */       nFieldType = 0;
/* 2908 */       break;
/*      */     case 30:
/* 2910 */       nFieldType = 0;
/* 2911 */       break;
/*      */     case 31:
/* 2913 */       nFieldType = 0;
/* 2914 */       break;
/*      */     case 32:
/* 2916 */       nFieldType = 1;
/* 2917 */       break;
/*      */     case 33:
/* 2919 */       nFieldType = 1;
/* 2920 */       break;
/*      */     case 34:
/* 2922 */       nFieldType = 0;
/* 2923 */       break;
/*      */     case 35:
/* 2925 */       nFieldType = 4;
/* 2926 */       break;
/*      */     case 36:
/* 2928 */       nFieldType = 0;
/* 2929 */       break;
/*      */     case 37:
/* 2931 */       nFieldType = 0;
/* 2932 */       break;
/*      */     case 38:
/* 2934 */       nFieldType = 0;
/* 2935 */       break;
/*      */     case 39:
/* 2937 */       nFieldType = 0;
/* 2938 */       break;
/*      */     case 40:
/* 2940 */       nFieldType = 0;
/* 2941 */       break;
/*      */     case 41:
/* 2943 */       nFieldType = 0;
/* 2944 */       break;
/*      */     case 42:
/* 2946 */       nFieldType = 1;
/* 2947 */       break;
/*      */     case 43:
/* 2949 */       nFieldType = 0;
/* 2950 */       break;
/*      */     case 44:
/* 2952 */       nFieldType = 0;
/* 2953 */       break;
/*      */     case 45:
/* 2955 */       nFieldType = 0;
/* 2956 */       break;
/*      */     case 46:
/* 2958 */       nFieldType = 0;
/* 2959 */       break;
/*      */     case 47:
/* 2961 */       nFieldType = 0;
/* 2962 */       break;
/*      */     case 48:
/* 2964 */       nFieldType = 0;
/* 2965 */       break;
/*      */     case 49:
/* 2967 */       nFieldType = 0;
/* 2968 */       break;
/*      */     case 50:
/* 2970 */       nFieldType = 0;
/* 2971 */       break;
/*      */     case 51:
/* 2973 */       nFieldType = 1;
/* 2974 */       break;
/*      */     case 52:
/* 2976 */       nFieldType = 0;
/* 2977 */       break;
/*      */     case 53:
/* 2979 */       nFieldType = 1;
/* 2980 */       break;
/*      */     case 54:
/* 2982 */       nFieldType = 0;
/* 2983 */       break;
/*      */     case 55:
/* 2985 */       nFieldType = 0;
/* 2986 */       break;
/*      */     default:
/* 2988 */       nFieldType = -1;
/*      */     }
/* 2990 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPPersonSchema
 * JD-Core Version:    0.6.0
 */