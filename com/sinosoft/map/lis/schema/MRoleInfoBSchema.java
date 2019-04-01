/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MRoleInfoBDB;
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
/*      */ public class MRoleInfoBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String roleCode;
/*      */   private String name;
/*      */   private String parent;
/*      */   private String describe;
/*      */   private String roleState;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private int int1;
/*      */   private int int2;
/*      */   private String varc1;
/*      */   private String varc2;
/*      */   private String varc3;
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   public static final int FIELDNUM = 22;
/*      */   private static String[] PK;
/*   68 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MRoleInfoBSchema()
/*      */   {
/*   75 */     this.mErrors = new CErrors();
/*      */ 
/*   77 */     String[] pk = new String[1];
/*   78 */     pk[0] = "EdorNo";
/*      */ 
/*   80 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   87 */     MRoleInfoBSchema cloned = (MRoleInfoBSchema)super.clone();
/*   88 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   89 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   90 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   96 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  101 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  105 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getRoleCode() {
/*  109 */     return this.roleCode;
/*      */   }
/*      */ 
/*      */   public void setRoleCode(String aRoleCode) {
/*  113 */     this.roleCode = aRoleCode;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  117 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  121 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getParent() {
/*  125 */     return this.parent;
/*      */   }
/*      */ 
/*      */   public void setParent(String aParent) {
/*  129 */     this.parent = aParent;
/*      */   }
/*      */ 
/*      */   public String getDescribe() {
/*  133 */     return this.describe;
/*      */   }
/*      */ 
/*      */   public void setDescribe(String aDescribe) {
/*  137 */     this.describe = aDescribe;
/*      */   }
/*      */ 
/*      */   public String getRoleState() {
/*  141 */     return this.roleState;
/*      */   }
/*      */ 
/*      */   public void setRoleState(String aRoleState) {
/*  145 */     this.roleState = aRoleState;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  149 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  153 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  157 */     if (this.makeDate != null) {
/*  158 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  160 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  164 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  168 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  170 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  173 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  178 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  182 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  186 */     if (this.modifyDate != null) {
/*  187 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  189 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  193 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  197 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  199 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  202 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  207 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  211 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public int getInt1() {
/*  215 */     return this.int1;
/*      */   }
/*      */ 
/*      */   public void setInt1(int aInt1) {
/*  219 */     this.int1 = aInt1;
/*      */   }
/*      */ 
/*      */   public void setInt1(String aInt1) {
/*  223 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*      */     {
/*  225 */       Integer tInteger = new Integer(aInt1);
/*  226 */       int i = tInteger.intValue();
/*  227 */       this.int1 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInt2()
/*      */   {
/*  233 */     return this.int2;
/*      */   }
/*      */ 
/*      */   public void setInt2(int aInt2) {
/*  237 */     this.int2 = aInt2;
/*      */   }
/*      */ 
/*      */   public void setInt2(String aInt2) {
/*  241 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*      */     {
/*  243 */       Integer tInteger = new Integer(aInt2);
/*  244 */       int i = tInteger.intValue();
/*  245 */       this.int2 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getVarc1()
/*      */   {
/*  251 */     return this.varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  255 */     this.varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  259 */     return this.varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  263 */     this.varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getVarc3() {
/*  267 */     return this.varc3;
/*      */   }
/*      */ 
/*      */   public void setVarc3(String aVarc3) {
/*  271 */     this.varc3 = aVarc3;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  275 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  279 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  283 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  287 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  291 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  295 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  299 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  303 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  307 */     if (this.makeDate2 != null) {
/*  308 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  310 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  314 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  318 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  320 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  323 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  328 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  332 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public void setSchema(MRoleInfoBSchema aMRoleInfoBSchema)
/*      */   {
/*  338 */     this.iD = aMRoleInfoBSchema.getID();
/*  339 */     this.roleCode = aMRoleInfoBSchema.getRoleCode();
/*  340 */     this.name = aMRoleInfoBSchema.getName();
/*  341 */     this.parent = aMRoleInfoBSchema.getParent();
/*  342 */     this.describe = aMRoleInfoBSchema.getDescribe();
/*  343 */     this.roleState = aMRoleInfoBSchema.getRoleState();
/*  344 */     this.operator = aMRoleInfoBSchema.getOperator();
/*  345 */     this.makeDate = this.fDate.getDate(aMRoleInfoBSchema.getMakeDate());
/*  346 */     this.makeTime = aMRoleInfoBSchema.getMakeTime();
/*  347 */     this.modifyDate = this.fDate.getDate(aMRoleInfoBSchema.getModifyDate());
/*  348 */     this.modifyTime = aMRoleInfoBSchema.getModifyTime();
/*  349 */     this.int1 = aMRoleInfoBSchema.getInt1();
/*  350 */     this.int2 = aMRoleInfoBSchema.getInt2();
/*  351 */     this.varc1 = aMRoleInfoBSchema.getVarc1();
/*  352 */     this.varc2 = aMRoleInfoBSchema.getVarc2();
/*  353 */     this.varc3 = aMRoleInfoBSchema.getVarc3();
/*  354 */     this.edorNo = aMRoleInfoBSchema.getEdorNo();
/*  355 */     this.edorType = aMRoleInfoBSchema.getEdorType();
/*  356 */     this.edorCase = aMRoleInfoBSchema.getEdorCase();
/*  357 */     this.operator2 = aMRoleInfoBSchema.getOperator2();
/*  358 */     this.makeDate2 = this.fDate.getDate(aMRoleInfoBSchema.getMakeDate2());
/*  359 */     this.makeTime2 = aMRoleInfoBSchema.getMakeTime2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  368 */       if (rs.getString("ID") == null)
/*  369 */         this.iD = null;
/*      */       else {
/*  371 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  373 */       if (rs.getString("RoleCode") == null)
/*  374 */         this.roleCode = null;
/*      */       else {
/*  376 */         this.roleCode = rs.getString("RoleCode").trim();
/*      */       }
/*  378 */       if (rs.getString("Name") == null)
/*  379 */         this.name = null;
/*      */       else {
/*  381 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  383 */       if (rs.getString("Parent") == null)
/*  384 */         this.parent = null;
/*      */       else {
/*  386 */         this.parent = rs.getString("Parent").trim();
/*      */       }
/*  388 */       if (rs.getString("Describe") == null)
/*  389 */         this.describe = null;
/*      */       else {
/*  391 */         this.describe = rs.getString("Describe").trim();
/*      */       }
/*  393 */       if (rs.getString("RoleState") == null)
/*  394 */         this.roleState = null;
/*      */       else {
/*  396 */         this.roleState = rs.getString("RoleState").trim();
/*      */       }
/*  398 */       if (rs.getString("Operator") == null)
/*  399 */         this.operator = null;
/*      */       else {
/*  401 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  403 */       this.makeDate = rs.getDate("MakeDate");
/*  404 */       if (rs.getString("MakeTime") == null)
/*  405 */         this.makeTime = null;
/*      */       else {
/*  407 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  409 */       this.modifyDate = rs.getDate("ModifyDate");
/*  410 */       if (rs.getString("ModifyTime") == null)
/*  411 */         this.modifyTime = null;
/*      */       else {
/*  413 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  415 */       this.int1 = rs.getInt("Int1");
/*  416 */       this.int2 = rs.getInt("Int2");
/*  417 */       if (rs.getString("Varc1") == null)
/*  418 */         this.varc1 = null;
/*      */       else {
/*  420 */         this.varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  422 */       if (rs.getString("Varc2") == null)
/*  423 */         this.varc2 = null;
/*      */       else {
/*  425 */         this.varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  427 */       if (rs.getString("Varc3") == null)
/*  428 */         this.varc3 = null;
/*      */       else {
/*  430 */         this.varc3 = rs.getString("Varc3").trim();
/*      */       }
/*  432 */       if (rs.getString("EdorNo") == null)
/*  433 */         this.edorNo = null;
/*      */       else {
/*  435 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  437 */       if (rs.getString("EdorType") == null)
/*  438 */         this.edorType = null;
/*      */       else {
/*  440 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  442 */       if (rs.getString("EdorCase") == null)
/*  443 */         this.edorCase = null;
/*      */       else {
/*  445 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  447 */       if (rs.getString("Operator2") == null)
/*  448 */         this.operator2 = null;
/*      */       else {
/*  450 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  452 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  453 */       if (rs.getString("MakeTime2") == null)
/*  454 */         this.makeTime2 = null;
/*      */       else {
/*  456 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  461 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MRoleInfoB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  463 */       CError tError = new CError();
/*  464 */       tError.moduleName = "MRoleInfoBSchema";
/*  465 */       tError.functionName = "setSchema";
/*  466 */       tError.errorMessage = sqle.toString();
/*  467 */       this.mErrors.addOneError(tError);
/*  468 */       return false;
/*      */     }
/*  470 */     return true;
/*      */   }
/*      */ 
/*      */   public MRoleInfoBSchema getSchema()
/*      */   {
/*  475 */     MRoleInfoBSchema aMRoleInfoBSchema = new MRoleInfoBSchema();
/*  476 */     aMRoleInfoBSchema.setSchema(this);
/*  477 */     return aMRoleInfoBSchema;
/*      */   }
/*      */ 
/*      */   public MRoleInfoBDB getDB()
/*      */   {
/*  482 */     MRoleInfoBDB aDBOper = new MRoleInfoBDB();
/*  483 */     aDBOper.setSchema(this);
/*  484 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  491 */     StringBuffer strReturn = new StringBuffer(256);
/*  492 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  493 */     strReturn.append(StrTool.cTrim(this.roleCode)); strReturn.append("|");
/*  494 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  495 */     strReturn.append(StrTool.cTrim(this.parent)); strReturn.append("|");
/*  496 */     strReturn.append(StrTool.cTrim(this.describe)); strReturn.append("|");
/*  497 */     strReturn.append(StrTool.cTrim(this.roleState)); strReturn.append("|");
/*  498 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  499 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  500 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  501 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  502 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  503 */     strReturn.append(ChgData.chgData(this.int1)); strReturn.append("|");
/*  504 */     strReturn.append(ChgData.chgData(this.int2)); strReturn.append("|");
/*  505 */     strReturn.append(StrTool.cTrim(this.varc1)); strReturn.append("|");
/*  506 */     strReturn.append(StrTool.cTrim(this.varc2)); strReturn.append("|");
/*  507 */     strReturn.append(StrTool.cTrim(this.varc3)); strReturn.append("|");
/*  508 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  509 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  510 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  511 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  512 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  513 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/*  514 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  522 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  523 */       this.roleCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  524 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  525 */       this.parent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  526 */       this.describe = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  527 */       this.roleState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  528 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  529 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/*  530 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  531 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*  532 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  533 */       this.int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).intValue();
/*  534 */       this.int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).intValue();
/*  535 */       this.varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  536 */       this.varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  537 */       this.varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  538 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  539 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  540 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  541 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  542 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
/*  543 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  548 */       CError tError = new CError();
/*  549 */       tError.moduleName = "MRoleInfoBSchema";
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
/*  567 */     if (FCode.equalsIgnoreCase("roleCode"))
/*      */     {
/*  569 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.roleCode));
/*      */     }
/*  571 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  573 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  575 */     if (FCode.equalsIgnoreCase("parent"))
/*      */     {
/*  577 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.parent));
/*      */     }
/*  579 */     if (FCode.equalsIgnoreCase("describe"))
/*      */     {
/*  581 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.describe));
/*      */     }
/*  583 */     if (FCode.equalsIgnoreCase("roleState"))
/*      */     {
/*  585 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.roleState));
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
/*  623 */     if (FCode.equalsIgnoreCase("varc3"))
/*      */     {
/*  625 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc3));
/*      */     }
/*  627 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  629 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  631 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  633 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  635 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  637 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  639 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  641 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  643 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  645 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  647 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  649 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  651 */     if (strReturn.equals(""))
/*      */     {
/*  653 */       strReturn = "null";
/*      */     }
/*      */ 
/*  656 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  663 */     String strFieldValue = "";
/*  664 */     switch (nFieldIndex) {
/*      */     case 0:
/*  666 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  667 */       break;
/*      */     case 1:
/*  669 */       strFieldValue = StrTool.GBKToUnicode(this.roleCode);
/*  670 */       break;
/*      */     case 2:
/*  672 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  673 */       break;
/*      */     case 3:
/*  675 */       strFieldValue = StrTool.GBKToUnicode(this.parent);
/*  676 */       break;
/*      */     case 4:
/*  678 */       strFieldValue = StrTool.GBKToUnicode(this.describe);
/*  679 */       break;
/*      */     case 5:
/*  681 */       strFieldValue = StrTool.GBKToUnicode(this.roleState);
/*  682 */       break;
/*      */     case 6:
/*  684 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  685 */       break;
/*      */     case 7:
/*  687 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  688 */       break;
/*      */     case 8:
/*  690 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  691 */       break;
/*      */     case 9:
/*  693 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  694 */       break;
/*      */     case 10:
/*  696 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  697 */       break;
/*      */     case 11:
/*  699 */       strFieldValue = String.valueOf(this.int1);
/*  700 */       break;
/*      */     case 12:
/*  702 */       strFieldValue = String.valueOf(this.int2);
/*  703 */       break;
/*      */     case 13:
/*  705 */       strFieldValue = StrTool.GBKToUnicode(this.varc1);
/*  706 */       break;
/*      */     case 14:
/*  708 */       strFieldValue = StrTool.GBKToUnicode(this.varc2);
/*  709 */       break;
/*      */     case 15:
/*  711 */       strFieldValue = StrTool.GBKToUnicode(this.varc3);
/*  712 */       break;
/*      */     case 16:
/*  714 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  715 */       break;
/*      */     case 17:
/*  717 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  718 */       break;
/*      */     case 18:
/*  720 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  721 */       break;
/*      */     case 19:
/*  723 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  724 */       break;
/*      */     case 20:
/*  726 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  727 */       break;
/*      */     case 21:
/*  729 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  730 */       break;
/*      */     default:
/*  732 */       strFieldValue = "";
/*      */     }
/*  734 */     if (strFieldValue.equals("")) {
/*  735 */       strFieldValue = "null";
/*      */     }
/*  737 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  743 */     if (StrTool.cTrim(FCode).equals("")) {
/*  744 */       return false;
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  748 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  750 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  753 */         this.iD = null;
/*      */     }
/*  755 */     if (FCode.equalsIgnoreCase("roleCode"))
/*      */     {
/*  757 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  759 */         this.roleCode = FValue.trim();
/*      */       }
/*      */       else
/*  762 */         this.roleCode = null;
/*      */     }
/*  764 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  766 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  768 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  771 */         this.name = null;
/*      */     }
/*  773 */     if (FCode.equalsIgnoreCase("parent"))
/*      */     {
/*  775 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  777 */         this.parent = FValue.trim();
/*      */       }
/*      */       else
/*  780 */         this.parent = null;
/*      */     }
/*  782 */     if (FCode.equalsIgnoreCase("describe"))
/*      */     {
/*  784 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  786 */         this.describe = FValue.trim();
/*      */       }
/*      */       else
/*  789 */         this.describe = null;
/*      */     }
/*  791 */     if (FCode.equalsIgnoreCase("roleState"))
/*      */     {
/*  793 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  795 */         this.roleState = FValue.trim();
/*      */       }
/*      */       else
/*  798 */         this.roleState = null;
/*      */     }
/*  800 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  802 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  804 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  807 */         this.operator = null;
/*      */     }
/*  809 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  811 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  813 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  816 */         this.makeDate = null;
/*      */     }
/*  818 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  820 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  822 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  825 */         this.makeTime = null;
/*      */     }
/*  827 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  829 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  831 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  834 */         this.modifyDate = null;
/*      */     }
/*  836 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  838 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  840 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  843 */         this.modifyTime = null;
/*      */     }
/*  845 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  847 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  849 */         Integer tInteger = new Integer(FValue);
/*  850 */         int i = tInteger.intValue();
/*  851 */         this.int1 = i;
/*      */       }
/*      */     }
/*  854 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  856 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  858 */         Integer tInteger = new Integer(FValue);
/*  859 */         int i = tInteger.intValue();
/*  860 */         this.int2 = i;
/*      */       }
/*      */     }
/*  863 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  865 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  867 */         this.varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  870 */         this.varc1 = null;
/*      */     }
/*  872 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  874 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  876 */         this.varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  879 */         this.varc2 = null;
/*      */     }
/*  881 */     if (FCode.equalsIgnoreCase("varc3"))
/*      */     {
/*  883 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  885 */         this.varc3 = FValue.trim();
/*      */       }
/*      */       else
/*  888 */         this.varc3 = null;
/*      */     }
/*  890 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  892 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  894 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/*  897 */         this.edorNo = null;
/*      */     }
/*  899 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  901 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  903 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/*  906 */         this.edorType = null;
/*      */     }
/*  908 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  910 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  912 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/*  915 */         this.edorCase = null;
/*      */     }
/*  917 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  919 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  921 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/*  924 */         this.operator2 = null;
/*      */     }
/*  926 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  928 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  930 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  933 */         this.makeDate2 = null;
/*      */     }
/*  935 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  937 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  939 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/*  942 */         this.makeTime2 = null;
/*      */     }
/*  944 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  949 */     if (otherObject == null) return false;
/*  950 */     if (this == otherObject) return true;
/*  951 */     if (getClass() != otherObject.getClass()) return false;
/*  952 */     MRoleInfoBSchema other = (MRoleInfoBSchema)otherObject;
/*  953 */     if ((this.iD == null) && (other.getID() != null)) return false;
/*  954 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/*  955 */     if ((this.roleCode == null) && (other.getRoleCode() != null)) return false;
/*  956 */     if ((this.roleCode != null) && (!this.roleCode.equals(other.getRoleCode()))) return false;
/*  957 */     if ((this.name == null) && (other.getName() != null)) return false;
/*  958 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/*  959 */     if ((this.parent == null) && (other.getParent() != null)) return false;
/*  960 */     if ((this.parent != null) && (!this.parent.equals(other.getParent()))) return false;
/*  961 */     if ((this.describe == null) && (other.getDescribe() != null)) return false;
/*  962 */     if ((this.describe != null) && (!this.describe.equals(other.getDescribe()))) return false;
/*  963 */     if ((this.roleState == null) && (other.getRoleState() != null)) return false;
/*  964 */     if ((this.roleState != null) && (!this.roleState.equals(other.getRoleState()))) return false;
/*  965 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  966 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  967 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  968 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  969 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  970 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  971 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  972 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  973 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  974 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/*  975 */     if (this.int1 != other.getInt1()) return false;
/*  976 */     if (this.int2 != other.getInt2()) return false;
/*  977 */     if ((this.varc1 == null) && (other.getVarc1() != null)) return false;
/*  978 */     if ((this.varc1 != null) && (!this.varc1.equals(other.getVarc1()))) return false;
/*  979 */     if ((this.varc2 == null) && (other.getVarc2() != null)) return false;
/*  980 */     if ((this.varc2 != null) && (!this.varc2.equals(other.getVarc2()))) return false;
/*  981 */     if ((this.varc3 == null) && (other.getVarc3() != null)) return false;
/*  982 */     if ((this.varc3 != null) && (!this.varc3.equals(other.getVarc3()))) return false;
/*  983 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/*  984 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/*  985 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/*  986 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/*  987 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/*  988 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/*  989 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/*  990 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/*  991 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/*  992 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/*  993 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/*  994 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1001 */     return 22;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1007 */     if (strFieldName.equals("iD")) {
/* 1008 */       return 0;
/*      */     }
/* 1010 */     if (strFieldName.equals("roleCode")) {
/* 1011 */       return 1;
/*      */     }
/* 1013 */     if (strFieldName.equals("name")) {
/* 1014 */       return 2;
/*      */     }
/* 1016 */     if (strFieldName.equals("parent")) {
/* 1017 */       return 3;
/*      */     }
/* 1019 */     if (strFieldName.equals("describe")) {
/* 1020 */       return 4;
/*      */     }
/* 1022 */     if (strFieldName.equals("roleState")) {
/* 1023 */       return 5;
/*      */     }
/* 1025 */     if (strFieldName.equals("operator")) {
/* 1026 */       return 6;
/*      */     }
/* 1028 */     if (strFieldName.equals("makeDate")) {
/* 1029 */       return 7;
/*      */     }
/* 1031 */     if (strFieldName.equals("makeTime")) {
/* 1032 */       return 8;
/*      */     }
/* 1034 */     if (strFieldName.equals("modifyDate")) {
/* 1035 */       return 9;
/*      */     }
/* 1037 */     if (strFieldName.equals("modifyTime")) {
/* 1038 */       return 10;
/*      */     }
/* 1040 */     if (strFieldName.equals("int1")) {
/* 1041 */       return 11;
/*      */     }
/* 1043 */     if (strFieldName.equals("int2")) {
/* 1044 */       return 12;
/*      */     }
/* 1046 */     if (strFieldName.equals("varc1")) {
/* 1047 */       return 13;
/*      */     }
/* 1049 */     if (strFieldName.equals("varc2")) {
/* 1050 */       return 14;
/*      */     }
/* 1052 */     if (strFieldName.equals("varc3")) {
/* 1053 */       return 15;
/*      */     }
/* 1055 */     if (strFieldName.equals("edorNo")) {
/* 1056 */       return 16;
/*      */     }
/* 1058 */     if (strFieldName.equals("edorType")) {
/* 1059 */       return 17;
/*      */     }
/* 1061 */     if (strFieldName.equals("edorCase")) {
/* 1062 */       return 18;
/*      */     }
/* 1064 */     if (strFieldName.equals("operator2")) {
/* 1065 */       return 19;
/*      */     }
/* 1067 */     if (strFieldName.equals("makeDate2")) {
/* 1068 */       return 20;
/*      */     }
/* 1070 */     if (strFieldName.equals("makeTime2")) {
/* 1071 */       return 21;
/*      */     }
/* 1073 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1079 */     String strFieldName = "";
/* 1080 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1082 */       strFieldName = "iD";
/* 1083 */       break;
/*      */     case 1:
/* 1085 */       strFieldName = "roleCode";
/* 1086 */       break;
/*      */     case 2:
/* 1088 */       strFieldName = "name";
/* 1089 */       break;
/*      */     case 3:
/* 1091 */       strFieldName = "parent";
/* 1092 */       break;
/*      */     case 4:
/* 1094 */       strFieldName = "describe";
/* 1095 */       break;
/*      */     case 5:
/* 1097 */       strFieldName = "roleState";
/* 1098 */       break;
/*      */     case 6:
/* 1100 */       strFieldName = "operator";
/* 1101 */       break;
/*      */     case 7:
/* 1103 */       strFieldName = "makeDate";
/* 1104 */       break;
/*      */     case 8:
/* 1106 */       strFieldName = "makeTime";
/* 1107 */       break;
/*      */     case 9:
/* 1109 */       strFieldName = "modifyDate";
/* 1110 */       break;
/*      */     case 10:
/* 1112 */       strFieldName = "modifyTime";
/* 1113 */       break;
/*      */     case 11:
/* 1115 */       strFieldName = "int1";
/* 1116 */       break;
/*      */     case 12:
/* 1118 */       strFieldName = "int2";
/* 1119 */       break;
/*      */     case 13:
/* 1121 */       strFieldName = "varc1";
/* 1122 */       break;
/*      */     case 14:
/* 1124 */       strFieldName = "varc2";
/* 1125 */       break;
/*      */     case 15:
/* 1127 */       strFieldName = "varc3";
/* 1128 */       break;
/*      */     case 16:
/* 1130 */       strFieldName = "edorNo";
/* 1131 */       break;
/*      */     case 17:
/* 1133 */       strFieldName = "edorType";
/* 1134 */       break;
/*      */     case 18:
/* 1136 */       strFieldName = "edorCase";
/* 1137 */       break;
/*      */     case 19:
/* 1139 */       strFieldName = "operator2";
/* 1140 */       break;
/*      */     case 20:
/* 1142 */       strFieldName = "makeDate2";
/* 1143 */       break;
/*      */     case 21:
/* 1145 */       strFieldName = "makeTime2";
/* 1146 */       break;
/*      */     default:
/* 1148 */       strFieldName = "";
/*      */     }
/* 1150 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1156 */     if (strFieldName.equals("iD")) {
/* 1157 */       return 0;
/*      */     }
/* 1159 */     if (strFieldName.equals("roleCode")) {
/* 1160 */       return 0;
/*      */     }
/* 1162 */     if (strFieldName.equals("name")) {
/* 1163 */       return 0;
/*      */     }
/* 1165 */     if (strFieldName.equals("parent")) {
/* 1166 */       return 0;
/*      */     }
/* 1168 */     if (strFieldName.equals("describe")) {
/* 1169 */       return 0;
/*      */     }
/* 1171 */     if (strFieldName.equals("roleState")) {
/* 1172 */       return 0;
/*      */     }
/* 1174 */     if (strFieldName.equals("operator")) {
/* 1175 */       return 0;
/*      */     }
/* 1177 */     if (strFieldName.equals("makeDate")) {
/* 1178 */       return 1;
/*      */     }
/* 1180 */     if (strFieldName.equals("makeTime")) {
/* 1181 */       return 0;
/*      */     }
/* 1183 */     if (strFieldName.equals("modifyDate")) {
/* 1184 */       return 1;
/*      */     }
/* 1186 */     if (strFieldName.equals("modifyTime")) {
/* 1187 */       return 0;
/*      */     }
/* 1189 */     if (strFieldName.equals("int1")) {
/* 1190 */       return 3;
/*      */     }
/* 1192 */     if (strFieldName.equals("int2")) {
/* 1193 */       return 3;
/*      */     }
/* 1195 */     if (strFieldName.equals("varc1")) {
/* 1196 */       return 0;
/*      */     }
/* 1198 */     if (strFieldName.equals("varc2")) {
/* 1199 */       return 0;
/*      */     }
/* 1201 */     if (strFieldName.equals("varc3")) {
/* 1202 */       return 0;
/*      */     }
/* 1204 */     if (strFieldName.equals("edorNo")) {
/* 1205 */       return 0;
/*      */     }
/* 1207 */     if (strFieldName.equals("edorType")) {
/* 1208 */       return 0;
/*      */     }
/* 1210 */     if (strFieldName.equals("edorCase")) {
/* 1211 */       return 0;
/*      */     }
/* 1213 */     if (strFieldName.equals("operator2")) {
/* 1214 */       return 0;
/*      */     }
/* 1216 */     if (strFieldName.equals("makeDate2")) {
/* 1217 */       return 1;
/*      */     }
/* 1219 */     if (strFieldName.equals("makeTime2")) {
/* 1220 */       return 0;
/*      */     }
/* 1222 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1228 */     int nFieldType = -1;
/* 1229 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1231 */       nFieldType = 0;
/* 1232 */       break;
/*      */     case 1:
/* 1234 */       nFieldType = 0;
/* 1235 */       break;
/*      */     case 2:
/* 1237 */       nFieldType = 0;
/* 1238 */       break;
/*      */     case 3:
/* 1240 */       nFieldType = 0;
/* 1241 */       break;
/*      */     case 4:
/* 1243 */       nFieldType = 0;
/* 1244 */       break;
/*      */     case 5:
/* 1246 */       nFieldType = 0;
/* 1247 */       break;
/*      */     case 6:
/* 1249 */       nFieldType = 0;
/* 1250 */       break;
/*      */     case 7:
/* 1252 */       nFieldType = 1;
/* 1253 */       break;
/*      */     case 8:
/* 1255 */       nFieldType = 0;
/* 1256 */       break;
/*      */     case 9:
/* 1258 */       nFieldType = 1;
/* 1259 */       break;
/*      */     case 10:
/* 1261 */       nFieldType = 0;
/* 1262 */       break;
/*      */     case 11:
/* 1264 */       nFieldType = 3;
/* 1265 */       break;
/*      */     case 12:
/* 1267 */       nFieldType = 3;
/* 1268 */       break;
/*      */     case 13:
/* 1270 */       nFieldType = 0;
/* 1271 */       break;
/*      */     case 14:
/* 1273 */       nFieldType = 0;
/* 1274 */       break;
/*      */     case 15:
/* 1276 */       nFieldType = 0;
/* 1277 */       break;
/*      */     case 16:
/* 1279 */       nFieldType = 0;
/* 1280 */       break;
/*      */     case 17:
/* 1282 */       nFieldType = 0;
/* 1283 */       break;
/*      */     case 18:
/* 1285 */       nFieldType = 0;
/* 1286 */       break;
/*      */     case 19:
/* 1288 */       nFieldType = 0;
/* 1289 */       break;
/*      */     case 20:
/* 1291 */       nFieldType = 1;
/* 1292 */       break;
/*      */     case 21:
/* 1294 */       nFieldType = 0;
/* 1295 */       break;
/*      */     default:
/* 1297 */       nFieldType = -1;
/*      */     }
/* 1299 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MRoleInfoBSchema
 * JD-Core Version:    0.6.0
 */