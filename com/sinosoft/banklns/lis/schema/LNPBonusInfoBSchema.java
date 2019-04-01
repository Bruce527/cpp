/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPBonusInfoBDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPBonusInfoBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
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
/*      */   public static final int FIELDNUM = 19;
/*      */   private static String[] PK;
/*   63 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPBonusInfoBSchema()
/*      */   {
/*   70 */     this.mErrors = new CErrors();
/*      */ 
/*   72 */     String[] pk = new String[2];
/*   73 */     pk[0] = "EdorNo";
/*   74 */     pk[1] = "serialNo";
/*      */ 
/*   76 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   82 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*   87 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*   91 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*   95 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*   99 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  103 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  107 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getgrpContNo() {
/*  111 */     if (this.grpContNo != null) this.grpContNo.equals("");
/*      */ 
/*  115 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setgrpContNo(String agrpContNo) {
/*  119 */     this.grpContNo = agrpContNo;
/*      */   }
/*      */ 
/*      */   public String getcontNo() {
/*  123 */     if (this.contNo != null) this.contNo.equals("");
/*      */ 
/*  127 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setcontNo(String acontNo) {
/*  131 */     this.contNo = acontNo;
/*      */   }
/*      */ 
/*      */   public String getproposalContNo() {
/*  135 */     if (this.proposalContNo != null) this.proposalContNo.equals("");
/*      */ 
/*  139 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setproposalContNo(String aproposalContNo) {
/*  143 */     this.proposalContNo = aproposalContNo;
/*      */   }
/*      */ 
/*      */   public String getprtNo() {
/*  147 */     if (this.prtNo != null) this.prtNo.equals("");
/*      */ 
/*  151 */     return this.prtNo;
/*      */   }
/*      */ 
/*      */   public void setprtNo(String aprtNo) {
/*  155 */     this.prtNo = aprtNo;
/*      */   }
/*      */ 
/*      */   public String getbonusType() {
/*  159 */     if (this.bonusType != null) this.bonusType.equals("");
/*      */ 
/*  163 */     return this.bonusType;
/*      */   }
/*      */ 
/*      */   public void setbonusType(String abonusType) {
/*  167 */     this.bonusType = abonusType;
/*      */   }
/*      */ 
/*      */   public String getbonusWay() {
/*  171 */     if (this.bonusWay != null) this.bonusWay.equals("");
/*      */ 
/*  175 */     return this.bonusWay;
/*      */   }
/*      */ 
/*      */   public void setbonusWay(String abonusWay) {
/*  179 */     this.bonusWay = abonusWay;
/*      */   }
/*      */ 
/*      */   public String getautoRepaid() {
/*  183 */     if (this.autoRepaid != null) this.autoRepaid.equals("");
/*      */ 
/*  187 */     return this.autoRepaid;
/*      */   }
/*      */ 
/*      */   public void setautoRepaid(String aautoRepaid) {
/*  191 */     this.autoRepaid = aautoRepaid;
/*      */   }
/*      */ 
/*      */   public String getcutPayAll() {
/*  195 */     if (this.cutPayAll != null) this.cutPayAll.equals("");
/*      */ 
/*  199 */     return this.cutPayAll;
/*      */   }
/*      */ 
/*      */   public void setcutPayAll(String acutPayAll) {
/*  203 */     this.cutPayAll = acutPayAll;
/*      */   }
/*      */ 
/*      */   public String getoperator() {
/*  207 */     if (this.operator != null) this.operator.equals("");
/*      */ 
/*  211 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setoperator(String aoperator) {
/*  215 */     this.operator = aoperator;
/*      */   }
/*      */ 
/*      */   public String getmakeDate() {
/*  219 */     if (this.makeDate != null) {
/*  220 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  222 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(Date amakeDate) {
/*  226 */     this.makeDate = amakeDate;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(String amakeDate) {
/*  230 */     if ((amakeDate != null) && (!amakeDate.equals("")))
/*      */     {
/*  232 */       this.makeDate = this.fDate.getDate(amakeDate);
/*      */     }
/*      */     else
/*  235 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getmakeTime()
/*      */   {
/*  240 */     if (this.makeTime != null) this.makeTime.equals("");
/*      */ 
/*  244 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setmakeTime(String amakeTime) {
/*  248 */     this.makeTime = amakeTime;
/*      */   }
/*      */ 
/*      */   public String getmodifyDate() {
/*  252 */     if (this.modifyDate != null) {
/*  253 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  255 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(Date amodifyDate) {
/*  259 */     this.modifyDate = amodifyDate;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(String amodifyDate) {
/*  263 */     if ((amodifyDate != null) && (!amodifyDate.equals("")))
/*      */     {
/*  265 */       this.modifyDate = this.fDate.getDate(amodifyDate);
/*      */     }
/*      */     else
/*  268 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getmodifyTime()
/*      */   {
/*  273 */     if (this.modifyTime != null) this.modifyTime.equals("");
/*      */ 
/*  277 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setmodifyTime(String amodifyTime) {
/*  281 */     this.modifyTime = amodifyTime;
/*      */   }
/*      */ 
/*      */   public String getp2() {
/*  285 */     if (this.p2 != null) this.p2.equals("");
/*      */ 
/*  289 */     return this.p2;
/*      */   }
/*      */ 
/*      */   public void setp2(String ap2) {
/*  293 */     this.p2 = ap2;
/*      */   }
/*      */ 
/*      */   public String getp4() {
/*  297 */     if (this.p4 != null) this.p4.equals("");
/*      */ 
/*  301 */     return this.p4;
/*      */   }
/*      */ 
/*      */   public void setp4(String ap4) {
/*  305 */     this.p4 = ap4;
/*      */   }
/*      */ 
/*      */   public String getp3() {
/*  309 */     if (this.p3 != null) this.p3.equals("");
/*      */ 
/*  313 */     return this.p3;
/*      */   }
/*      */ 
/*      */   public void setp3(String ap3) {
/*  317 */     this.p3 = ap3;
/*      */   }
/*      */ 
/*      */   public String getp1() {
/*  321 */     if (this.p1 != null) this.p1.equals("");
/*      */ 
/*  325 */     return this.p1;
/*      */   }
/*      */ 
/*      */   public void setp1(String ap1) {
/*  329 */     this.p1 = ap1;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPBonusInfoBSchema aLNPBonusInfoBSchema)
/*      */   {
/*  335 */     this.EdorNo = aLNPBonusInfoBSchema.getEdorNo();
/*  336 */     this.serialNo = aLNPBonusInfoBSchema.getserialNo();
/*  337 */     this.grpContNo = aLNPBonusInfoBSchema.getgrpContNo();
/*  338 */     this.contNo = aLNPBonusInfoBSchema.getcontNo();
/*  339 */     this.proposalContNo = aLNPBonusInfoBSchema.getproposalContNo();
/*  340 */     this.prtNo = aLNPBonusInfoBSchema.getprtNo();
/*  341 */     this.bonusType = aLNPBonusInfoBSchema.getbonusType();
/*  342 */     this.bonusWay = aLNPBonusInfoBSchema.getbonusWay();
/*  343 */     this.autoRepaid = aLNPBonusInfoBSchema.getautoRepaid();
/*  344 */     this.cutPayAll = aLNPBonusInfoBSchema.getcutPayAll();
/*  345 */     this.operator = aLNPBonusInfoBSchema.getoperator();
/*  346 */     this.makeDate = this.fDate.getDate(aLNPBonusInfoBSchema.getmakeDate());
/*  347 */     this.makeTime = aLNPBonusInfoBSchema.getmakeTime();
/*  348 */     this.modifyDate = this.fDate.getDate(aLNPBonusInfoBSchema.getmodifyDate());
/*  349 */     this.modifyTime = aLNPBonusInfoBSchema.getmodifyTime();
/*  350 */     this.p2 = aLNPBonusInfoBSchema.getp2();
/*  351 */     this.p4 = aLNPBonusInfoBSchema.getp4();
/*  352 */     this.p3 = aLNPBonusInfoBSchema.getp3();
/*  353 */     this.p1 = aLNPBonusInfoBSchema.getp1();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  362 */       if (rs.getString("EdorNo") == null)
/*  363 */         this.EdorNo = null;
/*      */       else {
/*  365 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  367 */       if (rs.getString("serialNo") == null)
/*  368 */         this.serialNo = null;
/*      */       else {
/*  370 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/*  372 */       if (rs.getString("grpContNo") == null)
/*  373 */         this.grpContNo = null;
/*      */       else {
/*  375 */         this.grpContNo = rs.getString("grpContNo").trim();
/*      */       }
/*  377 */       if (rs.getString("contNo") == null)
/*  378 */         this.contNo = null;
/*      */       else {
/*  380 */         this.contNo = rs.getString("contNo").trim();
/*      */       }
/*  382 */       if (rs.getString("proposalContNo") == null)
/*  383 */         this.proposalContNo = null;
/*      */       else {
/*  385 */         this.proposalContNo = rs.getString("proposalContNo").trim();
/*      */       }
/*  387 */       if (rs.getString("prtNo") == null)
/*  388 */         this.prtNo = null;
/*      */       else {
/*  390 */         this.prtNo = rs.getString("prtNo").trim();
/*      */       }
/*  392 */       if (rs.getString("bonusType") == null)
/*  393 */         this.bonusType = null;
/*      */       else {
/*  395 */         this.bonusType = rs.getString("bonusType").trim();
/*      */       }
/*  397 */       if (rs.getString("bonusWay") == null)
/*  398 */         this.bonusWay = null;
/*      */       else {
/*  400 */         this.bonusWay = rs.getString("bonusWay").trim();
/*      */       }
/*  402 */       if (rs.getString("autoRepaid") == null)
/*  403 */         this.autoRepaid = null;
/*      */       else {
/*  405 */         this.autoRepaid = rs.getString("autoRepaid").trim();
/*      */       }
/*  407 */       if (rs.getString("cutPayAll") == null)
/*  408 */         this.cutPayAll = null;
/*      */       else {
/*  410 */         this.cutPayAll = rs.getString("cutPayAll").trim();
/*      */       }
/*  412 */       if (rs.getString("operator") == null)
/*  413 */         this.operator = null;
/*      */       else {
/*  415 */         this.operator = rs.getString("operator").trim();
/*      */       }
/*  417 */       this.makeDate = rs.getDate("makeDate");
/*  418 */       if (rs.getString("makeTime") == null)
/*  419 */         this.makeTime = null;
/*      */       else {
/*  421 */         this.makeTime = rs.getString("makeTime").trim();
/*      */       }
/*  423 */       this.modifyDate = rs.getDate("modifyDate");
/*  424 */       if (rs.getString("modifyTime") == null)
/*  425 */         this.modifyTime = null;
/*      */       else {
/*  427 */         this.modifyTime = rs.getString("modifyTime").trim();
/*      */       }
/*  429 */       if (rs.getString("p2") == null)
/*  430 */         this.p2 = null;
/*      */       else {
/*  432 */         this.p2 = rs.getString("p2").trim();
/*      */       }
/*  434 */       if (rs.getString("p4") == null)
/*  435 */         this.p4 = null;
/*      */       else {
/*  437 */         this.p4 = rs.getString("p4").trim();
/*      */       }
/*  439 */       if (rs.getString("p3") == null)
/*  440 */         this.p3 = null;
/*      */       else {
/*  442 */         this.p3 = rs.getString("p3").trim();
/*      */       }
/*  444 */       if (rs.getString("p1") == null)
/*  445 */         this.p1 = null;
/*      */       else {
/*  447 */         this.p1 = rs.getString("p1").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  453 */       CError tError = new CError();
/*  454 */       tError.moduleName = "LNPBonusInfoBSchema";
/*  455 */       tError.functionName = "setSchema";
/*  456 */       tError.errorMessage = sqle.toString();
/*  457 */       this.mErrors.addOneError(tError);
/*      */ 
/*  459 */       return false;
/*      */     }
/*  461 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPBonusInfoBSchema getSchema()
/*      */   {
/*  466 */     LNPBonusInfoBSchema aLNPBonusInfoBSchema = new LNPBonusInfoBSchema();
/*  467 */     aLNPBonusInfoBSchema.setSchema(this);
/*  468 */     return aLNPBonusInfoBSchema;
/*      */   }
/*      */ 
/*      */   public LNPBonusInfoBDB getDB()
/*      */   {
/*  473 */     LNPBonusInfoBDB aDBOper = new LNPBonusInfoBDB();
/*  474 */     aDBOper.setSchema(this);
/*  475 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  482 */     String strReturn = "";
/*  483 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/*  484 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/*  485 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpContNo)) + "|" + 
/*  486 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contNo)) + "|" + 
/*  487 */       StrTool.cTrim(StrTool.unicodeToGBK(this.proposalContNo)) + "|" + 
/*  488 */       StrTool.cTrim(StrTool.unicodeToGBK(this.prtNo)) + "|" + 
/*  489 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bonusType)) + "|" + 
/*  490 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bonusWay)) + "|" + 
/*  491 */       StrTool.cTrim(StrTool.unicodeToGBK(this.autoRepaid)) + "|" + 
/*  492 */       StrTool.cTrim(StrTool.unicodeToGBK(this.cutPayAll)) + "|" + 
/*  493 */       StrTool.cTrim(StrTool.unicodeToGBK(this.operator)) + "|" + 
/*  494 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makeDate))) + "|" + 
/*  495 */       StrTool.cTrim(StrTool.unicodeToGBK(this.makeTime)) + "|" + 
/*  496 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifyDate))) + "|" + 
/*  497 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifyTime)) + "|" + 
/*  498 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p2)) + "|" + 
/*  499 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p4)) + "|" + 
/*  500 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p3)) + "|" + 
/*  501 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p1));
/*  502 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  510 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  511 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  512 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  513 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  514 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  515 */       this.prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  516 */       this.bonusType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  517 */       this.bonusWay = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  518 */       this.autoRepaid = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  519 */       this.cutPayAll = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  520 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  521 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
/*  522 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  523 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/*  524 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  525 */       this.p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  526 */       this.p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  527 */       this.p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  528 */       this.p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  533 */       CError tError = new CError();
/*  534 */       tError.moduleName = "LNPBonusInfoBSchema";
/*  535 */       tError.functionName = "decode";
/*  536 */       tError.errorMessage = ex.toString();
/*  537 */       this.mErrors.addOneError(tError);
/*      */ 
/*  539 */       return false;
/*      */     }
/*  541 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  547 */     String strReturn = "";
/*  548 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  550 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/*  552 */     if (FCode.equals("serialNo"))
/*      */     {
/*  554 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/*  556 */     if (FCode.equals("grpContNo"))
/*      */     {
/*  558 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  560 */     if (FCode.equals("contNo"))
/*      */     {
/*  562 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  564 */     if (FCode.equals("proposalContNo"))
/*      */     {
/*  566 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  568 */     if (FCode.equals("prtNo"))
/*      */     {
/*  570 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prtNo));
/*      */     }
/*  572 */     if (FCode.equals("bonusType"))
/*      */     {
/*  574 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bonusType));
/*      */     }
/*  576 */     if (FCode.equals("bonusWay"))
/*      */     {
/*  578 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bonusWay));
/*      */     }
/*  580 */     if (FCode.equals("autoRepaid"))
/*      */     {
/*  582 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.autoRepaid));
/*      */     }
/*  584 */     if (FCode.equals("cutPayAll"))
/*      */     {
/*  586 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.cutPayAll));
/*      */     }
/*  588 */     if (FCode.equals("operator"))
/*      */     {
/*  590 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  592 */     if (FCode.equals("makeDate"))
/*      */     {
/*  594 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*      */     }
/*  596 */     if (FCode.equals("makeTime"))
/*      */     {
/*  598 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  600 */     if (FCode.equals("modifyDate"))
/*      */     {
/*  602 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*      */     }
/*  604 */     if (FCode.equals("modifyTime"))
/*      */     {
/*  606 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  608 */     if (FCode.equals("p2"))
/*      */     {
/*  610 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p2));
/*      */     }
/*  612 */     if (FCode.equals("p4"))
/*      */     {
/*  614 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p4));
/*      */     }
/*  616 */     if (FCode.equals("p3"))
/*      */     {
/*  618 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p3));
/*      */     }
/*  620 */     if (FCode.equals("p1"))
/*      */     {
/*  622 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p1));
/*      */     }
/*  624 */     if (strReturn.equals(""))
/*      */     {
/*  626 */       strReturn = "null";
/*      */     }
/*      */ 
/*  629 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  636 */     String strFieldValue = "";
/*  637 */     switch (nFieldIndex) {
/*      */     case 0:
/*  639 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/*  640 */       break;
/*      */     case 1:
/*  642 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/*  643 */       break;
/*      */     case 2:
/*  645 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  646 */       break;
/*      */     case 3:
/*  648 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  649 */       break;
/*      */     case 4:
/*  651 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  652 */       break;
/*      */     case 5:
/*  654 */       strFieldValue = StrTool.GBKToUnicode(this.prtNo);
/*  655 */       break;
/*      */     case 6:
/*  657 */       strFieldValue = StrTool.GBKToUnicode(this.bonusType);
/*  658 */       break;
/*      */     case 7:
/*  660 */       strFieldValue = StrTool.GBKToUnicode(this.bonusWay);
/*  661 */       break;
/*      */     case 8:
/*  663 */       strFieldValue = StrTool.GBKToUnicode(this.autoRepaid);
/*  664 */       break;
/*      */     case 9:
/*  666 */       strFieldValue = StrTool.GBKToUnicode(this.cutPayAll);
/*  667 */       break;
/*      */     case 10:
/*  669 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  670 */       break;
/*      */     case 11:
/*  672 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*  673 */       break;
/*      */     case 12:
/*  675 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  676 */       break;
/*      */     case 13:
/*  678 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*  679 */       break;
/*      */     case 14:
/*  681 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  682 */       break;
/*      */     case 15:
/*  684 */       strFieldValue = StrTool.GBKToUnicode(this.p2);
/*  685 */       break;
/*      */     case 16:
/*  687 */       strFieldValue = StrTool.GBKToUnicode(this.p4);
/*  688 */       break;
/*      */     case 17:
/*  690 */       strFieldValue = StrTool.GBKToUnicode(this.p3);
/*  691 */       break;
/*      */     case 18:
/*  693 */       strFieldValue = StrTool.GBKToUnicode(this.p1);
/*  694 */       break;
/*      */     default:
/*  696 */       strFieldValue = "";
/*      */     }
/*  698 */     if (strFieldValue.equals("")) {
/*  699 */       strFieldValue = "null";
/*      */     }
/*  701 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  707 */     if (StrTool.cTrim(FCode).equals("")) {
/*  708 */       return false;
/*      */     }
/*  710 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  712 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  714 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/*  717 */         this.EdorNo = null;
/*      */     }
/*  719 */     if (FCode.equals("serialNo"))
/*      */     {
/*  721 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  723 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/*  726 */         this.serialNo = null;
/*      */     }
/*  728 */     if (FCode.equals("grpContNo"))
/*      */     {
/*  730 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  732 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/*  735 */         this.grpContNo = null;
/*      */     }
/*  737 */     if (FCode.equals("contNo"))
/*      */     {
/*  739 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  741 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/*  744 */         this.contNo = null;
/*      */     }
/*  746 */     if (FCode.equals("proposalContNo"))
/*      */     {
/*  748 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  750 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/*  753 */         this.proposalContNo = null;
/*      */     }
/*  755 */     if (FCode.equals("prtNo"))
/*      */     {
/*  757 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  759 */         this.prtNo = FValue.trim();
/*      */       }
/*      */       else
/*  762 */         this.prtNo = null;
/*      */     }
/*  764 */     if (FCode.equals("bonusType"))
/*      */     {
/*  766 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  768 */         this.bonusType = FValue.trim();
/*      */       }
/*      */       else
/*  771 */         this.bonusType = null;
/*      */     }
/*  773 */     if (FCode.equals("bonusWay"))
/*      */     {
/*  775 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  777 */         this.bonusWay = FValue.trim();
/*      */       }
/*      */       else
/*  780 */         this.bonusWay = null;
/*      */     }
/*  782 */     if (FCode.equals("autoRepaid"))
/*      */     {
/*  784 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  786 */         this.autoRepaid = FValue.trim();
/*      */       }
/*      */       else
/*  789 */         this.autoRepaid = null;
/*      */     }
/*  791 */     if (FCode.equals("cutPayAll"))
/*      */     {
/*  793 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  795 */         this.cutPayAll = FValue.trim();
/*      */       }
/*      */       else
/*  798 */         this.cutPayAll = null;
/*      */     }
/*  800 */     if (FCode.equals("operator"))
/*      */     {
/*  802 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  804 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  807 */         this.operator = null;
/*      */     }
/*  809 */     if (FCode.equals("makeDate"))
/*      */     {
/*  811 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  813 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  816 */         this.makeDate = null;
/*      */     }
/*  818 */     if (FCode.equals("makeTime"))
/*      */     {
/*  820 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  822 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  825 */         this.makeTime = null;
/*      */     }
/*  827 */     if (FCode.equals("modifyDate"))
/*      */     {
/*  829 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  831 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  834 */         this.modifyDate = null;
/*      */     }
/*  836 */     if (FCode.equals("modifyTime"))
/*      */     {
/*  838 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  840 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  843 */         this.modifyTime = null;
/*      */     }
/*  845 */     if (FCode.equals("p2"))
/*      */     {
/*  847 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  849 */         this.p2 = FValue.trim();
/*      */       }
/*      */       else
/*  852 */         this.p2 = null;
/*      */     }
/*  854 */     if (FCode.equals("p4"))
/*      */     {
/*  856 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  858 */         this.p4 = FValue.trim();
/*      */       }
/*      */       else
/*  861 */         this.p4 = null;
/*      */     }
/*  863 */     if (FCode.equals("p3"))
/*      */     {
/*  865 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  867 */         this.p3 = FValue.trim();
/*      */       }
/*      */       else
/*  870 */         this.p3 = null;
/*      */     }
/*  872 */     if (FCode.equals("p1"))
/*      */     {
/*  874 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  876 */         this.p1 = FValue.trim();
/*      */       }
/*      */       else
/*  879 */         this.p1 = null;
/*      */     }
/*  881 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  886 */     if (this == otherObject) return true;
/*  887 */     if (otherObject == null) return false;
/*  888 */     if (getClass() != otherObject.getClass()) return false;
/*  889 */     LNPBonusInfoBSchema other = (LNPBonusInfoBSchema)otherObject;
/*  890 */     return 
/*  891 */       (this.EdorNo.equals(other.getEdorNo())) && 
/*  892 */       (this.serialNo.equals(other.getserialNo())) && 
/*  893 */       (this.grpContNo.equals(other.getgrpContNo())) && 
/*  894 */       (this.contNo.equals(other.getcontNo())) && 
/*  895 */       (this.proposalContNo.equals(other.getproposalContNo())) && 
/*  896 */       (this.prtNo.equals(other.getprtNo())) && 
/*  897 */       (this.bonusType.equals(other.getbonusType())) && 
/*  898 */       (this.bonusWay.equals(other.getbonusWay())) && 
/*  899 */       (this.autoRepaid.equals(other.getautoRepaid())) && 
/*  900 */       (this.cutPayAll.equals(other.getcutPayAll())) && 
/*  901 */       (this.operator.equals(other.getoperator())) && 
/*  902 */       (this.fDate.getString(this.makeDate).equals(other.getmakeDate())) && 
/*  903 */       (this.makeTime.equals(other.getmakeTime())) && 
/*  904 */       (this.fDate.getString(this.modifyDate).equals(other.getmodifyDate())) && 
/*  905 */       (this.modifyTime.equals(other.getmodifyTime())) && 
/*  906 */       (this.p2.equals(other.getp2())) && 
/*  907 */       (this.p4.equals(other.getp4())) && 
/*  908 */       (this.p3.equals(other.getp3())) && 
/*  909 */       (this.p1.equals(other.getp1()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  915 */     return 19;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  921 */     if (strFieldName.equals("EdorNo")) {
/*  922 */       return 0;
/*      */     }
/*  924 */     if (strFieldName.equals("serialNo")) {
/*  925 */       return 1;
/*      */     }
/*  927 */     if (strFieldName.equals("grpContNo")) {
/*  928 */       return 2;
/*      */     }
/*  930 */     if (strFieldName.equals("contNo")) {
/*  931 */       return 3;
/*      */     }
/*  933 */     if (strFieldName.equals("proposalContNo")) {
/*  934 */       return 4;
/*      */     }
/*  936 */     if (strFieldName.equals("prtNo")) {
/*  937 */       return 5;
/*      */     }
/*  939 */     if (strFieldName.equals("bonusType")) {
/*  940 */       return 6;
/*      */     }
/*  942 */     if (strFieldName.equals("bonusWay")) {
/*  943 */       return 7;
/*      */     }
/*  945 */     if (strFieldName.equals("autoRepaid")) {
/*  946 */       return 8;
/*      */     }
/*  948 */     if (strFieldName.equals("cutPayAll")) {
/*  949 */       return 9;
/*      */     }
/*  951 */     if (strFieldName.equals("operator")) {
/*  952 */       return 10;
/*      */     }
/*  954 */     if (strFieldName.equals("makeDate")) {
/*  955 */       return 11;
/*      */     }
/*  957 */     if (strFieldName.equals("makeTime")) {
/*  958 */       return 12;
/*      */     }
/*  960 */     if (strFieldName.equals("modifyDate")) {
/*  961 */       return 13;
/*      */     }
/*  963 */     if (strFieldName.equals("modifyTime")) {
/*  964 */       return 14;
/*      */     }
/*  966 */     if (strFieldName.equals("p2")) {
/*  967 */       return 15;
/*      */     }
/*  969 */     if (strFieldName.equals("p4")) {
/*  970 */       return 16;
/*      */     }
/*  972 */     if (strFieldName.equals("p3")) {
/*  973 */       return 17;
/*      */     }
/*  975 */     if (strFieldName.equals("p1")) {
/*  976 */       return 18;
/*      */     }
/*  978 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  984 */     String strFieldName = "";
/*  985 */     switch (nFieldIndex) {
/*      */     case 0:
/*  987 */       strFieldName = "EdorNo";
/*  988 */       break;
/*      */     case 1:
/*  990 */       strFieldName = "serialNo";
/*  991 */       break;
/*      */     case 2:
/*  993 */       strFieldName = "grpContNo";
/*  994 */       break;
/*      */     case 3:
/*  996 */       strFieldName = "contNo";
/*  997 */       break;
/*      */     case 4:
/*  999 */       strFieldName = "proposalContNo";
/* 1000 */       break;
/*      */     case 5:
/* 1002 */       strFieldName = "prtNo";
/* 1003 */       break;
/*      */     case 6:
/* 1005 */       strFieldName = "bonusType";
/* 1006 */       break;
/*      */     case 7:
/* 1008 */       strFieldName = "bonusWay";
/* 1009 */       break;
/*      */     case 8:
/* 1011 */       strFieldName = "autoRepaid";
/* 1012 */       break;
/*      */     case 9:
/* 1014 */       strFieldName = "cutPayAll";
/* 1015 */       break;
/*      */     case 10:
/* 1017 */       strFieldName = "operator";
/* 1018 */       break;
/*      */     case 11:
/* 1020 */       strFieldName = "makeDate";
/* 1021 */       break;
/*      */     case 12:
/* 1023 */       strFieldName = "makeTime";
/* 1024 */       break;
/*      */     case 13:
/* 1026 */       strFieldName = "modifyDate";
/* 1027 */       break;
/*      */     case 14:
/* 1029 */       strFieldName = "modifyTime";
/* 1030 */       break;
/*      */     case 15:
/* 1032 */       strFieldName = "p2";
/* 1033 */       break;
/*      */     case 16:
/* 1035 */       strFieldName = "p4";
/* 1036 */       break;
/*      */     case 17:
/* 1038 */       strFieldName = "p3";
/* 1039 */       break;
/*      */     case 18:
/* 1041 */       strFieldName = "p1";
/* 1042 */       break;
/*      */     default:
/* 1044 */       strFieldName = "";
/*      */     }
/* 1046 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1052 */     if (strFieldName.equals("EdorNo")) {
/* 1053 */       return 0;
/*      */     }
/* 1055 */     if (strFieldName.equals("serialNo")) {
/* 1056 */       return 0;
/*      */     }
/* 1058 */     if (strFieldName.equals("grpContNo")) {
/* 1059 */       return 0;
/*      */     }
/* 1061 */     if (strFieldName.equals("contNo")) {
/* 1062 */       return 0;
/*      */     }
/* 1064 */     if (strFieldName.equals("proposalContNo")) {
/* 1065 */       return 0;
/*      */     }
/* 1067 */     if (strFieldName.equals("prtNo")) {
/* 1068 */       return 0;
/*      */     }
/* 1070 */     if (strFieldName.equals("bonusType")) {
/* 1071 */       return 0;
/*      */     }
/* 1073 */     if (strFieldName.equals("bonusWay")) {
/* 1074 */       return 0;
/*      */     }
/* 1076 */     if (strFieldName.equals("autoRepaid")) {
/* 1077 */       return 0;
/*      */     }
/* 1079 */     if (strFieldName.equals("cutPayAll")) {
/* 1080 */       return 0;
/*      */     }
/* 1082 */     if (strFieldName.equals("operator")) {
/* 1083 */       return 0;
/*      */     }
/* 1085 */     if (strFieldName.equals("makeDate")) {
/* 1086 */       return 1;
/*      */     }
/* 1088 */     if (strFieldName.equals("makeTime")) {
/* 1089 */       return 0;
/*      */     }
/* 1091 */     if (strFieldName.equals("modifyDate")) {
/* 1092 */       return 1;
/*      */     }
/* 1094 */     if (strFieldName.equals("modifyTime")) {
/* 1095 */       return 0;
/*      */     }
/* 1097 */     if (strFieldName.equals("p2")) {
/* 1098 */       return 0;
/*      */     }
/* 1100 */     if (strFieldName.equals("p4")) {
/* 1101 */       return 0;
/*      */     }
/* 1103 */     if (strFieldName.equals("p3")) {
/* 1104 */       return 0;
/*      */     }
/* 1106 */     if (strFieldName.equals("p1")) {
/* 1107 */       return 0;
/*      */     }
/* 1109 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1115 */     int nFieldType = -1;
/* 1116 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1118 */       nFieldType = 0;
/* 1119 */       break;
/*      */     case 1:
/* 1121 */       nFieldType = 0;
/* 1122 */       break;
/*      */     case 2:
/* 1124 */       nFieldType = 0;
/* 1125 */       break;
/*      */     case 3:
/* 1127 */       nFieldType = 0;
/* 1128 */       break;
/*      */     case 4:
/* 1130 */       nFieldType = 0;
/* 1131 */       break;
/*      */     case 5:
/* 1133 */       nFieldType = 0;
/* 1134 */       break;
/*      */     case 6:
/* 1136 */       nFieldType = 0;
/* 1137 */       break;
/*      */     case 7:
/* 1139 */       nFieldType = 0;
/* 1140 */       break;
/*      */     case 8:
/* 1142 */       nFieldType = 0;
/* 1143 */       break;
/*      */     case 9:
/* 1145 */       nFieldType = 0;
/* 1146 */       break;
/*      */     case 10:
/* 1148 */       nFieldType = 0;
/* 1149 */       break;
/*      */     case 11:
/* 1151 */       nFieldType = 1;
/* 1152 */       break;
/*      */     case 12:
/* 1154 */       nFieldType = 0;
/* 1155 */       break;
/*      */     case 13:
/* 1157 */       nFieldType = 1;
/* 1158 */       break;
/*      */     case 14:
/* 1160 */       nFieldType = 0;
/* 1161 */       break;
/*      */     case 15:
/* 1163 */       nFieldType = 0;
/* 1164 */       break;
/*      */     case 16:
/* 1166 */       nFieldType = 0;
/* 1167 */       break;
/*      */     case 17:
/* 1169 */       nFieldType = 0;
/* 1170 */       break;
/*      */     case 18:
/* 1172 */       nFieldType = 0;
/* 1173 */       break;
/*      */     default:
/* 1175 */       nFieldType = -1;
/*      */     }
/* 1177 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPBonusInfoBSchema
 * JD-Core Version:    0.6.0
 */