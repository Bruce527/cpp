/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ 
/*    */ public class DateConvert
/*    */ {
/*    */   public static java.sql.Date utilDateToSql(java.util.Date utilDate)
/*    */   {
/* 13 */     return new java.sql.Date(utilDate.getTime());
/*    */   }
/*    */   public static java.util.Date sqlDateToUtil(java.sql.Date sqlDate) {
/* 16 */     return sqlDate;
/*    */   }
/*    */   public static String dateToStr(java.util.Date utilDate) {
/* 19 */     String pattern = "yyyy-MM-dd";
/* 20 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/* 21 */     String returnDate = df.format(utilDate);
/* 22 */     return returnDate;
/*    */   }
/*    */   public static String StrToStr(String utilDate) {
/* 25 */     if (utilDate != null) {
/* 26 */       utilDate = utilDate.substring(0, 10);
/*    */     }
/* 28 */     String returnDate = utilDate;
/* 29 */     return returnDate;
/*    */   }
/*    */   public static java.util.Date strToDate(String dateStr) {
/* 32 */     java.util.Date date = null;
/* 33 */     String pattern = "yyyy-MM-dd";
/* 34 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/*    */     try {
/* 36 */       date = df.parse(dateStr);
/*    */     } catch (ParseException e) {
/* 38 */       e.printStackTrace();
/* 39 */       throw new RuntimeException("\u951F\u8857\u51E4\u62F7" + dateStr + "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E3A\u951F\u65A4\u62F7\u951F\u8282\u8FBE\u62F7\u951F\u65A4\u62F7", e);
/*    */     }
/* 41 */     return date;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.DateConvert
 * JD-Core Version:    0.6.0
 */