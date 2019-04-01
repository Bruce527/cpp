/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MInvQuestionBDB;
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
/*      */ public class MInvQuestionBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
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
/*      */   public static final int FIELDNUM = 26;
/*      */   private static String[] PK;
/*   76 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MInvQuestionBSchema()
/*      */   {
/*   83 */     this.mErrors = new CErrors();
/*      */ 
/*   85 */     String[] pk = new String[1];
/*   86 */     pk[0] = "EdorNo";
/*      */ 
/*   88 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   95 */     MInvQuestionBSchema cloned = (MInvQuestionBSchema)super.clone();
/*   96 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   97 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   98 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  104 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  109 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  113 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  117 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  121 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  125 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  129 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  133 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  137 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  141 */     if (this.makeDate2 != null) {
/*  142 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  144 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  148 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  152 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  154 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  157 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  162 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  166 */     this.makeTime2 = aMakeTime2;
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
/*      */   public String getTopicID() {
/*  178 */     return this.topicID;
/*      */   }
/*      */ 
/*      */   public void setTopicID(String aTopicID) {
/*  182 */     this.topicID = aTopicID;
/*      */   }
/*      */ 
/*      */   public String getQuestion() {
/*  186 */     return this.question;
/*      */   }
/*      */ 
/*      */   public void setQuestion(String aQuestion) {
/*  190 */     this.question = aQuestion;
/*      */   }
/*      */ 
/*      */   public String getDepiction() {
/*  194 */     return this.depiction;
/*      */   }
/*      */ 
/*      */   public void setDepiction(String aDepiction) {
/*  198 */     this.depiction = aDepiction;
/*      */   }
/*      */ 
/*      */   public String getQuestionType() {
/*  202 */     return this.questionType;
/*      */   }
/*      */ 
/*      */   public void setQuestionType(String aQuestionType) {
/*  206 */     this.questionType = aQuestionType;
/*      */   }
/*      */ 
/*      */   public int getQuestionOrder() {
/*  210 */     return this.questionOrder;
/*      */   }
/*      */ 
/*      */   public void setQuestionOrder(int aQuestionOrder) {
/*  214 */     this.questionOrder = aQuestionOrder;
/*      */   }
/*      */ 
/*      */   public void setQuestionOrder(String aQuestionOrder) {
/*  218 */     if ((aQuestionOrder != null) && (!aQuestionOrder.equals("")))
/*      */     {
/*  220 */       Integer tInteger = new Integer(aQuestionOrder);
/*  221 */       int i = tInteger.intValue();
/*  222 */       this.questionOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getParentID()
/*      */   {
/*  228 */     return this.parentID;
/*      */   }
/*      */ 
/*      */   public void setParentID(String aParentID) {
/*  232 */     this.parentID = aParentID;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  236 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  240 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getChildFlag() {
/*  244 */     return this.childFlag;
/*      */   }
/*      */ 
/*      */   public void setChildFlag(String aChildFlag) {
/*  248 */     this.childFlag = aChildFlag;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  252 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  256 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  260 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  264 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  268 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  272 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  276 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  278 */       Integer tInteger = new Integer(aIF01);
/*  279 */       int i = tInteger.intValue();
/*  280 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  286 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  290 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  294 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  296 */       Double tDouble = new Double(aDF02);
/*  297 */       double d = tDouble.doubleValue();
/*  298 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  304 */     if (this.date01 != null) {
/*  305 */       return this.fDate.getString(this.date01);
/*      */     }
/*  307 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  311 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  315 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  317 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  320 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  325 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  329 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  333 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  337 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  341 */     if (this.makeDate != null) {
/*  342 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  344 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  348 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  352 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  354 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  357 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  362 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  366 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  370 */     if (this.modifyDate != null) {
/*  371 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  373 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  377 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  381 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  383 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  386 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  391 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  395 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MInvQuestionBSchema aMInvQuestionBSchema)
/*      */   {
/*  401 */     this.edorNo = aMInvQuestionBSchema.getEdorNo();
/*  402 */     this.edorType = aMInvQuestionBSchema.getEdorType();
/*  403 */     this.edorCase = aMInvQuestionBSchema.getEdorCase();
/*  404 */     this.operator2 = aMInvQuestionBSchema.getOperator2();
/*  405 */     this.makeDate2 = this.fDate.getDate(aMInvQuestionBSchema.getMakeDate2());
/*  406 */     this.makeTime2 = aMInvQuestionBSchema.getMakeTime2();
/*  407 */     this.questionID = aMInvQuestionBSchema.getQuestionID();
/*  408 */     this.topicID = aMInvQuestionBSchema.getTopicID();
/*  409 */     this.question = aMInvQuestionBSchema.getQuestion();
/*  410 */     this.depiction = aMInvQuestionBSchema.getDepiction();
/*  411 */     this.questionType = aMInvQuestionBSchema.getQuestionType();
/*  412 */     this.questionOrder = aMInvQuestionBSchema.getQuestionOrder();
/*  413 */     this.parentID = aMInvQuestionBSchema.getParentID();
/*  414 */     this.state = aMInvQuestionBSchema.getState();
/*  415 */     this.childFlag = aMInvQuestionBSchema.getChildFlag();
/*  416 */     this.vF01 = aMInvQuestionBSchema.getVF01();
/*  417 */     this.nF01 = aMInvQuestionBSchema.getNF01();
/*  418 */     this.iF01 = aMInvQuestionBSchema.getIF01();
/*  419 */     this.dF02 = aMInvQuestionBSchema.getDF02();
/*  420 */     this.date01 = this.fDate.getDate(aMInvQuestionBSchema.getDate01());
/*  421 */     this.modifyOperator = aMInvQuestionBSchema.getModifyOperator();
/*  422 */     this.operator = aMInvQuestionBSchema.getOperator();
/*  423 */     this.makeDate = this.fDate.getDate(aMInvQuestionBSchema.getMakeDate());
/*  424 */     this.makeTime = aMInvQuestionBSchema.getMakeTime();
/*  425 */     this.modifyDate = this.fDate.getDate(aMInvQuestionBSchema.getModifyDate());
/*  426 */     this.modifyTime = aMInvQuestionBSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  435 */       if (rs.getString("EdorNo") == null)
/*  436 */         this.edorNo = null;
/*      */       else {
/*  438 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  440 */       if (rs.getString("EdorType") == null)
/*  441 */         this.edorType = null;
/*      */       else {
/*  443 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  445 */       if (rs.getString("EdorCase") == null)
/*  446 */         this.edorCase = null;
/*      */       else {
/*  448 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  450 */       if (rs.getString("Operator2") == null)
/*  451 */         this.operator2 = null;
/*      */       else {
/*  453 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  455 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  456 */       if (rs.getString("MakeTime2") == null)
/*  457 */         this.makeTime2 = null;
/*      */       else {
/*  459 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*  461 */       if (rs.getString("QuestionID") == null)
/*  462 */         this.questionID = null;
/*      */       else {
/*  464 */         this.questionID = rs.getString("QuestionID").trim();
/*      */       }
/*  466 */       if (rs.getString("TopicID") == null)
/*  467 */         this.topicID = null;
/*      */       else {
/*  469 */         this.topicID = rs.getString("TopicID").trim();
/*      */       }
/*  471 */       if (rs.getString("Question") == null)
/*  472 */         this.question = null;
/*      */       else {
/*  474 */         this.question = rs.getString("Question").trim();
/*      */       }
/*  476 */       if (rs.getString("Depiction") == null)
/*  477 */         this.depiction = null;
/*      */       else {
/*  479 */         this.depiction = rs.getString("Depiction").trim();
/*      */       }
/*  481 */       if (rs.getString("QuestionType") == null)
/*  482 */         this.questionType = null;
/*      */       else {
/*  484 */         this.questionType = rs.getString("QuestionType").trim();
/*      */       }
/*  486 */       this.questionOrder = rs.getInt("QuestionOrder");
/*  487 */       if (rs.getString("ParentID") == null)
/*  488 */         this.parentID = null;
/*      */       else {
/*  490 */         this.parentID = rs.getString("ParentID").trim();
/*      */       }
/*  492 */       if (rs.getString("State") == null)
/*  493 */         this.state = null;
/*      */       else {
/*  495 */         this.state = rs.getString("State").trim();
/*      */       }
/*  497 */       if (rs.getString("ChildFlag") == null)
/*  498 */         this.childFlag = null;
/*      */       else {
/*  500 */         this.childFlag = rs.getString("ChildFlag").trim();
/*      */       }
/*  502 */       if (rs.getString("VF01") == null)
/*  503 */         this.vF01 = null;
/*      */       else {
/*  505 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  507 */       if (rs.getString("NF01") == null)
/*  508 */         this.nF01 = null;
/*      */       else {
/*  510 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  512 */       this.iF01 = rs.getInt("IF01");
/*  513 */       this.dF02 = rs.getDouble("DF02");
/*  514 */       this.date01 = rs.getDate("Date01");
/*  515 */       if (rs.getString("ModifyOperator") == null)
/*  516 */         this.modifyOperator = null;
/*      */       else {
/*  518 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  520 */       if (rs.getString("Operator") == null)
/*  521 */         this.operator = null;
/*      */       else {
/*  523 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  525 */       this.makeDate = rs.getDate("MakeDate");
/*  526 */       if (rs.getString("MakeTime") == null)
/*  527 */         this.makeTime = null;
/*      */       else {
/*  529 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  531 */       this.modifyDate = rs.getDate("ModifyDate");
/*  532 */       if (rs.getString("ModifyTime") == null)
/*  533 */         this.modifyTime = null;
/*      */       else {
/*  535 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  540 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MInvQuestionB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  542 */       CError tError = new CError();
/*  543 */       tError.moduleName = "MInvQuestionBSchema";
/*  544 */       tError.functionName = "setSchema";
/*  545 */       tError.errorMessage = sqle.toString();
/*  546 */       this.mErrors.addOneError(tError);
/*  547 */       return false;
/*      */     }
/*  549 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvQuestionBSchema getSchema()
/*      */   {
/*  554 */     MInvQuestionBSchema aMInvQuestionBSchema = new MInvQuestionBSchema();
/*  555 */     aMInvQuestionBSchema.setSchema(this);
/*  556 */     return aMInvQuestionBSchema;
/*      */   }
/*      */ 
/*      */   public MInvQuestionBDB getDB()
/*      */   {
/*  561 */     MInvQuestionBDB aDBOper = new MInvQuestionBDB();
/*  562 */     aDBOper.setSchema(this);
/*  563 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  570 */     StringBuffer strReturn = new StringBuffer(256);
/*  571 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  572 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  573 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  574 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  575 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  576 */     strReturn.append(StrTool.cTrim(this.makeTime2)); strReturn.append("|");
/*  577 */     strReturn.append(StrTool.cTrim(this.questionID)); strReturn.append("|");
/*  578 */     strReturn.append(StrTool.cTrim(this.topicID)); strReturn.append("|");
/*  579 */     strReturn.append(StrTool.cTrim(this.question)); strReturn.append("|");
/*  580 */     strReturn.append(StrTool.cTrim(this.depiction)); strReturn.append("|");
/*  581 */     strReturn.append(StrTool.cTrim(this.questionType)); strReturn.append("|");
/*  582 */     strReturn.append(ChgData.chgData(this.questionOrder)); strReturn.append("|");
/*  583 */     strReturn.append(StrTool.cTrim(this.parentID)); strReturn.append("|");
/*  584 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  585 */     strReturn.append(StrTool.cTrim(this.childFlag)); strReturn.append("|");
/*  586 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  587 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  588 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  589 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  590 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  591 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  592 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  593 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  594 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  595 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  596 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  597 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  605 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  606 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  607 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  608 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  609 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/*  610 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  611 */       this.questionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  612 */       this.topicID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  613 */       this.question = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  614 */       this.depiction = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  615 */       this.questionType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  616 */       this.questionOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).intValue();
/*  617 */       this.parentID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  618 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  619 */       this.childFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  620 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  621 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  622 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|"))).intValue();
/*  623 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 19, "|"))).doubleValue();
/*  624 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  625 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  626 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  627 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
/*  628 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  629 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
/*  630 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  635 */       CError tError = new CError();
/*  636 */       tError.moduleName = "MInvQuestionBSchema";
/*  637 */       tError.functionName = "decode";
/*  638 */       tError.errorMessage = ex.toString();
/*  639 */       this.mErrors.addOneError(tError);
/*      */ 
/*  641 */       return false;
/*      */     }
/*  643 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  649 */     String strReturn = "";
/*  650 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  652 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  654 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  656 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  658 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  660 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  662 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  664 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  666 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  668 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  670 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  672 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  676 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionID));
/*      */     }
/*  678 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/*  680 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.topicID));
/*      */     }
/*  682 */     if (FCode.equalsIgnoreCase("question"))
/*      */     {
/*  684 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.question));
/*      */     }
/*  686 */     if (FCode.equalsIgnoreCase("depiction"))
/*      */     {
/*  688 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.depiction));
/*      */     }
/*  690 */     if (FCode.equalsIgnoreCase("questionType"))
/*      */     {
/*  692 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionType));
/*      */     }
/*  694 */     if (FCode.equalsIgnoreCase("questionOrder"))
/*      */     {
/*  696 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionOrder));
/*      */     }
/*  698 */     if (FCode.equalsIgnoreCase("parentID"))
/*      */     {
/*  700 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.parentID));
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  704 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  706 */     if (FCode.equalsIgnoreCase("childFlag"))
/*      */     {
/*  708 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.childFlag));
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  712 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  714 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  716 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  718 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  720 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  722 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  724 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  726 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  728 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  730 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  732 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  734 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  736 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  740 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  742 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  744 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  748 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  750 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  752 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  754 */     if (strReturn.equals(""))
/*      */     {
/*  756 */       strReturn = "null";
/*      */     }
/*      */ 
/*  759 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  766 */     String strFieldValue = "";
/*  767 */     switch (nFieldIndex) {
/*      */     case 0:
/*  769 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  770 */       break;
/*      */     case 1:
/*  772 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  773 */       break;
/*      */     case 2:
/*  775 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  776 */       break;
/*      */     case 3:
/*  778 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  779 */       break;
/*      */     case 4:
/*  781 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  782 */       break;
/*      */     case 5:
/*  784 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  785 */       break;
/*      */     case 6:
/*  787 */       strFieldValue = StrTool.GBKToUnicode(this.questionID);
/*  788 */       break;
/*      */     case 7:
/*  790 */       strFieldValue = StrTool.GBKToUnicode(this.topicID);
/*  791 */       break;
/*      */     case 8:
/*  793 */       strFieldValue = StrTool.GBKToUnicode(this.question);
/*  794 */       break;
/*      */     case 9:
/*  796 */       strFieldValue = StrTool.GBKToUnicode(this.depiction);
/*  797 */       break;
/*      */     case 10:
/*  799 */       strFieldValue = StrTool.GBKToUnicode(this.questionType);
/*  800 */       break;
/*      */     case 11:
/*  802 */       strFieldValue = String.valueOf(this.questionOrder);
/*  803 */       break;
/*      */     case 12:
/*  805 */       strFieldValue = StrTool.GBKToUnicode(this.parentID);
/*  806 */       break;
/*      */     case 13:
/*  808 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  809 */       break;
/*      */     case 14:
/*  811 */       strFieldValue = StrTool.GBKToUnicode(this.childFlag);
/*  812 */       break;
/*      */     case 15:
/*  814 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  815 */       break;
/*      */     case 16:
/*  817 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  818 */       break;
/*      */     case 17:
/*  820 */       strFieldValue = String.valueOf(this.iF01);
/*  821 */       break;
/*      */     case 18:
/*  823 */       strFieldValue = String.valueOf(this.dF02);
/*  824 */       break;
/*      */     case 19:
/*  826 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  827 */       break;
/*      */     case 20:
/*  829 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  830 */       break;
/*      */     case 21:
/*  832 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  833 */       break;
/*      */     case 22:
/*  835 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  836 */       break;
/*      */     case 23:
/*  838 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  839 */       break;
/*      */     case 24:
/*  841 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  842 */       break;
/*      */     case 25:
/*  844 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  845 */       break;
/*      */     default:
/*  847 */       strFieldValue = "";
/*      */     }
/*  849 */     if (strFieldValue.equals("")) {
/*  850 */       strFieldValue = "null";
/*      */     }
/*  852 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  858 */     if (StrTool.cTrim(FCode).equals("")) {
/*  859 */       return false;
/*      */     }
/*  861 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  863 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  865 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/*  868 */         this.edorNo = null;
/*      */     }
/*  870 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  872 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  874 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/*  877 */         this.edorType = null;
/*      */     }
/*  879 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  881 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  883 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/*  886 */         this.edorCase = null;
/*      */     }
/*  888 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  890 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  892 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/*  895 */         this.operator2 = null;
/*      */     }
/*  897 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  899 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  901 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  904 */         this.makeDate2 = null;
/*      */     }
/*  906 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  908 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  910 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/*  913 */         this.makeTime2 = null;
/*      */     }
/*  915 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  917 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  919 */         this.questionID = FValue.trim();
/*      */       }
/*      */       else
/*  922 */         this.questionID = null;
/*      */     }
/*  924 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/*  926 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  928 */         this.topicID = FValue.trim();
/*      */       }
/*      */       else
/*  931 */         this.topicID = null;
/*      */     }
/*  933 */     if (FCode.equalsIgnoreCase("question"))
/*      */     {
/*  935 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  937 */         this.question = FValue.trim();
/*      */       }
/*      */       else
/*  940 */         this.question = null;
/*      */     }
/*  942 */     if (FCode.equalsIgnoreCase("depiction"))
/*      */     {
/*  944 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  946 */         this.depiction = FValue.trim();
/*      */       }
/*      */       else
/*  949 */         this.depiction = null;
/*      */     }
/*  951 */     if (FCode.equalsIgnoreCase("questionType"))
/*      */     {
/*  953 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  955 */         this.questionType = FValue.trim();
/*      */       }
/*      */       else
/*  958 */         this.questionType = null;
/*      */     }
/*  960 */     if (FCode.equalsIgnoreCase("questionOrder"))
/*      */     {
/*  962 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  964 */         Integer tInteger = new Integer(FValue);
/*  965 */         int i = tInteger.intValue();
/*  966 */         this.questionOrder = i;
/*      */       }
/*      */     }
/*  969 */     if (FCode.equalsIgnoreCase("parentID"))
/*      */     {
/*  971 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  973 */         this.parentID = FValue.trim();
/*      */       }
/*      */       else
/*  976 */         this.parentID = null;
/*      */     }
/*  978 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  980 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  982 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  985 */         this.state = null;
/*      */     }
/*  987 */     if (FCode.equalsIgnoreCase("childFlag"))
/*      */     {
/*  989 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  991 */         this.childFlag = FValue.trim();
/*      */       }
/*      */       else
/*  994 */         this.childFlag = null;
/*      */     }
/*  996 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  998 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1000 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1003 */         this.vF01 = null;
/*      */     }
/* 1005 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1007 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1009 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1012 */         this.nF01 = null;
/*      */     }
/* 1014 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1016 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1018 */         Integer tInteger = new Integer(FValue);
/* 1019 */         int i = tInteger.intValue();
/* 1020 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1023 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1025 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1027 */         Double tDouble = new Double(FValue);
/* 1028 */         double d = tDouble.doubleValue();
/* 1029 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1032 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1034 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1036 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1039 */         this.date01 = null;
/*      */     }
/* 1041 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1043 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1045 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1048 */         this.modifyOperator = null;
/*      */     }
/* 1050 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1052 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1054 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1057 */         this.operator = null;
/*      */     }
/* 1059 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1061 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1063 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1066 */         this.makeDate = null;
/*      */     }
/* 1068 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1070 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1072 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1075 */         this.makeTime = null;
/*      */     }
/* 1077 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1079 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1081 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1084 */         this.modifyDate = null;
/*      */     }
/* 1086 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1088 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1090 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1093 */         this.modifyTime = null;
/*      */     }
/* 1095 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1100 */     if (otherObject == null) return false;
/* 1101 */     if (this == otherObject) return true;
/* 1102 */     if (getClass() != otherObject.getClass()) return false;
/* 1103 */     MInvQuestionBSchema other = (MInvQuestionBSchema)otherObject;
/* 1104 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1105 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1106 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1107 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1108 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1109 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1110 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1111 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1112 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1113 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1114 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1115 */     if ((this.makeTime2 != null) && (!this.makeTime2.equals(other.getMakeTime2()))) return false;
/* 1116 */     if ((this.questionID == null) && (other.getQuestionID() != null)) return false;
/* 1117 */     if ((this.questionID != null) && (!this.questionID.equals(other.getQuestionID()))) return false;
/* 1118 */     if ((this.topicID == null) && (other.getTopicID() != null)) return false;
/* 1119 */     if ((this.topicID != null) && (!this.topicID.equals(other.getTopicID()))) return false;
/* 1120 */     if ((this.question == null) && (other.getQuestion() != null)) return false;
/* 1121 */     if ((this.question != null) && (!this.question.equals(other.getQuestion()))) return false;
/* 1122 */     if ((this.depiction == null) && (other.getDepiction() != null)) return false;
/* 1123 */     if ((this.depiction != null) && (!this.depiction.equals(other.getDepiction()))) return false;
/* 1124 */     if ((this.questionType == null) && (other.getQuestionType() != null)) return false;
/* 1125 */     if ((this.questionType != null) && (!this.questionType.equals(other.getQuestionType()))) return false;
/* 1126 */     if (this.questionOrder != other.getQuestionOrder()) return false;
/* 1127 */     if ((this.parentID == null) && (other.getParentID() != null)) return false;
/* 1128 */     if ((this.parentID != null) && (!this.parentID.equals(other.getParentID()))) return false;
/* 1129 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1130 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1131 */     if ((this.childFlag == null) && (other.getChildFlag() != null)) return false;
/* 1132 */     if ((this.childFlag != null) && (!this.childFlag.equals(other.getChildFlag()))) return false;
/* 1133 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1134 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1135 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1136 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1137 */     if (this.iF01 != other.getIF01()) return false;
/* 1138 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1139 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1140 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1141 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1142 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1143 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1144 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1145 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1146 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1147 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1148 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1149 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1150 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1151 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1152 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1159 */     return 26;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1165 */     if (strFieldName.equals("edorNo")) {
/* 1166 */       return 0;
/*      */     }
/* 1168 */     if (strFieldName.equals("edorType")) {
/* 1169 */       return 1;
/*      */     }
/* 1171 */     if (strFieldName.equals("edorCase")) {
/* 1172 */       return 2;
/*      */     }
/* 1174 */     if (strFieldName.equals("operator2")) {
/* 1175 */       return 3;
/*      */     }
/* 1177 */     if (strFieldName.equals("makeDate2")) {
/* 1178 */       return 4;
/*      */     }
/* 1180 */     if (strFieldName.equals("makeTime2")) {
/* 1181 */       return 5;
/*      */     }
/* 1183 */     if (strFieldName.equals("questionID")) {
/* 1184 */       return 6;
/*      */     }
/* 1186 */     if (strFieldName.equals("topicID")) {
/* 1187 */       return 7;
/*      */     }
/* 1189 */     if (strFieldName.equals("question")) {
/* 1190 */       return 8;
/*      */     }
/* 1192 */     if (strFieldName.equals("depiction")) {
/* 1193 */       return 9;
/*      */     }
/* 1195 */     if (strFieldName.equals("questionType")) {
/* 1196 */       return 10;
/*      */     }
/* 1198 */     if (strFieldName.equals("questionOrder")) {
/* 1199 */       return 11;
/*      */     }
/* 1201 */     if (strFieldName.equals("parentID")) {
/* 1202 */       return 12;
/*      */     }
/* 1204 */     if (strFieldName.equals("state")) {
/* 1205 */       return 13;
/*      */     }
/* 1207 */     if (strFieldName.equals("childFlag")) {
/* 1208 */       return 14;
/*      */     }
/* 1210 */     if (strFieldName.equals("vF01")) {
/* 1211 */       return 15;
/*      */     }
/* 1213 */     if (strFieldName.equals("nF01")) {
/* 1214 */       return 16;
/*      */     }
/* 1216 */     if (strFieldName.equals("iF01")) {
/* 1217 */       return 17;
/*      */     }
/* 1219 */     if (strFieldName.equals("dF02")) {
/* 1220 */       return 18;
/*      */     }
/* 1222 */     if (strFieldName.equals("date01")) {
/* 1223 */       return 19;
/*      */     }
/* 1225 */     if (strFieldName.equals("modifyOperator")) {
/* 1226 */       return 20;
/*      */     }
/* 1228 */     if (strFieldName.equals("operator")) {
/* 1229 */       return 21;
/*      */     }
/* 1231 */     if (strFieldName.equals("makeDate")) {
/* 1232 */       return 22;
/*      */     }
/* 1234 */     if (strFieldName.equals("makeTime")) {
/* 1235 */       return 23;
/*      */     }
/* 1237 */     if (strFieldName.equals("modifyDate")) {
/* 1238 */       return 24;
/*      */     }
/* 1240 */     if (strFieldName.equals("modifyTime")) {
/* 1241 */       return 25;
/*      */     }
/* 1243 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1249 */     String strFieldName = "";
/* 1250 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1252 */       strFieldName = "edorNo";
/* 1253 */       break;
/*      */     case 1:
/* 1255 */       strFieldName = "edorType";
/* 1256 */       break;
/*      */     case 2:
/* 1258 */       strFieldName = "edorCase";
/* 1259 */       break;
/*      */     case 3:
/* 1261 */       strFieldName = "operator2";
/* 1262 */       break;
/*      */     case 4:
/* 1264 */       strFieldName = "makeDate2";
/* 1265 */       break;
/*      */     case 5:
/* 1267 */       strFieldName = "makeTime2";
/* 1268 */       break;
/*      */     case 6:
/* 1270 */       strFieldName = "questionID";
/* 1271 */       break;
/*      */     case 7:
/* 1273 */       strFieldName = "topicID";
/* 1274 */       break;
/*      */     case 8:
/* 1276 */       strFieldName = "question";
/* 1277 */       break;
/*      */     case 9:
/* 1279 */       strFieldName = "depiction";
/* 1280 */       break;
/*      */     case 10:
/* 1282 */       strFieldName = "questionType";
/* 1283 */       break;
/*      */     case 11:
/* 1285 */       strFieldName = "questionOrder";
/* 1286 */       break;
/*      */     case 12:
/* 1288 */       strFieldName = "parentID";
/* 1289 */       break;
/*      */     case 13:
/* 1291 */       strFieldName = "state";
/* 1292 */       break;
/*      */     case 14:
/* 1294 */       strFieldName = "childFlag";
/* 1295 */       break;
/*      */     case 15:
/* 1297 */       strFieldName = "vF01";
/* 1298 */       break;
/*      */     case 16:
/* 1300 */       strFieldName = "nF01";
/* 1301 */       break;
/*      */     case 17:
/* 1303 */       strFieldName = "iF01";
/* 1304 */       break;
/*      */     case 18:
/* 1306 */       strFieldName = "dF02";
/* 1307 */       break;
/*      */     case 19:
/* 1309 */       strFieldName = "date01";
/* 1310 */       break;
/*      */     case 20:
/* 1312 */       strFieldName = "modifyOperator";
/* 1313 */       break;
/*      */     case 21:
/* 1315 */       strFieldName = "operator";
/* 1316 */       break;
/*      */     case 22:
/* 1318 */       strFieldName = "makeDate";
/* 1319 */       break;
/*      */     case 23:
/* 1321 */       strFieldName = "makeTime";
/* 1322 */       break;
/*      */     case 24:
/* 1324 */       strFieldName = "modifyDate";
/* 1325 */       break;
/*      */     case 25:
/* 1327 */       strFieldName = "modifyTime";
/* 1328 */       break;
/*      */     default:
/* 1330 */       strFieldName = "";
/*      */     }
/* 1332 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1338 */     if (strFieldName.equals("edorNo")) {
/* 1339 */       return 0;
/*      */     }
/* 1341 */     if (strFieldName.equals("edorType")) {
/* 1342 */       return 0;
/*      */     }
/* 1344 */     if (strFieldName.equals("edorCase")) {
/* 1345 */       return 0;
/*      */     }
/* 1347 */     if (strFieldName.equals("operator2")) {
/* 1348 */       return 0;
/*      */     }
/* 1350 */     if (strFieldName.equals("makeDate2")) {
/* 1351 */       return 1;
/*      */     }
/* 1353 */     if (strFieldName.equals("makeTime2")) {
/* 1354 */       return 0;
/*      */     }
/* 1356 */     if (strFieldName.equals("questionID")) {
/* 1357 */       return 0;
/*      */     }
/* 1359 */     if (strFieldName.equals("topicID")) {
/* 1360 */       return 0;
/*      */     }
/* 1362 */     if (strFieldName.equals("question")) {
/* 1363 */       return 0;
/*      */     }
/* 1365 */     if (strFieldName.equals("depiction")) {
/* 1366 */       return 0;
/*      */     }
/* 1368 */     if (strFieldName.equals("questionType")) {
/* 1369 */       return 0;
/*      */     }
/* 1371 */     if (strFieldName.equals("questionOrder")) {
/* 1372 */       return 3;
/*      */     }
/* 1374 */     if (strFieldName.equals("parentID")) {
/* 1375 */       return 0;
/*      */     }
/* 1377 */     if (strFieldName.equals("state")) {
/* 1378 */       return 0;
/*      */     }
/* 1380 */     if (strFieldName.equals("childFlag")) {
/* 1381 */       return 0;
/*      */     }
/* 1383 */     if (strFieldName.equals("vF01")) {
/* 1384 */       return 0;
/*      */     }
/* 1386 */     if (strFieldName.equals("nF01")) {
/* 1387 */       return 0;
/*      */     }
/* 1389 */     if (strFieldName.equals("iF01")) {
/* 1390 */       return 3;
/*      */     }
/* 1392 */     if (strFieldName.equals("dF02")) {
/* 1393 */       return 4;
/*      */     }
/* 1395 */     if (strFieldName.equals("date01")) {
/* 1396 */       return 1;
/*      */     }
/* 1398 */     if (strFieldName.equals("modifyOperator")) {
/* 1399 */       return 0;
/*      */     }
/* 1401 */     if (strFieldName.equals("operator")) {
/* 1402 */       return 0;
/*      */     }
/* 1404 */     if (strFieldName.equals("makeDate")) {
/* 1405 */       return 1;
/*      */     }
/* 1407 */     if (strFieldName.equals("makeTime")) {
/* 1408 */       return 0;
/*      */     }
/* 1410 */     if (strFieldName.equals("modifyDate")) {
/* 1411 */       return 1;
/*      */     }
/* 1413 */     if (strFieldName.equals("modifyTime")) {
/* 1414 */       return 0;
/*      */     }
/* 1416 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1422 */     int nFieldType = -1;
/* 1423 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1425 */       nFieldType = 0;
/* 1426 */       break;
/*      */     case 1:
/* 1428 */       nFieldType = 0;
/* 1429 */       break;
/*      */     case 2:
/* 1431 */       nFieldType = 0;
/* 1432 */       break;
/*      */     case 3:
/* 1434 */       nFieldType = 0;
/* 1435 */       break;
/*      */     case 4:
/* 1437 */       nFieldType = 1;
/* 1438 */       break;
/*      */     case 5:
/* 1440 */       nFieldType = 0;
/* 1441 */       break;
/*      */     case 6:
/* 1443 */       nFieldType = 0;
/* 1444 */       break;
/*      */     case 7:
/* 1446 */       nFieldType = 0;
/* 1447 */       break;
/*      */     case 8:
/* 1449 */       nFieldType = 0;
/* 1450 */       break;
/*      */     case 9:
/* 1452 */       nFieldType = 0;
/* 1453 */       break;
/*      */     case 10:
/* 1455 */       nFieldType = 0;
/* 1456 */       break;
/*      */     case 11:
/* 1458 */       nFieldType = 3;
/* 1459 */       break;
/*      */     case 12:
/* 1461 */       nFieldType = 0;
/* 1462 */       break;
/*      */     case 13:
/* 1464 */       nFieldType = 0;
/* 1465 */       break;
/*      */     case 14:
/* 1467 */       nFieldType = 0;
/* 1468 */       break;
/*      */     case 15:
/* 1470 */       nFieldType = 0;
/* 1471 */       break;
/*      */     case 16:
/* 1473 */       nFieldType = 0;
/* 1474 */       break;
/*      */     case 17:
/* 1476 */       nFieldType = 3;
/* 1477 */       break;
/*      */     case 18:
/* 1479 */       nFieldType = 4;
/* 1480 */       break;
/*      */     case 19:
/* 1482 */       nFieldType = 1;
/* 1483 */       break;
/*      */     case 20:
/* 1485 */       nFieldType = 0;
/* 1486 */       break;
/*      */     case 21:
/* 1488 */       nFieldType = 0;
/* 1489 */       break;
/*      */     case 22:
/* 1491 */       nFieldType = 1;
/* 1492 */       break;
/*      */     case 23:
/* 1494 */       nFieldType = 0;
/* 1495 */       break;
/*      */     case 24:
/* 1497 */       nFieldType = 1;
/* 1498 */       break;
/*      */     case 25:
/* 1500 */       nFieldType = 0;
/* 1501 */       break;
/*      */     default:
/* 1503 */       nFieldType = -1;
/*      */     }
/* 1505 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MInvQuestionBSchema
 * JD-Core Version:    0.6.0
 */