/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MMenuBDB;
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
/*      */ public class MMenuBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String nodeCode;
/*      */   private String parentID;
/*      */   private String nodeLevel;
/*      */   private String nodeName;
/*      */   private String childFlag;
/*      */   private String nodeKey;
/*      */   private String runScript;
/*      */   private String nodeDesc;
/*      */   private String nodeSign;
/*      */   private int nodeOrder;
/*      */   private int int1;
/*      */   private int int2;
/*      */   private String varc1;
/*      */   private String varc2;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   public static final int FIELDNUM = 25;
/*      */   private static String[] PK;
/*   74 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MMenuBSchema()
/*      */   {
/*   81 */     this.mErrors = new CErrors();
/*      */ 
/*   83 */     String[] pk = new String[1];
/*   84 */     pk[0] = "EdorNo";
/*      */ 
/*   86 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   93 */     MMenuBSchema cloned = (MMenuBSchema)super.clone();
/*   94 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   95 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   96 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  102 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getNodeCode()
/*      */   {
/*  107 */     return this.nodeCode;
/*      */   }
/*      */ 
/*      */   public void setNodeCode(String aNodeCode) {
/*  111 */     this.nodeCode = aNodeCode;
/*      */   }
/*      */ 
/*      */   public String getParentID() {
/*  115 */     return this.parentID;
/*      */   }
/*      */ 
/*      */   public void setParentID(String aParentID) {
/*  119 */     this.parentID = aParentID;
/*      */   }
/*      */ 
/*      */   public String getNodeLevel() {
/*  123 */     return this.nodeLevel;
/*      */   }
/*      */ 
/*      */   public void setNodeLevel(String aNodeLevel) {
/*  127 */     this.nodeLevel = aNodeLevel;
/*      */   }
/*      */ 
/*      */   public String getNodeName() {
/*  131 */     return this.nodeName;
/*      */   }
/*      */ 
/*      */   public void setNodeName(String aNodeName) {
/*  135 */     this.nodeName = aNodeName;
/*      */   }
/*      */ 
/*      */   public String getChildFlag() {
/*  139 */     return this.childFlag;
/*      */   }
/*      */ 
/*      */   public void setChildFlag(String aChildFlag) {
/*  143 */     this.childFlag = aChildFlag;
/*      */   }
/*      */ 
/*      */   public String getNodeKey() {
/*  147 */     return this.nodeKey;
/*      */   }
/*      */ 
/*      */   public void setNodeKey(String aNodeKey) {
/*  151 */     this.nodeKey = aNodeKey;
/*      */   }
/*      */ 
/*      */   public String getRunScript() {
/*  155 */     return this.runScript;
/*      */   }
/*      */ 
/*      */   public void setRunScript(String aRunScript) {
/*  159 */     this.runScript = aRunScript;
/*      */   }
/*      */ 
/*      */   public String getNodeDesc() {
/*  163 */     return this.nodeDesc;
/*      */   }
/*      */ 
/*      */   public void setNodeDesc(String aNodeDesc) {
/*  167 */     this.nodeDesc = aNodeDesc;
/*      */   }
/*      */ 
/*      */   public String getNodeSign() {
/*  171 */     return this.nodeSign;
/*      */   }
/*      */ 
/*      */   public void setNodeSign(String aNodeSign) {
/*  175 */     this.nodeSign = aNodeSign;
/*      */   }
/*      */ 
/*      */   public int getNodeOrder() {
/*  179 */     return this.nodeOrder;
/*      */   }
/*      */ 
/*      */   public void setNodeOrder(int aNodeOrder) {
/*  183 */     this.nodeOrder = aNodeOrder;
/*      */   }
/*      */ 
/*      */   public void setNodeOrder(String aNodeOrder) {
/*  187 */     if ((aNodeOrder != null) && (!aNodeOrder.equals("")))
/*      */     {
/*  189 */       Integer tInteger = new Integer(aNodeOrder);
/*  190 */       int i = tInteger.intValue();
/*  191 */       this.nodeOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInt1()
/*      */   {
/*  197 */     return this.int1;
/*      */   }
/*      */ 
/*      */   public void setInt1(int aInt1) {
/*  201 */     this.int1 = aInt1;
/*      */   }
/*      */ 
/*      */   public void setInt1(String aInt1) {
/*  205 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*      */     {
/*  207 */       Integer tInteger = new Integer(aInt1);
/*  208 */       int i = tInteger.intValue();
/*  209 */       this.int1 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInt2()
/*      */   {
/*  215 */     return this.int2;
/*      */   }
/*      */ 
/*      */   public void setInt2(int aInt2) {
/*  219 */     this.int2 = aInt2;
/*      */   }
/*      */ 
/*      */   public void setInt2(String aInt2) {
/*  223 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*      */     {
/*  225 */       Integer tInteger = new Integer(aInt2);
/*  226 */       int i = tInteger.intValue();
/*  227 */       this.int2 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getVarc1()
/*      */   {
/*  233 */     return this.varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  237 */     this.varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  241 */     return this.varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  245 */     this.varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  249 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  253 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  257 */     if (this.makeDate != null) {
/*  258 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  260 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  264 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  268 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  270 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  273 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  278 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  282 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  286 */     if (this.modifyDate != null) {
/*  287 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  289 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  293 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  297 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  299 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  302 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  307 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  311 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  315 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  319 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  323 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  327 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  331 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  335 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  339 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  343 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  347 */     if (this.makeDate2 != null) {
/*  348 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  350 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  354 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  358 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  360 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  363 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  368 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  372 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public void setSchema(MMenuBSchema aMMenuBSchema)
/*      */   {
/*  378 */     this.nodeCode = aMMenuBSchema.getNodeCode();
/*  379 */     this.parentID = aMMenuBSchema.getParentID();
/*  380 */     this.nodeLevel = aMMenuBSchema.getNodeLevel();
/*  381 */     this.nodeName = aMMenuBSchema.getNodeName();
/*  382 */     this.childFlag = aMMenuBSchema.getChildFlag();
/*  383 */     this.nodeKey = aMMenuBSchema.getNodeKey();
/*  384 */     this.runScript = aMMenuBSchema.getRunScript();
/*  385 */     this.nodeDesc = aMMenuBSchema.getNodeDesc();
/*  386 */     this.nodeSign = aMMenuBSchema.getNodeSign();
/*  387 */     this.nodeOrder = aMMenuBSchema.getNodeOrder();
/*  388 */     this.int1 = aMMenuBSchema.getInt1();
/*  389 */     this.int2 = aMMenuBSchema.getInt2();
/*  390 */     this.varc1 = aMMenuBSchema.getVarc1();
/*  391 */     this.varc2 = aMMenuBSchema.getVarc2();
/*  392 */     this.operator = aMMenuBSchema.getOperator();
/*  393 */     this.makeDate = this.fDate.getDate(aMMenuBSchema.getMakeDate());
/*  394 */     this.makeTime = aMMenuBSchema.getMakeTime();
/*  395 */     this.modifyDate = this.fDate.getDate(aMMenuBSchema.getModifyDate());
/*  396 */     this.modifyTime = aMMenuBSchema.getModifyTime();
/*  397 */     this.edorNo = aMMenuBSchema.getEdorNo();
/*  398 */     this.edorType = aMMenuBSchema.getEdorType();
/*  399 */     this.edorCase = aMMenuBSchema.getEdorCase();
/*  400 */     this.operator2 = aMMenuBSchema.getOperator2();
/*  401 */     this.makeDate2 = this.fDate.getDate(aMMenuBSchema.getMakeDate2());
/*  402 */     this.makeTime2 = aMMenuBSchema.getMakeTime2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  411 */       if (rs.getString("NodeCode") == null)
/*  412 */         this.nodeCode = null;
/*      */       else {
/*  414 */         this.nodeCode = rs.getString("NodeCode").trim();
/*      */       }
/*  416 */       if (rs.getString("ParentID") == null)
/*  417 */         this.parentID = null;
/*      */       else {
/*  419 */         this.parentID = rs.getString("ParentID").trim();
/*      */       }
/*  421 */       if (rs.getString("NodeLevel") == null)
/*  422 */         this.nodeLevel = null;
/*      */       else {
/*  424 */         this.nodeLevel = rs.getString("NodeLevel").trim();
/*      */       }
/*  426 */       if (rs.getString("NodeName") == null)
/*  427 */         this.nodeName = null;
/*      */       else {
/*  429 */         this.nodeName = rs.getString("NodeName").trim();
/*      */       }
/*  431 */       if (rs.getString("ChildFlag") == null)
/*  432 */         this.childFlag = null;
/*      */       else {
/*  434 */         this.childFlag = rs.getString("ChildFlag").trim();
/*      */       }
/*  436 */       if (rs.getString("NodeKey") == null)
/*  437 */         this.nodeKey = null;
/*      */       else {
/*  439 */         this.nodeKey = rs.getString("NodeKey").trim();
/*      */       }
/*  441 */       if (rs.getString("RunScript") == null)
/*  442 */         this.runScript = null;
/*      */       else {
/*  444 */         this.runScript = rs.getString("RunScript").trim();
/*      */       }
/*  446 */       if (rs.getString("NodeDesc") == null)
/*  447 */         this.nodeDesc = null;
/*      */       else {
/*  449 */         this.nodeDesc = rs.getString("NodeDesc").trim();
/*      */       }
/*  451 */       if (rs.getString("NodeSign") == null)
/*  452 */         this.nodeSign = null;
/*      */       else {
/*  454 */         this.nodeSign = rs.getString("NodeSign").trim();
/*      */       }
/*  456 */       this.nodeOrder = rs.getInt("NodeOrder");
/*  457 */       this.int1 = rs.getInt("Int1");
/*  458 */       this.int2 = rs.getInt("Int2");
/*  459 */       if (rs.getString("Varc1") == null)
/*  460 */         this.varc1 = null;
/*      */       else {
/*  462 */         this.varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  464 */       if (rs.getString("Varc2") == null)
/*  465 */         this.varc2 = null;
/*      */       else {
/*  467 */         this.varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  469 */       if (rs.getString("Operator") == null)
/*  470 */         this.operator = null;
/*      */       else {
/*  472 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  474 */       this.makeDate = rs.getDate("MakeDate");
/*  475 */       if (rs.getString("MakeTime") == null)
/*  476 */         this.makeTime = null;
/*      */       else {
/*  478 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  480 */       this.modifyDate = rs.getDate("ModifyDate");
/*  481 */       if (rs.getString("ModifyTime") == null)
/*  482 */         this.modifyTime = null;
/*      */       else {
/*  484 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  486 */       if (rs.getString("EdorNo") == null)
/*  487 */         this.edorNo = null;
/*      */       else {
/*  489 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  491 */       if (rs.getString("EdorType") == null)
/*  492 */         this.edorType = null;
/*      */       else {
/*  494 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  496 */       if (rs.getString("EdorCase") == null)
/*  497 */         this.edorCase = null;
/*      */       else {
/*  499 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  501 */       if (rs.getString("Operator2") == null)
/*  502 */         this.operator2 = null;
/*      */       else {
/*  504 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  506 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  507 */       if (rs.getString("MakeTime2") == null)
/*  508 */         this.makeTime2 = null;
/*      */       else {
/*  510 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  515 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MMenuB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  517 */       CError tError = new CError();
/*  518 */       tError.moduleName = "MMenuBSchema";
/*  519 */       tError.functionName = "setSchema";
/*  520 */       tError.errorMessage = sqle.toString();
/*  521 */       this.mErrors.addOneError(tError);
/*  522 */       return false;
/*      */     }
/*  524 */     return true;
/*      */   }
/*      */ 
/*      */   public MMenuBSchema getSchema()
/*      */   {
/*  529 */     MMenuBSchema aMMenuBSchema = new MMenuBSchema();
/*  530 */     aMMenuBSchema.setSchema(this);
/*  531 */     return aMMenuBSchema;
/*      */   }
/*      */ 
/*      */   public MMenuBDB getDB()
/*      */   {
/*  536 */     MMenuBDB aDBOper = new MMenuBDB();
/*  537 */     aDBOper.setSchema(this);
/*  538 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  545 */     StringBuffer strReturn = new StringBuffer(256);
/*  546 */     strReturn.append(StrTool.cTrim(this.nodeCode)); strReturn.append("|");
/*  547 */     strReturn.append(StrTool.cTrim(this.parentID)); strReturn.append("|");
/*  548 */     strReturn.append(StrTool.cTrim(this.nodeLevel)); strReturn.append("|");
/*  549 */     strReturn.append(StrTool.cTrim(this.nodeName)); strReturn.append("|");
/*  550 */     strReturn.append(StrTool.cTrim(this.childFlag)); strReturn.append("|");
/*  551 */     strReturn.append(StrTool.cTrim(this.nodeKey)); strReturn.append("|");
/*  552 */     strReturn.append(StrTool.cTrim(this.runScript)); strReturn.append("|");
/*  553 */     strReturn.append(StrTool.cTrim(this.nodeDesc)); strReturn.append("|");
/*  554 */     strReturn.append(StrTool.cTrim(this.nodeSign)); strReturn.append("|");
/*  555 */     strReturn.append(ChgData.chgData(this.nodeOrder)); strReturn.append("|");
/*  556 */     strReturn.append(ChgData.chgData(this.int1)); strReturn.append("|");
/*  557 */     strReturn.append(ChgData.chgData(this.int2)); strReturn.append("|");
/*  558 */     strReturn.append(StrTool.cTrim(this.varc1)); strReturn.append("|");
/*  559 */     strReturn.append(StrTool.cTrim(this.varc2)); strReturn.append("|");
/*  560 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  561 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  562 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  563 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  564 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  565 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  566 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  567 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  568 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  569 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  570 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/*  571 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  579 */       this.nodeCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  580 */       this.parentID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  581 */       this.nodeLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  582 */       this.nodeName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  583 */       this.childFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  584 */       this.nodeKey = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  585 */       this.runScript = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  586 */       this.nodeDesc = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  587 */       this.nodeSign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  588 */       this.nodeOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/*  589 */       this.int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).intValue();
/*  590 */       this.int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).intValue();
/*  591 */       this.varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  592 */       this.varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  593 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  594 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  595 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  596 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*  597 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  598 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  599 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  600 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  601 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  602 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
/*  603 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  608 */       CError tError = new CError();
/*  609 */       tError.moduleName = "MMenuBSchema";
/*  610 */       tError.functionName = "decode";
/*  611 */       tError.errorMessage = ex.toString();
/*  612 */       this.mErrors.addOneError(tError);
/*      */ 
/*  614 */       return false;
/*      */     }
/*  616 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  622 */     String strReturn = "";
/*  623 */     if (FCode.equalsIgnoreCase("nodeCode"))
/*      */     {
/*  625 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeCode));
/*      */     }
/*  627 */     if (FCode.equalsIgnoreCase("parentID"))
/*      */     {
/*  629 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.parentID));
/*      */     }
/*  631 */     if (FCode.equalsIgnoreCase("nodeLevel"))
/*      */     {
/*  633 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeLevel));
/*      */     }
/*  635 */     if (FCode.equalsIgnoreCase("nodeName"))
/*      */     {
/*  637 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeName));
/*      */     }
/*  639 */     if (FCode.equalsIgnoreCase("childFlag"))
/*      */     {
/*  641 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.childFlag));
/*      */     }
/*  643 */     if (FCode.equalsIgnoreCase("nodeKey"))
/*      */     {
/*  645 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeKey));
/*      */     }
/*  647 */     if (FCode.equalsIgnoreCase("runScript"))
/*      */     {
/*  649 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.runScript));
/*      */     }
/*  651 */     if (FCode.equalsIgnoreCase("nodeDesc"))
/*      */     {
/*  653 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeDesc));
/*      */     }
/*  655 */     if (FCode.equalsIgnoreCase("nodeSign"))
/*      */     {
/*  657 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeSign));
/*      */     }
/*  659 */     if (FCode.equalsIgnoreCase("nodeOrder"))
/*      */     {
/*  661 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeOrder));
/*      */     }
/*  663 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  665 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int1));
/*      */     }
/*  667 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  669 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int2));
/*      */     }
/*  671 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  673 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc1));
/*      */     }
/*  675 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  677 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc2));
/*      */     }
/*  679 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  681 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  683 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  685 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  687 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  689 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  691 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  693 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  695 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  697 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  699 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  701 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  703 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  705 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  707 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  709 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  711 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  713 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  715 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  717 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  719 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  721 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  723 */     if (strReturn.equals(""))
/*      */     {
/*  725 */       strReturn = "null";
/*      */     }
/*      */ 
/*  728 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  735 */     String strFieldValue = "";
/*  736 */     switch (nFieldIndex) {
/*      */     case 0:
/*  738 */       strFieldValue = StrTool.GBKToUnicode(this.nodeCode);
/*  739 */       break;
/*      */     case 1:
/*  741 */       strFieldValue = StrTool.GBKToUnicode(this.parentID);
/*  742 */       break;
/*      */     case 2:
/*  744 */       strFieldValue = StrTool.GBKToUnicode(this.nodeLevel);
/*  745 */       break;
/*      */     case 3:
/*  747 */       strFieldValue = StrTool.GBKToUnicode(this.nodeName);
/*  748 */       break;
/*      */     case 4:
/*  750 */       strFieldValue = StrTool.GBKToUnicode(this.childFlag);
/*  751 */       break;
/*      */     case 5:
/*  753 */       strFieldValue = StrTool.GBKToUnicode(this.nodeKey);
/*  754 */       break;
/*      */     case 6:
/*  756 */       strFieldValue = StrTool.GBKToUnicode(this.runScript);
/*  757 */       break;
/*      */     case 7:
/*  759 */       strFieldValue = StrTool.GBKToUnicode(this.nodeDesc);
/*  760 */       break;
/*      */     case 8:
/*  762 */       strFieldValue = StrTool.GBKToUnicode(this.nodeSign);
/*  763 */       break;
/*      */     case 9:
/*  765 */       strFieldValue = String.valueOf(this.nodeOrder);
/*  766 */       break;
/*      */     case 10:
/*  768 */       strFieldValue = String.valueOf(this.int1);
/*  769 */       break;
/*      */     case 11:
/*  771 */       strFieldValue = String.valueOf(this.int2);
/*  772 */       break;
/*      */     case 12:
/*  774 */       strFieldValue = StrTool.GBKToUnicode(this.varc1);
/*  775 */       break;
/*      */     case 13:
/*  777 */       strFieldValue = StrTool.GBKToUnicode(this.varc2);
/*  778 */       break;
/*      */     case 14:
/*  780 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  781 */       break;
/*      */     case 15:
/*  783 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  784 */       break;
/*      */     case 16:
/*  786 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  787 */       break;
/*      */     case 17:
/*  789 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  790 */       break;
/*      */     case 18:
/*  792 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  793 */       break;
/*      */     case 19:
/*  795 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  796 */       break;
/*      */     case 20:
/*  798 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  799 */       break;
/*      */     case 21:
/*  801 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  802 */       break;
/*      */     case 22:
/*  804 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  805 */       break;
/*      */     case 23:
/*  807 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  808 */       break;
/*      */     case 24:
/*  810 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  811 */       break;
/*      */     default:
/*  813 */       strFieldValue = "";
/*      */     }
/*  815 */     if (strFieldValue.equals("")) {
/*  816 */       strFieldValue = "null";
/*      */     }
/*  818 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  824 */     if (StrTool.cTrim(FCode).equals("")) {
/*  825 */       return false;
/*      */     }
/*  827 */     if (FCode.equalsIgnoreCase("nodeCode"))
/*      */     {
/*  829 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  831 */         this.nodeCode = FValue.trim();
/*      */       }
/*      */       else
/*  834 */         this.nodeCode = null;
/*      */     }
/*  836 */     if (FCode.equalsIgnoreCase("parentID"))
/*      */     {
/*  838 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  840 */         this.parentID = FValue.trim();
/*      */       }
/*      */       else
/*  843 */         this.parentID = null;
/*      */     }
/*  845 */     if (FCode.equalsIgnoreCase("nodeLevel"))
/*      */     {
/*  847 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  849 */         this.nodeLevel = FValue.trim();
/*      */       }
/*      */       else
/*  852 */         this.nodeLevel = null;
/*      */     }
/*  854 */     if (FCode.equalsIgnoreCase("nodeName"))
/*      */     {
/*  856 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  858 */         this.nodeName = FValue.trim();
/*      */       }
/*      */       else
/*  861 */         this.nodeName = null;
/*      */     }
/*  863 */     if (FCode.equalsIgnoreCase("childFlag"))
/*      */     {
/*  865 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  867 */         this.childFlag = FValue.trim();
/*      */       }
/*      */       else
/*  870 */         this.childFlag = null;
/*      */     }
/*  872 */     if (FCode.equalsIgnoreCase("nodeKey"))
/*      */     {
/*  874 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  876 */         this.nodeKey = FValue.trim();
/*      */       }
/*      */       else
/*  879 */         this.nodeKey = null;
/*      */     }
/*  881 */     if (FCode.equalsIgnoreCase("runScript"))
/*      */     {
/*  883 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  885 */         this.runScript = FValue.trim();
/*      */       }
/*      */       else
/*  888 */         this.runScript = null;
/*      */     }
/*  890 */     if (FCode.equalsIgnoreCase("nodeDesc"))
/*      */     {
/*  892 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  894 */         this.nodeDesc = FValue.trim();
/*      */       }
/*      */       else
/*  897 */         this.nodeDesc = null;
/*      */     }
/*  899 */     if (FCode.equalsIgnoreCase("nodeSign"))
/*      */     {
/*  901 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  903 */         this.nodeSign = FValue.trim();
/*      */       }
/*      */       else
/*  906 */         this.nodeSign = null;
/*      */     }
/*  908 */     if (FCode.equalsIgnoreCase("nodeOrder"))
/*      */     {
/*  910 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  912 */         Integer tInteger = new Integer(FValue);
/*  913 */         int i = tInteger.intValue();
/*  914 */         this.nodeOrder = i;
/*      */       }
/*      */     }
/*  917 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  919 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  921 */         Integer tInteger = new Integer(FValue);
/*  922 */         int i = tInteger.intValue();
/*  923 */         this.int1 = i;
/*      */       }
/*      */     }
/*  926 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  928 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  930 */         Integer tInteger = new Integer(FValue);
/*  931 */         int i = tInteger.intValue();
/*  932 */         this.int2 = i;
/*      */       }
/*      */     }
/*  935 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  937 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  939 */         this.varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  942 */         this.varc1 = null;
/*      */     }
/*  944 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  946 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  948 */         this.varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  951 */         this.varc2 = null;
/*      */     }
/*  953 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  955 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  957 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  960 */         this.operator = null;
/*      */     }
/*  962 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  964 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  966 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  969 */         this.makeDate = null;
/*      */     }
/*  971 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  973 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  975 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  978 */         this.makeTime = null;
/*      */     }
/*  980 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  982 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  984 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  987 */         this.modifyDate = null;
/*      */     }
/*  989 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  991 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  993 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  996 */         this.modifyTime = null;
/*      */     }
/*  998 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/* 1000 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1002 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1005 */         this.edorNo = null;
/*      */     }
/* 1007 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/* 1009 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1011 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1014 */         this.edorType = null;
/*      */     }
/* 1016 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1018 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1020 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1023 */         this.edorCase = null;
/*      */     }
/* 1025 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1027 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1029 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1032 */         this.operator2 = null;
/*      */     }
/* 1034 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1036 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1038 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1041 */         this.makeDate2 = null;
/*      */     }
/* 1043 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1045 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1047 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1050 */         this.makeTime2 = null;
/*      */     }
/* 1052 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1057 */     if (otherObject == null) return false;
/* 1058 */     if (this == otherObject) return true;
/* 1059 */     if (getClass() != otherObject.getClass()) return false;
/* 1060 */     MMenuBSchema other = (MMenuBSchema)otherObject;
/* 1061 */     if ((this.nodeCode == null) && (other.getNodeCode() != null)) return false;
/* 1062 */     if ((this.nodeCode != null) && (!this.nodeCode.equals(other.getNodeCode()))) return false;
/* 1063 */     if ((this.parentID == null) && (other.getParentID() != null)) return false;
/* 1064 */     if ((this.parentID != null) && (!this.parentID.equals(other.getParentID()))) return false;
/* 1065 */     if ((this.nodeLevel == null) && (other.getNodeLevel() != null)) return false;
/* 1066 */     if ((this.nodeLevel != null) && (!this.nodeLevel.equals(other.getNodeLevel()))) return false;
/* 1067 */     if ((this.nodeName == null) && (other.getNodeName() != null)) return false;
/* 1068 */     if ((this.nodeName != null) && (!this.nodeName.equals(other.getNodeName()))) return false;
/* 1069 */     if ((this.childFlag == null) && (other.getChildFlag() != null)) return false;
/* 1070 */     if ((this.childFlag != null) && (!this.childFlag.equals(other.getChildFlag()))) return false;
/* 1071 */     if ((this.nodeKey == null) && (other.getNodeKey() != null)) return false;
/* 1072 */     if ((this.nodeKey != null) && (!this.nodeKey.equals(other.getNodeKey()))) return false;
/* 1073 */     if ((this.runScript == null) && (other.getRunScript() != null)) return false;
/* 1074 */     if ((this.runScript != null) && (!this.runScript.equals(other.getRunScript()))) return false;
/* 1075 */     if ((this.nodeDesc == null) && (other.getNodeDesc() != null)) return false;
/* 1076 */     if ((this.nodeDesc != null) && (!this.nodeDesc.equals(other.getNodeDesc()))) return false;
/* 1077 */     if ((this.nodeSign == null) && (other.getNodeSign() != null)) return false;
/* 1078 */     if ((this.nodeSign != null) && (!this.nodeSign.equals(other.getNodeSign()))) return false;
/* 1079 */     if (this.nodeOrder != other.getNodeOrder()) return false;
/* 1080 */     if (this.int1 != other.getInt1()) return false;
/* 1081 */     if (this.int2 != other.getInt2()) return false;
/* 1082 */     if ((this.varc1 == null) && (other.getVarc1() != null)) return false;
/* 1083 */     if ((this.varc1 != null) && (!this.varc1.equals(other.getVarc1()))) return false;
/* 1084 */     if ((this.varc2 == null) && (other.getVarc2() != null)) return false;
/* 1085 */     if ((this.varc2 != null) && (!this.varc2.equals(other.getVarc2()))) return false;
/* 1086 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1087 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1088 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1089 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1090 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1091 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1092 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1093 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1094 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1095 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1096 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1097 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1098 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1099 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1100 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1101 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1102 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1103 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1104 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1105 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1106 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1107 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1114 */     return 25;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1120 */     if (strFieldName.equals("nodeCode")) {
/* 1121 */       return 0;
/*      */     }
/* 1123 */     if (strFieldName.equals("parentID")) {
/* 1124 */       return 1;
/*      */     }
/* 1126 */     if (strFieldName.equals("nodeLevel")) {
/* 1127 */       return 2;
/*      */     }
/* 1129 */     if (strFieldName.equals("nodeName")) {
/* 1130 */       return 3;
/*      */     }
/* 1132 */     if (strFieldName.equals("childFlag")) {
/* 1133 */       return 4;
/*      */     }
/* 1135 */     if (strFieldName.equals("nodeKey")) {
/* 1136 */       return 5;
/*      */     }
/* 1138 */     if (strFieldName.equals("runScript")) {
/* 1139 */       return 6;
/*      */     }
/* 1141 */     if (strFieldName.equals("nodeDesc")) {
/* 1142 */       return 7;
/*      */     }
/* 1144 */     if (strFieldName.equals("nodeSign")) {
/* 1145 */       return 8;
/*      */     }
/* 1147 */     if (strFieldName.equals("nodeOrder")) {
/* 1148 */       return 9;
/*      */     }
/* 1150 */     if (strFieldName.equals("int1")) {
/* 1151 */       return 10;
/*      */     }
/* 1153 */     if (strFieldName.equals("int2")) {
/* 1154 */       return 11;
/*      */     }
/* 1156 */     if (strFieldName.equals("varc1")) {
/* 1157 */       return 12;
/*      */     }
/* 1159 */     if (strFieldName.equals("varc2")) {
/* 1160 */       return 13;
/*      */     }
/* 1162 */     if (strFieldName.equals("operator")) {
/* 1163 */       return 14;
/*      */     }
/* 1165 */     if (strFieldName.equals("makeDate")) {
/* 1166 */       return 15;
/*      */     }
/* 1168 */     if (strFieldName.equals("makeTime")) {
/* 1169 */       return 16;
/*      */     }
/* 1171 */     if (strFieldName.equals("modifyDate")) {
/* 1172 */       return 17;
/*      */     }
/* 1174 */     if (strFieldName.equals("modifyTime")) {
/* 1175 */       return 18;
/*      */     }
/* 1177 */     if (strFieldName.equals("edorNo")) {
/* 1178 */       return 19;
/*      */     }
/* 1180 */     if (strFieldName.equals("edorType")) {
/* 1181 */       return 20;
/*      */     }
/* 1183 */     if (strFieldName.equals("edorCase")) {
/* 1184 */       return 21;
/*      */     }
/* 1186 */     if (strFieldName.equals("operator2")) {
/* 1187 */       return 22;
/*      */     }
/* 1189 */     if (strFieldName.equals("makeDate2")) {
/* 1190 */       return 23;
/*      */     }
/* 1192 */     if (strFieldName.equals("makeTime2")) {
/* 1193 */       return 24;
/*      */     }
/* 1195 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1201 */     String strFieldName = "";
/* 1202 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1204 */       strFieldName = "nodeCode";
/* 1205 */       break;
/*      */     case 1:
/* 1207 */       strFieldName = "parentID";
/* 1208 */       break;
/*      */     case 2:
/* 1210 */       strFieldName = "nodeLevel";
/* 1211 */       break;
/*      */     case 3:
/* 1213 */       strFieldName = "nodeName";
/* 1214 */       break;
/*      */     case 4:
/* 1216 */       strFieldName = "childFlag";
/* 1217 */       break;
/*      */     case 5:
/* 1219 */       strFieldName = "nodeKey";
/* 1220 */       break;
/*      */     case 6:
/* 1222 */       strFieldName = "runScript";
/* 1223 */       break;
/*      */     case 7:
/* 1225 */       strFieldName = "nodeDesc";
/* 1226 */       break;
/*      */     case 8:
/* 1228 */       strFieldName = "nodeSign";
/* 1229 */       break;
/*      */     case 9:
/* 1231 */       strFieldName = "nodeOrder";
/* 1232 */       break;
/*      */     case 10:
/* 1234 */       strFieldName = "int1";
/* 1235 */       break;
/*      */     case 11:
/* 1237 */       strFieldName = "int2";
/* 1238 */       break;
/*      */     case 12:
/* 1240 */       strFieldName = "varc1";
/* 1241 */       break;
/*      */     case 13:
/* 1243 */       strFieldName = "varc2";
/* 1244 */       break;
/*      */     case 14:
/* 1246 */       strFieldName = "operator";
/* 1247 */       break;
/*      */     case 15:
/* 1249 */       strFieldName = "makeDate";
/* 1250 */       break;
/*      */     case 16:
/* 1252 */       strFieldName = "makeTime";
/* 1253 */       break;
/*      */     case 17:
/* 1255 */       strFieldName = "modifyDate";
/* 1256 */       break;
/*      */     case 18:
/* 1258 */       strFieldName = "modifyTime";
/* 1259 */       break;
/*      */     case 19:
/* 1261 */       strFieldName = "edorNo";
/* 1262 */       break;
/*      */     case 20:
/* 1264 */       strFieldName = "edorType";
/* 1265 */       break;
/*      */     case 21:
/* 1267 */       strFieldName = "edorCase";
/* 1268 */       break;
/*      */     case 22:
/* 1270 */       strFieldName = "operator2";
/* 1271 */       break;
/*      */     case 23:
/* 1273 */       strFieldName = "makeDate2";
/* 1274 */       break;
/*      */     case 24:
/* 1276 */       strFieldName = "makeTime2";
/* 1277 */       break;
/*      */     default:
/* 1279 */       strFieldName = "";
/*      */     }
/* 1281 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1287 */     if (strFieldName.equals("nodeCode")) {
/* 1288 */       return 0;
/*      */     }
/* 1290 */     if (strFieldName.equals("parentID")) {
/* 1291 */       return 0;
/*      */     }
/* 1293 */     if (strFieldName.equals("nodeLevel")) {
/* 1294 */       return 0;
/*      */     }
/* 1296 */     if (strFieldName.equals("nodeName")) {
/* 1297 */       return 0;
/*      */     }
/* 1299 */     if (strFieldName.equals("childFlag")) {
/* 1300 */       return 0;
/*      */     }
/* 1302 */     if (strFieldName.equals("nodeKey")) {
/* 1303 */       return 0;
/*      */     }
/* 1305 */     if (strFieldName.equals("runScript")) {
/* 1306 */       return 0;
/*      */     }
/* 1308 */     if (strFieldName.equals("nodeDesc")) {
/* 1309 */       return 0;
/*      */     }
/* 1311 */     if (strFieldName.equals("nodeSign")) {
/* 1312 */       return 0;
/*      */     }
/* 1314 */     if (strFieldName.equals("nodeOrder")) {
/* 1315 */       return 3;
/*      */     }
/* 1317 */     if (strFieldName.equals("int1")) {
/* 1318 */       return 3;
/*      */     }
/* 1320 */     if (strFieldName.equals("int2")) {
/* 1321 */       return 3;
/*      */     }
/* 1323 */     if (strFieldName.equals("varc1")) {
/* 1324 */       return 0;
/*      */     }
/* 1326 */     if (strFieldName.equals("varc2")) {
/* 1327 */       return 0;
/*      */     }
/* 1329 */     if (strFieldName.equals("operator")) {
/* 1330 */       return 0;
/*      */     }
/* 1332 */     if (strFieldName.equals("makeDate")) {
/* 1333 */       return 1;
/*      */     }
/* 1335 */     if (strFieldName.equals("makeTime")) {
/* 1336 */       return 0;
/*      */     }
/* 1338 */     if (strFieldName.equals("modifyDate")) {
/* 1339 */       return 1;
/*      */     }
/* 1341 */     if (strFieldName.equals("modifyTime")) {
/* 1342 */       return 0;
/*      */     }
/* 1344 */     if (strFieldName.equals("edorNo")) {
/* 1345 */       return 0;
/*      */     }
/* 1347 */     if (strFieldName.equals("edorType")) {
/* 1348 */       return 0;
/*      */     }
/* 1350 */     if (strFieldName.equals("edorCase")) {
/* 1351 */       return 0;
/*      */     }
/* 1353 */     if (strFieldName.equals("operator2")) {
/* 1354 */       return 0;
/*      */     }
/* 1356 */     if (strFieldName.equals("makeDate2")) {
/* 1357 */       return 1;
/*      */     }
/* 1359 */     if (strFieldName.equals("makeTime2")) {
/* 1360 */       return 0;
/*      */     }
/* 1362 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1368 */     int nFieldType = -1;
/* 1369 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1371 */       nFieldType = 0;
/* 1372 */       break;
/*      */     case 1:
/* 1374 */       nFieldType = 0;
/* 1375 */       break;
/*      */     case 2:
/* 1377 */       nFieldType = 0;
/* 1378 */       break;
/*      */     case 3:
/* 1380 */       nFieldType = 0;
/* 1381 */       break;
/*      */     case 4:
/* 1383 */       nFieldType = 0;
/* 1384 */       break;
/*      */     case 5:
/* 1386 */       nFieldType = 0;
/* 1387 */       break;
/*      */     case 6:
/* 1389 */       nFieldType = 0;
/* 1390 */       break;
/*      */     case 7:
/* 1392 */       nFieldType = 0;
/* 1393 */       break;
/*      */     case 8:
/* 1395 */       nFieldType = 0;
/* 1396 */       break;
/*      */     case 9:
/* 1398 */       nFieldType = 3;
/* 1399 */       break;
/*      */     case 10:
/* 1401 */       nFieldType = 3;
/* 1402 */       break;
/*      */     case 11:
/* 1404 */       nFieldType = 3;
/* 1405 */       break;
/*      */     case 12:
/* 1407 */       nFieldType = 0;
/* 1408 */       break;
/*      */     case 13:
/* 1410 */       nFieldType = 0;
/* 1411 */       break;
/*      */     case 14:
/* 1413 */       nFieldType = 0;
/* 1414 */       break;
/*      */     case 15:
/* 1416 */       nFieldType = 1;
/* 1417 */       break;
/*      */     case 16:
/* 1419 */       nFieldType = 0;
/* 1420 */       break;
/*      */     case 17:
/* 1422 */       nFieldType = 1;
/* 1423 */       break;
/*      */     case 18:
/* 1425 */       nFieldType = 0;
/* 1426 */       break;
/*      */     case 19:
/* 1428 */       nFieldType = 0;
/* 1429 */       break;
/*      */     case 20:
/* 1431 */       nFieldType = 0;
/* 1432 */       break;
/*      */     case 21:
/* 1434 */       nFieldType = 0;
/* 1435 */       break;
/*      */     case 22:
/* 1437 */       nFieldType = 0;
/* 1438 */       break;
/*      */     case 23:
/* 1440 */       nFieldType = 1;
/* 1441 */       break;
/*      */     case 24:
/* 1443 */       nFieldType = 0;
/* 1444 */       break;
/*      */     default:
/* 1446 */       nFieldType = -1;
/*      */     }
/* 1448 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MMenuBSchema
 * JD-Core Version:    0.6.0
 */