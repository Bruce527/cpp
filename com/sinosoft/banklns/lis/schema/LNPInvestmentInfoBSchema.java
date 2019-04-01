/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestmentInfoBDB;
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
/*      */ public class LNPInvestmentInfoBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
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
/*      */   public static final int FIELDNUM = 25;
/*      */   private static String[] PK;
/*   75 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPInvestmentInfoBSchema()
/*      */   {
/*   82 */     this.mErrors = new CErrors();
/*      */ 
/*   84 */     String[] pk = new String[2];
/*   85 */     pk[0] = "EdorNo";
/*   86 */     pk[1] = "serialNo";
/*      */ 
/*   88 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   94 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*   99 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*  103 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  107 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*  111 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  115 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  119 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getID() {
/*  123 */     if (this.ID != null) this.ID.equals("");
/*      */ 
/*  127 */     return this.ID;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  131 */     this.ID = aID;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  135 */     if (this.ContNo != null) this.ContNo.equals("");
/*      */ 
/*  139 */     return this.ContNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  143 */     this.ContNo = aContNo;
/*      */   }
/*      */ 
/*      */   public double getStockInvestAccount() {
/*  147 */     return this.StockInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setStockInvestAccount(double aStockInvestAccount) {
/*  151 */     this.StockInvestAccount = aStockInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setStockInvestAccount(String aStockInvestAccount) {
/*  155 */     if ((aStockInvestAccount != null) && (!aStockInvestAccount.equals("")))
/*      */     {
/*  157 */       Double tDouble = new Double(aStockInvestAccount);
/*  158 */       double d = tDouble.doubleValue();
/*  159 */       this.StockInvestAccount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMixedStockInvestAccount()
/*      */   {
/*  165 */     return this.MixedStockInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setMixedStockInvestAccount(double aMixedStockInvestAccount) {
/*  169 */     this.MixedStockInvestAccount = aMixedStockInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setMixedStockInvestAccount(String aMixedStockInvestAccount) {
/*  173 */     if ((aMixedStockInvestAccount != null) && (!aMixedStockInvestAccount.equals("")))
/*      */     {
/*  175 */       Double tDouble = new Double(aMixedStockInvestAccount);
/*  176 */       double d = tDouble.doubleValue();
/*  177 */       this.MixedStockInvestAccount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMixedBondInvestAccount()
/*      */   {
/*  183 */     return this.MixedBondInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setMixedBondInvestAccount(double aMixedBondInvestAccount) {
/*  187 */     this.MixedBondInvestAccount = aMixedBondInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setMixedBondInvestAccount(String aMixedBondInvestAccount) {
/*  191 */     if ((aMixedBondInvestAccount != null) && (!aMixedBondInvestAccount.equals("")))
/*      */     {
/*  193 */       Double tDouble = new Double(aMixedBondInvestAccount);
/*  194 */       double d = tDouble.doubleValue();
/*  195 */       this.MixedBondInvestAccount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getBondInvestAccount()
/*      */   {
/*  201 */     return this.BondInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setBondInvestAccount(double aBondInvestAccount) {
/*  205 */     this.BondInvestAccount = aBondInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setBondInvestAccount(String aBondInvestAccount) {
/*  209 */     if ((aBondInvestAccount != null) && (!aBondInvestAccount.equals("")))
/*      */     {
/*  211 */       Double tDouble = new Double(aBondInvestAccount);
/*  212 */       double d = tDouble.doubleValue();
/*  213 */       this.BondInvestAccount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getCurrencyInvestAccount()
/*      */   {
/*  219 */     return this.CurrencyInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setCurrencyInvestAccount(double aCurrencyInvestAccount) {
/*  223 */     this.CurrencyInvestAccount = aCurrencyInvestAccount;
/*      */   }
/*      */ 
/*      */   public void setCurrencyInvestAccount(String aCurrencyInvestAccount) {
/*  227 */     if ((aCurrencyInvestAccount != null) && (!aCurrencyInvestAccount.equals("")))
/*      */     {
/*  229 */       Double tDouble = new Double(aCurrencyInvestAccount);
/*  230 */       double d = tDouble.doubleValue();
/*  231 */       this.CurrencyInvestAccount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPayExtraPremFlag()
/*      */   {
/*  237 */     if (this.PayExtraPremFlag != null) this.PayExtraPremFlag.equals("");
/*      */ 
/*  241 */     return this.PayExtraPremFlag;
/*      */   }
/*      */ 
/*      */   public void setPayExtraPremFlag(String aPayExtraPremFlag) {
/*  245 */     this.PayExtraPremFlag = aPayExtraPremFlag;
/*      */   }
/*      */ 
/*      */   public double getMonthPlusPrem() {
/*  249 */     return this.MonthPlusPrem;
/*      */   }
/*      */ 
/*      */   public void setMonthPlusPrem(double aMonthPlusPrem) {
/*  253 */     this.MonthPlusPrem = aMonthPlusPrem;
/*      */   }
/*      */ 
/*      */   public void setMonthPlusPrem(String aMonthPlusPrem) {
/*  257 */     if ((aMonthPlusPrem != null) && (!aMonthPlusPrem.equals("")))
/*      */     {
/*  259 */       Double tDouble = new Double(aMonthPlusPrem);
/*  260 */       double d = tDouble.doubleValue();
/*  261 */       this.MonthPlusPrem = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getTermInvestment()
/*      */   {
/*  267 */     if (this.TermInvestment != null) this.TermInvestment.equals("");
/*      */ 
/*  271 */     return this.TermInvestment;
/*      */   }
/*      */ 
/*      */   public void setTermInvestment(String aTermInvestment) {
/*  275 */     this.TermInvestment = aTermInvestment;
/*      */   }
/*      */ 
/*      */   public String getHesInvestment() {
/*  279 */     if (this.HesInvestment != null) this.HesInvestment.equals("");
/*      */ 
/*  283 */     return this.HesInvestment;
/*      */   }
/*      */ 
/*      */   public void setHesInvestment(String aHesInvestment) {
/*  287 */     this.HesInvestment = aHesInvestment;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  291 */     if (this.Operator != null) this.Operator.equals("");
/*      */ 
/*  295 */     return this.Operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  299 */     this.Operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  303 */     if (this.MakeDate != null) this.MakeDate.equals("");
/*      */ 
/*  307 */     return this.MakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  311 */     this.MakeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public String getMakeTime() {
/*  315 */     if (this.MakeTime != null) this.MakeTime.equals("");
/*      */ 
/*  319 */     return this.MakeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  323 */     this.MakeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  327 */     if (this.ModifyDate != null) this.ModifyDate.equals("");
/*      */ 
/*  331 */     return this.ModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  335 */     this.ModifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public String getModifyTime() {
/*  339 */     if (this.ModifyTime != null) this.ModifyTime.equals("");
/*      */ 
/*  343 */     return this.ModifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  347 */     this.ModifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getRemark() {
/*  351 */     if (this.Remark != null) this.Remark.equals("");
/*      */ 
/*  355 */     return this.Remark;
/*      */   }
/*      */ 
/*      */   public void setRemark(String aRemark) {
/*  359 */     this.Remark = aRemark;
/*      */   }
/*      */ 
/*      */   public String getVarc1() {
/*  363 */     if (this.Varc1 != null) this.Varc1.equals("");
/*      */ 
/*  367 */     return this.Varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  371 */     this.Varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  375 */     if (this.Varc2 != null) this.Varc2.equals("");
/*      */ 
/*  379 */     return this.Varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  383 */     this.Varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getVarc3() {
/*  387 */     if (this.Varc3 != null) this.Varc3.equals("");
/*      */ 
/*  391 */     return this.Varc3;
/*      */   }
/*      */ 
/*      */   public void setVarc3(String aVarc3) {
/*  395 */     this.Varc3 = aVarc3;
/*      */   }
/*      */ 
/*      */   public String getVarc4() {
/*  399 */     if (this.Varc4 != null) this.Varc4.equals("");
/*      */ 
/*  403 */     return this.Varc4;
/*      */   }
/*      */ 
/*      */   public void setVarc4(String aVarc4) {
/*  407 */     this.Varc4 = aVarc4;
/*      */   }
/*      */ 
/*      */   public String getDateTime1() {
/*  411 */     if (this.DateTime1 != null) {
/*  412 */       return this.fDate.getString(this.DateTime1);
/*      */     }
/*  414 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(Date aDateTime1) {
/*  418 */     this.DateTime1 = aDateTime1;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(String aDateTime1) {
/*  422 */     if ((aDateTime1 != null) && (!aDateTime1.equals("")))
/*      */     {
/*  424 */       this.DateTime1 = this.fDate.getDate(aDateTime1);
/*      */     }
/*      */     else
/*  427 */       this.DateTime1 = null;
/*      */   }
/*      */ 
/*      */   public String getDateTime2()
/*      */   {
/*  432 */     if (this.DateTime2 != null) {
/*  433 */       return this.fDate.getString(this.DateTime2);
/*      */     }
/*  435 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(Date aDateTime2) {
/*  439 */     this.DateTime2 = aDateTime2;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(String aDateTime2) {
/*  443 */     if ((aDateTime2 != null) && (!aDateTime2.equals("")))
/*      */     {
/*  445 */       this.DateTime2 = this.fDate.getDate(aDateTime2);
/*      */     }
/*      */     else
/*  448 */       this.DateTime2 = null;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPInvestmentInfoBSchema aLNPInvestmentInfoBSchema)
/*      */   {
/*  455 */     this.EdorNo = aLNPInvestmentInfoBSchema.getEdorNo();
/*  456 */     this.serialNo = aLNPInvestmentInfoBSchema.getserialNo();
/*  457 */     this.ID = aLNPInvestmentInfoBSchema.getID();
/*  458 */     this.ContNo = aLNPInvestmentInfoBSchema.getContNo();
/*  459 */     this.StockInvestAccount = aLNPInvestmentInfoBSchema.getStockInvestAccount();
/*  460 */     this.MixedStockInvestAccount = aLNPInvestmentInfoBSchema.getMixedStockInvestAccount();
/*  461 */     this.MixedBondInvestAccount = aLNPInvestmentInfoBSchema.getMixedBondInvestAccount();
/*  462 */     this.BondInvestAccount = aLNPInvestmentInfoBSchema.getBondInvestAccount();
/*  463 */     this.CurrencyInvestAccount = aLNPInvestmentInfoBSchema.getCurrencyInvestAccount();
/*  464 */     this.PayExtraPremFlag = aLNPInvestmentInfoBSchema.getPayExtraPremFlag();
/*  465 */     this.MonthPlusPrem = aLNPInvestmentInfoBSchema.getMonthPlusPrem();
/*  466 */     this.TermInvestment = aLNPInvestmentInfoBSchema.getTermInvestment();
/*  467 */     this.HesInvestment = aLNPInvestmentInfoBSchema.getHesInvestment();
/*  468 */     this.Operator = aLNPInvestmentInfoBSchema.getOperator();
/*  469 */     this.MakeDate = aLNPInvestmentInfoBSchema.getMakeDate();
/*  470 */     this.MakeTime = aLNPInvestmentInfoBSchema.getMakeTime();
/*  471 */     this.ModifyDate = aLNPInvestmentInfoBSchema.getModifyDate();
/*  472 */     this.ModifyTime = aLNPInvestmentInfoBSchema.getModifyTime();
/*  473 */     this.Remark = aLNPInvestmentInfoBSchema.getRemark();
/*  474 */     this.Varc1 = aLNPInvestmentInfoBSchema.getVarc1();
/*  475 */     this.Varc2 = aLNPInvestmentInfoBSchema.getVarc2();
/*  476 */     this.Varc3 = aLNPInvestmentInfoBSchema.getVarc3();
/*  477 */     this.Varc4 = aLNPInvestmentInfoBSchema.getVarc4();
/*  478 */     this.DateTime1 = this.fDate.getDate(aLNPInvestmentInfoBSchema.getDateTime1());
/*  479 */     this.DateTime2 = this.fDate.getDate(aLNPInvestmentInfoBSchema.getDateTime2());
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  488 */       if (rs.getString("EdorNo") == null)
/*  489 */         this.EdorNo = null;
/*      */       else {
/*  491 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  493 */       if (rs.getString("serialNo") == null)
/*  494 */         this.serialNo = null;
/*      */       else {
/*  496 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/*  498 */       if (rs.getString("ID") == null)
/*  499 */         this.ID = null;
/*      */       else {
/*  501 */         this.ID = rs.getString("ID").trim();
/*      */       }
/*  503 */       if (rs.getString("ContNo") == null)
/*  504 */         this.ContNo = null;
/*      */       else {
/*  506 */         this.ContNo = rs.getString("ContNo").trim();
/*      */       }
/*  508 */       this.StockInvestAccount = rs.getDouble("StockInvestAccount");
/*  509 */       this.MixedStockInvestAccount = rs.getDouble("MixedStockInvestAccount");
/*  510 */       this.MixedBondInvestAccount = rs.getDouble("MixedBondInvestAccount");
/*  511 */       this.BondInvestAccount = rs.getDouble("BondInvestAccount");
/*  512 */       this.CurrencyInvestAccount = rs.getDouble("CurrencyInvestAccount");
/*  513 */       if (rs.getString("PayExtraPremFlag") == null)
/*  514 */         this.PayExtraPremFlag = null;
/*      */       else {
/*  516 */         this.PayExtraPremFlag = rs.getString("PayExtraPremFlag").trim();
/*      */       }
/*  518 */       this.MonthPlusPrem = rs.getDouble("MonthPlusPrem");
/*  519 */       if (rs.getString("TermInvestment") == null)
/*  520 */         this.TermInvestment = null;
/*      */       else {
/*  522 */         this.TermInvestment = rs.getString("TermInvestment").trim();
/*      */       }
/*  524 */       if (rs.getString("HesInvestment") == null)
/*  525 */         this.HesInvestment = null;
/*      */       else {
/*  527 */         this.HesInvestment = rs.getString("HesInvestment").trim();
/*      */       }
/*  529 */       if (rs.getString("Operator") == null)
/*  530 */         this.Operator = null;
/*      */       else {
/*  532 */         this.Operator = rs.getString("Operator").trim();
/*      */       }
/*  534 */       if (rs.getString("MakeDate") == null)
/*  535 */         this.MakeDate = null;
/*      */       else {
/*  537 */         this.MakeDate = rs.getString("MakeDate").trim();
/*      */       }
/*  539 */       if (rs.getString("MakeTime") == null)
/*  540 */         this.MakeTime = null;
/*      */       else {
/*  542 */         this.MakeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  544 */       if (rs.getString("ModifyDate") == null)
/*  545 */         this.ModifyDate = null;
/*      */       else {
/*  547 */         this.ModifyDate = rs.getString("ModifyDate").trim();
/*      */       }
/*  549 */       if (rs.getString("ModifyTime") == null)
/*  550 */         this.ModifyTime = null;
/*      */       else {
/*  552 */         this.ModifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  554 */       if (rs.getString("Remark") == null)
/*  555 */         this.Remark = null;
/*      */       else {
/*  557 */         this.Remark = rs.getString("Remark").trim();
/*      */       }
/*  559 */       if (rs.getString("Varc1") == null)
/*  560 */         this.Varc1 = null;
/*      */       else {
/*  562 */         this.Varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  564 */       if (rs.getString("Varc2") == null)
/*  565 */         this.Varc2 = null;
/*      */       else {
/*  567 */         this.Varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  569 */       if (rs.getString("Varc3") == null)
/*  570 */         this.Varc3 = null;
/*      */       else {
/*  572 */         this.Varc3 = rs.getString("Varc3").trim();
/*      */       }
/*  574 */       if (rs.getString("Varc4") == null)
/*  575 */         this.Varc4 = null;
/*      */       else {
/*  577 */         this.Varc4 = rs.getString("Varc4").trim();
/*      */       }
/*  579 */       this.DateTime1 = rs.getDate("DateTime1");
/*  580 */       this.DateTime2 = rs.getDate("DateTime2");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  585 */       CError tError = new CError();
/*  586 */       tError.moduleName = "LNPInvestmentInfoBSchema";
/*  587 */       tError.functionName = "setSchema";
/*  588 */       tError.errorMessage = sqle.toString();
/*  589 */       this.mErrors.addOneError(tError);
/*      */ 
/*  591 */       return false;
/*      */     }
/*  593 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInvestmentInfoBSchema getSchema()
/*      */   {
/*  598 */     LNPInvestmentInfoBSchema aLNPInvestmentInfoBSchema = new LNPInvestmentInfoBSchema();
/*  599 */     aLNPInvestmentInfoBSchema.setSchema(this);
/*  600 */     return aLNPInvestmentInfoBSchema;
/*      */   }
/*      */ 
/*      */   public LNPInvestmentInfoBDB getDB()
/*      */   {
/*  605 */     LNPInvestmentInfoBDB aDBOper = new LNPInvestmentInfoBDB();
/*  606 */     aDBOper.setSchema(this);
/*  607 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  614 */     String strReturn = "";
/*  615 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/*  616 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/*  617 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ID)) + "|" + 
/*  618 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ContNo)) + "|" + 
/*  619 */       ChgData.chgData(this.StockInvestAccount) + "|" + 
/*  620 */       ChgData.chgData(this.MixedStockInvestAccount) + "|" + 
/*  621 */       ChgData.chgData(this.MixedBondInvestAccount) + "|" + 
/*  622 */       ChgData.chgData(this.BondInvestAccount) + "|" + 
/*  623 */       ChgData.chgData(this.CurrencyInvestAccount) + "|" + 
/*  624 */       StrTool.cTrim(StrTool.unicodeToGBK(this.PayExtraPremFlag)) + "|" + 
/*  625 */       ChgData.chgData(this.MonthPlusPrem) + "|" + 
/*  626 */       StrTool.cTrim(StrTool.unicodeToGBK(this.TermInvestment)) + "|" + 
/*  627 */       StrTool.cTrim(StrTool.unicodeToGBK(this.HesInvestment)) + "|" + 
/*  628 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Operator)) + "|" + 
/*  629 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeDate)) + "|" + 
/*  630 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeTime)) + "|" + 
/*  631 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyDate)) + "|" + 
/*  632 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyTime)) + "|" + 
/*  633 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Remark)) + "|" + 
/*  634 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc1)) + "|" + 
/*  635 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc2)) + "|" + 
/*  636 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc3)) + "|" + 
/*  637 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc4)) + "|" + 
/*  638 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime1))) + "|" + 
/*  639 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime2)));
/*  640 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  648 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  649 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  650 */       this.ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  651 */       this.ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  652 */       this.StockInvestAccount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|"))).doubleValue();
/*  653 */       this.MixedStockInvestAccount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).doubleValue();
/*  654 */       this.MixedBondInvestAccount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).doubleValue();
/*  655 */       this.BondInvestAccount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).doubleValue();
/*  656 */       this.CurrencyInvestAccount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).doubleValue();
/*  657 */       this.PayExtraPremFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  658 */       this.MonthPlusPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).doubleValue();
/*  659 */       this.TermInvestment = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  660 */       this.HesInvestment = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  661 */       this.Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  662 */       this.MakeDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  663 */       this.MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  664 */       this.ModifyDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  665 */       this.ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  666 */       this.Remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  667 */       this.Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  668 */       this.Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  669 */       this.Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  670 */       this.Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  671 */       this.DateTime1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
/*  672 */       this.DateTime2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  677 */       CError tError = new CError();
/*  678 */       tError.moduleName = "LNPInvestmentInfoBSchema";
/*  679 */       tError.functionName = "decode";
/*  680 */       tError.errorMessage = ex.toString();
/*  681 */       this.mErrors.addOneError(tError);
/*      */ 
/*  683 */       return false;
/*      */     }
/*  685 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  691 */     String strReturn = "";
/*  692 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  694 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/*  696 */     if (FCode.equals("serialNo"))
/*      */     {
/*  698 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/*  700 */     if (FCode.equals("ID"))
/*      */     {
/*  702 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ID));
/*      */     }
/*  704 */     if (FCode.equals("ContNo"))
/*      */     {
/*  706 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ContNo));
/*      */     }
/*  708 */     if (FCode.equals("StockInvestAccount"))
/*      */     {
/*  710 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.StockInvestAccount));
/*      */     }
/*  712 */     if (FCode.equals("MixedStockInvestAccount"))
/*      */     {
/*  714 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MixedStockInvestAccount));
/*      */     }
/*  716 */     if (FCode.equals("MixedBondInvestAccount"))
/*      */     {
/*  718 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MixedBondInvestAccount));
/*      */     }
/*  720 */     if (FCode.equals("BondInvestAccount"))
/*      */     {
/*  722 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BondInvestAccount));
/*      */     }
/*  724 */     if (FCode.equals("CurrencyInvestAccount"))
/*      */     {
/*  726 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.CurrencyInvestAccount));
/*      */     }
/*  728 */     if (FCode.equals("PayExtraPremFlag"))
/*      */     {
/*  730 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.PayExtraPremFlag));
/*      */     }
/*  732 */     if (FCode.equals("MonthPlusPrem"))
/*      */     {
/*  734 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MonthPlusPrem));
/*      */     }
/*  736 */     if (FCode.equals("TermInvestment"))
/*      */     {
/*  738 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.TermInvestment));
/*      */     }
/*  740 */     if (FCode.equals("HesInvestment"))
/*      */     {
/*  742 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.HesInvestment));
/*      */     }
/*  744 */     if (FCode.equals("Operator"))
/*      */     {
/*  746 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Operator));
/*      */     }
/*  748 */     if (FCode.equals("MakeDate"))
/*      */     {
/*  750 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeDate));
/*      */     }
/*  752 */     if (FCode.equals("MakeTime"))
/*      */     {
/*  754 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeTime));
/*      */     }
/*  756 */     if (FCode.equals("ModifyDate"))
/*      */     {
/*  758 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyDate));
/*      */     }
/*  760 */     if (FCode.equals("ModifyTime"))
/*      */     {
/*  762 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyTime));
/*      */     }
/*  764 */     if (FCode.equals("Remark"))
/*      */     {
/*  766 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Remark));
/*      */     }
/*  768 */     if (FCode.equals("Varc1"))
/*      */     {
/*  770 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc1));
/*      */     }
/*  772 */     if (FCode.equals("Varc2"))
/*      */     {
/*  774 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc2));
/*      */     }
/*  776 */     if (FCode.equals("Varc3"))
/*      */     {
/*  778 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc3));
/*      */     }
/*  780 */     if (FCode.equals("Varc4"))
/*      */     {
/*  782 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc4));
/*      */     }
/*  784 */     if (FCode.equals("DateTime1"))
/*      */     {
/*  786 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*      */     }
/*  788 */     if (FCode.equals("DateTime2"))
/*      */     {
/*  790 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*      */     }
/*  792 */     if (strReturn.equals(""))
/*      */     {
/*  794 */       strReturn = "null";
/*      */     }
/*      */ 
/*  797 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  804 */     String strFieldValue = "";
/*  805 */     switch (nFieldIndex) {
/*      */     case 0:
/*  807 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/*  808 */       break;
/*      */     case 1:
/*  810 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/*  811 */       break;
/*      */     case 2:
/*  813 */       strFieldValue = StrTool.GBKToUnicode(this.ID);
/*  814 */       break;
/*      */     case 3:
/*  816 */       strFieldValue = StrTool.GBKToUnicode(this.ContNo);
/*  817 */       break;
/*      */     case 4:
/*  819 */       strFieldValue = String.valueOf(this.StockInvestAccount);
/*  820 */       break;
/*      */     case 5:
/*  822 */       strFieldValue = String.valueOf(this.MixedStockInvestAccount);
/*  823 */       break;
/*      */     case 6:
/*  825 */       strFieldValue = String.valueOf(this.MixedBondInvestAccount);
/*  826 */       break;
/*      */     case 7:
/*  828 */       strFieldValue = String.valueOf(this.BondInvestAccount);
/*  829 */       break;
/*      */     case 8:
/*  831 */       strFieldValue = String.valueOf(this.CurrencyInvestAccount);
/*  832 */       break;
/*      */     case 9:
/*  834 */       strFieldValue = StrTool.GBKToUnicode(this.PayExtraPremFlag);
/*  835 */       break;
/*      */     case 10:
/*  837 */       strFieldValue = String.valueOf(this.MonthPlusPrem);
/*  838 */       break;
/*      */     case 11:
/*  840 */       strFieldValue = StrTool.GBKToUnicode(this.TermInvestment);
/*  841 */       break;
/*      */     case 12:
/*  843 */       strFieldValue = StrTool.GBKToUnicode(this.HesInvestment);
/*  844 */       break;
/*      */     case 13:
/*  846 */       strFieldValue = StrTool.GBKToUnicode(this.Operator);
/*  847 */       break;
/*      */     case 14:
/*  849 */       strFieldValue = StrTool.GBKToUnicode(this.MakeDate);
/*  850 */       break;
/*      */     case 15:
/*  852 */       strFieldValue = StrTool.GBKToUnicode(this.MakeTime);
/*  853 */       break;
/*      */     case 16:
/*  855 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyDate);
/*  856 */       break;
/*      */     case 17:
/*  858 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyTime);
/*  859 */       break;
/*      */     case 18:
/*  861 */       strFieldValue = StrTool.GBKToUnicode(this.Remark);
/*  862 */       break;
/*      */     case 19:
/*  864 */       strFieldValue = StrTool.GBKToUnicode(this.Varc1);
/*  865 */       break;
/*      */     case 20:
/*  867 */       strFieldValue = StrTool.GBKToUnicode(this.Varc2);
/*  868 */       break;
/*      */     case 21:
/*  870 */       strFieldValue = StrTool.GBKToUnicode(this.Varc3);
/*  871 */       break;
/*      */     case 22:
/*  873 */       strFieldValue = StrTool.GBKToUnicode(this.Varc4);
/*  874 */       break;
/*      */     case 23:
/*  876 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*  877 */       break;
/*      */     case 24:
/*  879 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*  880 */       break;
/*      */     default:
/*  882 */       strFieldValue = "";
/*      */     }
/*  884 */     if (strFieldValue.equals("")) {
/*  885 */       strFieldValue = "null";
/*      */     }
/*  887 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  893 */     if (StrTool.cTrim(FCode).equals("")) {
/*  894 */       return false;
/*      */     }
/*  896 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  898 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  900 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/*  903 */         this.EdorNo = null;
/*      */     }
/*  905 */     if (FCode.equals("serialNo"))
/*      */     {
/*  907 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  909 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/*  912 */         this.serialNo = null;
/*      */     }
/*  914 */     if (FCode.equals("ID"))
/*      */     {
/*  916 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  918 */         this.ID = FValue.trim();
/*      */       }
/*      */       else
/*  921 */         this.ID = null;
/*      */     }
/*  923 */     if (FCode.equals("ContNo"))
/*      */     {
/*  925 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  927 */         this.ContNo = FValue.trim();
/*      */       }
/*      */       else
/*  930 */         this.ContNo = null;
/*      */     }
/*  932 */     if (FCode.equals("StockInvestAccount"))
/*      */     {
/*  934 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  936 */         Double tDouble = new Double(FValue);
/*  937 */         double d = tDouble.doubleValue();
/*  938 */         this.StockInvestAccount = d;
/*      */       }
/*      */     }
/*  941 */     if (FCode.equals("MixedStockInvestAccount"))
/*      */     {
/*  943 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  945 */         Double tDouble = new Double(FValue);
/*  946 */         double d = tDouble.doubleValue();
/*  947 */         this.MixedStockInvestAccount = d;
/*      */       }
/*      */     }
/*  950 */     if (FCode.equals("MixedBondInvestAccount"))
/*      */     {
/*  952 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  954 */         Double tDouble = new Double(FValue);
/*  955 */         double d = tDouble.doubleValue();
/*  956 */         this.MixedBondInvestAccount = d;
/*      */       }
/*      */     }
/*  959 */     if (FCode.equals("BondInvestAccount"))
/*      */     {
/*  961 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  963 */         Double tDouble = new Double(FValue);
/*  964 */         double d = tDouble.doubleValue();
/*  965 */         this.BondInvestAccount = d;
/*      */       }
/*      */     }
/*  968 */     if (FCode.equals("CurrencyInvestAccount"))
/*      */     {
/*  970 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  972 */         Double tDouble = new Double(FValue);
/*  973 */         double d = tDouble.doubleValue();
/*  974 */         this.CurrencyInvestAccount = d;
/*      */       }
/*      */     }
/*  977 */     if (FCode.equals("PayExtraPremFlag"))
/*      */     {
/*  979 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  981 */         this.PayExtraPremFlag = FValue.trim();
/*      */       }
/*      */       else
/*  984 */         this.PayExtraPremFlag = null;
/*      */     }
/*  986 */     if (FCode.equals("MonthPlusPrem"))
/*      */     {
/*  988 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  990 */         Double tDouble = new Double(FValue);
/*  991 */         double d = tDouble.doubleValue();
/*  992 */         this.MonthPlusPrem = d;
/*      */       }
/*      */     }
/*  995 */     if (FCode.equals("TermInvestment"))
/*      */     {
/*  997 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  999 */         this.TermInvestment = FValue.trim();
/*      */       }
/*      */       else
/* 1002 */         this.TermInvestment = null;
/*      */     }
/* 1004 */     if (FCode.equals("HesInvestment"))
/*      */     {
/* 1006 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1008 */         this.HesInvestment = FValue.trim();
/*      */       }
/*      */       else
/* 1011 */         this.HesInvestment = null;
/*      */     }
/* 1013 */     if (FCode.equals("Operator"))
/*      */     {
/* 1015 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1017 */         this.Operator = FValue.trim();
/*      */       }
/*      */       else
/* 1020 */         this.Operator = null;
/*      */     }
/* 1022 */     if (FCode.equals("MakeDate"))
/*      */     {
/* 1024 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1026 */         this.MakeDate = FValue.trim();
/*      */       }
/*      */       else
/* 1029 */         this.MakeDate = null;
/*      */     }
/* 1031 */     if (FCode.equals("MakeTime"))
/*      */     {
/* 1033 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1035 */         this.MakeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1038 */         this.MakeTime = null;
/*      */     }
/* 1040 */     if (FCode.equals("ModifyDate"))
/*      */     {
/* 1042 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1044 */         this.ModifyDate = FValue.trim();
/*      */       }
/*      */       else
/* 1047 */         this.ModifyDate = null;
/*      */     }
/* 1049 */     if (FCode.equals("ModifyTime"))
/*      */     {
/* 1051 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1053 */         this.ModifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1056 */         this.ModifyTime = null;
/*      */     }
/* 1058 */     if (FCode.equals("Remark"))
/*      */     {
/* 1060 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1062 */         this.Remark = FValue.trim();
/*      */       }
/*      */       else
/* 1065 */         this.Remark = null;
/*      */     }
/* 1067 */     if (FCode.equals("Varc1"))
/*      */     {
/* 1069 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1071 */         this.Varc1 = FValue.trim();
/*      */       }
/*      */       else
/* 1074 */         this.Varc1 = null;
/*      */     }
/* 1076 */     if (FCode.equals("Varc2"))
/*      */     {
/* 1078 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1080 */         this.Varc2 = FValue.trim();
/*      */       }
/*      */       else
/* 1083 */         this.Varc2 = null;
/*      */     }
/* 1085 */     if (FCode.equals("Varc3"))
/*      */     {
/* 1087 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1089 */         this.Varc3 = FValue.trim();
/*      */       }
/*      */       else
/* 1092 */         this.Varc3 = null;
/*      */     }
/* 1094 */     if (FCode.equals("Varc4"))
/*      */     {
/* 1096 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1098 */         this.Varc4 = FValue.trim();
/*      */       }
/*      */       else
/* 1101 */         this.Varc4 = null;
/*      */     }
/* 1103 */     if (FCode.equals("DateTime1"))
/*      */     {
/* 1105 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1107 */         this.DateTime1 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1110 */         this.DateTime1 = null;
/*      */     }
/* 1112 */     if (FCode.equals("DateTime2"))
/*      */     {
/* 1114 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1116 */         this.DateTime2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1119 */         this.DateTime2 = null;
/*      */     }
/* 1121 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1126 */     if (this == otherObject) return true;
/* 1127 */     if (otherObject == null) return false;
/* 1128 */     if (getClass() != otherObject.getClass()) return false;
/* 1129 */     LNPInvestmentInfoBSchema other = (LNPInvestmentInfoBSchema)otherObject;
/* 1130 */     return 
/* 1131 */       (this.EdorNo.equals(other.getEdorNo())) && 
/* 1132 */       (this.serialNo.equals(other.getserialNo())) && 
/* 1133 */       (this.ID.equals(other.getID())) && 
/* 1134 */       (this.ContNo.equals(other.getContNo())) && 
/* 1135 */       (this.StockInvestAccount == other.getStockInvestAccount()) && 
/* 1136 */       (this.MixedStockInvestAccount == other.getMixedStockInvestAccount()) && 
/* 1137 */       (this.MixedBondInvestAccount == other.getMixedBondInvestAccount()) && 
/* 1138 */       (this.BondInvestAccount == other.getBondInvestAccount()) && 
/* 1139 */       (this.CurrencyInvestAccount == other.getCurrencyInvestAccount()) && 
/* 1140 */       (this.PayExtraPremFlag.equals(other.getPayExtraPremFlag())) && 
/* 1141 */       (this.MonthPlusPrem == other.getMonthPlusPrem()) && 
/* 1142 */       (this.TermInvestment.equals(other.getTermInvestment())) && 
/* 1143 */       (this.HesInvestment.equals(other.getHesInvestment())) && 
/* 1144 */       (this.Operator.equals(other.getOperator())) && 
/* 1145 */       (this.MakeDate.equals(other.getMakeDate())) && 
/* 1146 */       (this.MakeTime.equals(other.getMakeTime())) && 
/* 1147 */       (this.ModifyDate.equals(other.getModifyDate())) && 
/* 1148 */       (this.ModifyTime.equals(other.getModifyTime())) && 
/* 1149 */       (this.Remark.equals(other.getRemark())) && 
/* 1150 */       (this.Varc1.equals(other.getVarc1())) && 
/* 1151 */       (this.Varc2.equals(other.getVarc2())) && 
/* 1152 */       (this.Varc3.equals(other.getVarc3())) && 
/* 1153 */       (this.Varc4.equals(other.getVarc4())) && 
/* 1154 */       (this.fDate.getString(this.DateTime1).equals(other.getDateTime1())) && 
/* 1155 */       (this.fDate.getString(this.DateTime2).equals(other.getDateTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1161 */     return 25;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1167 */     if (strFieldName.equals("EdorNo")) {
/* 1168 */       return 0;
/*      */     }
/* 1170 */     if (strFieldName.equals("serialNo")) {
/* 1171 */       return 1;
/*      */     }
/* 1173 */     if (strFieldName.equals("ID")) {
/* 1174 */       return 2;
/*      */     }
/* 1176 */     if (strFieldName.equals("ContNo")) {
/* 1177 */       return 3;
/*      */     }
/* 1179 */     if (strFieldName.equals("StockInvestAccount")) {
/* 1180 */       return 4;
/*      */     }
/* 1182 */     if (strFieldName.equals("MixedStockInvestAccount")) {
/* 1183 */       return 5;
/*      */     }
/* 1185 */     if (strFieldName.equals("MixedBondInvestAccount")) {
/* 1186 */       return 6;
/*      */     }
/* 1188 */     if (strFieldName.equals("BondInvestAccount")) {
/* 1189 */       return 7;
/*      */     }
/* 1191 */     if (strFieldName.equals("CurrencyInvestAccount")) {
/* 1192 */       return 8;
/*      */     }
/* 1194 */     if (strFieldName.equals("PayExtraPremFlag")) {
/* 1195 */       return 9;
/*      */     }
/* 1197 */     if (strFieldName.equals("MonthPlusPrem")) {
/* 1198 */       return 10;
/*      */     }
/* 1200 */     if (strFieldName.equals("TermInvestment")) {
/* 1201 */       return 11;
/*      */     }
/* 1203 */     if (strFieldName.equals("HesInvestment")) {
/* 1204 */       return 12;
/*      */     }
/* 1206 */     if (strFieldName.equals("Operator")) {
/* 1207 */       return 13;
/*      */     }
/* 1209 */     if (strFieldName.equals("MakeDate")) {
/* 1210 */       return 14;
/*      */     }
/* 1212 */     if (strFieldName.equals("MakeTime")) {
/* 1213 */       return 15;
/*      */     }
/* 1215 */     if (strFieldName.equals("ModifyDate")) {
/* 1216 */       return 16;
/*      */     }
/* 1218 */     if (strFieldName.equals("ModifyTime")) {
/* 1219 */       return 17;
/*      */     }
/* 1221 */     if (strFieldName.equals("Remark")) {
/* 1222 */       return 18;
/*      */     }
/* 1224 */     if (strFieldName.equals("Varc1")) {
/* 1225 */       return 19;
/*      */     }
/* 1227 */     if (strFieldName.equals("Varc2")) {
/* 1228 */       return 20;
/*      */     }
/* 1230 */     if (strFieldName.equals("Varc3")) {
/* 1231 */       return 21;
/*      */     }
/* 1233 */     if (strFieldName.equals("Varc4")) {
/* 1234 */       return 22;
/*      */     }
/* 1236 */     if (strFieldName.equals("DateTime1")) {
/* 1237 */       return 23;
/*      */     }
/* 1239 */     if (strFieldName.equals("DateTime2")) {
/* 1240 */       return 24;
/*      */     }
/* 1242 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1248 */     String strFieldName = "";
/* 1249 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1251 */       strFieldName = "EdorNo";
/* 1252 */       break;
/*      */     case 1:
/* 1254 */       strFieldName = "serialNo";
/* 1255 */       break;
/*      */     case 2:
/* 1257 */       strFieldName = "ID";
/* 1258 */       break;
/*      */     case 3:
/* 1260 */       strFieldName = "ContNo";
/* 1261 */       break;
/*      */     case 4:
/* 1263 */       strFieldName = "StockInvestAccount";
/* 1264 */       break;
/*      */     case 5:
/* 1266 */       strFieldName = "MixedStockInvestAccount";
/* 1267 */       break;
/*      */     case 6:
/* 1269 */       strFieldName = "MixedBondInvestAccount";
/* 1270 */       break;
/*      */     case 7:
/* 1272 */       strFieldName = "BondInvestAccount";
/* 1273 */       break;
/*      */     case 8:
/* 1275 */       strFieldName = "CurrencyInvestAccount";
/* 1276 */       break;
/*      */     case 9:
/* 1278 */       strFieldName = "PayExtraPremFlag";
/* 1279 */       break;
/*      */     case 10:
/* 1281 */       strFieldName = "MonthPlusPrem";
/* 1282 */       break;
/*      */     case 11:
/* 1284 */       strFieldName = "TermInvestment";
/* 1285 */       break;
/*      */     case 12:
/* 1287 */       strFieldName = "HesInvestment";
/* 1288 */       break;
/*      */     case 13:
/* 1290 */       strFieldName = "Operator";
/* 1291 */       break;
/*      */     case 14:
/* 1293 */       strFieldName = "MakeDate";
/* 1294 */       break;
/*      */     case 15:
/* 1296 */       strFieldName = "MakeTime";
/* 1297 */       break;
/*      */     case 16:
/* 1299 */       strFieldName = "ModifyDate";
/* 1300 */       break;
/*      */     case 17:
/* 1302 */       strFieldName = "ModifyTime";
/* 1303 */       break;
/*      */     case 18:
/* 1305 */       strFieldName = "Remark";
/* 1306 */       break;
/*      */     case 19:
/* 1308 */       strFieldName = "Varc1";
/* 1309 */       break;
/*      */     case 20:
/* 1311 */       strFieldName = "Varc2";
/* 1312 */       break;
/*      */     case 21:
/* 1314 */       strFieldName = "Varc3";
/* 1315 */       break;
/*      */     case 22:
/* 1317 */       strFieldName = "Varc4";
/* 1318 */       break;
/*      */     case 23:
/* 1320 */       strFieldName = "DateTime1";
/* 1321 */       break;
/*      */     case 24:
/* 1323 */       strFieldName = "DateTime2";
/* 1324 */       break;
/*      */     default:
/* 1326 */       strFieldName = "";
/*      */     }
/* 1328 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1334 */     if (strFieldName.equals("EdorNo")) {
/* 1335 */       return 0;
/*      */     }
/* 1337 */     if (strFieldName.equals("serialNo")) {
/* 1338 */       return 0;
/*      */     }
/* 1340 */     if (strFieldName.equals("ID")) {
/* 1341 */       return 0;
/*      */     }
/* 1343 */     if (strFieldName.equals("ContNo")) {
/* 1344 */       return 0;
/*      */     }
/* 1346 */     if (strFieldName.equals("StockInvestAccount")) {
/* 1347 */       return 4;
/*      */     }
/* 1349 */     if (strFieldName.equals("MixedStockInvestAccount")) {
/* 1350 */       return 4;
/*      */     }
/* 1352 */     if (strFieldName.equals("MixedBondInvestAccount")) {
/* 1353 */       return 4;
/*      */     }
/* 1355 */     if (strFieldName.equals("BondInvestAccount")) {
/* 1356 */       return 4;
/*      */     }
/* 1358 */     if (strFieldName.equals("CurrencyInvestAccount")) {
/* 1359 */       return 4;
/*      */     }
/* 1361 */     if (strFieldName.equals("PayExtraPremFlag")) {
/* 1362 */       return 0;
/*      */     }
/* 1364 */     if (strFieldName.equals("MonthPlusPrem")) {
/* 1365 */       return 4;
/*      */     }
/* 1367 */     if (strFieldName.equals("TermInvestment")) {
/* 1368 */       return 0;
/*      */     }
/* 1370 */     if (strFieldName.equals("HesInvestment")) {
/* 1371 */       return 0;
/*      */     }
/* 1373 */     if (strFieldName.equals("Operator")) {
/* 1374 */       return 0;
/*      */     }
/* 1376 */     if (strFieldName.equals("MakeDate")) {
/* 1377 */       return 0;
/*      */     }
/* 1379 */     if (strFieldName.equals("MakeTime")) {
/* 1380 */       return 0;
/*      */     }
/* 1382 */     if (strFieldName.equals("ModifyDate")) {
/* 1383 */       return 0;
/*      */     }
/* 1385 */     if (strFieldName.equals("ModifyTime")) {
/* 1386 */       return 0;
/*      */     }
/* 1388 */     if (strFieldName.equals("Remark")) {
/* 1389 */       return 0;
/*      */     }
/* 1391 */     if (strFieldName.equals("Varc1")) {
/* 1392 */       return 0;
/*      */     }
/* 1394 */     if (strFieldName.equals("Varc2")) {
/* 1395 */       return 0;
/*      */     }
/* 1397 */     if (strFieldName.equals("Varc3")) {
/* 1398 */       return 0;
/*      */     }
/* 1400 */     if (strFieldName.equals("Varc4")) {
/* 1401 */       return 0;
/*      */     }
/* 1403 */     if (strFieldName.equals("DateTime1")) {
/* 1404 */       return 1;
/*      */     }
/* 1406 */     if (strFieldName.equals("DateTime2")) {
/* 1407 */       return 1;
/*      */     }
/* 1409 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1415 */     int nFieldType = -1;
/* 1416 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1418 */       nFieldType = 0;
/* 1419 */       break;
/*      */     case 1:
/* 1421 */       nFieldType = 0;
/* 1422 */       break;
/*      */     case 2:
/* 1424 */       nFieldType = 0;
/* 1425 */       break;
/*      */     case 3:
/* 1427 */       nFieldType = 0;
/* 1428 */       break;
/*      */     case 4:
/* 1430 */       nFieldType = 4;
/* 1431 */       break;
/*      */     case 5:
/* 1433 */       nFieldType = 4;
/* 1434 */       break;
/*      */     case 6:
/* 1436 */       nFieldType = 4;
/* 1437 */       break;
/*      */     case 7:
/* 1439 */       nFieldType = 4;
/* 1440 */       break;
/*      */     case 8:
/* 1442 */       nFieldType = 4;
/* 1443 */       break;
/*      */     case 9:
/* 1445 */       nFieldType = 0;
/* 1446 */       break;
/*      */     case 10:
/* 1448 */       nFieldType = 4;
/* 1449 */       break;
/*      */     case 11:
/* 1451 */       nFieldType = 0;
/* 1452 */       break;
/*      */     case 12:
/* 1454 */       nFieldType = 0;
/* 1455 */       break;
/*      */     case 13:
/* 1457 */       nFieldType = 0;
/* 1458 */       break;
/*      */     case 14:
/* 1460 */       nFieldType = 0;
/* 1461 */       break;
/*      */     case 15:
/* 1463 */       nFieldType = 0;
/* 1464 */       break;
/*      */     case 16:
/* 1466 */       nFieldType = 0;
/* 1467 */       break;
/*      */     case 17:
/* 1469 */       nFieldType = 0;
/* 1470 */       break;
/*      */     case 18:
/* 1472 */       nFieldType = 0;
/* 1473 */       break;
/*      */     case 19:
/* 1475 */       nFieldType = 0;
/* 1476 */       break;
/*      */     case 20:
/* 1478 */       nFieldType = 0;
/* 1479 */       break;
/*      */     case 21:
/* 1481 */       nFieldType = 0;
/* 1482 */       break;
/*      */     case 22:
/* 1484 */       nFieldType = 0;
/* 1485 */       break;
/*      */     case 23:
/* 1487 */       nFieldType = 1;
/* 1488 */       break;
/*      */     case 24:
/* 1490 */       nFieldType = 1;
/* 1491 */       break;
/*      */     default:
/* 1493 */       nFieldType = -1;
/*      */     }
/* 1495 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPInvestmentInfoBSchema
 * JD-Core Version:    0.6.0
 */