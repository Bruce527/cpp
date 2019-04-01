/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MUserDB;
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
/*      */ public class MUserSchema
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
/*      */   public static final int FIELDNUM = 21;
/*      */   private static String[] PK;
/*   66 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MUserSchema()
/*      */   {
/*   73 */     this.mErrors = new CErrors();
/*      */ 
/*   75 */     String[] pk = new String[1];
/*   76 */     pk[0] = "UserCode";
/*      */ 
/*   78 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   85 */     MUserSchema cloned = (MUserSchema)super.clone();
/*   86 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   87 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   88 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   94 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getUserCode()
/*      */   {
/*   99 */     return this.userCode;
/*      */   }
/*      */ 
/*      */   public void setUserCode(String aUserCode) {
/*  103 */     this.userCode = aUserCode;
/*      */   }
/*      */ 
/*      */   public String getUserName() {
/*  107 */     return this.userName;
/*      */   }
/*      */ 
/*      */   public void setUserName(String aUserName) {
/*  111 */     this.userName = aUserName;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  115 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  119 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  123 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  127 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getPassword() {
/*  131 */     return this.password;
/*      */   }
/*      */ 
/*      */   public void setPassword(String aPassword) {
/*  135 */     this.password = aPassword;
/*      */   }
/*      */ 
/*      */   public String getPwdModifyDate() {
/*  139 */     if (this.pwdModifyDate != null) {
/*  140 */       return this.fDate.getString(this.pwdModifyDate);
/*      */     }
/*  142 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPwdModifyDate(Date aPwdModifyDate) {
/*  146 */     this.pwdModifyDate = aPwdModifyDate;
/*      */   }
/*      */ 
/*      */   public void setPwdModifyDate(String aPwdModifyDate) {
/*  150 */     if ((aPwdModifyDate != null) && (!aPwdModifyDate.equals("")))
/*      */     {
/*  152 */       this.pwdModifyDate = this.fDate.getDate(aPwdModifyDate);
/*      */     }
/*      */     else
/*  155 */       this.pwdModifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getUserDescription()
/*      */   {
/*  160 */     return this.userDescription;
/*      */   }
/*      */ 
/*      */   public void setUserDescription(String aUserDescription) {
/*  164 */     this.userDescription = aUserDescription;
/*      */   }
/*      */ 
/*      */   public String getUserState() {
/*  168 */     return this.userState;
/*      */   }
/*      */ 
/*      */   public void setUserState(String aUserState) {
/*  172 */     this.userState = aUserState;
/*      */   }
/*      */ 
/*      */   public String getSuperPopedomFlag() {
/*  176 */     return this.superPopedomFlag;
/*      */   }
/*      */ 
/*      */   public void setSuperPopedomFlag(String aSuperPopedomFlag) {
/*  180 */     this.superPopedomFlag = aSuperPopedomFlag;
/*      */   }
/*      */ 
/*      */   public String getValidStartDate() {
/*  184 */     if (this.validStartDate != null) {
/*  185 */       return this.fDate.getString(this.validStartDate);
/*      */     }
/*  187 */     return null;
/*      */   }
/*      */ 
/*      */   public void setValidStartDate(Date aValidStartDate) {
/*  191 */     this.validStartDate = aValidStartDate;
/*      */   }
/*      */ 
/*      */   public void setValidStartDate(String aValidStartDate) {
/*  195 */     if ((aValidStartDate != null) && (!aValidStartDate.equals("")))
/*      */     {
/*  197 */       this.validStartDate = this.fDate.getDate(aValidStartDate);
/*      */     }
/*      */     else
/*  200 */       this.validStartDate = null;
/*      */   }
/*      */ 
/*      */   public String getValidEndDate()
/*      */   {
/*  205 */     if (this.validEndDate != null) {
/*  206 */       return this.fDate.getString(this.validEndDate);
/*      */     }
/*  208 */     return null;
/*      */   }
/*      */ 
/*      */   public void setValidEndDate(Date aValidEndDate) {
/*  212 */     this.validEndDate = aValidEndDate;
/*      */   }
/*      */ 
/*      */   public void setValidEndDate(String aValidEndDate) {
/*  216 */     if ((aValidEndDate != null) && (!aValidEndDate.equals("")))
/*      */     {
/*  218 */       this.validEndDate = this.fDate.getDate(aValidEndDate);
/*      */     }
/*      */     else
/*  221 */       this.validEndDate = null;
/*      */   }
/*      */ 
/*      */   public String getStuffNo()
/*      */   {
/*  226 */     return this.stuffNo;
/*      */   }
/*      */ 
/*      */   public void setStuffNo(String aStuffNo) {
/*  230 */     this.stuffNo = aStuffNo;
/*      */   }
/*      */ 
/*      */   public String getOfficePhone() {
/*  234 */     return this.officePhone;
/*      */   }
/*      */ 
/*      */   public void setOfficePhone(String aOfficePhone) {
/*  238 */     this.officePhone = aOfficePhone;
/*      */   }
/*      */ 
/*      */   public String getPhone() {
/*  242 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setPhone(String aPhone) {
/*  246 */     this.phone = aPhone;
/*      */   }
/*      */ 
/*      */   public String getEMail() {
/*  250 */     return this.eMail;
/*      */   }
/*      */ 
/*      */   public void setEMail(String aEMail) {
/*  254 */     this.eMail = aEMail;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  258 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  262 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator() {
/*  266 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  270 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  274 */     if (this.makeDate != null) {
/*  275 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  277 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  281 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  285 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  287 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  290 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  295 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  299 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  303 */     if (this.modifyDate != null) {
/*  304 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  306 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  310 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  314 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  316 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  319 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  324 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  328 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MUserSchema aMUserSchema)
/*      */   {
/*  334 */     this.userCode = aMUserSchema.getUserCode();
/*  335 */     this.userName = aMUserSchema.getUserName();
/*  336 */     this.manageCom = aMUserSchema.getManageCom();
/*  337 */     this.branchType = aMUserSchema.getBranchType();
/*  338 */     this.password = aMUserSchema.getPassword();
/*  339 */     this.pwdModifyDate = this.fDate.getDate(aMUserSchema.getPwdModifyDate());
/*  340 */     this.userDescription = aMUserSchema.getUserDescription();
/*  341 */     this.userState = aMUserSchema.getUserState();
/*  342 */     this.superPopedomFlag = aMUserSchema.getSuperPopedomFlag();
/*  343 */     this.validStartDate = this.fDate.getDate(aMUserSchema.getValidStartDate());
/*  344 */     this.validEndDate = this.fDate.getDate(aMUserSchema.getValidEndDate());
/*  345 */     this.stuffNo = aMUserSchema.getStuffNo();
/*  346 */     this.officePhone = aMUserSchema.getOfficePhone();
/*  347 */     this.phone = aMUserSchema.getPhone();
/*  348 */     this.eMail = aMUserSchema.getEMail();
/*  349 */     this.operator = aMUserSchema.getOperator();
/*  350 */     this.modifyOperator = aMUserSchema.getModifyOperator();
/*  351 */     this.makeDate = this.fDate.getDate(aMUserSchema.getMakeDate());
/*  352 */     this.makeTime = aMUserSchema.getMakeTime();
/*  353 */     this.modifyDate = this.fDate.getDate(aMUserSchema.getModifyDate());
/*  354 */     this.modifyTime = aMUserSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  363 */       if (rs.getString("UserCode") == null)
/*  364 */         this.userCode = null;
/*      */       else {
/*  366 */         this.userCode = rs.getString("UserCode").trim();
/*      */       }
/*  368 */       if (rs.getString("UserName") == null)
/*  369 */         this.userName = null;
/*      */       else {
/*  371 */         this.userName = rs.getString("UserName").trim();
/*      */       }
/*  373 */       if (rs.getString("ManageCom") == null)
/*  374 */         this.manageCom = null;
/*      */       else {
/*  376 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  378 */       if (rs.getString("BranchType") == null)
/*  379 */         this.branchType = null;
/*      */       else {
/*  381 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  383 */       if (rs.getString("Password") == null)
/*  384 */         this.password = null;
/*      */       else {
/*  386 */         this.password = rs.getString("Password").trim();
/*      */       }
/*  388 */       this.pwdModifyDate = rs.getDate("PwdModifyDate");
/*  389 */       if (rs.getString("UserDescription") == null)
/*  390 */         this.userDescription = null;
/*      */       else {
/*  392 */         this.userDescription = rs.getString("UserDescription").trim();
/*      */       }
/*  394 */       if (rs.getString("UserState") == null)
/*  395 */         this.userState = null;
/*      */       else {
/*  397 */         this.userState = rs.getString("UserState").trim();
/*      */       }
/*  399 */       if (rs.getString("SuperPopedomFlag") == null)
/*  400 */         this.superPopedomFlag = null;
/*      */       else {
/*  402 */         this.superPopedomFlag = rs.getString("SuperPopedomFlag").trim();
/*      */       }
/*  404 */       this.validStartDate = rs.getDate("ValidStartDate");
/*  405 */       this.validEndDate = rs.getDate("ValidEndDate");
/*  406 */       if (rs.getString("StuffNo") == null)
/*  407 */         this.stuffNo = null;
/*      */       else {
/*  409 */         this.stuffNo = rs.getString("StuffNo").trim();
/*      */       }
/*  411 */       if (rs.getString("OfficePhone") == null)
/*  412 */         this.officePhone = null;
/*      */       else {
/*  414 */         this.officePhone = rs.getString("OfficePhone").trim();
/*      */       }
/*  416 */       if (rs.getString("Phone") == null)
/*  417 */         this.phone = null;
/*      */       else {
/*  419 */         this.phone = rs.getString("Phone").trim();
/*      */       }
/*  421 */       if (rs.getString("EMail") == null)
/*  422 */         this.eMail = null;
/*      */       else {
/*  424 */         this.eMail = rs.getString("EMail").trim();
/*      */       }
/*  426 */       if (rs.getString("Operator") == null)
/*  427 */         this.operator = null;
/*      */       else {
/*  429 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  431 */       if (rs.getString("ModifyOperator") == null)
/*  432 */         this.modifyOperator = null;
/*      */       else {
/*  434 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  436 */       this.makeDate = rs.getDate("MakeDate");
/*  437 */       if (rs.getString("MakeTime") == null)
/*  438 */         this.makeTime = null;
/*      */       else {
/*  440 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  442 */       this.modifyDate = rs.getDate("ModifyDate");
/*  443 */       if (rs.getString("ModifyTime") == null)
/*  444 */         this.modifyTime = null;
/*      */       else {
/*  446 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  451 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MUser\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  453 */       CError tError = new CError();
/*  454 */       tError.moduleName = "MUserSchema";
/*  455 */       tError.functionName = "setSchema";
/*  456 */       tError.errorMessage = sqle.toString();
/*  457 */       this.mErrors.addOneError(tError);
/*  458 */       return false;
/*      */     }
/*  460 */     return true;
/*      */   }
/*      */ 
/*      */   public MUserSchema getSchema()
/*      */   {
/*  465 */     MUserSchema aMUserSchema = new MUserSchema();
/*  466 */     aMUserSchema.setSchema(this);
/*  467 */     return aMUserSchema;
/*      */   }
/*      */ 
/*      */   public MUserDB getDB()
/*      */   {
/*  472 */     MUserDB aDBOper = new MUserDB();
/*  473 */     aDBOper.setSchema(this);
/*  474 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  481 */     StringBuffer strReturn = new StringBuffer(256);
/*  482 */     strReturn.append(StrTool.cTrim(this.userCode)); strReturn.append("|");
/*  483 */     strReturn.append(StrTool.cTrim(this.userName)); strReturn.append("|");
/*  484 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  485 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  486 */     strReturn.append(StrTool.cTrim(this.password)); strReturn.append("|");
/*  487 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.pwdModifyDate))); strReturn.append("|");
/*  488 */     strReturn.append(StrTool.cTrim(this.userDescription)); strReturn.append("|");
/*  489 */     strReturn.append(StrTool.cTrim(this.userState)); strReturn.append("|");
/*  490 */     strReturn.append(StrTool.cTrim(this.superPopedomFlag)); strReturn.append("|");
/*  491 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.validStartDate))); strReturn.append("|");
/*  492 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.validEndDate))); strReturn.append("|");
/*  493 */     strReturn.append(StrTool.cTrim(this.stuffNo)); strReturn.append("|");
/*  494 */     strReturn.append(StrTool.cTrim(this.officePhone)); strReturn.append("|");
/*  495 */     strReturn.append(StrTool.cTrim(this.phone)); strReturn.append("|");
/*  496 */     strReturn.append(StrTool.cTrim(this.eMail)); strReturn.append("|");
/*  497 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  498 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  499 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  500 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  501 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  502 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  503 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  511 */       this.userCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  512 */       this.userName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  513 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  514 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  515 */       this.password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  516 */       this.pwdModifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/*  517 */       this.userDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  518 */       this.userState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  519 */       this.superPopedomFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  520 */       this.validStartDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*  521 */       this.validEndDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
/*  522 */       this.stuffNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  523 */       this.officePhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  524 */       this.phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  525 */       this.eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  526 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  527 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  528 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*  529 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  530 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  531 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  536 */       CError tError = new CError();
/*  537 */       tError.moduleName = "MUserSchema";
/*  538 */       tError.functionName = "decode";
/*  539 */       tError.errorMessage = ex.toString();
/*  540 */       this.mErrors.addOneError(tError);
/*      */ 
/*  542 */       return false;
/*      */     }
/*  544 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  550 */     String strReturn = "";
/*  551 */     if (FCode.equalsIgnoreCase("userCode"))
/*      */     {
/*  553 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userCode));
/*      */     }
/*  555 */     if (FCode.equalsIgnoreCase("userName"))
/*      */     {
/*  557 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userName));
/*      */     }
/*  559 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  561 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  563 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  565 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  567 */     if (FCode.equalsIgnoreCase("password"))
/*      */     {
/*  569 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.password));
/*      */     }
/*  571 */     if (FCode.equalsIgnoreCase("pwdModifyDate"))
/*      */     {
/*  573 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPwdModifyDate()));
/*      */     }
/*  575 */     if (FCode.equalsIgnoreCase("userDescription"))
/*      */     {
/*  577 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userDescription));
/*      */     }
/*  579 */     if (FCode.equalsIgnoreCase("userState"))
/*      */     {
/*  581 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userState));
/*      */     }
/*  583 */     if (FCode.equalsIgnoreCase("superPopedomFlag"))
/*      */     {
/*  585 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.superPopedomFlag));
/*      */     }
/*  587 */     if (FCode.equalsIgnoreCase("validStartDate"))
/*      */     {
/*  589 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getValidStartDate()));
/*      */     }
/*  591 */     if (FCode.equalsIgnoreCase("validEndDate"))
/*      */     {
/*  593 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getValidEndDate()));
/*      */     }
/*  595 */     if (FCode.equalsIgnoreCase("stuffNo"))
/*      */     {
/*  597 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.stuffNo));
/*      */     }
/*  599 */     if (FCode.equalsIgnoreCase("officePhone"))
/*      */     {
/*  601 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.officePhone));
/*      */     }
/*  603 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/*  605 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.phone));
/*      */     }
/*  607 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/*  609 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.eMail));
/*      */     }
/*  611 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  613 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  615 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  617 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  619 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  621 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  623 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  625 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  627 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  629 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  631 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  633 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  635 */     if (strReturn.equals(""))
/*      */     {
/*  637 */       strReturn = "null";
/*      */     }
/*      */ 
/*  640 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  647 */     String strFieldValue = "";
/*  648 */     switch (nFieldIndex) {
/*      */     case 0:
/*  650 */       strFieldValue = StrTool.GBKToUnicode(this.userCode);
/*  651 */       break;
/*      */     case 1:
/*  653 */       strFieldValue = StrTool.GBKToUnicode(this.userName);
/*  654 */       break;
/*      */     case 2:
/*  656 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  657 */       break;
/*      */     case 3:
/*  659 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  660 */       break;
/*      */     case 4:
/*  662 */       strFieldValue = StrTool.GBKToUnicode(this.password);
/*  663 */       break;
/*      */     case 5:
/*  665 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPwdModifyDate()));
/*  666 */       break;
/*      */     case 6:
/*  668 */       strFieldValue = StrTool.GBKToUnicode(this.userDescription);
/*  669 */       break;
/*      */     case 7:
/*  671 */       strFieldValue = StrTool.GBKToUnicode(this.userState);
/*  672 */       break;
/*      */     case 8:
/*  674 */       strFieldValue = StrTool.GBKToUnicode(this.superPopedomFlag);
/*  675 */       break;
/*      */     case 9:
/*  677 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getValidStartDate()));
/*  678 */       break;
/*      */     case 10:
/*  680 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getValidEndDate()));
/*  681 */       break;
/*      */     case 11:
/*  683 */       strFieldValue = StrTool.GBKToUnicode(this.stuffNo);
/*  684 */       break;
/*      */     case 12:
/*  686 */       strFieldValue = StrTool.GBKToUnicode(this.officePhone);
/*  687 */       break;
/*      */     case 13:
/*  689 */       strFieldValue = StrTool.GBKToUnicode(this.phone);
/*  690 */       break;
/*      */     case 14:
/*  692 */       strFieldValue = StrTool.GBKToUnicode(this.eMail);
/*  693 */       break;
/*      */     case 15:
/*  695 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  696 */       break;
/*      */     case 16:
/*  698 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  699 */       break;
/*      */     case 17:
/*  701 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  702 */       break;
/*      */     case 18:
/*  704 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  705 */       break;
/*      */     case 19:
/*  707 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  708 */       break;
/*      */     case 20:
/*  710 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  711 */       break;
/*      */     default:
/*  713 */       strFieldValue = "";
/*      */     }
/*  715 */     if (strFieldValue.equals("")) {
/*  716 */       strFieldValue = "null";
/*      */     }
/*  718 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  724 */     if (StrTool.cTrim(FCode).equals("")) {
/*  725 */       return false;
/*      */     }
/*  727 */     if (FCode.equalsIgnoreCase("userCode"))
/*      */     {
/*  729 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  731 */         this.userCode = FValue.trim();
/*      */       }
/*      */       else
/*  734 */         this.userCode = null;
/*      */     }
/*  736 */     if (FCode.equalsIgnoreCase("userName"))
/*      */     {
/*  738 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  740 */         this.userName = FValue.trim();
/*      */       }
/*      */       else
/*  743 */         this.userName = null;
/*      */     }
/*  745 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  747 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  749 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  752 */         this.manageCom = null;
/*      */     }
/*  754 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  756 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  758 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  761 */         this.branchType = null;
/*      */     }
/*  763 */     if (FCode.equalsIgnoreCase("password"))
/*      */     {
/*  765 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  767 */         this.password = FValue.trim();
/*      */       }
/*      */       else
/*  770 */         this.password = null;
/*      */     }
/*  772 */     if (FCode.equalsIgnoreCase("pwdModifyDate"))
/*      */     {
/*  774 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  776 */         this.pwdModifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  779 */         this.pwdModifyDate = null;
/*      */     }
/*  781 */     if (FCode.equalsIgnoreCase("userDescription"))
/*      */     {
/*  783 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  785 */         this.userDescription = FValue.trim();
/*      */       }
/*      */       else
/*  788 */         this.userDescription = null;
/*      */     }
/*  790 */     if (FCode.equalsIgnoreCase("userState"))
/*      */     {
/*  792 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  794 */         this.userState = FValue.trim();
/*      */       }
/*      */       else
/*  797 */         this.userState = null;
/*      */     }
/*  799 */     if (FCode.equalsIgnoreCase("superPopedomFlag"))
/*      */     {
/*  801 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  803 */         this.superPopedomFlag = FValue.trim();
/*      */       }
/*      */       else
/*  806 */         this.superPopedomFlag = null;
/*      */     }
/*  808 */     if (FCode.equalsIgnoreCase("validStartDate"))
/*      */     {
/*  810 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  812 */         this.validStartDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  815 */         this.validStartDate = null;
/*      */     }
/*  817 */     if (FCode.equalsIgnoreCase("validEndDate"))
/*      */     {
/*  819 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  821 */         this.validEndDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  824 */         this.validEndDate = null;
/*      */     }
/*  826 */     if (FCode.equalsIgnoreCase("stuffNo"))
/*      */     {
/*  828 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  830 */         this.stuffNo = FValue.trim();
/*      */       }
/*      */       else
/*  833 */         this.stuffNo = null;
/*      */     }
/*  835 */     if (FCode.equalsIgnoreCase("officePhone"))
/*      */     {
/*  837 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  839 */         this.officePhone = FValue.trim();
/*      */       }
/*      */       else
/*  842 */         this.officePhone = null;
/*      */     }
/*  844 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/*  846 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  848 */         this.phone = FValue.trim();
/*      */       }
/*      */       else
/*  851 */         this.phone = null;
/*      */     }
/*  853 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/*  855 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  857 */         this.eMail = FValue.trim();
/*      */       }
/*      */       else
/*  860 */         this.eMail = null;
/*      */     }
/*  862 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  864 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  866 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  869 */         this.operator = null;
/*      */     }
/*  871 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  873 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  875 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  878 */         this.modifyOperator = null;
/*      */     }
/*  880 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  882 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  884 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  887 */         this.makeDate = null;
/*      */     }
/*  889 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  891 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  893 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  896 */         this.makeTime = null;
/*      */     }
/*  898 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  900 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  902 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  905 */         this.modifyDate = null;
/*      */     }
/*  907 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  909 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  911 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  914 */         this.modifyTime = null;
/*      */     }
/*  916 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  921 */     if (otherObject == null) return false;
/*  922 */     if (this == otherObject) return true;
/*  923 */     if (getClass() != otherObject.getClass()) return false;
/*  924 */     MUserSchema other = (MUserSchema)otherObject;
/*  925 */     if ((this.userCode == null) && (other.getUserCode() != null)) return false;
/*  926 */     if ((this.userCode != null) && (!this.userCode.equals(other.getUserCode()))) return false;
/*  927 */     if ((this.userName == null) && (other.getUserName() != null)) return false;
/*  928 */     if ((this.userName != null) && (!this.userName.equals(other.getUserName()))) return false;
/*  929 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/*  930 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/*  931 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/*  932 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/*  933 */     if ((this.password == null) && (other.getPassword() != null)) return false;
/*  934 */     if ((this.password != null) && (!this.password.equals(other.getPassword()))) return false;
/*  935 */     if ((this.pwdModifyDate == null) && (other.getPwdModifyDate() != null)) return false;
/*  936 */     if ((this.pwdModifyDate != null) && (!this.fDate.getString(this.pwdModifyDate).equals(other.getPwdModifyDate()))) return false;
/*  937 */     if ((this.userDescription == null) && (other.getUserDescription() != null)) return false;
/*  938 */     if ((this.userDescription != null) && (!this.userDescription.equals(other.getUserDescription()))) return false;
/*  939 */     if ((this.userState == null) && (other.getUserState() != null)) return false;
/*  940 */     if ((this.userState != null) && (!this.userState.equals(other.getUserState()))) return false;
/*  941 */     if ((this.superPopedomFlag == null) && (other.getSuperPopedomFlag() != null)) return false;
/*  942 */     if ((this.superPopedomFlag != null) && (!this.superPopedomFlag.equals(other.getSuperPopedomFlag()))) return false;
/*  943 */     if ((this.validStartDate == null) && (other.getValidStartDate() != null)) return false;
/*  944 */     if ((this.validStartDate != null) && (!this.fDate.getString(this.validStartDate).equals(other.getValidStartDate()))) return false;
/*  945 */     if ((this.validEndDate == null) && (other.getValidEndDate() != null)) return false;
/*  946 */     if ((this.validEndDate != null) && (!this.fDate.getString(this.validEndDate).equals(other.getValidEndDate()))) return false;
/*  947 */     if ((this.stuffNo == null) && (other.getStuffNo() != null)) return false;
/*  948 */     if ((this.stuffNo != null) && (!this.stuffNo.equals(other.getStuffNo()))) return false;
/*  949 */     if ((this.officePhone == null) && (other.getOfficePhone() != null)) return false;
/*  950 */     if ((this.officePhone != null) && (!this.officePhone.equals(other.getOfficePhone()))) return false;
/*  951 */     if ((this.phone == null) && (other.getPhone() != null)) return false;
/*  952 */     if ((this.phone != null) && (!this.phone.equals(other.getPhone()))) return false;
/*  953 */     if ((this.eMail == null) && (other.getEMail() != null)) return false;
/*  954 */     if ((this.eMail != null) && (!this.eMail.equals(other.getEMail()))) return false;
/*  955 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  956 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  957 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/*  958 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/*  959 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  960 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  961 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  962 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  963 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  964 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  965 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  966 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  973 */     return 21;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  979 */     if (strFieldName.equals("userCode")) {
/*  980 */       return 0;
/*      */     }
/*  982 */     if (strFieldName.equals("userName")) {
/*  983 */       return 1;
/*      */     }
/*  985 */     if (strFieldName.equals("manageCom")) {
/*  986 */       return 2;
/*      */     }
/*  988 */     if (strFieldName.equals("branchType")) {
/*  989 */       return 3;
/*      */     }
/*  991 */     if (strFieldName.equals("password")) {
/*  992 */       return 4;
/*      */     }
/*  994 */     if (strFieldName.equals("pwdModifyDate")) {
/*  995 */       return 5;
/*      */     }
/*  997 */     if (strFieldName.equals("userDescription")) {
/*  998 */       return 6;
/*      */     }
/* 1000 */     if (strFieldName.equals("userState")) {
/* 1001 */       return 7;
/*      */     }
/* 1003 */     if (strFieldName.equals("superPopedomFlag")) {
/* 1004 */       return 8;
/*      */     }
/* 1006 */     if (strFieldName.equals("validStartDate")) {
/* 1007 */       return 9;
/*      */     }
/* 1009 */     if (strFieldName.equals("validEndDate")) {
/* 1010 */       return 10;
/*      */     }
/* 1012 */     if (strFieldName.equals("stuffNo")) {
/* 1013 */       return 11;
/*      */     }
/* 1015 */     if (strFieldName.equals("officePhone")) {
/* 1016 */       return 12;
/*      */     }
/* 1018 */     if (strFieldName.equals("phone")) {
/* 1019 */       return 13;
/*      */     }
/* 1021 */     if (strFieldName.equals("eMail")) {
/* 1022 */       return 14;
/*      */     }
/* 1024 */     if (strFieldName.equals("operator")) {
/* 1025 */       return 15;
/*      */     }
/* 1027 */     if (strFieldName.equals("modifyOperator")) {
/* 1028 */       return 16;
/*      */     }
/* 1030 */     if (strFieldName.equals("makeDate")) {
/* 1031 */       return 17;
/*      */     }
/* 1033 */     if (strFieldName.equals("makeTime")) {
/* 1034 */       return 18;
/*      */     }
/* 1036 */     if (strFieldName.equals("modifyDate")) {
/* 1037 */       return 19;
/*      */     }
/* 1039 */     if (strFieldName.equals("modifyTime")) {
/* 1040 */       return 20;
/*      */     }
/* 1042 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1048 */     String strFieldName = "";
/* 1049 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1051 */       strFieldName = "userCode";
/* 1052 */       break;
/*      */     case 1:
/* 1054 */       strFieldName = "userName";
/* 1055 */       break;
/*      */     case 2:
/* 1057 */       strFieldName = "manageCom";
/* 1058 */       break;
/*      */     case 3:
/* 1060 */       strFieldName = "branchType";
/* 1061 */       break;
/*      */     case 4:
/* 1063 */       strFieldName = "password";
/* 1064 */       break;
/*      */     case 5:
/* 1066 */       strFieldName = "pwdModifyDate";
/* 1067 */       break;
/*      */     case 6:
/* 1069 */       strFieldName = "userDescription";
/* 1070 */       break;
/*      */     case 7:
/* 1072 */       strFieldName = "userState";
/* 1073 */       break;
/*      */     case 8:
/* 1075 */       strFieldName = "superPopedomFlag";
/* 1076 */       break;
/*      */     case 9:
/* 1078 */       strFieldName = "validStartDate";
/* 1079 */       break;
/*      */     case 10:
/* 1081 */       strFieldName = "validEndDate";
/* 1082 */       break;
/*      */     case 11:
/* 1084 */       strFieldName = "stuffNo";
/* 1085 */       break;
/*      */     case 12:
/* 1087 */       strFieldName = "officePhone";
/* 1088 */       break;
/*      */     case 13:
/* 1090 */       strFieldName = "phone";
/* 1091 */       break;
/*      */     case 14:
/* 1093 */       strFieldName = "eMail";
/* 1094 */       break;
/*      */     case 15:
/* 1096 */       strFieldName = "operator";
/* 1097 */       break;
/*      */     case 16:
/* 1099 */       strFieldName = "modifyOperator";
/* 1100 */       break;
/*      */     case 17:
/* 1102 */       strFieldName = "makeDate";
/* 1103 */       break;
/*      */     case 18:
/* 1105 */       strFieldName = "makeTime";
/* 1106 */       break;
/*      */     case 19:
/* 1108 */       strFieldName = "modifyDate";
/* 1109 */       break;
/*      */     case 20:
/* 1111 */       strFieldName = "modifyTime";
/* 1112 */       break;
/*      */     default:
/* 1114 */       strFieldName = "";
/*      */     }
/* 1116 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1122 */     if (strFieldName.equals("userCode")) {
/* 1123 */       return 0;
/*      */     }
/* 1125 */     if (strFieldName.equals("userName")) {
/* 1126 */       return 0;
/*      */     }
/* 1128 */     if (strFieldName.equals("manageCom")) {
/* 1129 */       return 0;
/*      */     }
/* 1131 */     if (strFieldName.equals("branchType")) {
/* 1132 */       return 0;
/*      */     }
/* 1134 */     if (strFieldName.equals("password")) {
/* 1135 */       return 0;
/*      */     }
/* 1137 */     if (strFieldName.equals("pwdModifyDate")) {
/* 1138 */       return 1;
/*      */     }
/* 1140 */     if (strFieldName.equals("userDescription")) {
/* 1141 */       return 0;
/*      */     }
/* 1143 */     if (strFieldName.equals("userState")) {
/* 1144 */       return 0;
/*      */     }
/* 1146 */     if (strFieldName.equals("superPopedomFlag")) {
/* 1147 */       return 0;
/*      */     }
/* 1149 */     if (strFieldName.equals("validStartDate")) {
/* 1150 */       return 1;
/*      */     }
/* 1152 */     if (strFieldName.equals("validEndDate")) {
/* 1153 */       return 1;
/*      */     }
/* 1155 */     if (strFieldName.equals("stuffNo")) {
/* 1156 */       return 0;
/*      */     }
/* 1158 */     if (strFieldName.equals("officePhone")) {
/* 1159 */       return 0;
/*      */     }
/* 1161 */     if (strFieldName.equals("phone")) {
/* 1162 */       return 0;
/*      */     }
/* 1164 */     if (strFieldName.equals("eMail")) {
/* 1165 */       return 0;
/*      */     }
/* 1167 */     if (strFieldName.equals("operator")) {
/* 1168 */       return 0;
/*      */     }
/* 1170 */     if (strFieldName.equals("modifyOperator")) {
/* 1171 */       return 0;
/*      */     }
/* 1173 */     if (strFieldName.equals("makeDate")) {
/* 1174 */       return 1;
/*      */     }
/* 1176 */     if (strFieldName.equals("makeTime")) {
/* 1177 */       return 0;
/*      */     }
/* 1179 */     if (strFieldName.equals("modifyDate")) {
/* 1180 */       return 1;
/*      */     }
/* 1182 */     if (strFieldName.equals("modifyTime")) {
/* 1183 */       return 0;
/*      */     }
/* 1185 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1191 */     int nFieldType = -1;
/* 1192 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1194 */       nFieldType = 0;
/* 1195 */       break;
/*      */     case 1:
/* 1197 */       nFieldType = 0;
/* 1198 */       break;
/*      */     case 2:
/* 1200 */       nFieldType = 0;
/* 1201 */       break;
/*      */     case 3:
/* 1203 */       nFieldType = 0;
/* 1204 */       break;
/*      */     case 4:
/* 1206 */       nFieldType = 0;
/* 1207 */       break;
/*      */     case 5:
/* 1209 */       nFieldType = 1;
/* 1210 */       break;
/*      */     case 6:
/* 1212 */       nFieldType = 0;
/* 1213 */       break;
/*      */     case 7:
/* 1215 */       nFieldType = 0;
/* 1216 */       break;
/*      */     case 8:
/* 1218 */       nFieldType = 0;
/* 1219 */       break;
/*      */     case 9:
/* 1221 */       nFieldType = 1;
/* 1222 */       break;
/*      */     case 10:
/* 1224 */       nFieldType = 1;
/* 1225 */       break;
/*      */     case 11:
/* 1227 */       nFieldType = 0;
/* 1228 */       break;
/*      */     case 12:
/* 1230 */       nFieldType = 0;
/* 1231 */       break;
/*      */     case 13:
/* 1233 */       nFieldType = 0;
/* 1234 */       break;
/*      */     case 14:
/* 1236 */       nFieldType = 0;
/* 1237 */       break;
/*      */     case 15:
/* 1239 */       nFieldType = 0;
/* 1240 */       break;
/*      */     case 16:
/* 1242 */       nFieldType = 0;
/* 1243 */       break;
/*      */     case 17:
/* 1245 */       nFieldType = 1;
/* 1246 */       break;
/*      */     case 18:
/* 1248 */       nFieldType = 0;
/* 1249 */       break;
/*      */     case 19:
/* 1251 */       nFieldType = 1;
/* 1252 */       break;
/*      */     case 20:
/* 1254 */       nFieldType = 0;
/* 1255 */       break;
/*      */     default:
/* 1257 */       nFieldType = -1;
/*      */     }
/* 1259 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MUserSchema
 * JD-Core Version:    0.6.0
 */