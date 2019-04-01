/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPDutyDB;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class LNPDutySchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String dutyCode;
/*      */   private String dutyName;
/*      */   private int payEndYear;
/*      */   private String payEndYearFlag;
/*      */   private String payEndDateCalRef;
/*      */   private String payEndDateCalMode;
/*      */   private int getYear;
/*      */   private String getYearFlag;
/*      */   private int insuYear;
/*      */   private String insuYearFlag;
/*      */   private int acciYear;
/*      */   private String acciYearFlag;
/*      */   private String calMode;
/*      */   private String payEndYearRela;
/*      */   private String getYearRela;
/*      */   private String insuYearRela;
/*      */   private String basicCalCode;
/*      */   private String riskCalCode;
/*      */   private String amntFlag;
/*      */   private double vPU;
/*      */   private String addFeeFlag;
/*      */   private String endDateCalMode;
/*      */   public static final int FIELDNUM = 22;
/*      */   private static String[] PK;
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPDutySchema()
/*      */   {
/*   76 */     this.mErrors = new CErrors();
/*      */ 
/*   78 */     String[] pk = new String[1];
/*   79 */     pk[0] = "DutyCode";
/*      */ 
/*   81 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   88 */     LNPDutySchema cloned = (LNPDutySchema)super.clone();
/*   89 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   90 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   96 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getDutyCode()
/*      */   {
/*  101 */     return this.dutyCode;
/*      */   }
/*      */ 
/*      */   public void setDutyCode(String aDutyCode) {
/*  105 */     this.dutyCode = aDutyCode;
/*      */   }
/*      */ 
/*      */   public String getDutyName() {
/*  109 */     return this.dutyName;
/*      */   }
/*      */ 
/*      */   public void setDutyName(String aDutyName) {
/*  113 */     this.dutyName = aDutyName;
/*      */   }
/*      */ 
/*      */   public int getPayEndYear() {
/*  117 */     return this.payEndYear;
/*      */   }
/*      */ 
/*      */   public void setPayEndYear(int aPayEndYear) {
/*  121 */     this.payEndYear = aPayEndYear;
/*      */   }
/*      */ 
/*      */   public void setPayEndYear(String aPayEndYear) {
/*  125 */     if ((aPayEndYear != null) && (!aPayEndYear.equals("")))
/*      */     {
/*  127 */       Integer tInteger = new Integer(aPayEndYear);
/*  128 */       int i = tInteger.intValue();
/*  129 */       this.payEndYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getPayEndYearFlag()
/*      */   {
/*  135 */     return this.payEndYearFlag;
/*      */   }
/*      */ 
/*      */   public void setPayEndYearFlag(String aPayEndYearFlag) {
/*  139 */     this.payEndYearFlag = aPayEndYearFlag;
/*      */   }
/*      */ 
/*      */   public String getPayEndDateCalRef() {
/*  143 */     return this.payEndDateCalRef;
/*      */   }
/*      */ 
/*      */   public void setPayEndDateCalRef(String aPayEndDateCalRef) {
/*  147 */     this.payEndDateCalRef = aPayEndDateCalRef;
/*      */   }
/*      */ 
/*      */   public String getPayEndDateCalMode() {
/*  151 */     return this.payEndDateCalMode;
/*      */   }
/*      */ 
/*      */   public void setPayEndDateCalMode(String aPayEndDateCalMode) {
/*  155 */     this.payEndDateCalMode = aPayEndDateCalMode;
/*      */   }
/*      */ 
/*      */   public int getGetYear() {
/*  159 */     return this.getYear;
/*      */   }
/*      */ 
/*      */   public void setGetYear(int aGetYear) {
/*  163 */     this.getYear = aGetYear;
/*      */   }
/*      */ 
/*      */   public void setGetYear(String aGetYear) {
/*  167 */     if ((aGetYear != null) && (!aGetYear.equals("")))
/*      */     {
/*  169 */       Integer tInteger = new Integer(aGetYear);
/*  170 */       int i = tInteger.intValue();
/*  171 */       this.getYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getGetYearFlag()
/*      */   {
/*  177 */     return this.getYearFlag;
/*      */   }
/*      */ 
/*      */   public void setGetYearFlag(String aGetYearFlag) {
/*  181 */     this.getYearFlag = aGetYearFlag;
/*      */   }
/*      */ 
/*      */   public int getInsuYear() {
/*  185 */     return this.insuYear;
/*      */   }
/*      */ 
/*      */   public void setInsuYear(int aInsuYear) {
/*  189 */     this.insuYear = aInsuYear;
/*      */   }
/*      */ 
/*      */   public void setInsuYear(String aInsuYear) {
/*  193 */     if ((aInsuYear != null) && (!aInsuYear.equals("")))
/*      */     {
/*  195 */       Integer tInteger = new Integer(aInsuYear);
/*  196 */       int i = tInteger.intValue();
/*  197 */       this.insuYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getInsuYearFlag()
/*      */   {
/*  203 */     return this.insuYearFlag;
/*      */   }
/*      */ 
/*      */   public void setInsuYearFlag(String aInsuYearFlag) {
/*  207 */     this.insuYearFlag = aInsuYearFlag;
/*      */   }
/*      */ 
/*      */   public int getAcciYear() {
/*  211 */     return this.acciYear;
/*      */   }
/*      */ 
/*      */   public void setAcciYear(int aAcciYear) {
/*  215 */     this.acciYear = aAcciYear;
/*      */   }
/*      */ 
/*      */   public void setAcciYear(String aAcciYear) {
/*  219 */     if ((aAcciYear != null) && (!aAcciYear.equals("")))
/*      */     {
/*  221 */       Integer tInteger = new Integer(aAcciYear);
/*  222 */       int i = tInteger.intValue();
/*  223 */       this.acciYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getAcciYearFlag()
/*      */   {
/*  229 */     return this.acciYearFlag;
/*      */   }
/*      */ 
/*      */   public void setAcciYearFlag(String aAcciYearFlag) {
/*  233 */     this.acciYearFlag = aAcciYearFlag;
/*      */   }
/*      */ 
/*      */   public String getCalMode() {
/*  237 */     return this.calMode;
/*      */   }
/*      */ 
/*      */   public void setCalMode(String aCalMode) {
/*  241 */     this.calMode = aCalMode;
/*      */   }
/*      */ 
/*      */   public String getPayEndYearRela() {
/*  245 */     return this.payEndYearRela;
/*      */   }
/*      */ 
/*      */   public void setPayEndYearRela(String aPayEndYearRela) {
/*  249 */     this.payEndYearRela = aPayEndYearRela;
/*      */   }
/*      */ 
/*      */   public String getGetYearRela() {
/*  253 */     return this.getYearRela;
/*      */   }
/*      */ 
/*      */   public void setGetYearRela(String aGetYearRela) {
/*  257 */     this.getYearRela = aGetYearRela;
/*      */   }
/*      */ 
/*      */   public String getInsuYearRela() {
/*  261 */     return this.insuYearRela;
/*      */   }
/*      */ 
/*      */   public void setInsuYearRela(String aInsuYearRela) {
/*  265 */     this.insuYearRela = aInsuYearRela;
/*      */   }
/*      */ 
/*      */   public String getBasicCalCode() {
/*  269 */     return this.basicCalCode;
/*      */   }
/*      */ 
/*      */   public void setBasicCalCode(String aBasicCalCode) {
/*  273 */     this.basicCalCode = aBasicCalCode;
/*      */   }
/*      */ 
/*      */   public String getRiskCalCode() {
/*  277 */     return this.riskCalCode;
/*      */   }
/*      */ 
/*      */   public void setRiskCalCode(String aRiskCalCode) {
/*  281 */     this.riskCalCode = aRiskCalCode;
/*      */   }
/*      */ 
/*      */   public String getAmntFlag() {
/*  285 */     return this.amntFlag;
/*      */   }
/*      */ 
/*      */   public void setAmntFlag(String aAmntFlag) {
/*  289 */     this.amntFlag = aAmntFlag;
/*      */   }
/*      */ 
/*      */   public double getVPU() {
/*  293 */     return this.vPU;
/*      */   }
/*      */ 
/*      */   public void setVPU(double aVPU) {
/*  297 */     this.vPU = aVPU;
/*      */   }
/*      */ 
/*      */   public void setVPU(String aVPU) {
/*  301 */     if ((aVPU != null) && (!aVPU.equals("")))
/*      */     {
/*  303 */       Double tDouble = new Double(aVPU);
/*  304 */       double d = tDouble.doubleValue();
/*  305 */       this.vPU = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getAddFeeFlag()
/*      */   {
/*  311 */     return this.addFeeFlag;
/*      */   }
/*      */ 
/*      */   public void setAddFeeFlag(String aAddFeeFlag) {
/*  315 */     this.addFeeFlag = aAddFeeFlag;
/*      */   }
/*      */ 
/*      */   public String getEndDateCalMode() {
/*  319 */     return this.endDateCalMode;
/*      */   }
/*      */ 
/*      */   public void setEndDateCalMode(String aEndDateCalMode) {
/*  323 */     this.endDateCalMode = aEndDateCalMode;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPDutySchema aLNPDutySchema)
/*      */   {
/*  329 */     this.dutyCode = aLNPDutySchema.getDutyCode();
/*  330 */     this.dutyName = aLNPDutySchema.getDutyName();
/*  331 */     this.payEndYear = aLNPDutySchema.getPayEndYear();
/*  332 */     this.payEndYearFlag = aLNPDutySchema.getPayEndYearFlag();
/*  333 */     this.payEndDateCalRef = aLNPDutySchema.getPayEndDateCalRef();
/*  334 */     this.payEndDateCalMode = aLNPDutySchema.getPayEndDateCalMode();
/*  335 */     this.getYear = aLNPDutySchema.getGetYear();
/*  336 */     this.getYearFlag = aLNPDutySchema.getGetYearFlag();
/*  337 */     this.insuYear = aLNPDutySchema.getInsuYear();
/*  338 */     this.insuYearFlag = aLNPDutySchema.getInsuYearFlag();
/*  339 */     this.acciYear = aLNPDutySchema.getAcciYear();
/*  340 */     this.acciYearFlag = aLNPDutySchema.getAcciYearFlag();
/*  341 */     this.calMode = aLNPDutySchema.getCalMode();
/*  342 */     this.payEndYearRela = aLNPDutySchema.getPayEndYearRela();
/*  343 */     this.getYearRela = aLNPDutySchema.getGetYearRela();
/*  344 */     this.insuYearRela = aLNPDutySchema.getInsuYearRela();
/*  345 */     this.basicCalCode = aLNPDutySchema.getBasicCalCode();
/*  346 */     this.riskCalCode = aLNPDutySchema.getRiskCalCode();
/*  347 */     this.amntFlag = aLNPDutySchema.getAmntFlag();
/*  348 */     this.vPU = aLNPDutySchema.getVPU();
/*  349 */     this.addFeeFlag = aLNPDutySchema.getAddFeeFlag();
/*  350 */     this.endDateCalMode = aLNPDutySchema.getEndDateCalMode();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  359 */       if (rs.getString("DutyCode") == null)
/*  360 */         this.dutyCode = null;
/*      */       else {
/*  362 */         this.dutyCode = rs.getString("DutyCode").trim();
/*      */       }
/*  364 */       if (rs.getString("DutyName") == null)
/*  365 */         this.dutyName = null;
/*      */       else {
/*  367 */         this.dutyName = rs.getString("DutyName").trim();
/*      */       }
/*  369 */       this.payEndYear = rs.getInt("PayEndYear");
/*  370 */       if (rs.getString("PayEndYearFlag") == null)
/*  371 */         this.payEndYearFlag = null;
/*      */       else {
/*  373 */         this.payEndYearFlag = rs.getString("PayEndYearFlag").trim();
/*      */       }
/*  375 */       if (rs.getString("PayEndDateCalRef") == null)
/*  376 */         this.payEndDateCalRef = null;
/*      */       else {
/*  378 */         this.payEndDateCalRef = rs.getString("PayEndDateCalRef").trim();
/*      */       }
/*  380 */       if (rs.getString("PayEndDateCalMode") == null)
/*  381 */         this.payEndDateCalMode = null;
/*      */       else {
/*  383 */         this.payEndDateCalMode = rs.getString("PayEndDateCalMode").trim();
/*      */       }
/*  385 */       this.getYear = rs.getInt("GetYear");
/*  386 */       if (rs.getString("GetYearFlag") == null)
/*  387 */         this.getYearFlag = null;
/*      */       else {
/*  389 */         this.getYearFlag = rs.getString("GetYearFlag").trim();
/*      */       }
/*  391 */       this.insuYear = rs.getInt("InsuYear");
/*  392 */       if (rs.getString("InsuYearFlag") == null)
/*  393 */         this.insuYearFlag = null;
/*      */       else {
/*  395 */         this.insuYearFlag = rs.getString("InsuYearFlag").trim();
/*      */       }
/*  397 */       this.acciYear = rs.getInt("AcciYear");
/*  398 */       if (rs.getString("AcciYearFlag") == null)
/*  399 */         this.acciYearFlag = null;
/*      */       else {
/*  401 */         this.acciYearFlag = rs.getString("AcciYearFlag").trim();
/*      */       }
/*  403 */       if (rs.getString("CalMode") == null)
/*  404 */         this.calMode = null;
/*      */       else {
/*  406 */         this.calMode = rs.getString("CalMode").trim();
/*      */       }
/*  408 */       if (rs.getString("PayEndYearRela") == null)
/*  409 */         this.payEndYearRela = null;
/*      */       else {
/*  411 */         this.payEndYearRela = rs.getString("PayEndYearRela").trim();
/*      */       }
/*  413 */       if (rs.getString("GetYearRela") == null)
/*  414 */         this.getYearRela = null;
/*      */       else {
/*  416 */         this.getYearRela = rs.getString("GetYearRela").trim();
/*      */       }
/*  418 */       if (rs.getString("InsuYearRela") == null)
/*  419 */         this.insuYearRela = null;
/*      */       else {
/*  421 */         this.insuYearRela = rs.getString("InsuYearRela").trim();
/*      */       }
/*  423 */       if (rs.getString("BasicCalCode") == null)
/*  424 */         this.basicCalCode = null;
/*      */       else {
/*  426 */         this.basicCalCode = rs.getString("BasicCalCode").trim();
/*      */       }
/*  428 */       if (rs.getString("RiskCalCode") == null)
/*  429 */         this.riskCalCode = null;
/*      */       else {
/*  431 */         this.riskCalCode = rs.getString("RiskCalCode").trim();
/*      */       }
/*  433 */       if (rs.getString("AmntFlag") == null)
/*  434 */         this.amntFlag = null;
/*      */       else {
/*  436 */         this.amntFlag = rs.getString("AmntFlag").trim();
/*      */       }
/*  438 */       this.vPU = rs.getDouble("VPU");
/*  439 */       if (rs.getString("AddFeeFlag") == null)
/*  440 */         this.addFeeFlag = null;
/*      */       else {
/*  442 */         this.addFeeFlag = rs.getString("AddFeeFlag").trim();
/*      */       }
/*  444 */       if (rs.getString("EndDateCalMode") == null)
/*  445 */         this.endDateCalMode = null;
/*      */       else {
/*  447 */         this.endDateCalMode = rs.getString("EndDateCalMode").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  452 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPDuty\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/*  454 */       CError tError = new CError();
/*  455 */       tError.moduleName = "LNPDutySchema";
/*  456 */       tError.functionName = "setSchema";
/*  457 */       tError.errorMessage = sqle.toString();
/*  458 */       this.mErrors.addOneError(tError);
/*  459 */       return false;
/*      */     }
/*  461 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPDutySchema getSchema()
/*      */   {
/*  466 */     LNPDutySchema aLNPDutySchema = new LNPDutySchema();
/*  467 */     aLNPDutySchema.setSchema(this);
/*  468 */     return aLNPDutySchema;
/*      */   }
/*      */ 
/*      */   public LNPDutyDB getDB()
/*      */   {
/*  473 */     LNPDutyDB aDBOper = new LNPDutyDB();
/*  474 */     aDBOper.setSchema(this);
/*  475 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  482 */     StringBuffer strReturn = new StringBuffer(256);
/*  483 */     strReturn.append(StrTool.cTrim(this.dutyCode)); strReturn.append("|");
/*  484 */     strReturn.append(StrTool.cTrim(this.dutyName)); strReturn.append("|");
/*  485 */     strReturn.append(ChgData.chgData(this.payEndYear)); strReturn.append("|");
/*  486 */     strReturn.append(StrTool.cTrim(this.payEndYearFlag)); strReturn.append("|");
/*  487 */     strReturn.append(StrTool.cTrim(this.payEndDateCalRef)); strReturn.append("|");
/*  488 */     strReturn.append(StrTool.cTrim(this.payEndDateCalMode)); strReturn.append("|");
/*  489 */     strReturn.append(ChgData.chgData(this.getYear)); strReturn.append("|");
/*  490 */     strReturn.append(StrTool.cTrim(this.getYearFlag)); strReturn.append("|");
/*  491 */     strReturn.append(ChgData.chgData(this.insuYear)); strReturn.append("|");
/*  492 */     strReturn.append(StrTool.cTrim(this.insuYearFlag)); strReturn.append("|");
/*  493 */     strReturn.append(ChgData.chgData(this.acciYear)); strReturn.append("|");
/*  494 */     strReturn.append(StrTool.cTrim(this.acciYearFlag)); strReturn.append("|");
/*  495 */     strReturn.append(StrTool.cTrim(this.calMode)); strReturn.append("|");
/*  496 */     strReturn.append(StrTool.cTrim(this.payEndYearRela)); strReturn.append("|");
/*  497 */     strReturn.append(StrTool.cTrim(this.getYearRela)); strReturn.append("|");
/*  498 */     strReturn.append(StrTool.cTrim(this.insuYearRela)); strReturn.append("|");
/*  499 */     strReturn.append(StrTool.cTrim(this.basicCalCode)); strReturn.append("|");
/*  500 */     strReturn.append(StrTool.cTrim(this.riskCalCode)); strReturn.append("|");
/*  501 */     strReturn.append(StrTool.cTrim(this.amntFlag)); strReturn.append("|");
/*  502 */     strReturn.append(ChgData.chgData(this.vPU)); strReturn.append("|");
/*  503 */     strReturn.append(StrTool.cTrim(this.addFeeFlag)); strReturn.append("|");
/*  504 */     strReturn.append(StrTool.cTrim(this.endDateCalMode));
/*  505 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  513 */       this.dutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  514 */       this.dutyName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  515 */       this.payEndYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 3, "|"))).intValue();
/*  516 */       this.payEndYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  517 */       this.payEndDateCalRef = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  518 */       this.payEndDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  519 */       this.getYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).intValue();
/*  520 */       this.getYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  521 */       this.insuYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).intValue();
/*  522 */       this.insuYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  523 */       this.acciYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).intValue();
/*  524 */       this.acciYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  525 */       this.calMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  526 */       this.payEndYearRela = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  527 */       this.getYearRela = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  528 */       this.insuYearRela = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  529 */       this.basicCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  530 */       this.riskCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  531 */       this.amntFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  532 */       this.vPU = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).doubleValue();
/*  533 */       this.addFeeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  534 */       this.endDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  539 */       CError tError = new CError();
/*  540 */       tError.moduleName = "LNPDutySchema";
/*  541 */       tError.functionName = "decode";
/*  542 */       tError.errorMessage = ex.toString();
/*  543 */       this.mErrors.addOneError(tError);
/*      */ 
/*  545 */       return false;
/*      */     }
/*  547 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  553 */     String strReturn = "";
/*  554 */     if (FCode.equalsIgnoreCase("dutyCode"))
/*      */     {
/*  556 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dutyCode));
/*      */     }
/*  558 */     if (FCode.equalsIgnoreCase("dutyName"))
/*      */     {
/*  560 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dutyName));
/*      */     }
/*  562 */     if (FCode.equalsIgnoreCase("payEndYear"))
/*      */     {
/*  564 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndYear));
/*      */     }
/*  566 */     if (FCode.equalsIgnoreCase("payEndYearFlag"))
/*      */     {
/*  568 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndYearFlag));
/*      */     }
/*  570 */     if (FCode.equalsIgnoreCase("payEndDateCalRef"))
/*      */     {
/*  572 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndDateCalRef));
/*      */     }
/*  574 */     if (FCode.equalsIgnoreCase("payEndDateCalMode"))
/*      */     {
/*  576 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndDateCalMode));
/*      */     }
/*  578 */     if (FCode.equalsIgnoreCase("getYear"))
/*      */     {
/*  580 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getYear));
/*      */     }
/*  582 */     if (FCode.equalsIgnoreCase("getYearFlag"))
/*      */     {
/*  584 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getYearFlag));
/*      */     }
/*  586 */     if (FCode.equalsIgnoreCase("insuYear"))
/*      */     {
/*  588 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuYear));
/*      */     }
/*  590 */     if (FCode.equalsIgnoreCase("insuYearFlag"))
/*      */     {
/*  592 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuYearFlag));
/*      */     }
/*  594 */     if (FCode.equalsIgnoreCase("acciYear"))
/*      */     {
/*  596 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.acciYear));
/*      */     }
/*  598 */     if (FCode.equalsIgnoreCase("acciYearFlag"))
/*      */     {
/*  600 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.acciYearFlag));
/*      */     }
/*  602 */     if (FCode.equalsIgnoreCase("calMode"))
/*      */     {
/*  604 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.calMode));
/*      */     }
/*  606 */     if (FCode.equalsIgnoreCase("payEndYearRela"))
/*      */     {
/*  608 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payEndYearRela));
/*      */     }
/*  610 */     if (FCode.equalsIgnoreCase("getYearRela"))
/*      */     {
/*  612 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getYearRela));
/*      */     }
/*  614 */     if (FCode.equalsIgnoreCase("insuYearRela"))
/*      */     {
/*  616 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuYearRela));
/*      */     }
/*  618 */     if (FCode.equalsIgnoreCase("basicCalCode"))
/*      */     {
/*  620 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.basicCalCode));
/*      */     }
/*  622 */     if (FCode.equalsIgnoreCase("riskCalCode"))
/*      */     {
/*  624 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCalCode));
/*      */     }
/*  626 */     if (FCode.equalsIgnoreCase("amntFlag"))
/*      */     {
/*  628 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.amntFlag));
/*      */     }
/*  630 */     if (FCode.equalsIgnoreCase("vPU"))
/*      */     {
/*  632 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vPU));
/*      */     }
/*  634 */     if (FCode.equalsIgnoreCase("addFeeFlag"))
/*      */     {
/*  636 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addFeeFlag));
/*      */     }
/*  638 */     if (FCode.equalsIgnoreCase("endDateCalMode"))
/*      */     {
/*  640 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endDateCalMode));
/*      */     }
/*  642 */     if (strReturn.equals(""))
/*      */     {
/*  644 */       strReturn = "null";
/*      */     }
/*      */ 
/*  647 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  654 */     String strFieldValue = "";
/*  655 */     switch (nFieldIndex) {
/*      */     case 0:
/*  657 */       strFieldValue = StrTool.GBKToUnicode(this.dutyCode);
/*  658 */       break;
/*      */     case 1:
/*  660 */       strFieldValue = StrTool.GBKToUnicode(this.dutyName);
/*  661 */       break;
/*      */     case 2:
/*  663 */       strFieldValue = String.valueOf(this.payEndYear);
/*  664 */       break;
/*      */     case 3:
/*  666 */       strFieldValue = StrTool.GBKToUnicode(this.payEndYearFlag);
/*  667 */       break;
/*      */     case 4:
/*  669 */       strFieldValue = StrTool.GBKToUnicode(this.payEndDateCalRef);
/*  670 */       break;
/*      */     case 5:
/*  672 */       strFieldValue = StrTool.GBKToUnicode(this.payEndDateCalMode);
/*  673 */       break;
/*      */     case 6:
/*  675 */       strFieldValue = String.valueOf(this.getYear);
/*  676 */       break;
/*      */     case 7:
/*  678 */       strFieldValue = StrTool.GBKToUnicode(this.getYearFlag);
/*  679 */       break;
/*      */     case 8:
/*  681 */       strFieldValue = String.valueOf(this.insuYear);
/*  682 */       break;
/*      */     case 9:
/*  684 */       strFieldValue = StrTool.GBKToUnicode(this.insuYearFlag);
/*  685 */       break;
/*      */     case 10:
/*  687 */       strFieldValue = String.valueOf(this.acciYear);
/*  688 */       break;
/*      */     case 11:
/*  690 */       strFieldValue = StrTool.GBKToUnicode(this.acciYearFlag);
/*  691 */       break;
/*      */     case 12:
/*  693 */       strFieldValue = StrTool.GBKToUnicode(this.calMode);
/*  694 */       break;
/*      */     case 13:
/*  696 */       strFieldValue = StrTool.GBKToUnicode(this.payEndYearRela);
/*  697 */       break;
/*      */     case 14:
/*  699 */       strFieldValue = StrTool.GBKToUnicode(this.getYearRela);
/*  700 */       break;
/*      */     case 15:
/*  702 */       strFieldValue = StrTool.GBKToUnicode(this.insuYearRela);
/*  703 */       break;
/*      */     case 16:
/*  705 */       strFieldValue = StrTool.GBKToUnicode(this.basicCalCode);
/*  706 */       break;
/*      */     case 17:
/*  708 */       strFieldValue = StrTool.GBKToUnicode(this.riskCalCode);
/*  709 */       break;
/*      */     case 18:
/*  711 */       strFieldValue = StrTool.GBKToUnicode(this.amntFlag);
/*  712 */       break;
/*      */     case 19:
/*  714 */       strFieldValue = String.valueOf(this.vPU);
/*  715 */       break;
/*      */     case 20:
/*  717 */       strFieldValue = StrTool.GBKToUnicode(this.addFeeFlag);
/*  718 */       break;
/*      */     case 21:
/*  720 */       strFieldValue = StrTool.GBKToUnicode(this.endDateCalMode);
/*  721 */       break;
/*      */     default:
/*  723 */       strFieldValue = "";
/*      */     }
/*  725 */     if (strFieldValue.equals("")) {
/*  726 */       strFieldValue = "null";
/*      */     }
/*  728 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  734 */     if (StrTool.cTrim(FCode).equals("")) {
/*  735 */       return false;
/*      */     }
/*  737 */     if (FCode.equalsIgnoreCase("dutyCode"))
/*      */     {
/*  739 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  741 */         this.dutyCode = FValue.trim();
/*      */       }
/*      */       else
/*  744 */         this.dutyCode = null;
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("dutyName"))
/*      */     {
/*  748 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  750 */         this.dutyName = FValue.trim();
/*      */       }
/*      */       else
/*  753 */         this.dutyName = null;
/*      */     }
/*  755 */     if (FCode.equalsIgnoreCase("payEndYear"))
/*      */     {
/*  757 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  759 */         Integer tInteger = new Integer(FValue);
/*  760 */         int i = tInteger.intValue();
/*  761 */         this.payEndYear = i;
/*      */       }
/*      */     }
/*  764 */     if (FCode.equalsIgnoreCase("payEndYearFlag"))
/*      */     {
/*  766 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  768 */         this.payEndYearFlag = FValue.trim();
/*      */       }
/*      */       else
/*  771 */         this.payEndYearFlag = null;
/*      */     }
/*  773 */     if (FCode.equalsIgnoreCase("payEndDateCalRef"))
/*      */     {
/*  775 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  777 */         this.payEndDateCalRef = FValue.trim();
/*      */       }
/*      */       else
/*  780 */         this.payEndDateCalRef = null;
/*      */     }
/*  782 */     if (FCode.equalsIgnoreCase("payEndDateCalMode"))
/*      */     {
/*  784 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  786 */         this.payEndDateCalMode = FValue.trim();
/*      */       }
/*      */       else
/*  789 */         this.payEndDateCalMode = null;
/*      */     }
/*  791 */     if (FCode.equalsIgnoreCase("getYear"))
/*      */     {
/*  793 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  795 */         Integer tInteger = new Integer(FValue);
/*  796 */         int i = tInteger.intValue();
/*  797 */         this.getYear = i;
/*      */       }
/*      */     }
/*  800 */     if (FCode.equalsIgnoreCase("getYearFlag"))
/*      */     {
/*  802 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  804 */         this.getYearFlag = FValue.trim();
/*      */       }
/*      */       else
/*  807 */         this.getYearFlag = null;
/*      */     }
/*  809 */     if (FCode.equalsIgnoreCase("insuYear"))
/*      */     {
/*  811 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  813 */         Integer tInteger = new Integer(FValue);
/*  814 */         int i = tInteger.intValue();
/*  815 */         this.insuYear = i;
/*      */       }
/*      */     }
/*  818 */     if (FCode.equalsIgnoreCase("insuYearFlag"))
/*      */     {
/*  820 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  822 */         this.insuYearFlag = FValue.trim();
/*      */       }
/*      */       else
/*  825 */         this.insuYearFlag = null;
/*      */     }
/*  827 */     if (FCode.equalsIgnoreCase("acciYear"))
/*      */     {
/*  829 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  831 */         Integer tInteger = new Integer(FValue);
/*  832 */         int i = tInteger.intValue();
/*  833 */         this.acciYear = i;
/*      */       }
/*      */     }
/*  836 */     if (FCode.equalsIgnoreCase("acciYearFlag"))
/*      */     {
/*  838 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  840 */         this.acciYearFlag = FValue.trim();
/*      */       }
/*      */       else
/*  843 */         this.acciYearFlag = null;
/*      */     }
/*  845 */     if (FCode.equalsIgnoreCase("calMode"))
/*      */     {
/*  847 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  849 */         this.calMode = FValue.trim();
/*      */       }
/*      */       else
/*  852 */         this.calMode = null;
/*      */     }
/*  854 */     if (FCode.equalsIgnoreCase("payEndYearRela"))
/*      */     {
/*  856 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  858 */         this.payEndYearRela = FValue.trim();
/*      */       }
/*      */       else
/*  861 */         this.payEndYearRela = null;
/*      */     }
/*  863 */     if (FCode.equalsIgnoreCase("getYearRela"))
/*      */     {
/*  865 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  867 */         this.getYearRela = FValue.trim();
/*      */       }
/*      */       else
/*  870 */         this.getYearRela = null;
/*      */     }
/*  872 */     if (FCode.equalsIgnoreCase("insuYearRela"))
/*      */     {
/*  874 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  876 */         this.insuYearRela = FValue.trim();
/*      */       }
/*      */       else
/*  879 */         this.insuYearRela = null;
/*      */     }
/*  881 */     if (FCode.equalsIgnoreCase("basicCalCode"))
/*      */     {
/*  883 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  885 */         this.basicCalCode = FValue.trim();
/*      */       }
/*      */       else
/*  888 */         this.basicCalCode = null;
/*      */     }
/*  890 */     if (FCode.equalsIgnoreCase("riskCalCode"))
/*      */     {
/*  892 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  894 */         this.riskCalCode = FValue.trim();
/*      */       }
/*      */       else
/*  897 */         this.riskCalCode = null;
/*      */     }
/*  899 */     if (FCode.equalsIgnoreCase("amntFlag"))
/*      */     {
/*  901 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  903 */         this.amntFlag = FValue.trim();
/*      */       }
/*      */       else
/*  906 */         this.amntFlag = null;
/*      */     }
/*  908 */     if (FCode.equalsIgnoreCase("vPU"))
/*      */     {
/*  910 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  912 */         Double tDouble = new Double(FValue);
/*  913 */         double d = tDouble.doubleValue();
/*  914 */         this.vPU = d;
/*      */       }
/*      */     }
/*  917 */     if (FCode.equalsIgnoreCase("addFeeFlag"))
/*      */     {
/*  919 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  921 */         this.addFeeFlag = FValue.trim();
/*      */       }
/*      */       else
/*  924 */         this.addFeeFlag = null;
/*      */     }
/*  926 */     if (FCode.equalsIgnoreCase("endDateCalMode"))
/*      */     {
/*  928 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  930 */         this.endDateCalMode = FValue.trim();
/*      */       }
/*      */       else
/*  933 */         this.endDateCalMode = null;
/*      */     }
/*  935 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  940 */     if (otherObject == null) return false;
/*  941 */     if (this == otherObject) return true;
/*  942 */     if (getClass() != otherObject.getClass()) return false;
/*  943 */     LNPDutySchema other = (LNPDutySchema)otherObject;
/*  944 */     if ((this.dutyCode == null) && (other.getDutyCode() != null)) return false;
/*  945 */     if ((this.dutyCode != null) && (!this.dutyCode.equals(other.getDutyCode()))) return false;
/*  946 */     if ((this.dutyName == null) && (other.getDutyName() != null)) return false;
/*  947 */     if ((this.dutyName != null) && (!this.dutyName.equals(other.getDutyName()))) return false;
/*  948 */     if (this.payEndYear != other.getPayEndYear()) return false;
/*  949 */     if ((this.payEndYearFlag == null) && (other.getPayEndYearFlag() != null)) return false;
/*  950 */     if ((this.payEndYearFlag != null) && (!this.payEndYearFlag.equals(other.getPayEndYearFlag()))) return false;
/*  951 */     if ((this.payEndDateCalRef == null) && (other.getPayEndDateCalRef() != null)) return false;
/*  952 */     if ((this.payEndDateCalRef != null) && (!this.payEndDateCalRef.equals(other.getPayEndDateCalRef()))) return false;
/*  953 */     if ((this.payEndDateCalMode == null) && (other.getPayEndDateCalMode() != null)) return false;
/*  954 */     if ((this.payEndDateCalMode != null) && (!this.payEndDateCalMode.equals(other.getPayEndDateCalMode()))) return false;
/*  955 */     if (this.getYear != other.getGetYear()) return false;
/*  956 */     if ((this.getYearFlag == null) && (other.getGetYearFlag() != null)) return false;
/*  957 */     if ((this.getYearFlag != null) && (!this.getYearFlag.equals(other.getGetYearFlag()))) return false;
/*  958 */     if (this.insuYear != other.getInsuYear()) return false;
/*  959 */     if ((this.insuYearFlag == null) && (other.getInsuYearFlag() != null)) return false;
/*  960 */     if ((this.insuYearFlag != null) && (!this.insuYearFlag.equals(other.getInsuYearFlag()))) return false;
/*  961 */     if (this.acciYear != other.getAcciYear()) return false;
/*  962 */     if ((this.acciYearFlag == null) && (other.getAcciYearFlag() != null)) return false;
/*  963 */     if ((this.acciYearFlag != null) && (!this.acciYearFlag.equals(other.getAcciYearFlag()))) return false;
/*  964 */     if ((this.calMode == null) && (other.getCalMode() != null)) return false;
/*  965 */     if ((this.calMode != null) && (!this.calMode.equals(other.getCalMode()))) return false;
/*  966 */     if ((this.payEndYearRela == null) && (other.getPayEndYearRela() != null)) return false;
/*  967 */     if ((this.payEndYearRela != null) && (!this.payEndYearRela.equals(other.getPayEndYearRela()))) return false;
/*  968 */     if ((this.getYearRela == null) && (other.getGetYearRela() != null)) return false;
/*  969 */     if ((this.getYearRela != null) && (!this.getYearRela.equals(other.getGetYearRela()))) return false;
/*  970 */     if ((this.insuYearRela == null) && (other.getInsuYearRela() != null)) return false;
/*  971 */     if ((this.insuYearRela != null) && (!this.insuYearRela.equals(other.getInsuYearRela()))) return false;
/*  972 */     if ((this.basicCalCode == null) && (other.getBasicCalCode() != null)) return false;
/*  973 */     if ((this.basicCalCode != null) && (!this.basicCalCode.equals(other.getBasicCalCode()))) return false;
/*  974 */     if ((this.riskCalCode == null) && (other.getRiskCalCode() != null)) return false;
/*  975 */     if ((this.riskCalCode != null) && (!this.riskCalCode.equals(other.getRiskCalCode()))) return false;
/*  976 */     if ((this.amntFlag == null) && (other.getAmntFlag() != null)) return false;
/*  977 */     if ((this.amntFlag != null) && (!this.amntFlag.equals(other.getAmntFlag()))) return false;
/*  978 */     if (Double.doubleToLongBits(this.vPU) != Double.doubleToLongBits(other.getVPU())) return false;
/*  979 */     if ((this.addFeeFlag == null) && (other.getAddFeeFlag() != null)) return false;
/*  980 */     if ((this.addFeeFlag != null) && (!this.addFeeFlag.equals(other.getAddFeeFlag()))) return false;
/*  981 */     if ((this.endDateCalMode == null) && (other.getEndDateCalMode() != null)) return false;
/*  982 */     return (this.endDateCalMode == null) || (this.endDateCalMode.equals(other.getEndDateCalMode()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  989 */     return 22;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  995 */     if (strFieldName.equals("dutyCode")) {
/*  996 */       return 0;
/*      */     }
/*  998 */     if (strFieldName.equals("dutyName")) {
/*  999 */       return 1;
/*      */     }
/* 1001 */     if (strFieldName.equals("payEndYear")) {
/* 1002 */       return 2;
/*      */     }
/* 1004 */     if (strFieldName.equals("payEndYearFlag")) {
/* 1005 */       return 3;
/*      */     }
/* 1007 */     if (strFieldName.equals("payEndDateCalRef")) {
/* 1008 */       return 4;
/*      */     }
/* 1010 */     if (strFieldName.equals("payEndDateCalMode")) {
/* 1011 */       return 5;
/*      */     }
/* 1013 */     if (strFieldName.equals("getYear")) {
/* 1014 */       return 6;
/*      */     }
/* 1016 */     if (strFieldName.equals("getYearFlag")) {
/* 1017 */       return 7;
/*      */     }
/* 1019 */     if (strFieldName.equals("insuYear")) {
/* 1020 */       return 8;
/*      */     }
/* 1022 */     if (strFieldName.equals("insuYearFlag")) {
/* 1023 */       return 9;
/*      */     }
/* 1025 */     if (strFieldName.equals("acciYear")) {
/* 1026 */       return 10;
/*      */     }
/* 1028 */     if (strFieldName.equals("acciYearFlag")) {
/* 1029 */       return 11;
/*      */     }
/* 1031 */     if (strFieldName.equals("calMode")) {
/* 1032 */       return 12;
/*      */     }
/* 1034 */     if (strFieldName.equals("payEndYearRela")) {
/* 1035 */       return 13;
/*      */     }
/* 1037 */     if (strFieldName.equals("getYearRela")) {
/* 1038 */       return 14;
/*      */     }
/* 1040 */     if (strFieldName.equals("insuYearRela")) {
/* 1041 */       return 15;
/*      */     }
/* 1043 */     if (strFieldName.equals("basicCalCode")) {
/* 1044 */       return 16;
/*      */     }
/* 1046 */     if (strFieldName.equals("riskCalCode")) {
/* 1047 */       return 17;
/*      */     }
/* 1049 */     if (strFieldName.equals("amntFlag")) {
/* 1050 */       return 18;
/*      */     }
/* 1052 */     if (strFieldName.equals("vPU")) {
/* 1053 */       return 19;
/*      */     }
/* 1055 */     if (strFieldName.equals("addFeeFlag")) {
/* 1056 */       return 20;
/*      */     }
/* 1058 */     if (strFieldName.equals("endDateCalMode")) {
/* 1059 */       return 21;
/*      */     }
/* 1061 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1067 */     String strFieldName = "";
/* 1068 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1070 */       strFieldName = "dutyCode";
/* 1071 */       break;
/*      */     case 1:
/* 1073 */       strFieldName = "dutyName";
/* 1074 */       break;
/*      */     case 2:
/* 1076 */       strFieldName = "payEndYear";
/* 1077 */       break;
/*      */     case 3:
/* 1079 */       strFieldName = "payEndYearFlag";
/* 1080 */       break;
/*      */     case 4:
/* 1082 */       strFieldName = "payEndDateCalRef";
/* 1083 */       break;
/*      */     case 5:
/* 1085 */       strFieldName = "payEndDateCalMode";
/* 1086 */       break;
/*      */     case 6:
/* 1088 */       strFieldName = "getYear";
/* 1089 */       break;
/*      */     case 7:
/* 1091 */       strFieldName = "getYearFlag";
/* 1092 */       break;
/*      */     case 8:
/* 1094 */       strFieldName = "insuYear";
/* 1095 */       break;
/*      */     case 9:
/* 1097 */       strFieldName = "insuYearFlag";
/* 1098 */       break;
/*      */     case 10:
/* 1100 */       strFieldName = "acciYear";
/* 1101 */       break;
/*      */     case 11:
/* 1103 */       strFieldName = "acciYearFlag";
/* 1104 */       break;
/*      */     case 12:
/* 1106 */       strFieldName = "calMode";
/* 1107 */       break;
/*      */     case 13:
/* 1109 */       strFieldName = "payEndYearRela";
/* 1110 */       break;
/*      */     case 14:
/* 1112 */       strFieldName = "getYearRela";
/* 1113 */       break;
/*      */     case 15:
/* 1115 */       strFieldName = "insuYearRela";
/* 1116 */       break;
/*      */     case 16:
/* 1118 */       strFieldName = "basicCalCode";
/* 1119 */       break;
/*      */     case 17:
/* 1121 */       strFieldName = "riskCalCode";
/* 1122 */       break;
/*      */     case 18:
/* 1124 */       strFieldName = "amntFlag";
/* 1125 */       break;
/*      */     case 19:
/* 1127 */       strFieldName = "vPU";
/* 1128 */       break;
/*      */     case 20:
/* 1130 */       strFieldName = "addFeeFlag";
/* 1131 */       break;
/*      */     case 21:
/* 1133 */       strFieldName = "endDateCalMode";
/* 1134 */       break;
/*      */     default:
/* 1136 */       strFieldName = "";
/*      */     }
/* 1138 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1144 */     if (strFieldName.equals("dutyCode")) {
/* 1145 */       return 0;
/*      */     }
/* 1147 */     if (strFieldName.equals("dutyName")) {
/* 1148 */       return 0;
/*      */     }
/* 1150 */     if (strFieldName.equals("payEndYear")) {
/* 1151 */       return 3;
/*      */     }
/* 1153 */     if (strFieldName.equals("payEndYearFlag")) {
/* 1154 */       return 0;
/*      */     }
/* 1156 */     if (strFieldName.equals("payEndDateCalRef")) {
/* 1157 */       return 0;
/*      */     }
/* 1159 */     if (strFieldName.equals("payEndDateCalMode")) {
/* 1160 */       return 0;
/*      */     }
/* 1162 */     if (strFieldName.equals("getYear")) {
/* 1163 */       return 3;
/*      */     }
/* 1165 */     if (strFieldName.equals("getYearFlag")) {
/* 1166 */       return 0;
/*      */     }
/* 1168 */     if (strFieldName.equals("insuYear")) {
/* 1169 */       return 3;
/*      */     }
/* 1171 */     if (strFieldName.equals("insuYearFlag")) {
/* 1172 */       return 0;
/*      */     }
/* 1174 */     if (strFieldName.equals("acciYear")) {
/* 1175 */       return 3;
/*      */     }
/* 1177 */     if (strFieldName.equals("acciYearFlag")) {
/* 1178 */       return 0;
/*      */     }
/* 1180 */     if (strFieldName.equals("calMode")) {
/* 1181 */       return 0;
/*      */     }
/* 1183 */     if (strFieldName.equals("payEndYearRela")) {
/* 1184 */       return 0;
/*      */     }
/* 1186 */     if (strFieldName.equals("getYearRela")) {
/* 1187 */       return 0;
/*      */     }
/* 1189 */     if (strFieldName.equals("insuYearRela")) {
/* 1190 */       return 0;
/*      */     }
/* 1192 */     if (strFieldName.equals("basicCalCode")) {
/* 1193 */       return 0;
/*      */     }
/* 1195 */     if (strFieldName.equals("riskCalCode")) {
/* 1196 */       return 0;
/*      */     }
/* 1198 */     if (strFieldName.equals("amntFlag")) {
/* 1199 */       return 0;
/*      */     }
/* 1201 */     if (strFieldName.equals("vPU")) {
/* 1202 */       return 4;
/*      */     }
/* 1204 */     if (strFieldName.equals("addFeeFlag")) {
/* 1205 */       return 0;
/*      */     }
/* 1207 */     if (strFieldName.equals("endDateCalMode")) {
/* 1208 */       return 0;
/*      */     }
/* 1210 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1216 */     int nFieldType = -1;
/* 1217 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1219 */       nFieldType = 0;
/* 1220 */       break;
/*      */     case 1:
/* 1222 */       nFieldType = 0;
/* 1223 */       break;
/*      */     case 2:
/* 1225 */       nFieldType = 3;
/* 1226 */       break;
/*      */     case 3:
/* 1228 */       nFieldType = 0;
/* 1229 */       break;
/*      */     case 4:
/* 1231 */       nFieldType = 0;
/* 1232 */       break;
/*      */     case 5:
/* 1234 */       nFieldType = 0;
/* 1235 */       break;
/*      */     case 6:
/* 1237 */       nFieldType = 3;
/* 1238 */       break;
/*      */     case 7:
/* 1240 */       nFieldType = 0;
/* 1241 */       break;
/*      */     case 8:
/* 1243 */       nFieldType = 3;
/* 1244 */       break;
/*      */     case 9:
/* 1246 */       nFieldType = 0;
/* 1247 */       break;
/*      */     case 10:
/* 1249 */       nFieldType = 3;
/* 1250 */       break;
/*      */     case 11:
/* 1252 */       nFieldType = 0;
/* 1253 */       break;
/*      */     case 12:
/* 1255 */       nFieldType = 0;
/* 1256 */       break;
/*      */     case 13:
/* 1258 */       nFieldType = 0;
/* 1259 */       break;
/*      */     case 14:
/* 1261 */       nFieldType = 0;
/* 1262 */       break;
/*      */     case 15:
/* 1264 */       nFieldType = 0;
/* 1265 */       break;
/*      */     case 16:
/* 1267 */       nFieldType = 0;
/* 1268 */       break;
/*      */     case 17:
/* 1270 */       nFieldType = 0;
/* 1271 */       break;
/*      */     case 18:
/* 1273 */       nFieldType = 0;
/* 1274 */       break;
/*      */     case 19:
/* 1276 */       nFieldType = 4;
/* 1277 */       break;
/*      */     case 20:
/* 1279 */       nFieldType = 0;
/* 1280 */       break;
/*      */     case 21:
/* 1282 */       nFieldType = 0;
/* 1283 */       break;
/*      */     default:
/* 1285 */       nFieldType = -1;
/*      */     }
/* 1287 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPDutySchema
 * JD-Core Version:    0.6.0
 */