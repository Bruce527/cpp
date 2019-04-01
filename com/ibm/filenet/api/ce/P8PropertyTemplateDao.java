/*     */ package com.ibm.filenet.api.ce;
/*     */ 
/*     */ import com.filenet.api.admin.LocalizedString;
/*     */ import com.filenet.api.admin.PropertyTemplate;
/*     */ import com.filenet.api.collection.IndependentObjectSet;
/*     */ import com.filenet.api.collection.LocalizedStringList;
/*     */ import com.filenet.api.collection.PropertyTemplateSet;
/*     */ import com.filenet.api.constants.Cardinality;
/*     */ import com.filenet.api.constants.RefreshMode;
/*     */ import com.filenet.api.core.Factory.LocalizedString;
/*     */ import com.filenet.api.core.Factory.PropertyTemplate;
/*     */ import com.filenet.api.core.Factory.PropertyTemplateBinary;
/*     */ import com.filenet.api.core.Factory.PropertyTemplateBoolean;
/*     */ import com.filenet.api.core.Factory.PropertyTemplateDateTime;
/*     */ import com.filenet.api.core.Factory.PropertyTemplateFloat64;
/*     */ import com.filenet.api.core.Factory.PropertyTemplateId;
/*     */ import com.filenet.api.core.Factory.PropertyTemplateInteger32;
/*     */ import com.filenet.api.core.Factory.PropertyTemplateObject;
/*     */ import com.filenet.api.core.Factory.PropertyTemplateString;
/*     */ import com.filenet.api.core.ObjectStore;
/*     */ import com.filenet.api.core.UpdatingBatch;
/*     */ import com.filenet.api.query.SearchSQL;
/*     */ import com.filenet.api.query.SearchScope;
/*     */ import com.filenet.api.util.Id;
/*     */ import com.ibm.filenet.api.util.EngineCollectionUtils;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class P8PropertyTemplateDao
/*     */ {
/*     */   public static PropertyTemplate createPropertyTemplate(ObjectStore os, int dataType, int cardinality, String symbolicName, Map<String, String> displayNameMap)
/*     */   {
/*  29 */     return createPropertyTemplate(null, os, dataType, cardinality, symbolicName, displayNameMap);
/*     */   }
/*     */ 
/*     */   public static PropertyTemplate createPropertyTemplate(UpdatingBatch ub, ObjectStore os, int dataType, int cardinality, String symbolicName, Map<String, String> displayNameMap)
/*     */   {
/*  34 */     PropertyTemplate prop = null;
/*     */ 
/*  36 */     switch (dataType) {
/*     */     case 1:
/*  38 */       prop = Factory.PropertyTemplateBinary.createInstance(os);
/*  39 */       break;
/*     */     case 2:
/*  41 */       prop = Factory.PropertyTemplateBoolean.createInstance(os);
/*  42 */       break;
/*     */     case 3:
/*  44 */       prop = Factory.PropertyTemplateDateTime.createInstance(os);
/*  45 */       break;
/*     */     case 4:
/*  47 */       prop = Factory.PropertyTemplateFloat64.createInstance(os);
/*  48 */       break;
/*     */     case 5:
/*  50 */       prop = Factory.PropertyTemplateId.createInstance(os);
/*  51 */       break;
/*     */     case 6:
/*  53 */       prop = Factory.PropertyTemplateInteger32.createInstance(os);
/*  54 */       break;
/*     */     case 7:
/*  56 */       prop = Factory.PropertyTemplateObject.createInstance(os);
/*  57 */       break;
/*     */     case 8:
/*  59 */       prop = Factory.PropertyTemplateString.createInstance(os);
/*  60 */       break;
/*     */     default:
/*  62 */       prop = Factory.PropertyTemplateObject.createInstance(os);
/*     */     }
/*     */ 
/*  65 */     switch (cardinality) {
/*     */     case 0:
/*  67 */       prop.set_Cardinality(Cardinality.SINGLE);
/*  68 */       break;
/*     */     case 2:
/*  70 */       prop.set_Cardinality(Cardinality.LIST);
/*  71 */       break;
/*     */     case 1:
/*  73 */       prop.set_Cardinality(Cardinality.ENUM);
/*  74 */       break;
/*     */     default:
/*  76 */       prop.set_Cardinality(Cardinality.SINGLE);
/*     */     }
/*     */ 
/*  79 */     prop.set_SymbolicName(symbolicName);
/*  80 */     prop.set_DisplayNames(Factory.LocalizedString.createList());
/*  81 */     Set keySet = displayNameMap.keySet();
/*  82 */     for (String key : keySet) {
/*  83 */       LocalizedString displayName = Factory.LocalizedString.createInstance();
/*  84 */       displayName.set_LocaleName(key);
/*  85 */       displayName.set_LocalizedText((String)displayNameMap.get(key));
/*  86 */       prop.get_DisplayNames().add(displayName);
/*     */     }
/*     */ 
/*  89 */     if (ub == null)
/*  90 */       prop.save(RefreshMode.REFRESH);
/*     */     else {
/*  92 */       P8CustomObjectDao.addToUpdatingBatchUniquly(ub, prop);
/*     */     }
/*  94 */     return prop;
/*     */   }
/*     */ 
/*     */   public static void deletePropertyTemplate(ObjectStore os, Id propTemplateId) {
/*  98 */     PropertyTemplate prop = Factory.PropertyTemplate.fetchInstance(os, propTemplateId, null);
/*  99 */     prop.delete();
/* 100 */     prop.save(RefreshMode.REFRESH);
/*     */   }
/*     */ 
/*     */   public static PropertyTemplate fetchPropertyTemplate(ObjectStore os, String id) {
/* 104 */     PropertyTemplate propertyTemplate = Factory.PropertyTemplate.fetchInstance(os, new Id(id), null);
/* 105 */     return propertyTemplate;
/*     */   }
/*     */ 
/*     */   public static List<PropertyTemplate> fetchPropertyTemplates(ObjectStore os, String symbolicName) {
/* 109 */     return fetchPropertyTemplates(os, symbolicName, new String[0]);
/*     */   }
/*     */ 
/*     */   public static List<PropertyTemplate> fetchPropertyTemplates(ObjectStore os, String symbolicName, String[] selectList) {
/* 113 */     String[] selectListOfSys = { "This", "Id", "SymbolicName", "DataType", "Cardinality", "DisplayName" };
/* 114 */     List list = new ArrayList();
/* 115 */     list.addAll(Arrays.asList(selectListOfSys));
/* 116 */     for (String p : selectList) {
/* 117 */       if (!list.contains(p)) {
/* 118 */         list.add(p);
/*     */       }
/*     */     }
/*     */ 
/* 122 */     SearchScope searchScope = new SearchScope(os);
/* 123 */     String sql = "SELECT p." + (String)list.get(0);
/* 124 */     for (int i = 1; i < list.size(); i++) {
/* 125 */       sql = sql + ",p." + (String)list.get(i);
/*     */     }
/*     */ 
/* 128 */     sql = sql + " FROM PropertyTemplate p WHERE p.SymbolicName='" + symbolicName + "'";
/* 129 */     SearchSQL searchSQL = new SearchSQL(sql);
/* 130 */     IndependentObjectSet objects = searchScope.fetchObjects(searchSQL, null, null, Boolean.valueOf(true));
/* 131 */     List propTemplates = new ArrayList();
/* 132 */     for (PropertyTemplate propTemplate : EngineCollectionUtils.c(objects, PropertyTemplate.class)) {
/* 133 */       propTemplates.add(propTemplate);
/*     */     }
/* 135 */     System.out.println("Search SQL:" + sql);
/* 136 */     return propTemplates;
/*     */   }
/*     */ 
/*     */   public static List<PropertyTemplate> fetchPropertyTemplates(ObjectStore os, String[] symbolicNames, String[] selectList) {
/* 140 */     List propTemplates = new ArrayList();
/* 141 */     if (symbolicNames.length == 0) {
/* 142 */       return propTemplates;
/*     */     }
/* 144 */     String[] selectListOfSys = { "This", "Id", "SymbolicName", "DataType", "Cardinality", "DisplayName" };
/* 145 */     List list = new ArrayList();
/* 146 */     list.addAll(Arrays.asList(selectListOfSys));
/* 147 */     for (String p : selectList) {
/* 148 */       if (!list.contains(p)) {
/* 149 */         list.add(p);
/*     */       }
/*     */     }
/*     */ 
/* 153 */     SearchScope searchScope = new SearchScope(os);
/* 154 */     String sql = "SELECT p." + (String)list.get(0);
/* 155 */     for (int i = 1; i < list.size(); i++) {
/* 156 */       sql = sql + ",p." + (String)list.get(i);
/*     */     }
/*     */ 
/* 159 */     String props = "'" + symbolicNames[0] + "'";
/* 160 */     for (int i = 0; i < symbolicNames.length; i++) {
/* 161 */       props = props + ",'" + symbolicNames[i] + "'";
/*     */     }
/*     */ 
/* 164 */     sql = sql + " FROM PropertyTemplate p WHERE p.SymbolicName in (" + props + ")";
/* 165 */     SearchSQL searchSQL = new SearchSQL(sql);
/* 166 */     IndependentObjectSet objects = searchScope.fetchObjects(searchSQL, null, null, Boolean.valueOf(true));
/* 167 */     for (PropertyTemplate propTemplate : EngineCollectionUtils.c(objects, PropertyTemplate.class)) {
/* 168 */       propTemplates.add(propTemplate);
/*     */     }
/* 170 */     System.out.println("Search SQL:" + sql);
/* 171 */     return propTemplates;
/*     */   }
/*     */ 
/*     */   public static PropertyTemplateSet getPropertyTemplates(ObjectStore os) {
/* 175 */     return os.get_PropertyTemplates();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.api.ce.P8PropertyTemplateDao
 * JD-Core Version:    0.6.0
 */