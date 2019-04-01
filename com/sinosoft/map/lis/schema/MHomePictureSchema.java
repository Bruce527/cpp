/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MHomePictureDB;
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
/*      */ public class MHomePictureSchema
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
/*      */   private String description;
/*      */   public static final int FIELDNUM = 24;
/*      */   private static String[] PK;
/*   72 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MHomePictureSchema()
/*      */   {
/*   79 */     this.mErrors = new CErrors();
/*      */ 
/*   81 */     String[] pk = new String[1];
/*   82 */     pk[0] = "ID";
/*      */ 
/*   84 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   91 */     MHomePictureSchema cloned = (MHomePictureSchema)super.clone();
/*   92 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   93 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   94 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  100 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  105 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  109 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getURL() {
/*  113 */     return this.uRL;
/*      */   }
/*      */ 
/*      */   public void setURL(String aURL) {
/*  117 */     this.uRL = aURL;
/*      */   }
/*      */ 
/*      */   public String getRefURL() {
/*  121 */     return this.refURL;
/*      */   }
/*      */ 
/*      */   public void setRefURL(String aRefURL) {
/*  125 */     this.refURL = aRefURL;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  129 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  133 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getAlt() {
/*  137 */     return this.alt;
/*      */   }
/*      */ 
/*      */   public void setAlt(String aAlt) {
/*  141 */     this.alt = aAlt;
/*      */   }
/*      */ 
/*      */   public int getPicOrder() {
/*  145 */     return this.picOrder;
/*      */   }
/*      */ 
/*      */   public void setPicOrder(int aPicOrder) {
/*  149 */     this.picOrder = aPicOrder;
/*      */   }
/*      */ 
/*      */   public void setPicOrder(String aPicOrder) {
/*  153 */     if ((aPicOrder != null) && (!aPicOrder.equals("")))
/*      */     {
/*  155 */       Integer tInteger = new Integer(aPicOrder);
/*  156 */       int i = tInteger.intValue();
/*  157 */       this.picOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDisplayFlag()
/*      */   {
/*  163 */     return this.displayFlag;
/*      */   }
/*      */ 
/*      */   public void setDisplayFlag(String aDisplayFlag) {
/*  167 */     this.displayFlag = aDisplayFlag;
/*      */   }
/*      */ 
/*      */   public String getCheckState() {
/*  171 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  175 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  179 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  183 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  187 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  191 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  195 */     if (this.checkDate != null) {
/*  196 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  198 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  202 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  206 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  208 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  211 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  216 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  220 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  224 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  228 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  232 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  236 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  240 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  244 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  248 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  250 */       Integer tInteger = new Integer(aIF01);
/*  251 */       int i = tInteger.intValue();
/*  252 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  258 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  262 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  266 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  268 */       Double tDouble = new Double(aDF02);
/*  269 */       double d = tDouble.doubleValue();
/*  270 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  276 */     if (this.date01 != null) {
/*  277 */       return this.fDate.getString(this.date01);
/*      */     }
/*  279 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  283 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  287 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  289 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  292 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  297 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  301 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  305 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  309 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  313 */     if (this.makeDate != null) {
/*  314 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  316 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  320 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  324 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  326 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  329 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  334 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  338 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  342 */     if (this.modifyDate != null) {
/*  343 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  345 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  349 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  353 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  355 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  358 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  363 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  367 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getDescription() {
/*  371 */     return this.description;
/*      */   }
/*      */ 
/*      */   public void setDescription(String aDescription) {
/*  375 */     this.description = aDescription;
/*      */   }
/*      */ 
/*      */   public void setSchema(MHomePictureSchema aMHomePictureSchema)
/*      */   {
/*  381 */     this.iD = aMHomePictureSchema.getID();
/*  382 */     this.uRL = aMHomePictureSchema.getURL();
/*  383 */     this.refURL = aMHomePictureSchema.getRefURL();
/*  384 */     this.name = aMHomePictureSchema.getName();
/*  385 */     this.alt = aMHomePictureSchema.getAlt();
/*  386 */     this.picOrder = aMHomePictureSchema.getPicOrder();
/*  387 */     this.displayFlag = aMHomePictureSchema.getDisplayFlag();
/*  388 */     this.checkState = aMHomePictureSchema.getCheckState();
/*  389 */     this.checkOperator = aMHomePictureSchema.getCheckOperator();
/*  390 */     this.checkReason = aMHomePictureSchema.getCheckReason();
/*  391 */     this.checkDate = this.fDate.getDate(aMHomePictureSchema.getCheckDate());
/*  392 */     this.checkTime = aMHomePictureSchema.getCheckTime();
/*  393 */     this.vF01 = aMHomePictureSchema.getVF01();
/*  394 */     this.nF01 = aMHomePictureSchema.getNF01();
/*  395 */     this.iF01 = aMHomePictureSchema.getIF01();
/*  396 */     this.dF02 = aMHomePictureSchema.getDF02();
/*  397 */     this.date01 = this.fDate.getDate(aMHomePictureSchema.getDate01());
/*  398 */     this.modifyOperator = aMHomePictureSchema.getModifyOperator();
/*  399 */     this.operator = aMHomePictureSchema.getOperator();
/*  400 */     this.makeDate = this.fDate.getDate(aMHomePictureSchema.getMakeDate());
/*  401 */     this.makeTime = aMHomePictureSchema.getMakeTime();
/*  402 */     this.modifyDate = this.fDate.getDate(aMHomePictureSchema.getModifyDate());
/*  403 */     this.modifyTime = aMHomePictureSchema.getModifyTime();
/*  404 */     this.description = aMHomePictureSchema.getDescription();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  413 */       if (rs.getString("ID") == null)
/*  414 */         this.iD = null;
/*      */       else {
/*  416 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  418 */       if (rs.getString("URL") == null)
/*  419 */         this.uRL = null;
/*      */       else {
/*  421 */         this.uRL = rs.getString("URL").trim();
/*      */       }
/*  423 */       if (rs.getString("RefURL") == null)
/*  424 */         this.refURL = null;
/*      */       else {
/*  426 */         this.refURL = rs.getString("RefURL").trim();
/*      */       }
/*  428 */       if (rs.getString("Name") == null)
/*  429 */         this.name = null;
/*      */       else {
/*  431 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  433 */       if (rs.getString("Alt") == null)
/*  434 */         this.alt = null;
/*      */       else {
/*  436 */         this.alt = rs.getString("Alt").trim();
/*      */       }
/*  438 */       this.picOrder = rs.getInt("PicOrder");
/*  439 */       if (rs.getString("DisplayFlag") == null)
/*  440 */         this.displayFlag = null;
/*      */       else {
/*  442 */         this.displayFlag = rs.getString("DisplayFlag").trim();
/*      */       }
/*  444 */       if (rs.getString("CheckState") == null)
/*  445 */         this.checkState = null;
/*      */       else {
/*  447 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  449 */       if (rs.getString("CheckOperator") == null)
/*  450 */         this.checkOperator = null;
/*      */       else {
/*  452 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  454 */       if (rs.getString("CheckReason") == null)
/*  455 */         this.checkReason = null;
/*      */       else {
/*  457 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  459 */       this.checkDate = rs.getDate("CheckDate");
/*  460 */       if (rs.getString("CheckTime") == null)
/*  461 */         this.checkTime = null;
/*      */       else {
/*  463 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  465 */       if (rs.getString("VF01") == null)
/*  466 */         this.vF01 = null;
/*      */       else {
/*  468 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  470 */       if (rs.getString("NF01") == null)
/*  471 */         this.nF01 = null;
/*      */       else {
/*  473 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  475 */       this.iF01 = rs.getInt("IF01");
/*  476 */       this.dF02 = rs.getDouble("DF02");
/*  477 */       this.date01 = rs.getDate("Date01");
/*  478 */       if (rs.getString("ModifyOperator") == null)
/*  479 */         this.modifyOperator = null;
/*      */       else {
/*  481 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  483 */       if (rs.getString("Operator") == null)
/*  484 */         this.operator = null;
/*      */       else {
/*  486 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  488 */       this.makeDate = rs.getDate("MakeDate");
/*  489 */       if (rs.getString("MakeTime") == null)
/*  490 */         this.makeTime = null;
/*      */       else {
/*  492 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  494 */       this.modifyDate = rs.getDate("ModifyDate");
/*  495 */       if (rs.getString("ModifyTime") == null)
/*  496 */         this.modifyTime = null;
/*      */       else {
/*  498 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  500 */       if (rs.getString("Description") == null)
/*  501 */         this.description = null;
/*      */       else {
/*  503 */         this.description = rs.getString("Description").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  508 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MHomePicture\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  510 */       CError tError = new CError();
/*  511 */       tError.moduleName = "MHomePictureSchema";
/*  512 */       tError.functionName = "setSchema";
/*  513 */       tError.errorMessage = sqle.toString();
/*  514 */       this.mErrors.addOneError(tError);
/*  515 */       return false;
/*      */     }
/*  517 */     return true;
/*      */   }
/*      */ 
/*      */   public MHomePictureSchema getSchema()
/*      */   {
/*  522 */     MHomePictureSchema aMHomePictureSchema = new MHomePictureSchema();
/*  523 */     aMHomePictureSchema.setSchema(this);
/*  524 */     return aMHomePictureSchema;
/*      */   }
/*      */ 
/*      */   public MHomePictureDB getDB()
/*      */   {
/*  529 */     MHomePictureDB aDBOper = new MHomePictureDB();
/*  530 */     aDBOper.setSchema(this);
/*  531 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  538 */     StringBuffer strReturn = new StringBuffer(256);
/*  539 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  540 */     strReturn.append(StrTool.cTrim(this.uRL)); strReturn.append("|");
/*  541 */     strReturn.append(StrTool.cTrim(this.refURL)); strReturn.append("|");
/*  542 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  543 */     strReturn.append(StrTool.cTrim(this.alt)); strReturn.append("|");
/*  544 */     strReturn.append(ChgData.chgData(this.picOrder)); strReturn.append("|");
/*  545 */     strReturn.append(StrTool.cTrim(this.displayFlag)); strReturn.append("|");
/*  546 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  547 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  548 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  549 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  550 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  551 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  552 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  553 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  554 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  555 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  556 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  557 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  558 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  559 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  560 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  561 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  562 */     strReturn.append(StrTool.cTrim(this.description));
/*  563 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  571 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  572 */       this.uRL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  573 */       this.refURL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  574 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  575 */       this.alt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  576 */       this.picOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/*  577 */       this.displayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  578 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  579 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  580 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  581 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
/*  582 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  583 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  584 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  585 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).intValue();
/*  586 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|"))).doubleValue();
/*  587 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  588 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  589 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  590 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  591 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  592 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  593 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  594 */       this.description = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  599 */       CError tError = new CError();
/*  600 */       tError.moduleName = "MHomePictureSchema";
/*  601 */       tError.functionName = "decode";
/*  602 */       tError.errorMessage = ex.toString();
/*  603 */       this.mErrors.addOneError(tError);
/*      */ 
/*  605 */       return false;
/*      */     }
/*  607 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  613 */     String strReturn = "";
/*  614 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  616 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  618 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  620 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uRL));
/*      */     }
/*  622 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  624 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.refURL));
/*      */     }
/*  626 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  628 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  630 */     if (FCode.equalsIgnoreCase("alt"))
/*      */     {
/*  632 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.alt));
/*      */     }
/*  634 */     if (FCode.equalsIgnoreCase("picOrder"))
/*      */     {
/*  636 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.picOrder));
/*      */     }
/*  638 */     if (FCode.equalsIgnoreCase("displayFlag"))
/*      */     {
/*  640 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.displayFlag));
/*      */     }
/*  642 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  644 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  646 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  648 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  650 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  652 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  654 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  656 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  658 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  660 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  662 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  664 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  666 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  668 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  670 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  672 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  676 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  678 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  680 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  682 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  684 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  686 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  688 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  690 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  692 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  694 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  696 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  698 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  700 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  704 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  706 */     if (FCode.equalsIgnoreCase("description"))
/*      */     {
/*  708 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.description));
/*      */     }
/*  710 */     if (strReturn.equals(""))
/*      */     {
/*  712 */       strReturn = "null";
/*      */     }
/*      */ 
/*  715 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  722 */     String strFieldValue = "";
/*  723 */     switch (nFieldIndex) {
/*      */     case 0:
/*  725 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  726 */       break;
/*      */     case 1:
/*  728 */       strFieldValue = StrTool.GBKToUnicode(this.uRL);
/*  729 */       break;
/*      */     case 2:
/*  731 */       strFieldValue = StrTool.GBKToUnicode(this.refURL);
/*  732 */       break;
/*      */     case 3:
/*  734 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  735 */       break;
/*      */     case 4:
/*  737 */       strFieldValue = StrTool.GBKToUnicode(this.alt);
/*  738 */       break;
/*      */     case 5:
/*  740 */       strFieldValue = String.valueOf(this.picOrder);
/*  741 */       break;
/*      */     case 6:
/*  743 */       strFieldValue = StrTool.GBKToUnicode(this.displayFlag);
/*  744 */       break;
/*      */     case 7:
/*  746 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/*  747 */       break;
/*      */     case 8:
/*  749 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/*  750 */       break;
/*      */     case 9:
/*  752 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/*  753 */       break;
/*      */     case 10:
/*  755 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*  756 */       break;
/*      */     case 11:
/*  758 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/*  759 */       break;
/*      */     case 12:
/*  761 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  762 */       break;
/*      */     case 13:
/*  764 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  765 */       break;
/*      */     case 14:
/*  767 */       strFieldValue = String.valueOf(this.iF01);
/*  768 */       break;
/*      */     case 15:
/*  770 */       strFieldValue = String.valueOf(this.dF02);
/*  771 */       break;
/*      */     case 16:
/*  773 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  774 */       break;
/*      */     case 17:
/*  776 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  777 */       break;
/*      */     case 18:
/*  779 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  780 */       break;
/*      */     case 19:
/*  782 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  783 */       break;
/*      */     case 20:
/*  785 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  786 */       break;
/*      */     case 21:
/*  788 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  789 */       break;
/*      */     case 22:
/*  791 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  792 */       break;
/*      */     case 23:
/*  794 */       strFieldValue = StrTool.GBKToUnicode(this.description);
/*  795 */       break;
/*      */     default:
/*  797 */       strFieldValue = "";
/*      */     }
/*  799 */     if (strFieldValue.equals("")) {
/*  800 */       strFieldValue = "null";
/*      */     }
/*  802 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  808 */     if (StrTool.cTrim(FCode).equals("")) {
/*  809 */       return false;
/*      */     }
/*  811 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  813 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  815 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  818 */         this.iD = null;
/*      */     }
/*  820 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  822 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  824 */         this.uRL = FValue.trim();
/*      */       }
/*      */       else
/*  827 */         this.uRL = null;
/*      */     }
/*  829 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  831 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  833 */         this.refURL = FValue.trim();
/*      */       }
/*      */       else
/*  836 */         this.refURL = null;
/*      */     }
/*  838 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  840 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  842 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  845 */         this.name = null;
/*      */     }
/*  847 */     if (FCode.equalsIgnoreCase("alt"))
/*      */     {
/*  849 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  851 */         this.alt = FValue.trim();
/*      */       }
/*      */       else
/*  854 */         this.alt = null;
/*      */     }
/*  856 */     if (FCode.equalsIgnoreCase("picOrder"))
/*      */     {
/*  858 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  860 */         Integer tInteger = new Integer(FValue);
/*  861 */         int i = tInteger.intValue();
/*  862 */         this.picOrder = i;
/*      */       }
/*      */     }
/*  865 */     if (FCode.equalsIgnoreCase("displayFlag"))
/*      */     {
/*  867 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  869 */         this.displayFlag = FValue.trim();
/*      */       }
/*      */       else
/*  872 */         this.displayFlag = null;
/*      */     }
/*  874 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  876 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  878 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/*  881 */         this.checkState = null;
/*      */     }
/*  883 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  885 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  887 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/*  890 */         this.checkOperator = null;
/*      */     }
/*  892 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  894 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  896 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/*  899 */         this.checkReason = null;
/*      */     }
/*  901 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  903 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  905 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  908 */         this.checkDate = null;
/*      */     }
/*  910 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  912 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  914 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/*  917 */         this.checkTime = null;
/*      */     }
/*  919 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  921 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  923 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/*  926 */         this.vF01 = null;
/*      */     }
/*  928 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  930 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  932 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/*  935 */         this.nF01 = null;
/*      */     }
/*  937 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  939 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  941 */         Integer tInteger = new Integer(FValue);
/*  942 */         int i = tInteger.intValue();
/*  943 */         this.iF01 = i;
/*      */       }
/*      */     }
/*  946 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  948 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  950 */         Double tDouble = new Double(FValue);
/*  951 */         double d = tDouble.doubleValue();
/*  952 */         this.dF02 = d;
/*      */       }
/*      */     }
/*  955 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  957 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  959 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  962 */         this.date01 = null;
/*      */     }
/*  964 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  966 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  968 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  971 */         this.modifyOperator = null;
/*      */     }
/*  973 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  975 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  977 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  980 */         this.operator = null;
/*      */     }
/*  982 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  984 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  986 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  989 */         this.makeDate = null;
/*      */     }
/*  991 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  993 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  995 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  998 */         this.makeTime = null;
/*      */     }
/* 1000 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1002 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1004 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1007 */         this.modifyDate = null;
/*      */     }
/* 1009 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1011 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1013 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1016 */         this.modifyTime = null;
/*      */     }
/* 1018 */     if (FCode.equalsIgnoreCase("description"))
/*      */     {
/* 1020 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1022 */         this.description = FValue.trim();
/*      */       }
/*      */       else
/* 1025 */         this.description = null;
/*      */     }
/* 1027 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1032 */     if (otherObject == null) return false;
/* 1033 */     if (this == otherObject) return true;
/* 1034 */     if (getClass() != otherObject.getClass()) return false;
/* 1035 */     MHomePictureSchema other = (MHomePictureSchema)otherObject;
/* 1036 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 1037 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 1038 */     if ((this.uRL == null) && (other.getURL() != null)) return false;
/* 1039 */     if ((this.uRL != null) && (!this.uRL.equals(other.getURL()))) return false;
/* 1040 */     if ((this.refURL == null) && (other.getRefURL() != null)) return false;
/* 1041 */     if ((this.refURL != null) && (!this.refURL.equals(other.getRefURL()))) return false;
/* 1042 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 1043 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 1044 */     if ((this.alt == null) && (other.getAlt() != null)) return false;
/* 1045 */     if ((this.alt != null) && (!this.alt.equals(other.getAlt()))) return false;
/* 1046 */     if (this.picOrder != other.getPicOrder()) return false;
/* 1047 */     if ((this.displayFlag == null) && (other.getDisplayFlag() != null)) return false;
/* 1048 */     if ((this.displayFlag != null) && (!this.displayFlag.equals(other.getDisplayFlag()))) return false;
/* 1049 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1050 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1051 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1052 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1053 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1054 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1055 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1056 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1057 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1058 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1059 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1060 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1061 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1062 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1063 */     if (this.iF01 != other.getIF01()) return false;
/* 1064 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1065 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1066 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1067 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1068 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1069 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1070 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1071 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1072 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1073 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1074 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1075 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1076 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1077 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1078 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1079 */     if ((this.description == null) && (other.getDescription() != null)) return false;
/* 1080 */     return (this.description == null) || (this.description.equals(other.getDescription()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1087 */     return 24;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1093 */     if (strFieldName.equals("iD")) {
/* 1094 */       return 0;
/*      */     }
/* 1096 */     if (strFieldName.equals("uRL")) {
/* 1097 */       return 1;
/*      */     }
/* 1099 */     if (strFieldName.equals("refURL")) {
/* 1100 */       return 2;
/*      */     }
/* 1102 */     if (strFieldName.equals("name")) {
/* 1103 */       return 3;
/*      */     }
/* 1105 */     if (strFieldName.equals("alt")) {
/* 1106 */       return 4;
/*      */     }
/* 1108 */     if (strFieldName.equals("picOrder")) {
/* 1109 */       return 5;
/*      */     }
/* 1111 */     if (strFieldName.equals("displayFlag")) {
/* 1112 */       return 6;
/*      */     }
/* 1114 */     if (strFieldName.equals("checkState")) {
/* 1115 */       return 7;
/*      */     }
/* 1117 */     if (strFieldName.equals("checkOperator")) {
/* 1118 */       return 8;
/*      */     }
/* 1120 */     if (strFieldName.equals("checkReason")) {
/* 1121 */       return 9;
/*      */     }
/* 1123 */     if (strFieldName.equals("checkDate")) {
/* 1124 */       return 10;
/*      */     }
/* 1126 */     if (strFieldName.equals("checkTime")) {
/* 1127 */       return 11;
/*      */     }
/* 1129 */     if (strFieldName.equals("vF01")) {
/* 1130 */       return 12;
/*      */     }
/* 1132 */     if (strFieldName.equals("nF01")) {
/* 1133 */       return 13;
/*      */     }
/* 1135 */     if (strFieldName.equals("iF01")) {
/* 1136 */       return 14;
/*      */     }
/* 1138 */     if (strFieldName.equals("dF02")) {
/* 1139 */       return 15;
/*      */     }
/* 1141 */     if (strFieldName.equals("date01")) {
/* 1142 */       return 16;
/*      */     }
/* 1144 */     if (strFieldName.equals("modifyOperator")) {
/* 1145 */       return 17;
/*      */     }
/* 1147 */     if (strFieldName.equals("operator")) {
/* 1148 */       return 18;
/*      */     }
/* 1150 */     if (strFieldName.equals("makeDate")) {
/* 1151 */       return 19;
/*      */     }
/* 1153 */     if (strFieldName.equals("makeTime")) {
/* 1154 */       return 20;
/*      */     }
/* 1156 */     if (strFieldName.equals("modifyDate")) {
/* 1157 */       return 21;
/*      */     }
/* 1159 */     if (strFieldName.equals("modifyTime")) {
/* 1160 */       return 22;
/*      */     }
/* 1162 */     if (strFieldName.equals("description")) {
/* 1163 */       return 23;
/*      */     }
/* 1165 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1171 */     String strFieldName = "";
/* 1172 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1174 */       strFieldName = "iD";
/* 1175 */       break;
/*      */     case 1:
/* 1177 */       strFieldName = "uRL";
/* 1178 */       break;
/*      */     case 2:
/* 1180 */       strFieldName = "refURL";
/* 1181 */       break;
/*      */     case 3:
/* 1183 */       strFieldName = "name";
/* 1184 */       break;
/*      */     case 4:
/* 1186 */       strFieldName = "alt";
/* 1187 */       break;
/*      */     case 5:
/* 1189 */       strFieldName = "picOrder";
/* 1190 */       break;
/*      */     case 6:
/* 1192 */       strFieldName = "displayFlag";
/* 1193 */       break;
/*      */     case 7:
/* 1195 */       strFieldName = "checkState";
/* 1196 */       break;
/*      */     case 8:
/* 1198 */       strFieldName = "checkOperator";
/* 1199 */       break;
/*      */     case 9:
/* 1201 */       strFieldName = "checkReason";
/* 1202 */       break;
/*      */     case 10:
/* 1204 */       strFieldName = "checkDate";
/* 1205 */       break;
/*      */     case 11:
/* 1207 */       strFieldName = "checkTime";
/* 1208 */       break;
/*      */     case 12:
/* 1210 */       strFieldName = "vF01";
/* 1211 */       break;
/*      */     case 13:
/* 1213 */       strFieldName = "nF01";
/* 1214 */       break;
/*      */     case 14:
/* 1216 */       strFieldName = "iF01";
/* 1217 */       break;
/*      */     case 15:
/* 1219 */       strFieldName = "dF02";
/* 1220 */       break;
/*      */     case 16:
/* 1222 */       strFieldName = "date01";
/* 1223 */       break;
/*      */     case 17:
/* 1225 */       strFieldName = "modifyOperator";
/* 1226 */       break;
/*      */     case 18:
/* 1228 */       strFieldName = "operator";
/* 1229 */       break;
/*      */     case 19:
/* 1231 */       strFieldName = "makeDate";
/* 1232 */       break;
/*      */     case 20:
/* 1234 */       strFieldName = "makeTime";
/* 1235 */       break;
/*      */     case 21:
/* 1237 */       strFieldName = "modifyDate";
/* 1238 */       break;
/*      */     case 22:
/* 1240 */       strFieldName = "modifyTime";
/* 1241 */       break;
/*      */     case 23:
/* 1243 */       strFieldName = "description";
/* 1244 */       break;
/*      */     default:
/* 1246 */       strFieldName = "";
/*      */     }
/* 1248 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1254 */     if (strFieldName.equals("iD")) {
/* 1255 */       return 0;
/*      */     }
/* 1257 */     if (strFieldName.equals("uRL")) {
/* 1258 */       return 0;
/*      */     }
/* 1260 */     if (strFieldName.equals("refURL")) {
/* 1261 */       return 0;
/*      */     }
/* 1263 */     if (strFieldName.equals("name")) {
/* 1264 */       return 0;
/*      */     }
/* 1266 */     if (strFieldName.equals("alt")) {
/* 1267 */       return 0;
/*      */     }
/* 1269 */     if (strFieldName.equals("picOrder")) {
/* 1270 */       return 3;
/*      */     }
/* 1272 */     if (strFieldName.equals("displayFlag")) {
/* 1273 */       return 0;
/*      */     }
/* 1275 */     if (strFieldName.equals("checkState")) {
/* 1276 */       return 0;
/*      */     }
/* 1278 */     if (strFieldName.equals("checkOperator")) {
/* 1279 */       return 0;
/*      */     }
/* 1281 */     if (strFieldName.equals("checkReason")) {
/* 1282 */       return 0;
/*      */     }
/* 1284 */     if (strFieldName.equals("checkDate")) {
/* 1285 */       return 1;
/*      */     }
/* 1287 */     if (strFieldName.equals("checkTime")) {
/* 1288 */       return 0;
/*      */     }
/* 1290 */     if (strFieldName.equals("vF01")) {
/* 1291 */       return 0;
/*      */     }
/* 1293 */     if (strFieldName.equals("nF01")) {
/* 1294 */       return 0;
/*      */     }
/* 1296 */     if (strFieldName.equals("iF01")) {
/* 1297 */       return 3;
/*      */     }
/* 1299 */     if (strFieldName.equals("dF02")) {
/* 1300 */       return 4;
/*      */     }
/* 1302 */     if (strFieldName.equals("date01")) {
/* 1303 */       return 1;
/*      */     }
/* 1305 */     if (strFieldName.equals("modifyOperator")) {
/* 1306 */       return 0;
/*      */     }
/* 1308 */     if (strFieldName.equals("operator")) {
/* 1309 */       return 0;
/*      */     }
/* 1311 */     if (strFieldName.equals("makeDate")) {
/* 1312 */       return 1;
/*      */     }
/* 1314 */     if (strFieldName.equals("makeTime")) {
/* 1315 */       return 0;
/*      */     }
/* 1317 */     if (strFieldName.equals("modifyDate")) {
/* 1318 */       return 1;
/*      */     }
/* 1320 */     if (strFieldName.equals("modifyTime")) {
/* 1321 */       return 0;
/*      */     }
/* 1323 */     if (strFieldName.equals("description")) {
/* 1324 */       return 0;
/*      */     }
/* 1326 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1332 */     int nFieldType = -1;
/* 1333 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1335 */       nFieldType = 0;
/* 1336 */       break;
/*      */     case 1:
/* 1338 */       nFieldType = 0;
/* 1339 */       break;
/*      */     case 2:
/* 1341 */       nFieldType = 0;
/* 1342 */       break;
/*      */     case 3:
/* 1344 */       nFieldType = 0;
/* 1345 */       break;
/*      */     case 4:
/* 1347 */       nFieldType = 0;
/* 1348 */       break;
/*      */     case 5:
/* 1350 */       nFieldType = 3;
/* 1351 */       break;
/*      */     case 6:
/* 1353 */       nFieldType = 0;
/* 1354 */       break;
/*      */     case 7:
/* 1356 */       nFieldType = 0;
/* 1357 */       break;
/*      */     case 8:
/* 1359 */       nFieldType = 0;
/* 1360 */       break;
/*      */     case 9:
/* 1362 */       nFieldType = 0;
/* 1363 */       break;
/*      */     case 10:
/* 1365 */       nFieldType = 1;
/* 1366 */       break;
/*      */     case 11:
/* 1368 */       nFieldType = 0;
/* 1369 */       break;
/*      */     case 12:
/* 1371 */       nFieldType = 0;
/* 1372 */       break;
/*      */     case 13:
/* 1374 */       nFieldType = 0;
/* 1375 */       break;
/*      */     case 14:
/* 1377 */       nFieldType = 3;
/* 1378 */       break;
/*      */     case 15:
/* 1380 */       nFieldType = 4;
/* 1381 */       break;
/*      */     case 16:
/* 1383 */       nFieldType = 1;
/* 1384 */       break;
/*      */     case 17:
/* 1386 */       nFieldType = 0;
/* 1387 */       break;
/*      */     case 18:
/* 1389 */       nFieldType = 0;
/* 1390 */       break;
/*      */     case 19:
/* 1392 */       nFieldType = 1;
/* 1393 */       break;
/*      */     case 20:
/* 1395 */       nFieldType = 0;
/* 1396 */       break;
/*      */     case 21:
/* 1398 */       nFieldType = 1;
/* 1399 */       break;
/*      */     case 22:
/* 1401 */       nFieldType = 0;
/* 1402 */       break;
/*      */     case 23:
/* 1404 */       nFieldType = 0;
/* 1405 */       break;
/*      */     default:
/* 1407 */       nFieldType = -1;
/*      */     }
/* 1409 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MHomePictureSchema
 * JD-Core Version:    0.6.0
 */