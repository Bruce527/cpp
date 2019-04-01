/*    */ package com.ibm.filenet.api.ce.search;
/*    */ 
/*    */ import com.filenet.api.core.Document;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Pagination
/*    */ {
/*    */   private int currentPageIndex;
/*    */   private int pageSize;
/*    */   private int totalNum;
/*    */   private List<Document> docs;
/*    */   private boolean isFirst;
/*    */   private boolean isLast;
/*    */   private int totalPages;
/*    */   private int pageCount;
/*    */ 
/*    */   public Pagination(List<Document> docs, int pageSize, int currentPageIndex, int totalNum)
/*    */   {
/* 21 */     this.pageSize = pageSize;
/* 22 */     this.currentPageIndex = currentPageIndex;
/* 23 */     this.isFirst = (currentPageIndex == 1);
/* 24 */     this.isLast = (currentPageIndex * pageSize >= totalNum);
/* 25 */     this.pageCount = (docs == null ? 0 : docs.size());
/* 26 */     this.docs = docs;
/* 27 */     this.totalPages = (totalNum / pageSize + (totalNum % pageSize == 0 ? 0 : 1));
/* 28 */     this.totalNum = totalNum;
/*    */   }
/*    */ 
/*    */   public int getPageSize() {
/* 32 */     return this.pageSize;
/*    */   }
/*    */ 
/*    */   public void setPageSize(int pageSize) {
/* 36 */     this.pageSize = pageSize;
/*    */   }
/*    */ 
/*    */   public int getCurrentPageIndex() {
/* 40 */     return this.currentPageIndex;
/*    */   }
/*    */ 
/*    */   public void setCurrentPageIndex(int currentPageIndex) {
/* 44 */     this.currentPageIndex = currentPageIndex;
/*    */   }
/*    */ 
/*    */   public boolean isFirst() {
/* 48 */     return this.isFirst;
/*    */   }
/*    */ 
/*    */   public void setFirst(boolean isFirst) {
/* 52 */     this.isFirst = isFirst;
/*    */   }
/*    */ 
/*    */   public boolean isLast() {
/* 56 */     return this.isLast;
/*    */   }
/*    */ 
/*    */   public void setLast(boolean isLast) {
/* 60 */     this.isLast = isLast;
/*    */   }
/*    */ 
/*    */   public int getPageCount() {
/* 64 */     return this.pageCount;
/*    */   }
/*    */ 
/*    */   public void setPageCount(int pageCount) {
/* 68 */     this.pageCount = pageCount;
/*    */   }
/*    */ 
/*    */   public List<Document> getItems() {
/* 72 */     return this.docs;
/*    */   }
/*    */ 
/*    */   public void setItems(List<Document> items) {
/* 76 */     this.docs = items;
/*    */   }
/*    */ 
/*    */   public int getTotalPages() {
/* 80 */     return this.totalPages;
/*    */   }
/*    */ 
/*    */   public void setTotalPages(int totalPages) {
/* 84 */     this.totalPages = totalPages;
/*    */   }
/*    */ 
/*    */   public int getTotalNum() {
/* 88 */     return this.totalNum;
/*    */   }
/*    */ 
/*    */   public void setTotalNum(int totalNum) {
/* 92 */     this.totalNum = totalNum;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.api.ce.search.Pagination
 * JD-Core Version:    0.6.0
 */