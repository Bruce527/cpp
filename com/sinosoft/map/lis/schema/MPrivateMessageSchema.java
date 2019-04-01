/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MPrivateMessageDB;
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
/*      */ public class MPrivateMessageSchema
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
/*      */   public static final int FIELDNUM = 25;
/*      */   private static String[] PK;
/*   74 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MPrivateMessageSchema()
/*      */   {
/*   81 */     this.mErrors = new CErrors();
/*      */ 
/*   83 */     String[] pk = new String[1];
/*   84 */     pk[0] = "ID";
/*      */ 
/*   86 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   93 */     MPrivateMessageSchema cloned = (MPrivateMessageSchema)super.clone();
/*   94 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   95 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   96 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  102 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  107 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  111 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  115 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  119 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  123 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  127 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  131 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  135 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/*  139 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String aMessage) {
/*  143 */     this.message = aMessage;
/*      */   }
/*      */ 
/*      */   public String getMessageType() {
/*  147 */     return this.messageType;
/*      */   }
/*      */ 
/*      */   public void setMessageType(String aMessageType) {
/*  151 */     this.messageType = aMessageType;
/*      */   }
/*      */ 
/*      */   public String getKeyData() {
/*  155 */     return this.keyData;
/*      */   }
/*      */ 
/*      */   public void setKeyData(String aKeyData) {
/*  159 */     this.keyData = aKeyData;
/*      */   }
/*      */ 
/*      */   public String getKeyData2() {
/*  163 */     return this.keyData2;
/*      */   }
/*      */ 
/*      */   public void setKeyData2(String aKeyData2) {
/*  167 */     this.keyData2 = aKeyData2;
/*      */   }
/*      */ 
/*      */   public String getKeyData3() {
/*  171 */     return this.keyData3;
/*      */   }
/*      */ 
/*      */   public void setKeyData3(String aKeyData3) {
/*  175 */     this.keyData3 = aKeyData3;
/*      */   }
/*      */ 
/*      */   public String getKeyData4() {
/*  179 */     return this.keyData4;
/*      */   }
/*      */ 
/*      */   public void setKeyData4(String aKeyData4) {
/*  183 */     this.keyData4 = aKeyData4;
/*      */   }
/*      */ 
/*      */   public String getURL() {
/*  187 */     return this.uRL;
/*      */   }
/*      */ 
/*      */   public void setURL(String aURL) {
/*  191 */     this.uRL = aURL;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  195 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  199 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  203 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  207 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  211 */     if (this.startDate != null) {
/*  212 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  214 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  218 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  222 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  224 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  227 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  232 */     if (this.endDate != null) {
/*  233 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  235 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  239 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  243 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  245 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  248 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartTime()
/*      */   {
/*  253 */     return this.startTime;
/*      */   }
/*      */ 
/*      */   public void setStartTime(String aStartTime) {
/*  257 */     this.startTime = aStartTime;
/*      */   }
/*      */ 
/*      */   public String getEndTime() {
/*  261 */     return this.endTime;
/*      */   }
/*      */ 
/*      */   public void setEndTime(String aEndTime) {
/*  265 */     this.endTime = aEndTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  269 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  273 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  277 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  281 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  285 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  289 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  293 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  295 */       Integer tInteger = new Integer(aIF01);
/*  296 */       int i = tInteger.intValue();
/*  297 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  303 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  307 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  311 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  313 */       Double tDouble = new Double(aDF02);
/*  314 */       double d = tDouble.doubleValue();
/*  315 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  321 */     if (this.date01 != null) {
/*  322 */       return this.fDate.getString(this.date01);
/*      */     }
/*  324 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  328 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  332 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  334 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  337 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  342 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  346 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  350 */     if (this.makeDate != null) {
/*  351 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  353 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  357 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  361 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  363 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  366 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  371 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  375 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MPrivateMessageSchema aMPrivateMessageSchema)
/*      */   {
/*  381 */     this.iD = aMPrivateMessageSchema.getID();
/*  382 */     this.agentCode = aMPrivateMessageSchema.getAgentCode();
/*  383 */     this.manageCom = aMPrivateMessageSchema.getManageCom();
/*  384 */     this.branchType = aMPrivateMessageSchema.getBranchType();
/*  385 */     this.message = aMPrivateMessageSchema.getMessage();
/*  386 */     this.messageType = aMPrivateMessageSchema.getMessageType();
/*  387 */     this.keyData = aMPrivateMessageSchema.getKeyData();
/*  388 */     this.keyData2 = aMPrivateMessageSchema.getKeyData2();
/*  389 */     this.keyData3 = aMPrivateMessageSchema.getKeyData3();
/*  390 */     this.keyData4 = aMPrivateMessageSchema.getKeyData4();
/*  391 */     this.uRL = aMPrivateMessageSchema.getURL();
/*  392 */     this.type = aMPrivateMessageSchema.getType();
/*  393 */     this.state = aMPrivateMessageSchema.getState();
/*  394 */     this.startDate = this.fDate.getDate(aMPrivateMessageSchema.getStartDate());
/*  395 */     this.endDate = this.fDate.getDate(aMPrivateMessageSchema.getEndDate());
/*  396 */     this.startTime = aMPrivateMessageSchema.getStartTime();
/*  397 */     this.endTime = aMPrivateMessageSchema.getEndTime();
/*  398 */     this.vF01 = aMPrivateMessageSchema.getVF01();
/*  399 */     this.nF01 = aMPrivateMessageSchema.getNF01();
/*  400 */     this.iF01 = aMPrivateMessageSchema.getIF01();
/*  401 */     this.dF02 = aMPrivateMessageSchema.getDF02();
/*  402 */     this.date01 = this.fDate.getDate(aMPrivateMessageSchema.getDate01());
/*  403 */     this.operator = aMPrivateMessageSchema.getOperator();
/*  404 */     this.makeDate = this.fDate.getDate(aMPrivateMessageSchema.getMakeDate());
/*  405 */     this.makeTime = aMPrivateMessageSchema.getMakeTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  414 */       if (rs.getString("ID") == null)
/*  415 */         this.iD = null;
/*      */       else {
/*  417 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  419 */       if (rs.getString("AgentCode") == null)
/*  420 */         this.agentCode = null;
/*      */       else {
/*  422 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/*  424 */       if (rs.getString("ManageCom") == null)
/*  425 */         this.manageCom = null;
/*      */       else {
/*  427 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  429 */       if (rs.getString("BranchType") == null)
/*  430 */         this.branchType = null;
/*      */       else {
/*  432 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  434 */       if (rs.getString("Message") == null)
/*  435 */         this.message = null;
/*      */       else {
/*  437 */         this.message = rs.getString("Message").trim();
/*      */       }
/*  439 */       if (rs.getString("MessageType") == null)
/*  440 */         this.messageType = null;
/*      */       else {
/*  442 */         this.messageType = rs.getString("MessageType").trim();
/*      */       }
/*  444 */       if (rs.getString("KeyData") == null)
/*  445 */         this.keyData = null;
/*      */       else {
/*  447 */         this.keyData = rs.getString("KeyData").trim();
/*      */       }
/*  449 */       if (rs.getString("KeyData2") == null)
/*  450 */         this.keyData2 = null;
/*      */       else {
/*  452 */         this.keyData2 = rs.getString("KeyData2").trim();
/*      */       }
/*  454 */       if (rs.getString("KeyData3") == null)
/*  455 */         this.keyData3 = null;
/*      */       else {
/*  457 */         this.keyData3 = rs.getString("KeyData3").trim();
/*      */       }
/*  459 */       if (rs.getString("KeyData4") == null)
/*  460 */         this.keyData4 = null;
/*      */       else {
/*  462 */         this.keyData4 = rs.getString("KeyData4").trim();
/*      */       }
/*  464 */       if (rs.getString("URL") == null)
/*  465 */         this.uRL = null;
/*      */       else {
/*  467 */         this.uRL = rs.getString("URL").trim();
/*      */       }
/*  469 */       if (rs.getString("Type") == null)
/*  470 */         this.type = null;
/*      */       else {
/*  472 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  474 */       if (rs.getString("State") == null)
/*  475 */         this.state = null;
/*      */       else {
/*  477 */         this.state = rs.getString("State").trim();
/*      */       }
/*  479 */       this.startDate = rs.getDate("StartDate");
/*  480 */       this.endDate = rs.getDate("EndDate");
/*  481 */       if (rs.getString("StartTime") == null)
/*  482 */         this.startTime = null;
/*      */       else {
/*  484 */         this.startTime = rs.getString("StartTime").trim();
/*      */       }
/*  486 */       if (rs.getString("EndTime") == null)
/*  487 */         this.endTime = null;
/*      */       else {
/*  489 */         this.endTime = rs.getString("EndTime").trim();
/*      */       }
/*  491 */       if (rs.getString("VF01") == null)
/*  492 */         this.vF01 = null;
/*      */       else {
/*  494 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  496 */       if (rs.getString("NF01") == null)
/*  497 */         this.nF01 = null;
/*      */       else {
/*  499 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  501 */       this.iF01 = rs.getInt("IF01");
/*  502 */       this.dF02 = rs.getDouble("DF02");
/*  503 */       this.date01 = rs.getDate("Date01");
/*  504 */       if (rs.getString("Operator") == null)
/*  505 */         this.operator = null;
/*      */       else {
/*  507 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  509 */       this.makeDate = rs.getDate("MakeDate");
/*  510 */       if (rs.getString("MakeTime") == null)
/*  511 */         this.makeTime = null;
/*      */       else {
/*  513 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  518 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MPrivateMessage\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  520 */       CError tError = new CError();
/*  521 */       tError.moduleName = "MPrivateMessageSchema";
/*  522 */       tError.functionName = "setSchema";
/*  523 */       tError.errorMessage = sqle.toString();
/*  524 */       this.mErrors.addOneError(tError);
/*  525 */       return false;
/*      */     }
/*  527 */     return true;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageSchema getSchema()
/*      */   {
/*  532 */     MPrivateMessageSchema aMPrivateMessageSchema = new MPrivateMessageSchema();
/*  533 */     aMPrivateMessageSchema.setSchema(this);
/*  534 */     return aMPrivateMessageSchema;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageDB getDB()
/*      */   {
/*  539 */     MPrivateMessageDB aDBOper = new MPrivateMessageDB();
/*  540 */     aDBOper.setSchema(this);
/*  541 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  548 */     StringBuffer strReturn = new StringBuffer(256);
/*  549 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  550 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/*  551 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  552 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  553 */     strReturn.append(StrTool.cTrim(this.message)); strReturn.append("|");
/*  554 */     strReturn.append(StrTool.cTrim(this.messageType)); strReturn.append("|");
/*  555 */     strReturn.append(StrTool.cTrim(this.keyData)); strReturn.append("|");
/*  556 */     strReturn.append(StrTool.cTrim(this.keyData2)); strReturn.append("|");
/*  557 */     strReturn.append(StrTool.cTrim(this.keyData3)); strReturn.append("|");
/*  558 */     strReturn.append(StrTool.cTrim(this.keyData4)); strReturn.append("|");
/*  559 */     strReturn.append(StrTool.cTrim(this.uRL)); strReturn.append("|");
/*  560 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  561 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  562 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  563 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  564 */     strReturn.append(StrTool.cTrim(this.startTime)); strReturn.append("|");
/*  565 */     strReturn.append(StrTool.cTrim(this.endTime)); strReturn.append("|");
/*  566 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  567 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  568 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  569 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  570 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  571 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  572 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  573 */     strReturn.append(StrTool.cTrim(this.makeTime));
/*  574 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  582 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  583 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  584 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  585 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  586 */       this.message = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  587 */       this.messageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  588 */       this.keyData = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  589 */       this.keyData2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  590 */       this.keyData3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  591 */       this.keyData4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  592 */       this.uRL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  593 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  594 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  595 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/*  596 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  597 */       this.startTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  598 */       this.endTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  599 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  600 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  601 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).intValue();
/*  602 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|"))).doubleValue();
/*  603 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  604 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  605 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
/*  606 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  611 */       CError tError = new CError();
/*  612 */       tError.moduleName = "MPrivateMessageSchema";
/*  613 */       tError.functionName = "decode";
/*  614 */       tError.errorMessage = ex.toString();
/*  615 */       this.mErrors.addOneError(tError);
/*      */ 
/*  617 */       return false;
/*      */     }
/*  619 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  625 */     String strReturn = "";
/*  626 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  628 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  630 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  632 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/*  634 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  636 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  638 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  640 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  642 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/*  644 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.message));
/*      */     }
/*  646 */     if (FCode.equalsIgnoreCase("messageType"))
/*      */     {
/*  648 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageType));
/*      */     }
/*  650 */     if (FCode.equalsIgnoreCase("keyData"))
/*      */     {
/*  652 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData));
/*      */     }
/*  654 */     if (FCode.equalsIgnoreCase("keyData2"))
/*      */     {
/*  656 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData2));
/*      */     }
/*  658 */     if (FCode.equalsIgnoreCase("keyData3"))
/*      */     {
/*  660 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData3));
/*      */     }
/*  662 */     if (FCode.equalsIgnoreCase("keyData4"))
/*      */     {
/*  664 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData4));
/*      */     }
/*  666 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  668 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uRL));
/*      */     }
/*  670 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  672 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  676 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  678 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  680 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  682 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  684 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  686 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/*  688 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startTime));
/*      */     }
/*  690 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/*  692 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endTime));
/*      */     }
/*  694 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  696 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  698 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  700 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  704 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  706 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  708 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  712 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  714 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  716 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  718 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  720 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  722 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  724 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  726 */     if (strReturn.equals(""))
/*      */     {
/*  728 */       strReturn = "null";
/*      */     }
/*      */ 
/*  731 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  738 */     String strFieldValue = "";
/*  739 */     switch (nFieldIndex) {
/*      */     case 0:
/*  741 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  742 */       break;
/*      */     case 1:
/*  744 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/*  745 */       break;
/*      */     case 2:
/*  747 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  748 */       break;
/*      */     case 3:
/*  750 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  751 */       break;
/*      */     case 4:
/*  753 */       strFieldValue = StrTool.GBKToUnicode(this.message);
/*  754 */       break;
/*      */     case 5:
/*  756 */       strFieldValue = StrTool.GBKToUnicode(this.messageType);
/*  757 */       break;
/*      */     case 6:
/*  759 */       strFieldValue = StrTool.GBKToUnicode(this.keyData);
/*  760 */       break;
/*      */     case 7:
/*  762 */       strFieldValue = StrTool.GBKToUnicode(this.keyData2);
/*  763 */       break;
/*      */     case 8:
/*  765 */       strFieldValue = StrTool.GBKToUnicode(this.keyData3);
/*  766 */       break;
/*      */     case 9:
/*  768 */       strFieldValue = StrTool.GBKToUnicode(this.keyData4);
/*  769 */       break;
/*      */     case 10:
/*  771 */       strFieldValue = StrTool.GBKToUnicode(this.uRL);
/*  772 */       break;
/*      */     case 11:
/*  774 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  775 */       break;
/*      */     case 12:
/*  777 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  778 */       break;
/*      */     case 13:
/*  780 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  781 */       break;
/*      */     case 14:
/*  783 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*  784 */       break;
/*      */     case 15:
/*  786 */       strFieldValue = StrTool.GBKToUnicode(this.startTime);
/*  787 */       break;
/*      */     case 16:
/*  789 */       strFieldValue = StrTool.GBKToUnicode(this.endTime);
/*  790 */       break;
/*      */     case 17:
/*  792 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  793 */       break;
/*      */     case 18:
/*  795 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  796 */       break;
/*      */     case 19:
/*  798 */       strFieldValue = String.valueOf(this.iF01);
/*  799 */       break;
/*      */     case 20:
/*  801 */       strFieldValue = String.valueOf(this.dF02);
/*  802 */       break;
/*      */     case 21:
/*  804 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  805 */       break;
/*      */     case 22:
/*  807 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  808 */       break;
/*      */     case 23:
/*  810 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  811 */       break;
/*      */     case 24:
/*  813 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  814 */       break;
/*      */     default:
/*  816 */       strFieldValue = "";
/*      */     }
/*  818 */     if (strFieldValue.equals("")) {
/*  819 */       strFieldValue = "null";
/*      */     }
/*  821 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  827 */     if (StrTool.cTrim(FCode).equals("")) {
/*  828 */       return false;
/*      */     }
/*  830 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  832 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  834 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  837 */         this.iD = null;
/*      */     }
/*  839 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  841 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  843 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/*  846 */         this.agentCode = null;
/*      */     }
/*  848 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  850 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  852 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  855 */         this.manageCom = null;
/*      */     }
/*  857 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  859 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  861 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  864 */         this.branchType = null;
/*      */     }
/*  866 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/*  868 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  870 */         this.message = FValue.trim();
/*      */       }
/*      */       else
/*  873 */         this.message = null;
/*      */     }
/*  875 */     if (FCode.equalsIgnoreCase("messageType"))
/*      */     {
/*  877 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  879 */         this.messageType = FValue.trim();
/*      */       }
/*      */       else
/*  882 */         this.messageType = null;
/*      */     }
/*  884 */     if (FCode.equalsIgnoreCase("keyData"))
/*      */     {
/*  886 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  888 */         this.keyData = FValue.trim();
/*      */       }
/*      */       else
/*  891 */         this.keyData = null;
/*      */     }
/*  893 */     if (FCode.equalsIgnoreCase("keyData2"))
/*      */     {
/*  895 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  897 */         this.keyData2 = FValue.trim();
/*      */       }
/*      */       else
/*  900 */         this.keyData2 = null;
/*      */     }
/*  902 */     if (FCode.equalsIgnoreCase("keyData3"))
/*      */     {
/*  904 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  906 */         this.keyData3 = FValue.trim();
/*      */       }
/*      */       else
/*  909 */         this.keyData3 = null;
/*      */     }
/*  911 */     if (FCode.equalsIgnoreCase("keyData4"))
/*      */     {
/*  913 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  915 */         this.keyData4 = FValue.trim();
/*      */       }
/*      */       else
/*  918 */         this.keyData4 = null;
/*      */     }
/*  920 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  922 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  924 */         this.uRL = FValue.trim();
/*      */       }
/*      */       else
/*  927 */         this.uRL = null;
/*      */     }
/*  929 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  931 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  933 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/*  936 */         this.type = null;
/*      */     }
/*  938 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  940 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  942 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  945 */         this.state = null;
/*      */     }
/*  947 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  949 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  951 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  954 */         this.startDate = null;
/*      */     }
/*  956 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  958 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  960 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  963 */         this.endDate = null;
/*      */     }
/*  965 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/*  967 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  969 */         this.startTime = FValue.trim();
/*      */       }
/*      */       else
/*  972 */         this.startTime = null;
/*      */     }
/*  974 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/*  976 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  978 */         this.endTime = FValue.trim();
/*      */       }
/*      */       else
/*  981 */         this.endTime = null;
/*      */     }
/*  983 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  985 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  987 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/*  990 */         this.vF01 = null;
/*      */     }
/*  992 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  994 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  996 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/*  999 */         this.nF01 = null;
/*      */     }
/* 1001 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1003 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1005 */         Integer tInteger = new Integer(FValue);
/* 1006 */         int i = tInteger.intValue();
/* 1007 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1010 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1012 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1014 */         Double tDouble = new Double(FValue);
/* 1015 */         double d = tDouble.doubleValue();
/* 1016 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1019 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1021 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1023 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1026 */         this.date01 = null;
/*      */     }
/* 1028 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1030 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1032 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1035 */         this.operator = null;
/*      */     }
/* 1037 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1039 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1041 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1044 */         this.makeDate = null;
/*      */     }
/* 1046 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1048 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1050 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1053 */         this.makeTime = null;
/*      */     }
/* 1055 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1060 */     if (otherObject == null) return false;
/* 1061 */     if (this == otherObject) return true;
/* 1062 */     if (getClass() != otherObject.getClass()) return false;
/* 1063 */     MPrivateMessageSchema other = (MPrivateMessageSchema)otherObject;
/* 1064 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 1065 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 1066 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/* 1067 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/* 1068 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1069 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1070 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1071 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1072 */     if ((this.message == null) && (other.getMessage() != null)) return false;
/* 1073 */     if ((this.message != null) && (!this.message.equals(other.getMessage()))) return false;
/* 1074 */     if ((this.messageType == null) && (other.getMessageType() != null)) return false;
/* 1075 */     if ((this.messageType != null) && (!this.messageType.equals(other.getMessageType()))) return false;
/* 1076 */     if ((this.keyData == null) && (other.getKeyData() != null)) return false;
/* 1077 */     if ((this.keyData != null) && (!this.keyData.equals(other.getKeyData()))) return false;
/* 1078 */     if ((this.keyData2 == null) && (other.getKeyData2() != null)) return false;
/* 1079 */     if ((this.keyData2 != null) && (!this.keyData2.equals(other.getKeyData2()))) return false;
/* 1080 */     if ((this.keyData3 == null) && (other.getKeyData3() != null)) return false;
/* 1081 */     if ((this.keyData3 != null) && (!this.keyData3.equals(other.getKeyData3()))) return false;
/* 1082 */     if ((this.keyData4 == null) && (other.getKeyData4() != null)) return false;
/* 1083 */     if ((this.keyData4 != null) && (!this.keyData4.equals(other.getKeyData4()))) return false;
/* 1084 */     if ((this.uRL == null) && (other.getURL() != null)) return false;
/* 1085 */     if ((this.uRL != null) && (!this.uRL.equals(other.getURL()))) return false;
/* 1086 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 1087 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 1088 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1089 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1090 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 1091 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 1092 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 1093 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 1094 */     if ((this.startTime == null) && (other.getStartTime() != null)) return false;
/* 1095 */     if ((this.startTime != null) && (!this.startTime.equals(other.getStartTime()))) return false;
/* 1096 */     if ((this.endTime == null) && (other.getEndTime() != null)) return false;
/* 1097 */     if ((this.endTime != null) && (!this.endTime.equals(other.getEndTime()))) return false;
/* 1098 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1099 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1100 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1101 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1102 */     if (this.iF01 != other.getIF01()) return false;
/* 1103 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1104 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1105 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1106 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1107 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1108 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1109 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1110 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1111 */     return (this.makeTime == null) || (this.makeTime.equals(other.getMakeTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1118 */     return 25;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1124 */     if (strFieldName.equals("iD")) {
/* 1125 */       return 0;
/*      */     }
/* 1127 */     if (strFieldName.equals("agentCode")) {
/* 1128 */       return 1;
/*      */     }
/* 1130 */     if (strFieldName.equals("manageCom")) {
/* 1131 */       return 2;
/*      */     }
/* 1133 */     if (strFieldName.equals("branchType")) {
/* 1134 */       return 3;
/*      */     }
/* 1136 */     if (strFieldName.equals("message")) {
/* 1137 */       return 4;
/*      */     }
/* 1139 */     if (strFieldName.equals("messageType")) {
/* 1140 */       return 5;
/*      */     }
/* 1142 */     if (strFieldName.equals("keyData")) {
/* 1143 */       return 6;
/*      */     }
/* 1145 */     if (strFieldName.equals("keyData2")) {
/* 1146 */       return 7;
/*      */     }
/* 1148 */     if (strFieldName.equals("keyData3")) {
/* 1149 */       return 8;
/*      */     }
/* 1151 */     if (strFieldName.equals("keyData4")) {
/* 1152 */       return 9;
/*      */     }
/* 1154 */     if (strFieldName.equals("uRL")) {
/* 1155 */       return 10;
/*      */     }
/* 1157 */     if (strFieldName.equals("type")) {
/* 1158 */       return 11;
/*      */     }
/* 1160 */     if (strFieldName.equals("state")) {
/* 1161 */       return 12;
/*      */     }
/* 1163 */     if (strFieldName.equals("startDate")) {
/* 1164 */       return 13;
/*      */     }
/* 1166 */     if (strFieldName.equals("endDate")) {
/* 1167 */       return 14;
/*      */     }
/* 1169 */     if (strFieldName.equals("startTime")) {
/* 1170 */       return 15;
/*      */     }
/* 1172 */     if (strFieldName.equals("endTime")) {
/* 1173 */       return 16;
/*      */     }
/* 1175 */     if (strFieldName.equals("vF01")) {
/* 1176 */       return 17;
/*      */     }
/* 1178 */     if (strFieldName.equals("nF01")) {
/* 1179 */       return 18;
/*      */     }
/* 1181 */     if (strFieldName.equals("iF01")) {
/* 1182 */       return 19;
/*      */     }
/* 1184 */     if (strFieldName.equals("dF02")) {
/* 1185 */       return 20;
/*      */     }
/* 1187 */     if (strFieldName.equals("date01")) {
/* 1188 */       return 21;
/*      */     }
/* 1190 */     if (strFieldName.equals("operator")) {
/* 1191 */       return 22;
/*      */     }
/* 1193 */     if (strFieldName.equals("makeDate")) {
/* 1194 */       return 23;
/*      */     }
/* 1196 */     if (strFieldName.equals("makeTime")) {
/* 1197 */       return 24;
/*      */     }
/* 1199 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1205 */     String strFieldName = "";
/* 1206 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1208 */       strFieldName = "iD";
/* 1209 */       break;
/*      */     case 1:
/* 1211 */       strFieldName = "agentCode";
/* 1212 */       break;
/*      */     case 2:
/* 1214 */       strFieldName = "manageCom";
/* 1215 */       break;
/*      */     case 3:
/* 1217 */       strFieldName = "branchType";
/* 1218 */       break;
/*      */     case 4:
/* 1220 */       strFieldName = "message";
/* 1221 */       break;
/*      */     case 5:
/* 1223 */       strFieldName = "messageType";
/* 1224 */       break;
/*      */     case 6:
/* 1226 */       strFieldName = "keyData";
/* 1227 */       break;
/*      */     case 7:
/* 1229 */       strFieldName = "keyData2";
/* 1230 */       break;
/*      */     case 8:
/* 1232 */       strFieldName = "keyData3";
/* 1233 */       break;
/*      */     case 9:
/* 1235 */       strFieldName = "keyData4";
/* 1236 */       break;
/*      */     case 10:
/* 1238 */       strFieldName = "uRL";
/* 1239 */       break;
/*      */     case 11:
/* 1241 */       strFieldName = "type";
/* 1242 */       break;
/*      */     case 12:
/* 1244 */       strFieldName = "state";
/* 1245 */       break;
/*      */     case 13:
/* 1247 */       strFieldName = "startDate";
/* 1248 */       break;
/*      */     case 14:
/* 1250 */       strFieldName = "endDate";
/* 1251 */       break;
/*      */     case 15:
/* 1253 */       strFieldName = "startTime";
/* 1254 */       break;
/*      */     case 16:
/* 1256 */       strFieldName = "endTime";
/* 1257 */       break;
/*      */     case 17:
/* 1259 */       strFieldName = "vF01";
/* 1260 */       break;
/*      */     case 18:
/* 1262 */       strFieldName = "nF01";
/* 1263 */       break;
/*      */     case 19:
/* 1265 */       strFieldName = "iF01";
/* 1266 */       break;
/*      */     case 20:
/* 1268 */       strFieldName = "dF02";
/* 1269 */       break;
/*      */     case 21:
/* 1271 */       strFieldName = "date01";
/* 1272 */       break;
/*      */     case 22:
/* 1274 */       strFieldName = "operator";
/* 1275 */       break;
/*      */     case 23:
/* 1277 */       strFieldName = "makeDate";
/* 1278 */       break;
/*      */     case 24:
/* 1280 */       strFieldName = "makeTime";
/* 1281 */       break;
/*      */     default:
/* 1283 */       strFieldName = "";
/*      */     }
/* 1285 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1291 */     if (strFieldName.equals("iD")) {
/* 1292 */       return 0;
/*      */     }
/* 1294 */     if (strFieldName.equals("agentCode")) {
/* 1295 */       return 0;
/*      */     }
/* 1297 */     if (strFieldName.equals("manageCom")) {
/* 1298 */       return 0;
/*      */     }
/* 1300 */     if (strFieldName.equals("branchType")) {
/* 1301 */       return 0;
/*      */     }
/* 1303 */     if (strFieldName.equals("message")) {
/* 1304 */       return 0;
/*      */     }
/* 1306 */     if (strFieldName.equals("messageType")) {
/* 1307 */       return 0;
/*      */     }
/* 1309 */     if (strFieldName.equals("keyData")) {
/* 1310 */       return 0;
/*      */     }
/* 1312 */     if (strFieldName.equals("keyData2")) {
/* 1313 */       return 0;
/*      */     }
/* 1315 */     if (strFieldName.equals("keyData3")) {
/* 1316 */       return 0;
/*      */     }
/* 1318 */     if (strFieldName.equals("keyData4")) {
/* 1319 */       return 0;
/*      */     }
/* 1321 */     if (strFieldName.equals("uRL")) {
/* 1322 */       return 0;
/*      */     }
/* 1324 */     if (strFieldName.equals("type")) {
/* 1325 */       return 0;
/*      */     }
/* 1327 */     if (strFieldName.equals("state")) {
/* 1328 */       return 0;
/*      */     }
/* 1330 */     if (strFieldName.equals("startDate")) {
/* 1331 */       return 1;
/*      */     }
/* 1333 */     if (strFieldName.equals("endDate")) {
/* 1334 */       return 1;
/*      */     }
/* 1336 */     if (strFieldName.equals("startTime")) {
/* 1337 */       return 0;
/*      */     }
/* 1339 */     if (strFieldName.equals("endTime")) {
/* 1340 */       return 0;
/*      */     }
/* 1342 */     if (strFieldName.equals("vF01")) {
/* 1343 */       return 0;
/*      */     }
/* 1345 */     if (strFieldName.equals("nF01")) {
/* 1346 */       return 0;
/*      */     }
/* 1348 */     if (strFieldName.equals("iF01")) {
/* 1349 */       return 3;
/*      */     }
/* 1351 */     if (strFieldName.equals("dF02")) {
/* 1352 */       return 4;
/*      */     }
/* 1354 */     if (strFieldName.equals("date01")) {
/* 1355 */       return 1;
/*      */     }
/* 1357 */     if (strFieldName.equals("operator")) {
/* 1358 */       return 0;
/*      */     }
/* 1360 */     if (strFieldName.equals("makeDate")) {
/* 1361 */       return 1;
/*      */     }
/* 1363 */     if (strFieldName.equals("makeTime")) {
/* 1364 */       return 0;
/*      */     }
/* 1366 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1372 */     int nFieldType = -1;
/* 1373 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1375 */       nFieldType = 0;
/* 1376 */       break;
/*      */     case 1:
/* 1378 */       nFieldType = 0;
/* 1379 */       break;
/*      */     case 2:
/* 1381 */       nFieldType = 0;
/* 1382 */       break;
/*      */     case 3:
/* 1384 */       nFieldType = 0;
/* 1385 */       break;
/*      */     case 4:
/* 1387 */       nFieldType = 0;
/* 1388 */       break;
/*      */     case 5:
/* 1390 */       nFieldType = 0;
/* 1391 */       break;
/*      */     case 6:
/* 1393 */       nFieldType = 0;
/* 1394 */       break;
/*      */     case 7:
/* 1396 */       nFieldType = 0;
/* 1397 */       break;
/*      */     case 8:
/* 1399 */       nFieldType = 0;
/* 1400 */       break;
/*      */     case 9:
/* 1402 */       nFieldType = 0;
/* 1403 */       break;
/*      */     case 10:
/* 1405 */       nFieldType = 0;
/* 1406 */       break;
/*      */     case 11:
/* 1408 */       nFieldType = 0;
/* 1409 */       break;
/*      */     case 12:
/* 1411 */       nFieldType = 0;
/* 1412 */       break;
/*      */     case 13:
/* 1414 */       nFieldType = 1;
/* 1415 */       break;
/*      */     case 14:
/* 1417 */       nFieldType = 1;
/* 1418 */       break;
/*      */     case 15:
/* 1420 */       nFieldType = 0;
/* 1421 */       break;
/*      */     case 16:
/* 1423 */       nFieldType = 0;
/* 1424 */       break;
/*      */     case 17:
/* 1426 */       nFieldType = 0;
/* 1427 */       break;
/*      */     case 18:
/* 1429 */       nFieldType = 0;
/* 1430 */       break;
/*      */     case 19:
/* 1432 */       nFieldType = 3;
/* 1433 */       break;
/*      */     case 20:
/* 1435 */       nFieldType = 4;
/* 1436 */       break;
/*      */     case 21:
/* 1438 */       nFieldType = 1;
/* 1439 */       break;
/*      */     case 22:
/* 1441 */       nFieldType = 0;
/* 1442 */       break;
/*      */     case 23:
/* 1444 */       nFieldType = 1;
/* 1445 */       break;
/*      */     case 24:
/* 1447 */       nFieldType = 0;
/* 1448 */       break;
/*      */     default:
/* 1450 */       nFieldType = -1;
/*      */     }
/* 1452 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MPrivateMessageSchema
 * JD-Core Version:    0.6.0
 */