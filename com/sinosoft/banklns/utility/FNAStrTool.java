/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ public class FNAStrTool extends StrTool
/*    */ {
/*    */   public static String toHTMLFormat(String strInValue)
/*    */   {
/* 27 */     String strOutValue = "";
/*    */ 
/* 30 */     for (int i = 0; i < strInValue.length(); i++)
/*    */     {
/* 32 */       char c = strInValue.charAt(i);
/* 33 */       switch (c)
/*    */       {
/*    */       case '\n':
/* 37 */         strOutValue = strOutValue + "<BR>";
/* 38 */         break;
/*    */       case '\r':
/* 40 */         break;
/*    */       case ' ':
/* 42 */         strOutValue = strOutValue + "&nbsp;";
/* 43 */         break;
/*    */       default:
/* 45 */         strOutValue = strOutValue + c;
/*    */       }
/*    */     }
/*    */ 
/* 49 */     return strOutValue;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.FNAStrTool
 * JD-Core Version:    0.6.0
 */