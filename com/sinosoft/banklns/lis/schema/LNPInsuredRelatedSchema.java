/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPInsuredRelatedDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPInsuredRelatedSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String polNo;
/*      */   private String customerId;
/*      */   private String customerNo;
/*      */   private String mainCustomerNo;
/*      */   private String relationToInsured;
/*      */   private String addressNo;
/*      */   private String name;
/*      */   private String sex;
/*      */   private Date birthday;
/*      */   private String iDType;
/*      */   private String iDNo;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 16;
/*      */   private static String[] PK;
/*   59 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPInsuredRelatedSchema()
/*      */   {
/*   66 */     this.mErrors = new CErrors();
/*      */ 
/*   68 */     String[] pk = new String[3];
/*   69 */     pk[0] = "PolNo";
/*   70 */     pk[1] = "CustomerId";
/*   71 */     pk[2] = "MainCustomerNo";
/*      */ 
/*   73 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   80 */     LNPInsuredRelatedSchema cloned = (LNPInsuredRelatedSchema)super.clone();
/*   81 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   82 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   83 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   89 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getPolNo()
/*      */   {
/*   94 */     return this.polNo;
/*      */   }
/*      */ 
/*      */   public void setPolNo(String aPolNo) {
/*   98 */     this.polNo = aPolNo;
/*      */   }
/*      */ 
/*      */   public String getCustomerId() {
/*  102 */     return this.customerId;
/*      */   }
/*      */ 
/*      */   public void setCustomerId(String aCustomerId) {
/*  106 */     this.customerId = aCustomerId;
/*      */   }
/*      */ 
/*      */   public String getCustomerNo() {
/*  110 */     return this.customerNo;
/*      */   }
/*      */ 
/*      */   public void setCustomerNo(String aCustomerNo) {
/*  114 */     this.customerNo = aCustomerNo;
/*      */   }
/*      */ 
/*      */   public String getMainCustomerNo() {
/*  118 */     return this.mainCustomerNo;
/*      */   }
/*      */ 
/*      */   public void setMainCustomerNo(String aMainCustomerNo) {
/*  122 */     this.mainCustomerNo = aMainCustomerNo;
/*      */   }
/*      */ 
/*      */   public String getRelationToInsured() {
/*  126 */     return this.relationToInsured;
/*      */   }
/*      */ 
/*      */   public void setRelationToInsured(String aRelationToInsured) {
/*  130 */     this.relationToInsured = aRelationToInsured;
/*      */   }
/*      */ 
/*      */   public String getAddressNo() {
/*  134 */     return this.addressNo;
/*      */   }
/*      */ 
/*      */   public void setAddressNo(String aAddressNo) {
/*  138 */     this.addressNo = aAddressNo;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  142 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  146 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getSex() {
/*  150 */     return this.sex;
/*      */   }
/*      */ 
/*      */   public void setSex(String aSex) {
/*  154 */     this.sex = aSex;
/*      */   }
/*      */ 
/*      */   public String getBirthday() {
/*  158 */     if (this.birthday != null) {
/*  159 */       return this.fDate.getString(this.birthday);
/*      */     }
/*  161 */     return null;
/*      */   }
/*      */ 
/*      */   public void setBirthday(Date aBirthday) {
/*  165 */     this.birthday = aBirthday;
/*      */   }
/*      */ 
/*      */   public void setBirthday(String aBirthday) {
/*  169 */     if ((aBirthday != null) && (!aBirthday.equals("")))
/*      */     {
/*  171 */       this.birthday = this.fDate.getDate(aBirthday);
/*      */     }
/*      */     else
/*  174 */       this.birthday = null;
/*      */   }
/*      */ 
/*      */   public String getIDType()
/*      */   {
/*  179 */     return this.iDType;
/*      */   }
/*      */ 
/*      */   public void setIDType(String aIDType) {
/*  183 */     this.iDType = aIDType;
/*      */   }
/*      */ 
/*      */   public String getIDNo() {
/*  187 */     return this.iDNo;
/*      */   }
/*      */ 
/*      */   public void setIDNo(String aIDNo) {
/*  191 */     this.iDNo = aIDNo;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  195 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  199 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  203 */     if (this.makeDate != null) {
/*  204 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  206 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  210 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  214 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  216 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  219 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  224 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  228 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  232 */     if (this.modifyDate != null) {
/*  233 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  235 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  239 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  243 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  245 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  248 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  253 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  257 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPInsuredRelatedSchema aLNPInsuredRelatedSchema)
/*      */   {
/*  263 */     this.polNo = aLNPInsuredRelatedSchema.getPolNo();
/*  264 */     this.customerId = aLNPInsuredRelatedSchema.getCustomerId();
/*  265 */     this.customerNo = aLNPInsuredRelatedSchema.getCustomerNo();
/*  266 */     this.mainCustomerNo = aLNPInsuredRelatedSchema.getMainCustomerNo();
/*  267 */     this.relationToInsured = aLNPInsuredRelatedSchema.getRelationToInsured();
/*  268 */     this.addressNo = aLNPInsuredRelatedSchema.getAddressNo();
/*  269 */     this.name = aLNPInsuredRelatedSchema.getName();
/*  270 */     this.sex = aLNPInsuredRelatedSchema.getSex();
/*  271 */     this.birthday = this.fDate.getDate(aLNPInsuredRelatedSchema.getBirthday());
/*  272 */     this.iDType = aLNPInsuredRelatedSchema.getIDType();
/*  273 */     this.iDNo = aLNPInsuredRelatedSchema.getIDNo();
/*  274 */     this.operator = aLNPInsuredRelatedSchema.getOperator();
/*  275 */     this.makeDate = this.fDate.getDate(aLNPInsuredRelatedSchema.getMakeDate());
/*  276 */     this.makeTime = aLNPInsuredRelatedSchema.getMakeTime();
/*  277 */     this.modifyDate = this.fDate.getDate(aLNPInsuredRelatedSchema.getModifyDate());
/*  278 */     this.modifyTime = aLNPInsuredRelatedSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  287 */       if (rs.getString("PolNo") == null)
/*  288 */         this.polNo = null;
/*      */       else {
/*  290 */         this.polNo = rs.getString("PolNo").trim();
/*      */       }
/*  292 */       if (rs.getString("CustomerId") == null)
/*  293 */         this.customerId = null;
/*      */       else {
/*  295 */         this.customerId = rs.getString("CustomerId").trim();
/*      */       }
/*  297 */       if (rs.getString("CustomerNo") == null)
/*  298 */         this.customerNo = null;
/*      */       else {
/*  300 */         this.customerNo = rs.getString("CustomerNo").trim();
/*      */       }
/*  302 */       if (rs.getString("MainCustomerNo") == null)
/*  303 */         this.mainCustomerNo = null;
/*      */       else {
/*  305 */         this.mainCustomerNo = rs.getString("MainCustomerNo").trim();
/*      */       }
/*  307 */       if (rs.getString("RelationToInsured") == null)
/*  308 */         this.relationToInsured = null;
/*      */       else {
/*  310 */         this.relationToInsured = rs.getString("RelationToInsured").trim();
/*      */       }
/*  312 */       if (rs.getString("AddressNo") == null)
/*  313 */         this.addressNo = null;
/*      */       else {
/*  315 */         this.addressNo = rs.getString("AddressNo").trim();
/*      */       }
/*  317 */       if (rs.getString("Name") == null)
/*  318 */         this.name = null;
/*      */       else {
/*  320 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  322 */       if (rs.getString("Sex") == null)
/*  323 */         this.sex = null;
/*      */       else {
/*  325 */         this.sex = rs.getString("Sex").trim();
/*      */       }
/*  327 */       this.birthday = rs.getDate("Birthday");
/*  328 */       if (rs.getString("IDType") == null)
/*  329 */         this.iDType = null;
/*      */       else {
/*  331 */         this.iDType = rs.getString("IDType").trim();
/*      */       }
/*  333 */       if (rs.getString("IDNo") == null)
/*  334 */         this.iDNo = null;
/*      */       else {
/*  336 */         this.iDNo = rs.getString("IDNo").trim();
/*      */       }
/*  338 */       if (rs.getString("Operator") == null)
/*  339 */         this.operator = null;
/*      */       else {
/*  341 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  343 */       this.makeDate = rs.getDate("MakeDate");
/*  344 */       if (rs.getString("MakeTime") == null)
/*  345 */         this.makeTime = null;
/*      */       else {
/*  347 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  349 */       this.modifyDate = rs.getDate("ModifyDate");
/*  350 */       if (rs.getString("ModifyTime") == null)
/*  351 */         this.modifyTime = null;
/*      */       else {
/*  353 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  358 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPInsuredRelated\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/*  360 */       CError tError = new CError();
/*  361 */       tError.moduleName = "LNPInsuredRelatedSchema";
/*  362 */       tError.functionName = "setSchema";
/*  363 */       tError.errorMessage = sqle.toString();
/*  364 */       this.mErrors.addOneError(tError);
/*  365 */       return false;
/*      */     }
/*  367 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInsuredRelatedSchema getSchema()
/*      */   {
/*  372 */     LNPInsuredRelatedSchema aLNPInsuredRelatedSchema = new LNPInsuredRelatedSchema();
/*  373 */     aLNPInsuredRelatedSchema.setSchema(this);
/*  374 */     return aLNPInsuredRelatedSchema;
/*      */   }
/*      */ 
/*      */   public LNPInsuredRelatedDB getDB()
/*      */   {
/*  379 */     LNPInsuredRelatedDB aDBOper = new LNPInsuredRelatedDB();
/*  380 */     aDBOper.setSchema(this);
/*  381 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  388 */     StringBuffer strReturn = new StringBuffer(256);
/*  389 */     strReturn.append(StrTool.cTrim(this.polNo)); strReturn.append("|");
/*  390 */     strReturn.append(StrTool.cTrim(this.customerId)); strReturn.append("|");
/*  391 */     strReturn.append(StrTool.cTrim(this.customerNo)); strReturn.append("|");
/*  392 */     strReturn.append(StrTool.cTrim(this.mainCustomerNo)); strReturn.append("|");
/*  393 */     strReturn.append(StrTool.cTrim(this.relationToInsured)); strReturn.append("|");
/*  394 */     strReturn.append(StrTool.cTrim(this.addressNo)); strReturn.append("|");
/*  395 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  396 */     strReturn.append(StrTool.cTrim(this.sex)); strReturn.append("|");
/*  397 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.birthday))); strReturn.append("|");
/*  398 */     strReturn.append(StrTool.cTrim(this.iDType)); strReturn.append("|");
/*  399 */     strReturn.append(StrTool.cTrim(this.iDNo)); strReturn.append("|");
/*  400 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  401 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  402 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  403 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  404 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  405 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  413 */       this.polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  414 */       this.customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  415 */       this.customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  416 */       this.mainCustomerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  417 */       this.relationToInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  418 */       this.addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  419 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  420 */       this.sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  421 */       this.birthday = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/*  422 */       this.iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  423 */       this.iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  424 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  425 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
/*  426 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  427 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  428 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  433 */       CError tError = new CError();
/*  434 */       tError.moduleName = "LNPInsuredRelatedSchema";
/*  435 */       tError.functionName = "decode";
/*  436 */       tError.errorMessage = ex.toString();
/*  437 */       this.mErrors.addOneError(tError);
/*      */ 
/*  439 */       return false;
/*      */     }
/*  441 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  447 */     String strReturn = "";
/*  448 */     if (FCode.equalsIgnoreCase("polNo"))
/*      */     {
/*  450 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.polNo));
/*      */     }
/*  452 */     if (FCode.equalsIgnoreCase("customerId"))
/*      */     {
/*  454 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerId));
/*      */     }
/*  456 */     if (FCode.equalsIgnoreCase("customerNo"))
/*      */     {
/*  458 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerNo));
/*      */     }
/*  460 */     if (FCode.equalsIgnoreCase("mainCustomerNo"))
/*      */     {
/*  462 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mainCustomerNo));
/*      */     }
/*  464 */     if (FCode.equalsIgnoreCase("relationToInsured"))
/*      */     {
/*  466 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relationToInsured));
/*      */     }
/*  468 */     if (FCode.equalsIgnoreCase("addressNo"))
/*      */     {
/*  470 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addressNo));
/*      */     }
/*  472 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  474 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  476 */     if (FCode.equalsIgnoreCase("sex"))
/*      */     {
/*  478 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sex));
/*      */     }
/*  480 */     if (FCode.equalsIgnoreCase("birthday"))
/*      */     {
/*  482 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
/*      */     }
/*  484 */     if (FCode.equalsIgnoreCase("iDType"))
/*      */     {
/*  486 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDType));
/*      */     }
/*  488 */     if (FCode.equalsIgnoreCase("iDNo"))
/*      */     {
/*  490 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iDNo));
/*      */     }
/*  492 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  494 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  496 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  498 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  500 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  502 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  504 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  506 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  508 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  510 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  512 */     if (strReturn.equals(""))
/*      */     {
/*  514 */       strReturn = "null";
/*      */     }
/*      */ 
/*  517 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  524 */     String strFieldValue = "";
/*  525 */     switch (nFieldIndex) {
/*      */     case 0:
/*  527 */       strFieldValue = StrTool.GBKToUnicode(this.polNo);
/*  528 */       break;
/*      */     case 1:
/*  530 */       strFieldValue = StrTool.GBKToUnicode(this.customerId);
/*  531 */       break;
/*      */     case 2:
/*  533 */       strFieldValue = StrTool.GBKToUnicode(this.customerNo);
/*  534 */       break;
/*      */     case 3:
/*  536 */       strFieldValue = StrTool.GBKToUnicode(this.mainCustomerNo);
/*  537 */       break;
/*      */     case 4:
/*  539 */       strFieldValue = StrTool.GBKToUnicode(this.relationToInsured);
/*  540 */       break;
/*      */     case 5:
/*  542 */       strFieldValue = StrTool.GBKToUnicode(this.addressNo);
/*  543 */       break;
/*      */     case 6:
/*  545 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  546 */       break;
/*      */     case 7:
/*  548 */       strFieldValue = StrTool.GBKToUnicode(this.sex);
/*  549 */       break;
/*      */     case 8:
/*  551 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
/*  552 */       break;
/*      */     case 9:
/*  554 */       strFieldValue = StrTool.GBKToUnicode(this.iDType);
/*  555 */       break;
/*      */     case 10:
/*  557 */       strFieldValue = StrTool.GBKToUnicode(this.iDNo);
/*  558 */       break;
/*      */     case 11:
/*  560 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  561 */       break;
/*      */     case 12:
/*  563 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  564 */       break;
/*      */     case 13:
/*  566 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  567 */       break;
/*      */     case 14:
/*  569 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  570 */       break;
/*      */     case 15:
/*  572 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  573 */       break;
/*      */     default:
/*  575 */       strFieldValue = "";
/*      */     }
/*  577 */     if (strFieldValue.equals("")) {
/*  578 */       strFieldValue = "null";
/*      */     }
/*  580 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  586 */     if (StrTool.cTrim(FCode).equals("")) {
/*  587 */       return false;
/*      */     }
/*  589 */     if (FCode.equalsIgnoreCase("polNo"))
/*      */     {
/*  591 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  593 */         this.polNo = FValue.trim();
/*      */       }
/*      */       else
/*  596 */         this.polNo = null;
/*      */     }
/*  598 */     if (FCode.equalsIgnoreCase("customerId"))
/*      */     {
/*  600 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  602 */         this.customerId = FValue.trim();
/*      */       }
/*      */       else
/*  605 */         this.customerId = null;
/*      */     }
/*  607 */     if (FCode.equalsIgnoreCase("customerNo"))
/*      */     {
/*  609 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  611 */         this.customerNo = FValue.trim();
/*      */       }
/*      */       else
/*  614 */         this.customerNo = null;
/*      */     }
/*  616 */     if (FCode.equalsIgnoreCase("mainCustomerNo"))
/*      */     {
/*  618 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  620 */         this.mainCustomerNo = FValue.trim();
/*      */       }
/*      */       else
/*  623 */         this.mainCustomerNo = null;
/*      */     }
/*  625 */     if (FCode.equalsIgnoreCase("relationToInsured"))
/*      */     {
/*  627 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  629 */         this.relationToInsured = FValue.trim();
/*      */       }
/*      */       else
/*  632 */         this.relationToInsured = null;
/*      */     }
/*  634 */     if (FCode.equalsIgnoreCase("addressNo"))
/*      */     {
/*  636 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  638 */         this.addressNo = FValue.trim();
/*      */       }
/*      */       else
/*  641 */         this.addressNo = null;
/*      */     }
/*  643 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  645 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  647 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  650 */         this.name = null;
/*      */     }
/*  652 */     if (FCode.equalsIgnoreCase("sex"))
/*      */     {
/*  654 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  656 */         this.sex = FValue.trim();
/*      */       }
/*      */       else
/*  659 */         this.sex = null;
/*      */     }
/*  661 */     if (FCode.equalsIgnoreCase("birthday"))
/*      */     {
/*  663 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  665 */         this.birthday = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  668 */         this.birthday = null;
/*      */     }
/*  670 */     if (FCode.equalsIgnoreCase("iDType"))
/*      */     {
/*  672 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  674 */         this.iDType = FValue.trim();
/*      */       }
/*      */       else
/*  677 */         this.iDType = null;
/*      */     }
/*  679 */     if (FCode.equalsIgnoreCase("iDNo"))
/*      */     {
/*  681 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  683 */         this.iDNo = FValue.trim();
/*      */       }
/*      */       else
/*  686 */         this.iDNo = null;
/*      */     }
/*  688 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  690 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  692 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  695 */         this.operator = null;
/*      */     }
/*  697 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  699 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  701 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  704 */         this.makeDate = null;
/*      */     }
/*  706 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  708 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  710 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  713 */         this.makeTime = null;
/*      */     }
/*  715 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  717 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  719 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  722 */         this.modifyDate = null;
/*      */     }
/*  724 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  726 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  728 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  731 */         this.modifyTime = null;
/*      */     }
/*  733 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  738 */     if (otherObject == null) return false;
/*  739 */     if (this == otherObject) return true;
/*  740 */     if (getClass() != otherObject.getClass()) return false;
/*  741 */     LNPInsuredRelatedSchema other = (LNPInsuredRelatedSchema)otherObject;
/*  742 */     if ((this.polNo == null) && (other.getPolNo() != null)) return false;
/*  743 */     if ((this.polNo != null) && (!this.polNo.equals(other.getPolNo()))) return false;
/*  744 */     if ((this.customerId == null) && (other.getCustomerId() != null)) return false;
/*  745 */     if ((this.customerId != null) && (!this.customerId.equals(other.getCustomerId()))) return false;
/*  746 */     if ((this.customerNo == null) && (other.getCustomerNo() != null)) return false;
/*  747 */     if ((this.customerNo != null) && (!this.customerNo.equals(other.getCustomerNo()))) return false;
/*  748 */     if ((this.mainCustomerNo == null) && (other.getMainCustomerNo() != null)) return false;
/*  749 */     if ((this.mainCustomerNo != null) && (!this.mainCustomerNo.equals(other.getMainCustomerNo()))) return false;
/*  750 */     if ((this.relationToInsured == null) && (other.getRelationToInsured() != null)) return false;
/*  751 */     if ((this.relationToInsured != null) && (!this.relationToInsured.equals(other.getRelationToInsured()))) return false;
/*  752 */     if ((this.addressNo == null) && (other.getAddressNo() != null)) return false;
/*  753 */     if ((this.addressNo != null) && (!this.addressNo.equals(other.getAddressNo()))) return false;
/*  754 */     if ((this.name == null) && (other.getName() != null)) return false;
/*  755 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/*  756 */     if ((this.sex == null) && (other.getSex() != null)) return false;
/*  757 */     if ((this.sex != null) && (!this.sex.equals(other.getSex()))) return false;
/*  758 */     if ((this.birthday == null) && (other.getBirthday() != null)) return false;
/*  759 */     if ((this.birthday != null) && (!this.fDate.getString(this.birthday).equals(other.getBirthday()))) return false;
/*  760 */     if ((this.iDType == null) && (other.getIDType() != null)) return false;
/*  761 */     if ((this.iDType != null) && (!this.iDType.equals(other.getIDType()))) return false;
/*  762 */     if ((this.iDNo == null) && (other.getIDNo() != null)) return false;
/*  763 */     if ((this.iDNo != null) && (!this.iDNo.equals(other.getIDNo()))) return false;
/*  764 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  765 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  766 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  767 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  768 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  769 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  770 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  771 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  772 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  773 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  780 */     return 16;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  786 */     if (strFieldName.equals("polNo")) {
/*  787 */       return 0;
/*      */     }
/*  789 */     if (strFieldName.equals("customerId")) {
/*  790 */       return 1;
/*      */     }
/*  792 */     if (strFieldName.equals("customerNo")) {
/*  793 */       return 2;
/*      */     }
/*  795 */     if (strFieldName.equals("mainCustomerNo")) {
/*  796 */       return 3;
/*      */     }
/*  798 */     if (strFieldName.equals("relationToInsured")) {
/*  799 */       return 4;
/*      */     }
/*  801 */     if (strFieldName.equals("addressNo")) {
/*  802 */       return 5;
/*      */     }
/*  804 */     if (strFieldName.equals("name")) {
/*  805 */       return 6;
/*      */     }
/*  807 */     if (strFieldName.equals("sex")) {
/*  808 */       return 7;
/*      */     }
/*  810 */     if (strFieldName.equals("birthday")) {
/*  811 */       return 8;
/*      */     }
/*  813 */     if (strFieldName.equals("iDType")) {
/*  814 */       return 9;
/*      */     }
/*  816 */     if (strFieldName.equals("iDNo")) {
/*  817 */       return 10;
/*      */     }
/*  819 */     if (strFieldName.equals("operator")) {
/*  820 */       return 11;
/*      */     }
/*  822 */     if (strFieldName.equals("makeDate")) {
/*  823 */       return 12;
/*      */     }
/*  825 */     if (strFieldName.equals("makeTime")) {
/*  826 */       return 13;
/*      */     }
/*  828 */     if (strFieldName.equals("modifyDate")) {
/*  829 */       return 14;
/*      */     }
/*  831 */     if (strFieldName.equals("modifyTime")) {
/*  832 */       return 15;
/*      */     }
/*  834 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  840 */     String strFieldName = "";
/*  841 */     switch (nFieldIndex) {
/*      */     case 0:
/*  843 */       strFieldName = "polNo";
/*  844 */       break;
/*      */     case 1:
/*  846 */       strFieldName = "customerId";
/*  847 */       break;
/*      */     case 2:
/*  849 */       strFieldName = "customerNo";
/*  850 */       break;
/*      */     case 3:
/*  852 */       strFieldName = "mainCustomerNo";
/*  853 */       break;
/*      */     case 4:
/*  855 */       strFieldName = "relationToInsured";
/*  856 */       break;
/*      */     case 5:
/*  858 */       strFieldName = "addressNo";
/*  859 */       break;
/*      */     case 6:
/*  861 */       strFieldName = "name";
/*  862 */       break;
/*      */     case 7:
/*  864 */       strFieldName = "sex";
/*  865 */       break;
/*      */     case 8:
/*  867 */       strFieldName = "birthday";
/*  868 */       break;
/*      */     case 9:
/*  870 */       strFieldName = "iDType";
/*  871 */       break;
/*      */     case 10:
/*  873 */       strFieldName = "iDNo";
/*  874 */       break;
/*      */     case 11:
/*  876 */       strFieldName = "operator";
/*  877 */       break;
/*      */     case 12:
/*  879 */       strFieldName = "makeDate";
/*  880 */       break;
/*      */     case 13:
/*  882 */       strFieldName = "makeTime";
/*  883 */       break;
/*      */     case 14:
/*  885 */       strFieldName = "modifyDate";
/*  886 */       break;
/*      */     case 15:
/*  888 */       strFieldName = "modifyTime";
/*  889 */       break;
/*      */     default:
/*  891 */       strFieldName = "";
/*      */     }
/*  893 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  899 */     if (strFieldName.equals("polNo")) {
/*  900 */       return 0;
/*      */     }
/*  902 */     if (strFieldName.equals("customerId")) {
/*  903 */       return 0;
/*      */     }
/*  905 */     if (strFieldName.equals("customerNo")) {
/*  906 */       return 0;
/*      */     }
/*  908 */     if (strFieldName.equals("mainCustomerNo")) {
/*  909 */       return 0;
/*      */     }
/*  911 */     if (strFieldName.equals("relationToInsured")) {
/*  912 */       return 0;
/*      */     }
/*  914 */     if (strFieldName.equals("addressNo")) {
/*  915 */       return 0;
/*      */     }
/*  917 */     if (strFieldName.equals("name")) {
/*  918 */       return 0;
/*      */     }
/*  920 */     if (strFieldName.equals("sex")) {
/*  921 */       return 0;
/*      */     }
/*  923 */     if (strFieldName.equals("birthday")) {
/*  924 */       return 1;
/*      */     }
/*  926 */     if (strFieldName.equals("iDType")) {
/*  927 */       return 0;
/*      */     }
/*  929 */     if (strFieldName.equals("iDNo")) {
/*  930 */       return 0;
/*      */     }
/*  932 */     if (strFieldName.equals("operator")) {
/*  933 */       return 0;
/*      */     }
/*  935 */     if (strFieldName.equals("makeDate")) {
/*  936 */       return 1;
/*      */     }
/*  938 */     if (strFieldName.equals("makeTime")) {
/*  939 */       return 0;
/*      */     }
/*  941 */     if (strFieldName.equals("modifyDate")) {
/*  942 */       return 1;
/*      */     }
/*  944 */     if (strFieldName.equals("modifyTime")) {
/*  945 */       return 0;
/*      */     }
/*  947 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/*  953 */     int nFieldType = -1;
/*  954 */     switch (nFieldIndex) {
/*      */     case 0:
/*  956 */       nFieldType = 0;
/*  957 */       break;
/*      */     case 1:
/*  959 */       nFieldType = 0;
/*  960 */       break;
/*      */     case 2:
/*  962 */       nFieldType = 0;
/*  963 */       break;
/*      */     case 3:
/*  965 */       nFieldType = 0;
/*  966 */       break;
/*      */     case 4:
/*  968 */       nFieldType = 0;
/*  969 */       break;
/*      */     case 5:
/*  971 */       nFieldType = 0;
/*  972 */       break;
/*      */     case 6:
/*  974 */       nFieldType = 0;
/*  975 */       break;
/*      */     case 7:
/*  977 */       nFieldType = 0;
/*  978 */       break;
/*      */     case 8:
/*  980 */       nFieldType = 1;
/*  981 */       break;
/*      */     case 9:
/*  983 */       nFieldType = 0;
/*  984 */       break;
/*      */     case 10:
/*  986 */       nFieldType = 0;
/*  987 */       break;
/*      */     case 11:
/*  989 */       nFieldType = 0;
/*  990 */       break;
/*      */     case 12:
/*  992 */       nFieldType = 1;
/*  993 */       break;
/*      */     case 13:
/*  995 */       nFieldType = 0;
/*  996 */       break;
/*      */     case 14:
/*  998 */       nFieldType = 1;
/*  999 */       break;
/*      */     case 15:
/* 1001 */       nFieldType = 0;
/* 1002 */       break;
/*      */     default:
/* 1004 */       nFieldType = -1;
/*      */     }
/* 1006 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPInsuredRelatedSchema
 * JD-Core Version:    0.6.0
 */