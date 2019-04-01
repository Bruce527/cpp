/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MUserBDB;
/*      */ import com.sinosoft.map.lis.pubfun.FDate;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.Schema;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class MUserBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String userCode;
/*      */   private String userName;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String password;
/*      */   private Date pwdModifyDate;
/*      */   private String userDescription;
/*      */   private String userState;
/*      */   private String superPopedomFlag;
/*      */   private Date validStartDate;
/*      */   private Date validEndDate;
/*      */   private String stuffNo;
/*      */   private String officePhone;
/*      */   private String phone;
/*      */   private String eMail;
/*      */   private String operator;
/*      */   private String modifyOperator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   public static final int FIELDNUM = 27;
/*      */   private static String[] PK;
/*   78 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MUserBSchema()
/*      */   {
/*   85 */     this.mErrors = new CErrors();
/*      */ 
/*   87 */     String[] pk = new String[1];
/*   88 */     pk[0] = "EdorNo";
/*      */ 
/*   90 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   97 */     MUserBSchema cloned = (MUserBSchema)super.clone();
/*   98 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   99 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  100 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  106 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getUserCode()
/*      */   {
/*  111 */     return this.userCode;
/*      */   }
/*      */ 
/*      */   public void setUserCode(String aUserCode) {
/*  115 */     this.userCode = aUserCode;
/*      */   }
/*      */ 
/*      */   public String getUserName() {
/*  119 */     return this.userName;
/*      */   }
/*      */ 
/*      */   public void setUserName(String aUserName) {
/*  123 */     this.userName = aUserName;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  127 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  131 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  135 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  139 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getPassword() {
/*  143 */     return this.password;
/*      */   }
/*      */ 
/*      */   public void setPassword(String aPassword) {
/*  147 */     this.password = aPassword;
/*      */   }
/*      */ 
/*      */   public String getPwdModifyDate() {
/*  151 */     if (this.pwdModifyDate != null) {
/*  152 */       return this.fDate.getString(this.pwdModifyDate);
/*      */     }
/*  154 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPwdModifyDate(Date aPwdModifyDate) {
/*  158 */     this.pwdModifyDate = aPwdModifyDate;
/*      */   }
/*      */ 
/*      */   public void setPwdModifyDate(String aPwdModifyDate) {
/*  162 */     if ((aPwdModifyDate != null) && (!aPwdModifyDate.equals("")))
/*      */     {
/*  164 */       this.pwdModifyDate = this.fDate.getDate(aPwdModifyDate);
/*      */     }
/*      */     else
/*  167 */       this.pwdModifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getUserDescription()
/*      */   {
/*  172 */     return this.userDescription;
/*      */   }
/*      */ 
/*      */   public void setUserDescription(String aUserDescription) {
/*  176 */     this.userDescription = aUserDescription;
/*      */   }
/*      */ 
/*      */   public String getUserState() {
/*  180 */     return this.userState;
/*      */   }
/*      */ 
/*      */   public void setUserState(String aUserState) {
/*  184 */     this.userState = aUserState;
/*      */   }
/*      */ 
/*      */   public String getSuperPopedomFlag() {
/*  188 */     return this.superPopedomFlag;
/*      */   }
/*      */ 
/*      */   public void setSuperPopedomFlag(String aSuperPopedomFlag) {
/*  192 */     this.superPopedomFlag = aSuperPopedomFlag;
/*      */   }
/*      */ 
/*      */   public String getValidStartDate() {
/*  196 */     if (this.validStartDate != null) {
/*  197 */       return this.fDate.getString(this.validStartDate);
/*      */     }
/*  199 */     return null;
/*      */   }
/*      */ 
/*      */   public void setValidStartDate(Date aValidStartDate) {
/*  203 */     this.validStartDate = aValidStartDate;
/*      */   }
/*      */ 
/*      */   public void setValidStartDate(String aValidStartDate) {
/*  207 */     if ((aValidStartDate != null) && (!aValidStartDate.equals("")))
/*      */     {
/*  209 */       this.validStartDate = this.fDate.getDate(aValidStartDate);
/*      */     }
/*      */     else
/*  212 */       this.validStartDate = null;
/*      */   }
/*      */ 
/*      */   public String getValidEndDate()
/*      */   {
/*  217 */     if (this.validEndDate != null) {
/*  218 */       return this.fDate.getString(this.validEndDate);
/*      */     }
/*  220 */     return null;
/*      */   }
/*      */ 
/*      */   public void setValidEndDate(Date aValidEndDate) {
/*  224 */     this.validEndDate = aValidEndDate;
/*      */   }
/*      */ 
/*      */   public void setValidEndDate(String aValidEndDate) {
/*  228 */     if ((aValidEndDate != null) && (!aValidEndDate.equals("")))
/*      */     {
/*  230 */       this.validEndDate = this.fDate.getDate(aValidEndDate);
/*      */     }
/*      */     else
/*  233 */       this.validEndDate = null;
/*      */   }
/*      */ 
/*      */   public String getStuffNo()
/*      */   {
/*  238 */     return this.stuffNo;
/*      */   }
/*      */ 
/*      */   public void setStuffNo(String aStuffNo) {
/*  242 */     this.stuffNo = aStuffNo;
/*      */   }
/*      */ 
/*      */   public String getOfficePhone() {
/*  246 */     return this.officePhone;
/*      */   }
/*      */ 
/*      */   public void setOfficePhone(String aOfficePhone) {
/*  250 */     this.officePhone = aOfficePhone;
/*      */   }
/*      */ 
/*      */   public String getPhone() {
/*  254 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setPhone(String aPhone) {
/*  258 */     this.phone = aPhone;
/*      */   }
/*      */ 
/*      */   public String getEMail() {
/*  262 */     return this.eMail;
/*      */   }
/*      */ 
/*      */   public void setEMail(String aEMail) {
/*  266 */     this.eMail = aEMail;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  270 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  274 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator() {
/*  278 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  282 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  286 */     if (this.makeDate != null) {
/*  287 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  289 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  293 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  297 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  299 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  302 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  307 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  311 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  315 */     if (this.modifyDate != null) {
/*  316 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  318 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  322 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  326 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  328 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  331 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  336 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  340 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  344 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  348 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  352 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  356 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  360 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  364 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  368 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  372 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  376 */     if (this.makeDate2 != null) {
/*  377 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  379 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  383 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  387 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  389 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  392 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  397 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  401 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public void setSchema(MUserBSchema aMUserBSchema)
/*      */   {
/*  407 */     this.userCode = aMUserBSchema.getUserCode();
/*  408 */     this.userName = aMUserBSchema.getUserName();
/*  409 */     this.manageCom = aMUserBSchema.getManageCom();
/*  410 */     this.branchType = aMUserBSchema.getBranchType();
/*  411 */     this.password = aMUserBSchema.getPassword();
/*  412 */     this.pwdModifyDate = this.fDate.getDate(aMUserBSchema.getPwdModifyDate());
/*  413 */     this.userDescription = aMUserBSchema.getUserDescription();
/*  414 */     this.userState = aMUserBSchema.getUserState();
/*  415 */     this.superPopedomFlag = aMUserBSchema.getSuperPopedomFlag();
/*  416 */     this.validStartDate = this.fDate.getDate(aMUserBSchema.getValidStartDate());
/*  417 */     this.validEndDate = this.fDate.getDate(aMUserBSchema.getValidEndDate());
/*  418 */     this.stuffNo = aMUserBSchema.getStuffNo();
/*  419 */     this.officePhone = aMUserBSchema.getOfficePhone();
/*  420 */     this.phone = aMUserBSchema.getPhone();
/*  421 */     this.eMail = aMUserBSchema.getEMail();
/*  422 */     this.operator = aMUserBSchema.getOperator();
/*  423 */     this.modifyOperator = aMUserBSchema.getModifyOperator();
/*  424 */     this.makeDate = this.fDate.getDate(aMUserBSchema.getMakeDate());
/*  425 */     this.makeTime = aMUserBSchema.getMakeTime();
/*  426 */     this.modifyDate = this.fDate.getDate(aMUserBSchema.getModifyDate());
/*  427 */     this.modifyTime = aMUserBSchema.getModifyTime();
/*  428 */     this.edorNo = aMUserBSchema.getEdorNo();
/*  429 */     this.edorType = aMUserBSchema.getEdorType();
/*  430 */     this.edorCase = aMUserBSchema.getEdorCase();
/*  431 */     this.operator2 = aMUserBSchema.getOperator2();
/*  432 */     this.makeDate2 = this.fDate.getDate(aMUserBSchema.getMakeDate2());
/*  433 */     this.makeTime2 = aMUserBSchema.getMakeTime2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  442 */       if (rs.getString("UserCode") == null)
/*  443 */         this.userCode = null;
/*      */       else {
/*  445 */         this.userCode = rs.getString("UserCode").trim();
/*      */       }
/*  447 */       if (rs.getString("UserName") == null)
/*  448 */         this.userName = null;
/*      */       else {
/*  450 */         this.userName = rs.getString("UserName").trim();
/*      */       }
/*  452 */       if (rs.getString("ManageCom") == null)
/*  453 */         this.manageCom = null;
/*      */       else {
/*  455 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  457 */       if (rs.getString("BranchType") == null)
/*  458 */         this.branchType = null;
/*      */       else {
/*  460 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  462 */       if (rs.getString("Password") == null)
/*  463 */         this.password = null;
/*      */       else {
/*  465 */         this.password = rs.getString("Password").trim();
/*      */       }
/*  467 */       this.pwdModifyDate = rs.getDate("PwdModifyDate");
/*  468 */       if (rs.getString("UserDescription") == null)
/*  469 */         this.userDescription = null;
/*      */       else {
/*  471 */         this.userDescription = rs.getString("UserDescription").trim();
/*      */       }
/*  473 */       if (rs.getString("UserState") == null)
/*  474 */         this.userState = null;
/*      */       else {
/*  476 */         this.userState = rs.getString("UserState").trim();
/*      */       }
/*  478 */       if (rs.getString("SuperPopedomFlag") == null)
/*  479 */         this.superPopedomFlag = null;
/*      */       else {
/*  481 */         this.superPopedomFlag = rs.getString("SuperPopedomFlag").trim();
/*      */       }
/*  483 */       this.validStartDate = rs.getDate("ValidStartDate");
/*  484 */       this.validEndDate = rs.getDate("ValidEndDate");
/*  485 */       if (rs.getString("StuffNo") == null)
/*  486 */         this.stuffNo = null;
/*      */       else {
/*  488 */         this.stuffNo = rs.getString("StuffNo").trim();
/*      */       }
/*  490 */       if (rs.getString("OfficePhone") == null)
/*  491 */         this.officePhone = null;
/*      */       else {
/*  493 */         this.officePhone = rs.getString("OfficePhone").trim();
/*      */       }
/*  495 */       if (rs.getString("Phone") == null)
/*  496 */         this.phone = null;
/*      */       else {
/*  498 */         this.phone = rs.getString("Phone").trim();
/*      */       }
/*  500 */       if (rs.getString("EMail") == null)
/*  501 */         this.eMail = null;
/*      */       else {
/*  503 */         this.eMail = rs.getString("EMail").trim();
/*      */       }
/*  505 */       if (rs.getString("Operator") == null)
/*  506 */         this.operator = null;
/*      */       else {
/*  508 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  510 */       if (rs.getString("ModifyOperator") == null)
/*  511 */         this.modifyOperator = null;
/*      */       else {
/*  513 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  515 */       this.makeDate = rs.getDate("MakeDate");
/*  516 */       if (rs.getString("MakeTime") == null)
/*  517 */         this.makeTime = null;
/*      */       else {
/*  519 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  521 */       this.modifyDate = rs.getDate("ModifyDate");
/*  522 */       if (rs.getString("ModifyTime") == null)
/*  523 */         this.modifyTime = null;
/*      */       else {
/*  525 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  527 */       if (rs.getString("EdorNo") == null)
/*  528 */         this.edorNo = null;
/*      */       else {
/*  530 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  532 */       if (rs.getString("EdorType") == null)
/*  533 */         this.edorType = null;
/*      */       else {
/*  535 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  537 */       if (rs.getString("EdorCase") == null)
/*  538 */         this.edorCase = null;
/*      */       else {
/*  540 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  542 */       if (rs.getString("Operator2") == null)
/*  543 */         this.operator2 = null;
/*      */       else {
/*  545 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  547 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  548 */       if (rs.getString("MakeTime2") == null)
/*  549 */         this.makeTime2 = null;
/*      */       else {
/*  551 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  556 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MUserB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  558 */       CError tError = new CError();
/*  559 */       tError.moduleName = "MUserBSchema";
/*  560 */       tError.functionName = "setSchema";
/*  561 */       tError.errorMessage = sqle.toString();
/*  562 */       this.mErrors.addOneError(tError);
/*  563 */       return false;
/*      */     }
/*  565 */     return true;
/*      */   }
/*      */ 
/*      */   public MUserBSchema getSchema()
/*      */   {
/*  570 */     MUserBSchema aMUserBSchema = new MUserBSchema();
/*  571 */     aMUserBSchema.setSchema(this);
/*  572 */     return aMUserBSchema;
/*      */   }
/*      */ 
/*      */   public MUserBDB getDB()
/*      */   {
/*  577 */     MUserBDB aDBOper = new MUserBDB();
/*  578 */     aDBOper.setSchema(this);
/*  579 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  586 */     StringBuffer strReturn = new StringBuffer(256);
/*  587 */     strReturn.append(StrTool.cTrim(this.userCode)); strReturn.append("|");
/*  588 */     strReturn.append(StrTool.cTrim(this.userName)); strReturn.append("|");
/*  589 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  590 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  591 */     strReturn.append(StrTool.cTrim(this.password)); strReturn.append("|");
/*  592 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.pwdModifyDate))); strReturn.append("|");
/*  593 */     strReturn.append(StrTool.cTrim(this.userDescription)); strReturn.append("|");
/*  594 */     strReturn.append(StrTool.cTrim(this.userState)); strReturn.append("|");
/*  595 */     strReturn.append(StrTool.cTrim(this.superPopedomFlag)); strReturn.append("|");
/*  596 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.validStartDate))); strReturn.append("|");
/*  597 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.validEndDate))); strReturn.append("|");
/*  598 */     strReturn.append(StrTool.cTrim(this.stuffNo)); strReturn.append("|");
/*  599 */     strReturn.append(StrTool.cTrim(this.officePhone)); strReturn.append("|");
/*  600 */     strReturn.append(StrTool.cTrim(this.phone)); strReturn.append("|");
/*  601 */     strReturn.append(StrTool.cTrim(this.eMail)); strReturn.append("|");
/*  602 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  603 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  604 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  605 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  606 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  607 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  608 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  609 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  610 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  611 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  612 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  613 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/*  614 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  622 */       this.userCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  623 */       this.userName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  624 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  625 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  626 */       this.password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  627 */       this.pwdModifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/*  628 */       this.userDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  629 */       this.userState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  630 */       this.superPopedomFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  631 */       this.validStartDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*  632 */       this.validEndDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
/*  633 */       this.stuffNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  634 */       this.officePhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  635 */       this.phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  636 */       this.eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  637 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  638 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  639 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*  640 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  641 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  642 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  643 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  644 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  645 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  646 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  647 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|"));
/*  648 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  653 */       CError tError = new CError();
/*  654 */       tError.moduleName = "MUserBSchema";
/*  655 */       tError.functionName = "decode";
/*  656 */       tError.errorMessage = ex.toString();
/*  657 */       this.mErrors.addOneError(tError);
/*      */ 
/*  659 */       return false;
/*      */     }
/*  661 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  667 */     String strReturn = "";
/*  668 */     if (FCode.equalsIgnoreCase("userCode"))
/*      */     {
/*  670 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userCode));
/*      */     }
/*  672 */     if (FCode.equalsIgnoreCase("userName"))
/*      */     {
/*  674 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userName));
/*      */     }
/*  676 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  678 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  680 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  682 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  684 */     if (FCode.equalsIgnoreCase("password"))
/*      */     {
/*  686 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.password));
/*      */     }
/*  688 */     if (FCode.equalsIgnoreCase("pwdModifyDate"))
/*      */     {
/*  690 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPwdModifyDate()));
/*      */     }
/*  692 */     if (FCode.equalsIgnoreCase("userDescription"))
/*      */     {
/*  694 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userDescription));
/*      */     }
/*  696 */     if (FCode.equalsIgnoreCase("userState"))
/*      */     {
/*  698 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userState));
/*      */     }
/*  700 */     if (FCode.equalsIgnoreCase("superPopedomFlag"))
/*      */     {
/*  702 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.superPopedomFlag));
/*      */     }
/*  704 */     if (FCode.equalsIgnoreCase("validStartDate"))
/*      */     {
/*  706 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getValidStartDate()));
/*      */     }
/*  708 */     if (FCode.equalsIgnoreCase("validEndDate"))
/*      */     {
/*  710 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getValidEndDate()));
/*      */     }
/*  712 */     if (FCode.equalsIgnoreCase("stuffNo"))
/*      */     {
/*  714 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stuffNo));
/*      */     }
/*  716 */     if (FCode.equalsIgnoreCase("officePhone"))
/*      */     {
/*  718 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.officePhone));
/*      */     }
/*  720 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/*  722 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.phone));
/*      */     }
/*  724 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/*  726 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.eMail));
/*      */     }
/*  728 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  730 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  732 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  734 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  736 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  738 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  740 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  742 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  744 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  746 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  748 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  750 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  752 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  754 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  756 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  758 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  760 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  762 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  764 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  766 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  768 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  770 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  772 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  774 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  776 */     if (strReturn.equals(""))
/*      */     {
/*  778 */       strReturn = "null";
/*      */     }
/*      */ 
/*  781 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  788 */     String strFieldValue = "";
/*  789 */     switch (nFieldIndex) {
/*      */     case 0:
/*  791 */       strFieldValue = StrTool.GBKToUnicode(this.userCode);
/*  792 */       break;
/*      */     case 1:
/*  794 */       strFieldValue = StrTool.GBKToUnicode(this.userName);
/*  795 */       break;
/*      */     case 2:
/*  797 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  798 */       break;
/*      */     case 3:
/*  800 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  801 */       break;
/*      */     case 4:
/*  803 */       strFieldValue = StrTool.GBKToUnicode(this.password);
/*  804 */       break;
/*      */     case 5:
/*  806 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPwdModifyDate()));
/*  807 */       break;
/*      */     case 6:
/*  809 */       strFieldValue = StrTool.GBKToUnicode(this.userDescription);
/*  810 */       break;
/*      */     case 7:
/*  812 */       strFieldValue = StrTool.GBKToUnicode(this.userState);
/*  813 */       break;
/*      */     case 8:
/*  815 */       strFieldValue = StrTool.GBKToUnicode(this.superPopedomFlag);
/*  816 */       break;
/*      */     case 9:
/*  818 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getValidStartDate()));
/*  819 */       break;
/*      */     case 10:
/*  821 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getValidEndDate()));
/*  822 */       break;
/*      */     case 11:
/*  824 */       strFieldValue = StrTool.GBKToUnicode(this.stuffNo);
/*  825 */       break;
/*      */     case 12:
/*  827 */       strFieldValue = StrTool.GBKToUnicode(this.officePhone);
/*  828 */       break;
/*      */     case 13:
/*  830 */       strFieldValue = StrTool.GBKToUnicode(this.phone);
/*  831 */       break;
/*      */     case 14:
/*  833 */       strFieldValue = StrTool.GBKToUnicode(this.eMail);
/*  834 */       break;
/*      */     case 15:
/*  836 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  837 */       break;
/*      */     case 16:
/*  839 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  840 */       break;
/*      */     case 17:
/*  842 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  843 */       break;
/*      */     case 18:
/*  845 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  846 */       break;
/*      */     case 19:
/*  848 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  849 */       break;
/*      */     case 20:
/*  851 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  852 */       break;
/*      */     case 21:
/*  854 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  855 */       break;
/*      */     case 22:
/*  857 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  858 */       break;
/*      */     case 23:
/*  860 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  861 */       break;
/*      */     case 24:
/*  863 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  864 */       break;
/*      */     case 25:
/*  866 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  867 */       break;
/*      */     case 26:
/*  869 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  870 */       break;
/*      */     default:
/*  872 */       strFieldValue = "";
/*      */     }
/*  874 */     if (strFieldValue.equals("")) {
/*  875 */       strFieldValue = "null";
/*      */     }
/*  877 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  883 */     if (StrTool.cTrim(FCode).equals("")) {
/*  884 */       return false;
/*      */     }
/*  886 */     if (FCode.equalsIgnoreCase("userCode"))
/*      */     {
/*  888 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  890 */         this.userCode = FValue.trim();
/*      */       }
/*      */       else
/*  893 */         this.userCode = null;
/*      */     }
/*  895 */     if (FCode.equalsIgnoreCase("userName"))
/*      */     {
/*  897 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  899 */         this.userName = FValue.trim();
/*      */       }
/*      */       else
/*  902 */         this.userName = null;
/*      */     }
/*  904 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  906 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  908 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  911 */         this.manageCom = null;
/*      */     }
/*  913 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  915 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  917 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  920 */         this.branchType = null;
/*      */     }
/*  922 */     if (FCode.equalsIgnoreCase("password"))
/*      */     {
/*  924 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  926 */         this.password = FValue.trim();
/*      */       }
/*      */       else
/*  929 */         this.password = null;
/*      */     }
/*  931 */     if (FCode.equalsIgnoreCase("pwdModifyDate"))
/*      */     {
/*  933 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  935 */         this.pwdModifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  938 */         this.pwdModifyDate = null;
/*      */     }
/*  940 */     if (FCode.equalsIgnoreCase("userDescription"))
/*      */     {
/*  942 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  944 */         this.userDescription = FValue.trim();
/*      */       }
/*      */       else
/*  947 */         this.userDescription = null;
/*      */     }
/*  949 */     if (FCode.equalsIgnoreCase("userState"))
/*      */     {
/*  951 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  953 */         this.userState = FValue.trim();
/*      */       }
/*      */       else
/*  956 */         this.userState = null;
/*      */     }
/*  958 */     if (FCode.equalsIgnoreCase("superPopedomFlag"))
/*      */     {
/*  960 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  962 */         this.superPopedomFlag = FValue.trim();
/*      */       }
/*      */       else
/*  965 */         this.superPopedomFlag = null;
/*      */     }
/*  967 */     if (FCode.equalsIgnoreCase("validStartDate"))
/*      */     {
/*  969 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  971 */         this.validStartDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  974 */         this.validStartDate = null;
/*      */     }
/*  976 */     if (FCode.equalsIgnoreCase("validEndDate"))
/*      */     {
/*  978 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  980 */         this.validEndDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  983 */         this.validEndDate = null;
/*      */     }
/*  985 */     if (FCode.equalsIgnoreCase("stuffNo"))
/*      */     {
/*  987 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  989 */         this.stuffNo = FValue.trim();
/*      */       }
/*      */       else
/*  992 */         this.stuffNo = null;
/*      */     }
/*  994 */     if (FCode.equalsIgnoreCase("officePhone"))
/*      */     {
/*  996 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  998 */         this.officePhone = FValue.trim();
/*      */       }
/*      */       else
/* 1001 */         this.officePhone = null;
/*      */     }
/* 1003 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/* 1005 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1007 */         this.phone = FValue.trim();
/*      */       }
/*      */       else
/* 1010 */         this.phone = null;
/*      */     }
/* 1012 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/* 1014 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1016 */         this.eMail = FValue.trim();
/*      */       }
/*      */       else
/* 1019 */         this.eMail = null;
/*      */     }
/* 1021 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1023 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1025 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1028 */         this.operator = null;
/*      */     }
/* 1030 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1032 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1034 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1037 */         this.modifyOperator = null;
/*      */     }
/* 1039 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1041 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1043 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1046 */         this.makeDate = null;
/*      */     }
/* 1048 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1050 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1052 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1055 */         this.makeTime = null;
/*      */     }
/* 1057 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1059 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1061 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1064 */         this.modifyDate = null;
/*      */     }
/* 1066 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1068 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1070 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1073 */         this.modifyTime = null;
/*      */     }
/* 1075 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/* 1077 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1079 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1082 */         this.edorNo = null;
/*      */     }
/* 1084 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/* 1086 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1088 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1091 */         this.edorType = null;
/*      */     }
/* 1093 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1095 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1097 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1100 */         this.edorCase = null;
/*      */     }
/* 1102 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1104 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1106 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1109 */         this.operator2 = null;
/*      */     }
/* 1111 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1113 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1115 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1118 */         this.makeDate2 = null;
/*      */     }
/* 1120 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1122 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1124 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1127 */         this.makeTime2 = null;
/*      */     }
/* 1129 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1134 */     if (otherObject == null) return false;
/* 1135 */     if (this == otherObject) return true;
/* 1136 */     if (getClass() != otherObject.getClass()) return false;
/* 1137 */     MUserBSchema other = (MUserBSchema)otherObject;
/* 1138 */     if ((this.userCode == null) && (other.getUserCode() != null)) return false;
/* 1139 */     if ((this.userCode != null) && (!this.userCode.equals(other.getUserCode()))) return false;
/* 1140 */     if ((this.userName == null) && (other.getUserName() != null)) return false;
/* 1141 */     if ((this.userName != null) && (!this.userName.equals(other.getUserName()))) return false;
/* 1142 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1143 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1144 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1145 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1146 */     if ((this.password == null) && (other.getPassword() != null)) return false;
/* 1147 */     if ((this.password != null) && (!this.password.equals(other.getPassword()))) return false;
/* 1148 */     if ((this.pwdModifyDate == null) && (other.getPwdModifyDate() != null)) return false;
/* 1149 */     if ((this.pwdModifyDate != null) && (!this.fDate.getString(this.pwdModifyDate).equals(other.getPwdModifyDate()))) return false;
/* 1150 */     if ((this.userDescription == null) && (other.getUserDescription() != null)) return false;
/* 1151 */     if ((this.userDescription != null) && (!this.userDescription.equals(other.getUserDescription()))) return false;
/* 1152 */     if ((this.userState == null) && (other.getUserState() != null)) return false;
/* 1153 */     if ((this.userState != null) && (!this.userState.equals(other.getUserState()))) return false;
/* 1154 */     if ((this.superPopedomFlag == null) && (other.getSuperPopedomFlag() != null)) return false;
/* 1155 */     if ((this.superPopedomFlag != null) && (!this.superPopedomFlag.equals(other.getSuperPopedomFlag()))) return false;
/* 1156 */     if ((this.validStartDate == null) && (other.getValidStartDate() != null)) return false;
/* 1157 */     if ((this.validStartDate != null) && (!this.fDate.getString(this.validStartDate).equals(other.getValidStartDate()))) return false;
/* 1158 */     if ((this.validEndDate == null) && (other.getValidEndDate() != null)) return false;
/* 1159 */     if ((this.validEndDate != null) && (!this.fDate.getString(this.validEndDate).equals(other.getValidEndDate()))) return false;
/* 1160 */     if ((this.stuffNo == null) && (other.getStuffNo() != null)) return false;
/* 1161 */     if ((this.stuffNo != null) && (!this.stuffNo.equals(other.getStuffNo()))) return false;
/* 1162 */     if ((this.officePhone == null) && (other.getOfficePhone() != null)) return false;
/* 1163 */     if ((this.officePhone != null) && (!this.officePhone.equals(other.getOfficePhone()))) return false;
/* 1164 */     if ((this.phone == null) && (other.getPhone() != null)) return false;
/* 1165 */     if ((this.phone != null) && (!this.phone.equals(other.getPhone()))) return false;
/* 1166 */     if ((this.eMail == null) && (other.getEMail() != null)) return false;
/* 1167 */     if ((this.eMail != null) && (!this.eMail.equals(other.getEMail()))) return false;
/* 1168 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1169 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1170 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1171 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1172 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1173 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1174 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1175 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1176 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1177 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1178 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1179 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1180 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1181 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1182 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1183 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1184 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1185 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1186 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1187 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1188 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1189 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1190 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1191 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1198 */     return 27;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1204 */     if (strFieldName.equals("userCode")) {
/* 1205 */       return 0;
/*      */     }
/* 1207 */     if (strFieldName.equals("userName")) {
/* 1208 */       return 1;
/*      */     }
/* 1210 */     if (strFieldName.equals("manageCom")) {
/* 1211 */       return 2;
/*      */     }
/* 1213 */     if (strFieldName.equals("branchType")) {
/* 1214 */       return 3;
/*      */     }
/* 1216 */     if (strFieldName.equals("password")) {
/* 1217 */       return 4;
/*      */     }
/* 1219 */     if (strFieldName.equals("pwdModifyDate")) {
/* 1220 */       return 5;
/*      */     }
/* 1222 */     if (strFieldName.equals("userDescription")) {
/* 1223 */       return 6;
/*      */     }
/* 1225 */     if (strFieldName.equals("userState")) {
/* 1226 */       return 7;
/*      */     }
/* 1228 */     if (strFieldName.equals("superPopedomFlag")) {
/* 1229 */       return 8;
/*      */     }
/* 1231 */     if (strFieldName.equals("validStartDate")) {
/* 1232 */       return 9;
/*      */     }
/* 1234 */     if (strFieldName.equals("validEndDate")) {
/* 1235 */       return 10;
/*      */     }
/* 1237 */     if (strFieldName.equals("stuffNo")) {
/* 1238 */       return 11;
/*      */     }
/* 1240 */     if (strFieldName.equals("officePhone")) {
/* 1241 */       return 12;
/*      */     }
/* 1243 */     if (strFieldName.equals("phone")) {
/* 1244 */       return 13;
/*      */     }
/* 1246 */     if (strFieldName.equals("eMail")) {
/* 1247 */       return 14;
/*      */     }
/* 1249 */     if (strFieldName.equals("operator")) {
/* 1250 */       return 15;
/*      */     }
/* 1252 */     if (strFieldName.equals("modifyOperator")) {
/* 1253 */       return 16;
/*      */     }
/* 1255 */     if (strFieldName.equals("makeDate")) {
/* 1256 */       return 17;
/*      */     }
/* 1258 */     if (strFieldName.equals("makeTime")) {
/* 1259 */       return 18;
/*      */     }
/* 1261 */     if (strFieldName.equals("modifyDate")) {
/* 1262 */       return 19;
/*      */     }
/* 1264 */     if (strFieldName.equals("modifyTime")) {
/* 1265 */       return 20;
/*      */     }
/* 1267 */     if (strFieldName.equals("edorNo")) {
/* 1268 */       return 21;
/*      */     }
/* 1270 */     if (strFieldName.equals("edorType")) {
/* 1271 */       return 22;
/*      */     }
/* 1273 */     if (strFieldName.equals("edorCase")) {
/* 1274 */       return 23;
/*      */     }
/* 1276 */     if (strFieldName.equals("operator2")) {
/* 1277 */       return 24;
/*      */     }
/* 1279 */     if (strFieldName.equals("makeDate2")) {
/* 1280 */       return 25;
/*      */     }
/* 1282 */     if (strFieldName.equals("makeTime2")) {
/* 1283 */       return 26;
/*      */     }
/* 1285 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1291 */     String strFieldName = "";
/* 1292 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1294 */       strFieldName = "userCode";
/* 1295 */       break;
/*      */     case 1:
/* 1297 */       strFieldName = "userName";
/* 1298 */       break;
/*      */     case 2:
/* 1300 */       strFieldName = "manageCom";
/* 1301 */       break;
/*      */     case 3:
/* 1303 */       strFieldName = "branchType";
/* 1304 */       break;
/*      */     case 4:
/* 1306 */       strFieldName = "password";
/* 1307 */       break;
/*      */     case 5:
/* 1309 */       strFieldName = "pwdModifyDate";
/* 1310 */       break;
/*      */     case 6:
/* 1312 */       strFieldName = "userDescription";
/* 1313 */       break;
/*      */     case 7:
/* 1315 */       strFieldName = "userState";
/* 1316 */       break;
/*      */     case 8:
/* 1318 */       strFieldName = "superPopedomFlag";
/* 1319 */       break;
/*      */     case 9:
/* 1321 */       strFieldName = "validStartDate";
/* 1322 */       break;
/*      */     case 10:
/* 1324 */       strFieldName = "validEndDate";
/* 1325 */       break;
/*      */     case 11:
/* 1327 */       strFieldName = "stuffNo";
/* 1328 */       break;
/*      */     case 12:
/* 1330 */       strFieldName = "officePhone";
/* 1331 */       break;
/*      */     case 13:
/* 1333 */       strFieldName = "phone";
/* 1334 */       break;
/*      */     case 14:
/* 1336 */       strFieldName = "eMail";
/* 1337 */       break;
/*      */     case 15:
/* 1339 */       strFieldName = "operator";
/* 1340 */       break;
/*      */     case 16:
/* 1342 */       strFieldName = "modifyOperator";
/* 1343 */       break;
/*      */     case 17:
/* 1345 */       strFieldName = "makeDate";
/* 1346 */       break;
/*      */     case 18:
/* 1348 */       strFieldName = "makeTime";
/* 1349 */       break;
/*      */     case 19:
/* 1351 */       strFieldName = "modifyDate";
/* 1352 */       break;
/*      */     case 20:
/* 1354 */       strFieldName = "modifyTime";
/* 1355 */       break;
/*      */     case 21:
/* 1357 */       strFieldName = "edorNo";
/* 1358 */       break;
/*      */     case 22:
/* 1360 */       strFieldName = "edorType";
/* 1361 */       break;
/*      */     case 23:
/* 1363 */       strFieldName = "edorCase";
/* 1364 */       break;
/*      */     case 24:
/* 1366 */       strFieldName = "operator2";
/* 1367 */       break;
/*      */     case 25:
/* 1369 */       strFieldName = "makeDate2";
/* 1370 */       break;
/*      */     case 26:
/* 1372 */       strFieldName = "makeTime2";
/* 1373 */       break;
/*      */     default:
/* 1375 */       strFieldName = "";
/*      */     }
/* 1377 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1383 */     if (strFieldName.equals("userCode")) {
/* 1384 */       return 0;
/*      */     }
/* 1386 */     if (strFieldName.equals("userName")) {
/* 1387 */       return 0;
/*      */     }
/* 1389 */     if (strFieldName.equals("manageCom")) {
/* 1390 */       return 0;
/*      */     }
/* 1392 */     if (strFieldName.equals("branchType")) {
/* 1393 */       return 0;
/*      */     }
/* 1395 */     if (strFieldName.equals("password")) {
/* 1396 */       return 0;
/*      */     }
/* 1398 */     if (strFieldName.equals("pwdModifyDate")) {
/* 1399 */       return 1;
/*      */     }
/* 1401 */     if (strFieldName.equals("userDescription")) {
/* 1402 */       return 0;
/*      */     }
/* 1404 */     if (strFieldName.equals("userState")) {
/* 1405 */       return 0;
/*      */     }
/* 1407 */     if (strFieldName.equals("superPopedomFlag")) {
/* 1408 */       return 0;
/*      */     }
/* 1410 */     if (strFieldName.equals("validStartDate")) {
/* 1411 */       return 1;
/*      */     }
/* 1413 */     if (strFieldName.equals("validEndDate")) {
/* 1414 */       return 1;
/*      */     }
/* 1416 */     if (strFieldName.equals("stuffNo")) {
/* 1417 */       return 0;
/*      */     }
/* 1419 */     if (strFieldName.equals("officePhone")) {
/* 1420 */       return 0;
/*      */     }
/* 1422 */     if (strFieldName.equals("phone")) {
/* 1423 */       return 0;
/*      */     }
/* 1425 */     if (strFieldName.equals("eMail")) {
/* 1426 */       return 0;
/*      */     }
/* 1428 */     if (strFieldName.equals("operator")) {
/* 1429 */       return 0;
/*      */     }
/* 1431 */     if (strFieldName.equals("modifyOperator")) {
/* 1432 */       return 0;
/*      */     }
/* 1434 */     if (strFieldName.equals("makeDate")) {
/* 1435 */       return 1;
/*      */     }
/* 1437 */     if (strFieldName.equals("makeTime")) {
/* 1438 */       return 0;
/*      */     }
/* 1440 */     if (strFieldName.equals("modifyDate")) {
/* 1441 */       return 1;
/*      */     }
/* 1443 */     if (strFieldName.equals("modifyTime")) {
/* 1444 */       return 0;
/*      */     }
/* 1446 */     if (strFieldName.equals("edorNo")) {
/* 1447 */       return 0;
/*      */     }
/* 1449 */     if (strFieldName.equals("edorType")) {
/* 1450 */       return 0;
/*      */     }
/* 1452 */     if (strFieldName.equals("edorCase")) {
/* 1453 */       return 0;
/*      */     }
/* 1455 */     if (strFieldName.equals("operator2")) {
/* 1456 */       return 0;
/*      */     }
/* 1458 */     if (strFieldName.equals("makeDate2")) {
/* 1459 */       return 1;
/*      */     }
/* 1461 */     if (strFieldName.equals("makeTime2")) {
/* 1462 */       return 0;
/*      */     }
/* 1464 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1470 */     int nFieldType = -1;
/* 1471 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1473 */       nFieldType = 0;
/* 1474 */       break;
/*      */     case 1:
/* 1476 */       nFieldType = 0;
/* 1477 */       break;
/*      */     case 2:
/* 1479 */       nFieldType = 0;
/* 1480 */       break;
/*      */     case 3:
/* 1482 */       nFieldType = 0;
/* 1483 */       break;
/*      */     case 4:
/* 1485 */       nFieldType = 0;
/* 1486 */       break;
/*      */     case 5:
/* 1488 */       nFieldType = 1;
/* 1489 */       break;
/*      */     case 6:
/* 1491 */       nFieldType = 0;
/* 1492 */       break;
/*      */     case 7:
/* 1494 */       nFieldType = 0;
/* 1495 */       break;
/*      */     case 8:
/* 1497 */       nFieldType = 0;
/* 1498 */       break;
/*      */     case 9:
/* 1500 */       nFieldType = 1;
/* 1501 */       break;
/*      */     case 10:
/* 1503 */       nFieldType = 1;
/* 1504 */       break;
/*      */     case 11:
/* 1506 */       nFieldType = 0;
/* 1507 */       break;
/*      */     case 12:
/* 1509 */       nFieldType = 0;
/* 1510 */       break;
/*      */     case 13:
/* 1512 */       nFieldType = 0;
/* 1513 */       break;
/*      */     case 14:
/* 1515 */       nFieldType = 0;
/* 1516 */       break;
/*      */     case 15:
/* 1518 */       nFieldType = 0;
/* 1519 */       break;
/*      */     case 16:
/* 1521 */       nFieldType = 0;
/* 1522 */       break;
/*      */     case 17:
/* 1524 */       nFieldType = 1;
/* 1525 */       break;
/*      */     case 18:
/* 1527 */       nFieldType = 0;
/* 1528 */       break;
/*      */     case 19:
/* 1530 */       nFieldType = 1;
/* 1531 */       break;
/*      */     case 20:
/* 1533 */       nFieldType = 0;
/* 1534 */       break;
/*      */     case 21:
/* 1536 */       nFieldType = 0;
/* 1537 */       break;
/*      */     case 22:
/* 1539 */       nFieldType = 0;
/* 1540 */       break;
/*      */     case 23:
/* 1542 */       nFieldType = 0;
/* 1543 */       break;
/*      */     case 24:
/* 1545 */       nFieldType = 0;
/* 1546 */       break;
/*      */     case 25:
/* 1548 */       nFieldType = 1;
/* 1549 */       break;
/*      */     case 26:
/* 1551 */       nFieldType = 0;
/* 1552 */       break;
/*      */     default:
/* 1554 */       nFieldType = -1;
/*      */     }
/* 1556 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MUserBSchema
 * JD-Core Version:    0.6.0
 */