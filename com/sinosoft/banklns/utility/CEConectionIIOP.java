/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import com.filenet.api.admin.ClassDefinition;
/*    */ import com.filenet.api.admin.PropertyDefinition;
/*    */ import com.filenet.api.collection.ObjectStoreSet;
/*    */ import com.filenet.api.collection.PropertyDefinitionList;
/*    */ import com.filenet.api.core.Connection;
/*    */ import com.filenet.api.core.Domain;
/*    */ import com.filenet.api.core.Factory.ClassDefinition;
/*    */ import com.filenet.api.core.Factory.Connection;
/*    */ import com.filenet.api.core.Factory.Domain;
/*    */ import com.filenet.api.core.Factory.ObjectStore;
/*    */ import com.filenet.api.core.ObjectStore;
/*    */ import com.filenet.api.util.UserContext;
/*    */ import filenet.vw.api.VWException;
/*    */ import filenet.vw.api.VWSession;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Iterator;
/*    */ import javax.security.auth.Subject;
/*    */ 
/*    */ public class CEConectionIIOP
/*    */ {
/*    */   private static Connection conn;
/*    */   private static Domain domain;
/*    */   private static ObjectStore os;
/*    */   private ObjectStoreSet OStoreSet;
/*    */ 
/*    */   public static void testIIOP()
/*    */     throws VWException
/*    */   {
/* 27 */     System.setProperty("wasp.location", ".\\config\\pe");
/* 28 */     System.setProperty("java.security.auth.login.config", "./config/pe/jaas.conf.WSI");
/* 29 */     System.setProperty("filenet.pe.bootstrap.ceuri", "iiop://iws.metlife.cn:8091/FileNet/Engine");
/* 30 */     System.out.println("stp1:~~~~~~~~~~~``CEConfiguration.FILENET_URI");
/* 31 */     Connection ceConnection = Factory.Connection.getConnection(CEConfiguration.FILENET_URI);
/* 32 */     System.out.println("stp2:~~~~~~~~~~~``" + CEConfiguration.FILENET_USERNAME);
/* 33 */     Subject ceSubject = UserContext.createSubject(ceConnection, CEConfiguration.FILENET_USERNAME, CEConfiguration.FILENET_PASSWORD, null);
/* 34 */     System.out.println("stp3:~~~~~~~~~~~``pushSubject(ceSubject)");
/* 35 */     UserContext.get().pushSubject(ceSubject);
/* 36 */     System.out.println("stp4:~~~~~~~~~~~``Factory.Domain.fetchInstance");
/* 37 */     Domain ceDomain = Factory.Domain.fetchInstance(ceConnection, CEConfiguration.CE_DOMAIN, null);
/* 38 */     System.out.println("stp5:~~~~~~~~~~~``Factory.ObjectStore.fetchInstance");
/* 39 */     ObjectStore ceObjectStore = Factory.ObjectStore.fetchInstance(ceDomain, CEConfiguration.CE_OBJECTSTORE, null);
/* 40 */     System.out.println("stp6:~~~~~~~~~~~``Factory.ClassDefinition.fetchInstance");
/* 41 */     ClassDefinition classDef = Factory.ClassDefinition.fetchInstance(ceObjectStore, "Document", null);
/*    */ 
/* 43 */     PropertyDefinitionList properties = classDef.get_PropertyDefinitions();
/*    */ 
/* 45 */     for (Iterator propertyIter = properties.iterator(); propertyIter.hasNext(); ) {
/* 46 */       PropertyDefinition property = (PropertyDefinition)propertyIter.next();
/* 47 */       System.out.println("Property: " + property.get_DisplayName());
/*    */     }
/*    */ 
/* 50 */     UserContext.get().popSubject();
/* 51 */     VWSession peSession = new VWSession();
/* 52 */     peSession.setBootstrapCEURI(CEConfiguration.FILENET_URI);
/* 53 */     peSession.logon(CEConfiguration.FILENET_USERNAME, CEConfiguration.FILENET_PASSWORD, CEConfiguration.PE_CONNECTION_POINT);
/* 54 */     String[] queueNames = peSession.fetchQueueNames(1);
/* 55 */     for (String queue : queueNames)
/* 56 */       System.out.println("Queue: " + queue);
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 72 */       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~main init~~~~~~~~~~~~~~~~~~~~~~~~~``");
/* 73 */       new CEConectionIIOP(); testIIOP();
/*    */     } catch (VWException e) {
/* 75 */       e.printStackTrace();
/* 76 */       System.out.println("~~~~~~~`" + e.getLocalizedMessage());
/*    */     }
/*    */   }
/*    */ 
/*    */   private static class CEConfiguration
/*    */   {
/* 61 */     private static String FILENET_URI = "iiop://iws.metlife.cn:8091/FileNet/Engine";
/* 62 */     private static String CE_DOMAIN = "P8Domain";
/* 63 */     private static String FILENET_USERNAME = "P8services";
/* 64 */     private static String FILENET_PASSWORD = "Hello01";
/* 65 */     private static String CE_OBJECTSTORE = "IWS";
/* 66 */     private static String PE_CONNECTION_POINT = "";
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.CEConectionIIOP
 * JD-Core Version:    0.6.0
 */