/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ public class PubFun1
/*     */ {
/*     */   public static String CreateMaxNo(String cNoType, String cNoLimit)
/*     */   {
/*     */     try
/*     */     {
/*  35 */       System.out.println("sysmaxnotype:METLIFE");
/*     */ 
/*  37 */       String className = "com.sinosoft.map.lis.pubfun.SysMaxNoMETLIFE";
/*     */ 
/*  39 */       Class cc = Class.forName(className);
/*  40 */       SysMaxNo tSysMaxNo = 
/*  42 */         (SysMaxNo)cc.newInstance();
/*  43 */       return tSysMaxNo.CreateMaxNo(cNoType, cNoLimit);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  47 */       ex.printStackTrace();
/*  48 */     }return null;
/*     */   }
/*     */ 
/*     */   public static String creatVerifyDigit(String originalDigit)
/*     */   {
/*     */     try
/*     */     {
/*  57 */       String finalDigit = null;
/*  58 */       String[] alterDigOdd = null;
/*  59 */       String[] alterDigEven = null;
/*  60 */       System.out.println("originalDigit" + originalDigit + "originalDigit.length()" + originalDigit.length());
/*  61 */       if (!"".equalsIgnoreCase(originalDigit)) {
/*  62 */         alterDigOdd = new String[originalDigit.length()];
/*  63 */         alterDigEven = new String[originalDigit.length()];
/*  64 */         for (int i = 0; i < originalDigit.length(); i++) {
/*  65 */           if (i == 0) {
/*  66 */             alterDigOdd[i] = originalDigit.substring(i, i + 1);
/*  67 */             System.out.println("alterDigOdd[" + i + "]" + alterDigOdd[i].toString());
/*     */           }
/*  69 */           if (i == 1) {
/*  70 */             alterDigEven[i] = originalDigit.substring(i, i + 1);
/*  71 */             System.out.println("alterDigEven[" + i + "]" + alterDigEven[i].toString());
/*     */           }
/*  73 */           if ((i > 1) && (i % 2 == 1)) {
/*  74 */             alterDigEven[i] = originalDigit.substring(i, i + 1);
/*  75 */             System.out.println("alterDigEven[" + i + "]" + alterDigEven[i].toString());
/*     */           }
/*  77 */           if ((i > 1) && (i % 2 == 0)) {
/*  78 */             alterDigOdd[i] = originalDigit.substring(i, i + 1);
/*  79 */             System.out.println("alterDigOdd[" + i + "]" + alterDigOdd[i].toString());
/*     */           }
/*     */         }
/*     */       }
/*  83 */       for (int i = alterDigOdd.length - 1; i >= 0; i--) {
/*  84 */         System.out.println("alterDigOdd\u6570\u7EC4\u7684\u5143\u7D20[" + i + "]" + alterDigOdd[i]);
/*     */       }
/*  86 */       for (int i = alterDigEven.length - 1; i >= 0; i--) {
/*  87 */         System.out.println("alterDigEven\u6570\u7EC4\u7684\u5143\u7D20[" + i + "]" + alterDigEven[i]);
/*     */       }
/*  89 */       System.out.println("alterDigOdd" + alterDigOdd.toString() + "alterDigOdd.length()" + alterDigOdd.length);
/*  90 */       System.out.println("alterDigEven" + alterDigEven.toString() + "alterDigEven.length()" + alterDigEven.length);
/*     */ 
/*  92 */       if (!"".equals(alterDigOdd))
/*     */       {
/*  94 */         for (int i = 0; i < alterDigOdd.length; i++) {
/*  95 */           if ((alterDigOdd[i] != null) && (alterDigOdd[i] != "null") && (alterDigOdd[i] != "0")) {
/*  96 */             System.out.println("(String)alterDigOdd[i]" + alterDigOdd[i]);
/*  97 */             String tempString = null;
/*  98 */             System.out.println("alterDigOdd before double[" + i + "]:" + alterDigOdd[i]);
/*  99 */             tempString = String.valueOf(2 * Integer.parseInt(alterDigOdd[i].toString()));
/* 100 */             System.out.println("alterDigOdd after double[" + i + "]:" + alterDigOdd[i]);
/* 101 */             alterDigOdd[i] = "";
/* 102 */             alterDigOdd[i] = tempString;
/*     */ 
/* 104 */             if ((!"".equals(alterDigOdd[i])) && (alterDigOdd[i].toString().length() > 1)) {
/* 105 */               int tempInt = 0;
/* 106 */               for (int j = 0; j < alterDigOdd[i].length(); j++) {
/* 107 */                 String temp = alterDigOdd[i];
/* 108 */                 tempInt += Integer.parseInt(String.valueOf(temp.charAt(j)));
/*     */               }
/* 110 */               alterDigOdd[i] = "";
/* 111 */               alterDigOdd[i] = String.valueOf(tempInt);
/*     */             }
/* 113 */             System.out.println("alterDigOdd after Add double" + alterDigOdd[i].toString());
/*     */           }
/*     */         }
/* 116 */         for (int i = alterDigOdd.length - 1; i >= 0; i--) {
/* 117 */           System.out.println("alterDigOdd\u6570\u7EC4\u7684\u5143\u7D20 after Add double [" + i + "]" + alterDigOdd[i]);
/*     */         }
/*     */ 
/* 121 */         int allDig = 0;
/* 122 */         for (int i = 0; i < alterDigOdd.length; i++) {
/* 123 */           if (i == 0) {
/* 124 */             allDig += Integer.parseInt(alterDigOdd[i]);
/* 125 */             System.out.println("alterDigOdd[" + i + "]" + alterDigOdd[i].toString());
/*     */           }
/* 127 */           if (i == 1) {
/* 128 */             allDig += Integer.parseInt(alterDigEven[i]);
/* 129 */             System.out.println("alterDigEven[" + i + "]" + alterDigEven[i].toString());
/*     */           }
/* 131 */           if ((i > 1) && (i % 2 == 1)) {
/* 132 */             allDig += Integer.parseInt(alterDigEven[i]);
/* 133 */             System.out.println("alterDigEven[" + i + "]" + alterDigEven[i].toString());
/*     */           }
/* 135 */           if ((i > 1) && (i % 2 == 0)) {
/* 136 */             allDig += Integer.parseInt(alterDigOdd[i]);
/* 137 */             System.out.println("alterDigOdd[" + i + "]" + alterDigOdd[i].toString());
/*     */           }
/*     */         }
/*     */ 
/* 141 */         System.out.println("allDig" + String.valueOf(allDig));
/*     */ 
/* 143 */         int lastDig = 0;
/* 144 */         String allDigString = String.valueOf(allDig);
/* 145 */         if (allDig != 0) {
/* 146 */           lastDig = Integer.parseInt(allDigString.substring(allDigString.length() - 1, allDigString.length()));
/*     */         }
/* 148 */         System.out.println("lastDig" + String.valueOf(lastDig));
/*     */ 
/* 150 */         int checkDig = 0;
/* 151 */         checkDig = 9 - lastDig;
/* 152 */         finalDigit = originalDigit + String.valueOf(checkDig);
/* 153 */         System.out.println("finalDigit" + finalDigit);
/*     */       }
/* 155 */       return finalDigit;
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 159 */       ex.printStackTrace();
/* 160 */     }return null;
/*     */   }
/*     */ 
/*     */   public static String CreateMaxNo(String cNoType, String cNoLimit, VData tVData)
/*     */   {
/*     */     try
/*     */     {
/* 172 */       System.out.println("sysmaxnotype:METLIFE");
/*     */ 
/* 174 */       String className = "com.sinosoft.map.lis.pubfun.SysMaxNoMETLIFE";
/*     */ 
/* 176 */       Class cc = Class.forName(className);
/* 177 */       SysMaxNo tSysMaxNo = 
/* 179 */         (SysMaxNo)cc.newInstance();
/* 180 */       return tSysMaxNo.CreateMaxNo(cNoType, cNoLimit);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 184 */       ex.printStackTrace();
/* 185 */     }return null;
/*     */   }
/*     */ 
/*     */   public static String CreateMaxNo(String cNoType, int cNoLength)
/*     */   {
/*     */     try
/*     */     {
/* 195 */       String className = "com.sinosoft.map.lis.pubfun.SysMaxNoMETLIFE";
/*     */ 
/* 197 */       Class cc = Class.forName(className);
/* 198 */       SysMaxNo tSysMaxNo = 
/* 200 */         (SysMaxNo)cc.newInstance();
/* 201 */       System.out.println(className);
/* 202 */       return tSysMaxNo.CreateMaxNo(cNoType, cNoLength);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 206 */       ex.printStackTrace();
/* 207 */     }return null;
/*     */   }
/*     */ 
/*     */   public static String[] calFLDate(String tDate)
/*     */   {
/* 215 */     String[] MonDate = new String[2];
/* 216 */     String asql = 
/* 217 */       "select startdate,enddate from LAStatSegment where stattype='5' and startdate<='" + 
/* 218 */       tDate + "' and enddate>='" + tDate + "'";
/* 219 */     ExeSQL aExeSQL = new ExeSQL();
/* 220 */     SSRS aSSRS = new SSRS();
/* 221 */     aSSRS = aExeSQL.execSQL(asql);
/* 222 */     MonDate[0] = aSSRS.GetText(1, 1);
/* 223 */     MonDate[1] = aSSRS.GetText(1, 2);
/*     */ 
/* 225 */     return MonDate;
/*     */   }
/*     */ 
/*     */   public static String CreateBranchAttr(String tUpAttr, int tLength)
/*     */   {
/* 233 */     ExeSQL tExeSql = new ExeSQL();
/*     */ 
/* 235 */     String aNewAttr = "";
/*     */ 
/* 237 */     String tSQL = 
/* 238 */       "select max(branchattr) from labranchgroup where trim(branchattr) like '" + 
/* 239 */       tUpAttr.trim() + "%' and (trim(state) <> '1' or state is null)" + 
/* 240 */       " and branchtype = '1' and length(trim(branchattr)) = " + 
/* 241 */       tLength;
/*     */ 
/* 243 */     aNewAttr = tExeSql.getOneValue(tSQL);
/* 244 */     System.out.println("---maximum = " + aNewAttr);
/*     */ 
/* 246 */     BigInteger tInt = null;
/* 247 */     BigInteger tAdd = null;
/*     */     try
/*     */     {
/* 251 */       tInt = new BigInteger(aNewAttr.trim());
/* 252 */       tAdd = new BigInteger("1");
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 256 */       ex.printStackTrace();
/*     */ 
/* 258 */       return "";
/*     */     }
/*     */ 
/* 261 */     tInt = tInt.add(tAdd);
/*     */ 
/* 263 */     aNewAttr = tInt.toString();
/* 264 */     System.out.println("---aNewAttr = " + aNewAttr);
/*     */ 
/* 266 */     return aNewAttr;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.PubFun1
 * JD-Core Version:    0.6.0
 */