/*    */ package com.sinosoft.banklns.lis.pubfun;
/*    */ 
/*    */ import com.sinosoft.banklns.utility.ExeSQL;
/*    */ import com.sinosoft.banklns.utility.SSRS;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class LNPPubFun
/*    */ {
/*    */   public static String getSysInfo(String string)
/*    */   {
/* 13 */     ExeSQL exeSQL = new ExeSQL();
/* 14 */     String sql = "select sysvarvalue from lnpsysvar where sysvar = '" + 
/* 15 */       string + "'";
/* 16 */     SSRS ssrs = exeSQL.execSQL(sql);
/*    */ 
/* 18 */     if (ssrs.MaxRow > 0) {
/* 19 */       String reString = ssrs.GetText(1, 1);
/* 20 */       return reString;
/*    */     }
/*    */ 
/* 23 */     return null;
/*    */   }
/*    */   public static void main(String[] args) {
/* 26 */     LNPPubFun q = new LNPPubFun();
/*    */ 
/* 28 */     System.out.println(Integer.parseInt("20120102  ".trim()) > Integer.parseInt("20120101".trim()));
/*    */   }
/*    */ 
/*    */   public static String getAgeByBirthdayNew(String strBirthday, String strApplyDay)
/*    */   {
/* 33 */     String returnAge = "-1";
/* 34 */     String[] arrBirthday = strBirthday.split("-");
/* 35 */     String[] arrApplyday = strApplyDay.split("-");
/*    */ 
/* 37 */     int age = Integer.parseInt(arrApplyday[0]) - 
/* 38 */       Integer.parseInt(arrBirthday[0]) - 1;
/* 39 */     if (Integer.parseInt(arrApplyday[1]) > Integer.parseInt(arrBirthday[1])) {
/* 40 */       age++;
/*    */     }
/* 42 */     else if (Integer.parseInt(arrApplyday[1]) >= 
/* 42 */       Integer.parseInt(arrBirthday[1]))
/*    */     {
/* 45 */       if (Integer.parseInt(arrApplyday[2]) >= 
/* 45 */         Integer.parseInt(arrBirthday[2]))
/* 46 */         age++;
/*    */     }
/* 48 */     if (age >= 0) {
/* 49 */       if (age == 0) {
/* 50 */         returnAge = PubFun.calInterval(strBirthday, strApplyDay, "D") + 
/* 51 */           "\uFF08\u5929\uFF09";
/*    */       }
/*    */       else {
/* 54 */         returnAge = age + "\uFF08\u5468\u5C81\uFF09";
/*    */       }
/*    */     }
/* 57 */     return returnAge;
/*    */   }
/*    */ 
/*    */   public static String[] getAppAge(String strBirthday, String strApplyDay)
/*    */   {
/* 62 */     String[] str = new String[2];
/* 63 */     int returnAge = 0;
/*    */ 
/* 65 */     returnAge = PubFun.calInterval(strBirthday, strApplyDay, "Y");
/*    */ 
/* 67 */     if (returnAge > 0)
/*    */     {
/* 69 */       str[0] = "Y";
/* 70 */       str[1] = String.valueOf(returnAge);
/* 71 */       return str;
/*    */     }
/* 73 */     if (returnAge == 0)
/*    */     {
/* 75 */       returnAge = PubFun.calInterval(strBirthday, strApplyDay, "D");
/* 76 */       if (returnAge < 0)
/*    */       {
/* 78 */         return null;
/*    */       }
/*    */ 
/* 82 */       str[0] = "D";
/* 83 */       str[1] = String.valueOf(returnAge);
/* 84 */       return str;
/*    */     }
/*    */ 
/* 89 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.LNPPubFun
 * JD-Core Version:    0.6.0
 */