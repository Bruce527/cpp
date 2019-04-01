/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPInsuredBDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPInsuredBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
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
/*      */   private String appAgetype;
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
/*      */   public static final int FIELDNUM = 59;
/*      */   private static String[] PK;
/*  143 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPInsuredBSchema()
/*      */   {
/*  150 */     this.mErrors = new CErrors();
/*      */ 
/*  152 */     String[] pk = new String[2];
/*  153 */     pk[0] = "EdorNo";
/*  154 */     pk[1] = "serialNo";
/*      */ 
/*  156 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  162 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  167 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*  171 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  175 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*  179 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  183 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  187 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getgrpContNo() {
/*  191 */     if (this.grpContNo != null) this.grpContNo.equals("");
/*      */ 
/*  195 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setgrpContNo(String agrpContNo) {
/*  199 */     this.grpContNo = agrpContNo;
/*      */   }
/*      */ 
/*      */   public String getcontNo() {
/*  203 */     if (this.contNo != null) this.contNo.equals("");
/*      */ 
/*  207 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setcontNo(String acontNo) {
/*  211 */     this.contNo = acontNo;
/*      */   }
/*      */ 
/*      */   public String getproposalContNo() {
/*  215 */     if (this.proposalContNo != null) this.proposalContNo.equals("");
/*      */ 
/*  219 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setproposalContNo(String aproposalContNo) {
/*  223 */     this.proposalContNo = aproposalContNo;
/*      */   }
/*      */ 
/*      */   public String getinsuredNo() {
/*  227 */     if (this.insuredNo != null) this.insuredNo.equals("");
/*      */ 
/*  231 */     return this.insuredNo;
/*      */   }
/*      */ 
/*      */   public void setinsuredNo(String ainsuredNo) {
/*  235 */     this.insuredNo = ainsuredNo;
/*      */   }
/*      */ 
/*      */   public String getinsuredId() {
/*  239 */     if (this.insuredId != null) this.insuredId.equals("");
/*      */ 
/*  243 */     return this.insuredId;
/*      */   }
/*      */ 
/*      */   public void setinsuredId(String ainsuredId) {
/*  247 */     this.insuredId = ainsuredId;
/*      */   }
/*      */ 
/*      */   public String getprtNo() {
/*  251 */     if (this.prtNo != null) this.prtNo.equals("");
/*      */ 
/*  255 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setprtNo(String aprtNo) {
/*  259 */     this.prtNo = aprtNo;
/*      */   }
/*      */ 
/*      */   public String getappntNo() {
/*  263 */     if (this.appntNo != null) this.appntNo.equals("");
/*      */ 
/*  267 */     return this.appntNo;
/*      */   }
/*      */ 
/*      */   public void setappntNo(String aappntNo) {
/*  271 */     this.appntNo = aappntNo;
/*      */   }
/*      */ 
/*      */   public String getappntId() {
/*  275 */     if (this.appntId != null) this.appntId.equals("");
/*      */ 
/*  279 */     return this.appntId;
/*      */   }
/*      */ 
/*      */   public void setappntId(String aappntId) {
/*  283 */     this.appntId = aappntId;
/*      */   }
/*      */ 
/*      */   public String getmanageCom() {
/*  287 */     if (this.manageCom != null) this.manageCom.equals("");
/*      */ 
/*  291 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setmanageCom(String amanageCom) {
/*  295 */     this.manageCom = amanageCom;
/*      */   }
/*      */ 
/*      */   public String getsignCity() {
/*  299 */     if (this.signCity != null) this.signCity.equals("");
/*      */ 
/*  303 */     return this.signCity;
/*      */   }
/*      */ 
/*      */   public void setsignCity(String asignCity) {
/*  307 */     this.signCity = asignCity;
/*      */   }
/*      */ 
/*      */   public String getexecuteCom() {
/*  311 */     if (this.executeCom != null) this.executeCom.equals("");
/*      */ 
/*  315 */     return this.executeCom;
/*      */   }
/*      */ 
/*      */   public void setexecuteCom(String aexecuteCom) {
/*  319 */     this.executeCom = aexecuteCom;
/*      */   }
/*      */ 
/*      */   public String getfamilyID() {
/*  323 */     if (this.familyID != null) this.familyID.equals("");
/*      */ 
/*  327 */     return this.familyID;
/*      */   }
/*      */ 
/*      */   public void setfamilyID(String afamilyID) {
/*  331 */     this.familyID = afamilyID;
/*      */   }
/*      */ 
/*      */   public String getrelationToMainInsured() {
/*  335 */     if (this.relationToMainInsured != null) this.relationToMainInsured.equals("");
/*      */ 
/*  339 */     return this.relationToMainInsured;
/*      */   }
/*      */ 
/*      */   public void setrelationToMainInsured(String arelationToMainInsured) {
/*  343 */     this.relationToMainInsured = arelationToMainInsured;
/*      */   }
/*      */ 
/*      */   public String getrelationToAppnt() {
/*  347 */     if (this.relationToAppnt != null) this.relationToAppnt.equals("");
/*      */ 
/*  351 */     return this.relationToAppnt;
/*      */   }
/*      */ 
/*      */   public void setrelationToAppnt(String arelationToAppnt) {
/*  355 */     this.relationToAppnt = arelationToAppnt;
/*      */   }
/*      */ 
/*      */   public String getaddressNo() {
/*  359 */     if (this.addressNo != null) this.addressNo.equals("");
/*      */ 
/*  363 */     return this.addressNo;
/*      */   }
/*      */ 
/*      */   public void setaddressNo(String aaddressNo) {
/*  367 */     this.addressNo = aaddressNo;
/*      */   }
/*      */ 
/*      */   public String getsequenceNo() {
/*  371 */     if (this.sequenceNo != null) this.sequenceNo.equals("");
/*      */ 
/*  375 */     return this.sequenceNo;
/*      */   }
/*      */ 
/*      */   public void setsequenceNo(String asequenceNo) {
/*  379 */     this.sequenceNo = asequenceNo;
/*      */   }
/*      */ 
/*      */   public String getname() {
/*  383 */     if (this.name != null) this.name.equals("");
/*      */ 
/*  387 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setname(String aname) {
/*  391 */     this.name = aname;
/*      */   }
/*      */ 
/*      */   public String getappellation() {
/*  395 */     if (this.appellation != null) this.appellation.equals("");
/*      */ 
/*  399 */     return this.appellation;
/*      */   }
/*      */ 
/*      */   public void setappellation(String aappellation) {
/*  403 */     this.appellation = aappellation;
/*      */   }
/*      */ 
/*      */   public String getsex() {
/*  407 */     if (this.sex != null) this.sex.equals("");
/*      */ 
/*  411 */     return this.sex;
/*      */   }
/*      */ 
/*      */   public void setsex(String asex) {
/*  415 */     this.sex = asex;
/*      */   }
/*      */ 
/*      */   public String getbirthday() {
/*  419 */     if (this.birthday != null) {
/*  420 */       return this.fDate.getString(this.birthday);
/*      */     }
/*  422 */     return null;
/*      */   }
/*      */ 
/*      */   public void setbirthday(Date abirthday) {
/*  426 */     this.birthday = abirthday;
/*      */   }
/*      */ 
/*      */   public void setbirthday(String abirthday) {
/*  430 */     if ((abirthday != null) && (!abirthday.equals("")))
/*      */     {
/*  432 */       this.birthday = this.fDate.getDate(abirthday);
/*      */     }
/*      */     else
/*  435 */       this.birthday = null;
/*      */   }
/*      */ 
/*      */   public int getappAge()
/*      */   {
/*  440 */     return this.appAge;
/*      */   }
/*      */ 
/*      */   public void setappAge(int aappAge) {
/*  444 */     this.appAge = aappAge;
/*      */   }
/*      */ 
/*      */   public void setappAge(String aappAge) {
/*  448 */     if ((aappAge != null) && (!aappAge.equals("")))
/*      */     {
/*  450 */       Integer tInteger = new Integer(aappAge);
/*  451 */       int i = tInteger.intValue();
/*  452 */       this.appAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getappAgetype()
/*      */   {
/*  458 */     if (this.appAgetype != null) this.appAgetype.equals("");
/*      */ 
/*  462 */     return this.appAgetype;
/*      */   }
/*      */ 
/*      */   public void setappAgetype(String aappAgetype) {
/*  466 */     this.appAgetype = aappAgetype;
/*      */   }
/*      */ 
/*      */   public String getiDType() {
/*  470 */     if (this.iDType != null) this.iDType.equals("");
/*      */ 
/*  474 */     return this.iDType;
/*      */   }
/*      */ 
/*      */   public void setiDType(String aiDType) {
/*  478 */     this.iDType = aiDType;
/*      */   }
/*      */ 
/*      */   public String getiDNo() {
/*  482 */     if (this.iDNo != null) this.iDNo.equals("");
/*      */ 
/*  486 */     return this.iDNo;
/*      */   }
/*      */ 
/*      */   public void setiDNo(String aiDNo) {
/*  490 */     this.iDNo = aiDNo;
/*      */   }
/*      */ 
/*      */   public String getiDValidity() {
/*  494 */     if (this.iDValidity != null) {
/*  495 */       return this.fDate.getString(this.iDValidity);
/*      */     }
/*  497 */     return null;
/*      */   }
/*      */ 
/*      */   public void setiDValidity(Date aiDValidity) {
/*  501 */     this.iDValidity = aiDValidity;
/*      */   }
/*      */ 
/*      */   public void setiDValidity(String aiDValidity) {
/*  505 */     if ((aiDValidity != null) && (!aiDValidity.equals("")))
/*      */     {
/*  507 */       this.iDValidity = this.fDate.getDate(aiDValidity);
/*      */     }
/*      */     else
/*  510 */       this.iDValidity = null;
/*      */   }
/*      */ 
/*      */   public String getiDPerpetual()
/*      */   {
/*  515 */     if (this.iDPerpetual != null) this.iDPerpetual.equals("");
/*      */ 
/*  519 */     return this.iDPerpetual;
/*      */   }
/*      */ 
/*      */   public void setiDPerpetual(String aiDPerpetual) {
/*  523 */     this.iDPerpetual = aiDPerpetual;
/*      */   }
/*      */ 
/*      */   public String getnativePlace() {
/*  527 */     if (this.nativePlace != null) this.nativePlace.equals("");
/*      */ 
/*  531 */     return this.nativePlace;
/*      */   }
/*      */ 
/*      */   public void setnativePlace(String anativePlace) {
/*  535 */     this.nativePlace = anativePlace;
/*      */   }
/*      */ 
/*      */   public String getnationality() {
/*  539 */     if (this.nationality != null) this.nationality.equals("");
/*      */ 
/*  543 */     return this.nationality;
/*      */   }
/*      */ 
/*      */   public void setnationality(String anationality) {
/*  547 */     this.nationality = anationality;
/*      */   }
/*      */ 
/*      */   public String getrgtAddress() {
/*  551 */     if (this.rgtAddress != null) this.rgtAddress.equals("");
/*      */ 
/*  555 */     return this.rgtAddress;
/*      */   }
/*      */ 
/*      */   public void setrgtAddress(String argtAddress) {
/*  559 */     this.rgtAddress = argtAddress;
/*      */   }
/*      */ 
/*      */   public String getmarriage() {
/*  563 */     if (this.marriage != null) this.marriage.equals("");
/*      */ 
/*  567 */     return this.marriage;
/*      */   }
/*      */ 
/*      */   public void setmarriage(String amarriage) {
/*  571 */     this.marriage = amarriage;
/*      */   }
/*      */ 
/*      */   public String getmarriageDate() {
/*  575 */     if (this.marriageDate != null) {
/*  576 */       return this.fDate.getString(this.marriageDate);
/*      */     }
/*  578 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmarriageDate(Date amarriageDate) {
/*  582 */     this.marriageDate = amarriageDate;
/*      */   }
/*      */ 
/*      */   public void setmarriageDate(String amarriageDate) {
/*  586 */     if ((amarriageDate != null) && (!amarriageDate.equals("")))
/*      */     {
/*  588 */       this.marriageDate = this.fDate.getDate(amarriageDate);
/*      */     }
/*      */     else
/*  591 */       this.marriageDate = null;
/*      */   }
/*      */ 
/*      */   public String gethealth()
/*      */   {
/*  596 */     if (this.health != null) this.health.equals("");
/*      */ 
/*  600 */     return this.health;
/*      */   }
/*      */ 
/*      */   public void sethealth(String ahealth) {
/*  604 */     this.health = ahealth;
/*      */   }
/*      */ 
/*      */   public double getstature() {
/*  608 */     return this.stature;
/*      */   }
/*      */ 
/*      */   public void setstature(double astature) {
/*  612 */     this.stature = astature;
/*      */   }
/*      */ 
/*      */   public void setstature(String astature) {
/*  616 */     if ((astature != null) && (!astature.equals("")))
/*      */     {
/*  618 */       Double tDouble = new Double(astature);
/*  619 */       double d = tDouble.doubleValue();
/*  620 */       this.stature = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getavoirdupois()
/*      */   {
/*  626 */     return this.avoirdupois;
/*      */   }
/*      */ 
/*      */   public void setavoirdupois(double aavoirdupois) {
/*  630 */     this.avoirdupois = aavoirdupois;
/*      */   }
/*      */ 
/*      */   public void setavoirdupois(String aavoirdupois) {
/*  634 */     if ((aavoirdupois != null) && (!aavoirdupois.equals("")))
/*      */     {
/*  636 */       Double tDouble = new Double(aavoirdupois);
/*  637 */       double d = tDouble.doubleValue();
/*  638 */       this.avoirdupois = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getdegree()
/*      */   {
/*  644 */     if (this.degree != null) this.degree.equals("");
/*      */ 
/*  648 */     return this.degree;
/*      */   }
/*      */ 
/*      */   public void setdegree(String adegree) {
/*  652 */     this.degree = adegree;
/*      */   }
/*      */ 
/*      */   public String getcreditGrade() {
/*  656 */     if (this.creditGrade != null) this.creditGrade.equals("");
/*      */ 
/*  660 */     return this.creditGrade;
/*      */   }
/*      */ 
/*      */   public void setcreditGrade(String acreditGrade) {
/*  664 */     this.creditGrade = acreditGrade;
/*      */   }
/*      */ 
/*      */   public String getbankCode() {
/*  668 */     if (this.bankCode != null) this.bankCode.equals("");
/*      */ 
/*  672 */     return this.bankCode;
/*      */   }
/*      */ 
/*      */   public void setbankCode(String abankCode) {
/*  676 */     this.bankCode = abankCode;
/*      */   }
/*      */ 
/*      */   public String getbankAccNo() {
/*  680 */     if (this.bankAccNo != null) this.bankAccNo.equals("");
/*      */ 
/*  684 */     return this.bankAccNo;
/*      */   }
/*      */ 
/*      */   public void setbankAccNo(String abankAccNo) {
/*  688 */     this.bankAccNo = abankAccNo;
/*      */   }
/*      */ 
/*      */   public String getaccName() {
/*  692 */     if (this.accName != null) this.accName.equals("");
/*      */ 
/*  696 */     return this.accName;
/*      */   }
/*      */ 
/*      */   public void setaccName(String aaccName) {
/*  700 */     this.accName = aaccName;
/*      */   }
/*      */ 
/*      */   public String getjoinCompanyDate() {
/*  704 */     if (this.joinCompanyDate != null) {
/*  705 */       return this.fDate.getString(this.joinCompanyDate);
/*      */     }
/*  707 */     return null;
/*      */   }
/*      */ 
/*      */   public void setjoinCompanyDate(Date ajoinCompanyDate) {
/*  711 */     this.joinCompanyDate = ajoinCompanyDate;
/*      */   }
/*      */ 
/*      */   public void setjoinCompanyDate(String ajoinCompanyDate) {
/*  715 */     if ((ajoinCompanyDate != null) && (!ajoinCompanyDate.equals("")))
/*      */     {
/*  717 */       this.joinCompanyDate = this.fDate.getDate(ajoinCompanyDate);
/*      */     }
/*      */     else
/*  720 */       this.joinCompanyDate = null;
/*      */   }
/*      */ 
/*      */   public String getstartWorkDate()
/*      */   {
/*  725 */     if (this.startWorkDate != null) {
/*  726 */       return this.fDate.getString(this.startWorkDate);
/*      */     }
/*  728 */     return null;
/*      */   }
/*      */ 
/*      */   public void setstartWorkDate(Date astartWorkDate) {
/*  732 */     this.startWorkDate = astartWorkDate;
/*      */   }
/*      */ 
/*      */   public void setstartWorkDate(String astartWorkDate) {
/*  736 */     if ((astartWorkDate != null) && (!astartWorkDate.equals("")))
/*      */     {
/*  738 */       this.startWorkDate = this.fDate.getDate(astartWorkDate);
/*      */     }
/*      */     else
/*  741 */       this.startWorkDate = null;
/*      */   }
/*      */ 
/*      */   public String getposition()
/*      */   {
/*  746 */     if (this.position != null) this.position.equals("");
/*      */ 
/*  750 */     return this.position;
/*      */   }
/*      */ 
/*      */   public void setposition(String aposition) {
/*  754 */     this.position = aposition;
/*      */   }
/*      */ 
/*      */   public double getsalary() {
/*  758 */     return this.salary;
/*      */   }
/*      */ 
/*      */   public void setsalary(double asalary) {
/*  762 */     this.salary = asalary;
/*      */   }
/*      */ 
/*      */   public void setsalary(String asalary) {
/*  766 */     if ((asalary != null) && (!asalary.equals("")))
/*      */     {
/*  768 */       Double tDouble = new Double(asalary);
/*  769 */       double d = tDouble.doubleValue();
/*  770 */       this.salary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getoccupationType()
/*      */   {
/*  776 */     if (this.occupationType != null) this.occupationType.equals("");
/*      */ 
/*  780 */     return this.occupationType;
/*      */   }
/*      */ 
/*      */   public void setoccupationType(String aoccupationType) {
/*  784 */     this.occupationType = aoccupationType;
/*      */   }
/*      */ 
/*      */   public String getoccupationCode() {
/*  788 */     if (this.occupationCode != null) this.occupationCode.equals("");
/*      */ 
/*  792 */     return this.occupationCode;
/*      */   }
/*      */ 
/*      */   public void setoccupationCode(String aoccupationCode) {
/*  796 */     this.occupationCode = aoccupationCode;
/*      */   }
/*      */ 
/*      */   public String getpartOccupationType() {
/*  800 */     if (this.partOccupationType != null) this.partOccupationType.equals("");
/*      */ 
/*  804 */     return this.partOccupationType;
/*      */   }
/*      */ 
/*      */   public void setpartOccupationType(String apartOccupationType) {
/*  808 */     this.partOccupationType = apartOccupationType;
/*      */   }
/*      */ 
/*      */   public String getpartOccupationCode() {
/*  812 */     if (this.partOccupationCode != null) this.partOccupationCode.equals("");
/*      */ 
/*  816 */     return this.partOccupationCode;
/*      */   }
/*      */ 
/*      */   public void setpartOccupationCode(String apartOccupationCode) {
/*  820 */     this.partOccupationCode = apartOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getworkType() {
/*  824 */     if (this.workType != null) this.workType.equals("");
/*      */ 
/*  828 */     return this.workType;
/*      */   }
/*      */ 
/*      */   public void setworkType(String aworkType) {
/*  832 */     this.workType = aworkType;
/*      */   }
/*      */ 
/*      */   public String getpluralityType() {
/*  836 */     if (this.pluralityType != null) this.pluralityType.equals("");
/*      */ 
/*  840 */     return this.pluralityType;
/*      */   }
/*      */ 
/*      */   public void setpluralityType(String apluralityType) {
/*  844 */     this.pluralityType = apluralityType;
/*      */   }
/*      */ 
/*      */   public String getsmokeFlag() {
/*  848 */     if (this.smokeFlag != null) this.smokeFlag.equals("");
/*      */ 
/*  852 */     return this.smokeFlag;
/*      */   }
/*      */ 
/*      */   public void setsmokeFlag(String asmokeFlag) {
/*  856 */     this.smokeFlag = asmokeFlag;
/*      */   }
/*      */ 
/*      */   public String getcontPlanCode() {
/*  860 */     if (this.contPlanCode != null) this.contPlanCode.equals("");
/*      */ 
/*  864 */     return this.contPlanCode;
/*      */   }
/*      */ 
/*      */   public void setcontPlanCode(String acontPlanCode) {
/*  868 */     this.contPlanCode = acontPlanCode;
/*      */   }
/*      */ 
/*      */   public String getoperator() {
/*  872 */     if (this.operator != null) this.operator.equals("");
/*      */ 
/*  876 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setoperator(String aoperator) {
/*  880 */     this.operator = aoperator;
/*      */   }
/*      */ 
/*      */   public String getmakeDate() {
/*  884 */     if (this.makeDate != null) {
/*  885 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  887 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(Date amakeDate) {
/*  891 */     this.makeDate = amakeDate;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(String amakeDate) {
/*  895 */     if ((amakeDate != null) && (!amakeDate.equals("")))
/*      */     {
/*  897 */       this.makeDate = this.fDate.getDate(amakeDate);
/*      */     }
/*      */     else
/*  900 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getmakeTime()
/*      */   {
/*  905 */     if (this.makeTime != null) this.makeTime.equals("");
/*      */ 
/*  909 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setmakeTime(String amakeTime) {
/*  913 */     this.makeTime = amakeTime;
/*      */   }
/*      */ 
/*      */   public String getmodifyDate() {
/*  917 */     if (this.modifyDate != null) {
/*  918 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  920 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(Date amodifyDate) {
/*  924 */     this.modifyDate = amodifyDate;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(String amodifyDate) {
/*  928 */     if ((amodifyDate != null) && (!amodifyDate.equals("")))
/*      */     {
/*  930 */       this.modifyDate = this.fDate.getDate(amodifyDate);
/*      */     }
/*      */     else
/*  933 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getmodifyTime()
/*      */   {
/*  938 */     if (this.modifyTime != null) this.modifyTime.equals("");
/*      */ 
/*  942 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setmodifyTime(String amodifyTime) {
/*  946 */     this.modifyTime = amodifyTime;
/*      */   }
/*      */ 
/*      */   public int getinsuredPeoples() {
/*  950 */     return this.insuredPeoples;
/*      */   }
/*      */ 
/*      */   public void setinsuredPeoples(int ainsuredPeoples) {
/*  954 */     this.insuredPeoples = ainsuredPeoples;
/*      */   }
/*      */ 
/*      */   public void setinsuredPeoples(String ainsuredPeoples) {
/*  958 */     if ((ainsuredPeoples != null) && (!ainsuredPeoples.equals("")))
/*      */     {
/*  960 */       Integer tInteger = new Integer(ainsuredPeoples);
/*  961 */       int i = tInteger.intValue();
/*  962 */       this.insuredPeoples = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPInsuredBSchema aLNPInsuredBSchema)
/*      */   {
/*  970 */     this.EdorNo = aLNPInsuredBSchema.getEdorNo();
/*  971 */     this.serialNo = aLNPInsuredBSchema.getserialNo();
/*  972 */     this.grpContNo = aLNPInsuredBSchema.getgrpContNo();
/*  973 */     this.contNo = aLNPInsuredBSchema.getcontNo();
/*  974 */     this.proposalContNo = aLNPInsuredBSchema.getproposalContNo();
/*  975 */     this.insuredNo = aLNPInsuredBSchema.getinsuredNo();
/*  976 */     this.insuredId = aLNPInsuredBSchema.getinsuredId();
/*  977 */     this.prtNo = aLNPInsuredBSchema.getprtNo();
/*  978 */     this.appntNo = aLNPInsuredBSchema.getappntNo();
/*  979 */     this.appntId = aLNPInsuredBSchema.getappntId();
/*  980 */     this.manageCom = aLNPInsuredBSchema.getmanageCom();
/*  981 */     this.signCity = aLNPInsuredBSchema.getsignCity();
/*  982 */     this.executeCom = aLNPInsuredBSchema.getexecuteCom();
/*  983 */     this.familyID = aLNPInsuredBSchema.getfamilyID();
/*  984 */     this.relationToMainInsured = aLNPInsuredBSchema.getrelationToMainInsured();
/*  985 */     this.relationToAppnt = aLNPInsuredBSchema.getrelationToAppnt();
/*  986 */     this.addressNo = aLNPInsuredBSchema.getaddressNo();
/*  987 */     this.sequenceNo = aLNPInsuredBSchema.getsequenceNo();
/*  988 */     this.name = aLNPInsuredBSchema.getname();
/*  989 */     this.appellation = aLNPInsuredBSchema.getappellation();
/*  990 */     this.sex = aLNPInsuredBSchema.getsex();
/*  991 */     this.birthday = this.fDate.getDate(aLNPInsuredBSchema.getbirthday());
/*  992 */     this.appAge = aLNPInsuredBSchema.getappAge();
/*  993 */     this.appAgetype = aLNPInsuredBSchema.getappAgetype();
/*  994 */     this.iDType = aLNPInsuredBSchema.getiDType();
/*  995 */     this.iDNo = aLNPInsuredBSchema.getiDNo();
/*  996 */     this.iDValidity = this.fDate.getDate(aLNPInsuredBSchema.getiDValidity());
/*  997 */     this.iDPerpetual = aLNPInsuredBSchema.getiDPerpetual();
/*  998 */     this.nativePlace = aLNPInsuredBSchema.getnativePlace();
/*  999 */     this.nationality = aLNPInsuredBSchema.getnationality();
/* 1000 */     this.rgtAddress = aLNPInsuredBSchema.getrgtAddress();
/* 1001 */     this.marriage = aLNPInsuredBSchema.getmarriage();
/* 1002 */     this.marriageDate = this.fDate.getDate(aLNPInsuredBSchema.getmarriageDate());
/* 1003 */     this.health = aLNPInsuredBSchema.gethealth();
/* 1004 */     this.stature = aLNPInsuredBSchema.getstature();
/* 1005 */     this.avoirdupois = aLNPInsuredBSchema.getavoirdupois();
/* 1006 */     this.degree = aLNPInsuredBSchema.getdegree();
/* 1007 */     this.creditGrade = aLNPInsuredBSchema.getcreditGrade();
/* 1008 */     this.bankCode = aLNPInsuredBSchema.getbankCode();
/* 1009 */     this.bankAccNo = aLNPInsuredBSchema.getbankAccNo();
/* 1010 */     this.accName = aLNPInsuredBSchema.getaccName();
/* 1011 */     this.joinCompanyDate = this.fDate.getDate(aLNPInsuredBSchema.getjoinCompanyDate());
/* 1012 */     this.startWorkDate = this.fDate.getDate(aLNPInsuredBSchema.getstartWorkDate());
/* 1013 */     this.position = aLNPInsuredBSchema.getposition();
/* 1014 */     this.salary = aLNPInsuredBSchema.getsalary();
/* 1015 */     this.occupationType = aLNPInsuredBSchema.getoccupationType();
/* 1016 */     this.occupationCode = aLNPInsuredBSchema.getoccupationCode();
/* 1017 */     this.partOccupationType = aLNPInsuredBSchema.getpartOccupationType();
/* 1018 */     this.partOccupationCode = aLNPInsuredBSchema.getpartOccupationCode();
/* 1019 */     this.workType = aLNPInsuredBSchema.getworkType();
/* 1020 */     this.pluralityType = aLNPInsuredBSchema.getpluralityType();
/* 1021 */     this.smokeFlag = aLNPInsuredBSchema.getsmokeFlag();
/* 1022 */     this.contPlanCode = aLNPInsuredBSchema.getcontPlanCode();
/* 1023 */     this.operator = aLNPInsuredBSchema.getoperator();
/* 1024 */     this.makeDate = this.fDate.getDate(aLNPInsuredBSchema.getmakeDate());
/* 1025 */     this.makeTime = aLNPInsuredBSchema.getmakeTime();
/* 1026 */     this.modifyDate = this.fDate.getDate(aLNPInsuredBSchema.getmodifyDate());
/* 1027 */     this.modifyTime = aLNPInsuredBSchema.getmodifyTime();
/* 1028 */     this.insuredPeoples = aLNPInsuredBSchema.getinsuredPeoples();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/* 1037 */       if (rs.getString("EdorNo") == null)
/* 1038 */         this.EdorNo = null;
/*      */       else {
/* 1040 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/* 1042 */       if (rs.getString("serialNo") == null)
/* 1043 */         this.serialNo = null;
/*      */       else {
/* 1045 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/* 1047 */       if (rs.getString("grpContNo") == null)
/* 1048 */         this.grpContNo = null;
/*      */       else {
/* 1050 */         this.grpContNo = rs.getString("grpContNo").trim();
/*      */       }
/* 1052 */       if (rs.getString("contNo") == null)
/* 1053 */         this.contNo = null;
/*      */       else {
/* 1055 */         this.contNo = rs.getString("contNo").trim();
/*      */       }
/* 1057 */       if (rs.getString("proposalContNo") == null)
/* 1058 */         this.proposalContNo = null;
/*      */       else {
/* 1060 */         this.proposalContNo = rs.getString("proposalContNo").trim();
/*      */       }
/* 1062 */       if (rs.getString("insuredNo") == null)
/* 1063 */         this.insuredNo = null;
/*      */       else {
/* 1065 */         this.insuredNo = rs.getString("insuredNo").trim();
/*      */       }
/* 1067 */       if (rs.getString("insuredId") == null)
/* 1068 */         this.insuredId = null;
/*      */       else {
/* 1070 */         this.insuredId = rs.getString("insuredId").trim();
/*      */       }
/* 1072 */       if (rs.getString("prtNo") == null)
/* 1073 */         this.prtNo = null;
/*      */       else {
/* 1075 */         this.prtNo = rs.getString("prtNo").trim();
/*      */       }
/* 1077 */       if (rs.getString("appntNo") == null)
/* 1078 */         this.appntNo = null;
/*      */       else {
/* 1080 */         this.appntNo = rs.getString("appntNo").trim();
/*      */       }
/* 1082 */       if (rs.getString("appntId") == null)
/* 1083 */         this.appntId = null;
/*      */       else {
/* 1085 */         this.appntId = rs.getString("appntId").trim();
/*      */       }
/* 1087 */       if (rs.getString("manageCom") == null)
/* 1088 */         this.manageCom = null;
/*      */       else {
/* 1090 */         this.manageCom = rs.getString("manageCom").trim();
/*      */       }
/* 1092 */       if (rs.getString("signCity") == null)
/* 1093 */         this.signCity = null;
/*      */       else {
/* 1095 */         this.signCity = rs.getString("signCity").trim();
/*      */       }
/* 1097 */       if (rs.getString("executeCom") == null)
/* 1098 */         this.executeCom = null;
/*      */       else {
/* 1100 */         this.executeCom = rs.getString("executeCom").trim();
/*      */       }
/* 1102 */       if (rs.getString("familyID") == null)
/* 1103 */         this.familyID = null;
/*      */       else {
/* 1105 */         this.familyID = rs.getString("familyID").trim();
/*      */       }
/* 1107 */       if (rs.getString("relationToMainInsured") == null)
/* 1108 */         this.relationToMainInsured = null;
/*      */       else {
/* 1110 */         this.relationToMainInsured = rs.getString("relationToMainInsured").trim();
/*      */       }
/* 1112 */       if (rs.getString("relationToAppnt") == null)
/* 1113 */         this.relationToAppnt = null;
/*      */       else {
/* 1115 */         this.relationToAppnt = rs.getString("relationToAppnt").trim();
/*      */       }
/* 1117 */       if (rs.getString("addressNo") == null)
/* 1118 */         this.addressNo = null;
/*      */       else {
/* 1120 */         this.addressNo = rs.getString("addressNo").trim();
/*      */       }
/* 1122 */       if (rs.getString("sequenceNo") == null)
/* 1123 */         this.sequenceNo = null;
/*      */       else {
/* 1125 */         this.sequenceNo = rs.getString("sequenceNo").trim();
/*      */       }
/* 1127 */       if (rs.getString("name") == null)
/* 1128 */         this.name = null;
/*      */       else {
/* 1130 */         this.name = rs.getString("name").trim();
/*      */       }
/* 1132 */       if (rs.getString("appellation") == null)
/* 1133 */         this.appellation = null;
/*      */       else {
/* 1135 */         this.appellation = rs.getString("appellation").trim();
/*      */       }
/* 1137 */       if (rs.getString("sex") == null)
/* 1138 */         this.sex = null;
/*      */       else {
/* 1140 */         this.sex = rs.getString("sex").trim();
/*      */       }
/* 1142 */       this.birthday = rs.getDate("birthday");
/* 1143 */       this.appAge = rs.getInt("appAge");
/* 1144 */       if (rs.getString("appAgetype") == null)
/* 1145 */         this.appAgetype = null;
/*      */       else {
/* 1147 */         this.appAgetype = rs.getString("appAgetype").trim();
/*      */       }
/* 1149 */       if (rs.getString("iDType") == null)
/* 1150 */         this.iDType = null;
/*      */       else {
/* 1152 */         this.iDType = rs.getString("iDType").trim();
/*      */       }
/* 1154 */       if (rs.getString("iDNo") == null)
/* 1155 */         this.iDNo = null;
/*      */       else {
/* 1157 */         this.iDNo = rs.getString("iDNo").trim();
/*      */       }
/* 1159 */       this.iDValidity = rs.getDate("iDValidity");
/* 1160 */       if (rs.getString("iDPerpetual") == null)
/* 1161 */         this.iDPerpetual = null;
/*      */       else {
/* 1163 */         this.iDPerpetual = rs.getString("iDPerpetual").trim();
/*      */       }
/* 1165 */       if (rs.getString("nativePlace") == null)
/* 1166 */         this.nativePlace = null;
/*      */       else {
/* 1168 */         this.nativePlace = rs.getString("nativePlace").trim();
/*      */       }
/* 1170 */       if (rs.getString("nationality") == null)
/* 1171 */         this.nationality = null;
/*      */       else {
/* 1173 */         this.nationality = rs.getString("nationality").trim();
/*      */       }
/* 1175 */       if (rs.getString("rgtAddress") == null)
/* 1176 */         this.rgtAddress = null;
/*      */       else {
/* 1178 */         this.rgtAddress = rs.getString("rgtAddress").trim();
/*      */       }
/* 1180 */       if (rs.getString("marriage") == null)
/* 1181 */         this.marriage = null;
/*      */       else {
/* 1183 */         this.marriage = rs.getString("marriage").trim();
/*      */       }
/* 1185 */       this.marriageDate = rs.getDate("marriageDate");
/* 1186 */       if (rs.getString("health") == null)
/* 1187 */         this.health = null;
/*      */       else {
/* 1189 */         this.health = rs.getString("health").trim();
/*      */       }
/* 1191 */       this.stature = rs.getDouble("stature");
/* 1192 */       this.avoirdupois = rs.getDouble("avoirdupois");
/* 1193 */       if (rs.getString("degree") == null)
/* 1194 */         this.degree = null;
/*      */       else {
/* 1196 */         this.degree = rs.getString("degree").trim();
/*      */       }
/* 1198 */       if (rs.getString("creditGrade") == null)
/* 1199 */         this.creditGrade = null;
/*      */       else {
/* 1201 */         this.creditGrade = rs.getString("creditGrade").trim();
/*      */       }
/* 1203 */       if (rs.getString("bankCode") == null)
/* 1204 */         this.bankCode = null;
/*      */       else {
/* 1206 */         this.bankCode = rs.getString("bankCode").trim();
/*      */       }
/* 1208 */       if (rs.getString("bankAccNo") == null)
/* 1209 */         this.bankAccNo = null;
/*      */       else {
/* 1211 */         this.bankAccNo = rs.getString("bankAccNo").trim();
/*      */       }
/* 1213 */       if (rs.getString("accName") == null)
/* 1214 */         this.accName = null;
/*      */       else {
/* 1216 */         this.accName = rs.getString("accName").trim();
/*      */       }
/* 1218 */       this.joinCompanyDate = rs.getDate("joinCompanyDate");
/* 1219 */       this.startWorkDate = rs.getDate("startWorkDate");
/* 1220 */       if (rs.getString("position") == null)
/* 1221 */         this.position = null;
/*      */       else {
/* 1223 */         this.position = rs.getString("position").trim();
/*      */       }
/* 1225 */       this.salary = rs.getDouble("salary");
/* 1226 */       if (rs.getString("occupationType") == null)
/* 1227 */         this.occupationType = null;
/*      */       else {
/* 1229 */         this.occupationType = rs.getString("occupationType").trim();
/*      */       }
/* 1231 */       if (rs.getString("occupationCode") == null)
/* 1232 */         this.occupationCode = null;
/*      */       else {
/* 1234 */         this.occupationCode = rs.getString("occupationCode").trim();
/*      */       }
/* 1236 */       if (rs.getString("partOccupationType") == null)
/* 1237 */         this.partOccupationType = null;
/*      */       else {
/* 1239 */         this.partOccupationType = rs.getString("partOccupationType").trim();
/*      */       }
/* 1241 */       if (rs.getString("partOccupationCode") == null)
/* 1242 */         this.partOccupationCode = null;
/*      */       else {
/* 1244 */         this.partOccupationCode = rs.getString("partOccupationCode").trim();
/*      */       }
/* 1246 */       if (rs.getString("workType") == null)
/* 1247 */         this.workType = null;
/*      */       else {
/* 1249 */         this.workType = rs.getString("workType").trim();
/*      */       }
/* 1251 */       if (rs.getString("pluralityType") == null)
/* 1252 */         this.pluralityType = null;
/*      */       else {
/* 1254 */         this.pluralityType = rs.getString("pluralityType").trim();
/*      */       }
/* 1256 */       if (rs.getString("smokeFlag") == null)
/* 1257 */         this.smokeFlag = null;
/*      */       else {
/* 1259 */         this.smokeFlag = rs.getString("smokeFlag").trim();
/*      */       }
/* 1261 */       if (rs.getString("contPlanCode") == null)
/* 1262 */         this.contPlanCode = null;
/*      */       else {
/* 1264 */         this.contPlanCode = rs.getString("contPlanCode").trim();
/*      */       }
/* 1266 */       if (rs.getString("operator") == null)
/* 1267 */         this.operator = null;
/*      */       else {
/* 1269 */         this.operator = rs.getString("operator").trim();
/*      */       }
/* 1271 */       this.makeDate = rs.getDate("makeDate");
/* 1272 */       if (rs.getString("makeTime") == null)
/* 1273 */         this.makeTime = null;
/*      */       else {
/* 1275 */         this.makeTime = rs.getString("makeTime").trim();
/*      */       }
/* 1277 */       this.modifyDate = rs.getDate("modifyDate");
/* 1278 */       if (rs.getString("modifyTime") == null)
/* 1279 */         this.modifyTime = null;
/*      */       else {
/* 1281 */         this.modifyTime = rs.getString("modifyTime").trim();
/*      */       }
/* 1283 */       this.insuredPeoples = rs.getInt("insuredPeoples");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1288 */       CError tError = new CError();
/* 1289 */       tError.moduleName = "LNPInsuredBSchema";
/* 1290 */       tError.functionName = "setSchema";
/* 1291 */       tError.errorMessage = sqle.toString();
/* 1292 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1294 */       return false;
/*      */     }
/* 1296 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInsuredBSchema getSchema()
/*      */   {
/* 1301 */     LNPInsuredBSchema aLNPInsuredBSchema = new LNPInsuredBSchema();
/* 1302 */     aLNPInsuredBSchema.setSchema(this);
/* 1303 */     return aLNPInsuredBSchema;
/*      */   }
/*      */ 
/*      */   public LNPInsuredBDB getDB()
/*      */   {
/* 1308 */     LNPInsuredBDB aDBOper = new LNPInsuredBDB();
/* 1309 */     aDBOper.setSchema(this);
/* 1310 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1317 */     String strReturn = "";
/* 1318 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/* 1319 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/* 1320 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpContNo)) + "|" + 
/* 1321 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contNo)) + "|" + 
/* 1322 */       StrTool.cTrim(StrTool.unicodeToGBK(this.proposalContNo)) + "|" + 
/* 1323 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredNo)) + "|" + 
/* 1324 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredId)) + "|" + 
/* 1325 */       StrTool.cTrim(StrTool.unicodeToGBK(this.prtNo)) + "|" + 
/* 1326 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntNo)) + "|" + 
/* 1327 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntId)) + "|" + 
/* 1328 */       StrTool.cTrim(StrTool.unicodeToGBK(this.manageCom)) + "|" + 
/* 1329 */       StrTool.cTrim(StrTool.unicodeToGBK(this.signCity)) + "|" + 
/* 1330 */       StrTool.cTrim(StrTool.unicodeToGBK(this.executeCom)) + "|" + 
/* 1331 */       StrTool.cTrim(StrTool.unicodeToGBK(this.familyID)) + "|" + 
/* 1332 */       StrTool.cTrim(StrTool.unicodeToGBK(this.relationToMainInsured)) + "|" + 
/* 1333 */       StrTool.cTrim(StrTool.unicodeToGBK(this.relationToAppnt)) + "|" + 
/* 1334 */       StrTool.cTrim(StrTool.unicodeToGBK(this.addressNo)) + "|" + 
/* 1335 */       StrTool.cTrim(StrTool.unicodeToGBK(this.sequenceNo)) + "|" + 
/* 1336 */       StrTool.cTrim(StrTool.unicodeToGBK(this.name)) + "|" + 
/* 1337 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appellation)) + "|" + 
/* 1338 */       StrTool.cTrim(StrTool.unicodeToGBK(this.sex)) + "|" + 
/* 1339 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.birthday))) + "|" + 
/* 1340 */       ChgData.chgData(this.appAge) + "|" + 
/* 1341 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appAgetype)) + "|" + 
/* 1342 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDType)) + "|" + 
/* 1343 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDNo)) + "|" + 
/* 1344 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.iDValidity))) + "|" + 
/* 1345 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDPerpetual)) + "|" + 
/* 1346 */       StrTool.cTrim(StrTool.unicodeToGBK(this.nativePlace)) + "|" + 
/* 1347 */       StrTool.cTrim(StrTool.unicodeToGBK(this.nationality)) + "|" + 
/* 1348 */       StrTool.cTrim(StrTool.unicodeToGBK(this.rgtAddress)) + "|" + 
/* 1349 */       StrTool.cTrim(StrTool.unicodeToGBK(this.marriage)) + "|" + 
/* 1350 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.marriageDate))) + "|" + 
/* 1351 */       StrTool.cTrim(StrTool.unicodeToGBK(this.health)) + "|" + 
/* 1352 */       ChgData.chgData(this.stature) + "|" + 
/* 1353 */       ChgData.chgData(this.avoirdupois) + "|" + 
/* 1354 */       StrTool.cTrim(StrTool.unicodeToGBK(this.degree)) + "|" + 
/* 1355 */       StrTool.cTrim(StrTool.unicodeToGBK(this.creditGrade)) + "|" + 
/* 1356 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bankCode)) + "|" + 
/* 1357 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bankAccNo)) + "|" + 
/* 1358 */       StrTool.cTrim(StrTool.unicodeToGBK(this.accName)) + "|" + 
/* 1359 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.joinCompanyDate))) + "|" + 
/* 1360 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.startWorkDate))) + "|" + 
/* 1361 */       StrTool.cTrim(StrTool.unicodeToGBK(this.position)) + "|" + 
/* 1362 */       ChgData.chgData(this.salary) + "|" + 
/* 1363 */       StrTool.cTrim(StrTool.unicodeToGBK(this.occupationType)) + "|" + 
/* 1364 */       StrTool.cTrim(StrTool.unicodeToGBK(this.occupationCode)) + "|" + 
/* 1365 */       StrTool.cTrim(StrTool.unicodeToGBK(this.partOccupationType)) + "|" + 
/* 1366 */       StrTool.cTrim(StrTool.unicodeToGBK(this.partOccupationCode)) + "|" + 
/* 1367 */       StrTool.cTrim(StrTool.unicodeToGBK(this.workType)) + "|" + 
/* 1368 */       StrTool.cTrim(StrTool.unicodeToGBK(this.pluralityType)) + "|" + 
/* 1369 */       StrTool.cTrim(StrTool.unicodeToGBK(this.smokeFlag)) + "|" + 
/* 1370 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contPlanCode)) + "|" + 
/* 1371 */       StrTool.cTrim(StrTool.unicodeToGBK(this.operator)) + "|" + 
/* 1372 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makeDate))) + "|" + 
/* 1373 */       StrTool.cTrim(StrTool.unicodeToGBK(this.makeTime)) + "|" + 
/* 1374 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifyDate))) + "|" + 
/* 1375 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifyTime)) + "|" + 
/* 1376 */       ChgData.chgData(this.insuredPeoples);
/* 1377 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1385 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1386 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1387 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1388 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1389 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1390 */       this.insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1391 */       this.insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1392 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1393 */       this.appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1394 */       this.appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1395 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1396 */       this.signCity = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1397 */       this.executeCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1398 */       this.familyID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1399 */       this.relationToMainInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1400 */       this.relationToAppnt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1401 */       this.addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1402 */       this.sequenceNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1403 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1404 */       this.appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 1405 */       this.sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1406 */       this.birthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/* 1407 */       this.appAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|"))).intValue();
/* 1408 */       this.appAgetype = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1409 */       this.iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1410 */       this.iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1411 */       this.iDValidity = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
/* 1412 */       this.iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1413 */       this.nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 1414 */       this.nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1415 */       this.rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/* 1416 */       this.marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 1417 */       this.marriageDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|"));
/* 1418 */       this.health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/* 1419 */       this.stature = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 35, "|"))).doubleValue();
/* 1420 */       this.avoirdupois = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|"))).doubleValue();
/* 1421 */       this.degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 1422 */       this.creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/* 1423 */       this.bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/* 1424 */       this.bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1425 */       this.accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1426 */       this.joinCompanyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|"));
/* 1427 */       this.startWorkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|"));
/* 1428 */       this.position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1429 */       this.salary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 45, "|"))).doubleValue();
/* 1430 */       this.occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 1431 */       this.occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 1432 */       this.partOccupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 1433 */       this.partOccupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/* 1434 */       this.workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
/* 1435 */       this.pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
/* 1436 */       this.smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
/* 1437 */       this.contPlanCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
/* 1438 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
/* 1439 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|"));
/* 1440 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
/* 1441 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, "|"));
/* 1442 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 58, "|");
/* 1443 */       this.insuredPeoples = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|"))).intValue();
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1448 */       CError tError = new CError();
/* 1449 */       tError.moduleName = "LNPInsuredBSchema";
/* 1450 */       tError.functionName = "decode";
/* 1451 */       tError.errorMessage = ex.toString();
/* 1452 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1454 */       return false;
/*      */     }
/* 1456 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1462 */     String strReturn = "";
/* 1463 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 1465 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/* 1467 */     if (FCode.equals("serialNo"))
/*      */     {
/* 1469 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/* 1471 */     if (FCode.equals("grpContNo"))
/*      */     {
/* 1473 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/* 1475 */     if (FCode.equals("contNo"))
/*      */     {
/* 1477 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/* 1479 */     if (FCode.equals("proposalContNo"))
/*      */     {
/* 1481 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/* 1483 */     if (FCode.equals("insuredNo"))
/*      */     {
/* 1485 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredNo));
/*      */     }
/* 1487 */     if (FCode.equals("insuredId"))
/*      */     {
/* 1489 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredId));
/*      */     }
/* 1491 */     if (FCode.equals("prtNo"))
/*      */     {
/* 1493 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/* 1495 */     if (FCode.equals("appntNo"))
/*      */     {
/* 1497 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntNo));
/*      */     }
/* 1499 */     if (FCode.equals("appntId"))
/*      */     {
/* 1501 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntId));
/*      */     }
/* 1503 */     if (FCode.equals("manageCom"))
/*      */     {
/* 1505 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 1507 */     if (FCode.equals("signCity"))
/*      */     {
/* 1509 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signCity));
/*      */     }
/* 1511 */     if (FCode.equals("executeCom"))
/*      */     {
/* 1513 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.executeCom));
/*      */     }
/* 1515 */     if (FCode.equals("familyID"))
/*      */     {
/* 1517 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.familyID));
/*      */     }
/* 1519 */     if (FCode.equals("relationToMainInsured"))
/*      */     {
/* 1521 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relationToMainInsured));
/*      */     }
/* 1523 */     if (FCode.equals("relationToAppnt"))
/*      */     {
/* 1525 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relationToAppnt));
/*      */     }
/* 1527 */     if (FCode.equals("addressNo"))
/*      */     {
/* 1529 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addressNo));
/*      */     }
/* 1531 */     if (FCode.equals("sequenceNo"))
/*      */     {
/* 1533 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sequenceNo));
/*      */     }
/* 1535 */     if (FCode.equals("name"))
/*      */     {
/* 1537 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/* 1539 */     if (FCode.equals("appellation"))
/*      */     {
/* 1541 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appellation));
/*      */     }
/* 1543 */     if (FCode.equals("sex"))
/*      */     {
/* 1545 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sex));
/*      */     }
/* 1547 */     if (FCode.equals("birthday"))
/*      */     {
/* 1549 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getbirthday()));
/*      */     }
/* 1551 */     if (FCode.equals("appAge"))
/*      */     {
/* 1553 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appAge));
/*      */     }
/* 1555 */     if (FCode.equals("appAgetype"))
/*      */     {
/* 1557 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appAgetype));
/*      */     }
/* 1559 */     if (FCode.equals("iDType"))
/*      */     {
/* 1561 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDType));
/*      */     }
/* 1563 */     if (FCode.equals("iDNo"))
/*      */     {
/* 1565 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDNo));
/*      */     }
/* 1567 */     if (FCode.equals("iDValidity"))
/*      */     {
/* 1569 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
/*      */     }
/* 1571 */     if (FCode.equals("iDPerpetual"))
/*      */     {
/* 1573 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDPerpetual));
/*      */     }
/* 1575 */     if (FCode.equals("nativePlace"))
/*      */     {
/* 1577 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nativePlace));
/*      */     }
/* 1579 */     if (FCode.equals("nationality"))
/*      */     {
/* 1581 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nationality));
/*      */     }
/* 1583 */     if (FCode.equals("rgtAddress"))
/*      */     {
/* 1585 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rgtAddress));
/*      */     }
/* 1587 */     if (FCode.equals("marriage"))
/*      */     {
/* 1589 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.marriage));
/*      */     }
/* 1591 */     if (FCode.equals("marriageDate"))
/*      */     {
/* 1593 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
/*      */     }
/* 1595 */     if (FCode.equals("health"))
/*      */     {
/* 1597 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.health));
/*      */     }
/* 1599 */     if (FCode.equals("stature"))
/*      */     {
/* 1601 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stature));
/*      */     }
/* 1603 */     if (FCode.equals("avoirdupois"))
/*      */     {
/* 1605 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.avoirdupois));
/*      */     }
/* 1607 */     if (FCode.equals("degree"))
/*      */     {
/* 1609 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.degree));
/*      */     }
/* 1611 */     if (FCode.equals("creditGrade"))
/*      */     {
/* 1613 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.creditGrade));
/*      */     }
/* 1615 */     if (FCode.equals("bankCode"))
/*      */     {
/* 1617 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankCode));
/*      */     }
/* 1619 */     if (FCode.equals("bankAccNo"))
/*      */     {
/* 1621 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankAccNo));
/*      */     }
/* 1623 */     if (FCode.equals("accName"))
/*      */     {
/* 1625 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.accName));
/*      */     }
/* 1627 */     if (FCode.equals("joinCompanyDate"))
/*      */     {
/* 1629 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
/*      */     }
/* 1631 */     if (FCode.equals("startWorkDate"))
/*      */     {
/* 1633 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
/*      */     }
/* 1635 */     if (FCode.equals("position"))
/*      */     {
/* 1637 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.position));
/*      */     }
/* 1639 */     if (FCode.equals("salary"))
/*      */     {
/* 1641 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.salary));
/*      */     }
/* 1643 */     if (FCode.equals("occupationType"))
/*      */     {
/* 1645 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationType));
/*      */     }
/* 1647 */     if (FCode.equals("occupationCode"))
/*      */     {
/* 1649 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationCode));
/*      */     }
/* 1651 */     if (FCode.equals("partOccupationType"))
/*      */     {
/* 1653 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.partOccupationType));
/*      */     }
/* 1655 */     if (FCode.equals("partOccupationCode"))
/*      */     {
/* 1657 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.partOccupationCode));
/*      */     }
/* 1659 */     if (FCode.equals("workType"))
/*      */     {
/* 1661 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.workType));
/*      */     }
/* 1663 */     if (FCode.equals("pluralityType"))
/*      */     {
/* 1665 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pluralityType));
/*      */     }
/* 1667 */     if (FCode.equals("smokeFlag"))
/*      */     {
/* 1669 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.smokeFlag));
/*      */     }
/* 1671 */     if (FCode.equals("contPlanCode"))
/*      */     {
/* 1673 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contPlanCode));
/*      */     }
/* 1675 */     if (FCode.equals("operator"))
/*      */     {
/* 1677 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1679 */     if (FCode.equals("makeDate"))
/*      */     {
/* 1681 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*      */     }
/* 1683 */     if (FCode.equals("makeTime"))
/*      */     {
/* 1685 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1687 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 1689 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*      */     }
/* 1691 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 1693 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1695 */     if (FCode.equals("insuredPeoples"))
/*      */     {
/* 1697 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredPeoples));
/*      */     }
/* 1699 */     if (strReturn.equals(""))
/*      */     {
/* 1701 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1704 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1711 */     String strFieldValue = "";
/* 1712 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1714 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/* 1715 */       break;
/*      */     case 1:
/* 1717 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/* 1718 */       break;
/*      */     case 2:
/* 1720 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/* 1721 */       break;
/*      */     case 3:
/* 1723 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 1724 */       break;
/*      */     case 4:
/* 1726 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/* 1727 */       break;
/*      */     case 5:
/* 1729 */       strFieldValue = StrTool.GBKToUnicode(this.insuredNo);
/* 1730 */       break;
/*      */     case 6:
/* 1732 */       strFieldValue = StrTool.GBKToUnicode(this.insuredId);
/* 1733 */       break;
/*      */     case 7:
/* 1735 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/* 1736 */       break;
/*      */     case 8:
/* 1738 */       strFieldValue = StrTool.GBKToUnicode(this.appntNo);
/* 1739 */       break;
/*      */     case 9:
/* 1741 */       strFieldValue = StrTool.GBKToUnicode(this.appntId);
/* 1742 */       break;
/*      */     case 10:
/* 1744 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1745 */       break;
/*      */     case 11:
/* 1747 */       strFieldValue = StrTool.GBKToUnicode(this.signCity);
/* 1748 */       break;
/*      */     case 12:
/* 1750 */       strFieldValue = StrTool.GBKToUnicode(this.executeCom);
/* 1751 */       break;
/*      */     case 13:
/* 1753 */       strFieldValue = StrTool.GBKToUnicode(this.familyID);
/* 1754 */       break;
/*      */     case 14:
/* 1756 */       strFieldValue = StrTool.GBKToUnicode(this.relationToMainInsured);
/* 1757 */       break;
/*      */     case 15:
/* 1759 */       strFieldValue = StrTool.GBKToUnicode(this.relationToAppnt);
/* 1760 */       break;
/*      */     case 16:
/* 1762 */       strFieldValue = StrTool.GBKToUnicode(this.addressNo);
/* 1763 */       break;
/*      */     case 17:
/* 1765 */       strFieldValue = StrTool.GBKToUnicode(this.sequenceNo);
/* 1766 */       break;
/*      */     case 18:
/* 1768 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/* 1769 */       break;
/*      */     case 19:
/* 1771 */       strFieldValue = StrTool.GBKToUnicode(this.appellation);
/* 1772 */       break;
/*      */     case 20:
/* 1774 */       strFieldValue = StrTool.GBKToUnicode(this.sex);
/* 1775 */       break;
/*      */     case 21:
/* 1777 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getbirthday()));
/* 1778 */       break;
/*      */     case 22:
/* 1780 */       strFieldValue = String.valueOf(this.appAge);
/* 1781 */       break;
/*      */     case 23:
/* 1783 */       strFieldValue = StrTool.GBKToUnicode(this.appAgetype);
/* 1784 */       break;
/*      */     case 24:
/* 1786 */       strFieldValue = StrTool.GBKToUnicode(this.iDType);
/* 1787 */       break;
/*      */     case 25:
/* 1789 */       strFieldValue = StrTool.GBKToUnicode(this.iDNo);
/* 1790 */       break;
/*      */     case 26:
/* 1792 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
/* 1793 */       break;
/*      */     case 27:
/* 1795 */       strFieldValue = StrTool.GBKToUnicode(this.iDPerpetual);
/* 1796 */       break;
/*      */     case 28:
/* 1798 */       strFieldValue = StrTool.GBKToUnicode(this.nativePlace);
/* 1799 */       break;
/*      */     case 29:
/* 1801 */       strFieldValue = StrTool.GBKToUnicode(this.nationality);
/* 1802 */       break;
/*      */     case 30:
/* 1804 */       strFieldValue = StrTool.GBKToUnicode(this.rgtAddress);
/* 1805 */       break;
/*      */     case 31:
/* 1807 */       strFieldValue = StrTool.GBKToUnicode(this.marriage);
/* 1808 */       break;
/*      */     case 32:
/* 1810 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
/* 1811 */       break;
/*      */     case 33:
/* 1813 */       strFieldValue = StrTool.GBKToUnicode(this.health);
/* 1814 */       break;
/*      */     case 34:
/* 1816 */       strFieldValue = String.valueOf(this.stature);
/* 1817 */       break;
/*      */     case 35:
/* 1819 */       strFieldValue = String.valueOf(this.avoirdupois);
/* 1820 */       break;
/*      */     case 36:
/* 1822 */       strFieldValue = StrTool.GBKToUnicode(this.degree);
/* 1823 */       break;
/*      */     case 37:
/* 1825 */       strFieldValue = StrTool.GBKToUnicode(this.creditGrade);
/* 1826 */       break;
/*      */     case 38:
/* 1828 */       strFieldValue = StrTool.GBKToUnicode(this.bankCode);
/* 1829 */       break;
/*      */     case 39:
/* 1831 */       strFieldValue = StrTool.GBKToUnicode(this.bankAccNo);
/* 1832 */       break;
/*      */     case 40:
/* 1834 */       strFieldValue = StrTool.GBKToUnicode(this.accName);
/* 1835 */       break;
/*      */     case 41:
/* 1837 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
/* 1838 */       break;
/*      */     case 42:
/* 1840 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
/* 1841 */       break;
/*      */     case 43:
/* 1843 */       strFieldValue = StrTool.GBKToUnicode(this.position);
/* 1844 */       break;
/*      */     case 44:
/* 1846 */       strFieldValue = String.valueOf(this.salary);
/* 1847 */       break;
/*      */     case 45:
/* 1849 */       strFieldValue = StrTool.GBKToUnicode(this.occupationType);
/* 1850 */       break;
/*      */     case 46:
/* 1852 */       strFieldValue = StrTool.GBKToUnicode(this.occupationCode);
/* 1853 */       break;
/*      */     case 47:
/* 1855 */       strFieldValue = StrTool.GBKToUnicode(this.partOccupationType);
/* 1856 */       break;
/*      */     case 48:
/* 1858 */       strFieldValue = StrTool.GBKToUnicode(this.partOccupationCode);
/* 1859 */       break;
/*      */     case 49:
/* 1861 */       strFieldValue = StrTool.GBKToUnicode(this.workType);
/* 1862 */       break;
/*      */     case 50:
/* 1864 */       strFieldValue = StrTool.GBKToUnicode(this.pluralityType);
/* 1865 */       break;
/*      */     case 51:
/* 1867 */       strFieldValue = StrTool.GBKToUnicode(this.smokeFlag);
/* 1868 */       break;
/*      */     case 52:
/* 1870 */       strFieldValue = StrTool.GBKToUnicode(this.contPlanCode);
/* 1871 */       break;
/*      */     case 53:
/* 1873 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1874 */       break;
/*      */     case 54:
/* 1876 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/* 1877 */       break;
/*      */     case 55:
/* 1879 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1880 */       break;
/*      */     case 56:
/* 1882 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/* 1883 */       break;
/*      */     case 57:
/* 1885 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1886 */       break;
/*      */     case 58:
/* 1888 */       strFieldValue = String.valueOf(this.insuredPeoples);
/* 1889 */       break;
/*      */     default:
/* 1891 */       strFieldValue = "";
/*      */     }
/* 1893 */     if (strFieldValue.equals("")) {
/* 1894 */       strFieldValue = "null";
/*      */     }
/* 1896 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1902 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1903 */       return false;
/*      */     }
/* 1905 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 1907 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1909 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1912 */         this.EdorNo = null;
/*      */     }
/* 1914 */     if (FCode.equals("serialNo"))
/*      */     {
/* 1916 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1918 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/* 1921 */         this.serialNo = null;
/*      */     }
/* 1923 */     if (FCode.equals("grpContNo"))
/*      */     {
/* 1925 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1927 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1930 */         this.grpContNo = null;
/*      */     }
/* 1932 */     if (FCode.equals("contNo"))
/*      */     {
/* 1934 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1936 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 1939 */         this.contNo = null;
/*      */     }
/* 1941 */     if (FCode.equals("proposalContNo"))
/*      */     {
/* 1943 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1945 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1948 */         this.proposalContNo = null;
/*      */     }
/* 1950 */     if (FCode.equals("insuredNo"))
/*      */     {
/* 1952 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1954 */         this.insuredNo = FValue.trim();
/*      */       }
/*      */       else
/* 1957 */         this.insuredNo = null;
/*      */     }
/* 1959 */     if (FCode.equals("insuredId"))
/*      */     {
/* 1961 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1963 */         this.insuredId = FValue.trim();
/*      */       }
/*      */       else
/* 1966 */         this.insuredId = null;
/*      */     }
/* 1968 */     if (FCode.equals("prtNo"))
/*      */     {
/* 1970 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1972 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/* 1975 */         this.prtNo = null;
/*      */     }
/* 1977 */     if (FCode.equals("appntNo"))
/*      */     {
/* 1979 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1981 */         this.appntNo = FValue.trim();
/*      */       }
/*      */       else
/* 1984 */         this.appntNo = null;
/*      */     }
/* 1986 */     if (FCode.equals("appntId"))
/*      */     {
/* 1988 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1990 */         this.appntId = FValue.trim();
/*      */       }
/*      */       else
/* 1993 */         this.appntId = null;
/*      */     }
/* 1995 */     if (FCode.equals("manageCom"))
/*      */     {
/* 1997 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1999 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 2002 */         this.manageCom = null;
/*      */     }
/* 2004 */     if (FCode.equals("signCity"))
/*      */     {
/* 2006 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2008 */         this.signCity = FValue.trim();
/*      */       }
/*      */       else
/* 2011 */         this.signCity = null;
/*      */     }
/* 2013 */     if (FCode.equals("executeCom"))
/*      */     {
/* 2015 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2017 */         this.executeCom = FValue.trim();
/*      */       }
/*      */       else
/* 2020 */         this.executeCom = null;
/*      */     }
/* 2022 */     if (FCode.equals("familyID"))
/*      */     {
/* 2024 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2026 */         this.familyID = FValue.trim();
/*      */       }
/*      */       else
/* 2029 */         this.familyID = null;
/*      */     }
/* 2031 */     if (FCode.equals("relationToMainInsured"))
/*      */     {
/* 2033 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2035 */         this.relationToMainInsured = FValue.trim();
/*      */       }
/*      */       else
/* 2038 */         this.relationToMainInsured = null;
/*      */     }
/* 2040 */     if (FCode.equals("relationToAppnt"))
/*      */     {
/* 2042 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2044 */         this.relationToAppnt = FValue.trim();
/*      */       }
/*      */       else
/* 2047 */         this.relationToAppnt = null;
/*      */     }
/* 2049 */     if (FCode.equals("addressNo"))
/*      */     {
/* 2051 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2053 */         this.addressNo = FValue.trim();
/*      */       }
/*      */       else
/* 2056 */         this.addressNo = null;
/*      */     }
/* 2058 */     if (FCode.equals("sequenceNo"))
/*      */     {
/* 2060 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2062 */         this.sequenceNo = FValue.trim();
/*      */       }
/*      */       else
/* 2065 */         this.sequenceNo = null;
/*      */     }
/* 2067 */     if (FCode.equals("name"))
/*      */     {
/* 2069 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2071 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/* 2074 */         this.name = null;
/*      */     }
/* 2076 */     if (FCode.equals("appellation"))
/*      */     {
/* 2078 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2080 */         this.appellation = FValue.trim();
/*      */       }
/*      */       else
/* 2083 */         this.appellation = null;
/*      */     }
/* 2085 */     if (FCode.equals("sex"))
/*      */     {
/* 2087 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2089 */         this.sex = FValue.trim();
/*      */       }
/*      */       else
/* 2092 */         this.sex = null;
/*      */     }
/* 2094 */     if (FCode.equals("birthday"))
/*      */     {
/* 2096 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2098 */         this.birthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2101 */         this.birthday = null;
/*      */     }
/* 2103 */     if (FCode.equals("appAge"))
/*      */     {
/* 2105 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2107 */         Integer tInteger = new Integer(FValue);
/* 2108 */         int i = tInteger.intValue();
/* 2109 */         this.appAge = i;
/*      */       }
/*      */     }
/* 2112 */     if (FCode.equals("appAgetype"))
/*      */     {
/* 2114 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2116 */         this.appAgetype = FValue.trim();
/*      */       }
/*      */       else
/* 2119 */         this.appAgetype = null;
/*      */     }
/* 2121 */     if (FCode.equals("iDType"))
/*      */     {
/* 2123 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2125 */         this.iDType = FValue.trim();
/*      */       }
/*      */       else
/* 2128 */         this.iDType = null;
/*      */     }
/* 2130 */     if (FCode.equals("iDNo"))
/*      */     {
/* 2132 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2134 */         this.iDNo = FValue.trim();
/*      */       }
/*      */       else
/* 2137 */         this.iDNo = null;
/*      */     }
/* 2139 */     if (FCode.equals("iDValidity"))
/*      */     {
/* 2141 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2143 */         this.iDValidity = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2146 */         this.iDValidity = null;
/*      */     }
/* 2148 */     if (FCode.equals("iDPerpetual"))
/*      */     {
/* 2150 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2152 */         this.iDPerpetual = FValue.trim();
/*      */       }
/*      */       else
/* 2155 */         this.iDPerpetual = null;
/*      */     }
/* 2157 */     if (FCode.equals("nativePlace"))
/*      */     {
/* 2159 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2161 */         this.nativePlace = FValue.trim();
/*      */       }
/*      */       else
/* 2164 */         this.nativePlace = null;
/*      */     }
/* 2166 */     if (FCode.equals("nationality"))
/*      */     {
/* 2168 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2170 */         this.nationality = FValue.trim();
/*      */       }
/*      */       else
/* 2173 */         this.nationality = null;
/*      */     }
/* 2175 */     if (FCode.equals("rgtAddress"))
/*      */     {
/* 2177 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2179 */         this.rgtAddress = FValue.trim();
/*      */       }
/*      */       else
/* 2182 */         this.rgtAddress = null;
/*      */     }
/* 2184 */     if (FCode.equals("marriage"))
/*      */     {
/* 2186 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2188 */         this.marriage = FValue.trim();
/*      */       }
/*      */       else
/* 2191 */         this.marriage = null;
/*      */     }
/* 2193 */     if (FCode.equals("marriageDate"))
/*      */     {
/* 2195 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2197 */         this.marriageDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2200 */         this.marriageDate = null;
/*      */     }
/* 2202 */     if (FCode.equals("health"))
/*      */     {
/* 2204 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2206 */         this.health = FValue.trim();
/*      */       }
/*      */       else
/* 2209 */         this.health = null;
/*      */     }
/* 2211 */     if (FCode.equals("stature"))
/*      */     {
/* 2213 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2215 */         Double tDouble = new Double(FValue);
/* 2216 */         double d = tDouble.doubleValue();
/* 2217 */         this.stature = d;
/*      */       }
/*      */     }
/* 2220 */     if (FCode.equals("avoirdupois"))
/*      */     {
/* 2222 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2224 */         Double tDouble = new Double(FValue);
/* 2225 */         double d = tDouble.doubleValue();
/* 2226 */         this.avoirdupois = d;
/*      */       }
/*      */     }
/* 2229 */     if (FCode.equals("degree"))
/*      */     {
/* 2231 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2233 */         this.degree = FValue.trim();
/*      */       }
/*      */       else
/* 2236 */         this.degree = null;
/*      */     }
/* 2238 */     if (FCode.equals("creditGrade"))
/*      */     {
/* 2240 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2242 */         this.creditGrade = FValue.trim();
/*      */       }
/*      */       else
/* 2245 */         this.creditGrade = null;
/*      */     }
/* 2247 */     if (FCode.equals("bankCode"))
/*      */     {
/* 2249 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2251 */         this.bankCode = FValue.trim();
/*      */       }
/*      */       else
/* 2254 */         this.bankCode = null;
/*      */     }
/* 2256 */     if (FCode.equals("bankAccNo"))
/*      */     {
/* 2258 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2260 */         this.bankAccNo = FValue.trim();
/*      */       }
/*      */       else
/* 2263 */         this.bankAccNo = null;
/*      */     }
/* 2265 */     if (FCode.equals("accName"))
/*      */     {
/* 2267 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2269 */         this.accName = FValue.trim();
/*      */       }
/*      */       else
/* 2272 */         this.accName = null;
/*      */     }
/* 2274 */     if (FCode.equals("joinCompanyDate"))
/*      */     {
/* 2276 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2278 */         this.joinCompanyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2281 */         this.joinCompanyDate = null;
/*      */     }
/* 2283 */     if (FCode.equals("startWorkDate"))
/*      */     {
/* 2285 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2287 */         this.startWorkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2290 */         this.startWorkDate = null;
/*      */     }
/* 2292 */     if (FCode.equals("position"))
/*      */     {
/* 2294 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2296 */         this.position = FValue.trim();
/*      */       }
/*      */       else
/* 2299 */         this.position = null;
/*      */     }
/* 2301 */     if (FCode.equals("salary"))
/*      */     {
/* 2303 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2305 */         Double tDouble = new Double(FValue);
/* 2306 */         double d = tDouble.doubleValue();
/* 2307 */         this.salary = d;
/*      */       }
/*      */     }
/* 2310 */     if (FCode.equals("occupationType"))
/*      */     {
/* 2312 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2314 */         this.occupationType = FValue.trim();
/*      */       }
/*      */       else
/* 2317 */         this.occupationType = null;
/*      */     }
/* 2319 */     if (FCode.equals("occupationCode"))
/*      */     {
/* 2321 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2323 */         this.occupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 2326 */         this.occupationCode = null;
/*      */     }
/* 2328 */     if (FCode.equals("partOccupationType"))
/*      */     {
/* 2330 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2332 */         this.partOccupationType = FValue.trim();
/*      */       }
/*      */       else
/* 2335 */         this.partOccupationType = null;
/*      */     }
/* 2337 */     if (FCode.equals("partOccupationCode"))
/*      */     {
/* 2339 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2341 */         this.partOccupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 2344 */         this.partOccupationCode = null;
/*      */     }
/* 2346 */     if (FCode.equals("workType"))
/*      */     {
/* 2348 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2350 */         this.workType = FValue.trim();
/*      */       }
/*      */       else
/* 2353 */         this.workType = null;
/*      */     }
/* 2355 */     if (FCode.equals("pluralityType"))
/*      */     {
/* 2357 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2359 */         this.pluralityType = FValue.trim();
/*      */       }
/*      */       else
/* 2362 */         this.pluralityType = null;
/*      */     }
/* 2364 */     if (FCode.equals("smokeFlag"))
/*      */     {
/* 2366 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2368 */         this.smokeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2371 */         this.smokeFlag = null;
/*      */     }
/* 2373 */     if (FCode.equals("contPlanCode"))
/*      */     {
/* 2375 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2377 */         this.contPlanCode = FValue.trim();
/*      */       }
/*      */       else
/* 2380 */         this.contPlanCode = null;
/*      */     }
/* 2382 */     if (FCode.equals("operator"))
/*      */     {
/* 2384 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2386 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 2389 */         this.operator = null;
/*      */     }
/* 2391 */     if (FCode.equals("makeDate"))
/*      */     {
/* 2393 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2395 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2398 */         this.makeDate = null;
/*      */     }
/* 2400 */     if (FCode.equals("makeTime"))
/*      */     {
/* 2402 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2404 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 2407 */         this.makeTime = null;
/*      */     }
/* 2409 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 2411 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2413 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2416 */         this.modifyDate = null;
/*      */     }
/* 2418 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 2420 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2422 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 2425 */         this.modifyTime = null;
/*      */     }
/* 2427 */     if (FCode.equals("insuredPeoples"))
/*      */     {
/* 2429 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2431 */         Integer tInteger = new Integer(FValue);
/* 2432 */         int i = tInteger.intValue();
/* 2433 */         this.insuredPeoples = i;
/*      */       }
/*      */     }
/* 2436 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 2441 */     if (this == otherObject) return true;
/* 2442 */     if (otherObject == null) return false;
/* 2443 */     if (getClass() != otherObject.getClass()) return false;
/* 2444 */     LNPInsuredBSchema other = (LNPInsuredBSchema)otherObject;
/* 2445 */     return 
/* 2446 */       (this.EdorNo.equals(other.getEdorNo())) && 
/* 2447 */       (this.serialNo.equals(other.getserialNo())) && 
/* 2448 */       (this.grpContNo.equals(other.getgrpContNo())) && 
/* 2449 */       (this.contNo.equals(other.getcontNo())) && 
/* 2450 */       (this.proposalContNo.equals(other.getproposalContNo())) && 
/* 2451 */       (this.insuredNo.equals(other.getinsuredNo())) && 
/* 2452 */       (this.insuredId.equals(other.getinsuredId())) && 
/* 2453 */       (this.prtNo.equals(other.getprtNo())) && 
/* 2454 */       (this.appntNo.equals(other.getappntNo())) && 
/* 2455 */       (this.appntId.equals(other.getappntId())) && 
/* 2456 */       (this.manageCom.equals(other.getmanageCom())) && 
/* 2457 */       (this.signCity.equals(other.getsignCity())) && 
/* 2458 */       (this.executeCom.equals(other.getexecuteCom())) && 
/* 2459 */       (this.familyID.equals(other.getfamilyID())) && 
/* 2460 */       (this.relationToMainInsured.equals(other.getrelationToMainInsured())) && 
/* 2461 */       (this.relationToAppnt.equals(other.getrelationToAppnt())) && 
/* 2462 */       (this.addressNo.equals(other.getaddressNo())) && 
/* 2463 */       (this.sequenceNo.equals(other.getsequenceNo())) && 
/* 2464 */       (this.name.equals(other.getname())) && 
/* 2465 */       (this.appellation.equals(other.getappellation())) && 
/* 2466 */       (this.sex.equals(other.getsex())) && 
/* 2467 */       (this.fDate.getString(this.birthday).equals(other.getbirthday())) && 
/* 2468 */       (this.appAge == other.getappAge()) && 
/* 2469 */       (this.appAgetype.equals(other.getappAgetype())) && 
/* 2470 */       (this.iDType.equals(other.getiDType())) && 
/* 2471 */       (this.iDNo.equals(other.getiDNo())) && 
/* 2472 */       (this.fDate.getString(this.iDValidity).equals(other.getiDValidity())) && 
/* 2473 */       (this.iDPerpetual.equals(other.getiDPerpetual())) && 
/* 2474 */       (this.nativePlace.equals(other.getnativePlace())) && 
/* 2475 */       (this.nationality.equals(other.getnationality())) && 
/* 2476 */       (this.rgtAddress.equals(other.getrgtAddress())) && 
/* 2477 */       (this.marriage.equals(other.getmarriage())) && 
/* 2478 */       (this.fDate.getString(this.marriageDate).equals(other.getmarriageDate())) && 
/* 2479 */       (this.health.equals(other.gethealth())) && 
/* 2480 */       (this.stature == other.getstature()) && 
/* 2481 */       (this.avoirdupois == other.getavoirdupois()) && 
/* 2482 */       (this.degree.equals(other.getdegree())) && 
/* 2483 */       (this.creditGrade.equals(other.getcreditGrade())) && 
/* 2484 */       (this.bankCode.equals(other.getbankCode())) && 
/* 2485 */       (this.bankAccNo.equals(other.getbankAccNo())) && 
/* 2486 */       (this.accName.equals(other.getaccName())) && 
/* 2487 */       (this.fDate.getString(this.joinCompanyDate).equals(other.getjoinCompanyDate())) && 
/* 2488 */       (this.fDate.getString(this.startWorkDate).equals(other.getstartWorkDate())) && 
/* 2489 */       (this.position.equals(other.getposition())) && 
/* 2490 */       (this.salary == other.getsalary()) && 
/* 2491 */       (this.occupationType.equals(other.getoccupationType())) && 
/* 2492 */       (this.occupationCode.equals(other.getoccupationCode())) && 
/* 2493 */       (this.partOccupationType.equals(other.getpartOccupationType())) && 
/* 2494 */       (this.partOccupationCode.equals(other.getpartOccupationCode())) && 
/* 2495 */       (this.workType.equals(other.getworkType())) && 
/* 2496 */       (this.pluralityType.equals(other.getpluralityType())) && 
/* 2497 */       (this.smokeFlag.equals(other.getsmokeFlag())) && 
/* 2498 */       (this.contPlanCode.equals(other.getcontPlanCode())) && 
/* 2499 */       (this.operator.equals(other.getoperator())) && 
/* 2500 */       (this.fDate.getString(this.makeDate).equals(other.getmakeDate())) && 
/* 2501 */       (this.makeTime.equals(other.getmakeTime())) && 
/* 2502 */       (this.fDate.getString(this.modifyDate).equals(other.getmodifyDate())) && 
/* 2503 */       (this.modifyTime.equals(other.getmodifyTime())) && 
/* 2504 */       (this.insuredPeoples == other.getinsuredPeoples());
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2510 */     return 59;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2516 */     if (strFieldName.equals("EdorNo")) {
/* 2517 */       return 0;
/*      */     }
/* 2519 */     if (strFieldName.equals("serialNo")) {
/* 2520 */       return 1;
/*      */     }
/* 2522 */     if (strFieldName.equals("grpContNo")) {
/* 2523 */       return 2;
/*      */     }
/* 2525 */     if (strFieldName.equals("contNo")) {
/* 2526 */       return 3;
/*      */     }
/* 2528 */     if (strFieldName.equals("proposalContNo")) {
/* 2529 */       return 4;
/*      */     }
/* 2531 */     if (strFieldName.equals("insuredNo")) {
/* 2532 */       return 5;
/*      */     }
/* 2534 */     if (strFieldName.equals("insuredId")) {
/* 2535 */       return 6;
/*      */     }
/* 2537 */     if (strFieldName.equals("prtNo")) {
/* 2538 */       return 7;
/*      */     }
/* 2540 */     if (strFieldName.equals("appntNo")) {
/* 2541 */       return 8;
/*      */     }
/* 2543 */     if (strFieldName.equals("appntId")) {
/* 2544 */       return 9;
/*      */     }
/* 2546 */     if (strFieldName.equals("manageCom")) {
/* 2547 */       return 10;
/*      */     }
/* 2549 */     if (strFieldName.equals("signCity")) {
/* 2550 */       return 11;
/*      */     }
/* 2552 */     if (strFieldName.equals("executeCom")) {
/* 2553 */       return 12;
/*      */     }
/* 2555 */     if (strFieldName.equals("familyID")) {
/* 2556 */       return 13;
/*      */     }
/* 2558 */     if (strFieldName.equals("relationToMainInsured")) {
/* 2559 */       return 14;
/*      */     }
/* 2561 */     if (strFieldName.equals("relationToAppnt")) {
/* 2562 */       return 15;
/*      */     }
/* 2564 */     if (strFieldName.equals("addressNo")) {
/* 2565 */       return 16;
/*      */     }
/* 2567 */     if (strFieldName.equals("sequenceNo")) {
/* 2568 */       return 17;
/*      */     }
/* 2570 */     if (strFieldName.equals("name")) {
/* 2571 */       return 18;
/*      */     }
/* 2573 */     if (strFieldName.equals("appellation")) {
/* 2574 */       return 19;
/*      */     }
/* 2576 */     if (strFieldName.equals("sex")) {
/* 2577 */       return 20;
/*      */     }
/* 2579 */     if (strFieldName.equals("birthday")) {
/* 2580 */       return 21;
/*      */     }
/* 2582 */     if (strFieldName.equals("appAge")) {
/* 2583 */       return 22;
/*      */     }
/* 2585 */     if (strFieldName.equals("appAgetype")) {
/* 2586 */       return 23;
/*      */     }
/* 2588 */     if (strFieldName.equals("iDType")) {
/* 2589 */       return 24;
/*      */     }
/* 2591 */     if (strFieldName.equals("iDNo")) {
/* 2592 */       return 25;
/*      */     }
/* 2594 */     if (strFieldName.equals("iDValidity")) {
/* 2595 */       return 26;
/*      */     }
/* 2597 */     if (strFieldName.equals("iDPerpetual")) {
/* 2598 */       return 27;
/*      */     }
/* 2600 */     if (strFieldName.equals("nativePlace")) {
/* 2601 */       return 28;
/*      */     }
/* 2603 */     if (strFieldName.equals("nationality")) {
/* 2604 */       return 29;
/*      */     }
/* 2606 */     if (strFieldName.equals("rgtAddress")) {
/* 2607 */       return 30;
/*      */     }
/* 2609 */     if (strFieldName.equals("marriage")) {
/* 2610 */       return 31;
/*      */     }
/* 2612 */     if (strFieldName.equals("marriageDate")) {
/* 2613 */       return 32;
/*      */     }
/* 2615 */     if (strFieldName.equals("health")) {
/* 2616 */       return 33;
/*      */     }
/* 2618 */     if (strFieldName.equals("stature")) {
/* 2619 */       return 34;
/*      */     }
/* 2621 */     if (strFieldName.equals("avoirdupois")) {
/* 2622 */       return 35;
/*      */     }
/* 2624 */     if (strFieldName.equals("degree")) {
/* 2625 */       return 36;
/*      */     }
/* 2627 */     if (strFieldName.equals("creditGrade")) {
/* 2628 */       return 37;
/*      */     }
/* 2630 */     if (strFieldName.equals("bankCode")) {
/* 2631 */       return 38;
/*      */     }
/* 2633 */     if (strFieldName.equals("bankAccNo")) {
/* 2634 */       return 39;
/*      */     }
/* 2636 */     if (strFieldName.equals("accName")) {
/* 2637 */       return 40;
/*      */     }
/* 2639 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2640 */       return 41;
/*      */     }
/* 2642 */     if (strFieldName.equals("startWorkDate")) {
/* 2643 */       return 42;
/*      */     }
/* 2645 */     if (strFieldName.equals("position")) {
/* 2646 */       return 43;
/*      */     }
/* 2648 */     if (strFieldName.equals("salary")) {
/* 2649 */       return 44;
/*      */     }
/* 2651 */     if (strFieldName.equals("occupationType")) {
/* 2652 */       return 45;
/*      */     }
/* 2654 */     if (strFieldName.equals("occupationCode")) {
/* 2655 */       return 46;
/*      */     }
/* 2657 */     if (strFieldName.equals("partOccupationType")) {
/* 2658 */       return 47;
/*      */     }
/* 2660 */     if (strFieldName.equals("partOccupationCode")) {
/* 2661 */       return 48;
/*      */     }
/* 2663 */     if (strFieldName.equals("workType")) {
/* 2664 */       return 49;
/*      */     }
/* 2666 */     if (strFieldName.equals("pluralityType")) {
/* 2667 */       return 50;
/*      */     }
/* 2669 */     if (strFieldName.equals("smokeFlag")) {
/* 2670 */       return 51;
/*      */     }
/* 2672 */     if (strFieldName.equals("contPlanCode")) {
/* 2673 */       return 52;
/*      */     }
/* 2675 */     if (strFieldName.equals("operator")) {
/* 2676 */       return 53;
/*      */     }
/* 2678 */     if (strFieldName.equals("makeDate")) {
/* 2679 */       return 54;
/*      */     }
/* 2681 */     if (strFieldName.equals("makeTime")) {
/* 2682 */       return 55;
/*      */     }
/* 2684 */     if (strFieldName.equals("modifyDate")) {
/* 2685 */       return 56;
/*      */     }
/* 2687 */     if (strFieldName.equals("modifyTime")) {
/* 2688 */       return 57;
/*      */     }
/* 2690 */     if (strFieldName.equals("insuredPeoples")) {
/* 2691 */       return 58;
/*      */     }
/* 2693 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2699 */     String strFieldName = "";
/* 2700 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2702 */       strFieldName = "EdorNo";
/* 2703 */       break;
/*      */     case 1:
/* 2705 */       strFieldName = "serialNo";
/* 2706 */       break;
/*      */     case 2:
/* 2708 */       strFieldName = "grpContNo";
/* 2709 */       break;
/*      */     case 3:
/* 2711 */       strFieldName = "contNo";
/* 2712 */       break;
/*      */     case 4:
/* 2714 */       strFieldName = "proposalContNo";
/* 2715 */       break;
/*      */     case 5:
/* 2717 */       strFieldName = "insuredNo";
/* 2718 */       break;
/*      */     case 6:
/* 2720 */       strFieldName = "insuredId";
/* 2721 */       break;
/*      */     case 7:
/* 2723 */       strFieldName = "prtNo";
/* 2724 */       break;
/*      */     case 8:
/* 2726 */       strFieldName = "appntNo";
/* 2727 */       break;
/*      */     case 9:
/* 2729 */       strFieldName = "appntId";
/* 2730 */       break;
/*      */     case 10:
/* 2732 */       strFieldName = "manageCom";
/* 2733 */       break;
/*      */     case 11:
/* 2735 */       strFieldName = "signCity";
/* 2736 */       break;
/*      */     case 12:
/* 2738 */       strFieldName = "executeCom";
/* 2739 */       break;
/*      */     case 13:
/* 2741 */       strFieldName = "familyID";
/* 2742 */       break;
/*      */     case 14:
/* 2744 */       strFieldName = "relationToMainInsured";
/* 2745 */       break;
/*      */     case 15:
/* 2747 */       strFieldName = "relationToAppnt";
/* 2748 */       break;
/*      */     case 16:
/* 2750 */       strFieldName = "addressNo";
/* 2751 */       break;
/*      */     case 17:
/* 2753 */       strFieldName = "sequenceNo";
/* 2754 */       break;
/*      */     case 18:
/* 2756 */       strFieldName = "name";
/* 2757 */       break;
/*      */     case 19:
/* 2759 */       strFieldName = "appellation";
/* 2760 */       break;
/*      */     case 20:
/* 2762 */       strFieldName = "sex";
/* 2763 */       break;
/*      */     case 21:
/* 2765 */       strFieldName = "birthday";
/* 2766 */       break;
/*      */     case 22:
/* 2768 */       strFieldName = "appAge";
/* 2769 */       break;
/*      */     case 23:
/* 2771 */       strFieldName = "appAgetype";
/* 2772 */       break;
/*      */     case 24:
/* 2774 */       strFieldName = "iDType";
/* 2775 */       break;
/*      */     case 25:
/* 2777 */       strFieldName = "iDNo";
/* 2778 */       break;
/*      */     case 26:
/* 2780 */       strFieldName = "iDValidity";
/* 2781 */       break;
/*      */     case 27:
/* 2783 */       strFieldName = "iDPerpetual";
/* 2784 */       break;
/*      */     case 28:
/* 2786 */       strFieldName = "nativePlace";
/* 2787 */       break;
/*      */     case 29:
/* 2789 */       strFieldName = "nationality";
/* 2790 */       break;
/*      */     case 30:
/* 2792 */       strFieldName = "rgtAddress";
/* 2793 */       break;
/*      */     case 31:
/* 2795 */       strFieldName = "marriage";
/* 2796 */       break;
/*      */     case 32:
/* 2798 */       strFieldName = "marriageDate";
/* 2799 */       break;
/*      */     case 33:
/* 2801 */       strFieldName = "health";
/* 2802 */       break;
/*      */     case 34:
/* 2804 */       strFieldName = "stature";
/* 2805 */       break;
/*      */     case 35:
/* 2807 */       strFieldName = "avoirdupois";
/* 2808 */       break;
/*      */     case 36:
/* 2810 */       strFieldName = "degree";
/* 2811 */       break;
/*      */     case 37:
/* 2813 */       strFieldName = "creditGrade";
/* 2814 */       break;
/*      */     case 38:
/* 2816 */       strFieldName = "bankCode";
/* 2817 */       break;
/*      */     case 39:
/* 2819 */       strFieldName = "bankAccNo";
/* 2820 */       break;
/*      */     case 40:
/* 2822 */       strFieldName = "accName";
/* 2823 */       break;
/*      */     case 41:
/* 2825 */       strFieldName = "joinCompanyDate";
/* 2826 */       break;
/*      */     case 42:
/* 2828 */       strFieldName = "startWorkDate";
/* 2829 */       break;
/*      */     case 43:
/* 2831 */       strFieldName = "position";
/* 2832 */       break;
/*      */     case 44:
/* 2834 */       strFieldName = "salary";
/* 2835 */       break;
/*      */     case 45:
/* 2837 */       strFieldName = "occupationType";
/* 2838 */       break;
/*      */     case 46:
/* 2840 */       strFieldName = "occupationCode";
/* 2841 */       break;
/*      */     case 47:
/* 2843 */       strFieldName = "partOccupationType";
/* 2844 */       break;
/*      */     case 48:
/* 2846 */       strFieldName = "partOccupationCode";
/* 2847 */       break;
/*      */     case 49:
/* 2849 */       strFieldName = "workType";
/* 2850 */       break;
/*      */     case 50:
/* 2852 */       strFieldName = "pluralityType";
/* 2853 */       break;
/*      */     case 51:
/* 2855 */       strFieldName = "smokeFlag";
/* 2856 */       break;
/*      */     case 52:
/* 2858 */       strFieldName = "contPlanCode";
/* 2859 */       break;
/*      */     case 53:
/* 2861 */       strFieldName = "operator";
/* 2862 */       break;
/*      */     case 54:
/* 2864 */       strFieldName = "makeDate";
/* 2865 */       break;
/*      */     case 55:
/* 2867 */       strFieldName = "makeTime";
/* 2868 */       break;
/*      */     case 56:
/* 2870 */       strFieldName = "modifyDate";
/* 2871 */       break;
/*      */     case 57:
/* 2873 */       strFieldName = "modifyTime";
/* 2874 */       break;
/*      */     case 58:
/* 2876 */       strFieldName = "insuredPeoples";
/* 2877 */       break;
/*      */     default:
/* 2879 */       strFieldName = "";
/*      */     }
/* 2881 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2887 */     if (strFieldName.equals("EdorNo")) {
/* 2888 */       return 0;
/*      */     }
/* 2890 */     if (strFieldName.equals("serialNo")) {
/* 2891 */       return 0;
/*      */     }
/* 2893 */     if (strFieldName.equals("grpContNo")) {
/* 2894 */       return 0;
/*      */     }
/* 2896 */     if (strFieldName.equals("contNo")) {
/* 2897 */       return 0;
/*      */     }
/* 2899 */     if (strFieldName.equals("proposalContNo")) {
/* 2900 */       return 0;
/*      */     }
/* 2902 */     if (strFieldName.equals("insuredNo")) {
/* 2903 */       return 0;
/*      */     }
/* 2905 */     if (strFieldName.equals("insuredId")) {
/* 2906 */       return 0;
/*      */     }
/* 2908 */     if (strFieldName.equals("prtNo")) {
/* 2909 */       return 0;
/*      */     }
/* 2911 */     if (strFieldName.equals("appntNo")) {
/* 2912 */       return 0;
/*      */     }
/* 2914 */     if (strFieldName.equals("appntId")) {
/* 2915 */       return 0;
/*      */     }
/* 2917 */     if (strFieldName.equals("manageCom")) {
/* 2918 */       return 0;
/*      */     }
/* 2920 */     if (strFieldName.equals("signCity")) {
/* 2921 */       return 0;
/*      */     }
/* 2923 */     if (strFieldName.equals("executeCom")) {
/* 2924 */       return 0;
/*      */     }
/* 2926 */     if (strFieldName.equals("familyID")) {
/* 2927 */       return 0;
/*      */     }
/* 2929 */     if (strFieldName.equals("relationToMainInsured")) {
/* 2930 */       return 0;
/*      */     }
/* 2932 */     if (strFieldName.equals("relationToAppnt")) {
/* 2933 */       return 0;
/*      */     }
/* 2935 */     if (strFieldName.equals("addressNo")) {
/* 2936 */       return 0;
/*      */     }
/* 2938 */     if (strFieldName.equals("sequenceNo")) {
/* 2939 */       return 0;
/*      */     }
/* 2941 */     if (strFieldName.equals("name")) {
/* 2942 */       return 0;
/*      */     }
/* 2944 */     if (strFieldName.equals("appellation")) {
/* 2945 */       return 0;
/*      */     }
/* 2947 */     if (strFieldName.equals("sex")) {
/* 2948 */       return 0;
/*      */     }
/* 2950 */     if (strFieldName.equals("birthday")) {
/* 2951 */       return 1;
/*      */     }
/* 2953 */     if (strFieldName.equals("appAge")) {
/* 2954 */       return 3;
/*      */     }
/* 2956 */     if (strFieldName.equals("appAgetype")) {
/* 2957 */       return 0;
/*      */     }
/* 2959 */     if (strFieldName.equals("iDType")) {
/* 2960 */       return 0;
/*      */     }
/* 2962 */     if (strFieldName.equals("iDNo")) {
/* 2963 */       return 0;
/*      */     }
/* 2965 */     if (strFieldName.equals("iDValidity")) {
/* 2966 */       return 1;
/*      */     }
/* 2968 */     if (strFieldName.equals("iDPerpetual")) {
/* 2969 */       return 0;
/*      */     }
/* 2971 */     if (strFieldName.equals("nativePlace")) {
/* 2972 */       return 0;
/*      */     }
/* 2974 */     if (strFieldName.equals("nationality")) {
/* 2975 */       return 0;
/*      */     }
/* 2977 */     if (strFieldName.equals("rgtAddress")) {
/* 2978 */       return 0;
/*      */     }
/* 2980 */     if (strFieldName.equals("marriage")) {
/* 2981 */       return 0;
/*      */     }
/* 2983 */     if (strFieldName.equals("marriageDate")) {
/* 2984 */       return 1;
/*      */     }
/* 2986 */     if (strFieldName.equals("health")) {
/* 2987 */       return 0;
/*      */     }
/* 2989 */     if (strFieldName.equals("stature")) {
/* 2990 */       return 4;
/*      */     }
/* 2992 */     if (strFieldName.equals("avoirdupois")) {
/* 2993 */       return 4;
/*      */     }
/* 2995 */     if (strFieldName.equals("degree")) {
/* 2996 */       return 0;
/*      */     }
/* 2998 */     if (strFieldName.equals("creditGrade")) {
/* 2999 */       return 0;
/*      */     }
/* 3001 */     if (strFieldName.equals("bankCode")) {
/* 3002 */       return 0;
/*      */     }
/* 3004 */     if (strFieldName.equals("bankAccNo")) {
/* 3005 */       return 0;
/*      */     }
/* 3007 */     if (strFieldName.equals("accName")) {
/* 3008 */       return 0;
/*      */     }
/* 3010 */     if (strFieldName.equals("joinCompanyDate")) {
/* 3011 */       return 1;
/*      */     }
/* 3013 */     if (strFieldName.equals("startWorkDate")) {
/* 3014 */       return 1;
/*      */     }
/* 3016 */     if (strFieldName.equals("position")) {
/* 3017 */       return 0;
/*      */     }
/* 3019 */     if (strFieldName.equals("salary")) {
/* 3020 */       return 4;
/*      */     }
/* 3022 */     if (strFieldName.equals("occupationType")) {
/* 3023 */       return 0;
/*      */     }
/* 3025 */     if (strFieldName.equals("occupationCode")) {
/* 3026 */       return 0;
/*      */     }
/* 3028 */     if (strFieldName.equals("partOccupationType")) {
/* 3029 */       return 0;
/*      */     }
/* 3031 */     if (strFieldName.equals("partOccupationCode")) {
/* 3032 */       return 0;
/*      */     }
/* 3034 */     if (strFieldName.equals("workType")) {
/* 3035 */       return 0;
/*      */     }
/* 3037 */     if (strFieldName.equals("pluralityType")) {
/* 3038 */       return 0;
/*      */     }
/* 3040 */     if (strFieldName.equals("smokeFlag")) {
/* 3041 */       return 0;
/*      */     }
/* 3043 */     if (strFieldName.equals("contPlanCode")) {
/* 3044 */       return 0;
/*      */     }
/* 3046 */     if (strFieldName.equals("operator")) {
/* 3047 */       return 0;
/*      */     }
/* 3049 */     if (strFieldName.equals("makeDate")) {
/* 3050 */       return 1;
/*      */     }
/* 3052 */     if (strFieldName.equals("makeTime")) {
/* 3053 */       return 0;
/*      */     }
/* 3055 */     if (strFieldName.equals("modifyDate")) {
/* 3056 */       return 1;
/*      */     }
/* 3058 */     if (strFieldName.equals("modifyTime")) {
/* 3059 */       return 0;
/*      */     }
/* 3061 */     if (strFieldName.equals("insuredPeoples")) {
/* 3062 */       return 3;
/*      */     }
/* 3064 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 3070 */     int nFieldType = -1;
/* 3071 */     switch (nFieldIndex) {
/*      */     case 0:
/* 3073 */       nFieldType = 0;
/* 3074 */       break;
/*      */     case 1:
/* 3076 */       nFieldType = 0;
/* 3077 */       break;
/*      */     case 2:
/* 3079 */       nFieldType = 0;
/* 3080 */       break;
/*      */     case 3:
/* 3082 */       nFieldType = 0;
/* 3083 */       break;
/*      */     case 4:
/* 3085 */       nFieldType = 0;
/* 3086 */       break;
/*      */     case 5:
/* 3088 */       nFieldType = 0;
/* 3089 */       break;
/*      */     case 6:
/* 3091 */       nFieldType = 0;
/* 3092 */       break;
/*      */     case 7:
/* 3094 */       nFieldType = 0;
/* 3095 */       break;
/*      */     case 8:
/* 3097 */       nFieldType = 0;
/* 3098 */       break;
/*      */     case 9:
/* 3100 */       nFieldType = 0;
/* 3101 */       break;
/*      */     case 10:
/* 3103 */       nFieldType = 0;
/* 3104 */       break;
/*      */     case 11:
/* 3106 */       nFieldType = 0;
/* 3107 */       break;
/*      */     case 12:
/* 3109 */       nFieldType = 0;
/* 3110 */       break;
/*      */     case 13:
/* 3112 */       nFieldType = 0;
/* 3113 */       break;
/*      */     case 14:
/* 3115 */       nFieldType = 0;
/* 3116 */       break;
/*      */     case 15:
/* 3118 */       nFieldType = 0;
/* 3119 */       break;
/*      */     case 16:
/* 3121 */       nFieldType = 0;
/* 3122 */       break;
/*      */     case 17:
/* 3124 */       nFieldType = 0;
/* 3125 */       break;
/*      */     case 18:
/* 3127 */       nFieldType = 0;
/* 3128 */       break;
/*      */     case 19:
/* 3130 */       nFieldType = 0;
/* 3131 */       break;
/*      */     case 20:
/* 3133 */       nFieldType = 0;
/* 3134 */       break;
/*      */     case 21:
/* 3136 */       nFieldType = 1;
/* 3137 */       break;
/*      */     case 22:
/* 3139 */       nFieldType = 3;
/* 3140 */       break;
/*      */     case 23:
/* 3142 */       nFieldType = 0;
/* 3143 */       break;
/*      */     case 24:
/* 3145 */       nFieldType = 0;
/* 3146 */       break;
/*      */     case 25:
/* 3148 */       nFieldType = 0;
/* 3149 */       break;
/*      */     case 26:
/* 3151 */       nFieldType = 1;
/* 3152 */       break;
/*      */     case 27:
/* 3154 */       nFieldType = 0;
/* 3155 */       break;
/*      */     case 28:
/* 3157 */       nFieldType = 0;
/* 3158 */       break;
/*      */     case 29:
/* 3160 */       nFieldType = 0;
/* 3161 */       break;
/*      */     case 30:
/* 3163 */       nFieldType = 0;
/* 3164 */       break;
/*      */     case 31:
/* 3166 */       nFieldType = 0;
/* 3167 */       break;
/*      */     case 32:
/* 3169 */       nFieldType = 1;
/* 3170 */       break;
/*      */     case 33:
/* 3172 */       nFieldType = 0;
/* 3173 */       break;
/*      */     case 34:
/* 3175 */       nFieldType = 4;
/* 3176 */       break;
/*      */     case 35:
/* 3178 */       nFieldType = 4;
/* 3179 */       break;
/*      */     case 36:
/* 3181 */       nFieldType = 0;
/* 3182 */       break;
/*      */     case 37:
/* 3184 */       nFieldType = 0;
/* 3185 */       break;
/*      */     case 38:
/* 3187 */       nFieldType = 0;
/* 3188 */       break;
/*      */     case 39:
/* 3190 */       nFieldType = 0;
/* 3191 */       break;
/*      */     case 40:
/* 3193 */       nFieldType = 0;
/* 3194 */       break;
/*      */     case 41:
/* 3196 */       nFieldType = 1;
/* 3197 */       break;
/*      */     case 42:
/* 3199 */       nFieldType = 1;
/* 3200 */       break;
/*      */     case 43:
/* 3202 */       nFieldType = 0;
/* 3203 */       break;
/*      */     case 44:
/* 3205 */       nFieldType = 4;
/* 3206 */       break;
/*      */     case 45:
/* 3208 */       nFieldType = 0;
/* 3209 */       break;
/*      */     case 46:
/* 3211 */       nFieldType = 0;
/* 3212 */       break;
/*      */     case 47:
/* 3214 */       nFieldType = 0;
/* 3215 */       break;
/*      */     case 48:
/* 3217 */       nFieldType = 0;
/* 3218 */       break;
/*      */     case 49:
/* 3220 */       nFieldType = 0;
/* 3221 */       break;
/*      */     case 50:
/* 3223 */       nFieldType = 0;
/* 3224 */       break;
/*      */     case 51:
/* 3226 */       nFieldType = 0;
/* 3227 */       break;
/*      */     case 52:
/* 3229 */       nFieldType = 0;
/* 3230 */       break;
/*      */     case 53:
/* 3232 */       nFieldType = 0;
/* 3233 */       break;
/*      */     case 54:
/* 3235 */       nFieldType = 1;
/* 3236 */       break;
/*      */     case 55:
/* 3238 */       nFieldType = 0;
/* 3239 */       break;
/*      */     case 56:
/* 3241 */       nFieldType = 1;
/* 3242 */       break;
/*      */     case 57:
/* 3244 */       nFieldType = 0;
/* 3245 */       break;
/*      */     case 58:
/* 3247 */       nFieldType = 3;
/* 3248 */       break;
/*      */     default:
/* 3250 */       nFieldType = -1;
/*      */     }
/* 3252 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPInsuredBSchema
 * JD-Core Version:    0.6.0
 */