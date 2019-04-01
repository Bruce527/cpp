/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestmentInfoDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPInvestmentInfoSchema
/*      */   implements Schema
/*      */ {
/*      */   private String ID;
/*      */   private String ContNo;
/*      */   private double StockInvestAccount;
/*      */   private double MixedStockInvestAccount;
/*      */   private double MixedBondInvestAccount;
/*      */   private double BondInvestAccount;
/*      */   private double CurrencyInvestAccount;
/*      */   private String PayExtraPremFlag;
/*      */   private double MonthPlusPrem;
/*      */   private String TermInvestment;
/*      */   private String HesInvestment;
/*      */   private String Operator;
/*      */   private String MakeDate;
/*      */   private String MakeTime;
/*      */   private String ModifyDate;
/*      */   private String ModifyTime;
/*      */   private String Remark;
/*      */   private String Varc1;
/*      */   private String Varc2;
/*      */   private String Varc3;
/*      */   private String Varc4;
/*      */   private Date DateTime1;
/*      */   private Date DateTime2;
/*      */   public static final int FIELDNUM = 23;
/*      */   private static String[] PK;
/*   71 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPInvestmentInfoSchema()
/*      */   {
/*   78 */     this.mErrors = new CErrors();
/*      */ 
/*   80 */     String[] pk = new String[1];
/*   81 */     pk[0] = "ID";
/*      */ 
/*   83 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   89 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*   94 */     if (this.ID != null) this.ID.equals("");
/*      */ 
/*   98 */     return this.ID;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  102 */     this.ID = aID;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  106 */     if (this.ContNo != null) this.ContNo.equals("");
/*      */ 
/*  110 */     return this.ContNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  114 */     this.ContNo = aContNo;
/*      */   }
/*      */ 
/*      */   public double getStockInvestAccount() {
/*  118 */     return this.StockInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setStockInvestAccount(double aStockInvestAccount) {
/*  122 */     this.StockInvestAccount = aStockInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setStockInvestAccount(String aStockInvestAccount) {
/*  126 */     if ((aStockInvestAccount != null) && (!aStockInvestAccount.equals("")))
/*      */     {
/*  128 */       Double tDouble = new Double(aStockInvestAccount);
/*  129 */       double d = tDouble.doubleValue();
/*  130 */       this.StockInvestAccount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMixedStockInvestAccount()
/*      */   {
/*  136 */     return this.MixedStockInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setMixedStockInvestAccount(double aMixedStockInvestAccount) {
/*  140 */     this.MixedStockInvestAccount = aMixedStockInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setMixedStockInvestAccount(String aMixedStockInvestAccount) {
/*  144 */     if ((aMixedStockInvestAccount != null) && (!aMixedStockInvestAccount.equals("")))
/*      */     {
/*  146 */       Double tDouble = new Double(aMixedStockInvestAccount);
/*  147 */       double d = tDouble.doubleValue();
/*  148 */       this.MixedStockInvestAccount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMixedBondInvestAccount()
/*      */   {
/*  154 */     return this.MixedBondInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setMixedBondInvestAccount(double aMixedBondInvestAccount) {
/*  158 */     this.MixedBondInvestAccount = aMixedBondInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setMixedBondInvestAccount(String aMixedBondInvestAccount) {
/*  162 */     if ((aMixedBondInvestAccount != null) && (!aMixedBondInvestAccount.equals("")))
/*      */     {
/*  164 */       Double tDouble = new Double(aMixedBondInvestAccount);
/*  165 */       double d = tDouble.doubleValue();
/*  166 */       this.MixedBondInvestAccount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getBondInvestAccount()
/*      */   {
/*  172 */     return this.BondInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setBondInvestAccount(double aBondInvestAccount) {
/*  176 */     this.BondInvestAccount = aBondInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setBondInvestAccount(String aBondInvestAccount) {
/*  180 */     if ((aBondInvestAccount != null) && (!aBondInvestAccount.equals("")))
/*      */     {
/*  182 */       Double tDouble = new Double(aBondInvestAccount);
/*  183 */       double d = tDouble.doubleValue();
/*  184 */       this.BondInvestAccount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getCurrencyInvestAccount()
/*      */   {
/*  190 */     return this.CurrencyInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setCurrencyInvestAccount(double aCurrencyInvestAccount) {
/*  194 */     this.CurrencyInvestAccount = aCurrencyInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setCurrencyInvestAccount(String aCurrencyInvestAccount) {
/*  198 */     if ((aCurrencyInvestAccount != null) && (!aCurrencyInvestAccount.equals("")))
/*      */     {
/*  200 */       Double tDouble = new Double(aCurrencyInvestAccount);
/*  201 */       double d = tDouble.doubleValue();
/*  202 */       this.CurrencyInvestAccount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPayExtraPremFlag()
/*      */   {
/*  208 */     if (this.PayExtraPremFlag != null) this.PayExtraPremFlag.equals("");
/*      */ 
/*  212 */     return this.PayExtraPremFlag;
/*      */   }
/*      */ 
/*      */   public void setPayExtraPremFlag(String aPayExtraPremFlag) {
/*  216 */     this.PayExtraPremFlag = aPayExtraPremFlag;
/*      */   }
/*      */ 
/*      */   public double getMonthPlusPrem() {
/*  220 */     return this.MonthPlusPrem;
/*      */   }
/*      */ 
/*      */   public void setMonthPlusPrem(double aMonthPlusPrem) {
/*  224 */     this.MonthPlusPrem = aMonthPlusPrem;
/*      */   }
/*      */ 
/*      */   public void setMonthPlusPrem(String aMonthPlusPrem) {
/*  228 */     if ((aMonthPlusPrem != null) && (!aMonthPlusPrem.equals("")))
/*      */     {
/*  230 */       Double tDouble = new Double(aMonthPlusPrem);
/*  231 */       double d = tDouble.doubleValue();
/*  232 */       this.MonthPlusPrem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getTermInvestment()
/*      */   {
/*  238 */     if (this.TermInvestment != null) this.TermInvestment.equals("");
/*      */ 
/*  242 */     return this.TermInvestment;
/*      */   }
/*      */ 
/*      */   public void setTermInvestment(String aTermInvestment) {
/*  246 */     this.TermInvestment = aTermInvestment;
/*      */   }
/*      */ 
/*      */   public String getHesInvestment() {
/*  250 */     if (this.HesInvestment != null) this.HesInvestment.equals("");
/*      */ 
/*  254 */     return this.HesInvestment;
/*      */   }
/*      */ 
/*      */   public void setHesInvestment(String aHesInvestment) {
/*  258 */     this.HesInvestment = aHesInvestment;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  262 */     if (this.Operator != null) this.Operator.equals("");
/*      */ 
/*  266 */     return this.Operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  270 */     this.Operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  274 */     if (this.MakeDate != null) this.MakeDate.equals("");
/*      */ 
/*  278 */     return this.MakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  282 */     this.MakeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public String getMakeTime() {
/*  286 */     if (this.MakeTime != null) this.MakeTime.equals("");
/*      */ 
/*  290 */     return this.MakeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  294 */     this.MakeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  298 */     if (this.ModifyDate != null) this.ModifyDate.equals("");
/*      */ 
/*  302 */     return this.ModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  306 */     this.ModifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public String getModifyTime() {
/*  310 */     if (this.ModifyTime != null) this.ModifyTime.equals("");
/*      */ 
/*  314 */     return this.ModifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  318 */     this.ModifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getRemark() {
/*  322 */     if (this.Remark != null) this.Remark.equals("");
/*      */ 
/*  326 */     return this.Remark;
/*      */   }
/*      */ 
/*      */   public void setRemark(String aRemark) {
/*  330 */     this.Remark = aRemark;
/*      */   }
/*      */ 
/*      */   public String getVarc1() {
/*  334 */     if (this.Varc1 != null) this.Varc1.equals("");
/*      */ 
/*  338 */     return this.Varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  342 */     this.Varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  346 */     if (this.Varc2 != null) this.Varc2.equals("");
/*      */ 
/*  350 */     return this.Varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  354 */     this.Varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getVarc3() {
/*  358 */     if (this.Varc3 != null) this.Varc3.equals("");
/*      */ 
/*  362 */     return this.Varc3;
/*      */   }
/*      */ 
/*      */   public void setVarc3(String aVarc3) {
/*  366 */     this.Varc3 = aVarc3;
/*      */   }
/*      */ 
/*      */   public String getVarc4() {
/*  370 */     if (this.Varc4 != null) this.Varc4.equals("");
/*      */ 
/*  374 */     return this.Varc4;
/*      */   }
/*      */ 
/*      */   public void setVarc4(String aVarc4) {
/*  378 */     this.Varc4 = aVarc4;
/*      */   }
/*      */ 
/*      */   public String getDateTime1() {
/*  382 */     if (this.DateTime1 != null) {
/*  383 */       return this.fDate.getString(this.DateTime1);
/*      */     }
/*  385 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(Date aDateTime1) {
/*  389 */     this.DateTime1 = aDateTime1;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(String aDateTime1) {
/*  393 */     if ((aDateTime1 != null) && (!aDateTime1.equals("")))
/*      */     {
/*  395 */       this.DateTime1 = this.fDate.getDate(aDateTime1);
/*      */     }
/*      */     else
/*  398 */       this.DateTime1 = null;
/*      */   }
/*      */ 
/*      */   public String getDateTime2()
/*      */   {
/*  403 */     if (this.DateTime2 != null) {
/*  404 */       return this.fDate.getString(this.DateTime2);
/*      */     }
/*  406 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(Date aDateTime2) {
/*  410 */     this.DateTime2 = aDateTime2;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(String aDateTime2) {
/*  414 */     if ((aDateTime2 != null) && (!aDateTime2.equals("")))
/*      */     {
/*  416 */       this.DateTime2 = this.fDate.getDate(aDateTime2);
/*      */     }
/*      */     else
/*  419 */       this.DateTime2 = null;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPInvestmentInfoSchema aLNPInvestmentInfoSchema)
/*      */   {
/*  426 */     this.ID = aLNPInvestmentInfoSchema.getID();
/*  427 */     this.ContNo = aLNPInvestmentInfoSchema.getContNo();
/*  428 */     this.StockInvestAccount = aLNPInvestmentInfoSchema.getStockInvestAccount();
/*  429 */     this.MixedStockInvestAccount = aLNPInvestmentInfoSchema.getMixedStockInvestAccount();
/*  430 */     this.MixedBondInvestAccount = aLNPInvestmentInfoSchema.getMixedBondInvestAccount();
/*  431 */     this.BondInvestAccount = aLNPInvestmentInfoSchema.getBondInvestAccount();
/*  432 */     this.CurrencyInvestAccount = aLNPInvestmentInfoSchema.getCurrencyInvestAccount();
/*  433 */     this.PayExtraPremFlag = aLNPInvestmentInfoSchema.getPayExtraPremFlag();
/*  434 */     this.MonthPlusPrem = aLNPInvestmentInfoSchema.getMonthPlusPrem();
/*  435 */     this.TermInvestment = aLNPInvestmentInfoSchema.getTermInvestment();
/*  436 */     this.HesInvestment = aLNPInvestmentInfoSchema.getHesInvestment();
/*  437 */     this.Operator = aLNPInvestmentInfoSchema.getOperator();
/*  438 */     this.MakeDate = aLNPInvestmentInfoSchema.getMakeDate();
/*  439 */     this.MakeTime = aLNPInvestmentInfoSchema.getMakeTime();
/*  440 */     this.ModifyDate = aLNPInvestmentInfoSchema.getModifyDate();
/*  441 */     this.ModifyTime = aLNPInvestmentInfoSchema.getModifyTime();
/*  442 */     this.Remark = aLNPInvestmentInfoSchema.getRemark();
/*  443 */     this.Varc1 = aLNPInvestmentInfoSchema.getVarc1();
/*  444 */     this.Varc2 = aLNPInvestmentInfoSchema.getVarc2();
/*  445 */     this.Varc3 = aLNPInvestmentInfoSchema.getVarc3();
/*  446 */     this.Varc4 = aLNPInvestmentInfoSchema.getVarc4();
/*  447 */     this.DateTime1 = this.fDate.getDate(aLNPInvestmentInfoSchema.getDateTime1());
/*  448 */     this.DateTime2 = this.fDate.getDate(aLNPInvestmentInfoSchema.getDateTime2());
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  457 */       if (rs.getString("ID") == null)
/*  458 */         this.ID = null;
/*      */       else {
/*  460 */         this.ID = rs.getString("ID").trim();
/*      */       }
/*  462 */       if (rs.getString("ContNo") == null)
/*  463 */         this.ContNo = null;
/*      */       else {
/*  465 */         this.ContNo = rs.getString("ContNo").trim();
/*      */       }
/*  467 */       this.StockInvestAccount = rs.getDouble("StockInvestAccount");
/*  468 */       this.MixedStockInvestAccount = rs.getDouble("MixedStockInvestAccount");
/*  469 */       this.MixedBondInvestAccount = rs.getDouble("MixedBondInvestAccount");
/*  470 */       this.BondInvestAccount = rs.getDouble("BondInvestAccount");
/*  471 */       this.CurrencyInvestAccount = rs.getDouble("CurrencyInvestAccount");
/*  472 */       if (rs.getString("PayExtraPremFlag") == null)
/*  473 */         this.PayExtraPremFlag = null;
/*      */       else {
/*  475 */         this.PayExtraPremFlag = rs.getString("PayExtraPremFlag").trim();
/*      */       }
/*  477 */       this.MonthPlusPrem = rs.getDouble("MonthPlusPrem");
/*  478 */       if (rs.getString("TermInvestment") == null)
/*  479 */         this.TermInvestment = null;
/*      */       else {
/*  481 */         this.TermInvestment = rs.getString("TermInvestment").trim();
/*      */       }
/*  483 */       if (rs.getString("HesInvestment") == null)
/*  484 */         this.HesInvestment = null;
/*      */       else {
/*  486 */         this.HesInvestment = rs.getString("HesInvestment").trim();
/*      */       }
/*  488 */       if (rs.getString("Operator") == null)
/*  489 */         this.Operator = null;
/*      */       else {
/*  491 */         this.Operator = rs.getString("Operator").trim();
/*      */       }
/*  493 */       if (rs.getString("MakeDate") == null)
/*  494 */         this.MakeDate = null;
/*      */       else {
/*  496 */         this.MakeDate = rs.getString("MakeDate").trim();
/*      */       }
/*  498 */       if (rs.getString("MakeTime") == null)
/*  499 */         this.MakeTime = null;
/*      */       else {
/*  501 */         this.MakeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  503 */       if (rs.getString("ModifyDate") == null)
/*  504 */         this.ModifyDate = null;
/*      */       else {
/*  506 */         this.ModifyDate = rs.getString("ModifyDate").trim();
/*      */       }
/*  508 */       if (rs.getString("ModifyTime") == null)
/*  509 */         this.ModifyTime = null;
/*      */       else {
/*  511 */         this.ModifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  513 */       if (rs.getString("Remark") == null)
/*  514 */         this.Remark = null;
/*      */       else {
/*  516 */         this.Remark = rs.getString("Remark").trim();
/*      */       }
/*  518 */       if (rs.getString("Varc1") == null)
/*  519 */         this.Varc1 = null;
/*      */       else {
/*  521 */         this.Varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  523 */       if (rs.getString("Varc2") == null)
/*  524 */         this.Varc2 = null;
/*      */       else {
/*  526 */         this.Varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  528 */       if (rs.getString("Varc3") == null)
/*  529 */         this.Varc3 = null;
/*      */       else {
/*  531 */         this.Varc3 = rs.getString("Varc3").trim();
/*      */       }
/*  533 */       if (rs.getString("Varc4") == null)
/*  534 */         this.Varc4 = null;
/*      */       else {
/*  536 */         this.Varc4 = rs.getString("Varc4").trim();
/*      */       }
/*  538 */       this.DateTime1 = rs.getDate("DateTime1");
/*  539 */       this.DateTime2 = rs.getDate("DateTime2");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  544 */       CError tError = new CError();
/*  545 */       tError.moduleName = "LNPInvestmentInfoSchema";
/*  546 */       tError.functionName = "setSchema";
/*  547 */       tError.errorMessage = sqle.toString();
/*  548 */       this.mErrors.addOneError(tError);
/*      */ 
/*  550 */       return false;
/*      */     }
/*  552 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInvestmentInfoSchema getSchema()
/*      */   {
/*  557 */     LNPInvestmentInfoSchema aLNPInvestmentInfoSchema = new LNPInvestmentInfoSchema();
/*  558 */     aLNPInvestmentInfoSchema.setSchema(this);
/*  559 */     return aLNPInvestmentInfoSchema;
/*      */   }
/*      */ 
/*      */   public LNPInvestmentInfoDB getDB()
/*      */   {
/*  564 */     LNPInvestmentInfoDB aDBOper = new LNPInvestmentInfoDB();
/*  565 */     aDBOper.setSchema(this);
/*  566 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  573 */     String strReturn = "";
/*  574 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.ID)) + "|" + 
/*  575 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ContNo)) + "|" + 
/*  576 */       ChgData.chgData(this.StockInvestAccount) + "|" + 
/*  577 */       ChgData.chgData(this.MixedStockInvestAccount) + "|" + 
/*  578 */       ChgData.chgData(this.MixedBondInvestAccount) + "|" + 
/*  579 */       ChgData.chgData(this.BondInvestAccount) + "|" + 
/*  580 */       ChgData.chgData(this.CurrencyInvestAccount) + "|" + 
/*  581 */       StrTool.cTrim(StrTool.unicodeToGBK(this.PayExtraPremFlag)) + "|" + 
/*  582 */       ChgData.chgData(this.MonthPlusPrem) + "|" + 
/*  583 */       StrTool.cTrim(StrTool.unicodeToGBK(this.TermInvestment)) + "|" + 
/*  584 */       StrTool.cTrim(StrTool.unicodeToGBK(this.HesInvestment)) + "|" + 
/*  585 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Operator)) + "|" + 
/*  586 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeDate)) + "|" + 
/*  587 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeTime)) + "|" + 
/*  588 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyDate)) + "|" + 
/*  589 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyTime)) + "|" + 
/*  590 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Remark)) + "|" + 
/*  591 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc1)) + "|" + 
/*  592 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc2)) + "|" + 
/*  593 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc3)) + "|" + 
/*  594 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc4)) + "|" + 
/*  595 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime1))) + "|" + 
/*  596 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime2)));
/*  597 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  605 */       this.ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  606 */       this.ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  607 */       this.StockInvestAccount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 3, "|"))).doubleValue();
/*  608 */       this.MixedStockInvestAccount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|"))).doubleValue();
/*  609 */       this.MixedBondInvestAccount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|"))).doubleValue();
/*  610 */       this.BondInvestAccount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).doubleValue();
/*  611 */       this.CurrencyInvestAccount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).doubleValue();
/*  612 */       this.PayExtraPremFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  613 */       this.MonthPlusPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).doubleValue();
/*  614 */       this.TermInvestment = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  615 */       this.HesInvestment = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  616 */       this.Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  617 */       this.MakeDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  618 */       this.MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  619 */       this.ModifyDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  620 */       this.ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  621 */       this.Remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  622 */       this.Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  623 */       this.Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  624 */       this.Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  625 */       this.Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  626 */       this.DateTime1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  627 */       this.DateTime2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  632 */       CError tError = new CError();
/*  633 */       tError.moduleName = "LNPInvestmentInfoSchema";
/*  634 */       tError.functionName = "decode";
/*  635 */       tError.errorMessage = ex.toString();
/*  636 */       this.mErrors.addOneError(tError);
/*      */ 
/*  638 */       return false;
/*      */     }
/*  640 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  646 */     String strReturn = "";
/*  647 */     if (FCode.equals("ID"))
/*      */     {
/*  649 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ID));
/*      */     }
/*  651 */     if (FCode.equals("ContNo"))
/*      */     {
/*  653 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ContNo));
/*      */     }
/*  655 */     if (FCode.equals("StockInvestAccount"))
/*      */     {
/*  657 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.StockInvestAccount));
/*      */     }
/*  659 */     if (FCode.equals("MixedStockInvestAccount"))
/*      */     {
/*  661 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MixedStockInvestAccount));
/*      */     }
/*  663 */     if (FCode.equals("MixedBondInvestAccount"))
/*      */     {
/*  665 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MixedBondInvestAccount));
/*      */     }
/*  667 */     if (FCode.equals("BondInvestAccount"))
/*      */     {
/*  669 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BondInvestAccount));
/*      */     }
/*  671 */     if (FCode.equals("CurrencyInvestAccount"))
/*      */     {
/*  673 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.CurrencyInvestAccount));
/*      */     }
/*  675 */     if (FCode.equals("PayExtraPremFlag"))
/*      */     {
/*  677 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.PayExtraPremFlag));
/*      */     }
/*  679 */     if (FCode.equals("MonthPlusPrem"))
/*      */     {
/*  681 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MonthPlusPrem));
/*      */     }
/*  683 */     if (FCode.equals("TermInvestment"))
/*      */     {
/*  685 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.TermInvestment));
/*      */     }
/*  687 */     if (FCode.equals("HesInvestment"))
/*      */     {
/*  689 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.HesInvestment));
/*      */     }
/*  691 */     if (FCode.equals("Operator"))
/*      */     {
/*  693 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Operator));
/*      */     }
/*  695 */     if (FCode.equals("MakeDate"))
/*      */     {
/*  697 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeDate));
/*      */     }
/*  699 */     if (FCode.equals("MakeTime"))
/*      */     {
/*  701 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeTime));
/*      */     }
/*  703 */     if (FCode.equals("ModifyDate"))
/*      */     {
/*  705 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyDate));
/*      */     }
/*  707 */     if (FCode.equals("ModifyTime"))
/*      */     {
/*  709 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyTime));
/*      */     }
/*  711 */     if (FCode.equals("Remark"))
/*      */     {
/*  713 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Remark));
/*      */     }
/*  715 */     if (FCode.equals("Varc1"))
/*      */     {
/*  717 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc1));
/*      */     }
/*  719 */     if (FCode.equals("Varc2"))
/*      */     {
/*  721 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc2));
/*      */     }
/*  723 */     if (FCode.equals("Varc3"))
/*      */     {
/*  725 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc3));
/*      */     }
/*  727 */     if (FCode.equals("Varc4"))
/*      */     {
/*  729 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc4));
/*      */     }
/*  731 */     if (FCode.equals("DateTime1"))
/*      */     {
/*  733 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*      */     }
/*  735 */     if (FCode.equals("DateTime2"))
/*      */     {
/*  737 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*      */     }
/*  739 */     if (strReturn.equals(""))
/*      */     {
/*  741 */       strReturn = "null";
/*      */     }
/*      */ 
/*  744 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  751 */     String strFieldValue = "";
/*  752 */     switch (nFieldIndex) {
/*      */     case 0:
/*  754 */       strFieldValue = StrTool.GBKToUnicode(this.ID);
/*  755 */       break;
/*      */     case 1:
/*  757 */       strFieldValue = StrTool.GBKToUnicode(this.ContNo);
/*  758 */       break;
/*      */     case 2:
/*  760 */       strFieldValue = String.valueOf(this.StockInvestAccount);
/*  761 */       break;
/*      */     case 3:
/*  763 */       strFieldValue = String.valueOf(this.MixedStockInvestAccount);
/*  764 */       break;
/*      */     case 4:
/*  766 */       strFieldValue = String.valueOf(this.MixedBondInvestAccount);
/*  767 */       break;
/*      */     case 5:
/*  769 */       strFieldValue = String.valueOf(this.BondInvestAccount);
/*  770 */       break;
/*      */     case 6:
/*  772 */       strFieldValue = String.valueOf(this.CurrencyInvestAccount);
/*  773 */       break;
/*      */     case 7:
/*  775 */       strFieldValue = StrTool.GBKToUnicode(this.PayExtraPremFlag);
/*  776 */       break;
/*      */     case 8:
/*  778 */       strFieldValue = String.valueOf(this.MonthPlusPrem);
/*  779 */       break;
/*      */     case 9:
/*  781 */       strFieldValue = StrTool.GBKToUnicode(this.TermInvestment);
/*  782 */       break;
/*      */     case 10:
/*  784 */       strFieldValue = StrTool.GBKToUnicode(this.HesInvestment);
/*  785 */       break;
/*      */     case 11:
/*  787 */       strFieldValue = StrTool.GBKToUnicode(this.Operator);
/*  788 */       break;
/*      */     case 12:
/*  790 */       strFieldValue = StrTool.GBKToUnicode(this.MakeDate);
/*  791 */       break;
/*      */     case 13:
/*  793 */       strFieldValue = StrTool.GBKToUnicode(this.MakeTime);
/*  794 */       break;
/*      */     case 14:
/*  796 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyDate);
/*  797 */       break;
/*      */     case 15:
/*  799 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyTime);
/*  800 */       break;
/*      */     case 16:
/*  802 */       strFieldValue = StrTool.GBKToUnicode(this.Remark);
/*  803 */       break;
/*      */     case 17:
/*  805 */       strFieldValue = StrTool.GBKToUnicode(this.Varc1);
/*  806 */       break;
/*      */     case 18:
/*  808 */       strFieldValue = StrTool.GBKToUnicode(this.Varc2);
/*  809 */       break;
/*      */     case 19:
/*  811 */       strFieldValue = StrTool.GBKToUnicode(this.Varc3);
/*  812 */       break;
/*      */     case 20:
/*  814 */       strFieldValue = StrTool.GBKToUnicode(this.Varc4);
/*  815 */       break;
/*      */     case 21:
/*  817 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*  818 */       break;
/*      */     case 22:
/*  820 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*  821 */       break;
/*      */     default:
/*  823 */       strFieldValue = "";
/*      */     }
/*  825 */     if (strFieldValue.equals("")) {
/*  826 */       strFieldValue = "null";
/*      */     }
/*  828 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  834 */     if (StrTool.cTrim(FCode).equals("")) {
/*  835 */       return false;
/*      */     }
/*  837 */     if (FCode.equals("ID"))
/*      */     {
/*  839 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  841 */         this.ID = FValue.trim();
/*      */       }
/*      */       else
/*  844 */         this.ID = null;
/*      */     }
/*  846 */     if (FCode.equals("ContNo"))
/*      */     {
/*  848 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  850 */         this.ContNo = FValue.trim();
/*      */       }
/*      */       else
/*  853 */         this.ContNo = null;
/*      */     }
/*  855 */     if (FCode.equals("StockInvestAccount"))
/*      */     {
/*  857 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  859 */         Double tDouble = new Double(FValue);
/*  860 */         double d = tDouble.doubleValue();
/*  861 */         this.StockInvestAccount = d;
/*      */       }
/*      */     }
/*  864 */     if (FCode.equals("MixedStockInvestAccount"))
/*      */     {
/*  866 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  868 */         Double tDouble = new Double(FValue);
/*  869 */         double d = tDouble.doubleValue();
/*  870 */         this.MixedStockInvestAccount = d;
/*      */       }
/*      */     }
/*  873 */     if (FCode.equals("MixedBondInvestAccount"))
/*      */     {
/*  875 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  877 */         Double tDouble = new Double(FValue);
/*  878 */         double d = tDouble.doubleValue();
/*  879 */         this.MixedBondInvestAccount = d;
/*      */       }
/*      */     }
/*  882 */     if (FCode.equals("BondInvestAccount"))
/*      */     {
/*  884 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  886 */         Double tDouble = new Double(FValue);
/*  887 */         double d = tDouble.doubleValue();
/*  888 */         this.BondInvestAccount = d;
/*      */       }
/*      */     }
/*  891 */     if (FCode.equals("CurrencyInvestAccount"))
/*      */     {
/*  893 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  895 */         Double tDouble = new Double(FValue);
/*  896 */         double d = tDouble.doubleValue();
/*  897 */         this.CurrencyInvestAccount = d;
/*      */       }
/*      */     }
/*  900 */     if (FCode.equals("PayExtraPremFlag"))
/*      */     {
/*  902 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  904 */         this.PayExtraPremFlag = FValue.trim();
/*      */       }
/*      */       else
/*  907 */         this.PayExtraPremFlag = null;
/*      */     }
/*  909 */     if (FCode.equals("MonthPlusPrem"))
/*      */     {
/*  911 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  913 */         Double tDouble = new Double(FValue);
/*  914 */         double d = tDouble.doubleValue();
/*  915 */         this.MonthPlusPrem = d;
/*      */       }
/*      */     }
/*  918 */     if (FCode.equals("TermInvestment"))
/*      */     {
/*  920 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  922 */         this.TermInvestment = FValue.trim();
/*      */       }
/*      */       else
/*  925 */         this.TermInvestment = null;
/*      */     }
/*  927 */     if (FCode.equals("HesInvestment"))
/*      */     {
/*  929 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  931 */         this.HesInvestment = FValue.trim();
/*      */       }
/*      */       else
/*  934 */         this.HesInvestment = null;
/*      */     }
/*  936 */     if (FCode.equals("Operator"))
/*      */     {
/*  938 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  940 */         this.Operator = FValue.trim();
/*      */       }
/*      */       else
/*  943 */         this.Operator = null;
/*      */     }
/*  945 */     if (FCode.equals("MakeDate"))
/*      */     {
/*  947 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  949 */         this.MakeDate = FValue.trim();
/*      */       }
/*      */       else
/*  952 */         this.MakeDate = null;
/*      */     }
/*  954 */     if (FCode.equals("MakeTime"))
/*      */     {
/*  956 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  958 */         this.MakeTime = FValue.trim();
/*      */       }
/*      */       else
/*  961 */         this.MakeTime = null;
/*      */     }
/*  963 */     if (FCode.equals("ModifyDate"))
/*      */     {
/*  965 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  967 */         this.ModifyDate = FValue.trim();
/*      */       }
/*      */       else
/*  970 */         this.ModifyDate = null;
/*      */     }
/*  972 */     if (FCode.equals("ModifyTime"))
/*      */     {
/*  974 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  976 */         this.ModifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  979 */         this.ModifyTime = null;
/*      */     }
/*  981 */     if (FCode.equals("Remark"))
/*      */     {
/*  983 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  985 */         this.Remark = FValue.trim();
/*      */       }
/*      */       else
/*  988 */         this.Remark = null;
/*      */     }
/*  990 */     if (FCode.equals("Varc1"))
/*      */     {
/*  992 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  994 */         this.Varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  997 */         this.Varc1 = null;
/*      */     }
/*  999 */     if (FCode.equals("Varc2"))
/*      */     {
/* 1001 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1003 */         this.Varc2 = FValue.trim();
/*      */       }
/*      */       else
/* 1006 */         this.Varc2 = null;
/*      */     }
/* 1008 */     if (FCode.equals("Varc3"))
/*      */     {
/* 1010 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1012 */         this.Varc3 = FValue.trim();
/*      */       }
/*      */       else
/* 1015 */         this.Varc3 = null;
/*      */     }
/* 1017 */     if (FCode.equals("Varc4"))
/*      */     {
/* 1019 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1021 */         this.Varc4 = FValue.trim();
/*      */       }
/*      */       else
/* 1024 */         this.Varc4 = null;
/*      */     }
/* 1026 */     if (FCode.equals("DateTime1"))
/*      */     {
/* 1028 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1030 */         this.DateTime1 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1033 */         this.DateTime1 = null;
/*      */     }
/* 1035 */     if (FCode.equals("DateTime2"))
/*      */     {
/* 1037 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1039 */         this.DateTime2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1042 */         this.DateTime2 = null;
/*      */     }
/* 1044 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1049 */     if (this == otherObject) return true;
/* 1050 */     if (otherObject == null) return false;
/* 1051 */     if (getClass() != otherObject.getClass()) return false;
/* 1052 */     LNPInvestmentInfoSchema other = (LNPInvestmentInfoSchema)otherObject;
/* 1053 */     return 
/* 1054 */       (this.ID.equals(other.getID())) && 
/* 1055 */       (this.ContNo.equals(other.getContNo())) && 
/* 1056 */       (this.StockInvestAccount == other.getStockInvestAccount()) && 
/* 1057 */       (this.MixedStockInvestAccount == other.getMixedStockInvestAccount()) && 
/* 1058 */       (this.MixedBondInvestAccount == other.getMixedBondInvestAccount()) && 
/* 1059 */       (this.BondInvestAccount == other.getBondInvestAccount()) && 
/* 1060 */       (this.CurrencyInvestAccount == other.getCurrencyInvestAccount()) && 
/* 1061 */       (this.PayExtraPremFlag.equals(other.getPayExtraPremFlag())) && 
/* 1062 */       (this.MonthPlusPrem == other.getMonthPlusPrem()) && 
/* 1063 */       (this.TermInvestment.equals(other.getTermInvestment())) && 
/* 1064 */       (this.HesInvestment.equals(other.getHesInvestment())) && 
/* 1065 */       (this.Operator.equals(other.getOperator())) && 
/* 1066 */       (this.MakeDate.equals(other.getMakeDate())) && 
/* 1067 */       (this.MakeTime.equals(other.getMakeTime())) && 
/* 1068 */       (this.ModifyDate.equals(other.getModifyDate())) && 
/* 1069 */       (this.ModifyTime.equals(other.getModifyTime())) && 
/* 1070 */       (this.Remark.equals(other.getRemark())) && 
/* 1071 */       (this.Varc1.equals(other.getVarc1())) && 
/* 1072 */       (this.Varc2.equals(other.getVarc2())) && 
/* 1073 */       (this.Varc3.equals(other.getVarc3())) && 
/* 1074 */       (this.Varc4.equals(other.getVarc4())) && 
/* 1075 */       (this.fDate.getString(this.DateTime1).equals(other.getDateTime1())) && 
/* 1076 */       (this.fDate.getString(this.DateTime2).equals(other.getDateTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1082 */     return 23;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1088 */     if (strFieldName.equals("ID")) {
/* 1089 */       return 0;
/*      */     }
/* 1091 */     if (strFieldName.equals("ContNo")) {
/* 1092 */       return 1;
/*      */     }
/* 1094 */     if (strFieldName.equals("StockInvestAccount")) {
/* 1095 */       return 2;
/*      */     }
/* 1097 */     if (strFieldName.equals("MixedStockInvestAccount")) {
/* 1098 */       return 3;
/*      */     }
/* 1100 */     if (strFieldName.equals("MixedBondInvestAccount")) {
/* 1101 */       return 4;
/*      */     }
/* 1103 */     if (strFieldName.equals("BondInvestAccount")) {
/* 1104 */       return 5;
/*      */     }
/* 1106 */     if (strFieldName.equals("CurrencyInvestAccount")) {
/* 1107 */       return 6;
/*      */     }
/* 1109 */     if (strFieldName.equals("PayExtraPremFlag")) {
/* 1110 */       return 7;
/*      */     }
/* 1112 */     if (strFieldName.equals("MonthPlusPrem")) {
/* 1113 */       return 8;
/*      */     }
/* 1115 */     if (strFieldName.equals("TermInvestment")) {
/* 1116 */       return 9;
/*      */     }
/* 1118 */     if (strFieldName.equals("HesInvestment")) {
/* 1119 */       return 10;
/*      */     }
/* 1121 */     if (strFieldName.equals("Operator")) {
/* 1122 */       return 11;
/*      */     }
/* 1124 */     if (strFieldName.equals("MakeDate")) {
/* 1125 */       return 12;
/*      */     }
/* 1127 */     if (strFieldName.equals("MakeTime")) {
/* 1128 */       return 13;
/*      */     }
/* 1130 */     if (strFieldName.equals("ModifyDate")) {
/* 1131 */       return 14;
/*      */     }
/* 1133 */     if (strFieldName.equals("ModifyTime")) {
/* 1134 */       return 15;
/*      */     }
/* 1136 */     if (strFieldName.equals("Remark")) {
/* 1137 */       return 16;
/*      */     }
/* 1139 */     if (strFieldName.equals("Varc1")) {
/* 1140 */       return 17;
/*      */     }
/* 1142 */     if (strFieldName.equals("Varc2")) {
/* 1143 */       return 18;
/*      */     }
/* 1145 */     if (strFieldName.equals("Varc3")) {
/* 1146 */       return 19;
/*      */     }
/* 1148 */     if (strFieldName.equals("Varc4")) {
/* 1149 */       return 20;
/*      */     }
/* 1151 */     if (strFieldName.equals("DateTime1")) {
/* 1152 */       return 21;
/*      */     }
/* 1154 */     if (strFieldName.equals("DateTime2")) {
/* 1155 */       return 22;
/*      */     }
/* 1157 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1163 */     String strFieldName = "";
/* 1164 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1166 */       strFieldName = "ID";
/* 1167 */       break;
/*      */     case 1:
/* 1169 */       strFieldName = "ContNo";
/* 1170 */       break;
/*      */     case 2:
/* 1172 */       strFieldName = "StockInvestAccount";
/* 1173 */       break;
/*      */     case 3:
/* 1175 */       strFieldName = "MixedStockInvestAccount";
/* 1176 */       break;
/*      */     case 4:
/* 1178 */       strFieldName = "MixedBondInvestAccount";
/* 1179 */       break;
/*      */     case 5:
/* 1181 */       strFieldName = "BondInvestAccount";
/* 1182 */       break;
/*      */     case 6:
/* 1184 */       strFieldName = "CurrencyInvestAccount";
/* 1185 */       break;
/*      */     case 7:
/* 1187 */       strFieldName = "PayExtraPremFlag";
/* 1188 */       break;
/*      */     case 8:
/* 1190 */       strFieldName = "MonthPlusPrem";
/* 1191 */       break;
/*      */     case 9:
/* 1193 */       strFieldName = "TermInvestment";
/* 1194 */       break;
/*      */     case 10:
/* 1196 */       strFieldName = "HesInvestment";
/* 1197 */       break;
/*      */     case 11:
/* 1199 */       strFieldName = "Operator";
/* 1200 */       break;
/*      */     case 12:
/* 1202 */       strFieldName = "MakeDate";
/* 1203 */       break;
/*      */     case 13:
/* 1205 */       strFieldName = "MakeTime";
/* 1206 */       break;
/*      */     case 14:
/* 1208 */       strFieldName = "ModifyDate";
/* 1209 */       break;
/*      */     case 15:
/* 1211 */       strFieldName = "ModifyTime";
/* 1212 */       break;
/*      */     case 16:
/* 1214 */       strFieldName = "Remark";
/* 1215 */       break;
/*      */     case 17:
/* 1217 */       strFieldName = "Varc1";
/* 1218 */       break;
/*      */     case 18:
/* 1220 */       strFieldName = "Varc2";
/* 1221 */       break;
/*      */     case 19:
/* 1223 */       strFieldName = "Varc3";
/* 1224 */       break;
/*      */     case 20:
/* 1226 */       strFieldName = "Varc4";
/* 1227 */       break;
/*      */     case 21:
/* 1229 */       strFieldName = "DateTime1";
/* 1230 */       break;
/*      */     case 22:
/* 1232 */       strFieldName = "DateTime2";
/* 1233 */       break;
/*      */     default:
/* 1235 */       strFieldName = "";
/*      */     }
/* 1237 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1243 */     if (strFieldName.equals("ID")) {
/* 1244 */       return 0;
/*      */     }
/* 1246 */     if (strFieldName.equals("ContNo")) {
/* 1247 */       return 0;
/*      */     }
/* 1249 */     if (strFieldName.equals("StockInvestAccount")) {
/* 1250 */       return 4;
/*      */     }
/* 1252 */     if (strFieldName.equals("MixedStockInvestAccount")) {
/* 1253 */       return 4;
/*      */     }
/* 1255 */     if (strFieldName.equals("MixedBondInvestAccount")) {
/* 1256 */       return 4;
/*      */     }
/* 1258 */     if (strFieldName.equals("BondInvestAccount")) {
/* 1259 */       return 4;
/*      */     }
/* 1261 */     if (strFieldName.equals("CurrencyInvestAccount")) {
/* 1262 */       return 4;
/*      */     }
/* 1264 */     if (strFieldName.equals("PayExtraPremFlag")) {
/* 1265 */       return 0;
/*      */     }
/* 1267 */     if (strFieldName.equals("MonthPlusPrem")) {
/* 1268 */       return 4;
/*      */     }
/* 1270 */     if (strFieldName.equals("TermInvestment")) {
/* 1271 */       return 0;
/*      */     }
/* 1273 */     if (strFieldName.equals("HesInvestment")) {
/* 1274 */       return 0;
/*      */     }
/* 1276 */     if (strFieldName.equals("Operator")) {
/* 1277 */       return 0;
/*      */     }
/* 1279 */     if (strFieldName.equals("MakeDate")) {
/* 1280 */       return 0;
/*      */     }
/* 1282 */     if (strFieldName.equals("MakeTime")) {
/* 1283 */       return 0;
/*      */     }
/* 1285 */     if (strFieldName.equals("ModifyDate")) {
/* 1286 */       return 0;
/*      */     }
/* 1288 */     if (strFieldName.equals("ModifyTime")) {
/* 1289 */       return 0;
/*      */     }
/* 1291 */     if (strFieldName.equals("Remark")) {
/* 1292 */       return 0;
/*      */     }
/* 1294 */     if (strFieldName.equals("Varc1")) {
/* 1295 */       return 0;
/*      */     }
/* 1297 */     if (strFieldName.equals("Varc2")) {
/* 1298 */       return 0;
/*      */     }
/* 1300 */     if (strFieldName.equals("Varc3")) {
/* 1301 */       return 0;
/*      */     }
/* 1303 */     if (strFieldName.equals("Varc4")) {
/* 1304 */       return 0;
/*      */     }
/* 1306 */     if (strFieldName.equals("DateTime1")) {
/* 1307 */       return 1;
/*      */     }
/* 1309 */     if (strFieldName.equals("DateTime2")) {
/* 1310 */       return 1;
/*      */     }
/* 1312 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1318 */     int nFieldType = -1;
/* 1319 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1321 */       nFieldType = 0;
/* 1322 */       break;
/*      */     case 1:
/* 1324 */       nFieldType = 0;
/* 1325 */       break;
/*      */     case 2:
/* 1327 */       nFieldType = 4;
/* 1328 */       break;
/*      */     case 3:
/* 1330 */       nFieldType = 4;
/* 1331 */       break;
/*      */     case 4:
/* 1333 */       nFieldType = 4;
/* 1334 */       break;
/*      */     case 5:
/* 1336 */       nFieldType = 4;
/* 1337 */       break;
/*      */     case 6:
/* 1339 */       nFieldType = 4;
/* 1340 */       break;
/*      */     case 7:
/* 1342 */       nFieldType = 0;
/* 1343 */       break;
/*      */     case 8:
/* 1345 */       nFieldType = 4;
/* 1346 */       break;
/*      */     case 9:
/* 1348 */       nFieldType = 0;
/* 1349 */       break;
/*      */     case 10:
/* 1351 */       nFieldType = 0;
/* 1352 */       break;
/*      */     case 11:
/* 1354 */       nFieldType = 0;
/* 1355 */       break;
/*      */     case 12:
/* 1357 */       nFieldType = 0;
/* 1358 */       break;
/*      */     case 13:
/* 1360 */       nFieldType = 0;
/* 1361 */       break;
/*      */     case 14:
/* 1363 */       nFieldType = 0;
/* 1364 */       break;
/*      */     case 15:
/* 1366 */       nFieldType = 0;
/* 1367 */       break;
/*      */     case 16:
/* 1369 */       nFieldType = 0;
/* 1370 */       break;
/*      */     case 17:
/* 1372 */       nFieldType = 0;
/* 1373 */       break;
/*      */     case 18:
/* 1375 */       nFieldType = 0;
/* 1376 */       break;
/*      */     case 19:
/* 1378 */       nFieldType = 0;
/* 1379 */       break;
/*      */     case 20:
/* 1381 */       nFieldType = 0;
/* 1382 */       break;
/*      */     case 21:
/* 1384 */       nFieldType = 1;
/* 1385 */       break;
/*      */     case 22:
/* 1387 */       nFieldType = 1;
/* 1388 */       break;
/*      */     default:
/* 1390 */       nFieldType = -1;
/*      */     }
/* 1392 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPInvestmentInfoSchema
 * JD-Core Version:    0.6.0
 */