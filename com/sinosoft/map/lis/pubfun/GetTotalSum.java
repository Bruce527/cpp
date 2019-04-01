/*    */ package com.sinosoft.map.lis.pubfun;
/*    */ 
/*    */ import com.sinosoft.map.utility.ExeSQL;
/*    */ import com.sinosoft.map.utility.SSRS;
/*    */ 
/*    */ public class GetTotalSum
/*    */ {
/*    */   public String getTotalPay(String serialno)
/*    */   {
/* 13 */     ExeSQL exeSql = new ExeSQL();
/* 14 */     SSRS testSSRS = new SSRS();
/*    */ 
/* 16 */     String sql = 
/* 17 */       "select Totalmoney, Totalnum from lybanklog where SerialNo = " + 
/* 18 */       serialno;
/* 19 */     testSSRS = exeSql.execSQL(sql);
/* 20 */     return testSSRS.GetText(0, 0);
/*    */   }
/*    */ 
/*    */   public String getTotalPic(String serialno)
/*    */   {
/* 25 */     ExeSQL exeSql = new ExeSQL();
/* 26 */     SSRS testSSRS = new SSRS();
/*    */ 
/* 28 */     String sql = 
/* 29 */       "select Totalmoney, Totalnum from lybanklog where SerialNo = " + 
/* 30 */       serialno;
/* 31 */     testSSRS = exeSql.execSQL(sql);
/*    */ 
/* 33 */     return testSSRS.GetText(0, 1);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.GetTotalSum
 * JD-Core Version:    0.6.0
 */