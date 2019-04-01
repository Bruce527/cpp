/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
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
/*      */ public class LNPAppntSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String prtNo;
/*      */   private String appntNo;
/*      */   private String appntId;
/*      */   private String relationToInsured;
/*      */   private String appntGrade;
/*      */   private String appellation;
/*      */   private String appntName;
/*      */   private String appntSex;
/*      */   private Date appntBirthday;
/*      */   private int appntAge;
/*      */   private String appntAgeType;
/*      */   private String appntType;
/*      */   private String addressNo;
/*      */   private String sequenceNo;
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
/*      */   private String workType;
/*      */   private String pluralityType;
/*      */   private String smokeFlag;
/*      */   private String operator;
/*      */   private String manageCom;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 49;
/*      */   private static String[] PK;
/*  125 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPAppntSchema()
/*      */   {
/*  132 */     this.mErrors = new CErrors();
/*      */ 
/*  134 */     String[] pk = new String[1];
/*  135 */     pk[0] = "ContNo";
/*      */ 
/*  137 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  144 */     LNPAppntSchema cloned = (LNPAppntSchema)super.clone();
/*  145 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  146 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  147 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  153 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo()
/*      */   {
/*  158 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  162 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  166 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  170 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  174 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  178 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public String getPrtNo() {
/*  182 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setPrtNo(String aPrtNo) {
/*  186 */     this.prtNo = aPrtNo;
/*      */   }
/*      */ 
/*      */   public String getAppntNo() {
/*  190 */     return this.appntNo;
/*      */   }
/*      */ 
/*      */   public void setAppntNo(String aAppntNo) {
/*  194 */     this.appntNo = aAppntNo;
/*      */   }
/*      */ 
/*      */   public String getAppntId() {
/*  198 */     return this.appntId;
/*      */   }
/*      */ 
/*      */   public void setAppntId(String aAppntId) {
/*  202 */     this.appntId = aAppntId;
/*      */   }
/*      */ 
/*      */   public String getRelationToInsured() {
/*  206 */     return this.relationToInsured;
/*      */   }
/*      */ 
/*      */   public void setRelationToInsured(String aRelationToInsured) {
/*  210 */     this.relationToInsured = aRelationToInsured;
/*      */   }
/*      */ 
/*      */   public String getAppntGrade() {
/*  214 */     return this.appntGrade;
/*      */   }
/*      */ 
/*      */   public void setAppntGrade(String aAppntGrade) {
/*  218 */     this.appntGrade = aAppntGrade;
/*      */   }
/*      */ 
/*      */   public String getAppellation() {
/*  222 */     return this.appellation;
/*      */   }
/*      */ 
/*      */   public void setAppellation(String aAppellation) {
/*  226 */     this.appellation = aAppellation;
/*      */   }
/*      */ 
/*      */   public String getAppntName() {
/*  230 */     return this.appntName;
/*      */   }
/*      */ 
/*      */   public void setAppntName(String aAppntName) {
/*  234 */     this.appntName = aAppntName;
/*      */   }
/*      */ 
/*      */   public String getAppntSex() {
/*  238 */     return this.appntSex;
/*      */   }
/*      */ 
/*      */   public void setAppntSex(String aAppntSex) {
/*  242 */     this.appntSex = aAppntSex;
/*      */   }
/*      */ 
/*      */   public String getAppntBirthday() {
/*  246 */     if (this.appntBirthday != null) {
/*  247 */       return this.fDate.getString(this.appntBirthday);
/*      */     }
/*  249 */     return null;
/*      */   }
/*      */ 
/*      */   public void setAppntBirthday(Date aAppntBirthday) {
/*  253 */     this.appntBirthday = aAppntBirthday;
/*      */   }
/*      */ 
/*      */   public void setAppntBirthday(String aAppntBirthday) {
/*  257 */     if ((aAppntBirthday != null) && (!aAppntBirthday.equals("")))
/*      */     {
/*  259 */       this.appntBirthday = this.fDate.getDate(aAppntBirthday);
/*      */     }
/*      */     else
/*  262 */       this.appntBirthday = null;
/*      */   }
/*      */ 
/*      */   public int getAppntAge()
/*      */   {
/*  267 */     return this.appntAge;
/*      */   }
/*      */ 
/*      */   public void setAppntAge(int aAppntAge) {
/*  271 */     this.appntAge = aAppntAge;
/*      */   }
/*      */ 
/*      */   public void setAppntAge(String aAppntAge) {
/*  275 */     if ((aAppntAge != null) && (!aAppntAge.equals("")))
/*      */     {
/*  277 */       Integer tInteger = new Integer(aAppntAge);
/*  278 */       int i = tInteger.intValue();
/*  279 */       this.appntAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getAppntAgeType()
/*      */   {
/*  285 */     return this.appntAgeType;
/*      */   }
/*      */ 
/*      */   public void setAppntAgeType(String aAppntAgeType) {
/*  289 */     this.appntAgeType = aAppntAgeType;
/*      */   }
/*      */ 
/*      */   public String getAppntType() {
/*  293 */     return this.appntType;
/*      */   }
/*      */ 
/*      */   public void setAppntType(String aAppntType) {
/*  297 */     this.appntType = aAppntType;
/*      */   }
/*      */ 
/*      */   public String getAddressNo() {
/*  301 */     return this.addressNo;
/*      */   }
/*      */ 
/*      */   public void setAddressNo(String aAddressNo) {
/*  305 */     this.addressNo = aAddressNo;
/*      */   }
/*      */ 
/*      */   public String getSequenceNo() {
/*  309 */     return this.sequenceNo;
/*      */   }
/*      */ 
/*      */   public void setSequenceNo(String aSequenceNo) {
/*  313 */     this.sequenceNo = aSequenceNo;
/*      */   }
/*      */ 
/*      */   public String getIDType() {
/*  317 */     return this.iDType;
/*      */   }
/*      */ 
/*      */   public void setIDType(String aIDType) {
/*  321 */     this.iDType = aIDType;
/*      */   }
/*      */ 
/*      */   public String getIDNo() {
/*  325 */     return this.iDNo;
/*      */   }
/*      */ 
/*      */   public void setIDNo(String aIDNo) {
/*  329 */     this.iDNo = aIDNo;
/*      */   }
/*      */ 
/*      */   public String getIDValidity() {
/*  333 */     if (this.iDValidity != null) {
/*  334 */       return this.fDate.getString(this.iDValidity);
/*      */     }
/*  336 */     return null;
/*      */   }
/*      */ 
/*      */   public void setIDValidity(Date aIDValidity) {
/*  340 */     this.iDValidity = aIDValidity;
/*      */   }
/*      */ 
/*      */   public void setIDValidity(String aIDValidity) {
/*  344 */     if ((aIDValidity != null) && (!aIDValidity.equals("")))
/*      */     {
/*  346 */       this.iDValidity = this.fDate.getDate(aIDValidity);
/*      */     }
/*      */     else
/*  349 */       this.iDValidity = null;
/*      */   }
/*      */ 
/*      */   public String getIDPerpetual()
/*      */   {
/*  354 */     return this.iDPerpetual;
/*      */   }
/*      */ 
/*      */   public void setIDPerpetual(String aIDPerpetual) {
/*  358 */     this.iDPerpetual = aIDPerpetual;
/*      */   }
/*      */ 
/*      */   public String getNativePlace() {
/*  362 */     return this.nativePlace;
/*      */   }
/*      */ 
/*      */   public void setNativePlace(String aNativePlace) {
/*  366 */     this.nativePlace = aNativePlace;
/*      */   }
/*      */ 
/*      */   public String getNationality() {
/*  370 */     return this.nationality;
/*      */   }
/*      */ 
/*      */   public void setNationality(String aNationality) {
/*  374 */     this.nationality = aNationality;
/*      */   }
/*      */ 
/*      */   public String getRgtAddress() {
/*  378 */     return this.rgtAddress;
/*      */   }
/*      */ 
/*      */   public void setRgtAddress(String aRgtAddress) {
/*  382 */     this.rgtAddress = aRgtAddress;
/*      */   }
/*      */ 
/*      */   public String getMarriage() {
/*  386 */     return this.marriage;
/*      */   }
/*      */ 
/*      */   public void setMarriage(String aMarriage) {
/*  390 */     this.marriage = aMarriage;
/*      */   }
/*      */ 
/*      */   public String getMarriageDate() {
/*  394 */     if (this.marriageDate != null) {
/*  395 */       return this.fDate.getString(this.marriageDate);
/*      */     }
/*  397 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMarriageDate(Date aMarriageDate) {
/*  401 */     this.marriageDate = aMarriageDate;
/*      */   }
/*      */ 
/*      */   public void setMarriageDate(String aMarriageDate) {
/*  405 */     if ((aMarriageDate != null) && (!aMarriageDate.equals("")))
/*      */     {
/*  407 */       this.marriageDate = this.fDate.getDate(aMarriageDate);
/*      */     }
/*      */     else
/*  410 */       this.marriageDate = null;
/*      */   }
/*      */ 
/*      */   public String getHealth()
/*      */   {
/*  415 */     return this.health;
/*      */   }
/*      */ 
/*      */   public void setHealth(String aHealth) {
/*  419 */     this.health = aHealth;
/*      */   }
/*      */ 
/*      */   public double getStature() {
/*  423 */     return this.stature;
/*      */   }
/*      */ 
/*      */   public void setStature(double aStature) {
/*  427 */     this.stature = aStature;
/*      */   }
/*      */ 
/*      */   public void setStature(String aStature) {
/*  431 */     if ((aStature != null) && (!aStature.equals("")))
/*      */     {
/*  433 */       Double tDouble = new Double(aStature);
/*  434 */       double d = tDouble.doubleValue();
/*  435 */       this.stature = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAvoirdupois()
/*      */   {
/*  441 */     return this.avoirdupois;
/*      */   }
/*      */ 
/*      */   public void setAvoirdupois(double aAvoirdupois) {
/*  445 */     this.avoirdupois = aAvoirdupois;
/*      */   }
/*      */ 
/*      */   public void setAvoirdupois(String aAvoirdupois) {
/*  449 */     if ((aAvoirdupois != null) && (!aAvoirdupois.equals("")))
/*      */     {
/*  451 */       Double tDouble = new Double(aAvoirdupois);
/*  452 */       double d = tDouble.doubleValue();
/*  453 */       this.avoirdupois = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDegree()
/*      */   {
/*  459 */     return this.degree;
/*      */   }
/*      */ 
/*      */   public void setDegree(String aDegree) {
/*  463 */     this.degree = aDegree;
/*      */   }
/*      */ 
/*      */   public String getCreditGrade() {
/*  467 */     return this.creditGrade;
/*      */   }
/*      */ 
/*      */   public void setCreditGrade(String aCreditGrade) {
/*  471 */     this.creditGrade = aCreditGrade;
/*      */   }
/*      */ 
/*      */   public String getBankCode() {
/*  475 */     return this.bankCode;
/*      */   }
/*      */ 
/*      */   public void setBankCode(String aBankCode) {
/*  479 */     this.bankCode = aBankCode;
/*      */   }
/*      */ 
/*      */   public String getBankAccNo() {
/*  483 */     return this.bankAccNo;
/*      */   }
/*      */ 
/*      */   public void setBankAccNo(String aBankAccNo) {
/*  487 */     this.bankAccNo = aBankAccNo;
/*      */   }
/*      */ 
/*      */   public String getAccName() {
/*  491 */     return this.accName;
/*      */   }
/*      */ 
/*      */   public void setAccName(String aAccName) {
/*  495 */     this.accName = aAccName;
/*      */   }
/*      */ 
/*      */   public String getJoinCompanyDate() {
/*  499 */     if (this.joinCompanyDate != null) {
/*  500 */       return this.fDate.getString(this.joinCompanyDate);
/*      */     }
/*  502 */     return null;
/*      */   }
/*      */ 
/*      */   public void setJoinCompanyDate(Date aJoinCompanyDate) {
/*  506 */     this.joinCompanyDate = aJoinCompanyDate;
/*      */   }
/*      */ 
/*      */   public void setJoinCompanyDate(String aJoinCompanyDate) {
/*  510 */     if ((aJoinCompanyDate != null) && (!aJoinCompanyDate.equals("")))
/*      */     {
/*  512 */       this.joinCompanyDate = this.fDate.getDate(aJoinCompanyDate);
/*      */     }
/*      */     else
/*  515 */       this.joinCompanyDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartWorkDate()
/*      */   {
/*  520 */     if (this.startWorkDate != null) {
/*  521 */       return this.fDate.getString(this.startWorkDate);
/*      */     }
/*  523 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartWorkDate(Date aStartWorkDate) {
/*  527 */     this.startWorkDate = aStartWorkDate;
/*      */   }
/*      */ 
/*      */   public void setStartWorkDate(String aStartWorkDate) {
/*  531 */     if ((aStartWorkDate != null) && (!aStartWorkDate.equals("")))
/*      */     {
/*  533 */       this.startWorkDate = this.fDate.getDate(aStartWorkDate);
/*      */     }
/*      */     else
/*  536 */       this.startWorkDate = null;
/*      */   }
/*      */ 
/*      */   public String getPosition()
/*      */   {
/*  541 */     return this.position;
/*      */   }
/*      */ 
/*      */   public void setPosition(String aPosition) {
/*  545 */     this.position = aPosition;
/*      */   }
/*      */ 
/*      */   public double getSalary() {
/*  549 */     return this.salary;
/*      */   }
/*      */ 
/*      */   public void setSalary(double aSalary) {
/*  553 */     this.salary = aSalary;
/*      */   }
/*      */ 
/*      */   public void setSalary(String aSalary) {
/*  557 */     if ((aSalary != null) && (!aSalary.equals("")))
/*      */     {
/*  559 */       Double tDouble = new Double(aSalary);
/*  560 */       double d = tDouble.doubleValue();
/*  561 */       this.salary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOccupationType()
/*      */   {
/*  567 */     return this.occupationType;
/*      */   }
/*      */ 
/*      */   public void setOccupationType(String aOccupationType) {
/*  571 */     this.occupationType = aOccupationType;
/*      */   }
/*      */ 
/*      */   public String getOccupationCode() {
/*  575 */     return this.occupationCode;
/*      */   }
/*      */ 
/*      */   public void setOccupationCode(String aOccupationCode) {
/*  579 */     this.occupationCode = aOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getWorkType() {
/*  583 */     return this.workType;
/*      */   }
/*      */ 
/*      */   public void setWorkType(String aWorkType) {
/*  587 */     this.workType = aWorkType;
/*      */   }
/*      */ 
/*      */   public String getPluralityType() {
/*  591 */     return this.pluralityType;
/*      */   }
/*      */ 
/*      */   public void setPluralityType(String aPluralityType) {
/*  595 */     this.pluralityType = aPluralityType;
/*      */   }
/*      */ 
/*      */   public String getSmokeFlag() {
/*  599 */     return this.smokeFlag;
/*      */   }
/*      */ 
/*      */   public void setSmokeFlag(String aSmokeFlag) {
/*  603 */     this.smokeFlag = aSmokeFlag;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  607 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  611 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  615 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  619 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  623 */     if (this.makeDate != null) {
/*  624 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  626 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  630 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  634 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  636 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  639 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  644 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  648 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  652 */     if (this.modifyDate != null) {
/*  653 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  655 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  659 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  663 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  665 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  668 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  673 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  677 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPAppntSchema aLNPAppntSchema)
/*      */   {
/*  683 */     this.grpContNo = aLNPAppntSchema.getGrpContNo();
/*  684 */     this.contNo = aLNPAppntSchema.getContNo();
/*  685 */     this.proposalContNo = aLNPAppntSchema.getProposalContNo();
/*  686 */     this.prtNo = aLNPAppntSchema.getPrtNo();
/*  687 */     this.appntNo = aLNPAppntSchema.getAppntNo();
/*  688 */     this.appntId = aLNPAppntSchema.getAppntId();
/*  689 */     this.relationToInsured = aLNPAppntSchema.getRelationToInsured();
/*  690 */     this.appntGrade = aLNPAppntSchema.getAppntGrade();
/*  691 */     this.appellation = aLNPAppntSchema.getAppellation();
/*  692 */     this.appntName = aLNPAppntSchema.getAppntName();
/*  693 */     this.appntSex = aLNPAppntSchema.getAppntSex();
/*  694 */     this.appntBirthday = this.fDate.getDate(aLNPAppntSchema.getAppntBirthday());
/*  695 */     this.appntAge = aLNPAppntSchema.getAppntAge();
/*  696 */     this.appntAgeType = aLNPAppntSchema.getAppntAgeType();
/*  697 */     this.appntType = aLNPAppntSchema.getAppntType();
/*  698 */     this.addressNo = aLNPAppntSchema.getAddressNo();
/*  699 */     this.sequenceNo = aLNPAppntSchema.getSequenceNo();
/*  700 */     this.iDType = aLNPAppntSchema.getIDType();
/*  701 */     this.iDNo = aLNPAppntSchema.getIDNo();
/*  702 */     this.iDValidity = this.fDate.getDate(aLNPAppntSchema.getIDValidity());
/*  703 */     this.iDPerpetual = aLNPAppntSchema.getIDPerpetual();
/*  704 */     this.nativePlace = aLNPAppntSchema.getNativePlace();
/*  705 */     this.nationality = aLNPAppntSchema.getNationality();
/*  706 */     this.rgtAddress = aLNPAppntSchema.getRgtAddress();
/*  707 */     this.marriage = aLNPAppntSchema.getMarriage();
/*  708 */     this.marriageDate = this.fDate.getDate(aLNPAppntSchema.getMarriageDate());
/*  709 */     this.health = aLNPAppntSchema.getHealth();
/*  710 */     this.stature = aLNPAppntSchema.getStature();
/*  711 */     this.avoirdupois = aLNPAppntSchema.getAvoirdupois();
/*  712 */     this.degree = aLNPAppntSchema.getDegree();
/*  713 */     this.creditGrade = aLNPAppntSchema.getCreditGrade();
/*  714 */     this.bankCode = aLNPAppntSchema.getBankCode();
/*  715 */     this.bankAccNo = aLNPAppntSchema.getBankAccNo();
/*  716 */     this.accName = aLNPAppntSchema.getAccName();
/*  717 */     this.joinCompanyDate = this.fDate.getDate(aLNPAppntSchema.getJoinCompanyDate());
/*  718 */     this.startWorkDate = this.fDate.getDate(aLNPAppntSchema.getStartWorkDate());
/*  719 */     this.position = aLNPAppntSchema.getPosition();
/*  720 */     this.salary = aLNPAppntSchema.getSalary();
/*  721 */     this.occupationType = aLNPAppntSchema.getOccupationType();
/*  722 */     this.occupationCode = aLNPAppntSchema.getOccupationCode();
/*  723 */     this.workType = aLNPAppntSchema.getWorkType();
/*  724 */     this.pluralityType = aLNPAppntSchema.getPluralityType();
/*  725 */     this.smokeFlag = aLNPAppntSchema.getSmokeFlag();
/*  726 */     this.operator = aLNPAppntSchema.getOperator();
/*  727 */     this.manageCom = aLNPAppntSchema.getManageCom();
/*  728 */     this.makeDate = this.fDate.getDate(aLNPAppntSchema.getMakeDate());
/*  729 */     this.makeTime = aLNPAppntSchema.getMakeTime();
/*  730 */     this.modifyDate = this.fDate.getDate(aLNPAppntSchema.getModifyDate());
/*  731 */     this.modifyTime = aLNPAppntSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  740 */       if (rs.getString("GrpContNo") == null)
/*  741 */         this.grpContNo = null;
/*      */       else {
/*  743 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  745 */       if (rs.getString("ContNo") == null)
/*  746 */         this.contNo = null;
/*      */       else {
/*  748 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  750 */       if (rs.getString("ProposalContNo") == null)
/*  751 */         this.proposalContNo = null;
/*      */       else {
/*  753 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  755 */       if (rs.getString("PrtNo") == null)
/*  756 */         this.prtNo = null;
/*      */       else {
/*  758 */         this.prtNo = rs.getString("PrtNo").trim();
/*      */       }
/*  760 */       if (rs.getString("AppntNo") == null)
/*  761 */         this.appntNo = null;
/*      */       else {
/*  763 */         this.appntNo = rs.getString("AppntNo").trim();
/*      */       }
/*  765 */       if (rs.getString("AppntId") == null)
/*  766 */         this.appntId = null;
/*      */       else {
/*  768 */         this.appntId = rs.getString("AppntId").trim();
/*      */       }
/*  770 */       if (rs.getString("RelationToInsured") == null)
/*  771 */         this.relationToInsured = null;
/*      */       else {
/*  773 */         this.relationToInsured = rs.getString("RelationToInsured").trim();
/*      */       }
/*  775 */       if (rs.getString("AppntGrade") == null)
/*  776 */         this.appntGrade = null;
/*      */       else {
/*  778 */         this.appntGrade = rs.getString("AppntGrade").trim();
/*      */       }
/*  780 */       if (rs.getString("Appellation") == null)
/*  781 */         this.appellation = null;
/*      */       else {
/*  783 */         this.appellation = rs.getString("Appellation").trim();
/*      */       }
/*  785 */       if (rs.getString("AppntName") == null)
/*  786 */         this.appntName = null;
/*      */       else {
/*  788 */         this.appntName = rs.getString("AppntName").trim();
/*      */       }
/*  790 */       if (rs.getString("AppntSex") == null)
/*  791 */         this.appntSex = null;
/*      */       else {
/*  793 */         this.appntSex = rs.getString("AppntSex").trim();
/*      */       }
/*  795 */       this.appntBirthday = rs.getDate("AppntBirthday");
/*  796 */       this.appntAge = rs.getInt("AppntAge");
/*  797 */       if (rs.getString("AppntAgeType") == null)
/*  798 */         this.appntAgeType = null;
/*      */       else {
/*  800 */         this.appntAgeType = rs.getString("AppntAgeType").trim();
/*      */       }
/*  802 */       if (rs.getString("AppntType") == null)
/*  803 */         this.appntType = null;
/*      */       else {
/*  805 */         this.appntType = rs.getString("AppntType").trim();
/*      */       }
/*  807 */       if (rs.getString("AddressNo") == null)
/*  808 */         this.addressNo = null;
/*      */       else {
/*  810 */         this.addressNo = rs.getString("AddressNo").trim();
/*      */       }
/*  812 */       if (rs.getString("SequenceNo") == null)
/*  813 */         this.sequenceNo = null;
/*      */       else {
/*  815 */         this.sequenceNo = rs.getString("SequenceNo").trim();
/*      */       }
/*  817 */       if (rs.getString("IDType") == null)
/*  818 */         this.iDType = null;
/*      */       else {
/*  820 */         this.iDType = rs.getString("IDType").trim();
/*      */       }
/*  822 */       if (rs.getString("IDNo") == null)
/*  823 */         this.iDNo = null;
/*      */       else {
/*  825 */         this.iDNo = rs.getString("IDNo").trim();
/*      */       }
/*  827 */       this.iDValidity = rs.getDate("IDValidity");
/*  828 */       if (rs.getString("IDPerpetual") == null)
/*  829 */         this.iDPerpetual = null;
/*      */       else {
/*  831 */         this.iDPerpetual = rs.getString("IDPerpetual").trim();
/*      */       }
/*  833 */       if (rs.getString("NativePlace") == null)
/*  834 */         this.nativePlace = null;
/*      */       else {
/*  836 */         this.nativePlace = rs.getString("NativePlace").trim();
/*      */       }
/*  838 */       if (rs.getString("Nationality") == null)
/*  839 */         this.nationality = null;
/*      */       else {
/*  841 */         this.nationality = rs.getString("Nationality").trim();
/*      */       }
/*  843 */       if (rs.getString("RgtAddress") == null)
/*  844 */         this.rgtAddress = null;
/*      */       else {
/*  846 */         this.rgtAddress = rs.getString("RgtAddress").trim();
/*      */       }
/*  848 */       if (rs.getString("Marriage") == null)
/*  849 */         this.marriage = null;
/*      */       else {
/*  851 */         this.marriage = rs.getString("Marriage").trim();
/*      */       }
/*  853 */       this.marriageDate = rs.getDate("MarriageDate");
/*  854 */       if (rs.getString("Health") == null)
/*  855 */         this.health = null;
/*      */       else {
/*  857 */         this.health = rs.getString("Health").trim();
/*      */       }
/*  859 */       this.stature = rs.getDouble("Stature");
/*  860 */       this.avoirdupois = rs.getDouble("Avoirdupois");
/*  861 */       if (rs.getString("Degree") == null)
/*  862 */         this.degree = null;
/*      */       else {
/*  864 */         this.degree = rs.getString("Degree").trim();
/*      */       }
/*  866 */       if (rs.getString("CreditGrade") == null)
/*  867 */         this.creditGrade = null;
/*      */       else {
/*  869 */         this.creditGrade = rs.getString("CreditGrade").trim();
/*      */       }
/*  871 */       if (rs.getString("BankCode") == null)
/*  872 */         this.bankCode = null;
/*      */       else {
/*  874 */         this.bankCode = rs.getString("BankCode").trim();
/*      */       }
/*  876 */       if (rs.getString("BankAccNo") == null)
/*  877 */         this.bankAccNo = null;
/*      */       else {
/*  879 */         this.bankAccNo = rs.getString("BankAccNo").trim();
/*      */       }
/*  881 */       if (rs.getString("AccName") == null)
/*  882 */         this.accName = null;
/*      */       else {
/*  884 */         this.accName = rs.getString("AccName").trim();
/*      */       }
/*  886 */       this.joinCompanyDate = rs.getDate("JoinCompanyDate");
/*  887 */       this.startWorkDate = rs.getDate("StartWorkDate");
/*  888 */       if (rs.getString("Position") == null)
/*  889 */         this.position = null;
/*      */       else {
/*  891 */         this.position = rs.getString("Position").trim();
/*      */       }
/*  893 */       this.salary = rs.getDouble("Salary");
/*  894 */       if (rs.getString("OccupationType") == null)
/*  895 */         this.occupationType = null;
/*      */       else {
/*  897 */         this.occupationType = rs.getString("OccupationType").trim();
/*      */       }
/*  899 */       if (rs.getString("OccupationCode") == null)
/*  900 */         this.occupationCode = null;
/*      */       else {
/*  902 */         this.occupationCode = rs.getString("OccupationCode").trim();
/*      */       }
/*  904 */       if (rs.getString("WorkType") == null)
/*  905 */         this.workType = null;
/*      */       else {
/*  907 */         this.workType = rs.getString("WorkType").trim();
/*      */       }
/*  909 */       if (rs.getString("PluralityType") == null)
/*  910 */         this.pluralityType = null;
/*      */       else {
/*  912 */         this.pluralityType = rs.getString("PluralityType").trim();
/*      */       }
/*  914 */       if (rs.getString("SmokeFlag") == null)
/*  915 */         this.smokeFlag = null;
/*      */       else {
/*  917 */         this.smokeFlag = rs.getString("SmokeFlag").trim();
/*      */       }
/*  919 */       if (rs.getString("Operator") == null)
/*  920 */         this.operator = null;
/*      */       else {
/*  922 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  924 */       if (rs.getString("ManageCom") == null)
/*  925 */         this.manageCom = null;
/*      */       else {
/*  927 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  929 */       this.makeDate = rs.getDate("MakeDate");
/*  930 */       if (rs.getString("MakeTime") == null)
/*  931 */         this.makeTime = null;
/*      */       else {
/*  933 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  935 */       this.modifyDate = rs.getDate("ModifyDate");
/*  936 */       if (rs.getString("ModifyTime") == null)
/*  937 */         this.modifyTime = null;
/*      */       else {
/*  939 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  944 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPAppnt\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/*  946 */       CError tError = new CError();
/*  947 */       tError.moduleName = "LNPAppntSchema";
/*  948 */       tError.functionName = "setSchema";
/*  949 */       tError.errorMessage = sqle.toString();
/*  950 */       this.mErrors.addOneError(tError);
/*  951 */       return false;
/*      */     }
/*  953 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAppntSchema getSchema()
/*      */   {
/*  958 */     LNPAppntSchema aLNPAppntSchema = new LNPAppntSchema();
/*  959 */     aLNPAppntSchema.setSchema(this);
/*  960 */     return aLNPAppntSchema;
/*      */   }
/*      */ 
/*      */   public LNPAppntDB getDB()
/*      */   {
/*  965 */     LNPAppntDB aDBOper = new LNPAppntDB();
/*  966 */     aDBOper.setSchema(this);
/*  967 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  974 */     StringBuffer strReturn = new StringBuffer(256);
/*  975 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/*  976 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/*  977 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/*  978 */     strReturn.append(StrTool.cTrim(this.prtNo)); strReturn.append("|");
/*  979 */     strReturn.append(StrTool.cTrim(this.appntNo)); strReturn.append("|");
/*  980 */     strReturn.append(StrTool.cTrim(this.appntId)); strReturn.append("|");
/*  981 */     strReturn.append(StrTool.cTrim(this.relationToInsured)); strReturn.append("|");
/*  982 */     strReturn.append(StrTool.cTrim(this.appntGrade)); strReturn.append("|");
/*  983 */     strReturn.append(StrTool.cTrim(this.appellation)); strReturn.append("|");
/*  984 */     strReturn.append(StrTool.cTrim(this.appntName)); strReturn.append("|");
/*  985 */     strReturn.append(StrTool.cTrim(this.appntSex)); strReturn.append("|");
/*  986 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.appntBirthday))); strReturn.append("|");
/*  987 */     strReturn.append(ChgData.chgData(this.appntAge)); strReturn.append("|");
/*  988 */     strReturn.append(StrTool.cTrim(this.appntAgeType)); strReturn.append("|");
/*  989 */     strReturn.append(StrTool.cTrim(this.appntType)); strReturn.append("|");
/*  990 */     strReturn.append(StrTool.cTrim(this.addressNo)); strReturn.append("|");
/*  991 */     strReturn.append(StrTool.cTrim(this.sequenceNo)); strReturn.append("|");
/*  992 */     strReturn.append(StrTool.cTrim(this.iDType)); strReturn.append("|");
/*  993 */     strReturn.append(StrTool.cTrim(this.iDNo)); strReturn.append("|");
/*  994 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.iDValidity))); strReturn.append("|");
/*  995 */     strReturn.append(StrTool.cTrim(this.iDPerpetual)); strReturn.append("|");
/*  996 */     strReturn.append(StrTool.cTrim(this.nativePlace)); strReturn.append("|");
/*  997 */     strReturn.append(StrTool.cTrim(this.nationality)); strReturn.append("|");
/*  998 */     strReturn.append(StrTool.cTrim(this.rgtAddress)); strReturn.append("|");
/*  999 */     strReturn.append(StrTool.cTrim(this.marriage)); strReturn.append("|");
/* 1000 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.marriageDate))); strReturn.append("|");
/* 1001 */     strReturn.append(StrTool.cTrim(this.health)); strReturn.append("|");
/* 1002 */     strReturn.append(ChgData.chgData(this.stature)); strReturn.append("|");
/* 1003 */     strReturn.append(ChgData.chgData(this.avoirdupois)); strReturn.append("|");
/* 1004 */     strReturn.append(StrTool.cTrim(this.degree)); strReturn.append("|");
/* 1005 */     strReturn.append(StrTool.cTrim(this.creditGrade)); strReturn.append("|");
/* 1006 */     strReturn.append(StrTool.cTrim(this.bankCode)); strReturn.append("|");
/* 1007 */     strReturn.append(StrTool.cTrim(this.bankAccNo)); strReturn.append("|");
/* 1008 */     strReturn.append(StrTool.cTrim(this.accName)); strReturn.append("|");
/* 1009 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.joinCompanyDate))); strReturn.append("|");
/* 1010 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startWorkDate))); strReturn.append("|");
/* 1011 */     strReturn.append(StrTool.cTrim(this.position)); strReturn.append("|");
/* 1012 */     strReturn.append(ChgData.chgData(this.salary)); strReturn.append("|");
/* 1013 */     strReturn.append(StrTool.cTrim(this.occupationType)); strReturn.append("|");
/* 1014 */     strReturn.append(StrTool.cTrim(this.occupationCode)); strReturn.append("|");
/* 1015 */     strReturn.append(StrTool.cTrim(this.workType)); strReturn.append("|");
/* 1016 */     strReturn.append(StrTool.cTrim(this.pluralityType)); strReturn.append("|");
/* 1017 */     strReturn.append(StrTool.cTrim(this.smokeFlag)); strReturn.append("|");
/* 1018 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 1019 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/* 1020 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 1021 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 1022 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 1023 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/* 1024 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1032 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1033 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1034 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1035 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1036 */       this.appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1037 */       this.appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1038 */       this.relationToInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1039 */       this.appntGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1040 */       this.appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1041 */       this.appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1042 */       this.appntSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1043 */       this.appntBirthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
/* 1044 */       this.appntAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).intValue();
/* 1045 */       this.appntAgeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1046 */       this.appntType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1047 */       this.addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1048 */       this.sequenceNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1049 */       this.iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1050 */       this.iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1051 */       this.iDValidity = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/* 1052 */       this.iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1053 */       this.nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 1054 */       this.nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 1055 */       this.rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1056 */       this.marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1057 */       this.marriageDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|"));
/* 1058 */       this.health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1059 */       this.stature = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 28, "|"))).doubleValue();
/* 1060 */       this.avoirdupois = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|"))).doubleValue();
/* 1061 */       this.degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1062 */       this.creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/* 1063 */       this.bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 1064 */       this.bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 1065 */       this.accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/* 1066 */       this.joinCompanyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|"));
/* 1067 */       this.startWorkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|"));
/* 1068 */       this.position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 1069 */       this.salary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|"))).doubleValue();
/* 1070 */       this.occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/* 1071 */       this.occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1072 */       this.workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1073 */       this.pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1074 */       this.smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 1075 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1076 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 1077 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|"));
/* 1078 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 1079 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|"));
/* 1080 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1085 */       CError tError = new CError();
/* 1086 */       tError.moduleName = "LNPAppntSchema";
/* 1087 */       tError.functionName = "decode";
/* 1088 */       tError.errorMessage = ex.toString();
/* 1089 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1091 */       return false;
/*      */     }
/* 1093 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1099 */     String strReturn = "";
/* 1100 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 1102 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/* 1104 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 1106 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/* 1108 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 1110 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/* 1112 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/* 1114 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/* 1116 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/* 1118 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntNo));
/*      */     }
/* 1120 */     if (FCode.equalsIgnoreCase("appntId"))
/*      */     {
/* 1122 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntId));
/*      */     }
/* 1124 */     if (FCode.equalsIgnoreCase("relationToInsured"))
/*      */     {
/* 1126 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relationToInsured));
/*      */     }
/* 1128 */     if (FCode.equalsIgnoreCase("appntGrade"))
/*      */     {
/* 1130 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntGrade));
/*      */     }
/* 1132 */     if (FCode.equalsIgnoreCase("appellation"))
/*      */     {
/* 1134 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appellation));
/*      */     }
/* 1136 */     if (FCode.equalsIgnoreCase("appntName"))
/*      */     {
/* 1138 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntName));
/*      */     }
/* 1140 */     if (FCode.equalsIgnoreCase("appntSex"))
/*      */     {
/* 1142 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntSex));
/*      */     }
/* 1144 */     if (FCode.equalsIgnoreCase("appntBirthday"))
/*      */     {
/* 1146 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getAppntBirthday()));
/*      */     }
/* 1148 */     if (FCode.equalsIgnoreCase("appntAge"))
/*      */     {
/* 1150 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntAge));
/*      */     }
/* 1152 */     if (FCode.equalsIgnoreCase("appntAgeType"))
/*      */     {
/* 1154 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntAgeType));
/*      */     }
/* 1156 */     if (FCode.equalsIgnoreCase("appntType"))
/*      */     {
/* 1158 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntType));
/*      */     }
/* 1160 */     if (FCode.equalsIgnoreCase("addressNo"))
/*      */     {
/* 1162 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addressNo));
/*      */     }
/* 1164 */     if (FCode.equalsIgnoreCase("sequenceNo"))
/*      */     {
/* 1166 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sequenceNo));
/*      */     }
/* 1168 */     if (FCode.equalsIgnoreCase("iDType"))
/*      */     {
/* 1170 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDType));
/*      */     }
/* 1172 */     if (FCode.equalsIgnoreCase("iDNo"))
/*      */     {
/* 1174 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDNo));
/*      */     }
/* 1176 */     if (FCode.equalsIgnoreCase("iDValidity"))
/*      */     {
/* 1178 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getIDValidity()));
/*      */     }
/* 1180 */     if (FCode.equalsIgnoreCase("iDPerpetual"))
/*      */     {
/* 1182 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDPerpetual));
/*      */     }
/* 1184 */     if (FCode.equalsIgnoreCase("nativePlace"))
/*      */     {
/* 1186 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nativePlace));
/*      */     }
/* 1188 */     if (FCode.equalsIgnoreCase("nationality"))
/*      */     {
/* 1190 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nationality));
/*      */     }
/* 1192 */     if (FCode.equalsIgnoreCase("rgtAddress"))
/*      */     {
/* 1194 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rgtAddress));
/*      */     }
/* 1196 */     if (FCode.equalsIgnoreCase("marriage"))
/*      */     {
/* 1198 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.marriage));
/*      */     }
/* 1200 */     if (FCode.equalsIgnoreCase("marriageDate"))
/*      */     {
/* 1202 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
/*      */     }
/* 1204 */     if (FCode.equalsIgnoreCase("health"))
/*      */     {
/* 1206 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.health));
/*      */     }
/* 1208 */     if (FCode.equalsIgnoreCase("stature"))
/*      */     {
/* 1210 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stature));
/*      */     }
/* 1212 */     if (FCode.equalsIgnoreCase("avoirdupois"))
/*      */     {
/* 1214 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.avoirdupois));
/*      */     }
/* 1216 */     if (FCode.equalsIgnoreCase("degree"))
/*      */     {
/* 1218 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.degree));
/*      */     }
/* 1220 */     if (FCode.equalsIgnoreCase("creditGrade"))
/*      */     {
/* 1222 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.creditGrade));
/*      */     }
/* 1224 */     if (FCode.equalsIgnoreCase("bankCode"))
/*      */     {
/* 1226 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankCode));
/*      */     }
/* 1228 */     if (FCode.equalsIgnoreCase("bankAccNo"))
/*      */     {
/* 1230 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankAccNo));
/*      */     }
/* 1232 */     if (FCode.equalsIgnoreCase("accName"))
/*      */     {
/* 1234 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.accName));
/*      */     }
/* 1236 */     if (FCode.equalsIgnoreCase("joinCompanyDate"))
/*      */     {
/* 1238 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
/*      */     }
/* 1240 */     if (FCode.equalsIgnoreCase("startWorkDate"))
/*      */     {
/* 1242 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
/*      */     }
/* 1244 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/* 1246 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.position));
/*      */     }
/* 1248 */     if (FCode.equalsIgnoreCase("salary"))
/*      */     {
/* 1250 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.salary));
/*      */     }
/* 1252 */     if (FCode.equalsIgnoreCase("occupationType"))
/*      */     {
/* 1254 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationType));
/*      */     }
/* 1256 */     if (FCode.equalsIgnoreCase("occupationCode"))
/*      */     {
/* 1258 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationCode));
/*      */     }
/* 1260 */     if (FCode.equalsIgnoreCase("workType"))
/*      */     {
/* 1262 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.workType));
/*      */     }
/* 1264 */     if (FCode.equalsIgnoreCase("pluralityType"))
/*      */     {
/* 1266 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pluralityType));
/*      */     }
/* 1268 */     if (FCode.equalsIgnoreCase("smokeFlag"))
/*      */     {
/* 1270 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.smokeFlag));
/*      */     }
/* 1272 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1274 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1276 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1278 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 1280 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1282 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 1284 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1286 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1288 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1290 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 1292 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1294 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1296 */     if (strReturn.equals(""))
/*      */     {
/* 1298 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1301 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1308 */     String strFieldValue = "";
/* 1309 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1311 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/* 1312 */       break;
/*      */     case 1:
/* 1314 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 1315 */       break;
/*      */     case 2:
/* 1317 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/* 1318 */       break;
/*      */     case 3:
/* 1320 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/* 1321 */       break;
/*      */     case 4:
/* 1323 */       strFieldValue = StrTool.GBKToUnicode(this.appntNo);
/* 1324 */       break;
/*      */     case 5:
/* 1326 */       strFieldValue = StrTool.GBKToUnicode(this.appntId);
/* 1327 */       break;
/*      */     case 6:
/* 1329 */       strFieldValue = StrTool.GBKToUnicode(this.relationToInsured);
/* 1330 */       break;
/*      */     case 7:
/* 1332 */       strFieldValue = StrTool.GBKToUnicode(this.appntGrade);
/* 1333 */       break;
/*      */     case 8:
/* 1335 */       strFieldValue = StrTool.GBKToUnicode(this.appellation);
/* 1336 */       break;
/*      */     case 9:
/* 1338 */       strFieldValue = StrTool.GBKToUnicode(this.appntName);
/* 1339 */       break;
/*      */     case 10:
/* 1341 */       strFieldValue = StrTool.GBKToUnicode(this.appntSex);
/* 1342 */       break;
/*      */     case 11:
/* 1344 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getAppntBirthday()));
/* 1345 */       break;
/*      */     case 12:
/* 1347 */       strFieldValue = String.valueOf(this.appntAge);
/* 1348 */       break;
/*      */     case 13:
/* 1350 */       strFieldValue = StrTool.GBKToUnicode(this.appntAgeType);
/* 1351 */       break;
/*      */     case 14:
/* 1353 */       strFieldValue = StrTool.GBKToUnicode(this.appntType);
/* 1354 */       break;
/*      */     case 15:
/* 1356 */       strFieldValue = StrTool.GBKToUnicode(this.addressNo);
/* 1357 */       break;
/*      */     case 16:
/* 1359 */       strFieldValue = StrTool.GBKToUnicode(this.sequenceNo);
/* 1360 */       break;
/*      */     case 17:
/* 1362 */       strFieldValue = StrTool.GBKToUnicode(this.iDType);
/* 1363 */       break;
/*      */     case 18:
/* 1365 */       strFieldValue = StrTool.GBKToUnicode(this.iDNo);
/* 1366 */       break;
/*      */     case 19:
/* 1368 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getIDValidity()));
/* 1369 */       break;
/*      */     case 20:
/* 1371 */       strFieldValue = StrTool.GBKToUnicode(this.iDPerpetual);
/* 1372 */       break;
/*      */     case 21:
/* 1374 */       strFieldValue = StrTool.GBKToUnicode(this.nativePlace);
/* 1375 */       break;
/*      */     case 22:
/* 1377 */       strFieldValue = StrTool.GBKToUnicode(this.nationality);
/* 1378 */       break;
/*      */     case 23:
/* 1380 */       strFieldValue = StrTool.GBKToUnicode(this.rgtAddress);
/* 1381 */       break;
/*      */     case 24:
/* 1383 */       strFieldValue = StrTool.GBKToUnicode(this.marriage);
/* 1384 */       break;
/*      */     case 25:
/* 1386 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
/* 1387 */       break;
/*      */     case 26:
/* 1389 */       strFieldValue = StrTool.GBKToUnicode(this.health);
/* 1390 */       break;
/*      */     case 27:
/* 1392 */       strFieldValue = String.valueOf(this.stature);
/* 1393 */       break;
/*      */     case 28:
/* 1395 */       strFieldValue = String.valueOf(this.avoirdupois);
/* 1396 */       break;
/*      */     case 29:
/* 1398 */       strFieldValue = StrTool.GBKToUnicode(this.degree);
/* 1399 */       break;
/*      */     case 30:
/* 1401 */       strFieldValue = StrTool.GBKToUnicode(this.creditGrade);
/* 1402 */       break;
/*      */     case 31:
/* 1404 */       strFieldValue = StrTool.GBKToUnicode(this.bankCode);
/* 1405 */       break;
/*      */     case 32:
/* 1407 */       strFieldValue = StrTool.GBKToUnicode(this.bankAccNo);
/* 1408 */       break;
/*      */     case 33:
/* 1410 */       strFieldValue = StrTool.GBKToUnicode(this.accName);
/* 1411 */       break;
/*      */     case 34:
/* 1413 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
/* 1414 */       break;
/*      */     case 35:
/* 1416 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
/* 1417 */       break;
/*      */     case 36:
/* 1419 */       strFieldValue = StrTool.GBKToUnicode(this.position);
/* 1420 */       break;
/*      */     case 37:
/* 1422 */       strFieldValue = String.valueOf(this.salary);
/* 1423 */       break;
/*      */     case 38:
/* 1425 */       strFieldValue = StrTool.GBKToUnicode(this.occupationType);
/* 1426 */       break;
/*      */     case 39:
/* 1428 */       strFieldValue = StrTool.GBKToUnicode(this.occupationCode);
/* 1429 */       break;
/*      */     case 40:
/* 1431 */       strFieldValue = StrTool.GBKToUnicode(this.workType);
/* 1432 */       break;
/*      */     case 41:
/* 1434 */       strFieldValue = StrTool.GBKToUnicode(this.pluralityType);
/* 1435 */       break;
/*      */     case 42:
/* 1437 */       strFieldValue = StrTool.GBKToUnicode(this.smokeFlag);
/* 1438 */       break;
/*      */     case 43:
/* 1440 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1441 */       break;
/*      */     case 44:
/* 1443 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1444 */       break;
/*      */     case 45:
/* 1446 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1447 */       break;
/*      */     case 46:
/* 1449 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1450 */       break;
/*      */     case 47:
/* 1452 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1453 */       break;
/*      */     case 48:
/* 1455 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1456 */       break;
/*      */     default:
/* 1458 */       strFieldValue = "";
/*      */     }
/* 1460 */     if (strFieldValue.equals("")) {
/* 1461 */       strFieldValue = "null";
/*      */     }
/* 1463 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1469 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1470 */       return false;
/*      */     }
/* 1472 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 1474 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1476 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1479 */         this.grpContNo = null;
/*      */     }
/* 1481 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 1483 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1485 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 1488 */         this.contNo = null;
/*      */     }
/* 1490 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 1492 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1494 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1497 */         this.proposalContNo = null;
/*      */     }
/* 1499 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/* 1501 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1503 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/* 1506 */         this.prtNo = null;
/*      */     }
/* 1508 */     if (FCode.equalsIgnoreCase("appntNo"))
/*      */     {
/* 1510 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1512 */         this.appntNo = FValue.trim();
/*      */       }
/*      */       else
/* 1515 */         this.appntNo = null;
/*      */     }
/* 1517 */     if (FCode.equalsIgnoreCase("appntId"))
/*      */     {
/* 1519 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1521 */         this.appntId = FValue.trim();
/*      */       }
/*      */       else
/* 1524 */         this.appntId = null;
/*      */     }
/* 1526 */     if (FCode.equalsIgnoreCase("relationToInsured"))
/*      */     {
/* 1528 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1530 */         this.relationToInsured = FValue.trim();
/*      */       }
/*      */       else
/* 1533 */         this.relationToInsured = null;
/*      */     }
/* 1535 */     if (FCode.equalsIgnoreCase("appntGrade"))
/*      */     {
/* 1537 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1539 */         this.appntGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1542 */         this.appntGrade = null;
/*      */     }
/* 1544 */     if (FCode.equalsIgnoreCase("appellation"))
/*      */     {
/* 1546 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1548 */         this.appellation = FValue.trim();
/*      */       }
/*      */       else
/* 1551 */         this.appellation = null;
/*      */     }
/* 1553 */     if (FCode.equalsIgnoreCase("appntName"))
/*      */     {
/* 1555 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1557 */         this.appntName = FValue.trim();
/*      */       }
/*      */       else
/* 1560 */         this.appntName = null;
/*      */     }
/* 1562 */     if (FCode.equalsIgnoreCase("appntSex"))
/*      */     {
/* 1564 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1566 */         this.appntSex = FValue.trim();
/*      */       }
/*      */       else
/* 1569 */         this.appntSex = null;
/*      */     }
/* 1571 */     if (FCode.equalsIgnoreCase("appntBirthday"))
/*      */     {
/* 1573 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1575 */         this.appntBirthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1578 */         this.appntBirthday = null;
/*      */     }
/* 1580 */     if (FCode.equalsIgnoreCase("appntAge"))
/*      */     {
/* 1582 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1584 */         Integer tInteger = new Integer(FValue);
/* 1585 */         int i = tInteger.intValue();
/* 1586 */         this.appntAge = i;
/*      */       }
/*      */     }
/* 1589 */     if (FCode.equalsIgnoreCase("appntAgeType"))
/*      */     {
/* 1591 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1593 */         this.appntAgeType = FValue.trim();
/*      */       }
/*      */       else
/* 1596 */         this.appntAgeType = null;
/*      */     }
/* 1598 */     if (FCode.equalsIgnoreCase("appntType"))
/*      */     {
/* 1600 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1602 */         this.appntType = FValue.trim();
/*      */       }
/*      */       else
/* 1605 */         this.appntType = null;
/*      */     }
/* 1607 */     if (FCode.equalsIgnoreCase("addressNo"))
/*      */     {
/* 1609 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1611 */         this.addressNo = FValue.trim();
/*      */       }
/*      */       else
/* 1614 */         this.addressNo = null;
/*      */     }
/* 1616 */     if (FCode.equalsIgnoreCase("sequenceNo"))
/*      */     {
/* 1618 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1620 */         this.sequenceNo = FValue.trim();
/*      */       }
/*      */       else
/* 1623 */         this.sequenceNo = null;
/*      */     }
/* 1625 */     if (FCode.equalsIgnoreCase("iDType"))
/*      */     {
/* 1627 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1629 */         this.iDType = FValue.trim();
/*      */       }
/*      */       else
/* 1632 */         this.iDType = null;
/*      */     }
/* 1634 */     if (FCode.equalsIgnoreCase("iDNo"))
/*      */     {
/* 1636 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1638 */         this.iDNo = FValue.trim();
/*      */       }
/*      */       else
/* 1641 */         this.iDNo = null;
/*      */     }
/* 1643 */     if (FCode.equalsIgnoreCase("iDValidity"))
/*      */     {
/* 1645 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1647 */         this.iDValidity = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1650 */         this.iDValidity = null;
/*      */     }
/* 1652 */     if (FCode.equalsIgnoreCase("iDPerpetual"))
/*      */     {
/* 1654 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1656 */         this.iDPerpetual = FValue.trim();
/*      */       }
/*      */       else
/* 1659 */         this.iDPerpetual = null;
/*      */     }
/* 1661 */     if (FCode.equalsIgnoreCase("nativePlace"))
/*      */     {
/* 1663 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1665 */         this.nativePlace = FValue.trim();
/*      */       }
/*      */       else
/* 1668 */         this.nativePlace = null;
/*      */     }
/* 1670 */     if (FCode.equalsIgnoreCase("nationality"))
/*      */     {
/* 1672 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1674 */         this.nationality = FValue.trim();
/*      */       }
/*      */       else
/* 1677 */         this.nationality = null;
/*      */     }
/* 1679 */     if (FCode.equalsIgnoreCase("rgtAddress"))
/*      */     {
/* 1681 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1683 */         this.rgtAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1686 */         this.rgtAddress = null;
/*      */     }
/* 1688 */     if (FCode.equalsIgnoreCase("marriage"))
/*      */     {
/* 1690 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1692 */         this.marriage = FValue.trim();
/*      */       }
/*      */       else
/* 1695 */         this.marriage = null;
/*      */     }
/* 1697 */     if (FCode.equalsIgnoreCase("marriageDate"))
/*      */     {
/* 1699 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1701 */         this.marriageDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1704 */         this.marriageDate = null;
/*      */     }
/* 1706 */     if (FCode.equalsIgnoreCase("health"))
/*      */     {
/* 1708 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1710 */         this.health = FValue.trim();
/*      */       }
/*      */       else
/* 1713 */         this.health = null;
/*      */     }
/* 1715 */     if (FCode.equalsIgnoreCase("stature"))
/*      */     {
/* 1717 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1719 */         Double tDouble = new Double(FValue);
/* 1720 */         double d = tDouble.doubleValue();
/* 1721 */         this.stature = d;
/*      */       }
/*      */     }
/* 1724 */     if (FCode.equalsIgnoreCase("avoirdupois"))
/*      */     {
/* 1726 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1728 */         Double tDouble = new Double(FValue);
/* 1729 */         double d = tDouble.doubleValue();
/* 1730 */         this.avoirdupois = d;
/*      */       }
/*      */     }
/* 1733 */     if (FCode.equalsIgnoreCase("degree"))
/*      */     {
/* 1735 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1737 */         this.degree = FValue.trim();
/*      */       }
/*      */       else
/* 1740 */         this.degree = null;
/*      */     }
/* 1742 */     if (FCode.equalsIgnoreCase("creditGrade"))
/*      */     {
/* 1744 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1746 */         this.creditGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1749 */         this.creditGrade = null;
/*      */     }
/* 1751 */     if (FCode.equalsIgnoreCase("bankCode"))
/*      */     {
/* 1753 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1755 */         this.bankCode = FValue.trim();
/*      */       }
/*      */       else
/* 1758 */         this.bankCode = null;
/*      */     }
/* 1760 */     if (FCode.equalsIgnoreCase("bankAccNo"))
/*      */     {
/* 1762 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1764 */         this.bankAccNo = FValue.trim();
/*      */       }
/*      */       else
/* 1767 */         this.bankAccNo = null;
/*      */     }
/* 1769 */     if (FCode.equalsIgnoreCase("accName"))
/*      */     {
/* 1771 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1773 */         this.accName = FValue.trim();
/*      */       }
/*      */       else
/* 1776 */         this.accName = null;
/*      */     }
/* 1778 */     if (FCode.equalsIgnoreCase("joinCompanyDate"))
/*      */     {
/* 1780 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1782 */         this.joinCompanyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1785 */         this.joinCompanyDate = null;
/*      */     }
/* 1787 */     if (FCode.equalsIgnoreCase("startWorkDate"))
/*      */     {
/* 1789 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1791 */         this.startWorkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1794 */         this.startWorkDate = null;
/*      */     }
/* 1796 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/* 1798 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1800 */         this.position = FValue.trim();
/*      */       }
/*      */       else
/* 1803 */         this.position = null;
/*      */     }
/* 1805 */     if (FCode.equalsIgnoreCase("salary"))
/*      */     {
/* 1807 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1809 */         Double tDouble = new Double(FValue);
/* 1810 */         double d = tDouble.doubleValue();
/* 1811 */         this.salary = d;
/*      */       }
/*      */     }
/* 1814 */     if (FCode.equalsIgnoreCase("occupationType"))
/*      */     {
/* 1816 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1818 */         this.occupationType = FValue.trim();
/*      */       }
/*      */       else
/* 1821 */         this.occupationType = null;
/*      */     }
/* 1823 */     if (FCode.equalsIgnoreCase("occupationCode"))
/*      */     {
/* 1825 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1827 */         this.occupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 1830 */         this.occupationCode = null;
/*      */     }
/* 1832 */     if (FCode.equalsIgnoreCase("workType"))
/*      */     {
/* 1834 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1836 */         this.workType = FValue.trim();
/*      */       }
/*      */       else
/* 1839 */         this.workType = null;
/*      */     }
/* 1841 */     if (FCode.equalsIgnoreCase("pluralityType"))
/*      */     {
/* 1843 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1845 */         this.pluralityType = FValue.trim();
/*      */       }
/*      */       else
/* 1848 */         this.pluralityType = null;
/*      */     }
/* 1850 */     if (FCode.equalsIgnoreCase("smokeFlag"))
/*      */     {
/* 1852 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1854 */         this.smokeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1857 */         this.smokeFlag = null;
/*      */     }
/* 1859 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1861 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1863 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1866 */         this.operator = null;
/*      */     }
/* 1868 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1870 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1872 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1875 */         this.manageCom = null;
/*      */     }
/* 1877 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1879 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1881 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1884 */         this.makeDate = null;
/*      */     }
/* 1886 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1888 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1890 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1893 */         this.makeTime = null;
/*      */     }
/* 1895 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1897 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1899 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1902 */         this.modifyDate = null;
/*      */     }
/* 1904 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1906 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1908 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1911 */         this.modifyTime = null;
/*      */     }
/* 1913 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1918 */     if (otherObject == null) return false;
/* 1919 */     if (this == otherObject) return true;
/* 1920 */     if (getClass() != otherObject.getClass()) return false;
/* 1921 */     LNPAppntSchema other = (LNPAppntSchema)otherObject;
/* 1922 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/* 1923 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/* 1924 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/* 1925 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/* 1926 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/* 1927 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/* 1928 */     if ((this.prtNo == null) && (other.getPrtNo() != null)) return false;
/* 1929 */     if ((this.prtNo != null) && (!this.prtNo.equals(other.getPrtNo()))) return false;
/* 1930 */     if ((this.appntNo == null) && (other.getAppntNo() != null)) return false;
/* 1931 */     if ((this.appntNo != null) && (!this.appntNo.equals(other.getAppntNo()))) return false;
/* 1932 */     if ((this.appntId == null) && (other.getAppntId() != null)) return false;
/* 1933 */     if ((this.appntId != null) && (!this.appntId.equals(other.getAppntId()))) return false;
/* 1934 */     if ((this.relationToInsured == null) && (other.getRelationToInsured() != null)) return false;
/* 1935 */     if ((this.relationToInsured != null) && (!this.relationToInsured.equals(other.getRelationToInsured()))) return false;
/* 1936 */     if ((this.appntGrade == null) && (other.getAppntGrade() != null)) return false;
/* 1937 */     if ((this.appntGrade != null) && (!this.appntGrade.equals(other.getAppntGrade()))) return false;
/* 1938 */     if ((this.appellation == null) && (other.getAppellation() != null)) return false;
/* 1939 */     if ((this.appellation != null) && (!this.appellation.equals(other.getAppellation()))) return false;
/* 1940 */     if ((this.appntName == null) && (other.getAppntName() != null)) return false;
/* 1941 */     if ((this.appntName != null) && (!this.appntName.equals(other.getAppntName()))) return false;
/* 1942 */     if ((this.appntSex == null) && (other.getAppntSex() != null)) return false;
/* 1943 */     if ((this.appntSex != null) && (!this.appntSex.equals(other.getAppntSex()))) return false;
/* 1944 */     if ((this.appntBirthday == null) && (other.getAppntBirthday() != null)) return false;
/* 1945 */     if ((this.appntBirthday != null) && (!this.fDate.getString(this.appntBirthday).equals(other.getAppntBirthday()))) return false;
/* 1946 */     if (this.appntAge != other.getAppntAge()) return false;
/* 1947 */     if ((this.appntAgeType == null) && (other.getAppntAgeType() != null)) return false;
/* 1948 */     if ((this.appntAgeType != null) && (!this.appntAgeType.equals(other.getAppntAgeType()))) return false;
/* 1949 */     if ((this.appntType == null) && (other.getAppntType() != null)) return false;
/* 1950 */     if ((this.appntType != null) && (!this.appntType.equals(other.getAppntType()))) return false;
/* 1951 */     if ((this.addressNo == null) && (other.getAddressNo() != null)) return false;
/* 1952 */     if ((this.addressNo != null) && (!this.addressNo.equals(other.getAddressNo()))) return false;
/* 1953 */     if ((this.sequenceNo == null) && (other.getSequenceNo() != null)) return false;
/* 1954 */     if ((this.sequenceNo != null) && (!this.sequenceNo.equals(other.getSequenceNo()))) return false;
/* 1955 */     if ((this.iDType == null) && (other.getIDType() != null)) return false;
/* 1956 */     if ((this.iDType != null) && (!this.iDType.equals(other.getIDType()))) return false;
/* 1957 */     if ((this.iDNo == null) && (other.getIDNo() != null)) return false;
/* 1958 */     if ((this.iDNo != null) && (!this.iDNo.equals(other.getIDNo()))) return false;
/* 1959 */     if ((this.iDValidity == null) && (other.getIDValidity() != null)) return false;
/* 1960 */     if ((this.iDValidity != null) && (!this.fDate.getString(this.iDValidity).equals(other.getIDValidity()))) return false;
/* 1961 */     if ((this.iDPerpetual == null) && (other.getIDPerpetual() != null)) return false;
/* 1962 */     if ((this.iDPerpetual != null) && (!this.iDPerpetual.equals(other.getIDPerpetual()))) return false;
/* 1963 */     if ((this.nativePlace == null) && (other.getNativePlace() != null)) return false;
/* 1964 */     if ((this.nativePlace != null) && (!this.nativePlace.equals(other.getNativePlace()))) return false;
/* 1965 */     if ((this.nationality == null) && (other.getNationality() != null)) return false;
/* 1966 */     if ((this.nationality != null) && (!this.nationality.equals(other.getNationality()))) return false;
/* 1967 */     if ((this.rgtAddress == null) && (other.getRgtAddress() != null)) return false;
/* 1968 */     if ((this.rgtAddress != null) && (!this.rgtAddress.equals(other.getRgtAddress()))) return false;
/* 1969 */     if ((this.marriage == null) && (other.getMarriage() != null)) return false;
/* 1970 */     if ((this.marriage != null) && (!this.marriage.equals(other.getMarriage()))) return false;
/* 1971 */     if ((this.marriageDate == null) && (other.getMarriageDate() != null)) return false;
/* 1972 */     if ((this.marriageDate != null) && (!this.fDate.getString(this.marriageDate).equals(other.getMarriageDate()))) return false;
/* 1973 */     if ((this.health == null) && (other.getHealth() != null)) return false;
/* 1974 */     if ((this.health != null) && (!this.health.equals(other.getHealth()))) return false;
/* 1975 */     if (Double.doubleToLongBits(this.stature) != Double.doubleToLongBits(other.getStature())) return false;
/* 1976 */     if (Double.doubleToLongBits(this.avoirdupois) != Double.doubleToLongBits(other.getAvoirdupois())) return false;
/* 1977 */     if ((this.degree == null) && (other.getDegree() != null)) return false;
/* 1978 */     if ((this.degree != null) && (!this.degree.equals(other.getDegree()))) return false;
/* 1979 */     if ((this.creditGrade == null) && (other.getCreditGrade() != null)) return false;
/* 1980 */     if ((this.creditGrade != null) && (!this.creditGrade.equals(other.getCreditGrade()))) return false;
/* 1981 */     if ((this.bankCode == null) && (other.getBankCode() != null)) return false;
/* 1982 */     if ((this.bankCode != null) && (!this.bankCode.equals(other.getBankCode()))) return false;
/* 1983 */     if ((this.bankAccNo == null) && (other.getBankAccNo() != null)) return false;
/* 1984 */     if ((this.bankAccNo != null) && (!this.bankAccNo.equals(other.getBankAccNo()))) return false;
/* 1985 */     if ((this.accName == null) && (other.getAccName() != null)) return false;
/* 1986 */     if ((this.accName != null) && (!this.accName.equals(other.getAccName()))) return false;
/* 1987 */     if ((this.joinCompanyDate == null) && (other.getJoinCompanyDate() != null)) return false;
/* 1988 */     if ((this.joinCompanyDate != null) && (!this.fDate.getString(this.joinCompanyDate).equals(other.getJoinCompanyDate()))) return false;
/* 1989 */     if ((this.startWorkDate == null) && (other.getStartWorkDate() != null)) return false;
/* 1990 */     if ((this.startWorkDate != null) && (!this.fDate.getString(this.startWorkDate).equals(other.getStartWorkDate()))) return false;
/* 1991 */     if ((this.position == null) && (other.getPosition() != null)) return false;
/* 1992 */     if ((this.position != null) && (!this.position.equals(other.getPosition()))) return false;
/* 1993 */     if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.getSalary())) return false;
/* 1994 */     if ((this.occupationType == null) && (other.getOccupationType() != null)) return false;
/* 1995 */     if ((this.occupationType != null) && (!this.occupationType.equals(other.getOccupationType()))) return false;
/* 1996 */     if ((this.occupationCode == null) && (other.getOccupationCode() != null)) return false;
/* 1997 */     if ((this.occupationCode != null) && (!this.occupationCode.equals(other.getOccupationCode()))) return false;
/* 1998 */     if ((this.workType == null) && (other.getWorkType() != null)) return false;
/* 1999 */     if ((this.workType != null) && (!this.workType.equals(other.getWorkType()))) return false;
/* 2000 */     if ((this.pluralityType == null) && (other.getPluralityType() != null)) return false;
/* 2001 */     if ((this.pluralityType != null) && (!this.pluralityType.equals(other.getPluralityType()))) return false;
/* 2002 */     if ((this.smokeFlag == null) && (other.getSmokeFlag() != null)) return false;
/* 2003 */     if ((this.smokeFlag != null) && (!this.smokeFlag.equals(other.getSmokeFlag()))) return false;
/* 2004 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 2005 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 2006 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 2007 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 2008 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 2009 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 2010 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 2011 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 2012 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 2013 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 2014 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 2015 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2022 */     return 49;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2028 */     if (strFieldName.equals("grpContNo")) {
/* 2029 */       return 0;
/*      */     }
/* 2031 */     if (strFieldName.equals("contNo")) {
/* 2032 */       return 1;
/*      */     }
/* 2034 */     if (strFieldName.equals("proposalContNo")) {
/* 2035 */       return 2;
/*      */     }
/* 2037 */     if (strFieldName.equals("prtNo")) {
/* 2038 */       return 3;
/*      */     }
/* 2040 */     if (strFieldName.equals("appntNo")) {
/* 2041 */       return 4;
/*      */     }
/* 2043 */     if (strFieldName.equals("appntId")) {
/* 2044 */       return 5;
/*      */     }
/* 2046 */     if (strFieldName.equals("relationToInsured")) {
/* 2047 */       return 6;
/*      */     }
/* 2049 */     if (strFieldName.equals("appntGrade")) {
/* 2050 */       return 7;
/*      */     }
/* 2052 */     if (strFieldName.equals("appellation")) {
/* 2053 */       return 8;
/*      */     }
/* 2055 */     if (strFieldName.equals("appntName")) {
/* 2056 */       return 9;
/*      */     }
/* 2058 */     if (strFieldName.equals("appntSex")) {
/* 2059 */       return 10;
/*      */     }
/* 2061 */     if (strFieldName.equals("appntBirthday")) {
/* 2062 */       return 11;
/*      */     }
/* 2064 */     if (strFieldName.equals("appntAge")) {
/* 2065 */       return 12;
/*      */     }
/* 2067 */     if (strFieldName.equals("appntAgeType")) {
/* 2068 */       return 13;
/*      */     }
/* 2070 */     if (strFieldName.equals("appntType")) {
/* 2071 */       return 14;
/*      */     }
/* 2073 */     if (strFieldName.equals("addressNo")) {
/* 2074 */       return 15;
/*      */     }
/* 2076 */     if (strFieldName.equals("sequenceNo")) {
/* 2077 */       return 16;
/*      */     }
/* 2079 */     if (strFieldName.equals("iDType")) {
/* 2080 */       return 17;
/*      */     }
/* 2082 */     if (strFieldName.equals("iDNo")) {
/* 2083 */       return 18;
/*      */     }
/* 2085 */     if (strFieldName.equals("iDValidity")) {
/* 2086 */       return 19;
/*      */     }
/* 2088 */     if (strFieldName.equals("iDPerpetual")) {
/* 2089 */       return 20;
/*      */     }
/* 2091 */     if (strFieldName.equals("nativePlace")) {
/* 2092 */       return 21;
/*      */     }
/* 2094 */     if (strFieldName.equals("nationality")) {
/* 2095 */       return 22;
/*      */     }
/* 2097 */     if (strFieldName.equals("rgtAddress")) {
/* 2098 */       return 23;
/*      */     }
/* 2100 */     if (strFieldName.equals("marriage")) {
/* 2101 */       return 24;
/*      */     }
/* 2103 */     if (strFieldName.equals("marriageDate")) {
/* 2104 */       return 25;
/*      */     }
/* 2106 */     if (strFieldName.equals("health")) {
/* 2107 */       return 26;
/*      */     }
/* 2109 */     if (strFieldName.equals("stature")) {
/* 2110 */       return 27;
/*      */     }
/* 2112 */     if (strFieldName.equals("avoirdupois")) {
/* 2113 */       return 28;
/*      */     }
/* 2115 */     if (strFieldName.equals("degree")) {
/* 2116 */       return 29;
/*      */     }
/* 2118 */     if (strFieldName.equals("creditGrade")) {
/* 2119 */       return 30;
/*      */     }
/* 2121 */     if (strFieldName.equals("bankCode")) {
/* 2122 */       return 31;
/*      */     }
/* 2124 */     if (strFieldName.equals("bankAccNo")) {
/* 2125 */       return 32;
/*      */     }
/* 2127 */     if (strFieldName.equals("accName")) {
/* 2128 */       return 33;
/*      */     }
/* 2130 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2131 */       return 34;
/*      */     }
/* 2133 */     if (strFieldName.equals("startWorkDate")) {
/* 2134 */       return 35;
/*      */     }
/* 2136 */     if (strFieldName.equals("position")) {
/* 2137 */       return 36;
/*      */     }
/* 2139 */     if (strFieldName.equals("salary")) {
/* 2140 */       return 37;
/*      */     }
/* 2142 */     if (strFieldName.equals("occupationType")) {
/* 2143 */       return 38;
/*      */     }
/* 2145 */     if (strFieldName.equals("occupationCode")) {
/* 2146 */       return 39;
/*      */     }
/* 2148 */     if (strFieldName.equals("workType")) {
/* 2149 */       return 40;
/*      */     }
/* 2151 */     if (strFieldName.equals("pluralityType")) {
/* 2152 */       return 41;
/*      */     }
/* 2154 */     if (strFieldName.equals("smokeFlag")) {
/* 2155 */       return 42;
/*      */     }
/* 2157 */     if (strFieldName.equals("operator")) {
/* 2158 */       return 43;
/*      */     }
/* 2160 */     if (strFieldName.equals("manageCom")) {
/* 2161 */       return 44;
/*      */     }
/* 2163 */     if (strFieldName.equals("makeDate")) {
/* 2164 */       return 45;
/*      */     }
/* 2166 */     if (strFieldName.equals("makeTime")) {
/* 2167 */       return 46;
/*      */     }
/* 2169 */     if (strFieldName.equals("modifyDate")) {
/* 2170 */       return 47;
/*      */     }
/* 2172 */     if (strFieldName.equals("modifyTime")) {
/* 2173 */       return 48;
/*      */     }
/* 2175 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2181 */     String strFieldName = "";
/* 2182 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2184 */       strFieldName = "grpContNo";
/* 2185 */       break;
/*      */     case 1:
/* 2187 */       strFieldName = "contNo";
/* 2188 */       break;
/*      */     case 2:
/* 2190 */       strFieldName = "proposalContNo";
/* 2191 */       break;
/*      */     case 3:
/* 2193 */       strFieldName = "prtNo";
/* 2194 */       break;
/*      */     case 4:
/* 2196 */       strFieldName = "appntNo";
/* 2197 */       break;
/*      */     case 5:
/* 2199 */       strFieldName = "appntId";
/* 2200 */       break;
/*      */     case 6:
/* 2202 */       strFieldName = "relationToInsured";
/* 2203 */       break;
/*      */     case 7:
/* 2205 */       strFieldName = "appntGrade";
/* 2206 */       break;
/*      */     case 8:
/* 2208 */       strFieldName = "appellation";
/* 2209 */       break;
/*      */     case 9:
/* 2211 */       strFieldName = "appntName";
/* 2212 */       break;
/*      */     case 10:
/* 2214 */       strFieldName = "appntSex";
/* 2215 */       break;
/*      */     case 11:
/* 2217 */       strFieldName = "appntBirthday";
/* 2218 */       break;
/*      */     case 12:
/* 2220 */       strFieldName = "appntAge";
/* 2221 */       break;
/*      */     case 13:
/* 2223 */       strFieldName = "appntAgeType";
/* 2224 */       break;
/*      */     case 14:
/* 2226 */       strFieldName = "appntType";
/* 2227 */       break;
/*      */     case 15:
/* 2229 */       strFieldName = "addressNo";
/* 2230 */       break;
/*      */     case 16:
/* 2232 */       strFieldName = "sequenceNo";
/* 2233 */       break;
/*      */     case 17:
/* 2235 */       strFieldName = "iDType";
/* 2236 */       break;
/*      */     case 18:
/* 2238 */       strFieldName = "iDNo";
/* 2239 */       break;
/*      */     case 19:
/* 2241 */       strFieldName = "iDValidity";
/* 2242 */       break;
/*      */     case 20:
/* 2244 */       strFieldName = "iDPerpetual";
/* 2245 */       break;
/*      */     case 21:
/* 2247 */       strFieldName = "nativePlace";
/* 2248 */       break;
/*      */     case 22:
/* 2250 */       strFieldName = "nationality";
/* 2251 */       break;
/*      */     case 23:
/* 2253 */       strFieldName = "rgtAddress";
/* 2254 */       break;
/*      */     case 24:
/* 2256 */       strFieldName = "marriage";
/* 2257 */       break;
/*      */     case 25:
/* 2259 */       strFieldName = "marriageDate";
/* 2260 */       break;
/*      */     case 26:
/* 2262 */       strFieldName = "health";
/* 2263 */       break;
/*      */     case 27:
/* 2265 */       strFieldName = "stature";
/* 2266 */       break;
/*      */     case 28:
/* 2268 */       strFieldName = "avoirdupois";
/* 2269 */       break;
/*      */     case 29:
/* 2271 */       strFieldName = "degree";
/* 2272 */       break;
/*      */     case 30:
/* 2274 */       strFieldName = "creditGrade";
/* 2275 */       break;
/*      */     case 31:
/* 2277 */       strFieldName = "bankCode";
/* 2278 */       break;
/*      */     case 32:
/* 2280 */       strFieldName = "bankAccNo";
/* 2281 */       break;
/*      */     case 33:
/* 2283 */       strFieldName = "accName";
/* 2284 */       break;
/*      */     case 34:
/* 2286 */       strFieldName = "joinCompanyDate";
/* 2287 */       break;
/*      */     case 35:
/* 2289 */       strFieldName = "startWorkDate";
/* 2290 */       break;
/*      */     case 36:
/* 2292 */       strFieldName = "position";
/* 2293 */       break;
/*      */     case 37:
/* 2295 */       strFieldName = "salary";
/* 2296 */       break;
/*      */     case 38:
/* 2298 */       strFieldName = "occupationType";
/* 2299 */       break;
/*      */     case 39:
/* 2301 */       strFieldName = "occupationCode";
/* 2302 */       break;
/*      */     case 40:
/* 2304 */       strFieldName = "workType";
/* 2305 */       break;
/*      */     case 41:
/* 2307 */       strFieldName = "pluralityType";
/* 2308 */       break;
/*      */     case 42:
/* 2310 */       strFieldName = "smokeFlag";
/* 2311 */       break;
/*      */     case 43:
/* 2313 */       strFieldName = "operator";
/* 2314 */       break;
/*      */     case 44:
/* 2316 */       strFieldName = "manageCom";
/* 2317 */       break;
/*      */     case 45:
/* 2319 */       strFieldName = "makeDate";
/* 2320 */       break;
/*      */     case 46:
/* 2322 */       strFieldName = "makeTime";
/* 2323 */       break;
/*      */     case 47:
/* 2325 */       strFieldName = "modifyDate";
/* 2326 */       break;
/*      */     case 48:
/* 2328 */       strFieldName = "modifyTime";
/* 2329 */       break;
/*      */     default:
/* 2331 */       strFieldName = "";
/*      */     }
/* 2333 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2339 */     if (strFieldName.equals("grpContNo")) {
/* 2340 */       return 0;
/*      */     }
/* 2342 */     if (strFieldName.equals("contNo")) {
/* 2343 */       return 0;
/*      */     }
/* 2345 */     if (strFieldName.equals("proposalContNo")) {
/* 2346 */       return 0;
/*      */     }
/* 2348 */     if (strFieldName.equals("prtNo")) {
/* 2349 */       return 0;
/*      */     }
/* 2351 */     if (strFieldName.equals("appntNo")) {
/* 2352 */       return 0;
/*      */     }
/* 2354 */     if (strFieldName.equals("appntId")) {
/* 2355 */       return 0;
/*      */     }
/* 2357 */     if (strFieldName.equals("relationToInsured")) {
/* 2358 */       return 0;
/*      */     }
/* 2360 */     if (strFieldName.equals("appntGrade")) {
/* 2361 */       return 0;
/*      */     }
/* 2363 */     if (strFieldName.equals("appellation")) {
/* 2364 */       return 0;
/*      */     }
/* 2366 */     if (strFieldName.equals("appntName")) {
/* 2367 */       return 0;
/*      */     }
/* 2369 */     if (strFieldName.equals("appntSex")) {
/* 2370 */       return 0;
/*      */     }
/* 2372 */     if (strFieldName.equals("appntBirthday")) {
/* 2373 */       return 1;
/*      */     }
/* 2375 */     if (strFieldName.equals("appntAge")) {
/* 2376 */       return 3;
/*      */     }
/* 2378 */     if (strFieldName.equals("appntAgeType")) {
/* 2379 */       return 0;
/*      */     }
/* 2381 */     if (strFieldName.equals("appntType")) {
/* 2382 */       return 0;
/*      */     }
/* 2384 */     if (strFieldName.equals("addressNo")) {
/* 2385 */       return 0;
/*      */     }
/* 2387 */     if (strFieldName.equals("sequenceNo")) {
/* 2388 */       return 0;
/*      */     }
/* 2390 */     if (strFieldName.equals("iDType")) {
/* 2391 */       return 0;
/*      */     }
/* 2393 */     if (strFieldName.equals("iDNo")) {
/* 2394 */       return 0;
/*      */     }
/* 2396 */     if (strFieldName.equals("iDValidity")) {
/* 2397 */       return 1;
/*      */     }
/* 2399 */     if (strFieldName.equals("iDPerpetual")) {
/* 2400 */       return 0;
/*      */     }
/* 2402 */     if (strFieldName.equals("nativePlace")) {
/* 2403 */       return 0;
/*      */     }
/* 2405 */     if (strFieldName.equals("nationality")) {
/* 2406 */       return 0;
/*      */     }
/* 2408 */     if (strFieldName.equals("rgtAddress")) {
/* 2409 */       return 0;
/*      */     }
/* 2411 */     if (strFieldName.equals("marriage")) {
/* 2412 */       return 0;
/*      */     }
/* 2414 */     if (strFieldName.equals("marriageDate")) {
/* 2415 */       return 1;
/*      */     }
/* 2417 */     if (strFieldName.equals("health")) {
/* 2418 */       return 0;
/*      */     }
/* 2420 */     if (strFieldName.equals("stature")) {
/* 2421 */       return 4;
/*      */     }
/* 2423 */     if (strFieldName.equals("avoirdupois")) {
/* 2424 */       return 4;
/*      */     }
/* 2426 */     if (strFieldName.equals("degree")) {
/* 2427 */       return 0;
/*      */     }
/* 2429 */     if (strFieldName.equals("creditGrade")) {
/* 2430 */       return 0;
/*      */     }
/* 2432 */     if (strFieldName.equals("bankCode")) {
/* 2433 */       return 0;
/*      */     }
/* 2435 */     if (strFieldName.equals("bankAccNo")) {
/* 2436 */       return 0;
/*      */     }
/* 2438 */     if (strFieldName.equals("accName")) {
/* 2439 */       return 0;
/*      */     }
/* 2441 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2442 */       return 1;
/*      */     }
/* 2444 */     if (strFieldName.equals("startWorkDate")) {
/* 2445 */       return 1;
/*      */     }
/* 2447 */     if (strFieldName.equals("position")) {
/* 2448 */       return 0;
/*      */     }
/* 2450 */     if (strFieldName.equals("salary")) {
/* 2451 */       return 4;
/*      */     }
/* 2453 */     if (strFieldName.equals("occupationType")) {
/* 2454 */       return 0;
/*      */     }
/* 2456 */     if (strFieldName.equals("occupationCode")) {
/* 2457 */       return 0;
/*      */     }
/* 2459 */     if (strFieldName.equals("workType")) {
/* 2460 */       return 0;
/*      */     }
/* 2462 */     if (strFieldName.equals("pluralityType")) {
/* 2463 */       return 0;
/*      */     }
/* 2465 */     if (strFieldName.equals("smokeFlag")) {
/* 2466 */       return 0;
/*      */     }
/* 2468 */     if (strFieldName.equals("operator")) {
/* 2469 */       return 0;
/*      */     }
/* 2471 */     if (strFieldName.equals("manageCom")) {
/* 2472 */       return 0;
/*      */     }
/* 2474 */     if (strFieldName.equals("makeDate")) {
/* 2475 */       return 1;
/*      */     }
/* 2477 */     if (strFieldName.equals("makeTime")) {
/* 2478 */       return 0;
/*      */     }
/* 2480 */     if (strFieldName.equals("modifyDate")) {
/* 2481 */       return 1;
/*      */     }
/* 2483 */     if (strFieldName.equals("modifyTime")) {
/* 2484 */       return 0;
/*      */     }
/* 2486 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 2492 */     int nFieldType = -1;
/* 2493 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2495 */       nFieldType = 0;
/* 2496 */       break;
/*      */     case 1:
/* 2498 */       nFieldType = 0;
/* 2499 */       break;
/*      */     case 2:
/* 2501 */       nFieldType = 0;
/* 2502 */       break;
/*      */     case 3:
/* 2504 */       nFieldType = 0;
/* 2505 */       break;
/*      */     case 4:
/* 2507 */       nFieldType = 0;
/* 2508 */       break;
/*      */     case 5:
/* 2510 */       nFieldType = 0;
/* 2511 */       break;
/*      */     case 6:
/* 2513 */       nFieldType = 0;
/* 2514 */       break;
/*      */     case 7:
/* 2516 */       nFieldType = 0;
/* 2517 */       break;
/*      */     case 8:
/* 2519 */       nFieldType = 0;
/* 2520 */       break;
/*      */     case 9:
/* 2522 */       nFieldType = 0;
/* 2523 */       break;
/*      */     case 10:
/* 2525 */       nFieldType = 0;
/* 2526 */       break;
/*      */     case 11:
/* 2528 */       nFieldType = 1;
/* 2529 */       break;
/*      */     case 12:
/* 2531 */       nFieldType = 3;
/* 2532 */       break;
/*      */     case 13:
/* 2534 */       nFieldType = 0;
/* 2535 */       break;
/*      */     case 14:
/* 2537 */       nFieldType = 0;
/* 2538 */       break;
/*      */     case 15:
/* 2540 */       nFieldType = 0;
/* 2541 */       break;
/*      */     case 16:
/* 2543 */       nFieldType = 0;
/* 2544 */       break;
/*      */     case 17:
/* 2546 */       nFieldType = 0;
/* 2547 */       break;
/*      */     case 18:
/* 2549 */       nFieldType = 0;
/* 2550 */       break;
/*      */     case 19:
/* 2552 */       nFieldType = 1;
/* 2553 */       break;
/*      */     case 20:
/* 2555 */       nFieldType = 0;
/* 2556 */       break;
/*      */     case 21:
/* 2558 */       nFieldType = 0;
/* 2559 */       break;
/*      */     case 22:
/* 2561 */       nFieldType = 0;
/* 2562 */       break;
/*      */     case 23:
/* 2564 */       nFieldType = 0;
/* 2565 */       break;
/*      */     case 24:
/* 2567 */       nFieldType = 0;
/* 2568 */       break;
/*      */     case 25:
/* 2570 */       nFieldType = 1;
/* 2571 */       break;
/*      */     case 26:
/* 2573 */       nFieldType = 0;
/* 2574 */       break;
/*      */     case 27:
/* 2576 */       nFieldType = 4;
/* 2577 */       break;
/*      */     case 28:
/* 2579 */       nFieldType = 4;
/* 2580 */       break;
/*      */     case 29:
/* 2582 */       nFieldType = 0;
/* 2583 */       break;
/*      */     case 30:
/* 2585 */       nFieldType = 0;
/* 2586 */       break;
/*      */     case 31:
/* 2588 */       nFieldType = 0;
/* 2589 */       break;
/*      */     case 32:
/* 2591 */       nFieldType = 0;
/* 2592 */       break;
/*      */     case 33:
/* 2594 */       nFieldType = 0;
/* 2595 */       break;
/*      */     case 34:
/* 2597 */       nFieldType = 1;
/* 2598 */       break;
/*      */     case 35:
/* 2600 */       nFieldType = 1;
/* 2601 */       break;
/*      */     case 36:
/* 2603 */       nFieldType = 0;
/* 2604 */       break;
/*      */     case 37:
/* 2606 */       nFieldType = 4;
/* 2607 */       break;
/*      */     case 38:
/* 2609 */       nFieldType = 0;
/* 2610 */       break;
/*      */     case 39:
/* 2612 */       nFieldType = 0;
/* 2613 */       break;
/*      */     case 40:
/* 2615 */       nFieldType = 0;
/* 2616 */       break;
/*      */     case 41:
/* 2618 */       nFieldType = 0;
/* 2619 */       break;
/*      */     case 42:
/* 2621 */       nFieldType = 0;
/* 2622 */       break;
/*      */     case 43:
/* 2624 */       nFieldType = 0;
/* 2625 */       break;
/*      */     case 44:
/* 2627 */       nFieldType = 0;
/* 2628 */       break;
/*      */     case 45:
/* 2630 */       nFieldType = 1;
/* 2631 */       break;
/*      */     case 46:
/* 2633 */       nFieldType = 0;
/* 2634 */       break;
/*      */     case 47:
/* 2636 */       nFieldType = 1;
/* 2637 */       break;
/*      */     case 48:
/* 2639 */       nFieldType = 0;
/* 2640 */       break;
/*      */     default:
/* 2642 */       nFieldType = -1;
/*      */     }
/* 2644 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPAppntSchema
 * JD-Core Version:    0.6.0
 */