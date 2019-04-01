/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MInvResultBDB;
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
/*      */ public class MInvResultBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   private String resultID;
/*      */   private String topicID;
/*      */   private String questionID;
/*      */   private String optionID;
/*      */   private String otherAnswer;
/*      */   private String agentCode;
/*      */   private String manageCom;
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
/*      */   public static final int FIELDNUM = 24;
/*      */   private static String[] PK;
/*   72 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MInvResultBSchema()
/*      */   {
/*   79 */     this.mErrors = new CErrors();
/*      */ 
/*   81 */     String[] pk = new String[1];
/*   82 */     pk[0] = "EdorNo";
/*      */ 
/*   84 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   91 */     MInvResultBSchema cloned = (MInvResultBSchema)super.clone();
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
/*      */   public String getEdorNo()
/*      */   {
/*  105 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  109 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  113 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  117 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  121 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  125 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  129 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  133 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  137 */     if (this.makeDate2 != null) {
/*  138 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  140 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  144 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  148 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  150 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  153 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  158 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  162 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public String getResultID() {
/*  166 */     return this.resultID;
/*      */   }
/*      */ 
/*      */   public void setResultID(String aResultID) {
/*  170 */     this.resultID = aResultID;
/*      */   }
/*      */ 
/*      */   public String getTopicID() {
/*  174 */     return this.topicID;
/*      */   }
/*      */ 
/*      */   public void setTopicID(String aTopicID) {
/*  178 */     this.topicID = aTopicID;
/*      */   }
/*      */ 
/*      */   public String getQuestionID() {
/*  182 */     return this.questionID;
/*      */   }
/*      */ 
/*      */   public void setQuestionID(String aQuestionID) {
/*  186 */     this.questionID = aQuestionID;
/*      */   }
/*      */ 
/*      */   public String getOptionID() {
/*  190 */     return this.optionID;
/*      */   }
/*      */ 
/*      */   public void setOptionID(String aOptionID) {
/*  194 */     this.optionID = aOptionID;
/*      */   }
/*      */ 
/*      */   public String getOtherAnswer() {
/*  198 */     return this.otherAnswer;
/*      */   }
/*      */ 
/*      */   public void setOtherAnswer(String aOtherAnswer) {
/*  202 */     this.otherAnswer = aOtherAnswer;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  206 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  210 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  214 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  218 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  222 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  226 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  230 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  234 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  238 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  242 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  246 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  248 */       Integer tInteger = new Integer(aIF01);
/*  249 */       int i = tInteger.intValue();
/*  250 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  256 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  260 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  264 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  266 */       Double tDouble = new Double(aDF02);
/*  267 */       double d = tDouble.doubleValue();
/*  268 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  274 */     if (this.date01 != null) {
/*  275 */       return this.fDate.getString(this.date01);
/*      */     }
/*  277 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  281 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  285 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  287 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  290 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  295 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  299 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  303 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  307 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  311 */     if (this.makeDate != null) {
/*  312 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  314 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  318 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  322 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  324 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  327 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  332 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  336 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  340 */     if (this.modifyDate != null) {
/*  341 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  343 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  347 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  351 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  353 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  356 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  361 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  365 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MInvResultBSchema aMInvResultBSchema)
/*      */   {
/*  371 */     this.edorNo = aMInvResultBSchema.getEdorNo();
/*  372 */     this.edorType = aMInvResultBSchema.getEdorType();
/*  373 */     this.edorCase = aMInvResultBSchema.getEdorCase();
/*  374 */     this.operator2 = aMInvResultBSchema.getOperator2();
/*  375 */     this.makeDate2 = this.fDate.getDate(aMInvResultBSchema.getMakeDate2());
/*  376 */     this.makeTime2 = aMInvResultBSchema.getMakeTime2();
/*  377 */     this.resultID = aMInvResultBSchema.getResultID();
/*  378 */     this.topicID = aMInvResultBSchema.getTopicID();
/*  379 */     this.questionID = aMInvResultBSchema.getQuestionID();
/*  380 */     this.optionID = aMInvResultBSchema.getOptionID();
/*  381 */     this.otherAnswer = aMInvResultBSchema.getOtherAnswer();
/*  382 */     this.agentCode = aMInvResultBSchema.getAgentCode();
/*  383 */     this.manageCom = aMInvResultBSchema.getManageCom();
/*  384 */     this.vF01 = aMInvResultBSchema.getVF01();
/*  385 */     this.nF01 = aMInvResultBSchema.getNF01();
/*  386 */     this.iF01 = aMInvResultBSchema.getIF01();
/*  387 */     this.dF02 = aMInvResultBSchema.getDF02();
/*  388 */     this.date01 = this.fDate.getDate(aMInvResultBSchema.getDate01());
/*  389 */     this.modifyOperator = aMInvResultBSchema.getModifyOperator();
/*  390 */     this.operator = aMInvResultBSchema.getOperator();
/*  391 */     this.makeDate = this.fDate.getDate(aMInvResultBSchema.getMakeDate());
/*  392 */     this.makeTime = aMInvResultBSchema.getMakeTime();
/*  393 */     this.modifyDate = this.fDate.getDate(aMInvResultBSchema.getModifyDate());
/*  394 */     this.modifyTime = aMInvResultBSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  403 */       if (rs.getString("EdorNo") == null)
/*  404 */         this.edorNo = null;
/*      */       else {
/*  406 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  408 */       if (rs.getString("EdorType") == null)
/*  409 */         this.edorType = null;
/*      */       else {
/*  411 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  413 */       if (rs.getString("EdorCase") == null)
/*  414 */         this.edorCase = null;
/*      */       else {
/*  416 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  418 */       if (rs.getString("Operator2") == null)
/*  419 */         this.operator2 = null;
/*      */       else {
/*  421 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  423 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  424 */       if (rs.getString("MakeTime2") == null)
/*  425 */         this.makeTime2 = null;
/*      */       else {
/*  427 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*  429 */       if (rs.getString("ResultID") == null)
/*  430 */         this.resultID = null;
/*      */       else {
/*  432 */         this.resultID = rs.getString("ResultID").trim();
/*      */       }
/*  434 */       if (rs.getString("TopicID") == null)
/*  435 */         this.topicID = null;
/*      */       else {
/*  437 */         this.topicID = rs.getString("TopicID").trim();
/*      */       }
/*  439 */       if (rs.getString("QuestionID") == null)
/*  440 */         this.questionID = null;
/*      */       else {
/*  442 */         this.questionID = rs.getString("QuestionID").trim();
/*      */       }
/*  444 */       if (rs.getString("OptionID") == null)
/*  445 */         this.optionID = null;
/*      */       else {
/*  447 */         this.optionID = rs.getString("OptionID").trim();
/*      */       }
/*  449 */       if (rs.getString("OtherAnswer") == null)
/*  450 */         this.otherAnswer = null;
/*      */       else {
/*  452 */         this.otherAnswer = rs.getString("OtherAnswer").trim();
/*      */       }
/*  454 */       if (rs.getString("AgentCode") == null)
/*  455 */         this.agentCode = null;
/*      */       else {
/*  457 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/*  459 */       if (rs.getString("ManageCom") == null)
/*  460 */         this.manageCom = null;
/*      */       else {
/*  462 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  464 */       if (rs.getString("VF01") == null)
/*  465 */         this.vF01 = null;
/*      */       else {
/*  467 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  469 */       if (rs.getString("NF01") == null)
/*  470 */         this.nF01 = null;
/*      */       else {
/*  472 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  474 */       this.iF01 = rs.getInt("IF01");
/*  475 */       this.dF02 = rs.getDouble("DF02");
/*  476 */       this.date01 = rs.getDate("Date01");
/*  477 */       if (rs.getString("ModifyOperator") == null)
/*  478 */         this.modifyOperator = null;
/*      */       else {
/*  480 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  482 */       if (rs.getString("Operator") == null)
/*  483 */         this.operator = null;
/*      */       else {
/*  485 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  487 */       this.makeDate = rs.getDate("MakeDate");
/*  488 */       if (rs.getString("MakeTime") == null)
/*  489 */         this.makeTime = null;
/*      */       else {
/*  491 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  493 */       this.modifyDate = rs.getDate("ModifyDate");
/*  494 */       if (rs.getString("ModifyTime") == null)
/*  495 */         this.modifyTime = null;
/*      */       else {
/*  497 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  502 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MInvResultB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  504 */       CError tError = new CError();
/*  505 */       tError.moduleName = "MInvResultBSchema";
/*  506 */       tError.functionName = "setSchema";
/*  507 */       tError.errorMessage = sqle.toString();
/*  508 */       this.mErrors.addOneError(tError);
/*  509 */       return false;
/*      */     }
/*  511 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvResultBSchema getSchema()
/*      */   {
/*  516 */     MInvResultBSchema aMInvResultBSchema = new MInvResultBSchema();
/*  517 */     aMInvResultBSchema.setSchema(this);
/*  518 */     return aMInvResultBSchema;
/*      */   }
/*      */ 
/*      */   public MInvResultBDB getDB()
/*      */   {
/*  523 */     MInvResultBDB aDBOper = new MInvResultBDB();
/*  524 */     aDBOper.setSchema(this);
/*  525 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  532 */     StringBuffer strReturn = new StringBuffer(256);
/*  533 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  534 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  535 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  536 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  537 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  538 */     strReturn.append(StrTool.cTrim(this.makeTime2)); strReturn.append("|");
/*  539 */     strReturn.append(StrTool.cTrim(this.resultID)); strReturn.append("|");
/*  540 */     strReturn.append(StrTool.cTrim(this.topicID)); strReturn.append("|");
/*  541 */     strReturn.append(StrTool.cTrim(this.questionID)); strReturn.append("|");
/*  542 */     strReturn.append(StrTool.cTrim(this.optionID)); strReturn.append("|");
/*  543 */     strReturn.append(StrTool.cTrim(this.otherAnswer)); strReturn.append("|");
/*  544 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/*  545 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  546 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  547 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  548 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  549 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  550 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  551 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  552 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  553 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  554 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  555 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  556 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  557 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  565 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  566 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  567 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  568 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  569 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/*  570 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  571 */       this.resultID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  572 */       this.topicID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  573 */       this.questionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  574 */       this.optionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  575 */       this.otherAnswer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  576 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  577 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  578 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  579 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  580 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|"))).intValue();
/*  581 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 17, "|"))).doubleValue();
/*  582 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*  583 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  584 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  585 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
/*  586 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  587 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
/*  588 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  593 */       CError tError = new CError();
/*  594 */       tError.moduleName = "MInvResultBSchema";
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
/*  608 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  610 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  612 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  614 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  616 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  618 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  620 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  622 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  624 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  626 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  628 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  630 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  632 */     if (FCode.equalsIgnoreCase("resultID"))
/*      */     {
/*  634 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.resultID));
/*      */     }
/*  636 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/*  638 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.topicID));
/*      */     }
/*  640 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  642 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionID));
/*      */     }
/*  644 */     if (FCode.equalsIgnoreCase("optionID"))
/*      */     {
/*  646 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.optionID));
/*      */     }
/*  648 */     if (FCode.equalsIgnoreCase("otherAnswer"))
/*      */     {
/*  650 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.otherAnswer));
/*      */     }
/*  652 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  654 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/*  656 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  658 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  660 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  662 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  664 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  666 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  668 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  670 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  672 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  674 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  676 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  678 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  680 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  682 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  684 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  686 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  688 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  690 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  692 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  694 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  696 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  698 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  700 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  702 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
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
/*  719 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  720 */       break;
/*      */     case 1:
/*  722 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  723 */       break;
/*      */     case 2:
/*  725 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  726 */       break;
/*      */     case 3:
/*  728 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  729 */       break;
/*      */     case 4:
/*  731 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  732 */       break;
/*      */     case 5:
/*  734 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  735 */       break;
/*      */     case 6:
/*  737 */       strFieldValue = StrTool.GBKToUnicode(this.resultID);
/*  738 */       break;
/*      */     case 7:
/*  740 */       strFieldValue = StrTool.GBKToUnicode(this.topicID);
/*  741 */       break;
/*      */     case 8:
/*  743 */       strFieldValue = StrTool.GBKToUnicode(this.questionID);
/*  744 */       break;
/*      */     case 9:
/*  746 */       strFieldValue = StrTool.GBKToUnicode(this.optionID);
/*  747 */       break;
/*      */     case 10:
/*  749 */       strFieldValue = StrTool.GBKToUnicode(this.otherAnswer);
/*  750 */       break;
/*      */     case 11:
/*  752 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/*  753 */       break;
/*      */     case 12:
/*  755 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  756 */       break;
/*      */     case 13:
/*  758 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  759 */       break;
/*      */     case 14:
/*  761 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  762 */       break;
/*      */     case 15:
/*  764 */       strFieldValue = String.valueOf(this.iF01);
/*  765 */       break;
/*      */     case 16:
/*  767 */       strFieldValue = String.valueOf(this.dF02);
/*  768 */       break;
/*      */     case 17:
/*  770 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  771 */       break;
/*      */     case 18:
/*  773 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  774 */       break;
/*      */     case 19:
/*  776 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  777 */       break;
/*      */     case 20:
/*  779 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  780 */       break;
/*      */     case 21:
/*  782 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  783 */       break;
/*      */     case 22:
/*  785 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  786 */       break;
/*      */     case 23:
/*  788 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
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
/*  805 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  807 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  809 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/*  812 */         this.edorNo = null;
/*      */     }
/*  814 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  816 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  818 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/*  821 */         this.edorType = null;
/*      */     }
/*  823 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  825 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  827 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/*  830 */         this.edorCase = null;
/*      */     }
/*  832 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  834 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  836 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/*  839 */         this.operator2 = null;
/*      */     }
/*  841 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  843 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  845 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  848 */         this.makeDate2 = null;
/*      */     }
/*  850 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  852 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  854 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/*  857 */         this.makeTime2 = null;
/*      */     }
/*  859 */     if (FCode.equalsIgnoreCase("resultID"))
/*      */     {
/*  861 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  863 */         this.resultID = FValue.trim();
/*      */       }
/*      */       else
/*  866 */         this.resultID = null;
/*      */     }
/*  868 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/*  870 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  872 */         this.topicID = FValue.trim();
/*      */       }
/*      */       else
/*  875 */         this.topicID = null;
/*      */     }
/*  877 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  879 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  881 */         this.questionID = FValue.trim();
/*      */       }
/*      */       else
/*  884 */         this.questionID = null;
/*      */     }
/*  886 */     if (FCode.equalsIgnoreCase("optionID"))
/*      */     {
/*  888 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  890 */         this.optionID = FValue.trim();
/*      */       }
/*      */       else
/*  893 */         this.optionID = null;
/*      */     }
/*  895 */     if (FCode.equalsIgnoreCase("otherAnswer"))
/*      */     {
/*  897 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  899 */         this.otherAnswer = FValue.trim();
/*      */       }
/*      */       else
/*  902 */         this.otherAnswer = null;
/*      */     }
/*  904 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  906 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  908 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/*  911 */         this.agentCode = null;
/*      */     }
/*  913 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  915 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  917 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  920 */         this.manageCom = null;
/*      */     }
/*  922 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  924 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  926 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/*  929 */         this.vF01 = null;
/*      */     }
/*  931 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  933 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  935 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/*  938 */         this.nF01 = null;
/*      */     }
/*  940 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  942 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  944 */         Integer tInteger = new Integer(FValue);
/*  945 */         int i = tInteger.intValue();
/*  946 */         this.iF01 = i;
/*      */       }
/*      */     }
/*  949 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  951 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  953 */         Double tDouble = new Double(FValue);
/*  954 */         double d = tDouble.doubleValue();
/*  955 */         this.dF02 = d;
/*      */       }
/*      */     }
/*  958 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  960 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  962 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  965 */         this.date01 = null;
/*      */     }
/*  967 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  969 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  971 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  974 */         this.modifyOperator = null;
/*      */     }
/*  976 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  978 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  980 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  983 */         this.operator = null;
/*      */     }
/*  985 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  987 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  989 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  992 */         this.makeDate = null;
/*      */     }
/*  994 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  996 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  998 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1001 */         this.makeTime = null;
/*      */     }
/* 1003 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1005 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1007 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1010 */         this.modifyDate = null;
/*      */     }
/* 1012 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1014 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1016 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1019 */         this.modifyTime = null;
/*      */     }
/* 1021 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1026 */     if (otherObject == null) return false;
/* 1027 */     if (this == otherObject) return true;
/* 1028 */     if (getClass() != otherObject.getClass()) return false;
/* 1029 */     MInvResultBSchema other = (MInvResultBSchema)otherObject;
/* 1030 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1031 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1032 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1033 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1034 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1035 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1036 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1037 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1038 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1039 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1040 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1041 */     if ((this.makeTime2 != null) && (!this.makeTime2.equals(other.getMakeTime2()))) return false;
/* 1042 */     if ((this.resultID == null) && (other.getResultID() != null)) return false;
/* 1043 */     if ((this.resultID != null) && (!this.resultID.equals(other.getResultID()))) return false;
/* 1044 */     if ((this.topicID == null) && (other.getTopicID() != null)) return false;
/* 1045 */     if ((this.topicID != null) && (!this.topicID.equals(other.getTopicID()))) return false;
/* 1046 */     if ((this.questionID == null) && (other.getQuestionID() != null)) return false;
/* 1047 */     if ((this.questionID != null) && (!this.questionID.equals(other.getQuestionID()))) return false;
/* 1048 */     if ((this.optionID == null) && (other.getOptionID() != null)) return false;
/* 1049 */     if ((this.optionID != null) && (!this.optionID.equals(other.getOptionID()))) return false;
/* 1050 */     if ((this.otherAnswer == null) && (other.getOtherAnswer() != null)) return false;
/* 1051 */     if ((this.otherAnswer != null) && (!this.otherAnswer.equals(other.getOtherAnswer()))) return false;
/* 1052 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/* 1053 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/* 1054 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1055 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1056 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1057 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1058 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1059 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1060 */     if (this.iF01 != other.getIF01()) return false;
/* 1061 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1062 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1063 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1064 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1065 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1066 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1067 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1068 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1069 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1070 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1071 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1072 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1073 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1074 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1075 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1082 */     return 24;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1088 */     if (strFieldName.equals("edorNo")) {
/* 1089 */       return 0;
/*      */     }
/* 1091 */     if (strFieldName.equals("edorType")) {
/* 1092 */       return 1;
/*      */     }
/* 1094 */     if (strFieldName.equals("edorCase")) {
/* 1095 */       return 2;
/*      */     }
/* 1097 */     if (strFieldName.equals("operator2")) {
/* 1098 */       return 3;
/*      */     }
/* 1100 */     if (strFieldName.equals("makeDate2")) {
/* 1101 */       return 4;
/*      */     }
/* 1103 */     if (strFieldName.equals("makeTime2")) {
/* 1104 */       return 5;
/*      */     }
/* 1106 */     if (strFieldName.equals("resultID")) {
/* 1107 */       return 6;
/*      */     }
/* 1109 */     if (strFieldName.equals("topicID")) {
/* 1110 */       return 7;
/*      */     }
/* 1112 */     if (strFieldName.equals("questionID")) {
/* 1113 */       return 8;
/*      */     }
/* 1115 */     if (strFieldName.equals("optionID")) {
/* 1116 */       return 9;
/*      */     }
/* 1118 */     if (strFieldName.equals("otherAnswer")) {
/* 1119 */       return 10;
/*      */     }
/* 1121 */     if (strFieldName.equals("agentCode")) {
/* 1122 */       return 11;
/*      */     }
/* 1124 */     if (strFieldName.equals("manageCom")) {
/* 1125 */       return 12;
/*      */     }
/* 1127 */     if (strFieldName.equals("vF01")) {
/* 1128 */       return 13;
/*      */     }
/* 1130 */     if (strFieldName.equals("nF01")) {
/* 1131 */       return 14;
/*      */     }
/* 1133 */     if (strFieldName.equals("iF01")) {
/* 1134 */       return 15;
/*      */     }
/* 1136 */     if (strFieldName.equals("dF02")) {
/* 1137 */       return 16;
/*      */     }
/* 1139 */     if (strFieldName.equals("date01")) {
/* 1140 */       return 17;
/*      */     }
/* 1142 */     if (strFieldName.equals("modifyOperator")) {
/* 1143 */       return 18;
/*      */     }
/* 1145 */     if (strFieldName.equals("operator")) {
/* 1146 */       return 19;
/*      */     }
/* 1148 */     if (strFieldName.equals("makeDate")) {
/* 1149 */       return 20;
/*      */     }
/* 1151 */     if (strFieldName.equals("makeTime")) {
/* 1152 */       return 21;
/*      */     }
/* 1154 */     if (strFieldName.equals("modifyDate")) {
/* 1155 */       return 22;
/*      */     }
/* 1157 */     if (strFieldName.equals("modifyTime")) {
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
/* 1169 */       strFieldName = "edorNo";
/* 1170 */       break;
/*      */     case 1:
/* 1172 */       strFieldName = "edorType";
/* 1173 */       break;
/*      */     case 2:
/* 1175 */       strFieldName = "edorCase";
/* 1176 */       break;
/*      */     case 3:
/* 1178 */       strFieldName = "operator2";
/* 1179 */       break;
/*      */     case 4:
/* 1181 */       strFieldName = "makeDate2";
/* 1182 */       break;
/*      */     case 5:
/* 1184 */       strFieldName = "makeTime2";
/* 1185 */       break;
/*      */     case 6:
/* 1187 */       strFieldName = "resultID";
/* 1188 */       break;
/*      */     case 7:
/* 1190 */       strFieldName = "topicID";
/* 1191 */       break;
/*      */     case 8:
/* 1193 */       strFieldName = "questionID";
/* 1194 */       break;
/*      */     case 9:
/* 1196 */       strFieldName = "optionID";
/* 1197 */       break;
/*      */     case 10:
/* 1199 */       strFieldName = "otherAnswer";
/* 1200 */       break;
/*      */     case 11:
/* 1202 */       strFieldName = "agentCode";
/* 1203 */       break;
/*      */     case 12:
/* 1205 */       strFieldName = "manageCom";
/* 1206 */       break;
/*      */     case 13:
/* 1208 */       strFieldName = "vF01";
/* 1209 */       break;
/*      */     case 14:
/* 1211 */       strFieldName = "nF01";
/* 1212 */       break;
/*      */     case 15:
/* 1214 */       strFieldName = "iF01";
/* 1215 */       break;
/*      */     case 16:
/* 1217 */       strFieldName = "dF02";
/* 1218 */       break;
/*      */     case 17:
/* 1220 */       strFieldName = "date01";
/* 1221 */       break;
/*      */     case 18:
/* 1223 */       strFieldName = "modifyOperator";
/* 1224 */       break;
/*      */     case 19:
/* 1226 */       strFieldName = "operator";
/* 1227 */       break;
/*      */     case 20:
/* 1229 */       strFieldName = "makeDate";
/* 1230 */       break;
/*      */     case 21:
/* 1232 */       strFieldName = "makeTime";
/* 1233 */       break;
/*      */     case 22:
/* 1235 */       strFieldName = "modifyDate";
/* 1236 */       break;
/*      */     case 23:
/* 1238 */       strFieldName = "modifyTime";
/* 1239 */       break;
/*      */     default:
/* 1241 */       strFieldName = "";
/*      */     }
/* 1243 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1249 */     if (strFieldName.equals("edorNo")) {
/* 1250 */       return 0;
/*      */     }
/* 1252 */     if (strFieldName.equals("edorType")) {
/* 1253 */       return 0;
/*      */     }
/* 1255 */     if (strFieldName.equals("edorCase")) {
/* 1256 */       return 0;
/*      */     }
/* 1258 */     if (strFieldName.equals("operator2")) {
/* 1259 */       return 0;
/*      */     }
/* 1261 */     if (strFieldName.equals("makeDate2")) {
/* 1262 */       return 1;
/*      */     }
/* 1264 */     if (strFieldName.equals("makeTime2")) {
/* 1265 */       return 0;
/*      */     }
/* 1267 */     if (strFieldName.equals("resultID")) {
/* 1268 */       return 0;
/*      */     }
/* 1270 */     if (strFieldName.equals("topicID")) {
/* 1271 */       return 0;
/*      */     }
/* 1273 */     if (strFieldName.equals("questionID")) {
/* 1274 */       return 0;
/*      */     }
/* 1276 */     if (strFieldName.equals("optionID")) {
/* 1277 */       return 0;
/*      */     }
/* 1279 */     if (strFieldName.equals("otherAnswer")) {
/* 1280 */       return 0;
/*      */     }
/* 1282 */     if (strFieldName.equals("agentCode")) {
/* 1283 */       return 0;
/*      */     }
/* 1285 */     if (strFieldName.equals("manageCom")) {
/* 1286 */       return 0;
/*      */     }
/* 1288 */     if (strFieldName.equals("vF01")) {
/* 1289 */       return 0;
/*      */     }
/* 1291 */     if (strFieldName.equals("nF01")) {
/* 1292 */       return 0;
/*      */     }
/* 1294 */     if (strFieldName.equals("iF01")) {
/* 1295 */       return 3;
/*      */     }
/* 1297 */     if (strFieldName.equals("dF02")) {
/* 1298 */       return 4;
/*      */     }
/* 1300 */     if (strFieldName.equals("date01")) {
/* 1301 */       return 1;
/*      */     }
/* 1303 */     if (strFieldName.equals("modifyOperator")) {
/* 1304 */       return 0;
/*      */     }
/* 1306 */     if (strFieldName.equals("operator")) {
/* 1307 */       return 0;
/*      */     }
/* 1309 */     if (strFieldName.equals("makeDate")) {
/* 1310 */       return 1;
/*      */     }
/* 1312 */     if (strFieldName.equals("makeTime")) {
/* 1313 */       return 0;
/*      */     }
/* 1315 */     if (strFieldName.equals("modifyDate")) {
/* 1316 */       return 1;
/*      */     }
/* 1318 */     if (strFieldName.equals("modifyTime")) {
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
/* 1342 */       nFieldType = 1;
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
/* 1366 */       nFieldType = 0;
/* 1367 */       break;
/*      */     case 13:
/* 1369 */       nFieldType = 0;
/* 1370 */       break;
/*      */     case 14:
/* 1372 */       nFieldType = 0;
/* 1373 */       break;
/*      */     case 15:
/* 1375 */       nFieldType = 3;
/* 1376 */       break;
/*      */     case 16:
/* 1378 */       nFieldType = 4;
/* 1379 */       break;
/*      */     case 17:
/* 1381 */       nFieldType = 1;
/* 1382 */       break;
/*      */     case 18:
/* 1384 */       nFieldType = 0;
/* 1385 */       break;
/*      */     case 19:
/* 1387 */       nFieldType = 0;
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
 * Qualified Name:     com.sinosoft.map.lis.schema.MInvResultBSchema
 * JD-Core Version:    0.6.0
 */