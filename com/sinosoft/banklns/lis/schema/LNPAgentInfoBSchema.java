/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAgentInfoBDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPAgentInfoBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String prtNo;
/*      */   private String agentOrder;
/*      */   private String agentName;
/*      */   private String agentCode;
/*      */   private String branchName;
/*      */   private String branchAttr;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String p2;
/*      */   private String p4;
/*      */   private String p3;
/*      */   private String p1;
/*      */   public static final int FIELDNUM = 20;
/*      */   private static String[] PK;
/*   65 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPAgentInfoBSchema()
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
/*      */   public String getgrpContNo() {
/*  113 */     if (this.grpContNo != null) this.grpContNo.equals("");
/*      */ 
/*  117 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setgrpContNo(String agrpContNo) {
/*  121 */     this.grpContNo = agrpContNo;
/*      */   }
/*      */ 
/*      */   public String getcontNo() {
/*  125 */     if (this.contNo != null) this.contNo.equals("");
/*      */ 
/*  129 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setcontNo(String acontNo) {
/*  133 */     this.contNo = acontNo;
/*      */   }
/*      */ 
/*      */   public String getproposalContNo() {
/*  137 */     if (this.proposalContNo != null) this.proposalContNo.equals("");
/*      */ 
/*  141 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setproposalContNo(String aproposalContNo) {
/*  145 */     this.proposalContNo = aproposalContNo;
/*      */   }
/*      */ 
/*      */   public String getprtNo() {
/*  149 */     if (this.prtNo != null) this.prtNo.equals("");
/*      */ 
/*  153 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setprtNo(String aprtNo) {
/*  157 */     this.prtNo = aprtNo;
/*      */   }
/*      */ 
/*      */   public String getagentOrder() {
/*  161 */     if (this.agentOrder != null) this.agentOrder.equals("");
/*      */ 
/*  165 */     return this.agentOrder;
/*      */   }
/*      */ 
/*      */   public void setagentOrder(String aagentOrder) {
/*  169 */     this.agentOrder = aagentOrder;
/*      */   }
/*      */ 
/*      */   public String getagentName() {
/*  173 */     if (this.agentName != null) this.agentName.equals("");
/*      */ 
/*  177 */     return this.agentName;
/*      */   }
/*      */ 
/*      */   public void setagentName(String aagentName) {
/*  181 */     this.agentName = aagentName;
/*      */   }
/*      */ 
/*      */   public String getagentCode() {
/*  185 */     if (this.agentCode != null) this.agentCode.equals("");
/*      */ 
/*  189 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setagentCode(String aagentCode) {
/*  193 */     this.agentCode = aagentCode;
/*      */   }
/*      */ 
/*      */   public String getbranchName() {
/*  197 */     if (this.branchName != null) this.branchName.equals("");
/*      */ 
/*  201 */     return this.branchName;
/*      */   }
/*      */ 
/*      */   public void setbranchName(String abranchName) {
/*  205 */     this.branchName = abranchName;
/*      */   }
/*      */ 
/*      */   public String getbranchAttr() {
/*  209 */     if (this.branchAttr != null) this.branchAttr.equals("");
/*      */ 
/*  213 */     return this.branchAttr;
/*      */   }
/*      */ 
/*      */   public void setbranchAttr(String abranchAttr) {
/*  217 */     this.branchAttr = abranchAttr;
/*      */   }
/*      */ 
/*      */   public String getoperator() {
/*  221 */     if (this.operator != null) this.operator.equals("");
/*      */ 
/*  225 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setoperator(String aoperator) {
/*  229 */     this.operator = aoperator;
/*      */   }
/*      */ 
/*      */   public String getmakeDate() {
/*  233 */     if (this.makeDate != null) {
/*  234 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  236 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(Date amakeDate) {
/*  240 */     this.makeDate = amakeDate;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(String amakeDate) {
/*  244 */     if ((amakeDate != null) && (!amakeDate.equals("")))
/*      */     {
/*  246 */       this.makeDate = this.fDate.getDate(amakeDate);
/*      */     }
/*      */     else
/*  249 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getmakeTime()
/*      */   {
/*  254 */     if (this.makeTime != null) this.makeTime.equals("");
/*      */ 
/*  258 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setmakeTime(String amakeTime) {
/*  262 */     this.makeTime = amakeTime;
/*      */   }
/*      */ 
/*      */   public String getmodifyDate() {
/*  266 */     if (this.modifyDate != null) {
/*  267 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  269 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(Date amodifyDate) {
/*  273 */     this.modifyDate = amodifyDate;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(String amodifyDate) {
/*  277 */     if ((amodifyDate != null) && (!amodifyDate.equals("")))
/*      */     {
/*  279 */       this.modifyDate = this.fDate.getDate(amodifyDate);
/*      */     }
/*      */     else
/*  282 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getmodifyTime()
/*      */   {
/*  287 */     if (this.modifyTime != null) this.modifyTime.equals("");
/*      */ 
/*  291 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setmodifyTime(String amodifyTime) {
/*  295 */     this.modifyTime = amodifyTime;
/*      */   }
/*      */ 
/*      */   public String getp2() {
/*  299 */     if (this.p2 != null) this.p2.equals("");
/*      */ 
/*  303 */     return this.p2;
/*      */   }
/*      */ 
/*      */   public void setp2(String ap2) {
/*  307 */     this.p2 = ap2;
/*      */   }
/*      */ 
/*      */   public String getp4() {
/*  311 */     if (this.p4 != null) this.p4.equals("");
/*      */ 
/*  315 */     return this.p4;
/*      */   }
/*      */ 
/*      */   public void setp4(String ap4) {
/*  319 */     this.p4 = ap4;
/*      */   }
/*      */ 
/*      */   public String getp3() {
/*  323 */     if (this.p3 != null) this.p3.equals("");
/*      */ 
/*  327 */     return this.p3;
/*      */   }
/*      */ 
/*      */   public void setp3(String ap3) {
/*  331 */     this.p3 = ap3;
/*      */   }
/*      */ 
/*      */   public String getp1() {
/*  335 */     if (this.p1 != null) this.p1.equals("");
/*      */ 
/*  339 */     return this.p1;
/*      */   }
/*      */ 
/*      */   public void setp1(String ap1) {
/*  343 */     this.p1 = ap1;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPAgentInfoBSchema aLNPAgentInfoBSchema)
/*      */   {
/*  349 */     this.EdorNo = aLNPAgentInfoBSchema.getEdorNo();
/*  350 */     this.serialNo = aLNPAgentInfoBSchema.getserialNo();
/*  351 */     this.grpContNo = aLNPAgentInfoBSchema.getgrpContNo();
/*  352 */     this.contNo = aLNPAgentInfoBSchema.getcontNo();
/*  353 */     this.proposalContNo = aLNPAgentInfoBSchema.getproposalContNo();
/*  354 */     this.prtNo = aLNPAgentInfoBSchema.getprtNo();
/*  355 */     this.agentOrder = aLNPAgentInfoBSchema.getagentOrder();
/*  356 */     this.agentName = aLNPAgentInfoBSchema.getagentName();
/*  357 */     this.agentCode = aLNPAgentInfoBSchema.getagentCode();
/*  358 */     this.branchName = aLNPAgentInfoBSchema.getbranchName();
/*  359 */     this.branchAttr = aLNPAgentInfoBSchema.getbranchAttr();
/*  360 */     this.operator = aLNPAgentInfoBSchema.getoperator();
/*  361 */     this.makeDate = this.fDate.getDate(aLNPAgentInfoBSchema.getmakeDate());
/*  362 */     this.makeTime = aLNPAgentInfoBSchema.getmakeTime();
/*  363 */     this.modifyDate = this.fDate.getDate(aLNPAgentInfoBSchema.getmodifyDate());
/*  364 */     this.modifyTime = aLNPAgentInfoBSchema.getmodifyTime();
/*  365 */     this.p2 = aLNPAgentInfoBSchema.getp2();
/*  366 */     this.p4 = aLNPAgentInfoBSchema.getp4();
/*  367 */     this.p3 = aLNPAgentInfoBSchema.getp3();
/*  368 */     this.p1 = aLNPAgentInfoBSchema.getp1();
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
/*  387 */       if (rs.getString("grpContNo") == null)
/*  388 */         this.grpContNo = null;
/*      */       else {
/*  390 */         this.grpContNo = rs.getString("grpContNo").trim();
/*      */       }
/*  392 */       if (rs.getString("contNo") == null)
/*  393 */         this.contNo = null;
/*      */       else {
/*  395 */         this.contNo = rs.getString("contNo").trim();
/*      */       }
/*  397 */       if (rs.getString("proposalContNo") == null)
/*  398 */         this.proposalContNo = null;
/*      */       else {
/*  400 */         this.proposalContNo = rs.getString("proposalContNo").trim();
/*      */       }
/*  402 */       if (rs.getString("prtNo") == null)
/*  403 */         this.prtNo = null;
/*      */       else {
/*  405 */         this.prtNo = rs.getString("prtNo").trim();
/*      */       }
/*  407 */       if (rs.getString("agentOrder") == null)
/*  408 */         this.agentOrder = null;
/*      */       else {
/*  410 */         this.agentOrder = rs.getString("agentOrder").trim();
/*      */       }
/*  412 */       if (rs.getString("agentName") == null)
/*  413 */         this.agentName = null;
/*      */       else {
/*  415 */         this.agentName = rs.getString("agentName").trim();
/*      */       }
/*  417 */       if (rs.getString("agentCode") == null)
/*  418 */         this.agentCode = null;
/*      */       else {
/*  420 */         this.agentCode = rs.getString("agentCode").trim();
/*      */       }
/*  422 */       if (rs.getString("branchName") == null)
/*  423 */         this.branchName = null;
/*      */       else {
/*  425 */         this.branchName = rs.getString("branchName").trim();
/*      */       }
/*  427 */       if (rs.getString("branchAttr") == null)
/*  428 */         this.branchAttr = null;
/*      */       else {
/*  430 */         this.branchAttr = rs.getString("branchAttr").trim();
/*      */       }
/*  432 */       if (rs.getString("operator") == null)
/*  433 */         this.operator = null;
/*      */       else {
/*  435 */         this.operator = rs.getString("operator").trim();
/*      */       }
/*  437 */       this.makeDate = rs.getDate("makeDate");
/*  438 */       if (rs.getString("makeTime") == null)
/*  439 */         this.makeTime = null;
/*      */       else {
/*  441 */         this.makeTime = rs.getString("makeTime").trim();
/*      */       }
/*  443 */       this.modifyDate = rs.getDate("modifyDate");
/*  444 */       if (rs.getString("modifyTime") == null)
/*  445 */         this.modifyTime = null;
/*      */       else {
/*  447 */         this.modifyTime = rs.getString("modifyTime").trim();
/*      */       }
/*  449 */       if (rs.getString("p2") == null)
/*  450 */         this.p2 = null;
/*      */       else {
/*  452 */         this.p2 = rs.getString("p2").trim();
/*      */       }
/*  454 */       if (rs.getString("p4") == null)
/*  455 */         this.p4 = null;
/*      */       else {
/*  457 */         this.p4 = rs.getString("p4").trim();
/*      */       }
/*  459 */       if (rs.getString("p3") == null)
/*  460 */         this.p3 = null;
/*      */       else {
/*  462 */         this.p3 = rs.getString("p3").trim();
/*      */       }
/*  464 */       if (rs.getString("p1") == null)
/*  465 */         this.p1 = null;
/*      */       else {
/*  467 */         this.p1 = rs.getString("p1").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  473 */       CError tError = new CError();
/*  474 */       tError.moduleName = "LNPAgentInfoBSchema";
/*  475 */       tError.functionName = "setSchema";
/*  476 */       tError.errorMessage = sqle.toString();
/*  477 */       this.mErrors.addOneError(tError);
/*      */ 
/*  479 */       return false;
/*      */     }
/*  481 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAgentInfoBSchema getSchema()
/*      */   {
/*  486 */     LNPAgentInfoBSchema aLNPAgentInfoBSchema = new LNPAgentInfoBSchema();
/*  487 */     aLNPAgentInfoBSchema.setSchema(this);
/*  488 */     return aLNPAgentInfoBSchema;
/*      */   }
/*      */ 
/*      */   public LNPAgentInfoBDB getDB()
/*      */   {
/*  493 */     LNPAgentInfoBDB aDBOper = new LNPAgentInfoBDB();
/*  494 */     aDBOper.setSchema(this);
/*  495 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  502 */     String strReturn = "";
/*  503 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/*  504 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/*  505 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpContNo)) + "|" + 
/*  506 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contNo)) + "|" + 
/*  507 */       StrTool.cTrim(StrTool.unicodeToGBK(this.proposalContNo)) + "|" + 
/*  508 */       StrTool.cTrim(StrTool.unicodeToGBK(this.prtNo)) + "|" + 
/*  509 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentOrder)) + "|" + 
/*  510 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentName)) + "|" + 
/*  511 */       StrTool.cTrim(StrTool.unicodeToGBK(this.agentCode)) + "|" + 
/*  512 */       StrTool.cTrim(StrTool.unicodeToGBK(this.branchName)) + "|" + 
/*  513 */       StrTool.cTrim(StrTool.unicodeToGBK(this.branchAttr)) + "|" + 
/*  514 */       StrTool.cTrim(StrTool.unicodeToGBK(this.operator)) + "|" + 
/*  515 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makeDate))) + "|" + 
/*  516 */       StrTool.cTrim(StrTool.unicodeToGBK(this.makeTime)) + "|" + 
/*  517 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifyDate))) + "|" + 
/*  518 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifyTime)) + "|" + 
/*  519 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p2)) + "|" + 
/*  520 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p4)) + "|" + 
/*  521 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p3)) + "|" + 
/*  522 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p1));
/*  523 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  531 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  532 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  533 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  534 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  535 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  536 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  537 */       this.agentOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  538 */       this.agentName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  539 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  540 */       this.branchName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  541 */       this.branchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  542 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  543 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
/*  544 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  545 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  546 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  547 */       this.p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  548 */       this.p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  549 */       this.p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  550 */       this.p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  555 */       CError tError = new CError();
/*  556 */       tError.moduleName = "LNPAgentInfoBSchema";
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
/*  578 */     if (FCode.equals("grpContNo"))
/*      */     {
/*  580 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  582 */     if (FCode.equals("contNo"))
/*      */     {
/*  584 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  586 */     if (FCode.equals("proposalContNo"))
/*      */     {
/*  588 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  590 */     if (FCode.equals("prtNo"))
/*      */     {
/*  592 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/*  594 */     if (FCode.equals("agentOrder"))
/*      */     {
/*  596 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentOrder));
/*      */     }
/*  598 */     if (FCode.equals("agentName"))
/*      */     {
/*  600 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentName));
/*      */     }
/*  602 */     if (FCode.equals("agentCode"))
/*      */     {
/*  604 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/*  606 */     if (FCode.equals("branchName"))
/*      */     {
/*  608 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchName));
/*      */     }
/*  610 */     if (FCode.equals("branchAttr"))
/*      */     {
/*  612 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchAttr));
/*      */     }
/*  614 */     if (FCode.equals("operator"))
/*      */     {
/*  616 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  618 */     if (FCode.equals("makeDate"))
/*      */     {
/*  620 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*      */     }
/*  622 */     if (FCode.equals("makeTime"))
/*      */     {
/*  624 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  626 */     if (FCode.equals("modifyDate"))
/*      */     {
/*  628 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*      */     }
/*  630 */     if (FCode.equals("modifyTime"))
/*      */     {
/*  632 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  634 */     if (FCode.equals("p2"))
/*      */     {
/*  636 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p2));
/*      */     }
/*  638 */     if (FCode.equals("p4"))
/*      */     {
/*  640 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p4));
/*      */     }
/*  642 */     if (FCode.equals("p3"))
/*      */     {
/*  644 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p3));
/*      */     }
/*  646 */     if (FCode.equals("p1"))
/*      */     {
/*  648 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p1));
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
/*  671 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  672 */       break;
/*      */     case 3:
/*  674 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  675 */       break;
/*      */     case 4:
/*  677 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  678 */       break;
/*      */     case 5:
/*  680 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/*  681 */       break;
/*      */     case 6:
/*  683 */       strFieldValue = StrTool.GBKToUnicode(this.agentOrder);
/*  684 */       break;
/*      */     case 7:
/*  686 */       strFieldValue = StrTool.GBKToUnicode(this.agentName);
/*  687 */       break;
/*      */     case 8:
/*  689 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/*  690 */       break;
/*      */     case 9:
/*  692 */       strFieldValue = StrTool.GBKToUnicode(this.branchName);
/*  693 */       break;
/*      */     case 10:
/*  695 */       strFieldValue = StrTool.GBKToUnicode(this.branchAttr);
/*  696 */       break;
/*      */     case 11:
/*  698 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  699 */       break;
/*      */     case 12:
/*  701 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*  702 */       break;
/*      */     case 13:
/*  704 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  705 */       break;
/*      */     case 14:
/*  707 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*  708 */       break;
/*      */     case 15:
/*  710 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  711 */       break;
/*      */     case 16:
/*  713 */       strFieldValue = StrTool.GBKToUnicode(this.p2);
/*  714 */       break;
/*      */     case 17:
/*  716 */       strFieldValue = StrTool.GBKToUnicode(this.p4);
/*  717 */       break;
/*      */     case 18:
/*  719 */       strFieldValue = StrTool.GBKToUnicode(this.p3);
/*  720 */       break;
/*      */     case 19:
/*  722 */       strFieldValue = StrTool.GBKToUnicode(this.p1);
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
/*  757 */     if (FCode.equals("grpContNo"))
/*      */     {
/*  759 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  761 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/*  764 */         this.grpContNo = null;
/*      */     }
/*  766 */     if (FCode.equals("contNo"))
/*      */     {
/*  768 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  770 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/*  773 */         this.contNo = null;
/*      */     }
/*  775 */     if (FCode.equals("proposalContNo"))
/*      */     {
/*  777 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  779 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/*  782 */         this.proposalContNo = null;
/*      */     }
/*  784 */     if (FCode.equals("prtNo"))
/*      */     {
/*  786 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  788 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/*  791 */         this.prtNo = null;
/*      */     }
/*  793 */     if (FCode.equals("agentOrder"))
/*      */     {
/*  795 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  797 */         this.agentOrder = FValue.trim();
/*      */       }
/*      */       else
/*  800 */         this.agentOrder = null;
/*      */     }
/*  802 */     if (FCode.equals("agentName"))
/*      */     {
/*  804 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  806 */         this.agentName = FValue.trim();
/*      */       }
/*      */       else
/*  809 */         this.agentName = null;
/*      */     }
/*  811 */     if (FCode.equals("agentCode"))
/*      */     {
/*  813 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  815 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/*  818 */         this.agentCode = null;
/*      */     }
/*  820 */     if (FCode.equals("branchName"))
/*      */     {
/*  822 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  824 */         this.branchName = FValue.trim();
/*      */       }
/*      */       else
/*  827 */         this.branchName = null;
/*      */     }
/*  829 */     if (FCode.equals("branchAttr"))
/*      */     {
/*  831 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  833 */         this.branchAttr = FValue.trim();
/*      */       }
/*      */       else
/*  836 */         this.branchAttr = null;
/*      */     }
/*  838 */     if (FCode.equals("operator"))
/*      */     {
/*  840 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  842 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  845 */         this.operator = null;
/*      */     }
/*  847 */     if (FCode.equals("makeDate"))
/*      */     {
/*  849 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  851 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  854 */         this.makeDate = null;
/*      */     }
/*  856 */     if (FCode.equals("makeTime"))
/*      */     {
/*  858 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  860 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  863 */         this.makeTime = null;
/*      */     }
/*  865 */     if (FCode.equals("modifyDate"))
/*      */     {
/*  867 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  869 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  872 */         this.modifyDate = null;
/*      */     }
/*  874 */     if (FCode.equals("modifyTime"))
/*      */     {
/*  876 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  878 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  881 */         this.modifyTime = null;
/*      */     }
/*  883 */     if (FCode.equals("p2"))
/*      */     {
/*  885 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  887 */         this.p2 = FValue.trim();
/*      */       }
/*      */       else
/*  890 */         this.p2 = null;
/*      */     }
/*  892 */     if (FCode.equals("p4"))
/*      */     {
/*  894 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  896 */         this.p4 = FValue.trim();
/*      */       }
/*      */       else
/*  899 */         this.p4 = null;
/*      */     }
/*  901 */     if (FCode.equals("p3"))
/*      */     {
/*  903 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  905 */         this.p3 = FValue.trim();
/*      */       }
/*      */       else
/*  908 */         this.p3 = null;
/*      */     }
/*  910 */     if (FCode.equals("p1"))
/*      */     {
/*  912 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  914 */         this.p1 = FValue.trim();
/*      */       }
/*      */       else
/*  917 */         this.p1 = null;
/*      */     }
/*  919 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  924 */     if (this == otherObject) return true;
/*  925 */     if (otherObject == null) return false;
/*  926 */     if (getClass() != otherObject.getClass()) return false;
/*  927 */     LNPAgentInfoBSchema other = (LNPAgentInfoBSchema)otherObject;
/*  928 */     return 
/*  929 */       (this.EdorNo.equals(other.getEdorNo())) && 
/*  930 */       (this.serialNo.equals(other.getserialNo())) && 
/*  931 */       (this.grpContNo.equals(other.getgrpContNo())) && 
/*  932 */       (this.contNo.equals(other.getcontNo())) && 
/*  933 */       (this.proposalContNo.equals(other.getproposalContNo())) && 
/*  934 */       (this.prtNo.equals(other.getprtNo())) && 
/*  935 */       (this.agentOrder.equals(other.getagentOrder())) && 
/*  936 */       (this.agentName.equals(other.getagentName())) && 
/*  937 */       (this.agentCode.equals(other.getagentCode())) && 
/*  938 */       (this.branchName.equals(other.getbranchName())) && 
/*  939 */       (this.branchAttr.equals(other.getbranchAttr())) && 
/*  940 */       (this.operator.equals(other.getoperator())) && 
/*  941 */       (this.fDate.getString(this.makeDate).equals(other.getmakeDate())) && 
/*  942 */       (this.makeTime.equals(other.getmakeTime())) && 
/*  943 */       (this.fDate.getString(this.modifyDate).equals(other.getmodifyDate())) && 
/*  944 */       (this.modifyTime.equals(other.getmodifyTime())) && 
/*  945 */       (this.p2.equals(other.getp2())) && 
/*  946 */       (this.p4.equals(other.getp4())) && 
/*  947 */       (this.p3.equals(other.getp3())) && 
/*  948 */       (this.p1.equals(other.getp1()));
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
/*  966 */     if (strFieldName.equals("grpContNo")) {
/*  967 */       return 2;
/*      */     }
/*  969 */     if (strFieldName.equals("contNo")) {
/*  970 */       return 3;
/*      */     }
/*  972 */     if (strFieldName.equals("proposalContNo")) {
/*  973 */       return 4;
/*      */     }
/*  975 */     if (strFieldName.equals("prtNo")) {
/*  976 */       return 5;
/*      */     }
/*  978 */     if (strFieldName.equals("agentOrder")) {
/*  979 */       return 6;
/*      */     }
/*  981 */     if (strFieldName.equals("agentName")) {
/*  982 */       return 7;
/*      */     }
/*  984 */     if (strFieldName.equals("agentCode")) {
/*  985 */       return 8;
/*      */     }
/*  987 */     if (strFieldName.equals("branchName")) {
/*  988 */       return 9;
/*      */     }
/*  990 */     if (strFieldName.equals("branchAttr")) {
/*  991 */       return 10;
/*      */     }
/*  993 */     if (strFieldName.equals("operator")) {
/*  994 */       return 11;
/*      */     }
/*  996 */     if (strFieldName.equals("makeDate")) {
/*  997 */       return 12;
/*      */     }
/*  999 */     if (strFieldName.equals("makeTime")) {
/* 1000 */       return 13;
/*      */     }
/* 1002 */     if (strFieldName.equals("modifyDate")) {
/* 1003 */       return 14;
/*      */     }
/* 1005 */     if (strFieldName.equals("modifyTime")) {
/* 1006 */       return 15;
/*      */     }
/* 1008 */     if (strFieldName.equals("p2")) {
/* 1009 */       return 16;
/*      */     }
/* 1011 */     if (strFieldName.equals("p4")) {
/* 1012 */       return 17;
/*      */     }
/* 1014 */     if (strFieldName.equals("p3")) {
/* 1015 */       return 18;
/*      */     }
/* 1017 */     if (strFieldName.equals("p1")) {
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
/* 1035 */       strFieldName = "grpContNo";
/* 1036 */       break;
/*      */     case 3:
/* 1038 */       strFieldName = "contNo";
/* 1039 */       break;
/*      */     case 4:
/* 1041 */       strFieldName = "proposalContNo";
/* 1042 */       break;
/*      */     case 5:
/* 1044 */       strFieldName = "prtNo";
/* 1045 */       break;
/*      */     case 6:
/* 1047 */       strFieldName = "agentOrder";
/* 1048 */       break;
/*      */     case 7:
/* 1050 */       strFieldName = "agentName";
/* 1051 */       break;
/*      */     case 8:
/* 1053 */       strFieldName = "agentCode";
/* 1054 */       break;
/*      */     case 9:
/* 1056 */       strFieldName = "branchName";
/* 1057 */       break;
/*      */     case 10:
/* 1059 */       strFieldName = "branchAttr";
/* 1060 */       break;
/*      */     case 11:
/* 1062 */       strFieldName = "operator";
/* 1063 */       break;
/*      */     case 12:
/* 1065 */       strFieldName = "makeDate";
/* 1066 */       break;
/*      */     case 13:
/* 1068 */       strFieldName = "makeTime";
/* 1069 */       break;
/*      */     case 14:
/* 1071 */       strFieldName = "modifyDate";
/* 1072 */       break;
/*      */     case 15:
/* 1074 */       strFieldName = "modifyTime";
/* 1075 */       break;
/*      */     case 16:
/* 1077 */       strFieldName = "p2";
/* 1078 */       break;
/*      */     case 17:
/* 1080 */       strFieldName = "p4";
/* 1081 */       break;
/*      */     case 18:
/* 1083 */       strFieldName = "p3";
/* 1084 */       break;
/*      */     case 19:
/* 1086 */       strFieldName = "p1";
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
/* 1103 */     if (strFieldName.equals("grpContNo")) {
/* 1104 */       return 0;
/*      */     }
/* 1106 */     if (strFieldName.equals("contNo")) {
/* 1107 */       return 0;
/*      */     }
/* 1109 */     if (strFieldName.equals("proposalContNo")) {
/* 1110 */       return 0;
/*      */     }
/* 1112 */     if (strFieldName.equals("prtNo")) {
/* 1113 */       return 0;
/*      */     }
/* 1115 */     if (strFieldName.equals("agentOrder")) {
/* 1116 */       return 0;
/*      */     }
/* 1118 */     if (strFieldName.equals("agentName")) {
/* 1119 */       return 0;
/*      */     }
/* 1121 */     if (strFieldName.equals("agentCode")) {
/* 1122 */       return 0;
/*      */     }
/* 1124 */     if (strFieldName.equals("branchName")) {
/* 1125 */       return 0;
/*      */     }
/* 1127 */     if (strFieldName.equals("branchAttr")) {
/* 1128 */       return 0;
/*      */     }
/* 1130 */     if (strFieldName.equals("operator")) {
/* 1131 */       return 0;
/*      */     }
/* 1133 */     if (strFieldName.equals("makeDate")) {
/* 1134 */       return 1;
/*      */     }
/* 1136 */     if (strFieldName.equals("makeTime")) {
/* 1137 */       return 0;
/*      */     }
/* 1139 */     if (strFieldName.equals("modifyDate")) {
/* 1140 */       return 1;
/*      */     }
/* 1142 */     if (strFieldName.equals("modifyTime")) {
/* 1143 */       return 0;
/*      */     }
/* 1145 */     if (strFieldName.equals("p2")) {
/* 1146 */       return 0;
/*      */     }
/* 1148 */     if (strFieldName.equals("p4")) {
/* 1149 */       return 0;
/*      */     }
/* 1151 */     if (strFieldName.equals("p3")) {
/* 1152 */       return 0;
/*      */     }
/* 1154 */     if (strFieldName.equals("p1")) {
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
/* 1202 */       nFieldType = 1;
/* 1203 */       break;
/*      */     case 13:
/* 1205 */       nFieldType = 0;
/* 1206 */       break;
/*      */     case 14:
/* 1208 */       nFieldType = 1;
/* 1209 */       break;
/*      */     case 15:
/* 1211 */       nFieldType = 0;
/* 1212 */       break;
/*      */     case 16:
/* 1214 */       nFieldType = 0;
/* 1215 */       break;
/*      */     case 17:
/* 1217 */       nFieldType = 0;
/* 1218 */       break;
/*      */     case 18:
/* 1220 */       nFieldType = 0;
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
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPAgentInfoBSchema
 * JD-Core Version:    0.6.0
 */