/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAppntBDB;
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
/*      */ public class LNPAppntBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
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
/*      */   public static final int FIELDNUM = 51;
/*      */   private static String[] PK;
/*  127 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPAppntBSchema()
/*      */   {
/*  134 */     this.mErrors = new CErrors();
/*      */ 
/*  136 */     String[] pk = new String[2];
/*  137 */     pk[0] = "EdorNo";
/*  138 */     pk[1] = "serialNo";
/*      */ 
/*  140 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  146 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  151 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*  155 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  159 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*  163 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  167 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  171 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getgrpContNo() {
/*  175 */     if (this.grpContNo != null) this.grpContNo.equals("");
/*      */ 
/*  179 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setgrpContNo(String agrpContNo) {
/*  183 */     this.grpContNo = agrpContNo;
/*      */   }
/*      */ 
/*      */   public String getcontNo() {
/*  187 */     if (this.contNo != null) this.contNo.equals("");
/*      */ 
/*  191 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setcontNo(String acontNo) {
/*  195 */     this.contNo = acontNo;
/*      */   }
/*      */ 
/*      */   public String getproposalContNo() {
/*  199 */     if (this.proposalContNo != null) this.proposalContNo.equals("");
/*      */ 
/*  203 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setproposalContNo(String aproposalContNo) {
/*  207 */     this.proposalContNo = aproposalContNo;
/*      */   }
/*      */ 
/*      */   public String getprtNo() {
/*  211 */     if (this.prtNo != null) this.prtNo.equals("");
/*      */ 
/*  215 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setprtNo(String aprtNo) {
/*  219 */     this.prtNo = aprtNo;
/*      */   }
/*      */ 
/*      */   public String getappntNo() {
/*  223 */     if (this.appntNo != null) this.appntNo.equals("");
/*      */ 
/*  227 */     return this.appntNo;
/*      */   }
/*      */ 
/*      */   public void setappntNo(String aappntNo) {
/*  231 */     this.appntNo = aappntNo;
/*      */   }
/*      */ 
/*      */   public String getappntId() {
/*  235 */     if (this.appntId != null) this.appntId.equals("");
/*      */ 
/*  239 */     return this.appntId;
/*      */   }
/*      */ 
/*      */   public void setappntId(String aappntId) {
/*  243 */     this.appntId = aappntId;
/*      */   }
/*      */ 
/*      */   public String getrelationToInsured() {
/*  247 */     if (this.relationToInsured != null) this.relationToInsured.equals("");
/*      */ 
/*  251 */     return this.relationToInsured;
/*      */   }
/*      */ 
/*      */   public void setrelationToInsured(String arelationToInsured) {
/*  255 */     this.relationToInsured = arelationToInsured;
/*      */   }
/*      */ 
/*      */   public String getappntGrade() {
/*  259 */     if (this.appntGrade != null) this.appntGrade.equals("");
/*      */ 
/*  263 */     return this.appntGrade;
/*      */   }
/*      */ 
/*      */   public void setappntGrade(String aappntGrade) {
/*  267 */     this.appntGrade = aappntGrade;
/*      */   }
/*      */ 
/*      */   public String getappellation() {
/*  271 */     if (this.appellation != null) this.appellation.equals("");
/*      */ 
/*  275 */     return this.appellation;
/*      */   }
/*      */ 
/*      */   public void setappellation(String aappellation) {
/*  279 */     this.appellation = aappellation;
/*      */   }
/*      */ 
/*      */   public String getappntName() {
/*  283 */     if (this.appntName != null) this.appntName.equals("");
/*      */ 
/*  287 */     return this.appntName;
/*      */   }
/*      */ 
/*      */   public void setappntName(String aappntName) {
/*  291 */     this.appntName = aappntName;
/*      */   }
/*      */ 
/*      */   public String getappntSex() {
/*  295 */     if (this.appntSex != null) this.appntSex.equals("");
/*      */ 
/*  299 */     return this.appntSex;
/*      */   }
/*      */ 
/*      */   public void setappntSex(String aappntSex) {
/*  303 */     this.appntSex = aappntSex;
/*      */   }
/*      */ 
/*      */   public String getappntBirthday() {
/*  307 */     if (this.appntBirthday != null) {
/*  308 */       return this.fDate.getString(this.appntBirthday);
/*      */     }
/*  310 */     return null;
/*      */   }
/*      */ 
/*      */   public void setappntBirthday(Date aappntBirthday) {
/*  314 */     this.appntBirthday = aappntBirthday;
/*      */   }
/*      */ 
/*      */   public void setappntBirthday(String aappntBirthday) {
/*  318 */     if ((aappntBirthday != null) && (!aappntBirthday.equals("")))
/*      */     {
/*  320 */       this.appntBirthday = this.fDate.getDate(aappntBirthday);
/*      */     }
/*      */     else
/*  323 */       this.appntBirthday = null;
/*      */   }
/*      */ 
/*      */   public int getappntAge()
/*      */   {
/*  328 */     return this.appntAge;
/*      */   }
/*      */ 
/*      */   public void setappntAge(int aappntAge) {
/*  332 */     this.appntAge = aappntAge;
/*      */   }
/*      */ 
/*      */   public void setappntAge(String aappntAge) {
/*  336 */     if ((aappntAge != null) && (!aappntAge.equals("")))
/*      */     {
/*  338 */       Integer tInteger = new Integer(aappntAge);
/*  339 */       int i = tInteger.intValue();
/*  340 */       this.appntAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getappntAgeType()
/*      */   {
/*  346 */     if (this.appntAgeType != null) this.appntAgeType.equals("");
/*      */ 
/*  350 */     return this.appntAgeType;
/*      */   }
/*      */ 
/*      */   public void setappntAgeType(String aappntAgeType) {
/*  354 */     this.appntAgeType = aappntAgeType;
/*      */   }
/*      */ 
/*      */   public String getappntType() {
/*  358 */     if (this.appntType != null) this.appntType.equals("");
/*      */ 
/*  362 */     return this.appntType;
/*      */   }
/*      */ 
/*      */   public void setappntType(String aappntType) {
/*  366 */     this.appntType = aappntType;
/*      */   }
/*      */ 
/*      */   public String getaddressNo() {
/*  370 */     if (this.addressNo != null) this.addressNo.equals("");
/*      */ 
/*  374 */     return this.addressNo;
/*      */   }
/*      */ 
/*      */   public void setaddressNo(String aaddressNo) {
/*  378 */     this.addressNo = aaddressNo;
/*      */   }
/*      */ 
/*      */   public String getsequenceNo() {
/*  382 */     if (this.sequenceNo != null) this.sequenceNo.equals("");
/*      */ 
/*  386 */     return this.sequenceNo;
/*      */   }
/*      */ 
/*      */   public void setsequenceNo(String asequenceNo) {
/*  390 */     this.sequenceNo = asequenceNo;
/*      */   }
/*      */ 
/*      */   public String getiDType() {
/*  394 */     if (this.iDType != null) this.iDType.equals("");
/*      */ 
/*  398 */     return this.iDType;
/*      */   }
/*      */ 
/*      */   public void setiDType(String aiDType) {
/*  402 */     this.iDType = aiDType;
/*      */   }
/*      */ 
/*      */   public String getiDNo() {
/*  406 */     if (this.iDNo != null) this.iDNo.equals("");
/*      */ 
/*  410 */     return this.iDNo;
/*      */   }
/*      */ 
/*      */   public void setiDNo(String aiDNo) {
/*  414 */     this.iDNo = aiDNo;
/*      */   }
/*      */ 
/*      */   public String getiDValidity() {
/*  418 */     if (this.iDValidity != null) {
/*  419 */       return this.fDate.getString(this.iDValidity);
/*      */     }
/*  421 */     return null;
/*      */   }
/*      */ 
/*      */   public void setiDValidity(Date aiDValidity) {
/*  425 */     this.iDValidity = aiDValidity;
/*      */   }
/*      */ 
/*      */   public void setiDValidity(String aiDValidity) {
/*  429 */     if ((aiDValidity != null) && (!aiDValidity.equals("")))
/*      */     {
/*  431 */       this.iDValidity = this.fDate.getDate(aiDValidity);
/*      */     }
/*      */     else
/*  434 */       this.iDValidity = null;
/*      */   }
/*      */ 
/*      */   public String getiDPerpetual()
/*      */   {
/*  439 */     if (this.iDPerpetual != null) this.iDPerpetual.equals("");
/*      */ 
/*  443 */     return this.iDPerpetual;
/*      */   }
/*      */ 
/*      */   public void setiDPerpetual(String aiDPerpetual) {
/*  447 */     this.iDPerpetual = aiDPerpetual;
/*      */   }
/*      */ 
/*      */   public String getnativePlace() {
/*  451 */     if (this.nativePlace != null) this.nativePlace.equals("");
/*      */ 
/*  455 */     return this.nativePlace;
/*      */   }
/*      */ 
/*      */   public void setnativePlace(String anativePlace) {
/*  459 */     this.nativePlace = anativePlace;
/*      */   }
/*      */ 
/*      */   public String getnationality() {
/*  463 */     if (this.nationality != null) this.nationality.equals("");
/*      */ 
/*  467 */     return this.nationality;
/*      */   }
/*      */ 
/*      */   public void setnationality(String anationality) {
/*  471 */     this.nationality = anationality;
/*      */   }
/*      */ 
/*      */   public String getrgtAddress() {
/*  475 */     if (this.rgtAddress != null) this.rgtAddress.equals("");
/*      */ 
/*  479 */     return this.rgtAddress;
/*      */   }
/*      */ 
/*      */   public void setrgtAddress(String argtAddress) {
/*  483 */     this.rgtAddress = argtAddress;
/*      */   }
/*      */ 
/*      */   public String getmarriage() {
/*  487 */     if (this.marriage != null) this.marriage.equals("");
/*      */ 
/*  491 */     return this.marriage;
/*      */   }
/*      */ 
/*      */   public void setmarriage(String amarriage) {
/*  495 */     this.marriage = amarriage;
/*      */   }
/*      */ 
/*      */   public String getmarriageDate() {
/*  499 */     if (this.marriageDate != null) {
/*  500 */       return this.fDate.getString(this.marriageDate);
/*      */     }
/*  502 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmarriageDate(Date amarriageDate) {
/*  506 */     this.marriageDate = amarriageDate;
/*      */   }
/*      */ 
/*      */   public void setmarriageDate(String amarriageDate) {
/*  510 */     if ((amarriageDate != null) && (!amarriageDate.equals("")))
/*      */     {
/*  512 */       this.marriageDate = this.fDate.getDate(amarriageDate);
/*      */     }
/*      */     else
/*  515 */       this.marriageDate = null;
/*      */   }
/*      */ 
/*      */   public String gethealth()
/*      */   {
/*  520 */     if (this.health != null) this.health.equals("");
/*      */ 
/*  524 */     return this.health;
/*      */   }
/*      */ 
/*      */   public void sethealth(String ahealth) {
/*  528 */     this.health = ahealth;
/*      */   }
/*      */ 
/*      */   public double getstature() {
/*  532 */     return this.stature;
/*      */   }
/*      */ 
/*      */   public void setstature(double astature) {
/*  536 */     this.stature = astature;
/*      */   }
/*      */ 
/*      */   public void setstature(String astature) {
/*  540 */     if ((astature != null) && (!astature.equals("")))
/*      */     {
/*  542 */       Double tDouble = new Double(astature);
/*  543 */       double d = tDouble.doubleValue();
/*  544 */       this.stature = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getavoirdupois()
/*      */   {
/*  550 */     return this.avoirdupois;
/*      */   }
/*      */ 
/*      */   public void setavoirdupois(double aavoirdupois) {
/*  554 */     this.avoirdupois = aavoirdupois;
/*      */   }
/*      */ 
/*      */   public void setavoirdupois(String aavoirdupois) {
/*  558 */     if ((aavoirdupois != null) && (!aavoirdupois.equals("")))
/*      */     {
/*  560 */       Double tDouble = new Double(aavoirdupois);
/*  561 */       double d = tDouble.doubleValue();
/*  562 */       this.avoirdupois = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getdegree()
/*      */   {
/*  568 */     if (this.degree != null) this.degree.equals("");
/*      */ 
/*  572 */     return this.degree;
/*      */   }
/*      */ 
/*      */   public void setdegree(String adegree) {
/*  576 */     this.degree = adegree;
/*      */   }
/*      */ 
/*      */   public String getcreditGrade() {
/*  580 */     if (this.creditGrade != null) this.creditGrade.equals("");
/*      */ 
/*  584 */     return this.creditGrade;
/*      */   }
/*      */ 
/*      */   public void setcreditGrade(String acreditGrade) {
/*  588 */     this.creditGrade = acreditGrade;
/*      */   }
/*      */ 
/*      */   public String getbankCode() {
/*  592 */     if (this.bankCode != null) this.bankCode.equals("");
/*      */ 
/*  596 */     return this.bankCode;
/*      */   }
/*      */ 
/*      */   public void setbankCode(String abankCode) {
/*  600 */     this.bankCode = abankCode;
/*      */   }
/*      */ 
/*      */   public String getbankAccNo() {
/*  604 */     if (this.bankAccNo != null) this.bankAccNo.equals("");
/*      */ 
/*  608 */     return this.bankAccNo;
/*      */   }
/*      */ 
/*      */   public void setbankAccNo(String abankAccNo) {
/*  612 */     this.bankAccNo = abankAccNo;
/*      */   }
/*      */ 
/*      */   public String getaccName() {
/*  616 */     if (this.accName != null) this.accName.equals("");
/*      */ 
/*  620 */     return this.accName;
/*      */   }
/*      */ 
/*      */   public void setaccName(String aaccName) {
/*  624 */     this.accName = aaccName;
/*      */   }
/*      */ 
/*      */   public String getjoinCompanyDate() {
/*  628 */     if (this.joinCompanyDate != null) {
/*  629 */       return this.fDate.getString(this.joinCompanyDate);
/*      */     }
/*  631 */     return null;
/*      */   }
/*      */ 
/*      */   public void setjoinCompanyDate(Date ajoinCompanyDate) {
/*  635 */     this.joinCompanyDate = ajoinCompanyDate;
/*      */   }
/*      */ 
/*      */   public void setjoinCompanyDate(String ajoinCompanyDate) {
/*  639 */     if ((ajoinCompanyDate != null) && (!ajoinCompanyDate.equals("")))
/*      */     {
/*  641 */       this.joinCompanyDate = this.fDate.getDate(ajoinCompanyDate);
/*      */     }
/*      */     else
/*  644 */       this.joinCompanyDate = null;
/*      */   }
/*      */ 
/*      */   public String getstartWorkDate()
/*      */   {
/*  649 */     if (this.startWorkDate != null) {
/*  650 */       return this.fDate.getString(this.startWorkDate);
/*      */     }
/*  652 */     return null;
/*      */   }
/*      */ 
/*      */   public void setstartWorkDate(Date astartWorkDate) {
/*  656 */     this.startWorkDate = astartWorkDate;
/*      */   }
/*      */ 
/*      */   public void setstartWorkDate(String astartWorkDate) {
/*  660 */     if ((astartWorkDate != null) && (!astartWorkDate.equals("")))
/*      */     {
/*  662 */       this.startWorkDate = this.fDate.getDate(astartWorkDate);
/*      */     }
/*      */     else
/*  665 */       this.startWorkDate = null;
/*      */   }
/*      */ 
/*      */   public String getposition()
/*      */   {
/*  670 */     if (this.position != null) this.position.equals("");
/*      */ 
/*  674 */     return this.position;
/*      */   }
/*      */ 
/*      */   public void setposition(String aposition) {
/*  678 */     this.position = aposition;
/*      */   }
/*      */ 
/*      */   public double getsalary() {
/*  682 */     return this.salary;
/*      */   }
/*      */ 
/*      */   public void setsalary(double asalary) {
/*  686 */     this.salary = asalary;
/*      */   }
/*      */ 
/*      */   public void setsalary(String asalary) {
/*  690 */     if ((asalary != null) && (!asalary.equals("")))
/*      */     {
/*  692 */       Double tDouble = new Double(asalary);
/*  693 */       double d = tDouble.doubleValue();
/*  694 */       this.salary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getoccupationType()
/*      */   {
/*  700 */     if (this.occupationType != null) this.occupationType.equals("");
/*      */ 
/*  704 */     return this.occupationType;
/*      */   }
/*      */ 
/*      */   public void setoccupationType(String aoccupationType) {
/*  708 */     this.occupationType = aoccupationType;
/*      */   }
/*      */ 
/*      */   public String getoccupationCode() {
/*  712 */     if (this.occupationCode != null) this.occupationCode.equals("");
/*      */ 
/*  716 */     return this.occupationCode;
/*      */   }
/*      */ 
/*      */   public void setoccupationCode(String aoccupationCode) {
/*  720 */     this.occupationCode = aoccupationCode;
/*      */   }
/*      */ 
/*      */   public String getworkType() {
/*  724 */     if (this.workType != null) this.workType.equals("");
/*      */ 
/*  728 */     return this.workType;
/*      */   }
/*      */ 
/*      */   public void setworkType(String aworkType) {
/*  732 */     this.workType = aworkType;
/*      */   }
/*      */ 
/*      */   public String getpluralityType() {
/*  736 */     if (this.pluralityType != null) this.pluralityType.equals("");
/*      */ 
/*  740 */     return this.pluralityType;
/*      */   }
/*      */ 
/*      */   public void setpluralityType(String apluralityType) {
/*  744 */     this.pluralityType = apluralityType;
/*      */   }
/*      */ 
/*      */   public String getsmokeFlag() {
/*  748 */     if (this.smokeFlag != null) this.smokeFlag.equals("");
/*      */ 
/*  752 */     return this.smokeFlag;
/*      */   }
/*      */ 
/*      */   public void setsmokeFlag(String asmokeFlag) {
/*  756 */     this.smokeFlag = asmokeFlag;
/*      */   }
/*      */ 
/*      */   public String getoperator() {
/*  760 */     if (this.operator != null) this.operator.equals("");
/*      */ 
/*  764 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setoperator(String aoperator) {
/*  768 */     this.operator = aoperator;
/*      */   }
/*      */ 
/*      */   public String getmanageCom() {
/*  772 */     if (this.manageCom != null) this.manageCom.equals("");
/*      */ 
/*  776 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setmanageCom(String amanageCom) {
/*  780 */     this.manageCom = amanageCom;
/*      */   }
/*      */ 
/*      */   public String getmakeDate() {
/*  784 */     if (this.makeDate != null) {
/*  785 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  787 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(Date amakeDate) {
/*  791 */     this.makeDate = amakeDate;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(String amakeDate) {
/*  795 */     if ((amakeDate != null) && (!amakeDate.equals("")))
/*      */     {
/*  797 */       this.makeDate = this.fDate.getDate(amakeDate);
/*      */     }
/*      */     else
/*  800 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getmakeTime()
/*      */   {
/*  805 */     if (this.makeTime != null) this.makeTime.equals("");
/*      */ 
/*  809 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setmakeTime(String amakeTime) {
/*  813 */     this.makeTime = amakeTime;
/*      */   }
/*      */ 
/*      */   public String getmodifyDate() {
/*  817 */     if (this.modifyDate != null) {
/*  818 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  820 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(Date amodifyDate) {
/*  824 */     this.modifyDate = amodifyDate;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(String amodifyDate) {
/*  828 */     if ((amodifyDate != null) && (!amodifyDate.equals("")))
/*      */     {
/*  830 */       this.modifyDate = this.fDate.getDate(amodifyDate);
/*      */     }
/*      */     else
/*  833 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getmodifyTime()
/*      */   {
/*  838 */     if (this.modifyTime != null) this.modifyTime.equals("");
/*      */ 
/*  842 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setmodifyTime(String amodifyTime) {
/*  846 */     this.modifyTime = amodifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPAppntBSchema aLNPAppntBSchema)
/*      */   {
/*  852 */     this.EdorNo = aLNPAppntBSchema.getEdorNo();
/*  853 */     this.serialNo = aLNPAppntBSchema.getserialNo();
/*  854 */     this.grpContNo = aLNPAppntBSchema.getgrpContNo();
/*  855 */     this.contNo = aLNPAppntBSchema.getcontNo();
/*  856 */     this.proposalContNo = aLNPAppntBSchema.getproposalContNo();
/*  857 */     this.prtNo = aLNPAppntBSchema.getprtNo();
/*  858 */     this.appntNo = aLNPAppntBSchema.getappntNo();
/*  859 */     this.appntId = aLNPAppntBSchema.getappntId();
/*  860 */     this.relationToInsured = aLNPAppntBSchema.getrelationToInsured();
/*  861 */     this.appntGrade = aLNPAppntBSchema.getappntGrade();
/*  862 */     this.appellation = aLNPAppntBSchema.getappellation();
/*  863 */     this.appntName = aLNPAppntBSchema.getappntName();
/*  864 */     this.appntSex = aLNPAppntBSchema.getappntSex();
/*  865 */     this.appntBirthday = this.fDate.getDate(aLNPAppntBSchema.getappntBirthday());
/*  866 */     this.appntAge = aLNPAppntBSchema.getappntAge();
/*  867 */     this.appntAgeType = aLNPAppntBSchema.getappntAgeType();
/*  868 */     this.appntType = aLNPAppntBSchema.getappntType();
/*  869 */     this.addressNo = aLNPAppntBSchema.getaddressNo();
/*  870 */     this.sequenceNo = aLNPAppntBSchema.getsequenceNo();
/*  871 */     this.iDType = aLNPAppntBSchema.getiDType();
/*  872 */     this.iDNo = aLNPAppntBSchema.getiDNo();
/*  873 */     this.iDValidity = this.fDate.getDate(aLNPAppntBSchema.getiDValidity());
/*  874 */     this.iDPerpetual = aLNPAppntBSchema.getiDPerpetual();
/*  875 */     this.nativePlace = aLNPAppntBSchema.getnativePlace();
/*  876 */     this.nationality = aLNPAppntBSchema.getnationality();
/*  877 */     this.rgtAddress = aLNPAppntBSchema.getrgtAddress();
/*  878 */     this.marriage = aLNPAppntBSchema.getmarriage();
/*  879 */     this.marriageDate = this.fDate.getDate(aLNPAppntBSchema.getmarriageDate());
/*  880 */     this.health = aLNPAppntBSchema.gethealth();
/*  881 */     this.stature = aLNPAppntBSchema.getstature();
/*  882 */     this.avoirdupois = aLNPAppntBSchema.getavoirdupois();
/*  883 */     this.degree = aLNPAppntBSchema.getdegree();
/*  884 */     this.creditGrade = aLNPAppntBSchema.getcreditGrade();
/*  885 */     this.bankCode = aLNPAppntBSchema.getbankCode();
/*  886 */     this.bankAccNo = aLNPAppntBSchema.getbankAccNo();
/*  887 */     this.accName = aLNPAppntBSchema.getaccName();
/*  888 */     this.joinCompanyDate = this.fDate.getDate(aLNPAppntBSchema.getjoinCompanyDate());
/*  889 */     this.startWorkDate = this.fDate.getDate(aLNPAppntBSchema.getstartWorkDate());
/*  890 */     this.position = aLNPAppntBSchema.getposition();
/*  891 */     this.salary = aLNPAppntBSchema.getsalary();
/*  892 */     this.occupationType = aLNPAppntBSchema.getoccupationType();
/*  893 */     this.occupationCode = aLNPAppntBSchema.getoccupationCode();
/*  894 */     this.workType = aLNPAppntBSchema.getworkType();
/*  895 */     this.pluralityType = aLNPAppntBSchema.getpluralityType();
/*  896 */     this.smokeFlag = aLNPAppntBSchema.getsmokeFlag();
/*  897 */     this.operator = aLNPAppntBSchema.getoperator();
/*  898 */     this.manageCom = aLNPAppntBSchema.getmanageCom();
/*  899 */     this.makeDate = this.fDate.getDate(aLNPAppntBSchema.getmakeDate());
/*  900 */     this.makeTime = aLNPAppntBSchema.getmakeTime();
/*  901 */     this.modifyDate = this.fDate.getDate(aLNPAppntBSchema.getmodifyDate());
/*  902 */     this.modifyTime = aLNPAppntBSchema.getmodifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  911 */       if (rs.getString("EdorNo") == null)
/*  912 */         this.EdorNo = null;
/*      */       else {
/*  914 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  916 */       if (rs.getString("serialNo") == null)
/*  917 */         this.serialNo = null;
/*      */       else {
/*  919 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/*  921 */       if (rs.getString("grpContNo") == null)
/*  922 */         this.grpContNo = null;
/*      */       else {
/*  924 */         this.grpContNo = rs.getString("grpContNo").trim();
/*      */       }
/*  926 */       if (rs.getString("contNo") == null)
/*  927 */         this.contNo = null;
/*      */       else {
/*  929 */         this.contNo = rs.getString("contNo").trim();
/*      */       }
/*  931 */       if (rs.getString("proposalContNo") == null)
/*  932 */         this.proposalContNo = null;
/*      */       else {
/*  934 */         this.proposalContNo = rs.getString("proposalContNo").trim();
/*      */       }
/*  936 */       if (rs.getString("prtNo") == null)
/*  937 */         this.prtNo = null;
/*      */       else {
/*  939 */         this.prtNo = rs.getString("prtNo").trim();
/*      */       }
/*  941 */       if (rs.getString("appntNo") == null)
/*  942 */         this.appntNo = null;
/*      */       else {
/*  944 */         this.appntNo = rs.getString("appntNo").trim();
/*      */       }
/*  946 */       if (rs.getString("appntId") == null)
/*  947 */         this.appntId = null;
/*      */       else {
/*  949 */         this.appntId = rs.getString("appntId").trim();
/*      */       }
/*  951 */       if (rs.getString("relationToInsured") == null)
/*  952 */         this.relationToInsured = null;
/*      */       else {
/*  954 */         this.relationToInsured = rs.getString("relationToInsured").trim();
/*      */       }
/*  956 */       if (rs.getString("appntGrade") == null)
/*  957 */         this.appntGrade = null;
/*      */       else {
/*  959 */         this.appntGrade = rs.getString("appntGrade").trim();
/*      */       }
/*  961 */       if (rs.getString("appellation") == null)
/*  962 */         this.appellation = null;
/*      */       else {
/*  964 */         this.appellation = rs.getString("appellation").trim();
/*      */       }
/*  966 */       if (rs.getString("appntName") == null)
/*  967 */         this.appntName = null;
/*      */       else {
/*  969 */         this.appntName = rs.getString("appntName").trim();
/*      */       }
/*  971 */       if (rs.getString("appntSex") == null)
/*  972 */         this.appntSex = null;
/*      */       else {
/*  974 */         this.appntSex = rs.getString("appntSex").trim();
/*      */       }
/*  976 */       this.appntBirthday = rs.getDate("appntBirthday");
/*  977 */       this.appntAge = rs.getInt("appntAge");
/*  978 */       if (rs.getString("appntAgeType") == null)
/*  979 */         this.appntAgeType = null;
/*      */       else {
/*  981 */         this.appntAgeType = rs.getString("appntAgeType").trim();
/*      */       }
/*  983 */       if (rs.getString("appntType") == null)
/*  984 */         this.appntType = null;
/*      */       else {
/*  986 */         this.appntType = rs.getString("appntType").trim();
/*      */       }
/*  988 */       if (rs.getString("addressNo") == null)
/*  989 */         this.addressNo = null;
/*      */       else {
/*  991 */         this.addressNo = rs.getString("addressNo").trim();
/*      */       }
/*  993 */       if (rs.getString("sequenceNo") == null)
/*  994 */         this.sequenceNo = null;
/*      */       else {
/*  996 */         this.sequenceNo = rs.getString("sequenceNo").trim();
/*      */       }
/*  998 */       if (rs.getString("iDType") == null)
/*  999 */         this.iDType = null;
/*      */       else {
/* 1001 */         this.iDType = rs.getString("iDType").trim();
/*      */       }
/* 1003 */       if (rs.getString("iDNo") == null)
/* 1004 */         this.iDNo = null;
/*      */       else {
/* 1006 */         this.iDNo = rs.getString("iDNo").trim();
/*      */       }
/* 1008 */       this.iDValidity = rs.getDate("iDValidity");
/* 1009 */       if (rs.getString("iDPerpetual") == null)
/* 1010 */         this.iDPerpetual = null;
/*      */       else {
/* 1012 */         this.iDPerpetual = rs.getString("iDPerpetual").trim();
/*      */       }
/* 1014 */       if (rs.getString("nativePlace") == null)
/* 1015 */         this.nativePlace = null;
/*      */       else {
/* 1017 */         this.nativePlace = rs.getString("nativePlace").trim();
/*      */       }
/* 1019 */       if (rs.getString("nationality") == null)
/* 1020 */         this.nationality = null;
/*      */       else {
/* 1022 */         this.nationality = rs.getString("nationality").trim();
/*      */       }
/* 1024 */       if (rs.getString("rgtAddress") == null)
/* 1025 */         this.rgtAddress = null;
/*      */       else {
/* 1027 */         this.rgtAddress = rs.getString("rgtAddress").trim();
/*      */       }
/* 1029 */       if (rs.getString("marriage") == null)
/* 1030 */         this.marriage = null;
/*      */       else {
/* 1032 */         this.marriage = rs.getString("marriage").trim();
/*      */       }
/* 1034 */       this.marriageDate = rs.getDate("marriageDate");
/* 1035 */       if (rs.getString("health") == null)
/* 1036 */         this.health = null;
/*      */       else {
/* 1038 */         this.health = rs.getString("health").trim();
/*      */       }
/* 1040 */       this.stature = rs.getDouble("stature");
/* 1041 */       this.avoirdupois = rs.getDouble("avoirdupois");
/* 1042 */       if (rs.getString("degree") == null)
/* 1043 */         this.degree = null;
/*      */       else {
/* 1045 */         this.degree = rs.getString("degree").trim();
/*      */       }
/* 1047 */       if (rs.getString("creditGrade") == null)
/* 1048 */         this.creditGrade = null;
/*      */       else {
/* 1050 */         this.creditGrade = rs.getString("creditGrade").trim();
/*      */       }
/* 1052 */       if (rs.getString("bankCode") == null)
/* 1053 */         this.bankCode = null;
/*      */       else {
/* 1055 */         this.bankCode = rs.getString("bankCode").trim();
/*      */       }
/* 1057 */       if (rs.getString("bankAccNo") == null)
/* 1058 */         this.bankAccNo = null;
/*      */       else {
/* 1060 */         this.bankAccNo = rs.getString("bankAccNo").trim();
/*      */       }
/* 1062 */       if (rs.getString("accName") == null)
/* 1063 */         this.accName = null;
/*      */       else {
/* 1065 */         this.accName = rs.getString("accName").trim();
/*      */       }
/* 1067 */       this.joinCompanyDate = rs.getDate("joinCompanyDate");
/* 1068 */       this.startWorkDate = rs.getDate("startWorkDate");
/* 1069 */       if (rs.getString("position") == null)
/* 1070 */         this.position = null;
/*      */       else {
/* 1072 */         this.position = rs.getString("position").trim();
/*      */       }
/* 1074 */       this.salary = rs.getDouble("salary");
/* 1075 */       if (rs.getString("occupationType") == null)
/* 1076 */         this.occupationType = null;
/*      */       else {
/* 1078 */         this.occupationType = rs.getString("occupationType").trim();
/*      */       }
/* 1080 */       if (rs.getString("occupationCode") == null)
/* 1081 */         this.occupationCode = null;
/*      */       else {
/* 1083 */         this.occupationCode = rs.getString("occupationCode").trim();
/*      */       }
/* 1085 */       if (rs.getString("workType") == null)
/* 1086 */         this.workType = null;
/*      */       else {
/* 1088 */         this.workType = rs.getString("workType").trim();
/*      */       }
/* 1090 */       if (rs.getString("pluralityType") == null)
/* 1091 */         this.pluralityType = null;
/*      */       else {
/* 1093 */         this.pluralityType = rs.getString("pluralityType").trim();
/*      */       }
/* 1095 */       if (rs.getString("smokeFlag") == null)
/* 1096 */         this.smokeFlag = null;
/*      */       else {
/* 1098 */         this.smokeFlag = rs.getString("smokeFlag").trim();
/*      */       }
/* 1100 */       if (rs.getString("operator") == null)
/* 1101 */         this.operator = null;
/*      */       else {
/* 1103 */         this.operator = rs.getString("operator").trim();
/*      */       }
/* 1105 */       if (rs.getString("manageCom") == null)
/* 1106 */         this.manageCom = null;
/*      */       else {
/* 1108 */         this.manageCom = rs.getString("manageCom").trim();
/*      */       }
/* 1110 */       this.makeDate = rs.getDate("makeDate");
/* 1111 */       if (rs.getString("makeTime") == null)
/* 1112 */         this.makeTime = null;
/*      */       else {
/* 1114 */         this.makeTime = rs.getString("makeTime").trim();
/*      */       }
/* 1116 */       this.modifyDate = rs.getDate("modifyDate");
/* 1117 */       if (rs.getString("modifyTime") == null)
/* 1118 */         this.modifyTime = null;
/*      */       else {
/* 1120 */         this.modifyTime = rs.getString("modifyTime").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1126 */       CError tError = new CError();
/* 1127 */       tError.moduleName = "LNPAppntBSchema";
/* 1128 */       tError.functionName = "setSchema";
/* 1129 */       tError.errorMessage = sqle.toString();
/* 1130 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1132 */       return false;
/*      */     }
/* 1134 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAppntBSchema getSchema()
/*      */   {
/* 1139 */     LNPAppntBSchema aLNPAppntBSchema = new LNPAppntBSchema();
/* 1140 */     aLNPAppntBSchema.setSchema(this);
/* 1141 */     return aLNPAppntBSchema;
/*      */   }
/*      */ 
/*      */   public LNPAppntBDB getDB()
/*      */   {
/* 1146 */     LNPAppntBDB aDBOper = new LNPAppntBDB();
/* 1147 */     aDBOper.setSchema(this);
/* 1148 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1155 */     String strReturn = "";
/* 1156 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/* 1157 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/* 1158 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpContNo)) + "|" + 
/* 1159 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contNo)) + "|" + 
/* 1160 */       StrTool.cTrim(StrTool.unicodeToGBK(this.proposalContNo)) + "|" + 
/* 1161 */       StrTool.cTrim(StrTool.unicodeToGBK(this.prtNo)) + "|" + 
/* 1162 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntNo)) + "|" + 
/* 1163 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntId)) + "|" + 
/* 1164 */       StrTool.cTrim(StrTool.unicodeToGBK(this.relationToInsured)) + "|" + 
/* 1165 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntGrade)) + "|" + 
/* 1166 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appellation)) + "|" + 
/* 1167 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntName)) + "|" + 
/* 1168 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntSex)) + "|" + 
/* 1169 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.appntBirthday))) + "|" + 
/* 1170 */       ChgData.chgData(this.appntAge) + "|" + 
/* 1171 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntAgeType)) + "|" + 
/* 1172 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntType)) + "|" + 
/* 1173 */       StrTool.cTrim(StrTool.unicodeToGBK(this.addressNo)) + "|" + 
/* 1174 */       StrTool.cTrim(StrTool.unicodeToGBK(this.sequenceNo)) + "|" + 
/* 1175 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDType)) + "|" + 
/* 1176 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDNo)) + "|" + 
/* 1177 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.iDValidity))) + "|" + 
/* 1178 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDPerpetual)) + "|" + 
/* 1179 */       StrTool.cTrim(StrTool.unicodeToGBK(this.nativePlace)) + "|" + 
/* 1180 */       StrTool.cTrim(StrTool.unicodeToGBK(this.nationality)) + "|" + 
/* 1181 */       StrTool.cTrim(StrTool.unicodeToGBK(this.rgtAddress)) + "|" + 
/* 1182 */       StrTool.cTrim(StrTool.unicodeToGBK(this.marriage)) + "|" + 
/* 1183 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.marriageDate))) + "|" + 
/* 1184 */       StrTool.cTrim(StrTool.unicodeToGBK(this.health)) + "|" + 
/* 1185 */       ChgData.chgData(this.stature) + "|" + 
/* 1186 */       ChgData.chgData(this.avoirdupois) + "|" + 
/* 1187 */       StrTool.cTrim(StrTool.unicodeToGBK(this.degree)) + "|" + 
/* 1188 */       StrTool.cTrim(StrTool.unicodeToGBK(this.creditGrade)) + "|" + 
/* 1189 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bankCode)) + "|" + 
/* 1190 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bankAccNo)) + "|" + 
/* 1191 */       StrTool.cTrim(StrTool.unicodeToGBK(this.accName)) + "|" + 
/* 1192 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.joinCompanyDate))) + "|" + 
/* 1193 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.startWorkDate))) + "|" + 
/* 1194 */       StrTool.cTrim(StrTool.unicodeToGBK(this.position)) + "|" + 
/* 1195 */       ChgData.chgData(this.salary) + "|" + 
/* 1196 */       StrTool.cTrim(StrTool.unicodeToGBK(this.occupationType)) + "|" + 
/* 1197 */       StrTool.cTrim(StrTool.unicodeToGBK(this.occupationCode)) + "|" + 
/* 1198 */       StrTool.cTrim(StrTool.unicodeToGBK(this.workType)) + "|" + 
/* 1199 */       StrTool.cTrim(StrTool.unicodeToGBK(this.pluralityType)) + "|" + 
/* 1200 */       StrTool.cTrim(StrTool.unicodeToGBK(this.smokeFlag)) + "|" + 
/* 1201 */       StrTool.cTrim(StrTool.unicodeToGBK(this.operator)) + "|" + 
/* 1202 */       StrTool.cTrim(StrTool.unicodeToGBK(this.manageCom)) + "|" + 
/* 1203 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makeDate))) + "|" + 
/* 1204 */       StrTool.cTrim(StrTool.unicodeToGBK(this.makeTime)) + "|" + 
/* 1205 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifyDate))) + "|" + 
/* 1206 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifyTime));
/* 1207 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1215 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1216 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1217 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1218 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1219 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1220 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1221 */       this.appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1222 */       this.appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1223 */       this.relationToInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1224 */       this.appntGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1225 */       this.appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1226 */       this.appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1227 */       this.appntSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1228 */       this.appntBirthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/* 1229 */       this.appntAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).intValue();
/* 1230 */       this.appntAgeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1231 */       this.appntType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1232 */       this.addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1233 */       this.sequenceNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1234 */       this.iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 1235 */       this.iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1236 */       this.iDValidity = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/* 1237 */       this.iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 1238 */       this.nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1239 */       this.nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1240 */       this.rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1241 */       this.marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1242 */       this.marriageDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
/* 1243 */       this.health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 1244 */       this.stature = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 30, "|"))).doubleValue();
/* 1245 */       this.avoirdupois = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|"))).doubleValue();
/* 1246 */       this.degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 1247 */       this.creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 1248 */       this.bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/* 1249 */       this.bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 1250 */       this.accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
/* 1251 */       this.joinCompanyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|"));
/* 1252 */       this.startWorkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|"));
/* 1253 */       this.position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/* 1254 */       this.salary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 40, "|"))).doubleValue();
/* 1255 */       this.occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1256 */       this.occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1257 */       this.workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 1258 */       this.pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1259 */       this.smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 1260 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 1261 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 1262 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|"));
/* 1263 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/* 1264 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|"));
/* 1265 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1270 */       CError tError = new CError();
/* 1271 */       tError.moduleName = "LNPAppntBSchema";
/* 1272 */       tError.functionName = "decode";
/* 1273 */       tError.errorMessage = ex.toString();
/* 1274 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1276 */       return false;
/*      */     }
/* 1278 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1284 */     String strReturn = "";
/* 1285 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 1287 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/* 1289 */     if (FCode.equals("serialNo"))
/*      */     {
/* 1291 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/* 1293 */     if (FCode.equals("grpContNo"))
/*      */     {
/* 1295 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/* 1297 */     if (FCode.equals("contNo"))
/*      */     {
/* 1299 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/* 1301 */     if (FCode.equals("proposalContNo"))
/*      */     {
/* 1303 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/* 1305 */     if (FCode.equals("prtNo"))
/*      */     {
/* 1307 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/* 1309 */     if (FCode.equals("appntNo"))
/*      */     {
/* 1311 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntNo));
/*      */     }
/* 1313 */     if (FCode.equals("appntId"))
/*      */     {
/* 1315 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntId));
/*      */     }
/* 1317 */     if (FCode.equals("relationToInsured"))
/*      */     {
/* 1319 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relationToInsured));
/*      */     }
/* 1321 */     if (FCode.equals("appntGrade"))
/*      */     {
/* 1323 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntGrade));
/*      */     }
/* 1325 */     if (FCode.equals("appellation"))
/*      */     {
/* 1327 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appellation));
/*      */     }
/* 1329 */     if (FCode.equals("appntName"))
/*      */     {
/* 1331 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntName));
/*      */     }
/* 1333 */     if (FCode.equals("appntSex"))
/*      */     {
/* 1335 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntSex));
/*      */     }
/* 1337 */     if (FCode.equals("appntBirthday"))
/*      */     {
/* 1339 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getappntBirthday()));
/*      */     }
/* 1341 */     if (FCode.equals("appntAge"))
/*      */     {
/* 1343 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntAge));
/*      */     }
/* 1345 */     if (FCode.equals("appntAgeType"))
/*      */     {
/* 1347 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntAgeType));
/*      */     }
/* 1349 */     if (FCode.equals("appntType"))
/*      */     {
/* 1351 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntType));
/*      */     }
/* 1353 */     if (FCode.equals("addressNo"))
/*      */     {
/* 1355 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addressNo));
/*      */     }
/* 1357 */     if (FCode.equals("sequenceNo"))
/*      */     {
/* 1359 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sequenceNo));
/*      */     }
/* 1361 */     if (FCode.equals("iDType"))
/*      */     {
/* 1363 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDType));
/*      */     }
/* 1365 */     if (FCode.equals("iDNo"))
/*      */     {
/* 1367 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDNo));
/*      */     }
/* 1369 */     if (FCode.equals("iDValidity"))
/*      */     {
/* 1371 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
/*      */     }
/* 1373 */     if (FCode.equals("iDPerpetual"))
/*      */     {
/* 1375 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDPerpetual));
/*      */     }
/* 1377 */     if (FCode.equals("nativePlace"))
/*      */     {
/* 1379 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nativePlace));
/*      */     }
/* 1381 */     if (FCode.equals("nationality"))
/*      */     {
/* 1383 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nationality));
/*      */     }
/* 1385 */     if (FCode.equals("rgtAddress"))
/*      */     {
/* 1387 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rgtAddress));
/*      */     }
/* 1389 */     if (FCode.equals("marriage"))
/*      */     {
/* 1391 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.marriage));
/*      */     }
/* 1393 */     if (FCode.equals("marriageDate"))
/*      */     {
/* 1395 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
/*      */     }
/* 1397 */     if (FCode.equals("health"))
/*      */     {
/* 1399 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.health));
/*      */     }
/* 1401 */     if (FCode.equals("stature"))
/*      */     {
/* 1403 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stature));
/*      */     }
/* 1405 */     if (FCode.equals("avoirdupois"))
/*      */     {
/* 1407 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.avoirdupois));
/*      */     }
/* 1409 */     if (FCode.equals("degree"))
/*      */     {
/* 1411 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.degree));
/*      */     }
/* 1413 */     if (FCode.equals("creditGrade"))
/*      */     {
/* 1415 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.creditGrade));
/*      */     }
/* 1417 */     if (FCode.equals("bankCode"))
/*      */     {
/* 1419 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankCode));
/*      */     }
/* 1421 */     if (FCode.equals("bankAccNo"))
/*      */     {
/* 1423 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankAccNo));
/*      */     }
/* 1425 */     if (FCode.equals("accName"))
/*      */     {
/* 1427 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.accName));
/*      */     }
/* 1429 */     if (FCode.equals("joinCompanyDate"))
/*      */     {
/* 1431 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
/*      */     }
/* 1433 */     if (FCode.equals("startWorkDate"))
/*      */     {
/* 1435 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
/*      */     }
/* 1437 */     if (FCode.equals("position"))
/*      */     {
/* 1439 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.position));
/*      */     }
/* 1441 */     if (FCode.equals("salary"))
/*      */     {
/* 1443 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.salary));
/*      */     }
/* 1445 */     if (FCode.equals("occupationType"))
/*      */     {
/* 1447 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationType));
/*      */     }
/* 1449 */     if (FCode.equals("occupationCode"))
/*      */     {
/* 1451 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationCode));
/*      */     }
/* 1453 */     if (FCode.equals("workType"))
/*      */     {
/* 1455 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.workType));
/*      */     }
/* 1457 */     if (FCode.equals("pluralityType"))
/*      */     {
/* 1459 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pluralityType));
/*      */     }
/* 1461 */     if (FCode.equals("smokeFlag"))
/*      */     {
/* 1463 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.smokeFlag));
/*      */     }
/* 1465 */     if (FCode.equals("operator"))
/*      */     {
/* 1467 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1469 */     if (FCode.equals("manageCom"))
/*      */     {
/* 1471 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 1473 */     if (FCode.equals("makeDate"))
/*      */     {
/* 1475 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*      */     }
/* 1477 */     if (FCode.equals("makeTime"))
/*      */     {
/* 1479 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1481 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 1483 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*      */     }
/* 1485 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 1487 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1489 */     if (strReturn.equals(""))
/*      */     {
/* 1491 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1494 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1501 */     String strFieldValue = "";
/* 1502 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1504 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/* 1505 */       break;
/*      */     case 1:
/* 1507 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/* 1508 */       break;
/*      */     case 2:
/* 1510 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/* 1511 */       break;
/*      */     case 3:
/* 1513 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 1514 */       break;
/*      */     case 4:
/* 1516 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/* 1517 */       break;
/*      */     case 5:
/* 1519 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/* 1520 */       break;
/*      */     case 6:
/* 1522 */       strFieldValue = StrTool.GBKToUnicode(this.appntNo);
/* 1523 */       break;
/*      */     case 7:
/* 1525 */       strFieldValue = StrTool.GBKToUnicode(this.appntId);
/* 1526 */       break;
/*      */     case 8:
/* 1528 */       strFieldValue = StrTool.GBKToUnicode(this.relationToInsured);
/* 1529 */       break;
/*      */     case 9:
/* 1531 */       strFieldValue = StrTool.GBKToUnicode(this.appntGrade);
/* 1532 */       break;
/*      */     case 10:
/* 1534 */       strFieldValue = StrTool.GBKToUnicode(this.appellation);
/* 1535 */       break;
/*      */     case 11:
/* 1537 */       strFieldValue = StrTool.GBKToUnicode(this.appntName);
/* 1538 */       break;
/*      */     case 12:
/* 1540 */       strFieldValue = StrTool.GBKToUnicode(this.appntSex);
/* 1541 */       break;
/*      */     case 13:
/* 1543 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getappntBirthday()));
/* 1544 */       break;
/*      */     case 14:
/* 1546 */       strFieldValue = String.valueOf(this.appntAge);
/* 1547 */       break;
/*      */     case 15:
/* 1549 */       strFieldValue = StrTool.GBKToUnicode(this.appntAgeType);
/* 1550 */       break;
/*      */     case 16:
/* 1552 */       strFieldValue = StrTool.GBKToUnicode(this.appntType);
/* 1553 */       break;
/*      */     case 17:
/* 1555 */       strFieldValue = StrTool.GBKToUnicode(this.addressNo);
/* 1556 */       break;
/*      */     case 18:
/* 1558 */       strFieldValue = StrTool.GBKToUnicode(this.sequenceNo);
/* 1559 */       break;
/*      */     case 19:
/* 1561 */       strFieldValue = StrTool.GBKToUnicode(this.iDType);
/* 1562 */       break;
/*      */     case 20:
/* 1564 */       strFieldValue = StrTool.GBKToUnicode(this.iDNo);
/* 1565 */       break;
/*      */     case 21:
/* 1567 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
/* 1568 */       break;
/*      */     case 22:
/* 1570 */       strFieldValue = StrTool.GBKToUnicode(this.iDPerpetual);
/* 1571 */       break;
/*      */     case 23:
/* 1573 */       strFieldValue = StrTool.GBKToUnicode(this.nativePlace);
/* 1574 */       break;
/*      */     case 24:
/* 1576 */       strFieldValue = StrTool.GBKToUnicode(this.nationality);
/* 1577 */       break;
/*      */     case 25:
/* 1579 */       strFieldValue = StrTool.GBKToUnicode(this.rgtAddress);
/* 1580 */       break;
/*      */     case 26:
/* 1582 */       strFieldValue = StrTool.GBKToUnicode(this.marriage);
/* 1583 */       break;
/*      */     case 27:
/* 1585 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
/* 1586 */       break;
/*      */     case 28:
/* 1588 */       strFieldValue = StrTool.GBKToUnicode(this.health);
/* 1589 */       break;
/*      */     case 29:
/* 1591 */       strFieldValue = String.valueOf(this.stature);
/* 1592 */       break;
/*      */     case 30:
/* 1594 */       strFieldValue = String.valueOf(this.avoirdupois);
/* 1595 */       break;
/*      */     case 31:
/* 1597 */       strFieldValue = StrTool.GBKToUnicode(this.degree);
/* 1598 */       break;
/*      */     case 32:
/* 1600 */       strFieldValue = StrTool.GBKToUnicode(this.creditGrade);
/* 1601 */       break;
/*      */     case 33:
/* 1603 */       strFieldValue = StrTool.GBKToUnicode(this.bankCode);
/* 1604 */       break;
/*      */     case 34:
/* 1606 */       strFieldValue = StrTool.GBKToUnicode(this.bankAccNo);
/* 1607 */       break;
/*      */     case 35:
/* 1609 */       strFieldValue = StrTool.GBKToUnicode(this.accName);
/* 1610 */       break;
/*      */     case 36:
/* 1612 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
/* 1613 */       break;
/*      */     case 37:
/* 1615 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
/* 1616 */       break;
/*      */     case 38:
/* 1618 */       strFieldValue = StrTool.GBKToUnicode(this.position);
/* 1619 */       break;
/*      */     case 39:
/* 1621 */       strFieldValue = String.valueOf(this.salary);
/* 1622 */       break;
/*      */     case 40:
/* 1624 */       strFieldValue = StrTool.GBKToUnicode(this.occupationType);
/* 1625 */       break;
/*      */     case 41:
/* 1627 */       strFieldValue = StrTool.GBKToUnicode(this.occupationCode);
/* 1628 */       break;
/*      */     case 42:
/* 1630 */       strFieldValue = StrTool.GBKToUnicode(this.workType);
/* 1631 */       break;
/*      */     case 43:
/* 1633 */       strFieldValue = StrTool.GBKToUnicode(this.pluralityType);
/* 1634 */       break;
/*      */     case 44:
/* 1636 */       strFieldValue = StrTool.GBKToUnicode(this.smokeFlag);
/* 1637 */       break;
/*      */     case 45:
/* 1639 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1640 */       break;
/*      */     case 46:
/* 1642 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1643 */       break;
/*      */     case 47:
/* 1645 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/* 1646 */       break;
/*      */     case 48:
/* 1648 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1649 */       break;
/*      */     case 49:
/* 1651 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/* 1652 */       break;
/*      */     case 50:
/* 1654 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1655 */       break;
/*      */     default:
/* 1657 */       strFieldValue = "";
/*      */     }
/* 1659 */     if (strFieldValue.equals("")) {
/* 1660 */       strFieldValue = "null";
/*      */     }
/* 1662 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1668 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1669 */       return false;
/*      */     }
/* 1671 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 1673 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1675 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1678 */         this.EdorNo = null;
/*      */     }
/* 1680 */     if (FCode.equals("serialNo"))
/*      */     {
/* 1682 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1684 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/* 1687 */         this.serialNo = null;
/*      */     }
/* 1689 */     if (FCode.equals("grpContNo"))
/*      */     {
/* 1691 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1693 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1696 */         this.grpContNo = null;
/*      */     }
/* 1698 */     if (FCode.equals("contNo"))
/*      */     {
/* 1700 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1702 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 1705 */         this.contNo = null;
/*      */     }
/* 1707 */     if (FCode.equals("proposalContNo"))
/*      */     {
/* 1709 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1711 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1714 */         this.proposalContNo = null;
/*      */     }
/* 1716 */     if (FCode.equals("prtNo"))
/*      */     {
/* 1718 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1720 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/* 1723 */         this.prtNo = null;
/*      */     }
/* 1725 */     if (FCode.equals("appntNo"))
/*      */     {
/* 1727 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1729 */         this.appntNo = FValue.trim();
/*      */       }
/*      */       else
/* 1732 */         this.appntNo = null;
/*      */     }
/* 1734 */     if (FCode.equals("appntId"))
/*      */     {
/* 1736 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1738 */         this.appntId = FValue.trim();
/*      */       }
/*      */       else
/* 1741 */         this.appntId = null;
/*      */     }
/* 1743 */     if (FCode.equals("relationToInsured"))
/*      */     {
/* 1745 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1747 */         this.relationToInsured = FValue.trim();
/*      */       }
/*      */       else
/* 1750 */         this.relationToInsured = null;
/*      */     }
/* 1752 */     if (FCode.equals("appntGrade"))
/*      */     {
/* 1754 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1756 */         this.appntGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1759 */         this.appntGrade = null;
/*      */     }
/* 1761 */     if (FCode.equals("appellation"))
/*      */     {
/* 1763 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1765 */         this.appellation = FValue.trim();
/*      */       }
/*      */       else
/* 1768 */         this.appellation = null;
/*      */     }
/* 1770 */     if (FCode.equals("appntName"))
/*      */     {
/* 1772 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1774 */         this.appntName = FValue.trim();
/*      */       }
/*      */       else
/* 1777 */         this.appntName = null;
/*      */     }
/* 1779 */     if (FCode.equals("appntSex"))
/*      */     {
/* 1781 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1783 */         this.appntSex = FValue.trim();
/*      */       }
/*      */       else
/* 1786 */         this.appntSex = null;
/*      */     }
/* 1788 */     if (FCode.equals("appntBirthday"))
/*      */     {
/* 1790 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1792 */         this.appntBirthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1795 */         this.appntBirthday = null;
/*      */     }
/* 1797 */     if (FCode.equals("appntAge"))
/*      */     {
/* 1799 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1801 */         Integer tInteger = new Integer(FValue);
/* 1802 */         int i = tInteger.intValue();
/* 1803 */         this.appntAge = i;
/*      */       }
/*      */     }
/* 1806 */     if (FCode.equals("appntAgeType"))
/*      */     {
/* 1808 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1810 */         this.appntAgeType = FValue.trim();
/*      */       }
/*      */       else
/* 1813 */         this.appntAgeType = null;
/*      */     }
/* 1815 */     if (FCode.equals("appntType"))
/*      */     {
/* 1817 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1819 */         this.appntType = FValue.trim();
/*      */       }
/*      */       else
/* 1822 */         this.appntType = null;
/*      */     }
/* 1824 */     if (FCode.equals("addressNo"))
/*      */     {
/* 1826 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1828 */         this.addressNo = FValue.trim();
/*      */       }
/*      */       else
/* 1831 */         this.addressNo = null;
/*      */     }
/* 1833 */     if (FCode.equals("sequenceNo"))
/*      */     {
/* 1835 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1837 */         this.sequenceNo = FValue.trim();
/*      */       }
/*      */       else
/* 1840 */         this.sequenceNo = null;
/*      */     }
/* 1842 */     if (FCode.equals("iDType"))
/*      */     {
/* 1844 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1846 */         this.iDType = FValue.trim();
/*      */       }
/*      */       else
/* 1849 */         this.iDType = null;
/*      */     }
/* 1851 */     if (FCode.equals("iDNo"))
/*      */     {
/* 1853 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1855 */         this.iDNo = FValue.trim();
/*      */       }
/*      */       else
/* 1858 */         this.iDNo = null;
/*      */     }
/* 1860 */     if (FCode.equals("iDValidity"))
/*      */     {
/* 1862 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1864 */         this.iDValidity = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1867 */         this.iDValidity = null;
/*      */     }
/* 1869 */     if (FCode.equals("iDPerpetual"))
/*      */     {
/* 1871 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1873 */         this.iDPerpetual = FValue.trim();
/*      */       }
/*      */       else
/* 1876 */         this.iDPerpetual = null;
/*      */     }
/* 1878 */     if (FCode.equals("nativePlace"))
/*      */     {
/* 1880 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1882 */         this.nativePlace = FValue.trim();
/*      */       }
/*      */       else
/* 1885 */         this.nativePlace = null;
/*      */     }
/* 1887 */     if (FCode.equals("nationality"))
/*      */     {
/* 1889 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1891 */         this.nationality = FValue.trim();
/*      */       }
/*      */       else
/* 1894 */         this.nationality = null;
/*      */     }
/* 1896 */     if (FCode.equals("rgtAddress"))
/*      */     {
/* 1898 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1900 */         this.rgtAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1903 */         this.rgtAddress = null;
/*      */     }
/* 1905 */     if (FCode.equals("marriage"))
/*      */     {
/* 1907 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1909 */         this.marriage = FValue.trim();
/*      */       }
/*      */       else
/* 1912 */         this.marriage = null;
/*      */     }
/* 1914 */     if (FCode.equals("marriageDate"))
/*      */     {
/* 1916 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1918 */         this.marriageDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1921 */         this.marriageDate = null;
/*      */     }
/* 1923 */     if (FCode.equals("health"))
/*      */     {
/* 1925 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1927 */         this.health = FValue.trim();
/*      */       }
/*      */       else
/* 1930 */         this.health = null;
/*      */     }
/* 1932 */     if (FCode.equals("stature"))
/*      */     {
/* 1934 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1936 */         Double tDouble = new Double(FValue);
/* 1937 */         double d = tDouble.doubleValue();
/* 1938 */         this.stature = d;
/*      */       }
/*      */     }
/* 1941 */     if (FCode.equals("avoirdupois"))
/*      */     {
/* 1943 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1945 */         Double tDouble = new Double(FValue);
/* 1946 */         double d = tDouble.doubleValue();
/* 1947 */         this.avoirdupois = d;
/*      */       }
/*      */     }
/* 1950 */     if (FCode.equals("degree"))
/*      */     {
/* 1952 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1954 */         this.degree = FValue.trim();
/*      */       }
/*      */       else
/* 1957 */         this.degree = null;
/*      */     }
/* 1959 */     if (FCode.equals("creditGrade"))
/*      */     {
/* 1961 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1963 */         this.creditGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1966 */         this.creditGrade = null;
/*      */     }
/* 1968 */     if (FCode.equals("bankCode"))
/*      */     {
/* 1970 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1972 */         this.bankCode = FValue.trim();
/*      */       }
/*      */       else
/* 1975 */         this.bankCode = null;
/*      */     }
/* 1977 */     if (FCode.equals("bankAccNo"))
/*      */     {
/* 1979 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1981 */         this.bankAccNo = FValue.trim();
/*      */       }
/*      */       else
/* 1984 */         this.bankAccNo = null;
/*      */     }
/* 1986 */     if (FCode.equals("accName"))
/*      */     {
/* 1988 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1990 */         this.accName = FValue.trim();
/*      */       }
/*      */       else
/* 1993 */         this.accName = null;
/*      */     }
/* 1995 */     if (FCode.equals("joinCompanyDate"))
/*      */     {
/* 1997 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1999 */         this.joinCompanyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2002 */         this.joinCompanyDate = null;
/*      */     }
/* 2004 */     if (FCode.equals("startWorkDate"))
/*      */     {
/* 2006 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2008 */         this.startWorkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2011 */         this.startWorkDate = null;
/*      */     }
/* 2013 */     if (FCode.equals("position"))
/*      */     {
/* 2015 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2017 */         this.position = FValue.trim();
/*      */       }
/*      */       else
/* 2020 */         this.position = null;
/*      */     }
/* 2022 */     if (FCode.equals("salary"))
/*      */     {
/* 2024 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2026 */         Double tDouble = new Double(FValue);
/* 2027 */         double d = tDouble.doubleValue();
/* 2028 */         this.salary = d;
/*      */       }
/*      */     }
/* 2031 */     if (FCode.equals("occupationType"))
/*      */     {
/* 2033 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2035 */         this.occupationType = FValue.trim();
/*      */       }
/*      */       else
/* 2038 */         this.occupationType = null;
/*      */     }
/* 2040 */     if (FCode.equals("occupationCode"))
/*      */     {
/* 2042 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2044 */         this.occupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 2047 */         this.occupationCode = null;
/*      */     }
/* 2049 */     if (FCode.equals("workType"))
/*      */     {
/* 2051 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2053 */         this.workType = FValue.trim();
/*      */       }
/*      */       else
/* 2056 */         this.workType = null;
/*      */     }
/* 2058 */     if (FCode.equals("pluralityType"))
/*      */     {
/* 2060 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2062 */         this.pluralityType = FValue.trim();
/*      */       }
/*      */       else
/* 2065 */         this.pluralityType = null;
/*      */     }
/* 2067 */     if (FCode.equals("smokeFlag"))
/*      */     {
/* 2069 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2071 */         this.smokeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2074 */         this.smokeFlag = null;
/*      */     }
/* 2076 */     if (FCode.equals("operator"))
/*      */     {
/* 2078 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2080 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 2083 */         this.operator = null;
/*      */     }
/* 2085 */     if (FCode.equals("manageCom"))
/*      */     {
/* 2087 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2089 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 2092 */         this.manageCom = null;
/*      */     }
/* 2094 */     if (FCode.equals("makeDate"))
/*      */     {
/* 2096 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2098 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2101 */         this.makeDate = null;
/*      */     }
/* 2103 */     if (FCode.equals("makeTime"))
/*      */     {
/* 2105 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2107 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 2110 */         this.makeTime = null;
/*      */     }
/* 2112 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 2114 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2116 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2119 */         this.modifyDate = null;
/*      */     }
/* 2121 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 2123 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2125 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 2128 */         this.modifyTime = null;
/*      */     }
/* 2130 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 2135 */     if (this == otherObject) return true;
/* 2136 */     if (otherObject == null) return false;
/* 2137 */     if (getClass() != otherObject.getClass()) return false;
/* 2138 */     LNPAppntBSchema other = (LNPAppntBSchema)otherObject;
/* 2139 */     return 
/* 2140 */       (this.EdorNo.equals(other.getEdorNo())) && 
/* 2141 */       (this.serialNo.equals(other.getserialNo())) && 
/* 2142 */       (this.grpContNo.equals(other.getgrpContNo())) && 
/* 2143 */       (this.contNo.equals(other.getcontNo())) && 
/* 2144 */       (this.proposalContNo.equals(other.getproposalContNo())) && 
/* 2145 */       (this.prtNo.equals(other.getprtNo())) && 
/* 2146 */       (this.appntNo.equals(other.getappntNo())) && 
/* 2147 */       (this.appntId.equals(other.getappntId())) && 
/* 2148 */       (this.relationToInsured.equals(other.getrelationToInsured())) && 
/* 2149 */       (this.appntGrade.equals(other.getappntGrade())) && 
/* 2150 */       (this.appellation.equals(other.getappellation())) && 
/* 2151 */       (this.appntName.equals(other.getappntName())) && 
/* 2152 */       (this.appntSex.equals(other.getappntSex())) && 
/* 2153 */       (this.fDate.getString(this.appntBirthday).equals(other.getappntBirthday())) && 
/* 2154 */       (this.appntAge == other.getappntAge()) && 
/* 2155 */       (this.appntAgeType.equals(other.getappntAgeType())) && 
/* 2156 */       (this.appntType.equals(other.getappntType())) && 
/* 2157 */       (this.addressNo.equals(other.getaddressNo())) && 
/* 2158 */       (this.sequenceNo.equals(other.getsequenceNo())) && 
/* 2159 */       (this.iDType.equals(other.getiDType())) && 
/* 2160 */       (this.iDNo.equals(other.getiDNo())) && 
/* 2161 */       (this.fDate.getString(this.iDValidity).equals(other.getiDValidity())) && 
/* 2162 */       (this.iDPerpetual.equals(other.getiDPerpetual())) && 
/* 2163 */       (this.nativePlace.equals(other.getnativePlace())) && 
/* 2164 */       (this.nationality.equals(other.getnationality())) && 
/* 2165 */       (this.rgtAddress.equals(other.getrgtAddress())) && 
/* 2166 */       (this.marriage.equals(other.getmarriage())) && 
/* 2167 */       (this.fDate.getString(this.marriageDate).equals(other.getmarriageDate())) && 
/* 2168 */       (this.health.equals(other.gethealth())) && 
/* 2169 */       (this.stature == other.getstature()) && 
/* 2170 */       (this.avoirdupois == other.getavoirdupois()) && 
/* 2171 */       (this.degree.equals(other.getdegree())) && 
/* 2172 */       (this.creditGrade.equals(other.getcreditGrade())) && 
/* 2173 */       (this.bankCode.equals(other.getbankCode())) && 
/* 2174 */       (this.bankAccNo.equals(other.getbankAccNo())) && 
/* 2175 */       (this.accName.equals(other.getaccName())) && 
/* 2176 */       (this.fDate.getString(this.joinCompanyDate).equals(other.getjoinCompanyDate())) && 
/* 2177 */       (this.fDate.getString(this.startWorkDate).equals(other.getstartWorkDate())) && 
/* 2178 */       (this.position.equals(other.getposition())) && 
/* 2179 */       (this.salary == other.getsalary()) && 
/* 2180 */       (this.occupationType.equals(other.getoccupationType())) && 
/* 2181 */       (this.occupationCode.equals(other.getoccupationCode())) && 
/* 2182 */       (this.workType.equals(other.getworkType())) && 
/* 2183 */       (this.pluralityType.equals(other.getpluralityType())) && 
/* 2184 */       (this.smokeFlag.equals(other.getsmokeFlag())) && 
/* 2185 */       (this.operator.equals(other.getoperator())) && 
/* 2186 */       (this.manageCom.equals(other.getmanageCom())) && 
/* 2187 */       (this.fDate.getString(this.makeDate).equals(other.getmakeDate())) && 
/* 2188 */       (this.makeTime.equals(other.getmakeTime())) && 
/* 2189 */       (this.fDate.getString(this.modifyDate).equals(other.getmodifyDate())) && 
/* 2190 */       (this.modifyTime.equals(other.getmodifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2196 */     return 51;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2202 */     if (strFieldName.equals("EdorNo")) {
/* 2203 */       return 0;
/*      */     }
/* 2205 */     if (strFieldName.equals("serialNo")) {
/* 2206 */       return 1;
/*      */     }
/* 2208 */     if (strFieldName.equals("grpContNo")) {
/* 2209 */       return 2;
/*      */     }
/* 2211 */     if (strFieldName.equals("contNo")) {
/* 2212 */       return 3;
/*      */     }
/* 2214 */     if (strFieldName.equals("proposalContNo")) {
/* 2215 */       return 4;
/*      */     }
/* 2217 */     if (strFieldName.equals("prtNo")) {
/* 2218 */       return 5;
/*      */     }
/* 2220 */     if (strFieldName.equals("appntNo")) {
/* 2221 */       return 6;
/*      */     }
/* 2223 */     if (strFieldName.equals("appntId")) {
/* 2224 */       return 7;
/*      */     }
/* 2226 */     if (strFieldName.equals("relationToInsured")) {
/* 2227 */       return 8;
/*      */     }
/* 2229 */     if (strFieldName.equals("appntGrade")) {
/* 2230 */       return 9;
/*      */     }
/* 2232 */     if (strFieldName.equals("appellation")) {
/* 2233 */       return 10;
/*      */     }
/* 2235 */     if (strFieldName.equals("appntName")) {
/* 2236 */       return 11;
/*      */     }
/* 2238 */     if (strFieldName.equals("appntSex")) {
/* 2239 */       return 12;
/*      */     }
/* 2241 */     if (strFieldName.equals("appntBirthday")) {
/* 2242 */       return 13;
/*      */     }
/* 2244 */     if (strFieldName.equals("appntAge")) {
/* 2245 */       return 14;
/*      */     }
/* 2247 */     if (strFieldName.equals("appntAgeType")) {
/* 2248 */       return 15;
/*      */     }
/* 2250 */     if (strFieldName.equals("appntType")) {
/* 2251 */       return 16;
/*      */     }
/* 2253 */     if (strFieldName.equals("addressNo")) {
/* 2254 */       return 17;
/*      */     }
/* 2256 */     if (strFieldName.equals("sequenceNo")) {
/* 2257 */       return 18;
/*      */     }
/* 2259 */     if (strFieldName.equals("iDType")) {
/* 2260 */       return 19;
/*      */     }
/* 2262 */     if (strFieldName.equals("iDNo")) {
/* 2263 */       return 20;
/*      */     }
/* 2265 */     if (strFieldName.equals("iDValidity")) {
/* 2266 */       return 21;
/*      */     }
/* 2268 */     if (strFieldName.equals("iDPerpetual")) {
/* 2269 */       return 22;
/*      */     }
/* 2271 */     if (strFieldName.equals("nativePlace")) {
/* 2272 */       return 23;
/*      */     }
/* 2274 */     if (strFieldName.equals("nationality")) {
/* 2275 */       return 24;
/*      */     }
/* 2277 */     if (strFieldName.equals("rgtAddress")) {
/* 2278 */       return 25;
/*      */     }
/* 2280 */     if (strFieldName.equals("marriage")) {
/* 2281 */       return 26;
/*      */     }
/* 2283 */     if (strFieldName.equals("marriageDate")) {
/* 2284 */       return 27;
/*      */     }
/* 2286 */     if (strFieldName.equals("health")) {
/* 2287 */       return 28;
/*      */     }
/* 2289 */     if (strFieldName.equals("stature")) {
/* 2290 */       return 29;
/*      */     }
/* 2292 */     if (strFieldName.equals("avoirdupois")) {
/* 2293 */       return 30;
/*      */     }
/* 2295 */     if (strFieldName.equals("degree")) {
/* 2296 */       return 31;
/*      */     }
/* 2298 */     if (strFieldName.equals("creditGrade")) {
/* 2299 */       return 32;
/*      */     }
/* 2301 */     if (strFieldName.equals("bankCode")) {
/* 2302 */       return 33;
/*      */     }
/* 2304 */     if (strFieldName.equals("bankAccNo")) {
/* 2305 */       return 34;
/*      */     }
/* 2307 */     if (strFieldName.equals("accName")) {
/* 2308 */       return 35;
/*      */     }
/* 2310 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2311 */       return 36;
/*      */     }
/* 2313 */     if (strFieldName.equals("startWorkDate")) {
/* 2314 */       return 37;
/*      */     }
/* 2316 */     if (strFieldName.equals("position")) {
/* 2317 */       return 38;
/*      */     }
/* 2319 */     if (strFieldName.equals("salary")) {
/* 2320 */       return 39;
/*      */     }
/* 2322 */     if (strFieldName.equals("occupationType")) {
/* 2323 */       return 40;
/*      */     }
/* 2325 */     if (strFieldName.equals("occupationCode")) {
/* 2326 */       return 41;
/*      */     }
/* 2328 */     if (strFieldName.equals("workType")) {
/* 2329 */       return 42;
/*      */     }
/* 2331 */     if (strFieldName.equals("pluralityType")) {
/* 2332 */       return 43;
/*      */     }
/* 2334 */     if (strFieldName.equals("smokeFlag")) {
/* 2335 */       return 44;
/*      */     }
/* 2337 */     if (strFieldName.equals("operator")) {
/* 2338 */       return 45;
/*      */     }
/* 2340 */     if (strFieldName.equals("manageCom")) {
/* 2341 */       return 46;
/*      */     }
/* 2343 */     if (strFieldName.equals("makeDate")) {
/* 2344 */       return 47;
/*      */     }
/* 2346 */     if (strFieldName.equals("makeTime")) {
/* 2347 */       return 48;
/*      */     }
/* 2349 */     if (strFieldName.equals("modifyDate")) {
/* 2350 */       return 49;
/*      */     }
/* 2352 */     if (strFieldName.equals("modifyTime")) {
/* 2353 */       return 50;
/*      */     }
/* 2355 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2361 */     String strFieldName = "";
/* 2362 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2364 */       strFieldName = "EdorNo";
/* 2365 */       break;
/*      */     case 1:
/* 2367 */       strFieldName = "serialNo";
/* 2368 */       break;
/*      */     case 2:
/* 2370 */       strFieldName = "grpContNo";
/* 2371 */       break;
/*      */     case 3:
/* 2373 */       strFieldName = "contNo";
/* 2374 */       break;
/*      */     case 4:
/* 2376 */       strFieldName = "proposalContNo";
/* 2377 */       break;
/*      */     case 5:
/* 2379 */       strFieldName = "prtNo";
/* 2380 */       break;
/*      */     case 6:
/* 2382 */       strFieldName = "appntNo";
/* 2383 */       break;
/*      */     case 7:
/* 2385 */       strFieldName = "appntId";
/* 2386 */       break;
/*      */     case 8:
/* 2388 */       strFieldName = "relationToInsured";
/* 2389 */       break;
/*      */     case 9:
/* 2391 */       strFieldName = "appntGrade";
/* 2392 */       break;
/*      */     case 10:
/* 2394 */       strFieldName = "appellation";
/* 2395 */       break;
/*      */     case 11:
/* 2397 */       strFieldName = "appntName";
/* 2398 */       break;
/*      */     case 12:
/* 2400 */       strFieldName = "appntSex";
/* 2401 */       break;
/*      */     case 13:
/* 2403 */       strFieldName = "appntBirthday";
/* 2404 */       break;
/*      */     case 14:
/* 2406 */       strFieldName = "appntAge";
/* 2407 */       break;
/*      */     case 15:
/* 2409 */       strFieldName = "appntAgeType";
/* 2410 */       break;
/*      */     case 16:
/* 2412 */       strFieldName = "appntType";
/* 2413 */       break;
/*      */     case 17:
/* 2415 */       strFieldName = "addressNo";
/* 2416 */       break;
/*      */     case 18:
/* 2418 */       strFieldName = "sequenceNo";
/* 2419 */       break;
/*      */     case 19:
/* 2421 */       strFieldName = "iDType";
/* 2422 */       break;
/*      */     case 20:
/* 2424 */       strFieldName = "iDNo";
/* 2425 */       break;
/*      */     case 21:
/* 2427 */       strFieldName = "iDValidity";
/* 2428 */       break;
/*      */     case 22:
/* 2430 */       strFieldName = "iDPerpetual";
/* 2431 */       break;
/*      */     case 23:
/* 2433 */       strFieldName = "nativePlace";
/* 2434 */       break;
/*      */     case 24:
/* 2436 */       strFieldName = "nationality";
/* 2437 */       break;
/*      */     case 25:
/* 2439 */       strFieldName = "rgtAddress";
/* 2440 */       break;
/*      */     case 26:
/* 2442 */       strFieldName = "marriage";
/* 2443 */       break;
/*      */     case 27:
/* 2445 */       strFieldName = "marriageDate";
/* 2446 */       break;
/*      */     case 28:
/* 2448 */       strFieldName = "health";
/* 2449 */       break;
/*      */     case 29:
/* 2451 */       strFieldName = "stature";
/* 2452 */       break;
/*      */     case 30:
/* 2454 */       strFieldName = "avoirdupois";
/* 2455 */       break;
/*      */     case 31:
/* 2457 */       strFieldName = "degree";
/* 2458 */       break;
/*      */     case 32:
/* 2460 */       strFieldName = "creditGrade";
/* 2461 */       break;
/*      */     case 33:
/* 2463 */       strFieldName = "bankCode";
/* 2464 */       break;
/*      */     case 34:
/* 2466 */       strFieldName = "bankAccNo";
/* 2467 */       break;
/*      */     case 35:
/* 2469 */       strFieldName = "accName";
/* 2470 */       break;
/*      */     case 36:
/* 2472 */       strFieldName = "joinCompanyDate";
/* 2473 */       break;
/*      */     case 37:
/* 2475 */       strFieldName = "startWorkDate";
/* 2476 */       break;
/*      */     case 38:
/* 2478 */       strFieldName = "position";
/* 2479 */       break;
/*      */     case 39:
/* 2481 */       strFieldName = "salary";
/* 2482 */       break;
/*      */     case 40:
/* 2484 */       strFieldName = "occupationType";
/* 2485 */       break;
/*      */     case 41:
/* 2487 */       strFieldName = "occupationCode";
/* 2488 */       break;
/*      */     case 42:
/* 2490 */       strFieldName = "workType";
/* 2491 */       break;
/*      */     case 43:
/* 2493 */       strFieldName = "pluralityType";
/* 2494 */       break;
/*      */     case 44:
/* 2496 */       strFieldName = "smokeFlag";
/* 2497 */       break;
/*      */     case 45:
/* 2499 */       strFieldName = "operator";
/* 2500 */       break;
/*      */     case 46:
/* 2502 */       strFieldName = "manageCom";
/* 2503 */       break;
/*      */     case 47:
/* 2505 */       strFieldName = "makeDate";
/* 2506 */       break;
/*      */     case 48:
/* 2508 */       strFieldName = "makeTime";
/* 2509 */       break;
/*      */     case 49:
/* 2511 */       strFieldName = "modifyDate";
/* 2512 */       break;
/*      */     case 50:
/* 2514 */       strFieldName = "modifyTime";
/* 2515 */       break;
/*      */     default:
/* 2517 */       strFieldName = "";
/*      */     }
/* 2519 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2525 */     if (strFieldName.equals("EdorNo")) {
/* 2526 */       return 0;
/*      */     }
/* 2528 */     if (strFieldName.equals("serialNo")) {
/* 2529 */       return 0;
/*      */     }
/* 2531 */     if (strFieldName.equals("grpContNo")) {
/* 2532 */       return 0;
/*      */     }
/* 2534 */     if (strFieldName.equals("contNo")) {
/* 2535 */       return 0;
/*      */     }
/* 2537 */     if (strFieldName.equals("proposalContNo")) {
/* 2538 */       return 0;
/*      */     }
/* 2540 */     if (strFieldName.equals("prtNo")) {
/* 2541 */       return 0;
/*      */     }
/* 2543 */     if (strFieldName.equals("appntNo")) {
/* 2544 */       return 0;
/*      */     }
/* 2546 */     if (strFieldName.equals("appntId")) {
/* 2547 */       return 0;
/*      */     }
/* 2549 */     if (strFieldName.equals("relationToInsured")) {
/* 2550 */       return 0;
/*      */     }
/* 2552 */     if (strFieldName.equals("appntGrade")) {
/* 2553 */       return 0;
/*      */     }
/* 2555 */     if (strFieldName.equals("appellation")) {
/* 2556 */       return 0;
/*      */     }
/* 2558 */     if (strFieldName.equals("appntName")) {
/* 2559 */       return 0;
/*      */     }
/* 2561 */     if (strFieldName.equals("appntSex")) {
/* 2562 */       return 0;
/*      */     }
/* 2564 */     if (strFieldName.equals("appntBirthday")) {
/* 2565 */       return 1;
/*      */     }
/* 2567 */     if (strFieldName.equals("appntAge")) {
/* 2568 */       return 3;
/*      */     }
/* 2570 */     if (strFieldName.equals("appntAgeType")) {
/* 2571 */       return 0;
/*      */     }
/* 2573 */     if (strFieldName.equals("appntType")) {
/* 2574 */       return 0;
/*      */     }
/* 2576 */     if (strFieldName.equals("addressNo")) {
/* 2577 */       return 0;
/*      */     }
/* 2579 */     if (strFieldName.equals("sequenceNo")) {
/* 2580 */       return 0;
/*      */     }
/* 2582 */     if (strFieldName.equals("iDType")) {
/* 2583 */       return 0;
/*      */     }
/* 2585 */     if (strFieldName.equals("iDNo")) {
/* 2586 */       return 0;
/*      */     }
/* 2588 */     if (strFieldName.equals("iDValidity")) {
/* 2589 */       return 1;
/*      */     }
/* 2591 */     if (strFieldName.equals("iDPerpetual")) {
/* 2592 */       return 0;
/*      */     }
/* 2594 */     if (strFieldName.equals("nativePlace")) {
/* 2595 */       return 0;
/*      */     }
/* 2597 */     if (strFieldName.equals("nationality")) {
/* 2598 */       return 0;
/*      */     }
/* 2600 */     if (strFieldName.equals("rgtAddress")) {
/* 2601 */       return 0;
/*      */     }
/* 2603 */     if (strFieldName.equals("marriage")) {
/* 2604 */       return 0;
/*      */     }
/* 2606 */     if (strFieldName.equals("marriageDate")) {
/* 2607 */       return 1;
/*      */     }
/* 2609 */     if (strFieldName.equals("health")) {
/* 2610 */       return 0;
/*      */     }
/* 2612 */     if (strFieldName.equals("stature")) {
/* 2613 */       return 4;
/*      */     }
/* 2615 */     if (strFieldName.equals("avoirdupois")) {
/* 2616 */       return 4;
/*      */     }
/* 2618 */     if (strFieldName.equals("degree")) {
/* 2619 */       return 0;
/*      */     }
/* 2621 */     if (strFieldName.equals("creditGrade")) {
/* 2622 */       return 0;
/*      */     }
/* 2624 */     if (strFieldName.equals("bankCode")) {
/* 2625 */       return 0;
/*      */     }
/* 2627 */     if (strFieldName.equals("bankAccNo")) {
/* 2628 */       return 0;
/*      */     }
/* 2630 */     if (strFieldName.equals("accName")) {
/* 2631 */       return 0;
/*      */     }
/* 2633 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2634 */       return 1;
/*      */     }
/* 2636 */     if (strFieldName.equals("startWorkDate")) {
/* 2637 */       return 1;
/*      */     }
/* 2639 */     if (strFieldName.equals("position")) {
/* 2640 */       return 0;
/*      */     }
/* 2642 */     if (strFieldName.equals("salary")) {
/* 2643 */       return 4;
/*      */     }
/* 2645 */     if (strFieldName.equals("occupationType")) {
/* 2646 */       return 0;
/*      */     }
/* 2648 */     if (strFieldName.equals("occupationCode")) {
/* 2649 */       return 0;
/*      */     }
/* 2651 */     if (strFieldName.equals("workType")) {
/* 2652 */       return 0;
/*      */     }
/* 2654 */     if (strFieldName.equals("pluralityType")) {
/* 2655 */       return 0;
/*      */     }
/* 2657 */     if (strFieldName.equals("smokeFlag")) {
/* 2658 */       return 0;
/*      */     }
/* 2660 */     if (strFieldName.equals("operator")) {
/* 2661 */       return 0;
/*      */     }
/* 2663 */     if (strFieldName.equals("manageCom")) {
/* 2664 */       return 0;
/*      */     }
/* 2666 */     if (strFieldName.equals("makeDate")) {
/* 2667 */       return 1;
/*      */     }
/* 2669 */     if (strFieldName.equals("makeTime")) {
/* 2670 */       return 0;
/*      */     }
/* 2672 */     if (strFieldName.equals("modifyDate")) {
/* 2673 */       return 1;
/*      */     }
/* 2675 */     if (strFieldName.equals("modifyTime")) {
/* 2676 */       return 0;
/*      */     }
/* 2678 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 2684 */     int nFieldType = -1;
/* 2685 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2687 */       nFieldType = 0;
/* 2688 */       break;
/*      */     case 1:
/* 2690 */       nFieldType = 0;
/* 2691 */       break;
/*      */     case 2:
/* 2693 */       nFieldType = 0;
/* 2694 */       break;
/*      */     case 3:
/* 2696 */       nFieldType = 0;
/* 2697 */       break;
/*      */     case 4:
/* 2699 */       nFieldType = 0;
/* 2700 */       break;
/*      */     case 5:
/* 2702 */       nFieldType = 0;
/* 2703 */       break;
/*      */     case 6:
/* 2705 */       nFieldType = 0;
/* 2706 */       break;
/*      */     case 7:
/* 2708 */       nFieldType = 0;
/* 2709 */       break;
/*      */     case 8:
/* 2711 */       nFieldType = 0;
/* 2712 */       break;
/*      */     case 9:
/* 2714 */       nFieldType = 0;
/* 2715 */       break;
/*      */     case 10:
/* 2717 */       nFieldType = 0;
/* 2718 */       break;
/*      */     case 11:
/* 2720 */       nFieldType = 0;
/* 2721 */       break;
/*      */     case 12:
/* 2723 */       nFieldType = 0;
/* 2724 */       break;
/*      */     case 13:
/* 2726 */       nFieldType = 1;
/* 2727 */       break;
/*      */     case 14:
/* 2729 */       nFieldType = 3;
/* 2730 */       break;
/*      */     case 15:
/* 2732 */       nFieldType = 0;
/* 2733 */       break;
/*      */     case 16:
/* 2735 */       nFieldType = 0;
/* 2736 */       break;
/*      */     case 17:
/* 2738 */       nFieldType = 0;
/* 2739 */       break;
/*      */     case 18:
/* 2741 */       nFieldType = 0;
/* 2742 */       break;
/*      */     case 19:
/* 2744 */       nFieldType = 0;
/* 2745 */       break;
/*      */     case 20:
/* 2747 */       nFieldType = 0;
/* 2748 */       break;
/*      */     case 21:
/* 2750 */       nFieldType = 1;
/* 2751 */       break;
/*      */     case 22:
/* 2753 */       nFieldType = 0;
/* 2754 */       break;
/*      */     case 23:
/* 2756 */       nFieldType = 0;
/* 2757 */       break;
/*      */     case 24:
/* 2759 */       nFieldType = 0;
/* 2760 */       break;
/*      */     case 25:
/* 2762 */       nFieldType = 0;
/* 2763 */       break;
/*      */     case 26:
/* 2765 */       nFieldType = 0;
/* 2766 */       break;
/*      */     case 27:
/* 2768 */       nFieldType = 1;
/* 2769 */       break;
/*      */     case 28:
/* 2771 */       nFieldType = 0;
/* 2772 */       break;
/*      */     case 29:
/* 2774 */       nFieldType = 4;
/* 2775 */       break;
/*      */     case 30:
/* 2777 */       nFieldType = 4;
/* 2778 */       break;
/*      */     case 31:
/* 2780 */       nFieldType = 0;
/* 2781 */       break;
/*      */     case 32:
/* 2783 */       nFieldType = 0;
/* 2784 */       break;
/*      */     case 33:
/* 2786 */       nFieldType = 0;
/* 2787 */       break;
/*      */     case 34:
/* 2789 */       nFieldType = 0;
/* 2790 */       break;
/*      */     case 35:
/* 2792 */       nFieldType = 0;
/* 2793 */       break;
/*      */     case 36:
/* 2795 */       nFieldType = 1;
/* 2796 */       break;
/*      */     case 37:
/* 2798 */       nFieldType = 1;
/* 2799 */       break;
/*      */     case 38:
/* 2801 */       nFieldType = 0;
/* 2802 */       break;
/*      */     case 39:
/* 2804 */       nFieldType = 4;
/* 2805 */       break;
/*      */     case 40:
/* 2807 */       nFieldType = 0;
/* 2808 */       break;
/*      */     case 41:
/* 2810 */       nFieldType = 0;
/* 2811 */       break;
/*      */     case 42:
/* 2813 */       nFieldType = 0;
/* 2814 */       break;
/*      */     case 43:
/* 2816 */       nFieldType = 0;
/* 2817 */       break;
/*      */     case 44:
/* 2819 */       nFieldType = 0;
/* 2820 */       break;
/*      */     case 45:
/* 2822 */       nFieldType = 0;
/* 2823 */       break;
/*      */     case 46:
/* 2825 */       nFieldType = 0;
/* 2826 */       break;
/*      */     case 47:
/* 2828 */       nFieldType = 1;
/* 2829 */       break;
/*      */     case 48:
/* 2831 */       nFieldType = 0;
/* 2832 */       break;
/*      */     case 49:
/* 2834 */       nFieldType = 1;
/* 2835 */       break;
/*      */     case 50:
/* 2837 */       nFieldType = 0;
/* 2838 */       break;
/*      */     default:
/* 2840 */       nFieldType = -1;
/*      */     }
/* 2842 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPAppntBSchema
 * JD-Core Version:    0.6.0
 */