/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ import com.sinosoft.map.style.pdf.TableHeadStyle;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class XmlTable<k>
/*    */ {
/*    */   private List<k> headers;
/*    */   private TableHeadStyle tableHeadStyle;
/*    */ 
/*    */   public XmlTable()
/*    */   {
/* 14 */     this.headers = new LinkedList();
/* 15 */     this.tableHeadStyle = new TableHeadStyle();
/*    */   }
/*    */ 
/*    */   public XmlTable(List<k> headers, TableHeadStyle tableHeadStyle) {
/* 19 */     this.headers = headers;
/* 20 */     this.tableHeadStyle = tableHeadStyle;
/*    */   }
/*    */   public List<k> getHeaders() {
/* 23 */     return this.headers;
/*    */   }
/*    */   public void setHeaders(List<k> headers) {
/* 26 */     this.headers = headers;
/*    */   }
/*    */   public TableHeadStyle getTableHeadStyle() {
/* 29 */     return this.tableHeadStyle;
/*    */   }
/*    */   public void setTableHeadStyle(TableHeadStyle tableHeadStyle) {
/* 32 */     this.tableHeadStyle = tableHeadStyle;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.XmlTable
 * JD-Core Version:    0.6.0
 */