/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MC2BMessageDB;
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
/*      */ public class MC2BMessageSchema
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
/*      */   public static final int FIELDNUM = 24;
/*      */   private static String[] PK;
/*   72 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MC2BMessageSchema()
/*      */   {
/*   79 */     this.mErrors = new CErrors();
/*      */ 
/*   81 */     String[] pk = new String[1];
/*   82 */     pk[0] = "ID";
/*      */ 
/*   84 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   91 */     MC2BMessageSchema cloned = (MC2BMessageSchema)super.clone();
/*   92 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   93 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   94 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  100 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  105 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  109 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  113 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  117 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  121 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  125 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/*  129 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String aMessage) {
/*  133 */     this.message = aMessage;
/*      */   }
/*      */ 
/*      */   public String getMessageType() {
/*  137 */     return this.messageType;
/*      */   }
/*      */ 
/*      */   public void setMessageType(String aMessageType) {
/*  141 */     this.messageType = aMessageType;
/*      */   }
/*      */ 
/*      */   public String getKeyData() {
/*  145 */     return this.keyData;
/*      */   }
/*      */ 
/*      */   public void setKeyData(String aKeyData) {
/*  149 */     this.keyData = aKeyData;
/*      */   }
/*      */ 
/*      */   public String getKeyData2() {
/*  153 */     return this.keyData2;
/*      */   }
/*      */ 
/*      */   public void setKeyData2(String aKeyData2) {
/*  157 */     this.keyData2 = aKeyData2;
/*      */   }
/*      */ 
/*      */   public String getKeyData3() {
/*  161 */     return this.keyData3;
/*      */   }
/*      */ 
/*      */   public void setKeyData3(String aKeyData3) {
/*  165 */     this.keyData3 = aKeyData3;
/*      */   }
/*      */ 
/*      */   public String getKeyData4() {
/*  169 */     return this.keyData4;
/*      */   }
/*      */ 
/*      */   public void setKeyData4(String aKeyData4) {
/*  173 */     this.keyData4 = aKeyData4;
/*      */   }
/*      */ 
/*      */   public String getURL() {
/*  177 */     return this.uRL;
/*      */   }
/*      */ 
/*      */   public void setURL(String aURL) {
/*  181 */     this.uRL = aURL;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  185 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  189 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  193 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  197 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  201 */     if (this.startDate != null) {
/*  202 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  204 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  208 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  212 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  214 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  217 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  222 */     if (this.endDate != null) {
/*  223 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  225 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  229 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  233 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  235 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  238 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartTime()
/*      */   {
/*  243 */     return this.startTime;
/*      */   }
/*      */ 
/*      */   public void setStartTime(String aStartTime) {
/*  247 */     this.startTime = aStartTime;
/*      */   }
/*      */ 
/*      */   public String getEndTime() {
/*  251 */     return this.endTime;
/*      */   }
/*      */ 
/*      */   public void setEndTime(String aEndTime) {
/*  255 */     this.endTime = aEndTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  259 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  263 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  267 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  271 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  275 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  279 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  283 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  285 */       Integer tInteger = new Integer(aIF01);
/*  286 */       int i = tInteger.intValue();
/*  287 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  293 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  297 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  301 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  303 */       Double tDouble = new Double(aDF02);
/*  304 */       double d = tDouble.doubleValue();
/*  305 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  311 */     if (this.date01 != null) {
/*  312 */       return this.fDate.getString(this.date01);
/*      */     }
/*  314 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  318 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  322 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  324 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  327 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  332 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  336 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  340 */     if (this.makeDate != null) {
/*  341 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  343 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  347 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  351 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  353 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  356 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  361 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  365 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MC2BMessageSchema aMC2BMessageSchema)
/*      */   {
/*  371 */     this.iD = aMC2BMessageSchema.getID();
/*  372 */     this.manageCom = aMC2BMessageSchema.getManageCom();
/*  373 */     this.branchType = aMC2BMessageSchema.getBranchType();
/*  374 */     this.message = aMC2BMessageSchema.getMessage();
/*  375 */     this.messageType = aMC2BMessageSchema.getMessageType();
/*  376 */     this.keyData = aMC2BMessageSchema.getKeyData();
/*  377 */     this.keyData2 = aMC2BMessageSchema.getKeyData2();
/*  378 */     this.keyData3 = aMC2BMessageSchema.getKeyData3();
/*  379 */     this.keyData4 = aMC2BMessageSchema.getKeyData4();
/*  380 */     this.uRL = aMC2BMessageSchema.getURL();
/*  381 */     this.type = aMC2BMessageSchema.getType();
/*  382 */     this.state = aMC2BMessageSchema.getState();
/*  383 */     this.startDate = this.fDate.getDate(aMC2BMessageSchema.getStartDate());
/*  384 */     this.endDate = this.fDate.getDate(aMC2BMessageSchema.getEndDate());
/*  385 */     this.startTime = aMC2BMessageSchema.getStartTime();
/*  386 */     this.endTime = aMC2BMessageSchema.getEndTime();
/*  387 */     this.vF01 = aMC2BMessageSchema.getVF01();
/*  388 */     this.nF01 = aMC2BMessageSchema.getNF01();
/*  389 */     this.iF01 = aMC2BMessageSchema.getIF01();
/*  390 */     this.dF02 = aMC2BMessageSchema.getDF02();
/*  391 */     this.date01 = this.fDate.getDate(aMC2BMessageSchema.getDate01());
/*  392 */     this.operator = aMC2BMessageSchema.getOperator();
/*  393 */     this.makeDate = this.fDate.getDate(aMC2BMessageSchema.getMakeDate());
/*  394 */     this.makeTime = aMC2BMessageSchema.getMakeTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  403 */       if (rs.getString("ID") == null)
/*  404 */         this.iD = null;
/*      */       else {
/*  406 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  408 */       if (rs.getString("ManageCom") == null)
/*  409 */         this.manageCom = null;
/*      */       else {
/*  411 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  413 */       if (rs.getString("BranchType") == null)
/*  414 */         this.branchType = null;
/*      */       else {
/*  416 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  418 */       if (rs.getString("Message") == null)
/*  419 */         this.message = null;
/*      */       else {
/*  421 */         this.message = rs.getString("Message").trim();
/*      */       }
/*  423 */       if (rs.getString("MessageType") == null)
/*  424 */         this.messageType = null;
/*      */       else {
/*  426 */         this.messageType = rs.getString("MessageType").trim();
/*      */       }
/*  428 */       if (rs.getString("KeyData") == null)
/*  429 */         this.keyData = null;
/*      */       else {
/*  431 */         this.keyData = rs.getString("KeyData").trim();
/*      */       }
/*  433 */       if (rs.getString("KeyData2") == null)
/*  434 */         this.keyData2 = null;
/*      */       else {
/*  436 */         this.keyData2 = rs.getString("KeyData2").trim();
/*      */       }
/*  438 */       if (rs.getString("KeyData3") == null)
/*  439 */         this.keyData3 = null;
/*      */       else {
/*  441 */         this.keyData3 = rs.getString("KeyData3").trim();
/*      */       }
/*  443 */       if (rs.getString("KeyData4") == null)
/*  444 */         this.keyData4 = null;
/*      */       else {
/*  446 */         this.keyData4 = rs.getString("KeyData4").trim();
/*      */       }
/*  448 */       if (rs.getString("URL") == null)
/*  449 */         this.uRL = null;
/*      */       else {
/*  451 */         this.uRL = rs.getString("URL").trim();
/*      */       }
/*  453 */       if (rs.getString("Type") == null)
/*  454 */         this.type = null;
/*      */       else {
/*  456 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  458 */       if (rs.getString("State") == null)
/*  459 */         this.state = null;
/*      */       else {
/*  461 */         this.state = rs.getString("State").trim();
/*      */       }
/*  463 */       this.startDate = rs.getDate("StartDate");
/*  464 */       this.endDate = rs.getDate("EndDate");
/*  465 */       if (rs.getString("StartTime") == null)
/*  466 */         this.startTime = null;
/*      */       else {
/*  468 */         this.startTime = rs.getString("StartTime").trim();
/*      */       }
/*  470 */       if (rs.getString("EndTime") == null)
/*  471 */         this.endTime = null;
/*      */       else {
/*  473 */         this.endTime = rs.getString("EndTime").trim();
/*      */       }
/*  475 */       if (rs.getString("VF01") == null)
/*  476 */         this.vF01 = null;
/*      */       else {
/*  478 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  480 */       if (rs.getString("NF01") == null)
/*  481 */         this.nF01 = null;
/*      */       else {
/*  483 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  485 */       this.iF01 = rs.getInt("IF01");
/*  486 */       this.dF02 = rs.getDouble("DF02");
/*  487 */       this.date01 = rs.getDate("Date01");
/*  488 */       if (rs.getString("Operator") == null)
/*  489 */         this.operator = null;
/*      */       else {
/*  491 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  493 */       this.makeDate = rs.getDate("MakeDate");
/*  494 */       if (rs.getString("MakeTime") == null)
/*  495 */         this.makeTime = null;
/*      */       else {
/*  497 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  502 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MC2BMessage\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  504 */       CError tError = new CError();
/*  505 */       tError.moduleName = "MC2BMessageSchema";
/*  506 */       tError.functionName = "setSchema";
/*  507 */       tError.errorMessage = sqle.toString();
/*  508 */       this.mErrors.addOneError(tError);
/*  509 */       return false;
/*      */     }
/*  511 */     return true;
/*      */   }
/*      */ 
/*      */   public MC2BMessageSchema getSchema()
/*      */   {
/*  516 */     MC2BMessageSchema aMC2BMessageSchema = new MC2BMessageSchema();
/*  517 */     aMC2BMessageSchema.setSchema(this);
/*  518 */     return aMC2BMessageSchema;
/*      */   }
/*      */ 
/*      */   public MC2BMessageDB getDB()
/*      */   {
/*  523 */     MC2BMessageDB aDBOper = new MC2BMessageDB();
/*  524 */     aDBOper.setSchema(this);
/*  525 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  532 */     StringBuffer strReturn = new StringBuffer(256);
/*  533 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  534 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  535 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  536 */     strReturn.append(StrTool.cTrim(this.message)); strReturn.append("|");
/*  537 */     strReturn.append(StrTool.cTrim(this.messageType)); strReturn.append("|");
/*  538 */     strReturn.append(StrTool.cTrim(this.keyData)); strReturn.append("|");
/*  539 */     strReturn.append(StrTool.cTrim(this.keyData2)); strReturn.append("|");
/*  540 */     strReturn.append(StrTool.cTrim(this.keyData3)); strReturn.append("|");
/*  541 */     strReturn.append(StrTool.cTrim(this.keyData4)); strReturn.append("|");
/*  542 */     strReturn.append(StrTool.cTrim(this.uRL)); strReturn.append("|");
/*  543 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  544 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  545 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  546 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  547 */     strReturn.append(StrTool.cTrim(this.startTime)); strReturn.append("|");
/*  548 */     strReturn.append(StrTool.cTrim(this.endTime)); strReturn.append("|");
/*  549 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  550 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  551 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  552 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  553 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  554 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  555 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  556 */     strReturn.append(StrTool.cTrim(this.makeTime));
/*  557 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  565 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  566 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  567 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  568 */       this.message = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  569 */       this.messageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  570 */       this.keyData = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  571 */       this.keyData2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  572 */       this.keyData3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  573 */       this.keyData4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  574 */       this.uRL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  575 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  576 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  577 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
/*  578 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/*  579 */       this.startTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  580 */       this.endTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  581 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  582 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  583 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 19, "|"))).intValue();
/*  584 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).doubleValue();
/*  585 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
/*  586 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  587 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
/*  588 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  593 */       CError tError = new CError();
/*  594 */       tError.moduleName = "MC2BMessageSchema";
/*  595 */       tError.functionName = "decode";
/*  596 */       tError.errorMessage = ex.toString();
/*  597 */       this.mErrors.addOneError(tError);
/*      */ 
/*  599 */       return false;
/*      */     }
/*  601 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  607 */     String strReturn = "";
/*  608 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  610 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  612 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  614 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  616 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  618 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  620 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/*  622 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.message));
/*      */     }
/*  624 */     if (FCode.equalsIgnoreCase("messageType"))
/*      */     {
/*  626 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageType));
/*      */     }
/*  628 */     if (FCode.equalsIgnoreCase("keyData"))
/*      */     {
/*  630 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData));
/*      */     }
/*  632 */     if (FCode.equalsIgnoreCase("keyData2"))
/*      */     {
/*  634 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData2));
/*      */     }
/*  636 */     if (FCode.equalsIgnoreCase("keyData3"))
/*      */     {
/*  638 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData3));
/*      */     }
/*  640 */     if (FCode.equalsIgnoreCase("keyData4"))
/*      */     {
/*  642 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.keyData4));
/*      */     }
/*  644 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  646 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uRL));
/*      */     }
/*  648 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  650 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  652 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  654 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  656 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  658 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  660 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  662 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  664 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/*  666 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startTime));
/*      */     }
/*  668 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/*  670 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endTime));
/*      */     }
/*  672 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  674 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  676 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  678 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  680 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  682 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  684 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  686 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  688 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  690 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  692 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  694 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  696 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  698 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  700 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  702 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  704 */     if (strReturn.equals(""))
/*      */     {
/*  706 */       strReturn = "null";
/*      */     }
/*      */ 
/*  709 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  716 */     String strFieldValue = "";
/*  717 */     switch (nFieldIndex) {
/*      */     case 0:
/*  719 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  720 */       break;
/*      */     case 1:
/*  722 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  723 */       break;
/*      */     case 2:
/*  725 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  726 */       break;
/*      */     case 3:
/*  728 */       strFieldValue = StrTool.GBKToUnicode(this.message);
/*  729 */       break;
/*      */     case 4:
/*  731 */       strFieldValue = StrTool.GBKToUnicode(this.messageType);
/*  732 */       break;
/*      */     case 5:
/*  734 */       strFieldValue = StrTool.GBKToUnicode(this.keyData);
/*  735 */       break;
/*      */     case 6:
/*  737 */       strFieldValue = StrTool.GBKToUnicode(this.keyData2);
/*  738 */       break;
/*      */     case 7:
/*  740 */       strFieldValue = StrTool.GBKToUnicode(this.keyData3);
/*  741 */       break;
/*      */     case 8:
/*  743 */       strFieldValue = StrTool.GBKToUnicode(this.keyData4);
/*  744 */       break;
/*      */     case 9:
/*  746 */       strFieldValue = StrTool.GBKToUnicode(this.uRL);
/*  747 */       break;
/*      */     case 10:
/*  749 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  750 */       break;
/*      */     case 11:
/*  752 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  753 */       break;
/*      */     case 12:
/*  755 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  756 */       break;
/*      */     case 13:
/*  758 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*  759 */       break;
/*      */     case 14:
/*  761 */       strFieldValue = StrTool.GBKToUnicode(this.startTime);
/*  762 */       break;
/*      */     case 15:
/*  764 */       strFieldValue = StrTool.GBKToUnicode(this.endTime);
/*  765 */       break;
/*      */     case 16:
/*  767 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  768 */       break;
/*      */     case 17:
/*  770 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  771 */       break;
/*      */     case 18:
/*  773 */       strFieldValue = String.valueOf(this.iF01);
/*  774 */       break;
/*      */     case 19:
/*  776 */       strFieldValue = String.valueOf(this.dF02);
/*  777 */       break;
/*      */     case 20:
/*  779 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  780 */       break;
/*      */     case 21:
/*  782 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  783 */       break;
/*      */     case 22:
/*  785 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  786 */       break;
/*      */     case 23:
/*  788 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  789 */       break;
/*      */     default:
/*  791 */       strFieldValue = "";
/*      */     }
/*  793 */     if (strFieldValue.equals("")) {
/*  794 */       strFieldValue = "null";
/*      */     }
/*  796 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  802 */     if (StrTool.cTrim(FCode).equals("")) {
/*  803 */       return false;
/*      */     }
/*  805 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  807 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  809 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  812 */         this.iD = null;
/*      */     }
/*  814 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  816 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  818 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  821 */         this.manageCom = null;
/*      */     }
/*  823 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  825 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  827 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  830 */         this.branchType = null;
/*      */     }
/*  832 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/*  834 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  836 */         this.message = FValue.trim();
/*      */       }
/*      */       else
/*  839 */         this.message = null;
/*      */     }
/*  841 */     if (FCode.equalsIgnoreCase("messageType"))
/*      */     {
/*  843 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  845 */         this.messageType = FValue.trim();
/*      */       }
/*      */       else
/*  848 */         this.messageType = null;
/*      */     }
/*  850 */     if (FCode.equalsIgnoreCase("keyData"))
/*      */     {
/*  852 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  854 */         this.keyData = FValue.trim();
/*      */       }
/*      */       else
/*  857 */         this.keyData = null;
/*      */     }
/*  859 */     if (FCode.equalsIgnoreCase("keyData2"))
/*      */     {
/*  861 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  863 */         this.keyData2 = FValue.trim();
/*      */       }
/*      */       else
/*  866 */         this.keyData2 = null;
/*      */     }
/*  868 */     if (FCode.equalsIgnoreCase("keyData3"))
/*      */     {
/*  870 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  872 */         this.keyData3 = FValue.trim();
/*      */       }
/*      */       else
/*  875 */         this.keyData3 = null;
/*      */     }
/*  877 */     if (FCode.equalsIgnoreCase("keyData4"))
/*      */     {
/*  879 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  881 */         this.keyData4 = FValue.trim();
/*      */       }
/*      */       else
/*  884 */         this.keyData4 = null;
/*      */     }
/*  886 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  888 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  890 */         this.uRL = FValue.trim();
/*      */       }
/*      */       else
/*  893 */         this.uRL = null;
/*      */     }
/*  895 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  897 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  899 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/*  902 */         this.type = null;
/*      */     }
/*  904 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  906 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  908 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  911 */         this.state = null;
/*      */     }
/*  913 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  915 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  917 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  920 */         this.startDate = null;
/*      */     }
/*  922 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  924 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  926 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  929 */         this.endDate = null;
/*      */     }
/*  931 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/*  933 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  935 */         this.startTime = FValue.trim();
/*      */       }
/*      */       else
/*  938 */         this.startTime = null;
/*      */     }
/*  940 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/*  942 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  944 */         this.endTime = FValue.trim();
/*      */       }
/*      */       else
/*  947 */         this.endTime = null;
/*      */     }
/*  949 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  951 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  953 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/*  956 */         this.vF01 = null;
/*      */     }
/*  958 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  960 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  962 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/*  965 */         this.nF01 = null;
/*      */     }
/*  967 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  969 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  971 */         Integer tInteger = new Integer(FValue);
/*  972 */         int i = tInteger.intValue();
/*  973 */         this.iF01 = i;
/*      */       }
/*      */     }
/*  976 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  978 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  980 */         Double tDouble = new Double(FValue);
/*  981 */         double d = tDouble.doubleValue();
/*  982 */         this.dF02 = d;
/*      */       }
/*      */     }
/*  985 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  987 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  989 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  992 */         this.date01 = null;
/*      */     }
/*  994 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  996 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  998 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1001 */         this.operator = null;
/*      */     }
/* 1003 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1005 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1007 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1010 */         this.makeDate = null;
/*      */     }
/* 1012 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1014 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1016 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1019 */         this.makeTime = null;
/*      */     }
/* 1021 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1026 */     if (otherObject == null) return false;
/* 1027 */     if (this == otherObject) return true;
/* 1028 */     if (getClass() != otherObject.getClass()) return false;
/* 1029 */     MC2BMessageSchema other = (MC2BMessageSchema)otherObject;
/* 1030 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 1031 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 1032 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1033 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1034 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1035 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1036 */     if ((this.message == null) && (other.getMessage() != null)) return false;
/* 1037 */     if ((this.message != null) && (!this.message.equals(other.getMessage()))) return false;
/* 1038 */     if ((this.messageType == null) && (other.getMessageType() != null)) return false;
/* 1039 */     if ((this.messageType != null) && (!this.messageType.equals(other.getMessageType()))) return false;
/* 1040 */     if ((this.keyData == null) && (other.getKeyData() != null)) return false;
/* 1041 */     if ((this.keyData != null) && (!this.keyData.equals(other.getKeyData()))) return false;
/* 1042 */     if ((this.keyData2 == null) && (other.getKeyData2() != null)) return false;
/* 1043 */     if ((this.keyData2 != null) && (!this.keyData2.equals(other.getKeyData2()))) return false;
/* 1044 */     if ((this.keyData3 == null) && (other.getKeyData3() != null)) return false;
/* 1045 */     if ((this.keyData3 != null) && (!this.keyData3.equals(other.getKeyData3()))) return false;
/* 1046 */     if ((this.keyData4 == null) && (other.getKeyData4() != null)) return false;
/* 1047 */     if ((this.keyData4 != null) && (!this.keyData4.equals(other.getKeyData4()))) return false;
/* 1048 */     if ((this.uRL == null) && (other.getURL() != null)) return false;
/* 1049 */     if ((this.uRL != null) && (!this.uRL.equals(other.getURL()))) return false;
/* 1050 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 1051 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 1052 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1053 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1054 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 1055 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 1056 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 1057 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 1058 */     if ((this.startTime == null) && (other.getStartTime() != null)) return false;
/* 1059 */     if ((this.startTime != null) && (!this.startTime.equals(other.getStartTime()))) return false;
/* 1060 */     if ((this.endTime == null) && (other.getEndTime() != null)) return false;
/* 1061 */     if ((this.endTime != null) && (!this.endTime.equals(other.getEndTime()))) return false;
/* 1062 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1063 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1064 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1065 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1066 */     if (this.iF01 != other.getIF01()) return false;
/* 1067 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1068 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1069 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1070 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1071 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1072 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1073 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1074 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1075 */     return (this.makeTime == null) || (this.makeTime.equals(other.getMakeTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1082 */     return 24;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1088 */     if (strFieldName.equals("iD")) {
/* 1089 */       return 0;
/*      */     }
/* 1091 */     if (strFieldName.equals("manageCom")) {
/* 1092 */       return 1;
/*      */     }
/* 1094 */     if (strFieldName.equals("branchType")) {
/* 1095 */       return 2;
/*      */     }
/* 1097 */     if (strFieldName.equals("message")) {
/* 1098 */       return 3;
/*      */     }
/* 1100 */     if (strFieldName.equals("messageType")) {
/* 1101 */       return 4;
/*      */     }
/* 1103 */     if (strFieldName.equals("keyData")) {
/* 1104 */       return 5;
/*      */     }
/* 1106 */     if (strFieldName.equals("keyData2")) {
/* 1107 */       return 6;
/*      */     }
/* 1109 */     if (strFieldName.equals("keyData3")) {
/* 1110 */       return 7;
/*      */     }
/* 1112 */     if (strFieldName.equals("keyData4")) {
/* 1113 */       return 8;
/*      */     }
/* 1115 */     if (strFieldName.equals("uRL")) {
/* 1116 */       return 9;
/*      */     }
/* 1118 */     if (strFieldName.equals("type")) {
/* 1119 */       return 10;
/*      */     }
/* 1121 */     if (strFieldName.equals("state")) {
/* 1122 */       return 11;
/*      */     }
/* 1124 */     if (strFieldName.equals("startDate")) {
/* 1125 */       return 12;
/*      */     }
/* 1127 */     if (strFieldName.equals("endDate")) {
/* 1128 */       return 13;
/*      */     }
/* 1130 */     if (strFieldName.equals("startTime")) {
/* 1131 */       return 14;
/*      */     }
/* 1133 */     if (strFieldName.equals("endTime")) {
/* 1134 */       return 15;
/*      */     }
/* 1136 */     if (strFieldName.equals("vF01")) {
/* 1137 */       return 16;
/*      */     }
/* 1139 */     if (strFieldName.equals("nF01")) {
/* 1140 */       return 17;
/*      */     }
/* 1142 */     if (strFieldName.equals("iF01")) {
/* 1143 */       return 18;
/*      */     }
/* 1145 */     if (strFieldName.equals("dF02")) {
/* 1146 */       return 19;
/*      */     }
/* 1148 */     if (strFieldName.equals("date01")) {
/* 1149 */       return 20;
/*      */     }
/* 1151 */     if (strFieldName.equals("operator")) {
/* 1152 */       return 21;
/*      */     }
/* 1154 */     if (strFieldName.equals("makeDate")) {
/* 1155 */       return 22;
/*      */     }
/* 1157 */     if (strFieldName.equals("makeTime")) {
/* 1158 */       return 23;
/*      */     }
/* 1160 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1166 */     String strFieldName = "";
/* 1167 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1169 */       strFieldName = "iD";
/* 1170 */       break;
/*      */     case 1:
/* 1172 */       strFieldName = "manageCom";
/* 1173 */       break;
/*      */     case 2:
/* 1175 */       strFieldName = "branchType";
/* 1176 */       break;
/*      */     case 3:
/* 1178 */       strFieldName = "message";
/* 1179 */       break;
/*      */     case 4:
/* 1181 */       strFieldName = "messageType";
/* 1182 */       break;
/*      */     case 5:
/* 1184 */       strFieldName = "keyData";
/* 1185 */       break;
/*      */     case 6:
/* 1187 */       strFieldName = "keyData2";
/* 1188 */       break;
/*      */     case 7:
/* 1190 */       strFieldName = "keyData3";
/* 1191 */       break;
/*      */     case 8:
/* 1193 */       strFieldName = "keyData4";
/* 1194 */       break;
/*      */     case 9:
/* 1196 */       strFieldName = "uRL";
/* 1197 */       break;
/*      */     case 10:
/* 1199 */       strFieldName = "type";
/* 1200 */       break;
/*      */     case 11:
/* 1202 */       strFieldName = "state";
/* 1203 */       break;
/*      */     case 12:
/* 1205 */       strFieldName = "startDate";
/* 1206 */       break;
/*      */     case 13:
/* 1208 */       strFieldName = "endDate";
/* 1209 */       break;
/*      */     case 14:
/* 1211 */       strFieldName = "startTime";
/* 1212 */       break;
/*      */     case 15:
/* 1214 */       strFieldName = "endTime";
/* 1215 */       break;
/*      */     case 16:
/* 1217 */       strFieldName = "vF01";
/* 1218 */       break;
/*      */     case 17:
/* 1220 */       strFieldName = "nF01";
/* 1221 */       break;
/*      */     case 18:
/* 1223 */       strFieldName = "iF01";
/* 1224 */       break;
/*      */     case 19:
/* 1226 */       strFieldName = "dF02";
/* 1227 */       break;
/*      */     case 20:
/* 1229 */       strFieldName = "date01";
/* 1230 */       break;
/*      */     case 21:
/* 1232 */       strFieldName = "operator";
/* 1233 */       break;
/*      */     case 22:
/* 1235 */       strFieldName = "makeDate";
/* 1236 */       break;
/*      */     case 23:
/* 1238 */       strFieldName = "makeTime";
/* 1239 */       break;
/*      */     default:
/* 1241 */       strFieldName = "";
/*      */     }
/* 1243 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1249 */     if (strFieldName.equals("iD")) {
/* 1250 */       return 0;
/*      */     }
/* 1252 */     if (strFieldName.equals("manageCom")) {
/* 1253 */       return 0;
/*      */     }
/* 1255 */     if (strFieldName.equals("branchType")) {
/* 1256 */       return 0;
/*      */     }
/* 1258 */     if (strFieldName.equals("message")) {
/* 1259 */       return 0;
/*      */     }
/* 1261 */     if (strFieldName.equals("messageType")) {
/* 1262 */       return 0;
/*      */     }
/* 1264 */     if (strFieldName.equals("keyData")) {
/* 1265 */       return 0;
/*      */     }
/* 1267 */     if (strFieldName.equals("keyData2")) {
/* 1268 */       return 0;
/*      */     }
/* 1270 */     if (strFieldName.equals("keyData3")) {
/* 1271 */       return 0;
/*      */     }
/* 1273 */     if (strFieldName.equals("keyData4")) {
/* 1274 */       return 0;
/*      */     }
/* 1276 */     if (strFieldName.equals("uRL")) {
/* 1277 */       return 0;
/*      */     }
/* 1279 */     if (strFieldName.equals("type")) {
/* 1280 */       return 0;
/*      */     }
/* 1282 */     if (strFieldName.equals("state")) {
/* 1283 */       return 0;
/*      */     }
/* 1285 */     if (strFieldName.equals("startDate")) {
/* 1286 */       return 1;
/*      */     }
/* 1288 */     if (strFieldName.equals("endDate")) {
/* 1289 */       return 1;
/*      */     }
/* 1291 */     if (strFieldName.equals("startTime")) {
/* 1292 */       return 0;
/*      */     }
/* 1294 */     if (strFieldName.equals("endTime")) {
/* 1295 */       return 0;
/*      */     }
/* 1297 */     if (strFieldName.equals("vF01")) {
/* 1298 */       return 0;
/*      */     }
/* 1300 */     if (strFieldName.equals("nF01")) {
/* 1301 */       return 0;
/*      */     }
/* 1303 */     if (strFieldName.equals("iF01")) {
/* 1304 */       return 3;
/*      */     }
/* 1306 */     if (strFieldName.equals("dF02")) {
/* 1307 */       return 4;
/*      */     }
/* 1309 */     if (strFieldName.equals("date01")) {
/* 1310 */       return 1;
/*      */     }
/* 1312 */     if (strFieldName.equals("operator")) {
/* 1313 */       return 0;
/*      */     }
/* 1315 */     if (strFieldName.equals("makeDate")) {
/* 1316 */       return 1;
/*      */     }
/* 1318 */     if (strFieldName.equals("makeTime")) {
/* 1319 */       return 0;
/*      */     }
/* 1321 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1327 */     int nFieldType = -1;
/* 1328 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1330 */       nFieldType = 0;
/* 1331 */       break;
/*      */     case 1:
/* 1333 */       nFieldType = 0;
/* 1334 */       break;
/*      */     case 2:
/* 1336 */       nFieldType = 0;
/* 1337 */       break;
/*      */     case 3:
/* 1339 */       nFieldType = 0;
/* 1340 */       break;
/*      */     case 4:
/* 1342 */       nFieldType = 0;
/* 1343 */       break;
/*      */     case 5:
/* 1345 */       nFieldType = 0;
/* 1346 */       break;
/*      */     case 6:
/* 1348 */       nFieldType = 0;
/* 1349 */       break;
/*      */     case 7:
/* 1351 */       nFieldType = 0;
/* 1352 */       break;
/*      */     case 8:
/* 1354 */       nFieldType = 0;
/* 1355 */       break;
/*      */     case 9:
/* 1357 */       nFieldType = 0;
/* 1358 */       break;
/*      */     case 10:
/* 1360 */       nFieldType = 0;
/* 1361 */       break;
/*      */     case 11:
/* 1363 */       nFieldType = 0;
/* 1364 */       break;
/*      */     case 12:
/* 1366 */       nFieldType = 1;
/* 1367 */       break;
/*      */     case 13:
/* 1369 */       nFieldType = 1;
/* 1370 */       break;
/*      */     case 14:
/* 1372 */       nFieldType = 0;
/* 1373 */       break;
/*      */     case 15:
/* 1375 */       nFieldType = 0;
/* 1376 */       break;
/*      */     case 16:
/* 1378 */       nFieldType = 0;
/* 1379 */       break;
/*      */     case 17:
/* 1381 */       nFieldType = 0;
/* 1382 */       break;
/*      */     case 18:
/* 1384 */       nFieldType = 3;
/* 1385 */       break;
/*      */     case 19:
/* 1387 */       nFieldType = 4;
/* 1388 */       break;
/*      */     case 20:
/* 1390 */       nFieldType = 1;
/* 1391 */       break;
/*      */     case 21:
/* 1393 */       nFieldType = 0;
/* 1394 */       break;
/*      */     case 22:
/* 1396 */       nFieldType = 1;
/* 1397 */       break;
/*      */     case 23:
/* 1399 */       nFieldType = 0;
/* 1400 */       break;
/*      */     default:
/* 1402 */       nFieldType = -1;
/*      */     }
/* 1404 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MC2BMessageSchema
 * JD-Core Version:    0.6.0
 */