/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MInvOptionBDB;
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
/*      */ public class MInvOptionBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   private String optionID;
/*      */   private String questionID;
/*      */   private String option;
/*      */   private int optionOrder;
/*      */   private String state;
/*      */   private String vF01;
/*      */   private String nF01;
/*      */   private int iF01;
/*      */   private double dF02;
/*      */   private Date date01;
/*      */   private String modifyOperator;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 22;
/*      */   private static String[] PK;
/*   68 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MInvOptionBSchema()
/*      */   {
/*   75 */     this.mErrors = new CErrors();
/*      */ 
/*   77 */     String[] pk = new String[1];
/*   78 */     pk[0] = "EdorNo";
/*      */ 
/*   80 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   87 */     MInvOptionBSchema cloned = (MInvOptionBSchema)super.clone();
/*   88 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   89 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   90 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   96 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  101 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  105 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  109 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  113 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  117 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  121 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  125 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  129 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  133 */     if (this.makeDate2 != null) {
/*  134 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  136 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  140 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  144 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  146 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  149 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  154 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  158 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public String getOptionID() {
/*  162 */     return this.optionID;
/*      */   }
/*      */ 
/*      */   public void setOptionID(String aOptionID) {
/*  166 */     this.optionID = aOptionID;
/*      */   }
/*      */ 
/*      */   public String getQuestionID() {
/*  170 */     return this.questionID;
/*      */   }
/*      */ 
/*      */   public void setQuestionID(String aQuestionID) {
/*  174 */     this.questionID = aQuestionID;
/*      */   }
/*      */ 
/*      */   public String getOption() {
/*  178 */     return this.option;
/*      */   }
/*      */ 
/*      */   public void setOption(String aOption) {
/*  182 */     this.option = aOption;
/*      */   }
/*      */ 
/*      */   public int getOptionOrder() {
/*  186 */     return this.optionOrder;
/*      */   }
/*      */ 
/*      */   public void setOptionOrder(int aOptionOrder) {
/*  190 */     this.optionOrder = aOptionOrder;
/*      */   }
/*      */ 
/*      */   public void setOptionOrder(String aOptionOrder) {
/*  194 */     if ((aOptionOrder != null) && (!aOptionOrder.equals("")))
/*      */     {
/*  196 */       Integer tInteger = new Integer(aOptionOrder);
/*  197 */       int i = tInteger.intValue();
/*  198 */       this.optionOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getState()
/*      */   {
/*  204 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  208 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  212 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  216 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  220 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  224 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  228 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  232 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  236 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  238 */       Integer tInteger = new Integer(aIF01);
/*  239 */       int i = tInteger.intValue();
/*  240 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  246 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  250 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  254 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  256 */       Double tDouble = new Double(aDF02);
/*  257 */       double d = tDouble.doubleValue();
/*  258 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  264 */     if (this.date01 != null) {
/*  265 */       return this.fDate.getString(this.date01);
/*      */     }
/*  267 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  271 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  275 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  277 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  280 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  285 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  289 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  293 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  297 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  301 */     if (this.makeDate != null) {
/*  302 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  304 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  308 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  312 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  314 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  317 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  322 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  326 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  330 */     if (this.modifyDate != null) {
/*  331 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  333 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  337 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  341 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  343 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  346 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  351 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  355 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MInvOptionBSchema aMInvOptionBSchema)
/*      */   {
/*  361 */     this.edorNo = aMInvOptionBSchema.getEdorNo();
/*  362 */     this.edorType = aMInvOptionBSchema.getEdorType();
/*  363 */     this.edorCase = aMInvOptionBSchema.getEdorCase();
/*  364 */     this.operator2 = aMInvOptionBSchema.getOperator2();
/*  365 */     this.makeDate2 = this.fDate.getDate(aMInvOptionBSchema.getMakeDate2());
/*  366 */     this.makeTime2 = aMInvOptionBSchema.getMakeTime2();
/*  367 */     this.optionID = aMInvOptionBSchema.getOptionID();
/*  368 */     this.questionID = aMInvOptionBSchema.getQuestionID();
/*  369 */     this.option = aMInvOptionBSchema.getOption();
/*  370 */     this.optionOrder = aMInvOptionBSchema.getOptionOrder();
/*  371 */     this.state = aMInvOptionBSchema.getState();
/*  372 */     this.vF01 = aMInvOptionBSchema.getVF01();
/*  373 */     this.nF01 = aMInvOptionBSchema.getNF01();
/*  374 */     this.iF01 = aMInvOptionBSchema.getIF01();
/*  375 */     this.dF02 = aMInvOptionBSchema.getDF02();
/*  376 */     this.date01 = this.fDate.getDate(aMInvOptionBSchema.getDate01());
/*  377 */     this.modifyOperator = aMInvOptionBSchema.getModifyOperator();
/*  378 */     this.operator = aMInvOptionBSchema.getOperator();
/*  379 */     this.makeDate = this.fDate.getDate(aMInvOptionBSchema.getMakeDate());
/*  380 */     this.makeTime = aMInvOptionBSchema.getMakeTime();
/*  381 */     this.modifyDate = this.fDate.getDate(aMInvOptionBSchema.getModifyDate());
/*  382 */     this.modifyTime = aMInvOptionBSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  391 */       if (rs.getString("EdorNo") == null)
/*  392 */         this.edorNo = null;
/*      */       else {
/*  394 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  396 */       if (rs.getString("EdorType") == null)
/*  397 */         this.edorType = null;
/*      */       else {
/*  399 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  401 */       if (rs.getString("EdorCase") == null)
/*  402 */         this.edorCase = null;
/*      */       else {
/*  404 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  406 */       if (rs.getString("Operator2") == null)
/*  407 */         this.operator2 = null;
/*      */       else {
/*  409 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  411 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  412 */       if (rs.getString("MakeTime2") == null)
/*  413 */         this.makeTime2 = null;
/*      */       else {
/*  415 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*  417 */       if (rs.getString("OptionID") == null)
/*  418 */         this.optionID = null;
/*      */       else {
/*  420 */         this.optionID = rs.getString("OptionID").trim();
/*      */       }
/*  422 */       if (rs.getString("QuestionID") == null)
/*  423 */         this.questionID = null;
/*      */       else {
/*  425 */         this.questionID = rs.getString("QuestionID").trim();
/*      */       }
/*  427 */       if (rs.getString("Option") == null)
/*  428 */         this.option = null;
/*      */       else {
/*  430 */         this.option = rs.getString("Option").trim();
/*      */       }
/*  432 */       this.optionOrder = rs.getInt("OptionOrder");
/*  433 */       if (rs.getString("State") == null)
/*  434 */         this.state = null;
/*      */       else {
/*  436 */         this.state = rs.getString("State").trim();
/*      */       }
/*  438 */       if (rs.getString("VF01") == null)
/*  439 */         this.vF01 = null;
/*      */       else {
/*  441 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  443 */       if (rs.getString("NF01") == null)
/*  444 */         this.nF01 = null;
/*      */       else {
/*  446 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  448 */       this.iF01 = rs.getInt("IF01");
/*  449 */       this.dF02 = rs.getDouble("DF02");
/*  450 */       this.date01 = rs.getDate("Date01");
/*  451 */       if (rs.getString("ModifyOperator") == null)
/*  452 */         this.modifyOperator = null;
/*      */       else {
/*  454 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  456 */       if (rs.getString("Operator") == null)
/*  457 */         this.operator = null;
/*      */       else {
/*  459 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  461 */       this.makeDate = rs.getDate("MakeDate");
/*  462 */       if (rs.getString("MakeTime") == null)
/*  463 */         this.makeTime = null;
/*      */       else {
/*  465 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  467 */       this.modifyDate = rs.getDate("ModifyDate");
/*  468 */       if (rs.getString("ModifyTime") == null)
/*  469 */         this.modifyTime = null;
/*      */       else {
/*  471 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  476 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MInvOptionB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  478 */       CError tError = new CError();
/*  479 */       tError.moduleName = "MInvOptionBSchema";
/*  480 */       tError.functionName = "setSchema";
/*  481 */       tError.errorMessage = sqle.toString();
/*  482 */       this.mErrors.addOneError(tError);
/*  483 */       return false;
/*      */     }
/*  485 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvOptionBSchema getSchema()
/*      */   {
/*  490 */     MInvOptionBSchema aMInvOptionBSchema = new MInvOptionBSchema();
/*  491 */     aMInvOptionBSchema.setSchema(this);
/*  492 */     return aMInvOptionBSchema;
/*      */   }
/*      */ 
/*      */   public MInvOptionBDB getDB()
/*      */   {
/*  497 */     MInvOptionBDB aDBOper = new MInvOptionBDB();
/*  498 */     aDBOper.setSchema(this);
/*  499 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  506 */     StringBuffer strReturn = new StringBuffer(256);
/*  507 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  508 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  509 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  510 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  511 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  512 */     strReturn.append(StrTool.cTrim(this.makeTime2)); strReturn.append("|");
/*  513 */     strReturn.append(StrTool.cTrim(this.optionID)); strReturn.append("|");
/*  514 */     strReturn.append(StrTool.cTrim(this.questionID)); strReturn.append("|");
/*  515 */     strReturn.append(StrTool.cTrim(this.option)); strReturn.append("|");
/*  516 */     strReturn.append(ChgData.chgData(this.optionOrder)); strReturn.append("|");
/*  517 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  518 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  519 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  520 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  521 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  522 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  523 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  524 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  525 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  526 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  527 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  528 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  529 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  537 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  538 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  539 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  540 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  541 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/*  542 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  543 */       this.optionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  544 */       this.questionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  545 */       this.option = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  546 */       this.optionOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/*  547 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  548 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  549 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  550 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|"))).intValue();
/*  551 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).doubleValue();
/*  552 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  553 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  554 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  555 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
/*  556 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  557 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
/*  558 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  563 */       CError tError = new CError();
/*  564 */       tError.moduleName = "MInvOptionBSchema";
/*  565 */       tError.functionName = "decode";
/*  566 */       tError.errorMessage = ex.toString();
/*  567 */       this.mErrors.addOneError(tError);
/*      */ 
/*  569 */       return false;
/*      */     }
/*  571 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  577 */     String strReturn = "";
/*  578 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  580 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  582 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  584 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  586 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  588 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  590 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  592 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  594 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  596 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  598 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  600 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  602 */     if (FCode.equalsIgnoreCase("optionID"))
/*      */     {
/*  604 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.optionID));
/*      */     }
/*  606 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  608 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionID));
/*      */     }
/*  610 */     if (FCode.equalsIgnoreCase("option"))
/*      */     {
/*  612 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.option));
/*      */     }
/*  614 */     if (FCode.equalsIgnoreCase("optionOrder"))
/*      */     {
/*  616 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.optionOrder));
/*      */     }
/*  618 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  620 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  622 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  624 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  626 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  628 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  630 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  632 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  634 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  636 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  638 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  640 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  642 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  644 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  646 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  648 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  650 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  652 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  654 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  656 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  658 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  660 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  662 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  664 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  666 */     if (strReturn.equals(""))
/*      */     {
/*  668 */       strReturn = "null";
/*      */     }
/*      */ 
/*  671 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  678 */     String strFieldValue = "";
/*  679 */     switch (nFieldIndex) {
/*      */     case 0:
/*  681 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  682 */       break;
/*      */     case 1:
/*  684 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  685 */       break;
/*      */     case 2:
/*  687 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  688 */       break;
/*      */     case 3:
/*  690 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  691 */       break;
/*      */     case 4:
/*  693 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  694 */       break;
/*      */     case 5:
/*  696 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  697 */       break;
/*      */     case 6:
/*  699 */       strFieldValue = StrTool.GBKToUnicode(this.optionID);
/*  700 */       break;
/*      */     case 7:
/*  702 */       strFieldValue = StrTool.GBKToUnicode(this.questionID);
/*  703 */       break;
/*      */     case 8:
/*  705 */       strFieldValue = StrTool.GBKToUnicode(this.option);
/*  706 */       break;
/*      */     case 9:
/*  708 */       strFieldValue = String.valueOf(this.optionOrder);
/*  709 */       break;
/*      */     case 10:
/*  711 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  712 */       break;
/*      */     case 11:
/*  714 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  715 */       break;
/*      */     case 12:
/*  717 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  718 */       break;
/*      */     case 13:
/*  720 */       strFieldValue = String.valueOf(this.iF01);
/*  721 */       break;
/*      */     case 14:
/*  723 */       strFieldValue = String.valueOf(this.dF02);
/*  724 */       break;
/*      */     case 15:
/*  726 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  727 */       break;
/*      */     case 16:
/*  729 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  730 */       break;
/*      */     case 17:
/*  732 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  733 */       break;
/*      */     case 18:
/*  735 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  736 */       break;
/*      */     case 19:
/*  738 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  739 */       break;
/*      */     case 20:
/*  741 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  742 */       break;
/*      */     case 21:
/*  744 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  745 */       break;
/*      */     default:
/*  747 */       strFieldValue = "";
/*      */     }
/*  749 */     if (strFieldValue.equals("")) {
/*  750 */       strFieldValue = "null";
/*      */     }
/*  752 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  758 */     if (StrTool.cTrim(FCode).equals("")) {
/*  759 */       return false;
/*      */     }
/*  761 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  763 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  765 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/*  768 */         this.edorNo = null;
/*      */     }
/*  770 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  772 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  774 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/*  777 */         this.edorType = null;
/*      */     }
/*  779 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  781 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  783 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/*  786 */         this.edorCase = null;
/*      */     }
/*  788 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  790 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  792 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/*  795 */         this.operator2 = null;
/*      */     }
/*  797 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  799 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  801 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  804 */         this.makeDate2 = null;
/*      */     }
/*  806 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  808 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  810 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/*  813 */         this.makeTime2 = null;
/*      */     }
/*  815 */     if (FCode.equalsIgnoreCase("optionID"))
/*      */     {
/*  817 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  819 */         this.optionID = FValue.trim();
/*      */       }
/*      */       else
/*  822 */         this.optionID = null;
/*      */     }
/*  824 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  826 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  828 */         this.questionID = FValue.trim();
/*      */       }
/*      */       else
/*  831 */         this.questionID = null;
/*      */     }
/*  833 */     if (FCode.equalsIgnoreCase("option"))
/*      */     {
/*  835 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  837 */         this.option = FValue.trim();
/*      */       }
/*      */       else
/*  840 */         this.option = null;
/*      */     }
/*  842 */     if (FCode.equalsIgnoreCase("optionOrder"))
/*      */     {
/*  844 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  846 */         Integer tInteger = new Integer(FValue);
/*  847 */         int i = tInteger.intValue();
/*  848 */         this.optionOrder = i;
/*      */       }
/*      */     }
/*  851 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  853 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  855 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  858 */         this.state = null;
/*      */     }
/*  860 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  862 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  864 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/*  867 */         this.vF01 = null;
/*      */     }
/*  869 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  871 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  873 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/*  876 */         this.nF01 = null;
/*      */     }
/*  878 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  880 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  882 */         Integer tInteger = new Integer(FValue);
/*  883 */         int i = tInteger.intValue();
/*  884 */         this.iF01 = i;
/*      */       }
/*      */     }
/*  887 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  889 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  891 */         Double tDouble = new Double(FValue);
/*  892 */         double d = tDouble.doubleValue();
/*  893 */         this.dF02 = d;
/*      */       }
/*      */     }
/*  896 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  898 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  900 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  903 */         this.date01 = null;
/*      */     }
/*  905 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  907 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  909 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  912 */         this.modifyOperator = null;
/*      */     }
/*  914 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  916 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  918 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  921 */         this.operator = null;
/*      */     }
/*  923 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  925 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  927 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  930 */         this.makeDate = null;
/*      */     }
/*  932 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  934 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  936 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  939 */         this.makeTime = null;
/*      */     }
/*  941 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  943 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  945 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  948 */         this.modifyDate = null;
/*      */     }
/*  950 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  952 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  954 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  957 */         this.modifyTime = null;
/*      */     }
/*  959 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  964 */     if (otherObject == null) return false;
/*  965 */     if (this == otherObject) return true;
/*  966 */     if (getClass() != otherObject.getClass()) return false;
/*  967 */     MInvOptionBSchema other = (MInvOptionBSchema)otherObject;
/*  968 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/*  969 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/*  970 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/*  971 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/*  972 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/*  973 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/*  974 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/*  975 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/*  976 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/*  977 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/*  978 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/*  979 */     if ((this.makeTime2 != null) && (!this.makeTime2.equals(other.getMakeTime2()))) return false;
/*  980 */     if ((this.optionID == null) && (other.getOptionID() != null)) return false;
/*  981 */     if ((this.optionID != null) && (!this.optionID.equals(other.getOptionID()))) return false;
/*  982 */     if ((this.questionID == null) && (other.getQuestionID() != null)) return false;
/*  983 */     if ((this.questionID != null) && (!this.questionID.equals(other.getQuestionID()))) return false;
/*  984 */     if ((this.option == null) && (other.getOption() != null)) return false;
/*  985 */     if ((this.option != null) && (!this.option.equals(other.getOption()))) return false;
/*  986 */     if (this.optionOrder != other.getOptionOrder()) return false;
/*  987 */     if ((this.state == null) && (other.getState() != null)) return false;
/*  988 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/*  989 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/*  990 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/*  991 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/*  992 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/*  993 */     if (this.iF01 != other.getIF01()) return false;
/*  994 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/*  995 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/*  996 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/*  997 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/*  998 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/*  999 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1000 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1001 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1002 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1003 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1004 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1005 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1006 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1007 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1008 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1015 */     return 22;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1021 */     if (strFieldName.equals("edorNo")) {
/* 1022 */       return 0;
/*      */     }
/* 1024 */     if (strFieldName.equals("edorType")) {
/* 1025 */       return 1;
/*      */     }
/* 1027 */     if (strFieldName.equals("edorCase")) {
/* 1028 */       return 2;
/*      */     }
/* 1030 */     if (strFieldName.equals("operator2")) {
/* 1031 */       return 3;
/*      */     }
/* 1033 */     if (strFieldName.equals("makeDate2")) {
/* 1034 */       return 4;
/*      */     }
/* 1036 */     if (strFieldName.equals("makeTime2")) {
/* 1037 */       return 5;
/*      */     }
/* 1039 */     if (strFieldName.equals("optionID")) {
/* 1040 */       return 6;
/*      */     }
/* 1042 */     if (strFieldName.equals("questionID")) {
/* 1043 */       return 7;
/*      */     }
/* 1045 */     if (strFieldName.equals("option")) {
/* 1046 */       return 8;
/*      */     }
/* 1048 */     if (strFieldName.equals("optionOrder")) {
/* 1049 */       return 9;
/*      */     }
/* 1051 */     if (strFieldName.equals("state")) {
/* 1052 */       return 10;
/*      */     }
/* 1054 */     if (strFieldName.equals("vF01")) {
/* 1055 */       return 11;
/*      */     }
/* 1057 */     if (strFieldName.equals("nF01")) {
/* 1058 */       return 12;
/*      */     }
/* 1060 */     if (strFieldName.equals("iF01")) {
/* 1061 */       return 13;
/*      */     }
/* 1063 */     if (strFieldName.equals("dF02")) {
/* 1064 */       return 14;
/*      */     }
/* 1066 */     if (strFieldName.equals("date01")) {
/* 1067 */       return 15;
/*      */     }
/* 1069 */     if (strFieldName.equals("modifyOperator")) {
/* 1070 */       return 16;
/*      */     }
/* 1072 */     if (strFieldName.equals("operator")) {
/* 1073 */       return 17;
/*      */     }
/* 1075 */     if (strFieldName.equals("makeDate")) {
/* 1076 */       return 18;
/*      */     }
/* 1078 */     if (strFieldName.equals("makeTime")) {
/* 1079 */       return 19;
/*      */     }
/* 1081 */     if (strFieldName.equals("modifyDate")) {
/* 1082 */       return 20;
/*      */     }
/* 1084 */     if (strFieldName.equals("modifyTime")) {
/* 1085 */       return 21;
/*      */     }
/* 1087 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1093 */     String strFieldName = "";
/* 1094 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1096 */       strFieldName = "edorNo";
/* 1097 */       break;
/*      */     case 1:
/* 1099 */       strFieldName = "edorType";
/* 1100 */       break;
/*      */     case 2:
/* 1102 */       strFieldName = "edorCase";
/* 1103 */       break;
/*      */     case 3:
/* 1105 */       strFieldName = "operator2";
/* 1106 */       break;
/*      */     case 4:
/* 1108 */       strFieldName = "makeDate2";
/* 1109 */       break;
/*      */     case 5:
/* 1111 */       strFieldName = "makeTime2";
/* 1112 */       break;
/*      */     case 6:
/* 1114 */       strFieldName = "optionID";
/* 1115 */       break;
/*      */     case 7:
/* 1117 */       strFieldName = "questionID";
/* 1118 */       break;
/*      */     case 8:
/* 1120 */       strFieldName = "option";
/* 1121 */       break;
/*      */     case 9:
/* 1123 */       strFieldName = "optionOrder";
/* 1124 */       break;
/*      */     case 10:
/* 1126 */       strFieldName = "state";
/* 1127 */       break;
/*      */     case 11:
/* 1129 */       strFieldName = "vF01";
/* 1130 */       break;
/*      */     case 12:
/* 1132 */       strFieldName = "nF01";
/* 1133 */       break;
/*      */     case 13:
/* 1135 */       strFieldName = "iF01";
/* 1136 */       break;
/*      */     case 14:
/* 1138 */       strFieldName = "dF02";
/* 1139 */       break;
/*      */     case 15:
/* 1141 */       strFieldName = "date01";
/* 1142 */       break;
/*      */     case 16:
/* 1144 */       strFieldName = "modifyOperator";
/* 1145 */       break;
/*      */     case 17:
/* 1147 */       strFieldName = "operator";
/* 1148 */       break;
/*      */     case 18:
/* 1150 */       strFieldName = "makeDate";
/* 1151 */       break;
/*      */     case 19:
/* 1153 */       strFieldName = "makeTime";
/* 1154 */       break;
/*      */     case 20:
/* 1156 */       strFieldName = "modifyDate";
/* 1157 */       break;
/*      */     case 21:
/* 1159 */       strFieldName = "modifyTime";
/* 1160 */       break;
/*      */     default:
/* 1162 */       strFieldName = "";
/*      */     }
/* 1164 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1170 */     if (strFieldName.equals("edorNo")) {
/* 1171 */       return 0;
/*      */     }
/* 1173 */     if (strFieldName.equals("edorType")) {
/* 1174 */       return 0;
/*      */     }
/* 1176 */     if (strFieldName.equals("edorCase")) {
/* 1177 */       return 0;
/*      */     }
/* 1179 */     if (strFieldName.equals("operator2")) {
/* 1180 */       return 0;
/*      */     }
/* 1182 */     if (strFieldName.equals("makeDate2")) {
/* 1183 */       return 1;
/*      */     }
/* 1185 */     if (strFieldName.equals("makeTime2")) {
/* 1186 */       return 0;
/*      */     }
/* 1188 */     if (strFieldName.equals("optionID")) {
/* 1189 */       return 0;
/*      */     }
/* 1191 */     if (strFieldName.equals("questionID")) {
/* 1192 */       return 0;
/*      */     }
/* 1194 */     if (strFieldName.equals("option")) {
/* 1195 */       return 0;
/*      */     }
/* 1197 */     if (strFieldName.equals("optionOrder")) {
/* 1198 */       return 3;
/*      */     }
/* 1200 */     if (strFieldName.equals("state")) {
/* 1201 */       return 0;
/*      */     }
/* 1203 */     if (strFieldName.equals("vF01")) {
/* 1204 */       return 0;
/*      */     }
/* 1206 */     if (strFieldName.equals("nF01")) {
/* 1207 */       return 0;
/*      */     }
/* 1209 */     if (strFieldName.equals("iF01")) {
/* 1210 */       return 3;
/*      */     }
/* 1212 */     if (strFieldName.equals("dF02")) {
/* 1213 */       return 4;
/*      */     }
/* 1215 */     if (strFieldName.equals("date01")) {
/* 1216 */       return 1;
/*      */     }
/* 1218 */     if (strFieldName.equals("modifyOperator")) {
/* 1219 */       return 0;
/*      */     }
/* 1221 */     if (strFieldName.equals("operator")) {
/* 1222 */       return 0;
/*      */     }
/* 1224 */     if (strFieldName.equals("makeDate")) {
/* 1225 */       return 1;
/*      */     }
/* 1227 */     if (strFieldName.equals("makeTime")) {
/* 1228 */       return 0;
/*      */     }
/* 1230 */     if (strFieldName.equals("modifyDate")) {
/* 1231 */       return 1;
/*      */     }
/* 1233 */     if (strFieldName.equals("modifyTime")) {
/* 1234 */       return 0;
/*      */     }
/* 1236 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1242 */     int nFieldType = -1;
/* 1243 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1245 */       nFieldType = 0;
/* 1246 */       break;
/*      */     case 1:
/* 1248 */       nFieldType = 0;
/* 1249 */       break;
/*      */     case 2:
/* 1251 */       nFieldType = 0;
/* 1252 */       break;
/*      */     case 3:
/* 1254 */       nFieldType = 0;
/* 1255 */       break;
/*      */     case 4:
/* 1257 */       nFieldType = 1;
/* 1258 */       break;
/*      */     case 5:
/* 1260 */       nFieldType = 0;
/* 1261 */       break;
/*      */     case 6:
/* 1263 */       nFieldType = 0;
/* 1264 */       break;
/*      */     case 7:
/* 1266 */       nFieldType = 0;
/* 1267 */       break;
/*      */     case 8:
/* 1269 */       nFieldType = 0;
/* 1270 */       break;
/*      */     case 9:
/* 1272 */       nFieldType = 3;
/* 1273 */       break;
/*      */     case 10:
/* 1275 */       nFieldType = 0;
/* 1276 */       break;
/*      */     case 11:
/* 1278 */       nFieldType = 0;
/* 1279 */       break;
/*      */     case 12:
/* 1281 */       nFieldType = 0;
/* 1282 */       break;
/*      */     case 13:
/* 1284 */       nFieldType = 3;
/* 1285 */       break;
/*      */     case 14:
/* 1287 */       nFieldType = 4;
/* 1288 */       break;
/*      */     case 15:
/* 1290 */       nFieldType = 1;
/* 1291 */       break;
/*      */     case 16:
/* 1293 */       nFieldType = 0;
/* 1294 */       break;
/*      */     case 17:
/* 1296 */       nFieldType = 0;
/* 1297 */       break;
/*      */     case 18:
/* 1299 */       nFieldType = 1;
/* 1300 */       break;
/*      */     case 19:
/* 1302 */       nFieldType = 0;
/* 1303 */       break;
/*      */     case 20:
/* 1305 */       nFieldType = 1;
/* 1306 */       break;
/*      */     case 21:
/* 1308 */       nFieldType = 0;
/* 1309 */       break;
/*      */     default:
/* 1311 */       nFieldType = -1;
/*      */     }
/* 1313 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MInvOptionBSchema
 * JD-Core Version:    0.6.0
 */