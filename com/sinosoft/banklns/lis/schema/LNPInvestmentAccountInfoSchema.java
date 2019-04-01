/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestmentAccountInfoDB;
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
/*      */ public class LNPInvestmentAccountInfoSchema
/*      */   implements Schema
/*      */ {
/*      */   private String ContNo;
/*      */   private String RiskCode;
/*      */   private String InvestAccountCode;
/*      */   private double InvestAccountRate;
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
/*      */   public static final int FIELDNUM = 16;
/*      */   private static String[] PK;
/*   57 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPInvestmentAccountInfoSchema()
/*      */   {
/*   64 */     this.mErrors = new CErrors();
/*      */ 
/*   66 */     String[] pk = new String[3];
/*   67 */     pk[0] = "ContNo";
/*   68 */     pk[1] = "RiskCode";
/*   69 */     pk[2] = "InvestAccountCode";
/*      */ 
/*   71 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   77 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getContNo()
/*      */   {
/*   82 */     if (this.ContNo != null) this.ContNo.equals("");
/*      */ 
/*   86 */     return this.ContNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*   90 */     this.ContNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getRiskCode() {
/*   94 */     if (this.RiskCode != null) this.RiskCode.equals("");
/*      */ 
/*   98 */     return this.RiskCode;
/*      */   }
/*      */ 
/*      */   public void setRiskCode(String aRiskCode) {
/*  102 */     this.RiskCode = aRiskCode;
/*      */   }
/*      */ 
/*      */   public String getInvestAccountCode() {
/*  106 */     if (this.InvestAccountCode != null) this.InvestAccountCode.equals("");
/*      */ 
/*  110 */     return this.InvestAccountCode;
/*      */   }
/*      */ 
/*      */   public void setInvestAccountCode(String aInvestAccountCode) {
/*  114 */     this.InvestAccountCode = aInvestAccountCode;
/*      */   }
/*      */ 
/*      */   public double getInvestAccountRate() {
/*  118 */     return this.InvestAccountRate;
/*      */   }
/*      */ 
/*      */   public void setInvestAccountRate(double aInvestAccountRate) {
/*  122 */     this.InvestAccountRate = aInvestAccountRate;
/*      */   }
/*      */ 
/*      */   public void setInvestAccountRate(String aInvestAccountRate) {
/*  126 */     if ((aInvestAccountRate != null) && (!aInvestAccountRate.equals("")))
/*      */     {
/*  128 */       Double tDouble = new Double(aInvestAccountRate);
/*  129 */       double d = tDouble.doubleValue();
/*  130 */       this.InvestAccountRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  136 */     if (this.Operator != null) this.Operator.equals("");
/*      */ 
/*  140 */     return this.Operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  144 */     this.Operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  148 */     if (this.MakeDate != null) this.MakeDate.equals("");
/*      */ 
/*  152 */     return this.MakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  156 */     this.MakeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public String getMakeTime() {
/*  160 */     if (this.MakeTime != null) this.MakeTime.equals("");
/*      */ 
/*  164 */     return this.MakeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  168 */     this.MakeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  172 */     if (this.ModifyDate != null) this.ModifyDate.equals("");
/*      */ 
/*  176 */     return this.ModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  180 */     this.ModifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public String getModifyTime() {
/*  184 */     if (this.ModifyTime != null) this.ModifyTime.equals("");
/*      */ 
/*  188 */     return this.ModifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  192 */     this.ModifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getRemark() {
/*  196 */     if (this.Remark != null) this.Remark.equals("");
/*      */ 
/*  200 */     return this.Remark;
/*      */   }
/*      */ 
/*      */   public void setRemark(String aRemark) {
/*  204 */     this.Remark = aRemark;
/*      */   }
/*      */ 
/*      */   public String getVarc1() {
/*  208 */     if (this.Varc1 != null) this.Varc1.equals("");
/*      */ 
/*  212 */     return this.Varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  216 */     this.Varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  220 */     if (this.Varc2 != null) this.Varc2.equals("");
/*      */ 
/*  224 */     return this.Varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  228 */     this.Varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getVarc3() {
/*  232 */     if (this.Varc3 != null) this.Varc3.equals("");
/*      */ 
/*  236 */     return this.Varc3;
/*      */   }
/*      */ 
/*      */   public void setVarc3(String aVarc3) {
/*  240 */     this.Varc3 = aVarc3;
/*      */   }
/*      */ 
/*      */   public String getVarc4() {
/*  244 */     if (this.Varc4 != null) this.Varc4.equals("");
/*      */ 
/*  248 */     return this.Varc4;
/*      */   }
/*      */ 
/*      */   public void setVarc4(String aVarc4) {
/*  252 */     this.Varc4 = aVarc4;
/*      */   }
/*      */ 
/*      */   public String getDateTime1() {
/*  256 */     if (this.DateTime1 != null) {
/*  257 */       return this.fDate.getString(this.DateTime1);
/*      */     }
/*  259 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(Date aDateTime1) {
/*  263 */     this.DateTime1 = aDateTime1;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(String aDateTime1) {
/*  267 */     if ((aDateTime1 != null) && (!aDateTime1.equals("")))
/*      */     {
/*  269 */       this.DateTime1 = this.fDate.getDate(aDateTime1);
/*      */     }
/*      */     else
/*  272 */       this.DateTime1 = null;
/*      */   }
/*      */ 
/*      */   public String getDateTime2()
/*      */   {
/*  277 */     if (this.DateTime2 != null) {
/*  278 */       return this.fDate.getString(this.DateTime2);
/*      */     }
/*  280 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(Date aDateTime2) {
/*  284 */     this.DateTime2 = aDateTime2;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(String aDateTime2) {
/*  288 */     if ((aDateTime2 != null) && (!aDateTime2.equals("")))
/*      */     {
/*  290 */       this.DateTime2 = this.fDate.getDate(aDateTime2);
/*      */     }
/*      */     else
/*  293 */       this.DateTime2 = null;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPInvestmentAccountInfoSchema aLNPInvestmentAccountInfoSchema)
/*      */   {
/*  300 */     this.ContNo = aLNPInvestmentAccountInfoSchema.getContNo();
/*  301 */     this.RiskCode = aLNPInvestmentAccountInfoSchema.getRiskCode();
/*  302 */     this.InvestAccountCode = aLNPInvestmentAccountInfoSchema.getInvestAccountCode();
/*  303 */     this.InvestAccountRate = aLNPInvestmentAccountInfoSchema.getInvestAccountRate();
/*  304 */     this.Operator = aLNPInvestmentAccountInfoSchema.getOperator();
/*  305 */     this.MakeDate = aLNPInvestmentAccountInfoSchema.getMakeDate();
/*  306 */     this.MakeTime = aLNPInvestmentAccountInfoSchema.getMakeTime();
/*  307 */     this.ModifyDate = aLNPInvestmentAccountInfoSchema.getModifyDate();
/*  308 */     this.ModifyTime = aLNPInvestmentAccountInfoSchema.getModifyTime();
/*  309 */     this.Remark = aLNPInvestmentAccountInfoSchema.getRemark();
/*  310 */     this.Varc1 = aLNPInvestmentAccountInfoSchema.getVarc1();
/*  311 */     this.Varc2 = aLNPInvestmentAccountInfoSchema.getVarc2();
/*  312 */     this.Varc3 = aLNPInvestmentAccountInfoSchema.getVarc3();
/*  313 */     this.Varc4 = aLNPInvestmentAccountInfoSchema.getVarc4();
/*  314 */     this.DateTime1 = this.fDate.getDate(aLNPInvestmentAccountInfoSchema.getDateTime1());
/*  315 */     this.DateTime2 = this.fDate.getDate(aLNPInvestmentAccountInfoSchema.getDateTime2());
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  324 */       if (rs.getString("ContNo") == null)
/*  325 */         this.ContNo = null;
/*      */       else {
/*  327 */         this.ContNo = rs.getString("ContNo").trim();
/*      */       }
/*  329 */       if (rs.getString("RiskCode") == null)
/*  330 */         this.RiskCode = null;
/*      */       else {
/*  332 */         this.RiskCode = rs.getString("RiskCode").trim();
/*      */       }
/*  334 */       if (rs.getString("InvestAccountCode") == null)
/*  335 */         this.InvestAccountCode = null;
/*      */       else {
/*  337 */         this.InvestAccountCode = rs.getString("InvestAccountCode").trim();
/*      */       }
/*  339 */       this.InvestAccountRate = rs.getDouble("InvestAccountRate");
/*  340 */       if (rs.getString("Operator") == null)
/*  341 */         this.Operator = null;
/*      */       else {
/*  343 */         this.Operator = rs.getString("Operator").trim();
/*      */       }
/*  345 */       if (rs.getString("MakeDate") == null)
/*  346 */         this.MakeDate = null;
/*      */       else {
/*  348 */         this.MakeDate = rs.getString("MakeDate").trim();
/*      */       }
/*  350 */       if (rs.getString("MakeTime") == null)
/*  351 */         this.MakeTime = null;
/*      */       else {
/*  353 */         this.MakeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  355 */       if (rs.getString("ModifyDate") == null)
/*  356 */         this.ModifyDate = null;
/*      */       else {
/*  358 */         this.ModifyDate = rs.getString("ModifyDate").trim();
/*      */       }
/*  360 */       if (rs.getString("ModifyTime") == null)
/*  361 */         this.ModifyTime = null;
/*      */       else {
/*  363 */         this.ModifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  365 */       if (rs.getString("Remark") == null)
/*  366 */         this.Remark = null;
/*      */       else {
/*  368 */         this.Remark = rs.getString("Remark").trim();
/*      */       }
/*  370 */       if (rs.getString("Varc1") == null)
/*  371 */         this.Varc1 = null;
/*      */       else {
/*  373 */         this.Varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  375 */       if (rs.getString("Varc2") == null)
/*  376 */         this.Varc2 = null;
/*      */       else {
/*  378 */         this.Varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  380 */       if (rs.getString("Varc3") == null)
/*  381 */         this.Varc3 = null;
/*      */       else {
/*  383 */         this.Varc3 = rs.getString("Varc3").trim();
/*      */       }
/*  385 */       if (rs.getString("Varc4") == null)
/*  386 */         this.Varc4 = null;
/*      */       else {
/*  388 */         this.Varc4 = rs.getString("Varc4").trim();
/*      */       }
/*  390 */       this.DateTime1 = rs.getDate("DateTime1");
/*  391 */       this.DateTime2 = rs.getDate("DateTime2");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  396 */       CError tError = new CError();
/*  397 */       tError.moduleName = "LNPInvestmentAccountInfoSchema";
/*  398 */       tError.functionName = "setSchema";
/*  399 */       tError.errorMessage = sqle.toString();
/*  400 */       this.mErrors.addOneError(tError);
/*      */ 
/*  402 */       return false;
/*      */     }
/*  404 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInvestmentAccountInfoSchema getSchema()
/*      */   {
/*  409 */     LNPInvestmentAccountInfoSchema aLNPInvestmentAccountInfoSchema = new LNPInvestmentAccountInfoSchema();
/*  410 */     aLNPInvestmentAccountInfoSchema.setSchema(this);
/*  411 */     return aLNPInvestmentAccountInfoSchema;
/*      */   }
/*      */ 
/*      */   public LNPInvestmentAccountInfoDB getDB()
/*      */   {
/*  416 */     LNPInvestmentAccountInfoDB aDBOper = new LNPInvestmentAccountInfoDB();
/*  417 */     aDBOper.setSchema(this);
/*  418 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  425 */     String strReturn = "";
/*  426 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.ContNo)) + "|" + 
/*  427 */       StrTool.cTrim(StrTool.unicodeToGBK(this.RiskCode)) + "|" + 
/*  428 */       StrTool.cTrim(StrTool.unicodeToGBK(this.InvestAccountCode)) + "|" + 
/*  429 */       ChgData.chgData(this.InvestAccountRate) + "|" + 
/*  430 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Operator)) + "|" + 
/*  431 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeDate)) + "|" + 
/*  432 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeTime)) + "|" + 
/*  433 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyDate)) + "|" + 
/*  434 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyTime)) + "|" + 
/*  435 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Remark)) + "|" + 
/*  436 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc1)) + "|" + 
/*  437 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc2)) + "|" + 
/*  438 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc3)) + "|" + 
/*  439 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc4)) + "|" + 
/*  440 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime1))) + "|" + 
/*  441 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime2)));
/*  442 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  450 */       this.ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  451 */       this.RiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  452 */       this.InvestAccountCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  453 */       this.InvestAccountRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|"))).doubleValue();
/*  454 */       this.Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  455 */       this.MakeDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  456 */       this.MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  457 */       this.ModifyDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  458 */       this.ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  459 */       this.Remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  460 */       this.Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  461 */       this.Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  462 */       this.Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  463 */       this.Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  464 */       this.DateTime1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  465 */       this.DateTime2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  470 */       CError tError = new CError();
/*  471 */       tError.moduleName = "LNPInvestmentAccountInfoSchema";
/*  472 */       tError.functionName = "decode";
/*  473 */       tError.errorMessage = ex.toString();
/*  474 */       this.mErrors.addOneError(tError);
/*      */ 
/*  476 */       return false;
/*      */     }
/*  478 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  484 */     String strReturn = "";
/*  485 */     if (FCode.equals("ContNo"))
/*      */     {
/*  487 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ContNo));
/*      */     }
/*  489 */     if (FCode.equals("RiskCode"))
/*      */     {
/*  491 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.RiskCode));
/*      */     }
/*  493 */     if (FCode.equals("InvestAccountCode"))
/*      */     {
/*  495 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.InvestAccountCode));
/*      */     }
/*  497 */     if (FCode.equals("InvestAccountRate"))
/*      */     {
/*  499 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.InvestAccountRate));
/*      */     }
/*  501 */     if (FCode.equals("Operator"))
/*      */     {
/*  503 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Operator));
/*      */     }
/*  505 */     if (FCode.equals("MakeDate"))
/*      */     {
/*  507 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeDate));
/*      */     }
/*  509 */     if (FCode.equals("MakeTime"))
/*      */     {
/*  511 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeTime));
/*      */     }
/*  513 */     if (FCode.equals("ModifyDate"))
/*      */     {
/*  515 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyDate));
/*      */     }
/*  517 */     if (FCode.equals("ModifyTime"))
/*      */     {
/*  519 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyTime));
/*      */     }
/*  521 */     if (FCode.equals("Remark"))
/*      */     {
/*  523 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Remark));
/*      */     }
/*  525 */     if (FCode.equals("Varc1"))
/*      */     {
/*  527 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc1));
/*      */     }
/*  529 */     if (FCode.equals("Varc2"))
/*      */     {
/*  531 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc2));
/*      */     }
/*  533 */     if (FCode.equals("Varc3"))
/*      */     {
/*  535 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc3));
/*      */     }
/*  537 */     if (FCode.equals("Varc4"))
/*      */     {
/*  539 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc4));
/*      */     }
/*  541 */     if (FCode.equals("DateTime1"))
/*      */     {
/*  543 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*      */     }
/*  545 */     if (FCode.equals("DateTime2"))
/*      */     {
/*  547 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*      */     }
/*  549 */     if (strReturn.equals(""))
/*      */     {
/*  551 */       strReturn = "null";
/*      */     }
/*      */ 
/*  554 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  561 */     String strFieldValue = "";
/*  562 */     switch (nFieldIndex) {
/*      */     case 0:
/*  564 */       strFieldValue = StrTool.GBKToUnicode(this.ContNo);
/*  565 */       break;
/*      */     case 1:
/*  567 */       strFieldValue = StrTool.GBKToUnicode(this.RiskCode);
/*  568 */       break;
/*      */     case 2:
/*  570 */       strFieldValue = StrTool.GBKToUnicode(this.InvestAccountCode);
/*  571 */       break;
/*      */     case 3:
/*  573 */       strFieldValue = String.valueOf(this.InvestAccountRate);
/*  574 */       break;
/*      */     case 4:
/*  576 */       strFieldValue = StrTool.GBKToUnicode(this.Operator);
/*  577 */       break;
/*      */     case 5:
/*  579 */       strFieldValue = StrTool.GBKToUnicode(this.MakeDate);
/*  580 */       break;
/*      */     case 6:
/*  582 */       strFieldValue = StrTool.GBKToUnicode(this.MakeTime);
/*  583 */       break;
/*      */     case 7:
/*  585 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyDate);
/*  586 */       break;
/*      */     case 8:
/*  588 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyTime);
/*  589 */       break;
/*      */     case 9:
/*  591 */       strFieldValue = StrTool.GBKToUnicode(this.Remark);
/*  592 */       break;
/*      */     case 10:
/*  594 */       strFieldValue = StrTool.GBKToUnicode(this.Varc1);
/*  595 */       break;
/*      */     case 11:
/*  597 */       strFieldValue = StrTool.GBKToUnicode(this.Varc2);
/*  598 */       break;
/*      */     case 12:
/*  600 */       strFieldValue = StrTool.GBKToUnicode(this.Varc3);
/*  601 */       break;
/*      */     case 13:
/*  603 */       strFieldValue = StrTool.GBKToUnicode(this.Varc4);
/*  604 */       break;
/*      */     case 14:
/*  606 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*  607 */       break;
/*      */     case 15:
/*  609 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*  610 */       break;
/*      */     default:
/*  612 */       strFieldValue = "";
/*      */     }
/*  614 */     if (strFieldValue.equals("")) {
/*  615 */       strFieldValue = "null";
/*      */     }
/*  617 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  623 */     if (StrTool.cTrim(FCode).equals("")) {
/*  624 */       return false;
/*      */     }
/*  626 */     if (FCode.equals("ContNo"))
/*      */     {
/*  628 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  630 */         this.ContNo = FValue.trim();
/*      */       }
/*      */       else
/*  633 */         this.ContNo = null;
/*      */     }
/*  635 */     if (FCode.equals("RiskCode"))
/*      */     {
/*  637 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  639 */         this.RiskCode = FValue.trim();
/*      */       }
/*      */       else
/*  642 */         this.RiskCode = null;
/*      */     }
/*  644 */     if (FCode.equals("InvestAccountCode"))
/*      */     {
/*  646 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  648 */         this.InvestAccountCode = FValue.trim();
/*      */       }
/*      */       else
/*  651 */         this.InvestAccountCode = null;
/*      */     }
/*  653 */     if (FCode.equals("InvestAccountRate"))
/*      */     {
/*  655 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  657 */         Double tDouble = new Double(FValue);
/*  658 */         double d = tDouble.doubleValue();
/*  659 */         this.InvestAccountRate = d;
/*      */       }
/*      */     }
/*  662 */     if (FCode.equals("Operator"))
/*      */     {
/*  664 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  666 */         this.Operator = FValue.trim();
/*      */       }
/*      */       else
/*  669 */         this.Operator = null;
/*      */     }
/*  671 */     if (FCode.equals("MakeDate"))
/*      */     {
/*  673 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  675 */         this.MakeDate = FValue.trim();
/*      */       }
/*      */       else
/*  678 */         this.MakeDate = null;
/*      */     }
/*  680 */     if (FCode.equals("MakeTime"))
/*      */     {
/*  682 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  684 */         this.MakeTime = FValue.trim();
/*      */       }
/*      */       else
/*  687 */         this.MakeTime = null;
/*      */     }
/*  689 */     if (FCode.equals("ModifyDate"))
/*      */     {
/*  691 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  693 */         this.ModifyDate = FValue.trim();
/*      */       }
/*      */       else
/*  696 */         this.ModifyDate = null;
/*      */     }
/*  698 */     if (FCode.equals("ModifyTime"))
/*      */     {
/*  700 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  702 */         this.ModifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  705 */         this.ModifyTime = null;
/*      */     }
/*  707 */     if (FCode.equals("Remark"))
/*      */     {
/*  709 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  711 */         this.Remark = FValue.trim();
/*      */       }
/*      */       else
/*  714 */         this.Remark = null;
/*      */     }
/*  716 */     if (FCode.equals("Varc1"))
/*      */     {
/*  718 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  720 */         this.Varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  723 */         this.Varc1 = null;
/*      */     }
/*  725 */     if (FCode.equals("Varc2"))
/*      */     {
/*  727 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  729 */         this.Varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  732 */         this.Varc2 = null;
/*      */     }
/*  734 */     if (FCode.equals("Varc3"))
/*      */     {
/*  736 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  738 */         this.Varc3 = FValue.trim();
/*      */       }
/*      */       else
/*  741 */         this.Varc3 = null;
/*      */     }
/*  743 */     if (FCode.equals("Varc4"))
/*      */     {
/*  745 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  747 */         this.Varc4 = FValue.trim();
/*      */       }
/*      */       else
/*  750 */         this.Varc4 = null;
/*      */     }
/*  752 */     if (FCode.equals("DateTime1"))
/*      */     {
/*  754 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  756 */         this.DateTime1 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  759 */         this.DateTime1 = null;
/*      */     }
/*  761 */     if (FCode.equals("DateTime2"))
/*      */     {
/*  763 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  765 */         this.DateTime2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  768 */         this.DateTime2 = null;
/*      */     }
/*  770 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  775 */     if (this == otherObject) return true;
/*  776 */     if (otherObject == null) return false;
/*  777 */     if (getClass() != otherObject.getClass()) return false;
/*  778 */     LNPInvestmentAccountInfoSchema other = (LNPInvestmentAccountInfoSchema)otherObject;
/*  779 */     return 
/*  780 */       (this.ContNo.equals(other.getContNo())) && 
/*  781 */       (this.RiskCode.equals(other.getRiskCode())) && 
/*  782 */       (this.InvestAccountCode.equals(other.getInvestAccountCode())) && 
/*  783 */       (this.InvestAccountRate == other.getInvestAccountRate()) && 
/*  784 */       (this.Operator.equals(other.getOperator())) && 
/*  785 */       (this.MakeDate.equals(other.getMakeDate())) && 
/*  786 */       (this.MakeTime.equals(other.getMakeTime())) && 
/*  787 */       (this.ModifyDate.equals(other.getModifyDate())) && 
/*  788 */       (this.ModifyTime.equals(other.getModifyTime())) && 
/*  789 */       (this.Remark.equals(other.getRemark())) && 
/*  790 */       (this.Varc1.equals(other.getVarc1())) && 
/*  791 */       (this.Varc2.equals(other.getVarc2())) && 
/*  792 */       (this.Varc3.equals(other.getVarc3())) && 
/*  793 */       (this.Varc4.equals(other.getVarc4())) && 
/*  794 */       (this.fDate.getString(this.DateTime1).equals(other.getDateTime1())) && 
/*  795 */       (this.fDate.getString(this.DateTime2).equals(other.getDateTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  801 */     return 16;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  807 */     if (strFieldName.equals("ContNo")) {
/*  808 */       return 0;
/*      */     }
/*  810 */     if (strFieldName.equals("RiskCode")) {
/*  811 */       return 1;
/*      */     }
/*  813 */     if (strFieldName.equals("InvestAccountCode")) {
/*  814 */       return 2;
/*      */     }
/*  816 */     if (strFieldName.equals("InvestAccountRate")) {
/*  817 */       return 3;
/*      */     }
/*  819 */     if (strFieldName.equals("Operator")) {
/*  820 */       return 4;
/*      */     }
/*  822 */     if (strFieldName.equals("MakeDate")) {
/*  823 */       return 5;
/*      */     }
/*  825 */     if (strFieldName.equals("MakeTime")) {
/*  826 */       return 6;
/*      */     }
/*  828 */     if (strFieldName.equals("ModifyDate")) {
/*  829 */       return 7;
/*      */     }
/*  831 */     if (strFieldName.equals("ModifyTime")) {
/*  832 */       return 8;
/*      */     }
/*  834 */     if (strFieldName.equals("Remark")) {
/*  835 */       return 9;
/*      */     }
/*  837 */     if (strFieldName.equals("Varc1")) {
/*  838 */       return 10;
/*      */     }
/*  840 */     if (strFieldName.equals("Varc2")) {
/*  841 */       return 11;
/*      */     }
/*  843 */     if (strFieldName.equals("Varc3")) {
/*  844 */       return 12;
/*      */     }
/*  846 */     if (strFieldName.equals("Varc4")) {
/*  847 */       return 13;
/*      */     }
/*  849 */     if (strFieldName.equals("DateTime1")) {
/*  850 */       return 14;
/*      */     }
/*  852 */     if (strFieldName.equals("DateTime2")) {
/*  853 */       return 15;
/*      */     }
/*  855 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  861 */     String strFieldName = "";
/*  862 */     switch (nFieldIndex) {
/*      */     case 0:
/*  864 */       strFieldName = "ContNo";
/*  865 */       break;
/*      */     case 1:
/*  867 */       strFieldName = "RiskCode";
/*  868 */       break;
/*      */     case 2:
/*  870 */       strFieldName = "InvestAccountCode";
/*  871 */       break;
/*      */     case 3:
/*  873 */       strFieldName = "InvestAccountRate";
/*  874 */       break;
/*      */     case 4:
/*  876 */       strFieldName = "Operator";
/*  877 */       break;
/*      */     case 5:
/*  879 */       strFieldName = "MakeDate";
/*  880 */       break;
/*      */     case 6:
/*  882 */       strFieldName = "MakeTime";
/*  883 */       break;
/*      */     case 7:
/*  885 */       strFieldName = "ModifyDate";
/*  886 */       break;
/*      */     case 8:
/*  888 */       strFieldName = "ModifyTime";
/*  889 */       break;
/*      */     case 9:
/*  891 */       strFieldName = "Remark";
/*  892 */       break;
/*      */     case 10:
/*  894 */       strFieldName = "Varc1";
/*  895 */       break;
/*      */     case 11:
/*  897 */       strFieldName = "Varc2";
/*  898 */       break;
/*      */     case 12:
/*  900 */       strFieldName = "Varc3";
/*  901 */       break;
/*      */     case 13:
/*  903 */       strFieldName = "Varc4";
/*  904 */       break;
/*      */     case 14:
/*  906 */       strFieldName = "DateTime1";
/*  907 */       break;
/*      */     case 15:
/*  909 */       strFieldName = "DateTime2";
/*  910 */       break;
/*      */     default:
/*  912 */       strFieldName = "";
/*      */     }
/*  914 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  920 */     if (strFieldName.equals("ContNo")) {
/*  921 */       return 0;
/*      */     }
/*  923 */     if (strFieldName.equals("RiskCode")) {
/*  924 */       return 0;
/*      */     }
/*  926 */     if (strFieldName.equals("InvestAccountCode")) {
/*  927 */       return 0;
/*      */     }
/*  929 */     if (strFieldName.equals("InvestAccountRate")) {
/*  930 */       return 4;
/*      */     }
/*  932 */     if (strFieldName.equals("Operator")) {
/*  933 */       return 0;
/*      */     }
/*  935 */     if (strFieldName.equals("MakeDate")) {
/*  936 */       return 0;
/*      */     }
/*  938 */     if (strFieldName.equals("MakeTime")) {
/*  939 */       return 0;
/*      */     }
/*  941 */     if (strFieldName.equals("ModifyDate")) {
/*  942 */       return 0;
/*      */     }
/*  944 */     if (strFieldName.equals("ModifyTime")) {
/*  945 */       return 0;
/*      */     }
/*  947 */     if (strFieldName.equals("Remark")) {
/*  948 */       return 0;
/*      */     }
/*  950 */     if (strFieldName.equals("Varc1")) {
/*  951 */       return 0;
/*      */     }
/*  953 */     if (strFieldName.equals("Varc2")) {
/*  954 */       return 0;
/*      */     }
/*  956 */     if (strFieldName.equals("Varc3")) {
/*  957 */       return 0;
/*      */     }
/*  959 */     if (strFieldName.equals("Varc4")) {
/*  960 */       return 0;
/*      */     }
/*  962 */     if (strFieldName.equals("DateTime1")) {
/*  963 */       return 1;
/*      */     }
/*  965 */     if (strFieldName.equals("DateTime2")) {
/*  966 */       return 1;
/*      */     }
/*  968 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/*  974 */     int nFieldType = -1;
/*  975 */     switch (nFieldIndex) {
/*      */     case 0:
/*  977 */       nFieldType = 0;
/*  978 */       break;
/*      */     case 1:
/*  980 */       nFieldType = 0;
/*  981 */       break;
/*      */     case 2:
/*  983 */       nFieldType = 0;
/*  984 */       break;
/*      */     case 3:
/*  986 */       nFieldType = 4;
/*  987 */       break;
/*      */     case 4:
/*  989 */       nFieldType = 0;
/*  990 */       break;
/*      */     case 5:
/*  992 */       nFieldType = 0;
/*  993 */       break;
/*      */     case 6:
/*  995 */       nFieldType = 0;
/*  996 */       break;
/*      */     case 7:
/*  998 */       nFieldType = 0;
/*  999 */       break;
/*      */     case 8:
/* 1001 */       nFieldType = 0;
/* 1002 */       break;
/*      */     case 9:
/* 1004 */       nFieldType = 0;
/* 1005 */       break;
/*      */     case 10:
/* 1007 */       nFieldType = 0;
/* 1008 */       break;
/*      */     case 11:
/* 1010 */       nFieldType = 0;
/* 1011 */       break;
/*      */     case 12:
/* 1013 */       nFieldType = 0;
/* 1014 */       break;
/*      */     case 13:
/* 1016 */       nFieldType = 0;
/* 1017 */       break;
/*      */     case 14:
/* 1019 */       nFieldType = 1;
/* 1020 */       break;
/*      */     case 15:
/* 1022 */       nFieldType = 1;
/* 1023 */       break;
/*      */     default:
/* 1025 */       nFieldType = -1;
/*      */     }
/* 1027 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPInvestmentAccountInfoSchema
 * JD-Core Version:    0.6.0
 */