/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MPublicMessageDB;
/*      */ import com.sinosoft.map.lis.pubfun.FDate;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.ChgData;
/*      */ import com.sinosoft.map.utility.Schema;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class MPublicMessageSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String manageCom;
/*      */   private String receiveBranch;
/*      */   private String branchType;
/*      */   private String message;
/*      */   private String type;
/*      */   private String author;
/*      */   private String state;
/*      */   private Date startDate;
/*      */   private Date endDate;
/*      */   private String startTime;
/*      */   private String endTime;
/*      */   private String vF01;
/*      */   private String nF01;
/*      */   private int iF01;
/*      */   private double dF02;
/*      */   private Date date01;
/*      */   private String operator;
/*      */   private String modifyOperator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String checkState;
/*      */   private String checkOperator;
/*      */   private String checkReason;
/*      */   private Date checkDate;
/*      */   private String checkTime;
/*      */   public static final int FIELDNUM = 28;
/*      */   private static String[] PK;
/*   80 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MPublicMessageSchema()
/*      */   {
/*   87 */     this.mErrors = new CErrors();
/*      */ 
/*   89 */     String[] pk = new String[1];
/*   90 */     pk[0] = "ID";
/*      */ 
/*   92 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   99 */     MPublicMessageSchema cloned = (MPublicMessageSchema)super.clone();
/*  100 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  101 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  102 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  108 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  113 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  117 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  121 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  125 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getReceiveBranch() {
/*  129 */     return this.receiveBranch;
/*      */   }
/*      */ 
/*      */   public void setReceiveBranch(String aReceiveBranch) {
/*  133 */     this.receiveBranch = aReceiveBranch;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  137 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  141 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/*  145 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String aMessage) {
/*  149 */     this.message = aMessage;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  153 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  157 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public String getAuthor() {
/*  161 */     return this.author;
/*      */   }
/*      */ 
/*      */   public void setAuthor(String aAuthor) {
/*  165 */     this.author = aAuthor;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  169 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  173 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  177 */     if (this.startDate != null) {
/*  178 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  180 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  184 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  188 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  190 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  193 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  198 */     if (this.endDate != null) {
/*  199 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  201 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  205 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  209 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  211 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  214 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartTime()
/*      */   {
/*  219 */     return this.startTime;
/*      */   }
/*      */ 
/*      */   public void setStartTime(String aStartTime) {
/*  223 */     this.startTime = aStartTime;
/*      */   }
/*      */ 
/*      */   public String getEndTime() {
/*  227 */     return this.endTime;
/*      */   }
/*      */ 
/*      */   public void setEndTime(String aEndTime) {
/*  231 */     this.endTime = aEndTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  235 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  239 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  243 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  247 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  251 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  255 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  259 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  261 */       Integer tInteger = new Integer(aIF01);
/*  262 */       int i = tInteger.intValue();
/*  263 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  269 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  273 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  277 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  279 */       Double tDouble = new Double(aDF02);
/*  280 */       double d = tDouble.doubleValue();
/*  281 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  287 */     if (this.date01 != null) {
/*  288 */       return this.fDate.getString(this.date01);
/*      */     }
/*  290 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  294 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  298 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  300 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  303 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  308 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  312 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator() {
/*  316 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  320 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  324 */     if (this.makeDate != null) {
/*  325 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  327 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  331 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  335 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  337 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  340 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  345 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  349 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  353 */     if (this.modifyDate != null) {
/*  354 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  356 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  360 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  364 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  366 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  369 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  374 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  378 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getCheckState() {
/*  382 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  386 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  390 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  394 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  398 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  402 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  406 */     if (this.checkDate != null) {
/*  407 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  409 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  413 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  417 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  419 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  422 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  427 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  431 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MPublicMessageSchema aMPublicMessageSchema)
/*      */   {
/*  437 */     this.iD = aMPublicMessageSchema.getID();
/*  438 */     this.manageCom = aMPublicMessageSchema.getManageCom();
/*  439 */     this.receiveBranch = aMPublicMessageSchema.getReceiveBranch();
/*  440 */     this.branchType = aMPublicMessageSchema.getBranchType();
/*  441 */     this.message = aMPublicMessageSchema.getMessage();
/*  442 */     this.type = aMPublicMessageSchema.getType();
/*  443 */     this.author = aMPublicMessageSchema.getAuthor();
/*  444 */     this.state = aMPublicMessageSchema.getState();
/*  445 */     this.startDate = this.fDate.getDate(aMPublicMessageSchema.getStartDate());
/*  446 */     this.endDate = this.fDate.getDate(aMPublicMessageSchema.getEndDate());
/*  447 */     this.startTime = aMPublicMessageSchema.getStartTime();
/*  448 */     this.endTime = aMPublicMessageSchema.getEndTime();
/*  449 */     this.vF01 = aMPublicMessageSchema.getVF01();
/*  450 */     this.nF01 = aMPublicMessageSchema.getNF01();
/*  451 */     this.iF01 = aMPublicMessageSchema.getIF01();
/*  452 */     this.dF02 = aMPublicMessageSchema.getDF02();
/*  453 */     this.date01 = this.fDate.getDate(aMPublicMessageSchema.getDate01());
/*  454 */     this.operator = aMPublicMessageSchema.getOperator();
/*  455 */     this.modifyOperator = aMPublicMessageSchema.getModifyOperator();
/*  456 */     this.makeDate = this.fDate.getDate(aMPublicMessageSchema.getMakeDate());
/*  457 */     this.makeTime = aMPublicMessageSchema.getMakeTime();
/*  458 */     this.modifyDate = this.fDate.getDate(aMPublicMessageSchema.getModifyDate());
/*  459 */     this.modifyTime = aMPublicMessageSchema.getModifyTime();
/*  460 */     this.checkState = aMPublicMessageSchema.getCheckState();
/*  461 */     this.checkOperator = aMPublicMessageSchema.getCheckOperator();
/*  462 */     this.checkReason = aMPublicMessageSchema.getCheckReason();
/*  463 */     this.checkDate = this.fDate.getDate(aMPublicMessageSchema.getCheckDate());
/*  464 */     this.checkTime = aMPublicMessageSchema.getCheckTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  473 */       if (rs.getString("ID") == null)
/*  474 */         this.iD = null;
/*      */       else {
/*  476 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  478 */       if (rs.getString("ManageCom") == null)
/*  479 */         this.manageCom = null;
/*      */       else {
/*  481 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  483 */       if (rs.getString("ReceiveBranch") == null)
/*  484 */         this.receiveBranch = null;
/*      */       else {
/*  486 */         this.receiveBranch = rs.getString("ReceiveBranch").trim();
/*      */       }
/*  488 */       if (rs.getString("BranchType") == null)
/*  489 */         this.branchType = null;
/*      */       else {
/*  491 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  493 */       if (rs.getString("Message") == null)
/*  494 */         this.message = null;
/*      */       else {
/*  496 */         this.message = rs.getString("Message").trim();
/*      */       }
/*  498 */       if (rs.getString("Type") == null)
/*  499 */         this.type = null;
/*      */       else {
/*  501 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  503 */       if (rs.getString("Author") == null)
/*  504 */         this.author = null;
/*      */       else {
/*  506 */         this.author = rs.getString("Author").trim();
/*      */       }
/*  508 */       if (rs.getString("State") == null)
/*  509 */         this.state = null;
/*      */       else {
/*  511 */         this.state = rs.getString("State").trim();
/*      */       }
/*  513 */       this.startDate = rs.getDate("StartDate");
/*  514 */       this.endDate = rs.getDate("EndDate");
/*  515 */       if (rs.getString("StartTime") == null)
/*  516 */         this.startTime = null;
/*      */       else {
/*  518 */         this.startTime = rs.getString("StartTime").trim();
/*      */       }
/*  520 */       if (rs.getString("EndTime") == null)
/*  521 */         this.endTime = null;
/*      */       else {
/*  523 */         this.endTime = rs.getString("EndTime").trim();
/*      */       }
/*  525 */       if (rs.getString("VF01") == null)
/*  526 */         this.vF01 = null;
/*      */       else {
/*  528 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  530 */       if (rs.getString("NF01") == null)
/*  531 */         this.nF01 = null;
/*      */       else {
/*  533 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  535 */       this.iF01 = rs.getInt("IF01");
/*  536 */       this.dF02 = rs.getDouble("DF02");
/*  537 */       this.date01 = rs.getDate("Date01");
/*  538 */       if (rs.getString("Operator") == null)
/*  539 */         this.operator = null;
/*      */       else {
/*  541 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  543 */       if (rs.getString("ModifyOperator") == null)
/*  544 */         this.modifyOperator = null;
/*      */       else {
/*  546 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  548 */       this.makeDate = rs.getDate("MakeDate");
/*  549 */       if (rs.getString("MakeTime") == null)
/*  550 */         this.makeTime = null;
/*      */       else {
/*  552 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  554 */       this.modifyDate = rs.getDate("ModifyDate");
/*  555 */       if (rs.getString("ModifyTime") == null)
/*  556 */         this.modifyTime = null;
/*      */       else {
/*  558 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  560 */       if (rs.getString("CheckState") == null)
/*  561 */         this.checkState = null;
/*      */       else {
/*  563 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  565 */       if (rs.getString("CheckOperator") == null)
/*  566 */         this.checkOperator = null;
/*      */       else {
/*  568 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  570 */       if (rs.getString("CheckReason") == null)
/*  571 */         this.checkReason = null;
/*      */       else {
/*  573 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  575 */       this.checkDate = rs.getDate("CheckDate");
/*  576 */       if (rs.getString("CheckTime") == null)
/*  577 */         this.checkTime = null;
/*      */       else {
/*  579 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  584 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MPublicMessage\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  586 */       CError tError = new CError();
/*  587 */       tError.moduleName = "MPublicMessageSchema";
/*  588 */       tError.functionName = "setSchema";
/*  589 */       tError.errorMessage = sqle.toString();
/*  590 */       this.mErrors.addOneError(tError);
/*  591 */       return false;
/*      */     }
/*  593 */     return true;
/*      */   }
/*      */ 
/*      */   public MPublicMessageSchema getSchema()
/*      */   {
/*  598 */     MPublicMessageSchema aMPublicMessageSchema = new MPublicMessageSchema();
/*  599 */     aMPublicMessageSchema.setSchema(this);
/*  600 */     return aMPublicMessageSchema;
/*      */   }
/*      */ 
/*      */   public MPublicMessageDB getDB()
/*      */   {
/*  605 */     MPublicMessageDB aDBOper = new MPublicMessageDB();
/*  606 */     aDBOper.setSchema(this);
/*  607 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  614 */     StringBuffer strReturn = new StringBuffer(256);
/*  615 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  616 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  617 */     strReturn.append(StrTool.cTrim(this.receiveBranch)); strReturn.append("|");
/*  618 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  619 */     strReturn.append(StrTool.cTrim(this.message)); strReturn.append("|");
/*  620 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  621 */     strReturn.append(StrTool.cTrim(this.author)); strReturn.append("|");
/*  622 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  623 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  624 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  625 */     strReturn.append(StrTool.cTrim(this.startTime)); strReturn.append("|");
/*  626 */     strReturn.append(StrTool.cTrim(this.endTime)); strReturn.append("|");
/*  627 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  628 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  629 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  630 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  631 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  632 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  633 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  634 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  635 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  636 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  637 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  638 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  639 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  640 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  641 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  642 */     strReturn.append(StrTool.cTrim(this.checkTime));
/*  643 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  651 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  652 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  653 */       this.receiveBranch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  654 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  655 */       this.message = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  656 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  657 */       this.author = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  658 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  659 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/*  660 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*  661 */       this.startTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  662 */       this.endTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  663 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  664 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  665 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).intValue();
/*  666 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|"))).doubleValue();
/*  667 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  668 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  669 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  670 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  671 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  672 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  673 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  674 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  675 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  676 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  677 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
/*  678 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  683 */       CError tError = new CError();
/*  684 */       tError.moduleName = "MPublicMessageSchema";
/*  685 */       tError.functionName = "decode";
/*  686 */       tError.errorMessage = ex.toString();
/*  687 */       this.mErrors.addOneError(tError);
/*      */ 
/*  689 */       return false;
/*      */     }
/*  691 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  697 */     String strReturn = "";
/*  698 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  700 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  704 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  706 */     if (FCode.equalsIgnoreCase("receiveBranch"))
/*      */     {
/*  708 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.receiveBranch));
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  712 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  714 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/*  716 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.message));
/*      */     }
/*  718 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  720 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  722 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/*  724 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.author));
/*      */     }
/*  726 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  728 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  730 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  732 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  734 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  736 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/*  740 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startTime));
/*      */     }
/*  742 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/*  744 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endTime));
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  748 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  750 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  752 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  754 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  756 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  758 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  760 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  762 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  764 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  766 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  768 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  770 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  772 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  774 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  776 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  778 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  780 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  782 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  784 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  786 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  788 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  790 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  792 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  794 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  796 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  798 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  800 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  802 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  804 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  806 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  808 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  810 */     if (strReturn.equals(""))
/*      */     {
/*  812 */       strReturn = "null";
/*      */     }
/*      */ 
/*  815 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  822 */     String strFieldValue = "";
/*  823 */     switch (nFieldIndex) {
/*      */     case 0:
/*  825 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  826 */       break;
/*      */     case 1:
/*  828 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  829 */       break;
/*      */     case 2:
/*  831 */       strFieldValue = StrTool.GBKToUnicode(this.receiveBranch);
/*  832 */       break;
/*      */     case 3:
/*  834 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  835 */       break;
/*      */     case 4:
/*  837 */       strFieldValue = StrTool.GBKToUnicode(this.message);
/*  838 */       break;
/*      */     case 5:
/*  840 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  841 */       break;
/*      */     case 6:
/*  843 */       strFieldValue = StrTool.GBKToUnicode(this.author);
/*  844 */       break;
/*      */     case 7:
/*  846 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  847 */       break;
/*      */     case 8:
/*  849 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  850 */       break;
/*      */     case 9:
/*  852 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*  853 */       break;
/*      */     case 10:
/*  855 */       strFieldValue = StrTool.GBKToUnicode(this.startTime);
/*  856 */       break;
/*      */     case 11:
/*  858 */       strFieldValue = StrTool.GBKToUnicode(this.endTime);
/*  859 */       break;
/*      */     case 12:
/*  861 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  862 */       break;
/*      */     case 13:
/*  864 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  865 */       break;
/*      */     case 14:
/*  867 */       strFieldValue = String.valueOf(this.iF01);
/*  868 */       break;
/*      */     case 15:
/*  870 */       strFieldValue = String.valueOf(this.dF02);
/*  871 */       break;
/*      */     case 16:
/*  873 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  874 */       break;
/*      */     case 17:
/*  876 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  877 */       break;
/*      */     case 18:
/*  879 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  880 */       break;
/*      */     case 19:
/*  882 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  883 */       break;
/*      */     case 20:
/*  885 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  886 */       break;
/*      */     case 21:
/*  888 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  889 */       break;
/*      */     case 22:
/*  891 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  892 */       break;
/*      */     case 23:
/*  894 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/*  895 */       break;
/*      */     case 24:
/*  897 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/*  898 */       break;
/*      */     case 25:
/*  900 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/*  901 */       break;
/*      */     case 26:
/*  903 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*  904 */       break;
/*      */     case 27:
/*  906 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/*  907 */       break;
/*      */     default:
/*  909 */       strFieldValue = "";
/*      */     }
/*  911 */     if (strFieldValue.equals("")) {
/*  912 */       strFieldValue = "null";
/*      */     }
/*  914 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  920 */     if (StrTool.cTrim(FCode).equals("")) {
/*  921 */       return false;
/*      */     }
/*  923 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  925 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  927 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  930 */         this.iD = null;
/*      */     }
/*  932 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  934 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  936 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  939 */         this.manageCom = null;
/*      */     }
/*  941 */     if (FCode.equalsIgnoreCase("receiveBranch"))
/*      */     {
/*  943 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  945 */         this.receiveBranch = FValue.trim();
/*      */       }
/*      */       else
/*  948 */         this.receiveBranch = null;
/*      */     }
/*  950 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  952 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  954 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  957 */         this.branchType = null;
/*      */     }
/*  959 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/*  961 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  963 */         this.message = FValue.trim();
/*      */       }
/*      */       else
/*  966 */         this.message = null;
/*      */     }
/*  968 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  970 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  972 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/*  975 */         this.type = null;
/*      */     }
/*  977 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/*  979 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  981 */         this.author = FValue.trim();
/*      */       }
/*      */       else
/*  984 */         this.author = null;
/*      */     }
/*  986 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  988 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  990 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  993 */         this.state = null;
/*      */     }
/*  995 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  997 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  999 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1002 */         this.startDate = null;
/*      */     }
/* 1004 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 1006 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1008 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1011 */         this.endDate = null;
/*      */     }
/* 1013 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/* 1015 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1017 */         this.startTime = FValue.trim();
/*      */       }
/*      */       else
/* 1020 */         this.startTime = null;
/*      */     }
/* 1022 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/* 1024 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1026 */         this.endTime = FValue.trim();
/*      */       }
/*      */       else
/* 1029 */         this.endTime = null;
/*      */     }
/* 1031 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1033 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1035 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1038 */         this.vF01 = null;
/*      */     }
/* 1040 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1042 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1044 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1047 */         this.nF01 = null;
/*      */     }
/* 1049 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1051 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1053 */         Integer tInteger = new Integer(FValue);
/* 1054 */         int i = tInteger.intValue();
/* 1055 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1058 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1060 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1062 */         Double tDouble = new Double(FValue);
/* 1063 */         double d = tDouble.doubleValue();
/* 1064 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1067 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1069 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1071 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1074 */         this.date01 = null;
/*      */     }
/* 1076 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1078 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1080 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1083 */         this.operator = null;
/*      */     }
/* 1085 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1087 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1089 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1092 */         this.modifyOperator = null;
/*      */     }
/* 1094 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1096 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1098 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1101 */         this.makeDate = null;
/*      */     }
/* 1103 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1105 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1107 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1110 */         this.makeTime = null;
/*      */     }
/* 1112 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1114 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1116 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1119 */         this.modifyDate = null;
/*      */     }
/* 1121 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1123 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1125 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1128 */         this.modifyTime = null;
/*      */     }
/* 1130 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/* 1132 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1134 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/* 1137 */         this.checkState = null;
/*      */     }
/* 1139 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/* 1141 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1143 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1146 */         this.checkOperator = null;
/*      */     }
/* 1148 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/* 1150 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1152 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/* 1155 */         this.checkReason = null;
/*      */     }
/* 1157 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/* 1159 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1161 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1164 */         this.checkDate = null;
/*      */     }
/* 1166 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/* 1168 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1170 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/* 1173 */         this.checkTime = null;
/*      */     }
/* 1175 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1180 */     if (otherObject == null) return false;
/* 1181 */     if (this == otherObject) return true;
/* 1182 */     if (getClass() != otherObject.getClass()) return false;
/* 1183 */     MPublicMessageSchema other = (MPublicMessageSchema)otherObject;
/* 1184 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 1185 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 1186 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1187 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1188 */     if ((this.receiveBranch == null) && (other.getReceiveBranch() != null)) return false;
/* 1189 */     if ((this.receiveBranch != null) && (!this.receiveBranch.equals(other.getReceiveBranch()))) return false;
/* 1190 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1191 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1192 */     if ((this.message == null) && (other.getMessage() != null)) return false;
/* 1193 */     if ((this.message != null) && (!this.message.equals(other.getMessage()))) return false;
/* 1194 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 1195 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 1196 */     if ((this.author == null) && (other.getAuthor() != null)) return false;
/* 1197 */     if ((this.author != null) && (!this.author.equals(other.getAuthor()))) return false;
/* 1198 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1199 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1200 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 1201 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 1202 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 1203 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 1204 */     if ((this.startTime == null) && (other.getStartTime() != null)) return false;
/* 1205 */     if ((this.startTime != null) && (!this.startTime.equals(other.getStartTime()))) return false;
/* 1206 */     if ((this.endTime == null) && (other.getEndTime() != null)) return false;
/* 1207 */     if ((this.endTime != null) && (!this.endTime.equals(other.getEndTime()))) return false;
/* 1208 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1209 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1210 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1211 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1212 */     if (this.iF01 != other.getIF01()) return false;
/* 1213 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1214 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1215 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1216 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1217 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1218 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1219 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1220 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1221 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1222 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1223 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1224 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1225 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1226 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1227 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1228 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1229 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1230 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1231 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1232 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1233 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1234 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1235 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1236 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1237 */     return (this.checkTime == null) || (this.checkTime.equals(other.getCheckTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1244 */     return 28;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1250 */     if (strFieldName.equals("iD")) {
/* 1251 */       return 0;
/*      */     }
/* 1253 */     if (strFieldName.equals("manageCom")) {
/* 1254 */       return 1;
/*      */     }
/* 1256 */     if (strFieldName.equals("receiveBranch")) {
/* 1257 */       return 2;
/*      */     }
/* 1259 */     if (strFieldName.equals("branchType")) {
/* 1260 */       return 3;
/*      */     }
/* 1262 */     if (strFieldName.equals("message")) {
/* 1263 */       return 4;
/*      */     }
/* 1265 */     if (strFieldName.equals("type")) {
/* 1266 */       return 5;
/*      */     }
/* 1268 */     if (strFieldName.equals("author")) {
/* 1269 */       return 6;
/*      */     }
/* 1271 */     if (strFieldName.equals("state")) {
/* 1272 */       return 7;
/*      */     }
/* 1274 */     if (strFieldName.equals("startDate")) {
/* 1275 */       return 8;
/*      */     }
/* 1277 */     if (strFieldName.equals("endDate")) {
/* 1278 */       return 9;
/*      */     }
/* 1280 */     if (strFieldName.equals("startTime")) {
/* 1281 */       return 10;
/*      */     }
/* 1283 */     if (strFieldName.equals("endTime")) {
/* 1284 */       return 11;
/*      */     }
/* 1286 */     if (strFieldName.equals("vF01")) {
/* 1287 */       return 12;
/*      */     }
/* 1289 */     if (strFieldName.equals("nF01")) {
/* 1290 */       return 13;
/*      */     }
/* 1292 */     if (strFieldName.equals("iF01")) {
/* 1293 */       return 14;
/*      */     }
/* 1295 */     if (strFieldName.equals("dF02")) {
/* 1296 */       return 15;
/*      */     }
/* 1298 */     if (strFieldName.equals("date01")) {
/* 1299 */       return 16;
/*      */     }
/* 1301 */     if (strFieldName.equals("operator")) {
/* 1302 */       return 17;
/*      */     }
/* 1304 */     if (strFieldName.equals("modifyOperator")) {
/* 1305 */       return 18;
/*      */     }
/* 1307 */     if (strFieldName.equals("makeDate")) {
/* 1308 */       return 19;
/*      */     }
/* 1310 */     if (strFieldName.equals("makeTime")) {
/* 1311 */       return 20;
/*      */     }
/* 1313 */     if (strFieldName.equals("modifyDate")) {
/* 1314 */       return 21;
/*      */     }
/* 1316 */     if (strFieldName.equals("modifyTime")) {
/* 1317 */       return 22;
/*      */     }
/* 1319 */     if (strFieldName.equals("checkState")) {
/* 1320 */       return 23;
/*      */     }
/* 1322 */     if (strFieldName.equals("checkOperator")) {
/* 1323 */       return 24;
/*      */     }
/* 1325 */     if (strFieldName.equals("checkReason")) {
/* 1326 */       return 25;
/*      */     }
/* 1328 */     if (strFieldName.equals("checkDate")) {
/* 1329 */       return 26;
/*      */     }
/* 1331 */     if (strFieldName.equals("checkTime")) {
/* 1332 */       return 27;
/*      */     }
/* 1334 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1340 */     String strFieldName = "";
/* 1341 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1343 */       strFieldName = "iD";
/* 1344 */       break;
/*      */     case 1:
/* 1346 */       strFieldName = "manageCom";
/* 1347 */       break;
/*      */     case 2:
/* 1349 */       strFieldName = "receiveBranch";
/* 1350 */       break;
/*      */     case 3:
/* 1352 */       strFieldName = "branchType";
/* 1353 */       break;
/*      */     case 4:
/* 1355 */       strFieldName = "message";
/* 1356 */       break;
/*      */     case 5:
/* 1358 */       strFieldName = "type";
/* 1359 */       break;
/*      */     case 6:
/* 1361 */       strFieldName = "author";
/* 1362 */       break;
/*      */     case 7:
/* 1364 */       strFieldName = "state";
/* 1365 */       break;
/*      */     case 8:
/* 1367 */       strFieldName = "startDate";
/* 1368 */       break;
/*      */     case 9:
/* 1370 */       strFieldName = "endDate";
/* 1371 */       break;
/*      */     case 10:
/* 1373 */       strFieldName = "startTime";
/* 1374 */       break;
/*      */     case 11:
/* 1376 */       strFieldName = "endTime";
/* 1377 */       break;
/*      */     case 12:
/* 1379 */       strFieldName = "vF01";
/* 1380 */       break;
/*      */     case 13:
/* 1382 */       strFieldName = "nF01";
/* 1383 */       break;
/*      */     case 14:
/* 1385 */       strFieldName = "iF01";
/* 1386 */       break;
/*      */     case 15:
/* 1388 */       strFieldName = "dF02";
/* 1389 */       break;
/*      */     case 16:
/* 1391 */       strFieldName = "date01";
/* 1392 */       break;
/*      */     case 17:
/* 1394 */       strFieldName = "operator";
/* 1395 */       break;
/*      */     case 18:
/* 1397 */       strFieldName = "modifyOperator";
/* 1398 */       break;
/*      */     case 19:
/* 1400 */       strFieldName = "makeDate";
/* 1401 */       break;
/*      */     case 20:
/* 1403 */       strFieldName = "makeTime";
/* 1404 */       break;
/*      */     case 21:
/* 1406 */       strFieldName = "modifyDate";
/* 1407 */       break;
/*      */     case 22:
/* 1409 */       strFieldName = "modifyTime";
/* 1410 */       break;
/*      */     case 23:
/* 1412 */       strFieldName = "checkState";
/* 1413 */       break;
/*      */     case 24:
/* 1415 */       strFieldName = "checkOperator";
/* 1416 */       break;
/*      */     case 25:
/* 1418 */       strFieldName = "checkReason";
/* 1419 */       break;
/*      */     case 26:
/* 1421 */       strFieldName = "checkDate";
/* 1422 */       break;
/*      */     case 27:
/* 1424 */       strFieldName = "checkTime";
/* 1425 */       break;
/*      */     default:
/* 1427 */       strFieldName = "";
/*      */     }
/* 1429 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1435 */     if (strFieldName.equals("iD")) {
/* 1436 */       return 0;
/*      */     }
/* 1438 */     if (strFieldName.equals("manageCom")) {
/* 1439 */       return 0;
/*      */     }
/* 1441 */     if (strFieldName.equals("receiveBranch")) {
/* 1442 */       return 0;
/*      */     }
/* 1444 */     if (strFieldName.equals("branchType")) {
/* 1445 */       return 0;
/*      */     }
/* 1447 */     if (strFieldName.equals("message")) {
/* 1448 */       return 0;
/*      */     }
/* 1450 */     if (strFieldName.equals("type")) {
/* 1451 */       return 0;
/*      */     }
/* 1453 */     if (strFieldName.equals("author")) {
/* 1454 */       return 0;
/*      */     }
/* 1456 */     if (strFieldName.equals("state")) {
/* 1457 */       return 0;
/*      */     }
/* 1459 */     if (strFieldName.equals("startDate")) {
/* 1460 */       return 1;
/*      */     }
/* 1462 */     if (strFieldName.equals("endDate")) {
/* 1463 */       return 1;
/*      */     }
/* 1465 */     if (strFieldName.equals("startTime")) {
/* 1466 */       return 0;
/*      */     }
/* 1468 */     if (strFieldName.equals("endTime")) {
/* 1469 */       return 0;
/*      */     }
/* 1471 */     if (strFieldName.equals("vF01")) {
/* 1472 */       return 0;
/*      */     }
/* 1474 */     if (strFieldName.equals("nF01")) {
/* 1475 */       return 0;
/*      */     }
/* 1477 */     if (strFieldName.equals("iF01")) {
/* 1478 */       return 3;
/*      */     }
/* 1480 */     if (strFieldName.equals("dF02")) {
/* 1481 */       return 4;
/*      */     }
/* 1483 */     if (strFieldName.equals("date01")) {
/* 1484 */       return 1;
/*      */     }
/* 1486 */     if (strFieldName.equals("operator")) {
/* 1487 */       return 0;
/*      */     }
/* 1489 */     if (strFieldName.equals("modifyOperator")) {
/* 1490 */       return 0;
/*      */     }
/* 1492 */     if (strFieldName.equals("makeDate")) {
/* 1493 */       return 1;
/*      */     }
/* 1495 */     if (strFieldName.equals("makeTime")) {
/* 1496 */       return 0;
/*      */     }
/* 1498 */     if (strFieldName.equals("modifyDate")) {
/* 1499 */       return 1;
/*      */     }
/* 1501 */     if (strFieldName.equals("modifyTime")) {
/* 1502 */       return 0;
/*      */     }
/* 1504 */     if (strFieldName.equals("checkState")) {
/* 1505 */       return 0;
/*      */     }
/* 1507 */     if (strFieldName.equals("checkOperator")) {
/* 1508 */       return 0;
/*      */     }
/* 1510 */     if (strFieldName.equals("checkReason")) {
/* 1511 */       return 0;
/*      */     }
/* 1513 */     if (strFieldName.equals("checkDate")) {
/* 1514 */       return 1;
/*      */     }
/* 1516 */     if (strFieldName.equals("checkTime")) {
/* 1517 */       return 0;
/*      */     }
/* 1519 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1525 */     int nFieldType = -1;
/* 1526 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1528 */       nFieldType = 0;
/* 1529 */       break;
/*      */     case 1:
/* 1531 */       nFieldType = 0;
/* 1532 */       break;
/*      */     case 2:
/* 1534 */       nFieldType = 0;
/* 1535 */       break;
/*      */     case 3:
/* 1537 */       nFieldType = 0;
/* 1538 */       break;
/*      */     case 4:
/* 1540 */       nFieldType = 0;
/* 1541 */       break;
/*      */     case 5:
/* 1543 */       nFieldType = 0;
/* 1544 */       break;
/*      */     case 6:
/* 1546 */       nFieldType = 0;
/* 1547 */       break;
/*      */     case 7:
/* 1549 */       nFieldType = 0;
/* 1550 */       break;
/*      */     case 8:
/* 1552 */       nFieldType = 1;
/* 1553 */       break;
/*      */     case 9:
/* 1555 */       nFieldType = 1;
/* 1556 */       break;
/*      */     case 10:
/* 1558 */       nFieldType = 0;
/* 1559 */       break;
/*      */     case 11:
/* 1561 */       nFieldType = 0;
/* 1562 */       break;
/*      */     case 12:
/* 1564 */       nFieldType = 0;
/* 1565 */       break;
/*      */     case 13:
/* 1567 */       nFieldType = 0;
/* 1568 */       break;
/*      */     case 14:
/* 1570 */       nFieldType = 3;
/* 1571 */       break;
/*      */     case 15:
/* 1573 */       nFieldType = 4;
/* 1574 */       break;
/*      */     case 16:
/* 1576 */       nFieldType = 1;
/* 1577 */       break;
/*      */     case 17:
/* 1579 */       nFieldType = 0;
/* 1580 */       break;
/*      */     case 18:
/* 1582 */       nFieldType = 0;
/* 1583 */       break;
/*      */     case 19:
/* 1585 */       nFieldType = 1;
/* 1586 */       break;
/*      */     case 20:
/* 1588 */       nFieldType = 0;
/* 1589 */       break;
/*      */     case 21:
/* 1591 */       nFieldType = 1;
/* 1592 */       break;
/*      */     case 22:
/* 1594 */       nFieldType = 0;
/* 1595 */       break;
/*      */     case 23:
/* 1597 */       nFieldType = 0;
/* 1598 */       break;
/*      */     case 24:
/* 1600 */       nFieldType = 0;
/* 1601 */       break;
/*      */     case 25:
/* 1603 */       nFieldType = 0;
/* 1604 */       break;
/*      */     case 26:
/* 1606 */       nFieldType = 1;
/* 1607 */       break;
/*      */     case 27:
/* 1609 */       nFieldType = 0;
/* 1610 */       break;
/*      */     default:
/* 1612 */       nFieldType = -1;
/*      */     }
/* 1614 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MPublicMessageSchema
 * JD-Core Version:    0.6.0
 */