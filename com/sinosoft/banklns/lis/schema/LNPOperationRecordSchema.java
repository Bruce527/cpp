/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPOperationRecordDB;
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
/*      */ public class LNPOperationRecordSchema
/*      */   implements Schema
/*      */ {
/*      */   private String ID;
/*      */   private String ContNo;
/*      */   private String OperatorCode;
/*      */   private String OperatorName;
/*      */   private String OperatorType;
/*      */   private String OperationDate;
/*      */   private String OperationTime;
/*      */   private String Operation;
/*      */   private int Int1;
/*      */   private int Int2;
/*      */   private String Varc1;
/*      */   private String Varc2;
/*      */   private String Varc3;
/*      */   private String Varc4;
/*      */   private Date Date1;
/*      */   private Date Date2;
/*      */   public static final int FIELDNUM = 16;
/*      */   private static String[] PK;
/*   57 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPOperationRecordSchema()
/*      */   {
/*   64 */     this.mErrors = new CErrors();
/*      */ 
/*   66 */     String[] pk = new String[1];
/*   67 */     pk[0] = "ID";
/*      */ 
/*   69 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   75 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*   80 */     if (this.ID != null) this.ID.equals("");
/*      */ 
/*   84 */     return this.ID;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*   88 */     this.ID = aID;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*   92 */     if (this.ContNo != null) this.ContNo.equals("");
/*      */ 
/*   96 */     return this.ContNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  100 */     this.ContNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getOperatorCode() {
/*  104 */     if (this.OperatorCode != null) this.OperatorCode.equals("");
/*      */ 
/*  108 */     return this.OperatorCode;
/*      */   }
/*      */ 
/*      */   public void setOperatorCode(String aOperatorCode) {
/*  112 */     this.OperatorCode = aOperatorCode;
/*      */   }
/*      */ 
/*      */   public String getOperatorName() {
/*  116 */     if (this.OperatorName != null) this.OperatorName.equals("");
/*      */ 
/*  120 */     return this.OperatorName;
/*      */   }
/*      */ 
/*      */   public void setOperatorName(String aOperatorName) {
/*  124 */     this.OperatorName = aOperatorName;
/*      */   }
/*      */ 
/*      */   public String getOperatorType() {
/*  128 */     if (this.OperatorType != null) this.OperatorType.equals("");
/*      */ 
/*  132 */     return this.OperatorType;
/*      */   }
/*      */ 
/*      */   public void setOperatorType(String aOperatorType) {
/*  136 */     this.OperatorType = aOperatorType;
/*      */   }
/*      */ 
/*      */   public String getOperationDate() {
/*  140 */     if (this.OperationDate != null) this.OperationDate.equals("");
/*      */ 
/*  144 */     return this.OperationDate;
/*      */   }
/*      */ 
/*      */   public void setOperationDate(String aOperationDate) {
/*  148 */     this.OperationDate = aOperationDate;
/*      */   }
/*      */ 
/*      */   public String getOperationTime() {
/*  152 */     if (this.OperationTime != null) this.OperationTime.equals("");
/*      */ 
/*  156 */     return this.OperationTime;
/*      */   }
/*      */ 
/*      */   public void setOperationTime(String aOperationTime) {
/*  160 */     this.OperationTime = aOperationTime;
/*      */   }
/*      */ 
/*      */   public String getOperation() {
/*  164 */     if (this.Operation != null) this.Operation.equals("");
/*      */ 
/*  168 */     return this.Operation;
/*      */   }
/*      */ 
/*      */   public void setOperation(String aOperation) {
/*  172 */     this.Operation = aOperation;
/*      */   }
/*      */ 
/*      */   public int getInt1() {
/*  176 */     return this.Int1;
/*      */   }
/*      */ 
/*      */   public void setInt1(int aInt1) {
/*  180 */     this.Int1 = aInt1;
/*      */   }
/*      */ 
/*      */   public void setInt1(String aInt1) {
/*  184 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*      */     {
/*  186 */       Integer tInteger = new Integer(aInt1);
/*  187 */       int i = tInteger.intValue();
/*  188 */       this.Int1 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInt2()
/*      */   {
/*  194 */     return this.Int2;
/*      */   }
/*      */ 
/*      */   public void setInt2(int aInt2) {
/*  198 */     this.Int2 = aInt2;
/*      */   }
/*      */ 
/*      */   public void setInt2(String aInt2) {
/*  202 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*      */     {
/*  204 */       Integer tInteger = new Integer(aInt2);
/*  205 */       int i = tInteger.intValue();
/*  206 */       this.Int2 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getVarc1()
/*      */   {
/*  212 */     if (this.Varc1 != null) this.Varc1.equals("");
/*      */ 
/*  216 */     return this.Varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  220 */     this.Varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  224 */     if (this.Varc2 != null) this.Varc2.equals("");
/*      */ 
/*  228 */     return this.Varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  232 */     this.Varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getVarc3() {
/*  236 */     if (this.Varc3 != null) this.Varc3.equals("");
/*      */ 
/*  240 */     return this.Varc3;
/*      */   }
/*      */ 
/*      */   public void setVarc3(String aVarc3) {
/*  244 */     this.Varc3 = aVarc3;
/*      */   }
/*      */ 
/*      */   public String getVarc4() {
/*  248 */     if (this.Varc4 != null) this.Varc4.equals("");
/*      */ 
/*  252 */     return this.Varc4;
/*      */   }
/*      */ 
/*      */   public void setVarc4(String aVarc4) {
/*  256 */     this.Varc4 = aVarc4;
/*      */   }
/*      */ 
/*      */   public String getDate1() {
/*  260 */     if (this.Date1 != null) {
/*  261 */       return this.fDate.getString(this.Date1);
/*      */     }
/*  263 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate1(Date aDate1) {
/*  267 */     this.Date1 = aDate1;
/*      */   }
/*      */ 
/*      */   public void setDate1(String aDate1) {
/*  271 */     if ((aDate1 != null) && (!aDate1.equals("")))
/*      */     {
/*  273 */       this.Date1 = this.fDate.getDate(aDate1);
/*      */     }
/*      */     else
/*  276 */       this.Date1 = null;
/*      */   }
/*      */ 
/*      */   public String getDate2()
/*      */   {
/*  281 */     if (this.Date2 != null) {
/*  282 */       return this.fDate.getString(this.Date2);
/*      */     }
/*  284 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate2(Date aDate2) {
/*  288 */     this.Date2 = aDate2;
/*      */   }
/*      */ 
/*      */   public void setDate2(String aDate2) {
/*  292 */     if ((aDate2 != null) && (!aDate2.equals("")))
/*      */     {
/*  294 */       this.Date2 = this.fDate.getDate(aDate2);
/*      */     }
/*      */     else
/*  297 */       this.Date2 = null;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPOperationRecordSchema aLNPOperationRecordSchema)
/*      */   {
/*  304 */     this.ID = aLNPOperationRecordSchema.getID();
/*  305 */     this.ContNo = aLNPOperationRecordSchema.getContNo();
/*  306 */     this.OperatorCode = aLNPOperationRecordSchema.getOperatorCode();
/*  307 */     this.OperatorName = aLNPOperationRecordSchema.getOperatorName();
/*  308 */     this.OperatorType = aLNPOperationRecordSchema.getOperatorType();
/*  309 */     this.OperationDate = aLNPOperationRecordSchema.getOperationDate();
/*  310 */     this.OperationTime = aLNPOperationRecordSchema.getOperationTime();
/*  311 */     this.Operation = aLNPOperationRecordSchema.getOperation();
/*  312 */     this.Int1 = aLNPOperationRecordSchema.getInt1();
/*  313 */     this.Int2 = aLNPOperationRecordSchema.getInt2();
/*  314 */     this.Varc1 = aLNPOperationRecordSchema.getVarc1();
/*  315 */     this.Varc2 = aLNPOperationRecordSchema.getVarc2();
/*  316 */     this.Varc3 = aLNPOperationRecordSchema.getVarc3();
/*  317 */     this.Varc4 = aLNPOperationRecordSchema.getVarc4();
/*  318 */     this.Date1 = this.fDate.getDate(aLNPOperationRecordSchema.getDate1());
/*  319 */     this.Date2 = this.fDate.getDate(aLNPOperationRecordSchema.getDate2());
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  328 */       if (rs.getString("ID") == null)
/*  329 */         this.ID = null;
/*      */       else {
/*  331 */         this.ID = rs.getString("ID").trim();
/*      */       }
/*  333 */       if (rs.getString("ContNo") == null)
/*  334 */         this.ContNo = null;
/*      */       else {
/*  336 */         this.ContNo = rs.getString("ContNo").trim();
/*      */       }
/*  338 */       if (rs.getString("OperatorCode") == null)
/*  339 */         this.OperatorCode = null;
/*      */       else {
/*  341 */         this.OperatorCode = rs.getString("OperatorCode").trim();
/*      */       }
/*  343 */       if (rs.getString("OperatorName") == null)
/*  344 */         this.OperatorName = null;
/*      */       else {
/*  346 */         this.OperatorName = rs.getString("OperatorName").trim();
/*      */       }
/*  348 */       if (rs.getString("OperatorType") == null)
/*  349 */         this.OperatorType = null;
/*      */       else {
/*  351 */         this.OperatorType = rs.getString("OperatorType").trim();
/*      */       }
/*  353 */       if (rs.getString("OperationDate") == null)
/*  354 */         this.OperationDate = null;
/*      */       else {
/*  356 */         this.OperationDate = rs.getString("OperationDate").trim();
/*      */       }
/*  358 */       if (rs.getString("OperationTime") == null)
/*  359 */         this.OperationTime = null;
/*      */       else {
/*  361 */         this.OperationTime = rs.getString("OperationTime").trim();
/*      */       }
/*  363 */       if (rs.getString("Operation") == null)
/*  364 */         this.Operation = null;
/*      */       else {
/*  366 */         this.Operation = rs.getString("Operation").trim();
/*      */       }
/*  368 */       this.Int1 = rs.getInt("Int1");
/*  369 */       this.Int2 = rs.getInt("Int2");
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
/*  390 */       this.Date1 = rs.getDate("Date1");
/*  391 */       this.Date2 = rs.getDate("Date2");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  396 */       CError tError = new CError();
/*  397 */       tError.moduleName = "LNPOperationRecordSchema";
/*  398 */       tError.functionName = "setSchema";
/*  399 */       tError.errorMessage = sqle.toString();
/*  400 */       this.mErrors.addOneError(tError);
/*      */ 
/*  402 */       return false;
/*      */     }
/*  404 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPOperationRecordSchema getSchema()
/*      */   {
/*  409 */     LNPOperationRecordSchema aLNPOperationRecordSchema = new LNPOperationRecordSchema();
/*  410 */     aLNPOperationRecordSchema.setSchema(this);
/*  411 */     return aLNPOperationRecordSchema;
/*      */   }
/*      */ 
/*      */   public LNPOperationRecordDB getDB()
/*      */   {
/*  416 */     LNPOperationRecordDB aDBOper = new LNPOperationRecordDB();
/*  417 */     aDBOper.setSchema(this);
/*  418 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  425 */     String strReturn = "";
/*  426 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.ID)) + "|" + 
/*  427 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ContNo)) + "|" + 
/*  428 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OperatorCode)) + "|" + 
/*  429 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OperatorName)) + "|" + 
/*  430 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OperatorType)) + "|" + 
/*  431 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OperationDate)) + "|" + 
/*  432 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OperationTime)) + "|" + 
/*  433 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Operation)) + "|" + 
/*  434 */       ChgData.chgData(this.Int1) + "|" + 
/*  435 */       ChgData.chgData(this.Int2) + "|" + 
/*  436 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc1)) + "|" + 
/*  437 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc2)) + "|" + 
/*  438 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc3)) + "|" + 
/*  439 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc4)) + "|" + 
/*  440 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.Date1))) + "|" + 
/*  441 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.Date2)));
/*  442 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  450 */       this.ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  451 */       this.ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  452 */       this.OperatorCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  453 */       this.OperatorName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  454 */       this.OperatorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  455 */       this.OperationDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  456 */       this.OperationTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  457 */       this.Operation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  458 */       this.Int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).intValue();
/*  459 */       this.Int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/*  460 */       this.Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  461 */       this.Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  462 */       this.Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  463 */       this.Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  464 */       this.Date1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  465 */       this.Date2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  470 */       CError tError = new CError();
/*  471 */       tError.moduleName = "LNPOperationRecordSchema";
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
/*  485 */     if (FCode.equals("ID"))
/*      */     {
/*  487 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ID));
/*      */     }
/*  489 */     if (FCode.equals("ContNo"))
/*      */     {
/*  491 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ContNo));
/*      */     }
/*  493 */     if (FCode.equals("OperatorCode"))
/*      */     {
/*  495 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OperatorCode));
/*      */     }
/*  497 */     if (FCode.equals("OperatorName"))
/*      */     {
/*  499 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OperatorName));
/*      */     }
/*  501 */     if (FCode.equals("OperatorType"))
/*      */     {
/*  503 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OperatorType));
/*      */     }
/*  505 */     if (FCode.equals("OperationDate"))
/*      */     {
/*  507 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OperationDate));
/*      */     }
/*  509 */     if (FCode.equals("OperationTime"))
/*      */     {
/*  511 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OperationTime));
/*      */     }
/*  513 */     if (FCode.equals("Operation"))
/*      */     {
/*  515 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Operation));
/*      */     }
/*  517 */     if (FCode.equals("Int1"))
/*      */     {
/*  519 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Int1));
/*      */     }
/*  521 */     if (FCode.equals("Int2"))
/*      */     {
/*  523 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Int2));
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
/*  541 */     if (FCode.equals("Date1"))
/*      */     {
/*  543 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate1()));
/*      */     }
/*  545 */     if (FCode.equals("Date2"))
/*      */     {
/*  547 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate2()));
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
/*  564 */       strFieldValue = StrTool.GBKToUnicode(this.ID);
/*  565 */       break;
/*      */     case 1:
/*  567 */       strFieldValue = StrTool.GBKToUnicode(this.ContNo);
/*  568 */       break;
/*      */     case 2:
/*  570 */       strFieldValue = StrTool.GBKToUnicode(this.OperatorCode);
/*  571 */       break;
/*      */     case 3:
/*  573 */       strFieldValue = StrTool.GBKToUnicode(this.OperatorName);
/*  574 */       break;
/*      */     case 4:
/*  576 */       strFieldValue = StrTool.GBKToUnicode(this.OperatorType);
/*  577 */       break;
/*      */     case 5:
/*  579 */       strFieldValue = StrTool.GBKToUnicode(this.OperationDate);
/*  580 */       break;
/*      */     case 6:
/*  582 */       strFieldValue = StrTool.GBKToUnicode(this.OperationTime);
/*  583 */       break;
/*      */     case 7:
/*  585 */       strFieldValue = StrTool.GBKToUnicode(this.Operation);
/*  586 */       break;
/*      */     case 8:
/*  588 */       strFieldValue = String.valueOf(this.Int1);
/*  589 */       break;
/*      */     case 9:
/*  591 */       strFieldValue = String.valueOf(this.Int2);
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
/*  606 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate1()));
/*  607 */       break;
/*      */     case 15:
/*  609 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate2()));
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
/*  626 */     if (FCode.equals("ID"))
/*      */     {
/*  628 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  630 */         this.ID = FValue.trim();
/*      */       }
/*      */       else
/*  633 */         this.ID = null;
/*      */     }
/*  635 */     if (FCode.equals("ContNo"))
/*      */     {
/*  637 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  639 */         this.ContNo = FValue.trim();
/*      */       }
/*      */       else
/*  642 */         this.ContNo = null;
/*      */     }
/*  644 */     if (FCode.equals("OperatorCode"))
/*      */     {
/*  646 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  648 */         this.OperatorCode = FValue.trim();
/*      */       }
/*      */       else
/*  651 */         this.OperatorCode = null;
/*      */     }
/*  653 */     if (FCode.equals("OperatorName"))
/*      */     {
/*  655 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  657 */         this.OperatorName = FValue.trim();
/*      */       }
/*      */       else
/*  660 */         this.OperatorName = null;
/*      */     }
/*  662 */     if (FCode.equals("OperatorType"))
/*      */     {
/*  664 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  666 */         this.OperatorType = FValue.trim();
/*      */       }
/*      */       else
/*  669 */         this.OperatorType = null;
/*      */     }
/*  671 */     if (FCode.equals("OperationDate"))
/*      */     {
/*  673 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  675 */         this.OperationDate = FValue.trim();
/*      */       }
/*      */       else
/*  678 */         this.OperationDate = null;
/*      */     }
/*  680 */     if (FCode.equals("OperationTime"))
/*      */     {
/*  682 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  684 */         this.OperationTime = FValue.trim();
/*      */       }
/*      */       else
/*  687 */         this.OperationTime = null;
/*      */     }
/*  689 */     if (FCode.equals("Operation"))
/*      */     {
/*  691 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  693 */         this.Operation = FValue.trim();
/*      */       }
/*      */       else
/*  696 */         this.Operation = null;
/*      */     }
/*  698 */     if (FCode.equals("Int1"))
/*      */     {
/*  700 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  702 */         Integer tInteger = new Integer(FValue);
/*  703 */         int i = tInteger.intValue();
/*  704 */         this.Int1 = i;
/*      */       }
/*      */     }
/*  707 */     if (FCode.equals("Int2"))
/*      */     {
/*  709 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  711 */         Integer tInteger = new Integer(FValue);
/*  712 */         int i = tInteger.intValue();
/*  713 */         this.Int2 = i;
/*      */       }
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
/*  752 */     if (FCode.equals("Date1"))
/*      */     {
/*  754 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  756 */         this.Date1 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  759 */         this.Date1 = null;
/*      */     }
/*  761 */     if (FCode.equals("Date2"))
/*      */     {
/*  763 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  765 */         this.Date2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  768 */         this.Date2 = null;
/*      */     }
/*  770 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  775 */     if (this == otherObject) return true;
/*  776 */     if (otherObject == null) return false;
/*  777 */     if (getClass() != otherObject.getClass()) return false;
/*  778 */     LNPOperationRecordSchema other = (LNPOperationRecordSchema)otherObject;
/*  779 */     return 
/*  780 */       (this.ID.equals(other.getID())) && 
/*  781 */       (this.ContNo.equals(other.getContNo())) && 
/*  782 */       (this.OperatorCode.equals(other.getOperatorCode())) && 
/*  783 */       (this.OperatorName.equals(other.getOperatorName())) && 
/*  784 */       (this.OperatorType.equals(other.getOperatorType())) && 
/*  785 */       (this.OperationDate.equals(other.getOperationDate())) && 
/*  786 */       (this.OperationTime.equals(other.getOperationTime())) && 
/*  787 */       (this.Operation.equals(other.getOperation())) && 
/*  788 */       (this.Int1 == other.getInt1()) && 
/*  789 */       (this.Int2 == other.getInt2()) && 
/*  790 */       (this.Varc1.equals(other.getVarc1())) && 
/*  791 */       (this.Varc2.equals(other.getVarc2())) && 
/*  792 */       (this.Varc3.equals(other.getVarc3())) && 
/*  793 */       (this.Varc4.equals(other.getVarc4())) && 
/*  794 */       (this.fDate.getString(this.Date1).equals(other.getDate1())) && 
/*  795 */       (this.fDate.getString(this.Date2).equals(other.getDate2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  801 */     return 16;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  807 */     if (strFieldName.equals("ID")) {
/*  808 */       return 0;
/*      */     }
/*  810 */     if (strFieldName.equals("ContNo")) {
/*  811 */       return 1;
/*      */     }
/*  813 */     if (strFieldName.equals("OperatorCode")) {
/*  814 */       return 2;
/*      */     }
/*  816 */     if (strFieldName.equals("OperatorName")) {
/*  817 */       return 3;
/*      */     }
/*  819 */     if (strFieldName.equals("OperatorType")) {
/*  820 */       return 4;
/*      */     }
/*  822 */     if (strFieldName.equals("OperationDate")) {
/*  823 */       return 5;
/*      */     }
/*  825 */     if (strFieldName.equals("OperationTime")) {
/*  826 */       return 6;
/*      */     }
/*  828 */     if (strFieldName.equals("Operation")) {
/*  829 */       return 7;
/*      */     }
/*  831 */     if (strFieldName.equals("Int1")) {
/*  832 */       return 8;
/*      */     }
/*  834 */     if (strFieldName.equals("Int2")) {
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
/*  849 */     if (strFieldName.equals("Date1")) {
/*  850 */       return 14;
/*      */     }
/*  852 */     if (strFieldName.equals("Date2")) {
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
/*  864 */       strFieldName = "ID";
/*  865 */       break;
/*      */     case 1:
/*  867 */       strFieldName = "ContNo";
/*  868 */       break;
/*      */     case 2:
/*  870 */       strFieldName = "OperatorCode";
/*  871 */       break;
/*      */     case 3:
/*  873 */       strFieldName = "OperatorName";
/*  874 */       break;
/*      */     case 4:
/*  876 */       strFieldName = "OperatorType";
/*  877 */       break;
/*      */     case 5:
/*  879 */       strFieldName = "OperationDate";
/*  880 */       break;
/*      */     case 6:
/*  882 */       strFieldName = "OperationTime";
/*  883 */       break;
/*      */     case 7:
/*  885 */       strFieldName = "Operation";
/*  886 */       break;
/*      */     case 8:
/*  888 */       strFieldName = "Int1";
/*  889 */       break;
/*      */     case 9:
/*  891 */       strFieldName = "Int2";
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
/*  906 */       strFieldName = "Date1";
/*  907 */       break;
/*      */     case 15:
/*  909 */       strFieldName = "Date2";
/*  910 */       break;
/*      */     default:
/*  912 */       strFieldName = "";
/*      */     }
/*  914 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  920 */     if (strFieldName.equals("ID")) {
/*  921 */       return 0;
/*      */     }
/*  923 */     if (strFieldName.equals("ContNo")) {
/*  924 */       return 0;
/*      */     }
/*  926 */     if (strFieldName.equals("OperatorCode")) {
/*  927 */       return 0;
/*      */     }
/*  929 */     if (strFieldName.equals("OperatorName")) {
/*  930 */       return 0;
/*      */     }
/*  932 */     if (strFieldName.equals("OperatorType")) {
/*  933 */       return 0;
/*      */     }
/*  935 */     if (strFieldName.equals("OperationDate")) {
/*  936 */       return 0;
/*      */     }
/*  938 */     if (strFieldName.equals("OperationTime")) {
/*  939 */       return 0;
/*      */     }
/*  941 */     if (strFieldName.equals("Operation")) {
/*  942 */       return 0;
/*      */     }
/*  944 */     if (strFieldName.equals("Int1")) {
/*  945 */       return 3;
/*      */     }
/*  947 */     if (strFieldName.equals("Int2")) {
/*  948 */       return 3;
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
/*  962 */     if (strFieldName.equals("Date1")) {
/*  963 */       return 1;
/*      */     }
/*  965 */     if (strFieldName.equals("Date2")) {
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
/*  986 */       nFieldType = 0;
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
/* 1001 */       nFieldType = 3;
/* 1002 */       break;
/*      */     case 9:
/* 1004 */       nFieldType = 3;
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
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPOperationRecordSchema
 * JD-Core Version:    0.6.0
 */