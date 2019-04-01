/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MHomePictureCheckBDB;
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
/*      */ public class MHomePictureCheckBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String uRL;
/*      */   private String refURL;
/*      */   private String name;
/*      */   private String alt;
/*      */   private int picOrder;
/*      */   private String displayFlag;
/*      */   private String checkState;
/*      */   private String checkOperator;
/*      */   private String checkReason;
/*      */   private Date checkDate;
/*      */   private String checkTime;
/*      */   private String vF01;
/*      */   private String nF01;
/*      */   private int iF01;
/*      */   private double dF02;
/*      */   private Date date01;
/*      */   private String modifyOperator;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   public static final int FIELDNUM = 29;
/*      */   private static String[] PK;
/*   82 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MHomePictureCheckBSchema()
/*      */   {
/*   89 */     this.mErrors = new CErrors();
/*      */ 
/*   91 */     String[] pk = new String[1];
/*   92 */     pk[0] = "EdorNo";
/*      */ 
/*   94 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  101 */     MHomePictureCheckBSchema cloned = (MHomePictureCheckBSchema)super.clone();
/*  102 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  103 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  104 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  110 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  115 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  119 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getURL() {
/*  123 */     return this.uRL;
/*      */   }
/*      */ 
/*      */   public void setURL(String aURL) {
/*  127 */     this.uRL = aURL;
/*      */   }
/*      */ 
/*      */   public String getRefURL() {
/*  131 */     return this.refURL;
/*      */   }
/*      */ 
/*      */   public void setRefURL(String aRefURL) {
/*  135 */     this.refURL = aRefURL;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  139 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  143 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getAlt() {
/*  147 */     return this.alt;
/*      */   }
/*      */ 
/*      */   public void setAlt(String aAlt) {
/*  151 */     this.alt = aAlt;
/*      */   }
/*      */ 
/*      */   public int getPicOrder() {
/*  155 */     return this.picOrder;
/*      */   }
/*      */ 
/*      */   public void setPicOrder(int aPicOrder) {
/*  159 */     this.picOrder = aPicOrder;
/*      */   }
/*      */ 
/*      */   public void setPicOrder(String aPicOrder) {
/*  163 */     if ((aPicOrder != null) && (!aPicOrder.equals("")))
/*      */     {
/*  165 */       Integer tInteger = new Integer(aPicOrder);
/*  166 */       int i = tInteger.intValue();
/*  167 */       this.picOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDisplayFlag()
/*      */   {
/*  173 */     return this.displayFlag;
/*      */   }
/*      */ 
/*      */   public void setDisplayFlag(String aDisplayFlag) {
/*  177 */     this.displayFlag = aDisplayFlag;
/*      */   }
/*      */ 
/*      */   public String getCheckState() {
/*  181 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  185 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  189 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  193 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  197 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  201 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  205 */     if (this.checkDate != null) {
/*  206 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  208 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  212 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  216 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  218 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  221 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  226 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  230 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  234 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  238 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  242 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  246 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  250 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  254 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  258 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  260 */       Integer tInteger = new Integer(aIF01);
/*  261 */       int i = tInteger.intValue();
/*  262 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  268 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  272 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  276 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  278 */       Double tDouble = new Double(aDF02);
/*  279 */       double d = tDouble.doubleValue();
/*  280 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  286 */     if (this.date01 != null) {
/*  287 */       return this.fDate.getString(this.date01);
/*      */     }
/*  289 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  293 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  297 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  299 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  302 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  307 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  311 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  315 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  319 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  323 */     if (this.makeDate != null) {
/*  324 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  326 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  330 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  334 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  336 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  339 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  344 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  348 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  352 */     if (this.modifyDate != null) {
/*  353 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  355 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  359 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  363 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  365 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  368 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  373 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  377 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  381 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  385 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  389 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  393 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  397 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  401 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  405 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  409 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  413 */     if (this.makeDate2 != null) {
/*  414 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  416 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  420 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  424 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  426 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  429 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  434 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  438 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public void setSchema(MHomePictureCheckBSchema aMHomePictureCheckBSchema)
/*      */   {
/*  444 */     this.iD = aMHomePictureCheckBSchema.getID();
/*  445 */     this.uRL = aMHomePictureCheckBSchema.getURL();
/*  446 */     this.refURL = aMHomePictureCheckBSchema.getRefURL();
/*  447 */     this.name = aMHomePictureCheckBSchema.getName();
/*  448 */     this.alt = aMHomePictureCheckBSchema.getAlt();
/*  449 */     this.picOrder = aMHomePictureCheckBSchema.getPicOrder();
/*  450 */     this.displayFlag = aMHomePictureCheckBSchema.getDisplayFlag();
/*  451 */     this.checkState = aMHomePictureCheckBSchema.getCheckState();
/*  452 */     this.checkOperator = aMHomePictureCheckBSchema.getCheckOperator();
/*  453 */     this.checkReason = aMHomePictureCheckBSchema.getCheckReason();
/*  454 */     this.checkDate = this.fDate.getDate(aMHomePictureCheckBSchema.getCheckDate());
/*  455 */     this.checkTime = aMHomePictureCheckBSchema.getCheckTime();
/*  456 */     this.vF01 = aMHomePictureCheckBSchema.getVF01();
/*  457 */     this.nF01 = aMHomePictureCheckBSchema.getNF01();
/*  458 */     this.iF01 = aMHomePictureCheckBSchema.getIF01();
/*  459 */     this.dF02 = aMHomePictureCheckBSchema.getDF02();
/*  460 */     this.date01 = this.fDate.getDate(aMHomePictureCheckBSchema.getDate01());
/*  461 */     this.modifyOperator = aMHomePictureCheckBSchema.getModifyOperator();
/*  462 */     this.operator = aMHomePictureCheckBSchema.getOperator();
/*  463 */     this.makeDate = this.fDate.getDate(aMHomePictureCheckBSchema.getMakeDate());
/*  464 */     this.makeTime = aMHomePictureCheckBSchema.getMakeTime();
/*  465 */     this.modifyDate = this.fDate.getDate(aMHomePictureCheckBSchema.getModifyDate());
/*  466 */     this.modifyTime = aMHomePictureCheckBSchema.getModifyTime();
/*  467 */     this.edorNo = aMHomePictureCheckBSchema.getEdorNo();
/*  468 */     this.edorType = aMHomePictureCheckBSchema.getEdorType();
/*  469 */     this.edorCase = aMHomePictureCheckBSchema.getEdorCase();
/*  470 */     this.operator2 = aMHomePictureCheckBSchema.getOperator2();
/*  471 */     this.makeDate2 = this.fDate.getDate(aMHomePictureCheckBSchema.getMakeDate2());
/*  472 */     this.makeTime2 = aMHomePictureCheckBSchema.getMakeTime2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  481 */       if (rs.getString("ID") == null)
/*  482 */         this.iD = null;
/*      */       else {
/*  484 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  486 */       if (rs.getString("URL") == null)
/*  487 */         this.uRL = null;
/*      */       else {
/*  489 */         this.uRL = rs.getString("URL").trim();
/*      */       }
/*  491 */       if (rs.getString("RefURL") == null)
/*  492 */         this.refURL = null;
/*      */       else {
/*  494 */         this.refURL = rs.getString("RefURL").trim();
/*      */       }
/*  496 */       if (rs.getString("Name") == null)
/*  497 */         this.name = null;
/*      */       else {
/*  499 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  501 */       if (rs.getString("Alt") == null)
/*  502 */         this.alt = null;
/*      */       else {
/*  504 */         this.alt = rs.getString("Alt").trim();
/*      */       }
/*  506 */       this.picOrder = rs.getInt("PicOrder");
/*  507 */       if (rs.getString("DisplayFlag") == null)
/*  508 */         this.displayFlag = null;
/*      */       else {
/*  510 */         this.displayFlag = rs.getString("DisplayFlag").trim();
/*      */       }
/*  512 */       if (rs.getString("CheckState") == null)
/*  513 */         this.checkState = null;
/*      */       else {
/*  515 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  517 */       if (rs.getString("CheckOperator") == null)
/*  518 */         this.checkOperator = null;
/*      */       else {
/*  520 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  522 */       if (rs.getString("CheckReason") == null)
/*  523 */         this.checkReason = null;
/*      */       else {
/*  525 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  527 */       this.checkDate = rs.getDate("CheckDate");
/*  528 */       if (rs.getString("CheckTime") == null)
/*  529 */         this.checkTime = null;
/*      */       else {
/*  531 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  533 */       if (rs.getString("VF01") == null)
/*  534 */         this.vF01 = null;
/*      */       else {
/*  536 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  538 */       if (rs.getString("NF01") == null)
/*  539 */         this.nF01 = null;
/*      */       else {
/*  541 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  543 */       this.iF01 = rs.getInt("IF01");
/*  544 */       this.dF02 = rs.getDouble("DF02");
/*  545 */       this.date01 = rs.getDate("Date01");
/*  546 */       if (rs.getString("ModifyOperator") == null)
/*  547 */         this.modifyOperator = null;
/*      */       else {
/*  549 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  551 */       if (rs.getString("Operator") == null)
/*  552 */         this.operator = null;
/*      */       else {
/*  554 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  556 */       this.makeDate = rs.getDate("MakeDate");
/*  557 */       if (rs.getString("MakeTime") == null)
/*  558 */         this.makeTime = null;
/*      */       else {
/*  560 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  562 */       this.modifyDate = rs.getDate("ModifyDate");
/*  563 */       if (rs.getString("ModifyTime") == null)
/*  564 */         this.modifyTime = null;
/*      */       else {
/*  566 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  568 */       if (rs.getString("EdorNo") == null)
/*  569 */         this.edorNo = null;
/*      */       else {
/*  571 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  573 */       if (rs.getString("EdorType") == null)
/*  574 */         this.edorType = null;
/*      */       else {
/*  576 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  578 */       if (rs.getString("EdorCase") == null)
/*  579 */         this.edorCase = null;
/*      */       else {
/*  581 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  583 */       if (rs.getString("Operator2") == null)
/*  584 */         this.operator2 = null;
/*      */       else {
/*  586 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  588 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  589 */       if (rs.getString("MakeTime2") == null)
/*  590 */         this.makeTime2 = null;
/*      */       else {
/*  592 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  597 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MHomePictureCheckB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  599 */       CError tError = new CError();
/*  600 */       tError.moduleName = "MHomePictureCheckBSchema";
/*  601 */       tError.functionName = "setSchema";
/*  602 */       tError.errorMessage = sqle.toString();
/*  603 */       this.mErrors.addOneError(tError);
/*  604 */       return false;
/*      */     }
/*  606 */     return true;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckBSchema getSchema()
/*      */   {
/*  611 */     MHomePictureCheckBSchema aMHomePictureCheckBSchema = new MHomePictureCheckBSchema();
/*  612 */     aMHomePictureCheckBSchema.setSchema(this);
/*  613 */     return aMHomePictureCheckBSchema;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckBDB getDB()
/*      */   {
/*  618 */     MHomePictureCheckBDB aDBOper = new MHomePictureCheckBDB();
/*  619 */     aDBOper.setSchema(this);
/*  620 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  627 */     StringBuffer strReturn = new StringBuffer(256);
/*  628 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  629 */     strReturn.append(StrTool.cTrim(this.uRL)); strReturn.append("|");
/*  630 */     strReturn.append(StrTool.cTrim(this.refURL)); strReturn.append("|");
/*  631 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  632 */     strReturn.append(StrTool.cTrim(this.alt)); strReturn.append("|");
/*  633 */     strReturn.append(ChgData.chgData(this.picOrder)); strReturn.append("|");
/*  634 */     strReturn.append(StrTool.cTrim(this.displayFlag)); strReturn.append("|");
/*  635 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  636 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  637 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  638 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  639 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  640 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  641 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  642 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  643 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  644 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  645 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  646 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  647 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  648 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  649 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  650 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  651 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  652 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  653 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  654 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  655 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  656 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/*  657 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  665 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  666 */       this.uRL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  667 */       this.refURL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  668 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  669 */       this.alt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  670 */       this.picOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/*  671 */       this.displayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  672 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  673 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  674 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  675 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
/*  676 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  677 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  678 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  679 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).intValue();
/*  680 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|"))).doubleValue();
/*  681 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  682 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  683 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  684 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  685 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  686 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  687 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  688 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  689 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  690 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  691 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  692 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
/*  693 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  698 */       CError tError = new CError();
/*  699 */       tError.moduleName = "MHomePictureCheckBSchema";
/*  700 */       tError.functionName = "decode";
/*  701 */       tError.errorMessage = ex.toString();
/*  702 */       this.mErrors.addOneError(tError);
/*      */ 
/*  704 */       return false;
/*      */     }
/*  706 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  712 */     String strReturn = "";
/*  713 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  715 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  717 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  719 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uRL));
/*      */     }
/*  721 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  723 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.refURL));
/*      */     }
/*  725 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  727 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  729 */     if (FCode.equalsIgnoreCase("alt"))
/*      */     {
/*  731 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.alt));
/*      */     }
/*  733 */     if (FCode.equalsIgnoreCase("picOrder"))
/*      */     {
/*  735 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.picOrder));
/*      */     }
/*  737 */     if (FCode.equalsIgnoreCase("displayFlag"))
/*      */     {
/*  739 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.displayFlag));
/*      */     }
/*  741 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  743 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  745 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  747 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  749 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  751 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  753 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  755 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  757 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  759 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  761 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  763 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  765 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  767 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  769 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  771 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  773 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  775 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  777 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  779 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  781 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  783 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  785 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  787 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  789 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  791 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  793 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  795 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  797 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  799 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  801 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  803 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  805 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  807 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  809 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  811 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  813 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  815 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  817 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  819 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  821 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  823 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  825 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  827 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  829 */     if (strReturn.equals(""))
/*      */     {
/*  831 */       strReturn = "null";
/*      */     }
/*      */ 
/*  834 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  841 */     String strFieldValue = "";
/*  842 */     switch (nFieldIndex) {
/*      */     case 0:
/*  844 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  845 */       break;
/*      */     case 1:
/*  847 */       strFieldValue = StrTool.GBKToUnicode(this.uRL);
/*  848 */       break;
/*      */     case 2:
/*  850 */       strFieldValue = StrTool.GBKToUnicode(this.refURL);
/*  851 */       break;
/*      */     case 3:
/*  853 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  854 */       break;
/*      */     case 4:
/*  856 */       strFieldValue = StrTool.GBKToUnicode(this.alt);
/*  857 */       break;
/*      */     case 5:
/*  859 */       strFieldValue = String.valueOf(this.picOrder);
/*  860 */       break;
/*      */     case 6:
/*  862 */       strFieldValue = StrTool.GBKToUnicode(this.displayFlag);
/*  863 */       break;
/*      */     case 7:
/*  865 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/*  866 */       break;
/*      */     case 8:
/*  868 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/*  869 */       break;
/*      */     case 9:
/*  871 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/*  872 */       break;
/*      */     case 10:
/*  874 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*  875 */       break;
/*      */     case 11:
/*  877 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/*  878 */       break;
/*      */     case 12:
/*  880 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  881 */       break;
/*      */     case 13:
/*  883 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  884 */       break;
/*      */     case 14:
/*  886 */       strFieldValue = String.valueOf(this.iF01);
/*  887 */       break;
/*      */     case 15:
/*  889 */       strFieldValue = String.valueOf(this.dF02);
/*  890 */       break;
/*      */     case 16:
/*  892 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  893 */       break;
/*      */     case 17:
/*  895 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  896 */       break;
/*      */     case 18:
/*  898 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  899 */       break;
/*      */     case 19:
/*  901 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  902 */       break;
/*      */     case 20:
/*  904 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  905 */       break;
/*      */     case 21:
/*  907 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  908 */       break;
/*      */     case 22:
/*  910 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  911 */       break;
/*      */     case 23:
/*  913 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  914 */       break;
/*      */     case 24:
/*  916 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  917 */       break;
/*      */     case 25:
/*  919 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  920 */       break;
/*      */     case 26:
/*  922 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  923 */       break;
/*      */     case 27:
/*  925 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  926 */       break;
/*      */     case 28:
/*  928 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  929 */       break;
/*      */     default:
/*  931 */       strFieldValue = "";
/*      */     }
/*  933 */     if (strFieldValue.equals("")) {
/*  934 */       strFieldValue = "null";
/*      */     }
/*  936 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  942 */     if (StrTool.cTrim(FCode).equals("")) {
/*  943 */       return false;
/*      */     }
/*  945 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  947 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  949 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  952 */         this.iD = null;
/*      */     }
/*  954 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  956 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  958 */         this.uRL = FValue.trim();
/*      */       }
/*      */       else
/*  961 */         this.uRL = null;
/*      */     }
/*  963 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  965 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  967 */         this.refURL = FValue.trim();
/*      */       }
/*      */       else
/*  970 */         this.refURL = null;
/*      */     }
/*  972 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  974 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  976 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  979 */         this.name = null;
/*      */     }
/*  981 */     if (FCode.equalsIgnoreCase("alt"))
/*      */     {
/*  983 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  985 */         this.alt = FValue.trim();
/*      */       }
/*      */       else
/*  988 */         this.alt = null;
/*      */     }
/*  990 */     if (FCode.equalsIgnoreCase("picOrder"))
/*      */     {
/*  992 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  994 */         Integer tInteger = new Integer(FValue);
/*  995 */         int i = tInteger.intValue();
/*  996 */         this.picOrder = i;
/*      */       }
/*      */     }
/*  999 */     if (FCode.equalsIgnoreCase("displayFlag"))
/*      */     {
/* 1001 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1003 */         this.displayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1006 */         this.displayFlag = null;
/*      */     }
/* 1008 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/* 1010 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1012 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/* 1015 */         this.checkState = null;
/*      */     }
/* 1017 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/* 1019 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1021 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1024 */         this.checkOperator = null;
/*      */     }
/* 1026 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/* 1028 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1030 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/* 1033 */         this.checkReason = null;
/*      */     }
/* 1035 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/* 1037 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1039 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1042 */         this.checkDate = null;
/*      */     }
/* 1044 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/* 1046 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1048 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/* 1051 */         this.checkTime = null;
/*      */     }
/* 1053 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1055 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1057 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1060 */         this.vF01 = null;
/*      */     }
/* 1062 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1064 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1066 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1069 */         this.nF01 = null;
/*      */     }
/* 1071 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1073 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1075 */         Integer tInteger = new Integer(FValue);
/* 1076 */         int i = tInteger.intValue();
/* 1077 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1080 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1082 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1084 */         Double tDouble = new Double(FValue);
/* 1085 */         double d = tDouble.doubleValue();
/* 1086 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1089 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1091 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1093 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1096 */         this.date01 = null;
/*      */     }
/* 1098 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1100 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1102 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1105 */         this.modifyOperator = null;
/*      */     }
/* 1107 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1109 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1111 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1114 */         this.operator = null;
/*      */     }
/* 1116 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1118 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1120 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1123 */         this.makeDate = null;
/*      */     }
/* 1125 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1127 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1129 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1132 */         this.makeTime = null;
/*      */     }
/* 1134 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1136 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1138 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1141 */         this.modifyDate = null;
/*      */     }
/* 1143 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1145 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1147 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1150 */         this.modifyTime = null;
/*      */     }
/* 1152 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/* 1154 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1156 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1159 */         this.edorNo = null;
/*      */     }
/* 1161 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/* 1163 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1165 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1168 */         this.edorType = null;
/*      */     }
/* 1170 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1172 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1174 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1177 */         this.edorCase = null;
/*      */     }
/* 1179 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1181 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1183 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1186 */         this.operator2 = null;
/*      */     }
/* 1188 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1190 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1192 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1195 */         this.makeDate2 = null;
/*      */     }
/* 1197 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1199 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1201 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1204 */         this.makeTime2 = null;
/*      */     }
/* 1206 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1211 */     if (otherObject == null) return false;
/* 1212 */     if (this == otherObject) return true;
/* 1213 */     if (getClass() != otherObject.getClass()) return false;
/* 1214 */     MHomePictureCheckBSchema other = (MHomePictureCheckBSchema)otherObject;
/* 1215 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 1216 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 1217 */     if ((this.uRL == null) && (other.getURL() != null)) return false;
/* 1218 */     if ((this.uRL != null) && (!this.uRL.equals(other.getURL()))) return false;
/* 1219 */     if ((this.refURL == null) && (other.getRefURL() != null)) return false;
/* 1220 */     if ((this.refURL != null) && (!this.refURL.equals(other.getRefURL()))) return false;
/* 1221 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 1222 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 1223 */     if ((this.alt == null) && (other.getAlt() != null)) return false;
/* 1224 */     if ((this.alt != null) && (!this.alt.equals(other.getAlt()))) return false;
/* 1225 */     if (this.picOrder != other.getPicOrder()) return false;
/* 1226 */     if ((this.displayFlag == null) && (other.getDisplayFlag() != null)) return false;
/* 1227 */     if ((this.displayFlag != null) && (!this.displayFlag.equals(other.getDisplayFlag()))) return false;
/* 1228 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1229 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1230 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1231 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1232 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1233 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1234 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1235 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1236 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1237 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1238 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1239 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1240 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1241 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1242 */     if (this.iF01 != other.getIF01()) return false;
/* 1243 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1244 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1245 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1246 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1247 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1248 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1249 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1250 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1251 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1252 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1253 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1254 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1255 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1256 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1257 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1258 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1259 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1260 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1261 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1262 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1263 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1264 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1265 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1266 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1267 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1268 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1269 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1276 */     return 29;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1282 */     if (strFieldName.equals("iD")) {
/* 1283 */       return 0;
/*      */     }
/* 1285 */     if (strFieldName.equals("uRL")) {
/* 1286 */       return 1;
/*      */     }
/* 1288 */     if (strFieldName.equals("refURL")) {
/* 1289 */       return 2;
/*      */     }
/* 1291 */     if (strFieldName.equals("name")) {
/* 1292 */       return 3;
/*      */     }
/* 1294 */     if (strFieldName.equals("alt")) {
/* 1295 */       return 4;
/*      */     }
/* 1297 */     if (strFieldName.equals("picOrder")) {
/* 1298 */       return 5;
/*      */     }
/* 1300 */     if (strFieldName.equals("displayFlag")) {
/* 1301 */       return 6;
/*      */     }
/* 1303 */     if (strFieldName.equals("checkState")) {
/* 1304 */       return 7;
/*      */     }
/* 1306 */     if (strFieldName.equals("checkOperator")) {
/* 1307 */       return 8;
/*      */     }
/* 1309 */     if (strFieldName.equals("checkReason")) {
/* 1310 */       return 9;
/*      */     }
/* 1312 */     if (strFieldName.equals("checkDate")) {
/* 1313 */       return 10;
/*      */     }
/* 1315 */     if (strFieldName.equals("checkTime")) {
/* 1316 */       return 11;
/*      */     }
/* 1318 */     if (strFieldName.equals("vF01")) {
/* 1319 */       return 12;
/*      */     }
/* 1321 */     if (strFieldName.equals("nF01")) {
/* 1322 */       return 13;
/*      */     }
/* 1324 */     if (strFieldName.equals("iF01")) {
/* 1325 */       return 14;
/*      */     }
/* 1327 */     if (strFieldName.equals("dF02")) {
/* 1328 */       return 15;
/*      */     }
/* 1330 */     if (strFieldName.equals("date01")) {
/* 1331 */       return 16;
/*      */     }
/* 1333 */     if (strFieldName.equals("modifyOperator")) {
/* 1334 */       return 17;
/*      */     }
/* 1336 */     if (strFieldName.equals("operator")) {
/* 1337 */       return 18;
/*      */     }
/* 1339 */     if (strFieldName.equals("makeDate")) {
/* 1340 */       return 19;
/*      */     }
/* 1342 */     if (strFieldName.equals("makeTime")) {
/* 1343 */       return 20;
/*      */     }
/* 1345 */     if (strFieldName.equals("modifyDate")) {
/* 1346 */       return 21;
/*      */     }
/* 1348 */     if (strFieldName.equals("modifyTime")) {
/* 1349 */       return 22;
/*      */     }
/* 1351 */     if (strFieldName.equals("edorNo")) {
/* 1352 */       return 23;
/*      */     }
/* 1354 */     if (strFieldName.equals("edorType")) {
/* 1355 */       return 24;
/*      */     }
/* 1357 */     if (strFieldName.equals("edorCase")) {
/* 1358 */       return 25;
/*      */     }
/* 1360 */     if (strFieldName.equals("operator2")) {
/* 1361 */       return 26;
/*      */     }
/* 1363 */     if (strFieldName.equals("makeDate2")) {
/* 1364 */       return 27;
/*      */     }
/* 1366 */     if (strFieldName.equals("makeTime2")) {
/* 1367 */       return 28;
/*      */     }
/* 1369 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1375 */     String strFieldName = "";
/* 1376 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1378 */       strFieldName = "iD";
/* 1379 */       break;
/*      */     case 1:
/* 1381 */       strFieldName = "uRL";
/* 1382 */       break;
/*      */     case 2:
/* 1384 */       strFieldName = "refURL";
/* 1385 */       break;
/*      */     case 3:
/* 1387 */       strFieldName = "name";
/* 1388 */       break;
/*      */     case 4:
/* 1390 */       strFieldName = "alt";
/* 1391 */       break;
/*      */     case 5:
/* 1393 */       strFieldName = "picOrder";
/* 1394 */       break;
/*      */     case 6:
/* 1396 */       strFieldName = "displayFlag";
/* 1397 */       break;
/*      */     case 7:
/* 1399 */       strFieldName = "checkState";
/* 1400 */       break;
/*      */     case 8:
/* 1402 */       strFieldName = "checkOperator";
/* 1403 */       break;
/*      */     case 9:
/* 1405 */       strFieldName = "checkReason";
/* 1406 */       break;
/*      */     case 10:
/* 1408 */       strFieldName = "checkDate";
/* 1409 */       break;
/*      */     case 11:
/* 1411 */       strFieldName = "checkTime";
/* 1412 */       break;
/*      */     case 12:
/* 1414 */       strFieldName = "vF01";
/* 1415 */       break;
/*      */     case 13:
/* 1417 */       strFieldName = "nF01";
/* 1418 */       break;
/*      */     case 14:
/* 1420 */       strFieldName = "iF01";
/* 1421 */       break;
/*      */     case 15:
/* 1423 */       strFieldName = "dF02";
/* 1424 */       break;
/*      */     case 16:
/* 1426 */       strFieldName = "date01";
/* 1427 */       break;
/*      */     case 17:
/* 1429 */       strFieldName = "modifyOperator";
/* 1430 */       break;
/*      */     case 18:
/* 1432 */       strFieldName = "operator";
/* 1433 */       break;
/*      */     case 19:
/* 1435 */       strFieldName = "makeDate";
/* 1436 */       break;
/*      */     case 20:
/* 1438 */       strFieldName = "makeTime";
/* 1439 */       break;
/*      */     case 21:
/* 1441 */       strFieldName = "modifyDate";
/* 1442 */       break;
/*      */     case 22:
/* 1444 */       strFieldName = "modifyTime";
/* 1445 */       break;
/*      */     case 23:
/* 1447 */       strFieldName = "edorNo";
/* 1448 */       break;
/*      */     case 24:
/* 1450 */       strFieldName = "edorType";
/* 1451 */       break;
/*      */     case 25:
/* 1453 */       strFieldName = "edorCase";
/* 1454 */       break;
/*      */     case 26:
/* 1456 */       strFieldName = "operator2";
/* 1457 */       break;
/*      */     case 27:
/* 1459 */       strFieldName = "makeDate2";
/* 1460 */       break;
/*      */     case 28:
/* 1462 */       strFieldName = "makeTime2";
/* 1463 */       break;
/*      */     default:
/* 1465 */       strFieldName = "";
/*      */     }
/* 1467 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1473 */     if (strFieldName.equals("iD")) {
/* 1474 */       return 0;
/*      */     }
/* 1476 */     if (strFieldName.equals("uRL")) {
/* 1477 */       return 0;
/*      */     }
/* 1479 */     if (strFieldName.equals("refURL")) {
/* 1480 */       return 0;
/*      */     }
/* 1482 */     if (strFieldName.equals("name")) {
/* 1483 */       return 0;
/*      */     }
/* 1485 */     if (strFieldName.equals("alt")) {
/* 1486 */       return 0;
/*      */     }
/* 1488 */     if (strFieldName.equals("picOrder")) {
/* 1489 */       return 3;
/*      */     }
/* 1491 */     if (strFieldName.equals("displayFlag")) {
/* 1492 */       return 0;
/*      */     }
/* 1494 */     if (strFieldName.equals("checkState")) {
/* 1495 */       return 0;
/*      */     }
/* 1497 */     if (strFieldName.equals("checkOperator")) {
/* 1498 */       return 0;
/*      */     }
/* 1500 */     if (strFieldName.equals("checkReason")) {
/* 1501 */       return 0;
/*      */     }
/* 1503 */     if (strFieldName.equals("checkDate")) {
/* 1504 */       return 1;
/*      */     }
/* 1506 */     if (strFieldName.equals("checkTime")) {
/* 1507 */       return 0;
/*      */     }
/* 1509 */     if (strFieldName.equals("vF01")) {
/* 1510 */       return 0;
/*      */     }
/* 1512 */     if (strFieldName.equals("nF01")) {
/* 1513 */       return 0;
/*      */     }
/* 1515 */     if (strFieldName.equals("iF01")) {
/* 1516 */       return 3;
/*      */     }
/* 1518 */     if (strFieldName.equals("dF02")) {
/* 1519 */       return 4;
/*      */     }
/* 1521 */     if (strFieldName.equals("date01")) {
/* 1522 */       return 1;
/*      */     }
/* 1524 */     if (strFieldName.equals("modifyOperator")) {
/* 1525 */       return 0;
/*      */     }
/* 1527 */     if (strFieldName.equals("operator")) {
/* 1528 */       return 0;
/*      */     }
/* 1530 */     if (strFieldName.equals("makeDate")) {
/* 1531 */       return 1;
/*      */     }
/* 1533 */     if (strFieldName.equals("makeTime")) {
/* 1534 */       return 0;
/*      */     }
/* 1536 */     if (strFieldName.equals("modifyDate")) {
/* 1537 */       return 1;
/*      */     }
/* 1539 */     if (strFieldName.equals("modifyTime")) {
/* 1540 */       return 0;
/*      */     }
/* 1542 */     if (strFieldName.equals("edorNo")) {
/* 1543 */       return 0;
/*      */     }
/* 1545 */     if (strFieldName.equals("edorType")) {
/* 1546 */       return 0;
/*      */     }
/* 1548 */     if (strFieldName.equals("edorCase")) {
/* 1549 */       return 0;
/*      */     }
/* 1551 */     if (strFieldName.equals("operator2")) {
/* 1552 */       return 0;
/*      */     }
/* 1554 */     if (strFieldName.equals("makeDate2")) {
/* 1555 */       return 1;
/*      */     }
/* 1557 */     if (strFieldName.equals("makeTime2")) {
/* 1558 */       return 0;
/*      */     }
/* 1560 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1566 */     int nFieldType = -1;
/* 1567 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1569 */       nFieldType = 0;
/* 1570 */       break;
/*      */     case 1:
/* 1572 */       nFieldType = 0;
/* 1573 */       break;
/*      */     case 2:
/* 1575 */       nFieldType = 0;
/* 1576 */       break;
/*      */     case 3:
/* 1578 */       nFieldType = 0;
/* 1579 */       break;
/*      */     case 4:
/* 1581 */       nFieldType = 0;
/* 1582 */       break;
/*      */     case 5:
/* 1584 */       nFieldType = 3;
/* 1585 */       break;
/*      */     case 6:
/* 1587 */       nFieldType = 0;
/* 1588 */       break;
/*      */     case 7:
/* 1590 */       nFieldType = 0;
/* 1591 */       break;
/*      */     case 8:
/* 1593 */       nFieldType = 0;
/* 1594 */       break;
/*      */     case 9:
/* 1596 */       nFieldType = 0;
/* 1597 */       break;
/*      */     case 10:
/* 1599 */       nFieldType = 1;
/* 1600 */       break;
/*      */     case 11:
/* 1602 */       nFieldType = 0;
/* 1603 */       break;
/*      */     case 12:
/* 1605 */       nFieldType = 0;
/* 1606 */       break;
/*      */     case 13:
/* 1608 */       nFieldType = 0;
/* 1609 */       break;
/*      */     case 14:
/* 1611 */       nFieldType = 3;
/* 1612 */       break;
/*      */     case 15:
/* 1614 */       nFieldType = 4;
/* 1615 */       break;
/*      */     case 16:
/* 1617 */       nFieldType = 1;
/* 1618 */       break;
/*      */     case 17:
/* 1620 */       nFieldType = 0;
/* 1621 */       break;
/*      */     case 18:
/* 1623 */       nFieldType = 0;
/* 1624 */       break;
/*      */     case 19:
/* 1626 */       nFieldType = 1;
/* 1627 */       break;
/*      */     case 20:
/* 1629 */       nFieldType = 0;
/* 1630 */       break;
/*      */     case 21:
/* 1632 */       nFieldType = 1;
/* 1633 */       break;
/*      */     case 22:
/* 1635 */       nFieldType = 0;
/* 1636 */       break;
/*      */     case 23:
/* 1638 */       nFieldType = 0;
/* 1639 */       break;
/*      */     case 24:
/* 1641 */       nFieldType = 0;
/* 1642 */       break;
/*      */     case 25:
/* 1644 */       nFieldType = 0;
/* 1645 */       break;
/*      */     case 26:
/* 1647 */       nFieldType = 0;
/* 1648 */       break;
/*      */     case 27:
/* 1650 */       nFieldType = 1;
/* 1651 */       break;
/*      */     case 28:
/* 1653 */       nFieldType = 0;
/* 1654 */       break;
/*      */     default:
/* 1656 */       nFieldType = -1;
/*      */     }
/* 1658 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MHomePictureCheckBSchema
 * JD-Core Version:    0.6.0
 */