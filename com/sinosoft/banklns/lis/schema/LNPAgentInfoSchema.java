/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
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
/*      */ public class LNPAgentInfoSchema
/*      */   implements Schema, Cloneable
/*      */ {
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
/*      */   private String polPrintType;
/*      */   public static final int FIELDNUM = 19;
/*      */   private static String[] PK;
/*   67 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPAgentInfoSchema()
/*      */   {
/*   74 */     this.mErrors = new CErrors();
/*      */ 
/*   76 */     String[] pk = new String[2];
/*   77 */     pk[0] = "ContNo";
/*   78 */     pk[1] = "AgentOrder";
/*      */ 
/*   80 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   87 */     LNPAgentInfoSchema cloned = (LNPAgentInfoSchema)super.clone();
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
/*      */   public String getGrpContNo()
/*      */   {
/*  101 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  105 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  109 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  113 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  117 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  121 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public String getPrtNo() {
/*  125 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setPrtNo(String aPrtNo) {
/*  129 */     this.prtNo = aPrtNo;
/*      */   }
/*      */ 
/*      */   public String getAgentOrder() {
/*  133 */     return this.agentOrder;
/*      */   }
/*      */ 
/*      */   public void setAgentOrder(String aAgentOrder) {
/*  137 */     this.agentOrder = aAgentOrder;
/*      */   }
/*      */ 
/*      */   public String getAgentName() {
/*  141 */     return this.agentName;
/*      */   }
/*      */ 
/*      */   public void setAgentName(String aAgentName) {
/*  145 */     this.agentName = aAgentName;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  149 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  153 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getBranchName() {
/*  157 */     return this.branchName;
/*      */   }
/*      */ 
/*      */   public void setBranchName(String aBranchName) {
/*  161 */     this.branchName = aBranchName;
/*      */   }
/*      */ 
/*      */   public String getBranchAttr() {
/*  165 */     return this.branchAttr;
/*      */   }
/*      */ 
/*      */   public void setBranchAttr(String aBranchAttr) {
/*  169 */     this.branchAttr = aBranchAttr;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  173 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  177 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  181 */     if (this.makeDate != null) {
/*  182 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  184 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  188 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  192 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  194 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  197 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  202 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  206 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  210 */     if (this.modifyDate != null) {
/*  211 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  213 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  217 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  221 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  223 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  226 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  231 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  235 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getP2() {
/*  239 */     return this.p2;
/*      */   }
/*      */ 
/*      */   public void setP2(String aP2) {
/*  243 */     this.p2 = aP2;
/*      */   }
/*      */ 
/*      */   public String getP4() {
/*  247 */     return this.p4;
/*      */   }
/*      */ 
/*      */   public void setP4(String aP4) {
/*  251 */     this.p4 = aP4;
/*      */   }
/*      */ 
/*      */   public String getP3() {
/*  255 */     return this.p3;
/*      */   }
/*      */ 
/*      */   public void setP3(String aP3) {
/*  259 */     this.p3 = aP3;
/*      */   }
/*      */ 
/*      */   public String getP1() {
/*  263 */     return this.p1;
/*      */   }
/*      */ 
/*      */   public void setP1(String aP1) {
/*  267 */     this.p1 = aP1;
/*      */   }
/*      */ 
/*      */   public String getPolPrintType()
/*      */   {
/*  272 */     return this.polPrintType;
/*      */   }
/*      */ 
/*      */   public void setPolPrintType(String polPrintType)
/*      */   {
/*  277 */     this.polPrintType = polPrintType;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPAgentInfoSchema aLNPAgentInfoSchema)
/*      */   {
/*  283 */     this.grpContNo = aLNPAgentInfoSchema.getGrpContNo();
/*  284 */     this.contNo = aLNPAgentInfoSchema.getContNo();
/*  285 */     this.proposalContNo = aLNPAgentInfoSchema.getProposalContNo();
/*  286 */     this.prtNo = aLNPAgentInfoSchema.getPrtNo();
/*  287 */     this.agentOrder = aLNPAgentInfoSchema.getAgentOrder();
/*  288 */     this.agentName = aLNPAgentInfoSchema.getAgentName();
/*  289 */     this.agentCode = aLNPAgentInfoSchema.getAgentCode();
/*  290 */     this.branchName = aLNPAgentInfoSchema.getBranchName();
/*  291 */     this.branchAttr = aLNPAgentInfoSchema.getBranchAttr();
/*  292 */     this.operator = aLNPAgentInfoSchema.getOperator();
/*  293 */     this.makeDate = this.fDate.getDate(aLNPAgentInfoSchema.getMakeDate());
/*  294 */     this.makeTime = aLNPAgentInfoSchema.getMakeTime();
/*  295 */     this.modifyDate = this.fDate.getDate(aLNPAgentInfoSchema.getModifyDate());
/*  296 */     this.modifyTime = aLNPAgentInfoSchema.getModifyTime();
/*  297 */     this.p2 = aLNPAgentInfoSchema.getP2();
/*  298 */     this.p4 = aLNPAgentInfoSchema.getP4();
/*  299 */     this.p3 = aLNPAgentInfoSchema.getP3();
/*  300 */     this.p1 = aLNPAgentInfoSchema.getP1();
/*  301 */     this.polPrintType = aLNPAgentInfoSchema.getPolPrintType();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  310 */       if (rs.getString("GrpContNo") == null)
/*  311 */         this.grpContNo = null;
/*      */       else {
/*  313 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  315 */       if (rs.getString("ContNo") == null)
/*  316 */         this.contNo = null;
/*      */       else {
/*  318 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  320 */       if (rs.getString("ProposalContNo") == null)
/*  321 */         this.proposalContNo = null;
/*      */       else {
/*  323 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  325 */       if (rs.getString("PrtNo") == null)
/*  326 */         this.prtNo = null;
/*      */       else {
/*  328 */         this.prtNo = rs.getString("PrtNo").trim();
/*      */       }
/*  330 */       if (rs.getString("AgentOrder") == null)
/*  331 */         this.agentOrder = null;
/*      */       else {
/*  333 */         this.agentOrder = rs.getString("AgentOrder").trim();
/*      */       }
/*  335 */       if (rs.getString("AgentName") == null)
/*  336 */         this.agentName = null;
/*      */       else {
/*  338 */         this.agentName = rs.getString("AgentName").trim();
/*      */       }
/*  340 */       if (rs.getString("AgentCode") == null)
/*  341 */         this.agentCode = null;
/*      */       else {
/*  343 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/*  345 */       if (rs.getString("BranchName") == null)
/*  346 */         this.branchName = null;
/*      */       else {
/*  348 */         this.branchName = rs.getString("BranchName").trim();
/*      */       }
/*  350 */       if (rs.getString("BranchAttr") == null)
/*  351 */         this.branchAttr = null;
/*      */       else {
/*  353 */         this.branchAttr = rs.getString("BranchAttr").trim();
/*      */       }
/*  355 */       if (rs.getString("Operator") == null)
/*  356 */         this.operator = null;
/*      */       else {
/*  358 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  360 */       this.makeDate = rs.getDate("MakeDate");
/*  361 */       if (rs.getString("MakeTime") == null)
/*  362 */         this.makeTime = null;
/*      */       else {
/*  364 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  366 */       this.modifyDate = rs.getDate("ModifyDate");
/*  367 */       if (rs.getString("ModifyTime") == null)
/*  368 */         this.modifyTime = null;
/*      */       else {
/*  370 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  372 */       if (rs.getString("p2") == null)
/*  373 */         this.p2 = null;
/*      */       else {
/*  375 */         this.p2 = rs.getString("p2").trim();
/*      */       }
/*  377 */       if (rs.getString("p4") == null)
/*  378 */         this.p4 = null;
/*      */       else {
/*  380 */         this.p4 = rs.getString("p4").trim();
/*      */       }
/*  382 */       if (rs.getString("p3") == null)
/*  383 */         this.p3 = null;
/*      */       else {
/*  385 */         this.p3 = rs.getString("p3").trim();
/*      */       }
/*  387 */       if (rs.getString("p1") == null)
/*  388 */         this.p1 = null;
/*      */       else {
/*  390 */         this.p1 = rs.getString("p1").trim();
/*      */       }
/*  392 */       if (rs.getString("polPrintType") == null)
/*  393 */         this.polPrintType = null;
/*      */       else {
/*  395 */         this.polPrintType = rs.getString("polPrintType").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  400 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684LNPAgentInfo\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  402 */       CError tError = new CError();
/*  403 */       tError.moduleName = "LNPAgentInfoSchema";
/*  404 */       tError.functionName = "setSchema";
/*  405 */       tError.errorMessage = sqle.toString();
/*  406 */       this.mErrors.addOneError(tError);
/*  407 */       return false;
/*      */     }
/*  409 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAgentInfoSchema getSchema()
/*      */   {
/*  414 */     LNPAgentInfoSchema aLNPAgentInfoSchema = new LNPAgentInfoSchema();
/*  415 */     aLNPAgentInfoSchema.setSchema(this);
/*  416 */     return aLNPAgentInfoSchema;
/*      */   }
/*      */ 
/*      */   public LNPAgentInfoDB getDB()
/*      */   {
/*  421 */     LNPAgentInfoDB aDBOper = new LNPAgentInfoDB();
/*  422 */     aDBOper.setSchema(this);
/*  423 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  430 */     StringBuffer strReturn = new StringBuffer(256);
/*  431 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/*  432 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/*  433 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/*  434 */     strReturn.append(StrTool.cTrim(this.prtNo)); strReturn.append("|");
/*  435 */     strReturn.append(StrTool.cTrim(this.agentOrder)); strReturn.append("|");
/*  436 */     strReturn.append(StrTool.cTrim(this.agentName)); strReturn.append("|");
/*  437 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/*  438 */     strReturn.append(StrTool.cTrim(this.branchName)); strReturn.append("|");
/*  439 */     strReturn.append(StrTool.cTrim(this.branchAttr)); strReturn.append("|");
/*  440 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  441 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  442 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  443 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  444 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  445 */     strReturn.append(StrTool.cTrim(this.p2)); strReturn.append("|");
/*  446 */     strReturn.append(StrTool.cTrim(this.p4)); strReturn.append("|");
/*  447 */     strReturn.append(StrTool.cTrim(this.p3)); strReturn.append("|");
/*  448 */     strReturn.append(StrTool.cTrim(this.p1)); strReturn.append("|");
/*  449 */     strReturn.append(StrTool.cTrim(this.polPrintType));
/*  450 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  458 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  459 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  460 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  461 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  462 */       this.agentOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  463 */       this.agentName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  464 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  465 */       this.branchName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  466 */       this.branchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  467 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  468 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
/*  469 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  470 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
/*  471 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  472 */       this.p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  473 */       this.p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  474 */       this.p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  475 */       this.p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  476 */       this.polPrintType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  481 */       CError tError = new CError();
/*  482 */       tError.moduleName = "LNPAgentInfoSchema";
/*  483 */       tError.functionName = "decode";
/*  484 */       tError.errorMessage = ex.toString();
/*  485 */       this.mErrors.addOneError(tError);
/*      */ 
/*  487 */       return false;
/*      */     }
/*  489 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  495 */     String strReturn = "";
/*  496 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  498 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  500 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  502 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  504 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  506 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  508 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/*  510 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/*  512 */     if (FCode.equalsIgnoreCase("agentOrder"))
/*      */     {
/*  514 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentOrder));
/*      */     }
/*  516 */     if (FCode.equalsIgnoreCase("agentName"))
/*      */     {
/*  518 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentName));
/*      */     }
/*  520 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  522 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/*  524 */     if (FCode.equalsIgnoreCase("branchName"))
/*      */     {
/*  526 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchName));
/*      */     }
/*  528 */     if (FCode.equalsIgnoreCase("branchAttr"))
/*      */     {
/*  530 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchAttr));
/*      */     }
/*  532 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  534 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  536 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  538 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  540 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  542 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  544 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  546 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  548 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  550 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  552 */     if (FCode.equalsIgnoreCase("p2"))
/*      */     {
/*  554 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p2));
/*      */     }
/*  556 */     if (FCode.equalsIgnoreCase("p4"))
/*      */     {
/*  558 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p4));
/*      */     }
/*  560 */     if (FCode.equalsIgnoreCase("p3"))
/*      */     {
/*  562 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p3));
/*      */     }
/*  564 */     if (FCode.equalsIgnoreCase("p1"))
/*      */     {
/*  566 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p1));
/*      */     }
/*      */ 
/*  569 */     if (FCode.equalsIgnoreCase("polPrintType"))
/*      */     {
/*  571 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polPrintType));
/*      */     }
/*  573 */     if (strReturn.equals(""))
/*      */     {
/*  575 */       strReturn = "null";
/*      */     }
/*      */ 
/*  578 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  585 */     String strFieldValue = "";
/*  586 */     switch (nFieldIndex) {
/*      */     case 0:
/*  588 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  589 */       break;
/*      */     case 1:
/*  591 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  592 */       break;
/*      */     case 2:
/*  594 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  595 */       break;
/*      */     case 3:
/*  597 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/*  598 */       break;
/*      */     case 4:
/*  600 */       strFieldValue = StrTool.GBKToUnicode(this.agentOrder);
/*  601 */       break;
/*      */     case 5:
/*  603 */       strFieldValue = StrTool.GBKToUnicode(this.agentName);
/*  604 */       break;
/*      */     case 6:
/*  606 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/*  607 */       break;
/*      */     case 7:
/*  609 */       strFieldValue = StrTool.GBKToUnicode(this.branchName);
/*  610 */       break;
/*      */     case 8:
/*  612 */       strFieldValue = StrTool.GBKToUnicode(this.branchAttr);
/*  613 */       break;
/*      */     case 9:
/*  615 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  616 */       break;
/*      */     case 10:
/*  618 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  619 */       break;
/*      */     case 11:
/*  621 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  622 */       break;
/*      */     case 12:
/*  624 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  625 */       break;
/*      */     case 13:
/*  627 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  628 */       break;
/*      */     case 14:
/*  630 */       strFieldValue = StrTool.GBKToUnicode(this.p2);
/*  631 */       break;
/*      */     case 15:
/*  633 */       strFieldValue = StrTool.GBKToUnicode(this.p4);
/*  634 */       break;
/*      */     case 16:
/*  636 */       strFieldValue = StrTool.GBKToUnicode(this.p3);
/*  637 */       break;
/*      */     case 17:
/*  639 */       strFieldValue = StrTool.GBKToUnicode(this.p1);
/*  640 */       break;
/*      */     case 18:
/*  642 */       strFieldValue = StrTool.GBKToUnicode(this.polPrintType);
/*  643 */       break;
/*      */     default:
/*  645 */       strFieldValue = "";
/*      */     }
/*  647 */     if (strFieldValue.equals("")) {
/*  648 */       strFieldValue = "null";
/*      */     }
/*  650 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  656 */     if (StrTool.cTrim(FCode).equals("")) {
/*  657 */       return false;
/*      */     }
/*  659 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  661 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  663 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/*  666 */         this.grpContNo = null;
/*      */     }
/*  668 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  670 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  672 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/*  675 */         this.contNo = null;
/*      */     }
/*  677 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  679 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  681 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/*  684 */         this.proposalContNo = null;
/*      */     }
/*  686 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/*  688 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  690 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/*  693 */         this.prtNo = null;
/*      */     }
/*  695 */     if (FCode.equalsIgnoreCase("agentOrder"))
/*      */     {
/*  697 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  699 */         this.agentOrder = FValue.trim();
/*      */       }
/*      */       else
/*  702 */         this.agentOrder = null;
/*      */     }
/*  704 */     if (FCode.equalsIgnoreCase("agentName"))
/*      */     {
/*  706 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  708 */         this.agentName = FValue.trim();
/*      */       }
/*      */       else
/*  711 */         this.agentName = null;
/*      */     }
/*  713 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  715 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  717 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/*  720 */         this.agentCode = null;
/*      */     }
/*  722 */     if (FCode.equalsIgnoreCase("branchName"))
/*      */     {
/*  724 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  726 */         this.branchName = FValue.trim();
/*      */       }
/*      */       else
/*  729 */         this.branchName = null;
/*      */     }
/*  731 */     if (FCode.equalsIgnoreCase("branchAttr"))
/*      */     {
/*  733 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  735 */         this.branchAttr = FValue.trim();
/*      */       }
/*      */       else
/*  738 */         this.branchAttr = null;
/*      */     }
/*  740 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  742 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  744 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  747 */         this.operator = null;
/*      */     }
/*  749 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  751 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  753 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  756 */         this.makeDate = null;
/*      */     }
/*  758 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  760 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  762 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  765 */         this.makeTime = null;
/*      */     }
/*  767 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  769 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  771 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  774 */         this.modifyDate = null;
/*      */     }
/*  776 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  778 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  780 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  783 */         this.modifyTime = null;
/*      */     }
/*  785 */     if (FCode.equalsIgnoreCase("p2"))
/*      */     {
/*  787 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  789 */         this.p2 = FValue.trim();
/*      */       }
/*      */       else
/*  792 */         this.p2 = null;
/*      */     }
/*  794 */     if (FCode.equalsIgnoreCase("p4"))
/*      */     {
/*  796 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  798 */         this.p4 = FValue.trim();
/*      */       }
/*      */       else
/*  801 */         this.p4 = null;
/*      */     }
/*  803 */     if (FCode.equalsIgnoreCase("p3"))
/*      */     {
/*  805 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  807 */         this.p3 = FValue.trim();
/*      */       }
/*      */       else
/*  810 */         this.p3 = null;
/*      */     }
/*  812 */     if (FCode.equalsIgnoreCase("p1"))
/*      */     {
/*  814 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  816 */         this.p1 = FValue.trim();
/*      */       }
/*      */       else {
/*  819 */         this.p1 = null;
/*      */       }
/*      */     }
/*  822 */     if (FCode.equalsIgnoreCase("polPrintType"))
/*      */     {
/*  824 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  826 */         this.polPrintType = FValue.trim();
/*      */       }
/*      */       else
/*  829 */         this.polPrintType = null;
/*      */     }
/*  831 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  836 */     if (otherObject == null) return false;
/*  837 */     if (this == otherObject) return true;
/*  838 */     if (getClass() != otherObject.getClass()) return false;
/*  839 */     LNPAgentInfoSchema other = (LNPAgentInfoSchema)otherObject;
/*  840 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/*  841 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/*  842 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/*  843 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/*  844 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/*  845 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/*  846 */     if ((this.prtNo == null) && (other.getPrtNo() != null)) return false;
/*  847 */     if ((this.prtNo != null) && (!this.prtNo.equals(other.getPrtNo()))) return false;
/*  848 */     if ((this.agentOrder == null) && (other.getAgentOrder() != null)) return false;
/*  849 */     if ((this.agentOrder != null) && (!this.agentOrder.equals(other.getAgentOrder()))) return false;
/*  850 */     if ((this.agentName == null) && (other.getAgentName() != null)) return false;
/*  851 */     if ((this.agentName != null) && (!this.agentName.equals(other.getAgentName()))) return false;
/*  852 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/*  853 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/*  854 */     if ((this.branchName == null) && (other.getBranchName() != null)) return false;
/*  855 */     if ((this.branchName != null) && (!this.branchName.equals(other.getBranchName()))) return false;
/*  856 */     if ((this.branchAttr == null) && (other.getBranchAttr() != null)) return false;
/*  857 */     if ((this.branchAttr != null) && (!this.branchAttr.equals(other.getBranchAttr()))) return false;
/*  858 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  859 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  860 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  861 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  862 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  863 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  864 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  865 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  866 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  867 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/*  868 */     if ((this.p2 == null) && (other.getP2() != null)) return false;
/*  869 */     if ((this.p2 != null) && (!this.p2.equals(other.getP2()))) return false;
/*  870 */     if ((this.p4 == null) && (other.getP4() != null)) return false;
/*  871 */     if ((this.p4 != null) && (!this.p4.equals(other.getP4()))) return false;
/*  872 */     if ((this.p3 == null) && (other.getP3() != null)) return false;
/*  873 */     if ((this.p3 != null) && (!this.p3.equals(other.getP3()))) return false;
/*  874 */     if ((this.p1 == null) && (other.getP1() != null)) return false;
/*  875 */     if ((this.p1 != null) && (!this.p1.equals(other.getP1()))) return false;
/*  876 */     return (this.polPrintType == null) || (this.polPrintType.equals(other.getPolPrintType()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  884 */     return 19;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  890 */     if (strFieldName.equals("grpContNo")) {
/*  891 */       return 0;
/*      */     }
/*  893 */     if (strFieldName.equals("contNo")) {
/*  894 */       return 1;
/*      */     }
/*  896 */     if (strFieldName.equals("proposalContNo")) {
/*  897 */       return 2;
/*      */     }
/*  899 */     if (strFieldName.equals("prtNo")) {
/*  900 */       return 3;
/*      */     }
/*  902 */     if (strFieldName.equals("agentOrder")) {
/*  903 */       return 4;
/*      */     }
/*  905 */     if (strFieldName.equals("agentName")) {
/*  906 */       return 5;
/*      */     }
/*  908 */     if (strFieldName.equals("agentCode")) {
/*  909 */       return 6;
/*      */     }
/*  911 */     if (strFieldName.equals("branchName")) {
/*  912 */       return 7;
/*      */     }
/*  914 */     if (strFieldName.equals("branchAttr")) {
/*  915 */       return 8;
/*      */     }
/*  917 */     if (strFieldName.equals("operator")) {
/*  918 */       return 9;
/*      */     }
/*  920 */     if (strFieldName.equals("makeDate")) {
/*  921 */       return 10;
/*      */     }
/*  923 */     if (strFieldName.equals("makeTime")) {
/*  924 */       return 11;
/*      */     }
/*  926 */     if (strFieldName.equals("modifyDate")) {
/*  927 */       return 12;
/*      */     }
/*  929 */     if (strFieldName.equals("modifyTime")) {
/*  930 */       return 13;
/*      */     }
/*  932 */     if (strFieldName.equals("p2")) {
/*  933 */       return 14;
/*      */     }
/*  935 */     if (strFieldName.equals("p4")) {
/*  936 */       return 15;
/*      */     }
/*  938 */     if (strFieldName.equals("p3")) {
/*  939 */       return 16;
/*      */     }
/*  941 */     if (strFieldName.equals("p1")) {
/*  942 */       return 17;
/*      */     }
/*  944 */     if (strFieldName.equals("polPrintType")) {
/*  945 */       return 18;
/*      */     }
/*  947 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  953 */     String strFieldName = "";
/*  954 */     switch (nFieldIndex) {
/*      */     case 0:
/*  956 */       strFieldName = "grpContNo";
/*  957 */       break;
/*      */     case 1:
/*  959 */       strFieldName = "contNo";
/*  960 */       break;
/*      */     case 2:
/*  962 */       strFieldName = "proposalContNo";
/*  963 */       break;
/*      */     case 3:
/*  965 */       strFieldName = "prtNo";
/*  966 */       break;
/*      */     case 4:
/*  968 */       strFieldName = "agentOrder";
/*  969 */       break;
/*      */     case 5:
/*  971 */       strFieldName = "agentName";
/*  972 */       break;
/*      */     case 6:
/*  974 */       strFieldName = "agentCode";
/*  975 */       break;
/*      */     case 7:
/*  977 */       strFieldName = "branchName";
/*  978 */       break;
/*      */     case 8:
/*  980 */       strFieldName = "branchAttr";
/*  981 */       break;
/*      */     case 9:
/*  983 */       strFieldName = "operator";
/*  984 */       break;
/*      */     case 10:
/*  986 */       strFieldName = "makeDate";
/*  987 */       break;
/*      */     case 11:
/*  989 */       strFieldName = "makeTime";
/*  990 */       break;
/*      */     case 12:
/*  992 */       strFieldName = "modifyDate";
/*  993 */       break;
/*      */     case 13:
/*  995 */       strFieldName = "modifyTime";
/*  996 */       break;
/*      */     case 14:
/*  998 */       strFieldName = "p2";
/*  999 */       break;
/*      */     case 15:
/* 1001 */       strFieldName = "p4";
/* 1002 */       break;
/*      */     case 16:
/* 1004 */       strFieldName = "p3";
/* 1005 */       break;
/*      */     case 17:
/* 1007 */       strFieldName = "p1";
/* 1008 */       break;
/*      */     case 18:
/* 1010 */       strFieldName = "polPrintType";
/* 1011 */       break;
/*      */     default:
/* 1013 */       strFieldName = "";
/*      */     }
/* 1015 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1021 */     if (strFieldName.equals("grpContNo")) {
/* 1022 */       return 0;
/*      */     }
/* 1024 */     if (strFieldName.equals("contNo")) {
/* 1025 */       return 0;
/*      */     }
/* 1027 */     if (strFieldName.equals("proposalContNo")) {
/* 1028 */       return 0;
/*      */     }
/* 1030 */     if (strFieldName.equals("prtNo")) {
/* 1031 */       return 0;
/*      */     }
/* 1033 */     if (strFieldName.equals("agentOrder")) {
/* 1034 */       return 0;
/*      */     }
/* 1036 */     if (strFieldName.equals("agentName")) {
/* 1037 */       return 0;
/*      */     }
/* 1039 */     if (strFieldName.equals("agentCode")) {
/* 1040 */       return 0;
/*      */     }
/* 1042 */     if (strFieldName.equals("branchName")) {
/* 1043 */       return 0;
/*      */     }
/* 1045 */     if (strFieldName.equals("branchAttr")) {
/* 1046 */       return 0;
/*      */     }
/* 1048 */     if (strFieldName.equals("operator")) {
/* 1049 */       return 0;
/*      */     }
/* 1051 */     if (strFieldName.equals("makeDate")) {
/* 1052 */       return 1;
/*      */     }
/* 1054 */     if (strFieldName.equals("makeTime")) {
/* 1055 */       return 0;
/*      */     }
/* 1057 */     if (strFieldName.equals("modifyDate")) {
/* 1058 */       return 1;
/*      */     }
/* 1060 */     if (strFieldName.equals("modifyTime")) {
/* 1061 */       return 0;
/*      */     }
/* 1063 */     if (strFieldName.equals("p2")) {
/* 1064 */       return 0;
/*      */     }
/* 1066 */     if (strFieldName.equals("p4")) {
/* 1067 */       return 0;
/*      */     }
/* 1069 */     if (strFieldName.equals("p3")) {
/* 1070 */       return 0;
/*      */     }
/* 1072 */     if (strFieldName.equals("p1")) {
/* 1073 */       return 0;
/*      */     }
/* 1075 */     if (strFieldName.equals("polPrintType")) {
/* 1076 */       return 0;
/*      */     }
/*      */ 
/* 1079 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1085 */     int nFieldType = -1;
/* 1086 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1088 */       nFieldType = 0;
/* 1089 */       break;
/*      */     case 1:
/* 1091 */       nFieldType = 0;
/* 1092 */       break;
/*      */     case 2:
/* 1094 */       nFieldType = 0;
/* 1095 */       break;
/*      */     case 3:
/* 1097 */       nFieldType = 0;
/* 1098 */       break;
/*      */     case 4:
/* 1100 */       nFieldType = 0;
/* 1101 */       break;
/*      */     case 5:
/* 1103 */       nFieldType = 0;
/* 1104 */       break;
/*      */     case 6:
/* 1106 */       nFieldType = 0;
/* 1107 */       break;
/*      */     case 7:
/* 1109 */       nFieldType = 0;
/* 1110 */       break;
/*      */     case 8:
/* 1112 */       nFieldType = 0;
/* 1113 */       break;
/*      */     case 9:
/* 1115 */       nFieldType = 0;
/* 1116 */       break;
/*      */     case 10:
/* 1118 */       nFieldType = 1;
/* 1119 */       break;
/*      */     case 11:
/* 1121 */       nFieldType = 0;
/* 1122 */       break;
/*      */     case 12:
/* 1124 */       nFieldType = 1;
/* 1125 */       break;
/*      */     case 13:
/* 1127 */       nFieldType = 0;
/* 1128 */       break;
/*      */     case 14:
/* 1130 */       nFieldType = 0;
/* 1131 */       break;
/*      */     case 15:
/* 1133 */       nFieldType = 0;
/* 1134 */       break;
/*      */     case 16:
/* 1136 */       nFieldType = 0;
/* 1137 */       break;
/*      */     case 17:
/* 1139 */       nFieldType = 0;
/* 1140 */       break;
/*      */     case 18:
/* 1142 */       nFieldType = 0;
/* 1143 */       break;
/*      */     default:
/* 1145 */       nFieldType = -1;
/*      */     }
/* 1147 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema
 * JD-Core Version:    0.6.0
 */