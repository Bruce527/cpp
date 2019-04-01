/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskScreenDB;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class LNPRiskScreenSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String riskCode;
/*      */   private int ctrlIndex;
/*      */   private String ctrlType;
/*      */   private String ctrlCode;
/*      */   private String ctrlName;
/*      */   private String ctrlLevel;
/*      */   private String ctrlProperty;
/*      */   private int ctrlAlignX;
/*      */   private int ctrlAlignY;
/*      */   private int ctrlHorizontal;
/*      */   private int ctrlVertical;
/*      */   private String ctrlBackground;
/*      */   private int labelAlignX;
/*      */   private int labelAlignY;
/*      */   private int labelHorizontal;
/*      */   private int labelVertical;
/*      */   private String labelBackground;
/*      */   private String defaultValue;
/*      */   private String defaultSql;
/*      */   private String ctrlProperty1;
/*      */   private String ctrlProperty2;
/*      */   private String noti;
/*      */   public static final int FIELDNUM = 22;
/*      */   private static String[] PK;
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPRiskScreenSchema()
/*      */   {
/*   76 */     this.mErrors = new CErrors();
/*      */ 
/*   78 */     String[] pk = new String[2];
/*   79 */     pk[0] = "RiskCode";
/*   80 */     pk[1] = "CtrlIndex";
/*      */ 
/*   82 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   89 */     LNPRiskScreenSchema cloned = (LNPRiskScreenSchema)super.clone();
/*   90 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   91 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   97 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getRiskCode()
/*      */   {
/*  102 */     return this.riskCode;
/*      */   }
/*      */ 
/*      */   public void setRiskCode(String aRiskCode) {
/*  106 */     this.riskCode = aRiskCode;
/*      */   }
/*      */ 
/*      */   public int getCtrlIndex() {
/*  110 */     return this.ctrlIndex;
/*      */   }
/*      */ 
/*      */   public void setCtrlIndex(int aCtrlIndex) {
/*  114 */     this.ctrlIndex = aCtrlIndex;
/*      */   }
/*      */ 
/*      */   public void setCtrlIndex(String aCtrlIndex) {
/*  118 */     if ((aCtrlIndex != null) && (!aCtrlIndex.equals("")))
/*      */     {
/*  120 */       Integer tInteger = new Integer(aCtrlIndex);
/*  121 */       int i = tInteger.intValue();
/*  122 */       this.ctrlIndex = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getCtrlType()
/*      */   {
/*  128 */     return this.ctrlType;
/*      */   }
/*      */ 
/*      */   public void setCtrlType(String aCtrlType) {
/*  132 */     this.ctrlType = aCtrlType;
/*      */   }
/*      */ 
/*      */   public String getCtrlCode() {
/*  136 */     return this.ctrlCode;
/*      */   }
/*      */ 
/*      */   public void setCtrlCode(String aCtrlCode) {
/*  140 */     this.ctrlCode = aCtrlCode;
/*      */   }
/*      */ 
/*      */   public String getCtrlName() {
/*  144 */     return this.ctrlName;
/*      */   }
/*      */ 
/*      */   public void setCtrlName(String aCtrlName) {
/*  148 */     this.ctrlName = aCtrlName;
/*      */   }
/*      */ 
/*      */   public String getCtrlLevel() {
/*  152 */     return this.ctrlLevel;
/*      */   }
/*      */ 
/*      */   public void setCtrlLevel(String aCtrlLevel) {
/*  156 */     this.ctrlLevel = aCtrlLevel;
/*      */   }
/*      */ 
/*      */   public String getCtrlProperty() {
/*  160 */     return this.ctrlProperty;
/*      */   }
/*      */ 
/*      */   public void setCtrlProperty(String aCtrlProperty) {
/*  164 */     this.ctrlProperty = aCtrlProperty;
/*      */   }
/*      */ 
/*      */   public int getCtrlAlignX() {
/*  168 */     return this.ctrlAlignX;
/*      */   }
/*      */ 
/*      */   public void setCtrlAlignX(int aCtrlAlignX) {
/*  172 */     this.ctrlAlignX = aCtrlAlignX;
/*      */   }
/*      */ 
/*      */   public void setCtrlAlignX(String aCtrlAlignX) {
/*  176 */     if ((aCtrlAlignX != null) && (!aCtrlAlignX.equals("")))
/*      */     {
/*  178 */       Integer tInteger = new Integer(aCtrlAlignX);
/*  179 */       int i = tInteger.intValue();
/*  180 */       this.ctrlAlignX = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getCtrlAlignY()
/*      */   {
/*  186 */     return this.ctrlAlignY;
/*      */   }
/*      */ 
/*      */   public void setCtrlAlignY(int aCtrlAlignY) {
/*  190 */     this.ctrlAlignY = aCtrlAlignY;
/*      */   }
/*      */ 
/*      */   public void setCtrlAlignY(String aCtrlAlignY) {
/*  194 */     if ((aCtrlAlignY != null) && (!aCtrlAlignY.equals("")))
/*      */     {
/*  196 */       Integer tInteger = new Integer(aCtrlAlignY);
/*  197 */       int i = tInteger.intValue();
/*  198 */       this.ctrlAlignY = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getCtrlHorizontal()
/*      */   {
/*  204 */     return this.ctrlHorizontal;
/*      */   }
/*      */ 
/*      */   public void setCtrlHorizontal(int aCtrlHorizontal) {
/*  208 */     this.ctrlHorizontal = aCtrlHorizontal;
/*      */   }
/*      */ 
/*      */   public void setCtrlHorizontal(String aCtrlHorizontal) {
/*  212 */     if ((aCtrlHorizontal != null) && (!aCtrlHorizontal.equals("")))
/*      */     {
/*  214 */       Integer tInteger = new Integer(aCtrlHorizontal);
/*  215 */       int i = tInteger.intValue();
/*  216 */       this.ctrlHorizontal = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getCtrlVertical()
/*      */   {
/*  222 */     return this.ctrlVertical;
/*      */   }
/*      */ 
/*      */   public void setCtrlVertical(int aCtrlVertical) {
/*  226 */     this.ctrlVertical = aCtrlVertical;
/*      */   }
/*      */ 
/*      */   public void setCtrlVertical(String aCtrlVertical) {
/*  230 */     if ((aCtrlVertical != null) && (!aCtrlVertical.equals("")))
/*      */     {
/*  232 */       Integer tInteger = new Integer(aCtrlVertical);
/*  233 */       int i = tInteger.intValue();
/*  234 */       this.ctrlVertical = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getCtrlBackground()
/*      */   {
/*  240 */     return this.ctrlBackground;
/*      */   }
/*      */ 
/*      */   public void setCtrlBackground(String aCtrlBackground) {
/*  244 */     this.ctrlBackground = aCtrlBackground;
/*      */   }
/*      */ 
/*      */   public int getLabelAlignX() {
/*  248 */     return this.labelAlignX;
/*      */   }
/*      */ 
/*      */   public void setLabelAlignX(int aLabelAlignX) {
/*  252 */     this.labelAlignX = aLabelAlignX;
/*      */   }
/*      */ 
/*      */   public void setLabelAlignX(String aLabelAlignX) {
/*  256 */     if ((aLabelAlignX != null) && (!aLabelAlignX.equals("")))
/*      */     {
/*  258 */       Integer tInteger = new Integer(aLabelAlignX);
/*  259 */       int i = tInteger.intValue();
/*  260 */       this.labelAlignX = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getLabelAlignY()
/*      */   {
/*  266 */     return this.labelAlignY;
/*      */   }
/*      */ 
/*      */   public void setLabelAlignY(int aLabelAlignY) {
/*  270 */     this.labelAlignY = aLabelAlignY;
/*      */   }
/*      */ 
/*      */   public void setLabelAlignY(String aLabelAlignY) {
/*  274 */     if ((aLabelAlignY != null) && (!aLabelAlignY.equals("")))
/*      */     {
/*  276 */       Integer tInteger = new Integer(aLabelAlignY);
/*  277 */       int i = tInteger.intValue();
/*  278 */       this.labelAlignY = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getLabelHorizontal()
/*      */   {
/*  284 */     return this.labelHorizontal;
/*      */   }
/*      */ 
/*      */   public void setLabelHorizontal(int aLabelHorizontal) {
/*  288 */     this.labelHorizontal = aLabelHorizontal;
/*      */   }
/*      */ 
/*      */   public void setLabelHorizontal(String aLabelHorizontal) {
/*  292 */     if ((aLabelHorizontal != null) && (!aLabelHorizontal.equals("")))
/*      */     {
/*  294 */       Integer tInteger = new Integer(aLabelHorizontal);
/*  295 */       int i = tInteger.intValue();
/*  296 */       this.labelHorizontal = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getLabelVertical()
/*      */   {
/*  302 */     return this.labelVertical;
/*      */   }
/*      */ 
/*      */   public void setLabelVertical(int aLabelVertical) {
/*  306 */     this.labelVertical = aLabelVertical;
/*      */   }
/*      */ 
/*      */   public void setLabelVertical(String aLabelVertical) {
/*  310 */     if ((aLabelVertical != null) && (!aLabelVertical.equals("")))
/*      */     {
/*  312 */       Integer tInteger = new Integer(aLabelVertical);
/*  313 */       int i = tInteger.intValue();
/*  314 */       this.labelVertical = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getLabelBackground()
/*      */   {
/*  320 */     return this.labelBackground;
/*      */   }
/*      */ 
/*      */   public void setLabelBackground(String aLabelBackground) {
/*  324 */     this.labelBackground = aLabelBackground;
/*      */   }
/*      */ 
/*      */   public String getDefaultValue() {
/*  328 */     return this.defaultValue;
/*      */   }
/*      */ 
/*      */   public void setDefaultValue(String aDefaultValue) {
/*  332 */     this.defaultValue = aDefaultValue;
/*      */   }
/*      */ 
/*      */   public String getDefaultSql() {
/*  336 */     return this.defaultSql;
/*      */   }
/*      */ 
/*      */   public void setDefaultSql(String aDefaultSql) {
/*  340 */     this.defaultSql = aDefaultSql;
/*      */   }
/*      */ 
/*      */   public String getCtrlProperty1() {
/*  344 */     return this.ctrlProperty1;
/*      */   }
/*      */ 
/*      */   public void setCtrlProperty1(String aCtrlProperty1) {
/*  348 */     this.ctrlProperty1 = aCtrlProperty1;
/*      */   }
/*      */ 
/*      */   public String getCtrlProperty2() {
/*  352 */     return this.ctrlProperty2;
/*      */   }
/*      */ 
/*      */   public void setCtrlProperty2(String aCtrlProperty2) {
/*  356 */     this.ctrlProperty2 = aCtrlProperty2;
/*      */   }
/*      */ 
/*      */   public String getNoti() {
/*  360 */     return this.noti;
/*      */   }
/*      */ 
/*      */   public void setNoti(String aNoti) {
/*  364 */     this.noti = aNoti;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPRiskScreenSchema aLNPRiskScreenSchema)
/*      */   {
/*  370 */     this.riskCode = aLNPRiskScreenSchema.getRiskCode();
/*  371 */     this.ctrlIndex = aLNPRiskScreenSchema.getCtrlIndex();
/*  372 */     this.ctrlType = aLNPRiskScreenSchema.getCtrlType();
/*  373 */     this.ctrlCode = aLNPRiskScreenSchema.getCtrlCode();
/*  374 */     this.ctrlName = aLNPRiskScreenSchema.getCtrlName();
/*  375 */     this.ctrlLevel = aLNPRiskScreenSchema.getCtrlLevel();
/*  376 */     this.ctrlProperty = aLNPRiskScreenSchema.getCtrlProperty();
/*  377 */     this.ctrlAlignX = aLNPRiskScreenSchema.getCtrlAlignX();
/*  378 */     this.ctrlAlignY = aLNPRiskScreenSchema.getCtrlAlignY();
/*  379 */     this.ctrlHorizontal = aLNPRiskScreenSchema.getCtrlHorizontal();
/*  380 */     this.ctrlVertical = aLNPRiskScreenSchema.getCtrlVertical();
/*  381 */     this.ctrlBackground = aLNPRiskScreenSchema.getCtrlBackground();
/*  382 */     this.labelAlignX = aLNPRiskScreenSchema.getLabelAlignX();
/*  383 */     this.labelAlignY = aLNPRiskScreenSchema.getLabelAlignY();
/*  384 */     this.labelHorizontal = aLNPRiskScreenSchema.getLabelHorizontal();
/*  385 */     this.labelVertical = aLNPRiskScreenSchema.getLabelVertical();
/*  386 */     this.labelBackground = aLNPRiskScreenSchema.getLabelBackground();
/*  387 */     this.defaultValue = aLNPRiskScreenSchema.getDefaultValue();
/*  388 */     this.defaultSql = aLNPRiskScreenSchema.getDefaultSql();
/*  389 */     this.ctrlProperty1 = aLNPRiskScreenSchema.getCtrlProperty1();
/*  390 */     this.ctrlProperty2 = aLNPRiskScreenSchema.getCtrlProperty2();
/*  391 */     this.noti = aLNPRiskScreenSchema.getNoti();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  400 */       if (rs.getString("RiskCode") == null)
/*  401 */         this.riskCode = null;
/*      */       else {
/*  403 */         this.riskCode = rs.getString("RiskCode").trim();
/*      */       }
/*  405 */       this.ctrlIndex = rs.getInt("CtrlIndex");
/*  406 */       if (rs.getString("CtrlType") == null)
/*  407 */         this.ctrlType = null;
/*      */       else {
/*  409 */         this.ctrlType = rs.getString("CtrlType").trim();
/*      */       }
/*  411 */       if (rs.getString("CtrlCode") == null)
/*  412 */         this.ctrlCode = null;
/*      */       else {
/*  414 */         this.ctrlCode = rs.getString("CtrlCode").trim();
/*      */       }
/*  416 */       if (rs.getString("CtrlName") == null)
/*  417 */         this.ctrlName = null;
/*      */       else {
/*  419 */         this.ctrlName = rs.getString("CtrlName").trim();
/*      */       }
/*  421 */       if (rs.getString("CtrlLevel") == null)
/*  422 */         this.ctrlLevel = null;
/*      */       else {
/*  424 */         this.ctrlLevel = rs.getString("CtrlLevel").trim();
/*      */       }
/*  426 */       if (rs.getString("CtrlProperty") == null)
/*  427 */         this.ctrlProperty = null;
/*      */       else {
/*  429 */         this.ctrlProperty = rs.getString("CtrlProperty").trim();
/*      */       }
/*  431 */       this.ctrlAlignX = rs.getInt("CtrlAlignX");
/*  432 */       this.ctrlAlignY = rs.getInt("CtrlAlignY");
/*  433 */       this.ctrlHorizontal = rs.getInt("CtrlHorizontal");
/*  434 */       this.ctrlVertical = rs.getInt("CtrlVertical");
/*  435 */       if (rs.getString("CtrlBackground") == null)
/*  436 */         this.ctrlBackground = null;
/*      */       else {
/*  438 */         this.ctrlBackground = rs.getString("CtrlBackground").trim();
/*      */       }
/*  440 */       this.labelAlignX = rs.getInt("LabelAlignX");
/*  441 */       this.labelAlignY = rs.getInt("LabelAlignY");
/*  442 */       this.labelHorizontal = rs.getInt("LabelHorizontal");
/*  443 */       this.labelVertical = rs.getInt("LabelVertical");
/*  444 */       if (rs.getString("LabelBackground") == null)
/*  445 */         this.labelBackground = null;
/*      */       else {
/*  447 */         this.labelBackground = rs.getString("LabelBackground").trim();
/*      */       }
/*  449 */       if (rs.getString("DefaultValue") == null)
/*  450 */         this.defaultValue = null;
/*      */       else {
/*  452 */         this.defaultValue = rs.getString("DefaultValue").trim();
/*      */       }
/*  454 */       if (rs.getString("DefaultSql") == null)
/*  455 */         this.defaultSql = null;
/*      */       else {
/*  457 */         this.defaultSql = rs.getString("DefaultSql").trim();
/*      */       }
/*  459 */       if (rs.getString("CtrlProperty1") == null)
/*  460 */         this.ctrlProperty1 = null;
/*      */       else {
/*  462 */         this.ctrlProperty1 = rs.getString("CtrlProperty1").trim();
/*      */       }
/*  464 */       if (rs.getString("CtrlProperty2") == null)
/*  465 */         this.ctrlProperty2 = null;
/*      */       else {
/*  467 */         this.ctrlProperty2 = rs.getString("CtrlProperty2").trim();
/*      */       }
/*  469 */       if (rs.getString("Noti") == null)
/*  470 */         this.noti = null;
/*      */       else {
/*  472 */         this.noti = rs.getString("Noti").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  477 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRiskScreen\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/*  479 */       CError tError = new CError();
/*  480 */       tError.moduleName = "LNPRiskScreenSchema";
/*  481 */       tError.functionName = "setSchema";
/*  482 */       tError.errorMessage = sqle.toString();
/*  483 */       this.mErrors.addOneError(tError);
/*  484 */       return false;
/*      */     }
/*  486 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenSchema getSchema()
/*      */   {
/*  491 */     LNPRiskScreenSchema aLNPRiskScreenSchema = new LNPRiskScreenSchema();
/*  492 */     aLNPRiskScreenSchema.setSchema(this);
/*  493 */     return aLNPRiskScreenSchema;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenDB getDB()
/*      */   {
/*  498 */     LNPRiskScreenDB aDBOper = new LNPRiskScreenDB();
/*  499 */     aDBOper.setSchema(this);
/*  500 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  507 */     StringBuffer strReturn = new StringBuffer(256);
/*  508 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/*  509 */     strReturn.append(ChgData.chgData(this.ctrlIndex)); strReturn.append("|");
/*  510 */     strReturn.append(StrTool.cTrim(this.ctrlType)); strReturn.append("|");
/*  511 */     strReturn.append(StrTool.cTrim(this.ctrlCode)); strReturn.append("|");
/*  512 */     strReturn.append(StrTool.cTrim(this.ctrlName)); strReturn.append("|");
/*  513 */     strReturn.append(StrTool.cTrim(this.ctrlLevel)); strReturn.append("|");
/*  514 */     strReturn.append(StrTool.cTrim(this.ctrlProperty)); strReturn.append("|");
/*  515 */     strReturn.append(ChgData.chgData(this.ctrlAlignX)); strReturn.append("|");
/*  516 */     strReturn.append(ChgData.chgData(this.ctrlAlignY)); strReturn.append("|");
/*  517 */     strReturn.append(ChgData.chgData(this.ctrlHorizontal)); strReturn.append("|");
/*  518 */     strReturn.append(ChgData.chgData(this.ctrlVertical)); strReturn.append("|");
/*  519 */     strReturn.append(StrTool.cTrim(this.ctrlBackground)); strReturn.append("|");
/*  520 */     strReturn.append(ChgData.chgData(this.labelAlignX)); strReturn.append("|");
/*  521 */     strReturn.append(ChgData.chgData(this.labelAlignY)); strReturn.append("|");
/*  522 */     strReturn.append(ChgData.chgData(this.labelHorizontal)); strReturn.append("|");
/*  523 */     strReturn.append(ChgData.chgData(this.labelVertical)); strReturn.append("|");
/*  524 */     strReturn.append(StrTool.cTrim(this.labelBackground)); strReturn.append("|");
/*  525 */     strReturn.append(StrTool.cTrim(this.defaultValue)); strReturn.append("|");
/*  526 */     strReturn.append(StrTool.cTrim(this.defaultSql)); strReturn.append("|");
/*  527 */     strReturn.append(StrTool.cTrim(this.ctrlProperty1)); strReturn.append("|");
/*  528 */     strReturn.append(StrTool.cTrim(this.ctrlProperty2)); strReturn.append("|");
/*  529 */     strReturn.append(StrTool.cTrim(this.noti));
/*  530 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  538 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  539 */       this.ctrlIndex = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 2, "|"))).intValue();
/*  540 */       this.ctrlType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  541 */       this.ctrlCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  542 */       this.ctrlName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  543 */       this.ctrlLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  544 */       this.ctrlProperty = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  545 */       this.ctrlAlignX = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).intValue();
/*  546 */       this.ctrlAlignY = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).intValue();
/*  547 */       this.ctrlHorizontal = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/*  548 */       this.ctrlVertical = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).intValue();
/*  549 */       this.ctrlBackground = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  550 */       this.labelAlignX = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).intValue();
/*  551 */       this.labelAlignY = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|"))).intValue();
/*  552 */       this.labelHorizontal = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).intValue();
/*  553 */       this.labelVertical = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|"))).intValue();
/*  554 */       this.labelBackground = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  555 */       this.defaultValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  556 */       this.defaultSql = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  557 */       this.ctrlProperty1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  558 */       this.ctrlProperty2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  559 */       this.noti = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  564 */       CError tError = new CError();
/*  565 */       tError.moduleName = "LNPRiskScreenSchema";
/*  566 */       tError.functionName = "decode";
/*  567 */       tError.errorMessage = ex.toString();
/*  568 */       this.mErrors.addOneError(tError);
/*      */ 
/*  570 */       return false;
/*      */     }
/*  572 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  578 */     String strReturn = "";
/*  579 */     if (FCode.equalsIgnoreCase("riskCode"))
/*      */     {
/*  581 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*      */     }
/*  583 */     if (FCode.equalsIgnoreCase("ctrlIndex"))
/*      */     {
/*  585 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlIndex));
/*      */     }
/*  587 */     if (FCode.equalsIgnoreCase("ctrlType"))
/*      */     {
/*  589 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlType));
/*      */     }
/*  591 */     if (FCode.equalsIgnoreCase("ctrlCode"))
/*      */     {
/*  593 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlCode));
/*      */     }
/*  595 */     if (FCode.equalsIgnoreCase("ctrlName"))
/*      */     {
/*  597 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlName));
/*      */     }
/*  599 */     if (FCode.equalsIgnoreCase("ctrlLevel"))
/*      */     {
/*  601 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlLevel));
/*      */     }
/*  603 */     if (FCode.equalsIgnoreCase("ctrlProperty"))
/*      */     {
/*  605 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlProperty));
/*      */     }
/*  607 */     if (FCode.equalsIgnoreCase("ctrlAlignX"))
/*      */     {
/*  609 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlAlignX));
/*      */     }
/*  611 */     if (FCode.equalsIgnoreCase("ctrlAlignY"))
/*      */     {
/*  613 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlAlignY));
/*      */     }
/*  615 */     if (FCode.equalsIgnoreCase("ctrlHorizontal"))
/*      */     {
/*  617 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlHorizontal));
/*      */     }
/*  619 */     if (FCode.equalsIgnoreCase("ctrlVertical"))
/*      */     {
/*  621 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlVertical));
/*      */     }
/*  623 */     if (FCode.equalsIgnoreCase("ctrlBackground"))
/*      */     {
/*  625 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlBackground));
/*      */     }
/*  627 */     if (FCode.equalsIgnoreCase("labelAlignX"))
/*      */     {
/*  629 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.labelAlignX));
/*      */     }
/*  631 */     if (FCode.equalsIgnoreCase("labelAlignY"))
/*      */     {
/*  633 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.labelAlignY));
/*      */     }
/*  635 */     if (FCode.equalsIgnoreCase("labelHorizontal"))
/*      */     {
/*  637 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.labelHorizontal));
/*      */     }
/*  639 */     if (FCode.equalsIgnoreCase("labelVertical"))
/*      */     {
/*  641 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.labelVertical));
/*      */     }
/*  643 */     if (FCode.equalsIgnoreCase("labelBackground"))
/*      */     {
/*  645 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.labelBackground));
/*      */     }
/*  647 */     if (FCode.equalsIgnoreCase("defaultValue"))
/*      */     {
/*  649 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.defaultValue));
/*      */     }
/*  651 */     if (FCode.equalsIgnoreCase("defaultSql"))
/*      */     {
/*  653 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.defaultSql));
/*      */     }
/*  655 */     if (FCode.equalsIgnoreCase("ctrlProperty1"))
/*      */     {
/*  657 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlProperty1));
/*      */     }
/*  659 */     if (FCode.equalsIgnoreCase("ctrlProperty2"))
/*      */     {
/*  661 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ctrlProperty2));
/*      */     }
/*  663 */     if (FCode.equalsIgnoreCase("noti"))
/*      */     {
/*  665 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.noti));
/*      */     }
/*  667 */     if (strReturn.equals(""))
/*      */     {
/*  669 */       strReturn = "null";
/*      */     }
/*      */ 
/*  672 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  679 */     String strFieldValue = "";
/*  680 */     switch (nFieldIndex) {
/*      */     case 0:
/*  682 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/*  683 */       break;
/*      */     case 1:
/*  685 */       strFieldValue = String.valueOf(this.ctrlIndex);
/*  686 */       break;
/*      */     case 2:
/*  688 */       strFieldValue = StrTool.GBKToUnicode(this.ctrlType);
/*  689 */       break;
/*      */     case 3:
/*  691 */       strFieldValue = StrTool.GBKToUnicode(this.ctrlCode);
/*  692 */       break;
/*      */     case 4:
/*  694 */       strFieldValue = StrTool.GBKToUnicode(this.ctrlName);
/*  695 */       break;
/*      */     case 5:
/*  697 */       strFieldValue = StrTool.GBKToUnicode(this.ctrlLevel);
/*  698 */       break;
/*      */     case 6:
/*  700 */       strFieldValue = StrTool.GBKToUnicode(this.ctrlProperty);
/*  701 */       break;
/*      */     case 7:
/*  703 */       strFieldValue = String.valueOf(this.ctrlAlignX);
/*  704 */       break;
/*      */     case 8:
/*  706 */       strFieldValue = String.valueOf(this.ctrlAlignY);
/*  707 */       break;
/*      */     case 9:
/*  709 */       strFieldValue = String.valueOf(this.ctrlHorizontal);
/*  710 */       break;
/*      */     case 10:
/*  712 */       strFieldValue = String.valueOf(this.ctrlVertical);
/*  713 */       break;
/*      */     case 11:
/*  715 */       strFieldValue = StrTool.GBKToUnicode(this.ctrlBackground);
/*  716 */       break;
/*      */     case 12:
/*  718 */       strFieldValue = String.valueOf(this.labelAlignX);
/*  719 */       break;
/*      */     case 13:
/*  721 */       strFieldValue = String.valueOf(this.labelAlignY);
/*  722 */       break;
/*      */     case 14:
/*  724 */       strFieldValue = String.valueOf(this.labelHorizontal);
/*  725 */       break;
/*      */     case 15:
/*  727 */       strFieldValue = String.valueOf(this.labelVertical);
/*  728 */       break;
/*      */     case 16:
/*  730 */       strFieldValue = StrTool.GBKToUnicode(this.labelBackground);
/*  731 */       break;
/*      */     case 17:
/*  733 */       strFieldValue = StrTool.GBKToUnicode(this.defaultValue);
/*  734 */       break;
/*      */     case 18:
/*  736 */       strFieldValue = StrTool.GBKToUnicode(this.defaultSql);
/*  737 */       break;
/*      */     case 19:
/*  739 */       strFieldValue = StrTool.GBKToUnicode(this.ctrlProperty1);
/*  740 */       break;
/*      */     case 20:
/*  742 */       strFieldValue = StrTool.GBKToUnicode(this.ctrlProperty2);
/*  743 */       break;
/*      */     case 21:
/*  745 */       strFieldValue = StrTool.GBKToUnicode(this.noti);
/*  746 */       break;
/*      */     default:
/*  748 */       strFieldValue = "";
/*      */     }
/*  750 */     if (strFieldValue.equals("")) {
/*  751 */       strFieldValue = "null";
/*      */     }
/*  753 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  759 */     if (StrTool.cTrim(FCode).equals("")) {
/*  760 */       return false;
/*      */     }
/*  762 */     if (FCode.equalsIgnoreCase("riskCode"))
/*      */     {
/*  764 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  766 */         this.riskCode = FValue.trim();
/*      */       }
/*      */       else
/*  769 */         this.riskCode = null;
/*      */     }
/*  771 */     if (FCode.equalsIgnoreCase("ctrlIndex"))
/*      */     {
/*  773 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  775 */         Integer tInteger = new Integer(FValue);
/*  776 */         int i = tInteger.intValue();
/*  777 */         this.ctrlIndex = i;
/*      */       }
/*      */     }
/*  780 */     if (FCode.equalsIgnoreCase("ctrlType"))
/*      */     {
/*  782 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  784 */         this.ctrlType = FValue.trim();
/*      */       }
/*      */       else
/*  787 */         this.ctrlType = null;
/*      */     }
/*  789 */     if (FCode.equalsIgnoreCase("ctrlCode"))
/*      */     {
/*  791 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  793 */         this.ctrlCode = FValue.trim();
/*      */       }
/*      */       else
/*  796 */         this.ctrlCode = null;
/*      */     }
/*  798 */     if (FCode.equalsIgnoreCase("ctrlName"))
/*      */     {
/*  800 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  802 */         this.ctrlName = FValue.trim();
/*      */       }
/*      */       else
/*  805 */         this.ctrlName = null;
/*      */     }
/*  807 */     if (FCode.equalsIgnoreCase("ctrlLevel"))
/*      */     {
/*  809 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  811 */         this.ctrlLevel = FValue.trim();
/*      */       }
/*      */       else
/*  814 */         this.ctrlLevel = null;
/*      */     }
/*  816 */     if (FCode.equalsIgnoreCase("ctrlProperty"))
/*      */     {
/*  818 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  820 */         this.ctrlProperty = FValue.trim();
/*      */       }
/*      */       else
/*  823 */         this.ctrlProperty = null;
/*      */     }
/*  825 */     if (FCode.equalsIgnoreCase("ctrlAlignX"))
/*      */     {
/*  827 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  829 */         Integer tInteger = new Integer(FValue);
/*  830 */         int i = tInteger.intValue();
/*  831 */         this.ctrlAlignX = i;
/*      */       }
/*      */     }
/*  834 */     if (FCode.equalsIgnoreCase("ctrlAlignY"))
/*      */     {
/*  836 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  838 */         Integer tInteger = new Integer(FValue);
/*  839 */         int i = tInteger.intValue();
/*  840 */         this.ctrlAlignY = i;
/*      */       }
/*      */     }
/*  843 */     if (FCode.equalsIgnoreCase("ctrlHorizontal"))
/*      */     {
/*  845 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  847 */         Integer tInteger = new Integer(FValue);
/*  848 */         int i = tInteger.intValue();
/*  849 */         this.ctrlHorizontal = i;
/*      */       }
/*      */     }
/*  852 */     if (FCode.equalsIgnoreCase("ctrlVertical"))
/*      */     {
/*  854 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  856 */         Integer tInteger = new Integer(FValue);
/*  857 */         int i = tInteger.intValue();
/*  858 */         this.ctrlVertical = i;
/*      */       }
/*      */     }
/*  861 */     if (FCode.equalsIgnoreCase("ctrlBackground"))
/*      */     {
/*  863 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  865 */         this.ctrlBackground = FValue.trim();
/*      */       }
/*      */       else
/*  868 */         this.ctrlBackground = null;
/*      */     }
/*  870 */     if (FCode.equalsIgnoreCase("labelAlignX"))
/*      */     {
/*  872 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  874 */         Integer tInteger = new Integer(FValue);
/*  875 */         int i = tInteger.intValue();
/*  876 */         this.labelAlignX = i;
/*      */       }
/*      */     }
/*  879 */     if (FCode.equalsIgnoreCase("labelAlignY"))
/*      */     {
/*  881 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  883 */         Integer tInteger = new Integer(FValue);
/*  884 */         int i = tInteger.intValue();
/*  885 */         this.labelAlignY = i;
/*      */       }
/*      */     }
/*  888 */     if (FCode.equalsIgnoreCase("labelHorizontal"))
/*      */     {
/*  890 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  892 */         Integer tInteger = new Integer(FValue);
/*  893 */         int i = tInteger.intValue();
/*  894 */         this.labelHorizontal = i;
/*      */       }
/*      */     }
/*  897 */     if (FCode.equalsIgnoreCase("labelVertical"))
/*      */     {
/*  899 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  901 */         Integer tInteger = new Integer(FValue);
/*  902 */         int i = tInteger.intValue();
/*  903 */         this.labelVertical = i;
/*      */       }
/*      */     }
/*  906 */     if (FCode.equalsIgnoreCase("labelBackground"))
/*      */     {
/*  908 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  910 */         this.labelBackground = FValue.trim();
/*      */       }
/*      */       else
/*  913 */         this.labelBackground = null;
/*      */     }
/*  915 */     if (FCode.equalsIgnoreCase("defaultValue"))
/*      */     {
/*  917 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  919 */         this.defaultValue = FValue.trim();
/*      */       }
/*      */       else
/*  922 */         this.defaultValue = null;
/*      */     }
/*  924 */     if (FCode.equalsIgnoreCase("defaultSql"))
/*      */     {
/*  926 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  928 */         this.defaultSql = FValue.trim();
/*      */       }
/*      */       else
/*  931 */         this.defaultSql = null;
/*      */     }
/*  933 */     if (FCode.equalsIgnoreCase("ctrlProperty1"))
/*      */     {
/*  935 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  937 */         this.ctrlProperty1 = FValue.trim();
/*      */       }
/*      */       else
/*  940 */         this.ctrlProperty1 = null;
/*      */     }
/*  942 */     if (FCode.equalsIgnoreCase("ctrlProperty2"))
/*      */     {
/*  944 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  946 */         this.ctrlProperty2 = FValue.trim();
/*      */       }
/*      */       else
/*  949 */         this.ctrlProperty2 = null;
/*      */     }
/*  951 */     if (FCode.equalsIgnoreCase("noti"))
/*      */     {
/*  953 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  955 */         this.noti = FValue.trim();
/*      */       }
/*      */       else
/*  958 */         this.noti = null;
/*      */     }
/*  960 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  965 */     if (otherObject == null) return false;
/*  966 */     if (this == otherObject) return true;
/*  967 */     if (getClass() != otherObject.getClass()) return false;
/*  968 */     LNPRiskScreenSchema other = (LNPRiskScreenSchema)otherObject;
/*  969 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/*  970 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/*  971 */     if (this.ctrlIndex != other.getCtrlIndex()) return false;
/*  972 */     if ((this.ctrlType == null) && (other.getCtrlType() != null)) return false;
/*  973 */     if ((this.ctrlType != null) && (!this.ctrlType.equals(other.getCtrlType()))) return false;
/*  974 */     if ((this.ctrlCode == null) && (other.getCtrlCode() != null)) return false;
/*  975 */     if ((this.ctrlCode != null) && (!this.ctrlCode.equals(other.getCtrlCode()))) return false;
/*  976 */     if ((this.ctrlName == null) && (other.getCtrlName() != null)) return false;
/*  977 */     if ((this.ctrlName != null) && (!this.ctrlName.equals(other.getCtrlName()))) return false;
/*  978 */     if ((this.ctrlLevel == null) && (other.getCtrlLevel() != null)) return false;
/*  979 */     if ((this.ctrlLevel != null) && (!this.ctrlLevel.equals(other.getCtrlLevel()))) return false;
/*  980 */     if ((this.ctrlProperty == null) && (other.getCtrlProperty() != null)) return false;
/*  981 */     if ((this.ctrlProperty != null) && (!this.ctrlProperty.equals(other.getCtrlProperty()))) return false;
/*  982 */     if (this.ctrlAlignX != other.getCtrlAlignX()) return false;
/*  983 */     if (this.ctrlAlignY != other.getCtrlAlignY()) return false;
/*  984 */     if (this.ctrlHorizontal != other.getCtrlHorizontal()) return false;
/*  985 */     if (this.ctrlVertical != other.getCtrlVertical()) return false;
/*  986 */     if ((this.ctrlBackground == null) && (other.getCtrlBackground() != null)) return false;
/*  987 */     if ((this.ctrlBackground != null) && (!this.ctrlBackground.equals(other.getCtrlBackground()))) return false;
/*  988 */     if (this.labelAlignX != other.getLabelAlignX()) return false;
/*  989 */     if (this.labelAlignY != other.getLabelAlignY()) return false;
/*  990 */     if (this.labelHorizontal != other.getLabelHorizontal()) return false;
/*  991 */     if (this.labelVertical != other.getLabelVertical()) return false;
/*  992 */     if ((this.labelBackground == null) && (other.getLabelBackground() != null)) return false;
/*  993 */     if ((this.labelBackground != null) && (!this.labelBackground.equals(other.getLabelBackground()))) return false;
/*  994 */     if ((this.defaultValue == null) && (other.getDefaultValue() != null)) return false;
/*  995 */     if ((this.defaultValue != null) && (!this.defaultValue.equals(other.getDefaultValue()))) return false;
/*  996 */     if ((this.defaultSql == null) && (other.getDefaultSql() != null)) return false;
/*  997 */     if ((this.defaultSql != null) && (!this.defaultSql.equals(other.getDefaultSql()))) return false;
/*  998 */     if ((this.ctrlProperty1 == null) && (other.getCtrlProperty1() != null)) return false;
/*  999 */     if ((this.ctrlProperty1 != null) && (!this.ctrlProperty1.equals(other.getCtrlProperty1()))) return false;
/* 1000 */     if ((this.ctrlProperty2 == null) && (other.getCtrlProperty2() != null)) return false;
/* 1001 */     if ((this.ctrlProperty2 != null) && (!this.ctrlProperty2.equals(other.getCtrlProperty2()))) return false;
/* 1002 */     if ((this.noti == null) && (other.getNoti() != null)) return false;
/* 1003 */     return (this.noti == null) || (this.noti.equals(other.getNoti()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1010 */     return 22;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1016 */     if (strFieldName.equals("riskCode")) {
/* 1017 */       return 0;
/*      */     }
/* 1019 */     if (strFieldName.equals("ctrlIndex")) {
/* 1020 */       return 1;
/*      */     }
/* 1022 */     if (strFieldName.equals("ctrlType")) {
/* 1023 */       return 2;
/*      */     }
/* 1025 */     if (strFieldName.equals("ctrlCode")) {
/* 1026 */       return 3;
/*      */     }
/* 1028 */     if (strFieldName.equals("ctrlName")) {
/* 1029 */       return 4;
/*      */     }
/* 1031 */     if (strFieldName.equals("ctrlLevel")) {
/* 1032 */       return 5;
/*      */     }
/* 1034 */     if (strFieldName.equals("ctrlProperty")) {
/* 1035 */       return 6;
/*      */     }
/* 1037 */     if (strFieldName.equals("ctrlAlignX")) {
/* 1038 */       return 7;
/*      */     }
/* 1040 */     if (strFieldName.equals("ctrlAlignY")) {
/* 1041 */       return 8;
/*      */     }
/* 1043 */     if (strFieldName.equals("ctrlHorizontal")) {
/* 1044 */       return 9;
/*      */     }
/* 1046 */     if (strFieldName.equals("ctrlVertical")) {
/* 1047 */       return 10;
/*      */     }
/* 1049 */     if (strFieldName.equals("ctrlBackground")) {
/* 1050 */       return 11;
/*      */     }
/* 1052 */     if (strFieldName.equals("labelAlignX")) {
/* 1053 */       return 12;
/*      */     }
/* 1055 */     if (strFieldName.equals("labelAlignY")) {
/* 1056 */       return 13;
/*      */     }
/* 1058 */     if (strFieldName.equals("labelHorizontal")) {
/* 1059 */       return 14;
/*      */     }
/* 1061 */     if (strFieldName.equals("labelVertical")) {
/* 1062 */       return 15;
/*      */     }
/* 1064 */     if (strFieldName.equals("labelBackground")) {
/* 1065 */       return 16;
/*      */     }
/* 1067 */     if (strFieldName.equals("defaultValue")) {
/* 1068 */       return 17;
/*      */     }
/* 1070 */     if (strFieldName.equals("defaultSql")) {
/* 1071 */       return 18;
/*      */     }
/* 1073 */     if (strFieldName.equals("ctrlProperty1")) {
/* 1074 */       return 19;
/*      */     }
/* 1076 */     if (strFieldName.equals("ctrlProperty2")) {
/* 1077 */       return 20;
/*      */     }
/* 1079 */     if (strFieldName.equals("noti")) {
/* 1080 */       return 21;
/*      */     }
/* 1082 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1088 */     String strFieldName = "";
/* 1089 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1091 */       strFieldName = "riskCode";
/* 1092 */       break;
/*      */     case 1:
/* 1094 */       strFieldName = "ctrlIndex";
/* 1095 */       break;
/*      */     case 2:
/* 1097 */       strFieldName = "ctrlType";
/* 1098 */       break;
/*      */     case 3:
/* 1100 */       strFieldName = "ctrlCode";
/* 1101 */       break;
/*      */     case 4:
/* 1103 */       strFieldName = "ctrlName";
/* 1104 */       break;
/*      */     case 5:
/* 1106 */       strFieldName = "ctrlLevel";
/* 1107 */       break;
/*      */     case 6:
/* 1109 */       strFieldName = "ctrlProperty";
/* 1110 */       break;
/*      */     case 7:
/* 1112 */       strFieldName = "ctrlAlignX";
/* 1113 */       break;
/*      */     case 8:
/* 1115 */       strFieldName = "ctrlAlignY";
/* 1116 */       break;
/*      */     case 9:
/* 1118 */       strFieldName = "ctrlHorizontal";
/* 1119 */       break;
/*      */     case 10:
/* 1121 */       strFieldName = "ctrlVertical";
/* 1122 */       break;
/*      */     case 11:
/* 1124 */       strFieldName = "ctrlBackground";
/* 1125 */       break;
/*      */     case 12:
/* 1127 */       strFieldName = "labelAlignX";
/* 1128 */       break;
/*      */     case 13:
/* 1130 */       strFieldName = "labelAlignY";
/* 1131 */       break;
/*      */     case 14:
/* 1133 */       strFieldName = "labelHorizontal";
/* 1134 */       break;
/*      */     case 15:
/* 1136 */       strFieldName = "labelVertical";
/* 1137 */       break;
/*      */     case 16:
/* 1139 */       strFieldName = "labelBackground";
/* 1140 */       break;
/*      */     case 17:
/* 1142 */       strFieldName = "defaultValue";
/* 1143 */       break;
/*      */     case 18:
/* 1145 */       strFieldName = "defaultSql";
/* 1146 */       break;
/*      */     case 19:
/* 1148 */       strFieldName = "ctrlProperty1";
/* 1149 */       break;
/*      */     case 20:
/* 1151 */       strFieldName = "ctrlProperty2";
/* 1152 */       break;
/*      */     case 21:
/* 1154 */       strFieldName = "noti";
/* 1155 */       break;
/*      */     default:
/* 1157 */       strFieldName = "";
/*      */     }
/* 1159 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1165 */     if (strFieldName.equals("riskCode")) {
/* 1166 */       return 0;
/*      */     }
/* 1168 */     if (strFieldName.equals("ctrlIndex")) {
/* 1169 */       return 3;
/*      */     }
/* 1171 */     if (strFieldName.equals("ctrlType")) {
/* 1172 */       return 0;
/*      */     }
/* 1174 */     if (strFieldName.equals("ctrlCode")) {
/* 1175 */       return 0;
/*      */     }
/* 1177 */     if (strFieldName.equals("ctrlName")) {
/* 1178 */       return 0;
/*      */     }
/* 1180 */     if (strFieldName.equals("ctrlLevel")) {
/* 1181 */       return 0;
/*      */     }
/* 1183 */     if (strFieldName.equals("ctrlProperty")) {
/* 1184 */       return 0;
/*      */     }
/* 1186 */     if (strFieldName.equals("ctrlAlignX")) {
/* 1187 */       return 3;
/*      */     }
/* 1189 */     if (strFieldName.equals("ctrlAlignY")) {
/* 1190 */       return 3;
/*      */     }
/* 1192 */     if (strFieldName.equals("ctrlHorizontal")) {
/* 1193 */       return 3;
/*      */     }
/* 1195 */     if (strFieldName.equals("ctrlVertical")) {
/* 1196 */       return 3;
/*      */     }
/* 1198 */     if (strFieldName.equals("ctrlBackground")) {
/* 1199 */       return 0;
/*      */     }
/* 1201 */     if (strFieldName.equals("labelAlignX")) {
/* 1202 */       return 3;
/*      */     }
/* 1204 */     if (strFieldName.equals("labelAlignY")) {
/* 1205 */       return 3;
/*      */     }
/* 1207 */     if (strFieldName.equals("labelHorizontal")) {
/* 1208 */       return 3;
/*      */     }
/* 1210 */     if (strFieldName.equals("labelVertical")) {
/* 1211 */       return 3;
/*      */     }
/* 1213 */     if (strFieldName.equals("labelBackground")) {
/* 1214 */       return 0;
/*      */     }
/* 1216 */     if (strFieldName.equals("defaultValue")) {
/* 1217 */       return 0;
/*      */     }
/* 1219 */     if (strFieldName.equals("defaultSql")) {
/* 1220 */       return 0;
/*      */     }
/* 1222 */     if (strFieldName.equals("ctrlProperty1")) {
/* 1223 */       return 0;
/*      */     }
/* 1225 */     if (strFieldName.equals("ctrlProperty2")) {
/* 1226 */       return 0;
/*      */     }
/* 1228 */     if (strFieldName.equals("noti")) {
/* 1229 */       return 0;
/*      */     }
/* 1231 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1237 */     int nFieldType = -1;
/* 1238 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1240 */       nFieldType = 0;
/* 1241 */       break;
/*      */     case 1:
/* 1243 */       nFieldType = 3;
/* 1244 */       break;
/*      */     case 2:
/* 1246 */       nFieldType = 0;
/* 1247 */       break;
/*      */     case 3:
/* 1249 */       nFieldType = 0;
/* 1250 */       break;
/*      */     case 4:
/* 1252 */       nFieldType = 0;
/* 1253 */       break;
/*      */     case 5:
/* 1255 */       nFieldType = 0;
/* 1256 */       break;
/*      */     case 6:
/* 1258 */       nFieldType = 0;
/* 1259 */       break;
/*      */     case 7:
/* 1261 */       nFieldType = 3;
/* 1262 */       break;
/*      */     case 8:
/* 1264 */       nFieldType = 3;
/* 1265 */       break;
/*      */     case 9:
/* 1267 */       nFieldType = 3;
/* 1268 */       break;
/*      */     case 10:
/* 1270 */       nFieldType = 3;
/* 1271 */       break;
/*      */     case 11:
/* 1273 */       nFieldType = 0;
/* 1274 */       break;
/*      */     case 12:
/* 1276 */       nFieldType = 3;
/* 1277 */       break;
/*      */     case 13:
/* 1279 */       nFieldType = 3;
/* 1280 */       break;
/*      */     case 14:
/* 1282 */       nFieldType = 3;
/* 1283 */       break;
/*      */     case 15:
/* 1285 */       nFieldType = 3;
/* 1286 */       break;
/*      */     case 16:
/* 1288 */       nFieldType = 0;
/* 1289 */       break;
/*      */     case 17:
/* 1291 */       nFieldType = 0;
/* 1292 */       break;
/*      */     case 18:
/* 1294 */       nFieldType = 0;
/* 1295 */       break;
/*      */     case 19:
/* 1297 */       nFieldType = 0;
/* 1298 */       break;
/*      */     case 20:
/* 1300 */       nFieldType = 0;
/* 1301 */       break;
/*      */     case 21:
/* 1303 */       nFieldType = 0;
/* 1304 */       break;
/*      */     default:
/* 1306 */       nFieldType = -1;
/*      */     }
/* 1308 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskScreenSchema
 * JD-Core Version:    0.6.0
 */