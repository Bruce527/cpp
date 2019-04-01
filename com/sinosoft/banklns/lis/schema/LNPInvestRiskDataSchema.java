/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestRiskDataDB;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class LNPInvestRiskDataSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String dataid;
/*      */   private String signno;
/*      */   private String type;
/*      */   private int serialno;
/*      */   private int age;
/*      */   private int degree;
/*      */   private double value;
/*      */   private int protagonist;
/*      */   private int exponent;
/*      */   private int banlance;
/*      */   private int solidity;
/*      */   private int prevent;
/*      */   private String remark1;
/*      */   private String remark2;
/*      */   private String remark3;
/*      */   private String remark4;
/*      */   public static final int FIELDNUM = 16;
/*      */   private static String[] PK;
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPInvestRiskDataSchema()
/*      */   {
/*   64 */     this.mErrors = new CErrors();
/*      */ 
/*   66 */     String[] pk = new String[1];
/*   67 */     pk[0] = "Dataid";
/*      */ 
/*   69 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   76 */     LNPInvestRiskDataSchema cloned = (LNPInvestRiskDataSchema)super.clone();
/*   77 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   78 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   84 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getDataid()
/*      */   {
/*   89 */     return this.dataid;
/*      */   }
/*      */ 
/*      */   public void setDataid(String aDataid) {
/*   93 */     this.dataid = aDataid;
/*      */   }
/*      */ 
/*      */   public String getSignno() {
/*   97 */     return this.signno;
/*      */   }
/*      */ 
/*      */   public void setSignno(String aSignno) {
/*  101 */     this.signno = aSignno;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  105 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  109 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public int getSerialno() {
/*  113 */     return this.serialno;
/*      */   }
/*      */ 
/*      */   public void setSerialno(int aSerialno) {
/*  117 */     this.serialno = aSerialno;
/*      */   }
/*      */ 
/*      */   public void setSerialno(String aSerialno) {
/*  121 */     if ((aSerialno != null) && (!aSerialno.equals("")))
/*      */     {
/*  123 */       Integer tInteger = new Integer(aSerialno);
/*  124 */       int i = tInteger.intValue();
/*  125 */       this.serialno = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getAge()
/*      */   {
/*  131 */     return this.age;
/*      */   }
/*      */ 
/*      */   public void setAge(int aAge) {
/*  135 */     this.age = aAge;
/*      */   }
/*      */ 
/*      */   public void setAge(String aAge) {
/*  139 */     if ((aAge != null) && (!aAge.equals("")))
/*      */     {
/*  141 */       Integer tInteger = new Integer(aAge);
/*  142 */       int i = tInteger.intValue();
/*  143 */       this.age = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getDegree()
/*      */   {
/*  149 */     return this.degree;
/*      */   }
/*      */ 
/*      */   public void setDegree(int aDegree) {
/*  153 */     this.degree = aDegree;
/*      */   }
/*      */ 
/*      */   public void setDegree(String aDegree) {
/*  157 */     if ((aDegree != null) && (!aDegree.equals("")))
/*      */     {
/*  159 */       Integer tInteger = new Integer(aDegree);
/*  160 */       int i = tInteger.intValue();
/*  161 */       this.degree = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getValue()
/*      */   {
/*  167 */     return this.value;
/*      */   }
/*      */ 
/*      */   public void setValue(double aValue) {
/*  171 */     this.value = aValue;
/*      */   }
/*      */ 
/*      */   public void setValue(String aValue) {
/*  175 */     if ((aValue != null) && (!aValue.equals("")))
/*      */     {
/*  177 */       Double tDouble = new Double(aValue);
/*  178 */       double d = tDouble.doubleValue();
/*  179 */       this.value = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getProtagonist()
/*      */   {
/*  185 */     return this.protagonist;
/*      */   }
/*      */ 
/*      */   public void setProtagonist(int aProtagonist) {
/*  189 */     this.protagonist = aProtagonist;
/*      */   }
/*      */ 
/*      */   public void setProtagonist(String aProtagonist) {
/*  193 */     if ((aProtagonist != null) && (!aProtagonist.equals("")))
/*      */     {
/*  195 */       Integer tInteger = new Integer(aProtagonist);
/*  196 */       int i = tInteger.intValue();
/*  197 */       this.protagonist = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getExponent()
/*      */   {
/*  203 */     return this.exponent;
/*      */   }
/*      */ 
/*      */   public void setExponent(int aExponent) {
/*  207 */     this.exponent = aExponent;
/*      */   }
/*      */ 
/*      */   public void setExponent(String aExponent) {
/*  211 */     if ((aExponent != null) && (!aExponent.equals("")))
/*      */     {
/*  213 */       Integer tInteger = new Integer(aExponent);
/*  214 */       int i = tInteger.intValue();
/*  215 */       this.exponent = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getBanlance()
/*      */   {
/*  221 */     return this.banlance;
/*      */   }
/*      */ 
/*      */   public void setBanlance(int aBanlance) {
/*  225 */     this.banlance = aBanlance;
/*      */   }
/*      */ 
/*      */   public void setBanlance(String aBanlance) {
/*  229 */     if ((aBanlance != null) && (!aBanlance.equals("")))
/*      */     {
/*  231 */       Integer tInteger = new Integer(aBanlance);
/*  232 */       int i = tInteger.intValue();
/*  233 */       this.banlance = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getSolidity()
/*      */   {
/*  239 */     return this.solidity;
/*      */   }
/*      */ 
/*      */   public void setSolidity(int aSolidity) {
/*  243 */     this.solidity = aSolidity;
/*      */   }
/*      */ 
/*      */   public void setSolidity(String aSolidity) {
/*  247 */     if ((aSolidity != null) && (!aSolidity.equals("")))
/*      */     {
/*  249 */       Integer tInteger = new Integer(aSolidity);
/*  250 */       int i = tInteger.intValue();
/*  251 */       this.solidity = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getPrevent()
/*      */   {
/*  257 */     return this.prevent;
/*      */   }
/*      */ 
/*      */   public void setPrevent(int aPrevent) {
/*  261 */     this.prevent = aPrevent;
/*      */   }
/*      */ 
/*      */   public void setPrevent(String aPrevent) {
/*  265 */     if ((aPrevent != null) && (!aPrevent.equals("")))
/*      */     {
/*  267 */       Integer tInteger = new Integer(aPrevent);
/*  268 */       int i = tInteger.intValue();
/*  269 */       this.prevent = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getRemark1()
/*      */   {
/*  275 */     return this.remark1;
/*      */   }
/*      */ 
/*      */   public void setRemark1(String aRemark1) {
/*  279 */     this.remark1 = aRemark1;
/*      */   }
/*      */ 
/*      */   public String getRemark2() {
/*  283 */     return this.remark2;
/*      */   }
/*      */ 
/*      */   public void setRemark2(String aRemark2) {
/*  287 */     this.remark2 = aRemark2;
/*      */   }
/*      */ 
/*      */   public String getRemark3() {
/*  291 */     return this.remark3;
/*      */   }
/*      */ 
/*      */   public void setRemark3(String aRemark3) {
/*  295 */     this.remark3 = aRemark3;
/*      */   }
/*      */ 
/*      */   public String getRemark4() {
/*  299 */     return this.remark4;
/*      */   }
/*      */ 
/*      */   public void setRemark4(String aRemark4) {
/*  303 */     this.remark4 = aRemark4;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPInvestRiskDataSchema aLNPInvestRiskDataSchema)
/*      */   {
/*  309 */     this.dataid = aLNPInvestRiskDataSchema.getDataid();
/*  310 */     this.signno = aLNPInvestRiskDataSchema.getSignno();
/*  311 */     this.type = aLNPInvestRiskDataSchema.getType();
/*  312 */     this.serialno = aLNPInvestRiskDataSchema.getSerialno();
/*  313 */     this.age = aLNPInvestRiskDataSchema.getAge();
/*  314 */     this.degree = aLNPInvestRiskDataSchema.getDegree();
/*  315 */     this.value = aLNPInvestRiskDataSchema.getValue();
/*  316 */     this.protagonist = aLNPInvestRiskDataSchema.getProtagonist();
/*  317 */     this.exponent = aLNPInvestRiskDataSchema.getExponent();
/*  318 */     this.banlance = aLNPInvestRiskDataSchema.getBanlance();
/*  319 */     this.solidity = aLNPInvestRiskDataSchema.getSolidity();
/*  320 */     this.prevent = aLNPInvestRiskDataSchema.getPrevent();
/*  321 */     this.remark1 = aLNPInvestRiskDataSchema.getRemark1();
/*  322 */     this.remark2 = aLNPInvestRiskDataSchema.getRemark2();
/*  323 */     this.remark3 = aLNPInvestRiskDataSchema.getRemark3();
/*  324 */     this.remark4 = aLNPInvestRiskDataSchema.getRemark4();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  333 */       if (rs.getString("Dataid") == null)
/*  334 */         this.dataid = null;
/*      */       else {
/*  336 */         this.dataid = rs.getString("Dataid").trim();
/*      */       }
/*  338 */       if (rs.getString("Signno") == null)
/*  339 */         this.signno = null;
/*      */       else {
/*  341 */         this.signno = rs.getString("Signno").trim();
/*      */       }
/*  343 */       if (rs.getString("Type") == null)
/*  344 */         this.type = null;
/*      */       else {
/*  346 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  348 */       this.serialno = rs.getInt("Serialno");
/*  349 */       this.age = rs.getInt("Age");
/*  350 */       this.degree = rs.getInt("Degree");
/*  351 */       this.value = rs.getDouble("Value");
/*  352 */       this.protagonist = rs.getInt("Protagonist");
/*  353 */       this.exponent = rs.getInt("exponent");
/*  354 */       this.banlance = rs.getInt("banlance");
/*  355 */       this.solidity = rs.getInt("solidity");
/*  356 */       this.prevent = rs.getInt("prevent");
/*  357 */       if (rs.getString("remark1") == null)
/*  358 */         this.remark1 = null;
/*      */       else {
/*  360 */         this.remark1 = rs.getString("remark1").trim();
/*      */       }
/*  362 */       if (rs.getString("remark2") == null)
/*  363 */         this.remark2 = null;
/*      */       else {
/*  365 */         this.remark2 = rs.getString("remark2").trim();
/*      */       }
/*  367 */       if (rs.getString("remark3") == null)
/*  368 */         this.remark3 = null;
/*      */       else {
/*  370 */         this.remark3 = rs.getString("remark3").trim();
/*      */       }
/*  372 */       if (rs.getString("remark4") == null)
/*  373 */         this.remark4 = null;
/*      */       else {
/*  375 */         this.remark4 = rs.getString("remark4").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  380 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPInvestRiskData\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/*  382 */       CError tError = new CError();
/*  383 */       tError.moduleName = "LNPInvestRiskDataSchema";
/*  384 */       tError.functionName = "setSchema";
/*  385 */       tError.errorMessage = sqle.toString();
/*  386 */       this.mErrors.addOneError(tError);
/*  387 */       return false;
/*      */     }
/*  389 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInvestRiskDataSchema getSchema()
/*      */   {
/*  394 */     LNPInvestRiskDataSchema aLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
/*  395 */     aLNPInvestRiskDataSchema.setSchema(this);
/*  396 */     return aLNPInvestRiskDataSchema;
/*      */   }
/*      */ 
/*      */   public LNPInvestRiskDataDB getDB()
/*      */   {
/*  401 */     LNPInvestRiskDataDB aDBOper = new LNPInvestRiskDataDB();
/*  402 */     aDBOper.setSchema(this);
/*  403 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  410 */     StringBuffer strReturn = new StringBuffer(256);
/*  411 */     strReturn.append(StrTool.cTrim(this.dataid)); strReturn.append("|");
/*  412 */     strReturn.append(StrTool.cTrim(this.signno)); strReturn.append("|");
/*  413 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  414 */     strReturn.append(ChgData.chgData(this.serialno)); strReturn.append("|");
/*  415 */     strReturn.append(ChgData.chgData(this.age)); strReturn.append("|");
/*  416 */     strReturn.append(ChgData.chgData(this.degree)); strReturn.append("|");
/*  417 */     strReturn.append(ChgData.chgData(this.value)); strReturn.append("|");
/*  418 */     strReturn.append(ChgData.chgData(this.protagonist)); strReturn.append("|");
/*  419 */     strReturn.append(ChgData.chgData(this.exponent)); strReturn.append("|");
/*  420 */     strReturn.append(ChgData.chgData(this.banlance)); strReturn.append("|");
/*  421 */     strReturn.append(ChgData.chgData(this.solidity)); strReturn.append("|");
/*  422 */     strReturn.append(ChgData.chgData(this.prevent)); strReturn.append("|");
/*  423 */     strReturn.append(StrTool.cTrim(this.remark1)); strReturn.append("|");
/*  424 */     strReturn.append(StrTool.cTrim(this.remark2)); strReturn.append("|");
/*  425 */     strReturn.append(StrTool.cTrim(this.remark3)); strReturn.append("|");
/*  426 */     strReturn.append(StrTool.cTrim(this.remark4));
/*  427 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  435 */       this.dataid = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  436 */       this.signno = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  437 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  438 */       this.serialno = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|"))).intValue();
/*  439 */       this.age = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|"))).intValue();
/*  440 */       this.degree = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/*  441 */       this.value = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).doubleValue();
/*  442 */       this.protagonist = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).intValue();
/*  443 */       this.exponent = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).intValue();
/*  444 */       this.banlance = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/*  445 */       this.solidity = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).intValue();
/*  446 */       this.prevent = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).intValue();
/*  447 */       this.remark1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  448 */       this.remark2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  449 */       this.remark3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  450 */       this.remark4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  455 */       CError tError = new CError();
/*  456 */       tError.moduleName = "LNPInvestRiskDataSchema";
/*  457 */       tError.functionName = "decode";
/*  458 */       tError.errorMessage = ex.toString();
/*  459 */       this.mErrors.addOneError(tError);
/*      */ 
/*  461 */       return false;
/*      */     }
/*  463 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  469 */     String strReturn = "";
/*  470 */     if (FCode.equalsIgnoreCase("dataid"))
/*      */     {
/*  472 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dataid));
/*      */     }
/*  474 */     if (FCode.equalsIgnoreCase("signno"))
/*      */     {
/*  476 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signno));
/*      */     }
/*  478 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  480 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  482 */     if (FCode.equalsIgnoreCase("serialno"))
/*      */     {
/*  484 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialno));
/*      */     }
/*  486 */     if (FCode.equalsIgnoreCase("age"))
/*      */     {
/*  488 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.age));
/*      */     }
/*  490 */     if (FCode.equalsIgnoreCase("degree"))
/*      */     {
/*  492 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.degree));
/*      */     }
/*  494 */     if (FCode.equalsIgnoreCase("value"))
/*      */     {
/*  496 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.value));
/*      */     }
/*  498 */     if (FCode.equalsIgnoreCase("protagonist"))
/*      */     {
/*  500 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.protagonist));
/*      */     }
/*  502 */     if (FCode.equalsIgnoreCase("exponent"))
/*      */     {
/*  504 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.exponent));
/*      */     }
/*  506 */     if (FCode.equalsIgnoreCase("banlance"))
/*      */     {
/*  508 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.banlance));
/*      */     }
/*  510 */     if (FCode.equalsIgnoreCase("solidity"))
/*      */     {
/*  512 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.solidity));
/*      */     }
/*  514 */     if (FCode.equalsIgnoreCase("prevent"))
/*      */     {
/*  516 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.prevent));
/*      */     }
/*  518 */     if (FCode.equalsIgnoreCase("remark1"))
/*      */     {
/*  520 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark1));
/*      */     }
/*  522 */     if (FCode.equalsIgnoreCase("remark2"))
/*      */     {
/*  524 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark2));
/*      */     }
/*  526 */     if (FCode.equalsIgnoreCase("remark3"))
/*      */     {
/*  528 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark3));
/*      */     }
/*  530 */     if (FCode.equalsIgnoreCase("remark4"))
/*      */     {
/*  532 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark4));
/*      */     }
/*  534 */     if (strReturn.equals(""))
/*      */     {
/*  536 */       strReturn = "null";
/*      */     }
/*      */ 
/*  539 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  546 */     String strFieldValue = "";
/*  547 */     switch (nFieldIndex) {
/*      */     case 0:
/*  549 */       strFieldValue = StrTool.GBKToUnicode(this.dataid);
/*  550 */       break;
/*      */     case 1:
/*  552 */       strFieldValue = StrTool.GBKToUnicode(this.signno);
/*  553 */       break;
/*      */     case 2:
/*  555 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  556 */       break;
/*      */     case 3:
/*  558 */       strFieldValue = String.valueOf(this.serialno);
/*  559 */       break;
/*      */     case 4:
/*  561 */       strFieldValue = String.valueOf(this.age);
/*  562 */       break;
/*      */     case 5:
/*  564 */       strFieldValue = String.valueOf(this.degree);
/*  565 */       break;
/*      */     case 6:
/*  567 */       strFieldValue = String.valueOf(this.value);
/*  568 */       break;
/*      */     case 7:
/*  570 */       strFieldValue = String.valueOf(this.protagonist);
/*  571 */       break;
/*      */     case 8:
/*  573 */       strFieldValue = String.valueOf(this.exponent);
/*  574 */       break;
/*      */     case 9:
/*  576 */       strFieldValue = String.valueOf(this.banlance);
/*  577 */       break;
/*      */     case 10:
/*  579 */       strFieldValue = String.valueOf(this.solidity);
/*  580 */       break;
/*      */     case 11:
/*  582 */       strFieldValue = String.valueOf(this.prevent);
/*  583 */       break;
/*      */     case 12:
/*  585 */       strFieldValue = StrTool.GBKToUnicode(this.remark1);
/*  586 */       break;
/*      */     case 13:
/*  588 */       strFieldValue = StrTool.GBKToUnicode(this.remark2);
/*  589 */       break;
/*      */     case 14:
/*  591 */       strFieldValue = StrTool.GBKToUnicode(this.remark3);
/*  592 */       break;
/*      */     case 15:
/*  594 */       strFieldValue = StrTool.GBKToUnicode(this.remark4);
/*  595 */       break;
/*      */     default:
/*  597 */       strFieldValue = "";
/*      */     }
/*  599 */     if (strFieldValue.equals("")) {
/*  600 */       strFieldValue = "null";
/*      */     }
/*  602 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  608 */     if (StrTool.cTrim(FCode).equals("")) {
/*  609 */       return false;
/*      */     }
/*  611 */     if (FCode.equalsIgnoreCase("dataid"))
/*      */     {
/*  613 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  615 */         this.dataid = FValue.trim();
/*      */       }
/*      */       else
/*  618 */         this.dataid = null;
/*      */     }
/*  620 */     if (FCode.equalsIgnoreCase("signno"))
/*      */     {
/*  622 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  624 */         this.signno = FValue.trim();
/*      */       }
/*      */       else
/*  627 */         this.signno = null;
/*      */     }
/*  629 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  631 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  633 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/*  636 */         this.type = null;
/*      */     }
/*  638 */     if (FCode.equalsIgnoreCase("serialno"))
/*      */     {
/*  640 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  642 */         Integer tInteger = new Integer(FValue);
/*  643 */         int i = tInteger.intValue();
/*  644 */         this.serialno = i;
/*      */       }
/*      */     }
/*  647 */     if (FCode.equalsIgnoreCase("age"))
/*      */     {
/*  649 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  651 */         Integer tInteger = new Integer(FValue);
/*  652 */         int i = tInteger.intValue();
/*  653 */         this.age = i;
/*      */       }
/*      */     }
/*  656 */     if (FCode.equalsIgnoreCase("degree"))
/*      */     {
/*  658 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  660 */         Integer tInteger = new Integer(FValue);
/*  661 */         int i = tInteger.intValue();
/*  662 */         this.degree = i;
/*      */       }
/*      */     }
/*  665 */     if (FCode.equalsIgnoreCase("value"))
/*      */     {
/*  667 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  669 */         Double tDouble = new Double(FValue);
/*  670 */         double d = tDouble.doubleValue();
/*  671 */         this.value = d;
/*      */       }
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("protagonist"))
/*      */     {
/*  676 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  678 */         Integer tInteger = new Integer(FValue);
/*  679 */         int i = tInteger.intValue();
/*  680 */         this.protagonist = i;
/*      */       }
/*      */     }
/*  683 */     if (FCode.equalsIgnoreCase("exponent"))
/*      */     {
/*  685 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  687 */         Integer tInteger = new Integer(FValue);
/*  688 */         int i = tInteger.intValue();
/*  689 */         this.exponent = i;
/*      */       }
/*      */     }
/*  692 */     if (FCode.equalsIgnoreCase("banlance"))
/*      */     {
/*  694 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  696 */         Integer tInteger = new Integer(FValue);
/*  697 */         int i = tInteger.intValue();
/*  698 */         this.banlance = i;
/*      */       }
/*      */     }
/*  701 */     if (FCode.equalsIgnoreCase("solidity"))
/*      */     {
/*  703 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  705 */         Integer tInteger = new Integer(FValue);
/*  706 */         int i = tInteger.intValue();
/*  707 */         this.solidity = i;
/*      */       }
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("prevent"))
/*      */     {
/*  712 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  714 */         Integer tInteger = new Integer(FValue);
/*  715 */         int i = tInteger.intValue();
/*  716 */         this.prevent = i;
/*      */       }
/*      */     }
/*  719 */     if (FCode.equalsIgnoreCase("remark1"))
/*      */     {
/*  721 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  723 */         this.remark1 = FValue.trim();
/*      */       }
/*      */       else
/*  726 */         this.remark1 = null;
/*      */     }
/*  728 */     if (FCode.equalsIgnoreCase("remark2"))
/*      */     {
/*  730 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  732 */         this.remark2 = FValue.trim();
/*      */       }
/*      */       else
/*  735 */         this.remark2 = null;
/*      */     }
/*  737 */     if (FCode.equalsIgnoreCase("remark3"))
/*      */     {
/*  739 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  741 */         this.remark3 = FValue.trim();
/*      */       }
/*      */       else
/*  744 */         this.remark3 = null;
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("remark4"))
/*      */     {
/*  748 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  750 */         this.remark4 = FValue.trim();
/*      */       }
/*      */       else
/*  753 */         this.remark4 = null;
/*      */     }
/*  755 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  760 */     if (otherObject == null) return false;
/*  761 */     if (this == otherObject) return true;
/*  762 */     if (getClass() != otherObject.getClass()) return false;
/*  763 */     LNPInvestRiskDataSchema other = (LNPInvestRiskDataSchema)otherObject;
/*  764 */     if ((this.dataid == null) && (other.getDataid() != null)) return false;
/*  765 */     if ((this.dataid != null) && (!this.dataid.equals(other.getDataid()))) return false;
/*  766 */     if ((this.signno == null) && (other.getSignno() != null)) return false;
/*  767 */     if ((this.signno != null) && (!this.signno.equals(other.getSignno()))) return false;
/*  768 */     if ((this.type == null) && (other.getType() != null)) return false;
/*  769 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/*  770 */     if (this.serialno != other.getSerialno()) return false;
/*  771 */     if (this.age != other.getAge()) return false;
/*  772 */     if (this.degree != other.getDegree()) return false;
/*  773 */     if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.getValue())) return false;
/*  774 */     if (this.protagonist != other.getProtagonist()) return false;
/*  775 */     if (this.exponent != other.getExponent()) return false;
/*  776 */     if (this.banlance != other.getBanlance()) return false;
/*  777 */     if (this.solidity != other.getSolidity()) return false;
/*  778 */     if (this.prevent != other.getPrevent()) return false;
/*  779 */     if ((this.remark1 == null) && (other.getRemark1() != null)) return false;
/*  780 */     if ((this.remark1 != null) && (!this.remark1.equals(other.getRemark1()))) return false;
/*  781 */     if ((this.remark2 == null) && (other.getRemark2() != null)) return false;
/*  782 */     if ((this.remark2 != null) && (!this.remark2.equals(other.getRemark2()))) return false;
/*  783 */     if ((this.remark3 == null) && (other.getRemark3() != null)) return false;
/*  784 */     if ((this.remark3 != null) && (!this.remark3.equals(other.getRemark3()))) return false;
/*  785 */     if ((this.remark4 == null) && (other.getRemark4() != null)) return false;
/*  786 */     return (this.remark4 == null) || (this.remark4.equals(other.getRemark4()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  793 */     return 16;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  799 */     if (strFieldName.equals("dataid")) {
/*  800 */       return 0;
/*      */     }
/*  802 */     if (strFieldName.equals("signno")) {
/*  803 */       return 1;
/*      */     }
/*  805 */     if (strFieldName.equals("type")) {
/*  806 */       return 2;
/*      */     }
/*  808 */     if (strFieldName.equals("serialno")) {
/*  809 */       return 3;
/*      */     }
/*  811 */     if (strFieldName.equals("age")) {
/*  812 */       return 4;
/*      */     }
/*  814 */     if (strFieldName.equals("degree")) {
/*  815 */       return 5;
/*      */     }
/*  817 */     if (strFieldName.equals("value")) {
/*  818 */       return 6;
/*      */     }
/*  820 */     if (strFieldName.equals("protagonist")) {
/*  821 */       return 7;
/*      */     }
/*  823 */     if (strFieldName.equals("exponent")) {
/*  824 */       return 8;
/*      */     }
/*  826 */     if (strFieldName.equals("banlance")) {
/*  827 */       return 9;
/*      */     }
/*  829 */     if (strFieldName.equals("solidity")) {
/*  830 */       return 10;
/*      */     }
/*  832 */     if (strFieldName.equals("prevent")) {
/*  833 */       return 11;
/*      */     }
/*  835 */     if (strFieldName.equals("remark1")) {
/*  836 */       return 12;
/*      */     }
/*  838 */     if (strFieldName.equals("remark2")) {
/*  839 */       return 13;
/*      */     }
/*  841 */     if (strFieldName.equals("remark3")) {
/*  842 */       return 14;
/*      */     }
/*  844 */     if (strFieldName.equals("remark4")) {
/*  845 */       return 15;
/*      */     }
/*  847 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  853 */     String strFieldName = "";
/*  854 */     switch (nFieldIndex) {
/*      */     case 0:
/*  856 */       strFieldName = "dataid";
/*  857 */       break;
/*      */     case 1:
/*  859 */       strFieldName = "signno";
/*  860 */       break;
/*      */     case 2:
/*  862 */       strFieldName = "type";
/*  863 */       break;
/*      */     case 3:
/*  865 */       strFieldName = "serialno";
/*  866 */       break;
/*      */     case 4:
/*  868 */       strFieldName = "age";
/*  869 */       break;
/*      */     case 5:
/*  871 */       strFieldName = "degree";
/*  872 */       break;
/*      */     case 6:
/*  874 */       strFieldName = "value";
/*  875 */       break;
/*      */     case 7:
/*  877 */       strFieldName = "protagonist";
/*  878 */       break;
/*      */     case 8:
/*  880 */       strFieldName = "exponent";
/*  881 */       break;
/*      */     case 9:
/*  883 */       strFieldName = "banlance";
/*  884 */       break;
/*      */     case 10:
/*  886 */       strFieldName = "solidity";
/*  887 */       break;
/*      */     case 11:
/*  889 */       strFieldName = "prevent";
/*  890 */       break;
/*      */     case 12:
/*  892 */       strFieldName = "remark1";
/*  893 */       break;
/*      */     case 13:
/*  895 */       strFieldName = "remark2";
/*  896 */       break;
/*      */     case 14:
/*  898 */       strFieldName = "remark3";
/*  899 */       break;
/*      */     case 15:
/*  901 */       strFieldName = "remark4";
/*  902 */       break;
/*      */     default:
/*  904 */       strFieldName = "";
/*      */     }
/*  906 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  912 */     if (strFieldName.equals("dataid")) {
/*  913 */       return 0;
/*      */     }
/*  915 */     if (strFieldName.equals("signno")) {
/*  916 */       return 0;
/*      */     }
/*  918 */     if (strFieldName.equals("type")) {
/*  919 */       return 0;
/*      */     }
/*  921 */     if (strFieldName.equals("serialno")) {
/*  922 */       return 3;
/*      */     }
/*  924 */     if (strFieldName.equals("age")) {
/*  925 */       return 3;
/*      */     }
/*  927 */     if (strFieldName.equals("degree")) {
/*  928 */       return 3;
/*      */     }
/*  930 */     if (strFieldName.equals("value")) {
/*  931 */       return 4;
/*      */     }
/*  933 */     if (strFieldName.equals("protagonist")) {
/*  934 */       return 3;
/*      */     }
/*  936 */     if (strFieldName.equals("exponent")) {
/*  937 */       return 3;
/*      */     }
/*  939 */     if (strFieldName.equals("banlance")) {
/*  940 */       return 3;
/*      */     }
/*  942 */     if (strFieldName.equals("solidity")) {
/*  943 */       return 3;
/*      */     }
/*  945 */     if (strFieldName.equals("prevent")) {
/*  946 */       return 3;
/*      */     }
/*  948 */     if (strFieldName.equals("remark1")) {
/*  949 */       return 0;
/*      */     }
/*  951 */     if (strFieldName.equals("remark2")) {
/*  952 */       return 0;
/*      */     }
/*  954 */     if (strFieldName.equals("remark3")) {
/*  955 */       return 0;
/*      */     }
/*  957 */     if (strFieldName.equals("remark4")) {
/*  958 */       return 0;
/*      */     }
/*  960 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/*  966 */     int nFieldType = -1;
/*  967 */     switch (nFieldIndex) {
/*      */     case 0:
/*  969 */       nFieldType = 0;
/*  970 */       break;
/*      */     case 1:
/*  972 */       nFieldType = 0;
/*  973 */       break;
/*      */     case 2:
/*  975 */       nFieldType = 0;
/*  976 */       break;
/*      */     case 3:
/*  978 */       nFieldType = 3;
/*  979 */       break;
/*      */     case 4:
/*  981 */       nFieldType = 3;
/*  982 */       break;
/*      */     case 5:
/*  984 */       nFieldType = 3;
/*  985 */       break;
/*      */     case 6:
/*  987 */       nFieldType = 4;
/*  988 */       break;
/*      */     case 7:
/*  990 */       nFieldType = 3;
/*  991 */       break;
/*      */     case 8:
/*  993 */       nFieldType = 3;
/*  994 */       break;
/*      */     case 9:
/*  996 */       nFieldType = 3;
/*  997 */       break;
/*      */     case 10:
/*  999 */       nFieldType = 3;
/* 1000 */       break;
/*      */     case 11:
/* 1002 */       nFieldType = 3;
/* 1003 */       break;
/*      */     case 12:
/* 1005 */       nFieldType = 0;
/* 1006 */       break;
/*      */     case 13:
/* 1008 */       nFieldType = 0;
/* 1009 */       break;
/*      */     case 14:
/* 1011 */       nFieldType = 0;
/* 1012 */       break;
/*      */     case 15:
/* 1014 */       nFieldType = 0;
/* 1015 */       break;
/*      */     default:
/* 1017 */       nFieldType = -1;
/*      */     }
/* 1019 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPInvestRiskDataSchema
 * JD-Core Version:    0.6.0
 */