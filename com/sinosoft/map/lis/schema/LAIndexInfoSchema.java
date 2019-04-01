/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.LAIndexInfoDB;
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
/*      */ public class LAIndexInfoSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String indexCalNo;
/*      */   private String indexType;
/*      */   private String agentCode;
/*      */   private String agentGroup;
/*      */   private String manageCom;
/*      */   private Date startDate;
/*      */   private Date startEnd;
/*      */   private int quaBgnMark;
/*      */   private int serverMonths;
/*      */   private int postMonths;
/*      */   private double indMonthFYC;
/*      */   private double indMonthSYC;
/*      */   private double indMonSignFYC;
/*      */   private double indMonSignAFYC;
/*      */   private double indMonSignNAFYC;
/*      */   private double grpMonSignNAFYC;
/*      */   private double monPolCnt;
/*      */   private double montCustCnt;
/*      */   private double indMonPCount;
/*      */   private double sMmonPolContin;
/*      */   private double sMmonProduct;
/*      */   private double sMworkMon;
/*      */   private double monPCount;
/*      */   private double wSMMonPCount;
/*      */   private double lPMonForSMMP;
/*      */   private double lPMonForAMMP;
/*      */   private double lPpolContinute;
/*      */   private double monEligFLPCnt;
/*      */   private double tSRmonAFYP;
/*      */   private double tSRmonDedAFYP;
/*      */   private double tSRmonCompAFYP;
/*      */   private double tSRMonWorkDays;
/*      */   private double monManPower;
/*      */   private double monManCount;
/*      */   private double monSAFYPSum;
/*      */   private double monTLGrpSAFYPSum;
/*      */   private double indYearNAFYC;
/*      */   private double b12IndEffectAFYC;
/*      */   private double b12IndAllAFYC;
/*      */   private double b24IndEffectAFYC;
/*      */   private double b24IndAllAFYC;
/*      */   private double indQutFYC;
/*      */   private double lPproductivity;
/*      */   private double lPPPRate;
/*      */   private double lPPPBonus;
/*      */   private double lPFincSubsidy;
/*      */   private double subsidyRate;
/*      */   private double b12TeamNAFYC;
/*      */   private double sMOverride;
/*      */   private double teamMonAvgPCount;
/*      */   private double sMBasicSalary;
/*      */   private double sMproductivity;
/*      */   private double sMpolContinute;
/*      */   private double sMPPRate;
/*      */   private double sMPPBonus;
/*      */   private double b24TeamEffectAFYC;
/*      */   private double b24TeamAllAFYC;
/*      */   private double teamQutPremSum;
/*      */   private double sMRRBonus;
/*      */   private double sMManPowerDBonus;
/*      */   private double lPB12ForMPDBonus;
/*      */   private double sMUsualALLCSum;
/*      */   private double aMBasicSalary;
/*      */   private double aMproductivity;
/*      */   private double aMpolContinute;
/*      */   private double aMPPRate;
/*      */   private double aMPPBonus;
/*      */   private double b12DepNAFYC;
/*      */   private double aMOverride;
/*      */   private double depMonAvgPCount;
/*      */   private double depQutPremSum;
/*      */   private double aMRRBonus;
/*      */   private double aMManPowerDBonus;
/*      */   private double productGrowth;
/*      */   private double depQuaFYCSum;
/*      */   private double aMLiability;
/*      */   private double reviOpen;
/*      */   private double t1;
/*      */   private double t2;
/*      */   private double t3;
/*      */   private double t4;
/*      */   private double t5;
/*      */   private double t6;
/*      */   private double t7;
/*      */   private double t8;
/*      */   private double t9;
/*      */   private double t10;
/*      */   private double t11;
/*      */   private double t12;
/*      */   private double t13;
/*      */   private double t14;
/*      */   private double t15;
/*      */   private double t16;
/*      */   private double t17;
/*      */   private double t18;
/*      */   private double t20;
/*      */   private double t19;
/*      */   private double monthIndex;
/*      */   private double tMonthIndex;
/*      */   private double aSumIndex;
/*      */   private double wSMMonthEligible;
/*      */   private double lPQuaPCount;
/*      */   private double lPQuaFYCSum;
/*      */   private double b12LPPCount;
/*      */   private double b12LPNAFYCSum;
/*      */   private double wSMMonAFYC;
/*      */   private double wSMTwoMonAFYC;
/*      */   private double wSMB6AFYC;
/*      */   private double wSMB6PCount;
/*      */   private double netLiveLPCount;
/*      */   private double netComLPCount;
/*      */   private double wSMTwoMonPCount;
/*      */   private double lPAllNAFYC;
/*      */   private double lPAllPCount;
/*      */   private double monPerSAFYP;
/*      */   private double tSRThrMonSAFYP;
/*      */   private double tLThrMonPerSAFYP;
/*      */   private double monSubsistCnt;
/*      */   private double thrMonSubsistCnt;
/*      */   private String state;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String assessMonth;
/*      */   private String branchAttr;
/*      */   private String agentGrade;
/*      */   private double clubPromBonus;
/*      */   private double clubGradeBonus;
/*      */   private double clubAssisBonus;
/*      */   private double clubSpecBonus;
/*      */   private double adddedMoney;
/*      */   private double lastMoney;
/*      */   private double shouldMoney;
/*      */   private double businessTax;
/*      */   private double eduTax;
/*      */   private double buildTax;
/*      */   private double busiCharge;
/*      */   private double incomeTax;
/*      */   private double sumMoney;
/*      */   private double afterTaxMoney;
/*      */   private double operInCome;
/*      */   private double t21;
/*      */   private double t22;
/*      */   private double t23;
/*      */   private double t24;
/*      */   private double t25;
/*      */   public static final int FIELDNUM = 148;
/*      */   private static String[] PK;
/*  320 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LAIndexInfoSchema()
/*      */   {
/*  327 */     this.mErrors = new CErrors();
/*      */ 
/*  329 */     String[] pk = new String[3];
/*  330 */     pk[0] = "IndexCalNo";
/*  331 */     pk[1] = "IndexType";
/*  332 */     pk[2] = "AgentCode";
/*      */ 
/*  334 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  341 */     LAIndexInfoSchema cloned = (LAIndexInfoSchema)super.clone();
/*  342 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  343 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  344 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  350 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getIndexCalNo()
/*      */   {
/*  355 */     return this.indexCalNo;
/*      */   }
/*      */ 
/*      */   public void setIndexCalNo(String aIndexCalNo) {
/*  359 */     this.indexCalNo = aIndexCalNo;
/*      */   }
/*      */ 
/*      */   public String getIndexType() {
/*  363 */     return this.indexType;
/*      */   }
/*      */ 
/*      */   public void setIndexType(String aIndexType) {
/*  367 */     this.indexType = aIndexType;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  371 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  375 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getAgentGroup() {
/*  379 */     return this.agentGroup;
/*      */   }
/*      */ 
/*      */   public void setAgentGroup(String aAgentGroup) {
/*  383 */     this.agentGroup = aAgentGroup;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  387 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  391 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  395 */     if (this.startDate != null) {
/*  396 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  398 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  402 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  406 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  408 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  411 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartEnd()
/*      */   {
/*  416 */     if (this.startEnd != null) {
/*  417 */       return this.fDate.getString(this.startEnd);
/*      */     }
/*  419 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartEnd(Date aStartEnd) {
/*  423 */     this.startEnd = aStartEnd;
/*      */   }
/*      */ 
/*      */   public void setStartEnd(String aStartEnd) {
/*  427 */     if ((aStartEnd != null) && (!aStartEnd.equals("")))
/*      */     {
/*  429 */       this.startEnd = this.fDate.getDate(aStartEnd);
/*      */     }
/*      */     else
/*  432 */       this.startEnd = null;
/*      */   }
/*      */ 
/*      */   public int getQuaBgnMark()
/*      */   {
/*  437 */     return this.quaBgnMark;
/*      */   }
/*      */ 
/*      */   public void setQuaBgnMark(int aQuaBgnMark) {
/*  441 */     this.quaBgnMark = aQuaBgnMark;
/*      */   }
/*      */ 
/*      */   public void setQuaBgnMark(String aQuaBgnMark) {
/*  445 */     if ((aQuaBgnMark != null) && (!aQuaBgnMark.equals("")))
/*      */     {
/*  447 */       Integer tInteger = new Integer(aQuaBgnMark);
/*  448 */       int i = tInteger.intValue();
/*  449 */       this.quaBgnMark = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getServerMonths()
/*      */   {
/*  455 */     return this.serverMonths;
/*      */   }
/*      */ 
/*      */   public void setServerMonths(int aServerMonths) {
/*  459 */     this.serverMonths = aServerMonths;
/*      */   }
/*      */ 
/*      */   public void setServerMonths(String aServerMonths) {
/*  463 */     if ((aServerMonths != null) && (!aServerMonths.equals("")))
/*      */     {
/*  465 */       Integer tInteger = new Integer(aServerMonths);
/*  466 */       int i = tInteger.intValue();
/*  467 */       this.serverMonths = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getPostMonths()
/*      */   {
/*  473 */     return this.postMonths;
/*      */   }
/*      */ 
/*      */   public void setPostMonths(int aPostMonths) {
/*  477 */     this.postMonths = aPostMonths;
/*      */   }
/*      */ 
/*      */   public void setPostMonths(String aPostMonths) {
/*  481 */     if ((aPostMonths != null) && (!aPostMonths.equals("")))
/*      */     {
/*  483 */       Integer tInteger = new Integer(aPostMonths);
/*  484 */       int i = tInteger.intValue();
/*  485 */       this.postMonths = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getIndMonthFYC()
/*      */   {
/*  491 */     return this.indMonthFYC;
/*      */   }
/*      */ 
/*      */   public void setIndMonthFYC(double aIndMonthFYC) {
/*  495 */     this.indMonthFYC = aIndMonthFYC;
/*      */   }
/*      */ 
/*      */   public void setIndMonthFYC(String aIndMonthFYC) {
/*  499 */     if ((aIndMonthFYC != null) && (!aIndMonthFYC.equals("")))
/*      */     {
/*  501 */       Double tDouble = new Double(aIndMonthFYC);
/*  502 */       double d = tDouble.doubleValue();
/*  503 */       this.indMonthFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getIndMonthSYC()
/*      */   {
/*  509 */     return this.indMonthSYC;
/*      */   }
/*      */ 
/*      */   public void setIndMonthSYC(double aIndMonthSYC) {
/*  513 */     this.indMonthSYC = aIndMonthSYC;
/*      */   }
/*      */ 
/*      */   public void setIndMonthSYC(String aIndMonthSYC) {
/*  517 */     if ((aIndMonthSYC != null) && (!aIndMonthSYC.equals("")))
/*      */     {
/*  519 */       Double tDouble = new Double(aIndMonthSYC);
/*  520 */       double d = tDouble.doubleValue();
/*  521 */       this.indMonthSYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getIndMonSignFYC()
/*      */   {
/*  527 */     return this.indMonSignFYC;
/*      */   }
/*      */ 
/*      */   public void setIndMonSignFYC(double aIndMonSignFYC) {
/*  531 */     this.indMonSignFYC = aIndMonSignFYC;
/*      */   }
/*      */ 
/*      */   public void setIndMonSignFYC(String aIndMonSignFYC) {
/*  535 */     if ((aIndMonSignFYC != null) && (!aIndMonSignFYC.equals("")))
/*      */     {
/*  537 */       Double tDouble = new Double(aIndMonSignFYC);
/*  538 */       double d = tDouble.doubleValue();
/*  539 */       this.indMonSignFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getIndMonSignAFYC()
/*      */   {
/*  545 */     return this.indMonSignAFYC;
/*      */   }
/*      */ 
/*      */   public void setIndMonSignAFYC(double aIndMonSignAFYC) {
/*  549 */     this.indMonSignAFYC = aIndMonSignAFYC;
/*      */   }
/*      */ 
/*      */   public void setIndMonSignAFYC(String aIndMonSignAFYC) {
/*  553 */     if ((aIndMonSignAFYC != null) && (!aIndMonSignAFYC.equals("")))
/*      */     {
/*  555 */       Double tDouble = new Double(aIndMonSignAFYC);
/*  556 */       double d = tDouble.doubleValue();
/*  557 */       this.indMonSignAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getIndMonSignNAFYC()
/*      */   {
/*  563 */     return this.indMonSignNAFYC;
/*      */   }
/*      */ 
/*      */   public void setIndMonSignNAFYC(double aIndMonSignNAFYC) {
/*  567 */     this.indMonSignNAFYC = aIndMonSignNAFYC;
/*      */   }
/*      */ 
/*      */   public void setIndMonSignNAFYC(String aIndMonSignNAFYC) {
/*  571 */     if ((aIndMonSignNAFYC != null) && (!aIndMonSignNAFYC.equals("")))
/*      */     {
/*  573 */       Double tDouble = new Double(aIndMonSignNAFYC);
/*  574 */       double d = tDouble.doubleValue();
/*  575 */       this.indMonSignNAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getGrpMonSignNAFYC()
/*      */   {
/*  581 */     return this.grpMonSignNAFYC;
/*      */   }
/*      */ 
/*      */   public void setGrpMonSignNAFYC(double aGrpMonSignNAFYC) {
/*  585 */     this.grpMonSignNAFYC = aGrpMonSignNAFYC;
/*      */   }
/*      */ 
/*      */   public void setGrpMonSignNAFYC(String aGrpMonSignNAFYC) {
/*  589 */     if ((aGrpMonSignNAFYC != null) && (!aGrpMonSignNAFYC.equals("")))
/*      */     {
/*  591 */       Double tDouble = new Double(aGrpMonSignNAFYC);
/*  592 */       double d = tDouble.doubleValue();
/*  593 */       this.grpMonSignNAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMonPolCnt()
/*      */   {
/*  599 */     return this.monPolCnt;
/*      */   }
/*      */ 
/*      */   public void setMonPolCnt(double aMonPolCnt) {
/*  603 */     this.monPolCnt = aMonPolCnt;
/*      */   }
/*      */ 
/*      */   public void setMonPolCnt(String aMonPolCnt) {
/*  607 */     if ((aMonPolCnt != null) && (!aMonPolCnt.equals("")))
/*      */     {
/*  609 */       Double tDouble = new Double(aMonPolCnt);
/*  610 */       double d = tDouble.doubleValue();
/*  611 */       this.monPolCnt = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMontCustCnt()
/*      */   {
/*  617 */     return this.montCustCnt;
/*      */   }
/*      */ 
/*      */   public void setMontCustCnt(double aMontCustCnt) {
/*  621 */     this.montCustCnt = aMontCustCnt;
/*      */   }
/*      */ 
/*      */   public void setMontCustCnt(String aMontCustCnt) {
/*  625 */     if ((aMontCustCnt != null) && (!aMontCustCnt.equals("")))
/*      */     {
/*  627 */       Double tDouble = new Double(aMontCustCnt);
/*  628 */       double d = tDouble.doubleValue();
/*  629 */       this.montCustCnt = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getIndMonPCount()
/*      */   {
/*  635 */     return this.indMonPCount;
/*      */   }
/*      */ 
/*      */   public void setIndMonPCount(double aIndMonPCount) {
/*  639 */     this.indMonPCount = aIndMonPCount;
/*      */   }
/*      */ 
/*      */   public void setIndMonPCount(String aIndMonPCount) {
/*  643 */     if ((aIndMonPCount != null) && (!aIndMonPCount.equals("")))
/*      */     {
/*  645 */       Double tDouble = new Double(aIndMonPCount);
/*  646 */       double d = tDouble.doubleValue();
/*  647 */       this.indMonPCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMmonPolContin()
/*      */   {
/*  653 */     return this.sMmonPolContin;
/*      */   }
/*      */ 
/*      */   public void setSMmonPolContin(double aSMmonPolContin) {
/*  657 */     this.sMmonPolContin = aSMmonPolContin;
/*      */   }
/*      */ 
/*      */   public void setSMmonPolContin(String aSMmonPolContin) {
/*  661 */     if ((aSMmonPolContin != null) && (!aSMmonPolContin.equals("")))
/*      */     {
/*  663 */       Double tDouble = new Double(aSMmonPolContin);
/*  664 */       double d = tDouble.doubleValue();
/*  665 */       this.sMmonPolContin = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMmonProduct()
/*      */   {
/*  671 */     return this.sMmonProduct;
/*      */   }
/*      */ 
/*      */   public void setSMmonProduct(double aSMmonProduct) {
/*  675 */     this.sMmonProduct = aSMmonProduct;
/*      */   }
/*      */ 
/*      */   public void setSMmonProduct(String aSMmonProduct) {
/*  679 */     if ((aSMmonProduct != null) && (!aSMmonProduct.equals("")))
/*      */     {
/*  681 */       Double tDouble = new Double(aSMmonProduct);
/*  682 */       double d = tDouble.doubleValue();
/*  683 */       this.sMmonProduct = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMworkMon()
/*      */   {
/*  689 */     return this.sMworkMon;
/*      */   }
/*      */ 
/*      */   public void setSMworkMon(double aSMworkMon) {
/*  693 */     this.sMworkMon = aSMworkMon;
/*      */   }
/*      */ 
/*      */   public void setSMworkMon(String aSMworkMon) {
/*  697 */     if ((aSMworkMon != null) && (!aSMworkMon.equals("")))
/*      */     {
/*  699 */       Double tDouble = new Double(aSMworkMon);
/*  700 */       double d = tDouble.doubleValue();
/*  701 */       this.sMworkMon = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMonPCount()
/*      */   {
/*  707 */     return this.monPCount;
/*      */   }
/*      */ 
/*      */   public void setMonPCount(double aMonPCount) {
/*  711 */     this.monPCount = aMonPCount;
/*      */   }
/*      */ 
/*      */   public void setMonPCount(String aMonPCount) {
/*  715 */     if ((aMonPCount != null) && (!aMonPCount.equals("")))
/*      */     {
/*  717 */       Double tDouble = new Double(aMonPCount);
/*  718 */       double d = tDouble.doubleValue();
/*  719 */       this.monPCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getWSMMonPCount()
/*      */   {
/*  725 */     return this.wSMMonPCount;
/*      */   }
/*      */ 
/*      */   public void setWSMMonPCount(double aWSMMonPCount) {
/*  729 */     this.wSMMonPCount = aWSMMonPCount;
/*      */   }
/*      */ 
/*      */   public void setWSMMonPCount(String aWSMMonPCount) {
/*  733 */     if ((aWSMMonPCount != null) && (!aWSMMonPCount.equals("")))
/*      */     {
/*  735 */       Double tDouble = new Double(aWSMMonPCount);
/*  736 */       double d = tDouble.doubleValue();
/*  737 */       this.wSMMonPCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPMonForSMMP()
/*      */   {
/*  743 */     return this.lPMonForSMMP;
/*      */   }
/*      */ 
/*      */   public void setLPMonForSMMP(double aLPMonForSMMP) {
/*  747 */     this.lPMonForSMMP = aLPMonForSMMP;
/*      */   }
/*      */ 
/*      */   public void setLPMonForSMMP(String aLPMonForSMMP) {
/*  751 */     if ((aLPMonForSMMP != null) && (!aLPMonForSMMP.equals("")))
/*      */     {
/*  753 */       Double tDouble = new Double(aLPMonForSMMP);
/*  754 */       double d = tDouble.doubleValue();
/*  755 */       this.lPMonForSMMP = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPMonForAMMP()
/*      */   {
/*  761 */     return this.lPMonForAMMP;
/*      */   }
/*      */ 
/*      */   public void setLPMonForAMMP(double aLPMonForAMMP) {
/*  765 */     this.lPMonForAMMP = aLPMonForAMMP;
/*      */   }
/*      */ 
/*      */   public void setLPMonForAMMP(String aLPMonForAMMP) {
/*  769 */     if ((aLPMonForAMMP != null) && (!aLPMonForAMMP.equals("")))
/*      */     {
/*  771 */       Double tDouble = new Double(aLPMonForAMMP);
/*  772 */       double d = tDouble.doubleValue();
/*  773 */       this.lPMonForAMMP = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPpolContinute()
/*      */   {
/*  779 */     return this.lPpolContinute;
/*      */   }
/*      */ 
/*      */   public void setLPpolContinute(double aLPpolContinute) {
/*  783 */     this.lPpolContinute = aLPpolContinute;
/*      */   }
/*      */ 
/*      */   public void setLPpolContinute(String aLPpolContinute) {
/*  787 */     if ((aLPpolContinute != null) && (!aLPpolContinute.equals("")))
/*      */     {
/*  789 */       Double tDouble = new Double(aLPpolContinute);
/*  790 */       double d = tDouble.doubleValue();
/*  791 */       this.lPpolContinute = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMonEligFLPCnt()
/*      */   {
/*  797 */     return this.monEligFLPCnt;
/*      */   }
/*      */ 
/*      */   public void setMonEligFLPCnt(double aMonEligFLPCnt) {
/*  801 */     this.monEligFLPCnt = aMonEligFLPCnt;
/*      */   }
/*      */ 
/*      */   public void setMonEligFLPCnt(String aMonEligFLPCnt) {
/*  805 */     if ((aMonEligFLPCnt != null) && (!aMonEligFLPCnt.equals("")))
/*      */     {
/*  807 */       Double tDouble = new Double(aMonEligFLPCnt);
/*  808 */       double d = tDouble.doubleValue();
/*  809 */       this.monEligFLPCnt = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getTSRmonAFYP()
/*      */   {
/*  815 */     return this.tSRmonAFYP;
/*      */   }
/*      */ 
/*      */   public void setTSRmonAFYP(double aTSRmonAFYP) {
/*  819 */     this.tSRmonAFYP = aTSRmonAFYP;
/*      */   }
/*      */ 
/*      */   public void setTSRmonAFYP(String aTSRmonAFYP) {
/*  823 */     if ((aTSRmonAFYP != null) && (!aTSRmonAFYP.equals("")))
/*      */     {
/*  825 */       Double tDouble = new Double(aTSRmonAFYP);
/*  826 */       double d = tDouble.doubleValue();
/*  827 */       this.tSRmonAFYP = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getTSRmonDedAFYP()
/*      */   {
/*  833 */     return this.tSRmonDedAFYP;
/*      */   }
/*      */ 
/*      */   public void setTSRmonDedAFYP(double aTSRmonDedAFYP) {
/*  837 */     this.tSRmonDedAFYP = aTSRmonDedAFYP;
/*      */   }
/*      */ 
/*      */   public void setTSRmonDedAFYP(String aTSRmonDedAFYP) {
/*  841 */     if ((aTSRmonDedAFYP != null) && (!aTSRmonDedAFYP.equals("")))
/*      */     {
/*  843 */       Double tDouble = new Double(aTSRmonDedAFYP);
/*  844 */       double d = tDouble.doubleValue();
/*  845 */       this.tSRmonDedAFYP = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getTSRmonCompAFYP()
/*      */   {
/*  851 */     return this.tSRmonCompAFYP;
/*      */   }
/*      */ 
/*      */   public void setTSRmonCompAFYP(double aTSRmonCompAFYP) {
/*  855 */     this.tSRmonCompAFYP = aTSRmonCompAFYP;
/*      */   }
/*      */ 
/*      */   public void setTSRmonCompAFYP(String aTSRmonCompAFYP) {
/*  859 */     if ((aTSRmonCompAFYP != null) && (!aTSRmonCompAFYP.equals("")))
/*      */     {
/*  861 */       Double tDouble = new Double(aTSRmonCompAFYP);
/*  862 */       double d = tDouble.doubleValue();
/*  863 */       this.tSRmonCompAFYP = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getTSRMonWorkDays()
/*      */   {
/*  869 */     return this.tSRMonWorkDays;
/*      */   }
/*      */ 
/*      */   public void setTSRMonWorkDays(double aTSRMonWorkDays) {
/*  873 */     this.tSRMonWorkDays = aTSRMonWorkDays;
/*      */   }
/*      */ 
/*      */   public void setTSRMonWorkDays(String aTSRMonWorkDays) {
/*  877 */     if ((aTSRMonWorkDays != null) && (!aTSRMonWorkDays.equals("")))
/*      */     {
/*  879 */       Double tDouble = new Double(aTSRMonWorkDays);
/*  880 */       double d = tDouble.doubleValue();
/*  881 */       this.tSRMonWorkDays = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMonManPower()
/*      */   {
/*  887 */     return this.monManPower;
/*      */   }
/*      */ 
/*      */   public void setMonManPower(double aMonManPower) {
/*  891 */     this.monManPower = aMonManPower;
/*      */   }
/*      */ 
/*      */   public void setMonManPower(String aMonManPower) {
/*  895 */     if ((aMonManPower != null) && (!aMonManPower.equals("")))
/*      */     {
/*  897 */       Double tDouble = new Double(aMonManPower);
/*  898 */       double d = tDouble.doubleValue();
/*  899 */       this.monManPower = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMonManCount()
/*      */   {
/*  905 */     return this.monManCount;
/*      */   }
/*      */ 
/*      */   public void setMonManCount(double aMonManCount) {
/*  909 */     this.monManCount = aMonManCount;
/*      */   }
/*      */ 
/*      */   public void setMonManCount(String aMonManCount) {
/*  913 */     if ((aMonManCount != null) && (!aMonManCount.equals("")))
/*      */     {
/*  915 */       Double tDouble = new Double(aMonManCount);
/*  916 */       double d = tDouble.doubleValue();
/*  917 */       this.monManCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMonSAFYPSum()
/*      */   {
/*  923 */     return this.monSAFYPSum;
/*      */   }
/*      */ 
/*      */   public void setMonSAFYPSum(double aMonSAFYPSum) {
/*  927 */     this.monSAFYPSum = aMonSAFYPSum;
/*      */   }
/*      */ 
/*      */   public void setMonSAFYPSum(String aMonSAFYPSum) {
/*  931 */     if ((aMonSAFYPSum != null) && (!aMonSAFYPSum.equals("")))
/*      */     {
/*  933 */       Double tDouble = new Double(aMonSAFYPSum);
/*  934 */       double d = tDouble.doubleValue();
/*  935 */       this.monSAFYPSum = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMonTLGrpSAFYPSum()
/*      */   {
/*  941 */     return this.monTLGrpSAFYPSum;
/*      */   }
/*      */ 
/*      */   public void setMonTLGrpSAFYPSum(double aMonTLGrpSAFYPSum) {
/*  945 */     this.monTLGrpSAFYPSum = aMonTLGrpSAFYPSum;
/*      */   }
/*      */ 
/*      */   public void setMonTLGrpSAFYPSum(String aMonTLGrpSAFYPSum) {
/*  949 */     if ((aMonTLGrpSAFYPSum != null) && (!aMonTLGrpSAFYPSum.equals("")))
/*      */     {
/*  951 */       Double tDouble = new Double(aMonTLGrpSAFYPSum);
/*  952 */       double d = tDouble.doubleValue();
/*  953 */       this.monTLGrpSAFYPSum = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getIndYearNAFYC()
/*      */   {
/*  959 */     return this.indYearNAFYC;
/*      */   }
/*      */ 
/*      */   public void setIndYearNAFYC(double aIndYearNAFYC) {
/*  963 */     this.indYearNAFYC = aIndYearNAFYC;
/*      */   }
/*      */ 
/*      */   public void setIndYearNAFYC(String aIndYearNAFYC) {
/*  967 */     if ((aIndYearNAFYC != null) && (!aIndYearNAFYC.equals("")))
/*      */     {
/*  969 */       Double tDouble = new Double(aIndYearNAFYC);
/*  970 */       double d = tDouble.doubleValue();
/*  971 */       this.indYearNAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getB12IndEffectAFYC()
/*      */   {
/*  977 */     return this.b12IndEffectAFYC;
/*      */   }
/*      */ 
/*      */   public void setB12IndEffectAFYC(double aB12IndEffectAFYC) {
/*  981 */     this.b12IndEffectAFYC = aB12IndEffectAFYC;
/*      */   }
/*      */ 
/*      */   public void setB12IndEffectAFYC(String aB12IndEffectAFYC) {
/*  985 */     if ((aB12IndEffectAFYC != null) && (!aB12IndEffectAFYC.equals("")))
/*      */     {
/*  987 */       Double tDouble = new Double(aB12IndEffectAFYC);
/*  988 */       double d = tDouble.doubleValue();
/*  989 */       this.b12IndEffectAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getB12IndAllAFYC()
/*      */   {
/*  995 */     return this.b12IndAllAFYC;
/*      */   }
/*      */ 
/*      */   public void setB12IndAllAFYC(double aB12IndAllAFYC) {
/*  999 */     this.b12IndAllAFYC = aB12IndAllAFYC;
/*      */   }
/*      */ 
/*      */   public void setB12IndAllAFYC(String aB12IndAllAFYC) {
/* 1003 */     if ((aB12IndAllAFYC != null) && (!aB12IndAllAFYC.equals("")))
/*      */     {
/* 1005 */       Double tDouble = new Double(aB12IndAllAFYC);
/* 1006 */       double d = tDouble.doubleValue();
/* 1007 */       this.b12IndAllAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getB24IndEffectAFYC()
/*      */   {
/* 1013 */     return this.b24IndEffectAFYC;
/*      */   }
/*      */ 
/*      */   public void setB24IndEffectAFYC(double aB24IndEffectAFYC) {
/* 1017 */     this.b24IndEffectAFYC = aB24IndEffectAFYC;
/*      */   }
/*      */ 
/*      */   public void setB24IndEffectAFYC(String aB24IndEffectAFYC) {
/* 1021 */     if ((aB24IndEffectAFYC != null) && (!aB24IndEffectAFYC.equals("")))
/*      */     {
/* 1023 */       Double tDouble = new Double(aB24IndEffectAFYC);
/* 1024 */       double d = tDouble.doubleValue();
/* 1025 */       this.b24IndEffectAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getB24IndAllAFYC()
/*      */   {
/* 1031 */     return this.b24IndAllAFYC;
/*      */   }
/*      */ 
/*      */   public void setB24IndAllAFYC(double aB24IndAllAFYC) {
/* 1035 */     this.b24IndAllAFYC = aB24IndAllAFYC;
/*      */   }
/*      */ 
/*      */   public void setB24IndAllAFYC(String aB24IndAllAFYC) {
/* 1039 */     if ((aB24IndAllAFYC != null) && (!aB24IndAllAFYC.equals("")))
/*      */     {
/* 1041 */       Double tDouble = new Double(aB24IndAllAFYC);
/* 1042 */       double d = tDouble.doubleValue();
/* 1043 */       this.b24IndAllAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getIndQutFYC()
/*      */   {
/* 1049 */     return this.indQutFYC;
/*      */   }
/*      */ 
/*      */   public void setIndQutFYC(double aIndQutFYC) {
/* 1053 */     this.indQutFYC = aIndQutFYC;
/*      */   }
/*      */ 
/*      */   public void setIndQutFYC(String aIndQutFYC) {
/* 1057 */     if ((aIndQutFYC != null) && (!aIndQutFYC.equals("")))
/*      */     {
/* 1059 */       Double tDouble = new Double(aIndQutFYC);
/* 1060 */       double d = tDouble.doubleValue();
/* 1061 */       this.indQutFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPproductivity()
/*      */   {
/* 1067 */     return this.lPproductivity;
/*      */   }
/*      */ 
/*      */   public void setLPproductivity(double aLPproductivity) {
/* 1071 */     this.lPproductivity = aLPproductivity;
/*      */   }
/*      */ 
/*      */   public void setLPproductivity(String aLPproductivity) {
/* 1075 */     if ((aLPproductivity != null) && (!aLPproductivity.equals("")))
/*      */     {
/* 1077 */       Double tDouble = new Double(aLPproductivity);
/* 1078 */       double d = tDouble.doubleValue();
/* 1079 */       this.lPproductivity = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPPPRate()
/*      */   {
/* 1085 */     return this.lPPPRate;
/*      */   }
/*      */ 
/*      */   public void setLPPPRate(double aLPPPRate) {
/* 1089 */     this.lPPPRate = aLPPPRate;
/*      */   }
/*      */ 
/*      */   public void setLPPPRate(String aLPPPRate) {
/* 1093 */     if ((aLPPPRate != null) && (!aLPPPRate.equals("")))
/*      */     {
/* 1095 */       Double tDouble = new Double(aLPPPRate);
/* 1096 */       double d = tDouble.doubleValue();
/* 1097 */       this.lPPPRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPPPBonus()
/*      */   {
/* 1103 */     return this.lPPPBonus;
/*      */   }
/*      */ 
/*      */   public void setLPPPBonus(double aLPPPBonus) {
/* 1107 */     this.lPPPBonus = aLPPPBonus;
/*      */   }
/*      */ 
/*      */   public void setLPPPBonus(String aLPPPBonus) {
/* 1111 */     if ((aLPPPBonus != null) && (!aLPPPBonus.equals("")))
/*      */     {
/* 1113 */       Double tDouble = new Double(aLPPPBonus);
/* 1114 */       double d = tDouble.doubleValue();
/* 1115 */       this.lPPPBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPFincSubsidy()
/*      */   {
/* 1121 */     return this.lPFincSubsidy;
/*      */   }
/*      */ 
/*      */   public void setLPFincSubsidy(double aLPFincSubsidy) {
/* 1125 */     this.lPFincSubsidy = aLPFincSubsidy;
/*      */   }
/*      */ 
/*      */   public void setLPFincSubsidy(String aLPFincSubsidy) {
/* 1129 */     if ((aLPFincSubsidy != null) && (!aLPFincSubsidy.equals("")))
/*      */     {
/* 1131 */       Double tDouble = new Double(aLPFincSubsidy);
/* 1132 */       double d = tDouble.doubleValue();
/* 1133 */       this.lPFincSubsidy = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSubsidyRate()
/*      */   {
/* 1139 */     return this.subsidyRate;
/*      */   }
/*      */ 
/*      */   public void setSubsidyRate(double aSubsidyRate) {
/* 1143 */     this.subsidyRate = aSubsidyRate;
/*      */   }
/*      */ 
/*      */   public void setSubsidyRate(String aSubsidyRate) {
/* 1147 */     if ((aSubsidyRate != null) && (!aSubsidyRate.equals("")))
/*      */     {
/* 1149 */       Double tDouble = new Double(aSubsidyRate);
/* 1150 */       double d = tDouble.doubleValue();
/* 1151 */       this.subsidyRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getB12TeamNAFYC()
/*      */   {
/* 1157 */     return this.b12TeamNAFYC;
/*      */   }
/*      */ 
/*      */   public void setB12TeamNAFYC(double aB12TeamNAFYC) {
/* 1161 */     this.b12TeamNAFYC = aB12TeamNAFYC;
/*      */   }
/*      */ 
/*      */   public void setB12TeamNAFYC(String aB12TeamNAFYC) {
/* 1165 */     if ((aB12TeamNAFYC != null) && (!aB12TeamNAFYC.equals("")))
/*      */     {
/* 1167 */       Double tDouble = new Double(aB12TeamNAFYC);
/* 1168 */       double d = tDouble.doubleValue();
/* 1169 */       this.b12TeamNAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMOverride()
/*      */   {
/* 1175 */     return this.sMOverride;
/*      */   }
/*      */ 
/*      */   public void setSMOverride(double aSMOverride) {
/* 1179 */     this.sMOverride = aSMOverride;
/*      */   }
/*      */ 
/*      */   public void setSMOverride(String aSMOverride) {
/* 1183 */     if ((aSMOverride != null) && (!aSMOverride.equals("")))
/*      */     {
/* 1185 */       Double tDouble = new Double(aSMOverride);
/* 1186 */       double d = tDouble.doubleValue();
/* 1187 */       this.sMOverride = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getTeamMonAvgPCount()
/*      */   {
/* 1193 */     return this.teamMonAvgPCount;
/*      */   }
/*      */ 
/*      */   public void setTeamMonAvgPCount(double aTeamMonAvgPCount) {
/* 1197 */     this.teamMonAvgPCount = aTeamMonAvgPCount;
/*      */   }
/*      */ 
/*      */   public void setTeamMonAvgPCount(String aTeamMonAvgPCount) {
/* 1201 */     if ((aTeamMonAvgPCount != null) && (!aTeamMonAvgPCount.equals("")))
/*      */     {
/* 1203 */       Double tDouble = new Double(aTeamMonAvgPCount);
/* 1204 */       double d = tDouble.doubleValue();
/* 1205 */       this.teamMonAvgPCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMBasicSalary()
/*      */   {
/* 1211 */     return this.sMBasicSalary;
/*      */   }
/*      */ 
/*      */   public void setSMBasicSalary(double aSMBasicSalary) {
/* 1215 */     this.sMBasicSalary = aSMBasicSalary;
/*      */   }
/*      */ 
/*      */   public void setSMBasicSalary(String aSMBasicSalary) {
/* 1219 */     if ((aSMBasicSalary != null) && (!aSMBasicSalary.equals("")))
/*      */     {
/* 1221 */       Double tDouble = new Double(aSMBasicSalary);
/* 1222 */       double d = tDouble.doubleValue();
/* 1223 */       this.sMBasicSalary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMproductivity()
/*      */   {
/* 1229 */     return this.sMproductivity;
/*      */   }
/*      */ 
/*      */   public void setSMproductivity(double aSMproductivity) {
/* 1233 */     this.sMproductivity = aSMproductivity;
/*      */   }
/*      */ 
/*      */   public void setSMproductivity(String aSMproductivity) {
/* 1237 */     if ((aSMproductivity != null) && (!aSMproductivity.equals("")))
/*      */     {
/* 1239 */       Double tDouble = new Double(aSMproductivity);
/* 1240 */       double d = tDouble.doubleValue();
/* 1241 */       this.sMproductivity = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMpolContinute()
/*      */   {
/* 1247 */     return this.sMpolContinute;
/*      */   }
/*      */ 
/*      */   public void setSMpolContinute(double aSMpolContinute) {
/* 1251 */     this.sMpolContinute = aSMpolContinute;
/*      */   }
/*      */ 
/*      */   public void setSMpolContinute(String aSMpolContinute) {
/* 1255 */     if ((aSMpolContinute != null) && (!aSMpolContinute.equals("")))
/*      */     {
/* 1257 */       Double tDouble = new Double(aSMpolContinute);
/* 1258 */       double d = tDouble.doubleValue();
/* 1259 */       this.sMpolContinute = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMPPRate()
/*      */   {
/* 1265 */     return this.sMPPRate;
/*      */   }
/*      */ 
/*      */   public void setSMPPRate(double aSMPPRate) {
/* 1269 */     this.sMPPRate = aSMPPRate;
/*      */   }
/*      */ 
/*      */   public void setSMPPRate(String aSMPPRate) {
/* 1273 */     if ((aSMPPRate != null) && (!aSMPPRate.equals("")))
/*      */     {
/* 1275 */       Double tDouble = new Double(aSMPPRate);
/* 1276 */       double d = tDouble.doubleValue();
/* 1277 */       this.sMPPRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMPPBonus()
/*      */   {
/* 1283 */     return this.sMPPBonus;
/*      */   }
/*      */ 
/*      */   public void setSMPPBonus(double aSMPPBonus) {
/* 1287 */     this.sMPPBonus = aSMPPBonus;
/*      */   }
/*      */ 
/*      */   public void setSMPPBonus(String aSMPPBonus) {
/* 1291 */     if ((aSMPPBonus != null) && (!aSMPPBonus.equals("")))
/*      */     {
/* 1293 */       Double tDouble = new Double(aSMPPBonus);
/* 1294 */       double d = tDouble.doubleValue();
/* 1295 */       this.sMPPBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getB24TeamEffectAFYC()
/*      */   {
/* 1301 */     return this.b24TeamEffectAFYC;
/*      */   }
/*      */ 
/*      */   public void setB24TeamEffectAFYC(double aB24TeamEffectAFYC) {
/* 1305 */     this.b24TeamEffectAFYC = aB24TeamEffectAFYC;
/*      */   }
/*      */ 
/*      */   public void setB24TeamEffectAFYC(String aB24TeamEffectAFYC) {
/* 1309 */     if ((aB24TeamEffectAFYC != null) && (!aB24TeamEffectAFYC.equals("")))
/*      */     {
/* 1311 */       Double tDouble = new Double(aB24TeamEffectAFYC);
/* 1312 */       double d = tDouble.doubleValue();
/* 1313 */       this.b24TeamEffectAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getB24TeamAllAFYC()
/*      */   {
/* 1319 */     return this.b24TeamAllAFYC;
/*      */   }
/*      */ 
/*      */   public void setB24TeamAllAFYC(double aB24TeamAllAFYC) {
/* 1323 */     this.b24TeamAllAFYC = aB24TeamAllAFYC;
/*      */   }
/*      */ 
/*      */   public void setB24TeamAllAFYC(String aB24TeamAllAFYC) {
/* 1327 */     if ((aB24TeamAllAFYC != null) && (!aB24TeamAllAFYC.equals("")))
/*      */     {
/* 1329 */       Double tDouble = new Double(aB24TeamAllAFYC);
/* 1330 */       double d = tDouble.doubleValue();
/* 1331 */       this.b24TeamAllAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getTeamQutPremSum()
/*      */   {
/* 1337 */     return this.teamQutPremSum;
/*      */   }
/*      */ 
/*      */   public void setTeamQutPremSum(double aTeamQutPremSum) {
/* 1341 */     this.teamQutPremSum = aTeamQutPremSum;
/*      */   }
/*      */ 
/*      */   public void setTeamQutPremSum(String aTeamQutPremSum) {
/* 1345 */     if ((aTeamQutPremSum != null) && (!aTeamQutPremSum.equals("")))
/*      */     {
/* 1347 */       Double tDouble = new Double(aTeamQutPremSum);
/* 1348 */       double d = tDouble.doubleValue();
/* 1349 */       this.teamQutPremSum = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMRRBonus()
/*      */   {
/* 1355 */     return this.sMRRBonus;
/*      */   }
/*      */ 
/*      */   public void setSMRRBonus(double aSMRRBonus) {
/* 1359 */     this.sMRRBonus = aSMRRBonus;
/*      */   }
/*      */ 
/*      */   public void setSMRRBonus(String aSMRRBonus) {
/* 1363 */     if ((aSMRRBonus != null) && (!aSMRRBonus.equals("")))
/*      */     {
/* 1365 */       Double tDouble = new Double(aSMRRBonus);
/* 1366 */       double d = tDouble.doubleValue();
/* 1367 */       this.sMRRBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMManPowerDBonus()
/*      */   {
/* 1373 */     return this.sMManPowerDBonus;
/*      */   }
/*      */ 
/*      */   public void setSMManPowerDBonus(double aSMManPowerDBonus) {
/* 1377 */     this.sMManPowerDBonus = aSMManPowerDBonus;
/*      */   }
/*      */ 
/*      */   public void setSMManPowerDBonus(String aSMManPowerDBonus) {
/* 1381 */     if ((aSMManPowerDBonus != null) && (!aSMManPowerDBonus.equals("")))
/*      */     {
/* 1383 */       Double tDouble = new Double(aSMManPowerDBonus);
/* 1384 */       double d = tDouble.doubleValue();
/* 1385 */       this.sMManPowerDBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPB12ForMPDBonus()
/*      */   {
/* 1391 */     return this.lPB12ForMPDBonus;
/*      */   }
/*      */ 
/*      */   public void setLPB12ForMPDBonus(double aLPB12ForMPDBonus) {
/* 1395 */     this.lPB12ForMPDBonus = aLPB12ForMPDBonus;
/*      */   }
/*      */ 
/*      */   public void setLPB12ForMPDBonus(String aLPB12ForMPDBonus) {
/* 1399 */     if ((aLPB12ForMPDBonus != null) && (!aLPB12ForMPDBonus.equals("")))
/*      */     {
/* 1401 */       Double tDouble = new Double(aLPB12ForMPDBonus);
/* 1402 */       double d = tDouble.doubleValue();
/* 1403 */       this.lPB12ForMPDBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSMUsualALLCSum()
/*      */   {
/* 1409 */     return this.sMUsualALLCSum;
/*      */   }
/*      */ 
/*      */   public void setSMUsualALLCSum(double aSMUsualALLCSum) {
/* 1413 */     this.sMUsualALLCSum = aSMUsualALLCSum;
/*      */   }
/*      */ 
/*      */   public void setSMUsualALLCSum(String aSMUsualALLCSum) {
/* 1417 */     if ((aSMUsualALLCSum != null) && (!aSMUsualALLCSum.equals("")))
/*      */     {
/* 1419 */       Double tDouble = new Double(aSMUsualALLCSum);
/* 1420 */       double d = tDouble.doubleValue();
/* 1421 */       this.sMUsualALLCSum = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAMBasicSalary()
/*      */   {
/* 1427 */     return this.aMBasicSalary;
/*      */   }
/*      */ 
/*      */   public void setAMBasicSalary(double aAMBasicSalary) {
/* 1431 */     this.aMBasicSalary = aAMBasicSalary;
/*      */   }
/*      */ 
/*      */   public void setAMBasicSalary(String aAMBasicSalary) {
/* 1435 */     if ((aAMBasicSalary != null) && (!aAMBasicSalary.equals("")))
/*      */     {
/* 1437 */       Double tDouble = new Double(aAMBasicSalary);
/* 1438 */       double d = tDouble.doubleValue();
/* 1439 */       this.aMBasicSalary = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAMproductivity()
/*      */   {
/* 1445 */     return this.aMproductivity;
/*      */   }
/*      */ 
/*      */   public void setAMproductivity(double aAMproductivity) {
/* 1449 */     this.aMproductivity = aAMproductivity;
/*      */   }
/*      */ 
/*      */   public void setAMproductivity(String aAMproductivity) {
/* 1453 */     if ((aAMproductivity != null) && (!aAMproductivity.equals("")))
/*      */     {
/* 1455 */       Double tDouble = new Double(aAMproductivity);
/* 1456 */       double d = tDouble.doubleValue();
/* 1457 */       this.aMproductivity = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAMpolContinute()
/*      */   {
/* 1463 */     return this.aMpolContinute;
/*      */   }
/*      */ 
/*      */   public void setAMpolContinute(double aAMpolContinute) {
/* 1467 */     this.aMpolContinute = aAMpolContinute;
/*      */   }
/*      */ 
/*      */   public void setAMpolContinute(String aAMpolContinute) {
/* 1471 */     if ((aAMpolContinute != null) && (!aAMpolContinute.equals("")))
/*      */     {
/* 1473 */       Double tDouble = new Double(aAMpolContinute);
/* 1474 */       double d = tDouble.doubleValue();
/* 1475 */       this.aMpolContinute = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAMPPRate()
/*      */   {
/* 1481 */     return this.aMPPRate;
/*      */   }
/*      */ 
/*      */   public void setAMPPRate(double aAMPPRate) {
/* 1485 */     this.aMPPRate = aAMPPRate;
/*      */   }
/*      */ 
/*      */   public void setAMPPRate(String aAMPPRate) {
/* 1489 */     if ((aAMPPRate != null) && (!aAMPPRate.equals("")))
/*      */     {
/* 1491 */       Double tDouble = new Double(aAMPPRate);
/* 1492 */       double d = tDouble.doubleValue();
/* 1493 */       this.aMPPRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAMPPBonus()
/*      */   {
/* 1499 */     return this.aMPPBonus;
/*      */   }
/*      */ 
/*      */   public void setAMPPBonus(double aAMPPBonus) {
/* 1503 */     this.aMPPBonus = aAMPPBonus;
/*      */   }
/*      */ 
/*      */   public void setAMPPBonus(String aAMPPBonus) {
/* 1507 */     if ((aAMPPBonus != null) && (!aAMPPBonus.equals("")))
/*      */     {
/* 1509 */       Double tDouble = new Double(aAMPPBonus);
/* 1510 */       double d = tDouble.doubleValue();
/* 1511 */       this.aMPPBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getB12DepNAFYC()
/*      */   {
/* 1517 */     return this.b12DepNAFYC;
/*      */   }
/*      */ 
/*      */   public void setB12DepNAFYC(double aB12DepNAFYC) {
/* 1521 */     this.b12DepNAFYC = aB12DepNAFYC;
/*      */   }
/*      */ 
/*      */   public void setB12DepNAFYC(String aB12DepNAFYC) {
/* 1525 */     if ((aB12DepNAFYC != null) && (!aB12DepNAFYC.equals("")))
/*      */     {
/* 1527 */       Double tDouble = new Double(aB12DepNAFYC);
/* 1528 */       double d = tDouble.doubleValue();
/* 1529 */       this.b12DepNAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAMOverride()
/*      */   {
/* 1535 */     return this.aMOverride;
/*      */   }
/*      */ 
/*      */   public void setAMOverride(double aAMOverride) {
/* 1539 */     this.aMOverride = aAMOverride;
/*      */   }
/*      */ 
/*      */   public void setAMOverride(String aAMOverride) {
/* 1543 */     if ((aAMOverride != null) && (!aAMOverride.equals("")))
/*      */     {
/* 1545 */       Double tDouble = new Double(aAMOverride);
/* 1546 */       double d = tDouble.doubleValue();
/* 1547 */       this.aMOverride = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDepMonAvgPCount()
/*      */   {
/* 1553 */     return this.depMonAvgPCount;
/*      */   }
/*      */ 
/*      */   public void setDepMonAvgPCount(double aDepMonAvgPCount) {
/* 1557 */     this.depMonAvgPCount = aDepMonAvgPCount;
/*      */   }
/*      */ 
/*      */   public void setDepMonAvgPCount(String aDepMonAvgPCount) {
/* 1561 */     if ((aDepMonAvgPCount != null) && (!aDepMonAvgPCount.equals("")))
/*      */     {
/* 1563 */       Double tDouble = new Double(aDepMonAvgPCount);
/* 1564 */       double d = tDouble.doubleValue();
/* 1565 */       this.depMonAvgPCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDepQutPremSum()
/*      */   {
/* 1571 */     return this.depQutPremSum;
/*      */   }
/*      */ 
/*      */   public void setDepQutPremSum(double aDepQutPremSum) {
/* 1575 */     this.depQutPremSum = aDepQutPremSum;
/*      */   }
/*      */ 
/*      */   public void setDepQutPremSum(String aDepQutPremSum) {
/* 1579 */     if ((aDepQutPremSum != null) && (!aDepQutPremSum.equals("")))
/*      */     {
/* 1581 */       Double tDouble = new Double(aDepQutPremSum);
/* 1582 */       double d = tDouble.doubleValue();
/* 1583 */       this.depQutPremSum = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAMRRBonus()
/*      */   {
/* 1589 */     return this.aMRRBonus;
/*      */   }
/*      */ 
/*      */   public void setAMRRBonus(double aAMRRBonus) {
/* 1593 */     this.aMRRBonus = aAMRRBonus;
/*      */   }
/*      */ 
/*      */   public void setAMRRBonus(String aAMRRBonus) {
/* 1597 */     if ((aAMRRBonus != null) && (!aAMRRBonus.equals("")))
/*      */     {
/* 1599 */       Double tDouble = new Double(aAMRRBonus);
/* 1600 */       double d = tDouble.doubleValue();
/* 1601 */       this.aMRRBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAMManPowerDBonus()
/*      */   {
/* 1607 */     return this.aMManPowerDBonus;
/*      */   }
/*      */ 
/*      */   public void setAMManPowerDBonus(double aAMManPowerDBonus) {
/* 1611 */     this.aMManPowerDBonus = aAMManPowerDBonus;
/*      */   }
/*      */ 
/*      */   public void setAMManPowerDBonus(String aAMManPowerDBonus) {
/* 1615 */     if ((aAMManPowerDBonus != null) && (!aAMManPowerDBonus.equals("")))
/*      */     {
/* 1617 */       Double tDouble = new Double(aAMManPowerDBonus);
/* 1618 */       double d = tDouble.doubleValue();
/* 1619 */       this.aMManPowerDBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getProductGrowth()
/*      */   {
/* 1625 */     return this.productGrowth;
/*      */   }
/*      */ 
/*      */   public void setProductGrowth(double aProductGrowth) {
/* 1629 */     this.productGrowth = aProductGrowth;
/*      */   }
/*      */ 
/*      */   public void setProductGrowth(String aProductGrowth) {
/* 1633 */     if ((aProductGrowth != null) && (!aProductGrowth.equals("")))
/*      */     {
/* 1635 */       Double tDouble = new Double(aProductGrowth);
/* 1636 */       double d = tDouble.doubleValue();
/* 1637 */       this.productGrowth = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDepQuaFYCSum()
/*      */   {
/* 1643 */     return this.depQuaFYCSum;
/*      */   }
/*      */ 
/*      */   public void setDepQuaFYCSum(double aDepQuaFYCSum) {
/* 1647 */     this.depQuaFYCSum = aDepQuaFYCSum;
/*      */   }
/*      */ 
/*      */   public void setDepQuaFYCSum(String aDepQuaFYCSum) {
/* 1651 */     if ((aDepQuaFYCSum != null) && (!aDepQuaFYCSum.equals("")))
/*      */     {
/* 1653 */       Double tDouble = new Double(aDepQuaFYCSum);
/* 1654 */       double d = tDouble.doubleValue();
/* 1655 */       this.depQuaFYCSum = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAMLiability()
/*      */   {
/* 1661 */     return this.aMLiability;
/*      */   }
/*      */ 
/*      */   public void setAMLiability(double aAMLiability) {
/* 1665 */     this.aMLiability = aAMLiability;
/*      */   }
/*      */ 
/*      */   public void setAMLiability(String aAMLiability) {
/* 1669 */     if ((aAMLiability != null) && (!aAMLiability.equals("")))
/*      */     {
/* 1671 */       Double tDouble = new Double(aAMLiability);
/* 1672 */       double d = tDouble.doubleValue();
/* 1673 */       this.aMLiability = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getReviOpen()
/*      */   {
/* 1679 */     return this.reviOpen;
/*      */   }
/*      */ 
/*      */   public void setReviOpen(double aReviOpen) {
/* 1683 */     this.reviOpen = aReviOpen;
/*      */   }
/*      */ 
/*      */   public void setReviOpen(String aReviOpen) {
/* 1687 */     if ((aReviOpen != null) && (!aReviOpen.equals("")))
/*      */     {
/* 1689 */       Double tDouble = new Double(aReviOpen);
/* 1690 */       double d = tDouble.doubleValue();
/* 1691 */       this.reviOpen = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT1()
/*      */   {
/* 1697 */     return this.t1;
/*      */   }
/*      */ 
/*      */   public void setT1(double aT1) {
/* 1701 */     this.t1 = aT1;
/*      */   }
/*      */ 
/*      */   public void setT1(String aT1) {
/* 1705 */     if ((aT1 != null) && (!aT1.equals("")))
/*      */     {
/* 1707 */       Double tDouble = new Double(aT1);
/* 1708 */       double d = tDouble.doubleValue();
/* 1709 */       this.t1 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT2()
/*      */   {
/* 1715 */     return this.t2;
/*      */   }
/*      */ 
/*      */   public void setT2(double aT2) {
/* 1719 */     this.t2 = aT2;
/*      */   }
/*      */ 
/*      */   public void setT2(String aT2) {
/* 1723 */     if ((aT2 != null) && (!aT2.equals("")))
/*      */     {
/* 1725 */       Double tDouble = new Double(aT2);
/* 1726 */       double d = tDouble.doubleValue();
/* 1727 */       this.t2 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT3()
/*      */   {
/* 1733 */     return this.t3;
/*      */   }
/*      */ 
/*      */   public void setT3(double aT3) {
/* 1737 */     this.t3 = aT3;
/*      */   }
/*      */ 
/*      */   public void setT3(String aT3) {
/* 1741 */     if ((aT3 != null) && (!aT3.equals("")))
/*      */     {
/* 1743 */       Double tDouble = new Double(aT3);
/* 1744 */       double d = tDouble.doubleValue();
/* 1745 */       this.t3 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT4()
/*      */   {
/* 1751 */     return this.t4;
/*      */   }
/*      */ 
/*      */   public void setT4(double aT4) {
/* 1755 */     this.t4 = aT4;
/*      */   }
/*      */ 
/*      */   public void setT4(String aT4) {
/* 1759 */     if ((aT4 != null) && (!aT4.equals("")))
/*      */     {
/* 1761 */       Double tDouble = new Double(aT4);
/* 1762 */       double d = tDouble.doubleValue();
/* 1763 */       this.t4 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT5()
/*      */   {
/* 1769 */     return this.t5;
/*      */   }
/*      */ 
/*      */   public void setT5(double aT5) {
/* 1773 */     this.t5 = aT5;
/*      */   }
/*      */ 
/*      */   public void setT5(String aT5) {
/* 1777 */     if ((aT5 != null) && (!aT5.equals("")))
/*      */     {
/* 1779 */       Double tDouble = new Double(aT5);
/* 1780 */       double d = tDouble.doubleValue();
/* 1781 */       this.t5 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT6()
/*      */   {
/* 1787 */     return this.t6;
/*      */   }
/*      */ 
/*      */   public void setT6(double aT6) {
/* 1791 */     this.t6 = aT6;
/*      */   }
/*      */ 
/*      */   public void setT6(String aT6) {
/* 1795 */     if ((aT6 != null) && (!aT6.equals("")))
/*      */     {
/* 1797 */       Double tDouble = new Double(aT6);
/* 1798 */       double d = tDouble.doubleValue();
/* 1799 */       this.t6 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT7()
/*      */   {
/* 1805 */     return this.t7;
/*      */   }
/*      */ 
/*      */   public void setT7(double aT7) {
/* 1809 */     this.t7 = aT7;
/*      */   }
/*      */ 
/*      */   public void setT7(String aT7) {
/* 1813 */     if ((aT7 != null) && (!aT7.equals("")))
/*      */     {
/* 1815 */       Double tDouble = new Double(aT7);
/* 1816 */       double d = tDouble.doubleValue();
/* 1817 */       this.t7 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT8()
/*      */   {
/* 1823 */     return this.t8;
/*      */   }
/*      */ 
/*      */   public void setT8(double aT8) {
/* 1827 */     this.t8 = aT8;
/*      */   }
/*      */ 
/*      */   public void setT8(String aT8) {
/* 1831 */     if ((aT8 != null) && (!aT8.equals("")))
/*      */     {
/* 1833 */       Double tDouble = new Double(aT8);
/* 1834 */       double d = tDouble.doubleValue();
/* 1835 */       this.t8 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT9()
/*      */   {
/* 1841 */     return this.t9;
/*      */   }
/*      */ 
/*      */   public void setT9(double aT9) {
/* 1845 */     this.t9 = aT9;
/*      */   }
/*      */ 
/*      */   public void setT9(String aT9) {
/* 1849 */     if ((aT9 != null) && (!aT9.equals("")))
/*      */     {
/* 1851 */       Double tDouble = new Double(aT9);
/* 1852 */       double d = tDouble.doubleValue();
/* 1853 */       this.t9 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT10()
/*      */   {
/* 1859 */     return this.t10;
/*      */   }
/*      */ 
/*      */   public void setT10(double aT10) {
/* 1863 */     this.t10 = aT10;
/*      */   }
/*      */ 
/*      */   public void setT10(String aT10) {
/* 1867 */     if ((aT10 != null) && (!aT10.equals("")))
/*      */     {
/* 1869 */       Double tDouble = new Double(aT10);
/* 1870 */       double d = tDouble.doubleValue();
/* 1871 */       this.t10 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT11()
/*      */   {
/* 1877 */     return this.t11;
/*      */   }
/*      */ 
/*      */   public void setT11(double aT11) {
/* 1881 */     this.t11 = aT11;
/*      */   }
/*      */ 
/*      */   public void setT11(String aT11) {
/* 1885 */     if ((aT11 != null) && (!aT11.equals("")))
/*      */     {
/* 1887 */       Double tDouble = new Double(aT11);
/* 1888 */       double d = tDouble.doubleValue();
/* 1889 */       this.t11 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT12()
/*      */   {
/* 1895 */     return this.t12;
/*      */   }
/*      */ 
/*      */   public void setT12(double aT12) {
/* 1899 */     this.t12 = aT12;
/*      */   }
/*      */ 
/*      */   public void setT12(String aT12) {
/* 1903 */     if ((aT12 != null) && (!aT12.equals("")))
/*      */     {
/* 1905 */       Double tDouble = new Double(aT12);
/* 1906 */       double d = tDouble.doubleValue();
/* 1907 */       this.t12 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT13()
/*      */   {
/* 1913 */     return this.t13;
/*      */   }
/*      */ 
/*      */   public void setT13(double aT13) {
/* 1917 */     this.t13 = aT13;
/*      */   }
/*      */ 
/*      */   public void setT13(String aT13) {
/* 1921 */     if ((aT13 != null) && (!aT13.equals("")))
/*      */     {
/* 1923 */       Double tDouble = new Double(aT13);
/* 1924 */       double d = tDouble.doubleValue();
/* 1925 */       this.t13 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT14()
/*      */   {
/* 1931 */     return this.t14;
/*      */   }
/*      */ 
/*      */   public void setT14(double aT14) {
/* 1935 */     this.t14 = aT14;
/*      */   }
/*      */ 
/*      */   public void setT14(String aT14) {
/* 1939 */     if ((aT14 != null) && (!aT14.equals("")))
/*      */     {
/* 1941 */       Double tDouble = new Double(aT14);
/* 1942 */       double d = tDouble.doubleValue();
/* 1943 */       this.t14 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT15()
/*      */   {
/* 1949 */     return this.t15;
/*      */   }
/*      */ 
/*      */   public void setT15(double aT15) {
/* 1953 */     this.t15 = aT15;
/*      */   }
/*      */ 
/*      */   public void setT15(String aT15) {
/* 1957 */     if ((aT15 != null) && (!aT15.equals("")))
/*      */     {
/* 1959 */       Double tDouble = new Double(aT15);
/* 1960 */       double d = tDouble.doubleValue();
/* 1961 */       this.t15 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT16()
/*      */   {
/* 1967 */     return this.t16;
/*      */   }
/*      */ 
/*      */   public void setT16(double aT16) {
/* 1971 */     this.t16 = aT16;
/*      */   }
/*      */ 
/*      */   public void setT16(String aT16) {
/* 1975 */     if ((aT16 != null) && (!aT16.equals("")))
/*      */     {
/* 1977 */       Double tDouble = new Double(aT16);
/* 1978 */       double d = tDouble.doubleValue();
/* 1979 */       this.t16 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT17()
/*      */   {
/* 1985 */     return this.t17;
/*      */   }
/*      */ 
/*      */   public void setT17(double aT17) {
/* 1989 */     this.t17 = aT17;
/*      */   }
/*      */ 
/*      */   public void setT17(String aT17) {
/* 1993 */     if ((aT17 != null) && (!aT17.equals("")))
/*      */     {
/* 1995 */       Double tDouble = new Double(aT17);
/* 1996 */       double d = tDouble.doubleValue();
/* 1997 */       this.t17 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT18()
/*      */   {
/* 2003 */     return this.t18;
/*      */   }
/*      */ 
/*      */   public void setT18(double aT18) {
/* 2007 */     this.t18 = aT18;
/*      */   }
/*      */ 
/*      */   public void setT18(String aT18) {
/* 2011 */     if ((aT18 != null) && (!aT18.equals("")))
/*      */     {
/* 2013 */       Double tDouble = new Double(aT18);
/* 2014 */       double d = tDouble.doubleValue();
/* 2015 */       this.t18 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT20()
/*      */   {
/* 2021 */     return this.t20;
/*      */   }
/*      */ 
/*      */   public void setT20(double aT20) {
/* 2025 */     this.t20 = aT20;
/*      */   }
/*      */ 
/*      */   public void setT20(String aT20) {
/* 2029 */     if ((aT20 != null) && (!aT20.equals("")))
/*      */     {
/* 2031 */       Double tDouble = new Double(aT20);
/* 2032 */       double d = tDouble.doubleValue();
/* 2033 */       this.t20 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT19()
/*      */   {
/* 2039 */     return this.t19;
/*      */   }
/*      */ 
/*      */   public void setT19(double aT19) {
/* 2043 */     this.t19 = aT19;
/*      */   }
/*      */ 
/*      */   public void setT19(String aT19) {
/* 2047 */     if ((aT19 != null) && (!aT19.equals("")))
/*      */     {
/* 2049 */       Double tDouble = new Double(aT19);
/* 2050 */       double d = tDouble.doubleValue();
/* 2051 */       this.t19 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMonthIndex()
/*      */   {
/* 2057 */     return this.monthIndex;
/*      */   }
/*      */ 
/*      */   public void setMonthIndex(double aMonthIndex) {
/* 2061 */     this.monthIndex = aMonthIndex;
/*      */   }
/*      */ 
/*      */   public void setMonthIndex(String aMonthIndex) {
/* 2065 */     if ((aMonthIndex != null) && (!aMonthIndex.equals("")))
/*      */     {
/* 2067 */       Double tDouble = new Double(aMonthIndex);
/* 2068 */       double d = tDouble.doubleValue();
/* 2069 */       this.monthIndex = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getTMonthIndex()
/*      */   {
/* 2075 */     return this.tMonthIndex;
/*      */   }
/*      */ 
/*      */   public void setTMonthIndex(double aTMonthIndex) {
/* 2079 */     this.tMonthIndex = aTMonthIndex;
/*      */   }
/*      */ 
/*      */   public void setTMonthIndex(String aTMonthIndex) {
/* 2083 */     if ((aTMonthIndex != null) && (!aTMonthIndex.equals("")))
/*      */     {
/* 2085 */       Double tDouble = new Double(aTMonthIndex);
/* 2086 */       double d = tDouble.doubleValue();
/* 2087 */       this.tMonthIndex = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getASumIndex()
/*      */   {
/* 2093 */     return this.aSumIndex;
/*      */   }
/*      */ 
/*      */   public void setASumIndex(double aASumIndex) {
/* 2097 */     this.aSumIndex = aASumIndex;
/*      */   }
/*      */ 
/*      */   public void setASumIndex(String aASumIndex) {
/* 2101 */     if ((aASumIndex != null) && (!aASumIndex.equals("")))
/*      */     {
/* 2103 */       Double tDouble = new Double(aASumIndex);
/* 2104 */       double d = tDouble.doubleValue();
/* 2105 */       this.aSumIndex = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getWSMMonthEligible()
/*      */   {
/* 2111 */     return this.wSMMonthEligible;
/*      */   }
/*      */ 
/*      */   public void setWSMMonthEligible(double aWSMMonthEligible) {
/* 2115 */     this.wSMMonthEligible = aWSMMonthEligible;
/*      */   }
/*      */ 
/*      */   public void setWSMMonthEligible(String aWSMMonthEligible) {
/* 2119 */     if ((aWSMMonthEligible != null) && (!aWSMMonthEligible.equals("")))
/*      */     {
/* 2121 */       Double tDouble = new Double(aWSMMonthEligible);
/* 2122 */       double d = tDouble.doubleValue();
/* 2123 */       this.wSMMonthEligible = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPQuaPCount()
/*      */   {
/* 2129 */     return this.lPQuaPCount;
/*      */   }
/*      */ 
/*      */   public void setLPQuaPCount(double aLPQuaPCount) {
/* 2133 */     this.lPQuaPCount = aLPQuaPCount;
/*      */   }
/*      */ 
/*      */   public void setLPQuaPCount(String aLPQuaPCount) {
/* 2137 */     if ((aLPQuaPCount != null) && (!aLPQuaPCount.equals("")))
/*      */     {
/* 2139 */       Double tDouble = new Double(aLPQuaPCount);
/* 2140 */       double d = tDouble.doubleValue();
/* 2141 */       this.lPQuaPCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPQuaFYCSum()
/*      */   {
/* 2147 */     return this.lPQuaFYCSum;
/*      */   }
/*      */ 
/*      */   public void setLPQuaFYCSum(double aLPQuaFYCSum) {
/* 2151 */     this.lPQuaFYCSum = aLPQuaFYCSum;
/*      */   }
/*      */ 
/*      */   public void setLPQuaFYCSum(String aLPQuaFYCSum) {
/* 2155 */     if ((aLPQuaFYCSum != null) && (!aLPQuaFYCSum.equals("")))
/*      */     {
/* 2157 */       Double tDouble = new Double(aLPQuaFYCSum);
/* 2158 */       double d = tDouble.doubleValue();
/* 2159 */       this.lPQuaFYCSum = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getB12LPPCount()
/*      */   {
/* 2165 */     return this.b12LPPCount;
/*      */   }
/*      */ 
/*      */   public void setB12LPPCount(double aB12LPPCount) {
/* 2169 */     this.b12LPPCount = aB12LPPCount;
/*      */   }
/*      */ 
/*      */   public void setB12LPPCount(String aB12LPPCount) {
/* 2173 */     if ((aB12LPPCount != null) && (!aB12LPPCount.equals("")))
/*      */     {
/* 2175 */       Double tDouble = new Double(aB12LPPCount);
/* 2176 */       double d = tDouble.doubleValue();
/* 2177 */       this.b12LPPCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getB12LPNAFYCSum()
/*      */   {
/* 2183 */     return this.b12LPNAFYCSum;
/*      */   }
/*      */ 
/*      */   public void setB12LPNAFYCSum(double aB12LPNAFYCSum) {
/* 2187 */     this.b12LPNAFYCSum = aB12LPNAFYCSum;
/*      */   }
/*      */ 
/*      */   public void setB12LPNAFYCSum(String aB12LPNAFYCSum) {
/* 2191 */     if ((aB12LPNAFYCSum != null) && (!aB12LPNAFYCSum.equals("")))
/*      */     {
/* 2193 */       Double tDouble = new Double(aB12LPNAFYCSum);
/* 2194 */       double d = tDouble.doubleValue();
/* 2195 */       this.b12LPNAFYCSum = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getWSMMonAFYC()
/*      */   {
/* 2201 */     return this.wSMMonAFYC;
/*      */   }
/*      */ 
/*      */   public void setWSMMonAFYC(double aWSMMonAFYC) {
/* 2205 */     this.wSMMonAFYC = aWSMMonAFYC;
/*      */   }
/*      */ 
/*      */   public void setWSMMonAFYC(String aWSMMonAFYC) {
/* 2209 */     if ((aWSMMonAFYC != null) && (!aWSMMonAFYC.equals("")))
/*      */     {
/* 2211 */       Double tDouble = new Double(aWSMMonAFYC);
/* 2212 */       double d = tDouble.doubleValue();
/* 2213 */       this.wSMMonAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getWSMTwoMonAFYC()
/*      */   {
/* 2219 */     return this.wSMTwoMonAFYC;
/*      */   }
/*      */ 
/*      */   public void setWSMTwoMonAFYC(double aWSMTwoMonAFYC) {
/* 2223 */     this.wSMTwoMonAFYC = aWSMTwoMonAFYC;
/*      */   }
/*      */ 
/*      */   public void setWSMTwoMonAFYC(String aWSMTwoMonAFYC) {
/* 2227 */     if ((aWSMTwoMonAFYC != null) && (!aWSMTwoMonAFYC.equals("")))
/*      */     {
/* 2229 */       Double tDouble = new Double(aWSMTwoMonAFYC);
/* 2230 */       double d = tDouble.doubleValue();
/* 2231 */       this.wSMTwoMonAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getWSMB6AFYC()
/*      */   {
/* 2237 */     return this.wSMB6AFYC;
/*      */   }
/*      */ 
/*      */   public void setWSMB6AFYC(double aWSMB6AFYC) {
/* 2241 */     this.wSMB6AFYC = aWSMB6AFYC;
/*      */   }
/*      */ 
/*      */   public void setWSMB6AFYC(String aWSMB6AFYC) {
/* 2245 */     if ((aWSMB6AFYC != null) && (!aWSMB6AFYC.equals("")))
/*      */     {
/* 2247 */       Double tDouble = new Double(aWSMB6AFYC);
/* 2248 */       double d = tDouble.doubleValue();
/* 2249 */       this.wSMB6AFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getWSMB6PCount()
/*      */   {
/* 2255 */     return this.wSMB6PCount;
/*      */   }
/*      */ 
/*      */   public void setWSMB6PCount(double aWSMB6PCount) {
/* 2259 */     this.wSMB6PCount = aWSMB6PCount;
/*      */   }
/*      */ 
/*      */   public void setWSMB6PCount(String aWSMB6PCount) {
/* 2263 */     if ((aWSMB6PCount != null) && (!aWSMB6PCount.equals("")))
/*      */     {
/* 2265 */       Double tDouble = new Double(aWSMB6PCount);
/* 2266 */       double d = tDouble.doubleValue();
/* 2267 */       this.wSMB6PCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getNetLiveLPCount()
/*      */   {
/* 2273 */     return this.netLiveLPCount;
/*      */   }
/*      */ 
/*      */   public void setNetLiveLPCount(double aNetLiveLPCount) {
/* 2277 */     this.netLiveLPCount = aNetLiveLPCount;
/*      */   }
/*      */ 
/*      */   public void setNetLiveLPCount(String aNetLiveLPCount) {
/* 2281 */     if ((aNetLiveLPCount != null) && (!aNetLiveLPCount.equals("")))
/*      */     {
/* 2283 */       Double tDouble = new Double(aNetLiveLPCount);
/* 2284 */       double d = tDouble.doubleValue();
/* 2285 */       this.netLiveLPCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getNetComLPCount()
/*      */   {
/* 2291 */     return this.netComLPCount;
/*      */   }
/*      */ 
/*      */   public void setNetComLPCount(double aNetComLPCount) {
/* 2295 */     this.netComLPCount = aNetComLPCount;
/*      */   }
/*      */ 
/*      */   public void setNetComLPCount(String aNetComLPCount) {
/* 2299 */     if ((aNetComLPCount != null) && (!aNetComLPCount.equals("")))
/*      */     {
/* 2301 */       Double tDouble = new Double(aNetComLPCount);
/* 2302 */       double d = tDouble.doubleValue();
/* 2303 */       this.netComLPCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getWSMTwoMonPCount()
/*      */   {
/* 2309 */     return this.wSMTwoMonPCount;
/*      */   }
/*      */ 
/*      */   public void setWSMTwoMonPCount(double aWSMTwoMonPCount) {
/* 2313 */     this.wSMTwoMonPCount = aWSMTwoMonPCount;
/*      */   }
/*      */ 
/*      */   public void setWSMTwoMonPCount(String aWSMTwoMonPCount) {
/* 2317 */     if ((aWSMTwoMonPCount != null) && (!aWSMTwoMonPCount.equals("")))
/*      */     {
/* 2319 */       Double tDouble = new Double(aWSMTwoMonPCount);
/* 2320 */       double d = tDouble.doubleValue();
/* 2321 */       this.wSMTwoMonPCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPAllNAFYC()
/*      */   {
/* 2327 */     return this.lPAllNAFYC;
/*      */   }
/*      */ 
/*      */   public void setLPAllNAFYC(double aLPAllNAFYC) {
/* 2331 */     this.lPAllNAFYC = aLPAllNAFYC;
/*      */   }
/*      */ 
/*      */   public void setLPAllNAFYC(String aLPAllNAFYC) {
/* 2335 */     if ((aLPAllNAFYC != null) && (!aLPAllNAFYC.equals("")))
/*      */     {
/* 2337 */       Double tDouble = new Double(aLPAllNAFYC);
/* 2338 */       double d = tDouble.doubleValue();
/* 2339 */       this.lPAllNAFYC = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLPAllPCount()
/*      */   {
/* 2345 */     return this.lPAllPCount;
/*      */   }
/*      */ 
/*      */   public void setLPAllPCount(double aLPAllPCount) {
/* 2349 */     this.lPAllPCount = aLPAllPCount;
/*      */   }
/*      */ 
/*      */   public void setLPAllPCount(String aLPAllPCount) {
/* 2353 */     if ((aLPAllPCount != null) && (!aLPAllPCount.equals("")))
/*      */     {
/* 2355 */       Double tDouble = new Double(aLPAllPCount);
/* 2356 */       double d = tDouble.doubleValue();
/* 2357 */       this.lPAllPCount = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMonPerSAFYP()
/*      */   {
/* 2363 */     return this.monPerSAFYP;
/*      */   }
/*      */ 
/*      */   public void setMonPerSAFYP(double aMonPerSAFYP) {
/* 2367 */     this.monPerSAFYP = aMonPerSAFYP;
/*      */   }
/*      */ 
/*      */   public void setMonPerSAFYP(String aMonPerSAFYP) {
/* 2371 */     if ((aMonPerSAFYP != null) && (!aMonPerSAFYP.equals("")))
/*      */     {
/* 2373 */       Double tDouble = new Double(aMonPerSAFYP);
/* 2374 */       double d = tDouble.doubleValue();
/* 2375 */       this.monPerSAFYP = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getTSRThrMonSAFYP()
/*      */   {
/* 2381 */     return this.tSRThrMonSAFYP;
/*      */   }
/*      */ 
/*      */   public void setTSRThrMonSAFYP(double aTSRThrMonSAFYP) {
/* 2385 */     this.tSRThrMonSAFYP = aTSRThrMonSAFYP;
/*      */   }
/*      */ 
/*      */   public void setTSRThrMonSAFYP(String aTSRThrMonSAFYP) {
/* 2389 */     if ((aTSRThrMonSAFYP != null) && (!aTSRThrMonSAFYP.equals("")))
/*      */     {
/* 2391 */       Double tDouble = new Double(aTSRThrMonSAFYP);
/* 2392 */       double d = tDouble.doubleValue();
/* 2393 */       this.tSRThrMonSAFYP = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getTLThrMonPerSAFYP()
/*      */   {
/* 2399 */     return this.tLThrMonPerSAFYP;
/*      */   }
/*      */ 
/*      */   public void setTLThrMonPerSAFYP(double aTLThrMonPerSAFYP) {
/* 2403 */     this.tLThrMonPerSAFYP = aTLThrMonPerSAFYP;
/*      */   }
/*      */ 
/*      */   public void setTLThrMonPerSAFYP(String aTLThrMonPerSAFYP) {
/* 2407 */     if ((aTLThrMonPerSAFYP != null) && (!aTLThrMonPerSAFYP.equals("")))
/*      */     {
/* 2409 */       Double tDouble = new Double(aTLThrMonPerSAFYP);
/* 2410 */       double d = tDouble.doubleValue();
/* 2411 */       this.tLThrMonPerSAFYP = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getMonSubsistCnt()
/*      */   {
/* 2417 */     return this.monSubsistCnt;
/*      */   }
/*      */ 
/*      */   public void setMonSubsistCnt(double aMonSubsistCnt) {
/* 2421 */     this.monSubsistCnt = aMonSubsistCnt;
/*      */   }
/*      */ 
/*      */   public void setMonSubsistCnt(String aMonSubsistCnt) {
/* 2425 */     if ((aMonSubsistCnt != null) && (!aMonSubsistCnt.equals("")))
/*      */     {
/* 2427 */       Double tDouble = new Double(aMonSubsistCnt);
/* 2428 */       double d = tDouble.doubleValue();
/* 2429 */       this.monSubsistCnt = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getThrMonSubsistCnt()
/*      */   {
/* 2435 */     return this.thrMonSubsistCnt;
/*      */   }
/*      */ 
/*      */   public void setThrMonSubsistCnt(double aThrMonSubsistCnt) {
/* 2439 */     this.thrMonSubsistCnt = aThrMonSubsistCnt;
/*      */   }
/*      */ 
/*      */   public void setThrMonSubsistCnt(String aThrMonSubsistCnt) {
/* 2443 */     if ((aThrMonSubsistCnt != null) && (!aThrMonSubsistCnt.equals("")))
/*      */     {
/* 2445 */       Double tDouble = new Double(aThrMonSubsistCnt);
/* 2446 */       double d = tDouble.doubleValue();
/* 2447 */       this.thrMonSubsistCnt = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getState()
/*      */   {
/* 2453 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/* 2457 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/* 2461 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/* 2465 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/* 2469 */     if (this.makeDate != null) {
/* 2470 */       return this.fDate.getString(this.makeDate);
/*      */     }
/* 2472 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/* 2476 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/* 2480 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/* 2482 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/* 2485 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/* 2490 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/* 2494 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/* 2498 */     if (this.modifyDate != null) {
/* 2499 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/* 2501 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/* 2505 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/* 2509 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/* 2511 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/* 2514 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/* 2519 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/* 2523 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getAssessMonth() {
/* 2527 */     return this.assessMonth;
/*      */   }
/*      */ 
/*      */   public void setAssessMonth(String aAssessMonth) {
/* 2531 */     this.assessMonth = aAssessMonth;
/*      */   }
/*      */ 
/*      */   public String getBranchAttr() {
/* 2535 */     return this.branchAttr;
/*      */   }
/*      */ 
/*      */   public void setBranchAttr(String aBranchAttr) {
/* 2539 */     this.branchAttr = aBranchAttr;
/*      */   }
/*      */ 
/*      */   public String getAgentGrade() {
/* 2543 */     return this.agentGrade;
/*      */   }
/*      */ 
/*      */   public void setAgentGrade(String aAgentGrade) {
/* 2547 */     this.agentGrade = aAgentGrade;
/*      */   }
/*      */ 
/*      */   public double getClubPromBonus() {
/* 2551 */     return this.clubPromBonus;
/*      */   }
/*      */ 
/*      */   public void setClubPromBonus(double aClubPromBonus) {
/* 2555 */     this.clubPromBonus = aClubPromBonus;
/*      */   }
/*      */ 
/*      */   public void setClubPromBonus(String aClubPromBonus) {
/* 2559 */     if ((aClubPromBonus != null) && (!aClubPromBonus.equals("")))
/*      */     {
/* 2561 */       Double tDouble = new Double(aClubPromBonus);
/* 2562 */       double d = tDouble.doubleValue();
/* 2563 */       this.clubPromBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getClubGradeBonus()
/*      */   {
/* 2569 */     return this.clubGradeBonus;
/*      */   }
/*      */ 
/*      */   public void setClubGradeBonus(double aClubGradeBonus) {
/* 2573 */     this.clubGradeBonus = aClubGradeBonus;
/*      */   }
/*      */ 
/*      */   public void setClubGradeBonus(String aClubGradeBonus) {
/* 2577 */     if ((aClubGradeBonus != null) && (!aClubGradeBonus.equals("")))
/*      */     {
/* 2579 */       Double tDouble = new Double(aClubGradeBonus);
/* 2580 */       double d = tDouble.doubleValue();
/* 2581 */       this.clubGradeBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getClubAssisBonus()
/*      */   {
/* 2587 */     return this.clubAssisBonus;
/*      */   }
/*      */ 
/*      */   public void setClubAssisBonus(double aClubAssisBonus) {
/* 2591 */     this.clubAssisBonus = aClubAssisBonus;
/*      */   }
/*      */ 
/*      */   public void setClubAssisBonus(String aClubAssisBonus) {
/* 2595 */     if ((aClubAssisBonus != null) && (!aClubAssisBonus.equals("")))
/*      */     {
/* 2597 */       Double tDouble = new Double(aClubAssisBonus);
/* 2598 */       double d = tDouble.doubleValue();
/* 2599 */       this.clubAssisBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getClubSpecBonus()
/*      */   {
/* 2605 */     return this.clubSpecBonus;
/*      */   }
/*      */ 
/*      */   public void setClubSpecBonus(double aClubSpecBonus) {
/* 2609 */     this.clubSpecBonus = aClubSpecBonus;
/*      */   }
/*      */ 
/*      */   public void setClubSpecBonus(String aClubSpecBonus) {
/* 2613 */     if ((aClubSpecBonus != null) && (!aClubSpecBonus.equals("")))
/*      */     {
/* 2615 */       Double tDouble = new Double(aClubSpecBonus);
/* 2616 */       double d = tDouble.doubleValue();
/* 2617 */       this.clubSpecBonus = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAdddedMoney()
/*      */   {
/* 2623 */     return this.adddedMoney;
/*      */   }
/*      */ 
/*      */   public void setAdddedMoney(double aAdddedMoney) {
/* 2627 */     this.adddedMoney = aAdddedMoney;
/*      */   }
/*      */ 
/*      */   public void setAdddedMoney(String aAdddedMoney) {
/* 2631 */     if ((aAdddedMoney != null) && (!aAdddedMoney.equals("")))
/*      */     {
/* 2633 */       Double tDouble = new Double(aAdddedMoney);
/* 2634 */       double d = tDouble.doubleValue();
/* 2635 */       this.adddedMoney = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getLastMoney()
/*      */   {
/* 2641 */     return this.lastMoney;
/*      */   }
/*      */ 
/*      */   public void setLastMoney(double aLastMoney) {
/* 2645 */     this.lastMoney = aLastMoney;
/*      */   }
/*      */ 
/*      */   public void setLastMoney(String aLastMoney) {
/* 2649 */     if ((aLastMoney != null) && (!aLastMoney.equals("")))
/*      */     {
/* 2651 */       Double tDouble = new Double(aLastMoney);
/* 2652 */       double d = tDouble.doubleValue();
/* 2653 */       this.lastMoney = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getShouldMoney()
/*      */   {
/* 2659 */     return this.shouldMoney;
/*      */   }
/*      */ 
/*      */   public void setShouldMoney(double aShouldMoney) {
/* 2663 */     this.shouldMoney = aShouldMoney;
/*      */   }
/*      */ 
/*      */   public void setShouldMoney(String aShouldMoney) {
/* 2667 */     if ((aShouldMoney != null) && (!aShouldMoney.equals("")))
/*      */     {
/* 2669 */       Double tDouble = new Double(aShouldMoney);
/* 2670 */       double d = tDouble.doubleValue();
/* 2671 */       this.shouldMoney = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getBusinessTax()
/*      */   {
/* 2677 */     return this.businessTax;
/*      */   }
/*      */ 
/*      */   public void setBusinessTax(double aBusinessTax) {
/* 2681 */     this.businessTax = aBusinessTax;
/*      */   }
/*      */ 
/*      */   public void setBusinessTax(String aBusinessTax) {
/* 2685 */     if ((aBusinessTax != null) && (!aBusinessTax.equals("")))
/*      */     {
/* 2687 */       Double tDouble = new Double(aBusinessTax);
/* 2688 */       double d = tDouble.doubleValue();
/* 2689 */       this.businessTax = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getEduTax()
/*      */   {
/* 2695 */     return this.eduTax;
/*      */   }
/*      */ 
/*      */   public void setEduTax(double aEduTax) {
/* 2699 */     this.eduTax = aEduTax;
/*      */   }
/*      */ 
/*      */   public void setEduTax(String aEduTax) {
/* 2703 */     if ((aEduTax != null) && (!aEduTax.equals("")))
/*      */     {
/* 2705 */       Double tDouble = new Double(aEduTax);
/* 2706 */       double d = tDouble.doubleValue();
/* 2707 */       this.eduTax = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getBuildTax()
/*      */   {
/* 2713 */     return this.buildTax;
/*      */   }
/*      */ 
/*      */   public void setBuildTax(double aBuildTax) {
/* 2717 */     this.buildTax = aBuildTax;
/*      */   }
/*      */ 
/*      */   public void setBuildTax(String aBuildTax) {
/* 2721 */     if ((aBuildTax != null) && (!aBuildTax.equals("")))
/*      */     {
/* 2723 */       Double tDouble = new Double(aBuildTax);
/* 2724 */       double d = tDouble.doubleValue();
/* 2725 */       this.buildTax = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getBusiCharge()
/*      */   {
/* 2731 */     return this.busiCharge;
/*      */   }
/*      */ 
/*      */   public void setBusiCharge(double aBusiCharge) {
/* 2735 */     this.busiCharge = aBusiCharge;
/*      */   }
/*      */ 
/*      */   public void setBusiCharge(String aBusiCharge) {
/* 2739 */     if ((aBusiCharge != null) && (!aBusiCharge.equals("")))
/*      */     {
/* 2741 */       Double tDouble = new Double(aBusiCharge);
/* 2742 */       double d = tDouble.doubleValue();
/* 2743 */       this.busiCharge = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getIncomeTax()
/*      */   {
/* 2749 */     return this.incomeTax;
/*      */   }
/*      */ 
/*      */   public void setIncomeTax(double aIncomeTax) {
/* 2753 */     this.incomeTax = aIncomeTax;
/*      */   }
/*      */ 
/*      */   public void setIncomeTax(String aIncomeTax) {
/* 2757 */     if ((aIncomeTax != null) && (!aIncomeTax.equals("")))
/*      */     {
/* 2759 */       Double tDouble = new Double(aIncomeTax);
/* 2760 */       double d = tDouble.doubleValue();
/* 2761 */       this.incomeTax = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getSumMoney()
/*      */   {
/* 2767 */     return this.sumMoney;
/*      */   }
/*      */ 
/*      */   public void setSumMoney(double aSumMoney) {
/* 2771 */     this.sumMoney = aSumMoney;
/*      */   }
/*      */ 
/*      */   public void setSumMoney(String aSumMoney) {
/* 2775 */     if ((aSumMoney != null) && (!aSumMoney.equals("")))
/*      */     {
/* 2777 */       Double tDouble = new Double(aSumMoney);
/* 2778 */       double d = tDouble.doubleValue();
/* 2779 */       this.sumMoney = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getAfterTaxMoney()
/*      */   {
/* 2785 */     return this.afterTaxMoney;
/*      */   }
/*      */ 
/*      */   public void setAfterTaxMoney(double aAfterTaxMoney) {
/* 2789 */     this.afterTaxMoney = aAfterTaxMoney;
/*      */   }
/*      */ 
/*      */   public void setAfterTaxMoney(String aAfterTaxMoney) {
/* 2793 */     if ((aAfterTaxMoney != null) && (!aAfterTaxMoney.equals("")))
/*      */     {
/* 2795 */       Double tDouble = new Double(aAfterTaxMoney);
/* 2796 */       double d = tDouble.doubleValue();
/* 2797 */       this.afterTaxMoney = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getOperInCome()
/*      */   {
/* 2803 */     return this.operInCome;
/*      */   }
/*      */ 
/*      */   public void setOperInCome(double aOperInCome) {
/* 2807 */     this.operInCome = aOperInCome;
/*      */   }
/*      */ 
/*      */   public void setOperInCome(String aOperInCome) {
/* 2811 */     if ((aOperInCome != null) && (!aOperInCome.equals("")))
/*      */     {
/* 2813 */       Double tDouble = new Double(aOperInCome);
/* 2814 */       double d = tDouble.doubleValue();
/* 2815 */       this.operInCome = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT21()
/*      */   {
/* 2821 */     return this.t21;
/*      */   }
/*      */ 
/*      */   public void setT21(double aT21) {
/* 2825 */     this.t21 = aT21;
/*      */   }
/*      */ 
/*      */   public void setT21(String aT21) {
/* 2829 */     if ((aT21 != null) && (!aT21.equals("")))
/*      */     {
/* 2831 */       Double tDouble = new Double(aT21);
/* 2832 */       double d = tDouble.doubleValue();
/* 2833 */       this.t21 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT22()
/*      */   {
/* 2839 */     return this.t22;
/*      */   }
/*      */ 
/*      */   public void setT22(double aT22) {
/* 2843 */     this.t22 = aT22;
/*      */   }
/*      */ 
/*      */   public void setT22(String aT22) {
/* 2847 */     if ((aT22 != null) && (!aT22.equals("")))
/*      */     {
/* 2849 */       Double tDouble = new Double(aT22);
/* 2850 */       double d = tDouble.doubleValue();
/* 2851 */       this.t22 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT23()
/*      */   {
/* 2857 */     return this.t23;
/*      */   }
/*      */ 
/*      */   public void setT23(double aT23) {
/* 2861 */     this.t23 = aT23;
/*      */   }
/*      */ 
/*      */   public void setT23(String aT23) {
/* 2865 */     if ((aT23 != null) && (!aT23.equals("")))
/*      */     {
/* 2867 */       Double tDouble = new Double(aT23);
/* 2868 */       double d = tDouble.doubleValue();
/* 2869 */       this.t23 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT24()
/*      */   {
/* 2875 */     return this.t24;
/*      */   }
/*      */ 
/*      */   public void setT24(double aT24) {
/* 2879 */     this.t24 = aT24;
/*      */   }
/*      */ 
/*      */   public void setT24(String aT24) {
/* 2883 */     if ((aT24 != null) && (!aT24.equals("")))
/*      */     {
/* 2885 */       Double tDouble = new Double(aT24);
/* 2886 */       double d = tDouble.doubleValue();
/* 2887 */       this.t24 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT25()
/*      */   {
/* 2893 */     return this.t25;
/*      */   }
/*      */ 
/*      */   public void setT25(double aT25) {
/* 2897 */     this.t25 = aT25;
/*      */   }
/*      */ 
/*      */   public void setT25(String aT25) {
/* 2901 */     if ((aT25 != null) && (!aT25.equals("")))
/*      */     {
/* 2903 */       Double tDouble = new Double(aT25);
/* 2904 */       double d = tDouble.doubleValue();
/* 2905 */       this.t25 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public void setSchema(LAIndexInfoSchema aLAIndexInfoSchema)
/*      */   {
/* 2913 */     this.indexCalNo = aLAIndexInfoSchema.getIndexCalNo();
/* 2914 */     this.indexType = aLAIndexInfoSchema.getIndexType();
/* 2915 */     this.agentCode = aLAIndexInfoSchema.getAgentCode();
/* 2916 */     this.agentGroup = aLAIndexInfoSchema.getAgentGroup();
/* 2917 */     this.manageCom = aLAIndexInfoSchema.getManageCom();
/* 2918 */     this.startDate = this.fDate.getDate(aLAIndexInfoSchema.getStartDate());
/* 2919 */     this.startEnd = this.fDate.getDate(aLAIndexInfoSchema.getStartEnd());
/* 2920 */     this.quaBgnMark = aLAIndexInfoSchema.getQuaBgnMark();
/* 2921 */     this.serverMonths = aLAIndexInfoSchema.getServerMonths();
/* 2922 */     this.postMonths = aLAIndexInfoSchema.getPostMonths();
/* 2923 */     this.indMonthFYC = aLAIndexInfoSchema.getIndMonthFYC();
/* 2924 */     this.indMonthSYC = aLAIndexInfoSchema.getIndMonthSYC();
/* 2925 */     this.indMonSignFYC = aLAIndexInfoSchema.getIndMonSignFYC();
/* 2926 */     this.indMonSignAFYC = aLAIndexInfoSchema.getIndMonSignAFYC();
/* 2927 */     this.indMonSignNAFYC = aLAIndexInfoSchema.getIndMonSignNAFYC();
/* 2928 */     this.grpMonSignNAFYC = aLAIndexInfoSchema.getGrpMonSignNAFYC();
/* 2929 */     this.monPolCnt = aLAIndexInfoSchema.getMonPolCnt();
/* 2930 */     this.montCustCnt = aLAIndexInfoSchema.getMontCustCnt();
/* 2931 */     this.indMonPCount = aLAIndexInfoSchema.getIndMonPCount();
/* 2932 */     this.sMmonPolContin = aLAIndexInfoSchema.getSMmonPolContin();
/* 2933 */     this.sMmonProduct = aLAIndexInfoSchema.getSMmonProduct();
/* 2934 */     this.sMworkMon = aLAIndexInfoSchema.getSMworkMon();
/* 2935 */     this.monPCount = aLAIndexInfoSchema.getMonPCount();
/* 2936 */     this.wSMMonPCount = aLAIndexInfoSchema.getWSMMonPCount();
/* 2937 */     this.lPMonForSMMP = aLAIndexInfoSchema.getLPMonForSMMP();
/* 2938 */     this.lPMonForAMMP = aLAIndexInfoSchema.getLPMonForAMMP();
/* 2939 */     this.lPpolContinute = aLAIndexInfoSchema.getLPpolContinute();
/* 2940 */     this.monEligFLPCnt = aLAIndexInfoSchema.getMonEligFLPCnt();
/* 2941 */     this.tSRmonAFYP = aLAIndexInfoSchema.getTSRmonAFYP();
/* 2942 */     this.tSRmonDedAFYP = aLAIndexInfoSchema.getTSRmonDedAFYP();
/* 2943 */     this.tSRmonCompAFYP = aLAIndexInfoSchema.getTSRmonCompAFYP();
/* 2944 */     this.tSRMonWorkDays = aLAIndexInfoSchema.getTSRMonWorkDays();
/* 2945 */     this.monManPower = aLAIndexInfoSchema.getMonManPower();
/* 2946 */     this.monManCount = aLAIndexInfoSchema.getMonManCount();
/* 2947 */     this.monSAFYPSum = aLAIndexInfoSchema.getMonSAFYPSum();
/* 2948 */     this.monTLGrpSAFYPSum = aLAIndexInfoSchema.getMonTLGrpSAFYPSum();
/* 2949 */     this.indYearNAFYC = aLAIndexInfoSchema.getIndYearNAFYC();
/* 2950 */     this.b12IndEffectAFYC = aLAIndexInfoSchema.getB12IndEffectAFYC();
/* 2951 */     this.b12IndAllAFYC = aLAIndexInfoSchema.getB12IndAllAFYC();
/* 2952 */     this.b24IndEffectAFYC = aLAIndexInfoSchema.getB24IndEffectAFYC();
/* 2953 */     this.b24IndAllAFYC = aLAIndexInfoSchema.getB24IndAllAFYC();
/* 2954 */     this.indQutFYC = aLAIndexInfoSchema.getIndQutFYC();
/* 2955 */     this.lPproductivity = aLAIndexInfoSchema.getLPproductivity();
/* 2956 */     this.lPPPRate = aLAIndexInfoSchema.getLPPPRate();
/* 2957 */     this.lPPPBonus = aLAIndexInfoSchema.getLPPPBonus();
/* 2958 */     this.lPFincSubsidy = aLAIndexInfoSchema.getLPFincSubsidy();
/* 2959 */     this.subsidyRate = aLAIndexInfoSchema.getSubsidyRate();
/* 2960 */     this.b12TeamNAFYC = aLAIndexInfoSchema.getB12TeamNAFYC();
/* 2961 */     this.sMOverride = aLAIndexInfoSchema.getSMOverride();
/* 2962 */     this.teamMonAvgPCount = aLAIndexInfoSchema.getTeamMonAvgPCount();
/* 2963 */     this.sMBasicSalary = aLAIndexInfoSchema.getSMBasicSalary();
/* 2964 */     this.sMproductivity = aLAIndexInfoSchema.getSMproductivity();
/* 2965 */     this.sMpolContinute = aLAIndexInfoSchema.getSMpolContinute();
/* 2966 */     this.sMPPRate = aLAIndexInfoSchema.getSMPPRate();
/* 2967 */     this.sMPPBonus = aLAIndexInfoSchema.getSMPPBonus();
/* 2968 */     this.b24TeamEffectAFYC = aLAIndexInfoSchema.getB24TeamEffectAFYC();
/* 2969 */     this.b24TeamAllAFYC = aLAIndexInfoSchema.getB24TeamAllAFYC();
/* 2970 */     this.teamQutPremSum = aLAIndexInfoSchema.getTeamQutPremSum();
/* 2971 */     this.sMRRBonus = aLAIndexInfoSchema.getSMRRBonus();
/* 2972 */     this.sMManPowerDBonus = aLAIndexInfoSchema.getSMManPowerDBonus();
/* 2973 */     this.lPB12ForMPDBonus = aLAIndexInfoSchema.getLPB12ForMPDBonus();
/* 2974 */     this.sMUsualALLCSum = aLAIndexInfoSchema.getSMUsualALLCSum();
/* 2975 */     this.aMBasicSalary = aLAIndexInfoSchema.getAMBasicSalary();
/* 2976 */     this.aMproductivity = aLAIndexInfoSchema.getAMproductivity();
/* 2977 */     this.aMpolContinute = aLAIndexInfoSchema.getAMpolContinute();
/* 2978 */     this.aMPPRate = aLAIndexInfoSchema.getAMPPRate();
/* 2979 */     this.aMPPBonus = aLAIndexInfoSchema.getAMPPBonus();
/* 2980 */     this.b12DepNAFYC = aLAIndexInfoSchema.getB12DepNAFYC();
/* 2981 */     this.aMOverride = aLAIndexInfoSchema.getAMOverride();
/* 2982 */     this.depMonAvgPCount = aLAIndexInfoSchema.getDepMonAvgPCount();
/* 2983 */     this.depQutPremSum = aLAIndexInfoSchema.getDepQutPremSum();
/* 2984 */     this.aMRRBonus = aLAIndexInfoSchema.getAMRRBonus();
/* 2985 */     this.aMManPowerDBonus = aLAIndexInfoSchema.getAMManPowerDBonus();
/* 2986 */     this.productGrowth = aLAIndexInfoSchema.getProductGrowth();
/* 2987 */     this.depQuaFYCSum = aLAIndexInfoSchema.getDepQuaFYCSum();
/* 2988 */     this.aMLiability = aLAIndexInfoSchema.getAMLiability();
/* 2989 */     this.reviOpen = aLAIndexInfoSchema.getReviOpen();
/* 2990 */     this.t1 = aLAIndexInfoSchema.getT1();
/* 2991 */     this.t2 = aLAIndexInfoSchema.getT2();
/* 2992 */     this.t3 = aLAIndexInfoSchema.getT3();
/* 2993 */     this.t4 = aLAIndexInfoSchema.getT4();
/* 2994 */     this.t5 = aLAIndexInfoSchema.getT5();
/* 2995 */     this.t6 = aLAIndexInfoSchema.getT6();
/* 2996 */     this.t7 = aLAIndexInfoSchema.getT7();
/* 2997 */     this.t8 = aLAIndexInfoSchema.getT8();
/* 2998 */     this.t9 = aLAIndexInfoSchema.getT9();
/* 2999 */     this.t10 = aLAIndexInfoSchema.getT10();
/* 3000 */     this.t11 = aLAIndexInfoSchema.getT11();
/* 3001 */     this.t12 = aLAIndexInfoSchema.getT12();
/* 3002 */     this.t13 = aLAIndexInfoSchema.getT13();
/* 3003 */     this.t14 = aLAIndexInfoSchema.getT14();
/* 3004 */     this.t15 = aLAIndexInfoSchema.getT15();
/* 3005 */     this.t16 = aLAIndexInfoSchema.getT16();
/* 3006 */     this.t17 = aLAIndexInfoSchema.getT17();
/* 3007 */     this.t18 = aLAIndexInfoSchema.getT18();
/* 3008 */     this.t20 = aLAIndexInfoSchema.getT20();
/* 3009 */     this.t19 = aLAIndexInfoSchema.getT19();
/* 3010 */     this.monthIndex = aLAIndexInfoSchema.getMonthIndex();
/* 3011 */     this.tMonthIndex = aLAIndexInfoSchema.getTMonthIndex();
/* 3012 */     this.aSumIndex = aLAIndexInfoSchema.getASumIndex();
/* 3013 */     this.wSMMonthEligible = aLAIndexInfoSchema.getWSMMonthEligible();
/* 3014 */     this.lPQuaPCount = aLAIndexInfoSchema.getLPQuaPCount();
/* 3015 */     this.lPQuaFYCSum = aLAIndexInfoSchema.getLPQuaFYCSum();
/* 3016 */     this.b12LPPCount = aLAIndexInfoSchema.getB12LPPCount();
/* 3017 */     this.b12LPNAFYCSum = aLAIndexInfoSchema.getB12LPNAFYCSum();
/* 3018 */     this.wSMMonAFYC = aLAIndexInfoSchema.getWSMMonAFYC();
/* 3019 */     this.wSMTwoMonAFYC = aLAIndexInfoSchema.getWSMTwoMonAFYC();
/* 3020 */     this.wSMB6AFYC = aLAIndexInfoSchema.getWSMB6AFYC();
/* 3021 */     this.wSMB6PCount = aLAIndexInfoSchema.getWSMB6PCount();
/* 3022 */     this.netLiveLPCount = aLAIndexInfoSchema.getNetLiveLPCount();
/* 3023 */     this.netComLPCount = aLAIndexInfoSchema.getNetComLPCount();
/* 3024 */     this.wSMTwoMonPCount = aLAIndexInfoSchema.getWSMTwoMonPCount();
/* 3025 */     this.lPAllNAFYC = aLAIndexInfoSchema.getLPAllNAFYC();
/* 3026 */     this.lPAllPCount = aLAIndexInfoSchema.getLPAllPCount();
/* 3027 */     this.monPerSAFYP = aLAIndexInfoSchema.getMonPerSAFYP();
/* 3028 */     this.tSRThrMonSAFYP = aLAIndexInfoSchema.getTSRThrMonSAFYP();
/* 3029 */     this.tLThrMonPerSAFYP = aLAIndexInfoSchema.getTLThrMonPerSAFYP();
/* 3030 */     this.monSubsistCnt = aLAIndexInfoSchema.getMonSubsistCnt();
/* 3031 */     this.thrMonSubsistCnt = aLAIndexInfoSchema.getThrMonSubsistCnt();
/* 3032 */     this.state = aLAIndexInfoSchema.getState();
/* 3033 */     this.operator = aLAIndexInfoSchema.getOperator();
/* 3034 */     this.makeDate = this.fDate.getDate(aLAIndexInfoSchema.getMakeDate());
/* 3035 */     this.makeTime = aLAIndexInfoSchema.getMakeTime();
/* 3036 */     this.modifyDate = this.fDate.getDate(aLAIndexInfoSchema.getModifyDate());
/* 3037 */     this.modifyTime = aLAIndexInfoSchema.getModifyTime();
/* 3038 */     this.assessMonth = aLAIndexInfoSchema.getAssessMonth();
/* 3039 */     this.branchAttr = aLAIndexInfoSchema.getBranchAttr();
/* 3040 */     this.agentGrade = aLAIndexInfoSchema.getAgentGrade();
/* 3041 */     this.clubPromBonus = aLAIndexInfoSchema.getClubPromBonus();
/* 3042 */     this.clubGradeBonus = aLAIndexInfoSchema.getClubGradeBonus();
/* 3043 */     this.clubAssisBonus = aLAIndexInfoSchema.getClubAssisBonus();
/* 3044 */     this.clubSpecBonus = aLAIndexInfoSchema.getClubSpecBonus();
/* 3045 */     this.adddedMoney = aLAIndexInfoSchema.getAdddedMoney();
/* 3046 */     this.lastMoney = aLAIndexInfoSchema.getLastMoney();
/* 3047 */     this.shouldMoney = aLAIndexInfoSchema.getShouldMoney();
/* 3048 */     this.businessTax = aLAIndexInfoSchema.getBusinessTax();
/* 3049 */     this.eduTax = aLAIndexInfoSchema.getEduTax();
/* 3050 */     this.buildTax = aLAIndexInfoSchema.getBuildTax();
/* 3051 */     this.busiCharge = aLAIndexInfoSchema.getBusiCharge();
/* 3052 */     this.incomeTax = aLAIndexInfoSchema.getIncomeTax();
/* 3053 */     this.sumMoney = aLAIndexInfoSchema.getSumMoney();
/* 3054 */     this.afterTaxMoney = aLAIndexInfoSchema.getAfterTaxMoney();
/* 3055 */     this.operInCome = aLAIndexInfoSchema.getOperInCome();
/* 3056 */     this.t21 = aLAIndexInfoSchema.getT21();
/* 3057 */     this.t22 = aLAIndexInfoSchema.getT22();
/* 3058 */     this.t23 = aLAIndexInfoSchema.getT23();
/* 3059 */     this.t24 = aLAIndexInfoSchema.getT24();
/* 3060 */     this.t25 = aLAIndexInfoSchema.getT25();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/* 3069 */       if (rs.getString("IndexCalNo") == null)
/* 3070 */         this.indexCalNo = null;
/*      */       else {
/* 3072 */         this.indexCalNo = rs.getString("IndexCalNo").trim();
/*      */       }
/* 3074 */       if (rs.getString("IndexType") == null)
/* 3075 */         this.indexType = null;
/*      */       else {
/* 3077 */         this.indexType = rs.getString("IndexType").trim();
/*      */       }
/* 3079 */       if (rs.getString("AgentCode") == null)
/* 3080 */         this.agentCode = null;
/*      */       else {
/* 3082 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/* 3084 */       if (rs.getString("AgentGroup") == null)
/* 3085 */         this.agentGroup = null;
/*      */       else {
/* 3087 */         this.agentGroup = rs.getString("AgentGroup").trim();
/*      */       }
/* 3089 */       if (rs.getString("ManageCom") == null)
/* 3090 */         this.manageCom = null;
/*      */       else {
/* 3092 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/* 3094 */       this.startDate = rs.getDate("StartDate");
/* 3095 */       this.startEnd = rs.getDate("StartEnd");
/* 3096 */       this.quaBgnMark = rs.getInt("QuaBgnMark");
/* 3097 */       this.serverMonths = rs.getInt("ServerMonths");
/* 3098 */       this.postMonths = rs.getInt("PostMonths");
/* 3099 */       this.indMonthFYC = rs.getDouble("IndMonthFYC");
/* 3100 */       this.indMonthSYC = rs.getDouble("IndMonthSYC");
/* 3101 */       this.indMonSignFYC = rs.getDouble("IndMonSignFYC");
/* 3102 */       this.indMonSignAFYC = rs.getDouble("IndMonSignAFYC");
/* 3103 */       this.indMonSignNAFYC = rs.getDouble("IndMonSignNAFYC");
/* 3104 */       this.grpMonSignNAFYC = rs.getDouble("GrpMonSignNAFYC");
/* 3105 */       this.monPolCnt = rs.getDouble("MonPolCnt");
/* 3106 */       this.montCustCnt = rs.getDouble("MontCustCnt");
/* 3107 */       this.indMonPCount = rs.getDouble("IndMonPCount");
/* 3108 */       this.sMmonPolContin = rs.getDouble("SMmonPolContin");
/* 3109 */       this.sMmonProduct = rs.getDouble("SMmonProduct");
/* 3110 */       this.sMworkMon = rs.getDouble("SMworkMon");
/* 3111 */       this.monPCount = rs.getDouble("MonPCount");
/* 3112 */       this.wSMMonPCount = rs.getDouble("WSMMonPCount");
/* 3113 */       this.lPMonForSMMP = rs.getDouble("LPMonForSMMP");
/* 3114 */       this.lPMonForAMMP = rs.getDouble("LPMonForAMMP");
/* 3115 */       this.lPpolContinute = rs.getDouble("LPpolContinute");
/* 3116 */       this.monEligFLPCnt = rs.getDouble("MonEligFLPCnt");
/* 3117 */       this.tSRmonAFYP = rs.getDouble("TSRmonAFYP");
/* 3118 */       this.tSRmonDedAFYP = rs.getDouble("TSRmonDedAFYP");
/* 3119 */       this.tSRmonCompAFYP = rs.getDouble("TSRmonCompAFYP");
/* 3120 */       this.tSRMonWorkDays = rs.getDouble("TSRMonWorkDays");
/* 3121 */       this.monManPower = rs.getDouble("MonManPower");
/* 3122 */       this.monManCount = rs.getDouble("MonManCount");
/* 3123 */       this.monSAFYPSum = rs.getDouble("MonSAFYPSum");
/* 3124 */       this.monTLGrpSAFYPSum = rs.getDouble("MonTLGrpSAFYPSum");
/* 3125 */       this.indYearNAFYC = rs.getDouble("IndYearNAFYC");
/* 3126 */       this.b12IndEffectAFYC = rs.getDouble("B12IndEffectAFYC");
/* 3127 */       this.b12IndAllAFYC = rs.getDouble("B12IndAllAFYC");
/* 3128 */       this.b24IndEffectAFYC = rs.getDouble("B24IndEffectAFYC");
/* 3129 */       this.b24IndAllAFYC = rs.getDouble("B24IndAllAFYC");
/* 3130 */       this.indQutFYC = rs.getDouble("IndQutFYC");
/* 3131 */       this.lPproductivity = rs.getDouble("LPproductivity");
/* 3132 */       this.lPPPRate = rs.getDouble("LPPPRate");
/* 3133 */       this.lPPPBonus = rs.getDouble("LPPPBonus");
/* 3134 */       this.lPFincSubsidy = rs.getDouble("LPFincSubsidy");
/* 3135 */       this.subsidyRate = rs.getDouble("SubsidyRate");
/* 3136 */       this.b12TeamNAFYC = rs.getDouble("B12TeamNAFYC");
/* 3137 */       this.sMOverride = rs.getDouble("SMOverride");
/* 3138 */       this.teamMonAvgPCount = rs.getDouble("TeamMonAvgPCount");
/* 3139 */       this.sMBasicSalary = rs.getDouble("SMBasicSalary");
/* 3140 */       this.sMproductivity = rs.getDouble("SMproductivity");
/* 3141 */       this.sMpolContinute = rs.getDouble("SMpolContinute");
/* 3142 */       this.sMPPRate = rs.getDouble("SMPPRate");
/* 3143 */       this.sMPPBonus = rs.getDouble("SMPPBonus");
/* 3144 */       this.b24TeamEffectAFYC = rs.getDouble("B24TeamEffectAFYC");
/* 3145 */       this.b24TeamAllAFYC = rs.getDouble("B24TeamAllAFYC");
/* 3146 */       this.teamQutPremSum = rs.getDouble("TeamQutPremSum");
/* 3147 */       this.sMRRBonus = rs.getDouble("SMRRBonus");
/* 3148 */       this.sMManPowerDBonus = rs.getDouble("SMManPowerDBonus");
/* 3149 */       this.lPB12ForMPDBonus = rs.getDouble("LPB12ForMPDBonus");
/* 3150 */       this.sMUsualALLCSum = rs.getDouble("SMUsualALLCSum");
/* 3151 */       this.aMBasicSalary = rs.getDouble("AMBasicSalary");
/* 3152 */       this.aMproductivity = rs.getDouble("AMproductivity");
/* 3153 */       this.aMpolContinute = rs.getDouble("AMpolContinute");
/* 3154 */       this.aMPPRate = rs.getDouble("AMPPRate");
/* 3155 */       this.aMPPBonus = rs.getDouble("AMPPBonus");
/* 3156 */       this.b12DepNAFYC = rs.getDouble("B12DepNAFYC");
/* 3157 */       this.aMOverride = rs.getDouble("AMOverride");
/* 3158 */       this.depMonAvgPCount = rs.getDouble("DepMonAvgPCount");
/* 3159 */       this.depQutPremSum = rs.getDouble("DepQutPremSum");
/* 3160 */       this.aMRRBonus = rs.getDouble("AMRRBonus");
/* 3161 */       this.aMManPowerDBonus = rs.getDouble("AMManPowerDBonus");
/* 3162 */       this.productGrowth = rs.getDouble("ProductGrowth");
/* 3163 */       this.depQuaFYCSum = rs.getDouble("DepQuaFYCSum");
/* 3164 */       this.aMLiability = rs.getDouble("AMLiability");
/* 3165 */       this.reviOpen = rs.getDouble("ReviOpen");
/* 3166 */       this.t1 = rs.getDouble("T1");
/* 3167 */       this.t2 = rs.getDouble("T2");
/* 3168 */       this.t3 = rs.getDouble("T3");
/* 3169 */       this.t4 = rs.getDouble("T4");
/* 3170 */       this.t5 = rs.getDouble("T5");
/* 3171 */       this.t6 = rs.getDouble("T6");
/* 3172 */       this.t7 = rs.getDouble("T7");
/* 3173 */       this.t8 = rs.getDouble("T8");
/* 3174 */       this.t9 = rs.getDouble("T9");
/* 3175 */       this.t10 = rs.getDouble("T10");
/* 3176 */       this.t11 = rs.getDouble("T11");
/* 3177 */       this.t12 = rs.getDouble("T12");
/* 3178 */       this.t13 = rs.getDouble("T13");
/* 3179 */       this.t14 = rs.getDouble("T14");
/* 3180 */       this.t15 = rs.getDouble("T15");
/* 3181 */       this.t16 = rs.getDouble("T16");
/* 3182 */       this.t17 = rs.getDouble("T17");
/* 3183 */       this.t18 = rs.getDouble("T18");
/* 3184 */       this.t20 = rs.getDouble("T20");
/* 3185 */       this.t19 = rs.getDouble("T19");
/* 3186 */       this.monthIndex = rs.getDouble("MonthIndex");
/* 3187 */       this.tMonthIndex = rs.getDouble("TMonthIndex");
/* 3188 */       this.aSumIndex = rs.getDouble("ASumIndex");
/* 3189 */       this.wSMMonthEligible = rs.getDouble("WSMMonthEligible");
/* 3190 */       this.lPQuaPCount = rs.getDouble("LPQuaPCount");
/* 3191 */       this.lPQuaFYCSum = rs.getDouble("LPQuaFYCSum");
/* 3192 */       this.b12LPPCount = rs.getDouble("B12LPPCount");
/* 3193 */       this.b12LPNAFYCSum = rs.getDouble("B12LPNAFYCSum");
/* 3194 */       this.wSMMonAFYC = rs.getDouble("WSMMonAFYC");
/* 3195 */       this.wSMTwoMonAFYC = rs.getDouble("WSMTwoMonAFYC");
/* 3196 */       this.wSMB6AFYC = rs.getDouble("WSMB6AFYC");
/* 3197 */       this.wSMB6PCount = rs.getDouble("WSMB6PCount");
/* 3198 */       this.netLiveLPCount = rs.getDouble("NetLiveLPCount");
/* 3199 */       this.netComLPCount = rs.getDouble("NetComLPCount");
/* 3200 */       this.wSMTwoMonPCount = rs.getDouble("WSMTwoMonPCount");
/* 3201 */       this.lPAllNAFYC = rs.getDouble("LPAllNAFYC");
/* 3202 */       this.lPAllPCount = rs.getDouble("LPAllPCount");
/* 3203 */       this.monPerSAFYP = rs.getDouble("MonPerSAFYP");
/* 3204 */       this.tSRThrMonSAFYP = rs.getDouble("TSRThrMonSAFYP");
/* 3205 */       this.tLThrMonPerSAFYP = rs.getDouble("TLThrMonPerSAFYP");
/* 3206 */       this.monSubsistCnt = rs.getDouble("MonSubsistCnt");
/* 3207 */       this.thrMonSubsistCnt = rs.getDouble("ThrMonSubsistCnt");
/* 3208 */       if (rs.getString("State") == null)
/* 3209 */         this.state = null;
/*      */       else {
/* 3211 */         this.state = rs.getString("State").trim();
/*      */       }
/* 3213 */       if (rs.getString("Operator") == null)
/* 3214 */         this.operator = null;
/*      */       else {
/* 3216 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/* 3218 */       this.makeDate = rs.getDate("MakeDate");
/* 3219 */       if (rs.getString("MakeTime") == null)
/* 3220 */         this.makeTime = null;
/*      */       else {
/* 3222 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/* 3224 */       this.modifyDate = rs.getDate("ModifyDate");
/* 3225 */       if (rs.getString("ModifyTime") == null)
/* 3226 */         this.modifyTime = null;
/*      */       else {
/* 3228 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/* 3230 */       if (rs.getString("AssessMonth") == null)
/* 3231 */         this.assessMonth = null;
/*      */       else {
/* 3233 */         this.assessMonth = rs.getString("AssessMonth").trim();
/*      */       }
/* 3235 */       if (rs.getString("BranchAttr") == null)
/* 3236 */         this.branchAttr = null;
/*      */       else {
/* 3238 */         this.branchAttr = rs.getString("BranchAttr").trim();
/*      */       }
/* 3240 */       if (rs.getString("AgentGrade") == null)
/* 3241 */         this.agentGrade = null;
/*      */       else {
/* 3243 */         this.agentGrade = rs.getString("AgentGrade").trim();
/*      */       }
/* 3245 */       this.clubPromBonus = rs.getDouble("ClubPromBonus");
/* 3246 */       this.clubGradeBonus = rs.getDouble("ClubGradeBonus");
/* 3247 */       this.clubAssisBonus = rs.getDouble("ClubAssisBonus");
/* 3248 */       this.clubSpecBonus = rs.getDouble("ClubSpecBonus");
/* 3249 */       this.adddedMoney = rs.getDouble("AdddedMoney");
/* 3250 */       this.lastMoney = rs.getDouble("LastMoney");
/* 3251 */       this.shouldMoney = rs.getDouble("ShouldMoney");
/* 3252 */       this.businessTax = rs.getDouble("BusinessTax");
/* 3253 */       this.eduTax = rs.getDouble("EduTax");
/* 3254 */       this.buildTax = rs.getDouble("BuildTax");
/* 3255 */       this.busiCharge = rs.getDouble("BusiCharge");
/* 3256 */       this.incomeTax = rs.getDouble("IncomeTax");
/* 3257 */       this.sumMoney = rs.getDouble("SumMoney");
/* 3258 */       this.afterTaxMoney = rs.getDouble("AfterTaxMoney");
/* 3259 */       this.operInCome = rs.getDouble("OperInCome");
/* 3260 */       this.t21 = rs.getDouble("T21");
/* 3261 */       this.t22 = rs.getDouble("T22");
/* 3262 */       this.t23 = rs.getDouble("T23");
/* 3263 */       this.t24 = rs.getDouble("T24");
/* 3264 */       this.t25 = rs.getDouble("T25");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 3268 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684LAIndexInfo\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/* 3270 */       CError tError = new CError();
/* 3271 */       tError.moduleName = "LAIndexInfoSchema";
/* 3272 */       tError.functionName = "setSchema";
/* 3273 */       tError.errorMessage = sqle.toString();
/* 3274 */       this.mErrors.addOneError(tError);
/* 3275 */       return false;
/*      */     }
/* 3277 */     return true;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoSchema getSchema()
/*      */   {
/* 3282 */     LAIndexInfoSchema aLAIndexInfoSchema = new LAIndexInfoSchema();
/* 3283 */     aLAIndexInfoSchema.setSchema(this);
/* 3284 */     return aLAIndexInfoSchema;
/*      */   }
/*      */ 
/*      */   public LAIndexInfoDB getDB()
/*      */   {
/* 3289 */     LAIndexInfoDB aDBOper = new LAIndexInfoDB();
/* 3290 */     aDBOper.setSchema(this);
/* 3291 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 3298 */     StringBuffer strReturn = new StringBuffer(256);
/* 3299 */     strReturn.append(StrTool.cTrim(this.indexCalNo)); strReturn.append("|");
/* 3300 */     strReturn.append(StrTool.cTrim(this.indexType)); strReturn.append("|");
/* 3301 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/* 3302 */     strReturn.append(StrTool.cTrim(this.agentGroup)); strReturn.append("|");
/* 3303 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/* 3304 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/* 3305 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startEnd))); strReturn.append("|");
/* 3306 */     strReturn.append(ChgData.chgData(this.quaBgnMark)); strReturn.append("|");
/* 3307 */     strReturn.append(ChgData.chgData(this.serverMonths)); strReturn.append("|");
/* 3308 */     strReturn.append(ChgData.chgData(this.postMonths)); strReturn.append("|");
/* 3309 */     strReturn.append(ChgData.chgData(this.indMonthFYC)); strReturn.append("|");
/* 3310 */     strReturn.append(ChgData.chgData(this.indMonthSYC)); strReturn.append("|");
/* 3311 */     strReturn.append(ChgData.chgData(this.indMonSignFYC)); strReturn.append("|");
/* 3312 */     strReturn.append(ChgData.chgData(this.indMonSignAFYC)); strReturn.append("|");
/* 3313 */     strReturn.append(ChgData.chgData(this.indMonSignNAFYC)); strReturn.append("|");
/* 3314 */     strReturn.append(ChgData.chgData(this.grpMonSignNAFYC)); strReturn.append("|");
/* 3315 */     strReturn.append(ChgData.chgData(this.monPolCnt)); strReturn.append("|");
/* 3316 */     strReturn.append(ChgData.chgData(this.montCustCnt)); strReturn.append("|");
/* 3317 */     strReturn.append(ChgData.chgData(this.indMonPCount)); strReturn.append("|");
/* 3318 */     strReturn.append(ChgData.chgData(this.sMmonPolContin)); strReturn.append("|");
/* 3319 */     strReturn.append(ChgData.chgData(this.sMmonProduct)); strReturn.append("|");
/* 3320 */     strReturn.append(ChgData.chgData(this.sMworkMon)); strReturn.append("|");
/* 3321 */     strReturn.append(ChgData.chgData(this.monPCount)); strReturn.append("|");
/* 3322 */     strReturn.append(ChgData.chgData(this.wSMMonPCount)); strReturn.append("|");
/* 3323 */     strReturn.append(ChgData.chgData(this.lPMonForSMMP)); strReturn.append("|");
/* 3324 */     strReturn.append(ChgData.chgData(this.lPMonForAMMP)); strReturn.append("|");
/* 3325 */     strReturn.append(ChgData.chgData(this.lPpolContinute)); strReturn.append("|");
/* 3326 */     strReturn.append(ChgData.chgData(this.monEligFLPCnt)); strReturn.append("|");
/* 3327 */     strReturn.append(ChgData.chgData(this.tSRmonAFYP)); strReturn.append("|");
/* 3328 */     strReturn.append(ChgData.chgData(this.tSRmonDedAFYP)); strReturn.append("|");
/* 3329 */     strReturn.append(ChgData.chgData(this.tSRmonCompAFYP)); strReturn.append("|");
/* 3330 */     strReturn.append(ChgData.chgData(this.tSRMonWorkDays)); strReturn.append("|");
/* 3331 */     strReturn.append(ChgData.chgData(this.monManPower)); strReturn.append("|");
/* 3332 */     strReturn.append(ChgData.chgData(this.monManCount)); strReturn.append("|");
/* 3333 */     strReturn.append(ChgData.chgData(this.monSAFYPSum)); strReturn.append("|");
/* 3334 */     strReturn.append(ChgData.chgData(this.monTLGrpSAFYPSum)); strReturn.append("|");
/* 3335 */     strReturn.append(ChgData.chgData(this.indYearNAFYC)); strReturn.append("|");
/* 3336 */     strReturn.append(ChgData.chgData(this.b12IndEffectAFYC)); strReturn.append("|");
/* 3337 */     strReturn.append(ChgData.chgData(this.b12IndAllAFYC)); strReturn.append("|");
/* 3338 */     strReturn.append(ChgData.chgData(this.b24IndEffectAFYC)); strReturn.append("|");
/* 3339 */     strReturn.append(ChgData.chgData(this.b24IndAllAFYC)); strReturn.append("|");
/* 3340 */     strReturn.append(ChgData.chgData(this.indQutFYC)); strReturn.append("|");
/* 3341 */     strReturn.append(ChgData.chgData(this.lPproductivity)); strReturn.append("|");
/* 3342 */     strReturn.append(ChgData.chgData(this.lPPPRate)); strReturn.append("|");
/* 3343 */     strReturn.append(ChgData.chgData(this.lPPPBonus)); strReturn.append("|");
/* 3344 */     strReturn.append(ChgData.chgData(this.lPFincSubsidy)); strReturn.append("|");
/* 3345 */     strReturn.append(ChgData.chgData(this.subsidyRate)); strReturn.append("|");
/* 3346 */     strReturn.append(ChgData.chgData(this.b12TeamNAFYC)); strReturn.append("|");
/* 3347 */     strReturn.append(ChgData.chgData(this.sMOverride)); strReturn.append("|");
/* 3348 */     strReturn.append(ChgData.chgData(this.teamMonAvgPCount)); strReturn.append("|");
/* 3349 */     strReturn.append(ChgData.chgData(this.sMBasicSalary)); strReturn.append("|");
/* 3350 */     strReturn.append(ChgData.chgData(this.sMproductivity)); strReturn.append("|");
/* 3351 */     strReturn.append(ChgData.chgData(this.sMpolContinute)); strReturn.append("|");
/* 3352 */     strReturn.append(ChgData.chgData(this.sMPPRate)); strReturn.append("|");
/* 3353 */     strReturn.append(ChgData.chgData(this.sMPPBonus)); strReturn.append("|");
/* 3354 */     strReturn.append(ChgData.chgData(this.b24TeamEffectAFYC)); strReturn.append("|");
/* 3355 */     strReturn.append(ChgData.chgData(this.b24TeamAllAFYC)); strReturn.append("|");
/* 3356 */     strReturn.append(ChgData.chgData(this.teamQutPremSum)); strReturn.append("|");
/* 3357 */     strReturn.append(ChgData.chgData(this.sMRRBonus)); strReturn.append("|");
/* 3358 */     strReturn.append(ChgData.chgData(this.sMManPowerDBonus)); strReturn.append("|");
/* 3359 */     strReturn.append(ChgData.chgData(this.lPB12ForMPDBonus)); strReturn.append("|");
/* 3360 */     strReturn.append(ChgData.chgData(this.sMUsualALLCSum)); strReturn.append("|");
/* 3361 */     strReturn.append(ChgData.chgData(this.aMBasicSalary)); strReturn.append("|");
/* 3362 */     strReturn.append(ChgData.chgData(this.aMproductivity)); strReturn.append("|");
/* 3363 */     strReturn.append(ChgData.chgData(this.aMpolContinute)); strReturn.append("|");
/* 3364 */     strReturn.append(ChgData.chgData(this.aMPPRate)); strReturn.append("|");
/* 3365 */     strReturn.append(ChgData.chgData(this.aMPPBonus)); strReturn.append("|");
/* 3366 */     strReturn.append(ChgData.chgData(this.b12DepNAFYC)); strReturn.append("|");
/* 3367 */     strReturn.append(ChgData.chgData(this.aMOverride)); strReturn.append("|");
/* 3368 */     strReturn.append(ChgData.chgData(this.depMonAvgPCount)); strReturn.append("|");
/* 3369 */     strReturn.append(ChgData.chgData(this.depQutPremSum)); strReturn.append("|");
/* 3370 */     strReturn.append(ChgData.chgData(this.aMRRBonus)); strReturn.append("|");
/* 3371 */     strReturn.append(ChgData.chgData(this.aMManPowerDBonus)); strReturn.append("|");
/* 3372 */     strReturn.append(ChgData.chgData(this.productGrowth)); strReturn.append("|");
/* 3373 */     strReturn.append(ChgData.chgData(this.depQuaFYCSum)); strReturn.append("|");
/* 3374 */     strReturn.append(ChgData.chgData(this.aMLiability)); strReturn.append("|");
/* 3375 */     strReturn.append(ChgData.chgData(this.reviOpen)); strReturn.append("|");
/* 3376 */     strReturn.append(ChgData.chgData(this.t1)); strReturn.append("|");
/* 3377 */     strReturn.append(ChgData.chgData(this.t2)); strReturn.append("|");
/* 3378 */     strReturn.append(ChgData.chgData(this.t3)); strReturn.append("|");
/* 3379 */     strReturn.append(ChgData.chgData(this.t4)); strReturn.append("|");
/* 3380 */     strReturn.append(ChgData.chgData(this.t5)); strReturn.append("|");
/* 3381 */     strReturn.append(ChgData.chgData(this.t6)); strReturn.append("|");
/* 3382 */     strReturn.append(ChgData.chgData(this.t7)); strReturn.append("|");
/* 3383 */     strReturn.append(ChgData.chgData(this.t8)); strReturn.append("|");
/* 3384 */     strReturn.append(ChgData.chgData(this.t9)); strReturn.append("|");
/* 3385 */     strReturn.append(ChgData.chgData(this.t10)); strReturn.append("|");
/* 3386 */     strReturn.append(ChgData.chgData(this.t11)); strReturn.append("|");
/* 3387 */     strReturn.append(ChgData.chgData(this.t12)); strReturn.append("|");
/* 3388 */     strReturn.append(ChgData.chgData(this.t13)); strReturn.append("|");
/* 3389 */     strReturn.append(ChgData.chgData(this.t14)); strReturn.append("|");
/* 3390 */     strReturn.append(ChgData.chgData(this.t15)); strReturn.append("|");
/* 3391 */     strReturn.append(ChgData.chgData(this.t16)); strReturn.append("|");
/* 3392 */     strReturn.append(ChgData.chgData(this.t17)); strReturn.append("|");
/* 3393 */     strReturn.append(ChgData.chgData(this.t18)); strReturn.append("|");
/* 3394 */     strReturn.append(ChgData.chgData(this.t20)); strReturn.append("|");
/* 3395 */     strReturn.append(ChgData.chgData(this.t19)); strReturn.append("|");
/* 3396 */     strReturn.append(ChgData.chgData(this.monthIndex)); strReturn.append("|");
/* 3397 */     strReturn.append(ChgData.chgData(this.tMonthIndex)); strReturn.append("|");
/* 3398 */     strReturn.append(ChgData.chgData(this.aSumIndex)); strReturn.append("|");
/* 3399 */     strReturn.append(ChgData.chgData(this.wSMMonthEligible)); strReturn.append("|");
/* 3400 */     strReturn.append(ChgData.chgData(this.lPQuaPCount)); strReturn.append("|");
/* 3401 */     strReturn.append(ChgData.chgData(this.lPQuaFYCSum)); strReturn.append("|");
/* 3402 */     strReturn.append(ChgData.chgData(this.b12LPPCount)); strReturn.append("|");
/* 3403 */     strReturn.append(ChgData.chgData(this.b12LPNAFYCSum)); strReturn.append("|");
/* 3404 */     strReturn.append(ChgData.chgData(this.wSMMonAFYC)); strReturn.append("|");
/* 3405 */     strReturn.append(ChgData.chgData(this.wSMTwoMonAFYC)); strReturn.append("|");
/* 3406 */     strReturn.append(ChgData.chgData(this.wSMB6AFYC)); strReturn.append("|");
/* 3407 */     strReturn.append(ChgData.chgData(this.wSMB6PCount)); strReturn.append("|");
/* 3408 */     strReturn.append(ChgData.chgData(this.netLiveLPCount)); strReturn.append("|");
/* 3409 */     strReturn.append(ChgData.chgData(this.netComLPCount)); strReturn.append("|");
/* 3410 */     strReturn.append(ChgData.chgData(this.wSMTwoMonPCount)); strReturn.append("|");
/* 3411 */     strReturn.append(ChgData.chgData(this.lPAllNAFYC)); strReturn.append("|");
/* 3412 */     strReturn.append(ChgData.chgData(this.lPAllPCount)); strReturn.append("|");
/* 3413 */     strReturn.append(ChgData.chgData(this.monPerSAFYP)); strReturn.append("|");
/* 3414 */     strReturn.append(ChgData.chgData(this.tSRThrMonSAFYP)); strReturn.append("|");
/* 3415 */     strReturn.append(ChgData.chgData(this.tLThrMonPerSAFYP)); strReturn.append("|");
/* 3416 */     strReturn.append(ChgData.chgData(this.monSubsistCnt)); strReturn.append("|");
/* 3417 */     strReturn.append(ChgData.chgData(this.thrMonSubsistCnt)); strReturn.append("|");
/* 3418 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/* 3419 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 3420 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 3421 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 3422 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 3423 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/* 3424 */     strReturn.append(StrTool.cTrim(this.assessMonth)); strReturn.append("|");
/* 3425 */     strReturn.append(StrTool.cTrim(this.branchAttr)); strReturn.append("|");
/* 3426 */     strReturn.append(StrTool.cTrim(this.agentGrade)); strReturn.append("|");
/* 3427 */     strReturn.append(ChgData.chgData(this.clubPromBonus)); strReturn.append("|");
/* 3428 */     strReturn.append(ChgData.chgData(this.clubGradeBonus)); strReturn.append("|");
/* 3429 */     strReturn.append(ChgData.chgData(this.clubAssisBonus)); strReturn.append("|");
/* 3430 */     strReturn.append(ChgData.chgData(this.clubSpecBonus)); strReturn.append("|");
/* 3431 */     strReturn.append(ChgData.chgData(this.adddedMoney)); strReturn.append("|");
/* 3432 */     strReturn.append(ChgData.chgData(this.lastMoney)); strReturn.append("|");
/* 3433 */     strReturn.append(ChgData.chgData(this.shouldMoney)); strReturn.append("|");
/* 3434 */     strReturn.append(ChgData.chgData(this.businessTax)); strReturn.append("|");
/* 3435 */     strReturn.append(ChgData.chgData(this.eduTax)); strReturn.append("|");
/* 3436 */     strReturn.append(ChgData.chgData(this.buildTax)); strReturn.append("|");
/* 3437 */     strReturn.append(ChgData.chgData(this.busiCharge)); strReturn.append("|");
/* 3438 */     strReturn.append(ChgData.chgData(this.incomeTax)); strReturn.append("|");
/* 3439 */     strReturn.append(ChgData.chgData(this.sumMoney)); strReturn.append("|");
/* 3440 */     strReturn.append(ChgData.chgData(this.afterTaxMoney)); strReturn.append("|");
/* 3441 */     strReturn.append(ChgData.chgData(this.operInCome)); strReturn.append("|");
/* 3442 */     strReturn.append(ChgData.chgData(this.t21)); strReturn.append("|");
/* 3443 */     strReturn.append(ChgData.chgData(this.t22)); strReturn.append("|");
/* 3444 */     strReturn.append(ChgData.chgData(this.t23)); strReturn.append("|");
/* 3445 */     strReturn.append(ChgData.chgData(this.t24)); strReturn.append("|");
/* 3446 */     strReturn.append(ChgData.chgData(this.t25));
/* 3447 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 3455 */       this.indexCalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 3456 */       this.indexType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 3457 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 3458 */       this.agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 3459 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 3460 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/* 3461 */       this.startEnd = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
/* 3462 */       this.quaBgnMark = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).intValue();
/* 3463 */       this.serverMonths = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).intValue();
/* 3464 */       this.postMonths = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/* 3465 */       this.indMonthFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).doubleValue();
/* 3466 */       this.indMonthSYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).doubleValue();
/* 3467 */       this.indMonSignFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).doubleValue();
/* 3468 */       this.indMonSignAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|"))).doubleValue();
/* 3469 */       this.indMonSignNAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).doubleValue();
/* 3470 */       this.grpMonSignNAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|"))).doubleValue();
/* 3471 */       this.monPolCnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 17, "|"))).doubleValue();
/* 3472 */       this.montCustCnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|"))).doubleValue();
/* 3473 */       this.indMonPCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 19, "|"))).doubleValue();
/* 3474 */       this.sMmonPolContin = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).doubleValue();
/* 3475 */       this.sMmonProduct = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|"))).doubleValue();
/* 3476 */       this.sMworkMon = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 22, "|"))).doubleValue();
/* 3477 */       this.monPCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|"))).doubleValue();
/* 3478 */       this.wSMMonPCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 24, "|"))).doubleValue();
/* 3479 */       this.lPMonForSMMP = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 25, "|"))).doubleValue();
/* 3480 */       this.lPMonForAMMP = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 26, "|"))).doubleValue();
/* 3481 */       this.lPpolContinute = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 27, "|"))).doubleValue();
/* 3482 */       this.monEligFLPCnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 28, "|"))).doubleValue();
/* 3483 */       this.tSRmonAFYP = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|"))).doubleValue();
/* 3484 */       this.tSRmonDedAFYP = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 30, "|"))).doubleValue();
/* 3485 */       this.tSRmonCompAFYP = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|"))).doubleValue();
/* 3486 */       this.tSRMonWorkDays = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|"))).doubleValue();
/* 3487 */       this.monManPower = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 33, "|"))).doubleValue();
/* 3488 */       this.monManCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 34, "|"))).doubleValue();
/* 3489 */       this.monSAFYPSum = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 35, "|"))).doubleValue();
/* 3490 */       this.monTLGrpSAFYPSum = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|"))).doubleValue();
/* 3491 */       this.indYearNAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 37, "|"))).doubleValue();
/* 3492 */       this.b12IndEffectAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|"))).doubleValue();
/* 3493 */       this.b12IndAllAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|"))).doubleValue();
/* 3494 */       this.b24IndEffectAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 40, "|"))).doubleValue();
/* 3495 */       this.b24IndAllAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 41, "|"))).doubleValue();
/* 3496 */       this.indQutFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 42, "|"))).doubleValue();
/* 3497 */       this.lPproductivity = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 43, "|"))).doubleValue();
/* 3498 */       this.lPPPRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 44, "|"))).doubleValue();
/* 3499 */       this.lPPPBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 45, "|"))).doubleValue();
/* 3500 */       this.lPFincSubsidy = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 46, "|"))).doubleValue();
/* 3501 */       this.subsidyRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 47, "|"))).doubleValue();
/* 3502 */       this.b12TeamNAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 48, "|"))).doubleValue();
/* 3503 */       this.sMOverride = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 49, "|"))).doubleValue();
/* 3504 */       this.teamMonAvgPCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 50, "|"))).doubleValue();
/* 3505 */       this.sMBasicSalary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 51, "|"))).doubleValue();
/* 3506 */       this.sMproductivity = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 52, "|"))).doubleValue();
/* 3507 */       this.sMpolContinute = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 53, "|"))).doubleValue();
/* 3508 */       this.sMPPRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 54, "|"))).doubleValue();
/* 3509 */       this.sMPPBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 55, "|"))).doubleValue();
/* 3510 */       this.b24TeamEffectAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 56, "|"))).doubleValue();
/* 3511 */       this.b24TeamAllAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|"))).doubleValue();
/* 3512 */       this.teamQutPremSum = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|"))).doubleValue();
/* 3513 */       this.sMRRBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|"))).doubleValue();
/* 3514 */       this.sMManPowerDBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|"))).doubleValue();
/* 3515 */       this.lPB12ForMPDBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|"))).doubleValue();
/* 3516 */       this.sMUsualALLCSum = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 62, "|"))).doubleValue();
/* 3517 */       this.aMBasicSalary = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 63, "|"))).doubleValue();
/* 3518 */       this.aMproductivity = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 64, "|"))).doubleValue();
/* 3519 */       this.aMpolContinute = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 65, "|"))).doubleValue();
/* 3520 */       this.aMPPRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 66, "|"))).doubleValue();
/* 3521 */       this.aMPPBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 67, "|"))).doubleValue();
/* 3522 */       this.b12DepNAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 68, "|"))).doubleValue();
/* 3523 */       this.aMOverride = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 69, "|"))).doubleValue();
/* 3524 */       this.depMonAvgPCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 70, "|"))).doubleValue();
/* 3525 */       this.depQutPremSum = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 71, "|"))).doubleValue();
/* 3526 */       this.aMRRBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 72, "|"))).doubleValue();
/* 3527 */       this.aMManPowerDBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 73, "|"))).doubleValue();
/* 3528 */       this.productGrowth = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 74, "|"))).doubleValue();
/* 3529 */       this.depQuaFYCSum = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 75, "|"))).doubleValue();
/* 3530 */       this.aMLiability = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 76, "|"))).doubleValue();
/* 3531 */       this.reviOpen = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 77, "|"))).doubleValue();
/* 3532 */       this.t1 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 78, "|"))).doubleValue();
/* 3533 */       this.t2 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 79, "|"))).doubleValue();
/* 3534 */       this.t3 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 80, "|"))).doubleValue();
/* 3535 */       this.t4 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 81, "|"))).doubleValue();
/* 3536 */       this.t5 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 82, "|"))).doubleValue();
/* 3537 */       this.t6 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 83, "|"))).doubleValue();
/* 3538 */       this.t7 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 84, "|"))).doubleValue();
/* 3539 */       this.t8 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 85, "|"))).doubleValue();
/* 3540 */       this.t9 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 86, "|"))).doubleValue();
/* 3541 */       this.t10 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 87, "|"))).doubleValue();
/* 3542 */       this.t11 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 88, "|"))).doubleValue();
/* 3543 */       this.t12 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 89, "|"))).doubleValue();
/* 3544 */       this.t13 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 90, "|"))).doubleValue();
/* 3545 */       this.t14 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 91, "|"))).doubleValue();
/* 3546 */       this.t15 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 92, "|"))).doubleValue();
/* 3547 */       this.t16 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 93, "|"))).doubleValue();
/* 3548 */       this.t17 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 94, "|"))).doubleValue();
/* 3549 */       this.t18 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 95, "|"))).doubleValue();
/* 3550 */       this.t20 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 96, "|"))).doubleValue();
/* 3551 */       this.t19 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 97, "|"))).doubleValue();
/* 3552 */       this.monthIndex = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 98, "|"))).doubleValue();
/* 3553 */       this.tMonthIndex = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 99, "|"))).doubleValue();
/* 3554 */       this.aSumIndex = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 100, "|"))).doubleValue();
/* 3555 */       this.wSMMonthEligible = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 101, "|"))).doubleValue();
/* 3556 */       this.lPQuaPCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 102, "|"))).doubleValue();
/* 3557 */       this.lPQuaFYCSum = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 103, "|"))).doubleValue();
/* 3558 */       this.b12LPPCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 104, "|"))).doubleValue();
/* 3559 */       this.b12LPNAFYCSum = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 105, "|"))).doubleValue();
/* 3560 */       this.wSMMonAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 106, "|"))).doubleValue();
/* 3561 */       this.wSMTwoMonAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 107, "|"))).doubleValue();
/* 3562 */       this.wSMB6AFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 108, "|"))).doubleValue();
/* 3563 */       this.wSMB6PCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 109, "|"))).doubleValue();
/* 3564 */       this.netLiveLPCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 110, "|"))).doubleValue();
/* 3565 */       this.netComLPCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 111, "|"))).doubleValue();
/* 3566 */       this.wSMTwoMonPCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 112, "|"))).doubleValue();
/* 3567 */       this.lPAllNAFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 113, "|"))).doubleValue();
/* 3568 */       this.lPAllPCount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 114, "|"))).doubleValue();
/* 3569 */       this.monPerSAFYP = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 115, "|"))).doubleValue();
/* 3570 */       this.tSRThrMonSAFYP = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 116, "|"))).doubleValue();
/* 3571 */       this.tLThrMonPerSAFYP = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 117, "|"))).doubleValue();
/* 3572 */       this.monSubsistCnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 118, "|"))).doubleValue();
/* 3573 */       this.thrMonSubsistCnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 119, "|"))).doubleValue();
/* 3574 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 120, "|");
/* 3575 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 121, "|");
/* 3576 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 122, "|"));
/* 3577 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 123, "|");
/* 3578 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 124, "|"));
/* 3579 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 125, "|");
/* 3580 */       this.assessMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 126, "|");
/* 3581 */       this.branchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 127, "|");
/* 3582 */       this.agentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 128, "|");
/* 3583 */       this.clubPromBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 129, "|"))).doubleValue();
/* 3584 */       this.clubGradeBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 130, "|"))).doubleValue();
/* 3585 */       this.clubAssisBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 131, "|"))).doubleValue();
/* 3586 */       this.clubSpecBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 132, "|"))).doubleValue();
/* 3587 */       this.adddedMoney = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 133, "|"))).doubleValue();
/* 3588 */       this.lastMoney = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 134, "|"))).doubleValue();
/* 3589 */       this.shouldMoney = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 135, "|"))).doubleValue();
/* 3590 */       this.businessTax = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 136, "|"))).doubleValue();
/* 3591 */       this.eduTax = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 137, "|"))).doubleValue();
/* 3592 */       this.buildTax = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 138, "|"))).doubleValue();
/* 3593 */       this.busiCharge = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 139, "|"))).doubleValue();
/* 3594 */       this.incomeTax = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 140, "|"))).doubleValue();
/* 3595 */       this.sumMoney = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 141, "|"))).doubleValue();
/* 3596 */       this.afterTaxMoney = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 142, "|"))).doubleValue();
/* 3597 */       this.operInCome = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 143, "|"))).doubleValue();
/* 3598 */       this.t21 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 144, "|"))).doubleValue();
/* 3599 */       this.t22 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 145, "|"))).doubleValue();
/* 3600 */       this.t23 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 146, "|"))).doubleValue();
/* 3601 */       this.t24 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 147, "|"))).doubleValue();
/* 3602 */       this.t25 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 148, "|"))).doubleValue();
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 3607 */       CError tError = new CError();
/* 3608 */       tError.moduleName = "LAIndexInfoSchema";
/* 3609 */       tError.functionName = "decode";
/* 3610 */       tError.errorMessage = ex.toString();
/* 3611 */       this.mErrors.addOneError(tError);
/*      */ 
/* 3613 */       return false;
/*      */     }
/* 3615 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 3621 */     String strReturn = "";
/* 3622 */     if (FCode.equalsIgnoreCase("indexCalNo"))
/*      */     {
/* 3624 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indexCalNo));
/*      */     }
/* 3626 */     if (FCode.equalsIgnoreCase("indexType"))
/*      */     {
/* 3628 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indexType));
/*      */     }
/* 3630 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 3632 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/* 3634 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*      */     {
/* 3636 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup));
/*      */     }
/* 3638 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 3640 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 3642 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/* 3644 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/* 3646 */     if (FCode.equalsIgnoreCase("startEnd"))
/*      */     {
/* 3648 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd()));
/*      */     }
/* 3650 */     if (FCode.equalsIgnoreCase("quaBgnMark"))
/*      */     {
/* 3652 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.quaBgnMark));
/*      */     }
/* 3654 */     if (FCode.equalsIgnoreCase("serverMonths"))
/*      */     {
/* 3656 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serverMonths));
/*      */     }
/* 3658 */     if (FCode.equalsIgnoreCase("postMonths"))
/*      */     {
/* 3660 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.postMonths));
/*      */     }
/* 3662 */     if (FCode.equalsIgnoreCase("indMonthFYC"))
/*      */     {
/* 3664 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indMonthFYC));
/*      */     }
/* 3666 */     if (FCode.equalsIgnoreCase("indMonthSYC"))
/*      */     {
/* 3668 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indMonthSYC));
/*      */     }
/* 3670 */     if (FCode.equalsIgnoreCase("indMonSignFYC"))
/*      */     {
/* 3672 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indMonSignFYC));
/*      */     }
/* 3674 */     if (FCode.equalsIgnoreCase("indMonSignAFYC"))
/*      */     {
/* 3676 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indMonSignAFYC));
/*      */     }
/* 3678 */     if (FCode.equalsIgnoreCase("indMonSignNAFYC"))
/*      */     {
/* 3680 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indMonSignNAFYC));
/*      */     }
/* 3682 */     if (FCode.equalsIgnoreCase("grpMonSignNAFYC"))
/*      */     {
/* 3684 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpMonSignNAFYC));
/*      */     }
/* 3686 */     if (FCode.equalsIgnoreCase("monPolCnt"))
/*      */     {
/* 3688 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.monPolCnt));
/*      */     }
/* 3690 */     if (FCode.equalsIgnoreCase("montCustCnt"))
/*      */     {
/* 3692 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.montCustCnt));
/*      */     }
/* 3694 */     if (FCode.equalsIgnoreCase("indMonPCount"))
/*      */     {
/* 3696 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indMonPCount));
/*      */     }
/* 3698 */     if (FCode.equalsIgnoreCase("sMmonPolContin"))
/*      */     {
/* 3700 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMmonPolContin));
/*      */     }
/* 3702 */     if (FCode.equalsIgnoreCase("sMmonProduct"))
/*      */     {
/* 3704 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMmonProduct));
/*      */     }
/* 3706 */     if (FCode.equalsIgnoreCase("sMworkMon"))
/*      */     {
/* 3708 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMworkMon));
/*      */     }
/* 3710 */     if (FCode.equalsIgnoreCase("monPCount"))
/*      */     {
/* 3712 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.monPCount));
/*      */     }
/* 3714 */     if (FCode.equalsIgnoreCase("wSMMonPCount"))
/*      */     {
/* 3716 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.wSMMonPCount));
/*      */     }
/* 3718 */     if (FCode.equalsIgnoreCase("lPMonForSMMP"))
/*      */     {
/* 3720 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPMonForSMMP));
/*      */     }
/* 3722 */     if (FCode.equalsIgnoreCase("lPMonForAMMP"))
/*      */     {
/* 3724 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPMonForAMMP));
/*      */     }
/* 3726 */     if (FCode.equalsIgnoreCase("lPpolContinute"))
/*      */     {
/* 3728 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPpolContinute));
/*      */     }
/* 3730 */     if (FCode.equalsIgnoreCase("monEligFLPCnt"))
/*      */     {
/* 3732 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.monEligFLPCnt));
/*      */     }
/* 3734 */     if (FCode.equalsIgnoreCase("tSRmonAFYP"))
/*      */     {
/* 3736 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.tSRmonAFYP));
/*      */     }
/* 3738 */     if (FCode.equalsIgnoreCase("tSRmonDedAFYP"))
/*      */     {
/* 3740 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.tSRmonDedAFYP));
/*      */     }
/* 3742 */     if (FCode.equalsIgnoreCase("tSRmonCompAFYP"))
/*      */     {
/* 3744 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.tSRmonCompAFYP));
/*      */     }
/* 3746 */     if (FCode.equalsIgnoreCase("tSRMonWorkDays"))
/*      */     {
/* 3748 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.tSRMonWorkDays));
/*      */     }
/* 3750 */     if (FCode.equalsIgnoreCase("monManPower"))
/*      */     {
/* 3752 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.monManPower));
/*      */     }
/* 3754 */     if (FCode.equalsIgnoreCase("monManCount"))
/*      */     {
/* 3756 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.monManCount));
/*      */     }
/* 3758 */     if (FCode.equalsIgnoreCase("monSAFYPSum"))
/*      */     {
/* 3760 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.monSAFYPSum));
/*      */     }
/* 3762 */     if (FCode.equalsIgnoreCase("monTLGrpSAFYPSum"))
/*      */     {
/* 3764 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.monTLGrpSAFYPSum));
/*      */     }
/* 3766 */     if (FCode.equalsIgnoreCase("indYearNAFYC"))
/*      */     {
/* 3768 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indYearNAFYC));
/*      */     }
/* 3770 */     if (FCode.equalsIgnoreCase("b12IndEffectAFYC"))
/*      */     {
/* 3772 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.b12IndEffectAFYC));
/*      */     }
/* 3774 */     if (FCode.equalsIgnoreCase("b12IndAllAFYC"))
/*      */     {
/* 3776 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.b12IndAllAFYC));
/*      */     }
/* 3778 */     if (FCode.equalsIgnoreCase("b24IndEffectAFYC"))
/*      */     {
/* 3780 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.b24IndEffectAFYC));
/*      */     }
/* 3782 */     if (FCode.equalsIgnoreCase("b24IndAllAFYC"))
/*      */     {
/* 3784 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.b24IndAllAFYC));
/*      */     }
/* 3786 */     if (FCode.equalsIgnoreCase("indQutFYC"))
/*      */     {
/* 3788 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indQutFYC));
/*      */     }
/* 3790 */     if (FCode.equalsIgnoreCase("lPproductivity"))
/*      */     {
/* 3792 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPproductivity));
/*      */     }
/* 3794 */     if (FCode.equalsIgnoreCase("lPPPRate"))
/*      */     {
/* 3796 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPPPRate));
/*      */     }
/* 3798 */     if (FCode.equalsIgnoreCase("lPPPBonus"))
/*      */     {
/* 3800 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPPPBonus));
/*      */     }
/* 3802 */     if (FCode.equalsIgnoreCase("lPFincSubsidy"))
/*      */     {
/* 3804 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPFincSubsidy));
/*      */     }
/* 3806 */     if (FCode.equalsIgnoreCase("subsidyRate"))
/*      */     {
/* 3808 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.subsidyRate));
/*      */     }
/* 3810 */     if (FCode.equalsIgnoreCase("b12TeamNAFYC"))
/*      */     {
/* 3812 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.b12TeamNAFYC));
/*      */     }
/* 3814 */     if (FCode.equalsIgnoreCase("sMOverride"))
/*      */     {
/* 3816 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMOverride));
/*      */     }
/* 3818 */     if (FCode.equalsIgnoreCase("teamMonAvgPCount"))
/*      */     {
/* 3820 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.teamMonAvgPCount));
/*      */     }
/* 3822 */     if (FCode.equalsIgnoreCase("sMBasicSalary"))
/*      */     {
/* 3824 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMBasicSalary));
/*      */     }
/* 3826 */     if (FCode.equalsIgnoreCase("sMproductivity"))
/*      */     {
/* 3828 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMproductivity));
/*      */     }
/* 3830 */     if (FCode.equalsIgnoreCase("sMpolContinute"))
/*      */     {
/* 3832 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMpolContinute));
/*      */     }
/* 3834 */     if (FCode.equalsIgnoreCase("sMPPRate"))
/*      */     {
/* 3836 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMPPRate));
/*      */     }
/* 3838 */     if (FCode.equalsIgnoreCase("sMPPBonus"))
/*      */     {
/* 3840 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMPPBonus));
/*      */     }
/* 3842 */     if (FCode.equalsIgnoreCase("b24TeamEffectAFYC"))
/*      */     {
/* 3844 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.b24TeamEffectAFYC));
/*      */     }
/* 3846 */     if (FCode.equalsIgnoreCase("b24TeamAllAFYC"))
/*      */     {
/* 3848 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.b24TeamAllAFYC));
/*      */     }
/* 3850 */     if (FCode.equalsIgnoreCase("teamQutPremSum"))
/*      */     {
/* 3852 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.teamQutPremSum));
/*      */     }
/* 3854 */     if (FCode.equalsIgnoreCase("sMRRBonus"))
/*      */     {
/* 3856 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMRRBonus));
/*      */     }
/* 3858 */     if (FCode.equalsIgnoreCase("sMManPowerDBonus"))
/*      */     {
/* 3860 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMManPowerDBonus));
/*      */     }
/* 3862 */     if (FCode.equalsIgnoreCase("lPB12ForMPDBonus"))
/*      */     {
/* 3864 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPB12ForMPDBonus));
/*      */     }
/* 3866 */     if (FCode.equalsIgnoreCase("sMUsualALLCSum"))
/*      */     {
/* 3868 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMUsualALLCSum));
/*      */     }
/* 3870 */     if (FCode.equalsIgnoreCase("aMBasicSalary"))
/*      */     {
/* 3872 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMBasicSalary));
/*      */     }
/* 3874 */     if (FCode.equalsIgnoreCase("aMproductivity"))
/*      */     {
/* 3876 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMproductivity));
/*      */     }
/* 3878 */     if (FCode.equalsIgnoreCase("aMpolContinute"))
/*      */     {
/* 3880 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMpolContinute));
/*      */     }
/* 3882 */     if (FCode.equalsIgnoreCase("aMPPRate"))
/*      */     {
/* 3884 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMPPRate));
/*      */     }
/* 3886 */     if (FCode.equalsIgnoreCase("aMPPBonus"))
/*      */     {
/* 3888 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMPPBonus));
/*      */     }
/* 3890 */     if (FCode.equalsIgnoreCase("b12DepNAFYC"))
/*      */     {
/* 3892 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.b12DepNAFYC));
/*      */     }
/* 3894 */     if (FCode.equalsIgnoreCase("aMOverride"))
/*      */     {
/* 3896 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMOverride));
/*      */     }
/* 3898 */     if (FCode.equalsIgnoreCase("depMonAvgPCount"))
/*      */     {
/* 3900 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.depMonAvgPCount));
/*      */     }
/* 3902 */     if (FCode.equalsIgnoreCase("depQutPremSum"))
/*      */     {
/* 3904 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.depQutPremSum));
/*      */     }
/* 3906 */     if (FCode.equalsIgnoreCase("aMRRBonus"))
/*      */     {
/* 3908 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMRRBonus));
/*      */     }
/* 3910 */     if (FCode.equalsIgnoreCase("aMManPowerDBonus"))
/*      */     {
/* 3912 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMManPowerDBonus));
/*      */     }
/* 3914 */     if (FCode.equalsIgnoreCase("productGrowth"))
/*      */     {
/* 3916 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.productGrowth));
/*      */     }
/* 3918 */     if (FCode.equalsIgnoreCase("depQuaFYCSum"))
/*      */     {
/* 3920 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.depQuaFYCSum));
/*      */     }
/* 3922 */     if (FCode.equalsIgnoreCase("aMLiability"))
/*      */     {
/* 3924 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMLiability));
/*      */     }
/* 3926 */     if (FCode.equalsIgnoreCase("reviOpen"))
/*      */     {
/* 3928 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.reviOpen));
/*      */     }
/* 3930 */     if (FCode.equalsIgnoreCase("t1"))
/*      */     {
/* 3932 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t1));
/*      */     }
/* 3934 */     if (FCode.equalsIgnoreCase("t2"))
/*      */     {
/* 3936 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t2));
/*      */     }
/* 3938 */     if (FCode.equalsIgnoreCase("t3"))
/*      */     {
/* 3940 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t3));
/*      */     }
/* 3942 */     if (FCode.equalsIgnoreCase("t4"))
/*      */     {
/* 3944 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t4));
/*      */     }
/* 3946 */     if (FCode.equalsIgnoreCase("t5"))
/*      */     {
/* 3948 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t5));
/*      */     }
/* 3950 */     if (FCode.equalsIgnoreCase("t6"))
/*      */     {
/* 3952 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t6));
/*      */     }
/* 3954 */     if (FCode.equalsIgnoreCase("t7"))
/*      */     {
/* 3956 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t7));
/*      */     }
/* 3958 */     if (FCode.equalsIgnoreCase("t8"))
/*      */     {
/* 3960 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t8));
/*      */     }
/* 3962 */     if (FCode.equalsIgnoreCase("t9"))
/*      */     {
/* 3964 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t9));
/*      */     }
/* 3966 */     if (FCode.equalsIgnoreCase("t10"))
/*      */     {
/* 3968 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t10));
/*      */     }
/* 3970 */     if (FCode.equalsIgnoreCase("t11"))
/*      */     {
/* 3972 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t11));
/*      */     }
/* 3974 */     if (FCode.equalsIgnoreCase("t12"))
/*      */     {
/* 3976 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t12));
/*      */     }
/* 3978 */     if (FCode.equalsIgnoreCase("t13"))
/*      */     {
/* 3980 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t13));
/*      */     }
/* 3982 */     if (FCode.equalsIgnoreCase("t14"))
/*      */     {
/* 3984 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t14));
/*      */     }
/* 3986 */     if (FCode.equalsIgnoreCase("t15"))
/*      */     {
/* 3988 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t15));
/*      */     }
/* 3990 */     if (FCode.equalsIgnoreCase("t16"))
/*      */     {
/* 3992 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t16));
/*      */     }
/* 3994 */     if (FCode.equalsIgnoreCase("t17"))
/*      */     {
/* 3996 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t17));
/*      */     }
/* 3998 */     if (FCode.equalsIgnoreCase("t18"))
/*      */     {
/* 4000 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t18));
/*      */     }
/* 4002 */     if (FCode.equalsIgnoreCase("t20"))
/*      */     {
/* 4004 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t20));
/*      */     }
/* 4006 */     if (FCode.equalsIgnoreCase("t19"))
/*      */     {
/* 4008 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t19));
/*      */     }
/* 4010 */     if (FCode.equalsIgnoreCase("monthIndex"))
/*      */     {
/* 4012 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.monthIndex));
/*      */     }
/* 4014 */     if (FCode.equalsIgnoreCase("tMonthIndex"))
/*      */     {
/* 4016 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.tMonthIndex));
/*      */     }
/* 4018 */     if (FCode.equalsIgnoreCase("aSumIndex"))
/*      */     {
/* 4020 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aSumIndex));
/*      */     }
/* 4022 */     if (FCode.equalsIgnoreCase("wSMMonthEligible"))
/*      */     {
/* 4024 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.wSMMonthEligible));
/*      */     }
/* 4026 */     if (FCode.equalsIgnoreCase("lPQuaPCount"))
/*      */     {
/* 4028 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPQuaPCount));
/*      */     }
/* 4030 */     if (FCode.equalsIgnoreCase("lPQuaFYCSum"))
/*      */     {
/* 4032 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPQuaFYCSum));
/*      */     }
/* 4034 */     if (FCode.equalsIgnoreCase("b12LPPCount"))
/*      */     {
/* 4036 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.b12LPPCount));
/*      */     }
/* 4038 */     if (FCode.equalsIgnoreCase("b12LPNAFYCSum"))
/*      */     {
/* 4040 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.b12LPNAFYCSum));
/*      */     }
/* 4042 */     if (FCode.equalsIgnoreCase("wSMMonAFYC"))
/*      */     {
/* 4044 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.wSMMonAFYC));
/*      */     }
/* 4046 */     if (FCode.equalsIgnoreCase("wSMTwoMonAFYC"))
/*      */     {
/* 4048 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.wSMTwoMonAFYC));
/*      */     }
/* 4050 */     if (FCode.equalsIgnoreCase("wSMB6AFYC"))
/*      */     {
/* 4052 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.wSMB6AFYC));
/*      */     }
/* 4054 */     if (FCode.equalsIgnoreCase("wSMB6PCount"))
/*      */     {
/* 4056 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.wSMB6PCount));
/*      */     }
/* 4058 */     if (FCode.equalsIgnoreCase("netLiveLPCount"))
/*      */     {
/* 4060 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.netLiveLPCount));
/*      */     }
/* 4062 */     if (FCode.equalsIgnoreCase("netComLPCount"))
/*      */     {
/* 4064 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.netComLPCount));
/*      */     }
/* 4066 */     if (FCode.equalsIgnoreCase("wSMTwoMonPCount"))
/*      */     {
/* 4068 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.wSMTwoMonPCount));
/*      */     }
/* 4070 */     if (FCode.equalsIgnoreCase("lPAllNAFYC"))
/*      */     {
/* 4072 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPAllNAFYC));
/*      */     }
/* 4074 */     if (FCode.equalsIgnoreCase("lPAllPCount"))
/*      */     {
/* 4076 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lPAllPCount));
/*      */     }
/* 4078 */     if (FCode.equalsIgnoreCase("monPerSAFYP"))
/*      */     {
/* 4080 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.monPerSAFYP));
/*      */     }
/* 4082 */     if (FCode.equalsIgnoreCase("tSRThrMonSAFYP"))
/*      */     {
/* 4084 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.tSRThrMonSAFYP));
/*      */     }
/* 4086 */     if (FCode.equalsIgnoreCase("tLThrMonPerSAFYP"))
/*      */     {
/* 4088 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.tLThrMonPerSAFYP));
/*      */     }
/* 4090 */     if (FCode.equalsIgnoreCase("monSubsistCnt"))
/*      */     {
/* 4092 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.monSubsistCnt));
/*      */     }
/* 4094 */     if (FCode.equalsIgnoreCase("thrMonSubsistCnt"))
/*      */     {
/* 4096 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.thrMonSubsistCnt));
/*      */     }
/* 4098 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 4100 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/* 4102 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 4104 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 4106 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 4108 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 4110 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 4112 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 4114 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 4116 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 4118 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 4120 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 4122 */     if (FCode.equalsIgnoreCase("assessMonth"))
/*      */     {
/* 4124 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.assessMonth));
/*      */     }
/* 4126 */     if (FCode.equalsIgnoreCase("branchAttr"))
/*      */     {
/* 4128 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchAttr));
/*      */     }
/* 4130 */     if (FCode.equalsIgnoreCase("agentGrade"))
/*      */     {
/* 4132 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGrade));
/*      */     }
/* 4134 */     if (FCode.equalsIgnoreCase("clubPromBonus"))
/*      */     {
/* 4136 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clubPromBonus));
/*      */     }
/* 4138 */     if (FCode.equalsIgnoreCase("clubGradeBonus"))
/*      */     {
/* 4140 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clubGradeBonus));
/*      */     }
/* 4142 */     if (FCode.equalsIgnoreCase("clubAssisBonus"))
/*      */     {
/* 4144 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clubAssisBonus));
/*      */     }
/* 4146 */     if (FCode.equalsIgnoreCase("clubSpecBonus"))
/*      */     {
/* 4148 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clubSpecBonus));
/*      */     }
/* 4150 */     if (FCode.equalsIgnoreCase("adddedMoney"))
/*      */     {
/* 4152 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.adddedMoney));
/*      */     }
/* 4154 */     if (FCode.equalsIgnoreCase("lastMoney"))
/*      */     {
/* 4156 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lastMoney));
/*      */     }
/* 4158 */     if (FCode.equalsIgnoreCase("shouldMoney"))
/*      */     {
/* 4160 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.shouldMoney));
/*      */     }
/* 4162 */     if (FCode.equalsIgnoreCase("businessTax"))
/*      */     {
/* 4164 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.businessTax));
/*      */     }
/* 4166 */     if (FCode.equalsIgnoreCase("eduTax"))
/*      */     {
/* 4168 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.eduTax));
/*      */     }
/* 4170 */     if (FCode.equalsIgnoreCase("buildTax"))
/*      */     {
/* 4172 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.buildTax));
/*      */     }
/* 4174 */     if (FCode.equalsIgnoreCase("busiCharge"))
/*      */     {
/* 4176 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.busiCharge));
/*      */     }
/* 4178 */     if (FCode.equalsIgnoreCase("incomeTax"))
/*      */     {
/* 4180 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.incomeTax));
/*      */     }
/* 4182 */     if (FCode.equalsIgnoreCase("sumMoney"))
/*      */     {
/* 4184 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sumMoney));
/*      */     }
/* 4186 */     if (FCode.equalsIgnoreCase("afterTaxMoney"))
/*      */     {
/* 4188 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.afterTaxMoney));
/*      */     }
/* 4190 */     if (FCode.equalsIgnoreCase("operInCome"))
/*      */     {
/* 4192 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operInCome));
/*      */     }
/* 4194 */     if (FCode.equalsIgnoreCase("t21"))
/*      */     {
/* 4196 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t21));
/*      */     }
/* 4198 */     if (FCode.equalsIgnoreCase("t22"))
/*      */     {
/* 4200 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t22));
/*      */     }
/* 4202 */     if (FCode.equalsIgnoreCase("t23"))
/*      */     {
/* 4204 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t23));
/*      */     }
/* 4206 */     if (FCode.equalsIgnoreCase("t24"))
/*      */     {
/* 4208 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t24));
/*      */     }
/* 4210 */     if (FCode.equalsIgnoreCase("t25"))
/*      */     {
/* 4212 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t25));
/*      */     }
/* 4214 */     if (strReturn.equals(""))
/*      */     {
/* 4216 */       strReturn = "null";
/*      */     }
/*      */ 
/* 4219 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 4226 */     String strFieldValue = "";
/* 4227 */     switch (nFieldIndex) {
/*      */     case 0:
/* 4229 */       strFieldValue = StrTool.GBKToUnicode(this.indexCalNo);
/* 4230 */       break;
/*      */     case 1:
/* 4232 */       strFieldValue = StrTool.GBKToUnicode(this.indexType);
/* 4233 */       break;
/*      */     case 2:
/* 4235 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/* 4236 */       break;
/*      */     case 3:
/* 4238 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup);
/* 4239 */       break;
/*      */     case 4:
/* 4241 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 4242 */       break;
/*      */     case 5:
/* 4244 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/* 4245 */       break;
/*      */     case 6:
/* 4247 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd()));
/* 4248 */       break;
/*      */     case 7:
/* 4250 */       strFieldValue = String.valueOf(this.quaBgnMark);
/* 4251 */       break;
/*      */     case 8:
/* 4253 */       strFieldValue = String.valueOf(this.serverMonths);
/* 4254 */       break;
/*      */     case 9:
/* 4256 */       strFieldValue = String.valueOf(this.postMonths);
/* 4257 */       break;
/*      */     case 10:
/* 4259 */       strFieldValue = String.valueOf(this.indMonthFYC);
/* 4260 */       break;
/*      */     case 11:
/* 4262 */       strFieldValue = String.valueOf(this.indMonthSYC);
/* 4263 */       break;
/*      */     case 12:
/* 4265 */       strFieldValue = String.valueOf(this.indMonSignFYC);
/* 4266 */       break;
/*      */     case 13:
/* 4268 */       strFieldValue = String.valueOf(this.indMonSignAFYC);
/* 4269 */       break;
/*      */     case 14:
/* 4271 */       strFieldValue = String.valueOf(this.indMonSignNAFYC);
/* 4272 */       break;
/*      */     case 15:
/* 4274 */       strFieldValue = String.valueOf(this.grpMonSignNAFYC);
/* 4275 */       break;
/*      */     case 16:
/* 4277 */       strFieldValue = String.valueOf(this.monPolCnt);
/* 4278 */       break;
/*      */     case 17:
/* 4280 */       strFieldValue = String.valueOf(this.montCustCnt);
/* 4281 */       break;
/*      */     case 18:
/* 4283 */       strFieldValue = String.valueOf(this.indMonPCount);
/* 4284 */       break;
/*      */     case 19:
/* 4286 */       strFieldValue = String.valueOf(this.sMmonPolContin);
/* 4287 */       break;
/*      */     case 20:
/* 4289 */       strFieldValue = String.valueOf(this.sMmonProduct);
/* 4290 */       break;
/*      */     case 21:
/* 4292 */       strFieldValue = String.valueOf(this.sMworkMon);
/* 4293 */       break;
/*      */     case 22:
/* 4295 */       strFieldValue = String.valueOf(this.monPCount);
/* 4296 */       break;
/*      */     case 23:
/* 4298 */       strFieldValue = String.valueOf(this.wSMMonPCount);
/* 4299 */       break;
/*      */     case 24:
/* 4301 */       strFieldValue = String.valueOf(this.lPMonForSMMP);
/* 4302 */       break;
/*      */     case 25:
/* 4304 */       strFieldValue = String.valueOf(this.lPMonForAMMP);
/* 4305 */       break;
/*      */     case 26:
/* 4307 */       strFieldValue = String.valueOf(this.lPpolContinute);
/* 4308 */       break;
/*      */     case 27:
/* 4310 */       strFieldValue = String.valueOf(this.monEligFLPCnt);
/* 4311 */       break;
/*      */     case 28:
/* 4313 */       strFieldValue = String.valueOf(this.tSRmonAFYP);
/* 4314 */       break;
/*      */     case 29:
/* 4316 */       strFieldValue = String.valueOf(this.tSRmonDedAFYP);
/* 4317 */       break;
/*      */     case 30:
/* 4319 */       strFieldValue = String.valueOf(this.tSRmonCompAFYP);
/* 4320 */       break;
/*      */     case 31:
/* 4322 */       strFieldValue = String.valueOf(this.tSRMonWorkDays);
/* 4323 */       break;
/*      */     case 32:
/* 4325 */       strFieldValue = String.valueOf(this.monManPower);
/* 4326 */       break;
/*      */     case 33:
/* 4328 */       strFieldValue = String.valueOf(this.monManCount);
/* 4329 */       break;
/*      */     case 34:
/* 4331 */       strFieldValue = String.valueOf(this.monSAFYPSum);
/* 4332 */       break;
/*      */     case 35:
/* 4334 */       strFieldValue = String.valueOf(this.monTLGrpSAFYPSum);
/* 4335 */       break;
/*      */     case 36:
/* 4337 */       strFieldValue = String.valueOf(this.indYearNAFYC);
/* 4338 */       break;
/*      */     case 37:
/* 4340 */       strFieldValue = String.valueOf(this.b12IndEffectAFYC);
/* 4341 */       break;
/*      */     case 38:
/* 4343 */       strFieldValue = String.valueOf(this.b12IndAllAFYC);
/* 4344 */       break;
/*      */     case 39:
/* 4346 */       strFieldValue = String.valueOf(this.b24IndEffectAFYC);
/* 4347 */       break;
/*      */     case 40:
/* 4349 */       strFieldValue = String.valueOf(this.b24IndAllAFYC);
/* 4350 */       break;
/*      */     case 41:
/* 4352 */       strFieldValue = String.valueOf(this.indQutFYC);
/* 4353 */       break;
/*      */     case 42:
/* 4355 */       strFieldValue = String.valueOf(this.lPproductivity);
/* 4356 */       break;
/*      */     case 43:
/* 4358 */       strFieldValue = String.valueOf(this.lPPPRate);
/* 4359 */       break;
/*      */     case 44:
/* 4361 */       strFieldValue = String.valueOf(this.lPPPBonus);
/* 4362 */       break;
/*      */     case 45:
/* 4364 */       strFieldValue = String.valueOf(this.lPFincSubsidy);
/* 4365 */       break;
/*      */     case 46:
/* 4367 */       strFieldValue = String.valueOf(this.subsidyRate);
/* 4368 */       break;
/*      */     case 47:
/* 4370 */       strFieldValue = String.valueOf(this.b12TeamNAFYC);
/* 4371 */       break;
/*      */     case 48:
/* 4373 */       strFieldValue = String.valueOf(this.sMOverride);
/* 4374 */       break;
/*      */     case 49:
/* 4376 */       strFieldValue = String.valueOf(this.teamMonAvgPCount);
/* 4377 */       break;
/*      */     case 50:
/* 4379 */       strFieldValue = String.valueOf(this.sMBasicSalary);
/* 4380 */       break;
/*      */     case 51:
/* 4382 */       strFieldValue = String.valueOf(this.sMproductivity);
/* 4383 */       break;
/*      */     case 52:
/* 4385 */       strFieldValue = String.valueOf(this.sMpolContinute);
/* 4386 */       break;
/*      */     case 53:
/* 4388 */       strFieldValue = String.valueOf(this.sMPPRate);
/* 4389 */       break;
/*      */     case 54:
/* 4391 */       strFieldValue = String.valueOf(this.sMPPBonus);
/* 4392 */       break;
/*      */     case 55:
/* 4394 */       strFieldValue = String.valueOf(this.b24TeamEffectAFYC);
/* 4395 */       break;
/*      */     case 56:
/* 4397 */       strFieldValue = String.valueOf(this.b24TeamAllAFYC);
/* 4398 */       break;
/*      */     case 57:
/* 4400 */       strFieldValue = String.valueOf(this.teamQutPremSum);
/* 4401 */       break;
/*      */     case 58:
/* 4403 */       strFieldValue = String.valueOf(this.sMRRBonus);
/* 4404 */       break;
/*      */     case 59:
/* 4406 */       strFieldValue = String.valueOf(this.sMManPowerDBonus);
/* 4407 */       break;
/*      */     case 60:
/* 4409 */       strFieldValue = String.valueOf(this.lPB12ForMPDBonus);
/* 4410 */       break;
/*      */     case 61:
/* 4412 */       strFieldValue = String.valueOf(this.sMUsualALLCSum);
/* 4413 */       break;
/*      */     case 62:
/* 4415 */       strFieldValue = String.valueOf(this.aMBasicSalary);
/* 4416 */       break;
/*      */     case 63:
/* 4418 */       strFieldValue = String.valueOf(this.aMproductivity);
/* 4419 */       break;
/*      */     case 64:
/* 4421 */       strFieldValue = String.valueOf(this.aMpolContinute);
/* 4422 */       break;
/*      */     case 65:
/* 4424 */       strFieldValue = String.valueOf(this.aMPPRate);
/* 4425 */       break;
/*      */     case 66:
/* 4427 */       strFieldValue = String.valueOf(this.aMPPBonus);
/* 4428 */       break;
/*      */     case 67:
/* 4430 */       strFieldValue = String.valueOf(this.b12DepNAFYC);
/* 4431 */       break;
/*      */     case 68:
/* 4433 */       strFieldValue = String.valueOf(this.aMOverride);
/* 4434 */       break;
/*      */     case 69:
/* 4436 */       strFieldValue = String.valueOf(this.depMonAvgPCount);
/* 4437 */       break;
/*      */     case 70:
/* 4439 */       strFieldValue = String.valueOf(this.depQutPremSum);
/* 4440 */       break;
/*      */     case 71:
/* 4442 */       strFieldValue = String.valueOf(this.aMRRBonus);
/* 4443 */       break;
/*      */     case 72:
/* 4445 */       strFieldValue = String.valueOf(this.aMManPowerDBonus);
/* 4446 */       break;
/*      */     case 73:
/* 4448 */       strFieldValue = String.valueOf(this.productGrowth);
/* 4449 */       break;
/*      */     case 74:
/* 4451 */       strFieldValue = String.valueOf(this.depQuaFYCSum);
/* 4452 */       break;
/*      */     case 75:
/* 4454 */       strFieldValue = String.valueOf(this.aMLiability);
/* 4455 */       break;
/*      */     case 76:
/* 4457 */       strFieldValue = String.valueOf(this.reviOpen);
/* 4458 */       break;
/*      */     case 77:
/* 4460 */       strFieldValue = String.valueOf(this.t1);
/* 4461 */       break;
/*      */     case 78:
/* 4463 */       strFieldValue = String.valueOf(this.t2);
/* 4464 */       break;
/*      */     case 79:
/* 4466 */       strFieldValue = String.valueOf(this.t3);
/* 4467 */       break;
/*      */     case 80:
/* 4469 */       strFieldValue = String.valueOf(this.t4);
/* 4470 */       break;
/*      */     case 81:
/* 4472 */       strFieldValue = String.valueOf(this.t5);
/* 4473 */       break;
/*      */     case 82:
/* 4475 */       strFieldValue = String.valueOf(this.t6);
/* 4476 */       break;
/*      */     case 83:
/* 4478 */       strFieldValue = String.valueOf(this.t7);
/* 4479 */       break;
/*      */     case 84:
/* 4481 */       strFieldValue = String.valueOf(this.t8);
/* 4482 */       break;
/*      */     case 85:
/* 4484 */       strFieldValue = String.valueOf(this.t9);
/* 4485 */       break;
/*      */     case 86:
/* 4487 */       strFieldValue = String.valueOf(this.t10);
/* 4488 */       break;
/*      */     case 87:
/* 4490 */       strFieldValue = String.valueOf(this.t11);
/* 4491 */       break;
/*      */     case 88:
/* 4493 */       strFieldValue = String.valueOf(this.t12);
/* 4494 */       break;
/*      */     case 89:
/* 4496 */       strFieldValue = String.valueOf(this.t13);
/* 4497 */       break;
/*      */     case 90:
/* 4499 */       strFieldValue = String.valueOf(this.t14);
/* 4500 */       break;
/*      */     case 91:
/* 4502 */       strFieldValue = String.valueOf(this.t15);
/* 4503 */       break;
/*      */     case 92:
/* 4505 */       strFieldValue = String.valueOf(this.t16);
/* 4506 */       break;
/*      */     case 93:
/* 4508 */       strFieldValue = String.valueOf(this.t17);
/* 4509 */       break;
/*      */     case 94:
/* 4511 */       strFieldValue = String.valueOf(this.t18);
/* 4512 */       break;
/*      */     case 95:
/* 4514 */       strFieldValue = String.valueOf(this.t20);
/* 4515 */       break;
/*      */     case 96:
/* 4517 */       strFieldValue = String.valueOf(this.t19);
/* 4518 */       break;
/*      */     case 97:
/* 4520 */       strFieldValue = String.valueOf(this.monthIndex);
/* 4521 */       break;
/*      */     case 98:
/* 4523 */       strFieldValue = String.valueOf(this.tMonthIndex);
/* 4524 */       break;
/*      */     case 99:
/* 4526 */       strFieldValue = String.valueOf(this.aSumIndex);
/* 4527 */       break;
/*      */     case 100:
/* 4529 */       strFieldValue = String.valueOf(this.wSMMonthEligible);
/* 4530 */       break;
/*      */     case 101:
/* 4532 */       strFieldValue = String.valueOf(this.lPQuaPCount);
/* 4533 */       break;
/*      */     case 102:
/* 4535 */       strFieldValue = String.valueOf(this.lPQuaFYCSum);
/* 4536 */       break;
/*      */     case 103:
/* 4538 */       strFieldValue = String.valueOf(this.b12LPPCount);
/* 4539 */       break;
/*      */     case 104:
/* 4541 */       strFieldValue = String.valueOf(this.b12LPNAFYCSum);
/* 4542 */       break;
/*      */     case 105:
/* 4544 */       strFieldValue = String.valueOf(this.wSMMonAFYC);
/* 4545 */       break;
/*      */     case 106:
/* 4547 */       strFieldValue = String.valueOf(this.wSMTwoMonAFYC);
/* 4548 */       break;
/*      */     case 107:
/* 4550 */       strFieldValue = String.valueOf(this.wSMB6AFYC);
/* 4551 */       break;
/*      */     case 108:
/* 4553 */       strFieldValue = String.valueOf(this.wSMB6PCount);
/* 4554 */       break;
/*      */     case 109:
/* 4556 */       strFieldValue = String.valueOf(this.netLiveLPCount);
/* 4557 */       break;
/*      */     case 110:
/* 4559 */       strFieldValue = String.valueOf(this.netComLPCount);
/* 4560 */       break;
/*      */     case 111:
/* 4562 */       strFieldValue = String.valueOf(this.wSMTwoMonPCount);
/* 4563 */       break;
/*      */     case 112:
/* 4565 */       strFieldValue = String.valueOf(this.lPAllNAFYC);
/* 4566 */       break;
/*      */     case 113:
/* 4568 */       strFieldValue = String.valueOf(this.lPAllPCount);
/* 4569 */       break;
/*      */     case 114:
/* 4571 */       strFieldValue = String.valueOf(this.monPerSAFYP);
/* 4572 */       break;
/*      */     case 115:
/* 4574 */       strFieldValue = String.valueOf(this.tSRThrMonSAFYP);
/* 4575 */       break;
/*      */     case 116:
/* 4577 */       strFieldValue = String.valueOf(this.tLThrMonPerSAFYP);
/* 4578 */       break;
/*      */     case 117:
/* 4580 */       strFieldValue = String.valueOf(this.monSubsistCnt);
/* 4581 */       break;
/*      */     case 118:
/* 4583 */       strFieldValue = String.valueOf(this.thrMonSubsistCnt);
/* 4584 */       break;
/*      */     case 119:
/* 4586 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 4587 */       break;
/*      */     case 120:
/* 4589 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 4590 */       break;
/*      */     case 121:
/* 4592 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 4593 */       break;
/*      */     case 122:
/* 4595 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 4596 */       break;
/*      */     case 123:
/* 4598 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 4599 */       break;
/*      */     case 124:
/* 4601 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 4602 */       break;
/*      */     case 125:
/* 4604 */       strFieldValue = StrTool.GBKToUnicode(this.assessMonth);
/* 4605 */       break;
/*      */     case 126:
/* 4607 */       strFieldValue = StrTool.GBKToUnicode(this.branchAttr);
/* 4608 */       break;
/*      */     case 127:
/* 4610 */       strFieldValue = StrTool.GBKToUnicode(this.agentGrade);
/* 4611 */       break;
/*      */     case 128:
/* 4613 */       strFieldValue = String.valueOf(this.clubPromBonus);
/* 4614 */       break;
/*      */     case 129:
/* 4616 */       strFieldValue = String.valueOf(this.clubGradeBonus);
/* 4617 */       break;
/*      */     case 130:
/* 4619 */       strFieldValue = String.valueOf(this.clubAssisBonus);
/* 4620 */       break;
/*      */     case 131:
/* 4622 */       strFieldValue = String.valueOf(this.clubSpecBonus);
/* 4623 */       break;
/*      */     case 132:
/* 4625 */       strFieldValue = String.valueOf(this.adddedMoney);
/* 4626 */       break;
/*      */     case 133:
/* 4628 */       strFieldValue = String.valueOf(this.lastMoney);
/* 4629 */       break;
/*      */     case 134:
/* 4631 */       strFieldValue = String.valueOf(this.shouldMoney);
/* 4632 */       break;
/*      */     case 135:
/* 4634 */       strFieldValue = String.valueOf(this.businessTax);
/* 4635 */       break;
/*      */     case 136:
/* 4637 */       strFieldValue = String.valueOf(this.eduTax);
/* 4638 */       break;
/*      */     case 137:
/* 4640 */       strFieldValue = String.valueOf(this.buildTax);
/* 4641 */       break;
/*      */     case 138:
/* 4643 */       strFieldValue = String.valueOf(this.busiCharge);
/* 4644 */       break;
/*      */     case 139:
/* 4646 */       strFieldValue = String.valueOf(this.incomeTax);
/* 4647 */       break;
/*      */     case 140:
/* 4649 */       strFieldValue = String.valueOf(this.sumMoney);
/* 4650 */       break;
/*      */     case 141:
/* 4652 */       strFieldValue = String.valueOf(this.afterTaxMoney);
/* 4653 */       break;
/*      */     case 142:
/* 4655 */       strFieldValue = String.valueOf(this.operInCome);
/* 4656 */       break;
/*      */     case 143:
/* 4658 */       strFieldValue = String.valueOf(this.t21);
/* 4659 */       break;
/*      */     case 144:
/* 4661 */       strFieldValue = String.valueOf(this.t22);
/* 4662 */       break;
/*      */     case 145:
/* 4664 */       strFieldValue = String.valueOf(this.t23);
/* 4665 */       break;
/*      */     case 146:
/* 4667 */       strFieldValue = String.valueOf(this.t24);
/* 4668 */       break;
/*      */     case 147:
/* 4670 */       strFieldValue = String.valueOf(this.t25);
/* 4671 */       break;
/*      */     default:
/* 4673 */       strFieldValue = "";
/*      */     }
/* 4675 */     if (strFieldValue.equals("")) {
/* 4676 */       strFieldValue = "null";
/*      */     }
/* 4678 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 4684 */     if (StrTool.cTrim(FCode).equals("")) {
/* 4685 */       return false;
/*      */     }
/* 4687 */     if (FCode.equalsIgnoreCase("indexCalNo"))
/*      */     {
/* 4689 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4691 */         this.indexCalNo = FValue.trim();
/*      */       }
/*      */       else
/* 4694 */         this.indexCalNo = null;
/*      */     }
/* 4696 */     if (FCode.equalsIgnoreCase("indexType"))
/*      */     {
/* 4698 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4700 */         this.indexType = FValue.trim();
/*      */       }
/*      */       else
/* 4703 */         this.indexType = null;
/*      */     }
/* 4705 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 4707 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4709 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/* 4712 */         this.agentCode = null;
/*      */     }
/* 4714 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*      */     {
/* 4716 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4718 */         this.agentGroup = FValue.trim();
/*      */       }
/*      */       else
/* 4721 */         this.agentGroup = null;
/*      */     }
/* 4723 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 4725 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4727 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 4730 */         this.manageCom = null;
/*      */     }
/* 4732 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/* 4734 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4736 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4739 */         this.startDate = null;
/*      */     }
/* 4741 */     if (FCode.equalsIgnoreCase("startEnd"))
/*      */     {
/* 4743 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4745 */         this.startEnd = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 4748 */         this.startEnd = null;
/*      */     }
/* 4750 */     if (FCode.equalsIgnoreCase("quaBgnMark"))
/*      */     {
/* 4752 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4754 */         Integer tInteger = new Integer(FValue);
/* 4755 */         int i = tInteger.intValue();
/* 4756 */         this.quaBgnMark = i;
/*      */       }
/*      */     }
/* 4759 */     if (FCode.equalsIgnoreCase("serverMonths"))
/*      */     {
/* 4761 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4763 */         Integer tInteger = new Integer(FValue);
/* 4764 */         int i = tInteger.intValue();
/* 4765 */         this.serverMonths = i;
/*      */       }
/*      */     }
/* 4768 */     if (FCode.equalsIgnoreCase("postMonths"))
/*      */     {
/* 4770 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4772 */         Integer tInteger = new Integer(FValue);
/* 4773 */         int i = tInteger.intValue();
/* 4774 */         this.postMonths = i;
/*      */       }
/*      */     }
/* 4777 */     if (FCode.equalsIgnoreCase("indMonthFYC"))
/*      */     {
/* 4779 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4781 */         Double tDouble = new Double(FValue);
/* 4782 */         double d = tDouble.doubleValue();
/* 4783 */         this.indMonthFYC = d;
/*      */       }
/*      */     }
/* 4786 */     if (FCode.equalsIgnoreCase("indMonthSYC"))
/*      */     {
/* 4788 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4790 */         Double tDouble = new Double(FValue);
/* 4791 */         double d = tDouble.doubleValue();
/* 4792 */         this.indMonthSYC = d;
/*      */       }
/*      */     }
/* 4795 */     if (FCode.equalsIgnoreCase("indMonSignFYC"))
/*      */     {
/* 4797 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4799 */         Double tDouble = new Double(FValue);
/* 4800 */         double d = tDouble.doubleValue();
/* 4801 */         this.indMonSignFYC = d;
/*      */       }
/*      */     }
/* 4804 */     if (FCode.equalsIgnoreCase("indMonSignAFYC"))
/*      */     {
/* 4806 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4808 */         Double tDouble = new Double(FValue);
/* 4809 */         double d = tDouble.doubleValue();
/* 4810 */         this.indMonSignAFYC = d;
/*      */       }
/*      */     }
/* 4813 */     if (FCode.equalsIgnoreCase("indMonSignNAFYC"))
/*      */     {
/* 4815 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4817 */         Double tDouble = new Double(FValue);
/* 4818 */         double d = tDouble.doubleValue();
/* 4819 */         this.indMonSignNAFYC = d;
/*      */       }
/*      */     }
/* 4822 */     if (FCode.equalsIgnoreCase("grpMonSignNAFYC"))
/*      */     {
/* 4824 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4826 */         Double tDouble = new Double(FValue);
/* 4827 */         double d = tDouble.doubleValue();
/* 4828 */         this.grpMonSignNAFYC = d;
/*      */       }
/*      */     }
/* 4831 */     if (FCode.equalsIgnoreCase("monPolCnt"))
/*      */     {
/* 4833 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4835 */         Double tDouble = new Double(FValue);
/* 4836 */         double d = tDouble.doubleValue();
/* 4837 */         this.monPolCnt = d;
/*      */       }
/*      */     }
/* 4840 */     if (FCode.equalsIgnoreCase("montCustCnt"))
/*      */     {
/* 4842 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4844 */         Double tDouble = new Double(FValue);
/* 4845 */         double d = tDouble.doubleValue();
/* 4846 */         this.montCustCnt = d;
/*      */       }
/*      */     }
/* 4849 */     if (FCode.equalsIgnoreCase("indMonPCount"))
/*      */     {
/* 4851 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4853 */         Double tDouble = new Double(FValue);
/* 4854 */         double d = tDouble.doubleValue();
/* 4855 */         this.indMonPCount = d;
/*      */       }
/*      */     }
/* 4858 */     if (FCode.equalsIgnoreCase("sMmonPolContin"))
/*      */     {
/* 4860 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4862 */         Double tDouble = new Double(FValue);
/* 4863 */         double d = tDouble.doubleValue();
/* 4864 */         this.sMmonPolContin = d;
/*      */       }
/*      */     }
/* 4867 */     if (FCode.equalsIgnoreCase("sMmonProduct"))
/*      */     {
/* 4869 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4871 */         Double tDouble = new Double(FValue);
/* 4872 */         double d = tDouble.doubleValue();
/* 4873 */         this.sMmonProduct = d;
/*      */       }
/*      */     }
/* 4876 */     if (FCode.equalsIgnoreCase("sMworkMon"))
/*      */     {
/* 4878 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4880 */         Double tDouble = new Double(FValue);
/* 4881 */         double d = tDouble.doubleValue();
/* 4882 */         this.sMworkMon = d;
/*      */       }
/*      */     }
/* 4885 */     if (FCode.equalsIgnoreCase("monPCount"))
/*      */     {
/* 4887 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4889 */         Double tDouble = new Double(FValue);
/* 4890 */         double d = tDouble.doubleValue();
/* 4891 */         this.monPCount = d;
/*      */       }
/*      */     }
/* 4894 */     if (FCode.equalsIgnoreCase("wSMMonPCount"))
/*      */     {
/* 4896 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4898 */         Double tDouble = new Double(FValue);
/* 4899 */         double d = tDouble.doubleValue();
/* 4900 */         this.wSMMonPCount = d;
/*      */       }
/*      */     }
/* 4903 */     if (FCode.equalsIgnoreCase("lPMonForSMMP"))
/*      */     {
/* 4905 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4907 */         Double tDouble = new Double(FValue);
/* 4908 */         double d = tDouble.doubleValue();
/* 4909 */         this.lPMonForSMMP = d;
/*      */       }
/*      */     }
/* 4912 */     if (FCode.equalsIgnoreCase("lPMonForAMMP"))
/*      */     {
/* 4914 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4916 */         Double tDouble = new Double(FValue);
/* 4917 */         double d = tDouble.doubleValue();
/* 4918 */         this.lPMonForAMMP = d;
/*      */       }
/*      */     }
/* 4921 */     if (FCode.equalsIgnoreCase("lPpolContinute"))
/*      */     {
/* 4923 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4925 */         Double tDouble = new Double(FValue);
/* 4926 */         double d = tDouble.doubleValue();
/* 4927 */         this.lPpolContinute = d;
/*      */       }
/*      */     }
/* 4930 */     if (FCode.equalsIgnoreCase("monEligFLPCnt"))
/*      */     {
/* 4932 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4934 */         Double tDouble = new Double(FValue);
/* 4935 */         double d = tDouble.doubleValue();
/* 4936 */         this.monEligFLPCnt = d;
/*      */       }
/*      */     }
/* 4939 */     if (FCode.equalsIgnoreCase("tSRmonAFYP"))
/*      */     {
/* 4941 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4943 */         Double tDouble = new Double(FValue);
/* 4944 */         double d = tDouble.doubleValue();
/* 4945 */         this.tSRmonAFYP = d;
/*      */       }
/*      */     }
/* 4948 */     if (FCode.equalsIgnoreCase("tSRmonDedAFYP"))
/*      */     {
/* 4950 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4952 */         Double tDouble = new Double(FValue);
/* 4953 */         double d = tDouble.doubleValue();
/* 4954 */         this.tSRmonDedAFYP = d;
/*      */       }
/*      */     }
/* 4957 */     if (FCode.equalsIgnoreCase("tSRmonCompAFYP"))
/*      */     {
/* 4959 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4961 */         Double tDouble = new Double(FValue);
/* 4962 */         double d = tDouble.doubleValue();
/* 4963 */         this.tSRmonCompAFYP = d;
/*      */       }
/*      */     }
/* 4966 */     if (FCode.equalsIgnoreCase("tSRMonWorkDays"))
/*      */     {
/* 4968 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4970 */         Double tDouble = new Double(FValue);
/* 4971 */         double d = tDouble.doubleValue();
/* 4972 */         this.tSRMonWorkDays = d;
/*      */       }
/*      */     }
/* 4975 */     if (FCode.equalsIgnoreCase("monManPower"))
/*      */     {
/* 4977 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4979 */         Double tDouble = new Double(FValue);
/* 4980 */         double d = tDouble.doubleValue();
/* 4981 */         this.monManPower = d;
/*      */       }
/*      */     }
/* 4984 */     if (FCode.equalsIgnoreCase("monManCount"))
/*      */     {
/* 4986 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4988 */         Double tDouble = new Double(FValue);
/* 4989 */         double d = tDouble.doubleValue();
/* 4990 */         this.monManCount = d;
/*      */       }
/*      */     }
/* 4993 */     if (FCode.equalsIgnoreCase("monSAFYPSum"))
/*      */     {
/* 4995 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 4997 */         Double tDouble = new Double(FValue);
/* 4998 */         double d = tDouble.doubleValue();
/* 4999 */         this.monSAFYPSum = d;
/*      */       }
/*      */     }
/* 5002 */     if (FCode.equalsIgnoreCase("monTLGrpSAFYPSum"))
/*      */     {
/* 5004 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5006 */         Double tDouble = new Double(FValue);
/* 5007 */         double d = tDouble.doubleValue();
/* 5008 */         this.monTLGrpSAFYPSum = d;
/*      */       }
/*      */     }
/* 5011 */     if (FCode.equalsIgnoreCase("indYearNAFYC"))
/*      */     {
/* 5013 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5015 */         Double tDouble = new Double(FValue);
/* 5016 */         double d = tDouble.doubleValue();
/* 5017 */         this.indYearNAFYC = d;
/*      */       }
/*      */     }
/* 5020 */     if (FCode.equalsIgnoreCase("b12IndEffectAFYC"))
/*      */     {
/* 5022 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5024 */         Double tDouble = new Double(FValue);
/* 5025 */         double d = tDouble.doubleValue();
/* 5026 */         this.b12IndEffectAFYC = d;
/*      */       }
/*      */     }
/* 5029 */     if (FCode.equalsIgnoreCase("b12IndAllAFYC"))
/*      */     {
/* 5031 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5033 */         Double tDouble = new Double(FValue);
/* 5034 */         double d = tDouble.doubleValue();
/* 5035 */         this.b12IndAllAFYC = d;
/*      */       }
/*      */     }
/* 5038 */     if (FCode.equalsIgnoreCase("b24IndEffectAFYC"))
/*      */     {
/* 5040 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5042 */         Double tDouble = new Double(FValue);
/* 5043 */         double d = tDouble.doubleValue();
/* 5044 */         this.b24IndEffectAFYC = d;
/*      */       }
/*      */     }
/* 5047 */     if (FCode.equalsIgnoreCase("b24IndAllAFYC"))
/*      */     {
/* 5049 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5051 */         Double tDouble = new Double(FValue);
/* 5052 */         double d = tDouble.doubleValue();
/* 5053 */         this.b24IndAllAFYC = d;
/*      */       }
/*      */     }
/* 5056 */     if (FCode.equalsIgnoreCase("indQutFYC"))
/*      */     {
/* 5058 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5060 */         Double tDouble = new Double(FValue);
/* 5061 */         double d = tDouble.doubleValue();
/* 5062 */         this.indQutFYC = d;
/*      */       }
/*      */     }
/* 5065 */     if (FCode.equalsIgnoreCase("lPproductivity"))
/*      */     {
/* 5067 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5069 */         Double tDouble = new Double(FValue);
/* 5070 */         double d = tDouble.doubleValue();
/* 5071 */         this.lPproductivity = d;
/*      */       }
/*      */     }
/* 5074 */     if (FCode.equalsIgnoreCase("lPPPRate"))
/*      */     {
/* 5076 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5078 */         Double tDouble = new Double(FValue);
/* 5079 */         double d = tDouble.doubleValue();
/* 5080 */         this.lPPPRate = d;
/*      */       }
/*      */     }
/* 5083 */     if (FCode.equalsIgnoreCase("lPPPBonus"))
/*      */     {
/* 5085 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5087 */         Double tDouble = new Double(FValue);
/* 5088 */         double d = tDouble.doubleValue();
/* 5089 */         this.lPPPBonus = d;
/*      */       }
/*      */     }
/* 5092 */     if (FCode.equalsIgnoreCase("lPFincSubsidy"))
/*      */     {
/* 5094 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5096 */         Double tDouble = new Double(FValue);
/* 5097 */         double d = tDouble.doubleValue();
/* 5098 */         this.lPFincSubsidy = d;
/*      */       }
/*      */     }
/* 5101 */     if (FCode.equalsIgnoreCase("subsidyRate"))
/*      */     {
/* 5103 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5105 */         Double tDouble = new Double(FValue);
/* 5106 */         double d = tDouble.doubleValue();
/* 5107 */         this.subsidyRate = d;
/*      */       }
/*      */     }
/* 5110 */     if (FCode.equalsIgnoreCase("b12TeamNAFYC"))
/*      */     {
/* 5112 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5114 */         Double tDouble = new Double(FValue);
/* 5115 */         double d = tDouble.doubleValue();
/* 5116 */         this.b12TeamNAFYC = d;
/*      */       }
/*      */     }
/* 5119 */     if (FCode.equalsIgnoreCase("sMOverride"))
/*      */     {
/* 5121 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5123 */         Double tDouble = new Double(FValue);
/* 5124 */         double d = tDouble.doubleValue();
/* 5125 */         this.sMOverride = d;
/*      */       }
/*      */     }
/* 5128 */     if (FCode.equalsIgnoreCase("teamMonAvgPCount"))
/*      */     {
/* 5130 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5132 */         Double tDouble = new Double(FValue);
/* 5133 */         double d = tDouble.doubleValue();
/* 5134 */         this.teamMonAvgPCount = d;
/*      */       }
/*      */     }
/* 5137 */     if (FCode.equalsIgnoreCase("sMBasicSalary"))
/*      */     {
/* 5139 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5141 */         Double tDouble = new Double(FValue);
/* 5142 */         double d = tDouble.doubleValue();
/* 5143 */         this.sMBasicSalary = d;
/*      */       }
/*      */     }
/* 5146 */     if (FCode.equalsIgnoreCase("sMproductivity"))
/*      */     {
/* 5148 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5150 */         Double tDouble = new Double(FValue);
/* 5151 */         double d = tDouble.doubleValue();
/* 5152 */         this.sMproductivity = d;
/*      */       }
/*      */     }
/* 5155 */     if (FCode.equalsIgnoreCase("sMpolContinute"))
/*      */     {
/* 5157 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5159 */         Double tDouble = new Double(FValue);
/* 5160 */         double d = tDouble.doubleValue();
/* 5161 */         this.sMpolContinute = d;
/*      */       }
/*      */     }
/* 5164 */     if (FCode.equalsIgnoreCase("sMPPRate"))
/*      */     {
/* 5166 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5168 */         Double tDouble = new Double(FValue);
/* 5169 */         double d = tDouble.doubleValue();
/* 5170 */         this.sMPPRate = d;
/*      */       }
/*      */     }
/* 5173 */     if (FCode.equalsIgnoreCase("sMPPBonus"))
/*      */     {
/* 5175 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5177 */         Double tDouble = new Double(FValue);
/* 5178 */         double d = tDouble.doubleValue();
/* 5179 */         this.sMPPBonus = d;
/*      */       }
/*      */     }
/* 5182 */     if (FCode.equalsIgnoreCase("b24TeamEffectAFYC"))
/*      */     {
/* 5184 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5186 */         Double tDouble = new Double(FValue);
/* 5187 */         double d = tDouble.doubleValue();
/* 5188 */         this.b24TeamEffectAFYC = d;
/*      */       }
/*      */     }
/* 5191 */     if (FCode.equalsIgnoreCase("b24TeamAllAFYC"))
/*      */     {
/* 5193 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5195 */         Double tDouble = new Double(FValue);
/* 5196 */         double d = tDouble.doubleValue();
/* 5197 */         this.b24TeamAllAFYC = d;
/*      */       }
/*      */     }
/* 5200 */     if (FCode.equalsIgnoreCase("teamQutPremSum"))
/*      */     {
/* 5202 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5204 */         Double tDouble = new Double(FValue);
/* 5205 */         double d = tDouble.doubleValue();
/* 5206 */         this.teamQutPremSum = d;
/*      */       }
/*      */     }
/* 5209 */     if (FCode.equalsIgnoreCase("sMRRBonus"))
/*      */     {
/* 5211 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5213 */         Double tDouble = new Double(FValue);
/* 5214 */         double d = tDouble.doubleValue();
/* 5215 */         this.sMRRBonus = d;
/*      */       }
/*      */     }
/* 5218 */     if (FCode.equalsIgnoreCase("sMManPowerDBonus"))
/*      */     {
/* 5220 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5222 */         Double tDouble = new Double(FValue);
/* 5223 */         double d = tDouble.doubleValue();
/* 5224 */         this.sMManPowerDBonus = d;
/*      */       }
/*      */     }
/* 5227 */     if (FCode.equalsIgnoreCase("lPB12ForMPDBonus"))
/*      */     {
/* 5229 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5231 */         Double tDouble = new Double(FValue);
/* 5232 */         double d = tDouble.doubleValue();
/* 5233 */         this.lPB12ForMPDBonus = d;
/*      */       }
/*      */     }
/* 5236 */     if (FCode.equalsIgnoreCase("sMUsualALLCSum"))
/*      */     {
/* 5238 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5240 */         Double tDouble = new Double(FValue);
/* 5241 */         double d = tDouble.doubleValue();
/* 5242 */         this.sMUsualALLCSum = d;
/*      */       }
/*      */     }
/* 5245 */     if (FCode.equalsIgnoreCase("aMBasicSalary"))
/*      */     {
/* 5247 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5249 */         Double tDouble = new Double(FValue);
/* 5250 */         double d = tDouble.doubleValue();
/* 5251 */         this.aMBasicSalary = d;
/*      */       }
/*      */     }
/* 5254 */     if (FCode.equalsIgnoreCase("aMproductivity"))
/*      */     {
/* 5256 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5258 */         Double tDouble = new Double(FValue);
/* 5259 */         double d = tDouble.doubleValue();
/* 5260 */         this.aMproductivity = d;
/*      */       }
/*      */     }
/* 5263 */     if (FCode.equalsIgnoreCase("aMpolContinute"))
/*      */     {
/* 5265 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5267 */         Double tDouble = new Double(FValue);
/* 5268 */         double d = tDouble.doubleValue();
/* 5269 */         this.aMpolContinute = d;
/*      */       }
/*      */     }
/* 5272 */     if (FCode.equalsIgnoreCase("aMPPRate"))
/*      */     {
/* 5274 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5276 */         Double tDouble = new Double(FValue);
/* 5277 */         double d = tDouble.doubleValue();
/* 5278 */         this.aMPPRate = d;
/*      */       }
/*      */     }
/* 5281 */     if (FCode.equalsIgnoreCase("aMPPBonus"))
/*      */     {
/* 5283 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5285 */         Double tDouble = new Double(FValue);
/* 5286 */         double d = tDouble.doubleValue();
/* 5287 */         this.aMPPBonus = d;
/*      */       }
/*      */     }
/* 5290 */     if (FCode.equalsIgnoreCase("b12DepNAFYC"))
/*      */     {
/* 5292 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5294 */         Double tDouble = new Double(FValue);
/* 5295 */         double d = tDouble.doubleValue();
/* 5296 */         this.b12DepNAFYC = d;
/*      */       }
/*      */     }
/* 5299 */     if (FCode.equalsIgnoreCase("aMOverride"))
/*      */     {
/* 5301 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5303 */         Double tDouble = new Double(FValue);
/* 5304 */         double d = tDouble.doubleValue();
/* 5305 */         this.aMOverride = d;
/*      */       }
/*      */     }
/* 5308 */     if (FCode.equalsIgnoreCase("depMonAvgPCount"))
/*      */     {
/* 5310 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5312 */         Double tDouble = new Double(FValue);
/* 5313 */         double d = tDouble.doubleValue();
/* 5314 */         this.depMonAvgPCount = d;
/*      */       }
/*      */     }
/* 5317 */     if (FCode.equalsIgnoreCase("depQutPremSum"))
/*      */     {
/* 5319 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5321 */         Double tDouble = new Double(FValue);
/* 5322 */         double d = tDouble.doubleValue();
/* 5323 */         this.depQutPremSum = d;
/*      */       }
/*      */     }
/* 5326 */     if (FCode.equalsIgnoreCase("aMRRBonus"))
/*      */     {
/* 5328 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5330 */         Double tDouble = new Double(FValue);
/* 5331 */         double d = tDouble.doubleValue();
/* 5332 */         this.aMRRBonus = d;
/*      */       }
/*      */     }
/* 5335 */     if (FCode.equalsIgnoreCase("aMManPowerDBonus"))
/*      */     {
/* 5337 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5339 */         Double tDouble = new Double(FValue);
/* 5340 */         double d = tDouble.doubleValue();
/* 5341 */         this.aMManPowerDBonus = d;
/*      */       }
/*      */     }
/* 5344 */     if (FCode.equalsIgnoreCase("productGrowth"))
/*      */     {
/* 5346 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5348 */         Double tDouble = new Double(FValue);
/* 5349 */         double d = tDouble.doubleValue();
/* 5350 */         this.productGrowth = d;
/*      */       }
/*      */     }
/* 5353 */     if (FCode.equalsIgnoreCase("depQuaFYCSum"))
/*      */     {
/* 5355 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5357 */         Double tDouble = new Double(FValue);
/* 5358 */         double d = tDouble.doubleValue();
/* 5359 */         this.depQuaFYCSum = d;
/*      */       }
/*      */     }
/* 5362 */     if (FCode.equalsIgnoreCase("aMLiability"))
/*      */     {
/* 5364 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5366 */         Double tDouble = new Double(FValue);
/* 5367 */         double d = tDouble.doubleValue();
/* 5368 */         this.aMLiability = d;
/*      */       }
/*      */     }
/* 5371 */     if (FCode.equalsIgnoreCase("reviOpen"))
/*      */     {
/* 5373 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5375 */         Double tDouble = new Double(FValue);
/* 5376 */         double d = tDouble.doubleValue();
/* 5377 */         this.reviOpen = d;
/*      */       }
/*      */     }
/* 5380 */     if (FCode.equalsIgnoreCase("t1"))
/*      */     {
/* 5382 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5384 */         Double tDouble = new Double(FValue);
/* 5385 */         double d = tDouble.doubleValue();
/* 5386 */         this.t1 = d;
/*      */       }
/*      */     }
/* 5389 */     if (FCode.equalsIgnoreCase("t2"))
/*      */     {
/* 5391 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5393 */         Double tDouble = new Double(FValue);
/* 5394 */         double d = tDouble.doubleValue();
/* 5395 */         this.t2 = d;
/*      */       }
/*      */     }
/* 5398 */     if (FCode.equalsIgnoreCase("t3"))
/*      */     {
/* 5400 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5402 */         Double tDouble = new Double(FValue);
/* 5403 */         double d = tDouble.doubleValue();
/* 5404 */         this.t3 = d;
/*      */       }
/*      */     }
/* 5407 */     if (FCode.equalsIgnoreCase("t4"))
/*      */     {
/* 5409 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5411 */         Double tDouble = new Double(FValue);
/* 5412 */         double d = tDouble.doubleValue();
/* 5413 */         this.t4 = d;
/*      */       }
/*      */     }
/* 5416 */     if (FCode.equalsIgnoreCase("t5"))
/*      */     {
/* 5418 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5420 */         Double tDouble = new Double(FValue);
/* 5421 */         double d = tDouble.doubleValue();
/* 5422 */         this.t5 = d;
/*      */       }
/*      */     }
/* 5425 */     if (FCode.equalsIgnoreCase("t6"))
/*      */     {
/* 5427 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5429 */         Double tDouble = new Double(FValue);
/* 5430 */         double d = tDouble.doubleValue();
/* 5431 */         this.t6 = d;
/*      */       }
/*      */     }
/* 5434 */     if (FCode.equalsIgnoreCase("t7"))
/*      */     {
/* 5436 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5438 */         Double tDouble = new Double(FValue);
/* 5439 */         double d = tDouble.doubleValue();
/* 5440 */         this.t7 = d;
/*      */       }
/*      */     }
/* 5443 */     if (FCode.equalsIgnoreCase("t8"))
/*      */     {
/* 5445 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5447 */         Double tDouble = new Double(FValue);
/* 5448 */         double d = tDouble.doubleValue();
/* 5449 */         this.t8 = d;
/*      */       }
/*      */     }
/* 5452 */     if (FCode.equalsIgnoreCase("t9"))
/*      */     {
/* 5454 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5456 */         Double tDouble = new Double(FValue);
/* 5457 */         double d = tDouble.doubleValue();
/* 5458 */         this.t9 = d;
/*      */       }
/*      */     }
/* 5461 */     if (FCode.equalsIgnoreCase("t10"))
/*      */     {
/* 5463 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5465 */         Double tDouble = new Double(FValue);
/* 5466 */         double d = tDouble.doubleValue();
/* 5467 */         this.t10 = d;
/*      */       }
/*      */     }
/* 5470 */     if (FCode.equalsIgnoreCase("t11"))
/*      */     {
/* 5472 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5474 */         Double tDouble = new Double(FValue);
/* 5475 */         double d = tDouble.doubleValue();
/* 5476 */         this.t11 = d;
/*      */       }
/*      */     }
/* 5479 */     if (FCode.equalsIgnoreCase("t12"))
/*      */     {
/* 5481 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5483 */         Double tDouble = new Double(FValue);
/* 5484 */         double d = tDouble.doubleValue();
/* 5485 */         this.t12 = d;
/*      */       }
/*      */     }
/* 5488 */     if (FCode.equalsIgnoreCase("t13"))
/*      */     {
/* 5490 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5492 */         Double tDouble = new Double(FValue);
/* 5493 */         double d = tDouble.doubleValue();
/* 5494 */         this.t13 = d;
/*      */       }
/*      */     }
/* 5497 */     if (FCode.equalsIgnoreCase("t14"))
/*      */     {
/* 5499 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5501 */         Double tDouble = new Double(FValue);
/* 5502 */         double d = tDouble.doubleValue();
/* 5503 */         this.t14 = d;
/*      */       }
/*      */     }
/* 5506 */     if (FCode.equalsIgnoreCase("t15"))
/*      */     {
/* 5508 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5510 */         Double tDouble = new Double(FValue);
/* 5511 */         double d = tDouble.doubleValue();
/* 5512 */         this.t15 = d;
/*      */       }
/*      */     }
/* 5515 */     if (FCode.equalsIgnoreCase("t16"))
/*      */     {
/* 5517 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5519 */         Double tDouble = new Double(FValue);
/* 5520 */         double d = tDouble.doubleValue();
/* 5521 */         this.t16 = d;
/*      */       }
/*      */     }
/* 5524 */     if (FCode.equalsIgnoreCase("t17"))
/*      */     {
/* 5526 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5528 */         Double tDouble = new Double(FValue);
/* 5529 */         double d = tDouble.doubleValue();
/* 5530 */         this.t17 = d;
/*      */       }
/*      */     }
/* 5533 */     if (FCode.equalsIgnoreCase("t18"))
/*      */     {
/* 5535 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5537 */         Double tDouble = new Double(FValue);
/* 5538 */         double d = tDouble.doubleValue();
/* 5539 */         this.t18 = d;
/*      */       }
/*      */     }
/* 5542 */     if (FCode.equalsIgnoreCase("t20"))
/*      */     {
/* 5544 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5546 */         Double tDouble = new Double(FValue);
/* 5547 */         double d = tDouble.doubleValue();
/* 5548 */         this.t20 = d;
/*      */       }
/*      */     }
/* 5551 */     if (FCode.equalsIgnoreCase("t19"))
/*      */     {
/* 5553 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5555 */         Double tDouble = new Double(FValue);
/* 5556 */         double d = tDouble.doubleValue();
/* 5557 */         this.t19 = d;
/*      */       }
/*      */     }
/* 5560 */     if (FCode.equalsIgnoreCase("monthIndex"))
/*      */     {
/* 5562 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5564 */         Double tDouble = new Double(FValue);
/* 5565 */         double d = tDouble.doubleValue();
/* 5566 */         this.monthIndex = d;
/*      */       }
/*      */     }
/* 5569 */     if (FCode.equalsIgnoreCase("tMonthIndex"))
/*      */     {
/* 5571 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5573 */         Double tDouble = new Double(FValue);
/* 5574 */         double d = tDouble.doubleValue();
/* 5575 */         this.tMonthIndex = d;
/*      */       }
/*      */     }
/* 5578 */     if (FCode.equalsIgnoreCase("aSumIndex"))
/*      */     {
/* 5580 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5582 */         Double tDouble = new Double(FValue);
/* 5583 */         double d = tDouble.doubleValue();
/* 5584 */         this.aSumIndex = d;
/*      */       }
/*      */     }
/* 5587 */     if (FCode.equalsIgnoreCase("wSMMonthEligible"))
/*      */     {
/* 5589 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5591 */         Double tDouble = new Double(FValue);
/* 5592 */         double d = tDouble.doubleValue();
/* 5593 */         this.wSMMonthEligible = d;
/*      */       }
/*      */     }
/* 5596 */     if (FCode.equalsIgnoreCase("lPQuaPCount"))
/*      */     {
/* 5598 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5600 */         Double tDouble = new Double(FValue);
/* 5601 */         double d = tDouble.doubleValue();
/* 5602 */         this.lPQuaPCount = d;
/*      */       }
/*      */     }
/* 5605 */     if (FCode.equalsIgnoreCase("lPQuaFYCSum"))
/*      */     {
/* 5607 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5609 */         Double tDouble = new Double(FValue);
/* 5610 */         double d = tDouble.doubleValue();
/* 5611 */         this.lPQuaFYCSum = d;
/*      */       }
/*      */     }
/* 5614 */     if (FCode.equalsIgnoreCase("b12LPPCount"))
/*      */     {
/* 5616 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5618 */         Double tDouble = new Double(FValue);
/* 5619 */         double d = tDouble.doubleValue();
/* 5620 */         this.b12LPPCount = d;
/*      */       }
/*      */     }
/* 5623 */     if (FCode.equalsIgnoreCase("b12LPNAFYCSum"))
/*      */     {
/* 5625 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5627 */         Double tDouble = new Double(FValue);
/* 5628 */         double d = tDouble.doubleValue();
/* 5629 */         this.b12LPNAFYCSum = d;
/*      */       }
/*      */     }
/* 5632 */     if (FCode.equalsIgnoreCase("wSMMonAFYC"))
/*      */     {
/* 5634 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5636 */         Double tDouble = new Double(FValue);
/* 5637 */         double d = tDouble.doubleValue();
/* 5638 */         this.wSMMonAFYC = d;
/*      */       }
/*      */     }
/* 5641 */     if (FCode.equalsIgnoreCase("wSMTwoMonAFYC"))
/*      */     {
/* 5643 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5645 */         Double tDouble = new Double(FValue);
/* 5646 */         double d = tDouble.doubleValue();
/* 5647 */         this.wSMTwoMonAFYC = d;
/*      */       }
/*      */     }
/* 5650 */     if (FCode.equalsIgnoreCase("wSMB6AFYC"))
/*      */     {
/* 5652 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5654 */         Double tDouble = new Double(FValue);
/* 5655 */         double d = tDouble.doubleValue();
/* 5656 */         this.wSMB6AFYC = d;
/*      */       }
/*      */     }
/* 5659 */     if (FCode.equalsIgnoreCase("wSMB6PCount"))
/*      */     {
/* 5661 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5663 */         Double tDouble = new Double(FValue);
/* 5664 */         double d = tDouble.doubleValue();
/* 5665 */         this.wSMB6PCount = d;
/*      */       }
/*      */     }
/* 5668 */     if (FCode.equalsIgnoreCase("netLiveLPCount"))
/*      */     {
/* 5670 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5672 */         Double tDouble = new Double(FValue);
/* 5673 */         double d = tDouble.doubleValue();
/* 5674 */         this.netLiveLPCount = d;
/*      */       }
/*      */     }
/* 5677 */     if (FCode.equalsIgnoreCase("netComLPCount"))
/*      */     {
/* 5679 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5681 */         Double tDouble = new Double(FValue);
/* 5682 */         double d = tDouble.doubleValue();
/* 5683 */         this.netComLPCount = d;
/*      */       }
/*      */     }
/* 5686 */     if (FCode.equalsIgnoreCase("wSMTwoMonPCount"))
/*      */     {
/* 5688 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5690 */         Double tDouble = new Double(FValue);
/* 5691 */         double d = tDouble.doubleValue();
/* 5692 */         this.wSMTwoMonPCount = d;
/*      */       }
/*      */     }
/* 5695 */     if (FCode.equalsIgnoreCase("lPAllNAFYC"))
/*      */     {
/* 5697 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5699 */         Double tDouble = new Double(FValue);
/* 5700 */         double d = tDouble.doubleValue();
/* 5701 */         this.lPAllNAFYC = d;
/*      */       }
/*      */     }
/* 5704 */     if (FCode.equalsIgnoreCase("lPAllPCount"))
/*      */     {
/* 5706 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5708 */         Double tDouble = new Double(FValue);
/* 5709 */         double d = tDouble.doubleValue();
/* 5710 */         this.lPAllPCount = d;
/*      */       }
/*      */     }
/* 5713 */     if (FCode.equalsIgnoreCase("monPerSAFYP"))
/*      */     {
/* 5715 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5717 */         Double tDouble = new Double(FValue);
/* 5718 */         double d = tDouble.doubleValue();
/* 5719 */         this.monPerSAFYP = d;
/*      */       }
/*      */     }
/* 5722 */     if (FCode.equalsIgnoreCase("tSRThrMonSAFYP"))
/*      */     {
/* 5724 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5726 */         Double tDouble = new Double(FValue);
/* 5727 */         double d = tDouble.doubleValue();
/* 5728 */         this.tSRThrMonSAFYP = d;
/*      */       }
/*      */     }
/* 5731 */     if (FCode.equalsIgnoreCase("tLThrMonPerSAFYP"))
/*      */     {
/* 5733 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5735 */         Double tDouble = new Double(FValue);
/* 5736 */         double d = tDouble.doubleValue();
/* 5737 */         this.tLThrMonPerSAFYP = d;
/*      */       }
/*      */     }
/* 5740 */     if (FCode.equalsIgnoreCase("monSubsistCnt"))
/*      */     {
/* 5742 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5744 */         Double tDouble = new Double(FValue);
/* 5745 */         double d = tDouble.doubleValue();
/* 5746 */         this.monSubsistCnt = d;
/*      */       }
/*      */     }
/* 5749 */     if (FCode.equalsIgnoreCase("thrMonSubsistCnt"))
/*      */     {
/* 5751 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5753 */         Double tDouble = new Double(FValue);
/* 5754 */         double d = tDouble.doubleValue();
/* 5755 */         this.thrMonSubsistCnt = d;
/*      */       }
/*      */     }
/* 5758 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 5760 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5762 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 5765 */         this.state = null;
/*      */     }
/* 5767 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 5769 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5771 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 5774 */         this.operator = null;
/*      */     }
/* 5776 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 5778 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5780 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 5783 */         this.makeDate = null;
/*      */     }
/* 5785 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 5787 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5789 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 5792 */         this.makeTime = null;
/*      */     }
/* 5794 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 5796 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5798 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 5801 */         this.modifyDate = null;
/*      */     }
/* 5803 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 5805 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5807 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 5810 */         this.modifyTime = null;
/*      */     }
/* 5812 */     if (FCode.equalsIgnoreCase("assessMonth"))
/*      */     {
/* 5814 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5816 */         this.assessMonth = FValue.trim();
/*      */       }
/*      */       else
/* 5819 */         this.assessMonth = null;
/*      */     }
/* 5821 */     if (FCode.equalsIgnoreCase("branchAttr"))
/*      */     {
/* 5823 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5825 */         this.branchAttr = FValue.trim();
/*      */       }
/*      */       else
/* 5828 */         this.branchAttr = null;
/*      */     }
/* 5830 */     if (FCode.equalsIgnoreCase("agentGrade"))
/*      */     {
/* 5832 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5834 */         this.agentGrade = FValue.trim();
/*      */       }
/*      */       else
/* 5837 */         this.agentGrade = null;
/*      */     }
/* 5839 */     if (FCode.equalsIgnoreCase("clubPromBonus"))
/*      */     {
/* 5841 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5843 */         Double tDouble = new Double(FValue);
/* 5844 */         double d = tDouble.doubleValue();
/* 5845 */         this.clubPromBonus = d;
/*      */       }
/*      */     }
/* 5848 */     if (FCode.equalsIgnoreCase("clubGradeBonus"))
/*      */     {
/* 5850 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5852 */         Double tDouble = new Double(FValue);
/* 5853 */         double d = tDouble.doubleValue();
/* 5854 */         this.clubGradeBonus = d;
/*      */       }
/*      */     }
/* 5857 */     if (FCode.equalsIgnoreCase("clubAssisBonus"))
/*      */     {
/* 5859 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5861 */         Double tDouble = new Double(FValue);
/* 5862 */         double d = tDouble.doubleValue();
/* 5863 */         this.clubAssisBonus = d;
/*      */       }
/*      */     }
/* 5866 */     if (FCode.equalsIgnoreCase("clubSpecBonus"))
/*      */     {
/* 5868 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5870 */         Double tDouble = new Double(FValue);
/* 5871 */         double d = tDouble.doubleValue();
/* 5872 */         this.clubSpecBonus = d;
/*      */       }
/*      */     }
/* 5875 */     if (FCode.equalsIgnoreCase("adddedMoney"))
/*      */     {
/* 5877 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5879 */         Double tDouble = new Double(FValue);
/* 5880 */         double d = tDouble.doubleValue();
/* 5881 */         this.adddedMoney = d;
/*      */       }
/*      */     }
/* 5884 */     if (FCode.equalsIgnoreCase("lastMoney"))
/*      */     {
/* 5886 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5888 */         Double tDouble = new Double(FValue);
/* 5889 */         double d = tDouble.doubleValue();
/* 5890 */         this.lastMoney = d;
/*      */       }
/*      */     }
/* 5893 */     if (FCode.equalsIgnoreCase("shouldMoney"))
/*      */     {
/* 5895 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5897 */         Double tDouble = new Double(FValue);
/* 5898 */         double d = tDouble.doubleValue();
/* 5899 */         this.shouldMoney = d;
/*      */       }
/*      */     }
/* 5902 */     if (FCode.equalsIgnoreCase("businessTax"))
/*      */     {
/* 5904 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5906 */         Double tDouble = new Double(FValue);
/* 5907 */         double d = tDouble.doubleValue();
/* 5908 */         this.businessTax = d;
/*      */       }
/*      */     }
/* 5911 */     if (FCode.equalsIgnoreCase("eduTax"))
/*      */     {
/* 5913 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5915 */         Double tDouble = new Double(FValue);
/* 5916 */         double d = tDouble.doubleValue();
/* 5917 */         this.eduTax = d;
/*      */       }
/*      */     }
/* 5920 */     if (FCode.equalsIgnoreCase("buildTax"))
/*      */     {
/* 5922 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5924 */         Double tDouble = new Double(FValue);
/* 5925 */         double d = tDouble.doubleValue();
/* 5926 */         this.buildTax = d;
/*      */       }
/*      */     }
/* 5929 */     if (FCode.equalsIgnoreCase("busiCharge"))
/*      */     {
/* 5931 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5933 */         Double tDouble = new Double(FValue);
/* 5934 */         double d = tDouble.doubleValue();
/* 5935 */         this.busiCharge = d;
/*      */       }
/*      */     }
/* 5938 */     if (FCode.equalsIgnoreCase("incomeTax"))
/*      */     {
/* 5940 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5942 */         Double tDouble = new Double(FValue);
/* 5943 */         double d = tDouble.doubleValue();
/* 5944 */         this.incomeTax = d;
/*      */       }
/*      */     }
/* 5947 */     if (FCode.equalsIgnoreCase("sumMoney"))
/*      */     {
/* 5949 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5951 */         Double tDouble = new Double(FValue);
/* 5952 */         double d = tDouble.doubleValue();
/* 5953 */         this.sumMoney = d;
/*      */       }
/*      */     }
/* 5956 */     if (FCode.equalsIgnoreCase("afterTaxMoney"))
/*      */     {
/* 5958 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5960 */         Double tDouble = new Double(FValue);
/* 5961 */         double d = tDouble.doubleValue();
/* 5962 */         this.afterTaxMoney = d;
/*      */       }
/*      */     }
/* 5965 */     if (FCode.equalsIgnoreCase("operInCome"))
/*      */     {
/* 5967 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5969 */         Double tDouble = new Double(FValue);
/* 5970 */         double d = tDouble.doubleValue();
/* 5971 */         this.operInCome = d;
/*      */       }
/*      */     }
/* 5974 */     if (FCode.equalsIgnoreCase("t21"))
/*      */     {
/* 5976 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5978 */         Double tDouble = new Double(FValue);
/* 5979 */         double d = tDouble.doubleValue();
/* 5980 */         this.t21 = d;
/*      */       }
/*      */     }
/* 5983 */     if (FCode.equalsIgnoreCase("t22"))
/*      */     {
/* 5985 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5987 */         Double tDouble = new Double(FValue);
/* 5988 */         double d = tDouble.doubleValue();
/* 5989 */         this.t22 = d;
/*      */       }
/*      */     }
/* 5992 */     if (FCode.equalsIgnoreCase("t23"))
/*      */     {
/* 5994 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 5996 */         Double tDouble = new Double(FValue);
/* 5997 */         double d = tDouble.doubleValue();
/* 5998 */         this.t23 = d;
/*      */       }
/*      */     }
/* 6001 */     if (FCode.equalsIgnoreCase("t24"))
/*      */     {
/* 6003 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 6005 */         Double tDouble = new Double(FValue);
/* 6006 */         double d = tDouble.doubleValue();
/* 6007 */         this.t24 = d;
/*      */       }
/*      */     }
/* 6010 */     if (FCode.equalsIgnoreCase("t25"))
/*      */     {
/* 6012 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 6014 */         Double tDouble = new Double(FValue);
/* 6015 */         double d = tDouble.doubleValue();
/* 6016 */         this.t25 = d;
/*      */       }
/*      */     }
/* 6019 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 6024 */     if (otherObject == null) return false;
/* 6025 */     if (this == otherObject) return true;
/* 6026 */     if (getClass() != otherObject.getClass()) return false;
/* 6027 */     LAIndexInfoSchema other = (LAIndexInfoSchema)otherObject;
/* 6028 */     if ((this.indexCalNo == null) && (other.getIndexCalNo() != null)) return false;
/* 6029 */     if ((this.indexCalNo != null) && (!this.indexCalNo.equals(other.getIndexCalNo()))) return false;
/* 6030 */     if ((this.indexType == null) && (other.getIndexType() != null)) return false;
/* 6031 */     if ((this.indexType != null) && (!this.indexType.equals(other.getIndexType()))) return false;
/* 6032 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/* 6033 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/* 6034 */     if ((this.agentGroup == null) && (other.getAgentGroup() != null)) return false;
/* 6035 */     if ((this.agentGroup != null) && (!this.agentGroup.equals(other.getAgentGroup()))) return false;
/* 6036 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 6037 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 6038 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 6039 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 6040 */     if ((this.startEnd == null) && (other.getStartEnd() != null)) return false;
/* 6041 */     if ((this.startEnd != null) && (!this.fDate.getString(this.startEnd).equals(other.getStartEnd()))) return false;
/* 6042 */     if (this.quaBgnMark != other.getQuaBgnMark()) return false;
/* 6043 */     if (this.serverMonths != other.getServerMonths()) return false;
/* 6044 */     if (this.postMonths != other.getPostMonths()) return false;
/* 6045 */     if (Double.doubleToLongBits(this.indMonthFYC) != Double.doubleToLongBits(other.getIndMonthFYC())) return false;
/* 6046 */     if (Double.doubleToLongBits(this.indMonthSYC) != Double.doubleToLongBits(other.getIndMonthSYC())) return false;
/* 6047 */     if (Double.doubleToLongBits(this.indMonSignFYC) != Double.doubleToLongBits(other.getIndMonSignFYC())) return false;
/* 6048 */     if (Double.doubleToLongBits(this.indMonSignAFYC) != Double.doubleToLongBits(other.getIndMonSignAFYC())) return false;
/* 6049 */     if (Double.doubleToLongBits(this.indMonSignNAFYC) != Double.doubleToLongBits(other.getIndMonSignNAFYC())) return false;
/* 6050 */     if (Double.doubleToLongBits(this.grpMonSignNAFYC) != Double.doubleToLongBits(other.getGrpMonSignNAFYC())) return false;
/* 6051 */     if (Double.doubleToLongBits(this.monPolCnt) != Double.doubleToLongBits(other.getMonPolCnt())) return false;
/* 6052 */     if (Double.doubleToLongBits(this.montCustCnt) != Double.doubleToLongBits(other.getMontCustCnt())) return false;
/* 6053 */     if (Double.doubleToLongBits(this.indMonPCount) != Double.doubleToLongBits(other.getIndMonPCount())) return false;
/* 6054 */     if (Double.doubleToLongBits(this.sMmonPolContin) != Double.doubleToLongBits(other.getSMmonPolContin())) return false;
/* 6055 */     if (Double.doubleToLongBits(this.sMmonProduct) != Double.doubleToLongBits(other.getSMmonProduct())) return false;
/* 6056 */     if (Double.doubleToLongBits(this.sMworkMon) != Double.doubleToLongBits(other.getSMworkMon())) return false;
/* 6057 */     if (Double.doubleToLongBits(this.monPCount) != Double.doubleToLongBits(other.getMonPCount())) return false;
/* 6058 */     if (Double.doubleToLongBits(this.wSMMonPCount) != Double.doubleToLongBits(other.getWSMMonPCount())) return false;
/* 6059 */     if (Double.doubleToLongBits(this.lPMonForSMMP) != Double.doubleToLongBits(other.getLPMonForSMMP())) return false;
/* 6060 */     if (Double.doubleToLongBits(this.lPMonForAMMP) != Double.doubleToLongBits(other.getLPMonForAMMP())) return false;
/* 6061 */     if (Double.doubleToLongBits(this.lPpolContinute) != Double.doubleToLongBits(other.getLPpolContinute())) return false;
/* 6062 */     if (Double.doubleToLongBits(this.monEligFLPCnt) != Double.doubleToLongBits(other.getMonEligFLPCnt())) return false;
/* 6063 */     if (Double.doubleToLongBits(this.tSRmonAFYP) != Double.doubleToLongBits(other.getTSRmonAFYP())) return false;
/* 6064 */     if (Double.doubleToLongBits(this.tSRmonDedAFYP) != Double.doubleToLongBits(other.getTSRmonDedAFYP())) return false;
/* 6065 */     if (Double.doubleToLongBits(this.tSRmonCompAFYP) != Double.doubleToLongBits(other.getTSRmonCompAFYP())) return false;
/* 6066 */     if (Double.doubleToLongBits(this.tSRMonWorkDays) != Double.doubleToLongBits(other.getTSRMonWorkDays())) return false;
/* 6067 */     if (Double.doubleToLongBits(this.monManPower) != Double.doubleToLongBits(other.getMonManPower())) return false;
/* 6068 */     if (Double.doubleToLongBits(this.monManCount) != Double.doubleToLongBits(other.getMonManCount())) return false;
/* 6069 */     if (Double.doubleToLongBits(this.monSAFYPSum) != Double.doubleToLongBits(other.getMonSAFYPSum())) return false;
/* 6070 */     if (Double.doubleToLongBits(this.monTLGrpSAFYPSum) != Double.doubleToLongBits(other.getMonTLGrpSAFYPSum())) return false;
/* 6071 */     if (Double.doubleToLongBits(this.indYearNAFYC) != Double.doubleToLongBits(other.getIndYearNAFYC())) return false;
/* 6072 */     if (Double.doubleToLongBits(this.b12IndEffectAFYC) != Double.doubleToLongBits(other.getB12IndEffectAFYC())) return false;
/* 6073 */     if (Double.doubleToLongBits(this.b12IndAllAFYC) != Double.doubleToLongBits(other.getB12IndAllAFYC())) return false;
/* 6074 */     if (Double.doubleToLongBits(this.b24IndEffectAFYC) != Double.doubleToLongBits(other.getB24IndEffectAFYC())) return false;
/* 6075 */     if (Double.doubleToLongBits(this.b24IndAllAFYC) != Double.doubleToLongBits(other.getB24IndAllAFYC())) return false;
/* 6076 */     if (Double.doubleToLongBits(this.indQutFYC) != Double.doubleToLongBits(other.getIndQutFYC())) return false;
/* 6077 */     if (Double.doubleToLongBits(this.lPproductivity) != Double.doubleToLongBits(other.getLPproductivity())) return false;
/* 6078 */     if (Double.doubleToLongBits(this.lPPPRate) != Double.doubleToLongBits(other.getLPPPRate())) return false;
/* 6079 */     if (Double.doubleToLongBits(this.lPPPBonus) != Double.doubleToLongBits(other.getLPPPBonus())) return false;
/* 6080 */     if (Double.doubleToLongBits(this.lPFincSubsidy) != Double.doubleToLongBits(other.getLPFincSubsidy())) return false;
/* 6081 */     if (Double.doubleToLongBits(this.subsidyRate) != Double.doubleToLongBits(other.getSubsidyRate())) return false;
/* 6082 */     if (Double.doubleToLongBits(this.b12TeamNAFYC) != Double.doubleToLongBits(other.getB12TeamNAFYC())) return false;
/* 6083 */     if (Double.doubleToLongBits(this.sMOverride) != Double.doubleToLongBits(other.getSMOverride())) return false;
/* 6084 */     if (Double.doubleToLongBits(this.teamMonAvgPCount) != Double.doubleToLongBits(other.getTeamMonAvgPCount())) return false;
/* 6085 */     if (Double.doubleToLongBits(this.sMBasicSalary) != Double.doubleToLongBits(other.getSMBasicSalary())) return false;
/* 6086 */     if (Double.doubleToLongBits(this.sMproductivity) != Double.doubleToLongBits(other.getSMproductivity())) return false;
/* 6087 */     if (Double.doubleToLongBits(this.sMpolContinute) != Double.doubleToLongBits(other.getSMpolContinute())) return false;
/* 6088 */     if (Double.doubleToLongBits(this.sMPPRate) != Double.doubleToLongBits(other.getSMPPRate())) return false;
/* 6089 */     if (Double.doubleToLongBits(this.sMPPBonus) != Double.doubleToLongBits(other.getSMPPBonus())) return false;
/* 6090 */     if (Double.doubleToLongBits(this.b24TeamEffectAFYC) != Double.doubleToLongBits(other.getB24TeamEffectAFYC())) return false;
/* 6091 */     if (Double.doubleToLongBits(this.b24TeamAllAFYC) != Double.doubleToLongBits(other.getB24TeamAllAFYC())) return false;
/* 6092 */     if (Double.doubleToLongBits(this.teamQutPremSum) != Double.doubleToLongBits(other.getTeamQutPremSum())) return false;
/* 6093 */     if (Double.doubleToLongBits(this.sMRRBonus) != Double.doubleToLongBits(other.getSMRRBonus())) return false;
/* 6094 */     if (Double.doubleToLongBits(this.sMManPowerDBonus) != Double.doubleToLongBits(other.getSMManPowerDBonus())) return false;
/* 6095 */     if (Double.doubleToLongBits(this.lPB12ForMPDBonus) != Double.doubleToLongBits(other.getLPB12ForMPDBonus())) return false;
/* 6096 */     if (Double.doubleToLongBits(this.sMUsualALLCSum) != Double.doubleToLongBits(other.getSMUsualALLCSum())) return false;
/* 6097 */     if (Double.doubleToLongBits(this.aMBasicSalary) != Double.doubleToLongBits(other.getAMBasicSalary())) return false;
/* 6098 */     if (Double.doubleToLongBits(this.aMproductivity) != Double.doubleToLongBits(other.getAMproductivity())) return false;
/* 6099 */     if (Double.doubleToLongBits(this.aMpolContinute) != Double.doubleToLongBits(other.getAMpolContinute())) return false;
/* 6100 */     if (Double.doubleToLongBits(this.aMPPRate) != Double.doubleToLongBits(other.getAMPPRate())) return false;
/* 6101 */     if (Double.doubleToLongBits(this.aMPPBonus) != Double.doubleToLongBits(other.getAMPPBonus())) return false;
/* 6102 */     if (Double.doubleToLongBits(this.b12DepNAFYC) != Double.doubleToLongBits(other.getB12DepNAFYC())) return false;
/* 6103 */     if (Double.doubleToLongBits(this.aMOverride) != Double.doubleToLongBits(other.getAMOverride())) return false;
/* 6104 */     if (Double.doubleToLongBits(this.depMonAvgPCount) != Double.doubleToLongBits(other.getDepMonAvgPCount())) return false;
/* 6105 */     if (Double.doubleToLongBits(this.depQutPremSum) != Double.doubleToLongBits(other.getDepQutPremSum())) return false;
/* 6106 */     if (Double.doubleToLongBits(this.aMRRBonus) != Double.doubleToLongBits(other.getAMRRBonus())) return false;
/* 6107 */     if (Double.doubleToLongBits(this.aMManPowerDBonus) != Double.doubleToLongBits(other.getAMManPowerDBonus())) return false;
/* 6108 */     if (Double.doubleToLongBits(this.productGrowth) != Double.doubleToLongBits(other.getProductGrowth())) return false;
/* 6109 */     if (Double.doubleToLongBits(this.depQuaFYCSum) != Double.doubleToLongBits(other.getDepQuaFYCSum())) return false;
/* 6110 */     if (Double.doubleToLongBits(this.aMLiability) != Double.doubleToLongBits(other.getAMLiability())) return false;
/* 6111 */     if (Double.doubleToLongBits(this.reviOpen) != Double.doubleToLongBits(other.getReviOpen())) return false;
/* 6112 */     if (Double.doubleToLongBits(this.t1) != Double.doubleToLongBits(other.getT1())) return false;
/* 6113 */     if (Double.doubleToLongBits(this.t2) != Double.doubleToLongBits(other.getT2())) return false;
/* 6114 */     if (Double.doubleToLongBits(this.t3) != Double.doubleToLongBits(other.getT3())) return false;
/* 6115 */     if (Double.doubleToLongBits(this.t4) != Double.doubleToLongBits(other.getT4())) return false;
/* 6116 */     if (Double.doubleToLongBits(this.t5) != Double.doubleToLongBits(other.getT5())) return false;
/* 6117 */     if (Double.doubleToLongBits(this.t6) != Double.doubleToLongBits(other.getT6())) return false;
/* 6118 */     if (Double.doubleToLongBits(this.t7) != Double.doubleToLongBits(other.getT7())) return false;
/* 6119 */     if (Double.doubleToLongBits(this.t8) != Double.doubleToLongBits(other.getT8())) return false;
/* 6120 */     if (Double.doubleToLongBits(this.t9) != Double.doubleToLongBits(other.getT9())) return false;
/* 6121 */     if (Double.doubleToLongBits(this.t10) != Double.doubleToLongBits(other.getT10())) return false;
/* 6122 */     if (Double.doubleToLongBits(this.t11) != Double.doubleToLongBits(other.getT11())) return false;
/* 6123 */     if (Double.doubleToLongBits(this.t12) != Double.doubleToLongBits(other.getT12())) return false;
/* 6124 */     if (Double.doubleToLongBits(this.t13) != Double.doubleToLongBits(other.getT13())) return false;
/* 6125 */     if (Double.doubleToLongBits(this.t14) != Double.doubleToLongBits(other.getT14())) return false;
/* 6126 */     if (Double.doubleToLongBits(this.t15) != Double.doubleToLongBits(other.getT15())) return false;
/* 6127 */     if (Double.doubleToLongBits(this.t16) != Double.doubleToLongBits(other.getT16())) return false;
/* 6128 */     if (Double.doubleToLongBits(this.t17) != Double.doubleToLongBits(other.getT17())) return false;
/* 6129 */     if (Double.doubleToLongBits(this.t18) != Double.doubleToLongBits(other.getT18())) return false;
/* 6130 */     if (Double.doubleToLongBits(this.t20) != Double.doubleToLongBits(other.getT20())) return false;
/* 6131 */     if (Double.doubleToLongBits(this.t19) != Double.doubleToLongBits(other.getT19())) return false;
/* 6132 */     if (Double.doubleToLongBits(this.monthIndex) != Double.doubleToLongBits(other.getMonthIndex())) return false;
/* 6133 */     if (Double.doubleToLongBits(this.tMonthIndex) != Double.doubleToLongBits(other.getTMonthIndex())) return false;
/* 6134 */     if (Double.doubleToLongBits(this.aSumIndex) != Double.doubleToLongBits(other.getASumIndex())) return false;
/* 6135 */     if (Double.doubleToLongBits(this.wSMMonthEligible) != Double.doubleToLongBits(other.getWSMMonthEligible())) return false;
/* 6136 */     if (Double.doubleToLongBits(this.lPQuaPCount) != Double.doubleToLongBits(other.getLPQuaPCount())) return false;
/* 6137 */     if (Double.doubleToLongBits(this.lPQuaFYCSum) != Double.doubleToLongBits(other.getLPQuaFYCSum())) return false;
/* 6138 */     if (Double.doubleToLongBits(this.b12LPPCount) != Double.doubleToLongBits(other.getB12LPPCount())) return false;
/* 6139 */     if (Double.doubleToLongBits(this.b12LPNAFYCSum) != Double.doubleToLongBits(other.getB12LPNAFYCSum())) return false;
/* 6140 */     if (Double.doubleToLongBits(this.wSMMonAFYC) != Double.doubleToLongBits(other.getWSMMonAFYC())) return false;
/* 6141 */     if (Double.doubleToLongBits(this.wSMTwoMonAFYC) != Double.doubleToLongBits(other.getWSMTwoMonAFYC())) return false;
/* 6142 */     if (Double.doubleToLongBits(this.wSMB6AFYC) != Double.doubleToLongBits(other.getWSMB6AFYC())) return false;
/* 6143 */     if (Double.doubleToLongBits(this.wSMB6PCount) != Double.doubleToLongBits(other.getWSMB6PCount())) return false;
/* 6144 */     if (Double.doubleToLongBits(this.netLiveLPCount) != Double.doubleToLongBits(other.getNetLiveLPCount())) return false;
/* 6145 */     if (Double.doubleToLongBits(this.netComLPCount) != Double.doubleToLongBits(other.getNetComLPCount())) return false;
/* 6146 */     if (Double.doubleToLongBits(this.wSMTwoMonPCount) != Double.doubleToLongBits(other.getWSMTwoMonPCount())) return false;
/* 6147 */     if (Double.doubleToLongBits(this.lPAllNAFYC) != Double.doubleToLongBits(other.getLPAllNAFYC())) return false;
/* 6148 */     if (Double.doubleToLongBits(this.lPAllPCount) != Double.doubleToLongBits(other.getLPAllPCount())) return false;
/* 6149 */     if (Double.doubleToLongBits(this.monPerSAFYP) != Double.doubleToLongBits(other.getMonPerSAFYP())) return false;
/* 6150 */     if (Double.doubleToLongBits(this.tSRThrMonSAFYP) != Double.doubleToLongBits(other.getTSRThrMonSAFYP())) return false;
/* 6151 */     if (Double.doubleToLongBits(this.tLThrMonPerSAFYP) != Double.doubleToLongBits(other.getTLThrMonPerSAFYP())) return false;
/* 6152 */     if (Double.doubleToLongBits(this.monSubsistCnt) != Double.doubleToLongBits(other.getMonSubsistCnt())) return false;
/* 6153 */     if (Double.doubleToLongBits(this.thrMonSubsistCnt) != Double.doubleToLongBits(other.getThrMonSubsistCnt())) return false;
/* 6154 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 6155 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 6156 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 6157 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 6158 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 6159 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 6160 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 6161 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 6162 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 6163 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 6164 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 6165 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 6166 */     if ((this.assessMonth == null) && (other.getAssessMonth() != null)) return false;
/* 6167 */     if ((this.assessMonth != null) && (!this.assessMonth.equals(other.getAssessMonth()))) return false;
/* 6168 */     if ((this.branchAttr == null) && (other.getBranchAttr() != null)) return false;
/* 6169 */     if ((this.branchAttr != null) && (!this.branchAttr.equals(other.getBranchAttr()))) return false;
/* 6170 */     if ((this.agentGrade == null) && (other.getAgentGrade() != null)) return false;
/* 6171 */     if ((this.agentGrade != null) && (!this.agentGrade.equals(other.getAgentGrade()))) return false;
/* 6172 */     if (Double.doubleToLongBits(this.clubPromBonus) != Double.doubleToLongBits(other.getClubPromBonus())) return false;
/* 6173 */     if (Double.doubleToLongBits(this.clubGradeBonus) != Double.doubleToLongBits(other.getClubGradeBonus())) return false;
/* 6174 */     if (Double.doubleToLongBits(this.clubAssisBonus) != Double.doubleToLongBits(other.getClubAssisBonus())) return false;
/* 6175 */     if (Double.doubleToLongBits(this.clubSpecBonus) != Double.doubleToLongBits(other.getClubSpecBonus())) return false;
/* 6176 */     if (Double.doubleToLongBits(this.adddedMoney) != Double.doubleToLongBits(other.getAdddedMoney())) return false;
/* 6177 */     if (Double.doubleToLongBits(this.lastMoney) != Double.doubleToLongBits(other.getLastMoney())) return false;
/* 6178 */     if (Double.doubleToLongBits(this.shouldMoney) != Double.doubleToLongBits(other.getShouldMoney())) return false;
/* 6179 */     if (Double.doubleToLongBits(this.businessTax) != Double.doubleToLongBits(other.getBusinessTax())) return false;
/* 6180 */     if (Double.doubleToLongBits(this.eduTax) != Double.doubleToLongBits(other.getEduTax())) return false;
/* 6181 */     if (Double.doubleToLongBits(this.buildTax) != Double.doubleToLongBits(other.getBuildTax())) return false;
/* 6182 */     if (Double.doubleToLongBits(this.busiCharge) != Double.doubleToLongBits(other.getBusiCharge())) return false;
/* 6183 */     if (Double.doubleToLongBits(this.incomeTax) != Double.doubleToLongBits(other.getIncomeTax())) return false;
/* 6184 */     if (Double.doubleToLongBits(this.sumMoney) != Double.doubleToLongBits(other.getSumMoney())) return false;
/* 6185 */     if (Double.doubleToLongBits(this.afterTaxMoney) != Double.doubleToLongBits(other.getAfterTaxMoney())) return false;
/* 6186 */     if (Double.doubleToLongBits(this.operInCome) != Double.doubleToLongBits(other.getOperInCome())) return false;
/* 6187 */     if (Double.doubleToLongBits(this.t21) != Double.doubleToLongBits(other.getT21())) return false;
/* 6188 */     if (Double.doubleToLongBits(this.t22) != Double.doubleToLongBits(other.getT22())) return false;
/* 6189 */     if (Double.doubleToLongBits(this.t23) != Double.doubleToLongBits(other.getT23())) return false;
/* 6190 */     if (Double.doubleToLongBits(this.t24) != Double.doubleToLongBits(other.getT24())) return false;
/* 6191 */     return Double.doubleToLongBits(this.t25) == Double.doubleToLongBits(other.getT25());
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 6198 */     return 148;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 6204 */     if (strFieldName.equals("indexCalNo")) {
/* 6205 */       return 0;
/*      */     }
/* 6207 */     if (strFieldName.equals("indexType")) {
/* 6208 */       return 1;
/*      */     }
/* 6210 */     if (strFieldName.equals("agentCode")) {
/* 6211 */       return 2;
/*      */     }
/* 6213 */     if (strFieldName.equals("agentGroup")) {
/* 6214 */       return 3;
/*      */     }
/* 6216 */     if (strFieldName.equals("manageCom")) {
/* 6217 */       return 4;
/*      */     }
/* 6219 */     if (strFieldName.equals("startDate")) {
/* 6220 */       return 5;
/*      */     }
/* 6222 */     if (strFieldName.equals("startEnd")) {
/* 6223 */       return 6;
/*      */     }
/* 6225 */     if (strFieldName.equals("quaBgnMark")) {
/* 6226 */       return 7;
/*      */     }
/* 6228 */     if (strFieldName.equals("serverMonths")) {
/* 6229 */       return 8;
/*      */     }
/* 6231 */     if (strFieldName.equals("postMonths")) {
/* 6232 */       return 9;
/*      */     }
/* 6234 */     if (strFieldName.equals("indMonthFYC")) {
/* 6235 */       return 10;
/*      */     }
/* 6237 */     if (strFieldName.equals("indMonthSYC")) {
/* 6238 */       return 11;
/*      */     }
/* 6240 */     if (strFieldName.equals("indMonSignFYC")) {
/* 6241 */       return 12;
/*      */     }
/* 6243 */     if (strFieldName.equals("indMonSignAFYC")) {
/* 6244 */       return 13;
/*      */     }
/* 6246 */     if (strFieldName.equals("indMonSignNAFYC")) {
/* 6247 */       return 14;
/*      */     }
/* 6249 */     if (strFieldName.equals("grpMonSignNAFYC")) {
/* 6250 */       return 15;
/*      */     }
/* 6252 */     if (strFieldName.equals("monPolCnt")) {
/* 6253 */       return 16;
/*      */     }
/* 6255 */     if (strFieldName.equals("montCustCnt")) {
/* 6256 */       return 17;
/*      */     }
/* 6258 */     if (strFieldName.equals("indMonPCount")) {
/* 6259 */       return 18;
/*      */     }
/* 6261 */     if (strFieldName.equals("sMmonPolContin")) {
/* 6262 */       return 19;
/*      */     }
/* 6264 */     if (strFieldName.equals("sMmonProduct")) {
/* 6265 */       return 20;
/*      */     }
/* 6267 */     if (strFieldName.equals("sMworkMon")) {
/* 6268 */       return 21;
/*      */     }
/* 6270 */     if (strFieldName.equals("monPCount")) {
/* 6271 */       return 22;
/*      */     }
/* 6273 */     if (strFieldName.equals("wSMMonPCount")) {
/* 6274 */       return 23;
/*      */     }
/* 6276 */     if (strFieldName.equals("lPMonForSMMP")) {
/* 6277 */       return 24;
/*      */     }
/* 6279 */     if (strFieldName.equals("lPMonForAMMP")) {
/* 6280 */       return 25;
/*      */     }
/* 6282 */     if (strFieldName.equals("lPpolContinute")) {
/* 6283 */       return 26;
/*      */     }
/* 6285 */     if (strFieldName.equals("monEligFLPCnt")) {
/* 6286 */       return 27;
/*      */     }
/* 6288 */     if (strFieldName.equals("tSRmonAFYP")) {
/* 6289 */       return 28;
/*      */     }
/* 6291 */     if (strFieldName.equals("tSRmonDedAFYP")) {
/* 6292 */       return 29;
/*      */     }
/* 6294 */     if (strFieldName.equals("tSRmonCompAFYP")) {
/* 6295 */       return 30;
/*      */     }
/* 6297 */     if (strFieldName.equals("tSRMonWorkDays")) {
/* 6298 */       return 31;
/*      */     }
/* 6300 */     if (strFieldName.equals("monManPower")) {
/* 6301 */       return 32;
/*      */     }
/* 6303 */     if (strFieldName.equals("monManCount")) {
/* 6304 */       return 33;
/*      */     }
/* 6306 */     if (strFieldName.equals("monSAFYPSum")) {
/* 6307 */       return 34;
/*      */     }
/* 6309 */     if (strFieldName.equals("monTLGrpSAFYPSum")) {
/* 6310 */       return 35;
/*      */     }
/* 6312 */     if (strFieldName.equals("indYearNAFYC")) {
/* 6313 */       return 36;
/*      */     }
/* 6315 */     if (strFieldName.equals("b12IndEffectAFYC")) {
/* 6316 */       return 37;
/*      */     }
/* 6318 */     if (strFieldName.equals("b12IndAllAFYC")) {
/* 6319 */       return 38;
/*      */     }
/* 6321 */     if (strFieldName.equals("b24IndEffectAFYC")) {
/* 6322 */       return 39;
/*      */     }
/* 6324 */     if (strFieldName.equals("b24IndAllAFYC")) {
/* 6325 */       return 40;
/*      */     }
/* 6327 */     if (strFieldName.equals("indQutFYC")) {
/* 6328 */       return 41;
/*      */     }
/* 6330 */     if (strFieldName.equals("lPproductivity")) {
/* 6331 */       return 42;
/*      */     }
/* 6333 */     if (strFieldName.equals("lPPPRate")) {
/* 6334 */       return 43;
/*      */     }
/* 6336 */     if (strFieldName.equals("lPPPBonus")) {
/* 6337 */       return 44;
/*      */     }
/* 6339 */     if (strFieldName.equals("lPFincSubsidy")) {
/* 6340 */       return 45;
/*      */     }
/* 6342 */     if (strFieldName.equals("subsidyRate")) {
/* 6343 */       return 46;
/*      */     }
/* 6345 */     if (strFieldName.equals("b12TeamNAFYC")) {
/* 6346 */       return 47;
/*      */     }
/* 6348 */     if (strFieldName.equals("sMOverride")) {
/* 6349 */       return 48;
/*      */     }
/* 6351 */     if (strFieldName.equals("teamMonAvgPCount")) {
/* 6352 */       return 49;
/*      */     }
/* 6354 */     if (strFieldName.equals("sMBasicSalary")) {
/* 6355 */       return 50;
/*      */     }
/* 6357 */     if (strFieldName.equals("sMproductivity")) {
/* 6358 */       return 51;
/*      */     }
/* 6360 */     if (strFieldName.equals("sMpolContinute")) {
/* 6361 */       return 52;
/*      */     }
/* 6363 */     if (strFieldName.equals("sMPPRate")) {
/* 6364 */       return 53;
/*      */     }
/* 6366 */     if (strFieldName.equals("sMPPBonus")) {
/* 6367 */       return 54;
/*      */     }
/* 6369 */     if (strFieldName.equals("b24TeamEffectAFYC")) {
/* 6370 */       return 55;
/*      */     }
/* 6372 */     if (strFieldName.equals("b24TeamAllAFYC")) {
/* 6373 */       return 56;
/*      */     }
/* 6375 */     if (strFieldName.equals("teamQutPremSum")) {
/* 6376 */       return 57;
/*      */     }
/* 6378 */     if (strFieldName.equals("sMRRBonus")) {
/* 6379 */       return 58;
/*      */     }
/* 6381 */     if (strFieldName.equals("sMManPowerDBonus")) {
/* 6382 */       return 59;
/*      */     }
/* 6384 */     if (strFieldName.equals("lPB12ForMPDBonus")) {
/* 6385 */       return 60;
/*      */     }
/* 6387 */     if (strFieldName.equals("sMUsualALLCSum")) {
/* 6388 */       return 61;
/*      */     }
/* 6390 */     if (strFieldName.equals("aMBasicSalary")) {
/* 6391 */       return 62;
/*      */     }
/* 6393 */     if (strFieldName.equals("aMproductivity")) {
/* 6394 */       return 63;
/*      */     }
/* 6396 */     if (strFieldName.equals("aMpolContinute")) {
/* 6397 */       return 64;
/*      */     }
/* 6399 */     if (strFieldName.equals("aMPPRate")) {
/* 6400 */       return 65;
/*      */     }
/* 6402 */     if (strFieldName.equals("aMPPBonus")) {
/* 6403 */       return 66;
/*      */     }
/* 6405 */     if (strFieldName.equals("b12DepNAFYC")) {
/* 6406 */       return 67;
/*      */     }
/* 6408 */     if (strFieldName.equals("aMOverride")) {
/* 6409 */       return 68;
/*      */     }
/* 6411 */     if (strFieldName.equals("depMonAvgPCount")) {
/* 6412 */       return 69;
/*      */     }
/* 6414 */     if (strFieldName.equals("depQutPremSum")) {
/* 6415 */       return 70;
/*      */     }
/* 6417 */     if (strFieldName.equals("aMRRBonus")) {
/* 6418 */       return 71;
/*      */     }
/* 6420 */     if (strFieldName.equals("aMManPowerDBonus")) {
/* 6421 */       return 72;
/*      */     }
/* 6423 */     if (strFieldName.equals("productGrowth")) {
/* 6424 */       return 73;
/*      */     }
/* 6426 */     if (strFieldName.equals("depQuaFYCSum")) {
/* 6427 */       return 74;
/*      */     }
/* 6429 */     if (strFieldName.equals("aMLiability")) {
/* 6430 */       return 75;
/*      */     }
/* 6432 */     if (strFieldName.equals("reviOpen")) {
/* 6433 */       return 76;
/*      */     }
/* 6435 */     if (strFieldName.equals("t1")) {
/* 6436 */       return 77;
/*      */     }
/* 6438 */     if (strFieldName.equals("t2")) {
/* 6439 */       return 78;
/*      */     }
/* 6441 */     if (strFieldName.equals("t3")) {
/* 6442 */       return 79;
/*      */     }
/* 6444 */     if (strFieldName.equals("t4")) {
/* 6445 */       return 80;
/*      */     }
/* 6447 */     if (strFieldName.equals("t5")) {
/* 6448 */       return 81;
/*      */     }
/* 6450 */     if (strFieldName.equals("t6")) {
/* 6451 */       return 82;
/*      */     }
/* 6453 */     if (strFieldName.equals("t7")) {
/* 6454 */       return 83;
/*      */     }
/* 6456 */     if (strFieldName.equals("t8")) {
/* 6457 */       return 84;
/*      */     }
/* 6459 */     if (strFieldName.equals("t9")) {
/* 6460 */       return 85;
/*      */     }
/* 6462 */     if (strFieldName.equals("t10")) {
/* 6463 */       return 86;
/*      */     }
/* 6465 */     if (strFieldName.equals("t11")) {
/* 6466 */       return 87;
/*      */     }
/* 6468 */     if (strFieldName.equals("t12")) {
/* 6469 */       return 88;
/*      */     }
/* 6471 */     if (strFieldName.equals("t13")) {
/* 6472 */       return 89;
/*      */     }
/* 6474 */     if (strFieldName.equals("t14")) {
/* 6475 */       return 90;
/*      */     }
/* 6477 */     if (strFieldName.equals("t15")) {
/* 6478 */       return 91;
/*      */     }
/* 6480 */     if (strFieldName.equals("t16")) {
/* 6481 */       return 92;
/*      */     }
/* 6483 */     if (strFieldName.equals("t17")) {
/* 6484 */       return 93;
/*      */     }
/* 6486 */     if (strFieldName.equals("t18")) {
/* 6487 */       return 94;
/*      */     }
/* 6489 */     if (strFieldName.equals("t20")) {
/* 6490 */       return 95;
/*      */     }
/* 6492 */     if (strFieldName.equals("t19")) {
/* 6493 */       return 96;
/*      */     }
/* 6495 */     if (strFieldName.equals("monthIndex")) {
/* 6496 */       return 97;
/*      */     }
/* 6498 */     if (strFieldName.equals("tMonthIndex")) {
/* 6499 */       return 98;
/*      */     }
/* 6501 */     if (strFieldName.equals("aSumIndex")) {
/* 6502 */       return 99;
/*      */     }
/* 6504 */     if (strFieldName.equals("wSMMonthEligible")) {
/* 6505 */       return 100;
/*      */     }
/* 6507 */     if (strFieldName.equals("lPQuaPCount")) {
/* 6508 */       return 101;
/*      */     }
/* 6510 */     if (strFieldName.equals("lPQuaFYCSum")) {
/* 6511 */       return 102;
/*      */     }
/* 6513 */     if (strFieldName.equals("b12LPPCount")) {
/* 6514 */       return 103;
/*      */     }
/* 6516 */     if (strFieldName.equals("b12LPNAFYCSum")) {
/* 6517 */       return 104;
/*      */     }
/* 6519 */     if (strFieldName.equals("wSMMonAFYC")) {
/* 6520 */       return 105;
/*      */     }
/* 6522 */     if (strFieldName.equals("wSMTwoMonAFYC")) {
/* 6523 */       return 106;
/*      */     }
/* 6525 */     if (strFieldName.equals("wSMB6AFYC")) {
/* 6526 */       return 107;
/*      */     }
/* 6528 */     if (strFieldName.equals("wSMB6PCount")) {
/* 6529 */       return 108;
/*      */     }
/* 6531 */     if (strFieldName.equals("netLiveLPCount")) {
/* 6532 */       return 109;
/*      */     }
/* 6534 */     if (strFieldName.equals("netComLPCount")) {
/* 6535 */       return 110;
/*      */     }
/* 6537 */     if (strFieldName.equals("wSMTwoMonPCount")) {
/* 6538 */       return 111;
/*      */     }
/* 6540 */     if (strFieldName.equals("lPAllNAFYC")) {
/* 6541 */       return 112;
/*      */     }
/* 6543 */     if (strFieldName.equals("lPAllPCount")) {
/* 6544 */       return 113;
/*      */     }
/* 6546 */     if (strFieldName.equals("monPerSAFYP")) {
/* 6547 */       return 114;
/*      */     }
/* 6549 */     if (strFieldName.equals("tSRThrMonSAFYP")) {
/* 6550 */       return 115;
/*      */     }
/* 6552 */     if (strFieldName.equals("tLThrMonPerSAFYP")) {
/* 6553 */       return 116;
/*      */     }
/* 6555 */     if (strFieldName.equals("monSubsistCnt")) {
/* 6556 */       return 117;
/*      */     }
/* 6558 */     if (strFieldName.equals("thrMonSubsistCnt")) {
/* 6559 */       return 118;
/*      */     }
/* 6561 */     if (strFieldName.equals("state")) {
/* 6562 */       return 119;
/*      */     }
/* 6564 */     if (strFieldName.equals("operator")) {
/* 6565 */       return 120;
/*      */     }
/* 6567 */     if (strFieldName.equals("makeDate")) {
/* 6568 */       return 121;
/*      */     }
/* 6570 */     if (strFieldName.equals("makeTime")) {
/* 6571 */       return 122;
/*      */     }
/* 6573 */     if (strFieldName.equals("modifyDate")) {
/* 6574 */       return 123;
/*      */     }
/* 6576 */     if (strFieldName.equals("modifyTime")) {
/* 6577 */       return 124;
/*      */     }
/* 6579 */     if (strFieldName.equals("assessMonth")) {
/* 6580 */       return 125;
/*      */     }
/* 6582 */     if (strFieldName.equals("branchAttr")) {
/* 6583 */       return 126;
/*      */     }
/* 6585 */     if (strFieldName.equals("agentGrade")) {
/* 6586 */       return 127;
/*      */     }
/* 6588 */     if (strFieldName.equals("clubPromBonus")) {
/* 6589 */       return 128;
/*      */     }
/* 6591 */     if (strFieldName.equals("clubGradeBonus")) {
/* 6592 */       return 129;
/*      */     }
/* 6594 */     if (strFieldName.equals("clubAssisBonus")) {
/* 6595 */       return 130;
/*      */     }
/* 6597 */     if (strFieldName.equals("clubSpecBonus")) {
/* 6598 */       return 131;
/*      */     }
/* 6600 */     if (strFieldName.equals("adddedMoney")) {
/* 6601 */       return 132;
/*      */     }
/* 6603 */     if (strFieldName.equals("lastMoney")) {
/* 6604 */       return 133;
/*      */     }
/* 6606 */     if (strFieldName.equals("shouldMoney")) {
/* 6607 */       return 134;
/*      */     }
/* 6609 */     if (strFieldName.equals("businessTax")) {
/* 6610 */       return 135;
/*      */     }
/* 6612 */     if (strFieldName.equals("eduTax")) {
/* 6613 */       return 136;
/*      */     }
/* 6615 */     if (strFieldName.equals("buildTax")) {
/* 6616 */       return 137;
/*      */     }
/* 6618 */     if (strFieldName.equals("busiCharge")) {
/* 6619 */       return 138;
/*      */     }
/* 6621 */     if (strFieldName.equals("incomeTax")) {
/* 6622 */       return 139;
/*      */     }
/* 6624 */     if (strFieldName.equals("sumMoney")) {
/* 6625 */       return 140;
/*      */     }
/* 6627 */     if (strFieldName.equals("afterTaxMoney")) {
/* 6628 */       return 141;
/*      */     }
/* 6630 */     if (strFieldName.equals("operInCome")) {
/* 6631 */       return 142;
/*      */     }
/* 6633 */     if (strFieldName.equals("t21")) {
/* 6634 */       return 143;
/*      */     }
/* 6636 */     if (strFieldName.equals("t22")) {
/* 6637 */       return 144;
/*      */     }
/* 6639 */     if (strFieldName.equals("t23")) {
/* 6640 */       return 145;
/*      */     }
/* 6642 */     if (strFieldName.equals("t24")) {
/* 6643 */       return 146;
/*      */     }
/* 6645 */     if (strFieldName.equals("t25")) {
/* 6646 */       return 147;
/*      */     }
/* 6648 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 6654 */     String strFieldName = "";
/* 6655 */     switch (nFieldIndex) {
/*      */     case 0:
/* 6657 */       strFieldName = "indexCalNo";
/* 6658 */       break;
/*      */     case 1:
/* 6660 */       strFieldName = "indexType";
/* 6661 */       break;
/*      */     case 2:
/* 6663 */       strFieldName = "agentCode";
/* 6664 */       break;
/*      */     case 3:
/* 6666 */       strFieldName = "agentGroup";
/* 6667 */       break;
/*      */     case 4:
/* 6669 */       strFieldName = "manageCom";
/* 6670 */       break;
/*      */     case 5:
/* 6672 */       strFieldName = "startDate";
/* 6673 */       break;
/*      */     case 6:
/* 6675 */       strFieldName = "startEnd";
/* 6676 */       break;
/*      */     case 7:
/* 6678 */       strFieldName = "quaBgnMark";
/* 6679 */       break;
/*      */     case 8:
/* 6681 */       strFieldName = "serverMonths";
/* 6682 */       break;
/*      */     case 9:
/* 6684 */       strFieldName = "postMonths";
/* 6685 */       break;
/*      */     case 10:
/* 6687 */       strFieldName = "indMonthFYC";
/* 6688 */       break;
/*      */     case 11:
/* 6690 */       strFieldName = "indMonthSYC";
/* 6691 */       break;
/*      */     case 12:
/* 6693 */       strFieldName = "indMonSignFYC";
/* 6694 */       break;
/*      */     case 13:
/* 6696 */       strFieldName = "indMonSignAFYC";
/* 6697 */       break;
/*      */     case 14:
/* 6699 */       strFieldName = "indMonSignNAFYC";
/* 6700 */       break;
/*      */     case 15:
/* 6702 */       strFieldName = "grpMonSignNAFYC";
/* 6703 */       break;
/*      */     case 16:
/* 6705 */       strFieldName = "monPolCnt";
/* 6706 */       break;
/*      */     case 17:
/* 6708 */       strFieldName = "montCustCnt";
/* 6709 */       break;
/*      */     case 18:
/* 6711 */       strFieldName = "indMonPCount";
/* 6712 */       break;
/*      */     case 19:
/* 6714 */       strFieldName = "sMmonPolContin";
/* 6715 */       break;
/*      */     case 20:
/* 6717 */       strFieldName = "sMmonProduct";
/* 6718 */       break;
/*      */     case 21:
/* 6720 */       strFieldName = "sMworkMon";
/* 6721 */       break;
/*      */     case 22:
/* 6723 */       strFieldName = "monPCount";
/* 6724 */       break;
/*      */     case 23:
/* 6726 */       strFieldName = "wSMMonPCount";
/* 6727 */       break;
/*      */     case 24:
/* 6729 */       strFieldName = "lPMonForSMMP";
/* 6730 */       break;
/*      */     case 25:
/* 6732 */       strFieldName = "lPMonForAMMP";
/* 6733 */       break;
/*      */     case 26:
/* 6735 */       strFieldName = "lPpolContinute";
/* 6736 */       break;
/*      */     case 27:
/* 6738 */       strFieldName = "monEligFLPCnt";
/* 6739 */       break;
/*      */     case 28:
/* 6741 */       strFieldName = "tSRmonAFYP";
/* 6742 */       break;
/*      */     case 29:
/* 6744 */       strFieldName = "tSRmonDedAFYP";
/* 6745 */       break;
/*      */     case 30:
/* 6747 */       strFieldName = "tSRmonCompAFYP";
/* 6748 */       break;
/*      */     case 31:
/* 6750 */       strFieldName = "tSRMonWorkDays";
/* 6751 */       break;
/*      */     case 32:
/* 6753 */       strFieldName = "monManPower";
/* 6754 */       break;
/*      */     case 33:
/* 6756 */       strFieldName = "monManCount";
/* 6757 */       break;
/*      */     case 34:
/* 6759 */       strFieldName = "monSAFYPSum";
/* 6760 */       break;
/*      */     case 35:
/* 6762 */       strFieldName = "monTLGrpSAFYPSum";
/* 6763 */       break;
/*      */     case 36:
/* 6765 */       strFieldName = "indYearNAFYC";
/* 6766 */       break;
/*      */     case 37:
/* 6768 */       strFieldName = "b12IndEffectAFYC";
/* 6769 */       break;
/*      */     case 38:
/* 6771 */       strFieldName = "b12IndAllAFYC";
/* 6772 */       break;
/*      */     case 39:
/* 6774 */       strFieldName = "b24IndEffectAFYC";
/* 6775 */       break;
/*      */     case 40:
/* 6777 */       strFieldName = "b24IndAllAFYC";
/* 6778 */       break;
/*      */     case 41:
/* 6780 */       strFieldName = "indQutFYC";
/* 6781 */       break;
/*      */     case 42:
/* 6783 */       strFieldName = "lPproductivity";
/* 6784 */       break;
/*      */     case 43:
/* 6786 */       strFieldName = "lPPPRate";
/* 6787 */       break;
/*      */     case 44:
/* 6789 */       strFieldName = "lPPPBonus";
/* 6790 */       break;
/*      */     case 45:
/* 6792 */       strFieldName = "lPFincSubsidy";
/* 6793 */       break;
/*      */     case 46:
/* 6795 */       strFieldName = "subsidyRate";
/* 6796 */       break;
/*      */     case 47:
/* 6798 */       strFieldName = "b12TeamNAFYC";
/* 6799 */       break;
/*      */     case 48:
/* 6801 */       strFieldName = "sMOverride";
/* 6802 */       break;
/*      */     case 49:
/* 6804 */       strFieldName = "teamMonAvgPCount";
/* 6805 */       break;
/*      */     case 50:
/* 6807 */       strFieldName = "sMBasicSalary";
/* 6808 */       break;
/*      */     case 51:
/* 6810 */       strFieldName = "sMproductivity";
/* 6811 */       break;
/*      */     case 52:
/* 6813 */       strFieldName = "sMpolContinute";
/* 6814 */       break;
/*      */     case 53:
/* 6816 */       strFieldName = "sMPPRate";
/* 6817 */       break;
/*      */     case 54:
/* 6819 */       strFieldName = "sMPPBonus";
/* 6820 */       break;
/*      */     case 55:
/* 6822 */       strFieldName = "b24TeamEffectAFYC";
/* 6823 */       break;
/*      */     case 56:
/* 6825 */       strFieldName = "b24TeamAllAFYC";
/* 6826 */       break;
/*      */     case 57:
/* 6828 */       strFieldName = "teamQutPremSum";
/* 6829 */       break;
/*      */     case 58:
/* 6831 */       strFieldName = "sMRRBonus";
/* 6832 */       break;
/*      */     case 59:
/* 6834 */       strFieldName = "sMManPowerDBonus";
/* 6835 */       break;
/*      */     case 60:
/* 6837 */       strFieldName = "lPB12ForMPDBonus";
/* 6838 */       break;
/*      */     case 61:
/* 6840 */       strFieldName = "sMUsualALLCSum";
/* 6841 */       break;
/*      */     case 62:
/* 6843 */       strFieldName = "aMBasicSalary";
/* 6844 */       break;
/*      */     case 63:
/* 6846 */       strFieldName = "aMproductivity";
/* 6847 */       break;
/*      */     case 64:
/* 6849 */       strFieldName = "aMpolContinute";
/* 6850 */       break;
/*      */     case 65:
/* 6852 */       strFieldName = "aMPPRate";
/* 6853 */       break;
/*      */     case 66:
/* 6855 */       strFieldName = "aMPPBonus";
/* 6856 */       break;
/*      */     case 67:
/* 6858 */       strFieldName = "b12DepNAFYC";
/* 6859 */       break;
/*      */     case 68:
/* 6861 */       strFieldName = "aMOverride";
/* 6862 */       break;
/*      */     case 69:
/* 6864 */       strFieldName = "depMonAvgPCount";
/* 6865 */       break;
/*      */     case 70:
/* 6867 */       strFieldName = "depQutPremSum";
/* 6868 */       break;
/*      */     case 71:
/* 6870 */       strFieldName = "aMRRBonus";
/* 6871 */       break;
/*      */     case 72:
/* 6873 */       strFieldName = "aMManPowerDBonus";
/* 6874 */       break;
/*      */     case 73:
/* 6876 */       strFieldName = "productGrowth";
/* 6877 */       break;
/*      */     case 74:
/* 6879 */       strFieldName = "depQuaFYCSum";
/* 6880 */       break;
/*      */     case 75:
/* 6882 */       strFieldName = "aMLiability";
/* 6883 */       break;
/*      */     case 76:
/* 6885 */       strFieldName = "reviOpen";
/* 6886 */       break;
/*      */     case 77:
/* 6888 */       strFieldName = "t1";
/* 6889 */       break;
/*      */     case 78:
/* 6891 */       strFieldName = "t2";
/* 6892 */       break;
/*      */     case 79:
/* 6894 */       strFieldName = "t3";
/* 6895 */       break;
/*      */     case 80:
/* 6897 */       strFieldName = "t4";
/* 6898 */       break;
/*      */     case 81:
/* 6900 */       strFieldName = "t5";
/* 6901 */       break;
/*      */     case 82:
/* 6903 */       strFieldName = "t6";
/* 6904 */       break;
/*      */     case 83:
/* 6906 */       strFieldName = "t7";
/* 6907 */       break;
/*      */     case 84:
/* 6909 */       strFieldName = "t8";
/* 6910 */       break;
/*      */     case 85:
/* 6912 */       strFieldName = "t9";
/* 6913 */       break;
/*      */     case 86:
/* 6915 */       strFieldName = "t10";
/* 6916 */       break;
/*      */     case 87:
/* 6918 */       strFieldName = "t11";
/* 6919 */       break;
/*      */     case 88:
/* 6921 */       strFieldName = "t12";
/* 6922 */       break;
/*      */     case 89:
/* 6924 */       strFieldName = "t13";
/* 6925 */       break;
/*      */     case 90:
/* 6927 */       strFieldName = "t14";
/* 6928 */       break;
/*      */     case 91:
/* 6930 */       strFieldName = "t15";
/* 6931 */       break;
/*      */     case 92:
/* 6933 */       strFieldName = "t16";
/* 6934 */       break;
/*      */     case 93:
/* 6936 */       strFieldName = "t17";
/* 6937 */       break;
/*      */     case 94:
/* 6939 */       strFieldName = "t18";
/* 6940 */       break;
/*      */     case 95:
/* 6942 */       strFieldName = "t20";
/* 6943 */       break;
/*      */     case 96:
/* 6945 */       strFieldName = "t19";
/* 6946 */       break;
/*      */     case 97:
/* 6948 */       strFieldName = "monthIndex";
/* 6949 */       break;
/*      */     case 98:
/* 6951 */       strFieldName = "tMonthIndex";
/* 6952 */       break;
/*      */     case 99:
/* 6954 */       strFieldName = "aSumIndex";
/* 6955 */       break;
/*      */     case 100:
/* 6957 */       strFieldName = "wSMMonthEligible";
/* 6958 */       break;
/*      */     case 101:
/* 6960 */       strFieldName = "lPQuaPCount";
/* 6961 */       break;
/*      */     case 102:
/* 6963 */       strFieldName = "lPQuaFYCSum";
/* 6964 */       break;
/*      */     case 103:
/* 6966 */       strFieldName = "b12LPPCount";
/* 6967 */       break;
/*      */     case 104:
/* 6969 */       strFieldName = "b12LPNAFYCSum";
/* 6970 */       break;
/*      */     case 105:
/* 6972 */       strFieldName = "wSMMonAFYC";
/* 6973 */       break;
/*      */     case 106:
/* 6975 */       strFieldName = "wSMTwoMonAFYC";
/* 6976 */       break;
/*      */     case 107:
/* 6978 */       strFieldName = "wSMB6AFYC";
/* 6979 */       break;
/*      */     case 108:
/* 6981 */       strFieldName = "wSMB6PCount";
/* 6982 */       break;
/*      */     case 109:
/* 6984 */       strFieldName = "netLiveLPCount";
/* 6985 */       break;
/*      */     case 110:
/* 6987 */       strFieldName = "netComLPCount";
/* 6988 */       break;
/*      */     case 111:
/* 6990 */       strFieldName = "wSMTwoMonPCount";
/* 6991 */       break;
/*      */     case 112:
/* 6993 */       strFieldName = "lPAllNAFYC";
/* 6994 */       break;
/*      */     case 113:
/* 6996 */       strFieldName = "lPAllPCount";
/* 6997 */       break;
/*      */     case 114:
/* 6999 */       strFieldName = "monPerSAFYP";
/* 7000 */       break;
/*      */     case 115:
/* 7002 */       strFieldName = "tSRThrMonSAFYP";
/* 7003 */       break;
/*      */     case 116:
/* 7005 */       strFieldName = "tLThrMonPerSAFYP";
/* 7006 */       break;
/*      */     case 117:
/* 7008 */       strFieldName = "monSubsistCnt";
/* 7009 */       break;
/*      */     case 118:
/* 7011 */       strFieldName = "thrMonSubsistCnt";
/* 7012 */       break;
/*      */     case 119:
/* 7014 */       strFieldName = "state";
/* 7015 */       break;
/*      */     case 120:
/* 7017 */       strFieldName = "operator";
/* 7018 */       break;
/*      */     case 121:
/* 7020 */       strFieldName = "makeDate";
/* 7021 */       break;
/*      */     case 122:
/* 7023 */       strFieldName = "makeTime";
/* 7024 */       break;
/*      */     case 123:
/* 7026 */       strFieldName = "modifyDate";
/* 7027 */       break;
/*      */     case 124:
/* 7029 */       strFieldName = "modifyTime";
/* 7030 */       break;
/*      */     case 125:
/* 7032 */       strFieldName = "assessMonth";
/* 7033 */       break;
/*      */     case 126:
/* 7035 */       strFieldName = "branchAttr";
/* 7036 */       break;
/*      */     case 127:
/* 7038 */       strFieldName = "agentGrade";
/* 7039 */       break;
/*      */     case 128:
/* 7041 */       strFieldName = "clubPromBonus";
/* 7042 */       break;
/*      */     case 129:
/* 7044 */       strFieldName = "clubGradeBonus";
/* 7045 */       break;
/*      */     case 130:
/* 7047 */       strFieldName = "clubAssisBonus";
/* 7048 */       break;
/*      */     case 131:
/* 7050 */       strFieldName = "clubSpecBonus";
/* 7051 */       break;
/*      */     case 132:
/* 7053 */       strFieldName = "adddedMoney";
/* 7054 */       break;
/*      */     case 133:
/* 7056 */       strFieldName = "lastMoney";
/* 7057 */       break;
/*      */     case 134:
/* 7059 */       strFieldName = "shouldMoney";
/* 7060 */       break;
/*      */     case 135:
/* 7062 */       strFieldName = "businessTax";
/* 7063 */       break;
/*      */     case 136:
/* 7065 */       strFieldName = "eduTax";
/* 7066 */       break;
/*      */     case 137:
/* 7068 */       strFieldName = "buildTax";
/* 7069 */       break;
/*      */     case 138:
/* 7071 */       strFieldName = "busiCharge";
/* 7072 */       break;
/*      */     case 139:
/* 7074 */       strFieldName = "incomeTax";
/* 7075 */       break;
/*      */     case 140:
/* 7077 */       strFieldName = "sumMoney";
/* 7078 */       break;
/*      */     case 141:
/* 7080 */       strFieldName = "afterTaxMoney";
/* 7081 */       break;
/*      */     case 142:
/* 7083 */       strFieldName = "operInCome";
/* 7084 */       break;
/*      */     case 143:
/* 7086 */       strFieldName = "t21";
/* 7087 */       break;
/*      */     case 144:
/* 7089 */       strFieldName = "t22";
/* 7090 */       break;
/*      */     case 145:
/* 7092 */       strFieldName = "t23";
/* 7093 */       break;
/*      */     case 146:
/* 7095 */       strFieldName = "t24";
/* 7096 */       break;
/*      */     case 147:
/* 7098 */       strFieldName = "t25";
/* 7099 */       break;
/*      */     default:
/* 7101 */       strFieldName = "";
/*      */     }
/* 7103 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 7109 */     if (strFieldName.equals("indexCalNo")) {
/* 7110 */       return 0;
/*      */     }
/* 7112 */     if (strFieldName.equals("indexType")) {
/* 7113 */       return 0;
/*      */     }
/* 7115 */     if (strFieldName.equals("agentCode")) {
/* 7116 */       return 0;
/*      */     }
/* 7118 */     if (strFieldName.equals("agentGroup")) {
/* 7119 */       return 0;
/*      */     }
/* 7121 */     if (strFieldName.equals("manageCom")) {
/* 7122 */       return 0;
/*      */     }
/* 7124 */     if (strFieldName.equals("startDate")) {
/* 7125 */       return 1;
/*      */     }
/* 7127 */     if (strFieldName.equals("startEnd")) {
/* 7128 */       return 1;
/*      */     }
/* 7130 */     if (strFieldName.equals("quaBgnMark")) {
/* 7131 */       return 3;
/*      */     }
/* 7133 */     if (strFieldName.equals("serverMonths")) {
/* 7134 */       return 3;
/*      */     }
/* 7136 */     if (strFieldName.equals("postMonths")) {
/* 7137 */       return 3;
/*      */     }
/* 7139 */     if (strFieldName.equals("indMonthFYC")) {
/* 7140 */       return 4;
/*      */     }
/* 7142 */     if (strFieldName.equals("indMonthSYC")) {
/* 7143 */       return 4;
/*      */     }
/* 7145 */     if (strFieldName.equals("indMonSignFYC")) {
/* 7146 */       return 4;
/*      */     }
/* 7148 */     if (strFieldName.equals("indMonSignAFYC")) {
/* 7149 */       return 4;
/*      */     }
/* 7151 */     if (strFieldName.equals("indMonSignNAFYC")) {
/* 7152 */       return 4;
/*      */     }
/* 7154 */     if (strFieldName.equals("grpMonSignNAFYC")) {
/* 7155 */       return 4;
/*      */     }
/* 7157 */     if (strFieldName.equals("monPolCnt")) {
/* 7158 */       return 4;
/*      */     }
/* 7160 */     if (strFieldName.equals("montCustCnt")) {
/* 7161 */       return 4;
/*      */     }
/* 7163 */     if (strFieldName.equals("indMonPCount")) {
/* 7164 */       return 4;
/*      */     }
/* 7166 */     if (strFieldName.equals("sMmonPolContin")) {
/* 7167 */       return 4;
/*      */     }
/* 7169 */     if (strFieldName.equals("sMmonProduct")) {
/* 7170 */       return 4;
/*      */     }
/* 7172 */     if (strFieldName.equals("sMworkMon")) {
/* 7173 */       return 4;
/*      */     }
/* 7175 */     if (strFieldName.equals("monPCount")) {
/* 7176 */       return 4;
/*      */     }
/* 7178 */     if (strFieldName.equals("wSMMonPCount")) {
/* 7179 */       return 4;
/*      */     }
/* 7181 */     if (strFieldName.equals("lPMonForSMMP")) {
/* 7182 */       return 4;
/*      */     }
/* 7184 */     if (strFieldName.equals("lPMonForAMMP")) {
/* 7185 */       return 4;
/*      */     }
/* 7187 */     if (strFieldName.equals("lPpolContinute")) {
/* 7188 */       return 4;
/*      */     }
/* 7190 */     if (strFieldName.equals("monEligFLPCnt")) {
/* 7191 */       return 4;
/*      */     }
/* 7193 */     if (strFieldName.equals("tSRmonAFYP")) {
/* 7194 */       return 4;
/*      */     }
/* 7196 */     if (strFieldName.equals("tSRmonDedAFYP")) {
/* 7197 */       return 4;
/*      */     }
/* 7199 */     if (strFieldName.equals("tSRmonCompAFYP")) {
/* 7200 */       return 4;
/*      */     }
/* 7202 */     if (strFieldName.equals("tSRMonWorkDays")) {
/* 7203 */       return 4;
/*      */     }
/* 7205 */     if (strFieldName.equals("monManPower")) {
/* 7206 */       return 4;
/*      */     }
/* 7208 */     if (strFieldName.equals("monManCount")) {
/* 7209 */       return 4;
/*      */     }
/* 7211 */     if (strFieldName.equals("monSAFYPSum")) {
/* 7212 */       return 4;
/*      */     }
/* 7214 */     if (strFieldName.equals("monTLGrpSAFYPSum")) {
/* 7215 */       return 4;
/*      */     }
/* 7217 */     if (strFieldName.equals("indYearNAFYC")) {
/* 7218 */       return 4;
/*      */     }
/* 7220 */     if (strFieldName.equals("b12IndEffectAFYC")) {
/* 7221 */       return 4;
/*      */     }
/* 7223 */     if (strFieldName.equals("b12IndAllAFYC")) {
/* 7224 */       return 4;
/*      */     }
/* 7226 */     if (strFieldName.equals("b24IndEffectAFYC")) {
/* 7227 */       return 4;
/*      */     }
/* 7229 */     if (strFieldName.equals("b24IndAllAFYC")) {
/* 7230 */       return 4;
/*      */     }
/* 7232 */     if (strFieldName.equals("indQutFYC")) {
/* 7233 */       return 4;
/*      */     }
/* 7235 */     if (strFieldName.equals("lPproductivity")) {
/* 7236 */       return 4;
/*      */     }
/* 7238 */     if (strFieldName.equals("lPPPRate")) {
/* 7239 */       return 4;
/*      */     }
/* 7241 */     if (strFieldName.equals("lPPPBonus")) {
/* 7242 */       return 4;
/*      */     }
/* 7244 */     if (strFieldName.equals("lPFincSubsidy")) {
/* 7245 */       return 4;
/*      */     }
/* 7247 */     if (strFieldName.equals("subsidyRate")) {
/* 7248 */       return 4;
/*      */     }
/* 7250 */     if (strFieldName.equals("b12TeamNAFYC")) {
/* 7251 */       return 4;
/*      */     }
/* 7253 */     if (strFieldName.equals("sMOverride")) {
/* 7254 */       return 4;
/*      */     }
/* 7256 */     if (strFieldName.equals("teamMonAvgPCount")) {
/* 7257 */       return 4;
/*      */     }
/* 7259 */     if (strFieldName.equals("sMBasicSalary")) {
/* 7260 */       return 4;
/*      */     }
/* 7262 */     if (strFieldName.equals("sMproductivity")) {
/* 7263 */       return 4;
/*      */     }
/* 7265 */     if (strFieldName.equals("sMpolContinute")) {
/* 7266 */       return 4;
/*      */     }
/* 7268 */     if (strFieldName.equals("sMPPRate")) {
/* 7269 */       return 4;
/*      */     }
/* 7271 */     if (strFieldName.equals("sMPPBonus")) {
/* 7272 */       return 4;
/*      */     }
/* 7274 */     if (strFieldName.equals("b24TeamEffectAFYC")) {
/* 7275 */       return 4;
/*      */     }
/* 7277 */     if (strFieldName.equals("b24TeamAllAFYC")) {
/* 7278 */       return 4;
/*      */     }
/* 7280 */     if (strFieldName.equals("teamQutPremSum")) {
/* 7281 */       return 4;
/*      */     }
/* 7283 */     if (strFieldName.equals("sMRRBonus")) {
/* 7284 */       return 4;
/*      */     }
/* 7286 */     if (strFieldName.equals("sMManPowerDBonus")) {
/* 7287 */       return 4;
/*      */     }
/* 7289 */     if (strFieldName.equals("lPB12ForMPDBonus")) {
/* 7290 */       return 4;
/*      */     }
/* 7292 */     if (strFieldName.equals("sMUsualALLCSum")) {
/* 7293 */       return 4;
/*      */     }
/* 7295 */     if (strFieldName.equals("aMBasicSalary")) {
/* 7296 */       return 4;
/*      */     }
/* 7298 */     if (strFieldName.equals("aMproductivity")) {
/* 7299 */       return 4;
/*      */     }
/* 7301 */     if (strFieldName.equals("aMpolContinute")) {
/* 7302 */       return 4;
/*      */     }
/* 7304 */     if (strFieldName.equals("aMPPRate")) {
/* 7305 */       return 4;
/*      */     }
/* 7307 */     if (strFieldName.equals("aMPPBonus")) {
/* 7308 */       return 4;
/*      */     }
/* 7310 */     if (strFieldName.equals("b12DepNAFYC")) {
/* 7311 */       return 4;
/*      */     }
/* 7313 */     if (strFieldName.equals("aMOverride")) {
/* 7314 */       return 4;
/*      */     }
/* 7316 */     if (strFieldName.equals("depMonAvgPCount")) {
/* 7317 */       return 4;
/*      */     }
/* 7319 */     if (strFieldName.equals("depQutPremSum")) {
/* 7320 */       return 4;
/*      */     }
/* 7322 */     if (strFieldName.equals("aMRRBonus")) {
/* 7323 */       return 4;
/*      */     }
/* 7325 */     if (strFieldName.equals("aMManPowerDBonus")) {
/* 7326 */       return 4;
/*      */     }
/* 7328 */     if (strFieldName.equals("productGrowth")) {
/* 7329 */       return 4;
/*      */     }
/* 7331 */     if (strFieldName.equals("depQuaFYCSum")) {
/* 7332 */       return 4;
/*      */     }
/* 7334 */     if (strFieldName.equals("aMLiability")) {
/* 7335 */       return 4;
/*      */     }
/* 7337 */     if (strFieldName.equals("reviOpen")) {
/* 7338 */       return 4;
/*      */     }
/* 7340 */     if (strFieldName.equals("t1")) {
/* 7341 */       return 4;
/*      */     }
/* 7343 */     if (strFieldName.equals("t2")) {
/* 7344 */       return 4;
/*      */     }
/* 7346 */     if (strFieldName.equals("t3")) {
/* 7347 */       return 4;
/*      */     }
/* 7349 */     if (strFieldName.equals("t4")) {
/* 7350 */       return 4;
/*      */     }
/* 7352 */     if (strFieldName.equals("t5")) {
/* 7353 */       return 4;
/*      */     }
/* 7355 */     if (strFieldName.equals("t6")) {
/* 7356 */       return 4;
/*      */     }
/* 7358 */     if (strFieldName.equals("t7")) {
/* 7359 */       return 4;
/*      */     }
/* 7361 */     if (strFieldName.equals("t8")) {
/* 7362 */       return 4;
/*      */     }
/* 7364 */     if (strFieldName.equals("t9")) {
/* 7365 */       return 4;
/*      */     }
/* 7367 */     if (strFieldName.equals("t10")) {
/* 7368 */       return 4;
/*      */     }
/* 7370 */     if (strFieldName.equals("t11")) {
/* 7371 */       return 4;
/*      */     }
/* 7373 */     if (strFieldName.equals("t12")) {
/* 7374 */       return 4;
/*      */     }
/* 7376 */     if (strFieldName.equals("t13")) {
/* 7377 */       return 4;
/*      */     }
/* 7379 */     if (strFieldName.equals("t14")) {
/* 7380 */       return 4;
/*      */     }
/* 7382 */     if (strFieldName.equals("t15")) {
/* 7383 */       return 4;
/*      */     }
/* 7385 */     if (strFieldName.equals("t16")) {
/* 7386 */       return 4;
/*      */     }
/* 7388 */     if (strFieldName.equals("t17")) {
/* 7389 */       return 4;
/*      */     }
/* 7391 */     if (strFieldName.equals("t18")) {
/* 7392 */       return 4;
/*      */     }
/* 7394 */     if (strFieldName.equals("t20")) {
/* 7395 */       return 4;
/*      */     }
/* 7397 */     if (strFieldName.equals("t19")) {
/* 7398 */       return 4;
/*      */     }
/* 7400 */     if (strFieldName.equals("monthIndex")) {
/* 7401 */       return 4;
/*      */     }
/* 7403 */     if (strFieldName.equals("tMonthIndex")) {
/* 7404 */       return 4;
/*      */     }
/* 7406 */     if (strFieldName.equals("aSumIndex")) {
/* 7407 */       return 4;
/*      */     }
/* 7409 */     if (strFieldName.equals("wSMMonthEligible")) {
/* 7410 */       return 4;
/*      */     }
/* 7412 */     if (strFieldName.equals("lPQuaPCount")) {
/* 7413 */       return 4;
/*      */     }
/* 7415 */     if (strFieldName.equals("lPQuaFYCSum")) {
/* 7416 */       return 4;
/*      */     }
/* 7418 */     if (strFieldName.equals("b12LPPCount")) {
/* 7419 */       return 4;
/*      */     }
/* 7421 */     if (strFieldName.equals("b12LPNAFYCSum")) {
/* 7422 */       return 4;
/*      */     }
/* 7424 */     if (strFieldName.equals("wSMMonAFYC")) {
/* 7425 */       return 4;
/*      */     }
/* 7427 */     if (strFieldName.equals("wSMTwoMonAFYC")) {
/* 7428 */       return 4;
/*      */     }
/* 7430 */     if (strFieldName.equals("wSMB6AFYC")) {
/* 7431 */       return 4;
/*      */     }
/* 7433 */     if (strFieldName.equals("wSMB6PCount")) {
/* 7434 */       return 4;
/*      */     }
/* 7436 */     if (strFieldName.equals("netLiveLPCount")) {
/* 7437 */       return 4;
/*      */     }
/* 7439 */     if (strFieldName.equals("netComLPCount")) {
/* 7440 */       return 4;
/*      */     }
/* 7442 */     if (strFieldName.equals("wSMTwoMonPCount")) {
/* 7443 */       return 4;
/*      */     }
/* 7445 */     if (strFieldName.equals("lPAllNAFYC")) {
/* 7446 */       return 4;
/*      */     }
/* 7448 */     if (strFieldName.equals("lPAllPCount")) {
/* 7449 */       return 4;
/*      */     }
/* 7451 */     if (strFieldName.equals("monPerSAFYP")) {
/* 7452 */       return 4;
/*      */     }
/* 7454 */     if (strFieldName.equals("tSRThrMonSAFYP")) {
/* 7455 */       return 4;
/*      */     }
/* 7457 */     if (strFieldName.equals("tLThrMonPerSAFYP")) {
/* 7458 */       return 4;
/*      */     }
/* 7460 */     if (strFieldName.equals("monSubsistCnt")) {
/* 7461 */       return 4;
/*      */     }
/* 7463 */     if (strFieldName.equals("thrMonSubsistCnt")) {
/* 7464 */       return 4;
/*      */     }
/* 7466 */     if (strFieldName.equals("state")) {
/* 7467 */       return 0;
/*      */     }
/* 7469 */     if (strFieldName.equals("operator")) {
/* 7470 */       return 0;
/*      */     }
/* 7472 */     if (strFieldName.equals("makeDate")) {
/* 7473 */       return 1;
/*      */     }
/* 7475 */     if (strFieldName.equals("makeTime")) {
/* 7476 */       return 0;
/*      */     }
/* 7478 */     if (strFieldName.equals("modifyDate")) {
/* 7479 */       return 1;
/*      */     }
/* 7481 */     if (strFieldName.equals("modifyTime")) {
/* 7482 */       return 0;
/*      */     }
/* 7484 */     if (strFieldName.equals("assessMonth")) {
/* 7485 */       return 0;
/*      */     }
/* 7487 */     if (strFieldName.equals("branchAttr")) {
/* 7488 */       return 0;
/*      */     }
/* 7490 */     if (strFieldName.equals("agentGrade")) {
/* 7491 */       return 0;
/*      */     }
/* 7493 */     if (strFieldName.equals("clubPromBonus")) {
/* 7494 */       return 4;
/*      */     }
/* 7496 */     if (strFieldName.equals("clubGradeBonus")) {
/* 7497 */       return 4;
/*      */     }
/* 7499 */     if (strFieldName.equals("clubAssisBonus")) {
/* 7500 */       return 4;
/*      */     }
/* 7502 */     if (strFieldName.equals("clubSpecBonus")) {
/* 7503 */       return 4;
/*      */     }
/* 7505 */     if (strFieldName.equals("adddedMoney")) {
/* 7506 */       return 4;
/*      */     }
/* 7508 */     if (strFieldName.equals("lastMoney")) {
/* 7509 */       return 4;
/*      */     }
/* 7511 */     if (strFieldName.equals("shouldMoney")) {
/* 7512 */       return 4;
/*      */     }
/* 7514 */     if (strFieldName.equals("businessTax")) {
/* 7515 */       return 4;
/*      */     }
/* 7517 */     if (strFieldName.equals("eduTax")) {
/* 7518 */       return 4;
/*      */     }
/* 7520 */     if (strFieldName.equals("buildTax")) {
/* 7521 */       return 4;
/*      */     }
/* 7523 */     if (strFieldName.equals("busiCharge")) {
/* 7524 */       return 4;
/*      */     }
/* 7526 */     if (strFieldName.equals("incomeTax")) {
/* 7527 */       return 4;
/*      */     }
/* 7529 */     if (strFieldName.equals("sumMoney")) {
/* 7530 */       return 4;
/*      */     }
/* 7532 */     if (strFieldName.equals("afterTaxMoney")) {
/* 7533 */       return 4;
/*      */     }
/* 7535 */     if (strFieldName.equals("operInCome")) {
/* 7536 */       return 4;
/*      */     }
/* 7538 */     if (strFieldName.equals("t21")) {
/* 7539 */       return 4;
/*      */     }
/* 7541 */     if (strFieldName.equals("t22")) {
/* 7542 */       return 4;
/*      */     }
/* 7544 */     if (strFieldName.equals("t23")) {
/* 7545 */       return 4;
/*      */     }
/* 7547 */     if (strFieldName.equals("t24")) {
/* 7548 */       return 4;
/*      */     }
/* 7550 */     if (strFieldName.equals("t25")) {
/* 7551 */       return 4;
/*      */     }
/* 7553 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 7559 */     int nFieldType = -1;
/* 7560 */     switch (nFieldIndex) {
/*      */     case 0:
/* 7562 */       nFieldType = 0;
/* 7563 */       break;
/*      */     case 1:
/* 7565 */       nFieldType = 0;
/* 7566 */       break;
/*      */     case 2:
/* 7568 */       nFieldType = 0;
/* 7569 */       break;
/*      */     case 3:
/* 7571 */       nFieldType = 0;
/* 7572 */       break;
/*      */     case 4:
/* 7574 */       nFieldType = 0;
/* 7575 */       break;
/*      */     case 5:
/* 7577 */       nFieldType = 1;
/* 7578 */       break;
/*      */     case 6:
/* 7580 */       nFieldType = 1;
/* 7581 */       break;
/*      */     case 7:
/* 7583 */       nFieldType = 3;
/* 7584 */       break;
/*      */     case 8:
/* 7586 */       nFieldType = 3;
/* 7587 */       break;
/*      */     case 9:
/* 7589 */       nFieldType = 3;
/* 7590 */       break;
/*      */     case 10:
/* 7592 */       nFieldType = 4;
/* 7593 */       break;
/*      */     case 11:
/* 7595 */       nFieldType = 4;
/* 7596 */       break;
/*      */     case 12:
/* 7598 */       nFieldType = 4;
/* 7599 */       break;
/*      */     case 13:
/* 7601 */       nFieldType = 4;
/* 7602 */       break;
/*      */     case 14:
/* 7604 */       nFieldType = 4;
/* 7605 */       break;
/*      */     case 15:
/* 7607 */       nFieldType = 4;
/* 7608 */       break;
/*      */     case 16:
/* 7610 */       nFieldType = 4;
/* 7611 */       break;
/*      */     case 17:
/* 7613 */       nFieldType = 4;
/* 7614 */       break;
/*      */     case 18:
/* 7616 */       nFieldType = 4;
/* 7617 */       break;
/*      */     case 19:
/* 7619 */       nFieldType = 4;
/* 7620 */       break;
/*      */     case 20:
/* 7622 */       nFieldType = 4;
/* 7623 */       break;
/*      */     case 21:
/* 7625 */       nFieldType = 4;
/* 7626 */       break;
/*      */     case 22:
/* 7628 */       nFieldType = 4;
/* 7629 */       break;
/*      */     case 23:
/* 7631 */       nFieldType = 4;
/* 7632 */       break;
/*      */     case 24:
/* 7634 */       nFieldType = 4;
/* 7635 */       break;
/*      */     case 25:
/* 7637 */       nFieldType = 4;
/* 7638 */       break;
/*      */     case 26:
/* 7640 */       nFieldType = 4;
/* 7641 */       break;
/*      */     case 27:
/* 7643 */       nFieldType = 4;
/* 7644 */       break;
/*      */     case 28:
/* 7646 */       nFieldType = 4;
/* 7647 */       break;
/*      */     case 29:
/* 7649 */       nFieldType = 4;
/* 7650 */       break;
/*      */     case 30:
/* 7652 */       nFieldType = 4;
/* 7653 */       break;
/*      */     case 31:
/* 7655 */       nFieldType = 4;
/* 7656 */       break;
/*      */     case 32:
/* 7658 */       nFieldType = 4;
/* 7659 */       break;
/*      */     case 33:
/* 7661 */       nFieldType = 4;
/* 7662 */       break;
/*      */     case 34:
/* 7664 */       nFieldType = 4;
/* 7665 */       break;
/*      */     case 35:
/* 7667 */       nFieldType = 4;
/* 7668 */       break;
/*      */     case 36:
/* 7670 */       nFieldType = 4;
/* 7671 */       break;
/*      */     case 37:
/* 7673 */       nFieldType = 4;
/* 7674 */       break;
/*      */     case 38:
/* 7676 */       nFieldType = 4;
/* 7677 */       break;
/*      */     case 39:
/* 7679 */       nFieldType = 4;
/* 7680 */       break;
/*      */     case 40:
/* 7682 */       nFieldType = 4;
/* 7683 */       break;
/*      */     case 41:
/* 7685 */       nFieldType = 4;
/* 7686 */       break;
/*      */     case 42:
/* 7688 */       nFieldType = 4;
/* 7689 */       break;
/*      */     case 43:
/* 7691 */       nFieldType = 4;
/* 7692 */       break;
/*      */     case 44:
/* 7694 */       nFieldType = 4;
/* 7695 */       break;
/*      */     case 45:
/* 7697 */       nFieldType = 4;
/* 7698 */       break;
/*      */     case 46:
/* 7700 */       nFieldType = 4;
/* 7701 */       break;
/*      */     case 47:
/* 7703 */       nFieldType = 4;
/* 7704 */       break;
/*      */     case 48:
/* 7706 */       nFieldType = 4;
/* 7707 */       break;
/*      */     case 49:
/* 7709 */       nFieldType = 4;
/* 7710 */       break;
/*      */     case 50:
/* 7712 */       nFieldType = 4;
/* 7713 */       break;
/*      */     case 51:
/* 7715 */       nFieldType = 4;
/* 7716 */       break;
/*      */     case 52:
/* 7718 */       nFieldType = 4;
/* 7719 */       break;
/*      */     case 53:
/* 7721 */       nFieldType = 4;
/* 7722 */       break;
/*      */     case 54:
/* 7724 */       nFieldType = 4;
/* 7725 */       break;
/*      */     case 55:
/* 7727 */       nFieldType = 4;
/* 7728 */       break;
/*      */     case 56:
/* 7730 */       nFieldType = 4;
/* 7731 */       break;
/*      */     case 57:
/* 7733 */       nFieldType = 4;
/* 7734 */       break;
/*      */     case 58:
/* 7736 */       nFieldType = 4;
/* 7737 */       break;
/*      */     case 59:
/* 7739 */       nFieldType = 4;
/* 7740 */       break;
/*      */     case 60:
/* 7742 */       nFieldType = 4;
/* 7743 */       break;
/*      */     case 61:
/* 7745 */       nFieldType = 4;
/* 7746 */       break;
/*      */     case 62:
/* 7748 */       nFieldType = 4;
/* 7749 */       break;
/*      */     case 63:
/* 7751 */       nFieldType = 4;
/* 7752 */       break;
/*      */     case 64:
/* 7754 */       nFieldType = 4;
/* 7755 */       break;
/*      */     case 65:
/* 7757 */       nFieldType = 4;
/* 7758 */       break;
/*      */     case 66:
/* 7760 */       nFieldType = 4;
/* 7761 */       break;
/*      */     case 67:
/* 7763 */       nFieldType = 4;
/* 7764 */       break;
/*      */     case 68:
/* 7766 */       nFieldType = 4;
/* 7767 */       break;
/*      */     case 69:
/* 7769 */       nFieldType = 4;
/* 7770 */       break;
/*      */     case 70:
/* 7772 */       nFieldType = 4;
/* 7773 */       break;
/*      */     case 71:
/* 7775 */       nFieldType = 4;
/* 7776 */       break;
/*      */     case 72:
/* 7778 */       nFieldType = 4;
/* 7779 */       break;
/*      */     case 73:
/* 7781 */       nFieldType = 4;
/* 7782 */       break;
/*      */     case 74:
/* 7784 */       nFieldType = 4;
/* 7785 */       break;
/*      */     case 75:
/* 7787 */       nFieldType = 4;
/* 7788 */       break;
/*      */     case 76:
/* 7790 */       nFieldType = 4;
/* 7791 */       break;
/*      */     case 77:
/* 7793 */       nFieldType = 4;
/* 7794 */       break;
/*      */     case 78:
/* 7796 */       nFieldType = 4;
/* 7797 */       break;
/*      */     case 79:
/* 7799 */       nFieldType = 4;
/* 7800 */       break;
/*      */     case 80:
/* 7802 */       nFieldType = 4;
/* 7803 */       break;
/*      */     case 81:
/* 7805 */       nFieldType = 4;
/* 7806 */       break;
/*      */     case 82:
/* 7808 */       nFieldType = 4;
/* 7809 */       break;
/*      */     case 83:
/* 7811 */       nFieldType = 4;
/* 7812 */       break;
/*      */     case 84:
/* 7814 */       nFieldType = 4;
/* 7815 */       break;
/*      */     case 85:
/* 7817 */       nFieldType = 4;
/* 7818 */       break;
/*      */     case 86:
/* 7820 */       nFieldType = 4;
/* 7821 */       break;
/*      */     case 87:
/* 7823 */       nFieldType = 4;
/* 7824 */       break;
/*      */     case 88:
/* 7826 */       nFieldType = 4;
/* 7827 */       break;
/*      */     case 89:
/* 7829 */       nFieldType = 4;
/* 7830 */       break;
/*      */     case 90:
/* 7832 */       nFieldType = 4;
/* 7833 */       break;
/*      */     case 91:
/* 7835 */       nFieldType = 4;
/* 7836 */       break;
/*      */     case 92:
/* 7838 */       nFieldType = 4;
/* 7839 */       break;
/*      */     case 93:
/* 7841 */       nFieldType = 4;
/* 7842 */       break;
/*      */     case 94:
/* 7844 */       nFieldType = 4;
/* 7845 */       break;
/*      */     case 95:
/* 7847 */       nFieldType = 4;
/* 7848 */       break;
/*      */     case 96:
/* 7850 */       nFieldType = 4;
/* 7851 */       break;
/*      */     case 97:
/* 7853 */       nFieldType = 4;
/* 7854 */       break;
/*      */     case 98:
/* 7856 */       nFieldType = 4;
/* 7857 */       break;
/*      */     case 99:
/* 7859 */       nFieldType = 4;
/* 7860 */       break;
/*      */     case 100:
/* 7862 */       nFieldType = 4;
/* 7863 */       break;
/*      */     case 101:
/* 7865 */       nFieldType = 4;
/* 7866 */       break;
/*      */     case 102:
/* 7868 */       nFieldType = 4;
/* 7869 */       break;
/*      */     case 103:
/* 7871 */       nFieldType = 4;
/* 7872 */       break;
/*      */     case 104:
/* 7874 */       nFieldType = 4;
/* 7875 */       break;
/*      */     case 105:
/* 7877 */       nFieldType = 4;
/* 7878 */       break;
/*      */     case 106:
/* 7880 */       nFieldType = 4;
/* 7881 */       break;
/*      */     case 107:
/* 7883 */       nFieldType = 4;
/* 7884 */       break;
/*      */     case 108:
/* 7886 */       nFieldType = 4;
/* 7887 */       break;
/*      */     case 109:
/* 7889 */       nFieldType = 4;
/* 7890 */       break;
/*      */     case 110:
/* 7892 */       nFieldType = 4;
/* 7893 */       break;
/*      */     case 111:
/* 7895 */       nFieldType = 4;
/* 7896 */       break;
/*      */     case 112:
/* 7898 */       nFieldType = 4;
/* 7899 */       break;
/*      */     case 113:
/* 7901 */       nFieldType = 4;
/* 7902 */       break;
/*      */     case 114:
/* 7904 */       nFieldType = 4;
/* 7905 */       break;
/*      */     case 115:
/* 7907 */       nFieldType = 4;
/* 7908 */       break;
/*      */     case 116:
/* 7910 */       nFieldType = 4;
/* 7911 */       break;
/*      */     case 117:
/* 7913 */       nFieldType = 4;
/* 7914 */       break;
/*      */     case 118:
/* 7916 */       nFieldType = 4;
/* 7917 */       break;
/*      */     case 119:
/* 7919 */       nFieldType = 0;
/* 7920 */       break;
/*      */     case 120:
/* 7922 */       nFieldType = 0;
/* 7923 */       break;
/*      */     case 121:
/* 7925 */       nFieldType = 1;
/* 7926 */       break;
/*      */     case 122:
/* 7928 */       nFieldType = 0;
/* 7929 */       break;
/*      */     case 123:
/* 7931 */       nFieldType = 1;
/* 7932 */       break;
/*      */     case 124:
/* 7934 */       nFieldType = 0;
/* 7935 */       break;
/*      */     case 125:
/* 7937 */       nFieldType = 0;
/* 7938 */       break;
/*      */     case 126:
/* 7940 */       nFieldType = 0;
/* 7941 */       break;
/*      */     case 127:
/* 7943 */       nFieldType = 0;
/* 7944 */       break;
/*      */     case 128:
/* 7946 */       nFieldType = 4;
/* 7947 */       break;
/*      */     case 129:
/* 7949 */       nFieldType = 4;
/* 7950 */       break;
/*      */     case 130:
/* 7952 */       nFieldType = 4;
/* 7953 */       break;
/*      */     case 131:
/* 7955 */       nFieldType = 4;
/* 7956 */       break;
/*      */     case 132:
/* 7958 */       nFieldType = 4;
/* 7959 */       break;
/*      */     case 133:
/* 7961 */       nFieldType = 4;
/* 7962 */       break;
/*      */     case 134:
/* 7964 */       nFieldType = 4;
/* 7965 */       break;
/*      */     case 135:
/* 7967 */       nFieldType = 4;
/* 7968 */       break;
/*      */     case 136:
/* 7970 */       nFieldType = 4;
/* 7971 */       break;
/*      */     case 137:
/* 7973 */       nFieldType = 4;
/* 7974 */       break;
/*      */     case 138:
/* 7976 */       nFieldType = 4;
/* 7977 */       break;
/*      */     case 139:
/* 7979 */       nFieldType = 4;
/* 7980 */       break;
/*      */     case 140:
/* 7982 */       nFieldType = 4;
/* 7983 */       break;
/*      */     case 141:
/* 7985 */       nFieldType = 4;
/* 7986 */       break;
/*      */     case 142:
/* 7988 */       nFieldType = 4;
/* 7989 */       break;
/*      */     case 143:
/* 7991 */       nFieldType = 4;
/* 7992 */       break;
/*      */     case 144:
/* 7994 */       nFieldType = 4;
/* 7995 */       break;
/*      */     case 145:
/* 7997 */       nFieldType = 4;
/* 7998 */       break;
/*      */     case 146:
/* 8000 */       nFieldType = 4;
/* 8001 */       break;
/*      */     case 147:
/* 8003 */       nFieldType = 4;
/* 8004 */       break;
/*      */     default:
/* 8006 */       nFieldType = -1;
/*      */     }
/* 8008 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.LAIndexInfoSchema
 * JD-Core Version:    0.6.0
 */