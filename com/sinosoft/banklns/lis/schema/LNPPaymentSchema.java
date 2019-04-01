/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPPaymentDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPPaymentSchema
/*      */   implements Schema
/*      */ {
/*      */   private String ContNo;
/*      */   private String AppntID;
/*      */   private String InusredID;
/*      */   private String PayMent1;
/*      */   private String PayMent2;
/*      */   private String BankCode;
/*      */   private String Account;
/*      */   private String Operator;
/*      */   private Date MakeDate;
/*      */   private String MakeTime;
/*      */   private Date ModifyDate;
/*      */   private String ModifyTime;
/*      */   private String Varc1;
/*      */   private String Varc2;
/*      */   private String Varc3;
/*      */   private String Varc4;
/*      */   private Date DateTime1;
/*      */   private Date DateTime2;
/*      */   public static final int FIELDNUM = 18;
/*      */   private static String[] PK;
/*   61 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPPaymentSchema()
/*      */   {
/*   68 */     this.mErrors = new CErrors();
/*      */ 
/*   70 */     String[] pk = new String[1];
/*   71 */     pk[0] = "ContNo";
/*      */ 
/*   73 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   79 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getContNo()
/*      */   {
/*   84 */     if (this.ContNo != null) this.ContNo.equals("");
/*      */ 
/*   88 */     return this.ContNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*   92 */     this.ContNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getAppntID() {
/*   96 */     if (this.AppntID != null) this.AppntID.equals("");
/*      */ 
/*  100 */     return this.AppntID;
/*      */   }
/*      */ 
/*      */   public void setAppntID(String aAppntID) {
/*  104 */     this.AppntID = aAppntID;
/*      */   }
/*      */ 
/*      */   public String getInusredID() {
/*  108 */     if (this.InusredID != null) this.InusredID.equals("");
/*      */ 
/*  112 */     return this.InusredID;
/*      */   }
/*      */ 
/*      */   public void setInusredID(String aInusredID) {
/*  116 */     this.InusredID = aInusredID;
/*      */   }
/*      */ 
/*      */   public String getPayMent1() {
/*  120 */     if (this.PayMent1 != null) this.PayMent1.equals("");
/*      */ 
/*  124 */     return this.PayMent1;
/*      */   }
/*      */ 
/*      */   public void setPayMent1(String aPayMent1) {
/*  128 */     this.PayMent1 = aPayMent1;
/*      */   }
/*      */ 
/*      */   public String getPayMent2() {
/*  132 */     if (this.PayMent2 != null) this.PayMent2.equals("");
/*      */ 
/*  136 */     return this.PayMent2;
/*      */   }
/*      */ 
/*      */   public void setPayMent2(String aPayMent2) {
/*  140 */     this.PayMent2 = aPayMent2;
/*      */   }
/*      */ 
/*      */   public String getBankCode() {
/*  144 */     if (this.BankCode != null) this.BankCode.equals("");
/*      */ 
/*  148 */     return this.BankCode;
/*      */   }
/*      */ 
/*      */   public void setBankCode(String aBankCode) {
/*  152 */     this.BankCode = aBankCode;
/*      */   }
/*      */ 
/*      */   public String getAccount() {
/*  156 */     if (this.Account != null) this.Account.equals("");
/*      */ 
/*  160 */     return this.Account;
/*      */   }
/*      */ 
/*      */   public void setAccount(String aAccount) {
/*  164 */     this.Account = aAccount;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  168 */     if (this.Operator != null) this.Operator.equals("");
/*      */ 
/*  172 */     return this.Operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  176 */     this.Operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  180 */     if (this.MakeDate != null) {
/*  181 */       return this.fDate.getString(this.MakeDate);
/*      */     }
/*  183 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  187 */     this.MakeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  191 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  193 */       this.MakeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  196 */       this.MakeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  201 */     if (this.MakeTime != null) this.MakeTime.equals("");
/*      */ 
/*  205 */     return this.MakeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  209 */     this.MakeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  213 */     if (this.ModifyDate != null) {
/*  214 */       return this.fDate.getString(this.ModifyDate);
/*      */     }
/*  216 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  220 */     this.ModifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  224 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  226 */       this.ModifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  229 */       this.ModifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  234 */     if (this.ModifyTime != null) this.ModifyTime.equals("");
/*      */ 
/*  238 */     return this.ModifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  242 */     this.ModifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getVarc1() {
/*  246 */     if (this.Varc1 != null) this.Varc1.equals("");
/*      */ 
/*  250 */     return this.Varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  254 */     this.Varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  258 */     if (this.Varc2 != null) this.Varc2.equals("");
/*      */ 
/*  262 */     return this.Varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  266 */     this.Varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getVarc3() {
/*  270 */     if (this.Varc3 != null) this.Varc3.equals("");
/*      */ 
/*  274 */     return this.Varc3;
/*      */   }
/*      */ 
/*      */   public void setVarc3(String aVarc3) {
/*  278 */     this.Varc3 = aVarc3;
/*      */   }
/*      */ 
/*      */   public String getVarc4() {
/*  282 */     if (this.Varc4 != null) this.Varc4.equals("");
/*      */ 
/*  286 */     return this.Varc4;
/*      */   }
/*      */ 
/*      */   public void setVarc4(String aVarc4) {
/*  290 */     this.Varc4 = aVarc4;
/*      */   }
/*      */ 
/*      */   public String getDateTime1() {
/*  294 */     if (this.DateTime1 != null) {
/*  295 */       return this.fDate.getString(this.DateTime1);
/*      */     }
/*  297 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(Date aDateTime1) {
/*  301 */     this.DateTime1 = aDateTime1;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(String aDateTime1) {
/*  305 */     if ((aDateTime1 != null) && (!aDateTime1.equals("")))
/*      */     {
/*  307 */       this.DateTime1 = this.fDate.getDate(aDateTime1);
/*      */     }
/*      */     else
/*  310 */       this.DateTime1 = null;
/*      */   }
/*      */ 
/*      */   public String getDateTime2()
/*      */   {
/*  315 */     if (this.DateTime2 != null) {
/*  316 */       return this.fDate.getString(this.DateTime2);
/*      */     }
/*  318 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(Date aDateTime2) {
/*  322 */     this.DateTime2 = aDateTime2;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(String aDateTime2) {
/*  326 */     if ((aDateTime2 != null) && (!aDateTime2.equals("")))
/*      */     {
/*  328 */       this.DateTime2 = this.fDate.getDate(aDateTime2);
/*      */     }
/*      */     else
/*  331 */       this.DateTime2 = null;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPPaymentSchema aLNPPaymentSchema)
/*      */   {
/*  338 */     this.ContNo = aLNPPaymentSchema.getContNo();
/*  339 */     this.AppntID = aLNPPaymentSchema.getAppntID();
/*  340 */     this.InusredID = aLNPPaymentSchema.getInusredID();
/*  341 */     this.PayMent1 = aLNPPaymentSchema.getPayMent1();
/*  342 */     this.PayMent2 = aLNPPaymentSchema.getPayMent2();
/*  343 */     this.BankCode = aLNPPaymentSchema.getBankCode();
/*  344 */     this.Account = aLNPPaymentSchema.getAccount();
/*  345 */     this.Operator = aLNPPaymentSchema.getOperator();
/*  346 */     this.MakeDate = this.fDate.getDate(aLNPPaymentSchema.getMakeDate());
/*  347 */     this.MakeTime = aLNPPaymentSchema.getMakeTime();
/*  348 */     this.ModifyDate = this.fDate.getDate(aLNPPaymentSchema.getModifyDate());
/*  349 */     this.ModifyTime = aLNPPaymentSchema.getModifyTime();
/*  350 */     this.Varc1 = aLNPPaymentSchema.getVarc1();
/*  351 */     this.Varc2 = aLNPPaymentSchema.getVarc2();
/*  352 */     this.Varc3 = aLNPPaymentSchema.getVarc3();
/*  353 */     this.Varc4 = aLNPPaymentSchema.getVarc4();
/*  354 */     this.DateTime1 = this.fDate.getDate(aLNPPaymentSchema.getDateTime1());
/*  355 */     this.DateTime2 = this.fDate.getDate(aLNPPaymentSchema.getDateTime2());
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  364 */       if (rs.getString("ContNo") == null)
/*  365 */         this.ContNo = null;
/*      */       else {
/*  367 */         this.ContNo = rs.getString("ContNo").trim();
/*      */       }
/*  369 */       if (rs.getString("AppntID") == null)
/*  370 */         this.AppntID = null;
/*      */       else {
/*  372 */         this.AppntID = rs.getString("AppntID").trim();
/*      */       }
/*  374 */       if (rs.getString("InusredID") == null)
/*  375 */         this.InusredID = null;
/*      */       else {
/*  377 */         this.InusredID = rs.getString("InusredID").trim();
/*      */       }
/*  379 */       if (rs.getString("PayMent1") == null)
/*  380 */         this.PayMent1 = null;
/*      */       else {
/*  382 */         this.PayMent1 = rs.getString("PayMent1").trim();
/*      */       }
/*  384 */       if (rs.getString("PayMent2") == null)
/*  385 */         this.PayMent2 = null;
/*      */       else {
/*  387 */         this.PayMent2 = rs.getString("PayMent2").trim();
/*      */       }
/*  389 */       if (rs.getString("BankCode") == null)
/*  390 */         this.BankCode = null;
/*      */       else {
/*  392 */         this.BankCode = rs.getString("BankCode").trim();
/*      */       }
/*  394 */       if (rs.getString("Account") == null)
/*  395 */         this.Account = null;
/*      */       else {
/*  397 */         this.Account = rs.getString("Account").trim();
/*      */       }
/*  399 */       if (rs.getString("Operator") == null)
/*  400 */         this.Operator = null;
/*      */       else {
/*  402 */         this.Operator = rs.getString("Operator").trim();
/*      */       }
/*  404 */       this.MakeDate = rs.getDate("MakeDate");
/*  405 */       if (rs.getString("MakeTime") == null)
/*  406 */         this.MakeTime = null;
/*      */       else {
/*  408 */         this.MakeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  410 */       this.ModifyDate = rs.getDate("ModifyDate");
/*  411 */       if (rs.getString("ModifyTime") == null)
/*  412 */         this.ModifyTime = null;
/*      */       else {
/*  414 */         this.ModifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  416 */       if (rs.getString("Varc1") == null)
/*  417 */         this.Varc1 = null;
/*      */       else {
/*  419 */         this.Varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  421 */       if (rs.getString("Varc2") == null)
/*  422 */         this.Varc2 = null;
/*      */       else {
/*  424 */         this.Varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  426 */       if (rs.getString("Varc3") == null)
/*  427 */         this.Varc3 = null;
/*      */       else {
/*  429 */         this.Varc3 = rs.getString("Varc3").trim();
/*      */       }
/*  431 */       if (rs.getString("Varc4") == null)
/*  432 */         this.Varc4 = null;
/*      */       else {
/*  434 */         this.Varc4 = rs.getString("Varc4").trim();
/*      */       }
/*  436 */       this.DateTime1 = rs.getDate("DateTime1");
/*  437 */       this.DateTime2 = rs.getDate("DateTime2");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  442 */       CError tError = new CError();
/*  443 */       tError.moduleName = "LNPPaymentSchema";
/*  444 */       tError.functionName = "setSchema";
/*  445 */       tError.errorMessage = sqle.toString();
/*  446 */       this.mErrors.addOneError(tError);
/*      */ 
/*  448 */       return false;
/*      */     }
/*  450 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPPaymentSchema getSchema()
/*      */   {
/*  455 */     LNPPaymentSchema aLNPPaymentSchema = new LNPPaymentSchema();
/*  456 */     aLNPPaymentSchema.setSchema(this);
/*  457 */     return aLNPPaymentSchema;
/*      */   }
/*      */ 
/*      */   public LNPPaymentDB getDB()
/*      */   {
/*  462 */     LNPPaymentDB aDBOper = new LNPPaymentDB();
/*  463 */     aDBOper.setSchema(this);
/*  464 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  471 */     String strReturn = "";
/*  472 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.ContNo)) + "|" + 
/*  473 */       StrTool.cTrim(StrTool.unicodeToGBK(this.AppntID)) + "|" + 
/*  474 */       StrTool.cTrim(StrTool.unicodeToGBK(this.InusredID)) + "|" + 
/*  475 */       StrTool.cTrim(StrTool.unicodeToGBK(this.PayMent1)) + "|" + 
/*  476 */       StrTool.cTrim(StrTool.unicodeToGBK(this.PayMent2)) + "|" + 
/*  477 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BankCode)) + "|" + 
/*  478 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Account)) + "|" + 
/*  479 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Operator)) + "|" + 
/*  480 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.MakeDate))) + "|" + 
/*  481 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeTime)) + "|" + 
/*  482 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.ModifyDate))) + "|" + 
/*  483 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyTime)) + "|" + 
/*  484 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc1)) + "|" + 
/*  485 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc2)) + "|" + 
/*  486 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc3)) + "|" + 
/*  487 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc4)) + "|" + 
/*  488 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime1))) + "|" + 
/*  489 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime2)));
/*  490 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  498 */       this.ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  499 */       this.AppntID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  500 */       this.InusredID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  501 */       this.PayMent1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  502 */       this.PayMent2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  503 */       this.BankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  504 */       this.Account = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  505 */       this.Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  506 */       this.MakeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/*  507 */       this.MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  508 */       this.ModifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
/*  509 */       this.ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  510 */       this.Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  511 */       this.Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  512 */       this.Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  513 */       this.Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  514 */       this.DateTime1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  515 */       this.DateTime2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  520 */       CError tError = new CError();
/*  521 */       tError.moduleName = "LNPPaymentSchema";
/*  522 */       tError.functionName = "decode";
/*  523 */       tError.errorMessage = ex.toString();
/*  524 */       this.mErrors.addOneError(tError);
/*      */ 
/*  526 */       return false;
/*      */     }
/*  528 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  534 */     String strReturn = "";
/*  535 */     if (FCode.equals("ContNo"))
/*      */     {
/*  537 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ContNo));
/*      */     }
/*  539 */     if (FCode.equals("AppntID"))
/*      */     {
/*  541 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.AppntID));
/*      */     }
/*  543 */     if (FCode.equals("InusredID"))
/*      */     {
/*  545 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.InusredID));
/*      */     }
/*  547 */     if (FCode.equals("PayMent1"))
/*      */     {
/*  549 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.PayMent1));
/*      */     }
/*  551 */     if (FCode.equals("PayMent2"))
/*      */     {
/*  553 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.PayMent2));
/*      */     }
/*  555 */     if (FCode.equals("BankCode"))
/*      */     {
/*  557 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BankCode));
/*      */     }
/*  559 */     if (FCode.equals("Account"))
/*      */     {
/*  561 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Account));
/*      */     }
/*  563 */     if (FCode.equals("Operator"))
/*      */     {
/*  565 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Operator));
/*      */     }
/*  567 */     if (FCode.equals("MakeDate"))
/*      */     {
/*  569 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  571 */     if (FCode.equals("MakeTime"))
/*      */     {
/*  573 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeTime));
/*      */     }
/*  575 */     if (FCode.equals("ModifyDate"))
/*      */     {
/*  577 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  579 */     if (FCode.equals("ModifyTime"))
/*      */     {
/*  581 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyTime));
/*      */     }
/*  583 */     if (FCode.equals("Varc1"))
/*      */     {
/*  585 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc1));
/*      */     }
/*  587 */     if (FCode.equals("Varc2"))
/*      */     {
/*  589 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc2));
/*      */     }
/*  591 */     if (FCode.equals("Varc3"))
/*      */     {
/*  593 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc3));
/*      */     }
/*  595 */     if (FCode.equals("Varc4"))
/*      */     {
/*  597 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc4));
/*      */     }
/*  599 */     if (FCode.equals("DateTime1"))
/*      */     {
/*  601 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*      */     }
/*  603 */     if (FCode.equals("DateTime2"))
/*      */     {
/*  605 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*      */     }
/*  607 */     if (strReturn.equals(""))
/*      */     {
/*  609 */       strReturn = "null";
/*      */     }
/*      */ 
/*  612 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  619 */     String strFieldValue = "";
/*  620 */     switch (nFieldIndex) {
/*      */     case 0:
/*  622 */       strFieldValue = StrTool.GBKToUnicode(this.ContNo);
/*  623 */       break;
/*      */     case 1:
/*  625 */       strFieldValue = StrTool.GBKToUnicode(this.AppntID);
/*  626 */       break;
/*      */     case 2:
/*  628 */       strFieldValue = StrTool.GBKToUnicode(this.InusredID);
/*  629 */       break;
/*      */     case 3:
/*  631 */       strFieldValue = StrTool.GBKToUnicode(this.PayMent1);
/*  632 */       break;
/*      */     case 4:
/*  634 */       strFieldValue = StrTool.GBKToUnicode(this.PayMent2);
/*  635 */       break;
/*      */     case 5:
/*  637 */       strFieldValue = StrTool.GBKToUnicode(this.BankCode);
/*  638 */       break;
/*      */     case 6:
/*  640 */       strFieldValue = StrTool.GBKToUnicode(this.Account);
/*  641 */       break;
/*      */     case 7:
/*  643 */       strFieldValue = StrTool.GBKToUnicode(this.Operator);
/*  644 */       break;
/*      */     case 8:
/*  646 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  647 */       break;
/*      */     case 9:
/*  649 */       strFieldValue = StrTool.GBKToUnicode(this.MakeTime);
/*  650 */       break;
/*      */     case 10:
/*  652 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  653 */       break;
/*      */     case 11:
/*  655 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyTime);
/*  656 */       break;
/*      */     case 12:
/*  658 */       strFieldValue = StrTool.GBKToUnicode(this.Varc1);
/*  659 */       break;
/*      */     case 13:
/*  661 */       strFieldValue = StrTool.GBKToUnicode(this.Varc2);
/*  662 */       break;
/*      */     case 14:
/*  664 */       strFieldValue = StrTool.GBKToUnicode(this.Varc3);
/*  665 */       break;
/*      */     case 15:
/*  667 */       strFieldValue = StrTool.GBKToUnicode(this.Varc4);
/*  668 */       break;
/*      */     case 16:
/*  670 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*  671 */       break;
/*      */     case 17:
/*  673 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*  674 */       break;
/*      */     default:
/*  676 */       strFieldValue = "";
/*      */     }
/*  678 */     if (strFieldValue.equals("")) {
/*  679 */       strFieldValue = "null";
/*      */     }
/*  681 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  687 */     if (StrTool.cTrim(FCode).equals("")) {
/*  688 */       return false;
/*      */     }
/*  690 */     if (FCode.equals("ContNo"))
/*      */     {
/*  692 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  694 */         this.ContNo = FValue.trim();
/*      */       }
/*      */       else
/*  697 */         this.ContNo = null;
/*      */     }
/*  699 */     if (FCode.equals("AppntID"))
/*      */     {
/*  701 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  703 */         this.AppntID = FValue.trim();
/*      */       }
/*      */       else
/*  706 */         this.AppntID = null;
/*      */     }
/*  708 */     if (FCode.equals("InusredID"))
/*      */     {
/*  710 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  712 */         this.InusredID = FValue.trim();
/*      */       }
/*      */       else
/*  715 */         this.InusredID = null;
/*      */     }
/*  717 */     if (FCode.equals("PayMent1"))
/*      */     {
/*  719 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  721 */         this.PayMent1 = FValue.trim();
/*      */       }
/*      */       else
/*  724 */         this.PayMent1 = null;
/*      */     }
/*  726 */     if (FCode.equals("PayMent2"))
/*      */     {
/*  728 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  730 */         this.PayMent2 = FValue.trim();
/*      */       }
/*      */       else
/*  733 */         this.PayMent2 = null;
/*      */     }
/*  735 */     if (FCode.equals("BankCode"))
/*      */     {
/*  737 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  739 */         this.BankCode = FValue.trim();
/*      */       }
/*      */       else
/*  742 */         this.BankCode = null;
/*      */     }
/*  744 */     if (FCode.equals("Account"))
/*      */     {
/*  746 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  748 */         this.Account = FValue.trim();
/*      */       }
/*      */       else
/*  751 */         this.Account = null;
/*      */     }
/*  753 */     if (FCode.equals("Operator"))
/*      */     {
/*  755 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  757 */         this.Operator = FValue.trim();
/*      */       }
/*      */       else
/*  760 */         this.Operator = null;
/*      */     }
/*  762 */     if (FCode.equals("MakeDate"))
/*      */     {
/*  764 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  766 */         this.MakeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  769 */         this.MakeDate = null;
/*      */     }
/*  771 */     if (FCode.equals("MakeTime"))
/*      */     {
/*  773 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  775 */         this.MakeTime = FValue.trim();
/*      */       }
/*      */       else
/*  778 */         this.MakeTime = null;
/*      */     }
/*  780 */     if (FCode.equals("ModifyDate"))
/*      */     {
/*  782 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  784 */         this.ModifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  787 */         this.ModifyDate = null;
/*      */     }
/*  789 */     if (FCode.equals("ModifyTime"))
/*      */     {
/*  791 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  793 */         this.ModifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  796 */         this.ModifyTime = null;
/*      */     }
/*  798 */     if (FCode.equals("Varc1"))
/*      */     {
/*  800 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  802 */         this.Varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  805 */         this.Varc1 = null;
/*      */     }
/*  807 */     if (FCode.equals("Varc2"))
/*      */     {
/*  809 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  811 */         this.Varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  814 */         this.Varc2 = null;
/*      */     }
/*  816 */     if (FCode.equals("Varc3"))
/*      */     {
/*  818 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  820 */         this.Varc3 = FValue.trim();
/*      */       }
/*      */       else
/*  823 */         this.Varc3 = null;
/*      */     }
/*  825 */     if (FCode.equals("Varc4"))
/*      */     {
/*  827 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  829 */         this.Varc4 = FValue.trim();
/*      */       }
/*      */       else
/*  832 */         this.Varc4 = null;
/*      */     }
/*  834 */     if (FCode.equals("DateTime1"))
/*      */     {
/*  836 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  838 */         this.DateTime1 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  841 */         this.DateTime1 = null;
/*      */     }
/*  843 */     if (FCode.equals("DateTime2"))
/*      */     {
/*  845 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  847 */         this.DateTime2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  850 */         this.DateTime2 = null;
/*      */     }
/*  852 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  857 */     if (this == otherObject) return true;
/*  858 */     if (otherObject == null) return false;
/*  859 */     if (getClass() != otherObject.getClass()) return false;
/*  860 */     LNPPaymentSchema other = (LNPPaymentSchema)otherObject;
/*  861 */     return 
/*  862 */       (this.ContNo.equals(other.getContNo())) && 
/*  863 */       (this.AppntID.equals(other.getAppntID())) && 
/*  864 */       (this.InusredID.equals(other.getInusredID())) && 
/*  865 */       (this.PayMent1.equals(other.getPayMent1())) && 
/*  866 */       (this.PayMent2.equals(other.getPayMent2())) && 
/*  867 */       (this.BankCode.equals(other.getBankCode())) && 
/*  868 */       (this.Account.equals(other.getAccount())) && 
/*  869 */       (this.Operator.equals(other.getOperator())) && 
/*  870 */       (this.fDate.getString(this.MakeDate).equals(other.getMakeDate())) && 
/*  871 */       (this.MakeTime.equals(other.getMakeTime())) && 
/*  872 */       (this.fDate.getString(this.ModifyDate).equals(other.getModifyDate())) && 
/*  873 */       (this.ModifyTime.equals(other.getModifyTime())) && 
/*  874 */       (this.Varc1.equals(other.getVarc1())) && 
/*  875 */       (this.Varc2.equals(other.getVarc2())) && 
/*  876 */       (this.Varc3.equals(other.getVarc3())) && 
/*  877 */       (this.Varc4.equals(other.getVarc4())) && 
/*  878 */       (this.fDate.getString(this.DateTime1).equals(other.getDateTime1())) && 
/*  879 */       (this.fDate.getString(this.DateTime2).equals(other.getDateTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  885 */     return 18;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  891 */     if (strFieldName.equals("ContNo")) {
/*  892 */       return 0;
/*      */     }
/*  894 */     if (strFieldName.equals("AppntID")) {
/*  895 */       return 1;
/*      */     }
/*  897 */     if (strFieldName.equals("InusredID")) {
/*  898 */       return 2;
/*      */     }
/*  900 */     if (strFieldName.equals("PayMent1")) {
/*  901 */       return 3;
/*      */     }
/*  903 */     if (strFieldName.equals("PayMent2")) {
/*  904 */       return 4;
/*      */     }
/*  906 */     if (strFieldName.equals("BankCode")) {
/*  907 */       return 5;
/*      */     }
/*  909 */     if (strFieldName.equals("Account")) {
/*  910 */       return 6;
/*      */     }
/*  912 */     if (strFieldName.equals("Operator")) {
/*  913 */       return 7;
/*      */     }
/*  915 */     if (strFieldName.equals("MakeDate")) {
/*  916 */       return 8;
/*      */     }
/*  918 */     if (strFieldName.equals("MakeTime")) {
/*  919 */       return 9;
/*      */     }
/*  921 */     if (strFieldName.equals("ModifyDate")) {
/*  922 */       return 10;
/*      */     }
/*  924 */     if (strFieldName.equals("ModifyTime")) {
/*  925 */       return 11;
/*      */     }
/*  927 */     if (strFieldName.equals("Varc1")) {
/*  928 */       return 12;
/*      */     }
/*  930 */     if (strFieldName.equals("Varc2")) {
/*  931 */       return 13;
/*      */     }
/*  933 */     if (strFieldName.equals("Varc3")) {
/*  934 */       return 14;
/*      */     }
/*  936 */     if (strFieldName.equals("Varc4")) {
/*  937 */       return 15;
/*      */     }
/*  939 */     if (strFieldName.equals("DateTime1")) {
/*  940 */       return 16;
/*      */     }
/*  942 */     if (strFieldName.equals("DateTime2")) {
/*  943 */       return 17;
/*      */     }
/*  945 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  951 */     String strFieldName = "";
/*  952 */     switch (nFieldIndex) {
/*      */     case 0:
/*  954 */       strFieldName = "ContNo";
/*  955 */       break;
/*      */     case 1:
/*  957 */       strFieldName = "AppntID";
/*  958 */       break;
/*      */     case 2:
/*  960 */       strFieldName = "InusredID";
/*  961 */       break;
/*      */     case 3:
/*  963 */       strFieldName = "PayMent1";
/*  964 */       break;
/*      */     case 4:
/*  966 */       strFieldName = "PayMent2";
/*  967 */       break;
/*      */     case 5:
/*  969 */       strFieldName = "BankCode";
/*  970 */       break;
/*      */     case 6:
/*  972 */       strFieldName = "Account";
/*  973 */       break;
/*      */     case 7:
/*  975 */       strFieldName = "Operator";
/*  976 */       break;
/*      */     case 8:
/*  978 */       strFieldName = "MakeDate";
/*  979 */       break;
/*      */     case 9:
/*  981 */       strFieldName = "MakeTime";
/*  982 */       break;
/*      */     case 10:
/*  984 */       strFieldName = "ModifyDate";
/*  985 */       break;
/*      */     case 11:
/*  987 */       strFieldName = "ModifyTime";
/*  988 */       break;
/*      */     case 12:
/*  990 */       strFieldName = "Varc1";
/*  991 */       break;
/*      */     case 13:
/*  993 */       strFieldName = "Varc2";
/*  994 */       break;
/*      */     case 14:
/*  996 */       strFieldName = "Varc3";
/*  997 */       break;
/*      */     case 15:
/*  999 */       strFieldName = "Varc4";
/* 1000 */       break;
/*      */     case 16:
/* 1002 */       strFieldName = "DateTime1";
/* 1003 */       break;
/*      */     case 17:
/* 1005 */       strFieldName = "DateTime2";
/* 1006 */       break;
/*      */     default:
/* 1008 */       strFieldName = "";
/*      */     }
/* 1010 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1016 */     if (strFieldName.equals("ContNo")) {
/* 1017 */       return 0;
/*      */     }
/* 1019 */     if (strFieldName.equals("AppntID")) {
/* 1020 */       return 0;
/*      */     }
/* 1022 */     if (strFieldName.equals("InusredID")) {
/* 1023 */       return 0;
/*      */     }
/* 1025 */     if (strFieldName.equals("PayMent1")) {
/* 1026 */       return 0;
/*      */     }
/* 1028 */     if (strFieldName.equals("PayMent2")) {
/* 1029 */       return 0;
/*      */     }
/* 1031 */     if (strFieldName.equals("BankCode")) {
/* 1032 */       return 0;
/*      */     }
/* 1034 */     if (strFieldName.equals("Account")) {
/* 1035 */       return 0;
/*      */     }
/* 1037 */     if (strFieldName.equals("Operator")) {
/* 1038 */       return 0;
/*      */     }
/* 1040 */     if (strFieldName.equals("MakeDate")) {
/* 1041 */       return 1;
/*      */     }
/* 1043 */     if (strFieldName.equals("MakeTime")) {
/* 1044 */       return 0;
/*      */     }
/* 1046 */     if (strFieldName.equals("ModifyDate")) {
/* 1047 */       return 1;
/*      */     }
/* 1049 */     if (strFieldName.equals("ModifyTime")) {
/* 1050 */       return 0;
/*      */     }
/* 1052 */     if (strFieldName.equals("Varc1")) {
/* 1053 */       return 0;
/*      */     }
/* 1055 */     if (strFieldName.equals("Varc2")) {
/* 1056 */       return 0;
/*      */     }
/* 1058 */     if (strFieldName.equals("Varc3")) {
/* 1059 */       return 0;
/*      */     }
/* 1061 */     if (strFieldName.equals("Varc4")) {
/* 1062 */       return 0;
/*      */     }
/* 1064 */     if (strFieldName.equals("DateTime1")) {
/* 1065 */       return 1;
/*      */     }
/* 1067 */     if (strFieldName.equals("DateTime2")) {
/* 1068 */       return 1;
/*      */     }
/* 1070 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1076 */     int nFieldType = -1;
/* 1077 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1079 */       nFieldType = 0;
/* 1080 */       break;
/*      */     case 1:
/* 1082 */       nFieldType = 0;
/* 1083 */       break;
/*      */     case 2:
/* 1085 */       nFieldType = 0;
/* 1086 */       break;
/*      */     case 3:
/* 1088 */       nFieldType = 0;
/* 1089 */       break;
/*      */     case 4:
/* 1091 */       nFieldType = 0;
/* 1092 */       break;
/*      */     case 5:
/* 1094 */       nFieldType = 0;
/* 1095 */       break;
/*      */     case 6:
/* 1097 */       nFieldType = 0;
/* 1098 */       break;
/*      */     case 7:
/* 1100 */       nFieldType = 0;
/* 1101 */       break;
/*      */     case 8:
/* 1103 */       nFieldType = 1;
/* 1104 */       break;
/*      */     case 9:
/* 1106 */       nFieldType = 0;
/* 1107 */       break;
/*      */     case 10:
/* 1109 */       nFieldType = 1;
/* 1110 */       break;
/*      */     case 11:
/* 1112 */       nFieldType = 0;
/* 1113 */       break;
/*      */     case 12:
/* 1115 */       nFieldType = 0;
/* 1116 */       break;
/*      */     case 13:
/* 1118 */       nFieldType = 0;
/* 1119 */       break;
/*      */     case 14:
/* 1121 */       nFieldType = 0;
/* 1122 */       break;
/*      */     case 15:
/* 1124 */       nFieldType = 0;
/* 1125 */       break;
/*      */     case 16:
/* 1127 */       nFieldType = 1;
/* 1128 */       break;
/*      */     case 17:
/* 1130 */       nFieldType = 1;
/* 1131 */       break;
/*      */     default:
/* 1133 */       nFieldType = -1;
/*      */     }
/* 1135 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPPaymentSchema
 * JD-Core Version:    0.6.0
 */