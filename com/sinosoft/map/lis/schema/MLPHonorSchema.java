/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MLPHonorDB;
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
/*      */ public class MLPHonorSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String statYear;
/*      */   private String statBatch;
/*      */   private String agentCode;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private Date startDate;
/*      */   private Date endDate;
/*      */   private String name;
/*      */   private Date employDate;
/*      */   private String branchAttr;
/*      */   private String agentGrade;
/*      */   private String sMManagerName;
/*      */   private String aMManagerName;
/*      */   private String rMManagerName;
/*      */   private double t1;
/*      */   private double t2;
/*      */   private double t3;
/*      */   private double t4;
/*      */   private double t5;
/*      */   private double t6;
/*      */   private String t7;
/*      */   private String t8;
/*      */   private String t9;
/*      */   private double t10;
/*      */   private double t11;
/*      */   private double t12;
/*      */   private String aMManager;
/*      */   private String rMManager;
/*      */   private String sMManager;
/*      */   private String t13;
/*      */   private String t14;
/*      */   private double t15;
/*      */   private Date outWorkDate;
/*      */   private double t16;
/*      */   private double t17;
/*      */   private double t18;
/*      */   private String t19;
/*      */   private double t20;
/*      */   private double t21;
/*      */   private String t22;
/*      */   private String sMManager2;
/*      */   private String rMManager2;
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
/*      */   private double c1;
/*      */   private double c2;
/*      */   private double c3;
/*      */   private double c4;
/*      */   private double c5;
/*      */   private double c6;
/*      */   private double c7;
/*      */   private double c8;
/*      */   private double c9;
/*      */   private double c10;
/*      */   public static final int FIELDNUM = 63;
/*      */   private static String[] PK;
/*  150 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MLPHonorSchema()
/*      */   {
/*  157 */     this.mErrors = new CErrors();
/*      */ 
/*  159 */     String[] pk = new String[3];
/*  160 */     pk[0] = "StatYear";
/*  161 */     pk[1] = "StatBatch";
/*  162 */     pk[2] = "AgentCode";
/*      */ 
/*  164 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  171 */     MLPHonorSchema cloned = (MLPHonorSchema)super.clone();
/*  172 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  173 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  174 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  180 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getStatYear()
/*      */   {
/*  185 */     return this.statYear;
/*      */   }
/*      */ 
/*      */   public void setStatYear(String aStatYear) {
/*  189 */     this.statYear = aStatYear;
/*      */   }
/*      */ 
/*      */   public String getStatBatch() {
/*  193 */     return this.statBatch;
/*      */   }
/*      */ 
/*      */   public void setStatBatch(String aStatBatch) {
/*  197 */     this.statBatch = aStatBatch;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  201 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  205 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  209 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  213 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  217 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  221 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  225 */     if (this.startDate != null) {
/*  226 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  228 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  232 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  236 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  238 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  241 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  246 */     if (this.endDate != null) {
/*  247 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  249 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  253 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  257 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  259 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  262 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getName()
/*      */   {
/*  267 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  271 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getEmployDate() {
/*  275 */     if (this.employDate != null) {
/*  276 */       return this.fDate.getString(this.employDate);
/*      */     }
/*  278 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEmployDate(Date aEmployDate) {
/*  282 */     this.employDate = aEmployDate;
/*      */   }
/*      */ 
/*      */   public void setEmployDate(String aEmployDate) {
/*  286 */     if ((aEmployDate != null) && (!aEmployDate.equals("")))
/*      */     {
/*  288 */       this.employDate = this.fDate.getDate(aEmployDate);
/*      */     }
/*      */     else
/*  291 */       this.employDate = null;
/*      */   }
/*      */ 
/*      */   public String getBranchAttr()
/*      */   {
/*  296 */     return this.branchAttr;
/*      */   }
/*      */ 
/*      */   public void setBranchAttr(String aBranchAttr) {
/*  300 */     this.branchAttr = aBranchAttr;
/*      */   }
/*      */ 
/*      */   public String getAgentGrade() {
/*  304 */     return this.agentGrade;
/*      */   }
/*      */ 
/*      */   public void setAgentGrade(String aAgentGrade) {
/*  308 */     this.agentGrade = aAgentGrade;
/*      */   }
/*      */ 
/*      */   public String getSMManagerName() {
/*  312 */     return this.sMManagerName;
/*      */   }
/*      */ 
/*      */   public void setSMManagerName(String aSMManagerName) {
/*  316 */     this.sMManagerName = aSMManagerName;
/*      */   }
/*      */ 
/*      */   public String getAMManagerName() {
/*  320 */     return this.aMManagerName;
/*      */   }
/*      */ 
/*      */   public void setAMManagerName(String aAMManagerName) {
/*  324 */     this.aMManagerName = aAMManagerName;
/*      */   }
/*      */ 
/*      */   public String getRMManagerName() {
/*  328 */     return this.rMManagerName;
/*      */   }
/*      */ 
/*      */   public void setRMManagerName(String aRMManagerName) {
/*  332 */     this.rMManagerName = aRMManagerName;
/*      */   }
/*      */ 
/*      */   public double getT1() {
/*  336 */     return this.t1;
/*      */   }
/*      */ 
/*      */   public void setT1(double aT1) {
/*  340 */     this.t1 = aT1;
/*      */   }
/*      */ 
/*      */   public void setT1(String aT1) {
/*  344 */     if ((aT1 != null) && (!aT1.equals("")))
/*      */     {
/*  346 */       Double tDouble = new Double(aT1);
/*  347 */       double d = tDouble.doubleValue();
/*  348 */       this.t1 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT2()
/*      */   {
/*  354 */     return this.t2;
/*      */   }
/*      */ 
/*      */   public void setT2(double aT2) {
/*  358 */     this.t2 = aT2;
/*      */   }
/*      */ 
/*      */   public void setT2(String aT2) {
/*  362 */     if ((aT2 != null) && (!aT2.equals("")))
/*      */     {
/*  364 */       Double tDouble = new Double(aT2);
/*  365 */       double d = tDouble.doubleValue();
/*  366 */       this.t2 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT3()
/*      */   {
/*  372 */     return this.t3;
/*      */   }
/*      */ 
/*      */   public void setT3(double aT3) {
/*  376 */     this.t3 = aT3;
/*      */   }
/*      */ 
/*      */   public void setT3(String aT3) {
/*  380 */     if ((aT3 != null) && (!aT3.equals("")))
/*      */     {
/*  382 */       Double tDouble = new Double(aT3);
/*  383 */       double d = tDouble.doubleValue();
/*  384 */       this.t3 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT4()
/*      */   {
/*  390 */     return this.t4;
/*      */   }
/*      */ 
/*      */   public void setT4(double aT4) {
/*  394 */     this.t4 = aT4;
/*      */   }
/*      */ 
/*      */   public void setT4(String aT4) {
/*  398 */     if ((aT4 != null) && (!aT4.equals("")))
/*      */     {
/*  400 */       Double tDouble = new Double(aT4);
/*  401 */       double d = tDouble.doubleValue();
/*  402 */       this.t4 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT5()
/*      */   {
/*  408 */     return this.t5;
/*      */   }
/*      */ 
/*      */   public void setT5(double aT5) {
/*  412 */     this.t5 = aT5;
/*      */   }
/*      */ 
/*      */   public void setT5(String aT5) {
/*  416 */     if ((aT5 != null) && (!aT5.equals("")))
/*      */     {
/*  418 */       Double tDouble = new Double(aT5);
/*  419 */       double d = tDouble.doubleValue();
/*  420 */       this.t5 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT6()
/*      */   {
/*  426 */     return this.t6;
/*      */   }
/*      */ 
/*      */   public void setT6(double aT6) {
/*  430 */     this.t6 = aT6;
/*      */   }
/*      */ 
/*      */   public void setT6(String aT6) {
/*  434 */     if ((aT6 != null) && (!aT6.equals("")))
/*      */     {
/*  436 */       Double tDouble = new Double(aT6);
/*  437 */       double d = tDouble.doubleValue();
/*  438 */       this.t6 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getT7()
/*      */   {
/*  444 */     return this.t7;
/*      */   }
/*      */ 
/*      */   public void setT7(String aT7) {
/*  448 */     this.t7 = aT7;
/*      */   }
/*      */ 
/*      */   public String getT8() {
/*  452 */     return this.t8;
/*      */   }
/*      */ 
/*      */   public void setT8(String aT8) {
/*  456 */     this.t8 = aT8;
/*      */   }
/*      */ 
/*      */   public String getT9() {
/*  460 */     return this.t9;
/*      */   }
/*      */ 
/*      */   public void setT9(String aT9) {
/*  464 */     this.t9 = aT9;
/*      */   }
/*      */ 
/*      */   public double getT10() {
/*  468 */     return this.t10;
/*      */   }
/*      */ 
/*      */   public void setT10(double aT10) {
/*  472 */     this.t10 = aT10;
/*      */   }
/*      */ 
/*      */   public void setT10(String aT10) {
/*  476 */     if ((aT10 != null) && (!aT10.equals("")))
/*      */     {
/*  478 */       Double tDouble = new Double(aT10);
/*  479 */       double d = tDouble.doubleValue();
/*  480 */       this.t10 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT11()
/*      */   {
/*  486 */     return this.t11;
/*      */   }
/*      */ 
/*      */   public void setT11(double aT11) {
/*  490 */     this.t11 = aT11;
/*      */   }
/*      */ 
/*      */   public void setT11(String aT11) {
/*  494 */     if ((aT11 != null) && (!aT11.equals("")))
/*      */     {
/*  496 */       Double tDouble = new Double(aT11);
/*  497 */       double d = tDouble.doubleValue();
/*  498 */       this.t11 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT12()
/*      */   {
/*  504 */     return this.t12;
/*      */   }
/*      */ 
/*      */   public void setT12(double aT12) {
/*  508 */     this.t12 = aT12;
/*      */   }
/*      */ 
/*      */   public void setT12(String aT12) {
/*  512 */     if ((aT12 != null) && (!aT12.equals("")))
/*      */     {
/*  514 */       Double tDouble = new Double(aT12);
/*  515 */       double d = tDouble.doubleValue();
/*  516 */       this.t12 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getAMManager()
/*      */   {
/*  522 */     return this.aMManager;
/*      */   }
/*      */ 
/*      */   public void setAMManager(String aAMManager) {
/*  526 */     this.aMManager = aAMManager;
/*      */   }
/*      */ 
/*      */   public String getRMManager() {
/*  530 */     return this.rMManager;
/*      */   }
/*      */ 
/*      */   public void setRMManager(String aRMManager) {
/*  534 */     this.rMManager = aRMManager;
/*      */   }
/*      */ 
/*      */   public String getSMManager() {
/*  538 */     return this.sMManager;
/*      */   }
/*      */ 
/*      */   public void setSMManager(String aSMManager) {
/*  542 */     this.sMManager = aSMManager;
/*      */   }
/*      */ 
/*      */   public String getT13() {
/*  546 */     return this.t13;
/*      */   }
/*      */ 
/*      */   public void setT13(String aT13) {
/*  550 */     this.t13 = aT13;
/*      */   }
/*      */ 
/*      */   public String getT14() {
/*  554 */     return this.t14;
/*      */   }
/*      */ 
/*      */   public void setT14(String aT14) {
/*  558 */     this.t14 = aT14;
/*      */   }
/*      */ 
/*      */   public double getT15() {
/*  562 */     return this.t15;
/*      */   }
/*      */ 
/*      */   public void setT15(double aT15) {
/*  566 */     this.t15 = aT15;
/*      */   }
/*      */ 
/*      */   public void setT15(String aT15) {
/*  570 */     if ((aT15 != null) && (!aT15.equals("")))
/*      */     {
/*  572 */       Double tDouble = new Double(aT15);
/*  573 */       double d = tDouble.doubleValue();
/*  574 */       this.t15 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOutWorkDate()
/*      */   {
/*  580 */     if (this.outWorkDate != null) {
/*  581 */       return this.fDate.getString(this.outWorkDate);
/*      */     }
/*  583 */     return null;
/*      */   }
/*      */ 
/*      */   public void setOutWorkDate(Date aOutWorkDate) {
/*  587 */     this.outWorkDate = aOutWorkDate;
/*      */   }
/*      */ 
/*      */   public void setOutWorkDate(String aOutWorkDate) {
/*  591 */     if ((aOutWorkDate != null) && (!aOutWorkDate.equals("")))
/*      */     {
/*  593 */       this.outWorkDate = this.fDate.getDate(aOutWorkDate);
/*      */     }
/*      */     else
/*  596 */       this.outWorkDate = null;
/*      */   }
/*      */ 
/*      */   public double getT16()
/*      */   {
/*  601 */     return this.t16;
/*      */   }
/*      */ 
/*      */   public void setT16(double aT16) {
/*  605 */     this.t16 = aT16;
/*      */   }
/*      */ 
/*      */   public void setT16(String aT16) {
/*  609 */     if ((aT16 != null) && (!aT16.equals("")))
/*      */     {
/*  611 */       Double tDouble = new Double(aT16);
/*  612 */       double d = tDouble.doubleValue();
/*  613 */       this.t16 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT17()
/*      */   {
/*  619 */     return this.t17;
/*      */   }
/*      */ 
/*      */   public void setT17(double aT17) {
/*  623 */     this.t17 = aT17;
/*      */   }
/*      */ 
/*      */   public void setT17(String aT17) {
/*  627 */     if ((aT17 != null) && (!aT17.equals("")))
/*      */     {
/*  629 */       Double tDouble = new Double(aT17);
/*  630 */       double d = tDouble.doubleValue();
/*  631 */       this.t17 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT18()
/*      */   {
/*  637 */     return this.t18;
/*      */   }
/*      */ 
/*      */   public void setT18(double aT18) {
/*  641 */     this.t18 = aT18;
/*      */   }
/*      */ 
/*      */   public void setT18(String aT18) {
/*  645 */     if ((aT18 != null) && (!aT18.equals("")))
/*      */     {
/*  647 */       Double tDouble = new Double(aT18);
/*  648 */       double d = tDouble.doubleValue();
/*  649 */       this.t18 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getT19()
/*      */   {
/*  655 */     return this.t19;
/*      */   }
/*      */ 
/*      */   public void setT19(String aT19) {
/*  659 */     this.t19 = aT19;
/*      */   }
/*      */ 
/*      */   public double getT20() {
/*  663 */     return this.t20;
/*      */   }
/*      */ 
/*      */   public void setT20(double aT20) {
/*  667 */     this.t20 = aT20;
/*      */   }
/*      */ 
/*      */   public void setT20(String aT20) {
/*  671 */     if ((aT20 != null) && (!aT20.equals("")))
/*      */     {
/*  673 */       Double tDouble = new Double(aT20);
/*  674 */       double d = tDouble.doubleValue();
/*  675 */       this.t20 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getT21()
/*      */   {
/*  681 */     return this.t21;
/*      */   }
/*      */ 
/*      */   public void setT21(double aT21) {
/*  685 */     this.t21 = aT21;
/*      */   }
/*      */ 
/*      */   public void setT21(String aT21) {
/*  689 */     if ((aT21 != null) && (!aT21.equals("")))
/*      */     {
/*  691 */       Double tDouble = new Double(aT21);
/*  692 */       double d = tDouble.doubleValue();
/*  693 */       this.t21 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getT22()
/*      */   {
/*  699 */     return this.t22;
/*      */   }
/*      */ 
/*      */   public void setT22(String aT22) {
/*  703 */     this.t22 = aT22;
/*      */   }
/*      */ 
/*      */   public String getSMManager2() {
/*  707 */     return this.sMManager2;
/*      */   }
/*      */ 
/*      */   public void setSMManager2(String aSMManager2) {
/*  711 */     this.sMManager2 = aSMManager2;
/*      */   }
/*      */ 
/*      */   public String getRMManager2() {
/*  715 */     return this.rMManager2;
/*      */   }
/*      */ 
/*      */   public void setRMManager2(String aRMManager2) {
/*  719 */     this.rMManager2 = aRMManager2;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  723 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  727 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  731 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  735 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  739 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  743 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  747 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  749 */       Integer tInteger = new Integer(aIF01);
/*  750 */       int i = tInteger.intValue();
/*  751 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  757 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  761 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  765 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  767 */       Double tDouble = new Double(aDF02);
/*  768 */       double d = tDouble.doubleValue();
/*  769 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  775 */     if (this.date01 != null) {
/*  776 */       return this.fDate.getString(this.date01);
/*      */     }
/*  778 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  782 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  786 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  788 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  791 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  796 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  800 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  804 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  808 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  812 */     if (this.makeDate != null) {
/*  813 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  815 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  819 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  823 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  825 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  828 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  833 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  837 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  841 */     if (this.modifyDate != null) {
/*  842 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  844 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  848 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  852 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  854 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  857 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  862 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  866 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public double getC1() {
/*  870 */     return this.c1;
/*      */   }
/*      */ 
/*      */   public void setC1(double aC1) {
/*  874 */     this.c1 = aC1;
/*      */   }
/*      */ 
/*      */   public void setC1(String aC1) {
/*  878 */     if ((aC1 != null) && (!aC1.equals("")))
/*      */     {
/*  880 */       Double tDouble = new Double(aC1);
/*  881 */       double d = tDouble.doubleValue();
/*  882 */       this.c1 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getC2()
/*      */   {
/*  888 */     return this.c2;
/*      */   }
/*      */ 
/*      */   public void setC2(double aC2) {
/*  892 */     this.c2 = aC2;
/*      */   }
/*      */ 
/*      */   public void setC2(String aC2) {
/*  896 */     if ((aC2 != null) && (!aC2.equals("")))
/*      */     {
/*  898 */       Double tDouble = new Double(aC2);
/*  899 */       double d = tDouble.doubleValue();
/*  900 */       this.c2 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getC3()
/*      */   {
/*  906 */     return this.c3;
/*      */   }
/*      */ 
/*      */   public void setC3(double aC3) {
/*  910 */     this.c3 = aC3;
/*      */   }
/*      */ 
/*      */   public void setC3(String aC3) {
/*  914 */     if ((aC3 != null) && (!aC3.equals("")))
/*      */     {
/*  916 */       Double tDouble = new Double(aC3);
/*  917 */       double d = tDouble.doubleValue();
/*  918 */       this.c3 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getC4()
/*      */   {
/*  924 */     return this.c4;
/*      */   }
/*      */ 
/*      */   public void setC4(double aC4) {
/*  928 */     this.c4 = aC4;
/*      */   }
/*      */ 
/*      */   public void setC4(String aC4) {
/*  932 */     if ((aC4 != null) && (!aC4.equals("")))
/*      */     {
/*  934 */       Double tDouble = new Double(aC4);
/*  935 */       double d = tDouble.doubleValue();
/*  936 */       this.c4 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getC5()
/*      */   {
/*  942 */     return this.c5;
/*      */   }
/*      */ 
/*      */   public void setC5(double aC5) {
/*  946 */     this.c5 = aC5;
/*      */   }
/*      */ 
/*      */   public void setC5(String aC5) {
/*  950 */     if ((aC5 != null) && (!aC5.equals("")))
/*      */     {
/*  952 */       Double tDouble = new Double(aC5);
/*  953 */       double d = tDouble.doubleValue();
/*  954 */       this.c5 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getC6()
/*      */   {
/*  960 */     return this.c6;
/*      */   }
/*      */ 
/*      */   public void setC6(double aC6) {
/*  964 */     this.c6 = aC6;
/*      */   }
/*      */ 
/*      */   public void setC6(String aC6) {
/*  968 */     if ((aC6 != null) && (!aC6.equals("")))
/*      */     {
/*  970 */       Double tDouble = new Double(aC6);
/*  971 */       double d = tDouble.doubleValue();
/*  972 */       this.c6 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getC7()
/*      */   {
/*  978 */     return this.c7;
/*      */   }
/*      */ 
/*      */   public void setC7(double aC7) {
/*  982 */     this.c7 = aC7;
/*      */   }
/*      */ 
/*      */   public void setC7(String aC7) {
/*  986 */     if ((aC7 != null) && (!aC7.equals("")))
/*      */     {
/*  988 */       Double tDouble = new Double(aC7);
/*  989 */       double d = tDouble.doubleValue();
/*  990 */       this.c7 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getC8()
/*      */   {
/*  996 */     return this.c8;
/*      */   }
/*      */ 
/*      */   public void setC8(double aC8) {
/* 1000 */     this.c8 = aC8;
/*      */   }
/*      */ 
/*      */   public void setC8(String aC8) {
/* 1004 */     if ((aC8 != null) && (!aC8.equals("")))
/*      */     {
/* 1006 */       Double tDouble = new Double(aC8);
/* 1007 */       double d = tDouble.doubleValue();
/* 1008 */       this.c8 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getC9()
/*      */   {
/* 1014 */     return this.c9;
/*      */   }
/*      */ 
/*      */   public void setC9(double aC9) {
/* 1018 */     this.c9 = aC9;
/*      */   }
/*      */ 
/*      */   public void setC9(String aC9) {
/* 1022 */     if ((aC9 != null) && (!aC9.equals("")))
/*      */     {
/* 1024 */       Double tDouble = new Double(aC9);
/* 1025 */       double d = tDouble.doubleValue();
/* 1026 */       this.c9 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getC10()
/*      */   {
/* 1032 */     return this.c10;
/*      */   }
/*      */ 
/*      */   public void setC10(double aC10) {
/* 1036 */     this.c10 = aC10;
/*      */   }
/*      */ 
/*      */   public void setC10(String aC10) {
/* 1040 */     if ((aC10 != null) && (!aC10.equals("")))
/*      */     {
/* 1042 */       Double tDouble = new Double(aC10);
/* 1043 */       double d = tDouble.doubleValue();
/* 1044 */       this.c10 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public void setSchema(MLPHonorSchema aMLPHonorSchema)
/*      */   {
/* 1052 */     this.statYear = aMLPHonorSchema.getStatYear();
/* 1053 */     this.statBatch = aMLPHonorSchema.getStatBatch();
/* 1054 */     this.agentCode = aMLPHonorSchema.getAgentCode();
/* 1055 */     this.manageCom = aMLPHonorSchema.getManageCom();
/* 1056 */     this.branchType = aMLPHonorSchema.getBranchType();
/* 1057 */     this.startDate = this.fDate.getDate(aMLPHonorSchema.getStartDate());
/* 1058 */     this.endDate = this.fDate.getDate(aMLPHonorSchema.getEndDate());
/* 1059 */     this.name = aMLPHonorSchema.getName();
/* 1060 */     this.employDate = this.fDate.getDate(aMLPHonorSchema.getEmployDate());
/* 1061 */     this.branchAttr = aMLPHonorSchema.getBranchAttr();
/* 1062 */     this.agentGrade = aMLPHonorSchema.getAgentGrade();
/* 1063 */     this.sMManagerName = aMLPHonorSchema.getSMManagerName();
/* 1064 */     this.aMManagerName = aMLPHonorSchema.getAMManagerName();
/* 1065 */     this.rMManagerName = aMLPHonorSchema.getRMManagerName();
/* 1066 */     this.t1 = aMLPHonorSchema.getT1();
/* 1067 */     this.t2 = aMLPHonorSchema.getT2();
/* 1068 */     this.t3 = aMLPHonorSchema.getT3();
/* 1069 */     this.t4 = aMLPHonorSchema.getT4();
/* 1070 */     this.t5 = aMLPHonorSchema.getT5();
/* 1071 */     this.t6 = aMLPHonorSchema.getT6();
/* 1072 */     this.t7 = aMLPHonorSchema.getT7();
/* 1073 */     this.t8 = aMLPHonorSchema.getT8();
/* 1074 */     this.t9 = aMLPHonorSchema.getT9();
/* 1075 */     this.t10 = aMLPHonorSchema.getT10();
/* 1076 */     this.t11 = aMLPHonorSchema.getT11();
/* 1077 */     this.t12 = aMLPHonorSchema.getT12();
/* 1078 */     this.aMManager = aMLPHonorSchema.getAMManager();
/* 1079 */     this.rMManager = aMLPHonorSchema.getRMManager();
/* 1080 */     this.sMManager = aMLPHonorSchema.getSMManager();
/* 1081 */     this.t13 = aMLPHonorSchema.getT13();
/* 1082 */     this.t14 = aMLPHonorSchema.getT14();
/* 1083 */     this.t15 = aMLPHonorSchema.getT15();
/* 1084 */     this.outWorkDate = this.fDate.getDate(aMLPHonorSchema.getOutWorkDate());
/* 1085 */     this.t16 = aMLPHonorSchema.getT16();
/* 1086 */     this.t17 = aMLPHonorSchema.getT17();
/* 1087 */     this.t18 = aMLPHonorSchema.getT18();
/* 1088 */     this.t19 = aMLPHonorSchema.getT19();
/* 1089 */     this.t20 = aMLPHonorSchema.getT20();
/* 1090 */     this.t21 = aMLPHonorSchema.getT21();
/* 1091 */     this.t22 = aMLPHonorSchema.getT22();
/* 1092 */     this.sMManager2 = aMLPHonorSchema.getSMManager2();
/* 1093 */     this.rMManager2 = aMLPHonorSchema.getRMManager2();
/* 1094 */     this.vF01 = aMLPHonorSchema.getVF01();
/* 1095 */     this.nF01 = aMLPHonorSchema.getNF01();
/* 1096 */     this.iF01 = aMLPHonorSchema.getIF01();
/* 1097 */     this.dF02 = aMLPHonorSchema.getDF02();
/* 1098 */     this.date01 = this.fDate.getDate(aMLPHonorSchema.getDate01());
/* 1099 */     this.modifyOperator = aMLPHonorSchema.getModifyOperator();
/* 1100 */     this.operator = aMLPHonorSchema.getOperator();
/* 1101 */     this.makeDate = this.fDate.getDate(aMLPHonorSchema.getMakeDate());
/* 1102 */     this.makeTime = aMLPHonorSchema.getMakeTime();
/* 1103 */     this.modifyDate = this.fDate.getDate(aMLPHonorSchema.getModifyDate());
/* 1104 */     this.modifyTime = aMLPHonorSchema.getModifyTime();
/* 1105 */     this.c1 = aMLPHonorSchema.getC1();
/* 1106 */     this.c2 = aMLPHonorSchema.getC2();
/* 1107 */     this.c3 = aMLPHonorSchema.getC3();
/* 1108 */     this.c4 = aMLPHonorSchema.getC4();
/* 1109 */     this.c5 = aMLPHonorSchema.getC5();
/* 1110 */     this.c6 = aMLPHonorSchema.getC6();
/* 1111 */     this.c7 = aMLPHonorSchema.getC7();
/* 1112 */     this.c8 = aMLPHonorSchema.getC8();
/* 1113 */     this.c9 = aMLPHonorSchema.getC9();
/* 1114 */     this.c10 = aMLPHonorSchema.getC10();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/* 1123 */       if (rs.getString("StatYear") == null)
/* 1124 */         this.statYear = null;
/*      */       else {
/* 1126 */         this.statYear = rs.getString("StatYear").trim();
/*      */       }
/* 1128 */       if (rs.getString("StatBatch") == null)
/* 1129 */         this.statBatch = null;
/*      */       else {
/* 1131 */         this.statBatch = rs.getString("StatBatch").trim();
/*      */       }
/* 1133 */       if (rs.getString("AgentCode") == null)
/* 1134 */         this.agentCode = null;
/*      */       else {
/* 1136 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/* 1138 */       if (rs.getString("ManageCom") == null)
/* 1139 */         this.manageCom = null;
/*      */       else {
/* 1141 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/* 1143 */       if (rs.getString("BranchType") == null)
/* 1144 */         this.branchType = null;
/*      */       else {
/* 1146 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/* 1148 */       this.startDate = rs.getDate("StartDate");
/* 1149 */       this.endDate = rs.getDate("EndDate");
/* 1150 */       if (rs.getString("Name") == null)
/* 1151 */         this.name = null;
/*      */       else {
/* 1153 */         this.name = rs.getString("Name").trim();
/*      */       }
/* 1155 */       this.employDate = rs.getDate("EmployDate");
/* 1156 */       if (rs.getString("BranchAttr") == null)
/* 1157 */         this.branchAttr = null;
/*      */       else {
/* 1159 */         this.branchAttr = rs.getString("BranchAttr").trim();
/*      */       }
/* 1161 */       if (rs.getString("AgentGrade") == null)
/* 1162 */         this.agentGrade = null;
/*      */       else {
/* 1164 */         this.agentGrade = rs.getString("AgentGrade").trim();
/*      */       }
/* 1166 */       if (rs.getString("SMManagerName") == null)
/* 1167 */         this.sMManagerName = null;
/*      */       else {
/* 1169 */         this.sMManagerName = rs.getString("SMManagerName").trim();
/*      */       }
/* 1171 */       if (rs.getString("AMManagerName") == null)
/* 1172 */         this.aMManagerName = null;
/*      */       else {
/* 1174 */         this.aMManagerName = rs.getString("AMManagerName").trim();
/*      */       }
/* 1176 */       if (rs.getString("RMManagerName") == null)
/* 1177 */         this.rMManagerName = null;
/*      */       else {
/* 1179 */         this.rMManagerName = rs.getString("RMManagerName").trim();
/*      */       }
/* 1181 */       this.t1 = rs.getDouble("T1");
/* 1182 */       this.t2 = rs.getDouble("T2");
/* 1183 */       this.t3 = rs.getDouble("T3");
/* 1184 */       this.t4 = rs.getDouble("T4");
/* 1185 */       this.t5 = rs.getDouble("T5");
/* 1186 */       this.t6 = rs.getDouble("T6");
/* 1187 */       if (rs.getString("T7") == null)
/* 1188 */         this.t7 = null;
/*      */       else {
/* 1190 */         this.t7 = rs.getString("T7").trim();
/*      */       }
/* 1192 */       if (rs.getString("T8") == null)
/* 1193 */         this.t8 = null;
/*      */       else {
/* 1195 */         this.t8 = rs.getString("T8").trim();
/*      */       }
/* 1197 */       if (rs.getString("T9") == null)
/* 1198 */         this.t9 = null;
/*      */       else {
/* 1200 */         this.t9 = rs.getString("T9").trim();
/*      */       }
/* 1202 */       this.t10 = rs.getDouble("T10");
/* 1203 */       this.t11 = rs.getDouble("T11");
/* 1204 */       this.t12 = rs.getDouble("T12");
/* 1205 */       if (rs.getString("AMManager") == null)
/* 1206 */         this.aMManager = null;
/*      */       else {
/* 1208 */         this.aMManager = rs.getString("AMManager").trim();
/*      */       }
/* 1210 */       if (rs.getString("RMManager") == null)
/* 1211 */         this.rMManager = null;
/*      */       else {
/* 1213 */         this.rMManager = rs.getString("RMManager").trim();
/*      */       }
/* 1215 */       if (rs.getString("SMManager") == null)
/* 1216 */         this.sMManager = null;
/*      */       else {
/* 1218 */         this.sMManager = rs.getString("SMManager").trim();
/*      */       }
/* 1220 */       if (rs.getString("T13") == null)
/* 1221 */         this.t13 = null;
/*      */       else {
/* 1223 */         this.t13 = rs.getString("T13").trim();
/*      */       }
/* 1225 */       if (rs.getString("T14") == null)
/* 1226 */         this.t14 = null;
/*      */       else {
/* 1228 */         this.t14 = rs.getString("T14").trim();
/*      */       }
/* 1230 */       this.t15 = rs.getDouble("T15");
/* 1231 */       this.outWorkDate = rs.getDate("OutWorkDate");
/* 1232 */       this.t16 = rs.getDouble("T16");
/* 1233 */       this.t17 = rs.getDouble("T17");
/* 1234 */       this.t18 = rs.getDouble("T18");
/* 1235 */       if (rs.getString("T19") == null)
/* 1236 */         this.t19 = null;
/*      */       else {
/* 1238 */         this.t19 = rs.getString("T19").trim();
/*      */       }
/* 1240 */       this.t20 = rs.getDouble("T20");
/* 1241 */       this.t21 = rs.getDouble("T21");
/* 1242 */       if (rs.getString("T22") == null)
/* 1243 */         this.t22 = null;
/*      */       else {
/* 1245 */         this.t22 = rs.getString("T22").trim();
/*      */       }
/* 1247 */       if (rs.getString("SMManager2") == null)
/* 1248 */         this.sMManager2 = null;
/*      */       else {
/* 1250 */         this.sMManager2 = rs.getString("SMManager2").trim();
/*      */       }
/* 1252 */       if (rs.getString("RMManager2") == null)
/* 1253 */         this.rMManager2 = null;
/*      */       else {
/* 1255 */         this.rMManager2 = rs.getString("RMManager2").trim();
/*      */       }
/* 1257 */       if (rs.getString("VF01") == null)
/* 1258 */         this.vF01 = null;
/*      */       else {
/* 1260 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/* 1262 */       if (rs.getString("NF01") == null)
/* 1263 */         this.nF01 = null;
/*      */       else {
/* 1265 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/* 1267 */       this.iF01 = rs.getInt("IF01");
/* 1268 */       this.dF02 = rs.getDouble("DF02");
/* 1269 */       this.date01 = rs.getDate("Date01");
/* 1270 */       if (rs.getString("ModifyOperator") == null)
/* 1271 */         this.modifyOperator = null;
/*      */       else {
/* 1273 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/* 1275 */       if (rs.getString("Operator") == null)
/* 1276 */         this.operator = null;
/*      */       else {
/* 1278 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/* 1280 */       this.makeDate = rs.getDate("MakeDate");
/* 1281 */       if (rs.getString("MakeTime") == null)
/* 1282 */         this.makeTime = null;
/*      */       else {
/* 1284 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/* 1286 */       this.modifyDate = rs.getDate("ModifyDate");
/* 1287 */       if (rs.getString("ModifyTime") == null)
/* 1288 */         this.modifyTime = null;
/*      */       else {
/* 1290 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/* 1292 */       this.c1 = rs.getDouble("C1");
/* 1293 */       this.c2 = rs.getDouble("C2");
/* 1294 */       this.c3 = rs.getDouble("C3");
/* 1295 */       this.c4 = rs.getDouble("C4");
/* 1296 */       this.c5 = rs.getDouble("C5");
/* 1297 */       this.c6 = rs.getDouble("C6");
/* 1298 */       this.c7 = rs.getDouble("C7");
/* 1299 */       this.c8 = rs.getDouble("C8");
/* 1300 */       this.c9 = rs.getDouble("C9");
/* 1301 */       this.c10 = rs.getDouble("C10");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1305 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MLPHonor\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/* 1307 */       CError tError = new CError();
/* 1308 */       tError.moduleName = "MLPHonorSchema";
/* 1309 */       tError.functionName = "setSchema";
/* 1310 */       tError.errorMessage = sqle.toString();
/* 1311 */       this.mErrors.addOneError(tError);
/* 1312 */       return false;
/*      */     }
/* 1314 */     return true;
/*      */   }
/*      */ 
/*      */   public MLPHonorSchema getSchema()
/*      */   {
/* 1319 */     MLPHonorSchema aMLPHonorSchema = new MLPHonorSchema();
/* 1320 */     aMLPHonorSchema.setSchema(this);
/* 1321 */     return aMLPHonorSchema;
/*      */   }
/*      */ 
/*      */   public MLPHonorDB getDB()
/*      */   {
/* 1326 */     MLPHonorDB aDBOper = new MLPHonorDB();
/* 1327 */     aDBOper.setSchema(this);
/* 1328 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1335 */     StringBuffer strReturn = new StringBuffer(256);
/* 1336 */     strReturn.append(StrTool.cTrim(this.statYear)); strReturn.append("|");
/* 1337 */     strReturn.append(StrTool.cTrim(this.statBatch)); strReturn.append("|");
/* 1338 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/* 1339 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/* 1340 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/* 1341 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/* 1342 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/* 1343 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/* 1344 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.employDate))); strReturn.append("|");
/* 1345 */     strReturn.append(StrTool.cTrim(this.branchAttr)); strReturn.append("|");
/* 1346 */     strReturn.append(StrTool.cTrim(this.agentGrade)); strReturn.append("|");
/* 1347 */     strReturn.append(StrTool.cTrim(this.sMManagerName)); strReturn.append("|");
/* 1348 */     strReturn.append(StrTool.cTrim(this.aMManagerName)); strReturn.append("|");
/* 1349 */     strReturn.append(StrTool.cTrim(this.rMManagerName)); strReturn.append("|");
/* 1350 */     strReturn.append(ChgData.chgData(this.t1)); strReturn.append("|");
/* 1351 */     strReturn.append(ChgData.chgData(this.t2)); strReturn.append("|");
/* 1352 */     strReturn.append(ChgData.chgData(this.t3)); strReturn.append("|");
/* 1353 */     strReturn.append(ChgData.chgData(this.t4)); strReturn.append("|");
/* 1354 */     strReturn.append(ChgData.chgData(this.t5)); strReturn.append("|");
/* 1355 */     strReturn.append(ChgData.chgData(this.t6)); strReturn.append("|");
/* 1356 */     strReturn.append(StrTool.cTrim(this.t7)); strReturn.append("|");
/* 1357 */     strReturn.append(StrTool.cTrim(this.t8)); strReturn.append("|");
/* 1358 */     strReturn.append(StrTool.cTrim(this.t9)); strReturn.append("|");
/* 1359 */     strReturn.append(ChgData.chgData(this.t10)); strReturn.append("|");
/* 1360 */     strReturn.append(ChgData.chgData(this.t11)); strReturn.append("|");
/* 1361 */     strReturn.append(ChgData.chgData(this.t12)); strReturn.append("|");
/* 1362 */     strReturn.append(StrTool.cTrim(this.aMManager)); strReturn.append("|");
/* 1363 */     strReturn.append(StrTool.cTrim(this.rMManager)); strReturn.append("|");
/* 1364 */     strReturn.append(StrTool.cTrim(this.sMManager)); strReturn.append("|");
/* 1365 */     strReturn.append(StrTool.cTrim(this.t13)); strReturn.append("|");
/* 1366 */     strReturn.append(StrTool.cTrim(this.t14)); strReturn.append("|");
/* 1367 */     strReturn.append(ChgData.chgData(this.t15)); strReturn.append("|");
/* 1368 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.outWorkDate))); strReturn.append("|");
/* 1369 */     strReturn.append(ChgData.chgData(this.t16)); strReturn.append("|");
/* 1370 */     strReturn.append(ChgData.chgData(this.t17)); strReturn.append("|");
/* 1371 */     strReturn.append(ChgData.chgData(this.t18)); strReturn.append("|");
/* 1372 */     strReturn.append(StrTool.cTrim(this.t19)); strReturn.append("|");
/* 1373 */     strReturn.append(ChgData.chgData(this.t20)); strReturn.append("|");
/* 1374 */     strReturn.append(ChgData.chgData(this.t21)); strReturn.append("|");
/* 1375 */     strReturn.append(StrTool.cTrim(this.t22)); strReturn.append("|");
/* 1376 */     strReturn.append(StrTool.cTrim(this.sMManager2)); strReturn.append("|");
/* 1377 */     strReturn.append(StrTool.cTrim(this.rMManager2)); strReturn.append("|");
/* 1378 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/* 1379 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/* 1380 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/* 1381 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/* 1382 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/* 1383 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/* 1384 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 1385 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 1386 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 1387 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 1388 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/* 1389 */     strReturn.append(ChgData.chgData(this.c1)); strReturn.append("|");
/* 1390 */     strReturn.append(ChgData.chgData(this.c2)); strReturn.append("|");
/* 1391 */     strReturn.append(ChgData.chgData(this.c3)); strReturn.append("|");
/* 1392 */     strReturn.append(ChgData.chgData(this.c4)); strReturn.append("|");
/* 1393 */     strReturn.append(ChgData.chgData(this.c5)); strReturn.append("|");
/* 1394 */     strReturn.append(ChgData.chgData(this.c6)); strReturn.append("|");
/* 1395 */     strReturn.append(ChgData.chgData(this.c7)); strReturn.append("|");
/* 1396 */     strReturn.append(ChgData.chgData(this.c8)); strReturn.append("|");
/* 1397 */     strReturn.append(ChgData.chgData(this.c9)); strReturn.append("|");
/* 1398 */     strReturn.append(ChgData.chgData(this.c10));
/* 1399 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1407 */       this.statYear = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1408 */       this.statBatch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1409 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1410 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1411 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1412 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/* 1413 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
/* 1414 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1415 */       this.employDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/* 1416 */       this.branchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1417 */       this.agentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1418 */       this.sMManagerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1419 */       this.aMManagerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1420 */       this.rMManagerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1421 */       this.t1 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).doubleValue();
/* 1422 */       this.t2 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|"))).doubleValue();
/* 1423 */       this.t3 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 17, "|"))).doubleValue();
/* 1424 */       this.t4 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|"))).doubleValue();
/* 1425 */       this.t5 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 19, "|"))).doubleValue();
/* 1426 */       this.t6 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).doubleValue();
/* 1427 */       this.t7 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1428 */       this.t8 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 1429 */       this.t9 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 1430 */       this.t10 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 24, "|"))).doubleValue();
/* 1431 */       this.t11 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 25, "|"))).doubleValue();
/* 1432 */       this.t12 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 26, "|"))).doubleValue();
/* 1433 */       this.aMManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1434 */       this.rMManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1435 */       this.sMManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 1436 */       this.t13 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1437 */       this.t14 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/* 1438 */       this.t15 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|"))).doubleValue();
/* 1439 */       this.outWorkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|"));
/* 1440 */       this.t16 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 34, "|"))).doubleValue();
/* 1441 */       this.t17 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 35, "|"))).doubleValue();
/* 1442 */       this.t18 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|"))).doubleValue();
/* 1443 */       this.t19 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 1444 */       this.t20 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|"))).doubleValue();
/* 1445 */       this.t21 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|"))).doubleValue();
/* 1446 */       this.t22 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1447 */       this.sMManager2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1448 */       this.rMManager2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1449 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 1450 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1451 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 45, "|"))).intValue();
/* 1452 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 46, "|"))).doubleValue();
/* 1453 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|"));
/* 1454 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
/* 1455 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
/* 1456 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|"));
/* 1457 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
/* 1458 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|"));
/* 1459 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
/* 1460 */       this.c1 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 54, "|"))).doubleValue();
/* 1461 */       this.c2 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 55, "|"))).doubleValue();
/* 1462 */       this.c3 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 56, "|"))).doubleValue();
/* 1463 */       this.c4 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|"))).doubleValue();
/* 1464 */       this.c5 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|"))).doubleValue();
/* 1465 */       this.c6 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|"))).doubleValue();
/* 1466 */       this.c7 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|"))).doubleValue();
/* 1467 */       this.c8 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|"))).doubleValue();
/* 1468 */       this.c9 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 62, "|"))).doubleValue();
/* 1469 */       this.c10 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 63, "|"))).doubleValue();
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1474 */       CError tError = new CError();
/* 1475 */       tError.moduleName = "MLPHonorSchema";
/* 1476 */       tError.functionName = "decode";
/* 1477 */       tError.errorMessage = ex.toString();
/* 1478 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1480 */       return false;
/*      */     }
/* 1482 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1488 */     String strReturn = "";
/* 1489 */     if (FCode.equalsIgnoreCase("statYear"))
/*      */     {
/* 1491 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.statYear));
/*      */     }
/* 1493 */     if (FCode.equalsIgnoreCase("statBatch"))
/*      */     {
/* 1495 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.statBatch));
/*      */     }
/* 1497 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 1499 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/* 1501 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1503 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 1505 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/* 1507 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/* 1509 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/* 1511 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/* 1513 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 1515 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/* 1517 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/* 1519 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/* 1521 */     if (FCode.equalsIgnoreCase("employDate"))
/*      */     {
/* 1523 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEmployDate()));
/*      */     }
/* 1525 */     if (FCode.equalsIgnoreCase("branchAttr"))
/*      */     {
/* 1527 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchAttr));
/*      */     }
/* 1529 */     if (FCode.equalsIgnoreCase("agentGrade"))
/*      */     {
/* 1531 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGrade));
/*      */     }
/* 1533 */     if (FCode.equalsIgnoreCase("sMManagerName"))
/*      */     {
/* 1535 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMManagerName));
/*      */     }
/* 1537 */     if (FCode.equalsIgnoreCase("aMManagerName"))
/*      */     {
/* 1539 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMManagerName));
/*      */     }
/* 1541 */     if (FCode.equalsIgnoreCase("rMManagerName"))
/*      */     {
/* 1543 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rMManagerName));
/*      */     }
/* 1545 */     if (FCode.equalsIgnoreCase("t1"))
/*      */     {
/* 1547 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t1));
/*      */     }
/* 1549 */     if (FCode.equalsIgnoreCase("t2"))
/*      */     {
/* 1551 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t2));
/*      */     }
/* 1553 */     if (FCode.equalsIgnoreCase("t3"))
/*      */     {
/* 1555 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t3));
/*      */     }
/* 1557 */     if (FCode.equalsIgnoreCase("t4"))
/*      */     {
/* 1559 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t4));
/*      */     }
/* 1561 */     if (FCode.equalsIgnoreCase("t5"))
/*      */     {
/* 1563 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t5));
/*      */     }
/* 1565 */     if (FCode.equalsIgnoreCase("t6"))
/*      */     {
/* 1567 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t6));
/*      */     }
/* 1569 */     if (FCode.equalsIgnoreCase("t7"))
/*      */     {
/* 1571 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t7));
/*      */     }
/* 1573 */     if (FCode.equalsIgnoreCase("t8"))
/*      */     {
/* 1575 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t8));
/*      */     }
/* 1577 */     if (FCode.equalsIgnoreCase("t9"))
/*      */     {
/* 1579 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t9));
/*      */     }
/* 1581 */     if (FCode.equalsIgnoreCase("t10"))
/*      */     {
/* 1583 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t10));
/*      */     }
/* 1585 */     if (FCode.equalsIgnoreCase("t11"))
/*      */     {
/* 1587 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t11));
/*      */     }
/* 1589 */     if (FCode.equalsIgnoreCase("t12"))
/*      */     {
/* 1591 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t12));
/*      */     }
/* 1593 */     if (FCode.equalsIgnoreCase("aMManager"))
/*      */     {
/* 1595 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.aMManager));
/*      */     }
/* 1597 */     if (FCode.equalsIgnoreCase("rMManager"))
/*      */     {
/* 1599 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rMManager));
/*      */     }
/* 1601 */     if (FCode.equalsIgnoreCase("sMManager"))
/*      */     {
/* 1603 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMManager));
/*      */     }
/* 1605 */     if (FCode.equalsIgnoreCase("t13"))
/*      */     {
/* 1607 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t13));
/*      */     }
/* 1609 */     if (FCode.equalsIgnoreCase("t14"))
/*      */     {
/* 1611 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t14));
/*      */     }
/* 1613 */     if (FCode.equalsIgnoreCase("t15"))
/*      */     {
/* 1615 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t15));
/*      */     }
/* 1617 */     if (FCode.equalsIgnoreCase("outWorkDate"))
/*      */     {
/* 1619 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getOutWorkDate()));
/*      */     }
/* 1621 */     if (FCode.equalsIgnoreCase("t16"))
/*      */     {
/* 1623 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t16));
/*      */     }
/* 1625 */     if (FCode.equalsIgnoreCase("t17"))
/*      */     {
/* 1627 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t17));
/*      */     }
/* 1629 */     if (FCode.equalsIgnoreCase("t18"))
/*      */     {
/* 1631 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t18));
/*      */     }
/* 1633 */     if (FCode.equalsIgnoreCase("t19"))
/*      */     {
/* 1635 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t19));
/*      */     }
/* 1637 */     if (FCode.equalsIgnoreCase("t20"))
/*      */     {
/* 1639 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t20));
/*      */     }
/* 1641 */     if (FCode.equalsIgnoreCase("t21"))
/*      */     {
/* 1643 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t21));
/*      */     }
/* 1645 */     if (FCode.equalsIgnoreCase("t22"))
/*      */     {
/* 1647 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.t22));
/*      */     }
/* 1649 */     if (FCode.equalsIgnoreCase("sMManager2"))
/*      */     {
/* 1651 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sMManager2));
/*      */     }
/* 1653 */     if (FCode.equalsIgnoreCase("rMManager2"))
/*      */     {
/* 1655 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rMManager2));
/*      */     }
/* 1657 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1659 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/* 1661 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1663 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/* 1665 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1667 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/* 1669 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1671 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/* 1673 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1675 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/* 1677 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1679 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/* 1681 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1683 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1685 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1687 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 1689 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1691 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1693 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1695 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 1697 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1699 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1701 */     if (FCode.equalsIgnoreCase("c1"))
/*      */     {
/* 1703 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.c1));
/*      */     }
/* 1705 */     if (FCode.equalsIgnoreCase("c2"))
/*      */     {
/* 1707 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.c2));
/*      */     }
/* 1709 */     if (FCode.equalsIgnoreCase("c3"))
/*      */     {
/* 1711 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.c3));
/*      */     }
/* 1713 */     if (FCode.equalsIgnoreCase("c4"))
/*      */     {
/* 1715 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.c4));
/*      */     }
/* 1717 */     if (FCode.equalsIgnoreCase("c5"))
/*      */     {
/* 1719 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.c5));
/*      */     }
/* 1721 */     if (FCode.equalsIgnoreCase("c6"))
/*      */     {
/* 1723 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.c6));
/*      */     }
/* 1725 */     if (FCode.equalsIgnoreCase("c7"))
/*      */     {
/* 1727 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.c7));
/*      */     }
/* 1729 */     if (FCode.equalsIgnoreCase("c8"))
/*      */     {
/* 1731 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.c8));
/*      */     }
/* 1733 */     if (FCode.equalsIgnoreCase("c9"))
/*      */     {
/* 1735 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.c9));
/*      */     }
/* 1737 */     if (FCode.equalsIgnoreCase("c10"))
/*      */     {
/* 1739 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.c10));
/*      */     }
/* 1741 */     if (strReturn.equals(""))
/*      */     {
/* 1743 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1746 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1753 */     String strFieldValue = "";
/* 1754 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1756 */       strFieldValue = StrTool.GBKToUnicode(this.statYear);
/* 1757 */       break;
/*      */     case 1:
/* 1759 */       strFieldValue = StrTool.GBKToUnicode(this.statBatch);
/* 1760 */       break;
/*      */     case 2:
/* 1762 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/* 1763 */       break;
/*      */     case 3:
/* 1765 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1766 */       break;
/*      */     case 4:
/* 1768 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/* 1769 */       break;
/*      */     case 5:
/* 1771 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/* 1772 */       break;
/*      */     case 6:
/* 1774 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/* 1775 */       break;
/*      */     case 7:
/* 1777 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/* 1778 */       break;
/*      */     case 8:
/* 1780 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEmployDate()));
/* 1781 */       break;
/*      */     case 9:
/* 1783 */       strFieldValue = StrTool.GBKToUnicode(this.branchAttr);
/* 1784 */       break;
/*      */     case 10:
/* 1786 */       strFieldValue = StrTool.GBKToUnicode(this.agentGrade);
/* 1787 */       break;
/*      */     case 11:
/* 1789 */       strFieldValue = StrTool.GBKToUnicode(this.sMManagerName);
/* 1790 */       break;
/*      */     case 12:
/* 1792 */       strFieldValue = StrTool.GBKToUnicode(this.aMManagerName);
/* 1793 */       break;
/*      */     case 13:
/* 1795 */       strFieldValue = StrTool.GBKToUnicode(this.rMManagerName);
/* 1796 */       break;
/*      */     case 14:
/* 1798 */       strFieldValue = String.valueOf(this.t1);
/* 1799 */       break;
/*      */     case 15:
/* 1801 */       strFieldValue = String.valueOf(this.t2);
/* 1802 */       break;
/*      */     case 16:
/* 1804 */       strFieldValue = String.valueOf(this.t3);
/* 1805 */       break;
/*      */     case 17:
/* 1807 */       strFieldValue = String.valueOf(this.t4);
/* 1808 */       break;
/*      */     case 18:
/* 1810 */       strFieldValue = String.valueOf(this.t5);
/* 1811 */       break;
/*      */     case 19:
/* 1813 */       strFieldValue = String.valueOf(this.t6);
/* 1814 */       break;
/*      */     case 20:
/* 1816 */       strFieldValue = StrTool.GBKToUnicode(this.t7);
/* 1817 */       break;
/*      */     case 21:
/* 1819 */       strFieldValue = StrTool.GBKToUnicode(this.t8);
/* 1820 */       break;
/*      */     case 22:
/* 1822 */       strFieldValue = StrTool.GBKToUnicode(this.t9);
/* 1823 */       break;
/*      */     case 23:
/* 1825 */       strFieldValue = String.valueOf(this.t10);
/* 1826 */       break;
/*      */     case 24:
/* 1828 */       strFieldValue = String.valueOf(this.t11);
/* 1829 */       break;
/*      */     case 25:
/* 1831 */       strFieldValue = String.valueOf(this.t12);
/* 1832 */       break;
/*      */     case 26:
/* 1834 */       strFieldValue = StrTool.GBKToUnicode(this.aMManager);
/* 1835 */       break;
/*      */     case 27:
/* 1837 */       strFieldValue = StrTool.GBKToUnicode(this.rMManager);
/* 1838 */       break;
/*      */     case 28:
/* 1840 */       strFieldValue = StrTool.GBKToUnicode(this.sMManager);
/* 1841 */       break;
/*      */     case 29:
/* 1843 */       strFieldValue = StrTool.GBKToUnicode(this.t13);
/* 1844 */       break;
/*      */     case 30:
/* 1846 */       strFieldValue = StrTool.GBKToUnicode(this.t14);
/* 1847 */       break;
/*      */     case 31:
/* 1849 */       strFieldValue = String.valueOf(this.t15);
/* 1850 */       break;
/*      */     case 32:
/* 1852 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getOutWorkDate()));
/* 1853 */       break;
/*      */     case 33:
/* 1855 */       strFieldValue = String.valueOf(this.t16);
/* 1856 */       break;
/*      */     case 34:
/* 1858 */       strFieldValue = String.valueOf(this.t17);
/* 1859 */       break;
/*      */     case 35:
/* 1861 */       strFieldValue = String.valueOf(this.t18);
/* 1862 */       break;
/*      */     case 36:
/* 1864 */       strFieldValue = StrTool.GBKToUnicode(this.t19);
/* 1865 */       break;
/*      */     case 37:
/* 1867 */       strFieldValue = String.valueOf(this.t20);
/* 1868 */       break;
/*      */     case 38:
/* 1870 */       strFieldValue = String.valueOf(this.t21);
/* 1871 */       break;
/*      */     case 39:
/* 1873 */       strFieldValue = StrTool.GBKToUnicode(this.t22);
/* 1874 */       break;
/*      */     case 40:
/* 1876 */       strFieldValue = StrTool.GBKToUnicode(this.sMManager2);
/* 1877 */       break;
/*      */     case 41:
/* 1879 */       strFieldValue = StrTool.GBKToUnicode(this.rMManager2);
/* 1880 */       break;
/*      */     case 42:
/* 1882 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/* 1883 */       break;
/*      */     case 43:
/* 1885 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/* 1886 */       break;
/*      */     case 44:
/* 1888 */       strFieldValue = String.valueOf(this.iF01);
/* 1889 */       break;
/*      */     case 45:
/* 1891 */       strFieldValue = String.valueOf(this.dF02);
/* 1892 */       break;
/*      */     case 46:
/* 1894 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/* 1895 */       break;
/*      */     case 47:
/* 1897 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/* 1898 */       break;
/*      */     case 48:
/* 1900 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1901 */       break;
/*      */     case 49:
/* 1903 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1904 */       break;
/*      */     case 50:
/* 1906 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1907 */       break;
/*      */     case 51:
/* 1909 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1910 */       break;
/*      */     case 52:
/* 1912 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1913 */       break;
/*      */     case 53:
/* 1915 */       strFieldValue = String.valueOf(this.c1);
/* 1916 */       break;
/*      */     case 54:
/* 1918 */       strFieldValue = String.valueOf(this.c2);
/* 1919 */       break;
/*      */     case 55:
/* 1921 */       strFieldValue = String.valueOf(this.c3);
/* 1922 */       break;
/*      */     case 56:
/* 1924 */       strFieldValue = String.valueOf(this.c4);
/* 1925 */       break;
/*      */     case 57:
/* 1927 */       strFieldValue = String.valueOf(this.c5);
/* 1928 */       break;
/*      */     case 58:
/* 1930 */       strFieldValue = String.valueOf(this.c6);
/* 1931 */       break;
/*      */     case 59:
/* 1933 */       strFieldValue = String.valueOf(this.c7);
/* 1934 */       break;
/*      */     case 60:
/* 1936 */       strFieldValue = String.valueOf(this.c8);
/* 1937 */       break;
/*      */     case 61:
/* 1939 */       strFieldValue = String.valueOf(this.c9);
/* 1940 */       break;
/*      */     case 62:
/* 1942 */       strFieldValue = String.valueOf(this.c10);
/* 1943 */       break;
/*      */     default:
/* 1945 */       strFieldValue = "";
/*      */     }
/* 1947 */     if (strFieldValue.equals("")) {
/* 1948 */       strFieldValue = "null";
/*      */     }
/* 1950 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1956 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1957 */       return false;
/*      */     }
/* 1959 */     if (FCode.equalsIgnoreCase("statYear"))
/*      */     {
/* 1961 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1963 */         this.statYear = FValue.trim();
/*      */       }
/*      */       else
/* 1966 */         this.statYear = null;
/*      */     }
/* 1968 */     if (FCode.equalsIgnoreCase("statBatch"))
/*      */     {
/* 1970 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1972 */         this.statBatch = FValue.trim();
/*      */       }
/*      */       else
/* 1975 */         this.statBatch = null;
/*      */     }
/* 1977 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 1979 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1981 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/* 1984 */         this.agentCode = null;
/*      */     }
/* 1986 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1988 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1990 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1993 */         this.manageCom = null;
/*      */     }
/* 1995 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/* 1997 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1999 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/* 2002 */         this.branchType = null;
/*      */     }
/* 2004 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/* 2006 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2008 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2011 */         this.startDate = null;
/*      */     }
/* 2013 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 2015 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2017 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2020 */         this.endDate = null;
/*      */     }
/* 2022 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/* 2024 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2026 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/* 2029 */         this.name = null;
/*      */     }
/* 2031 */     if (FCode.equalsIgnoreCase("employDate"))
/*      */     {
/* 2033 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2035 */         this.employDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2038 */         this.employDate = null;
/*      */     }
/* 2040 */     if (FCode.equalsIgnoreCase("branchAttr"))
/*      */     {
/* 2042 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2044 */         this.branchAttr = FValue.trim();
/*      */       }
/*      */       else
/* 2047 */         this.branchAttr = null;
/*      */     }
/* 2049 */     if (FCode.equalsIgnoreCase("agentGrade"))
/*      */     {
/* 2051 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2053 */         this.agentGrade = FValue.trim();
/*      */       }
/*      */       else
/* 2056 */         this.agentGrade = null;
/*      */     }
/* 2058 */     if (FCode.equalsIgnoreCase("sMManagerName"))
/*      */     {
/* 2060 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2062 */         this.sMManagerName = FValue.trim();
/*      */       }
/*      */       else
/* 2065 */         this.sMManagerName = null;
/*      */     }
/* 2067 */     if (FCode.equalsIgnoreCase("aMManagerName"))
/*      */     {
/* 2069 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2071 */         this.aMManagerName = FValue.trim();
/*      */       }
/*      */       else
/* 2074 */         this.aMManagerName = null;
/*      */     }
/* 2076 */     if (FCode.equalsIgnoreCase("rMManagerName"))
/*      */     {
/* 2078 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2080 */         this.rMManagerName = FValue.trim();
/*      */       }
/*      */       else
/* 2083 */         this.rMManagerName = null;
/*      */     }
/* 2085 */     if (FCode.equalsIgnoreCase("t1"))
/*      */     {
/* 2087 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2089 */         Double tDouble = new Double(FValue);
/* 2090 */         double d = tDouble.doubleValue();
/* 2091 */         this.t1 = d;
/*      */       }
/*      */     }
/* 2094 */     if (FCode.equalsIgnoreCase("t2"))
/*      */     {
/* 2096 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2098 */         Double tDouble = new Double(FValue);
/* 2099 */         double d = tDouble.doubleValue();
/* 2100 */         this.t2 = d;
/*      */       }
/*      */     }
/* 2103 */     if (FCode.equalsIgnoreCase("t3"))
/*      */     {
/* 2105 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2107 */         Double tDouble = new Double(FValue);
/* 2108 */         double d = tDouble.doubleValue();
/* 2109 */         this.t3 = d;
/*      */       }
/*      */     }
/* 2112 */     if (FCode.equalsIgnoreCase("t4"))
/*      */     {
/* 2114 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2116 */         Double tDouble = new Double(FValue);
/* 2117 */         double d = tDouble.doubleValue();
/* 2118 */         this.t4 = d;
/*      */       }
/*      */     }
/* 2121 */     if (FCode.equalsIgnoreCase("t5"))
/*      */     {
/* 2123 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2125 */         Double tDouble = new Double(FValue);
/* 2126 */         double d = tDouble.doubleValue();
/* 2127 */         this.t5 = d;
/*      */       }
/*      */     }
/* 2130 */     if (FCode.equalsIgnoreCase("t6"))
/*      */     {
/* 2132 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2134 */         Double tDouble = new Double(FValue);
/* 2135 */         double d = tDouble.doubleValue();
/* 2136 */         this.t6 = d;
/*      */       }
/*      */     }
/* 2139 */     if (FCode.equalsIgnoreCase("t7"))
/*      */     {
/* 2141 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2143 */         this.t7 = FValue.trim();
/*      */       }
/*      */       else
/* 2146 */         this.t7 = null;
/*      */     }
/* 2148 */     if (FCode.equalsIgnoreCase("t8"))
/*      */     {
/* 2150 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2152 */         this.t8 = FValue.trim();
/*      */       }
/*      */       else
/* 2155 */         this.t8 = null;
/*      */     }
/* 2157 */     if (FCode.equalsIgnoreCase("t9"))
/*      */     {
/* 2159 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2161 */         this.t9 = FValue.trim();
/*      */       }
/*      */       else
/* 2164 */         this.t9 = null;
/*      */     }
/* 2166 */     if (FCode.equalsIgnoreCase("t10"))
/*      */     {
/* 2168 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2170 */         Double tDouble = new Double(FValue);
/* 2171 */         double d = tDouble.doubleValue();
/* 2172 */         this.t10 = d;
/*      */       }
/*      */     }
/* 2175 */     if (FCode.equalsIgnoreCase("t11"))
/*      */     {
/* 2177 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2179 */         Double tDouble = new Double(FValue);
/* 2180 */         double d = tDouble.doubleValue();
/* 2181 */         this.t11 = d;
/*      */       }
/*      */     }
/* 2184 */     if (FCode.equalsIgnoreCase("t12"))
/*      */     {
/* 2186 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2188 */         Double tDouble = new Double(FValue);
/* 2189 */         double d = tDouble.doubleValue();
/* 2190 */         this.t12 = d;
/*      */       }
/*      */     }
/* 2193 */     if (FCode.equalsIgnoreCase("aMManager"))
/*      */     {
/* 2195 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2197 */         this.aMManager = FValue.trim();
/*      */       }
/*      */       else
/* 2200 */         this.aMManager = null;
/*      */     }
/* 2202 */     if (FCode.equalsIgnoreCase("rMManager"))
/*      */     {
/* 2204 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2206 */         this.rMManager = FValue.trim();
/*      */       }
/*      */       else
/* 2209 */         this.rMManager = null;
/*      */     }
/* 2211 */     if (FCode.equalsIgnoreCase("sMManager"))
/*      */     {
/* 2213 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2215 */         this.sMManager = FValue.trim();
/*      */       }
/*      */       else
/* 2218 */         this.sMManager = null;
/*      */     }
/* 2220 */     if (FCode.equalsIgnoreCase("t13"))
/*      */     {
/* 2222 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2224 */         this.t13 = FValue.trim();
/*      */       }
/*      */       else
/* 2227 */         this.t13 = null;
/*      */     }
/* 2229 */     if (FCode.equalsIgnoreCase("t14"))
/*      */     {
/* 2231 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2233 */         this.t14 = FValue.trim();
/*      */       }
/*      */       else
/* 2236 */         this.t14 = null;
/*      */     }
/* 2238 */     if (FCode.equalsIgnoreCase("t15"))
/*      */     {
/* 2240 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2242 */         Double tDouble = new Double(FValue);
/* 2243 */         double d = tDouble.doubleValue();
/* 2244 */         this.t15 = d;
/*      */       }
/*      */     }
/* 2247 */     if (FCode.equalsIgnoreCase("outWorkDate"))
/*      */     {
/* 2249 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2251 */         this.outWorkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2254 */         this.outWorkDate = null;
/*      */     }
/* 2256 */     if (FCode.equalsIgnoreCase("t16"))
/*      */     {
/* 2258 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2260 */         Double tDouble = new Double(FValue);
/* 2261 */         double d = tDouble.doubleValue();
/* 2262 */         this.t16 = d;
/*      */       }
/*      */     }
/* 2265 */     if (FCode.equalsIgnoreCase("t17"))
/*      */     {
/* 2267 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2269 */         Double tDouble = new Double(FValue);
/* 2270 */         double d = tDouble.doubleValue();
/* 2271 */         this.t17 = d;
/*      */       }
/*      */     }
/* 2274 */     if (FCode.equalsIgnoreCase("t18"))
/*      */     {
/* 2276 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2278 */         Double tDouble = new Double(FValue);
/* 2279 */         double d = tDouble.doubleValue();
/* 2280 */         this.t18 = d;
/*      */       }
/*      */     }
/* 2283 */     if (FCode.equalsIgnoreCase("t19"))
/*      */     {
/* 2285 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2287 */         this.t19 = FValue.trim();
/*      */       }
/*      */       else
/* 2290 */         this.t19 = null;
/*      */     }
/* 2292 */     if (FCode.equalsIgnoreCase("t20"))
/*      */     {
/* 2294 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2296 */         Double tDouble = new Double(FValue);
/* 2297 */         double d = tDouble.doubleValue();
/* 2298 */         this.t20 = d;
/*      */       }
/*      */     }
/* 2301 */     if (FCode.equalsIgnoreCase("t21"))
/*      */     {
/* 2303 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2305 */         Double tDouble = new Double(FValue);
/* 2306 */         double d = tDouble.doubleValue();
/* 2307 */         this.t21 = d;
/*      */       }
/*      */     }
/* 2310 */     if (FCode.equalsIgnoreCase("t22"))
/*      */     {
/* 2312 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2314 */         this.t22 = FValue.trim();
/*      */       }
/*      */       else
/* 2317 */         this.t22 = null;
/*      */     }
/* 2319 */     if (FCode.equalsIgnoreCase("sMManager2"))
/*      */     {
/* 2321 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2323 */         this.sMManager2 = FValue.trim();
/*      */       }
/*      */       else
/* 2326 */         this.sMManager2 = null;
/*      */     }
/* 2328 */     if (FCode.equalsIgnoreCase("rMManager2"))
/*      */     {
/* 2330 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2332 */         this.rMManager2 = FValue.trim();
/*      */       }
/*      */       else
/* 2335 */         this.rMManager2 = null;
/*      */     }
/* 2337 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 2339 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2341 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 2344 */         this.vF01 = null;
/*      */     }
/* 2346 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 2348 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2350 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 2353 */         this.nF01 = null;
/*      */     }
/* 2355 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 2357 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2359 */         Integer tInteger = new Integer(FValue);
/* 2360 */         int i = tInteger.intValue();
/* 2361 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 2364 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 2366 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2368 */         Double tDouble = new Double(FValue);
/* 2369 */         double d = tDouble.doubleValue();
/* 2370 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 2373 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 2375 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2377 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2380 */         this.date01 = null;
/*      */     }
/* 2382 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 2384 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2386 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 2389 */         this.modifyOperator = null;
/*      */     }
/* 2391 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 2393 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2395 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 2398 */         this.operator = null;
/*      */     }
/* 2400 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 2402 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2404 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2407 */         this.makeDate = null;
/*      */     }
/* 2409 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 2411 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2413 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 2416 */         this.makeTime = null;
/*      */     }
/* 2418 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 2420 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2422 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 2425 */         this.modifyDate = null;
/*      */     }
/* 2427 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 2429 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2431 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 2434 */         this.modifyTime = null;
/*      */     }
/* 2436 */     if (FCode.equalsIgnoreCase("c1"))
/*      */     {
/* 2438 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2440 */         Double tDouble = new Double(FValue);
/* 2441 */         double d = tDouble.doubleValue();
/* 2442 */         this.c1 = d;
/*      */       }
/*      */     }
/* 2445 */     if (FCode.equalsIgnoreCase("c2"))
/*      */     {
/* 2447 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2449 */         Double tDouble = new Double(FValue);
/* 2450 */         double d = tDouble.doubleValue();
/* 2451 */         this.c2 = d;
/*      */       }
/*      */     }
/* 2454 */     if (FCode.equalsIgnoreCase("c3"))
/*      */     {
/* 2456 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2458 */         Double tDouble = new Double(FValue);
/* 2459 */         double d = tDouble.doubleValue();
/* 2460 */         this.c3 = d;
/*      */       }
/*      */     }
/* 2463 */     if (FCode.equalsIgnoreCase("c4"))
/*      */     {
/* 2465 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2467 */         Double tDouble = new Double(FValue);
/* 2468 */         double d = tDouble.doubleValue();
/* 2469 */         this.c4 = d;
/*      */       }
/*      */     }
/* 2472 */     if (FCode.equalsIgnoreCase("c5"))
/*      */     {
/* 2474 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2476 */         Double tDouble = new Double(FValue);
/* 2477 */         double d = tDouble.doubleValue();
/* 2478 */         this.c5 = d;
/*      */       }
/*      */     }
/* 2481 */     if (FCode.equalsIgnoreCase("c6"))
/*      */     {
/* 2483 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2485 */         Double tDouble = new Double(FValue);
/* 2486 */         double d = tDouble.doubleValue();
/* 2487 */         this.c6 = d;
/*      */       }
/*      */     }
/* 2490 */     if (FCode.equalsIgnoreCase("c7"))
/*      */     {
/* 2492 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2494 */         Double tDouble = new Double(FValue);
/* 2495 */         double d = tDouble.doubleValue();
/* 2496 */         this.c7 = d;
/*      */       }
/*      */     }
/* 2499 */     if (FCode.equalsIgnoreCase("c8"))
/*      */     {
/* 2501 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2503 */         Double tDouble = new Double(FValue);
/* 2504 */         double d = tDouble.doubleValue();
/* 2505 */         this.c8 = d;
/*      */       }
/*      */     }
/* 2508 */     if (FCode.equalsIgnoreCase("c9"))
/*      */     {
/* 2510 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2512 */         Double tDouble = new Double(FValue);
/* 2513 */         double d = tDouble.doubleValue();
/* 2514 */         this.c9 = d;
/*      */       }
/*      */     }
/* 2517 */     if (FCode.equalsIgnoreCase("c10"))
/*      */     {
/* 2519 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 2521 */         Double tDouble = new Double(FValue);
/* 2522 */         double d = tDouble.doubleValue();
/* 2523 */         this.c10 = d;
/*      */       }
/*      */     }
/* 2526 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 2531 */     if (otherObject == null) return false;
/* 2532 */     if (this == otherObject) return true;
/* 2533 */     if (getClass() != otherObject.getClass()) return false;
/* 2534 */     MLPHonorSchema other = (MLPHonorSchema)otherObject;
/* 2535 */     if ((this.statYear == null) && (other.getStatYear() != null)) return false;
/* 2536 */     if ((this.statYear != null) && (!this.statYear.equals(other.getStatYear()))) return false;
/* 2537 */     if ((this.statBatch == null) && (other.getStatBatch() != null)) return false;
/* 2538 */     if ((this.statBatch != null) && (!this.statBatch.equals(other.getStatBatch()))) return false;
/* 2539 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/* 2540 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/* 2541 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 2542 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 2543 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 2544 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 2545 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 2546 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 2547 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 2548 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 2549 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 2550 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 2551 */     if ((this.employDate == null) && (other.getEmployDate() != null)) return false;
/* 2552 */     if ((this.employDate != null) && (!this.fDate.getString(this.employDate).equals(other.getEmployDate()))) return false;
/* 2553 */     if ((this.branchAttr == null) && (other.getBranchAttr() != null)) return false;
/* 2554 */     if ((this.branchAttr != null) && (!this.branchAttr.equals(other.getBranchAttr()))) return false;
/* 2555 */     if ((this.agentGrade == null) && (other.getAgentGrade() != null)) return false;
/* 2556 */     if ((this.agentGrade != null) && (!this.agentGrade.equals(other.getAgentGrade()))) return false;
/* 2557 */     if ((this.sMManagerName == null) && (other.getSMManagerName() != null)) return false;
/* 2558 */     if ((this.sMManagerName != null) && (!this.sMManagerName.equals(other.getSMManagerName()))) return false;
/* 2559 */     if ((this.aMManagerName == null) && (other.getAMManagerName() != null)) return false;
/* 2560 */     if ((this.aMManagerName != null) && (!this.aMManagerName.equals(other.getAMManagerName()))) return false;
/* 2561 */     if ((this.rMManagerName == null) && (other.getRMManagerName() != null)) return false;
/* 2562 */     if ((this.rMManagerName != null) && (!this.rMManagerName.equals(other.getRMManagerName()))) return false;
/* 2563 */     if (Double.doubleToLongBits(this.t1) != Double.doubleToLongBits(other.getT1())) return false;
/* 2564 */     if (Double.doubleToLongBits(this.t2) != Double.doubleToLongBits(other.getT2())) return false;
/* 2565 */     if (Double.doubleToLongBits(this.t3) != Double.doubleToLongBits(other.getT3())) return false;
/* 2566 */     if (Double.doubleToLongBits(this.t4) != Double.doubleToLongBits(other.getT4())) return false;
/* 2567 */     if (Double.doubleToLongBits(this.t5) != Double.doubleToLongBits(other.getT5())) return false;
/* 2568 */     if (Double.doubleToLongBits(this.t6) != Double.doubleToLongBits(other.getT6())) return false;
/* 2569 */     if ((this.t7 == null) && (other.getT7() != null)) return false;
/* 2570 */     if ((this.t7 != null) && (!this.t7.equals(other.getT7()))) return false;
/* 2571 */     if ((this.t8 == null) && (other.getT8() != null)) return false;
/* 2572 */     if ((this.t8 != null) && (!this.t8.equals(other.getT8()))) return false;
/* 2573 */     if ((this.t9 == null) && (other.getT9() != null)) return false;
/* 2574 */     if ((this.t9 != null) && (!this.t9.equals(other.getT9()))) return false;
/* 2575 */     if (Double.doubleToLongBits(this.t10) != Double.doubleToLongBits(other.getT10())) return false;
/* 2576 */     if (Double.doubleToLongBits(this.t11) != Double.doubleToLongBits(other.getT11())) return false;
/* 2577 */     if (Double.doubleToLongBits(this.t12) != Double.doubleToLongBits(other.getT12())) return false;
/* 2578 */     if ((this.aMManager == null) && (other.getAMManager() != null)) return false;
/* 2579 */     if ((this.aMManager != null) && (!this.aMManager.equals(other.getAMManager()))) return false;
/* 2580 */     if ((this.rMManager == null) && (other.getRMManager() != null)) return false;
/* 2581 */     if ((this.rMManager != null) && (!this.rMManager.equals(other.getRMManager()))) return false;
/* 2582 */     if ((this.sMManager == null) && (other.getSMManager() != null)) return false;
/* 2583 */     if ((this.sMManager != null) && (!this.sMManager.equals(other.getSMManager()))) return false;
/* 2584 */     if ((this.t13 == null) && (other.getT13() != null)) return false;
/* 2585 */     if ((this.t13 != null) && (!this.t13.equals(other.getT13()))) return false;
/* 2586 */     if ((this.t14 == null) && (other.getT14() != null)) return false;
/* 2587 */     if ((this.t14 != null) && (!this.t14.equals(other.getT14()))) return false;
/* 2588 */     if (Double.doubleToLongBits(this.t15) != Double.doubleToLongBits(other.getT15())) return false;
/* 2589 */     if ((this.outWorkDate == null) && (other.getOutWorkDate() != null)) return false;
/* 2590 */     if ((this.outWorkDate != null) && (!this.fDate.getString(this.outWorkDate).equals(other.getOutWorkDate()))) return false;
/* 2591 */     if (Double.doubleToLongBits(this.t16) != Double.doubleToLongBits(other.getT16())) return false;
/* 2592 */     if (Double.doubleToLongBits(this.t17) != Double.doubleToLongBits(other.getT17())) return false;
/* 2593 */     if (Double.doubleToLongBits(this.t18) != Double.doubleToLongBits(other.getT18())) return false;
/* 2594 */     if ((this.t19 == null) && (other.getT19() != null)) return false;
/* 2595 */     if ((this.t19 != null) && (!this.t19.equals(other.getT19()))) return false;
/* 2596 */     if (Double.doubleToLongBits(this.t20) != Double.doubleToLongBits(other.getT20())) return false;
/* 2597 */     if (Double.doubleToLongBits(this.t21) != Double.doubleToLongBits(other.getT21())) return false;
/* 2598 */     if ((this.t22 == null) && (other.getT22() != null)) return false;
/* 2599 */     if ((this.t22 != null) && (!this.t22.equals(other.getT22()))) return false;
/* 2600 */     if ((this.sMManager2 == null) && (other.getSMManager2() != null)) return false;
/* 2601 */     if ((this.sMManager2 != null) && (!this.sMManager2.equals(other.getSMManager2()))) return false;
/* 2602 */     if ((this.rMManager2 == null) && (other.getRMManager2() != null)) return false;
/* 2603 */     if ((this.rMManager2 != null) && (!this.rMManager2.equals(other.getRMManager2()))) return false;
/* 2604 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 2605 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 2606 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 2607 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 2608 */     if (this.iF01 != other.getIF01()) return false;
/* 2609 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 2610 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 2611 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 2612 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 2613 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 2614 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 2615 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 2616 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 2617 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 2618 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 2619 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 2620 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 2621 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 2622 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 2623 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 2624 */     if (Double.doubleToLongBits(this.c1) != Double.doubleToLongBits(other.getC1())) return false;
/* 2625 */     if (Double.doubleToLongBits(this.c2) != Double.doubleToLongBits(other.getC2())) return false;
/* 2626 */     if (Double.doubleToLongBits(this.c3) != Double.doubleToLongBits(other.getC3())) return false;
/* 2627 */     if (Double.doubleToLongBits(this.c4) != Double.doubleToLongBits(other.getC4())) return false;
/* 2628 */     if (Double.doubleToLongBits(this.c5) != Double.doubleToLongBits(other.getC5())) return false;
/* 2629 */     if (Double.doubleToLongBits(this.c6) != Double.doubleToLongBits(other.getC6())) return false;
/* 2630 */     if (Double.doubleToLongBits(this.c7) != Double.doubleToLongBits(other.getC7())) return false;
/* 2631 */     if (Double.doubleToLongBits(this.c8) != Double.doubleToLongBits(other.getC8())) return false;
/* 2632 */     if (Double.doubleToLongBits(this.c9) != Double.doubleToLongBits(other.getC9())) return false;
/* 2633 */     return Double.doubleToLongBits(this.c10) == Double.doubleToLongBits(other.getC10());
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 2640 */     return 63;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 2646 */     if (strFieldName.equals("statYear")) {
/* 2647 */       return 0;
/*      */     }
/* 2649 */     if (strFieldName.equals("statBatch")) {
/* 2650 */       return 1;
/*      */     }
/* 2652 */     if (strFieldName.equals("agentCode")) {
/* 2653 */       return 2;
/*      */     }
/* 2655 */     if (strFieldName.equals("manageCom")) {
/* 2656 */       return 3;
/*      */     }
/* 2658 */     if (strFieldName.equals("branchType")) {
/* 2659 */       return 4;
/*      */     }
/* 2661 */     if (strFieldName.equals("startDate")) {
/* 2662 */       return 5;
/*      */     }
/* 2664 */     if (strFieldName.equals("endDate")) {
/* 2665 */       return 6;
/*      */     }
/* 2667 */     if (strFieldName.equals("name")) {
/* 2668 */       return 7;
/*      */     }
/* 2670 */     if (strFieldName.equals("employDate")) {
/* 2671 */       return 8;
/*      */     }
/* 2673 */     if (strFieldName.equals("branchAttr")) {
/* 2674 */       return 9;
/*      */     }
/* 2676 */     if (strFieldName.equals("agentGrade")) {
/* 2677 */       return 10;
/*      */     }
/* 2679 */     if (strFieldName.equals("sMManagerName")) {
/* 2680 */       return 11;
/*      */     }
/* 2682 */     if (strFieldName.equals("aMManagerName")) {
/* 2683 */       return 12;
/*      */     }
/* 2685 */     if (strFieldName.equals("rMManagerName")) {
/* 2686 */       return 13;
/*      */     }
/* 2688 */     if (strFieldName.equals("t1")) {
/* 2689 */       return 14;
/*      */     }
/* 2691 */     if (strFieldName.equals("t2")) {
/* 2692 */       return 15;
/*      */     }
/* 2694 */     if (strFieldName.equals("t3")) {
/* 2695 */       return 16;
/*      */     }
/* 2697 */     if (strFieldName.equals("t4")) {
/* 2698 */       return 17;
/*      */     }
/* 2700 */     if (strFieldName.equals("t5")) {
/* 2701 */       return 18;
/*      */     }
/* 2703 */     if (strFieldName.equals("t6")) {
/* 2704 */       return 19;
/*      */     }
/* 2706 */     if (strFieldName.equals("t7")) {
/* 2707 */       return 20;
/*      */     }
/* 2709 */     if (strFieldName.equals("t8")) {
/* 2710 */       return 21;
/*      */     }
/* 2712 */     if (strFieldName.equals("t9")) {
/* 2713 */       return 22;
/*      */     }
/* 2715 */     if (strFieldName.equals("t10")) {
/* 2716 */       return 23;
/*      */     }
/* 2718 */     if (strFieldName.equals("t11")) {
/* 2719 */       return 24;
/*      */     }
/* 2721 */     if (strFieldName.equals("t12")) {
/* 2722 */       return 25;
/*      */     }
/* 2724 */     if (strFieldName.equals("aMManager")) {
/* 2725 */       return 26;
/*      */     }
/* 2727 */     if (strFieldName.equals("rMManager")) {
/* 2728 */       return 27;
/*      */     }
/* 2730 */     if (strFieldName.equals("sMManager")) {
/* 2731 */       return 28;
/*      */     }
/* 2733 */     if (strFieldName.equals("t13")) {
/* 2734 */       return 29;
/*      */     }
/* 2736 */     if (strFieldName.equals("t14")) {
/* 2737 */       return 30;
/*      */     }
/* 2739 */     if (strFieldName.equals("t15")) {
/* 2740 */       return 31;
/*      */     }
/* 2742 */     if (strFieldName.equals("outWorkDate")) {
/* 2743 */       return 32;
/*      */     }
/* 2745 */     if (strFieldName.equals("t16")) {
/* 2746 */       return 33;
/*      */     }
/* 2748 */     if (strFieldName.equals("t17")) {
/* 2749 */       return 34;
/*      */     }
/* 2751 */     if (strFieldName.equals("t18")) {
/* 2752 */       return 35;
/*      */     }
/* 2754 */     if (strFieldName.equals("t19")) {
/* 2755 */       return 36;
/*      */     }
/* 2757 */     if (strFieldName.equals("t20")) {
/* 2758 */       return 37;
/*      */     }
/* 2760 */     if (strFieldName.equals("t21")) {
/* 2761 */       return 38;
/*      */     }
/* 2763 */     if (strFieldName.equals("t22")) {
/* 2764 */       return 39;
/*      */     }
/* 2766 */     if (strFieldName.equals("sMManager2")) {
/* 2767 */       return 40;
/*      */     }
/* 2769 */     if (strFieldName.equals("rMManager2")) {
/* 2770 */       return 41;
/*      */     }
/* 2772 */     if (strFieldName.equals("vF01")) {
/* 2773 */       return 42;
/*      */     }
/* 2775 */     if (strFieldName.equals("nF01")) {
/* 2776 */       return 43;
/*      */     }
/* 2778 */     if (strFieldName.equals("iF01")) {
/* 2779 */       return 44;
/*      */     }
/* 2781 */     if (strFieldName.equals("dF02")) {
/* 2782 */       return 45;
/*      */     }
/* 2784 */     if (strFieldName.equals("date01")) {
/* 2785 */       return 46;
/*      */     }
/* 2787 */     if (strFieldName.equals("modifyOperator")) {
/* 2788 */       return 47;
/*      */     }
/* 2790 */     if (strFieldName.equals("operator")) {
/* 2791 */       return 48;
/*      */     }
/* 2793 */     if (strFieldName.equals("makeDate")) {
/* 2794 */       return 49;
/*      */     }
/* 2796 */     if (strFieldName.equals("makeTime")) {
/* 2797 */       return 50;
/*      */     }
/* 2799 */     if (strFieldName.equals("modifyDate")) {
/* 2800 */       return 51;
/*      */     }
/* 2802 */     if (strFieldName.equals("modifyTime")) {
/* 2803 */       return 52;
/*      */     }
/* 2805 */     if (strFieldName.equals("c1")) {
/* 2806 */       return 53;
/*      */     }
/* 2808 */     if (strFieldName.equals("c2")) {
/* 2809 */       return 54;
/*      */     }
/* 2811 */     if (strFieldName.equals("c3")) {
/* 2812 */       return 55;
/*      */     }
/* 2814 */     if (strFieldName.equals("c4")) {
/* 2815 */       return 56;
/*      */     }
/* 2817 */     if (strFieldName.equals("c5")) {
/* 2818 */       return 57;
/*      */     }
/* 2820 */     if (strFieldName.equals("c6")) {
/* 2821 */       return 58;
/*      */     }
/* 2823 */     if (strFieldName.equals("c7")) {
/* 2824 */       return 59;
/*      */     }
/* 2826 */     if (strFieldName.equals("c8")) {
/* 2827 */       return 60;
/*      */     }
/* 2829 */     if (strFieldName.equals("c9")) {
/* 2830 */       return 61;
/*      */     }
/* 2832 */     if (strFieldName.equals("c10")) {
/* 2833 */       return 62;
/*      */     }
/* 2835 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2841 */     String strFieldName = "";
/* 2842 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2844 */       strFieldName = "statYear";
/* 2845 */       break;
/*      */     case 1:
/* 2847 */       strFieldName = "statBatch";
/* 2848 */       break;
/*      */     case 2:
/* 2850 */       strFieldName = "agentCode";
/* 2851 */       break;
/*      */     case 3:
/* 2853 */       strFieldName = "manageCom";
/* 2854 */       break;
/*      */     case 4:
/* 2856 */       strFieldName = "branchType";
/* 2857 */       break;
/*      */     case 5:
/* 2859 */       strFieldName = "startDate";
/* 2860 */       break;
/*      */     case 6:
/* 2862 */       strFieldName = "endDate";
/* 2863 */       break;
/*      */     case 7:
/* 2865 */       strFieldName = "name";
/* 2866 */       break;
/*      */     case 8:
/* 2868 */       strFieldName = "employDate";
/* 2869 */       break;
/*      */     case 9:
/* 2871 */       strFieldName = "branchAttr";
/* 2872 */       break;
/*      */     case 10:
/* 2874 */       strFieldName = "agentGrade";
/* 2875 */       break;
/*      */     case 11:
/* 2877 */       strFieldName = "sMManagerName";
/* 2878 */       break;
/*      */     case 12:
/* 2880 */       strFieldName = "aMManagerName";
/* 2881 */       break;
/*      */     case 13:
/* 2883 */       strFieldName = "rMManagerName";
/* 2884 */       break;
/*      */     case 14:
/* 2886 */       strFieldName = "t1";
/* 2887 */       break;
/*      */     case 15:
/* 2889 */       strFieldName = "t2";
/* 2890 */       break;
/*      */     case 16:
/* 2892 */       strFieldName = "t3";
/* 2893 */       break;
/*      */     case 17:
/* 2895 */       strFieldName = "t4";
/* 2896 */       break;
/*      */     case 18:
/* 2898 */       strFieldName = "t5";
/* 2899 */       break;
/*      */     case 19:
/* 2901 */       strFieldName = "t6";
/* 2902 */       break;
/*      */     case 20:
/* 2904 */       strFieldName = "t7";
/* 2905 */       break;
/*      */     case 21:
/* 2907 */       strFieldName = "t8";
/* 2908 */       break;
/*      */     case 22:
/* 2910 */       strFieldName = "t9";
/* 2911 */       break;
/*      */     case 23:
/* 2913 */       strFieldName = "t10";
/* 2914 */       break;
/*      */     case 24:
/* 2916 */       strFieldName = "t11";
/* 2917 */       break;
/*      */     case 25:
/* 2919 */       strFieldName = "t12";
/* 2920 */       break;
/*      */     case 26:
/* 2922 */       strFieldName = "aMManager";
/* 2923 */       break;
/*      */     case 27:
/* 2925 */       strFieldName = "rMManager";
/* 2926 */       break;
/*      */     case 28:
/* 2928 */       strFieldName = "sMManager";
/* 2929 */       break;
/*      */     case 29:
/* 2931 */       strFieldName = "t13";
/* 2932 */       break;
/*      */     case 30:
/* 2934 */       strFieldName = "t14";
/* 2935 */       break;
/*      */     case 31:
/* 2937 */       strFieldName = "t15";
/* 2938 */       break;
/*      */     case 32:
/* 2940 */       strFieldName = "outWorkDate";
/* 2941 */       break;
/*      */     case 33:
/* 2943 */       strFieldName = "t16";
/* 2944 */       break;
/*      */     case 34:
/* 2946 */       strFieldName = "t17";
/* 2947 */       break;
/*      */     case 35:
/* 2949 */       strFieldName = "t18";
/* 2950 */       break;
/*      */     case 36:
/* 2952 */       strFieldName = "t19";
/* 2953 */       break;
/*      */     case 37:
/* 2955 */       strFieldName = "t20";
/* 2956 */       break;
/*      */     case 38:
/* 2958 */       strFieldName = "t21";
/* 2959 */       break;
/*      */     case 39:
/* 2961 */       strFieldName = "t22";
/* 2962 */       break;
/*      */     case 40:
/* 2964 */       strFieldName = "sMManager2";
/* 2965 */       break;
/*      */     case 41:
/* 2967 */       strFieldName = "rMManager2";
/* 2968 */       break;
/*      */     case 42:
/* 2970 */       strFieldName = "vF01";
/* 2971 */       break;
/*      */     case 43:
/* 2973 */       strFieldName = "nF01";
/* 2974 */       break;
/*      */     case 44:
/* 2976 */       strFieldName = "iF01";
/* 2977 */       break;
/*      */     case 45:
/* 2979 */       strFieldName = "dF02";
/* 2980 */       break;
/*      */     case 46:
/* 2982 */       strFieldName = "date01";
/* 2983 */       break;
/*      */     case 47:
/* 2985 */       strFieldName = "modifyOperator";
/* 2986 */       break;
/*      */     case 48:
/* 2988 */       strFieldName = "operator";
/* 2989 */       break;
/*      */     case 49:
/* 2991 */       strFieldName = "makeDate";
/* 2992 */       break;
/*      */     case 50:
/* 2994 */       strFieldName = "makeTime";
/* 2995 */       break;
/*      */     case 51:
/* 2997 */       strFieldName = "modifyDate";
/* 2998 */       break;
/*      */     case 52:
/* 3000 */       strFieldName = "modifyTime";
/* 3001 */       break;
/*      */     case 53:
/* 3003 */       strFieldName = "c1";
/* 3004 */       break;
/*      */     case 54:
/* 3006 */       strFieldName = "c2";
/* 3007 */       break;
/*      */     case 55:
/* 3009 */       strFieldName = "c3";
/* 3010 */       break;
/*      */     case 56:
/* 3012 */       strFieldName = "c4";
/* 3013 */       break;
/*      */     case 57:
/* 3015 */       strFieldName = "c5";
/* 3016 */       break;
/*      */     case 58:
/* 3018 */       strFieldName = "c6";
/* 3019 */       break;
/*      */     case 59:
/* 3021 */       strFieldName = "c7";
/* 3022 */       break;
/*      */     case 60:
/* 3024 */       strFieldName = "c8";
/* 3025 */       break;
/*      */     case 61:
/* 3027 */       strFieldName = "c9";
/* 3028 */       break;
/*      */     case 62:
/* 3030 */       strFieldName = "c10";
/* 3031 */       break;
/*      */     default:
/* 3033 */       strFieldName = "";
/*      */     }
/* 3035 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 3041 */     if (strFieldName.equals("statYear")) {
/* 3042 */       return 0;
/*      */     }
/* 3044 */     if (strFieldName.equals("statBatch")) {
/* 3045 */       return 0;
/*      */     }
/* 3047 */     if (strFieldName.equals("agentCode")) {
/* 3048 */       return 0;
/*      */     }
/* 3050 */     if (strFieldName.equals("manageCom")) {
/* 3051 */       return 0;
/*      */     }
/* 3053 */     if (strFieldName.equals("branchType")) {
/* 3054 */       return 0;
/*      */     }
/* 3056 */     if (strFieldName.equals("startDate")) {
/* 3057 */       return 1;
/*      */     }
/* 3059 */     if (strFieldName.equals("endDate")) {
/* 3060 */       return 1;
/*      */     }
/* 3062 */     if (strFieldName.equals("name")) {
/* 3063 */       return 0;
/*      */     }
/* 3065 */     if (strFieldName.equals("employDate")) {
/* 3066 */       return 1;
/*      */     }
/* 3068 */     if (strFieldName.equals("branchAttr")) {
/* 3069 */       return 0;
/*      */     }
/* 3071 */     if (strFieldName.equals("agentGrade")) {
/* 3072 */       return 0;
/*      */     }
/* 3074 */     if (strFieldName.equals("sMManagerName")) {
/* 3075 */       return 0;
/*      */     }
/* 3077 */     if (strFieldName.equals("aMManagerName")) {
/* 3078 */       return 0;
/*      */     }
/* 3080 */     if (strFieldName.equals("rMManagerName")) {
/* 3081 */       return 0;
/*      */     }
/* 3083 */     if (strFieldName.equals("t1")) {
/* 3084 */       return 4;
/*      */     }
/* 3086 */     if (strFieldName.equals("t2")) {
/* 3087 */       return 4;
/*      */     }
/* 3089 */     if (strFieldName.equals("t3")) {
/* 3090 */       return 4;
/*      */     }
/* 3092 */     if (strFieldName.equals("t4")) {
/* 3093 */       return 4;
/*      */     }
/* 3095 */     if (strFieldName.equals("t5")) {
/* 3096 */       return 4;
/*      */     }
/* 3098 */     if (strFieldName.equals("t6")) {
/* 3099 */       return 4;
/*      */     }
/* 3101 */     if (strFieldName.equals("t7")) {
/* 3102 */       return 0;
/*      */     }
/* 3104 */     if (strFieldName.equals("t8")) {
/* 3105 */       return 0;
/*      */     }
/* 3107 */     if (strFieldName.equals("t9")) {
/* 3108 */       return 0;
/*      */     }
/* 3110 */     if (strFieldName.equals("t10")) {
/* 3111 */       return 4;
/*      */     }
/* 3113 */     if (strFieldName.equals("t11")) {
/* 3114 */       return 4;
/*      */     }
/* 3116 */     if (strFieldName.equals("t12")) {
/* 3117 */       return 4;
/*      */     }
/* 3119 */     if (strFieldName.equals("aMManager")) {
/* 3120 */       return 0;
/*      */     }
/* 3122 */     if (strFieldName.equals("rMManager")) {
/* 3123 */       return 0;
/*      */     }
/* 3125 */     if (strFieldName.equals("sMManager")) {
/* 3126 */       return 0;
/*      */     }
/* 3128 */     if (strFieldName.equals("t13")) {
/* 3129 */       return 0;
/*      */     }
/* 3131 */     if (strFieldName.equals("t14")) {
/* 3132 */       return 0;
/*      */     }
/* 3134 */     if (strFieldName.equals("t15")) {
/* 3135 */       return 4;
/*      */     }
/* 3137 */     if (strFieldName.equals("outWorkDate")) {
/* 3138 */       return 1;
/*      */     }
/* 3140 */     if (strFieldName.equals("t16")) {
/* 3141 */       return 4;
/*      */     }
/* 3143 */     if (strFieldName.equals("t17")) {
/* 3144 */       return 4;
/*      */     }
/* 3146 */     if (strFieldName.equals("t18")) {
/* 3147 */       return 4;
/*      */     }
/* 3149 */     if (strFieldName.equals("t19")) {
/* 3150 */       return 0;
/*      */     }
/* 3152 */     if (strFieldName.equals("t20")) {
/* 3153 */       return 4;
/*      */     }
/* 3155 */     if (strFieldName.equals("t21")) {
/* 3156 */       return 4;
/*      */     }
/* 3158 */     if (strFieldName.equals("t22")) {
/* 3159 */       return 0;
/*      */     }
/* 3161 */     if (strFieldName.equals("sMManager2")) {
/* 3162 */       return 0;
/*      */     }
/* 3164 */     if (strFieldName.equals("rMManager2")) {
/* 3165 */       return 0;
/*      */     }
/* 3167 */     if (strFieldName.equals("vF01")) {
/* 3168 */       return 0;
/*      */     }
/* 3170 */     if (strFieldName.equals("nF01")) {
/* 3171 */       return 0;
/*      */     }
/* 3173 */     if (strFieldName.equals("iF01")) {
/* 3174 */       return 3;
/*      */     }
/* 3176 */     if (strFieldName.equals("dF02")) {
/* 3177 */       return 4;
/*      */     }
/* 3179 */     if (strFieldName.equals("date01")) {
/* 3180 */       return 1;
/*      */     }
/* 3182 */     if (strFieldName.equals("modifyOperator")) {
/* 3183 */       return 0;
/*      */     }
/* 3185 */     if (strFieldName.equals("operator")) {
/* 3186 */       return 0;
/*      */     }
/* 3188 */     if (strFieldName.equals("makeDate")) {
/* 3189 */       return 1;
/*      */     }
/* 3191 */     if (strFieldName.equals("makeTime")) {
/* 3192 */       return 0;
/*      */     }
/* 3194 */     if (strFieldName.equals("modifyDate")) {
/* 3195 */       return 1;
/*      */     }
/* 3197 */     if (strFieldName.equals("modifyTime")) {
/* 3198 */       return 0;
/*      */     }
/* 3200 */     if (strFieldName.equals("c1")) {
/* 3201 */       return 4;
/*      */     }
/* 3203 */     if (strFieldName.equals("c2")) {
/* 3204 */       return 4;
/*      */     }
/* 3206 */     if (strFieldName.equals("c3")) {
/* 3207 */       return 4;
/*      */     }
/* 3209 */     if (strFieldName.equals("c4")) {
/* 3210 */       return 4;
/*      */     }
/* 3212 */     if (strFieldName.equals("c5")) {
/* 3213 */       return 4;
/*      */     }
/* 3215 */     if (strFieldName.equals("c6")) {
/* 3216 */       return 4;
/*      */     }
/* 3218 */     if (strFieldName.equals("c7")) {
/* 3219 */       return 4;
/*      */     }
/* 3221 */     if (strFieldName.equals("c8")) {
/* 3222 */       return 4;
/*      */     }
/* 3224 */     if (strFieldName.equals("c9")) {
/* 3225 */       return 4;
/*      */     }
/* 3227 */     if (strFieldName.equals("c10")) {
/* 3228 */       return 4;
/*      */     }
/* 3230 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 3236 */     int nFieldType = -1;
/* 3237 */     switch (nFieldIndex) {
/*      */     case 0:
/* 3239 */       nFieldType = 0;
/* 3240 */       break;
/*      */     case 1:
/* 3242 */       nFieldType = 0;
/* 3243 */       break;
/*      */     case 2:
/* 3245 */       nFieldType = 0;
/* 3246 */       break;
/*      */     case 3:
/* 3248 */       nFieldType = 0;
/* 3249 */       break;
/*      */     case 4:
/* 3251 */       nFieldType = 0;
/* 3252 */       break;
/*      */     case 5:
/* 3254 */       nFieldType = 1;
/* 3255 */       break;
/*      */     case 6:
/* 3257 */       nFieldType = 1;
/* 3258 */       break;
/*      */     case 7:
/* 3260 */       nFieldType = 0;
/* 3261 */       break;
/*      */     case 8:
/* 3263 */       nFieldType = 1;
/* 3264 */       break;
/*      */     case 9:
/* 3266 */       nFieldType = 0;
/* 3267 */       break;
/*      */     case 10:
/* 3269 */       nFieldType = 0;
/* 3270 */       break;
/*      */     case 11:
/* 3272 */       nFieldType = 0;
/* 3273 */       break;
/*      */     case 12:
/* 3275 */       nFieldType = 0;
/* 3276 */       break;
/*      */     case 13:
/* 3278 */       nFieldType = 0;
/* 3279 */       break;
/*      */     case 14:
/* 3281 */       nFieldType = 4;
/* 3282 */       break;
/*      */     case 15:
/* 3284 */       nFieldType = 4;
/* 3285 */       break;
/*      */     case 16:
/* 3287 */       nFieldType = 4;
/* 3288 */       break;
/*      */     case 17:
/* 3290 */       nFieldType = 4;
/* 3291 */       break;
/*      */     case 18:
/* 3293 */       nFieldType = 4;
/* 3294 */       break;
/*      */     case 19:
/* 3296 */       nFieldType = 4;
/* 3297 */       break;
/*      */     case 20:
/* 3299 */       nFieldType = 0;
/* 3300 */       break;
/*      */     case 21:
/* 3302 */       nFieldType = 0;
/* 3303 */       break;
/*      */     case 22:
/* 3305 */       nFieldType = 0;
/* 3306 */       break;
/*      */     case 23:
/* 3308 */       nFieldType = 4;
/* 3309 */       break;
/*      */     case 24:
/* 3311 */       nFieldType = 4;
/* 3312 */       break;
/*      */     case 25:
/* 3314 */       nFieldType = 4;
/* 3315 */       break;
/*      */     case 26:
/* 3317 */       nFieldType = 0;
/* 3318 */       break;
/*      */     case 27:
/* 3320 */       nFieldType = 0;
/* 3321 */       break;
/*      */     case 28:
/* 3323 */       nFieldType = 0;
/* 3324 */       break;
/*      */     case 29:
/* 3326 */       nFieldType = 0;
/* 3327 */       break;
/*      */     case 30:
/* 3329 */       nFieldType = 0;
/* 3330 */       break;
/*      */     case 31:
/* 3332 */       nFieldType = 4;
/* 3333 */       break;
/*      */     case 32:
/* 3335 */       nFieldType = 1;
/* 3336 */       break;
/*      */     case 33:
/* 3338 */       nFieldType = 4;
/* 3339 */       break;
/*      */     case 34:
/* 3341 */       nFieldType = 4;
/* 3342 */       break;
/*      */     case 35:
/* 3344 */       nFieldType = 4;
/* 3345 */       break;
/*      */     case 36:
/* 3347 */       nFieldType = 0;
/* 3348 */       break;
/*      */     case 37:
/* 3350 */       nFieldType = 4;
/* 3351 */       break;
/*      */     case 38:
/* 3353 */       nFieldType = 4;
/* 3354 */       break;
/*      */     case 39:
/* 3356 */       nFieldType = 0;
/* 3357 */       break;
/*      */     case 40:
/* 3359 */       nFieldType = 0;
/* 3360 */       break;
/*      */     case 41:
/* 3362 */       nFieldType = 0;
/* 3363 */       break;
/*      */     case 42:
/* 3365 */       nFieldType = 0;
/* 3366 */       break;
/*      */     case 43:
/* 3368 */       nFieldType = 0;
/* 3369 */       break;
/*      */     case 44:
/* 3371 */       nFieldType = 3;
/* 3372 */       break;
/*      */     case 45:
/* 3374 */       nFieldType = 4;
/* 3375 */       break;
/*      */     case 46:
/* 3377 */       nFieldType = 1;
/* 3378 */       break;
/*      */     case 47:
/* 3380 */       nFieldType = 0;
/* 3381 */       break;
/*      */     case 48:
/* 3383 */       nFieldType = 0;
/* 3384 */       break;
/*      */     case 49:
/* 3386 */       nFieldType = 1;
/* 3387 */       break;
/*      */     case 50:
/* 3389 */       nFieldType = 0;
/* 3390 */       break;
/*      */     case 51:
/* 3392 */       nFieldType = 1;
/* 3393 */       break;
/*      */     case 52:
/* 3395 */       nFieldType = 0;
/* 3396 */       break;
/*      */     case 53:
/* 3398 */       nFieldType = 4;
/* 3399 */       break;
/*      */     case 54:
/* 3401 */       nFieldType = 4;
/* 3402 */       break;
/*      */     case 55:
/* 3404 */       nFieldType = 4;
/* 3405 */       break;
/*      */     case 56:
/* 3407 */       nFieldType = 4;
/* 3408 */       break;
/*      */     case 57:
/* 3410 */       nFieldType = 4;
/* 3411 */       break;
/*      */     case 58:
/* 3413 */       nFieldType = 4;
/* 3414 */       break;
/*      */     case 59:
/* 3416 */       nFieldType = 4;
/* 3417 */       break;
/*      */     case 60:
/* 3419 */       nFieldType = 4;
/* 3420 */       break;
/*      */     case 61:
/* 3422 */       nFieldType = 4;
/* 3423 */       break;
/*      */     case 62:
/* 3425 */       nFieldType = 4;
/* 3426 */       break;
/*      */     default:
/* 3428 */       nFieldType = -1;
/*      */     }
/* 3430 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MLPHonorSchema
 * JD-Core Version:    0.6.0
 */