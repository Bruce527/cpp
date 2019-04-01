/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MNewClientDB;
/*      */ import com.sinosoft.map.lis.pubfun.FDate;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.ChgData;
/*      */ import com.sinosoft.map.utility.Schema;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class MNewClientSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String customerNo;
/*      */   private String customerNo2;
/*      */   private String clientName;
/*      */   private String gender;
/*      */   private Date birthday;
/*      */   private String eMail;
/*      */   private String grpZipCode;
/*      */   private String grpAddress;
/*      */   private String grpNo;
/*      */   private String bP;
/*      */   private String grpAddressCode;
/*      */   private String phone2;
/*      */   private String grpName;
/*      */   private String grpPhone;
/*      */   private String phone;
/*      */   private String mobile;
/*      */   private String occupationCode;
/*      */   private String position;
/*      */   private String workType;
/*      */   private String occupationType;
/*      */   private String homeAddress;
/*      */   private String homeAddressCode;
/*      */   private String rgtAddress;
/*      */   private String postalAddress;
/*      */   private String zipCode;
/*      */   private String homeZipCode;
/*      */   private String sequenceNo;
/*      */   private double stature;
/*      */   private double avoirdupois;
/*      */   private String smokeFlag;
/*      */   private Date deathDate;
/*      */   private String marriage;
/*      */   private String credentType;
/*      */   private String credentNO;
/*      */   private String othIDNo;
/*      */   private String othIDType;
/*      */   private String iCNo;
/*      */   private double salary;
/*      */   private double yearSalary;
/*      */   private String nativePlace;
/*      */   private String nationality;
/*      */   private Date marriageDate;
/*      */   private String degree;
/*      */   private String polNo;
/*      */   private String relationToInsured;
/*      */   private String pluralityType;
/*      */   private Date startWorkDate;
/*      */   private String health;
/*      */   private String password;
/*      */   private Date joinCompanyDate;
/*      */   private String appntGrade;
/*      */   private String creditGrade;
/*      */   private String clientType;
/*      */   private String state;
/*      */   private String agentcode;
/*      */   private Date signDate;
/*      */   private String addrChoise;
/*      */   private String customeProperty;
/*      */   private String birthdayFlag;
/*      */   private String appellation;
/*      */   private String iDDNo;
/*      */   private Date validityDate;
/*      */   private String countryOrArea;
/*      */   private Date specialDate;
/*      */   private String deleteFlag;
/*      */   private String interest;
/*      */   private String customeType;
/*      */   private String introducer;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 73;
/*      */   private static String[] PK;
/*  170 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MNewClientSchema()
/*      */   {
/*  177 */     this.mErrors = new CErrors();
/*      */ 
/*  179 */     String[] pk = new String[1];
/*  180 */     pk[0] = "CustomerNo";
/*      */ 
/*  182 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  189 */     MNewClientSchema cloned = (MNewClientSchema)super.clone();
/*  190 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  191 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  192 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  198 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getCustomerNo()
/*      */   {
/*  203 */     return this.customerNo;
/*      */   }
/*      */ 
/*      */   public void setCustomerNo(String aCustomerNo) {
/*  207 */     this.customerNo = aCustomerNo;
/*      */   }
/*      */ 
/*      */   public String getCustomerNo2() {
/*  211 */     return this.customerNo2;
/*      */   }
/*      */ 
/*      */   public void setCustomerNo2(String aCustomerNo2) {
/*  215 */     this.customerNo2 = aCustomerNo2;
/*      */   }
/*      */ 
/*      */   public String getClientName() {
/*  219 */     return this.clientName;
/*      */   }
/*      */ 
/*      */   public void setClientName(String aClientName) {
/*  223 */     this.clientName = aClientName;
/*      */   }
/*      */ 
/*      */   public String getGender() {
/*  227 */     return this.gender;
/*      */   }
/*      */ 
/*      */   public void setGender(String aGender) {
/*  231 */     this.gender = aGender;
/*      */   }
/*      */ 
/*      */   public String getBirthday() {
/*  235 */     if (this.birthday != null) {
/*  236 */       return this.fDate.getString(this.birthday);
/*      */     }
/*  238 */     return null;
/*      */   }
/*      */ 
/*      */   public void setBirthday(Date aBirthday) {
/*  242 */     this.birthday = aBirthday;
/*      */   }
/*      */ 
/*      */   public void setBirthday(String aBirthday) {
/*  246 */     if ((aBirthday != null) && (!aBirthday.equals("")))
/*      */     {
/*  248 */       this.birthday = this.fDate.getDate(aBirthday);
/*      */     }
/*      */     else
/*  251 */       this.birthday = null;
/*      */   }
/*      */ 
/*      */   public String getEMail()
/*      */   {
/*  256 */     return this.eMail;
/*      */   }
/*      */ 
/*      */   public void setEMail(String aEMail) {
/*  260 */     this.eMail = aEMail;
/*      */   }
/*      */ 
/*      */   public String getGrpZipCode() {
/*  264 */     return this.grpZipCode;
/*      */   }
/*      */ 
/*      */   public void setGrpZipCode(String aGrpZipCode) {
/*  268 */     this.grpZipCode = aGrpZipCode;
/*      */   }
/*      */ 
/*      */   public String getGrpAddress() {
/*  272 */     return this.grpAddress;
/*      */   }
/*      */ 
/*      */   public void setGrpAddress(String aGrpAddress) {
/*  276 */     this.grpAddress = aGrpAddress;
/*      */   }
/*      */ 
/*      */   public String getGrpNo() {
/*  280 */     return this.grpNo;
/*      */   }
/*      */ 
/*      */   public void setGrpNo(String aGrpNo) {
/*  284 */     this.grpNo = aGrpNo;
/*      */   }
/*      */ 
/*      */   public String getBP() {
/*  288 */     return this.bP;
/*      */   }
/*      */ 
/*      */   public void setBP(String aBP) {
/*  292 */     this.bP = aBP;
/*      */   }
/*      */ 
/*      */   public String getGrpAddressCode() {
/*  296 */     return this.grpAddressCode;
/*      */   }
/*      */ 
/*      */   public void setGrpAddressCode(String aGrpAddressCode) {
/*  300 */     this.grpAddressCode = aGrpAddressCode;
/*      */   }
/*      */ 
/*      */   public String getPhone2() {
/*  304 */     return this.phone2;
/*      */   }
/*      */ 
/*      */   public void setPhone2(String aPhone2) {
/*  308 */     this.phone2 = aPhone2;
/*      */   }
/*      */ 
/*      */   public String getGrpName() {
/*  312 */     return this.grpName;
/*      */   }
/*      */ 
/*      */   public void setGrpName(String aGrpName) {
/*  316 */     this.grpName = aGrpName;
/*      */   }
/*      */ 
/*      */   public String getGrpPhone() {
/*  320 */     return this.grpPhone;
/*      */   }
/*      */ 
/*      */   public void setGrpPhone(String aGrpPhone) {
/*  324 */     this.grpPhone = aGrpPhone;
/*      */   }
/*      */ 
/*      */   public String getPhone() {
/*  328 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setPhone(String aPhone) {
/*  332 */     this.phone = aPhone;
/*      */   }
/*      */ 
/*      */   public String getMobile() {
/*  336 */     return this.mobile;
/*      */   }
/*      */ 
/*      */   public void setMobile(String aMobile) {
/*  340 */     this.mobile = aMobile;
/*      */   }
/*      */ 
/*      */   public String getOccupationCode() {
/*  344 */     return this.occupationCode;
/*      */   }
/*      */ 
/*      */   public void setOccupationCode(String aOccupationCode) {
/*  348 */     this.occupationCode = aOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getPosition() {
/*  352 */     return this.position;
/*      */   }
/*      */ 
/*      */   public void setPosition(String aPosition) {
/*  356 */     this.position = aPosition;
/*      */   }
/*      */ 
/*      */   public String getWorkType() {
/*  360 */     return this.workType;
/*      */   }
/*      */ 
/*      */   public void setWorkType(String aWorkType) {
/*  364 */     this.workType = aWorkType;
/*      */   }
/*      */ 
/*      */   public String getOccupationType() {
/*  368 */     return this.occupationType;
/*      */   }
/*      */ 
/*      */   public void setOccupationType(String aOccupationType) {
/*  372 */     this.occupationType = aOccupationType;
/*      */   }
/*      */ 
/*      */   public String getHomeAddress() {
/*  376 */     return this.homeAddress;
/*      */   }
/*      */ 
/*      */   public void setHomeAddress(String aHomeAddress) {
/*  380 */     this.homeAddress = aHomeAddress;
/*      */   }
/*      */ 
/*      */   public String getHomeAddressCode() {
/*  384 */     return this.homeAddressCode;
/*      */   }
/*      */ 
/*      */   public void setHomeAddressCode(String aHomeAddressCode) {
/*  388 */     this.homeAddressCode = aHomeAddressCode;
/*      */   }
/*      */ 
/*      */   public String getRgtAddress() {
/*  392 */     return this.rgtAddress;
/*      */   }
/*      */ 
/*      */   public void setRgtAddress(String aRgtAddress) {
/*  396 */     this.rgtAddress = aRgtAddress;
/*      */   }
/*      */ 
/*      */   public String getPostalAddress() {
/*  400 */     return this.postalAddress;
/*      */   }
/*      */ 
/*      */   public void setPostalAddress(String aPostalAddress) {
/*  404 */     this.postalAddress = aPostalAddress;
/*      */   }
/*      */ 
/*      */   public String getZipCode() {
/*  408 */     return this.zipCode;
/*      */   }
/*      */ 
/*      */   public void setZipCode(String aZipCode) {
/*  412 */     this.zipCode = aZipCode;
/*      */   }
/*      */ 
/*      */   public String getHomeZipCode() {
/*  416 */     return this.homeZipCode;
/*      */   }
/*      */ 
/*      */   public void setHomeZipCode(String aHomeZipCode) {
/*  420 */     this.homeZipCode = aHomeZipCode;
/*      */   }
/*      */ 
/*      */   public String getSequenceNo() {
/*  424 */     return this.sequenceNo;
/*      */   }
/*      */ 
/*      */   public void setSequenceNo(String aSequenceNo) {
/*  428 */     this.sequenceNo = aSequenceNo;
/*      */   }
/*      */ 
/*      */   public double getStature() {
/*  432 */     return this.stature;
/*      */   }
/*      */ 
/*      */   public void setStature(double aStature) {
/*  436 */     this.stature = aStature;
/*      */   }
/*      */ 
/*      */   public void setStature(String aStature) {
/*  440 */     if ((aStature != null) && (!aStature.equals("")))
/*      */     {
/*  442 */       Double tDouble = new Double(aStature);
/*  443 */       double d = tDouble.doubleValue();
/*  444 */       this.stature = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAvoirdupois()
/*      */   {
/*  450 */     return this.avoirdupois;
/*      */   }
/*      */ 
/*      */   public void setAvoirdupois(double aAvoirdupois) {
/*  454 */     this.avoirdupois = aAvoirdupois;
/*      */   }
/*      */ 
/*      */   public void setAvoirdupois(String aAvoirdupois) {
/*  458 */     if ((aAvoirdupois != null) && (!aAvoirdupois.equals("")))
/*      */     {
/*  460 */       Double tDouble = new Double(aAvoirdupois);
/*  461 */       double d = tDouble.doubleValue();
/*  462 */       this.avoirdupois = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getSmokeFlag()
/*      */   {
/*  468 */     return this.smokeFlag;
/*      */   }
/*      */ 
/*      */   public void setSmokeFlag(String aSmokeFlag) {
/*  472 */     this.smokeFlag = aSmokeFlag;
/*      */   }
/*      */ 
/*      */   public String getDeathDate() {
/*  476 */     if (this.deathDate != null) {
/*  477 */       return this.fDate.getString(this.deathDate);
/*      */     }
/*  479 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDeathDate(Date aDeathDate) {
/*  483 */     this.deathDate = aDeathDate;
/*      */   }
/*      */ 
/*      */   public void setDeathDate(String aDeathDate) {
/*  487 */     if ((aDeathDate != null) && (!aDeathDate.equals("")))
/*      */     {
/*  489 */       this.deathDate = this.fDate.getDate(aDeathDate);
/*      */     }
/*      */     else
/*  492 */       this.deathDate = null;
/*      */   }
/*      */ 
/*      */   public String getMarriage()
/*      */   {
/*  497 */     return this.marriage;
/*      */   }
/*      */ 
/*      */   public void setMarriage(String aMarriage) {
/*  501 */     this.marriage = aMarriage;
/*      */   }
/*      */ 
/*      */   public String getCredentType() {
/*  505 */     return this.credentType;
/*      */   }
/*      */ 
/*      */   public void setCredentType(String aCredentType) {
/*  509 */     this.credentType = aCredentType;
/*      */   }
/*      */ 
/*      */   public String getCredentNO() {
/*  513 */     return this.credentNO;
/*      */   }
/*      */ 
/*      */   public void setCredentNO(String aCredentNO) {
/*  517 */     this.credentNO = aCredentNO;
/*      */   }
/*      */ 
/*      */   public String getOthIDNo() {
/*  521 */     return this.othIDNo;
/*      */   }
/*      */ 
/*      */   public void setOthIDNo(String aOthIDNo) {
/*  525 */     this.othIDNo = aOthIDNo;
/*      */   }
/*      */ 
/*      */   public String getOthIDType() {
/*  529 */     return this.othIDType;
/*      */   }
/*      */ 
/*      */   public void setOthIDType(String aOthIDType) {
/*  533 */     this.othIDType = aOthIDType;
/*      */   }
/*      */ 
/*      */   public String getICNo() {
/*  537 */     return this.iCNo;
/*      */   }
/*      */ 
/*      */   public void setICNo(String aICNo) {
/*  541 */     this.iCNo = aICNo;
/*      */   }
/*      */ 
/*      */   public double getSalary() {
/*  545 */     return this.salary;
/*      */   }
/*      */ 
/*      */   public void setSalary(double aSalary) {
/*  549 */     this.salary = aSalary;
/*      */   }
/*      */ 
/*      */   public void setSalary(String aSalary) {
/*  553 */     if ((aSalary != null) && (!aSalary.equals("")))
/*      */     {
/*  555 */       Double tDouble = new Double(aSalary);
/*  556 */       double d = tDouble.doubleValue();
/*  557 */       this.salary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getYearSalary()
/*      */   {
/*  563 */     return this.yearSalary;
/*      */   }
/*      */ 
/*      */   public void setYearSalary(double aYearSalary) {
/*  567 */     this.yearSalary = aYearSalary;
/*      */   }
/*      */ 
/*      */   public void setYearSalary(String aYearSalary) {
/*  571 */     if ((aYearSalary != null) && (!aYearSalary.equals("")))
/*      */     {
/*  573 */       Double tDouble = new Double(aYearSalary);
/*  574 */       double d = tDouble.doubleValue();
/*  575 */       this.yearSalary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getNativePlace()
/*      */   {
/*  581 */     return this.nativePlace;
/*      */   }
/*      */ 
/*      */   public void setNativePlace(String aNativePlace) {
/*  585 */     this.nativePlace = aNativePlace;
/*      */   }
/*      */ 
/*      */   public String getNationality() {
/*  589 */     return this.nationality;
/*      */   }
/*      */ 
/*      */   public void setNationality(String aNationality) {
/*  593 */     this.nationality = aNationality;
/*      */   }
/*      */ 
/*      */   public String getMarriageDate() {
/*  597 */     if (this.marriageDate != null) {
/*  598 */       return this.fDate.getString(this.marriageDate);
/*      */     }
/*  600 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMarriageDate(Date aMarriageDate) {
/*  604 */     this.marriageDate = aMarriageDate;
/*      */   }
/*      */ 
/*      */   public void setMarriageDate(String aMarriageDate) {
/*  608 */     if ((aMarriageDate != null) && (!aMarriageDate.equals("")))
/*      */     {
/*  610 */       this.marriageDate = this.fDate.getDate(aMarriageDate);
/*      */     }
/*      */     else
/*  613 */       this.marriageDate = null;
/*      */   }
/*      */ 
/*      */   public String getDegree()
/*      */   {
/*  618 */     return this.degree;
/*      */   }
/*      */ 
/*      */   public void setDegree(String aDegree) {
/*  622 */     this.degree = aDegree;
/*      */   }
/*      */ 
/*      */   public String getPolNo() {
/*  626 */     return this.polNo;
/*      */   }
/*      */ 
/*      */   public void setPolNo(String aPolNo) {
/*  630 */     this.polNo = aPolNo;
/*      */   }
/*      */ 
/*      */   public String getRelationToInsured() {
/*  634 */     return this.relationToInsured;
/*      */   }
/*      */ 
/*      */   public void setRelationToInsured(String aRelationToInsured) {
/*  638 */     this.relationToInsured = aRelationToInsured;
/*      */   }
/*      */ 
/*      */   public String getPluralityType() {
/*  642 */     return this.pluralityType;
/*      */   }
/*      */ 
/*      */   public void setPluralityType(String aPluralityType) {
/*  646 */     this.pluralityType = aPluralityType;
/*      */   }
/*      */ 
/*      */   public String getStartWorkDate() {
/*  650 */     if (this.startWorkDate != null) {
/*  651 */       return this.fDate.getString(this.startWorkDate);
/*      */     }
/*  653 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartWorkDate(Date aStartWorkDate) {
/*  657 */     this.startWorkDate = aStartWorkDate;
/*      */   }
/*      */ 
/*      */   public void setStartWorkDate(String aStartWorkDate) {
/*  661 */     if ((aStartWorkDate != null) && (!aStartWorkDate.equals("")))
/*      */     {
/*  663 */       this.startWorkDate = this.fDate.getDate(aStartWorkDate);
/*      */     }
/*      */     else
/*  666 */       this.startWorkDate = null;
/*      */   }
/*      */ 
/*      */   public String getHealth()
/*      */   {
/*  671 */     return this.health;
/*      */   }
/*      */ 
/*      */   public void setHealth(String aHealth) {
/*  675 */     this.health = aHealth;
/*      */   }
/*      */ 
/*      */   public String getPassword() {
/*  679 */     return this.password;
/*      */   }
/*      */ 
/*      */   public void setPassword(String aPassword) {
/*  683 */     this.password = aPassword;
/*      */   }
/*      */ 
/*      */   public String getJoinCompanyDate() {
/*  687 */     if (this.joinCompanyDate != null) {
/*  688 */       return this.fDate.getString(this.joinCompanyDate);
/*      */     }
/*  690 */     return null;
/*      */   }
/*      */ 
/*      */   public void setJoinCompanyDate(Date aJoinCompanyDate) {
/*  694 */     this.joinCompanyDate = aJoinCompanyDate;
/*      */   }
/*      */ 
/*      */   public void setJoinCompanyDate(String aJoinCompanyDate) {
/*  698 */     if ((aJoinCompanyDate != null) && (!aJoinCompanyDate.equals("")))
/*      */     {
/*  700 */       this.joinCompanyDate = this.fDate.getDate(aJoinCompanyDate);
/*      */     }
/*      */     else
/*  703 */       this.joinCompanyDate = null;
/*      */   }
/*      */ 
/*      */   public String getAppntGrade()
/*      */   {
/*  708 */     return this.appntGrade;
/*      */   }
/*      */ 
/*      */   public void setAppntGrade(String aAppntGrade) {
/*  712 */     this.appntGrade = aAppntGrade;
/*      */   }
/*      */ 
/*      */   public String getCreditGrade() {
/*  716 */     return this.creditGrade;
/*      */   }
/*      */ 
/*      */   public void setCreditGrade(String aCreditGrade) {
/*  720 */     this.creditGrade = aCreditGrade;
/*      */   }
/*      */ 
/*      */   public String getClientType() {
/*  724 */     return this.clientType;
/*      */   }
/*      */ 
/*      */   public void setClientType(String aClientType) {
/*  728 */     this.clientType = aClientType;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  732 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  736 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getAgentcode() {
/*  740 */     return this.agentcode;
/*      */   }
/*      */ 
/*      */   public void setAgentcode(String aAgentcode) {
/*  744 */     this.agentcode = aAgentcode;
/*      */   }
/*      */ 
/*      */   public String getSignDate() {
/*  748 */     if (this.signDate != null) {
/*  749 */       return this.fDate.getString(this.signDate);
/*      */     }
/*  751 */     return null;
/*      */   }
/*      */ 
/*      */   public void setSignDate(Date aSignDate) {
/*  755 */     this.signDate = aSignDate;
/*      */   }
/*      */ 
/*      */   public void setSignDate(String aSignDate) {
/*  759 */     if ((aSignDate != null) && (!aSignDate.equals("")))
/*      */     {
/*  761 */       this.signDate = this.fDate.getDate(aSignDate);
/*      */     }
/*      */     else
/*  764 */       this.signDate = null;
/*      */   }
/*      */ 
/*      */   public String getAddrChoise()
/*      */   {
/*  769 */     return this.addrChoise;
/*      */   }
/*      */ 
/*      */   public void setAddrChoise(String aAddrChoise) {
/*  773 */     this.addrChoise = aAddrChoise;
/*      */   }
/*      */ 
/*      */   public String getCustomeProperty() {
/*  777 */     return this.customeProperty;
/*      */   }
/*      */ 
/*      */   public void setCustomeProperty(String aCustomeProperty) {
/*  781 */     this.customeProperty = aCustomeProperty;
/*      */   }
/*      */ 
/*      */   public String getBirthdayFlag() {
/*  785 */     return this.birthdayFlag;
/*      */   }
/*      */ 
/*      */   public void setBirthdayFlag(String aBirthdayFlag) {
/*  789 */     this.birthdayFlag = aBirthdayFlag;
/*      */   }
/*      */ 
/*      */   public String getAppellation() {
/*  793 */     return this.appellation;
/*      */   }
/*      */ 
/*      */   public void setAppellation(String aAppellation) {
/*  797 */     this.appellation = aAppellation;
/*      */   }
/*      */ 
/*      */   public String getIDDNo() {
/*  801 */     return this.iDDNo;
/*      */   }
/*      */ 
/*      */   public void setIDDNo(String aIDDNo) {
/*  805 */     this.iDDNo = aIDDNo;
/*      */   }
/*      */ 
/*      */   public String getValidityDate() {
/*  809 */     if (this.validityDate != null) {
/*  810 */       return this.fDate.getString(this.validityDate);
/*      */     }
/*  812 */     return null;
/*      */   }
/*      */ 
/*      */   public void setValidityDate(Date aValidityDate) {
/*  816 */     this.validityDate = aValidityDate;
/*      */   }
/*      */ 
/*      */   public void setValidityDate(String aValidityDate) {
/*  820 */     if ((aValidityDate != null) && (!aValidityDate.equals("")))
/*      */     {
/*  822 */       this.validityDate = this.fDate.getDate(aValidityDate);
/*      */     }
/*      */     else
/*  825 */       this.validityDate = null;
/*      */   }
/*      */ 
/*      */   public String getCountryOrArea()
/*      */   {
/*  830 */     return this.countryOrArea;
/*      */   }
/*      */ 
/*      */   public void setCountryOrArea(String aCountryOrArea) {
/*  834 */     this.countryOrArea = aCountryOrArea;
/*      */   }
/*      */ 
/*      */   public String getSpecialDate() {
/*  838 */     if (this.specialDate != null) {
/*  839 */       return this.fDate.getString(this.specialDate);
/*      */     }
/*  841 */     return null;
/*      */   }
/*      */ 
/*      */   public void setSpecialDate(Date aSpecialDate) {
/*  845 */     this.specialDate = aSpecialDate;
/*      */   }
/*      */ 
/*      */   public void setSpecialDate(String aSpecialDate) {
/*  849 */     if ((aSpecialDate != null) && (!aSpecialDate.equals("")))
/*      */     {
/*  851 */       this.specialDate = this.fDate.getDate(aSpecialDate);
/*      */     }
/*      */     else
/*  854 */       this.specialDate = null;
/*      */   }
/*      */ 
/*      */   public String getDeleteFlag()
/*      */   {
/*  859 */     return this.deleteFlag;
/*      */   }
/*      */ 
/*      */   public void setDeleteFlag(String aDeleteFlag) {
/*  863 */     this.deleteFlag = aDeleteFlag;
/*      */   }
/*      */ 
/*      */   public String getInterest() {
/*  867 */     return this.interest;
/*      */   }
/*      */ 
/*      */   public void setInterest(String aInterest) {
/*  871 */     this.interest = aInterest;
/*      */   }
/*      */ 
/*      */   public String getCustomeType() {
/*  875 */     return this.customeType;
/*      */   }
/*      */ 
/*      */   public void setCustomeType(String aCustomeType) {
/*  879 */     this.customeType = aCustomeType;
/*      */   }
/*      */ 
/*      */   public String getIntroducer() {
/*  883 */     return this.introducer;
/*      */   }
/*      */ 
/*      */   public void setIntroducer(String aIntroducer) {
/*  887 */     this.introducer = aIntroducer;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  891 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  895 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  899 */     if (this.makeDate != null) {
/*  900 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  902 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  906 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  910 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  912 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  915 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  920 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  924 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  928 */     if (this.modifyDate != null) {
/*  929 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  931 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  935 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  939 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  941 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  944 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  949 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  953 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MNewClientSchema aMNewClientSchema)
/*      */   {
/*  959 */     this.customerNo = aMNewClientSchema.getCustomerNo();
/*  960 */     this.customerNo2 = aMNewClientSchema.getCustomerNo2();
/*  961 */     this.clientName = aMNewClientSchema.getClientName();
/*  962 */     this.gender = aMNewClientSchema.getGender();
/*  963 */     this.birthday = this.fDate.getDate(aMNewClientSchema.getBirthday());
/*  964 */     this.eMail = aMNewClientSchema.getEMail();
/*  965 */     this.grpZipCode = aMNewClientSchema.getGrpZipCode();
/*  966 */     this.grpAddress = aMNewClientSchema.getGrpAddress();
/*  967 */     this.grpNo = aMNewClientSchema.getGrpNo();
/*  968 */     this.bP = aMNewClientSchema.getBP();
/*  969 */     this.grpAddressCode = aMNewClientSchema.getGrpAddressCode();
/*  970 */     this.phone2 = aMNewClientSchema.getPhone2();
/*  971 */     this.grpName = aMNewClientSchema.getGrpName();
/*  972 */     this.grpPhone = aMNewClientSchema.getGrpPhone();
/*  973 */     this.phone = aMNewClientSchema.getPhone();
/*  974 */     this.mobile = aMNewClientSchema.getMobile();
/*  975 */     this.occupationCode = aMNewClientSchema.getOccupationCode();
/*  976 */     this.position = aMNewClientSchema.getPosition();
/*  977 */     this.workType = aMNewClientSchema.getWorkType();
/*  978 */     this.occupationType = aMNewClientSchema.getOccupationType();
/*  979 */     this.homeAddress = aMNewClientSchema.getHomeAddress();
/*  980 */     this.homeAddressCode = aMNewClientSchema.getHomeAddressCode();
/*  981 */     this.rgtAddress = aMNewClientSchema.getRgtAddress();
/*  982 */     this.postalAddress = aMNewClientSchema.getPostalAddress();
/*  983 */     this.zipCode = aMNewClientSchema.getZipCode();
/*  984 */     this.homeZipCode = aMNewClientSchema.getHomeZipCode();
/*  985 */     this.sequenceNo = aMNewClientSchema.getSequenceNo();
/*  986 */     this.stature = aMNewClientSchema.getStature();
/*  987 */     this.avoirdupois = aMNewClientSchema.getAvoirdupois();
/*  988 */     this.smokeFlag = aMNewClientSchema.getSmokeFlag();
/*  989 */     this.deathDate = this.fDate.getDate(aMNewClientSchema.getDeathDate());
/*  990 */     this.marriage = aMNewClientSchema.getMarriage();
/*  991 */     this.credentType = aMNewClientSchema.getCredentType();
/*  992 */     this.credentNO = aMNewClientSchema.getCredentNO();
/*  993 */     this.othIDNo = aMNewClientSchema.getOthIDNo();
/*  994 */     this.othIDType = aMNewClientSchema.getOthIDType();
/*  995 */     this.iCNo = aMNewClientSchema.getICNo();
/*  996 */     this.salary = aMNewClientSchema.getSalary();
/*  997 */     this.yearSalary = aMNewClientSchema.getYearSalary();
/*  998 */     this.nativePlace = aMNewClientSchema.getNativePlace();
/*  999 */     this.nationality = aMNewClientSchema.getNationality();
/* 1000 */     this.marriageDate = this.fDate.getDate(aMNewClientSchema.getMarriageDate());
/* 1001 */     this.degree = aMNewClientSchema.getDegree();
/* 1002 */     this.polNo = aMNewClientSchema.getPolNo();
/* 1003 */     this.relationToInsured = aMNewClientSchema.getRelationToInsured();
/* 1004 */     this.pluralityType = aMNewClientSchema.getPluralityType();
/* 1005 */     this.startWorkDate = this.fDate.getDate(aMNewClientSchema.getStartWorkDate());
/* 1006 */     this.health = aMNewClientSchema.getHealth();
/* 1007 */     this.password = aMNewClientSchema.getPassword();
/* 1008 */     this.joinCompanyDate = this.fDate.getDate(aMNewClientSchema.getJoinCompanyDate());
/* 1009 */     this.appntGrade = aMNewClientSchema.getAppntGrade();
/* 1010 */     this.creditGrade = aMNewClientSchema.getCreditGrade();
/* 1011 */     this.clientType = aMNewClientSchema.getClientType();
/* 1012 */     this.state = aMNewClientSchema.getState();
/* 1013 */     this.agentcode = aMNewClientSchema.getAgentcode();
/* 1014 */     this.signDate = this.fDate.getDate(aMNewClientSchema.getSignDate());
/* 1015 */     this.addrChoise = aMNewClientSchema.getAddrChoise();
/* 1016 */     this.customeProperty = aMNewClientSchema.getCustomeProperty();
/* 1017 */     this.birthdayFlag = aMNewClientSchema.getBirthdayFlag();
/* 1018 */     this.appellation = aMNewClientSchema.getAppellation();
/* 1019 */     this.iDDNo = aMNewClientSchema.getIDDNo();
/* 1020 */     this.validityDate = this.fDate.getDate(aMNewClientSchema.getValidityDate());
/* 1021 */     this.countryOrArea = aMNewClientSchema.getCountryOrArea();
/* 1022 */     this.specialDate = this.fDate.getDate(aMNewClientSchema.getSpecialDate());
/* 1023 */     this.deleteFlag = aMNewClientSchema.getDeleteFlag();
/* 1024 */     this.interest = aMNewClientSchema.getInterest();
/* 1025 */     this.customeType = aMNewClientSchema.getCustomeType();
/* 1026 */     this.introducer = aMNewClientSchema.getIntroducer();
/* 1027 */     this.operator = aMNewClientSchema.getOperator();
/* 1028 */     this.makeDate = this.fDate.getDate(aMNewClientSchema.getMakeDate());
/* 1029 */     this.makeTime = aMNewClientSchema.getMakeTime();
/* 1030 */     this.modifyDate = this.fDate.getDate(aMNewClientSchema.getModifyDate());
/* 1031 */     this.modifyTime = aMNewClientSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/* 1040 */       if (rs.getString("CustomerNo") == null)
/* 1041 */         this.customerNo = null;
/*      */       else {
/* 1043 */         this.customerNo = rs.getString("CustomerNo").trim();
/*      */       }
/* 1045 */       if (rs.getString("CustomerNo2") == null)
/* 1046 */         this.customerNo2 = null;
/*      */       else {
/* 1048 */         this.customerNo2 = rs.getString("CustomerNo2").trim();
/*      */       }
/* 1050 */       if (rs.getString("ClientName") == null)
/* 1051 */         this.clientName = null;
/*      */       else {
/* 1053 */         this.clientName = rs.getString("ClientName").trim();
/*      */       }
/* 1055 */       if (rs.getString("Gender") == null)
/* 1056 */         this.gender = null;
/*      */       else {
/* 1058 */         this.gender = rs.getString("Gender").trim();
/*      */       }
/* 1060 */       this.birthday = rs.getDate("Birthday");
/* 1061 */       if (rs.getString("EMail") == null)
/* 1062 */         this.eMail = null;
/*      */       else {
/* 1064 */         this.eMail = rs.getString("EMail").trim();
/*      */       }
/* 1066 */       if (rs.getString("GrpZipCode") == null)
/* 1067 */         this.grpZipCode = null;
/*      */       else {
/* 1069 */         this.grpZipCode = rs.getString("GrpZipCode").trim();
/*      */       }
/* 1071 */       if (rs.getString("GrpAddress") == null)
/* 1072 */         this.grpAddress = null;
/*      */       else {
/* 1074 */         this.grpAddress = rs.getString("GrpAddress").trim();
/*      */       }
/* 1076 */       if (rs.getString("GrpNo") == null)
/* 1077 */         this.grpNo = null;
/*      */       else {
/* 1079 */         this.grpNo = rs.getString("GrpNo").trim();
/*      */       }
/* 1081 */       if (rs.getString("BP") == null)
/* 1082 */         this.bP = null;
/*      */       else {
/* 1084 */         this.bP = rs.getString("BP").trim();
/*      */       }
/* 1086 */       if (rs.getString("GrpAddressCode") == null)
/* 1087 */         this.grpAddressCode = null;
/*      */       else {
/* 1089 */         this.grpAddressCode = rs.getString("GrpAddressCode").trim();
/*      */       }
/* 1091 */       if (rs.getString("Phone2") == null)
/* 1092 */         this.phone2 = null;
/*      */       else {
/* 1094 */         this.phone2 = rs.getString("Phone2").trim();
/*      */       }
/* 1096 */       if (rs.getString("GrpName") == null)
/* 1097 */         this.grpName = null;
/*      */       else {
/* 1099 */         this.grpName = rs.getString("GrpName").trim();
/*      */       }
/* 1101 */       if (rs.getString("GrpPhone") == null)
/* 1102 */         this.grpPhone = null;
/*      */       else {
/* 1104 */         this.grpPhone = rs.getString("GrpPhone").trim();
/*      */       }
/* 1106 */       if (rs.getString("Phone") == null)
/* 1107 */         this.phone = null;
/*      */       else {
/* 1109 */         this.phone = rs.getString("Phone").trim();
/*      */       }
/* 1111 */       if (rs.getString("Mobile") == null)
/* 1112 */         this.mobile = null;
/*      */       else {
/* 1114 */         this.mobile = rs.getString("Mobile").trim();
/*      */       }
/* 1116 */       if (rs.getString("OccupationCode") == null)
/* 1117 */         this.occupationCode = null;
/*      */       else {
/* 1119 */         this.occupationCode = rs.getString("OccupationCode").trim();
/*      */       }
/* 1121 */       if (rs.getString("Position") == null)
/* 1122 */         this.position = null;
/*      */       else {
/* 1124 */         this.position = rs.getString("Position").trim();
/*      */       }
/* 1126 */       if (rs.getString("WorkType") == null)
/* 1127 */         this.workType = null;
/*      */       else {
/* 1129 */         this.workType = rs.getString("WorkType").trim();
/*      */       }
/* 1131 */       if (rs.getString("OccupationType") == null)
/* 1132 */         this.occupationType = null;
/*      */       else {
/* 1134 */         this.occupationType = rs.getString("OccupationType").trim();
/*      */       }
/* 1136 */       if (rs.getString("HomeAddress") == null)
/* 1137 */         this.homeAddress = null;
/*      */       else {
/* 1139 */         this.homeAddress = rs.getString("HomeAddress").trim();
/*      */       }
/* 1141 */       if (rs.getString("HomeAddressCode") == null)
/* 1142 */         this.homeAddressCode = null;
/*      */       else {
/* 1144 */         this.homeAddressCode = rs.getString("HomeAddressCode").trim();
/*      */       }
/* 1146 */       if (rs.getString("RgtAddress") == null)
/* 1147 */         this.rgtAddress = null;
/*      */       else {
/* 1149 */         this.rgtAddress = rs.getString("RgtAddress").trim();
/*      */       }
/* 1151 */       if (rs.getString("PostalAddress") == null)
/* 1152 */         this.postalAddress = null;
/*      */       else {
/* 1154 */         this.postalAddress = rs.getString("PostalAddress").trim();
/*      */       }
/* 1156 */       if (rs.getString("ZipCode") == null)
/* 1157 */         this.zipCode = null;
/*      */       else {
/* 1159 */         this.zipCode = rs.getString("ZipCode").trim();
/*      */       }
/* 1161 */       if (rs.getString("HomeZipCode") == null)
/* 1162 */         this.homeZipCode = null;
/*      */       else {
/* 1164 */         this.homeZipCode = rs.getString("HomeZipCode").trim();
/*      */       }
/* 1166 */       if (rs.getString("SequenceNo") == null)
/* 1167 */         this.sequenceNo = null;
/*      */       else {
/* 1169 */         this.sequenceNo = rs.getString("SequenceNo").trim();
/*      */       }
/* 1171 */       this.stature = rs.getDouble("Stature");
/* 1172 */       this.avoirdupois = rs.getDouble("Avoirdupois");
/* 1173 */       if (rs.getString("SmokeFlag") == null)
/* 1174 */         this.smokeFlag = null;
/*      */       else {
/* 1176 */         this.smokeFlag = rs.getString("SmokeFlag").trim();
/*      */       }
/* 1178 */       this.deathDate = rs.getDate("DeathDate");
/* 1179 */       if (rs.getString("Marriage") == null)
/* 1180 */         this.marriage = null;
/*      */       else {
/* 1182 */         this.marriage = rs.getString("Marriage").trim();
/*      */       }
/* 1184 */       if (rs.getString("CredentType") == null)
/* 1185 */         this.credentType = null;
/*      */       else {
/* 1187 */         this.credentType = rs.getString("CredentType").trim();
/*      */       }
/* 1189 */       if (rs.getString("CredentNO") == null)
/* 1190 */         this.credentNO = null;
/*      */       else {
/* 1192 */         this.credentNO = rs.getString("CredentNO").trim();
/*      */       }
/* 1194 */       if (rs.getString("OthIDNo") == null)
/* 1195 */         this.othIDNo = null;
/*      */       else {
/* 1197 */         this.othIDNo = rs.getString("OthIDNo").trim();
/*      */       }
/* 1199 */       if (rs.getString("OthIDType") == null)
/* 1200 */         this.othIDType = null;
/*      */       else {
/* 1202 */         this.othIDType = rs.getString("OthIDType").trim();
/*      */       }
/* 1204 */       if (rs.getString("ICNo") == null)
/* 1205 */         this.iCNo = null;
/*      */       else {
/* 1207 */         this.iCNo = rs.getString("ICNo").trim();
/*      */       }
/* 1209 */       this.salary = rs.getDouble("Salary");
/* 1210 */       this.yearSalary = rs.getDouble("YearSalary");
/* 1211 */       if (rs.getString("NativePlace") == null)
/* 1212 */         this.nativePlace = null;
/*      */       else {
/* 1214 */         this.nativePlace = rs.getString("NativePlace").trim();
/*      */       }
/* 1216 */       if (rs.getString("Nationality") == null)
/* 1217 */         this.nationality = null;
/*      */       else {
/* 1219 */         this.nationality = rs.getString("Nationality").trim();
/*      */       }
/* 1221 */       this.marriageDate = rs.getDate("MarriageDate");
/* 1222 */       if (rs.getString("Degree") == null)
/* 1223 */         this.degree = null;
/*      */       else {
/* 1225 */         this.degree = rs.getString("Degree").trim();
/*      */       }
/* 1227 */       if (rs.getString("PolNo") == null)
/* 1228 */         this.polNo = null;
/*      */       else {
/* 1230 */         this.polNo = rs.getString("PolNo").trim();
/*      */       }
/* 1232 */       if (rs.getString("RelationToInsured") == null)
/* 1233 */         this.relationToInsured = null;
/*      */       else {
/* 1235 */         this.relationToInsured = rs.getString("RelationToInsured").trim();
/*      */       }
/* 1237 */       if (rs.getString("PluralityType") == null)
/* 1238 */         this.pluralityType = null;
/*      */       else {
/* 1240 */         this.pluralityType = rs.getString("PluralityType").trim();
/*      */       }
/* 1242 */       this.startWorkDate = rs.getDate("StartWorkDate");
/* 1243 */       if (rs.getString("Health") == null)
/* 1244 */         this.health = null;
/*      */       else {
/* 1246 */         this.health = rs.getString("Health").trim();
/*      */       }
/* 1248 */       if (rs.getString("Password") == null)
/* 1249 */         this.password = null;
/*      */       else {
/* 1251 */         this.password = rs.getString("Password").trim();
/*      */       }
/* 1253 */       this.joinCompanyDate = rs.getDate("JoinCompanyDate");
/* 1254 */       if (rs.getString("AppntGrade") == null)
/* 1255 */         this.appntGrade = null;
/*      */       else {
/* 1257 */         this.appntGrade = rs.getString("AppntGrade").trim();
/*      */       }
/* 1259 */       if (rs.getString("CreditGrade") == null)
/* 1260 */         this.creditGrade = null;
/*      */       else {
/* 1262 */         this.creditGrade = rs.getString("CreditGrade").trim();
/*      */       }
/* 1264 */       if (rs.getString("ClientType") == null)
/* 1265 */         this.clientType = null;
/*      */       else {
/* 1267 */         this.clientType = rs.getString("ClientType").trim();
/*      */       }
/* 1269 */       if (rs.getString("State") == null)
/* 1270 */         this.state = null;
/*      */       else {
/* 1272 */         this.state = rs.getString("State").trim();
/*      */       }
/* 1274 */       if (rs.getString("Agentcode") == null)
/* 1275 */         this.agentcode = null;
/*      */       else {
/* 1277 */         this.agentcode = rs.getString("Agentcode").trim();
/*      */       }
/* 1279 */       this.signDate = rs.getDate("SignDate");
/* 1280 */       if (rs.getString("AddrChoise") == null)
/* 1281 */         this.addrChoise = null;
/*      */       else {
/* 1283 */         this.addrChoise = rs.getString("AddrChoise").trim();
/*      */       }
/* 1285 */       if (rs.getString("CustomeProperty") == null)
/* 1286 */         this.customeProperty = null;
/*      */       else {
/* 1288 */         this.customeProperty = rs.getString("CustomeProperty").trim();
/*      */       }
/* 1290 */       if (rs.getString("BirthdayFlag") == null)
/* 1291 */         this.birthdayFlag = null;
/*      */       else {
/* 1293 */         this.birthdayFlag = rs.getString("BirthdayFlag").trim();
/*      */       }
/* 1295 */       if (rs.getString("Appellation") == null)
/* 1296 */         this.appellation = null;
/*      */       else {
/* 1298 */         this.appellation = rs.getString("Appellation").trim();
/*      */       }
/* 1300 */       if (rs.getString("IDDNo") == null)
/* 1301 */         this.iDDNo = null;
/*      */       else {
/* 1303 */         this.iDDNo = rs.getString("IDDNo").trim();
/*      */       }
/* 1305 */       this.validityDate = rs.getDate("ValidityDate");
/* 1306 */       if (rs.getString("CountryOrArea") == null)
/* 1307 */         this.countryOrArea = null;
/*      */       else {
/* 1309 */         this.countryOrArea = rs.getString("CountryOrArea").trim();
/*      */       }
/* 1311 */       this.specialDate = rs.getDate("SpecialDate");
/* 1312 */       if (rs.getString("DeleteFlag") == null)
/* 1313 */         this.deleteFlag = null;
/*      */       else {
/* 1315 */         this.deleteFlag = rs.getString("DeleteFlag").trim();
/*      */       }
/* 1317 */       if (rs.getString("Interest") == null)
/* 1318 */         this.interest = null;
/*      */       else {
/* 1320 */         this.interest = rs.getString("Interest").trim();
/*      */       }
/* 1322 */       if (rs.getString("CustomeType") == null)
/* 1323 */         this.customeType = null;
/*      */       else {
/* 1325 */         this.customeType = rs.getString("CustomeType").trim();
/*      */       }
/* 1327 */       if (rs.getString("Introducer") == null)
/* 1328 */         this.introducer = null;
/*      */       else {
/* 1330 */         this.introducer = rs.getString("Introducer").trim();
/*      */       }
/* 1332 */       if (rs.getString("Operator") == null)
/* 1333 */         this.operator = null;
/*      */       else {
/* 1335 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/* 1337 */       this.makeDate = rs.getDate("MakeDate");
/* 1338 */       if (rs.getString("MakeTime") == null)
/* 1339 */         this.makeTime = null;
/*      */       else {
/* 1341 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/* 1343 */       this.modifyDate = rs.getDate("ModifyDate");
/* 1344 */       if (rs.getString("ModifyTime") == null)
/* 1345 */         this.modifyTime = null;
/*      */       else {
/* 1347 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1352 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MNewClient\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/* 1354 */       CError tError = new CError();
/* 1355 */       tError.moduleName = "MNewClientSchema";
/* 1356 */       tError.functionName = "setSchema";
/* 1357 */       tError.errorMessage = sqle.toString();
/* 1358 */       this.mErrors.addOneError(tError);
/* 1359 */       return false;
/*      */     }
/* 1361 */     return true;
/*      */   }
/*      */ 
/*      */   public MNewClientSchema getSchema()
/*      */   {
/* 1366 */     MNewClientSchema aMNewClientSchema = new MNewClientSchema();
/* 1367 */     aMNewClientSchema.setSchema(this);
/* 1368 */     return aMNewClientSchema;
/*      */   }
/*      */ 
/*      */   public MNewClientDB getDB()
/*      */   {
/* 1373 */     MNewClientDB aDBOper = new MNewClientDB();
/* 1374 */     aDBOper.setSchema(this);
/* 1375 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1382 */     StringBuffer strReturn = new StringBuffer(256);
/* 1383 */     strReturn.append(StrTool.cTrim(this.customerNo)); strReturn.append("|");
/* 1384 */     strReturn.append(StrTool.cTrim(this.customerNo2)); strReturn.append("|");
/* 1385 */     strReturn.append(StrTool.cTrim(this.clientName)); strReturn.append("|");
/* 1386 */     strReturn.append(StrTool.cTrim(this.gender)); strReturn.append("|");
/* 1387 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.birthday))); strReturn.append("|");
/* 1388 */     strReturn.append(StrTool.cTrim(this.eMail)); strReturn.append("|");
/* 1389 */     strReturn.append(StrTool.cTrim(this.grpZipCode)); strReturn.append("|");
/* 1390 */     strReturn.append(StrTool.cTrim(this.grpAddress)); strReturn.append("|");
/* 1391 */     strReturn.append(StrTool.cTrim(this.grpNo)); strReturn.append("|");
/* 1392 */     strReturn.append(StrTool.cTrim(this.bP)); strReturn.append("|");
/* 1393 */     strReturn.append(StrTool.cTrim(this.grpAddressCode)); strReturn.append("|");
/* 1394 */     strReturn.append(StrTool.cTrim(this.phone2)); strReturn.append("|");
/* 1395 */     strReturn.append(StrTool.cTrim(this.grpName)); strReturn.append("|");
/* 1396 */     strReturn.append(StrTool.cTrim(this.grpPhone)); strReturn.append("|");
/* 1397 */     strReturn.append(StrTool.cTrim(this.phone)); strReturn.append("|");
/* 1398 */     strReturn.append(StrTool.cTrim(this.mobile)); strReturn.append("|");
/* 1399 */     strReturn.append(StrTool.cTrim(this.occupationCode)); strReturn.append("|");
/* 1400 */     strReturn.append(StrTool.cTrim(this.position)); strReturn.append("|");
/* 1401 */     strReturn.append(StrTool.cTrim(this.workType)); strReturn.append("|");
/* 1402 */     strReturn.append(StrTool.cTrim(this.occupationType)); strReturn.append("|");
/* 1403 */     strReturn.append(StrTool.cTrim(this.homeAddress)); strReturn.append("|");
/* 1404 */     strReturn.append(StrTool.cTrim(this.homeAddressCode)); strReturn.append("|");
/* 1405 */     strReturn.append(StrTool.cTrim(this.rgtAddress)); strReturn.append("|");
/* 1406 */     strReturn.append(StrTool.cTrim(this.postalAddress)); strReturn.append("|");
/* 1407 */     strReturn.append(StrTool.cTrim(this.zipCode)); strReturn.append("|");
/* 1408 */     strReturn.append(StrTool.cTrim(this.homeZipCode)); strReturn.append("|");
/* 1409 */     strReturn.append(StrTool.cTrim(this.sequenceNo)); strReturn.append("|");
/* 1410 */     strReturn.append(ChgData.chgData(this.stature)); strReturn.append("|");
/* 1411 */     strReturn.append(ChgData.chgData(this.avoirdupois)); strReturn.append("|");
/* 1412 */     strReturn.append(StrTool.cTrim(this.smokeFlag)); strReturn.append("|");
/* 1413 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.deathDate))); strReturn.append("|");
/* 1414 */     strReturn.append(StrTool.cTrim(this.marriage)); strReturn.append("|");
/* 1415 */     strReturn.append(StrTool.cTrim(this.credentType)); strReturn.append("|");
/* 1416 */     strReturn.append(StrTool.cTrim(this.credentNO)); strReturn.append("|");
/* 1417 */     strReturn.append(StrTool.cTrim(this.othIDNo)); strReturn.append("|");
/* 1418 */     strReturn.append(StrTool.cTrim(this.othIDType)); strReturn.append("|");
/* 1419 */     strReturn.append(StrTool.cTrim(this.iCNo)); strReturn.append("|");
/* 1420 */     strReturn.append(ChgData.chgData(this.salary)); strReturn.append("|");
/* 1421 */     strReturn.append(ChgData.chgData(this.yearSalary)); strReturn.append("|");
/* 1422 */     strReturn.append(StrTool.cTrim(this.nativePlace)); strReturn.append("|");
/* 1423 */     strReturn.append(StrTool.cTrim(this.nationality)); strReturn.append("|");
/* 1424 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.marriageDate))); strReturn.append("|");
/* 1425 */     strReturn.append(StrTool.cTrim(this.degree)); strReturn.append("|");
/* 1426 */     strReturn.append(StrTool.cTrim(this.polNo)); strReturn.append("|");
/* 1427 */     strReturn.append(StrTool.cTrim(this.relationToInsured)); strReturn.append("|");
/* 1428 */     strReturn.append(StrTool.cTrim(this.pluralityType)); strReturn.append("|");
/* 1429 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startWorkDate))); strReturn.append("|");
/* 1430 */     strReturn.append(StrTool.cTrim(this.health)); strReturn.append("|");
/* 1431 */     strReturn.append(StrTool.cTrim(this.password)); strReturn.append("|");
/* 1432 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.joinCompanyDate))); strReturn.append("|");
/* 1433 */     strReturn.append(StrTool.cTrim(this.appntGrade)); strReturn.append("|");
/* 1434 */     strReturn.append(StrTool.cTrim(this.creditGrade)); strReturn.append("|");
/* 1435 */     strReturn.append(StrTool.cTrim(this.clientType)); strReturn.append("|");
/* 1436 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/* 1437 */     strReturn.append(StrTool.cTrim(this.agentcode)); strReturn.append("|");
/* 1438 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.signDate))); strReturn.append("|");
/* 1439 */     strReturn.append(StrTool.cTrim(this.addrChoise)); strReturn.append("|");
/* 1440 */     strReturn.append(StrTool.cTrim(this.customeProperty)); strReturn.append("|");
/* 1441 */     strReturn.append(StrTool.cTrim(this.birthdayFlag)); strReturn.append("|");
/* 1442 */     strReturn.append(StrTool.cTrim(this.appellation)); strReturn.append("|");
/* 1443 */     strReturn.append(StrTool.cTrim(this.iDDNo)); strReturn.append("|");
/* 1444 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.validityDate))); strReturn.append("|");
/* 1445 */     strReturn.append(StrTool.cTrim(this.countryOrArea)); strReturn.append("|");
/* 1446 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.specialDate))); strReturn.append("|");
/* 1447 */     strReturn.append(StrTool.cTrim(this.deleteFlag)); strReturn.append("|");
/* 1448 */     strReturn.append(StrTool.cTrim(this.interest)); strReturn.append("|");
/* 1449 */     strReturn.append(StrTool.cTrim(this.customeType)); strReturn.append("|");
/* 1450 */     strReturn.append(StrTool.cTrim(this.introducer)); strReturn.append("|");
/* 1451 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 1452 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 1453 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 1454 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 1455 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/* 1456 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1464 */       this.customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1465 */       this.customerNo2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1466 */       this.clientName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1467 */       this.gender = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1468 */       this.birthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/* 1469 */       this.eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1470 */       this.grpZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1471 */       this.grpAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1472 */       this.grpNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1473 */       this.bP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1474 */       this.grpAddressCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1475 */       this.phone2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1476 */       this.grpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1477 */       this.grpPhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1478 */       this.phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1479 */       this.mobile = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1480 */       this.occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1481 */       this.position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1482 */       this.workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1483 */       this.occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 1484 */       this.homeAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1485 */       this.homeAddressCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 1486 */       this.rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 1487 */       this.postalAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1488 */       this.zipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1489 */       this.homeZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1490 */       this.sequenceNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1491 */       this.stature = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 28, "|"))).doubleValue();
/* 1492 */       this.avoirdupois = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|"))).doubleValue();
/* 1493 */       this.smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1494 */       this.deathDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|"));
/* 1495 */       this.marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 1496 */       this.credentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 1497 */       this.credentNO = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/* 1498 */       this.othIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 1499 */       this.othIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
/* 1500 */       this.iCNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 1501 */       this.salary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|"))).doubleValue();
/* 1502 */       this.yearSalary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|"))).doubleValue();
/* 1503 */       this.nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1504 */       this.nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1505 */       this.marriageDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|"));
/* 1506 */       this.degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 1507 */       this.polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1508 */       this.relationToInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 1509 */       this.pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 1510 */       this.startWorkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|"));
/* 1511 */       this.health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 1512 */       this.password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/* 1513 */       this.joinCompanyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|"));
/* 1514 */       this.appntGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
/* 1515 */       this.creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
/* 1516 */       this.clientType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
/* 1517 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
/* 1518 */       this.agentcode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
/* 1519 */       this.signDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|"));
/* 1520 */       this.addrChoise = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, "|");
/* 1521 */       this.customeProperty = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 58, "|");
/* 1522 */       this.birthdayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 59, "|");
/* 1523 */       this.appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 60, "|");
/* 1524 */       this.iDDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 61, "|");
/* 1525 */       this.validityDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 62, "|"));
/* 1526 */       this.countryOrArea = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 63, "|");
/* 1527 */       this.specialDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 64, "|"));
/* 1528 */       this.deleteFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 65, "|");
/* 1529 */       this.interest = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 66, "|");
/* 1530 */       this.customeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 67, "|");
/* 1531 */       this.introducer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 68, "|");
/* 1532 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 69, "|");
/* 1533 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 70, "|"));
/* 1534 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 71, "|");
/* 1535 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 72, "|"));
/* 1536 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 73, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1541 */       CError tError = new CError();
/* 1542 */       tError.moduleName = "MNewClientSchema";
/* 1543 */       tError.functionName = "decode";
/* 1544 */       tError.errorMessage = ex.toString();
/* 1545 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1547 */       return false;
/*      */     }
/* 1549 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1555 */     String strReturn = "";
/* 1556 */     if (FCode.equalsIgnoreCase("customerNo"))
/*      */     {
/* 1558 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerNo));
/*      */     }
/* 1560 */     if (FCode.equalsIgnoreCase("customerNo2"))
/*      */     {
/* 1562 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerNo2));
/*      */     }
/* 1564 */     if (FCode.equalsIgnoreCase("clientName"))
/*      */     {
/* 1566 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clientName));
/*      */     }
/* 1568 */     if (FCode.equalsIgnoreCase("gender"))
/*      */     {
/* 1570 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.gender));
/*      */     }
/* 1572 */     if (FCode.equalsIgnoreCase("birthday"))
/*      */     {
/* 1574 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
/*      */     }
/* 1576 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/* 1578 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.eMail));
/*      */     }
/* 1580 */     if (FCode.equalsIgnoreCase("grpZipCode"))
/*      */     {
/* 1582 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpZipCode));
/*      */     }
/* 1584 */     if (FCode.equalsIgnoreCase("grpAddress"))
/*      */     {
/* 1586 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpAddress));
/*      */     }
/* 1588 */     if (FCode.equalsIgnoreCase("grpNo"))
/*      */     {
/* 1590 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpNo));
/*      */     }
/* 1592 */     if (FCode.equalsIgnoreCase("bP"))
/*      */     {
/* 1594 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bP));
/*      */     }
/* 1596 */     if (FCode.equalsIgnoreCase("grpAddressCode"))
/*      */     {
/* 1598 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpAddressCode));
/*      */     }
/* 1600 */     if (FCode.equalsIgnoreCase("phone2"))
/*      */     {
/* 1602 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.phone2));
/*      */     }
/* 1604 */     if (FCode.equalsIgnoreCase("grpName"))
/*      */     {
/* 1606 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpName));
/*      */     }
/* 1608 */     if (FCode.equalsIgnoreCase("grpPhone"))
/*      */     {
/* 1610 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpPhone));
/*      */     }
/* 1612 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/* 1614 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.phone));
/*      */     }
/* 1616 */     if (FCode.equalsIgnoreCase("mobile"))
/*      */     {
/* 1618 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mobile));
/*      */     }
/* 1620 */     if (FCode.equalsIgnoreCase("occupationCode"))
/*      */     {
/* 1622 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationCode));
/*      */     }
/* 1624 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/* 1626 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.position));
/*      */     }
/* 1628 */     if (FCode.equalsIgnoreCase("workType"))
/*      */     {
/* 1630 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.workType));
/*      */     }
/* 1632 */     if (FCode.equalsIgnoreCase("occupationType"))
/*      */     {
/* 1634 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationType));
/*      */     }
/* 1636 */     if (FCode.equalsIgnoreCase("homeAddress"))
/*      */     {
/* 1638 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.homeAddress));
/*      */     }
/* 1640 */     if (FCode.equalsIgnoreCase("homeAddressCode"))
/*      */     {
/* 1642 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.homeAddressCode));
/*      */     }
/* 1644 */     if (FCode.equalsIgnoreCase("rgtAddress"))
/*      */     {
/* 1646 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rgtAddress));
/*      */     }
/* 1648 */     if (FCode.equalsIgnoreCase("postalAddress"))
/*      */     {
/* 1650 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.postalAddress));
/*      */     }
/* 1652 */     if (FCode.equalsIgnoreCase("zipCode"))
/*      */     {
/* 1654 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.zipCode));
/*      */     }
/* 1656 */     if (FCode.equalsIgnoreCase("homeZipCode"))
/*      */     {
/* 1658 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.homeZipCode));
/*      */     }
/* 1660 */     if (FCode.equalsIgnoreCase("sequenceNo"))
/*      */     {
/* 1662 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sequenceNo));
/*      */     }
/* 1664 */     if (FCode.equalsIgnoreCase("stature"))
/*      */     {
/* 1666 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stature));
/*      */     }
/* 1668 */     if (FCode.equalsIgnoreCase("avoirdupois"))
/*      */     {
/* 1670 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.avoirdupois));
/*      */     }
/* 1672 */     if (FCode.equalsIgnoreCase("smokeFlag"))
/*      */     {
/* 1674 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.smokeFlag));
/*      */     }
/* 1676 */     if (FCode.equalsIgnoreCase("deathDate"))
/*      */     {
/* 1678 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDeathDate()));
/*      */     }
/* 1680 */     if (FCode.equalsIgnoreCase("marriage"))
/*      */     {
/* 1682 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.marriage));
/*      */     }
/* 1684 */     if (FCode.equalsIgnoreCase("credentType"))
/*      */     {
/* 1686 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.credentType));
/*      */     }
/* 1688 */     if (FCode.equalsIgnoreCase("credentNO"))
/*      */     {
/* 1690 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.credentNO));
/*      */     }
/* 1692 */     if (FCode.equalsIgnoreCase("othIDNo"))
/*      */     {
/* 1694 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.othIDNo));
/*      */     }
/* 1696 */     if (FCode.equalsIgnoreCase("othIDType"))
/*      */     {
/* 1698 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.othIDType));
/*      */     }
/* 1700 */     if (FCode.equalsIgnoreCase("iCNo"))
/*      */     {
/* 1702 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iCNo));
/*      */     }
/* 1704 */     if (FCode.equalsIgnoreCase("salary"))
/*      */     {
/* 1706 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.salary));
/*      */     }
/* 1708 */     if (FCode.equalsIgnoreCase("yearSalary"))
/*      */     {
/* 1710 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.yearSalary));
/*      */     }
/* 1712 */     if (FCode.equalsIgnoreCase("nativePlace"))
/*      */     {
/* 1714 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nativePlace));
/*      */     }
/* 1716 */     if (FCode.equalsIgnoreCase("nationality"))
/*      */     {
/* 1718 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nationality));
/*      */     }
/* 1720 */     if (FCode.equalsIgnoreCase("marriageDate"))
/*      */     {
/* 1722 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
/*      */     }
/* 1724 */     if (FCode.equalsIgnoreCase("degree"))
/*      */     {
/* 1726 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.degree));
/*      */     }
/* 1728 */     if (FCode.equalsIgnoreCase("polNo"))
/*      */     {
/* 1730 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polNo));
/*      */     }
/* 1732 */     if (FCode.equalsIgnoreCase("relationToInsured"))
/*      */     {
/* 1734 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relationToInsured));
/*      */     }
/* 1736 */     if (FCode.equalsIgnoreCase("pluralityType"))
/*      */     {
/* 1738 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pluralityType));
/*      */     }
/* 1740 */     if (FCode.equalsIgnoreCase("startWorkDate"))
/*      */     {
/* 1742 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
/*      */     }
/* 1744 */     if (FCode.equalsIgnoreCase("health"))
/*      */     {
/* 1746 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.health));
/*      */     }
/* 1748 */     if (FCode.equalsIgnoreCase("password"))
/*      */     {
/* 1750 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.password));
/*      */     }
/* 1752 */     if (FCode.equalsIgnoreCase("joinCompanyDate"))
/*      */     {
/* 1754 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
/*      */     }
/* 1756 */     if (FCode.equalsIgnoreCase("appntGrade"))
/*      */     {
/* 1758 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntGrade));
/*      */     }
/* 1760 */     if (FCode.equalsIgnoreCase("creditGrade"))
/*      */     {
/* 1762 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.creditGrade));
/*      */     }
/* 1764 */     if (FCode.equalsIgnoreCase("clientType"))
/*      */     {
/* 1766 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clientType));
/*      */     }
/* 1768 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1770 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/* 1772 */     if (FCode.equalsIgnoreCase("agentcode"))
/*      */     {
/* 1774 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentcode));
/*      */     }
/* 1776 */     if (FCode.equalsIgnoreCase("signDate"))
/*      */     {
/* 1778 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
/*      */     }
/* 1780 */     if (FCode.equalsIgnoreCase("addrChoise"))
/*      */     {
/* 1782 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addrChoise));
/*      */     }
/* 1784 */     if (FCode.equalsIgnoreCase("customeProperty"))
/*      */     {
/* 1786 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customeProperty));
/*      */     }
/* 1788 */     if (FCode.equalsIgnoreCase("birthdayFlag"))
/*      */     {
/* 1790 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.birthdayFlag));
/*      */     }
/* 1792 */     if (FCode.equalsIgnoreCase("appellation"))
/*      */     {
/* 1794 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appellation));
/*      */     }
/* 1796 */     if (FCode.equalsIgnoreCase("iDDNo"))
/*      */     {
/* 1798 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDDNo));
/*      */     }
/* 1800 */     if (FCode.equalsIgnoreCase("validityDate"))
/*      */     {
/* 1802 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getValidityDate()));
/*      */     }
/* 1804 */     if (FCode.equalsIgnoreCase("countryOrArea"))
/*      */     {
/* 1806 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.countryOrArea));
/*      */     }
/* 1808 */     if (FCode.equalsIgnoreCase("specialDate"))
/*      */     {
/* 1810 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getSpecialDate()));
/*      */     }
/* 1812 */     if (FCode.equalsIgnoreCase("deleteFlag"))
/*      */     {
/* 1814 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.deleteFlag));
/*      */     }
/* 1816 */     if (FCode.equalsIgnoreCase("interest"))
/*      */     {
/* 1818 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.interest));
/*      */     }
/* 1820 */     if (FCode.equalsIgnoreCase("customeType"))
/*      */     {
/* 1822 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customeType));
/*      */     }
/* 1824 */     if (FCode.equalsIgnoreCase("introducer"))
/*      */     {
/* 1826 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.introducer));
/*      */     }
/* 1828 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1830 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1832 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1834 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 1836 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1838 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1840 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1842 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 1844 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1846 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1848 */     if (strReturn.equals(""))
/*      */     {
/* 1850 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1853 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1860 */     String strFieldValue = "";
/* 1861 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1863 */       strFieldValue = StrTool.GBKToUnicode(this.customerNo);
/* 1864 */       break;
/*      */     case 1:
/* 1866 */       strFieldValue = StrTool.GBKToUnicode(this.customerNo2);
/* 1867 */       break;
/*      */     case 2:
/* 1869 */       strFieldValue = StrTool.GBKToUnicode(this.clientName);
/* 1870 */       break;
/*      */     case 3:
/* 1872 */       strFieldValue = StrTool.GBKToUnicode(this.gender);
/* 1873 */       break;
/*      */     case 4:
/* 1875 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
/* 1876 */       break;
/*      */     case 5:
/* 1878 */       strFieldValue = StrTool.GBKToUnicode(this.eMail);
/* 1879 */       break;
/*      */     case 6:
/* 1881 */       strFieldValue = StrTool.GBKToUnicode(this.grpZipCode);
/* 1882 */       break;
/*      */     case 7:
/* 1884 */       strFieldValue = StrTool.GBKToUnicode(this.grpAddress);
/* 1885 */       break;
/*      */     case 8:
/* 1887 */       strFieldValue = StrTool.GBKToUnicode(this.grpNo);
/* 1888 */       break;
/*      */     case 9:
/* 1890 */       strFieldValue = StrTool.GBKToUnicode(this.bP);
/* 1891 */       break;
/*      */     case 10:
/* 1893 */       strFieldValue = StrTool.GBKToUnicode(this.grpAddressCode);
/* 1894 */       break;
/*      */     case 11:
/* 1896 */       strFieldValue = StrTool.GBKToUnicode(this.phone2);
/* 1897 */       break;
/*      */     case 12:
/* 1899 */       strFieldValue = StrTool.GBKToUnicode(this.grpName);
/* 1900 */       break;
/*      */     case 13:
/* 1902 */       strFieldValue = StrTool.GBKToUnicode(this.grpPhone);
/* 1903 */       break;
/*      */     case 14:
/* 1905 */       strFieldValue = StrTool.GBKToUnicode(this.phone);
/* 1906 */       break;
/*      */     case 15:
/* 1908 */       strFieldValue = StrTool.GBKToUnicode(this.mobile);
/* 1909 */       break;
/*      */     case 16:
/* 1911 */       strFieldValue = StrTool.GBKToUnicode(this.occupationCode);
/* 1912 */       break;
/*      */     case 17:
/* 1914 */       strFieldValue = StrTool.GBKToUnicode(this.position);
/* 1915 */       break;
/*      */     case 18:
/* 1917 */       strFieldValue = StrTool.GBKToUnicode(this.workType);
/* 1918 */       break;
/*      */     case 19:
/* 1920 */       strFieldValue = StrTool.GBKToUnicode(this.occupationType);
/* 1921 */       break;
/*      */     case 20:
/* 1923 */       strFieldValue = StrTool.GBKToUnicode(this.homeAddress);
/* 1924 */       break;
/*      */     case 21:
/* 1926 */       strFieldValue = StrTool.GBKToUnicode(this.homeAddressCode);
/* 1927 */       break;
/*      */     case 22:
/* 1929 */       strFieldValue = StrTool.GBKToUnicode(this.rgtAddress);
/* 1930 */       break;
/*      */     case 23:
/* 1932 */       strFieldValue = StrTool.GBKToUnicode(this.postalAddress);
/* 1933 */       break;
/*      */     case 24:
/* 1935 */       strFieldValue = StrTool.GBKToUnicode(this.zipCode);
/* 1936 */       break;
/*      */     case 25:
/* 1938 */       strFieldValue = StrTool.GBKToUnicode(this.homeZipCode);
/* 1939 */       break;
/*      */     case 26:
/* 1941 */       strFieldValue = StrTool.GBKToUnicode(this.sequenceNo);
/* 1942 */       break;
/*      */     case 27:
/* 1944 */       strFieldValue = String.valueOf(this.stature);
/* 1945 */       break;
/*      */     case 28:
/* 1947 */       strFieldValue = String.valueOf(this.avoirdupois);
/* 1948 */       break;
/*      */     case 29:
/* 1950 */       strFieldValue = StrTool.GBKToUnicode(this.smokeFlag);
/* 1951 */       break;
/*      */     case 30:
/* 1953 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDeathDate()));
/* 1954 */       break;
/*      */     case 31:
/* 1956 */       strFieldValue = StrTool.GBKToUnicode(this.marriage);
/* 1957 */       break;
/*      */     case 32:
/* 1959 */       strFieldValue = StrTool.GBKToUnicode(this.credentType);
/* 1960 */       break;
/*      */     case 33:
/* 1962 */       strFieldValue = StrTool.GBKToUnicode(this.credentNO);
/* 1963 */       break;
/*      */     case 34:
/* 1965 */       strFieldValue = StrTool.GBKToUnicode(this.othIDNo);
/* 1966 */       break;
/*      */     case 35:
/* 1968 */       strFieldValue = StrTool.GBKToUnicode(this.othIDType);
/* 1969 */       break;
/*      */     case 36:
/* 1971 */       strFieldValue = StrTool.GBKToUnicode(this.iCNo);
/* 1972 */       break;
/*      */     case 37:
/* 1974 */       strFieldValue = String.valueOf(this.salary);
/* 1975 */       break;
/*      */     case 38:
/* 1977 */       strFieldValue = String.valueOf(this.yearSalary);
/* 1978 */       break;
/*      */     case 39:
/* 1980 */       strFieldValue = StrTool.GBKToUnicode(this.nativePlace);
/* 1981 */       break;
/*      */     case 40:
/* 1983 */       strFieldValue = StrTool.GBKToUnicode(this.nationality);
/* 1984 */       break;
/*      */     case 41:
/* 1986 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
/* 1987 */       break;
/*      */     case 42:
/* 1989 */       strFieldValue = StrTool.GBKToUnicode(this.degree);
/* 1990 */       break;
/*      */     case 43:
/* 1992 */       strFieldValue = StrTool.GBKToUnicode(this.polNo);
/* 1993 */       break;
/*      */     case 44:
/* 1995 */       strFieldValue = StrTool.GBKToUnicode(this.relationToInsured);
/* 1996 */       break;
/*      */     case 45:
/* 1998 */       strFieldValue = StrTool.GBKToUnicode(this.pluralityType);
/* 1999 */       break;
/*      */     case 46:
/* 2001 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
/* 2002 */       break;
/*      */     case 47:
/* 2004 */       strFieldValue = StrTool.GBKToUnicode(this.health);
/* 2005 */       break;
/*      */     case 48:
/* 2007 */       strFieldValue = StrTool.GBKToUnicode(this.password);
/* 2008 */       break;
/*      */     case 49:
/* 2010 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
/* 2011 */       break;
/*      */     case 50:
/* 2013 */       strFieldValue = StrTool.GBKToUnicode(this.appntGrade);
/* 2014 */       break;
/*      */     case 51:
/* 2016 */       strFieldValue = StrTool.GBKToUnicode(this.creditGrade);
/* 2017 */       break;
/*      */     case 52:
/* 2019 */       strFieldValue = StrTool.GBKToUnicode(this.clientType);
/* 2020 */       break;
/*      */     case 53:
/* 2022 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 2023 */       break;
/*      */     case 54:
/* 2025 */       strFieldValue = StrTool.GBKToUnicode(this.agentcode);
/* 2026 */       break;
/*      */     case 55:
/* 2028 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
/* 2029 */       break;
/*      */     case 56:
/* 2031 */       strFieldValue = StrTool.GBKToUnicode(this.addrChoise);
/* 2032 */       break;
/*      */     case 57:
/* 2034 */       strFieldValue = StrTool.GBKToUnicode(this.customeProperty);
/* 2035 */       break;
/*      */     case 58:
/* 2037 */       strFieldValue = StrTool.GBKToUnicode(this.birthdayFlag);
/* 2038 */       break;
/*      */     case 59:
/* 2040 */       strFieldValue = StrTool.GBKToUnicode(this.appellation);
/* 2041 */       break;
/*      */     case 60:
/* 2043 */       strFieldValue = StrTool.GBKToUnicode(this.iDDNo);
/* 2044 */       break;
/*      */     case 61:
/* 2046 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getValidityDate()));
/* 2047 */       break;
/*      */     case 62:
/* 2049 */       strFieldValue = StrTool.GBKToUnicode(this.countryOrArea);
/* 2050 */       break;
/*      */     case 63:
/* 2052 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getSpecialDate()));
/* 2053 */       break;
/*      */     case 64:
/* 2055 */       strFieldValue = StrTool.GBKToUnicode(this.deleteFlag);
/* 2056 */       break;
/*      */     case 65:
/* 2058 */       strFieldValue = StrTool.GBKToUnicode(this.interest);
/* 2059 */       break;
/*      */     case 66:
/* 2061 */       strFieldValue = StrTool.GBKToUnicode(this.customeType);
/* 2062 */       break;
/*      */     case 67:
/* 2064 */       strFieldValue = StrTool.GBKToUnicode(this.introducer);
/* 2065 */       break;
/*      */     case 68:
/* 2067 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 2068 */       break;
/*      */     case 69:
/* 2070 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 2071 */       break;
/*      */     case 70:
/* 2073 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 2074 */       break;
/*      */     case 71:
/* 2076 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 2077 */       break;
/*      */     case 72:
/* 2079 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 2080 */       break;
/*      */     default:
/* 2082 */       strFieldValue = "";
/*      */     }
/* 2084 */     if (strFieldValue.equals("")) {
/* 2085 */       strFieldValue = "null";
/*      */     }
/* 2087 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 2093 */     if (StrTool.cTrim(FCode).equals("")) {
/* 2094 */       return false;
/*      */     }
/* 2096 */     if (FCode.equalsIgnoreCase("customerNo"))
/*      */     {
/* 2098 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2100 */         this.customerNo = FValue.trim();
/*      */       }
/*      */       else
/* 2103 */         this.customerNo = null;
/*      */     }
/* 2105 */     if (FCode.equalsIgnoreCase("customerNo2"))
/*      */     {
/* 2107 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2109 */         this.customerNo2 = FValue.trim();
/*      */       }
/*      */       else
/* 2112 */         this.customerNo2 = null;
/*      */     }
/* 2114 */     if (FCode.equalsIgnoreCase("clientName"))
/*      */     {
/* 2116 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2118 */         this.clientName = FValue.trim();
/*      */       }
/*      */       else
/* 2121 */         this.clientName = null;
/*      */     }
/* 2123 */     if (FCode.equalsIgnoreCase("gender"))
/*      */     {
/* 2125 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2127 */         this.gender = FValue.trim();
/*      */       }
/*      */       else
/* 2130 */         this.gender = null;
/*      */     }
/* 2132 */     if (FCode.equalsIgnoreCase("birthday"))
/*      */     {
/* 2134 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2136 */         this.birthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2139 */         this.birthday = null;
/*      */     }
/* 2141 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/* 2143 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2145 */         this.eMail = FValue.trim();
/*      */       }
/*      */       else
/* 2148 */         this.eMail = null;
/*      */     }
/* 2150 */     if (FCode.equalsIgnoreCase("grpZipCode"))
/*      */     {
/* 2152 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2154 */         this.grpZipCode = FValue.trim();
/*      */       }
/*      */       else
/* 2157 */         this.grpZipCode = null;
/*      */     }
/* 2159 */     if (FCode.equalsIgnoreCase("grpAddress"))
/*      */     {
/* 2161 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2163 */         this.grpAddress = FValue.trim();
/*      */       }
/*      */       else
/* 2166 */         this.grpAddress = null;
/*      */     }
/* 2168 */     if (FCode.equalsIgnoreCase("grpNo"))
/*      */     {
/* 2170 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2172 */         this.grpNo = FValue.trim();
/*      */       }
/*      */       else
/* 2175 */         this.grpNo = null;
/*      */     }
/* 2177 */     if (FCode.equalsIgnoreCase("bP"))
/*      */     {
/* 2179 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2181 */         this.bP = FValue.trim();
/*      */       }
/*      */       else
/* 2184 */         this.bP = null;
/*      */     }
/* 2186 */     if (FCode.equalsIgnoreCase("grpAddressCode"))
/*      */     {
/* 2188 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2190 */         this.grpAddressCode = FValue.trim();
/*      */       }
/*      */       else
/* 2193 */         this.grpAddressCode = null;
/*      */     }
/* 2195 */     if (FCode.equalsIgnoreCase("phone2"))
/*      */     {
/* 2197 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2199 */         this.phone2 = FValue.trim();
/*      */       }
/*      */       else
/* 2202 */         this.phone2 = null;
/*      */     }
/* 2204 */     if (FCode.equalsIgnoreCase("grpName"))
/*      */     {
/* 2206 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2208 */         this.grpName = FValue.trim();
/*      */       }
/*      */       else
/* 2211 */         this.grpName = null;
/*      */     }
/* 2213 */     if (FCode.equalsIgnoreCase("grpPhone"))
/*      */     {
/* 2215 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2217 */         this.grpPhone = FValue.trim();
/*      */       }
/*      */       else
/* 2220 */         this.grpPhone = null;
/*      */     }
/* 2222 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/* 2224 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2226 */         this.phone = FValue.trim();
/*      */       }
/*      */       else
/* 2229 */         this.phone = null;
/*      */     }
/* 2231 */     if (FCode.equalsIgnoreCase("mobile"))
/*      */     {
/* 2233 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2235 */         this.mobile = FValue.trim();
/*      */       }
/*      */       else
/* 2238 */         this.mobile = null;
/*      */     }
/* 2240 */     if (FCode.equalsIgnoreCase("occupationCode"))
/*      */     {
/* 2242 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2244 */         this.occupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 2247 */         this.occupationCode = null;
/*      */     }
/* 2249 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/* 2251 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2253 */         this.position = FValue.trim();
/*      */       }
/*      */       else
/* 2256 */         this.position = null;
/*      */     }
/* 2258 */     if (FCode.equalsIgnoreCase("workType"))
/*      */     {
/* 2260 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2262 */         this.workType = FValue.trim();
/*      */       }
/*      */       else
/* 2265 */         this.workType = null;
/*      */     }
/* 2267 */     if (FCode.equalsIgnoreCase("occupationType"))
/*      */     {
/* 2269 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2271 */         this.occupationType = FValue.trim();
/*      */       }
/*      */       else
/* 2274 */         this.occupationType = null;
/*      */     }
/* 2276 */     if (FCode.equalsIgnoreCase("homeAddress"))
/*      */     {
/* 2278 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2280 */         this.homeAddress = FValue.trim();
/*      */       }
/*      */       else
/* 2283 */         this.homeAddress = null;
/*      */     }
/* 2285 */     if (FCode.equalsIgnoreCase("homeAddressCode"))
/*      */     {
/* 2287 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2289 */         this.homeAddressCode = FValue.trim();
/*      */       }
/*      */       else
/* 2292 */         this.homeAddressCode = null;
/*      */     }
/* 2294 */     if (FCode.equalsIgnoreCase("rgtAddress"))
/*      */     {
/* 2296 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2298 */         this.rgtAddress = FValue.trim();
/*      */       }
/*      */       else
/* 2301 */         this.rgtAddress = null;
/*      */     }
/* 2303 */     if (FCode.equalsIgnoreCase("postalAddress"))
/*      */     {
/* 2305 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2307 */         this.postalAddress = FValue.trim();
/*      */       }
/*      */       else
/* 2310 */         this.postalAddress = null;
/*      */     }
/* 2312 */     if (FCode.equalsIgnoreCase("zipCode"))
/*      */     {
/* 2314 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2316 */         this.zipCode = FValue.trim();
/*      */       }
/*      */       else
/* 2319 */         this.zipCode = null;
/*      */     }
/* 2321 */     if (FCode.equalsIgnoreCase("homeZipCode"))
/*      */     {
/* 2323 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2325 */         this.homeZipCode = FValue.trim();
/*      */       }
/*      */       else
/* 2328 */         this.homeZipCode = null;
/*      */     }
/* 2330 */     if (FCode.equalsIgnoreCase("sequenceNo"))
/*      */     {
/* 2332 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2334 */         this.sequenceNo = FValue.trim();
/*      */       }
/*      */       else
/* 2337 */         this.sequenceNo = null;
/*      */     }
/* 2339 */     if (FCode.equalsIgnoreCase("stature"))
/*      */     {
/* 2341 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2343 */         Double tDouble = new Double(FValue);
/* 2344 */         double d = tDouble.doubleValue();
/* 2345 */         this.stature = d;
/*      */       }
/*      */     }
/* 2348 */     if (FCode.equalsIgnoreCase("avoirdupois"))
/*      */     {
/* 2350 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2352 */         Double tDouble = new Double(FValue);
/* 2353 */         double d = tDouble.doubleValue();
/* 2354 */         this.avoirdupois = d;
/*      */       }
/*      */     }
/* 2357 */     if (FCode.equalsIgnoreCase("smokeFlag"))
/*      */     {
/* 2359 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2361 */         this.smokeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2364 */         this.smokeFlag = null;
/*      */     }
/* 2366 */     if (FCode.equalsIgnoreCase("deathDate"))
/*      */     {
/* 2368 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2370 */         this.deathDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2373 */         this.deathDate = null;
/*      */     }
/* 2375 */     if (FCode.equalsIgnoreCase("marriage"))
/*      */     {
/* 2377 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2379 */         this.marriage = FValue.trim();
/*      */       }
/*      */       else
/* 2382 */         this.marriage = null;
/*      */     }
/* 2384 */     if (FCode.equalsIgnoreCase("credentType"))
/*      */     {
/* 2386 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2388 */         this.credentType = FValue.trim();
/*      */       }
/*      */       else
/* 2391 */         this.credentType = null;
/*      */     }
/* 2393 */     if (FCode.equalsIgnoreCase("credentNO"))
/*      */     {
/* 2395 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2397 */         this.credentNO = FValue.trim();
/*      */       }
/*      */       else
/* 2400 */         this.credentNO = null;
/*      */     }
/* 2402 */     if (FCode.equalsIgnoreCase("othIDNo"))
/*      */     {
/* 2404 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2406 */         this.othIDNo = FValue.trim();
/*      */       }
/*      */       else
/* 2409 */         this.othIDNo = null;
/*      */     }
/* 2411 */     if (FCode.equalsIgnoreCase("othIDType"))
/*      */     {
/* 2413 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2415 */         this.othIDType = FValue.trim();
/*      */       }
/*      */       else
/* 2418 */         this.othIDType = null;
/*      */     }
/* 2420 */     if (FCode.equalsIgnoreCase("iCNo"))
/*      */     {
/* 2422 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2424 */         this.iCNo = FValue.trim();
/*      */       }
/*      */       else
/* 2427 */         this.iCNo = null;
/*      */     }
/* 2429 */     if (FCode.equalsIgnoreCase("salary"))
/*      */     {
/* 2431 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2433 */         Double tDouble = new Double(FValue);
/* 2434 */         double d = tDouble.doubleValue();
/* 2435 */         this.salary = d;
/*      */       }
/*      */     }
/* 2438 */     if (FCode.equalsIgnoreCase("yearSalary"))
/*      */     {
/* 2440 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2442 */         Double tDouble = new Double(FValue);
/* 2443 */         double d = tDouble.doubleValue();
/* 2444 */         this.yearSalary = d;
/*      */       }
/*      */     }
/* 2447 */     if (FCode.equalsIgnoreCase("nativePlace"))
/*      */     {
/* 2449 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2451 */         this.nativePlace = FValue.trim();
/*      */       }
/*      */       else
/* 2454 */         this.nativePlace = null;
/*      */     }
/* 2456 */     if (FCode.equalsIgnoreCase("nationality"))
/*      */     {
/* 2458 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2460 */         this.nationality = FValue.trim();
/*      */       }
/*      */       else
/* 2463 */         this.nationality = null;
/*      */     }
/* 2465 */     if (FCode.equalsIgnoreCase("marriageDate"))
/*      */     {
/* 2467 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2469 */         this.marriageDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2472 */         this.marriageDate = null;
/*      */     }
/* 2474 */     if (FCode.equalsIgnoreCase("degree"))
/*      */     {
/* 2476 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2478 */         this.degree = FValue.trim();
/*      */       }
/*      */       else
/* 2481 */         this.degree = null;
/*      */     }
/* 2483 */     if (FCode.equalsIgnoreCase("polNo"))
/*      */     {
/* 2485 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2487 */         this.polNo = FValue.trim();
/*      */       }
/*      */       else
/* 2490 */         this.polNo = null;
/*      */     }
/* 2492 */     if (FCode.equalsIgnoreCase("relationToInsured"))
/*      */     {
/* 2494 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2496 */         this.relationToInsured = FValue.trim();
/*      */       }
/*      */       else
/* 2499 */         this.relationToInsured = null;
/*      */     }
/* 2501 */     if (FCode.equalsIgnoreCase("pluralityType"))
/*      */     {
/* 2503 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2505 */         this.pluralityType = FValue.trim();
/*      */       }
/*      */       else
/* 2508 */         this.pluralityType = null;
/*      */     }
/* 2510 */     if (FCode.equalsIgnoreCase("startWorkDate"))
/*      */     {
/* 2512 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2514 */         this.startWorkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2517 */         this.startWorkDate = null;
/*      */     }
/* 2519 */     if (FCode.equalsIgnoreCase("health"))
/*      */     {
/* 2521 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2523 */         this.health = FValue.trim();
/*      */       }
/*      */       else
/* 2526 */         this.health = null;
/*      */     }
/* 2528 */     if (FCode.equalsIgnoreCase("password"))
/*      */     {
/* 2530 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2532 */         this.password = FValue.trim();
/*      */       }
/*      */       else
/* 2535 */         this.password = null;
/*      */     }
/* 2537 */     if (FCode.equalsIgnoreCase("joinCompanyDate"))
/*      */     {
/* 2539 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2541 */         this.joinCompanyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2544 */         this.joinCompanyDate = null;
/*      */     }
/* 2546 */     if (FCode.equalsIgnoreCase("appntGrade"))
/*      */     {
/* 2548 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2550 */         this.appntGrade = FValue.trim();
/*      */       }
/*      */       else
/* 2553 */         this.appntGrade = null;
/*      */     }
/* 2555 */     if (FCode.equalsIgnoreCase("creditGrade"))
/*      */     {
/* 2557 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2559 */         this.creditGrade = FValue.trim();
/*      */       }
/*      */       else
/* 2562 */         this.creditGrade = null;
/*      */     }
/* 2564 */     if (FCode.equalsIgnoreCase("clientType"))
/*      */     {
/* 2566 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2568 */         this.clientType = FValue.trim();
/*      */       }
/*      */       else
/* 2571 */         this.clientType = null;
/*      */     }
/* 2573 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 2575 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2577 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 2580 */         this.state = null;
/*      */     }
/* 2582 */     if (FCode.equalsIgnoreCase("agentcode"))
/*      */     {
/* 2584 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2586 */         this.agentcode = FValue.trim();
/*      */       }
/*      */       else
/* 2589 */         this.agentcode = null;
/*      */     }
/* 2591 */     if (FCode.equalsIgnoreCase("signDate"))
/*      */     {
/* 2593 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2595 */         this.signDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2598 */         this.signDate = null;
/*      */     }
/* 2600 */     if (FCode.equalsIgnoreCase("addrChoise"))
/*      */     {
/* 2602 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2604 */         this.addrChoise = FValue.trim();
/*      */       }
/*      */       else
/* 2607 */         this.addrChoise = null;
/*      */     }
/* 2609 */     if (FCode.equalsIgnoreCase("customeProperty"))
/*      */     {
/* 2611 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2613 */         this.customeProperty = FValue.trim();
/*      */       }
/*      */       else
/* 2616 */         this.customeProperty = null;
/*      */     }
/* 2618 */     if (FCode.equalsIgnoreCase("birthdayFlag"))
/*      */     {
/* 2620 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2622 */         this.birthdayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2625 */         this.birthdayFlag = null;
/*      */     }
/* 2627 */     if (FCode.equalsIgnoreCase("appellation"))
/*      */     {
/* 2629 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2631 */         this.appellation = FValue.trim();
/*      */       }
/*      */       else
/* 2634 */         this.appellation = null;
/*      */     }
/* 2636 */     if (FCode.equalsIgnoreCase("iDDNo"))
/*      */     {
/* 2638 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2640 */         this.iDDNo = FValue.trim();
/*      */       }
/*      */       else
/* 2643 */         this.iDDNo = null;
/*      */     }
/* 2645 */     if (FCode.equalsIgnoreCase("validityDate"))
/*      */     {
/* 2647 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2649 */         this.validityDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2652 */         this.validityDate = null;
/*      */     }
/* 2654 */     if (FCode.equalsIgnoreCase("countryOrArea"))
/*      */     {
/* 2656 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2658 */         this.countryOrArea = FValue.trim();
/*      */       }
/*      */       else
/* 2661 */         this.countryOrArea = null;
/*      */     }
/* 2663 */     if (FCode.equalsIgnoreCase("specialDate"))
/*      */     {
/* 2665 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2667 */         this.specialDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2670 */         this.specialDate = null;
/*      */     }
/* 2672 */     if (FCode.equalsIgnoreCase("deleteFlag"))
/*      */     {
/* 2674 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2676 */         this.deleteFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2679 */         this.deleteFlag = null;
/*      */     }
/* 2681 */     if (FCode.equalsIgnoreCase("interest"))
/*      */     {
/* 2683 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2685 */         this.interest = FValue.trim();
/*      */       }
/*      */       else
/* 2688 */         this.interest = null;
/*      */     }
/* 2690 */     if (FCode.equalsIgnoreCase("customeType"))
/*      */     {
/* 2692 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2694 */         this.customeType = FValue.trim();
/*      */       }
/*      */       else
/* 2697 */         this.customeType = null;
/*      */     }
/* 2699 */     if (FCode.equalsIgnoreCase("introducer"))
/*      */     {
/* 2701 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2703 */         this.introducer = FValue.trim();
/*      */       }
/*      */       else
/* 2706 */         this.introducer = null;
/*      */     }
/* 2708 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 2710 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2712 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 2715 */         this.operator = null;
/*      */     }
/* 2717 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 2719 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2721 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2724 */         this.makeDate = null;
/*      */     }
/* 2726 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 2728 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2730 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 2733 */         this.makeTime = null;
/*      */     }
/* 2735 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 2737 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2739 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2742 */         this.modifyDate = null;
/*      */     }
/* 2744 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 2746 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2748 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 2751 */         this.modifyTime = null;
/*      */     }
/* 2753 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 2758 */     if (otherObject == null) return false;
/* 2759 */     if (this == otherObject) return true;
/* 2760 */     if (getClass() != otherObject.getClass()) return false;
/* 2761 */     MNewClientSchema other = (MNewClientSchema)otherObject;
/* 2762 */     if ((this.customerNo == null) && (other.getCustomerNo() != null)) return false;
/* 2763 */     if ((this.customerNo != null) && (!this.customerNo.equals(other.getCustomerNo()))) return false;
/* 2764 */     if ((this.customerNo2 == null) && (other.getCustomerNo2() != null)) return false;
/* 2765 */     if ((this.customerNo2 != null) && (!this.customerNo2.equals(other.getCustomerNo2()))) return false;
/* 2766 */     if ((this.clientName == null) && (other.getClientName() != null)) return false;
/* 2767 */     if ((this.clientName != null) && (!this.clientName.equals(other.getClientName()))) return false;
/* 2768 */     if ((this.gender == null) && (other.getGender() != null)) return false;
/* 2769 */     if ((this.gender != null) && (!this.gender.equals(other.getGender()))) return false;
/* 2770 */     if ((this.birthday == null) && (other.getBirthday() != null)) return false;
/* 2771 */     if ((this.birthday != null) && (!this.fDate.getString(this.birthday).equals(other.getBirthday()))) return false;
/* 2772 */     if ((this.eMail == null) && (other.getEMail() != null)) return false;
/* 2773 */     if ((this.eMail != null) && (!this.eMail.equals(other.getEMail()))) return false;
/* 2774 */     if ((this.grpZipCode == null) && (other.getGrpZipCode() != null)) return false;
/* 2775 */     if ((this.grpZipCode != null) && (!this.grpZipCode.equals(other.getGrpZipCode()))) return false;
/* 2776 */     if ((this.grpAddress == null) && (other.getGrpAddress() != null)) return false;
/* 2777 */     if ((this.grpAddress != null) && (!this.grpAddress.equals(other.getGrpAddress()))) return false;
/* 2778 */     if ((this.grpNo == null) && (other.getGrpNo() != null)) return false;
/* 2779 */     if ((this.grpNo != null) && (!this.grpNo.equals(other.getGrpNo()))) return false;
/* 2780 */     if ((this.bP == null) && (other.getBP() != null)) return false;
/* 2781 */     if ((this.bP != null) && (!this.bP.equals(other.getBP()))) return false;
/* 2782 */     if ((this.grpAddressCode == null) && (other.getGrpAddressCode() != null)) return false;
/* 2783 */     if ((this.grpAddressCode != null) && (!this.grpAddressCode.equals(other.getGrpAddressCode()))) return false;
/* 2784 */     if ((this.phone2 == null) && (other.getPhone2() != null)) return false;
/* 2785 */     if ((this.phone2 != null) && (!this.phone2.equals(other.getPhone2()))) return false;
/* 2786 */     if ((this.grpName == null) && (other.getGrpName() != null)) return false;
/* 2787 */     if ((this.grpName != null) && (!this.grpName.equals(other.getGrpName()))) return false;
/* 2788 */     if ((this.grpPhone == null) && (other.getGrpPhone() != null)) return false;
/* 2789 */     if ((this.grpPhone != null) && (!this.grpPhone.equals(other.getGrpPhone()))) return false;
/* 2790 */     if ((this.phone == null) && (other.getPhone() != null)) return false;
/* 2791 */     if ((this.phone != null) && (!this.phone.equals(other.getPhone()))) return false;
/* 2792 */     if ((this.mobile == null) && (other.getMobile() != null)) return false;
/* 2793 */     if ((this.mobile != null) && (!this.mobile.equals(other.getMobile()))) return false;
/* 2794 */     if ((this.occupationCode == null) && (other.getOccupationCode() != null)) return false;
/* 2795 */     if ((this.occupationCode != null) && (!this.occupationCode.equals(other.getOccupationCode()))) return false;
/* 2796 */     if ((this.position == null) && (other.getPosition() != null)) return false;
/* 2797 */     if ((this.position != null) && (!this.position.equals(other.getPosition()))) return false;
/* 2798 */     if ((this.workType == null) && (other.getWorkType() != null)) return false;
/* 2799 */     if ((this.workType != null) && (!this.workType.equals(other.getWorkType()))) return false;
/* 2800 */     if ((this.occupationType == null) && (other.getOccupationType() != null)) return false;
/* 2801 */     if ((this.occupationType != null) && (!this.occupationType.equals(other.getOccupationType()))) return false;
/* 2802 */     if ((this.homeAddress == null) && (other.getHomeAddress() != null)) return false;
/* 2803 */     if ((this.homeAddress != null) && (!this.homeAddress.equals(other.getHomeAddress()))) return false;
/* 2804 */     if ((this.homeAddressCode == null) && (other.getHomeAddressCode() != null)) return false;
/* 2805 */     if ((this.homeAddressCode != null) && (!this.homeAddressCode.equals(other.getHomeAddressCode()))) return false;
/* 2806 */     if ((this.rgtAddress == null) && (other.getRgtAddress() != null)) return false;
/* 2807 */     if ((this.rgtAddress != null) && (!this.rgtAddress.equals(other.getRgtAddress()))) return false;
/* 2808 */     if ((this.postalAddress == null) && (other.getPostalAddress() != null)) return false;
/* 2809 */     if ((this.postalAddress != null) && (!this.postalAddress.equals(other.getPostalAddress()))) return false;
/* 2810 */     if ((this.zipCode == null) && (other.getZipCode() != null)) return false;
/* 2811 */     if ((this.zipCode != null) && (!this.zipCode.equals(other.getZipCode()))) return false;
/* 2812 */     if ((this.homeZipCode == null) && (other.getHomeZipCode() != null)) return false;
/* 2813 */     if ((this.homeZipCode != null) && (!this.homeZipCode.equals(other.getHomeZipCode()))) return false;
/* 2814 */     if ((this.sequenceNo == null) && (other.getSequenceNo() != null)) return false;
/* 2815 */     if ((this.sequenceNo != null) && (!this.sequenceNo.equals(other.getSequenceNo()))) return false;
/* 2816 */     if (Double.doubleToLongBits(this.stature) != Double.doubleToLongBits(other.getStature())) return false;
/* 2817 */     if (Double.doubleToLongBits(this.avoirdupois) != Double.doubleToLongBits(other.getAvoirdupois())) return false;
/* 2818 */     if ((this.smokeFlag == null) && (other.getSmokeFlag() != null)) return false;
/* 2819 */     if ((this.smokeFlag != null) && (!this.smokeFlag.equals(other.getSmokeFlag()))) return false;
/* 2820 */     if ((this.deathDate == null) && (other.getDeathDate() != null)) return false;
/* 2821 */     if ((this.deathDate != null) && (!this.fDate.getString(this.deathDate).equals(other.getDeathDate()))) return false;
/* 2822 */     if ((this.marriage == null) && (other.getMarriage() != null)) return false;
/* 2823 */     if ((this.marriage != null) && (!this.marriage.equals(other.getMarriage()))) return false;
/* 2824 */     if ((this.credentType == null) && (other.getCredentType() != null)) return false;
/* 2825 */     if ((this.credentType != null) && (!this.credentType.equals(other.getCredentType()))) return false;
/* 2826 */     if ((this.credentNO == null) && (other.getCredentNO() != null)) return false;
/* 2827 */     if ((this.credentNO != null) && (!this.credentNO.equals(other.getCredentNO()))) return false;
/* 2828 */     if ((this.othIDNo == null) && (other.getOthIDNo() != null)) return false;
/* 2829 */     if ((this.othIDNo != null) && (!this.othIDNo.equals(other.getOthIDNo()))) return false;
/* 2830 */     if ((this.othIDType == null) && (other.getOthIDType() != null)) return false;
/* 2831 */     if ((this.othIDType != null) && (!this.othIDType.equals(other.getOthIDType()))) return false;
/* 2832 */     if ((this.iCNo == null) && (other.getICNo() != null)) return false;
/* 2833 */     if ((this.iCNo != null) && (!this.iCNo.equals(other.getICNo()))) return false;
/* 2834 */     if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.getSalary())) return false;
/* 2835 */     if (Double.doubleToLongBits(this.yearSalary) != Double.doubleToLongBits(other.getYearSalary())) return false;
/* 2836 */     if ((this.nativePlace == null) && (other.getNativePlace() != null)) return false;
/* 2837 */     if ((this.nativePlace != null) && (!this.nativePlace.equals(other.getNativePlace()))) return false;
/* 2838 */     if ((this.nationality == null) && (other.getNationality() != null)) return false;
/* 2839 */     if ((this.nationality != null) && (!this.nationality.equals(other.getNationality()))) return false;
/* 2840 */     if ((this.marriageDate == null) && (other.getMarriageDate() != null)) return false;
/* 2841 */     if ((this.marriageDate != null) && (!this.fDate.getString(this.marriageDate).equals(other.getMarriageDate()))) return false;
/* 2842 */     if ((this.degree == null) && (other.getDegree() != null)) return false;
/* 2843 */     if ((this.degree != null) && (!this.degree.equals(other.getDegree()))) return false;
/* 2844 */     if ((this.polNo == null) && (other.getPolNo() != null)) return false;
/* 2845 */     if ((this.polNo != null) && (!this.polNo.equals(other.getPolNo()))) return false;
/* 2846 */     if ((this.relationToInsured == null) && (other.getRelationToInsured() != null)) return false;
/* 2847 */     if ((this.relationToInsured != null) && (!this.relationToInsured.equals(other.getRelationToInsured()))) return false;
/* 2848 */     if ((this.pluralityType == null) && (other.getPluralityType() != null)) return false;
/* 2849 */     if ((this.pluralityType != null) && (!this.pluralityType.equals(other.getPluralityType()))) return false;
/* 2850 */     if ((this.startWorkDate == null) && (other.getStartWorkDate() != null)) return false;
/* 2851 */     if ((this.startWorkDate != null) && (!this.fDate.getString(this.startWorkDate).equals(other.getStartWorkDate()))) return false;
/* 2852 */     if ((this.health == null) && (other.getHealth() != null)) return false;
/* 2853 */     if ((this.health != null) && (!this.health.equals(other.getHealth()))) return false;
/* 2854 */     if ((this.password == null) && (other.getPassword() != null)) return false;
/* 2855 */     if ((this.password != null) && (!this.password.equals(other.getPassword()))) return false;
/* 2856 */     if ((this.joinCompanyDate == null) && (other.getJoinCompanyDate() != null)) return false;
/* 2857 */     if ((this.joinCompanyDate != null) && (!this.fDate.getString(this.joinCompanyDate).equals(other.getJoinCompanyDate()))) return false;
/* 2858 */     if ((this.appntGrade == null) && (other.getAppntGrade() != null)) return false;
/* 2859 */     if ((this.appntGrade != null) && (!this.appntGrade.equals(other.getAppntGrade()))) return false;
/* 2860 */     if ((this.creditGrade == null) && (other.getCreditGrade() != null)) return false;
/* 2861 */     if ((this.creditGrade != null) && (!this.creditGrade.equals(other.getCreditGrade()))) return false;
/* 2862 */     if ((this.clientType == null) && (other.getClientType() != null)) return false;
/* 2863 */     if ((this.clientType != null) && (!this.clientType.equals(other.getClientType()))) return false;
/* 2864 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 2865 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 2866 */     if ((this.agentcode == null) && (other.getAgentcode() != null)) return false;
/* 2867 */     if ((this.agentcode != null) && (!this.agentcode.equals(other.getAgentcode()))) return false;
/* 2868 */     if ((this.signDate == null) && (other.getSignDate() != null)) return false;
/* 2869 */     if ((this.signDate != null) && (!this.fDate.getString(this.signDate).equals(other.getSignDate()))) return false;
/* 2870 */     if ((this.addrChoise == null) && (other.getAddrChoise() != null)) return false;
/* 2871 */     if ((this.addrChoise != null) && (!this.addrChoise.equals(other.getAddrChoise()))) return false;
/* 2872 */     if ((this.customeProperty == null) && (other.getCustomeProperty() != null)) return false;
/* 2873 */     if ((this.customeProperty != null) && (!this.customeProperty.equals(other.getCustomeProperty()))) return false;
/* 2874 */     if ((this.birthdayFlag == null) && (other.getBirthdayFlag() != null)) return false;
/* 2875 */     if ((this.birthdayFlag != null) && (!this.birthdayFlag.equals(other.getBirthdayFlag()))) return false;
/* 2876 */     if ((this.appellation == null) && (other.getAppellation() != null)) return false;
/* 2877 */     if ((this.appellation != null) && (!this.appellation.equals(other.getAppellation()))) return false;
/* 2878 */     if ((this.iDDNo == null) && (other.getIDDNo() != null)) return false;
/* 2879 */     if ((this.iDDNo != null) && (!this.iDDNo.equals(other.getIDDNo()))) return false;
/* 2880 */     if ((this.validityDate == null) && (other.getValidityDate() != null)) return false;
/* 2881 */     if ((this.validityDate != null) && (!this.fDate.getString(this.validityDate).equals(other.getValidityDate()))) return false;
/* 2882 */     if ((this.countryOrArea == null) && (other.getCountryOrArea() != null)) return false;
/* 2883 */     if ((this.countryOrArea != null) && (!this.countryOrArea.equals(other.getCountryOrArea()))) return false;
/* 2884 */     if ((this.specialDate == null) && (other.getSpecialDate() != null)) return false;
/* 2885 */     if ((this.specialDate != null) && (!this.fDate.getString(this.specialDate).equals(other.getSpecialDate()))) return false;
/* 2886 */     if ((this.deleteFlag == null) && (other.getDeleteFlag() != null)) return false;
/* 2887 */     if ((this.deleteFlag != null) && (!this.deleteFlag.equals(other.getDeleteFlag()))) return false;
/* 2888 */     if ((this.interest == null) && (other.getInterest() != null)) return false;
/* 2889 */     if ((this.interest != null) && (!this.interest.equals(other.getInterest()))) return false;
/* 2890 */     if ((this.customeType == null) && (other.getCustomeType() != null)) return false;
/* 2891 */     if ((this.customeType != null) && (!this.customeType.equals(other.getCustomeType()))) return false;
/* 2892 */     if ((this.introducer == null) && (other.getIntroducer() != null)) return false;
/* 2893 */     if ((this.introducer != null) && (!this.introducer.equals(other.getIntroducer()))) return false;
/* 2894 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 2895 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 2896 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 2897 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 2898 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 2899 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 2900 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 2901 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 2902 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 2903 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2910 */     return 73;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2916 */     if (strFieldName.equals("customerNo")) {
/* 2917 */       return 0;
/*      */     }
/* 2919 */     if (strFieldName.equals("customerNo2")) {
/* 2920 */       return 1;
/*      */     }
/* 2922 */     if (strFieldName.equals("clientName")) {
/* 2923 */       return 2;
/*      */     }
/* 2925 */     if (strFieldName.equals("gender")) {
/* 2926 */       return 3;
/*      */     }
/* 2928 */     if (strFieldName.equals("birthday")) {
/* 2929 */       return 4;
/*      */     }
/* 2931 */     if (strFieldName.equals("eMail")) {
/* 2932 */       return 5;
/*      */     }
/* 2934 */     if (strFieldName.equals("grpZipCode")) {
/* 2935 */       return 6;
/*      */     }
/* 2937 */     if (strFieldName.equals("grpAddress")) {
/* 2938 */       return 7;
/*      */     }
/* 2940 */     if (strFieldName.equals("grpNo")) {
/* 2941 */       return 8;
/*      */     }
/* 2943 */     if (strFieldName.equals("bP")) {
/* 2944 */       return 9;
/*      */     }
/* 2946 */     if (strFieldName.equals("grpAddressCode")) {
/* 2947 */       return 10;
/*      */     }
/* 2949 */     if (strFieldName.equals("phone2")) {
/* 2950 */       return 11;
/*      */     }
/* 2952 */     if (strFieldName.equals("grpName")) {
/* 2953 */       return 12;
/*      */     }
/* 2955 */     if (strFieldName.equals("grpPhone")) {
/* 2956 */       return 13;
/*      */     }
/* 2958 */     if (strFieldName.equals("phone")) {
/* 2959 */       return 14;
/*      */     }
/* 2961 */     if (strFieldName.equals("mobile")) {
/* 2962 */       return 15;
/*      */     }
/* 2964 */     if (strFieldName.equals("occupationCode")) {
/* 2965 */       return 16;
/*      */     }
/* 2967 */     if (strFieldName.equals("position")) {
/* 2968 */       return 17;
/*      */     }
/* 2970 */     if (strFieldName.equals("workType")) {
/* 2971 */       return 18;
/*      */     }
/* 2973 */     if (strFieldName.equals("occupationType")) {
/* 2974 */       return 19;
/*      */     }
/* 2976 */     if (strFieldName.equals("homeAddress")) {
/* 2977 */       return 20;
/*      */     }
/* 2979 */     if (strFieldName.equals("homeAddressCode")) {
/* 2980 */       return 21;
/*      */     }
/* 2982 */     if (strFieldName.equals("rgtAddress")) {
/* 2983 */       return 22;
/*      */     }
/* 2985 */     if (strFieldName.equals("postalAddress")) {
/* 2986 */       return 23;
/*      */     }
/* 2988 */     if (strFieldName.equals("zipCode")) {
/* 2989 */       return 24;
/*      */     }
/* 2991 */     if (strFieldName.equals("homeZipCode")) {
/* 2992 */       return 25;
/*      */     }
/* 2994 */     if (strFieldName.equals("sequenceNo")) {
/* 2995 */       return 26;
/*      */     }
/* 2997 */     if (strFieldName.equals("stature")) {
/* 2998 */       return 27;
/*      */     }
/* 3000 */     if (strFieldName.equals("avoirdupois")) {
/* 3001 */       return 28;
/*      */     }
/* 3003 */     if (strFieldName.equals("smokeFlag")) {
/* 3004 */       return 29;
/*      */     }
/* 3006 */     if (strFieldName.equals("deathDate")) {
/* 3007 */       return 30;
/*      */     }
/* 3009 */     if (strFieldName.equals("marriage")) {
/* 3010 */       return 31;
/*      */     }
/* 3012 */     if (strFieldName.equals("credentType")) {
/* 3013 */       return 32;
/*      */     }
/* 3015 */     if (strFieldName.equals("credentNO")) {
/* 3016 */       return 33;
/*      */     }
/* 3018 */     if (strFieldName.equals("othIDNo")) {
/* 3019 */       return 34;
/*      */     }
/* 3021 */     if (strFieldName.equals("othIDType")) {
/* 3022 */       return 35;
/*      */     }
/* 3024 */     if (strFieldName.equals("iCNo")) {
/* 3025 */       return 36;
/*      */     }
/* 3027 */     if (strFieldName.equals("salary")) {
/* 3028 */       return 37;
/*      */     }
/* 3030 */     if (strFieldName.equals("yearSalary")) {
/* 3031 */       return 38;
/*      */     }
/* 3033 */     if (strFieldName.equals("nativePlace")) {
/* 3034 */       return 39;
/*      */     }
/* 3036 */     if (strFieldName.equals("nationality")) {
/* 3037 */       return 40;
/*      */     }
/* 3039 */     if (strFieldName.equals("marriageDate")) {
/* 3040 */       return 41;
/*      */     }
/* 3042 */     if (strFieldName.equals("degree")) {
/* 3043 */       return 42;
/*      */     }
/* 3045 */     if (strFieldName.equals("polNo")) {
/* 3046 */       return 43;
/*      */     }
/* 3048 */     if (strFieldName.equals("relationToInsured")) {
/* 3049 */       return 44;
/*      */     }
/* 3051 */     if (strFieldName.equals("pluralityType")) {
/* 3052 */       return 45;
/*      */     }
/* 3054 */     if (strFieldName.equals("startWorkDate")) {
/* 3055 */       return 46;
/*      */     }
/* 3057 */     if (strFieldName.equals("health")) {
/* 3058 */       return 47;
/*      */     }
/* 3060 */     if (strFieldName.equals("password")) {
/* 3061 */       return 48;
/*      */     }
/* 3063 */     if (strFieldName.equals("joinCompanyDate")) {
/* 3064 */       return 49;
/*      */     }
/* 3066 */     if (strFieldName.equals("appntGrade")) {
/* 3067 */       return 50;
/*      */     }
/* 3069 */     if (strFieldName.equals("creditGrade")) {
/* 3070 */       return 51;
/*      */     }
/* 3072 */     if (strFieldName.equals("clientType")) {
/* 3073 */       return 52;
/*      */     }
/* 3075 */     if (strFieldName.equals("state")) {
/* 3076 */       return 53;
/*      */     }
/* 3078 */     if (strFieldName.equals("agentcode")) {
/* 3079 */       return 54;
/*      */     }
/* 3081 */     if (strFieldName.equals("signDate")) {
/* 3082 */       return 55;
/*      */     }
/* 3084 */     if (strFieldName.equals("addrChoise")) {
/* 3085 */       return 56;
/*      */     }
/* 3087 */     if (strFieldName.equals("customeProperty")) {
/* 3088 */       return 57;
/*      */     }
/* 3090 */     if (strFieldName.equals("birthdayFlag")) {
/* 3091 */       return 58;
/*      */     }
/* 3093 */     if (strFieldName.equals("appellation")) {
/* 3094 */       return 59;
/*      */     }
/* 3096 */     if (strFieldName.equals("iDDNo")) {
/* 3097 */       return 60;
/*      */     }
/* 3099 */     if (strFieldName.equals("validityDate")) {
/* 3100 */       return 61;
/*      */     }
/* 3102 */     if (strFieldName.equals("countryOrArea")) {
/* 3103 */       return 62;
/*      */     }
/* 3105 */     if (strFieldName.equals("specialDate")) {
/* 3106 */       return 63;
/*      */     }
/* 3108 */     if (strFieldName.equals("deleteFlag")) {
/* 3109 */       return 64;
/*      */     }
/* 3111 */     if (strFieldName.equals("interest")) {
/* 3112 */       return 65;
/*      */     }
/* 3114 */     if (strFieldName.equals("customeType")) {
/* 3115 */       return 66;
/*      */     }
/* 3117 */     if (strFieldName.equals("introducer")) {
/* 3118 */       return 67;
/*      */     }
/* 3120 */     if (strFieldName.equals("operator")) {
/* 3121 */       return 68;
/*      */     }
/* 3123 */     if (strFieldName.equals("makeDate")) {
/* 3124 */       return 69;
/*      */     }
/* 3126 */     if (strFieldName.equals("makeTime")) {
/* 3127 */       return 70;
/*      */     }
/* 3129 */     if (strFieldName.equals("modifyDate")) {
/* 3130 */       return 71;
/*      */     }
/* 3132 */     if (strFieldName.equals("modifyTime")) {
/* 3133 */       return 72;
/*      */     }
/* 3135 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 3141 */     String strFieldName = "";
/* 3142 */     switch (nFieldIndex) {
/*      */     case 0:
/* 3144 */       strFieldName = "customerNo";
/* 3145 */       break;
/*      */     case 1:
/* 3147 */       strFieldName = "customerNo2";
/* 3148 */       break;
/*      */     case 2:
/* 3150 */       strFieldName = "clientName";
/* 3151 */       break;
/*      */     case 3:
/* 3153 */       strFieldName = "gender";
/* 3154 */       break;
/*      */     case 4:
/* 3156 */       strFieldName = "birthday";
/* 3157 */       break;
/*      */     case 5:
/* 3159 */       strFieldName = "eMail";
/* 3160 */       break;
/*      */     case 6:
/* 3162 */       strFieldName = "grpZipCode";
/* 3163 */       break;
/*      */     case 7:
/* 3165 */       strFieldName = "grpAddress";
/* 3166 */       break;
/*      */     case 8:
/* 3168 */       strFieldName = "grpNo";
/* 3169 */       break;
/*      */     case 9:
/* 3171 */       strFieldName = "bP";
/* 3172 */       break;
/*      */     case 10:
/* 3174 */       strFieldName = "grpAddressCode";
/* 3175 */       break;
/*      */     case 11:
/* 3177 */       strFieldName = "phone2";
/* 3178 */       break;
/*      */     case 12:
/* 3180 */       strFieldName = "grpName";
/* 3181 */       break;
/*      */     case 13:
/* 3183 */       strFieldName = "grpPhone";
/* 3184 */       break;
/*      */     case 14:
/* 3186 */       strFieldName = "phone";
/* 3187 */       break;
/*      */     case 15:
/* 3189 */       strFieldName = "mobile";
/* 3190 */       break;
/*      */     case 16:
/* 3192 */       strFieldName = "occupationCode";
/* 3193 */       break;
/*      */     case 17:
/* 3195 */       strFieldName = "position";
/* 3196 */       break;
/*      */     case 18:
/* 3198 */       strFieldName = "workType";
/* 3199 */       break;
/*      */     case 19:
/* 3201 */       strFieldName = "occupationType";
/* 3202 */       break;
/*      */     case 20:
/* 3204 */       strFieldName = "homeAddress";
/* 3205 */       break;
/*      */     case 21:
/* 3207 */       strFieldName = "homeAddressCode";
/* 3208 */       break;
/*      */     case 22:
/* 3210 */       strFieldName = "rgtAddress";
/* 3211 */       break;
/*      */     case 23:
/* 3213 */       strFieldName = "postalAddress";
/* 3214 */       break;
/*      */     case 24:
/* 3216 */       strFieldName = "zipCode";
/* 3217 */       break;
/*      */     case 25:
/* 3219 */       strFieldName = "homeZipCode";
/* 3220 */       break;
/*      */     case 26:
/* 3222 */       strFieldName = "sequenceNo";
/* 3223 */       break;
/*      */     case 27:
/* 3225 */       strFieldName = "stature";
/* 3226 */       break;
/*      */     case 28:
/* 3228 */       strFieldName = "avoirdupois";
/* 3229 */       break;
/*      */     case 29:
/* 3231 */       strFieldName = "smokeFlag";
/* 3232 */       break;
/*      */     case 30:
/* 3234 */       strFieldName = "deathDate";
/* 3235 */       break;
/*      */     case 31:
/* 3237 */       strFieldName = "marriage";
/* 3238 */       break;
/*      */     case 32:
/* 3240 */       strFieldName = "credentType";
/* 3241 */       break;
/*      */     case 33:
/* 3243 */       strFieldName = "credentNO";
/* 3244 */       break;
/*      */     case 34:
/* 3246 */       strFieldName = "othIDNo";
/* 3247 */       break;
/*      */     case 35:
/* 3249 */       strFieldName = "othIDType";
/* 3250 */       break;
/*      */     case 36:
/* 3252 */       strFieldName = "iCNo";
/* 3253 */       break;
/*      */     case 37:
/* 3255 */       strFieldName = "salary";
/* 3256 */       break;
/*      */     case 38:
/* 3258 */       strFieldName = "yearSalary";
/* 3259 */       break;
/*      */     case 39:
/* 3261 */       strFieldName = "nativePlace";
/* 3262 */       break;
/*      */     case 40:
/* 3264 */       strFieldName = "nationality";
/* 3265 */       break;
/*      */     case 41:
/* 3267 */       strFieldName = "marriageDate";
/* 3268 */       break;
/*      */     case 42:
/* 3270 */       strFieldName = "degree";
/* 3271 */       break;
/*      */     case 43:
/* 3273 */       strFieldName = "polNo";
/* 3274 */       break;
/*      */     case 44:
/* 3276 */       strFieldName = "relationToInsured";
/* 3277 */       break;
/*      */     case 45:
/* 3279 */       strFieldName = "pluralityType";
/* 3280 */       break;
/*      */     case 46:
/* 3282 */       strFieldName = "startWorkDate";
/* 3283 */       break;
/*      */     case 47:
/* 3285 */       strFieldName = "health";
/* 3286 */       break;
/*      */     case 48:
/* 3288 */       strFieldName = "password";
/* 3289 */       break;
/*      */     case 49:
/* 3291 */       strFieldName = "joinCompanyDate";
/* 3292 */       break;
/*      */     case 50:
/* 3294 */       strFieldName = "appntGrade";
/* 3295 */       break;
/*      */     case 51:
/* 3297 */       strFieldName = "creditGrade";
/* 3298 */       break;
/*      */     case 52:
/* 3300 */       strFieldName = "clientType";
/* 3301 */       break;
/*      */     case 53:
/* 3303 */       strFieldName = "state";
/* 3304 */       break;
/*      */     case 54:
/* 3306 */       strFieldName = "agentcode";
/* 3307 */       break;
/*      */     case 55:
/* 3309 */       strFieldName = "signDate";
/* 3310 */       break;
/*      */     case 56:
/* 3312 */       strFieldName = "addrChoise";
/* 3313 */       break;
/*      */     case 57:
/* 3315 */       strFieldName = "customeProperty";
/* 3316 */       break;
/*      */     case 58:
/* 3318 */       strFieldName = "birthdayFlag";
/* 3319 */       break;
/*      */     case 59:
/* 3321 */       strFieldName = "appellation";
/* 3322 */       break;
/*      */     case 60:
/* 3324 */       strFieldName = "iDDNo";
/* 3325 */       break;
/*      */     case 61:
/* 3327 */       strFieldName = "validityDate";
/* 3328 */       break;
/*      */     case 62:
/* 3330 */       strFieldName = "countryOrArea";
/* 3331 */       break;
/*      */     case 63:
/* 3333 */       strFieldName = "specialDate";
/* 3334 */       break;
/*      */     case 64:
/* 3336 */       strFieldName = "deleteFlag";
/* 3337 */       break;
/*      */     case 65:
/* 3339 */       strFieldName = "interest";
/* 3340 */       break;
/*      */     case 66:
/* 3342 */       strFieldName = "customeType";
/* 3343 */       break;
/*      */     case 67:
/* 3345 */       strFieldName = "introducer";
/* 3346 */       break;
/*      */     case 68:
/* 3348 */       strFieldName = "operator";
/* 3349 */       break;
/*      */     case 69:
/* 3351 */       strFieldName = "makeDate";
/* 3352 */       break;
/*      */     case 70:
/* 3354 */       strFieldName = "makeTime";
/* 3355 */       break;
/*      */     case 71:
/* 3357 */       strFieldName = "modifyDate";
/* 3358 */       break;
/*      */     case 72:
/* 3360 */       strFieldName = "modifyTime";
/* 3361 */       break;
/*      */     default:
/* 3363 */       strFieldName = "";
/*      */     }
/* 3365 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 3371 */     if (strFieldName.equals("customerNo")) {
/* 3372 */       return 0;
/*      */     }
/* 3374 */     if (strFieldName.equals("customerNo2")) {
/* 3375 */       return 0;
/*      */     }
/* 3377 */     if (strFieldName.equals("clientName")) {
/* 3378 */       return 0;
/*      */     }
/* 3380 */     if (strFieldName.equals("gender")) {
/* 3381 */       return 0;
/*      */     }
/* 3383 */     if (strFieldName.equals("birthday")) {
/* 3384 */       return 1;
/*      */     }
/* 3386 */     if (strFieldName.equals("eMail")) {
/* 3387 */       return 0;
/*      */     }
/* 3389 */     if (strFieldName.equals("grpZipCode")) {
/* 3390 */       return 0;
/*      */     }
/* 3392 */     if (strFieldName.equals("grpAddress")) {
/* 3393 */       return 0;
/*      */     }
/* 3395 */     if (strFieldName.equals("grpNo")) {
/* 3396 */       return 0;
/*      */     }
/* 3398 */     if (strFieldName.equals("bP")) {
/* 3399 */       return 0;
/*      */     }
/* 3401 */     if (strFieldName.equals("grpAddressCode")) {
/* 3402 */       return 0;
/*      */     }
/* 3404 */     if (strFieldName.equals("phone2")) {
/* 3405 */       return 0;
/*      */     }
/* 3407 */     if (strFieldName.equals("grpName")) {
/* 3408 */       return 0;
/*      */     }
/* 3410 */     if (strFieldName.equals("grpPhone")) {
/* 3411 */       return 0;
/*      */     }
/* 3413 */     if (strFieldName.equals("phone")) {
/* 3414 */       return 0;
/*      */     }
/* 3416 */     if (strFieldName.equals("mobile")) {
/* 3417 */       return 0;
/*      */     }
/* 3419 */     if (strFieldName.equals("occupationCode")) {
/* 3420 */       return 0;
/*      */     }
/* 3422 */     if (strFieldName.equals("position")) {
/* 3423 */       return 0;
/*      */     }
/* 3425 */     if (strFieldName.equals("workType")) {
/* 3426 */       return 0;
/*      */     }
/* 3428 */     if (strFieldName.equals("occupationType")) {
/* 3429 */       return 0;
/*      */     }
/* 3431 */     if (strFieldName.equals("homeAddress")) {
/* 3432 */       return 0;
/*      */     }
/* 3434 */     if (strFieldName.equals("homeAddressCode")) {
/* 3435 */       return 0;
/*      */     }
/* 3437 */     if (strFieldName.equals("rgtAddress")) {
/* 3438 */       return 0;
/*      */     }
/* 3440 */     if (strFieldName.equals("postalAddress")) {
/* 3441 */       return 0;
/*      */     }
/* 3443 */     if (strFieldName.equals("zipCode")) {
/* 3444 */       return 0;
/*      */     }
/* 3446 */     if (strFieldName.equals("homeZipCode")) {
/* 3447 */       return 0;
/*      */     }
/* 3449 */     if (strFieldName.equals("sequenceNo")) {
/* 3450 */       return 0;
/*      */     }
/* 3452 */     if (strFieldName.equals("stature")) {
/* 3453 */       return 4;
/*      */     }
/* 3455 */     if (strFieldName.equals("avoirdupois")) {
/* 3456 */       return 4;
/*      */     }
/* 3458 */     if (strFieldName.equals("smokeFlag")) {
/* 3459 */       return 0;
/*      */     }
/* 3461 */     if (strFieldName.equals("deathDate")) {
/* 3462 */       return 1;
/*      */     }
/* 3464 */     if (strFieldName.equals("marriage")) {
/* 3465 */       return 0;
/*      */     }
/* 3467 */     if (strFieldName.equals("credentType")) {
/* 3468 */       return 0;
/*      */     }
/* 3470 */     if (strFieldName.equals("credentNO")) {
/* 3471 */       return 0;
/*      */     }
/* 3473 */     if (strFieldName.equals("othIDNo")) {
/* 3474 */       return 0;
/*      */     }
/* 3476 */     if (strFieldName.equals("othIDType")) {
/* 3477 */       return 0;
/*      */     }
/* 3479 */     if (strFieldName.equals("iCNo")) {
/* 3480 */       return 0;
/*      */     }
/* 3482 */     if (strFieldName.equals("salary")) {
/* 3483 */       return 4;
/*      */     }
/* 3485 */     if (strFieldName.equals("yearSalary")) {
/* 3486 */       return 4;
/*      */     }
/* 3488 */     if (strFieldName.equals("nativePlace")) {
/* 3489 */       return 0;
/*      */     }
/* 3491 */     if (strFieldName.equals("nationality")) {
/* 3492 */       return 0;
/*      */     }
/* 3494 */     if (strFieldName.equals("marriageDate")) {
/* 3495 */       return 1;
/*      */     }
/* 3497 */     if (strFieldName.equals("degree")) {
/* 3498 */       return 0;
/*      */     }
/* 3500 */     if (strFieldName.equals("polNo")) {
/* 3501 */       return 0;
/*      */     }
/* 3503 */     if (strFieldName.equals("relationToInsured")) {
/* 3504 */       return 0;
/*      */     }
/* 3506 */     if (strFieldName.equals("pluralityType")) {
/* 3507 */       return 0;
/*      */     }
/* 3509 */     if (strFieldName.equals("startWorkDate")) {
/* 3510 */       return 1;
/*      */     }
/* 3512 */     if (strFieldName.equals("health")) {
/* 3513 */       return 0;
/*      */     }
/* 3515 */     if (strFieldName.equals("password")) {
/* 3516 */       return 0;
/*      */     }
/* 3518 */     if (strFieldName.equals("joinCompanyDate")) {
/* 3519 */       return 1;
/*      */     }
/* 3521 */     if (strFieldName.equals("appntGrade")) {
/* 3522 */       return 0;
/*      */     }
/* 3524 */     if (strFieldName.equals("creditGrade")) {
/* 3525 */       return 0;
/*      */     }
/* 3527 */     if (strFieldName.equals("clientType")) {
/* 3528 */       return 0;
/*      */     }
/* 3530 */     if (strFieldName.equals("state")) {
/* 3531 */       return 0;
/*      */     }
/* 3533 */     if (strFieldName.equals("agentcode")) {
/* 3534 */       return 0;
/*      */     }
/* 3536 */     if (strFieldName.equals("signDate")) {
/* 3537 */       return 1;
/*      */     }
/* 3539 */     if (strFieldName.equals("addrChoise")) {
/* 3540 */       return 0;
/*      */     }
/* 3542 */     if (strFieldName.equals("customeProperty")) {
/* 3543 */       return 0;
/*      */     }
/* 3545 */     if (strFieldName.equals("birthdayFlag")) {
/* 3546 */       return 0;
/*      */     }
/* 3548 */     if (strFieldName.equals("appellation")) {
/* 3549 */       return 0;
/*      */     }
/* 3551 */     if (strFieldName.equals("iDDNo")) {
/* 3552 */       return 0;
/*      */     }
/* 3554 */     if (strFieldName.equals("validityDate")) {
/* 3555 */       return 1;
/*      */     }
/* 3557 */     if (strFieldName.equals("countryOrArea")) {
/* 3558 */       return 0;
/*      */     }
/* 3560 */     if (strFieldName.equals("specialDate")) {
/* 3561 */       return 1;
/*      */     }
/* 3563 */     if (strFieldName.equals("deleteFlag")) {
/* 3564 */       return 0;
/*      */     }
/* 3566 */     if (strFieldName.equals("interest")) {
/* 3567 */       return 0;
/*      */     }
/* 3569 */     if (strFieldName.equals("customeType")) {
/* 3570 */       return 0;
/*      */     }
/* 3572 */     if (strFieldName.equals("introducer")) {
/* 3573 */       return 0;
/*      */     }
/* 3575 */     if (strFieldName.equals("operator")) {
/* 3576 */       return 0;
/*      */     }
/* 3578 */     if (strFieldName.equals("makeDate")) {
/* 3579 */       return 1;
/*      */     }
/* 3581 */     if (strFieldName.equals("makeTime")) {
/* 3582 */       return 0;
/*      */     }
/* 3584 */     if (strFieldName.equals("modifyDate")) {
/* 3585 */       return 1;
/*      */     }
/* 3587 */     if (strFieldName.equals("modifyTime")) {
/* 3588 */       return 0;
/*      */     }
/* 3590 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 3596 */     int nFieldType = -1;
/* 3597 */     switch (nFieldIndex) {
/*      */     case 0:
/* 3599 */       nFieldType = 0;
/* 3600 */       break;
/*      */     case 1:
/* 3602 */       nFieldType = 0;
/* 3603 */       break;
/*      */     case 2:
/* 3605 */       nFieldType = 0;
/* 3606 */       break;
/*      */     case 3:
/* 3608 */       nFieldType = 0;
/* 3609 */       break;
/*      */     case 4:
/* 3611 */       nFieldType = 1;
/* 3612 */       break;
/*      */     case 5:
/* 3614 */       nFieldType = 0;
/* 3615 */       break;
/*      */     case 6:
/* 3617 */       nFieldType = 0;
/* 3618 */       break;
/*      */     case 7:
/* 3620 */       nFieldType = 0;
/* 3621 */       break;
/*      */     case 8:
/* 3623 */       nFieldType = 0;
/* 3624 */       break;
/*      */     case 9:
/* 3626 */       nFieldType = 0;
/* 3627 */       break;
/*      */     case 10:
/* 3629 */       nFieldType = 0;
/* 3630 */       break;
/*      */     case 11:
/* 3632 */       nFieldType = 0;
/* 3633 */       break;
/*      */     case 12:
/* 3635 */       nFieldType = 0;
/* 3636 */       break;
/*      */     case 13:
/* 3638 */       nFieldType = 0;
/* 3639 */       break;
/*      */     case 14:
/* 3641 */       nFieldType = 0;
/* 3642 */       break;
/*      */     case 15:
/* 3644 */       nFieldType = 0;
/* 3645 */       break;
/*      */     case 16:
/* 3647 */       nFieldType = 0;
/* 3648 */       break;
/*      */     case 17:
/* 3650 */       nFieldType = 0;
/* 3651 */       break;
/*      */     case 18:
/* 3653 */       nFieldType = 0;
/* 3654 */       break;
/*      */     case 19:
/* 3656 */       nFieldType = 0;
/* 3657 */       break;
/*      */     case 20:
/* 3659 */       nFieldType = 0;
/* 3660 */       break;
/*      */     case 21:
/* 3662 */       nFieldType = 0;
/* 3663 */       break;
/*      */     case 22:
/* 3665 */       nFieldType = 0;
/* 3666 */       break;
/*      */     case 23:
/* 3668 */       nFieldType = 0;
/* 3669 */       break;
/*      */     case 24:
/* 3671 */       nFieldType = 0;
/* 3672 */       break;
/*      */     case 25:
/* 3674 */       nFieldType = 0;
/* 3675 */       break;
/*      */     case 26:
/* 3677 */       nFieldType = 0;
/* 3678 */       break;
/*      */     case 27:
/* 3680 */       nFieldType = 4;
/* 3681 */       break;
/*      */     case 28:
/* 3683 */       nFieldType = 4;
/* 3684 */       break;
/*      */     case 29:
/* 3686 */       nFieldType = 0;
/* 3687 */       break;
/*      */     case 30:
/* 3689 */       nFieldType = 1;
/* 3690 */       break;
/*      */     case 31:
/* 3692 */       nFieldType = 0;
/* 3693 */       break;
/*      */     case 32:
/* 3695 */       nFieldType = 0;
/* 3696 */       break;
/*      */     case 33:
/* 3698 */       nFieldType = 0;
/* 3699 */       break;
/*      */     case 34:
/* 3701 */       nFieldType = 0;
/* 3702 */       break;
/*      */     case 35:
/* 3704 */       nFieldType = 0;
/* 3705 */       break;
/*      */     case 36:
/* 3707 */       nFieldType = 0;
/* 3708 */       break;
/*      */     case 37:
/* 3710 */       nFieldType = 4;
/* 3711 */       break;
/*      */     case 38:
/* 3713 */       nFieldType = 4;
/* 3714 */       break;
/*      */     case 39:
/* 3716 */       nFieldType = 0;
/* 3717 */       break;
/*      */     case 40:
/* 3719 */       nFieldType = 0;
/* 3720 */       break;
/*      */     case 41:
/* 3722 */       nFieldType = 1;
/* 3723 */       break;
/*      */     case 42:
/* 3725 */       nFieldType = 0;
/* 3726 */       break;
/*      */     case 43:
/* 3728 */       nFieldType = 0;
/* 3729 */       break;
/*      */     case 44:
/* 3731 */       nFieldType = 0;
/* 3732 */       break;
/*      */     case 45:
/* 3734 */       nFieldType = 0;
/* 3735 */       break;
/*      */     case 46:
/* 3737 */       nFieldType = 1;
/* 3738 */       break;
/*      */     case 47:
/* 3740 */       nFieldType = 0;
/* 3741 */       break;
/*      */     case 48:
/* 3743 */       nFieldType = 0;
/* 3744 */       break;
/*      */     case 49:
/* 3746 */       nFieldType = 1;
/* 3747 */       break;
/*      */     case 50:
/* 3749 */       nFieldType = 0;
/* 3750 */       break;
/*      */     case 51:
/* 3752 */       nFieldType = 0;
/* 3753 */       break;
/*      */     case 52:
/* 3755 */       nFieldType = 0;
/* 3756 */       break;
/*      */     case 53:
/* 3758 */       nFieldType = 0;
/* 3759 */       break;
/*      */     case 54:
/* 3761 */       nFieldType = 0;
/* 3762 */       break;
/*      */     case 55:
/* 3764 */       nFieldType = 1;
/* 3765 */       break;
/*      */     case 56:
/* 3767 */       nFieldType = 0;
/* 3768 */       break;
/*      */     case 57:
/* 3770 */       nFieldType = 0;
/* 3771 */       break;
/*      */     case 58:
/* 3773 */       nFieldType = 0;
/* 3774 */       break;
/*      */     case 59:
/* 3776 */       nFieldType = 0;
/* 3777 */       break;
/*      */     case 60:
/* 3779 */       nFieldType = 0;
/* 3780 */       break;
/*      */     case 61:
/* 3782 */       nFieldType = 1;
/* 3783 */       break;
/*      */     case 62:
/* 3785 */       nFieldType = 0;
/* 3786 */       break;
/*      */     case 63:
/* 3788 */       nFieldType = 1;
/* 3789 */       break;
/*      */     case 64:
/* 3791 */       nFieldType = 0;
/* 3792 */       break;
/*      */     case 65:
/* 3794 */       nFieldType = 0;
/* 3795 */       break;
/*      */     case 66:
/* 3797 */       nFieldType = 0;
/* 3798 */       break;
/*      */     case 67:
/* 3800 */       nFieldType = 0;
/* 3801 */       break;
/*      */     case 68:
/* 3803 */       nFieldType = 0;
/* 3804 */       break;
/*      */     case 69:
/* 3806 */       nFieldType = 1;
/* 3807 */       break;
/*      */     case 70:
/* 3809 */       nFieldType = 0;
/* 3810 */       break;
/*      */     case 71:
/* 3812 */       nFieldType = 1;
/* 3813 */       break;
/*      */     case 72:
/* 3815 */       nFieldType = 0;
/* 3816 */       break;
/*      */     default:
/* 3818 */       nFieldType = -1;
/*      */     }
/* 3820 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MNewClientSchema
 * JD-Core Version:    0.6.0
 */