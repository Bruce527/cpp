/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MInvResultDB;
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
/*      */ public class MInvResultSchema
/*      */   implements Schema, Cloneable
/*      */ {
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
/*      */   public static final int FIELDNUM = 18;
/*      */   private static String[] PK;
/*   60 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MInvResultSchema()
/*      */   {
/*   67 */     this.mErrors = new CErrors();
/*      */ 
/*   69 */     String[] pk = new String[1];
/*   70 */     pk[0] = "ResultID";
/*      */ 
/*   72 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   79 */     MInvResultSchema cloned = (MInvResultSchema)super.clone();
/*   80 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   81 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   82 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   88 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getResultID()
/*      */   {
/*   93 */     return this.resultID;
/*      */   }
/*      */ 
/*      */   public void setResultID(String aResultID) {
/*   97 */     this.resultID = aResultID;
/*      */   }
/*      */ 
/*      */   public String getTopicID() {
/*  101 */     return this.topicID;
/*      */   }
/*      */ 
/*      */   public void setTopicID(String aTopicID) {
/*  105 */     this.topicID = aTopicID;
/*      */   }
/*      */ 
/*      */   public String getQuestionID() {
/*  109 */     return this.questionID;
/*      */   }
/*      */ 
/*      */   public void setQuestionID(String aQuestionID) {
/*  113 */     this.questionID = aQuestionID;
/*      */   }
/*      */ 
/*      */   public String getOptionID() {
/*  117 */     return this.optionID;
/*      */   }
/*      */ 
/*      */   public void setOptionID(String aOptionID) {
/*  121 */     this.optionID = aOptionID;
/*      */   }
/*      */ 
/*      */   public String getOtherAnswer() {
/*  125 */     return this.otherAnswer;
/*      */   }
/*      */ 
/*      */   public void setOtherAnswer(String aOtherAnswer) {
/*  129 */     this.otherAnswer = aOtherAnswer;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  133 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  137 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  141 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  145 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  149 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  153 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  157 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  161 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  165 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  169 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  173 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  175 */       Integer tInteger = new Integer(aIF01);
/*  176 */       int i = tInteger.intValue();
/*  177 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  183 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  187 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  191 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  193 */       Double tDouble = new Double(aDF02);
/*  194 */       double d = tDouble.doubleValue();
/*  195 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  201 */     if (this.date01 != null) {
/*  202 */       return this.fDate.getString(this.date01);
/*      */     }
/*  204 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  208 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  212 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  214 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  217 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  222 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  226 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  230 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  234 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  238 */     if (this.makeDate != null) {
/*  239 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  241 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  245 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  249 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  251 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  254 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  259 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  263 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  267 */     if (this.modifyDate != null) {
/*  268 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  270 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  274 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  278 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  280 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  283 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  288 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  292 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MInvResultSchema aMInvResultSchema)
/*      */   {
/*  298 */     this.resultID = aMInvResultSchema.getResultID();
/*  299 */     this.topicID = aMInvResultSchema.getTopicID();
/*  300 */     this.questionID = aMInvResultSchema.getQuestionID();
/*  301 */     this.optionID = aMInvResultSchema.getOptionID();
/*  302 */     this.otherAnswer = aMInvResultSchema.getOtherAnswer();
/*  303 */     this.agentCode = aMInvResultSchema.getAgentCode();
/*  304 */     this.manageCom = aMInvResultSchema.getManageCom();
/*  305 */     this.vF01 = aMInvResultSchema.getVF01();
/*  306 */     this.nF01 = aMInvResultSchema.getNF01();
/*  307 */     this.iF01 = aMInvResultSchema.getIF01();
/*  308 */     this.dF02 = aMInvResultSchema.getDF02();
/*  309 */     this.date01 = this.fDate.getDate(aMInvResultSchema.getDate01());
/*  310 */     this.modifyOperator = aMInvResultSchema.getModifyOperator();
/*  311 */     this.operator = aMInvResultSchema.getOperator();
/*  312 */     this.makeDate = this.fDate.getDate(aMInvResultSchema.getMakeDate());
/*  313 */     this.makeTime = aMInvResultSchema.getMakeTime();
/*  314 */     this.modifyDate = this.fDate.getDate(aMInvResultSchema.getModifyDate());
/*  315 */     this.modifyTime = aMInvResultSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  324 */       if (rs.getString("ResultID") == null)
/*  325 */         this.resultID = null;
/*      */       else {
/*  327 */         this.resultID = rs.getString("ResultID").trim();
/*      */       }
/*  329 */       if (rs.getString("TopicID") == null)
/*  330 */         this.topicID = null;
/*      */       else {
/*  332 */         this.topicID = rs.getString("TopicID").trim();
/*      */       }
/*  334 */       if (rs.getString("QuestionID") == null)
/*  335 */         this.questionID = null;
/*      */       else {
/*  337 */         this.questionID = rs.getString("QuestionID").trim();
/*      */       }
/*  339 */       if (rs.getString("OptionID") == null)
/*  340 */         this.optionID = null;
/*      */       else {
/*  342 */         this.optionID = rs.getString("OptionID").trim();
/*      */       }
/*  344 */       if (rs.getString("OtherAnswer") == null)
/*  345 */         this.otherAnswer = null;
/*      */       else {
/*  347 */         this.otherAnswer = rs.getString("OtherAnswer").trim();
/*      */       }
/*  349 */       if (rs.getString("AgentCode") == null)
/*  350 */         this.agentCode = null;
/*      */       else {
/*  352 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/*  354 */       if (rs.getString("ManageCom") == null)
/*  355 */         this.manageCom = null;
/*      */       else {
/*  357 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  359 */       if (rs.getString("VF01") == null)
/*  360 */         this.vF01 = null;
/*      */       else {
/*  362 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  364 */       if (rs.getString("NF01") == null)
/*  365 */         this.nF01 = null;
/*      */       else {
/*  367 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  369 */       this.iF01 = rs.getInt("IF01");
/*  370 */       this.dF02 = rs.getDouble("DF02");
/*  371 */       this.date01 = rs.getDate("Date01");
/*  372 */       if (rs.getString("ModifyOperator") == null)
/*  373 */         this.modifyOperator = null;
/*      */       else {
/*  375 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  377 */       if (rs.getString("Operator") == null)
/*  378 */         this.operator = null;
/*      */       else {
/*  380 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  382 */       this.makeDate = rs.getDate("MakeDate");
/*  383 */       if (rs.getString("MakeTime") == null)
/*  384 */         this.makeTime = null;
/*      */       else {
/*  386 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  388 */       this.modifyDate = rs.getDate("ModifyDate");
/*  389 */       if (rs.getString("ModifyTime") == null)
/*  390 */         this.modifyTime = null;
/*      */       else {
/*  392 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  397 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MInvResult\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  399 */       CError tError = new CError();
/*  400 */       tError.moduleName = "MInvResultSchema";
/*  401 */       tError.functionName = "setSchema";
/*  402 */       tError.errorMessage = sqle.toString();
/*  403 */       this.mErrors.addOneError(tError);
/*  404 */       return false;
/*      */     }
/*  406 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvResultSchema getSchema()
/*      */   {
/*  411 */     MInvResultSchema aMInvResultSchema = new MInvResultSchema();
/*  412 */     aMInvResultSchema.setSchema(this);
/*  413 */     return aMInvResultSchema;
/*      */   }
/*      */ 
/*      */   public MInvResultDB getDB()
/*      */   {
/*  418 */     MInvResultDB aDBOper = new MInvResultDB();
/*  419 */     aDBOper.setSchema(this);
/*  420 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  427 */     StringBuffer strReturn = new StringBuffer(256);
/*  428 */     strReturn.append(StrTool.cTrim(this.resultID)); strReturn.append("|");
/*  429 */     strReturn.append(StrTool.cTrim(this.topicID)); strReturn.append("|");
/*  430 */     strReturn.append(StrTool.cTrim(this.questionID)); strReturn.append("|");
/*  431 */     strReturn.append(StrTool.cTrim(this.optionID)); strReturn.append("|");
/*  432 */     strReturn.append(StrTool.cTrim(this.otherAnswer)); strReturn.append("|");
/*  433 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/*  434 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  435 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  436 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  437 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  438 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  439 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  440 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  441 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  442 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  443 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  444 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  445 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  446 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  454 */       this.resultID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  455 */       this.topicID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  456 */       this.questionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  457 */       this.optionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  458 */       this.otherAnswer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  459 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  460 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  461 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  462 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  463 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/*  464 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).doubleValue();
/*  465 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
/*  466 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  467 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  468 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  469 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  470 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  471 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  476 */       CError tError = new CError();
/*  477 */       tError.moduleName = "MInvResultSchema";
/*  478 */       tError.functionName = "decode";
/*  479 */       tError.errorMessage = ex.toString();
/*  480 */       this.mErrors.addOneError(tError);
/*      */ 
/*  482 */       return false;
/*      */     }
/*  484 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  490 */     String strReturn = "";
/*  491 */     if (FCode.equalsIgnoreCase("resultID"))
/*      */     {
/*  493 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.resultID));
/*      */     }
/*  495 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/*  497 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.topicID));
/*      */     }
/*  499 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  501 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionID));
/*      */     }
/*  503 */     if (FCode.equalsIgnoreCase("optionID"))
/*      */     {
/*  505 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.optionID));
/*      */     }
/*  507 */     if (FCode.equalsIgnoreCase("otherAnswer"))
/*      */     {
/*  509 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.otherAnswer));
/*      */     }
/*  511 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  513 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/*  515 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  517 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  519 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  521 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  523 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  525 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  527 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  529 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  531 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  533 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  535 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  537 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  539 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  541 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  543 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  545 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  547 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  549 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  551 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  553 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  555 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  557 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  559 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  561 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  563 */     if (strReturn.equals(""))
/*      */     {
/*  565 */       strReturn = "null";
/*      */     }
/*      */ 
/*  568 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  575 */     String strFieldValue = "";
/*  576 */     switch (nFieldIndex) {
/*      */     case 0:
/*  578 */       strFieldValue = StrTool.GBKToUnicode(this.resultID);
/*  579 */       break;
/*      */     case 1:
/*  581 */       strFieldValue = StrTool.GBKToUnicode(this.topicID);
/*  582 */       break;
/*      */     case 2:
/*  584 */       strFieldValue = StrTool.GBKToUnicode(this.questionID);
/*  585 */       break;
/*      */     case 3:
/*  587 */       strFieldValue = StrTool.GBKToUnicode(this.optionID);
/*  588 */       break;
/*      */     case 4:
/*  590 */       strFieldValue = StrTool.GBKToUnicode(this.otherAnswer);
/*  591 */       break;
/*      */     case 5:
/*  593 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/*  594 */       break;
/*      */     case 6:
/*  596 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  597 */       break;
/*      */     case 7:
/*  599 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  600 */       break;
/*      */     case 8:
/*  602 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  603 */       break;
/*      */     case 9:
/*  605 */       strFieldValue = String.valueOf(this.iF01);
/*  606 */       break;
/*      */     case 10:
/*  608 */       strFieldValue = String.valueOf(this.dF02);
/*  609 */       break;
/*      */     case 11:
/*  611 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  612 */       break;
/*      */     case 12:
/*  614 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  615 */       break;
/*      */     case 13:
/*  617 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  618 */       break;
/*      */     case 14:
/*  620 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  621 */       break;
/*      */     case 15:
/*  623 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  624 */       break;
/*      */     case 16:
/*  626 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  627 */       break;
/*      */     case 17:
/*  629 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  630 */       break;
/*      */     default:
/*  632 */       strFieldValue = "";
/*      */     }
/*  634 */     if (strFieldValue.equals("")) {
/*  635 */       strFieldValue = "null";
/*      */     }
/*  637 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  643 */     if (StrTool.cTrim(FCode).equals("")) {
/*  644 */       return false;
/*      */     }
/*  646 */     if (FCode.equalsIgnoreCase("resultID"))
/*      */     {
/*  648 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  650 */         this.resultID = FValue.trim();
/*      */       }
/*      */       else
/*  653 */         this.resultID = null;
/*      */     }
/*  655 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/*  657 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  659 */         this.topicID = FValue.trim();
/*      */       }
/*      */       else
/*  662 */         this.topicID = null;
/*      */     }
/*  664 */     if (FCode.equalsIgnoreCase("questionID"))
/*      */     {
/*  666 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  668 */         this.questionID = FValue.trim();
/*      */       }
/*      */       else
/*  671 */         this.questionID = null;
/*      */     }
/*  673 */     if (FCode.equalsIgnoreCase("optionID"))
/*      */     {
/*  675 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  677 */         this.optionID = FValue.trim();
/*      */       }
/*      */       else
/*  680 */         this.optionID = null;
/*      */     }
/*  682 */     if (FCode.equalsIgnoreCase("otherAnswer"))
/*      */     {
/*  684 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  686 */         this.otherAnswer = FValue.trim();
/*      */       }
/*      */       else
/*  689 */         this.otherAnswer = null;
/*      */     }
/*  691 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  693 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  695 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/*  698 */         this.agentCode = null;
/*      */     }
/*  700 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  702 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  704 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  707 */         this.manageCom = null;
/*      */     }
/*  709 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  711 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  713 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/*  716 */         this.vF01 = null;
/*      */     }
/*  718 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  720 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  722 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/*  725 */         this.nF01 = null;
/*      */     }
/*  727 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  729 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  731 */         Integer tInteger = new Integer(FValue);
/*  732 */         int i = tInteger.intValue();
/*  733 */         this.iF01 = i;
/*      */       }
/*      */     }
/*  736 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  738 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  740 */         Double tDouble = new Double(FValue);
/*  741 */         double d = tDouble.doubleValue();
/*  742 */         this.dF02 = d;
/*      */       }
/*      */     }
/*  745 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  747 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  749 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  752 */         this.date01 = null;
/*      */     }
/*  754 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  756 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  758 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  761 */         this.modifyOperator = null;
/*      */     }
/*  763 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  765 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  767 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  770 */         this.operator = null;
/*      */     }
/*  772 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  774 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  776 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  779 */         this.makeDate = null;
/*      */     }
/*  781 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  783 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  785 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  788 */         this.makeTime = null;
/*      */     }
/*  790 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  792 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  794 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  797 */         this.modifyDate = null;
/*      */     }
/*  799 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  801 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  803 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  806 */         this.modifyTime = null;
/*      */     }
/*  808 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  813 */     if (otherObject == null) return false;
/*  814 */     if (this == otherObject) return true;
/*  815 */     if (getClass() != otherObject.getClass()) return false;
/*  816 */     MInvResultSchema other = (MInvResultSchema)otherObject;
/*  817 */     if ((this.resultID == null) && (other.getResultID() != null)) return false;
/*  818 */     if ((this.resultID != null) && (!this.resultID.equals(other.getResultID()))) return false;
/*  819 */     if ((this.topicID == null) && (other.getTopicID() != null)) return false;
/*  820 */     if ((this.topicID != null) && (!this.topicID.equals(other.getTopicID()))) return false;
/*  821 */     if ((this.questionID == null) && (other.getQuestionID() != null)) return false;
/*  822 */     if ((this.questionID != null) && (!this.questionID.equals(other.getQuestionID()))) return false;
/*  823 */     if ((this.optionID == null) && (other.getOptionID() != null)) return false;
/*  824 */     if ((this.optionID != null) && (!this.optionID.equals(other.getOptionID()))) return false;
/*  825 */     if ((this.otherAnswer == null) && (other.getOtherAnswer() != null)) return false;
/*  826 */     if ((this.otherAnswer != null) && (!this.otherAnswer.equals(other.getOtherAnswer()))) return false;
/*  827 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/*  828 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/*  829 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/*  830 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/*  831 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/*  832 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/*  833 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/*  834 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/*  835 */     if (this.iF01 != other.getIF01()) return false;
/*  836 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/*  837 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/*  838 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/*  839 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/*  840 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/*  841 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  842 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  843 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  844 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  845 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  846 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  847 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  848 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  849 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  850 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  857 */     return 18;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  863 */     if (strFieldName.equals("resultID")) {
/*  864 */       return 0;
/*      */     }
/*  866 */     if (strFieldName.equals("topicID")) {
/*  867 */       return 1;
/*      */     }
/*  869 */     if (strFieldName.equals("questionID")) {
/*  870 */       return 2;
/*      */     }
/*  872 */     if (strFieldName.equals("optionID")) {
/*  873 */       return 3;
/*      */     }
/*  875 */     if (strFieldName.equals("otherAnswer")) {
/*  876 */       return 4;
/*      */     }
/*  878 */     if (strFieldName.equals("agentCode")) {
/*  879 */       return 5;
/*      */     }
/*  881 */     if (strFieldName.equals("manageCom")) {
/*  882 */       return 6;
/*      */     }
/*  884 */     if (strFieldName.equals("vF01")) {
/*  885 */       return 7;
/*      */     }
/*  887 */     if (strFieldName.equals("nF01")) {
/*  888 */       return 8;
/*      */     }
/*  890 */     if (strFieldName.equals("iF01")) {
/*  891 */       return 9;
/*      */     }
/*  893 */     if (strFieldName.equals("dF02")) {
/*  894 */       return 10;
/*      */     }
/*  896 */     if (strFieldName.equals("date01")) {
/*  897 */       return 11;
/*      */     }
/*  899 */     if (strFieldName.equals("modifyOperator")) {
/*  900 */       return 12;
/*      */     }
/*  902 */     if (strFieldName.equals("operator")) {
/*  903 */       return 13;
/*      */     }
/*  905 */     if (strFieldName.equals("makeDate")) {
/*  906 */       return 14;
/*      */     }
/*  908 */     if (strFieldName.equals("makeTime")) {
/*  909 */       return 15;
/*      */     }
/*  911 */     if (strFieldName.equals("modifyDate")) {
/*  912 */       return 16;
/*      */     }
/*  914 */     if (strFieldName.equals("modifyTime")) {
/*  915 */       return 17;
/*      */     }
/*  917 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  923 */     String strFieldName = "";
/*  924 */     switch (nFieldIndex) {
/*      */     case 0:
/*  926 */       strFieldName = "resultID";
/*  927 */       break;
/*      */     case 1:
/*  929 */       strFieldName = "topicID";
/*  930 */       break;
/*      */     case 2:
/*  932 */       strFieldName = "questionID";
/*  933 */       break;
/*      */     case 3:
/*  935 */       strFieldName = "optionID";
/*  936 */       break;
/*      */     case 4:
/*  938 */       strFieldName = "otherAnswer";
/*  939 */       break;
/*      */     case 5:
/*  941 */       strFieldName = "agentCode";
/*  942 */       break;
/*      */     case 6:
/*  944 */       strFieldName = "manageCom";
/*  945 */       break;
/*      */     case 7:
/*  947 */       strFieldName = "vF01";
/*  948 */       break;
/*      */     case 8:
/*  950 */       strFieldName = "nF01";
/*  951 */       break;
/*      */     case 9:
/*  953 */       strFieldName = "iF01";
/*  954 */       break;
/*      */     case 10:
/*  956 */       strFieldName = "dF02";
/*  957 */       break;
/*      */     case 11:
/*  959 */       strFieldName = "date01";
/*  960 */       break;
/*      */     case 12:
/*  962 */       strFieldName = "modifyOperator";
/*  963 */       break;
/*      */     case 13:
/*  965 */       strFieldName = "operator";
/*  966 */       break;
/*      */     case 14:
/*  968 */       strFieldName = "makeDate";
/*  969 */       break;
/*      */     case 15:
/*  971 */       strFieldName = "makeTime";
/*  972 */       break;
/*      */     case 16:
/*  974 */       strFieldName = "modifyDate";
/*  975 */       break;
/*      */     case 17:
/*  977 */       strFieldName = "modifyTime";
/*  978 */       break;
/*      */     default:
/*  980 */       strFieldName = "";
/*      */     }
/*  982 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  988 */     if (strFieldName.equals("resultID")) {
/*  989 */       return 0;
/*      */     }
/*  991 */     if (strFieldName.equals("topicID")) {
/*  992 */       return 0;
/*      */     }
/*  994 */     if (strFieldName.equals("questionID")) {
/*  995 */       return 0;
/*      */     }
/*  997 */     if (strFieldName.equals("optionID")) {
/*  998 */       return 0;
/*      */     }
/* 1000 */     if (strFieldName.equals("otherAnswer")) {
/* 1001 */       return 0;
/*      */     }
/* 1003 */     if (strFieldName.equals("agentCode")) {
/* 1004 */       return 0;
/*      */     }
/* 1006 */     if (strFieldName.equals("manageCom")) {
/* 1007 */       return 0;
/*      */     }
/* 1009 */     if (strFieldName.equals("vF01")) {
/* 1010 */       return 0;
/*      */     }
/* 1012 */     if (strFieldName.equals("nF01")) {
/* 1013 */       return 0;
/*      */     }
/* 1015 */     if (strFieldName.equals("iF01")) {
/* 1016 */       return 3;
/*      */     }
/* 1018 */     if (strFieldName.equals("dF02")) {
/* 1019 */       return 4;
/*      */     }
/* 1021 */     if (strFieldName.equals("date01")) {
/* 1022 */       return 1;
/*      */     }
/* 1024 */     if (strFieldName.equals("modifyOperator")) {
/* 1025 */       return 0;
/*      */     }
/* 1027 */     if (strFieldName.equals("operator")) {
/* 1028 */       return 0;
/*      */     }
/* 1030 */     if (strFieldName.equals("makeDate")) {
/* 1031 */       return 1;
/*      */     }
/* 1033 */     if (strFieldName.equals("makeTime")) {
/* 1034 */       return 0;
/*      */     }
/* 1036 */     if (strFieldName.equals("modifyDate")) {
/* 1037 */       return 1;
/*      */     }
/* 1039 */     if (strFieldName.equals("modifyTime")) {
/* 1040 */       return 0;
/*      */     }
/* 1042 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1048 */     int nFieldType = -1;
/* 1049 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1051 */       nFieldType = 0;
/* 1052 */       break;
/*      */     case 1:
/* 1054 */       nFieldType = 0;
/* 1055 */       break;
/*      */     case 2:
/* 1057 */       nFieldType = 0;
/* 1058 */       break;
/*      */     case 3:
/* 1060 */       nFieldType = 0;
/* 1061 */       break;
/*      */     case 4:
/* 1063 */       nFieldType = 0;
/* 1064 */       break;
/*      */     case 5:
/* 1066 */       nFieldType = 0;
/* 1067 */       break;
/*      */     case 6:
/* 1069 */       nFieldType = 0;
/* 1070 */       break;
/*      */     case 7:
/* 1072 */       nFieldType = 0;
/* 1073 */       break;
/*      */     case 8:
/* 1075 */       nFieldType = 0;
/* 1076 */       break;
/*      */     case 9:
/* 1078 */       nFieldType = 3;
/* 1079 */       break;
/*      */     case 10:
/* 1081 */       nFieldType = 4;
/* 1082 */       break;
/*      */     case 11:
/* 1084 */       nFieldType = 1;
/* 1085 */       break;
/*      */     case 12:
/* 1087 */       nFieldType = 0;
/* 1088 */       break;
/*      */     case 13:
/* 1090 */       nFieldType = 0;
/* 1091 */       break;
/*      */     case 14:
/* 1093 */       nFieldType = 1;
/* 1094 */       break;
/*      */     case 15:
/* 1096 */       nFieldType = 0;
/* 1097 */       break;
/*      */     case 16:
/* 1099 */       nFieldType = 1;
/* 1100 */       break;
/*      */     case 17:
/* 1102 */       nFieldType = 0;
/* 1103 */       break;
/*      */     default:
/* 1105 */       nFieldType = -1;
/*      */     }
/* 1107 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MInvResultSchema
 * JD-Core Version:    0.6.0
 */