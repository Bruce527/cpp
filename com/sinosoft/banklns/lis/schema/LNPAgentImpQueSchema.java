/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAgentImpQueDB;
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
/*      */ public class LNPAgentImpQueSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String impartId;
/*      */   private String questionid;
/*      */   private String questionType;
/*      */   private String content1;
/*      */   private String content2;
/*      */   private String queOrder;
/*      */   private String innerOrder;
/*      */   private String outQueId;
/*      */   private String innerQueNum;
/*      */   private String parentId;
/*      */   private String childQueNum;
/*      */   private String operator;
/*      */   private String manageCom;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 17;
/*      */   private static String[] PK;
/*   61 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPAgentImpQueSchema()
/*      */   {
/*   68 */     this.mErrors = new CErrors();
/*      */ 
/*   70 */     String[] pk = new String[2];
/*   71 */     pk[0] = "Questionid";
/*   72 */     pk[1] = "InnerOrder";
/*      */ 
/*   74 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   81 */     LNPAgentImpQueSchema cloned = (LNPAgentImpQueSchema)super.clone();
/*   82 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   83 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   84 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   90 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getImpartId()
/*      */   {
/*   95 */     return this.impartId;
/*      */   }
/*      */ 
/*      */   public void setImpartId(String aImpartId) {
/*   99 */     this.impartId = aImpartId;
/*      */   }
/*      */ 
/*      */   public String getQuestionid() {
/*  103 */     return this.questionid;
/*      */   }
/*      */ 
/*      */   public void setQuestionid(String aQuestionid) {
/*  107 */     this.questionid = aQuestionid;
/*      */   }
/*      */ 
/*      */   public String getQuestionType() {
/*  111 */     return this.questionType;
/*      */   }
/*      */ 
/*      */   public void setQuestionType(String aQuestionType) {
/*  115 */     this.questionType = aQuestionType;
/*      */   }
/*      */ 
/*      */   public String getContent1() {
/*  119 */     return this.content1;
/*      */   }
/*      */ 
/*      */   public void setContent1(String aContent1) {
/*  123 */     this.content1 = aContent1;
/*      */   }
/*      */ 
/*      */   public String getContent2() {
/*  127 */     return this.content2;
/*      */   }
/*      */ 
/*      */   public void setContent2(String aContent2) {
/*  131 */     this.content2 = aContent2;
/*      */   }
/*      */ 
/*      */   public String getQueOrder() {
/*  135 */     return this.queOrder;
/*      */   }
/*      */ 
/*      */   public void setQueOrder(String aQueOrder) {
/*  139 */     this.queOrder = aQueOrder;
/*      */   }
/*      */ 
/*      */   public String getInnerOrder() {
/*  143 */     return this.innerOrder;
/*      */   }
/*      */ 
/*      */   public void setInnerOrder(String aInnerOrder) {
/*  147 */     this.innerOrder = aInnerOrder;
/*      */   }
/*      */ 
/*      */   public String getOutQueId() {
/*  151 */     return this.outQueId;
/*      */   }
/*      */ 
/*      */   public void setOutQueId(String aOutQueId) {
/*  155 */     this.outQueId = aOutQueId;
/*      */   }
/*      */ 
/*      */   public String getInnerQueNum() {
/*  159 */     return this.innerQueNum;
/*      */   }
/*      */ 
/*      */   public void setInnerQueNum(String aInnerQueNum) {
/*  163 */     this.innerQueNum = aInnerQueNum;
/*      */   }
/*      */ 
/*      */   public String getParentId() {
/*  167 */     return this.parentId;
/*      */   }
/*      */ 
/*      */   public void setParentId(String aParentId) {
/*  171 */     this.parentId = aParentId;
/*      */   }
/*      */ 
/*      */   public String getChildQueNum() {
/*  175 */     return this.childQueNum;
/*      */   }
/*      */ 
/*      */   public void setChildQueNum(String aChildQueNum) {
/*  179 */     this.childQueNum = aChildQueNum;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  183 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  187 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  191 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  195 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  199 */     if (this.makeDate != null) {
/*  200 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  202 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  206 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  210 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  212 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  215 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  220 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  224 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  228 */     if (this.modifyDate != null) {
/*  229 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  231 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  235 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  239 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  241 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  244 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  249 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  253 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPAgentImpQueSchema aLNPAgentImpQueSchema)
/*      */   {
/*  259 */     this.impartId = aLNPAgentImpQueSchema.getImpartId();
/*  260 */     this.questionid = aLNPAgentImpQueSchema.getQuestionid();
/*  261 */     this.questionType = aLNPAgentImpQueSchema.getQuestionType();
/*  262 */     this.content1 = aLNPAgentImpQueSchema.getContent1();
/*  263 */     this.content2 = aLNPAgentImpQueSchema.getContent2();
/*  264 */     this.queOrder = aLNPAgentImpQueSchema.getQueOrder();
/*  265 */     this.innerOrder = aLNPAgentImpQueSchema.getInnerOrder();
/*  266 */     this.outQueId = aLNPAgentImpQueSchema.getOutQueId();
/*  267 */     this.innerQueNum = aLNPAgentImpQueSchema.getInnerQueNum();
/*  268 */     this.parentId = aLNPAgentImpQueSchema.getParentId();
/*  269 */     this.childQueNum = aLNPAgentImpQueSchema.getChildQueNum();
/*  270 */     this.operator = aLNPAgentImpQueSchema.getOperator();
/*  271 */     this.manageCom = aLNPAgentImpQueSchema.getManageCom();
/*  272 */     this.makeDate = this.fDate.getDate(aLNPAgentImpQueSchema.getMakeDate());
/*  273 */     this.makeTime = aLNPAgentImpQueSchema.getMakeTime();
/*  274 */     this.modifyDate = this.fDate.getDate(aLNPAgentImpQueSchema.getModifyDate());
/*  275 */     this.modifyTime = aLNPAgentImpQueSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  284 */       if (rs.getString("ImpartId") == null)
/*  285 */         this.impartId = null;
/*      */       else {
/*  287 */         this.impartId = rs.getString("ImpartId").trim();
/*      */       }
/*  289 */       if (rs.getString("Questionid") == null)
/*  290 */         this.questionid = null;
/*      */       else {
/*  292 */         this.questionid = rs.getString("Questionid").trim();
/*      */       }
/*  294 */       if (rs.getString("QuestionType") == null)
/*  295 */         this.questionType = null;
/*      */       else {
/*  297 */         this.questionType = rs.getString("QuestionType").trim();
/*      */       }
/*  299 */       if (rs.getString("Content1") == null)
/*  300 */         this.content1 = null;
/*      */       else {
/*  302 */         this.content1 = rs.getString("Content1").trim();
/*      */       }
/*  304 */       if (rs.getString("Content2") == null)
/*  305 */         this.content2 = null;
/*      */       else {
/*  307 */         this.content2 = rs.getString("Content2").trim();
/*      */       }
/*  309 */       if (rs.getString("QueOrder") == null)
/*  310 */         this.queOrder = null;
/*      */       else {
/*  312 */         this.queOrder = rs.getString("QueOrder").trim();
/*      */       }
/*  314 */       if (rs.getString("InnerOrder") == null)
/*  315 */         this.innerOrder = null;
/*      */       else {
/*  317 */         this.innerOrder = rs.getString("InnerOrder").trim();
/*      */       }
/*  319 */       if (rs.getString("OutQueId") == null)
/*  320 */         this.outQueId = null;
/*      */       else {
/*  322 */         this.outQueId = rs.getString("OutQueId").trim();
/*      */       }
/*  324 */       if (rs.getString("InnerQueNum") == null)
/*  325 */         this.innerQueNum = null;
/*      */       else {
/*  327 */         this.innerQueNum = rs.getString("InnerQueNum").trim();
/*      */       }
/*  329 */       if (rs.getString("ParentId") == null)
/*  330 */         this.parentId = null;
/*      */       else {
/*  332 */         this.parentId = rs.getString("ParentId").trim();
/*      */       }
/*  334 */       if (rs.getString("ChildQueNum") == null)
/*  335 */         this.childQueNum = null;
/*      */       else {
/*  337 */         this.childQueNum = rs.getString("ChildQueNum").trim();
/*      */       }
/*  339 */       if (rs.getString("Operator") == null)
/*  340 */         this.operator = null;
/*      */       else {
/*  342 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  344 */       if (rs.getString("ManageCom") == null)
/*  345 */         this.manageCom = null;
/*      */       else {
/*  347 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  349 */       this.makeDate = rs.getDate("MakeDate");
/*  350 */       if (rs.getString("MakeTime") == null)
/*  351 */         this.makeTime = null;
/*      */       else {
/*  353 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  355 */       this.modifyDate = rs.getDate("ModifyDate");
/*  356 */       if (rs.getString("ModifyTime") == null)
/*  357 */         this.modifyTime = null;
/*      */       else {
/*  359 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  364 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPAgentImpQue\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/*  366 */       CError tError = new CError();
/*  367 */       tError.moduleName = "LNPAgentImpQueSchema";
/*  368 */       tError.functionName = "setSchema";
/*  369 */       tError.errorMessage = sqle.toString();
/*  370 */       this.mErrors.addOneError(tError);
/*  371 */       return false;
/*      */     }
/*  373 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpQueSchema getSchema()
/*      */   {
/*  378 */     LNPAgentImpQueSchema aLNPAgentImpQueSchema = new LNPAgentImpQueSchema();
/*  379 */     aLNPAgentImpQueSchema.setSchema(this);
/*  380 */     return aLNPAgentImpQueSchema;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpQueDB getDB()
/*      */   {
/*  385 */     LNPAgentImpQueDB aDBOper = new LNPAgentImpQueDB();
/*  386 */     aDBOper.setSchema(this);
/*  387 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  394 */     StringBuffer strReturn = new StringBuffer(256);
/*  395 */     strReturn.append(StrTool.cTrim(this.impartId)); strReturn.append("|");
/*  396 */     strReturn.append(StrTool.cTrim(this.questionid)); strReturn.append("|");
/*  397 */     strReturn.append(StrTool.cTrim(this.questionType)); strReturn.append("|");
/*  398 */     strReturn.append(StrTool.cTrim(this.content1)); strReturn.append("|");
/*  399 */     strReturn.append(StrTool.cTrim(this.content2)); strReturn.append("|");
/*  400 */     strReturn.append(StrTool.cTrim(this.queOrder)); strReturn.append("|");
/*  401 */     strReturn.append(StrTool.cTrim(this.innerOrder)); strReturn.append("|");
/*  402 */     strReturn.append(StrTool.cTrim(this.outQueId)); strReturn.append("|");
/*  403 */     strReturn.append(StrTool.cTrim(this.innerQueNum)); strReturn.append("|");
/*  404 */     strReturn.append(StrTool.cTrim(this.parentId)); strReturn.append("|");
/*  405 */     strReturn.append(StrTool.cTrim(this.childQueNum)); strReturn.append("|");
/*  406 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  407 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  408 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  409 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  410 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  411 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  412 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  420 */       this.impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  421 */       this.questionid = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  422 */       this.questionType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  423 */       this.content1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  424 */       this.content2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  425 */       this.queOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  426 */       this.innerOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  427 */       this.outQueId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  428 */       this.innerQueNum = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  429 */       this.parentId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  430 */       this.childQueNum = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  431 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  432 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  433 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/*  434 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  435 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  436 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  441 */       CError tError = new CError();
/*  442 */       tError.moduleName = "LNPAgentImpQueSchema";
/*  443 */       tError.functionName = "decode";
/*  444 */       tError.errorMessage = ex.toString();
/*  445 */       this.mErrors.addOneError(tError);
/*      */ 
/*  447 */       return false;
/*      */     }
/*  449 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  455 */     String strReturn = "";
/*  456 */     if (FCode.equalsIgnoreCase("impartId"))
/*      */     {
/*  458 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartId));
/*      */     }
/*  460 */     if (FCode.equalsIgnoreCase("questionid"))
/*      */     {
/*  462 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionid));
/*      */     }
/*  464 */     if (FCode.equalsIgnoreCase("questionType"))
/*      */     {
/*  466 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionType));
/*      */     }
/*  468 */     if (FCode.equalsIgnoreCase("content1"))
/*      */     {
/*  470 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.content1));
/*      */     }
/*  472 */     if (FCode.equalsIgnoreCase("content2"))
/*      */     {
/*  474 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.content2));
/*      */     }
/*  476 */     if (FCode.equalsIgnoreCase("queOrder"))
/*      */     {
/*  478 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.queOrder));
/*      */     }
/*  480 */     if (FCode.equalsIgnoreCase("innerOrder"))
/*      */     {
/*  482 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.innerOrder));
/*      */     }
/*  484 */     if (FCode.equalsIgnoreCase("outQueId"))
/*      */     {
/*  486 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.outQueId));
/*      */     }
/*  488 */     if (FCode.equalsIgnoreCase("innerQueNum"))
/*      */     {
/*  490 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.innerQueNum));
/*      */     }
/*  492 */     if (FCode.equalsIgnoreCase("parentId"))
/*      */     {
/*  494 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.parentId));
/*      */     }
/*  496 */     if (FCode.equalsIgnoreCase("childQueNum"))
/*      */     {
/*  498 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.childQueNum));
/*      */     }
/*  500 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  502 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  504 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  506 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  508 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  510 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  512 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  514 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  516 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  518 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  520 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  522 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  524 */     if (strReturn.equals(""))
/*      */     {
/*  526 */       strReturn = "null";
/*      */     }
/*      */ 
/*  529 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  536 */     String strFieldValue = "";
/*  537 */     switch (nFieldIndex) {
/*      */     case 0:
/*  539 */       strFieldValue = StrTool.GBKToUnicode(this.impartId);
/*  540 */       break;
/*      */     case 1:
/*  542 */       strFieldValue = StrTool.GBKToUnicode(this.questionid);
/*  543 */       break;
/*      */     case 2:
/*  545 */       strFieldValue = StrTool.GBKToUnicode(this.questionType);
/*  546 */       break;
/*      */     case 3:
/*  548 */       strFieldValue = StrTool.GBKToUnicode(this.content1);
/*  549 */       break;
/*      */     case 4:
/*  551 */       strFieldValue = StrTool.GBKToUnicode(this.content2);
/*  552 */       break;
/*      */     case 5:
/*  554 */       strFieldValue = StrTool.GBKToUnicode(this.queOrder);
/*  555 */       break;
/*      */     case 6:
/*  557 */       strFieldValue = StrTool.GBKToUnicode(this.innerOrder);
/*  558 */       break;
/*      */     case 7:
/*  560 */       strFieldValue = StrTool.GBKToUnicode(this.outQueId);
/*  561 */       break;
/*      */     case 8:
/*  563 */       strFieldValue = StrTool.GBKToUnicode(this.innerQueNum);
/*  564 */       break;
/*      */     case 9:
/*  566 */       strFieldValue = StrTool.GBKToUnicode(this.parentId);
/*  567 */       break;
/*      */     case 10:
/*  569 */       strFieldValue = StrTool.GBKToUnicode(this.childQueNum);
/*  570 */       break;
/*      */     case 11:
/*  572 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  573 */       break;
/*      */     case 12:
/*  575 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  576 */       break;
/*      */     case 13:
/*  578 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  579 */       break;
/*      */     case 14:
/*  581 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  582 */       break;
/*      */     case 15:
/*  584 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  585 */       break;
/*      */     case 16:
/*  587 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  588 */       break;
/*      */     default:
/*  590 */       strFieldValue = "";
/*      */     }
/*  592 */     if (strFieldValue.equals("")) {
/*  593 */       strFieldValue = "null";
/*      */     }
/*  595 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  601 */     if (StrTool.cTrim(FCode).equals("")) {
/*  602 */       return false;
/*      */     }
/*  604 */     if (FCode.equalsIgnoreCase("impartId"))
/*      */     {
/*  606 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  608 */         this.impartId = FValue.trim();
/*      */       }
/*      */       else
/*  611 */         this.impartId = null;
/*      */     }
/*  613 */     if (FCode.equalsIgnoreCase("questionid"))
/*      */     {
/*  615 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  617 */         this.questionid = FValue.trim();
/*      */       }
/*      */       else
/*  620 */         this.questionid = null;
/*      */     }
/*  622 */     if (FCode.equalsIgnoreCase("questionType"))
/*      */     {
/*  624 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  626 */         this.questionType = FValue.trim();
/*      */       }
/*      */       else
/*  629 */         this.questionType = null;
/*      */     }
/*  631 */     if (FCode.equalsIgnoreCase("content1"))
/*      */     {
/*  633 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  635 */         this.content1 = FValue.trim();
/*      */       }
/*      */       else
/*  638 */         this.content1 = null;
/*      */     }
/*  640 */     if (FCode.equalsIgnoreCase("content2"))
/*      */     {
/*  642 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  644 */         this.content2 = FValue.trim();
/*      */       }
/*      */       else
/*  647 */         this.content2 = null;
/*      */     }
/*  649 */     if (FCode.equalsIgnoreCase("queOrder"))
/*      */     {
/*  651 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  653 */         this.queOrder = FValue.trim();
/*      */       }
/*      */       else
/*  656 */         this.queOrder = null;
/*      */     }
/*  658 */     if (FCode.equalsIgnoreCase("innerOrder"))
/*      */     {
/*  660 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  662 */         this.innerOrder = FValue.trim();
/*      */       }
/*      */       else
/*  665 */         this.innerOrder = null;
/*      */     }
/*  667 */     if (FCode.equalsIgnoreCase("outQueId"))
/*      */     {
/*  669 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  671 */         this.outQueId = FValue.trim();
/*      */       }
/*      */       else
/*  674 */         this.outQueId = null;
/*      */     }
/*  676 */     if (FCode.equalsIgnoreCase("innerQueNum"))
/*      */     {
/*  678 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  680 */         this.innerQueNum = FValue.trim();
/*      */       }
/*      */       else
/*  683 */         this.innerQueNum = null;
/*      */     }
/*  685 */     if (FCode.equalsIgnoreCase("parentId"))
/*      */     {
/*  687 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  689 */         this.parentId = FValue.trim();
/*      */       }
/*      */       else
/*  692 */         this.parentId = null;
/*      */     }
/*  694 */     if (FCode.equalsIgnoreCase("childQueNum"))
/*      */     {
/*  696 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  698 */         this.childQueNum = FValue.trim();
/*      */       }
/*      */       else
/*  701 */         this.childQueNum = null;
/*      */     }
/*  703 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  705 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  707 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  710 */         this.operator = null;
/*      */     }
/*  712 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  714 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  716 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  719 */         this.manageCom = null;
/*      */     }
/*  721 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  723 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  725 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  728 */         this.makeDate = null;
/*      */     }
/*  730 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  732 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  734 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  737 */         this.makeTime = null;
/*      */     }
/*  739 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  741 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  743 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  746 */         this.modifyDate = null;
/*      */     }
/*  748 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  750 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  752 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  755 */         this.modifyTime = null;
/*      */     }
/*  757 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  762 */     if (otherObject == null) return false;
/*  763 */     if (this == otherObject) return true;
/*  764 */     if (getClass() != otherObject.getClass()) return false;
/*  765 */     LNPAgentImpQueSchema other = (LNPAgentImpQueSchema)otherObject;
/*  766 */     if ((this.impartId == null) && (other.getImpartId() != null)) return false;
/*  767 */     if ((this.impartId != null) && (!this.impartId.equals(other.getImpartId()))) return false;
/*  768 */     if ((this.questionid == null) && (other.getQuestionid() != null)) return false;
/*  769 */     if ((this.questionid != null) && (!this.questionid.equals(other.getQuestionid()))) return false;
/*  770 */     if ((this.questionType == null) && (other.getQuestionType() != null)) return false;
/*  771 */     if ((this.questionType != null) && (!this.questionType.equals(other.getQuestionType()))) return false;
/*  772 */     if ((this.content1 == null) && (other.getContent1() != null)) return false;
/*  773 */     if ((this.content1 != null) && (!this.content1.equals(other.getContent1()))) return false;
/*  774 */     if ((this.content2 == null) && (other.getContent2() != null)) return false;
/*  775 */     if ((this.content2 != null) && (!this.content2.equals(other.getContent2()))) return false;
/*  776 */     if ((this.queOrder == null) && (other.getQueOrder() != null)) return false;
/*  777 */     if ((this.queOrder != null) && (!this.queOrder.equals(other.getQueOrder()))) return false;
/*  778 */     if ((this.innerOrder == null) && (other.getInnerOrder() != null)) return false;
/*  779 */     if ((this.innerOrder != null) && (!this.innerOrder.equals(other.getInnerOrder()))) return false;
/*  780 */     if ((this.outQueId == null) && (other.getOutQueId() != null)) return false;
/*  781 */     if ((this.outQueId != null) && (!this.outQueId.equals(other.getOutQueId()))) return false;
/*  782 */     if ((this.innerQueNum == null) && (other.getInnerQueNum() != null)) return false;
/*  783 */     if ((this.innerQueNum != null) && (!this.innerQueNum.equals(other.getInnerQueNum()))) return false;
/*  784 */     if ((this.parentId == null) && (other.getParentId() != null)) return false;
/*  785 */     if ((this.parentId != null) && (!this.parentId.equals(other.getParentId()))) return false;
/*  786 */     if ((this.childQueNum == null) && (other.getChildQueNum() != null)) return false;
/*  787 */     if ((this.childQueNum != null) && (!this.childQueNum.equals(other.getChildQueNum()))) return false;
/*  788 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  789 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  790 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/*  791 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/*  792 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  793 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  794 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  795 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  796 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  797 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  798 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  799 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  806 */     return 17;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  812 */     if (strFieldName.equals("impartId")) {
/*  813 */       return 0;
/*      */     }
/*  815 */     if (strFieldName.equals("questionid")) {
/*  816 */       return 1;
/*      */     }
/*  818 */     if (strFieldName.equals("questionType")) {
/*  819 */       return 2;
/*      */     }
/*  821 */     if (strFieldName.equals("content1")) {
/*  822 */       return 3;
/*      */     }
/*  824 */     if (strFieldName.equals("content2")) {
/*  825 */       return 4;
/*      */     }
/*  827 */     if (strFieldName.equals("queOrder")) {
/*  828 */       return 5;
/*      */     }
/*  830 */     if (strFieldName.equals("innerOrder")) {
/*  831 */       return 6;
/*      */     }
/*  833 */     if (strFieldName.equals("outQueId")) {
/*  834 */       return 7;
/*      */     }
/*  836 */     if (strFieldName.equals("innerQueNum")) {
/*  837 */       return 8;
/*      */     }
/*  839 */     if (strFieldName.equals("parentId")) {
/*  840 */       return 9;
/*      */     }
/*  842 */     if (strFieldName.equals("childQueNum")) {
/*  843 */       return 10;
/*      */     }
/*  845 */     if (strFieldName.equals("operator")) {
/*  846 */       return 11;
/*      */     }
/*  848 */     if (strFieldName.equals("manageCom")) {
/*  849 */       return 12;
/*      */     }
/*  851 */     if (strFieldName.equals("makeDate")) {
/*  852 */       return 13;
/*      */     }
/*  854 */     if (strFieldName.equals("makeTime")) {
/*  855 */       return 14;
/*      */     }
/*  857 */     if (strFieldName.equals("modifyDate")) {
/*  858 */       return 15;
/*      */     }
/*  860 */     if (strFieldName.equals("modifyTime")) {
/*  861 */       return 16;
/*      */     }
/*  863 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  869 */     String strFieldName = "";
/*  870 */     switch (nFieldIndex) {
/*      */     case 0:
/*  872 */       strFieldName = "impartId";
/*  873 */       break;
/*      */     case 1:
/*  875 */       strFieldName = "questionid";
/*  876 */       break;
/*      */     case 2:
/*  878 */       strFieldName = "questionType";
/*  879 */       break;
/*      */     case 3:
/*  881 */       strFieldName = "content1";
/*  882 */       break;
/*      */     case 4:
/*  884 */       strFieldName = "content2";
/*  885 */       break;
/*      */     case 5:
/*  887 */       strFieldName = "queOrder";
/*  888 */       break;
/*      */     case 6:
/*  890 */       strFieldName = "innerOrder";
/*  891 */       break;
/*      */     case 7:
/*  893 */       strFieldName = "outQueId";
/*  894 */       break;
/*      */     case 8:
/*  896 */       strFieldName = "innerQueNum";
/*  897 */       break;
/*      */     case 9:
/*  899 */       strFieldName = "parentId";
/*  900 */       break;
/*      */     case 10:
/*  902 */       strFieldName = "childQueNum";
/*  903 */       break;
/*      */     case 11:
/*  905 */       strFieldName = "operator";
/*  906 */       break;
/*      */     case 12:
/*  908 */       strFieldName = "manageCom";
/*  909 */       break;
/*      */     case 13:
/*  911 */       strFieldName = "makeDate";
/*  912 */       break;
/*      */     case 14:
/*  914 */       strFieldName = "makeTime";
/*  915 */       break;
/*      */     case 15:
/*  917 */       strFieldName = "modifyDate";
/*  918 */       break;
/*      */     case 16:
/*  920 */       strFieldName = "modifyTime";
/*  921 */       break;
/*      */     default:
/*  923 */       strFieldName = "";
/*      */     }
/*  925 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  931 */     if (strFieldName.equals("impartId")) {
/*  932 */       return 0;
/*      */     }
/*  934 */     if (strFieldName.equals("questionid")) {
/*  935 */       return 0;
/*      */     }
/*  937 */     if (strFieldName.equals("questionType")) {
/*  938 */       return 0;
/*      */     }
/*  940 */     if (strFieldName.equals("content1")) {
/*  941 */       return 0;
/*      */     }
/*  943 */     if (strFieldName.equals("content2")) {
/*  944 */       return 0;
/*      */     }
/*  946 */     if (strFieldName.equals("queOrder")) {
/*  947 */       return 0;
/*      */     }
/*  949 */     if (strFieldName.equals("innerOrder")) {
/*  950 */       return 0;
/*      */     }
/*  952 */     if (strFieldName.equals("outQueId")) {
/*  953 */       return 0;
/*      */     }
/*  955 */     if (strFieldName.equals("innerQueNum")) {
/*  956 */       return 0;
/*      */     }
/*  958 */     if (strFieldName.equals("parentId")) {
/*  959 */       return 0;
/*      */     }
/*  961 */     if (strFieldName.equals("childQueNum")) {
/*  962 */       return 0;
/*      */     }
/*  964 */     if (strFieldName.equals("operator")) {
/*  965 */       return 0;
/*      */     }
/*  967 */     if (strFieldName.equals("manageCom")) {
/*  968 */       return 0;
/*      */     }
/*  970 */     if (strFieldName.equals("makeDate")) {
/*  971 */       return 1;
/*      */     }
/*  973 */     if (strFieldName.equals("makeTime")) {
/*  974 */       return 0;
/*      */     }
/*  976 */     if (strFieldName.equals("modifyDate")) {
/*  977 */       return 1;
/*      */     }
/*  979 */     if (strFieldName.equals("modifyTime")) {
/*  980 */       return 0;
/*      */     }
/*  982 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/*  988 */     int nFieldType = -1;
/*  989 */     switch (nFieldIndex) {
/*      */     case 0:
/*  991 */       nFieldType = 0;
/*  992 */       break;
/*      */     case 1:
/*  994 */       nFieldType = 0;
/*  995 */       break;
/*      */     case 2:
/*  997 */       nFieldType = 0;
/*  998 */       break;
/*      */     case 3:
/* 1000 */       nFieldType = 0;
/* 1001 */       break;
/*      */     case 4:
/* 1003 */       nFieldType = 0;
/* 1004 */       break;
/*      */     case 5:
/* 1006 */       nFieldType = 0;
/* 1007 */       break;
/*      */     case 6:
/* 1009 */       nFieldType = 0;
/* 1010 */       break;
/*      */     case 7:
/* 1012 */       nFieldType = 0;
/* 1013 */       break;
/*      */     case 8:
/* 1015 */       nFieldType = 0;
/* 1016 */       break;
/*      */     case 9:
/* 1018 */       nFieldType = 0;
/* 1019 */       break;
/*      */     case 10:
/* 1021 */       nFieldType = 0;
/* 1022 */       break;
/*      */     case 11:
/* 1024 */       nFieldType = 0;
/* 1025 */       break;
/*      */     case 12:
/* 1027 */       nFieldType = 0;
/* 1028 */       break;
/*      */     case 13:
/* 1030 */       nFieldType = 1;
/* 1031 */       break;
/*      */     case 14:
/* 1033 */       nFieldType = 0;
/* 1034 */       break;
/*      */     case 15:
/* 1036 */       nFieldType = 1;
/* 1037 */       break;
/*      */     case 16:
/* 1039 */       nFieldType = 0;
/* 1040 */       break;
/*      */     default:
/* 1042 */       nFieldType = -1;
/*      */     }
/* 1044 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPAgentImpQueSchema
 * JD-Core Version:    0.6.0
 */