/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MSysLinkDB;
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
/*      */ public class MSysLinkSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String refURL;
/*      */   private String target;
/*      */   private String name;
/*      */   private int linkOrder;
/*      */   private String state;
/*      */   private String type;
/*      */   private String icon;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String vF01;
/*      */   private String nF01;
/*      */   private int iF01;
/*      */   private double dF02;
/*      */   private Date date01;
/*      */   private String modifyOperator;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String description;
/*      */   public static final int FIELDNUM = 22;
/*      */   private static String[] PK;
/*   68 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MSysLinkSchema()
/*      */   {
/*   75 */     this.mErrors = new CErrors();
/*      */ 
/*   77 */     String[] pk = new String[1];
/*   78 */     pk[0] = "ID";
/*      */ 
/*   80 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   87 */     MSysLinkSchema cloned = (MSysLinkSchema)super.clone();
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
/*      */   public String getRefURL() {
/*  109 */     return this.refURL;
/*      */   }
/*      */ 
/*      */   public void setRefURL(String aRefURL) {
/*  113 */     this.refURL = aRefURL;
/*      */   }
/*      */ 
/*      */   public String getTarget() {
/*  117 */     return this.target;
/*      */   }
/*      */ 
/*      */   public void setTarget(String aTarget) {
/*  121 */     this.target = aTarget;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  125 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  129 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public int getLinkOrder() {
/*  133 */     return this.linkOrder;
/*      */   }
/*      */ 
/*      */   public void setLinkOrder(int aLinkOrder) {
/*  137 */     this.linkOrder = aLinkOrder;
/*      */   }
/*      */ 
/*      */   public void setLinkOrder(String aLinkOrder) {
/*  141 */     if ((aLinkOrder != null) && (!aLinkOrder.equals("")))
/*      */     {
/*  143 */       Integer tInteger = new Integer(aLinkOrder);
/*  144 */       int i = tInteger.intValue();
/*  145 */       this.linkOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getState()
/*      */   {
/*  151 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  155 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  159 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  163 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public String getIcon() {
/*  167 */     return this.icon;
/*      */   }
/*      */ 
/*      */   public void setIcon(String aIcon) {
/*  171 */     this.icon = aIcon;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  175 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  179 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  183 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  187 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  191 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  195 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  199 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  203 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  207 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  211 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  215 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  217 */       Integer tInteger = new Integer(aIF01);
/*  218 */       int i = tInteger.intValue();
/*  219 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  225 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  229 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  233 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  235 */       Double tDouble = new Double(aDF02);
/*  236 */       double d = tDouble.doubleValue();
/*  237 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  243 */     if (this.date01 != null) {
/*  244 */       return this.fDate.getString(this.date01);
/*      */     }
/*  246 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  250 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  254 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  256 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  259 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  264 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  268 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  272 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  276 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  280 */     if (this.makeDate != null) {
/*  281 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  283 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  287 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  291 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  293 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  296 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  301 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  305 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  309 */     if (this.modifyDate != null) {
/*  310 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  312 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  316 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  320 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  322 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  325 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  330 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  334 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getDescription() {
/*  338 */     return this.description;
/*      */   }
/*      */ 
/*      */   public void setDescription(String aDescription) {
/*  342 */     this.description = aDescription;
/*      */   }
/*      */ 
/*      */   public void setSchema(MSysLinkSchema aMSysLinkSchema)
/*      */   {
/*  348 */     this.iD = aMSysLinkSchema.getID();
/*  349 */     this.refURL = aMSysLinkSchema.getRefURL();
/*  350 */     this.target = aMSysLinkSchema.getTarget();
/*  351 */     this.name = aMSysLinkSchema.getName();
/*  352 */     this.linkOrder = aMSysLinkSchema.getLinkOrder();
/*  353 */     this.state = aMSysLinkSchema.getState();
/*  354 */     this.type = aMSysLinkSchema.getType();
/*  355 */     this.icon = aMSysLinkSchema.getIcon();
/*  356 */     this.manageCom = aMSysLinkSchema.getManageCom();
/*  357 */     this.branchType = aMSysLinkSchema.getBranchType();
/*  358 */     this.vF01 = aMSysLinkSchema.getVF01();
/*  359 */     this.nF01 = aMSysLinkSchema.getNF01();
/*  360 */     this.iF01 = aMSysLinkSchema.getIF01();
/*  361 */     this.dF02 = aMSysLinkSchema.getDF02();
/*  362 */     this.date01 = this.fDate.getDate(aMSysLinkSchema.getDate01());
/*  363 */     this.modifyOperator = aMSysLinkSchema.getModifyOperator();
/*  364 */     this.operator = aMSysLinkSchema.getOperator();
/*  365 */     this.makeDate = this.fDate.getDate(aMSysLinkSchema.getMakeDate());
/*  366 */     this.makeTime = aMSysLinkSchema.getMakeTime();
/*  367 */     this.modifyDate = this.fDate.getDate(aMSysLinkSchema.getModifyDate());
/*  368 */     this.modifyTime = aMSysLinkSchema.getModifyTime();
/*  369 */     this.description = aMSysLinkSchema.getDescription();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  378 */       if (rs.getString("ID") == null)
/*  379 */         this.iD = null;
/*      */       else {
/*  381 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  383 */       if (rs.getString("RefURL") == null)
/*  384 */         this.refURL = null;
/*      */       else {
/*  386 */         this.refURL = rs.getString("RefURL").trim();
/*      */       }
/*  388 */       if (rs.getString("Target") == null)
/*  389 */         this.target = null;
/*      */       else {
/*  391 */         this.target = rs.getString("Target").trim();
/*      */       }
/*  393 */       if (rs.getString("Name") == null)
/*  394 */         this.name = null;
/*      */       else {
/*  396 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  398 */       this.linkOrder = rs.getInt("LinkOrder");
/*  399 */       if (rs.getString("State") == null)
/*  400 */         this.state = null;
/*      */       else {
/*  402 */         this.state = rs.getString("State").trim();
/*      */       }
/*  404 */       if (rs.getString("Type") == null)
/*  405 */         this.type = null;
/*      */       else {
/*  407 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  409 */       if (rs.getString("Icon") == null)
/*  410 */         this.icon = null;
/*      */       else {
/*  412 */         this.icon = rs.getString("Icon").trim();
/*      */       }
/*  414 */       if (rs.getString("ManageCom") == null)
/*  415 */         this.manageCom = null;
/*      */       else {
/*  417 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  419 */       if (rs.getString("BranchType") == null)
/*  420 */         this.branchType = null;
/*      */       else {
/*  422 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  424 */       if (rs.getString("VF01") == null)
/*  425 */         this.vF01 = null;
/*      */       else {
/*  427 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  429 */       if (rs.getString("NF01") == null)
/*  430 */         this.nF01 = null;
/*      */       else {
/*  432 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  434 */       this.iF01 = rs.getInt("IF01");
/*  435 */       this.dF02 = rs.getDouble("DF02");
/*  436 */       this.date01 = rs.getDate("Date01");
/*  437 */       if (rs.getString("ModifyOperator") == null)
/*  438 */         this.modifyOperator = null;
/*      */       else {
/*  440 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  442 */       if (rs.getString("Operator") == null)
/*  443 */         this.operator = null;
/*      */       else {
/*  445 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  447 */       this.makeDate = rs.getDate("MakeDate");
/*  448 */       if (rs.getString("MakeTime") == null)
/*  449 */         this.makeTime = null;
/*      */       else {
/*  451 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  453 */       this.modifyDate = rs.getDate("ModifyDate");
/*  454 */       if (rs.getString("ModifyTime") == null)
/*  455 */         this.modifyTime = null;
/*      */       else {
/*  457 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  459 */       if (rs.getString("Description") == null)
/*  460 */         this.description = null;
/*      */       else {
/*  462 */         this.description = rs.getString("Description").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  467 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MSysLink\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  469 */       CError tError = new CError();
/*  470 */       tError.moduleName = "MSysLinkSchema";
/*  471 */       tError.functionName = "setSchema";
/*  472 */       tError.errorMessage = sqle.toString();
/*  473 */       this.mErrors.addOneError(tError);
/*  474 */       return false;
/*      */     }
/*  476 */     return true;
/*      */   }
/*      */ 
/*      */   public MSysLinkSchema getSchema()
/*      */   {
/*  481 */     MSysLinkSchema aMSysLinkSchema = new MSysLinkSchema();
/*  482 */     aMSysLinkSchema.setSchema(this);
/*  483 */     return aMSysLinkSchema;
/*      */   }
/*      */ 
/*      */   public MSysLinkDB getDB()
/*      */   {
/*  488 */     MSysLinkDB aDBOper = new MSysLinkDB();
/*  489 */     aDBOper.setSchema(this);
/*  490 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  497 */     StringBuffer strReturn = new StringBuffer(256);
/*  498 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  499 */     strReturn.append(StrTool.cTrim(this.refURL)); strReturn.append("|");
/*  500 */     strReturn.append(StrTool.cTrim(this.target)); strReturn.append("|");
/*  501 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  502 */     strReturn.append(ChgData.chgData(this.linkOrder)); strReturn.append("|");
/*  503 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  504 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  505 */     strReturn.append(StrTool.cTrim(this.icon)); strReturn.append("|");
/*  506 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  507 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  508 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  509 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  510 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  511 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  512 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  513 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  514 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  515 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  516 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  517 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  518 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  519 */     strReturn.append(StrTool.cTrim(this.description));
/*  520 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  528 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  529 */       this.refURL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  530 */       this.target = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  531 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  532 */       this.linkOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|"))).intValue();
/*  533 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  534 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  535 */       this.icon = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  536 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  537 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  538 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  539 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  540 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).intValue();
/*  541 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|"))).doubleValue();
/*  542 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  543 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  544 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  545 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*  546 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  547 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  548 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  549 */       this.description = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  554 */       CError tError = new CError();
/*  555 */       tError.moduleName = "MSysLinkSchema";
/*  556 */       tError.functionName = "decode";
/*  557 */       tError.errorMessage = ex.toString();
/*  558 */       this.mErrors.addOneError(tError);
/*      */ 
/*  560 */       return false;
/*      */     }
/*  562 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  568 */     String strReturn = "";
/*  569 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  571 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  573 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  575 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.refURL));
/*      */     }
/*  577 */     if (FCode.equalsIgnoreCase("target"))
/*      */     {
/*  579 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.target));
/*      */     }
/*  581 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  583 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  585 */     if (FCode.equalsIgnoreCase("linkOrder"))
/*      */     {
/*  587 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.linkOrder));
/*      */     }
/*  589 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  591 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  593 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  595 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  597 */     if (FCode.equalsIgnoreCase("icon"))
/*      */     {
/*  599 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.icon));
/*      */     }
/*  601 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  603 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  605 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  607 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  609 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  611 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  613 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  615 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  617 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  619 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  621 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  623 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  625 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  627 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  629 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  631 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  633 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  635 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  637 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  639 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  641 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  643 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  645 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  647 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  649 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  651 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  653 */     if (FCode.equalsIgnoreCase("description"))
/*      */     {
/*  655 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.description));
/*      */     }
/*  657 */     if (strReturn.equals(""))
/*      */     {
/*  659 */       strReturn = "null";
/*      */     }
/*      */ 
/*  662 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  669 */     String strFieldValue = "";
/*  670 */     switch (nFieldIndex) {
/*      */     case 0:
/*  672 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  673 */       break;
/*      */     case 1:
/*  675 */       strFieldValue = StrTool.GBKToUnicode(this.refURL);
/*  676 */       break;
/*      */     case 2:
/*  678 */       strFieldValue = StrTool.GBKToUnicode(this.target);
/*  679 */       break;
/*      */     case 3:
/*  681 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  682 */       break;
/*      */     case 4:
/*  684 */       strFieldValue = String.valueOf(this.linkOrder);
/*  685 */       break;
/*      */     case 5:
/*  687 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  688 */       break;
/*      */     case 6:
/*  690 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  691 */       break;
/*      */     case 7:
/*  693 */       strFieldValue = StrTool.GBKToUnicode(this.icon);
/*  694 */       break;
/*      */     case 8:
/*  696 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  697 */       break;
/*      */     case 9:
/*  699 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  700 */       break;
/*      */     case 10:
/*  702 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  703 */       break;
/*      */     case 11:
/*  705 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  706 */       break;
/*      */     case 12:
/*  708 */       strFieldValue = String.valueOf(this.iF01);
/*  709 */       break;
/*      */     case 13:
/*  711 */       strFieldValue = String.valueOf(this.dF02);
/*  712 */       break;
/*      */     case 14:
/*  714 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  715 */       break;
/*      */     case 15:
/*  717 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  718 */       break;
/*      */     case 16:
/*  720 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  721 */       break;
/*      */     case 17:
/*  723 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  724 */       break;
/*      */     case 18:
/*  726 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  727 */       break;
/*      */     case 19:
/*  729 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  730 */       break;
/*      */     case 20:
/*  732 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  733 */       break;
/*      */     case 21:
/*  735 */       strFieldValue = StrTool.GBKToUnicode(this.description);
/*  736 */       break;
/*      */     default:
/*  738 */       strFieldValue = "";
/*      */     }
/*  740 */     if (strFieldValue.equals("")) {
/*  741 */       strFieldValue = "null";
/*      */     }
/*  743 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  749 */     if (StrTool.cTrim(FCode).equals("")) {
/*  750 */       return false;
/*      */     }
/*  752 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  754 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  756 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  759 */         this.iD = null;
/*      */     }
/*  761 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  763 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  765 */         this.refURL = FValue.trim();
/*      */       }
/*      */       else
/*  768 */         this.refURL = null;
/*      */     }
/*  770 */     if (FCode.equalsIgnoreCase("target"))
/*      */     {
/*  772 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  774 */         this.target = FValue.trim();
/*      */       }
/*      */       else
/*  777 */         this.target = null;
/*      */     }
/*  779 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  781 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  783 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  786 */         this.name = null;
/*      */     }
/*  788 */     if (FCode.equalsIgnoreCase("linkOrder"))
/*      */     {
/*  790 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  792 */         Integer tInteger = new Integer(FValue);
/*  793 */         int i = tInteger.intValue();
/*  794 */         this.linkOrder = i;
/*      */       }
/*      */     }
/*  797 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  799 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  801 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  804 */         this.state = null;
/*      */     }
/*  806 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  808 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  810 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/*  813 */         this.type = null;
/*      */     }
/*  815 */     if (FCode.equalsIgnoreCase("icon"))
/*      */     {
/*  817 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  819 */         this.icon = FValue.trim();
/*      */       }
/*      */       else
/*  822 */         this.icon = null;
/*      */     }
/*  824 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  826 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  828 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  831 */         this.manageCom = null;
/*      */     }
/*  833 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  835 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  837 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  840 */         this.branchType = null;
/*      */     }
/*  842 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  844 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  846 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/*  849 */         this.vF01 = null;
/*      */     }
/*  851 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  853 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  855 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/*  858 */         this.nF01 = null;
/*      */     }
/*  860 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  862 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  864 */         Integer tInteger = new Integer(FValue);
/*  865 */         int i = tInteger.intValue();
/*  866 */         this.iF01 = i;
/*      */       }
/*      */     }
/*  869 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  871 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  873 */         Double tDouble = new Double(FValue);
/*  874 */         double d = tDouble.doubleValue();
/*  875 */         this.dF02 = d;
/*      */       }
/*      */     }
/*  878 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  880 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  882 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  885 */         this.date01 = null;
/*      */     }
/*  887 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  889 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  891 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  894 */         this.modifyOperator = null;
/*      */     }
/*  896 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  898 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  900 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  903 */         this.operator = null;
/*      */     }
/*  905 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  907 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  909 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  912 */         this.makeDate = null;
/*      */     }
/*  914 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  916 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  918 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  921 */         this.makeTime = null;
/*      */     }
/*  923 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  925 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  927 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  930 */         this.modifyDate = null;
/*      */     }
/*  932 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  934 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  936 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  939 */         this.modifyTime = null;
/*      */     }
/*  941 */     if (FCode.equalsIgnoreCase("description"))
/*      */     {
/*  943 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  945 */         this.description = FValue.trim();
/*      */       }
/*      */       else
/*  948 */         this.description = null;
/*      */     }
/*  950 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  955 */     if (otherObject == null) return false;
/*  956 */     if (this == otherObject) return true;
/*  957 */     if (getClass() != otherObject.getClass()) return false;
/*  958 */     MSysLinkSchema other = (MSysLinkSchema)otherObject;
/*  959 */     if ((this.iD == null) && (other.getID() != null)) return false;
/*  960 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/*  961 */     if ((this.refURL == null) && (other.getRefURL() != null)) return false;
/*  962 */     if ((this.refURL != null) && (!this.refURL.equals(other.getRefURL()))) return false;
/*  963 */     if ((this.target == null) && (other.getTarget() != null)) return false;
/*  964 */     if ((this.target != null) && (!this.target.equals(other.getTarget()))) return false;
/*  965 */     if ((this.name == null) && (other.getName() != null)) return false;
/*  966 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/*  967 */     if (this.linkOrder != other.getLinkOrder()) return false;
/*  968 */     if ((this.state == null) && (other.getState() != null)) return false;
/*  969 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/*  970 */     if ((this.type == null) && (other.getType() != null)) return false;
/*  971 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/*  972 */     if ((this.icon == null) && (other.getIcon() != null)) return false;
/*  973 */     if ((this.icon != null) && (!this.icon.equals(other.getIcon()))) return false;
/*  974 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/*  975 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/*  976 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/*  977 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/*  978 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/*  979 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/*  980 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/*  981 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/*  982 */     if (this.iF01 != other.getIF01()) return false;
/*  983 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/*  984 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/*  985 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/*  986 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/*  987 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/*  988 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  989 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  990 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  991 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  992 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  993 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  994 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  995 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  996 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  997 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/*  998 */     if ((this.description == null) && (other.getDescription() != null)) return false;
/*  999 */     return (this.description == null) || (this.description.equals(other.getDescription()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1006 */     return 22;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1012 */     if (strFieldName.equals("iD")) {
/* 1013 */       return 0;
/*      */     }
/* 1015 */     if (strFieldName.equals("refURL")) {
/* 1016 */       return 1;
/*      */     }
/* 1018 */     if (strFieldName.equals("target")) {
/* 1019 */       return 2;
/*      */     }
/* 1021 */     if (strFieldName.equals("name")) {
/* 1022 */       return 3;
/*      */     }
/* 1024 */     if (strFieldName.equals("linkOrder")) {
/* 1025 */       return 4;
/*      */     }
/* 1027 */     if (strFieldName.equals("state")) {
/* 1028 */       return 5;
/*      */     }
/* 1030 */     if (strFieldName.equals("type")) {
/* 1031 */       return 6;
/*      */     }
/* 1033 */     if (strFieldName.equals("icon")) {
/* 1034 */       return 7;
/*      */     }
/* 1036 */     if (strFieldName.equals("manageCom")) {
/* 1037 */       return 8;
/*      */     }
/* 1039 */     if (strFieldName.equals("branchType")) {
/* 1040 */       return 9;
/*      */     }
/* 1042 */     if (strFieldName.equals("vF01")) {
/* 1043 */       return 10;
/*      */     }
/* 1045 */     if (strFieldName.equals("nF01")) {
/* 1046 */       return 11;
/*      */     }
/* 1048 */     if (strFieldName.equals("iF01")) {
/* 1049 */       return 12;
/*      */     }
/* 1051 */     if (strFieldName.equals("dF02")) {
/* 1052 */       return 13;
/*      */     }
/* 1054 */     if (strFieldName.equals("date01")) {
/* 1055 */       return 14;
/*      */     }
/* 1057 */     if (strFieldName.equals("modifyOperator")) {
/* 1058 */       return 15;
/*      */     }
/* 1060 */     if (strFieldName.equals("operator")) {
/* 1061 */       return 16;
/*      */     }
/* 1063 */     if (strFieldName.equals("makeDate")) {
/* 1064 */       return 17;
/*      */     }
/* 1066 */     if (strFieldName.equals("makeTime")) {
/* 1067 */       return 18;
/*      */     }
/* 1069 */     if (strFieldName.equals("modifyDate")) {
/* 1070 */       return 19;
/*      */     }
/* 1072 */     if (strFieldName.equals("modifyTime")) {
/* 1073 */       return 20;
/*      */     }
/* 1075 */     if (strFieldName.equals("description")) {
/* 1076 */       return 21;
/*      */     }
/* 1078 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1084 */     String strFieldName = "";
/* 1085 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1087 */       strFieldName = "iD";
/* 1088 */       break;
/*      */     case 1:
/* 1090 */       strFieldName = "refURL";
/* 1091 */       break;
/*      */     case 2:
/* 1093 */       strFieldName = "target";
/* 1094 */       break;
/*      */     case 3:
/* 1096 */       strFieldName = "name";
/* 1097 */       break;
/*      */     case 4:
/* 1099 */       strFieldName = "linkOrder";
/* 1100 */       break;
/*      */     case 5:
/* 1102 */       strFieldName = "state";
/* 1103 */       break;
/*      */     case 6:
/* 1105 */       strFieldName = "type";
/* 1106 */       break;
/*      */     case 7:
/* 1108 */       strFieldName = "icon";
/* 1109 */       break;
/*      */     case 8:
/* 1111 */       strFieldName = "manageCom";
/* 1112 */       break;
/*      */     case 9:
/* 1114 */       strFieldName = "branchType";
/* 1115 */       break;
/*      */     case 10:
/* 1117 */       strFieldName = "vF01";
/* 1118 */       break;
/*      */     case 11:
/* 1120 */       strFieldName = "nF01";
/* 1121 */       break;
/*      */     case 12:
/* 1123 */       strFieldName = "iF01";
/* 1124 */       break;
/*      */     case 13:
/* 1126 */       strFieldName = "dF02";
/* 1127 */       break;
/*      */     case 14:
/* 1129 */       strFieldName = "date01";
/* 1130 */       break;
/*      */     case 15:
/* 1132 */       strFieldName = "modifyOperator";
/* 1133 */       break;
/*      */     case 16:
/* 1135 */       strFieldName = "operator";
/* 1136 */       break;
/*      */     case 17:
/* 1138 */       strFieldName = "makeDate";
/* 1139 */       break;
/*      */     case 18:
/* 1141 */       strFieldName = "makeTime";
/* 1142 */       break;
/*      */     case 19:
/* 1144 */       strFieldName = "modifyDate";
/* 1145 */       break;
/*      */     case 20:
/* 1147 */       strFieldName = "modifyTime";
/* 1148 */       break;
/*      */     case 21:
/* 1150 */       strFieldName = "description";
/* 1151 */       break;
/*      */     default:
/* 1153 */       strFieldName = "";
/*      */     }
/* 1155 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1161 */     if (strFieldName.equals("iD")) {
/* 1162 */       return 0;
/*      */     }
/* 1164 */     if (strFieldName.equals("refURL")) {
/* 1165 */       return 0;
/*      */     }
/* 1167 */     if (strFieldName.equals("target")) {
/* 1168 */       return 0;
/*      */     }
/* 1170 */     if (strFieldName.equals("name")) {
/* 1171 */       return 0;
/*      */     }
/* 1173 */     if (strFieldName.equals("linkOrder")) {
/* 1174 */       return 3;
/*      */     }
/* 1176 */     if (strFieldName.equals("state")) {
/* 1177 */       return 0;
/*      */     }
/* 1179 */     if (strFieldName.equals("type")) {
/* 1180 */       return 0;
/*      */     }
/* 1182 */     if (strFieldName.equals("icon")) {
/* 1183 */       return 0;
/*      */     }
/* 1185 */     if (strFieldName.equals("manageCom")) {
/* 1186 */       return 0;
/*      */     }
/* 1188 */     if (strFieldName.equals("branchType")) {
/* 1189 */       return 0;
/*      */     }
/* 1191 */     if (strFieldName.equals("vF01")) {
/* 1192 */       return 0;
/*      */     }
/* 1194 */     if (strFieldName.equals("nF01")) {
/* 1195 */       return 0;
/*      */     }
/* 1197 */     if (strFieldName.equals("iF01")) {
/* 1198 */       return 3;
/*      */     }
/* 1200 */     if (strFieldName.equals("dF02")) {
/* 1201 */       return 4;
/*      */     }
/* 1203 */     if (strFieldName.equals("date01")) {
/* 1204 */       return 1;
/*      */     }
/* 1206 */     if (strFieldName.equals("modifyOperator")) {
/* 1207 */       return 0;
/*      */     }
/* 1209 */     if (strFieldName.equals("operator")) {
/* 1210 */       return 0;
/*      */     }
/* 1212 */     if (strFieldName.equals("makeDate")) {
/* 1213 */       return 1;
/*      */     }
/* 1215 */     if (strFieldName.equals("makeTime")) {
/* 1216 */       return 0;
/*      */     }
/* 1218 */     if (strFieldName.equals("modifyDate")) {
/* 1219 */       return 1;
/*      */     }
/* 1221 */     if (strFieldName.equals("modifyTime")) {
/* 1222 */       return 0;
/*      */     }
/* 1224 */     if (strFieldName.equals("description")) {
/* 1225 */       return 0;
/*      */     }
/* 1227 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1233 */     int nFieldType = -1;
/* 1234 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1236 */       nFieldType = 0;
/* 1237 */       break;
/*      */     case 1:
/* 1239 */       nFieldType = 0;
/* 1240 */       break;
/*      */     case 2:
/* 1242 */       nFieldType = 0;
/* 1243 */       break;
/*      */     case 3:
/* 1245 */       nFieldType = 0;
/* 1246 */       break;
/*      */     case 4:
/* 1248 */       nFieldType = 3;
/* 1249 */       break;
/*      */     case 5:
/* 1251 */       nFieldType = 0;
/* 1252 */       break;
/*      */     case 6:
/* 1254 */       nFieldType = 0;
/* 1255 */       break;
/*      */     case 7:
/* 1257 */       nFieldType = 0;
/* 1258 */       break;
/*      */     case 8:
/* 1260 */       nFieldType = 0;
/* 1261 */       break;
/*      */     case 9:
/* 1263 */       nFieldType = 0;
/* 1264 */       break;
/*      */     case 10:
/* 1266 */       nFieldType = 0;
/* 1267 */       break;
/*      */     case 11:
/* 1269 */       nFieldType = 0;
/* 1270 */       break;
/*      */     case 12:
/* 1272 */       nFieldType = 3;
/* 1273 */       break;
/*      */     case 13:
/* 1275 */       nFieldType = 4;
/* 1276 */       break;
/*      */     case 14:
/* 1278 */       nFieldType = 1;
/* 1279 */       break;
/*      */     case 15:
/* 1281 */       nFieldType = 0;
/* 1282 */       break;
/*      */     case 16:
/* 1284 */       nFieldType = 0;
/* 1285 */       break;
/*      */     case 17:
/* 1287 */       nFieldType = 1;
/* 1288 */       break;
/*      */     case 18:
/* 1290 */       nFieldType = 0;
/* 1291 */       break;
/*      */     case 19:
/* 1293 */       nFieldType = 1;
/* 1294 */       break;
/*      */     case 20:
/* 1296 */       nFieldType = 0;
/* 1297 */       break;
/*      */     case 21:
/* 1299 */       nFieldType = 0;
/* 1300 */       break;
/*      */     default:
/* 1302 */       nFieldType = -1;
/*      */     }
/* 1304 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MSysLinkSchema
 * JD-Core Version:    0.6.0
 */