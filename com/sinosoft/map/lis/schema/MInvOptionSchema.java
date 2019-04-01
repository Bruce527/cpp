/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MInvOptionDB;
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
/*      */ public class MInvOptionSchema
/*      */   implements Schema, Cloneable
/*      */ {
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
/*      */   public static final int FIELDNUM = 16;
/*      */   private static String[] PK;
/*   56 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MInvOptionSchema()
/*      */   {
/*   63 */     this.mErrors = new CErrors();
/*      */ 
/*   65 */     String[] pk = new String[1];
/*   66 */     pk[0] = "OptionID";
/*      */ 
/*   68 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   75 */     MInvOptionSchema cloned = (MInvOptionSchema)super.clone();
/*   76 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   77 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   78 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   84 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getOptionID()
/*      */   {
/*   89 */     return this.optionID;
/*      */   }
/*      */ 
/*      */   public void setOptionID(String aOptionID) {
/*   93 */     this.optionID = aOptionID;
/*      */   }
/*      */ 
/*      */   public String getQuestionID() {
/*   97 */     return this.questionID;
/*      */   }
/*      */ 
/*      */   public void setQuestionID(String aQuestionID) {
/*  101 */     this.questionID = aQuestionID;
/*      */   }
/*      */ 
/*      */   public String getOption() {
/*  105 */     return this.option;
/*      */   }
/*      */ 
/*      */   public void setOption(String aOption) {
/*  109 */     this.option = aOption;
/*      */   }
/*      */ 
/*      */   public int getOptionOrder() {
/*  113 */     return this.optionOrder;
/*      */   }
/*      */ 
/*      */   public void setOptionOrder(int aOptionOrder) {
/*  117 */     this.optionOrder = aOptionOrder;
/*      */   }
/*      */ 
/*      */   public void setOptionOrder(String aOptionOrder) {
/*  121 */     if ((aOptionOrder != null) && (!aOptionOrder.equals("")))
/*      */     {
/*  123 */       Integer tInteger = new Integer(aOptionOrder);
/*  124 */       int i = tInteger.intValue();
/*  125 */       this.optionOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getState()
/*      */   {
/*  131 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  135 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  139 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  143 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  147 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  151 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  155 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  159 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  163 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  165 */       Integer tInteger = new Integer(aIF01);
/*  166 */       int i = tInteger.intValue();
/*  167 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  173 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  177 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  181 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  183 */       Double tDouble = new Double(aDF02);
/*  184 */       double d = tDouble.doubleValue();
/*  185 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  191 */     if (this.date01 != null) {
/*  192 */       return this.fDate.getString(this.date01);
/*      */     }
/*  194 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  198 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  202 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  204 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  207 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  212 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  216 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  220 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  224 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  228 */     if (this.makeDate != null) {
/*  229 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  231 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  235 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  239 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  241 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  244 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  249 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  253 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  257 */     if (this.modifyDate != null) {
/*  258 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  260 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  264 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  268 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  270 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  273 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  278 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  282 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MInvOptionSchema aMInvOptionSchema)
/*      */   {
/*  288 */     this.optionID = aMInvOptionSchema.getOptionID();
/*  289 */     this.questionID = aMInvOptionSchema.getQuestionID();
/*  290 */     this.option = aMInvOptionSchema.getOption();
/*  291 */     this.optionOrder = aMInvOptionSchema.getOptionOrder();
/*  292 */     this.state = aMInvOptionSchema.getState();
/*  293 */     this.vF01 = aMInvOptionSchema.getVF01();
/*  294 */     this.nF01 = aMInvOptionSchema.getNF01();
/*  295 */     this.iF01 = aMInvOptionSchema.getIF01();
/*  296 */     this.dF02 = aMInvOptionSchema.getDF02();
/*  297 */     this.date01 = this.fDate.getDate(aMInvOptionSchema.getDate01());
/*  298 */     this.modifyOperator = aMInvOptionSchema.getModifyOperator();
/*  299 */     this.operator = aMInvOptionSchema.getOperator();
/*  300 */     this.makeDate = this.fDate.getDate(aMInvOptionSchema.getMakeDate());
/*  301 */     this.makeTime = aMInvOptionSchema.getMakeTime();
/*  302 */     this.modifyDate = this.fDate.getDate(aMInvOptionSchema.getModifyDate());
/*  303 */     this.modifyTime = aMInvOptionSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  312 */       if (rs.getString("OptionID") == null)
/*  313 */         this.optionID = null;
/*      */       else {
/*  315 */         this.optionID = rs.getString("OptionID").trim();
/*      */       }
/*  317 */       if (rs.getString("QuestionID") == null)
/*  318 */         this.questionID = null;
/*      */       else {
/*  320 */         this.questionID = rs.getString("QuestionID").trim();
/*      */       }
/*  322 */       if (rs.getString("Option") == null)
/*  323 */         this.option = null;
/*      */       else {
/*  325 */         this.option = rs.getString("Option").trim();
/*      */       }
/*  327 */       this.optionOrder = rs.getInt("OptionOrder");
/*  328 */       if (rs.getString("State") == null)
/*  329 */         this.state = null;
/*      */       else {
/*  331 */         this.state = rs.getString("State").trim();
/*      */       }
/*  333 */       if (rs.getString("VF01") == null)
/*  334 */         this.vF01 = null;
/*      */       else {
/*  336 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  338 */       if (rs.getString("NF01") == null)
/*  339 */         this.nF01 = null;
/*      */       else {
/*  341 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  343 */       this.iF01 = rs.getInt("IF01");
/*  344 */       this.dF02 = rs.getDouble("DF02");
/*  345 */       this.date01 = rs.getDate("Date01");
/*  346 */       if (rs.getString("ModifyOperator") == null)
/*  347 */         this.modifyOperator = null;
/*      */       else {
/*  349 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  351 */       if (rs.getString("Operator") == null)
/*  352 */         this.operator = null;
/*      */       else {
/*  354 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  356 */       this.makeDate = rs.getDate("MakeDate");
/*  357 */       if (rs.getString("MakeTime") == null)
/*  358 */         this.makeTime = null;
/*      */       else {
/*  360 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  362 */       this.modifyDate = rs.getDate("ModifyDate");
/*  363 */       if (rs.getString("ModifyTime") == null)
/*  364 */         this.modifyTime = null;
/*      */       else {
/*  366 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  371 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MInvOption\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  373 */       CError tError = new CError();
/*  374 */       tError.moduleName = "MInvOptionSchema";
/*  375 */       tError.functionName = "setSchema";
/*  376 */       tError.errorMessage = sqle.toString();
/*  377 */       this.mErrors.addOneError(tError);
/*  378 */       return false;
/*      */     }
/*  380 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvOptionSchema getSchema()
/*      */   {
/*  385 */     MInvOptionSchema aMInvOptionSchema = new MInvOptionSchema();
/*  386 */     aMInvOptionSchema.setSchema(this);
/*  387 */     return aMInvOptionSchema;
/*      */   }
/*      */ 
/*      */   public MInvOptionDB getDB()
/*      */   {
/*  392 */     MInvOptionDB aDBOper = new MInvOptionDB();
/*  393 */     aDBOper.setSchema(this);
/*  394 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  401 */     StringBuffer strReturn = new StringBuffer(256);
/*  402 */     strReturn.append(StrTool.cTrim(this.optionID)); strReturn.append("|");
/*  403 */     strReturn.append(StrTool.cTrim(this.questionID)); strReturn.append("|");
/*  404 */     strReturn.append(StrTool.cTrim(this.option)); strReturn.append("|");
/*  405 */     strReturn.append(ChgData.chgData(this.optionOrder)); strReturn.append("|");
/*  406 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  407 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  408 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  409 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  410 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  411 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  412 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  413 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  414 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  415 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  416 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  417 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  418 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  426 */       this.optionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  427 */       this.questionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  428 */       this.option = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  429 */       this.optionOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|"))).intValue();
/*  430 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  431 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  432 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  433 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).intValue();
/*  434 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).doubleValue();
/*  435 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*  436 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  437 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  438 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
/*  439 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  440 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  441 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  446 */       CError tError = new CError();
/*  447 */       tError.moduleName = "MInvOptionSchema";
/*  448 */       tError.functionName = "decode";
/*  449 */       tError.errorMessage = ex.toString();
/*  450 */       this.mErrors.addOneError(tError);
/*      */ 
/*  452 */       return false;
/*      */     }
/*  454 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  460 */     String strReturn = "";
/*  461 */     if (FCode.equalsIgnoreCase("optionID"))
/*      */     {
/*  463 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.optionID));
/*      */     }
/*  465 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  467 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionID));
/*      */     }
/*  469 */     if (FCode.equalsIgnoreCase("option"))
/*      */     {
/*  471 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.option));
/*      */     }
/*  473 */     if (FCode.equalsIgnoreCase("optionOrder"))
/*      */     {
/*  475 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.optionOrder));
/*      */     }
/*  477 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  479 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  481 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  483 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  485 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  487 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  489 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  491 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  493 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  495 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  497 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  499 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  501 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  503 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  505 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  507 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  509 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  511 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  513 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  515 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  517 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  519 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  521 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  523 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  525 */     if (strReturn.equals(""))
/*      */     {
/*  527 */       strReturn = "null";
/*      */     }
/*      */ 
/*  530 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  537 */     String strFieldValue = "";
/*  538 */     switch (nFieldIndex) {
/*      */     case 0:
/*  540 */       strFieldValue = StrTool.GBKToUnicode(this.optionID);
/*  541 */       break;
/*      */     case 1:
/*  543 */       strFieldValue = StrTool.GBKToUnicode(this.questionID);
/*  544 */       break;
/*      */     case 2:
/*  546 */       strFieldValue = StrTool.GBKToUnicode(this.option);
/*  547 */       break;
/*      */     case 3:
/*  549 */       strFieldValue = String.valueOf(this.optionOrder);
/*  550 */       break;
/*      */     case 4:
/*  552 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  553 */       break;
/*      */     case 5:
/*  555 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  556 */       break;
/*      */     case 6:
/*  558 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  559 */       break;
/*      */     case 7:
/*  561 */       strFieldValue = String.valueOf(this.iF01);
/*  562 */       break;
/*      */     case 8:
/*  564 */       strFieldValue = String.valueOf(this.dF02);
/*  565 */       break;
/*      */     case 9:
/*  567 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  568 */       break;
/*      */     case 10:
/*  570 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  571 */       break;
/*      */     case 11:
/*  573 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  574 */       break;
/*      */     case 12:
/*  576 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  577 */       break;
/*      */     case 13:
/*  579 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  580 */       break;
/*      */     case 14:
/*  582 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  583 */       break;
/*      */     case 15:
/*  585 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  586 */       break;
/*      */     default:
/*  588 */       strFieldValue = "";
/*      */     }
/*  590 */     if (strFieldValue.equals("")) {
/*  591 */       strFieldValue = "null";
/*      */     }
/*  593 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  599 */     if (StrTool.cTrim(FCode).equals("")) {
/*  600 */       return false;
/*      */     }
/*  602 */     if (FCode.equalsIgnoreCase("optionID"))
/*      */     {
/*  604 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  606 */         this.optionID = FValue.trim();
/*      */       }
/*      */       else
/*  609 */         this.optionID = null;
/*      */     }
/*  611 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  613 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  615 */         this.questionID = FValue.trim();
/*      */       }
/*      */       else
/*  618 */         this.questionID = null;
/*      */     }
/*  620 */     if (FCode.equalsIgnoreCase("option"))
/*      */     {
/*  622 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  624 */         this.option = FValue.trim();
/*      */       }
/*      */       else
/*  627 */         this.option = null;
/*      */     }
/*  629 */     if (FCode.equalsIgnoreCase("optionOrder"))
/*      */     {
/*  631 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  633 */         Integer tInteger = new Integer(FValue);
/*  634 */         int i = tInteger.intValue();
/*  635 */         this.optionOrder = i;
/*      */       }
/*      */     }
/*  638 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  640 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  642 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  645 */         this.state = null;
/*      */     }
/*  647 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  649 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  651 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/*  654 */         this.vF01 = null;
/*      */     }
/*  656 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  658 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  660 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/*  663 */         this.nF01 = null;
/*      */     }
/*  665 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  667 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  669 */         Integer tInteger = new Integer(FValue);
/*  670 */         int i = tInteger.intValue();
/*  671 */         this.iF01 = i;
/*      */       }
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  676 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  678 */         Double tDouble = new Double(FValue);
/*  679 */         double d = tDouble.doubleValue();
/*  680 */         this.dF02 = d;
/*      */       }
/*      */     }
/*  683 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  685 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  687 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  690 */         this.date01 = null;
/*      */     }
/*  692 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  694 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  696 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  699 */         this.modifyOperator = null;
/*      */     }
/*  701 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  703 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  705 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  708 */         this.operator = null;
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  712 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  714 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  717 */         this.makeDate = null;
/*      */     }
/*  719 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  721 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  723 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  726 */         this.makeTime = null;
/*      */     }
/*  728 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  730 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  732 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  735 */         this.modifyDate = null;
/*      */     }
/*  737 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  739 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  741 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  744 */         this.modifyTime = null;
/*      */     }
/*  746 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  751 */     if (otherObject == null) return false;
/*  752 */     if (this == otherObject) return true;
/*  753 */     if (getClass() != otherObject.getClass()) return false;
/*  754 */     MInvOptionSchema other = (MInvOptionSchema)otherObject;
/*  755 */     if ((this.optionID == null) && (other.getOptionID() != null)) return false;
/*  756 */     if ((this.optionID != null) && (!this.optionID.equals(other.getOptionID()))) return false;
/*  757 */     if ((this.questionID == null) && (other.getQuestionID() != null)) return false;
/*  758 */     if ((this.questionID != null) && (!this.questionID.equals(other.getQuestionID()))) return false;
/*  759 */     if ((this.option == null) && (other.getOption() != null)) return false;
/*  760 */     if ((this.option != null) && (!this.option.equals(other.getOption()))) return false;
/*  761 */     if (this.optionOrder != other.getOptionOrder()) return false;
/*  762 */     if ((this.state == null) && (other.getState() != null)) return false;
/*  763 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/*  764 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/*  765 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/*  766 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/*  767 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/*  768 */     if (this.iF01 != other.getIF01()) return false;
/*  769 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/*  770 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/*  771 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/*  772 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/*  773 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/*  774 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  775 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  776 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  777 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  778 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  779 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  780 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  781 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  782 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  783 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  790 */     return 16;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  796 */     if (strFieldName.equals("optionID")) {
/*  797 */       return 0;
/*      */     }
/*  799 */     if (strFieldName.equals("questionID")) {
/*  800 */       return 1;
/*      */     }
/*  802 */     if (strFieldName.equals("option")) {
/*  803 */       return 2;
/*      */     }
/*  805 */     if (strFieldName.equals("optionOrder")) {
/*  806 */       return 3;
/*      */     }
/*  808 */     if (strFieldName.equals("state")) {
/*  809 */       return 4;
/*      */     }
/*  811 */     if (strFieldName.equals("vF01")) {
/*  812 */       return 5;
/*      */     }
/*  814 */     if (strFieldName.equals("nF01")) {
/*  815 */       return 6;
/*      */     }
/*  817 */     if (strFieldName.equals("iF01")) {
/*  818 */       return 7;
/*      */     }
/*  820 */     if (strFieldName.equals("dF02")) {
/*  821 */       return 8;
/*      */     }
/*  823 */     if (strFieldName.equals("date01")) {
/*  824 */       return 9;
/*      */     }
/*  826 */     if (strFieldName.equals("modifyOperator")) {
/*  827 */       return 10;
/*      */     }
/*  829 */     if (strFieldName.equals("operator")) {
/*  830 */       return 11;
/*      */     }
/*  832 */     if (strFieldName.equals("makeDate")) {
/*  833 */       return 12;
/*      */     }
/*  835 */     if (strFieldName.equals("makeTime")) {
/*  836 */       return 13;
/*      */     }
/*  838 */     if (strFieldName.equals("modifyDate")) {
/*  839 */       return 14;
/*      */     }
/*  841 */     if (strFieldName.equals("modifyTime")) {
/*  842 */       return 15;
/*      */     }
/*  844 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  850 */     String strFieldName = "";
/*  851 */     switch (nFieldIndex) {
/*      */     case 0:
/*  853 */       strFieldName = "optionID";
/*  854 */       break;
/*      */     case 1:
/*  856 */       strFieldName = "questionID";
/*  857 */       break;
/*      */     case 2:
/*  859 */       strFieldName = "option";
/*  860 */       break;
/*      */     case 3:
/*  862 */       strFieldName = "optionOrder";
/*  863 */       break;
/*      */     case 4:
/*  865 */       strFieldName = "state";
/*  866 */       break;
/*      */     case 5:
/*  868 */       strFieldName = "vF01";
/*  869 */       break;
/*      */     case 6:
/*  871 */       strFieldName = "nF01";
/*  872 */       break;
/*      */     case 7:
/*  874 */       strFieldName = "iF01";
/*  875 */       break;
/*      */     case 8:
/*  877 */       strFieldName = "dF02";
/*  878 */       break;
/*      */     case 9:
/*  880 */       strFieldName = "date01";
/*  881 */       break;
/*      */     case 10:
/*  883 */       strFieldName = "modifyOperator";
/*  884 */       break;
/*      */     case 11:
/*  886 */       strFieldName = "operator";
/*  887 */       break;
/*      */     case 12:
/*  889 */       strFieldName = "makeDate";
/*  890 */       break;
/*      */     case 13:
/*  892 */       strFieldName = "makeTime";
/*  893 */       break;
/*      */     case 14:
/*  895 */       strFieldName = "modifyDate";
/*  896 */       break;
/*      */     case 15:
/*  898 */       strFieldName = "modifyTime";
/*  899 */       break;
/*      */     default:
/*  901 */       strFieldName = "";
/*      */     }
/*  903 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  909 */     if (strFieldName.equals("optionID")) {
/*  910 */       return 0;
/*      */     }
/*  912 */     if (strFieldName.equals("questionID")) {
/*  913 */       return 0;
/*      */     }
/*  915 */     if (strFieldName.equals("option")) {
/*  916 */       return 0;
/*      */     }
/*  918 */     if (strFieldName.equals("optionOrder")) {
/*  919 */       return 3;
/*      */     }
/*  921 */     if (strFieldName.equals("state")) {
/*  922 */       return 0;
/*      */     }
/*  924 */     if (strFieldName.equals("vF01")) {
/*  925 */       return 0;
/*      */     }
/*  927 */     if (strFieldName.equals("nF01")) {
/*  928 */       return 0;
/*      */     }
/*  930 */     if (strFieldName.equals("iF01")) {
/*  931 */       return 3;
/*      */     }
/*  933 */     if (strFieldName.equals("dF02")) {
/*  934 */       return 4;
/*      */     }
/*  936 */     if (strFieldName.equals("date01")) {
/*  937 */       return 1;
/*      */     }
/*  939 */     if (strFieldName.equals("modifyOperator")) {
/*  940 */       return 0;
/*      */     }
/*  942 */     if (strFieldName.equals("operator")) {
/*  943 */       return 0;
/*      */     }
/*  945 */     if (strFieldName.equals("makeDate")) {
/*  946 */       return 1;
/*      */     }
/*  948 */     if (strFieldName.equals("makeTime")) {
/*  949 */       return 0;
/*      */     }
/*  951 */     if (strFieldName.equals("modifyDate")) {
/*  952 */       return 1;
/*      */     }
/*  954 */     if (strFieldName.equals("modifyTime")) {
/*  955 */       return 0;
/*      */     }
/*  957 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/*  963 */     int nFieldType = -1;
/*  964 */     switch (nFieldIndex) {
/*      */     case 0:
/*  966 */       nFieldType = 0;
/*  967 */       break;
/*      */     case 1:
/*  969 */       nFieldType = 0;
/*  970 */       break;
/*      */     case 2:
/*  972 */       nFieldType = 0;
/*  973 */       break;
/*      */     case 3:
/*  975 */       nFieldType = 3;
/*  976 */       break;
/*      */     case 4:
/*  978 */       nFieldType = 0;
/*  979 */       break;
/*      */     case 5:
/*  981 */       nFieldType = 0;
/*  982 */       break;
/*      */     case 6:
/*  984 */       nFieldType = 0;
/*  985 */       break;
/*      */     case 7:
/*  987 */       nFieldType = 3;
/*  988 */       break;
/*      */     case 8:
/*  990 */       nFieldType = 4;
/*  991 */       break;
/*      */     case 9:
/*  993 */       nFieldType = 1;
/*  994 */       break;
/*      */     case 10:
/*  996 */       nFieldType = 0;
/*  997 */       break;
/*      */     case 11:
/*  999 */       nFieldType = 0;
/* 1000 */       break;
/*      */     case 12:
/* 1002 */       nFieldType = 1;
/* 1003 */       break;
/*      */     case 13:
/* 1005 */       nFieldType = 0;
/* 1006 */       break;
/*      */     case 14:
/* 1008 */       nFieldType = 1;
/* 1009 */       break;
/*      */     case 15:
/* 1011 */       nFieldType = 0;
/* 1012 */       break;
/*      */     default:
/* 1014 */       nFieldType = -1;
/*      */     }
/* 1016 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MInvOptionSchema
 * JD-Core Version:    0.6.0
 */