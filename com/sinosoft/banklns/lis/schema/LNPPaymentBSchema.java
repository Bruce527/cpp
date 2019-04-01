/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPPaymentBDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPPaymentBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
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
/*      */   public static final int FIELDNUM = 20;
/*      */   private static String[] PK;
/*   65 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPPaymentBSchema()
/*      */   {
/*   72 */     this.mErrors = new CErrors();
/*      */ 
/*   74 */     String[] pk = new String[2];
/*   75 */     pk[0] = "EdorNo";
/*   76 */     pk[1] = "serialNo";
/*      */ 
/*   78 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   84 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*   89 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*   93 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*   97 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*  101 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  105 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  109 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  113 */     if (this.ContNo != null) this.ContNo.equals("");
/*      */ 
/*  117 */     return this.ContNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  121 */     this.ContNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getAppntID() {
/*  125 */     if (this.AppntID != null) this.AppntID.equals("");
/*      */ 
/*  129 */     return this.AppntID;
/*      */   }
/*      */ 
/*      */   public void setAppntID(String aAppntID) {
/*  133 */     this.AppntID = aAppntID;
/*      */   }
/*      */ 
/*      */   public String getInusredID() {
/*  137 */     if (this.InusredID != null) this.InusredID.equals("");
/*      */ 
/*  141 */     return this.InusredID;
/*      */   }
/*      */ 
/*      */   public void setInusredID(String aInusredID) {
/*  145 */     this.InusredID = aInusredID;
/*      */   }
/*      */ 
/*      */   public String getPayMent1() {
/*  149 */     if (this.PayMent1 != null) this.PayMent1.equals("");
/*      */ 
/*  153 */     return this.PayMent1;
/*      */   }
/*      */ 
/*      */   public void setPayMent1(String aPayMent1) {
/*  157 */     this.PayMent1 = aPayMent1;
/*      */   }
/*      */ 
/*      */   public String getPayMent2() {
/*  161 */     if (this.PayMent2 != null) this.PayMent2.equals("");
/*      */ 
/*  165 */     return this.PayMent2;
/*      */   }
/*      */ 
/*      */   public void setPayMent2(String aPayMent2) {
/*  169 */     this.PayMent2 = aPayMent2;
/*      */   }
/*      */ 
/*      */   public String getBankCode() {
/*  173 */     if (this.BankCode != null) this.BankCode.equals("");
/*      */ 
/*  177 */     return this.BankCode;
/*      */   }
/*      */ 
/*      */   public void setBankCode(String aBankCode) {
/*  181 */     this.BankCode = aBankCode;
/*      */   }
/*      */ 
/*      */   public String getAccount() {
/*  185 */     if (this.Account != null) this.Account.equals("");
/*      */ 
/*  189 */     return this.Account;
/*      */   }
/*      */ 
/*      */   public void setAccount(String aAccount) {
/*  193 */     this.Account = aAccount;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  197 */     if (this.Operator != null) this.Operator.equals("");
/*      */ 
/*  201 */     return this.Operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  205 */     this.Operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  209 */     if (this.MakeDate != null) {
/*  210 */       return this.fDate.getString(this.MakeDate);
/*      */     }
/*  212 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  216 */     this.MakeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  220 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  222 */       this.MakeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  225 */       this.MakeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  230 */     if (this.MakeTime != null) this.MakeTime.equals("");
/*      */ 
/*  234 */     return this.MakeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  238 */     this.MakeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  242 */     if (this.ModifyDate != null) {
/*  243 */       return this.fDate.getString(this.ModifyDate);
/*      */     }
/*  245 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  249 */     this.ModifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  253 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  255 */       this.ModifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  258 */       this.ModifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  263 */     if (this.ModifyTime != null) this.ModifyTime.equals("");
/*      */ 
/*  267 */     return this.ModifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  271 */     this.ModifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getVarc1() {
/*  275 */     if (this.Varc1 != null) this.Varc1.equals("");
/*      */ 
/*  279 */     return this.Varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  283 */     this.Varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  287 */     if (this.Varc2 != null) this.Varc2.equals("");
/*      */ 
/*  291 */     return this.Varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  295 */     this.Varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getVarc3() {
/*  299 */     if (this.Varc3 != null) this.Varc3.equals("");
/*      */ 
/*  303 */     return this.Varc3;
/*      */   }
/*      */ 
/*      */   public void setVarc3(String aVarc3) {
/*  307 */     this.Varc3 = aVarc3;
/*      */   }
/*      */ 
/*      */   public String getVarc4() {
/*  311 */     if (this.Varc4 != null) this.Varc4.equals("");
/*      */ 
/*  315 */     return this.Varc4;
/*      */   }
/*      */ 
/*      */   public void setVarc4(String aVarc4) {
/*  319 */     this.Varc4 = aVarc4;
/*      */   }
/*      */ 
/*      */   public String getDateTime1() {
/*  323 */     if (this.DateTime1 != null) {
/*  324 */       return this.fDate.getString(this.DateTime1);
/*      */     }
/*  326 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(Date aDateTime1) {
/*  330 */     this.DateTime1 = aDateTime1;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(String aDateTime1) {
/*  334 */     if ((aDateTime1 != null) && (!aDateTime1.equals("")))
/*      */     {
/*  336 */       this.DateTime1 = this.fDate.getDate(aDateTime1);
/*      */     }
/*      */     else
/*  339 */       this.DateTime1 = null;
/*      */   }
/*      */ 
/*      */   public String getDateTime2()
/*      */   {
/*  344 */     if (this.DateTime2 != null) {
/*  345 */       return this.fDate.getString(this.DateTime2);
/*      */     }
/*  347 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(Date aDateTime2) {
/*  351 */     this.DateTime2 = aDateTime2;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(String aDateTime2) {
/*  355 */     if ((aDateTime2 != null) && (!aDateTime2.equals("")))
/*      */     {
/*  357 */       this.DateTime2 = this.fDate.getDate(aDateTime2);
/*      */     }
/*      */     else
/*  360 */       this.DateTime2 = null;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPPaymentBSchema aLNPPaymentBSchema)
/*      */   {
/*  367 */     this.EdorNo = aLNPPaymentBSchema.getEdorNo();
/*  368 */     this.serialNo = aLNPPaymentBSchema.getserialNo();
/*  369 */     this.ContNo = aLNPPaymentBSchema.getContNo();
/*  370 */     this.AppntID = aLNPPaymentBSchema.getAppntID();
/*  371 */     this.InusredID = aLNPPaymentBSchema.getInusredID();
/*  372 */     this.PayMent1 = aLNPPaymentBSchema.getPayMent1();
/*  373 */     this.PayMent2 = aLNPPaymentBSchema.getPayMent2();
/*  374 */     this.BankCode = aLNPPaymentBSchema.getBankCode();
/*  375 */     this.Account = aLNPPaymentBSchema.getAccount();
/*  376 */     this.Operator = aLNPPaymentBSchema.getOperator();
/*  377 */     this.MakeDate = this.fDate.getDate(aLNPPaymentBSchema.getMakeDate());
/*  378 */     this.MakeTime = aLNPPaymentBSchema.getMakeTime();
/*  379 */     this.ModifyDate = this.fDate.getDate(aLNPPaymentBSchema.getModifyDate());
/*  380 */     this.ModifyTime = aLNPPaymentBSchema.getModifyTime();
/*  381 */     this.Varc1 = aLNPPaymentBSchema.getVarc1();
/*  382 */     this.Varc2 = aLNPPaymentBSchema.getVarc2();
/*  383 */     this.Varc3 = aLNPPaymentBSchema.getVarc3();
/*  384 */     this.Varc4 = aLNPPaymentBSchema.getVarc4();
/*  385 */     this.DateTime1 = this.fDate.getDate(aLNPPaymentBSchema.getDateTime1());
/*  386 */     this.DateTime2 = this.fDate.getDate(aLNPPaymentBSchema.getDateTime2());
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  395 */       if (rs.getString("EdorNo") == null)
/*  396 */         this.EdorNo = null;
/*      */       else {
/*  398 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  400 */       if (rs.getString("serialNo") == null)
/*  401 */         this.serialNo = null;
/*      */       else {
/*  403 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/*  405 */       if (rs.getString("ContNo") == null)
/*  406 */         this.ContNo = null;
/*      */       else {
/*  408 */         this.ContNo = rs.getString("ContNo").trim();
/*      */       }
/*  410 */       if (rs.getString("AppntID") == null)
/*  411 */         this.AppntID = null;
/*      */       else {
/*  413 */         this.AppntID = rs.getString("AppntID").trim();
/*      */       }
/*  415 */       if (rs.getString("InusredID") == null)
/*  416 */         this.InusredID = null;
/*      */       else {
/*  418 */         this.InusredID = rs.getString("InusredID").trim();
/*      */       }
/*  420 */       if (rs.getString("PayMent1") == null)
/*  421 */         this.PayMent1 = null;
/*      */       else {
/*  423 */         this.PayMent1 = rs.getString("PayMent1").trim();
/*      */       }
/*  425 */       if (rs.getString("PayMent2") == null)
/*  426 */         this.PayMent2 = null;
/*      */       else {
/*  428 */         this.PayMent2 = rs.getString("PayMent2").trim();
/*      */       }
/*  430 */       if (rs.getString("BankCode") == null)
/*  431 */         this.BankCode = null;
/*      */       else {
/*  433 */         this.BankCode = rs.getString("BankCode").trim();
/*      */       }
/*  435 */       if (rs.getString("Account") == null)
/*  436 */         this.Account = null;
/*      */       else {
/*  438 */         this.Account = rs.getString("Account").trim();
/*      */       }
/*  440 */       if (rs.getString("Operator") == null)
/*  441 */         this.Operator = null;
/*      */       else {
/*  443 */         this.Operator = rs.getString("Operator").trim();
/*      */       }
/*  445 */       this.MakeDate = rs.getDate("MakeDate");
/*  446 */       if (rs.getString("MakeTime") == null)
/*  447 */         this.MakeTime = null;
/*      */       else {
/*  449 */         this.MakeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  451 */       this.ModifyDate = rs.getDate("ModifyDate");
/*  452 */       if (rs.getString("ModifyTime") == null)
/*  453 */         this.ModifyTime = null;
/*      */       else {
/*  455 */         this.ModifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  457 */       if (rs.getString("Varc1") == null)
/*  458 */         this.Varc1 = null;
/*      */       else {
/*  460 */         this.Varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  462 */       if (rs.getString("Varc2") == null)
/*  463 */         this.Varc2 = null;
/*      */       else {
/*  465 */         this.Varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  467 */       if (rs.getString("Varc3") == null)
/*  468 */         this.Varc3 = null;
/*      */       else {
/*  470 */         this.Varc3 = rs.getString("Varc3").trim();
/*      */       }
/*  472 */       if (rs.getString("Varc4") == null)
/*  473 */         this.Varc4 = null;
/*      */       else {
/*  475 */         this.Varc4 = rs.getString("Varc4").trim();
/*      */       }
/*  477 */       this.DateTime1 = rs.getDate("DateTime1");
/*  478 */       this.DateTime2 = rs.getDate("DateTime2");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  483 */       CError tError = new CError();
/*  484 */       tError.moduleName = "LNPPaymentBSchema";
/*  485 */       tError.functionName = "setSchema";
/*  486 */       tError.errorMessage = sqle.toString();
/*  487 */       this.mErrors.addOneError(tError);
/*      */ 
/*  489 */       return false;
/*      */     }
/*  491 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPPaymentBSchema getSchema()
/*      */   {
/*  496 */     LNPPaymentBSchema aLNPPaymentBSchema = new LNPPaymentBSchema();
/*  497 */     aLNPPaymentBSchema.setSchema(this);
/*  498 */     return aLNPPaymentBSchema;
/*      */   }
/*      */ 
/*      */   public LNPPaymentBDB getDB()
/*      */   {
/*  503 */     LNPPaymentBDB aDBOper = new LNPPaymentBDB();
/*  504 */     aDBOper.setSchema(this);
/*  505 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  512 */     String strReturn = "";
/*  513 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/*  514 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/*  515 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ContNo)) + "|" + 
/*  516 */       StrTool.cTrim(StrTool.unicodeToGBK(this.AppntID)) + "|" + 
/*  517 */       StrTool.cTrim(StrTool.unicodeToGBK(this.InusredID)) + "|" + 
/*  518 */       StrTool.cTrim(StrTool.unicodeToGBK(this.PayMent1)) + "|" + 
/*  519 */       StrTool.cTrim(StrTool.unicodeToGBK(this.PayMent2)) + "|" + 
/*  520 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BankCode)) + "|" + 
/*  521 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Account)) + "|" + 
/*  522 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Operator)) + "|" + 
/*  523 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.MakeDate))) + "|" + 
/*  524 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeTime)) + "|" + 
/*  525 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.ModifyDate))) + "|" + 
/*  526 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyTime)) + "|" + 
/*  527 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc1)) + "|" + 
/*  528 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc2)) + "|" + 
/*  529 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc3)) + "|" + 
/*  530 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc4)) + "|" + 
/*  531 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime1))) + "|" + 
/*  532 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime2)));
/*  533 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  541 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  542 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  543 */       this.ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  544 */       this.AppntID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  545 */       this.InusredID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  546 */       this.PayMent1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  547 */       this.PayMent2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  548 */       this.BankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  549 */       this.Account = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  550 */       this.Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  551 */       this.MakeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
/*  552 */       this.MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  553 */       this.ModifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
/*  554 */       this.ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  555 */       this.Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  556 */       this.Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  557 */       this.Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  558 */       this.Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  559 */       this.DateTime1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
/*  560 */       this.DateTime2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  565 */       CError tError = new CError();
/*  566 */       tError.moduleName = "LNPPaymentBSchema";
/*  567 */       tError.functionName = "decode";
/*  568 */       tError.errorMessage = ex.toString();
/*  569 */       this.mErrors.addOneError(tError);
/*      */ 
/*  571 */       return false;
/*      */     }
/*  573 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  579 */     String strReturn = "";
/*  580 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  582 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/*  584 */     if (FCode.equals("serialNo"))
/*      */     {
/*  586 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/*  588 */     if (FCode.equals("ContNo"))
/*      */     {
/*  590 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ContNo));
/*      */     }
/*  592 */     if (FCode.equals("AppntID"))
/*      */     {
/*  594 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.AppntID));
/*      */     }
/*  596 */     if (FCode.equals("InusredID"))
/*      */     {
/*  598 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.InusredID));
/*      */     }
/*  600 */     if (FCode.equals("PayMent1"))
/*      */     {
/*  602 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.PayMent1));
/*      */     }
/*  604 */     if (FCode.equals("PayMent2"))
/*      */     {
/*  606 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.PayMent2));
/*      */     }
/*  608 */     if (FCode.equals("BankCode"))
/*      */     {
/*  610 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BankCode));
/*      */     }
/*  612 */     if (FCode.equals("Account"))
/*      */     {
/*  614 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Account));
/*      */     }
/*  616 */     if (FCode.equals("Operator"))
/*      */     {
/*  618 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Operator));
/*      */     }
/*  620 */     if (FCode.equals("MakeDate"))
/*      */     {
/*  622 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  624 */     if (FCode.equals("MakeTime"))
/*      */     {
/*  626 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeTime));
/*      */     }
/*  628 */     if (FCode.equals("ModifyDate"))
/*      */     {
/*  630 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  632 */     if (FCode.equals("ModifyTime"))
/*      */     {
/*  634 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyTime));
/*      */     }
/*  636 */     if (FCode.equals("Varc1"))
/*      */     {
/*  638 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc1));
/*      */     }
/*  640 */     if (FCode.equals("Varc2"))
/*      */     {
/*  642 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc2));
/*      */     }
/*  644 */     if (FCode.equals("Varc3"))
/*      */     {
/*  646 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc3));
/*      */     }
/*  648 */     if (FCode.equals("Varc4"))
/*      */     {
/*  650 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc4));
/*      */     }
/*  652 */     if (FCode.equals("DateTime1"))
/*      */     {
/*  654 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*      */     }
/*  656 */     if (FCode.equals("DateTime2"))
/*      */     {
/*  658 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*      */     }
/*  660 */     if (strReturn.equals(""))
/*      */     {
/*  662 */       strReturn = "null";
/*      */     }
/*      */ 
/*  665 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  672 */     String strFieldValue = "";
/*  673 */     switch (nFieldIndex) {
/*      */     case 0:
/*  675 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/*  676 */       break;
/*      */     case 1:
/*  678 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/*  679 */       break;
/*      */     case 2:
/*  681 */       strFieldValue = StrTool.GBKToUnicode(this.ContNo);
/*  682 */       break;
/*      */     case 3:
/*  684 */       strFieldValue = StrTool.GBKToUnicode(this.AppntID);
/*  685 */       break;
/*      */     case 4:
/*  687 */       strFieldValue = StrTool.GBKToUnicode(this.InusredID);
/*  688 */       break;
/*      */     case 5:
/*  690 */       strFieldValue = StrTool.GBKToUnicode(this.PayMent1);
/*  691 */       break;
/*      */     case 6:
/*  693 */       strFieldValue = StrTool.GBKToUnicode(this.PayMent2);
/*  694 */       break;
/*      */     case 7:
/*  696 */       strFieldValue = StrTool.GBKToUnicode(this.BankCode);
/*  697 */       break;
/*      */     case 8:
/*  699 */       strFieldValue = StrTool.GBKToUnicode(this.Account);
/*  700 */       break;
/*      */     case 9:
/*  702 */       strFieldValue = StrTool.GBKToUnicode(this.Operator);
/*  703 */       break;
/*      */     case 10:
/*  705 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  706 */       break;
/*      */     case 11:
/*  708 */       strFieldValue = StrTool.GBKToUnicode(this.MakeTime);
/*  709 */       break;
/*      */     case 12:
/*  711 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  712 */       break;
/*      */     case 13:
/*  714 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyTime);
/*  715 */       break;
/*      */     case 14:
/*  717 */       strFieldValue = StrTool.GBKToUnicode(this.Varc1);
/*  718 */       break;
/*      */     case 15:
/*  720 */       strFieldValue = StrTool.GBKToUnicode(this.Varc2);
/*  721 */       break;
/*      */     case 16:
/*  723 */       strFieldValue = StrTool.GBKToUnicode(this.Varc3);
/*  724 */       break;
/*      */     case 17:
/*  726 */       strFieldValue = StrTool.GBKToUnicode(this.Varc4);
/*  727 */       break;
/*      */     case 18:
/*  729 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*  730 */       break;
/*      */     case 19:
/*  732 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*  733 */       break;
/*      */     default:
/*  735 */       strFieldValue = "";
/*      */     }
/*  737 */     if (strFieldValue.equals("")) {
/*  738 */       strFieldValue = "null";
/*      */     }
/*  740 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  746 */     if (StrTool.cTrim(FCode).equals("")) {
/*  747 */       return false;
/*      */     }
/*  749 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  751 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  753 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/*  756 */         this.EdorNo = null;
/*      */     }
/*  758 */     if (FCode.equals("serialNo"))
/*      */     {
/*  760 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  762 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/*  765 */         this.serialNo = null;
/*      */     }
/*  767 */     if (FCode.equals("ContNo"))
/*      */     {
/*  769 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  771 */         this.ContNo = FValue.trim();
/*      */       }
/*      */       else
/*  774 */         this.ContNo = null;
/*      */     }
/*  776 */     if (FCode.equals("AppntID"))
/*      */     {
/*  778 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  780 */         this.AppntID = FValue.trim();
/*      */       }
/*      */       else
/*  783 */         this.AppntID = null;
/*      */     }
/*  785 */     if (FCode.equals("InusredID"))
/*      */     {
/*  787 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  789 */         this.InusredID = FValue.trim();
/*      */       }
/*      */       else
/*  792 */         this.InusredID = null;
/*      */     }
/*  794 */     if (FCode.equals("PayMent1"))
/*      */     {
/*  796 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  798 */         this.PayMent1 = FValue.trim();
/*      */       }
/*      */       else
/*  801 */         this.PayMent1 = null;
/*      */     }
/*  803 */     if (FCode.equals("PayMent2"))
/*      */     {
/*  805 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  807 */         this.PayMent2 = FValue.trim();
/*      */       }
/*      */       else
/*  810 */         this.PayMent2 = null;
/*      */     }
/*  812 */     if (FCode.equals("BankCode"))
/*      */     {
/*  814 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  816 */         this.BankCode = FValue.trim();
/*      */       }
/*      */       else
/*  819 */         this.BankCode = null;
/*      */     }
/*  821 */     if (FCode.equals("Account"))
/*      */     {
/*  823 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  825 */         this.Account = FValue.trim();
/*      */       }
/*      */       else
/*  828 */         this.Account = null;
/*      */     }
/*  830 */     if (FCode.equals("Operator"))
/*      */     {
/*  832 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  834 */         this.Operator = FValue.trim();
/*      */       }
/*      */       else
/*  837 */         this.Operator = null;
/*      */     }
/*  839 */     if (FCode.equals("MakeDate"))
/*      */     {
/*  841 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  843 */         this.MakeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  846 */         this.MakeDate = null;
/*      */     }
/*  848 */     if (FCode.equals("MakeTime"))
/*      */     {
/*  850 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  852 */         this.MakeTime = FValue.trim();
/*      */       }
/*      */       else
/*  855 */         this.MakeTime = null;
/*      */     }
/*  857 */     if (FCode.equals("ModifyDate"))
/*      */     {
/*  859 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  861 */         this.ModifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  864 */         this.ModifyDate = null;
/*      */     }
/*  866 */     if (FCode.equals("ModifyTime"))
/*      */     {
/*  868 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  870 */         this.ModifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  873 */         this.ModifyTime = null;
/*      */     }
/*  875 */     if (FCode.equals("Varc1"))
/*      */     {
/*  877 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  879 */         this.Varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  882 */         this.Varc1 = null;
/*      */     }
/*  884 */     if (FCode.equals("Varc2"))
/*      */     {
/*  886 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  888 */         this.Varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  891 */         this.Varc2 = null;
/*      */     }
/*  893 */     if (FCode.equals("Varc3"))
/*      */     {
/*  895 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  897 */         this.Varc3 = FValue.trim();
/*      */       }
/*      */       else
/*  900 */         this.Varc3 = null;
/*      */     }
/*  902 */     if (FCode.equals("Varc4"))
/*      */     {
/*  904 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  906 */         this.Varc4 = FValue.trim();
/*      */       }
/*      */       else
/*  909 */         this.Varc4 = null;
/*      */     }
/*  911 */     if (FCode.equals("DateTime1"))
/*      */     {
/*  913 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  915 */         this.DateTime1 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  918 */         this.DateTime1 = null;
/*      */     }
/*  920 */     if (FCode.equals("DateTime2"))
/*      */     {
/*  922 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  924 */         this.DateTime2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  927 */         this.DateTime2 = null;
/*      */     }
/*  929 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  934 */     if (this == otherObject) return true;
/*  935 */     if (otherObject == null) return false;
/*  936 */     if (getClass() != otherObject.getClass()) return false;
/*  937 */     LNPPaymentBSchema other = (LNPPaymentBSchema)otherObject;
/*  938 */     return 
/*  939 */       (this.EdorNo.equals(other.getEdorNo())) && 
/*  940 */       (this.serialNo.equals(other.getserialNo())) && 
/*  941 */       (this.ContNo.equals(other.getContNo())) && 
/*  942 */       (this.AppntID.equals(other.getAppntID())) && 
/*  943 */       (this.InusredID.equals(other.getInusredID())) && 
/*  944 */       (this.PayMent1.equals(other.getPayMent1())) && 
/*  945 */       (this.PayMent2.equals(other.getPayMent2())) && 
/*  946 */       (this.BankCode.equals(other.getBankCode())) && 
/*  947 */       (this.Account.equals(other.getAccount())) && 
/*  948 */       (this.Operator.equals(other.getOperator())) && 
/*  949 */       (this.fDate.getString(this.MakeDate).equals(other.getMakeDate())) && 
/*  950 */       (this.MakeTime.equals(other.getMakeTime())) && 
/*  951 */       (this.fDate.getString(this.ModifyDate).equals(other.getModifyDate())) && 
/*  952 */       (this.ModifyTime.equals(other.getModifyTime())) && 
/*  953 */       (this.Varc1.equals(other.getVarc1())) && 
/*  954 */       (this.Varc2.equals(other.getVarc2())) && 
/*  955 */       (this.Varc3.equals(other.getVarc3())) && 
/*  956 */       (this.Varc4.equals(other.getVarc4())) && 
/*  957 */       (this.fDate.getString(this.DateTime1).equals(other.getDateTime1())) && 
/*  958 */       (this.fDate.getString(this.DateTime2).equals(other.getDateTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  964 */     return 20;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  970 */     if (strFieldName.equals("EdorNo")) {
/*  971 */       return 0;
/*      */     }
/*  973 */     if (strFieldName.equals("serialNo")) {
/*  974 */       return 1;
/*      */     }
/*  976 */     if (strFieldName.equals("ContNo")) {
/*  977 */       return 2;
/*      */     }
/*  979 */     if (strFieldName.equals("AppntID")) {
/*  980 */       return 3;
/*      */     }
/*  982 */     if (strFieldName.equals("InusredID")) {
/*  983 */       return 4;
/*      */     }
/*  985 */     if (strFieldName.equals("PayMent1")) {
/*  986 */       return 5;
/*      */     }
/*  988 */     if (strFieldName.equals("PayMent2")) {
/*  989 */       return 6;
/*      */     }
/*  991 */     if (strFieldName.equals("BankCode")) {
/*  992 */       return 7;
/*      */     }
/*  994 */     if (strFieldName.equals("Account")) {
/*  995 */       return 8;
/*      */     }
/*  997 */     if (strFieldName.equals("Operator")) {
/*  998 */       return 9;
/*      */     }
/* 1000 */     if (strFieldName.equals("MakeDate")) {
/* 1001 */       return 10;
/*      */     }
/* 1003 */     if (strFieldName.equals("MakeTime")) {
/* 1004 */       return 11;
/*      */     }
/* 1006 */     if (strFieldName.equals("ModifyDate")) {
/* 1007 */       return 12;
/*      */     }
/* 1009 */     if (strFieldName.equals("ModifyTime")) {
/* 1010 */       return 13;
/*      */     }
/* 1012 */     if (strFieldName.equals("Varc1")) {
/* 1013 */       return 14;
/*      */     }
/* 1015 */     if (strFieldName.equals("Varc2")) {
/* 1016 */       return 15;
/*      */     }
/* 1018 */     if (strFieldName.equals("Varc3")) {
/* 1019 */       return 16;
/*      */     }
/* 1021 */     if (strFieldName.equals("Varc4")) {
/* 1022 */       return 17;
/*      */     }
/* 1024 */     if (strFieldName.equals("DateTime1")) {
/* 1025 */       return 18;
/*      */     }
/* 1027 */     if (strFieldName.equals("DateTime2")) {
/* 1028 */       return 19;
/*      */     }
/* 1030 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1036 */     String strFieldName = "";
/* 1037 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1039 */       strFieldName = "EdorNo";
/* 1040 */       break;
/*      */     case 1:
/* 1042 */       strFieldName = "serialNo";
/* 1043 */       break;
/*      */     case 2:
/* 1045 */       strFieldName = "ContNo";
/* 1046 */       break;
/*      */     case 3:
/* 1048 */       strFieldName = "AppntID";
/* 1049 */       break;
/*      */     case 4:
/* 1051 */       strFieldName = "InusredID";
/* 1052 */       break;
/*      */     case 5:
/* 1054 */       strFieldName = "PayMent1";
/* 1055 */       break;
/*      */     case 6:
/* 1057 */       strFieldName = "PayMent2";
/* 1058 */       break;
/*      */     case 7:
/* 1060 */       strFieldName = "BankCode";
/* 1061 */       break;
/*      */     case 8:
/* 1063 */       strFieldName = "Account";
/* 1064 */       break;
/*      */     case 9:
/* 1066 */       strFieldName = "Operator";
/* 1067 */       break;
/*      */     case 10:
/* 1069 */       strFieldName = "MakeDate";
/* 1070 */       break;
/*      */     case 11:
/* 1072 */       strFieldName = "MakeTime";
/* 1073 */       break;
/*      */     case 12:
/* 1075 */       strFieldName = "ModifyDate";
/* 1076 */       break;
/*      */     case 13:
/* 1078 */       strFieldName = "ModifyTime";
/* 1079 */       break;
/*      */     case 14:
/* 1081 */       strFieldName = "Varc1";
/* 1082 */       break;
/*      */     case 15:
/* 1084 */       strFieldName = "Varc2";
/* 1085 */       break;
/*      */     case 16:
/* 1087 */       strFieldName = "Varc3";
/* 1088 */       break;
/*      */     case 17:
/* 1090 */       strFieldName = "Varc4";
/* 1091 */       break;
/*      */     case 18:
/* 1093 */       strFieldName = "DateTime1";
/* 1094 */       break;
/*      */     case 19:
/* 1096 */       strFieldName = "DateTime2";
/* 1097 */       break;
/*      */     default:
/* 1099 */       strFieldName = "";
/*      */     }
/* 1101 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1107 */     if (strFieldName.equals("EdorNo")) {
/* 1108 */       return 0;
/*      */     }
/* 1110 */     if (strFieldName.equals("serialNo")) {
/* 1111 */       return 0;
/*      */     }
/* 1113 */     if (strFieldName.equals("ContNo")) {
/* 1114 */       return 0;
/*      */     }
/* 1116 */     if (strFieldName.equals("AppntID")) {
/* 1117 */       return 0;
/*      */     }
/* 1119 */     if (strFieldName.equals("InusredID")) {
/* 1120 */       return 0;
/*      */     }
/* 1122 */     if (strFieldName.equals("PayMent1")) {
/* 1123 */       return 0;
/*      */     }
/* 1125 */     if (strFieldName.equals("PayMent2")) {
/* 1126 */       return 0;
/*      */     }
/* 1128 */     if (strFieldName.equals("BankCode")) {
/* 1129 */       return 0;
/*      */     }
/* 1131 */     if (strFieldName.equals("Account")) {
/* 1132 */       return 0;
/*      */     }
/* 1134 */     if (strFieldName.equals("Operator")) {
/* 1135 */       return 0;
/*      */     }
/* 1137 */     if (strFieldName.equals("MakeDate")) {
/* 1138 */       return 1;
/*      */     }
/* 1140 */     if (strFieldName.equals("MakeTime")) {
/* 1141 */       return 0;
/*      */     }
/* 1143 */     if (strFieldName.equals("ModifyDate")) {
/* 1144 */       return 1;
/*      */     }
/* 1146 */     if (strFieldName.equals("ModifyTime")) {
/* 1147 */       return 0;
/*      */     }
/* 1149 */     if (strFieldName.equals("Varc1")) {
/* 1150 */       return 0;
/*      */     }
/* 1152 */     if (strFieldName.equals("Varc2")) {
/* 1153 */       return 0;
/*      */     }
/* 1155 */     if (strFieldName.equals("Varc3")) {
/* 1156 */       return 0;
/*      */     }
/* 1158 */     if (strFieldName.equals("Varc4")) {
/* 1159 */       return 0;
/*      */     }
/* 1161 */     if (strFieldName.equals("DateTime1")) {
/* 1162 */       return 1;
/*      */     }
/* 1164 */     if (strFieldName.equals("DateTime2")) {
/* 1165 */       return 1;
/*      */     }
/* 1167 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1173 */     int nFieldType = -1;
/* 1174 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1176 */       nFieldType = 0;
/* 1177 */       break;
/*      */     case 1:
/* 1179 */       nFieldType = 0;
/* 1180 */       break;
/*      */     case 2:
/* 1182 */       nFieldType = 0;
/* 1183 */       break;
/*      */     case 3:
/* 1185 */       nFieldType = 0;
/* 1186 */       break;
/*      */     case 4:
/* 1188 */       nFieldType = 0;
/* 1189 */       break;
/*      */     case 5:
/* 1191 */       nFieldType = 0;
/* 1192 */       break;
/*      */     case 6:
/* 1194 */       nFieldType = 0;
/* 1195 */       break;
/*      */     case 7:
/* 1197 */       nFieldType = 0;
/* 1198 */       break;
/*      */     case 8:
/* 1200 */       nFieldType = 0;
/* 1201 */       break;
/*      */     case 9:
/* 1203 */       nFieldType = 0;
/* 1204 */       break;
/*      */     case 10:
/* 1206 */       nFieldType = 1;
/* 1207 */       break;
/*      */     case 11:
/* 1209 */       nFieldType = 0;
/* 1210 */       break;
/*      */     case 12:
/* 1212 */       nFieldType = 1;
/* 1213 */       break;
/*      */     case 13:
/* 1215 */       nFieldType = 0;
/* 1216 */       break;
/*      */     case 14:
/* 1218 */       nFieldType = 0;
/* 1219 */       break;
/*      */     case 15:
/* 1221 */       nFieldType = 0;
/* 1222 */       break;
/*      */     case 16:
/* 1224 */       nFieldType = 0;
/* 1225 */       break;
/*      */     case 17:
/* 1227 */       nFieldType = 0;
/* 1228 */       break;
/*      */     case 18:
/* 1230 */       nFieldType = 1;
/* 1231 */       break;
/*      */     case 19:
/* 1233 */       nFieldType = 1;
/* 1234 */       break;
/*      */     default:
/* 1236 */       nFieldType = -1;
/*      */     }
/* 1238 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPPaymentBSchema
 * JD-Core Version:    0.6.0
 */