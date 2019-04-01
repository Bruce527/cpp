/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPContBDB;
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
/*      */ public class LNPContBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String prtNo;
/*      */   private String mainPolNo;
/*      */   private String contType;
/*      */   private String familyType;
/*      */   private String familyID;
/*      */   private String polType;
/*      */   private String sugNo;
/*      */   private String cardFlag;
/*      */   private String manageCom;
/*      */   private String executeCom;
/*      */   private String agentCom;
/*      */   private String agentCode;
/*      */   private String agentGroup;
/*      */   private String agentCode1;
/*      */   private String agentGroup1;
/*      */   private String agentType;
/*      */   private String saleChnl;
/*      */   private String handler;
/*      */   private String password;
/*      */   private String appntNo;
/*      */   private String appntId;
/*      */   private String appntName;
/*      */   private String appntSex;
/*      */   private Date appntBirthday;
/*      */   private String appntIDType;
/*      */   private String appntIDNo;
/*      */   private String insuredNo;
/*      */   private String insuredId;
/*      */   private String insuredName;
/*      */   private String insuredSex;
/*      */   private Date insuredBirthday;
/*      */   private String insuredIDType;
/*      */   private String insuredIDNo;
/*      */   private int payIntv;
/*      */   private String payMode;
/*      */   private String payLocation;
/*      */   private String disputedFlag;
/*      */   private String outPayFlag;
/*      */   private String getPolMode;
/*      */   private String signCom;
/*      */   private Date signDate;
/*      */   private String signTime;
/*      */   private String consignNo;
/*      */   private String bankCode;
/*      */   private String bankAccNo;
/*      */   private String accName;
/*      */   private int printCount;
/*      */   private int lostTimes;
/*      */   private String lang;
/*      */   private String currency;
/*      */   private String remark;
/*      */   private int peoples;
/*      */   private double mult;
/*      */   private double prem;
/*      */   private double amnt;
/*      */   private double sumPrem;
/*      */   private double dif;
/*      */   private Date paytoDate;
/*      */   private Date firstPayDate;
/*      */   private Date cValiDate;
/*      */   private Date pSignDate;
/*      */   private Date pValiDate;
/*      */   private String inputOperator;
/*      */   private Date inputDate;
/*      */   private String inputTime;
/*      */   private String approveFlag;
/*      */   private String approveCode;
/*      */   private Date approveDate;
/*      */   private String approveTime;
/*      */   private String uWFlag;
/*      */   private String uWOperator;
/*      */   private Date uWDate;
/*      */   private String uWTime;
/*      */   private String appFlag;
/*      */   private Date polApplyDate;
/*      */   private Date getPolDate;
/*      */   private String getPolTime;
/*      */   private Date customGetPolDate;
/*      */   private String state;
/*      */   private String saleChnlDetail;
/*      */   private String proposalType;
/*      */   private String editstate;
/*      */   private Date cInValiDate;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 93;
/*      */   private static String[] PK;
/*  211 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPContBSchema()
/*      */   {
/*  218 */     this.mErrors = new CErrors();
/*      */ 
/*  220 */     String[] pk = new String[3];
/*  221 */     pk[0] = "EdorNo";
/*  222 */     pk[1] = "serialNo";
/*  223 */     pk[2] = "contNo";
/*      */ 
/*  225 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  231 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  236 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*  240 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  244 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*  248 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  252 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  256 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getgrpContNo() {
/*  260 */     if (this.grpContNo != null) this.grpContNo.equals("");
/*      */ 
/*  264 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setgrpContNo(String agrpContNo) {
/*  268 */     this.grpContNo = agrpContNo;
/*      */   }
/*      */ 
/*      */   public String getcontNo() {
/*  272 */     if (this.contNo != null) this.contNo.equals("");
/*      */ 
/*  276 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setcontNo(String acontNo) {
/*  280 */     this.contNo = acontNo;
/*      */   }
/*      */ 
/*      */   public String getproposalContNo() {
/*  284 */     if (this.proposalContNo != null) this.proposalContNo.equals("");
/*      */ 
/*  288 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setproposalContNo(String aproposalContNo) {
/*  292 */     this.proposalContNo = aproposalContNo;
/*      */   }
/*      */ 
/*      */   public String getprtNo() {
/*  296 */     if (this.prtNo != null) this.prtNo.equals("");
/*      */ 
/*  300 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setprtNo(String aprtNo) {
/*  304 */     this.prtNo = aprtNo;
/*      */   }
/*      */ 
/*      */   public String getmainPolNo() {
/*  308 */     if (this.mainPolNo != null) this.mainPolNo.equals("");
/*      */ 
/*  312 */     return this.mainPolNo;
/*      */   }
/*      */ 
/*      */   public void setmainPolNo(String amainPolNo) {
/*  316 */     this.mainPolNo = amainPolNo;
/*      */   }
/*      */ 
/*      */   public String getcontType() {
/*  320 */     if (this.contType != null) this.contType.equals("");
/*      */ 
/*  324 */     return this.contType;
/*      */   }
/*      */ 
/*      */   public void setcontType(String acontType) {
/*  328 */     this.contType = acontType;
/*      */   }
/*      */ 
/*      */   public String getfamilyType() {
/*  332 */     if (this.familyType != null) this.familyType.equals("");
/*      */ 
/*  336 */     return this.familyType;
/*      */   }
/*      */ 
/*      */   public void setfamilyType(String afamilyType) {
/*  340 */     this.familyType = afamilyType;
/*      */   }
/*      */ 
/*      */   public String getfamilyID() {
/*  344 */     if (this.familyID != null) this.familyID.equals("");
/*      */ 
/*  348 */     return this.familyID;
/*      */   }
/*      */ 
/*      */   public void setfamilyID(String afamilyID) {
/*  352 */     this.familyID = afamilyID;
/*      */   }
/*      */ 
/*      */   public String getpolType() {
/*  356 */     if (this.polType != null) this.polType.equals("");
/*      */ 
/*  360 */     return this.polType;
/*      */   }
/*      */ 
/*      */   public void setpolType(String apolType) {
/*  364 */     this.polType = apolType;
/*      */   }
/*      */ 
/*      */   public String getsugNo() {
/*  368 */     if (this.sugNo != null) this.sugNo.equals("");
/*      */ 
/*  372 */     return this.sugNo;
/*      */   }
/*      */ 
/*      */   public void setsugNo(String asugNo) {
/*  376 */     this.sugNo = asugNo;
/*      */   }
/*      */ 
/*      */   public String getcardFlag() {
/*  380 */     if (this.cardFlag != null) this.cardFlag.equals("");
/*      */ 
/*  384 */     return this.cardFlag;
/*      */   }
/*      */ 
/*      */   public void setcardFlag(String acardFlag) {
/*  388 */     this.cardFlag = acardFlag;
/*      */   }
/*      */ 
/*      */   public String getmanageCom() {
/*  392 */     if (this.manageCom != null) this.manageCom.equals("");
/*      */ 
/*  396 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setmanageCom(String amanageCom) {
/*  400 */     this.manageCom = amanageCom;
/*      */   }
/*      */ 
/*      */   public String getexecuteCom() {
/*  404 */     if (this.executeCom != null) this.executeCom.equals("");
/*      */ 
/*  408 */     return this.executeCom;
/*      */   }
/*      */ 
/*      */   public void setexecuteCom(String aexecuteCom) {
/*  412 */     this.executeCom = aexecuteCom;
/*      */   }
/*      */ 
/*      */   public String getagentCom() {
/*  416 */     if (this.agentCom != null) this.agentCom.equals("");
/*      */ 
/*  420 */     return this.agentCom;
/*      */   }
/*      */ 
/*      */   public void setagentCom(String aagentCom) {
/*  424 */     this.agentCom = aagentCom;
/*      */   }
/*      */ 
/*      */   public String getagentCode() {
/*  428 */     if (this.agentCode != null) this.agentCode.equals("");
/*      */ 
/*  432 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setagentCode(String aagentCode) {
/*  436 */     this.agentCode = aagentCode;
/*      */   }
/*      */ 
/*      */   public String getagentGroup() {
/*  440 */     if (this.agentGroup != null) this.agentGroup.equals("");
/*      */ 
/*  444 */     return this.agentGroup;
/*      */   }
/*      */ 
/*      */   public void setagentGroup(String aagentGroup) {
/*  448 */     this.agentGroup = aagentGroup;
/*      */   }
/*      */ 
/*      */   public String getagentCode1() {
/*  452 */     if (this.agentCode1 != null) this.agentCode1.equals("");
/*      */ 
/*  456 */     return this.agentCode1;
/*      */   }
/*      */ 
/*      */   public void setagentCode1(String aagentCode1) {
/*  460 */     this.agentCode1 = aagentCode1;
/*      */   }
/*      */ 
/*      */   public String getagentGroup1() {
/*  464 */     if (this.agentGroup1 != null) this.agentGroup1.equals("");
/*      */ 
/*  468 */     return this.agentGroup1;
/*      */   }
/*      */ 
/*      */   public void setagentGroup1(String aagentGroup1) {
/*  472 */     this.agentGroup1 = aagentGroup1;
/*      */   }
/*      */ 
/*      */   public String getagentType() {
/*  476 */     if (this.agentType != null) this.agentType.equals("");
/*      */ 
/*  480 */     return this.agentType;
/*      */   }
/*      */ 
/*      */   public void setagentType(String aagentType) {
/*  484 */     this.agentType = aagentType;
/*      */   }
/*      */ 
/*      */   public String getsaleChnl() {
/*  488 */     if (this.saleChnl != null) this.saleChnl.equals("");
/*      */ 
/*  492 */     return this.saleChnl;
/*      */   }
/*      */ 
/*      */   public void setsaleChnl(String asaleChnl) {
/*  496 */     this.saleChnl = asaleChnl;
/*      */   }
/*      */ 
/*      */   public String gethandler() {
/*  500 */     if (this.handler != null) this.handler.equals("");
/*      */ 
/*  504 */     return this.handler;
/*      */   }
/*      */ 
/*      */   public void sethandler(String ahandler) {
/*  508 */     this.handler = ahandler;
/*      */   }
/*      */ 
/*      */   public String getpassword() {
/*  512 */     if (this.password != null) this.password.equals("");
/*      */ 
/*  516 */     return this.password;
/*      */   }
/*      */ 
/*      */   public void setpassword(String apassword) {
/*  520 */     this.password = apassword;
/*      */   }
/*      */ 
/*      */   public String getappntNo() {
/*  524 */     if (this.appntNo != null) this.appntNo.equals("");
/*      */ 
/*  528 */     return this.appntNo;
/*      */   }
/*      */ 
/*      */   public void setappntNo(String aappntNo) {
/*  532 */     this.appntNo = aappntNo;
/*      */   }
/*      */ 
/*      */   public String getappntId() {
/*  536 */     if (this.appntId != null) this.appntId.equals("");
/*      */ 
/*  540 */     return this.appntId;
/*      */   }
/*      */ 
/*      */   public void setappntId(String aappntId) {
/*  544 */     this.appntId = aappntId;
/*      */   }
/*      */ 
/*      */   public String getappntName() {
/*  548 */     if (this.appntName != null) this.appntName.equals("");
/*      */ 
/*  552 */     return this.appntName;
/*      */   }
/*      */ 
/*      */   public void setappntName(String aappntName) {
/*  556 */     this.appntName = aappntName;
/*      */   }
/*      */ 
/*      */   public String getappntSex() {
/*  560 */     if (this.appntSex != null) this.appntSex.equals("");
/*      */ 
/*  564 */     return this.appntSex;
/*      */   }
/*      */ 
/*      */   public void setappntSex(String aappntSex) {
/*  568 */     this.appntSex = aappntSex;
/*      */   }
/*      */ 
/*      */   public String getappntBirthday() {
/*  572 */     if (this.appntBirthday != null) {
/*  573 */       return this.fDate.getString(this.appntBirthday);
/*      */     }
/*  575 */     return null;
/*      */   }
/*      */ 
/*      */   public void setappntBirthday(Date aappntBirthday) {
/*  579 */     this.appntBirthday = aappntBirthday;
/*      */   }
/*      */ 
/*      */   public void setappntBirthday(String aappntBirthday) {
/*  583 */     if ((aappntBirthday != null) && (!aappntBirthday.equals("")))
/*      */     {
/*  585 */       this.appntBirthday = this.fDate.getDate(aappntBirthday);
/*      */     }
/*      */     else
/*  588 */       this.appntBirthday = null;
/*      */   }
/*      */ 
/*      */   public String getappntIDType()
/*      */   {
/*  593 */     if (this.appntIDType != null) this.appntIDType.equals("");
/*      */ 
/*  597 */     return this.appntIDType;
/*      */   }
/*      */ 
/*      */   public void setappntIDType(String aappntIDType) {
/*  601 */     this.appntIDType = aappntIDType;
/*      */   }
/*      */ 
/*      */   public String getappntIDNo() {
/*  605 */     if (this.appntIDNo != null) this.appntIDNo.equals("");
/*      */ 
/*  609 */     return this.appntIDNo;
/*      */   }
/*      */ 
/*      */   public void setappntIDNo(String aappntIDNo) {
/*  613 */     this.appntIDNo = aappntIDNo;
/*      */   }
/*      */ 
/*      */   public String getinsuredNo() {
/*  617 */     if (this.insuredNo != null) this.insuredNo.equals("");
/*      */ 
/*  621 */     return this.insuredNo;
/*      */   }
/*      */ 
/*      */   public void setinsuredNo(String ainsuredNo) {
/*  625 */     this.insuredNo = ainsuredNo;
/*      */   }
/*      */ 
/*      */   public String getinsuredId() {
/*  629 */     if (this.insuredId != null) this.insuredId.equals("");
/*      */ 
/*  633 */     return this.insuredId;
/*      */   }
/*      */ 
/*      */   public void setinsuredId(String ainsuredId) {
/*  637 */     this.insuredId = ainsuredId;
/*      */   }
/*      */ 
/*      */   public String getinsuredName() {
/*  641 */     if (this.insuredName != null) this.insuredName.equals("");
/*      */ 
/*  645 */     return this.insuredName;
/*      */   }
/*      */ 
/*      */   public void setinsuredName(String ainsuredName) {
/*  649 */     this.insuredName = ainsuredName;
/*      */   }
/*      */ 
/*      */   public String getinsuredSex() {
/*  653 */     if (this.insuredSex != null) this.insuredSex.equals("");
/*      */ 
/*  657 */     return this.insuredSex;
/*      */   }
/*      */ 
/*      */   public void setinsuredSex(String ainsuredSex) {
/*  661 */     this.insuredSex = ainsuredSex;
/*      */   }
/*      */ 
/*      */   public String getinsuredBirthday() {
/*  665 */     if (this.insuredBirthday != null) {
/*  666 */       return this.fDate.getString(this.insuredBirthday);
/*      */     }
/*  668 */     return null;
/*      */   }
/*      */ 
/*      */   public void setinsuredBirthday(Date ainsuredBirthday) {
/*  672 */     this.insuredBirthday = ainsuredBirthday;
/*      */   }
/*      */ 
/*      */   public void setinsuredBirthday(String ainsuredBirthday) {
/*  676 */     if ((ainsuredBirthday != null) && (!ainsuredBirthday.equals("")))
/*      */     {
/*  678 */       this.insuredBirthday = this.fDate.getDate(ainsuredBirthday);
/*      */     }
/*      */     else
/*  681 */       this.insuredBirthday = null;
/*      */   }
/*      */ 
/*      */   public String getinsuredIDType()
/*      */   {
/*  686 */     if (this.insuredIDType != null) this.insuredIDType.equals("");
/*      */ 
/*  690 */     return this.insuredIDType;
/*      */   }
/*      */ 
/*      */   public void setinsuredIDType(String ainsuredIDType) {
/*  694 */     this.insuredIDType = ainsuredIDType;
/*      */   }
/*      */ 
/*      */   public String getinsuredIDNo() {
/*  698 */     if (this.insuredIDNo != null) this.insuredIDNo.equals("");
/*      */ 
/*  702 */     return this.insuredIDNo;
/*      */   }
/*      */ 
/*      */   public void setinsuredIDNo(String ainsuredIDNo) {
/*  706 */     this.insuredIDNo = ainsuredIDNo;
/*      */   }
/*      */ 
/*      */   public int getpayIntv() {
/*  710 */     return this.payIntv;
/*      */   }
/*      */ 
/*      */   public void setpayIntv(int apayIntv) {
/*  714 */     this.payIntv = apayIntv;
/*      */   }
/*      */ 
/*      */   public void setpayIntv(String apayIntv) {
/*  718 */     if ((apayIntv != null) && (!apayIntv.equals("")))
/*      */     {
/*  720 */       Integer tInteger = new Integer(apayIntv);
/*  721 */       int i = tInteger.intValue();
/*  722 */       this.payIntv = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getpayMode()
/*      */   {
/*  728 */     if (this.payMode != null) this.payMode.equals("");
/*      */ 
/*  732 */     return this.payMode;
/*      */   }
/*      */ 
/*      */   public void setpayMode(String apayMode) {
/*  736 */     this.payMode = apayMode;
/*      */   }
/*      */ 
/*      */   public String getpayLocation() {
/*  740 */     if (this.payLocation != null) this.payLocation.equals("");
/*      */ 
/*  744 */     return this.payLocation;
/*      */   }
/*      */ 
/*      */   public void setpayLocation(String apayLocation) {
/*  748 */     this.payLocation = apayLocation;
/*      */   }
/*      */ 
/*      */   public String getdisputedFlag() {
/*  752 */     if (this.disputedFlag != null) this.disputedFlag.equals("");
/*      */ 
/*  756 */     return this.disputedFlag;
/*      */   }
/*      */ 
/*      */   public void setdisputedFlag(String adisputedFlag) {
/*  760 */     this.disputedFlag = adisputedFlag;
/*      */   }
/*      */ 
/*      */   public String getoutPayFlag() {
/*  764 */     if (this.outPayFlag != null) this.outPayFlag.equals("");
/*      */ 
/*  768 */     return this.outPayFlag;
/*      */   }
/*      */ 
/*      */   public void setoutPayFlag(String aoutPayFlag) {
/*  772 */     this.outPayFlag = aoutPayFlag;
/*      */   }
/*      */ 
/*      */   public String getgetPolMode() {
/*  776 */     if (this.getPolMode != null) this.getPolMode.equals("");
/*      */ 
/*  780 */     return this.getPolMode;
/*      */   }
/*      */ 
/*      */   public void setgetPolMode(String agetPolMode) {
/*  784 */     this.getPolMode = agetPolMode;
/*      */   }
/*      */ 
/*      */   public String getsignCom() {
/*  788 */     if (this.signCom != null) this.signCom.equals("");
/*      */ 
/*  792 */     return this.signCom;
/*      */   }
/*      */ 
/*      */   public void setsignCom(String asignCom) {
/*  796 */     this.signCom = asignCom;
/*      */   }
/*      */ 
/*      */   public String getsignDate() {
/*  800 */     if (this.signDate != null) {
/*  801 */       return this.fDate.getString(this.signDate);
/*      */     }
/*  803 */     return null;
/*      */   }
/*      */ 
/*      */   public void setsignDate(Date asignDate) {
/*  807 */     this.signDate = asignDate;
/*      */   }
/*      */ 
/*      */   public void setsignDate(String asignDate) {
/*  811 */     if ((asignDate != null) && (!asignDate.equals("")))
/*      */     {
/*  813 */       this.signDate = this.fDate.getDate(asignDate);
/*      */     }
/*      */     else
/*  816 */       this.signDate = null;
/*      */   }
/*      */ 
/*      */   public String getsignTime()
/*      */   {
/*  821 */     if (this.signTime != null) this.signTime.equals("");
/*      */ 
/*  825 */     return this.signTime;
/*      */   }
/*      */ 
/*      */   public void setsignTime(String asignTime) {
/*  829 */     this.signTime = asignTime;
/*      */   }
/*      */ 
/*      */   public String getconsignNo() {
/*  833 */     if (this.consignNo != null) this.consignNo.equals("");
/*      */ 
/*  837 */     return this.consignNo;
/*      */   }
/*      */ 
/*      */   public void setconsignNo(String aconsignNo) {
/*  841 */     this.consignNo = aconsignNo;
/*      */   }
/*      */ 
/*      */   public String getbankCode() {
/*  845 */     if (this.bankCode != null) this.bankCode.equals("");
/*      */ 
/*  849 */     return this.bankCode;
/*      */   }
/*      */ 
/*      */   public void setbankCode(String abankCode) {
/*  853 */     this.bankCode = abankCode;
/*      */   }
/*      */ 
/*      */   public String getbankAccNo() {
/*  857 */     if (this.bankAccNo != null) this.bankAccNo.equals("");
/*      */ 
/*  861 */     return this.bankAccNo;
/*      */   }
/*      */ 
/*      */   public void setbankAccNo(String abankAccNo) {
/*  865 */     this.bankAccNo = abankAccNo;
/*      */   }
/*      */ 
/*      */   public String getaccName() {
/*  869 */     if (this.accName != null) this.accName.equals("");
/*      */ 
/*  873 */     return this.accName;
/*      */   }
/*      */ 
/*      */   public void setaccName(String aaccName) {
/*  877 */     this.accName = aaccName;
/*      */   }
/*      */ 
/*      */   public int getprintCount() {
/*  881 */     return this.printCount;
/*      */   }
/*      */ 
/*      */   public void setprintCount(int aprintCount) {
/*  885 */     this.printCount = aprintCount;
/*      */   }
/*      */ 
/*      */   public void setprintCount(String aprintCount) {
/*  889 */     if ((aprintCount != null) && (!aprintCount.equals("")))
/*      */     {
/*  891 */       Integer tInteger = new Integer(aprintCount);
/*  892 */       int i = tInteger.intValue();
/*  893 */       this.printCount = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getlostTimes()
/*      */   {
/*  899 */     return this.lostTimes;
/*      */   }
/*      */ 
/*      */   public void setlostTimes(int alostTimes) {
/*  903 */     this.lostTimes = alostTimes;
/*      */   }
/*      */ 
/*      */   public void setlostTimes(String alostTimes) {
/*  907 */     if ((alostTimes != null) && (!alostTimes.equals("")))
/*      */     {
/*  909 */       Integer tInteger = new Integer(alostTimes);
/*  910 */       int i = tInteger.intValue();
/*  911 */       this.lostTimes = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getlang()
/*      */   {
/*  917 */     if (this.lang != null) this.lang.equals("");
/*      */ 
/*  921 */     return this.lang;
/*      */   }
/*      */ 
/*      */   public void setlang(String alang) {
/*  925 */     this.lang = alang;
/*      */   }
/*      */ 
/*      */   public String getcurrency() {
/*  929 */     if (this.currency != null) this.currency.equals("");
/*      */ 
/*  933 */     return this.currency;
/*      */   }
/*      */ 
/*      */   public void setcurrency(String acurrency) {
/*  937 */     this.currency = acurrency;
/*      */   }
/*      */ 
/*      */   public String getremark() {
/*  941 */     if (this.remark != null) this.remark.equals("");
/*      */ 
/*  945 */     return this.remark;
/*      */   }
/*      */ 
/*      */   public void setremark(String aremark) {
/*  949 */     this.remark = aremark;
/*      */   }
/*      */ 
/*      */   public int getpeoples() {
/*  953 */     return this.peoples;
/*      */   }
/*      */ 
/*      */   public void setpeoples(int apeoples) {
/*  957 */     this.peoples = apeoples;
/*      */   }
/*      */ 
/*      */   public void setpeoples(String apeoples) {
/*  961 */     if ((apeoples != null) && (!apeoples.equals("")))
/*      */     {
/*  963 */       Integer tInteger = new Integer(apeoples);
/*  964 */       int i = tInteger.intValue();
/*  965 */       this.peoples = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getmult()
/*      */   {
/*  971 */     return this.mult;
/*      */   }
/*      */ 
/*      */   public void setmult(double amult) {
/*  975 */     this.mult = amult;
/*      */   }
/*      */ 
/*      */   public void setmult(String amult) {
/*  979 */     if ((amult != null) && (!amult.equals("")))
/*      */     {
/*  981 */       Double tDouble = new Double(amult);
/*  982 */       double d = tDouble.doubleValue();
/*  983 */       this.mult = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getprem()
/*      */   {
/*  989 */     return this.prem;
/*      */   }
/*      */ 
/*      */   public void setprem(double aprem) {
/*  993 */     this.prem = aprem;
/*      */   }
/*      */ 
/*      */   public void setprem(String aprem) {
/*  997 */     if ((aprem != null) && (!aprem.equals("")))
/*      */     {
/*  999 */       Double tDouble = new Double(aprem);
/* 1000 */       double d = tDouble.doubleValue();
/* 1001 */       this.prem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getamnt()
/*      */   {
/* 1007 */     return this.amnt;
/*      */   }
/*      */ 
/*      */   public void setamnt(double aamnt) {
/* 1011 */     this.amnt = aamnt;
/*      */   }
/*      */ 
/*      */   public void setamnt(String aamnt) {
/* 1015 */     if ((aamnt != null) && (!aamnt.equals("")))
/*      */     {
/* 1017 */       Double tDouble = new Double(aamnt);
/* 1018 */       double d = tDouble.doubleValue();
/* 1019 */       this.amnt = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getsumPrem()
/*      */   {
/* 1025 */     return this.sumPrem;
/*      */   }
/*      */ 
/*      */   public void setsumPrem(double asumPrem) {
/* 1029 */     this.sumPrem = asumPrem;
/*      */   }
/*      */ 
/*      */   public void setsumPrem(String asumPrem) {
/* 1033 */     if ((asumPrem != null) && (!asumPrem.equals("")))
/*      */     {
/* 1035 */       Double tDouble = new Double(asumPrem);
/* 1036 */       double d = tDouble.doubleValue();
/* 1037 */       this.sumPrem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getdif()
/*      */   {
/* 1043 */     return this.dif;
/*      */   }
/*      */ 
/*      */   public void setdif(double adif) {
/* 1047 */     this.dif = adif;
/*      */   }
/*      */ 
/*      */   public void setdif(String adif) {
/* 1051 */     if ((adif != null) && (!adif.equals("")))
/*      */     {
/* 1053 */       Double tDouble = new Double(adif);
/* 1054 */       double d = tDouble.doubleValue();
/* 1055 */       this.dif = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getpaytoDate()
/*      */   {
/* 1061 */     if (this.paytoDate != null) {
/* 1062 */       return this.fDate.getString(this.paytoDate);
/*      */     }
/* 1064 */     return null;
/*      */   }
/*      */ 
/*      */   public void setpaytoDate(Date apaytoDate) {
/* 1068 */     this.paytoDate = apaytoDate;
/*      */   }
/*      */ 
/*      */   public void setpaytoDate(String apaytoDate) {
/* 1072 */     if ((apaytoDate != null) && (!apaytoDate.equals("")))
/*      */     {
/* 1074 */       this.paytoDate = this.fDate.getDate(apaytoDate);
/*      */     }
/*      */     else
/* 1077 */       this.paytoDate = null;
/*      */   }
/*      */ 
/*      */   public String getfirstPayDate()
/*      */   {
/* 1082 */     if (this.firstPayDate != null) {
/* 1083 */       return this.fDate.getString(this.firstPayDate);
/*      */     }
/* 1085 */     return null;
/*      */   }
/*      */ 
/*      */   public void setfirstPayDate(Date afirstPayDate) {
/* 1089 */     this.firstPayDate = afirstPayDate;
/*      */   }
/*      */ 
/*      */   public void setfirstPayDate(String afirstPayDate) {
/* 1093 */     if ((afirstPayDate != null) && (!afirstPayDate.equals("")))
/*      */     {
/* 1095 */       this.firstPayDate = this.fDate.getDate(afirstPayDate);
/*      */     }
/*      */     else
/* 1098 */       this.firstPayDate = null;
/*      */   }
/*      */ 
/*      */   public String getcValiDate()
/*      */   {
/* 1103 */     if (this.cValiDate != null) {
/* 1104 */       return this.fDate.getString(this.cValiDate);
/*      */     }
/* 1106 */     return null;
/*      */   }
/*      */ 
/*      */   public void setcValiDate(Date acValiDate) {
/* 1110 */     this.cValiDate = acValiDate;
/*      */   }
/*      */ 
/*      */   public void setcValiDate(String acValiDate) {
/* 1114 */     if ((acValiDate != null) && (!acValiDate.equals("")))
/*      */     {
/* 1116 */       this.cValiDate = this.fDate.getDate(acValiDate);
/*      */     }
/*      */     else
/* 1119 */       this.cValiDate = null;
/*      */   }
/*      */ 
/*      */   public String getpSignDate()
/*      */   {
/* 1124 */     if (this.pSignDate != null) {
/* 1125 */       return this.fDate.getString(this.pSignDate);
/*      */     }
/* 1127 */     return null;
/*      */   }
/*      */ 
/*      */   public void setpSignDate(Date apSignDate) {
/* 1131 */     this.pSignDate = apSignDate;
/*      */   }
/*      */ 
/*      */   public void setpSignDate(String apSignDate) {
/* 1135 */     if ((apSignDate != null) && (!apSignDate.equals("")))
/*      */     {
/* 1137 */       this.pSignDate = this.fDate.getDate(apSignDate);
/*      */     }
/*      */     else
/* 1140 */       this.pSignDate = null;
/*      */   }
/*      */ 
/*      */   public String getpValiDate()
/*      */   {
/* 1145 */     if (this.pValiDate != null) {
/* 1146 */       return this.fDate.getString(this.pValiDate);
/*      */     }
/* 1148 */     return null;
/*      */   }
/*      */ 
/*      */   public void setpValiDate(Date apValiDate) {
/* 1152 */     this.pValiDate = apValiDate;
/*      */   }
/*      */ 
/*      */   public void setpValiDate(String apValiDate) {
/* 1156 */     if ((apValiDate != null) && (!apValiDate.equals("")))
/*      */     {
/* 1158 */       this.pValiDate = this.fDate.getDate(apValiDate);
/*      */     }
/*      */     else
/* 1161 */       this.pValiDate = null;
/*      */   }
/*      */ 
/*      */   public String getinputOperator()
/*      */   {
/* 1166 */     if (this.inputOperator != null) this.inputOperator.equals("");
/*      */ 
/* 1170 */     return this.inputOperator;
/*      */   }
/*      */ 
/*      */   public void setinputOperator(String ainputOperator) {
/* 1174 */     this.inputOperator = ainputOperator;
/*      */   }
/*      */ 
/*      */   public String getinputDate() {
/* 1178 */     if (this.inputDate != null) {
/* 1179 */       return this.fDate.getString(this.inputDate);
/*      */     }
/* 1181 */     return null;
/*      */   }
/*      */ 
/*      */   public void setinputDate(Date ainputDate) {
/* 1185 */     this.inputDate = ainputDate;
/*      */   }
/*      */ 
/*      */   public void setinputDate(String ainputDate) {
/* 1189 */     if ((ainputDate != null) && (!ainputDate.equals("")))
/*      */     {
/* 1191 */       this.inputDate = this.fDate.getDate(ainputDate);
/*      */     }
/*      */     else
/* 1194 */       this.inputDate = null;
/*      */   }
/*      */ 
/*      */   public String getinputTime()
/*      */   {
/* 1199 */     if (this.inputTime != null) this.inputTime.equals("");
/*      */ 
/* 1203 */     return this.inputTime;
/*      */   }
/*      */ 
/*      */   public void setinputTime(String ainputTime) {
/* 1207 */     this.inputTime = ainputTime;
/*      */   }
/*      */ 
/*      */   public String getapproveFlag() {
/* 1211 */     if (this.approveFlag != null) this.approveFlag.equals("");
/*      */ 
/* 1215 */     return this.approveFlag;
/*      */   }
/*      */ 
/*      */   public void setapproveFlag(String aapproveFlag) {
/* 1219 */     this.approveFlag = aapproveFlag;
/*      */   }
/*      */ 
/*      */   public String getapproveCode() {
/* 1223 */     if (this.approveCode != null) this.approveCode.equals("");
/*      */ 
/* 1227 */     return this.approveCode;
/*      */   }
/*      */ 
/*      */   public void setapproveCode(String aapproveCode) {
/* 1231 */     this.approveCode = aapproveCode;
/*      */   }
/*      */ 
/*      */   public String getapproveDate() {
/* 1235 */     if (this.approveDate != null) {
/* 1236 */       return this.fDate.getString(this.approveDate);
/*      */     }
/* 1238 */     return null;
/*      */   }
/*      */ 
/*      */   public void setapproveDate(Date aapproveDate) {
/* 1242 */     this.approveDate = aapproveDate;
/*      */   }
/*      */ 
/*      */   public void setapproveDate(String aapproveDate) {
/* 1246 */     if ((aapproveDate != null) && (!aapproveDate.equals("")))
/*      */     {
/* 1248 */       this.approveDate = this.fDate.getDate(aapproveDate);
/*      */     }
/*      */     else
/* 1251 */       this.approveDate = null;
/*      */   }
/*      */ 
/*      */   public String getapproveTime()
/*      */   {
/* 1256 */     if (this.approveTime != null) this.approveTime.equals("");
/*      */ 
/* 1260 */     return this.approveTime;
/*      */   }
/*      */ 
/*      */   public void setapproveTime(String aapproveTime) {
/* 1264 */     this.approveTime = aapproveTime;
/*      */   }
/*      */ 
/*      */   public String getuWFlag() {
/* 1268 */     if (this.uWFlag != null) this.uWFlag.equals("");
/*      */ 
/* 1272 */     return this.uWFlag;
/*      */   }
/*      */ 
/*      */   public void setuWFlag(String auWFlag) {
/* 1276 */     this.uWFlag = auWFlag;
/*      */   }
/*      */ 
/*      */   public String getuWOperator() {
/* 1280 */     if (this.uWOperator != null) this.uWOperator.equals("");
/*      */ 
/* 1284 */     return this.uWOperator;
/*      */   }
/*      */ 
/*      */   public void setuWOperator(String auWOperator) {
/* 1288 */     this.uWOperator = auWOperator;
/*      */   }
/*      */ 
/*      */   public String getuWDate() {
/* 1292 */     if (this.uWDate != null) {
/* 1293 */       return this.fDate.getString(this.uWDate);
/*      */     }
/* 1295 */     return null;
/*      */   }
/*      */ 
/*      */   public void setuWDate(Date auWDate) {
/* 1299 */     this.uWDate = auWDate;
/*      */   }
/*      */ 
/*      */   public void setuWDate(String auWDate) {
/* 1303 */     if ((auWDate != null) && (!auWDate.equals("")))
/*      */     {
/* 1305 */       this.uWDate = this.fDate.getDate(auWDate);
/*      */     }
/*      */     else
/* 1308 */       this.uWDate = null;
/*      */   }
/*      */ 
/*      */   public String getuWTime()
/*      */   {
/* 1313 */     if (this.uWTime != null) this.uWTime.equals("");
/*      */ 
/* 1317 */     return this.uWTime;
/*      */   }
/*      */ 
/*      */   public void setuWTime(String auWTime) {
/* 1321 */     this.uWTime = auWTime;
/*      */   }
/*      */ 
/*      */   public String getappFlag() {
/* 1325 */     if (this.appFlag != null) this.appFlag.equals("");
/*      */ 
/* 1329 */     return this.appFlag;
/*      */   }
/*      */ 
/*      */   public void setappFlag(String aappFlag) {
/* 1333 */     this.appFlag = aappFlag;
/*      */   }
/*      */ 
/*      */   public String getpolApplyDate() {
/* 1337 */     if (this.polApplyDate != null) {
/* 1338 */       return this.fDate.getString(this.polApplyDate);
/*      */     }
/* 1340 */     return null;
/*      */   }
/*      */ 
/*      */   public void setpolApplyDate(Date apolApplyDate) {
/* 1344 */     this.polApplyDate = apolApplyDate;
/*      */   }
/*      */ 
/*      */   public void setpolApplyDate(String apolApplyDate) {
/* 1348 */     if ((apolApplyDate != null) && (!apolApplyDate.equals("")))
/*      */     {
/* 1350 */       this.polApplyDate = this.fDate.getDate(apolApplyDate);
/*      */     }
/*      */     else
/* 1353 */       this.polApplyDate = null;
/*      */   }
/*      */ 
/*      */   public String getgetPolDate()
/*      */   {
/* 1358 */     if (this.getPolDate != null) {
/* 1359 */       return this.fDate.getString(this.getPolDate);
/*      */     }
/* 1361 */     return null;
/*      */   }
/*      */ 
/*      */   public void setgetPolDate(Date agetPolDate) {
/* 1365 */     this.getPolDate = agetPolDate;
/*      */   }
/*      */ 
/*      */   public void setgetPolDate(String agetPolDate) {
/* 1369 */     if ((agetPolDate != null) && (!agetPolDate.equals("")))
/*      */     {
/* 1371 */       this.getPolDate = this.fDate.getDate(agetPolDate);
/*      */     }
/*      */     else
/* 1374 */       this.getPolDate = null;
/*      */   }
/*      */ 
/*      */   public String getgetPolTime()
/*      */   {
/* 1379 */     if (this.getPolTime != null) this.getPolTime.equals("");
/*      */ 
/* 1383 */     return this.getPolTime;
/*      */   }
/*      */ 
/*      */   public void setgetPolTime(String agetPolTime) {
/* 1387 */     this.getPolTime = agetPolTime;
/*      */   }
/*      */ 
/*      */   public String getcustomGetPolDate() {
/* 1391 */     if (this.customGetPolDate != null) {
/* 1392 */       return this.fDate.getString(this.customGetPolDate);
/*      */     }
/* 1394 */     return null;
/*      */   }
/*      */ 
/*      */   public void setcustomGetPolDate(Date acustomGetPolDate) {
/* 1398 */     this.customGetPolDate = acustomGetPolDate;
/*      */   }
/*      */ 
/*      */   public void setcustomGetPolDate(String acustomGetPolDate) {
/* 1402 */     if ((acustomGetPolDate != null) && (!acustomGetPolDate.equals("")))
/*      */     {
/* 1404 */       this.customGetPolDate = this.fDate.getDate(acustomGetPolDate);
/*      */     }
/*      */     else
/* 1407 */       this.customGetPolDate = null;
/*      */   }
/*      */ 
/*      */   public String getstate()
/*      */   {
/* 1412 */     if (this.state != null) this.state.equals("");
/*      */ 
/* 1416 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setstate(String astate) {
/* 1420 */     this.state = astate;
/*      */   }
/*      */ 
/*      */   public String getsaleChnlDetail() {
/* 1424 */     if (this.saleChnlDetail != null) this.saleChnlDetail.equals("");
/*      */ 
/* 1428 */     return this.saleChnlDetail;
/*      */   }
/*      */ 
/*      */   public void setsaleChnlDetail(String asaleChnlDetail) {
/* 1432 */     this.saleChnlDetail = asaleChnlDetail;
/*      */   }
/*      */ 
/*      */   public String getproposalType() {
/* 1436 */     if (this.proposalType != null) this.proposalType.equals("");
/*      */ 
/* 1440 */     return this.proposalType;
/*      */   }
/*      */ 
/*      */   public void setproposalType(String aproposalType) {
/* 1444 */     this.proposalType = aproposalType;
/*      */   }
/*      */ 
/*      */   public String geteditstate() {
/* 1448 */     if (this.editstate != null) this.editstate.equals("");
/*      */ 
/* 1452 */     return this.editstate;
/*      */   }
/*      */ 
/*      */   public void seteditstate(String aeditstate) {
/* 1456 */     this.editstate = aeditstate;
/*      */   }
/*      */ 
/*      */   public String getcInValiDate() {
/* 1460 */     if (this.cInValiDate != null) {
/* 1461 */       return this.fDate.getString(this.cInValiDate);
/*      */     }
/* 1463 */     return null;
/*      */   }
/*      */ 
/*      */   public void setcInValiDate(Date acInValiDate) {
/* 1467 */     this.cInValiDate = acInValiDate;
/*      */   }
/*      */ 
/*      */   public void setcInValiDate(String acInValiDate) {
/* 1471 */     if ((acInValiDate != null) && (!acInValiDate.equals("")))
/*      */     {
/* 1473 */       this.cInValiDate = this.fDate.getDate(acInValiDate);
/*      */     }
/*      */     else
/* 1476 */       this.cInValiDate = null;
/*      */   }
/*      */ 
/*      */   public String getoperator()
/*      */   {
/* 1481 */     if (this.operator != null) this.operator.equals("");
/*      */ 
/* 1485 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setoperator(String aoperator) {
/* 1489 */     this.operator = aoperator;
/*      */   }
/*      */ 
/*      */   public String getmakeDate() {
/* 1493 */     if (this.makeDate != null) {
/* 1494 */       return this.fDate.getString(this.makeDate);
/*      */     }
/* 1496 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(Date amakeDate) {
/* 1500 */     this.makeDate = amakeDate;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(String amakeDate) {
/* 1504 */     if ((amakeDate != null) && (!amakeDate.equals("")))
/*      */     {
/* 1506 */       this.makeDate = this.fDate.getDate(amakeDate);
/*      */     }
/*      */     else
/* 1509 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getmakeTime()
/*      */   {
/* 1514 */     if (this.makeTime != null) this.makeTime.equals("");
/*      */ 
/* 1518 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setmakeTime(String amakeTime) {
/* 1522 */     this.makeTime = amakeTime;
/*      */   }
/*      */ 
/*      */   public String getmodifyDate() {
/* 1526 */     if (this.modifyDate != null) {
/* 1527 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/* 1529 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(Date amodifyDate) {
/* 1533 */     this.modifyDate = amodifyDate;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(String amodifyDate) {
/* 1537 */     if ((amodifyDate != null) && (!amodifyDate.equals("")))
/*      */     {
/* 1539 */       this.modifyDate = this.fDate.getDate(amodifyDate);
/*      */     }
/*      */     else
/* 1542 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getmodifyTime()
/*      */   {
/* 1547 */     if (this.modifyTime != null) this.modifyTime.equals("");
/*      */ 
/* 1551 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setmodifyTime(String amodifyTime) {
/* 1555 */     this.modifyTime = amodifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPContBSchema aLNPContBSchema)
/*      */   {
/* 1561 */     this.EdorNo = aLNPContBSchema.getEdorNo();
/* 1562 */     this.serialNo = aLNPContBSchema.getserialNo();
/* 1563 */     this.grpContNo = aLNPContBSchema.getgrpContNo();
/* 1564 */     this.contNo = aLNPContBSchema.getcontNo();
/* 1565 */     this.proposalContNo = aLNPContBSchema.getproposalContNo();
/* 1566 */     this.prtNo = aLNPContBSchema.getprtNo();
/* 1567 */     this.mainPolNo = aLNPContBSchema.getmainPolNo();
/* 1568 */     this.contType = aLNPContBSchema.getcontType();
/* 1569 */     this.familyType = aLNPContBSchema.getfamilyType();
/* 1570 */     this.familyID = aLNPContBSchema.getfamilyID();
/* 1571 */     this.polType = aLNPContBSchema.getpolType();
/* 1572 */     this.sugNo = aLNPContBSchema.getsugNo();
/* 1573 */     this.cardFlag = aLNPContBSchema.getcardFlag();
/* 1574 */     this.manageCom = aLNPContBSchema.getmanageCom();
/* 1575 */     this.executeCom = aLNPContBSchema.getexecuteCom();
/* 1576 */     this.agentCom = aLNPContBSchema.getagentCom();
/* 1577 */     this.agentCode = aLNPContBSchema.getagentCode();
/* 1578 */     this.agentGroup = aLNPContBSchema.getagentGroup();
/* 1579 */     this.agentCode1 = aLNPContBSchema.getagentCode1();
/* 1580 */     this.agentGroup1 = aLNPContBSchema.getagentGroup1();
/* 1581 */     this.agentType = aLNPContBSchema.getagentType();
/* 1582 */     this.saleChnl = aLNPContBSchema.getsaleChnl();
/* 1583 */     this.handler = aLNPContBSchema.gethandler();
/* 1584 */     this.password = aLNPContBSchema.getpassword();
/* 1585 */     this.appntNo = aLNPContBSchema.getappntNo();
/* 1586 */     this.appntId = aLNPContBSchema.getappntId();
/* 1587 */     this.appntName = aLNPContBSchema.getappntName();
/* 1588 */     this.appntSex = aLNPContBSchema.getappntSex();
/* 1589 */     this.appntBirthday = this.fDate.getDate(aLNPContBSchema.getappntBirthday());
/* 1590 */     this.appntIDType = aLNPContBSchema.getappntIDType();
/* 1591 */     this.appntIDNo = aLNPContBSchema.getappntIDNo();
/* 1592 */     this.insuredNo = aLNPContBSchema.getinsuredNo();
/* 1593 */     this.insuredId = aLNPContBSchema.getinsuredId();
/* 1594 */     this.insuredName = aLNPContBSchema.getinsuredName();
/* 1595 */     this.insuredSex = aLNPContBSchema.getinsuredSex();
/* 1596 */     this.insuredBirthday = this.fDate.getDate(aLNPContBSchema.getinsuredBirthday());
/* 1597 */     this.insuredIDType = aLNPContBSchema.getinsuredIDType();
/* 1598 */     this.insuredIDNo = aLNPContBSchema.getinsuredIDNo();
/* 1599 */     this.payIntv = aLNPContBSchema.getpayIntv();
/* 1600 */     this.payMode = aLNPContBSchema.getpayMode();
/* 1601 */     this.payLocation = aLNPContBSchema.getpayLocation();
/* 1602 */     this.disputedFlag = aLNPContBSchema.getdisputedFlag();
/* 1603 */     this.outPayFlag = aLNPContBSchema.getoutPayFlag();
/* 1604 */     this.getPolMode = aLNPContBSchema.getgetPolMode();
/* 1605 */     this.signCom = aLNPContBSchema.getsignCom();
/* 1606 */     this.signDate = this.fDate.getDate(aLNPContBSchema.getsignDate());
/* 1607 */     this.signTime = aLNPContBSchema.getsignTime();
/* 1608 */     this.consignNo = aLNPContBSchema.getconsignNo();
/* 1609 */     this.bankCode = aLNPContBSchema.getbankCode();
/* 1610 */     this.bankAccNo = aLNPContBSchema.getbankAccNo();
/* 1611 */     this.accName = aLNPContBSchema.getaccName();
/* 1612 */     this.printCount = aLNPContBSchema.getprintCount();
/* 1613 */     this.lostTimes = aLNPContBSchema.getlostTimes();
/* 1614 */     this.lang = aLNPContBSchema.getlang();
/* 1615 */     this.currency = aLNPContBSchema.getcurrency();
/* 1616 */     this.remark = aLNPContBSchema.getremark();
/* 1617 */     this.peoples = aLNPContBSchema.getpeoples();
/* 1618 */     this.mult = aLNPContBSchema.getmult();
/* 1619 */     this.prem = aLNPContBSchema.getprem();
/* 1620 */     this.amnt = aLNPContBSchema.getamnt();
/* 1621 */     this.sumPrem = aLNPContBSchema.getsumPrem();
/* 1622 */     this.dif = aLNPContBSchema.getdif();
/* 1623 */     this.paytoDate = this.fDate.getDate(aLNPContBSchema.getpaytoDate());
/* 1624 */     this.firstPayDate = this.fDate.getDate(aLNPContBSchema.getfirstPayDate());
/* 1625 */     this.cValiDate = this.fDate.getDate(aLNPContBSchema.getcValiDate());
/* 1626 */     this.pSignDate = this.fDate.getDate(aLNPContBSchema.getpSignDate());
/* 1627 */     this.pValiDate = this.fDate.getDate(aLNPContBSchema.getpValiDate());
/* 1628 */     this.inputOperator = aLNPContBSchema.getinputOperator();
/* 1629 */     this.inputDate = this.fDate.getDate(aLNPContBSchema.getinputDate());
/* 1630 */     this.inputTime = aLNPContBSchema.getinputTime();
/* 1631 */     this.approveFlag = aLNPContBSchema.getapproveFlag();
/* 1632 */     this.approveCode = aLNPContBSchema.getapproveCode();
/* 1633 */     this.approveDate = this.fDate.getDate(aLNPContBSchema.getapproveDate());
/* 1634 */     this.approveTime = aLNPContBSchema.getapproveTime();
/* 1635 */     this.uWFlag = aLNPContBSchema.getuWFlag();
/* 1636 */     this.uWOperator = aLNPContBSchema.getuWOperator();
/* 1637 */     this.uWDate = this.fDate.getDate(aLNPContBSchema.getuWDate());
/* 1638 */     this.uWTime = aLNPContBSchema.getuWTime();
/* 1639 */     this.appFlag = aLNPContBSchema.getappFlag();
/* 1640 */     this.polApplyDate = this.fDate.getDate(aLNPContBSchema.getpolApplyDate());
/* 1641 */     this.getPolDate = this.fDate.getDate(aLNPContBSchema.getgetPolDate());
/* 1642 */     this.getPolTime = aLNPContBSchema.getgetPolTime();
/* 1643 */     this.customGetPolDate = this.fDate.getDate(aLNPContBSchema.getcustomGetPolDate());
/* 1644 */     this.state = aLNPContBSchema.getstate();
/* 1645 */     this.saleChnlDetail = aLNPContBSchema.getsaleChnlDetail();
/* 1646 */     this.proposalType = aLNPContBSchema.getproposalType();
/* 1647 */     this.editstate = aLNPContBSchema.geteditstate();
/* 1648 */     this.cInValiDate = this.fDate.getDate(aLNPContBSchema.getcInValiDate());
/* 1649 */     this.operator = aLNPContBSchema.getoperator();
/* 1650 */     this.makeDate = this.fDate.getDate(aLNPContBSchema.getmakeDate());
/* 1651 */     this.makeTime = aLNPContBSchema.getmakeTime();
/* 1652 */     this.modifyDate = this.fDate.getDate(aLNPContBSchema.getmodifyDate());
/* 1653 */     this.modifyTime = aLNPContBSchema.getmodifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/* 1662 */       if (rs.getString("EdorNo") == null)
/* 1663 */         this.EdorNo = null;
/*      */       else {
/* 1665 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/* 1667 */       if (rs.getString("serialNo") == null)
/* 1668 */         this.serialNo = null;
/*      */       else {
/* 1670 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/* 1672 */       if (rs.getString("grpContNo") == null)
/* 1673 */         this.grpContNo = null;
/*      */       else {
/* 1675 */         this.grpContNo = rs.getString("grpContNo").trim();
/*      */       }
/* 1677 */       if (rs.getString("contNo") == null)
/* 1678 */         this.contNo = null;
/*      */       else {
/* 1680 */         this.contNo = rs.getString("contNo").trim();
/*      */       }
/* 1682 */       if (rs.getString("proposalContNo") == null)
/* 1683 */         this.proposalContNo = null;
/*      */       else {
/* 1685 */         this.proposalContNo = rs.getString("proposalContNo").trim();
/*      */       }
/* 1687 */       if (rs.getString("prtNo") == null)
/* 1688 */         this.prtNo = null;
/*      */       else {
/* 1690 */         this.prtNo = rs.getString("prtNo").trim();
/*      */       }
/* 1692 */       if (rs.getString("mainPolNo") == null)
/* 1693 */         this.mainPolNo = null;
/*      */       else {
/* 1695 */         this.mainPolNo = rs.getString("mainPolNo").trim();
/*      */       }
/* 1697 */       if (rs.getString("contType") == null)
/* 1698 */         this.contType = null;
/*      */       else {
/* 1700 */         this.contType = rs.getString("contType").trim();
/*      */       }
/* 1702 */       if (rs.getString("familyType") == null)
/* 1703 */         this.familyType = null;
/*      */       else {
/* 1705 */         this.familyType = rs.getString("familyType").trim();
/*      */       }
/* 1707 */       if (rs.getString("familyID") == null)
/* 1708 */         this.familyID = null;
/*      */       else {
/* 1710 */         this.familyID = rs.getString("familyID").trim();
/*      */       }
/* 1712 */       if (rs.getString("polType") == null)
/* 1713 */         this.polType = null;
/*      */       else {
/* 1715 */         this.polType = rs.getString("polType").trim();
/*      */       }
/* 1717 */       if (rs.getString("sugNo") == null)
/* 1718 */         this.sugNo = null;
/*      */       else {
/* 1720 */         this.sugNo = rs.getString("sugNo").trim();
/*      */       }
/* 1722 */       if (rs.getString("cardFlag") == null)
/* 1723 */         this.cardFlag = null;
/*      */       else {
/* 1725 */         this.cardFlag = rs.getString("cardFlag").trim();
/*      */       }
/* 1727 */       if (rs.getString("manageCom") == null)
/* 1728 */         this.manageCom = null;
/*      */       else {
/* 1730 */         this.manageCom = rs.getString("manageCom").trim();
/*      */       }
/* 1732 */       if (rs.getString("executeCom") == null)
/* 1733 */         this.executeCom = null;
/*      */       else {
/* 1735 */         this.executeCom = rs.getString("executeCom").trim();
/*      */       }
/* 1737 */       if (rs.getString("agentCom") == null)
/* 1738 */         this.agentCom = null;
/*      */       else {
/* 1740 */         this.agentCom = rs.getString("agentCom").trim();
/*      */       }
/* 1742 */       if (rs.getString("agentCode") == null)
/* 1743 */         this.agentCode = null;
/*      */       else {
/* 1745 */         this.agentCode = rs.getString("agentCode").trim();
/*      */       }
/* 1747 */       if (rs.getString("agentGroup") == null)
/* 1748 */         this.agentGroup = null;
/*      */       else {
/* 1750 */         this.agentGroup = rs.getString("agentGroup").trim();
/*      */       }
/* 1752 */       if (rs.getString("agentCode1") == null)
/* 1753 */         this.agentCode1 = null;
/*      */       else {
/* 1755 */         this.agentCode1 = rs.getString("agentCode1").trim();
/*      */       }
/* 1757 */       if (rs.getString("agentGroup1") == null)
/* 1758 */         this.agentGroup1 = null;
/*      */       else {
/* 1760 */         this.agentGroup1 = rs.getString("agentGroup1").trim();
/*      */       }
/* 1762 */       if (rs.getString("agentType") == null)
/* 1763 */         this.agentType = null;
/*      */       else {
/* 1765 */         this.agentType = rs.getString("agentType").trim();
/*      */       }
/* 1767 */       if (rs.getString("saleChnl") == null)
/* 1768 */         this.saleChnl = null;
/*      */       else {
/* 1770 */         this.saleChnl = rs.getString("saleChnl").trim();
/*      */       }
/* 1772 */       if (rs.getString("handler") == null)
/* 1773 */         this.handler = null;
/*      */       else {
/* 1775 */         this.handler = rs.getString("handler").trim();
/*      */       }
/* 1777 */       if (rs.getString("password") == null)
/* 1778 */         this.password = null;
/*      */       else {
/* 1780 */         this.password = rs.getString("password").trim();
/*      */       }
/* 1782 */       if (rs.getString("appntNo") == null)
/* 1783 */         this.appntNo = null;
/*      */       else {
/* 1785 */         this.appntNo = rs.getString("appntNo").trim();
/*      */       }
/* 1787 */       if (rs.getString("appntId") == null)
/* 1788 */         this.appntId = null;
/*      */       else {
/* 1790 */         this.appntId = rs.getString("appntId").trim();
/*      */       }
/* 1792 */       if (rs.getString("appntName") == null)
/* 1793 */         this.appntName = null;
/*      */       else {
/* 1795 */         this.appntName = rs.getString("appntName").trim();
/*      */       }
/* 1797 */       if (rs.getString("appntSex") == null)
/* 1798 */         this.appntSex = null;
/*      */       else {
/* 1800 */         this.appntSex = rs.getString("appntSex").trim();
/*      */       }
/* 1802 */       this.appntBirthday = rs.getDate("appntBirthday");
/* 1803 */       if (rs.getString("appntIDType") == null)
/* 1804 */         this.appntIDType = null;
/*      */       else {
/* 1806 */         this.appntIDType = rs.getString("appntIDType").trim();
/*      */       }
/* 1808 */       if (rs.getString("appntIDNo") == null)
/* 1809 */         this.appntIDNo = null;
/*      */       else {
/* 1811 */         this.appntIDNo = rs.getString("appntIDNo").trim();
/*      */       }
/* 1813 */       if (rs.getString("insuredNo") == null)
/* 1814 */         this.insuredNo = null;
/*      */       else {
/* 1816 */         this.insuredNo = rs.getString("insuredNo").trim();
/*      */       }
/* 1818 */       if (rs.getString("insuredId") == null)
/* 1819 */         this.insuredId = null;
/*      */       else {
/* 1821 */         this.insuredId = rs.getString("insuredId").trim();
/*      */       }
/* 1823 */       if (rs.getString("insuredName") == null)
/* 1824 */         this.insuredName = null;
/*      */       else {
/* 1826 */         this.insuredName = rs.getString("insuredName").trim();
/*      */       }
/* 1828 */       if (rs.getString("insuredSex") == null)
/* 1829 */         this.insuredSex = null;
/*      */       else {
/* 1831 */         this.insuredSex = rs.getString("insuredSex").trim();
/*      */       }
/* 1833 */       this.insuredBirthday = rs.getDate("insuredBirthday");
/* 1834 */       if (rs.getString("insuredIDType") == null)
/* 1835 */         this.insuredIDType = null;
/*      */       else {
/* 1837 */         this.insuredIDType = rs.getString("insuredIDType").trim();
/*      */       }
/* 1839 */       if (rs.getString("insuredIDNo") == null)
/* 1840 */         this.insuredIDNo = null;
/*      */       else {
/* 1842 */         this.insuredIDNo = rs.getString("insuredIDNo").trim();
/*      */       }
/* 1844 */       this.payIntv = rs.getInt("payIntv");
/* 1845 */       if (rs.getString("payMode") == null)
/* 1846 */         this.payMode = null;
/*      */       else {
/* 1848 */         this.payMode = rs.getString("payMode").trim();
/*      */       }
/* 1850 */       if (rs.getString("payLocation") == null)
/* 1851 */         this.payLocation = null;
/*      */       else {
/* 1853 */         this.payLocation = rs.getString("payLocation").trim();
/*      */       }
/* 1855 */       if (rs.getString("disputedFlag") == null)
/* 1856 */         this.disputedFlag = null;
/*      */       else {
/* 1858 */         this.disputedFlag = rs.getString("disputedFlag").trim();
/*      */       }
/* 1860 */       if (rs.getString("outPayFlag") == null)
/* 1861 */         this.outPayFlag = null;
/*      */       else {
/* 1863 */         this.outPayFlag = rs.getString("outPayFlag").trim();
/*      */       }
/* 1865 */       if (rs.getString("getPolMode") == null)
/* 1866 */         this.getPolMode = null;
/*      */       else {
/* 1868 */         this.getPolMode = rs.getString("getPolMode").trim();
/*      */       }
/* 1870 */       if (rs.getString("signCom") == null)
/* 1871 */         this.signCom = null;
/*      */       else {
/* 1873 */         this.signCom = rs.getString("signCom").trim();
/*      */       }
/* 1875 */       this.signDate = rs.getDate("signDate");
/* 1876 */       if (rs.getString("signTime") == null)
/* 1877 */         this.signTime = null;
/*      */       else {
/* 1879 */         this.signTime = rs.getString("signTime").trim();
/*      */       }
/* 1881 */       if (rs.getString("consignNo") == null)
/* 1882 */         this.consignNo = null;
/*      */       else {
/* 1884 */         this.consignNo = rs.getString("consignNo").trim();
/*      */       }
/* 1886 */       if (rs.getString("bankCode") == null)
/* 1887 */         this.bankCode = null;
/*      */       else {
/* 1889 */         this.bankCode = rs.getString("bankCode").trim();
/*      */       }
/* 1891 */       if (rs.getString("bankAccNo") == null)
/* 1892 */         this.bankAccNo = null;
/*      */       else {
/* 1894 */         this.bankAccNo = rs.getString("bankAccNo").trim();
/*      */       }
/* 1896 */       if (rs.getString("accName") == null)
/* 1897 */         this.accName = null;
/*      */       else {
/* 1899 */         this.accName = rs.getString("accName").trim();
/*      */       }
/* 1901 */       this.printCount = rs.getInt("printCount");
/* 1902 */       this.lostTimes = rs.getInt("lostTimes");
/* 1903 */       if (rs.getString("lang") == null)
/* 1904 */         this.lang = null;
/*      */       else {
/* 1906 */         this.lang = rs.getString("lang").trim();
/*      */       }
/* 1908 */       if (rs.getString("currency") == null)
/* 1909 */         this.currency = null;
/*      */       else {
/* 1911 */         this.currency = rs.getString("currency").trim();
/*      */       }
/* 1913 */       if (rs.getString("remark") == null)
/* 1914 */         this.remark = null;
/*      */       else {
/* 1916 */         this.remark = rs.getString("remark").trim();
/*      */       }
/* 1918 */       this.peoples = rs.getInt("peoples");
/* 1919 */       this.mult = rs.getDouble("mult");
/* 1920 */       this.prem = rs.getDouble("prem");
/* 1921 */       this.amnt = rs.getDouble("amnt");
/* 1922 */       this.sumPrem = rs.getDouble("sumPrem");
/* 1923 */       this.dif = rs.getDouble("dif");
/* 1924 */       this.paytoDate = rs.getDate("paytoDate");
/* 1925 */       this.firstPayDate = rs.getDate("firstPayDate");
/* 1926 */       this.cValiDate = rs.getDate("cValiDate");
/* 1927 */       this.pSignDate = rs.getDate("pSignDate");
/* 1928 */       this.pValiDate = rs.getDate("pValiDate");
/* 1929 */       if (rs.getString("inputOperator") == null)
/* 1930 */         this.inputOperator = null;
/*      */       else {
/* 1932 */         this.inputOperator = rs.getString("inputOperator").trim();
/*      */       }
/* 1934 */       this.inputDate = rs.getDate("inputDate");
/* 1935 */       if (rs.getString("inputTime") == null)
/* 1936 */         this.inputTime = null;
/*      */       else {
/* 1938 */         this.inputTime = rs.getString("inputTime").trim();
/*      */       }
/* 1940 */       if (rs.getString("approveFlag") == null)
/* 1941 */         this.approveFlag = null;
/*      */       else {
/* 1943 */         this.approveFlag = rs.getString("approveFlag").trim();
/*      */       }
/* 1945 */       if (rs.getString("approveCode") == null)
/* 1946 */         this.approveCode = null;
/*      */       else {
/* 1948 */         this.approveCode = rs.getString("approveCode").trim();
/*      */       }
/* 1950 */       this.approveDate = rs.getDate("approveDate");
/* 1951 */       if (rs.getString("approveTime") == null)
/* 1952 */         this.approveTime = null;
/*      */       else {
/* 1954 */         this.approveTime = rs.getString("approveTime").trim();
/*      */       }
/* 1956 */       if (rs.getString("uWFlag") == null)
/* 1957 */         this.uWFlag = null;
/*      */       else {
/* 1959 */         this.uWFlag = rs.getString("uWFlag").trim();
/*      */       }
/* 1961 */       if (rs.getString("uWOperator") == null)
/* 1962 */         this.uWOperator = null;
/*      */       else {
/* 1964 */         this.uWOperator = rs.getString("uWOperator").trim();
/*      */       }
/* 1966 */       this.uWDate = rs.getDate("uWDate");
/* 1967 */       if (rs.getString("uWTime") == null)
/* 1968 */         this.uWTime = null;
/*      */       else {
/* 1970 */         this.uWTime = rs.getString("uWTime").trim();
/*      */       }
/* 1972 */       if (rs.getString("appFlag") == null)
/* 1973 */         this.appFlag = null;
/*      */       else {
/* 1975 */         this.appFlag = rs.getString("appFlag").trim();
/*      */       }
/* 1977 */       this.polApplyDate = rs.getDate("polApplyDate");
/* 1978 */       this.getPolDate = rs.getDate("getPolDate");
/* 1979 */       if (rs.getString("getPolTime") == null)
/* 1980 */         this.getPolTime = null;
/*      */       else {
/* 1982 */         this.getPolTime = rs.getString("getPolTime").trim();
/*      */       }
/* 1984 */       this.customGetPolDate = rs.getDate("customGetPolDate");
/* 1985 */       if (rs.getString("state") == null)
/* 1986 */         this.state = null;
/*      */       else {
/* 1988 */         this.state = rs.getString("state").trim();
/*      */       }
/* 1990 */       if (rs.getString("saleChnlDetail") == null)
/* 1991 */         this.saleChnlDetail = null;
/*      */       else {
/* 1993 */         this.saleChnlDetail = rs.getString("saleChnlDetail").trim();
/*      */       }
/* 1995 */       if (rs.getString("proposalType") == null)
/* 1996 */         this.proposalType = null;
/*      */       else {
/* 1998 */         this.proposalType = rs.getString("proposalType").trim();
/*      */       }
/* 2000 */       if (rs.getString("editstate") == null)
/* 2001 */         this.editstate = null;
/*      */       else {
/* 2003 */         this.editstate = rs.getString("editstate").trim();
/*      */       }
/* 2005 */       this.cInValiDate = rs.getDate("cInValiDate");
/* 2006 */       if (rs.getString("operator") == null)
/* 2007 */         this.operator = null;
/*      */       else {
/* 2009 */         this.operator = rs.getString("operator").trim();
/*      */       }
/* 2011 */       this.makeDate = rs.getDate("makeDate");
/* 2012 */       if (rs.getString("makeTime") == null)
/* 2013 */         this.makeTime = null;
/*      */       else {
/* 2015 */         this.makeTime = rs.getString("makeTime").trim();
/*      */       }
/* 2017 */       this.modifyDate = rs.getDate("modifyDate");
/* 2018 */       if (rs.getString("modifyTime") == null)
/* 2019 */         this.modifyTime = null;
/*      */       else {
/* 2021 */         this.modifyTime = rs.getString("modifyTime").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 2027 */       CError tError = new CError();
/* 2028 */       tError.moduleName = "LNPContBSchema";
/* 2029 */       tError.functionName = "setSchema";
/* 2030 */       tError.errorMessage = sqle.toString();
/* 2031 */       this.mErrors.addOneError(tError);
/*      */ 
/* 2033 */       return false;
/*      */     }
/* 2035 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPContBSchema getSchema()
/*      */   {
/* 2040 */     LNPContBSchema aLNPContBSchema = new LNPContBSchema();
/* 2041 */     aLNPContBSchema.setSchema(this);
/* 2042 */     return aLNPContBSchema;
/*      */   }
/*      */ 
/*      */   public LNPContBDB getDB()
/*      */   {
/* 2047 */     LNPContBDB aDBOper = new LNPContBDB();
/* 2048 */     aDBOper.setSchema(this);
/* 2049 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 2056 */     String strReturn = "";
/* 2057 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/* 2058 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/* 2059 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpContNo)) + "|" + 
/* 2060 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contNo)) + "|" + 
/* 2061 */       StrTool.cTrim(StrTool.unicodeToGBK(this.proposalContNo)) + "|" + 
/* 2062 */       StrTool.cTrim(StrTool.unicodeToGBK(this.prtNo)) + "|" + 
/* 2063 */       StrTool.cTrim(StrTool.unicodeToGBK(this.mainPolNo)) + "|" + 
/* 2064 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contType)) + "|" + 
/* 2065 */       StrTool.cTrim(StrTool.unicodeToGBK(this.familyType)) + "|" + 
/* 2066 */       StrTool.cTrim(StrTool.unicodeToGBK(this.familyID)) + "|" + 
/* 2067 */       StrTool.cTrim(StrTool.unicodeToGBK(this.polType)) + "|" + 
/* 2068 */       StrTool.cTrim(StrTool.unicodeToGBK(this.sugNo)) + "|" + 
/* 2069 */       StrTool.cTrim(StrTool.unicodeToGBK(this.cardFlag)) + "|" + 
/* 2070 */       StrTool.cTrim(StrTool.unicodeToGBK(this.manageCom)) + "|" + 
/* 2071 */       StrTool.cTrim(StrTool.unicodeToGBK(this.executeCom)) + "|" + 
/* 2072 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentCom)) + "|" + 
/* 2073 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentCode)) + "|" + 
/* 2074 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentGroup)) + "|" + 
/* 2075 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentCode1)) + "|" + 
/* 2076 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentGroup1)) + "|" + 
/* 2077 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentType)) + "|" + 
/* 2078 */       StrTool.cTrim(StrTool.unicodeToGBK(this.saleChnl)) + "|" + 
/* 2079 */       StrTool.cTrim(StrTool.unicodeToGBK(this.handler)) + "|" + 
/* 2080 */       StrTool.cTrim(StrTool.unicodeToGBK(this.password)) + "|" + 
/* 2081 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntNo)) + "|" + 
/* 2082 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntId)) + "|" + 
/* 2083 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntName)) + "|" + 
/* 2084 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntSex)) + "|" + 
/* 2085 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.appntBirthday))) + "|" + 
/* 2086 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntIDType)) + "|" + 
/* 2087 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appntIDNo)) + "|" + 
/* 2088 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredNo)) + "|" + 
/* 2089 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredId)) + "|" + 
/* 2090 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredName)) + "|" + 
/* 2091 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredSex)) + "|" + 
/* 2092 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.insuredBirthday))) + "|" + 
/* 2093 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredIDType)) + "|" + 
/* 2094 */       StrTool.cTrim(StrTool.unicodeToGBK(this.insuredIDNo)) + "|" + 
/* 2095 */       ChgData.chgData(this.payIntv) + "|" + 
/* 2096 */       StrTool.cTrim(StrTool.unicodeToGBK(this.payMode)) + "|" + 
/* 2097 */       StrTool.cTrim(StrTool.unicodeToGBK(this.payLocation)) + "|" + 
/* 2098 */       StrTool.cTrim(StrTool.unicodeToGBK(this.disputedFlag)) + "|" + 
/* 2099 */       StrTool.cTrim(StrTool.unicodeToGBK(this.outPayFlag)) + "|" + 
/* 2100 */       StrTool.cTrim(StrTool.unicodeToGBK(this.getPolMode)) + "|" + 
/* 2101 */       StrTool.cTrim(StrTool.unicodeToGBK(this.signCom)) + "|" + 
/* 2102 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.signDate))) + "|" + 
/* 2103 */       StrTool.cTrim(StrTool.unicodeToGBK(this.signTime)) + "|" + 
/* 2104 */       StrTool.cTrim(StrTool.unicodeToGBK(this.consignNo)) + "|" + 
/* 2105 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bankCode)) + "|" + 
/* 2106 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bankAccNo)) + "|" + 
/* 2107 */       StrTool.cTrim(StrTool.unicodeToGBK(this.accName)) + "|" + 
/* 2108 */       ChgData.chgData(this.printCount) + "|" + 
/* 2109 */       ChgData.chgData(this.lostTimes) + "|" + 
/* 2110 */       StrTool.cTrim(StrTool.unicodeToGBK(this.lang)) + "|" + 
/* 2111 */       StrTool.cTrim(StrTool.unicodeToGBK(this.currency)) + "|" + 
/* 2112 */       StrTool.cTrim(StrTool.unicodeToGBK(this.remark)) + "|" + 
/* 2113 */       ChgData.chgData(this.peoples) + "|" + 
/* 2114 */       ChgData.chgData(this.mult) + "|" + 
/* 2115 */       ChgData.chgData(this.prem) + "|" + 
/* 2116 */       ChgData.chgData(this.amnt) + "|" + 
/* 2117 */       ChgData.chgData(this.sumPrem) + "|" + 
/* 2118 */       ChgData.chgData(this.dif) + "|" + 
/* 2119 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.paytoDate))) + "|" + 
/* 2120 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.firstPayDate))) + "|" + 
/* 2121 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.cValiDate))) + "|" + 
/* 2122 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.pSignDate))) + "|" + 
/* 2123 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.pValiDate))) + "|" + 
/* 2124 */       StrTool.cTrim(StrTool.unicodeToGBK(this.inputOperator)) + "|" + 
/* 2125 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.inputDate))) + "|" + 
/* 2126 */       StrTool.cTrim(StrTool.unicodeToGBK(this.inputTime)) + "|" + 
/* 2127 */       StrTool.cTrim(StrTool.unicodeToGBK(this.approveFlag)) + "|" + 
/* 2128 */       StrTool.cTrim(StrTool.unicodeToGBK(this.approveCode)) + "|" + 
/* 2129 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.approveDate))) + "|" + 
/* 2130 */       StrTool.cTrim(StrTool.unicodeToGBK(this.approveTime)) + "|" + 
/* 2131 */       StrTool.cTrim(StrTool.unicodeToGBK(this.uWFlag)) + "|" + 
/* 2132 */       StrTool.cTrim(StrTool.unicodeToGBK(this.uWOperator)) + "|" + 
/* 2133 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.uWDate))) + "|" + 
/* 2134 */       StrTool.cTrim(StrTool.unicodeToGBK(this.uWTime)) + "|" + 
/* 2135 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appFlag)) + "|" + 
/* 2136 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.polApplyDate))) + "|" + 
/* 2137 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.getPolDate))) + "|" + 
/* 2138 */       StrTool.cTrim(StrTool.unicodeToGBK(this.getPolTime)) + "|" + 
/* 2139 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.customGetPolDate))) + "|" + 
/* 2140 */       StrTool.cTrim(StrTool.unicodeToGBK(this.state)) + "|" + 
/* 2141 */       StrTool.cTrim(StrTool.unicodeToGBK(this.saleChnlDetail)) + "|" + 
/* 2142 */       StrTool.cTrim(StrTool.unicodeToGBK(this.proposalType)) + "|" + 
/* 2143 */       StrTool.cTrim(StrTool.unicodeToGBK(this.editstate)) + "|" + 
/* 2144 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.cInValiDate))) + "|" + 
/* 2145 */       StrTool.cTrim(StrTool.unicodeToGBK(this.operator)) + "|" + 
/* 2146 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makeDate))) + "|" + 
/* 2147 */       StrTool.cTrim(StrTool.unicodeToGBK(this.makeTime)) + "|" + 
/* 2148 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifyDate))) + "|" + 
/* 2149 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifyTime));
/* 2150 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 2158 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 2159 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 2160 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 2161 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 2162 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 2163 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 2164 */       this.mainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 2165 */       this.contType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 2166 */       this.familyType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 2167 */       this.familyID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 2168 */       this.polType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 2169 */       this.sugNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 2170 */       this.cardFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 2171 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 2172 */       this.executeCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 2173 */       this.agentCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 2174 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 2175 */       this.agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 2176 */       this.agentCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 2177 */       this.agentGroup1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 2178 */       this.agentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 2179 */       this.saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 2180 */       this.handler = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 2181 */       this.password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 2182 */       this.appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 2183 */       this.appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 2184 */       this.appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 2185 */       this.appntSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 2186 */       this.appntBirthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|"));
/* 2187 */       this.appntIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 2188 */       this.appntIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/* 2189 */       this.insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 2190 */       this.insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 2191 */       this.insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/* 2192 */       this.insuredSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 2193 */       this.insuredBirthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|"));
/* 2194 */       this.insuredIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 2195 */       this.insuredIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/* 2196 */       this.payIntv = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|"))).intValue();
/* 2197 */       this.payMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 2198 */       this.payLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 2199 */       this.disputedFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 2200 */       this.outPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 2201 */       this.getPolMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 2202 */       this.signCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 2203 */       this.signDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|"));
/* 2204 */       this.signTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
/* 2205 */       this.consignNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 2206 */       this.bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/* 2207 */       this.bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
/* 2208 */       this.accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
/* 2209 */       this.printCount = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 52, "|"))).intValue();
/* 2210 */       this.lostTimes = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 53, "|"))).intValue();
/* 2211 */       this.lang = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
/* 2212 */       this.currency = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
/* 2213 */       this.remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
/* 2214 */       this.peoples = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|"))).intValue();
/* 2215 */       this.mult = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|"))).doubleValue();
/* 2216 */       this.prem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|"))).doubleValue();
/* 2217 */       this.amnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|"))).doubleValue();
/* 2218 */       this.sumPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|"))).doubleValue();
/* 2219 */       this.dif = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 62, "|"))).doubleValue();
/* 2220 */       this.paytoDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 63, "|"));
/* 2221 */       this.firstPayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 64, "|"));
/* 2222 */       this.cValiDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 65, "|"));
/* 2223 */       this.pSignDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 66, "|"));
/* 2224 */       this.pValiDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 67, "|"));
/* 2225 */       this.inputOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 68, "|");
/* 2226 */       this.inputDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 69, "|"));
/* 2227 */       this.inputTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 70, "|");
/* 2228 */       this.approveFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 71, "|");
/* 2229 */       this.approveCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 72, "|");
/* 2230 */       this.approveDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 73, "|"));
/* 2231 */       this.approveTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 74, "|");
/* 2232 */       this.uWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 75, "|");
/* 2233 */       this.uWOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 76, "|");
/* 2234 */       this.uWDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 77, "|"));
/* 2235 */       this.uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 78, "|");
/* 2236 */       this.appFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 79, "|");
/* 2237 */       this.polApplyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 80, "|"));
/* 2238 */       this.getPolDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 81, "|"));
/* 2239 */       this.getPolTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 82, "|");
/* 2240 */       this.customGetPolDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 83, "|"));
/* 2241 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 84, "|");
/* 2242 */       this.saleChnlDetail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 85, "|");
/* 2243 */       this.proposalType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 86, "|");
/* 2244 */       this.editstate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 87, "|");
/* 2245 */       this.cInValiDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 88, "|"));
/* 2246 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 89, "|");
/* 2247 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 90, "|"));
/* 2248 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 91, "|");
/* 2249 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 92, "|"));
/* 2250 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 93, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 2255 */       CError tError = new CError();
/* 2256 */       tError.moduleName = "LNPContBSchema";
/* 2257 */       tError.functionName = "decode";
/* 2258 */       tError.errorMessage = ex.toString();
/* 2259 */       this.mErrors.addOneError(tError);
/*      */ 
/* 2261 */       return false;
/*      */     }
/* 2263 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 2269 */     String strReturn = "";
/* 2270 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 2272 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/* 2274 */     if (FCode.equals("serialNo"))
/*      */     {
/* 2276 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/* 2278 */     if (FCode.equals("grpContNo"))
/*      */     {
/* 2280 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/* 2282 */     if (FCode.equals("contNo"))
/*      */     {
/* 2284 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/* 2286 */     if (FCode.equals("proposalContNo"))
/*      */     {
/* 2288 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/* 2290 */     if (FCode.equals("prtNo"))
/*      */     {
/* 2292 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/* 2294 */     if (FCode.equals("mainPolNo"))
/*      */     {
/* 2296 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mainPolNo));
/*      */     }
/* 2298 */     if (FCode.equals("contType"))
/*      */     {
/* 2300 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contType));
/*      */     }
/* 2302 */     if (FCode.equals("familyType"))
/*      */     {
/* 2304 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.familyType));
/*      */     }
/* 2306 */     if (FCode.equals("familyID"))
/*      */     {
/* 2308 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.familyID));
/*      */     }
/* 2310 */     if (FCode.equals("polType"))
/*      */     {
/* 2312 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polType));
/*      */     }
/* 2314 */     if (FCode.equals("sugNo"))
/*      */     {
/* 2316 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sugNo));
/*      */     }
/* 2318 */     if (FCode.equals("cardFlag"))
/*      */     {
/* 2320 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.cardFlag));
/*      */     }
/* 2322 */     if (FCode.equals("manageCom"))
/*      */     {
/* 2324 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 2326 */     if (FCode.equals("executeCom"))
/*      */     {
/* 2328 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.executeCom));
/*      */     }
/* 2330 */     if (FCode.equals("agentCom"))
/*      */     {
/* 2332 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCom));
/*      */     }
/* 2334 */     if (FCode.equals("agentCode"))
/*      */     {
/* 2336 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/* 2338 */     if (FCode.equals("agentGroup"))
/*      */     {
/* 2340 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup));
/*      */     }
/* 2342 */     if (FCode.equals("agentCode1"))
/*      */     {
/* 2344 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode1));
/*      */     }
/* 2346 */     if (FCode.equals("agentGroup1"))
/*      */     {
/* 2348 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup1));
/*      */     }
/* 2350 */     if (FCode.equals("agentType"))
/*      */     {
/* 2352 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentType));
/*      */     }
/* 2354 */     if (FCode.equals("saleChnl"))
/*      */     {
/* 2356 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.saleChnl));
/*      */     }
/* 2358 */     if (FCode.equals("handler"))
/*      */     {
/* 2360 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.handler));
/*      */     }
/* 2362 */     if (FCode.equals("password"))
/*      */     {
/* 2364 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.password));
/*      */     }
/* 2366 */     if (FCode.equals("appntNo"))
/*      */     {
/* 2368 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntNo));
/*      */     }
/* 2370 */     if (FCode.equals("appntId"))
/*      */     {
/* 2372 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntId));
/*      */     }
/* 2374 */     if (FCode.equals("appntName"))
/*      */     {
/* 2376 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntName));
/*      */     }
/* 2378 */     if (FCode.equals("appntSex"))
/*      */     {
/* 2380 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntSex));
/*      */     }
/* 2382 */     if (FCode.equals("appntBirthday"))
/*      */     {
/* 2384 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getappntBirthday()));
/*      */     }
/* 2386 */     if (FCode.equals("appntIDType"))
/*      */     {
/* 2388 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntIDType));
/*      */     }
/* 2390 */     if (FCode.equals("appntIDNo"))
/*      */     {
/* 2392 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appntIDNo));
/*      */     }
/* 2394 */     if (FCode.equals("insuredNo"))
/*      */     {
/* 2396 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredNo));
/*      */     }
/* 2398 */     if (FCode.equals("insuredId"))
/*      */     {
/* 2400 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredId));
/*      */     }
/* 2402 */     if (FCode.equals("insuredName"))
/*      */     {
/* 2404 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredName));
/*      */     }
/* 2406 */     if (FCode.equals("insuredSex"))
/*      */     {
/* 2408 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredSex));
/*      */     }
/* 2410 */     if (FCode.equals("insuredBirthday"))
/*      */     {
/* 2412 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getinsuredBirthday()));
/*      */     }
/* 2414 */     if (FCode.equals("insuredIDType"))
/*      */     {
/* 2416 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredIDType));
/*      */     }
/* 2418 */     if (FCode.equals("insuredIDNo"))
/*      */     {
/* 2420 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredIDNo));
/*      */     }
/* 2422 */     if (FCode.equals("payIntv"))
/*      */     {
/* 2424 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payIntv));
/*      */     }
/* 2426 */     if (FCode.equals("payMode"))
/*      */     {
/* 2428 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payMode));
/*      */     }
/* 2430 */     if (FCode.equals("payLocation"))
/*      */     {
/* 2432 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payLocation));
/*      */     }
/* 2434 */     if (FCode.equals("disputedFlag"))
/*      */     {
/* 2436 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.disputedFlag));
/*      */     }
/* 2438 */     if (FCode.equals("outPayFlag"))
/*      */     {
/* 2440 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.outPayFlag));
/*      */     }
/* 2442 */     if (FCode.equals("getPolMode"))
/*      */     {
/* 2444 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getPolMode));
/*      */     }
/* 2446 */     if (FCode.equals("signCom"))
/*      */     {
/* 2448 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signCom));
/*      */     }
/* 2450 */     if (FCode.equals("signDate"))
/*      */     {
/* 2452 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getsignDate()));
/*      */     }
/* 2454 */     if (FCode.equals("signTime"))
/*      */     {
/* 2456 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signTime));
/*      */     }
/* 2458 */     if (FCode.equals("consignNo"))
/*      */     {
/* 2460 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.consignNo));
/*      */     }
/* 2462 */     if (FCode.equals("bankCode"))
/*      */     {
/* 2464 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankCode));
/*      */     }
/* 2466 */     if (FCode.equals("bankAccNo"))
/*      */     {
/* 2468 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankAccNo));
/*      */     }
/* 2470 */     if (FCode.equals("accName"))
/*      */     {
/* 2472 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.accName));
/*      */     }
/* 2474 */     if (FCode.equals("printCount"))
/*      */     {
/* 2476 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.printCount));
/*      */     }
/* 2478 */     if (FCode.equals("lostTimes"))
/*      */     {
/* 2480 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lostTimes));
/*      */     }
/* 2482 */     if (FCode.equals("lang"))
/*      */     {
/* 2484 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lang));
/*      */     }
/* 2486 */     if (FCode.equals("currency"))
/*      */     {
/* 2488 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.currency));
/*      */     }
/* 2490 */     if (FCode.equals("remark"))
/*      */     {
/* 2492 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark));
/*      */     }
/* 2494 */     if (FCode.equals("peoples"))
/*      */     {
/* 2496 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.peoples));
/*      */     }
/* 2498 */     if (FCode.equals("mult"))
/*      */     {
/* 2500 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mult));
/*      */     }
/* 2502 */     if (FCode.equals("prem"))
/*      */     {
/* 2504 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prem));
/*      */     }
/* 2506 */     if (FCode.equals("amnt"))
/*      */     {
/* 2508 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.amnt));
/*      */     }
/* 2510 */     if (FCode.equals("sumPrem"))
/*      */     {
/* 2512 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sumPrem));
/*      */     }
/* 2514 */     if (FCode.equals("dif"))
/*      */     {
/* 2516 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dif));
/*      */     }
/* 2518 */     if (FCode.equals("paytoDate"))
/*      */     {
/* 2520 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getpaytoDate()));
/*      */     }
/* 2522 */     if (FCode.equals("firstPayDate"))
/*      */     {
/* 2524 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getfirstPayDate()));
/*      */     }
/* 2526 */     if (FCode.equals("cValiDate"))
/*      */     {
/* 2528 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getcValiDate()));
/*      */     }
/* 2530 */     if (FCode.equals("pSignDate"))
/*      */     {
/* 2532 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getpSignDate()));
/*      */     }
/* 2534 */     if (FCode.equals("pValiDate"))
/*      */     {
/* 2536 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getpValiDate()));
/*      */     }
/* 2538 */     if (FCode.equals("inputOperator"))
/*      */     {
/* 2540 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.inputOperator));
/*      */     }
/* 2542 */     if (FCode.equals("inputDate"))
/*      */     {
/* 2544 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getinputDate()));
/*      */     }
/* 2546 */     if (FCode.equals("inputTime"))
/*      */     {
/* 2548 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.inputTime));
/*      */     }
/* 2550 */     if (FCode.equals("approveFlag"))
/*      */     {
/* 2552 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveFlag));
/*      */     }
/* 2554 */     if (FCode.equals("approveCode"))
/*      */     {
/* 2556 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveCode));
/*      */     }
/* 2558 */     if (FCode.equals("approveDate"))
/*      */     {
/* 2560 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getapproveDate()));
/*      */     }
/* 2562 */     if (FCode.equals("approveTime"))
/*      */     {
/* 2564 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.approveTime));
/*      */     }
/* 2566 */     if (FCode.equals("uWFlag"))
/*      */     {
/* 2568 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWFlag));
/*      */     }
/* 2570 */     if (FCode.equals("uWOperator"))
/*      */     {
/* 2572 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWOperator));
/*      */     }
/* 2574 */     if (FCode.equals("uWDate"))
/*      */     {
/* 2576 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
/*      */     }
/* 2578 */     if (FCode.equals("uWTime"))
/*      */     {
/* 2580 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWTime));
/*      */     }
/* 2582 */     if (FCode.equals("appFlag"))
/*      */     {
/* 2584 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appFlag));
/*      */     }
/* 2586 */     if (FCode.equals("polApplyDate"))
/*      */     {
/* 2588 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getpolApplyDate()));
/*      */     }
/* 2590 */     if (FCode.equals("getPolDate"))
/*      */     {
/* 2592 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getgetPolDate()));
/*      */     }
/* 2594 */     if (FCode.equals("getPolTime"))
/*      */     {
/* 2596 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getPolTime));
/*      */     }
/* 2598 */     if (FCode.equals("customGetPolDate"))
/*      */     {
/* 2600 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getcustomGetPolDate()));
/*      */     }
/* 2602 */     if (FCode.equals("state"))
/*      */     {
/* 2604 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/* 2606 */     if (FCode.equals("saleChnlDetail"))
/*      */     {
/* 2608 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.saleChnlDetail));
/*      */     }
/* 2610 */     if (FCode.equals("proposalType"))
/*      */     {
/* 2612 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalType));
/*      */     }
/* 2614 */     if (FCode.equals("editstate"))
/*      */     {
/* 2616 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.editstate));
/*      */     }
/* 2618 */     if (FCode.equals("cInValiDate"))
/*      */     {
/* 2620 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getcInValiDate()));
/*      */     }
/* 2622 */     if (FCode.equals("operator"))
/*      */     {
/* 2624 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 2626 */     if (FCode.equals("makeDate"))
/*      */     {
/* 2628 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*      */     }
/* 2630 */     if (FCode.equals("makeTime"))
/*      */     {
/* 2632 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 2634 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 2636 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*      */     }
/* 2638 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 2640 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 2642 */     if (strReturn.equals(""))
/*      */     {
/* 2644 */       strReturn = "null";
/*      */     }
/*      */ 
/* 2647 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 2654 */     String strFieldValue = "";
/* 2655 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2657 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/* 2658 */       break;
/*      */     case 1:
/* 2660 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/* 2661 */       break;
/*      */     case 2:
/* 2663 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/* 2664 */       break;
/*      */     case 3:
/* 2666 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 2667 */       break;
/*      */     case 4:
/* 2669 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/* 2670 */       break;
/*      */     case 5:
/* 2672 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/* 2673 */       break;
/*      */     case 6:
/* 2675 */       strFieldValue = StrTool.GBKToUnicode(this.mainPolNo);
/* 2676 */       break;
/*      */     case 7:
/* 2678 */       strFieldValue = StrTool.GBKToUnicode(this.contType);
/* 2679 */       break;
/*      */     case 8:
/* 2681 */       strFieldValue = StrTool.GBKToUnicode(this.familyType);
/* 2682 */       break;
/*      */     case 9:
/* 2684 */       strFieldValue = StrTool.GBKToUnicode(this.familyID);
/* 2685 */       break;
/*      */     case 10:
/* 2687 */       strFieldValue = StrTool.GBKToUnicode(this.polType);
/* 2688 */       break;
/*      */     case 11:
/* 2690 */       strFieldValue = StrTool.GBKToUnicode(this.sugNo);
/* 2691 */       break;
/*      */     case 12:
/* 2693 */       strFieldValue = StrTool.GBKToUnicode(this.cardFlag);
/* 2694 */       break;
/*      */     case 13:
/* 2696 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 2697 */       break;
/*      */     case 14:
/* 2699 */       strFieldValue = StrTool.GBKToUnicode(this.executeCom);
/* 2700 */       break;
/*      */     case 15:
/* 2702 */       strFieldValue = StrTool.GBKToUnicode(this.agentCom);
/* 2703 */       break;
/*      */     case 16:
/* 2705 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/* 2706 */       break;
/*      */     case 17:
/* 2708 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup);
/* 2709 */       break;
/*      */     case 18:
/* 2711 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode1);
/* 2712 */       break;
/*      */     case 19:
/* 2714 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup1);
/* 2715 */       break;
/*      */     case 20:
/* 2717 */       strFieldValue = StrTool.GBKToUnicode(this.agentType);
/* 2718 */       break;
/*      */     case 21:
/* 2720 */       strFieldValue = StrTool.GBKToUnicode(this.saleChnl);
/* 2721 */       break;
/*      */     case 22:
/* 2723 */       strFieldValue = StrTool.GBKToUnicode(this.handler);
/* 2724 */       break;
/*      */     case 23:
/* 2726 */       strFieldValue = StrTool.GBKToUnicode(this.password);
/* 2727 */       break;
/*      */     case 24:
/* 2729 */       strFieldValue = StrTool.GBKToUnicode(this.appntNo);
/* 2730 */       break;
/*      */     case 25:
/* 2732 */       strFieldValue = StrTool.GBKToUnicode(this.appntId);
/* 2733 */       break;
/*      */     case 26:
/* 2735 */       strFieldValue = StrTool.GBKToUnicode(this.appntName);
/* 2736 */       break;
/*      */     case 27:
/* 2738 */       strFieldValue = StrTool.GBKToUnicode(this.appntSex);
/* 2739 */       break;
/*      */     case 28:
/* 2741 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getappntBirthday()));
/* 2742 */       break;
/*      */     case 29:
/* 2744 */       strFieldValue = StrTool.GBKToUnicode(this.appntIDType);
/* 2745 */       break;
/*      */     case 30:
/* 2747 */       strFieldValue = StrTool.GBKToUnicode(this.appntIDNo);
/* 2748 */       break;
/*      */     case 31:
/* 2750 */       strFieldValue = StrTool.GBKToUnicode(this.insuredNo);
/* 2751 */       break;
/*      */     case 32:
/* 2753 */       strFieldValue = StrTool.GBKToUnicode(this.insuredId);
/* 2754 */       break;
/*      */     case 33:
/* 2756 */       strFieldValue = StrTool.GBKToUnicode(this.insuredName);
/* 2757 */       break;
/*      */     case 34:
/* 2759 */       strFieldValue = StrTool.GBKToUnicode(this.insuredSex);
/* 2760 */       break;
/*      */     case 35:
/* 2762 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getinsuredBirthday()));
/* 2763 */       break;
/*      */     case 36:
/* 2765 */       strFieldValue = StrTool.GBKToUnicode(this.insuredIDType);
/* 2766 */       break;
/*      */     case 37:
/* 2768 */       strFieldValue = StrTool.GBKToUnicode(this.insuredIDNo);
/* 2769 */       break;
/*      */     case 38:
/* 2771 */       strFieldValue = String.valueOf(this.payIntv);
/* 2772 */       break;
/*      */     case 39:
/* 2774 */       strFieldValue = StrTool.GBKToUnicode(this.payMode);
/* 2775 */       break;
/*      */     case 40:
/* 2777 */       strFieldValue = StrTool.GBKToUnicode(this.payLocation);
/* 2778 */       break;
/*      */     case 41:
/* 2780 */       strFieldValue = StrTool.GBKToUnicode(this.disputedFlag);
/* 2781 */       break;
/*      */     case 42:
/* 2783 */       strFieldValue = StrTool.GBKToUnicode(this.outPayFlag);
/* 2784 */       break;
/*      */     case 43:
/* 2786 */       strFieldValue = StrTool.GBKToUnicode(this.getPolMode);
/* 2787 */       break;
/*      */     case 44:
/* 2789 */       strFieldValue = StrTool.GBKToUnicode(this.signCom);
/* 2790 */       break;
/*      */     case 45:
/* 2792 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getsignDate()));
/* 2793 */       break;
/*      */     case 46:
/* 2795 */       strFieldValue = StrTool.GBKToUnicode(this.signTime);
/* 2796 */       break;
/*      */     case 47:
/* 2798 */       strFieldValue = StrTool.GBKToUnicode(this.consignNo);
/* 2799 */       break;
/*      */     case 48:
/* 2801 */       strFieldValue = StrTool.GBKToUnicode(this.bankCode);
/* 2802 */       break;
/*      */     case 49:
/* 2804 */       strFieldValue = StrTool.GBKToUnicode(this.bankAccNo);
/* 2805 */       break;
/*      */     case 50:
/* 2807 */       strFieldValue = StrTool.GBKToUnicode(this.accName);
/* 2808 */       break;
/*      */     case 51:
/* 2810 */       strFieldValue = String.valueOf(this.printCount);
/* 2811 */       break;
/*      */     case 52:
/* 2813 */       strFieldValue = String.valueOf(this.lostTimes);
/* 2814 */       break;
/*      */     case 53:
/* 2816 */       strFieldValue = StrTool.GBKToUnicode(this.lang);
/* 2817 */       break;
/*      */     case 54:
/* 2819 */       strFieldValue = StrTool.GBKToUnicode(this.currency);
/* 2820 */       break;
/*      */     case 55:
/* 2822 */       strFieldValue = StrTool.GBKToUnicode(this.remark);
/* 2823 */       break;
/*      */     case 56:
/* 2825 */       strFieldValue = String.valueOf(this.peoples);
/* 2826 */       break;
/*      */     case 57:
/* 2828 */       strFieldValue = String.valueOf(this.mult);
/* 2829 */       break;
/*      */     case 58:
/* 2831 */       strFieldValue = String.valueOf(this.prem);
/* 2832 */       break;
/*      */     case 59:
/* 2834 */       strFieldValue = String.valueOf(this.amnt);
/* 2835 */       break;
/*      */     case 60:
/* 2837 */       strFieldValue = String.valueOf(this.sumPrem);
/* 2838 */       break;
/*      */     case 61:
/* 2840 */       strFieldValue = String.valueOf(this.dif);
/* 2841 */       break;
/*      */     case 62:
/* 2843 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpaytoDate()));
/* 2844 */       break;
/*      */     case 63:
/* 2846 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getfirstPayDate()));
/* 2847 */       break;
/*      */     case 64:
/* 2849 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getcValiDate()));
/* 2850 */       break;
/*      */     case 65:
/* 2852 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpSignDate()));
/* 2853 */       break;
/*      */     case 66:
/* 2855 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpValiDate()));
/* 2856 */       break;
/*      */     case 67:
/* 2858 */       strFieldValue = StrTool.GBKToUnicode(this.inputOperator);
/* 2859 */       break;
/*      */     case 68:
/* 2861 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getinputDate()));
/* 2862 */       break;
/*      */     case 69:
/* 2864 */       strFieldValue = StrTool.GBKToUnicode(this.inputTime);
/* 2865 */       break;
/*      */     case 70:
/* 2867 */       strFieldValue = StrTool.GBKToUnicode(this.approveFlag);
/* 2868 */       break;
/*      */     case 71:
/* 2870 */       strFieldValue = StrTool.GBKToUnicode(this.approveCode);
/* 2871 */       break;
/*      */     case 72:
/* 2873 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getapproveDate()));
/* 2874 */       break;
/*      */     case 73:
/* 2876 */       strFieldValue = StrTool.GBKToUnicode(this.approveTime);
/* 2877 */       break;
/*      */     case 74:
/* 2879 */       strFieldValue = StrTool.GBKToUnicode(this.uWFlag);
/* 2880 */       break;
/*      */     case 75:
/* 2882 */       strFieldValue = StrTool.GBKToUnicode(this.uWOperator);
/* 2883 */       break;
/*      */     case 76:
/* 2885 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
/* 2886 */       break;
/*      */     case 77:
/* 2888 */       strFieldValue = StrTool.GBKToUnicode(this.uWTime);
/* 2889 */       break;
/*      */     case 78:
/* 2891 */       strFieldValue = StrTool.GBKToUnicode(this.appFlag);
/* 2892 */       break;
/*      */     case 79:
/* 2894 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpolApplyDate()));
/* 2895 */       break;
/*      */     case 80:
/* 2897 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getgetPolDate()));
/* 2898 */       break;
/*      */     case 81:
/* 2900 */       strFieldValue = StrTool.GBKToUnicode(this.getPolTime);
/* 2901 */       break;
/*      */     case 82:
/* 2903 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getcustomGetPolDate()));
/* 2904 */       break;
/*      */     case 83:
/* 2906 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 2907 */       break;
/*      */     case 84:
/* 2909 */       strFieldValue = StrTool.GBKToUnicode(this.saleChnlDetail);
/* 2910 */       break;
/*      */     case 85:
/* 2912 */       strFieldValue = StrTool.GBKToUnicode(this.proposalType);
/* 2913 */       break;
/*      */     case 86:
/* 2915 */       strFieldValue = StrTool.GBKToUnicode(this.editstate);
/* 2916 */       break;
/*      */     case 87:
/* 2918 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getcInValiDate()));
/* 2919 */       break;
/*      */     case 88:
/* 2921 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 2922 */       break;
/*      */     case 89:
/* 2924 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/* 2925 */       break;
/*      */     case 90:
/* 2927 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 2928 */       break;
/*      */     case 91:
/* 2930 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/* 2931 */       break;
/*      */     case 92:
/* 2933 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 2934 */       break;
/*      */     default:
/* 2936 */       strFieldValue = "";
/*      */     }
/* 2938 */     if (strFieldValue.equals("")) {
/* 2939 */       strFieldValue = "null";
/*      */     }
/* 2941 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 2947 */     if (StrTool.cTrim(FCode).equals("")) {
/* 2948 */       return false;
/*      */     }
/* 2950 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 2952 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2954 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/* 2957 */         this.EdorNo = null;
/*      */     }
/* 2959 */     if (FCode.equals("serialNo"))
/*      */     {
/* 2961 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2963 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/* 2966 */         this.serialNo = null;
/*      */     }
/* 2968 */     if (FCode.equals("grpContNo"))
/*      */     {
/* 2970 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2972 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 2975 */         this.grpContNo = null;
/*      */     }
/* 2977 */     if (FCode.equals("contNo"))
/*      */     {
/* 2979 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2981 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 2984 */         this.contNo = null;
/*      */     }
/* 2986 */     if (FCode.equals("proposalContNo"))
/*      */     {
/* 2988 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2990 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 2993 */         this.proposalContNo = null;
/*      */     }
/* 2995 */     if (FCode.equals("prtNo"))
/*      */     {
/* 2997 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2999 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/* 3002 */         this.prtNo = null;
/*      */     }
/* 3004 */     if (FCode.equals("mainPolNo"))
/*      */     {
/* 3006 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3008 */         this.mainPolNo = FValue.trim();
/*      */       }
/*      */       else
/* 3011 */         this.mainPolNo = null;
/*      */     }
/* 3013 */     if (FCode.equals("contType"))
/*      */     {
/* 3015 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3017 */         this.contType = FValue.trim();
/*      */       }
/*      */       else
/* 3020 */         this.contType = null;
/*      */     }
/* 3022 */     if (FCode.equals("familyType"))
/*      */     {
/* 3024 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3026 */         this.familyType = FValue.trim();
/*      */       }
/*      */       else
/* 3029 */         this.familyType = null;
/*      */     }
/* 3031 */     if (FCode.equals("familyID"))
/*      */     {
/* 3033 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3035 */         this.familyID = FValue.trim();
/*      */       }
/*      */       else
/* 3038 */         this.familyID = null;
/*      */     }
/* 3040 */     if (FCode.equals("polType"))
/*      */     {
/* 3042 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3044 */         this.polType = FValue.trim();
/*      */       }
/*      */       else
/* 3047 */         this.polType = null;
/*      */     }
/* 3049 */     if (FCode.equals("sugNo"))
/*      */     {
/* 3051 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3053 */         this.sugNo = FValue.trim();
/*      */       }
/*      */       else
/* 3056 */         this.sugNo = null;
/*      */     }
/* 3058 */     if (FCode.equals("cardFlag"))
/*      */     {
/* 3060 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3062 */         this.cardFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3065 */         this.cardFlag = null;
/*      */     }
/* 3067 */     if (FCode.equals("manageCom"))
/*      */     {
/* 3069 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3071 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 3074 */         this.manageCom = null;
/*      */     }
/* 3076 */     if (FCode.equals("executeCom"))
/*      */     {
/* 3078 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3080 */         this.executeCom = FValue.trim();
/*      */       }
/*      */       else
/* 3083 */         this.executeCom = null;
/*      */     }
/* 3085 */     if (FCode.equals("agentCom"))
/*      */     {
/* 3087 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3089 */         this.agentCom = FValue.trim();
/*      */       }
/*      */       else
/* 3092 */         this.agentCom = null;
/*      */     }
/* 3094 */     if (FCode.equals("agentCode"))
/*      */     {
/* 3096 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3098 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/* 3101 */         this.agentCode = null;
/*      */     }
/* 3103 */     if (FCode.equals("agentGroup"))
/*      */     {
/* 3105 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3107 */         this.agentGroup = FValue.trim();
/*      */       }
/*      */       else
/* 3110 */         this.agentGroup = null;
/*      */     }
/* 3112 */     if (FCode.equals("agentCode1"))
/*      */     {
/* 3114 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3116 */         this.agentCode1 = FValue.trim();
/*      */       }
/*      */       else
/* 3119 */         this.agentCode1 = null;
/*      */     }
/* 3121 */     if (FCode.equals("agentGroup1"))
/*      */     {
/* 3123 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3125 */         this.agentGroup1 = FValue.trim();
/*      */       }
/*      */       else
/* 3128 */         this.agentGroup1 = null;
/*      */     }
/* 3130 */     if (FCode.equals("agentType"))
/*      */     {
/* 3132 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3134 */         this.agentType = FValue.trim();
/*      */       }
/*      */       else
/* 3137 */         this.agentType = null;
/*      */     }
/* 3139 */     if (FCode.equals("saleChnl"))
/*      */     {
/* 3141 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3143 */         this.saleChnl = FValue.trim();
/*      */       }
/*      */       else
/* 3146 */         this.saleChnl = null;
/*      */     }
/* 3148 */     if (FCode.equals("handler"))
/*      */     {
/* 3150 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3152 */         this.handler = FValue.trim();
/*      */       }
/*      */       else
/* 3155 */         this.handler = null;
/*      */     }
/* 3157 */     if (FCode.equals("password"))
/*      */     {
/* 3159 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3161 */         this.password = FValue.trim();
/*      */       }
/*      */       else
/* 3164 */         this.password = null;
/*      */     }
/* 3166 */     if (FCode.equals("appntNo"))
/*      */     {
/* 3168 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3170 */         this.appntNo = FValue.trim();
/*      */       }
/*      */       else
/* 3173 */         this.appntNo = null;
/*      */     }
/* 3175 */     if (FCode.equals("appntId"))
/*      */     {
/* 3177 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3179 */         this.appntId = FValue.trim();
/*      */       }
/*      */       else
/* 3182 */         this.appntId = null;
/*      */     }
/* 3184 */     if (FCode.equals("appntName"))
/*      */     {
/* 3186 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3188 */         this.appntName = FValue.trim();
/*      */       }
/*      */       else
/* 3191 */         this.appntName = null;
/*      */     }
/* 3193 */     if (FCode.equals("appntSex"))
/*      */     {
/* 3195 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3197 */         this.appntSex = FValue.trim();
/*      */       }
/*      */       else
/* 3200 */         this.appntSex = null;
/*      */     }
/* 3202 */     if (FCode.equals("appntBirthday"))
/*      */     {
/* 3204 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3206 */         this.appntBirthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3209 */         this.appntBirthday = null;
/*      */     }
/* 3211 */     if (FCode.equals("appntIDType"))
/*      */     {
/* 3213 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3215 */         this.appntIDType = FValue.trim();
/*      */       }
/*      */       else
/* 3218 */         this.appntIDType = null;
/*      */     }
/* 3220 */     if (FCode.equals("appntIDNo"))
/*      */     {
/* 3222 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3224 */         this.appntIDNo = FValue.trim();
/*      */       }
/*      */       else
/* 3227 */         this.appntIDNo = null;
/*      */     }
/* 3229 */     if (FCode.equals("insuredNo"))
/*      */     {
/* 3231 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3233 */         this.insuredNo = FValue.trim();
/*      */       }
/*      */       else
/* 3236 */         this.insuredNo = null;
/*      */     }
/* 3238 */     if (FCode.equals("insuredId"))
/*      */     {
/* 3240 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3242 */         this.insuredId = FValue.trim();
/*      */       }
/*      */       else
/* 3245 */         this.insuredId = null;
/*      */     }
/* 3247 */     if (FCode.equals("insuredName"))
/*      */     {
/* 3249 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3251 */         this.insuredName = FValue.trim();
/*      */       }
/*      */       else
/* 3254 */         this.insuredName = null;
/*      */     }
/* 3256 */     if (FCode.equals("insuredSex"))
/*      */     {
/* 3258 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3260 */         this.insuredSex = FValue.trim();
/*      */       }
/*      */       else
/* 3263 */         this.insuredSex = null;
/*      */     }
/* 3265 */     if (FCode.equals("insuredBirthday"))
/*      */     {
/* 3267 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3269 */         this.insuredBirthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3272 */         this.insuredBirthday = null;
/*      */     }
/* 3274 */     if (FCode.equals("insuredIDType"))
/*      */     {
/* 3276 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3278 */         this.insuredIDType = FValue.trim();
/*      */       }
/*      */       else
/* 3281 */         this.insuredIDType = null;
/*      */     }
/* 3283 */     if (FCode.equals("insuredIDNo"))
/*      */     {
/* 3285 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3287 */         this.insuredIDNo = FValue.trim();
/*      */       }
/*      */       else
/* 3290 */         this.insuredIDNo = null;
/*      */     }
/* 3292 */     if (FCode.equals("payIntv"))
/*      */     {
/* 3294 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3296 */         Integer tInteger = new Integer(FValue);
/* 3297 */         int i = tInteger.intValue();
/* 3298 */         this.payIntv = i;
/*      */       }
/*      */     }
/* 3301 */     if (FCode.equals("payMode"))
/*      */     {
/* 3303 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3305 */         this.payMode = FValue.trim();
/*      */       }
/*      */       else
/* 3308 */         this.payMode = null;
/*      */     }
/* 3310 */     if (FCode.equals("payLocation"))
/*      */     {
/* 3312 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3314 */         this.payLocation = FValue.trim();
/*      */       }
/*      */       else
/* 3317 */         this.payLocation = null;
/*      */     }
/* 3319 */     if (FCode.equals("disputedFlag"))
/*      */     {
/* 3321 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3323 */         this.disputedFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3326 */         this.disputedFlag = null;
/*      */     }
/* 3328 */     if (FCode.equals("outPayFlag"))
/*      */     {
/* 3330 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3332 */         this.outPayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3335 */         this.outPayFlag = null;
/*      */     }
/* 3337 */     if (FCode.equals("getPolMode"))
/*      */     {
/* 3339 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3341 */         this.getPolMode = FValue.trim();
/*      */       }
/*      */       else
/* 3344 */         this.getPolMode = null;
/*      */     }
/* 3346 */     if (FCode.equals("signCom"))
/*      */     {
/* 3348 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3350 */         this.signCom = FValue.trim();
/*      */       }
/*      */       else
/* 3353 */         this.signCom = null;
/*      */     }
/* 3355 */     if (FCode.equals("signDate"))
/*      */     {
/* 3357 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3359 */         this.signDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3362 */         this.signDate = null;
/*      */     }
/* 3364 */     if (FCode.equals("signTime"))
/*      */     {
/* 3366 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3368 */         this.signTime = FValue.trim();
/*      */       }
/*      */       else
/* 3371 */         this.signTime = null;
/*      */     }
/* 3373 */     if (FCode.equals("consignNo"))
/*      */     {
/* 3375 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3377 */         this.consignNo = FValue.trim();
/*      */       }
/*      */       else
/* 3380 */         this.consignNo = null;
/*      */     }
/* 3382 */     if (FCode.equals("bankCode"))
/*      */     {
/* 3384 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3386 */         this.bankCode = FValue.trim();
/*      */       }
/*      */       else
/* 3389 */         this.bankCode = null;
/*      */     }
/* 3391 */     if (FCode.equals("bankAccNo"))
/*      */     {
/* 3393 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3395 */         this.bankAccNo = FValue.trim();
/*      */       }
/*      */       else
/* 3398 */         this.bankAccNo = null;
/*      */     }
/* 3400 */     if (FCode.equals("accName"))
/*      */     {
/* 3402 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3404 */         this.accName = FValue.trim();
/*      */       }
/*      */       else
/* 3407 */         this.accName = null;
/*      */     }
/* 3409 */     if (FCode.equals("printCount"))
/*      */     {
/* 3411 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3413 */         Integer tInteger = new Integer(FValue);
/* 3414 */         int i = tInteger.intValue();
/* 3415 */         this.printCount = i;
/*      */       }
/*      */     }
/* 3418 */     if (FCode.equals("lostTimes"))
/*      */     {
/* 3420 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3422 */         Integer tInteger = new Integer(FValue);
/* 3423 */         int i = tInteger.intValue();
/* 3424 */         this.lostTimes = i;
/*      */       }
/*      */     }
/* 3427 */     if (FCode.equals("lang"))
/*      */     {
/* 3429 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3431 */         this.lang = FValue.trim();
/*      */       }
/*      */       else
/* 3434 */         this.lang = null;
/*      */     }
/* 3436 */     if (FCode.equals("currency"))
/*      */     {
/* 3438 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3440 */         this.currency = FValue.trim();
/*      */       }
/*      */       else
/* 3443 */         this.currency = null;
/*      */     }
/* 3445 */     if (FCode.equals("remark"))
/*      */     {
/* 3447 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3449 */         this.remark = FValue.trim();
/*      */       }
/*      */       else
/* 3452 */         this.remark = null;
/*      */     }
/* 3454 */     if (FCode.equals("peoples"))
/*      */     {
/* 3456 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3458 */         Integer tInteger = new Integer(FValue);
/* 3459 */         int i = tInteger.intValue();
/* 3460 */         this.peoples = i;
/*      */       }
/*      */     }
/* 3463 */     if (FCode.equals("mult"))
/*      */     {
/* 3465 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3467 */         Double tDouble = new Double(FValue);
/* 3468 */         double d = tDouble.doubleValue();
/* 3469 */         this.mult = d;
/*      */       }
/*      */     }
/* 3472 */     if (FCode.equals("prem"))
/*      */     {
/* 3474 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3476 */         Double tDouble = new Double(FValue);
/* 3477 */         double d = tDouble.doubleValue();
/* 3478 */         this.prem = d;
/*      */       }
/*      */     }
/* 3481 */     if (FCode.equals("amnt"))
/*      */     {
/* 3483 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3485 */         Double tDouble = new Double(FValue);
/* 3486 */         double d = tDouble.doubleValue();
/* 3487 */         this.amnt = d;
/*      */       }
/*      */     }
/* 3490 */     if (FCode.equals("sumPrem"))
/*      */     {
/* 3492 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3494 */         Double tDouble = new Double(FValue);
/* 3495 */         double d = tDouble.doubleValue();
/* 3496 */         this.sumPrem = d;
/*      */       }
/*      */     }
/* 3499 */     if (FCode.equals("dif"))
/*      */     {
/* 3501 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3503 */         Double tDouble = new Double(FValue);
/* 3504 */         double d = tDouble.doubleValue();
/* 3505 */         this.dif = d;
/*      */       }
/*      */     }
/* 3508 */     if (FCode.equals("paytoDate"))
/*      */     {
/* 3510 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3512 */         this.paytoDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3515 */         this.paytoDate = null;
/*      */     }
/* 3517 */     if (FCode.equals("firstPayDate"))
/*      */     {
/* 3519 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3521 */         this.firstPayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3524 */         this.firstPayDate = null;
/*      */     }
/* 3526 */     if (FCode.equals("cValiDate"))
/*      */     {
/* 3528 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3530 */         this.cValiDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3533 */         this.cValiDate = null;
/*      */     }
/* 3535 */     if (FCode.equals("pSignDate"))
/*      */     {
/* 3537 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3539 */         this.pSignDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3542 */         this.pSignDate = null;
/*      */     }
/* 3544 */     if (FCode.equals("pValiDate"))
/*      */     {
/* 3546 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3548 */         this.pValiDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3551 */         this.pValiDate = null;
/*      */     }
/* 3553 */     if (FCode.equals("inputOperator"))
/*      */     {
/* 3555 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3557 */         this.inputOperator = FValue.trim();
/*      */       }
/*      */       else
/* 3560 */         this.inputOperator = null;
/*      */     }
/* 3562 */     if (FCode.equals("inputDate"))
/*      */     {
/* 3564 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3566 */         this.inputDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3569 */         this.inputDate = null;
/*      */     }
/* 3571 */     if (FCode.equals("inputTime"))
/*      */     {
/* 3573 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3575 */         this.inputTime = FValue.trim();
/*      */       }
/*      */       else
/* 3578 */         this.inputTime = null;
/*      */     }
/* 3580 */     if (FCode.equals("approveFlag"))
/*      */     {
/* 3582 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3584 */         this.approveFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3587 */         this.approveFlag = null;
/*      */     }
/* 3589 */     if (FCode.equals("approveCode"))
/*      */     {
/* 3591 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3593 */         this.approveCode = FValue.trim();
/*      */       }
/*      */       else
/* 3596 */         this.approveCode = null;
/*      */     }
/* 3598 */     if (FCode.equals("approveDate"))
/*      */     {
/* 3600 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3602 */         this.approveDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3605 */         this.approveDate = null;
/*      */     }
/* 3607 */     if (FCode.equals("approveTime"))
/*      */     {
/* 3609 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3611 */         this.approveTime = FValue.trim();
/*      */       }
/*      */       else
/* 3614 */         this.approveTime = null;
/*      */     }
/* 3616 */     if (FCode.equals("uWFlag"))
/*      */     {
/* 3618 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3620 */         this.uWFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3623 */         this.uWFlag = null;
/*      */     }
/* 3625 */     if (FCode.equals("uWOperator"))
/*      */     {
/* 3627 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3629 */         this.uWOperator = FValue.trim();
/*      */       }
/*      */       else
/* 3632 */         this.uWOperator = null;
/*      */     }
/* 3634 */     if (FCode.equals("uWDate"))
/*      */     {
/* 3636 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3638 */         this.uWDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3641 */         this.uWDate = null;
/*      */     }
/* 3643 */     if (FCode.equals("uWTime"))
/*      */     {
/* 3645 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3647 */         this.uWTime = FValue.trim();
/*      */       }
/*      */       else
/* 3650 */         this.uWTime = null;
/*      */     }
/* 3652 */     if (FCode.equals("appFlag"))
/*      */     {
/* 3654 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3656 */         this.appFlag = FValue.trim();
/*      */       }
/*      */       else
/* 3659 */         this.appFlag = null;
/*      */     }
/* 3661 */     if (FCode.equals("polApplyDate"))
/*      */     {
/* 3663 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3665 */         this.polApplyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3668 */         this.polApplyDate = null;
/*      */     }
/* 3670 */     if (FCode.equals("getPolDate"))
/*      */     {
/* 3672 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3674 */         this.getPolDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3677 */         this.getPolDate = null;
/*      */     }
/* 3679 */     if (FCode.equals("getPolTime"))
/*      */     {
/* 3681 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3683 */         this.getPolTime = FValue.trim();
/*      */       }
/*      */       else
/* 3686 */         this.getPolTime = null;
/*      */     }
/* 3688 */     if (FCode.equals("customGetPolDate"))
/*      */     {
/* 3690 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3692 */         this.customGetPolDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3695 */         this.customGetPolDate = null;
/*      */     }
/* 3697 */     if (FCode.equals("state"))
/*      */     {
/* 3699 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3701 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 3704 */         this.state = null;
/*      */     }
/* 3706 */     if (FCode.equals("saleChnlDetail"))
/*      */     {
/* 3708 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3710 */         this.saleChnlDetail = FValue.trim();
/*      */       }
/*      */       else
/* 3713 */         this.saleChnlDetail = null;
/*      */     }
/* 3715 */     if (FCode.equals("proposalType"))
/*      */     {
/* 3717 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3719 */         this.proposalType = FValue.trim();
/*      */       }
/*      */       else
/* 3722 */         this.proposalType = null;
/*      */     }
/* 3724 */     if (FCode.equals("editstate"))
/*      */     {
/* 3726 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3728 */         this.editstate = FValue.trim();
/*      */       }
/*      */       else
/* 3731 */         this.editstate = null;
/*      */     }
/* 3733 */     if (FCode.equals("cInValiDate"))
/*      */     {
/* 3735 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3737 */         this.cInValiDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3740 */         this.cInValiDate = null;
/*      */     }
/* 3742 */     if (FCode.equals("operator"))
/*      */     {
/* 3744 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3746 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 3749 */         this.operator = null;
/*      */     }
/* 3751 */     if (FCode.equals("makeDate"))
/*      */     {
/* 3753 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3755 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3758 */         this.makeDate = null;
/*      */     }
/* 3760 */     if (FCode.equals("makeTime"))
/*      */     {
/* 3762 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3764 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 3767 */         this.makeTime = null;
/*      */     }
/* 3769 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 3771 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3773 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 3776 */         this.modifyDate = null;
/*      */     }
/* 3778 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 3780 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 3782 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 3785 */         this.modifyTime = null;
/*      */     }
/* 3787 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 3792 */     if (this == otherObject) return true;
/* 3793 */     if (otherObject == null) return false;
/* 3794 */     if (getClass() != otherObject.getClass()) return false;
/* 3795 */     LNPContBSchema other = (LNPContBSchema)otherObject;
/* 3796 */     return 
/* 3797 */       (this.EdorNo.equals(other.getEdorNo())) && 
/* 3798 */       (this.serialNo.equals(other.getserialNo())) && 
/* 3799 */       (this.grpContNo.equals(other.getgrpContNo())) && 
/* 3800 */       (this.contNo.equals(other.getcontNo())) && 
/* 3801 */       (this.proposalContNo.equals(other.getproposalContNo())) && 
/* 3802 */       (this.prtNo.equals(other.getprtNo())) && 
/* 3803 */       (this.mainPolNo.equals(other.getmainPolNo())) && 
/* 3804 */       (this.contType.equals(other.getcontType())) && 
/* 3805 */       (this.familyType.equals(other.getfamilyType())) && 
/* 3806 */       (this.familyID.equals(other.getfamilyID())) && 
/* 3807 */       (this.polType.equals(other.getpolType())) && 
/* 3808 */       (this.sugNo.equals(other.getsugNo())) && 
/* 3809 */       (this.cardFlag.equals(other.getcardFlag())) && 
/* 3810 */       (this.manageCom.equals(other.getmanageCom())) && 
/* 3811 */       (this.executeCom.equals(other.getexecuteCom())) && 
/* 3812 */       (this.agentCom.equals(other.getagentCom())) && 
/* 3813 */       (this.agentCode.equals(other.getagentCode())) && 
/* 3814 */       (this.agentGroup.equals(other.getagentGroup())) && 
/* 3815 */       (this.agentCode1.equals(other.getagentCode1())) && 
/* 3816 */       (this.agentGroup1.equals(other.getagentGroup1())) && 
/* 3817 */       (this.agentType.equals(other.getagentType())) && 
/* 3818 */       (this.saleChnl.equals(other.getsaleChnl())) && 
/* 3819 */       (this.handler.equals(other.gethandler())) && 
/* 3820 */       (this.password.equals(other.getpassword())) && 
/* 3821 */       (this.appntNo.equals(other.getappntNo())) && 
/* 3822 */       (this.appntId.equals(other.getappntId())) && 
/* 3823 */       (this.appntName.equals(other.getappntName())) && 
/* 3824 */       (this.appntSex.equals(other.getappntSex())) && 
/* 3825 */       (this.fDate.getString(this.appntBirthday).equals(other.getappntBirthday())) && 
/* 3826 */       (this.appntIDType.equals(other.getappntIDType())) && 
/* 3827 */       (this.appntIDNo.equals(other.getappntIDNo())) && 
/* 3828 */       (this.insuredNo.equals(other.getinsuredNo())) && 
/* 3829 */       (this.insuredId.equals(other.getinsuredId())) && 
/* 3830 */       (this.insuredName.equals(other.getinsuredName())) && 
/* 3831 */       (this.insuredSex.equals(other.getinsuredSex())) && 
/* 3832 */       (this.fDate.getString(this.insuredBirthday).equals(other.getinsuredBirthday())) && 
/* 3833 */       (this.insuredIDType.equals(other.getinsuredIDType())) && 
/* 3834 */       (this.insuredIDNo.equals(other.getinsuredIDNo())) && 
/* 3835 */       (this.payIntv == other.getpayIntv()) && 
/* 3836 */       (this.payMode.equals(other.getpayMode())) && 
/* 3837 */       (this.payLocation.equals(other.getpayLocation())) && 
/* 3838 */       (this.disputedFlag.equals(other.getdisputedFlag())) && 
/* 3839 */       (this.outPayFlag.equals(other.getoutPayFlag())) && 
/* 3840 */       (this.getPolMode.equals(other.getgetPolMode())) && 
/* 3841 */       (this.signCom.equals(other.getsignCom())) && 
/* 3842 */       (this.fDate.getString(this.signDate).equals(other.getsignDate())) && 
/* 3843 */       (this.signTime.equals(other.getsignTime())) && 
/* 3844 */       (this.consignNo.equals(other.getconsignNo())) && 
/* 3845 */       (this.bankCode.equals(other.getbankCode())) && 
/* 3846 */       (this.bankAccNo.equals(other.getbankAccNo())) && 
/* 3847 */       (this.accName.equals(other.getaccName())) && 
/* 3848 */       (this.printCount == other.getprintCount()) && 
/* 3849 */       (this.lostTimes == other.getlostTimes()) && 
/* 3850 */       (this.lang.equals(other.getlang())) && 
/* 3851 */       (this.currency.equals(other.getcurrency())) && 
/* 3852 */       (this.remark.equals(other.getremark())) && 
/* 3853 */       (this.peoples == other.getpeoples()) && 
/* 3854 */       (this.mult == other.getmult()) && 
/* 3855 */       (this.prem == other.getprem()) && 
/* 3856 */       (this.amnt == other.getamnt()) && 
/* 3857 */       (this.sumPrem == other.getsumPrem()) && 
/* 3858 */       (this.dif == other.getdif()) && 
/* 3859 */       (this.fDate.getString(this.paytoDate).equals(other.getpaytoDate())) && 
/* 3860 */       (this.fDate.getString(this.firstPayDate).equals(other.getfirstPayDate())) && 
/* 3861 */       (this.fDate.getString(this.cValiDate).equals(other.getcValiDate())) && 
/* 3862 */       (this.fDate.getString(this.pSignDate).equals(other.getpSignDate())) && 
/* 3863 */       (this.fDate.getString(this.pValiDate).equals(other.getpValiDate())) && 
/* 3864 */       (this.inputOperator.equals(other.getinputOperator())) && 
/* 3865 */       (this.fDate.getString(this.inputDate).equals(other.getinputDate())) && 
/* 3866 */       (this.inputTime.equals(other.getinputTime())) && 
/* 3867 */       (this.approveFlag.equals(other.getapproveFlag())) && 
/* 3868 */       (this.approveCode.equals(other.getapproveCode())) && 
/* 3869 */       (this.fDate.getString(this.approveDate).equals(other.getapproveDate())) && 
/* 3870 */       (this.approveTime.equals(other.getapproveTime())) && 
/* 3871 */       (this.uWFlag.equals(other.getuWFlag())) && 
/* 3872 */       (this.uWOperator.equals(other.getuWOperator())) && 
/* 3873 */       (this.fDate.getString(this.uWDate).equals(other.getuWDate())) && 
/* 3874 */       (this.uWTime.equals(other.getuWTime())) && 
/* 3875 */       (this.appFlag.equals(other.getappFlag())) && 
/* 3876 */       (this.fDate.getString(this.polApplyDate).equals(other.getpolApplyDate())) && 
/* 3877 */       (this.fDate.getString(this.getPolDate).equals(other.getgetPolDate())) && 
/* 3878 */       (this.getPolTime.equals(other.getgetPolTime())) && 
/* 3879 */       (this.fDate.getString(this.customGetPolDate).equals(other.getcustomGetPolDate())) && 
/* 3880 */       (this.state.equals(other.getstate())) && 
/* 3881 */       (this.saleChnlDetail.equals(other.getsaleChnlDetail())) && 
/* 3882 */       (this.proposalType.equals(other.getproposalType())) && 
/* 3883 */       (this.editstate.equals(other.geteditstate())) && 
/* 3884 */       (this.fDate.getString(this.cInValiDate).equals(other.getcInValiDate())) && 
/* 3885 */       (this.operator.equals(other.getoperator())) && 
/* 3886 */       (this.fDate.getString(this.makeDate).equals(other.getmakeDate())) && 
/* 3887 */       (this.makeTime.equals(other.getmakeTime())) && 
/* 3888 */       (this.fDate.getString(this.modifyDate).equals(other.getmodifyDate())) && 
/* 3889 */       (this.modifyTime.equals(other.getmodifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 3895 */     return 93;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 3901 */     if (strFieldName.equals("EdorNo")) {
/* 3902 */       return 0;
/*      */     }
/* 3904 */     if (strFieldName.equals("serialNo")) {
/* 3905 */       return 1;
/*      */     }
/* 3907 */     if (strFieldName.equals("grpContNo")) {
/* 3908 */       return 2;
/*      */     }
/* 3910 */     if (strFieldName.equals("contNo")) {
/* 3911 */       return 3;
/*      */     }
/* 3913 */     if (strFieldName.equals("proposalContNo")) {
/* 3914 */       return 4;
/*      */     }
/* 3916 */     if (strFieldName.equals("prtNo")) {
/* 3917 */       return 5;
/*      */     }
/* 3919 */     if (strFieldName.equals("mainPolNo")) {
/* 3920 */       return 6;
/*      */     }
/* 3922 */     if (strFieldName.equals("contType")) {
/* 3923 */       return 7;
/*      */     }
/* 3925 */     if (strFieldName.equals("familyType")) {
/* 3926 */       return 8;
/*      */     }
/* 3928 */     if (strFieldName.equals("familyID")) {
/* 3929 */       return 9;
/*      */     }
/* 3931 */     if (strFieldName.equals("polType")) {
/* 3932 */       return 10;
/*      */     }
/* 3934 */     if (strFieldName.equals("sugNo")) {
/* 3935 */       return 11;
/*      */     }
/* 3937 */     if (strFieldName.equals("cardFlag")) {
/* 3938 */       return 12;
/*      */     }
/* 3940 */     if (strFieldName.equals("manageCom")) {
/* 3941 */       return 13;
/*      */     }
/* 3943 */     if (strFieldName.equals("executeCom")) {
/* 3944 */       return 14;
/*      */     }
/* 3946 */     if (strFieldName.equals("agentCom")) {
/* 3947 */       return 15;
/*      */     }
/* 3949 */     if (strFieldName.equals("agentCode")) {
/* 3950 */       return 16;
/*      */     }
/* 3952 */     if (strFieldName.equals("agentGroup")) {
/* 3953 */       return 17;
/*      */     }
/* 3955 */     if (strFieldName.equals("agentCode1")) {
/* 3956 */       return 18;
/*      */     }
/* 3958 */     if (strFieldName.equals("agentGroup1")) {
/* 3959 */       return 19;
/*      */     }
/* 3961 */     if (strFieldName.equals("agentType")) {
/* 3962 */       return 20;
/*      */     }
/* 3964 */     if (strFieldName.equals("saleChnl")) {
/* 3965 */       return 21;
/*      */     }
/* 3967 */     if (strFieldName.equals("handler")) {
/* 3968 */       return 22;
/*      */     }
/* 3970 */     if (strFieldName.equals("password")) {
/* 3971 */       return 23;
/*      */     }
/* 3973 */     if (strFieldName.equals("appntNo")) {
/* 3974 */       return 24;
/*      */     }
/* 3976 */     if (strFieldName.equals("appntId")) {
/* 3977 */       return 25;
/*      */     }
/* 3979 */     if (strFieldName.equals("appntName")) {
/* 3980 */       return 26;
/*      */     }
/* 3982 */     if (strFieldName.equals("appntSex")) {
/* 3983 */       return 27;
/*      */     }
/* 3985 */     if (strFieldName.equals("appntBirthday")) {
/* 3986 */       return 28;
/*      */     }
/* 3988 */     if (strFieldName.equals("appntIDType")) {
/* 3989 */       return 29;
/*      */     }
/* 3991 */     if (strFieldName.equals("appntIDNo")) {
/* 3992 */       return 30;
/*      */     }
/* 3994 */     if (strFieldName.equals("insuredNo")) {
/* 3995 */       return 31;
/*      */     }
/* 3997 */     if (strFieldName.equals("insuredId")) {
/* 3998 */       return 32;
/*      */     }
/* 4000 */     if (strFieldName.equals("insuredName")) {
/* 4001 */       return 33;
/*      */     }
/* 4003 */     if (strFieldName.equals("insuredSex")) {
/* 4004 */       return 34;
/*      */     }
/* 4006 */     if (strFieldName.equals("insuredBirthday")) {
/* 4007 */       return 35;
/*      */     }
/* 4009 */     if (strFieldName.equals("insuredIDType")) {
/* 4010 */       return 36;
/*      */     }
/* 4012 */     if (strFieldName.equals("insuredIDNo")) {
/* 4013 */       return 37;
/*      */     }
/* 4015 */     if (strFieldName.equals("payIntv")) {
/* 4016 */       return 38;
/*      */     }
/* 4018 */     if (strFieldName.equals("payMode")) {
/* 4019 */       return 39;
/*      */     }
/* 4021 */     if (strFieldName.equals("payLocation")) {
/* 4022 */       return 40;
/*      */     }
/* 4024 */     if (strFieldName.equals("disputedFlag")) {
/* 4025 */       return 41;
/*      */     }
/* 4027 */     if (strFieldName.equals("outPayFlag")) {
/* 4028 */       return 42;
/*      */     }
/* 4030 */     if (strFieldName.equals("getPolMode")) {
/* 4031 */       return 43;
/*      */     }
/* 4033 */     if (strFieldName.equals("signCom")) {
/* 4034 */       return 44;
/*      */     }
/* 4036 */     if (strFieldName.equals("signDate")) {
/* 4037 */       return 45;
/*      */     }
/* 4039 */     if (strFieldName.equals("signTime")) {
/* 4040 */       return 46;
/*      */     }
/* 4042 */     if (strFieldName.equals("consignNo")) {
/* 4043 */       return 47;
/*      */     }
/* 4045 */     if (strFieldName.equals("bankCode")) {
/* 4046 */       return 48;
/*      */     }
/* 4048 */     if (strFieldName.equals("bankAccNo")) {
/* 4049 */       return 49;
/*      */     }
/* 4051 */     if (strFieldName.equals("accName")) {
/* 4052 */       return 50;
/*      */     }
/* 4054 */     if (strFieldName.equals("printCount")) {
/* 4055 */       return 51;
/*      */     }
/* 4057 */     if (strFieldName.equals("lostTimes")) {
/* 4058 */       return 52;
/*      */     }
/* 4060 */     if (strFieldName.equals("lang")) {
/* 4061 */       return 53;
/*      */     }
/* 4063 */     if (strFieldName.equals("currency")) {
/* 4064 */       return 54;
/*      */     }
/* 4066 */     if (strFieldName.equals("remark")) {
/* 4067 */       return 55;
/*      */     }
/* 4069 */     if (strFieldName.equals("peoples")) {
/* 4070 */       return 56;
/*      */     }
/* 4072 */     if (strFieldName.equals("mult")) {
/* 4073 */       return 57;
/*      */     }
/* 4075 */     if (strFieldName.equals("prem")) {
/* 4076 */       return 58;
/*      */     }
/* 4078 */     if (strFieldName.equals("amnt")) {
/* 4079 */       return 59;
/*      */     }
/* 4081 */     if (strFieldName.equals("sumPrem")) {
/* 4082 */       return 60;
/*      */     }
/* 4084 */     if (strFieldName.equals("dif")) {
/* 4085 */       return 61;
/*      */     }
/* 4087 */     if (strFieldName.equals("paytoDate")) {
/* 4088 */       return 62;
/*      */     }
/* 4090 */     if (strFieldName.equals("firstPayDate")) {
/* 4091 */       return 63;
/*      */     }
/* 4093 */     if (strFieldName.equals("cValiDate")) {
/* 4094 */       return 64;
/*      */     }
/* 4096 */     if (strFieldName.equals("pSignDate")) {
/* 4097 */       return 65;
/*      */     }
/* 4099 */     if (strFieldName.equals("pValiDate")) {
/* 4100 */       return 66;
/*      */     }
/* 4102 */     if (strFieldName.equals("inputOperator")) {
/* 4103 */       return 67;
/*      */     }
/* 4105 */     if (strFieldName.equals("inputDate")) {
/* 4106 */       return 68;
/*      */     }
/* 4108 */     if (strFieldName.equals("inputTime")) {
/* 4109 */       return 69;
/*      */     }
/* 4111 */     if (strFieldName.equals("approveFlag")) {
/* 4112 */       return 70;
/*      */     }
/* 4114 */     if (strFieldName.equals("approveCode")) {
/* 4115 */       return 71;
/*      */     }
/* 4117 */     if (strFieldName.equals("approveDate")) {
/* 4118 */       return 72;
/*      */     }
/* 4120 */     if (strFieldName.equals("approveTime")) {
/* 4121 */       return 73;
/*      */     }
/* 4123 */     if (strFieldName.equals("uWFlag")) {
/* 4124 */       return 74;
/*      */     }
/* 4126 */     if (strFieldName.equals("uWOperator")) {
/* 4127 */       return 75;
/*      */     }
/* 4129 */     if (strFieldName.equals("uWDate")) {
/* 4130 */       return 76;
/*      */     }
/* 4132 */     if (strFieldName.equals("uWTime")) {
/* 4133 */       return 77;
/*      */     }
/* 4135 */     if (strFieldName.equals("appFlag")) {
/* 4136 */       return 78;
/*      */     }
/* 4138 */     if (strFieldName.equals("polApplyDate")) {
/* 4139 */       return 79;
/*      */     }
/* 4141 */     if (strFieldName.equals("getPolDate")) {
/* 4142 */       return 80;
/*      */     }
/* 4144 */     if (strFieldName.equals("getPolTime")) {
/* 4145 */       return 81;
/*      */     }
/* 4147 */     if (strFieldName.equals("customGetPolDate")) {
/* 4148 */       return 82;
/*      */     }
/* 4150 */     if (strFieldName.equals("state")) {
/* 4151 */       return 83;
/*      */     }
/* 4153 */     if (strFieldName.equals("saleChnlDetail")) {
/* 4154 */       return 84;
/*      */     }
/* 4156 */     if (strFieldName.equals("proposalType")) {
/* 4157 */       return 85;
/*      */     }
/* 4159 */     if (strFieldName.equals("editstate")) {
/* 4160 */       return 86;
/*      */     }
/* 4162 */     if (strFieldName.equals("cInValiDate")) {
/* 4163 */       return 87;
/*      */     }
/* 4165 */     if (strFieldName.equals("operator")) {
/* 4166 */       return 88;
/*      */     }
/* 4168 */     if (strFieldName.equals("makeDate")) {
/* 4169 */       return 89;
/*      */     }
/* 4171 */     if (strFieldName.equals("makeTime")) {
/* 4172 */       return 90;
/*      */     }
/* 4174 */     if (strFieldName.equals("modifyDate")) {
/* 4175 */       return 91;
/*      */     }
/* 4177 */     if (strFieldName.equals("modifyTime")) {
/* 4178 */       return 92;
/*      */     }
/* 4180 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 4186 */     String strFieldName = "";
/* 4187 */     switch (nFieldIndex) {
/*      */     case 0:
/* 4189 */       strFieldName = "EdorNo";
/* 4190 */       break;
/*      */     case 1:
/* 4192 */       strFieldName = "serialNo";
/* 4193 */       break;
/*      */     case 2:
/* 4195 */       strFieldName = "grpContNo";
/* 4196 */       break;
/*      */     case 3:
/* 4198 */       strFieldName = "contNo";
/* 4199 */       break;
/*      */     case 4:
/* 4201 */       strFieldName = "proposalContNo";
/* 4202 */       break;
/*      */     case 5:
/* 4204 */       strFieldName = "prtNo";
/* 4205 */       break;
/*      */     case 6:
/* 4207 */       strFieldName = "mainPolNo";
/* 4208 */       break;
/*      */     case 7:
/* 4210 */       strFieldName = "contType";
/* 4211 */       break;
/*      */     case 8:
/* 4213 */       strFieldName = "familyType";
/* 4214 */       break;
/*      */     case 9:
/* 4216 */       strFieldName = "familyID";
/* 4217 */       break;
/*      */     case 10:
/* 4219 */       strFieldName = "polType";
/* 4220 */       break;
/*      */     case 11:
/* 4222 */       strFieldName = "sugNo";
/* 4223 */       break;
/*      */     case 12:
/* 4225 */       strFieldName = "cardFlag";
/* 4226 */       break;
/*      */     case 13:
/* 4228 */       strFieldName = "manageCom";
/* 4229 */       break;
/*      */     case 14:
/* 4231 */       strFieldName = "executeCom";
/* 4232 */       break;
/*      */     case 15:
/* 4234 */       strFieldName = "agentCom";
/* 4235 */       break;
/*      */     case 16:
/* 4237 */       strFieldName = "agentCode";
/* 4238 */       break;
/*      */     case 17:
/* 4240 */       strFieldName = "agentGroup";
/* 4241 */       break;
/*      */     case 18:
/* 4243 */       strFieldName = "agentCode1";
/* 4244 */       break;
/*      */     case 19:
/* 4246 */       strFieldName = "agentGroup1";
/* 4247 */       break;
/*      */     case 20:
/* 4249 */       strFieldName = "agentType";
/* 4250 */       break;
/*      */     case 21:
/* 4252 */       strFieldName = "saleChnl";
/* 4253 */       break;
/*      */     case 22:
/* 4255 */       strFieldName = "handler";
/* 4256 */       break;
/*      */     case 23:
/* 4258 */       strFieldName = "password";
/* 4259 */       break;
/*      */     case 24:
/* 4261 */       strFieldName = "appntNo";
/* 4262 */       break;
/*      */     case 25:
/* 4264 */       strFieldName = "appntId";
/* 4265 */       break;
/*      */     case 26:
/* 4267 */       strFieldName = "appntName";
/* 4268 */       break;
/*      */     case 27:
/* 4270 */       strFieldName = "appntSex";
/* 4271 */       break;
/*      */     case 28:
/* 4273 */       strFieldName = "appntBirthday";
/* 4274 */       break;
/*      */     case 29:
/* 4276 */       strFieldName = "appntIDType";
/* 4277 */       break;
/*      */     case 30:
/* 4279 */       strFieldName = "appntIDNo";
/* 4280 */       break;
/*      */     case 31:
/* 4282 */       strFieldName = "insuredNo";
/* 4283 */       break;
/*      */     case 32:
/* 4285 */       strFieldName = "insuredId";
/* 4286 */       break;
/*      */     case 33:
/* 4288 */       strFieldName = "insuredName";
/* 4289 */       break;
/*      */     case 34:
/* 4291 */       strFieldName = "insuredSex";
/* 4292 */       break;
/*      */     case 35:
/* 4294 */       strFieldName = "insuredBirthday";
/* 4295 */       break;
/*      */     case 36:
/* 4297 */       strFieldName = "insuredIDType";
/* 4298 */       break;
/*      */     case 37:
/* 4300 */       strFieldName = "insuredIDNo";
/* 4301 */       break;
/*      */     case 38:
/* 4303 */       strFieldName = "payIntv";
/* 4304 */       break;
/*      */     case 39:
/* 4306 */       strFieldName = "payMode";
/* 4307 */       break;
/*      */     case 40:
/* 4309 */       strFieldName = "payLocation";
/* 4310 */       break;
/*      */     case 41:
/* 4312 */       strFieldName = "disputedFlag";
/* 4313 */       break;
/*      */     case 42:
/* 4315 */       strFieldName = "outPayFlag";
/* 4316 */       break;
/*      */     case 43:
/* 4318 */       strFieldName = "getPolMode";
/* 4319 */       break;
/*      */     case 44:
/* 4321 */       strFieldName = "signCom";
/* 4322 */       break;
/*      */     case 45:
/* 4324 */       strFieldName = "signDate";
/* 4325 */       break;
/*      */     case 46:
/* 4327 */       strFieldName = "signTime";
/* 4328 */       break;
/*      */     case 47:
/* 4330 */       strFieldName = "consignNo";
/* 4331 */       break;
/*      */     case 48:
/* 4333 */       strFieldName = "bankCode";
/* 4334 */       break;
/*      */     case 49:
/* 4336 */       strFieldName = "bankAccNo";
/* 4337 */       break;
/*      */     case 50:
/* 4339 */       strFieldName = "accName";
/* 4340 */       break;
/*      */     case 51:
/* 4342 */       strFieldName = "printCount";
/* 4343 */       break;
/*      */     case 52:
/* 4345 */       strFieldName = "lostTimes";
/* 4346 */       break;
/*      */     case 53:
/* 4348 */       strFieldName = "lang";
/* 4349 */       break;
/*      */     case 54:
/* 4351 */       strFieldName = "currency";
/* 4352 */       break;
/*      */     case 55:
/* 4354 */       strFieldName = "remark";
/* 4355 */       break;
/*      */     case 56:
/* 4357 */       strFieldName = "peoples";
/* 4358 */       break;
/*      */     case 57:
/* 4360 */       strFieldName = "mult";
/* 4361 */       break;
/*      */     case 58:
/* 4363 */       strFieldName = "prem";
/* 4364 */       break;
/*      */     case 59:
/* 4366 */       strFieldName = "amnt";
/* 4367 */       break;
/*      */     case 60:
/* 4369 */       strFieldName = "sumPrem";
/* 4370 */       break;
/*      */     case 61:
/* 4372 */       strFieldName = "dif";
/* 4373 */       break;
/*      */     case 62:
/* 4375 */       strFieldName = "paytoDate";
/* 4376 */       break;
/*      */     case 63:
/* 4378 */       strFieldName = "firstPayDate";
/* 4379 */       break;
/*      */     case 64:
/* 4381 */       strFieldName = "cValiDate";
/* 4382 */       break;
/*      */     case 65:
/* 4384 */       strFieldName = "pSignDate";
/* 4385 */       break;
/*      */     case 66:
/* 4387 */       strFieldName = "pValiDate";
/* 4388 */       break;
/*      */     case 67:
/* 4390 */       strFieldName = "inputOperator";
/* 4391 */       break;
/*      */     case 68:
/* 4393 */       strFieldName = "inputDate";
/* 4394 */       break;
/*      */     case 69:
/* 4396 */       strFieldName = "inputTime";
/* 4397 */       break;
/*      */     case 70:
/* 4399 */       strFieldName = "approveFlag";
/* 4400 */       break;
/*      */     case 71:
/* 4402 */       strFieldName = "approveCode";
/* 4403 */       break;
/*      */     case 72:
/* 4405 */       strFieldName = "approveDate";
/* 4406 */       break;
/*      */     case 73:
/* 4408 */       strFieldName = "approveTime";
/* 4409 */       break;
/*      */     case 74:
/* 4411 */       strFieldName = "uWFlag";
/* 4412 */       break;
/*      */     case 75:
/* 4414 */       strFieldName = "uWOperator";
/* 4415 */       break;
/*      */     case 76:
/* 4417 */       strFieldName = "uWDate";
/* 4418 */       break;
/*      */     case 77:
/* 4420 */       strFieldName = "uWTime";
/* 4421 */       break;
/*      */     case 78:
/* 4423 */       strFieldName = "appFlag";
/* 4424 */       break;
/*      */     case 79:
/* 4426 */       strFieldName = "polApplyDate";
/* 4427 */       break;
/*      */     case 80:
/* 4429 */       strFieldName = "getPolDate";
/* 4430 */       break;
/*      */     case 81:
/* 4432 */       strFieldName = "getPolTime";
/* 4433 */       break;
/*      */     case 82:
/* 4435 */       strFieldName = "customGetPolDate";
/* 4436 */       break;
/*      */     case 83:
/* 4438 */       strFieldName = "state";
/* 4439 */       break;
/*      */     case 84:
/* 4441 */       strFieldName = "saleChnlDetail";
/* 4442 */       break;
/*      */     case 85:
/* 4444 */       strFieldName = "proposalType";
/* 4445 */       break;
/*      */     case 86:
/* 4447 */       strFieldName = "editstate";
/* 4448 */       break;
/*      */     case 87:
/* 4450 */       strFieldName = "cInValiDate";
/* 4451 */       break;
/*      */     case 88:
/* 4453 */       strFieldName = "operator";
/* 4454 */       break;
/*      */     case 89:
/* 4456 */       strFieldName = "makeDate";
/* 4457 */       break;
/*      */     case 90:
/* 4459 */       strFieldName = "makeTime";
/* 4460 */       break;
/*      */     case 91:
/* 4462 */       strFieldName = "modifyDate";
/* 4463 */       break;
/*      */     case 92:
/* 4465 */       strFieldName = "modifyTime";
/* 4466 */       break;
/*      */     default:
/* 4468 */       strFieldName = "";
/*      */     }
/* 4470 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 4476 */     if (strFieldName.equals("EdorNo")) {
/* 4477 */       return 0;
/*      */     }
/* 4479 */     if (strFieldName.equals("serialNo")) {
/* 4480 */       return 0;
/*      */     }
/* 4482 */     if (strFieldName.equals("grpContNo")) {
/* 4483 */       return 0;
/*      */     }
/* 4485 */     if (strFieldName.equals("contNo")) {
/* 4486 */       return 0;
/*      */     }
/* 4488 */     if (strFieldName.equals("proposalContNo")) {
/* 4489 */       return 0;
/*      */     }
/* 4491 */     if (strFieldName.equals("prtNo")) {
/* 4492 */       return 0;
/*      */     }
/* 4494 */     if (strFieldName.equals("mainPolNo")) {
/* 4495 */       return 0;
/*      */     }
/* 4497 */     if (strFieldName.equals("contType")) {
/* 4498 */       return 0;
/*      */     }
/* 4500 */     if (strFieldName.equals("familyType")) {
/* 4501 */       return 0;
/*      */     }
/* 4503 */     if (strFieldName.equals("familyID")) {
/* 4504 */       return 0;
/*      */     }
/* 4506 */     if (strFieldName.equals("polType")) {
/* 4507 */       return 0;
/*      */     }
/* 4509 */     if (strFieldName.equals("sugNo")) {
/* 4510 */       return 0;
/*      */     }
/* 4512 */     if (strFieldName.equals("cardFlag")) {
/* 4513 */       return 0;
/*      */     }
/* 4515 */     if (strFieldName.equals("manageCom")) {
/* 4516 */       return 0;
/*      */     }
/* 4518 */     if (strFieldName.equals("executeCom")) {
/* 4519 */       return 0;
/*      */     }
/* 4521 */     if (strFieldName.equals("agentCom")) {
/* 4522 */       return 0;
/*      */     }
/* 4524 */     if (strFieldName.equals("agentCode")) {
/* 4525 */       return 0;
/*      */     }
/* 4527 */     if (strFieldName.equals("agentGroup")) {
/* 4528 */       return 0;
/*      */     }
/* 4530 */     if (strFieldName.equals("agentCode1")) {
/* 4531 */       return 0;
/*      */     }
/* 4533 */     if (strFieldName.equals("agentGroup1")) {
/* 4534 */       return 0;
/*      */     }
/* 4536 */     if (strFieldName.equals("agentType")) {
/* 4537 */       return 0;
/*      */     }
/* 4539 */     if (strFieldName.equals("saleChnl")) {
/* 4540 */       return 0;
/*      */     }
/* 4542 */     if (strFieldName.equals("handler")) {
/* 4543 */       return 0;
/*      */     }
/* 4545 */     if (strFieldName.equals("password")) {
/* 4546 */       return 0;
/*      */     }
/* 4548 */     if (strFieldName.equals("appntNo")) {
/* 4549 */       return 0;
/*      */     }
/* 4551 */     if (strFieldName.equals("appntId")) {
/* 4552 */       return 0;
/*      */     }
/* 4554 */     if (strFieldName.equals("appntName")) {
/* 4555 */       return 0;
/*      */     }
/* 4557 */     if (strFieldName.equals("appntSex")) {
/* 4558 */       return 0;
/*      */     }
/* 4560 */     if (strFieldName.equals("appntBirthday")) {
/* 4561 */       return 1;
/*      */     }
/* 4563 */     if (strFieldName.equals("appntIDType")) {
/* 4564 */       return 0;
/*      */     }
/* 4566 */     if (strFieldName.equals("appntIDNo")) {
/* 4567 */       return 0;
/*      */     }
/* 4569 */     if (strFieldName.equals("insuredNo")) {
/* 4570 */       return 0;
/*      */     }
/* 4572 */     if (strFieldName.equals("insuredId")) {
/* 4573 */       return 0;
/*      */     }
/* 4575 */     if (strFieldName.equals("insuredName")) {
/* 4576 */       return 0;
/*      */     }
/* 4578 */     if (strFieldName.equals("insuredSex")) {
/* 4579 */       return 0;
/*      */     }
/* 4581 */     if (strFieldName.equals("insuredBirthday")) {
/* 4582 */       return 1;
/*      */     }
/* 4584 */     if (strFieldName.equals("insuredIDType")) {
/* 4585 */       return 0;
/*      */     }
/* 4587 */     if (strFieldName.equals("insuredIDNo")) {
/* 4588 */       return 0;
/*      */     }
/* 4590 */     if (strFieldName.equals("payIntv")) {
/* 4591 */       return 3;
/*      */     }
/* 4593 */     if (strFieldName.equals("payMode")) {
/* 4594 */       return 0;
/*      */     }
/* 4596 */     if (strFieldName.equals("payLocation")) {
/* 4597 */       return 0;
/*      */     }
/* 4599 */     if (strFieldName.equals("disputedFlag")) {
/* 4600 */       return 0;
/*      */     }
/* 4602 */     if (strFieldName.equals("outPayFlag")) {
/* 4603 */       return 0;
/*      */     }
/* 4605 */     if (strFieldName.equals("getPolMode")) {
/* 4606 */       return 0;
/*      */     }
/* 4608 */     if (strFieldName.equals("signCom")) {
/* 4609 */       return 0;
/*      */     }
/* 4611 */     if (strFieldName.equals("signDate")) {
/* 4612 */       return 1;
/*      */     }
/* 4614 */     if (strFieldName.equals("signTime")) {
/* 4615 */       return 0;
/*      */     }
/* 4617 */     if (strFieldName.equals("consignNo")) {
/* 4618 */       return 0;
/*      */     }
/* 4620 */     if (strFieldName.equals("bankCode")) {
/* 4621 */       return 0;
/*      */     }
/* 4623 */     if (strFieldName.equals("bankAccNo")) {
/* 4624 */       return 0;
/*      */     }
/* 4626 */     if (strFieldName.equals("accName")) {
/* 4627 */       return 0;
/*      */     }
/* 4629 */     if (strFieldName.equals("printCount")) {
/* 4630 */       return 3;
/*      */     }
/* 4632 */     if (strFieldName.equals("lostTimes")) {
/* 4633 */       return 3;
/*      */     }
/* 4635 */     if (strFieldName.equals("lang")) {
/* 4636 */       return 0;
/*      */     }
/* 4638 */     if (strFieldName.equals("currency")) {
/* 4639 */       return 0;
/*      */     }
/* 4641 */     if (strFieldName.equals("remark")) {
/* 4642 */       return 0;
/*      */     }
/* 4644 */     if (strFieldName.equals("peoples")) {
/* 4645 */       return 3;
/*      */     }
/* 4647 */     if (strFieldName.equals("mult")) {
/* 4648 */       return 4;
/*      */     }
/* 4650 */     if (strFieldName.equals("prem")) {
/* 4651 */       return 4;
/*      */     }
/* 4653 */     if (strFieldName.equals("amnt")) {
/* 4654 */       return 4;
/*      */     }
/* 4656 */     if (strFieldName.equals("sumPrem")) {
/* 4657 */       return 4;
/*      */     }
/* 4659 */     if (strFieldName.equals("dif")) {
/* 4660 */       return 4;
/*      */     }
/* 4662 */     if (strFieldName.equals("paytoDate")) {
/* 4663 */       return 1;
/*      */     }
/* 4665 */     if (strFieldName.equals("firstPayDate")) {
/* 4666 */       return 1;
/*      */     }
/* 4668 */     if (strFieldName.equals("cValiDate")) {
/* 4669 */       return 1;
/*      */     }
/* 4671 */     if (strFieldName.equals("pSignDate")) {
/* 4672 */       return 1;
/*      */     }
/* 4674 */     if (strFieldName.equals("pValiDate")) {
/* 4675 */       return 1;
/*      */     }
/* 4677 */     if (strFieldName.equals("inputOperator")) {
/* 4678 */       return 0;
/*      */     }
/* 4680 */     if (strFieldName.equals("inputDate")) {
/* 4681 */       return 1;
/*      */     }
/* 4683 */     if (strFieldName.equals("inputTime")) {
/* 4684 */       return 0;
/*      */     }
/* 4686 */     if (strFieldName.equals("approveFlag")) {
/* 4687 */       return 0;
/*      */     }
/* 4689 */     if (strFieldName.equals("approveCode")) {
/* 4690 */       return 0;
/*      */     }
/* 4692 */     if (strFieldName.equals("approveDate")) {
/* 4693 */       return 1;
/*      */     }
/* 4695 */     if (strFieldName.equals("approveTime")) {
/* 4696 */       return 0;
/*      */     }
/* 4698 */     if (strFieldName.equals("uWFlag")) {
/* 4699 */       return 0;
/*      */     }
/* 4701 */     if (strFieldName.equals("uWOperator")) {
/* 4702 */       return 0;
/*      */     }
/* 4704 */     if (strFieldName.equals("uWDate")) {
/* 4705 */       return 1;
/*      */     }
/* 4707 */     if (strFieldName.equals("uWTime")) {
/* 4708 */       return 0;
/*      */     }
/* 4710 */     if (strFieldName.equals("appFlag")) {
/* 4711 */       return 0;
/*      */     }
/* 4713 */     if (strFieldName.equals("polApplyDate")) {
/* 4714 */       return 1;
/*      */     }
/* 4716 */     if (strFieldName.equals("getPolDate")) {
/* 4717 */       return 1;
/*      */     }
/* 4719 */     if (strFieldName.equals("getPolTime")) {
/* 4720 */       return 0;
/*      */     }
/* 4722 */     if (strFieldName.equals("customGetPolDate")) {
/* 4723 */       return 1;
/*      */     }
/* 4725 */     if (strFieldName.equals("state")) {
/* 4726 */       return 0;
/*      */     }
/* 4728 */     if (strFieldName.equals("saleChnlDetail")) {
/* 4729 */       return 0;
/*      */     }
/* 4731 */     if (strFieldName.equals("proposalType")) {
/* 4732 */       return 0;
/*      */     }
/* 4734 */     if (strFieldName.equals("editstate")) {
/* 4735 */       return 0;
/*      */     }
/* 4737 */     if (strFieldName.equals("cInValiDate")) {
/* 4738 */       return 1;
/*      */     }
/* 4740 */     if (strFieldName.equals("operator")) {
/* 4741 */       return 0;
/*      */     }
/* 4743 */     if (strFieldName.equals("makeDate")) {
/* 4744 */       return 1;
/*      */     }
/* 4746 */     if (strFieldName.equals("makeTime")) {
/* 4747 */       return 0;
/*      */     }
/* 4749 */     if (strFieldName.equals("modifyDate")) {
/* 4750 */       return 1;
/*      */     }
/* 4752 */     if (strFieldName.equals("modifyTime")) {
/* 4753 */       return 0;
/*      */     }
/* 4755 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 4761 */     int nFieldType = -1;
/* 4762 */     switch (nFieldIndex) {
/*      */     case 0:
/* 4764 */       nFieldType = 0;
/* 4765 */       break;
/*      */     case 1:
/* 4767 */       nFieldType = 0;
/* 4768 */       break;
/*      */     case 2:
/* 4770 */       nFieldType = 0;
/* 4771 */       break;
/*      */     case 3:
/* 4773 */       nFieldType = 0;
/* 4774 */       break;
/*      */     case 4:
/* 4776 */       nFieldType = 0;
/* 4777 */       break;
/*      */     case 5:
/* 4779 */       nFieldType = 0;
/* 4780 */       break;
/*      */     case 6:
/* 4782 */       nFieldType = 0;
/* 4783 */       break;
/*      */     case 7:
/* 4785 */       nFieldType = 0;
/* 4786 */       break;
/*      */     case 8:
/* 4788 */       nFieldType = 0;
/* 4789 */       break;
/*      */     case 9:
/* 4791 */       nFieldType = 0;
/* 4792 */       break;
/*      */     case 10:
/* 4794 */       nFieldType = 0;
/* 4795 */       break;
/*      */     case 11:
/* 4797 */       nFieldType = 0;
/* 4798 */       break;
/*      */     case 12:
/* 4800 */       nFieldType = 0;
/* 4801 */       break;
/*      */     case 13:
/* 4803 */       nFieldType = 0;
/* 4804 */       break;
/*      */     case 14:
/* 4806 */       nFieldType = 0;
/* 4807 */       break;
/*      */     case 15:
/* 4809 */       nFieldType = 0;
/* 4810 */       break;
/*      */     case 16:
/* 4812 */       nFieldType = 0;
/* 4813 */       break;
/*      */     case 17:
/* 4815 */       nFieldType = 0;
/* 4816 */       break;
/*      */     case 18:
/* 4818 */       nFieldType = 0;
/* 4819 */       break;
/*      */     case 19:
/* 4821 */       nFieldType = 0;
/* 4822 */       break;
/*      */     case 20:
/* 4824 */       nFieldType = 0;
/* 4825 */       break;
/*      */     case 21:
/* 4827 */       nFieldType = 0;
/* 4828 */       break;
/*      */     case 22:
/* 4830 */       nFieldType = 0;
/* 4831 */       break;
/*      */     case 23:
/* 4833 */       nFieldType = 0;
/* 4834 */       break;
/*      */     case 24:
/* 4836 */       nFieldType = 0;
/* 4837 */       break;
/*      */     case 25:
/* 4839 */       nFieldType = 0;
/* 4840 */       break;
/*      */     case 26:
/* 4842 */       nFieldType = 0;
/* 4843 */       break;
/*      */     case 27:
/* 4845 */       nFieldType = 0;
/* 4846 */       break;
/*      */     case 28:
/* 4848 */       nFieldType = 1;
/* 4849 */       break;
/*      */     case 29:
/* 4851 */       nFieldType = 0;
/* 4852 */       break;
/*      */     case 30:
/* 4854 */       nFieldType = 0;
/* 4855 */       break;
/*      */     case 31:
/* 4857 */       nFieldType = 0;
/* 4858 */       break;
/*      */     case 32:
/* 4860 */       nFieldType = 0;
/* 4861 */       break;
/*      */     case 33:
/* 4863 */       nFieldType = 0;
/* 4864 */       break;
/*      */     case 34:
/* 4866 */       nFieldType = 0;
/* 4867 */       break;
/*      */     case 35:
/* 4869 */       nFieldType = 1;
/* 4870 */       break;
/*      */     case 36:
/* 4872 */       nFieldType = 0;
/* 4873 */       break;
/*      */     case 37:
/* 4875 */       nFieldType = 0;
/* 4876 */       break;
/*      */     case 38:
/* 4878 */       nFieldType = 3;
/* 4879 */       break;
/*      */     case 39:
/* 4881 */       nFieldType = 0;
/* 4882 */       break;
/*      */     case 40:
/* 4884 */       nFieldType = 0;
/* 4885 */       break;
/*      */     case 41:
/* 4887 */       nFieldType = 0;
/* 4888 */       break;
/*      */     case 42:
/* 4890 */       nFieldType = 0;
/* 4891 */       break;
/*      */     case 43:
/* 4893 */       nFieldType = 0;
/* 4894 */       break;
/*      */     case 44:
/* 4896 */       nFieldType = 0;
/* 4897 */       break;
/*      */     case 45:
/* 4899 */       nFieldType = 1;
/* 4900 */       break;
/*      */     case 46:
/* 4902 */       nFieldType = 0;
/* 4903 */       break;
/*      */     case 47:
/* 4905 */       nFieldType = 0;
/* 4906 */       break;
/*      */     case 48:
/* 4908 */       nFieldType = 0;
/* 4909 */       break;
/*      */     case 49:
/* 4911 */       nFieldType = 0;
/* 4912 */       break;
/*      */     case 50:
/* 4914 */       nFieldType = 0;
/* 4915 */       break;
/*      */     case 51:
/* 4917 */       nFieldType = 3;
/* 4918 */       break;
/*      */     case 52:
/* 4920 */       nFieldType = 3;
/* 4921 */       break;
/*      */     case 53:
/* 4923 */       nFieldType = 0;
/* 4924 */       break;
/*      */     case 54:
/* 4926 */       nFieldType = 0;
/* 4927 */       break;
/*      */     case 55:
/* 4929 */       nFieldType = 0;
/* 4930 */       break;
/*      */     case 56:
/* 4932 */       nFieldType = 3;
/* 4933 */       break;
/*      */     case 57:
/* 4935 */       nFieldType = 4;
/* 4936 */       break;
/*      */     case 58:
/* 4938 */       nFieldType = 4;
/* 4939 */       break;
/*      */     case 59:
/* 4941 */       nFieldType = 4;
/* 4942 */       break;
/*      */     case 60:
/* 4944 */       nFieldType = 4;
/* 4945 */       break;
/*      */     case 61:
/* 4947 */       nFieldType = 4;
/* 4948 */       break;
/*      */     case 62:
/* 4950 */       nFieldType = 1;
/* 4951 */       break;
/*      */     case 63:
/* 4953 */       nFieldType = 1;
/* 4954 */       break;
/*      */     case 64:
/* 4956 */       nFieldType = 1;
/* 4957 */       break;
/*      */     case 65:
/* 4959 */       nFieldType = 1;
/* 4960 */       break;
/*      */     case 66:
/* 4962 */       nFieldType = 1;
/* 4963 */       break;
/*      */     case 67:
/* 4965 */       nFieldType = 0;
/* 4966 */       break;
/*      */     case 68:
/* 4968 */       nFieldType = 1;
/* 4969 */       break;
/*      */     case 69:
/* 4971 */       nFieldType = 0;
/* 4972 */       break;
/*      */     case 70:
/* 4974 */       nFieldType = 0;
/* 4975 */       break;
/*      */     case 71:
/* 4977 */       nFieldType = 0;
/* 4978 */       break;
/*      */     case 72:
/* 4980 */       nFieldType = 1;
/* 4981 */       break;
/*      */     case 73:
/* 4983 */       nFieldType = 0;
/* 4984 */       break;
/*      */     case 74:
/* 4986 */       nFieldType = 0;
/* 4987 */       break;
/*      */     case 75:
/* 4989 */       nFieldType = 0;
/* 4990 */       break;
/*      */     case 76:
/* 4992 */       nFieldType = 1;
/* 4993 */       break;
/*      */     case 77:
/* 4995 */       nFieldType = 0;
/* 4996 */       break;
/*      */     case 78:
/* 4998 */       nFieldType = 0;
/* 4999 */       break;
/*      */     case 79:
/* 5001 */       nFieldType = 1;
/* 5002 */       break;
/*      */     case 80:
/* 5004 */       nFieldType = 1;
/* 5005 */       break;
/*      */     case 81:
/* 5007 */       nFieldType = 0;
/* 5008 */       break;
/*      */     case 82:
/* 5010 */       nFieldType = 1;
/* 5011 */       break;
/*      */     case 83:
/* 5013 */       nFieldType = 0;
/* 5014 */       break;
/*      */     case 84:
/* 5016 */       nFieldType = 0;
/* 5017 */       break;
/*      */     case 85:
/* 5019 */       nFieldType = 0;
/* 5020 */       break;
/*      */     case 86:
/* 5022 */       nFieldType = 0;
/* 5023 */       break;
/*      */     case 87:
/* 5025 */       nFieldType = 1;
/* 5026 */       break;
/*      */     case 88:
/* 5028 */       nFieldType = 0;
/* 5029 */       break;
/*      */     case 89:
/* 5031 */       nFieldType = 1;
/* 5032 */       break;
/*      */     case 90:
/* 5034 */       nFieldType = 0;
/* 5035 */       break;
/*      */     case 91:
/* 5037 */       nFieldType = 1;
/* 5038 */       break;
/*      */     case 92:
/* 5040 */       nFieldType = 0;
/* 5041 */       break;
/*      */     default:
/* 5043 */       nFieldType = -1;
/*      */     }
/* 5045 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPContBSchema
 * JD-Core Version:    0.6.0
 */