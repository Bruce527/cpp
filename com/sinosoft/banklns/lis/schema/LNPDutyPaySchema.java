/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPDutyPayDB;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class LNPDutyPaySchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String payPlanCode;
/*      */   private String payPlanName;
/*      */   private String type;
/*      */   private int payIntv;
/*      */   private String payEndYearFlag;
/*      */   private int payEndYear;
/*      */   private String payEndDateCalRef;
/*      */   private String payEndDateCalMode;
/*      */   private double defaultVal;
/*      */   private String calCode;
/*      */   private String cnterCalCode;
/*      */   private String othCalCode;
/*      */   private double rate;
/*      */   private double minPay;
/*      */   private double assuYield;
/*      */   private double feeRate;
/*      */   private String payToDateCalMode;
/*      */   private String urgePayFlag;
/*      */   private String payLackFlag;
/*      */   private String payOverFlag;
/*      */   private String payOverDeal;
/*      */   private String avoidPayFlag;
/*      */   private int gracePeriod;
/*      */   private String pubFlag;
/*      */   private String zeroFlag;
/*      */   private String needAcc;
/*      */   private String payAimClass;
/*      */   public static final int FIELDNUM = 27;
/*      */   private static String[] PK;
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPDutyPaySchema()
/*      */   {
/*   86 */     this.mErrors = new CErrors();
/*      */ 
/*   88 */     String[] pk = new String[1];
/*   89 */     pk[0] = "PayPlanCode";
/*      */ 
/*   91 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   98 */     LNPDutyPaySchema cloned = (LNPDutyPaySchema)super.clone();
/*   99 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  100 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  106 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getPayPlanCode()
/*      */   {
/*  111 */     return this.payPlanCode;
/*      */   }
/*      */ 
/*      */   public void setPayPlanCode(String aPayPlanCode) {
/*  115 */     this.payPlanCode = aPayPlanCode;
/*      */   }
/*      */ 
/*      */   public String getPayPlanName() {
/*  119 */     return this.payPlanName;
/*      */   }
/*      */ 
/*      */   public void setPayPlanName(String aPayPlanName) {
/*  123 */     this.payPlanName = aPayPlanName;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  127 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  131 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public int getPayIntv() {
/*  135 */     return this.payIntv;
/*      */   }
/*      */ 
/*      */   public void setPayIntv(int aPayIntv) {
/*  139 */     this.payIntv = aPayIntv;
/*      */   }
/*      */ 
/*      */   public void setPayIntv(String aPayIntv) {
/*  143 */     if ((aPayIntv != null) && (!aPayIntv.equals("")))
/*      */     {
/*  145 */       Integer tInteger = new Integer(aPayIntv);
/*  146 */       int i = tInteger.intValue();
/*  147 */       this.payIntv = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPayEndYearFlag()
/*      */   {
/*  153 */     return this.payEndYearFlag;
/*      */   }
/*      */ 
/*      */   public void setPayEndYearFlag(String aPayEndYearFlag) {
/*  157 */     this.payEndYearFlag = aPayEndYearFlag;
/*      */   }
/*      */ 
/*      */   public int getPayEndYear() {
/*  161 */     return this.payEndYear;
/*      */   }
/*      */ 
/*      */   public void setPayEndYear(int aPayEndYear) {
/*  165 */     this.payEndYear = aPayEndYear;
/*      */   }
/*      */ 
/*      */   public void setPayEndYear(String aPayEndYear) {
/*  169 */     if ((aPayEndYear != null) && (!aPayEndYear.equals("")))
/*      */     {
/*  171 */       Integer tInteger = new Integer(aPayEndYear);
/*  172 */       int i = tInteger.intValue();
/*  173 */       this.payEndYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPayEndDateCalRef()
/*      */   {
/*  179 */     return this.payEndDateCalRef;
/*      */   }
/*      */ 
/*      */   public void setPayEndDateCalRef(String aPayEndDateCalRef) {
/*  183 */     this.payEndDateCalRef = aPayEndDateCalRef;
/*      */   }
/*      */ 
/*      */   public String getPayEndDateCalMode() {
/*  187 */     return this.payEndDateCalMode;
/*      */   }
/*      */ 
/*      */   public void setPayEndDateCalMode(String aPayEndDateCalMode) {
/*  191 */     this.payEndDateCalMode = aPayEndDateCalMode;
/*      */   }
/*      */ 
/*      */   public double getDefaultVal() {
/*  195 */     return this.defaultVal;
/*      */   }
/*      */ 
/*      */   public void setDefaultVal(double aDefaultVal) {
/*  199 */     this.defaultVal = aDefaultVal;
/*      */   }
/*      */ 
/*      */   public void setDefaultVal(String aDefaultVal) {
/*  203 */     if ((aDefaultVal != null) && (!aDefaultVal.equals("")))
/*      */     {
/*  205 */       Double tDouble = new Double(aDefaultVal);
/*  206 */       double d = tDouble.doubleValue();
/*  207 */       this.defaultVal = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getCalCode()
/*      */   {
/*  213 */     return this.calCode;
/*      */   }
/*      */ 
/*      */   public void setCalCode(String aCalCode) {
/*  217 */     this.calCode = aCalCode;
/*      */   }
/*      */ 
/*      */   public String getCnterCalCode() {
/*  221 */     return this.cnterCalCode;
/*      */   }
/*      */ 
/*      */   public void setCnterCalCode(String aCnterCalCode) {
/*  225 */     this.cnterCalCode = aCnterCalCode;
/*      */   }
/*      */ 
/*      */   public String getOthCalCode() {
/*  229 */     return this.othCalCode;
/*      */   }
/*      */ 
/*      */   public void setOthCalCode(String aOthCalCode) {
/*  233 */     this.othCalCode = aOthCalCode;
/*      */   }
/*      */ 
/*      */   public double getRate() {
/*  237 */     return this.rate;
/*      */   }
/*      */ 
/*      */   public void setRate(double aRate) {
/*  241 */     this.rate = aRate;
/*      */   }
/*      */ 
/*      */   public void setRate(String aRate) {
/*  245 */     if ((aRate != null) && (!aRate.equals("")))
/*      */     {
/*  247 */       Double tDouble = new Double(aRate);
/*  248 */       double d = tDouble.doubleValue();
/*  249 */       this.rate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMinPay()
/*      */   {
/*  255 */     return this.minPay;
/*      */   }
/*      */ 
/*      */   public void setMinPay(double aMinPay) {
/*  259 */     this.minPay = aMinPay;
/*      */   }
/*      */ 
/*      */   public void setMinPay(String aMinPay) {
/*  263 */     if ((aMinPay != null) && (!aMinPay.equals("")))
/*      */     {
/*  265 */       Double tDouble = new Double(aMinPay);
/*  266 */       double d = tDouble.doubleValue();
/*  267 */       this.minPay = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAssuYield()
/*      */   {
/*  273 */     return this.assuYield;
/*      */   }
/*      */ 
/*      */   public void setAssuYield(double aAssuYield) {
/*  277 */     this.assuYield = aAssuYield;
/*      */   }
/*      */ 
/*      */   public void setAssuYield(String aAssuYield) {
/*  281 */     if ((aAssuYield != null) && (!aAssuYield.equals("")))
/*      */     {
/*  283 */       Double tDouble = new Double(aAssuYield);
/*  284 */       double d = tDouble.doubleValue();
/*  285 */       this.assuYield = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getFeeRate()
/*      */   {
/*  291 */     return this.feeRate;
/*      */   }
/*      */ 
/*      */   public void setFeeRate(double aFeeRate) {
/*  295 */     this.feeRate = aFeeRate;
/*      */   }
/*      */ 
/*      */   public void setFeeRate(String aFeeRate) {
/*  299 */     if ((aFeeRate != null) && (!aFeeRate.equals("")))
/*      */     {
/*  301 */       Double tDouble = new Double(aFeeRate);
/*  302 */       double d = tDouble.doubleValue();
/*  303 */       this.feeRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPayToDateCalMode()
/*      */   {
/*  309 */     return this.payToDateCalMode;
/*      */   }
/*      */ 
/*      */   public void setPayToDateCalMode(String aPayToDateCalMode) {
/*  313 */     this.payToDateCalMode = aPayToDateCalMode;
/*      */   }
/*      */ 
/*      */   public String getUrgePayFlag() {
/*  317 */     return this.urgePayFlag;
/*      */   }
/*      */ 
/*      */   public void setUrgePayFlag(String aUrgePayFlag) {
/*  321 */     this.urgePayFlag = aUrgePayFlag;
/*      */   }
/*      */ 
/*      */   public String getPayLackFlag() {
/*  325 */     return this.payLackFlag;
/*      */   }
/*      */ 
/*      */   public void setPayLackFlag(String aPayLackFlag) {
/*  329 */     this.payLackFlag = aPayLackFlag;
/*      */   }
/*      */ 
/*      */   public String getPayOverFlag() {
/*  333 */     return this.payOverFlag;
/*      */   }
/*      */ 
/*      */   public void setPayOverFlag(String aPayOverFlag) {
/*  337 */     this.payOverFlag = aPayOverFlag;
/*      */   }
/*      */ 
/*      */   public String getPayOverDeal() {
/*  341 */     return this.payOverDeal;
/*      */   }
/*      */ 
/*      */   public void setPayOverDeal(String aPayOverDeal) {
/*  345 */     this.payOverDeal = aPayOverDeal;
/*      */   }
/*      */ 
/*      */   public String getAvoidPayFlag() {
/*  349 */     return this.avoidPayFlag;
/*      */   }
/*      */ 
/*      */   public void setAvoidPayFlag(String aAvoidPayFlag) {
/*  353 */     this.avoidPayFlag = aAvoidPayFlag;
/*      */   }
/*      */ 
/*      */   public int getGracePeriod() {
/*  357 */     return this.gracePeriod;
/*      */   }
/*      */ 
/*      */   public void setGracePeriod(int aGracePeriod) {
/*  361 */     this.gracePeriod = aGracePeriod;
/*      */   }
/*      */ 
/*      */   public void setGracePeriod(String aGracePeriod) {
/*  365 */     if ((aGracePeriod != null) && (!aGracePeriod.equals("")))
/*      */     {
/*  367 */       Integer tInteger = new Integer(aGracePeriod);
/*  368 */       int i = tInteger.intValue();
/*  369 */       this.gracePeriod = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPubFlag()
/*      */   {
/*  375 */     return this.pubFlag;
/*      */   }
/*      */ 
/*      */   public void setPubFlag(String aPubFlag) {
/*  379 */     this.pubFlag = aPubFlag;
/*      */   }
/*      */ 
/*      */   public String getZeroFlag() {
/*  383 */     return this.zeroFlag;
/*      */   }
/*      */ 
/*      */   public void setZeroFlag(String aZeroFlag) {
/*  387 */     this.zeroFlag = aZeroFlag;
/*      */   }
/*      */ 
/*      */   public String getNeedAcc() {
/*  391 */     return this.needAcc;
/*      */   }
/*      */ 
/*      */   public void setNeedAcc(String aNeedAcc) {
/*  395 */     this.needAcc = aNeedAcc;
/*      */   }
/*      */ 
/*      */   public String getPayAimClass() {
/*  399 */     return this.payAimClass;
/*      */   }
/*      */ 
/*      */   public void setPayAimClass(String aPayAimClass) {
/*  403 */     this.payAimClass = aPayAimClass;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPDutyPaySchema aLNPDutyPaySchema)
/*      */   {
/*  409 */     this.payPlanCode = aLNPDutyPaySchema.getPayPlanCode();
/*  410 */     this.payPlanName = aLNPDutyPaySchema.getPayPlanName();
/*  411 */     this.type = aLNPDutyPaySchema.getType();
/*  412 */     this.payIntv = aLNPDutyPaySchema.getPayIntv();
/*  413 */     this.payEndYearFlag = aLNPDutyPaySchema.getPayEndYearFlag();
/*  414 */     this.payEndYear = aLNPDutyPaySchema.getPayEndYear();
/*  415 */     this.payEndDateCalRef = aLNPDutyPaySchema.getPayEndDateCalRef();
/*  416 */     this.payEndDateCalMode = aLNPDutyPaySchema.getPayEndDateCalMode();
/*  417 */     this.defaultVal = aLNPDutyPaySchema.getDefaultVal();
/*  418 */     this.calCode = aLNPDutyPaySchema.getCalCode();
/*  419 */     this.cnterCalCode = aLNPDutyPaySchema.getCnterCalCode();
/*  420 */     this.othCalCode = aLNPDutyPaySchema.getOthCalCode();
/*  421 */     this.rate = aLNPDutyPaySchema.getRate();
/*  422 */     this.minPay = aLNPDutyPaySchema.getMinPay();
/*  423 */     this.assuYield = aLNPDutyPaySchema.getAssuYield();
/*  424 */     this.feeRate = aLNPDutyPaySchema.getFeeRate();
/*  425 */     this.payToDateCalMode = aLNPDutyPaySchema.getPayToDateCalMode();
/*  426 */     this.urgePayFlag = aLNPDutyPaySchema.getUrgePayFlag();
/*  427 */     this.payLackFlag = aLNPDutyPaySchema.getPayLackFlag();
/*  428 */     this.payOverFlag = aLNPDutyPaySchema.getPayOverFlag();
/*  429 */     this.payOverDeal = aLNPDutyPaySchema.getPayOverDeal();
/*  430 */     this.avoidPayFlag = aLNPDutyPaySchema.getAvoidPayFlag();
/*  431 */     this.gracePeriod = aLNPDutyPaySchema.getGracePeriod();
/*  432 */     this.pubFlag = aLNPDutyPaySchema.getPubFlag();
/*  433 */     this.zeroFlag = aLNPDutyPaySchema.getZeroFlag();
/*  434 */     this.needAcc = aLNPDutyPaySchema.getNeedAcc();
/*  435 */     this.payAimClass = aLNPDutyPaySchema.getPayAimClass();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  444 */       if (rs.getString("PayPlanCode") == null)
/*  445 */         this.payPlanCode = null;
/*      */       else {
/*  447 */         this.payPlanCode = rs.getString("PayPlanCode").trim();
/*      */       }
/*  449 */       if (rs.getString("PayPlanName") == null)
/*  450 */         this.payPlanName = null;
/*      */       else {
/*  452 */         this.payPlanName = rs.getString("PayPlanName").trim();
/*      */       }
/*  454 */       if (rs.getString("Type") == null)
/*  455 */         this.type = null;
/*      */       else {
/*  457 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  459 */       this.payIntv = rs.getInt("PayIntv");
/*  460 */       if (rs.getString("PayEndYearFlag") == null)
/*  461 */         this.payEndYearFlag = null;
/*      */       else {
/*  463 */         this.payEndYearFlag = rs.getString("PayEndYearFlag").trim();
/*      */       }
/*  465 */       this.payEndYear = rs.getInt("PayEndYear");
/*  466 */       if (rs.getString("PayEndDateCalRef") == null)
/*  467 */         this.payEndDateCalRef = null;
/*      */       else {
/*  469 */         this.payEndDateCalRef = rs.getString("PayEndDateCalRef").trim();
/*      */       }
/*  471 */       if (rs.getString("PayEndDateCalMode") == null)
/*  472 */         this.payEndDateCalMode = null;
/*      */       else {
/*  474 */         this.payEndDateCalMode = rs.getString("PayEndDateCalMode").trim();
/*      */       }
/*  476 */       this.defaultVal = rs.getDouble("DefaultVal");
/*  477 */       if (rs.getString("CalCode") == null)
/*  478 */         this.calCode = null;
/*      */       else {
/*  480 */         this.calCode = rs.getString("CalCode").trim();
/*      */       }
/*  482 */       if (rs.getString("CnterCalCode") == null)
/*  483 */         this.cnterCalCode = null;
/*      */       else {
/*  485 */         this.cnterCalCode = rs.getString("CnterCalCode").trim();
/*      */       }
/*  487 */       if (rs.getString("OthCalCode") == null)
/*  488 */         this.othCalCode = null;
/*      */       else {
/*  490 */         this.othCalCode = rs.getString("OthCalCode").trim();
/*      */       }
/*  492 */       this.rate = rs.getDouble("Rate");
/*  493 */       this.minPay = rs.getDouble("MinPay");
/*  494 */       this.assuYield = rs.getDouble("AssuYield");
/*  495 */       this.feeRate = rs.getDouble("FeeRate");
/*  496 */       if (rs.getString("PayToDateCalMode") == null)
/*  497 */         this.payToDateCalMode = null;
/*      */       else {
/*  499 */         this.payToDateCalMode = rs.getString("PayToDateCalMode").trim();
/*      */       }
/*  501 */       if (rs.getString("UrgePayFlag") == null)
/*  502 */         this.urgePayFlag = null;
/*      */       else {
/*  504 */         this.urgePayFlag = rs.getString("UrgePayFlag").trim();
/*      */       }
/*  506 */       if (rs.getString("PayLackFlag") == null)
/*  507 */         this.payLackFlag = null;
/*      */       else {
/*  509 */         this.payLackFlag = rs.getString("PayLackFlag").trim();
/*      */       }
/*  511 */       if (rs.getString("PayOverFlag") == null)
/*  512 */         this.payOverFlag = null;
/*      */       else {
/*  514 */         this.payOverFlag = rs.getString("PayOverFlag").trim();
/*      */       }
/*  516 */       if (rs.getString("PayOverDeal") == null)
/*  517 */         this.payOverDeal = null;
/*      */       else {
/*  519 */         this.payOverDeal = rs.getString("PayOverDeal").trim();
/*      */       }
/*  521 */       if (rs.getString("AvoidPayFlag") == null)
/*  522 */         this.avoidPayFlag = null;
/*      */       else {
/*  524 */         this.avoidPayFlag = rs.getString("AvoidPayFlag").trim();
/*      */       }
/*  526 */       this.gracePeriod = rs.getInt("GracePeriod");
/*  527 */       if (rs.getString("PubFlag") == null)
/*  528 */         this.pubFlag = null;
/*      */       else {
/*  530 */         this.pubFlag = rs.getString("PubFlag").trim();
/*      */       }
/*  532 */       if (rs.getString("ZeroFlag") == null)
/*  533 */         this.zeroFlag = null;
/*      */       else {
/*  535 */         this.zeroFlag = rs.getString("ZeroFlag").trim();
/*      */       }
/*  537 */       if (rs.getString("NeedAcc") == null)
/*  538 */         this.needAcc = null;
/*      */       else {
/*  540 */         this.needAcc = rs.getString("NeedAcc").trim();
/*      */       }
/*  542 */       if (rs.getString("PayAimClass") == null)
/*  543 */         this.payAimClass = null;
/*      */       else {
/*  545 */         this.payAimClass = rs.getString("PayAimClass").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  550 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPDutyPay\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/*  552 */       CError tError = new CError();
/*  553 */       tError.moduleName = "LNPDutyPaySchema";
/*  554 */       tError.functionName = "setSchema";
/*  555 */       tError.errorMessage = sqle.toString();
/*  556 */       this.mErrors.addOneError(tError);
/*  557 */       return false;
/*      */     }
/*  559 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPDutyPaySchema getSchema()
/*      */   {
/*  564 */     LNPDutyPaySchema aLNPDutyPaySchema = new LNPDutyPaySchema();
/*  565 */     aLNPDutyPaySchema.setSchema(this);
/*  566 */     return aLNPDutyPaySchema;
/*      */   }
/*      */ 
/*      */   public LNPDutyPayDB getDB()
/*      */   {
/*  571 */     LNPDutyPayDB aDBOper = new LNPDutyPayDB();
/*  572 */     aDBOper.setSchema(this);
/*  573 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  580 */     StringBuffer strReturn = new StringBuffer(256);
/*  581 */     strReturn.append(StrTool.cTrim(this.payPlanCode)); strReturn.append("|");
/*  582 */     strReturn.append(StrTool.cTrim(this.payPlanName)); strReturn.append("|");
/*  583 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  584 */     strReturn.append(ChgData.chgData(this.payIntv)); strReturn.append("|");
/*  585 */     strReturn.append(StrTool.cTrim(this.payEndYearFlag)); strReturn.append("|");
/*  586 */     strReturn.append(ChgData.chgData(this.payEndYear)); strReturn.append("|");
/*  587 */     strReturn.append(StrTool.cTrim(this.payEndDateCalRef)); strReturn.append("|");
/*  588 */     strReturn.append(StrTool.cTrim(this.payEndDateCalMode)); strReturn.append("|");
/*  589 */     strReturn.append(ChgData.chgData(this.defaultVal)); strReturn.append("|");
/*  590 */     strReturn.append(StrTool.cTrim(this.calCode)); strReturn.append("|");
/*  591 */     strReturn.append(StrTool.cTrim(this.cnterCalCode)); strReturn.append("|");
/*  592 */     strReturn.append(StrTool.cTrim(this.othCalCode)); strReturn.append("|");
/*  593 */     strReturn.append(ChgData.chgData(this.rate)); strReturn.append("|");
/*  594 */     strReturn.append(ChgData.chgData(this.minPay)); strReturn.append("|");
/*  595 */     strReturn.append(ChgData.chgData(this.assuYield)); strReturn.append("|");
/*  596 */     strReturn.append(ChgData.chgData(this.feeRate)); strReturn.append("|");
/*  597 */     strReturn.append(StrTool.cTrim(this.payToDateCalMode)); strReturn.append("|");
/*  598 */     strReturn.append(StrTool.cTrim(this.urgePayFlag)); strReturn.append("|");
/*  599 */     strReturn.append(StrTool.cTrim(this.payLackFlag)); strReturn.append("|");
/*  600 */     strReturn.append(StrTool.cTrim(this.payOverFlag)); strReturn.append("|");
/*  601 */     strReturn.append(StrTool.cTrim(this.payOverDeal)); strReturn.append("|");
/*  602 */     strReturn.append(StrTool.cTrim(this.avoidPayFlag)); strReturn.append("|");
/*  603 */     strReturn.append(ChgData.chgData(this.gracePeriod)); strReturn.append("|");
/*  604 */     strReturn.append(StrTool.cTrim(this.pubFlag)); strReturn.append("|");
/*  605 */     strReturn.append(StrTool.cTrim(this.zeroFlag)); strReturn.append("|");
/*  606 */     strReturn.append(StrTool.cTrim(this.needAcc)); strReturn.append("|");
/*  607 */     strReturn.append(StrTool.cTrim(this.payAimClass));
/*  608 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  616 */       this.payPlanCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  617 */       this.payPlanName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  618 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  619 */       this.payIntv = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|"))).intValue();
/*  620 */       this.payEndYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  621 */       this.payEndYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/*  622 */       this.payEndDateCalRef = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  623 */       this.payEndDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  624 */       this.defaultVal = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).doubleValue();
/*  625 */       this.calCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  626 */       this.cnterCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  627 */       this.othCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  628 */       this.rate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).doubleValue();
/*  629 */       this.minPay = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|"))).doubleValue();
/*  630 */       this.assuYield = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).doubleValue();
/*  631 */       this.feeRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|"))).doubleValue();
/*  632 */       this.payToDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  633 */       this.urgePayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  634 */       this.payLackFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  635 */       this.payOverFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  636 */       this.payOverDeal = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  637 */       this.avoidPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  638 */       this.gracePeriod = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|"))).intValue();
/*  639 */       this.pubFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  640 */       this.zeroFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  641 */       this.needAcc = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  642 */       this.payAimClass = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  647 */       CError tError = new CError();
/*  648 */       tError.moduleName = "LNPDutyPaySchema";
/*  649 */       tError.functionName = "decode";
/*  650 */       tError.errorMessage = ex.toString();
/*  651 */       this.mErrors.addOneError(tError);
/*      */ 
/*  653 */       return false;
/*      */     }
/*  655 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  661 */     String strReturn = "";
/*  662 */     if (FCode.equalsIgnoreCase("payPlanCode"))
/*      */     {
/*  664 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payPlanCode));
/*      */     }
/*  666 */     if (FCode.equalsIgnoreCase("payPlanName"))
/*      */     {
/*  668 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payPlanName));
/*      */     }
/*  670 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  672 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("payIntv"))
/*      */     {
/*  676 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payIntv));
/*      */     }
/*  678 */     if (FCode.equalsIgnoreCase("payEndYearFlag"))
/*      */     {
/*  680 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndYearFlag));
/*      */     }
/*  682 */     if (FCode.equalsIgnoreCase("payEndYear"))
/*      */     {
/*  684 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndYear));
/*      */     }
/*  686 */     if (FCode.equalsIgnoreCase("payEndDateCalRef"))
/*      */     {
/*  688 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndDateCalRef));
/*      */     }
/*  690 */     if (FCode.equalsIgnoreCase("payEndDateCalMode"))
/*      */     {
/*  692 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndDateCalMode));
/*      */     }
/*  694 */     if (FCode.equalsIgnoreCase("defaultVal"))
/*      */     {
/*  696 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.defaultVal));
/*      */     }
/*  698 */     if (FCode.equalsIgnoreCase("calCode"))
/*      */     {
/*  700 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.calCode));
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("cnterCalCode"))
/*      */     {
/*  704 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.cnterCalCode));
/*      */     }
/*  706 */     if (FCode.equalsIgnoreCase("othCalCode"))
/*      */     {
/*  708 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.othCalCode));
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("rate"))
/*      */     {
/*  712 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rate));
/*      */     }
/*  714 */     if (FCode.equalsIgnoreCase("minPay"))
/*      */     {
/*  716 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minPay));
/*      */     }
/*  718 */     if (FCode.equalsIgnoreCase("assuYield"))
/*      */     {
/*  720 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.assuYield));
/*      */     }
/*  722 */     if (FCode.equalsIgnoreCase("feeRate"))
/*      */     {
/*  724 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.feeRate));
/*      */     }
/*  726 */     if (FCode.equalsIgnoreCase("payToDateCalMode"))
/*      */     {
/*  728 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payToDateCalMode));
/*      */     }
/*  730 */     if (FCode.equalsIgnoreCase("urgePayFlag"))
/*      */     {
/*  732 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.urgePayFlag));
/*      */     }
/*  734 */     if (FCode.equalsIgnoreCase("payLackFlag"))
/*      */     {
/*  736 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payLackFlag));
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("payOverFlag"))
/*      */     {
/*  740 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payOverFlag));
/*      */     }
/*  742 */     if (FCode.equalsIgnoreCase("payOverDeal"))
/*      */     {
/*  744 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payOverDeal));
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("avoidPayFlag"))
/*      */     {
/*  748 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.avoidPayFlag));
/*      */     }
/*  750 */     if (FCode.equalsIgnoreCase("gracePeriod"))
/*      */     {
/*  752 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.gracePeriod));
/*      */     }
/*  754 */     if (FCode.equalsIgnoreCase("pubFlag"))
/*      */     {
/*  756 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pubFlag));
/*      */     }
/*  758 */     if (FCode.equalsIgnoreCase("zeroFlag"))
/*      */     {
/*  760 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.zeroFlag));
/*      */     }
/*  762 */     if (FCode.equalsIgnoreCase("needAcc"))
/*      */     {
/*  764 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.needAcc));
/*      */     }
/*  766 */     if (FCode.equalsIgnoreCase("payAimClass"))
/*      */     {
/*  768 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payAimClass));
/*      */     }
/*  770 */     if (strReturn.equals(""))
/*      */     {
/*  772 */       strReturn = "null";
/*      */     }
/*      */ 
/*  775 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  782 */     String strFieldValue = "";
/*  783 */     switch (nFieldIndex) {
/*      */     case 0:
/*  785 */       strFieldValue = StrTool.GBKToUnicode(this.payPlanCode);
/*  786 */       break;
/*      */     case 1:
/*  788 */       strFieldValue = StrTool.GBKToUnicode(this.payPlanName);
/*  789 */       break;
/*      */     case 2:
/*  791 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  792 */       break;
/*      */     case 3:
/*  794 */       strFieldValue = String.valueOf(this.payIntv);
/*  795 */       break;
/*      */     case 4:
/*  797 */       strFieldValue = StrTool.GBKToUnicode(this.payEndYearFlag);
/*  798 */       break;
/*      */     case 5:
/*  800 */       strFieldValue = String.valueOf(this.payEndYear);
/*  801 */       break;
/*      */     case 6:
/*  803 */       strFieldValue = StrTool.GBKToUnicode(this.payEndDateCalRef);
/*  804 */       break;
/*      */     case 7:
/*  806 */       strFieldValue = StrTool.GBKToUnicode(this.payEndDateCalMode);
/*  807 */       break;
/*      */     case 8:
/*  809 */       strFieldValue = String.valueOf(this.defaultVal);
/*  810 */       break;
/*      */     case 9:
/*  812 */       strFieldValue = StrTool.GBKToUnicode(this.calCode);
/*  813 */       break;
/*      */     case 10:
/*  815 */       strFieldValue = StrTool.GBKToUnicode(this.cnterCalCode);
/*  816 */       break;
/*      */     case 11:
/*  818 */       strFieldValue = StrTool.GBKToUnicode(this.othCalCode);
/*  819 */       break;
/*      */     case 12:
/*  821 */       strFieldValue = String.valueOf(this.rate);
/*  822 */       break;
/*      */     case 13:
/*  824 */       strFieldValue = String.valueOf(this.minPay);
/*  825 */       break;
/*      */     case 14:
/*  827 */       strFieldValue = String.valueOf(this.assuYield);
/*  828 */       break;
/*      */     case 15:
/*  830 */       strFieldValue = String.valueOf(this.feeRate);
/*  831 */       break;
/*      */     case 16:
/*  833 */       strFieldValue = StrTool.GBKToUnicode(this.payToDateCalMode);
/*  834 */       break;
/*      */     case 17:
/*  836 */       strFieldValue = StrTool.GBKToUnicode(this.urgePayFlag);
/*  837 */       break;
/*      */     case 18:
/*  839 */       strFieldValue = StrTool.GBKToUnicode(this.payLackFlag);
/*  840 */       break;
/*      */     case 19:
/*  842 */       strFieldValue = StrTool.GBKToUnicode(this.payOverFlag);
/*  843 */       break;
/*      */     case 20:
/*  845 */       strFieldValue = StrTool.GBKToUnicode(this.payOverDeal);
/*  846 */       break;
/*      */     case 21:
/*  848 */       strFieldValue = StrTool.GBKToUnicode(this.avoidPayFlag);
/*  849 */       break;
/*      */     case 22:
/*  851 */       strFieldValue = String.valueOf(this.gracePeriod);
/*  852 */       break;
/*      */     case 23:
/*  854 */       strFieldValue = StrTool.GBKToUnicode(this.pubFlag);
/*  855 */       break;
/*      */     case 24:
/*  857 */       strFieldValue = StrTool.GBKToUnicode(this.zeroFlag);
/*  858 */       break;
/*      */     case 25:
/*  860 */       strFieldValue = StrTool.GBKToUnicode(this.needAcc);
/*  861 */       break;
/*      */     case 26:
/*  863 */       strFieldValue = StrTool.GBKToUnicode(this.payAimClass);
/*  864 */       break;
/*      */     default:
/*  866 */       strFieldValue = "";
/*      */     }
/*  868 */     if (strFieldValue.equals("")) {
/*  869 */       strFieldValue = "null";
/*      */     }
/*  871 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  877 */     if (StrTool.cTrim(FCode).equals("")) {
/*  878 */       return false;
/*      */     }
/*  880 */     if (FCode.equalsIgnoreCase("payPlanCode"))
/*      */     {
/*  882 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  884 */         this.payPlanCode = FValue.trim();
/*      */       }
/*      */       else
/*  887 */         this.payPlanCode = null;
/*      */     }
/*  889 */     if (FCode.equalsIgnoreCase("payPlanName"))
/*      */     {
/*  891 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  893 */         this.payPlanName = FValue.trim();
/*      */       }
/*      */       else
/*  896 */         this.payPlanName = null;
/*      */     }
/*  898 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  900 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  902 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/*  905 */         this.type = null;
/*      */     }
/*  907 */     if (FCode.equalsIgnoreCase("payIntv"))
/*      */     {
/*  909 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  911 */         Integer tInteger = new Integer(FValue);
/*  912 */         int i = tInteger.intValue();
/*  913 */         this.payIntv = i;
/*      */       }
/*      */     }
/*  916 */     if (FCode.equalsIgnoreCase("payEndYearFlag"))
/*      */     {
/*  918 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  920 */         this.payEndYearFlag = FValue.trim();
/*      */       }
/*      */       else
/*  923 */         this.payEndYearFlag = null;
/*      */     }
/*  925 */     if (FCode.equalsIgnoreCase("payEndYear"))
/*      */     {
/*  927 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  929 */         Integer tInteger = new Integer(FValue);
/*  930 */         int i = tInteger.intValue();
/*  931 */         this.payEndYear = i;
/*      */       }
/*      */     }
/*  934 */     if (FCode.equalsIgnoreCase("payEndDateCalRef"))
/*      */     {
/*  936 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  938 */         this.payEndDateCalRef = FValue.trim();
/*      */       }
/*      */       else
/*  941 */         this.payEndDateCalRef = null;
/*      */     }
/*  943 */     if (FCode.equalsIgnoreCase("payEndDateCalMode"))
/*      */     {
/*  945 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  947 */         this.payEndDateCalMode = FValue.trim();
/*      */       }
/*      */       else
/*  950 */         this.payEndDateCalMode = null;
/*      */     }
/*  952 */     if (FCode.equalsIgnoreCase("defaultVal"))
/*      */     {
/*  954 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  956 */         Double tDouble = new Double(FValue);
/*  957 */         double d = tDouble.doubleValue();
/*  958 */         this.defaultVal = d;
/*      */       }
/*      */     }
/*  961 */     if (FCode.equalsIgnoreCase("calCode"))
/*      */     {
/*  963 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  965 */         this.calCode = FValue.trim();
/*      */       }
/*      */       else
/*  968 */         this.calCode = null;
/*      */     }
/*  970 */     if (FCode.equalsIgnoreCase("cnterCalCode"))
/*      */     {
/*  972 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  974 */         this.cnterCalCode = FValue.trim();
/*      */       }
/*      */       else
/*  977 */         this.cnterCalCode = null;
/*      */     }
/*  979 */     if (FCode.equalsIgnoreCase("othCalCode"))
/*      */     {
/*  981 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  983 */         this.othCalCode = FValue.trim();
/*      */       }
/*      */       else
/*  986 */         this.othCalCode = null;
/*      */     }
/*  988 */     if (FCode.equalsIgnoreCase("rate"))
/*      */     {
/*  990 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  992 */         Double tDouble = new Double(FValue);
/*  993 */         double d = tDouble.doubleValue();
/*  994 */         this.rate = d;
/*      */       }
/*      */     }
/*  997 */     if (FCode.equalsIgnoreCase("minPay"))
/*      */     {
/*  999 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1001 */         Double tDouble = new Double(FValue);
/* 1002 */         double d = tDouble.doubleValue();
/* 1003 */         this.minPay = d;
/*      */       }
/*      */     }
/* 1006 */     if (FCode.equalsIgnoreCase("assuYield"))
/*      */     {
/* 1008 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1010 */         Double tDouble = new Double(FValue);
/* 1011 */         double d = tDouble.doubleValue();
/* 1012 */         this.assuYield = d;
/*      */       }
/*      */     }
/* 1015 */     if (FCode.equalsIgnoreCase("feeRate"))
/*      */     {
/* 1017 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1019 */         Double tDouble = new Double(FValue);
/* 1020 */         double d = tDouble.doubleValue();
/* 1021 */         this.feeRate = d;
/*      */       }
/*      */     }
/* 1024 */     if (FCode.equalsIgnoreCase("payToDateCalMode"))
/*      */     {
/* 1026 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1028 */         this.payToDateCalMode = FValue.trim();
/*      */       }
/*      */       else
/* 1031 */         this.payToDateCalMode = null;
/*      */     }
/* 1033 */     if (FCode.equalsIgnoreCase("urgePayFlag"))
/*      */     {
/* 1035 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1037 */         this.urgePayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1040 */         this.urgePayFlag = null;
/*      */     }
/* 1042 */     if (FCode.equalsIgnoreCase("payLackFlag"))
/*      */     {
/* 1044 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1046 */         this.payLackFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1049 */         this.payLackFlag = null;
/*      */     }
/* 1051 */     if (FCode.equalsIgnoreCase("payOverFlag"))
/*      */     {
/* 1053 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1055 */         this.payOverFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1058 */         this.payOverFlag = null;
/*      */     }
/* 1060 */     if (FCode.equalsIgnoreCase("payOverDeal"))
/*      */     {
/* 1062 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1064 */         this.payOverDeal = FValue.trim();
/*      */       }
/*      */       else
/* 1067 */         this.payOverDeal = null;
/*      */     }
/* 1069 */     if (FCode.equalsIgnoreCase("avoidPayFlag"))
/*      */     {
/* 1071 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1073 */         this.avoidPayFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1076 */         this.avoidPayFlag = null;
/*      */     }
/* 1078 */     if (FCode.equalsIgnoreCase("gracePeriod"))
/*      */     {
/* 1080 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1082 */         Integer tInteger = new Integer(FValue);
/* 1083 */         int i = tInteger.intValue();
/* 1084 */         this.gracePeriod = i;
/*      */       }
/*      */     }
/* 1087 */     if (FCode.equalsIgnoreCase("pubFlag"))
/*      */     {
/* 1089 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1091 */         this.pubFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1094 */         this.pubFlag = null;
/*      */     }
/* 1096 */     if (FCode.equalsIgnoreCase("zeroFlag"))
/*      */     {
/* 1098 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1100 */         this.zeroFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1103 */         this.zeroFlag = null;
/*      */     }
/* 1105 */     if (FCode.equalsIgnoreCase("needAcc"))
/*      */     {
/* 1107 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1109 */         this.needAcc = FValue.trim();
/*      */       }
/*      */       else
/* 1112 */         this.needAcc = null;
/*      */     }
/* 1114 */     if (FCode.equalsIgnoreCase("payAimClass"))
/*      */     {
/* 1116 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1118 */         this.payAimClass = FValue.trim();
/*      */       }
/*      */       else
/* 1121 */         this.payAimClass = null;
/*      */     }
/* 1123 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1128 */     if (otherObject == null) return false;
/* 1129 */     if (this == otherObject) return true;
/* 1130 */     if (getClass() != otherObject.getClass()) return false;
/* 1131 */     LNPDutyPaySchema other = (LNPDutyPaySchema)otherObject;
/* 1132 */     if ((this.payPlanCode == null) && (other.getPayPlanCode() != null)) return false;
/* 1133 */     if ((this.payPlanCode != null) && (!this.payPlanCode.equals(other.getPayPlanCode()))) return false;
/* 1134 */     if ((this.payPlanName == null) && (other.getPayPlanName() != null)) return false;
/* 1135 */     if ((this.payPlanName != null) && (!this.payPlanName.equals(other.getPayPlanName()))) return false;
/* 1136 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 1137 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 1138 */     if (this.payIntv != other.getPayIntv()) return false;
/* 1139 */     if ((this.payEndYearFlag == null) && (other.getPayEndYearFlag() != null)) return false;
/* 1140 */     if ((this.payEndYearFlag != null) && (!this.payEndYearFlag.equals(other.getPayEndYearFlag()))) return false;
/* 1141 */     if (this.payEndYear != other.getPayEndYear()) return false;
/* 1142 */     if ((this.payEndDateCalRef == null) && (other.getPayEndDateCalRef() != null)) return false;
/* 1143 */     if ((this.payEndDateCalRef != null) && (!this.payEndDateCalRef.equals(other.getPayEndDateCalRef()))) return false;
/* 1144 */     if ((this.payEndDateCalMode == null) && (other.getPayEndDateCalMode() != null)) return false;
/* 1145 */     if ((this.payEndDateCalMode != null) && (!this.payEndDateCalMode.equals(other.getPayEndDateCalMode()))) return false;
/* 1146 */     if (Double.doubleToLongBits(this.defaultVal) != Double.doubleToLongBits(other.getDefaultVal())) return false;
/* 1147 */     if ((this.calCode == null) && (other.getCalCode() != null)) return false;
/* 1148 */     if ((this.calCode != null) && (!this.calCode.equals(other.getCalCode()))) return false;
/* 1149 */     if ((this.cnterCalCode == null) && (other.getCnterCalCode() != null)) return false;
/* 1150 */     if ((this.cnterCalCode != null) && (!this.cnterCalCode.equals(other.getCnterCalCode()))) return false;
/* 1151 */     if ((this.othCalCode == null) && (other.getOthCalCode() != null)) return false;
/* 1152 */     if ((this.othCalCode != null) && (!this.othCalCode.equals(other.getOthCalCode()))) return false;
/* 1153 */     if (Double.doubleToLongBits(this.rate) != Double.doubleToLongBits(other.getRate())) return false;
/* 1154 */     if (Double.doubleToLongBits(this.minPay) != Double.doubleToLongBits(other.getMinPay())) return false;
/* 1155 */     if (Double.doubleToLongBits(this.assuYield) != Double.doubleToLongBits(other.getAssuYield())) return false;
/* 1156 */     if (Double.doubleToLongBits(this.feeRate) != Double.doubleToLongBits(other.getFeeRate())) return false;
/* 1157 */     if ((this.payToDateCalMode == null) && (other.getPayToDateCalMode() != null)) return false;
/* 1158 */     if ((this.payToDateCalMode != null) && (!this.payToDateCalMode.equals(other.getPayToDateCalMode()))) return false;
/* 1159 */     if ((this.urgePayFlag == null) && (other.getUrgePayFlag() != null)) return false;
/* 1160 */     if ((this.urgePayFlag != null) && (!this.urgePayFlag.equals(other.getUrgePayFlag()))) return false;
/* 1161 */     if ((this.payLackFlag == null) && (other.getPayLackFlag() != null)) return false;
/* 1162 */     if ((this.payLackFlag != null) && (!this.payLackFlag.equals(other.getPayLackFlag()))) return false;
/* 1163 */     if ((this.payOverFlag == null) && (other.getPayOverFlag() != null)) return false;
/* 1164 */     if ((this.payOverFlag != null) && (!this.payOverFlag.equals(other.getPayOverFlag()))) return false;
/* 1165 */     if ((this.payOverDeal == null) && (other.getPayOverDeal() != null)) return false;
/* 1166 */     if ((this.payOverDeal != null) && (!this.payOverDeal.equals(other.getPayOverDeal()))) return false;
/* 1167 */     if ((this.avoidPayFlag == null) && (other.getAvoidPayFlag() != null)) return false;
/* 1168 */     if ((this.avoidPayFlag != null) && (!this.avoidPayFlag.equals(other.getAvoidPayFlag()))) return false;
/* 1169 */     if (this.gracePeriod != other.getGracePeriod()) return false;
/* 1170 */     if ((this.pubFlag == null) && (other.getPubFlag() != null)) return false;
/* 1171 */     if ((this.pubFlag != null) && (!this.pubFlag.equals(other.getPubFlag()))) return false;
/* 1172 */     if ((this.zeroFlag == null) && (other.getZeroFlag() != null)) return false;
/* 1173 */     if ((this.zeroFlag != null) && (!this.zeroFlag.equals(other.getZeroFlag()))) return false;
/* 1174 */     if ((this.needAcc == null) && (other.getNeedAcc() != null)) return false;
/* 1175 */     if ((this.needAcc != null) && (!this.needAcc.equals(other.getNeedAcc()))) return false;
/* 1176 */     if ((this.payAimClass == null) && (other.getPayAimClass() != null)) return false;
/* 1177 */     return (this.payAimClass == null) || (this.payAimClass.equals(other.getPayAimClass()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1184 */     return 27;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1190 */     if (strFieldName.equals("payPlanCode")) {
/* 1191 */       return 0;
/*      */     }
/* 1193 */     if (strFieldName.equals("payPlanName")) {
/* 1194 */       return 1;
/*      */     }
/* 1196 */     if (strFieldName.equals("type")) {
/* 1197 */       return 2;
/*      */     }
/* 1199 */     if (strFieldName.equals("payIntv")) {
/* 1200 */       return 3;
/*      */     }
/* 1202 */     if (strFieldName.equals("payEndYearFlag")) {
/* 1203 */       return 4;
/*      */     }
/* 1205 */     if (strFieldName.equals("payEndYear")) {
/* 1206 */       return 5;
/*      */     }
/* 1208 */     if (strFieldName.equals("payEndDateCalRef")) {
/* 1209 */       return 6;
/*      */     }
/* 1211 */     if (strFieldName.equals("payEndDateCalMode")) {
/* 1212 */       return 7;
/*      */     }
/* 1214 */     if (strFieldName.equals("defaultVal")) {
/* 1215 */       return 8;
/*      */     }
/* 1217 */     if (strFieldName.equals("calCode")) {
/* 1218 */       return 9;
/*      */     }
/* 1220 */     if (strFieldName.equals("cnterCalCode")) {
/* 1221 */       return 10;
/*      */     }
/* 1223 */     if (strFieldName.equals("othCalCode")) {
/* 1224 */       return 11;
/*      */     }
/* 1226 */     if (strFieldName.equals("rate")) {
/* 1227 */       return 12;
/*      */     }
/* 1229 */     if (strFieldName.equals("minPay")) {
/* 1230 */       return 13;
/*      */     }
/* 1232 */     if (strFieldName.equals("assuYield")) {
/* 1233 */       return 14;
/*      */     }
/* 1235 */     if (strFieldName.equals("feeRate")) {
/* 1236 */       return 15;
/*      */     }
/* 1238 */     if (strFieldName.equals("payToDateCalMode")) {
/* 1239 */       return 16;
/*      */     }
/* 1241 */     if (strFieldName.equals("urgePayFlag")) {
/* 1242 */       return 17;
/*      */     }
/* 1244 */     if (strFieldName.equals("payLackFlag")) {
/* 1245 */       return 18;
/*      */     }
/* 1247 */     if (strFieldName.equals("payOverFlag")) {
/* 1248 */       return 19;
/*      */     }
/* 1250 */     if (strFieldName.equals("payOverDeal")) {
/* 1251 */       return 20;
/*      */     }
/* 1253 */     if (strFieldName.equals("avoidPayFlag")) {
/* 1254 */       return 21;
/*      */     }
/* 1256 */     if (strFieldName.equals("gracePeriod")) {
/* 1257 */       return 22;
/*      */     }
/* 1259 */     if (strFieldName.equals("pubFlag")) {
/* 1260 */       return 23;
/*      */     }
/* 1262 */     if (strFieldName.equals("zeroFlag")) {
/* 1263 */       return 24;
/*      */     }
/* 1265 */     if (strFieldName.equals("needAcc")) {
/* 1266 */       return 25;
/*      */     }
/* 1268 */     if (strFieldName.equals("payAimClass")) {
/* 1269 */       return 26;
/*      */     }
/* 1271 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1277 */     String strFieldName = "";
/* 1278 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1280 */       strFieldName = "payPlanCode";
/* 1281 */       break;
/*      */     case 1:
/* 1283 */       strFieldName = "payPlanName";
/* 1284 */       break;
/*      */     case 2:
/* 1286 */       strFieldName = "type";
/* 1287 */       break;
/*      */     case 3:
/* 1289 */       strFieldName = "payIntv";
/* 1290 */       break;
/*      */     case 4:
/* 1292 */       strFieldName = "payEndYearFlag";
/* 1293 */       break;
/*      */     case 5:
/* 1295 */       strFieldName = "payEndYear";
/* 1296 */       break;
/*      */     case 6:
/* 1298 */       strFieldName = "payEndDateCalRef";
/* 1299 */       break;
/*      */     case 7:
/* 1301 */       strFieldName = "payEndDateCalMode";
/* 1302 */       break;
/*      */     case 8:
/* 1304 */       strFieldName = "defaultVal";
/* 1305 */       break;
/*      */     case 9:
/* 1307 */       strFieldName = "calCode";
/* 1308 */       break;
/*      */     case 10:
/* 1310 */       strFieldName = "cnterCalCode";
/* 1311 */       break;
/*      */     case 11:
/* 1313 */       strFieldName = "othCalCode";
/* 1314 */       break;
/*      */     case 12:
/* 1316 */       strFieldName = "rate";
/* 1317 */       break;
/*      */     case 13:
/* 1319 */       strFieldName = "minPay";
/* 1320 */       break;
/*      */     case 14:
/* 1322 */       strFieldName = "assuYield";
/* 1323 */       break;
/*      */     case 15:
/* 1325 */       strFieldName = "feeRate";
/* 1326 */       break;
/*      */     case 16:
/* 1328 */       strFieldName = "payToDateCalMode";
/* 1329 */       break;
/*      */     case 17:
/* 1331 */       strFieldName = "urgePayFlag";
/* 1332 */       break;
/*      */     case 18:
/* 1334 */       strFieldName = "payLackFlag";
/* 1335 */       break;
/*      */     case 19:
/* 1337 */       strFieldName = "payOverFlag";
/* 1338 */       break;
/*      */     case 20:
/* 1340 */       strFieldName = "payOverDeal";
/* 1341 */       break;
/*      */     case 21:
/* 1343 */       strFieldName = "avoidPayFlag";
/* 1344 */       break;
/*      */     case 22:
/* 1346 */       strFieldName = "gracePeriod";
/* 1347 */       break;
/*      */     case 23:
/* 1349 */       strFieldName = "pubFlag";
/* 1350 */       break;
/*      */     case 24:
/* 1352 */       strFieldName = "zeroFlag";
/* 1353 */       break;
/*      */     case 25:
/* 1355 */       strFieldName = "needAcc";
/* 1356 */       break;
/*      */     case 26:
/* 1358 */       strFieldName = "payAimClass";
/* 1359 */       break;
/*      */     default:
/* 1361 */       strFieldName = "";
/*      */     }
/* 1363 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1369 */     if (strFieldName.equals("payPlanCode")) {
/* 1370 */       return 0;
/*      */     }
/* 1372 */     if (strFieldName.equals("payPlanName")) {
/* 1373 */       return 0;
/*      */     }
/* 1375 */     if (strFieldName.equals("type")) {
/* 1376 */       return 0;
/*      */     }
/* 1378 */     if (strFieldName.equals("payIntv")) {
/* 1379 */       return 3;
/*      */     }
/* 1381 */     if (strFieldName.equals("payEndYearFlag")) {
/* 1382 */       return 0;
/*      */     }
/* 1384 */     if (strFieldName.equals("payEndYear")) {
/* 1385 */       return 3;
/*      */     }
/* 1387 */     if (strFieldName.equals("payEndDateCalRef")) {
/* 1388 */       return 0;
/*      */     }
/* 1390 */     if (strFieldName.equals("payEndDateCalMode")) {
/* 1391 */       return 0;
/*      */     }
/* 1393 */     if (strFieldName.equals("defaultVal")) {
/* 1394 */       return 4;
/*      */     }
/* 1396 */     if (strFieldName.equals("calCode")) {
/* 1397 */       return 0;
/*      */     }
/* 1399 */     if (strFieldName.equals("cnterCalCode")) {
/* 1400 */       return 0;
/*      */     }
/* 1402 */     if (strFieldName.equals("othCalCode")) {
/* 1403 */       return 0;
/*      */     }
/* 1405 */     if (strFieldName.equals("rate")) {
/* 1406 */       return 4;
/*      */     }
/* 1408 */     if (strFieldName.equals("minPay")) {
/* 1409 */       return 4;
/*      */     }
/* 1411 */     if (strFieldName.equals("assuYield")) {
/* 1412 */       return 4;
/*      */     }
/* 1414 */     if (strFieldName.equals("feeRate")) {
/* 1415 */       return 4;
/*      */     }
/* 1417 */     if (strFieldName.equals("payToDateCalMode")) {
/* 1418 */       return 0;
/*      */     }
/* 1420 */     if (strFieldName.equals("urgePayFlag")) {
/* 1421 */       return 0;
/*      */     }
/* 1423 */     if (strFieldName.equals("payLackFlag")) {
/* 1424 */       return 0;
/*      */     }
/* 1426 */     if (strFieldName.equals("payOverFlag")) {
/* 1427 */       return 0;
/*      */     }
/* 1429 */     if (strFieldName.equals("payOverDeal")) {
/* 1430 */       return 0;
/*      */     }
/* 1432 */     if (strFieldName.equals("avoidPayFlag")) {
/* 1433 */       return 0;
/*      */     }
/* 1435 */     if (strFieldName.equals("gracePeriod")) {
/* 1436 */       return 3;
/*      */     }
/* 1438 */     if (strFieldName.equals("pubFlag")) {
/* 1439 */       return 0;
/*      */     }
/* 1441 */     if (strFieldName.equals("zeroFlag")) {
/* 1442 */       return 0;
/*      */     }
/* 1444 */     if (strFieldName.equals("needAcc")) {
/* 1445 */       return 0;
/*      */     }
/* 1447 */     if (strFieldName.equals("payAimClass")) {
/* 1448 */       return 0;
/*      */     }
/* 1450 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1456 */     int nFieldType = -1;
/* 1457 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1459 */       nFieldType = 0;
/* 1460 */       break;
/*      */     case 1:
/* 1462 */       nFieldType = 0;
/* 1463 */       break;
/*      */     case 2:
/* 1465 */       nFieldType = 0;
/* 1466 */       break;
/*      */     case 3:
/* 1468 */       nFieldType = 3;
/* 1469 */       break;
/*      */     case 4:
/* 1471 */       nFieldType = 0;
/* 1472 */       break;
/*      */     case 5:
/* 1474 */       nFieldType = 3;
/* 1475 */       break;
/*      */     case 6:
/* 1477 */       nFieldType = 0;
/* 1478 */       break;
/*      */     case 7:
/* 1480 */       nFieldType = 0;
/* 1481 */       break;
/*      */     case 8:
/* 1483 */       nFieldType = 4;
/* 1484 */       break;
/*      */     case 9:
/* 1486 */       nFieldType = 0;
/* 1487 */       break;
/*      */     case 10:
/* 1489 */       nFieldType = 0;
/* 1490 */       break;
/*      */     case 11:
/* 1492 */       nFieldType = 0;
/* 1493 */       break;
/*      */     case 12:
/* 1495 */       nFieldType = 4;
/* 1496 */       break;
/*      */     case 13:
/* 1498 */       nFieldType = 4;
/* 1499 */       break;
/*      */     case 14:
/* 1501 */       nFieldType = 4;
/* 1502 */       break;
/*      */     case 15:
/* 1504 */       nFieldType = 4;
/* 1505 */       break;
/*      */     case 16:
/* 1507 */       nFieldType = 0;
/* 1508 */       break;
/*      */     case 17:
/* 1510 */       nFieldType = 0;
/* 1511 */       break;
/*      */     case 18:
/* 1513 */       nFieldType = 0;
/* 1514 */       break;
/*      */     case 19:
/* 1516 */       nFieldType = 0;
/* 1517 */       break;
/*      */     case 20:
/* 1519 */       nFieldType = 0;
/* 1520 */       break;
/*      */     case 21:
/* 1522 */       nFieldType = 0;
/* 1523 */       break;
/*      */     case 22:
/* 1525 */       nFieldType = 3;
/* 1526 */       break;
/*      */     case 23:
/* 1528 */       nFieldType = 0;
/* 1529 */       break;
/*      */     case 24:
/* 1531 */       nFieldType = 0;
/* 1532 */       break;
/*      */     case 25:
/* 1534 */       nFieldType = 0;
/* 1535 */       break;
/*      */     case 26:
/* 1537 */       nFieldType = 0;
/* 1538 */       break;
/*      */     default:
/* 1540 */       nFieldType = -1;
/*      */     }
/* 1542 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPDutyPaySchema
 * JD-Core Version:    0.6.0
 */