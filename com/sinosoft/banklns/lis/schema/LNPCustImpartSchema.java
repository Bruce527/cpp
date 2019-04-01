/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPCustImpartDB;
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
/*      */ public class LNPCustImpartSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String impartId;
/*      */   private String proposalType;
/*      */   private String impartName;
/*      */   private String impartVer;
/*      */   private String impartContent;
/*      */   private int questionSum;
/*      */   private String operator;
/*      */   private String manageCom;
/*      */   private String makeTime;
/*      */   private Date makeDate;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String p1;
/*      */   private String p2;
/*      */   private String p3;
/*      */   private String p4;
/*      */   public static final int FIELDNUM = 16;
/*      */   private static String[] PK;
/*   59 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPCustImpartSchema()
/*      */   {
/*   66 */     this.mErrors = new CErrors();
/*      */ 
/*   68 */     String[] pk = new String[1];
/*   69 */     pk[0] = "ImpartId";
/*      */ 
/*   71 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   78 */     LNPCustImpartSchema cloned = (LNPCustImpartSchema)super.clone();
/*   79 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   80 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   81 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   87 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getImpartId()
/*      */   {
/*   92 */     return this.impartId;
/*      */   }
/*      */ 
/*      */   public void setImpartId(String aImpartId) {
/*   96 */     this.impartId = aImpartId;
/*      */   }
/*      */ 
/*      */   public String getProposalType() {
/*  100 */     return this.proposalType;
/*      */   }
/*      */ 
/*      */   public void setProposalType(String aProposalType) {
/*  104 */     this.proposalType = aProposalType;
/*      */   }
/*      */ 
/*      */   public String getImpartName() {
/*  108 */     return this.impartName;
/*      */   }
/*      */ 
/*      */   public void setImpartName(String aImpartName) {
/*  112 */     this.impartName = aImpartName;
/*      */   }
/*      */ 
/*      */   public String getImpartVer() {
/*  116 */     return this.impartVer;
/*      */   }
/*      */ 
/*      */   public void setImpartVer(String aImpartVer) {
/*  120 */     this.impartVer = aImpartVer;
/*      */   }
/*      */ 
/*      */   public String getImpartContent() {
/*  124 */     return this.impartContent;
/*      */   }
/*      */ 
/*      */   public void setImpartContent(String aImpartContent) {
/*  128 */     this.impartContent = aImpartContent;
/*      */   }
/*      */ 
/*      */   public int getQuestionSum() {
/*  132 */     return this.questionSum;
/*      */   }
/*      */ 
/*      */   public void setQuestionSum(int aQuestionSum) {
/*  136 */     this.questionSum = aQuestionSum;
/*      */   }
/*      */ 
/*      */   public void setQuestionSum(String aQuestionSum) {
/*  140 */     if ((aQuestionSum != null) && (!aQuestionSum.equals("")))
/*      */     {
/*  142 */       Integer tInteger = new Integer(aQuestionSum);
/*  143 */       int i = tInteger.intValue();
/*  144 */       this.questionSum = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  150 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  154 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  158 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  162 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getMakeTime() {
/*  166 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  170 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  174 */     if (this.makeDate != null) {
/*  175 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  177 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  181 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  185 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  187 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  190 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyDate()
/*      */   {
/*  195 */     if (this.modifyDate != null) {
/*  196 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  198 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  202 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  206 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  208 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  211 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  216 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  220 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getP1() {
/*  224 */     return this.p1;
/*      */   }
/*      */ 
/*      */   public void setP1(String aP1) {
/*  228 */     this.p1 = aP1;
/*      */   }
/*      */ 
/*      */   public String getP2() {
/*  232 */     return this.p2;
/*      */   }
/*      */ 
/*      */   public void setP2(String aP2) {
/*  236 */     this.p2 = aP2;
/*      */   }
/*      */ 
/*      */   public String getP3() {
/*  240 */     return this.p3;
/*      */   }
/*      */ 
/*      */   public void setP3(String aP3) {
/*  244 */     this.p3 = aP3;
/*      */   }
/*      */ 
/*      */   public String getP4() {
/*  248 */     return this.p4;
/*      */   }
/*      */ 
/*      */   public void setP4(String aP4) {
/*  252 */     this.p4 = aP4;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPCustImpartSchema aLNPCustImpartSchema)
/*      */   {
/*  258 */     this.impartId = aLNPCustImpartSchema.getImpartId();
/*  259 */     this.proposalType = aLNPCustImpartSchema.getProposalType();
/*  260 */     this.impartName = aLNPCustImpartSchema.getImpartName();
/*  261 */     this.impartVer = aLNPCustImpartSchema.getImpartVer();
/*  262 */     this.impartContent = aLNPCustImpartSchema.getImpartContent();
/*  263 */     this.questionSum = aLNPCustImpartSchema.getQuestionSum();
/*  264 */     this.operator = aLNPCustImpartSchema.getOperator();
/*  265 */     this.manageCom = aLNPCustImpartSchema.getManageCom();
/*  266 */     this.makeTime = aLNPCustImpartSchema.getMakeTime();
/*  267 */     this.makeDate = this.fDate.getDate(aLNPCustImpartSchema.getMakeDate());
/*  268 */     this.modifyDate = this.fDate.getDate(aLNPCustImpartSchema.getModifyDate());
/*  269 */     this.modifyTime = aLNPCustImpartSchema.getModifyTime();
/*  270 */     this.p1 = aLNPCustImpartSchema.getP1();
/*  271 */     this.p2 = aLNPCustImpartSchema.getP2();
/*  272 */     this.p3 = aLNPCustImpartSchema.getP3();
/*  273 */     this.p4 = aLNPCustImpartSchema.getP4();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  282 */       if (rs.getString("ImpartId") == null)
/*  283 */         this.impartId = null;
/*      */       else {
/*  285 */         this.impartId = rs.getString("ImpartId").trim();
/*      */       }
/*  287 */       if (rs.getString("ProposalType") == null)
/*  288 */         this.proposalType = null;
/*      */       else {
/*  290 */         this.proposalType = rs.getString("ProposalType").trim();
/*      */       }
/*  292 */       if (rs.getString("ImpartName") == null)
/*  293 */         this.impartName = null;
/*      */       else {
/*  295 */         this.impartName = rs.getString("ImpartName").trim();
/*      */       }
/*  297 */       if (rs.getString("ImpartVer") == null)
/*  298 */         this.impartVer = null;
/*      */       else {
/*  300 */         this.impartVer = rs.getString("ImpartVer").trim();
/*      */       }
/*  302 */       if (rs.getString("ImpartContent") == null)
/*  303 */         this.impartContent = null;
/*      */       else {
/*  305 */         this.impartContent = rs.getString("ImpartContent").trim();
/*      */       }
/*  307 */       this.questionSum = rs.getInt("QuestionSum");
/*  308 */       if (rs.getString("Operator") == null)
/*  309 */         this.operator = null;
/*      */       else {
/*  311 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  313 */       if (rs.getString("ManageCom") == null)
/*  314 */         this.manageCom = null;
/*      */       else {
/*  316 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  318 */       if (rs.getString("MakeTime") == null)
/*  319 */         this.makeTime = null;
/*      */       else {
/*  321 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  323 */       this.makeDate = rs.getDate("MakeDate");
/*  324 */       this.modifyDate = rs.getDate("ModifyDate");
/*  325 */       if (rs.getString("ModifyTime") == null)
/*  326 */         this.modifyTime = null;
/*      */       else {
/*  328 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  330 */       if (rs.getString("p1") == null)
/*  331 */         this.p1 = null;
/*      */       else {
/*  333 */         this.p1 = rs.getString("p1").trim();
/*      */       }
/*  335 */       if (rs.getString("p2") == null)
/*  336 */         this.p2 = null;
/*      */       else {
/*  338 */         this.p2 = rs.getString("p2").trim();
/*      */       }
/*  340 */       if (rs.getString("p3") == null)
/*  341 */         this.p3 = null;
/*      */       else {
/*  343 */         this.p3 = rs.getString("p3").trim();
/*      */       }
/*  345 */       if (rs.getString("p4") == null)
/*  346 */         this.p4 = null;
/*      */       else {
/*  348 */         this.p4 = rs.getString("p4").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  353 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPCustImpart\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/*  355 */       CError tError = new CError();
/*  356 */       tError.moduleName = "LNPCustImpartSchema";
/*  357 */       tError.functionName = "setSchema";
/*  358 */       tError.errorMessage = sqle.toString();
/*  359 */       this.mErrors.addOneError(tError);
/*  360 */       return false;
/*      */     }
/*  362 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPCustImpartSchema getSchema()
/*      */   {
/*  367 */     LNPCustImpartSchema aLNPCustImpartSchema = new LNPCustImpartSchema();
/*  368 */     aLNPCustImpartSchema.setSchema(this);
/*  369 */     return aLNPCustImpartSchema;
/*      */   }
/*      */ 
/*      */   public LNPCustImpartDB getDB()
/*      */   {
/*  374 */     LNPCustImpartDB aDBOper = new LNPCustImpartDB();
/*  375 */     aDBOper.setSchema(this);
/*  376 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  383 */     StringBuffer strReturn = new StringBuffer(256);
/*  384 */     strReturn.append(StrTool.cTrim(this.impartId)); strReturn.append("|");
/*  385 */     strReturn.append(StrTool.cTrim(this.proposalType)); strReturn.append("|");
/*  386 */     strReturn.append(StrTool.cTrim(this.impartName)); strReturn.append("|");
/*  387 */     strReturn.append(StrTool.cTrim(this.impartVer)); strReturn.append("|");
/*  388 */     strReturn.append(StrTool.cTrim(this.impartContent)); strReturn.append("|");
/*  389 */     strReturn.append(ChgData.chgData(this.questionSum)); strReturn.append("|");
/*  390 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  391 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  392 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  393 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  394 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  395 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  396 */     strReturn.append(StrTool.cTrim(this.p1)); strReturn.append("|");
/*  397 */     strReturn.append(StrTool.cTrim(this.p2)); strReturn.append("|");
/*  398 */     strReturn.append(StrTool.cTrim(this.p3)); strReturn.append("|");
/*  399 */     strReturn.append(StrTool.cTrim(this.p4));
/*  400 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  408 */       this.impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  409 */       this.proposalType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  410 */       this.impartName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  411 */       this.impartVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  412 */       this.impartContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  413 */       this.questionSum = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/*  414 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  415 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  416 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  417 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*  418 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
/*  419 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  420 */       this.p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  421 */       this.p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  422 */       this.p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  423 */       this.p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  428 */       CError tError = new CError();
/*  429 */       tError.moduleName = "LNPCustImpartSchema";
/*  430 */       tError.functionName = "decode";
/*  431 */       tError.errorMessage = ex.toString();
/*  432 */       this.mErrors.addOneError(tError);
/*      */ 
/*  434 */       return false;
/*      */     }
/*  436 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  442 */     String strReturn = "";
/*  443 */     if (FCode.equalsIgnoreCase("impartId"))
/*      */     {
/*  445 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartId));
/*      */     }
/*  447 */     if (FCode.equalsIgnoreCase("proposalType"))
/*      */     {
/*  449 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalType));
/*      */     }
/*  451 */     if (FCode.equalsIgnoreCase("impartName"))
/*      */     {
/*  453 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartName));
/*      */     }
/*  455 */     if (FCode.equalsIgnoreCase("impartVer"))
/*      */     {
/*  457 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartVer));
/*      */     }
/*  459 */     if (FCode.equalsIgnoreCase("impartContent"))
/*      */     {
/*  461 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartContent));
/*      */     }
/*  463 */     if (FCode.equalsIgnoreCase("questionSum"))
/*      */     {
/*  465 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionSum));
/*      */     }
/*  467 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  469 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  471 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  473 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  475 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  477 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  479 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  481 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  483 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  485 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  487 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  489 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  491 */     if (FCode.equalsIgnoreCase("p1"))
/*      */     {
/*  493 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p1));
/*      */     }
/*  495 */     if (FCode.equalsIgnoreCase("p2"))
/*      */     {
/*  497 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p2));
/*      */     }
/*  499 */     if (FCode.equalsIgnoreCase("p3"))
/*      */     {
/*  501 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p3));
/*      */     }
/*  503 */     if (FCode.equalsIgnoreCase("p4"))
/*      */     {
/*  505 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p4));
/*      */     }
/*  507 */     if (strReturn.equals(""))
/*      */     {
/*  509 */       strReturn = "null";
/*      */     }
/*      */ 
/*  512 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  519 */     String strFieldValue = "";
/*  520 */     switch (nFieldIndex) {
/*      */     case 0:
/*  522 */       strFieldValue = StrTool.GBKToUnicode(this.impartId);
/*  523 */       break;
/*      */     case 1:
/*  525 */       strFieldValue = StrTool.GBKToUnicode(this.proposalType);
/*  526 */       break;
/*      */     case 2:
/*  528 */       strFieldValue = StrTool.GBKToUnicode(this.impartName);
/*  529 */       break;
/*      */     case 3:
/*  531 */       strFieldValue = StrTool.GBKToUnicode(this.impartVer);
/*  532 */       break;
/*      */     case 4:
/*  534 */       strFieldValue = StrTool.GBKToUnicode(this.impartContent);
/*  535 */       break;
/*      */     case 5:
/*  537 */       strFieldValue = String.valueOf(this.questionSum);
/*  538 */       break;
/*      */     case 6:
/*  540 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  541 */       break;
/*      */     case 7:
/*  543 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  544 */       break;
/*      */     case 8:
/*  546 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  547 */       break;
/*      */     case 9:
/*  549 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  550 */       break;
/*      */     case 10:
/*  552 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  553 */       break;
/*      */     case 11:
/*  555 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  556 */       break;
/*      */     case 12:
/*  558 */       strFieldValue = StrTool.GBKToUnicode(this.p1);
/*  559 */       break;
/*      */     case 13:
/*  561 */       strFieldValue = StrTool.GBKToUnicode(this.p2);
/*  562 */       break;
/*      */     case 14:
/*  564 */       strFieldValue = StrTool.GBKToUnicode(this.p3);
/*  565 */       break;
/*      */     case 15:
/*  567 */       strFieldValue = StrTool.GBKToUnicode(this.p4);
/*  568 */       break;
/*      */     default:
/*  570 */       strFieldValue = "";
/*      */     }
/*  572 */     if (strFieldValue.equals("")) {
/*  573 */       strFieldValue = "null";
/*      */     }
/*  575 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  581 */     if (StrTool.cTrim(FCode).equals("")) {
/*  582 */       return false;
/*      */     }
/*  584 */     if (FCode.equalsIgnoreCase("impartId"))
/*      */     {
/*  586 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  588 */         this.impartId = FValue.trim();
/*      */       }
/*      */       else
/*  591 */         this.impartId = null;
/*      */     }
/*  593 */     if (FCode.equalsIgnoreCase("proposalType"))
/*      */     {
/*  595 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  597 */         this.proposalType = FValue.trim();
/*      */       }
/*      */       else
/*  600 */         this.proposalType = null;
/*      */     }
/*  602 */     if (FCode.equalsIgnoreCase("impartName"))
/*      */     {
/*  604 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  606 */         this.impartName = FValue.trim();
/*      */       }
/*      */       else
/*  609 */         this.impartName = null;
/*      */     }
/*  611 */     if (FCode.equalsIgnoreCase("impartVer"))
/*      */     {
/*  613 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  615 */         this.impartVer = FValue.trim();
/*      */       }
/*      */       else
/*  618 */         this.impartVer = null;
/*      */     }
/*  620 */     if (FCode.equalsIgnoreCase("impartContent"))
/*      */     {
/*  622 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  624 */         this.impartContent = FValue.trim();
/*      */       }
/*      */       else
/*  627 */         this.impartContent = null;
/*      */     }
/*  629 */     if (FCode.equalsIgnoreCase("questionSum"))
/*      */     {
/*  631 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  633 */         Integer tInteger = new Integer(FValue);
/*  634 */         int i = tInteger.intValue();
/*  635 */         this.questionSum = i;
/*      */       }
/*      */     }
/*  638 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  640 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  642 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  645 */         this.operator = null;
/*      */     }
/*  647 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  649 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  651 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  654 */         this.manageCom = null;
/*      */     }
/*  656 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  658 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  660 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  663 */         this.makeTime = null;
/*      */     }
/*  665 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  667 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  669 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  672 */         this.makeDate = null;
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  676 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  678 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  681 */         this.modifyDate = null;
/*      */     }
/*  683 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  685 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  687 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  690 */         this.modifyTime = null;
/*      */     }
/*  692 */     if (FCode.equalsIgnoreCase("p1"))
/*      */     {
/*  694 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  696 */         this.p1 = FValue.trim();
/*      */       }
/*      */       else
/*  699 */         this.p1 = null;
/*      */     }
/*  701 */     if (FCode.equalsIgnoreCase("p2"))
/*      */     {
/*  703 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  705 */         this.p2 = FValue.trim();
/*      */       }
/*      */       else
/*  708 */         this.p2 = null;
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("p3"))
/*      */     {
/*  712 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  714 */         this.p3 = FValue.trim();
/*      */       }
/*      */       else
/*  717 */         this.p3 = null;
/*      */     }
/*  719 */     if (FCode.equalsIgnoreCase("p4"))
/*      */     {
/*  721 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  723 */         this.p4 = FValue.trim();
/*      */       }
/*      */       else
/*  726 */         this.p4 = null;
/*      */     }
/*  728 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  733 */     if (otherObject == null) return false;
/*  734 */     if (this == otherObject) return true;
/*  735 */     if (getClass() != otherObject.getClass()) return false;
/*  736 */     LNPCustImpartSchema other = (LNPCustImpartSchema)otherObject;
/*  737 */     if ((this.impartId == null) && (other.getImpartId() != null)) return false;
/*  738 */     if ((this.impartId != null) && (!this.impartId.equals(other.getImpartId()))) return false;
/*  739 */     if ((this.proposalType == null) && (other.getProposalType() != null)) return false;
/*  740 */     if ((this.proposalType != null) && (!this.proposalType.equals(other.getProposalType()))) return false;
/*  741 */     if ((this.impartName == null) && (other.getImpartName() != null)) return false;
/*  742 */     if ((this.impartName != null) && (!this.impartName.equals(other.getImpartName()))) return false;
/*  743 */     if ((this.impartVer == null) && (other.getImpartVer() != null)) return false;
/*  744 */     if ((this.impartVer != null) && (!this.impartVer.equals(other.getImpartVer()))) return false;
/*  745 */     if ((this.impartContent == null) && (other.getImpartContent() != null)) return false;
/*  746 */     if ((this.impartContent != null) && (!this.impartContent.equals(other.getImpartContent()))) return false;
/*  747 */     if (this.questionSum != other.getQuestionSum()) return false;
/*  748 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  749 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  750 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/*  751 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/*  752 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  753 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  754 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  755 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  756 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  757 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  758 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  759 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/*  760 */     if ((this.p1 == null) && (other.getP1() != null)) return false;
/*  761 */     if ((this.p1 != null) && (!this.p1.equals(other.getP1()))) return false;
/*  762 */     if ((this.p2 == null) && (other.getP2() != null)) return false;
/*  763 */     if ((this.p2 != null) && (!this.p2.equals(other.getP2()))) return false;
/*  764 */     if ((this.p3 == null) && (other.getP3() != null)) return false;
/*  765 */     if ((this.p3 != null) && (!this.p3.equals(other.getP3()))) return false;
/*  766 */     if ((this.p4 == null) && (other.getP4() != null)) return false;
/*  767 */     return (this.p4 == null) || (this.p4.equals(other.getP4()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  774 */     return 16;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  780 */     if (strFieldName.equals("impartId")) {
/*  781 */       return 0;
/*      */     }
/*  783 */     if (strFieldName.equals("proposalType")) {
/*  784 */       return 1;
/*      */     }
/*  786 */     if (strFieldName.equals("impartName")) {
/*  787 */       return 2;
/*      */     }
/*  789 */     if (strFieldName.equals("impartVer")) {
/*  790 */       return 3;
/*      */     }
/*  792 */     if (strFieldName.equals("impartContent")) {
/*  793 */       return 4;
/*      */     }
/*  795 */     if (strFieldName.equals("questionSum")) {
/*  796 */       return 5;
/*      */     }
/*  798 */     if (strFieldName.equals("operator")) {
/*  799 */       return 6;
/*      */     }
/*  801 */     if (strFieldName.equals("manageCom")) {
/*  802 */       return 7;
/*      */     }
/*  804 */     if (strFieldName.equals("makeTime")) {
/*  805 */       return 8;
/*      */     }
/*  807 */     if (strFieldName.equals("makeDate")) {
/*  808 */       return 9;
/*      */     }
/*  810 */     if (strFieldName.equals("modifyDate")) {
/*  811 */       return 10;
/*      */     }
/*  813 */     if (strFieldName.equals("modifyTime")) {
/*  814 */       return 11;
/*      */     }
/*  816 */     if (strFieldName.equals("p1")) {
/*  817 */       return 12;
/*      */     }
/*  819 */     if (strFieldName.equals("p2")) {
/*  820 */       return 13;
/*      */     }
/*  822 */     if (strFieldName.equals("p3")) {
/*  823 */       return 14;
/*      */     }
/*  825 */     if (strFieldName.equals("p4")) {
/*  826 */       return 15;
/*      */     }
/*  828 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  834 */     String strFieldName = "";
/*  835 */     switch (nFieldIndex) {
/*      */     case 0:
/*  837 */       strFieldName = "impartId";
/*  838 */       break;
/*      */     case 1:
/*  840 */       strFieldName = "proposalType";
/*  841 */       break;
/*      */     case 2:
/*  843 */       strFieldName = "impartName";
/*  844 */       break;
/*      */     case 3:
/*  846 */       strFieldName = "impartVer";
/*  847 */       break;
/*      */     case 4:
/*  849 */       strFieldName = "impartContent";
/*  850 */       break;
/*      */     case 5:
/*  852 */       strFieldName = "questionSum";
/*  853 */       break;
/*      */     case 6:
/*  855 */       strFieldName = "operator";
/*  856 */       break;
/*      */     case 7:
/*  858 */       strFieldName = "manageCom";
/*  859 */       break;
/*      */     case 8:
/*  861 */       strFieldName = "makeTime";
/*  862 */       break;
/*      */     case 9:
/*  864 */       strFieldName = "makeDate";
/*  865 */       break;
/*      */     case 10:
/*  867 */       strFieldName = "modifyDate";
/*  868 */       break;
/*      */     case 11:
/*  870 */       strFieldName = "modifyTime";
/*  871 */       break;
/*      */     case 12:
/*  873 */       strFieldName = "p1";
/*  874 */       break;
/*      */     case 13:
/*  876 */       strFieldName = "p2";
/*  877 */       break;
/*      */     case 14:
/*  879 */       strFieldName = "p3";
/*  880 */       break;
/*      */     case 15:
/*  882 */       strFieldName = "p4";
/*  883 */       break;
/*      */     default:
/*  885 */       strFieldName = "";
/*      */     }
/*  887 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  893 */     if (strFieldName.equals("impartId")) {
/*  894 */       return 0;
/*      */     }
/*  896 */     if (strFieldName.equals("proposalType")) {
/*  897 */       return 0;
/*      */     }
/*  899 */     if (strFieldName.equals("impartName")) {
/*  900 */       return 0;
/*      */     }
/*  902 */     if (strFieldName.equals("impartVer")) {
/*  903 */       return 0;
/*      */     }
/*  905 */     if (strFieldName.equals("impartContent")) {
/*  906 */       return 0;
/*      */     }
/*  908 */     if (strFieldName.equals("questionSum")) {
/*  909 */       return 3;
/*      */     }
/*  911 */     if (strFieldName.equals("operator")) {
/*  912 */       return 0;
/*      */     }
/*  914 */     if (strFieldName.equals("manageCom")) {
/*  915 */       return 0;
/*      */     }
/*  917 */     if (strFieldName.equals("makeTime")) {
/*  918 */       return 0;
/*      */     }
/*  920 */     if (strFieldName.equals("makeDate")) {
/*  921 */       return 1;
/*      */     }
/*  923 */     if (strFieldName.equals("modifyDate")) {
/*  924 */       return 1;
/*      */     }
/*  926 */     if (strFieldName.equals("modifyTime")) {
/*  927 */       return 0;
/*      */     }
/*  929 */     if (strFieldName.equals("p1")) {
/*  930 */       return 0;
/*      */     }
/*  932 */     if (strFieldName.equals("p2")) {
/*  933 */       return 0;
/*      */     }
/*  935 */     if (strFieldName.equals("p3")) {
/*  936 */       return 0;
/*      */     }
/*  938 */     if (strFieldName.equals("p4")) {
/*  939 */       return 0;
/*      */     }
/*  941 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/*  947 */     int nFieldType = -1;
/*  948 */     switch (nFieldIndex) {
/*      */     case 0:
/*  950 */       nFieldType = 0;
/*  951 */       break;
/*      */     case 1:
/*  953 */       nFieldType = 0;
/*  954 */       break;
/*      */     case 2:
/*  956 */       nFieldType = 0;
/*  957 */       break;
/*      */     case 3:
/*  959 */       nFieldType = 0;
/*  960 */       break;
/*      */     case 4:
/*  962 */       nFieldType = 0;
/*  963 */       break;
/*      */     case 5:
/*  965 */       nFieldType = 3;
/*  966 */       break;
/*      */     case 6:
/*  968 */       nFieldType = 0;
/*  969 */       break;
/*      */     case 7:
/*  971 */       nFieldType = 0;
/*  972 */       break;
/*      */     case 8:
/*  974 */       nFieldType = 0;
/*  975 */       break;
/*      */     case 9:
/*  977 */       nFieldType = 1;
/*  978 */       break;
/*      */     case 10:
/*  980 */       nFieldType = 1;
/*  981 */       break;
/*      */     case 11:
/*  983 */       nFieldType = 0;
/*  984 */       break;
/*      */     case 12:
/*  986 */       nFieldType = 0;
/*  987 */       break;
/*      */     case 13:
/*  989 */       nFieldType = 0;
/*  990 */       break;
/*      */     case 14:
/*  992 */       nFieldType = 0;
/*  993 */       break;
/*      */     case 15:
/*  995 */       nFieldType = 0;
/*  996 */       break;
/*      */     default:
/*  998 */       nFieldType = -1;
/*      */     }
/* 1000 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPCustImpartSchema
 * JD-Core Version:    0.6.0
 */