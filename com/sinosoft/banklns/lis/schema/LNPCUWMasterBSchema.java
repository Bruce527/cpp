/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPCUWMasterBDB;
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
/*      */ public class LNPCUWMasterBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private int uWNo;
/*      */   private String manageCom;
/*      */   private Date uWDate;
/*      */   private String uWTime;
/*      */   private String uWerName;
/*      */   private String checkStatus;
/*      */   private String appIsCompleted;
/*      */   private String appIsSubmitted;
/*      */   private String appDecision;
/*      */   private String autoUWFlag;
/*      */   private String uWMessages;
/*      */   private String uWGrade;
/*      */   private String appGrade;
/*      */   private String state;
/*      */   private String upReportContent;
/*      */   private String healthFlag;
/*      */   private String quesFlag;
/*      */   private String specFlag;
/*      */   private String addPremFlag;
/*      */   private String addPremReason;
/*      */   private String specReason;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 31;
/*      */   private static String[] PK;
/*   87 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPCUWMasterBSchema()
/*      */   {
/*   94 */     this.mErrors = new CErrors();
/*      */ 
/*   96 */     String[] pk = new String[2];
/*   97 */     pk[0] = "EdorNo";
/*   98 */     pk[1] = "serialNo";
/*      */ 
/*  100 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  106 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  111 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*  115 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  119 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*  123 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  127 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  131 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getgrpContNo() {
/*  135 */     if (this.grpContNo != null) this.grpContNo.equals("");
/*      */ 
/*  139 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setgrpContNo(String agrpContNo) {
/*  143 */     this.grpContNo = agrpContNo;
/*      */   }
/*      */ 
/*      */   public String getcontNo() {
/*  147 */     if (this.contNo != null) this.contNo.equals("");
/*      */ 
/*  151 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setcontNo(String acontNo) {
/*  155 */     this.contNo = acontNo;
/*      */   }
/*      */ 
/*      */   public String getproposalContNo() {
/*  159 */     if (this.proposalContNo != null) this.proposalContNo.equals("");
/*      */ 
/*  163 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setproposalContNo(String aproposalContNo) {
/*  167 */     this.proposalContNo = aproposalContNo;
/*      */   }
/*      */ 
/*      */   public int getuWNo() {
/*  171 */     return this.uWNo;
/*      */   }
/*      */ 
/*      */   public void setuWNo(int auWNo) {
/*  175 */     this.uWNo = auWNo;
/*      */   }
/*      */ 
/*      */   public void setuWNo(String auWNo) {
/*  179 */     if ((auWNo != null) && (!auWNo.equals("")))
/*      */     {
/*  181 */       Integer tInteger = new Integer(auWNo);
/*  182 */       int i = tInteger.intValue();
/*  183 */       this.uWNo = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getmanageCom()
/*      */   {
/*  189 */     if (this.manageCom != null) this.manageCom.equals("");
/*      */ 
/*  193 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setmanageCom(String amanageCom) {
/*  197 */     this.manageCom = amanageCom;
/*      */   }
/*      */ 
/*      */   public String getuWDate() {
/*  201 */     if (this.uWDate != null) {
/*  202 */       return this.fDate.getString(this.uWDate);
/*      */     }
/*  204 */     return null;
/*      */   }
/*      */ 
/*      */   public void setuWDate(Date auWDate) {
/*  208 */     this.uWDate = auWDate;
/*      */   }
/*      */ 
/*      */   public void setuWDate(String auWDate) {
/*  212 */     if ((auWDate != null) && (!auWDate.equals("")))
/*      */     {
/*  214 */       this.uWDate = this.fDate.getDate(auWDate);
/*      */     }
/*      */     else
/*  217 */       this.uWDate = null;
/*      */   }
/*      */ 
/*      */   public String getuWTime()
/*      */   {
/*  222 */     if (this.uWTime != null) this.uWTime.equals("");
/*      */ 
/*  226 */     return this.uWTime;
/*      */   }
/*      */ 
/*      */   public void setuWTime(String auWTime) {
/*  230 */     this.uWTime = auWTime;
/*      */   }
/*      */ 
/*      */   public String getuWerName() {
/*  234 */     if (this.uWerName != null) this.uWerName.equals("");
/*      */ 
/*  238 */     return this.uWerName;
/*      */   }
/*      */ 
/*      */   public void setuWerName(String auWerName) {
/*  242 */     this.uWerName = auWerName;
/*      */   }
/*      */ 
/*      */   public String getcheckStatus() {
/*  246 */     if (this.checkStatus != null) this.checkStatus.equals("");
/*      */ 
/*  250 */     return this.checkStatus;
/*      */   }
/*      */ 
/*      */   public void setcheckStatus(String acheckStatus) {
/*  254 */     this.checkStatus = acheckStatus;
/*      */   }
/*      */ 
/*      */   public String getappIsCompleted() {
/*  258 */     if (this.appIsCompleted != null) this.appIsCompleted.equals("");
/*      */ 
/*  262 */     return this.appIsCompleted;
/*      */   }
/*      */ 
/*      */   public void setappIsCompleted(String aappIsCompleted) {
/*  266 */     this.appIsCompleted = aappIsCompleted;
/*      */   }
/*      */ 
/*      */   public String getappIsSubmitted() {
/*  270 */     if (this.appIsSubmitted != null) this.appIsSubmitted.equals("");
/*      */ 
/*  274 */     return this.appIsSubmitted;
/*      */   }
/*      */ 
/*      */   public void setappIsSubmitted(String aappIsSubmitted) {
/*  278 */     this.appIsSubmitted = aappIsSubmitted;
/*      */   }
/*      */ 
/*      */   public String getappDecision() {
/*  282 */     if (this.appDecision != null) this.appDecision.equals("");
/*      */ 
/*  286 */     return this.appDecision;
/*      */   }
/*      */ 
/*      */   public void setappDecision(String aappDecision) {
/*  290 */     this.appDecision = aappDecision;
/*      */   }
/*      */ 
/*      */   public String getautoUWFlag() {
/*  294 */     if (this.autoUWFlag != null) this.autoUWFlag.equals("");
/*      */ 
/*  298 */     return this.autoUWFlag;
/*      */   }
/*      */ 
/*      */   public void setautoUWFlag(String aautoUWFlag) {
/*  302 */     this.autoUWFlag = aautoUWFlag;
/*      */   }
/*      */ 
/*      */   public String getuWMessages() {
/*  306 */     if (this.uWMessages != null) this.uWMessages.equals("");
/*      */ 
/*  310 */     return this.uWMessages;
/*      */   }
/*      */ 
/*      */   public void setuWMessages(String auWMessages) {
/*  314 */     this.uWMessages = auWMessages;
/*      */   }
/*      */ 
/*      */   public String getuWGrade() {
/*  318 */     if (this.uWGrade != null) this.uWGrade.equals("");
/*      */ 
/*  322 */     return this.uWGrade;
/*      */   }
/*      */ 
/*      */   public void setuWGrade(String auWGrade) {
/*  326 */     this.uWGrade = auWGrade;
/*      */   }
/*      */ 
/*      */   public String getappGrade() {
/*  330 */     if (this.appGrade != null) this.appGrade.equals("");
/*      */ 
/*  334 */     return this.appGrade;
/*      */   }
/*      */ 
/*      */   public void setappGrade(String aappGrade) {
/*  338 */     this.appGrade = aappGrade;
/*      */   }
/*      */ 
/*      */   public String getstate() {
/*  342 */     if (this.state != null) this.state.equals("");
/*      */ 
/*  346 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setstate(String astate) {
/*  350 */     this.state = astate;
/*      */   }
/*      */ 
/*      */   public String getupReportContent() {
/*  354 */     if (this.upReportContent != null) this.upReportContent.equals("");
/*      */ 
/*  358 */     return this.upReportContent;
/*      */   }
/*      */ 
/*      */   public void setupReportContent(String aupReportContent) {
/*  362 */     this.upReportContent = aupReportContent;
/*      */   }
/*      */ 
/*      */   public String gethealthFlag() {
/*  366 */     if (this.healthFlag != null) this.healthFlag.equals("");
/*      */ 
/*  370 */     return this.healthFlag;
/*      */   }
/*      */ 
/*      */   public void sethealthFlag(String ahealthFlag) {
/*  374 */     this.healthFlag = ahealthFlag;
/*      */   }
/*      */ 
/*      */   public String getquesFlag() {
/*  378 */     if (this.quesFlag != null) this.quesFlag.equals("");
/*      */ 
/*  382 */     return this.quesFlag;
/*      */   }
/*      */ 
/*      */   public void setquesFlag(String aquesFlag) {
/*  386 */     this.quesFlag = aquesFlag;
/*      */   }
/*      */ 
/*      */   public String getspecFlag() {
/*  390 */     if (this.specFlag != null) this.specFlag.equals("");
/*      */ 
/*  394 */     return this.specFlag;
/*      */   }
/*      */ 
/*      */   public void setspecFlag(String aspecFlag) {
/*  398 */     this.specFlag = aspecFlag;
/*      */   }
/*      */ 
/*      */   public String getaddPremFlag() {
/*  402 */     if (this.addPremFlag != null) this.addPremFlag.equals("");
/*      */ 
/*  406 */     return this.addPremFlag;
/*      */   }
/*      */ 
/*      */   public void setaddPremFlag(String aaddPremFlag) {
/*  410 */     this.addPremFlag = aaddPremFlag;
/*      */   }
/*      */ 
/*      */   public String getaddPremReason() {
/*  414 */     if (this.addPremReason != null) this.addPremReason.equals("");
/*      */ 
/*  418 */     return this.addPremReason;
/*      */   }
/*      */ 
/*      */   public void setaddPremReason(String aaddPremReason) {
/*  422 */     this.addPremReason = aaddPremReason;
/*      */   }
/*      */ 
/*      */   public String getspecReason() {
/*  426 */     if (this.specReason != null) this.specReason.equals("");
/*      */ 
/*  430 */     return this.specReason;
/*      */   }
/*      */ 
/*      */   public void setspecReason(String aspecReason) {
/*  434 */     this.specReason = aspecReason;
/*      */   }
/*      */ 
/*      */   public String getoperator() {
/*  438 */     if (this.operator != null) this.operator.equals("");
/*      */ 
/*  442 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setoperator(String aoperator) {
/*  446 */     this.operator = aoperator;
/*      */   }
/*      */ 
/*      */   public String getmakeDate() {
/*  450 */     if (this.makeDate != null) {
/*  451 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  453 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(Date amakeDate) {
/*  457 */     this.makeDate = amakeDate;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(String amakeDate) {
/*  461 */     if ((amakeDate != null) && (!amakeDate.equals("")))
/*      */     {
/*  463 */       this.makeDate = this.fDate.getDate(amakeDate);
/*      */     }
/*      */     else
/*  466 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getmakeTime()
/*      */   {
/*  471 */     if (this.makeTime != null) this.makeTime.equals("");
/*      */ 
/*  475 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setmakeTime(String amakeTime) {
/*  479 */     this.makeTime = amakeTime;
/*      */   }
/*      */ 
/*      */   public String getmodifyDate() {
/*  483 */     if (this.modifyDate != null) {
/*  484 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  486 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(Date amodifyDate) {
/*  490 */     this.modifyDate = amodifyDate;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(String amodifyDate) {
/*  494 */     if ((amodifyDate != null) && (!amodifyDate.equals("")))
/*      */     {
/*  496 */       this.modifyDate = this.fDate.getDate(amodifyDate);
/*      */     }
/*      */     else
/*  499 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getmodifyTime()
/*      */   {
/*  504 */     if (this.modifyTime != null) this.modifyTime.equals("");
/*      */ 
/*  508 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setmodifyTime(String amodifyTime) {
/*  512 */     this.modifyTime = amodifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPCUWMasterBSchema aLNPCUWMasterBSchema)
/*      */   {
/*  518 */     this.EdorNo = aLNPCUWMasterBSchema.getEdorNo();
/*  519 */     this.serialNo = aLNPCUWMasterBSchema.getserialNo();
/*  520 */     this.grpContNo = aLNPCUWMasterBSchema.getgrpContNo();
/*  521 */     this.contNo = aLNPCUWMasterBSchema.getcontNo();
/*  522 */     this.proposalContNo = aLNPCUWMasterBSchema.getproposalContNo();
/*  523 */     this.uWNo = aLNPCUWMasterBSchema.getuWNo();
/*  524 */     this.manageCom = aLNPCUWMasterBSchema.getmanageCom();
/*  525 */     this.uWDate = this.fDate.getDate(aLNPCUWMasterBSchema.getuWDate());
/*  526 */     this.uWTime = aLNPCUWMasterBSchema.getuWTime();
/*  527 */     this.uWerName = aLNPCUWMasterBSchema.getuWerName();
/*  528 */     this.checkStatus = aLNPCUWMasterBSchema.getcheckStatus();
/*  529 */     this.appIsCompleted = aLNPCUWMasterBSchema.getappIsCompleted();
/*  530 */     this.appIsSubmitted = aLNPCUWMasterBSchema.getappIsSubmitted();
/*  531 */     this.appDecision = aLNPCUWMasterBSchema.getappDecision();
/*  532 */     this.autoUWFlag = aLNPCUWMasterBSchema.getautoUWFlag();
/*  533 */     this.uWMessages = aLNPCUWMasterBSchema.getuWMessages();
/*  534 */     this.uWGrade = aLNPCUWMasterBSchema.getuWGrade();
/*  535 */     this.appGrade = aLNPCUWMasterBSchema.getappGrade();
/*  536 */     this.state = aLNPCUWMasterBSchema.getstate();
/*  537 */     this.upReportContent = aLNPCUWMasterBSchema.getupReportContent();
/*  538 */     this.healthFlag = aLNPCUWMasterBSchema.gethealthFlag();
/*  539 */     this.quesFlag = aLNPCUWMasterBSchema.getquesFlag();
/*  540 */     this.specFlag = aLNPCUWMasterBSchema.getspecFlag();
/*  541 */     this.addPremFlag = aLNPCUWMasterBSchema.getaddPremFlag();
/*  542 */     this.addPremReason = aLNPCUWMasterBSchema.getaddPremReason();
/*  543 */     this.specReason = aLNPCUWMasterBSchema.getspecReason();
/*  544 */     this.operator = aLNPCUWMasterBSchema.getoperator();
/*  545 */     this.makeDate = this.fDate.getDate(aLNPCUWMasterBSchema.getmakeDate());
/*  546 */     this.makeTime = aLNPCUWMasterBSchema.getmakeTime();
/*  547 */     this.modifyDate = this.fDate.getDate(aLNPCUWMasterBSchema.getmodifyDate());
/*  548 */     this.modifyTime = aLNPCUWMasterBSchema.getmodifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  557 */       if (rs.getString("EdorNo") == null)
/*  558 */         this.EdorNo = null;
/*      */       else {
/*  560 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  562 */       if (rs.getString("serialNo") == null)
/*  563 */         this.serialNo = null;
/*      */       else {
/*  565 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/*  567 */       if (rs.getString("grpContNo") == null)
/*  568 */         this.grpContNo = null;
/*      */       else {
/*  570 */         this.grpContNo = rs.getString("grpContNo").trim();
/*      */       }
/*  572 */       if (rs.getString("contNo") == null)
/*  573 */         this.contNo = null;
/*      */       else {
/*  575 */         this.contNo = rs.getString("contNo").trim();
/*      */       }
/*  577 */       if (rs.getString("proposalContNo") == null)
/*  578 */         this.proposalContNo = null;
/*      */       else {
/*  580 */         this.proposalContNo = rs.getString("proposalContNo").trim();
/*      */       }
/*  582 */       this.uWNo = rs.getInt("uWNo");
/*  583 */       if (rs.getString("manageCom") == null)
/*  584 */         this.manageCom = null;
/*      */       else {
/*  586 */         this.manageCom = rs.getString("manageCom").trim();
/*      */       }
/*  588 */       this.uWDate = rs.getDate("uWDate");
/*  589 */       if (rs.getString("uWTime") == null)
/*  590 */         this.uWTime = null;
/*      */       else {
/*  592 */         this.uWTime = rs.getString("uWTime").trim();
/*      */       }
/*  594 */       if (rs.getString("uWerName") == null)
/*  595 */         this.uWerName = null;
/*      */       else {
/*  597 */         this.uWerName = rs.getString("uWerName").trim();
/*      */       }
/*  599 */       if (rs.getString("checkStatus") == null)
/*  600 */         this.checkStatus = null;
/*      */       else {
/*  602 */         this.checkStatus = rs.getString("checkStatus").trim();
/*      */       }
/*  604 */       if (rs.getString("appIsCompleted") == null)
/*  605 */         this.appIsCompleted = null;
/*      */       else {
/*  607 */         this.appIsCompleted = rs.getString("appIsCompleted").trim();
/*      */       }
/*  609 */       if (rs.getString("appIsSubmitted") == null)
/*  610 */         this.appIsSubmitted = null;
/*      */       else {
/*  612 */         this.appIsSubmitted = rs.getString("appIsSubmitted").trim();
/*      */       }
/*  614 */       if (rs.getString("appDecision") == null)
/*  615 */         this.appDecision = null;
/*      */       else {
/*  617 */         this.appDecision = rs.getString("appDecision").trim();
/*      */       }
/*  619 */       if (rs.getString("autoUWFlag") == null)
/*  620 */         this.autoUWFlag = null;
/*      */       else {
/*  622 */         this.autoUWFlag = rs.getString("autoUWFlag").trim();
/*      */       }
/*  624 */       if (rs.getString("uWMessages") == null)
/*  625 */         this.uWMessages = null;
/*      */       else {
/*  627 */         this.uWMessages = rs.getString("uWMessages").trim();
/*      */       }
/*  629 */       if (rs.getString("uWGrade") == null)
/*  630 */         this.uWGrade = null;
/*      */       else {
/*  632 */         this.uWGrade = rs.getString("uWGrade").trim();
/*      */       }
/*  634 */       if (rs.getString("appGrade") == null)
/*  635 */         this.appGrade = null;
/*      */       else {
/*  637 */         this.appGrade = rs.getString("appGrade").trim();
/*      */       }
/*  639 */       if (rs.getString("state") == null)
/*  640 */         this.state = null;
/*      */       else {
/*  642 */         this.state = rs.getString("state").trim();
/*      */       }
/*  644 */       if (rs.getString("upReportContent") == null)
/*  645 */         this.upReportContent = null;
/*      */       else {
/*  647 */         this.upReportContent = rs.getString("upReportContent").trim();
/*      */       }
/*  649 */       if (rs.getString("healthFlag") == null)
/*  650 */         this.healthFlag = null;
/*      */       else {
/*  652 */         this.healthFlag = rs.getString("healthFlag").trim();
/*      */       }
/*  654 */       if (rs.getString("quesFlag") == null)
/*  655 */         this.quesFlag = null;
/*      */       else {
/*  657 */         this.quesFlag = rs.getString("quesFlag").trim();
/*      */       }
/*  659 */       if (rs.getString("specFlag") == null)
/*  660 */         this.specFlag = null;
/*      */       else {
/*  662 */         this.specFlag = rs.getString("specFlag").trim();
/*      */       }
/*  664 */       if (rs.getString("addPremFlag") == null)
/*  665 */         this.addPremFlag = null;
/*      */       else {
/*  667 */         this.addPremFlag = rs.getString("addPremFlag").trim();
/*      */       }
/*  669 */       if (rs.getString("addPremReason") == null)
/*  670 */         this.addPremReason = null;
/*      */       else {
/*  672 */         this.addPremReason = rs.getString("addPremReason").trim();
/*      */       }
/*  674 */       if (rs.getString("specReason") == null)
/*  675 */         this.specReason = null;
/*      */       else {
/*  677 */         this.specReason = rs.getString("specReason").trim();
/*      */       }
/*  679 */       if (rs.getString("operator") == null)
/*  680 */         this.operator = null;
/*      */       else {
/*  682 */         this.operator = rs.getString("operator").trim();
/*      */       }
/*  684 */       this.makeDate = rs.getDate("makeDate");
/*  685 */       if (rs.getString("makeTime") == null)
/*  686 */         this.makeTime = null;
/*      */       else {
/*  688 */         this.makeTime = rs.getString("makeTime").trim();
/*      */       }
/*  690 */       this.modifyDate = rs.getDate("modifyDate");
/*  691 */       if (rs.getString("modifyTime") == null)
/*  692 */         this.modifyTime = null;
/*      */       else {
/*  694 */         this.modifyTime = rs.getString("modifyTime").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  700 */       CError tError = new CError();
/*  701 */       tError.moduleName = "LNPCUWMasterBSchema";
/*  702 */       tError.functionName = "setSchema";
/*  703 */       tError.errorMessage = sqle.toString();
/*  704 */       this.mErrors.addOneError(tError);
/*      */ 
/*  706 */       return false;
/*      */     }
/*  708 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPCUWMasterBSchema getSchema()
/*      */   {
/*  713 */     LNPCUWMasterBSchema aLNPCUWMasterBSchema = new LNPCUWMasterBSchema();
/*  714 */     aLNPCUWMasterBSchema.setSchema(this);
/*  715 */     return aLNPCUWMasterBSchema;
/*      */   }
/*      */ 
/*      */   public LNPCUWMasterBDB getDB()
/*      */   {
/*  720 */     LNPCUWMasterBDB aDBOper = new LNPCUWMasterBDB();
/*  721 */     aDBOper.setSchema(this);
/*  722 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  729 */     String strReturn = "";
/*  730 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/*  731 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/*  732 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpContNo)) + "|" + 
/*  733 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contNo)) + "|" + 
/*  734 */       StrTool.cTrim(StrTool.unicodeToGBK(this.proposalContNo)) + "|" + 
/*  735 */       ChgData.chgData(this.uWNo) + "|" + 
/*  736 */       StrTool.cTrim(StrTool.unicodeToGBK(this.manageCom)) + "|" + 
/*  737 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.uWDate))) + "|" + 
/*  738 */       StrTool.cTrim(StrTool.unicodeToGBK(this.uWTime)) + "|" + 
/*  739 */       StrTool.cTrim(StrTool.unicodeToGBK(this.uWerName)) + "|" + 
/*  740 */       StrTool.cTrim(StrTool.unicodeToGBK(this.checkStatus)) + "|" + 
/*  741 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appIsCompleted)) + "|" + 
/*  742 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appIsSubmitted)) + "|" + 
/*  743 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appDecision)) + "|" + 
/*  744 */       StrTool.cTrim(StrTool.unicodeToGBK(this.autoUWFlag)) + "|" + 
/*  745 */       StrTool.cTrim(StrTool.unicodeToGBK(this.uWMessages)) + "|" + 
/*  746 */       StrTool.cTrim(StrTool.unicodeToGBK(this.uWGrade)) + "|" + 
/*  747 */       StrTool.cTrim(StrTool.unicodeToGBK(this.appGrade)) + "|" + 
/*  748 */       StrTool.cTrim(StrTool.unicodeToGBK(this.state)) + "|" + 
/*  749 */       StrTool.cTrim(StrTool.unicodeToGBK(this.upReportContent)) + "|" + 
/*  750 */       StrTool.cTrim(StrTool.unicodeToGBK(this.healthFlag)) + "|" + 
/*  751 */       StrTool.cTrim(StrTool.unicodeToGBK(this.quesFlag)) + "|" + 
/*  752 */       StrTool.cTrim(StrTool.unicodeToGBK(this.specFlag)) + "|" + 
/*  753 */       StrTool.cTrim(StrTool.unicodeToGBK(this.addPremFlag)) + "|" + 
/*  754 */       StrTool.cTrim(StrTool.unicodeToGBK(this.addPremReason)) + "|" + 
/*  755 */       StrTool.cTrim(StrTool.unicodeToGBK(this.specReason)) + "|" + 
/*  756 */       StrTool.cTrim(StrTool.unicodeToGBK(this.operator)) + "|" + 
/*  757 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makeDate))) + "|" + 
/*  758 */       StrTool.cTrim(StrTool.unicodeToGBK(this.makeTime)) + "|" + 
/*  759 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifyDate))) + "|" + 
/*  760 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifyTime));
/*  761 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  769 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  770 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  771 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  772 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  773 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  774 */       this.uWNo = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/*  775 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  776 */       this.uWDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/*  777 */       this.uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  778 */       this.uWerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  779 */       this.checkStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  780 */       this.appIsCompleted = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  781 */       this.appIsSubmitted = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  782 */       this.appDecision = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  783 */       this.autoUWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  784 */       this.uWMessages = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  785 */       this.uWGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  786 */       this.appGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  787 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  788 */       this.upReportContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  789 */       this.healthFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  790 */       this.quesFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  791 */       this.specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  792 */       this.addPremFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  793 */       this.addPremReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  794 */       this.specReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  795 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  796 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
/*  797 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*  798 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|"));
/*  799 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  804 */       CError tError = new CError();
/*  805 */       tError.moduleName = "LNPCUWMasterBSchema";
/*  806 */       tError.functionName = "decode";
/*  807 */       tError.errorMessage = ex.toString();
/*  808 */       this.mErrors.addOneError(tError);
/*      */ 
/*  810 */       return false;
/*      */     }
/*  812 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  818 */     String strReturn = "";
/*  819 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  821 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/*  823 */     if (FCode.equals("serialNo"))
/*      */     {
/*  825 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/*  827 */     if (FCode.equals("grpContNo"))
/*      */     {
/*  829 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  831 */     if (FCode.equals("contNo"))
/*      */     {
/*  833 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  835 */     if (FCode.equals("proposalContNo"))
/*      */     {
/*  837 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  839 */     if (FCode.equals("uWNo"))
/*      */     {
/*  841 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWNo));
/*      */     }
/*  843 */     if (FCode.equals("manageCom"))
/*      */     {
/*  845 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  847 */     if (FCode.equals("uWDate"))
/*      */     {
/*  849 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
/*      */     }
/*  851 */     if (FCode.equals("uWTime"))
/*      */     {
/*  853 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWTime));
/*      */     }
/*  855 */     if (FCode.equals("uWerName"))
/*      */     {
/*  857 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWerName));
/*      */     }
/*  859 */     if (FCode.equals("checkStatus"))
/*      */     {
/*  861 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkStatus));
/*      */     }
/*  863 */     if (FCode.equals("appIsCompleted"))
/*      */     {
/*  865 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appIsCompleted));
/*      */     }
/*  867 */     if (FCode.equals("appIsSubmitted"))
/*      */     {
/*  869 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appIsSubmitted));
/*      */     }
/*  871 */     if (FCode.equals("appDecision"))
/*      */     {
/*  873 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appDecision));
/*      */     }
/*  875 */     if (FCode.equals("autoUWFlag"))
/*      */     {
/*  877 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.autoUWFlag));
/*      */     }
/*  879 */     if (FCode.equals("uWMessages"))
/*      */     {
/*  881 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWMessages));
/*      */     }
/*  883 */     if (FCode.equals("uWGrade"))
/*      */     {
/*  885 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWGrade));
/*      */     }
/*  887 */     if (FCode.equals("appGrade"))
/*      */     {
/*  889 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.appGrade));
/*      */     }
/*  891 */     if (FCode.equals("state"))
/*      */     {
/*  893 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  895 */     if (FCode.equals("upReportContent"))
/*      */     {
/*  897 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.upReportContent));
/*      */     }
/*  899 */     if (FCode.equals("healthFlag"))
/*      */     {
/*  901 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.healthFlag));
/*      */     }
/*  903 */     if (FCode.equals("quesFlag"))
/*      */     {
/*  905 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.quesFlag));
/*      */     }
/*  907 */     if (FCode.equals("specFlag"))
/*      */     {
/*  909 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specFlag));
/*      */     }
/*  911 */     if (FCode.equals("addPremFlag"))
/*      */     {
/*  913 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addPremFlag));
/*      */     }
/*  915 */     if (FCode.equals("addPremReason"))
/*      */     {
/*  917 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addPremReason));
/*      */     }
/*  919 */     if (FCode.equals("specReason"))
/*      */     {
/*  921 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specReason));
/*      */     }
/*  923 */     if (FCode.equals("operator"))
/*      */     {
/*  925 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  927 */     if (FCode.equals("makeDate"))
/*      */     {
/*  929 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*      */     }
/*  931 */     if (FCode.equals("makeTime"))
/*      */     {
/*  933 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  935 */     if (FCode.equals("modifyDate"))
/*      */     {
/*  937 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*      */     }
/*  939 */     if (FCode.equals("modifyTime"))
/*      */     {
/*  941 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  943 */     if (strReturn.equals(""))
/*      */     {
/*  945 */       strReturn = "null";
/*      */     }
/*      */ 
/*  948 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  955 */     String strFieldValue = "";
/*  956 */     switch (nFieldIndex) {
/*      */     case 0:
/*  958 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/*  959 */       break;
/*      */     case 1:
/*  961 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/*  962 */       break;
/*      */     case 2:
/*  964 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  965 */       break;
/*      */     case 3:
/*  967 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  968 */       break;
/*      */     case 4:
/*  970 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  971 */       break;
/*      */     case 5:
/*  973 */       strFieldValue = String.valueOf(this.uWNo);
/*  974 */       break;
/*      */     case 6:
/*  976 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  977 */       break;
/*      */     case 7:
/*  979 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
/*  980 */       break;
/*      */     case 8:
/*  982 */       strFieldValue = StrTool.GBKToUnicode(this.uWTime);
/*  983 */       break;
/*      */     case 9:
/*  985 */       strFieldValue = StrTool.GBKToUnicode(this.uWerName);
/*  986 */       break;
/*      */     case 10:
/*  988 */       strFieldValue = StrTool.GBKToUnicode(this.checkStatus);
/*  989 */       break;
/*      */     case 11:
/*  991 */       strFieldValue = StrTool.GBKToUnicode(this.appIsCompleted);
/*  992 */       break;
/*      */     case 12:
/*  994 */       strFieldValue = StrTool.GBKToUnicode(this.appIsSubmitted);
/*  995 */       break;
/*      */     case 13:
/*  997 */       strFieldValue = StrTool.GBKToUnicode(this.appDecision);
/*  998 */       break;
/*      */     case 14:
/* 1000 */       strFieldValue = StrTool.GBKToUnicode(this.autoUWFlag);
/* 1001 */       break;
/*      */     case 15:
/* 1003 */       strFieldValue = StrTool.GBKToUnicode(this.uWMessages);
/* 1004 */       break;
/*      */     case 16:
/* 1006 */       strFieldValue = StrTool.GBKToUnicode(this.uWGrade);
/* 1007 */       break;
/*      */     case 17:
/* 1009 */       strFieldValue = StrTool.GBKToUnicode(this.appGrade);
/* 1010 */       break;
/*      */     case 18:
/* 1012 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 1013 */       break;
/*      */     case 19:
/* 1015 */       strFieldValue = StrTool.GBKToUnicode(this.upReportContent);
/* 1016 */       break;
/*      */     case 20:
/* 1018 */       strFieldValue = StrTool.GBKToUnicode(this.healthFlag);
/* 1019 */       break;
/*      */     case 21:
/* 1021 */       strFieldValue = StrTool.GBKToUnicode(this.quesFlag);
/* 1022 */       break;
/*      */     case 22:
/* 1024 */       strFieldValue = StrTool.GBKToUnicode(this.specFlag);
/* 1025 */       break;
/*      */     case 23:
/* 1027 */       strFieldValue = StrTool.GBKToUnicode(this.addPremFlag);
/* 1028 */       break;
/*      */     case 24:
/* 1030 */       strFieldValue = StrTool.GBKToUnicode(this.addPremReason);
/* 1031 */       break;
/*      */     case 25:
/* 1033 */       strFieldValue = StrTool.GBKToUnicode(this.specReason);
/* 1034 */       break;
/*      */     case 26:
/* 1036 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1037 */       break;
/*      */     case 27:
/* 1039 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/* 1040 */       break;
/*      */     case 28:
/* 1042 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1043 */       break;
/*      */     case 29:
/* 1045 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/* 1046 */       break;
/*      */     case 30:
/* 1048 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1049 */       break;
/*      */     default:
/* 1051 */       strFieldValue = "";
/*      */     }
/* 1053 */     if (strFieldValue.equals("")) {
/* 1054 */       strFieldValue = "null";
/*      */     }
/* 1056 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1062 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1063 */       return false;
/*      */     }
/* 1065 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 1067 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1069 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1072 */         this.EdorNo = null;
/*      */     }
/* 1074 */     if (FCode.equals("serialNo"))
/*      */     {
/* 1076 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1078 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/* 1081 */         this.serialNo = null;
/*      */     }
/* 1083 */     if (FCode.equals("grpContNo"))
/*      */     {
/* 1085 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1087 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1090 */         this.grpContNo = null;
/*      */     }
/* 1092 */     if (FCode.equals("contNo"))
/*      */     {
/* 1094 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1096 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 1099 */         this.contNo = null;
/*      */     }
/* 1101 */     if (FCode.equals("proposalContNo"))
/*      */     {
/* 1103 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1105 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1108 */         this.proposalContNo = null;
/*      */     }
/* 1110 */     if (FCode.equals("uWNo"))
/*      */     {
/* 1112 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1114 */         Integer tInteger = new Integer(FValue);
/* 1115 */         int i = tInteger.intValue();
/* 1116 */         this.uWNo = i;
/*      */       }
/*      */     }
/* 1119 */     if (FCode.equals("manageCom"))
/*      */     {
/* 1121 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1123 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1126 */         this.manageCom = null;
/*      */     }
/* 1128 */     if (FCode.equals("uWDate"))
/*      */     {
/* 1130 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1132 */         this.uWDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1135 */         this.uWDate = null;
/*      */     }
/* 1137 */     if (FCode.equals("uWTime"))
/*      */     {
/* 1139 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1141 */         this.uWTime = FValue.trim();
/*      */       }
/*      */       else
/* 1144 */         this.uWTime = null;
/*      */     }
/* 1146 */     if (FCode.equals("uWerName"))
/*      */     {
/* 1148 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1150 */         this.uWerName = FValue.trim();
/*      */       }
/*      */       else
/* 1153 */         this.uWerName = null;
/*      */     }
/* 1155 */     if (FCode.equals("checkStatus"))
/*      */     {
/* 1157 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1159 */         this.checkStatus = FValue.trim();
/*      */       }
/*      */       else
/* 1162 */         this.checkStatus = null;
/*      */     }
/* 1164 */     if (FCode.equals("appIsCompleted"))
/*      */     {
/* 1166 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1168 */         this.appIsCompleted = FValue.trim();
/*      */       }
/*      */       else
/* 1171 */         this.appIsCompleted = null;
/*      */     }
/* 1173 */     if (FCode.equals("appIsSubmitted"))
/*      */     {
/* 1175 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1177 */         this.appIsSubmitted = FValue.trim();
/*      */       }
/*      */       else
/* 1180 */         this.appIsSubmitted = null;
/*      */     }
/* 1182 */     if (FCode.equals("appDecision"))
/*      */     {
/* 1184 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1186 */         this.appDecision = FValue.trim();
/*      */       }
/*      */       else
/* 1189 */         this.appDecision = null;
/*      */     }
/* 1191 */     if (FCode.equals("autoUWFlag"))
/*      */     {
/* 1193 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1195 */         this.autoUWFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1198 */         this.autoUWFlag = null;
/*      */     }
/* 1200 */     if (FCode.equals("uWMessages"))
/*      */     {
/* 1202 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1204 */         this.uWMessages = FValue.trim();
/*      */       }
/*      */       else
/* 1207 */         this.uWMessages = null;
/*      */     }
/* 1209 */     if (FCode.equals("uWGrade"))
/*      */     {
/* 1211 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1213 */         this.uWGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1216 */         this.uWGrade = null;
/*      */     }
/* 1218 */     if (FCode.equals("appGrade"))
/*      */     {
/* 1220 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1222 */         this.appGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1225 */         this.appGrade = null;
/*      */     }
/* 1227 */     if (FCode.equals("state"))
/*      */     {
/* 1229 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1231 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 1234 */         this.state = null;
/*      */     }
/* 1236 */     if (FCode.equals("upReportContent"))
/*      */     {
/* 1238 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1240 */         this.upReportContent = FValue.trim();
/*      */       }
/*      */       else
/* 1243 */         this.upReportContent = null;
/*      */     }
/* 1245 */     if (FCode.equals("healthFlag"))
/*      */     {
/* 1247 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1249 */         this.healthFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1252 */         this.healthFlag = null;
/*      */     }
/* 1254 */     if (FCode.equals("quesFlag"))
/*      */     {
/* 1256 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1258 */         this.quesFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1261 */         this.quesFlag = null;
/*      */     }
/* 1263 */     if (FCode.equals("specFlag"))
/*      */     {
/* 1265 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1267 */         this.specFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1270 */         this.specFlag = null;
/*      */     }
/* 1272 */     if (FCode.equals("addPremFlag"))
/*      */     {
/* 1274 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1276 */         this.addPremFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1279 */         this.addPremFlag = null;
/*      */     }
/* 1281 */     if (FCode.equals("addPremReason"))
/*      */     {
/* 1283 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1285 */         this.addPremReason = FValue.trim();
/*      */       }
/*      */       else
/* 1288 */         this.addPremReason = null;
/*      */     }
/* 1290 */     if (FCode.equals("specReason"))
/*      */     {
/* 1292 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1294 */         this.specReason = FValue.trim();
/*      */       }
/*      */       else
/* 1297 */         this.specReason = null;
/*      */     }
/* 1299 */     if (FCode.equals("operator"))
/*      */     {
/* 1301 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1303 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1306 */         this.operator = null;
/*      */     }
/* 1308 */     if (FCode.equals("makeDate"))
/*      */     {
/* 1310 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1312 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1315 */         this.makeDate = null;
/*      */     }
/* 1317 */     if (FCode.equals("makeTime"))
/*      */     {
/* 1319 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1321 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1324 */         this.makeTime = null;
/*      */     }
/* 1326 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 1328 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1330 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1333 */         this.modifyDate = null;
/*      */     }
/* 1335 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 1337 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1339 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1342 */         this.modifyTime = null;
/*      */     }
/* 1344 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1349 */     if (this == otherObject) return true;
/* 1350 */     if (otherObject == null) return false;
/* 1351 */     if (getClass() != otherObject.getClass()) return false;
/* 1352 */     LNPCUWMasterBSchema other = (LNPCUWMasterBSchema)otherObject;
/* 1353 */     return 
/* 1354 */       (this.EdorNo.equals(other.getEdorNo())) && 
/* 1355 */       (this.serialNo.equals(other.getserialNo())) && 
/* 1356 */       (this.grpContNo.equals(other.getgrpContNo())) && 
/* 1357 */       (this.contNo.equals(other.getcontNo())) && 
/* 1358 */       (this.proposalContNo.equals(other.getproposalContNo())) && 
/* 1359 */       (this.uWNo == other.getuWNo()) && 
/* 1360 */       (this.manageCom.equals(other.getmanageCom())) && 
/* 1361 */       (this.fDate.getString(this.uWDate).equals(other.getuWDate())) && 
/* 1362 */       (this.uWTime.equals(other.getuWTime())) && 
/* 1363 */       (this.uWerName.equals(other.getuWerName())) && 
/* 1364 */       (this.checkStatus.equals(other.getcheckStatus())) && 
/* 1365 */       (this.appIsCompleted.equals(other.getappIsCompleted())) && 
/* 1366 */       (this.appIsSubmitted.equals(other.getappIsSubmitted())) && 
/* 1367 */       (this.appDecision.equals(other.getappDecision())) && 
/* 1368 */       (this.autoUWFlag.equals(other.getautoUWFlag())) && 
/* 1369 */       (this.uWMessages.equals(other.getuWMessages())) && 
/* 1370 */       (this.uWGrade.equals(other.getuWGrade())) && 
/* 1371 */       (this.appGrade.equals(other.getappGrade())) && 
/* 1372 */       (this.state.equals(other.getstate())) && 
/* 1373 */       (this.upReportContent.equals(other.getupReportContent())) && 
/* 1374 */       (this.healthFlag.equals(other.gethealthFlag())) && 
/* 1375 */       (this.quesFlag.equals(other.getquesFlag())) && 
/* 1376 */       (this.specFlag.equals(other.getspecFlag())) && 
/* 1377 */       (this.addPremFlag.equals(other.getaddPremFlag())) && 
/* 1378 */       (this.addPremReason.equals(other.getaddPremReason())) && 
/* 1379 */       (this.specReason.equals(other.getspecReason())) && 
/* 1380 */       (this.operator.equals(other.getoperator())) && 
/* 1381 */       (this.fDate.getString(this.makeDate).equals(other.getmakeDate())) && 
/* 1382 */       (this.makeTime.equals(other.getmakeTime())) && 
/* 1383 */       (this.fDate.getString(this.modifyDate).equals(other.getmodifyDate())) && 
/* 1384 */       (this.modifyTime.equals(other.getmodifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1390 */     return 31;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1396 */     if (strFieldName.equals("EdorNo")) {
/* 1397 */       return 0;
/*      */     }
/* 1399 */     if (strFieldName.equals("serialNo")) {
/* 1400 */       return 1;
/*      */     }
/* 1402 */     if (strFieldName.equals("grpContNo")) {
/* 1403 */       return 2;
/*      */     }
/* 1405 */     if (strFieldName.equals("contNo")) {
/* 1406 */       return 3;
/*      */     }
/* 1408 */     if (strFieldName.equals("proposalContNo")) {
/* 1409 */       return 4;
/*      */     }
/* 1411 */     if (strFieldName.equals("uWNo")) {
/* 1412 */       return 5;
/*      */     }
/* 1414 */     if (strFieldName.equals("manageCom")) {
/* 1415 */       return 6;
/*      */     }
/* 1417 */     if (strFieldName.equals("uWDate")) {
/* 1418 */       return 7;
/*      */     }
/* 1420 */     if (strFieldName.equals("uWTime")) {
/* 1421 */       return 8;
/*      */     }
/* 1423 */     if (strFieldName.equals("uWerName")) {
/* 1424 */       return 9;
/*      */     }
/* 1426 */     if (strFieldName.equals("checkStatus")) {
/* 1427 */       return 10;
/*      */     }
/* 1429 */     if (strFieldName.equals("appIsCompleted")) {
/* 1430 */       return 11;
/*      */     }
/* 1432 */     if (strFieldName.equals("appIsSubmitted")) {
/* 1433 */       return 12;
/*      */     }
/* 1435 */     if (strFieldName.equals("appDecision")) {
/* 1436 */       return 13;
/*      */     }
/* 1438 */     if (strFieldName.equals("autoUWFlag")) {
/* 1439 */       return 14;
/*      */     }
/* 1441 */     if (strFieldName.equals("uWMessages")) {
/* 1442 */       return 15;
/*      */     }
/* 1444 */     if (strFieldName.equals("uWGrade")) {
/* 1445 */       return 16;
/*      */     }
/* 1447 */     if (strFieldName.equals("appGrade")) {
/* 1448 */       return 17;
/*      */     }
/* 1450 */     if (strFieldName.equals("state")) {
/* 1451 */       return 18;
/*      */     }
/* 1453 */     if (strFieldName.equals("upReportContent")) {
/* 1454 */       return 19;
/*      */     }
/* 1456 */     if (strFieldName.equals("healthFlag")) {
/* 1457 */       return 20;
/*      */     }
/* 1459 */     if (strFieldName.equals("quesFlag")) {
/* 1460 */       return 21;
/*      */     }
/* 1462 */     if (strFieldName.equals("specFlag")) {
/* 1463 */       return 22;
/*      */     }
/* 1465 */     if (strFieldName.equals("addPremFlag")) {
/* 1466 */       return 23;
/*      */     }
/* 1468 */     if (strFieldName.equals("addPremReason")) {
/* 1469 */       return 24;
/*      */     }
/* 1471 */     if (strFieldName.equals("specReason")) {
/* 1472 */       return 25;
/*      */     }
/* 1474 */     if (strFieldName.equals("operator")) {
/* 1475 */       return 26;
/*      */     }
/* 1477 */     if (strFieldName.equals("makeDate")) {
/* 1478 */       return 27;
/*      */     }
/* 1480 */     if (strFieldName.equals("makeTime")) {
/* 1481 */       return 28;
/*      */     }
/* 1483 */     if (strFieldName.equals("modifyDate")) {
/* 1484 */       return 29;
/*      */     }
/* 1486 */     if (strFieldName.equals("modifyTime")) {
/* 1487 */       return 30;
/*      */     }
/* 1489 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1495 */     String strFieldName = "";
/* 1496 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1498 */       strFieldName = "EdorNo";
/* 1499 */       break;
/*      */     case 1:
/* 1501 */       strFieldName = "serialNo";
/* 1502 */       break;
/*      */     case 2:
/* 1504 */       strFieldName = "grpContNo";
/* 1505 */       break;
/*      */     case 3:
/* 1507 */       strFieldName = "contNo";
/* 1508 */       break;
/*      */     case 4:
/* 1510 */       strFieldName = "proposalContNo";
/* 1511 */       break;
/*      */     case 5:
/* 1513 */       strFieldName = "uWNo";
/* 1514 */       break;
/*      */     case 6:
/* 1516 */       strFieldName = "manageCom";
/* 1517 */       break;
/*      */     case 7:
/* 1519 */       strFieldName = "uWDate";
/* 1520 */       break;
/*      */     case 8:
/* 1522 */       strFieldName = "uWTime";
/* 1523 */       break;
/*      */     case 9:
/* 1525 */       strFieldName = "uWerName";
/* 1526 */       break;
/*      */     case 10:
/* 1528 */       strFieldName = "checkStatus";
/* 1529 */       break;
/*      */     case 11:
/* 1531 */       strFieldName = "appIsCompleted";
/* 1532 */       break;
/*      */     case 12:
/* 1534 */       strFieldName = "appIsSubmitted";
/* 1535 */       break;
/*      */     case 13:
/* 1537 */       strFieldName = "appDecision";
/* 1538 */       break;
/*      */     case 14:
/* 1540 */       strFieldName = "autoUWFlag";
/* 1541 */       break;
/*      */     case 15:
/* 1543 */       strFieldName = "uWMessages";
/* 1544 */       break;
/*      */     case 16:
/* 1546 */       strFieldName = "uWGrade";
/* 1547 */       break;
/*      */     case 17:
/* 1549 */       strFieldName = "appGrade";
/* 1550 */       break;
/*      */     case 18:
/* 1552 */       strFieldName = "state";
/* 1553 */       break;
/*      */     case 19:
/* 1555 */       strFieldName = "upReportContent";
/* 1556 */       break;
/*      */     case 20:
/* 1558 */       strFieldName = "healthFlag";
/* 1559 */       break;
/*      */     case 21:
/* 1561 */       strFieldName = "quesFlag";
/* 1562 */       break;
/*      */     case 22:
/* 1564 */       strFieldName = "specFlag";
/* 1565 */       break;
/*      */     case 23:
/* 1567 */       strFieldName = "addPremFlag";
/* 1568 */       break;
/*      */     case 24:
/* 1570 */       strFieldName = "addPremReason";
/* 1571 */       break;
/*      */     case 25:
/* 1573 */       strFieldName = "specReason";
/* 1574 */       break;
/*      */     case 26:
/* 1576 */       strFieldName = "operator";
/* 1577 */       break;
/*      */     case 27:
/* 1579 */       strFieldName = "makeDate";
/* 1580 */       break;
/*      */     case 28:
/* 1582 */       strFieldName = "makeTime";
/* 1583 */       break;
/*      */     case 29:
/* 1585 */       strFieldName = "modifyDate";
/* 1586 */       break;
/*      */     case 30:
/* 1588 */       strFieldName = "modifyTime";
/* 1589 */       break;
/*      */     default:
/* 1591 */       strFieldName = "";
/*      */     }
/* 1593 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1599 */     if (strFieldName.equals("EdorNo")) {
/* 1600 */       return 0;
/*      */     }
/* 1602 */     if (strFieldName.equals("serialNo")) {
/* 1603 */       return 0;
/*      */     }
/* 1605 */     if (strFieldName.equals("grpContNo")) {
/* 1606 */       return 0;
/*      */     }
/* 1608 */     if (strFieldName.equals("contNo")) {
/* 1609 */       return 0;
/*      */     }
/* 1611 */     if (strFieldName.equals("proposalContNo")) {
/* 1612 */       return 0;
/*      */     }
/* 1614 */     if (strFieldName.equals("uWNo")) {
/* 1615 */       return 3;
/*      */     }
/* 1617 */     if (strFieldName.equals("manageCom")) {
/* 1618 */       return 0;
/*      */     }
/* 1620 */     if (strFieldName.equals("uWDate")) {
/* 1621 */       return 1;
/*      */     }
/* 1623 */     if (strFieldName.equals("uWTime")) {
/* 1624 */       return 0;
/*      */     }
/* 1626 */     if (strFieldName.equals("uWerName")) {
/* 1627 */       return 0;
/*      */     }
/* 1629 */     if (strFieldName.equals("checkStatus")) {
/* 1630 */       return 0;
/*      */     }
/* 1632 */     if (strFieldName.equals("appIsCompleted")) {
/* 1633 */       return 0;
/*      */     }
/* 1635 */     if (strFieldName.equals("appIsSubmitted")) {
/* 1636 */       return 0;
/*      */     }
/* 1638 */     if (strFieldName.equals("appDecision")) {
/* 1639 */       return 0;
/*      */     }
/* 1641 */     if (strFieldName.equals("autoUWFlag")) {
/* 1642 */       return 0;
/*      */     }
/* 1644 */     if (strFieldName.equals("uWMessages")) {
/* 1645 */       return 0;
/*      */     }
/* 1647 */     if (strFieldName.equals("uWGrade")) {
/* 1648 */       return 0;
/*      */     }
/* 1650 */     if (strFieldName.equals("appGrade")) {
/* 1651 */       return 0;
/*      */     }
/* 1653 */     if (strFieldName.equals("state")) {
/* 1654 */       return 0;
/*      */     }
/* 1656 */     if (strFieldName.equals("upReportContent")) {
/* 1657 */       return 0;
/*      */     }
/* 1659 */     if (strFieldName.equals("healthFlag")) {
/* 1660 */       return 0;
/*      */     }
/* 1662 */     if (strFieldName.equals("quesFlag")) {
/* 1663 */       return 0;
/*      */     }
/* 1665 */     if (strFieldName.equals("specFlag")) {
/* 1666 */       return 0;
/*      */     }
/* 1668 */     if (strFieldName.equals("addPremFlag")) {
/* 1669 */       return 0;
/*      */     }
/* 1671 */     if (strFieldName.equals("addPremReason")) {
/* 1672 */       return 0;
/*      */     }
/* 1674 */     if (strFieldName.equals("specReason")) {
/* 1675 */       return 0;
/*      */     }
/* 1677 */     if (strFieldName.equals("operator")) {
/* 1678 */       return 0;
/*      */     }
/* 1680 */     if (strFieldName.equals("makeDate")) {
/* 1681 */       return 1;
/*      */     }
/* 1683 */     if (strFieldName.equals("makeTime")) {
/* 1684 */       return 0;
/*      */     }
/* 1686 */     if (strFieldName.equals("modifyDate")) {
/* 1687 */       return 1;
/*      */     }
/* 1689 */     if (strFieldName.equals("modifyTime")) {
/* 1690 */       return 0;
/*      */     }
/* 1692 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1698 */     int nFieldType = -1;
/* 1699 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1701 */       nFieldType = 0;
/* 1702 */       break;
/*      */     case 1:
/* 1704 */       nFieldType = 0;
/* 1705 */       break;
/*      */     case 2:
/* 1707 */       nFieldType = 0;
/* 1708 */       break;
/*      */     case 3:
/* 1710 */       nFieldType = 0;
/* 1711 */       break;
/*      */     case 4:
/* 1713 */       nFieldType = 0;
/* 1714 */       break;
/*      */     case 5:
/* 1716 */       nFieldType = 3;
/* 1717 */       break;
/*      */     case 6:
/* 1719 */       nFieldType = 0;
/* 1720 */       break;
/*      */     case 7:
/* 1722 */       nFieldType = 1;
/* 1723 */       break;
/*      */     case 8:
/* 1725 */       nFieldType = 0;
/* 1726 */       break;
/*      */     case 9:
/* 1728 */       nFieldType = 0;
/* 1729 */       break;
/*      */     case 10:
/* 1731 */       nFieldType = 0;
/* 1732 */       break;
/*      */     case 11:
/* 1734 */       nFieldType = 0;
/* 1735 */       break;
/*      */     case 12:
/* 1737 */       nFieldType = 0;
/* 1738 */       break;
/*      */     case 13:
/* 1740 */       nFieldType = 0;
/* 1741 */       break;
/*      */     case 14:
/* 1743 */       nFieldType = 0;
/* 1744 */       break;
/*      */     case 15:
/* 1746 */       nFieldType = 0;
/* 1747 */       break;
/*      */     case 16:
/* 1749 */       nFieldType = 0;
/* 1750 */       break;
/*      */     case 17:
/* 1752 */       nFieldType = 0;
/* 1753 */       break;
/*      */     case 18:
/* 1755 */       nFieldType = 0;
/* 1756 */       break;
/*      */     case 19:
/* 1758 */       nFieldType = 0;
/* 1759 */       break;
/*      */     case 20:
/* 1761 */       nFieldType = 0;
/* 1762 */       break;
/*      */     case 21:
/* 1764 */       nFieldType = 0;
/* 1765 */       break;
/*      */     case 22:
/* 1767 */       nFieldType = 0;
/* 1768 */       break;
/*      */     case 23:
/* 1770 */       nFieldType = 0;
/* 1771 */       break;
/*      */     case 24:
/* 1773 */       nFieldType = 0;
/* 1774 */       break;
/*      */     case 25:
/* 1776 */       nFieldType = 0;
/* 1777 */       break;
/*      */     case 26:
/* 1779 */       nFieldType = 0;
/* 1780 */       break;
/*      */     case 27:
/* 1782 */       nFieldType = 1;
/* 1783 */       break;
/*      */     case 28:
/* 1785 */       nFieldType = 0;
/* 1786 */       break;
/*      */     case 29:
/* 1788 */       nFieldType = 1;
/* 1789 */       break;
/*      */     case 30:
/* 1791 */       nFieldType = 0;
/* 1792 */       break;
/*      */     default:
/* 1794 */       nFieldType = -1;
/*      */     }
/* 1796 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPCUWMasterBSchema
 * JD-Core Version:    0.6.0
 */