/*    */ package com.sinosoft.banklns.lis.pubfun;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class MMap
/*    */ {
/*  9 */   private HashMap mapV = null;
/*    */ 
/* 12 */   private HashMap mapO = null;
/*    */ 
/* 14 */   public MMap() { this.mapV = new HashMap();
/* 15 */     this.mapO = new HashMap(); }
/*    */ 
/*    */   public void put(Object key, Object value)
/*    */   {
/* 19 */     if ((key == null) || (value == null)) return;
/* 20 */     this.mapV.put(key, value);
/* 21 */     this.mapO.put(String.valueOf(this.mapV.size()), key);
/*    */   }
/*    */   public Set keySet() {
/* 24 */     return this.mapV.keySet();
/*    */   }
/*    */ 
/*    */   public Object get(Object key) {
/* 28 */     return this.mapV.get(key);
/*    */   }
/*    */ 
/*    */   public HashMap getOrder() {
/* 32 */     return this.mapO;
/*    */   }
/*    */ 
/*    */   public Object getKeyByOrder(String order) {
/* 36 */     return this.mapO.get(order);
/*    */   }
/*    */   public void add(MMap srcMap) {
/* 39 */     if (srcMap == null) return;
/* 40 */     for (int i = 0; i < srcMap.keySet().size(); i++) {
/* 41 */       Object key = srcMap.getKeyByOrder(String.valueOf(i + 1));
/* 42 */       put(key, srcMap.get(key));
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 47 */     MMap amap = new MMap();
/* 48 */     amap.put("key1", "value1");
/* 49 */     amap.put("key2", "value2");
/* 50 */     MMap bmap = new MMap();
/* 51 */     bmap.put("keyb1", "valueb1");
/* 52 */     bmap.put("keyb2", "valueb2");
/* 53 */     amap.add(bmap);
/* 54 */     for (int i = 0; i < amap.keySet().size(); i++) {
/* 55 */       Object key = amap.getKeyByOrder(String.valueOf(i + 1));
/* 56 */       System.out.println(amap.get(key).toString());
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.MMap
 * JD-Core Version:    0.6.0
 */