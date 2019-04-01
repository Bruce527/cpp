/*    */ package com.ibm.filenet.api.util;
/*    */ 
/*    */ import com.filenet.api.collection.EngineCollection;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import org.apache.commons.collections.CollectionUtils;
/*    */ 
/*    */ public class EngineCollectionUtils
/*    */ {
/*    */   public static <T> Collection<T> c(EngineCollection ec, Class<T> cls)
/*    */   {
/* 14 */     Iterator it = ec.iterator();
/* 15 */     Collection c = new ArrayList();
/* 16 */     CollectionUtils.addAll(c, it);
/* 17 */     return c;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.api.util.EngineCollectionUtils
 * JD-Core Version:    0.6.0
 */