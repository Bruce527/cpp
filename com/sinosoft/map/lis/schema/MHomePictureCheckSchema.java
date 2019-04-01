/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MHomePictureCheckDB;
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
/*      */ public class MHomePictureCheckSchema
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
/*      */   public static final int FIELDNUM = 23;
/*      */   private static String[] PK;
/*   70 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MHomePictureCheckSchema()
/*      */   {
/*   77 */     this.mErrors = new CErrors();
/*      */ 
/*   79 */     String[] pk = new String[1];
/*   80 */     pk[0] = "ID";
/*      */ 
/*   82 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   89 */     MHomePictureCheckSchema cloned = (MHomePictureCheckSchema)super.clone();
/*   90 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   91 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   92 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   98 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  103 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  107 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getURL() {
/*  111 */     return this.uRL;
/*      */   }
/*      */ 
/*      */   public void setURL(String aURL) {
/*  115 */     this.uRL = aURL;
/*      */   }
/*      */ 
/*      */   public String getRefURL() {
/*  119 */     return this.refURL;
/*      */   }
/*      */ 
/*      */   public void setRefURL(String aRefURL) {
/*  123 */     this.refURL = aRefURL;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  127 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  131 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getAlt() {
/*  135 */     return this.alt;
/*      */   }
/*      */ 
/*      */   public void setAlt(String aAlt) {
/*  139 */     this.alt = aAlt;
/*      */   }
/*      */ 
/*      */   public int getPicOrder() {
/*  143 */     return this.picOrder;
/*      */   }
/*      */ 
/*      */   public void setPicOrder(int aPicOrder) {
/*  147 */     this.picOrder = aPicOrder;
/*      */   }
/*      */ 
/*      */   public void setPicOrder(String aPicOrder) {
/*  151 */     if ((aPicOrder != null) && (!aPicOrder.equals("")))
/*      */     {
/*  153 */       Integer tInteger = new Integer(aPicOrder);
/*  154 */       int i = tInteger.intValue();
/*  155 */       this.picOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDisplayFlag()
/*      */   {
/*  161 */     return this.displayFlag;
/*      */   }
/*      */ 
/*      */   public void setDisplayFlag(String aDisplayFlag) {
/*  165 */     this.displayFlag = aDisplayFlag;
/*      */   }
/*      */ 
/*      */   public String getCheckState() {
/*  169 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  173 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  177 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  181 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  185 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  189 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  193 */     if (this.checkDate != null) {
/*  194 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  196 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  200 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  204 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  206 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  209 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  214 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  218 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  222 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  226 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  230 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  234 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  238 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  242 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  246 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  248 */       Integer tInteger = new Integer(aIF01);
/*  249 */       int i = tInteger.intValue();
/*  250 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  256 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  260 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  264 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  266 */       Double tDouble = new Double(aDF02);
/*  267 */       double d = tDouble.doubleValue();
/*  268 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  274 */     if (this.date01 != null) {
/*  275 */       return this.fDate.getString(this.date01);
/*      */     }
/*  277 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  281 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  285 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  287 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  290 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  295 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  299 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  303 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  307 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  311 */     if (this.makeDate != null) {
/*  312 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  314 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  318 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  322 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  324 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  327 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  332 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  336 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  340 */     if (this.modifyDate != null) {
/*  341 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  343 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  347 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  351 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  353 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  356 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  361 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  365 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MHomePictureCheckSchema aMHomePictureCheckSchema)
/*      */   {
/*  371 */     this.iD = aMHomePictureCheckSchema.getID();
/*  372 */     this.uRL = aMHomePictureCheckSchema.getURL();
/*  373 */     this.refURL = aMHomePictureCheckSchema.getRefURL();
/*  374 */     this.name = aMHomePictureCheckSchema.getName();
/*  375 */     this.alt = aMHomePictureCheckSchema.getAlt();
/*  376 */     this.picOrder = aMHomePictureCheckSchema.getPicOrder();
/*  377 */     this.displayFlag = aMHomePictureCheckSchema.getDisplayFlag();
/*  378 */     this.checkState = aMHomePictureCheckSchema.getCheckState();
/*  379 */     this.checkOperator = aMHomePictureCheckSchema.getCheckOperator();
/*  380 */     this.checkReason = aMHomePictureCheckSchema.getCheckReason();
/*  381 */     this.checkDate = this.fDate.getDate(aMHomePictureCheckSchema.getCheckDate());
/*  382 */     this.checkTime = aMHomePictureCheckSchema.getCheckTime();
/*  383 */     this.vF01 = aMHomePictureCheckSchema.getVF01();
/*  384 */     this.nF01 = aMHomePictureCheckSchema.getNF01();
/*  385 */     this.iF01 = aMHomePictureCheckSchema.getIF01();
/*  386 */     this.dF02 = aMHomePictureCheckSchema.getDF02();
/*  387 */     this.date01 = this.fDate.getDate(aMHomePictureCheckSchema.getDate01());
/*  388 */     this.modifyOperator = aMHomePictureCheckSchema.getModifyOperator();
/*  389 */     this.operator = aMHomePictureCheckSchema.getOperator();
/*  390 */     this.makeDate = this.fDate.getDate(aMHomePictureCheckSchema.getMakeDate());
/*  391 */     this.makeTime = aMHomePictureCheckSchema.getMakeTime();
/*  392 */     this.modifyDate = this.fDate.getDate(aMHomePictureCheckSchema.getModifyDate());
/*  393 */     this.modifyTime = aMHomePictureCheckSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  402 */       if (rs.getString("ID") == null)
/*  403 */         this.iD = null;
/*      */       else {
/*  405 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  407 */       if (rs.getString("URL") == null)
/*  408 */         this.uRL = null;
/*      */       else {
/*  410 */         this.uRL = rs.getString("URL").trim();
/*      */       }
/*  412 */       if (rs.getString("RefURL") == null)
/*  413 */         this.refURL = null;
/*      */       else {
/*  415 */         this.refURL = rs.getString("RefURL").trim();
/*      */       }
/*  417 */       if (rs.getString("Name") == null)
/*  418 */         this.name = null;
/*      */       else {
/*  420 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  422 */       if (rs.getString("Alt") == null)
/*  423 */         this.alt = null;
/*      */       else {
/*  425 */         this.alt = rs.getString("Alt").trim();
/*      */       }
/*  427 */       this.picOrder = rs.getInt("PicOrder");
/*  428 */       if (rs.getString("DisplayFlag") == null)
/*  429 */         this.displayFlag = null;
/*      */       else {
/*  431 */         this.displayFlag = rs.getString("DisplayFlag").trim();
/*      */       }
/*  433 */       if (rs.getString("CheckState") == null)
/*  434 */         this.checkState = null;
/*      */       else {
/*  436 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  438 */       if (rs.getString("CheckOperator") == null)
/*  439 */         this.checkOperator = null;
/*      */       else {
/*  441 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  443 */       if (rs.getString("CheckReason") == null)
/*  444 */         this.checkReason = null;
/*      */       else {
/*  446 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  448 */       this.checkDate = rs.getDate("CheckDate");
/*  449 */       if (rs.getString("CheckTime") == null)
/*  450 */         this.checkTime = null;
/*      */       else {
/*  452 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  454 */       if (rs.getString("VF01") == null)
/*  455 */         this.vF01 = null;
/*      */       else {
/*  457 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  459 */       if (rs.getString("NF01") == null)
/*  460 */         this.nF01 = null;
/*      */       else {
/*  462 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  464 */       this.iF01 = rs.getInt("IF01");
/*  465 */       this.dF02 = rs.getDouble("DF02");
/*  466 */       this.date01 = rs.getDate("Date01");
/*  467 */       if (rs.getString("ModifyOperator") == null)
/*  468 */         this.modifyOperator = null;
/*      */       else {
/*  470 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  472 */       if (rs.getString("Operator") == null)
/*  473 */         this.operator = null;
/*      */       else {
/*  475 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  477 */       this.makeDate = rs.getDate("MakeDate");
/*  478 */       if (rs.getString("MakeTime") == null)
/*  479 */         this.makeTime = null;
/*      */       else {
/*  481 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  483 */       this.modifyDate = rs.getDate("ModifyDate");
/*  484 */       if (rs.getString("ModifyTime") == null)
/*  485 */         this.modifyTime = null;
/*      */       else {
/*  487 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  492 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MHomePictureCheck\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  494 */       CError tError = new CError();
/*  495 */       tError.moduleName = "MHomePictureCheckSchema";
/*  496 */       tError.functionName = "setSchema";
/*  497 */       tError.errorMessage = sqle.toString();
/*  498 */       this.mErrors.addOneError(tError);
/*  499 */       return false;
/*      */     }
/*  501 */     return true;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckSchema getSchema()
/*      */   {
/*  506 */     MHomePictureCheckSchema aMHomePictureCheckSchema = new MHomePictureCheckSchema();
/*  507 */     aMHomePictureCheckSchema.setSchema(this);
/*  508 */     return aMHomePictureCheckSchema;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckDB getDB()
/*      */   {
/*  513 */     MHomePictureCheckDB aDBOper = new MHomePictureCheckDB();
/*  514 */     aDBOper.setSchema(this);
/*  515 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  522 */     StringBuffer strReturn = new StringBuffer(256);
/*  523 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  524 */     strReturn.append(StrTool.cTrim(this.uRL)); strReturn.append("|");
/*  525 */     strReturn.append(StrTool.cTrim(this.refURL)); strReturn.append("|");
/*  526 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  527 */     strReturn.append(StrTool.cTrim(this.alt)); strReturn.append("|");
/*  528 */     strReturn.append(ChgData.chgData(this.picOrder)); strReturn.append("|");
/*  529 */     strReturn.append(StrTool.cTrim(this.displayFlag)); strReturn.append("|");
/*  530 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  531 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  532 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  533 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  534 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  535 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  536 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  537 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  538 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  539 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  540 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  541 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  542 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  543 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  544 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  545 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  546 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  554 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  555 */       this.uRL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  556 */       this.refURL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  557 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  558 */       this.alt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  559 */       this.picOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/*  560 */       this.displayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  561 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  562 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  563 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  564 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
/*  565 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  566 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  567 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  568 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).intValue();
/*  569 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|"))).doubleValue();
/*  570 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  571 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  572 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  573 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  574 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  575 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  576 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  581 */       CError tError = new CError();
/*  582 */       tError.moduleName = "MHomePictureCheckSchema";
/*  583 */       tError.functionName = "decode";
/*  584 */       tError.errorMessage = ex.toString();
/*  585 */       this.mErrors.addOneError(tError);
/*      */ 
/*  587 */       return false;
/*      */     }
/*  589 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  595 */     String strReturn = "";
/*  596 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  598 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  600 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  602 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uRL));
/*      */     }
/*  604 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  606 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.refURL));
/*      */     }
/*  608 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  610 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  612 */     if (FCode.equalsIgnoreCase("alt"))
/*      */     {
/*  614 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.alt));
/*      */     }
/*  616 */     if (FCode.equalsIgnoreCase("picOrder"))
/*      */     {
/*  618 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.picOrder));
/*      */     }
/*  620 */     if (FCode.equalsIgnoreCase("displayFlag"))
/*      */     {
/*  622 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.displayFlag));
/*      */     }
/*  624 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  626 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  628 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  630 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  632 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  634 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  636 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  638 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  640 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  642 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  644 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  646 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  648 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  650 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  652 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  654 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  656 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  658 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  660 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  662 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  664 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  666 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  668 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  670 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  672 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  674 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  676 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  678 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  680 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  682 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  684 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  686 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  688 */     if (strReturn.equals(""))
/*      */     {
/*  690 */       strReturn = "null";
/*      */     }
/*      */ 
/*  693 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  700 */     String strFieldValue = "";
/*  701 */     switch (nFieldIndex) {
/*      */     case 0:
/*  703 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  704 */       break;
/*      */     case 1:
/*  706 */       strFieldValue = StrTool.GBKToUnicode(this.uRL);
/*  707 */       break;
/*      */     case 2:
/*  709 */       strFieldValue = StrTool.GBKToUnicode(this.refURL);
/*  710 */       break;
/*      */     case 3:
/*  712 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  713 */       break;
/*      */     case 4:
/*  715 */       strFieldValue = StrTool.GBKToUnicode(this.alt);
/*  716 */       break;
/*      */     case 5:
/*  718 */       strFieldValue = String.valueOf(this.picOrder);
/*  719 */       break;
/*      */     case 6:
/*  721 */       strFieldValue = StrTool.GBKToUnicode(this.displayFlag);
/*  722 */       break;
/*      */     case 7:
/*  724 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/*  725 */       break;
/*      */     case 8:
/*  727 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/*  728 */       break;
/*      */     case 9:
/*  730 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/*  731 */       break;
/*      */     case 10:
/*  733 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*  734 */       break;
/*      */     case 11:
/*  736 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/*  737 */       break;
/*      */     case 12:
/*  739 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  740 */       break;
/*      */     case 13:
/*  742 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  743 */       break;
/*      */     case 14:
/*  745 */       strFieldValue = String.valueOf(this.iF01);
/*  746 */       break;
/*      */     case 15:
/*  748 */       strFieldValue = String.valueOf(this.dF02);
/*  749 */       break;
/*      */     case 16:
/*  751 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  752 */       break;
/*      */     case 17:
/*  754 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  755 */       break;
/*      */     case 18:
/*  757 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  758 */       break;
/*      */     case 19:
/*  760 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  761 */       break;
/*      */     case 20:
/*  763 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  764 */       break;
/*      */     case 21:
/*  766 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  767 */       break;
/*      */     case 22:
/*  769 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  770 */       break;
/*      */     default:
/*  772 */       strFieldValue = "";
/*      */     }
/*  774 */     if (strFieldValue.equals("")) {
/*  775 */       strFieldValue = "null";
/*      */     }
/*  777 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  783 */     if (StrTool.cTrim(FCode).equals("")) {
/*  784 */       return false;
/*      */     }
/*  786 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  788 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  790 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  793 */         this.iD = null;
/*      */     }
/*  795 */     if (FCode.equalsIgnoreCase("uRL"))
/*      */     {
/*  797 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  799 */         this.uRL = FValue.trim();
/*      */       }
/*      */       else
/*  802 */         this.uRL = null;
/*      */     }
/*  804 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  806 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  808 */         this.refURL = FValue.trim();
/*      */       }
/*      */       else
/*  811 */         this.refURL = null;
/*      */     }
/*  813 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  815 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  817 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  820 */         this.name = null;
/*      */     }
/*  822 */     if (FCode.equalsIgnoreCase("alt"))
/*      */     {
/*  824 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  826 */         this.alt = FValue.trim();
/*      */       }
/*      */       else
/*  829 */         this.alt = null;
/*      */     }
/*  831 */     if (FCode.equalsIgnoreCase("picOrder"))
/*      */     {
/*  833 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  835 */         Integer tInteger = new Integer(FValue);
/*  836 */         int i = tInteger.intValue();
/*  837 */         this.picOrder = i;
/*      */       }
/*      */     }
/*  840 */     if (FCode.equalsIgnoreCase("displayFlag"))
/*      */     {
/*  842 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  844 */         this.displayFlag = FValue.trim();
/*      */       }
/*      */       else
/*  847 */         this.displayFlag = null;
/*      */     }
/*  849 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  851 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  853 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/*  856 */         this.checkState = null;
/*      */     }
/*  858 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  860 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  862 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/*  865 */         this.checkOperator = null;
/*      */     }
/*  867 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  869 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  871 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/*  874 */         this.checkReason = null;
/*      */     }
/*  876 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  878 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  880 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  883 */         this.checkDate = null;
/*      */     }
/*  885 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  887 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  889 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/*  892 */         this.checkTime = null;
/*      */     }
/*  894 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  896 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  898 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/*  901 */         this.vF01 = null;
/*      */     }
/*  903 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  905 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  907 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/*  910 */         this.nF01 = null;
/*      */     }
/*  912 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  914 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  916 */         Integer tInteger = new Integer(FValue);
/*  917 */         int i = tInteger.intValue();
/*  918 */         this.iF01 = i;
/*      */       }
/*      */     }
/*  921 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  923 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  925 */         Double tDouble = new Double(FValue);
/*  926 */         double d = tDouble.doubleValue();
/*  927 */         this.dF02 = d;
/*      */       }
/*      */     }
/*  930 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  932 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  934 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  937 */         this.date01 = null;
/*      */     }
/*  939 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  941 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  943 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  946 */         this.modifyOperator = null;
/*      */     }
/*  948 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  950 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  952 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  955 */         this.operator = null;
/*      */     }
/*  957 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  959 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  961 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  964 */         this.makeDate = null;
/*      */     }
/*  966 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  968 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  970 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  973 */         this.makeTime = null;
/*      */     }
/*  975 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  977 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  979 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  982 */         this.modifyDate = null;
/*      */     }
/*  984 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  986 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  988 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  991 */         this.modifyTime = null;
/*      */     }
/*  993 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  998 */     if (otherObject == null) return false;
/*  999 */     if (this == otherObject) return true;
/* 1000 */     if (getClass() != otherObject.getClass()) return false;
/* 1001 */     MHomePictureCheckSchema other = (MHomePictureCheckSchema)otherObject;
/* 1002 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 1003 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 1004 */     if ((this.uRL == null) && (other.getURL() != null)) return false;
/* 1005 */     if ((this.uRL != null) && (!this.uRL.equals(other.getURL()))) return false;
/* 1006 */     if ((this.refURL == null) && (other.getRefURL() != null)) return false;
/* 1007 */     if ((this.refURL != null) && (!this.refURL.equals(other.getRefURL()))) return false;
/* 1008 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 1009 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 1010 */     if ((this.alt == null) && (other.getAlt() != null)) return false;
/* 1011 */     if ((this.alt != null) && (!this.alt.equals(other.getAlt()))) return false;
/* 1012 */     if (this.picOrder != other.getPicOrder()) return false;
/* 1013 */     if ((this.displayFlag == null) && (other.getDisplayFlag() != null)) return false;
/* 1014 */     if ((this.displayFlag != null) && (!this.displayFlag.equals(other.getDisplayFlag()))) return false;
/* 1015 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1016 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1017 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1018 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1019 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1020 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1021 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1022 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1023 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1024 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1025 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1026 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1027 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1028 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1029 */     if (this.iF01 != other.getIF01()) return false;
/* 1030 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1031 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1032 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1033 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1034 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1035 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1036 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1037 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1038 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1039 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1040 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1041 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1042 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1043 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1044 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1051 */     return 23;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1057 */     if (strFieldName.equals("iD")) {
/* 1058 */       return 0;
/*      */     }
/* 1060 */     if (strFieldName.equals("uRL")) {
/* 1061 */       return 1;
/*      */     }
/* 1063 */     if (strFieldName.equals("refURL")) {
/* 1064 */       return 2;
/*      */     }
/* 1066 */     if (strFieldName.equals("name")) {
/* 1067 */       return 3;
/*      */     }
/* 1069 */     if (strFieldName.equals("alt")) {
/* 1070 */       return 4;
/*      */     }
/* 1072 */     if (strFieldName.equals("picOrder")) {
/* 1073 */       return 5;
/*      */     }
/* 1075 */     if (strFieldName.equals("displayFlag")) {
/* 1076 */       return 6;
/*      */     }
/* 1078 */     if (strFieldName.equals("checkState")) {
/* 1079 */       return 7;
/*      */     }
/* 1081 */     if (strFieldName.equals("checkOperator")) {
/* 1082 */       return 8;
/*      */     }
/* 1084 */     if (strFieldName.equals("checkReason")) {
/* 1085 */       return 9;
/*      */     }
/* 1087 */     if (strFieldName.equals("checkDate")) {
/* 1088 */       return 10;
/*      */     }
/* 1090 */     if (strFieldName.equals("checkTime")) {
/* 1091 */       return 11;
/*      */     }
/* 1093 */     if (strFieldName.equals("vF01")) {
/* 1094 */       return 12;
/*      */     }
/* 1096 */     if (strFieldName.equals("nF01")) {
/* 1097 */       return 13;
/*      */     }
/* 1099 */     if (strFieldName.equals("iF01")) {
/* 1100 */       return 14;
/*      */     }
/* 1102 */     if (strFieldName.equals("dF02")) {
/* 1103 */       return 15;
/*      */     }
/* 1105 */     if (strFieldName.equals("date01")) {
/* 1106 */       return 16;
/*      */     }
/* 1108 */     if (strFieldName.equals("modifyOperator")) {
/* 1109 */       return 17;
/*      */     }
/* 1111 */     if (strFieldName.equals("operator")) {
/* 1112 */       return 18;
/*      */     }
/* 1114 */     if (strFieldName.equals("makeDate")) {
/* 1115 */       return 19;
/*      */     }
/* 1117 */     if (strFieldName.equals("makeTime")) {
/* 1118 */       return 20;
/*      */     }
/* 1120 */     if (strFieldName.equals("modifyDate")) {
/* 1121 */       return 21;
/*      */     }
/* 1123 */     if (strFieldName.equals("modifyTime")) {
/* 1124 */       return 22;
/*      */     }
/* 1126 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1132 */     String strFieldName = "";
/* 1133 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1135 */       strFieldName = "iD";
/* 1136 */       break;
/*      */     case 1:
/* 1138 */       strFieldName = "uRL";
/* 1139 */       break;
/*      */     case 2:
/* 1141 */       strFieldName = "refURL";
/* 1142 */       break;
/*      */     case 3:
/* 1144 */       strFieldName = "name";
/* 1145 */       break;
/*      */     case 4:
/* 1147 */       strFieldName = "alt";
/* 1148 */       break;
/*      */     case 5:
/* 1150 */       strFieldName = "picOrder";
/* 1151 */       break;
/*      */     case 6:
/* 1153 */       strFieldName = "displayFlag";
/* 1154 */       break;
/*      */     case 7:
/* 1156 */       strFieldName = "checkState";
/* 1157 */       break;
/*      */     case 8:
/* 1159 */       strFieldName = "checkOperator";
/* 1160 */       break;
/*      */     case 9:
/* 1162 */       strFieldName = "checkReason";
/* 1163 */       break;
/*      */     case 10:
/* 1165 */       strFieldName = "checkDate";
/* 1166 */       break;
/*      */     case 11:
/* 1168 */       strFieldName = "checkTime";
/* 1169 */       break;
/*      */     case 12:
/* 1171 */       strFieldName = "vF01";
/* 1172 */       break;
/*      */     case 13:
/* 1174 */       strFieldName = "nF01";
/* 1175 */       break;
/*      */     case 14:
/* 1177 */       strFieldName = "iF01";
/* 1178 */       break;
/*      */     case 15:
/* 1180 */       strFieldName = "dF02";
/* 1181 */       break;
/*      */     case 16:
/* 1183 */       strFieldName = "date01";
/* 1184 */       break;
/*      */     case 17:
/* 1186 */       strFieldName = "modifyOperator";
/* 1187 */       break;
/*      */     case 18:
/* 1189 */       strFieldName = "operator";
/* 1190 */       break;
/*      */     case 19:
/* 1192 */       strFieldName = "makeDate";
/* 1193 */       break;
/*      */     case 20:
/* 1195 */       strFieldName = "makeTime";
/* 1196 */       break;
/*      */     case 21:
/* 1198 */       strFieldName = "modifyDate";
/* 1199 */       break;
/*      */     case 22:
/* 1201 */       strFieldName = "modifyTime";
/* 1202 */       break;
/*      */     default:
/* 1204 */       strFieldName = "";
/*      */     }
/* 1206 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1212 */     if (strFieldName.equals("iD")) {
/* 1213 */       return 0;
/*      */     }
/* 1215 */     if (strFieldName.equals("uRL")) {
/* 1216 */       return 0;
/*      */     }
/* 1218 */     if (strFieldName.equals("refURL")) {
/* 1219 */       return 0;
/*      */     }
/* 1221 */     if (strFieldName.equals("name")) {
/* 1222 */       return 0;
/*      */     }
/* 1224 */     if (strFieldName.equals("alt")) {
/* 1225 */       return 0;
/*      */     }
/* 1227 */     if (strFieldName.equals("picOrder")) {
/* 1228 */       return 3;
/*      */     }
/* 1230 */     if (strFieldName.equals("displayFlag")) {
/* 1231 */       return 0;
/*      */     }
/* 1233 */     if (strFieldName.equals("checkState")) {
/* 1234 */       return 0;
/*      */     }
/* 1236 */     if (strFieldName.equals("checkOperator")) {
/* 1237 */       return 0;
/*      */     }
/* 1239 */     if (strFieldName.equals("checkReason")) {
/* 1240 */       return 0;
/*      */     }
/* 1242 */     if (strFieldName.equals("checkDate")) {
/* 1243 */       return 1;
/*      */     }
/* 1245 */     if (strFieldName.equals("checkTime")) {
/* 1246 */       return 0;
/*      */     }
/* 1248 */     if (strFieldName.equals("vF01")) {
/* 1249 */       return 0;
/*      */     }
/* 1251 */     if (strFieldName.equals("nF01")) {
/* 1252 */       return 0;
/*      */     }
/* 1254 */     if (strFieldName.equals("iF01")) {
/* 1255 */       return 3;
/*      */     }
/* 1257 */     if (strFieldName.equals("dF02")) {
/* 1258 */       return 4;
/*      */     }
/* 1260 */     if (strFieldName.equals("date01")) {
/* 1261 */       return 1;
/*      */     }
/* 1263 */     if (strFieldName.equals("modifyOperator")) {
/* 1264 */       return 0;
/*      */     }
/* 1266 */     if (strFieldName.equals("operator")) {
/* 1267 */       return 0;
/*      */     }
/* 1269 */     if (strFieldName.equals("makeDate")) {
/* 1270 */       return 1;
/*      */     }
/* 1272 */     if (strFieldName.equals("makeTime")) {
/* 1273 */       return 0;
/*      */     }
/* 1275 */     if (strFieldName.equals("modifyDate")) {
/* 1276 */       return 1;
/*      */     }
/* 1278 */     if (strFieldName.equals("modifyTime")) {
/* 1279 */       return 0;
/*      */     }
/* 1281 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1287 */     int nFieldType = -1;
/* 1288 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1290 */       nFieldType = 0;
/* 1291 */       break;
/*      */     case 1:
/* 1293 */       nFieldType = 0;
/* 1294 */       break;
/*      */     case 2:
/* 1296 */       nFieldType = 0;
/* 1297 */       break;
/*      */     case 3:
/* 1299 */       nFieldType = 0;
/* 1300 */       break;
/*      */     case 4:
/* 1302 */       nFieldType = 0;
/* 1303 */       break;
/*      */     case 5:
/* 1305 */       nFieldType = 3;
/* 1306 */       break;
/*      */     case 6:
/* 1308 */       nFieldType = 0;
/* 1309 */       break;
/*      */     case 7:
/* 1311 */       nFieldType = 0;
/* 1312 */       break;
/*      */     case 8:
/* 1314 */       nFieldType = 0;
/* 1315 */       break;
/*      */     case 9:
/* 1317 */       nFieldType = 0;
/* 1318 */       break;
/*      */     case 10:
/* 1320 */       nFieldType = 1;
/* 1321 */       break;
/*      */     case 11:
/* 1323 */       nFieldType = 0;
/* 1324 */       break;
/*      */     case 12:
/* 1326 */       nFieldType = 0;
/* 1327 */       break;
/*      */     case 13:
/* 1329 */       nFieldType = 0;
/* 1330 */       break;
/*      */     case 14:
/* 1332 */       nFieldType = 3;
/* 1333 */       break;
/*      */     case 15:
/* 1335 */       nFieldType = 4;
/* 1336 */       break;
/*      */     case 16:
/* 1338 */       nFieldType = 1;
/* 1339 */       break;
/*      */     case 17:
/* 1341 */       nFieldType = 0;
/* 1342 */       break;
/*      */     case 18:
/* 1344 */       nFieldType = 0;
/* 1345 */       break;
/*      */     case 19:
/* 1347 */       nFieldType = 1;
/* 1348 */       break;
/*      */     case 20:
/* 1350 */       nFieldType = 0;
/* 1351 */       break;
/*      */     case 21:
/* 1353 */       nFieldType = 1;
/* 1354 */       break;
/*      */     case 22:
/* 1356 */       nFieldType = 0;
/* 1357 */       break;
/*      */     default:
/* 1359 */       nFieldType = -1;
/*      */     }
/* 1361 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MHomePictureCheckSchema
 * JD-Core Version:    0.6.0
 */