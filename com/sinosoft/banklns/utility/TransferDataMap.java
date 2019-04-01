/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import java.util.TreeMap;
/*    */ 
/*    */ public class TransferDataMap<K, V> extends TreeMap<K, V>
/*    */ {
/*    */   public void setNameAndValue(K name, V value)
/*    */   {
/* 16 */     put(name, value);
/*    */   }
/*    */ 
/*    */   public Object getValueByName(Object name)
/*    */   {
/* 22 */     if (name == null) {
/* 23 */       return null;
/*    */     }
/* 25 */     return get(name);
/*    */   }
/*    */ 
/*    */   public Object getNameByIndex(int index) {
/* 29 */     Set set = keySet();
/* 30 */     Iterator iterator = set.iterator();
/* 31 */     int i = 0;
/* 32 */     while (iterator.hasNext()) {
/* 33 */       if (i == index) {
/* 34 */         return iterator.next();
/*    */       }
/* 36 */       iterator.next();
/* 37 */       i++;
/*    */     }
/* 39 */     return null;
/*    */   }
/*    */ 
/*    */   public Object getValueByIndex(int index) {
/* 43 */     Collection collection = values();
/* 44 */     Iterator iterator = collection.iterator();
/* 45 */     int i = 0;
/* 46 */     while (iterator.hasNext()) {
/* 47 */       if (i == index) {
/* 48 */         return iterator.next();
/*    */       }
/* 50 */       iterator.next();
/* 51 */       i++;
/*    */     }
/* 53 */     return null;
/*    */   }
/*    */ 
/*    */   public int size() {
/* 57 */     return super.size();
/*    */   }
/*    */ 
/*    */   public boolean removeValueByIndex(int index) {
/* 61 */     Object objectKey = getNameByIndex(index);
/* 62 */     Object check = remove(objectKey);
/* 63 */     if (check == null) {
/* 64 */       System.out.println("\u951F\u72E1\u7B79\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7686\u65A4\u62F7\u7EBE\uFFFD");
/* 65 */       return false;
/*    */     }
/* 67 */     return true;
/*    */   }
/*    */ 
/*    */   public boolean removeValueByName(K name)
/*    */   {
/* 72 */     Object check = remove(name);
/* 73 */     if (check == null) {
/* 74 */       System.out.println("\u951F\u72E1\u7B79\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7686\u65A4\u62F7\u7EBE\uFFFD");
/* 75 */       return false;
/*    */     }
/* 77 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.TransferDataMap
 * JD-Core Version:    0.6.0
 */