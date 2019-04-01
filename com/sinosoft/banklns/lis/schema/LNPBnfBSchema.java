/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPBnfBDB;
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
/*      */ public class LNPBnfBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
/*      */   private String contNo;
/*      */   private String polNo;
/*      */   private String insuredNo;
/*      */   private String insuredId;
/*      */   private String benefitType;
/*      */   private int bnfOrder;
/*      */   private String bnfGrade;
/*      */   private double benefitRate;
/*      */   private String benefitOrder;
/*      */   private String bnfNo;
/*      */   private String bnfId;
/*      */   private String appellation;
/*      */   private String bnfName;
/*      */   private String bnfSex;
/*      */   private Date bnfBirthday;
/*      */   private int bnfAge;
/*      */   private String relationToInsured;
/*      */   private String addressNo;
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
/*      */   private String bnfFlag;
/*      */   private String operator;
/*      */   private String manageCom;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 53;
/*      */   private static String[] PK;
/*  131 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPBnfBSchema()
/*      */   {
/*  138 */     this.mErrors = new CErrors();
/*      */ 
/*  140 */     String[] pk = new String[2];
/*  141 */     pk[0] = "EdorNo";
/*  142 */     pk[1] = "serialNo";
/*      */ 
/*  144 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  150 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  155 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*  159 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  163 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*  167 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  171 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  175 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getcontNo() {
/*  179 */     if (this.contNo != null) this.contNo.equals("");
/*      */ 
/*  183 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setcontNo(String acontNo) {
/*  187 */     this.contNo = acontNo;
/*      */   }
/*      */ 
/*      */   public String getpolNo() {
/*  191 */     if (this.polNo != null) this.polNo.equals("");
/*      */ 
/*  195 */     return this.polNo;
/*      */   }
/*      */ 
/*      */   public void setpolNo(String apolNo) {
/*  199 */     this.polNo = apolNo;
/*      */   }
/*      */ 
/*      */   public String getinsuredNo() {
/*  203 */     if (this.insuredNo != null) this.insuredNo.equals("");
/*      */ 
/*  207 */     return this.insuredNo;
/*      */   }
/*      */ 
/*      */   public void setinsuredNo(String ainsuredNo) {
/*  211 */     this.insuredNo = ainsuredNo;
/*      */   }
/*      */ 
/*      */   public String getinsuredId() {
/*  215 */     if (this.insuredId != null) this.insuredId.equals("");
/*      */ 
/*  219 */     return this.insuredId;
/*      */   }
/*      */ 
/*      */   public void setinsuredId(String ainsuredId) {
/*  223 */     this.insuredId = ainsuredId;
/*      */   }
/*      */ 
/*      */   public String getbenefitType() {
/*  227 */     if (this.benefitType != null) this.benefitType.equals("");
/*      */ 
/*  231 */     return this.benefitType;
/*      */   }
/*      */ 
/*      */   public void setbenefitType(String abenefitType) {
/*  235 */     this.benefitType = abenefitType;
/*      */   }
/*      */ 
/*      */   public int getbnfOrder() {
/*  239 */     return this.bnfOrder;
/*      */   }
/*      */ 
/*      */   public void setbnfOrder(int abnfOrder) {
/*  243 */     this.bnfOrder = abnfOrder;
/*      */   }
/*      */ 
/*      */   public void setbnfOrder(String abnfOrder) {
/*  247 */     if ((abnfOrder != null) && (!abnfOrder.equals("")))
/*      */     {
/*  249 */       Integer tInteger = new Integer(abnfOrder);
/*  250 */       int i = tInteger.intValue();
/*  251 */       this.bnfOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getbnfGrade()
/*      */   {
/*  257 */     if (this.bnfGrade != null) this.bnfGrade.equals("");
/*      */ 
/*  261 */     return this.bnfGrade;
/*      */   }
/*      */ 
/*      */   public void setbnfGrade(String abnfGrade) {
/*  265 */     this.bnfGrade = abnfGrade;
/*      */   }
/*      */ 
/*      */   public double getbenefitRate() {
/*  269 */     return this.benefitRate;
/*      */   }
/*      */ 
/*      */   public void setbenefitRate(double abenefitRate) {
/*  273 */     this.benefitRate = abenefitRate;
/*      */   }
/*      */ 
/*      */   public void setbenefitRate(String abenefitRate) {
/*  277 */     if ((abenefitRate != null) && (!abenefitRate.equals("")))
/*      */     {
/*  279 */       Double tDouble = new Double(abenefitRate);
/*  280 */       double d = tDouble.doubleValue();
/*  281 */       this.benefitRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getbenefitOrder()
/*      */   {
/*  287 */     if (this.benefitOrder != null) this.benefitOrder.equals("");
/*      */ 
/*  291 */     return this.benefitOrder;
/*      */   }
/*      */ 
/*      */   public void setbenefitOrder(String abenefitOrder) {
/*  295 */     this.benefitOrder = abenefitOrder;
/*      */   }
/*      */ 
/*      */   public String getbnfNo() {
/*  299 */     if (this.bnfNo != null) this.bnfNo.equals("");
/*      */ 
/*  303 */     return this.bnfNo;
/*      */   }
/*      */ 
/*      */   public void setbnfNo(String abnfNo) {
/*  307 */     this.bnfNo = abnfNo;
/*      */   }
/*      */ 
/*      */   public String getbnfId() {
/*  311 */     if (this.bnfId != null) this.bnfId.equals("");
/*      */ 
/*  315 */     return this.bnfId;
/*      */   }
/*      */ 
/*      */   public void setbnfId(String abnfId) {
/*  319 */     this.bnfId = abnfId;
/*      */   }
/*      */ 
/*      */   public String getappellation() {
/*  323 */     if (this.appellation != null) this.appellation.equals("");
/*      */ 
/*  327 */     return this.appellation;
/*      */   }
/*      */ 
/*      */   public void setappellation(String aappellation) {
/*  331 */     this.appellation = aappellation;
/*      */   }
/*      */ 
/*      */   public String getbnfName() {
/*  335 */     if (this.bnfName != null) this.bnfName.equals("");
/*      */ 
/*  339 */     return this.bnfName;
/*      */   }
/*      */ 
/*      */   public void setbnfName(String abnfName) {
/*  343 */     this.bnfName = abnfName;
/*      */   }
/*      */ 
/*      */   public String getbnfSex() {
/*  347 */     if (this.bnfSex != null) this.bnfSex.equals("");
/*      */ 
/*  351 */     return this.bnfSex;
/*      */   }
/*      */ 
/*      */   public void setbnfSex(String abnfSex) {
/*  355 */     this.bnfSex = abnfSex;
/*      */   }
/*      */ 
/*      */   public String getbnfBirthday() {
/*  359 */     if (this.bnfBirthday != null) {
/*  360 */       return this.fDate.getString(this.bnfBirthday);
/*      */     }
/*  362 */     return null;
/*      */   }
/*      */ 
/*      */   public void setbnfBirthday(Date abnfBirthday) {
/*  366 */     this.bnfBirthday = abnfBirthday;
/*      */   }
/*      */ 
/*      */   public void setbnfBirthday(String abnfBirthday) {
/*  370 */     if ((abnfBirthday != null) && (!abnfBirthday.equals("")))
/*      */     {
/*  372 */       this.bnfBirthday = this.fDate.getDate(abnfBirthday);
/*      */     }
/*      */     else
/*  375 */       this.bnfBirthday = null;
/*      */   }
/*      */ 
/*      */   public int getbnfAge()
/*      */   {
/*  380 */     return this.bnfAge;
/*      */   }
/*      */ 
/*      */   public void setbnfAge(int abnfAge) {
/*  384 */     this.bnfAge = abnfAge;
/*      */   }
/*      */ 
/*      */   public void setbnfAge(String abnfAge) {
/*  388 */     if ((abnfAge != null) && (!abnfAge.equals("")))
/*      */     {
/*  390 */       Integer tInteger = new Integer(abnfAge);
/*  391 */       int i = tInteger.intValue();
/*  392 */       this.bnfAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getrelationToInsured()
/*      */   {
/*  398 */     if (this.relationToInsured != null) this.relationToInsured.equals("");
/*      */ 
/*  402 */     return this.relationToInsured;
/*      */   }
/*      */ 
/*      */   public void setrelationToInsured(String arelationToInsured) {
/*  406 */     this.relationToInsured = arelationToInsured;
/*      */   }
/*      */ 
/*      */   public String getaddressNo() {
/*  410 */     if (this.addressNo != null) this.addressNo.equals("");
/*      */ 
/*  414 */     return this.addressNo;
/*      */   }
/*      */ 
/*      */   public void setaddressNo(String aaddressNo) {
/*  418 */     this.addressNo = aaddressNo;
/*      */   }
/*      */ 
/*      */   public String getiDType() {
/*  422 */     if (this.iDType != null) this.iDType.equals("");
/*      */ 
/*  426 */     return this.iDType;
/*      */   }
/*      */ 
/*      */   public void setiDType(String aiDType) {
/*  430 */     this.iDType = aiDType;
/*      */   }
/*      */ 
/*      */   public String getiDNo() {
/*  434 */     if (this.iDNo != null) this.iDNo.equals("");
/*      */ 
/*  438 */     return this.iDNo;
/*      */   }
/*      */ 
/*      */   public void setiDNo(String aiDNo) {
/*  442 */     this.iDNo = aiDNo;
/*      */   }
/*      */ 
/*      */   public String getiDValidity() {
/*  446 */     if (this.iDValidity != null) {
/*  447 */       return this.fDate.getString(this.iDValidity);
/*      */     }
/*  449 */     return null;
/*      */   }
/*      */ 
/*      */   public void setiDValidity(Date aiDValidity) {
/*  453 */     this.iDValidity = aiDValidity;
/*      */   }
/*      */ 
/*      */   public void setiDValidity(String aiDValidity) {
/*  457 */     if ((aiDValidity != null) && (!aiDValidity.equals("")))
/*      */     {
/*  459 */       this.iDValidity = this.fDate.getDate(aiDValidity);
/*      */     }
/*      */     else
/*  462 */       this.iDValidity = null;
/*      */   }
/*      */ 
/*      */   public String getiDPerpetual()
/*      */   {
/*  467 */     if (this.iDPerpetual != null) this.iDPerpetual.equals("");
/*      */ 
/*  471 */     return this.iDPerpetual;
/*      */   }
/*      */ 
/*      */   public void setiDPerpetual(String aiDPerpetual) {
/*  475 */     this.iDPerpetual = aiDPerpetual;
/*      */   }
/*      */ 
/*      */   public String getnativePlace() {
/*  479 */     if (this.nativePlace != null) this.nativePlace.equals("");
/*      */ 
/*  483 */     return this.nativePlace;
/*      */   }
/*      */ 
/*      */   public void setnativePlace(String anativePlace) {
/*  487 */     this.nativePlace = anativePlace;
/*      */   }
/*      */ 
/*      */   public String getnationality() {
/*  491 */     if (this.nationality != null) this.nationality.equals("");
/*      */ 
/*  495 */     return this.nationality;
/*      */   }
/*      */ 
/*      */   public void setnationality(String anationality) {
/*  499 */     this.nationality = anationality;
/*      */   }
/*      */ 
/*      */   public String getrgtAddress() {
/*  503 */     if (this.rgtAddress != null) this.rgtAddress.equals("");
/*      */ 
/*  507 */     return this.rgtAddress;
/*      */   }
/*      */ 
/*      */   public void setrgtAddress(String argtAddress) {
/*  511 */     this.rgtAddress = argtAddress;
/*      */   }
/*      */ 
/*      */   public String getmarriage() {
/*  515 */     if (this.marriage != null) this.marriage.equals("");
/*      */ 
/*  519 */     return this.marriage;
/*      */   }
/*      */ 
/*      */   public void setmarriage(String amarriage) {
/*  523 */     this.marriage = amarriage;
/*      */   }
/*      */ 
/*      */   public String getmarriageDate() {
/*  527 */     if (this.marriageDate != null) {
/*  528 */       return this.fDate.getString(this.marriageDate);
/*      */     }
/*  530 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmarriageDate(Date amarriageDate) {
/*  534 */     this.marriageDate = amarriageDate;
/*      */   }
/*      */ 
/*      */   public void setmarriageDate(String amarriageDate) {
/*  538 */     if ((amarriageDate != null) && (!amarriageDate.equals("")))
/*      */     {
/*  540 */       this.marriageDate = this.fDate.getDate(amarriageDate);
/*      */     }
/*      */     else
/*  543 */       this.marriageDate = null;
/*      */   }
/*      */ 
/*      */   public String gethealth()
/*      */   {
/*  548 */     if (this.health != null) this.health.equals("");
/*      */ 
/*  552 */     return this.health;
/*      */   }
/*      */ 
/*      */   public void sethealth(String ahealth) {
/*  556 */     this.health = ahealth;
/*      */   }
/*      */ 
/*      */   public double getstature() {
/*  560 */     return this.stature;
/*      */   }
/*      */ 
/*      */   public void setstature(double astature) {
/*  564 */     this.stature = astature;
/*      */   }
/*      */ 
/*      */   public void setstature(String astature) {
/*  568 */     if ((astature != null) && (!astature.equals("")))
/*      */     {
/*  570 */       Double tDouble = new Double(astature);
/*  571 */       double d = tDouble.doubleValue();
/*  572 */       this.stature = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getavoirdupois()
/*      */   {
/*  578 */     return this.avoirdupois;
/*      */   }
/*      */ 
/*      */   public void setavoirdupois(double aavoirdupois) {
/*  582 */     this.avoirdupois = aavoirdupois;
/*      */   }
/*      */ 
/*      */   public void setavoirdupois(String aavoirdupois) {
/*  586 */     if ((aavoirdupois != null) && (!aavoirdupois.equals("")))
/*      */     {
/*  588 */       Double tDouble = new Double(aavoirdupois);
/*  589 */       double d = tDouble.doubleValue();
/*  590 */       this.avoirdupois = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getdegree()
/*      */   {
/*  596 */     if (this.degree != null) this.degree.equals("");
/*      */ 
/*  600 */     return this.degree;
/*      */   }
/*      */ 
/*      */   public void setdegree(String adegree) {
/*  604 */     this.degree = adegree;
/*      */   }
/*      */ 
/*      */   public String getcreditGrade() {
/*  608 */     if (this.creditGrade != null) this.creditGrade.equals("");
/*      */ 
/*  612 */     return this.creditGrade;
/*      */   }
/*      */ 
/*      */   public void setcreditGrade(String acreditGrade) {
/*  616 */     this.creditGrade = acreditGrade;
/*      */   }
/*      */ 
/*      */   public String getbankCode() {
/*  620 */     if (this.bankCode != null) this.bankCode.equals("");
/*      */ 
/*  624 */     return this.bankCode;
/*      */   }
/*      */ 
/*      */   public void setbankCode(String abankCode) {
/*  628 */     this.bankCode = abankCode;
/*      */   }
/*      */ 
/*      */   public String getbankAccNo() {
/*  632 */     if (this.bankAccNo != null) this.bankAccNo.equals("");
/*      */ 
/*  636 */     return this.bankAccNo;
/*      */   }
/*      */ 
/*      */   public void setbankAccNo(String abankAccNo) {
/*  640 */     this.bankAccNo = abankAccNo;
/*      */   }
/*      */ 
/*      */   public String getaccName() {
/*  644 */     if (this.accName != null) this.accName.equals("");
/*      */ 
/*  648 */     return this.accName;
/*      */   }
/*      */ 
/*      */   public void setaccName(String aaccName) {
/*  652 */     this.accName = aaccName;
/*      */   }
/*      */ 
/*      */   public String getjoinCompanyDate() {
/*  656 */     if (this.joinCompanyDate != null) {
/*  657 */       return this.fDate.getString(this.joinCompanyDate);
/*      */     }
/*  659 */     return null;
/*      */   }
/*      */ 
/*      */   public void setjoinCompanyDate(Date ajoinCompanyDate) {
/*  663 */     this.joinCompanyDate = ajoinCompanyDate;
/*      */   }
/*      */ 
/*      */   public void setjoinCompanyDate(String ajoinCompanyDate) {
/*  667 */     if ((ajoinCompanyDate != null) && (!ajoinCompanyDate.equals("")))
/*      */     {
/*  669 */       this.joinCompanyDate = this.fDate.getDate(ajoinCompanyDate);
/*      */     }
/*      */     else
/*  672 */       this.joinCompanyDate = null;
/*      */   }
/*      */ 
/*      */   public String getstartWorkDate()
/*      */   {
/*  677 */     if (this.startWorkDate != null) {
/*  678 */       return this.fDate.getString(this.startWorkDate);
/*      */     }
/*  680 */     return null;
/*      */   }
/*      */ 
/*      */   public void setstartWorkDate(Date astartWorkDate) {
/*  684 */     this.startWorkDate = astartWorkDate;
/*      */   }
/*      */ 
/*      */   public void setstartWorkDate(String astartWorkDate) {
/*  688 */     if ((astartWorkDate != null) && (!astartWorkDate.equals("")))
/*      */     {
/*  690 */       this.startWorkDate = this.fDate.getDate(astartWorkDate);
/*      */     }
/*      */     else
/*  693 */       this.startWorkDate = null;
/*      */   }
/*      */ 
/*      */   public String getposition()
/*      */   {
/*  698 */     if (this.position != null) this.position.equals("");
/*      */ 
/*  702 */     return this.position;
/*      */   }
/*      */ 
/*      */   public void setposition(String aposition) {
/*  706 */     this.position = aposition;
/*      */   }
/*      */ 
/*      */   public double getsalary() {
/*  710 */     return this.salary;
/*      */   }
/*      */ 
/*      */   public void setsalary(double asalary) {
/*  714 */     this.salary = asalary;
/*      */   }
/*      */ 
/*      */   public void setsalary(String asalary) {
/*  718 */     if ((asalary != null) && (!asalary.equals("")))
/*      */     {
/*  720 */       Double tDouble = new Double(asalary);
/*  721 */       double d = tDouble.doubleValue();
/*  722 */       this.salary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getoccupationType()
/*      */   {
/*  728 */     if (this.occupationType != null) this.occupationType.equals("");
/*      */ 
/*  732 */     return this.occupationType;
/*      */   }
/*      */ 
/*      */   public void setoccupationType(String aoccupationType) {
/*  736 */     this.occupationType = aoccupationType;
/*      */   }
/*      */ 
/*      */   public String getoccupationCode() {
/*  740 */     if (this.occupationCode != null) this.occupationCode.equals("");
/*      */ 
/*  744 */     return this.occupationCode;
/*      */   }
/*      */ 
/*      */   public void setoccupationCode(String aoccupationCode) {
/*  748 */     this.occupationCode = aoccupationCode;
/*      */   }
/*      */ 
/*      */   public String getworkType() {
/*  752 */     if (this.workType != null) this.workType.equals("");
/*      */ 
/*  756 */     return this.workType;
/*      */   }
/*      */ 
/*      */   public void setworkType(String aworkType) {
/*  760 */     this.workType = aworkType;
/*      */   }
/*      */ 
/*      */   public String getpluralityType() {
/*  764 */     if (this.pluralityType != null) this.pluralityType.equals("");
/*      */ 
/*  768 */     return this.pluralityType;
/*      */   }
/*      */ 
/*      */   public void setpluralityType(String apluralityType) {
/*  772 */     this.pluralityType = apluralityType;
/*      */   }
/*      */ 
/*      */   public String getsmokeFlag() {
/*  776 */     if (this.smokeFlag != null) this.smokeFlag.equals("");
/*      */ 
/*  780 */     return this.smokeFlag;
/*      */   }
/*      */ 
/*      */   public void setsmokeFlag(String asmokeFlag) {
/*  784 */     this.smokeFlag = asmokeFlag;
/*      */   }
/*      */ 
/*      */   public String getbnfFlag() {
/*  788 */     if (this.bnfFlag != null) this.bnfFlag.equals("");
/*      */ 
/*  792 */     return this.bnfFlag;
/*      */   }
/*      */ 
/*      */   public void setbnfFlag(String abnfFlag) {
/*  796 */     this.bnfFlag = abnfFlag;
/*      */   }
/*      */ 
/*      */   public String getoperator() {
/*  800 */     if (this.operator != null) this.operator.equals("");
/*      */ 
/*  804 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setoperator(String aoperator) {
/*  808 */     this.operator = aoperator;
/*      */   }
/*      */ 
/*      */   public String getmanageCom() {
/*  812 */     if (this.manageCom != null) this.manageCom.equals("");
/*      */ 
/*  816 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setmanageCom(String amanageCom) {
/*  820 */     this.manageCom = amanageCom;
/*      */   }
/*      */ 
/*      */   public String getmakeDate() {
/*  824 */     if (this.makeDate != null) {
/*  825 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  827 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(Date amakeDate) {
/*  831 */     this.makeDate = amakeDate;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(String amakeDate) {
/*  835 */     if ((amakeDate != null) && (!amakeDate.equals("")))
/*      */     {
/*  837 */       this.makeDate = this.fDate.getDate(amakeDate);
/*      */     }
/*      */     else
/*  840 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getmakeTime()
/*      */   {
/*  845 */     if (this.makeTime != null) this.makeTime.equals("");
/*      */ 
/*  849 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setmakeTime(String amakeTime) {
/*  853 */     this.makeTime = amakeTime;
/*      */   }
/*      */ 
/*      */   public String getmodifyDate() {
/*  857 */     if (this.modifyDate != null) {
/*  858 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  860 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(Date amodifyDate) {
/*  864 */     this.modifyDate = amodifyDate;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(String amodifyDate) {
/*  868 */     if ((amodifyDate != null) && (!amodifyDate.equals("")))
/*      */     {
/*  870 */       this.modifyDate = this.fDate.getDate(amodifyDate);
/*      */     }
/*      */     else
/*  873 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getmodifyTime()
/*      */   {
/*  878 */     if (this.modifyTime != null) this.modifyTime.equals("");
/*      */ 
/*  882 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setmodifyTime(String amodifyTime) {
/*  886 */     this.modifyTime = amodifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPBnfBSchema aLNPBnfBSchema)
/*      */   {
/*  892 */     this.EdorNo = aLNPBnfBSchema.getEdorNo();
/*  893 */     this.serialNo = aLNPBnfBSchema.getserialNo();
/*  894 */     this.contNo = aLNPBnfBSchema.getcontNo();
/*  895 */     this.polNo = aLNPBnfBSchema.getpolNo();
/*  896 */     this.insuredNo = aLNPBnfBSchema.getinsuredNo();
/*  897 */     this.insuredId = aLNPBnfBSchema.getinsuredId();
/*  898 */     this.benefitType = aLNPBnfBSchema.getbenefitType();
/*  899 */     this.bnfOrder = aLNPBnfBSchema.getbnfOrder();
/*  900 */     this.bnfGrade = aLNPBnfBSchema.getbnfGrade();
/*  901 */     this.benefitRate = aLNPBnfBSchema.getbenefitRate();
/*  902 */     this.benefitOrder = aLNPBnfBSchema.getbenefitOrder();
/*  903 */     this.bnfNo = aLNPBnfBSchema.getbnfNo();
/*  904 */     this.bnfId = aLNPBnfBSchema.getbnfId();
/*  905 */     this.appellation = aLNPBnfBSchema.getappellation();
/*  906 */     this.bnfName = aLNPBnfBSchema.getbnfName();
/*  907 */     this.bnfSex = aLNPBnfBSchema.getbnfSex();
/*  908 */     this.bnfBirthday = this.fDate.getDate(aLNPBnfBSchema.getbnfBirthday());
/*  909 */     this.bnfAge = aLNPBnfBSchema.getbnfAge();
/*  910 */     this.relationToInsured = aLNPBnfBSchema.getrelationToInsured();
/*  911 */     this.addressNo = aLNPBnfBSchema.getaddressNo();
/*  912 */     this.iDType = aLNPBnfBSchema.getiDType();
/*  913 */     this.iDNo = aLNPBnfBSchema.getiDNo();
/*  914 */     this.iDValidity = this.fDate.getDate(aLNPBnfBSchema.getiDValidity());
/*  915 */     this.iDPerpetual = aLNPBnfBSchema.getiDPerpetual();
/*  916 */     this.nativePlace = aLNPBnfBSchema.getnativePlace();
/*  917 */     this.nationality = aLNPBnfBSchema.getnationality();
/*  918 */     this.rgtAddress = aLNPBnfBSchema.getrgtAddress();
/*  919 */     this.marriage = aLNPBnfBSchema.getmarriage();
/*  920 */     this.marriageDate = this.fDate.getDate(aLNPBnfBSchema.getmarriageDate());
/*  921 */     this.health = aLNPBnfBSchema.gethealth();
/*  922 */     this.stature = aLNPBnfBSchema.getstature();
/*  923 */     this.avoirdupois = aLNPBnfBSchema.getavoirdupois();
/*  924 */     this.degree = aLNPBnfBSchema.getdegree();
/*  925 */     this.creditGrade = aLNPBnfBSchema.getcreditGrade();
/*  926 */     this.bankCode = aLNPBnfBSchema.getbankCode();
/*  927 */     this.bankAccNo = aLNPBnfBSchema.getbankAccNo();
/*  928 */     this.accName = aLNPBnfBSchema.getaccName();
/*  929 */     this.joinCompanyDate = this.fDate.getDate(aLNPBnfBSchema.getjoinCompanyDate());
/*  930 */     this.startWorkDate = this.fDate.getDate(aLNPBnfBSchema.getstartWorkDate());
/*  931 */     this.position = aLNPBnfBSchema.getposition();
/*  932 */     this.salary = aLNPBnfBSchema.getsalary();
/*  933 */     this.occupationType = aLNPBnfBSchema.getoccupationType();
/*  934 */     this.occupationCode = aLNPBnfBSchema.getoccupationCode();
/*  935 */     this.workType = aLNPBnfBSchema.getworkType();
/*  936 */     this.pluralityType = aLNPBnfBSchema.getpluralityType();
/*  937 */     this.smokeFlag = aLNPBnfBSchema.getsmokeFlag();
/*  938 */     this.bnfFlag = aLNPBnfBSchema.getbnfFlag();
/*  939 */     this.operator = aLNPBnfBSchema.getoperator();
/*  940 */     this.manageCom = aLNPBnfBSchema.getmanageCom();
/*  941 */     this.makeDate = this.fDate.getDate(aLNPBnfBSchema.getmakeDate());
/*  942 */     this.makeTime = aLNPBnfBSchema.getmakeTime();
/*  943 */     this.modifyDate = this.fDate.getDate(aLNPBnfBSchema.getmodifyDate());
/*  944 */     this.modifyTime = aLNPBnfBSchema.getmodifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  953 */       if (rs.getString("EdorNo") == null)
/*  954 */         this.EdorNo = null;
/*      */       else {
/*  956 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  958 */       if (rs.getString("serialNo") == null)
/*  959 */         this.serialNo = null;
/*      */       else {
/*  961 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/*  963 */       if (rs.getString("contNo") == null)
/*  964 */         this.contNo = null;
/*      */       else {
/*  966 */         this.contNo = rs.getString("contNo").trim();
/*      */       }
/*  968 */       if (rs.getString("polNo") == null)
/*  969 */         this.polNo = null;
/*      */       else {
/*  971 */         this.polNo = rs.getString("polNo").trim();
/*      */       }
/*  973 */       if (rs.getString("insuredNo") == null)
/*  974 */         this.insuredNo = null;
/*      */       else {
/*  976 */         this.insuredNo = rs.getString("insuredNo").trim();
/*      */       }
/*  978 */       if (rs.getString("insuredId") == null)
/*  979 */         this.insuredId = null;
/*      */       else {
/*  981 */         this.insuredId = rs.getString("insuredId").trim();
/*      */       }
/*  983 */       if (rs.getString("benefitType") == null)
/*  984 */         this.benefitType = null;
/*      */       else {
/*  986 */         this.benefitType = rs.getString("benefitType").trim();
/*      */       }
/*  988 */       this.bnfOrder = rs.getInt("bnfOrder");
/*  989 */       if (rs.getString("bnfGrade") == null)
/*  990 */         this.bnfGrade = null;
/*      */       else {
/*  992 */         this.bnfGrade = rs.getString("bnfGrade").trim();
/*      */       }
/*  994 */       this.benefitRate = rs.getDouble("benefitRate");
/*  995 */       if (rs.getString("benefitOrder") == null)
/*  996 */         this.benefitOrder = null;
/*      */       else {
/*  998 */         this.benefitOrder = rs.getString("benefitOrder").trim();
/*      */       }
/* 1000 */       if (rs.getString("bnfNo") == null)
/* 1001 */         this.bnfNo = null;
/*      */       else {
/* 1003 */         this.bnfNo = rs.getString("bnfNo").trim();
/*      */       }
/* 1005 */       if (rs.getString("bnfId") == null)
/* 1006 */         this.bnfId = null;
/*      */       else {
/* 1008 */         this.bnfId = rs.getString("bnfId").trim();
/*      */       }
/* 1010 */       if (rs.getString("appellation") == null)
/* 1011 */         this.appellation = null;
/*      */       else {
/* 1013 */         this.appellation = rs.getString("appellation").trim();
/*      */       }
/* 1015 */       if (rs.getString("bnfName") == null)
/* 1016 */         this.bnfName = null;
/*      */       else {
/* 1018 */         this.bnfName = rs.getString("bnfName").trim();
/*      */       }
/* 1020 */       if (rs.getString("bnfSex") == null)
/* 1021 */         this.bnfSex = null;
/*      */       else {
/* 1023 */         this.bnfSex = rs.getString("bnfSex").trim();
/*      */       }
/* 1025 */       this.bnfBirthday = rs.getDate("bnfBirthday");
/* 1026 */       this.bnfAge = rs.getInt("bnfAge");
/* 1027 */       if (rs.getString("relationToInsured") == null)
/* 1028 */         this.relationToInsured = null;
/*      */       else {
/* 1030 */         this.relationToInsured = rs.getString("relationToInsured").trim();
/*      */       }
/* 1032 */       if (rs.getString("addressNo") == null)
/* 1033 */         this.addressNo = null;
/*      */       else {
/* 1035 */         this.addressNo = rs.getString("addressNo").trim();
/*      */       }
/* 1037 */       if (rs.getString("iDType") == null)
/* 1038 */         this.iDType = null;
/*      */       else {
/* 1040 */         this.iDType = rs.getString("iDType").trim();
/*      */       }
/* 1042 */       if (rs.getString("iDNo") == null)
/* 1043 */         this.iDNo = null;
/*      */       else {
/* 1045 */         this.iDNo = rs.getString("iDNo").trim();
/*      */       }
/* 1047 */       this.iDValidity = rs.getDate("iDValidity");
/* 1048 */       if (rs.getString("iDPerpetual") == null)
/* 1049 */         this.iDPerpetual = null;
/*      */       else {
/* 1051 */         this.iDPerpetual = rs.getString("iDPerpetual").trim();
/*      */       }
/* 1053 */       if (rs.getString("nativePlace") == null)
/* 1054 */         this.nativePlace = null;
/*      */       else {
/* 1056 */         this.nativePlace = rs.getString("nativePlace").trim();
/*      */       }
/* 1058 */       if (rs.getString("nationality") == null)
/* 1059 */         this.nationality = null;
/*      */       else {
/* 1061 */         this.nationality = rs.getString("nationality").trim();
/*      */       }
/* 1063 */       if (rs.getString("rgtAddress") == null)
/* 1064 */         this.rgtAddress = null;
/*      */       else {
/* 1066 */         this.rgtAddress = rs.getString("rgtAddress").trim();
/*      */       }
/* 1068 */       if (rs.getString("marriage") == null)
/* 1069 */         this.marriage = null;
/*      */       else {
/* 1071 */         this.marriage = rs.getString("marriage").trim();
/*      */       }
/* 1073 */       this.marriageDate = rs.getDate("marriageDate");
/* 1074 */       if (rs.getString("health") == null)
/* 1075 */         this.health = null;
/*      */       else {
/* 1077 */         this.health = rs.getString("health").trim();
/*      */       }
/* 1079 */       this.stature = rs.getDouble("stature");
/* 1080 */       this.avoirdupois = rs.getDouble("avoirdupois");
/* 1081 */       if (rs.getString("degree") == null)
/* 1082 */         this.degree = null;
/*      */       else {
/* 1084 */         this.degree = rs.getString("degree").trim();
/*      */       }
/* 1086 */       if (rs.getString("creditGrade") == null)
/* 1087 */         this.creditGrade = null;
/*      */       else {
/* 1089 */         this.creditGrade = rs.getString("creditGrade").trim();
/*      */       }
/* 1091 */       if (rs.getString("bankCode") == null)
/* 1092 */         this.bankCode = null;
/*      */       else {
/* 1094 */         this.bankCode = rs.getString("bankCode").trim();
/*      */       }
/* 1096 */       if (rs.getString("bankAccNo") == null)
/* 1097 */         this.bankAccNo = null;
/*      */       else {
/* 1099 */         this.bankAccNo = rs.getString("bankAccNo").trim();
/*      */       }
/* 1101 */       if (rs.getString("accName") == null)
/* 1102 */         this.accName = null;
/*      */       else {
/* 1104 */         this.accName = rs.getString("accName").trim();
/*      */       }
/* 1106 */       this.joinCompanyDate = rs.getDate("joinCompanyDate");
/* 1107 */       this.startWorkDate = rs.getDate("startWorkDate");
/* 1108 */       if (rs.getString("position") == null)
/* 1109 */         this.position = null;
/*      */       else {
/* 1111 */         this.position = rs.getString("position").trim();
/*      */       }
/* 1113 */       this.salary = rs.getDouble("salary");
/* 1114 */       if (rs.getString("occupationType") == null)
/* 1115 */         this.occupationType = null;
/*      */       else {
/* 1117 */         this.occupationType = rs.getString("occupationType").trim();
/*      */       }
/* 1119 */       if (rs.getString("occupationCode") == null)
/* 1120 */         this.occupationCode = null;
/*      */       else {
/* 1122 */         this.occupationCode = rs.getString("occupationCode").trim();
/*      */       }
/* 1124 */       if (rs.getString("workType") == null)
/* 1125 */         this.workType = null;
/*      */       else {
/* 1127 */         this.workType = rs.getString("workType").trim();
/*      */       }
/* 1129 */       if (rs.getString("pluralityType") == null)
/* 1130 */         this.pluralityType = null;
/*      */       else {
/* 1132 */         this.pluralityType = rs.getString("pluralityType").trim();
/*      */       }
/* 1134 */       if (rs.getString("smokeFlag") == null)
/* 1135 */         this.smokeFlag = null;
/*      */       else {
/* 1137 */         this.smokeFlag = rs.getString("smokeFlag").trim();
/*      */       }
/* 1139 */       if (rs.getString("bnfFlag") == null)
/* 1140 */         this.bnfFlag = null;
/*      */       else {
/* 1142 */         this.bnfFlag = rs.getString("bnfFlag").trim();
/*      */       }
/* 1144 */       if (rs.getString("operator") == null)
/* 1145 */         this.operator = null;
/*      */       else {
/* 1147 */         this.operator = rs.getString("operator").trim();
/*      */       }
/* 1149 */       if (rs.getString("manageCom") == null)
/* 1150 */         this.manageCom = null;
/*      */       else {
/* 1152 */         this.manageCom = rs.getString("manageCom").trim();
/*      */       }
/* 1154 */       this.makeDate = rs.getDate("makeDate");
/* 1155 */       if (rs.getString("makeTime") == null)
/* 1156 */         this.makeTime = null;
/*      */       else {
/* 1158 */         this.makeTime = rs.getString("makeTime").trim();
/*      */       }
/* 1160 */       this.modifyDate = rs.getDate("modifyDate");
/* 1161 */       if (rs.getString("modifyTime") == null)
/* 1162 */         this.modifyTime = null;
/*      */       else {
/* 1164 */         this.modifyTime = rs.getString("modifyTime").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1170 */       CError tError = new CError();
/* 1171 */       tError.moduleName = "LNPBnfBSchema";
/* 1172 */       tError.functionName = "setSchema";
/* 1173 */       tError.errorMessage = sqle.toString();
/* 1174 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1176 */       return false;
/*      */     }
/* 1178 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPBnfBSchema getSchema()
/*      */   {
/* 1183 */     LNPBnfBSchema aLNPBnfBSchema = new LNPBnfBSchema();
/* 1184 */     aLNPBnfBSchema.setSchema(this);
/* 1185 */     return aLNPBnfBSchema;
/*      */   }
/*      */ 
/*      */   public LNPBnfBDB getDB()
/*      */   {
/* 1190 */     LNPBnfBDB aDBOper = new LNPBnfBDB();
/* 1191 */     aDBOper.setSchema(this);
/* 1192 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1199 */     String strReturn = "";
/* 1200 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/* 1201 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/* 1202 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contNo)) + "|" + 
/* 1203 */       StrTool.cTrim(StrTool.unicodeToGBK(this.polNo)) + "|" + 
/* 1204 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredNo)) + "|" + 
/* 1205 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredId)) + "|" + 
/* 1206 */       StrTool.cTrim(StrTool.unicodeToGBK(this.benefitType)) + "|" + 
/* 1207 */       ChgData.chgData(this.bnfOrder) + "|" + 
/* 1208 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bnfGrade)) + "|" + 
/* 1209 */       ChgData.chgData(this.benefitRate) + "|" + 
/* 1210 */       StrTool.cTrim(StrTool.unicodeToGBK(this.benefitOrder)) + "|" + 
/* 1211 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bnfNo)) + "|" + 
/* 1212 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bnfId)) + "|" + 
/* 1213 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appellation)) + "|" + 
/* 1214 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bnfName)) + "|" + 
/* 1215 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bnfSex)) + "|" + 
/* 1216 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.bnfBirthday))) + "|" + 
/* 1217 */       ChgData.chgData(this.bnfAge) + "|" + 
/* 1218 */       StrTool.cTrim(StrTool.unicodeToGBK(this.relationToInsured)) + "|" + 
/* 1219 */       StrTool.cTrim(StrTool.unicodeToGBK(this.addressNo)) + "|" + 
/* 1220 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDType)) + "|" + 
/* 1221 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDNo)) + "|" + 
/* 1222 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.iDValidity))) + "|" + 
/* 1223 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDPerpetual)) + "|" + 
/* 1224 */       StrTool.cTrim(StrTool.unicodeToGBK(this.nativePlace)) + "|" + 
/* 1225 */       StrTool.cTrim(StrTool.unicodeToGBK(this.nationality)) + "|" + 
/* 1226 */       StrTool.cTrim(StrTool.unicodeToGBK(this.rgtAddress)) + "|" + 
/* 1227 */       StrTool.cTrim(StrTool.unicodeToGBK(this.marriage)) + "|" + 
/* 1228 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.marriageDate))) + "|" + 
/* 1229 */       StrTool.cTrim(StrTool.unicodeToGBK(this.health)) + "|" + 
/* 1230 */       ChgData.chgData(this.stature) + "|" + 
/* 1231 */       ChgData.chgData(this.avoirdupois) + "|" + 
/* 1232 */       StrTool.cTrim(StrTool.unicodeToGBK(this.degree)) + "|" + 
/* 1233 */       StrTool.cTrim(StrTool.unicodeToGBK(this.creditGrade)) + "|" + 
/* 1234 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bankCode)) + "|" + 
/* 1235 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bankAccNo)) + "|" + 
/* 1236 */       StrTool.cTrim(StrTool.unicodeToGBK(this.accName)) + "|" + 
/* 1237 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.joinCompanyDate))) + "|" + 
/* 1238 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.startWorkDate))) + "|" + 
/* 1239 */       StrTool.cTrim(StrTool.unicodeToGBK(this.position)) + "|" + 
/* 1240 */       ChgData.chgData(this.salary) + "|" + 
/* 1241 */       StrTool.cTrim(StrTool.unicodeToGBK(this.occupationType)) + "|" + 
/* 1242 */       StrTool.cTrim(StrTool.unicodeToGBK(this.occupationCode)) + "|" + 
/* 1243 */       StrTool.cTrim(StrTool.unicodeToGBK(this.workType)) + "|" + 
/* 1244 */       StrTool.cTrim(StrTool.unicodeToGBK(this.pluralityType)) + "|" + 
/* 1245 */       StrTool.cTrim(StrTool.unicodeToGBK(this.smokeFlag)) + "|" + 
/* 1246 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bnfFlag)) + "|" + 
/* 1247 */       StrTool.cTrim(StrTool.unicodeToGBK(this.operator)) + "|" + 
/* 1248 */       StrTool.cTrim(StrTool.unicodeToGBK(this.manageCom)) + "|" + 
/* 1249 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makeDate))) + "|" + 
/* 1250 */       StrTool.cTrim(StrTool.unicodeToGBK(this.makeTime)) + "|" + 
/* 1251 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifyDate))) + "|" + 
/* 1252 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifyTime));
/* 1253 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1261 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1262 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1263 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1264 */       this.polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1265 */       this.insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1266 */       this.insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1267 */       this.benefitType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1268 */       this.bnfOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).intValue();
/* 1269 */       this.bnfGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1270 */       this.benefitRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).doubleValue();
/* 1271 */       this.benefitOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1272 */       this.bnfNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1273 */       this.bnfId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1274 */       this.appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1275 */       this.bnfName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1276 */       this.bnfSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1277 */       this.bnfBirthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/* 1278 */       this.bnfAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|"))).intValue();
/* 1279 */       this.relationToInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1280 */       this.addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 1281 */       this.iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1282 */       this.iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 1283 */       this.iDValidity = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
/* 1284 */       this.iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1285 */       this.nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1286 */       this.nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1287 */       this.rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1288 */       this.marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1289 */       this.marriageDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|"));
/* 1290 */       this.health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1291 */       this.stature = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|"))).doubleValue();
/* 1292 */       this.avoirdupois = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|"))).doubleValue();
/* 1293 */       this.degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 1294 */       this.creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/* 1295 */       this.bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 1296 */       this.bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
/* 1297 */       this.accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 1298 */       this.joinCompanyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|"));
/* 1299 */       this.startWorkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|"));
/* 1300 */       this.position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1301 */       this.salary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 41, "|"))).doubleValue();
/* 1302 */       this.occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1303 */       this.occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 1304 */       this.workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1305 */       this.pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 1306 */       this.smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 1307 */       this.bnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 1308 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 1309 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/* 1310 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|"));
/* 1311 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
/* 1312 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|"));
/* 1313 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1318 */       CError tError = new CError();
/* 1319 */       tError.moduleName = "LNPBnfBSchema";
/* 1320 */       tError.functionName = "decode";
/* 1321 */       tError.errorMessage = ex.toString();
/* 1322 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1324 */       return false;
/*      */     }
/* 1326 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1332 */     String strReturn = "";
/* 1333 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 1335 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/* 1337 */     if (FCode.equals("serialNo"))
/*      */     {
/* 1339 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/* 1341 */     if (FCode.equals("contNo"))
/*      */     {
/* 1343 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/* 1345 */     if (FCode.equals("polNo"))
/*      */     {
/* 1347 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polNo));
/*      */     }
/* 1349 */     if (FCode.equals("insuredNo"))
/*      */     {
/* 1351 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredNo));
/*      */     }
/* 1353 */     if (FCode.equals("insuredId"))
/*      */     {
/* 1355 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredId));
/*      */     }
/* 1357 */     if (FCode.equals("benefitType"))
/*      */     {
/* 1359 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.benefitType));
/*      */     }
/* 1361 */     if (FCode.equals("bnfOrder"))
/*      */     {
/* 1363 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfOrder));
/*      */     }
/* 1365 */     if (FCode.equals("bnfGrade"))
/*      */     {
/* 1367 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfGrade));
/*      */     }
/* 1369 */     if (FCode.equals("benefitRate"))
/*      */     {
/* 1371 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.benefitRate));
/*      */     }
/* 1373 */     if (FCode.equals("benefitOrder"))
/*      */     {
/* 1375 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.benefitOrder));
/*      */     }
/* 1377 */     if (FCode.equals("bnfNo"))
/*      */     {
/* 1379 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfNo));
/*      */     }
/* 1381 */     if (FCode.equals("bnfId"))
/*      */     {
/* 1383 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfId));
/*      */     }
/* 1385 */     if (FCode.equals("appellation"))
/*      */     {
/* 1387 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appellation));
/*      */     }
/* 1389 */     if (FCode.equals("bnfName"))
/*      */     {
/* 1391 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfName));
/*      */     }
/* 1393 */     if (FCode.equals("bnfSex"))
/*      */     {
/* 1395 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfSex));
/*      */     }
/* 1397 */     if (FCode.equals("bnfBirthday"))
/*      */     {
/* 1399 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getbnfBirthday()));
/*      */     }
/* 1401 */     if (FCode.equals("bnfAge"))
/*      */     {
/* 1403 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfAge));
/*      */     }
/* 1405 */     if (FCode.equals("relationToInsured"))
/*      */     {
/* 1407 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relationToInsured));
/*      */     }
/* 1409 */     if (FCode.equals("addressNo"))
/*      */     {
/* 1411 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addressNo));
/*      */     }
/* 1413 */     if (FCode.equals("iDType"))
/*      */     {
/* 1415 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDType));
/*      */     }
/* 1417 */     if (FCode.equals("iDNo"))
/*      */     {
/* 1419 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDNo));
/*      */     }
/* 1421 */     if (FCode.equals("iDValidity"))
/*      */     {
/* 1423 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
/*      */     }
/* 1425 */     if (FCode.equals("iDPerpetual"))
/*      */     {
/* 1427 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDPerpetual));
/*      */     }
/* 1429 */     if (FCode.equals("nativePlace"))
/*      */     {
/* 1431 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nativePlace));
/*      */     }
/* 1433 */     if (FCode.equals("nationality"))
/*      */     {
/* 1435 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nationality));
/*      */     }
/* 1437 */     if (FCode.equals("rgtAddress"))
/*      */     {
/* 1439 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rgtAddress));
/*      */     }
/* 1441 */     if (FCode.equals("marriage"))
/*      */     {
/* 1443 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.marriage));
/*      */     }
/* 1445 */     if (FCode.equals("marriageDate"))
/*      */     {
/* 1447 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
/*      */     }
/* 1449 */     if (FCode.equals("health"))
/*      */     {
/* 1451 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.health));
/*      */     }
/* 1453 */     if (FCode.equals("stature"))
/*      */     {
/* 1455 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stature));
/*      */     }
/* 1457 */     if (FCode.equals("avoirdupois"))
/*      */     {
/* 1459 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.avoirdupois));
/*      */     }
/* 1461 */     if (FCode.equals("degree"))
/*      */     {
/* 1463 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.degree));
/*      */     }
/* 1465 */     if (FCode.equals("creditGrade"))
/*      */     {
/* 1467 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.creditGrade));
/*      */     }
/* 1469 */     if (FCode.equals("bankCode"))
/*      */     {
/* 1471 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankCode));
/*      */     }
/* 1473 */     if (FCode.equals("bankAccNo"))
/*      */     {
/* 1475 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankAccNo));
/*      */     }
/* 1477 */     if (FCode.equals("accName"))
/*      */     {
/* 1479 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.accName));
/*      */     }
/* 1481 */     if (FCode.equals("joinCompanyDate"))
/*      */     {
/* 1483 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
/*      */     }
/* 1485 */     if (FCode.equals("startWorkDate"))
/*      */     {
/* 1487 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
/*      */     }
/* 1489 */     if (FCode.equals("position"))
/*      */     {
/* 1491 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.position));
/*      */     }
/* 1493 */     if (FCode.equals("salary"))
/*      */     {
/* 1495 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.salary));
/*      */     }
/* 1497 */     if (FCode.equals("occupationType"))
/*      */     {
/* 1499 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationType));
/*      */     }
/* 1501 */     if (FCode.equals("occupationCode"))
/*      */     {
/* 1503 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationCode));
/*      */     }
/* 1505 */     if (FCode.equals("workType"))
/*      */     {
/* 1507 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.workType));
/*      */     }
/* 1509 */     if (FCode.equals("pluralityType"))
/*      */     {
/* 1511 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pluralityType));
/*      */     }
/* 1513 */     if (FCode.equals("smokeFlag"))
/*      */     {
/* 1515 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.smokeFlag));
/*      */     }
/* 1517 */     if (FCode.equals("bnfFlag"))
/*      */     {
/* 1519 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfFlag));
/*      */     }
/* 1521 */     if (FCode.equals("operator"))
/*      */     {
/* 1523 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1525 */     if (FCode.equals("manageCom"))
/*      */     {
/* 1527 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 1529 */     if (FCode.equals("makeDate"))
/*      */     {
/* 1531 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*      */     }
/* 1533 */     if (FCode.equals("makeTime"))
/*      */     {
/* 1535 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1537 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 1539 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*      */     }
/* 1541 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 1543 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1545 */     if (strReturn.equals(""))
/*      */     {
/* 1547 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1550 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1557 */     String strFieldValue = "";
/* 1558 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1560 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/* 1561 */       break;
/*      */     case 1:
/* 1563 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/* 1564 */       break;
/*      */     case 2:
/* 1566 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 1567 */       break;
/*      */     case 3:
/* 1569 */       strFieldValue = StrTool.GBKToUnicode(this.polNo);
/* 1570 */       break;
/*      */     case 4:
/* 1572 */       strFieldValue = StrTool.GBKToUnicode(this.insuredNo);
/* 1573 */       break;
/*      */     case 5:
/* 1575 */       strFieldValue = StrTool.GBKToUnicode(this.insuredId);
/* 1576 */       break;
/*      */     case 6:
/* 1578 */       strFieldValue = StrTool.GBKToUnicode(this.benefitType);
/* 1579 */       break;
/*      */     case 7:
/* 1581 */       strFieldValue = String.valueOf(this.bnfOrder);
/* 1582 */       break;
/*      */     case 8:
/* 1584 */       strFieldValue = StrTool.GBKToUnicode(this.bnfGrade);
/* 1585 */       break;
/*      */     case 9:
/* 1587 */       strFieldValue = String.valueOf(this.benefitRate);
/* 1588 */       break;
/*      */     case 10:
/* 1590 */       strFieldValue = StrTool.GBKToUnicode(this.benefitOrder);
/* 1591 */       break;
/*      */     case 11:
/* 1593 */       strFieldValue = StrTool.GBKToUnicode(this.bnfNo);
/* 1594 */       break;
/*      */     case 12:
/* 1596 */       strFieldValue = StrTool.GBKToUnicode(this.bnfId);
/* 1597 */       break;
/*      */     case 13:
/* 1599 */       strFieldValue = StrTool.GBKToUnicode(this.appellation);
/* 1600 */       break;
/*      */     case 14:
/* 1602 */       strFieldValue = StrTool.GBKToUnicode(this.bnfName);
/* 1603 */       break;
/*      */     case 15:
/* 1605 */       strFieldValue = StrTool.GBKToUnicode(this.bnfSex);
/* 1606 */       break;
/*      */     case 16:
/* 1608 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getbnfBirthday()));
/* 1609 */       break;
/*      */     case 17:
/* 1611 */       strFieldValue = String.valueOf(this.bnfAge);
/* 1612 */       break;
/*      */     case 18:
/* 1614 */       strFieldValue = StrTool.GBKToUnicode(this.relationToInsured);
/* 1615 */       break;
/*      */     case 19:
/* 1617 */       strFieldValue = StrTool.GBKToUnicode(this.addressNo);
/* 1618 */       break;
/*      */     case 20:
/* 1620 */       strFieldValue = StrTool.GBKToUnicode(this.iDType);
/* 1621 */       break;
/*      */     case 21:
/* 1623 */       strFieldValue = StrTool.GBKToUnicode(this.iDNo);
/* 1624 */       break;
/*      */     case 22:
/* 1626 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
/* 1627 */       break;
/*      */     case 23:
/* 1629 */       strFieldValue = StrTool.GBKToUnicode(this.iDPerpetual);
/* 1630 */       break;
/*      */     case 24:
/* 1632 */       strFieldValue = StrTool.GBKToUnicode(this.nativePlace);
/* 1633 */       break;
/*      */     case 25:
/* 1635 */       strFieldValue = StrTool.GBKToUnicode(this.nationality);
/* 1636 */       break;
/*      */     case 26:
/* 1638 */       strFieldValue = StrTool.GBKToUnicode(this.rgtAddress);
/* 1639 */       break;
/*      */     case 27:
/* 1641 */       strFieldValue = StrTool.GBKToUnicode(this.marriage);
/* 1642 */       break;
/*      */     case 28:
/* 1644 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
/* 1645 */       break;
/*      */     case 29:
/* 1647 */       strFieldValue = StrTool.GBKToUnicode(this.health);
/* 1648 */       break;
/*      */     case 30:
/* 1650 */       strFieldValue = String.valueOf(this.stature);
/* 1651 */       break;
/*      */     case 31:
/* 1653 */       strFieldValue = String.valueOf(this.avoirdupois);
/* 1654 */       break;
/*      */     case 32:
/* 1656 */       strFieldValue = StrTool.GBKToUnicode(this.degree);
/* 1657 */       break;
/*      */     case 33:
/* 1659 */       strFieldValue = StrTool.GBKToUnicode(this.creditGrade);
/* 1660 */       break;
/*      */     case 34:
/* 1662 */       strFieldValue = StrTool.GBKToUnicode(this.bankCode);
/* 1663 */       break;
/*      */     case 35:
/* 1665 */       strFieldValue = StrTool.GBKToUnicode(this.bankAccNo);
/* 1666 */       break;
/*      */     case 36:
/* 1668 */       strFieldValue = StrTool.GBKToUnicode(this.accName);
/* 1669 */       break;
/*      */     case 37:
/* 1671 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
/* 1672 */       break;
/*      */     case 38:
/* 1674 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
/* 1675 */       break;
/*      */     case 39:
/* 1677 */       strFieldValue = StrTool.GBKToUnicode(this.position);
/* 1678 */       break;
/*      */     case 40:
/* 1680 */       strFieldValue = String.valueOf(this.salary);
/* 1681 */       break;
/*      */     case 41:
/* 1683 */       strFieldValue = StrTool.GBKToUnicode(this.occupationType);
/* 1684 */       break;
/*      */     case 42:
/* 1686 */       strFieldValue = StrTool.GBKToUnicode(this.occupationCode);
/* 1687 */       break;
/*      */     case 43:
/* 1689 */       strFieldValue = StrTool.GBKToUnicode(this.workType);
/* 1690 */       break;
/*      */     case 44:
/* 1692 */       strFieldValue = StrTool.GBKToUnicode(this.pluralityType);
/* 1693 */       break;
/*      */     case 45:
/* 1695 */       strFieldValue = StrTool.GBKToUnicode(this.smokeFlag);
/* 1696 */       break;
/*      */     case 46:
/* 1698 */       strFieldValue = StrTool.GBKToUnicode(this.bnfFlag);
/* 1699 */       break;
/*      */     case 47:
/* 1701 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1702 */       break;
/*      */     case 48:
/* 1704 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1705 */       break;
/*      */     case 49:
/* 1707 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/* 1708 */       break;
/*      */     case 50:
/* 1710 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1711 */       break;
/*      */     case 51:
/* 1713 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/* 1714 */       break;
/*      */     case 52:
/* 1716 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1717 */       break;
/*      */     default:
/* 1719 */       strFieldValue = "";
/*      */     }
/* 1721 */     if (strFieldValue.equals("")) {
/* 1722 */       strFieldValue = "null";
/*      */     }
/* 1724 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1730 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1731 */       return false;
/*      */     }
/* 1733 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 1735 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1737 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1740 */         this.EdorNo = null;
/*      */     }
/* 1742 */     if (FCode.equals("serialNo"))
/*      */     {
/* 1744 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1746 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/* 1749 */         this.serialNo = null;
/*      */     }
/* 1751 */     if (FCode.equals("contNo"))
/*      */     {
/* 1753 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1755 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 1758 */         this.contNo = null;
/*      */     }
/* 1760 */     if (FCode.equals("polNo"))
/*      */     {
/* 1762 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1764 */         this.polNo = FValue.trim();
/*      */       }
/*      */       else
/* 1767 */         this.polNo = null;
/*      */     }
/* 1769 */     if (FCode.equals("insuredNo"))
/*      */     {
/* 1771 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1773 */         this.insuredNo = FValue.trim();
/*      */       }
/*      */       else
/* 1776 */         this.insuredNo = null;
/*      */     }
/* 1778 */     if (FCode.equals("insuredId"))
/*      */     {
/* 1780 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1782 */         this.insuredId = FValue.trim();
/*      */       }
/*      */       else
/* 1785 */         this.insuredId = null;
/*      */     }
/* 1787 */     if (FCode.equals("benefitType"))
/*      */     {
/* 1789 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1791 */         this.benefitType = FValue.trim();
/*      */       }
/*      */       else
/* 1794 */         this.benefitType = null;
/*      */     }
/* 1796 */     if (FCode.equals("bnfOrder"))
/*      */     {
/* 1798 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1800 */         Integer tInteger = new Integer(FValue);
/* 1801 */         int i = tInteger.intValue();
/* 1802 */         this.bnfOrder = i;
/*      */       }
/*      */     }
/* 1805 */     if (FCode.equals("bnfGrade"))
/*      */     {
/* 1807 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1809 */         this.bnfGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1812 */         this.bnfGrade = null;
/*      */     }
/* 1814 */     if (FCode.equals("benefitRate"))
/*      */     {
/* 1816 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1818 */         Double tDouble = new Double(FValue);
/* 1819 */         double d = tDouble.doubleValue();
/* 1820 */         this.benefitRate = d;
/*      */       }
/*      */     }
/* 1823 */     if (FCode.equals("benefitOrder"))
/*      */     {
/* 1825 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1827 */         this.benefitOrder = FValue.trim();
/*      */       }
/*      */       else
/* 1830 */         this.benefitOrder = null;
/*      */     }
/* 1832 */     if (FCode.equals("bnfNo"))
/*      */     {
/* 1834 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1836 */         this.bnfNo = FValue.trim();
/*      */       }
/*      */       else
/* 1839 */         this.bnfNo = null;
/*      */     }
/* 1841 */     if (FCode.equals("bnfId"))
/*      */     {
/* 1843 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1845 */         this.bnfId = FValue.trim();
/*      */       }
/*      */       else
/* 1848 */         this.bnfId = null;
/*      */     }
/* 1850 */     if (FCode.equals("appellation"))
/*      */     {
/* 1852 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1854 */         this.appellation = FValue.trim();
/*      */       }
/*      */       else
/* 1857 */         this.appellation = null;
/*      */     }
/* 1859 */     if (FCode.equals("bnfName"))
/*      */     {
/* 1861 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1863 */         this.bnfName = FValue.trim();
/*      */       }
/*      */       else
/* 1866 */         this.bnfName = null;
/*      */     }
/* 1868 */     if (FCode.equals("bnfSex"))
/*      */     {
/* 1870 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1872 */         this.bnfSex = FValue.trim();
/*      */       }
/*      */       else
/* 1875 */         this.bnfSex = null;
/*      */     }
/* 1877 */     if (FCode.equals("bnfBirthday"))
/*      */     {
/* 1879 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1881 */         this.bnfBirthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1884 */         this.bnfBirthday = null;
/*      */     }
/* 1886 */     if (FCode.equals("bnfAge"))
/*      */     {
/* 1888 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1890 */         Integer tInteger = new Integer(FValue);
/* 1891 */         int i = tInteger.intValue();
/* 1892 */         this.bnfAge = i;
/*      */       }
/*      */     }
/* 1895 */     if (FCode.equals("relationToInsured"))
/*      */     {
/* 1897 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1899 */         this.relationToInsured = FValue.trim();
/*      */       }
/*      */       else
/* 1902 */         this.relationToInsured = null;
/*      */     }
/* 1904 */     if (FCode.equals("addressNo"))
/*      */     {
/* 1906 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1908 */         this.addressNo = FValue.trim();
/*      */       }
/*      */       else
/* 1911 */         this.addressNo = null;
/*      */     }
/* 1913 */     if (FCode.equals("iDType"))
/*      */     {
/* 1915 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1917 */         this.iDType = FValue.trim();
/*      */       }
/*      */       else
/* 1920 */         this.iDType = null;
/*      */     }
/* 1922 */     if (FCode.equals("iDNo"))
/*      */     {
/* 1924 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1926 */         this.iDNo = FValue.trim();
/*      */       }
/*      */       else
/* 1929 */         this.iDNo = null;
/*      */     }
/* 1931 */     if (FCode.equals("iDValidity"))
/*      */     {
/* 1933 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1935 */         this.iDValidity = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1938 */         this.iDValidity = null;
/*      */     }
/* 1940 */     if (FCode.equals("iDPerpetual"))
/*      */     {
/* 1942 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1944 */         this.iDPerpetual = FValue.trim();
/*      */       }
/*      */       else
/* 1947 */         this.iDPerpetual = null;
/*      */     }
/* 1949 */     if (FCode.equals("nativePlace"))
/*      */     {
/* 1951 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1953 */         this.nativePlace = FValue.trim();
/*      */       }
/*      */       else
/* 1956 */         this.nativePlace = null;
/*      */     }
/* 1958 */     if (FCode.equals("nationality"))
/*      */     {
/* 1960 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1962 */         this.nationality = FValue.trim();
/*      */       }
/*      */       else
/* 1965 */         this.nationality = null;
/*      */     }
/* 1967 */     if (FCode.equals("rgtAddress"))
/*      */     {
/* 1969 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1971 */         this.rgtAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1974 */         this.rgtAddress = null;
/*      */     }
/* 1976 */     if (FCode.equals("marriage"))
/*      */     {
/* 1978 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1980 */         this.marriage = FValue.trim();
/*      */       }
/*      */       else
/* 1983 */         this.marriage = null;
/*      */     }
/* 1985 */     if (FCode.equals("marriageDate"))
/*      */     {
/* 1987 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1989 */         this.marriageDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1992 */         this.marriageDate = null;
/*      */     }
/* 1994 */     if (FCode.equals("health"))
/*      */     {
/* 1996 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1998 */         this.health = FValue.trim();
/*      */       }
/*      */       else
/* 2001 */         this.health = null;
/*      */     }
/* 2003 */     if (FCode.equals("stature"))
/*      */     {
/* 2005 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2007 */         Double tDouble = new Double(FValue);
/* 2008 */         double d = tDouble.doubleValue();
/* 2009 */         this.stature = d;
/*      */       }
/*      */     }
/* 2012 */     if (FCode.equals("avoirdupois"))
/*      */     {
/* 2014 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2016 */         Double tDouble = new Double(FValue);
/* 2017 */         double d = tDouble.doubleValue();
/* 2018 */         this.avoirdupois = d;
/*      */       }
/*      */     }
/* 2021 */     if (FCode.equals("degree"))
/*      */     {
/* 2023 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2025 */         this.degree = FValue.trim();
/*      */       }
/*      */       else
/* 2028 */         this.degree = null;
/*      */     }
/* 2030 */     if (FCode.equals("creditGrade"))
/*      */     {
/* 2032 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2034 */         this.creditGrade = FValue.trim();
/*      */       }
/*      */       else
/* 2037 */         this.creditGrade = null;
/*      */     }
/* 2039 */     if (FCode.equals("bankCode"))
/*      */     {
/* 2041 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2043 */         this.bankCode = FValue.trim();
/*      */       }
/*      */       else
/* 2046 */         this.bankCode = null;
/*      */     }
/* 2048 */     if (FCode.equals("bankAccNo"))
/*      */     {
/* 2050 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2052 */         this.bankAccNo = FValue.trim();
/*      */       }
/*      */       else
/* 2055 */         this.bankAccNo = null;
/*      */     }
/* 2057 */     if (FCode.equals("accName"))
/*      */     {
/* 2059 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2061 */         this.accName = FValue.trim();
/*      */       }
/*      */       else
/* 2064 */         this.accName = null;
/*      */     }
/* 2066 */     if (FCode.equals("joinCompanyDate"))
/*      */     {
/* 2068 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2070 */         this.joinCompanyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2073 */         this.joinCompanyDate = null;
/*      */     }
/* 2075 */     if (FCode.equals("startWorkDate"))
/*      */     {
/* 2077 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2079 */         this.startWorkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2082 */         this.startWorkDate = null;
/*      */     }
/* 2084 */     if (FCode.equals("position"))
/*      */     {
/* 2086 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2088 */         this.position = FValue.trim();
/*      */       }
/*      */       else
/* 2091 */         this.position = null;
/*      */     }
/* 2093 */     if (FCode.equals("salary"))
/*      */     {
/* 2095 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2097 */         Double tDouble = new Double(FValue);
/* 2098 */         double d = tDouble.doubleValue();
/* 2099 */         this.salary = d;
/*      */       }
/*      */     }
/* 2102 */     if (FCode.equals("occupationType"))
/*      */     {
/* 2104 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2106 */         this.occupationType = FValue.trim();
/*      */       }
/*      */       else
/* 2109 */         this.occupationType = null;
/*      */     }
/* 2111 */     if (FCode.equals("occupationCode"))
/*      */     {
/* 2113 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2115 */         this.occupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 2118 */         this.occupationCode = null;
/*      */     }
/* 2120 */     if (FCode.equals("workType"))
/*      */     {
/* 2122 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2124 */         this.workType = FValue.trim();
/*      */       }
/*      */       else
/* 2127 */         this.workType = null;
/*      */     }
/* 2129 */     if (FCode.equals("pluralityType"))
/*      */     {
/* 2131 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2133 */         this.pluralityType = FValue.trim();
/*      */       }
/*      */       else
/* 2136 */         this.pluralityType = null;
/*      */     }
/* 2138 */     if (FCode.equals("smokeFlag"))
/*      */     {
/* 2140 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2142 */         this.smokeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2145 */         this.smokeFlag = null;
/*      */     }
/* 2147 */     if (FCode.equals("bnfFlag"))
/*      */     {
/* 2149 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2151 */         this.bnfFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2154 */         this.bnfFlag = null;
/*      */     }
/* 2156 */     if (FCode.equals("operator"))
/*      */     {
/* 2158 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2160 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 2163 */         this.operator = null;
/*      */     }
/* 2165 */     if (FCode.equals("manageCom"))
/*      */     {
/* 2167 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2169 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 2172 */         this.manageCom = null;
/*      */     }
/* 2174 */     if (FCode.equals("makeDate"))
/*      */     {
/* 2176 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2178 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2181 */         this.makeDate = null;
/*      */     }
/* 2183 */     if (FCode.equals("makeTime"))
/*      */     {
/* 2185 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2187 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 2190 */         this.makeTime = null;
/*      */     }
/* 2192 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 2194 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2196 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2199 */         this.modifyDate = null;
/*      */     }
/* 2201 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 2203 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2205 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 2208 */         this.modifyTime = null;
/*      */     }
/* 2210 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 2215 */     if (this == otherObject) return true;
/* 2216 */     if (otherObject == null) return false;
/* 2217 */     if (getClass() != otherObject.getClass()) return false;
/* 2218 */     LNPBnfBSchema other = (LNPBnfBSchema)otherObject;
/* 2219 */     return 
/* 2220 */       (this.EdorNo.equals(other.getEdorNo())) && 
/* 2221 */       (this.serialNo.equals(other.getserialNo())) && 
/* 2222 */       (this.contNo.equals(other.getcontNo())) && 
/* 2223 */       (this.polNo.equals(other.getpolNo())) && 
/* 2224 */       (this.insuredNo.equals(other.getinsuredNo())) && 
/* 2225 */       (this.insuredId.equals(other.getinsuredId())) && 
/* 2226 */       (this.benefitType.equals(other.getbenefitType())) && 
/* 2227 */       (this.bnfOrder == other.getbnfOrder()) && 
/* 2228 */       (this.bnfGrade.equals(other.getbnfGrade())) && 
/* 2229 */       (this.benefitRate == other.getbenefitRate()) && 
/* 2230 */       (this.benefitOrder.equals(other.getbenefitOrder())) && 
/* 2231 */       (this.bnfNo.equals(other.getbnfNo())) && 
/* 2232 */       (this.bnfId.equals(other.getbnfId())) && 
/* 2233 */       (this.appellation.equals(other.getappellation())) && 
/* 2234 */       (this.bnfName.equals(other.getbnfName())) && 
/* 2235 */       (this.bnfSex.equals(other.getbnfSex())) && 
/* 2236 */       (this.fDate.getString(this.bnfBirthday).equals(other.getbnfBirthday())) && 
/* 2237 */       (this.bnfAge == other.getbnfAge()) && 
/* 2238 */       (this.relationToInsured.equals(other.getrelationToInsured())) && 
/* 2239 */       (this.addressNo.equals(other.getaddressNo())) && 
/* 2240 */       (this.iDType.equals(other.getiDType())) && 
/* 2241 */       (this.iDNo.equals(other.getiDNo())) && 
/* 2242 */       (this.fDate.getString(this.iDValidity).equals(other.getiDValidity())) && 
/* 2243 */       (this.iDPerpetual.equals(other.getiDPerpetual())) && 
/* 2244 */       (this.nativePlace.equals(other.getnativePlace())) && 
/* 2245 */       (this.nationality.equals(other.getnationality())) && 
/* 2246 */       (this.rgtAddress.equals(other.getrgtAddress())) && 
/* 2247 */       (this.marriage.equals(other.getmarriage())) && 
/* 2248 */       (this.fDate.getString(this.marriageDate).equals(other.getmarriageDate())) && 
/* 2249 */       (this.health.equals(other.gethealth())) && 
/* 2250 */       (this.stature == other.getstature()) && 
/* 2251 */       (this.avoirdupois == other.getavoirdupois()) && 
/* 2252 */       (this.degree.equals(other.getdegree())) && 
/* 2253 */       (this.creditGrade.equals(other.getcreditGrade())) && 
/* 2254 */       (this.bankCode.equals(other.getbankCode())) && 
/* 2255 */       (this.bankAccNo.equals(other.getbankAccNo())) && 
/* 2256 */       (this.accName.equals(other.getaccName())) && 
/* 2257 */       (this.fDate.getString(this.joinCompanyDate).equals(other.getjoinCompanyDate())) && 
/* 2258 */       (this.fDate.getString(this.startWorkDate).equals(other.getstartWorkDate())) && 
/* 2259 */       (this.position.equals(other.getposition())) && 
/* 2260 */       (this.salary == other.getsalary()) && 
/* 2261 */       (this.occupationType.equals(other.getoccupationType())) && 
/* 2262 */       (this.occupationCode.equals(other.getoccupationCode())) && 
/* 2263 */       (this.workType.equals(other.getworkType())) && 
/* 2264 */       (this.pluralityType.equals(other.getpluralityType())) && 
/* 2265 */       (this.smokeFlag.equals(other.getsmokeFlag())) && 
/* 2266 */       (this.bnfFlag.equals(other.getbnfFlag())) && 
/* 2267 */       (this.operator.equals(other.getoperator())) && 
/* 2268 */       (this.manageCom.equals(other.getmanageCom())) && 
/* 2269 */       (this.fDate.getString(this.makeDate).equals(other.getmakeDate())) && 
/* 2270 */       (this.makeTime.equals(other.getmakeTime())) && 
/* 2271 */       (this.fDate.getString(this.modifyDate).equals(other.getmodifyDate())) && 
/* 2272 */       (this.modifyTime.equals(other.getmodifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2278 */     return 53;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2284 */     if (strFieldName.equals("EdorNo")) {
/* 2285 */       return 0;
/*      */     }
/* 2287 */     if (strFieldName.equals("serialNo")) {
/* 2288 */       return 1;
/*      */     }
/* 2290 */     if (strFieldName.equals("contNo")) {
/* 2291 */       return 2;
/*      */     }
/* 2293 */     if (strFieldName.equals("polNo")) {
/* 2294 */       return 3;
/*      */     }
/* 2296 */     if (strFieldName.equals("insuredNo")) {
/* 2297 */       return 4;
/*      */     }
/* 2299 */     if (strFieldName.equals("insuredId")) {
/* 2300 */       return 5;
/*      */     }
/* 2302 */     if (strFieldName.equals("benefitType")) {
/* 2303 */       return 6;
/*      */     }
/* 2305 */     if (strFieldName.equals("bnfOrder")) {
/* 2306 */       return 7;
/*      */     }
/* 2308 */     if (strFieldName.equals("bnfGrade")) {
/* 2309 */       return 8;
/*      */     }
/* 2311 */     if (strFieldName.equals("benefitRate")) {
/* 2312 */       return 9;
/*      */     }
/* 2314 */     if (strFieldName.equals("benefitOrder")) {
/* 2315 */       return 10;
/*      */     }
/* 2317 */     if (strFieldName.equals("bnfNo")) {
/* 2318 */       return 11;
/*      */     }
/* 2320 */     if (strFieldName.equals("bnfId")) {
/* 2321 */       return 12;
/*      */     }
/* 2323 */     if (strFieldName.equals("appellation")) {
/* 2324 */       return 13;
/*      */     }
/* 2326 */     if (strFieldName.equals("bnfName")) {
/* 2327 */       return 14;
/*      */     }
/* 2329 */     if (strFieldName.equals("bnfSex")) {
/* 2330 */       return 15;
/*      */     }
/* 2332 */     if (strFieldName.equals("bnfBirthday")) {
/* 2333 */       return 16;
/*      */     }
/* 2335 */     if (strFieldName.equals("bnfAge")) {
/* 2336 */       return 17;
/*      */     }
/* 2338 */     if (strFieldName.equals("relationToInsured")) {
/* 2339 */       return 18;
/*      */     }
/* 2341 */     if (strFieldName.equals("addressNo")) {
/* 2342 */       return 19;
/*      */     }
/* 2344 */     if (strFieldName.equals("iDType")) {
/* 2345 */       return 20;
/*      */     }
/* 2347 */     if (strFieldName.equals("iDNo")) {
/* 2348 */       return 21;
/*      */     }
/* 2350 */     if (strFieldName.equals("iDValidity")) {
/* 2351 */       return 22;
/*      */     }
/* 2353 */     if (strFieldName.equals("iDPerpetual")) {
/* 2354 */       return 23;
/*      */     }
/* 2356 */     if (strFieldName.equals("nativePlace")) {
/* 2357 */       return 24;
/*      */     }
/* 2359 */     if (strFieldName.equals("nationality")) {
/* 2360 */       return 25;
/*      */     }
/* 2362 */     if (strFieldName.equals("rgtAddress")) {
/* 2363 */       return 26;
/*      */     }
/* 2365 */     if (strFieldName.equals("marriage")) {
/* 2366 */       return 27;
/*      */     }
/* 2368 */     if (strFieldName.equals("marriageDate")) {
/* 2369 */       return 28;
/*      */     }
/* 2371 */     if (strFieldName.equals("health")) {
/* 2372 */       return 29;
/*      */     }
/* 2374 */     if (strFieldName.equals("stature")) {
/* 2375 */       return 30;
/*      */     }
/* 2377 */     if (strFieldName.equals("avoirdupois")) {
/* 2378 */       return 31;
/*      */     }
/* 2380 */     if (strFieldName.equals("degree")) {
/* 2381 */       return 32;
/*      */     }
/* 2383 */     if (strFieldName.equals("creditGrade")) {
/* 2384 */       return 33;
/*      */     }
/* 2386 */     if (strFieldName.equals("bankCode")) {
/* 2387 */       return 34;
/*      */     }
/* 2389 */     if (strFieldName.equals("bankAccNo")) {
/* 2390 */       return 35;
/*      */     }
/* 2392 */     if (strFieldName.equals("accName")) {
/* 2393 */       return 36;
/*      */     }
/* 2395 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2396 */       return 37;
/*      */     }
/* 2398 */     if (strFieldName.equals("startWorkDate")) {
/* 2399 */       return 38;
/*      */     }
/* 2401 */     if (strFieldName.equals("position")) {
/* 2402 */       return 39;
/*      */     }
/* 2404 */     if (strFieldName.equals("salary")) {
/* 2405 */       return 40;
/*      */     }
/* 2407 */     if (strFieldName.equals("occupationType")) {
/* 2408 */       return 41;
/*      */     }
/* 2410 */     if (strFieldName.equals("occupationCode")) {
/* 2411 */       return 42;
/*      */     }
/* 2413 */     if (strFieldName.equals("workType")) {
/* 2414 */       return 43;
/*      */     }
/* 2416 */     if (strFieldName.equals("pluralityType")) {
/* 2417 */       return 44;
/*      */     }
/* 2419 */     if (strFieldName.equals("smokeFlag")) {
/* 2420 */       return 45;
/*      */     }
/* 2422 */     if (strFieldName.equals("bnfFlag")) {
/* 2423 */       return 46;
/*      */     }
/* 2425 */     if (strFieldName.equals("operator")) {
/* 2426 */       return 47;
/*      */     }
/* 2428 */     if (strFieldName.equals("manageCom")) {
/* 2429 */       return 48;
/*      */     }
/* 2431 */     if (strFieldName.equals("makeDate")) {
/* 2432 */       return 49;
/*      */     }
/* 2434 */     if (strFieldName.equals("makeTime")) {
/* 2435 */       return 50;
/*      */     }
/* 2437 */     if (strFieldName.equals("modifyDate")) {
/* 2438 */       return 51;
/*      */     }
/* 2440 */     if (strFieldName.equals("modifyTime")) {
/* 2441 */       return 52;
/*      */     }
/* 2443 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2449 */     String strFieldName = "";
/* 2450 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2452 */       strFieldName = "EdorNo";
/* 2453 */       break;
/*      */     case 1:
/* 2455 */       strFieldName = "serialNo";
/* 2456 */       break;
/*      */     case 2:
/* 2458 */       strFieldName = "contNo";
/* 2459 */       break;
/*      */     case 3:
/* 2461 */       strFieldName = "polNo";
/* 2462 */       break;
/*      */     case 4:
/* 2464 */       strFieldName = "insuredNo";
/* 2465 */       break;
/*      */     case 5:
/* 2467 */       strFieldName = "insuredId";
/* 2468 */       break;
/*      */     case 6:
/* 2470 */       strFieldName = "benefitType";
/* 2471 */       break;
/*      */     case 7:
/* 2473 */       strFieldName = "bnfOrder";
/* 2474 */       break;
/*      */     case 8:
/* 2476 */       strFieldName = "bnfGrade";
/* 2477 */       break;
/*      */     case 9:
/* 2479 */       strFieldName = "benefitRate";
/* 2480 */       break;
/*      */     case 10:
/* 2482 */       strFieldName = "benefitOrder";
/* 2483 */       break;
/*      */     case 11:
/* 2485 */       strFieldName = "bnfNo";
/* 2486 */       break;
/*      */     case 12:
/* 2488 */       strFieldName = "bnfId";
/* 2489 */       break;
/*      */     case 13:
/* 2491 */       strFieldName = "appellation";
/* 2492 */       break;
/*      */     case 14:
/* 2494 */       strFieldName = "bnfName";
/* 2495 */       break;
/*      */     case 15:
/* 2497 */       strFieldName = "bnfSex";
/* 2498 */       break;
/*      */     case 16:
/* 2500 */       strFieldName = "bnfBirthday";
/* 2501 */       break;
/*      */     case 17:
/* 2503 */       strFieldName = "bnfAge";
/* 2504 */       break;
/*      */     case 18:
/* 2506 */       strFieldName = "relationToInsured";
/* 2507 */       break;
/*      */     case 19:
/* 2509 */       strFieldName = "addressNo";
/* 2510 */       break;
/*      */     case 20:
/* 2512 */       strFieldName = "iDType";
/* 2513 */       break;
/*      */     case 21:
/* 2515 */       strFieldName = "iDNo";
/* 2516 */       break;
/*      */     case 22:
/* 2518 */       strFieldName = "iDValidity";
/* 2519 */       break;
/*      */     case 23:
/* 2521 */       strFieldName = "iDPerpetual";
/* 2522 */       break;
/*      */     case 24:
/* 2524 */       strFieldName = "nativePlace";
/* 2525 */       break;
/*      */     case 25:
/* 2527 */       strFieldName = "nationality";
/* 2528 */       break;
/*      */     case 26:
/* 2530 */       strFieldName = "rgtAddress";
/* 2531 */       break;
/*      */     case 27:
/* 2533 */       strFieldName = "marriage";
/* 2534 */       break;
/*      */     case 28:
/* 2536 */       strFieldName = "marriageDate";
/* 2537 */       break;
/*      */     case 29:
/* 2539 */       strFieldName = "health";
/* 2540 */       break;
/*      */     case 30:
/* 2542 */       strFieldName = "stature";
/* 2543 */       break;
/*      */     case 31:
/* 2545 */       strFieldName = "avoirdupois";
/* 2546 */       break;
/*      */     case 32:
/* 2548 */       strFieldName = "degree";
/* 2549 */       break;
/*      */     case 33:
/* 2551 */       strFieldName = "creditGrade";
/* 2552 */       break;
/*      */     case 34:
/* 2554 */       strFieldName = "bankCode";
/* 2555 */       break;
/*      */     case 35:
/* 2557 */       strFieldName = "bankAccNo";
/* 2558 */       break;
/*      */     case 36:
/* 2560 */       strFieldName = "accName";
/* 2561 */       break;
/*      */     case 37:
/* 2563 */       strFieldName = "joinCompanyDate";
/* 2564 */       break;
/*      */     case 38:
/* 2566 */       strFieldName = "startWorkDate";
/* 2567 */       break;
/*      */     case 39:
/* 2569 */       strFieldName = "position";
/* 2570 */       break;
/*      */     case 40:
/* 2572 */       strFieldName = "salary";
/* 2573 */       break;
/*      */     case 41:
/* 2575 */       strFieldName = "occupationType";
/* 2576 */       break;
/*      */     case 42:
/* 2578 */       strFieldName = "occupationCode";
/* 2579 */       break;
/*      */     case 43:
/* 2581 */       strFieldName = "workType";
/* 2582 */       break;
/*      */     case 44:
/* 2584 */       strFieldName = "pluralityType";
/* 2585 */       break;
/*      */     case 45:
/* 2587 */       strFieldName = "smokeFlag";
/* 2588 */       break;
/*      */     case 46:
/* 2590 */       strFieldName = "bnfFlag";
/* 2591 */       break;
/*      */     case 47:
/* 2593 */       strFieldName = "operator";
/* 2594 */       break;
/*      */     case 48:
/* 2596 */       strFieldName = "manageCom";
/* 2597 */       break;
/*      */     case 49:
/* 2599 */       strFieldName = "makeDate";
/* 2600 */       break;
/*      */     case 50:
/* 2602 */       strFieldName = "makeTime";
/* 2603 */       break;
/*      */     case 51:
/* 2605 */       strFieldName = "modifyDate";
/* 2606 */       break;
/*      */     case 52:
/* 2608 */       strFieldName = "modifyTime";
/* 2609 */       break;
/*      */     default:
/* 2611 */       strFieldName = "";
/*      */     }
/* 2613 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2619 */     if (strFieldName.equals("EdorNo")) {
/* 2620 */       return 0;
/*      */     }
/* 2622 */     if (strFieldName.equals("serialNo")) {
/* 2623 */       return 0;
/*      */     }
/* 2625 */     if (strFieldName.equals("contNo")) {
/* 2626 */       return 0;
/*      */     }
/* 2628 */     if (strFieldName.equals("polNo")) {
/* 2629 */       return 0;
/*      */     }
/* 2631 */     if (strFieldName.equals("insuredNo")) {
/* 2632 */       return 0;
/*      */     }
/* 2634 */     if (strFieldName.equals("insuredId")) {
/* 2635 */       return 0;
/*      */     }
/* 2637 */     if (strFieldName.equals("benefitType")) {
/* 2638 */       return 0;
/*      */     }
/* 2640 */     if (strFieldName.equals("bnfOrder")) {
/* 2641 */       return 3;
/*      */     }
/* 2643 */     if (strFieldName.equals("bnfGrade")) {
/* 2644 */       return 0;
/*      */     }
/* 2646 */     if (strFieldName.equals("benefitRate")) {
/* 2647 */       return 4;
/*      */     }
/* 2649 */     if (strFieldName.equals("benefitOrder")) {
/* 2650 */       return 0;
/*      */     }
/* 2652 */     if (strFieldName.equals("bnfNo")) {
/* 2653 */       return 0;
/*      */     }
/* 2655 */     if (strFieldName.equals("bnfId")) {
/* 2656 */       return 0;
/*      */     }
/* 2658 */     if (strFieldName.equals("appellation")) {
/* 2659 */       return 0;
/*      */     }
/* 2661 */     if (strFieldName.equals("bnfName")) {
/* 2662 */       return 0;
/*      */     }
/* 2664 */     if (strFieldName.equals("bnfSex")) {
/* 2665 */       return 0;
/*      */     }
/* 2667 */     if (strFieldName.equals("bnfBirthday")) {
/* 2668 */       return 1;
/*      */     }
/* 2670 */     if (strFieldName.equals("bnfAge")) {
/* 2671 */       return 3;
/*      */     }
/* 2673 */     if (strFieldName.equals("relationToInsured")) {
/* 2674 */       return 0;
/*      */     }
/* 2676 */     if (strFieldName.equals("addressNo")) {
/* 2677 */       return 0;
/*      */     }
/* 2679 */     if (strFieldName.equals("iDType")) {
/* 2680 */       return 0;
/*      */     }
/* 2682 */     if (strFieldName.equals("iDNo")) {
/* 2683 */       return 0;
/*      */     }
/* 2685 */     if (strFieldName.equals("iDValidity")) {
/* 2686 */       return 1;
/*      */     }
/* 2688 */     if (strFieldName.equals("iDPerpetual")) {
/* 2689 */       return 0;
/*      */     }
/* 2691 */     if (strFieldName.equals("nativePlace")) {
/* 2692 */       return 0;
/*      */     }
/* 2694 */     if (strFieldName.equals("nationality")) {
/* 2695 */       return 0;
/*      */     }
/* 2697 */     if (strFieldName.equals("rgtAddress")) {
/* 2698 */       return 0;
/*      */     }
/* 2700 */     if (strFieldName.equals("marriage")) {
/* 2701 */       return 0;
/*      */     }
/* 2703 */     if (strFieldName.equals("marriageDate")) {
/* 2704 */       return 1;
/*      */     }
/* 2706 */     if (strFieldName.equals("health")) {
/* 2707 */       return 0;
/*      */     }
/* 2709 */     if (strFieldName.equals("stature")) {
/* 2710 */       return 4;
/*      */     }
/* 2712 */     if (strFieldName.equals("avoirdupois")) {
/* 2713 */       return 4;
/*      */     }
/* 2715 */     if (strFieldName.equals("degree")) {
/* 2716 */       return 0;
/*      */     }
/* 2718 */     if (strFieldName.equals("creditGrade")) {
/* 2719 */       return 0;
/*      */     }
/* 2721 */     if (strFieldName.equals("bankCode")) {
/* 2722 */       return 0;
/*      */     }
/* 2724 */     if (strFieldName.equals("bankAccNo")) {
/* 2725 */       return 0;
/*      */     }
/* 2727 */     if (strFieldName.equals("accName")) {
/* 2728 */       return 0;
/*      */     }
/* 2730 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2731 */       return 1;
/*      */     }
/* 2733 */     if (strFieldName.equals("startWorkDate")) {
/* 2734 */       return 1;
/*      */     }
/* 2736 */     if (strFieldName.equals("position")) {
/* 2737 */       return 0;
/*      */     }
/* 2739 */     if (strFieldName.equals("salary")) {
/* 2740 */       return 4;
/*      */     }
/* 2742 */     if (strFieldName.equals("occupationType")) {
/* 2743 */       return 0;
/*      */     }
/* 2745 */     if (strFieldName.equals("occupationCode")) {
/* 2746 */       return 0;
/*      */     }
/* 2748 */     if (strFieldName.equals("workType")) {
/* 2749 */       return 0;
/*      */     }
/* 2751 */     if (strFieldName.equals("pluralityType")) {
/* 2752 */       return 0;
/*      */     }
/* 2754 */     if (strFieldName.equals("smokeFlag")) {
/* 2755 */       return 0;
/*      */     }
/* 2757 */     if (strFieldName.equals("bnfFlag")) {
/* 2758 */       return 0;
/*      */     }
/* 2760 */     if (strFieldName.equals("operator")) {
/* 2761 */       return 0;
/*      */     }
/* 2763 */     if (strFieldName.equals("manageCom")) {
/* 2764 */       return 0;
/*      */     }
/* 2766 */     if (strFieldName.equals("makeDate")) {
/* 2767 */       return 1;
/*      */     }
/* 2769 */     if (strFieldName.equals("makeTime")) {
/* 2770 */       return 0;
/*      */     }
/* 2772 */     if (strFieldName.equals("modifyDate")) {
/* 2773 */       return 1;
/*      */     }
/* 2775 */     if (strFieldName.equals("modifyTime")) {
/* 2776 */       return 0;
/*      */     }
/* 2778 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 2784 */     int nFieldType = -1;
/* 2785 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2787 */       nFieldType = 0;
/* 2788 */       break;
/*      */     case 1:
/* 2790 */       nFieldType = 0;
/* 2791 */       break;
/*      */     case 2:
/* 2793 */       nFieldType = 0;
/* 2794 */       break;
/*      */     case 3:
/* 2796 */       nFieldType = 0;
/* 2797 */       break;
/*      */     case 4:
/* 2799 */       nFieldType = 0;
/* 2800 */       break;
/*      */     case 5:
/* 2802 */       nFieldType = 0;
/* 2803 */       break;
/*      */     case 6:
/* 2805 */       nFieldType = 0;
/* 2806 */       break;
/*      */     case 7:
/* 2808 */       nFieldType = 3;
/* 2809 */       break;
/*      */     case 8:
/* 2811 */       nFieldType = 0;
/* 2812 */       break;
/*      */     case 9:
/* 2814 */       nFieldType = 4;
/* 2815 */       break;
/*      */     case 10:
/* 2817 */       nFieldType = 0;
/* 2818 */       break;
/*      */     case 11:
/* 2820 */       nFieldType = 0;
/* 2821 */       break;
/*      */     case 12:
/* 2823 */       nFieldType = 0;
/* 2824 */       break;
/*      */     case 13:
/* 2826 */       nFieldType = 0;
/* 2827 */       break;
/*      */     case 14:
/* 2829 */       nFieldType = 0;
/* 2830 */       break;
/*      */     case 15:
/* 2832 */       nFieldType = 0;
/* 2833 */       break;
/*      */     case 16:
/* 2835 */       nFieldType = 1;
/* 2836 */       break;
/*      */     case 17:
/* 2838 */       nFieldType = 3;
/* 2839 */       break;
/*      */     case 18:
/* 2841 */       nFieldType = 0;
/* 2842 */       break;
/*      */     case 19:
/* 2844 */       nFieldType = 0;
/* 2845 */       break;
/*      */     case 20:
/* 2847 */       nFieldType = 0;
/* 2848 */       break;
/*      */     case 21:
/* 2850 */       nFieldType = 0;
/* 2851 */       break;
/*      */     case 22:
/* 2853 */       nFieldType = 1;
/* 2854 */       break;
/*      */     case 23:
/* 2856 */       nFieldType = 0;
/* 2857 */       break;
/*      */     case 24:
/* 2859 */       nFieldType = 0;
/* 2860 */       break;
/*      */     case 25:
/* 2862 */       nFieldType = 0;
/* 2863 */       break;
/*      */     case 26:
/* 2865 */       nFieldType = 0;
/* 2866 */       break;
/*      */     case 27:
/* 2868 */       nFieldType = 0;
/* 2869 */       break;
/*      */     case 28:
/* 2871 */       nFieldType = 1;
/* 2872 */       break;
/*      */     case 29:
/* 2874 */       nFieldType = 0;
/* 2875 */       break;
/*      */     case 30:
/* 2877 */       nFieldType = 4;
/* 2878 */       break;
/*      */     case 31:
/* 2880 */       nFieldType = 4;
/* 2881 */       break;
/*      */     case 32:
/* 2883 */       nFieldType = 0;
/* 2884 */       break;
/*      */     case 33:
/* 2886 */       nFieldType = 0;
/* 2887 */       break;
/*      */     case 34:
/* 2889 */       nFieldType = 0;
/* 2890 */       break;
/*      */     case 35:
/* 2892 */       nFieldType = 0;
/* 2893 */       break;
/*      */     case 36:
/* 2895 */       nFieldType = 0;
/* 2896 */       break;
/*      */     case 37:
/* 2898 */       nFieldType = 1;
/* 2899 */       break;
/*      */     case 38:
/* 2901 */       nFieldType = 1;
/* 2902 */       break;
/*      */     case 39:
/* 2904 */       nFieldType = 0;
/* 2905 */       break;
/*      */     case 40:
/* 2907 */       nFieldType = 4;
/* 2908 */       break;
/*      */     case 41:
/* 2910 */       nFieldType = 0;
/* 2911 */       break;
/*      */     case 42:
/* 2913 */       nFieldType = 0;
/* 2914 */       break;
/*      */     case 43:
/* 2916 */       nFieldType = 0;
/* 2917 */       break;
/*      */     case 44:
/* 2919 */       nFieldType = 0;
/* 2920 */       break;
/*      */     case 45:
/* 2922 */       nFieldType = 0;
/* 2923 */       break;
/*      */     case 46:
/* 2925 */       nFieldType = 0;
/* 2926 */       break;
/*      */     case 47:
/* 2928 */       nFieldType = 0;
/* 2929 */       break;
/*      */     case 48:
/* 2931 */       nFieldType = 0;
/* 2932 */       break;
/*      */     case 49:
/* 2934 */       nFieldType = 1;
/* 2935 */       break;
/*      */     case 50:
/* 2937 */       nFieldType = 0;
/* 2938 */       break;
/*      */     case 51:
/* 2940 */       nFieldType = 1;
/* 2941 */       break;
/*      */     case 52:
/* 2943 */       nFieldType = 0;
/* 2944 */       break;
/*      */     default:
/* 2946 */       nFieldType = -1;
/*      */     }
/* 2948 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPBnfBSchema
 * JD-Core Version:    0.6.0
 */