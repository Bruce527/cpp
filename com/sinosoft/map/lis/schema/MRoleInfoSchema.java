/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MRoleInfoDB;
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
/*      */ public class MRoleInfoSchema
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
/*      */   public static final int FIELDNUM = 16;
/*      */   private static String[] PK;
/*   56 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MRoleInfoSchema()
/*      */   {
/*   63 */     this.mErrors = new CErrors();
/*      */ 
/*   65 */     String[] pk = new String[1];
/*   66 */     pk[0] = "ID";
/*      */ 
/*   68 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   75 */     MRoleInfoSchema cloned = (MRoleInfoSchema)super.clone();
/*   76 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   77 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   78 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   84 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*   89 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*   93 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getRoleCode() {
/*   97 */     return this.roleCode;
/*      */   }
/*      */ 
/*      */   public void setRoleCode(String aRoleCode) {
/*  101 */     this.roleCode = aRoleCode;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  105 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  109 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getParent() {
/*  113 */     return this.parent;
/*      */   }
/*      */ 
/*      */   public void setParent(String aParent) {
/*  117 */     this.parent = aParent;
/*      */   }
/*      */ 
/*      */   public String getDescribe() {
/*  121 */     return this.describe;
/*      */   }
/*      */ 
/*      */   public void setDescribe(String aDescribe) {
/*  125 */     this.describe = aDescribe;
/*      */   }
/*      */ 
/*      */   public String getRoleState() {
/*  129 */     return this.roleState;
/*      */   }
/*      */ 
/*      */   public void setRoleState(String aRoleState) {
/*  133 */     this.roleState = aRoleState;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  137 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  141 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  145 */     if (this.makeDate != null) {
/*  146 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  148 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  152 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  156 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  158 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  161 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  166 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  170 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  174 */     if (this.modifyDate != null) {
/*  175 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  177 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  181 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  185 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  187 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  190 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  195 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  199 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public int getInt1() {
/*  203 */     return this.int1;
/*      */   }
/*      */ 
/*      */   public void setInt1(int aInt1) {
/*  207 */     this.int1 = aInt1;
/*      */   }
/*      */ 
/*      */   public void setInt1(String aInt1) {
/*  211 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*      */     {
/*  213 */       Integer tInteger = new Integer(aInt1);
/*  214 */       int i = tInteger.intValue();
/*  215 */       this.int1 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInt2()
/*      */   {
/*  221 */     return this.int2;
/*      */   }
/*      */ 
/*      */   public void setInt2(int aInt2) {
/*  225 */     this.int2 = aInt2;
/*      */   }
/*      */ 
/*      */   public void setInt2(String aInt2) {
/*  229 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*      */     {
/*  231 */       Integer tInteger = new Integer(aInt2);
/*  232 */       int i = tInteger.intValue();
/*  233 */       this.int2 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getVarc1()
/*      */   {
/*  239 */     return this.varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  243 */     this.varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  247 */     return this.varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  251 */     this.varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getVarc3() {
/*  255 */     return this.varc3;
/*      */   }
/*      */ 
/*      */   public void setVarc3(String aVarc3) {
/*  259 */     this.varc3 = aVarc3;
/*      */   }
/*      */ 
/*      */   public void setSchema(MRoleInfoSchema aMRoleInfoSchema)
/*      */   {
/*  265 */     this.iD = aMRoleInfoSchema.getID();
/*  266 */     this.roleCode = aMRoleInfoSchema.getRoleCode();
/*  267 */     this.name = aMRoleInfoSchema.getName();
/*  268 */     this.parent = aMRoleInfoSchema.getParent();
/*  269 */     this.describe = aMRoleInfoSchema.getDescribe();
/*  270 */     this.roleState = aMRoleInfoSchema.getRoleState();
/*  271 */     this.operator = aMRoleInfoSchema.getOperator();
/*  272 */     this.makeDate = this.fDate.getDate(aMRoleInfoSchema.getMakeDate());
/*  273 */     this.makeTime = aMRoleInfoSchema.getMakeTime();
/*  274 */     this.modifyDate = this.fDate.getDate(aMRoleInfoSchema.getModifyDate());
/*  275 */     this.modifyTime = aMRoleInfoSchema.getModifyTime();
/*  276 */     this.int1 = aMRoleInfoSchema.getInt1();
/*  277 */     this.int2 = aMRoleInfoSchema.getInt2();
/*  278 */     this.varc1 = aMRoleInfoSchema.getVarc1();
/*  279 */     this.varc2 = aMRoleInfoSchema.getVarc2();
/*  280 */     this.varc3 = aMRoleInfoSchema.getVarc3();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  289 */       if (rs.getString("ID") == null)
/*  290 */         this.iD = null;
/*      */       else {
/*  292 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  294 */       if (rs.getString("RoleCode") == null)
/*  295 */         this.roleCode = null;
/*      */       else {
/*  297 */         this.roleCode = rs.getString("RoleCode").trim();
/*      */       }
/*  299 */       if (rs.getString("Name") == null)
/*  300 */         this.name = null;
/*      */       else {
/*  302 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  304 */       if (rs.getString("Parent") == null)
/*  305 */         this.parent = null;
/*      */       else {
/*  307 */         this.parent = rs.getString("Parent").trim();
/*      */       }
/*  309 */       if (rs.getString("Describe") == null)
/*  310 */         this.describe = null;
/*      */       else {
/*  312 */         this.describe = rs.getString("Describe").trim();
/*      */       }
/*  314 */       if (rs.getString("RoleState") == null)
/*  315 */         this.roleState = null;
/*      */       else {
/*  317 */         this.roleState = rs.getString("RoleState").trim();
/*      */       }
/*  319 */       if (rs.getString("Operator") == null)
/*  320 */         this.operator = null;
/*      */       else {
/*  322 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  324 */       this.makeDate = rs.getDate("MakeDate");
/*  325 */       if (rs.getString("MakeTime") == null)
/*  326 */         this.makeTime = null;
/*      */       else {
/*  328 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  330 */       this.modifyDate = rs.getDate("ModifyDate");
/*  331 */       if (rs.getString("ModifyTime") == null)
/*  332 */         this.modifyTime = null;
/*      */       else {
/*  334 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  336 */       this.int1 = rs.getInt("Int1");
/*  337 */       this.int2 = rs.getInt("Int2");
/*  338 */       if (rs.getString("Varc1") == null)
/*  339 */         this.varc1 = null;
/*      */       else {
/*  341 */         this.varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  343 */       if (rs.getString("Varc2") == null)
/*  344 */         this.varc2 = null;
/*      */       else {
/*  346 */         this.varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  348 */       if (rs.getString("Varc3") == null)
/*  349 */         this.varc3 = null;
/*      */       else {
/*  351 */         this.varc3 = rs.getString("Varc3").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  356 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MRoleInfo\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  358 */       CError tError = new CError();
/*  359 */       tError.moduleName = "MRoleInfoSchema";
/*  360 */       tError.functionName = "setSchema";
/*  361 */       tError.errorMessage = sqle.toString();
/*  362 */       this.mErrors.addOneError(tError);
/*  363 */       return false;
/*      */     }
/*  365 */     return true;
/*      */   }
/*      */ 
/*      */   public MRoleInfoSchema getSchema()
/*      */   {
/*  370 */     MRoleInfoSchema aMRoleInfoSchema = new MRoleInfoSchema();
/*  371 */     aMRoleInfoSchema.setSchema(this);
/*  372 */     return aMRoleInfoSchema;
/*      */   }
/*      */ 
/*      */   public MRoleInfoDB getDB()
/*      */   {
/*  377 */     MRoleInfoDB aDBOper = new MRoleInfoDB();
/*  378 */     aDBOper.setSchema(this);
/*  379 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  386 */     StringBuffer strReturn = new StringBuffer(256);
/*  387 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  388 */     strReturn.append(StrTool.cTrim(this.roleCode)); strReturn.append("|");
/*  389 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  390 */     strReturn.append(StrTool.cTrim(this.parent)); strReturn.append("|");
/*  391 */     strReturn.append(StrTool.cTrim(this.describe)); strReturn.append("|");
/*  392 */     strReturn.append(StrTool.cTrim(this.roleState)); strReturn.append("|");
/*  393 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  394 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  395 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  396 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  397 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  398 */     strReturn.append(ChgData.chgData(this.int1)); strReturn.append("|");
/*  399 */     strReturn.append(ChgData.chgData(this.int2)); strReturn.append("|");
/*  400 */     strReturn.append(StrTool.cTrim(this.varc1)); strReturn.append("|");
/*  401 */     strReturn.append(StrTool.cTrim(this.varc2)); strReturn.append("|");
/*  402 */     strReturn.append(StrTool.cTrim(this.varc3));
/*  403 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  411 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  412 */       this.roleCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  413 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  414 */       this.parent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  415 */       this.describe = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  416 */       this.roleState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  417 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  418 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/*  419 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  420 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*  421 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  422 */       this.int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).intValue();
/*  423 */       this.int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).intValue();
/*  424 */       this.varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  425 */       this.varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  426 */       this.varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  431 */       CError tError = new CError();
/*  432 */       tError.moduleName = "MRoleInfoSchema";
/*  433 */       tError.functionName = "decode";
/*  434 */       tError.errorMessage = ex.toString();
/*  435 */       this.mErrors.addOneError(tError);
/*      */ 
/*  437 */       return false;
/*      */     }
/*  439 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  445 */     String strReturn = "";
/*  446 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  448 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  450 */     if (FCode.equalsIgnoreCase("roleCode"))
/*      */     {
/*  452 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.roleCode));
/*      */     }
/*  454 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  456 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  458 */     if (FCode.equalsIgnoreCase("parent"))
/*      */     {
/*  460 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.parent));
/*      */     }
/*  462 */     if (FCode.equalsIgnoreCase("describe"))
/*      */     {
/*  464 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.describe));
/*      */     }
/*  466 */     if (FCode.equalsIgnoreCase("roleState"))
/*      */     {
/*  468 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.roleState));
/*      */     }
/*  470 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  472 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  474 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  476 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  478 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  480 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  482 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  484 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  486 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  488 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  490 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  492 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int1));
/*      */     }
/*  494 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  496 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int2));
/*      */     }
/*  498 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  500 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc1));
/*      */     }
/*  502 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  504 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc2));
/*      */     }
/*  506 */     if (FCode.equalsIgnoreCase("varc3"))
/*      */     {
/*  508 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc3));
/*      */     }
/*  510 */     if (strReturn.equals(""))
/*      */     {
/*  512 */       strReturn = "null";
/*      */     }
/*      */ 
/*  515 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  522 */     String strFieldValue = "";
/*  523 */     switch (nFieldIndex) {
/*      */     case 0:
/*  525 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  526 */       break;
/*      */     case 1:
/*  528 */       strFieldValue = StrTool.GBKToUnicode(this.roleCode);
/*  529 */       break;
/*      */     case 2:
/*  531 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  532 */       break;
/*      */     case 3:
/*  534 */       strFieldValue = StrTool.GBKToUnicode(this.parent);
/*  535 */       break;
/*      */     case 4:
/*  537 */       strFieldValue = StrTool.GBKToUnicode(this.describe);
/*  538 */       break;
/*      */     case 5:
/*  540 */       strFieldValue = StrTool.GBKToUnicode(this.roleState);
/*  541 */       break;
/*      */     case 6:
/*  543 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  544 */       break;
/*      */     case 7:
/*  546 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  547 */       break;
/*      */     case 8:
/*  549 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  550 */       break;
/*      */     case 9:
/*  552 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  553 */       break;
/*      */     case 10:
/*  555 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  556 */       break;
/*      */     case 11:
/*  558 */       strFieldValue = String.valueOf(this.int1);
/*  559 */       break;
/*      */     case 12:
/*  561 */       strFieldValue = String.valueOf(this.int2);
/*  562 */       break;
/*      */     case 13:
/*  564 */       strFieldValue = StrTool.GBKToUnicode(this.varc1);
/*  565 */       break;
/*      */     case 14:
/*  567 */       strFieldValue = StrTool.GBKToUnicode(this.varc2);
/*  568 */       break;
/*      */     case 15:
/*  570 */       strFieldValue = StrTool.GBKToUnicode(this.varc3);
/*  571 */       break;
/*      */     default:
/*  573 */       strFieldValue = "";
/*      */     }
/*  575 */     if (strFieldValue.equals("")) {
/*  576 */       strFieldValue = "null";
/*      */     }
/*  578 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  584 */     if (StrTool.cTrim(FCode).equals("")) {
/*  585 */       return false;
/*      */     }
/*  587 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  589 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  591 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  594 */         this.iD = null;
/*      */     }
/*  596 */     if (FCode.equalsIgnoreCase("roleCode"))
/*      */     {
/*  598 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  600 */         this.roleCode = FValue.trim();
/*      */       }
/*      */       else
/*  603 */         this.roleCode = null;
/*      */     }
/*  605 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  607 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  609 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  612 */         this.name = null;
/*      */     }
/*  614 */     if (FCode.equalsIgnoreCase("parent"))
/*      */     {
/*  616 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  618 */         this.parent = FValue.trim();
/*      */       }
/*      */       else
/*  621 */         this.parent = null;
/*      */     }
/*  623 */     if (FCode.equalsIgnoreCase("describe"))
/*      */     {
/*  625 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  627 */         this.describe = FValue.trim();
/*      */       }
/*      */       else
/*  630 */         this.describe = null;
/*      */     }
/*  632 */     if (FCode.equalsIgnoreCase("roleState"))
/*      */     {
/*  634 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  636 */         this.roleState = FValue.trim();
/*      */       }
/*      */       else
/*  639 */         this.roleState = null;
/*      */     }
/*  641 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  643 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  645 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  648 */         this.operator = null;
/*      */     }
/*  650 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  652 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  654 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  657 */         this.makeDate = null;
/*      */     }
/*  659 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  661 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  663 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  666 */         this.makeTime = null;
/*      */     }
/*  668 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  670 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  672 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  675 */         this.modifyDate = null;
/*      */     }
/*  677 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  679 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  681 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  684 */         this.modifyTime = null;
/*      */     }
/*  686 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  688 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  690 */         Integer tInteger = new Integer(FValue);
/*  691 */         int i = tInteger.intValue();
/*  692 */         this.int1 = i;
/*      */       }
/*      */     }
/*  695 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  697 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  699 */         Integer tInteger = new Integer(FValue);
/*  700 */         int i = tInteger.intValue();
/*  701 */         this.int2 = i;
/*      */       }
/*      */     }
/*  704 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  706 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  708 */         this.varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  711 */         this.varc1 = null;
/*      */     }
/*  713 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  715 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  717 */         this.varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  720 */         this.varc2 = null;
/*      */     }
/*  722 */     if (FCode.equalsIgnoreCase("varc3"))
/*      */     {
/*  724 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  726 */         this.varc3 = FValue.trim();
/*      */       }
/*      */       else
/*  729 */         this.varc3 = null;
/*      */     }
/*  731 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  736 */     if (otherObject == null) return false;
/*  737 */     if (this == otherObject) return true;
/*  738 */     if (getClass() != otherObject.getClass()) return false;
/*  739 */     MRoleInfoSchema other = (MRoleInfoSchema)otherObject;
/*  740 */     if ((this.iD == null) && (other.getID() != null)) return false;
/*  741 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/*  742 */     if ((this.roleCode == null) && (other.getRoleCode() != null)) return false;
/*  743 */     if ((this.roleCode != null) && (!this.roleCode.equals(other.getRoleCode()))) return false;
/*  744 */     if ((this.name == null) && (other.getName() != null)) return false;
/*  745 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/*  746 */     if ((this.parent == null) && (other.getParent() != null)) return false;
/*  747 */     if ((this.parent != null) && (!this.parent.equals(other.getParent()))) return false;
/*  748 */     if ((this.describe == null) && (other.getDescribe() != null)) return false;
/*  749 */     if ((this.describe != null) && (!this.describe.equals(other.getDescribe()))) return false;
/*  750 */     if ((this.roleState == null) && (other.getRoleState() != null)) return false;
/*  751 */     if ((this.roleState != null) && (!this.roleState.equals(other.getRoleState()))) return false;
/*  752 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  753 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  754 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  755 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  756 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  757 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  758 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  759 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  760 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  761 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/*  762 */     if (this.int1 != other.getInt1()) return false;
/*  763 */     if (this.int2 != other.getInt2()) return false;
/*  764 */     if ((this.varc1 == null) && (other.getVarc1() != null)) return false;
/*  765 */     if ((this.varc1 != null) && (!this.varc1.equals(other.getVarc1()))) return false;
/*  766 */     if ((this.varc2 == null) && (other.getVarc2() != null)) return false;
/*  767 */     if ((this.varc2 != null) && (!this.varc2.equals(other.getVarc2()))) return false;
/*  768 */     if ((this.varc3 == null) && (other.getVarc3() != null)) return false;
/*  769 */     return (this.varc3 == null) || (this.varc3.equals(other.getVarc3()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  776 */     return 16;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  782 */     if (strFieldName.equals("iD")) {
/*  783 */       return 0;
/*      */     }
/*  785 */     if (strFieldName.equals("roleCode")) {
/*  786 */       return 1;
/*      */     }
/*  788 */     if (strFieldName.equals("name")) {
/*  789 */       return 2;
/*      */     }
/*  791 */     if (strFieldName.equals("parent")) {
/*  792 */       return 3;
/*      */     }
/*  794 */     if (strFieldName.equals("describe")) {
/*  795 */       return 4;
/*      */     }
/*  797 */     if (strFieldName.equals("roleState")) {
/*  798 */       return 5;
/*      */     }
/*  800 */     if (strFieldName.equals("operator")) {
/*  801 */       return 6;
/*      */     }
/*  803 */     if (strFieldName.equals("makeDate")) {
/*  804 */       return 7;
/*      */     }
/*  806 */     if (strFieldName.equals("makeTime")) {
/*  807 */       return 8;
/*      */     }
/*  809 */     if (strFieldName.equals("modifyDate")) {
/*  810 */       return 9;
/*      */     }
/*  812 */     if (strFieldName.equals("modifyTime")) {
/*  813 */       return 10;
/*      */     }
/*  815 */     if (strFieldName.equals("int1")) {
/*  816 */       return 11;
/*      */     }
/*  818 */     if (strFieldName.equals("int2")) {
/*  819 */       return 12;
/*      */     }
/*  821 */     if (strFieldName.equals("varc1")) {
/*  822 */       return 13;
/*      */     }
/*  824 */     if (strFieldName.equals("varc2")) {
/*  825 */       return 14;
/*      */     }
/*  827 */     if (strFieldName.equals("varc3")) {
/*  828 */       return 15;
/*      */     }
/*  830 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  836 */     String strFieldName = "";
/*  837 */     switch (nFieldIndex) {
/*      */     case 0:
/*  839 */       strFieldName = "iD";
/*  840 */       break;
/*      */     case 1:
/*  842 */       strFieldName = "roleCode";
/*  843 */       break;
/*      */     case 2:
/*  845 */       strFieldName = "name";
/*  846 */       break;
/*      */     case 3:
/*  848 */       strFieldName = "parent";
/*  849 */       break;
/*      */     case 4:
/*  851 */       strFieldName = "describe";
/*  852 */       break;
/*      */     case 5:
/*  854 */       strFieldName = "roleState";
/*  855 */       break;
/*      */     case 6:
/*  857 */       strFieldName = "operator";
/*  858 */       break;
/*      */     case 7:
/*  860 */       strFieldName = "makeDate";
/*  861 */       break;
/*      */     case 8:
/*  863 */       strFieldName = "makeTime";
/*  864 */       break;
/*      */     case 9:
/*  866 */       strFieldName = "modifyDate";
/*  867 */       break;
/*      */     case 10:
/*  869 */       strFieldName = "modifyTime";
/*  870 */       break;
/*      */     case 11:
/*  872 */       strFieldName = "int1";
/*  873 */       break;
/*      */     case 12:
/*  875 */       strFieldName = "int2";
/*  876 */       break;
/*      */     case 13:
/*  878 */       strFieldName = "varc1";
/*  879 */       break;
/*      */     case 14:
/*  881 */       strFieldName = "varc2";
/*  882 */       break;
/*      */     case 15:
/*  884 */       strFieldName = "varc3";
/*  885 */       break;
/*      */     default:
/*  887 */       strFieldName = "";
/*      */     }
/*  889 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  895 */     if (strFieldName.equals("iD")) {
/*  896 */       return 0;
/*      */     }
/*  898 */     if (strFieldName.equals("roleCode")) {
/*  899 */       return 0;
/*      */     }
/*  901 */     if (strFieldName.equals("name")) {
/*  902 */       return 0;
/*      */     }
/*  904 */     if (strFieldName.equals("parent")) {
/*  905 */       return 0;
/*      */     }
/*  907 */     if (strFieldName.equals("describe")) {
/*  908 */       return 0;
/*      */     }
/*  910 */     if (strFieldName.equals("roleState")) {
/*  911 */       return 0;
/*      */     }
/*  913 */     if (strFieldName.equals("operator")) {
/*  914 */       return 0;
/*      */     }
/*  916 */     if (strFieldName.equals("makeDate")) {
/*  917 */       return 1;
/*      */     }
/*  919 */     if (strFieldName.equals("makeTime")) {
/*  920 */       return 0;
/*      */     }
/*  922 */     if (strFieldName.equals("modifyDate")) {
/*  923 */       return 1;
/*      */     }
/*  925 */     if (strFieldName.equals("modifyTime")) {
/*  926 */       return 0;
/*      */     }
/*  928 */     if (strFieldName.equals("int1")) {
/*  929 */       return 3;
/*      */     }
/*  931 */     if (strFieldName.equals("int2")) {
/*  932 */       return 3;
/*      */     }
/*  934 */     if (strFieldName.equals("varc1")) {
/*  935 */       return 0;
/*      */     }
/*  937 */     if (strFieldName.equals("varc2")) {
/*  938 */       return 0;
/*      */     }
/*  940 */     if (strFieldName.equals("varc3")) {
/*  941 */       return 0;
/*      */     }
/*  943 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/*  949 */     int nFieldType = -1;
/*  950 */     switch (nFieldIndex) {
/*      */     case 0:
/*  952 */       nFieldType = 0;
/*  953 */       break;
/*      */     case 1:
/*  955 */       nFieldType = 0;
/*  956 */       break;
/*      */     case 2:
/*  958 */       nFieldType = 0;
/*  959 */       break;
/*      */     case 3:
/*  961 */       nFieldType = 0;
/*  962 */       break;
/*      */     case 4:
/*  964 */       nFieldType = 0;
/*  965 */       break;
/*      */     case 5:
/*  967 */       nFieldType = 0;
/*  968 */       break;
/*      */     case 6:
/*  970 */       nFieldType = 0;
/*  971 */       break;
/*      */     case 7:
/*  973 */       nFieldType = 1;
/*  974 */       break;
/*      */     case 8:
/*  976 */       nFieldType = 0;
/*  977 */       break;
/*      */     case 9:
/*  979 */       nFieldType = 1;
/*  980 */       break;
/*      */     case 10:
/*  982 */       nFieldType = 0;
/*  983 */       break;
/*      */     case 11:
/*  985 */       nFieldType = 3;
/*  986 */       break;
/*      */     case 12:
/*  988 */       nFieldType = 3;
/*  989 */       break;
/*      */     case 13:
/*  991 */       nFieldType = 0;
/*  992 */       break;
/*      */     case 14:
/*  994 */       nFieldType = 0;
/*  995 */       break;
/*      */     case 15:
/*  997 */       nFieldType = 0;
/*  998 */       break;
/*      */     default:
/* 1000 */       nFieldType = -1;
/*      */     }
/* 1002 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MRoleInfoSchema
 * JD-Core Version:    0.6.0
 */