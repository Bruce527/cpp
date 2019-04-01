/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPPersonBDB;
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
/*      */ public class LNPPersonBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
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
/*      */   public static final int FIELDNUM = 58;
/*      */   private static String[] PK;
/*  141 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPPersonBSchema()
/*      */   {
/*  148 */     this.mErrors = new CErrors();
/*      */ 
/*  150 */     String[] pk = new String[2];
/*  151 */     pk[0] = "EdorNo";
/*  152 */     pk[1] = "serialNo";
/*      */ 
/*  154 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  160 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  165 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*  169 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  173 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*  177 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  181 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  185 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getcustomerId() {
/*  189 */     if (this.customerId != null) this.customerId.equals("");
/*      */ 
/*  193 */     return this.customerId;
/*      */   }
/*      */ 
/*      */   public void setcustomerId(String acustomerId) {
/*  197 */     this.customerId = acustomerId;
/*      */   }
/*      */ 
/*      */   public String getagentCode() {
/*  201 */     if (this.agentCode != null) this.agentCode.equals("");
/*      */ 
/*  205 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setagentCode(String aagentCode) {
/*  209 */     this.agentCode = aagentCode;
/*      */   }
/*      */ 
/*      */   public String getcustomerNo() {
/*  213 */     if (this.customerNo != null) this.customerNo.equals("");
/*      */ 
/*  217 */     return this.customerNo;
/*      */   }
/*      */ 
/*      */   public void setcustomerNo(String acustomerNo) {
/*  221 */     this.customerNo = acustomerNo;
/*      */   }
/*      */ 
/*      */   public String getappellation() {
/*  225 */     if (this.appellation != null) this.appellation.equals("");
/*      */ 
/*  229 */     return this.appellation;
/*      */   }
/*      */ 
/*      */   public void setappellation(String aappellation) {
/*  233 */     this.appellation = aappellation;
/*      */   }
/*      */ 
/*      */   public String getname() {
/*  237 */     if (this.name != null) this.name.equals("");
/*      */ 
/*  241 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setname(String aname) {
/*  245 */     this.name = aname;
/*      */   }
/*      */ 
/*      */   public String getsex() {
/*  249 */     if (this.sex != null) this.sex.equals("");
/*      */ 
/*  253 */     return this.sex;
/*      */   }
/*      */ 
/*      */   public void setsex(String asex) {
/*  257 */     this.sex = asex;
/*      */   }
/*      */ 
/*      */   public String getbirthday() {
/*  261 */     if (this.birthday != null) {
/*  262 */       return this.fDate.getString(this.birthday);
/*      */     }
/*  264 */     return null;
/*      */   }
/*      */ 
/*      */   public void setbirthday(Date abirthday) {
/*  268 */     this.birthday = abirthday;
/*      */   }
/*      */ 
/*      */   public void setbirthday(String abirthday) {
/*  272 */     if ((abirthday != null) && (!abirthday.equals("")))
/*      */     {
/*  274 */       this.birthday = this.fDate.getDate(abirthday);
/*      */     }
/*      */     else
/*  277 */       this.birthday = null;
/*      */   }
/*      */ 
/*      */   public int getage()
/*      */   {
/*  282 */     return this.age;
/*      */   }
/*      */ 
/*      */   public void setage(int aage) {
/*  286 */     this.age = aage;
/*      */   }
/*      */ 
/*      */   public void setage(String aage) {
/*  290 */     if ((aage != null) && (!aage.equals("")))
/*      */     {
/*  292 */       Integer tInteger = new Integer(aage);
/*  293 */       int i = tInteger.intValue();
/*  294 */       this.age = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getageType()
/*      */   {
/*  300 */     if (this.ageType != null) this.ageType.equals("");
/*      */ 
/*  304 */     return this.ageType;
/*      */   }
/*      */ 
/*      */   public void setageType(String aageType) {
/*  308 */     this.ageType = aageType;
/*      */   }
/*      */ 
/*      */   public String getappntType() {
/*  312 */     if (this.appntType != null) this.appntType.equals("");
/*      */ 
/*  316 */     return this.appntType;
/*      */   }
/*      */ 
/*      */   public void setappntType(String aappntType) {
/*  320 */     this.appntType = aappntType;
/*      */   }
/*      */ 
/*      */   public String getiDType() {
/*  324 */     if (this.iDType != null) this.iDType.equals("");
/*      */ 
/*  328 */     return this.iDType;
/*      */   }
/*      */ 
/*      */   public void setiDType(String aiDType) {
/*  332 */     this.iDType = aiDType;
/*      */   }
/*      */ 
/*      */   public String getiDNo() {
/*  336 */     if (this.iDNo != null) this.iDNo.equals("");
/*      */ 
/*  340 */     return this.iDNo;
/*      */   }
/*      */ 
/*      */   public void setiDNo(String aiDNo) {
/*  344 */     this.iDNo = aiDNo;
/*      */   }
/*      */ 
/*      */   public String getiDValidity() {
/*  348 */     if (this.iDValidity != null) {
/*  349 */       return this.fDate.getString(this.iDValidity);
/*      */     }
/*  351 */     return null;
/*      */   }
/*      */ 
/*      */   public void setiDValidity(Date aiDValidity) {
/*  355 */     this.iDValidity = aiDValidity;
/*      */   }
/*      */ 
/*      */   public void setiDValidity(String aiDValidity) {
/*  359 */     if ((aiDValidity != null) && (!aiDValidity.equals("")))
/*      */     {
/*  361 */       this.iDValidity = this.fDate.getDate(aiDValidity);
/*      */     }
/*      */     else
/*  364 */       this.iDValidity = null;
/*      */   }
/*      */ 
/*      */   public String getiDPerpetual()
/*      */   {
/*  369 */     if (this.iDPerpetual != null) this.iDPerpetual.equals("");
/*      */ 
/*  373 */     return this.iDPerpetual;
/*      */   }
/*      */ 
/*      */   public void setiDPerpetual(String aiDPerpetual) {
/*  377 */     this.iDPerpetual = aiDPerpetual;
/*      */   }
/*      */ 
/*      */   public String getpassword() {
/*  381 */     if (this.password != null) this.password.equals("");
/*      */ 
/*  385 */     return this.password;
/*      */   }
/*      */ 
/*      */   public void setpassword(String apassword) {
/*  389 */     this.password = apassword;
/*      */   }
/*      */ 
/*      */   public String getnativePlace() {
/*  393 */     if (this.nativePlace != null) this.nativePlace.equals("");
/*      */ 
/*  397 */     return this.nativePlace;
/*      */   }
/*      */ 
/*      */   public void setnativePlace(String anativePlace) {
/*  401 */     this.nativePlace = anativePlace;
/*      */   }
/*      */ 
/*      */   public String getnationality() {
/*  405 */     if (this.nationality != null) this.nationality.equals("");
/*      */ 
/*  409 */     return this.nationality;
/*      */   }
/*      */ 
/*      */   public void setnationality(String anationality) {
/*  413 */     this.nationality = anationality;
/*      */   }
/*      */ 
/*      */   public String getrgtAddress() {
/*  417 */     if (this.rgtAddress != null) this.rgtAddress.equals("");
/*      */ 
/*  421 */     return this.rgtAddress;
/*      */   }
/*      */ 
/*      */   public void setrgtAddress(String argtAddress) {
/*  425 */     this.rgtAddress = argtAddress;
/*      */   }
/*      */ 
/*      */   public String getmarriage() {
/*  429 */     if (this.marriage != null) this.marriage.equals("");
/*      */ 
/*  433 */     return this.marriage;
/*      */   }
/*      */ 
/*      */   public void setmarriage(String amarriage) {
/*  437 */     this.marriage = amarriage;
/*      */   }
/*      */ 
/*      */   public String getmarriageDate() {
/*  441 */     if (this.marriageDate != null) {
/*  442 */       return this.fDate.getString(this.marriageDate);
/*      */     }
/*  444 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmarriageDate(Date amarriageDate) {
/*  448 */     this.marriageDate = amarriageDate;
/*      */   }
/*      */ 
/*      */   public void setmarriageDate(String amarriageDate) {
/*  452 */     if ((amarriageDate != null) && (!amarriageDate.equals("")))
/*      */     {
/*  454 */       this.marriageDate = this.fDate.getDate(amarriageDate);
/*      */     }
/*      */     else
/*  457 */       this.marriageDate = null;
/*      */   }
/*      */ 
/*      */   public String gethealth()
/*      */   {
/*  462 */     if (this.health != null) this.health.equals("");
/*      */ 
/*  466 */     return this.health;
/*      */   }
/*      */ 
/*      */   public void sethealth(String ahealth) {
/*  470 */     this.health = ahealth;
/*      */   }
/*      */ 
/*      */   public double getstature() {
/*  474 */     return this.stature;
/*      */   }
/*      */ 
/*      */   public void setstature(double astature) {
/*  478 */     this.stature = astature;
/*      */   }
/*      */ 
/*      */   public void setstature(String astature) {
/*  482 */     if ((astature != null) && (!astature.equals("")))
/*      */     {
/*  484 */       Double tDouble = new Double(astature);
/*  485 */       double d = tDouble.doubleValue();
/*  486 */       this.stature = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getavoirdupois()
/*      */   {
/*  492 */     return this.avoirdupois;
/*      */   }
/*      */ 
/*      */   public void setavoirdupois(double aavoirdupois) {
/*  496 */     this.avoirdupois = aavoirdupois;
/*      */   }
/*      */ 
/*      */   public void setavoirdupois(String aavoirdupois) {
/*  500 */     if ((aavoirdupois != null) && (!aavoirdupois.equals("")))
/*      */     {
/*  502 */       Double tDouble = new Double(aavoirdupois);
/*  503 */       double d = tDouble.doubleValue();
/*  504 */       this.avoirdupois = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getdegree()
/*      */   {
/*  510 */     if (this.degree != null) this.degree.equals("");
/*      */ 
/*  514 */     return this.degree;
/*      */   }
/*      */ 
/*      */   public void setdegree(String adegree) {
/*  518 */     this.degree = adegree;
/*      */   }
/*      */ 
/*      */   public String getcreditGrade() {
/*  522 */     if (this.creditGrade != null) this.creditGrade.equals("");
/*      */ 
/*  526 */     return this.creditGrade;
/*      */   }
/*      */ 
/*      */   public void setcreditGrade(String acreditGrade) {
/*  530 */     this.creditGrade = acreditGrade;
/*      */   }
/*      */ 
/*      */   public String getbankCode() {
/*  534 */     if (this.bankCode != null) this.bankCode.equals("");
/*      */ 
/*  538 */     return this.bankCode;
/*      */   }
/*      */ 
/*      */   public void setbankCode(String abankCode) {
/*  542 */     this.bankCode = abankCode;
/*      */   }
/*      */ 
/*      */   public String getbankAccNo() {
/*  546 */     if (this.bankAccNo != null) this.bankAccNo.equals("");
/*      */ 
/*  550 */     return this.bankAccNo;
/*      */   }
/*      */ 
/*      */   public void setbankAccNo(String abankAccNo) {
/*  554 */     this.bankAccNo = abankAccNo;
/*      */   }
/*      */ 
/*      */   public String getaccName() {
/*  558 */     if (this.accName != null) this.accName.equals("");
/*      */ 
/*  562 */     return this.accName;
/*      */   }
/*      */ 
/*      */   public void setaccName(String aaccName) {
/*  566 */     this.accName = aaccName;
/*      */   }
/*      */ 
/*      */   public String getothIDType() {
/*  570 */     if (this.othIDType != null) this.othIDType.equals("");
/*      */ 
/*  574 */     return this.othIDType;
/*      */   }
/*      */ 
/*      */   public void setothIDType(String aothIDType) {
/*  578 */     this.othIDType = aothIDType;
/*      */   }
/*      */ 
/*      */   public String getothIDNo() {
/*  582 */     if (this.othIDNo != null) this.othIDNo.equals("");
/*      */ 
/*  586 */     return this.othIDNo;
/*      */   }
/*      */ 
/*      */   public void setothIDNo(String aothIDNo) {
/*  590 */     this.othIDNo = aothIDNo;
/*      */   }
/*      */ 
/*      */   public String getiCNo() {
/*  594 */     if (this.iCNo != null) this.iCNo.equals("");
/*      */ 
/*  598 */     return this.iCNo;
/*      */   }
/*      */ 
/*      */   public void setiCNo(String aiCNo) {
/*  602 */     this.iCNo = aiCNo;
/*      */   }
/*      */ 
/*      */   public String getgrpNo() {
/*  606 */     if (this.grpNo != null) this.grpNo.equals("");
/*      */ 
/*  610 */     return this.grpNo;
/*      */   }
/*      */ 
/*      */   public void setgrpNo(String agrpNo) {
/*  614 */     this.grpNo = agrpNo;
/*      */   }
/*      */ 
/*      */   public String getjoinCompanyDate() {
/*  618 */     if (this.joinCompanyDate != null) {
/*  619 */       return this.fDate.getString(this.joinCompanyDate);
/*      */     }
/*  621 */     return null;
/*      */   }
/*      */ 
/*      */   public void setjoinCompanyDate(Date ajoinCompanyDate) {
/*  625 */     this.joinCompanyDate = ajoinCompanyDate;
/*      */   }
/*      */ 
/*      */   public void setjoinCompanyDate(String ajoinCompanyDate) {
/*  629 */     if ((ajoinCompanyDate != null) && (!ajoinCompanyDate.equals("")))
/*      */     {
/*  631 */       this.joinCompanyDate = this.fDate.getDate(ajoinCompanyDate);
/*      */     }
/*      */     else
/*  634 */       this.joinCompanyDate = null;
/*      */   }
/*      */ 
/*      */   public String getstartWorkDate()
/*      */   {
/*  639 */     if (this.startWorkDate != null) {
/*  640 */       return this.fDate.getString(this.startWorkDate);
/*      */     }
/*  642 */     return null;
/*      */   }
/*      */ 
/*      */   public void setstartWorkDate(Date astartWorkDate) {
/*  646 */     this.startWorkDate = astartWorkDate;
/*      */   }
/*      */ 
/*      */   public void setstartWorkDate(String astartWorkDate) {
/*  650 */     if ((astartWorkDate != null) && (!astartWorkDate.equals("")))
/*      */     {
/*  652 */       this.startWorkDate = this.fDate.getDate(astartWorkDate);
/*      */     }
/*      */     else
/*  655 */       this.startWorkDate = null;
/*      */   }
/*      */ 
/*      */   public String getposition()
/*      */   {
/*  660 */     if (this.position != null) this.position.equals("");
/*      */ 
/*  664 */     return this.position;
/*      */   }
/*      */ 
/*      */   public void setposition(String aposition) {
/*  668 */     this.position = aposition;
/*      */   }
/*      */ 
/*      */   public double getsalary() {
/*  672 */     return this.salary;
/*      */   }
/*      */ 
/*      */   public void setsalary(double asalary) {
/*  676 */     this.salary = asalary;
/*      */   }
/*      */ 
/*      */   public void setsalary(String asalary) {
/*  680 */     if ((asalary != null) && (!asalary.equals("")))
/*      */     {
/*  682 */       Double tDouble = new Double(asalary);
/*  683 */       double d = tDouble.doubleValue();
/*  684 */       this.salary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getoccupationType()
/*      */   {
/*  690 */     if (this.occupationType != null) this.occupationType.equals("");
/*      */ 
/*  694 */     return this.occupationType;
/*      */   }
/*      */ 
/*      */   public void setoccupationType(String aoccupationType) {
/*  698 */     this.occupationType = aoccupationType;
/*      */   }
/*      */ 
/*      */   public String getoccupationCode() {
/*  702 */     if (this.occupationCode != null) this.occupationCode.equals("");
/*      */ 
/*  706 */     return this.occupationCode;
/*      */   }
/*      */ 
/*      */   public void setoccupationCode(String aoccupationCode) {
/*  710 */     this.occupationCode = aoccupationCode;
/*      */   }
/*      */ 
/*      */   public String getpartOccupationType() {
/*  714 */     if (this.partOccupationType != null) this.partOccupationType.equals("");
/*      */ 
/*  718 */     return this.partOccupationType;
/*      */   }
/*      */ 
/*      */   public void setpartOccupationType(String apartOccupationType) {
/*  722 */     this.partOccupationType = apartOccupationType;
/*      */   }
/*      */ 
/*      */   public String getpartOccupationCode() {
/*  726 */     if (this.partOccupationCode != null) this.partOccupationCode.equals("");
/*      */ 
/*  730 */     return this.partOccupationCode;
/*      */   }
/*      */ 
/*      */   public void setpartOccupationCode(String apartOccupationCode) {
/*  734 */     this.partOccupationCode = apartOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getworkType() {
/*  738 */     if (this.workType != null) this.workType.equals("");
/*      */ 
/*  742 */     return this.workType;
/*      */   }
/*      */ 
/*      */   public void setworkType(String aworkType) {
/*  746 */     this.workType = aworkType;
/*      */   }
/*      */ 
/*      */   public String getpluralityType() {
/*  750 */     if (this.pluralityType != null) this.pluralityType.equals("");
/*      */ 
/*  754 */     return this.pluralityType;
/*      */   }
/*      */ 
/*      */   public void setpluralityType(String apluralityType) {
/*  758 */     this.pluralityType = apluralityType;
/*      */   }
/*      */ 
/*      */   public String getdeathDate() {
/*  762 */     if (this.deathDate != null) {
/*  763 */       return this.fDate.getString(this.deathDate);
/*      */     }
/*  765 */     return null;
/*      */   }
/*      */ 
/*      */   public void setdeathDate(Date adeathDate) {
/*  769 */     this.deathDate = adeathDate;
/*      */   }
/*      */ 
/*      */   public void setdeathDate(String adeathDate) {
/*  773 */     if ((adeathDate != null) && (!adeathDate.equals("")))
/*      */     {
/*  775 */       this.deathDate = this.fDate.getDate(adeathDate);
/*      */     }
/*      */     else
/*  778 */       this.deathDate = null;
/*      */   }
/*      */ 
/*      */   public String getsmokeFlag()
/*      */   {
/*  783 */     if (this.smokeFlag != null) this.smokeFlag.equals("");
/*      */ 
/*  787 */     return this.smokeFlag;
/*      */   }
/*      */ 
/*      */   public void setsmokeFlag(String asmokeFlag) {
/*  791 */     this.smokeFlag = asmokeFlag;
/*      */   }
/*      */ 
/*      */   public String getblacklistFlag() {
/*  795 */     if (this.blacklistFlag != null) this.blacklistFlag.equals("");
/*      */ 
/*  799 */     return this.blacklistFlag;
/*      */   }
/*      */ 
/*      */   public void setblacklistFlag(String ablacklistFlag) {
/*  803 */     this.blacklistFlag = ablacklistFlag;
/*      */   }
/*      */ 
/*      */   public String getproterty() {
/*  807 */     if (this.proterty != null) this.proterty.equals("");
/*      */ 
/*  811 */     return this.proterty;
/*      */   }
/*      */ 
/*      */   public void setproterty(String aproterty) {
/*  815 */     this.proterty = aproterty;
/*      */   }
/*      */ 
/*      */   public String getremark() {
/*  819 */     if (this.remark != null) this.remark.equals("");
/*      */ 
/*  823 */     return this.remark;
/*      */   }
/*      */ 
/*      */   public void setremark(String aremark) {
/*  827 */     this.remark = aremark;
/*      */   }
/*      */ 
/*      */   public String getstate() {
/*  831 */     if (this.state != null) this.state.equals("");
/*      */ 
/*  835 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setstate(String astate) {
/*  839 */     this.state = astate;
/*      */   }
/*      */ 
/*      */   public String getvIPValue() {
/*  843 */     if (this.vIPValue != null) this.vIPValue.equals("");
/*      */ 
/*  847 */     return this.vIPValue;
/*      */   }
/*      */ 
/*      */   public void setvIPValue(String avIPValue) {
/*  851 */     this.vIPValue = avIPValue;
/*      */   }
/*      */ 
/*      */   public String getoperator() {
/*  855 */     if (this.operator != null) this.operator.equals("");
/*      */ 
/*  859 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setoperator(String aoperator) {
/*  863 */     this.operator = aoperator;
/*      */   }
/*      */ 
/*      */   public String getmanageCom() {
/*  867 */     if (this.manageCom != null) this.manageCom.equals("");
/*      */ 
/*  871 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setmanageCom(String amanageCom) {
/*  875 */     this.manageCom = amanageCom;
/*      */   }
/*      */ 
/*      */   public String getmakeDate() {
/*  879 */     if (this.makeDate != null) {
/*  880 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  882 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(Date amakeDate) {
/*  886 */     this.makeDate = amakeDate;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(String amakeDate) {
/*  890 */     if ((amakeDate != null) && (!amakeDate.equals("")))
/*      */     {
/*  892 */       this.makeDate = this.fDate.getDate(amakeDate);
/*      */     }
/*      */     else
/*  895 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getmakeTime()
/*      */   {
/*  900 */     if (this.makeTime != null) this.makeTime.equals("");
/*      */ 
/*  904 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setmakeTime(String amakeTime) {
/*  908 */     this.makeTime = amakeTime;
/*      */   }
/*      */ 
/*      */   public String getmodifyDate() {
/*  912 */     if (this.modifyDate != null) {
/*  913 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  915 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(Date amodifyDate) {
/*  919 */     this.modifyDate = amodifyDate;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(String amodifyDate) {
/*  923 */     if ((amodifyDate != null) && (!amodifyDate.equals("")))
/*      */     {
/*  925 */       this.modifyDate = this.fDate.getDate(amodifyDate);
/*      */     }
/*      */     else
/*  928 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getmodifyTime()
/*      */   {
/*  933 */     if (this.modifyTime != null) this.modifyTime.equals("");
/*      */ 
/*  937 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setmodifyTime(String amodifyTime) {
/*  941 */     this.modifyTime = amodifyTime;
/*      */   }
/*      */ 
/*      */   public String getgrpName() {
/*  945 */     if (this.grpName != null) this.grpName.equals("");
/*      */ 
/*  949 */     return this.grpName;
/*      */   }
/*      */ 
/*      */   public void setgrpName(String agrpName) {
/*  953 */     this.grpName = agrpName;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPPersonBSchema aLNPPersonBSchema)
/*      */   {
/*  959 */     this.EdorNo = aLNPPersonBSchema.getEdorNo();
/*  960 */     this.serialNo = aLNPPersonBSchema.getserialNo();
/*  961 */     this.customerId = aLNPPersonBSchema.getcustomerId();
/*  962 */     this.agentCode = aLNPPersonBSchema.getagentCode();
/*  963 */     this.customerNo = aLNPPersonBSchema.getcustomerNo();
/*  964 */     this.appellation = aLNPPersonBSchema.getappellation();
/*  965 */     this.name = aLNPPersonBSchema.getname();
/*  966 */     this.sex = aLNPPersonBSchema.getsex();
/*  967 */     this.birthday = this.fDate.getDate(aLNPPersonBSchema.getbirthday());
/*  968 */     this.age = aLNPPersonBSchema.getage();
/*  969 */     this.ageType = aLNPPersonBSchema.getageType();
/*  970 */     this.appntType = aLNPPersonBSchema.getappntType();
/*  971 */     this.iDType = aLNPPersonBSchema.getiDType();
/*  972 */     this.iDNo = aLNPPersonBSchema.getiDNo();
/*  973 */     this.iDValidity = this.fDate.getDate(aLNPPersonBSchema.getiDValidity());
/*  974 */     this.iDPerpetual = aLNPPersonBSchema.getiDPerpetual();
/*  975 */     this.password = aLNPPersonBSchema.getpassword();
/*  976 */     this.nativePlace = aLNPPersonBSchema.getnativePlace();
/*  977 */     this.nationality = aLNPPersonBSchema.getnationality();
/*  978 */     this.rgtAddress = aLNPPersonBSchema.getrgtAddress();
/*  979 */     this.marriage = aLNPPersonBSchema.getmarriage();
/*  980 */     this.marriageDate = this.fDate.getDate(aLNPPersonBSchema.getmarriageDate());
/*  981 */     this.health = aLNPPersonBSchema.gethealth();
/*  982 */     this.stature = aLNPPersonBSchema.getstature();
/*  983 */     this.avoirdupois = aLNPPersonBSchema.getavoirdupois();
/*  984 */     this.degree = aLNPPersonBSchema.getdegree();
/*  985 */     this.creditGrade = aLNPPersonBSchema.getcreditGrade();
/*  986 */     this.bankCode = aLNPPersonBSchema.getbankCode();
/*  987 */     this.bankAccNo = aLNPPersonBSchema.getbankAccNo();
/*  988 */     this.accName = aLNPPersonBSchema.getaccName();
/*  989 */     this.othIDType = aLNPPersonBSchema.getothIDType();
/*  990 */     this.othIDNo = aLNPPersonBSchema.getothIDNo();
/*  991 */     this.iCNo = aLNPPersonBSchema.getiCNo();
/*  992 */     this.grpNo = aLNPPersonBSchema.getgrpNo();
/*  993 */     this.joinCompanyDate = this.fDate.getDate(aLNPPersonBSchema.getjoinCompanyDate());
/*  994 */     this.startWorkDate = this.fDate.getDate(aLNPPersonBSchema.getstartWorkDate());
/*  995 */     this.position = aLNPPersonBSchema.getposition();
/*  996 */     this.salary = aLNPPersonBSchema.getsalary();
/*  997 */     this.occupationType = aLNPPersonBSchema.getoccupationType();
/*  998 */     this.occupationCode = aLNPPersonBSchema.getoccupationCode();
/*  999 */     this.partOccupationType = aLNPPersonBSchema.getpartOccupationType();
/* 1000 */     this.partOccupationCode = aLNPPersonBSchema.getpartOccupationCode();
/* 1001 */     this.workType = aLNPPersonBSchema.getworkType();
/* 1002 */     this.pluralityType = aLNPPersonBSchema.getpluralityType();
/* 1003 */     this.deathDate = this.fDate.getDate(aLNPPersonBSchema.getdeathDate());
/* 1004 */     this.smokeFlag = aLNPPersonBSchema.getsmokeFlag();
/* 1005 */     this.blacklistFlag = aLNPPersonBSchema.getblacklistFlag();
/* 1006 */     this.proterty = aLNPPersonBSchema.getproterty();
/* 1007 */     this.remark = aLNPPersonBSchema.getremark();
/* 1008 */     this.state = aLNPPersonBSchema.getstate();
/* 1009 */     this.vIPValue = aLNPPersonBSchema.getvIPValue();
/* 1010 */     this.operator = aLNPPersonBSchema.getoperator();
/* 1011 */     this.manageCom = aLNPPersonBSchema.getmanageCom();
/* 1012 */     this.makeDate = this.fDate.getDate(aLNPPersonBSchema.getmakeDate());
/* 1013 */     this.makeTime = aLNPPersonBSchema.getmakeTime();
/* 1014 */     this.modifyDate = this.fDate.getDate(aLNPPersonBSchema.getmodifyDate());
/* 1015 */     this.modifyTime = aLNPPersonBSchema.getmodifyTime();
/* 1016 */     this.grpName = aLNPPersonBSchema.getgrpName();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/* 1025 */       if (rs.getString("EdorNo") == null)
/* 1026 */         this.EdorNo = null;
/*      */       else {
/* 1028 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/* 1030 */       if (rs.getString("serialNo") == null)
/* 1031 */         this.serialNo = null;
/*      */       else {
/* 1033 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/* 1035 */       if (rs.getString("customerId") == null)
/* 1036 */         this.customerId = null;
/*      */       else {
/* 1038 */         this.customerId = rs.getString("customerId").trim();
/*      */       }
/* 1040 */       if (rs.getString("agentCode") == null)
/* 1041 */         this.agentCode = null;
/*      */       else {
/* 1043 */         this.agentCode = rs.getString("agentCode").trim();
/*      */       }
/* 1045 */       if (rs.getString("customerNo") == null)
/* 1046 */         this.customerNo = null;
/*      */       else {
/* 1048 */         this.customerNo = rs.getString("customerNo").trim();
/*      */       }
/* 1050 */       if (rs.getString("appellation") == null)
/* 1051 */         this.appellation = null;
/*      */       else {
/* 1053 */         this.appellation = rs.getString("appellation").trim();
/*      */       }
/* 1055 */       if (rs.getString("name") == null)
/* 1056 */         this.name = null;
/*      */       else {
/* 1058 */         this.name = rs.getString("name").trim();
/*      */       }
/* 1060 */       if (rs.getString("sex") == null)
/* 1061 */         this.sex = null;
/*      */       else {
/* 1063 */         this.sex = rs.getString("sex").trim();
/*      */       }
/* 1065 */       this.birthday = rs.getDate("birthday");
/* 1066 */       this.age = rs.getInt("age");
/* 1067 */       if (rs.getString("ageType") == null)
/* 1068 */         this.ageType = null;
/*      */       else {
/* 1070 */         this.ageType = rs.getString("ageType").trim();
/*      */       }
/* 1072 */       if (rs.getString("appntType") == null)
/* 1073 */         this.appntType = null;
/*      */       else {
/* 1075 */         this.appntType = rs.getString("appntType").trim();
/*      */       }
/* 1077 */       if (rs.getString("iDType") == null)
/* 1078 */         this.iDType = null;
/*      */       else {
/* 1080 */         this.iDType = rs.getString("iDType").trim();
/*      */       }
/* 1082 */       if (rs.getString("iDNo") == null)
/* 1083 */         this.iDNo = null;
/*      */       else {
/* 1085 */         this.iDNo = rs.getString("iDNo").trim();
/*      */       }
/* 1087 */       this.iDValidity = rs.getDate("iDValidity");
/* 1088 */       if (rs.getString("iDPerpetual") == null)
/* 1089 */         this.iDPerpetual = null;
/*      */       else {
/* 1091 */         this.iDPerpetual = rs.getString("iDPerpetual").trim();
/*      */       }
/* 1093 */       if (rs.getString("password") == null)
/* 1094 */         this.password = null;
/*      */       else {
/* 1096 */         this.password = rs.getString("password").trim();
/*      */       }
/* 1098 */       if (rs.getString("nativePlace") == null)
/* 1099 */         this.nativePlace = null;
/*      */       else {
/* 1101 */         this.nativePlace = rs.getString("nativePlace").trim();
/*      */       }
/* 1103 */       if (rs.getString("nationality") == null)
/* 1104 */         this.nationality = null;
/*      */       else {
/* 1106 */         this.nationality = rs.getString("nationality").trim();
/*      */       }
/* 1108 */       if (rs.getString("rgtAddress") == null)
/* 1109 */         this.rgtAddress = null;
/*      */       else {
/* 1111 */         this.rgtAddress = rs.getString("rgtAddress").trim();
/*      */       }
/* 1113 */       if (rs.getString("marriage") == null)
/* 1114 */         this.marriage = null;
/*      */       else {
/* 1116 */         this.marriage = rs.getString("marriage").trim();
/*      */       }
/* 1118 */       this.marriageDate = rs.getDate("marriageDate");
/* 1119 */       if (rs.getString("health") == null)
/* 1120 */         this.health = null;
/*      */       else {
/* 1122 */         this.health = rs.getString("health").trim();
/*      */       }
/* 1124 */       this.stature = rs.getDouble("stature");
/* 1125 */       this.avoirdupois = rs.getDouble("avoirdupois");
/* 1126 */       if (rs.getString("degree") == null)
/* 1127 */         this.degree = null;
/*      */       else {
/* 1129 */         this.degree = rs.getString("degree").trim();
/*      */       }
/* 1131 */       if (rs.getString("creditGrade") == null)
/* 1132 */         this.creditGrade = null;
/*      */       else {
/* 1134 */         this.creditGrade = rs.getString("creditGrade").trim();
/*      */       }
/* 1136 */       if (rs.getString("bankCode") == null)
/* 1137 */         this.bankCode = null;
/*      */       else {
/* 1139 */         this.bankCode = rs.getString("bankCode").trim();
/*      */       }
/* 1141 */       if (rs.getString("bankAccNo") == null)
/* 1142 */         this.bankAccNo = null;
/*      */       else {
/* 1144 */         this.bankAccNo = rs.getString("bankAccNo").trim();
/*      */       }
/* 1146 */       if (rs.getString("accName") == null)
/* 1147 */         this.accName = null;
/*      */       else {
/* 1149 */         this.accName = rs.getString("accName").trim();
/*      */       }
/* 1151 */       if (rs.getString("othIDType") == null)
/* 1152 */         this.othIDType = null;
/*      */       else {
/* 1154 */         this.othIDType = rs.getString("othIDType").trim();
/*      */       }
/* 1156 */       if (rs.getString("othIDNo") == null)
/* 1157 */         this.othIDNo = null;
/*      */       else {
/* 1159 */         this.othIDNo = rs.getString("othIDNo").trim();
/*      */       }
/* 1161 */       if (rs.getString("iCNo") == null)
/* 1162 */         this.iCNo = null;
/*      */       else {
/* 1164 */         this.iCNo = rs.getString("iCNo").trim();
/*      */       }
/* 1166 */       if (rs.getString("grpNo") == null)
/* 1167 */         this.grpNo = null;
/*      */       else {
/* 1169 */         this.grpNo = rs.getString("grpNo").trim();
/*      */       }
/* 1171 */       this.joinCompanyDate = rs.getDate("joinCompanyDate");
/* 1172 */       this.startWorkDate = rs.getDate("startWorkDate");
/* 1173 */       if (rs.getString("position") == null)
/* 1174 */         this.position = null;
/*      */       else {
/* 1176 */         this.position = rs.getString("position").trim();
/*      */       }
/* 1178 */       this.salary = rs.getDouble("salary");
/* 1179 */       if (rs.getString("occupationType") == null)
/* 1180 */         this.occupationType = null;
/*      */       else {
/* 1182 */         this.occupationType = rs.getString("occupationType").trim();
/*      */       }
/* 1184 */       if (rs.getString("occupationCode") == null)
/* 1185 */         this.occupationCode = null;
/*      */       else {
/* 1187 */         this.occupationCode = rs.getString("occupationCode").trim();
/*      */       }
/* 1189 */       if (rs.getString("partOccupationType") == null)
/* 1190 */         this.partOccupationType = null;
/*      */       else {
/* 1192 */         this.partOccupationType = rs.getString("partOccupationType").trim();
/*      */       }
/* 1194 */       if (rs.getString("partOccupationCode") == null)
/* 1195 */         this.partOccupationCode = null;
/*      */       else {
/* 1197 */         this.partOccupationCode = rs.getString("partOccupationCode").trim();
/*      */       }
/* 1199 */       if (rs.getString("workType") == null)
/* 1200 */         this.workType = null;
/*      */       else {
/* 1202 */         this.workType = rs.getString("workType").trim();
/*      */       }
/* 1204 */       if (rs.getString("pluralityType") == null)
/* 1205 */         this.pluralityType = null;
/*      */       else {
/* 1207 */         this.pluralityType = rs.getString("pluralityType").trim();
/*      */       }
/* 1209 */       this.deathDate = rs.getDate("deathDate");
/* 1210 */       if (rs.getString("smokeFlag") == null)
/* 1211 */         this.smokeFlag = null;
/*      */       else {
/* 1213 */         this.smokeFlag = rs.getString("smokeFlag").trim();
/*      */       }
/* 1215 */       if (rs.getString("blacklistFlag") == null)
/* 1216 */         this.blacklistFlag = null;
/*      */       else {
/* 1218 */         this.blacklistFlag = rs.getString("blacklistFlag").trim();
/*      */       }
/* 1220 */       if (rs.getString("proterty") == null)
/* 1221 */         this.proterty = null;
/*      */       else {
/* 1223 */         this.proterty = rs.getString("proterty").trim();
/*      */       }
/* 1225 */       if (rs.getString("remark") == null)
/* 1226 */         this.remark = null;
/*      */       else {
/* 1228 */         this.remark = rs.getString("remark").trim();
/*      */       }
/* 1230 */       if (rs.getString("state") == null)
/* 1231 */         this.state = null;
/*      */       else {
/* 1233 */         this.state = rs.getString("state").trim();
/*      */       }
/* 1235 */       if (rs.getString("vIPValue") == null)
/* 1236 */         this.vIPValue = null;
/*      */       else {
/* 1238 */         this.vIPValue = rs.getString("vIPValue").trim();
/*      */       }
/* 1240 */       if (rs.getString("operator") == null)
/* 1241 */         this.operator = null;
/*      */       else {
/* 1243 */         this.operator = rs.getString("operator").trim();
/*      */       }
/* 1245 */       if (rs.getString("manageCom") == null)
/* 1246 */         this.manageCom = null;
/*      */       else {
/* 1248 */         this.manageCom = rs.getString("manageCom").trim();
/*      */       }
/* 1250 */       this.makeDate = rs.getDate("makeDate");
/* 1251 */       if (rs.getString("makeTime") == null)
/* 1252 */         this.makeTime = null;
/*      */       else {
/* 1254 */         this.makeTime = rs.getString("makeTime").trim();
/*      */       }
/* 1256 */       this.modifyDate = rs.getDate("modifyDate");
/* 1257 */       if (rs.getString("modifyTime") == null)
/* 1258 */         this.modifyTime = null;
/*      */       else {
/* 1260 */         this.modifyTime = rs.getString("modifyTime").trim();
/*      */       }
/* 1262 */       if (rs.getString("grpName") == null)
/* 1263 */         this.grpName = null;
/*      */       else {
/* 1265 */         this.grpName = rs.getString("grpName").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1271 */       CError tError = new CError();
/* 1272 */       tError.moduleName = "LNPPersonBSchema";
/* 1273 */       tError.functionName = "setSchema";
/* 1274 */       tError.errorMessage = sqle.toString();
/* 1275 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1277 */       return false;
/*      */     }
/* 1279 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPPersonBSchema getSchema()
/*      */   {
/* 1284 */     LNPPersonBSchema aLNPPersonBSchema = new LNPPersonBSchema();
/* 1285 */     aLNPPersonBSchema.setSchema(this);
/* 1286 */     return aLNPPersonBSchema;
/*      */   }
/*      */ 
/*      */   public LNPPersonBDB getDB()
/*      */   {
/* 1291 */     LNPPersonBDB aDBOper = new LNPPersonBDB();
/* 1292 */     aDBOper.setSchema(this);
/* 1293 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1300 */     String strReturn = "";
/* 1301 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/* 1302 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/* 1303 */       StrTool.cTrim(StrTool.unicodeToGBK(this.customerId)) + "|" + 
/* 1304 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentCode)) + "|" + 
/* 1305 */       StrTool.cTrim(StrTool.unicodeToGBK(this.customerNo)) + "|" + 
/* 1306 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appellation)) + "|" + 
/* 1307 */       StrTool.cTrim(StrTool.unicodeToGBK(this.name)) + "|" + 
/* 1308 */       StrTool.cTrim(StrTool.unicodeToGBK(this.sex)) + "|" + 
/* 1309 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.birthday))) + "|" + 
/* 1310 */       ChgData.chgData(this.age) + "|" + 
/* 1311 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ageType)) + "|" + 
/* 1312 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntType)) + "|" + 
/* 1313 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDType)) + "|" + 
/* 1314 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDNo)) + "|" + 
/* 1315 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.iDValidity))) + "|" + 
/* 1316 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iDPerpetual)) + "|" + 
/* 1317 */       StrTool.cTrim(StrTool.unicodeToGBK(this.password)) + "|" + 
/* 1318 */       StrTool.cTrim(StrTool.unicodeToGBK(this.nativePlace)) + "|" + 
/* 1319 */       StrTool.cTrim(StrTool.unicodeToGBK(this.nationality)) + "|" + 
/* 1320 */       StrTool.cTrim(StrTool.unicodeToGBK(this.rgtAddress)) + "|" + 
/* 1321 */       StrTool.cTrim(StrTool.unicodeToGBK(this.marriage)) + "|" + 
/* 1322 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.marriageDate))) + "|" + 
/* 1323 */       StrTool.cTrim(StrTool.unicodeToGBK(this.health)) + "|" + 
/* 1324 */       ChgData.chgData(this.stature) + "|" + 
/* 1325 */       ChgData.chgData(this.avoirdupois) + "|" + 
/* 1326 */       StrTool.cTrim(StrTool.unicodeToGBK(this.degree)) + "|" + 
/* 1327 */       StrTool.cTrim(StrTool.unicodeToGBK(this.creditGrade)) + "|" + 
/* 1328 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bankCode)) + "|" + 
/* 1329 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bankAccNo)) + "|" + 
/* 1330 */       StrTool.cTrim(StrTool.unicodeToGBK(this.accName)) + "|" + 
/* 1331 */       StrTool.cTrim(StrTool.unicodeToGBK(this.othIDType)) + "|" + 
/* 1332 */       StrTool.cTrim(StrTool.unicodeToGBK(this.othIDNo)) + "|" + 
/* 1333 */       StrTool.cTrim(StrTool.unicodeToGBK(this.iCNo)) + "|" + 
/* 1334 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpNo)) + "|" + 
/* 1335 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.joinCompanyDate))) + "|" + 
/* 1336 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.startWorkDate))) + "|" + 
/* 1337 */       StrTool.cTrim(StrTool.unicodeToGBK(this.position)) + "|" + 
/* 1338 */       ChgData.chgData(this.salary) + "|" + 
/* 1339 */       StrTool.cTrim(StrTool.unicodeToGBK(this.occupationType)) + "|" + 
/* 1340 */       StrTool.cTrim(StrTool.unicodeToGBK(this.occupationCode)) + "|" + 
/* 1341 */       StrTool.cTrim(StrTool.unicodeToGBK(this.partOccupationType)) + "|" + 
/* 1342 */       StrTool.cTrim(StrTool.unicodeToGBK(this.partOccupationCode)) + "|" + 
/* 1343 */       StrTool.cTrim(StrTool.unicodeToGBK(this.workType)) + "|" + 
/* 1344 */       StrTool.cTrim(StrTool.unicodeToGBK(this.pluralityType)) + "|" + 
/* 1345 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.deathDate))) + "|" + 
/* 1346 */       StrTool.cTrim(StrTool.unicodeToGBK(this.smokeFlag)) + "|" + 
/* 1347 */       StrTool.cTrim(StrTool.unicodeToGBK(this.blacklistFlag)) + "|" + 
/* 1348 */       StrTool.cTrim(StrTool.unicodeToGBK(this.proterty)) + "|" + 
/* 1349 */       StrTool.cTrim(StrTool.unicodeToGBK(this.remark)) + "|" + 
/* 1350 */       StrTool.cTrim(StrTool.unicodeToGBK(this.state)) + "|" + 
/* 1351 */       StrTool.cTrim(StrTool.unicodeToGBK(this.vIPValue)) + "|" + 
/* 1352 */       StrTool.cTrim(StrTool.unicodeToGBK(this.operator)) + "|" + 
/* 1353 */       StrTool.cTrim(StrTool.unicodeToGBK(this.manageCom)) + "|" + 
/* 1354 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makeDate))) + "|" + 
/* 1355 */       StrTool.cTrim(StrTool.unicodeToGBK(this.makeTime)) + "|" + 
/* 1356 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifyDate))) + "|" + 
/* 1357 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifyTime)) + "|" + 
/* 1358 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpName));
/* 1359 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1367 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1368 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1369 */       this.customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1370 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1371 */       this.customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1372 */       this.appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1373 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1374 */       this.sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1375 */       this.birthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/* 1376 */       this.age = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/* 1377 */       this.ageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1378 */       this.appntType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1379 */       this.iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1380 */       this.iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1381 */       this.iDValidity = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/* 1382 */       this.iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1383 */       this.password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1384 */       this.nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1385 */       this.nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1386 */       this.rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 1387 */       this.marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1388 */       this.marriageDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/* 1389 */       this.health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 1390 */       this.stature = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 24, "|"))).doubleValue();
/* 1391 */       this.avoirdupois = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 25, "|"))).doubleValue();
/* 1392 */       this.degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1393 */       this.creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1394 */       this.bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1395 */       this.bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 1396 */       this.accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1397 */       this.othIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/* 1398 */       this.othIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 1399 */       this.iCNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 1400 */       this.grpNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/* 1401 */       this.joinCompanyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|"));
/* 1402 */       this.startWorkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|"));
/* 1403 */       this.position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 1404 */       this.salary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|"))).doubleValue();
/* 1405 */       this.occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/* 1406 */       this.occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1407 */       this.partOccupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1408 */       this.partOccupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1409 */       this.workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 1410 */       this.pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1411 */       this.deathDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|"));
/* 1412 */       this.smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 1413 */       this.blacklistFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 1414 */       this.proterty = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 1415 */       this.remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/* 1416 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
/* 1417 */       this.vIPValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
/* 1418 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
/* 1419 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
/* 1420 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|"));
/* 1421 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
/* 1422 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|"));
/* 1423 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, "|");
/* 1424 */       this.grpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 58, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1429 */       CError tError = new CError();
/* 1430 */       tError.moduleName = "LNPPersonBSchema";
/* 1431 */       tError.functionName = "decode";
/* 1432 */       tError.errorMessage = ex.toString();
/* 1433 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1435 */       return false;
/*      */     }
/* 1437 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1443 */     String strReturn = "";
/* 1444 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 1446 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/* 1448 */     if (FCode.equals("serialNo"))
/*      */     {
/* 1450 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/* 1452 */     if (FCode.equals("customerId"))
/*      */     {
/* 1454 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerId));
/*      */     }
/* 1456 */     if (FCode.equals("agentCode"))
/*      */     {
/* 1458 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/* 1460 */     if (FCode.equals("customerNo"))
/*      */     {
/* 1462 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerNo));
/*      */     }
/* 1464 */     if (FCode.equals("appellation"))
/*      */     {
/* 1466 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appellation));
/*      */     }
/* 1468 */     if (FCode.equals("name"))
/*      */     {
/* 1470 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/* 1472 */     if (FCode.equals("sex"))
/*      */     {
/* 1474 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sex));
/*      */     }
/* 1476 */     if (FCode.equals("birthday"))
/*      */     {
/* 1478 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getbirthday()));
/*      */     }
/* 1480 */     if (FCode.equals("age"))
/*      */     {
/* 1482 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.age));
/*      */     }
/* 1484 */     if (FCode.equals("ageType"))
/*      */     {
/* 1486 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ageType));
/*      */     }
/* 1488 */     if (FCode.equals("appntType"))
/*      */     {
/* 1490 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntType));
/*      */     }
/* 1492 */     if (FCode.equals("iDType"))
/*      */     {
/* 1494 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDType));
/*      */     }
/* 1496 */     if (FCode.equals("iDNo"))
/*      */     {
/* 1498 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDNo));
/*      */     }
/* 1500 */     if (FCode.equals("iDValidity"))
/*      */     {
/* 1502 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
/*      */     }
/* 1504 */     if (FCode.equals("iDPerpetual"))
/*      */     {
/* 1506 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDPerpetual));
/*      */     }
/* 1508 */     if (FCode.equals("password"))
/*      */     {
/* 1510 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.password));
/*      */     }
/* 1512 */     if (FCode.equals("nativePlace"))
/*      */     {
/* 1514 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nativePlace));
/*      */     }
/* 1516 */     if (FCode.equals("nationality"))
/*      */     {
/* 1518 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nationality));
/*      */     }
/* 1520 */     if (FCode.equals("rgtAddress"))
/*      */     {
/* 1522 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rgtAddress));
/*      */     }
/* 1524 */     if (FCode.equals("marriage"))
/*      */     {
/* 1526 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.marriage));
/*      */     }
/* 1528 */     if (FCode.equals("marriageDate"))
/*      */     {
/* 1530 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
/*      */     }
/* 1532 */     if (FCode.equals("health"))
/*      */     {
/* 1534 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.health));
/*      */     }
/* 1536 */     if (FCode.equals("stature"))
/*      */     {
/* 1538 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stature));
/*      */     }
/* 1540 */     if (FCode.equals("avoirdupois"))
/*      */     {
/* 1542 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.avoirdupois));
/*      */     }
/* 1544 */     if (FCode.equals("degree"))
/*      */     {
/* 1546 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.degree));
/*      */     }
/* 1548 */     if (FCode.equals("creditGrade"))
/*      */     {
/* 1550 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.creditGrade));
/*      */     }
/* 1552 */     if (FCode.equals("bankCode"))
/*      */     {
/* 1554 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankCode));
/*      */     }
/* 1556 */     if (FCode.equals("bankAccNo"))
/*      */     {
/* 1558 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankAccNo));
/*      */     }
/* 1560 */     if (FCode.equals("accName"))
/*      */     {
/* 1562 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.accName));
/*      */     }
/* 1564 */     if (FCode.equals("othIDType"))
/*      */     {
/* 1566 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.othIDType));
/*      */     }
/* 1568 */     if (FCode.equals("othIDNo"))
/*      */     {
/* 1570 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.othIDNo));
/*      */     }
/* 1572 */     if (FCode.equals("iCNo"))
/*      */     {
/* 1574 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iCNo));
/*      */     }
/* 1576 */     if (FCode.equals("grpNo"))
/*      */     {
/* 1578 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpNo));
/*      */     }
/* 1580 */     if (FCode.equals("joinCompanyDate"))
/*      */     {
/* 1582 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
/*      */     }
/* 1584 */     if (FCode.equals("startWorkDate"))
/*      */     {
/* 1586 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
/*      */     }
/* 1588 */     if (FCode.equals("position"))
/*      */     {
/* 1590 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.position));
/*      */     }
/* 1592 */     if (FCode.equals("salary"))
/*      */     {
/* 1594 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.salary));
/*      */     }
/* 1596 */     if (FCode.equals("occupationType"))
/*      */     {
/* 1598 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationType));
/*      */     }
/* 1600 */     if (FCode.equals("occupationCode"))
/*      */     {
/* 1602 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationCode));
/*      */     }
/* 1604 */     if (FCode.equals("partOccupationType"))
/*      */     {
/* 1606 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.partOccupationType));
/*      */     }
/* 1608 */     if (FCode.equals("partOccupationCode"))
/*      */     {
/* 1610 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.partOccupationCode));
/*      */     }
/* 1612 */     if (FCode.equals("workType"))
/*      */     {
/* 1614 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.workType));
/*      */     }
/* 1616 */     if (FCode.equals("pluralityType"))
/*      */     {
/* 1618 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pluralityType));
/*      */     }
/* 1620 */     if (FCode.equals("deathDate"))
/*      */     {
/* 1622 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getdeathDate()));
/*      */     }
/* 1624 */     if (FCode.equals("smokeFlag"))
/*      */     {
/* 1626 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.smokeFlag));
/*      */     }
/* 1628 */     if (FCode.equals("blacklistFlag"))
/*      */     {
/* 1630 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.blacklistFlag));
/*      */     }
/* 1632 */     if (FCode.equals("proterty"))
/*      */     {
/* 1634 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proterty));
/*      */     }
/* 1636 */     if (FCode.equals("remark"))
/*      */     {
/* 1638 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark));
/*      */     }
/* 1640 */     if (FCode.equals("state"))
/*      */     {
/* 1642 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/* 1644 */     if (FCode.equals("vIPValue"))
/*      */     {
/* 1646 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vIPValue));
/*      */     }
/* 1648 */     if (FCode.equals("operator"))
/*      */     {
/* 1650 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1652 */     if (FCode.equals("manageCom"))
/*      */     {
/* 1654 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 1656 */     if (FCode.equals("makeDate"))
/*      */     {
/* 1658 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*      */     }
/* 1660 */     if (FCode.equals("makeTime"))
/*      */     {
/* 1662 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1664 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 1666 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*      */     }
/* 1668 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 1670 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1672 */     if (FCode.equals("grpName"))
/*      */     {
/* 1674 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpName));
/*      */     }
/* 1676 */     if (strReturn.equals(""))
/*      */     {
/* 1678 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1681 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1688 */     String strFieldValue = "";
/* 1689 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1691 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/* 1692 */       break;
/*      */     case 1:
/* 1694 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/* 1695 */       break;
/*      */     case 2:
/* 1697 */       strFieldValue = StrTool.GBKToUnicode(this.customerId);
/* 1698 */       break;
/*      */     case 3:
/* 1700 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/* 1701 */       break;
/*      */     case 4:
/* 1703 */       strFieldValue = StrTool.GBKToUnicode(this.customerNo);
/* 1704 */       break;
/*      */     case 5:
/* 1706 */       strFieldValue = StrTool.GBKToUnicode(this.appellation);
/* 1707 */       break;
/*      */     case 6:
/* 1709 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/* 1710 */       break;
/*      */     case 7:
/* 1712 */       strFieldValue = StrTool.GBKToUnicode(this.sex);
/* 1713 */       break;
/*      */     case 8:
/* 1715 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getbirthday()));
/* 1716 */       break;
/*      */     case 9:
/* 1718 */       strFieldValue = String.valueOf(this.age);
/* 1719 */       break;
/*      */     case 10:
/* 1721 */       strFieldValue = StrTool.GBKToUnicode(this.ageType);
/* 1722 */       break;
/*      */     case 11:
/* 1724 */       strFieldValue = StrTool.GBKToUnicode(this.appntType);
/* 1725 */       break;
/*      */     case 12:
/* 1727 */       strFieldValue = StrTool.GBKToUnicode(this.iDType);
/* 1728 */       break;
/*      */     case 13:
/* 1730 */       strFieldValue = StrTool.GBKToUnicode(this.iDNo);
/* 1731 */       break;
/*      */     case 14:
/* 1733 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
/* 1734 */       break;
/*      */     case 15:
/* 1736 */       strFieldValue = StrTool.GBKToUnicode(this.iDPerpetual);
/* 1737 */       break;
/*      */     case 16:
/* 1739 */       strFieldValue = StrTool.GBKToUnicode(this.password);
/* 1740 */       break;
/*      */     case 17:
/* 1742 */       strFieldValue = StrTool.GBKToUnicode(this.nativePlace);
/* 1743 */       break;
/*      */     case 18:
/* 1745 */       strFieldValue = StrTool.GBKToUnicode(this.nationality);
/* 1746 */       break;
/*      */     case 19:
/* 1748 */       strFieldValue = StrTool.GBKToUnicode(this.rgtAddress);
/* 1749 */       break;
/*      */     case 20:
/* 1751 */       strFieldValue = StrTool.GBKToUnicode(this.marriage);
/* 1752 */       break;
/*      */     case 21:
/* 1754 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
/* 1755 */       break;
/*      */     case 22:
/* 1757 */       strFieldValue = StrTool.GBKToUnicode(this.health);
/* 1758 */       break;
/*      */     case 23:
/* 1760 */       strFieldValue = String.valueOf(this.stature);
/* 1761 */       break;
/*      */     case 24:
/* 1763 */       strFieldValue = String.valueOf(this.avoirdupois);
/* 1764 */       break;
/*      */     case 25:
/* 1766 */       strFieldValue = StrTool.GBKToUnicode(this.degree);
/* 1767 */       break;
/*      */     case 26:
/* 1769 */       strFieldValue = StrTool.GBKToUnicode(this.creditGrade);
/* 1770 */       break;
/*      */     case 27:
/* 1772 */       strFieldValue = StrTool.GBKToUnicode(this.bankCode);
/* 1773 */       break;
/*      */     case 28:
/* 1775 */       strFieldValue = StrTool.GBKToUnicode(this.bankAccNo);
/* 1776 */       break;
/*      */     case 29:
/* 1778 */       strFieldValue = StrTool.GBKToUnicode(this.accName);
/* 1779 */       break;
/*      */     case 30:
/* 1781 */       strFieldValue = StrTool.GBKToUnicode(this.othIDType);
/* 1782 */       break;
/*      */     case 31:
/* 1784 */       strFieldValue = StrTool.GBKToUnicode(this.othIDNo);
/* 1785 */       break;
/*      */     case 32:
/* 1787 */       strFieldValue = StrTool.GBKToUnicode(this.iCNo);
/* 1788 */       break;
/*      */     case 33:
/* 1790 */       strFieldValue = StrTool.GBKToUnicode(this.grpNo);
/* 1791 */       break;
/*      */     case 34:
/* 1793 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
/* 1794 */       break;
/*      */     case 35:
/* 1796 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
/* 1797 */       break;
/*      */     case 36:
/* 1799 */       strFieldValue = StrTool.GBKToUnicode(this.position);
/* 1800 */       break;
/*      */     case 37:
/* 1802 */       strFieldValue = String.valueOf(this.salary);
/* 1803 */       break;
/*      */     case 38:
/* 1805 */       strFieldValue = StrTool.GBKToUnicode(this.occupationType);
/* 1806 */       break;
/*      */     case 39:
/* 1808 */       strFieldValue = StrTool.GBKToUnicode(this.occupationCode);
/* 1809 */       break;
/*      */     case 40:
/* 1811 */       strFieldValue = StrTool.GBKToUnicode(this.partOccupationType);
/* 1812 */       break;
/*      */     case 41:
/* 1814 */       strFieldValue = StrTool.GBKToUnicode(this.partOccupationCode);
/* 1815 */       break;
/*      */     case 42:
/* 1817 */       strFieldValue = StrTool.GBKToUnicode(this.workType);
/* 1818 */       break;
/*      */     case 43:
/* 1820 */       strFieldValue = StrTool.GBKToUnicode(this.pluralityType);
/* 1821 */       break;
/*      */     case 44:
/* 1823 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getdeathDate()));
/* 1824 */       break;
/*      */     case 45:
/* 1826 */       strFieldValue = StrTool.GBKToUnicode(this.smokeFlag);
/* 1827 */       break;
/*      */     case 46:
/* 1829 */       strFieldValue = StrTool.GBKToUnicode(this.blacklistFlag);
/* 1830 */       break;
/*      */     case 47:
/* 1832 */       strFieldValue = StrTool.GBKToUnicode(this.proterty);
/* 1833 */       break;
/*      */     case 48:
/* 1835 */       strFieldValue = StrTool.GBKToUnicode(this.remark);
/* 1836 */       break;
/*      */     case 49:
/* 1838 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 1839 */       break;
/*      */     case 50:
/* 1841 */       strFieldValue = StrTool.GBKToUnicode(this.vIPValue);
/* 1842 */       break;
/*      */     case 51:
/* 1844 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1845 */       break;
/*      */     case 52:
/* 1847 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1848 */       break;
/*      */     case 53:
/* 1850 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/* 1851 */       break;
/*      */     case 54:
/* 1853 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1854 */       break;
/*      */     case 55:
/* 1856 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/* 1857 */       break;
/*      */     case 56:
/* 1859 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1860 */       break;
/*      */     case 57:
/* 1862 */       strFieldValue = StrTool.GBKToUnicode(this.grpName);
/* 1863 */       break;
/*      */     default:
/* 1865 */       strFieldValue = "";
/*      */     }
/* 1867 */     if (strFieldValue.equals("")) {
/* 1868 */       strFieldValue = "null";
/*      */     }
/* 1870 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1876 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1877 */       return false;
/*      */     }
/* 1879 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 1881 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1883 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1886 */         this.EdorNo = null;
/*      */     }
/* 1888 */     if (FCode.equals("serialNo"))
/*      */     {
/* 1890 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1892 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/* 1895 */         this.serialNo = null;
/*      */     }
/* 1897 */     if (FCode.equals("customerId"))
/*      */     {
/* 1899 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1901 */         this.customerId = FValue.trim();
/*      */       }
/*      */       else
/* 1904 */         this.customerId = null;
/*      */     }
/* 1906 */     if (FCode.equals("agentCode"))
/*      */     {
/* 1908 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1910 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/* 1913 */         this.agentCode = null;
/*      */     }
/* 1915 */     if (FCode.equals("customerNo"))
/*      */     {
/* 1917 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1919 */         this.customerNo = FValue.trim();
/*      */       }
/*      */       else
/* 1922 */         this.customerNo = null;
/*      */     }
/* 1924 */     if (FCode.equals("appellation"))
/*      */     {
/* 1926 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1928 */         this.appellation = FValue.trim();
/*      */       }
/*      */       else
/* 1931 */         this.appellation = null;
/*      */     }
/* 1933 */     if (FCode.equals("name"))
/*      */     {
/* 1935 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1937 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/* 1940 */         this.name = null;
/*      */     }
/* 1942 */     if (FCode.equals("sex"))
/*      */     {
/* 1944 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1946 */         this.sex = FValue.trim();
/*      */       }
/*      */       else
/* 1949 */         this.sex = null;
/*      */     }
/* 1951 */     if (FCode.equals("birthday"))
/*      */     {
/* 1953 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1955 */         this.birthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1958 */         this.birthday = null;
/*      */     }
/* 1960 */     if (FCode.equals("age"))
/*      */     {
/* 1962 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1964 */         Integer tInteger = new Integer(FValue);
/* 1965 */         int i = tInteger.intValue();
/* 1966 */         this.age = i;
/*      */       }
/*      */     }
/* 1969 */     if (FCode.equals("ageType"))
/*      */     {
/* 1971 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1973 */         this.ageType = FValue.trim();
/*      */       }
/*      */       else
/* 1976 */         this.ageType = null;
/*      */     }
/* 1978 */     if (FCode.equals("appntType"))
/*      */     {
/* 1980 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1982 */         this.appntType = FValue.trim();
/*      */       }
/*      */       else
/* 1985 */         this.appntType = null;
/*      */     }
/* 1987 */     if (FCode.equals("iDType"))
/*      */     {
/* 1989 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1991 */         this.iDType = FValue.trim();
/*      */       }
/*      */       else
/* 1994 */         this.iDType = null;
/*      */     }
/* 1996 */     if (FCode.equals("iDNo"))
/*      */     {
/* 1998 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2000 */         this.iDNo = FValue.trim();
/*      */       }
/*      */       else
/* 2003 */         this.iDNo = null;
/*      */     }
/* 2005 */     if (FCode.equals("iDValidity"))
/*      */     {
/* 2007 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2009 */         this.iDValidity = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2012 */         this.iDValidity = null;
/*      */     }
/* 2014 */     if (FCode.equals("iDPerpetual"))
/*      */     {
/* 2016 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2018 */         this.iDPerpetual = FValue.trim();
/*      */       }
/*      */       else
/* 2021 */         this.iDPerpetual = null;
/*      */     }
/* 2023 */     if (FCode.equals("password"))
/*      */     {
/* 2025 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2027 */         this.password = FValue.trim();
/*      */       }
/*      */       else
/* 2030 */         this.password = null;
/*      */     }
/* 2032 */     if (FCode.equals("nativePlace"))
/*      */     {
/* 2034 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2036 */         this.nativePlace = FValue.trim();
/*      */       }
/*      */       else
/* 2039 */         this.nativePlace = null;
/*      */     }
/* 2041 */     if (FCode.equals("nationality"))
/*      */     {
/* 2043 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2045 */         this.nationality = FValue.trim();
/*      */       }
/*      */       else
/* 2048 */         this.nationality = null;
/*      */     }
/* 2050 */     if (FCode.equals("rgtAddress"))
/*      */     {
/* 2052 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2054 */         this.rgtAddress = FValue.trim();
/*      */       }
/*      */       else
/* 2057 */         this.rgtAddress = null;
/*      */     }
/* 2059 */     if (FCode.equals("marriage"))
/*      */     {
/* 2061 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2063 */         this.marriage = FValue.trim();
/*      */       }
/*      */       else
/* 2066 */         this.marriage = null;
/*      */     }
/* 2068 */     if (FCode.equals("marriageDate"))
/*      */     {
/* 2070 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2072 */         this.marriageDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2075 */         this.marriageDate = null;
/*      */     }
/* 2077 */     if (FCode.equals("health"))
/*      */     {
/* 2079 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2081 */         this.health = FValue.trim();
/*      */       }
/*      */       else
/* 2084 */         this.health = null;
/*      */     }
/* 2086 */     if (FCode.equals("stature"))
/*      */     {
/* 2088 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2090 */         Double tDouble = new Double(FValue);
/* 2091 */         double d = tDouble.doubleValue();
/* 2092 */         this.stature = d;
/*      */       }
/*      */     }
/* 2095 */     if (FCode.equals("avoirdupois"))
/*      */     {
/* 2097 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2099 */         Double tDouble = new Double(FValue);
/* 2100 */         double d = tDouble.doubleValue();
/* 2101 */         this.avoirdupois = d;
/*      */       }
/*      */     }
/* 2104 */     if (FCode.equals("degree"))
/*      */     {
/* 2106 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2108 */         this.degree = FValue.trim();
/*      */       }
/*      */       else
/* 2111 */         this.degree = null;
/*      */     }
/* 2113 */     if (FCode.equals("creditGrade"))
/*      */     {
/* 2115 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2117 */         this.creditGrade = FValue.trim();
/*      */       }
/*      */       else
/* 2120 */         this.creditGrade = null;
/*      */     }
/* 2122 */     if (FCode.equals("bankCode"))
/*      */     {
/* 2124 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2126 */         this.bankCode = FValue.trim();
/*      */       }
/*      */       else
/* 2129 */         this.bankCode = null;
/*      */     }
/* 2131 */     if (FCode.equals("bankAccNo"))
/*      */     {
/* 2133 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2135 */         this.bankAccNo = FValue.trim();
/*      */       }
/*      */       else
/* 2138 */         this.bankAccNo = null;
/*      */     }
/* 2140 */     if (FCode.equals("accName"))
/*      */     {
/* 2142 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2144 */         this.accName = FValue.trim();
/*      */       }
/*      */       else
/* 2147 */         this.accName = null;
/*      */     }
/* 2149 */     if (FCode.equals("othIDType"))
/*      */     {
/* 2151 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2153 */         this.othIDType = FValue.trim();
/*      */       }
/*      */       else
/* 2156 */         this.othIDType = null;
/*      */     }
/* 2158 */     if (FCode.equals("othIDNo"))
/*      */     {
/* 2160 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2162 */         this.othIDNo = FValue.trim();
/*      */       }
/*      */       else
/* 2165 */         this.othIDNo = null;
/*      */     }
/* 2167 */     if (FCode.equals("iCNo"))
/*      */     {
/* 2169 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2171 */         this.iCNo = FValue.trim();
/*      */       }
/*      */       else
/* 2174 */         this.iCNo = null;
/*      */     }
/* 2176 */     if (FCode.equals("grpNo"))
/*      */     {
/* 2178 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2180 */         this.grpNo = FValue.trim();
/*      */       }
/*      */       else
/* 2183 */         this.grpNo = null;
/*      */     }
/* 2185 */     if (FCode.equals("joinCompanyDate"))
/*      */     {
/* 2187 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2189 */         this.joinCompanyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2192 */         this.joinCompanyDate = null;
/*      */     }
/* 2194 */     if (FCode.equals("startWorkDate"))
/*      */     {
/* 2196 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2198 */         this.startWorkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2201 */         this.startWorkDate = null;
/*      */     }
/* 2203 */     if (FCode.equals("position"))
/*      */     {
/* 2205 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2207 */         this.position = FValue.trim();
/*      */       }
/*      */       else
/* 2210 */         this.position = null;
/*      */     }
/* 2212 */     if (FCode.equals("salary"))
/*      */     {
/* 2214 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2216 */         Double tDouble = new Double(FValue);
/* 2217 */         double d = tDouble.doubleValue();
/* 2218 */         this.salary = d;
/*      */       }
/*      */     }
/* 2221 */     if (FCode.equals("occupationType"))
/*      */     {
/* 2223 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2225 */         this.occupationType = FValue.trim();
/*      */       }
/*      */       else
/* 2228 */         this.occupationType = null;
/*      */     }
/* 2230 */     if (FCode.equals("occupationCode"))
/*      */     {
/* 2232 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2234 */         this.occupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 2237 */         this.occupationCode = null;
/*      */     }
/* 2239 */     if (FCode.equals("partOccupationType"))
/*      */     {
/* 2241 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2243 */         this.partOccupationType = FValue.trim();
/*      */       }
/*      */       else
/* 2246 */         this.partOccupationType = null;
/*      */     }
/* 2248 */     if (FCode.equals("partOccupationCode"))
/*      */     {
/* 2250 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2252 */         this.partOccupationCode = FValue.trim();
/*      */       }
/*      */       else
/* 2255 */         this.partOccupationCode = null;
/*      */     }
/* 2257 */     if (FCode.equals("workType"))
/*      */     {
/* 2259 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2261 */         this.workType = FValue.trim();
/*      */       }
/*      */       else
/* 2264 */         this.workType = null;
/*      */     }
/* 2266 */     if (FCode.equals("pluralityType"))
/*      */     {
/* 2268 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2270 */         this.pluralityType = FValue.trim();
/*      */       }
/*      */       else
/* 2273 */         this.pluralityType = null;
/*      */     }
/* 2275 */     if (FCode.equals("deathDate"))
/*      */     {
/* 2277 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2279 */         this.deathDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2282 */         this.deathDate = null;
/*      */     }
/* 2284 */     if (FCode.equals("smokeFlag"))
/*      */     {
/* 2286 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2288 */         this.smokeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2291 */         this.smokeFlag = null;
/*      */     }
/* 2293 */     if (FCode.equals("blacklistFlag"))
/*      */     {
/* 2295 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2297 */         this.blacklistFlag = FValue.trim();
/*      */       }
/*      */       else
/* 2300 */         this.blacklistFlag = null;
/*      */     }
/* 2302 */     if (FCode.equals("proterty"))
/*      */     {
/* 2304 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2306 */         this.proterty = FValue.trim();
/*      */       }
/*      */       else
/* 2309 */         this.proterty = null;
/*      */     }
/* 2311 */     if (FCode.equals("remark"))
/*      */     {
/* 2313 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2315 */         this.remark = FValue.trim();
/*      */       }
/*      */       else
/* 2318 */         this.remark = null;
/*      */     }
/* 2320 */     if (FCode.equals("state"))
/*      */     {
/* 2322 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2324 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 2327 */         this.state = null;
/*      */     }
/* 2329 */     if (FCode.equals("vIPValue"))
/*      */     {
/* 2331 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2333 */         this.vIPValue = FValue.trim();
/*      */       }
/*      */       else
/* 2336 */         this.vIPValue = null;
/*      */     }
/* 2338 */     if (FCode.equals("operator"))
/*      */     {
/* 2340 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2342 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 2345 */         this.operator = null;
/*      */     }
/* 2347 */     if (FCode.equals("manageCom"))
/*      */     {
/* 2349 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2351 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 2354 */         this.manageCom = null;
/*      */     }
/* 2356 */     if (FCode.equals("makeDate"))
/*      */     {
/* 2358 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2360 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2363 */         this.makeDate = null;
/*      */     }
/* 2365 */     if (FCode.equals("makeTime"))
/*      */     {
/* 2367 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2369 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 2372 */         this.makeTime = null;
/*      */     }
/* 2374 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 2376 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2378 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2381 */         this.modifyDate = null;
/*      */     }
/* 2383 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 2385 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2387 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 2390 */         this.modifyTime = null;
/*      */     }
/* 2392 */     if (FCode.equals("grpName"))
/*      */     {
/* 2394 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2396 */         this.grpName = FValue.trim();
/*      */       }
/*      */       else
/* 2399 */         this.grpName = null;
/*      */     }
/* 2401 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 2406 */     if (this == otherObject) return true;
/* 2407 */     if (otherObject == null) return false;
/* 2408 */     if (getClass() != otherObject.getClass()) return false;
/* 2409 */     LNPPersonBSchema other = (LNPPersonBSchema)otherObject;
/* 2410 */     return 
/* 2411 */       (this.EdorNo.equals(other.getEdorNo())) && 
/* 2412 */       (this.serialNo.equals(other.getserialNo())) && 
/* 2413 */       (this.customerId.equals(other.getcustomerId())) && 
/* 2414 */       (this.agentCode.equals(other.getagentCode())) && 
/* 2415 */       (this.customerNo.equals(other.getcustomerNo())) && 
/* 2416 */       (this.appellation.equals(other.getappellation())) && 
/* 2417 */       (this.name.equals(other.getname())) && 
/* 2418 */       (this.sex.equals(other.getsex())) && 
/* 2419 */       (this.fDate.getString(this.birthday).equals(other.getbirthday())) && 
/* 2420 */       (this.age == other.getage()) && 
/* 2421 */       (this.ageType.equals(other.getageType())) && 
/* 2422 */       (this.appntType.equals(other.getappntType())) && 
/* 2423 */       (this.iDType.equals(other.getiDType())) && 
/* 2424 */       (this.iDNo.equals(other.getiDNo())) && 
/* 2425 */       (this.fDate.getString(this.iDValidity).equals(other.getiDValidity())) && 
/* 2426 */       (this.iDPerpetual.equals(other.getiDPerpetual())) && 
/* 2427 */       (this.password.equals(other.getpassword())) && 
/* 2428 */       (this.nativePlace.equals(other.getnativePlace())) && 
/* 2429 */       (this.nationality.equals(other.getnationality())) && 
/* 2430 */       (this.rgtAddress.equals(other.getrgtAddress())) && 
/* 2431 */       (this.marriage.equals(other.getmarriage())) && 
/* 2432 */       (this.fDate.getString(this.marriageDate).equals(other.getmarriageDate())) && 
/* 2433 */       (this.health.equals(other.gethealth())) && 
/* 2434 */       (this.stature == other.getstature()) && 
/* 2435 */       (this.avoirdupois == other.getavoirdupois()) && 
/* 2436 */       (this.degree.equals(other.getdegree())) && 
/* 2437 */       (this.creditGrade.equals(other.getcreditGrade())) && 
/* 2438 */       (this.bankCode.equals(other.getbankCode())) && 
/* 2439 */       (this.bankAccNo.equals(other.getbankAccNo())) && 
/* 2440 */       (this.accName.equals(other.getaccName())) && 
/* 2441 */       (this.othIDType.equals(other.getothIDType())) && 
/* 2442 */       (this.othIDNo.equals(other.getothIDNo())) && 
/* 2443 */       (this.iCNo.equals(other.getiCNo())) && 
/* 2444 */       (this.grpNo.equals(other.getgrpNo())) && 
/* 2445 */       (this.fDate.getString(this.joinCompanyDate).equals(other.getjoinCompanyDate())) && 
/* 2446 */       (this.fDate.getString(this.startWorkDate).equals(other.getstartWorkDate())) && 
/* 2447 */       (this.position.equals(other.getposition())) && 
/* 2448 */       (this.salary == other.getsalary()) && 
/* 2449 */       (this.occupationType.equals(other.getoccupationType())) && 
/* 2450 */       (this.occupationCode.equals(other.getoccupationCode())) && 
/* 2451 */       (this.partOccupationType.equals(other.getpartOccupationType())) && 
/* 2452 */       (this.partOccupationCode.equals(other.getpartOccupationCode())) && 
/* 2453 */       (this.workType.equals(other.getworkType())) && 
/* 2454 */       (this.pluralityType.equals(other.getpluralityType())) && 
/* 2455 */       (this.fDate.getString(this.deathDate).equals(other.getdeathDate())) && 
/* 2456 */       (this.smokeFlag.equals(other.getsmokeFlag())) && 
/* 2457 */       (this.blacklistFlag.equals(other.getblacklistFlag())) && 
/* 2458 */       (this.proterty.equals(other.getproterty())) && 
/* 2459 */       (this.remark.equals(other.getremark())) && 
/* 2460 */       (this.state.equals(other.getstate())) && 
/* 2461 */       (this.vIPValue.equals(other.getvIPValue())) && 
/* 2462 */       (this.operator.equals(other.getoperator())) && 
/* 2463 */       (this.manageCom.equals(other.getmanageCom())) && 
/* 2464 */       (this.fDate.getString(this.makeDate).equals(other.getmakeDate())) && 
/* 2465 */       (this.makeTime.equals(other.getmakeTime())) && 
/* 2466 */       (this.fDate.getString(this.modifyDate).equals(other.getmodifyDate())) && 
/* 2467 */       (this.modifyTime.equals(other.getmodifyTime())) && 
/* 2468 */       (this.grpName.equals(other.getgrpName()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2474 */     return 58;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2480 */     if (strFieldName.equals("EdorNo")) {
/* 2481 */       return 0;
/*      */     }
/* 2483 */     if (strFieldName.equals("serialNo")) {
/* 2484 */       return 1;
/*      */     }
/* 2486 */     if (strFieldName.equals("customerId")) {
/* 2487 */       return 2;
/*      */     }
/* 2489 */     if (strFieldName.equals("agentCode")) {
/* 2490 */       return 3;
/*      */     }
/* 2492 */     if (strFieldName.equals("customerNo")) {
/* 2493 */       return 4;
/*      */     }
/* 2495 */     if (strFieldName.equals("appellation")) {
/* 2496 */       return 5;
/*      */     }
/* 2498 */     if (strFieldName.equals("name")) {
/* 2499 */       return 6;
/*      */     }
/* 2501 */     if (strFieldName.equals("sex")) {
/* 2502 */       return 7;
/*      */     }
/* 2504 */     if (strFieldName.equals("birthday")) {
/* 2505 */       return 8;
/*      */     }
/* 2507 */     if (strFieldName.equals("age")) {
/* 2508 */       return 9;
/*      */     }
/* 2510 */     if (strFieldName.equals("ageType")) {
/* 2511 */       return 10;
/*      */     }
/* 2513 */     if (strFieldName.equals("appntType")) {
/* 2514 */       return 11;
/*      */     }
/* 2516 */     if (strFieldName.equals("iDType")) {
/* 2517 */       return 12;
/*      */     }
/* 2519 */     if (strFieldName.equals("iDNo")) {
/* 2520 */       return 13;
/*      */     }
/* 2522 */     if (strFieldName.equals("iDValidity")) {
/* 2523 */       return 14;
/*      */     }
/* 2525 */     if (strFieldName.equals("iDPerpetual")) {
/* 2526 */       return 15;
/*      */     }
/* 2528 */     if (strFieldName.equals("password")) {
/* 2529 */       return 16;
/*      */     }
/* 2531 */     if (strFieldName.equals("nativePlace")) {
/* 2532 */       return 17;
/*      */     }
/* 2534 */     if (strFieldName.equals("nationality")) {
/* 2535 */       return 18;
/*      */     }
/* 2537 */     if (strFieldName.equals("rgtAddress")) {
/* 2538 */       return 19;
/*      */     }
/* 2540 */     if (strFieldName.equals("marriage")) {
/* 2541 */       return 20;
/*      */     }
/* 2543 */     if (strFieldName.equals("marriageDate")) {
/* 2544 */       return 21;
/*      */     }
/* 2546 */     if (strFieldName.equals("health")) {
/* 2547 */       return 22;
/*      */     }
/* 2549 */     if (strFieldName.equals("stature")) {
/* 2550 */       return 23;
/*      */     }
/* 2552 */     if (strFieldName.equals("avoirdupois")) {
/* 2553 */       return 24;
/*      */     }
/* 2555 */     if (strFieldName.equals("degree")) {
/* 2556 */       return 25;
/*      */     }
/* 2558 */     if (strFieldName.equals("creditGrade")) {
/* 2559 */       return 26;
/*      */     }
/* 2561 */     if (strFieldName.equals("bankCode")) {
/* 2562 */       return 27;
/*      */     }
/* 2564 */     if (strFieldName.equals("bankAccNo")) {
/* 2565 */       return 28;
/*      */     }
/* 2567 */     if (strFieldName.equals("accName")) {
/* 2568 */       return 29;
/*      */     }
/* 2570 */     if (strFieldName.equals("othIDType")) {
/* 2571 */       return 30;
/*      */     }
/* 2573 */     if (strFieldName.equals("othIDNo")) {
/* 2574 */       return 31;
/*      */     }
/* 2576 */     if (strFieldName.equals("iCNo")) {
/* 2577 */       return 32;
/*      */     }
/* 2579 */     if (strFieldName.equals("grpNo")) {
/* 2580 */       return 33;
/*      */     }
/* 2582 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2583 */       return 34;
/*      */     }
/* 2585 */     if (strFieldName.equals("startWorkDate")) {
/* 2586 */       return 35;
/*      */     }
/* 2588 */     if (strFieldName.equals("position")) {
/* 2589 */       return 36;
/*      */     }
/* 2591 */     if (strFieldName.equals("salary")) {
/* 2592 */       return 37;
/*      */     }
/* 2594 */     if (strFieldName.equals("occupationType")) {
/* 2595 */       return 38;
/*      */     }
/* 2597 */     if (strFieldName.equals("occupationCode")) {
/* 2598 */       return 39;
/*      */     }
/* 2600 */     if (strFieldName.equals("partOccupationType")) {
/* 2601 */       return 40;
/*      */     }
/* 2603 */     if (strFieldName.equals("partOccupationCode")) {
/* 2604 */       return 41;
/*      */     }
/* 2606 */     if (strFieldName.equals("workType")) {
/* 2607 */       return 42;
/*      */     }
/* 2609 */     if (strFieldName.equals("pluralityType")) {
/* 2610 */       return 43;
/*      */     }
/* 2612 */     if (strFieldName.equals("deathDate")) {
/* 2613 */       return 44;
/*      */     }
/* 2615 */     if (strFieldName.equals("smokeFlag")) {
/* 2616 */       return 45;
/*      */     }
/* 2618 */     if (strFieldName.equals("blacklistFlag")) {
/* 2619 */       return 46;
/*      */     }
/* 2621 */     if (strFieldName.equals("proterty")) {
/* 2622 */       return 47;
/*      */     }
/* 2624 */     if (strFieldName.equals("remark")) {
/* 2625 */       return 48;
/*      */     }
/* 2627 */     if (strFieldName.equals("state")) {
/* 2628 */       return 49;
/*      */     }
/* 2630 */     if (strFieldName.equals("vIPValue")) {
/* 2631 */       return 50;
/*      */     }
/* 2633 */     if (strFieldName.equals("operator")) {
/* 2634 */       return 51;
/*      */     }
/* 2636 */     if (strFieldName.equals("manageCom")) {
/* 2637 */       return 52;
/*      */     }
/* 2639 */     if (strFieldName.equals("makeDate")) {
/* 2640 */       return 53;
/*      */     }
/* 2642 */     if (strFieldName.equals("makeTime")) {
/* 2643 */       return 54;
/*      */     }
/* 2645 */     if (strFieldName.equals("modifyDate")) {
/* 2646 */       return 55;
/*      */     }
/* 2648 */     if (strFieldName.equals("modifyTime")) {
/* 2649 */       return 56;
/*      */     }
/* 2651 */     if (strFieldName.equals("grpName")) {
/* 2652 */       return 57;
/*      */     }
/* 2654 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2660 */     String strFieldName = "";
/* 2661 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2663 */       strFieldName = "EdorNo";
/* 2664 */       break;
/*      */     case 1:
/* 2666 */       strFieldName = "serialNo";
/* 2667 */       break;
/*      */     case 2:
/* 2669 */       strFieldName = "customerId";
/* 2670 */       break;
/*      */     case 3:
/* 2672 */       strFieldName = "agentCode";
/* 2673 */       break;
/*      */     case 4:
/* 2675 */       strFieldName = "customerNo";
/* 2676 */       break;
/*      */     case 5:
/* 2678 */       strFieldName = "appellation";
/* 2679 */       break;
/*      */     case 6:
/* 2681 */       strFieldName = "name";
/* 2682 */       break;
/*      */     case 7:
/* 2684 */       strFieldName = "sex";
/* 2685 */       break;
/*      */     case 8:
/* 2687 */       strFieldName = "birthday";
/* 2688 */       break;
/*      */     case 9:
/* 2690 */       strFieldName = "age";
/* 2691 */       break;
/*      */     case 10:
/* 2693 */       strFieldName = "ageType";
/* 2694 */       break;
/*      */     case 11:
/* 2696 */       strFieldName = "appntType";
/* 2697 */       break;
/*      */     case 12:
/* 2699 */       strFieldName = "iDType";
/* 2700 */       break;
/*      */     case 13:
/* 2702 */       strFieldName = "iDNo";
/* 2703 */       break;
/*      */     case 14:
/* 2705 */       strFieldName = "iDValidity";
/* 2706 */       break;
/*      */     case 15:
/* 2708 */       strFieldName = "iDPerpetual";
/* 2709 */       break;
/*      */     case 16:
/* 2711 */       strFieldName = "password";
/* 2712 */       break;
/*      */     case 17:
/* 2714 */       strFieldName = "nativePlace";
/* 2715 */       break;
/*      */     case 18:
/* 2717 */       strFieldName = "nationality";
/* 2718 */       break;
/*      */     case 19:
/* 2720 */       strFieldName = "rgtAddress";
/* 2721 */       break;
/*      */     case 20:
/* 2723 */       strFieldName = "marriage";
/* 2724 */       break;
/*      */     case 21:
/* 2726 */       strFieldName = "marriageDate";
/* 2727 */       break;
/*      */     case 22:
/* 2729 */       strFieldName = "health";
/* 2730 */       break;
/*      */     case 23:
/* 2732 */       strFieldName = "stature";
/* 2733 */       break;
/*      */     case 24:
/* 2735 */       strFieldName = "avoirdupois";
/* 2736 */       break;
/*      */     case 25:
/* 2738 */       strFieldName = "degree";
/* 2739 */       break;
/*      */     case 26:
/* 2741 */       strFieldName = "creditGrade";
/* 2742 */       break;
/*      */     case 27:
/* 2744 */       strFieldName = "bankCode";
/* 2745 */       break;
/*      */     case 28:
/* 2747 */       strFieldName = "bankAccNo";
/* 2748 */       break;
/*      */     case 29:
/* 2750 */       strFieldName = "accName";
/* 2751 */       break;
/*      */     case 30:
/* 2753 */       strFieldName = "othIDType";
/* 2754 */       break;
/*      */     case 31:
/* 2756 */       strFieldName = "othIDNo";
/* 2757 */       break;
/*      */     case 32:
/* 2759 */       strFieldName = "iCNo";
/* 2760 */       break;
/*      */     case 33:
/* 2762 */       strFieldName = "grpNo";
/* 2763 */       break;
/*      */     case 34:
/* 2765 */       strFieldName = "joinCompanyDate";
/* 2766 */       break;
/*      */     case 35:
/* 2768 */       strFieldName = "startWorkDate";
/* 2769 */       break;
/*      */     case 36:
/* 2771 */       strFieldName = "position";
/* 2772 */       break;
/*      */     case 37:
/* 2774 */       strFieldName = "salary";
/* 2775 */       break;
/*      */     case 38:
/* 2777 */       strFieldName = "occupationType";
/* 2778 */       break;
/*      */     case 39:
/* 2780 */       strFieldName = "occupationCode";
/* 2781 */       break;
/*      */     case 40:
/* 2783 */       strFieldName = "partOccupationType";
/* 2784 */       break;
/*      */     case 41:
/* 2786 */       strFieldName = "partOccupationCode";
/* 2787 */       break;
/*      */     case 42:
/* 2789 */       strFieldName = "workType";
/* 2790 */       break;
/*      */     case 43:
/* 2792 */       strFieldName = "pluralityType";
/* 2793 */       break;
/*      */     case 44:
/* 2795 */       strFieldName = "deathDate";
/* 2796 */       break;
/*      */     case 45:
/* 2798 */       strFieldName = "smokeFlag";
/* 2799 */       break;
/*      */     case 46:
/* 2801 */       strFieldName = "blacklistFlag";
/* 2802 */       break;
/*      */     case 47:
/* 2804 */       strFieldName = "proterty";
/* 2805 */       break;
/*      */     case 48:
/* 2807 */       strFieldName = "remark";
/* 2808 */       break;
/*      */     case 49:
/* 2810 */       strFieldName = "state";
/* 2811 */       break;
/*      */     case 50:
/* 2813 */       strFieldName = "vIPValue";
/* 2814 */       break;
/*      */     case 51:
/* 2816 */       strFieldName = "operator";
/* 2817 */       break;
/*      */     case 52:
/* 2819 */       strFieldName = "manageCom";
/* 2820 */       break;
/*      */     case 53:
/* 2822 */       strFieldName = "makeDate";
/* 2823 */       break;
/*      */     case 54:
/* 2825 */       strFieldName = "makeTime";
/* 2826 */       break;
/*      */     case 55:
/* 2828 */       strFieldName = "modifyDate";
/* 2829 */       break;
/*      */     case 56:
/* 2831 */       strFieldName = "modifyTime";
/* 2832 */       break;
/*      */     case 57:
/* 2834 */       strFieldName = "grpName";
/* 2835 */       break;
/*      */     default:
/* 2837 */       strFieldName = "";
/*      */     }
/* 2839 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2845 */     if (strFieldName.equals("EdorNo")) {
/* 2846 */       return 0;
/*      */     }
/* 2848 */     if (strFieldName.equals("serialNo")) {
/* 2849 */       return 0;
/*      */     }
/* 2851 */     if (strFieldName.equals("customerId")) {
/* 2852 */       return 0;
/*      */     }
/* 2854 */     if (strFieldName.equals("agentCode")) {
/* 2855 */       return 0;
/*      */     }
/* 2857 */     if (strFieldName.equals("customerNo")) {
/* 2858 */       return 0;
/*      */     }
/* 2860 */     if (strFieldName.equals("appellation")) {
/* 2861 */       return 0;
/*      */     }
/* 2863 */     if (strFieldName.equals("name")) {
/* 2864 */       return 0;
/*      */     }
/* 2866 */     if (strFieldName.equals("sex")) {
/* 2867 */       return 0;
/*      */     }
/* 2869 */     if (strFieldName.equals("birthday")) {
/* 2870 */       return 1;
/*      */     }
/* 2872 */     if (strFieldName.equals("age")) {
/* 2873 */       return 3;
/*      */     }
/* 2875 */     if (strFieldName.equals("ageType")) {
/* 2876 */       return 0;
/*      */     }
/* 2878 */     if (strFieldName.equals("appntType")) {
/* 2879 */       return 0;
/*      */     }
/* 2881 */     if (strFieldName.equals("iDType")) {
/* 2882 */       return 0;
/*      */     }
/* 2884 */     if (strFieldName.equals("iDNo")) {
/* 2885 */       return 0;
/*      */     }
/* 2887 */     if (strFieldName.equals("iDValidity")) {
/* 2888 */       return 1;
/*      */     }
/* 2890 */     if (strFieldName.equals("iDPerpetual")) {
/* 2891 */       return 0;
/*      */     }
/* 2893 */     if (strFieldName.equals("password")) {
/* 2894 */       return 0;
/*      */     }
/* 2896 */     if (strFieldName.equals("nativePlace")) {
/* 2897 */       return 0;
/*      */     }
/* 2899 */     if (strFieldName.equals("nationality")) {
/* 2900 */       return 0;
/*      */     }
/* 2902 */     if (strFieldName.equals("rgtAddress")) {
/* 2903 */       return 0;
/*      */     }
/* 2905 */     if (strFieldName.equals("marriage")) {
/* 2906 */       return 0;
/*      */     }
/* 2908 */     if (strFieldName.equals("marriageDate")) {
/* 2909 */       return 1;
/*      */     }
/* 2911 */     if (strFieldName.equals("health")) {
/* 2912 */       return 0;
/*      */     }
/* 2914 */     if (strFieldName.equals("stature")) {
/* 2915 */       return 4;
/*      */     }
/* 2917 */     if (strFieldName.equals("avoirdupois")) {
/* 2918 */       return 4;
/*      */     }
/* 2920 */     if (strFieldName.equals("degree")) {
/* 2921 */       return 0;
/*      */     }
/* 2923 */     if (strFieldName.equals("creditGrade")) {
/* 2924 */       return 0;
/*      */     }
/* 2926 */     if (strFieldName.equals("bankCode")) {
/* 2927 */       return 0;
/*      */     }
/* 2929 */     if (strFieldName.equals("bankAccNo")) {
/* 2930 */       return 0;
/*      */     }
/* 2932 */     if (strFieldName.equals("accName")) {
/* 2933 */       return 0;
/*      */     }
/* 2935 */     if (strFieldName.equals("othIDType")) {
/* 2936 */       return 0;
/*      */     }
/* 2938 */     if (strFieldName.equals("othIDNo")) {
/* 2939 */       return 0;
/*      */     }
/* 2941 */     if (strFieldName.equals("iCNo")) {
/* 2942 */       return 0;
/*      */     }
/* 2944 */     if (strFieldName.equals("grpNo")) {
/* 2945 */       return 0;
/*      */     }
/* 2947 */     if (strFieldName.equals("joinCompanyDate")) {
/* 2948 */       return 1;
/*      */     }
/* 2950 */     if (strFieldName.equals("startWorkDate")) {
/* 2951 */       return 1;
/*      */     }
/* 2953 */     if (strFieldName.equals("position")) {
/* 2954 */       return 0;
/*      */     }
/* 2956 */     if (strFieldName.equals("salary")) {
/* 2957 */       return 4;
/*      */     }
/* 2959 */     if (strFieldName.equals("occupationType")) {
/* 2960 */       return 0;
/*      */     }
/* 2962 */     if (strFieldName.equals("occupationCode")) {
/* 2963 */       return 0;
/*      */     }
/* 2965 */     if (strFieldName.equals("partOccupationType")) {
/* 2966 */       return 0;
/*      */     }
/* 2968 */     if (strFieldName.equals("partOccupationCode")) {
/* 2969 */       return 0;
/*      */     }
/* 2971 */     if (strFieldName.equals("workType")) {
/* 2972 */       return 0;
/*      */     }
/* 2974 */     if (strFieldName.equals("pluralityType")) {
/* 2975 */       return 0;
/*      */     }
/* 2977 */     if (strFieldName.equals("deathDate")) {
/* 2978 */       return 1;
/*      */     }
/* 2980 */     if (strFieldName.equals("smokeFlag")) {
/* 2981 */       return 0;
/*      */     }
/* 2983 */     if (strFieldName.equals("blacklistFlag")) {
/* 2984 */       return 0;
/*      */     }
/* 2986 */     if (strFieldName.equals("proterty")) {
/* 2987 */       return 0;
/*      */     }
/* 2989 */     if (strFieldName.equals("remark")) {
/* 2990 */       return 0;
/*      */     }
/* 2992 */     if (strFieldName.equals("state")) {
/* 2993 */       return 0;
/*      */     }
/* 2995 */     if (strFieldName.equals("vIPValue")) {
/* 2996 */       return 0;
/*      */     }
/* 2998 */     if (strFieldName.equals("operator")) {
/* 2999 */       return 0;
/*      */     }
/* 3001 */     if (strFieldName.equals("manageCom")) {
/* 3002 */       return 0;
/*      */     }
/* 3004 */     if (strFieldName.equals("makeDate")) {
/* 3005 */       return 1;
/*      */     }
/* 3007 */     if (strFieldName.equals("makeTime")) {
/* 3008 */       return 0;
/*      */     }
/* 3010 */     if (strFieldName.equals("modifyDate")) {
/* 3011 */       return 1;
/*      */     }
/* 3013 */     if (strFieldName.equals("modifyTime")) {
/* 3014 */       return 0;
/*      */     }
/* 3016 */     if (strFieldName.equals("grpName")) {
/* 3017 */       return 0;
/*      */     }
/* 3019 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 3025 */     int nFieldType = -1;
/* 3026 */     switch (nFieldIndex) {
/*      */     case 0:
/* 3028 */       nFieldType = 0;
/* 3029 */       break;
/*      */     case 1:
/* 3031 */       nFieldType = 0;
/* 3032 */       break;
/*      */     case 2:
/* 3034 */       nFieldType = 0;
/* 3035 */       break;
/*      */     case 3:
/* 3037 */       nFieldType = 0;
/* 3038 */       break;
/*      */     case 4:
/* 3040 */       nFieldType = 0;
/* 3041 */       break;
/*      */     case 5:
/* 3043 */       nFieldType = 0;
/* 3044 */       break;
/*      */     case 6:
/* 3046 */       nFieldType = 0;
/* 3047 */       break;
/*      */     case 7:
/* 3049 */       nFieldType = 0;
/* 3050 */       break;
/*      */     case 8:
/* 3052 */       nFieldType = 1;
/* 3053 */       break;
/*      */     case 9:
/* 3055 */       nFieldType = 3;
/* 3056 */       break;
/*      */     case 10:
/* 3058 */       nFieldType = 0;
/* 3059 */       break;
/*      */     case 11:
/* 3061 */       nFieldType = 0;
/* 3062 */       break;
/*      */     case 12:
/* 3064 */       nFieldType = 0;
/* 3065 */       break;
/*      */     case 13:
/* 3067 */       nFieldType = 0;
/* 3068 */       break;
/*      */     case 14:
/* 3070 */       nFieldType = 1;
/* 3071 */       break;
/*      */     case 15:
/* 3073 */       nFieldType = 0;
/* 3074 */       break;
/*      */     case 16:
/* 3076 */       nFieldType = 0;
/* 3077 */       break;
/*      */     case 17:
/* 3079 */       nFieldType = 0;
/* 3080 */       break;
/*      */     case 18:
/* 3082 */       nFieldType = 0;
/* 3083 */       break;
/*      */     case 19:
/* 3085 */       nFieldType = 0;
/* 3086 */       break;
/*      */     case 20:
/* 3088 */       nFieldType = 0;
/* 3089 */       break;
/*      */     case 21:
/* 3091 */       nFieldType = 1;
/* 3092 */       break;
/*      */     case 22:
/* 3094 */       nFieldType = 0;
/* 3095 */       break;
/*      */     case 23:
/* 3097 */       nFieldType = 4;
/* 3098 */       break;
/*      */     case 24:
/* 3100 */       nFieldType = 4;
/* 3101 */       break;
/*      */     case 25:
/* 3103 */       nFieldType = 0;
/* 3104 */       break;
/*      */     case 26:
/* 3106 */       nFieldType = 0;
/* 3107 */       break;
/*      */     case 27:
/* 3109 */       nFieldType = 0;
/* 3110 */       break;
/*      */     case 28:
/* 3112 */       nFieldType = 0;
/* 3113 */       break;
/*      */     case 29:
/* 3115 */       nFieldType = 0;
/* 3116 */       break;
/*      */     case 30:
/* 3118 */       nFieldType = 0;
/* 3119 */       break;
/*      */     case 31:
/* 3121 */       nFieldType = 0;
/* 3122 */       break;
/*      */     case 32:
/* 3124 */       nFieldType = 0;
/* 3125 */       break;
/*      */     case 33:
/* 3127 */       nFieldType = 0;
/* 3128 */       break;
/*      */     case 34:
/* 3130 */       nFieldType = 1;
/* 3131 */       break;
/*      */     case 35:
/* 3133 */       nFieldType = 1;
/* 3134 */       break;
/*      */     case 36:
/* 3136 */       nFieldType = 0;
/* 3137 */       break;
/*      */     case 37:
/* 3139 */       nFieldType = 4;
/* 3140 */       break;
/*      */     case 38:
/* 3142 */       nFieldType = 0;
/* 3143 */       break;
/*      */     case 39:
/* 3145 */       nFieldType = 0;
/* 3146 */       break;
/*      */     case 40:
/* 3148 */       nFieldType = 0;
/* 3149 */       break;
/*      */     case 41:
/* 3151 */       nFieldType = 0;
/* 3152 */       break;
/*      */     case 42:
/* 3154 */       nFieldType = 0;
/* 3155 */       break;
/*      */     case 43:
/* 3157 */       nFieldType = 0;
/* 3158 */       break;
/*      */     case 44:
/* 3160 */       nFieldType = 1;
/* 3161 */       break;
/*      */     case 45:
/* 3163 */       nFieldType = 0;
/* 3164 */       break;
/*      */     case 46:
/* 3166 */       nFieldType = 0;
/* 3167 */       break;
/*      */     case 47:
/* 3169 */       nFieldType = 0;
/* 3170 */       break;
/*      */     case 48:
/* 3172 */       nFieldType = 0;
/* 3173 */       break;
/*      */     case 49:
/* 3175 */       nFieldType = 0;
/* 3176 */       break;
/*      */     case 50:
/* 3178 */       nFieldType = 0;
/* 3179 */       break;
/*      */     case 51:
/* 3181 */       nFieldType = 0;
/* 3182 */       break;
/*      */     case 52:
/* 3184 */       nFieldType = 0;
/* 3185 */       break;
/*      */     case 53:
/* 3187 */       nFieldType = 1;
/* 3188 */       break;
/*      */     case 54:
/* 3190 */       nFieldType = 0;
/* 3191 */       break;
/*      */     case 55:
/* 3193 */       nFieldType = 1;
/* 3194 */       break;
/*      */     case 56:
/* 3196 */       nFieldType = 0;
/* 3197 */       break;
/*      */     case 57:
/* 3199 */       nFieldType = 0;
/* 3200 */       break;
/*      */     default:
/* 3202 */       nFieldType = -1;
/*      */     }
/* 3204 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPPersonBSchema
 * JD-Core Version:    0.6.0
 */