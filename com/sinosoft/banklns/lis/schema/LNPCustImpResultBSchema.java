/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPCustImpResultBDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPCustImpResultBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
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
/*      */   public static final int FIELDNUM = 20;
/*      */   private static String[] PK;
/*   65 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPCustImpResultBSchema()
/*      */   {
/*   72 */     this.mErrors = new CErrors();
/*      */ 
/*   74 */     String[] pk = new String[2];
/*   75 */     pk[0] = "EdorNo";
/*   76 */     pk[1] = "serialNo";
/*      */ 
/*   78 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   84 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*   89 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*   93 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*   97 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*  101 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  105 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  109 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getresultId() {
/*  113 */     if (this.resultId != null) this.resultId.equals("");
/*      */ 
/*  117 */     return this.resultId;
/*      */   }
/*      */ 
/*      */   public void setresultId(String aresultId) {
/*  121 */     this.resultId = aresultId;
/*      */   }
/*      */ 
/*      */   public String getimpartId() {
/*  125 */     if (this.impartId != null) this.impartId.equals("");
/*      */ 
/*  129 */     return this.impartId;
/*      */   }
/*      */ 
/*      */   public void setimpartId(String aimpartId) {
/*  133 */     this.impartId = aimpartId;
/*      */   }
/*      */ 
/*      */   public String getquestionId() {
/*  137 */     if (this.questionId != null) this.questionId.equals("");
/*      */ 
/*  141 */     return this.questionId;
/*      */   }
/*      */ 
/*      */   public void setquestionId(String aquestionId) {
/*  145 */     this.questionId = aquestionId;
/*      */   }
/*      */ 
/*      */   public String getquestionType() {
/*  149 */     if (this.questionType != null) this.questionType.equals("");
/*      */ 
/*  153 */     return this.questionType;
/*      */   }
/*      */ 
/*      */   public void setquestionType(String aquestionType) {
/*  157 */     this.questionType = aquestionType;
/*      */   }
/*      */ 
/*      */   public String getqueInnerOrder() {
/*  161 */     if (this.queInnerOrder != null) this.queInnerOrder.equals("");
/*      */ 
/*  165 */     return this.queInnerOrder;
/*      */   }
/*      */ 
/*      */   public void setqueInnerOrder(String aqueInnerOrder) {
/*  169 */     this.queInnerOrder = aqueInnerOrder;
/*      */   }
/*      */ 
/*      */   public String getgrpContNo() {
/*  173 */     if (this.grpContNo != null) this.grpContNo.equals("");
/*      */ 
/*  177 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setgrpContNo(String agrpContNo) {
/*  181 */     this.grpContNo = agrpContNo;
/*      */   }
/*      */ 
/*      */   public String getcontNo() {
/*  185 */     if (this.contNo != null) this.contNo.equals("");
/*      */ 
/*  189 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setcontNo(String acontNo) {
/*  193 */     this.contNo = acontNo;
/*      */   }
/*      */ 
/*      */   public String getproposalContNo() {
/*  197 */     if (this.proposalContNo != null) this.proposalContNo.equals("");
/*      */ 
/*  201 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setproposalContNo(String aproposalContNo) {
/*  205 */     this.proposalContNo = aproposalContNo;
/*      */   }
/*      */ 
/*      */   public String getcustomerNo() {
/*  209 */     if (this.customerNo != null) this.customerNo.equals("");
/*      */ 
/*  213 */     return this.customerNo;
/*      */   }
/*      */ 
/*      */   public void setcustomerNo(String acustomerNo) {
/*  217 */     this.customerNo = acustomerNo;
/*      */   }
/*      */ 
/*      */   public String getcustomerId() {
/*  221 */     if (this.customerId != null) this.customerId.equals("");
/*      */ 
/*  225 */     return this.customerId;
/*      */   }
/*      */ 
/*      */   public void setcustomerId(String acustomerId) {
/*  229 */     this.customerId = acustomerId;
/*      */   }
/*      */ 
/*      */   public String getoptionId() {
/*  233 */     if (this.optionId != null) this.optionId.equals("");
/*      */ 
/*  237 */     return this.optionId;
/*      */   }
/*      */ 
/*      */   public void setoptionId(String aoptionId) {
/*  241 */     this.optionId = aoptionId;
/*      */   }
/*      */ 
/*      */   public String getanswer() {
/*  245 */     if (this.answer != null) this.answer.equals("");
/*      */ 
/*  249 */     return this.answer;
/*      */   }
/*      */ 
/*      */   public void setanswer(String aanswer) {
/*  253 */     this.answer = aanswer;
/*      */   }
/*      */ 
/*      */   public String getoperator() {
/*  257 */     if (this.operator != null) this.operator.equals("");
/*      */ 
/*  261 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setoperator(String aoperator) {
/*  265 */     this.operator = aoperator;
/*      */   }
/*      */ 
/*      */   public String getmanageCom() {
/*  269 */     if (this.manageCom != null) this.manageCom.equals("");
/*      */ 
/*  273 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setmanageCom(String amanageCom) {
/*  277 */     this.manageCom = amanageCom;
/*      */   }
/*      */ 
/*      */   public String getmakeDate() {
/*  281 */     if (this.makeDate != null) {
/*  282 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  284 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(Date amakeDate) {
/*  288 */     this.makeDate = amakeDate;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(String amakeDate) {
/*  292 */     if ((amakeDate != null) && (!amakeDate.equals("")))
/*      */     {
/*  294 */       this.makeDate = this.fDate.getDate(amakeDate);
/*      */     }
/*      */     else
/*  297 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getmakeTime()
/*      */   {
/*  302 */     if (this.makeTime != null) this.makeTime.equals("");
/*      */ 
/*  306 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setmakeTime(String amakeTime) {
/*  310 */     this.makeTime = amakeTime;
/*      */   }
/*      */ 
/*      */   public String getmodifyDate() {
/*  314 */     if (this.modifyDate != null) {
/*  315 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  317 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(Date amodifyDate) {
/*  321 */     this.modifyDate = amodifyDate;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(String amodifyDate) {
/*  325 */     if ((amodifyDate != null) && (!amodifyDate.equals("")))
/*      */     {
/*  327 */       this.modifyDate = this.fDate.getDate(amodifyDate);
/*      */     }
/*      */     else
/*  330 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getmodifyTime()
/*      */   {
/*  335 */     if (this.modifyTime != null) this.modifyTime.equals("");
/*      */ 
/*  339 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setmodifyTime(String amodifyTime) {
/*  343 */     this.modifyTime = amodifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPCustImpResultBSchema aLNPCustImpResultBSchema)
/*      */   {
/*  349 */     this.EdorNo = aLNPCustImpResultBSchema.getEdorNo();
/*  350 */     this.serialNo = aLNPCustImpResultBSchema.getserialNo();
/*  351 */     this.resultId = aLNPCustImpResultBSchema.getresultId();
/*  352 */     this.impartId = aLNPCustImpResultBSchema.getimpartId();
/*  353 */     this.questionId = aLNPCustImpResultBSchema.getquestionId();
/*  354 */     this.questionType = aLNPCustImpResultBSchema.getquestionType();
/*  355 */     this.queInnerOrder = aLNPCustImpResultBSchema.getqueInnerOrder();
/*  356 */     this.grpContNo = aLNPCustImpResultBSchema.getgrpContNo();
/*  357 */     this.contNo = aLNPCustImpResultBSchema.getcontNo();
/*  358 */     this.proposalContNo = aLNPCustImpResultBSchema.getproposalContNo();
/*  359 */     this.customerNo = aLNPCustImpResultBSchema.getcustomerNo();
/*  360 */     this.customerId = aLNPCustImpResultBSchema.getcustomerId();
/*  361 */     this.optionId = aLNPCustImpResultBSchema.getoptionId();
/*  362 */     this.answer = aLNPCustImpResultBSchema.getanswer();
/*  363 */     this.operator = aLNPCustImpResultBSchema.getoperator();
/*  364 */     this.manageCom = aLNPCustImpResultBSchema.getmanageCom();
/*  365 */     this.makeDate = this.fDate.getDate(aLNPCustImpResultBSchema.getmakeDate());
/*  366 */     this.makeTime = aLNPCustImpResultBSchema.getmakeTime();
/*  367 */     this.modifyDate = this.fDate.getDate(aLNPCustImpResultBSchema.getmodifyDate());
/*  368 */     this.modifyTime = aLNPCustImpResultBSchema.getmodifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  377 */       if (rs.getString("EdorNo") == null)
/*  378 */         this.EdorNo = null;
/*      */       else {
/*  380 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  382 */       if (rs.getString("serialNo") == null)
/*  383 */         this.serialNo = null;
/*      */       else {
/*  385 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/*  387 */       if (rs.getString("resultId") == null)
/*  388 */         this.resultId = null;
/*      */       else {
/*  390 */         this.resultId = rs.getString("resultId").trim();
/*      */       }
/*  392 */       if (rs.getString("impartId") == null)
/*  393 */         this.impartId = null;
/*      */       else {
/*  395 */         this.impartId = rs.getString("impartId").trim();
/*      */       }
/*  397 */       if (rs.getString("questionId") == null)
/*  398 */         this.questionId = null;
/*      */       else {
/*  400 */         this.questionId = rs.getString("questionId").trim();
/*      */       }
/*  402 */       if (rs.getString("questionType") == null)
/*  403 */         this.questionType = null;
/*      */       else {
/*  405 */         this.questionType = rs.getString("questionType").trim();
/*      */       }
/*  407 */       if (rs.getString("queInnerOrder") == null)
/*  408 */         this.queInnerOrder = null;
/*      */       else {
/*  410 */         this.queInnerOrder = rs.getString("queInnerOrder").trim();
/*      */       }
/*  412 */       if (rs.getString("grpContNo") == null)
/*  413 */         this.grpContNo = null;
/*      */       else {
/*  415 */         this.grpContNo = rs.getString("grpContNo").trim();
/*      */       }
/*  417 */       if (rs.getString("contNo") == null)
/*  418 */         this.contNo = null;
/*      */       else {
/*  420 */         this.contNo = rs.getString("contNo").trim();
/*      */       }
/*  422 */       if (rs.getString("proposalContNo") == null)
/*  423 */         this.proposalContNo = null;
/*      */       else {
/*  425 */         this.proposalContNo = rs.getString("proposalContNo").trim();
/*      */       }
/*  427 */       if (rs.getString("customerNo") == null)
/*  428 */         this.customerNo = null;
/*      */       else {
/*  430 */         this.customerNo = rs.getString("customerNo").trim();
/*      */       }
/*  432 */       if (rs.getString("customerId") == null)
/*  433 */         this.customerId = null;
/*      */       else {
/*  435 */         this.customerId = rs.getString("customerId").trim();
/*      */       }
/*  437 */       if (rs.getString("optionId") == null)
/*  438 */         this.optionId = null;
/*      */       else {
/*  440 */         this.optionId = rs.getString("optionId").trim();
/*      */       }
/*  442 */       if (rs.getString("answer") == null)
/*  443 */         this.answer = null;
/*      */       else {
/*  445 */         this.answer = rs.getString("answer").trim();
/*      */       }
/*  447 */       if (rs.getString("operator") == null)
/*  448 */         this.operator = null;
/*      */       else {
/*  450 */         this.operator = rs.getString("operator").trim();
/*      */       }
/*  452 */       if (rs.getString("manageCom") == null)
/*  453 */         this.manageCom = null;
/*      */       else {
/*  455 */         this.manageCom = rs.getString("manageCom").trim();
/*      */       }
/*  457 */       this.makeDate = rs.getDate("makeDate");
/*  458 */       if (rs.getString("makeTime") == null)
/*  459 */         this.makeTime = null;
/*      */       else {
/*  461 */         this.makeTime = rs.getString("makeTime").trim();
/*      */       }
/*  463 */       this.modifyDate = rs.getDate("modifyDate");
/*  464 */       if (rs.getString("modifyTime") == null)
/*  465 */         this.modifyTime = null;
/*      */       else {
/*  467 */         this.modifyTime = rs.getString("modifyTime").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  473 */       CError tError = new CError();
/*  474 */       tError.moduleName = "LNPCustImpResultBSchema";
/*  475 */       tError.functionName = "setSchema";
/*  476 */       tError.errorMessage = sqle.toString();
/*  477 */       this.mErrors.addOneError(tError);
/*      */ 
/*  479 */       return false;
/*      */     }
/*  481 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPCustImpResultBSchema getSchema()
/*      */   {
/*  486 */     LNPCustImpResultBSchema aLNPCustImpResultBSchema = new LNPCustImpResultBSchema();
/*  487 */     aLNPCustImpResultBSchema.setSchema(this);
/*  488 */     return aLNPCustImpResultBSchema;
/*      */   }
/*      */ 
/*      */   public LNPCustImpResultBDB getDB()
/*      */   {
/*  493 */     LNPCustImpResultBDB aDBOper = new LNPCustImpResultBDB();
/*  494 */     aDBOper.setSchema(this);
/*  495 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  502 */     String strReturn = "";
/*  503 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/*  504 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/*  505 */       StrTool.cTrim(StrTool.unicodeToGBK(this.resultId)) + "|" + 
/*  506 */       StrTool.cTrim(StrTool.unicodeToGBK(this.impartId)) + "|" + 
/*  507 */       StrTool.cTrim(StrTool.unicodeToGBK(this.questionId)) + "|" + 
/*  508 */       StrTool.cTrim(StrTool.unicodeToGBK(this.questionType)) + "|" + 
/*  509 */       StrTool.cTrim(StrTool.unicodeToGBK(this.queInnerOrder)) + "|" + 
/*  510 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpContNo)) + "|" + 
/*  511 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contNo)) + "|" + 
/*  512 */       StrTool.cTrim(StrTool.unicodeToGBK(this.proposalContNo)) + "|" + 
/*  513 */       StrTool.cTrim(StrTool.unicodeToGBK(this.customerNo)) + "|" + 
/*  514 */       StrTool.cTrim(StrTool.unicodeToGBK(this.customerId)) + "|" + 
/*  515 */       StrTool.cTrim(StrTool.unicodeToGBK(this.optionId)) + "|" + 
/*  516 */       StrTool.cTrim(StrTool.unicodeToGBK(this.answer)) + "|" + 
/*  517 */       StrTool.cTrim(StrTool.unicodeToGBK(this.operator)) + "|" + 
/*  518 */       StrTool.cTrim(StrTool.unicodeToGBK(this.manageCom)) + "|" + 
/*  519 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makeDate))) + "|" + 
/*  520 */       StrTool.cTrim(StrTool.unicodeToGBK(this.makeTime)) + "|" + 
/*  521 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifyDate))) + "|" + 
/*  522 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifyTime));
/*  523 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  531 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  532 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  533 */       this.resultId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  534 */       this.impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  535 */       this.questionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  536 */       this.questionType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  537 */       this.queInnerOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  538 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  539 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  540 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  541 */       this.customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  542 */       this.customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  543 */       this.optionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  544 */       this.answer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  545 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  546 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  547 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  548 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  549 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
/*  550 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  555 */       CError tError = new CError();
/*  556 */       tError.moduleName = "LNPCustImpResultBSchema";
/*  557 */       tError.functionName = "decode";
/*  558 */       tError.errorMessage = ex.toString();
/*  559 */       this.mErrors.addOneError(tError);
/*      */ 
/*  561 */       return false;
/*      */     }
/*  563 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  569 */     String strReturn = "";
/*  570 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  572 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/*  574 */     if (FCode.equals("serialNo"))
/*      */     {
/*  576 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/*  578 */     if (FCode.equals("resultId"))
/*      */     {
/*  580 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.resultId));
/*      */     }
/*  582 */     if (FCode.equals("impartId"))
/*      */     {
/*  584 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartId));
/*      */     }
/*  586 */     if (FCode.equals("questionId"))
/*      */     {
/*  588 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionId));
/*      */     }
/*  590 */     if (FCode.equals("questionType"))
/*      */     {
/*  592 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionType));
/*      */     }
/*  594 */     if (FCode.equals("queInnerOrder"))
/*      */     {
/*  596 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.queInnerOrder));
/*      */     }
/*  598 */     if (FCode.equals("grpContNo"))
/*      */     {
/*  600 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  602 */     if (FCode.equals("contNo"))
/*      */     {
/*  604 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  606 */     if (FCode.equals("proposalContNo"))
/*      */     {
/*  608 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  610 */     if (FCode.equals("customerNo"))
/*      */     {
/*  612 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerNo));
/*      */     }
/*  614 */     if (FCode.equals("customerId"))
/*      */     {
/*  616 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerId));
/*      */     }
/*  618 */     if (FCode.equals("optionId"))
/*      */     {
/*  620 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.optionId));
/*      */     }
/*  622 */     if (FCode.equals("answer"))
/*      */     {
/*  624 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.answer));
/*      */     }
/*  626 */     if (FCode.equals("operator"))
/*      */     {
/*  628 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  630 */     if (FCode.equals("manageCom"))
/*      */     {
/*  632 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  634 */     if (FCode.equals("makeDate"))
/*      */     {
/*  636 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*      */     }
/*  638 */     if (FCode.equals("makeTime"))
/*      */     {
/*  640 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  642 */     if (FCode.equals("modifyDate"))
/*      */     {
/*  644 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*      */     }
/*  646 */     if (FCode.equals("modifyTime"))
/*      */     {
/*  648 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  650 */     if (strReturn.equals(""))
/*      */     {
/*  652 */       strReturn = "null";
/*      */     }
/*      */ 
/*  655 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  662 */     String strFieldValue = "";
/*  663 */     switch (nFieldIndex) {
/*      */     case 0:
/*  665 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/*  666 */       break;
/*      */     case 1:
/*  668 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/*  669 */       break;
/*      */     case 2:
/*  671 */       strFieldValue = StrTool.GBKToUnicode(this.resultId);
/*  672 */       break;
/*      */     case 3:
/*  674 */       strFieldValue = StrTool.GBKToUnicode(this.impartId);
/*  675 */       break;
/*      */     case 4:
/*  677 */       strFieldValue = StrTool.GBKToUnicode(this.questionId);
/*  678 */       break;
/*      */     case 5:
/*  680 */       strFieldValue = StrTool.GBKToUnicode(this.questionType);
/*  681 */       break;
/*      */     case 6:
/*  683 */       strFieldValue = StrTool.GBKToUnicode(this.queInnerOrder);
/*  684 */       break;
/*      */     case 7:
/*  686 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  687 */       break;
/*      */     case 8:
/*  689 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  690 */       break;
/*      */     case 9:
/*  692 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  693 */       break;
/*      */     case 10:
/*  695 */       strFieldValue = StrTool.GBKToUnicode(this.customerNo);
/*  696 */       break;
/*      */     case 11:
/*  698 */       strFieldValue = StrTool.GBKToUnicode(this.customerId);
/*  699 */       break;
/*      */     case 12:
/*  701 */       strFieldValue = StrTool.GBKToUnicode(this.optionId);
/*  702 */       break;
/*      */     case 13:
/*  704 */       strFieldValue = StrTool.GBKToUnicode(this.answer);
/*  705 */       break;
/*      */     case 14:
/*  707 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  708 */       break;
/*      */     case 15:
/*  710 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  711 */       break;
/*      */     case 16:
/*  713 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*  714 */       break;
/*      */     case 17:
/*  716 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  717 */       break;
/*      */     case 18:
/*  719 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*  720 */       break;
/*      */     case 19:
/*  722 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  723 */       break;
/*      */     default:
/*  725 */       strFieldValue = "";
/*      */     }
/*  727 */     if (strFieldValue.equals("")) {
/*  728 */       strFieldValue = "null";
/*      */     }
/*  730 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  736 */     if (StrTool.cTrim(FCode).equals("")) {
/*  737 */       return false;
/*      */     }
/*  739 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  741 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  743 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/*  746 */         this.EdorNo = null;
/*      */     }
/*  748 */     if (FCode.equals("serialNo"))
/*      */     {
/*  750 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  752 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/*  755 */         this.serialNo = null;
/*      */     }
/*  757 */     if (FCode.equals("resultId"))
/*      */     {
/*  759 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  761 */         this.resultId = FValue.trim();
/*      */       }
/*      */       else
/*  764 */         this.resultId = null;
/*      */     }
/*  766 */     if (FCode.equals("impartId"))
/*      */     {
/*  768 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  770 */         this.impartId = FValue.trim();
/*      */       }
/*      */       else
/*  773 */         this.impartId = null;
/*      */     }
/*  775 */     if (FCode.equals("questionId"))
/*      */     {
/*  777 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  779 */         this.questionId = FValue.trim();
/*      */       }
/*      */       else
/*  782 */         this.questionId = null;
/*      */     }
/*  784 */     if (FCode.equals("questionType"))
/*      */     {
/*  786 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  788 */         this.questionType = FValue.trim();
/*      */       }
/*      */       else
/*  791 */         this.questionType = null;
/*      */     }
/*  793 */     if (FCode.equals("queInnerOrder"))
/*      */     {
/*  795 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  797 */         this.queInnerOrder = FValue.trim();
/*      */       }
/*      */       else
/*  800 */         this.queInnerOrder = null;
/*      */     }
/*  802 */     if (FCode.equals("grpContNo"))
/*      */     {
/*  804 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  806 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/*  809 */         this.grpContNo = null;
/*      */     }
/*  811 */     if (FCode.equals("contNo"))
/*      */     {
/*  813 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  815 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/*  818 */         this.contNo = null;
/*      */     }
/*  820 */     if (FCode.equals("proposalContNo"))
/*      */     {
/*  822 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  824 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/*  827 */         this.proposalContNo = null;
/*      */     }
/*  829 */     if (FCode.equals("customerNo"))
/*      */     {
/*  831 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  833 */         this.customerNo = FValue.trim();
/*      */       }
/*      */       else
/*  836 */         this.customerNo = null;
/*      */     }
/*  838 */     if (FCode.equals("customerId"))
/*      */     {
/*  840 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  842 */         this.customerId = FValue.trim();
/*      */       }
/*      */       else
/*  845 */         this.customerId = null;
/*      */     }
/*  847 */     if (FCode.equals("optionId"))
/*      */     {
/*  849 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  851 */         this.optionId = FValue.trim();
/*      */       }
/*      */       else
/*  854 */         this.optionId = null;
/*      */     }
/*  856 */     if (FCode.equals("answer"))
/*      */     {
/*  858 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  860 */         this.answer = FValue.trim();
/*      */       }
/*      */       else
/*  863 */         this.answer = null;
/*      */     }
/*  865 */     if (FCode.equals("operator"))
/*      */     {
/*  867 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  869 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  872 */         this.operator = null;
/*      */     }
/*  874 */     if (FCode.equals("manageCom"))
/*      */     {
/*  876 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  878 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  881 */         this.manageCom = null;
/*      */     }
/*  883 */     if (FCode.equals("makeDate"))
/*      */     {
/*  885 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  887 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  890 */         this.makeDate = null;
/*      */     }
/*  892 */     if (FCode.equals("makeTime"))
/*      */     {
/*  894 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  896 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  899 */         this.makeTime = null;
/*      */     }
/*  901 */     if (FCode.equals("modifyDate"))
/*      */     {
/*  903 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  905 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  908 */         this.modifyDate = null;
/*      */     }
/*  910 */     if (FCode.equals("modifyTime"))
/*      */     {
/*  912 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  914 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  917 */         this.modifyTime = null;
/*      */     }
/*  919 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  924 */     if (this == otherObject) return true;
/*  925 */     if (otherObject == null) return false;
/*  926 */     if (getClass() != otherObject.getClass()) return false;
/*  927 */     LNPCustImpResultBSchema other = (LNPCustImpResultBSchema)otherObject;
/*  928 */     return 
/*  929 */       (this.EdorNo.equals(other.getEdorNo())) && 
/*  930 */       (this.serialNo.equals(other.getserialNo())) && 
/*  931 */       (this.resultId.equals(other.getresultId())) && 
/*  932 */       (this.impartId.equals(other.getimpartId())) && 
/*  933 */       (this.questionId.equals(other.getquestionId())) && 
/*  934 */       (this.questionType.equals(other.getquestionType())) && 
/*  935 */       (this.queInnerOrder.equals(other.getqueInnerOrder())) && 
/*  936 */       (this.grpContNo.equals(other.getgrpContNo())) && 
/*  937 */       (this.contNo.equals(other.getcontNo())) && 
/*  938 */       (this.proposalContNo.equals(other.getproposalContNo())) && 
/*  939 */       (this.customerNo.equals(other.getcustomerNo())) && 
/*  940 */       (this.customerId.equals(other.getcustomerId())) && 
/*  941 */       (this.optionId.equals(other.getoptionId())) && 
/*  942 */       (this.answer.equals(other.getanswer())) && 
/*  943 */       (this.operator.equals(other.getoperator())) && 
/*  944 */       (this.manageCom.equals(other.getmanageCom())) && 
/*  945 */       (this.fDate.getString(this.makeDate).equals(other.getmakeDate())) && 
/*  946 */       (this.makeTime.equals(other.getmakeTime())) && 
/*  947 */       (this.fDate.getString(this.modifyDate).equals(other.getmodifyDate())) && 
/*  948 */       (this.modifyTime.equals(other.getmodifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  954 */     return 20;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  960 */     if (strFieldName.equals("EdorNo")) {
/*  961 */       return 0;
/*      */     }
/*  963 */     if (strFieldName.equals("serialNo")) {
/*  964 */       return 1;
/*      */     }
/*  966 */     if (strFieldName.equals("resultId")) {
/*  967 */       return 2;
/*      */     }
/*  969 */     if (strFieldName.equals("impartId")) {
/*  970 */       return 3;
/*      */     }
/*  972 */     if (strFieldName.equals("questionId")) {
/*  973 */       return 4;
/*      */     }
/*  975 */     if (strFieldName.equals("questionType")) {
/*  976 */       return 5;
/*      */     }
/*  978 */     if (strFieldName.equals("queInnerOrder")) {
/*  979 */       return 6;
/*      */     }
/*  981 */     if (strFieldName.equals("grpContNo")) {
/*  982 */       return 7;
/*      */     }
/*  984 */     if (strFieldName.equals("contNo")) {
/*  985 */       return 8;
/*      */     }
/*  987 */     if (strFieldName.equals("proposalContNo")) {
/*  988 */       return 9;
/*      */     }
/*  990 */     if (strFieldName.equals("customerNo")) {
/*  991 */       return 10;
/*      */     }
/*  993 */     if (strFieldName.equals("customerId")) {
/*  994 */       return 11;
/*      */     }
/*  996 */     if (strFieldName.equals("optionId")) {
/*  997 */       return 12;
/*      */     }
/*  999 */     if (strFieldName.equals("answer")) {
/* 1000 */       return 13;
/*      */     }
/* 1002 */     if (strFieldName.equals("operator")) {
/* 1003 */       return 14;
/*      */     }
/* 1005 */     if (strFieldName.equals("manageCom")) {
/* 1006 */       return 15;
/*      */     }
/* 1008 */     if (strFieldName.equals("makeDate")) {
/* 1009 */       return 16;
/*      */     }
/* 1011 */     if (strFieldName.equals("makeTime")) {
/* 1012 */       return 17;
/*      */     }
/* 1014 */     if (strFieldName.equals("modifyDate")) {
/* 1015 */       return 18;
/*      */     }
/* 1017 */     if (strFieldName.equals("modifyTime")) {
/* 1018 */       return 19;
/*      */     }
/* 1020 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1026 */     String strFieldName = "";
/* 1027 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1029 */       strFieldName = "EdorNo";
/* 1030 */       break;
/*      */     case 1:
/* 1032 */       strFieldName = "serialNo";
/* 1033 */       break;
/*      */     case 2:
/* 1035 */       strFieldName = "resultId";
/* 1036 */       break;
/*      */     case 3:
/* 1038 */       strFieldName = "impartId";
/* 1039 */       break;
/*      */     case 4:
/* 1041 */       strFieldName = "questionId";
/* 1042 */       break;
/*      */     case 5:
/* 1044 */       strFieldName = "questionType";
/* 1045 */       break;
/*      */     case 6:
/* 1047 */       strFieldName = "queInnerOrder";
/* 1048 */       break;
/*      */     case 7:
/* 1050 */       strFieldName = "grpContNo";
/* 1051 */       break;
/*      */     case 8:
/* 1053 */       strFieldName = "contNo";
/* 1054 */       break;
/*      */     case 9:
/* 1056 */       strFieldName = "proposalContNo";
/* 1057 */       break;
/*      */     case 10:
/* 1059 */       strFieldName = "customerNo";
/* 1060 */       break;
/*      */     case 11:
/* 1062 */       strFieldName = "customerId";
/* 1063 */       break;
/*      */     case 12:
/* 1065 */       strFieldName = "optionId";
/* 1066 */       break;
/*      */     case 13:
/* 1068 */       strFieldName = "answer";
/* 1069 */       break;
/*      */     case 14:
/* 1071 */       strFieldName = "operator";
/* 1072 */       break;
/*      */     case 15:
/* 1074 */       strFieldName = "manageCom";
/* 1075 */       break;
/*      */     case 16:
/* 1077 */       strFieldName = "makeDate";
/* 1078 */       break;
/*      */     case 17:
/* 1080 */       strFieldName = "makeTime";
/* 1081 */       break;
/*      */     case 18:
/* 1083 */       strFieldName = "modifyDate";
/* 1084 */       break;
/*      */     case 19:
/* 1086 */       strFieldName = "modifyTime";
/* 1087 */       break;
/*      */     default:
/* 1089 */       strFieldName = "";
/*      */     }
/* 1091 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1097 */     if (strFieldName.equals("EdorNo")) {
/* 1098 */       return 0;
/*      */     }
/* 1100 */     if (strFieldName.equals("serialNo")) {
/* 1101 */       return 0;
/*      */     }
/* 1103 */     if (strFieldName.equals("resultId")) {
/* 1104 */       return 0;
/*      */     }
/* 1106 */     if (strFieldName.equals("impartId")) {
/* 1107 */       return 0;
/*      */     }
/* 1109 */     if (strFieldName.equals("questionId")) {
/* 1110 */       return 0;
/*      */     }
/* 1112 */     if (strFieldName.equals("questionType")) {
/* 1113 */       return 0;
/*      */     }
/* 1115 */     if (strFieldName.equals("queInnerOrder")) {
/* 1116 */       return 0;
/*      */     }
/* 1118 */     if (strFieldName.equals("grpContNo")) {
/* 1119 */       return 0;
/*      */     }
/* 1121 */     if (strFieldName.equals("contNo")) {
/* 1122 */       return 0;
/*      */     }
/* 1124 */     if (strFieldName.equals("proposalContNo")) {
/* 1125 */       return 0;
/*      */     }
/* 1127 */     if (strFieldName.equals("customerNo")) {
/* 1128 */       return 0;
/*      */     }
/* 1130 */     if (strFieldName.equals("customerId")) {
/* 1131 */       return 0;
/*      */     }
/* 1133 */     if (strFieldName.equals("optionId")) {
/* 1134 */       return 0;
/*      */     }
/* 1136 */     if (strFieldName.equals("answer")) {
/* 1137 */       return 0;
/*      */     }
/* 1139 */     if (strFieldName.equals("operator")) {
/* 1140 */       return 0;
/*      */     }
/* 1142 */     if (strFieldName.equals("manageCom")) {
/* 1143 */       return 0;
/*      */     }
/* 1145 */     if (strFieldName.equals("makeDate")) {
/* 1146 */       return 1;
/*      */     }
/* 1148 */     if (strFieldName.equals("makeTime")) {
/* 1149 */       return 0;
/*      */     }
/* 1151 */     if (strFieldName.equals("modifyDate")) {
/* 1152 */       return 1;
/*      */     }
/* 1154 */     if (strFieldName.equals("modifyTime")) {
/* 1155 */       return 0;
/*      */     }
/* 1157 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1163 */     int nFieldType = -1;
/* 1164 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1166 */       nFieldType = 0;
/* 1167 */       break;
/*      */     case 1:
/* 1169 */       nFieldType = 0;
/* 1170 */       break;
/*      */     case 2:
/* 1172 */       nFieldType = 0;
/* 1173 */       break;
/*      */     case 3:
/* 1175 */       nFieldType = 0;
/* 1176 */       break;
/*      */     case 4:
/* 1178 */       nFieldType = 0;
/* 1179 */       break;
/*      */     case 5:
/* 1181 */       nFieldType = 0;
/* 1182 */       break;
/*      */     case 6:
/* 1184 */       nFieldType = 0;
/* 1185 */       break;
/*      */     case 7:
/* 1187 */       nFieldType = 0;
/* 1188 */       break;
/*      */     case 8:
/* 1190 */       nFieldType = 0;
/* 1191 */       break;
/*      */     case 9:
/* 1193 */       nFieldType = 0;
/* 1194 */       break;
/*      */     case 10:
/* 1196 */       nFieldType = 0;
/* 1197 */       break;
/*      */     case 11:
/* 1199 */       nFieldType = 0;
/* 1200 */       break;
/*      */     case 12:
/* 1202 */       nFieldType = 0;
/* 1203 */       break;
/*      */     case 13:
/* 1205 */       nFieldType = 0;
/* 1206 */       break;
/*      */     case 14:
/* 1208 */       nFieldType = 0;
/* 1209 */       break;
/*      */     case 15:
/* 1211 */       nFieldType = 0;
/* 1212 */       break;
/*      */     case 16:
/* 1214 */       nFieldType = 1;
/* 1215 */       break;
/*      */     case 17:
/* 1217 */       nFieldType = 0;
/* 1218 */       break;
/*      */     case 18:
/* 1220 */       nFieldType = 1;
/* 1221 */       break;
/*      */     case 19:
/* 1223 */       nFieldType = 0;
/* 1224 */       break;
/*      */     default:
/* 1226 */       nFieldType = -1;
/*      */     }
/* 1228 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPCustImpResultBSchema
 * JD-Core Version:    0.6.0
 */