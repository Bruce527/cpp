/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPPolBDB;
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
/*      */ public class LNPPolBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
/*      */   private String grpContNo;
/*      */   private String grpPolNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String polNo;
/*      */   private String proposalNo;
/*      */   private String prtNo;
/*      */   private String contType;
/*      */   private String polTypeFlag;
/*      */   private String mainPolNo;
/*      */   private String masterPolNo;
/*      */   private String kindCode;
/*      */   private String riskCode;
/*      */   private String riskVersion;
/*      */   private String manageCom;
/*      */   private String agentCom;
/*      */   private String agentType;
/*      */   private String agentCode;
/*      */   private String agentGroup;
/*      */   private String agentGroup1;
/*      */   private String agentCode1;
/*      */   private String saleChnl;
/*      */   private String handler;
/*      */   private String insuredNo;
/*      */   private String insuredId;
/*      */   private String insuredName;
/*      */   private String insuredSex;
/*      */   private Date insuredBirthday;
/*      */   private int insuredAppAge;
/*      */   private int insuredPeoples;
/*      */   private String occupationType;
/*      */   private String appntNo;
/*      */   private String appntName;
/*      */   private Date cValiDate;
/*      */   private String signCom;
/*      */   private Date signDate;
/*      */   private String signTime;
/*      */   private Date firstPayDate;
/*      */   private Date payEndDate;
/*      */   private Date paytoDate;
/*      */   private Date getStartDate;
/*      */   private Date endDate;
/*      */   private Date acciEndDate;
/*      */   private String getYearFlag;
/*      */   private int getYear;
/*      */   private String payEndYearFlag;
/*      */   private int payEndYear;
/*      */   private String insuYearFlag;
/*      */   private int insuYear;
/*      */   private String acciYearFlag;
/*      */   private int acciYear;
/*      */   private String getStartType;
/*      */   private String specifyValiDate;
/*      */   private String payMode;
/*      */   private String payLocation;
/*      */   private int payIntv;
/*      */   private int payYears;
/*      */   private int years;
/*      */   private double manageFeeRate;
/*      */   private double floatRate;
/*      */   private double premRate;
/*      */   private String premToAmnt;
/*      */   private double mult;
/*      */   private double standPrem;
/*      */   private double prem;
/*      */   private double sumPrem;
/*      */   private double amnt;
/*      */   private double riskAmnt;
/*      */   private double leavingMoney;
/*      */   private int endorseTimes;
/*      */   private int claimTimes;
/*      */   private int liveTimes;
/*      */   private int renewCount;
/*      */   private Date lastGetDate;
/*      */   private Date lastLoanDate;
/*      */   private Date lastRegetDate;
/*      */   private Date lastEdorDate;
/*      */   private Date lastRevDate;
/*      */   private String rnewFlag;
/*      */   private String stopFlag;
/*      */   private String expiryFlag;
/*      */   private String autoPayFlag;
/*      */   private String interestDifFlag;
/*      */   private String subFlag;
/*      */   private String bnfFlag;
/*      */   private String healthCheckFlag;
/*      */   private String impartFlag;
/*      */   private String reinsureFlag;
/*      */   private String agentPayFlag;
/*      */   private String agentGetFlag;
/*      */   private String liveGetMode;
/*      */   private String deadGetMode;
/*      */   private String bonusGetMode;
/*      */   private String deadAmntType;
/*      */   private double topUpPrem;
/*      */   private String bonusMan;
/*      */   private String deadFlag;
/*      */   private String smokeFlag;
/*      */   private String remark;
/*      */   private String approveFlag;
/*      */   private String approveCode;
/*      */   private Date approveDate;
/*      */   private String approveTime;
/*      */   private String uWFlag;
/*      */   private String uWCode;
/*      */   private Date uWDate;
/*      */   private String uWTime;
/*      */   private Date polApplyDate;
/*      */   private String appFlag;
/*      */   private String saleChnlDetail;
/*      */   private String polState;
/*      */   private String standbyFlag1;
/*      */   private String standbyFlag2;
/*      */   private String standbyFlag3;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 121;
/*      */   private static String[] PK;
/*  267 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPPolBSchema()
/*      */   {
/*  274 */     this.mErrors = new CErrors();
/*      */ 
/*  276 */     String[] pk = new String[2];
/*  277 */     pk[0] = "EdorNo";
/*  278 */     pk[1] = "serialNo";
/*      */ 
/*  280 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  286 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  291 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*  295 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  299 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*  303 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  307 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  311 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getgrpContNo() {
/*  315 */     if (this.grpContNo != null) this.grpContNo.equals("");
/*      */ 
/*  319 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setgrpContNo(String agrpContNo) {
/*  323 */     this.grpContNo = agrpContNo;
/*      */   }
/*      */ 
/*      */   public String getgrpPolNo() {
/*  327 */     if (this.grpPolNo != null) this.grpPolNo.equals("");
/*      */ 
/*  331 */     return this.grpPolNo;
/*      */   }
/*      */ 
/*      */   public void setgrpPolNo(String agrpPolNo) {
/*  335 */     this.grpPolNo = agrpPolNo;
/*      */   }
/*      */ 
/*      */   public String getcontNo() {
/*  339 */     if (this.contNo != null) this.contNo.equals("");
/*      */ 
/*  343 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setcontNo(String acontNo) {
/*  347 */     this.contNo = acontNo;
/*      */   }
/*      */ 
/*      */   public String getproposalContNo() {
/*  351 */     if (this.proposalContNo != null) this.proposalContNo.equals("");
/*      */ 
/*  355 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setproposalContNo(String aproposalContNo) {
/*  359 */     this.proposalContNo = aproposalContNo;
/*      */   }
/*      */ 
/*      */   public String getpolNo() {
/*  363 */     if (this.polNo != null) this.polNo.equals("");
/*      */ 
/*  367 */     return this.polNo;
/*      */   }
/*      */ 
/*      */   public void setpolNo(String apolNo) {
/*  371 */     this.polNo = apolNo;
/*      */   }
/*      */ 
/*      */   public String getproposalNo() {
/*  375 */     if (this.proposalNo != null) this.proposalNo.equals("");
/*      */ 
/*  379 */     return this.proposalNo;
/*      */   }
/*      */ 
/*      */   public void setproposalNo(String aproposalNo) {
/*  383 */     this.proposalNo = aproposalNo;
/*      */   }
/*      */ 
/*      */   public String getprtNo() {
/*  387 */     if (this.prtNo != null) this.prtNo.equals("");
/*      */ 
/*  391 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setprtNo(String aprtNo) {
/*  395 */     this.prtNo = aprtNo;
/*      */   }
/*      */ 
/*      */   public String getcontType() {
/*  399 */     if (this.contType != null) this.contType.equals("");
/*      */ 
/*  403 */     return this.contType;
/*      */   }
/*      */ 
/*      */   public void setcontType(String acontType) {
/*  407 */     this.contType = acontType;
/*      */   }
/*      */ 
/*      */   public String getpolTypeFlag() {
/*  411 */     if (this.polTypeFlag != null) this.polTypeFlag.equals("");
/*      */ 
/*  415 */     return this.polTypeFlag;
/*      */   }
/*      */ 
/*      */   public void setpolTypeFlag(String apolTypeFlag) {
/*  419 */     this.polTypeFlag = apolTypeFlag;
/*      */   }
/*      */ 
/*      */   public String getmainPolNo() {
/*  423 */     if (this.mainPolNo != null) this.mainPolNo.equals("");
/*      */ 
/*  427 */     return this.mainPolNo;
/*      */   }
/*      */ 
/*      */   public void setmainPolNo(String amainPolNo) {
/*  431 */     this.mainPolNo = amainPolNo;
/*      */   }
/*      */ 
/*      */   public String getmasterPolNo() {
/*  435 */     if (this.masterPolNo != null) this.masterPolNo.equals("");
/*      */ 
/*  439 */     return this.masterPolNo;
/*      */   }
/*      */ 
/*      */   public void setmasterPolNo(String amasterPolNo) {
/*  443 */     this.masterPolNo = amasterPolNo;
/*      */   }
/*      */ 
/*      */   public String getkindCode() {
/*  447 */     if (this.kindCode != null) this.kindCode.equals("");
/*      */ 
/*  451 */     return this.kindCode;
/*      */   }
/*      */ 
/*      */   public void setkindCode(String akindCode) {
/*  455 */     this.kindCode = akindCode;
/*      */   }
/*      */ 
/*      */   public String getriskCode() {
/*  459 */     if (this.riskCode != null) this.riskCode.equals("");
/*      */ 
/*  463 */     return this.riskCode;
/*      */   }
/*      */ 
/*      */   public void setriskCode(String ariskCode) {
/*  467 */     this.riskCode = ariskCode;
/*      */   }
/*      */ 
/*      */   public String getriskVersion() {
/*  471 */     if (this.riskVersion != null) this.riskVersion.equals("");
/*      */ 
/*  475 */     return this.riskVersion;
/*      */   }
/*      */ 
/*      */   public void setriskVersion(String ariskVersion) {
/*  479 */     this.riskVersion = ariskVersion;
/*      */   }
/*      */ 
/*      */   public String getmanageCom() {
/*  483 */     if (this.manageCom != null) this.manageCom.equals("");
/*      */ 
/*  487 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setmanageCom(String amanageCom) {
/*  491 */     this.manageCom = amanageCom;
/*      */   }
/*      */ 
/*      */   public String getagentCom() {
/*  495 */     if (this.agentCom != null) this.agentCom.equals("");
/*      */ 
/*  499 */     return this.agentCom;
/*      */   }
/*      */ 
/*      */   public void setagentCom(String aagentCom) {
/*  503 */     this.agentCom = aagentCom;
/*      */   }
/*      */ 
/*      */   public String getagentType() {
/*  507 */     if (this.agentType != null) this.agentType.equals("");
/*      */ 
/*  511 */     return this.agentType;
/*      */   }
/*      */ 
/*      */   public void setagentType(String aagentType) {
/*  515 */     this.agentType = aagentType;
/*      */   }
/*      */ 
/*      */   public String getagentCode() {
/*  519 */     if (this.agentCode != null) this.agentCode.equals("");
/*      */ 
/*  523 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setagentCode(String aagentCode) {
/*  527 */     this.agentCode = aagentCode;
/*      */   }
/*      */ 
/*      */   public String getagentGroup() {
/*  531 */     if (this.agentGroup != null) this.agentGroup.equals("");
/*      */ 
/*  535 */     return this.agentGroup;
/*      */   }
/*      */ 
/*      */   public void setagentGroup(String aagentGroup) {
/*  539 */     this.agentGroup = aagentGroup;
/*      */   }
/*      */ 
/*      */   public String getagentGroup1() {
/*  543 */     if (this.agentGroup1 != null) this.agentGroup1.equals("");
/*      */ 
/*  547 */     return this.agentGroup1;
/*      */   }
/*      */ 
/*      */   public void setagentGroup1(String aagentGroup1) {
/*  551 */     this.agentGroup1 = aagentGroup1;
/*      */   }
/*      */ 
/*      */   public String getagentCode1() {
/*  555 */     if (this.agentCode1 != null) this.agentCode1.equals("");
/*      */ 
/*  559 */     return this.agentCode1;
/*      */   }
/*      */ 
/*      */   public void setagentCode1(String aagentCode1) {
/*  563 */     this.agentCode1 = aagentCode1;
/*      */   }
/*      */ 
/*      */   public String getsaleChnl() {
/*  567 */     if (this.saleChnl != null) this.saleChnl.equals("");
/*      */ 
/*  571 */     return this.saleChnl;
/*      */   }
/*      */ 
/*      */   public void setsaleChnl(String asaleChnl) {
/*  575 */     this.saleChnl = asaleChnl;
/*      */   }
/*      */ 
/*      */   public String gethandler() {
/*  579 */     if (this.handler != null) this.handler.equals("");
/*      */ 
/*  583 */     return this.handler;
/*      */   }
/*      */ 
/*      */   public void sethandler(String ahandler) {
/*  587 */     this.handler = ahandler;
/*      */   }
/*      */ 
/*      */   public String getinsuredNo() {
/*  591 */     if (this.insuredNo != null) this.insuredNo.equals("");
/*      */ 
/*  595 */     return this.insuredNo;
/*      */   }
/*      */ 
/*      */   public void setinsuredNo(String ainsuredNo) {
/*  599 */     this.insuredNo = ainsuredNo;
/*      */   }
/*      */ 
/*      */   public String getinsuredId() {
/*  603 */     if (this.insuredId != null) this.insuredId.equals("");
/*      */ 
/*  607 */     return this.insuredId;
/*      */   }
/*      */ 
/*      */   public void setinsuredId(String ainsuredId) {
/*  611 */     this.insuredId = ainsuredId;
/*      */   }
/*      */ 
/*      */   public String getinsuredName() {
/*  615 */     if (this.insuredName != null) this.insuredName.equals("");
/*      */ 
/*  619 */     return this.insuredName;
/*      */   }
/*      */ 
/*      */   public void setinsuredName(String ainsuredName) {
/*  623 */     this.insuredName = ainsuredName;
/*      */   }
/*      */ 
/*      */   public String getinsuredSex() {
/*  627 */     if (this.insuredSex != null) this.insuredSex.equals("");
/*      */ 
/*  631 */     return this.insuredSex;
/*      */   }
/*      */ 
/*      */   public void setinsuredSex(String ainsuredSex) {
/*  635 */     this.insuredSex = ainsuredSex;
/*      */   }
/*      */ 
/*      */   public String getinsuredBirthday() {
/*  639 */     if (this.insuredBirthday != null) {
/*  640 */       return this.fDate.getString(this.insuredBirthday);
/*      */     }
/*  642 */     return null;
/*      */   }
/*      */ 
/*      */   public void setinsuredBirthday(Date ainsuredBirthday) {
/*  646 */     this.insuredBirthday = ainsuredBirthday;
/*      */   }
/*      */ 
/*      */   public void setinsuredBirthday(String ainsuredBirthday) {
/*  650 */     if ((ainsuredBirthday != null) && (!ainsuredBirthday.equals("")))
/*      */     {
/*  652 */       this.insuredBirthday = this.fDate.getDate(ainsuredBirthday);
/*      */     }
/*      */     else
/*  655 */       this.insuredBirthday = null;
/*      */   }
/*      */ 
/*      */   public int getinsuredAppAge()
/*      */   {
/*  660 */     return this.insuredAppAge;
/*      */   }
/*      */ 
/*      */   public void setinsuredAppAge(int ainsuredAppAge) {
/*  664 */     this.insuredAppAge = ainsuredAppAge;
/*      */   }
/*      */ 
/*      */   public void setinsuredAppAge(String ainsuredAppAge) {
/*  668 */     if ((ainsuredAppAge != null) && (!ainsuredAppAge.equals("")))
/*      */     {
/*  670 */       Integer tInteger = new Integer(ainsuredAppAge);
/*  671 */       int i = tInteger.intValue();
/*  672 */       this.insuredAppAge = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getinsuredPeoples()
/*      */   {
/*  678 */     return this.insuredPeoples;
/*      */   }
/*      */ 
/*      */   public void setinsuredPeoples(int ainsuredPeoples) {
/*  682 */     this.insuredPeoples = ainsuredPeoples;
/*      */   }
/*      */ 
/*      */   public void setinsuredPeoples(String ainsuredPeoples) {
/*  686 */     if ((ainsuredPeoples != null) && (!ainsuredPeoples.equals("")))
/*      */     {
/*  688 */       Integer tInteger = new Integer(ainsuredPeoples);
/*  689 */       int i = tInteger.intValue();
/*  690 */       this.insuredPeoples = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getoccupationType()
/*      */   {
/*  696 */     if (this.occupationType != null) this.occupationType.equals("");
/*      */ 
/*  700 */     return this.occupationType;
/*      */   }
/*      */ 
/*      */   public void setoccupationType(String aoccupationType) {
/*  704 */     this.occupationType = aoccupationType;
/*      */   }
/*      */ 
/*      */   public String getappntNo() {
/*  708 */     if (this.appntNo != null) this.appntNo.equals("");
/*      */ 
/*  712 */     return this.appntNo;
/*      */   }
/*      */ 
/*      */   public void setappntNo(String aappntNo) {
/*  716 */     this.appntNo = aappntNo;
/*      */   }
/*      */ 
/*      */   public String getappntName() {
/*  720 */     if (this.appntName != null) this.appntName.equals("");
/*      */ 
/*  724 */     return this.appntName;
/*      */   }
/*      */ 
/*      */   public void setappntName(String aappntName) {
/*  728 */     this.appntName = aappntName;
/*      */   }
/*      */ 
/*      */   public String getcValiDate() {
/*  732 */     if (this.cValiDate != null) {
/*  733 */       return this.fDate.getString(this.cValiDate);
/*      */     }
/*  735 */     return null;
/*      */   }
/*      */ 
/*      */   public void setcValiDate(Date acValiDate) {
/*  739 */     this.cValiDate = acValiDate;
/*      */   }
/*      */ 
/*      */   public void setcValiDate(String acValiDate) {
/*  743 */     if ((acValiDate != null) && (!acValiDate.equals("")))
/*      */     {
/*  745 */       this.cValiDate = this.fDate.getDate(acValiDate);
/*      */     }
/*      */     else
/*  748 */       this.cValiDate = null;
/*      */   }
/*      */ 
/*      */   public String getsignCom()
/*      */   {
/*  753 */     if (this.signCom != null) this.signCom.equals("");
/*      */ 
/*  757 */     return this.signCom;
/*      */   }
/*      */ 
/*      */   public void setsignCom(String asignCom) {
/*  761 */     this.signCom = asignCom;
/*      */   }
/*      */ 
/*      */   public String getsignDate() {
/*  765 */     if (this.signDate != null) {
/*  766 */       return this.fDate.getString(this.signDate);
/*      */     }
/*  768 */     return null;
/*      */   }
/*      */ 
/*      */   public void setsignDate(Date asignDate) {
/*  772 */     this.signDate = asignDate;
/*      */   }
/*      */ 
/*      */   public void setsignDate(String asignDate) {
/*  776 */     if ((asignDate != null) && (!asignDate.equals("")))
/*      */     {
/*  778 */       this.signDate = this.fDate.getDate(asignDate);
/*      */     }
/*      */     else
/*  781 */       this.signDate = null;
/*      */   }
/*      */ 
/*      */   public String getsignTime()
/*      */   {
/*  786 */     if (this.signTime != null) this.signTime.equals("");
/*      */ 
/*  790 */     return this.signTime;
/*      */   }
/*      */ 
/*      */   public void setsignTime(String asignTime) {
/*  794 */     this.signTime = asignTime;
/*      */   }
/*      */ 
/*      */   public String getfirstPayDate() {
/*  798 */     if (this.firstPayDate != null) {
/*  799 */       return this.fDate.getString(this.firstPayDate);
/*      */     }
/*  801 */     return null;
/*      */   }
/*      */ 
/*      */   public void setfirstPayDate(Date afirstPayDate) {
/*  805 */     this.firstPayDate = afirstPayDate;
/*      */   }
/*      */ 
/*      */   public void setfirstPayDate(String afirstPayDate) {
/*  809 */     if ((afirstPayDate != null) && (!afirstPayDate.equals("")))
/*      */     {
/*  811 */       this.firstPayDate = this.fDate.getDate(afirstPayDate);
/*      */     }
/*      */     else
/*  814 */       this.firstPayDate = null;
/*      */   }
/*      */ 
/*      */   public String getpayEndDate()
/*      */   {
/*  819 */     if (this.payEndDate != null) {
/*  820 */       return this.fDate.getString(this.payEndDate);
/*      */     }
/*  822 */     return null;
/*      */   }
/*      */ 
/*      */   public void setpayEndDate(Date apayEndDate) {
/*  826 */     this.payEndDate = apayEndDate;
/*      */   }
/*      */ 
/*      */   public void setpayEndDate(String apayEndDate) {
/*  830 */     if ((apayEndDate != null) && (!apayEndDate.equals("")))
/*      */     {
/*  832 */       this.payEndDate = this.fDate.getDate(apayEndDate);
/*      */     }
/*      */     else
/*  835 */       this.payEndDate = null;
/*      */   }
/*      */ 
/*      */   public String getpaytoDate()
/*      */   {
/*  840 */     if (this.paytoDate != null) {
/*  841 */       return this.fDate.getString(this.paytoDate);
/*      */     }
/*  843 */     return null;
/*      */   }
/*      */ 
/*      */   public void setpaytoDate(Date apaytoDate) {
/*  847 */     this.paytoDate = apaytoDate;
/*      */   }
/*      */ 
/*      */   public void setpaytoDate(String apaytoDate) {
/*  851 */     if ((apaytoDate != null) && (!apaytoDate.equals("")))
/*      */     {
/*  853 */       this.paytoDate = this.fDate.getDate(apaytoDate);
/*      */     }
/*      */     else
/*  856 */       this.paytoDate = null;
/*      */   }
/*      */ 
/*      */   public String getgetStartDate()
/*      */   {
/*  861 */     if (this.getStartDate != null) {
/*  862 */       return this.fDate.getString(this.getStartDate);
/*      */     }
/*  864 */     return null;
/*      */   }
/*      */ 
/*      */   public void setgetStartDate(Date agetStartDate) {
/*  868 */     this.getStartDate = agetStartDate;
/*      */   }
/*      */ 
/*      */   public void setgetStartDate(String agetStartDate) {
/*  872 */     if ((agetStartDate != null) && (!agetStartDate.equals("")))
/*      */     {
/*  874 */       this.getStartDate = this.fDate.getDate(agetStartDate);
/*      */     }
/*      */     else
/*  877 */       this.getStartDate = null;
/*      */   }
/*      */ 
/*      */   public String getendDate()
/*      */   {
/*  882 */     if (this.endDate != null) {
/*  883 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  885 */     return null;
/*      */   }
/*      */ 
/*      */   public void setendDate(Date aendDate) {
/*  889 */     this.endDate = aendDate;
/*      */   }
/*      */ 
/*      */   public void setendDate(String aendDate) {
/*  893 */     if ((aendDate != null) && (!aendDate.equals("")))
/*      */     {
/*  895 */       this.endDate = this.fDate.getDate(aendDate);
/*      */     }
/*      */     else
/*  898 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getacciEndDate()
/*      */   {
/*  903 */     if (this.acciEndDate != null) {
/*  904 */       return this.fDate.getString(this.acciEndDate);
/*      */     }
/*  906 */     return null;
/*      */   }
/*      */ 
/*      */   public void setacciEndDate(Date aacciEndDate) {
/*  910 */     this.acciEndDate = aacciEndDate;
/*      */   }
/*      */ 
/*      */   public void setacciEndDate(String aacciEndDate) {
/*  914 */     if ((aacciEndDate != null) && (!aacciEndDate.equals("")))
/*      */     {
/*  916 */       this.acciEndDate = this.fDate.getDate(aacciEndDate);
/*      */     }
/*      */     else
/*  919 */       this.acciEndDate = null;
/*      */   }
/*      */ 
/*      */   public String getgetYearFlag()
/*      */   {
/*  924 */     if (this.getYearFlag != null) this.getYearFlag.equals("");
/*      */ 
/*  928 */     return this.getYearFlag;
/*      */   }
/*      */ 
/*      */   public void setgetYearFlag(String agetYearFlag) {
/*  932 */     this.getYearFlag = agetYearFlag;
/*      */   }
/*      */ 
/*      */   public int getgetYear() {
/*  936 */     return this.getYear;
/*      */   }
/*      */ 
/*      */   public void setgetYear(int agetYear) {
/*  940 */     this.getYear = agetYear;
/*      */   }
/*      */ 
/*      */   public void setgetYear(String agetYear) {
/*  944 */     if ((agetYear != null) && (!agetYear.equals("")))
/*      */     {
/*  946 */       Integer tInteger = new Integer(agetYear);
/*  947 */       int i = tInteger.intValue();
/*  948 */       this.getYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getpayEndYearFlag()
/*      */   {
/*  954 */     if (this.payEndYearFlag != null) this.payEndYearFlag.equals("");
/*      */ 
/*  958 */     return this.payEndYearFlag;
/*      */   }
/*      */ 
/*      */   public void setpayEndYearFlag(String apayEndYearFlag) {
/*  962 */     this.payEndYearFlag = apayEndYearFlag;
/*      */   }
/*      */ 
/*      */   public int getpayEndYear() {
/*  966 */     return this.payEndYear;
/*      */   }
/*      */ 
/*      */   public void setpayEndYear(int apayEndYear) {
/*  970 */     this.payEndYear = apayEndYear;
/*      */   }
/*      */ 
/*      */   public void setpayEndYear(String apayEndYear) {
/*  974 */     if ((apayEndYear != null) && (!apayEndYear.equals("")))
/*      */     {
/*  976 */       Integer tInteger = new Integer(apayEndYear);
/*  977 */       int i = tInteger.intValue();
/*  978 */       this.payEndYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getinsuYearFlag()
/*      */   {
/*  984 */     if (this.insuYearFlag != null) this.insuYearFlag.equals("");
/*      */ 
/*  988 */     return this.insuYearFlag;
/*      */   }
/*      */ 
/*      */   public void setinsuYearFlag(String ainsuYearFlag) {
/*  992 */     this.insuYearFlag = ainsuYearFlag;
/*      */   }
/*      */ 
/*      */   public int getinsuYear() {
/*  996 */     return this.insuYear;
/*      */   }
/*      */ 
/*      */   public void setinsuYear(int ainsuYear) {
/* 1000 */     this.insuYear = ainsuYear;
/*      */   }
/*      */ 
/*      */   public void setinsuYear(String ainsuYear) {
/* 1004 */     if ((ainsuYear != null) && (!ainsuYear.equals("")))
/*      */     {
/* 1006 */       Integer tInteger = new Integer(ainsuYear);
/* 1007 */       int i = tInteger.intValue();
/* 1008 */       this.insuYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getacciYearFlag()
/*      */   {
/* 1014 */     if (this.acciYearFlag != null) this.acciYearFlag.equals("");
/*      */ 
/* 1018 */     return this.acciYearFlag;
/*      */   }
/*      */ 
/*      */   public void setacciYearFlag(String aacciYearFlag) {
/* 1022 */     this.acciYearFlag = aacciYearFlag;
/*      */   }
/*      */ 
/*      */   public int getacciYear() {
/* 1026 */     return this.acciYear;
/*      */   }
/*      */ 
/*      */   public void setacciYear(int aacciYear) {
/* 1030 */     this.acciYear = aacciYear;
/*      */   }
/*      */ 
/*      */   public void setacciYear(String aacciYear) {
/* 1034 */     if ((aacciYear != null) && (!aacciYear.equals("")))
/*      */     {
/* 1036 */       Integer tInteger = new Integer(aacciYear);
/* 1037 */       int i = tInteger.intValue();
/* 1038 */       this.acciYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getgetStartType()
/*      */   {
/* 1044 */     if (this.getStartType != null) this.getStartType.equals("");
/*      */ 
/* 1048 */     return this.getStartType;
/*      */   }
/*      */ 
/*      */   public void setgetStartType(String agetStartType) {
/* 1052 */     this.getStartType = agetStartType;
/*      */   }
/*      */ 
/*      */   public String getspecifyValiDate() {
/* 1056 */     if (this.specifyValiDate != null) this.specifyValiDate.equals("");
/*      */ 
/* 1060 */     return this.specifyValiDate;
/*      */   }
/*      */ 
/*      */   public void setspecifyValiDate(String aspecifyValiDate) {
/* 1064 */     this.specifyValiDate = aspecifyValiDate;
/*      */   }
/*      */ 
/*      */   public String getpayMode() {
/* 1068 */     if (this.payMode != null) this.payMode.equals("");
/*      */ 
/* 1072 */     return this.payMode;
/*      */   }
/*      */ 
/*      */   public void setpayMode(String apayMode) {
/* 1076 */     this.payMode = apayMode;
/*      */   }
/*      */ 
/*      */   public String getpayLocation() {
/* 1080 */     if (this.payLocation != null) this.payLocation.equals("");
/*      */ 
/* 1084 */     return this.payLocation;
/*      */   }
/*      */ 
/*      */   public void setpayLocation(String apayLocation) {
/* 1088 */     this.payLocation = apayLocation;
/*      */   }
/*      */ 
/*      */   public int getpayIntv() {
/* 1092 */     return this.payIntv;
/*      */   }
/*      */ 
/*      */   public void setpayIntv(int apayIntv) {
/* 1096 */     this.payIntv = apayIntv;
/*      */   }
/*      */ 
/*      */   public void setpayIntv(String apayIntv) {
/* 1100 */     if ((apayIntv != null) && (!apayIntv.equals("")))
/*      */     {
/* 1102 */       Integer tInteger = new Integer(apayIntv);
/* 1103 */       int i = tInteger.intValue();
/* 1104 */       this.payIntv = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getpayYears()
/*      */   {
/* 1110 */     return this.payYears;
/*      */   }
/*      */ 
/*      */   public void setpayYears(int apayYears) {
/* 1114 */     this.payYears = apayYears;
/*      */   }
/*      */ 
/*      */   public void setpayYears(String apayYears) {
/* 1118 */     if ((apayYears != null) && (!apayYears.equals("")))
/*      */     {
/* 1120 */       Integer tInteger = new Integer(apayYears);
/* 1121 */       int i = tInteger.intValue();
/* 1122 */       this.payYears = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getyears()
/*      */   {
/* 1128 */     return this.years;
/*      */   }
/*      */ 
/*      */   public void setyears(int ayears) {
/* 1132 */     this.years = ayears;
/*      */   }
/*      */ 
/*      */   public void setyears(String ayears) {
/* 1136 */     if ((ayears != null) && (!ayears.equals("")))
/*      */     {
/* 1138 */       Integer tInteger = new Integer(ayears);
/* 1139 */       int i = tInteger.intValue();
/* 1140 */       this.years = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getmanageFeeRate()
/*      */   {
/* 1146 */     return this.manageFeeRate;
/*      */   }
/*      */ 
/*      */   public void setmanageFeeRate(double amanageFeeRate) {
/* 1150 */     this.manageFeeRate = amanageFeeRate;
/*      */   }
/*      */ 
/*      */   public void setmanageFeeRate(String amanageFeeRate) {
/* 1154 */     if ((amanageFeeRate != null) && (!amanageFeeRate.equals("")))
/*      */     {
/* 1156 */       Double tDouble = new Double(amanageFeeRate);
/* 1157 */       double d = tDouble.doubleValue();
/* 1158 */       this.manageFeeRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getfloatRate()
/*      */   {
/* 1164 */     return this.floatRate;
/*      */   }
/*      */ 
/*      */   public void setfloatRate(double afloatRate) {
/* 1168 */     this.floatRate = afloatRate;
/*      */   }
/*      */ 
/*      */   public void setfloatRate(String afloatRate) {
/* 1172 */     if ((afloatRate != null) && (!afloatRate.equals("")))
/*      */     {
/* 1174 */       Double tDouble = new Double(afloatRate);
/* 1175 */       double d = tDouble.doubleValue();
/* 1176 */       this.floatRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getpremRate()
/*      */   {
/* 1182 */     return this.premRate;
/*      */   }
/*      */ 
/*      */   public void setpremRate(double apremRate) {
/* 1186 */     this.premRate = apremRate;
/*      */   }
/*      */ 
/*      */   public void setpremRate(String apremRate) {
/* 1190 */     if ((apremRate != null) && (!apremRate.equals("")))
/*      */     {
/* 1192 */       Double tDouble = new Double(apremRate);
/* 1193 */       double d = tDouble.doubleValue();
/* 1194 */       this.premRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getpremToAmnt()
/*      */   {
/* 1200 */     if (this.premToAmnt != null) this.premToAmnt.equals("");
/*      */ 
/* 1204 */     return this.premToAmnt;
/*      */   }
/*      */ 
/*      */   public void setpremToAmnt(String apremToAmnt) {
/* 1208 */     this.premToAmnt = apremToAmnt;
/*      */   }
/*      */ 
/*      */   public double getmult() {
/* 1212 */     return this.mult;
/*      */   }
/*      */ 
/*      */   public void setmult(double amult) {
/* 1216 */     this.mult = amult;
/*      */   }
/*      */ 
/*      */   public void setmult(String amult) {
/* 1220 */     if ((amult != null) && (!amult.equals("")))
/*      */     {
/* 1222 */       Double tDouble = new Double(amult);
/* 1223 */       double d = tDouble.doubleValue();
/* 1224 */       this.mult = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getstandPrem()
/*      */   {
/* 1230 */     return this.standPrem;
/*      */   }
/*      */ 
/*      */   public void setstandPrem(double astandPrem) {
/* 1234 */     this.standPrem = astandPrem;
/*      */   }
/*      */ 
/*      */   public void setstandPrem(String astandPrem) {
/* 1238 */     if ((astandPrem != null) && (!astandPrem.equals("")))
/*      */     {
/* 1240 */       Double tDouble = new Double(astandPrem);
/* 1241 */       double d = tDouble.doubleValue();
/* 1242 */       this.standPrem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getprem()
/*      */   {
/* 1248 */     return this.prem;
/*      */   }
/*      */ 
/*      */   public void setprem(double aprem) {
/* 1252 */     this.prem = aprem;
/*      */   }
/*      */ 
/*      */   public void setprem(String aprem) {
/* 1256 */     if ((aprem != null) && (!aprem.equals("")))
/*      */     {
/* 1258 */       Double tDouble = new Double(aprem);
/* 1259 */       double d = tDouble.doubleValue();
/* 1260 */       this.prem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getsumPrem()
/*      */   {
/* 1266 */     return this.sumPrem;
/*      */   }
/*      */ 
/*      */   public void setsumPrem(double asumPrem) {
/* 1270 */     this.sumPrem = asumPrem;
/*      */   }
/*      */ 
/*      */   public void setsumPrem(String asumPrem) {
/* 1274 */     if ((asumPrem != null) && (!asumPrem.equals("")))
/*      */     {
/* 1276 */       Double tDouble = new Double(asumPrem);
/* 1277 */       double d = tDouble.doubleValue();
/* 1278 */       this.sumPrem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getamnt()
/*      */   {
/* 1284 */     return this.amnt;
/*      */   }
/*      */ 
/*      */   public void setamnt(double aamnt) {
/* 1288 */     this.amnt = aamnt;
/*      */   }
/*      */ 
/*      */   public void setamnt(String aamnt) {
/* 1292 */     if ((aamnt != null) && (!aamnt.equals("")))
/*      */     {
/* 1294 */       Double tDouble = new Double(aamnt);
/* 1295 */       double d = tDouble.doubleValue();
/* 1296 */       this.amnt = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getriskAmnt()
/*      */   {
/* 1302 */     return this.riskAmnt;
/*      */   }
/*      */ 
/*      */   public void setriskAmnt(double ariskAmnt) {
/* 1306 */     this.riskAmnt = ariskAmnt;
/*      */   }
/*      */ 
/*      */   public void setriskAmnt(String ariskAmnt) {
/* 1310 */     if ((ariskAmnt != null) && (!ariskAmnt.equals("")))
/*      */     {
/* 1312 */       Double tDouble = new Double(ariskAmnt);
/* 1313 */       double d = tDouble.doubleValue();
/* 1314 */       this.riskAmnt = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getleavingMoney()
/*      */   {
/* 1320 */     return this.leavingMoney;
/*      */   }
/*      */ 
/*      */   public void setleavingMoney(double aleavingMoney) {
/* 1324 */     this.leavingMoney = aleavingMoney;
/*      */   }
/*      */ 
/*      */   public void setleavingMoney(String aleavingMoney) {
/* 1328 */     if ((aleavingMoney != null) && (!aleavingMoney.equals("")))
/*      */     {
/* 1330 */       Double tDouble = new Double(aleavingMoney);
/* 1331 */       double d = tDouble.doubleValue();
/* 1332 */       this.leavingMoney = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getendorseTimes()
/*      */   {
/* 1338 */     return this.endorseTimes;
/*      */   }
/*      */ 
/*      */   public void setendorseTimes(int aendorseTimes) {
/* 1342 */     this.endorseTimes = aendorseTimes;
/*      */   }
/*      */ 
/*      */   public void setendorseTimes(String aendorseTimes) {
/* 1346 */     if ((aendorseTimes != null) && (!aendorseTimes.equals("")))
/*      */     {
/* 1348 */       Integer tInteger = new Integer(aendorseTimes);
/* 1349 */       int i = tInteger.intValue();
/* 1350 */       this.endorseTimes = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getclaimTimes()
/*      */   {
/* 1356 */     return this.claimTimes;
/*      */   }
/*      */ 
/*      */   public void setclaimTimes(int aclaimTimes) {
/* 1360 */     this.claimTimes = aclaimTimes;
/*      */   }
/*      */ 
/*      */   public void setclaimTimes(String aclaimTimes) {
/* 1364 */     if ((aclaimTimes != null) && (!aclaimTimes.equals("")))
/*      */     {
/* 1366 */       Integer tInteger = new Integer(aclaimTimes);
/* 1367 */       int i = tInteger.intValue();
/* 1368 */       this.claimTimes = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getliveTimes()
/*      */   {
/* 1374 */     return this.liveTimes;
/*      */   }
/*      */ 
/*      */   public void setliveTimes(int aliveTimes) {
/* 1378 */     this.liveTimes = aliveTimes;
/*      */   }
/*      */ 
/*      */   public void setliveTimes(String aliveTimes) {
/* 1382 */     if ((aliveTimes != null) && (!aliveTimes.equals("")))
/*      */     {
/* 1384 */       Integer tInteger = new Integer(aliveTimes);
/* 1385 */       int i = tInteger.intValue();
/* 1386 */       this.liveTimes = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getrenewCount()
/*      */   {
/* 1392 */     return this.renewCount;
/*      */   }
/*      */ 
/*      */   public void setrenewCount(int arenewCount) {
/* 1396 */     this.renewCount = arenewCount;
/*      */   }
/*      */ 
/*      */   public void setrenewCount(String arenewCount) {
/* 1400 */     if ((arenewCount != null) && (!arenewCount.equals("")))
/*      */     {
/* 1402 */       Integer tInteger = new Integer(arenewCount);
/* 1403 */       int i = tInteger.intValue();
/* 1404 */       this.renewCount = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getlastGetDate()
/*      */   {
/* 1410 */     if (this.lastGetDate != null) {
/* 1411 */       return this.fDate.getString(this.lastGetDate);
/*      */     }
/* 1413 */     return null;
/*      */   }
/*      */ 
/*      */   public void setlastGetDate(Date alastGetDate) {
/* 1417 */     this.lastGetDate = alastGetDate;
/*      */   }
/*      */ 
/*      */   public void setlastGetDate(String alastGetDate) {
/* 1421 */     if ((alastGetDate != null) && (!alastGetDate.equals("")))
/*      */     {
/* 1423 */       this.lastGetDate = this.fDate.getDate(alastGetDate);
/*      */     }
/*      */     else
/* 1426 */       this.lastGetDate = null;
/*      */   }
/*      */ 
/*      */   public String getlastLoanDate()
/*      */   {
/* 1431 */     if (this.lastLoanDate != null) {
/* 1432 */       return this.fDate.getString(this.lastLoanDate);
/*      */     }
/* 1434 */     return null;
/*      */   }
/*      */ 
/*      */   public void setlastLoanDate(Date alastLoanDate) {
/* 1438 */     this.lastLoanDate = alastLoanDate;
/*      */   }
/*      */ 
/*      */   public void setlastLoanDate(String alastLoanDate) {
/* 1442 */     if ((alastLoanDate != null) && (!alastLoanDate.equals("")))
/*      */     {
/* 1444 */       this.lastLoanDate = this.fDate.getDate(alastLoanDate);
/*      */     }
/*      */     else
/* 1447 */       this.lastLoanDate = null;
/*      */   }
/*      */ 
/*      */   public String getlastRegetDate()
/*      */   {
/* 1452 */     if (this.lastRegetDate != null) {
/* 1453 */       return this.fDate.getString(this.lastRegetDate);
/*      */     }
/* 1455 */     return null;
/*      */   }
/*      */ 
/*      */   public void setlastRegetDate(Date alastRegetDate) {
/* 1459 */     this.lastRegetDate = alastRegetDate;
/*      */   }
/*      */ 
/*      */   public void setlastRegetDate(String alastRegetDate) {
/* 1463 */     if ((alastRegetDate != null) && (!alastRegetDate.equals("")))
/*      */     {
/* 1465 */       this.lastRegetDate = this.fDate.getDate(alastRegetDate);
/*      */     }
/*      */     else
/* 1468 */       this.lastRegetDate = null;
/*      */   }
/*      */ 
/*      */   public String getlastEdorDate()
/*      */   {
/* 1473 */     if (this.lastEdorDate != null) {
/* 1474 */       return this.fDate.getString(this.lastEdorDate);
/*      */     }
/* 1476 */     return null;
/*      */   }
/*      */ 
/*      */   public void setlastEdorDate(Date alastEdorDate) {
/* 1480 */     this.lastEdorDate = alastEdorDate;
/*      */   }
/*      */ 
/*      */   public void setlastEdorDate(String alastEdorDate) {
/* 1484 */     if ((alastEdorDate != null) && (!alastEdorDate.equals("")))
/*      */     {
/* 1486 */       this.lastEdorDate = this.fDate.getDate(alastEdorDate);
/*      */     }
/*      */     else
/* 1489 */       this.lastEdorDate = null;
/*      */   }
/*      */ 
/*      */   public String getlastRevDate()
/*      */   {
/* 1494 */     if (this.lastRevDate != null) {
/* 1495 */       return this.fDate.getString(this.lastRevDate);
/*      */     }
/* 1497 */     return null;
/*      */   }
/*      */ 
/*      */   public void setlastRevDate(Date alastRevDate) {
/* 1501 */     this.lastRevDate = alastRevDate;
/*      */   }
/*      */ 
/*      */   public void setlastRevDate(String alastRevDate) {
/* 1505 */     if ((alastRevDate != null) && (!alastRevDate.equals("")))
/*      */     {
/* 1507 */       this.lastRevDate = this.fDate.getDate(alastRevDate);
/*      */     }
/*      */     else
/* 1510 */       this.lastRevDate = null;
/*      */   }
/*      */ 
/*      */   public String getrnewFlag()
/*      */   {
/* 1515 */     if (this.rnewFlag != null) this.rnewFlag.equals("");
/*      */ 
/* 1519 */     return this.rnewFlag;
/*      */   }
/*      */ 
/*      */   public void setrnewFlag(String arnewFlag) {
/* 1523 */     this.rnewFlag = arnewFlag;
/*      */   }
/*      */ 
/*      */   public String getstopFlag() {
/* 1527 */     if (this.stopFlag != null) this.stopFlag.equals("");
/*      */ 
/* 1531 */     return this.stopFlag;
/*      */   }
/*      */ 
/*      */   public void setstopFlag(String astopFlag) {
/* 1535 */     this.stopFlag = astopFlag;
/*      */   }
/*      */ 
/*      */   public String getexpiryFlag() {
/* 1539 */     if (this.expiryFlag != null) this.expiryFlag.equals("");
/*      */ 
/* 1543 */     return this.expiryFlag;
/*      */   }
/*      */ 
/*      */   public void setexpiryFlag(String aexpiryFlag) {
/* 1547 */     this.expiryFlag = aexpiryFlag;
/*      */   }
/*      */ 
/*      */   public String getautoPayFlag() {
/* 1551 */     if (this.autoPayFlag != null) this.autoPayFlag.equals("");
/*      */ 
/* 1555 */     return this.autoPayFlag;
/*      */   }
/*      */ 
/*      */   public void setautoPayFlag(String aautoPayFlag) {
/* 1559 */     this.autoPayFlag = aautoPayFlag;
/*      */   }
/*      */ 
/*      */   public String getinterestDifFlag() {
/* 1563 */     if (this.interestDifFlag != null) this.interestDifFlag.equals("");
/*      */ 
/* 1567 */     return this.interestDifFlag;
/*      */   }
/*      */ 
/*      */   public void setinterestDifFlag(String ainterestDifFlag) {
/* 1571 */     this.interestDifFlag = ainterestDifFlag;
/*      */   }
/*      */ 
/*      */   public String getsubFlag() {
/* 1575 */     if (this.subFlag != null) this.subFlag.equals("");
/*      */ 
/* 1579 */     return this.subFlag;
/*      */   }
/*      */ 
/*      */   public void setsubFlag(String asubFlag) {
/* 1583 */     this.subFlag = asubFlag;
/*      */   }
/*      */ 
/*      */   public String getbnfFlag() {
/* 1587 */     if (this.bnfFlag != null) this.bnfFlag.equals("");
/*      */ 
/* 1591 */     return this.bnfFlag;
/*      */   }
/*      */ 
/*      */   public void setbnfFlag(String abnfFlag) {
/* 1595 */     this.bnfFlag = abnfFlag;
/*      */   }
/*      */ 
/*      */   public String gethealthCheckFlag() {
/* 1599 */     if (this.healthCheckFlag != null) this.healthCheckFlag.equals("");
/*      */ 
/* 1603 */     return this.healthCheckFlag;
/*      */   }
/*      */ 
/*      */   public void sethealthCheckFlag(String ahealthCheckFlag) {
/* 1607 */     this.healthCheckFlag = ahealthCheckFlag;
/*      */   }
/*      */ 
/*      */   public String getimpartFlag() {
/* 1611 */     if (this.impartFlag != null) this.impartFlag.equals("");
/*      */ 
/* 1615 */     return this.impartFlag;
/*      */   }
/*      */ 
/*      */   public void setimpartFlag(String aimpartFlag) {
/* 1619 */     this.impartFlag = aimpartFlag;
/*      */   }
/*      */ 
/*      */   public String getreinsureFlag() {
/* 1623 */     if (this.reinsureFlag != null) this.reinsureFlag.equals("");
/*      */ 
/* 1627 */     return this.reinsureFlag;
/*      */   }
/*      */ 
/*      */   public void setreinsureFlag(String areinsureFlag) {
/* 1631 */     this.reinsureFlag = areinsureFlag;
/*      */   }
/*      */ 
/*      */   public String getagentPayFlag() {
/* 1635 */     if (this.agentPayFlag != null) this.agentPayFlag.equals("");
/*      */ 
/* 1639 */     return this.agentPayFlag;
/*      */   }
/*      */ 
/*      */   public void setagentPayFlag(String aagentPayFlag) {
/* 1643 */     this.agentPayFlag = aagentPayFlag;
/*      */   }
/*      */ 
/*      */   public String getagentGetFlag() {
/* 1647 */     if (this.agentGetFlag != null) this.agentGetFlag.equals("");
/*      */ 
/* 1651 */     return this.agentGetFlag;
/*      */   }
/*      */ 
/*      */   public void setagentGetFlag(String aagentGetFlag) {
/* 1655 */     this.agentGetFlag = aagentGetFlag;
/*      */   }
/*      */ 
/*      */   public String getliveGetMode() {
/* 1659 */     if (this.liveGetMode != null) this.liveGetMode.equals("");
/*      */ 
/* 1663 */     return this.liveGetMode;
/*      */   }
/*      */ 
/*      */   public void setliveGetMode(String aliveGetMode) {
/* 1667 */     this.liveGetMode = aliveGetMode;
/*      */   }
/*      */ 
/*      */   public String getdeadGetMode() {
/* 1671 */     if (this.deadGetMode != null) this.deadGetMode.equals("");
/*      */ 
/* 1675 */     return this.deadGetMode;
/*      */   }
/*      */ 
/*      */   public void setdeadGetMode(String adeadGetMode) {
/* 1679 */     this.deadGetMode = adeadGetMode;
/*      */   }
/*      */ 
/*      */   public String getbonusGetMode() {
/* 1683 */     if (this.bonusGetMode != null) this.bonusGetMode.equals("");
/*      */ 
/* 1687 */     return this.bonusGetMode;
/*      */   }
/*      */ 
/*      */   public void setbonusGetMode(String abonusGetMode) {
/* 1691 */     this.bonusGetMode = abonusGetMode;
/*      */   }
/*      */ 
/*      */   public String getdeadAmntType() {
/* 1695 */     if (this.deadAmntType != null) this.deadAmntType.equals("");
/*      */ 
/* 1699 */     return this.deadAmntType;
/*      */   }
/*      */ 
/*      */   public void setdeadAmntType(String adeadAmntType) {
/* 1703 */     this.deadAmntType = adeadAmntType;
/*      */   }
/*      */ 
/*      */   public double gettopUpPrem() {
/* 1707 */     return this.topUpPrem;
/*      */   }
/*      */ 
/*      */   public void settopUpPrem(double atopUpPrem) {
/* 1711 */     this.topUpPrem = atopUpPrem;
/*      */   }
/*      */ 
/*      */   public void settopUpPrem(String atopUpPrem) {
/* 1715 */     if ((atopUpPrem != null) && (!atopUpPrem.equals("")))
/*      */     {
/* 1717 */       Double tDouble = new Double(atopUpPrem);
/* 1718 */       double d = tDouble.doubleValue();
/* 1719 */       this.topUpPrem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getbonusMan()
/*      */   {
/* 1725 */     if (this.bonusMan != null) this.bonusMan.equals("");
/*      */ 
/* 1729 */     return this.bonusMan;
/*      */   }
/*      */ 
/*      */   public void setbonusMan(String abonusMan) {
/* 1733 */     this.bonusMan = abonusMan;
/*      */   }
/*      */ 
/*      */   public String getdeadFlag() {
/* 1737 */     if (this.deadFlag != null) this.deadFlag.equals("");
/*      */ 
/* 1741 */     return this.deadFlag;
/*      */   }
/*      */ 
/*      */   public void setdeadFlag(String adeadFlag) {
/* 1745 */     this.deadFlag = adeadFlag;
/*      */   }
/*      */ 
/*      */   public String getsmokeFlag() {
/* 1749 */     if (this.smokeFlag != null) this.smokeFlag.equals("");
/*      */ 
/* 1753 */     return this.smokeFlag;
/*      */   }
/*      */ 
/*      */   public void setsmokeFlag(String asmokeFlag) {
/* 1757 */     this.smokeFlag = asmokeFlag;
/*      */   }
/*      */ 
/*      */   public String getremark() {
/* 1761 */     if (this.remark != null) this.remark.equals("");
/*      */ 
/* 1765 */     return this.remark;
/*      */   }
/*      */ 
/*      */   public void setremark(String aremark) {
/* 1769 */     this.remark = aremark;
/*      */   }
/*      */ 
/*      */   public String getapproveFlag() {
/* 1773 */     if (this.approveFlag != null) this.approveFlag.equals("");
/*      */ 
/* 1777 */     return this.approveFlag;
/*      */   }
/*      */ 
/*      */   public void setapproveFlag(String aapproveFlag) {
/* 1781 */     this.approveFlag = aapproveFlag;
/*      */   }
/*      */ 
/*      */   public String getapproveCode() {
/* 1785 */     if (this.approveCode != null) this.approveCode.equals("");
/*      */ 
/* 1789 */     return this.approveCode;
/*      */   }
/*      */ 
/*      */   public void setapproveCode(String aapproveCode) {
/* 1793 */     this.approveCode = aapproveCode;
/*      */   }
/*      */ 
/*      */   public String getapproveDate() {
/* 1797 */     if (this.approveDate != null) {
/* 1798 */       return this.fDate.getString(this.approveDate);
/*      */     }
/* 1800 */     return null;
/*      */   }
/*      */ 
/*      */   public void setapproveDate(Date aapproveDate) {
/* 1804 */     this.approveDate = aapproveDate;
/*      */   }
/*      */ 
/*      */   public void setapproveDate(String aapproveDate) {
/* 1808 */     if ((aapproveDate != null) && (!aapproveDate.equals("")))
/*      */     {
/* 1810 */       this.approveDate = this.fDate.getDate(aapproveDate);
/*      */     }
/*      */     else
/* 1813 */       this.approveDate = null;
/*      */   }
/*      */ 
/*      */   public String getapproveTime()
/*      */   {
/* 1818 */     if (this.approveTime != null) this.approveTime.equals("");
/*      */ 
/* 1822 */     return this.approveTime;
/*      */   }
/*      */ 
/*      */   public void setapproveTime(String aapproveTime) {
/* 1826 */     this.approveTime = aapproveTime;
/*      */   }
/*      */ 
/*      */   public String getuWFlag() {
/* 1830 */     if (this.uWFlag != null) this.uWFlag.equals("");
/*      */ 
/* 1834 */     return this.uWFlag;
/*      */   }
/*      */ 
/*      */   public void setuWFlag(String auWFlag) {
/* 1838 */     this.uWFlag = auWFlag;
/*      */   }
/*      */ 
/*      */   public String getuWCode() {
/* 1842 */     if (this.uWCode != null) this.uWCode.equals("");
/*      */ 
/* 1846 */     return this.uWCode;
/*      */   }
/*      */ 
/*      */   public void setuWCode(String auWCode) {
/* 1850 */     this.uWCode = auWCode;
/*      */   }
/*      */ 
/*      */   public String getuWDate() {
/* 1854 */     if (this.uWDate != null) {
/* 1855 */       return this.fDate.getString(this.uWDate);
/*      */     }
/* 1857 */     return null;
/*      */   }
/*      */ 
/*      */   public void setuWDate(Date auWDate) {
/* 1861 */     this.uWDate = auWDate;
/*      */   }
/*      */ 
/*      */   public void setuWDate(String auWDate) {
/* 1865 */     if ((auWDate != null) && (!auWDate.equals("")))
/*      */     {
/* 1867 */       this.uWDate = this.fDate.getDate(auWDate);
/*      */     }
/*      */     else
/* 1870 */       this.uWDate = null;
/*      */   }
/*      */ 
/*      */   public String getuWTime()
/*      */   {
/* 1875 */     if (this.uWTime != null) this.uWTime.equals("");
/*      */ 
/* 1879 */     return this.uWTime;
/*      */   }
/*      */ 
/*      */   public void setuWTime(String auWTime) {
/* 1883 */     this.uWTime = auWTime;
/*      */   }
/*      */ 
/*      */   public String getpolApplyDate() {
/* 1887 */     if (this.polApplyDate != null) {
/* 1888 */       return this.fDate.getString(this.polApplyDate);
/*      */     }
/* 1890 */     return null;
/*      */   }
/*      */ 
/*      */   public void setpolApplyDate(Date apolApplyDate) {
/* 1894 */     this.polApplyDate = apolApplyDate;
/*      */   }
/*      */ 
/*      */   public void setpolApplyDate(String apolApplyDate) {
/* 1898 */     if ((apolApplyDate != null) && (!apolApplyDate.equals("")))
/*      */     {
/* 1900 */       this.polApplyDate = this.fDate.getDate(apolApplyDate);
/*      */     }
/*      */     else
/* 1903 */       this.polApplyDate = null;
/*      */   }
/*      */ 
/*      */   public String getappFlag()
/*      */   {
/* 1908 */     if (this.appFlag != null) this.appFlag.equals("");
/*      */ 
/* 1912 */     return this.appFlag;
/*      */   }
/*      */ 
/*      */   public void setappFlag(String aappFlag) {
/* 1916 */     this.appFlag = aappFlag;
/*      */   }
/*      */ 
/*      */   public String getsaleChnlDetail() {
/* 1920 */     if (this.saleChnlDetail != null) this.saleChnlDetail.equals("");
/*      */ 
/* 1924 */     return this.saleChnlDetail;
/*      */   }
/*      */ 
/*      */   public void setsaleChnlDetail(String asaleChnlDetail) {
/* 1928 */     this.saleChnlDetail = asaleChnlDetail;
/*      */   }
/*      */ 
/*      */   public String getpolState() {
/* 1932 */     if (this.polState != null) this.polState.equals("");
/*      */ 
/* 1936 */     return this.polState;
/*      */   }
/*      */ 
/*      */   public void setpolState(String apolState) {
/* 1940 */     this.polState = apolState;
/*      */   }
/*      */ 
/*      */   public String getstandbyFlag1() {
/* 1944 */     if (this.standbyFlag1 != null) this.standbyFlag1.equals("");
/*      */ 
/* 1948 */     return this.standbyFlag1;
/*      */   }
/*      */ 
/*      */   public void setstandbyFlag1(String astandbyFlag1) {
/* 1952 */     this.standbyFlag1 = astandbyFlag1;
/*      */   }
/*      */ 
/*      */   public String getstandbyFlag2() {
/* 1956 */     if (this.standbyFlag2 != null) this.standbyFlag2.equals("");
/*      */ 
/* 1960 */     return this.standbyFlag2;
/*      */   }
/*      */ 
/*      */   public void setstandbyFlag2(String astandbyFlag2) {
/* 1964 */     this.standbyFlag2 = astandbyFlag2;
/*      */   }
/*      */ 
/*      */   public String getstandbyFlag3() {
/* 1968 */     if (this.standbyFlag3 != null) this.standbyFlag3.equals("");
/*      */ 
/* 1972 */     return this.standbyFlag3;
/*      */   }
/*      */ 
/*      */   public void setstandbyFlag3(String astandbyFlag3) {
/* 1976 */     this.standbyFlag3 = astandbyFlag3;
/*      */   }
/*      */ 
/*      */   public String getoperator() {
/* 1980 */     if (this.operator != null) this.operator.equals("");
/*      */ 
/* 1984 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setoperator(String aoperator) {
/* 1988 */     this.operator = aoperator;
/*      */   }
/*      */ 
/*      */   public String getmakeDate() {
/* 1992 */     if (this.makeDate != null) {
/* 1993 */       return this.fDate.getString(this.makeDate);
/*      */     }
/* 1995 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(Date amakeDate) {
/* 1999 */     this.makeDate = amakeDate;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(String amakeDate) {
/* 2003 */     if ((amakeDate != null) && (!amakeDate.equals("")))
/*      */     {
/* 2005 */       this.makeDate = this.fDate.getDate(amakeDate);
/*      */     }
/*      */     else
/* 2008 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getmakeTime()
/*      */   {
/* 2013 */     if (this.makeTime != null) this.makeTime.equals("");
/*      */ 
/* 2017 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setmakeTime(String amakeTime) {
/* 2021 */     this.makeTime = amakeTime;
/*      */   }
/*      */ 
/*      */   public String getmodifyDate() {
/* 2025 */     if (this.modifyDate != null) {
/* 2026 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/* 2028 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(Date amodifyDate) {
/* 2032 */     this.modifyDate = amodifyDate;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(String amodifyDate) {
/* 2036 */     if ((amodifyDate != null) && (!amodifyDate.equals("")))
/*      */     {
/* 2038 */       this.modifyDate = this.fDate.getDate(amodifyDate);
/*      */     }
/*      */     else
/* 2041 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getmodifyTime()
/*      */   {
/* 2046 */     if (this.modifyTime != null) this.modifyTime.equals("");
/*      */ 
/* 2050 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setmodifyTime(String amodifyTime) {
/* 2054 */     this.modifyTime = amodifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPPolBSchema aLNPPolBSchema)
/*      */   {
/* 2060 */     this.EdorNo = aLNPPolBSchema.getEdorNo();
/* 2061 */     this.serialNo = aLNPPolBSchema.getserialNo();
/* 2062 */     this.grpContNo = aLNPPolBSchema.getgrpContNo();
/* 2063 */     this.grpPolNo = aLNPPolBSchema.getgrpPolNo();
/* 2064 */     this.contNo = aLNPPolBSchema.getcontNo();
/* 2065 */     this.proposalContNo = aLNPPolBSchema.getproposalContNo();
/* 2066 */     this.polNo = aLNPPolBSchema.getpolNo();
/* 2067 */     this.proposalNo = aLNPPolBSchema.getproposalNo();
/* 2068 */     this.prtNo = aLNPPolBSchema.getprtNo();
/* 2069 */     this.contType = aLNPPolBSchema.getcontType();
/* 2070 */     this.polTypeFlag = aLNPPolBSchema.getpolTypeFlag();
/* 2071 */     this.mainPolNo = aLNPPolBSchema.getmainPolNo();
/* 2072 */     this.masterPolNo = aLNPPolBSchema.getmasterPolNo();
/* 2073 */     this.kindCode = aLNPPolBSchema.getkindCode();
/* 2074 */     this.riskCode = aLNPPolBSchema.getriskCode();
/* 2075 */     this.riskVersion = aLNPPolBSchema.getriskVersion();
/* 2076 */     this.manageCom = aLNPPolBSchema.getmanageCom();
/* 2077 */     this.agentCom = aLNPPolBSchema.getagentCom();
/* 2078 */     this.agentType = aLNPPolBSchema.getagentType();
/* 2079 */     this.agentCode = aLNPPolBSchema.getagentCode();
/* 2080 */     this.agentGroup = aLNPPolBSchema.getagentGroup();
/* 2081 */     this.agentGroup1 = aLNPPolBSchema.getagentGroup1();
/* 2082 */     this.agentCode1 = aLNPPolBSchema.getagentCode1();
/* 2083 */     this.saleChnl = aLNPPolBSchema.getsaleChnl();
/* 2084 */     this.handler = aLNPPolBSchema.gethandler();
/* 2085 */     this.insuredNo = aLNPPolBSchema.getinsuredNo();
/* 2086 */     this.insuredId = aLNPPolBSchema.getinsuredId();
/* 2087 */     this.insuredName = aLNPPolBSchema.getinsuredName();
/* 2088 */     this.insuredSex = aLNPPolBSchema.getinsuredSex();
/* 2089 */     this.insuredBirthday = this.fDate.getDate(aLNPPolBSchema.getinsuredBirthday());
/* 2090 */     this.insuredAppAge = aLNPPolBSchema.getinsuredAppAge();
/* 2091 */     this.insuredPeoples = aLNPPolBSchema.getinsuredPeoples();
/* 2092 */     this.occupationType = aLNPPolBSchema.getoccupationType();
/* 2093 */     this.appntNo = aLNPPolBSchema.getappntNo();
/* 2094 */     this.appntName = aLNPPolBSchema.getappntName();
/* 2095 */     this.cValiDate = this.fDate.getDate(aLNPPolBSchema.getcValiDate());
/* 2096 */     this.signCom = aLNPPolBSchema.getsignCom();
/* 2097 */     this.signDate = this.fDate.getDate(aLNPPolBSchema.getsignDate());
/* 2098 */     this.signTime = aLNPPolBSchema.getsignTime();
/* 2099 */     this.firstPayDate = this.fDate.getDate(aLNPPolBSchema.getfirstPayDate());
/* 2100 */     this.payEndDate = this.fDate.getDate(aLNPPolBSchema.getpayEndDate());
/* 2101 */     this.paytoDate = this.fDate.getDate(aLNPPolBSchema.getpaytoDate());
/* 2102 */     this.getStartDate = this.fDate.getDate(aLNPPolBSchema.getgetStartDate());
/* 2103 */     this.endDate = this.fDate.getDate(aLNPPolBSchema.getendDate());
/* 2104 */     this.acciEndDate = this.fDate.getDate(aLNPPolBSchema.getacciEndDate());
/* 2105 */     this.getYearFlag = aLNPPolBSchema.getgetYearFlag();
/* 2106 */     this.getYear = aLNPPolBSchema.getgetYear();
/* 2107 */     this.payEndYearFlag = aLNPPolBSchema.getpayEndYearFlag();
/* 2108 */     this.payEndYear = aLNPPolBSchema.getpayEndYear();
/* 2109 */     this.insuYearFlag = aLNPPolBSchema.getinsuYearFlag();
/* 2110 */     this.insuYear = aLNPPolBSchema.getinsuYear();
/* 2111 */     this.acciYearFlag = aLNPPolBSchema.getacciYearFlag();
/* 2112 */     this.acciYear = aLNPPolBSchema.getacciYear();
/* 2113 */     this.getStartType = aLNPPolBSchema.getgetStartType();
/* 2114 */     this.specifyValiDate = aLNPPolBSchema.getspecifyValiDate();
/* 2115 */     this.payMode = aLNPPolBSchema.getpayMode();
/* 2116 */     this.payLocation = aLNPPolBSchema.getpayLocation();
/* 2117 */     this.payIntv = aLNPPolBSchema.getpayIntv();
/* 2118 */     this.payYears = aLNPPolBSchema.getpayYears();
/* 2119 */     this.years = aLNPPolBSchema.getyears();
/* 2120 */     this.manageFeeRate = aLNPPolBSchema.getmanageFeeRate();
/* 2121 */     this.floatRate = aLNPPolBSchema.getfloatRate();
/* 2122 */     this.premRate = aLNPPolBSchema.getpremRate();
/* 2123 */     this.premToAmnt = aLNPPolBSchema.getpremToAmnt();
/* 2124 */     this.mult = aLNPPolBSchema.getmult();
/* 2125 */     this.standPrem = aLNPPolBSchema.getstandPrem();
/* 2126 */     this.prem = aLNPPolBSchema.getprem();
/* 2127 */     this.sumPrem = aLNPPolBSchema.getsumPrem();
/* 2128 */     this.amnt = aLNPPolBSchema.getamnt();
/* 2129 */     this.riskAmnt = aLNPPolBSchema.getriskAmnt();
/* 2130 */     this.leavingMoney = aLNPPolBSchema.getleavingMoney();
/* 2131 */     this.endorseTimes = aLNPPolBSchema.getendorseTimes();
/* 2132 */     this.claimTimes = aLNPPolBSchema.getclaimTimes();
/* 2133 */     this.liveTimes = aLNPPolBSchema.getliveTimes();
/* 2134 */     this.renewCount = aLNPPolBSchema.getrenewCount();
/* 2135 */     this.lastGetDate = this.fDate.getDate(aLNPPolBSchema.getlastGetDate());
/* 2136 */     this.lastLoanDate = this.fDate.getDate(aLNPPolBSchema.getlastLoanDate());
/* 2137 */     this.lastRegetDate = this.fDate.getDate(aLNPPolBSchema.getlastRegetDate());
/* 2138 */     this.lastEdorDate = this.fDate.getDate(aLNPPolBSchema.getlastEdorDate());
/* 2139 */     this.lastRevDate = this.fDate.getDate(aLNPPolBSchema.getlastRevDate());
/* 2140 */     this.rnewFlag = aLNPPolBSchema.getrnewFlag();
/* 2141 */     this.stopFlag = aLNPPolBSchema.getstopFlag();
/* 2142 */     this.expiryFlag = aLNPPolBSchema.getexpiryFlag();
/* 2143 */     this.autoPayFlag = aLNPPolBSchema.getautoPayFlag();
/* 2144 */     this.interestDifFlag = aLNPPolBSchema.getinterestDifFlag();
/* 2145 */     this.subFlag = aLNPPolBSchema.getsubFlag();
/* 2146 */     this.bnfFlag = aLNPPolBSchema.getbnfFlag();
/* 2147 */     this.healthCheckFlag = aLNPPolBSchema.gethealthCheckFlag();
/* 2148 */     this.impartFlag = aLNPPolBSchema.getimpartFlag();
/* 2149 */     this.reinsureFlag = aLNPPolBSchema.getreinsureFlag();
/* 2150 */     this.agentPayFlag = aLNPPolBSchema.getagentPayFlag();
/* 2151 */     this.agentGetFlag = aLNPPolBSchema.getagentGetFlag();
/* 2152 */     this.liveGetMode = aLNPPolBSchema.getliveGetMode();
/* 2153 */     this.deadGetMode = aLNPPolBSchema.getdeadGetMode();
/* 2154 */     this.bonusGetMode = aLNPPolBSchema.getbonusGetMode();
/* 2155 */     this.deadAmntType = aLNPPolBSchema.getdeadAmntType();
/* 2156 */     this.topUpPrem = aLNPPolBSchema.gettopUpPrem();
/* 2157 */     this.bonusMan = aLNPPolBSchema.getbonusMan();
/* 2158 */     this.deadFlag = aLNPPolBSchema.getdeadFlag();
/* 2159 */     this.smokeFlag = aLNPPolBSchema.getsmokeFlag();
/* 2160 */     this.remark = aLNPPolBSchema.getremark();
/* 2161 */     this.approveFlag = aLNPPolBSchema.getapproveFlag();
/* 2162 */     this.approveCode = aLNPPolBSchema.getapproveCode();
/* 2163 */     this.approveDate = this.fDate.getDate(aLNPPolBSchema.getapproveDate());
/* 2164 */     this.approveTime = aLNPPolBSchema.getapproveTime();
/* 2165 */     this.uWFlag = aLNPPolBSchema.getuWFlag();
/* 2166 */     this.uWCode = aLNPPolBSchema.getuWCode();
/* 2167 */     this.uWDate = this.fDate.getDate(aLNPPolBSchema.getuWDate());
/* 2168 */     this.uWTime = aLNPPolBSchema.getuWTime();
/* 2169 */     this.polApplyDate = this.fDate.getDate(aLNPPolBSchema.getpolApplyDate());
/* 2170 */     this.appFlag = aLNPPolBSchema.getappFlag();
/* 2171 */     this.saleChnlDetail = aLNPPolBSchema.getsaleChnlDetail();
/* 2172 */     this.polState = aLNPPolBSchema.getpolState();
/* 2173 */     this.standbyFlag1 = aLNPPolBSchema.getstandbyFlag1();
/* 2174 */     this.standbyFlag2 = aLNPPolBSchema.getstandbyFlag2();
/* 2175 */     this.standbyFlag3 = aLNPPolBSchema.getstandbyFlag3();
/* 2176 */     this.operator = aLNPPolBSchema.getoperator();
/* 2177 */     this.makeDate = this.fDate.getDate(aLNPPolBSchema.getmakeDate());
/* 2178 */     this.makeTime = aLNPPolBSchema.getmakeTime();
/* 2179 */     this.modifyDate = this.fDate.getDate(aLNPPolBSchema.getmodifyDate());
/* 2180 */     this.modifyTime = aLNPPolBSchema.getmodifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/* 2189 */       if (rs.getString("EdorNo") == null)
/* 2190 */         this.EdorNo = null;
/*      */       else {
/* 2192 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/* 2194 */       if (rs.getString("serialNo") == null)
/* 2195 */         this.serialNo = null;
/*      */       else {
/* 2197 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/* 2199 */       if (rs.getString("grpContNo") == null)
/* 2200 */         this.grpContNo = null;
/*      */       else {
/* 2202 */         this.grpContNo = rs.getString("grpContNo").trim();
/*      */       }
/* 2204 */       if (rs.getString("grpPolNo") == null)
/* 2205 */         this.grpPolNo = null;
/*      */       else {
/* 2207 */         this.grpPolNo = rs.getString("grpPolNo").trim();
/*      */       }
/* 2209 */       if (rs.getString("contNo") == null)
/* 2210 */         this.contNo = null;
/*      */       else {
/* 2212 */         this.contNo = rs.getString("contNo").trim();
/*      */       }
/* 2214 */       if (rs.getString("proposalContNo") == null)
/* 2215 */         this.proposalContNo = null;
/*      */       else {
/* 2217 */         this.proposalContNo = rs.getString("proposalContNo").trim();
/*      */       }
/* 2219 */       if (rs.getString("polNo") == null)
/* 2220 */         this.polNo = null;
/*      */       else {
/* 2222 */         this.polNo = rs.getString("polNo").trim();
/*      */       }
/* 2224 */       if (rs.getString("proposalNo") == null)
/* 2225 */         this.proposalNo = null;
/*      */       else {
/* 2227 */         this.proposalNo = rs.getString("proposalNo").trim();
/*      */       }
/* 2229 */       if (rs.getString("prtNo") == null)
/* 2230 */         this.prtNo = null;
/*      */       else {
/* 2232 */         this.prtNo = rs.getString("prtNo").trim();
/*      */       }
/* 2234 */       if (rs.getString("contType") == null)
/* 2235 */         this.contType = null;
/*      */       else {
/* 2237 */         this.contType = rs.getString("contType").trim();
/*      */       }
/* 2239 */       if (rs.getString("polTypeFlag") == null)
/* 2240 */         this.polTypeFlag = null;
/*      */       else {
/* 2242 */         this.polTypeFlag = rs.getString("polTypeFlag").trim();
/*      */       }
/* 2244 */       if (rs.getString("mainPolNo") == null)
/* 2245 */         this.mainPolNo = null;
/*      */       else {
/* 2247 */         this.mainPolNo = rs.getString("mainPolNo").trim();
/*      */       }
/* 2249 */       if (rs.getString("masterPolNo") == null)
/* 2250 */         this.masterPolNo = null;
/*      */       else {
/* 2252 */         this.masterPolNo = rs.getString("masterPolNo").trim();
/*      */       }
/* 2254 */       if (rs.getString("kindCode") == null)
/* 2255 */         this.kindCode = null;
/*      */       else {
/* 2257 */         this.kindCode = rs.getString("kindCode").trim();
/*      */       }
/* 2259 */       if (rs.getString("riskCode") == null)
/* 2260 */         this.riskCode = null;
/*      */       else {
/* 2262 */         this.riskCode = rs.getString("riskCode").trim();
/*      */       }
/* 2264 */       if (rs.getString("riskVersion") == null)
/* 2265 */         this.riskVersion = null;
/*      */       else {
/* 2267 */         this.riskVersion = rs.getString("riskVersion").trim();
/*      */       }
/* 2269 */       if (rs.getString("manageCom") == null)
/* 2270 */         this.manageCom = null;
/*      */       else {
/* 2272 */         this.manageCom = rs.getString("manageCom").trim();
/*      */       }
/* 2274 */       if (rs.getString("agentCom") == null)
/* 2275 */         this.agentCom = null;
/*      */       else {
/* 2277 */         this.agentCom = rs.getString("agentCom").trim();
/*      */       }
/* 2279 */       if (rs.getString("agentType") == null)
/* 2280 */         this.agentType = null;
/*      */       else {
/* 2282 */         this.agentType = rs.getString("agentType").trim();
/*      */       }
/* 2284 */       if (rs.getString("agentCode") == null)
/* 2285 */         this.agentCode = null;
/*      */       else {
/* 2287 */         this.agentCode = rs.getString("agentCode").trim();
/*      */       }
/* 2289 */       if (rs.getString("agentGroup") == null)
/* 2290 */         this.agentGroup = null;
/*      */       else {
/* 2292 */         this.agentGroup = rs.getString("agentGroup").trim();
/*      */       }
/* 2294 */       if (rs.getString("agentGroup1") == null)
/* 2295 */         this.agentGroup1 = null;
/*      */       else {
/* 2297 */         this.agentGroup1 = rs.getString("agentGroup1").trim();
/*      */       }
/* 2299 */       if (rs.getString("agentCode1") == null)
/* 2300 */         this.agentCode1 = null;
/*      */       else {
/* 2302 */         this.agentCode1 = rs.getString("agentCode1").trim();
/*      */       }
/* 2304 */       if (rs.getString("saleChnl") == null)
/* 2305 */         this.saleChnl = null;
/*      */       else {
/* 2307 */         this.saleChnl = rs.getString("saleChnl").trim();
/*      */       }
/* 2309 */       if (rs.getString("handler") == null)
/* 2310 */         this.handler = null;
/*      */       else {
/* 2312 */         this.handler = rs.getString("handler").trim();
/*      */       }
/* 2314 */       if (rs.getString("insuredNo") == null)
/* 2315 */         this.insuredNo = null;
/*      */       else {
/* 2317 */         this.insuredNo = rs.getString("insuredNo").trim();
/*      */       }
/* 2319 */       if (rs.getString("insuredId") == null)
/* 2320 */         this.insuredId = null;
/*      */       else {
/* 2322 */         this.insuredId = rs.getString("insuredId").trim();
/*      */       }
/* 2324 */       if (rs.getString("insuredName") == null)
/* 2325 */         this.insuredName = null;
/*      */       else {
/* 2327 */         this.insuredName = rs.getString("insuredName").trim();
/*      */       }
/* 2329 */       if (rs.getString("insuredSex") == null)
/* 2330 */         this.insuredSex = null;
/*      */       else {
/* 2332 */         this.insuredSex = rs.getString("insuredSex").trim();
/*      */       }
/* 2334 */       this.insuredBirthday = rs.getDate("insuredBirthday");
/* 2335 */       this.insuredAppAge = rs.getInt("insuredAppAge");
/* 2336 */       this.insuredPeoples = rs.getInt("insuredPeoples");
/* 2337 */       if (rs.getString("occupationType") == null)
/* 2338 */         this.occupationType = null;
/*      */       else {
/* 2340 */         this.occupationType = rs.getString("occupationType").trim();
/*      */       }
/* 2342 */       if (rs.getString("appntNo") == null)
/* 2343 */         this.appntNo = null;
/*      */       else {
/* 2345 */         this.appntNo = rs.getString("appntNo").trim();
/*      */       }
/* 2347 */       if (rs.getString("appntName") == null)
/* 2348 */         this.appntName = null;
/*      */       else {
/* 2350 */         this.appntName = rs.getString("appntName").trim();
/*      */       }
/* 2352 */       this.cValiDate = rs.getDate("cValiDate");
/* 2353 */       if (rs.getString("signCom") == null)
/* 2354 */         this.signCom = null;
/*      */       else {
/* 2356 */         this.signCom = rs.getString("signCom").trim();
/*      */       }
/* 2358 */       this.signDate = rs.getDate("signDate");
/* 2359 */       if (rs.getString("signTime") == null)
/* 2360 */         this.signTime = null;
/*      */       else {
/* 2362 */         this.signTime = rs.getString("signTime").trim();
/*      */       }
/* 2364 */       this.firstPayDate = rs.getDate("firstPayDate");
/* 2365 */       this.payEndDate = rs.getDate("payEndDate");
/* 2366 */       this.paytoDate = rs.getDate("paytoDate");
/* 2367 */       this.getStartDate = rs.getDate("getStartDate");
/* 2368 */       this.endDate = rs.getDate("endDate");
/* 2369 */       this.acciEndDate = rs.getDate("acciEndDate");
/* 2370 */       if (rs.getString("getYearFlag") == null)
/* 2371 */         this.getYearFlag = null;
/*      */       else {
/* 2373 */         this.getYearFlag = rs.getString("getYearFlag").trim();
/*      */       }
/* 2375 */       this.getYear = rs.getInt("getYear");
/* 2376 */       if (rs.getString("payEndYearFlag") == null)
/* 2377 */         this.payEndYearFlag = null;
/*      */       else {
/* 2379 */         this.payEndYearFlag = rs.getString("payEndYearFlag").trim();
/*      */       }
/* 2381 */       this.payEndYear = rs.getInt("payEndYear");
/* 2382 */       if (rs.getString("insuYearFlag") == null)
/* 2383 */         this.insuYearFlag = null;
/*      */       else {
/* 2385 */         this.insuYearFlag = rs.getString("insuYearFlag").trim();
/*      */       }
/* 2387 */       this.insuYear = rs.getInt("insuYear");
/* 2388 */       if (rs.getString("acciYearFlag") == null)
/* 2389 */         this.acciYearFlag = null;
/*      */       else {
/* 2391 */         this.acciYearFlag = rs.getString("acciYearFlag").trim();
/*      */       }
/* 2393 */       this.acciYear = rs.getInt("acciYear");
/* 2394 */       if (rs.getString("getStartType") == null)
/* 2395 */         this.getStartType = null;
/*      */       else {
/* 2397 */         this.getStartType = rs.getString("getStartType").trim();
/*      */       }
/* 2399 */       if (rs.getString("specifyValiDate") == null)
/* 2400 */         this.specifyValiDate = null;
/*      */       else {
/* 2402 */         this.specifyValiDate = rs.getString("specifyValiDate").trim();
/*      */       }
/* 2404 */       if (rs.getString("payMode") == null)
/* 2405 */         this.payMode = null;
/*      */       else {
/* 2407 */         this.payMode = rs.getString("payMode").trim();
/*      */       }
/* 2409 */       if (rs.getString("payLocation") == null)
/* 2410 */         this.payLocation = null;
/*      */       else {
/* 2412 */         this.payLocation = rs.getString("payLocation").trim();
/*      */       }
/* 2414 */       this.payIntv = rs.getInt("payIntv");
/* 2415 */       this.payYears = rs.getInt("payYears");
/* 2416 */       this.years = rs.getInt("years");
/* 2417 */       this.manageFeeRate = rs.getDouble("manageFeeRate");
/* 2418 */       this.floatRate = rs.getDouble("floatRate");
/* 2419 */       this.premRate = rs.getDouble("premRate");
/* 2420 */       if (rs.getString("premToAmnt") == null)
/* 2421 */         this.premToAmnt = null;
/*      */       else {
/* 2423 */         this.premToAmnt = rs.getString("premToAmnt").trim();
/*      */       }
/* 2425 */       this.mult = rs.getDouble("mult");
/* 2426 */       this.standPrem = rs.getDouble("standPrem");
/* 2427 */       this.prem = rs.getDouble("prem");
/* 2428 */       this.sumPrem = rs.getDouble("sumPrem");
/* 2429 */       this.amnt = rs.getDouble("amnt");
/* 2430 */       this.riskAmnt = rs.getDouble("riskAmnt");
/* 2431 */       this.leavingMoney = rs.getDouble("leavingMoney");
/* 2432 */       this.endorseTimes = rs.getInt("endorseTimes");
/* 2433 */       this.claimTimes = rs.getInt("claimTimes");
/* 2434 */       this.liveTimes = rs.getInt("liveTimes");
/* 2435 */       this.renewCount = rs.getInt("renewCount");
/* 2436 */       this.lastGetDate = rs.getDate("lastGetDate");
/* 2437 */       this.lastLoanDate = rs.getDate("lastLoanDate");
/* 2438 */       this.lastRegetDate = rs.getDate("lastRegetDate");
/* 2439 */       this.lastEdorDate = rs.getDate("lastEdorDate");
/* 2440 */       this.lastRevDate = rs.getDate("lastRevDate");
/* 2441 */       if (rs.getString("rnewFlag") == null)
/* 2442 */         this.rnewFlag = null;
/*      */       else {
/* 2444 */         this.rnewFlag = rs.getString("rnewFlag").trim();
/*      */       }
/* 2446 */       if (rs.getString("stopFlag") == null)
/* 2447 */         this.stopFlag = null;
/*      */       else {
/* 2449 */         this.stopFlag = rs.getString("stopFlag").trim();
/*      */       }
/* 2451 */       if (rs.getString("expiryFlag") == null)
/* 2452 */         this.expiryFlag = null;
/*      */       else {
/* 2454 */         this.expiryFlag = rs.getString("expiryFlag").trim();
/*      */       }
/* 2456 */       if (rs.getString("autoPayFlag") == null)
/* 2457 */         this.autoPayFlag = null;
/*      */       else {
/* 2459 */         this.autoPayFlag = rs.getString("autoPayFlag").trim();
/*      */       }
/* 2461 */       if (rs.getString("interestDifFlag") == null)
/* 2462 */         this.interestDifFlag = null;
/*      */       else {
/* 2464 */         this.interestDifFlag = rs.getString("interestDifFlag").trim();
/*      */       }
/* 2466 */       if (rs.getString("subFlag") == null)
/* 2467 */         this.subFlag = null;
/*      */       else {
/* 2469 */         this.subFlag = rs.getString("subFlag").trim();
/*      */       }
/* 2471 */       if (rs.getString("bnfFlag") == null)
/* 2472 */         this.bnfFlag = null;
/*      */       else {
/* 2474 */         this.bnfFlag = rs.getString("bnfFlag").trim();
/*      */       }
/* 2476 */       if (rs.getString("healthCheckFlag") == null)
/* 2477 */         this.healthCheckFlag = null;
/*      */       else {
/* 2479 */         this.healthCheckFlag = rs.getString("healthCheckFlag").trim();
/*      */       }
/* 2481 */       if (rs.getString("impartFlag") == null)
/* 2482 */         this.impartFlag = null;
/*      */       else {
/* 2484 */         this.impartFlag = rs.getString("impartFlag").trim();
/*      */       }
/* 2486 */       if (rs.getString("reinsureFlag") == null)
/* 2487 */         this.reinsureFlag = null;
/*      */       else {
/* 2489 */         this.reinsureFlag = rs.getString("reinsureFlag").trim();
/*      */       }
/* 2491 */       if (rs.getString("agentPayFlag") == null)
/* 2492 */         this.agentPayFlag = null;
/*      */       else {
/* 2494 */         this.agentPayFlag = rs.getString("agentPayFlag").trim();
/*      */       }
/* 2496 */       if (rs.getString("agentGetFlag") == null)
/* 2497 */         this.agentGetFlag = null;
/*      */       else {
/* 2499 */         this.agentGetFlag = rs.getString("agentGetFlag").trim();
/*      */       }
/* 2501 */       if (rs.getString("liveGetMode") == null)
/* 2502 */         this.liveGetMode = null;
/*      */       else {
/* 2504 */         this.liveGetMode = rs.getString("liveGetMode").trim();
/*      */       }
/* 2506 */       if (rs.getString("deadGetMode") == null)
/* 2507 */         this.deadGetMode = null;
/*      */       else {
/* 2509 */         this.deadGetMode = rs.getString("deadGetMode").trim();
/*      */       }
/* 2511 */       if (rs.getString("bonusGetMode") == null)
/* 2512 */         this.bonusGetMode = null;
/*      */       else {
/* 2514 */         this.bonusGetMode = rs.getString("bonusGetMode").trim();
/*      */       }
/* 2516 */       if (rs.getString("deadAmntType") == null)
/* 2517 */         this.deadAmntType = null;
/*      */       else {
/* 2519 */         this.deadAmntType = rs.getString("deadAmntType").trim();
/*      */       }
/* 2521 */       this.topUpPrem = rs.getDouble("topUpPrem");
/* 2522 */       if (rs.getString("bonusMan") == null)
/* 2523 */         this.bonusMan = null;
/*      */       else {
/* 2525 */         this.bonusMan = rs.getString("bonusMan").trim();
/*      */       }
/* 2527 */       if (rs.getString("deadFlag") == null)
/* 2528 */         this.deadFlag = null;
/*      */       else {
/* 2530 */         this.deadFlag = rs.getString("deadFlag").trim();
/*      */       }
/* 2532 */       if (rs.getString("smokeFlag") == null)
/* 2533 */         this.smokeFlag = null;
/*      */       else {
/* 2535 */         this.smokeFlag = rs.getString("smokeFlag").trim();
/*      */       }
/* 2537 */       if (rs.getString("remark") == null)
/* 2538 */         this.remark = null;
/*      */       else {
/* 2540 */         this.remark = rs.getString("remark").trim();
/*      */       }
/* 2542 */       if (rs.getString("approveFlag") == null)
/* 2543 */         this.approveFlag = null;
/*      */       else {
/* 2545 */         this.approveFlag = rs.getString("approveFlag").trim();
/*      */       }
/* 2547 */       if (rs.getString("approveCode") == null)
/* 2548 */         this.approveCode = null;
/*      */       else {
/* 2550 */         this.approveCode = rs.getString("approveCode").trim();
/*      */       }
/* 2552 */       this.approveDate = rs.getDate("approveDate");
/* 2553 */       if (rs.getString("approveTime") == null)
/* 2554 */         this.approveTime = null;
/*      */       else {
/* 2556 */         this.approveTime = rs.getString("approveTime").trim();
/*      */       }
/* 2558 */       if (rs.getString("uWFlag") == null)
/* 2559 */         this.uWFlag = null;
/*      */       else {
/* 2561 */         this.uWFlag = rs.getString("uWFlag").trim();
/*      */       }
/* 2563 */       if (rs.getString("uWCode") == null)
/* 2564 */         this.uWCode = null;
/*      */       else {
/* 2566 */         this.uWCode = rs.getString("uWCode").trim();
/*      */       }
/* 2568 */       this.uWDate = rs.getDate("uWDate");
/* 2569 */       if (rs.getString("uWTime") == null)
/* 2570 */         this.uWTime = null;
/*      */       else {
/* 2572 */         this.uWTime = rs.getString("uWTime").trim();
/*      */       }
/* 2574 */       this.polApplyDate = rs.getDate("polApplyDate");
/* 2575 */       if (rs.getString("appFlag") == null)
/* 2576 */         this.appFlag = null;
/*      */       else {
/* 2578 */         this.appFlag = rs.getString("appFlag").trim();
/*      */       }
/* 2580 */       if (rs.getString("saleChnlDetail") == null)
/* 2581 */         this.saleChnlDetail = null;
/*      */       else {
/* 2583 */         this.saleChnlDetail = rs.getString("saleChnlDetail").trim();
/*      */       }
/* 2585 */       if (rs.getString("polState") == null)
/* 2586 */         this.polState = null;
/*      */       else {
/* 2588 */         this.polState = rs.getString("polState").trim();
/*      */       }
/* 2590 */       if (rs.getString("standbyFlag1") == null)
/* 2591 */         this.standbyFlag1 = null;
/*      */       else {
/* 2593 */         this.standbyFlag1 = rs.getString("standbyFlag1").trim();
/*      */       }
/* 2595 */       if (rs.getString("standbyFlag2") == null)
/* 2596 */         this.standbyFlag2 = null;
/*      */       else {
/* 2598 */         this.standbyFlag2 = rs.getString("standbyFlag2").trim();
/*      */       }
/* 2600 */       if (rs.getString("standbyFlag3") == null)
/* 2601 */         this.standbyFlag3 = null;
/*      */       else {
/* 2603 */         this.standbyFlag3 = rs.getString("standbyFlag3").trim();
/*      */       }
/* 2605 */       if (rs.getString("operator") == null)
/* 2606 */         this.operator = null;
/*      */       else {
/* 2608 */         this.operator = rs.getString("operator").trim();
/*      */       }
/* 2610 */       this.makeDate = rs.getDate("makeDate");
/* 2611 */       if (rs.getString("makeTime") == null)
/* 2612 */         this.makeTime = null;
/*      */       else {
/* 2614 */         this.makeTime = rs.getString("makeTime").trim();
/*      */       }
/* 2616 */       this.modifyDate = rs.getDate("modifyDate");
/* 2617 */       if (rs.getString("modifyTime") == null)
/* 2618 */         this.modifyTime = null;
/*      */       else {
/* 2620 */         this.modifyTime = rs.getString("modifyTime").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 2626 */       CError tError = new CError();
/* 2627 */       tError.moduleName = "LNPPolBSchema";
/* 2628 */       tError.functionName = "setSchema";
/* 2629 */       tError.errorMessage = sqle.toString();
/* 2630 */       this.mErrors.addOneError(tError);
/*      */ 
/* 2632 */       return false;
/*      */     }
/* 2634 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPPolBSchema getSchema()
/*      */   {
/* 2639 */     LNPPolBSchema aLNPPolBSchema = new LNPPolBSchema();
/* 2640 */     aLNPPolBSchema.setSchema(this);
/* 2641 */     return aLNPPolBSchema;
/*      */   }
/*      */ 
/*      */   public LNPPolBDB getDB()
/*      */   {
/* 2646 */     LNPPolBDB aDBOper = new LNPPolBDB();
/* 2647 */     aDBOper.setSchema(this);
/* 2648 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 2655 */     String strReturn = "";
/* 2656 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/* 2657 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/* 2658 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpContNo)) + "|" + 
/* 2659 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpPolNo)) + "|" + 
/* 2660 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contNo)) + "|" + 
/* 2661 */       StrTool.cTrim(StrTool.unicodeToGBK(this.proposalContNo)) + "|" + 
/* 2662 */       StrTool.cTrim(StrTool.unicodeToGBK(this.polNo)) + "|" + 
/* 2663 */       StrTool.cTrim(StrTool.unicodeToGBK(this.proposalNo)) + "|" + 
/* 2664 */       StrTool.cTrim(StrTool.unicodeToGBK(this.prtNo)) + "|" + 
/* 2665 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contType)) + "|" + 
/* 2666 */       StrTool.cTrim(StrTool.unicodeToGBK(this.polTypeFlag)) + "|" + 
/* 2667 */       StrTool.cTrim(StrTool.unicodeToGBK(this.mainPolNo)) + "|" + 
/* 2668 */       StrTool.cTrim(StrTool.unicodeToGBK(this.masterPolNo)) + "|" + 
/* 2669 */       StrTool.cTrim(StrTool.unicodeToGBK(this.kindCode)) + "|" + 
/* 2670 */       StrTool.cTrim(StrTool.unicodeToGBK(this.riskCode)) + "|" + 
/* 2671 */       StrTool.cTrim(StrTool.unicodeToGBK(this.riskVersion)) + "|" + 
/* 2672 */       StrTool.cTrim(StrTool.unicodeToGBK(this.manageCom)) + "|" + 
/* 2673 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentCom)) + "|" + 
/* 2674 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentType)) + "|" + 
/* 2675 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentCode)) + "|" + 
/* 2676 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentGroup)) + "|" + 
/* 2677 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentGroup1)) + "|" + 
/* 2678 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentCode1)) + "|" + 
/* 2679 */       StrTool.cTrim(StrTool.unicodeToGBK(this.saleChnl)) + "|" + 
/* 2680 */       StrTool.cTrim(StrTool.unicodeToGBK(this.handler)) + "|" + 
/* 2681 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredNo)) + "|" + 
/* 2682 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredId)) + "|" + 
/* 2683 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredName)) + "|" + 
/* 2684 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredSex)) + "|" + 
/* 2685 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.insuredBirthday))) + "|" + 
/* 2686 */       ChgData.chgData(this.insuredAppAge) + "|" + 
/* 2687 */       ChgData.chgData(this.insuredPeoples) + "|" + 
/* 2688 */       StrTool.cTrim(StrTool.unicodeToGBK(this.occupationType)) + "|" + 
/* 2689 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntNo)) + "|" + 
/* 2690 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntName)) + "|" + 
/* 2691 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.cValiDate))) + "|" + 
/* 2692 */       StrTool.cTrim(StrTool.unicodeToGBK(this.signCom)) + "|" + 
/* 2693 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.signDate))) + "|" + 
/* 2694 */       StrTool.cTrim(StrTool.unicodeToGBK(this.signTime)) + "|" + 
/* 2695 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.firstPayDate))) + "|" + 
/* 2696 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.payEndDate))) + "|" + 
/* 2697 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.paytoDate))) + "|" + 
/* 2698 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.getStartDate))) + "|" + 
/* 2699 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.endDate))) + "|" + 
/* 2700 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.acciEndDate))) + "|" + 
/* 2701 */       StrTool.cTrim(StrTool.unicodeToGBK(this.getYearFlag)) + "|" + 
/* 2702 */       ChgData.chgData(this.getYear) + "|" + 
/* 2703 */       StrTool.cTrim(StrTool.unicodeToGBK(this.payEndYearFlag)) + "|" + 
/* 2704 */       ChgData.chgData(this.payEndYear) + "|" + 
/* 2705 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuYearFlag)) + "|" + 
/* 2706 */       ChgData.chgData(this.insuYear) + "|" + 
/* 2707 */       StrTool.cTrim(StrTool.unicodeToGBK(this.acciYearFlag)) + "|" + 
/* 2708 */       ChgData.chgData(this.acciYear) + "|" + 
/* 2709 */       StrTool.cTrim(StrTool.unicodeToGBK(this.getStartType)) + "|" + 
/* 2710 */       StrTool.cTrim(StrTool.unicodeToGBK(this.specifyValiDate)) + "|" + 
/* 2711 */       StrTool.cTrim(StrTool.unicodeToGBK(this.payMode)) + "|" + 
/* 2712 */       StrTool.cTrim(StrTool.unicodeToGBK(this.payLocation)) + "|" + 
/* 2713 */       ChgData.chgData(this.payIntv) + "|" + 
/* 2714 */       ChgData.chgData(this.payYears) + "|" + 
/* 2715 */       ChgData.chgData(this.years) + "|" + 
/* 2716 */       ChgData.chgData(this.manageFeeRate) + "|" + 
/* 2717 */       ChgData.chgData(this.floatRate) + "|" + 
/* 2718 */       ChgData.chgData(this.premRate) + "|" + 
/* 2719 */       StrTool.cTrim(StrTool.unicodeToGBK(this.premToAmnt)) + "|" + 
/* 2720 */       ChgData.chgData(this.mult) + "|" + 
/* 2721 */       ChgData.chgData(this.standPrem) + "|" + 
/* 2722 */       ChgData.chgData(this.prem) + "|" + 
/* 2723 */       ChgData.chgData(this.sumPrem) + "|" + 
/* 2724 */       ChgData.chgData(this.amnt) + "|" + 
/* 2725 */       ChgData.chgData(this.riskAmnt) + "|" + 
/* 2726 */       ChgData.chgData(this.leavingMoney) + "|" + 
/* 2727 */       ChgData.chgData(this.endorseTimes) + "|" + 
/* 2728 */       ChgData.chgData(this.claimTimes) + "|" + 
/* 2729 */       ChgData.chgData(this.liveTimes) + "|" + 
/* 2730 */       ChgData.chgData(this.renewCount) + "|" + 
/* 2731 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.lastGetDate))) + "|" + 
/* 2732 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.lastLoanDate))) + "|" + 
/* 2733 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.lastRegetDate))) + "|" + 
/* 2734 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.lastEdorDate))) + "|" + 
/* 2735 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.lastRevDate))) + "|" + 
/* 2736 */       StrTool.cTrim(StrTool.unicodeToGBK(this.rnewFlag)) + "|" + 
/* 2737 */       StrTool.cTrim(StrTool.unicodeToGBK(this.stopFlag)) + "|" + 
/* 2738 */       StrTool.cTrim(StrTool.unicodeToGBK(this.expiryFlag)) + "|" + 
/* 2739 */       StrTool.cTrim(StrTool.unicodeToGBK(this.autoPayFlag)) + "|" + 
/* 2740 */       StrTool.cTrim(StrTool.unicodeToGBK(this.interestDifFlag)) + "|" + 
/* 2741 */       StrTool.cTrim(StrTool.unicodeToGBK(this.subFlag)) + "|" + 
/* 2742 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bnfFlag)) + "|" + 
/* 2743 */       StrTool.cTrim(StrTool.unicodeToGBK(this.healthCheckFlag)) + "|" + 
/* 2744 */       StrTool.cTrim(StrTool.unicodeToGBK(this.impartFlag)) + "|" + 
/* 2745 */       StrTool.cTrim(StrTool.unicodeToGBK(this.reinsureFlag)) + "|" + 
/* 2746 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentPayFlag)) + "|" + 
/* 2747 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentGetFlag)) + "|" + 
/* 2748 */       StrTool.cTrim(StrTool.unicodeToGBK(this.liveGetMode)) + "|" + 
/* 2749 */       StrTool.cTrim(StrTool.unicodeToGBK(this.deadGetMode)) + "|" + 
/* 2750 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bonusGetMode)) + "|" + 
/* 2751 */       StrTool.cTrim(StrTool.unicodeToGBK(this.deadAmntType)) + "|" + 
/* 2752 */       ChgData.chgData(this.topUpPrem) + "|" + 
/* 2753 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bonusMan)) + "|" + 
/* 2754 */       StrTool.cTrim(StrTool.unicodeToGBK(this.deadFlag)) + "|" + 
/* 2755 */       StrTool.cTrim(StrTool.unicodeToGBK(this.smokeFlag)) + "|" + 
/* 2756 */       StrTool.cTrim(StrTool.unicodeToGBK(this.remark)) + "|" + 
/* 2757 */       StrTool.cTrim(StrTool.unicodeToGBK(this.approveFlag)) + "|" + 
/* 2758 */       StrTool.cTrim(StrTool.unicodeToGBK(this.approveCode)) + "|" + 
/* 2759 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.approveDate))) + "|" + 
/* 2760 */       StrTool.cTrim(StrTool.unicodeToGBK(this.approveTime)) + "|" + 
/* 2761 */       StrTool.cTrim(StrTool.unicodeToGBK(this.uWFlag)) + "|" + 
/* 2762 */       StrTool.cTrim(StrTool.unicodeToGBK(this.uWCode)) + "|" + 
/* 2763 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.uWDate))) + "|" + 
/* 2764 */       StrTool.cTrim(StrTool.unicodeToGBK(this.uWTime)) + "|" + 
/* 2765 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.polApplyDate))) + "|" + 
/* 2766 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appFlag)) + "|" + 
/* 2767 */       StrTool.cTrim(StrTool.unicodeToGBK(this.saleChnlDetail)) + "|" + 
/* 2768 */       StrTool.cTrim(StrTool.unicodeToGBK(this.polState)) + "|" + 
/* 2769 */       StrTool.cTrim(StrTool.unicodeToGBK(this.standbyFlag1)) + "|" + 
/* 2770 */       StrTool.cTrim(StrTool.unicodeToGBK(this.standbyFlag2)) + "|" + 
/* 2771 */       StrTool.cTrim(StrTool.unicodeToGBK(this.standbyFlag3)) + "|" + 
/* 2772 */       StrTool.cTrim(StrTool.unicodeToGBK(this.operator)) + "|" + 
/* 2773 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makeDate))) + "|" + 
/* 2774 */       StrTool.cTrim(StrTool.unicodeToGBK(this.makeTime)) + "|" + 
/* 2775 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifyDate))) + "|" + 
/* 2776 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifyTime));
/* 2777 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 2785 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 2786 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 2787 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 2788 */       this.grpPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 2789 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 2790 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 2791 */       this.polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 2792 */       this.proposalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 2793 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 2794 */       this.contType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 2795 */       this.polTypeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 2796 */       this.mainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 2797 */       this.masterPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 2798 */       this.kindCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 2799 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 2800 */       this.riskVersion = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 2801 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 2802 */       this.agentCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 2803 */       this.agentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 2804 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 2805 */       this.agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 2806 */       this.agentGroup1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 2807 */       this.agentCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 2808 */       this.saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 2809 */       this.handler = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 2810 */       this.insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 2811 */       this.insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 2812 */       this.insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 2813 */       this.insuredSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 2814 */       this.insuredBirthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|"));
/* 2815 */       this.insuredAppAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|"))).intValue();
/* 2816 */       this.insuredPeoples = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|"))).intValue();
/* 2817 */       this.occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 2818 */       this.appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/* 2819 */       this.appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 2820 */       this.cValiDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|"));
/* 2821 */       this.signCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 2822 */       this.signDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|"));
/* 2823 */       this.signTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/* 2824 */       this.firstPayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|"));
/* 2825 */       this.payEndDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|"));
/* 2826 */       this.paytoDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|"));
/* 2827 */       this.getStartDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|"));
/* 2828 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|"));
/* 2829 */       this.acciEndDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|"));
/* 2830 */       this.getYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/* 2831 */       this.getYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 47, "|"))).intValue();
/* 2832 */       this.payEndYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 2833 */       this.payEndYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 49, "|"))).intValue();
/* 2834 */       this.insuYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
/* 2835 */       this.insuYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 51, "|"))).intValue();
/* 2836 */       this.acciYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
/* 2837 */       this.acciYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 53, "|"))).intValue();
/* 2838 */       this.getStartType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
/* 2839 */       this.specifyValiDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
/* 2840 */       this.payMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
/* 2841 */       this.payLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, "|");
/* 2842 */       this.payIntv = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|"))).intValue();
/* 2843 */       this.payYears = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|"))).intValue();
/* 2844 */       this.years = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|"))).intValue();
/* 2845 */       this.manageFeeRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|"))).doubleValue();
/* 2846 */       this.floatRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 62, "|"))).doubleValue();
/* 2847 */       this.premRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 63, "|"))).doubleValue();
/* 2848 */       this.premToAmnt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 64, "|");
/* 2849 */       this.mult = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 65, "|"))).doubleValue();
/* 2850 */       this.standPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 66, "|"))).doubleValue();
/* 2851 */       this.prem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 67, "|"))).doubleValue();
/* 2852 */       this.sumPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 68, "|"))).doubleValue();
/* 2853 */       this.amnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 69, "|"))).doubleValue();
/* 2854 */       this.riskAmnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 70, "|"))).doubleValue();
/* 2855 */       this.leavingMoney = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 71, "|"))).doubleValue();
/* 2856 */       this.endorseTimes = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 72, "|"))).intValue();
/* 2857 */       this.claimTimes = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 73, "|"))).intValue();
/* 2858 */       this.liveTimes = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 74, "|"))).intValue();
/* 2859 */       this.renewCount = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 75, "|"))).intValue();
/* 2860 */       this.lastGetDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 76, "|"));
/* 2861 */       this.lastLoanDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 77, "|"));
/* 2862 */       this.lastRegetDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 78, "|"));
/* 2863 */       this.lastEdorDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 79, "|"));
/* 2864 */       this.lastRevDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 80, "|"));
/* 2865 */       this.rnewFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 81, "|");
/* 2866 */       this.stopFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 82, "|");
/* 2867 */       this.expiryFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 83, "|");
/* 2868 */       this.autoPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 84, "|");
/* 2869 */       this.interestDifFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 85, "|");
/* 2870 */       this.subFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 86, "|");
/* 2871 */       this.bnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 87, "|");
/* 2872 */       this.healthCheckFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 88, "|");
/* 2873 */       this.impartFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 89, "|");
/* 2874 */       this.reinsureFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 90, "|");
/* 2875 */       this.agentPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 91, "|");
/* 2876 */       this.agentGetFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 92, "|");
/* 2877 */       this.liveGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 93, "|");
/* 2878 */       this.deadGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 94, "|");
/* 2879 */       this.bonusGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 95, "|");
/* 2880 */       this.deadAmntType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 96, "|");
/* 2881 */       this.topUpPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 97, "|"))).doubleValue();
/* 2882 */       this.bonusMan = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 98, "|");
/* 2883 */       this.deadFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 99, "|");
/* 2884 */       this.smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 100, "|");
/* 2885 */       this.remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 101, "|");
/* 2886 */       this.approveFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 102, "|");
/* 2887 */       this.approveCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 103, "|");
/* 2888 */       this.approveDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 104, "|"));
/* 2889 */       this.approveTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 105, "|");
/* 2890 */       this.uWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 106, "|");
/* 2891 */       this.uWCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 107, "|");
/* 2892 */       this.uWDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 108, "|"));
/* 2893 */       this.uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 109, "|");
/* 2894 */       this.polApplyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 110, "|"));
/* 2895 */       this.appFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 111, "|");
/* 2896 */       this.saleChnlDetail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 112, "|");
/* 2897 */       this.polState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 113, "|");
/* 2898 */       this.standbyFlag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 114, "|");
/* 2899 */       this.standbyFlag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 115, "|");
/* 2900 */       this.standbyFlag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 116, "|");
/* 2901 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 117, "|");
/* 2902 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 118, "|"));
/* 2903 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 119, "|");
/* 2904 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 120, "|"));
/* 2905 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 121, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 2910 */       CError tError = new CError();
/* 2911 */       tError.moduleName = "LNPPolBSchema";
/* 2912 */       tError.functionName = "decode";
/* 2913 */       tError.errorMessage = ex.toString();
/* 2914 */       this.mErrors.addOneError(tError);
/*      */ 
/* 2916 */       return false;
/*      */     }
/* 2918 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 2924 */     String strReturn = "";
/* 2925 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 2927 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/* 2929 */     if (FCode.equals("serialNo"))
/*      */     {
/* 2931 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/* 2933 */     if (FCode.equals("grpContNo"))
/*      */     {
/* 2935 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/* 2937 */     if (FCode.equals("grpPolNo"))
/*      */     {
/* 2939 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpPolNo));
/*      */     }
/* 2941 */     if (FCode.equals("contNo"))
/*      */     {
/* 2943 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/* 2945 */     if (FCode.equals("proposalContNo"))
/*      */     {
/* 2947 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/* 2949 */     if (FCode.equals("polNo"))
/*      */     {
/* 2951 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polNo));
/*      */     }
/* 2953 */     if (FCode.equals("proposalNo"))
/*      */     {
/* 2955 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalNo));
/*      */     }
/* 2957 */     if (FCode.equals("prtNo"))
/*      */     {
/* 2959 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/* 2961 */     if (FCode.equals("contType"))
/*      */     {
/* 2963 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contType));
/*      */     }
/* 2965 */     if (FCode.equals("polTypeFlag"))
/*      */     {
/* 2967 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polTypeFlag));
/*      */     }
/* 2969 */     if (FCode.equals("mainPolNo"))
/*      */     {
/* 2971 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mainPolNo));
/*      */     }
/* 2973 */     if (FCode.equals("masterPolNo"))
/*      */     {
/* 2975 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.masterPolNo));
/*      */     }
/* 2977 */     if (FCode.equals("kindCode"))
/*      */     {
/* 2979 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.kindCode));
/*      */     }
/* 2981 */     if (FCode.equals("riskCode"))
/*      */     {
/* 2983 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*      */     }
/* 2985 */     if (FCode.equals("riskVersion"))
/*      */     {
/* 2987 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskVersion));
/*      */     }
/* 2989 */     if (FCode.equals("manageCom"))
/*      */     {
/* 2991 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 2993 */     if (FCode.equals("agentCom"))
/*      */     {
/* 2995 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCom));
/*      */     }
/* 2997 */     if (FCode.equals("agentType"))
/*      */     {
/* 2999 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentType));
/*      */     }
/* 3001 */     if (FCode.equals("agentCode"))
/*      */     {
/* 3003 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/* 3005 */     if (FCode.equals("agentGroup"))
/*      */     {
/* 3007 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup));
/*      */     }
/* 3009 */     if (FCode.equals("agentGroup1"))
/*      */     {
/* 3011 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup1));
/*      */     }
/* 3013 */     if (FCode.equals("agentCode1"))
/*      */     {
/* 3015 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode1));
/*      */     }
/* 3017 */     if (FCode.equals("saleChnl"))
/*      */     {
/* 3019 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.saleChnl));
/*      */     }
/* 3021 */     if (FCode.equals("handler"))
/*      */     {
/* 3023 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.handler));
/*      */     }
/* 3025 */     if (FCode.equals("insuredNo"))
/*      */     {
/* 3027 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredNo));
/*      */     }
/* 3029 */     if (FCode.equals("insuredId"))
/*      */     {
/* 3031 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredId));
/*      */     }
/* 3033 */     if (FCode.equals("insuredName"))
/*      */     {
/* 3035 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredName));
/*      */     }
/* 3037 */     if (FCode.equals("insuredSex"))
/*      */     {
/* 3039 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredSex));
/*      */     }
/* 3041 */     if (FCode.equals("insuredBirthday"))
/*      */     {
/* 3043 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getinsuredBirthday()));
/*      */     }
/* 3045 */     if (FCode.equals("insuredAppAge"))
/*      */     {
/* 3047 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredAppAge));
/*      */     }
/* 3049 */     if (FCode.equals("insuredPeoples"))
/*      */     {
/* 3051 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredPeoples));
/*      */     }
/* 3053 */     if (FCode.equals("occupationType"))
/*      */     {
/* 3055 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationType));
/*      */     }
/* 3057 */     if (FCode.equals("appntNo"))
/*      */     {
/* 3059 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntNo));
/*      */     }
/* 3061 */     if (FCode.equals("appntName"))
/*      */     {
/* 3063 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntName));
/*      */     }
/* 3065 */     if (FCode.equals("cValiDate"))
/*      */     {
/* 3067 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getcValiDate()));
/*      */     }
/* 3069 */     if (FCode.equals("signCom"))
/*      */     {
/* 3071 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signCom));
/*      */     }
/* 3073 */     if (FCode.equals("signDate"))
/*      */     {
/* 3075 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getsignDate()));
/*      */     }
/* 3077 */     if (FCode.equals("signTime"))
/*      */     {
/* 3079 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signTime));
/*      */     }
/* 3081 */     if (FCode.equals("firstPayDate"))
/*      */     {
/* 3083 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getfirstPayDate()));
/*      */     }
/* 3085 */     if (FCode.equals("payEndDate"))
/*      */     {
/* 3087 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getpayEndDate()));
/*      */     }
/* 3089 */     if (FCode.equals("paytoDate"))
/*      */     {
/* 3091 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getpaytoDate()));
/*      */     }
/* 3093 */     if (FCode.equals("getStartDate"))
/*      */     {
/* 3095 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getgetStartDate()));
/*      */     }
/* 3097 */     if (FCode.equals("endDate"))
/*      */     {
/* 3099 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getendDate()));
/*      */     }
/* 3101 */     if (FCode.equals("acciEndDate"))
/*      */     {
/* 3103 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getacciEndDate()));
/*      */     }
/* 3105 */     if (FCode.equals("getYearFlag"))
/*      */     {
/* 3107 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getYearFlag));
/*      */     }
/* 3109 */     if (FCode.equals("getYear"))
/*      */     {
/* 3111 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getYear));
/*      */     }
/* 3113 */     if (FCode.equals("payEndYearFlag"))
/*      */     {
/* 3115 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndYearFlag));
/*      */     }
/* 3117 */     if (FCode.equals("payEndYear"))
/*      */     {
/* 3119 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndYear));
/*      */     }
/* 3121 */     if (FCode.equals("insuYearFlag"))
/*      */     {
/* 3123 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuYearFlag));
/*      */     }
/* 3125 */     if (FCode.equals("insuYear"))
/*      */     {
/* 3127 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuYear));
/*      */     }
/* 3129 */     if (FCode.equals("acciYearFlag"))
/*      */     {
/* 3131 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.acciYearFlag));
/*      */     }
/* 3133 */     if (FCode.equals("acciYear"))
/*      */     {
/* 3135 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.acciYear));
/*      */     }
/* 3137 */     if (FCode.equals("getStartType"))
/*      */     {
/* 3139 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getStartType));
/*      */     }
/* 3141 */     if (FCode.equals("specifyValiDate"))
/*      */     {
/* 3143 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specifyValiDate));
/*      */     }
/* 3145 */     if (FCode.equals("payMode"))
/*      */     {
/* 3147 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payMode));
/*      */     }
/* 3149 */     if (FCode.equals("payLocation"))
/*      */     {
/* 3151 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payLocation));
/*      */     }
/* 3153 */     if (FCode.equals("payIntv"))
/*      */     {
/* 3155 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payIntv));
/*      */     }
/* 3157 */     if (FCode.equals("payYears"))
/*      */     {
/* 3159 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payYears));
/*      */     }
/* 3161 */     if (FCode.equals("years"))
/*      */     {
/* 3163 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.years));
/*      */     }
/* 3165 */     if (FCode.equals("manageFeeRate"))
/*      */     {
/* 3167 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageFeeRate));
/*      */     }
/* 3169 */     if (FCode.equals("floatRate"))
/*      */     {
/* 3171 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.floatRate));
/*      */     }
/* 3173 */     if (FCode.equals("premRate"))
/*      */     {
/* 3175 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.premRate));
/*      */     }
/* 3177 */     if (FCode.equals("premToAmnt"))
/*      */     {
/* 3179 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.premToAmnt));
/*      */     }
/* 3181 */     if (FCode.equals("mult"))
/*      */     {
/* 3183 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mult));
/*      */     }
/* 3185 */     if (FCode.equals("standPrem"))
/*      */     {
/* 3187 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.standPrem));
/*      */     }
/* 3189 */     if (FCode.equals("prem"))
/*      */     {
/* 3191 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prem));
/*      */     }
/* 3193 */     if (FCode.equals("sumPrem"))
/*      */     {
/* 3195 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sumPrem));
/*      */     }
/* 3197 */     if (FCode.equals("amnt"))
/*      */     {
/* 3199 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.amnt));
/*      */     }
/* 3201 */     if (FCode.equals("riskAmnt"))
/*      */     {
/* 3203 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskAmnt));
/*      */     }
/* 3205 */     if (FCode.equals("leavingMoney"))
/*      */     {
/* 3207 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.leavingMoney));
/*      */     }
/* 3209 */     if (FCode.equals("endorseTimes"))
/*      */     {
/* 3211 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endorseTimes));
/*      */     }
/* 3213 */     if (FCode.equals("claimTimes"))
/*      */     {
/* 3215 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.claimTimes));
/*      */     }
/* 3217 */     if (FCode.equals("liveTimes"))
/*      */     {
/* 3219 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.liveTimes));
/*      */     }
/* 3221 */     if (FCode.equals("renewCount"))
/*      */     {
/* 3223 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.renewCount));
/*      */     }
/* 3225 */     if (FCode.equals("lastGetDate"))
/*      */     {
/* 3227 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getlastGetDate()));
/*      */     }
/* 3229 */     if (FCode.equals("lastLoanDate"))
/*      */     {
/* 3231 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getlastLoanDate()));
/*      */     }
/* 3233 */     if (FCode.equals("lastRegetDate"))
/*      */     {
/* 3235 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getlastRegetDate()));
/*      */     }
/* 3237 */     if (FCode.equals("lastEdorDate"))
/*      */     {
/* 3239 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getlastEdorDate()));
/*      */     }
/* 3241 */     if (FCode.equals("lastRevDate"))
/*      */     {
/* 3243 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getlastRevDate()));
/*      */     }
/* 3245 */     if (FCode.equals("rnewFlag"))
/*      */     {
/* 3247 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rnewFlag));
/*      */     }
/* 3249 */     if (FCode.equals("stopFlag"))
/*      */     {
/* 3251 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stopFlag));
/*      */     }
/* 3253 */     if (FCode.equals("expiryFlag"))
/*      */     {
/* 3255 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.expiryFlag));
/*      */     }
/* 3257 */     if (FCode.equals("autoPayFlag"))
/*      */     {
/* 3259 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.autoPayFlag));
/*      */     }
/* 3261 */     if (FCode.equals("interestDifFlag"))
/*      */     {
/* 3263 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.interestDifFlag));
/*      */     }
/* 3265 */     if (FCode.equals("subFlag"))
/*      */     {
/* 3267 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.subFlag));
/*      */     }
/* 3269 */     if (FCode.equals("bnfFlag"))
/*      */     {
/* 3271 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfFlag));
/*      */     }
/* 3273 */     if (FCode.equals("healthCheckFlag"))
/*      */     {
/* 3275 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.healthCheckFlag));
/*      */     }
/* 3277 */     if (FCode.equals("impartFlag"))
/*      */     {
/* 3279 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartFlag));
/*      */     }
/* 3281 */     if (FCode.equals("reinsureFlag"))
/*      */     {
/* 3283 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.reinsureFlag));
/*      */     }
/* 3285 */     if (FCode.equals("agentPayFlag"))
/*      */     {
/* 3287 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentPayFlag));
/*      */     }
/* 3289 */     if (FCode.equals("agentGetFlag"))
/*      */     {
/* 3291 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGetFlag));
/*      */     }
/* 3293 */     if (FCode.equals("liveGetMode"))
/*      */     {
/* 3295 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.liveGetMode));
/*      */     }
/* 3297 */     if (FCode.equals("deadGetMode"))
/*      */     {
/* 3299 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.deadGetMode));
/*      */     }
/* 3301 */     if (FCode.equals("bonusGetMode"))
/*      */     {
/* 3303 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bonusGetMode));
/*      */     }
/* 3305 */     if (FCode.equals("deadAmntType"))
/*      */     {
/* 3307 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.deadAmntType));
/*      */     }
/* 3309 */     if (FCode.equals("topUpPrem"))
/*      */     {
/* 3311 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.topUpPrem));
/*      */     }
/* 3313 */     if (FCode.equals("bonusMan"))
/*      */     {
/* 3315 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bonusMan));
/*      */     }
/* 3317 */     if (FCode.equals("deadFlag"))
/*      */     {
/* 3319 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.deadFlag));
/*      */     }
/* 3321 */     if (FCode.equals("smokeFlag"))
/*      */     {
/* 3323 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.smokeFlag));
/*      */     }
/* 3325 */     if (FCode.equals("remark"))
/*      */     {
/* 3327 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark));
/*      */     }
/* 3329 */     if (FCode.equals("approveFlag"))
/*      */     {
/* 3331 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveFlag));
/*      */     }
/* 3333 */     if (FCode.equals("approveCode"))
/*      */     {
/* 3335 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveCode));
/*      */     }
/* 3337 */     if (FCode.equals("approveDate"))
/*      */     {
/* 3339 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getapproveDate()));
/*      */     }
/* 3341 */     if (FCode.equals("approveTime"))
/*      */     {
/* 3343 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveTime));
/*      */     }
/* 3345 */     if (FCode.equals("uWFlag"))
/*      */     {
/* 3347 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWFlag));
/*      */     }
/* 3349 */     if (FCode.equals("uWCode"))
/*      */     {
/* 3351 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWCode));
/*      */     }
/* 3353 */     if (FCode.equals("uWDate"))
/*      */     {
/* 3355 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
/*      */     }
/* 3357 */     if (FCode.equals("uWTime"))
/*      */     {
/* 3359 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWTime));
/*      */     }
/* 3361 */     if (FCode.equals("polApplyDate"))
/*      */     {
/* 3363 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getpolApplyDate()));
/*      */     }
/* 3365 */     if (FCode.equals("appFlag"))
/*      */     {
/* 3367 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appFlag));
/*      */     }
/* 3369 */     if (FCode.equals("saleChnlDetail"))
/*      */     {
/* 3371 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.saleChnlDetail));
/*      */     }
/* 3373 */     if (FCode.equals("polState"))
/*      */     {
/* 3375 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polState));
/*      */     }
/* 3377 */     if (FCode.equals("standbyFlag1"))
/*      */     {
/* 3379 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.standbyFlag1));
/*      */     }
/* 3381 */     if (FCode.equals("standbyFlag2"))
/*      */     {
/* 3383 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.standbyFlag2));
/*      */     }
/* 3385 */     if (FCode.equals("standbyFlag3"))
/*      */     {
/* 3387 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.standbyFlag3));
/*      */     }
/* 3389 */     if (FCode.equals("operator"))
/*      */     {
/* 3391 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 3393 */     if (FCode.equals("makeDate"))
/*      */     {
/* 3395 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*      */     }
/* 3397 */     if (FCode.equals("makeTime"))
/*      */     {
/* 3399 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 3401 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 3403 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*      */     }
/* 3405 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 3407 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 3409 */     if (strReturn.equals(""))
/*      */     {
/* 3411 */       strReturn = "null";
/*      */     }
/*      */ 
/* 3414 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 3421 */     String strFieldValue = "";
/* 3422 */     switch (nFieldIndex) {
/*      */     case 0:
/* 3424 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/* 3425 */       break;
/*      */     case 1:
/* 3427 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/* 3428 */       break;
/*      */     case 2:
/* 3430 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/* 3431 */       break;
/*      */     case 3:
/* 3433 */       strFieldValue = StrTool.GBKToUnicode(this.grpPolNo);
/* 3434 */       break;
/*      */     case 4:
/* 3436 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 3437 */       break;
/*      */     case 5:
/* 3439 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/* 3440 */       break;
/*      */     case 6:
/* 3442 */       strFieldValue = StrTool.GBKToUnicode(this.polNo);
/* 3443 */       break;
/*      */     case 7:
/* 3445 */       strFieldValue = StrTool.GBKToUnicode(this.proposalNo);
/* 3446 */       break;
/*      */     case 8:
/* 3448 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/* 3449 */       break;
/*      */     case 9:
/* 3451 */       strFieldValue = StrTool.GBKToUnicode(this.contType);
/* 3452 */       break;
/*      */     case 10:
/* 3454 */       strFieldValue = StrTool.GBKToUnicode(this.polTypeFlag);
/* 3455 */       break;
/*      */     case 11:
/* 3457 */       strFieldValue = StrTool.GBKToUnicode(this.mainPolNo);
/* 3458 */       break;
/*      */     case 12:
/* 3460 */       strFieldValue = StrTool.GBKToUnicode(this.masterPolNo);
/* 3461 */       break;
/*      */     case 13:
/* 3463 */       strFieldValue = StrTool.GBKToUnicode(this.kindCode);
/* 3464 */       break;
/*      */     case 14:
/* 3466 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 3467 */       break;
/*      */     case 15:
/* 3469 */       strFieldValue = StrTool.GBKToUnicode(this.riskVersion);
/* 3470 */       break;
/*      */     case 16:
/* 3472 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 3473 */       break;
/*      */     case 17:
/* 3475 */       strFieldValue = StrTool.GBKToUnicode(this.agentCom);
/* 3476 */       break;
/*      */     case 18:
/* 3478 */       strFieldValue = StrTool.GBKToUnicode(this.agentType);
/* 3479 */       break;
/*      */     case 19:
/* 3481 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/* 3482 */       break;
/*      */     case 20:
/* 3484 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup);
/* 3485 */       break;
/*      */     case 21:
/* 3487 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup1);
/* 3488 */       break;
/*      */     case 22:
/* 3490 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode1);
/* 3491 */       break;
/*      */     case 23:
/* 3493 */       strFieldValue = StrTool.GBKToUnicode(this.saleChnl);
/* 3494 */       break;
/*      */     case 24:
/* 3496 */       strFieldValue = StrTool.GBKToUnicode(this.handler);
/* 3497 */       break;
/*      */     case 25:
/* 3499 */       strFieldValue = StrTool.GBKToUnicode(this.insuredNo);
/* 3500 */       break;
/*      */     case 26:
/* 3502 */       strFieldValue = StrTool.GBKToUnicode(this.insuredId);
/* 3503 */       break;
/*      */     case 27:
/* 3505 */       strFieldValue = StrTool.GBKToUnicode(this.insuredName);
/* 3506 */       break;
/*      */     case 28:
/* 3508 */       strFieldValue = StrTool.GBKToUnicode(this.insuredSex);
/* 3509 */       break;
/*      */     case 29:
/* 3511 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getinsuredBirthday()));
/* 3512 */       break;
/*      */     case 30:
/* 3514 */       strFieldValue = String.valueOf(this.insuredAppAge);
/* 3515 */       break;
/*      */     case 31:
/* 3517 */       strFieldValue = String.valueOf(this.insuredPeoples);
/* 3518 */       break;
/*      */     case 32:
/* 3520 */       strFieldValue = StrTool.GBKToUnicode(this.occupationType);
/* 3521 */       break;
/*      */     case 33:
/* 3523 */       strFieldValue = StrTool.GBKToUnicode(this.appntNo);
/* 3524 */       break;
/*      */     case 34:
/* 3526 */       strFieldValue = StrTool.GBKToUnicode(this.appntName);
/* 3527 */       break;
/*      */     case 35:
/* 3529 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getcValiDate()));
/* 3530 */       break;
/*      */     case 36:
/* 3532 */       strFieldValue = StrTool.GBKToUnicode(this.signCom);
/* 3533 */       break;
/*      */     case 37:
/* 3535 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getsignDate()));
/* 3536 */       break;
/*      */     case 38:
/* 3538 */       strFieldValue = StrTool.GBKToUnicode(this.signTime);
/* 3539 */       break;
/*      */     case 39:
/* 3541 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getfirstPayDate()));
/* 3542 */       break;
/*      */     case 40:
/* 3544 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpayEndDate()));
/* 3545 */       break;
/*      */     case 41:
/* 3547 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpaytoDate()));
/* 3548 */       break;
/*      */     case 42:
/* 3550 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getgetStartDate()));
/* 3551 */       break;
/*      */     case 43:
/* 3553 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getendDate()));
/* 3554 */       break;
/*      */     case 44:
/* 3556 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getacciEndDate()));
/* 3557 */       break;
/*      */     case 45:
/* 3559 */       strFieldValue = StrTool.GBKToUnicode(this.getYearFlag);
/* 3560 */       break;
/*      */     case 46:
/* 3562 */       strFieldValue = String.valueOf(this.getYear);
/* 3563 */       break;
/*      */     case 47:
/* 3565 */       strFieldValue = StrTool.GBKToUnicode(this.payEndYearFlag);
/* 3566 */       break;
/*      */     case 48:
/* 3568 */       strFieldValue = String.valueOf(this.payEndYear);
/* 3569 */       break;
/*      */     case 49:
/* 3571 */       strFieldValue = StrTool.GBKToUnicode(this.insuYearFlag);
/* 3572 */       break;
/*      */     case 50:
/* 3574 */       strFieldValue = String.valueOf(this.insuYear);
/* 3575 */       break;
/*      */     case 51:
/* 3577 */       strFieldValue = StrTool.GBKToUnicode(this.acciYearFlag);
/* 3578 */       break;
/*      */     case 52:
/* 3580 */       strFieldValue = String.valueOf(this.acciYear);
/* 3581 */       break;
/*      */     case 53:
/* 3583 */       strFieldValue = StrTool.GBKToUnicode(this.getStartType);
/* 3584 */       break;
/*      */     case 54:
/* 3586 */       strFieldValue = StrTool.GBKToUnicode(this.specifyValiDate);
/* 3587 */       break;
/*      */     case 55:
/* 3589 */       strFieldValue = StrTool.GBKToUnicode(this.payMode);
/* 3590 */       break;
/*      */     case 56:
/* 3592 */       strFieldValue = StrTool.GBKToUnicode(this.payLocation);
/* 3593 */       break;
/*      */     case 57:
/* 3595 */       strFieldValue = String.valueOf(this.payIntv);
/* 3596 */       break;
/*      */     case 58:
/* 3598 */       strFieldValue = String.valueOf(this.payYears);
/* 3599 */       break;
/*      */     case 59:
/* 3601 */       strFieldValue = String.valueOf(this.years);
/* 3602 */       break;
/*      */     case 60:
/* 3604 */       strFieldValue = String.valueOf(this.manageFeeRate);
/* 3605 */       break;
/*      */     case 61:
/* 3607 */       strFieldValue = String.valueOf(this.floatRate);
/* 3608 */       break;
/*      */     case 62:
/* 3610 */       strFieldValue = String.valueOf(this.premRate);
/* 3611 */       break;
/*      */     case 63:
/* 3613 */       strFieldValue = StrTool.GBKToUnicode(this.premToAmnt);
/* 3614 */       break;
/*      */     case 64:
/* 3616 */       strFieldValue = String.valueOf(this.mult);
/* 3617 */       break;
/*      */     case 65:
/* 3619 */       strFieldValue = String.valueOf(this.standPrem);
/* 3620 */       break;
/*      */     case 66:
/* 3622 */       strFieldValue = String.valueOf(this.prem);
/* 3623 */       break;
/*      */     case 67:
/* 3625 */       strFieldValue = String.valueOf(this.sumPrem);
/* 3626 */       break;
/*      */     case 68:
/* 3628 */       strFieldValue = String.valueOf(this.amnt);
/* 3629 */       break;
/*      */     case 69:
/* 3631 */       strFieldValue = String.valueOf(this.riskAmnt);
/* 3632 */       break;
/*      */     case 70:
/* 3634 */       strFieldValue = String.valueOf(this.leavingMoney);
/* 3635 */       break;
/*      */     case 71:
/* 3637 */       strFieldValue = String.valueOf(this.endorseTimes);
/* 3638 */       break;
/*      */     case 72:
/* 3640 */       strFieldValue = String.valueOf(this.claimTimes);
/* 3641 */       break;
/*      */     case 73:
/* 3643 */       strFieldValue = String.valueOf(this.liveTimes);
/* 3644 */       break;
/*      */     case 74:
/* 3646 */       strFieldValue = String.valueOf(this.renewCount);
/* 3647 */       break;
/*      */     case 75:
/* 3649 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getlastGetDate()));
/* 3650 */       break;
/*      */     case 76:
/* 3652 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getlastLoanDate()));
/* 3653 */       break;
/*      */     case 77:
/* 3655 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getlastRegetDate()));
/* 3656 */       break;
/*      */     case 78:
/* 3658 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getlastEdorDate()));
/* 3659 */       break;
/*      */     case 79:
/* 3661 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getlastRevDate()));
/* 3662 */       break;
/*      */     case 80:
/* 3664 */       strFieldValue = StrTool.GBKToUnicode(this.rnewFlag);
/* 3665 */       break;
/*      */     case 81:
/* 3667 */       strFieldValue = StrTool.GBKToUnicode(this.stopFlag);
/* 3668 */       break;
/*      */     case 82:
/* 3670 */       strFieldValue = StrTool.GBKToUnicode(this.expiryFlag);
/* 3671 */       break;
/*      */     case 83:
/* 3673 */       strFieldValue = StrTool.GBKToUnicode(this.autoPayFlag);
/* 3674 */       break;
/*      */     case 84:
/* 3676 */       strFieldValue = StrTool.GBKToUnicode(this.interestDifFlag);
/* 3677 */       break;
/*      */     case 85:
/* 3679 */       strFieldValue = StrTool.GBKToUnicode(this.subFlag);
/* 3680 */       break;
/*      */     case 86:
/* 3682 */       strFieldValue = StrTool.GBKToUnicode(this.bnfFlag);
/* 3683 */       break;
/*      */     case 87:
/* 3685 */       strFieldValue = StrTool.GBKToUnicode(this.healthCheckFlag);
/* 3686 */       break;
/*      */     case 88:
/* 3688 */       strFieldValue = StrTool.GBKToUnicode(this.impartFlag);
/* 3689 */       break;
/*      */     case 89:
/* 3691 */       strFieldValue = StrTool.GBKToUnicode(this.reinsureFlag);
/* 3692 */       break;
/*      */     case 90:
/* 3694 */       strFieldValue = StrTool.GBKToUnicode(this.agentPayFlag);
/* 3695 */       break;
/*      */     case 91:
/* 3697 */       strFieldValue = StrTool.GBKToUnicode(this.agentGetFlag);
/* 3698 */       break;
/*      */     case 92:
/* 3700 */       strFieldValue = StrTool.GBKToUnicode(this.liveGetMode);
/* 3701 */       break;
/*      */     case 93:
/* 3703 */       strFieldValue = StrTool.GBKToUnicode(this.deadGetMode);
/* 3704 */       break;
/*      */     case 94:
/* 3706 */       strFieldValue = StrTool.GBKToUnicode(this.bonusGetMode);
/* 3707 */       break;
/*      */     case 95:
/* 3709 */       strFieldValue = StrTool.GBKToUnicode(this.deadAmntType);
/* 3710 */       break;
/*      */     case 96:
/* 3712 */       strFieldValue = String.valueOf(this.topUpPrem);
/* 3713 */       break;
/*      */     case 97:
/* 3715 */       strFieldValue = StrTool.GBKToUnicode(this.bonusMan);
/* 3716 */       break;
/*      */     case 98:
/* 3718 */       strFieldValue = StrTool.GBKToUnicode(this.deadFlag);
/* 3719 */       break;
/*      */     case 99:
/* 3721 */       strFieldValue = StrTool.GBKToUnicode(this.smokeFlag);
/* 3722 */       break;
/*      */     case 100:
/* 3724 */       strFieldValue = StrTool.GBKToUnicode(this.remark);
/* 3725 */       break;
/*      */     case 101:
/* 3727 */       strFieldValue = StrTool.GBKToUnicode(this.approveFlag);
/* 3728 */       break;
/*      */     case 102:
/* 3730 */       strFieldValue = StrTool.GBKToUnicode(this.approveCode);
/* 3731 */       break;
/*      */     case 103:
/* 3733 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getapproveDate()));
/* 3734 */       break;
/*      */     case 104:
/* 3736 */       strFieldValue = StrTool.GBKToUnicode(this.approveTime);
/* 3737 */       break;
/*      */     case 105:
/* 3739 */       strFieldValue = StrTool.GBKToUnicode(this.uWFlag);
/* 3740 */       break;
/*      */     case 106:
/* 3742 */       strFieldValue = StrTool.GBKToUnicode(this.uWCode);
/* 3743 */       break;
/*      */     case 107:
/* 3745 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
/* 3746 */       break;
/*      */     case 108:
/* 3748 */       strFieldValue = StrTool.GBKToUnicode(this.uWTime);
/* 3749 */       break;
/*      */     case 109:
/* 3751 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpolApplyDate()));
/* 3752 */       break;
/*      */     case 110:
/* 3754 */       strFieldValue = StrTool.GBKToUnicode(this.appFlag);
/* 3755 */       break;
/*      */     case 111:
/* 3757 */       strFieldValue = StrTool.GBKToUnicode(this.saleChnlDetail);
/* 3758 */       break;
/*      */     case 112:
/* 3760 */       strFieldValue = StrTool.GBKToUnicode(this.polState);
/* 3761 */       break;
/*      */     case 113:
/* 3763 */       strFieldValue = StrTool.GBKToUnicode(this.standbyFlag1);
/* 3764 */       break;
/*      */     case 114:
/* 3766 */       strFieldValue = StrTool.GBKToUnicode(this.standbyFlag2);
/* 3767 */       break;
/*      */     case 115:
/* 3769 */       strFieldValue = StrTool.GBKToUnicode(this.standbyFlag3);
/* 3770 */       break;
/*      */     case 116:
/* 3772 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 3773 */       break;
/*      */     case 117:
/* 3775 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/* 3776 */       break;
/*      */     case 118:
/* 3778 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 3779 */       break;
/*      */     case 119:
/* 3781 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/* 3782 */       break;
/*      */     case 120:
/* 3784 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 3785 */       break;
/*      */     default:
/* 3787 */       strFieldValue = "";
/*      */     }
/* 3789 */     if (strFieldValue.equals("")) {
/* 3790 */       strFieldValue = "null";
/*      */     }
/* 3792 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 3798 */     if (StrTool.cTrim(FCode).equals("")) {
/* 3799 */       return false;
/*      */     }
/* 3801 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 3803 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3805 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/* 3808 */         this.EdorNo = null;
/*      */     }
/* 3810 */     if (FCode.equals("serialNo"))
/*      */     {
/* 3812 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3814 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/* 3817 */         this.serialNo = null;
/*      */     }
/* 3819 */     if (FCode.equals("grpContNo"))
/*      */     {
/* 3821 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3823 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 3826 */         this.grpContNo = null;
/*      */     }
/* 3828 */     if (FCode.equals("grpPolNo"))
/*      */     {
/* 3830 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3832 */         this.grpPolNo = FValue.trim();
/*      */       }
/*      */       else
/* 3835 */         this.grpPolNo = null;
/*      */     }
/* 3837 */     if (FCode.equals("contNo"))
/*      */     {
/* 3839 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3841 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 3844 */         this.contNo = null;
/*      */     }
/* 3846 */     if (FCode.equals("proposalContNo"))
/*      */     {
/* 3848 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3850 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 3853 */         this.proposalContNo = null;
/*      */     }
/* 3855 */     if (FCode.equals("polNo"))
/*      */     {
/* 3857 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3859 */         this.polNo = FValue.trim();
/*      */       }
/*      */       else
/* 3862 */         this.polNo = null;
/*      */     }
/* 3864 */     if (FCode.equals("proposalNo"))
/*      */     {
/* 3866 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3868 */         this.proposalNo = FValue.trim();
/*      */       }
/*      */       else
/* 3871 */         this.proposalNo = null;
/*      */     }
/* 3873 */     if (FCode.equals("prtNo"))
/*      */     {
/* 3875 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3877 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/* 3880 */         this.prtNo = null;
/*      */     }
/* 3882 */     if (FCode.equals("contType"))
/*      */     {
/* 3884 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3886 */         this.contType = FValue.trim();
/*      */       }
/*      */       else
/* 3889 */         this.contType = null;
/*      */     }
/* 3891 */     if (FCode.equals("polTypeFlag"))
/*      */     {
/* 3893 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3895 */         this.polTypeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3898 */         this.polTypeFlag = null;
/*      */     }
/* 3900 */     if (FCode.equals("mainPolNo"))
/*      */     {
/* 3902 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3904 */         this.mainPolNo = FValue.trim();
/*      */       }
/*      */       else
/* 3907 */         this.mainPolNo = null;
/*      */     }
/* 3909 */     if (FCode.equals("masterPolNo"))
/*      */     {
/* 3911 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3913 */         this.masterPolNo = FValue.trim();
/*      */       }
/*      */       else
/* 3916 */         this.masterPolNo = null;
/*      */     }
/* 3918 */     if (FCode.equals("kindCode"))
/*      */     {
/* 3920 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3922 */         this.kindCode = FValue.trim();
/*      */       }
/*      */       else
/* 3925 */         this.kindCode = null;
/*      */     }
/* 3927 */     if (FCode.equals("riskCode"))
/*      */     {
/* 3929 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3931 */         this.riskCode = FValue.trim();
/*      */       }
/*      */       else
/* 3934 */         this.riskCode = null;
/*      */     }
/* 3936 */     if (FCode.equals("riskVersion"))
/*      */     {
/* 3938 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3940 */         this.riskVersion = FValue.trim();
/*      */       }
/*      */       else
/* 3943 */         this.riskVersion = null;
/*      */     }
/* 3945 */     if (FCode.equals("manageCom"))
/*      */     {
/* 3947 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3949 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 3952 */         this.manageCom = null;
/*      */     }
/* 3954 */     if (FCode.equals("agentCom"))
/*      */     {
/* 3956 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3958 */         this.agentCom = FValue.trim();
/*      */       }
/*      */       else
/* 3961 */         this.agentCom = null;
/*      */     }
/* 3963 */     if (FCode.equals("agentType"))
/*      */     {
/* 3965 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3967 */         this.agentType = FValue.trim();
/*      */       }
/*      */       else
/* 3970 */         this.agentType = null;
/*      */     }
/* 3972 */     if (FCode.equals("agentCode"))
/*      */     {
/* 3974 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3976 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/* 3979 */         this.agentCode = null;
/*      */     }
/* 3981 */     if (FCode.equals("agentGroup"))
/*      */     {
/* 3983 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3985 */         this.agentGroup = FValue.trim();
/*      */       }
/*      */       else
/* 3988 */         this.agentGroup = null;
/*      */     }
/* 3990 */     if (FCode.equals("agentGroup1"))
/*      */     {
/* 3992 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3994 */         this.agentGroup1 = FValue.trim();
/*      */       }
/*      */       else
/* 3997 */         this.agentGroup1 = null;
/*      */     }
/* 3999 */     if (FCode.equals("agentCode1"))
/*      */     {
/* 4001 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4003 */         this.agentCode1 = FValue.trim();
/*      */       }
/*      */       else
/* 4006 */         this.agentCode1 = null;
/*      */     }
/* 4008 */     if (FCode.equals("saleChnl"))
/*      */     {
/* 4010 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4012 */         this.saleChnl = FValue.trim();
/*      */       }
/*      */       else
/* 4015 */         this.saleChnl = null;
/*      */     }
/* 4017 */     if (FCode.equals("handler"))
/*      */     {
/* 4019 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4021 */         this.handler = FValue.trim();
/*      */       }
/*      */       else
/* 4024 */         this.handler = null;
/*      */     }
/* 4026 */     if (FCode.equals("insuredNo"))
/*      */     {
/* 4028 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4030 */         this.insuredNo = FValue.trim();
/*      */       }
/*      */       else
/* 4033 */         this.insuredNo = null;
/*      */     }
/* 4035 */     if (FCode.equals("insuredId"))
/*      */     {
/* 4037 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4039 */         this.insuredId = FValue.trim();
/*      */       }
/*      */       else
/* 4042 */         this.insuredId = null;
/*      */     }
/* 4044 */     if (FCode.equals("insuredName"))
/*      */     {
/* 4046 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4048 */         this.insuredName = FValue.trim();
/*      */       }
/*      */       else
/* 4051 */         this.insuredName = null;
/*      */     }
/* 4053 */     if (FCode.equals("insuredSex"))
/*      */     {
/* 4055 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4057 */         this.insuredSex = FValue.trim();
/*      */       }
/*      */       else
/* 4060 */         this.insuredSex = null;
/*      */     }
/* 4062 */     if (FCode.equals("insuredBirthday"))
/*      */     {
/* 4064 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4066 */         this.insuredBirthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4069 */         this.insuredBirthday = null;
/*      */     }
/* 4071 */     if (FCode.equals("insuredAppAge"))
/*      */     {
/* 4073 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4075 */         Integer tInteger = new Integer(FValue);
/* 4076 */         int i = tInteger.intValue();
/* 4077 */         this.insuredAppAge = i;
/*      */       }
/*      */     }
/* 4080 */     if (FCode.equals("insuredPeoples"))
/*      */     {
/* 4082 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4084 */         Integer tInteger = new Integer(FValue);
/* 4085 */         int i = tInteger.intValue();
/* 4086 */         this.insuredPeoples = i;
/*      */       }
/*      */     }
/* 4089 */     if (FCode.equals("occupationType"))
/*      */     {
/* 4091 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4093 */         this.occupationType = FValue.trim();
/*      */       }
/*      */       else
/* 4096 */         this.occupationType = null;
/*      */     }
/* 4098 */     if (FCode.equals("appntNo"))
/*      */     {
/* 4100 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4102 */         this.appntNo = FValue.trim();
/*      */       }
/*      */       else
/* 4105 */         this.appntNo = null;
/*      */     }
/* 4107 */     if (FCode.equals("appntName"))
/*      */     {
/* 4109 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4111 */         this.appntName = FValue.trim();
/*      */       }
/*      */       else
/* 4114 */         this.appntName = null;
/*      */     }
/* 4116 */     if (FCode.equals("cValiDate"))
/*      */     {
/* 4118 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4120 */         this.cValiDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4123 */         this.cValiDate = null;
/*      */     }
/* 4125 */     if (FCode.equals("signCom"))
/*      */     {
/* 4127 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4129 */         this.signCom = FValue.trim();
/*      */       }
/*      */       else
/* 4132 */         this.signCom = null;
/*      */     }
/* 4134 */     if (FCode.equals("signDate"))
/*      */     {
/* 4136 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4138 */         this.signDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4141 */         this.signDate = null;
/*      */     }
/* 4143 */     if (FCode.equals("signTime"))
/*      */     {
/* 4145 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4147 */         this.signTime = FValue.trim();
/*      */       }
/*      */       else
/* 4150 */         this.signTime = null;
/*      */     }
/* 4152 */     if (FCode.equals("firstPayDate"))
/*      */     {
/* 4154 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4156 */         this.firstPayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4159 */         this.firstPayDate = null;
/*      */     }
/* 4161 */     if (FCode.equals("payEndDate"))
/*      */     {
/* 4163 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4165 */         this.payEndDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4168 */         this.payEndDate = null;
/*      */     }
/* 4170 */     if (FCode.equals("paytoDate"))
/*      */     {
/* 4172 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4174 */         this.paytoDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4177 */         this.paytoDate = null;
/*      */     }
/* 4179 */     if (FCode.equals("getStartDate"))
/*      */     {
/* 4181 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4183 */         this.getStartDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4186 */         this.getStartDate = null;
/*      */     }
/* 4188 */     if (FCode.equals("endDate"))
/*      */     {
/* 4190 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4192 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4195 */         this.endDate = null;
/*      */     }
/* 4197 */     if (FCode.equals("acciEndDate"))
/*      */     {
/* 4199 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4201 */         this.acciEndDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4204 */         this.acciEndDate = null;
/*      */     }
/* 4206 */     if (FCode.equals("getYearFlag"))
/*      */     {
/* 4208 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4210 */         this.getYearFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4213 */         this.getYearFlag = null;
/*      */     }
/* 4215 */     if (FCode.equals("getYear"))
/*      */     {
/* 4217 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4219 */         Integer tInteger = new Integer(FValue);
/* 4220 */         int i = tInteger.intValue();
/* 4221 */         this.getYear = i;
/*      */       }
/*      */     }
/* 4224 */     if (FCode.equals("payEndYearFlag"))
/*      */     {
/* 4226 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4228 */         this.payEndYearFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4231 */         this.payEndYearFlag = null;
/*      */     }
/* 4233 */     if (FCode.equals("payEndYear"))
/*      */     {
/* 4235 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4237 */         Integer tInteger = new Integer(FValue);
/* 4238 */         int i = tInteger.intValue();
/* 4239 */         this.payEndYear = i;
/*      */       }
/*      */     }
/* 4242 */     if (FCode.equals("insuYearFlag"))
/*      */     {
/* 4244 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4246 */         this.insuYearFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4249 */         this.insuYearFlag = null;
/*      */     }
/* 4251 */     if (FCode.equals("insuYear"))
/*      */     {
/* 4253 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4255 */         Integer tInteger = new Integer(FValue);
/* 4256 */         int i = tInteger.intValue();
/* 4257 */         this.insuYear = i;
/*      */       }
/*      */     }
/* 4260 */     if (FCode.equals("acciYearFlag"))
/*      */     {
/* 4262 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4264 */         this.acciYearFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4267 */         this.acciYearFlag = null;
/*      */     }
/* 4269 */     if (FCode.equals("acciYear"))
/*      */     {
/* 4271 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4273 */         Integer tInteger = new Integer(FValue);
/* 4274 */         int i = tInteger.intValue();
/* 4275 */         this.acciYear = i;
/*      */       }
/*      */     }
/* 4278 */     if (FCode.equals("getStartType"))
/*      */     {
/* 4280 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4282 */         this.getStartType = FValue.trim();
/*      */       }
/*      */       else
/* 4285 */         this.getStartType = null;
/*      */     }
/* 4287 */     if (FCode.equals("specifyValiDate"))
/*      */     {
/* 4289 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4291 */         this.specifyValiDate = FValue.trim();
/*      */       }
/*      */       else
/* 4294 */         this.specifyValiDate = null;
/*      */     }
/* 4296 */     if (FCode.equals("payMode"))
/*      */     {
/* 4298 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4300 */         this.payMode = FValue.trim();
/*      */       }
/*      */       else
/* 4303 */         this.payMode = null;
/*      */     }
/* 4305 */     if (FCode.equals("payLocation"))
/*      */     {
/* 4307 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4309 */         this.payLocation = FValue.trim();
/*      */       }
/*      */       else
/* 4312 */         this.payLocation = null;
/*      */     }
/* 4314 */     if (FCode.equals("payIntv"))
/*      */     {
/* 4316 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4318 */         Integer tInteger = new Integer(FValue);
/* 4319 */         int i = tInteger.intValue();
/* 4320 */         this.payIntv = i;
/*      */       }
/*      */     }
/* 4323 */     if (FCode.equals("payYears"))
/*      */     {
/* 4325 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4327 */         Integer tInteger = new Integer(FValue);
/* 4328 */         int i = tInteger.intValue();
/* 4329 */         this.payYears = i;
/*      */       }
/*      */     }
/* 4332 */     if (FCode.equals("years"))
/*      */     {
/* 4334 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4336 */         Integer tInteger = new Integer(FValue);
/* 4337 */         int i = tInteger.intValue();
/* 4338 */         this.years = i;
/*      */       }
/*      */     }
/* 4341 */     if (FCode.equals("manageFeeRate"))
/*      */     {
/* 4343 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4345 */         Double tDouble = new Double(FValue);
/* 4346 */         double d = tDouble.doubleValue();
/* 4347 */         this.manageFeeRate = d;
/*      */       }
/*      */     }
/* 4350 */     if (FCode.equals("floatRate"))
/*      */     {
/* 4352 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4354 */         Double tDouble = new Double(FValue);
/* 4355 */         double d = tDouble.doubleValue();
/* 4356 */         this.floatRate = d;
/*      */       }
/*      */     }
/* 4359 */     if (FCode.equals("premRate"))
/*      */     {
/* 4361 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4363 */         Double tDouble = new Double(FValue);
/* 4364 */         double d = tDouble.doubleValue();
/* 4365 */         this.premRate = d;
/*      */       }
/*      */     }
/* 4368 */     if (FCode.equals("premToAmnt"))
/*      */     {
/* 4370 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4372 */         this.premToAmnt = FValue.trim();
/*      */       }
/*      */       else
/* 4375 */         this.premToAmnt = null;
/*      */     }
/* 4377 */     if (FCode.equals("mult"))
/*      */     {
/* 4379 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4381 */         Double tDouble = new Double(FValue);
/* 4382 */         double d = tDouble.doubleValue();
/* 4383 */         this.mult = d;
/*      */       }
/*      */     }
/* 4386 */     if (FCode.equals("standPrem"))
/*      */     {
/* 4388 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4390 */         Double tDouble = new Double(FValue);
/* 4391 */         double d = tDouble.doubleValue();
/* 4392 */         this.standPrem = d;
/*      */       }
/*      */     }
/* 4395 */     if (FCode.equals("prem"))
/*      */     {
/* 4397 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4399 */         Double tDouble = new Double(FValue);
/* 4400 */         double d = tDouble.doubleValue();
/* 4401 */         this.prem = d;
/*      */       }
/*      */     }
/* 4404 */     if (FCode.equals("sumPrem"))
/*      */     {
/* 4406 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4408 */         Double tDouble = new Double(FValue);
/* 4409 */         double d = tDouble.doubleValue();
/* 4410 */         this.sumPrem = d;
/*      */       }
/*      */     }
/* 4413 */     if (FCode.equals("amnt"))
/*      */     {
/* 4415 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4417 */         Double tDouble = new Double(FValue);
/* 4418 */         double d = tDouble.doubleValue();
/* 4419 */         this.amnt = d;
/*      */       }
/*      */     }
/* 4422 */     if (FCode.equals("riskAmnt"))
/*      */     {
/* 4424 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4426 */         Double tDouble = new Double(FValue);
/* 4427 */         double d = tDouble.doubleValue();
/* 4428 */         this.riskAmnt = d;
/*      */       }
/*      */     }
/* 4431 */     if (FCode.equals("leavingMoney"))
/*      */     {
/* 4433 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4435 */         Double tDouble = new Double(FValue);
/* 4436 */         double d = tDouble.doubleValue();
/* 4437 */         this.leavingMoney = d;
/*      */       }
/*      */     }
/* 4440 */     if (FCode.equals("endorseTimes"))
/*      */     {
/* 4442 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4444 */         Integer tInteger = new Integer(FValue);
/* 4445 */         int i = tInteger.intValue();
/* 4446 */         this.endorseTimes = i;
/*      */       }
/*      */     }
/* 4449 */     if (FCode.equals("claimTimes"))
/*      */     {
/* 4451 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4453 */         Integer tInteger = new Integer(FValue);
/* 4454 */         int i = tInteger.intValue();
/* 4455 */         this.claimTimes = i;
/*      */       }
/*      */     }
/* 4458 */     if (FCode.equals("liveTimes"))
/*      */     {
/* 4460 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4462 */         Integer tInteger = new Integer(FValue);
/* 4463 */         int i = tInteger.intValue();
/* 4464 */         this.liveTimes = i;
/*      */       }
/*      */     }
/* 4467 */     if (FCode.equals("renewCount"))
/*      */     {
/* 4469 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4471 */         Integer tInteger = new Integer(FValue);
/* 4472 */         int i = tInteger.intValue();
/* 4473 */         this.renewCount = i;
/*      */       }
/*      */     }
/* 4476 */     if (FCode.equals("lastGetDate"))
/*      */     {
/* 4478 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4480 */         this.lastGetDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4483 */         this.lastGetDate = null;
/*      */     }
/* 4485 */     if (FCode.equals("lastLoanDate"))
/*      */     {
/* 4487 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4489 */         this.lastLoanDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4492 */         this.lastLoanDate = null;
/*      */     }
/* 4494 */     if (FCode.equals("lastRegetDate"))
/*      */     {
/* 4496 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4498 */         this.lastRegetDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4501 */         this.lastRegetDate = null;
/*      */     }
/* 4503 */     if (FCode.equals("lastEdorDate"))
/*      */     {
/* 4505 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4507 */         this.lastEdorDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4510 */         this.lastEdorDate = null;
/*      */     }
/* 4512 */     if (FCode.equals("lastRevDate"))
/*      */     {
/* 4514 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4516 */         this.lastRevDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4519 */         this.lastRevDate = null;
/*      */     }
/* 4521 */     if (FCode.equals("rnewFlag"))
/*      */     {
/* 4523 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4525 */         this.rnewFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4528 */         this.rnewFlag = null;
/*      */     }
/* 4530 */     if (FCode.equals("stopFlag"))
/*      */     {
/* 4532 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4534 */         this.stopFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4537 */         this.stopFlag = null;
/*      */     }
/* 4539 */     if (FCode.equals("expiryFlag"))
/*      */     {
/* 4541 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4543 */         this.expiryFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4546 */         this.expiryFlag = null;
/*      */     }
/* 4548 */     if (FCode.equals("autoPayFlag"))
/*      */     {
/* 4550 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4552 */         this.autoPayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4555 */         this.autoPayFlag = null;
/*      */     }
/* 4557 */     if (FCode.equals("interestDifFlag"))
/*      */     {
/* 4559 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4561 */         this.interestDifFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4564 */         this.interestDifFlag = null;
/*      */     }
/* 4566 */     if (FCode.equals("subFlag"))
/*      */     {
/* 4568 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4570 */         this.subFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4573 */         this.subFlag = null;
/*      */     }
/* 4575 */     if (FCode.equals("bnfFlag"))
/*      */     {
/* 4577 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4579 */         this.bnfFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4582 */         this.bnfFlag = null;
/*      */     }
/* 4584 */     if (FCode.equals("healthCheckFlag"))
/*      */     {
/* 4586 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4588 */         this.healthCheckFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4591 */         this.healthCheckFlag = null;
/*      */     }
/* 4593 */     if (FCode.equals("impartFlag"))
/*      */     {
/* 4595 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4597 */         this.impartFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4600 */         this.impartFlag = null;
/*      */     }
/* 4602 */     if (FCode.equals("reinsureFlag"))
/*      */     {
/* 4604 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4606 */         this.reinsureFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4609 */         this.reinsureFlag = null;
/*      */     }
/* 4611 */     if (FCode.equals("agentPayFlag"))
/*      */     {
/* 4613 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4615 */         this.agentPayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4618 */         this.agentPayFlag = null;
/*      */     }
/* 4620 */     if (FCode.equals("agentGetFlag"))
/*      */     {
/* 4622 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4624 */         this.agentGetFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4627 */         this.agentGetFlag = null;
/*      */     }
/* 4629 */     if (FCode.equals("liveGetMode"))
/*      */     {
/* 4631 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4633 */         this.liveGetMode = FValue.trim();
/*      */       }
/*      */       else
/* 4636 */         this.liveGetMode = null;
/*      */     }
/* 4638 */     if (FCode.equals("deadGetMode"))
/*      */     {
/* 4640 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4642 */         this.deadGetMode = FValue.trim();
/*      */       }
/*      */       else
/* 4645 */         this.deadGetMode = null;
/*      */     }
/* 4647 */     if (FCode.equals("bonusGetMode"))
/*      */     {
/* 4649 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4651 */         this.bonusGetMode = FValue.trim();
/*      */       }
/*      */       else
/* 4654 */         this.bonusGetMode = null;
/*      */     }
/* 4656 */     if (FCode.equals("deadAmntType"))
/*      */     {
/* 4658 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4660 */         this.deadAmntType = FValue.trim();
/*      */       }
/*      */       else
/* 4663 */         this.deadAmntType = null;
/*      */     }
/* 4665 */     if (FCode.equals("topUpPrem"))
/*      */     {
/* 4667 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4669 */         Double tDouble = new Double(FValue);
/* 4670 */         double d = tDouble.doubleValue();
/* 4671 */         this.topUpPrem = d;
/*      */       }
/*      */     }
/* 4674 */     if (FCode.equals("bonusMan"))
/*      */     {
/* 4676 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4678 */         this.bonusMan = FValue.trim();
/*      */       }
/*      */       else
/* 4681 */         this.bonusMan = null;
/*      */     }
/* 4683 */     if (FCode.equals("deadFlag"))
/*      */     {
/* 4685 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4687 */         this.deadFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4690 */         this.deadFlag = null;
/*      */     }
/* 4692 */     if (FCode.equals("smokeFlag"))
/*      */     {
/* 4694 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4696 */         this.smokeFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4699 */         this.smokeFlag = null;
/*      */     }
/* 4701 */     if (FCode.equals("remark"))
/*      */     {
/* 4703 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4705 */         this.remark = FValue.trim();
/*      */       }
/*      */       else
/* 4708 */         this.remark = null;
/*      */     }
/* 4710 */     if (FCode.equals("approveFlag"))
/*      */     {
/* 4712 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4714 */         this.approveFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4717 */         this.approveFlag = null;
/*      */     }
/* 4719 */     if (FCode.equals("approveCode"))
/*      */     {
/* 4721 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4723 */         this.approveCode = FValue.trim();
/*      */       }
/*      */       else
/* 4726 */         this.approveCode = null;
/*      */     }
/* 4728 */     if (FCode.equals("approveDate"))
/*      */     {
/* 4730 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4732 */         this.approveDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4735 */         this.approveDate = null;
/*      */     }
/* 4737 */     if (FCode.equals("approveTime"))
/*      */     {
/* 4739 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4741 */         this.approveTime = FValue.trim();
/*      */       }
/*      */       else
/* 4744 */         this.approveTime = null;
/*      */     }
/* 4746 */     if (FCode.equals("uWFlag"))
/*      */     {
/* 4748 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4750 */         this.uWFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4753 */         this.uWFlag = null;
/*      */     }
/* 4755 */     if (FCode.equals("uWCode"))
/*      */     {
/* 4757 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4759 */         this.uWCode = FValue.trim();
/*      */       }
/*      */       else
/* 4762 */         this.uWCode = null;
/*      */     }
/* 4764 */     if (FCode.equals("uWDate"))
/*      */     {
/* 4766 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4768 */         this.uWDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4771 */         this.uWDate = null;
/*      */     }
/* 4773 */     if (FCode.equals("uWTime"))
/*      */     {
/* 4775 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4777 */         this.uWTime = FValue.trim();
/*      */       }
/*      */       else
/* 4780 */         this.uWTime = null;
/*      */     }
/* 4782 */     if (FCode.equals("polApplyDate"))
/*      */     {
/* 4784 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4786 */         this.polApplyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4789 */         this.polApplyDate = null;
/*      */     }
/* 4791 */     if (FCode.equals("appFlag"))
/*      */     {
/* 4793 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4795 */         this.appFlag = FValue.trim();
/*      */       }
/*      */       else
/* 4798 */         this.appFlag = null;
/*      */     }
/* 4800 */     if (FCode.equals("saleChnlDetail"))
/*      */     {
/* 4802 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4804 */         this.saleChnlDetail = FValue.trim();
/*      */       }
/*      */       else
/* 4807 */         this.saleChnlDetail = null;
/*      */     }
/* 4809 */     if (FCode.equals("polState"))
/*      */     {
/* 4811 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4813 */         this.polState = FValue.trim();
/*      */       }
/*      */       else
/* 4816 */         this.polState = null;
/*      */     }
/* 4818 */     if (FCode.equals("standbyFlag1"))
/*      */     {
/* 4820 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4822 */         this.standbyFlag1 = FValue.trim();
/*      */       }
/*      */       else
/* 4825 */         this.standbyFlag1 = null;
/*      */     }
/* 4827 */     if (FCode.equals("standbyFlag2"))
/*      */     {
/* 4829 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4831 */         this.standbyFlag2 = FValue.trim();
/*      */       }
/*      */       else
/* 4834 */         this.standbyFlag2 = null;
/*      */     }
/* 4836 */     if (FCode.equals("standbyFlag3"))
/*      */     {
/* 4838 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4840 */         this.standbyFlag3 = FValue.trim();
/*      */       }
/*      */       else
/* 4843 */         this.standbyFlag3 = null;
/*      */     }
/* 4845 */     if (FCode.equals("operator"))
/*      */     {
/* 4847 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4849 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 4852 */         this.operator = null;
/*      */     }
/* 4854 */     if (FCode.equals("makeDate"))
/*      */     {
/* 4856 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4858 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4861 */         this.makeDate = null;
/*      */     }
/* 4863 */     if (FCode.equals("makeTime"))
/*      */     {
/* 4865 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4867 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 4870 */         this.makeTime = null;
/*      */     }
/* 4872 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 4874 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4876 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4879 */         this.modifyDate = null;
/*      */     }
/* 4881 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 4883 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4885 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 4888 */         this.modifyTime = null;
/*      */     }
/* 4890 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 4895 */     if (this == otherObject) return true;
/* 4896 */     if (otherObject == null) return false;
/* 4897 */     if (getClass() != otherObject.getClass()) return false;
/* 4898 */     LNPPolBSchema other = (LNPPolBSchema)otherObject;
/* 4899 */     return 
/* 4900 */       (this.EdorNo.equals(other.getEdorNo())) && 
/* 4901 */       (this.serialNo.equals(other.getserialNo())) && 
/* 4902 */       (this.grpContNo.equals(other.getgrpContNo())) && 
/* 4903 */       (this.grpPolNo.equals(other.getgrpPolNo())) && 
/* 4904 */       (this.contNo.equals(other.getcontNo())) && 
/* 4905 */       (this.proposalContNo.equals(other.getproposalContNo())) && 
/* 4906 */       (this.polNo.equals(other.getpolNo())) && 
/* 4907 */       (this.proposalNo.equals(other.getproposalNo())) && 
/* 4908 */       (this.prtNo.equals(other.getprtNo())) && 
/* 4909 */       (this.contType.equals(other.getcontType())) && 
/* 4910 */       (this.polTypeFlag.equals(other.getpolTypeFlag())) && 
/* 4911 */       (this.mainPolNo.equals(other.getmainPolNo())) && 
/* 4912 */       (this.masterPolNo.equals(other.getmasterPolNo())) && 
/* 4913 */       (this.kindCode.equals(other.getkindCode())) && 
/* 4914 */       (this.riskCode.equals(other.getriskCode())) && 
/* 4915 */       (this.riskVersion.equals(other.getriskVersion())) && 
/* 4916 */       (this.manageCom.equals(other.getmanageCom())) && 
/* 4917 */       (this.agentCom.equals(other.getagentCom())) && 
/* 4918 */       (this.agentType.equals(other.getagentType())) && 
/* 4919 */       (this.agentCode.equals(other.getagentCode())) && 
/* 4920 */       (this.agentGroup.equals(other.getagentGroup())) && 
/* 4921 */       (this.agentGroup1.equals(other.getagentGroup1())) && 
/* 4922 */       (this.agentCode1.equals(other.getagentCode1())) && 
/* 4923 */       (this.saleChnl.equals(other.getsaleChnl())) && 
/* 4924 */       (this.handler.equals(other.gethandler())) && 
/* 4925 */       (this.insuredNo.equals(other.getinsuredNo())) && 
/* 4926 */       (this.insuredId.equals(other.getinsuredId())) && 
/* 4927 */       (this.insuredName.equals(other.getinsuredName())) && 
/* 4928 */       (this.insuredSex.equals(other.getinsuredSex())) && 
/* 4929 */       (this.fDate.getString(this.insuredBirthday).equals(other.getinsuredBirthday())) && 
/* 4930 */       (this.insuredAppAge == other.getinsuredAppAge()) && 
/* 4931 */       (this.insuredPeoples == other.getinsuredPeoples()) && 
/* 4932 */       (this.occupationType.equals(other.getoccupationType())) && 
/* 4933 */       (this.appntNo.equals(other.getappntNo())) && 
/* 4934 */       (this.appntName.equals(other.getappntName())) && 
/* 4935 */       (this.fDate.getString(this.cValiDate).equals(other.getcValiDate())) && 
/* 4936 */       (this.signCom.equals(other.getsignCom())) && 
/* 4937 */       (this.fDate.getString(this.signDate).equals(other.getsignDate())) && 
/* 4938 */       (this.signTime.equals(other.getsignTime())) && 
/* 4939 */       (this.fDate.getString(this.firstPayDate).equals(other.getfirstPayDate())) && 
/* 4940 */       (this.fDate.getString(this.payEndDate).equals(other.getpayEndDate())) && 
/* 4941 */       (this.fDate.getString(this.paytoDate).equals(other.getpaytoDate())) && 
/* 4942 */       (this.fDate.getString(this.getStartDate).equals(other.getgetStartDate())) && 
/* 4943 */       (this.fDate.getString(this.endDate).equals(other.getendDate())) && 
/* 4944 */       (this.fDate.getString(this.acciEndDate).equals(other.getacciEndDate())) && 
/* 4945 */       (this.getYearFlag.equals(other.getgetYearFlag())) && 
/* 4946 */       (this.getYear == other.getgetYear()) && 
/* 4947 */       (this.payEndYearFlag.equals(other.getpayEndYearFlag())) && 
/* 4948 */       (this.payEndYear == other.getpayEndYear()) && 
/* 4949 */       (this.insuYearFlag.equals(other.getinsuYearFlag())) && 
/* 4950 */       (this.insuYear == other.getinsuYear()) && 
/* 4951 */       (this.acciYearFlag.equals(other.getacciYearFlag())) && 
/* 4952 */       (this.acciYear == other.getacciYear()) && 
/* 4953 */       (this.getStartType.equals(other.getgetStartType())) && 
/* 4954 */       (this.specifyValiDate.equals(other.getspecifyValiDate())) && 
/* 4955 */       (this.payMode.equals(other.getpayMode())) && 
/* 4956 */       (this.payLocation.equals(other.getpayLocation())) && 
/* 4957 */       (this.payIntv == other.getpayIntv()) && 
/* 4958 */       (this.payYears == other.getpayYears()) && 
/* 4959 */       (this.years == other.getyears()) && 
/* 4960 */       (this.manageFeeRate == other.getmanageFeeRate()) && 
/* 4961 */       (this.floatRate == other.getfloatRate()) && 
/* 4962 */       (this.premRate == other.getpremRate()) && 
/* 4963 */       (this.premToAmnt.equals(other.getpremToAmnt())) && 
/* 4964 */       (this.mult == other.getmult()) && 
/* 4965 */       (this.standPrem == other.getstandPrem()) && 
/* 4966 */       (this.prem == other.getprem()) && 
/* 4967 */       (this.sumPrem == other.getsumPrem()) && 
/* 4968 */       (this.amnt == other.getamnt()) && 
/* 4969 */       (this.riskAmnt == other.getriskAmnt()) && 
/* 4970 */       (this.leavingMoney == other.getleavingMoney()) && 
/* 4971 */       (this.endorseTimes == other.getendorseTimes()) && 
/* 4972 */       (this.claimTimes == other.getclaimTimes()) && 
/* 4973 */       (this.liveTimes == other.getliveTimes()) && 
/* 4974 */       (this.renewCount == other.getrenewCount()) && 
/* 4975 */       (this.fDate.getString(this.lastGetDate).equals(other.getlastGetDate())) && 
/* 4976 */       (this.fDate.getString(this.lastLoanDate).equals(other.getlastLoanDate())) && 
/* 4977 */       (this.fDate.getString(this.lastRegetDate).equals(other.getlastRegetDate())) && 
/* 4978 */       (this.fDate.getString(this.lastEdorDate).equals(other.getlastEdorDate())) && 
/* 4979 */       (this.fDate.getString(this.lastRevDate).equals(other.getlastRevDate())) && 
/* 4980 */       (this.rnewFlag.equals(other.getrnewFlag())) && 
/* 4981 */       (this.stopFlag.equals(other.getstopFlag())) && 
/* 4982 */       (this.expiryFlag.equals(other.getexpiryFlag())) && 
/* 4983 */       (this.autoPayFlag.equals(other.getautoPayFlag())) && 
/* 4984 */       (this.interestDifFlag.equals(other.getinterestDifFlag())) && 
/* 4985 */       (this.subFlag.equals(other.getsubFlag())) && 
/* 4986 */       (this.bnfFlag.equals(other.getbnfFlag())) && 
/* 4987 */       (this.healthCheckFlag.equals(other.gethealthCheckFlag())) && 
/* 4988 */       (this.impartFlag.equals(other.getimpartFlag())) && 
/* 4989 */       (this.reinsureFlag.equals(other.getreinsureFlag())) && 
/* 4990 */       (this.agentPayFlag.equals(other.getagentPayFlag())) && 
/* 4991 */       (this.agentGetFlag.equals(other.getagentGetFlag())) && 
/* 4992 */       (this.liveGetMode.equals(other.getliveGetMode())) && 
/* 4993 */       (this.deadGetMode.equals(other.getdeadGetMode())) && 
/* 4994 */       (this.bonusGetMode.equals(other.getbonusGetMode())) && 
/* 4995 */       (this.deadAmntType.equals(other.getdeadAmntType())) && 
/* 4996 */       (this.topUpPrem == other.gettopUpPrem()) && 
/* 4997 */       (this.bonusMan.equals(other.getbonusMan())) && 
/* 4998 */       (this.deadFlag.equals(other.getdeadFlag())) && 
/* 4999 */       (this.smokeFlag.equals(other.getsmokeFlag())) && 
/* 5000 */       (this.remark.equals(other.getremark())) && 
/* 5001 */       (this.approveFlag.equals(other.getapproveFlag())) && 
/* 5002 */       (this.approveCode.equals(other.getapproveCode())) && 
/* 5003 */       (this.fDate.getString(this.approveDate).equals(other.getapproveDate())) && 
/* 5004 */       (this.approveTime.equals(other.getapproveTime())) && 
/* 5005 */       (this.uWFlag.equals(other.getuWFlag())) && 
/* 5006 */       (this.uWCode.equals(other.getuWCode())) && 
/* 5007 */       (this.fDate.getString(this.uWDate).equals(other.getuWDate())) && 
/* 5008 */       (this.uWTime.equals(other.getuWTime())) && 
/* 5009 */       (this.fDate.getString(this.polApplyDate).equals(other.getpolApplyDate())) && 
/* 5010 */       (this.appFlag.equals(other.getappFlag())) && 
/* 5011 */       (this.saleChnlDetail.equals(other.getsaleChnlDetail())) && 
/* 5012 */       (this.polState.equals(other.getpolState())) && 
/* 5013 */       (this.standbyFlag1.equals(other.getstandbyFlag1())) && 
/* 5014 */       (this.standbyFlag2.equals(other.getstandbyFlag2())) && 
/* 5015 */       (this.standbyFlag3.equals(other.getstandbyFlag3())) && 
/* 5016 */       (this.operator.equals(other.getoperator())) && 
/* 5017 */       (this.fDate.getString(this.makeDate).equals(other.getmakeDate())) && 
/* 5018 */       (this.makeTime.equals(other.getmakeTime())) && 
/* 5019 */       (this.fDate.getString(this.modifyDate).equals(other.getmodifyDate())) && 
/* 5020 */       (this.modifyTime.equals(other.getmodifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 5026 */     return 121;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 5032 */     if (strFieldName.equals("EdorNo")) {
/* 5033 */       return 0;
/*      */     }
/* 5035 */     if (strFieldName.equals("serialNo")) {
/* 5036 */       return 1;
/*      */     }
/* 5038 */     if (strFieldName.equals("grpContNo")) {
/* 5039 */       return 2;
/*      */     }
/* 5041 */     if (strFieldName.equals("grpPolNo")) {
/* 5042 */       return 3;
/*      */     }
/* 5044 */     if (strFieldName.equals("contNo")) {
/* 5045 */       return 4;
/*      */     }
/* 5047 */     if (strFieldName.equals("proposalContNo")) {
/* 5048 */       return 5;
/*      */     }
/* 5050 */     if (strFieldName.equals("polNo")) {
/* 5051 */       return 6;
/*      */     }
/* 5053 */     if (strFieldName.equals("proposalNo")) {
/* 5054 */       return 7;
/*      */     }
/* 5056 */     if (strFieldName.equals("prtNo")) {
/* 5057 */       return 8;
/*      */     }
/* 5059 */     if (strFieldName.equals("contType")) {
/* 5060 */       return 9;
/*      */     }
/* 5062 */     if (strFieldName.equals("polTypeFlag")) {
/* 5063 */       return 10;
/*      */     }
/* 5065 */     if (strFieldName.equals("mainPolNo")) {
/* 5066 */       return 11;
/*      */     }
/* 5068 */     if (strFieldName.equals("masterPolNo")) {
/* 5069 */       return 12;
/*      */     }
/* 5071 */     if (strFieldName.equals("kindCode")) {
/* 5072 */       return 13;
/*      */     }
/* 5074 */     if (strFieldName.equals("riskCode")) {
/* 5075 */       return 14;
/*      */     }
/* 5077 */     if (strFieldName.equals("riskVersion")) {
/* 5078 */       return 15;
/*      */     }
/* 5080 */     if (strFieldName.equals("manageCom")) {
/* 5081 */       return 16;
/*      */     }
/* 5083 */     if (strFieldName.equals("agentCom")) {
/* 5084 */       return 17;
/*      */     }
/* 5086 */     if (strFieldName.equals("agentType")) {
/* 5087 */       return 18;
/*      */     }
/* 5089 */     if (strFieldName.equals("agentCode")) {
/* 5090 */       return 19;
/*      */     }
/* 5092 */     if (strFieldName.equals("agentGroup")) {
/* 5093 */       return 20;
/*      */     }
/* 5095 */     if (strFieldName.equals("agentGroup1")) {
/* 5096 */       return 21;
/*      */     }
/* 5098 */     if (strFieldName.equals("agentCode1")) {
/* 5099 */       return 22;
/*      */     }
/* 5101 */     if (strFieldName.equals("saleChnl")) {
/* 5102 */       return 23;
/*      */     }
/* 5104 */     if (strFieldName.equals("handler")) {
/* 5105 */       return 24;
/*      */     }
/* 5107 */     if (strFieldName.equals("insuredNo")) {
/* 5108 */       return 25;
/*      */     }
/* 5110 */     if (strFieldName.equals("insuredId")) {
/* 5111 */       return 26;
/*      */     }
/* 5113 */     if (strFieldName.equals("insuredName")) {
/* 5114 */       return 27;
/*      */     }
/* 5116 */     if (strFieldName.equals("insuredSex")) {
/* 5117 */       return 28;
/*      */     }
/* 5119 */     if (strFieldName.equals("insuredBirthday")) {
/* 5120 */       return 29;
/*      */     }
/* 5122 */     if (strFieldName.equals("insuredAppAge")) {
/* 5123 */       return 30;
/*      */     }
/* 5125 */     if (strFieldName.equals("insuredPeoples")) {
/* 5126 */       return 31;
/*      */     }
/* 5128 */     if (strFieldName.equals("occupationType")) {
/* 5129 */       return 32;
/*      */     }
/* 5131 */     if (strFieldName.equals("appntNo")) {
/* 5132 */       return 33;
/*      */     }
/* 5134 */     if (strFieldName.equals("appntName")) {
/* 5135 */       return 34;
/*      */     }
/* 5137 */     if (strFieldName.equals("cValiDate")) {
/* 5138 */       return 35;
/*      */     }
/* 5140 */     if (strFieldName.equals("signCom")) {
/* 5141 */       return 36;
/*      */     }
/* 5143 */     if (strFieldName.equals("signDate")) {
/* 5144 */       return 37;
/*      */     }
/* 5146 */     if (strFieldName.equals("signTime")) {
/* 5147 */       return 38;
/*      */     }
/* 5149 */     if (strFieldName.equals("firstPayDate")) {
/* 5150 */       return 39;
/*      */     }
/* 5152 */     if (strFieldName.equals("payEndDate")) {
/* 5153 */       return 40;
/*      */     }
/* 5155 */     if (strFieldName.equals("paytoDate")) {
/* 5156 */       return 41;
/*      */     }
/* 5158 */     if (strFieldName.equals("getStartDate")) {
/* 5159 */       return 42;
/*      */     }
/* 5161 */     if (strFieldName.equals("endDate")) {
/* 5162 */       return 43;
/*      */     }
/* 5164 */     if (strFieldName.equals("acciEndDate")) {
/* 5165 */       return 44;
/*      */     }
/* 5167 */     if (strFieldName.equals("getYearFlag")) {
/* 5168 */       return 45;
/*      */     }
/* 5170 */     if (strFieldName.equals("getYear")) {
/* 5171 */       return 46;
/*      */     }
/* 5173 */     if (strFieldName.equals("payEndYearFlag")) {
/* 5174 */       return 47;
/*      */     }
/* 5176 */     if (strFieldName.equals("payEndYear")) {
/* 5177 */       return 48;
/*      */     }
/* 5179 */     if (strFieldName.equals("insuYearFlag")) {
/* 5180 */       return 49;
/*      */     }
/* 5182 */     if (strFieldName.equals("insuYear")) {
/* 5183 */       return 50;
/*      */     }
/* 5185 */     if (strFieldName.equals("acciYearFlag")) {
/* 5186 */       return 51;
/*      */     }
/* 5188 */     if (strFieldName.equals("acciYear")) {
/* 5189 */       return 52;
/*      */     }
/* 5191 */     if (strFieldName.equals("getStartType")) {
/* 5192 */       return 53;
/*      */     }
/* 5194 */     if (strFieldName.equals("specifyValiDate")) {
/* 5195 */       return 54;
/*      */     }
/* 5197 */     if (strFieldName.equals("payMode")) {
/* 5198 */       return 55;
/*      */     }
/* 5200 */     if (strFieldName.equals("payLocation")) {
/* 5201 */       return 56;
/*      */     }
/* 5203 */     if (strFieldName.equals("payIntv")) {
/* 5204 */       return 57;
/*      */     }
/* 5206 */     if (strFieldName.equals("payYears")) {
/* 5207 */       return 58;
/*      */     }
/* 5209 */     if (strFieldName.equals("years")) {
/* 5210 */       return 59;
/*      */     }
/* 5212 */     if (strFieldName.equals("manageFeeRate")) {
/* 5213 */       return 60;
/*      */     }
/* 5215 */     if (strFieldName.equals("floatRate")) {
/* 5216 */       return 61;
/*      */     }
/* 5218 */     if (strFieldName.equals("premRate")) {
/* 5219 */       return 62;
/*      */     }
/* 5221 */     if (strFieldName.equals("premToAmnt")) {
/* 5222 */       return 63;
/*      */     }
/* 5224 */     if (strFieldName.equals("mult")) {
/* 5225 */       return 64;
/*      */     }
/* 5227 */     if (strFieldName.equals("standPrem")) {
/* 5228 */       return 65;
/*      */     }
/* 5230 */     if (strFieldName.equals("prem")) {
/* 5231 */       return 66;
/*      */     }
/* 5233 */     if (strFieldName.equals("sumPrem")) {
/* 5234 */       return 67;
/*      */     }
/* 5236 */     if (strFieldName.equals("amnt")) {
/* 5237 */       return 68;
/*      */     }
/* 5239 */     if (strFieldName.equals("riskAmnt")) {
/* 5240 */       return 69;
/*      */     }
/* 5242 */     if (strFieldName.equals("leavingMoney")) {
/* 5243 */       return 70;
/*      */     }
/* 5245 */     if (strFieldName.equals("endorseTimes")) {
/* 5246 */       return 71;
/*      */     }
/* 5248 */     if (strFieldName.equals("claimTimes")) {
/* 5249 */       return 72;
/*      */     }
/* 5251 */     if (strFieldName.equals("liveTimes")) {
/* 5252 */       return 73;
/*      */     }
/* 5254 */     if (strFieldName.equals("renewCount")) {
/* 5255 */       return 74;
/*      */     }
/* 5257 */     if (strFieldName.equals("lastGetDate")) {
/* 5258 */       return 75;
/*      */     }
/* 5260 */     if (strFieldName.equals("lastLoanDate")) {
/* 5261 */       return 76;
/*      */     }
/* 5263 */     if (strFieldName.equals("lastRegetDate")) {
/* 5264 */       return 77;
/*      */     }
/* 5266 */     if (strFieldName.equals("lastEdorDate")) {
/* 5267 */       return 78;
/*      */     }
/* 5269 */     if (strFieldName.equals("lastRevDate")) {
/* 5270 */       return 79;
/*      */     }
/* 5272 */     if (strFieldName.equals("rnewFlag")) {
/* 5273 */       return 80;
/*      */     }
/* 5275 */     if (strFieldName.equals("stopFlag")) {
/* 5276 */       return 81;
/*      */     }
/* 5278 */     if (strFieldName.equals("expiryFlag")) {
/* 5279 */       return 82;
/*      */     }
/* 5281 */     if (strFieldName.equals("autoPayFlag")) {
/* 5282 */       return 83;
/*      */     }
/* 5284 */     if (strFieldName.equals("interestDifFlag")) {
/* 5285 */       return 84;
/*      */     }
/* 5287 */     if (strFieldName.equals("subFlag")) {
/* 5288 */       return 85;
/*      */     }
/* 5290 */     if (strFieldName.equals("bnfFlag")) {
/* 5291 */       return 86;
/*      */     }
/* 5293 */     if (strFieldName.equals("healthCheckFlag")) {
/* 5294 */       return 87;
/*      */     }
/* 5296 */     if (strFieldName.equals("impartFlag")) {
/* 5297 */       return 88;
/*      */     }
/* 5299 */     if (strFieldName.equals("reinsureFlag")) {
/* 5300 */       return 89;
/*      */     }
/* 5302 */     if (strFieldName.equals("agentPayFlag")) {
/* 5303 */       return 90;
/*      */     }
/* 5305 */     if (strFieldName.equals("agentGetFlag")) {
/* 5306 */       return 91;
/*      */     }
/* 5308 */     if (strFieldName.equals("liveGetMode")) {
/* 5309 */       return 92;
/*      */     }
/* 5311 */     if (strFieldName.equals("deadGetMode")) {
/* 5312 */       return 93;
/*      */     }
/* 5314 */     if (strFieldName.equals("bonusGetMode")) {
/* 5315 */       return 94;
/*      */     }
/* 5317 */     if (strFieldName.equals("deadAmntType")) {
/* 5318 */       return 95;
/*      */     }
/* 5320 */     if (strFieldName.equals("topUpPrem")) {
/* 5321 */       return 96;
/*      */     }
/* 5323 */     if (strFieldName.equals("bonusMan")) {
/* 5324 */       return 97;
/*      */     }
/* 5326 */     if (strFieldName.equals("deadFlag")) {
/* 5327 */       return 98;
/*      */     }
/* 5329 */     if (strFieldName.equals("smokeFlag")) {
/* 5330 */       return 99;
/*      */     }
/* 5332 */     if (strFieldName.equals("remark")) {
/* 5333 */       return 100;
/*      */     }
/* 5335 */     if (strFieldName.equals("approveFlag")) {
/* 5336 */       return 101;
/*      */     }
/* 5338 */     if (strFieldName.equals("approveCode")) {
/* 5339 */       return 102;
/*      */     }
/* 5341 */     if (strFieldName.equals("approveDate")) {
/* 5342 */       return 103;
/*      */     }
/* 5344 */     if (strFieldName.equals("approveTime")) {
/* 5345 */       return 104;
/*      */     }
/* 5347 */     if (strFieldName.equals("uWFlag")) {
/* 5348 */       return 105;
/*      */     }
/* 5350 */     if (strFieldName.equals("uWCode")) {
/* 5351 */       return 106;
/*      */     }
/* 5353 */     if (strFieldName.equals("uWDate")) {
/* 5354 */       return 107;
/*      */     }
/* 5356 */     if (strFieldName.equals("uWTime")) {
/* 5357 */       return 108;
/*      */     }
/* 5359 */     if (strFieldName.equals("polApplyDate")) {
/* 5360 */       return 109;
/*      */     }
/* 5362 */     if (strFieldName.equals("appFlag")) {
/* 5363 */       return 110;
/*      */     }
/* 5365 */     if (strFieldName.equals("saleChnlDetail")) {
/* 5366 */       return 111;
/*      */     }
/* 5368 */     if (strFieldName.equals("polState")) {
/* 5369 */       return 112;
/*      */     }
/* 5371 */     if (strFieldName.equals("standbyFlag1")) {
/* 5372 */       return 113;
/*      */     }
/* 5374 */     if (strFieldName.equals("standbyFlag2")) {
/* 5375 */       return 114;
/*      */     }
/* 5377 */     if (strFieldName.equals("standbyFlag3")) {
/* 5378 */       return 115;
/*      */     }
/* 5380 */     if (strFieldName.equals("operator")) {
/* 5381 */       return 116;
/*      */     }
/* 5383 */     if (strFieldName.equals("makeDate")) {
/* 5384 */       return 117;
/*      */     }
/* 5386 */     if (strFieldName.equals("makeTime")) {
/* 5387 */       return 118;
/*      */     }
/* 5389 */     if (strFieldName.equals("modifyDate")) {
/* 5390 */       return 119;
/*      */     }
/* 5392 */     if (strFieldName.equals("modifyTime")) {
/* 5393 */       return 120;
/*      */     }
/* 5395 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 5401 */     String strFieldName = "";
/* 5402 */     switch (nFieldIndex) {
/*      */     case 0:
/* 5404 */       strFieldName = "EdorNo";
/* 5405 */       break;
/*      */     case 1:
/* 5407 */       strFieldName = "serialNo";
/* 5408 */       break;
/*      */     case 2:
/* 5410 */       strFieldName = "grpContNo";
/* 5411 */       break;
/*      */     case 3:
/* 5413 */       strFieldName = "grpPolNo";
/* 5414 */       break;
/*      */     case 4:
/* 5416 */       strFieldName = "contNo";
/* 5417 */       break;
/*      */     case 5:
/* 5419 */       strFieldName = "proposalContNo";
/* 5420 */       break;
/*      */     case 6:
/* 5422 */       strFieldName = "polNo";
/* 5423 */       break;
/*      */     case 7:
/* 5425 */       strFieldName = "proposalNo";
/* 5426 */       break;
/*      */     case 8:
/* 5428 */       strFieldName = "prtNo";
/* 5429 */       break;
/*      */     case 9:
/* 5431 */       strFieldName = "contType";
/* 5432 */       break;
/*      */     case 10:
/* 5434 */       strFieldName = "polTypeFlag";
/* 5435 */       break;
/*      */     case 11:
/* 5437 */       strFieldName = "mainPolNo";
/* 5438 */       break;
/*      */     case 12:
/* 5440 */       strFieldName = "masterPolNo";
/* 5441 */       break;
/*      */     case 13:
/* 5443 */       strFieldName = "kindCode";
/* 5444 */       break;
/*      */     case 14:
/* 5446 */       strFieldName = "riskCode";
/* 5447 */       break;
/*      */     case 15:
/* 5449 */       strFieldName = "riskVersion";
/* 5450 */       break;
/*      */     case 16:
/* 5452 */       strFieldName = "manageCom";
/* 5453 */       break;
/*      */     case 17:
/* 5455 */       strFieldName = "agentCom";
/* 5456 */       break;
/*      */     case 18:
/* 5458 */       strFieldName = "agentType";
/* 5459 */       break;
/*      */     case 19:
/* 5461 */       strFieldName = "agentCode";
/* 5462 */       break;
/*      */     case 20:
/* 5464 */       strFieldName = "agentGroup";
/* 5465 */       break;
/*      */     case 21:
/* 5467 */       strFieldName = "agentGroup1";
/* 5468 */       break;
/*      */     case 22:
/* 5470 */       strFieldName = "agentCode1";
/* 5471 */       break;
/*      */     case 23:
/* 5473 */       strFieldName = "saleChnl";
/* 5474 */       break;
/*      */     case 24:
/* 5476 */       strFieldName = "handler";
/* 5477 */       break;
/*      */     case 25:
/* 5479 */       strFieldName = "insuredNo";
/* 5480 */       break;
/*      */     case 26:
/* 5482 */       strFieldName = "insuredId";
/* 5483 */       break;
/*      */     case 27:
/* 5485 */       strFieldName = "insuredName";
/* 5486 */       break;
/*      */     case 28:
/* 5488 */       strFieldName = "insuredSex";
/* 5489 */       break;
/*      */     case 29:
/* 5491 */       strFieldName = "insuredBirthday";
/* 5492 */       break;
/*      */     case 30:
/* 5494 */       strFieldName = "insuredAppAge";
/* 5495 */       break;
/*      */     case 31:
/* 5497 */       strFieldName = "insuredPeoples";
/* 5498 */       break;
/*      */     case 32:
/* 5500 */       strFieldName = "occupationType";
/* 5501 */       break;
/*      */     case 33:
/* 5503 */       strFieldName = "appntNo";
/* 5504 */       break;
/*      */     case 34:
/* 5506 */       strFieldName = "appntName";
/* 5507 */       break;
/*      */     case 35:
/* 5509 */       strFieldName = "cValiDate";
/* 5510 */       break;
/*      */     case 36:
/* 5512 */       strFieldName = "signCom";
/* 5513 */       break;
/*      */     case 37:
/* 5515 */       strFieldName = "signDate";
/* 5516 */       break;
/*      */     case 38:
/* 5518 */       strFieldName = "signTime";
/* 5519 */       break;
/*      */     case 39:
/* 5521 */       strFieldName = "firstPayDate";
/* 5522 */       break;
/*      */     case 40:
/* 5524 */       strFieldName = "payEndDate";
/* 5525 */       break;
/*      */     case 41:
/* 5527 */       strFieldName = "paytoDate";
/* 5528 */       break;
/*      */     case 42:
/* 5530 */       strFieldName = "getStartDate";
/* 5531 */       break;
/*      */     case 43:
/* 5533 */       strFieldName = "endDate";
/* 5534 */       break;
/*      */     case 44:
/* 5536 */       strFieldName = "acciEndDate";
/* 5537 */       break;
/*      */     case 45:
/* 5539 */       strFieldName = "getYearFlag";
/* 5540 */       break;
/*      */     case 46:
/* 5542 */       strFieldName = "getYear";
/* 5543 */       break;
/*      */     case 47:
/* 5545 */       strFieldName = "payEndYearFlag";
/* 5546 */       break;
/*      */     case 48:
/* 5548 */       strFieldName = "payEndYear";
/* 5549 */       break;
/*      */     case 49:
/* 5551 */       strFieldName = "insuYearFlag";
/* 5552 */       break;
/*      */     case 50:
/* 5554 */       strFieldName = "insuYear";
/* 5555 */       break;
/*      */     case 51:
/* 5557 */       strFieldName = "acciYearFlag";
/* 5558 */       break;
/*      */     case 52:
/* 5560 */       strFieldName = "acciYear";
/* 5561 */       break;
/*      */     case 53:
/* 5563 */       strFieldName = "getStartType";
/* 5564 */       break;
/*      */     case 54:
/* 5566 */       strFieldName = "specifyValiDate";
/* 5567 */       break;
/*      */     case 55:
/* 5569 */       strFieldName = "payMode";
/* 5570 */       break;
/*      */     case 56:
/* 5572 */       strFieldName = "payLocation";
/* 5573 */       break;
/*      */     case 57:
/* 5575 */       strFieldName = "payIntv";
/* 5576 */       break;
/*      */     case 58:
/* 5578 */       strFieldName = "payYears";
/* 5579 */       break;
/*      */     case 59:
/* 5581 */       strFieldName = "years";
/* 5582 */       break;
/*      */     case 60:
/* 5584 */       strFieldName = "manageFeeRate";
/* 5585 */       break;
/*      */     case 61:
/* 5587 */       strFieldName = "floatRate";
/* 5588 */       break;
/*      */     case 62:
/* 5590 */       strFieldName = "premRate";
/* 5591 */       break;
/*      */     case 63:
/* 5593 */       strFieldName = "premToAmnt";
/* 5594 */       break;
/*      */     case 64:
/* 5596 */       strFieldName = "mult";
/* 5597 */       break;
/*      */     case 65:
/* 5599 */       strFieldName = "standPrem";
/* 5600 */       break;
/*      */     case 66:
/* 5602 */       strFieldName = "prem";
/* 5603 */       break;
/*      */     case 67:
/* 5605 */       strFieldName = "sumPrem";
/* 5606 */       break;
/*      */     case 68:
/* 5608 */       strFieldName = "amnt";
/* 5609 */       break;
/*      */     case 69:
/* 5611 */       strFieldName = "riskAmnt";
/* 5612 */       break;
/*      */     case 70:
/* 5614 */       strFieldName = "leavingMoney";
/* 5615 */       break;
/*      */     case 71:
/* 5617 */       strFieldName = "endorseTimes";
/* 5618 */       break;
/*      */     case 72:
/* 5620 */       strFieldName = "claimTimes";
/* 5621 */       break;
/*      */     case 73:
/* 5623 */       strFieldName = "liveTimes";
/* 5624 */       break;
/*      */     case 74:
/* 5626 */       strFieldName = "renewCount";
/* 5627 */       break;
/*      */     case 75:
/* 5629 */       strFieldName = "lastGetDate";
/* 5630 */       break;
/*      */     case 76:
/* 5632 */       strFieldName = "lastLoanDate";
/* 5633 */       break;
/*      */     case 77:
/* 5635 */       strFieldName = "lastRegetDate";
/* 5636 */       break;
/*      */     case 78:
/* 5638 */       strFieldName = "lastEdorDate";
/* 5639 */       break;
/*      */     case 79:
/* 5641 */       strFieldName = "lastRevDate";
/* 5642 */       break;
/*      */     case 80:
/* 5644 */       strFieldName = "rnewFlag";
/* 5645 */       break;
/*      */     case 81:
/* 5647 */       strFieldName = "stopFlag";
/* 5648 */       break;
/*      */     case 82:
/* 5650 */       strFieldName = "expiryFlag";
/* 5651 */       break;
/*      */     case 83:
/* 5653 */       strFieldName = "autoPayFlag";
/* 5654 */       break;
/*      */     case 84:
/* 5656 */       strFieldName = "interestDifFlag";
/* 5657 */       break;
/*      */     case 85:
/* 5659 */       strFieldName = "subFlag";
/* 5660 */       break;
/*      */     case 86:
/* 5662 */       strFieldName = "bnfFlag";
/* 5663 */       break;
/*      */     case 87:
/* 5665 */       strFieldName = "healthCheckFlag";
/* 5666 */       break;
/*      */     case 88:
/* 5668 */       strFieldName = "impartFlag";
/* 5669 */       break;
/*      */     case 89:
/* 5671 */       strFieldName = "reinsureFlag";
/* 5672 */       break;
/*      */     case 90:
/* 5674 */       strFieldName = "agentPayFlag";
/* 5675 */       break;
/*      */     case 91:
/* 5677 */       strFieldName = "agentGetFlag";
/* 5678 */       break;
/*      */     case 92:
/* 5680 */       strFieldName = "liveGetMode";
/* 5681 */       break;
/*      */     case 93:
/* 5683 */       strFieldName = "deadGetMode";
/* 5684 */       break;
/*      */     case 94:
/* 5686 */       strFieldName = "bonusGetMode";
/* 5687 */       break;
/*      */     case 95:
/* 5689 */       strFieldName = "deadAmntType";
/* 5690 */       break;
/*      */     case 96:
/* 5692 */       strFieldName = "topUpPrem";
/* 5693 */       break;
/*      */     case 97:
/* 5695 */       strFieldName = "bonusMan";
/* 5696 */       break;
/*      */     case 98:
/* 5698 */       strFieldName = "deadFlag";
/* 5699 */       break;
/*      */     case 99:
/* 5701 */       strFieldName = "smokeFlag";
/* 5702 */       break;
/*      */     case 100:
/* 5704 */       strFieldName = "remark";
/* 5705 */       break;
/*      */     case 101:
/* 5707 */       strFieldName = "approveFlag";
/* 5708 */       break;
/*      */     case 102:
/* 5710 */       strFieldName = "approveCode";
/* 5711 */       break;
/*      */     case 103:
/* 5713 */       strFieldName = "approveDate";
/* 5714 */       break;
/*      */     case 104:
/* 5716 */       strFieldName = "approveTime";
/* 5717 */       break;
/*      */     case 105:
/* 5719 */       strFieldName = "uWFlag";
/* 5720 */       break;
/*      */     case 106:
/* 5722 */       strFieldName = "uWCode";
/* 5723 */       break;
/*      */     case 107:
/* 5725 */       strFieldName = "uWDate";
/* 5726 */       break;
/*      */     case 108:
/* 5728 */       strFieldName = "uWTime";
/* 5729 */       break;
/*      */     case 109:
/* 5731 */       strFieldName = "polApplyDate";
/* 5732 */       break;
/*      */     case 110:
/* 5734 */       strFieldName = "appFlag";
/* 5735 */       break;
/*      */     case 111:
/* 5737 */       strFieldName = "saleChnlDetail";
/* 5738 */       break;
/*      */     case 112:
/* 5740 */       strFieldName = "polState";
/* 5741 */       break;
/*      */     case 113:
/* 5743 */       strFieldName = "standbyFlag1";
/* 5744 */       break;
/*      */     case 114:
/* 5746 */       strFieldName = "standbyFlag2";
/* 5747 */       break;
/*      */     case 115:
/* 5749 */       strFieldName = "standbyFlag3";
/* 5750 */       break;
/*      */     case 116:
/* 5752 */       strFieldName = "operator";
/* 5753 */       break;
/*      */     case 117:
/* 5755 */       strFieldName = "makeDate";
/* 5756 */       break;
/*      */     case 118:
/* 5758 */       strFieldName = "makeTime";
/* 5759 */       break;
/*      */     case 119:
/* 5761 */       strFieldName = "modifyDate";
/* 5762 */       break;
/*      */     case 120:
/* 5764 */       strFieldName = "modifyTime";
/* 5765 */       break;
/*      */     default:
/* 5767 */       strFieldName = "";
/*      */     }
/* 5769 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 5775 */     if (strFieldName.equals("EdorNo")) {
/* 5776 */       return 0;
/*      */     }
/* 5778 */     if (strFieldName.equals("serialNo")) {
/* 5779 */       return 0;
/*      */     }
/* 5781 */     if (strFieldName.equals("grpContNo")) {
/* 5782 */       return 0;
/*      */     }
/* 5784 */     if (strFieldName.equals("grpPolNo")) {
/* 5785 */       return 0;
/*      */     }
/* 5787 */     if (strFieldName.equals("contNo")) {
/* 5788 */       return 0;
/*      */     }
/* 5790 */     if (strFieldName.equals("proposalContNo")) {
/* 5791 */       return 0;
/*      */     }
/* 5793 */     if (strFieldName.equals("polNo")) {
/* 5794 */       return 0;
/*      */     }
/* 5796 */     if (strFieldName.equals("proposalNo")) {
/* 5797 */       return 0;
/*      */     }
/* 5799 */     if (strFieldName.equals("prtNo")) {
/* 5800 */       return 0;
/*      */     }
/* 5802 */     if (strFieldName.equals("contType")) {
/* 5803 */       return 0;
/*      */     }
/* 5805 */     if (strFieldName.equals("polTypeFlag")) {
/* 5806 */       return 0;
/*      */     }
/* 5808 */     if (strFieldName.equals("mainPolNo")) {
/* 5809 */       return 0;
/*      */     }
/* 5811 */     if (strFieldName.equals("masterPolNo")) {
/* 5812 */       return 0;
/*      */     }
/* 5814 */     if (strFieldName.equals("kindCode")) {
/* 5815 */       return 0;
/*      */     }
/* 5817 */     if (strFieldName.equals("riskCode")) {
/* 5818 */       return 0;
/*      */     }
/* 5820 */     if (strFieldName.equals("riskVersion")) {
/* 5821 */       return 0;
/*      */     }
/* 5823 */     if (strFieldName.equals("manageCom")) {
/* 5824 */       return 0;
/*      */     }
/* 5826 */     if (strFieldName.equals("agentCom")) {
/* 5827 */       return 0;
/*      */     }
/* 5829 */     if (strFieldName.equals("agentType")) {
/* 5830 */       return 0;
/*      */     }
/* 5832 */     if (strFieldName.equals("agentCode")) {
/* 5833 */       return 0;
/*      */     }
/* 5835 */     if (strFieldName.equals("agentGroup")) {
/* 5836 */       return 0;
/*      */     }
/* 5838 */     if (strFieldName.equals("agentGroup1")) {
/* 5839 */       return 0;
/*      */     }
/* 5841 */     if (strFieldName.equals("agentCode1")) {
/* 5842 */       return 0;
/*      */     }
/* 5844 */     if (strFieldName.equals("saleChnl")) {
/* 5845 */       return 0;
/*      */     }
/* 5847 */     if (strFieldName.equals("handler")) {
/* 5848 */       return 0;
/*      */     }
/* 5850 */     if (strFieldName.equals("insuredNo")) {
/* 5851 */       return 0;
/*      */     }
/* 5853 */     if (strFieldName.equals("insuredId")) {
/* 5854 */       return 0;
/*      */     }
/* 5856 */     if (strFieldName.equals("insuredName")) {
/* 5857 */       return 0;
/*      */     }
/* 5859 */     if (strFieldName.equals("insuredSex")) {
/* 5860 */       return 0;
/*      */     }
/* 5862 */     if (strFieldName.equals("insuredBirthday")) {
/* 5863 */       return 1;
/*      */     }
/* 5865 */     if (strFieldName.equals("insuredAppAge")) {
/* 5866 */       return 3;
/*      */     }
/* 5868 */     if (strFieldName.equals("insuredPeoples")) {
/* 5869 */       return 3;
/*      */     }
/* 5871 */     if (strFieldName.equals("occupationType")) {
/* 5872 */       return 0;
/*      */     }
/* 5874 */     if (strFieldName.equals("appntNo")) {
/* 5875 */       return 0;
/*      */     }
/* 5877 */     if (strFieldName.equals("appntName")) {
/* 5878 */       return 0;
/*      */     }
/* 5880 */     if (strFieldName.equals("cValiDate")) {
/* 5881 */       return 1;
/*      */     }
/* 5883 */     if (strFieldName.equals("signCom")) {
/* 5884 */       return 0;
/*      */     }
/* 5886 */     if (strFieldName.equals("signDate")) {
/* 5887 */       return 1;
/*      */     }
/* 5889 */     if (strFieldName.equals("signTime")) {
/* 5890 */       return 0;
/*      */     }
/* 5892 */     if (strFieldName.equals("firstPayDate")) {
/* 5893 */       return 1;
/*      */     }
/* 5895 */     if (strFieldName.equals("payEndDate")) {
/* 5896 */       return 1;
/*      */     }
/* 5898 */     if (strFieldName.equals("paytoDate")) {
/* 5899 */       return 1;
/*      */     }
/* 5901 */     if (strFieldName.equals("getStartDate")) {
/* 5902 */       return 1;
/*      */     }
/* 5904 */     if (strFieldName.equals("endDate")) {
/* 5905 */       return 1;
/*      */     }
/* 5907 */     if (strFieldName.equals("acciEndDate")) {
/* 5908 */       return 1;
/*      */     }
/* 5910 */     if (strFieldName.equals("getYearFlag")) {
/* 5911 */       return 0;
/*      */     }
/* 5913 */     if (strFieldName.equals("getYear")) {
/* 5914 */       return 3;
/*      */     }
/* 5916 */     if (strFieldName.equals("payEndYearFlag")) {
/* 5917 */       return 0;
/*      */     }
/* 5919 */     if (strFieldName.equals("payEndYear")) {
/* 5920 */       return 3;
/*      */     }
/* 5922 */     if (strFieldName.equals("insuYearFlag")) {
/* 5923 */       return 0;
/*      */     }
/* 5925 */     if (strFieldName.equals("insuYear")) {
/* 5926 */       return 3;
/*      */     }
/* 5928 */     if (strFieldName.equals("acciYearFlag")) {
/* 5929 */       return 0;
/*      */     }
/* 5931 */     if (strFieldName.equals("acciYear")) {
/* 5932 */       return 3;
/*      */     }
/* 5934 */     if (strFieldName.equals("getStartType")) {
/* 5935 */       return 0;
/*      */     }
/* 5937 */     if (strFieldName.equals("specifyValiDate")) {
/* 5938 */       return 0;
/*      */     }
/* 5940 */     if (strFieldName.equals("payMode")) {
/* 5941 */       return 0;
/*      */     }
/* 5943 */     if (strFieldName.equals("payLocation")) {
/* 5944 */       return 0;
/*      */     }
/* 5946 */     if (strFieldName.equals("payIntv")) {
/* 5947 */       return 3;
/*      */     }
/* 5949 */     if (strFieldName.equals("payYears")) {
/* 5950 */       return 3;
/*      */     }
/* 5952 */     if (strFieldName.equals("years")) {
/* 5953 */       return 3;
/*      */     }
/* 5955 */     if (strFieldName.equals("manageFeeRate")) {
/* 5956 */       return 4;
/*      */     }
/* 5958 */     if (strFieldName.equals("floatRate")) {
/* 5959 */       return 4;
/*      */     }
/* 5961 */     if (strFieldName.equals("premRate")) {
/* 5962 */       return 4;
/*      */     }
/* 5964 */     if (strFieldName.equals("premToAmnt")) {
/* 5965 */       return 0;
/*      */     }
/* 5967 */     if (strFieldName.equals("mult")) {
/* 5968 */       return 4;
/*      */     }
/* 5970 */     if (strFieldName.equals("standPrem")) {
/* 5971 */       return 4;
/*      */     }
/* 5973 */     if (strFieldName.equals("prem")) {
/* 5974 */       return 4;
/*      */     }
/* 5976 */     if (strFieldName.equals("sumPrem")) {
/* 5977 */       return 4;
/*      */     }
/* 5979 */     if (strFieldName.equals("amnt")) {
/* 5980 */       return 4;
/*      */     }
/* 5982 */     if (strFieldName.equals("riskAmnt")) {
/* 5983 */       return 4;
/*      */     }
/* 5985 */     if (strFieldName.equals("leavingMoney")) {
/* 5986 */       return 4;
/*      */     }
/* 5988 */     if (strFieldName.equals("endorseTimes")) {
/* 5989 */       return 3;
/*      */     }
/* 5991 */     if (strFieldName.equals("claimTimes")) {
/* 5992 */       return 3;
/*      */     }
/* 5994 */     if (strFieldName.equals("liveTimes")) {
/* 5995 */       return 3;
/*      */     }
/* 5997 */     if (strFieldName.equals("renewCount")) {
/* 5998 */       return 3;
/*      */     }
/* 6000 */     if (strFieldName.equals("lastGetDate")) {
/* 6001 */       return 1;
/*      */     }
/* 6003 */     if (strFieldName.equals("lastLoanDate")) {
/* 6004 */       return 1;
/*      */     }
/* 6006 */     if (strFieldName.equals("lastRegetDate")) {
/* 6007 */       return 1;
/*      */     }
/* 6009 */     if (strFieldName.equals("lastEdorDate")) {
/* 6010 */       return 1;
/*      */     }
/* 6012 */     if (strFieldName.equals("lastRevDate")) {
/* 6013 */       return 1;
/*      */     }
/* 6015 */     if (strFieldName.equals("rnewFlag")) {
/* 6016 */       return 0;
/*      */     }
/* 6018 */     if (strFieldName.equals("stopFlag")) {
/* 6019 */       return 0;
/*      */     }
/* 6021 */     if (strFieldName.equals("expiryFlag")) {
/* 6022 */       return 0;
/*      */     }
/* 6024 */     if (strFieldName.equals("autoPayFlag")) {
/* 6025 */       return 0;
/*      */     }
/* 6027 */     if (strFieldName.equals("interestDifFlag")) {
/* 6028 */       return 0;
/*      */     }
/* 6030 */     if (strFieldName.equals("subFlag")) {
/* 6031 */       return 0;
/*      */     }
/* 6033 */     if (strFieldName.equals("bnfFlag")) {
/* 6034 */       return 0;
/*      */     }
/* 6036 */     if (strFieldName.equals("healthCheckFlag")) {
/* 6037 */       return 0;
/*      */     }
/* 6039 */     if (strFieldName.equals("impartFlag")) {
/* 6040 */       return 0;
/*      */     }
/* 6042 */     if (strFieldName.equals("reinsureFlag")) {
/* 6043 */       return 0;
/*      */     }
/* 6045 */     if (strFieldName.equals("agentPayFlag")) {
/* 6046 */       return 0;
/*      */     }
/* 6048 */     if (strFieldName.equals("agentGetFlag")) {
/* 6049 */       return 0;
/*      */     }
/* 6051 */     if (strFieldName.equals("liveGetMode")) {
/* 6052 */       return 0;
/*      */     }
/* 6054 */     if (strFieldName.equals("deadGetMode")) {
/* 6055 */       return 0;
/*      */     }
/* 6057 */     if (strFieldName.equals("bonusGetMode")) {
/* 6058 */       return 0;
/*      */     }
/* 6060 */     if (strFieldName.equals("deadAmntType")) {
/* 6061 */       return 0;
/*      */     }
/* 6063 */     if (strFieldName.equals("topUpPrem")) {
/* 6064 */       return 4;
/*      */     }
/* 6066 */     if (strFieldName.equals("bonusMan")) {
/* 6067 */       return 0;
/*      */     }
/* 6069 */     if (strFieldName.equals("deadFlag")) {
/* 6070 */       return 0;
/*      */     }
/* 6072 */     if (strFieldName.equals("smokeFlag")) {
/* 6073 */       return 0;
/*      */     }
/* 6075 */     if (strFieldName.equals("remark")) {
/* 6076 */       return 0;
/*      */     }
/* 6078 */     if (strFieldName.equals("approveFlag")) {
/* 6079 */       return 0;
/*      */     }
/* 6081 */     if (strFieldName.equals("approveCode")) {
/* 6082 */       return 0;
/*      */     }
/* 6084 */     if (strFieldName.equals("approveDate")) {
/* 6085 */       return 1;
/*      */     }
/* 6087 */     if (strFieldName.equals("approveTime")) {
/* 6088 */       return 0;
/*      */     }
/* 6090 */     if (strFieldName.equals("uWFlag")) {
/* 6091 */       return 0;
/*      */     }
/* 6093 */     if (strFieldName.equals("uWCode")) {
/* 6094 */       return 0;
/*      */     }
/* 6096 */     if (strFieldName.equals("uWDate")) {
/* 6097 */       return 1;
/*      */     }
/* 6099 */     if (strFieldName.equals("uWTime")) {
/* 6100 */       return 0;
/*      */     }
/* 6102 */     if (strFieldName.equals("polApplyDate")) {
/* 6103 */       return 1;
/*      */     }
/* 6105 */     if (strFieldName.equals("appFlag")) {
/* 6106 */       return 0;
/*      */     }
/* 6108 */     if (strFieldName.equals("saleChnlDetail")) {
/* 6109 */       return 0;
/*      */     }
/* 6111 */     if (strFieldName.equals("polState")) {
/* 6112 */       return 0;
/*      */     }
/* 6114 */     if (strFieldName.equals("standbyFlag1")) {
/* 6115 */       return 0;
/*      */     }
/* 6117 */     if (strFieldName.equals("standbyFlag2")) {
/* 6118 */       return 0;
/*      */     }
/* 6120 */     if (strFieldName.equals("standbyFlag3")) {
/* 6121 */       return 0;
/*      */     }
/* 6123 */     if (strFieldName.equals("operator")) {
/* 6124 */       return 0;
/*      */     }
/* 6126 */     if (strFieldName.equals("makeDate")) {
/* 6127 */       return 1;
/*      */     }
/* 6129 */     if (strFieldName.equals("makeTime")) {
/* 6130 */       return 0;
/*      */     }
/* 6132 */     if (strFieldName.equals("modifyDate")) {
/* 6133 */       return 1;
/*      */     }
/* 6135 */     if (strFieldName.equals("modifyTime")) {
/* 6136 */       return 0;
/*      */     }
/* 6138 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 6144 */     int nFieldType = -1;
/* 6145 */     switch (nFieldIndex) {
/*      */     case 0:
/* 6147 */       nFieldType = 0;
/* 6148 */       break;
/*      */     case 1:
/* 6150 */       nFieldType = 0;
/* 6151 */       break;
/*      */     case 2:
/* 6153 */       nFieldType = 0;
/* 6154 */       break;
/*      */     case 3:
/* 6156 */       nFieldType = 0;
/* 6157 */       break;
/*      */     case 4:
/* 6159 */       nFieldType = 0;
/* 6160 */       break;
/*      */     case 5:
/* 6162 */       nFieldType = 0;
/* 6163 */       break;
/*      */     case 6:
/* 6165 */       nFieldType = 0;
/* 6166 */       break;
/*      */     case 7:
/* 6168 */       nFieldType = 0;
/* 6169 */       break;
/*      */     case 8:
/* 6171 */       nFieldType = 0;
/* 6172 */       break;
/*      */     case 9:
/* 6174 */       nFieldType = 0;
/* 6175 */       break;
/*      */     case 10:
/* 6177 */       nFieldType = 0;
/* 6178 */       break;
/*      */     case 11:
/* 6180 */       nFieldType = 0;
/* 6181 */       break;
/*      */     case 12:
/* 6183 */       nFieldType = 0;
/* 6184 */       break;
/*      */     case 13:
/* 6186 */       nFieldType = 0;
/* 6187 */       break;
/*      */     case 14:
/* 6189 */       nFieldType = 0;
/* 6190 */       break;
/*      */     case 15:
/* 6192 */       nFieldType = 0;
/* 6193 */       break;
/*      */     case 16:
/* 6195 */       nFieldType = 0;
/* 6196 */       break;
/*      */     case 17:
/* 6198 */       nFieldType = 0;
/* 6199 */       break;
/*      */     case 18:
/* 6201 */       nFieldType = 0;
/* 6202 */       break;
/*      */     case 19:
/* 6204 */       nFieldType = 0;
/* 6205 */       break;
/*      */     case 20:
/* 6207 */       nFieldType = 0;
/* 6208 */       break;
/*      */     case 21:
/* 6210 */       nFieldType = 0;
/* 6211 */       break;
/*      */     case 22:
/* 6213 */       nFieldType = 0;
/* 6214 */       break;
/*      */     case 23:
/* 6216 */       nFieldType = 0;
/* 6217 */       break;
/*      */     case 24:
/* 6219 */       nFieldType = 0;
/* 6220 */       break;
/*      */     case 25:
/* 6222 */       nFieldType = 0;
/* 6223 */       break;
/*      */     case 26:
/* 6225 */       nFieldType = 0;
/* 6226 */       break;
/*      */     case 27:
/* 6228 */       nFieldType = 0;
/* 6229 */       break;
/*      */     case 28:
/* 6231 */       nFieldType = 0;
/* 6232 */       break;
/*      */     case 29:
/* 6234 */       nFieldType = 1;
/* 6235 */       break;
/*      */     case 30:
/* 6237 */       nFieldType = 3;
/* 6238 */       break;
/*      */     case 31:
/* 6240 */       nFieldType = 3;
/* 6241 */       break;
/*      */     case 32:
/* 6243 */       nFieldType = 0;
/* 6244 */       break;
/*      */     case 33:
/* 6246 */       nFieldType = 0;
/* 6247 */       break;
/*      */     case 34:
/* 6249 */       nFieldType = 0;
/* 6250 */       break;
/*      */     case 35:
/* 6252 */       nFieldType = 1;
/* 6253 */       break;
/*      */     case 36:
/* 6255 */       nFieldType = 0;
/* 6256 */       break;
/*      */     case 37:
/* 6258 */       nFieldType = 1;
/* 6259 */       break;
/*      */     case 38:
/* 6261 */       nFieldType = 0;
/* 6262 */       break;
/*      */     case 39:
/* 6264 */       nFieldType = 1;
/* 6265 */       break;
/*      */     case 40:
/* 6267 */       nFieldType = 1;
/* 6268 */       break;
/*      */     case 41:
/* 6270 */       nFieldType = 1;
/* 6271 */       break;
/*      */     case 42:
/* 6273 */       nFieldType = 1;
/* 6274 */       break;
/*      */     case 43:
/* 6276 */       nFieldType = 1;
/* 6277 */       break;
/*      */     case 44:
/* 6279 */       nFieldType = 1;
/* 6280 */       break;
/*      */     case 45:
/* 6282 */       nFieldType = 0;
/* 6283 */       break;
/*      */     case 46:
/* 6285 */       nFieldType = 3;
/* 6286 */       break;
/*      */     case 47:
/* 6288 */       nFieldType = 0;
/* 6289 */       break;
/*      */     case 48:
/* 6291 */       nFieldType = 3;
/* 6292 */       break;
/*      */     case 49:
/* 6294 */       nFieldType = 0;
/* 6295 */       break;
/*      */     case 50:
/* 6297 */       nFieldType = 3;
/* 6298 */       break;
/*      */     case 51:
/* 6300 */       nFieldType = 0;
/* 6301 */       break;
/*      */     case 52:
/* 6303 */       nFieldType = 3;
/* 6304 */       break;
/*      */     case 53:
/* 6306 */       nFieldType = 0;
/* 6307 */       break;
/*      */     case 54:
/* 6309 */       nFieldType = 0;
/* 6310 */       break;
/*      */     case 55:
/* 6312 */       nFieldType = 0;
/* 6313 */       break;
/*      */     case 56:
/* 6315 */       nFieldType = 0;
/* 6316 */       break;
/*      */     case 57:
/* 6318 */       nFieldType = 3;
/* 6319 */       break;
/*      */     case 58:
/* 6321 */       nFieldType = 3;
/* 6322 */       break;
/*      */     case 59:
/* 6324 */       nFieldType = 3;
/* 6325 */       break;
/*      */     case 60:
/* 6327 */       nFieldType = 4;
/* 6328 */       break;
/*      */     case 61:
/* 6330 */       nFieldType = 4;
/* 6331 */       break;
/*      */     case 62:
/* 6333 */       nFieldType = 4;
/* 6334 */       break;
/*      */     case 63:
/* 6336 */       nFieldType = 0;
/* 6337 */       break;
/*      */     case 64:
/* 6339 */       nFieldType = 4;
/* 6340 */       break;
/*      */     case 65:
/* 6342 */       nFieldType = 4;
/* 6343 */       break;
/*      */     case 66:
/* 6345 */       nFieldType = 4;
/* 6346 */       break;
/*      */     case 67:
/* 6348 */       nFieldType = 4;
/* 6349 */       break;
/*      */     case 68:
/* 6351 */       nFieldType = 4;
/* 6352 */       break;
/*      */     case 69:
/* 6354 */       nFieldType = 4;
/* 6355 */       break;
/*      */     case 70:
/* 6357 */       nFieldType = 4;
/* 6358 */       break;
/*      */     case 71:
/* 6360 */       nFieldType = 3;
/* 6361 */       break;
/*      */     case 72:
/* 6363 */       nFieldType = 3;
/* 6364 */       break;
/*      */     case 73:
/* 6366 */       nFieldType = 3;
/* 6367 */       break;
/*      */     case 74:
/* 6369 */       nFieldType = 3;
/* 6370 */       break;
/*      */     case 75:
/* 6372 */       nFieldType = 1;
/* 6373 */       break;
/*      */     case 76:
/* 6375 */       nFieldType = 1;
/* 6376 */       break;
/*      */     case 77:
/* 6378 */       nFieldType = 1;
/* 6379 */       break;
/*      */     case 78:
/* 6381 */       nFieldType = 1;
/* 6382 */       break;
/*      */     case 79:
/* 6384 */       nFieldType = 1;
/* 6385 */       break;
/*      */     case 80:
/* 6387 */       nFieldType = 0;
/* 6388 */       break;
/*      */     case 81:
/* 6390 */       nFieldType = 0;
/* 6391 */       break;
/*      */     case 82:
/* 6393 */       nFieldType = 0;
/* 6394 */       break;
/*      */     case 83:
/* 6396 */       nFieldType = 0;
/* 6397 */       break;
/*      */     case 84:
/* 6399 */       nFieldType = 0;
/* 6400 */       break;
/*      */     case 85:
/* 6402 */       nFieldType = 0;
/* 6403 */       break;
/*      */     case 86:
/* 6405 */       nFieldType = 0;
/* 6406 */       break;
/*      */     case 87:
/* 6408 */       nFieldType = 0;
/* 6409 */       break;
/*      */     case 88:
/* 6411 */       nFieldType = 0;
/* 6412 */       break;
/*      */     case 89:
/* 6414 */       nFieldType = 0;
/* 6415 */       break;
/*      */     case 90:
/* 6417 */       nFieldType = 0;
/* 6418 */       break;
/*      */     case 91:
/* 6420 */       nFieldType = 0;
/* 6421 */       break;
/*      */     case 92:
/* 6423 */       nFieldType = 0;
/* 6424 */       break;
/*      */     case 93:
/* 6426 */       nFieldType = 0;
/* 6427 */       break;
/*      */     case 94:
/* 6429 */       nFieldType = 0;
/* 6430 */       break;
/*      */     case 95:
/* 6432 */       nFieldType = 0;
/* 6433 */       break;
/*      */     case 96:
/* 6435 */       nFieldType = 4;
/* 6436 */       break;
/*      */     case 97:
/* 6438 */       nFieldType = 0;
/* 6439 */       break;
/*      */     case 98:
/* 6441 */       nFieldType = 0;
/* 6442 */       break;
/*      */     case 99:
/* 6444 */       nFieldType = 0;
/* 6445 */       break;
/*      */     case 100:
/* 6447 */       nFieldType = 0;
/* 6448 */       break;
/*      */     case 101:
/* 6450 */       nFieldType = 0;
/* 6451 */       break;
/*      */     case 102:
/* 6453 */       nFieldType = 0;
/* 6454 */       break;
/*      */     case 103:
/* 6456 */       nFieldType = 1;
/* 6457 */       break;
/*      */     case 104:
/* 6459 */       nFieldType = 0;
/* 6460 */       break;
/*      */     case 105:
/* 6462 */       nFieldType = 0;
/* 6463 */       break;
/*      */     case 106:
/* 6465 */       nFieldType = 0;
/* 6466 */       break;
/*      */     case 107:
/* 6468 */       nFieldType = 1;
/* 6469 */       break;
/*      */     case 108:
/* 6471 */       nFieldType = 0;
/* 6472 */       break;
/*      */     case 109:
/* 6474 */       nFieldType = 1;
/* 6475 */       break;
/*      */     case 110:
/* 6477 */       nFieldType = 0;
/* 6478 */       break;
/*      */     case 111:
/* 6480 */       nFieldType = 0;
/* 6481 */       break;
/*      */     case 112:
/* 6483 */       nFieldType = 0;
/* 6484 */       break;
/*      */     case 113:
/* 6486 */       nFieldType = 0;
/* 6487 */       break;
/*      */     case 114:
/* 6489 */       nFieldType = 0;
/* 6490 */       break;
/*      */     case 115:
/* 6492 */       nFieldType = 0;
/* 6493 */       break;
/*      */     case 116:
/* 6495 */       nFieldType = 0;
/* 6496 */       break;
/*      */     case 117:
/* 6498 */       nFieldType = 1;
/* 6499 */       break;
/*      */     case 118:
/* 6501 */       nFieldType = 0;
/* 6502 */       break;
/*      */     case 119:
/* 6504 */       nFieldType = 1;
/* 6505 */       break;
/*      */     case 120:
/* 6507 */       nFieldType = 0;
/* 6508 */       break;
/*      */     default:
/* 6510 */       nFieldType = -1;
/*      */     }
/* 6512 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPPolBSchema
 * JD-Core Version:    0.6.0
 */