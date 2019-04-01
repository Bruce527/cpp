/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class TransferData
/*    */ {
/* 17 */   private Vector nameVData = new Vector();
/* 18 */   private Vector valueVData = new Vector();
/*    */ 
/*    */   public void setNameAndValue(Object name, Object value)
/*    */   {
/* 23 */     this.nameVData.add(name);
/* 24 */     this.valueVData.add(value);
/*    */   }
/*    */ 
/*    */   public void setNameAndValue(Object name, float value)
/*    */   {
/* 30 */     this.nameVData.add(name);
/* 31 */     this.valueVData.add(new Float(value));
/*    */   }
/*    */ 
/*    */   public void setNameAndValue(Object name, double value)
/*    */   {
/* 37 */     this.nameVData.add(name);
/* 38 */     this.valueVData.add(new Double(value));
/*    */   }
/*    */ 
/*    */   public void setNameAndValue(Object name, int value)
/*    */   {
/* 44 */     this.nameVData.add(name);
/* 45 */     this.valueVData.add(new Integer(value));
/*    */   }
/*    */ 
/*    */   public Object getValueByName(Object name)
/*    */   {
/* 51 */     for (int i = 0; i < this.nameVData.size(); i++)
/*    */     {
/* 53 */       if (this.nameVData.elementAt(i).equals(name))
/*    */       {
/* 55 */         return this.valueVData.get(i);
/*    */       }
/*    */     }
/* 58 */     return null;
/*    */   }
/*    */ 
/*    */   public int findIndexByName(Object name)
/*    */   {
/* 64 */     for (int i = 0; i < this.nameVData.size(); i++)
/*    */     {
/* 66 */       if (this.nameVData.elementAt(i).equals(name))
/*    */       {
/* 68 */         return i;
/*    */       }
/*    */     }
/* 71 */     return -1;
/*    */   }
/*    */ 
/*    */   public boolean removeByName(Object name)
/*    */   {
/* 77 */     for (int i = 0; i < this.nameVData.size(); i++)
/*    */     {
/* 79 */       if (!this.nameVData.elementAt(i).equals(name))
/*    */         continue;
/* 81 */       this.valueVData.remove(i);
/* 82 */       this.nameVData.remove(i);
/*    */     }
/*    */ 
/* 85 */     return true;
/*    */   }
/*    */ 
/*    */   public Vector getValueNames()
/*    */   {
/* 91 */     return this.nameVData;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.TransferData
 * JD-Core Version:    0.6.0
 */