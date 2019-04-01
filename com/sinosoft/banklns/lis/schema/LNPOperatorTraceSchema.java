/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPOperatorTraceDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPOperatorTraceSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String contno;
/*      */   private String operator;
/*      */   private Date operatorDate;
/*      */   private String operatorTime;
/*      */   private String operatorType;
/*      */   private int int1;
/*      */   private int int2;
/*      */   private String varc1;
/*      */   private String varc2;
/*      */   private String varc5;
/*      */   private String varc3;
/*      */   private String varc4;
/*      */   private String varc6;
/*      */   private Date date1;
/*      */   private Date date2;
/*      */   public static final int FIELDNUM = 16;
/*      */   private static String[] PK;
/*   59 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPOperatorTraceSchema()
/*      */   {
/*   66 */     this.mErrors = new CErrors();
/*      */ 
/*   68 */     String[] pk = new String[1];
/*   69 */     pk[0] = "ID";
/*      */ 
/*   71 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   78 */     LNPOperatorTraceSchema cloned = (LNPOperatorTraceSchema)super.clone();
/*   79 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   80 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   81 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   87 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*   92 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*   96 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getContno() {
/*  100 */     return this.contno;
/*      */   }
/*      */ 
/*      */   public void setContno(String aContno) {
/*  104 */     this.contno = aContno;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  108 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  112 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getOperatorDate() {
/*  116 */     if (this.operatorDate != null) {
/*  117 */       return this.fDate.getString(this.operatorDate);
/*      */     }
/*  119 */     return null;
/*      */   }
/*      */ 
/*      */   public void setOperatorDate(Date aOperatorDate) {
/*  123 */     this.operatorDate = aOperatorDate;
/*      */   }
/*      */ 
/*      */   public void setOperatorDate(String aOperatorDate) {
/*  127 */     if ((aOperatorDate != null) && (!aOperatorDate.equals("")))
/*      */     {
/*  129 */       this.operatorDate = this.fDate.getDate(aOperatorDate);
/*      */     }
/*      */     else
/*  132 */       this.operatorDate = null;
/*      */   }
/*      */ 
/*      */   public String getOperatorTime()
/*      */   {
/*  137 */     return this.operatorTime;
/*      */   }
/*      */ 
/*      */   public void setOperatorTime(String aOperatorTime) {
/*  141 */     this.operatorTime = aOperatorTime;
/*      */   }
/*      */ 
/*      */   public String getOperatorType() {
/*  145 */     return this.operatorType;
/*      */   }
/*      */ 
/*      */   public void setOperatorType(String aOperatorType) {
/*  149 */     this.operatorType = aOperatorType;
/*      */   }
/*      */ 
/*      */   public int getInt1() {
/*  153 */     return this.int1;
/*      */   }
/*      */ 
/*      */   public void setInt1(int aInt1) {
/*  157 */     this.int1 = aInt1;
/*      */   }
/*      */ 
/*      */   public void setInt1(String aInt1) {
/*  161 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*      */     {
/*  163 */       Integer tInteger = new Integer(aInt1);
/*  164 */       int i = tInteger.intValue();
/*  165 */       this.int1 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInt2()
/*      */   {
/*  171 */     return this.int2;
/*      */   }
/*      */ 
/*      */   public void setInt2(int aInt2) {
/*  175 */     this.int2 = aInt2;
/*      */   }
/*      */ 
/*      */   public void setInt2(String aInt2) {
/*  179 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*      */     {
/*  181 */       Integer tInteger = new Integer(aInt2);
/*  182 */       int i = tInteger.intValue();
/*  183 */       this.int2 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getVarc1()
/*      */   {
/*  189 */     return this.varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  193 */     this.varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  197 */     return this.varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  201 */     this.varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getVarc5() {
/*  205 */     return this.varc5;
/*      */   }
/*      */ 
/*      */   public void setVarc5(String aVarc5) {
/*  209 */     this.varc5 = aVarc5;
/*      */   }
/*      */ 
/*      */   public String getVarc3() {
/*  213 */     return this.varc3;
/*      */   }
/*      */ 
/*      */   public void setVarc3(String aVarc3) {
/*  217 */     this.varc3 = aVarc3;
/*      */   }
/*      */ 
/*      */   public String getVarc4() {
/*  221 */     return this.varc4;
/*      */   }
/*      */ 
/*      */   public void setVarc4(String aVarc4) {
/*  225 */     this.varc4 = aVarc4;
/*      */   }
/*      */ 
/*      */   public String getVarc6() {
/*  229 */     return this.varc6;
/*      */   }
/*      */ 
/*      */   public void setVarc6(String aVarc6) {
/*  233 */     this.varc6 = aVarc6;
/*      */   }
/*      */ 
/*      */   public String getDate1() {
/*  237 */     if (this.date1 != null) {
/*  238 */       return this.fDate.getString(this.date1);
/*      */     }
/*  240 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate1(Date aDate1) {
/*  244 */     this.date1 = aDate1;
/*      */   }
/*      */ 
/*      */   public void setDate1(String aDate1) {
/*  248 */     if ((aDate1 != null) && (!aDate1.equals("")))
/*      */     {
/*  250 */       this.date1 = this.fDate.getDate(aDate1);
/*      */     }
/*      */     else
/*  253 */       this.date1 = null;
/*      */   }
/*      */ 
/*      */   public String getDate2()
/*      */   {
/*  258 */     if (this.date2 != null) {
/*  259 */       return this.fDate.getString(this.date2);
/*      */     }
/*  261 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate2(Date aDate2) {
/*  265 */     this.date2 = aDate2;
/*      */   }
/*      */ 
/*      */   public void setDate2(String aDate2) {
/*  269 */     if ((aDate2 != null) && (!aDate2.equals("")))
/*      */     {
/*  271 */       this.date2 = this.fDate.getDate(aDate2);
/*      */     }
/*      */     else
/*  274 */       this.date2 = null;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPOperatorTraceSchema aLNPOperatorTraceSchema)
/*      */   {
/*  281 */     this.iD = aLNPOperatorTraceSchema.getID();
/*  282 */     this.contno = aLNPOperatorTraceSchema.getContno();
/*  283 */     this.operator = aLNPOperatorTraceSchema.getOperator();
/*  284 */     this.operatorDate = this.fDate.getDate(aLNPOperatorTraceSchema.getOperatorDate());
/*  285 */     this.operatorTime = aLNPOperatorTraceSchema.getOperatorTime();
/*  286 */     this.operatorType = aLNPOperatorTraceSchema.getOperatorType();
/*  287 */     this.int1 = aLNPOperatorTraceSchema.getInt1();
/*  288 */     this.int2 = aLNPOperatorTraceSchema.getInt2();
/*  289 */     this.varc1 = aLNPOperatorTraceSchema.getVarc1();
/*  290 */     this.varc2 = aLNPOperatorTraceSchema.getVarc2();
/*  291 */     this.varc5 = aLNPOperatorTraceSchema.getVarc5();
/*  292 */     this.varc3 = aLNPOperatorTraceSchema.getVarc3();
/*  293 */     this.varc4 = aLNPOperatorTraceSchema.getVarc4();
/*  294 */     this.varc6 = aLNPOperatorTraceSchema.getVarc6();
/*  295 */     this.date1 = this.fDate.getDate(aLNPOperatorTraceSchema.getDate1());
/*  296 */     this.date2 = this.fDate.getDate(aLNPOperatorTraceSchema.getDate2());
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  305 */       if (rs.getString("ID") == null)
/*  306 */         this.iD = null;
/*      */       else {
/*  308 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  310 */       if (rs.getString("Contno") == null)
/*  311 */         this.contno = null;
/*      */       else {
/*  313 */         this.contno = rs.getString("Contno").trim();
/*      */       }
/*  315 */       if (rs.getString("Operator") == null)
/*  316 */         this.operator = null;
/*      */       else {
/*  318 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  320 */       this.operatorDate = rs.getDate("OperatorDate");
/*  321 */       if (rs.getString("OperatorTime") == null)
/*  322 */         this.operatorTime = null;
/*      */       else {
/*  324 */         this.operatorTime = rs.getString("OperatorTime").trim();
/*      */       }
/*  326 */       if (rs.getString("OperatorType") == null)
/*  327 */         this.operatorType = null;
/*      */       else {
/*  329 */         this.operatorType = rs.getString("OperatorType").trim();
/*      */       }
/*  331 */       this.int1 = rs.getInt("Int1");
/*  332 */       this.int2 = rs.getInt("Int2");
/*  333 */       if (rs.getString("Varc1") == null)
/*  334 */         this.varc1 = null;
/*      */       else {
/*  336 */         this.varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  338 */       if (rs.getString("Varc2") == null)
/*  339 */         this.varc2 = null;
/*      */       else {
/*  341 */         this.varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  343 */       if (rs.getString("Varc5") == null)
/*  344 */         this.varc5 = null;
/*      */       else {
/*  346 */         this.varc5 = rs.getString("Varc5").trim();
/*      */       }
/*  348 */       if (rs.getString("Varc3") == null)
/*  349 */         this.varc3 = null;
/*      */       else {
/*  351 */         this.varc3 = rs.getString("Varc3").trim();
/*      */       }
/*  353 */       if (rs.getString("Varc4") == null)
/*  354 */         this.varc4 = null;
/*      */       else {
/*  356 */         this.varc4 = rs.getString("Varc4").trim();
/*      */       }
/*  358 */       if (rs.getString("Varc6") == null)
/*  359 */         this.varc6 = null;
/*      */       else {
/*  361 */         this.varc6 = rs.getString("Varc6").trim();
/*      */       }
/*  363 */       this.date1 = rs.getDate("Date1");
/*  364 */       this.date2 = rs.getDate("Date2");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  368 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPOperatorTrace\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/*  370 */       CError tError = new CError();
/*  371 */       tError.moduleName = "LNPOperatorTraceSchema";
/*  372 */       tError.functionName = "setSchema";
/*  373 */       tError.errorMessage = sqle.toString();
/*  374 */       this.mErrors.addOneError(tError);
/*  375 */       return false;
/*      */     }
/*  377 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPOperatorTraceSchema getSchema()
/*      */   {
/*  382 */     LNPOperatorTraceSchema aLNPOperatorTraceSchema = new LNPOperatorTraceSchema();
/*  383 */     aLNPOperatorTraceSchema.setSchema(this);
/*  384 */     return aLNPOperatorTraceSchema;
/*      */   }
/*      */ 
/*      */   public LNPOperatorTraceDB getDB()
/*      */   {
/*  389 */     LNPOperatorTraceDB aDBOper = new LNPOperatorTraceDB();
/*  390 */     aDBOper.setSchema(this);
/*  391 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  398 */     StringBuffer strReturn = new StringBuffer(256);
/*  399 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  400 */     strReturn.append(StrTool.cTrim(this.contno)); strReturn.append("|");
/*  401 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  402 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.operatorDate))); strReturn.append("|");
/*  403 */     strReturn.append(StrTool.cTrim(this.operatorTime)); strReturn.append("|");
/*  404 */     strReturn.append(StrTool.cTrim(this.operatorType)); strReturn.append("|");
/*  405 */     strReturn.append(ChgData.chgData(this.int1)); strReturn.append("|");
/*  406 */     strReturn.append(ChgData.chgData(this.int2)); strReturn.append("|");
/*  407 */     strReturn.append(StrTool.cTrim(this.varc1)); strReturn.append("|");
/*  408 */     strReturn.append(StrTool.cTrim(this.varc2)); strReturn.append("|");
/*  409 */     strReturn.append(StrTool.cTrim(this.varc5)); strReturn.append("|");
/*  410 */     strReturn.append(StrTool.cTrim(this.varc3)); strReturn.append("|");
/*  411 */     strReturn.append(StrTool.cTrim(this.varc4)); strReturn.append("|");
/*  412 */     strReturn.append(StrTool.cTrim(this.varc6)); strReturn.append("|");
/*  413 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date1))); strReturn.append("|");
/*  414 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date2)));
/*  415 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  423 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  424 */       this.contno = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  425 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  426 */       this.operatorDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|"));
/*  427 */       this.operatorTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  428 */       this.operatorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  429 */       this.int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).intValue();
/*  430 */       this.int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).intValue();
/*  431 */       this.varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  432 */       this.varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  433 */       this.varc5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  434 */       this.varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  435 */       this.varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  436 */       this.varc6 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  437 */       this.date1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  438 */       this.date2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  443 */       CError tError = new CError();
/*  444 */       tError.moduleName = "LNPOperatorTraceSchema";
/*  445 */       tError.functionName = "decode";
/*  446 */       tError.errorMessage = ex.toString();
/*  447 */       this.mErrors.addOneError(tError);
/*      */ 
/*  449 */       return false;
/*      */     }
/*  451 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  457 */     String strReturn = "";
/*  458 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  460 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  462 */     if (FCode.equalsIgnoreCase("contno"))
/*      */     {
/*  464 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contno));
/*      */     }
/*  466 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  468 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  470 */     if (FCode.equalsIgnoreCase("operatorDate"))
/*      */     {
/*  472 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getOperatorDate()));
/*      */     }
/*  474 */     if (FCode.equalsIgnoreCase("operatorTime"))
/*      */     {
/*  476 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operatorTime));
/*      */     }
/*  478 */     if (FCode.equalsIgnoreCase("operatorType"))
/*      */     {
/*  480 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operatorType));
/*      */     }
/*  482 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  484 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int1));
/*      */     }
/*  486 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  488 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int2));
/*      */     }
/*  490 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  492 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc1));
/*      */     }
/*  494 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  496 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc2));
/*      */     }
/*  498 */     if (FCode.equalsIgnoreCase("varc5"))
/*      */     {
/*  500 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc5));
/*      */     }
/*  502 */     if (FCode.equalsIgnoreCase("varc3"))
/*      */     {
/*  504 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc3));
/*      */     }
/*  506 */     if (FCode.equalsIgnoreCase("varc4"))
/*      */     {
/*  508 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc4));
/*      */     }
/*  510 */     if (FCode.equalsIgnoreCase("varc6"))
/*      */     {
/*  512 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc6));
/*      */     }
/*  514 */     if (FCode.equalsIgnoreCase("date1"))
/*      */     {
/*  516 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate1()));
/*      */     }
/*  518 */     if (FCode.equalsIgnoreCase("date2"))
/*      */     {
/*  520 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate2()));
/*      */     }
/*  522 */     if (strReturn.equals(""))
/*      */     {
/*  524 */       strReturn = "null";
/*      */     }
/*      */ 
/*  527 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  534 */     String strFieldValue = "";
/*  535 */     switch (nFieldIndex) {
/*      */     case 0:
/*  537 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  538 */       break;
/*      */     case 1:
/*  540 */       strFieldValue = StrTool.GBKToUnicode(this.contno);
/*  541 */       break;
/*      */     case 2:
/*  543 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  544 */       break;
/*      */     case 3:
/*  546 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getOperatorDate()));
/*  547 */       break;
/*      */     case 4:
/*  549 */       strFieldValue = StrTool.GBKToUnicode(this.operatorTime);
/*  550 */       break;
/*      */     case 5:
/*  552 */       strFieldValue = StrTool.GBKToUnicode(this.operatorType);
/*  553 */       break;
/*      */     case 6:
/*  555 */       strFieldValue = String.valueOf(this.int1);
/*  556 */       break;
/*      */     case 7:
/*  558 */       strFieldValue = String.valueOf(this.int2);
/*  559 */       break;
/*      */     case 8:
/*  561 */       strFieldValue = StrTool.GBKToUnicode(this.varc1);
/*  562 */       break;
/*      */     case 9:
/*  564 */       strFieldValue = StrTool.GBKToUnicode(this.varc2);
/*  565 */       break;
/*      */     case 10:
/*  567 */       strFieldValue = StrTool.GBKToUnicode(this.varc5);
/*  568 */       break;
/*      */     case 11:
/*  570 */       strFieldValue = StrTool.GBKToUnicode(this.varc3);
/*  571 */       break;
/*      */     case 12:
/*  573 */       strFieldValue = StrTool.GBKToUnicode(this.varc4);
/*  574 */       break;
/*      */     case 13:
/*  576 */       strFieldValue = StrTool.GBKToUnicode(this.varc6);
/*  577 */       break;
/*      */     case 14:
/*  579 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate1()));
/*  580 */       break;
/*      */     case 15:
/*  582 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate2()));
/*  583 */       break;
/*      */     default:
/*  585 */       strFieldValue = "";
/*      */     }
/*  587 */     if (strFieldValue.equals("")) {
/*  588 */       strFieldValue = "null";
/*      */     }
/*  590 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  596 */     if (StrTool.cTrim(FCode).equals("")) {
/*  597 */       return false;
/*      */     }
/*  599 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  601 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  603 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  606 */         this.iD = null;
/*      */     }
/*  608 */     if (FCode.equalsIgnoreCase("contno"))
/*      */     {
/*  610 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  612 */         this.contno = FValue.trim();
/*      */       }
/*      */       else
/*  615 */         this.contno = null;
/*      */     }
/*  617 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  619 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  621 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  624 */         this.operator = null;
/*      */     }
/*  626 */     if (FCode.equalsIgnoreCase("operatorDate"))
/*      */     {
/*  628 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  630 */         this.operatorDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  633 */         this.operatorDate = null;
/*      */     }
/*  635 */     if (FCode.equalsIgnoreCase("operatorTime"))
/*      */     {
/*  637 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  639 */         this.operatorTime = FValue.trim();
/*      */       }
/*      */       else
/*  642 */         this.operatorTime = null;
/*      */     }
/*  644 */     if (FCode.equalsIgnoreCase("operatorType"))
/*      */     {
/*  646 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  648 */         this.operatorType = FValue.trim();
/*      */       }
/*      */       else
/*  651 */         this.operatorType = null;
/*      */     }
/*  653 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  655 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  657 */         Integer tInteger = new Integer(FValue);
/*  658 */         int i = tInteger.intValue();
/*  659 */         this.int1 = i;
/*      */       }
/*      */     }
/*  662 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  664 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  666 */         Integer tInteger = new Integer(FValue);
/*  667 */         int i = tInteger.intValue();
/*  668 */         this.int2 = i;
/*      */       }
/*      */     }
/*  671 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  673 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  675 */         this.varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  678 */         this.varc1 = null;
/*      */     }
/*  680 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  682 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  684 */         this.varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  687 */         this.varc2 = null;
/*      */     }
/*  689 */     if (FCode.equalsIgnoreCase("varc5"))
/*      */     {
/*  691 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  693 */         this.varc5 = FValue.trim();
/*      */       }
/*      */       else
/*  696 */         this.varc5 = null;
/*      */     }
/*  698 */     if (FCode.equalsIgnoreCase("varc3"))
/*      */     {
/*  700 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  702 */         this.varc3 = FValue.trim();
/*      */       }
/*      */       else
/*  705 */         this.varc3 = null;
/*      */     }
/*  707 */     if (FCode.equalsIgnoreCase("varc4"))
/*      */     {
/*  709 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  711 */         this.varc4 = FValue.trim();
/*      */       }
/*      */       else
/*  714 */         this.varc4 = null;
/*      */     }
/*  716 */     if (FCode.equalsIgnoreCase("varc6"))
/*      */     {
/*  718 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  720 */         this.varc6 = FValue.trim();
/*      */       }
/*      */       else
/*  723 */         this.varc6 = null;
/*      */     }
/*  725 */     if (FCode.equalsIgnoreCase("date1"))
/*      */     {
/*  727 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  729 */         this.date1 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  732 */         this.date1 = null;
/*      */     }
/*  734 */     if (FCode.equalsIgnoreCase("date2"))
/*      */     {
/*  736 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  738 */         this.date2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  741 */         this.date2 = null;
/*      */     }
/*  743 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  748 */     if (otherObject == null) return false;
/*  749 */     if (this == otherObject) return true;
/*  750 */     if (getClass() != otherObject.getClass()) return false;
/*  751 */     LNPOperatorTraceSchema other = (LNPOperatorTraceSchema)otherObject;
/*  752 */     if ((this.iD == null) && (other.getID() != null)) return false;
/*  753 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/*  754 */     if ((this.contno == null) && (other.getContno() != null)) return false;
/*  755 */     if ((this.contno != null) && (!this.contno.equals(other.getContno()))) return false;
/*  756 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  757 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  758 */     if ((this.operatorDate == null) && (other.getOperatorDate() != null)) return false;
/*  759 */     if ((this.operatorDate != null) && (!this.fDate.getString(this.operatorDate).equals(other.getOperatorDate()))) return false;
/*  760 */     if ((this.operatorTime == null) && (other.getOperatorTime() != null)) return false;
/*  761 */     if ((this.operatorTime != null) && (!this.operatorTime.equals(other.getOperatorTime()))) return false;
/*  762 */     if ((this.operatorType == null) && (other.getOperatorType() != null)) return false;
/*  763 */     if ((this.operatorType != null) && (!this.operatorType.equals(other.getOperatorType()))) return false;
/*  764 */     if (this.int1 != other.getInt1()) return false;
/*  765 */     if (this.int2 != other.getInt2()) return false;
/*  766 */     if ((this.varc1 == null) && (other.getVarc1() != null)) return false;
/*  767 */     if ((this.varc1 != null) && (!this.varc1.equals(other.getVarc1()))) return false;
/*  768 */     if ((this.varc2 == null) && (other.getVarc2() != null)) return false;
/*  769 */     if ((this.varc2 != null) && (!this.varc2.equals(other.getVarc2()))) return false;
/*  770 */     if ((this.varc5 == null) && (other.getVarc5() != null)) return false;
/*  771 */     if ((this.varc5 != null) && (!this.varc5.equals(other.getVarc5()))) return false;
/*  772 */     if ((this.varc3 == null) && (other.getVarc3() != null)) return false;
/*  773 */     if ((this.varc3 != null) && (!this.varc3.equals(other.getVarc3()))) return false;
/*  774 */     if ((this.varc4 == null) && (other.getVarc4() != null)) return false;
/*  775 */     if ((this.varc4 != null) && (!this.varc4.equals(other.getVarc4()))) return false;
/*  776 */     if ((this.varc6 == null) && (other.getVarc6() != null)) return false;
/*  777 */     if ((this.varc6 != null) && (!this.varc6.equals(other.getVarc6()))) return false;
/*  778 */     if ((this.date1 == null) && (other.getDate1() != null)) return false;
/*  779 */     if ((this.date1 != null) && (!this.fDate.getString(this.date1).equals(other.getDate1()))) return false;
/*  780 */     if ((this.date2 == null) && (other.getDate2() != null)) return false;
/*  781 */     return (this.date2 == null) || (this.fDate.getString(this.date2).equals(other.getDate2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  788 */     return 16;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  794 */     if (strFieldName.equals("iD")) {
/*  795 */       return 0;
/*      */     }
/*  797 */     if (strFieldName.equals("contno")) {
/*  798 */       return 1;
/*      */     }
/*  800 */     if (strFieldName.equals("operator")) {
/*  801 */       return 2;
/*      */     }
/*  803 */     if (strFieldName.equals("operatorDate")) {
/*  804 */       return 3;
/*      */     }
/*  806 */     if (strFieldName.equals("operatorTime")) {
/*  807 */       return 4;
/*      */     }
/*  809 */     if (strFieldName.equals("operatorType")) {
/*  810 */       return 5;
/*      */     }
/*  812 */     if (strFieldName.equals("int1")) {
/*  813 */       return 6;
/*      */     }
/*  815 */     if (strFieldName.equals("int2")) {
/*  816 */       return 7;
/*      */     }
/*  818 */     if (strFieldName.equals("varc1")) {
/*  819 */       return 8;
/*      */     }
/*  821 */     if (strFieldName.equals("varc2")) {
/*  822 */       return 9;
/*      */     }
/*  824 */     if (strFieldName.equals("varc5")) {
/*  825 */       return 10;
/*      */     }
/*  827 */     if (strFieldName.equals("varc3")) {
/*  828 */       return 11;
/*      */     }
/*  830 */     if (strFieldName.equals("varc4")) {
/*  831 */       return 12;
/*      */     }
/*  833 */     if (strFieldName.equals("varc6")) {
/*  834 */       return 13;
/*      */     }
/*  836 */     if (strFieldName.equals("date1")) {
/*  837 */       return 14;
/*      */     }
/*  839 */     if (strFieldName.equals("date2")) {
/*  840 */       return 15;
/*      */     }
/*  842 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  848 */     String strFieldName = "";
/*  849 */     switch (nFieldIndex) {
/*      */     case 0:
/*  851 */       strFieldName = "iD";
/*  852 */       break;
/*      */     case 1:
/*  854 */       strFieldName = "contno";
/*  855 */       break;
/*      */     case 2:
/*  857 */       strFieldName = "operator";
/*  858 */       break;
/*      */     case 3:
/*  860 */       strFieldName = "operatorDate";
/*  861 */       break;
/*      */     case 4:
/*  863 */       strFieldName = "operatorTime";
/*  864 */       break;
/*      */     case 5:
/*  866 */       strFieldName = "operatorType";
/*  867 */       break;
/*      */     case 6:
/*  869 */       strFieldName = "int1";
/*  870 */       break;
/*      */     case 7:
/*  872 */       strFieldName = "int2";
/*  873 */       break;
/*      */     case 8:
/*  875 */       strFieldName = "varc1";
/*  876 */       break;
/*      */     case 9:
/*  878 */       strFieldName = "varc2";
/*  879 */       break;
/*      */     case 10:
/*  881 */       strFieldName = "varc5";
/*  882 */       break;
/*      */     case 11:
/*  884 */       strFieldName = "varc3";
/*  885 */       break;
/*      */     case 12:
/*  887 */       strFieldName = "varc4";
/*  888 */       break;
/*      */     case 13:
/*  890 */       strFieldName = "varc6";
/*  891 */       break;
/*      */     case 14:
/*  893 */       strFieldName = "date1";
/*  894 */       break;
/*      */     case 15:
/*  896 */       strFieldName = "date2";
/*  897 */       break;
/*      */     default:
/*  899 */       strFieldName = "";
/*      */     }
/*  901 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  907 */     if (strFieldName.equals("iD")) {
/*  908 */       return 0;
/*      */     }
/*  910 */     if (strFieldName.equals("contno")) {
/*  911 */       return 0;
/*      */     }
/*  913 */     if (strFieldName.equals("operator")) {
/*  914 */       return 0;
/*      */     }
/*  916 */     if (strFieldName.equals("operatorDate")) {
/*  917 */       return 1;
/*      */     }
/*  919 */     if (strFieldName.equals("operatorTime")) {
/*  920 */       return 0;
/*      */     }
/*  922 */     if (strFieldName.equals("operatorType")) {
/*  923 */       return 0;
/*      */     }
/*  925 */     if (strFieldName.equals("int1")) {
/*  926 */       return 3;
/*      */     }
/*  928 */     if (strFieldName.equals("int2")) {
/*  929 */       return 3;
/*      */     }
/*  931 */     if (strFieldName.equals("varc1")) {
/*  932 */       return 0;
/*      */     }
/*  934 */     if (strFieldName.equals("varc2")) {
/*  935 */       return 0;
/*      */     }
/*  937 */     if (strFieldName.equals("varc5")) {
/*  938 */       return 0;
/*      */     }
/*  940 */     if (strFieldName.equals("varc3")) {
/*  941 */       return 0;
/*      */     }
/*  943 */     if (strFieldName.equals("varc4")) {
/*  944 */       return 0;
/*      */     }
/*  946 */     if (strFieldName.equals("varc6")) {
/*  947 */       return 0;
/*      */     }
/*  949 */     if (strFieldName.equals("date1")) {
/*  950 */       return 1;
/*      */     }
/*  952 */     if (strFieldName.equals("date2")) {
/*  953 */       return 1;
/*      */     }
/*  955 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/*  961 */     int nFieldType = -1;
/*  962 */     switch (nFieldIndex) {
/*      */     case 0:
/*  964 */       nFieldType = 0;
/*  965 */       break;
/*      */     case 1:
/*  967 */       nFieldType = 0;
/*  968 */       break;
/*      */     case 2:
/*  970 */       nFieldType = 0;
/*  971 */       break;
/*      */     case 3:
/*  973 */       nFieldType = 1;
/*  974 */       break;
/*      */     case 4:
/*  976 */       nFieldType = 0;
/*  977 */       break;
/*      */     case 5:
/*  979 */       nFieldType = 0;
/*  980 */       break;
/*      */     case 6:
/*  982 */       nFieldType = 3;
/*  983 */       break;
/*      */     case 7:
/*  985 */       nFieldType = 3;
/*  986 */       break;
/*      */     case 8:
/*  988 */       nFieldType = 0;
/*  989 */       break;
/*      */     case 9:
/*  991 */       nFieldType = 0;
/*  992 */       break;
/*      */     case 10:
/*  994 */       nFieldType = 0;
/*  995 */       break;
/*      */     case 11:
/*  997 */       nFieldType = 0;
/*  998 */       break;
/*      */     case 12:
/* 1000 */       nFieldType = 0;
/* 1001 */       break;
/*      */     case 13:
/* 1003 */       nFieldType = 0;
/* 1004 */       break;
/*      */     case 14:
/* 1006 */       nFieldType = 1;
/* 1007 */       break;
/*      */     case 15:
/* 1009 */       nFieldType = 1;
/* 1010 */       break;
/*      */     default:
/* 1012 */       nFieldType = -1;
/*      */     }
/* 1014 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPOperatorTraceSchema
 * JD-Core Version:    0.6.0
 */