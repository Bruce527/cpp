/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAgentIImpResultDB;
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
/*      */ public class LNPAgentIImpResultSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String resultId;
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String impartId;
/*      */   private String grouporder;
/*      */   private String qID01;
/*      */   private String a01;
/*      */   private String qID02;
/*      */   private String a02;
/*      */   private String qID03;
/*      */   private String a03;
/*      */   private String qID04;
/*      */   private String a04;
/*      */   private String qID05;
/*      */   private String a05;
/*      */   private String qID06;
/*      */   private String a06;
/*      */   private String operator;
/*      */   private String manageCom;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 24;
/*      */   private static String[] PK;
/*   75 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPAgentIImpResultSchema()
/*      */   {
/*   82 */     this.mErrors = new CErrors();
/*      */ 
/*   84 */     String[] pk = new String[2];
/*   85 */     pk[0] = "ResultId";
/*   86 */     pk[1] = "Grouporder";
/*      */ 
/*   88 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   95 */     LNPAgentIImpResultSchema cloned = (LNPAgentIImpResultSchema)super.clone();
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
/*      */   public String getResultId()
/*      */   {
/*  109 */     return this.resultId;
/*      */   }
/*      */ 
/*      */   public void setResultId(String aResultId) {
/*  113 */     this.resultId = aResultId;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo() {
/*  117 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  121 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  125 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  129 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  133 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  137 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public String getImpartId() {
/*  141 */     return this.impartId;
/*      */   }
/*      */ 
/*      */   public void setImpartId(String aImpartId) {
/*  145 */     this.impartId = aImpartId;
/*      */   }
/*      */ 
/*      */   public String getGrouporder() {
/*  149 */     return this.grouporder;
/*      */   }
/*      */ 
/*      */   public void setGrouporder(String aGrouporder) {
/*  153 */     this.grouporder = aGrouporder;
/*      */   }
/*      */ 
/*      */   public String getQID01() {
/*  157 */     return this.qID01;
/*      */   }
/*      */ 
/*      */   public void setQID01(String aQID01) {
/*  161 */     this.qID01 = aQID01;
/*      */   }
/*      */ 
/*      */   public String getA01() {
/*  165 */     return this.a01;
/*      */   }
/*      */ 
/*      */   public void setA01(String aA01) {
/*  169 */     this.a01 = aA01;
/*      */   }
/*      */ 
/*      */   public String getQID02() {
/*  173 */     return this.qID02;
/*      */   }
/*      */ 
/*      */   public void setQID02(String aQID02) {
/*  177 */     this.qID02 = aQID02;
/*      */   }
/*      */ 
/*      */   public String getA02() {
/*  181 */     return this.a02;
/*      */   }
/*      */ 
/*      */   public void setA02(String aA02) {
/*  185 */     this.a02 = aA02;
/*      */   }
/*      */ 
/*      */   public String getQID03() {
/*  189 */     return this.qID03;
/*      */   }
/*      */ 
/*      */   public void setQID03(String aQID03) {
/*  193 */     this.qID03 = aQID03;
/*      */   }
/*      */ 
/*      */   public String getA03() {
/*  197 */     return this.a03;
/*      */   }
/*      */ 
/*      */   public void setA03(String aA03) {
/*  201 */     this.a03 = aA03;
/*      */   }
/*      */ 
/*      */   public String getQID04() {
/*  205 */     return this.qID04;
/*      */   }
/*      */ 
/*      */   public void setQID04(String aQID04) {
/*  209 */     this.qID04 = aQID04;
/*      */   }
/*      */ 
/*      */   public String getA04() {
/*  213 */     return this.a04;
/*      */   }
/*      */ 
/*      */   public void setA04(String aA04) {
/*  217 */     this.a04 = aA04;
/*      */   }
/*      */ 
/*      */   public String getQID05() {
/*  221 */     return this.qID05;
/*      */   }
/*      */ 
/*      */   public void setQID05(String aQID05) {
/*  225 */     this.qID05 = aQID05;
/*      */   }
/*      */ 
/*      */   public String getA05() {
/*  229 */     return this.a05;
/*      */   }
/*      */ 
/*      */   public void setA05(String aA05) {
/*  233 */     this.a05 = aA05;
/*      */   }
/*      */ 
/*      */   public String getQID06() {
/*  237 */     return this.qID06;
/*      */   }
/*      */ 
/*      */   public void setQID06(String aQID06) {
/*  241 */     this.qID06 = aQID06;
/*      */   }
/*      */ 
/*      */   public String getA06() {
/*  245 */     return this.a06;
/*      */   }
/*      */ 
/*      */   public void setA06(String aA06) {
/*  249 */     this.a06 = aA06;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  253 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  257 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  261 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  265 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  269 */     if (this.makeDate != null) {
/*  270 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  272 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  276 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  280 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  282 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  285 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  290 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  294 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  298 */     if (this.modifyDate != null) {
/*  299 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  301 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  305 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  309 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  311 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  314 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  319 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  323 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPAgentIImpResultSchema aLNPAgentIImpResultSchema)
/*      */   {
/*  329 */     this.resultId = aLNPAgentIImpResultSchema.getResultId();
/*  330 */     this.grpContNo = aLNPAgentIImpResultSchema.getGrpContNo();
/*  331 */     this.contNo = aLNPAgentIImpResultSchema.getContNo();
/*  332 */     this.proposalContNo = aLNPAgentIImpResultSchema.getProposalContNo();
/*  333 */     this.impartId = aLNPAgentIImpResultSchema.getImpartId();
/*  334 */     this.grouporder = aLNPAgentIImpResultSchema.getGrouporder();
/*  335 */     this.qID01 = aLNPAgentIImpResultSchema.getQID01();
/*  336 */     this.a01 = aLNPAgentIImpResultSchema.getA01();
/*  337 */     this.qID02 = aLNPAgentIImpResultSchema.getQID02();
/*  338 */     this.a02 = aLNPAgentIImpResultSchema.getA02();
/*  339 */     this.qID03 = aLNPAgentIImpResultSchema.getQID03();
/*  340 */     this.a03 = aLNPAgentIImpResultSchema.getA03();
/*  341 */     this.qID04 = aLNPAgentIImpResultSchema.getQID04();
/*  342 */     this.a04 = aLNPAgentIImpResultSchema.getA04();
/*  343 */     this.qID05 = aLNPAgentIImpResultSchema.getQID05();
/*  344 */     this.a05 = aLNPAgentIImpResultSchema.getA05();
/*  345 */     this.qID06 = aLNPAgentIImpResultSchema.getQID06();
/*  346 */     this.a06 = aLNPAgentIImpResultSchema.getA06();
/*  347 */     this.operator = aLNPAgentIImpResultSchema.getOperator();
/*  348 */     this.manageCom = aLNPAgentIImpResultSchema.getManageCom();
/*  349 */     this.makeDate = this.fDate.getDate(aLNPAgentIImpResultSchema.getMakeDate());
/*  350 */     this.makeTime = aLNPAgentIImpResultSchema.getMakeTime();
/*  351 */     this.modifyDate = this.fDate.getDate(aLNPAgentIImpResultSchema.getModifyDate());
/*  352 */     this.modifyTime = aLNPAgentIImpResultSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  361 */       if (rs.getString("ResultId") == null)
/*  362 */         this.resultId = null;
/*      */       else {
/*  364 */         this.resultId = rs.getString("ResultId").trim();
/*      */       }
/*  366 */       if (rs.getString("GrpContNo") == null)
/*  367 */         this.grpContNo = null;
/*      */       else {
/*  369 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  371 */       if (rs.getString("ContNo") == null)
/*  372 */         this.contNo = null;
/*      */       else {
/*  374 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  376 */       if (rs.getString("ProposalContNo") == null)
/*  377 */         this.proposalContNo = null;
/*      */       else {
/*  379 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  381 */       if (rs.getString("ImpartId") == null)
/*  382 */         this.impartId = null;
/*      */       else {
/*  384 */         this.impartId = rs.getString("ImpartId").trim();
/*      */       }
/*  386 */       if (rs.getString("Grouporder") == null)
/*  387 */         this.grouporder = null;
/*      */       else {
/*  389 */         this.grouporder = rs.getString("Grouporder").trim();
/*      */       }
/*  391 */       if (rs.getString("QID01") == null)
/*  392 */         this.qID01 = null;
/*      */       else {
/*  394 */         this.qID01 = rs.getString("QID01").trim();
/*      */       }
/*  396 */       if (rs.getString("A01") == null)
/*  397 */         this.a01 = null;
/*      */       else {
/*  399 */         this.a01 = rs.getString("A01").trim();
/*      */       }
/*  401 */       if (rs.getString("QID02") == null)
/*  402 */         this.qID02 = null;
/*      */       else {
/*  404 */         this.qID02 = rs.getString("QID02").trim();
/*      */       }
/*  406 */       if (rs.getString("A02") == null)
/*  407 */         this.a02 = null;
/*      */       else {
/*  409 */         this.a02 = rs.getString("A02").trim();
/*      */       }
/*  411 */       if (rs.getString("QID03") == null)
/*  412 */         this.qID03 = null;
/*      */       else {
/*  414 */         this.qID03 = rs.getString("QID03").trim();
/*      */       }
/*  416 */       if (rs.getString("A03") == null)
/*  417 */         this.a03 = null;
/*      */       else {
/*  419 */         this.a03 = rs.getString("A03").trim();
/*      */       }
/*  421 */       if (rs.getString("QID04") == null)
/*  422 */         this.qID04 = null;
/*      */       else {
/*  424 */         this.qID04 = rs.getString("QID04").trim();
/*      */       }
/*  426 */       if (rs.getString("A04") == null)
/*  427 */         this.a04 = null;
/*      */       else {
/*  429 */         this.a04 = rs.getString("A04").trim();
/*      */       }
/*  431 */       if (rs.getString("QID05") == null)
/*  432 */         this.qID05 = null;
/*      */       else {
/*  434 */         this.qID05 = rs.getString("QID05").trim();
/*      */       }
/*  436 */       if (rs.getString("A05") == null)
/*  437 */         this.a05 = null;
/*      */       else {
/*  439 */         this.a05 = rs.getString("A05").trim();
/*      */       }
/*  441 */       if (rs.getString("QID06") == null)
/*  442 */         this.qID06 = null;
/*      */       else {
/*  444 */         this.qID06 = rs.getString("QID06").trim();
/*      */       }
/*  446 */       if (rs.getString("A06") == null)
/*  447 */         this.a06 = null;
/*      */       else {
/*  449 */         this.a06 = rs.getString("A06").trim();
/*      */       }
/*  451 */       if (rs.getString("Operator") == null)
/*  452 */         this.operator = null;
/*      */       else {
/*  454 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  456 */       if (rs.getString("ManageCom") == null)
/*  457 */         this.manageCom = null;
/*      */       else {
/*  459 */         this.manageCom = rs.getString("ManageCom").trim();
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
/*  476 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPAgentIImpResult\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/*  478 */       CError tError = new CError();
/*  479 */       tError.moduleName = "LNPAgentIImpResultSchema";
/*  480 */       tError.functionName = "setSchema";
/*  481 */       tError.errorMessage = sqle.toString();
/*  482 */       this.mErrors.addOneError(tError);
/*  483 */       return false;
/*      */     }
/*  485 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAgentIImpResultSchema getSchema()
/*      */   {
/*  490 */     LNPAgentIImpResultSchema aLNPAgentIImpResultSchema = new LNPAgentIImpResultSchema();
/*  491 */     aLNPAgentIImpResultSchema.setSchema(this);
/*  492 */     return aLNPAgentIImpResultSchema;
/*      */   }
/*      */ 
/*      */   public LNPAgentIImpResultDB getDB()
/*      */   {
/*  497 */     LNPAgentIImpResultDB aDBOper = new LNPAgentIImpResultDB();
/*  498 */     aDBOper.setSchema(this);
/*  499 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  506 */     StringBuffer strReturn = new StringBuffer(256);
/*  507 */     strReturn.append(StrTool.cTrim(this.resultId)); strReturn.append("|");
/*  508 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/*  509 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/*  510 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/*  511 */     strReturn.append(StrTool.cTrim(this.impartId)); strReturn.append("|");
/*  512 */     strReturn.append(StrTool.cTrim(this.grouporder)); strReturn.append("|");
/*  513 */     strReturn.append(StrTool.cTrim(this.qID01)); strReturn.append("|");
/*  514 */     strReturn.append(StrTool.cTrim(this.a01)); strReturn.append("|");
/*  515 */     strReturn.append(StrTool.cTrim(this.qID02)); strReturn.append("|");
/*  516 */     strReturn.append(StrTool.cTrim(this.a02)); strReturn.append("|");
/*  517 */     strReturn.append(StrTool.cTrim(this.qID03)); strReturn.append("|");
/*  518 */     strReturn.append(StrTool.cTrim(this.a03)); strReturn.append("|");
/*  519 */     strReturn.append(StrTool.cTrim(this.qID04)); strReturn.append("|");
/*  520 */     strReturn.append(StrTool.cTrim(this.a04)); strReturn.append("|");
/*  521 */     strReturn.append(StrTool.cTrim(this.qID05)); strReturn.append("|");
/*  522 */     strReturn.append(StrTool.cTrim(this.a05)); strReturn.append("|");
/*  523 */     strReturn.append(StrTool.cTrim(this.qID06)); strReturn.append("|");
/*  524 */     strReturn.append(StrTool.cTrim(this.a06)); strReturn.append("|");
/*  525 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  526 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  527 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  528 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  529 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  530 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  531 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  539 */       this.resultId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  540 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  541 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  542 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  543 */       this.impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  544 */       this.grouporder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  545 */       this.qID01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  546 */       this.a01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  547 */       this.qID02 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  548 */       this.a02 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  549 */       this.qID03 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  550 */       this.a03 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  551 */       this.qID04 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  552 */       this.a04 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  553 */       this.qID05 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  554 */       this.a05 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  555 */       this.qID06 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  556 */       this.a06 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  557 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  558 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  559 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
/*  560 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  561 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
/*  562 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  567 */       CError tError = new CError();
/*  568 */       tError.moduleName = "LNPAgentIImpResultSchema";
/*  569 */       tError.functionName = "decode";
/*  570 */       tError.errorMessage = ex.toString();
/*  571 */       this.mErrors.addOneError(tError);
/*      */ 
/*  573 */       return false;
/*      */     }
/*  575 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  581 */     String strReturn = "";
/*  582 */     if (FCode.equalsIgnoreCase("resultId"))
/*      */     {
/*  584 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.resultId));
/*      */     }
/*  586 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  588 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  590 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  592 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  594 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  596 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  598 */     if (FCode.equalsIgnoreCase("impartId"))
/*      */     {
/*  600 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartId));
/*      */     }
/*  602 */     if (FCode.equalsIgnoreCase("grouporder"))
/*      */     {
/*  604 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grouporder));
/*      */     }
/*  606 */     if (FCode.equalsIgnoreCase("qID01"))
/*      */     {
/*  608 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID01));
/*      */     }
/*  610 */     if (FCode.equalsIgnoreCase("a01"))
/*      */     {
/*  612 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a01));
/*      */     }
/*  614 */     if (FCode.equalsIgnoreCase("qID02"))
/*      */     {
/*  616 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID02));
/*      */     }
/*  618 */     if (FCode.equalsIgnoreCase("a02"))
/*      */     {
/*  620 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a02));
/*      */     }
/*  622 */     if (FCode.equalsIgnoreCase("qID03"))
/*      */     {
/*  624 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID03));
/*      */     }
/*  626 */     if (FCode.equalsIgnoreCase("a03"))
/*      */     {
/*  628 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a03));
/*      */     }
/*  630 */     if (FCode.equalsIgnoreCase("qID04"))
/*      */     {
/*  632 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID04));
/*      */     }
/*  634 */     if (FCode.equalsIgnoreCase("a04"))
/*      */     {
/*  636 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a04));
/*      */     }
/*  638 */     if (FCode.equalsIgnoreCase("qID05"))
/*      */     {
/*  640 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID05));
/*      */     }
/*  642 */     if (FCode.equalsIgnoreCase("a05"))
/*      */     {
/*  644 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a05));
/*      */     }
/*  646 */     if (FCode.equalsIgnoreCase("qID06"))
/*      */     {
/*  648 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID06));
/*      */     }
/*  650 */     if (FCode.equalsIgnoreCase("a06"))
/*      */     {
/*  652 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a06));
/*      */     }
/*  654 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  656 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  658 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  660 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  662 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  664 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  666 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  668 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  670 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  672 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  676 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  678 */     if (strReturn.equals(""))
/*      */     {
/*  680 */       strReturn = "null";
/*      */     }
/*      */ 
/*  683 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  690 */     String strFieldValue = "";
/*  691 */     switch (nFieldIndex) {
/*      */     case 0:
/*  693 */       strFieldValue = StrTool.GBKToUnicode(this.resultId);
/*  694 */       break;
/*      */     case 1:
/*  696 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  697 */       break;
/*      */     case 2:
/*  699 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  700 */       break;
/*      */     case 3:
/*  702 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  703 */       break;
/*      */     case 4:
/*  705 */       strFieldValue = StrTool.GBKToUnicode(this.impartId);
/*  706 */       break;
/*      */     case 5:
/*  708 */       strFieldValue = StrTool.GBKToUnicode(this.grouporder);
/*  709 */       break;
/*      */     case 6:
/*  711 */       strFieldValue = StrTool.GBKToUnicode(this.qID01);
/*  712 */       break;
/*      */     case 7:
/*  714 */       strFieldValue = StrTool.GBKToUnicode(this.a01);
/*  715 */       break;
/*      */     case 8:
/*  717 */       strFieldValue = StrTool.GBKToUnicode(this.qID02);
/*  718 */       break;
/*      */     case 9:
/*  720 */       strFieldValue = StrTool.GBKToUnicode(this.a02);
/*  721 */       break;
/*      */     case 10:
/*  723 */       strFieldValue = StrTool.GBKToUnicode(this.qID03);
/*  724 */       break;
/*      */     case 11:
/*  726 */       strFieldValue = StrTool.GBKToUnicode(this.a03);
/*  727 */       break;
/*      */     case 12:
/*  729 */       strFieldValue = StrTool.GBKToUnicode(this.qID04);
/*  730 */       break;
/*      */     case 13:
/*  732 */       strFieldValue = StrTool.GBKToUnicode(this.a04);
/*  733 */       break;
/*      */     case 14:
/*  735 */       strFieldValue = StrTool.GBKToUnicode(this.qID05);
/*  736 */       break;
/*      */     case 15:
/*  738 */       strFieldValue = StrTool.GBKToUnicode(this.a05);
/*  739 */       break;
/*      */     case 16:
/*  741 */       strFieldValue = StrTool.GBKToUnicode(this.qID06);
/*  742 */       break;
/*      */     case 17:
/*  744 */       strFieldValue = StrTool.GBKToUnicode(this.a06);
/*  745 */       break;
/*      */     case 18:
/*  747 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  748 */       break;
/*      */     case 19:
/*  750 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  751 */       break;
/*      */     case 20:
/*  753 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  754 */       break;
/*      */     case 21:
/*  756 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  757 */       break;
/*      */     case 22:
/*  759 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  760 */       break;
/*      */     case 23:
/*  762 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  763 */       break;
/*      */     default:
/*  765 */       strFieldValue = "";
/*      */     }
/*  767 */     if (strFieldValue.equals("")) {
/*  768 */       strFieldValue = "null";
/*      */     }
/*  770 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  776 */     if (StrTool.cTrim(FCode).equals("")) {
/*  777 */       return false;
/*      */     }
/*  779 */     if (FCode.equalsIgnoreCase("resultId"))
/*      */     {
/*  781 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  783 */         this.resultId = FValue.trim();
/*      */       }
/*      */       else
/*  786 */         this.resultId = null;
/*      */     }
/*  788 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  790 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  792 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/*  795 */         this.grpContNo = null;
/*      */     }
/*  797 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  799 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  801 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/*  804 */         this.contNo = null;
/*      */     }
/*  806 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  808 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  810 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/*  813 */         this.proposalContNo = null;
/*      */     }
/*  815 */     if (FCode.equalsIgnoreCase("impartId"))
/*      */     {
/*  817 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  819 */         this.impartId = FValue.trim();
/*      */       }
/*      */       else
/*  822 */         this.impartId = null;
/*      */     }
/*  824 */     if (FCode.equalsIgnoreCase("grouporder"))
/*      */     {
/*  826 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  828 */         this.grouporder = FValue.trim();
/*      */       }
/*      */       else
/*  831 */         this.grouporder = null;
/*      */     }
/*  833 */     if (FCode.equalsIgnoreCase("qID01"))
/*      */     {
/*  835 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  837 */         this.qID01 = FValue.trim();
/*      */       }
/*      */       else
/*  840 */         this.qID01 = null;
/*      */     }
/*  842 */     if (FCode.equalsIgnoreCase("a01"))
/*      */     {
/*  844 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  846 */         this.a01 = FValue.trim();
/*      */       }
/*      */       else
/*  849 */         this.a01 = null;
/*      */     }
/*  851 */     if (FCode.equalsIgnoreCase("qID02"))
/*      */     {
/*  853 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  855 */         this.qID02 = FValue.trim();
/*      */       }
/*      */       else
/*  858 */         this.qID02 = null;
/*      */     }
/*  860 */     if (FCode.equalsIgnoreCase("a02"))
/*      */     {
/*  862 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  864 */         this.a02 = FValue.trim();
/*      */       }
/*      */       else
/*  867 */         this.a02 = null;
/*      */     }
/*  869 */     if (FCode.equalsIgnoreCase("qID03"))
/*      */     {
/*  871 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  873 */         this.qID03 = FValue.trim();
/*      */       }
/*      */       else
/*  876 */         this.qID03 = null;
/*      */     }
/*  878 */     if (FCode.equalsIgnoreCase("a03"))
/*      */     {
/*  880 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  882 */         this.a03 = FValue.trim();
/*      */       }
/*      */       else
/*  885 */         this.a03 = null;
/*      */     }
/*  887 */     if (FCode.equalsIgnoreCase("qID04"))
/*      */     {
/*  889 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  891 */         this.qID04 = FValue.trim();
/*      */       }
/*      */       else
/*  894 */         this.qID04 = null;
/*      */     }
/*  896 */     if (FCode.equalsIgnoreCase("a04"))
/*      */     {
/*  898 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  900 */         this.a04 = FValue.trim();
/*      */       }
/*      */       else
/*  903 */         this.a04 = null;
/*      */     }
/*  905 */     if (FCode.equalsIgnoreCase("qID05"))
/*      */     {
/*  907 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  909 */         this.qID05 = FValue.trim();
/*      */       }
/*      */       else
/*  912 */         this.qID05 = null;
/*      */     }
/*  914 */     if (FCode.equalsIgnoreCase("a05"))
/*      */     {
/*  916 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  918 */         this.a05 = FValue.trim();
/*      */       }
/*      */       else
/*  921 */         this.a05 = null;
/*      */     }
/*  923 */     if (FCode.equalsIgnoreCase("qID06"))
/*      */     {
/*  925 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  927 */         this.qID06 = FValue.trim();
/*      */       }
/*      */       else
/*  930 */         this.qID06 = null;
/*      */     }
/*  932 */     if (FCode.equalsIgnoreCase("a06"))
/*      */     {
/*  934 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  936 */         this.a06 = FValue.trim();
/*      */       }
/*      */       else
/*  939 */         this.a06 = null;
/*      */     }
/*  941 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  943 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  945 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  948 */         this.operator = null;
/*      */     }
/*  950 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  952 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  954 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  957 */         this.manageCom = null;
/*      */     }
/*  959 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  961 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  963 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  966 */         this.makeDate = null;
/*      */     }
/*  968 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  970 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  972 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  975 */         this.makeTime = null;
/*      */     }
/*  977 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  979 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  981 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  984 */         this.modifyDate = null;
/*      */     }
/*  986 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  988 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  990 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  993 */         this.modifyTime = null;
/*      */     }
/*  995 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1000 */     if (otherObject == null) return false;
/* 1001 */     if (this == otherObject) return true;
/* 1002 */     if (getClass() != otherObject.getClass()) return false;
/* 1003 */     LNPAgentIImpResultSchema other = (LNPAgentIImpResultSchema)otherObject;
/* 1004 */     if ((this.resultId == null) && (other.getResultId() != null)) return false;
/* 1005 */     if ((this.resultId != null) && (!this.resultId.equals(other.getResultId()))) return false;
/* 1006 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/* 1007 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/* 1008 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/* 1009 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/* 1010 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/* 1011 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/* 1012 */     if ((this.impartId == null) && (other.getImpartId() != null)) return false;
/* 1013 */     if ((this.impartId != null) && (!this.impartId.equals(other.getImpartId()))) return false;
/* 1014 */     if ((this.grouporder == null) && (other.getGrouporder() != null)) return false;
/* 1015 */     if ((this.grouporder != null) && (!this.grouporder.equals(other.getGrouporder()))) return false;
/* 1016 */     if ((this.qID01 == null) && (other.getQID01() != null)) return false;
/* 1017 */     if ((this.qID01 != null) && (!this.qID01.equals(other.getQID01()))) return false;
/* 1018 */     if ((this.a01 == null) && (other.getA01() != null)) return false;
/* 1019 */     if ((this.a01 != null) && (!this.a01.equals(other.getA01()))) return false;
/* 1020 */     if ((this.qID02 == null) && (other.getQID02() != null)) return false;
/* 1021 */     if ((this.qID02 != null) && (!this.qID02.equals(other.getQID02()))) return false;
/* 1022 */     if ((this.a02 == null) && (other.getA02() != null)) return false;
/* 1023 */     if ((this.a02 != null) && (!this.a02.equals(other.getA02()))) return false;
/* 1024 */     if ((this.qID03 == null) && (other.getQID03() != null)) return false;
/* 1025 */     if ((this.qID03 != null) && (!this.qID03.equals(other.getQID03()))) return false;
/* 1026 */     if ((this.a03 == null) && (other.getA03() != null)) return false;
/* 1027 */     if ((this.a03 != null) && (!this.a03.equals(other.getA03()))) return false;
/* 1028 */     if ((this.qID04 == null) && (other.getQID04() != null)) return false;
/* 1029 */     if ((this.qID04 != null) && (!this.qID04.equals(other.getQID04()))) return false;
/* 1030 */     if ((this.a04 == null) && (other.getA04() != null)) return false;
/* 1031 */     if ((this.a04 != null) && (!this.a04.equals(other.getA04()))) return false;
/* 1032 */     if ((this.qID05 == null) && (other.getQID05() != null)) return false;
/* 1033 */     if ((this.qID05 != null) && (!this.qID05.equals(other.getQID05()))) return false;
/* 1034 */     if ((this.a05 == null) && (other.getA05() != null)) return false;
/* 1035 */     if ((this.a05 != null) && (!this.a05.equals(other.getA05()))) return false;
/* 1036 */     if ((this.qID06 == null) && (other.getQID06() != null)) return false;
/* 1037 */     if ((this.qID06 != null) && (!this.qID06.equals(other.getQID06()))) return false;
/* 1038 */     if ((this.a06 == null) && (other.getA06() != null)) return false;
/* 1039 */     if ((this.a06 != null) && (!this.a06.equals(other.getA06()))) return false;
/* 1040 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1041 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1042 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1043 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1044 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1045 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1046 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1047 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1048 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1049 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1050 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1051 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1058 */     return 24;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1064 */     if (strFieldName.equals("resultId")) {
/* 1065 */       return 0;
/*      */     }
/* 1067 */     if (strFieldName.equals("grpContNo")) {
/* 1068 */       return 1;
/*      */     }
/* 1070 */     if (strFieldName.equals("contNo")) {
/* 1071 */       return 2;
/*      */     }
/* 1073 */     if (strFieldName.equals("proposalContNo")) {
/* 1074 */       return 3;
/*      */     }
/* 1076 */     if (strFieldName.equals("impartId")) {
/* 1077 */       return 4;
/*      */     }
/* 1079 */     if (strFieldName.equals("grouporder")) {
/* 1080 */       return 5;
/*      */     }
/* 1082 */     if (strFieldName.equals("qID01")) {
/* 1083 */       return 6;
/*      */     }
/* 1085 */     if (strFieldName.equals("a01")) {
/* 1086 */       return 7;
/*      */     }
/* 1088 */     if (strFieldName.equals("qID02")) {
/* 1089 */       return 8;
/*      */     }
/* 1091 */     if (strFieldName.equals("a02")) {
/* 1092 */       return 9;
/*      */     }
/* 1094 */     if (strFieldName.equals("qID03")) {
/* 1095 */       return 10;
/*      */     }
/* 1097 */     if (strFieldName.equals("a03")) {
/* 1098 */       return 11;
/*      */     }
/* 1100 */     if (strFieldName.equals("qID04")) {
/* 1101 */       return 12;
/*      */     }
/* 1103 */     if (strFieldName.equals("a04")) {
/* 1104 */       return 13;
/*      */     }
/* 1106 */     if (strFieldName.equals("qID05")) {
/* 1107 */       return 14;
/*      */     }
/* 1109 */     if (strFieldName.equals("a05")) {
/* 1110 */       return 15;
/*      */     }
/* 1112 */     if (strFieldName.equals("qID06")) {
/* 1113 */       return 16;
/*      */     }
/* 1115 */     if (strFieldName.equals("a06")) {
/* 1116 */       return 17;
/*      */     }
/* 1118 */     if (strFieldName.equals("operator")) {
/* 1119 */       return 18;
/*      */     }
/* 1121 */     if (strFieldName.equals("manageCom")) {
/* 1122 */       return 19;
/*      */     }
/* 1124 */     if (strFieldName.equals("makeDate")) {
/* 1125 */       return 20;
/*      */     }
/* 1127 */     if (strFieldName.equals("makeTime")) {
/* 1128 */       return 21;
/*      */     }
/* 1130 */     if (strFieldName.equals("modifyDate")) {
/* 1131 */       return 22;
/*      */     }
/* 1133 */     if (strFieldName.equals("modifyTime")) {
/* 1134 */       return 23;
/*      */     }
/* 1136 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1142 */     String strFieldName = "";
/* 1143 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1145 */       strFieldName = "resultId";
/* 1146 */       break;
/*      */     case 1:
/* 1148 */       strFieldName = "grpContNo";
/* 1149 */       break;
/*      */     case 2:
/* 1151 */       strFieldName = "contNo";
/* 1152 */       break;
/*      */     case 3:
/* 1154 */       strFieldName = "proposalContNo";
/* 1155 */       break;
/*      */     case 4:
/* 1157 */       strFieldName = "impartId";
/* 1158 */       break;
/*      */     case 5:
/* 1160 */       strFieldName = "grouporder";
/* 1161 */       break;
/*      */     case 6:
/* 1163 */       strFieldName = "qID01";
/* 1164 */       break;
/*      */     case 7:
/* 1166 */       strFieldName = "a01";
/* 1167 */       break;
/*      */     case 8:
/* 1169 */       strFieldName = "qID02";
/* 1170 */       break;
/*      */     case 9:
/* 1172 */       strFieldName = "a02";
/* 1173 */       break;
/*      */     case 10:
/* 1175 */       strFieldName = "qID03";
/* 1176 */       break;
/*      */     case 11:
/* 1178 */       strFieldName = "a03";
/* 1179 */       break;
/*      */     case 12:
/* 1181 */       strFieldName = "qID04";
/* 1182 */       break;
/*      */     case 13:
/* 1184 */       strFieldName = "a04";
/* 1185 */       break;
/*      */     case 14:
/* 1187 */       strFieldName = "qID05";
/* 1188 */       break;
/*      */     case 15:
/* 1190 */       strFieldName = "a05";
/* 1191 */       break;
/*      */     case 16:
/* 1193 */       strFieldName = "qID06";
/* 1194 */       break;
/*      */     case 17:
/* 1196 */       strFieldName = "a06";
/* 1197 */       break;
/*      */     case 18:
/* 1199 */       strFieldName = "operator";
/* 1200 */       break;
/*      */     case 19:
/* 1202 */       strFieldName = "manageCom";
/* 1203 */       break;
/*      */     case 20:
/* 1205 */       strFieldName = "makeDate";
/* 1206 */       break;
/*      */     case 21:
/* 1208 */       strFieldName = "makeTime";
/* 1209 */       break;
/*      */     case 22:
/* 1211 */       strFieldName = "modifyDate";
/* 1212 */       break;
/*      */     case 23:
/* 1214 */       strFieldName = "modifyTime";
/* 1215 */       break;
/*      */     default:
/* 1217 */       strFieldName = "";
/*      */     }
/* 1219 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1225 */     if (strFieldName.equals("resultId")) {
/* 1226 */       return 0;
/*      */     }
/* 1228 */     if (strFieldName.equals("grpContNo")) {
/* 1229 */       return 0;
/*      */     }
/* 1231 */     if (strFieldName.equals("contNo")) {
/* 1232 */       return 0;
/*      */     }
/* 1234 */     if (strFieldName.equals("proposalContNo")) {
/* 1235 */       return 0;
/*      */     }
/* 1237 */     if (strFieldName.equals("impartId")) {
/* 1238 */       return 0;
/*      */     }
/* 1240 */     if (strFieldName.equals("grouporder")) {
/* 1241 */       return 0;
/*      */     }
/* 1243 */     if (strFieldName.equals("qID01")) {
/* 1244 */       return 0;
/*      */     }
/* 1246 */     if (strFieldName.equals("a01")) {
/* 1247 */       return 0;
/*      */     }
/* 1249 */     if (strFieldName.equals("qID02")) {
/* 1250 */       return 0;
/*      */     }
/* 1252 */     if (strFieldName.equals("a02")) {
/* 1253 */       return 0;
/*      */     }
/* 1255 */     if (strFieldName.equals("qID03")) {
/* 1256 */       return 0;
/*      */     }
/* 1258 */     if (strFieldName.equals("a03")) {
/* 1259 */       return 0;
/*      */     }
/* 1261 */     if (strFieldName.equals("qID04")) {
/* 1262 */       return 0;
/*      */     }
/* 1264 */     if (strFieldName.equals("a04")) {
/* 1265 */       return 0;
/*      */     }
/* 1267 */     if (strFieldName.equals("qID05")) {
/* 1268 */       return 0;
/*      */     }
/* 1270 */     if (strFieldName.equals("a05")) {
/* 1271 */       return 0;
/*      */     }
/* 1273 */     if (strFieldName.equals("qID06")) {
/* 1274 */       return 0;
/*      */     }
/* 1276 */     if (strFieldName.equals("a06")) {
/* 1277 */       return 0;
/*      */     }
/* 1279 */     if (strFieldName.equals("operator")) {
/* 1280 */       return 0;
/*      */     }
/* 1282 */     if (strFieldName.equals("manageCom")) {
/* 1283 */       return 0;
/*      */     }
/* 1285 */     if (strFieldName.equals("makeDate")) {
/* 1286 */       return 1;
/*      */     }
/* 1288 */     if (strFieldName.equals("makeTime")) {
/* 1289 */       return 0;
/*      */     }
/* 1291 */     if (strFieldName.equals("modifyDate")) {
/* 1292 */       return 1;
/*      */     }
/* 1294 */     if (strFieldName.equals("modifyTime")) {
/* 1295 */       return 0;
/*      */     }
/* 1297 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1303 */     int nFieldType = -1;
/* 1304 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1306 */       nFieldType = 0;
/* 1307 */       break;
/*      */     case 1:
/* 1309 */       nFieldType = 0;
/* 1310 */       break;
/*      */     case 2:
/* 1312 */       nFieldType = 0;
/* 1313 */       break;
/*      */     case 3:
/* 1315 */       nFieldType = 0;
/* 1316 */       break;
/*      */     case 4:
/* 1318 */       nFieldType = 0;
/* 1319 */       break;
/*      */     case 5:
/* 1321 */       nFieldType = 0;
/* 1322 */       break;
/*      */     case 6:
/* 1324 */       nFieldType = 0;
/* 1325 */       break;
/*      */     case 7:
/* 1327 */       nFieldType = 0;
/* 1328 */       break;
/*      */     case 8:
/* 1330 */       nFieldType = 0;
/* 1331 */       break;
/*      */     case 9:
/* 1333 */       nFieldType = 0;
/* 1334 */       break;
/*      */     case 10:
/* 1336 */       nFieldType = 0;
/* 1337 */       break;
/*      */     case 11:
/* 1339 */       nFieldType = 0;
/* 1340 */       break;
/*      */     case 12:
/* 1342 */       nFieldType = 0;
/* 1343 */       break;
/*      */     case 13:
/* 1345 */       nFieldType = 0;
/* 1346 */       break;
/*      */     case 14:
/* 1348 */       nFieldType = 0;
/* 1349 */       break;
/*      */     case 15:
/* 1351 */       nFieldType = 0;
/* 1352 */       break;
/*      */     case 16:
/* 1354 */       nFieldType = 0;
/* 1355 */       break;
/*      */     case 17:
/* 1357 */       nFieldType = 0;
/* 1358 */       break;
/*      */     case 18:
/* 1360 */       nFieldType = 0;
/* 1361 */       break;
/*      */     case 19:
/* 1363 */       nFieldType = 0;
/* 1364 */       break;
/*      */     case 20:
/* 1366 */       nFieldType = 1;
/* 1367 */       break;
/*      */     case 21:
/* 1369 */       nFieldType = 0;
/* 1370 */       break;
/*      */     case 22:
/* 1372 */       nFieldType = 1;
/* 1373 */       break;
/*      */     case 23:
/* 1375 */       nFieldType = 0;
/* 1376 */       break;
/*      */     default:
/* 1378 */       nFieldType = -1;
/*      */     }
/* 1380 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPAgentIImpResultSchema
 * JD-Core Version:    0.6.0
 */