/*    */ package com.sinosoft.map.utility;
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
/* 25 */     this.myVector.addElement(temparray);
/*    */   }
/*    */ 
/*    */   public String getValue(int column, int row)
/*    */   {
/* 32 */     String[] temparray = new String[column];
/* 33 */     temparray = (String[])this.myVector.get(row);
/* 34 */     return temparray[column];
/*    */   }
/*    */ 
/*    */   public String[] get(int i)
/*    */   {
/* 40 */     return (String[])this.myVector.get(i);
/*    */   }
/*    */ 
/*    */   public int size()
/*    */   {
/* 46 */     return this.myVector.size();
/*    */   }
/*    */ 
/*    */   public void setName(String name)
/*    */   {
/* 51 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 56 */     return this.name;
/*    */   }
/*    */ 
/*    */   public int getCol()
/*    */   {
/* 62 */     return this.col;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.ListTable
 * JD-Core Version:    0.6.0
 */