/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class TextTag
/*    */ {
/* 11 */   private Vector myVector = new Vector();
/*    */ 
/*    */   public Vector add(String name, String value)
/*    */   {
/* 19 */     if (value != null)
/*    */     {
/* 21 */       String[] temparray = { name, value };
/* 22 */       this.myVector.addElement(temparray);
/* 23 */       return this.myVector;
/*    */     }
/*    */ 
/* 27 */     String[] temparray = { name, " " };
/* 28 */     this.myVector.addElement(temparray);
/* 29 */     return this.myVector;
/*    */   }
/*    */ 
/*    */   public Vector add(String name, int value)
/*    */   {
/* 35 */     Integer ivalue = new Integer(value);
/* 36 */     String svalue = ivalue.toString();
/* 37 */     String[] temparray = { name, svalue };
/* 38 */     this.myVector.addElement(temparray);
/* 39 */     return this.myVector;
/*    */   }
/*    */ 
/*    */   public Vector add(String name, long value)
/*    */   {
/* 45 */     Long ivalue = new Long(value);
/* 46 */     String svalue = ivalue.toString();
/* 47 */     String[] temparray = { name, svalue };
/* 48 */     this.myVector.addElement(temparray);
/* 49 */     return this.myVector;
/*    */   }
/*    */ 
/*    */   public Vector add(String name, float value)
/*    */   {
/* 55 */     Float fvalue = new Float(value);
/* 56 */     String svalue = fvalue.toString();
/* 57 */     String[] temparray = { name, svalue };
/* 58 */     this.myVector.addElement(temparray);
/* 59 */     return this.myVector;
/*    */   }
/*    */ 
/*    */   public Vector add(String name, double value)
/*    */   {
/* 64 */     Double fvalue = new Double(value);
/* 65 */     String svalue = fvalue.toString();
/* 66 */     String[] temparray = { name, svalue };
/* 67 */     this.myVector.addElement(temparray);
/* 68 */     return this.myVector;
/*    */   }
/*    */ 
/*    */   public Object get(int i)
/*    */   {
/* 75 */     return this.myVector.get(i);
/*    */   }
/*    */ 
/*    */   public int size()
/*    */   {
/* 81 */     return this.myVector.size();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.TextTag
 * JD-Core Version:    0.6.0
 */