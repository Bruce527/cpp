/*    */ package com.ibm.filenet.api.util;
/*    */ 
/*    */ import com.filenet.api.core.IndependentlyPersistableObject;
/*    */ import com.filenet.api.core.ObjectStore;
/*    */ import com.filenet.api.property.Properties;
/*    */ import com.filenet.api.property.Property;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ObjectStoreUtil
/*    */ {
/*    */   public static Map<String, Object> iterateAttributes(ObjectStore os, IndependentlyPersistableObject ipo)
/*    */   {
/* 18 */     Map map = new HashMap();
/*    */ 
/* 20 */     Properties props = ipo.getProperties();
/* 21 */     Iterator it = props.iterator();
/* 22 */     while (it.hasNext()) {
/* 23 */       Property prop = (Property)it.next();
/* 24 */       map.put(prop.getPropertyName(), prop.getObjectValue());
/*    */     }
/*    */ 
/* 27 */     return map;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.api.util.ObjectStoreUtil
 * JD-Core Version:    0.6.0
 */