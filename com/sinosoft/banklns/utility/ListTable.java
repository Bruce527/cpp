/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class ListTable
/*    */ {
/* 11 */   private Vector myVector = new Vector();
/*    */   private int col;
/*    */   private String name;
/*    */ 
/*    */   public void add(String[] temparray)
/*    */   {
/* 27 */     this.myVector.addElement(temparray);
/*    */   }
/*    */ 
/*    */   public String getValue(int column, int row)
/*    */   {
/* 34 */     String[] temparray = new String[column];
/* 35 */     temparray = (String[])this.myVector.get(row);
/* 36 */     return temparray[column];
/*    */   }
/*    */ 
/*    */   public String[] get(int i)
/*    */   {
/* 42 */     return (String[])this.myVector.get(i);
/*    */   }
/*    */ 
/*    */   public int size()
/*    */   {
/* 47 */     return this.myVector.size();
/*    */   }
/*    */ 
/*    */   public void setName(String name)
/*    */   {
/* 52 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 57 */     return this.name;
/*    */   }
/*    */ 
/*    */   public int getCol()
/*    */   {
/* 63 */     return this.col;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.ListTable
 * JD-Core Version:    0.6.0
 */