/*    */ package com.sinosoft.map.lis.excel;
/*    */ 
/*    */ class ExcelException extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = -415720489952215657L;
/*    */ 
/*    */   public ExcelException(Exception e)
/*    */   {
/*  9 */     super(e.getMessage());
/*    */   }
/*    */   public ExcelException(String message) {
/* 12 */     super(message);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.excel.ExcelException
 * JD-Core Version:    0.6.0
 */