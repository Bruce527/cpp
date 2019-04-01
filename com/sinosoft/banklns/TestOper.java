/*     */ package com.sinosoft.banklns;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.bean.BankLNPBnfBean;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.utility.DBConn;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.io.PrintStream;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class TestOper
/*     */ {
/*  23 */   private BankLNPBnfBean bean = new BankLNPBnfBean();
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  33 */     TestOper t = new TestOper();
/*     */ 
/*  82 */     System.out.println(PubFun.calInterval("2012-09-29", "2012-10-29", "D"));
/*     */   }
/*     */ 
/*     */   public String calHMS(long timeInSeconds)
/*     */   {
/*  90 */     long hours = timeInSeconds / 3600L;
/*  91 */     timeInSeconds -= hours * 3600L;
/*  92 */     long minutes = timeInSeconds / 60L;
/*  93 */     timeInSeconds -= minutes * 60L;
/*  94 */     long seconds = timeInSeconds;
/*  95 */     return hours + " hour(s) " + minutes + " minute(s) " + seconds + " second(s)";
/*     */   }
/*     */ 
/*     */   public void formatKinds() {
/*  99 */     DecimalFormat formatDouble = new DecimalFormat("#.00");
/* 100 */     double number = 100000000.0D;
/* 101 */     String rst = formatDouble.format(number);
/* 102 */     String number1 = "100000000.00";
/*     */   }
/*     */ 
/*     */   public void DBconnT()
/*     */   {
/* 107 */     for (int i = 0; i < 300; i++)
/*     */       try {
/* 109 */         DBConn con = DBConnPool.getConnection();
/* 110 */         System.out.println("cur idx:" + (i + 1) + "----------start:" + PubFun.getCurrentTime());
/* 111 */         Thread.sleep(500L);
/* 112 */         System.out.println("----------end:" + PubFun.getCurrentTime());
/* 113 */         ExeSQL execSQL = new ExeSQL(con);
/* 114 */         SSRS ssrs = execSQL.execSQL("select * from lnpcont");
/* 115 */         System.out.println(ssrs.getMaxRow());
/*     */       }
/*     */       catch (InterruptedException e) {
/* 118 */         e.printStackTrace();
/*     */       }
/*     */   }
/*     */ 
/*     */   public String fomartDate(String date)
/*     */   {
/* 125 */     if (date != null)
/* 126 */       return date.replaceAll("^(\\d+)-(\\d+)-(\\d+).*$", "$1$2$3");
/* 127 */     return null;
/*     */   }
/*     */ 
/*     */   public void init() {
/* 131 */     MMap map = new MMap();
/* 132 */     this.bean = new BankLNPBnfBean();
/* 133 */     add(this.bean, map);
/* 134 */     add1(this.bean, map);
/* 135 */     this.bean = ((BankLNPBnfBean)map.get("bean"));
/* 136 */     this.bean.setGender("nan");
/* 137 */     System.out.println(this.bean.getIdType() + "------" + this.bean.getRelationToInsured() + "----------" + this.bean.getGender());
/*     */   }
/*     */   public MMap add(BankLNPBnfBean bean, MMap map) {
/* 140 */     bean.setIdType("shenfenzheng");
/* 141 */     System.out.println(bean.getIdType() + "------" + bean.getRelationToInsured() + "----------" + bean.getGender());
/* 142 */     map.put("bean", bean);
/* 143 */     return map;
/*     */   }
/*     */   public MMap add1(BankLNPBnfBean bean, MMap map) {
/* 146 */     bean.setRelationToInsured("songsss");
/* 147 */     System.out.println(bean.getIdType() + "------" + bean.getRelationToInsured() + "----------" + bean.getGender());
/* 148 */     map.put("bean", bean);
/* 149 */     return map;
/*     */   }
/*     */ 
/*     */   public void init1() {
/* 153 */     MMap amap = new MMap();
/* 154 */     BankLNPBnfBean bean1 = new BankLNPBnfBean();
/* 155 */     BankLNPBnfBean bean2 = new BankLNPBnfBean();
/* 156 */     add2(bean1, amap);
/* 157 */     add3(bean2, amap);
/* 158 */     for (int i = 0; i < amap.keySet().size(); i++) {
/* 159 */       Object key = amap.getKeyByOrder(String.valueOf(i + 1));
/* 160 */       System.out.println(amap.get(key).toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void add2(BankLNPBnfBean bean, MMap map) {
/* 165 */     bean.setIdType("1111");
/* 166 */     map.put(bean, "update");
/*     */   }
/*     */ 
/*     */   public void add3(BankLNPBnfBean bean, MMap map) {
/* 170 */     bean.setIdType("2222");
/* 171 */     map.put(bean, "update");
/*     */   }
/*     */ 
/*     */   public void init2() {
/* 175 */     String txt = "ABC^12312^|ABC^12312^|ABC^12312^";
/* 176 */     String[] args = txt.split("\\|");
/*     */ 
/* 180 */     System.out.println(args[0].split("\\^")[2]);
/*     */   }
/*     */ 
/*     */   public void sendFile()
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.TestOper
 * JD-Core Version:    0.6.0
 */