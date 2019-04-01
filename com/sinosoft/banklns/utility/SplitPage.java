/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ public class SplitPage
/*    */ {
/*  5 */   int CurrentPage = 1;
/*    */ 
/*  7 */   int Recordscount = 0;
/*    */ 
/*  9 */   int PageCount = 0;
/*    */ 
/*    */   public String[][] splitpage(String[][] src)
/*    */   {
/* 15 */     this.Recordscount = src.length;
/*    */ 
/* 17 */     this.PageCount = ((this.Recordscount - 1) / 10 + 1);
/* 18 */     int start = (this.CurrentPage - 1) * 10 + 1;
/* 19 */     int end = this.CurrentPage * 10;
/* 20 */     if (end >= this.Recordscount) {
/* 21 */       end = this.Recordscount;
/*    */     }
/*    */ 
/* 24 */     String[][] result = new String[end - start + 1][src[0].length];
/* 25 */     for (int i = 0; i < end - start + 1; i++)
/*    */     {
/* 27 */       for (int j = 0; j < src[0].length; j++)
/*    */       {
/* 29 */         result[i][j] = src[(i + start - 1)][j];
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 35 */     return result;
/*    */   }
/*    */   public int getCurrentPage() {
/* 38 */     return this.CurrentPage;
/*    */   }
/*    */ 
/*    */   public void setCurrentPage(int currentPage) {
/* 42 */     this.CurrentPage = currentPage;
/*    */   }
/*    */ 
/*    */   public int getPageCount() {
/* 46 */     return this.PageCount;
/*    */   }
/*    */ 
/*    */   public void setPageCount(int pageCount) {
/* 50 */     this.PageCount = pageCount;
/*    */   }
/*    */ 
/*    */   public int getRecordscount() {
/* 54 */     return this.Recordscount;
/*    */   }
/*    */ 
/*    */   public void setRecordscount(int recordscount) {
/* 58 */     this.Recordscount = recordscount;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.SplitPage
 * JD-Core Version:    0.6.0
 */