/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class TransferData
/*     */ {
/*  10 */   private Vector nameVData = new Vector();
/*  11 */   private Vector valueVData = new Vector();
/*     */ 
/*     */   public static void main(String[] args) {
/*  14 */     TransferData transferData1 = new TransferData();
/*  15 */     System.out.println(transferData1.size());
/*     */ 
/*  17 */     transferData1.setNameAndValue("int", 200);
/*  18 */     Integer value = (Integer)transferData1.getValueByName("int");
/*  19 */     System.out.println("value:" + value);
/*  20 */     System.out.println(transferData1.size());
/*  21 */     TransferData test1 = transferData1;
/*  22 */     Integer value2 = (Integer)transferData1.getValueByIndex(1);
/*  23 */     System.out.println("value2:" + value2);
/*     */   }
/*     */ 
/*     */   public void setNameAndValue(Object name, Object value)
/*     */   {
/*  28 */     int index = getIndexByName(name);
/*  29 */     if (index >= 0) {
/*  30 */       this.valueVData.remove(index);
/*  31 */       this.valueVData.insertElementAt(value, index);
/*     */     } else {
/*  33 */       this.nameVData.add(name);
/*  34 */       this.valueVData.add(value);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setNameAndValue(Object name, float value)
/*     */   {
/*  40 */     setNameAndValue(name, new Float(value));
/*     */   }
/*     */ 
/*     */   public void setNameAndValue(Object name, double value)
/*     */   {
/*  45 */     setNameAndValue(name, new Double(value));
/*     */   }
/*     */ 
/*     */   public void setNameAndValue(Object name, int value)
/*     */   {
/*  50 */     setNameAndValue(name, new Integer(value));
/*     */   }
/*     */ 
/*     */   public Object getValueByName(Object name)
/*     */   {
/*  61 */     int index = getIndexByName(name);
/*  62 */     if (index < 0) {
/*  63 */       return null;
/*     */     }
/*  65 */     return this.valueVData.get(index);
/*     */   }
/*     */ 
/*     */   public Object getNameByIndex(int index)
/*     */   {
/*  71 */     if (index == 0) {
/*  72 */       return null;
/*     */     }
/*  74 */     if (index <= this.nameVData.size()) {
/*  75 */       return this.nameVData.get(index - 1);
/*     */     }
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */   public Object getValueByIndex(int index)
/*     */   {
/*  82 */     if (index == 0) {
/*  83 */       return null;
/*     */     }
/*  85 */     if (index <= this.valueVData.size()) {
/*  86 */       return this.valueVData.get(index - 1);
/*     */     }
/*  88 */     return null;
/*     */   }
/*     */ 
/*     */   public int size()
/*     */   {
/*  93 */     return this.valueVData.size();
/*     */   }
/*     */ 
/*     */   public boolean removeValueByIndex(int index)
/*     */   {
/*  98 */     if ((this.nameVData.size() < index) || (index == 0)) {
/*  99 */       System.out.println("\u951F\u72E1\u7B79\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7686\u65A4\u62F7\u7EBE\uFFFD");
/* 100 */       return false;
/*     */     }
/* 102 */     this.nameVData.remove(index);
/* 103 */     this.valueVData.remove(index);
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean removeValueByName(String name)
/*     */   {
/* 118 */     int index = getIndexByName(name);
/* 119 */     if (index < 0) {
/* 120 */       return false;
/*     */     }
/* 122 */     this.nameVData.remove(index);
/* 123 */     this.valueVData.remove(index);
/* 124 */     return true;
/*     */   }
/*     */ 
/*     */   private int getIndexByName(Object name) {
/* 128 */     for (int i = 0; i < this.nameVData.size(); i++) {
/* 129 */       if (this.nameVData.elementAt(i).equals(name)) {
/* 130 */         return i;
/*     */       }
/*     */     }
/* 133 */     return -1;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.TransferData
 * JD-Core Version:    0.6.0
 */