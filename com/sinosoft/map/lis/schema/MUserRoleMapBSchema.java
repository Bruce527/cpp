/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MUserRoleMapBDB;
/*      */ import com.sinosoft.map.lis.pubfun.FDate;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.ChgData;
/*      */ import com.sinosoft.map.utility.Schema;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class MUserRoleMapBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String userCode;
/*      */   private String roleID;
/*      */   private String type;
/*      */   private Date startDate;
/*      */   private Date endDate;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private int int1;
/*      */   private int int2;
/*      */   private String varc1;
/*      */   private String varc2;
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   public static final int FIELDNUM = 21;
/*      */   private static String[] PK;
/*   66 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MUserRoleMapBSchema()
/*      */   {
/*   73 */     this.mErrors = new CErrors();
/*      */ 
/*   75 */     String[] pk = new String[1];
/*   76 */     pk[0] = "EdorNo";
/*      */ 
/*   78 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   85 */     MUserRoleMapBSchema cloned = (MUserRoleMapBSchema)super.clone();
/*   86 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   87 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   88 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   94 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*   99 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  103 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getUserCode() {
/*  107 */     return this.userCode;
/*      */   }
/*      */ 
/*      */   public void setUserCode(String aUserCode) {
/*  111 */     this.userCode = aUserCode;
/*      */   }
/*      */ 
/*      */   public String getRoleID() {
/*  115 */     return this.roleID;
/*      */   }
/*      */ 
/*      */   public void setRoleID(String aRoleID) {
/*  119 */     this.roleID = aRoleID;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  123 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  127 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  131 */     if (this.startDate != null) {
/*  132 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  134 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  138 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  142 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  144 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  147 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  152 */     if (this.endDate != null) {
/*  153 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  155 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  159 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  163 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  165 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  168 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  173 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  177 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  181 */     if (this.makeDate != null) {
/*  182 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  184 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  188 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  192 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  194 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  197 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  202 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  206 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  210 */     if (this.modifyDate != null) {
/*  211 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  213 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  217 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  221 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  223 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  226 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  231 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  235 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public int getInt1() {
/*  239 */     return this.int1;
/*      */   }
/*      */ 
/*      */   public void setInt1(int aInt1) {
/*  243 */     this.int1 = aInt1;
/*      */   }
/*      */ 
/*      */   public void setInt1(String aInt1) {
/*  247 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*      */     {
/*  249 */       Integer tInteger = new Integer(aInt1);
/*  250 */       int i = tInteger.intValue();
/*  251 */       this.int1 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInt2()
/*      */   {
/*  257 */     return this.int2;
/*      */   }
/*      */ 
/*      */   public void setInt2(int aInt2) {
/*  261 */     this.int2 = aInt2;
/*      */   }
/*      */ 
/*      */   public void setInt2(String aInt2) {
/*  265 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*      */     {
/*  267 */       Integer tInteger = new Integer(aInt2);
/*  268 */       int i = tInteger.intValue();
/*  269 */       this.int2 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getVarc1()
/*      */   {
/*  275 */     return this.varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  279 */     this.varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  283 */     return this.varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  287 */     this.varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  291 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  295 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  299 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  303 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  307 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  311 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  315 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  319 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  323 */     if (this.makeDate2 != null) {
/*  324 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  326 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  330 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  334 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  336 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  339 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  344 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  348 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public void setSchema(MUserRoleMapBSchema aMUserRoleMapBSchema)
/*      */   {
/*  354 */     this.iD = aMUserRoleMapBSchema.getID();
/*  355 */     this.userCode = aMUserRoleMapBSchema.getUserCode();
/*  356 */     this.roleID = aMUserRoleMapBSchema.getRoleID();
/*  357 */     this.type = aMUserRoleMapBSchema.getType();
/*  358 */     this.startDate = this.fDate.getDate(aMUserRoleMapBSchema.getStartDate());
/*  359 */     this.endDate = this.fDate.getDate(aMUserRoleMapBSchema.getEndDate());
/*  360 */     this.operator = aMUserRoleMapBSchema.getOperator();
/*  361 */     this.makeDate = this.fDate.getDate(aMUserRoleMapBSchema.getMakeDate());
/*  362 */     this.makeTime = aMUserRoleMapBSchema.getMakeTime();
/*  363 */     this.modifyDate = this.fDate.getDate(aMUserRoleMapBSchema.getModifyDate());
/*  364 */     this.modifyTime = aMUserRoleMapBSchema.getModifyTime();
/*  365 */     this.int1 = aMUserRoleMapBSchema.getInt1();
/*  366 */     this.int2 = aMUserRoleMapBSchema.getInt2();
/*  367 */     this.varc1 = aMUserRoleMapBSchema.getVarc1();
/*  368 */     this.varc2 = aMUserRoleMapBSchema.getVarc2();
/*  369 */     this.edorNo = aMUserRoleMapBSchema.getEdorNo();
/*  370 */     this.edorType = aMUserRoleMapBSchema.getEdorType();
/*  371 */     this.edorCase = aMUserRoleMapBSchema.getEdorCase();
/*  372 */     this.operator2 = aMUserRoleMapBSchema.getOperator2();
/*  373 */     this.makeDate2 = this.fDate.getDate(aMUserRoleMapBSchema.getMakeDate2());
/*  374 */     this.makeTime2 = aMUserRoleMapBSchema.getMakeTime2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  383 */       if (rs.getString("ID") == null)
/*  384 */         this.iD = null;
/*      */       else {
/*  386 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  388 */       if (rs.getString("UserCode") == null)
/*  389 */         this.userCode = null;
/*      */       else {
/*  391 */         this.userCode = rs.getString("UserCode").trim();
/*      */       }
/*  393 */       if (rs.getString("RoleID") == null)
/*  394 */         this.roleID = null;
/*      */       else {
/*  396 */         this.roleID = rs.getString("RoleID").trim();
/*      */       }
/*  398 */       if (rs.getString("Type") == null)
/*  399 */         this.type = null;
/*      */       else {
/*  401 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  403 */       this.startDate = rs.getDate("StartDate");
/*  404 */       this.endDate = rs.getDate("EndDate");
/*  405 */       if (rs.getString("Operator") == null)
/*  406 */         this.operator = null;
/*      */       else {
/*  408 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  410 */       this.makeDate = rs.getDate("MakeDate");
/*  411 */       if (rs.getString("MakeTime") == null)
/*  412 */         this.makeTime = null;
/*      */       else {
/*  414 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  416 */       this.modifyDate = rs.getDate("ModifyDate");
/*  417 */       if (rs.getString("ModifyTime") == null)
/*  418 */         this.modifyTime = null;
/*      */       else {
/*  420 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  422 */       this.int1 = rs.getInt("Int1");
/*  423 */       this.int2 = rs.getInt("Int2");
/*  424 */       if (rs.getString("Varc1") == null)
/*  425 */         this.varc1 = null;
/*      */       else {
/*  427 */         this.varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  429 */       if (rs.getString("Varc2") == null)
/*  430 */         this.varc2 = null;
/*      */       else {
/*  432 */         this.varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  434 */       if (rs.getString("EdorNo") == null)
/*  435 */         this.edorNo = null;
/*      */       else {
/*  437 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  439 */       if (rs.getString("EdorType") == null)
/*  440 */         this.edorType = null;
/*      */       else {
/*  442 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  444 */       if (rs.getString("EdorCase") == null)
/*  445 */         this.edorCase = null;
/*      */       else {
/*  447 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  449 */       if (rs.getString("Operator2") == null)
/*  450 */         this.operator2 = null;
/*      */       else {
/*  452 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  454 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  455 */       if (rs.getString("MakeTime2") == null)
/*  456 */         this.makeTime2 = null;
/*      */       else {
/*  458 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  463 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MUserRoleMapB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  465 */       CError tError = new CError();
/*  466 */       tError.moduleName = "MUserRoleMapBSchema";
/*  467 */       tError.functionName = "setSchema";
/*  468 */       tError.errorMessage = sqle.toString();
/*  469 */       this.mErrors.addOneError(tError);
/*  470 */       return false;
/*      */     }
/*  472 */     return true;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapBSchema getSchema()
/*      */   {
/*  477 */     MUserRoleMapBSchema aMUserRoleMapBSchema = new MUserRoleMapBSchema();
/*  478 */     aMUserRoleMapBSchema.setSchema(this);
/*  479 */     return aMUserRoleMapBSchema;
/*      */   }
/*      */ 
/*      */   public MUserRoleMapBDB getDB()
/*      */   {
/*  484 */     MUserRoleMapBDB aDBOper = new MUserRoleMapBDB();
/*  485 */     aDBOper.setSchema(this);
/*  486 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  493 */     StringBuffer strReturn = new StringBuffer(256);
/*  494 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  495 */     strReturn.append(StrTool.cTrim(this.userCode)); strReturn.append("|");
/*  496 */     strReturn.append(StrTool.cTrim(this.roleID)); strReturn.append("|");
/*  497 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  498 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  499 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  500 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  501 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  502 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  503 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  504 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  505 */     strReturn.append(ChgData.chgData(this.int1)); strReturn.append("|");
/*  506 */     strReturn.append(ChgData.chgData(this.int2)); strReturn.append("|");
/*  507 */     strReturn.append(StrTool.cTrim(this.varc1)); strReturn.append("|");
/*  508 */     strReturn.append(StrTool.cTrim(this.varc2)); strReturn.append("|");
/*  509 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  510 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  511 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  512 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  513 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  514 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/*  515 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  523 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  524 */       this.userCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  525 */       this.roleID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  526 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  527 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/*  528 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/*  529 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  530 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/*  531 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  532 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*  533 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  534 */       this.int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).intValue();
/*  535 */       this.int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).intValue();
/*  536 */       this.varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  537 */       this.varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  538 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  539 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  540 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  541 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  542 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  543 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  548 */       CError tError = new CError();
/*  549 */       tError.moduleName = "MUserRoleMapBSchema";
/*  550 */       tError.functionName = "decode";
/*  551 */       tError.errorMessage = ex.toString();
/*  552 */       this.mErrors.addOneError(tError);
/*      */ 
/*  554 */       return false;
/*      */     }
/*  556 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  562 */     String strReturn = "";
/*  563 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  565 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  567 */     if (FCode.equalsIgnoreCase("userCode"))
/*      */     {
/*  569 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userCode));
/*      */     }
/*  571 */     if (FCode.equalsIgnoreCase("roleID"))
/*      */     {
/*  573 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.roleID));
/*      */     }
/*  575 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  577 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  579 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  581 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  583 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  585 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  587 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  589 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  591 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  593 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  595 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  597 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  599 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  601 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  603 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  605 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  607 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  609 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int1));
/*      */     }
/*  611 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  613 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int2));
/*      */     }
/*  615 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  617 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc1));
/*      */     }
/*  619 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  621 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc2));
/*      */     }
/*  623 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  625 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  627 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  629 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  631 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  633 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  635 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  637 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  639 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  641 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  643 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  645 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  647 */     if (strReturn.equals(""))
/*      */     {
/*  649 */       strReturn = "null";
/*      */     }
/*      */ 
/*  652 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  659 */     String strFieldValue = "";
/*  660 */     switch (nFieldIndex) {
/*      */     case 0:
/*  662 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  663 */       break;
/*      */     case 1:
/*  665 */       strFieldValue = StrTool.GBKToUnicode(this.userCode);
/*  666 */       break;
/*      */     case 2:
/*  668 */       strFieldValue = StrTool.GBKToUnicode(this.roleID);
/*  669 */       break;
/*      */     case 3:
/*  671 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  672 */       break;
/*      */     case 4:
/*  674 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  675 */       break;
/*      */     case 5:
/*  677 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*  678 */       break;
/*      */     case 6:
/*  680 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  681 */       break;
/*      */     case 7:
/*  683 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  684 */       break;
/*      */     case 8:
/*  686 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  687 */       break;
/*      */     case 9:
/*  689 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  690 */       break;
/*      */     case 10:
/*  692 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  693 */       break;
/*      */     case 11:
/*  695 */       strFieldValue = String.valueOf(this.int1);
/*  696 */       break;
/*      */     case 12:
/*  698 */       strFieldValue = String.valueOf(this.int2);
/*  699 */       break;
/*      */     case 13:
/*  701 */       strFieldValue = StrTool.GBKToUnicode(this.varc1);
/*  702 */       break;
/*      */     case 14:
/*  704 */       strFieldValue = StrTool.GBKToUnicode(this.varc2);
/*  705 */       break;
/*      */     case 15:
/*  707 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  708 */       break;
/*      */     case 16:
/*  710 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  711 */       break;
/*      */     case 17:
/*  713 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  714 */       break;
/*      */     case 18:
/*  716 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  717 */       break;
/*      */     case 19:
/*  719 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  720 */       break;
/*      */     case 20:
/*  722 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  723 */       break;
/*      */     default:
/*  725 */       strFieldValue = "";
/*      */     }
/*  727 */     if (strFieldValue.equals("")) {
/*  728 */       strFieldValue = "null";
/*      */     }
/*  730 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  736 */     if (StrTool.cTrim(FCode).equals("")) {
/*  737 */       return false;
/*      */     }
/*  739 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  741 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  743 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  746 */         this.iD = null;
/*      */     }
/*  748 */     if (FCode.equalsIgnoreCase("userCode"))
/*      */     {
/*  750 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  752 */         this.userCode = FValue.trim();
/*      */       }
/*      */       else
/*  755 */         this.userCode = null;
/*      */     }
/*  757 */     if (FCode.equalsIgnoreCase("roleID"))
/*      */     {
/*  759 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  761 */         this.roleID = FValue.trim();
/*      */       }
/*      */       else
/*  764 */         this.roleID = null;
/*      */     }
/*  766 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  768 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  770 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/*  773 */         this.type = null;
/*      */     }
/*  775 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  777 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  779 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  782 */         this.startDate = null;
/*      */     }
/*  784 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  786 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  788 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  791 */         this.endDate = null;
/*      */     }
/*  793 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  795 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  797 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  800 */         this.operator = null;
/*      */     }
/*  802 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  804 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  806 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  809 */         this.makeDate = null;
/*      */     }
/*  811 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  813 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  815 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  818 */         this.makeTime = null;
/*      */     }
/*  820 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  822 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  824 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  827 */         this.modifyDate = null;
/*      */     }
/*  829 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  831 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  833 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  836 */         this.modifyTime = null;
/*      */     }
/*  838 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  840 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  842 */         Integer tInteger = new Integer(FValue);
/*  843 */         int i = tInteger.intValue();
/*  844 */         this.int1 = i;
/*      */       }
/*      */     }
/*  847 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  849 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  851 */         Integer tInteger = new Integer(FValue);
/*  852 */         int i = tInteger.intValue();
/*  853 */         this.int2 = i;
/*      */       }
/*      */     }
/*  856 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  858 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  860 */         this.varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  863 */         this.varc1 = null;
/*      */     }
/*  865 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  867 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  869 */         this.varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  872 */         this.varc2 = null;
/*      */     }
/*  874 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  876 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  878 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/*  881 */         this.edorNo = null;
/*      */     }
/*  883 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  885 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  887 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/*  890 */         this.edorType = null;
/*      */     }
/*  892 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  894 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  896 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/*  899 */         this.edorCase = null;
/*      */     }
/*  901 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  903 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  905 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/*  908 */         this.operator2 = null;
/*      */     }
/*  910 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  912 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  914 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  917 */         this.makeDate2 = null;
/*      */     }
/*  919 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  921 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  923 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/*  926 */         this.makeTime2 = null;
/*      */     }
/*  928 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  933 */     if (otherObject == null) return false;
/*  934 */     if (this == otherObject) return true;
/*  935 */     if (getClass() != otherObject.getClass()) return false;
/*  936 */     MUserRoleMapBSchema other = (MUserRoleMapBSchema)otherObject;
/*  937 */     if ((this.iD == null) && (other.getID() != null)) return false;
/*  938 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/*  939 */     if ((this.userCode == null) && (other.getUserCode() != null)) return false;
/*  940 */     if ((this.userCode != null) && (!this.userCode.equals(other.getUserCode()))) return false;
/*  941 */     if ((this.roleID == null) && (other.getRoleID() != null)) return false;
/*  942 */     if ((this.roleID != null) && (!this.roleID.equals(other.getRoleID()))) return false;
/*  943 */     if ((this.type == null) && (other.getType() != null)) return false;
/*  944 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/*  945 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/*  946 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/*  947 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/*  948 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/*  949 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  950 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  951 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  952 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  953 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  954 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  955 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  956 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  957 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  958 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/*  959 */     if (this.int1 != other.getInt1()) return false;
/*  960 */     if (this.int2 != other.getInt2()) return false;
/*  961 */     if ((this.varc1 == null) && (other.getVarc1() != null)) return false;
/*  962 */     if ((this.varc1 != null) && (!this.varc1.equals(other.getVarc1()))) return false;
/*  963 */     if ((this.varc2 == null) && (other.getVarc2() != null)) return false;
/*  964 */     if ((this.varc2 != null) && (!this.varc2.equals(other.getVarc2()))) return false;
/*  965 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/*  966 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/*  967 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/*  968 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/*  969 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/*  970 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/*  971 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/*  972 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/*  973 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/*  974 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/*  975 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/*  976 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  983 */     return 21;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  989 */     if (strFieldName.equals("iD")) {
/*  990 */       return 0;
/*      */     }
/*  992 */     if (strFieldName.equals("userCode")) {
/*  993 */       return 1;
/*      */     }
/*  995 */     if (strFieldName.equals("roleID")) {
/*  996 */       return 2;
/*      */     }
/*  998 */     if (strFieldName.equals("type")) {
/*  999 */       return 3;
/*      */     }
/* 1001 */     if (strFieldName.equals("startDate")) {
/* 1002 */       return 4;
/*      */     }
/* 1004 */     if (strFieldName.equals("endDate")) {
/* 1005 */       return 5;
/*      */     }
/* 1007 */     if (strFieldName.equals("operator")) {
/* 1008 */       return 6;
/*      */     }
/* 1010 */     if (strFieldName.equals("makeDate")) {
/* 1011 */       return 7;
/*      */     }
/* 1013 */     if (strFieldName.equals("makeTime")) {
/* 1014 */       return 8;
/*      */     }
/* 1016 */     if (strFieldName.equals("modifyDate")) {
/* 1017 */       return 9;
/*      */     }
/* 1019 */     if (strFieldName.equals("modifyTime")) {
/* 1020 */       return 10;
/*      */     }
/* 1022 */     if (strFieldName.equals("int1")) {
/* 1023 */       return 11;
/*      */     }
/* 1025 */     if (strFieldName.equals("int2")) {
/* 1026 */       return 12;
/*      */     }
/* 1028 */     if (strFieldName.equals("varc1")) {
/* 1029 */       return 13;
/*      */     }
/* 1031 */     if (strFieldName.equals("varc2")) {
/* 1032 */       return 14;
/*      */     }
/* 1034 */     if (strFieldName.equals("edorNo")) {
/* 1035 */       return 15;
/*      */     }
/* 1037 */     if (strFieldName.equals("edorType")) {
/* 1038 */       return 16;
/*      */     }
/* 1040 */     if (strFieldName.equals("edorCase")) {
/* 1041 */       return 17;
/*      */     }
/* 1043 */     if (strFieldName.equals("operator2")) {
/* 1044 */       return 18;
/*      */     }
/* 1046 */     if (strFieldName.equals("makeDate2")) {
/* 1047 */       return 19;
/*      */     }
/* 1049 */     if (strFieldName.equals("makeTime2")) {
/* 1050 */       return 20;
/*      */     }
/* 1052 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1058 */     String strFieldName = "";
/* 1059 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1061 */       strFieldName = "iD";
/* 1062 */       break;
/*      */     case 1:
/* 1064 */       strFieldName = "userCode";
/* 1065 */       break;
/*      */     case 2:
/* 1067 */       strFieldName = "roleID";
/* 1068 */       break;
/*      */     case 3:
/* 1070 */       strFieldName = "type";
/* 1071 */       break;
/*      */     case 4:
/* 1073 */       strFieldName = "startDate";
/* 1074 */       break;
/*      */     case 5:
/* 1076 */       strFieldName = "endDate";
/* 1077 */       break;
/*      */     case 6:
/* 1079 */       strFieldName = "operator";
/* 1080 */       break;
/*      */     case 7:
/* 1082 */       strFieldName = "makeDate";
/* 1083 */       break;
/*      */     case 8:
/* 1085 */       strFieldName = "makeTime";
/* 1086 */       break;
/*      */     case 9:
/* 1088 */       strFieldName = "modifyDate";
/* 1089 */       break;
/*      */     case 10:
/* 1091 */       strFieldName = "modifyTime";
/* 1092 */       break;
/*      */     case 11:
/* 1094 */       strFieldName = "int1";
/* 1095 */       break;
/*      */     case 12:
/* 1097 */       strFieldName = "int2";
/* 1098 */       break;
/*      */     case 13:
/* 1100 */       strFieldName = "varc1";
/* 1101 */       break;
/*      */     case 14:
/* 1103 */       strFieldName = "varc2";
/* 1104 */       break;
/*      */     case 15:
/* 1106 */       strFieldName = "edorNo";
/* 1107 */       break;
/*      */     case 16:
/* 1109 */       strFieldName = "edorType";
/* 1110 */       break;
/*      */     case 17:
/* 1112 */       strFieldName = "edorCase";
/* 1113 */       break;
/*      */     case 18:
/* 1115 */       strFieldName = "operator2";
/* 1116 */       break;
/*      */     case 19:
/* 1118 */       strFieldName = "makeDate2";
/* 1119 */       break;
/*      */     case 20:
/* 1121 */       strFieldName = "makeTime2";
/* 1122 */       break;
/*      */     default:
/* 1124 */       strFieldName = "";
/*      */     }
/* 1126 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1132 */     if (strFieldName.equals("iD")) {
/* 1133 */       return 0;
/*      */     }
/* 1135 */     if (strFieldName.equals("userCode")) {
/* 1136 */       return 0;
/*      */     }
/* 1138 */     if (strFieldName.equals("roleID")) {
/* 1139 */       return 0;
/*      */     }
/* 1141 */     if (strFieldName.equals("type")) {
/* 1142 */       return 0;
/*      */     }
/* 1144 */     if (strFieldName.equals("startDate")) {
/* 1145 */       return 1;
/*      */     }
/* 1147 */     if (strFieldName.equals("endDate")) {
/* 1148 */       return 1;
/*      */     }
/* 1150 */     if (strFieldName.equals("operator")) {
/* 1151 */       return 0;
/*      */     }
/* 1153 */     if (strFieldName.equals("makeDate")) {
/* 1154 */       return 1;
/*      */     }
/* 1156 */     if (strFieldName.equals("makeTime")) {
/* 1157 */       return 0;
/*      */     }
/* 1159 */     if (strFieldName.equals("modifyDate")) {
/* 1160 */       return 1;
/*      */     }
/* 1162 */     if (strFieldName.equals("modifyTime")) {
/* 1163 */       return 0;
/*      */     }
/* 1165 */     if (strFieldName.equals("int1")) {
/* 1166 */       return 3;
/*      */     }
/* 1168 */     if (strFieldName.equals("int2")) {
/* 1169 */       return 3;
/*      */     }
/* 1171 */     if (strFieldName.equals("varc1")) {
/* 1172 */       return 0;
/*      */     }
/* 1174 */     if (strFieldName.equals("varc2")) {
/* 1175 */       return 0;
/*      */     }
/* 1177 */     if (strFieldName.equals("edorNo")) {
/* 1178 */       return 0;
/*      */     }
/* 1180 */     if (strFieldName.equals("edorType")) {
/* 1181 */       return 0;
/*      */     }
/* 1183 */     if (strFieldName.equals("edorCase")) {
/* 1184 */       return 0;
/*      */     }
/* 1186 */     if (strFieldName.equals("operator2")) {
/* 1187 */       return 0;
/*      */     }
/* 1189 */     if (strFieldName.equals("makeDate2")) {
/* 1190 */       return 1;
/*      */     }
/* 1192 */     if (strFieldName.equals("makeTime2")) {
/* 1193 */       return 0;
/*      */     }
/* 1195 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1201 */     int nFieldType = -1;
/* 1202 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1204 */       nFieldType = 0;
/* 1205 */       break;
/*      */     case 1:
/* 1207 */       nFieldType = 0;
/* 1208 */       break;
/*      */     case 2:
/* 1210 */       nFieldType = 0;
/* 1211 */       break;
/*      */     case 3:
/* 1213 */       nFieldType = 0;
/* 1214 */       break;
/*      */     case 4:
/* 1216 */       nFieldType = 1;
/* 1217 */       break;
/*      */     case 5:
/* 1219 */       nFieldType = 1;
/* 1220 */       break;
/*      */     case 6:
/* 1222 */       nFieldType = 0;
/* 1223 */       break;
/*      */     case 7:
/* 1225 */       nFieldType = 1;
/* 1226 */       break;
/*      */     case 8:
/* 1228 */       nFieldType = 0;
/* 1229 */       break;
/*      */     case 9:
/* 1231 */       nFieldType = 1;
/* 1232 */       break;
/*      */     case 10:
/* 1234 */       nFieldType = 0;
/* 1235 */       break;
/*      */     case 11:
/* 1237 */       nFieldType = 3;
/* 1238 */       break;
/*      */     case 12:
/* 1240 */       nFieldType = 3;
/* 1241 */       break;
/*      */     case 13:
/* 1243 */       nFieldType = 0;
/* 1244 */       break;
/*      */     case 14:
/* 1246 */       nFieldType = 0;
/* 1247 */       break;
/*      */     case 15:
/* 1249 */       nFieldType = 0;
/* 1250 */       break;
/*      */     case 16:
/* 1252 */       nFieldType = 0;
/* 1253 */       break;
/*      */     case 17:
/* 1255 */       nFieldType = 0;
/* 1256 */       break;
/*      */     case 18:
/* 1258 */       nFieldType = 0;
/* 1259 */       break;
/*      */     case 19:
/* 1261 */       nFieldType = 1;
/* 1262 */       break;
/*      */     case 20:
/* 1264 */       nFieldType = 0;
/* 1265 */       break;
/*      */     default:
/* 1267 */       nFieldType = -1;
/*      */     }
/* 1269 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MUserRoleMapBSchema
 * JD-Core Version:    0.6.0
 */