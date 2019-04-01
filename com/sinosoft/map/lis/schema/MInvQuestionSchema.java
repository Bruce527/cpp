/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MInvQuestionDB;
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
/*      */ public class MInvQuestionSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String questionID;
/*      */   private String topicID;
/*      */   private String question;
/*      */   private String depiction;
/*      */   private String questionType;
/*      */   private int questionOrder;
/*      */   private String parentID;
/*      */   private String state;
/*      */   private String childFlag;
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
/*      */   public static final int FIELDNUM = 20;
/*      */   private static String[] PK;
/*   64 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MInvQuestionSchema()
/*      */   {
/*   71 */     this.mErrors = new CErrors();
/*      */ 
/*   73 */     String[] pk = new String[1];
/*   74 */     pk[0] = "QuestionID";
/*      */ 
/*   76 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   83 */     MInvQuestionSchema cloned = (MInvQuestionSchema)super.clone();
/*   84 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   85 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   86 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   92 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getQuestionID()
/*      */   {
/*   97 */     return this.questionID;
/*      */   }
/*      */ 
/*      */   public void setQuestionID(String aQuestionID) {
/*  101 */     this.questionID = aQuestionID;
/*      */   }
/*      */ 
/*      */   public String getTopicID() {
/*  105 */     return this.topicID;
/*      */   }
/*      */ 
/*      */   public void setTopicID(String aTopicID) {
/*  109 */     this.topicID = aTopicID;
/*      */   }
/*      */ 
/*      */   public String getQuestion() {
/*  113 */     return this.question;
/*      */   }
/*      */ 
/*      */   public void setQuestion(String aQuestion) {
/*  117 */     this.question = aQuestion;
/*      */   }
/*      */ 
/*      */   public String getDepiction() {
/*  121 */     return this.depiction;
/*      */   }
/*      */ 
/*      */   public void setDepiction(String aDepiction) {
/*  125 */     this.depiction = aDepiction;
/*      */   }
/*      */ 
/*      */   public String getQuestionType() {
/*  129 */     return this.questionType;
/*      */   }
/*      */ 
/*      */   public void setQuestionType(String aQuestionType) {
/*  133 */     this.questionType = aQuestionType;
/*      */   }
/*      */ 
/*      */   public int getQuestionOrder() {
/*  137 */     return this.questionOrder;
/*      */   }
/*      */ 
/*      */   public void setQuestionOrder(int aQuestionOrder) {
/*  141 */     this.questionOrder = aQuestionOrder;
/*      */   }
/*      */ 
/*      */   public void setQuestionOrder(String aQuestionOrder) {
/*  145 */     if ((aQuestionOrder != null) && (!aQuestionOrder.equals("")))
/*      */     {
/*  147 */       Integer tInteger = new Integer(aQuestionOrder);
/*  148 */       int i = tInteger.intValue();
/*  149 */       this.questionOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getParentID()
/*      */   {
/*  155 */     return this.parentID;
/*      */   }
/*      */ 
/*      */   public void setParentID(String aParentID) {
/*  159 */     this.parentID = aParentID;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  163 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  167 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getChildFlag() {
/*  171 */     return this.childFlag;
/*      */   }
/*      */ 
/*      */   public void setChildFlag(String aChildFlag) {
/*  175 */     this.childFlag = aChildFlag;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  179 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  183 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  187 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  191 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  195 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  199 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  203 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  205 */       Integer tInteger = new Integer(aIF01);
/*  206 */       int i = tInteger.intValue();
/*  207 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  213 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  217 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  221 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  223 */       Double tDouble = new Double(aDF02);
/*  224 */       double d = tDouble.doubleValue();
/*  225 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  231 */     if (this.date01 != null) {
/*  232 */       return this.fDate.getString(this.date01);
/*      */     }
/*  234 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  238 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  242 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  244 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  247 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  252 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  256 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  260 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  264 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  268 */     if (this.makeDate != null) {
/*  269 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  271 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  275 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  279 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  281 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  284 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  289 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  293 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  297 */     if (this.modifyDate != null) {
/*  298 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  300 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  304 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  308 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  310 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  313 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  318 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  322 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MInvQuestionSchema aMInvQuestionSchema)
/*      */   {
/*  328 */     this.questionID = aMInvQuestionSchema.getQuestionID();
/*  329 */     this.topicID = aMInvQuestionSchema.getTopicID();
/*  330 */     this.question = aMInvQuestionSchema.getQuestion();
/*  331 */     this.depiction = aMInvQuestionSchema.getDepiction();
/*  332 */     this.questionType = aMInvQuestionSchema.getQuestionType();
/*  333 */     this.questionOrder = aMInvQuestionSchema.getQuestionOrder();
/*  334 */     this.parentID = aMInvQuestionSchema.getParentID();
/*  335 */     this.state = aMInvQuestionSchema.getState();
/*  336 */     this.childFlag = aMInvQuestionSchema.getChildFlag();
/*  337 */     this.vF01 = aMInvQuestionSchema.getVF01();
/*  338 */     this.nF01 = aMInvQuestionSchema.getNF01();
/*  339 */     this.iF01 = aMInvQuestionSchema.getIF01();
/*  340 */     this.dF02 = aMInvQuestionSchema.getDF02();
/*  341 */     this.date01 = this.fDate.getDate(aMInvQuestionSchema.getDate01());
/*  342 */     this.modifyOperator = aMInvQuestionSchema.getModifyOperator();
/*  343 */     this.operator = aMInvQuestionSchema.getOperator();
/*  344 */     this.makeDate = this.fDate.getDate(aMInvQuestionSchema.getMakeDate());
/*  345 */     this.makeTime = aMInvQuestionSchema.getMakeTime();
/*  346 */     this.modifyDate = this.fDate.getDate(aMInvQuestionSchema.getModifyDate());
/*  347 */     this.modifyTime = aMInvQuestionSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  356 */       if (rs.getString("QuestionID") == null)
/*  357 */         this.questionID = null;
/*      */       else {
/*  359 */         this.questionID = rs.getString("QuestionID").trim();
/*      */       }
/*  361 */       if (rs.getString("TopicID") == null)
/*  362 */         this.topicID = null;
/*      */       else {
/*  364 */         this.topicID = rs.getString("TopicID").trim();
/*      */       }
/*  366 */       if (rs.getString("Question") == null)
/*  367 */         this.question = null;
/*      */       else {
/*  369 */         this.question = rs.getString("Question").trim();
/*      */       }
/*  371 */       if (rs.getString("Depiction") == null)
/*  372 */         this.depiction = null;
/*      */       else {
/*  374 */         this.depiction = rs.getString("Depiction").trim();
/*      */       }
/*  376 */       if (rs.getString("QuestionType") == null)
/*  377 */         this.questionType = null;
/*      */       else {
/*  379 */         this.questionType = rs.getString("QuestionType").trim();
/*      */       }
/*  381 */       this.questionOrder = rs.getInt("QuestionOrder");
/*  382 */       if (rs.getString("ParentID") == null)
/*  383 */         this.parentID = null;
/*      */       else {
/*  385 */         this.parentID = rs.getString("ParentID").trim();
/*      */       }
/*  387 */       if (rs.getString("State") == null)
/*  388 */         this.state = null;
/*      */       else {
/*  390 */         this.state = rs.getString("State").trim();
/*      */       }
/*  392 */       if (rs.getString("ChildFlag") == null)
/*  393 */         this.childFlag = null;
/*      */       else {
/*  395 */         this.childFlag = rs.getString("ChildFlag").trim();
/*      */       }
/*  397 */       if (rs.getString("VF01") == null)
/*  398 */         this.vF01 = null;
/*      */       else {
/*  400 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  402 */       if (rs.getString("NF01") == null)
/*  403 */         this.nF01 = null;
/*      */       else {
/*  405 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  407 */       this.iF01 = rs.getInt("IF01");
/*  408 */       this.dF02 = rs.getDouble("DF02");
/*  409 */       this.date01 = rs.getDate("Date01");
/*  410 */       if (rs.getString("ModifyOperator") == null)
/*  411 */         this.modifyOperator = null;
/*      */       else {
/*  413 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  415 */       if (rs.getString("Operator") == null)
/*  416 */         this.operator = null;
/*      */       else {
/*  418 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  420 */       this.makeDate = rs.getDate("MakeDate");
/*  421 */       if (rs.getString("MakeTime") == null)
/*  422 */         this.makeTime = null;
/*      */       else {
/*  424 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  426 */       this.modifyDate = rs.getDate("ModifyDate");
/*  427 */       if (rs.getString("ModifyTime") == null)
/*  428 */         this.modifyTime = null;
/*      */       else {
/*  430 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  435 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MInvQuestion\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  437 */       CError tError = new CError();
/*  438 */       tError.moduleName = "MInvQuestionSchema";
/*  439 */       tError.functionName = "setSchema";
/*  440 */       tError.errorMessage = sqle.toString();
/*  441 */       this.mErrors.addOneError(tError);
/*  442 */       return false;
/*      */     }
/*  444 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvQuestionSchema getSchema()
/*      */   {
/*  449 */     MInvQuestionSchema aMInvQuestionSchema = new MInvQuestionSchema();
/*  450 */     aMInvQuestionSchema.setSchema(this);
/*  451 */     return aMInvQuestionSchema;
/*      */   }
/*      */ 
/*      */   public MInvQuestionDB getDB()
/*      */   {
/*  456 */     MInvQuestionDB aDBOper = new MInvQuestionDB();
/*  457 */     aDBOper.setSchema(this);
/*  458 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  465 */     StringBuffer strReturn = new StringBuffer(256);
/*  466 */     strReturn.append(StrTool.cTrim(this.questionID)); strReturn.append("|");
/*  467 */     strReturn.append(StrTool.cTrim(this.topicID)); strReturn.append("|");
/*  468 */     strReturn.append(StrTool.cTrim(this.question)); strReturn.append("|");
/*  469 */     strReturn.append(StrTool.cTrim(this.depiction)); strReturn.append("|");
/*  470 */     strReturn.append(StrTool.cTrim(this.questionType)); strReturn.append("|");
/*  471 */     strReturn.append(ChgData.chgData(this.questionOrder)); strReturn.append("|");
/*  472 */     strReturn.append(StrTool.cTrim(this.parentID)); strReturn.append("|");
/*  473 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  474 */     strReturn.append(StrTool.cTrim(this.childFlag)); strReturn.append("|");
/*  475 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  476 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  477 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  478 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  479 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  480 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  481 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  482 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  483 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  484 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  485 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  486 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  494 */       this.questionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  495 */       this.topicID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  496 */       this.question = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  497 */       this.depiction = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  498 */       this.questionType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  499 */       this.questionOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/*  500 */       this.parentID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  501 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  502 */       this.childFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  503 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  504 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  505 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).intValue();
/*  506 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).doubleValue();
/*  507 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/*  508 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  509 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  510 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  511 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  512 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
/*  513 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  518 */       CError tError = new CError();
/*  519 */       tError.moduleName = "MInvQuestionSchema";
/*  520 */       tError.functionName = "decode";
/*  521 */       tError.errorMessage = ex.toString();
/*  522 */       this.mErrors.addOneError(tError);
/*      */ 
/*  524 */       return false;
/*      */     }
/*  526 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  532 */     String strReturn = "";
/*  533 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  535 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionID));
/*      */     }
/*  537 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/*  539 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.topicID));
/*      */     }
/*  541 */     if (FCode.equalsIgnoreCase("question"))
/*      */     {
/*  543 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.question));
/*      */     }
/*  545 */     if (FCode.equalsIgnoreCase("depiction"))
/*      */     {
/*  547 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.depiction));
/*      */     }
/*  549 */     if (FCode.equalsIgnoreCase("questionType"))
/*      */     {
/*  551 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionType));
/*      */     }
/*  553 */     if (FCode.equalsIgnoreCase("questionOrder"))
/*      */     {
/*  555 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionOrder));
/*      */     }
/*  557 */     if (FCode.equalsIgnoreCase("parentID"))
/*      */     {
/*  559 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.parentID));
/*      */     }
/*  561 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  563 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  565 */     if (FCode.equalsIgnoreCase("childFlag"))
/*      */     {
/*  567 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.childFlag));
/*      */     }
/*  569 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  571 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  573 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  575 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  577 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  579 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  581 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  583 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  585 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  587 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  589 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  591 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  593 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  595 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  597 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  599 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  601 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  603 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  605 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  607 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  609 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  611 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  613 */     if (strReturn.equals(""))
/*      */     {
/*  615 */       strReturn = "null";
/*      */     }
/*      */ 
/*  618 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  625 */     String strFieldValue = "";
/*  626 */     switch (nFieldIndex) {
/*      */     case 0:
/*  628 */       strFieldValue = StrTool.GBKToUnicode(this.questionID);
/*  629 */       break;
/*      */     case 1:
/*  631 */       strFieldValue = StrTool.GBKToUnicode(this.topicID);
/*  632 */       break;
/*      */     case 2:
/*  634 */       strFieldValue = StrTool.GBKToUnicode(this.question);
/*  635 */       break;
/*      */     case 3:
/*  637 */       strFieldValue = StrTool.GBKToUnicode(this.depiction);
/*  638 */       break;
/*      */     case 4:
/*  640 */       strFieldValue = StrTool.GBKToUnicode(this.questionType);
/*  641 */       break;
/*      */     case 5:
/*  643 */       strFieldValue = String.valueOf(this.questionOrder);
/*  644 */       break;
/*      */     case 6:
/*  646 */       strFieldValue = StrTool.GBKToUnicode(this.parentID);
/*  647 */       break;
/*      */     case 7:
/*  649 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  650 */       break;
/*      */     case 8:
/*  652 */       strFieldValue = StrTool.GBKToUnicode(this.childFlag);
/*  653 */       break;
/*      */     case 9:
/*  655 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  656 */       break;
/*      */     case 10:
/*  658 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  659 */       break;
/*      */     case 11:
/*  661 */       strFieldValue = String.valueOf(this.iF01);
/*  662 */       break;
/*      */     case 12:
/*  664 */       strFieldValue = String.valueOf(this.dF02);
/*  665 */       break;
/*      */     case 13:
/*  667 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  668 */       break;
/*      */     case 14:
/*  670 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  671 */       break;
/*      */     case 15:
/*  673 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  674 */       break;
/*      */     case 16:
/*  676 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  677 */       break;
/*      */     case 17:
/*  679 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  680 */       break;
/*      */     case 18:
/*  682 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  683 */       break;
/*      */     case 19:
/*  685 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  686 */       break;
/*      */     default:
/*  688 */       strFieldValue = "";
/*      */     }
/*  690 */     if (strFieldValue.equals("")) {
/*  691 */       strFieldValue = "null";
/*      */     }
/*  693 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  699 */     if (StrTool.cTrim(FCode).equals("")) {
/*  700 */       return false;
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  704 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  706 */         this.questionID = FValue.trim();
/*      */       }
/*      */       else
/*  709 */         this.questionID = null;
/*      */     }
/*  711 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/*  713 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  715 */         this.topicID = FValue.trim();
/*      */       }
/*      */       else
/*  718 */         this.topicID = null;
/*      */     }
/*  720 */     if (FCode.equalsIgnoreCase("question"))
/*      */     {
/*  722 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  724 */         this.question = FValue.trim();
/*      */       }
/*      */       else
/*  727 */         this.question = null;
/*      */     }
/*  729 */     if (FCode.equalsIgnoreCase("depiction"))
/*      */     {
/*  731 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  733 */         this.depiction = FValue.trim();
/*      */       }
/*      */       else
/*  736 */         this.depiction = null;
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("questionType"))
/*      */     {
/*  740 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  742 */         this.questionType = FValue.trim();
/*      */       }
/*      */       else
/*  745 */         this.questionType = null;
/*      */     }
/*  747 */     if (FCode.equalsIgnoreCase("questionOrder"))
/*      */     {
/*  749 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  751 */         Integer tInteger = new Integer(FValue);
/*  752 */         int i = tInteger.intValue();
/*  753 */         this.questionOrder = i;
/*      */       }
/*      */     }
/*  756 */     if (FCode.equalsIgnoreCase("parentID"))
/*      */     {
/*  758 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  760 */         this.parentID = FValue.trim();
/*      */       }
/*      */       else
/*  763 */         this.parentID = null;
/*      */     }
/*  765 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  767 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  769 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  772 */         this.state = null;
/*      */     }
/*  774 */     if (FCode.equalsIgnoreCase("childFlag"))
/*      */     {
/*  776 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  778 */         this.childFlag = FValue.trim();
/*      */       }
/*      */       else
/*  781 */         this.childFlag = null;
/*      */     }
/*  783 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  785 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  787 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/*  790 */         this.vF01 = null;
/*      */     }
/*  792 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  794 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  796 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/*  799 */         this.nF01 = null;
/*      */     }
/*  801 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  803 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  805 */         Integer tInteger = new Integer(FValue);
/*  806 */         int i = tInteger.intValue();
/*  807 */         this.iF01 = i;
/*      */       }
/*      */     }
/*  810 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  812 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  814 */         Double tDouble = new Double(FValue);
/*  815 */         double d = tDouble.doubleValue();
/*  816 */         this.dF02 = d;
/*      */       }
/*      */     }
/*  819 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  821 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  823 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  826 */         this.date01 = null;
/*      */     }
/*  828 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  830 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  832 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  835 */         this.modifyOperator = null;
/*      */     }
/*  837 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  839 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  841 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  844 */         this.operator = null;
/*      */     }
/*  846 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  848 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  850 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  853 */         this.makeDate = null;
/*      */     }
/*  855 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  857 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  859 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  862 */         this.makeTime = null;
/*      */     }
/*  864 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  866 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  868 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  871 */         this.modifyDate = null;
/*      */     }
/*  873 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  875 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  877 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  880 */         this.modifyTime = null;
/*      */     }
/*  882 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  887 */     if (otherObject == null) return false;
/*  888 */     if (this == otherObject) return true;
/*  889 */     if (getClass() != otherObject.getClass()) return false;
/*  890 */     MInvQuestionSchema other = (MInvQuestionSchema)otherObject;
/*  891 */     if ((this.questionID == null) && (other.getQuestionID() != null)) return false;
/*  892 */     if ((this.questionID != null) && (!this.questionID.equals(other.getQuestionID()))) return false;
/*  893 */     if ((this.topicID == null) && (other.getTopicID() != null)) return false;
/*  894 */     if ((this.topicID != null) && (!this.topicID.equals(other.getTopicID()))) return false;
/*  895 */     if ((this.question == null) && (other.getQuestion() != null)) return false;
/*  896 */     if ((this.question != null) && (!this.question.equals(other.getQuestion()))) return false;
/*  897 */     if ((this.depiction == null) && (other.getDepiction() != null)) return false;
/*  898 */     if ((this.depiction != null) && (!this.depiction.equals(other.getDepiction()))) return false;
/*  899 */     if ((this.questionType == null) && (other.getQuestionType() != null)) return false;
/*  900 */     if ((this.questionType != null) && (!this.questionType.equals(other.getQuestionType()))) return false;
/*  901 */     if (this.questionOrder != other.getQuestionOrder()) return false;
/*  902 */     if ((this.parentID == null) && (other.getParentID() != null)) return false;
/*  903 */     if ((this.parentID != null) && (!this.parentID.equals(other.getParentID()))) return false;
/*  904 */     if ((this.state == null) && (other.getState() != null)) return false;
/*  905 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/*  906 */     if ((this.childFlag == null) && (other.getChildFlag() != null)) return false;
/*  907 */     if ((this.childFlag != null) && (!this.childFlag.equals(other.getChildFlag()))) return false;
/*  908 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/*  909 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/*  910 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/*  911 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/*  912 */     if (this.iF01 != other.getIF01()) return false;
/*  913 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/*  914 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/*  915 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/*  916 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/*  917 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/*  918 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  919 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  920 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  921 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  922 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  923 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  924 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  925 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  926 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  927 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  934 */     return 20;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  940 */     if (strFieldName.equals("questionID")) {
/*  941 */       return 0;
/*      */     }
/*  943 */     if (strFieldName.equals("topicID")) {
/*  944 */       return 1;
/*      */     }
/*  946 */     if (strFieldName.equals("question")) {
/*  947 */       return 2;
/*      */     }
/*  949 */     if (strFieldName.equals("depiction")) {
/*  950 */       return 3;
/*      */     }
/*  952 */     if (strFieldName.equals("questionType")) {
/*  953 */       return 4;
/*      */     }
/*  955 */     if (strFieldName.equals("questionOrder")) {
/*  956 */       return 5;
/*      */     }
/*  958 */     if (strFieldName.equals("parentID")) {
/*  959 */       return 6;
/*      */     }
/*  961 */     if (strFieldName.equals("state")) {
/*  962 */       return 7;
/*      */     }
/*  964 */     if (strFieldName.equals("childFlag")) {
/*  965 */       return 8;
/*      */     }
/*  967 */     if (strFieldName.equals("vF01")) {
/*  968 */       return 9;
/*      */     }
/*  970 */     if (strFieldName.equals("nF01")) {
/*  971 */       return 10;
/*      */     }
/*  973 */     if (strFieldName.equals("iF01")) {
/*  974 */       return 11;
/*      */     }
/*  976 */     if (strFieldName.equals("dF02")) {
/*  977 */       return 12;
/*      */     }
/*  979 */     if (strFieldName.equals("date01")) {
/*  980 */       return 13;
/*      */     }
/*  982 */     if (strFieldName.equals("modifyOperator")) {
/*  983 */       return 14;
/*      */     }
/*  985 */     if (strFieldName.equals("operator")) {
/*  986 */       return 15;
/*      */     }
/*  988 */     if (strFieldName.equals("makeDate")) {
/*  989 */       return 16;
/*      */     }
/*  991 */     if (strFieldName.equals("makeTime")) {
/*  992 */       return 17;
/*      */     }
/*  994 */     if (strFieldName.equals("modifyDate")) {
/*  995 */       return 18;
/*      */     }
/*  997 */     if (strFieldName.equals("modifyTime")) {
/*  998 */       return 19;
/*      */     }
/* 1000 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1006 */     String strFieldName = "";
/* 1007 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1009 */       strFieldName = "questionID";
/* 1010 */       break;
/*      */     case 1:
/* 1012 */       strFieldName = "topicID";
/* 1013 */       break;
/*      */     case 2:
/* 1015 */       strFieldName = "question";
/* 1016 */       break;
/*      */     case 3:
/* 1018 */       strFieldName = "depiction";
/* 1019 */       break;
/*      */     case 4:
/* 1021 */       strFieldName = "questionType";
/* 1022 */       break;
/*      */     case 5:
/* 1024 */       strFieldName = "questionOrder";
/* 1025 */       break;
/*      */     case 6:
/* 1027 */       strFieldName = "parentID";
/* 1028 */       break;
/*      */     case 7:
/* 1030 */       strFieldName = "state";
/* 1031 */       break;
/*      */     case 8:
/* 1033 */       strFieldName = "childFlag";
/* 1034 */       break;
/*      */     case 9:
/* 1036 */       strFieldName = "vF01";
/* 1037 */       break;
/*      */     case 10:
/* 1039 */       strFieldName = "nF01";
/* 1040 */       break;
/*      */     case 11:
/* 1042 */       strFieldName = "iF01";
/* 1043 */       break;
/*      */     case 12:
/* 1045 */       strFieldName = "dF02";
/* 1046 */       break;
/*      */     case 13:
/* 1048 */       strFieldName = "date01";
/* 1049 */       break;
/*      */     case 14:
/* 1051 */       strFieldName = "modifyOperator";
/* 1052 */       break;
/*      */     case 15:
/* 1054 */       strFieldName = "operator";
/* 1055 */       break;
/*      */     case 16:
/* 1057 */       strFieldName = "makeDate";
/* 1058 */       break;
/*      */     case 17:
/* 1060 */       strFieldName = "makeTime";
/* 1061 */       break;
/*      */     case 18:
/* 1063 */       strFieldName = "modifyDate";
/* 1064 */       break;
/*      */     case 19:
/* 1066 */       strFieldName = "modifyTime";
/* 1067 */       break;
/*      */     default:
/* 1069 */       strFieldName = "";
/*      */     }
/* 1071 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1077 */     if (strFieldName.equals("questionID")) {
/* 1078 */       return 0;
/*      */     }
/* 1080 */     if (strFieldName.equals("topicID")) {
/* 1081 */       return 0;
/*      */     }
/* 1083 */     if (strFieldName.equals("question")) {
/* 1084 */       return 0;
/*      */     }
/* 1086 */     if (strFieldName.equals("depiction")) {
/* 1087 */       return 0;
/*      */     }
/* 1089 */     if (strFieldName.equals("questionType")) {
/* 1090 */       return 0;
/*      */     }
/* 1092 */     if (strFieldName.equals("questionOrder")) {
/* 1093 */       return 3;
/*      */     }
/* 1095 */     if (strFieldName.equals("parentID")) {
/* 1096 */       return 0;
/*      */     }
/* 1098 */     if (strFieldName.equals("state")) {
/* 1099 */       return 0;
/*      */     }
/* 1101 */     if (strFieldName.equals("childFlag")) {
/* 1102 */       return 0;
/*      */     }
/* 1104 */     if (strFieldName.equals("vF01")) {
/* 1105 */       return 0;
/*      */     }
/* 1107 */     if (strFieldName.equals("nF01")) {
/* 1108 */       return 0;
/*      */     }
/* 1110 */     if (strFieldName.equals("iF01")) {
/* 1111 */       return 3;
/*      */     }
/* 1113 */     if (strFieldName.equals("dF02")) {
/* 1114 */       return 4;
/*      */     }
/* 1116 */     if (strFieldName.equals("date01")) {
/* 1117 */       return 1;
/*      */     }
/* 1119 */     if (strFieldName.equals("modifyOperator")) {
/* 1120 */       return 0;
/*      */     }
/* 1122 */     if (strFieldName.equals("operator")) {
/* 1123 */       return 0;
/*      */     }
/* 1125 */     if (strFieldName.equals("makeDate")) {
/* 1126 */       return 1;
/*      */     }
/* 1128 */     if (strFieldName.equals("makeTime")) {
/* 1129 */       return 0;
/*      */     }
/* 1131 */     if (strFieldName.equals("modifyDate")) {
/* 1132 */       return 1;
/*      */     }
/* 1134 */     if (strFieldName.equals("modifyTime")) {
/* 1135 */       return 0;
/*      */     }
/* 1137 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1143 */     int nFieldType = -1;
/* 1144 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1146 */       nFieldType = 0;
/* 1147 */       break;
/*      */     case 1:
/* 1149 */       nFieldType = 0;
/* 1150 */       break;
/*      */     case 2:
/* 1152 */       nFieldType = 0;
/* 1153 */       break;
/*      */     case 3:
/* 1155 */       nFieldType = 0;
/* 1156 */       break;
/*      */     case 4:
/* 1158 */       nFieldType = 0;
/* 1159 */       break;
/*      */     case 5:
/* 1161 */       nFieldType = 3;
/* 1162 */       break;
/*      */     case 6:
/* 1164 */       nFieldType = 0;
/* 1165 */       break;
/*      */     case 7:
/* 1167 */       nFieldType = 0;
/* 1168 */       break;
/*      */     case 8:
/* 1170 */       nFieldType = 0;
/* 1171 */       break;
/*      */     case 9:
/* 1173 */       nFieldType = 0;
/* 1174 */       break;
/*      */     case 10:
/* 1176 */       nFieldType = 0;
/* 1177 */       break;
/*      */     case 11:
/* 1179 */       nFieldType = 3;
/* 1180 */       break;
/*      */     case 12:
/* 1182 */       nFieldType = 4;
/* 1183 */       break;
/*      */     case 13:
/* 1185 */       nFieldType = 1;
/* 1186 */       break;
/*      */     case 14:
/* 1188 */       nFieldType = 0;
/* 1189 */       break;
/*      */     case 15:
/* 1191 */       nFieldType = 0;
/* 1192 */       break;
/*      */     case 16:
/* 1194 */       nFieldType = 1;
/* 1195 */       break;
/*      */     case 17:
/* 1197 */       nFieldType = 0;
/* 1198 */       break;
/*      */     case 18:
/* 1200 */       nFieldType = 1;
/* 1201 */       break;
/*      */     case 19:
/* 1203 */       nFieldType = 0;
/* 1204 */       break;
/*      */     default:
/* 1206 */       nFieldType = -1;
/*      */     }
/* 1208 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MInvQuestionSchema
 * JD-Core Version:    0.6.0
 */