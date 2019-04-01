/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPBonusInfoDB;
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
/*      */ public class LNPBonusInfoSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String prtNo;
/*      */   private String bonusType;
/*      */   private String bonusWay;
/*      */   private String autoRepaid;
/*      */   private String cutPayAll;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String p2;
/*      */   private String p4;
/*      */   private String p3;
/*      */   private String p1;
/*      */   public static final int FIELDNUM = 17;
/*      */   private static String[] PK;
/*   61 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPBonusInfoSchema()
/*      */   {
/*   68 */     this.mErrors = new CErrors();
/*      */ 
/*   70 */     String[] pk = new String[1];
/*   71 */     pk[0] = "ContNo";
/*      */ 
/*   73 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   80 */     LNPBonusInfoSchema cloned = (LNPBonusInfoSchema)super.clone();
/*   81 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   82 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   83 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   89 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo()
/*      */   {
/*   94 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*   98 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  102 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  106 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  110 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  114 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public String getPrtNo() {
/*  118 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setPrtNo(String aPrtNo) {
/*  122 */     this.prtNo = aPrtNo;
/*      */   }
/*      */ 
/*      */   public String getBonusType() {
/*  126 */     return this.bonusType;
/*      */   }
/*      */ 
/*      */   public void setBonusType(String aBonusType) {
/*  130 */     this.bonusType = aBonusType;
/*      */   }
/*      */ 
/*      */   public String getBonusWay() {
/*  134 */     return this.bonusWay;
/*      */   }
/*      */ 
/*      */   public void setBonusWay(String aBonusWay) {
/*  138 */     this.bonusWay = aBonusWay;
/*      */   }
/*      */ 
/*      */   public String getAutoRepaid() {
/*  142 */     return this.autoRepaid;
/*      */   }
/*      */ 
/*      */   public void setAutoRepaid(String aAutoRepaid) {
/*  146 */     this.autoRepaid = aAutoRepaid;
/*      */   }
/*      */ 
/*      */   public String getCutPayAll() {
/*  150 */     return this.cutPayAll;
/*      */   }
/*      */ 
/*      */   public void setCutPayAll(String aCutPayAll) {
/*  154 */     this.cutPayAll = aCutPayAll;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  158 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  162 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  166 */     if (this.makeDate != null) {
/*  167 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  169 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  173 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  177 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  179 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  182 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  187 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  191 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
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
/*      */   public String getP2() {
/*  224 */     return this.p2;
/*      */   }
/*      */ 
/*      */   public void setP2(String aP2) {
/*  228 */     this.p2 = aP2;
/*      */   }
/*      */ 
/*      */   public String getP4() {
/*  232 */     return this.p4;
/*      */   }
/*      */ 
/*      */   public void setP4(String aP4) {
/*  236 */     this.p4 = aP4;
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
/*      */   public String getP1() {
/*  248 */     return this.p1;
/*      */   }
/*      */ 
/*      */   public void setP1(String aP1) {
/*  252 */     this.p1 = aP1;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPBonusInfoSchema aLNPBonusInfoSchema)
/*      */   {
/*  258 */     this.grpContNo = aLNPBonusInfoSchema.getGrpContNo();
/*  259 */     this.contNo = aLNPBonusInfoSchema.getContNo();
/*  260 */     this.proposalContNo = aLNPBonusInfoSchema.getProposalContNo();
/*  261 */     this.prtNo = aLNPBonusInfoSchema.getPrtNo();
/*  262 */     this.bonusType = aLNPBonusInfoSchema.getBonusType();
/*  263 */     this.bonusWay = aLNPBonusInfoSchema.getBonusWay();
/*  264 */     this.autoRepaid = aLNPBonusInfoSchema.getAutoRepaid();
/*  265 */     this.cutPayAll = aLNPBonusInfoSchema.getCutPayAll();
/*  266 */     this.operator = aLNPBonusInfoSchema.getOperator();
/*  267 */     this.makeDate = this.fDate.getDate(aLNPBonusInfoSchema.getMakeDate());
/*  268 */     this.makeTime = aLNPBonusInfoSchema.getMakeTime();
/*  269 */     this.modifyDate = this.fDate.getDate(aLNPBonusInfoSchema.getModifyDate());
/*  270 */     this.modifyTime = aLNPBonusInfoSchema.getModifyTime();
/*  271 */     this.p2 = aLNPBonusInfoSchema.getP2();
/*  272 */     this.p4 = aLNPBonusInfoSchema.getP4();
/*  273 */     this.p3 = aLNPBonusInfoSchema.getP3();
/*  274 */     this.p1 = aLNPBonusInfoSchema.getP1();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  283 */       if (rs.getString("GrpContNo") == null)
/*  284 */         this.grpContNo = null;
/*      */       else {
/*  286 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  288 */       if (rs.getString("ContNo") == null)
/*  289 */         this.contNo = null;
/*      */       else {
/*  291 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  293 */       if (rs.getString("ProposalContNo") == null)
/*  294 */         this.proposalContNo = null;
/*      */       else {
/*  296 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  298 */       if (rs.getString("PrtNo") == null)
/*  299 */         this.prtNo = null;
/*      */       else {
/*  301 */         this.prtNo = rs.getString("PrtNo").trim();
/*      */       }
/*  303 */       if (rs.getString("BonusType") == null)
/*  304 */         this.bonusType = null;
/*      */       else {
/*  306 */         this.bonusType = rs.getString("BonusType").trim();
/*      */       }
/*  308 */       if (rs.getString("BonusWay") == null)
/*  309 */         this.bonusWay = null;
/*      */       else {
/*  311 */         this.bonusWay = rs.getString("BonusWay").trim();
/*      */       }
/*  313 */       if (rs.getString("AutoRepaid") == null)
/*  314 */         this.autoRepaid = null;
/*      */       else {
/*  316 */         this.autoRepaid = rs.getString("AutoRepaid").trim();
/*      */       }
/*  318 */       if (rs.getString("cutPayAll") == null)
/*  319 */         this.cutPayAll = null;
/*      */       else {
/*  321 */         this.cutPayAll = rs.getString("cutPayAll").trim();
/*      */       }
/*  323 */       if (rs.getString("Operator") == null)
/*  324 */         this.operator = null;
/*      */       else {
/*  326 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  328 */       this.makeDate = rs.getDate("MakeDate");
/*  329 */       if (rs.getString("MakeTime") == null)
/*  330 */         this.makeTime = null;
/*      */       else {
/*  332 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  334 */       this.modifyDate = rs.getDate("ModifyDate");
/*  335 */       if (rs.getString("ModifyTime") == null)
/*  336 */         this.modifyTime = null;
/*      */       else {
/*  338 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  340 */       if (rs.getString("p2") == null)
/*  341 */         this.p2 = null;
/*      */       else {
/*  343 */         this.p2 = rs.getString("p2").trim();
/*      */       }
/*  345 */       if (rs.getString("p4") == null)
/*  346 */         this.p4 = null;
/*      */       else {
/*  348 */         this.p4 = rs.getString("p4").trim();
/*      */       }
/*  350 */       if (rs.getString("p3") == null)
/*  351 */         this.p3 = null;
/*      */       else {
/*  353 */         this.p3 = rs.getString("p3").trim();
/*      */       }
/*  355 */       if (rs.getString("p1") == null)
/*  356 */         this.p1 = null;
/*      */       else {
/*  358 */         this.p1 = rs.getString("p1").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  363 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPBonusInfo\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/*  365 */       CError tError = new CError();
/*  366 */       tError.moduleName = "LNPBonusInfoSchema";
/*  367 */       tError.functionName = "setSchema";
/*  368 */       tError.errorMessage = sqle.toString();
/*  369 */       this.mErrors.addOneError(tError);
/*  370 */       return false;
/*      */     }
/*  372 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPBonusInfoSchema getSchema()
/*      */   {
/*  377 */     LNPBonusInfoSchema aLNPBonusInfoSchema = new LNPBonusInfoSchema();
/*  378 */     aLNPBonusInfoSchema.setSchema(this);
/*  379 */     return aLNPBonusInfoSchema;
/*      */   }
/*      */ 
/*      */   public LNPBonusInfoDB getDB()
/*      */   {
/*  384 */     LNPBonusInfoDB aDBOper = new LNPBonusInfoDB();
/*  385 */     aDBOper.setSchema(this);
/*  386 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  393 */     StringBuffer strReturn = new StringBuffer(256);
/*  394 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/*  395 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/*  396 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/*  397 */     strReturn.append(StrTool.cTrim(this.prtNo)); strReturn.append("|");
/*  398 */     strReturn.append(StrTool.cTrim(this.bonusType)); strReturn.append("|");
/*  399 */     strReturn.append(StrTool.cTrim(this.bonusWay)); strReturn.append("|");
/*  400 */     strReturn.append(StrTool.cTrim(this.autoRepaid)); strReturn.append("|");
/*  401 */     strReturn.append(StrTool.cTrim(this.cutPayAll)); strReturn.append("|");
/*  402 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  403 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  404 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  405 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  406 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  407 */     strReturn.append(StrTool.cTrim(this.p2)); strReturn.append("|");
/*  408 */     strReturn.append(StrTool.cTrim(this.p4)); strReturn.append("|");
/*  409 */     strReturn.append(StrTool.cTrim(this.p3)); strReturn.append("|");
/*  410 */     strReturn.append(StrTool.cTrim(this.p1));
/*  411 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  419 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  420 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  421 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  422 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  423 */       this.bonusType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  424 */       this.bonusWay = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  425 */       this.autoRepaid = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  426 */       this.cutPayAll = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  427 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  428 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*  429 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  430 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
/*  431 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  432 */       this.p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  433 */       this.p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  434 */       this.p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  435 */       this.p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  440 */       CError tError = new CError();
/*  441 */       tError.moduleName = "LNPBonusInfoSchema";
/*  442 */       tError.functionName = "decode";
/*  443 */       tError.errorMessage = ex.toString();
/*  444 */       this.mErrors.addOneError(tError);
/*      */ 
/*  446 */       return false;
/*      */     }
/*  448 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  454 */     String strReturn = "";
/*  455 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  457 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  459 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  461 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  463 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  465 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  467 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/*  469 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/*  471 */     if (FCode.equalsIgnoreCase("bonusType"))
/*      */     {
/*  473 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bonusType));
/*      */     }
/*  475 */     if (FCode.equalsIgnoreCase("bonusWay"))
/*      */     {
/*  477 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bonusWay));
/*      */     }
/*  479 */     if (FCode.equalsIgnoreCase("autoRepaid"))
/*      */     {
/*  481 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.autoRepaid));
/*      */     }
/*  483 */     if (FCode.equalsIgnoreCase("cutPayAll"))
/*      */     {
/*  485 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.cutPayAll));
/*      */     }
/*  487 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  489 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  491 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  493 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  495 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  497 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  499 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  501 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  503 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  505 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  507 */     if (FCode.equalsIgnoreCase("p2"))
/*      */     {
/*  509 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p2));
/*      */     }
/*  511 */     if (FCode.equalsIgnoreCase("p4"))
/*      */     {
/*  513 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p4));
/*      */     }
/*  515 */     if (FCode.equalsIgnoreCase("p3"))
/*      */     {
/*  517 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p3));
/*      */     }
/*  519 */     if (FCode.equalsIgnoreCase("p1"))
/*      */     {
/*  521 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p1));
/*      */     }
/*  523 */     if (strReturn.equals(""))
/*      */     {
/*  525 */       strReturn = "null";
/*      */     }
/*      */ 
/*  528 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  535 */     String strFieldValue = "";
/*  536 */     switch (nFieldIndex) {
/*      */     case 0:
/*  538 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  539 */       break;
/*      */     case 1:
/*  541 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  542 */       break;
/*      */     case 2:
/*  544 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  545 */       break;
/*      */     case 3:
/*  547 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/*  548 */       break;
/*      */     case 4:
/*  550 */       strFieldValue = StrTool.GBKToUnicode(this.bonusType);
/*  551 */       break;
/*      */     case 5:
/*  553 */       strFieldValue = StrTool.GBKToUnicode(this.bonusWay);
/*  554 */       break;
/*      */     case 6:
/*  556 */       strFieldValue = StrTool.GBKToUnicode(this.autoRepaid);
/*  557 */       break;
/*      */     case 7:
/*  559 */       strFieldValue = StrTool.GBKToUnicode(this.cutPayAll);
/*  560 */       break;
/*      */     case 8:
/*  562 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  563 */       break;
/*      */     case 9:
/*  565 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  566 */       break;
/*      */     case 10:
/*  568 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  569 */       break;
/*      */     case 11:
/*  571 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  572 */       break;
/*      */     case 12:
/*  574 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  575 */       break;
/*      */     case 13:
/*  577 */       strFieldValue = StrTool.GBKToUnicode(this.p2);
/*  578 */       break;
/*      */     case 14:
/*  580 */       strFieldValue = StrTool.GBKToUnicode(this.p4);
/*  581 */       break;
/*      */     case 15:
/*  583 */       strFieldValue = StrTool.GBKToUnicode(this.p3);
/*  584 */       break;
/*      */     case 16:
/*  586 */       strFieldValue = StrTool.GBKToUnicode(this.p1);
/*  587 */       break;
/*      */     default:
/*  589 */       strFieldValue = "";
/*      */     }
/*  591 */     if (strFieldValue.equals("")) {
/*  592 */       strFieldValue = "null";
/*      */     }
/*  594 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  600 */     if (StrTool.cTrim(FCode).equals("")) {
/*  601 */       return false;
/*      */     }
/*  603 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  605 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  607 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/*  610 */         this.grpContNo = null;
/*      */     }
/*  612 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  614 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  616 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/*  619 */         this.contNo = null;
/*      */     }
/*  621 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  623 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  625 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/*  628 */         this.proposalContNo = null;
/*      */     }
/*  630 */     if (FCode.equalsIgnoreCase("prtNo"))
/*      */     {
/*  632 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  634 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/*  637 */         this.prtNo = null;
/*      */     }
/*  639 */     if (FCode.equalsIgnoreCase("bonusType"))
/*      */     {
/*  641 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  643 */         this.bonusType = FValue.trim();
/*      */       }
/*      */       else
/*  646 */         this.bonusType = null;
/*      */     }
/*  648 */     if (FCode.equalsIgnoreCase("bonusWay"))
/*      */     {
/*  650 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  652 */         this.bonusWay = FValue.trim();
/*      */       }
/*      */       else
/*  655 */         this.bonusWay = null;
/*      */     }
/*  657 */     if (FCode.equalsIgnoreCase("autoRepaid"))
/*      */     {
/*  659 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  661 */         this.autoRepaid = FValue.trim();
/*      */       }
/*      */       else
/*  664 */         this.autoRepaid = null;
/*      */     }
/*  666 */     if (FCode.equalsIgnoreCase("cutPayAll"))
/*      */     {
/*  668 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  670 */         this.cutPayAll = FValue.trim();
/*      */       }
/*      */       else
/*  673 */         this.cutPayAll = null;
/*      */     }
/*  675 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  677 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  679 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  682 */         this.operator = null;
/*      */     }
/*  684 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  686 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  688 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  691 */         this.makeDate = null;
/*      */     }
/*  693 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  695 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  697 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  700 */         this.makeTime = null;
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  704 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  706 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  709 */         this.modifyDate = null;
/*      */     }
/*  711 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  713 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  715 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  718 */         this.modifyTime = null;
/*      */     }
/*  720 */     if (FCode.equalsIgnoreCase("p2"))
/*      */     {
/*  722 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  724 */         this.p2 = FValue.trim();
/*      */       }
/*      */       else
/*  727 */         this.p2 = null;
/*      */     }
/*  729 */     if (FCode.equalsIgnoreCase("p4"))
/*      */     {
/*  731 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  733 */         this.p4 = FValue.trim();
/*      */       }
/*      */       else
/*  736 */         this.p4 = null;
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("p3"))
/*      */     {
/*  740 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  742 */         this.p3 = FValue.trim();
/*      */       }
/*      */       else
/*  745 */         this.p3 = null;
/*      */     }
/*  747 */     if (FCode.equalsIgnoreCase("p1"))
/*      */     {
/*  749 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  751 */         this.p1 = FValue.trim();
/*      */       }
/*      */       else
/*  754 */         this.p1 = null;
/*      */     }
/*  756 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  761 */     if (otherObject == null) return false;
/*  762 */     if (this == otherObject) return true;
/*  763 */     if (getClass() != otherObject.getClass()) return false;
/*  764 */     LNPBonusInfoSchema other = (LNPBonusInfoSchema)otherObject;
/*  765 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/*  766 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/*  767 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/*  768 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/*  769 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/*  770 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/*  771 */     if ((this.prtNo == null) && (other.getPrtNo() != null)) return false;
/*  772 */     if ((this.prtNo != null) && (!this.prtNo.equals(other.getPrtNo()))) return false;
/*  773 */     if ((this.bonusType == null) && (other.getBonusType() != null)) return false;
/*  774 */     if ((this.bonusType != null) && (!this.bonusType.equals(other.getBonusType()))) return false;
/*  775 */     if ((this.bonusWay == null) && (other.getBonusWay() != null)) return false;
/*  776 */     if ((this.bonusWay != null) && (!this.bonusWay.equals(other.getBonusWay()))) return false;
/*  777 */     if ((this.autoRepaid == null) && (other.getAutoRepaid() != null)) return false;
/*  778 */     if ((this.autoRepaid != null) && (!this.autoRepaid.equals(other.getAutoRepaid()))) return false;
/*  779 */     if ((this.cutPayAll == null) && (other.getCutPayAll() != null)) return false;
/*  780 */     if ((this.cutPayAll != null) && (!this.cutPayAll.equals(other.getCutPayAll()))) return false;
/*  781 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  782 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  783 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  784 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  785 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  786 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  787 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  788 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  789 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  790 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/*  791 */     if ((this.p2 == null) && (other.getP2() != null)) return false;
/*  792 */     if ((this.p2 != null) && (!this.p2.equals(other.getP2()))) return false;
/*  793 */     if ((this.p4 == null) && (other.getP4() != null)) return false;
/*  794 */     if ((this.p4 != null) && (!this.p4.equals(other.getP4()))) return false;
/*  795 */     if ((this.p3 == null) && (other.getP3() != null)) return false;
/*  796 */     if ((this.p3 != null) && (!this.p3.equals(other.getP3()))) return false;
/*  797 */     if ((this.p1 == null) && (other.getP1() != null)) return false;
/*  798 */     return (this.p1 == null) || (this.p1.equals(other.getP1()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  805 */     return 17;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  811 */     if (strFieldName.equals("grpContNo")) {
/*  812 */       return 0;
/*      */     }
/*  814 */     if (strFieldName.equals("contNo")) {
/*  815 */       return 1;
/*      */     }
/*  817 */     if (strFieldName.equals("proposalContNo")) {
/*  818 */       return 2;
/*      */     }
/*  820 */     if (strFieldName.equals("prtNo")) {
/*  821 */       return 3;
/*      */     }
/*  823 */     if (strFieldName.equals("bonusType")) {
/*  824 */       return 4;
/*      */     }
/*  826 */     if (strFieldName.equals("bonusWay")) {
/*  827 */       return 5;
/*      */     }
/*  829 */     if (strFieldName.equals("autoRepaid")) {
/*  830 */       return 6;
/*      */     }
/*  832 */     if (strFieldName.equals("cutPayAll")) {
/*  833 */       return 7;
/*      */     }
/*  835 */     if (strFieldName.equals("operator")) {
/*  836 */       return 8;
/*      */     }
/*  838 */     if (strFieldName.equals("makeDate")) {
/*  839 */       return 9;
/*      */     }
/*  841 */     if (strFieldName.equals("makeTime")) {
/*  842 */       return 10;
/*      */     }
/*  844 */     if (strFieldName.equals("modifyDate")) {
/*  845 */       return 11;
/*      */     }
/*  847 */     if (strFieldName.equals("modifyTime")) {
/*  848 */       return 12;
/*      */     }
/*  850 */     if (strFieldName.equals("p2")) {
/*  851 */       return 13;
/*      */     }
/*  853 */     if (strFieldName.equals("p4")) {
/*  854 */       return 14;
/*      */     }
/*  856 */     if (strFieldName.equals("p3")) {
/*  857 */       return 15;
/*      */     }
/*  859 */     if (strFieldName.equals("p1")) {
/*  860 */       return 16;
/*      */     }
/*  862 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  868 */     String strFieldName = "";
/*  869 */     switch (nFieldIndex) {
/*      */     case 0:
/*  871 */       strFieldName = "grpContNo";
/*  872 */       break;
/*      */     case 1:
/*  874 */       strFieldName = "contNo";
/*  875 */       break;
/*      */     case 2:
/*  877 */       strFieldName = "proposalContNo";
/*  878 */       break;
/*      */     case 3:
/*  880 */       strFieldName = "prtNo";
/*  881 */       break;
/*      */     case 4:
/*  883 */       strFieldName = "bonusType";
/*  884 */       break;
/*      */     case 5:
/*  886 */       strFieldName = "bonusWay";
/*  887 */       break;
/*      */     case 6:
/*  889 */       strFieldName = "autoRepaid";
/*  890 */       break;
/*      */     case 7:
/*  892 */       strFieldName = "cutPayAll";
/*  893 */       break;
/*      */     case 8:
/*  895 */       strFieldName = "operator";
/*  896 */       break;
/*      */     case 9:
/*  898 */       strFieldName = "makeDate";
/*  899 */       break;
/*      */     case 10:
/*  901 */       strFieldName = "makeTime";
/*  902 */       break;
/*      */     case 11:
/*  904 */       strFieldName = "modifyDate";
/*  905 */       break;
/*      */     case 12:
/*  907 */       strFieldName = "modifyTime";
/*  908 */       break;
/*      */     case 13:
/*  910 */       strFieldName = "p2";
/*  911 */       break;
/*      */     case 14:
/*  913 */       strFieldName = "p4";
/*  914 */       break;
/*      */     case 15:
/*  916 */       strFieldName = "p3";
/*  917 */       break;
/*      */     case 16:
/*  919 */       strFieldName = "p1";
/*  920 */       break;
/*      */     default:
/*  922 */       strFieldName = "";
/*      */     }
/*  924 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  930 */     if (strFieldName.equals("grpContNo")) {
/*  931 */       return 0;
/*      */     }
/*  933 */     if (strFieldName.equals("contNo")) {
/*  934 */       return 0;
/*      */     }
/*  936 */     if (strFieldName.equals("proposalContNo")) {
/*  937 */       return 0;
/*      */     }
/*  939 */     if (strFieldName.equals("prtNo")) {
/*  940 */       return 0;
/*      */     }
/*  942 */     if (strFieldName.equals("bonusType")) {
/*  943 */       return 0;
/*      */     }
/*  945 */     if (strFieldName.equals("bonusWay")) {
/*  946 */       return 0;
/*      */     }
/*  948 */     if (strFieldName.equals("autoRepaid")) {
/*  949 */       return 0;
/*      */     }
/*  951 */     if (strFieldName.equals("cutPayAll")) {
/*  952 */       return 0;
/*      */     }
/*  954 */     if (strFieldName.equals("operator")) {
/*  955 */       return 0;
/*      */     }
/*  957 */     if (strFieldName.equals("makeDate")) {
/*  958 */       return 1;
/*      */     }
/*  960 */     if (strFieldName.equals("makeTime")) {
/*  961 */       return 0;
/*      */     }
/*  963 */     if (strFieldName.equals("modifyDate")) {
/*  964 */       return 1;
/*      */     }
/*  966 */     if (strFieldName.equals("modifyTime")) {
/*  967 */       return 0;
/*      */     }
/*  969 */     if (strFieldName.equals("p2")) {
/*  970 */       return 0;
/*      */     }
/*  972 */     if (strFieldName.equals("p4")) {
/*  973 */       return 0;
/*      */     }
/*  975 */     if (strFieldName.equals("p3")) {
/*  976 */       return 0;
/*      */     }
/*  978 */     if (strFieldName.equals("p1")) {
/*  979 */       return 0;
/*      */     }
/*  981 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/*  987 */     int nFieldType = -1;
/*  988 */     switch (nFieldIndex) {
/*      */     case 0:
/*  990 */       nFieldType = 0;
/*  991 */       break;
/*      */     case 1:
/*  993 */       nFieldType = 0;
/*  994 */       break;
/*      */     case 2:
/*  996 */       nFieldType = 0;
/*  997 */       break;
/*      */     case 3:
/*  999 */       nFieldType = 0;
/* 1000 */       break;
/*      */     case 4:
/* 1002 */       nFieldType = 0;
/* 1003 */       break;
/*      */     case 5:
/* 1005 */       nFieldType = 0;
/* 1006 */       break;
/*      */     case 6:
/* 1008 */       nFieldType = 0;
/* 1009 */       break;
/*      */     case 7:
/* 1011 */       nFieldType = 0;
/* 1012 */       break;
/*      */     case 8:
/* 1014 */       nFieldType = 0;
/* 1015 */       break;
/*      */     case 9:
/* 1017 */       nFieldType = 1;
/* 1018 */       break;
/*      */     case 10:
/* 1020 */       nFieldType = 0;
/* 1021 */       break;
/*      */     case 11:
/* 1023 */       nFieldType = 1;
/* 1024 */       break;
/*      */     case 12:
/* 1026 */       nFieldType = 0;
/* 1027 */       break;
/*      */     case 13:
/* 1029 */       nFieldType = 0;
/* 1030 */       break;
/*      */     case 14:
/* 1032 */       nFieldType = 0;
/* 1033 */       break;
/*      */     case 15:
/* 1035 */       nFieldType = 0;
/* 1036 */       break;
/*      */     case 16:
/* 1038 */       nFieldType = 0;
/* 1039 */       break;
/*      */     default:
/* 1041 */       nFieldType = -1;
/*      */     }
/* 1043 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPBonusInfoSchema
 * JD-Core Version:    0.6.0
 */