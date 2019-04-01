/*     */ package com.ibm.filenet.api.ce;
/*     */ 
/*     */ import com.filenet.api.admin.ClassDefinition;
/*     */ import com.filenet.api.admin.LocalizedString;
/*     */ import com.filenet.api.admin.PropertyDefinition;
/*     */ import com.filenet.api.admin.PropertyTemplate;
/*     */ import com.filenet.api.collection.ClassDefinitionSet;
/*     */ import com.filenet.api.collection.ClassDescriptionSet;
/*     */ import com.filenet.api.collection.DateTimeList;
/*     */ import com.filenet.api.collection.IndependentObjectSet;
/*     */ import com.filenet.api.collection.LocalizedStringList;
/*     */ import com.filenet.api.collection.PropertyDefinitionList;
/*     */ import com.filenet.api.collection.StringList;
/*     */ import com.filenet.api.constants.Cardinality;
/*     */ import com.filenet.api.constants.PropertySettability;
/*     */ import com.filenet.api.constants.RefreshMode;
/*     */ import com.filenet.api.constants.TypeID;
/*     */ import com.filenet.api.core.Factory.ClassDefinition;
/*     */ import com.filenet.api.core.Factory.DateTimeList;
/*     */ import com.filenet.api.core.Factory.LocalizedString;
/*     */ import com.filenet.api.core.Factory.StringList;
/*     */ import com.filenet.api.core.ObjectStore;
/*     */ import com.filenet.api.core.UpdatingBatch;
/*     */ import com.filenet.api.exception.EngineRuntimeException;
/*     */ import com.filenet.api.exception.ExceptionCode;
/*     */ import com.filenet.api.meta.ClassDescription;
/*     */ import com.filenet.api.property.Properties;
/*     */ import com.filenet.api.query.SearchSQL;
/*     */ import com.filenet.api.query.SearchScope;
/*     */ import com.filenet.api.util.Id;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class P8ClassDefinitionDao
/*     */ {
/*  26 */   public static Logger logger = Logger.getLogger(P8ClassDefinitionDao.class);
/*     */ 
/*     */   public static void addPropertyDefinitionsToClassDefinition(ObjectStore os, ClassDefinition classDefinition, List<PropertyTemplate> propTemplateIdList)
/*     */   {
/*  30 */     PropertyDefinitionList propDefList = classDefinition.get_PropertyDefinitions();
/*  31 */     for (PropertyTemplate propTemplate : propTemplateIdList) {
/*  32 */       PropertyDefinition newPropDef = propTemplate.createClassProperty();
/*  33 */       newPropDef.set_Settability(PropertySettability.READ_WRITE);
/*  34 */       propDefList.add(newPropDef);
/*     */     }
/*  36 */     classDefinition.save(RefreshMode.REFRESH);
/*     */   }
/*     */ 
/*     */   public static void addPropertyDefinitionsToClassDefinitionBySymbolicName(ObjectStore os, ClassDefinition classDefinition, List<String> propTemplateSymbolicNameList)
/*     */   {
/*  41 */     PropertyDefinitionList propDefList = classDefinition.get_PropertyDefinitions();
/*  42 */     List propSymblicNameList = new ArrayList();
/*  43 */     Iterator it = propDefList.iterator();
/*  44 */     PropertyDefinition pdf = null;
/*  45 */     while (it.hasNext()) {
/*  46 */       pdf = (PropertyDefinition)it.next();
/*  47 */       propSymblicNameList.add(pdf.get_SymbolicName());
/*  48 */       System.out.println("SymbolicName\u951B\uFFFD" + pdf.get_SymbolicName());
/*     */     }
/*  50 */     PropertyTemplate propTemplate = null;
/*  51 */     List propTemplateList = null;
/*  52 */     PropertyDefinition newPropDef = null;
/*  53 */     for (String symbolicName : propTemplateSymbolicNameList)
/*     */     {
/*  55 */       propTemplateList = P8PropertyTemplateDao.fetchPropertyTemplates(os, symbolicName);
/*  56 */       if ((propTemplateList == null) || (propTemplateList.size() > 0)) {
/*  57 */         propTemplate = (PropertyTemplate)propTemplateList.get(0);
/*  58 */         newPropDef = propTemplate.createClassProperty();
/*  59 */         newPropDef.set_Settability(PropertySettability.READ_WRITE);
/*  60 */         if (!isClassHasThisProperty(propSymblicNameList, newPropDef)) {
/*  61 */           propDefList.add(newPropDef);
/*     */         }
/*     */       }
/*     */     }
/*  65 */     classDefinition.save(RefreshMode.REFRESH);
/*     */   }
/*     */ 
/*     */   private static boolean isClassHasThisProperty(List<String> propDefList, PropertyDefinition newPropDef) {
/*  69 */     boolean bHas = false;
/*  70 */     String propDef = null;
/*  71 */     if ((propDefList != null) && (propDefList.size() > 0)) {
/*  72 */       Iterator it = propDefList.iterator();
/*  73 */       while (it.hasNext()) {
/*  74 */         propDef = (String)it.next();
/*  75 */         if (propDef.equals(newPropDef.get_PropertyTemplate().get_SymbolicName())) {
/*  76 */           bHas = true;
/*  77 */           break;
/*     */         }
/*     */       }
/*     */     }
/*  81 */     return bHas;
/*     */   }
/*     */ 
/*     */   public static ClassDefinition createClassDefinition(ObjectStore os, String parentSymbolicName, String symbolicName, Map<String, String> displayNameMap) {
/*  85 */     ClassDefinition parent = Factory.ClassDefinition.fetchInstance(os, parentSymbolicName, null);
/*  86 */     return createClassDefinition(parent, symbolicName, displayNameMap);
/*     */   }
/*     */ 
/*     */   public static ClassDefinition createClassDefinition(ClassDefinition parent, String symbolicName, Map<String, String> displayNameMap) {
/*  90 */     return createClassDefinition(null, parent, symbolicName, displayNameMap);
/*     */   }
/*     */ 
/*     */   public static ClassDefinition createClassDefinition(UpdatingBatch ub, ClassDefinition parent, String symbolicName, Map<String, String> displayNameMap)
/*     */   {
/*  95 */     ClassDefinition def = parent.createSubclass();
/*  96 */     def.set_SymbolicName(symbolicName);
/*  97 */     def.set_DisplayNames(Factory.LocalizedString.createList());
/*  98 */     Set keySet = displayNameMap.keySet();
/*  99 */     for (String key : keySet) {
/* 100 */       LocalizedString displayName = Factory.LocalizedString.createInstance();
/* 101 */       displayName.set_LocaleName(key);
/* 102 */       displayName.set_LocalizedText((String)displayNameMap.get(key));
/* 103 */       def.get_DisplayNames().add(displayName);
/*     */     }
/*     */ 
/* 106 */     if (ub == null)
/* 107 */       def.save(RefreshMode.REFRESH);
/*     */     else
/* 109 */       P8CustomObjectDao.addToUpdatingBatchUniquly(ub, def);
/* 110 */     return def;
/*     */   }
/*     */ 
/*     */   public static void deleteClassDefinition(ObjectStore os, String symbolicName) {
/* 114 */     ClassDefinition clzDef = Factory.ClassDefinition.fetchInstance(os, symbolicName, null);
/* 115 */     deleteClassDefinition(os, clzDef);
/*     */   }
/*     */ 
/*     */   public static void deleteClassDefinition(ObjectStore os, ClassDefinition classDefinition) {
/* 119 */     classDefinition.delete();
/* 120 */     classDefinition.save(RefreshMode.REFRESH);
/*     */   }
/*     */ 
/*     */   public static ClassDefinition fetchClassDefinition(ObjectStore os, String symbolicName) {
/*     */     try {
/* 125 */       if (os == null)
/*     */       {
/* 127 */         throw new NullPointerException("ObjectStore is null when get ClassDefinition of " + symbolicName);
/*     */       }
/* 129 */       return Factory.ClassDefinition.fetchInstance(os, symbolicName, null);
/*     */     } catch (EngineRuntimeException e) {
/* 131 */       if (e.getExceptionCode() == ExceptionCode.E_BAD_CLASSID) {
/* 132 */         logger.warn(os.get_Name() + " : " + e.getMessage());
/* 133 */         return null;
/*     */       }
/*     */     }
/* 135 */     throw e;
/*     */   }
/*     */ 
/*     */   public static ClassDefinitionSet getImmediateSubclassDefinitions(ObjectStore os, String symbolicName)
/*     */   {
/* 141 */     ClassDefinition def = Factory.ClassDefinition.fetchInstance(os, symbolicName, null);
/* 142 */     return def.get_ImmediateSubclassDefinitions();
/*     */   }
/*     */ 
/*     */   public static PropertyDefinitionList getPropertyDefinitionList(ObjectStore os, String symbolicName) {
/* 146 */     ClassDefinition clzDef = Factory.ClassDefinition.fetchInstance(os, symbolicName, null);
/* 147 */     return clzDef.get_PropertyDefinitions();
/*     */   }
/*     */ 
/*     */   public static boolean hasPropertyDefinition(ObjectStore os, String clzSymbolicName, String propSymbolicName) {
/* 151 */     boolean flag = false;
/*     */ 
/* 153 */     ClassDefinition clzDef = Factory.ClassDefinition.fetchInstance(os, clzSymbolicName, null);
/* 154 */     PropertyDefinitionList propDefList = clzDef.get_PropertyDefinitions();
/* 155 */     for (int i = 0; i < propDefList.size(); i++) {
/* 156 */       PropertyDefinition propDef = (PropertyDefinition)propDefList.get(i);
/* 157 */       if (StringUtils.equals(propDef.get_SymbolicName(), propSymbolicName)) {
/* 158 */         flag = true;
/*     */       }
/*     */     }
/*     */ 
/* 162 */     return flag;
/*     */   }
/*     */ 
/*     */   public static List<String> listAllClassDefinitionNames(ObjectStore os)
/*     */   {
/* 167 */     List clzDefNames = new ArrayList();
/*     */ 
/* 169 */     ClassDescriptionSet cds = os.get_ClassDescriptions();
/* 170 */     Iterator it = cds.iterator();
/* 171 */     while (it.hasNext()) {
/* 172 */       ClassDescription clzDesc = (ClassDescription)it.next();
/* 173 */       clzDefNames.add(clzDesc.get_SymbolicName());
/*     */     }
/*     */ 
/* 176 */     return clzDefNames;
/*     */   }
/*     */ 
/*     */   public static List<ClassDefinition> listDocumentClasses(ObjectStore os) {
/* 180 */     List defList = new ArrayList();
/*     */ 
/* 182 */     String queryString = "SELECT * FROM DocumentClassDefinition WHERE [IsHidden] = FALSE AND [AllowsInstances] = TRUE";
/* 183 */     SearchSQL searchSQL = new SearchSQL(queryString);
/* 184 */     SearchScope searchScope = new SearchScope(os);
/* 185 */     IndependentObjectSet set = searchScope.fetchObjects(searchSQL, null, null, Boolean.valueOf(false));
/*     */ 
/* 188 */     Iterator iter = set.iterator();
/* 189 */     while (iter.hasNext()) {
/* 190 */       defList.add((ClassDefinition)iter.next());
/*     */     }
/*     */ 
/* 193 */     return defList;
/*     */   }
/*     */ 
/*     */   public static void removePropTempFromClassDef(ObjectStore os, String propTemplateName, String symbolicClassName) {
/* 197 */     ClassDefinition classDef = Factory.ClassDefinition.fetchInstance(os, symbolicClassName, null);
/*     */ 
/* 199 */     PropertyDefinitionList propDefs = classDef.get_PropertyDefinitions();
/* 200 */     for (Iterator localIterator = propDefs.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 201 */       PropertyDefinition propDef = (PropertyDefinition)object;
/* 202 */       if (propDef.get_SymbolicName().equalsIgnoreCase(propTemplateName)) {
/* 203 */         propDefs.remove(object);
/* 204 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void updatePropertyDefinitionsOfClassDefinition(ObjectStore os, ClassDefinition classDefinition, List<String> propTemplateIdList)
/*     */   {
/* 211 */     PropertyDefinitionList propertyDefinitionList = classDefinition.get_PropertyDefinitions();
/*     */     String propId;
/* 215 */     for (int i = propertyDefinitionList.size() - 1; i >= classDefinition.get_ProtectedPropertyCount().intValue(); i--) {
/* 216 */       Object obj = propertyDefinitionList.get(i);
/* 217 */       boolean exist = false;
/* 218 */       PropertyDefinition propertyDefinition = (PropertyDefinition)obj;
/* 219 */       String id = propertyDefinition.get_Id().toString();
/* 220 */       for (Iterator localIterator = propTemplateIdList.iterator(); localIterator.hasNext(); ) { propId = (String)localIterator.next();
/* 221 */         if (propId.equals(id)) {
/* 222 */           propTemplateIdList.remove(propId);
/* 223 */           exist = true;
/* 224 */           break;
/*     */         }
/*     */       }
/* 227 */       if (!exist) {
/* 228 */         propertyDefinitionList.remove(obj);
/*     */       }
/*     */     }
/*     */ 
/* 232 */     for (String propId : propTemplateIdList) {
/* 233 */       PropertyTemplate propTemplate = P8PropertyTemplateDao.fetchPropertyTemplate(os, propId);
/* 234 */       PropertyDefinition newPropDef = propTemplate.createClassProperty();
/* 235 */       newPropDef.set_Settability(PropertySettability.READ_WRITE);
/* 236 */       propertyDefinitionList.add(newPropDef);
/*     */     }
/* 238 */     classDefinition.save(RefreshMode.NO_REFRESH);
/*     */   }
/*     */ 
/*     */   public static void updatePropertyListofClassDefinition(ObjectStore os, ClassDefinition classDefinition, List<String> deletePropertyList, List<String> createPropertyList)
/*     */   {
/* 243 */     if (((deletePropertyList == null) || (deletePropertyList.size() == 0)) && ((createPropertyList == null) || (createPropertyList.size() == 0))) {
/* 244 */       return;
/*     */     }
/*     */ 
/* 247 */     PropertyDefinitionList propertyDefList = classDefinition.get_PropertyDefinitions();
/*     */ 
/* 250 */     if ((deletePropertyList != null) && (deletePropertyList.size() > 0)) {
/* 251 */       for (int i = deletePropertyList.size() - 1; i >= 0; i--) {
/* 252 */         String symbolicName = (String)deletePropertyList.get(i);
/* 253 */         for (int j = propertyDefList.size() - 1; j >= 0; j--) {
/* 254 */           if (((PropertyDefinition)propertyDefList.get(j)).get_SymbolicName().equals(symbolicName)) {
/* 255 */             propertyDefList.remove(j);
/* 256 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 261 */     if ((createPropertyList != null) && (createPropertyList.size() > 0))
/* 262 */       for (int i = createPropertyList.size() - 1; i >= 0; i--) {
/* 263 */         String symbolic = (String)createPropertyList.get(i);
/* 264 */         List propertyTemplates = P8PropertyTemplateDao.fetchPropertyTemplates(os, symbolic);
/* 265 */         if (propertyTemplates.size() > 0) {
/* 266 */           PropertyTemplate propTemplate = (PropertyTemplate)propertyTemplates.get(0);
/* 267 */           PropertyDefinition newPropDef = propTemplate.createClassProperty();
/* 268 */           propertyDefList.add(newPropDef);
/*     */         } else {
/* 270 */           throw new RuntimeException("\u7455\u4F78\u57B1\u5BE4\u54C4\u7584\u6E1A\u5B2C\u6B91\u705E\u70B4\uFFFD\u0444\u0101\u93C9\uFFFD" + symbolic + "\u6D93\u5D85\u74E8\u9366\uFFFD");
/*     */         }
/*     */       }
/*     */     try
/*     */     {
/* 275 */       classDefinition.save(RefreshMode.REFRESH);
/*     */     } catch (EngineRuntimeException e) {
/* 277 */       if (e.getExceptionCode() == ExceptionCode.E_NOT_UNIQUE) {
/* 278 */         throw new RuntimeException("\u705E\u70B4\uFFFD\u0443\u51E1\u701B\u6A3A\u6E6A\u6D5C\u5EA1\u7D8B\u9353\u5D85\u578E\u7EEB\u7ED8\u57A8\u934F\u8DFA\u74D9\u7EEB\u8BB3\u8151", e);
/*     */       }
/* 280 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void putObjectValue(ObjectStore os, String symbolicClassName, Properties props, String name, Object updatedAttr)
/*     */   {
/* 288 */     if (StringUtils.isEmpty(symbolicClassName)) {
/* 289 */       symbolicClassName = "Document";
/*     */     }
/*     */ 
/* 292 */     ClassDefinition objClassDef = Factory.ClassDefinition.fetchInstance(os, symbolicClassName, null);
/*     */ 
/* 294 */     PropertyDefinitionList objPropDefs = objClassDef.get_PropertyDefinitions();
/* 295 */     Iterator it = objPropDefs.iterator();
/*     */ 
/* 297 */     while (it.hasNext()) {
/* 298 */       PropertyDefinition objPropDef = (PropertyDefinition)it.next();
/* 299 */       String objPropDefSymbolicName = objPropDef.get_SymbolicName();
/* 300 */       if (objPropDefSymbolicName.equals(name)) {
/* 301 */         if (objPropDef.get_Cardinality() == Cardinality.LIST) {
/* 302 */           TypeID type = objPropDef.get_DataType();
/* 303 */           if (type == TypeID.STRING) {
/* 304 */             StringList list = Factory.StringList.createList();
/* 305 */             List strList = (List)updatedAttr;
/* 306 */             for (String str : strList) {
/* 307 */               list.add(str);
/*     */             }
/* 309 */             props.putObjectValue(name, list);
/* 310 */             break; } if (type != TypeID.DATE) break;
/* 311 */           DateTimeList list = Factory.DateTimeList.createList();
/* 312 */           List dateList = (List)updatedAttr;
/* 313 */           for (Date date : dateList) {
/* 314 */             list.add(date);
/*     */           }
/* 316 */           props.putObjectValue(name, list);
/*     */ 
/* 318 */           break;
/* 319 */         }props.putObjectValue(name, updatedAttr);
/*     */ 
/* 321 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.api.ce.P8ClassDefinitionDao
 * JD-Core Version:    0.6.0
 */