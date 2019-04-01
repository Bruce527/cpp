/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPCustImpResultDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPCustImpResultSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String resultId;
/*      */   private String impartId;
/*      */   private String questionId;
/*      */   private String questionType;
/*      */   private String queInnerOrder;
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String customerNo;
/*      */   private String customerId;
/*      */   private String optionId;
/*      */   private String answer;
/*      */   private String operator;
/*      */   private String manageCom;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 18;
/*      */   private static String[] PK;
/*   63 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPCustImpResultSchema()
/*      */   {
/*   70 */     this.mErrors = new CErrors();
/*      */ 
/*   72 */     String[] pk = new String[1];
/*   73 */     pk[0] = "ResultId";
/*      */ 
/*   75 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   82 */     LNPCustImpResultSchema cloned = (LNPCustImpResultSchema)super.clone();
/*   83 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   84 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   85 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   91 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getResultId()
/*      */   {
/*   96 */     return this.resultId;
/*      */   }
/*      */ 
/*      */   public void setResultId(String aResultId) {
/*  100 */     this.resultId = aResultId;
/*      */   }
/*      */ 
/*      */   public String getImpartId() {
/*  104 */     return this.impartId;
/*      */   }
/*      */ 
/*      */   public void setImpartId(String aImpartId) {
/*  108 */     this.impartId = aImpartId;
/*      */   }
/*      */ 
/*      */   public String getQuestionId() {
/*  112 */     return this.questionId;
/*      */   }
/*      */ 
/*      */   public void setQuestionId(String aQuestionId) {
/*  116 */     this.questionId = aQuestionId;
/*      */   }
/*      */ 
/*      */   public String getQuestionType() {
/*  120 */     return this.questionType;
/*      */   }
/*      */ 
/*      */   public void setQuestionType(String aQuestionType) {
/*  124 */     this.questionType = aQuestionType;
/*      */   }
/*      */ 
/*      */   public String getQueInnerOrder() {
/*  128 */     return this.queInnerOrder;
/*      */   }
/*      */ 
/*      */   public void setQueInnerOrder(String aQueInnerOrder) {
/*  132 */     this.queInnerOrder = aQueInnerOrder;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo() {
/*  136 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  140 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  144 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  148 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  152 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  156 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public String getCustomerNo() {
/*  160 */     return this.customerNo;
/*      */   }
/*      */ 
/*      */   public void setCustomerNo(String aCustomerNo) {
/*  164 */     this.customerNo = aCustomerNo;
/*      */   }
/*      */ 
/*      */   public String getCustomerId() {
/*  168 */     return this.customerId;
/*      */   }
/*      */ 
/*      */   public void setCustomerId(String aCustomerId) {
/*  172 */     this.customerId = aCustomerId;
/*      */   }
/*      */ 
/*      */   public String getOptionId() {
/*  176 */     return this.optionId;
/*      */   }
/*      */ 
/*      */   public void setOptionId(String aOptionId) {
/*  180 */     this.optionId = aOptionId;
/*      */   }
/*      */ 
/*      */   public String getAnswer() {
/*  184 */     return this.answer;
/*      */   }
/*      */ 
/*      */   public void setAnswer(String aAnswer) {
/*  188 */     this.answer = aAnswer;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  192 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  196 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  200 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  204 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  208 */     if (this.makeDate != null) {
/*  209 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  211 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  215 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  219 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  221 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  224 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  229 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  233 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  237 */     if (this.modifyDate != null) {
/*  238 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  240 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  244 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  248 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  250 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  253 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  258 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  262 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPCustImpResultSchema aLNPCustImpResultSchema)
/*      */   {
/*  268 */     this.resultId = aLNPCustImpResultSchema.getResultId();
/*  269 */     this.impartId = aLNPCustImpResultSchema.getImpartId();
/*  270 */     this.questionId = aLNPCustImpResultSchema.getQuestionId();
/*  271 */     this.questionType = aLNPCustImpResultSchema.getQuestionType();
/*  272 */     this.queInnerOrder = aLNPCustImpResultSchema.getQueInnerOrder();
/*  273 */     this.grpContNo = aLNPCustImpResultSchema.getGrpContNo();
/*  274 */     this.contNo = aLNPCustImpResultSchema.getContNo();
/*  275 */     this.proposalContNo = aLNPCustImpResultSchema.getProposalContNo();
/*  276 */     this.customerNo = aLNPCustImpResultSchema.getCustomerNo();
/*  277 */     this.customerId = aLNPCustImpResultSchema.getCustomerId();
/*  278 */     this.optionId = aLNPCustImpResultSchema.getOptionId();
/*  279 */     this.answer = aLNPCustImpResultSchema.getAnswer();
/*  280 */     this.operator = aLNPCustImpResultSchema.getOperator();
/*  281 */     this.manageCom = aLNPCustImpResultSchema.getManageCom();
/*  282 */     this.makeDate = this.fDate.getDate(aLNPCustImpResultSchema.getMakeDate());
/*  283 */     this.makeTime = aLNPCustImpResultSchema.getMakeTime();
/*  284 */     this.modifyDate = this.fDate.getDate(aLNPCustImpResultSchema.getModifyDate());
/*  285 */     this.modifyTime = aLNPCustImpResultSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  294 */       if (rs.getString("ResultId") == null)
/*  295 */         this.resultId = null;
/*      */       else {
/*  297 */         this.resultId = rs.getString("ResultId").trim();
/*      */       }
/*  299 */       if (rs.getString("ImpartId") == null)
/*  300 */         this.impartId = null;
/*      */       else {
/*  302 */         this.impartId = rs.getString("ImpartId").trim();
/*      */       }
/*  304 */       if (rs.getString("QuestionId") == null)
/*  305 */         this.questionId = null;
/*      */       else {
/*  307 */         this.questionId = rs.getString("QuestionId").trim();
/*      */       }
/*  309 */       if (rs.getString("QuestionType") == null)
/*  310 */         this.questionType = null;
/*      */       else {
/*  312 */         this.questionType = rs.getString("QuestionType").trim();
/*      */       }
/*  314 */       if (rs.getString("QueInnerOrder") == null)
/*  315 */         this.queInnerOrder = null;
/*      */       else {
/*  317 */         this.queInnerOrder = rs.getString("QueInnerOrder").trim();
/*      */       }
/*  319 */       if (rs.getString("GrpContNo") == null)
/*  320 */         this.grpContNo = null;
/*      */       else {
/*  322 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  324 */       if (rs.getString("ContNo") == null)
/*  325 */         this.contNo = null;
/*      */       else {
/*  327 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  329 */       if (rs.getString("ProposalContNo") == null)
/*  330 */         this.proposalContNo = null;
/*      */       else {
/*  332 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  334 */       if (rs.getString("CustomerNo") == null)
/*  335 */         this.customerNo = null;
/*      */       else {
/*  337 */         this.customerNo = rs.getString("CustomerNo").trim();
/*      */       }
/*  339 */       if (rs.getString("CustomerId") == null)
/*  340 */         this.customerId = null;
/*      */       else {
/*  342 */         this.customerId = rs.getString("CustomerId").trim();
/*      */       }
/*  344 */       if (rs.getString("OptionId") == null)
/*  345 */         this.optionId = null;
/*      */       else {
/*  347 */         this.optionId = rs.getString("OptionId").trim();
/*      */       }
/*  349 */       if (rs.getString("Answer") == null)
/*  350 */         this.answer = null;
/*      */       else {
/*  352 */         this.answer = rs.getString("Answer").trim();
/*      */       }
/*  354 */       if (rs.getString("Operator") == null)
/*  355 */         this.operator = null;
/*      */       else {
/*  357 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  359 */       if (rs.getString("ManageCom") == null)
/*  360 */         this.manageCom = null;
/*      */       else {
/*  362 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  364 */       this.makeDate = rs.getDate("MakeDate");
/*  365 */       if (rs.getString("MakeTime") == null)
/*  366 */         this.makeTime = null;
/*      */       else {
/*  368 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  370 */       this.modifyDate = rs.getDate("ModifyDate");
/*  371 */       if (rs.getString("ModifyTime") == null)
/*  372 */         this.modifyTime = null;
/*      */       else {
/*  374 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  379 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPCustImpResult\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/*  381 */       CError tError = new CError();
/*  382 */       tError.moduleName = "LNPCustImpResultSchema";
/*  383 */       tError.functionName = "setSchema";
/*  384 */       tError.errorMessage = sqle.toString();
/*  385 */       this.mErrors.addOneError(tError);
/*  386 */       return false;
/*      */     }
/*  388 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPCustImpResultSchema getSchema()
/*      */   {
/*  393 */     LNPCustImpResultSchema aLNPCustImpResultSchema = new LNPCustImpResultSchema();
/*  394 */     aLNPCustImpResultSchema.setSchema(this);
/*  395 */     return aLNPCustImpResultSchema;
/*      */   }
/*      */ 
/*      */   public LNPCustImpResultDB getDB()
/*      */   {
/*  400 */     LNPCustImpResultDB aDBOper = new LNPCustImpResultDB();
/*  401 */     aDBOper.setSchema(this);
/*  402 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  409 */     StringBuffer strReturn = new StringBuffer(256);
/*  410 */     strReturn.append(StrTool.cTrim(this.resultId)); strReturn.append("|");
/*  411 */     strReturn.append(StrTool.cTrim(this.impartId)); strReturn.append("|");
/*  412 */     strReturn.append(StrTool.cTrim(this.questionId)); strReturn.append("|");
/*  413 */     strReturn.append(StrTool.cTrim(this.questionType)); strReturn.append("|");
/*  414 */     strReturn.append(StrTool.cTrim(this.queInnerOrder)); strReturn.append("|");
/*  415 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/*  416 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/*  417 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/*  418 */     strReturn.append(StrTool.cTrim(this.customerNo)); strReturn.append("|");
/*  419 */     strReturn.append(StrTool.cTrim(this.customerId)); strReturn.append("|");
/*  420 */     strReturn.append(StrTool.cTrim(this.optionId)); strReturn.append("|");
/*  421 */     strReturn.append(StrTool.cTrim(this.answer)); strReturn.append("|");
/*  422 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  423 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  424 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  425 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  426 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  427 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  428 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  436 */       this.resultId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  437 */       this.impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  438 */       this.questionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  439 */       this.questionType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  440 */       this.queInnerOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  441 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  442 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  443 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  444 */       this.customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  445 */       this.customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  446 */       this.optionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  447 */       this.answer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  448 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  449 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  450 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  451 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  452 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  453 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  458 */       CError tError = new CError();
/*  459 */       tError.moduleName = "LNPCustImpResultSchema";
/*  460 */       tError.functionName = "decode";
/*  461 */       tError.errorMessage = ex.toString();
/*  462 */       this.mErrors.addOneError(tError);
/*      */ 
/*  464 */       return false;
/*      */     }
/*  466 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  472 */     String strReturn = "";
/*  473 */     if (FCode.equalsIgnoreCase("resultId"))
/*      */     {
/*  475 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.resultId));
/*      */     }
/*  477 */     if (FCode.equalsIgnoreCase("impartId"))
/*      */     {
/*  479 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartId));
/*      */     }
/*  481 */     if (FCode.equalsIgnoreCase("questionId"))
/*      */     {
/*  483 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionId));
/*      */     }
/*  485 */     if (FCode.equalsIgnoreCase("questionType"))
/*      */     {
/*  487 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionType));
/*      */     }
/*  489 */     if (FCode.equalsIgnoreCase("queInnerOrder"))
/*      */     {
/*  491 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.queInnerOrder));
/*      */     }
/*  493 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  495 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  497 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  499 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  501 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  503 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  505 */     if (FCode.equalsIgnoreCase("customerNo"))
/*      */     {
/*  507 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerNo));
/*      */     }
/*  509 */     if (FCode.equalsIgnoreCase("customerId"))
/*      */     {
/*  511 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerId));
/*      */     }
/*  513 */     if (FCode.equalsIgnoreCase("optionId"))
/*      */     {
/*  515 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.optionId));
/*      */     }
/*  517 */     if (FCode.equalsIgnoreCase("answer"))
/*      */     {
/*  519 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.answer));
/*      */     }
/*  521 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  523 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  525 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  527 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  529 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  531 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  533 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  535 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  537 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  539 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  541 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  543 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  545 */     if (strReturn.equals(""))
/*      */     {
/*  547 */       strReturn = "null";
/*      */     }
/*      */ 
/*  550 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  557 */     String strFieldValue = "";
/*  558 */     switch (nFieldIndex) {
/*      */     case 0:
/*  560 */       strFieldValue = StrTool.GBKToUnicode(this.resultId);
/*  561 */       break;
/*      */     case 1:
/*  563 */       strFieldValue = StrTool.GBKToUnicode(this.impartId);
/*  564 */       break;
/*      */     case 2:
/*  566 */       strFieldValue = StrTool.GBKToUnicode(this.questionId);
/*  567 */       break;
/*      */     case 3:
/*  569 */       strFieldValue = StrTool.GBKToUnicode(this.questionType);
/*  570 */       break;
/*      */     case 4:
/*  572 */       strFieldValue = StrTool.GBKToUnicode(this.queInnerOrder);
/*  573 */       break;
/*      */     case 5:
/*  575 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  576 */       break;
/*      */     case 6:
/*  578 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  579 */       break;
/*      */     case 7:
/*  581 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  582 */       break;
/*      */     case 8:
/*  584 */       strFieldValue = StrTool.GBKToUnicode(this.customerNo);
/*  585 */       break;
/*      */     case 9:
/*  587 */       strFieldValue = StrTool.GBKToUnicode(this.customerId);
/*  588 */       break;
/*      */     case 10:
/*  590 */       strFieldValue = StrTool.GBKToUnicode(this.optionId);
/*  591 */       break;
/*      */     case 11:
/*  593 */       strFieldValue = StrTool.GBKToUnicode(this.answer);
/*  594 */       break;
/*      */     case 12:
/*  596 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  597 */       break;
/*      */     case 13:
/*  599 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  600 */       break;
/*      */     case 14:
/*  602 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  603 */       break;
/*      */     case 15:
/*  605 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  606 */       break;
/*      */     case 16:
/*  608 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  609 */       break;
/*      */     case 17:
/*  611 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  612 */       break;
/*      */     default:
/*  614 */       strFieldValue = "";
/*      */     }
/*  616 */     if (strFieldValue.equals("")) {
/*  617 */       strFieldValue = "null";
/*      */     }
/*  619 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  625 */     if (StrTool.cTrim(FCode).equals("")) {
/*  626 */       return false;
/*      */     }
/*  628 */     if (FCode.equalsIgnoreCase("resultId"))
/*      */     {
/*  630 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  632 */         this.resultId = FValue.trim();
/*      */       }
/*      */       else
/*  635 */         this.resultId = null;
/*      */     }
/*  637 */     if (FCode.equalsIgnoreCase("impartId"))
/*      */     {
/*  639 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  641 */         this.impartId = FValue.trim();
/*      */       }
/*      */       else
/*  644 */         this.impartId = null;
/*      */     }
/*  646 */     if (FCode.equalsIgnoreCase("questionId"))
/*      */     {
/*  648 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  650 */         this.questionId = FValue.trim();
/*      */       }
/*      */       else
/*  653 */         this.questionId = null;
/*      */     }
/*  655 */     if (FCode.equalsIgnoreCase("questionType"))
/*      */     {
/*  657 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  659 */         this.questionType = FValue.trim();
/*      */       }
/*      */       else
/*  662 */         this.questionType = null;
/*      */     }
/*  664 */     if (FCode.equalsIgnoreCase("queInnerOrder"))
/*      */     {
/*  666 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  668 */         this.queInnerOrder = FValue.trim();
/*      */       }
/*      */       else
/*  671 */         this.queInnerOrder = null;
/*      */     }
/*  673 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  675 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  677 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/*  680 */         this.grpContNo = null;
/*      */     }
/*  682 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  684 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  686 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/*  689 */         this.contNo = null;
/*      */     }
/*  691 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  693 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  695 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/*  698 */         this.proposalContNo = null;
/*      */     }
/*  700 */     if (FCode.equalsIgnoreCase("customerNo"))
/*      */     {
/*  702 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  704 */         this.customerNo = FValue.trim();
/*      */       }
/*      */       else
/*  707 */         this.customerNo = null;
/*      */     }
/*  709 */     if (FCode.equalsIgnoreCase("customerId"))
/*      */     {
/*  711 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  713 */         this.customerId = FValue.trim();
/*      */       }
/*      */       else
/*  716 */         this.customerId = null;
/*      */     }
/*  718 */     if (FCode.equalsIgnoreCase("optionId"))
/*      */     {
/*  720 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  722 */         this.optionId = FValue.trim();
/*      */       }
/*      */       else
/*  725 */         this.optionId = null;
/*      */     }
/*  727 */     if (FCode.equalsIgnoreCase("answer"))
/*      */     {
/*  729 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  731 */         this.answer = FValue.trim();
/*      */       }
/*      */       else
/*  734 */         this.answer = null;
/*      */     }
/*  736 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  738 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  740 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  743 */         this.operator = null;
/*      */     }
/*  745 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  747 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  749 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  752 */         this.manageCom = null;
/*      */     }
/*  754 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  756 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  758 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  761 */         this.makeDate = null;
/*      */     }
/*  763 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  765 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  767 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  770 */         this.makeTime = null;
/*      */     }
/*  772 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  774 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  776 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  779 */         this.modifyDate = null;
/*      */     }
/*  781 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  783 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  785 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  788 */         this.modifyTime = null;
/*      */     }
/*  790 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  795 */     if (otherObject == null) return false;
/*  796 */     if (this == otherObject) return true;
/*  797 */     if (getClass() != otherObject.getClass()) return false;
/*  798 */     LNPCustImpResultSchema other = (LNPCustImpResultSchema)otherObject;
/*  799 */     if ((this.resultId == null) && (other.getResultId() != null)) return false;
/*  800 */     if ((this.resultId != null) && (!this.resultId.equals(other.getResultId()))) return false;
/*  801 */     if ((this.impartId == null) && (other.getImpartId() != null)) return false;
/*  802 */     if ((this.impartId != null) && (!this.impartId.equals(other.getImpartId()))) return false;
/*  803 */     if ((this.questionId == null) && (other.getQuestionId() != null)) return false;
/*  804 */     if ((this.questionId != null) && (!this.questionId.equals(other.getQuestionId()))) return false;
/*  805 */     if ((this.questionType == null) && (other.getQuestionType() != null)) return false;
/*  806 */     if ((this.questionType != null) && (!this.questionType.equals(other.getQuestionType()))) return false;
/*  807 */     if ((this.queInnerOrder == null) && (other.getQueInnerOrder() != null)) return false;
/*  808 */     if ((this.queInnerOrder != null) && (!this.queInnerOrder.equals(other.getQueInnerOrder()))) return false;
/*  809 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/*  810 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/*  811 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/*  812 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/*  813 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/*  814 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/*  815 */     if ((this.customerNo == null) && (other.getCustomerNo() != null)) return false;
/*  816 */     if ((this.customerNo != null) && (!this.customerNo.equals(other.getCustomerNo()))) return false;
/*  817 */     if ((this.customerId == null) && (other.getCustomerId() != null)) return false;
/*  818 */     if ((this.customerId != null) && (!this.customerId.equals(other.getCustomerId()))) return false;
/*  819 */     if ((this.optionId == null) && (other.getOptionId() != null)) return false;
/*  820 */     if ((this.optionId != null) && (!this.optionId.equals(other.getOptionId()))) return false;
/*  821 */     if ((this.answer == null) && (other.getAnswer() != null)) return false;
/*  822 */     if ((this.answer != null) && (!this.answer.equals(other.getAnswer()))) return false;
/*  823 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  824 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  825 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/*  826 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/*  827 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  828 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  829 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  830 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  831 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  832 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  833 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  834 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  841 */     return 18;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  847 */     if (strFieldName.equals("resultId")) {
/*  848 */       return 0;
/*      */     }
/*  850 */     if (strFieldName.equals("impartId")) {
/*  851 */       return 1;
/*      */     }
/*  853 */     if (strFieldName.equals("questionId")) {
/*  854 */       return 2;
/*      */     }
/*  856 */     if (strFieldName.equals("questionType")) {
/*  857 */       return 3;
/*      */     }
/*  859 */     if (strFieldName.equals("queInnerOrder")) {
/*  860 */       return 4;
/*      */     }
/*  862 */     if (strFieldName.equals("grpContNo")) {
/*  863 */       return 5;
/*      */     }
/*  865 */     if (strFieldName.equals("contNo")) {
/*  866 */       return 6;
/*      */     }
/*  868 */     if (strFieldName.equals("proposalContNo")) {
/*  869 */       return 7;
/*      */     }
/*  871 */     if (strFieldName.equals("customerNo")) {
/*  872 */       return 8;
/*      */     }
/*  874 */     if (strFieldName.equals("customerId")) {
/*  875 */       return 9;
/*      */     }
/*  877 */     if (strFieldName.equals("optionId")) {
/*  878 */       return 10;
/*      */     }
/*  880 */     if (strFieldName.equals("answer")) {
/*  881 */       return 11;
/*      */     }
/*  883 */     if (strFieldName.equals("operator")) {
/*  884 */       return 12;
/*      */     }
/*  886 */     if (strFieldName.equals("manageCom")) {
/*  887 */       return 13;
/*      */     }
/*  889 */     if (strFieldName.equals("makeDate")) {
/*  890 */       return 14;
/*      */     }
/*  892 */     if (strFieldName.equals("makeTime")) {
/*  893 */       return 15;
/*      */     }
/*  895 */     if (strFieldName.equals("modifyDate")) {
/*  896 */       return 16;
/*      */     }
/*  898 */     if (strFieldName.equals("modifyTime")) {
/*  899 */       return 17;
/*      */     }
/*  901 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  907 */     String strFieldName = "";
/*  908 */     switch (nFieldIndex) {
/*      */     case 0:
/*  910 */       strFieldName = "resultId";
/*  911 */       break;
/*      */     case 1:
/*  913 */       strFieldName = "impartId";
/*  914 */       break;
/*      */     case 2:
/*  916 */       strFieldName = "questionId";
/*  917 */       break;
/*      */     case 3:
/*  919 */       strFieldName = "questionType";
/*  920 */       break;
/*      */     case 4:
/*  922 */       strFieldName = "queInnerOrder";
/*  923 */       break;
/*      */     case 5:
/*  925 */       strFieldName = "grpContNo";
/*  926 */       break;
/*      */     case 6:
/*  928 */       strFieldName = "contNo";
/*  929 */       break;
/*      */     case 7:
/*  931 */       strFieldName = "proposalContNo";
/*  932 */       break;
/*      */     case 8:
/*  934 */       strFieldName = "customerNo";
/*  935 */       break;
/*      */     case 9:
/*  937 */       strFieldName = "customerId";
/*  938 */       break;
/*      */     case 10:
/*  940 */       strFieldName = "optionId";
/*  941 */       break;
/*      */     case 11:
/*  943 */       strFieldName = "answer";
/*  944 */       break;
/*      */     case 12:
/*  946 */       strFieldName = "operator";
/*  947 */       break;
/*      */     case 13:
/*  949 */       strFieldName = "manageCom";
/*  950 */       break;
/*      */     case 14:
/*  952 */       strFieldName = "makeDate";
/*  953 */       break;
/*      */     case 15:
/*  955 */       strFieldName = "makeTime";
/*  956 */       break;
/*      */     case 16:
/*  958 */       strFieldName = "modifyDate";
/*  959 */       break;
/*      */     case 17:
/*  961 */       strFieldName = "modifyTime";
/*  962 */       break;
/*      */     default:
/*  964 */       strFieldName = "";
/*      */     }
/*  966 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  972 */     if (strFieldName.equals("resultId")) {
/*  973 */       return 0;
/*      */     }
/*  975 */     if (strFieldName.equals("impartId")) {
/*  976 */       return 0;
/*      */     }
/*  978 */     if (strFieldName.equals("questionId")) {
/*  979 */       return 0;
/*      */     }
/*  981 */     if (strFieldName.equals("questionType")) {
/*  982 */       return 0;
/*      */     }
/*  984 */     if (strFieldName.equals("queInnerOrder")) {
/*  985 */       return 0;
/*      */     }
/*  987 */     if (strFieldName.equals("grpContNo")) {
/*  988 */       return 0;
/*      */     }
/*  990 */     if (strFieldName.equals("contNo")) {
/*  991 */       return 0;
/*      */     }
/*  993 */     if (strFieldName.equals("proposalContNo")) {
/*  994 */       return 0;
/*      */     }
/*  996 */     if (strFieldName.equals("customerNo")) {
/*  997 */       return 0;
/*      */     }
/*  999 */     if (strFieldName.equals("customerId")) {
/* 1000 */       return 0;
/*      */     }
/* 1002 */     if (strFieldName.equals("optionId")) {
/* 1003 */       return 0;
/*      */     }
/* 1005 */     if (strFieldName.equals("answer")) {
/* 1006 */       return 0;
/*      */     }
/* 1008 */     if (strFieldName.equals("operator")) {
/* 1009 */       return 0;
/*      */     }
/* 1011 */     if (strFieldName.equals("manageCom")) {
/* 1012 */       return 0;
/*      */     }
/* 1014 */     if (strFieldName.equals("makeDate")) {
/* 1015 */       return 1;
/*      */     }
/* 1017 */     if (strFieldName.equals("makeTime")) {
/* 1018 */       return 0;
/*      */     }
/* 1020 */     if (strFieldName.equals("modifyDate")) {
/* 1021 */       return 1;
/*      */     }
/* 1023 */     if (strFieldName.equals("modifyTime")) {
/* 1024 */       return 0;
/*      */     }
/* 1026 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1032 */     int nFieldType = -1;
/* 1033 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1035 */       nFieldType = 0;
/* 1036 */       break;
/*      */     case 1:
/* 1038 */       nFieldType = 0;
/* 1039 */       break;
/*      */     case 2:
/* 1041 */       nFieldType = 0;
/* 1042 */       break;
/*      */     case 3:
/* 1044 */       nFieldType = 0;
/* 1045 */       break;
/*      */     case 4:
/* 1047 */       nFieldType = 0;
/* 1048 */       break;
/*      */     case 5:
/* 1050 */       nFieldType = 0;
/* 1051 */       break;
/*      */     case 6:
/* 1053 */       nFieldType = 0;
/* 1054 */       break;
/*      */     case 7:
/* 1056 */       nFieldType = 0;
/* 1057 */       break;
/*      */     case 8:
/* 1059 */       nFieldType = 0;
/* 1060 */       break;
/*      */     case 9:
/* 1062 */       nFieldType = 0;
/* 1063 */       break;
/*      */     case 10:
/* 1065 */       nFieldType = 0;
/* 1066 */       break;
/*      */     case 11:
/* 1068 */       nFieldType = 0;
/* 1069 */       break;
/*      */     case 12:
/* 1071 */       nFieldType = 0;
/* 1072 */       break;
/*      */     case 13:
/* 1074 */       nFieldType = 0;
/* 1075 */       break;
/*      */     case 14:
/* 1077 */       nFieldType = 1;
/* 1078 */       break;
/*      */     case 15:
/* 1080 */       nFieldType = 0;
/* 1081 */       break;
/*      */     case 16:
/* 1083 */       nFieldType = 1;
/* 1084 */       break;
/*      */     case 17:
/* 1086 */       nFieldType = 0;
/* 1087 */       break;
/*      */     default:
/* 1089 */       nFieldType = -1;
/*      */     }
/* 1091 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPCustImpResultSchema
 * JD-Core Version:    0.6.0
 */