/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPOperationRecordBDB;
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
/*      */ public class LNPOperationRecordBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
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
/*      */   public static final int FIELDNUM = 18;
/*      */   private static String[] PK;
/*   61 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPOperationRecordBSchema()
/*      */   {
/*   68 */     this.mErrors = new CErrors();
/*      */ 
/*   70 */     String[] pk = new String[2];
/*   71 */     pk[0] = "EdorNo";
/*   72 */     pk[1] = "serialNo";
/*      */ 
/*   74 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   80 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*   85 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*   89 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*   93 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*   97 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  101 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  105 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getID() {
/*  109 */     if (this.ID != null) this.ID.equals("");
/*      */ 
/*  113 */     return this.ID;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  117 */     this.ID = aID;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  121 */     if (this.ContNo != null) this.ContNo.equals("");
/*      */ 
/*  125 */     return this.ContNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  129 */     this.ContNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getOperatorCode() {
/*  133 */     if (this.OperatorCode != null) this.OperatorCode.equals("");
/*      */ 
/*  137 */     return this.OperatorCode;
/*      */   }
/*      */ 
/*      */   public void setOperatorCode(String aOperatorCode) {
/*  141 */     this.OperatorCode = aOperatorCode;
/*      */   }
/*      */ 
/*      */   public String getOperatorName() {
/*  145 */     if (this.OperatorName != null) this.OperatorName.equals("");
/*      */ 
/*  149 */     return this.OperatorName;
/*      */   }
/*      */ 
/*      */   public void setOperatorName(String aOperatorName) {
/*  153 */     this.OperatorName = aOperatorName;
/*      */   }
/*      */ 
/*      */   public String getOperatorType() {
/*  157 */     if (this.OperatorType != null) this.OperatorType.equals("");
/*      */ 
/*  161 */     return this.OperatorType;
/*      */   }
/*      */ 
/*      */   public void setOperatorType(String aOperatorType) {
/*  165 */     this.OperatorType = aOperatorType;
/*      */   }
/*      */ 
/*      */   public String getOperationDate() {
/*  169 */     if (this.OperationDate != null) this.OperationDate.equals("");
/*      */ 
/*  173 */     return this.OperationDate;
/*      */   }
/*      */ 
/*      */   public void setOperationDate(String aOperationDate) {
/*  177 */     this.OperationDate = aOperationDate;
/*      */   }
/*      */ 
/*      */   public String getOperationTime() {
/*  181 */     if (this.OperationTime != null) this.OperationTime.equals("");
/*      */ 
/*  185 */     return this.OperationTime;
/*      */   }
/*      */ 
/*      */   public void setOperationTime(String aOperationTime) {
/*  189 */     this.OperationTime = aOperationTime;
/*      */   }
/*      */ 
/*      */   public String getOperation() {
/*  193 */     if (this.Operation != null) this.Operation.equals("");
/*      */ 
/*  197 */     return this.Operation;
/*      */   }
/*      */ 
/*      */   public void setOperation(String aOperation) {
/*  201 */     this.Operation = aOperation;
/*      */   }
/*      */ 
/*      */   public int getInt1() {
/*  205 */     return this.Int1;
/*      */   }
/*      */ 
/*      */   public void setInt1(int aInt1) {
/*  209 */     this.Int1 = aInt1;
/*      */   }
/*      */ 
/*      */   public void setInt1(String aInt1) {
/*  213 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*      */     {
/*  215 */       Integer tInteger = new Integer(aInt1);
/*  216 */       int i = tInteger.intValue();
/*  217 */       this.Int1 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInt2()
/*      */   {
/*  223 */     return this.Int2;
/*      */   }
/*      */ 
/*      */   public void setInt2(int aInt2) {
/*  227 */     this.Int2 = aInt2;
/*      */   }
/*      */ 
/*      */   public void setInt2(String aInt2) {
/*  231 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*      */     {
/*  233 */       Integer tInteger = new Integer(aInt2);
/*  234 */       int i = tInteger.intValue();
/*  235 */       this.Int2 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getVarc1()
/*      */   {
/*  241 */     if (this.Varc1 != null) this.Varc1.equals("");
/*      */ 
/*  245 */     return this.Varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  249 */     this.Varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  253 */     if (this.Varc2 != null) this.Varc2.equals("");
/*      */ 
/*  257 */     return this.Varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  261 */     this.Varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getVarc3() {
/*  265 */     if (this.Varc3 != null) this.Varc3.equals("");
/*      */ 
/*  269 */     return this.Varc3;
/*      */   }
/*      */ 
/*      */   public void setVarc3(String aVarc3) {
/*  273 */     this.Varc3 = aVarc3;
/*      */   }
/*      */ 
/*      */   public String getVarc4() {
/*  277 */     if (this.Varc4 != null) this.Varc4.equals("");
/*      */ 
/*  281 */     return this.Varc4;
/*      */   }
/*      */ 
/*      */   public void setVarc4(String aVarc4) {
/*  285 */     this.Varc4 = aVarc4;
/*      */   }
/*      */ 
/*      */   public String getDate1() {
/*  289 */     if (this.Date1 != null) {
/*  290 */       return this.fDate.getString(this.Date1);
/*      */     }
/*  292 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate1(Date aDate1) {
/*  296 */     this.Date1 = aDate1;
/*      */   }
/*      */ 
/*      */   public void setDate1(String aDate1) {
/*  300 */     if ((aDate1 != null) && (!aDate1.equals("")))
/*      */     {
/*  302 */       this.Date1 = this.fDate.getDate(aDate1);
/*      */     }
/*      */     else
/*  305 */       this.Date1 = null;
/*      */   }
/*      */ 
/*      */   public String getDate2()
/*      */   {
/*  310 */     if (this.Date2 != null) {
/*  311 */       return this.fDate.getString(this.Date2);
/*      */     }
/*  313 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate2(Date aDate2) {
/*  317 */     this.Date2 = aDate2;
/*      */   }
/*      */ 
/*      */   public void setDate2(String aDate2) {
/*  321 */     if ((aDate2 != null) && (!aDate2.equals("")))
/*      */     {
/*  323 */       this.Date2 = this.fDate.getDate(aDate2);
/*      */     }
/*      */     else
/*  326 */       this.Date2 = null;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPOperationRecordBSchema aLNPOperationRecordBSchema)
/*      */   {
/*  333 */     this.EdorNo = aLNPOperationRecordBSchema.getEdorNo();
/*  334 */     this.serialNo = aLNPOperationRecordBSchema.getserialNo();
/*  335 */     this.ID = aLNPOperationRecordBSchema.getID();
/*  336 */     this.ContNo = aLNPOperationRecordBSchema.getContNo();
/*  337 */     this.OperatorCode = aLNPOperationRecordBSchema.getOperatorCode();
/*  338 */     this.OperatorName = aLNPOperationRecordBSchema.getOperatorName();
/*  339 */     this.OperatorType = aLNPOperationRecordBSchema.getOperatorType();
/*  340 */     this.OperationDate = aLNPOperationRecordBSchema.getOperationDate();
/*  341 */     this.OperationTime = aLNPOperationRecordBSchema.getOperationTime();
/*  342 */     this.Operation = aLNPOperationRecordBSchema.getOperation();
/*  343 */     this.Int1 = aLNPOperationRecordBSchema.getInt1();
/*  344 */     this.Int2 = aLNPOperationRecordBSchema.getInt2();
/*  345 */     this.Varc1 = aLNPOperationRecordBSchema.getVarc1();
/*  346 */     this.Varc2 = aLNPOperationRecordBSchema.getVarc2();
/*  347 */     this.Varc3 = aLNPOperationRecordBSchema.getVarc3();
/*  348 */     this.Varc4 = aLNPOperationRecordBSchema.getVarc4();
/*  349 */     this.Date1 = this.fDate.getDate(aLNPOperationRecordBSchema.getDate1());
/*  350 */     this.Date2 = this.fDate.getDate(aLNPOperationRecordBSchema.getDate2());
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  359 */       if (rs.getString("EdorNo") == null)
/*  360 */         this.EdorNo = null;
/*      */       else {
/*  362 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  364 */       if (rs.getString("serialNo") == null)
/*  365 */         this.serialNo = null;
/*      */       else {
/*  367 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/*  369 */       if (rs.getString("ID") == null)
/*  370 */         this.ID = null;
/*      */       else {
/*  372 */         this.ID = rs.getString("ID").trim();
/*      */       }
/*  374 */       if (rs.getString("ContNo") == null)
/*  375 */         this.ContNo = null;
/*      */       else {
/*  377 */         this.ContNo = rs.getString("ContNo").trim();
/*      */       }
/*  379 */       if (rs.getString("OperatorCode") == null)
/*  380 */         this.OperatorCode = null;
/*      */       else {
/*  382 */         this.OperatorCode = rs.getString("OperatorCode").trim();
/*      */       }
/*  384 */       if (rs.getString("OperatorName") == null)
/*  385 */         this.OperatorName = null;
/*      */       else {
/*  387 */         this.OperatorName = rs.getString("OperatorName").trim();
/*      */       }
/*  389 */       if (rs.getString("OperatorType") == null)
/*  390 */         this.OperatorType = null;
/*      */       else {
/*  392 */         this.OperatorType = rs.getString("OperatorType").trim();
/*      */       }
/*  394 */       if (rs.getString("OperationDate") == null)
/*  395 */         this.OperationDate = null;
/*      */       else {
/*  397 */         this.OperationDate = rs.getString("OperationDate").trim();
/*      */       }
/*  399 */       if (rs.getString("OperationTime") == null)
/*  400 */         this.OperationTime = null;
/*      */       else {
/*  402 */         this.OperationTime = rs.getString("OperationTime").trim();
/*      */       }
/*  404 */       if (rs.getString("Operation") == null)
/*  405 */         this.Operation = null;
/*      */       else {
/*  407 */         this.Operation = rs.getString("Operation").trim();
/*      */       }
/*  409 */       this.Int1 = rs.getInt("Int1");
/*  410 */       this.Int2 = rs.getInt("Int2");
/*  411 */       if (rs.getString("Varc1") == null)
/*  412 */         this.Varc1 = null;
/*      */       else {
/*  414 */         this.Varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  416 */       if (rs.getString("Varc2") == null)
/*  417 */         this.Varc2 = null;
/*      */       else {
/*  419 */         this.Varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  421 */       if (rs.getString("Varc3") == null)
/*  422 */         this.Varc3 = null;
/*      */       else {
/*  424 */         this.Varc3 = rs.getString("Varc3").trim();
/*      */       }
/*  426 */       if (rs.getString("Varc4") == null)
/*  427 */         this.Varc4 = null;
/*      */       else {
/*  429 */         this.Varc4 = rs.getString("Varc4").trim();
/*      */       }
/*  431 */       this.Date1 = rs.getDate("Date1");
/*  432 */       this.Date2 = rs.getDate("Date2");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  437 */       CError tError = new CError();
/*  438 */       tError.moduleName = "LNPOperationRecordBSchema";
/*  439 */       tError.functionName = "setSchema";
/*  440 */       tError.errorMessage = sqle.toString();
/*  441 */       this.mErrors.addOneError(tError);
/*      */ 
/*  443 */       return false;
/*      */     }
/*  445 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPOperationRecordBSchema getSchema()
/*      */   {
/*  450 */     LNPOperationRecordBSchema aLNPOperationRecordBSchema = new LNPOperationRecordBSchema();
/*  451 */     aLNPOperationRecordBSchema.setSchema(this);
/*  452 */     return aLNPOperationRecordBSchema;
/*      */   }
/*      */ 
/*      */   public LNPOperationRecordBDB getDB()
/*      */   {
/*  457 */     LNPOperationRecordBDB aDBOper = new LNPOperationRecordBDB();
/*  458 */     aDBOper.setSchema(this);
/*  459 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  466 */     String strReturn = "";
/*  467 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/*  468 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/*  469 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ID)) + "|" + 
/*  470 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ContNo)) + "|" + 
/*  471 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OperatorCode)) + "|" + 
/*  472 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OperatorName)) + "|" + 
/*  473 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OperatorType)) + "|" + 
/*  474 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OperationDate)) + "|" + 
/*  475 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OperationTime)) + "|" + 
/*  476 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Operation)) + "|" + 
/*  477 */       ChgData.chgData(this.Int1) + "|" + 
/*  478 */       ChgData.chgData(this.Int2) + "|" + 
/*  479 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc1)) + "|" + 
/*  480 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc2)) + "|" + 
/*  481 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc3)) + "|" + 
/*  482 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc4)) + "|" + 
/*  483 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.Date1))) + "|" + 
/*  484 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.Date2)));
/*  485 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  493 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  494 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  495 */       this.ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  496 */       this.ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  497 */       this.OperatorCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  498 */       this.OperatorName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  499 */       this.OperatorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  500 */       this.OperationDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  501 */       this.OperationTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  502 */       this.Operation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  503 */       this.Int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).intValue();
/*  504 */       this.Int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).intValue();
/*  505 */       this.Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  506 */       this.Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  507 */       this.Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  508 */       this.Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  509 */       this.Date1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  510 */       this.Date2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  515 */       CError tError = new CError();
/*  516 */       tError.moduleName = "LNPOperationRecordBSchema";
/*  517 */       tError.functionName = "decode";
/*  518 */       tError.errorMessage = ex.toString();
/*  519 */       this.mErrors.addOneError(tError);
/*      */ 
/*  521 */       return false;
/*      */     }
/*  523 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  529 */     String strReturn = "";
/*  530 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  532 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/*  534 */     if (FCode.equals("serialNo"))
/*      */     {
/*  536 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/*  538 */     if (FCode.equals("ID"))
/*      */     {
/*  540 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ID));
/*      */     }
/*  542 */     if (FCode.equals("ContNo"))
/*      */     {
/*  544 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ContNo));
/*      */     }
/*  546 */     if (FCode.equals("OperatorCode"))
/*      */     {
/*  548 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OperatorCode));
/*      */     }
/*  550 */     if (FCode.equals("OperatorName"))
/*      */     {
/*  552 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OperatorName));
/*      */     }
/*  554 */     if (FCode.equals("OperatorType"))
/*      */     {
/*  556 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OperatorType));
/*      */     }
/*  558 */     if (FCode.equals("OperationDate"))
/*      */     {
/*  560 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OperationDate));
/*      */     }
/*  562 */     if (FCode.equals("OperationTime"))
/*      */     {
/*  564 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OperationTime));
/*      */     }
/*  566 */     if (FCode.equals("Operation"))
/*      */     {
/*  568 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Operation));
/*      */     }
/*  570 */     if (FCode.equals("Int1"))
/*      */     {
/*  572 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Int1));
/*      */     }
/*  574 */     if (FCode.equals("Int2"))
/*      */     {
/*  576 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Int2));
/*      */     }
/*  578 */     if (FCode.equals("Varc1"))
/*      */     {
/*  580 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc1));
/*      */     }
/*  582 */     if (FCode.equals("Varc2"))
/*      */     {
/*  584 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc2));
/*      */     }
/*  586 */     if (FCode.equals("Varc3"))
/*      */     {
/*  588 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc3));
/*      */     }
/*  590 */     if (FCode.equals("Varc4"))
/*      */     {
/*  592 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc4));
/*      */     }
/*  594 */     if (FCode.equals("Date1"))
/*      */     {
/*  596 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate1()));
/*      */     }
/*  598 */     if (FCode.equals("Date2"))
/*      */     {
/*  600 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate2()));
/*      */     }
/*  602 */     if (strReturn.equals(""))
/*      */     {
/*  604 */       strReturn = "null";
/*      */     }
/*      */ 
/*  607 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  614 */     String strFieldValue = "";
/*  615 */     switch (nFieldIndex) {
/*      */     case 0:
/*  617 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/*  618 */       break;
/*      */     case 1:
/*  620 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/*  621 */       break;
/*      */     case 2:
/*  623 */       strFieldValue = StrTool.GBKToUnicode(this.ID);
/*  624 */       break;
/*      */     case 3:
/*  626 */       strFieldValue = StrTool.GBKToUnicode(this.ContNo);
/*  627 */       break;
/*      */     case 4:
/*  629 */       strFieldValue = StrTool.GBKToUnicode(this.OperatorCode);
/*  630 */       break;
/*      */     case 5:
/*  632 */       strFieldValue = StrTool.GBKToUnicode(this.OperatorName);
/*  633 */       break;
/*      */     case 6:
/*  635 */       strFieldValue = StrTool.GBKToUnicode(this.OperatorType);
/*  636 */       break;
/*      */     case 7:
/*  638 */       strFieldValue = StrTool.GBKToUnicode(this.OperationDate);
/*  639 */       break;
/*      */     case 8:
/*  641 */       strFieldValue = StrTool.GBKToUnicode(this.OperationTime);
/*  642 */       break;
/*      */     case 9:
/*  644 */       strFieldValue = StrTool.GBKToUnicode(this.Operation);
/*  645 */       break;
/*      */     case 10:
/*  647 */       strFieldValue = String.valueOf(this.Int1);
/*  648 */       break;
/*      */     case 11:
/*  650 */       strFieldValue = String.valueOf(this.Int2);
/*  651 */       break;
/*      */     case 12:
/*  653 */       strFieldValue = StrTool.GBKToUnicode(this.Varc1);
/*  654 */       break;
/*      */     case 13:
/*  656 */       strFieldValue = StrTool.GBKToUnicode(this.Varc2);
/*  657 */       break;
/*      */     case 14:
/*  659 */       strFieldValue = StrTool.GBKToUnicode(this.Varc3);
/*  660 */       break;
/*      */     case 15:
/*  662 */       strFieldValue = StrTool.GBKToUnicode(this.Varc4);
/*  663 */       break;
/*      */     case 16:
/*  665 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate1()));
/*  666 */       break;
/*      */     case 17:
/*  668 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate2()));
/*  669 */       break;
/*      */     default:
/*  671 */       strFieldValue = "";
/*      */     }
/*  673 */     if (strFieldValue.equals("")) {
/*  674 */       strFieldValue = "null";
/*      */     }
/*  676 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  682 */     if (StrTool.cTrim(FCode).equals("")) {
/*  683 */       return false;
/*      */     }
/*  685 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  687 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  689 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/*  692 */         this.EdorNo = null;
/*      */     }
/*  694 */     if (FCode.equals("serialNo"))
/*      */     {
/*  696 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  698 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/*  701 */         this.serialNo = null;
/*      */     }
/*  703 */     if (FCode.equals("ID"))
/*      */     {
/*  705 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  707 */         this.ID = FValue.trim();
/*      */       }
/*      */       else
/*  710 */         this.ID = null;
/*      */     }
/*  712 */     if (FCode.equals("ContNo"))
/*      */     {
/*  714 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  716 */         this.ContNo = FValue.trim();
/*      */       }
/*      */       else
/*  719 */         this.ContNo = null;
/*      */     }
/*  721 */     if (FCode.equals("OperatorCode"))
/*      */     {
/*  723 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  725 */         this.OperatorCode = FValue.trim();
/*      */       }
/*      */       else
/*  728 */         this.OperatorCode = null;
/*      */     }
/*  730 */     if (FCode.equals("OperatorName"))
/*      */     {
/*  732 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  734 */         this.OperatorName = FValue.trim();
/*      */       }
/*      */       else
/*  737 */         this.OperatorName = null;
/*      */     }
/*  739 */     if (FCode.equals("OperatorType"))
/*      */     {
/*  741 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  743 */         this.OperatorType = FValue.trim();
/*      */       }
/*      */       else
/*  746 */         this.OperatorType = null;
/*      */     }
/*  748 */     if (FCode.equals("OperationDate"))
/*      */     {
/*  750 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  752 */         this.OperationDate = FValue.trim();
/*      */       }
/*      */       else
/*  755 */         this.OperationDate = null;
/*      */     }
/*  757 */     if (FCode.equals("OperationTime"))
/*      */     {
/*  759 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  761 */         this.OperationTime = FValue.trim();
/*      */       }
/*      */       else
/*  764 */         this.OperationTime = null;
/*      */     }
/*  766 */     if (FCode.equals("Operation"))
/*      */     {
/*  768 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  770 */         this.Operation = FValue.trim();
/*      */       }
/*      */       else
/*  773 */         this.Operation = null;
/*      */     }
/*  775 */     if (FCode.equals("Int1"))
/*      */     {
/*  777 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  779 */         Integer tInteger = new Integer(FValue);
/*  780 */         int i = tInteger.intValue();
/*  781 */         this.Int1 = i;
/*      */       }
/*      */     }
/*  784 */     if (FCode.equals("Int2"))
/*      */     {
/*  786 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  788 */         Integer tInteger = new Integer(FValue);
/*  789 */         int i = tInteger.intValue();
/*  790 */         this.Int2 = i;
/*      */       }
/*      */     }
/*  793 */     if (FCode.equals("Varc1"))
/*      */     {
/*  795 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  797 */         this.Varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  800 */         this.Varc1 = null;
/*      */     }
/*  802 */     if (FCode.equals("Varc2"))
/*      */     {
/*  804 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  806 */         this.Varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  809 */         this.Varc2 = null;
/*      */     }
/*  811 */     if (FCode.equals("Varc3"))
/*      */     {
/*  813 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  815 */         this.Varc3 = FValue.trim();
/*      */       }
/*      */       else
/*  818 */         this.Varc3 = null;
/*      */     }
/*  820 */     if (FCode.equals("Varc4"))
/*      */     {
/*  822 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  824 */         this.Varc4 = FValue.trim();
/*      */       }
/*      */       else
/*  827 */         this.Varc4 = null;
/*      */     }
/*  829 */     if (FCode.equals("Date1"))
/*      */     {
/*  831 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  833 */         this.Date1 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  836 */         this.Date1 = null;
/*      */     }
/*  838 */     if (FCode.equals("Date2"))
/*      */     {
/*  840 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  842 */         this.Date2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  845 */         this.Date2 = null;
/*      */     }
/*  847 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  852 */     if (this == otherObject) return true;
/*  853 */     if (otherObject == null) return false;
/*  854 */     if (getClass() != otherObject.getClass()) return false;
/*  855 */     LNPOperationRecordBSchema other = (LNPOperationRecordBSchema)otherObject;
/*  856 */     return 
/*  857 */       (this.EdorNo.equals(other.getEdorNo())) && 
/*  858 */       (this.serialNo.equals(other.getserialNo())) && 
/*  859 */       (this.ID.equals(other.getID())) && 
/*  860 */       (this.ContNo.equals(other.getContNo())) && 
/*  861 */       (this.OperatorCode.equals(other.getOperatorCode())) && 
/*  862 */       (this.OperatorName.equals(other.getOperatorName())) && 
/*  863 */       (this.OperatorType.equals(other.getOperatorType())) && 
/*  864 */       (this.OperationDate.equals(other.getOperationDate())) && 
/*  865 */       (this.OperationTime.equals(other.getOperationTime())) && 
/*  866 */       (this.Operation.equals(other.getOperation())) && 
/*  867 */       (this.Int1 == other.getInt1()) && 
/*  868 */       (this.Int2 == other.getInt2()) && 
/*  869 */       (this.Varc1.equals(other.getVarc1())) && 
/*  870 */       (this.Varc2.equals(other.getVarc2())) && 
/*  871 */       (this.Varc3.equals(other.getVarc3())) && 
/*  872 */       (this.Varc4.equals(other.getVarc4())) && 
/*  873 */       (this.fDate.getString(this.Date1).equals(other.getDate1())) && 
/*  874 */       (this.fDate.getString(this.Date2).equals(other.getDate2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  880 */     return 18;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  886 */     if (strFieldName.equals("EdorNo")) {
/*  887 */       return 0;
/*      */     }
/*  889 */     if (strFieldName.equals("serialNo")) {
/*  890 */       return 1;
/*      */     }
/*  892 */     if (strFieldName.equals("ID")) {
/*  893 */       return 2;
/*      */     }
/*  895 */     if (strFieldName.equals("ContNo")) {
/*  896 */       return 3;
/*      */     }
/*  898 */     if (strFieldName.equals("OperatorCode")) {
/*  899 */       return 4;
/*      */     }
/*  901 */     if (strFieldName.equals("OperatorName")) {
/*  902 */       return 5;
/*      */     }
/*  904 */     if (strFieldName.equals("OperatorType")) {
/*  905 */       return 6;
/*      */     }
/*  907 */     if (strFieldName.equals("OperationDate")) {
/*  908 */       return 7;
/*      */     }
/*  910 */     if (strFieldName.equals("OperationTime")) {
/*  911 */       return 8;
/*      */     }
/*  913 */     if (strFieldName.equals("Operation")) {
/*  914 */       return 9;
/*      */     }
/*  916 */     if (strFieldName.equals("Int1")) {
/*  917 */       return 10;
/*      */     }
/*  919 */     if (strFieldName.equals("Int2")) {
/*  920 */       return 11;
/*      */     }
/*  922 */     if (strFieldName.equals("Varc1")) {
/*  923 */       return 12;
/*      */     }
/*  925 */     if (strFieldName.equals("Varc2")) {
/*  926 */       return 13;
/*      */     }
/*  928 */     if (strFieldName.equals("Varc3")) {
/*  929 */       return 14;
/*      */     }
/*  931 */     if (strFieldName.equals("Varc4")) {
/*  932 */       return 15;
/*      */     }
/*  934 */     if (strFieldName.equals("Date1")) {
/*  935 */       return 16;
/*      */     }
/*  937 */     if (strFieldName.equals("Date2")) {
/*  938 */       return 17;
/*      */     }
/*  940 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  946 */     String strFieldName = "";
/*  947 */     switch (nFieldIndex) {
/*      */     case 0:
/*  949 */       strFieldName = "EdorNo";
/*  950 */       break;
/*      */     case 1:
/*  952 */       strFieldName = "serialNo";
/*  953 */       break;
/*      */     case 2:
/*  955 */       strFieldName = "ID";
/*  956 */       break;
/*      */     case 3:
/*  958 */       strFieldName = "ContNo";
/*  959 */       break;
/*      */     case 4:
/*  961 */       strFieldName = "OperatorCode";
/*  962 */       break;
/*      */     case 5:
/*  964 */       strFieldName = "OperatorName";
/*  965 */       break;
/*      */     case 6:
/*  967 */       strFieldName = "OperatorType";
/*  968 */       break;
/*      */     case 7:
/*  970 */       strFieldName = "OperationDate";
/*  971 */       break;
/*      */     case 8:
/*  973 */       strFieldName = "OperationTime";
/*  974 */       break;
/*      */     case 9:
/*  976 */       strFieldName = "Operation";
/*  977 */       break;
/*      */     case 10:
/*  979 */       strFieldName = "Int1";
/*  980 */       break;
/*      */     case 11:
/*  982 */       strFieldName = "Int2";
/*  983 */       break;
/*      */     case 12:
/*  985 */       strFieldName = "Varc1";
/*  986 */       break;
/*      */     case 13:
/*  988 */       strFieldName = "Varc2";
/*  989 */       break;
/*      */     case 14:
/*  991 */       strFieldName = "Varc3";
/*  992 */       break;
/*      */     case 15:
/*  994 */       strFieldName = "Varc4";
/*  995 */       break;
/*      */     case 16:
/*  997 */       strFieldName = "Date1";
/*  998 */       break;
/*      */     case 17:
/* 1000 */       strFieldName = "Date2";
/* 1001 */       break;
/*      */     default:
/* 1003 */       strFieldName = "";
/*      */     }
/* 1005 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1011 */     if (strFieldName.equals("EdorNo")) {
/* 1012 */       return 0;
/*      */     }
/* 1014 */     if (strFieldName.equals("serialNo")) {
/* 1015 */       return 0;
/*      */     }
/* 1017 */     if (strFieldName.equals("ID")) {
/* 1018 */       return 0;
/*      */     }
/* 1020 */     if (strFieldName.equals("ContNo")) {
/* 1021 */       return 0;
/*      */     }
/* 1023 */     if (strFieldName.equals("OperatorCode")) {
/* 1024 */       return 0;
/*      */     }
/* 1026 */     if (strFieldName.equals("OperatorName")) {
/* 1027 */       return 0;
/*      */     }
/* 1029 */     if (strFieldName.equals("OperatorType")) {
/* 1030 */       return 0;
/*      */     }
/* 1032 */     if (strFieldName.equals("OperationDate")) {
/* 1033 */       return 0;
/*      */     }
/* 1035 */     if (strFieldName.equals("OperationTime")) {
/* 1036 */       return 0;
/*      */     }
/* 1038 */     if (strFieldName.equals("Operation")) {
/* 1039 */       return 0;
/*      */     }
/* 1041 */     if (strFieldName.equals("Int1")) {
/* 1042 */       return 3;
/*      */     }
/* 1044 */     if (strFieldName.equals("Int2")) {
/* 1045 */       return 3;
/*      */     }
/* 1047 */     if (strFieldName.equals("Varc1")) {
/* 1048 */       return 0;
/*      */     }
/* 1050 */     if (strFieldName.equals("Varc2")) {
/* 1051 */       return 0;
/*      */     }
/* 1053 */     if (strFieldName.equals("Varc3")) {
/* 1054 */       return 0;
/*      */     }
/* 1056 */     if (strFieldName.equals("Varc4")) {
/* 1057 */       return 0;
/*      */     }
/* 1059 */     if (strFieldName.equals("Date1")) {
/* 1060 */       return 1;
/*      */     }
/* 1062 */     if (strFieldName.equals("Date2")) {
/* 1063 */       return 1;
/*      */     }
/* 1065 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1071 */     int nFieldType = -1;
/* 1072 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1074 */       nFieldType = 0;
/* 1075 */       break;
/*      */     case 1:
/* 1077 */       nFieldType = 0;
/* 1078 */       break;
/*      */     case 2:
/* 1080 */       nFieldType = 0;
/* 1081 */       break;
/*      */     case 3:
/* 1083 */       nFieldType = 0;
/* 1084 */       break;
/*      */     case 4:
/* 1086 */       nFieldType = 0;
/* 1087 */       break;
/*      */     case 5:
/* 1089 */       nFieldType = 0;
/* 1090 */       break;
/*      */     case 6:
/* 1092 */       nFieldType = 0;
/* 1093 */       break;
/*      */     case 7:
/* 1095 */       nFieldType = 0;
/* 1096 */       break;
/*      */     case 8:
/* 1098 */       nFieldType = 0;
/* 1099 */       break;
/*      */     case 9:
/* 1101 */       nFieldType = 0;
/* 1102 */       break;
/*      */     case 10:
/* 1104 */       nFieldType = 3;
/* 1105 */       break;
/*      */     case 11:
/* 1107 */       nFieldType = 3;
/* 1108 */       break;
/*      */     case 12:
/* 1110 */       nFieldType = 0;
/* 1111 */       break;
/*      */     case 13:
/* 1113 */       nFieldType = 0;
/* 1114 */       break;
/*      */     case 14:
/* 1116 */       nFieldType = 0;
/* 1117 */       break;
/*      */     case 15:
/* 1119 */       nFieldType = 0;
/* 1120 */       break;
/*      */     case 16:
/* 1122 */       nFieldType = 1;
/* 1123 */       break;
/*      */     case 17:
/* 1125 */       nFieldType = 1;
/* 1126 */       break;
/*      */     default:
/* 1128 */       nFieldType = -1;
/*      */     }
/* 1130 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPOperationRecordBSchema
 * JD-Core Version:    0.6.0
 */