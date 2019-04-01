/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MRoleMenuMapBDB;
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
/*      */ public class MRoleMenuMapBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String roleID;
/*      */   private String menuID;
/*      */   private String type;
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
/*      */   public static final int FIELDNUM = 19;
/*      */   private static String[] PK;
/*   62 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MRoleMenuMapBSchema()
/*      */   {
/*   69 */     this.mErrors = new CErrors();
/*      */ 
/*   71 */     String[] pk = new String[1];
/*   72 */     pk[0] = "EdorNo";
/*      */ 
/*   74 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   81 */     MRoleMenuMapBSchema cloned = (MRoleMenuMapBSchema)super.clone();
/*   82 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   83 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   84 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   90 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*   95 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*   99 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getRoleID() {
/*  103 */     return this.roleID;
/*      */   }
/*      */ 
/*      */   public void setRoleID(String aRoleID) {
/*  107 */     this.roleID = aRoleID;
/*      */   }
/*      */ 
/*      */   public String getMenuID() {
/*  111 */     return this.menuID;
/*      */   }
/*      */ 
/*      */   public void setMenuID(String aMenuID) {
/*  115 */     this.menuID = aMenuID;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  119 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  123 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  127 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  131 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  135 */     if (this.makeDate != null) {
/*  136 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  138 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  142 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  146 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  148 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  151 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  156 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  160 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  164 */     if (this.modifyDate != null) {
/*  165 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  167 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  171 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  175 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  177 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  180 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  185 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  189 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public int getInt1() {
/*  193 */     return this.int1;
/*      */   }
/*      */ 
/*      */   public void setInt1(int aInt1) {
/*  197 */     this.int1 = aInt1;
/*      */   }
/*      */ 
/*      */   public void setInt1(String aInt1) {
/*  201 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*      */     {
/*  203 */       Integer tInteger = new Integer(aInt1);
/*  204 */       int i = tInteger.intValue();
/*  205 */       this.int1 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInt2()
/*      */   {
/*  211 */     return this.int2;
/*      */   }
/*      */ 
/*      */   public void setInt2(int aInt2) {
/*  215 */     this.int2 = aInt2;
/*      */   }
/*      */ 
/*      */   public void setInt2(String aInt2) {
/*  219 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*      */     {
/*  221 */       Integer tInteger = new Integer(aInt2);
/*  222 */       int i = tInteger.intValue();
/*  223 */       this.int2 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getVarc1()
/*      */   {
/*  229 */     return this.varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  233 */     this.varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  237 */     return this.varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  241 */     this.varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  245 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  249 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  253 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  257 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  261 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  265 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  269 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  273 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  277 */     if (this.makeDate2 != null) {
/*  278 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  280 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  284 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  288 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  290 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  293 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  298 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  302 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public void setSchema(MRoleMenuMapBSchema aMRoleMenuMapBSchema)
/*      */   {
/*  308 */     this.iD = aMRoleMenuMapBSchema.getID();
/*  309 */     this.roleID = aMRoleMenuMapBSchema.getRoleID();
/*  310 */     this.menuID = aMRoleMenuMapBSchema.getMenuID();
/*  311 */     this.type = aMRoleMenuMapBSchema.getType();
/*  312 */     this.operator = aMRoleMenuMapBSchema.getOperator();
/*  313 */     this.makeDate = this.fDate.getDate(aMRoleMenuMapBSchema.getMakeDate());
/*  314 */     this.makeTime = aMRoleMenuMapBSchema.getMakeTime();
/*  315 */     this.modifyDate = this.fDate.getDate(aMRoleMenuMapBSchema.getModifyDate());
/*  316 */     this.modifyTime = aMRoleMenuMapBSchema.getModifyTime();
/*  317 */     this.int1 = aMRoleMenuMapBSchema.getInt1();
/*  318 */     this.int2 = aMRoleMenuMapBSchema.getInt2();
/*  319 */     this.varc1 = aMRoleMenuMapBSchema.getVarc1();
/*  320 */     this.varc2 = aMRoleMenuMapBSchema.getVarc2();
/*  321 */     this.edorNo = aMRoleMenuMapBSchema.getEdorNo();
/*  322 */     this.edorType = aMRoleMenuMapBSchema.getEdorType();
/*  323 */     this.edorCase = aMRoleMenuMapBSchema.getEdorCase();
/*  324 */     this.operator2 = aMRoleMenuMapBSchema.getOperator2();
/*  325 */     this.makeDate2 = this.fDate.getDate(aMRoleMenuMapBSchema.getMakeDate2());
/*  326 */     this.makeTime2 = aMRoleMenuMapBSchema.getMakeTime2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  335 */       if (rs.getString("ID") == null)
/*  336 */         this.iD = null;
/*      */       else {
/*  338 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  340 */       if (rs.getString("RoleID") == null)
/*  341 */         this.roleID = null;
/*      */       else {
/*  343 */         this.roleID = rs.getString("RoleID").trim();
/*      */       }
/*  345 */       if (rs.getString("MenuID") == null)
/*  346 */         this.menuID = null;
/*      */       else {
/*  348 */         this.menuID = rs.getString("MenuID").trim();
/*      */       }
/*  350 */       if (rs.getString("Type") == null)
/*  351 */         this.type = null;
/*      */       else {
/*  353 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  355 */       if (rs.getString("Operator") == null)
/*  356 */         this.operator = null;
/*      */       else {
/*  358 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  360 */       this.makeDate = rs.getDate("MakeDate");
/*  361 */       if (rs.getString("MakeTime") == null)
/*  362 */         this.makeTime = null;
/*      */       else {
/*  364 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  366 */       this.modifyDate = rs.getDate("ModifyDate");
/*  367 */       if (rs.getString("ModifyTime") == null)
/*  368 */         this.modifyTime = null;
/*      */       else {
/*  370 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  372 */       this.int1 = rs.getInt("Int1");
/*  373 */       this.int2 = rs.getInt("Int2");
/*  374 */       if (rs.getString("Varc1") == null)
/*  375 */         this.varc1 = null;
/*      */       else {
/*  377 */         this.varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  379 */       if (rs.getString("Varc2") == null)
/*  380 */         this.varc2 = null;
/*      */       else {
/*  382 */         this.varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  384 */       if (rs.getString("EdorNo") == null)
/*  385 */         this.edorNo = null;
/*      */       else {
/*  387 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  389 */       if (rs.getString("EdorType") == null)
/*  390 */         this.edorType = null;
/*      */       else {
/*  392 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  394 */       if (rs.getString("EdorCase") == null)
/*  395 */         this.edorCase = null;
/*      */       else {
/*  397 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  399 */       if (rs.getString("Operator2") == null)
/*  400 */         this.operator2 = null;
/*      */       else {
/*  402 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  404 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  405 */       if (rs.getString("MakeTime2") == null)
/*  406 */         this.makeTime2 = null;
/*      */       else {
/*  408 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  413 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MRoleMenuMapB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  415 */       CError tError = new CError();
/*  416 */       tError.moduleName = "MRoleMenuMapBSchema";
/*  417 */       tError.functionName = "setSchema";
/*  418 */       tError.errorMessage = sqle.toString();
/*  419 */       this.mErrors.addOneError(tError);
/*  420 */       return false;
/*      */     }
/*  422 */     return true;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapBSchema getSchema()
/*      */   {
/*  427 */     MRoleMenuMapBSchema aMRoleMenuMapBSchema = new MRoleMenuMapBSchema();
/*  428 */     aMRoleMenuMapBSchema.setSchema(this);
/*  429 */     return aMRoleMenuMapBSchema;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapBDB getDB()
/*      */   {
/*  434 */     MRoleMenuMapBDB aDBOper = new MRoleMenuMapBDB();
/*  435 */     aDBOper.setSchema(this);
/*  436 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  443 */     StringBuffer strReturn = new StringBuffer(256);
/*  444 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  445 */     strReturn.append(StrTool.cTrim(this.roleID)); strReturn.append("|");
/*  446 */     strReturn.append(StrTool.cTrim(this.menuID)); strReturn.append("|");
/*  447 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  448 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  449 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  450 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  451 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  452 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  453 */     strReturn.append(ChgData.chgData(this.int1)); strReturn.append("|");
/*  454 */     strReturn.append(ChgData.chgData(this.int2)); strReturn.append("|");
/*  455 */     strReturn.append(StrTool.cTrim(this.varc1)); strReturn.append("|");
/*  456 */     strReturn.append(StrTool.cTrim(this.varc2)); strReturn.append("|");
/*  457 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  458 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  459 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  460 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  461 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  462 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/*  463 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  471 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  472 */       this.roleID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  473 */       this.menuID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  474 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  475 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  476 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/*  477 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  478 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/*  479 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  480 */       this.int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/*  481 */       this.int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).intValue();
/*  482 */       this.varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  483 */       this.varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  484 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  485 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  486 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  487 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  488 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*  489 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  494 */       CError tError = new CError();
/*  495 */       tError.moduleName = "MRoleMenuMapBSchema";
/*  496 */       tError.functionName = "decode";
/*  497 */       tError.errorMessage = ex.toString();
/*  498 */       this.mErrors.addOneError(tError);
/*      */ 
/*  500 */       return false;
/*      */     }
/*  502 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  508 */     String strReturn = "";
/*  509 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  511 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  513 */     if (FCode.equalsIgnoreCase("roleID"))
/*      */     {
/*  515 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.roleID));
/*      */     }
/*  517 */     if (FCode.equalsIgnoreCase("menuID"))
/*      */     {
/*  519 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.menuID));
/*      */     }
/*  521 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  523 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  525 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  527 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  529 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  531 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  533 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  535 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  537 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  539 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  541 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  543 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  545 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  547 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int1));
/*      */     }
/*  549 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  551 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int2));
/*      */     }
/*  553 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  555 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc1));
/*      */     }
/*  557 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  559 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc2));
/*      */     }
/*  561 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  563 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  565 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  567 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  569 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  571 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  573 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  575 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  577 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  579 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  581 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  583 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  585 */     if (strReturn.equals(""))
/*      */     {
/*  587 */       strReturn = "null";
/*      */     }
/*      */ 
/*  590 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  597 */     String strFieldValue = "";
/*  598 */     switch (nFieldIndex) {
/*      */     case 0:
/*  600 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  601 */       break;
/*      */     case 1:
/*  603 */       strFieldValue = StrTool.GBKToUnicode(this.roleID);
/*  604 */       break;
/*      */     case 2:
/*  606 */       strFieldValue = StrTool.GBKToUnicode(this.menuID);
/*  607 */       break;
/*      */     case 3:
/*  609 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  610 */       break;
/*      */     case 4:
/*  612 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  613 */       break;
/*      */     case 5:
/*  615 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  616 */       break;
/*      */     case 6:
/*  618 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  619 */       break;
/*      */     case 7:
/*  621 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  622 */       break;
/*      */     case 8:
/*  624 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  625 */       break;
/*      */     case 9:
/*  627 */       strFieldValue = String.valueOf(this.int1);
/*  628 */       break;
/*      */     case 10:
/*  630 */       strFieldValue = String.valueOf(this.int2);
/*  631 */       break;
/*      */     case 11:
/*  633 */       strFieldValue = StrTool.GBKToUnicode(this.varc1);
/*  634 */       break;
/*      */     case 12:
/*  636 */       strFieldValue = StrTool.GBKToUnicode(this.varc2);
/*  637 */       break;
/*      */     case 13:
/*  639 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  640 */       break;
/*      */     case 14:
/*  642 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  643 */       break;
/*      */     case 15:
/*  645 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  646 */       break;
/*      */     case 16:
/*  648 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  649 */       break;
/*      */     case 17:
/*  651 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  652 */       break;
/*      */     case 18:
/*  654 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  655 */       break;
/*      */     default:
/*  657 */       strFieldValue = "";
/*      */     }
/*  659 */     if (strFieldValue.equals("")) {
/*  660 */       strFieldValue = "null";
/*      */     }
/*  662 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  668 */     if (StrTool.cTrim(FCode).equals("")) {
/*  669 */       return false;
/*      */     }
/*  671 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  673 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  675 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  678 */         this.iD = null;
/*      */     }
/*  680 */     if (FCode.equalsIgnoreCase("roleID"))
/*      */     {
/*  682 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  684 */         this.roleID = FValue.trim();
/*      */       }
/*      */       else
/*  687 */         this.roleID = null;
/*      */     }
/*  689 */     if (FCode.equalsIgnoreCase("menuID"))
/*      */     {
/*  691 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  693 */         this.menuID = FValue.trim();
/*      */       }
/*      */       else
/*  696 */         this.menuID = null;
/*      */     }
/*  698 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  700 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  702 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/*  705 */         this.type = null;
/*      */     }
/*  707 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  709 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  711 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  714 */         this.operator = null;
/*      */     }
/*  716 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  718 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  720 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  723 */         this.makeDate = null;
/*      */     }
/*  725 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  727 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  729 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  732 */         this.makeTime = null;
/*      */     }
/*  734 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  736 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  738 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  741 */         this.modifyDate = null;
/*      */     }
/*  743 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  745 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  747 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  750 */         this.modifyTime = null;
/*      */     }
/*  752 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  754 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  756 */         Integer tInteger = new Integer(FValue);
/*  757 */         int i = tInteger.intValue();
/*  758 */         this.int1 = i;
/*      */       }
/*      */     }
/*  761 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  763 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  765 */         Integer tInteger = new Integer(FValue);
/*  766 */         int i = tInteger.intValue();
/*  767 */         this.int2 = i;
/*      */       }
/*      */     }
/*  770 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  772 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  774 */         this.varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  777 */         this.varc1 = null;
/*      */     }
/*  779 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  781 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  783 */         this.varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  786 */         this.varc2 = null;
/*      */     }
/*  788 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  790 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  792 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/*  795 */         this.edorNo = null;
/*      */     }
/*  797 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  799 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  801 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/*  804 */         this.edorType = null;
/*      */     }
/*  806 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  808 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  810 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/*  813 */         this.edorCase = null;
/*      */     }
/*  815 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  817 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  819 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/*  822 */         this.operator2 = null;
/*      */     }
/*  824 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  826 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  828 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  831 */         this.makeDate2 = null;
/*      */     }
/*  833 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  835 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  837 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/*  840 */         this.makeTime2 = null;
/*      */     }
/*  842 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  847 */     if (otherObject == null) return false;
/*  848 */     if (this == otherObject) return true;
/*  849 */     if (getClass() != otherObject.getClass()) return false;
/*  850 */     MRoleMenuMapBSchema other = (MRoleMenuMapBSchema)otherObject;
/*  851 */     if ((this.iD == null) && (other.getID() != null)) return false;
/*  852 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/*  853 */     if ((this.roleID == null) && (other.getRoleID() != null)) return false;
/*  854 */     if ((this.roleID != null) && (!this.roleID.equals(other.getRoleID()))) return false;
/*  855 */     if ((this.menuID == null) && (other.getMenuID() != null)) return false;
/*  856 */     if ((this.menuID != null) && (!this.menuID.equals(other.getMenuID()))) return false;
/*  857 */     if ((this.type == null) && (other.getType() != null)) return false;
/*  858 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/*  859 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  860 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  861 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  862 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  863 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  864 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  865 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  866 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  867 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  868 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/*  869 */     if (this.int1 != other.getInt1()) return false;
/*  870 */     if (this.int2 != other.getInt2()) return false;
/*  871 */     if ((this.varc1 == null) && (other.getVarc1() != null)) return false;
/*  872 */     if ((this.varc1 != null) && (!this.varc1.equals(other.getVarc1()))) return false;
/*  873 */     if ((this.varc2 == null) && (other.getVarc2() != null)) return false;
/*  874 */     if ((this.varc2 != null) && (!this.varc2.equals(other.getVarc2()))) return false;
/*  875 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/*  876 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/*  877 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/*  878 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/*  879 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/*  880 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/*  881 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/*  882 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/*  883 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/*  884 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/*  885 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/*  886 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  893 */     return 19;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  899 */     if (strFieldName.equals("iD")) {
/*  900 */       return 0;
/*      */     }
/*  902 */     if (strFieldName.equals("roleID")) {
/*  903 */       return 1;
/*      */     }
/*  905 */     if (strFieldName.equals("menuID")) {
/*  906 */       return 2;
/*      */     }
/*  908 */     if (strFieldName.equals("type")) {
/*  909 */       return 3;
/*      */     }
/*  911 */     if (strFieldName.equals("operator")) {
/*  912 */       return 4;
/*      */     }
/*  914 */     if (strFieldName.equals("makeDate")) {
/*  915 */       return 5;
/*      */     }
/*  917 */     if (strFieldName.equals("makeTime")) {
/*  918 */       return 6;
/*      */     }
/*  920 */     if (strFieldName.equals("modifyDate")) {
/*  921 */       return 7;
/*      */     }
/*  923 */     if (strFieldName.equals("modifyTime")) {
/*  924 */       return 8;
/*      */     }
/*  926 */     if (strFieldName.equals("int1")) {
/*  927 */       return 9;
/*      */     }
/*  929 */     if (strFieldName.equals("int2")) {
/*  930 */       return 10;
/*      */     }
/*  932 */     if (strFieldName.equals("varc1")) {
/*  933 */       return 11;
/*      */     }
/*  935 */     if (strFieldName.equals("varc2")) {
/*  936 */       return 12;
/*      */     }
/*  938 */     if (strFieldName.equals("edorNo")) {
/*  939 */       return 13;
/*      */     }
/*  941 */     if (strFieldName.equals("edorType")) {
/*  942 */       return 14;
/*      */     }
/*  944 */     if (strFieldName.equals("edorCase")) {
/*  945 */       return 15;
/*      */     }
/*  947 */     if (strFieldName.equals("operator2")) {
/*  948 */       return 16;
/*      */     }
/*  950 */     if (strFieldName.equals("makeDate2")) {
/*  951 */       return 17;
/*      */     }
/*  953 */     if (strFieldName.equals("makeTime2")) {
/*  954 */       return 18;
/*      */     }
/*  956 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  962 */     String strFieldName = "";
/*  963 */     switch (nFieldIndex) {
/*      */     case 0:
/*  965 */       strFieldName = "iD";
/*  966 */       break;
/*      */     case 1:
/*  968 */       strFieldName = "roleID";
/*  969 */       break;
/*      */     case 2:
/*  971 */       strFieldName = "menuID";
/*  972 */       break;
/*      */     case 3:
/*  974 */       strFieldName = "type";
/*  975 */       break;
/*      */     case 4:
/*  977 */       strFieldName = "operator";
/*  978 */       break;
/*      */     case 5:
/*  980 */       strFieldName = "makeDate";
/*  981 */       break;
/*      */     case 6:
/*  983 */       strFieldName = "makeTime";
/*  984 */       break;
/*      */     case 7:
/*  986 */       strFieldName = "modifyDate";
/*  987 */       break;
/*      */     case 8:
/*  989 */       strFieldName = "modifyTime";
/*  990 */       break;
/*      */     case 9:
/*  992 */       strFieldName = "int1";
/*  993 */       break;
/*      */     case 10:
/*  995 */       strFieldName = "int2";
/*  996 */       break;
/*      */     case 11:
/*  998 */       strFieldName = "varc1";
/*  999 */       break;
/*      */     case 12:
/* 1001 */       strFieldName = "varc2";
/* 1002 */       break;
/*      */     case 13:
/* 1004 */       strFieldName = "edorNo";
/* 1005 */       break;
/*      */     case 14:
/* 1007 */       strFieldName = "edorType";
/* 1008 */       break;
/*      */     case 15:
/* 1010 */       strFieldName = "edorCase";
/* 1011 */       break;
/*      */     case 16:
/* 1013 */       strFieldName = "operator2";
/* 1014 */       break;
/*      */     case 17:
/* 1016 */       strFieldName = "makeDate2";
/* 1017 */       break;
/*      */     case 18:
/* 1019 */       strFieldName = "makeTime2";
/* 1020 */       break;
/*      */     default:
/* 1022 */       strFieldName = "";
/*      */     }
/* 1024 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1030 */     if (strFieldName.equals("iD")) {
/* 1031 */       return 0;
/*      */     }
/* 1033 */     if (strFieldName.equals("roleID")) {
/* 1034 */       return 0;
/*      */     }
/* 1036 */     if (strFieldName.equals("menuID")) {
/* 1037 */       return 0;
/*      */     }
/* 1039 */     if (strFieldName.equals("type")) {
/* 1040 */       return 0;
/*      */     }
/* 1042 */     if (strFieldName.equals("operator")) {
/* 1043 */       return 0;
/*      */     }
/* 1045 */     if (strFieldName.equals("makeDate")) {
/* 1046 */       return 1;
/*      */     }
/* 1048 */     if (strFieldName.equals("makeTime")) {
/* 1049 */       return 0;
/*      */     }
/* 1051 */     if (strFieldName.equals("modifyDate")) {
/* 1052 */       return 1;
/*      */     }
/* 1054 */     if (strFieldName.equals("modifyTime")) {
/* 1055 */       return 0;
/*      */     }
/* 1057 */     if (strFieldName.equals("int1")) {
/* 1058 */       return 3;
/*      */     }
/* 1060 */     if (strFieldName.equals("int2")) {
/* 1061 */       return 3;
/*      */     }
/* 1063 */     if (strFieldName.equals("varc1")) {
/* 1064 */       return 0;
/*      */     }
/* 1066 */     if (strFieldName.equals("varc2")) {
/* 1067 */       return 0;
/*      */     }
/* 1069 */     if (strFieldName.equals("edorNo")) {
/* 1070 */       return 0;
/*      */     }
/* 1072 */     if (strFieldName.equals("edorType")) {
/* 1073 */       return 0;
/*      */     }
/* 1075 */     if (strFieldName.equals("edorCase")) {
/* 1076 */       return 0;
/*      */     }
/* 1078 */     if (strFieldName.equals("operator2")) {
/* 1079 */       return 0;
/*      */     }
/* 1081 */     if (strFieldName.equals("makeDate2")) {
/* 1082 */       return 1;
/*      */     }
/* 1084 */     if (strFieldName.equals("makeTime2")) {
/* 1085 */       return 0;
/*      */     }
/* 1087 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1093 */     int nFieldType = -1;
/* 1094 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1096 */       nFieldType = 0;
/* 1097 */       break;
/*      */     case 1:
/* 1099 */       nFieldType = 0;
/* 1100 */       break;
/*      */     case 2:
/* 1102 */       nFieldType = 0;
/* 1103 */       break;
/*      */     case 3:
/* 1105 */       nFieldType = 0;
/* 1106 */       break;
/*      */     case 4:
/* 1108 */       nFieldType = 0;
/* 1109 */       break;
/*      */     case 5:
/* 1111 */       nFieldType = 1;
/* 1112 */       break;
/*      */     case 6:
/* 1114 */       nFieldType = 0;
/* 1115 */       break;
/*      */     case 7:
/* 1117 */       nFieldType = 1;
/* 1118 */       break;
/*      */     case 8:
/* 1120 */       nFieldType = 0;
/* 1121 */       break;
/*      */     case 9:
/* 1123 */       nFieldType = 3;
/* 1124 */       break;
/*      */     case 10:
/* 1126 */       nFieldType = 3;
/* 1127 */       break;
/*      */     case 11:
/* 1129 */       nFieldType = 0;
/* 1130 */       break;
/*      */     case 12:
/* 1132 */       nFieldType = 0;
/* 1133 */       break;
/*      */     case 13:
/* 1135 */       nFieldType = 0;
/* 1136 */       break;
/*      */     case 14:
/* 1138 */       nFieldType = 0;
/* 1139 */       break;
/*      */     case 15:
/* 1141 */       nFieldType = 0;
/* 1142 */       break;
/*      */     case 16:
/* 1144 */       nFieldType = 0;
/* 1145 */       break;
/*      */     case 17:
/* 1147 */       nFieldType = 1;
/* 1148 */       break;
/*      */     case 18:
/* 1150 */       nFieldType = 0;
/* 1151 */       break;
/*      */     default:
/* 1153 */       nFieldType = -1;
/*      */     }
/* 1155 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MRoleMenuMapBSchema
 * JD-Core Version:    0.6.0
 */