/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPDutyGetDB;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class LNPDutyGetSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String getDutyCode;
/*      */   private String getDutyName;
/*      */   private String type;
/*      */   private int getIntv;
/*      */   private double defaultVal;
/*      */   private String calCode;
/*      */   private String cnterCalCode;
/*      */   private String othCalCode;
/*      */   private int getYear;
/*      */   private String getYearFlag;
/*      */   private String startDateCalRef;
/*      */   private String startDateCalMode;
/*      */   private int minGetStartPeriod;
/*      */   private int getEndPeriod;
/*      */   private String getEndUnit;
/*      */   private String endDateCalRef;
/*      */   private String endDateCalMode;
/*      */   private int maxGetEndPeriod;
/*      */   private String addFlag;
/*      */   private String sexRelaFlag;
/*      */   private String unitAppRelaFlag;
/*      */   private String addAmntFlag;
/*      */   private String discntFlag;
/*      */   private String interestFlag;
/*      */   private String shareFlag;
/*      */   private String inpFlag;
/*      */   private String bnfFlag;
/*      */   private String urgeGetFlag;
/*      */   private String deadValiFlag;
/*      */   private String getInitFlag;
/*      */   private double getLimit;
/*      */   private double maxGet;
/*      */   private double getRate;
/*      */   private String needAcc;
/*      */   private String canGet;
/*      */   private String needCancelAcc;
/*      */   private String getType1;
/*      */   private String zeroFlag;
/*      */   private String getType2;
/*      */   public static final int FIELDNUM = 39;
/*      */   private static String[] PK;
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPDutyGetSchema()
/*      */   {
/*  110 */     this.mErrors = new CErrors();
/*      */ 
/*  112 */     String[] pk = new String[1];
/*  113 */     pk[0] = "GetDutyCode";
/*      */ 
/*  115 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  122 */     LNPDutyGetSchema cloned = (LNPDutyGetSchema)super.clone();
/*  123 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  124 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  130 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getGetDutyCode()
/*      */   {
/*  135 */     return this.getDutyCode;
/*      */   }
/*      */ 
/*      */   public void setGetDutyCode(String aGetDutyCode) {
/*  139 */     this.getDutyCode = aGetDutyCode;
/*      */   }
/*      */ 
/*      */   public String getGetDutyName() {
/*  143 */     return this.getDutyName;
/*      */   }
/*      */ 
/*      */   public void setGetDutyName(String aGetDutyName) {
/*  147 */     this.getDutyName = aGetDutyName;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  151 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  155 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public int getGetIntv() {
/*  159 */     return this.getIntv;
/*      */   }
/*      */ 
/*      */   public void setGetIntv(int aGetIntv) {
/*  163 */     this.getIntv = aGetIntv;
/*      */   }
/*      */ 
/*      */   public void setGetIntv(String aGetIntv) {
/*  167 */     if ((aGetIntv != null) && (!aGetIntv.equals("")))
/*      */     {
/*  169 */       Integer tInteger = new Integer(aGetIntv);
/*  170 */       int i = tInteger.intValue();
/*  171 */       this.getIntv = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDefaultVal()
/*      */   {
/*  177 */     return this.defaultVal;
/*      */   }
/*      */ 
/*      */   public void setDefaultVal(double aDefaultVal) {
/*  181 */     this.defaultVal = aDefaultVal;
/*      */   }
/*      */ 
/*      */   public void setDefaultVal(String aDefaultVal) {
/*  185 */     if ((aDefaultVal != null) && (!aDefaultVal.equals("")))
/*      */     {
/*  187 */       Double tDouble = new Double(aDefaultVal);
/*  188 */       double d = tDouble.doubleValue();
/*  189 */       this.defaultVal = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getCalCode()
/*      */   {
/*  195 */     return this.calCode;
/*      */   }
/*      */ 
/*      */   public void setCalCode(String aCalCode) {
/*  199 */     this.calCode = aCalCode;
/*      */   }
/*      */ 
/*      */   public String getCnterCalCode() {
/*  203 */     return this.cnterCalCode;
/*      */   }
/*      */ 
/*      */   public void setCnterCalCode(String aCnterCalCode) {
/*  207 */     this.cnterCalCode = aCnterCalCode;
/*      */   }
/*      */ 
/*      */   public String getOthCalCode() {
/*  211 */     return this.othCalCode;
/*      */   }
/*      */ 
/*      */   public void setOthCalCode(String aOthCalCode) {
/*  215 */     this.othCalCode = aOthCalCode;
/*      */   }
/*      */ 
/*      */   public int getGetYear() {
/*  219 */     return this.getYear;
/*      */   }
/*      */ 
/*      */   public void setGetYear(int aGetYear) {
/*  223 */     this.getYear = aGetYear;
/*      */   }
/*      */ 
/*      */   public void setGetYear(String aGetYear) {
/*  227 */     if ((aGetYear != null) && (!aGetYear.equals("")))
/*      */     {
/*  229 */       Integer tInteger = new Integer(aGetYear);
/*  230 */       int i = tInteger.intValue();
/*  231 */       this.getYear = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getGetYearFlag()
/*      */   {
/*  237 */     return this.getYearFlag;
/*      */   }
/*      */ 
/*      */   public void setGetYearFlag(String aGetYearFlag) {
/*  241 */     this.getYearFlag = aGetYearFlag;
/*      */   }
/*      */ 
/*      */   public String getStartDateCalRef() {
/*  245 */     return this.startDateCalRef;
/*      */   }
/*      */ 
/*      */   public void setStartDateCalRef(String aStartDateCalRef) {
/*  249 */     this.startDateCalRef = aStartDateCalRef;
/*      */   }
/*      */ 
/*      */   public String getStartDateCalMode() {
/*  253 */     return this.startDateCalMode;
/*      */   }
/*      */ 
/*      */   public void setStartDateCalMode(String aStartDateCalMode) {
/*  257 */     this.startDateCalMode = aStartDateCalMode;
/*      */   }
/*      */ 
/*      */   public int getMinGetStartPeriod() {
/*  261 */     return this.minGetStartPeriod;
/*      */   }
/*      */ 
/*      */   public void setMinGetStartPeriod(int aMinGetStartPeriod) {
/*  265 */     this.minGetStartPeriod = aMinGetStartPeriod;
/*      */   }
/*      */ 
/*      */   public void setMinGetStartPeriod(String aMinGetStartPeriod) {
/*  269 */     if ((aMinGetStartPeriod != null) && (!aMinGetStartPeriod.equals("")))
/*      */     {
/*  271 */       Integer tInteger = new Integer(aMinGetStartPeriod);
/*  272 */       int i = tInteger.intValue();
/*  273 */       this.minGetStartPeriod = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getGetEndPeriod()
/*      */   {
/*  279 */     return this.getEndPeriod;
/*      */   }
/*      */ 
/*      */   public void setGetEndPeriod(int aGetEndPeriod) {
/*  283 */     this.getEndPeriod = aGetEndPeriod;
/*      */   }
/*      */ 
/*      */   public void setGetEndPeriod(String aGetEndPeriod) {
/*  287 */     if ((aGetEndPeriod != null) && (!aGetEndPeriod.equals("")))
/*      */     {
/*  289 */       Integer tInteger = new Integer(aGetEndPeriod);
/*  290 */       int i = tInteger.intValue();
/*  291 */       this.getEndPeriod = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getGetEndUnit()
/*      */   {
/*  297 */     return this.getEndUnit;
/*      */   }
/*      */ 
/*      */   public void setGetEndUnit(String aGetEndUnit) {
/*  301 */     this.getEndUnit = aGetEndUnit;
/*      */   }
/*      */ 
/*      */   public String getEndDateCalRef() {
/*  305 */     return this.endDateCalRef;
/*      */   }
/*      */ 
/*      */   public void setEndDateCalRef(String aEndDateCalRef) {
/*  309 */     this.endDateCalRef = aEndDateCalRef;
/*      */   }
/*      */ 
/*      */   public String getEndDateCalMode() {
/*  313 */     return this.endDateCalMode;
/*      */   }
/*      */ 
/*      */   public void setEndDateCalMode(String aEndDateCalMode) {
/*  317 */     this.endDateCalMode = aEndDateCalMode;
/*      */   }
/*      */ 
/*      */   public int getMaxGetEndPeriod() {
/*  321 */     return this.maxGetEndPeriod;
/*      */   }
/*      */ 
/*      */   public void setMaxGetEndPeriod(int aMaxGetEndPeriod) {
/*  325 */     this.maxGetEndPeriod = aMaxGetEndPeriod;
/*      */   }
/*      */ 
/*      */   public void setMaxGetEndPeriod(String aMaxGetEndPeriod) {
/*  329 */     if ((aMaxGetEndPeriod != null) && (!aMaxGetEndPeriod.equals("")))
/*      */     {
/*  331 */       Integer tInteger = new Integer(aMaxGetEndPeriod);
/*  332 */       int i = tInteger.intValue();
/*  333 */       this.maxGetEndPeriod = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getAddFlag()
/*      */   {
/*  339 */     return this.addFlag;
/*      */   }
/*      */ 
/*      */   public void setAddFlag(String aAddFlag) {
/*  343 */     this.addFlag = aAddFlag;
/*      */   }
/*      */ 
/*      */   public String getSexRelaFlag() {
/*  347 */     return this.sexRelaFlag;
/*      */   }
/*      */ 
/*      */   public void setSexRelaFlag(String aSexRelaFlag) {
/*  351 */     this.sexRelaFlag = aSexRelaFlag;
/*      */   }
/*      */ 
/*      */   public String getUnitAppRelaFlag() {
/*  355 */     return this.unitAppRelaFlag;
/*      */   }
/*      */ 
/*      */   public void setUnitAppRelaFlag(String aUnitAppRelaFlag) {
/*  359 */     this.unitAppRelaFlag = aUnitAppRelaFlag;
/*      */   }
/*      */ 
/*      */   public String getAddAmntFlag() {
/*  363 */     return this.addAmntFlag;
/*      */   }
/*      */ 
/*      */   public void setAddAmntFlag(String aAddAmntFlag) {
/*  367 */     this.addAmntFlag = aAddAmntFlag;
/*      */   }
/*      */ 
/*      */   public String getDiscntFlag() {
/*  371 */     return this.discntFlag;
/*      */   }
/*      */ 
/*      */   public void setDiscntFlag(String aDiscntFlag) {
/*  375 */     this.discntFlag = aDiscntFlag;
/*      */   }
/*      */ 
/*      */   public String getInterestFlag() {
/*  379 */     return this.interestFlag;
/*      */   }
/*      */ 
/*      */   public void setInterestFlag(String aInterestFlag) {
/*  383 */     this.interestFlag = aInterestFlag;
/*      */   }
/*      */ 
/*      */   public String getShareFlag() {
/*  387 */     return this.shareFlag;
/*      */   }
/*      */ 
/*      */   public void setShareFlag(String aShareFlag) {
/*  391 */     this.shareFlag = aShareFlag;
/*      */   }
/*      */ 
/*      */   public String getInpFlag() {
/*  395 */     return this.inpFlag;
/*      */   }
/*      */ 
/*      */   public void setInpFlag(String aInpFlag) {
/*  399 */     this.inpFlag = aInpFlag;
/*      */   }
/*      */ 
/*      */   public String getBnfFlag() {
/*  403 */     return this.bnfFlag;
/*      */   }
/*      */ 
/*      */   public void setBnfFlag(String aBnfFlag) {
/*  407 */     this.bnfFlag = aBnfFlag;
/*      */   }
/*      */ 
/*      */   public String getUrgeGetFlag() {
/*  411 */     return this.urgeGetFlag;
/*      */   }
/*      */ 
/*      */   public void setUrgeGetFlag(String aUrgeGetFlag) {
/*  415 */     this.urgeGetFlag = aUrgeGetFlag;
/*      */   }
/*      */ 
/*      */   public String getDeadValiFlag() {
/*  419 */     return this.deadValiFlag;
/*      */   }
/*      */ 
/*      */   public void setDeadValiFlag(String aDeadValiFlag) {
/*  423 */     this.deadValiFlag = aDeadValiFlag;
/*      */   }
/*      */ 
/*      */   public String getGetInitFlag() {
/*  427 */     return this.getInitFlag;
/*      */   }
/*      */ 
/*      */   public void setGetInitFlag(String aGetInitFlag) {
/*  431 */     this.getInitFlag = aGetInitFlag;
/*      */   }
/*      */ 
/*      */   public double getGetLimit() {
/*  435 */     return this.getLimit;
/*      */   }
/*      */ 
/*      */   public void setGetLimit(double aGetLimit) {
/*  439 */     this.getLimit = aGetLimit;
/*      */   }
/*      */ 
/*      */   public void setGetLimit(String aGetLimit) {
/*  443 */     if ((aGetLimit != null) && (!aGetLimit.equals("")))
/*      */     {
/*  445 */       Double tDouble = new Double(aGetLimit);
/*  446 */       double d = tDouble.doubleValue();
/*  447 */       this.getLimit = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMaxGet()
/*      */   {
/*  453 */     return this.maxGet;
/*      */   }
/*      */ 
/*      */   public void setMaxGet(double aMaxGet) {
/*  457 */     this.maxGet = aMaxGet;
/*      */   }
/*      */ 
/*      */   public void setMaxGet(String aMaxGet) {
/*  461 */     if ((aMaxGet != null) && (!aMaxGet.equals("")))
/*      */     {
/*  463 */       Double tDouble = new Double(aMaxGet);
/*  464 */       double d = tDouble.doubleValue();
/*  465 */       this.maxGet = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getGetRate()
/*      */   {
/*  471 */     return this.getRate;
/*      */   }
/*      */ 
/*      */   public void setGetRate(double aGetRate) {
/*  475 */     this.getRate = aGetRate;
/*      */   }
/*      */ 
/*      */   public void setGetRate(String aGetRate) {
/*  479 */     if ((aGetRate != null) && (!aGetRate.equals("")))
/*      */     {
/*  481 */       Double tDouble = new Double(aGetRate);
/*  482 */       double d = tDouble.doubleValue();
/*  483 */       this.getRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getNeedAcc()
/*      */   {
/*  489 */     return this.needAcc;
/*      */   }
/*      */ 
/*      */   public void setNeedAcc(String aNeedAcc) {
/*  493 */     this.needAcc = aNeedAcc;
/*      */   }
/*      */ 
/*      */   public String getCanGet() {
/*  497 */     return this.canGet;
/*      */   }
/*      */ 
/*      */   public void setCanGet(String aCanGet) {
/*  501 */     this.canGet = aCanGet;
/*      */   }
/*      */ 
/*      */   public String getNeedCancelAcc() {
/*  505 */     return this.needCancelAcc;
/*      */   }
/*      */ 
/*      */   public void setNeedCancelAcc(String aNeedCancelAcc) {
/*  509 */     this.needCancelAcc = aNeedCancelAcc;
/*      */   }
/*      */ 
/*      */   public String getGetType1() {
/*  513 */     return this.getType1;
/*      */   }
/*      */ 
/*      */   public void setGetType1(String aGetType1) {
/*  517 */     this.getType1 = aGetType1;
/*      */   }
/*      */ 
/*      */   public String getZeroFlag() {
/*  521 */     return this.zeroFlag;
/*      */   }
/*      */ 
/*      */   public void setZeroFlag(String aZeroFlag) {
/*  525 */     this.zeroFlag = aZeroFlag;
/*      */   }
/*      */ 
/*      */   public String getGetType2() {
/*  529 */     return this.getType2;
/*      */   }
/*      */ 
/*      */   public void setGetType2(String aGetType2) {
/*  533 */     this.getType2 = aGetType2;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPDutyGetSchema aLNPDutyGetSchema)
/*      */   {
/*  539 */     this.getDutyCode = aLNPDutyGetSchema.getGetDutyCode();
/*  540 */     this.getDutyName = aLNPDutyGetSchema.getGetDutyName();
/*  541 */     this.type = aLNPDutyGetSchema.getType();
/*  542 */     this.getIntv = aLNPDutyGetSchema.getGetIntv();
/*  543 */     this.defaultVal = aLNPDutyGetSchema.getDefaultVal();
/*  544 */     this.calCode = aLNPDutyGetSchema.getCalCode();
/*  545 */     this.cnterCalCode = aLNPDutyGetSchema.getCnterCalCode();
/*  546 */     this.othCalCode = aLNPDutyGetSchema.getOthCalCode();
/*  547 */     this.getYear = aLNPDutyGetSchema.getGetYear();
/*  548 */     this.getYearFlag = aLNPDutyGetSchema.getGetYearFlag();
/*  549 */     this.startDateCalRef = aLNPDutyGetSchema.getStartDateCalRef();
/*  550 */     this.startDateCalMode = aLNPDutyGetSchema.getStartDateCalMode();
/*  551 */     this.minGetStartPeriod = aLNPDutyGetSchema.getMinGetStartPeriod();
/*  552 */     this.getEndPeriod = aLNPDutyGetSchema.getGetEndPeriod();
/*  553 */     this.getEndUnit = aLNPDutyGetSchema.getGetEndUnit();
/*  554 */     this.endDateCalRef = aLNPDutyGetSchema.getEndDateCalRef();
/*  555 */     this.endDateCalMode = aLNPDutyGetSchema.getEndDateCalMode();
/*  556 */     this.maxGetEndPeriod = aLNPDutyGetSchema.getMaxGetEndPeriod();
/*  557 */     this.addFlag = aLNPDutyGetSchema.getAddFlag();
/*  558 */     this.sexRelaFlag = aLNPDutyGetSchema.getSexRelaFlag();
/*  559 */     this.unitAppRelaFlag = aLNPDutyGetSchema.getUnitAppRelaFlag();
/*  560 */     this.addAmntFlag = aLNPDutyGetSchema.getAddAmntFlag();
/*  561 */     this.discntFlag = aLNPDutyGetSchema.getDiscntFlag();
/*  562 */     this.interestFlag = aLNPDutyGetSchema.getInterestFlag();
/*  563 */     this.shareFlag = aLNPDutyGetSchema.getShareFlag();
/*  564 */     this.inpFlag = aLNPDutyGetSchema.getInpFlag();
/*  565 */     this.bnfFlag = aLNPDutyGetSchema.getBnfFlag();
/*  566 */     this.urgeGetFlag = aLNPDutyGetSchema.getUrgeGetFlag();
/*  567 */     this.deadValiFlag = aLNPDutyGetSchema.getDeadValiFlag();
/*  568 */     this.getInitFlag = aLNPDutyGetSchema.getGetInitFlag();
/*  569 */     this.getLimit = aLNPDutyGetSchema.getGetLimit();
/*  570 */     this.maxGet = aLNPDutyGetSchema.getMaxGet();
/*  571 */     this.getRate = aLNPDutyGetSchema.getGetRate();
/*  572 */     this.needAcc = aLNPDutyGetSchema.getNeedAcc();
/*  573 */     this.canGet = aLNPDutyGetSchema.getCanGet();
/*  574 */     this.needCancelAcc = aLNPDutyGetSchema.getNeedCancelAcc();
/*  575 */     this.getType1 = aLNPDutyGetSchema.getGetType1();
/*  576 */     this.zeroFlag = aLNPDutyGetSchema.getZeroFlag();
/*  577 */     this.getType2 = aLNPDutyGetSchema.getGetType2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  586 */       if (rs.getString("GetDutyCode") == null)
/*  587 */         this.getDutyCode = null;
/*      */       else {
/*  589 */         this.getDutyCode = rs.getString("GetDutyCode").trim();
/*      */       }
/*  591 */       if (rs.getString("GetDutyName") == null)
/*  592 */         this.getDutyName = null;
/*      */       else {
/*  594 */         this.getDutyName = rs.getString("GetDutyName").trim();
/*      */       }
/*  596 */       if (rs.getString("Type") == null)
/*  597 */         this.type = null;
/*      */       else {
/*  599 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  601 */       this.getIntv = rs.getInt("GetIntv");
/*  602 */       this.defaultVal = rs.getDouble("DefaultVal");
/*  603 */       if (rs.getString("CalCode") == null)
/*  604 */         this.calCode = null;
/*      */       else {
/*  606 */         this.calCode = rs.getString("CalCode").trim();
/*      */       }
/*  608 */       if (rs.getString("CnterCalCode") == null)
/*  609 */         this.cnterCalCode = null;
/*      */       else {
/*  611 */         this.cnterCalCode = rs.getString("CnterCalCode").trim();
/*      */       }
/*  613 */       if (rs.getString("OthCalCode") == null)
/*  614 */         this.othCalCode = null;
/*      */       else {
/*  616 */         this.othCalCode = rs.getString("OthCalCode").trim();
/*      */       }
/*  618 */       this.getYear = rs.getInt("GetYear");
/*  619 */       if (rs.getString("GetYearFlag") == null)
/*  620 */         this.getYearFlag = null;
/*      */       else {
/*  622 */         this.getYearFlag = rs.getString("GetYearFlag").trim();
/*      */       }
/*  624 */       if (rs.getString("StartDateCalRef") == null)
/*  625 */         this.startDateCalRef = null;
/*      */       else {
/*  627 */         this.startDateCalRef = rs.getString("StartDateCalRef").trim();
/*      */       }
/*  629 */       if (rs.getString("StartDateCalMode") == null)
/*  630 */         this.startDateCalMode = null;
/*      */       else {
/*  632 */         this.startDateCalMode = rs.getString("StartDateCalMode").trim();
/*      */       }
/*  634 */       this.minGetStartPeriod = rs.getInt("MinGetStartPeriod");
/*  635 */       this.getEndPeriod = rs.getInt("GetEndPeriod");
/*  636 */       if (rs.getString("GetEndUnit") == null)
/*  637 */         this.getEndUnit = null;
/*      */       else {
/*  639 */         this.getEndUnit = rs.getString("GetEndUnit").trim();
/*      */       }
/*  641 */       if (rs.getString("EndDateCalRef") == null)
/*  642 */         this.endDateCalRef = null;
/*      */       else {
/*  644 */         this.endDateCalRef = rs.getString("EndDateCalRef").trim();
/*      */       }
/*  646 */       if (rs.getString("EndDateCalMode") == null)
/*  647 */         this.endDateCalMode = null;
/*      */       else {
/*  649 */         this.endDateCalMode = rs.getString("EndDateCalMode").trim();
/*      */       }
/*  651 */       this.maxGetEndPeriod = rs.getInt("MaxGetEndPeriod");
/*  652 */       if (rs.getString("AddFlag") == null)
/*  653 */         this.addFlag = null;
/*      */       else {
/*  655 */         this.addFlag = rs.getString("AddFlag").trim();
/*      */       }
/*  657 */       if (rs.getString("SexRelaFlag") == null)
/*  658 */         this.sexRelaFlag = null;
/*      */       else {
/*  660 */         this.sexRelaFlag = rs.getString("SexRelaFlag").trim();
/*      */       }
/*  662 */       if (rs.getString("UnitAppRelaFlag") == null)
/*  663 */         this.unitAppRelaFlag = null;
/*      */       else {
/*  665 */         this.unitAppRelaFlag = rs.getString("UnitAppRelaFlag").trim();
/*      */       }
/*  667 */       if (rs.getString("AddAmntFlag") == null)
/*  668 */         this.addAmntFlag = null;
/*      */       else {
/*  670 */         this.addAmntFlag = rs.getString("AddAmntFlag").trim();
/*      */       }
/*  672 */       if (rs.getString("DiscntFlag") == null)
/*  673 */         this.discntFlag = null;
/*      */       else {
/*  675 */         this.discntFlag = rs.getString("DiscntFlag").trim();
/*      */       }
/*  677 */       if (rs.getString("InterestFlag") == null)
/*  678 */         this.interestFlag = null;
/*      */       else {
/*  680 */         this.interestFlag = rs.getString("InterestFlag").trim();
/*      */       }
/*  682 */       if (rs.getString("ShareFlag") == null)
/*  683 */         this.shareFlag = null;
/*      */       else {
/*  685 */         this.shareFlag = rs.getString("ShareFlag").trim();
/*      */       }
/*  687 */       if (rs.getString("InpFlag") == null)
/*  688 */         this.inpFlag = null;
/*      */       else {
/*  690 */         this.inpFlag = rs.getString("InpFlag").trim();
/*      */       }
/*  692 */       if (rs.getString("BnfFlag") == null)
/*  693 */         this.bnfFlag = null;
/*      */       else {
/*  695 */         this.bnfFlag = rs.getString("BnfFlag").trim();
/*      */       }
/*  697 */       if (rs.getString("UrgeGetFlag") == null)
/*  698 */         this.urgeGetFlag = null;
/*      */       else {
/*  700 */         this.urgeGetFlag = rs.getString("UrgeGetFlag").trim();
/*      */       }
/*  702 */       if (rs.getString("DeadValiFlag") == null)
/*  703 */         this.deadValiFlag = null;
/*      */       else {
/*  705 */         this.deadValiFlag = rs.getString("DeadValiFlag").trim();
/*      */       }
/*  707 */       if (rs.getString("GetInitFlag") == null)
/*  708 */         this.getInitFlag = null;
/*      */       else {
/*  710 */         this.getInitFlag = rs.getString("GetInitFlag").trim();
/*      */       }
/*  712 */       this.getLimit = rs.getDouble("GetLimit");
/*  713 */       this.maxGet = rs.getDouble("MaxGet");
/*  714 */       this.getRate = rs.getDouble("GetRate");
/*  715 */       if (rs.getString("NeedAcc") == null)
/*  716 */         this.needAcc = null;
/*      */       else {
/*  718 */         this.needAcc = rs.getString("NeedAcc").trim();
/*      */       }
/*  720 */       if (rs.getString("CanGet") == null)
/*  721 */         this.canGet = null;
/*      */       else {
/*  723 */         this.canGet = rs.getString("CanGet").trim();
/*      */       }
/*  725 */       if (rs.getString("NeedCancelAcc") == null)
/*  726 */         this.needCancelAcc = null;
/*      */       else {
/*  728 */         this.needCancelAcc = rs.getString("NeedCancelAcc").trim();
/*      */       }
/*  730 */       if (rs.getString("GetType1") == null)
/*  731 */         this.getType1 = null;
/*      */       else {
/*  733 */         this.getType1 = rs.getString("GetType1").trim();
/*      */       }
/*  735 */       if (rs.getString("ZeroFlag") == null)
/*  736 */         this.zeroFlag = null;
/*      */       else {
/*  738 */         this.zeroFlag = rs.getString("ZeroFlag").trim();
/*      */       }
/*  740 */       if (rs.getString("GetType2") == null)
/*  741 */         this.getType2 = null;
/*      */       else {
/*  743 */         this.getType2 = rs.getString("GetType2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  748 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPDutyGet\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/*  750 */       CError tError = new CError();
/*  751 */       tError.moduleName = "LNPDutyGetSchema";
/*  752 */       tError.functionName = "setSchema";
/*  753 */       tError.errorMessage = sqle.toString();
/*  754 */       this.mErrors.addOneError(tError);
/*  755 */       return false;
/*      */     }
/*  757 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPDutyGetSchema getSchema()
/*      */   {
/*  762 */     LNPDutyGetSchema aLNPDutyGetSchema = new LNPDutyGetSchema();
/*  763 */     aLNPDutyGetSchema.setSchema(this);
/*  764 */     return aLNPDutyGetSchema;
/*      */   }
/*      */ 
/*      */   public LNPDutyGetDB getDB()
/*      */   {
/*  769 */     LNPDutyGetDB aDBOper = new LNPDutyGetDB();
/*  770 */     aDBOper.setSchema(this);
/*  771 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  778 */     StringBuffer strReturn = new StringBuffer(256);
/*  779 */     strReturn.append(StrTool.cTrim(this.getDutyCode)); strReturn.append("|");
/*  780 */     strReturn.append(StrTool.cTrim(this.getDutyName)); strReturn.append("|");
/*  781 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  782 */     strReturn.append(ChgData.chgData(this.getIntv)); strReturn.append("|");
/*  783 */     strReturn.append(ChgData.chgData(this.defaultVal)); strReturn.append("|");
/*  784 */     strReturn.append(StrTool.cTrim(this.calCode)); strReturn.append("|");
/*  785 */     strReturn.append(StrTool.cTrim(this.cnterCalCode)); strReturn.append("|");
/*  786 */     strReturn.append(StrTool.cTrim(this.othCalCode)); strReturn.append("|");
/*  787 */     strReturn.append(ChgData.chgData(this.getYear)); strReturn.append("|");
/*  788 */     strReturn.append(StrTool.cTrim(this.getYearFlag)); strReturn.append("|");
/*  789 */     strReturn.append(StrTool.cTrim(this.startDateCalRef)); strReturn.append("|");
/*  790 */     strReturn.append(StrTool.cTrim(this.startDateCalMode)); strReturn.append("|");
/*  791 */     strReturn.append(ChgData.chgData(this.minGetStartPeriod)); strReturn.append("|");
/*  792 */     strReturn.append(ChgData.chgData(this.getEndPeriod)); strReturn.append("|");
/*  793 */     strReturn.append(StrTool.cTrim(this.getEndUnit)); strReturn.append("|");
/*  794 */     strReturn.append(StrTool.cTrim(this.endDateCalRef)); strReturn.append("|");
/*  795 */     strReturn.append(StrTool.cTrim(this.endDateCalMode)); strReturn.append("|");
/*  796 */     strReturn.append(ChgData.chgData(this.maxGetEndPeriod)); strReturn.append("|");
/*  797 */     strReturn.append(StrTool.cTrim(this.addFlag)); strReturn.append("|");
/*  798 */     strReturn.append(StrTool.cTrim(this.sexRelaFlag)); strReturn.append("|");
/*  799 */     strReturn.append(StrTool.cTrim(this.unitAppRelaFlag)); strReturn.append("|");
/*  800 */     strReturn.append(StrTool.cTrim(this.addAmntFlag)); strReturn.append("|");
/*  801 */     strReturn.append(StrTool.cTrim(this.discntFlag)); strReturn.append("|");
/*  802 */     strReturn.append(StrTool.cTrim(this.interestFlag)); strReturn.append("|");
/*  803 */     strReturn.append(StrTool.cTrim(this.shareFlag)); strReturn.append("|");
/*  804 */     strReturn.append(StrTool.cTrim(this.inpFlag)); strReturn.append("|");
/*  805 */     strReturn.append(StrTool.cTrim(this.bnfFlag)); strReturn.append("|");
/*  806 */     strReturn.append(StrTool.cTrim(this.urgeGetFlag)); strReturn.append("|");
/*  807 */     strReturn.append(StrTool.cTrim(this.deadValiFlag)); strReturn.append("|");
/*  808 */     strReturn.append(StrTool.cTrim(this.getInitFlag)); strReturn.append("|");
/*  809 */     strReturn.append(ChgData.chgData(this.getLimit)); strReturn.append("|");
/*  810 */     strReturn.append(ChgData.chgData(this.maxGet)); strReturn.append("|");
/*  811 */     strReturn.append(ChgData.chgData(this.getRate)); strReturn.append("|");
/*  812 */     strReturn.append(StrTool.cTrim(this.needAcc)); strReturn.append("|");
/*  813 */     strReturn.append(StrTool.cTrim(this.canGet)); strReturn.append("|");
/*  814 */     strReturn.append(StrTool.cTrim(this.needCancelAcc)); strReturn.append("|");
/*  815 */     strReturn.append(StrTool.cTrim(this.getType1)); strReturn.append("|");
/*  816 */     strReturn.append(StrTool.cTrim(this.zeroFlag)); strReturn.append("|");
/*  817 */     strReturn.append(StrTool.cTrim(this.getType2));
/*  818 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  826 */       this.getDutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  827 */       this.getDutyName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  828 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  829 */       this.getIntv = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|"))).intValue();
/*  830 */       this.defaultVal = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|"))).doubleValue();
/*  831 */       this.calCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  832 */       this.cnterCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  833 */       this.othCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  834 */       this.getYear = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).intValue();
/*  835 */       this.getYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  836 */       this.startDateCalRef = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  837 */       this.startDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  838 */       this.minGetStartPeriod = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).intValue();
/*  839 */       this.getEndPeriod = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|"))).intValue();
/*  840 */       this.getEndUnit = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  841 */       this.endDateCalRef = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  842 */       this.endDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  843 */       this.maxGetEndPeriod = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|"))).intValue();
/*  844 */       this.addFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  845 */       this.sexRelaFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  846 */       this.unitAppRelaFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  847 */       this.addAmntFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  848 */       this.discntFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  849 */       this.interestFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  850 */       this.shareFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  851 */       this.inpFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  852 */       this.bnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  853 */       this.urgeGetFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*  854 */       this.deadValiFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*  855 */       this.getInitFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/*  856 */       this.getLimit = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|"))).doubleValue();
/*  857 */       this.maxGet = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|"))).doubleValue();
/*  858 */       this.getRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 33, "|"))).doubleValue();
/*  859 */       this.needAcc = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/*  860 */       this.canGet = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/*  861 */       this.needCancelAcc = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
/*  862 */       this.getType1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/*  863 */       this.zeroFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/*  864 */       this.getType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  869 */       CError tError = new CError();
/*  870 */       tError.moduleName = "LNPDutyGetSchema";
/*  871 */       tError.functionName = "decode";
/*  872 */       tError.errorMessage = ex.toString();
/*  873 */       this.mErrors.addOneError(tError);
/*      */ 
/*  875 */       return false;
/*      */     }
/*  877 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  883 */     String strReturn = "";
/*  884 */     if (FCode.equalsIgnoreCase("getDutyCode"))
/*      */     {
/*  886 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getDutyCode));
/*      */     }
/*  888 */     if (FCode.equalsIgnoreCase("getDutyName"))
/*      */     {
/*  890 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getDutyName));
/*      */     }
/*  892 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  894 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  896 */     if (FCode.equalsIgnoreCase("getIntv"))
/*      */     {
/*  898 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getIntv));
/*      */     }
/*  900 */     if (FCode.equalsIgnoreCase("defaultVal"))
/*      */     {
/*  902 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.defaultVal));
/*      */     }
/*  904 */     if (FCode.equalsIgnoreCase("calCode"))
/*      */     {
/*  906 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.calCode));
/*      */     }
/*  908 */     if (FCode.equalsIgnoreCase("cnterCalCode"))
/*      */     {
/*  910 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.cnterCalCode));
/*      */     }
/*  912 */     if (FCode.equalsIgnoreCase("othCalCode"))
/*      */     {
/*  914 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.othCalCode));
/*      */     }
/*  916 */     if (FCode.equalsIgnoreCase("getYear"))
/*      */     {
/*  918 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getYear));
/*      */     }
/*  920 */     if (FCode.equalsIgnoreCase("getYearFlag"))
/*      */     {
/*  922 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getYearFlag));
/*      */     }
/*  924 */     if (FCode.equalsIgnoreCase("startDateCalRef"))
/*      */     {
/*  926 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startDateCalRef));
/*      */     }
/*  928 */     if (FCode.equalsIgnoreCase("startDateCalMode"))
/*      */     {
/*  930 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startDateCalMode));
/*      */     }
/*  932 */     if (FCode.equalsIgnoreCase("minGetStartPeriod"))
/*      */     {
/*  934 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minGetStartPeriod));
/*      */     }
/*  936 */     if (FCode.equalsIgnoreCase("getEndPeriod"))
/*      */     {
/*  938 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getEndPeriod));
/*      */     }
/*  940 */     if (FCode.equalsIgnoreCase("getEndUnit"))
/*      */     {
/*  942 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getEndUnit));
/*      */     }
/*  944 */     if (FCode.equalsIgnoreCase("endDateCalRef"))
/*      */     {
/*  946 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endDateCalRef));
/*      */     }
/*  948 */     if (FCode.equalsIgnoreCase("endDateCalMode"))
/*      */     {
/*  950 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endDateCalMode));
/*      */     }
/*  952 */     if (FCode.equalsIgnoreCase("maxGetEndPeriod"))
/*      */     {
/*  954 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.maxGetEndPeriod));
/*      */     }
/*  956 */     if (FCode.equalsIgnoreCase("addFlag"))
/*      */     {
/*  958 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addFlag));
/*      */     }
/*  960 */     if (FCode.equalsIgnoreCase("sexRelaFlag"))
/*      */     {
/*  962 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sexRelaFlag));
/*      */     }
/*  964 */     if (FCode.equalsIgnoreCase("unitAppRelaFlag"))
/*      */     {
/*  966 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.unitAppRelaFlag));
/*      */     }
/*  968 */     if (FCode.equalsIgnoreCase("addAmntFlag"))
/*      */     {
/*  970 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addAmntFlag));
/*      */     }
/*  972 */     if (FCode.equalsIgnoreCase("discntFlag"))
/*      */     {
/*  974 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.discntFlag));
/*      */     }
/*  976 */     if (FCode.equalsIgnoreCase("interestFlag"))
/*      */     {
/*  978 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.interestFlag));
/*      */     }
/*  980 */     if (FCode.equalsIgnoreCase("shareFlag"))
/*      */     {
/*  982 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.shareFlag));
/*      */     }
/*  984 */     if (FCode.equalsIgnoreCase("inpFlag"))
/*      */     {
/*  986 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.inpFlag));
/*      */     }
/*  988 */     if (FCode.equalsIgnoreCase("bnfFlag"))
/*      */     {
/*  990 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bnfFlag));
/*      */     }
/*  992 */     if (FCode.equalsIgnoreCase("urgeGetFlag"))
/*      */     {
/*  994 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.urgeGetFlag));
/*      */     }
/*  996 */     if (FCode.equalsIgnoreCase("deadValiFlag"))
/*      */     {
/*  998 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.deadValiFlag));
/*      */     }
/* 1000 */     if (FCode.equalsIgnoreCase("getInitFlag"))
/*      */     {
/* 1002 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getInitFlag));
/*      */     }
/* 1004 */     if (FCode.equalsIgnoreCase("getLimit"))
/*      */     {
/* 1006 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getLimit));
/*      */     }
/* 1008 */     if (FCode.equalsIgnoreCase("maxGet"))
/*      */     {
/* 1010 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.maxGet));
/*      */     }
/* 1012 */     if (FCode.equalsIgnoreCase("getRate"))
/*      */     {
/* 1014 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getRate));
/*      */     }
/* 1016 */     if (FCode.equalsIgnoreCase("needAcc"))
/*      */     {
/* 1018 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.needAcc));
/*      */     }
/* 1020 */     if (FCode.equalsIgnoreCase("canGet"))
/*      */     {
/* 1022 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.canGet));
/*      */     }
/* 1024 */     if (FCode.equalsIgnoreCase("needCancelAcc"))
/*      */     {
/* 1026 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.needCancelAcc));
/*      */     }
/* 1028 */     if (FCode.equalsIgnoreCase("getType1"))
/*      */     {
/* 1030 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getType1));
/*      */     }
/* 1032 */     if (FCode.equalsIgnoreCase("zeroFlag"))
/*      */     {
/* 1034 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.zeroFlag));
/*      */     }
/* 1036 */     if (FCode.equalsIgnoreCase("getType2"))
/*      */     {
/* 1038 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getType2));
/*      */     }
/* 1040 */     if (strReturn.equals(""))
/*      */     {
/* 1042 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1045 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1052 */     String strFieldValue = "";
/* 1053 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1055 */       strFieldValue = StrTool.GBKToUnicode(this.getDutyCode);
/* 1056 */       break;
/*      */     case 1:
/* 1058 */       strFieldValue = StrTool.GBKToUnicode(this.getDutyName);
/* 1059 */       break;
/*      */     case 2:
/* 1061 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/* 1062 */       break;
/*      */     case 3:
/* 1064 */       strFieldValue = String.valueOf(this.getIntv);
/* 1065 */       break;
/*      */     case 4:
/* 1067 */       strFieldValue = String.valueOf(this.defaultVal);
/* 1068 */       break;
/*      */     case 5:
/* 1070 */       strFieldValue = StrTool.GBKToUnicode(this.calCode);
/* 1071 */       break;
/*      */     case 6:
/* 1073 */       strFieldValue = StrTool.GBKToUnicode(this.cnterCalCode);
/* 1074 */       break;
/*      */     case 7:
/* 1076 */       strFieldValue = StrTool.GBKToUnicode(this.othCalCode);
/* 1077 */       break;
/*      */     case 8:
/* 1079 */       strFieldValue = String.valueOf(this.getYear);
/* 1080 */       break;
/*      */     case 9:
/* 1082 */       strFieldValue = StrTool.GBKToUnicode(this.getYearFlag);
/* 1083 */       break;
/*      */     case 10:
/* 1085 */       strFieldValue = StrTool.GBKToUnicode(this.startDateCalRef);
/* 1086 */       break;
/*      */     case 11:
/* 1088 */       strFieldValue = StrTool.GBKToUnicode(this.startDateCalMode);
/* 1089 */       break;
/*      */     case 12:
/* 1091 */       strFieldValue = String.valueOf(this.minGetStartPeriod);
/* 1092 */       break;
/*      */     case 13:
/* 1094 */       strFieldValue = String.valueOf(this.getEndPeriod);
/* 1095 */       break;
/*      */     case 14:
/* 1097 */       strFieldValue = StrTool.GBKToUnicode(this.getEndUnit);
/* 1098 */       break;
/*      */     case 15:
/* 1100 */       strFieldValue = StrTool.GBKToUnicode(this.endDateCalRef);
/* 1101 */       break;
/*      */     case 16:
/* 1103 */       strFieldValue = StrTool.GBKToUnicode(this.endDateCalMode);
/* 1104 */       break;
/*      */     case 17:
/* 1106 */       strFieldValue = String.valueOf(this.maxGetEndPeriod);
/* 1107 */       break;
/*      */     case 18:
/* 1109 */       strFieldValue = StrTool.GBKToUnicode(this.addFlag);
/* 1110 */       break;
/*      */     case 19:
/* 1112 */       strFieldValue = StrTool.GBKToUnicode(this.sexRelaFlag);
/* 1113 */       break;
/*      */     case 20:
/* 1115 */       strFieldValue = StrTool.GBKToUnicode(this.unitAppRelaFlag);
/* 1116 */       break;
/*      */     case 21:
/* 1118 */       strFieldValue = StrTool.GBKToUnicode(this.addAmntFlag);
/* 1119 */       break;
/*      */     case 22:
/* 1121 */       strFieldValue = StrTool.GBKToUnicode(this.discntFlag);
/* 1122 */       break;
/*      */     case 23:
/* 1124 */       strFieldValue = StrTool.GBKToUnicode(this.interestFlag);
/* 1125 */       break;
/*      */     case 24:
/* 1127 */       strFieldValue = StrTool.GBKToUnicode(this.shareFlag);
/* 1128 */       break;
/*      */     case 25:
/* 1130 */       strFieldValue = StrTool.GBKToUnicode(this.inpFlag);
/* 1131 */       break;
/*      */     case 26:
/* 1133 */       strFieldValue = StrTool.GBKToUnicode(this.bnfFlag);
/* 1134 */       break;
/*      */     case 27:
/* 1136 */       strFieldValue = StrTool.GBKToUnicode(this.urgeGetFlag);
/* 1137 */       break;
/*      */     case 28:
/* 1139 */       strFieldValue = StrTool.GBKToUnicode(this.deadValiFlag);
/* 1140 */       break;
/*      */     case 29:
/* 1142 */       strFieldValue = StrTool.GBKToUnicode(this.getInitFlag);
/* 1143 */       break;
/*      */     case 30:
/* 1145 */       strFieldValue = String.valueOf(this.getLimit);
/* 1146 */       break;
/*      */     case 31:
/* 1148 */       strFieldValue = String.valueOf(this.maxGet);
/* 1149 */       break;
/*      */     case 32:
/* 1151 */       strFieldValue = String.valueOf(this.getRate);
/* 1152 */       break;
/*      */     case 33:
/* 1154 */       strFieldValue = StrTool.GBKToUnicode(this.needAcc);
/* 1155 */       break;
/*      */     case 34:
/* 1157 */       strFieldValue = StrTool.GBKToUnicode(this.canGet);
/* 1158 */       break;
/*      */     case 35:
/* 1160 */       strFieldValue = StrTool.GBKToUnicode(this.needCancelAcc);
/* 1161 */       break;
/*      */     case 36:
/* 1163 */       strFieldValue = StrTool.GBKToUnicode(this.getType1);
/* 1164 */       break;
/*      */     case 37:
/* 1166 */       strFieldValue = StrTool.GBKToUnicode(this.zeroFlag);
/* 1167 */       break;
/*      */     case 38:
/* 1169 */       strFieldValue = StrTool.GBKToUnicode(this.getType2);
/* 1170 */       break;
/*      */     default:
/* 1172 */       strFieldValue = "";
/*      */     }
/* 1174 */     if (strFieldValue.equals("")) {
/* 1175 */       strFieldValue = "null";
/*      */     }
/* 1177 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1183 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1184 */       return false;
/*      */     }
/* 1186 */     if (FCode.equalsIgnoreCase("getDutyCode"))
/*      */     {
/* 1188 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1190 */         this.getDutyCode = FValue.trim();
/*      */       }
/*      */       else
/* 1193 */         this.getDutyCode = null;
/*      */     }
/* 1195 */     if (FCode.equalsIgnoreCase("getDutyName"))
/*      */     {
/* 1197 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1199 */         this.getDutyName = FValue.trim();
/*      */       }
/*      */       else
/* 1202 */         this.getDutyName = null;
/*      */     }
/* 1204 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/* 1206 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1208 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/* 1211 */         this.type = null;
/*      */     }
/* 1213 */     if (FCode.equalsIgnoreCase("getIntv"))
/*      */     {
/* 1215 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1217 */         Integer tInteger = new Integer(FValue);
/* 1218 */         int i = tInteger.intValue();
/* 1219 */         this.getIntv = i;
/*      */       }
/*      */     }
/* 1222 */     if (FCode.equalsIgnoreCase("defaultVal"))
/*      */     {
/* 1224 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1226 */         Double tDouble = new Double(FValue);
/* 1227 */         double d = tDouble.doubleValue();
/* 1228 */         this.defaultVal = d;
/*      */       }
/*      */     }
/* 1231 */     if (FCode.equalsIgnoreCase("calCode"))
/*      */     {
/* 1233 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1235 */         this.calCode = FValue.trim();
/*      */       }
/*      */       else
/* 1238 */         this.calCode = null;
/*      */     }
/* 1240 */     if (FCode.equalsIgnoreCase("cnterCalCode"))
/*      */     {
/* 1242 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1244 */         this.cnterCalCode = FValue.trim();
/*      */       }
/*      */       else
/* 1247 */         this.cnterCalCode = null;
/*      */     }
/* 1249 */     if (FCode.equalsIgnoreCase("othCalCode"))
/*      */     {
/* 1251 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1253 */         this.othCalCode = FValue.trim();
/*      */       }
/*      */       else
/* 1256 */         this.othCalCode = null;
/*      */     }
/* 1258 */     if (FCode.equalsIgnoreCase("getYear"))
/*      */     {
/* 1260 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1262 */         Integer tInteger = new Integer(FValue);
/* 1263 */         int i = tInteger.intValue();
/* 1264 */         this.getYear = i;
/*      */       }
/*      */     }
/* 1267 */     if (FCode.equalsIgnoreCase("getYearFlag"))
/*      */     {
/* 1269 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1271 */         this.getYearFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1274 */         this.getYearFlag = null;
/*      */     }
/* 1276 */     if (FCode.equalsIgnoreCase("startDateCalRef"))
/*      */     {
/* 1278 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1280 */         this.startDateCalRef = FValue.trim();
/*      */       }
/*      */       else
/* 1283 */         this.startDateCalRef = null;
/*      */     }
/* 1285 */     if (FCode.equalsIgnoreCase("startDateCalMode"))
/*      */     {
/* 1287 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1289 */         this.startDateCalMode = FValue.trim();
/*      */       }
/*      */       else
/* 1292 */         this.startDateCalMode = null;
/*      */     }
/* 1294 */     if (FCode.equalsIgnoreCase("minGetStartPeriod"))
/*      */     {
/* 1296 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1298 */         Integer tInteger = new Integer(FValue);
/* 1299 */         int i = tInteger.intValue();
/* 1300 */         this.minGetStartPeriod = i;
/*      */       }
/*      */     }
/* 1303 */     if (FCode.equalsIgnoreCase("getEndPeriod"))
/*      */     {
/* 1305 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1307 */         Integer tInteger = new Integer(FValue);
/* 1308 */         int i = tInteger.intValue();
/* 1309 */         this.getEndPeriod = i;
/*      */       }
/*      */     }
/* 1312 */     if (FCode.equalsIgnoreCase("getEndUnit"))
/*      */     {
/* 1314 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1316 */         this.getEndUnit = FValue.trim();
/*      */       }
/*      */       else
/* 1319 */         this.getEndUnit = null;
/*      */     }
/* 1321 */     if (FCode.equalsIgnoreCase("endDateCalRef"))
/*      */     {
/* 1323 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1325 */         this.endDateCalRef = FValue.trim();
/*      */       }
/*      */       else
/* 1328 */         this.endDateCalRef = null;
/*      */     }
/* 1330 */     if (FCode.equalsIgnoreCase("endDateCalMode"))
/*      */     {
/* 1332 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1334 */         this.endDateCalMode = FValue.trim();
/*      */       }
/*      */       else
/* 1337 */         this.endDateCalMode = null;
/*      */     }
/* 1339 */     if (FCode.equalsIgnoreCase("maxGetEndPeriod"))
/*      */     {
/* 1341 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1343 */         Integer tInteger = new Integer(FValue);
/* 1344 */         int i = tInteger.intValue();
/* 1345 */         this.maxGetEndPeriod = i;
/*      */       }
/*      */     }
/* 1348 */     if (FCode.equalsIgnoreCase("addFlag"))
/*      */     {
/* 1350 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1352 */         this.addFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1355 */         this.addFlag = null;
/*      */     }
/* 1357 */     if (FCode.equalsIgnoreCase("sexRelaFlag"))
/*      */     {
/* 1359 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1361 */         this.sexRelaFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1364 */         this.sexRelaFlag = null;
/*      */     }
/* 1366 */     if (FCode.equalsIgnoreCase("unitAppRelaFlag"))
/*      */     {
/* 1368 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1370 */         this.unitAppRelaFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1373 */         this.unitAppRelaFlag = null;
/*      */     }
/* 1375 */     if (FCode.equalsIgnoreCase("addAmntFlag"))
/*      */     {
/* 1377 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1379 */         this.addAmntFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1382 */         this.addAmntFlag = null;
/*      */     }
/* 1384 */     if (FCode.equalsIgnoreCase("discntFlag"))
/*      */     {
/* 1386 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1388 */         this.discntFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1391 */         this.discntFlag = null;
/*      */     }
/* 1393 */     if (FCode.equalsIgnoreCase("interestFlag"))
/*      */     {
/* 1395 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1397 */         this.interestFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1400 */         this.interestFlag = null;
/*      */     }
/* 1402 */     if (FCode.equalsIgnoreCase("shareFlag"))
/*      */     {
/* 1404 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1406 */         this.shareFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1409 */         this.shareFlag = null;
/*      */     }
/* 1411 */     if (FCode.equalsIgnoreCase("inpFlag"))
/*      */     {
/* 1413 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1415 */         this.inpFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1418 */         this.inpFlag = null;
/*      */     }
/* 1420 */     if (FCode.equalsIgnoreCase("bnfFlag"))
/*      */     {
/* 1422 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1424 */         this.bnfFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1427 */         this.bnfFlag = null;
/*      */     }
/* 1429 */     if (FCode.equalsIgnoreCase("urgeGetFlag"))
/*      */     {
/* 1431 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1433 */         this.urgeGetFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1436 */         this.urgeGetFlag = null;
/*      */     }
/* 1438 */     if (FCode.equalsIgnoreCase("deadValiFlag"))
/*      */     {
/* 1440 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1442 */         this.deadValiFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1445 */         this.deadValiFlag = null;
/*      */     }
/* 1447 */     if (FCode.equalsIgnoreCase("getInitFlag"))
/*      */     {
/* 1449 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1451 */         this.getInitFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1454 */         this.getInitFlag = null;
/*      */     }
/* 1456 */     if (FCode.equalsIgnoreCase("getLimit"))
/*      */     {
/* 1458 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1460 */         Double tDouble = new Double(FValue);
/* 1461 */         double d = tDouble.doubleValue();
/* 1462 */         this.getLimit = d;
/*      */       }
/*      */     }
/* 1465 */     if (FCode.equalsIgnoreCase("maxGet"))
/*      */     {
/* 1467 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1469 */         Double tDouble = new Double(FValue);
/* 1470 */         double d = tDouble.doubleValue();
/* 1471 */         this.maxGet = d;
/*      */       }
/*      */     }
/* 1474 */     if (FCode.equalsIgnoreCase("getRate"))
/*      */     {
/* 1476 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1478 */         Double tDouble = new Double(FValue);
/* 1479 */         double d = tDouble.doubleValue();
/* 1480 */         this.getRate = d;
/*      */       }
/*      */     }
/* 1483 */     if (FCode.equalsIgnoreCase("needAcc"))
/*      */     {
/* 1485 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1487 */         this.needAcc = FValue.trim();
/*      */       }
/*      */       else
/* 1490 */         this.needAcc = null;
/*      */     }
/* 1492 */     if (FCode.equalsIgnoreCase("canGet"))
/*      */     {
/* 1494 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1496 */         this.canGet = FValue.trim();
/*      */       }
/*      */       else
/* 1499 */         this.canGet = null;
/*      */     }
/* 1501 */     if (FCode.equalsIgnoreCase("needCancelAcc"))
/*      */     {
/* 1503 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1505 */         this.needCancelAcc = FValue.trim();
/*      */       }
/*      */       else
/* 1508 */         this.needCancelAcc = null;
/*      */     }
/* 1510 */     if (FCode.equalsIgnoreCase("getType1"))
/*      */     {
/* 1512 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1514 */         this.getType1 = FValue.trim();
/*      */       }
/*      */       else
/* 1517 */         this.getType1 = null;
/*      */     }
/* 1519 */     if (FCode.equalsIgnoreCase("zeroFlag"))
/*      */     {
/* 1521 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1523 */         this.zeroFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1526 */         this.zeroFlag = null;
/*      */     }
/* 1528 */     if (FCode.equalsIgnoreCase("getType2"))
/*      */     {
/* 1530 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1532 */         this.getType2 = FValue.trim();
/*      */       }
/*      */       else
/* 1535 */         this.getType2 = null;
/*      */     }
/* 1537 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1542 */     if (otherObject == null) return false;
/* 1543 */     if (this == otherObject) return true;
/* 1544 */     if (getClass() != otherObject.getClass()) return false;
/* 1545 */     LNPDutyGetSchema other = (LNPDutyGetSchema)otherObject;
/* 1546 */     if ((this.getDutyCode == null) && (other.getGetDutyCode() != null)) return false;
/* 1547 */     if ((this.getDutyCode != null) && (!this.getDutyCode.equals(other.getGetDutyCode()))) return false;
/* 1548 */     if ((this.getDutyName == null) && (other.getGetDutyName() != null)) return false;
/* 1549 */     if ((this.getDutyName != null) && (!this.getDutyName.equals(other.getGetDutyName()))) return false;
/* 1550 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 1551 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 1552 */     if (this.getIntv != other.getGetIntv()) return false;
/* 1553 */     if (Double.doubleToLongBits(this.defaultVal) != Double.doubleToLongBits(other.getDefaultVal())) return false;
/* 1554 */     if ((this.calCode == null) && (other.getCalCode() != null)) return false;
/* 1555 */     if ((this.calCode != null) && (!this.calCode.equals(other.getCalCode()))) return false;
/* 1556 */     if ((this.cnterCalCode == null) && (other.getCnterCalCode() != null)) return false;
/* 1557 */     if ((this.cnterCalCode != null) && (!this.cnterCalCode.equals(other.getCnterCalCode()))) return false;
/* 1558 */     if ((this.othCalCode == null) && (other.getOthCalCode() != null)) return false;
/* 1559 */     if ((this.othCalCode != null) && (!this.othCalCode.equals(other.getOthCalCode()))) return false;
/* 1560 */     if (this.getYear != other.getGetYear()) return false;
/* 1561 */     if ((this.getYearFlag == null) && (other.getGetYearFlag() != null)) return false;
/* 1562 */     if ((this.getYearFlag != null) && (!this.getYearFlag.equals(other.getGetYearFlag()))) return false;
/* 1563 */     if ((this.startDateCalRef == null) && (other.getStartDateCalRef() != null)) return false;
/* 1564 */     if ((this.startDateCalRef != null) && (!this.startDateCalRef.equals(other.getStartDateCalRef()))) return false;
/* 1565 */     if ((this.startDateCalMode == null) && (other.getStartDateCalMode() != null)) return false;
/* 1566 */     if ((this.startDateCalMode != null) && (!this.startDateCalMode.equals(other.getStartDateCalMode()))) return false;
/* 1567 */     if (this.minGetStartPeriod != other.getMinGetStartPeriod()) return false;
/* 1568 */     if (this.getEndPeriod != other.getGetEndPeriod()) return false;
/* 1569 */     if ((this.getEndUnit == null) && (other.getGetEndUnit() != null)) return false;
/* 1570 */     if ((this.getEndUnit != null) && (!this.getEndUnit.equals(other.getGetEndUnit()))) return false;
/* 1571 */     if ((this.endDateCalRef == null) && (other.getEndDateCalRef() != null)) return false;
/* 1572 */     if ((this.endDateCalRef != null) && (!this.endDateCalRef.equals(other.getEndDateCalRef()))) return false;
/* 1573 */     if ((this.endDateCalMode == null) && (other.getEndDateCalMode() != null)) return false;
/* 1574 */     if ((this.endDateCalMode != null) && (!this.endDateCalMode.equals(other.getEndDateCalMode()))) return false;
/* 1575 */     if (this.maxGetEndPeriod != other.getMaxGetEndPeriod()) return false;
/* 1576 */     if ((this.addFlag == null) && (other.getAddFlag() != null)) return false;
/* 1577 */     if ((this.addFlag != null) && (!this.addFlag.equals(other.getAddFlag()))) return false;
/* 1578 */     if ((this.sexRelaFlag == null) && (other.getSexRelaFlag() != null)) return false;
/* 1579 */     if ((this.sexRelaFlag != null) && (!this.sexRelaFlag.equals(other.getSexRelaFlag()))) return false;
/* 1580 */     if ((this.unitAppRelaFlag == null) && (other.getUnitAppRelaFlag() != null)) return false;
/* 1581 */     if ((this.unitAppRelaFlag != null) && (!this.unitAppRelaFlag.equals(other.getUnitAppRelaFlag()))) return false;
/* 1582 */     if ((this.addAmntFlag == null) && (other.getAddAmntFlag() != null)) return false;
/* 1583 */     if ((this.addAmntFlag != null) && (!this.addAmntFlag.equals(other.getAddAmntFlag()))) return false;
/* 1584 */     if ((this.discntFlag == null) && (other.getDiscntFlag() != null)) return false;
/* 1585 */     if ((this.discntFlag != null) && (!this.discntFlag.equals(other.getDiscntFlag()))) return false;
/* 1586 */     if ((this.interestFlag == null) && (other.getInterestFlag() != null)) return false;
/* 1587 */     if ((this.interestFlag != null) && (!this.interestFlag.equals(other.getInterestFlag()))) return false;
/* 1588 */     if ((this.shareFlag == null) && (other.getShareFlag() != null)) return false;
/* 1589 */     if ((this.shareFlag != null) && (!this.shareFlag.equals(other.getShareFlag()))) return false;
/* 1590 */     if ((this.inpFlag == null) && (other.getInpFlag() != null)) return false;
/* 1591 */     if ((this.inpFlag != null) && (!this.inpFlag.equals(other.getInpFlag()))) return false;
/* 1592 */     if ((this.bnfFlag == null) && (other.getBnfFlag() != null)) return false;
/* 1593 */     if ((this.bnfFlag != null) && (!this.bnfFlag.equals(other.getBnfFlag()))) return false;
/* 1594 */     if ((this.urgeGetFlag == null) && (other.getUrgeGetFlag() != null)) return false;
/* 1595 */     if ((this.urgeGetFlag != null) && (!this.urgeGetFlag.equals(other.getUrgeGetFlag()))) return false;
/* 1596 */     if ((this.deadValiFlag == null) && (other.getDeadValiFlag() != null)) return false;
/* 1597 */     if ((this.deadValiFlag != null) && (!this.deadValiFlag.equals(other.getDeadValiFlag()))) return false;
/* 1598 */     if ((this.getInitFlag == null) && (other.getGetInitFlag() != null)) return false;
/* 1599 */     if ((this.getInitFlag != null) && (!this.getInitFlag.equals(other.getGetInitFlag()))) return false;
/* 1600 */     if (Double.doubleToLongBits(this.getLimit) != Double.doubleToLongBits(other.getGetLimit())) return false;
/* 1601 */     if (Double.doubleToLongBits(this.maxGet) != Double.doubleToLongBits(other.getMaxGet())) return false;
/* 1602 */     if (Double.doubleToLongBits(this.getRate) != Double.doubleToLongBits(other.getGetRate())) return false;
/* 1603 */     if ((this.needAcc == null) && (other.getNeedAcc() != null)) return false;
/* 1604 */     if ((this.needAcc != null) && (!this.needAcc.equals(other.getNeedAcc()))) return false;
/* 1605 */     if ((this.canGet == null) && (other.getCanGet() != null)) return false;
/* 1606 */     if ((this.canGet != null) && (!this.canGet.equals(other.getCanGet()))) return false;
/* 1607 */     if ((this.needCancelAcc == null) && (other.getNeedCancelAcc() != null)) return false;
/* 1608 */     if ((this.needCancelAcc != null) && (!this.needCancelAcc.equals(other.getNeedCancelAcc()))) return false;
/* 1609 */     if ((this.getType1 == null) && (other.getGetType1() != null)) return false;
/* 1610 */     if ((this.getType1 != null) && (!this.getType1.equals(other.getGetType1()))) return false;
/* 1611 */     if ((this.zeroFlag == null) && (other.getZeroFlag() != null)) return false;
/* 1612 */     if ((this.zeroFlag != null) && (!this.zeroFlag.equals(other.getZeroFlag()))) return false;
/* 1613 */     if ((this.getType2 == null) && (other.getGetType2() != null)) return false;
/* 1614 */     return (this.getType2 == null) || (this.getType2.equals(other.getGetType2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1621 */     return 39;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1627 */     if (strFieldName.equals("getDutyCode")) {
/* 1628 */       return 0;
/*      */     }
/* 1630 */     if (strFieldName.equals("getDutyName")) {
/* 1631 */       return 1;
/*      */     }
/* 1633 */     if (strFieldName.equals("type")) {
/* 1634 */       return 2;
/*      */     }
/* 1636 */     if (strFieldName.equals("getIntv")) {
/* 1637 */       return 3;
/*      */     }
/* 1639 */     if (strFieldName.equals("defaultVal")) {
/* 1640 */       return 4;
/*      */     }
/* 1642 */     if (strFieldName.equals("calCode")) {
/* 1643 */       return 5;
/*      */     }
/* 1645 */     if (strFieldName.equals("cnterCalCode")) {
/* 1646 */       return 6;
/*      */     }
/* 1648 */     if (strFieldName.equals("othCalCode")) {
/* 1649 */       return 7;
/*      */     }
/* 1651 */     if (strFieldName.equals("getYear")) {
/* 1652 */       return 8;
/*      */     }
/* 1654 */     if (strFieldName.equals("getYearFlag")) {
/* 1655 */       return 9;
/*      */     }
/* 1657 */     if (strFieldName.equals("startDateCalRef")) {
/* 1658 */       return 10;
/*      */     }
/* 1660 */     if (strFieldName.equals("startDateCalMode")) {
/* 1661 */       return 11;
/*      */     }
/* 1663 */     if (strFieldName.equals("minGetStartPeriod")) {
/* 1664 */       return 12;
/*      */     }
/* 1666 */     if (strFieldName.equals("getEndPeriod")) {
/* 1667 */       return 13;
/*      */     }
/* 1669 */     if (strFieldName.equals("getEndUnit")) {
/* 1670 */       return 14;
/*      */     }
/* 1672 */     if (strFieldName.equals("endDateCalRef")) {
/* 1673 */       return 15;
/*      */     }
/* 1675 */     if (strFieldName.equals("endDateCalMode")) {
/* 1676 */       return 16;
/*      */     }
/* 1678 */     if (strFieldName.equals("maxGetEndPeriod")) {
/* 1679 */       return 17;
/*      */     }
/* 1681 */     if (strFieldName.equals("addFlag")) {
/* 1682 */       return 18;
/*      */     }
/* 1684 */     if (strFieldName.equals("sexRelaFlag")) {
/* 1685 */       return 19;
/*      */     }
/* 1687 */     if (strFieldName.equals("unitAppRelaFlag")) {
/* 1688 */       return 20;
/*      */     }
/* 1690 */     if (strFieldName.equals("addAmntFlag")) {
/* 1691 */       return 21;
/*      */     }
/* 1693 */     if (strFieldName.equals("discntFlag")) {
/* 1694 */       return 22;
/*      */     }
/* 1696 */     if (strFieldName.equals("interestFlag")) {
/* 1697 */       return 23;
/*      */     }
/* 1699 */     if (strFieldName.equals("shareFlag")) {
/* 1700 */       return 24;
/*      */     }
/* 1702 */     if (strFieldName.equals("inpFlag")) {
/* 1703 */       return 25;
/*      */     }
/* 1705 */     if (strFieldName.equals("bnfFlag")) {
/* 1706 */       return 26;
/*      */     }
/* 1708 */     if (strFieldName.equals("urgeGetFlag")) {
/* 1709 */       return 27;
/*      */     }
/* 1711 */     if (strFieldName.equals("deadValiFlag")) {
/* 1712 */       return 28;
/*      */     }
/* 1714 */     if (strFieldName.equals("getInitFlag")) {
/* 1715 */       return 29;
/*      */     }
/* 1717 */     if (strFieldName.equals("getLimit")) {
/* 1718 */       return 30;
/*      */     }
/* 1720 */     if (strFieldName.equals("maxGet")) {
/* 1721 */       return 31;
/*      */     }
/* 1723 */     if (strFieldName.equals("getRate")) {
/* 1724 */       return 32;
/*      */     }
/* 1726 */     if (strFieldName.equals("needAcc")) {
/* 1727 */       return 33;
/*      */     }
/* 1729 */     if (strFieldName.equals("canGet")) {
/* 1730 */       return 34;
/*      */     }
/* 1732 */     if (strFieldName.equals("needCancelAcc")) {
/* 1733 */       return 35;
/*      */     }
/* 1735 */     if (strFieldName.equals("getType1")) {
/* 1736 */       return 36;
/*      */     }
/* 1738 */     if (strFieldName.equals("zeroFlag")) {
/* 1739 */       return 37;
/*      */     }
/* 1741 */     if (strFieldName.equals("getType2")) {
/* 1742 */       return 38;
/*      */     }
/* 1744 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1750 */     String strFieldName = "";
/* 1751 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1753 */       strFieldName = "getDutyCode";
/* 1754 */       break;
/*      */     case 1:
/* 1756 */       strFieldName = "getDutyName";
/* 1757 */       break;
/*      */     case 2:
/* 1759 */       strFieldName = "type";
/* 1760 */       break;
/*      */     case 3:
/* 1762 */       strFieldName = "getIntv";
/* 1763 */       break;
/*      */     case 4:
/* 1765 */       strFieldName = "defaultVal";
/* 1766 */       break;
/*      */     case 5:
/* 1768 */       strFieldName = "calCode";
/* 1769 */       break;
/*      */     case 6:
/* 1771 */       strFieldName = "cnterCalCode";
/* 1772 */       break;
/*      */     case 7:
/* 1774 */       strFieldName = "othCalCode";
/* 1775 */       break;
/*      */     case 8:
/* 1777 */       strFieldName = "getYear";
/* 1778 */       break;
/*      */     case 9:
/* 1780 */       strFieldName = "getYearFlag";
/* 1781 */       break;
/*      */     case 10:
/* 1783 */       strFieldName = "startDateCalRef";
/* 1784 */       break;
/*      */     case 11:
/* 1786 */       strFieldName = "startDateCalMode";
/* 1787 */       break;
/*      */     case 12:
/* 1789 */       strFieldName = "minGetStartPeriod";
/* 1790 */       break;
/*      */     case 13:
/* 1792 */       strFieldName = "getEndPeriod";
/* 1793 */       break;
/*      */     case 14:
/* 1795 */       strFieldName = "getEndUnit";
/* 1796 */       break;
/*      */     case 15:
/* 1798 */       strFieldName = "endDateCalRef";
/* 1799 */       break;
/*      */     case 16:
/* 1801 */       strFieldName = "endDateCalMode";
/* 1802 */       break;
/*      */     case 17:
/* 1804 */       strFieldName = "maxGetEndPeriod";
/* 1805 */       break;
/*      */     case 18:
/* 1807 */       strFieldName = "addFlag";
/* 1808 */       break;
/*      */     case 19:
/* 1810 */       strFieldName = "sexRelaFlag";
/* 1811 */       break;
/*      */     case 20:
/* 1813 */       strFieldName = "unitAppRelaFlag";
/* 1814 */       break;
/*      */     case 21:
/* 1816 */       strFieldName = "addAmntFlag";
/* 1817 */       break;
/*      */     case 22:
/* 1819 */       strFieldName = "discntFlag";
/* 1820 */       break;
/*      */     case 23:
/* 1822 */       strFieldName = "interestFlag";
/* 1823 */       break;
/*      */     case 24:
/* 1825 */       strFieldName = "shareFlag";
/* 1826 */       break;
/*      */     case 25:
/* 1828 */       strFieldName = "inpFlag";
/* 1829 */       break;
/*      */     case 26:
/* 1831 */       strFieldName = "bnfFlag";
/* 1832 */       break;
/*      */     case 27:
/* 1834 */       strFieldName = "urgeGetFlag";
/* 1835 */       break;
/*      */     case 28:
/* 1837 */       strFieldName = "deadValiFlag";
/* 1838 */       break;
/*      */     case 29:
/* 1840 */       strFieldName = "getInitFlag";
/* 1841 */       break;
/*      */     case 30:
/* 1843 */       strFieldName = "getLimit";
/* 1844 */       break;
/*      */     case 31:
/* 1846 */       strFieldName = "maxGet";
/* 1847 */       break;
/*      */     case 32:
/* 1849 */       strFieldName = "getRate";
/* 1850 */       break;
/*      */     case 33:
/* 1852 */       strFieldName = "needAcc";
/* 1853 */       break;
/*      */     case 34:
/* 1855 */       strFieldName = "canGet";
/* 1856 */       break;
/*      */     case 35:
/* 1858 */       strFieldName = "needCancelAcc";
/* 1859 */       break;
/*      */     case 36:
/* 1861 */       strFieldName = "getType1";
/* 1862 */       break;
/*      */     case 37:
/* 1864 */       strFieldName = "zeroFlag";
/* 1865 */       break;
/*      */     case 38:
/* 1867 */       strFieldName = "getType2";
/* 1868 */       break;
/*      */     default:
/* 1870 */       strFieldName = "";
/*      */     }
/* 1872 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1878 */     if (strFieldName.equals("getDutyCode")) {
/* 1879 */       return 0;
/*      */     }
/* 1881 */     if (strFieldName.equals("getDutyName")) {
/* 1882 */       return 0;
/*      */     }
/* 1884 */     if (strFieldName.equals("type")) {
/* 1885 */       return 0;
/*      */     }
/* 1887 */     if (strFieldName.equals("getIntv")) {
/* 1888 */       return 3;
/*      */     }
/* 1890 */     if (strFieldName.equals("defaultVal")) {
/* 1891 */       return 4;
/*      */     }
/* 1893 */     if (strFieldName.equals("calCode")) {
/* 1894 */       return 0;
/*      */     }
/* 1896 */     if (strFieldName.equals("cnterCalCode")) {
/* 1897 */       return 0;
/*      */     }
/* 1899 */     if (strFieldName.equals("othCalCode")) {
/* 1900 */       return 0;
/*      */     }
/* 1902 */     if (strFieldName.equals("getYear")) {
/* 1903 */       return 3;
/*      */     }
/* 1905 */     if (strFieldName.equals("getYearFlag")) {
/* 1906 */       return 0;
/*      */     }
/* 1908 */     if (strFieldName.equals("startDateCalRef")) {
/* 1909 */       return 0;
/*      */     }
/* 1911 */     if (strFieldName.equals("startDateCalMode")) {
/* 1912 */       return 0;
/*      */     }
/* 1914 */     if (strFieldName.equals("minGetStartPeriod")) {
/* 1915 */       return 3;
/*      */     }
/* 1917 */     if (strFieldName.equals("getEndPeriod")) {
/* 1918 */       return 3;
/*      */     }
/* 1920 */     if (strFieldName.equals("getEndUnit")) {
/* 1921 */       return 0;
/*      */     }
/* 1923 */     if (strFieldName.equals("endDateCalRef")) {
/* 1924 */       return 0;
/*      */     }
/* 1926 */     if (strFieldName.equals("endDateCalMode")) {
/* 1927 */       return 0;
/*      */     }
/* 1929 */     if (strFieldName.equals("maxGetEndPeriod")) {
/* 1930 */       return 3;
/*      */     }
/* 1932 */     if (strFieldName.equals("addFlag")) {
/* 1933 */       return 0;
/*      */     }
/* 1935 */     if (strFieldName.equals("sexRelaFlag")) {
/* 1936 */       return 0;
/*      */     }
/* 1938 */     if (strFieldName.equals("unitAppRelaFlag")) {
/* 1939 */       return 0;
/*      */     }
/* 1941 */     if (strFieldName.equals("addAmntFlag")) {
/* 1942 */       return 0;
/*      */     }
/* 1944 */     if (strFieldName.equals("discntFlag")) {
/* 1945 */       return 0;
/*      */     }
/* 1947 */     if (strFieldName.equals("interestFlag")) {
/* 1948 */       return 0;
/*      */     }
/* 1950 */     if (strFieldName.equals("shareFlag")) {
/* 1951 */       return 0;
/*      */     }
/* 1953 */     if (strFieldName.equals("inpFlag")) {
/* 1954 */       return 0;
/*      */     }
/* 1956 */     if (strFieldName.equals("bnfFlag")) {
/* 1957 */       return 0;
/*      */     }
/* 1959 */     if (strFieldName.equals("urgeGetFlag")) {
/* 1960 */       return 0;
/*      */     }
/* 1962 */     if (strFieldName.equals("deadValiFlag")) {
/* 1963 */       return 0;
/*      */     }
/* 1965 */     if (strFieldName.equals("getInitFlag")) {
/* 1966 */       return 0;
/*      */     }
/* 1968 */     if (strFieldName.equals("getLimit")) {
/* 1969 */       return 4;
/*      */     }
/* 1971 */     if (strFieldName.equals("maxGet")) {
/* 1972 */       return 4;
/*      */     }
/* 1974 */     if (strFieldName.equals("getRate")) {
/* 1975 */       return 4;
/*      */     }
/* 1977 */     if (strFieldName.equals("needAcc")) {
/* 1978 */       return 0;
/*      */     }
/* 1980 */     if (strFieldName.equals("canGet")) {
/* 1981 */       return 0;
/*      */     }
/* 1983 */     if (strFieldName.equals("needCancelAcc")) {
/* 1984 */       return 0;
/*      */     }
/* 1986 */     if (strFieldName.equals("getType1")) {
/* 1987 */       return 0;
/*      */     }
/* 1989 */     if (strFieldName.equals("zeroFlag")) {
/* 1990 */       return 0;
/*      */     }
/* 1992 */     if (strFieldName.equals("getType2")) {
/* 1993 */       return 0;
/*      */     }
/* 1995 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 2001 */     int nFieldType = -1;
/* 2002 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2004 */       nFieldType = 0;
/* 2005 */       break;
/*      */     case 1:
/* 2007 */       nFieldType = 0;
/* 2008 */       break;
/*      */     case 2:
/* 2010 */       nFieldType = 0;
/* 2011 */       break;
/*      */     case 3:
/* 2013 */       nFieldType = 3;
/* 2014 */       break;
/*      */     case 4:
/* 2016 */       nFieldType = 4;
/* 2017 */       break;
/*      */     case 5:
/* 2019 */       nFieldType = 0;
/* 2020 */       break;
/*      */     case 6:
/* 2022 */       nFieldType = 0;
/* 2023 */       break;
/*      */     case 7:
/* 2025 */       nFieldType = 0;
/* 2026 */       break;
/*      */     case 8:
/* 2028 */       nFieldType = 3;
/* 2029 */       break;
/*      */     case 9:
/* 2031 */       nFieldType = 0;
/* 2032 */       break;
/*      */     case 10:
/* 2034 */       nFieldType = 0;
/* 2035 */       break;
/*      */     case 11:
/* 2037 */       nFieldType = 0;
/* 2038 */       break;
/*      */     case 12:
/* 2040 */       nFieldType = 3;
/* 2041 */       break;
/*      */     case 13:
/* 2043 */       nFieldType = 3;
/* 2044 */       break;
/*      */     case 14:
/* 2046 */       nFieldType = 0;
/* 2047 */       break;
/*      */     case 15:
/* 2049 */       nFieldType = 0;
/* 2050 */       break;
/*      */     case 16:
/* 2052 */       nFieldType = 0;
/* 2053 */       break;
/*      */     case 17:
/* 2055 */       nFieldType = 3;
/* 2056 */       break;
/*      */     case 18:
/* 2058 */       nFieldType = 0;
/* 2059 */       break;
/*      */     case 19:
/* 2061 */       nFieldType = 0;
/* 2062 */       break;
/*      */     case 20:
/* 2064 */       nFieldType = 0;
/* 2065 */       break;
/*      */     case 21:
/* 2067 */       nFieldType = 0;
/* 2068 */       break;
/*      */     case 22:
/* 2070 */       nFieldType = 0;
/* 2071 */       break;
/*      */     case 23:
/* 2073 */       nFieldType = 0;
/* 2074 */       break;
/*      */     case 24:
/* 2076 */       nFieldType = 0;
/* 2077 */       break;
/*      */     case 25:
/* 2079 */       nFieldType = 0;
/* 2080 */       break;
/*      */     case 26:
/* 2082 */       nFieldType = 0;
/* 2083 */       break;
/*      */     case 27:
/* 2085 */       nFieldType = 0;
/* 2086 */       break;
/*      */     case 28:
/* 2088 */       nFieldType = 0;
/* 2089 */       break;
/*      */     case 29:
/* 2091 */       nFieldType = 0;
/* 2092 */       break;
/*      */     case 30:
/* 2094 */       nFieldType = 4;
/* 2095 */       break;
/*      */     case 31:
/* 2097 */       nFieldType = 4;
/* 2098 */       break;
/*      */     case 32:
/* 2100 */       nFieldType = 4;
/* 2101 */       break;
/*      */     case 33:
/* 2103 */       nFieldType = 0;
/* 2104 */       break;
/*      */     case 34:
/* 2106 */       nFieldType = 0;
/* 2107 */       break;
/*      */     case 35:
/* 2109 */       nFieldType = 0;
/* 2110 */       break;
/*      */     case 36:
/* 2112 */       nFieldType = 0;
/* 2113 */       break;
/*      */     case 37:
/* 2115 */       nFieldType = 0;
/* 2116 */       break;
/*      */     case 38:
/* 2118 */       nFieldType = 0;
/* 2119 */       break;
/*      */     default:
/* 2121 */       nFieldType = -1;
/*      */     }
/* 2123 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPDutyGetSchema
 * JD-Core Version:    0.6.0
 */