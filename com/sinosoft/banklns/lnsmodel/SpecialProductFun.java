/*    */ package com.sinosoft.banklns.lnsmodel;
/*    */ 
/*    */ import com.sinosoft.banklns.utility.ExeSQL;
/*    */ import com.sinosoft.banklns.utility.SSRS;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Hashtable;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class SpecialProductFun
/*    */ {
/*    */   public static final int PERIOD_106 = 106;
/* 18 */   public static Map<String, Integer> ProductRiskMap = new Hashtable();
/*    */ 
/*    */   static {
/* 21 */     initProductRisk();
/*    */   }
/*    */ 
/*    */   private static void initProductRisk() {
/*    */     try {
/* 26 */       ProductRiskMap.clear();
/*    */ 
/* 56 */       ExeSQL execSQL = new ExeSQL();
/* 57 */       String sql = "select code,codename from LNPCode where CodeType='BankSpecialRiskCode'";
/* 58 */       SSRS ssrs = execSQL.execSQL(sql);
/* 59 */       if (ssrs.MaxRow > 0) {
/* 60 */         for (int i = 1; i <= ssrs.MaxRow; i++) {
/* 61 */           ProductRiskMap.put(ssrs.GetText(i, 1), Integer.valueOf(Integer.parseInt(ssrs.GetText(i, 2))));
/* 62 */           System.out.println("i+riskcode==================" + ssrs.GetText(i, 1) + "-----------" + Integer.parseInt(ssrs.GetText(i, 2)));
/*    */         }
/*    */       }
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 68 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public static int getRiskPro(String RiskCode)
/*    */   {
/*    */     try {
/* 75 */       if ((RiskCode != null) && (ProductRiskMap.containsKey(RiskCode.toUpperCase()))) {
/* 76 */         System.out.println("~~~~~~~~current riskcode:" + RiskCode + " will return period:" + ProductRiskMap.get(RiskCode.toUpperCase()) + "/A");
/* 77 */         return ((Integer)ProductRiskMap.get(RiskCode.toUpperCase())).intValue();
/*    */       }
/*    */     } catch (Exception e) {
/* 80 */       e.printStackTrace();
/*    */ 
/* 82 */       System.out.println("~~~~~~~~current riskcode:" + RiskCode + "  will return period:106/A");
/* 83 */     }return 106;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 87 */     String RiskCode = "LA09BA";
/* 88 */     getRiskPro(RiskCode);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.SpecialProductFun
 * JD-Core Version:    0.6.0
 */