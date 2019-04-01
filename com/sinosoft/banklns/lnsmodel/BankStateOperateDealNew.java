/*    */ package com.sinosoft.banklns.lnsmodel;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class BankStateOperateDealNew extends BankStateOperateDeal
/*    */   implements BankStateOperateDealIface
/*    */ {
/*    */   public boolean checkEditOperate(String state, String sheetType, String userType, String contNo)
/*    */   {
/* 12 */     boolean flag = false;
/* 13 */     flag = super.checkEditOperate(state, "", sheetType, userType, contNo);
/* 14 */     return flag;
/*    */   }
/*    */ 
/*    */   public boolean checkButtonOperate(String state, String editState, int buttonType, String userType, String contNo)
/*    */   {
/* 20 */     boolean flag = false;
/* 21 */     if (contNo != null) {
/* 22 */       System.out.println("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0172\uFFFD\u03AA\uFFFD\uFFFD~\u02B2\u00F4\uFFFD\uFFFD\u00FB\uFFFD\uFFFD");
/*    */     } else {
/* 24 */       boolean tempFlag = false;
/* 25 */       if (("0".equals(userType)) && (buttonType == 1))
/* 26 */         tempFlag = true;
/* 27 */       else if (("1".equals(userType)) && (buttonType != 1))
/* 28 */         tempFlag = true;
/* 29 */       else if ("2".equals(userType)) {
/* 30 */         tempFlag = true;
/*    */       }
/* 32 */       flag = (super.checkOperate(state, editState, buttonType)) && (tempFlag);
/*    */     }
/* 34 */     return flag;
/*    */   }
/*    */ 
/*    */   public List<String> infoOprate(String state, String editState, String operateType, String infoType)
/*    */   {
/* 40 */     return super.infoOprate(state, editState, operateType, infoType);
/*    */   }
/*    */ 
/*    */   public String updateEditStateDone(String editstate, int index)
/*    */   {
/* 45 */     return super.updateEditStateDone(editstate, index);
/*    */   }
/*    */ 
/*    */   public String updateEditStateUNDone(String editstate, int index) {
/* 49 */     return super.updateEditStateUNDone(editstate, index);
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 53 */     BankStateOperateDeal detal = new BankStateOperateDealNew();
/* 54 */     String[] editStateArry = { "1", "1", "1", "1", "1", "1", "1", "1", "x", "1", "0" };
/* 55 */     String state = "05";
/* 56 */     List list = detal.modifySateByEditState(state, editStateArry);
/* 57 */     System.out.println((String)list.get(0));
/* 58 */     editStateArry = (String[])list.get(1);
/* 59 */     for (int i = 0; i < editStateArry.length; i++) {
/* 60 */       System.out.print(editStateArry[i] + "|");
/*    */     }
/*    */ 
/* 63 */     boolean flag = Pattern.matches("^[1]{4}\\d{3}[^1]{1}\\d{2}$", "1111000000");
/* 64 */     System.out.println(flag);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BankStateOperateDealNew
 * JD-Core Version:    0.6.0
 */