/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPInsureHistoryDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPInsureHistorySchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String prtNo;
/*      */   private String polOrder;
/*      */   private String comName;
/*      */   private double sumInsuredDeath;
/*      */   private double sumInsuredDisease;
/*      */   private String policyState;
/*      */   private String state;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String p2;
/*      */   private double p4;
/*      */   private double p3;
/*      */   private String p1;
/*      */   public static final int FIELDNUM = 19;
/*      */   private static String[] PK;
/*   65 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPInsureHistorySchema()
/*      */   {
/*   72 */     this.mErrors = new CErrors();
/*      */ 
/*   74 */     String[] pk = new String[2];
/*   75 */     pk[0] = "ContNo";
/*   76 */     pk[1] = "PolOrder";
/*      */ 
/*   78 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   85 */     LNPInsureHistorySchema cloned = (LNPInsureHistorySchema)super.clone();
/*   86 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   87 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   88 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   94 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo()
/*      */   {
/*   99 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  103 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  107 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  111 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  115 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  119 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public String getPrtNo() {
/*  123 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setPrtNo(String aPrtNo) {
/*  127 */     this.prtNo = aPrtNo;
/*      */   }
/*      */ 
/*      */   public String getPolOrder() {
/*  131 */     return this.polOrder;
/*      */   }
/*      */ 
/*      */   public void setPolOrder(String aPolOrder) {
/*  135 */     this.polOrder = aPolOrder;
/*      */   }
/*      */ 
/*      */   public String getComName() {
/*  139 */     return this.comName;
/*      */   }
/*      */ 
/*      */   public void setComName(String aComName) {
/*  143 */     this.comName = aComName;
/*      */   }
/*      */ 
/*      */   public double getSumInsuredDeath() {
/*  147 */     return this.sumInsuredDeath;
/*      */   }
/*      */ 
/*      */   public void setSumInsuredDeath(double aSumInsuredDeath) {
/*  151 */     this.sumInsuredDeath = aSumInsuredDeath;
/*      */   }
/*      */ 
/*      */   public void setSumInsuredDeath(String aSumInsuredDeath) {
/*  155 */     if ((aSumInsuredDeath != null) && (!aSumInsuredDeath.equals("")))
/*      */     {
/*  157 */       Double tDouble = new Double(aSumInsuredDeath);
/*  158 */       double d = tDouble.doubleValue();
/*  159 */       this.sumInsuredDeath = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSumInsuredDisease()
/*      */   {
/*  165 */     return this.sumInsuredDisease;
/*      */   }
/*      */ 
/*      */   public void setSumInsuredDisease(double aSumInsuredDisease) {
/*  169 */     this.sumInsuredDisease = aSumInsuredDisease;
/*      */   }
/*      */ 
/*      */   public void setSumInsuredDisease(String aSumInsuredDisease) {
/*  173 */     if ((aSumInsuredDisease != null) && (!aSumInsuredDisease.equals("")))
/*      */     {
/*  175 */       Double tDouble = new Double(aSumInsuredDisease);
/*  176 */       double d = tDouble.doubleValue();
/*  177 */       this.sumInsuredDisease = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPolicyState()
/*      */   {
/*  183 */     return this.policyState;
/*      */   }
/*      */ 
/*      */   public void setPolicyState(String aPolicyState) {
/*  187 */     this.policyState = aPolicyState;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  191 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  195 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  199 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  203 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  207 */     if (this.makeDate != null) {
/*  208 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  210 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  214 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  218 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  220 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  223 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  228 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  232 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  236 */     if (this.modifyDate != null) {
/*  237 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  239 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  243 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  247 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  249 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  252 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  257 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  261 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getP2() {
/*  265 */     return this.p2;
/*      */   }
/*      */ 
/*      */   public void setP2(String aP2) {
/*  269 */     this.p2 = aP2;
/*      */   }
/*      */ 
/*      */   public double getP4() {
/*  273 */     return this.p4;
/*      */   }
/*      */ 
/*      */   public void setP4(double aP4) {
/*  277 */     this.p4 = aP4;
/*      */   }
/*      */ 
/*      */   public void setP4(String aP4) {
/*  281 */     if ((aP4 != null) && (!aP4.equals("")))
/*      */     {
/*  283 */       Double tDouble = new Double(aP4);
/*  284 */       double d = tDouble.doubleValue();
/*  285 */       this.p4 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getP3()
/*      */   {
/*  291 */     return this.p3;
/*      */   }
/*      */ 
/*      */   public void setP3(double aP3) {
/*  295 */     this.p3 = aP3;
/*      */   }
/*      */ 
/*      */   public void setP3(String aP3) {
/*  299 */     if ((aP3 != null) && (!aP3.equals("")))
/*      */     {
/*  301 */       Double tDouble = new Double(aP3);
/*  302 */       double d = tDouble.doubleValue();
/*  303 */       this.p3 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getP1()
/*      */   {
/*  309 */     return this.p1;
/*      */   }
/*      */ 
/*      */   public void setP1(String aP1) {
/*  313 */     this.p1 = aP1;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPInsureHistorySchema aLNPInsureHistorySchema)
/*      */   {
/*  319 */     this.grpContNo = aLNPInsureHistorySchema.getGrpContNo();
/*  320 */     this.contNo = aLNPInsureHistorySchema.getContNo();
/*  321 */     this.proposalContNo = aLNPInsureHistorySchema.getProposalContNo();
/*  322 */     this.prtNo = aLNPInsureHistorySchema.getPrtNo();
/*  323 */     this.polOrder = aLNPInsureHistorySchema.getPolOrder();
/*  324 */     this.comName = aLNPInsureHistorySchema.getComName();
/*  325 */     this.sumInsuredDeath = aLNPInsureHistorySchema.getSumInsuredDeath();
/*  326 */     this.sumInsuredDisease = aLNPInsureHistorySchema.getSumInsuredDisease();
/*  327 */     this.policyState = aLNPInsureHistorySchema.getPolicyState();
/*  328 */     this.state = aLNPInsureHistorySchema.getState();
/*  329 */     this.operator = aLNPInsureHistorySchema.getOperator();
/*  330 */     this.makeDate = this.fDate.getDate(aLNPInsureHistorySchema.getMakeDate());
/*  331 */     this.makeTime = aLNPInsureHistorySchema.getMakeTime();
/*  332 */     this.modifyDate = this.fDate.getDate(aLNPInsureHistorySchema.getModifyDate());
/*  333 */     this.modifyTime = aLNPInsureHistorySchema.getModifyTime();
/*  334 */     this.p2 = aLNPInsureHistorySchema.getP2();
/*  335 */     this.p4 = aLNPInsureHistorySchema.getP4();
/*  336 */     this.p3 = aLNPInsureHistorySchema.getP3();
/*  337 */     this.p1 = aLNPInsureHistorySchema.getP1();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  346 */       if (rs.getString("GrpContNo") == null)
/*  347 */         this.grpContNo = null;
/*      */       else {
/*  349 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  351 */       if (rs.getString("ContNo") == null)
/*  352 */         this.contNo = null;
/*      */       else {
/*  354 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  356 */       if (rs.getString("ProposalContNo") == null)
/*  357 */         this.proposalContNo = null;
/*      */       else {
/*  359 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  361 */       if (rs.getString("PrtNo") == null)
/*  362 */         this.prtNo = null;
/*      */       else {
/*  364 */         this.prtNo = rs.getString("PrtNo").trim();
/*      */       }
/*  366 */       if (rs.getString("PolOrder") == null)
/*  367 */         this.polOrder = null;
/*      */       else {
/*  369 */         this.polOrder = rs.getString("PolOrder").trim();
/*      */       }
/*  371 */       if (rs.getString("ComName") == null)
/*  372 */         this.comName = null;
/*      */       else {
/*  374 */         this.comName = rs.getString("ComName").trim();
/*      */       }
/*  376 */       this.sumInsuredDeath = rs.getDouble("SumInsuredDeath");
/*  377 */       this.sumInsuredDisease = rs.getDouble("SumInsuredDisease");
/*  378 */       if (rs.getString("PolicyState") == null)
/*  379 */         this.policyState = null;
/*      */       else {
/*  381 */         this.policyState = rs.getString("PolicyState").trim();
/*      */       }
/*  383 */       if (rs.getString("State") == null)
/*  384 */         this.state = null;
/*      */       else {
/*  386 */         this.state = rs.getString("State").trim();
/*      */       }
/*  388 */       if (rs.getString("Operator") == null)
/*  389 */         this.operator = null;
/*      */       else {
/*  391 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  393 */       this.makeDate = rs.getDate("MakeDate");
/*  394 */       if (rs.getString("MakeTime") == null)
/*  395 */         this.makeTime = null;
/*      */       else {
/*  397 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  399 */       this.modifyDate = rs.getDate("ModifyDate");
/*  400 */       if (rs.getString("ModifyTime") == null)
/*  401 */         this.modifyTime = null;
/*      */       else {
/*  403 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  405 */       if (rs.getString("p2") == null)
/*  406 */         this.p2 = null;
/*      */       else {
/*  408 */         this.p2 = rs.getString("p2").trim();
/*      */       }
/*  410 */       this.p4 = rs.getDouble("p4");
/*  411 */       this.p3 = rs.getDouble("p3");
/*  412 */       if (rs.getString("p1") == null)
/*  413 */         this.p1 = null;
/*      */       else {
/*  415 */         this.p1 = rs.getString("p1").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  420 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPInsureHistory\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/*  422 */       CError tError = new CError();
/*  423 */       tError.moduleName = "LNPInsureHistorySchema";
/*  424 */       tError.functionName = "setSchema";
/*  425 */       tError.errorMessage = sqle.toString();
/*  426 */       this.mErrors.addOneError(tError);
/*  427 */       return false;
/*      */     }
/*  429 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInsureHistorySchema getSchema()
/*      */   {
/*  434 */     LNPInsureHistorySchema aLNPInsureHistorySchema = new LNPInsureHistorySchema();
/*  435 */     aLNPInsureHistorySchema.setSchema(this);
/*  436 */     return aLNPInsureHistorySchema;
/*      */   }
/*      */ 
/*      */   public LNPInsureHistoryDB getDB()
/*      */   {
/*  441 */     LNPInsureHistoryDB aDBOper = new LNPInsureHistoryDB();
/*  442 */     aDBOper.setSchema(this);
/*  443 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  450 */     StringBuffer strReturn = new StringBuffer(256);
/*  451 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/*  452 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/*  453 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/*  454 */     strReturn.append(StrTool.cTrim(this.prtNo)); strReturn.append("|");
/*  455 */     strReturn.append(StrTool.cTrim(this.polOrder)); strReturn.append("|");
/*  456 */     strReturn.append(StrTool.cTrim(this.comName)); strReturn.append("|");
/*  457 */     strReturn.append(ChgData.chgData(this.sumInsuredDeath)); strReturn.append("|");
/*  458 */     strReturn.append(ChgData.chgData(this.sumInsuredDisease)); strReturn.append("|");
/*  459 */     strReturn.append(StrTool.cTrim(this.policyState)); strReturn.append("|");
/*  460 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  461 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  462 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  463 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  464 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  465 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  466 */     strReturn.append(StrTool.cTrim(this.p2)); strReturn.append("|");
/*  467 */     strReturn.append(ChgData.chgData(this.p4)); strReturn.append("|");
/*  468 */     strReturn.append(ChgData.chgData(this.p3)); strReturn.append("|");
/*  469 */     strReturn.append(StrTool.cTrim(this.p1));
/*  470 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  478 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  479 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  480 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  481 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  482 */       this.polOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  483 */       this.comName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  484 */       this.sumInsuredDeath = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).doubleValue();
/*  485 */       this.sumInsuredDisease = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).doubleValue();
/*  486 */       this.policyState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  487 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  488 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  489 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
/*  490 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  491 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/*  492 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  493 */       this.p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  494 */       this.p4 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 17, "|"))).doubleValue();
/*  495 */       this.p3 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|"))).doubleValue();
/*  496 */       this.p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  501 */       CError tError = new CError();
/*  502 */       tError.moduleName = "LNPInsureHistorySchema";
/*  503 */       tError.functionName = "decode";
/*  504 */       tError.errorMessage = ex.toString();
/*  505 */       this.mErrors.addOneError(tError);
/*      */ 
/*  507 */       return false;
/*      */     }
/*  509 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  515 */     String strReturn = "";
/*  516 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  518 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  520 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  522 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  524 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  526 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  528 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/*  530 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/*  532 */     if (FCode.equalsIgnoreCase("polOrder"))
/*      */     {
/*  534 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polOrder));
/*      */     }
/*  536 */     if (FCode.equalsIgnoreCase("comName"))
/*      */     {
/*  538 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comName));
/*      */     }
/*  540 */     if (FCode.equalsIgnoreCase("sumInsuredDeath"))
/*      */     {
/*  542 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sumInsuredDeath));
/*      */     }
/*  544 */     if (FCode.equalsIgnoreCase("sumInsuredDisease"))
/*      */     {
/*  546 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sumInsuredDisease));
/*      */     }
/*  548 */     if (FCode.equalsIgnoreCase("policyState"))
/*      */     {
/*  550 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.policyState));
/*      */     }
/*  552 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  554 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  556 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  558 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  560 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  562 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  564 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  566 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  568 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  570 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  572 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  574 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  576 */     if (FCode.equalsIgnoreCase("p2"))
/*      */     {
/*  578 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p2));
/*      */     }
/*  580 */     if (FCode.equalsIgnoreCase("p4"))
/*      */     {
/*  582 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p4));
/*      */     }
/*  584 */     if (FCode.equalsIgnoreCase("p3"))
/*      */     {
/*  586 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p3));
/*      */     }
/*  588 */     if (FCode.equalsIgnoreCase("p1"))
/*      */     {
/*  590 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p1));
/*      */     }
/*  592 */     if (strReturn.equals(""))
/*      */     {
/*  594 */       strReturn = "null";
/*      */     }
/*      */ 
/*  597 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  604 */     String strFieldValue = "";
/*  605 */     switch (nFieldIndex) {
/*      */     case 0:
/*  607 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  608 */       break;
/*      */     case 1:
/*  610 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  611 */       break;
/*      */     case 2:
/*  613 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  614 */       break;
/*      */     case 3:
/*  616 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/*  617 */       break;
/*      */     case 4:
/*  619 */       strFieldValue = StrTool.GBKToUnicode(this.polOrder);
/*  620 */       break;
/*      */     case 5:
/*  622 */       strFieldValue = StrTool.GBKToUnicode(this.comName);
/*  623 */       break;
/*      */     case 6:
/*  625 */       strFieldValue = String.valueOf(this.sumInsuredDeath);
/*  626 */       break;
/*      */     case 7:
/*  628 */       strFieldValue = String.valueOf(this.sumInsuredDisease);
/*  629 */       break;
/*      */     case 8:
/*  631 */       strFieldValue = StrTool.GBKToUnicode(this.policyState);
/*  632 */       break;
/*      */     case 9:
/*  634 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  635 */       break;
/*      */     case 10:
/*  637 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  638 */       break;
/*      */     case 11:
/*  640 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  641 */       break;
/*      */     case 12:
/*  643 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  644 */       break;
/*      */     case 13:
/*  646 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  647 */       break;
/*      */     case 14:
/*  649 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  650 */       break;
/*      */     case 15:
/*  652 */       strFieldValue = StrTool.GBKToUnicode(this.p2);
/*  653 */       break;
/*      */     case 16:
/*  655 */       strFieldValue = String.valueOf(this.p4);
/*  656 */       break;
/*      */     case 17:
/*  658 */       strFieldValue = String.valueOf(this.p3);
/*  659 */       break;
/*      */     case 18:
/*  661 */       strFieldValue = StrTool.GBKToUnicode(this.p1);
/*  662 */       break;
/*      */     default:
/*  664 */       strFieldValue = "";
/*      */     }
/*  666 */     if (strFieldValue.equals("")) {
/*  667 */       strFieldValue = "null";
/*      */     }
/*  669 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  675 */     if (StrTool.cTrim(FCode).equals("")) {
/*  676 */       return false;
/*      */     }
/*  678 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  680 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  682 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/*  685 */         this.grpContNo = null;
/*      */     }
/*  687 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  689 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  691 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/*  694 */         this.contNo = null;
/*      */     }
/*  696 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  698 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  700 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/*  703 */         this.proposalContNo = null;
/*      */     }
/*  705 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/*  707 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  709 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/*  712 */         this.prtNo = null;
/*      */     }
/*  714 */     if (FCode.equalsIgnoreCase("polOrder"))
/*      */     {
/*  716 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  718 */         this.polOrder = FValue.trim();
/*      */       }
/*      */       else
/*  721 */         this.polOrder = null;
/*      */     }
/*  723 */     if (FCode.equalsIgnoreCase("comName"))
/*      */     {
/*  725 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  727 */         this.comName = FValue.trim();
/*      */       }
/*      */       else
/*  730 */         this.comName = null;
/*      */     }
/*  732 */     if (FCode.equalsIgnoreCase("sumInsuredDeath"))
/*      */     {
/*  734 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  736 */         Double tDouble = new Double(FValue);
/*  737 */         double d = tDouble.doubleValue();
/*  738 */         this.sumInsuredDeath = d;
/*      */       }
/*      */     }
/*  741 */     if (FCode.equalsIgnoreCase("sumInsuredDisease"))
/*      */     {
/*  743 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  745 */         Double tDouble = new Double(FValue);
/*  746 */         double d = tDouble.doubleValue();
/*  747 */         this.sumInsuredDisease = d;
/*      */       }
/*      */     }
/*  750 */     if (FCode.equalsIgnoreCase("policyState"))
/*      */     {
/*  752 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  754 */         this.policyState = FValue.trim();
/*      */       }
/*      */       else
/*  757 */         this.policyState = null;
/*      */     }
/*  759 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  761 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  763 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  766 */         this.state = null;
/*      */     }
/*  768 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  770 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  772 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  775 */         this.operator = null;
/*      */     }
/*  777 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  779 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  781 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  784 */         this.makeDate = null;
/*      */     }
/*  786 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  788 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  790 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  793 */         this.makeTime = null;
/*      */     }
/*  795 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  797 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  799 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  802 */         this.modifyDate = null;
/*      */     }
/*  804 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  806 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  808 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  811 */         this.modifyTime = null;
/*      */     }
/*  813 */     if (FCode.equalsIgnoreCase("p2"))
/*      */     {
/*  815 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  817 */         this.p2 = FValue.trim();
/*      */       }
/*      */       else
/*  820 */         this.p2 = null;
/*      */     }
/*  822 */     if (FCode.equalsIgnoreCase("p4"))
/*      */     {
/*  824 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  826 */         Double tDouble = new Double(FValue);
/*  827 */         double d = tDouble.doubleValue();
/*  828 */         this.p4 = d;
/*      */       }
/*      */     }
/*  831 */     if (FCode.equalsIgnoreCase("p3"))
/*      */     {
/*  833 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  835 */         Double tDouble = new Double(FValue);
/*  836 */         double d = tDouble.doubleValue();
/*  837 */         this.p3 = d;
/*      */       }
/*      */     }
/*  840 */     if (FCode.equalsIgnoreCase("p1"))
/*      */     {
/*  842 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  844 */         this.p1 = FValue.trim();
/*      */       }
/*      */       else
/*  847 */         this.p1 = null;
/*      */     }
/*  849 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  854 */     if (otherObject == null) return false;
/*  855 */     if (this == otherObject) return true;
/*  856 */     if (getClass() != otherObject.getClass()) return false;
/*  857 */     LNPInsureHistorySchema other = (LNPInsureHistorySchema)otherObject;
/*  858 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/*  859 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/*  860 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/*  861 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/*  862 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/*  863 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/*  864 */     if ((this.prtNo == null) && (other.getPrtNo() != null)) return false;
/*  865 */     if ((this.prtNo != null) && (!this.prtNo.equals(other.getPrtNo()))) return false;
/*  866 */     if ((this.polOrder == null) && (other.getPolOrder() != null)) return false;
/*  867 */     if ((this.polOrder != null) && (!this.polOrder.equals(other.getPolOrder()))) return false;
/*  868 */     if ((this.comName == null) && (other.getComName() != null)) return false;
/*  869 */     if ((this.comName != null) && (!this.comName.equals(other.getComName()))) return false;
/*  870 */     if (Double.doubleToLongBits(this.sumInsuredDeath) != Double.doubleToLongBits(other.getSumInsuredDeath())) return false;
/*  871 */     if (Double.doubleToLongBits(this.sumInsuredDisease) != Double.doubleToLongBits(other.getSumInsuredDisease())) return false;
/*  872 */     if ((this.policyState == null) && (other.getPolicyState() != null)) return false;
/*  873 */     if ((this.policyState != null) && (!this.policyState.equals(other.getPolicyState()))) return false;
/*  874 */     if ((this.state == null) && (other.getState() != null)) return false;
/*  875 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/*  876 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  877 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  878 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  879 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  880 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  881 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  882 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  883 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  884 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  885 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/*  886 */     if ((this.p2 == null) && (other.getP2() != null)) return false;
/*  887 */     if ((this.p2 != null) && (!this.p2.equals(other.getP2()))) return false;
/*  888 */     if (Double.doubleToLongBits(this.p4) != Double.doubleToLongBits(other.getP4())) return false;
/*  889 */     if (Double.doubleToLongBits(this.p3) != Double.doubleToLongBits(other.getP3())) return false;
/*  890 */     if ((this.p1 == null) && (other.getP1() != null)) return false;
/*  891 */     return (this.p1 == null) || (this.p1.equals(other.getP1()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  898 */     return 19;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  904 */     if (strFieldName.equals("grpContNo")) {
/*  905 */       return 0;
/*      */     }
/*  907 */     if (strFieldName.equals("contNo")) {
/*  908 */       return 1;
/*      */     }
/*  910 */     if (strFieldName.equals("proposalContNo")) {
/*  911 */       return 2;
/*      */     }
/*  913 */     if (strFieldName.equals("prtNo")) {
/*  914 */       return 3;
/*      */     }
/*  916 */     if (strFieldName.equals("polOrder")) {
/*  917 */       return 4;
/*      */     }
/*  919 */     if (strFieldName.equals("comName")) {
/*  920 */       return 5;
/*      */     }
/*  922 */     if (strFieldName.equals("sumInsuredDeath")) {
/*  923 */       return 6;
/*      */     }
/*  925 */     if (strFieldName.equals("sumInsuredDisease")) {
/*  926 */       return 7;
/*      */     }
/*  928 */     if (strFieldName.equals("policyState")) {
/*  929 */       return 8;
/*      */     }
/*  931 */     if (strFieldName.equals("state")) {
/*  932 */       return 9;
/*      */     }
/*  934 */     if (strFieldName.equals("operator")) {
/*  935 */       return 10;
/*      */     }
/*  937 */     if (strFieldName.equals("makeDate")) {
/*  938 */       return 11;
/*      */     }
/*  940 */     if (strFieldName.equals("makeTime")) {
/*  941 */       return 12;
/*      */     }
/*  943 */     if (strFieldName.equals("modifyDate")) {
/*  944 */       return 13;
/*      */     }
/*  946 */     if (strFieldName.equals("modifyTime")) {
/*  947 */       return 14;
/*      */     }
/*  949 */     if (strFieldName.equals("p2")) {
/*  950 */       return 15;
/*      */     }
/*  952 */     if (strFieldName.equals("p4")) {
/*  953 */       return 16;
/*      */     }
/*  955 */     if (strFieldName.equals("p3")) {
/*  956 */       return 17;
/*      */     }
/*  958 */     if (strFieldName.equals("p1")) {
/*  959 */       return 18;
/*      */     }
/*  961 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  967 */     String strFieldName = "";
/*  968 */     switch (nFieldIndex) {
/*      */     case 0:
/*  970 */       strFieldName = "grpContNo";
/*  971 */       break;
/*      */     case 1:
/*  973 */       strFieldName = "contNo";
/*  974 */       break;
/*      */     case 2:
/*  976 */       strFieldName = "proposalContNo";
/*  977 */       break;
/*      */     case 3:
/*  979 */       strFieldName = "prtNo";
/*  980 */       break;
/*      */     case 4:
/*  982 */       strFieldName = "polOrder";
/*  983 */       break;
/*      */     case 5:
/*  985 */       strFieldName = "comName";
/*  986 */       break;
/*      */     case 6:
/*  988 */       strFieldName = "sumInsuredDeath";
/*  989 */       break;
/*      */     case 7:
/*  991 */       strFieldName = "sumInsuredDisease";
/*  992 */       break;
/*      */     case 8:
/*  994 */       strFieldName = "policyState";
/*  995 */       break;
/*      */     case 9:
/*  997 */       strFieldName = "state";
/*  998 */       break;
/*      */     case 10:
/* 1000 */       strFieldName = "operator";
/* 1001 */       break;
/*      */     case 11:
/* 1003 */       strFieldName = "makeDate";
/* 1004 */       break;
/*      */     case 12:
/* 1006 */       strFieldName = "makeTime";
/* 1007 */       break;
/*      */     case 13:
/* 1009 */       strFieldName = "modifyDate";
/* 1010 */       break;
/*      */     case 14:
/* 1012 */       strFieldName = "modifyTime";
/* 1013 */       break;
/*      */     case 15:
/* 1015 */       strFieldName = "p2";
/* 1016 */       break;
/*      */     case 16:
/* 1018 */       strFieldName = "p4";
/* 1019 */       break;
/*      */     case 17:
/* 1021 */       strFieldName = "p3";
/* 1022 */       break;
/*      */     case 18:
/* 1024 */       strFieldName = "p1";
/* 1025 */       break;
/*      */     default:
/* 1027 */       strFieldName = "";
/*      */     }
/* 1029 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1035 */     if (strFieldName.equals("grpContNo")) {
/* 1036 */       return 0;
/*      */     }
/* 1038 */     if (strFieldName.equals("contNo")) {
/* 1039 */       return 0;
/*      */     }
/* 1041 */     if (strFieldName.equals("proposalContNo")) {
/* 1042 */       return 0;
/*      */     }
/* 1044 */     if (strFieldName.equals("prtNo")) {
/* 1045 */       return 0;
/*      */     }
/* 1047 */     if (strFieldName.equals("polOrder")) {
/* 1048 */       return 0;
/*      */     }
/* 1050 */     if (strFieldName.equals("comName")) {
/* 1051 */       return 0;
/*      */     }
/* 1053 */     if (strFieldName.equals("sumInsuredDeath")) {
/* 1054 */       return 4;
/*      */     }
/* 1056 */     if (strFieldName.equals("sumInsuredDisease")) {
/* 1057 */       return 4;
/*      */     }
/* 1059 */     if (strFieldName.equals("policyState")) {
/* 1060 */       return 0;
/*      */     }
/* 1062 */     if (strFieldName.equals("state")) {
/* 1063 */       return 0;
/*      */     }
/* 1065 */     if (strFieldName.equals("operator")) {
/* 1066 */       return 0;
/*      */     }
/* 1068 */     if (strFieldName.equals("makeDate")) {
/* 1069 */       return 1;
/*      */     }
/* 1071 */     if (strFieldName.equals("makeTime")) {
/* 1072 */       return 0;
/*      */     }
/* 1074 */     if (strFieldName.equals("modifyDate")) {
/* 1075 */       return 1;
/*      */     }
/* 1077 */     if (strFieldName.equals("modifyTime")) {
/* 1078 */       return 0;
/*      */     }
/* 1080 */     if (strFieldName.equals("p2")) {
/* 1081 */       return 0;
/*      */     }
/* 1083 */     if (strFieldName.equals("p4")) {
/* 1084 */       return 4;
/*      */     }
/* 1086 */     if (strFieldName.equals("p3")) {
/* 1087 */       return 4;
/*      */     }
/* 1089 */     if (strFieldName.equals("p1")) {
/* 1090 */       return 0;
/*      */     }
/* 1092 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1098 */     int nFieldType = -1;
/* 1099 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1101 */       nFieldType = 0;
/* 1102 */       break;
/*      */     case 1:
/* 1104 */       nFieldType = 0;
/* 1105 */       break;
/*      */     case 2:
/* 1107 */       nFieldType = 0;
/* 1108 */       break;
/*      */     case 3:
/* 1110 */       nFieldType = 0;
/* 1111 */       break;
/*      */     case 4:
/* 1113 */       nFieldType = 0;
/* 1114 */       break;
/*      */     case 5:
/* 1116 */       nFieldType = 0;
/* 1117 */       break;
/*      */     case 6:
/* 1119 */       nFieldType = 4;
/* 1120 */       break;
/*      */     case 7:
/* 1122 */       nFieldType = 4;
/* 1123 */       break;
/*      */     case 8:
/* 1125 */       nFieldType = 0;
/* 1126 */       break;
/*      */     case 9:
/* 1128 */       nFieldType = 0;
/* 1129 */       break;
/*      */     case 10:
/* 1131 */       nFieldType = 0;
/* 1132 */       break;
/*      */     case 11:
/* 1134 */       nFieldType = 1;
/* 1135 */       break;
/*      */     case 12:
/* 1137 */       nFieldType = 0;
/* 1138 */       break;
/*      */     case 13:
/* 1140 */       nFieldType = 1;
/* 1141 */       break;
/*      */     case 14:
/* 1143 */       nFieldType = 0;
/* 1144 */       break;
/*      */     case 15:
/* 1146 */       nFieldType = 0;
/* 1147 */       break;
/*      */     case 16:
/* 1149 */       nFieldType = 4;
/* 1150 */       break;
/*      */     case 17:
/* 1152 */       nFieldType = 4;
/* 1153 */       break;
/*      */     case 18:
/* 1155 */       nFieldType = 0;
/* 1156 */       break;
/*      */     default:
/* 1158 */       nFieldType = -1;
/*      */     }
/* 1160 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPInsureHistorySchema
 * JD-Core Version:    0.6.0
 */