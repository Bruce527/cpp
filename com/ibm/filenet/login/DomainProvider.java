/*    */ package com.ibm.filenet.login;
/*    */ 
/*    */ import com.filenet.api.collection.ObjectStoreSet;
/*    */ import com.filenet.api.core.Connection;
/*    */ import com.filenet.api.core.Domain;
/*    */ import com.filenet.api.core.Factory.Domain;
/*    */ import com.filenet.api.core.Factory.ObjectStore;
/*    */ import com.filenet.api.core.ObjectStore;
/*    */ import com.filenet.api.property.PropertyFilter;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DomainProvider
/*    */ {
/*    */   private static DomainProvider instance;
/*    */ 
/*    */   public static synchronized DomainProvider getInstance()
/*    */   {
/* 24 */     if (instance == null) {
/* 25 */       instance = new DomainProvider();
/*    */     }
/* 27 */     return instance;
/*    */   }
/*    */ 
/*    */   public Domain fetchDomain(Connection connection, String domainName)
/*    */   {
/* 32 */     return fetchDomain(connection, domainName, null);
/*    */   }
/*    */ 
/*    */   public Domain fetchDomain(Connection connection, String domainName, PropertyFilter domainPropFilter)
/*    */   {
/* 37 */     return Factory.Domain.fetchInstance(connection, domainName, domainPropFilter);
/*    */   }
/*    */ 
/*    */   public ObjectStore fetchObjectStore(Connection connection, String domainName, String objectStoreName)
/*    */   {
/* 42 */     return fetchObjectStore(fetchDomain(connection, domainName), objectStoreName, null);
/*    */   }
/*    */ 
/*    */   public ObjectStore getObjectStore(Connection connection, String domainName, String objectStoreName)
/*    */   {
/* 47 */     return getObjectStore(fetchDomain(connection, domainName), objectStoreName, null);
/*    */   }
/*    */ 
/*    */   public ObjectStore fetchObjectStore(Connection connection, String domainName, String objectStoreName, PropertyFilter osPropFilter)
/*    */   {
/* 52 */     return fetchObjectStore(fetchDomain(connection, domainName), objectStoreName, osPropFilter);
/*    */   }
/*    */ 
/*    */   public ObjectStore fetchObjectStore(Domain domain, String objectStoreName, PropertyFilter osPropFilter)
/*    */   {
/* 57 */     return Factory.ObjectStore.fetchInstance(domain, objectStoreName, osPropFilter);
/*    */   }
/*    */ 
/*    */   public ObjectStore getObjectStore(Domain domain, String objectStoreName, PropertyFilter osPropFilter)
/*    */   {
/* 62 */     return Factory.ObjectStore.getInstance(domain, objectStoreName);
/*    */   }
/*    */ 
/*    */   public List<ObjectStore> listObjectStores(Domain domain) {
/* 66 */     List osList = new ArrayList();
/* 67 */     ObjectStoreSet osSet = domain.get_ObjectStores();
/*    */ 
/* 70 */     Iterator iterator = osSet.iterator();
/* 71 */     while (iterator.hasNext()) {
/* 72 */       ObjectStore os = (ObjectStore)iterator.next();
/*    */ 
/* 74 */       osList.add(os);
/*    */     }
/*    */ 
/* 77 */     return osList;
/*    */   }
/*    */ 
/*    */   public List<String> listObjectStoreNames(Domain domain)
/*    */   {
/* 82 */     List osNames = new ArrayList();
/* 83 */     ObjectStoreSet osSet = domain.get_ObjectStores();
/*    */ 
/* 86 */     Iterator iterator = osSet.iterator();
/* 87 */     while (iterator.hasNext()) {
/* 88 */       ObjectStore os = (ObjectStore)iterator.next();
/*    */ 
/* 90 */       osNames.add(os.get_DisplayName());
/*    */     }
/*    */ 
/* 93 */     return osNames;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.login.DomainProvider
 * JD-Core Version:    0.6.0
 */