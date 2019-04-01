/*    */ package com.sinosoft.banklns.lnsmodel;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class BankValidateDealSubRewImpl
/*    */   implements BankValidateDealIface
/*    */ {
/*  8 */   private List<String> errors = new ArrayList();
/*    */ 
/*    */   public boolean validateByContNo(String contNo)
/*    */   {
/* 12 */     if (this.errors != null)
/* 13 */       this.errors.clear();
/* 14 */     boolean flag = false;
/*    */ 
/* 20 */     return flag;
/*    */   }
/*    */ 
/*    */   public List<String> getErroList()
/*    */   {
/* 25 */     return this.errors;
/*    */   }
/*    */ 
/*    */   public String showErrors() {
/* 29 */     return showFormate1();
/*    */   }
/*    */ 
/*    */   private String showFormate1() {
/* 33 */     String temp = null;
/* 34 */     for (int i = 1; (this.errors != null) && (i <= this.errors.size()); i++) {
/* 35 */       if (i <= 1)
/* 36 */         temp = temp + "\u6821\u9A8C\u672A\u901A\u8FC7\u9879\u5982\u4E0B:\n" + i + "\u3001" + (String)this.errors.get(i) + "\n";
/*    */       else
/* 38 */         temp = temp + i + "\u3001" + (String)this.errors.get(i) + "\n";
/*    */     }
/* 40 */     return temp;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BankValidateDealSubRewImpl
 * JD-Core Version:    0.6.0
 */