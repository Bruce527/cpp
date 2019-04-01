/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ public class Pool
/*    */ {
/*  7 */   private static ThreadPool tThreadPool = new ThreadPool();
/*    */ 
/*    */   public static ThreadPool getThreadPool()
/*    */   {
/* 14 */     return tThreadPool;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 18 */     Pool pool1 = new Pool();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.Pool
 * JD-Core Version:    0.6.0
 */