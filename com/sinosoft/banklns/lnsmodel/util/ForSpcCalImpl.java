/*    */ package com.sinosoft.banklns.lnsmodel.util;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ 
/*    */ public class ForSpcCalImpl
/*    */   implements ForSpcCalIntf
/*    */ {
/*    */   public String handlerPTVForCBRA(String mainRiskCode, int payIntv)
/*    */   {
/* 11 */     HashSet hs = new HashSet();
/* 12 */     hs.add("ULES");
/* 13 */     hs.add("ULDX");
/* 14 */     if (hs.contains(mainRiskCode)) {
/* 15 */       return "12";
/*    */     }
/*    */ 
/* 18 */     return payIntv;
/*    */   }
/*    */ 
/*    */   public String handlerPTVForTLR(String mainRiskCode, int payIntv) {
/* 22 */     HashSet hs = new HashSet();
/* 23 */     hs.add("ULES");
/* 24 */     hs.add("ULDX");
/* 25 */     if (hs.contains(mainRiskCode)) {
/* 26 */       return "12";
/*    */     }
/*    */ 
/* 29 */     return payIntv;
/*    */   }
/*    */ 
/*    */   public String handlerPYForADR(String mainRiskCode, int payEndYear) {
/* 33 */     HashSet hs = new HashSet();
/* 34 */     hs.add("NWA");
/* 35 */     if (hs.contains(mainRiskCode)) {
/* 36 */       return payEndYear;
/*    */     }
/* 38 */     return null;
/*    */   }
/*    */ 
/*    */   public String handlerPYFForADR(String mainRiskCode, String payEndYearFlag) {
/* 42 */     HashSet hs = new HashSet();
/* 43 */     hs.add("NWA");
/* 44 */     if (hs.contains(mainRiskCode)) {
/* 45 */       return payEndYearFlag;
/*    */     }
/* 47 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.util.ForSpcCalImpl
 * JD-Core Version:    0.6.0
 */