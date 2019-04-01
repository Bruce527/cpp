/*    */ package com.sinosoft;
/*    */ 
/*    */ public class OperTest
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*  5 */     OperTest test = new OperTest();
/*  6 */     test.tset01();
/*    */   }
/*    */ 
/*    */   private void tset01() {
/* 10 */     String[] arg1 = { "A", "E", "D", "C", "B" };
/* 11 */     String[] find1 = { "C", "B" };
/* 12 */     String[] find2 = { "C", "E" };
/* 13 */     for (int i = 0; i < arg1.length; i++) {
/* 14 */       boolean flag = false;
/* 15 */       for (int j = 0; j < find1.length; j++) {
/* 16 */         if (find1[j].equals(arg1[i])) {
/* 17 */           flag = true;
/* 18 */           break;
/*    */         }
/*    */       }
/* 21 */       if (!flag)
/* 22 */         for (int k = 0; k < find2.length; k++)
/* 23 */           if (find2[k].equals(arg1[i])) {
/* 24 */             flag = true;
/* 25 */             break;
/*    */           }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.OperTest
 * JD-Core Version:    0.6.0
 */