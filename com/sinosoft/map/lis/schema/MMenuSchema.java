/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MMenuDB;
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
/*      */ public class MMenuSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String nodeCode;
/*      */   private String nodeName;
/*      */   private String parentNodeCode;
/*      */   private String nodeLevel;
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
/*      */   public static final int FIELDNUM = 19;
/*      */   private static String[] PK;
/*   62 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MMenuSchema()
/*      */   {
/*   69 */     this.mErrors = new CErrors();
/*      */ 
/*   71 */     String[] pk = new String[1];
/*   72 */     pk[0] = "NodeCode";
/*      */ 
/*   74 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   81 */     MMenuSchema cloned = (MMenuSchema)super.clone();
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
/*      */   public String getNodeCode()
/*      */   {
/*   95 */     return this.nodeCode;
/*      */   }
/*      */ 
/*      */   public void setNodeCode(String aNodeCode) {
/*   99 */     this.nodeCode = aNodeCode;
/*      */   }
/*      */ 
/*      */   public String getNodeName() {
/*  103 */     return this.nodeName;
/*      */   }
/*      */ 
/*      */   public void setNodeName(String aNodeName) {
/*  107 */     this.nodeName = aNodeName;
/*      */   }
/*      */ 
/*      */   public String getParentNodeCode() {
/*  111 */     return this.parentNodeCode;
/*      */   }
/*      */ 
/*      */   public void setParentNodeCode(String aParentNodeCode) {
/*  115 */     this.parentNodeCode = aParentNodeCode;
/*      */   }
/*      */ 
/*      */   public String getNodeLevel() {
/*  119 */     return this.nodeLevel;
/*      */   }
/*      */ 
/*      */   public void setNodeLevel(String aNodeLevel) {
/*  123 */     this.nodeLevel = aNodeLevel;
/*      */   }
/*      */ 
/*      */   public String getChildFlag() {
/*  127 */     return this.childFlag;
/*      */   }
/*      */ 
/*      */   public void setChildFlag(String aChildFlag) {
/*  131 */     this.childFlag = aChildFlag;
/*      */   }
/*      */ 
/*      */   public String getNodeKey() {
/*  135 */     return this.nodeKey;
/*      */   }
/*      */ 
/*      */   public void setNodeKey(String aNodeKey) {
/*  139 */     this.nodeKey = aNodeKey;
/*      */   }
/*      */ 
/*      */   public String getRunScript() {
/*  143 */     return this.runScript;
/*      */   }
/*      */ 
/*      */   public void setRunScript(String aRunScript) {
/*  147 */     this.runScript = aRunScript;
/*      */   }
/*      */ 
/*      */   public String getNodeDesc() {
/*  151 */     return this.nodeDesc;
/*      */   }
/*      */ 
/*      */   public void setNodeDesc(String aNodeDesc) {
/*  155 */     this.nodeDesc = aNodeDesc;
/*      */   }
/*      */ 
/*      */   public String getNodeSign() {
/*  159 */     return this.nodeSign;
/*      */   }
/*      */ 
/*      */   public void setNodeSign(String aNodeSign) {
/*  163 */     this.nodeSign = aNodeSign;
/*      */   }
/*      */ 
/*      */   public int getNodeOrder() {
/*  167 */     return this.nodeOrder;
/*      */   }
/*      */ 
/*      */   public void setNodeOrder(int aNodeOrder) {
/*  171 */     this.nodeOrder = aNodeOrder;
/*      */   }
/*      */ 
/*      */   public void setNodeOrder(String aNodeOrder) {
/*  175 */     if ((aNodeOrder != null) && (!aNodeOrder.equals("")))
/*      */     {
/*  177 */       Integer tInteger = new Integer(aNodeOrder);
/*  178 */       int i = tInteger.intValue();
/*  179 */       this.nodeOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInt1()
/*      */   {
/*  185 */     return this.int1;
/*      */   }
/*      */ 
/*      */   public void setInt1(int aInt1) {
/*  189 */     this.int1 = aInt1;
/*      */   }
/*      */ 
/*      */   public void setInt1(String aInt1) {
/*  193 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*      */     {
/*  195 */       Integer tInteger = new Integer(aInt1);
/*  196 */       int i = tInteger.intValue();
/*  197 */       this.int1 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getInt2()
/*      */   {
/*  203 */     return this.int2;
/*      */   }
/*      */ 
/*      */   public void setInt2(int aInt2) {
/*  207 */     this.int2 = aInt2;
/*      */   }
/*      */ 
/*      */   public void setInt2(String aInt2) {
/*  211 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*      */     {
/*  213 */       Integer tInteger = new Integer(aInt2);
/*  214 */       int i = tInteger.intValue();
/*  215 */       this.int2 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getVarc1()
/*      */   {
/*  221 */     return this.varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  225 */     this.varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  229 */     return this.varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  233 */     this.varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  237 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  241 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  245 */     if (this.makeDate != null) {
/*  246 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  248 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  252 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  256 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  258 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  261 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  266 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  270 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  274 */     if (this.modifyDate != null) {
/*  275 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  277 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  281 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  285 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  287 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  290 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  295 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  299 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MMenuSchema aMMenuSchema)
/*      */   {
/*  305 */     this.nodeCode = aMMenuSchema.getNodeCode();
/*  306 */     this.nodeName = aMMenuSchema.getNodeName();
/*  307 */     this.parentNodeCode = aMMenuSchema.getParentNodeCode();
/*  308 */     this.nodeLevel = aMMenuSchema.getNodeLevel();
/*  309 */     this.childFlag = aMMenuSchema.getChildFlag();
/*  310 */     this.nodeKey = aMMenuSchema.getNodeKey();
/*  311 */     this.runScript = aMMenuSchema.getRunScript();
/*  312 */     this.nodeDesc = aMMenuSchema.getNodeDesc();
/*  313 */     this.nodeSign = aMMenuSchema.getNodeSign();
/*  314 */     this.nodeOrder = aMMenuSchema.getNodeOrder();
/*  315 */     this.int1 = aMMenuSchema.getInt1();
/*  316 */     this.int2 = aMMenuSchema.getInt2();
/*  317 */     this.varc1 = aMMenuSchema.getVarc1();
/*  318 */     this.varc2 = aMMenuSchema.getVarc2();
/*  319 */     this.operator = aMMenuSchema.getOperator();
/*  320 */     this.makeDate = this.fDate.getDate(aMMenuSchema.getMakeDate());
/*  321 */     this.makeTime = aMMenuSchema.getMakeTime();
/*  322 */     this.modifyDate = this.fDate.getDate(aMMenuSchema.getModifyDate());
/*  323 */     this.modifyTime = aMMenuSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  332 */       if (rs.getString("NodeCode") == null)
/*  333 */         this.nodeCode = null;
/*      */       else {
/*  335 */         this.nodeCode = rs.getString("NodeCode").trim();
/*      */       }
/*  337 */       if (rs.getString("NodeName") == null)
/*  338 */         this.nodeName = null;
/*      */       else {
/*  340 */         this.nodeName = rs.getString("NodeName").trim();
/*      */       }
/*  342 */       if (rs.getString("ParentNodeCode") == null)
/*  343 */         this.parentNodeCode = null;
/*      */       else {
/*  345 */         this.parentNodeCode = rs.getString("ParentNodeCode").trim();
/*      */       }
/*  347 */       if (rs.getString("NodeLevel") == null)
/*  348 */         this.nodeLevel = null;
/*      */       else {
/*  350 */         this.nodeLevel = rs.getString("NodeLevel").trim();
/*      */       }
/*  352 */       if (rs.getString("ChildFlag") == null)
/*  353 */         this.childFlag = null;
/*      */       else {
/*  355 */         this.childFlag = rs.getString("ChildFlag").trim();
/*      */       }
/*  357 */       if (rs.getString("NodeKey") == null)
/*  358 */         this.nodeKey = null;
/*      */       else {
/*  360 */         this.nodeKey = rs.getString("NodeKey").trim();
/*      */       }
/*  362 */       if (rs.getString("RunScript") == null)
/*  363 */         this.runScript = null;
/*      */       else {
/*  365 */         this.runScript = rs.getString("RunScript").trim();
/*      */       }
/*  367 */       if (rs.getString("NodeDesc") == null)
/*  368 */         this.nodeDesc = null;
/*      */       else {
/*  370 */         this.nodeDesc = rs.getString("NodeDesc").trim();
/*      */       }
/*  372 */       if (rs.getString("NodeSign") == null)
/*  373 */         this.nodeSign = null;
/*      */       else {
/*  375 */         this.nodeSign = rs.getString("NodeSign").trim();
/*      */       }
/*  377 */       this.nodeOrder = rs.getInt("NodeOrder");
/*  378 */       this.int1 = rs.getInt("Int1");
/*  379 */       this.int2 = rs.getInt("Int2");
/*  380 */       if (rs.getString("Varc1") == null)
/*  381 */         this.varc1 = null;
/*      */       else {
/*  383 */         this.varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  385 */       if (rs.getString("Varc2") == null)
/*  386 */         this.varc2 = null;
/*      */       else {
/*  388 */         this.varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  390 */       if (rs.getString("Operator") == null)
/*  391 */         this.operator = null;
/*      */       else {
/*  393 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  395 */       this.makeDate = rs.getDate("MakeDate");
/*  396 */       if (rs.getString("MakeTime") == null)
/*  397 */         this.makeTime = null;
/*      */       else {
/*  399 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  401 */       this.modifyDate = rs.getDate("ModifyDate");
/*  402 */       if (rs.getString("ModifyTime") == null)
/*  403 */         this.modifyTime = null;
/*      */       else {
/*  405 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  410 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MMenu\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  412 */       CError tError = new CError();
/*  413 */       tError.moduleName = "MMenuSchema";
/*  414 */       tError.functionName = "setSchema";
/*  415 */       tError.errorMessage = sqle.toString();
/*  416 */       this.mErrors.addOneError(tError);
/*  417 */       return false;
/*      */     }
/*  419 */     return true;
/*      */   }
/*      */ 
/*      */   public MMenuSchema getSchema()
/*      */   {
/*  424 */     MMenuSchema aMMenuSchema = new MMenuSchema();
/*  425 */     aMMenuSchema.setSchema(this);
/*  426 */     return aMMenuSchema;
/*      */   }
/*      */ 
/*      */   public MMenuDB getDB()
/*      */   {
/*  431 */     MMenuDB aDBOper = new MMenuDB();
/*  432 */     aDBOper.setSchema(this);
/*  433 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  440 */     StringBuffer strReturn = new StringBuffer(256);
/*  441 */     strReturn.append(StrTool.cTrim(this.nodeCode)); strReturn.append("|");
/*  442 */     strReturn.append(StrTool.cTrim(this.nodeName)); strReturn.append("|");
/*  443 */     strReturn.append(StrTool.cTrim(this.parentNodeCode)); strReturn.append("|");
/*  444 */     strReturn.append(StrTool.cTrim(this.nodeLevel)); strReturn.append("|");
/*  445 */     strReturn.append(StrTool.cTrim(this.childFlag)); strReturn.append("|");
/*  446 */     strReturn.append(StrTool.cTrim(this.nodeKey)); strReturn.append("|");
/*  447 */     strReturn.append(StrTool.cTrim(this.runScript)); strReturn.append("|");
/*  448 */     strReturn.append(StrTool.cTrim(this.nodeDesc)); strReturn.append("|");
/*  449 */     strReturn.append(StrTool.cTrim(this.nodeSign)); strReturn.append("|");
/*  450 */     strReturn.append(ChgData.chgData(this.nodeOrder)); strReturn.append("|");
/*  451 */     strReturn.append(ChgData.chgData(this.int1)); strReturn.append("|");
/*  452 */     strReturn.append(ChgData.chgData(this.int2)); strReturn.append("|");
/*  453 */     strReturn.append(StrTool.cTrim(this.varc1)); strReturn.append("|");
/*  454 */     strReturn.append(StrTool.cTrim(this.varc2)); strReturn.append("|");
/*  455 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  456 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  457 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  458 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  459 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  460 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  468 */       this.nodeCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  469 */       this.nodeName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  470 */       this.parentNodeCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  471 */       this.nodeLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  472 */       this.childFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  473 */       this.nodeKey = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  474 */       this.runScript = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  475 */       this.nodeDesc = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  476 */       this.nodeSign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  477 */       this.nodeOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/*  478 */       this.int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).intValue();
/*  479 */       this.int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).intValue();
/*  480 */       this.varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  481 */       this.varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  482 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  483 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  484 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  485 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*  486 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  491 */       CError tError = new CError();
/*  492 */       tError.moduleName = "MMenuSchema";
/*  493 */       tError.functionName = "decode";
/*  494 */       tError.errorMessage = ex.toString();
/*  495 */       this.mErrors.addOneError(tError);
/*      */ 
/*  497 */       return false;
/*      */     }
/*  499 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  505 */     String strReturn = "";
/*  506 */     if (FCode.equalsIgnoreCase("nodeCode"))
/*      */     {
/*  508 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeCode));
/*      */     }
/*  510 */     if (FCode.equalsIgnoreCase("nodeName"))
/*      */     {
/*  512 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeName));
/*      */     }
/*  514 */     if (FCode.equalsIgnoreCase("parentNodeCode"))
/*      */     {
/*  516 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.parentNodeCode));
/*      */     }
/*  518 */     if (FCode.equalsIgnoreCase("nodeLevel"))
/*      */     {
/*  520 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeLevel));
/*      */     }
/*  522 */     if (FCode.equalsIgnoreCase("childFlag"))
/*      */     {
/*  524 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.childFlag));
/*      */     }
/*  526 */     if (FCode.equalsIgnoreCase("nodeKey"))
/*      */     {
/*  528 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeKey));
/*      */     }
/*  530 */     if (FCode.equalsIgnoreCase("runScript"))
/*      */     {
/*  532 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.runScript));
/*      */     }
/*  534 */     if (FCode.equalsIgnoreCase("nodeDesc"))
/*      */     {
/*  536 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeDesc));
/*      */     }
/*  538 */     if (FCode.equalsIgnoreCase("nodeSign"))
/*      */     {
/*  540 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeSign));
/*      */     }
/*  542 */     if (FCode.equalsIgnoreCase("nodeOrder"))
/*      */     {
/*  544 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeOrder));
/*      */     }
/*  546 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  548 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int1));
/*      */     }
/*  550 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  552 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int2));
/*      */     }
/*  554 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  556 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc1));
/*      */     }
/*  558 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  560 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc2));
/*      */     }
/*  562 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  564 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  566 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  568 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  570 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  572 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  574 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  576 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  578 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  580 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  582 */     if (strReturn.equals(""))
/*      */     {
/*  584 */       strReturn = "null";
/*      */     }
/*      */ 
/*  587 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  594 */     String strFieldValue = "";
/*  595 */     switch (nFieldIndex) {
/*      */     case 0:
/*  597 */       strFieldValue = StrTool.GBKToUnicode(this.nodeCode);
/*  598 */       break;
/*      */     case 1:
/*  600 */       strFieldValue = StrTool.GBKToUnicode(this.nodeName);
/*  601 */       break;
/*      */     case 2:
/*  603 */       strFieldValue = StrTool.GBKToUnicode(this.parentNodeCode);
/*  604 */       break;
/*      */     case 3:
/*  606 */       strFieldValue = StrTool.GBKToUnicode(this.nodeLevel);
/*  607 */       break;
/*      */     case 4:
/*  609 */       strFieldValue = StrTool.GBKToUnicode(this.childFlag);
/*  610 */       break;
/*      */     case 5:
/*  612 */       strFieldValue = StrTool.GBKToUnicode(this.nodeKey);
/*  613 */       break;
/*      */     case 6:
/*  615 */       strFieldValue = StrTool.GBKToUnicode(this.runScript);
/*  616 */       break;
/*      */     case 7:
/*  618 */       strFieldValue = StrTool.GBKToUnicode(this.nodeDesc);
/*  619 */       break;
/*      */     case 8:
/*  621 */       strFieldValue = StrTool.GBKToUnicode(this.nodeSign);
/*  622 */       break;
/*      */     case 9:
/*  624 */       strFieldValue = String.valueOf(this.nodeOrder);
/*  625 */       break;
/*      */     case 10:
/*  627 */       strFieldValue = String.valueOf(this.int1);
/*  628 */       break;
/*      */     case 11:
/*  630 */       strFieldValue = String.valueOf(this.int2);
/*  631 */       break;
/*      */     case 12:
/*  633 */       strFieldValue = StrTool.GBKToUnicode(this.varc1);
/*  634 */       break;
/*      */     case 13:
/*  636 */       strFieldValue = StrTool.GBKToUnicode(this.varc2);
/*  637 */       break;
/*      */     case 14:
/*  639 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  640 */       break;
/*      */     case 15:
/*  642 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  643 */       break;
/*      */     case 16:
/*  645 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  646 */       break;
/*      */     case 17:
/*  648 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  649 */       break;
/*      */     case 18:
/*  651 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  652 */       break;
/*      */     default:
/*  654 */       strFieldValue = "";
/*      */     }
/*  656 */     if (strFieldValue.equals("")) {
/*  657 */       strFieldValue = "null";
/*      */     }
/*  659 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  665 */     if (StrTool.cTrim(FCode).equals("")) {
/*  666 */       return false;
/*      */     }
/*  668 */     if (FCode.equalsIgnoreCase("nodeCode"))
/*      */     {
/*  670 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  672 */         this.nodeCode = FValue.trim();
/*      */       }
/*      */       else
/*  675 */         this.nodeCode = null;
/*      */     }
/*  677 */     if (FCode.equalsIgnoreCase("nodeName"))
/*      */     {
/*  679 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  681 */         this.nodeName = FValue.trim();
/*      */       }
/*      */       else
/*  684 */         this.nodeName = null;
/*      */     }
/*  686 */     if (FCode.equalsIgnoreCase("parentNodeCode"))
/*      */     {
/*  688 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  690 */         this.parentNodeCode = FValue.trim();
/*      */       }
/*      */       else
/*  693 */         this.parentNodeCode = null;
/*      */     }
/*  695 */     if (FCode.equalsIgnoreCase("nodeLevel"))
/*      */     {
/*  697 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  699 */         this.nodeLevel = FValue.trim();
/*      */       }
/*      */       else
/*  702 */         this.nodeLevel = null;
/*      */     }
/*  704 */     if (FCode.equalsIgnoreCase("childFlag"))
/*      */     {
/*  706 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  708 */         this.childFlag = FValue.trim();
/*      */       }
/*      */       else
/*  711 */         this.childFlag = null;
/*      */     }
/*  713 */     if (FCode.equalsIgnoreCase("nodeKey"))
/*      */     {
/*  715 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  717 */         this.nodeKey = FValue.trim();
/*      */       }
/*      */       else
/*  720 */         this.nodeKey = null;
/*      */     }
/*  722 */     if (FCode.equalsIgnoreCase("runScript"))
/*      */     {
/*  724 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  726 */         this.runScript = FValue.trim();
/*      */       }
/*      */       else
/*  729 */         this.runScript = null;
/*      */     }
/*  731 */     if (FCode.equalsIgnoreCase("nodeDesc"))
/*      */     {
/*  733 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  735 */         this.nodeDesc = FValue.trim();
/*      */       }
/*      */       else
/*  738 */         this.nodeDesc = null;
/*      */     }
/*  740 */     if (FCode.equalsIgnoreCase("nodeSign"))
/*      */     {
/*  742 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  744 */         this.nodeSign = FValue.trim();
/*      */       }
/*      */       else
/*  747 */         this.nodeSign = null;
/*      */     }
/*  749 */     if (FCode.equalsIgnoreCase("nodeOrder"))
/*      */     {
/*  751 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  753 */         Integer tInteger = new Integer(FValue);
/*  754 */         int i = tInteger.intValue();
/*  755 */         this.nodeOrder = i;
/*      */       }
/*      */     }
/*  758 */     if (FCode.equalsIgnoreCase("int1"))
/*      */     {
/*  760 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  762 */         Integer tInteger = new Integer(FValue);
/*  763 */         int i = tInteger.intValue();
/*  764 */         this.int1 = i;
/*      */       }
/*      */     }
/*  767 */     if (FCode.equalsIgnoreCase("int2"))
/*      */     {
/*  769 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  771 */         Integer tInteger = new Integer(FValue);
/*  772 */         int i = tInteger.intValue();
/*  773 */         this.int2 = i;
/*      */       }
/*      */     }
/*  776 */     if (FCode.equalsIgnoreCase("varc1"))
/*      */     {
/*  778 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  780 */         this.varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  783 */         this.varc1 = null;
/*      */     }
/*  785 */     if (FCode.equalsIgnoreCase("varc2"))
/*      */     {
/*  787 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  789 */         this.varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  792 */         this.varc2 = null;
/*      */     }
/*  794 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  796 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  798 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  801 */         this.operator = null;
/*      */     }
/*  803 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  805 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  807 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  810 */         this.makeDate = null;
/*      */     }
/*  812 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  814 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  816 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  819 */         this.makeTime = null;
/*      */     }
/*  821 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  823 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  825 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  828 */         this.modifyDate = null;
/*      */     }
/*  830 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  832 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  834 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  837 */         this.modifyTime = null;
/*      */     }
/*  839 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  844 */     if (otherObject == null) return false;
/*  845 */     if (this == otherObject) return true;
/*  846 */     if (getClass() != otherObject.getClass()) return false;
/*  847 */     MMenuSchema other = (MMenuSchema)otherObject;
/*  848 */     if ((this.nodeCode == null) && (other.getNodeCode() != null)) return false;
/*  849 */     if ((this.nodeCode != null) && (!this.nodeCode.equals(other.getNodeCode()))) return false;
/*  850 */     if ((this.nodeName == null) && (other.getNodeName() != null)) return false;
/*  851 */     if ((this.nodeName != null) && (!this.nodeName.equals(other.getNodeName()))) return false;
/*  852 */     if ((this.parentNodeCode == null) && (other.getParentNodeCode() != null)) return false;
/*  853 */     if ((this.parentNodeCode != null) && (!this.parentNodeCode.equals(other.getParentNodeCode()))) return false;
/*  854 */     if ((this.nodeLevel == null) && (other.getNodeLevel() != null)) return false;
/*  855 */     if ((this.nodeLevel != null) && (!this.nodeLevel.equals(other.getNodeLevel()))) return false;
/*  856 */     if ((this.childFlag == null) && (other.getChildFlag() != null)) return false;
/*  857 */     if ((this.childFlag != null) && (!this.childFlag.equals(other.getChildFlag()))) return false;
/*  858 */     if ((this.nodeKey == null) && (other.getNodeKey() != null)) return false;
/*  859 */     if ((this.nodeKey != null) && (!this.nodeKey.equals(other.getNodeKey()))) return false;
/*  860 */     if ((this.runScript == null) && (other.getRunScript() != null)) return false;
/*  861 */     if ((this.runScript != null) && (!this.runScript.equals(other.getRunScript()))) return false;
/*  862 */     if ((this.nodeDesc == null) && (other.getNodeDesc() != null)) return false;
/*  863 */     if ((this.nodeDesc != null) && (!this.nodeDesc.equals(other.getNodeDesc()))) return false;
/*  864 */     if ((this.nodeSign == null) && (other.getNodeSign() != null)) return false;
/*  865 */     if ((this.nodeSign != null) && (!this.nodeSign.equals(other.getNodeSign()))) return false;
/*  866 */     if (this.nodeOrder != other.getNodeOrder()) return false;
/*  867 */     if (this.int1 != other.getInt1()) return false;
/*  868 */     if (this.int2 != other.getInt2()) return false;
/*  869 */     if ((this.varc1 == null) && (other.getVarc1() != null)) return false;
/*  870 */     if ((this.varc1 != null) && (!this.varc1.equals(other.getVarc1()))) return false;
/*  871 */     if ((this.varc2 == null) && (other.getVarc2() != null)) return false;
/*  872 */     if ((this.varc2 != null) && (!this.varc2.equals(other.getVarc2()))) return false;
/*  873 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  874 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  875 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  876 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  877 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  878 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  879 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  880 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  881 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  882 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  889 */     return 19;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  895 */     if (strFieldName.equals("nodeCode")) {
/*  896 */       return 0;
/*      */     }
/*  898 */     if (strFieldName.equals("nodeName")) {
/*  899 */       return 1;
/*      */     }
/*  901 */     if (strFieldName.equals("parentNodeCode")) {
/*  902 */       return 2;
/*      */     }
/*  904 */     if (strFieldName.equals("nodeLevel")) {
/*  905 */       return 3;
/*      */     }
/*  907 */     if (strFieldName.equals("childFlag")) {
/*  908 */       return 4;
/*      */     }
/*  910 */     if (strFieldName.equals("nodeKey")) {
/*  911 */       return 5;
/*      */     }
/*  913 */     if (strFieldName.equals("runScript")) {
/*  914 */       return 6;
/*      */     }
/*  916 */     if (strFieldName.equals("nodeDesc")) {
/*  917 */       return 7;
/*      */     }
/*  919 */     if (strFieldName.equals("nodeSign")) {
/*  920 */       return 8;
/*      */     }
/*  922 */     if (strFieldName.equals("nodeOrder")) {
/*  923 */       return 9;
/*      */     }
/*  925 */     if (strFieldName.equals("int1")) {
/*  926 */       return 10;
/*      */     }
/*  928 */     if (strFieldName.equals("int2")) {
/*  929 */       return 11;
/*      */     }
/*  931 */     if (strFieldName.equals("varc1")) {
/*  932 */       return 12;
/*      */     }
/*  934 */     if (strFieldName.equals("varc2")) {
/*  935 */       return 13;
/*      */     }
/*  937 */     if (strFieldName.equals("operator")) {
/*  938 */       return 14;
/*      */     }
/*  940 */     if (strFieldName.equals("makeDate")) {
/*  941 */       return 15;
/*      */     }
/*  943 */     if (strFieldName.equals("makeTime")) {
/*  944 */       return 16;
/*      */     }
/*  946 */     if (strFieldName.equals("modifyDate")) {
/*  947 */       return 17;
/*      */     }
/*  949 */     if (strFieldName.equals("modifyTime")) {
/*  950 */       return 18;
/*      */     }
/*  952 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  958 */     String strFieldName = "";
/*  959 */     switch (nFieldIndex) {
/*      */     case 0:
/*  961 */       strFieldName = "nodeCode";
/*  962 */       break;
/*      */     case 1:
/*  964 */       strFieldName = "nodeName";
/*  965 */       break;
/*      */     case 2:
/*  967 */       strFieldName = "parentNodeCode";
/*  968 */       break;
/*      */     case 3:
/*  970 */       strFieldName = "nodeLevel";
/*  971 */       break;
/*      */     case 4:
/*  973 */       strFieldName = "childFlag";
/*  974 */       break;
/*      */     case 5:
/*  976 */       strFieldName = "nodeKey";
/*  977 */       break;
/*      */     case 6:
/*  979 */       strFieldName = "runScript";
/*  980 */       break;
/*      */     case 7:
/*  982 */       strFieldName = "nodeDesc";
/*  983 */       break;
/*      */     case 8:
/*  985 */       strFieldName = "nodeSign";
/*  986 */       break;
/*      */     case 9:
/*  988 */       strFieldName = "nodeOrder";
/*  989 */       break;
/*      */     case 10:
/*  991 */       strFieldName = "int1";
/*  992 */       break;
/*      */     case 11:
/*  994 */       strFieldName = "int2";
/*  995 */       break;
/*      */     case 12:
/*  997 */       strFieldName = "varc1";
/*  998 */       break;
/*      */     case 13:
/* 1000 */       strFieldName = "varc2";
/* 1001 */       break;
/*      */     case 14:
/* 1003 */       strFieldName = "operator";
/* 1004 */       break;
/*      */     case 15:
/* 1006 */       strFieldName = "makeDate";
/* 1007 */       break;
/*      */     case 16:
/* 1009 */       strFieldName = "makeTime";
/* 1010 */       break;
/*      */     case 17:
/* 1012 */       strFieldName = "modifyDate";
/* 1013 */       break;
/*      */     case 18:
/* 1015 */       strFieldName = "modifyTime";
/* 1016 */       break;
/*      */     default:
/* 1018 */       strFieldName = "";
/*      */     }
/* 1020 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1026 */     if (strFieldName.equals("nodeCode")) {
/* 1027 */       return 0;
/*      */     }
/* 1029 */     if (strFieldName.equals("nodeName")) {
/* 1030 */       return 0;
/*      */     }
/* 1032 */     if (strFieldName.equals("parentNodeCode")) {
/* 1033 */       return 0;
/*      */     }
/* 1035 */     if (strFieldName.equals("nodeLevel")) {
/* 1036 */       return 0;
/*      */     }
/* 1038 */     if (strFieldName.equals("childFlag")) {
/* 1039 */       return 0;
/*      */     }
/* 1041 */     if (strFieldName.equals("nodeKey")) {
/* 1042 */       return 0;
/*      */     }
/* 1044 */     if (strFieldName.equals("runScript")) {
/* 1045 */       return 0;
/*      */     }
/* 1047 */     if (strFieldName.equals("nodeDesc")) {
/* 1048 */       return 0;
/*      */     }
/* 1050 */     if (strFieldName.equals("nodeSign")) {
/* 1051 */       return 0;
/*      */     }
/* 1053 */     if (strFieldName.equals("nodeOrder")) {
/* 1054 */       return 3;
/*      */     }
/* 1056 */     if (strFieldName.equals("int1")) {
/* 1057 */       return 3;
/*      */     }
/* 1059 */     if (strFieldName.equals("int2")) {
/* 1060 */       return 3;
/*      */     }
/* 1062 */     if (strFieldName.equals("varc1")) {
/* 1063 */       return 0;
/*      */     }
/* 1065 */     if (strFieldName.equals("varc2")) {
/* 1066 */       return 0;
/*      */     }
/* 1068 */     if (strFieldName.equals("operator")) {
/* 1069 */       return 0;
/*      */     }
/* 1071 */     if (strFieldName.equals("makeDate")) {
/* 1072 */       return 1;
/*      */     }
/* 1074 */     if (strFieldName.equals("makeTime")) {
/* 1075 */       return 0;
/*      */     }
/* 1077 */     if (strFieldName.equals("modifyDate")) {
/* 1078 */       return 1;
/*      */     }
/* 1080 */     if (strFieldName.equals("modifyTime")) {
/* 1081 */       return 0;
/*      */     }
/* 1083 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1089 */     int nFieldType = -1;
/* 1090 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1092 */       nFieldType = 0;
/* 1093 */       break;
/*      */     case 1:
/* 1095 */       nFieldType = 0;
/* 1096 */       break;
/*      */     case 2:
/* 1098 */       nFieldType = 0;
/* 1099 */       break;
/*      */     case 3:
/* 1101 */       nFieldType = 0;
/* 1102 */       break;
/*      */     case 4:
/* 1104 */       nFieldType = 0;
/* 1105 */       break;
/*      */     case 5:
/* 1107 */       nFieldType = 0;
/* 1108 */       break;
/*      */     case 6:
/* 1110 */       nFieldType = 0;
/* 1111 */       break;
/*      */     case 7:
/* 1113 */       nFieldType = 0;
/* 1114 */       break;
/*      */     case 8:
/* 1116 */       nFieldType = 0;
/* 1117 */       break;
/*      */     case 9:
/* 1119 */       nFieldType = 3;
/* 1120 */       break;
/*      */     case 10:
/* 1122 */       nFieldType = 3;
/* 1123 */       break;
/*      */     case 11:
/* 1125 */       nFieldType = 3;
/* 1126 */       break;
/*      */     case 12:
/* 1128 */       nFieldType = 0;
/* 1129 */       break;
/*      */     case 13:
/* 1131 */       nFieldType = 0;
/* 1132 */       break;
/*      */     case 14:
/* 1134 */       nFieldType = 0;
/* 1135 */       break;
/*      */     case 15:
/* 1137 */       nFieldType = 1;
/* 1138 */       break;
/*      */     case 16:
/* 1140 */       nFieldType = 0;
/* 1141 */       break;
/*      */     case 17:
/* 1143 */       nFieldType = 1;
/* 1144 */       break;
/*      */     case 18:
/* 1146 */       nFieldType = 0;
/* 1147 */       break;
/*      */     default:
/* 1149 */       nFieldType = -1;
/*      */     }
/* 1151 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MMenuSchema
 * JD-Core Version:    0.6.0
 */