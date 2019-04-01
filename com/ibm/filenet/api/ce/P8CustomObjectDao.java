/*     */ package com.ibm.filenet.api.ce;
/*     */ 
/*     */ import com.filenet.api.constants.RefreshMode;
/*     */ import com.filenet.api.core.CustomObject;
/*     */ import com.filenet.api.core.Factory.CustomObject;
/*     */ import com.filenet.api.core.IndependentlyPersistableObject;
/*     */ import com.filenet.api.core.ObjectStore;
/*     */ import com.filenet.api.core.UpdatingBatch;
/*     */ import com.filenet.api.exception.EngineRuntimeException;
/*     */ import com.filenet.api.exception.ExceptionCode;
/*     */ import com.filenet.api.property.Properties;
/*     */ import com.filenet.api.property.PropertyFilter;
/*     */ import com.filenet.api.util.Id;
/*     */ import com.ibm.filenet.api.ce.search.Search;
/*     */ import com.ibm.filenet.api.util.ObjectStoreUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class P8CustomObjectDao
/*     */ {
/*  25 */   private static final Logger logger = Logger.getLogger(P8CustomObjectDao.class);
/*     */ 
/*     */   public static CustomObject createCustomObject(ObjectStore os, String symbolicName, Map<String, Object> propMap, boolean save) {
/*  28 */     CustomObject co = Factory.CustomObject.createInstance(os, symbolicName);
/*     */ 
/*  30 */     if ((propMap == null) || (propMap.isEmpty())) {
/*  31 */       throw new RuntimeException("Property map is null or empty.");
/*     */     }
/*  33 */     Set propKeySet = propMap.keySet();
/*  34 */     Properties props = co.getProperties();
/*  35 */     for (String propName : propKeySet) {
/*  36 */       Object obj = propMap.get(propName);
/*  37 */       if (obj != null) {
/*  38 */         props.putObjectValue(propName, propMap.get(propName));
/*     */       }
/*     */     }
/*  41 */     if (save) {
/*  42 */       co.save(RefreshMode.REFRESH);
/*     */     }
/*     */ 
/*  45 */     return co;
/*     */   }
/*     */ 
/*     */   public static void deleteCustomObject(CustomObject customObject, boolean save) {
/*  49 */     customObject.delete();
/*  50 */     if (save)
/*  51 */       customObject.save(RefreshMode.NO_REFRESH);
/*     */   }
/*     */ 
/*     */   public static void deleteCustomObject(CustomObject customObject)
/*     */   {
/*  56 */     deleteCustomObject(customObject, true);
/*     */   }
/*     */ 
/*     */   public static void deleteCustomObjectById(ObjectStore os, String coId, boolean save) {
/*  60 */     CustomObject co = fetchCustomObjectById(os, coId);
/*  61 */     deleteCustomObject(co, save);
/*     */   }
/*     */ 
/*     */   public static void deleteCustomObjectByPath(ObjectStore os, String coPath, boolean save) {
/*  65 */     CustomObject co = fetchCustomObjectByPath(os, coPath);
/*  66 */     deleteCustomObject(co, save);
/*     */   }
/*     */ 
/*     */   public static CustomObject fetchCustomObjectById(ObjectStore os, String customObjectId) {
/*  70 */     return fetchCustomObjectById(os, customObjectId, null);
/*     */   }
/*     */ 
/*     */   public static CustomObject fetchCustomObjectById(ObjectStore os, String customObjectId, PropertyFilter customObjectPropFilter) {
/*     */     try {
/*  75 */       return Factory.CustomObject.fetchInstance(os, new Id(customObjectId), customObjectPropFilter);
/*     */     } catch (EngineRuntimeException ex) {
/*  77 */       if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND) {
/*  78 */         logger.error("Custom object cannot be found by id '" + customObjectId + "'.", ex);
/*  79 */         return null;
/*     */       }
/*     */     }
/*  81 */     throw ex;
/*     */   }
/*     */ 
/*     */   public static CustomObject fetchCustomObjectByPath(ObjectStore os, String customObjectPath)
/*     */   {
/*  86 */     return fetchCustomObjectByPath(os, customObjectPath, null);
/*     */   }
/*     */ 
/*     */   public static CustomObject fetchCustomObjectByPath(ObjectStore os, String customObjectPath, PropertyFilter customObjectPropFilter) {
/*     */     try {
/*  91 */       return Factory.CustomObject.fetchInstance(os, customObjectPath, customObjectPropFilter);
/*     */     } catch (EngineRuntimeException ex) {
/*  93 */       if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND) {
/*  94 */         logger.error("Custom object cannot be found by path '" + customObjectPath + "'.", ex);
/*  95 */         return null;
/*     */       }
/*     */     }
/*  97 */     throw ex;
/*     */   }
/*     */ 
/*     */   public static Map<String, Object> iterateCustomObjectAttributes(ObjectStore os, CustomObject co)
/*     */   {
/* 102 */     return ObjectStoreUtil.iterateAttributes(os, co);
/*     */   }
/*     */ 
/*     */   public static List<CustomObject> listCustomObjects(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String orderByClause) {
/* 106 */     Search search = new Search();
/* 107 */     return search.setObjectSql(symbolicClassName, includeSubclasses, null, orderByClause, -1).setScope(os).setPropertyFilter().fetchCustomObjects();
/*     */   }
/*     */ 
/*     */   public static List<CustomObject> searchForCustomObjects(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause) {
/* 111 */     Search search = new Search();
/* 112 */     return search.setObjectSql(symbolicClassName, includeSubclasses, whereClause, null, "").setScope(os).setPropertyFilter().fetchCustomObjects();
/*     */   }
/*     */ 
/*     */   public static List<CustomObject> searchForCustomObjects(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause, List<String> selectList) {
/* 116 */     Search search = new Search();
/* 117 */     return search.setObjectSql(symbolicClassName, includeSubclasses, whereClause, selectList, "").setScope(os).setPropertyFilter().fetchCustomObjects();
/*     */   }
/*     */ 
/*     */   public static List<CustomObject> searchForCustomObjects(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause, String orderByClause, boolean isFullText) {
/* 121 */     Search search = new Search();
/* 122 */     return search.setObjectSql(symbolicClassName, includeSubclasses, whereClause, orderByClause, -1, isFullText).setScope(os).setPropertyFilter().fetchCustomObjects();
/*     */   }
/*     */ 
/*     */   public static List<CustomObject> searchForCustomObjects(ObjectStore os, String symbolicClassName, String whereClause) {
/* 126 */     Search search = new Search();
/* 127 */     return search.setObjectSql(symbolicClassName, false, whereClause, null, "").setScope(os).setPropertyFilter().fetchCustomObjects();
/*     */   }
/*     */ 
/*     */   public static List<Object> searchForDistinctCustomObjectFields(ObjectStore os, String selectClause, String symbolicClassName, boolean includeSubclasses, String whereClause, String orderByClause) {
/* 131 */     List result = new ArrayList();
/*     */ 
/* 133 */     boolean distinct = true;
/* 134 */     Search search = new Search();
/* 135 */     List customObjectList = search.setObjectSql(distinct, selectClause, symbolicClassName, includeSubclasses, whereClause, orderByClause).setScope(os).setPropertyFilter().fetchCustomObjects();
/*     */ 
/* 137 */     for (CustomObject co : customObjectList) {
/* 138 */       Object value = co.getProperties().getObjectValue(selectClause);
/* 139 */       result.add(value);
/*     */     }
/*     */ 
/* 142 */     return result;
/*     */   }
/*     */ 
/*     */   public static List<CustomObject> searchForDistinctCustomObjects(ObjectStore os, String selectClause, String symbolicClassName, boolean includeSubclasses, String whereClause, String orderByClause) {
/* 146 */     boolean distinct = true;
/* 147 */     Search search = new Search();
/* 148 */     return search.setObjectSql(distinct, selectClause, symbolicClassName, includeSubclasses, whereClause, orderByClause).setScope(os).setPropertyFilter().fetchCustomObjects();
/*     */   }
/*     */ 
/*     */   public static void updateCustomObjectAttributes(ObjectStore os, CustomObject co, Map<String, Object> updatedAttrs) {
/* 152 */     updateAttributes(os, co, updatedAttrs);
/*     */   }
/*     */ 
/*     */   public static void updateCustomObjectAttributes(ObjectStore os, String customObjectId, Map<String, Object> updatedAttrs) {
/* 156 */     updateAttributes(os, fetchCustomObjectById(os, customObjectId), updatedAttrs);
/*     */   }
/*     */ 
/*     */   public static boolean updateAttributes(ObjectStore os, IndependentlyPersistableObject ipo, Map<String, Object> updatedAttrs)
/*     */   {
/* 161 */     boolean flag = false;
/*     */ 
/* 163 */     if ((updatedAttrs == null) || (updatedAttrs.isEmpty())) {
/* 164 */       return true;
/*     */     }
/* 166 */     Iterator it = updatedAttrs.keySet().iterator();
/* 167 */     Properties props = ipo.getProperties();
/* 168 */     while (it.hasNext()) {
/* 169 */       String name = (String)it.next();
/* 170 */       Object updatedAttr = updatedAttrs.get(name);
/* 171 */       if ((props.isPropertyPresent(name)) && (updatedAttr != null)) {
/* 172 */         if (!name.equals("techProcDocId"))
/* 173 */           props.putObjectValue(name, updatedAttr);
/*     */         else {
/* 175 */           props.putObjectValue(name, new Id(updatedAttr.toString()));
/*     */         }
/*     */       }
/*     */     }
/* 179 */     ipo.save(RefreshMode.REFRESH);
/* 180 */     flag = true;
/*     */ 
/* 182 */     return flag;
/*     */   }
/*     */ 
/*     */   public static CustomObject createCustomObject(ObjectStore os, String symbolicName, Map<String, Object> propMap) {
/* 186 */     CustomObject co = Factory.CustomObject.createInstance(os, symbolicName);
/*     */ 
/* 188 */     if ((propMap == null) || (propMap.isEmpty())) {
/* 189 */       throw new RuntimeException("Property map is null or empty.");
/*     */     }
/* 191 */     Properties props = co.getProperties();
/* 192 */     P8DocumentDao.updateAttributes(props, propMap);
/*     */ 
/* 194 */     co.save(RefreshMode.REFRESH);
/*     */ 
/* 196 */     return co;
/*     */   }
/*     */ 
/*     */   public static void addToUpdatingBatchUniquly(UpdatingBatch ub, IndependentlyPersistableObject co) {
/* 200 */     if (ub.getBatchItemHandles(co).size() == 0)
/* 201 */       ub.add(co, null);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.api.ce.P8CustomObjectDao
 * JD-Core Version:    0.6.0
 */