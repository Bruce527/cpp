/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MPrivateMessageBDB;
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
/*      */ public class MPrivateMessageBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String agentCode;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String message;
/*      */   private String messageType;
/*      */   private String keyData;
/*      */   private String keyData2;
/*      */   private String keyData3;
/*      */   private String keyData4;
/*      */   private String uRL;
/*      */   private String type;
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
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   public static final int FIELDNUM = 31;
/*      */   private static String[] PK;
/*   86 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MPrivateMessageBSchema()
/*      */   {
/*   93 */     this.mErrors = new CErrors();
/*      */ 
/*   95 */     String[] pk = new String[1];
/*   96 */     pk[0] = "ID";
/*      */ 
/*   98 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  105 */     MPrivateMessageBSchema cloned = (MPrivateMessageBSchema)super.clone();
/*  106 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  107 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  108 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  114 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  119 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  123 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  127 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  131 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  135 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  139 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  143 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  147 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/*  151 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String aMessage) {
/*  155 */     this.message = aMessage;
/*      */   }
/*      */ 
/*      */   public String getMessageType() {
/*  159 */     return this.messageType;
/*      */   }
/*      */ 
/*      */   public void setMessageType(String aMessageType) {
/*  163 */     this.messageType = aMessageType;
/*      */   }
/*      */ 
/*      */   public String getKeyData() {
/*  167 */     return this.keyData;
/*      */   }
/*      */ 
/*      */   public void setKeyData(String aKeyData) {
/*  171 */     this.keyData = aKeyData;
/*      */   }
/*      */ 
/*      */   public String getKeyData2() {
/*  175 */     return this.keyData2;
/*      */   }
/*      */ 
/*      */   public void setKeyData2(String aKeyData2) {
/*  179 */     this.keyData2 = aKeyData2;
/*      */   }
/*      */ 
/*      */   public String getKeyData3() {
/*  183 */     return this.keyData3;
/*      */   }
/*      */ 
/*      */   public void setKeyData3(String aKeyData3) {
/*  187 */     this.keyData3 = aKeyData3;
/*      */   }
/*      */ 
/*      */   public String getKeyData4() {
/*  191 */     return this.keyData4;
/*      */   }
/*      */ 
/*      */   public void setKeyData4(String aKeyData4) {
/*  195 */     this.keyData4 = aKeyData4;
/*      */   }
/*      */ 
/*      */   public String getURL() {
/*  199 */     return this.uRL;
/*      */   }
/*      */ 
/*      */   public void setURL(String aURL) {
/*  203 */     this.uRL = aURL;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  207 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  211 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  215 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  219 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  223 */     if (this.startDate != null) {
/*  224 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  226 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  230 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  234 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  236 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  239 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  244 */     if (this.endDate != null) {
/*  245 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  247 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  251 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  255 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  257 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  260 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartTime()
/*      */   {
/*  265 */     return this.startTime;
/*      */   }
/*      */ 
/*      */   public void setStartTime(String aStartTime) {
/*  269 */     this.startTime = aStartTime;
/*      */   }
/*      */ 
/*      */   public String getEndTime() {
/*  273 */     return this.endTime;
/*      */   }
/*      */ 
/*      */   public void setEndTime(String aEndTime) {
/*  277 */     this.endTime = aEndTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  281 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  285 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  289 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  293 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  297 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  301 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  305 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  307 */       Integer tInteger = new Integer(aIF01);
/*  308 */       int i = tInteger.intValue();
/*  309 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  315 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  319 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  323 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  325 */       Double tDouble = new Double(aDF02);
/*  326 */       double d = tDouble.doubleValue();
/*  327 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  333 */     if (this.date01 != null) {
/*  334 */       return this.fDate.getString(this.date01);
/*      */     }
/*  336 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  340 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  344 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  346 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  349 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  354 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  358 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  362 */     if (this.makeDate != null) {
/*  363 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  365 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  369 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  373 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  375 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  378 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  383 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  387 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  391 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  395 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  399 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  403 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  407 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  411 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  415 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  419 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  423 */     if (this.makeDate2 != null) {
/*  424 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  426 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  430 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  434 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  436 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  439 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  444 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  448 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public void setSchema(MPrivateMessageBSchema aMPrivateMessageBSchema)
/*      */   {
/*  454 */     this.iD = aMPrivateMessageBSchema.getID();
/*  455 */     this.agentCode = aMPrivateMessageBSchema.getAgentCode();
/*  456 */     this.manageCom = aMPrivateMessageBSchema.getManageCom();
/*  457 */     this.branchType = aMPrivateMessageBSchema.getBranchType();
/*  458 */     this.message = aMPrivateMessageBSchema.getMessage();
/*  459 */     this.messageType = aMPrivateMessageBSchema.getMessageType();
/*  460 */     this.keyData = aMPrivateMessageBSchema.getKeyData();
/*  461 */     this.keyData2 = aMPrivateMessageBSchema.getKeyData2();
/*  462 */     this.keyData3 = aMPrivateMessageBSchema.getKeyData3();
/*  463 */     this.keyData4 = aMPrivateMessageBSchema.getKeyData4();
/*  464 */     this.uRL = aMPrivateMessageBSchema.getURL();
/*  465 */     this.type = aMPrivateMessageBSchema.getType();
/*  466 */     this.state = aMPrivateMessageBSchema.getState();
/*  467 */     this.startDate = this.fDate.getDate(aMPrivateMessageBSchema.getStartDate());
/*  468 */     this.endDate = this.fDate.getDate(aMPrivateMessageBSchema.getEndDate());
/*  469 */     this.startTime = aMPrivateMessageBSchema.getStartTime();
/*  470 */     this.endTime = aMPrivateMessageBSchema.getEndTime();
/*  471 */     this.vF01 = aMPrivateMessageBSchema.getVF01();
/*  472 */     this.nF01 = aMPrivateMessageBSchema.getNF01();
/*  473 */     this.iF01 = aMPrivateMessageBSchema.getIF01();
/*  474 */     this.dF02 = aMPrivateMessageBSchema.getDF02();
/*  475 */     this.date01 = this.fDate.getDate(aMPrivateMessageBSchema.getDate01());
/*  476 */     this.operator = aMPrivateMessageBSchema.getOperator();
/*  477 */     this.makeDate = this.fDate.getDate(aMPrivateMessageBSchema.getMakeDate());
/*  478 */     this.makeTime = aMPrivateMessageBSchema.getMakeTime();
/*  479 */     this.edorNo = aMPrivateMessageBSchema.getEdorNo();
/*  480 */     this.edorType = aMPrivateMessageBSchema.getEdorType();
/*  481 */     this.edorCase = aMPrivateMessageBSchema.getEdorCase();
/*  482 */     this.operator2 = aMPrivateMessageBSchema.getOperator2();
/*  483 */     this.makeDate2 = this.fDate.getDate(aMPrivateMessageBSchema.getMakeDate2());
/*  484 */     this.makeTime2 = aMPrivateMessageBSchema.getMakeTime2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  493 */       if (rs.getString("ID") == null)
/*  494 */         this.iD = null;
/*      */       else {
/*  496 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  498 */       if (rs.getString("AgentCode") == null)
/*  499 */         this.agentCode = null;
/*      */       else {
/*  501 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/*  503 */       if (rs.getString("ManageCom") == null)
/*  504 */         this.manageCom = null;
/*      */       else {
/*  506 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  508 */       if (rs.getString("BranchType") == null)
/*  509 */         this.branchType = null;
/*      */       else {
/*  511 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  513 */       if (rs.getString("Message") == null)
/*  514 */         this.message = null;
/*      */       else {
/*  516 */         this.message = rs.getString("Message").trim();
/*      */       }
/*  518 */       if (rs.getString("MessageType") == null)
/*  519 */         this.messageType = null;
/*      */       else {
/*  521 */         this.messageType = rs.getString("MessageType").trim();
/*      */       }
/*  523 */       if (rs.getString("KeyData") == null)
/*  524 */         this.keyData = null;
/*      */       else {
/*  526 */         this.keyData = rs.getString("KeyData").trim();
/*      */       }
/*  528 */       if (rs.getString("KeyData2") == null)
/*  529 */         this.keyData2 = null;
/*      */       else {
/*  531 */         this.keyData2 = rs.getString("KeyData2").trim();
/*      */       }
/*  533 */       if (rs.getString("KeyData3") == null)
/*  534 */         this.keyData3 = null;
/*      */       else {
/*  536 */         this.keyData3 = rs.getString("KeyData3").trim();
/*      */       }
/*  538 */       if (rs.getString("KeyData4") == null)
/*  539 */         this.keyData4 = null;
/*      */       else {
/*  541 */         this.keyData4 = rs.getString("KeyData4").trim();
/*      */       }
/*  543 */       if (rs.getString("URL") == null)
/*  544 */         this.uRL = null;
/*      */       else {
/*  546 */         this.uRL = rs.getString("URL").trim();
/*      */       }
/*  548 */       if (rs.getString("Type") == null)
/*  549 */         this.type = null;
/*      */       else {
/*  551 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  553 */       if (rs.getString("State") == null)
/*  554 */         this.state = null;
/*      */       else {
/*  556 */         this.state = rs.getString("State").trim();
/*      */       }
/*  558 */       this.startDate = rs.getDate("StartDate");
/*  559 */       this.endDate = rs.getDate("EndDate");
/*  560 */       if (rs.getString("StartTime") == null)
/*  561 */         this.startTime = null;
/*      */       else {
/*  563 */         this.startTime = rs.getString("StartTime").trim();
/*      */       }
/*  565 */       if (rs.getString("EndTime") == null)
/*  566 */         this.endTime = null;
/*      */       else {
/*  568 */         this.endTime = rs.getString("EndTime").trim();
/*      */       }
/*  570 */       if (rs.getString("VF01") == null)
/*  571 */         this.vF01 = null;
/*      */       else {
/*  573 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  575 */       if (rs.getString("NF01") == null)
/*  576 */         this.nF01 = null;
/*      */       else {
/*  578 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  580 */       this.iF01 = rs.getInt("IF01");
/*  581 */       this.dF02 = rs.getDouble("DF02");
/*  582 */       this.date01 = rs.getDate("Date01");
/*  583 */       if (rs.getString("Operator") == null)
/*  584 */         this.operator = null;
/*      */       else {
/*  586 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  588 */       this.makeDate = rs.getDate("MakeDate");
/*  589 */       if (rs.getString("MakeTime") == null)
/*  590 */         this.makeTime = null;
/*      */       else {
/*  592 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  594 */       if (rs.getString("EdorNo") == null)
/*  595 */         this.edorNo = null;
/*      */       else {
/*  597 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  599 */       if (rs.getString("EdorType") == null)
/*  600 */         this.edorType = null;
/*      */       else {
/*  602 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  604 */       if (rs.getString("EdorCase") == null)
/*  605 */         this.edorCase = null;
/*      */       else {
/*  607 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  609 */       if (rs.getString("Operator2") == null)
/*  610 */         this.operator2 = null;
/*      */       else {
/*  612 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  614 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  615 */       if (rs.getString("MakeTime2") == null)
/*  616 */         this.makeTime2 = null;
/*      */       else {
/*  618 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  623 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MPrivateMessageB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  625 */       CError tError = new CError();
/*  626 */       tError.moduleName = "MPrivateMessageBSchema";
/*  627 */       tError.functionName = "setSchema";
/*  628 */       tError.errorMessage = sqle.toString();
/*  629 */       this.mErrors.addOneError(tError);
/*  630 */       return false;
/*      */     }
/*  632 */     return true;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageBSchema getSchema()
/*      */   {
/*  637 */     MPrivateMessageBSchema aMPrivateMessageBSchema = new MPrivateMessageBSchema();
/*  638 */     aMPrivateMessageBSchema.setSchema(this);
/*  639 */     return aMPrivateMessageBSchema;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageBDB getDB()
/*      */   {
/*  644 */     MPrivateMessageBDB aDBOper = new MPrivateMessageBDB();
/*  645 */     aDBOper.setSchema(this);
/*  646 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  653 */     StringBuffer strReturn = new StringBuffer(256);
/*  654 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  655 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/*  656 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  657 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  658 */     strReturn.append(StrTool.cTrim(this.message)); strReturn.append("|");
/*  659 */     strReturn.append(StrTool.cTrim(this.messageType)); strReturn.append("|");
/*  660 */     strReturn.append(StrTool.cTrim(this.keyData)); strReturn.append("|");
/*  661 */     strReturn.append(StrTool.cTrim(this.keyData2)); strReturn.append("|");
/*  662 */     strReturn.append(StrTool.cTrim(this.keyData3)); strReturn.append("|");
/*  663 */     strReturn.append(StrTool.cTrim(this.keyData4)); strReturn.append("|");
/*  664 */     strReturn.append(StrTool.cTrim(this.uRL)); strReturn.append("|");
/*  665 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  666 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  667 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  668 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  669 */     strReturn.append(StrTool.cTrim(this.startTime)); strReturn.append("|");
/*  670 */     strReturn.append(StrTool.cTrim(this.endTime)); strReturn.append("|");
/*  671 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  672 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  673 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  674 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  675 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  676 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  677 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  678 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  679 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  680 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  681 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  682 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  683 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  684 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/*  685 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  693 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  694 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  695 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  696 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  697 */       this.message = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  698 */       this.messageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  699 */       this.keyData = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  700 */       this.keyData2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  701 */       this.keyData3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  702 */       this.keyData4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  703 */       this.uRL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  704 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  705 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  706 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/*  707 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  708 */       this.startTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  709 */       this.endTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  710 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  711 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  712 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).intValue();
/*  713 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|"))).doubleValue();
/*  714 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  715 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  716 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
/*  717 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  718 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  719 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  720 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*  721 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*  722 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|"));
/*  723 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  728 */       CError tError = new CError();
/*  729 */       tError.moduleName = "MPrivateMessageBSchema";
/*  730 */       tError.functionName = "decode";
/*  731 */       tError.errorMessage = ex.toString();
/*  732 */       this.mErrors.addOneError(tError);
/*      */ 
/*  734 */       return false;
/*      */     }
/*  736 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  742 */     String strReturn = "";
/*  743 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  745 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  747 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  749 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/*  751 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  753 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  755 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  757 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  759 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/*  761 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.message));
/*      */     }
/*  763 */     if (FCode.equalsIgnoreCase("messageType"))
/*      */     {
/*  765 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageType));
/*      */     }
/*  767 */     if (FCode.equalsIgnoreCase("keyData"))
/*      */     {
/*  769 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData));
/*      */     }
/*  771 */     if (FCode.equalsIgnoreCase("keyData2"))
/*      */     {
/*  773 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData2));
/*      */     }
/*  775 */     if (FCode.equalsIgnoreCase("keyData3"))
/*      */     {
/*  777 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData3));
/*      */     }
/*  779 */     if (FCode.equalsIgnoreCase("keyData4"))
/*      */     {
/*  781 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData4));
/*      */     }
/*  783 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  785 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uRL));
/*      */     }
/*  787 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  789 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  791 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  793 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  795 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  797 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  799 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  801 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  803 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/*  805 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startTime));
/*      */     }
/*  807 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/*  809 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endTime));
/*      */     }
/*  811 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  813 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  815 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  817 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  819 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  821 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  823 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  825 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  827 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  829 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  831 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  833 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  835 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  837 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  839 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  841 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  843 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  845 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  847 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  849 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  851 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  853 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  855 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  857 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  859 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  861 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  863 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  865 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  867 */     if (strReturn.equals(""))
/*      */     {
/*  869 */       strReturn = "null";
/*      */     }
/*      */ 
/*  872 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  879 */     String strFieldValue = "";
/*  880 */     switch (nFieldIndex) {
/*      */     case 0:
/*  882 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  883 */       break;
/*      */     case 1:
/*  885 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/*  886 */       break;
/*      */     case 2:
/*  888 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  889 */       break;
/*      */     case 3:
/*  891 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  892 */       break;
/*      */     case 4:
/*  894 */       strFieldValue = StrTool.GBKToUnicode(this.message);
/*  895 */       break;
/*      */     case 5:
/*  897 */       strFieldValue = StrTool.GBKToUnicode(this.messageType);
/*  898 */       break;
/*      */     case 6:
/*  900 */       strFieldValue = StrTool.GBKToUnicode(this.keyData);
/*  901 */       break;
/*      */     case 7:
/*  903 */       strFieldValue = StrTool.GBKToUnicode(this.keyData2);
/*  904 */       break;
/*      */     case 8:
/*  906 */       strFieldValue = StrTool.GBKToUnicode(this.keyData3);
/*  907 */       break;
/*      */     case 9:
/*  909 */       strFieldValue = StrTool.GBKToUnicode(this.keyData4);
/*  910 */       break;
/*      */     case 10:
/*  912 */       strFieldValue = StrTool.GBKToUnicode(this.uRL);
/*  913 */       break;
/*      */     case 11:
/*  915 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  916 */       break;
/*      */     case 12:
/*  918 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  919 */       break;
/*      */     case 13:
/*  921 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  922 */       break;
/*      */     case 14:
/*  924 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*  925 */       break;
/*      */     case 15:
/*  927 */       strFieldValue = StrTool.GBKToUnicode(this.startTime);
/*  928 */       break;
/*      */     case 16:
/*  930 */       strFieldValue = StrTool.GBKToUnicode(this.endTime);
/*  931 */       break;
/*      */     case 17:
/*  933 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  934 */       break;
/*      */     case 18:
/*  936 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  937 */       break;
/*      */     case 19:
/*  939 */       strFieldValue = String.valueOf(this.iF01);
/*  940 */       break;
/*      */     case 20:
/*  942 */       strFieldValue = String.valueOf(this.dF02);
/*  943 */       break;
/*      */     case 21:
/*  945 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  946 */       break;
/*      */     case 22:
/*  948 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  949 */       break;
/*      */     case 23:
/*  951 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  952 */       break;
/*      */     case 24:
/*  954 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  955 */       break;
/*      */     case 25:
/*  957 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  958 */       break;
/*      */     case 26:
/*  960 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  961 */       break;
/*      */     case 27:
/*  963 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  964 */       break;
/*      */     case 28:
/*  966 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  967 */       break;
/*      */     case 29:
/*  969 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  970 */       break;
/*      */     case 30:
/*  972 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  973 */       break;
/*      */     default:
/*  975 */       strFieldValue = "";
/*      */     }
/*  977 */     if (strFieldValue.equals("")) {
/*  978 */       strFieldValue = "null";
/*      */     }
/*  980 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  986 */     if (StrTool.cTrim(FCode).equals("")) {
/*  987 */       return false;
/*      */     }
/*  989 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  991 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  993 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  996 */         this.iD = null;
/*      */     }
/*  998 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 1000 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1002 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/* 1005 */         this.agentCode = null;
/*      */     }
/* 1007 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1009 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1011 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1014 */         this.manageCom = null;
/*      */     }
/* 1016 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/* 1018 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1020 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/* 1023 */         this.branchType = null;
/*      */     }
/* 1025 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/* 1027 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1029 */         this.message = FValue.trim();
/*      */       }
/*      */       else
/* 1032 */         this.message = null;
/*      */     }
/* 1034 */     if (FCode.equalsIgnoreCase("messageType"))
/*      */     {
/* 1036 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1038 */         this.messageType = FValue.trim();
/*      */       }
/*      */       else
/* 1041 */         this.messageType = null;
/*      */     }
/* 1043 */     if (FCode.equalsIgnoreCase("keyData"))
/*      */     {
/* 1045 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1047 */         this.keyData = FValue.trim();
/*      */       }
/*      */       else
/* 1050 */         this.keyData = null;
/*      */     }
/* 1052 */     if (FCode.equalsIgnoreCase("keyData2"))
/*      */     {
/* 1054 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1056 */         this.keyData2 = FValue.trim();
/*      */       }
/*      */       else
/* 1059 */         this.keyData2 = null;
/*      */     }
/* 1061 */     if (FCode.equalsIgnoreCase("keyData3"))
/*      */     {
/* 1063 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1065 */         this.keyData3 = FValue.trim();
/*      */       }
/*      */       else
/* 1068 */         this.keyData3 = null;
/*      */     }
/* 1070 */     if (FCode.equalsIgnoreCase("keyData4"))
/*      */     {
/* 1072 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1074 */         this.keyData4 = FValue.trim();
/*      */       }
/*      */       else
/* 1077 */         this.keyData4 = null;
/*      */     }
/* 1079 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/* 1081 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1083 */         this.uRL = FValue.trim();
/*      */       }
/*      */       else
/* 1086 */         this.uRL = null;
/*      */     }
/* 1088 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/* 1090 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1092 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/* 1095 */         this.type = null;
/*      */     }
/* 1097 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1099 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1101 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 1104 */         this.state = null;
/*      */     }
/* 1106 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/* 1108 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1110 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1113 */         this.startDate = null;
/*      */     }
/* 1115 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 1117 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1119 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1122 */         this.endDate = null;
/*      */     }
/* 1124 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/* 1126 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1128 */         this.startTime = FValue.trim();
/*      */       }
/*      */       else
/* 1131 */         this.startTime = null;
/*      */     }
/* 1133 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/* 1135 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1137 */         this.endTime = FValue.trim();
/*      */       }
/*      */       else
/* 1140 */         this.endTime = null;
/*      */     }
/* 1142 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1144 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1146 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1149 */         this.vF01 = null;
/*      */     }
/* 1151 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1153 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1155 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1158 */         this.nF01 = null;
/*      */     }
/* 1160 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1162 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1164 */         Integer tInteger = new Integer(FValue);
/* 1165 */         int i = tInteger.intValue();
/* 1166 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1169 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1171 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1173 */         Double tDouble = new Double(FValue);
/* 1174 */         double d = tDouble.doubleValue();
/* 1175 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1178 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1180 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1182 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1185 */         this.date01 = null;
/*      */     }
/* 1187 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1189 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1191 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1194 */         this.operator = null;
/*      */     }
/* 1196 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1198 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1200 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1203 */         this.makeDate = null;
/*      */     }
/* 1205 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1207 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1209 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1212 */         this.makeTime = null;
/*      */     }
/* 1214 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/* 1216 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1218 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1221 */         this.edorNo = null;
/*      */     }
/* 1223 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/* 1225 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1227 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1230 */         this.edorType = null;
/*      */     }
/* 1232 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1234 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1236 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1239 */         this.edorCase = null;
/*      */     }
/* 1241 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1243 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1245 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1248 */         this.operator2 = null;
/*      */     }
/* 1250 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1252 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1254 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1257 */         this.makeDate2 = null;
/*      */     }
/* 1259 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1261 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1263 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1266 */         this.makeTime2 = null;
/*      */     }
/* 1268 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1273 */     if (otherObject == null) return false;
/* 1274 */     if (this == otherObject) return true;
/* 1275 */     if (getClass() != otherObject.getClass()) return false;
/* 1276 */     MPrivateMessageBSchema other = (MPrivateMessageBSchema)otherObject;
/* 1277 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 1278 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 1279 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/* 1280 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/* 1281 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1282 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1283 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1284 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1285 */     if ((this.message == null) && (other.getMessage() != null)) return false;
/* 1286 */     if ((this.message != null) && (!this.message.equals(other.getMessage()))) return false;
/* 1287 */     if ((this.messageType == null) && (other.getMessageType() != null)) return false;
/* 1288 */     if ((this.messageType != null) && (!this.messageType.equals(other.getMessageType()))) return false;
/* 1289 */     if ((this.keyData == null) && (other.getKeyData() != null)) return false;
/* 1290 */     if ((this.keyData != null) && (!this.keyData.equals(other.getKeyData()))) return false;
/* 1291 */     if ((this.keyData2 == null) && (other.getKeyData2() != null)) return false;
/* 1292 */     if ((this.keyData2 != null) && (!this.keyData2.equals(other.getKeyData2()))) return false;
/* 1293 */     if ((this.keyData3 == null) && (other.getKeyData3() != null)) return false;
/* 1294 */     if ((this.keyData3 != null) && (!this.keyData3.equals(other.getKeyData3()))) return false;
/* 1295 */     if ((this.keyData4 == null) && (other.getKeyData4() != null)) return false;
/* 1296 */     if ((this.keyData4 != null) && (!this.keyData4.equals(other.getKeyData4()))) return false;
/* 1297 */     if ((this.uRL == null) && (other.getURL() != null)) return false;
/* 1298 */     if ((this.uRL != null) && (!this.uRL.equals(other.getURL()))) return false;
/* 1299 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 1300 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 1301 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1302 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1303 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 1304 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 1305 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 1306 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 1307 */     if ((this.startTime == null) && (other.getStartTime() != null)) return false;
/* 1308 */     if ((this.startTime != null) && (!this.startTime.equals(other.getStartTime()))) return false;
/* 1309 */     if ((this.endTime == null) && (other.getEndTime() != null)) return false;
/* 1310 */     if ((this.endTime != null) && (!this.endTime.equals(other.getEndTime()))) return false;
/* 1311 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1312 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1313 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1314 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1315 */     if (this.iF01 != other.getIF01()) return false;
/* 1316 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1317 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1318 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1319 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1320 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1321 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1322 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1323 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1324 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1325 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1326 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1327 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1328 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1329 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1330 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1331 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1332 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1333 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1334 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1335 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1336 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1343 */     return 31;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1349 */     if (strFieldName.equals("iD")) {
/* 1350 */       return 0;
/*      */     }
/* 1352 */     if (strFieldName.equals("agentCode")) {
/* 1353 */       return 1;
/*      */     }
/* 1355 */     if (strFieldName.equals("manageCom")) {
/* 1356 */       return 2;
/*      */     }
/* 1358 */     if (strFieldName.equals("branchType")) {
/* 1359 */       return 3;
/*      */     }
/* 1361 */     if (strFieldName.equals("message")) {
/* 1362 */       return 4;
/*      */     }
/* 1364 */     if (strFieldName.equals("messageType")) {
/* 1365 */       return 5;
/*      */     }
/* 1367 */     if (strFieldName.equals("keyData")) {
/* 1368 */       return 6;
/*      */     }
/* 1370 */     if (strFieldName.equals("keyData2")) {
/* 1371 */       return 7;
/*      */     }
/* 1373 */     if (strFieldName.equals("keyData3")) {
/* 1374 */       return 8;
/*      */     }
/* 1376 */     if (strFieldName.equals("keyData4")) {
/* 1377 */       return 9;
/*      */     }
/* 1379 */     if (strFieldName.equals("uRL")) {
/* 1380 */       return 10;
/*      */     }
/* 1382 */     if (strFieldName.equals("type")) {
/* 1383 */       return 11;
/*      */     }
/* 1385 */     if (strFieldName.equals("state")) {
/* 1386 */       return 12;
/*      */     }
/* 1388 */     if (strFieldName.equals("startDate")) {
/* 1389 */       return 13;
/*      */     }
/* 1391 */     if (strFieldName.equals("endDate")) {
/* 1392 */       return 14;
/*      */     }
/* 1394 */     if (strFieldName.equals("startTime")) {
/* 1395 */       return 15;
/*      */     }
/* 1397 */     if (strFieldName.equals("endTime")) {
/* 1398 */       return 16;
/*      */     }
/* 1400 */     if (strFieldName.equals("vF01")) {
/* 1401 */       return 17;
/*      */     }
/* 1403 */     if (strFieldName.equals("nF01")) {
/* 1404 */       return 18;
/*      */     }
/* 1406 */     if (strFieldName.equals("iF01")) {
/* 1407 */       return 19;
/*      */     }
/* 1409 */     if (strFieldName.equals("dF02")) {
/* 1410 */       return 20;
/*      */     }
/* 1412 */     if (strFieldName.equals("date01")) {
/* 1413 */       return 21;
/*      */     }
/* 1415 */     if (strFieldName.equals("operator")) {
/* 1416 */       return 22;
/*      */     }
/* 1418 */     if (strFieldName.equals("makeDate")) {
/* 1419 */       return 23;
/*      */     }
/* 1421 */     if (strFieldName.equals("makeTime")) {
/* 1422 */       return 24;
/*      */     }
/* 1424 */     if (strFieldName.equals("edorNo")) {
/* 1425 */       return 25;
/*      */     }
/* 1427 */     if (strFieldName.equals("edorType")) {
/* 1428 */       return 26;
/*      */     }
/* 1430 */     if (strFieldName.equals("edorCase")) {
/* 1431 */       return 27;
/*      */     }
/* 1433 */     if (strFieldName.equals("operator2")) {
/* 1434 */       return 28;
/*      */     }
/* 1436 */     if (strFieldName.equals("makeDate2")) {
/* 1437 */       return 29;
/*      */     }
/* 1439 */     if (strFieldName.equals("makeTime2")) {
/* 1440 */       return 30;
/*      */     }
/* 1442 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1448 */     String strFieldName = "";
/* 1449 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1451 */       strFieldName = "iD";
/* 1452 */       break;
/*      */     case 1:
/* 1454 */       strFieldName = "agentCode";
/* 1455 */       break;
/*      */     case 2:
/* 1457 */       strFieldName = "manageCom";
/* 1458 */       break;
/*      */     case 3:
/* 1460 */       strFieldName = "branchType";
/* 1461 */       break;
/*      */     case 4:
/* 1463 */       strFieldName = "message";
/* 1464 */       break;
/*      */     case 5:
/* 1466 */       strFieldName = "messageType";
/* 1467 */       break;
/*      */     case 6:
/* 1469 */       strFieldName = "keyData";
/* 1470 */       break;
/*      */     case 7:
/* 1472 */       strFieldName = "keyData2";
/* 1473 */       break;
/*      */     case 8:
/* 1475 */       strFieldName = "keyData3";
/* 1476 */       break;
/*      */     case 9:
/* 1478 */       strFieldName = "keyData4";
/* 1479 */       break;
/*      */     case 10:
/* 1481 */       strFieldName = "uRL";
/* 1482 */       break;
/*      */     case 11:
/* 1484 */       strFieldName = "type";
/* 1485 */       break;
/*      */     case 12:
/* 1487 */       strFieldName = "state";
/* 1488 */       break;
/*      */     case 13:
/* 1490 */       strFieldName = "startDate";
/* 1491 */       break;
/*      */     case 14:
/* 1493 */       strFieldName = "endDate";
/* 1494 */       break;
/*      */     case 15:
/* 1496 */       strFieldName = "startTime";
/* 1497 */       break;
/*      */     case 16:
/* 1499 */       strFieldName = "endTime";
/* 1500 */       break;
/*      */     case 17:
/* 1502 */       strFieldName = "vF01";
/* 1503 */       break;
/*      */     case 18:
/* 1505 */       strFieldName = "nF01";
/* 1506 */       break;
/*      */     case 19:
/* 1508 */       strFieldName = "iF01";
/* 1509 */       break;
/*      */     case 20:
/* 1511 */       strFieldName = "dF02";
/* 1512 */       break;
/*      */     case 21:
/* 1514 */       strFieldName = "date01";
/* 1515 */       break;
/*      */     case 22:
/* 1517 */       strFieldName = "operator";
/* 1518 */       break;
/*      */     case 23:
/* 1520 */       strFieldName = "makeDate";
/* 1521 */       break;
/*      */     case 24:
/* 1523 */       strFieldName = "makeTime";
/* 1524 */       break;
/*      */     case 25:
/* 1526 */       strFieldName = "edorNo";
/* 1527 */       break;
/*      */     case 26:
/* 1529 */       strFieldName = "edorType";
/* 1530 */       break;
/*      */     case 27:
/* 1532 */       strFieldName = "edorCase";
/* 1533 */       break;
/*      */     case 28:
/* 1535 */       strFieldName = "operator2";
/* 1536 */       break;
/*      */     case 29:
/* 1538 */       strFieldName = "makeDate2";
/* 1539 */       break;
/*      */     case 30:
/* 1541 */       strFieldName = "makeTime2";
/* 1542 */       break;
/*      */     default:
/* 1544 */       strFieldName = "";
/*      */     }
/* 1546 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1552 */     if (strFieldName.equals("iD")) {
/* 1553 */       return 0;
/*      */     }
/* 1555 */     if (strFieldName.equals("agentCode")) {
/* 1556 */       return 0;
/*      */     }
/* 1558 */     if (strFieldName.equals("manageCom")) {
/* 1559 */       return 0;
/*      */     }
/* 1561 */     if (strFieldName.equals("branchType")) {
/* 1562 */       return 0;
/*      */     }
/* 1564 */     if (strFieldName.equals("message")) {
/* 1565 */       return 0;
/*      */     }
/* 1567 */     if (strFieldName.equals("messageType")) {
/* 1568 */       return 0;
/*      */     }
/* 1570 */     if (strFieldName.equals("keyData")) {
/* 1571 */       return 0;
/*      */     }
/* 1573 */     if (strFieldName.equals("keyData2")) {
/* 1574 */       return 0;
/*      */     }
/* 1576 */     if (strFieldName.equals("keyData3")) {
/* 1577 */       return 0;
/*      */     }
/* 1579 */     if (strFieldName.equals("keyData4")) {
/* 1580 */       return 0;
/*      */     }
/* 1582 */     if (strFieldName.equals("uRL")) {
/* 1583 */       return 0;
/*      */     }
/* 1585 */     if (strFieldName.equals("type")) {
/* 1586 */       return 0;
/*      */     }
/* 1588 */     if (strFieldName.equals("state")) {
/* 1589 */       return 0;
/*      */     }
/* 1591 */     if (strFieldName.equals("startDate")) {
/* 1592 */       return 1;
/*      */     }
/* 1594 */     if (strFieldName.equals("endDate")) {
/* 1595 */       return 1;
/*      */     }
/* 1597 */     if (strFieldName.equals("startTime")) {
/* 1598 */       return 0;
/*      */     }
/* 1600 */     if (strFieldName.equals("endTime")) {
/* 1601 */       return 0;
/*      */     }
/* 1603 */     if (strFieldName.equals("vF01")) {
/* 1604 */       return 0;
/*      */     }
/* 1606 */     if (strFieldName.equals("nF01")) {
/* 1607 */       return 0;
/*      */     }
/* 1609 */     if (strFieldName.equals("iF01")) {
/* 1610 */       return 3;
/*      */     }
/* 1612 */     if (strFieldName.equals("dF02")) {
/* 1613 */       return 4;
/*      */     }
/* 1615 */     if (strFieldName.equals("date01")) {
/* 1616 */       return 1;
/*      */     }
/* 1618 */     if (strFieldName.equals("operator")) {
/* 1619 */       return 0;
/*      */     }
/* 1621 */     if (strFieldName.equals("makeDate")) {
/* 1622 */       return 1;
/*      */     }
/* 1624 */     if (strFieldName.equals("makeTime")) {
/* 1625 */       return 0;
/*      */     }
/* 1627 */     if (strFieldName.equals("edorNo")) {
/* 1628 */       return 0;
/*      */     }
/* 1630 */     if (strFieldName.equals("edorType")) {
/* 1631 */       return 0;
/*      */     }
/* 1633 */     if (strFieldName.equals("edorCase")) {
/* 1634 */       return 0;
/*      */     }
/* 1636 */     if (strFieldName.equals("operator2")) {
/* 1637 */       return 0;
/*      */     }
/* 1639 */     if (strFieldName.equals("makeDate2")) {
/* 1640 */       return 1;
/*      */     }
/* 1642 */     if (strFieldName.equals("makeTime2")) {
/* 1643 */       return 0;
/*      */     }
/* 1645 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1651 */     int nFieldType = -1;
/* 1652 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1654 */       nFieldType = 0;
/* 1655 */       break;
/*      */     case 1:
/* 1657 */       nFieldType = 0;
/* 1658 */       break;
/*      */     case 2:
/* 1660 */       nFieldType = 0;
/* 1661 */       break;
/*      */     case 3:
/* 1663 */       nFieldType = 0;
/* 1664 */       break;
/*      */     case 4:
/* 1666 */       nFieldType = 0;
/* 1667 */       break;
/*      */     case 5:
/* 1669 */       nFieldType = 0;
/* 1670 */       break;
/*      */     case 6:
/* 1672 */       nFieldType = 0;
/* 1673 */       break;
/*      */     case 7:
/* 1675 */       nFieldType = 0;
/* 1676 */       break;
/*      */     case 8:
/* 1678 */       nFieldType = 0;
/* 1679 */       break;
/*      */     case 9:
/* 1681 */       nFieldType = 0;
/* 1682 */       break;
/*      */     case 10:
/* 1684 */       nFieldType = 0;
/* 1685 */       break;
/*      */     case 11:
/* 1687 */       nFieldType = 0;
/* 1688 */       break;
/*      */     case 12:
/* 1690 */       nFieldType = 0;
/* 1691 */       break;
/*      */     case 13:
/* 1693 */       nFieldType = 1;
/* 1694 */       break;
/*      */     case 14:
/* 1696 */       nFieldType = 1;
/* 1697 */       break;
/*      */     case 15:
/* 1699 */       nFieldType = 0;
/* 1700 */       break;
/*      */     case 16:
/* 1702 */       nFieldType = 0;
/* 1703 */       break;
/*      */     case 17:
/* 1705 */       nFieldType = 0;
/* 1706 */       break;
/*      */     case 18:
/* 1708 */       nFieldType = 0;
/* 1709 */       break;
/*      */     case 19:
/* 1711 */       nFieldType = 3;
/* 1712 */       break;
/*      */     case 20:
/* 1714 */       nFieldType = 4;
/* 1715 */       break;
/*      */     case 21:
/* 1717 */       nFieldType = 1;
/* 1718 */       break;
/*      */     case 22:
/* 1720 */       nFieldType = 0;
/* 1721 */       break;
/*      */     case 23:
/* 1723 */       nFieldType = 1;
/* 1724 */       break;
/*      */     case 24:
/* 1726 */       nFieldType = 0;
/* 1727 */       break;
/*      */     case 25:
/* 1729 */       nFieldType = 0;
/* 1730 */       break;
/*      */     case 26:
/* 1732 */       nFieldType = 0;
/* 1733 */       break;
/*      */     case 27:
/* 1735 */       nFieldType = 0;
/* 1736 */       break;
/*      */     case 28:
/* 1738 */       nFieldType = 0;
/* 1739 */       break;
/*      */     case 29:
/* 1741 */       nFieldType = 1;
/* 1742 */       break;
/*      */     case 30:
/* 1744 */       nFieldType = 0;
/* 1745 */       break;
/*      */     default:
/* 1747 */       nFieldType = -1;
/*      */     }
/* 1749 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MPrivateMessageBSchema
 * JD-Core Version:    0.6.0
 */