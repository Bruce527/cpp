/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MC2BMessageBDB;
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
/*      */ public class MC2BMessageBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
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
/*      */   public static final int FIELDNUM = 30;
/*      */   private static String[] PK;
/*   84 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MC2BMessageBSchema()
/*      */   {
/*   91 */     this.mErrors = new CErrors();
/*      */ 
/*   93 */     String[] pk = new String[1];
/*   94 */     pk[0] = "ID";
/*      */ 
/*   96 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  103 */     MC2BMessageBSchema cloned = (MC2BMessageBSchema)super.clone();
/*  104 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  105 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  106 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  112 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  117 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  121 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  125 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  129 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  133 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  137 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/*  141 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String aMessage) {
/*  145 */     this.message = aMessage;
/*      */   }
/*      */ 
/*      */   public String getMessageType() {
/*  149 */     return this.messageType;
/*      */   }
/*      */ 
/*      */   public void setMessageType(String aMessageType) {
/*  153 */     this.messageType = aMessageType;
/*      */   }
/*      */ 
/*      */   public String getKeyData() {
/*  157 */     return this.keyData;
/*      */   }
/*      */ 
/*      */   public void setKeyData(String aKeyData) {
/*  161 */     this.keyData = aKeyData;
/*      */   }
/*      */ 
/*      */   public String getKeyData2() {
/*  165 */     return this.keyData2;
/*      */   }
/*      */ 
/*      */   public void setKeyData2(String aKeyData2) {
/*  169 */     this.keyData2 = aKeyData2;
/*      */   }
/*      */ 
/*      */   public String getKeyData3() {
/*  173 */     return this.keyData3;
/*      */   }
/*      */ 
/*      */   public void setKeyData3(String aKeyData3) {
/*  177 */     this.keyData3 = aKeyData3;
/*      */   }
/*      */ 
/*      */   public String getKeyData4() {
/*  181 */     return this.keyData4;
/*      */   }
/*      */ 
/*      */   public void setKeyData4(String aKeyData4) {
/*  185 */     this.keyData4 = aKeyData4;
/*      */   }
/*      */ 
/*      */   public String getURL() {
/*  189 */     return this.uRL;
/*      */   }
/*      */ 
/*      */   public void setURL(String aURL) {
/*  193 */     this.uRL = aURL;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  197 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  201 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  205 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  209 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  213 */     if (this.startDate != null) {
/*  214 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  216 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  220 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  224 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  226 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  229 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  234 */     if (this.endDate != null) {
/*  235 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  237 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  241 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  245 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  247 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  250 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartTime()
/*      */   {
/*  255 */     return this.startTime;
/*      */   }
/*      */ 
/*      */   public void setStartTime(String aStartTime) {
/*  259 */     this.startTime = aStartTime;
/*      */   }
/*      */ 
/*      */   public String getEndTime() {
/*  263 */     return this.endTime;
/*      */   }
/*      */ 
/*      */   public void setEndTime(String aEndTime) {
/*  267 */     this.endTime = aEndTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  271 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  275 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  279 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  283 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  287 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  291 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  295 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  297 */       Integer tInteger = new Integer(aIF01);
/*  298 */       int i = tInteger.intValue();
/*  299 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  305 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  309 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  313 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  315 */       Double tDouble = new Double(aDF02);
/*  316 */       double d = tDouble.doubleValue();
/*  317 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  323 */     if (this.date01 != null) {
/*  324 */       return this.fDate.getString(this.date01);
/*      */     }
/*  326 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  330 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  334 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  336 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  339 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  344 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  348 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  352 */     if (this.makeDate != null) {
/*  353 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  355 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  359 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  363 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  365 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  368 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  373 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  377 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  381 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  385 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  389 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  393 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  397 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  401 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  405 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  409 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  413 */     if (this.makeDate2 != null) {
/*  414 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  416 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  420 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  424 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  426 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  429 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  434 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  438 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public void setSchema(MC2BMessageBSchema aMC2BMessageBSchema)
/*      */   {
/*  444 */     this.iD = aMC2BMessageBSchema.getID();
/*  445 */     this.manageCom = aMC2BMessageBSchema.getManageCom();
/*  446 */     this.branchType = aMC2BMessageBSchema.getBranchType();
/*  447 */     this.message = aMC2BMessageBSchema.getMessage();
/*  448 */     this.messageType = aMC2BMessageBSchema.getMessageType();
/*  449 */     this.keyData = aMC2BMessageBSchema.getKeyData();
/*  450 */     this.keyData2 = aMC2BMessageBSchema.getKeyData2();
/*  451 */     this.keyData3 = aMC2BMessageBSchema.getKeyData3();
/*  452 */     this.keyData4 = aMC2BMessageBSchema.getKeyData4();
/*  453 */     this.uRL = aMC2BMessageBSchema.getURL();
/*  454 */     this.type = aMC2BMessageBSchema.getType();
/*  455 */     this.state = aMC2BMessageBSchema.getState();
/*  456 */     this.startDate = this.fDate.getDate(aMC2BMessageBSchema.getStartDate());
/*  457 */     this.endDate = this.fDate.getDate(aMC2BMessageBSchema.getEndDate());
/*  458 */     this.startTime = aMC2BMessageBSchema.getStartTime();
/*  459 */     this.endTime = aMC2BMessageBSchema.getEndTime();
/*  460 */     this.vF01 = aMC2BMessageBSchema.getVF01();
/*  461 */     this.nF01 = aMC2BMessageBSchema.getNF01();
/*  462 */     this.iF01 = aMC2BMessageBSchema.getIF01();
/*  463 */     this.dF02 = aMC2BMessageBSchema.getDF02();
/*  464 */     this.date01 = this.fDate.getDate(aMC2BMessageBSchema.getDate01());
/*  465 */     this.operator = aMC2BMessageBSchema.getOperator();
/*  466 */     this.makeDate = this.fDate.getDate(aMC2BMessageBSchema.getMakeDate());
/*  467 */     this.makeTime = aMC2BMessageBSchema.getMakeTime();
/*  468 */     this.edorNo = aMC2BMessageBSchema.getEdorNo();
/*  469 */     this.edorType = aMC2BMessageBSchema.getEdorType();
/*  470 */     this.edorCase = aMC2BMessageBSchema.getEdorCase();
/*  471 */     this.operator2 = aMC2BMessageBSchema.getOperator2();
/*  472 */     this.makeDate2 = this.fDate.getDate(aMC2BMessageBSchema.getMakeDate2());
/*  473 */     this.makeTime2 = aMC2BMessageBSchema.getMakeTime2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  482 */       if (rs.getString("ID") == null)
/*  483 */         this.iD = null;
/*      */       else {
/*  485 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  487 */       if (rs.getString("ManageCom") == null)
/*  488 */         this.manageCom = null;
/*      */       else {
/*  490 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  492 */       if (rs.getString("BranchType") == null)
/*  493 */         this.branchType = null;
/*      */       else {
/*  495 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  497 */       if (rs.getString("Message") == null)
/*  498 */         this.message = null;
/*      */       else {
/*  500 */         this.message = rs.getString("Message").trim();
/*      */       }
/*  502 */       if (rs.getString("MessageType") == null)
/*  503 */         this.messageType = null;
/*      */       else {
/*  505 */         this.messageType = rs.getString("MessageType").trim();
/*      */       }
/*  507 */       if (rs.getString("KeyData") == null)
/*  508 */         this.keyData = null;
/*      */       else {
/*  510 */         this.keyData = rs.getString("KeyData").trim();
/*      */       }
/*  512 */       if (rs.getString("KeyData2") == null)
/*  513 */         this.keyData2 = null;
/*      */       else {
/*  515 */         this.keyData2 = rs.getString("KeyData2").trim();
/*      */       }
/*  517 */       if (rs.getString("KeyData3") == null)
/*  518 */         this.keyData3 = null;
/*      */       else {
/*  520 */         this.keyData3 = rs.getString("KeyData3").trim();
/*      */       }
/*  522 */       if (rs.getString("KeyData4") == null)
/*  523 */         this.keyData4 = null;
/*      */       else {
/*  525 */         this.keyData4 = rs.getString("KeyData4").trim();
/*      */       }
/*  527 */       if (rs.getString("URL") == null)
/*  528 */         this.uRL = null;
/*      */       else {
/*  530 */         this.uRL = rs.getString("URL").trim();
/*      */       }
/*  532 */       if (rs.getString("Type") == null)
/*  533 */         this.type = null;
/*      */       else {
/*  535 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  537 */       if (rs.getString("State") == null)
/*  538 */         this.state = null;
/*      */       else {
/*  540 */         this.state = rs.getString("State").trim();
/*      */       }
/*  542 */       this.startDate = rs.getDate("StartDate");
/*  543 */       this.endDate = rs.getDate("EndDate");
/*  544 */       if (rs.getString("StartTime") == null)
/*  545 */         this.startTime = null;
/*      */       else {
/*  547 */         this.startTime = rs.getString("StartTime").trim();
/*      */       }
/*  549 */       if (rs.getString("EndTime") == null)
/*  550 */         this.endTime = null;
/*      */       else {
/*  552 */         this.endTime = rs.getString("EndTime").trim();
/*      */       }
/*  554 */       if (rs.getString("VF01") == null)
/*  555 */         this.vF01 = null;
/*      */       else {
/*  557 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  559 */       if (rs.getString("NF01") == null)
/*  560 */         this.nF01 = null;
/*      */       else {
/*  562 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  564 */       this.iF01 = rs.getInt("IF01");
/*  565 */       this.dF02 = rs.getDouble("DF02");
/*  566 */       this.date01 = rs.getDate("Date01");
/*  567 */       if (rs.getString("Operator") == null)
/*  568 */         this.operator = null;
/*      */       else {
/*  570 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  572 */       this.makeDate = rs.getDate("MakeDate");
/*  573 */       if (rs.getString("MakeTime") == null)
/*  574 */         this.makeTime = null;
/*      */       else {
/*  576 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  578 */       if (rs.getString("EdorNo") == null)
/*  579 */         this.edorNo = null;
/*      */       else {
/*  581 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  583 */       if (rs.getString("EdorType") == null)
/*  584 */         this.edorType = null;
/*      */       else {
/*  586 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  588 */       if (rs.getString("EdorCase") == null)
/*  589 */         this.edorCase = null;
/*      */       else {
/*  591 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  593 */       if (rs.getString("Operator2") == null)
/*  594 */         this.operator2 = null;
/*      */       else {
/*  596 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  598 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  599 */       if (rs.getString("MakeTime2") == null)
/*  600 */         this.makeTime2 = null;
/*      */       else {
/*  602 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  607 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MC2BMessageB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  609 */       CError tError = new CError();
/*  610 */       tError.moduleName = "MC2BMessageBSchema";
/*  611 */       tError.functionName = "setSchema";
/*  612 */       tError.errorMessage = sqle.toString();
/*  613 */       this.mErrors.addOneError(tError);
/*  614 */       return false;
/*      */     }
/*  616 */     return true;
/*      */   }
/*      */ 
/*      */   public MC2BMessageBSchema getSchema()
/*      */   {
/*  621 */     MC2BMessageBSchema aMC2BMessageBSchema = new MC2BMessageBSchema();
/*  622 */     aMC2BMessageBSchema.setSchema(this);
/*  623 */     return aMC2BMessageBSchema;
/*      */   }
/*      */ 
/*      */   public MC2BMessageBDB getDB()
/*      */   {
/*  628 */     MC2BMessageBDB aDBOper = new MC2BMessageBDB();
/*  629 */     aDBOper.setSchema(this);
/*  630 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  637 */     StringBuffer strReturn = new StringBuffer(256);
/*  638 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  639 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  640 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  641 */     strReturn.append(StrTool.cTrim(this.message)); strReturn.append("|");
/*  642 */     strReturn.append(StrTool.cTrim(this.messageType)); strReturn.append("|");
/*  643 */     strReturn.append(StrTool.cTrim(this.keyData)); strReturn.append("|");
/*  644 */     strReturn.append(StrTool.cTrim(this.keyData2)); strReturn.append("|");
/*  645 */     strReturn.append(StrTool.cTrim(this.keyData3)); strReturn.append("|");
/*  646 */     strReturn.append(StrTool.cTrim(this.keyData4)); strReturn.append("|");
/*  647 */     strReturn.append(StrTool.cTrim(this.uRL)); strReturn.append("|");
/*  648 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  649 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  650 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  651 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  652 */     strReturn.append(StrTool.cTrim(this.startTime)); strReturn.append("|");
/*  653 */     strReturn.append(StrTool.cTrim(this.endTime)); strReturn.append("|");
/*  654 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  655 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  656 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  657 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  658 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  659 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  660 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  661 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  662 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  663 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  664 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  665 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  666 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  667 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/*  668 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  676 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  677 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  678 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  679 */       this.message = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  680 */       this.messageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  681 */       this.keyData = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  682 */       this.keyData2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  683 */       this.keyData3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  684 */       this.keyData4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  685 */       this.uRL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  686 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  687 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  688 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
/*  689 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/*  690 */       this.startTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  691 */       this.endTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  692 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  693 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  694 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 19, "|"))).intValue();
/*  695 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).doubleValue();
/*  696 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
/*  697 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  698 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
/*  699 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  700 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  701 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  702 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  703 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*  704 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|"));
/*  705 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  710 */       CError tError = new CError();
/*  711 */       tError.moduleName = "MC2BMessageBSchema";
/*  712 */       tError.functionName = "decode";
/*  713 */       tError.errorMessage = ex.toString();
/*  714 */       this.mErrors.addOneError(tError);
/*      */ 
/*  716 */       return false;
/*      */     }
/*  718 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  724 */     String strReturn = "";
/*  725 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  727 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  729 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  731 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  733 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  735 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  737 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/*  739 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.message));
/*      */     }
/*  741 */     if (FCode.equalsIgnoreCase("messageType"))
/*      */     {
/*  743 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageType));
/*      */     }
/*  745 */     if (FCode.equalsIgnoreCase("keyData"))
/*      */     {
/*  747 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData));
/*      */     }
/*  749 */     if (FCode.equalsIgnoreCase("keyData2"))
/*      */     {
/*  751 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData2));
/*      */     }
/*  753 */     if (FCode.equalsIgnoreCase("keyData3"))
/*      */     {
/*  755 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData3));
/*      */     }
/*  757 */     if (FCode.equalsIgnoreCase("keyData4"))
/*      */     {
/*  759 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData4));
/*      */     }
/*  761 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  763 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uRL));
/*      */     }
/*  765 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  767 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  769 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  771 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  773 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  775 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  777 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  779 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  781 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/*  783 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startTime));
/*      */     }
/*  785 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/*  787 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endTime));
/*      */     }
/*  789 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  791 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  793 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  795 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  797 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  799 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  801 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  803 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  805 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  807 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  809 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  811 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  813 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  815 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  817 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  819 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  821 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  823 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  825 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  827 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  829 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  831 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  833 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  835 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  837 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  839 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  841 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  843 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  845 */     if (strReturn.equals(""))
/*      */     {
/*  847 */       strReturn = "null";
/*      */     }
/*      */ 
/*  850 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  857 */     String strFieldValue = "";
/*  858 */     switch (nFieldIndex) {
/*      */     case 0:
/*  860 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  861 */       break;
/*      */     case 1:
/*  863 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  864 */       break;
/*      */     case 2:
/*  866 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  867 */       break;
/*      */     case 3:
/*  869 */       strFieldValue = StrTool.GBKToUnicode(this.message);
/*  870 */       break;
/*      */     case 4:
/*  872 */       strFieldValue = StrTool.GBKToUnicode(this.messageType);
/*  873 */       break;
/*      */     case 5:
/*  875 */       strFieldValue = StrTool.GBKToUnicode(this.keyData);
/*  876 */       break;
/*      */     case 6:
/*  878 */       strFieldValue = StrTool.GBKToUnicode(this.keyData2);
/*  879 */       break;
/*      */     case 7:
/*  881 */       strFieldValue = StrTool.GBKToUnicode(this.keyData3);
/*  882 */       break;
/*      */     case 8:
/*  884 */       strFieldValue = StrTool.GBKToUnicode(this.keyData4);
/*  885 */       break;
/*      */     case 9:
/*  887 */       strFieldValue = StrTool.GBKToUnicode(this.uRL);
/*  888 */       break;
/*      */     case 10:
/*  890 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  891 */       break;
/*      */     case 11:
/*  893 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  894 */       break;
/*      */     case 12:
/*  896 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  897 */       break;
/*      */     case 13:
/*  899 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*  900 */       break;
/*      */     case 14:
/*  902 */       strFieldValue = StrTool.GBKToUnicode(this.startTime);
/*  903 */       break;
/*      */     case 15:
/*  905 */       strFieldValue = StrTool.GBKToUnicode(this.endTime);
/*  906 */       break;
/*      */     case 16:
/*  908 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  909 */       break;
/*      */     case 17:
/*  911 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  912 */       break;
/*      */     case 18:
/*  914 */       strFieldValue = String.valueOf(this.iF01);
/*  915 */       break;
/*      */     case 19:
/*  917 */       strFieldValue = String.valueOf(this.dF02);
/*  918 */       break;
/*      */     case 20:
/*  920 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  921 */       break;
/*      */     case 21:
/*  923 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  924 */       break;
/*      */     case 22:
/*  926 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  927 */       break;
/*      */     case 23:
/*  929 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  930 */       break;
/*      */     case 24:
/*  932 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  933 */       break;
/*      */     case 25:
/*  935 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  936 */       break;
/*      */     case 26:
/*  938 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  939 */       break;
/*      */     case 27:
/*  941 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  942 */       break;
/*      */     case 28:
/*  944 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  945 */       break;
/*      */     case 29:
/*  947 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  948 */       break;
/*      */     default:
/*  950 */       strFieldValue = "";
/*      */     }
/*  952 */     if (strFieldValue.equals("")) {
/*  953 */       strFieldValue = "null";
/*      */     }
/*  955 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  961 */     if (StrTool.cTrim(FCode).equals("")) {
/*  962 */       return false;
/*      */     }
/*  964 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  966 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  968 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  971 */         this.iD = null;
/*      */     }
/*  973 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  975 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  977 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  980 */         this.manageCom = null;
/*      */     }
/*  982 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  984 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  986 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  989 */         this.branchType = null;
/*      */     }
/*  991 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/*  993 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  995 */         this.message = FValue.trim();
/*      */       }
/*      */       else
/*  998 */         this.message = null;
/*      */     }
/* 1000 */     if (FCode.equalsIgnoreCase("messageType"))
/*      */     {
/* 1002 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1004 */         this.messageType = FValue.trim();
/*      */       }
/*      */       else
/* 1007 */         this.messageType = null;
/*      */     }
/* 1009 */     if (FCode.equalsIgnoreCase("keyData"))
/*      */     {
/* 1011 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1013 */         this.keyData = FValue.trim();
/*      */       }
/*      */       else
/* 1016 */         this.keyData = null;
/*      */     }
/* 1018 */     if (FCode.equalsIgnoreCase("keyData2"))
/*      */     {
/* 1020 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1022 */         this.keyData2 = FValue.trim();
/*      */       }
/*      */       else
/* 1025 */         this.keyData2 = null;
/*      */     }
/* 1027 */     if (FCode.equalsIgnoreCase("keyData3"))
/*      */     {
/* 1029 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1031 */         this.keyData3 = FValue.trim();
/*      */       }
/*      */       else
/* 1034 */         this.keyData3 = null;
/*      */     }
/* 1036 */     if (FCode.equalsIgnoreCase("keyData4"))
/*      */     {
/* 1038 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1040 */         this.keyData4 = FValue.trim();
/*      */       }
/*      */       else
/* 1043 */         this.keyData4 = null;
/*      */     }
/* 1045 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/* 1047 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1049 */         this.uRL = FValue.trim();
/*      */       }
/*      */       else
/* 1052 */         this.uRL = null;
/*      */     }
/* 1054 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/* 1056 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1058 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/* 1061 */         this.type = null;
/*      */     }
/* 1063 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1065 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1067 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 1070 */         this.state = null;
/*      */     }
/* 1072 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/* 1074 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1076 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1079 */         this.startDate = null;
/*      */     }
/* 1081 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 1083 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1085 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1088 */         this.endDate = null;
/*      */     }
/* 1090 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/* 1092 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1094 */         this.startTime = FValue.trim();
/*      */       }
/*      */       else
/* 1097 */         this.startTime = null;
/*      */     }
/* 1099 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/* 1101 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1103 */         this.endTime = FValue.trim();
/*      */       }
/*      */       else
/* 1106 */         this.endTime = null;
/*      */     }
/* 1108 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1110 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1112 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1115 */         this.vF01 = null;
/*      */     }
/* 1117 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1119 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1121 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1124 */         this.nF01 = null;
/*      */     }
/* 1126 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1128 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1130 */         Integer tInteger = new Integer(FValue);
/* 1131 */         int i = tInteger.intValue();
/* 1132 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1135 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1137 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1139 */         Double tDouble = new Double(FValue);
/* 1140 */         double d = tDouble.doubleValue();
/* 1141 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1144 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1146 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1148 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1151 */         this.date01 = null;
/*      */     }
/* 1153 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1155 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1157 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1160 */         this.operator = null;
/*      */     }
/* 1162 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1164 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1166 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1169 */         this.makeDate = null;
/*      */     }
/* 1171 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1173 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1175 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1178 */         this.makeTime = null;
/*      */     }
/* 1180 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/* 1182 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1184 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1187 */         this.edorNo = null;
/*      */     }
/* 1189 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/* 1191 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1193 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1196 */         this.edorType = null;
/*      */     }
/* 1198 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1200 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1202 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1205 */         this.edorCase = null;
/*      */     }
/* 1207 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1209 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1211 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1214 */         this.operator2 = null;
/*      */     }
/* 1216 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1218 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1220 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1223 */         this.makeDate2 = null;
/*      */     }
/* 1225 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1227 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1229 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1232 */         this.makeTime2 = null;
/*      */     }
/* 1234 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1239 */     if (otherObject == null) return false;
/* 1240 */     if (this == otherObject) return true;
/* 1241 */     if (getClass() != otherObject.getClass()) return false;
/* 1242 */     MC2BMessageBSchema other = (MC2BMessageBSchema)otherObject;
/* 1243 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 1244 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 1245 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1246 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1247 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1248 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1249 */     if ((this.message == null) && (other.getMessage() != null)) return false;
/* 1250 */     if ((this.message != null) && (!this.message.equals(other.getMessage()))) return false;
/* 1251 */     if ((this.messageType == null) && (other.getMessageType() != null)) return false;
/* 1252 */     if ((this.messageType != null) && (!this.messageType.equals(other.getMessageType()))) return false;
/* 1253 */     if ((this.keyData == null) && (other.getKeyData() != null)) return false;
/* 1254 */     if ((this.keyData != null) && (!this.keyData.equals(other.getKeyData()))) return false;
/* 1255 */     if ((this.keyData2 == null) && (other.getKeyData2() != null)) return false;
/* 1256 */     if ((this.keyData2 != null) && (!this.keyData2.equals(other.getKeyData2()))) return false;
/* 1257 */     if ((this.keyData3 == null) && (other.getKeyData3() != null)) return false;
/* 1258 */     if ((this.keyData3 != null) && (!this.keyData3.equals(other.getKeyData3()))) return false;
/* 1259 */     if ((this.keyData4 == null) && (other.getKeyData4() != null)) return false;
/* 1260 */     if ((this.keyData4 != null) && (!this.keyData4.equals(other.getKeyData4()))) return false;
/* 1261 */     if ((this.uRL == null) && (other.getURL() != null)) return false;
/* 1262 */     if ((this.uRL != null) && (!this.uRL.equals(other.getURL()))) return false;
/* 1263 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 1264 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 1265 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1266 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1267 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 1268 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 1269 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 1270 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 1271 */     if ((this.startTime == null) && (other.getStartTime() != null)) return false;
/* 1272 */     if ((this.startTime != null) && (!this.startTime.equals(other.getStartTime()))) return false;
/* 1273 */     if ((this.endTime == null) && (other.getEndTime() != null)) return false;
/* 1274 */     if ((this.endTime != null) && (!this.endTime.equals(other.getEndTime()))) return false;
/* 1275 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1276 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1277 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1278 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1279 */     if (this.iF01 != other.getIF01()) return false;
/* 1280 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1281 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1282 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1283 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1284 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1285 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1286 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1287 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1288 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1289 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1290 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1291 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1292 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1293 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1294 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1295 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1296 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1297 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1298 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1299 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1300 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1307 */     return 30;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1313 */     if (strFieldName.equals("iD")) {
/* 1314 */       return 0;
/*      */     }
/* 1316 */     if (strFieldName.equals("manageCom")) {
/* 1317 */       return 1;
/*      */     }
/* 1319 */     if (strFieldName.equals("branchType")) {
/* 1320 */       return 2;
/*      */     }
/* 1322 */     if (strFieldName.equals("message")) {
/* 1323 */       return 3;
/*      */     }
/* 1325 */     if (strFieldName.equals("messageType")) {
/* 1326 */       return 4;
/*      */     }
/* 1328 */     if (strFieldName.equals("keyData")) {
/* 1329 */       return 5;
/*      */     }
/* 1331 */     if (strFieldName.equals("keyData2")) {
/* 1332 */       return 6;
/*      */     }
/* 1334 */     if (strFieldName.equals("keyData3")) {
/* 1335 */       return 7;
/*      */     }
/* 1337 */     if (strFieldName.equals("keyData4")) {
/* 1338 */       return 8;
/*      */     }
/* 1340 */     if (strFieldName.equals("uRL")) {
/* 1341 */       return 9;
/*      */     }
/* 1343 */     if (strFieldName.equals("type")) {
/* 1344 */       return 10;
/*      */     }
/* 1346 */     if (strFieldName.equals("state")) {
/* 1347 */       return 11;
/*      */     }
/* 1349 */     if (strFieldName.equals("startDate")) {
/* 1350 */       return 12;
/*      */     }
/* 1352 */     if (strFieldName.equals("endDate")) {
/* 1353 */       return 13;
/*      */     }
/* 1355 */     if (strFieldName.equals("startTime")) {
/* 1356 */       return 14;
/*      */     }
/* 1358 */     if (strFieldName.equals("endTime")) {
/* 1359 */       return 15;
/*      */     }
/* 1361 */     if (strFieldName.equals("vF01")) {
/* 1362 */       return 16;
/*      */     }
/* 1364 */     if (strFieldName.equals("nF01")) {
/* 1365 */       return 17;
/*      */     }
/* 1367 */     if (strFieldName.equals("iF01")) {
/* 1368 */       return 18;
/*      */     }
/* 1370 */     if (strFieldName.equals("dF02")) {
/* 1371 */       return 19;
/*      */     }
/* 1373 */     if (strFieldName.equals("date01")) {
/* 1374 */       return 20;
/*      */     }
/* 1376 */     if (strFieldName.equals("operator")) {
/* 1377 */       return 21;
/*      */     }
/* 1379 */     if (strFieldName.equals("makeDate")) {
/* 1380 */       return 22;
/*      */     }
/* 1382 */     if (strFieldName.equals("makeTime")) {
/* 1383 */       return 23;
/*      */     }
/* 1385 */     if (strFieldName.equals("edorNo")) {
/* 1386 */       return 24;
/*      */     }
/* 1388 */     if (strFieldName.equals("edorType")) {
/* 1389 */       return 25;
/*      */     }
/* 1391 */     if (strFieldName.equals("edorCase")) {
/* 1392 */       return 26;
/*      */     }
/* 1394 */     if (strFieldName.equals("operator2")) {
/* 1395 */       return 27;
/*      */     }
/* 1397 */     if (strFieldName.equals("makeDate2")) {
/* 1398 */       return 28;
/*      */     }
/* 1400 */     if (strFieldName.equals("makeTime2")) {
/* 1401 */       return 29;
/*      */     }
/* 1403 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1409 */     String strFieldName = "";
/* 1410 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1412 */       strFieldName = "iD";
/* 1413 */       break;
/*      */     case 1:
/* 1415 */       strFieldName = "manageCom";
/* 1416 */       break;
/*      */     case 2:
/* 1418 */       strFieldName = "branchType";
/* 1419 */       break;
/*      */     case 3:
/* 1421 */       strFieldName = "message";
/* 1422 */       break;
/*      */     case 4:
/* 1424 */       strFieldName = "messageType";
/* 1425 */       break;
/*      */     case 5:
/* 1427 */       strFieldName = "keyData";
/* 1428 */       break;
/*      */     case 6:
/* 1430 */       strFieldName = "keyData2";
/* 1431 */       break;
/*      */     case 7:
/* 1433 */       strFieldName = "keyData3";
/* 1434 */       break;
/*      */     case 8:
/* 1436 */       strFieldName = "keyData4";
/* 1437 */       break;
/*      */     case 9:
/* 1439 */       strFieldName = "uRL";
/* 1440 */       break;
/*      */     case 10:
/* 1442 */       strFieldName = "type";
/* 1443 */       break;
/*      */     case 11:
/* 1445 */       strFieldName = "state";
/* 1446 */       break;
/*      */     case 12:
/* 1448 */       strFieldName = "startDate";
/* 1449 */       break;
/*      */     case 13:
/* 1451 */       strFieldName = "endDate";
/* 1452 */       break;
/*      */     case 14:
/* 1454 */       strFieldName = "startTime";
/* 1455 */       break;
/*      */     case 15:
/* 1457 */       strFieldName = "endTime";
/* 1458 */       break;
/*      */     case 16:
/* 1460 */       strFieldName = "vF01";
/* 1461 */       break;
/*      */     case 17:
/* 1463 */       strFieldName = "nF01";
/* 1464 */       break;
/*      */     case 18:
/* 1466 */       strFieldName = "iF01";
/* 1467 */       break;
/*      */     case 19:
/* 1469 */       strFieldName = "dF02";
/* 1470 */       break;
/*      */     case 20:
/* 1472 */       strFieldName = "date01";
/* 1473 */       break;
/*      */     case 21:
/* 1475 */       strFieldName = "operator";
/* 1476 */       break;
/*      */     case 22:
/* 1478 */       strFieldName = "makeDate";
/* 1479 */       break;
/*      */     case 23:
/* 1481 */       strFieldName = "makeTime";
/* 1482 */       break;
/*      */     case 24:
/* 1484 */       strFieldName = "edorNo";
/* 1485 */       break;
/*      */     case 25:
/* 1487 */       strFieldName = "edorType";
/* 1488 */       break;
/*      */     case 26:
/* 1490 */       strFieldName = "edorCase";
/* 1491 */       break;
/*      */     case 27:
/* 1493 */       strFieldName = "operator2";
/* 1494 */       break;
/*      */     case 28:
/* 1496 */       strFieldName = "makeDate2";
/* 1497 */       break;
/*      */     case 29:
/* 1499 */       strFieldName = "makeTime2";
/* 1500 */       break;
/*      */     default:
/* 1502 */       strFieldName = "";
/*      */     }
/* 1504 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1510 */     if (strFieldName.equals("iD")) {
/* 1511 */       return 0;
/*      */     }
/* 1513 */     if (strFieldName.equals("manageCom")) {
/* 1514 */       return 0;
/*      */     }
/* 1516 */     if (strFieldName.equals("branchType")) {
/* 1517 */       return 0;
/*      */     }
/* 1519 */     if (strFieldName.equals("message")) {
/* 1520 */       return 0;
/*      */     }
/* 1522 */     if (strFieldName.equals("messageType")) {
/* 1523 */       return 0;
/*      */     }
/* 1525 */     if (strFieldName.equals("keyData")) {
/* 1526 */       return 0;
/*      */     }
/* 1528 */     if (strFieldName.equals("keyData2")) {
/* 1529 */       return 0;
/*      */     }
/* 1531 */     if (strFieldName.equals("keyData3")) {
/* 1532 */       return 0;
/*      */     }
/* 1534 */     if (strFieldName.equals("keyData4")) {
/* 1535 */       return 0;
/*      */     }
/* 1537 */     if (strFieldName.equals("uRL")) {
/* 1538 */       return 0;
/*      */     }
/* 1540 */     if (strFieldName.equals("type")) {
/* 1541 */       return 0;
/*      */     }
/* 1543 */     if (strFieldName.equals("state")) {
/* 1544 */       return 0;
/*      */     }
/* 1546 */     if (strFieldName.equals("startDate")) {
/* 1547 */       return 1;
/*      */     }
/* 1549 */     if (strFieldName.equals("endDate")) {
/* 1550 */       return 1;
/*      */     }
/* 1552 */     if (strFieldName.equals("startTime")) {
/* 1553 */       return 0;
/*      */     }
/* 1555 */     if (strFieldName.equals("endTime")) {
/* 1556 */       return 0;
/*      */     }
/* 1558 */     if (strFieldName.equals("vF01")) {
/* 1559 */       return 0;
/*      */     }
/* 1561 */     if (strFieldName.equals("nF01")) {
/* 1562 */       return 0;
/*      */     }
/* 1564 */     if (strFieldName.equals("iF01")) {
/* 1565 */       return 3;
/*      */     }
/* 1567 */     if (strFieldName.equals("dF02")) {
/* 1568 */       return 4;
/*      */     }
/* 1570 */     if (strFieldName.equals("date01")) {
/* 1571 */       return 1;
/*      */     }
/* 1573 */     if (strFieldName.equals("operator")) {
/* 1574 */       return 0;
/*      */     }
/* 1576 */     if (strFieldName.equals("makeDate")) {
/* 1577 */       return 1;
/*      */     }
/* 1579 */     if (strFieldName.equals("makeTime")) {
/* 1580 */       return 0;
/*      */     }
/* 1582 */     if (strFieldName.equals("edorNo")) {
/* 1583 */       return 0;
/*      */     }
/* 1585 */     if (strFieldName.equals("edorType")) {
/* 1586 */       return 0;
/*      */     }
/* 1588 */     if (strFieldName.equals("edorCase")) {
/* 1589 */       return 0;
/*      */     }
/* 1591 */     if (strFieldName.equals("operator2")) {
/* 1592 */       return 0;
/*      */     }
/* 1594 */     if (strFieldName.equals("makeDate2")) {
/* 1595 */       return 1;
/*      */     }
/* 1597 */     if (strFieldName.equals("makeTime2")) {
/* 1598 */       return 0;
/*      */     }
/* 1600 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1606 */     int nFieldType = -1;
/* 1607 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1609 */       nFieldType = 0;
/* 1610 */       break;
/*      */     case 1:
/* 1612 */       nFieldType = 0;
/* 1613 */       break;
/*      */     case 2:
/* 1615 */       nFieldType = 0;
/* 1616 */       break;
/*      */     case 3:
/* 1618 */       nFieldType = 0;
/* 1619 */       break;
/*      */     case 4:
/* 1621 */       nFieldType = 0;
/* 1622 */       break;
/*      */     case 5:
/* 1624 */       nFieldType = 0;
/* 1625 */       break;
/*      */     case 6:
/* 1627 */       nFieldType = 0;
/* 1628 */       break;
/*      */     case 7:
/* 1630 */       nFieldType = 0;
/* 1631 */       break;
/*      */     case 8:
/* 1633 */       nFieldType = 0;
/* 1634 */       break;
/*      */     case 9:
/* 1636 */       nFieldType = 0;
/* 1637 */       break;
/*      */     case 10:
/* 1639 */       nFieldType = 0;
/* 1640 */       break;
/*      */     case 11:
/* 1642 */       nFieldType = 0;
/* 1643 */       break;
/*      */     case 12:
/* 1645 */       nFieldType = 1;
/* 1646 */       break;
/*      */     case 13:
/* 1648 */       nFieldType = 1;
/* 1649 */       break;
/*      */     case 14:
/* 1651 */       nFieldType = 0;
/* 1652 */       break;
/*      */     case 15:
/* 1654 */       nFieldType = 0;
/* 1655 */       break;
/*      */     case 16:
/* 1657 */       nFieldType = 0;
/* 1658 */       break;
/*      */     case 17:
/* 1660 */       nFieldType = 0;
/* 1661 */       break;
/*      */     case 18:
/* 1663 */       nFieldType = 3;
/* 1664 */       break;
/*      */     case 19:
/* 1666 */       nFieldType = 4;
/* 1667 */       break;
/*      */     case 20:
/* 1669 */       nFieldType = 1;
/* 1670 */       break;
/*      */     case 21:
/* 1672 */       nFieldType = 0;
/* 1673 */       break;
/*      */     case 22:
/* 1675 */       nFieldType = 1;
/* 1676 */       break;
/*      */     case 23:
/* 1678 */       nFieldType = 0;
/* 1679 */       break;
/*      */     case 24:
/* 1681 */       nFieldType = 0;
/* 1682 */       break;
/*      */     case 25:
/* 1684 */       nFieldType = 0;
/* 1685 */       break;
/*      */     case 26:
/* 1687 */       nFieldType = 0;
/* 1688 */       break;
/*      */     case 27:
/* 1690 */       nFieldType = 0;
/* 1691 */       break;
/*      */     case 28:
/* 1693 */       nFieldType = 1;
/* 1694 */       break;
/*      */     case 29:
/* 1696 */       nFieldType = 0;
/* 1697 */       break;
/*      */     default:
/* 1699 */       nFieldType = -1;
/*      */     }
/* 1701 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MC2BMessageBSchema
 * JD-Core Version:    0.6.0
 */