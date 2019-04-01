/*    */ package com.sinosoft.map.user;
/*    */ 
/*    */ import com.sinosoft.map.utility.DBConn;
/*    */ import com.sinosoft.map.utility.DBConnPool;
/*    */ import com.sinosoft.map.utility.ExeSQL;
/*    */ import com.sinosoft.map.utility.SSRS;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class TestDataSource
/*    */ {
/*    */   public TestDataSource()
/*    */   {
/* 11 */     System.out.println("Start------------------------DataSource TestClass------------------------");
/*    */ 
/* 13 */     DBConn con = DBConnPool.getConnection();
/* 14 */     ExeSQL execSQL = new ExeSQL(con);
/* 15 */     String sql = "select varvalue from msysvar where vartype='loginbranchtype'";
/* 16 */     SSRS ssrs = execSQL.execSQL(sql);
/* 17 */     for (int i = 1; i < ssrs.MaxRow; i++) {
/* 18 */       System.out.println(ssrs.GetText(i, 1));
/*    */     }
/*    */ 
/* 21 */     System.out.println("End------------------------DataSource TestClass------------------------");
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 25 */     new TestDataSource();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.user.TestDataSource
 * JD-Core Version:    0.6.0
 */