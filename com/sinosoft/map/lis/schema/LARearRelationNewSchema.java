/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.LARearRelationNewDB;
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
/*      */ public class LARearRelationNewSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String manageCom;
/*      */   private String agentCode;
/*      */   private String agentGrade;
/*      */   private String agentGroup;
/*      */   private String sMAgentCode;
/*      */   private String aMAgentCode;
/*      */   private String rAgentCode;
/*      */   private String agentTitle;
/*      */   private String rAgentGrade;
/*      */   private String rAgentTitle;
/*      */   private String rAgentGroup;
/*      */   private String rBranchAttr;
/*      */   private String type;
/*      */   private int deep;
/*      */   private Date startDate;
/*      */   private Date breakDate;
/*      */   private Date pBreakDate;
/*      */   private String breakType;
/*      */   private String state;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String operator;
/*      */   public static final int FIELDNUM = 24;
/*      */   private static String[] PK;
/*   72 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LARearRelationNewSchema()
/*      */   {
/*   79 */     this.mErrors = new CErrors();
/*      */ 
/*   81 */     String[] pk = new String[5];
/*   82 */     pk[0] = "AgentCode";
/*   83 */     pk[1] = "RAgentCode";
/*   84 */     pk[2] = "Type";
/*   85 */     pk[3] = "Deep";
/*   86 */     pk[4] = "State";
/*      */ 
/*   88 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   95 */     LARearRelationNewSchema cloned = (LARearRelationNewSchema)super.clone();
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
/*      */   public String getManageCom()
/*      */   {
/*  109 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  113 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  117 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  121 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getAgentGrade() {
/*  125 */     return this.agentGrade;
/*      */   }
/*      */ 
/*      */   public void setAgentGrade(String aAgentGrade) {
/*  129 */     this.agentGrade = aAgentGrade;
/*      */   }
/*      */ 
/*      */   public String getAgentGroup() {
/*  133 */     return this.agentGroup;
/*      */   }
/*      */ 
/*      */   public void setAgentGroup(String aAgentGroup) {
/*  137 */     this.agentGroup = aAgentGroup;
/*      */   }
/*      */ 
/*      */   public String getSMAgentCode() {
/*  141 */     return this.sMAgentCode;
/*      */   }
/*      */ 
/*      */   public void setSMAgentCode(String aSMAgentCode) {
/*  145 */     this.sMAgentCode = aSMAgentCode;
/*      */   }
/*      */ 
/*      */   public String getAMAgentCode() {
/*  149 */     return this.aMAgentCode;
/*      */   }
/*      */ 
/*      */   public void setAMAgentCode(String aAMAgentCode) {
/*  153 */     this.aMAgentCode = aAMAgentCode;
/*      */   }
/*      */ 
/*      */   public String getRAgentCode() {
/*  157 */     return this.rAgentCode;
/*      */   }
/*      */ 
/*      */   public void setRAgentCode(String aRAgentCode) {
/*  161 */     this.rAgentCode = aRAgentCode;
/*      */   }
/*      */ 
/*      */   public String getAgentTitle() {
/*  165 */     return this.agentTitle;
/*      */   }
/*      */ 
/*      */   public void setAgentTitle(String aAgentTitle) {
/*  169 */     this.agentTitle = aAgentTitle;
/*      */   }
/*      */ 
/*      */   public String getRAgentGrade() {
/*  173 */     return this.rAgentGrade;
/*      */   }
/*      */ 
/*      */   public void setRAgentGrade(String aRAgentGrade) {
/*  177 */     this.rAgentGrade = aRAgentGrade;
/*      */   }
/*      */ 
/*      */   public String getRAgentTitle() {
/*  181 */     return this.rAgentTitle;
/*      */   }
/*      */ 
/*      */   public void setRAgentTitle(String aRAgentTitle) {
/*  185 */     this.rAgentTitle = aRAgentTitle;
/*      */   }
/*      */ 
/*      */   public String getRAgentGroup() {
/*  189 */     return this.rAgentGroup;
/*      */   }
/*      */ 
/*      */   public void setRAgentGroup(String aRAgentGroup) {
/*  193 */     this.rAgentGroup = aRAgentGroup;
/*      */   }
/*      */ 
/*      */   public String getRBranchAttr() {
/*  197 */     return this.rBranchAttr;
/*      */   }
/*      */ 
/*      */   public void setRBranchAttr(String aRBranchAttr) {
/*  201 */     this.rBranchAttr = aRBranchAttr;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  205 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  209 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public int getDeep() {
/*  213 */     return this.deep;
/*      */   }
/*      */ 
/*      */   public void setDeep(int aDeep) {
/*  217 */     this.deep = aDeep;
/*      */   }
/*      */ 
/*      */   public void setDeep(String aDeep) {
/*  221 */     if ((aDeep != null) && (!aDeep.equals("")))
/*      */     {
/*  223 */       Integer tInteger = new Integer(aDeep);
/*  224 */       int i = tInteger.intValue();
/*  225 */       this.deep = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getStartDate()
/*      */   {
/*  231 */     if (this.startDate != null) {
/*  232 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  234 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  238 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  242 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  244 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  247 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getBreakDate()
/*      */   {
/*  252 */     if (this.breakDate != null) {
/*  253 */       return this.fDate.getString(this.breakDate);
/*      */     }
/*  255 */     return null;
/*      */   }
/*      */ 
/*      */   public void setBreakDate(Date aBreakDate) {
/*  259 */     this.breakDate = aBreakDate;
/*      */   }
/*      */ 
/*      */   public void setBreakDate(String aBreakDate) {
/*  263 */     if ((aBreakDate != null) && (!aBreakDate.equals("")))
/*      */     {
/*  265 */       this.breakDate = this.fDate.getDate(aBreakDate);
/*      */     }
/*      */     else
/*  268 */       this.breakDate = null;
/*      */   }
/*      */ 
/*      */   public String getPBreakDate()
/*      */   {
/*  273 */     if (this.pBreakDate != null) {
/*  274 */       return this.fDate.getString(this.pBreakDate);
/*      */     }
/*  276 */     return null;
/*      */   }
/*      */ 
/*      */   public void setPBreakDate(Date aPBreakDate) {
/*  280 */     this.pBreakDate = aPBreakDate;
/*      */   }
/*      */ 
/*      */   public void setPBreakDate(String aPBreakDate) {
/*  284 */     if ((aPBreakDate != null) && (!aPBreakDate.equals("")))
/*      */     {
/*  286 */       this.pBreakDate = this.fDate.getDate(aPBreakDate);
/*      */     }
/*      */     else
/*  289 */       this.pBreakDate = null;
/*      */   }
/*      */ 
/*      */   public String getBreakType()
/*      */   {
/*  294 */     return this.breakType;
/*      */   }
/*      */ 
/*      */   public void setBreakType(String aBreakType) {
/*  298 */     this.breakType = aBreakType;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  302 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  306 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  310 */     if (this.makeDate != null) {
/*  311 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  313 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  317 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  321 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  323 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  326 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  331 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  335 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  339 */     if (this.modifyDate != null) {
/*  340 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  342 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  346 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  350 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  352 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  355 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  360 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  364 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  368 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  372 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public void setSchema(LARearRelationNewSchema aLARearRelationNewSchema)
/*      */   {
/*  378 */     this.manageCom = aLARearRelationNewSchema.getManageCom();
/*  379 */     this.agentCode = aLARearRelationNewSchema.getAgentCode();
/*  380 */     this.agentGrade = aLARearRelationNewSchema.getAgentGrade();
/*  381 */     this.agentGroup = aLARearRelationNewSchema.getAgentGroup();
/*  382 */     this.sMAgentCode = aLARearRelationNewSchema.getSMAgentCode();
/*  383 */     this.aMAgentCode = aLARearRelationNewSchema.getAMAgentCode();
/*  384 */     this.rAgentCode = aLARearRelationNewSchema.getRAgentCode();
/*  385 */     this.agentTitle = aLARearRelationNewSchema.getAgentTitle();
/*  386 */     this.rAgentGrade = aLARearRelationNewSchema.getRAgentGrade();
/*  387 */     this.rAgentTitle = aLARearRelationNewSchema.getRAgentTitle();
/*  388 */     this.rAgentGroup = aLARearRelationNewSchema.getRAgentGroup();
/*  389 */     this.rBranchAttr = aLARearRelationNewSchema.getRBranchAttr();
/*  390 */     this.type = aLARearRelationNewSchema.getType();
/*  391 */     this.deep = aLARearRelationNewSchema.getDeep();
/*  392 */     this.startDate = this.fDate.getDate(aLARearRelationNewSchema.getStartDate());
/*  393 */     this.breakDate = this.fDate.getDate(aLARearRelationNewSchema.getBreakDate());
/*  394 */     this.pBreakDate = this.fDate.getDate(aLARearRelationNewSchema.getPBreakDate());
/*  395 */     this.breakType = aLARearRelationNewSchema.getBreakType();
/*  396 */     this.state = aLARearRelationNewSchema.getState();
/*  397 */     this.makeDate = this.fDate.getDate(aLARearRelationNewSchema.getMakeDate());
/*  398 */     this.makeTime = aLARearRelationNewSchema.getMakeTime();
/*  399 */     this.modifyDate = this.fDate.getDate(aLARearRelationNewSchema.getModifyDate());
/*  400 */     this.modifyTime = aLARearRelationNewSchema.getModifyTime();
/*  401 */     this.operator = aLARearRelationNewSchema.getOperator();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  410 */       if (rs.getString("ManageCom") == null)
/*  411 */         this.manageCom = null;
/*      */       else {
/*  413 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  415 */       if (rs.getString("AgentCode") == null)
/*  416 */         this.agentCode = null;
/*      */       else {
/*  418 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/*  420 */       if (rs.getString("AgentGrade") == null)
/*  421 */         this.agentGrade = null;
/*      */       else {
/*  423 */         this.agentGrade = rs.getString("AgentGrade").trim();
/*      */       }
/*  425 */       if (rs.getString("AgentGroup") == null)
/*  426 */         this.agentGroup = null;
/*      */       else {
/*  428 */         this.agentGroup = rs.getString("AgentGroup").trim();
/*      */       }
/*  430 */       if (rs.getString("SMAgentCode") == null)
/*  431 */         this.sMAgentCode = null;
/*      */       else {
/*  433 */         this.sMAgentCode = rs.getString("SMAgentCode").trim();
/*      */       }
/*  435 */       if (rs.getString("AMAgentCode") == null)
/*  436 */         this.aMAgentCode = null;
/*      */       else {
/*  438 */         this.aMAgentCode = rs.getString("AMAgentCode").trim();
/*      */       }
/*  440 */       if (rs.getString("RAgentCode") == null)
/*  441 */         this.rAgentCode = null;
/*      */       else {
/*  443 */         this.rAgentCode = rs.getString("RAgentCode").trim();
/*      */       }
/*  445 */       if (rs.getString("AgentTitle") == null)
/*  446 */         this.agentTitle = null;
/*      */       else {
/*  448 */         this.agentTitle = rs.getString("AgentTitle").trim();
/*      */       }
/*  450 */       if (rs.getString("RAgentGrade") == null)
/*  451 */         this.rAgentGrade = null;
/*      */       else {
/*  453 */         this.rAgentGrade = rs.getString("RAgentGrade").trim();
/*      */       }
/*  455 */       if (rs.getString("RAgentTitle") == null)
/*  456 */         this.rAgentTitle = null;
/*      */       else {
/*  458 */         this.rAgentTitle = rs.getString("RAgentTitle").trim();
/*      */       }
/*  460 */       if (rs.getString("RAgentGroup") == null)
/*  461 */         this.rAgentGroup = null;
/*      */       else {
/*  463 */         this.rAgentGroup = rs.getString("RAgentGroup").trim();
/*      */       }
/*  465 */       if (rs.getString("RBranchAttr") == null)
/*  466 */         this.rBranchAttr = null;
/*      */       else {
/*  468 */         this.rBranchAttr = rs.getString("RBranchAttr").trim();
/*      */       }
/*  470 */       if (rs.getString("Type") == null)
/*  471 */         this.type = null;
/*      */       else {
/*  473 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  475 */       this.deep = rs.getInt("Deep");
/*  476 */       this.startDate = rs.getDate("StartDate");
/*  477 */       this.breakDate = rs.getDate("BreakDate");
/*  478 */       this.pBreakDate = rs.getDate("PBreakDate");
/*  479 */       if (rs.getString("BreakType") == null)
/*  480 */         this.breakType = null;
/*      */       else {
/*  482 */         this.breakType = rs.getString("BreakType").trim();
/*      */       }
/*  484 */       if (rs.getString("State") == null)
/*  485 */         this.state = null;
/*      */       else {
/*  487 */         this.state = rs.getString("State").trim();
/*      */       }
/*  489 */       this.makeDate = rs.getDate("MakeDate");
/*  490 */       if (rs.getString("MakeTime") == null)
/*  491 */         this.makeTime = null;
/*      */       else {
/*  493 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  495 */       this.modifyDate = rs.getDate("ModifyDate");
/*  496 */       if (rs.getString("ModifyTime") == null)
/*  497 */         this.modifyTime = null;
/*      */       else {
/*  499 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  501 */       if (rs.getString("Operator") == null)
/*  502 */         this.operator = null;
/*      */       else {
/*  504 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  509 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684LARearRelationNew\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  511 */       CError tError = new CError();
/*  512 */       tError.moduleName = "LARearRelationNewSchema";
/*  513 */       tError.functionName = "setSchema";
/*  514 */       tError.errorMessage = sqle.toString();
/*  515 */       this.mErrors.addOneError(tError);
/*  516 */       return false;
/*      */     }
/*  518 */     return true;
/*      */   }
/*      */ 
/*      */   public LARearRelationNewSchema getSchema()
/*      */   {
/*  523 */     LARearRelationNewSchema aLARearRelationNewSchema = new LARearRelationNewSchema();
/*  524 */     aLARearRelationNewSchema.setSchema(this);
/*  525 */     return aLARearRelationNewSchema;
/*      */   }
/*      */ 
/*      */   public LARearRelationNewDB getDB()
/*      */   {
/*  530 */     LARearRelationNewDB aDBOper = new LARearRelationNewDB();
/*  531 */     aDBOper.setSchema(this);
/*  532 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  539 */     StringBuffer strReturn = new StringBuffer(256);
/*  540 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  541 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/*  542 */     strReturn.append(StrTool.cTrim(this.agentGrade)); strReturn.append("|");
/*  543 */     strReturn.append(StrTool.cTrim(this.agentGroup)); strReturn.append("|");
/*  544 */     strReturn.append(StrTool.cTrim(this.sMAgentCode)); strReturn.append("|");
/*  545 */     strReturn.append(StrTool.cTrim(this.aMAgentCode)); strReturn.append("|");
/*  546 */     strReturn.append(StrTool.cTrim(this.rAgentCode)); strReturn.append("|");
/*  547 */     strReturn.append(StrTool.cTrim(this.agentTitle)); strReturn.append("|");
/*  548 */     strReturn.append(StrTool.cTrim(this.rAgentGrade)); strReturn.append("|");
/*  549 */     strReturn.append(StrTool.cTrim(this.rAgentTitle)); strReturn.append("|");
/*  550 */     strReturn.append(StrTool.cTrim(this.rAgentGroup)); strReturn.append("|");
/*  551 */     strReturn.append(StrTool.cTrim(this.rBranchAttr)); strReturn.append("|");
/*  552 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  553 */     strReturn.append(ChgData.chgData(this.deep)); strReturn.append("|");
/*  554 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  555 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.breakDate))); strReturn.append("|");
/*  556 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.pBreakDate))); strReturn.append("|");
/*  557 */     strReturn.append(StrTool.cTrim(this.breakType)); strReturn.append("|");
/*  558 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  559 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  560 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  561 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  562 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  563 */     strReturn.append(StrTool.cTrim(this.operator));
/*  564 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  572 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  573 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  574 */       this.agentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  575 */       this.agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  576 */       this.sMAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  577 */       this.aMAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  578 */       this.rAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  579 */       this.agentTitle = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  580 */       this.rAgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  581 */       this.rAgentTitle = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  582 */       this.rAgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  583 */       this.rBranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  584 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  585 */       this.deep = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|"))).intValue();
/*  586 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  587 */       this.breakDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  588 */       this.pBreakDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  589 */       this.breakType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  590 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  591 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  592 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  593 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  594 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  595 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  600 */       CError tError = new CError();
/*  601 */       tError.moduleName = "LARearRelationNewSchema";
/*  602 */       tError.functionName = "decode";
/*  603 */       tError.errorMessage = ex.toString();
/*  604 */       this.mErrors.addOneError(tError);
/*      */ 
/*  606 */       return false;
/*      */     }
/*  608 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  614 */     String strReturn = "";
/*  615 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  617 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  619 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  621 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/*  623 */     if (FCode.equalsIgnoreCase("agentGrade"))
/*      */     {
/*  625 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGrade));
/*      */     }
/*  627 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*      */     {
/*  629 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup));
/*      */     }
/*  631 */     if (FCode.equalsIgnoreCase("sMAgentCode"))
/*      */     {
/*  633 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMAgentCode));
/*      */     }
/*  635 */     if (FCode.equalsIgnoreCase("aMAgentCode"))
/*      */     {
/*  637 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMAgentCode));
/*      */     }
/*  639 */     if (FCode.equalsIgnoreCase("rAgentCode"))
/*      */     {
/*  641 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rAgentCode));
/*      */     }
/*  643 */     if (FCode.equalsIgnoreCase("agentTitle"))
/*      */     {
/*  645 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentTitle));
/*      */     }
/*  647 */     if (FCode.equalsIgnoreCase("rAgentGrade"))
/*      */     {
/*  649 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rAgentGrade));
/*      */     }
/*  651 */     if (FCode.equalsIgnoreCase("rAgentTitle"))
/*      */     {
/*  653 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rAgentTitle));
/*      */     }
/*  655 */     if (FCode.equalsIgnoreCase("rAgentGroup"))
/*      */     {
/*  657 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rAgentGroup));
/*      */     }
/*  659 */     if (FCode.equalsIgnoreCase("rBranchAttr"))
/*      */     {
/*  661 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rBranchAttr));
/*      */     }
/*  663 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  665 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  667 */     if (FCode.equalsIgnoreCase("deep"))
/*      */     {
/*  669 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.deep));
/*      */     }
/*  671 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  673 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  675 */     if (FCode.equalsIgnoreCase("breakDate"))
/*      */     {
/*  677 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getBreakDate()));
/*      */     }
/*  679 */     if (FCode.equalsIgnoreCase("pBreakDate"))
/*      */     {
/*  681 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getPBreakDate()));
/*      */     }
/*  683 */     if (FCode.equalsIgnoreCase("breakType"))
/*      */     {
/*  685 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.breakType));
/*      */     }
/*  687 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  689 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  691 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  693 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  695 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  697 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  699 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  701 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  703 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  705 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  707 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  709 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  711 */     if (strReturn.equals(""))
/*      */     {
/*  713 */       strReturn = "null";
/*      */     }
/*      */ 
/*  716 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  723 */     String strFieldValue = "";
/*  724 */     switch (nFieldIndex) {
/*      */     case 0:
/*  726 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  727 */       break;
/*      */     case 1:
/*  729 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/*  730 */       break;
/*      */     case 2:
/*  732 */       strFieldValue = StrTool.GBKToUnicode(this.agentGrade);
/*  733 */       break;
/*      */     case 3:
/*  735 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup);
/*  736 */       break;
/*      */     case 4:
/*  738 */       strFieldValue = StrTool.GBKToUnicode(this.sMAgentCode);
/*  739 */       break;
/*      */     case 5:
/*  741 */       strFieldValue = StrTool.GBKToUnicode(this.aMAgentCode);
/*  742 */       break;
/*      */     case 6:
/*  744 */       strFieldValue = StrTool.GBKToUnicode(this.rAgentCode);
/*  745 */       break;
/*      */     case 7:
/*  747 */       strFieldValue = StrTool.GBKToUnicode(this.agentTitle);
/*  748 */       break;
/*      */     case 8:
/*  750 */       strFieldValue = StrTool.GBKToUnicode(this.rAgentGrade);
/*  751 */       break;
/*      */     case 9:
/*  753 */       strFieldValue = StrTool.GBKToUnicode(this.rAgentTitle);
/*  754 */       break;
/*      */     case 10:
/*  756 */       strFieldValue = StrTool.GBKToUnicode(this.rAgentGroup);
/*  757 */       break;
/*      */     case 11:
/*  759 */       strFieldValue = StrTool.GBKToUnicode(this.rBranchAttr);
/*  760 */       break;
/*      */     case 12:
/*  762 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  763 */       break;
/*      */     case 13:
/*  765 */       strFieldValue = String.valueOf(this.deep);
/*  766 */       break;
/*      */     case 14:
/*  768 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  769 */       break;
/*      */     case 15:
/*  771 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBreakDate()));
/*  772 */       break;
/*      */     case 16:
/*  774 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPBreakDate()));
/*  775 */       break;
/*      */     case 17:
/*  777 */       strFieldValue = StrTool.GBKToUnicode(this.breakType);
/*  778 */       break;
/*      */     case 18:
/*  780 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  781 */       break;
/*      */     case 19:
/*  783 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  784 */       break;
/*      */     case 20:
/*  786 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  787 */       break;
/*      */     case 21:
/*  789 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  790 */       break;
/*      */     case 22:
/*  792 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  793 */       break;
/*      */     case 23:
/*  795 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  796 */       break;
/*      */     default:
/*  798 */       strFieldValue = "";
/*      */     }
/*  800 */     if (strFieldValue.equals("")) {
/*  801 */       strFieldValue = "null";
/*      */     }
/*  803 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  809 */     if (StrTool.cTrim(FCode).equals("")) {
/*  810 */       return false;
/*      */     }
/*  812 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  814 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  816 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  819 */         this.manageCom = null;
/*      */     }
/*  821 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  823 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  825 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/*  828 */         this.agentCode = null;
/*      */     }
/*  830 */     if (FCode.equalsIgnoreCase("agentGrade"))
/*      */     {
/*  832 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  834 */         this.agentGrade = FValue.trim();
/*      */       }
/*      */       else
/*  837 */         this.agentGrade = null;
/*      */     }
/*  839 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*      */     {
/*  841 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  843 */         this.agentGroup = FValue.trim();
/*      */       }
/*      */       else
/*  846 */         this.agentGroup = null;
/*      */     }
/*  848 */     if (FCode.equalsIgnoreCase("sMAgentCode"))
/*      */     {
/*  850 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  852 */         this.sMAgentCode = FValue.trim();
/*      */       }
/*      */       else
/*  855 */         this.sMAgentCode = null;
/*      */     }
/*  857 */     if (FCode.equalsIgnoreCase("aMAgentCode"))
/*      */     {
/*  859 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  861 */         this.aMAgentCode = FValue.trim();
/*      */       }
/*      */       else
/*  864 */         this.aMAgentCode = null;
/*      */     }
/*  866 */     if (FCode.equalsIgnoreCase("rAgentCode"))
/*      */     {
/*  868 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  870 */         this.rAgentCode = FValue.trim();
/*      */       }
/*      */       else
/*  873 */         this.rAgentCode = null;
/*      */     }
/*  875 */     if (FCode.equalsIgnoreCase("agentTitle"))
/*      */     {
/*  877 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  879 */         this.agentTitle = FValue.trim();
/*      */       }
/*      */       else
/*  882 */         this.agentTitle = null;
/*      */     }
/*  884 */     if (FCode.equalsIgnoreCase("rAgentGrade"))
/*      */     {
/*  886 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  888 */         this.rAgentGrade = FValue.trim();
/*      */       }
/*      */       else
/*  891 */         this.rAgentGrade = null;
/*      */     }
/*  893 */     if (FCode.equalsIgnoreCase("rAgentTitle"))
/*      */     {
/*  895 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  897 */         this.rAgentTitle = FValue.trim();
/*      */       }
/*      */       else
/*  900 */         this.rAgentTitle = null;
/*      */     }
/*  902 */     if (FCode.equalsIgnoreCase("rAgentGroup"))
/*      */     {
/*  904 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  906 */         this.rAgentGroup = FValue.trim();
/*      */       }
/*      */       else
/*  909 */         this.rAgentGroup = null;
/*      */     }
/*  911 */     if (FCode.equalsIgnoreCase("rBranchAttr"))
/*      */     {
/*  913 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  915 */         this.rBranchAttr = FValue.trim();
/*      */       }
/*      */       else
/*  918 */         this.rBranchAttr = null;
/*      */     }
/*  920 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  922 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  924 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/*  927 */         this.type = null;
/*      */     }
/*  929 */     if (FCode.equalsIgnoreCase("deep"))
/*      */     {
/*  931 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  933 */         Integer tInteger = new Integer(FValue);
/*  934 */         int i = tInteger.intValue();
/*  935 */         this.deep = i;
/*      */       }
/*      */     }
/*  938 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  940 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  942 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  945 */         this.startDate = null;
/*      */     }
/*  947 */     if (FCode.equalsIgnoreCase("breakDate"))
/*      */     {
/*  949 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  951 */         this.breakDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  954 */         this.breakDate = null;
/*      */     }
/*  956 */     if (FCode.equalsIgnoreCase("pBreakDate"))
/*      */     {
/*  958 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  960 */         this.pBreakDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  963 */         this.pBreakDate = null;
/*      */     }
/*  965 */     if (FCode.equalsIgnoreCase("breakType"))
/*      */     {
/*  967 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  969 */         this.breakType = FValue.trim();
/*      */       }
/*      */       else
/*  972 */         this.breakType = null;
/*      */     }
/*  974 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  976 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  978 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  981 */         this.state = null;
/*      */     }
/*  983 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  985 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  987 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  990 */         this.makeDate = null;
/*      */     }
/*  992 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  994 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  996 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  999 */         this.makeTime = null;
/*      */     }
/* 1001 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1003 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1005 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1008 */         this.modifyDate = null;
/*      */     }
/* 1010 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1012 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1014 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1017 */         this.modifyTime = null;
/*      */     }
/* 1019 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1021 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1023 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1026 */         this.operator = null;
/*      */     }
/* 1028 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1033 */     if (otherObject == null) return false;
/* 1034 */     if (this == otherObject) return true;
/* 1035 */     if (getClass() != otherObject.getClass()) return false;
/* 1036 */     LARearRelationNewSchema other = (LARearRelationNewSchema)otherObject;
/* 1037 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1038 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1039 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/* 1040 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/* 1041 */     if ((this.agentGrade == null) && (other.getAgentGrade() != null)) return false;
/* 1042 */     if ((this.agentGrade != null) && (!this.agentGrade.equals(other.getAgentGrade()))) return false;
/* 1043 */     if ((this.agentGroup == null) && (other.getAgentGroup() != null)) return false;
/* 1044 */     if ((this.agentGroup != null) && (!this.agentGroup.equals(other.getAgentGroup()))) return false;
/* 1045 */     if ((this.sMAgentCode == null) && (other.getSMAgentCode() != null)) return false;
/* 1046 */     if ((this.sMAgentCode != null) && (!this.sMAgentCode.equals(other.getSMAgentCode()))) return false;
/* 1047 */     if ((this.aMAgentCode == null) && (other.getAMAgentCode() != null)) return false;
/* 1048 */     if ((this.aMAgentCode != null) && (!this.aMAgentCode.equals(other.getAMAgentCode()))) return false;
/* 1049 */     if ((this.rAgentCode == null) && (other.getRAgentCode() != null)) return false;
/* 1050 */     if ((this.rAgentCode != null) && (!this.rAgentCode.equals(other.getRAgentCode()))) return false;
/* 1051 */     if ((this.agentTitle == null) && (other.getAgentTitle() != null)) return false;
/* 1052 */     if ((this.agentTitle != null) && (!this.agentTitle.equals(other.getAgentTitle()))) return false;
/* 1053 */     if ((this.rAgentGrade == null) && (other.getRAgentGrade() != null)) return false;
/* 1054 */     if ((this.rAgentGrade != null) && (!this.rAgentGrade.equals(other.getRAgentGrade()))) return false;
/* 1055 */     if ((this.rAgentTitle == null) && (other.getRAgentTitle() != null)) return false;
/* 1056 */     if ((this.rAgentTitle != null) && (!this.rAgentTitle.equals(other.getRAgentTitle()))) return false;
/* 1057 */     if ((this.rAgentGroup == null) && (other.getRAgentGroup() != null)) return false;
/* 1058 */     if ((this.rAgentGroup != null) && (!this.rAgentGroup.equals(other.getRAgentGroup()))) return false;
/* 1059 */     if ((this.rBranchAttr == null) && (other.getRBranchAttr() != null)) return false;
/* 1060 */     if ((this.rBranchAttr != null) && (!this.rBranchAttr.equals(other.getRBranchAttr()))) return false;
/* 1061 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 1062 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 1063 */     if (this.deep != other.getDeep()) return false;
/* 1064 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 1065 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 1066 */     if ((this.breakDate == null) && (other.getBreakDate() != null)) return false;
/* 1067 */     if ((this.breakDate != null) && (!this.fDate.getString(this.breakDate).equals(other.getBreakDate()))) return false;
/* 1068 */     if ((this.pBreakDate == null) && (other.getPBreakDate() != null)) return false;
/* 1069 */     if ((this.pBreakDate != null) && (!this.fDate.getString(this.pBreakDate).equals(other.getPBreakDate()))) return false;
/* 1070 */     if ((this.breakType == null) && (other.getBreakType() != null)) return false;
/* 1071 */     if ((this.breakType != null) && (!this.breakType.equals(other.getBreakType()))) return false;
/* 1072 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1073 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1074 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1075 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1076 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1077 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1078 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1079 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1080 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1081 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1082 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1083 */     return (this.operator == null) || (this.operator.equals(other.getOperator()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1090 */     return 24;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1096 */     if (strFieldName.equals("manageCom")) {
/* 1097 */       return 0;
/*      */     }
/* 1099 */     if (strFieldName.equals("agentCode")) {
/* 1100 */       return 1;
/*      */     }
/* 1102 */     if (strFieldName.equals("agentGrade")) {
/* 1103 */       return 2;
/*      */     }
/* 1105 */     if (strFieldName.equals("agentGroup")) {
/* 1106 */       return 3;
/*      */     }
/* 1108 */     if (strFieldName.equals("sMAgentCode")) {
/* 1109 */       return 4;
/*      */     }
/* 1111 */     if (strFieldName.equals("aMAgentCode")) {
/* 1112 */       return 5;
/*      */     }
/* 1114 */     if (strFieldName.equals("rAgentCode")) {
/* 1115 */       return 6;
/*      */     }
/* 1117 */     if (strFieldName.equals("agentTitle")) {
/* 1118 */       return 7;
/*      */     }
/* 1120 */     if (strFieldName.equals("rAgentGrade")) {
/* 1121 */       return 8;
/*      */     }
/* 1123 */     if (strFieldName.equals("rAgentTitle")) {
/* 1124 */       return 9;
/*      */     }
/* 1126 */     if (strFieldName.equals("rAgentGroup")) {
/* 1127 */       return 10;
/*      */     }
/* 1129 */     if (strFieldName.equals("rBranchAttr")) {
/* 1130 */       return 11;
/*      */     }
/* 1132 */     if (strFieldName.equals("type")) {
/* 1133 */       return 12;
/*      */     }
/* 1135 */     if (strFieldName.equals("deep")) {
/* 1136 */       return 13;
/*      */     }
/* 1138 */     if (strFieldName.equals("startDate")) {
/* 1139 */       return 14;
/*      */     }
/* 1141 */     if (strFieldName.equals("breakDate")) {
/* 1142 */       return 15;
/*      */     }
/* 1144 */     if (strFieldName.equals("pBreakDate")) {
/* 1145 */       return 16;
/*      */     }
/* 1147 */     if (strFieldName.equals("breakType")) {
/* 1148 */       return 17;
/*      */     }
/* 1150 */     if (strFieldName.equals("state")) {
/* 1151 */       return 18;
/*      */     }
/* 1153 */     if (strFieldName.equals("makeDate")) {
/* 1154 */       return 19;
/*      */     }
/* 1156 */     if (strFieldName.equals("makeTime")) {
/* 1157 */       return 20;
/*      */     }
/* 1159 */     if (strFieldName.equals("modifyDate")) {
/* 1160 */       return 21;
/*      */     }
/* 1162 */     if (strFieldName.equals("modifyTime")) {
/* 1163 */       return 22;
/*      */     }
/* 1165 */     if (strFieldName.equals("operator")) {
/* 1166 */       return 23;
/*      */     }
/* 1168 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1174 */     String strFieldName = "";
/* 1175 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1177 */       strFieldName = "manageCom";
/* 1178 */       break;
/*      */     case 1:
/* 1180 */       strFieldName = "agentCode";
/* 1181 */       break;
/*      */     case 2:
/* 1183 */       strFieldName = "agentGrade";
/* 1184 */       break;
/*      */     case 3:
/* 1186 */       strFieldName = "agentGroup";
/* 1187 */       break;
/*      */     case 4:
/* 1189 */       strFieldName = "sMAgentCode";
/* 1190 */       break;
/*      */     case 5:
/* 1192 */       strFieldName = "aMAgentCode";
/* 1193 */       break;
/*      */     case 6:
/* 1195 */       strFieldName = "rAgentCode";
/* 1196 */       break;
/*      */     case 7:
/* 1198 */       strFieldName = "agentTitle";
/* 1199 */       break;
/*      */     case 8:
/* 1201 */       strFieldName = "rAgentGrade";
/* 1202 */       break;
/*      */     case 9:
/* 1204 */       strFieldName = "rAgentTitle";
/* 1205 */       break;
/*      */     case 10:
/* 1207 */       strFieldName = "rAgentGroup";
/* 1208 */       break;
/*      */     case 11:
/* 1210 */       strFieldName = "rBranchAttr";
/* 1211 */       break;
/*      */     case 12:
/* 1213 */       strFieldName = "type";
/* 1214 */       break;
/*      */     case 13:
/* 1216 */       strFieldName = "deep";
/* 1217 */       break;
/*      */     case 14:
/* 1219 */       strFieldName = "startDate";
/* 1220 */       break;
/*      */     case 15:
/* 1222 */       strFieldName = "breakDate";
/* 1223 */       break;
/*      */     case 16:
/* 1225 */       strFieldName = "pBreakDate";
/* 1226 */       break;
/*      */     case 17:
/* 1228 */       strFieldName = "breakType";
/* 1229 */       break;
/*      */     case 18:
/* 1231 */       strFieldName = "state";
/* 1232 */       break;
/*      */     case 19:
/* 1234 */       strFieldName = "makeDate";
/* 1235 */       break;
/*      */     case 20:
/* 1237 */       strFieldName = "makeTime";
/* 1238 */       break;
/*      */     case 21:
/* 1240 */       strFieldName = "modifyDate";
/* 1241 */       break;
/*      */     case 22:
/* 1243 */       strFieldName = "modifyTime";
/* 1244 */       break;
/*      */     case 23:
/* 1246 */       strFieldName = "operator";
/* 1247 */       break;
/*      */     default:
/* 1249 */       strFieldName = "";
/*      */     }
/* 1251 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1257 */     if (strFieldName.equals("manageCom")) {
/* 1258 */       return 0;
/*      */     }
/* 1260 */     if (strFieldName.equals("agentCode")) {
/* 1261 */       return 0;
/*      */     }
/* 1263 */     if (strFieldName.equals("agentGrade")) {
/* 1264 */       return 0;
/*      */     }
/* 1266 */     if (strFieldName.equals("agentGroup")) {
/* 1267 */       return 0;
/*      */     }
/* 1269 */     if (strFieldName.equals("sMAgentCode")) {
/* 1270 */       return 0;
/*      */     }
/* 1272 */     if (strFieldName.equals("aMAgentCode")) {
/* 1273 */       return 0;
/*      */     }
/* 1275 */     if (strFieldName.equals("rAgentCode")) {
/* 1276 */       return 0;
/*      */     }
/* 1278 */     if (strFieldName.equals("agentTitle")) {
/* 1279 */       return 0;
/*      */     }
/* 1281 */     if (strFieldName.equals("rAgentGrade")) {
/* 1282 */       return 0;
/*      */     }
/* 1284 */     if (strFieldName.equals("rAgentTitle")) {
/* 1285 */       return 0;
/*      */     }
/* 1287 */     if (strFieldName.equals("rAgentGroup")) {
/* 1288 */       return 0;
/*      */     }
/* 1290 */     if (strFieldName.equals("rBranchAttr")) {
/* 1291 */       return 0;
/*      */     }
/* 1293 */     if (strFieldName.equals("type")) {
/* 1294 */       return 0;
/*      */     }
/* 1296 */     if (strFieldName.equals("deep")) {
/* 1297 */       return 3;
/*      */     }
/* 1299 */     if (strFieldName.equals("startDate")) {
/* 1300 */       return 1;
/*      */     }
/* 1302 */     if (strFieldName.equals("breakDate")) {
/* 1303 */       return 1;
/*      */     }
/* 1305 */     if (strFieldName.equals("pBreakDate")) {
/* 1306 */       return 1;
/*      */     }
/* 1308 */     if (strFieldName.equals("breakType")) {
/* 1309 */       return 0;
/*      */     }
/* 1311 */     if (strFieldName.equals("state")) {
/* 1312 */       return 0;
/*      */     }
/* 1314 */     if (strFieldName.equals("makeDate")) {
/* 1315 */       return 1;
/*      */     }
/* 1317 */     if (strFieldName.equals("makeTime")) {
/* 1318 */       return 0;
/*      */     }
/* 1320 */     if (strFieldName.equals("modifyDate")) {
/* 1321 */       return 1;
/*      */     }
/* 1323 */     if (strFieldName.equals("modifyTime")) {
/* 1324 */       return 0;
/*      */     }
/* 1326 */     if (strFieldName.equals("operator")) {
/* 1327 */       return 0;
/*      */     }
/* 1329 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1335 */     int nFieldType = -1;
/* 1336 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1338 */       nFieldType = 0;
/* 1339 */       break;
/*      */     case 1:
/* 1341 */       nFieldType = 0;
/* 1342 */       break;
/*      */     case 2:
/* 1344 */       nFieldType = 0;
/* 1345 */       break;
/*      */     case 3:
/* 1347 */       nFieldType = 0;
/* 1348 */       break;
/*      */     case 4:
/* 1350 */       nFieldType = 0;
/* 1351 */       break;
/*      */     case 5:
/* 1353 */       nFieldType = 0;
/* 1354 */       break;
/*      */     case 6:
/* 1356 */       nFieldType = 0;
/* 1357 */       break;
/*      */     case 7:
/* 1359 */       nFieldType = 0;
/* 1360 */       break;
/*      */     case 8:
/* 1362 */       nFieldType = 0;
/* 1363 */       break;
/*      */     case 9:
/* 1365 */       nFieldType = 0;
/* 1366 */       break;
/*      */     case 10:
/* 1368 */       nFieldType = 0;
/* 1369 */       break;
/*      */     case 11:
/* 1371 */       nFieldType = 0;
/* 1372 */       break;
/*      */     case 12:
/* 1374 */       nFieldType = 0;
/* 1375 */       break;
/*      */     case 13:
/* 1377 */       nFieldType = 3;
/* 1378 */       break;
/*      */     case 14:
/* 1380 */       nFieldType = 1;
/* 1381 */       break;
/*      */     case 15:
/* 1383 */       nFieldType = 1;
/* 1384 */       break;
/*      */     case 16:
/* 1386 */       nFieldType = 1;
/* 1387 */       break;
/*      */     case 17:
/* 1389 */       nFieldType = 0;
/* 1390 */       break;
/*      */     case 18:
/* 1392 */       nFieldType = 0;
/* 1393 */       break;
/*      */     case 19:
/* 1395 */       nFieldType = 1;
/* 1396 */       break;
/*      */     case 20:
/* 1398 */       nFieldType = 0;
/* 1399 */       break;
/*      */     case 21:
/* 1401 */       nFieldType = 1;
/* 1402 */       break;
/*      */     case 22:
/* 1404 */       nFieldType = 0;
/* 1405 */       break;
/*      */     case 23:
/* 1407 */       nFieldType = 0;
/* 1408 */       break;
/*      */     default:
/* 1410 */       nFieldType = -1;
/*      */     }
/* 1412 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.LARearRelationNewSchema
 * JD-Core Version:    0.6.0
 */