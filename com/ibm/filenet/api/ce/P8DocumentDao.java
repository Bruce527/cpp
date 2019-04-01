/*      */ package com.ibm.filenet.api.ce;
/*      */ 
/*      */ import com.filenet.api.admin.ClassDefinition;
/*      */ import com.filenet.api.admin.PropertyDefinition;
/*      */ import com.filenet.api.collection.ContentElementList;
/*      */ import com.filenet.api.collection.DocumentSet;
/*      */ import com.filenet.api.collection.FolderSet;
/*      */ import com.filenet.api.collection.PropertyDefinitionList;
/*      */ import com.filenet.api.collection.StringList;
/*      */ import com.filenet.api.collection.VersionableSet;
/*      */ import com.filenet.api.constants.AutoClassify;
/*      */ import com.filenet.api.constants.AutoUniqueName;
/*      */ import com.filenet.api.constants.CheckinType;
/*      */ import com.filenet.api.constants.ComponentCascadeDeleteAction;
/*      */ import com.filenet.api.constants.CompoundDocumentState;
/*      */ import com.filenet.api.constants.DefineSecurityParentage;
/*      */ import com.filenet.api.constants.RefreshMode;
/*      */ import com.filenet.api.constants.ReservationType;
/*      */ import com.filenet.api.core.ComponentRelationship;
/*      */ import com.filenet.api.core.ContentTransfer;
/*      */ import com.filenet.api.core.CustomObject;
/*      */ import com.filenet.api.core.Document;
/*      */ import com.filenet.api.core.Factory.ClassDefinition;
/*      */ import com.filenet.api.core.Factory.ComponentRelationship;
/*      */ import com.filenet.api.core.Factory.ContentElement;
/*      */ import com.filenet.api.core.Factory.ContentTransfer;
/*      */ import com.filenet.api.core.Factory.Document;
/*      */ import com.filenet.api.core.Factory.StringList;
/*      */ import com.filenet.api.core.Folder;
/*      */ import com.filenet.api.core.IndependentObject;
/*      */ import com.filenet.api.core.IndependentlyPersistableObject;
/*      */ import com.filenet.api.core.ObjectStore;
/*      */ import com.filenet.api.core.ReferentialContainmentRelationship;
/*      */ import com.filenet.api.core.UpdatingBatch;
/*      */ import com.filenet.api.core.VersionSeries;
/*      */ import com.filenet.api.core.Versionable;
/*      */ import com.filenet.api.exception.EngineRuntimeException;
/*      */ import com.filenet.api.exception.ExceptionCode;
/*      */ import com.filenet.api.property.Properties;
/*      */ import com.filenet.api.property.Property;
/*      */ import com.filenet.api.property.PropertyContent;
/*      */ import com.filenet.api.property.PropertyDependentObjectList;
/*      */ import com.filenet.api.property.PropertyEngineObject;
/*      */ import com.filenet.api.property.PropertyFilter;
/*      */ import com.filenet.api.property.PropertyIndependentObjectSet;
/*      */ import com.filenet.api.util.Id;
/*      */ import com.ibm.filenet.api.ce.search.Search;
/*      */ import com.ibm.filenet.api.util.ObjectStoreUtil;
/*      */ import java.io.InputStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.lang.StringUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ public class P8DocumentDao
/*      */ {
/*   56 */   private static final Logger logger = Logger.getLogger(P8DocumentDao.class);
/*      */   public static final String DOCUMENT_TITLE = "DocumentTitle";
/*      */ 
/*      */   public static boolean cancelCheckOutDocument(ObjectStore os, String docId)
/*      */   {
/*   61 */     Document doc = fetchDocumentById(os, docId);
/*   62 */     return cancelCheckOutDocument(os, doc);
/*      */   }
/*      */ 
/*      */   public static boolean cancelCheckOutDocument(ObjectStore os, Document doc) {
/*   66 */     boolean flag = false;
/*      */ 
/*   68 */     Document reservation = (Document)doc.get_Reservation();
/*   69 */     doc.cancelCheckout();
/*   70 */     reservation.save(RefreshMode.REFRESH);
/*   71 */     flag = true;
/*      */ 
/*   73 */     return flag;
/*      */   }
/*      */ 
/*      */   public static void changeDocumentClass(ObjectStore os, String docId, String className) {
/*   77 */     Document doc = fetchDocumentById(os, docId);
/*   78 */     changeDocumentClass(doc, className);
/*      */   }
/*      */ 
/*      */   public static void changeDocumentClass(Document doc, String className) {
/*   82 */     doc.changeClass(className);
/*   83 */     doc.save(RefreshMode.REFRESH);
/*      */   }
/*      */ 
/*      */   private static boolean checkInDocument(ObjectStore os, Document doc, Map<String, Object> propMap, ContentElementList contentElementList, CheckinType checkinType) {
/*   87 */     boolean flag = false;
/*      */     try {
/*   89 */       checkInDocument(null, os, doc, propMap, contentElementList, checkinType);
/*   90 */       flag = true;
/*      */     } catch (EngineRuntimeException ex) {
/*   92 */       logger.error("Error occurred when checking in the document '" + doc.get_Id() + "'.");
/*   93 */       throw ex;
/*      */     }
/*   95 */     return flag;
/*      */   }
/*      */ 
/*      */   public static boolean checkInDocumentAsMajor(ObjectStore os, Document doc, Map<String, Object> propMap, ContentElementList contentElementList) {
/*   99 */     return checkInDocument(os, doc, propMap, contentElementList, CheckinType.MAJOR_VERSION);
/*      */   }
/*      */ 
/*      */   private static void checkInDocument(UpdatingBatch ub, ObjectStore os, Document doc, Map<String, Object> propMap, ContentElementList contentElementList, CheckinType checkinType) {
/*      */     try {
/*      */       Document released;
/*      */       try {
/*  107 */         released = (Document)doc.get_Reservation();
/*      */       }
/*      */       catch (Exception e)
/*      */       {
/*      */         Document released;
/*  114 */         released = doc;
/*      */       }
/*      */ 
/*  117 */       Properties props = released.getProperties();
/*  118 */       updateAttributes(props, propMap);
/*      */ 
/*  120 */       setContentElementList(released, contentElementList);
/*  121 */       released.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, checkinType);
/*  122 */       if (ub == null)
/*  123 */         released.save(RefreshMode.REFRESH);
/*      */       else
/*  125 */         P8CustomObjectDao.addToUpdatingBatchUniquly(ub, released);
/*      */     }
/*      */     catch (EngineRuntimeException ex) {
/*  128 */       logger.error("Error occurred when checking in the document '" + doc.get_Id() + "'.");
/*  129 */       throw ex;
/*      */     }
/*      */   }
/*      */ 
/*      */   public static void checkInDocumentAsMajor(UpdatingBatch ub, ObjectStore os, Document doc, Map<String, Object> propMap, ContentElementList contentElementList)
/*      */   {
/*  356 */     checkInDocument(ub, os, doc, propMap, contentElementList, CheckinType.MAJOR_VERSION);
/*      */   }
/*      */ 
/*      */   private static boolean checkInDocument(ObjectStore os, String docId, Map<String, Object> propMap, ContentElementList contentElementList, CheckinType checkinType) {
/*  360 */     boolean flag = false;
/*      */     try {
/*  362 */       Document doc = fetchDocumentById(os, docId);
/*  363 */       flag = checkInDocument(os, doc, propMap, contentElementList, checkinType);
/*      */     } catch (EngineRuntimeException ex) {
/*  365 */       logger.error("Error occurred when checking in the document '" + docId + "'.");
/*  366 */       throw ex;
/*      */     }
/*      */ 
/*  369 */     return flag;
/*      */   }
/*      */ 
/*      */   public static boolean checkInDocumentAsMajor(ObjectStore os, String docId, Map<String, Object> propMap, ContentElementList contentElementList) {
/*  373 */     return checkInDocument(os, docId, propMap, contentElementList, CheckinType.MAJOR_VERSION);
/*      */   }
/*      */ 
/*      */   public static void checkOutDocument(ObjectStore os, Document doc) {
/*  377 */     doc.checkout(ReservationType.OBJECT_STORE_DEFAULT, null, null, null);
/*  378 */     doc.save(RefreshMode.REFRESH);
/*      */   }
/*      */ 
/*      */   public static void checkOutDocument(ObjectStore os, String docId) {
/*  382 */     Document doc = fetchDocumentById(os, docId);
/*  383 */     checkOutDocument(os, doc);
/*      */   }
/*      */ 
/*      */   public static void checkInDocument(ObjectStore os, Document doc, Map<String, Object> propMap, Map<String, InputStream> content) {
/*      */     try {
/*      */       Document released;
/*      */       try {
/*  391 */         released = (Document)doc.get_Reservation();
/*      */       }
/*      */       catch (Exception e)
/*      */       {
/*      */         Document released;
/*  393 */         released = doc;
/*      */       }
/*      */ 
/*  396 */       if (propMap != null) {
/*  397 */         updateAttributes(released.getProperties(), propMap);
/*      */       }
/*  399 */       if ((content != null) && (!content.isEmpty())) {
/*  400 */         ContentElementList contentElementList = Factory.ContentElement.createList();
/*  401 */         Iterator it = content.keySet().iterator();
/*  402 */         while (it.hasNext()) {
/*  403 */           String name = (String)it.next();
/*  404 */           InputStream ins = (InputStream)content.get(name);
/*  405 */           ContentTransfer transfer = Factory.ContentTransfer.createInstance();
/*  406 */           transfer.setCaptureSource(ins);
/*  407 */           transfer.set_RetrievalName(name);
/*  408 */           contentElementList.add(transfer);
/*      */         }
/*  410 */         released.set_ContentElements(contentElementList);
/*      */       }
/*  412 */       released.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
/*  413 */       released.save(RefreshMode.REFRESH);
/*      */     } catch (EngineRuntimeException ex) {
/*  415 */       logger.error("Error occurred when checking in the document '" + doc.get_Id() + "'.");
/*  416 */       throw ex;
/*      */     }
/*      */   }
/*      */ 
/*      */   public static ComponentRelationship createComponentRelationship(ObjectStore os, Document parentDoc, Document childDoc) {
/*  421 */     if (parentDoc.get_CompoundDocumentState().getValue() != 1)
/*  422 */       throw new RuntimeException(parentDoc.get_Id() + "\u6D93\u5D86\u69F8\u6FB6\u5D85\u608E\u93C2\u56E8\u3002");
/*  423 */     ComponentRelationship cr = Factory.ComponentRelationship.createInstance(os, null);
/*  424 */     cr.set_ParentComponent(parentDoc);
/*  425 */     cr.set_ChildComponent(childDoc);
/*  426 */     cr.set_ComponentCascadeDelete(ComponentCascadeDeleteAction.CASCADE_DELETE);
/*  427 */     return cr;
/*      */   }
/*      */ 
/*      */   public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map<String, Object> propMap)
/*      */   {
/*  432 */     return createDocument(os, symbolicName, documentTitle, propMap, false);
/*      */   }
/*      */ 
/*      */   public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map<String, Object> propMap, boolean isCompoundDocument) {
/*  436 */     Document doc = Factory.Document.createInstance(os, symbolicName);
/*      */ 
/*  438 */     Properties props = doc.getProperties();
/*      */ 
/*  440 */     if (propMap != null) {
/*  441 */       String techProcDocId = "techProcDocId";
/*  442 */       String dcoTitle = "DocumentTitle";
/*  443 */       props.putValue(dcoTitle, documentTitle);
/*  444 */       if (propMap.get(techProcDocId) != null) {
/*  445 */         props.putObjectValue(techProcDocId, new Id(propMap.get(techProcDocId).toString()));
/*  446 */         propMap.remove(techProcDocId);
/*      */       }
/*  448 */       if (propMap.get(dcoTitle) != null) {
/*  449 */         propMap.remove(dcoTitle);
/*      */       }
/*  451 */       updateAttributes(props, propMap);
/*      */     }
/*  453 */     if (isCompoundDocument) {
/*  454 */       doc.set_CompoundDocumentState(CompoundDocumentState.COMPOUND_DOCUMENT);
/*      */     }
/*  456 */     doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
/*  457 */     doc.save(RefreshMode.REFRESH);
/*  458 */     return doc;
/*      */   }
/*      */ 
/*      */   public static void updateAttributes(Properties props, Map<String, Object> propMap)
/*      */   {
/*  464 */     if ((propMap != null) && (!propMap.isEmpty()))
/*      */     {
/*  466 */       Iterator it = propMap.keySet().iterator();
/*  467 */       while (it.hasNext()) {
/*  468 */         String key = (String)it.next();
/*  469 */         Object value = propMap.get(key);
/*      */ 
/*  472 */         if ((!props.isPropertyPresent(key)) && (value == null))
/*      */         {
/*      */           continue;
/*      */         }
/*  476 */         if ((value != null) && ((value instanceof List)) && (!(value instanceof StringList))) {
/*  477 */           StringList list = Factory.StringList.createList();
/*  478 */           for (Iterator localIterator1 = ((List)value).iterator(); localIterator1.hasNext(); ) { Object obj = localIterator1.next();
/*  479 */             list.add(obj);
/*      */           }
/*  481 */           value = list;
/*      */         }
/*      */         try
/*      */         {
/*  485 */           if (props.isPropertyPresent(key))
/*  486 */             props.get(key).setObjectValue(value);
/*      */           else
/*  488 */             props.putObjectValue(key, value);
/*      */         } catch (EngineRuntimeException e) {
/*  490 */           throw new RuntimeException("error when set property value. propName: " + key + ", value: " + value, e);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map<String, Object> propMap, ContentElementList contentElementList) {
/*  497 */     return createDocument(os, symbolicName, documentTitle, propMap, false, contentElementList);
/*      */   }
/*      */ 
/*      */   public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map<String, Object> propMap, boolean isCompoundDocument, ContentElementList contentElementList) {
/*  501 */     Document doc = Factory.Document.createInstance(os, symbolicName);
/*      */ 
/*  503 */     if (propMap != null) {
/*  504 */       Properties props = doc.getProperties();
/*  505 */       String docTitle = "documentTitle";
/*  506 */       props.putValue(docTitle, documentTitle);
/*  507 */       if (propMap.get(docTitle) != null) {
/*  508 */         propMap.remove(docTitle);
/*      */       }
/*  510 */       updateAttributes(props, propMap);
/*      */     }
/*      */ 
/*  513 */     if (contentElementList != null) {
/*  514 */       setContentElementList(doc, contentElementList);
/*      */     }
/*      */ 
/*  517 */     if (isCompoundDocument) {
/*  518 */       doc.set_CompoundDocumentState(CompoundDocumentState.COMPOUND_DOCUMENT);
/*      */     }
/*  520 */     doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
/*  521 */     doc.save(RefreshMode.REFRESH);
/*      */ 
/*  523 */     return doc;
/*      */   }
/*      */ 
/*      */   public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map<String, Object> propMap, Folder folder) {
/*  527 */     Document doc = createDocument(os, symbolicName, documentTitle, propMap);
/*      */ 
/*  529 */     ReferentialContainmentRelationship rcr = folder.file(doc, AutoUniqueName.AUTO_UNIQUE, null, DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
/*      */ 
/*  533 */     rcr.save(RefreshMode.NO_REFRESH);
/*      */ 
/*  535 */     return doc;
/*      */   }
/*      */ 
/*      */   public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map<String, Object> propMap, InputStream ins)
/*      */   {
/*  540 */     Document doc = Factory.Document.createInstance(os, symbolicName);
/*      */ 
/*  542 */     if (propMap != null) {
/*  543 */       Properties props = doc.getProperties();
/*  544 */       String docTitle = "DocumentTitle";
/*  545 */       props.putValue(docTitle, documentTitle);
/*  546 */       if (propMap.get(docTitle) != null) {
/*  547 */         propMap.remove(docTitle);
/*      */       }
/*  549 */       updateAttributes(props, propMap);
/*      */     }
/*      */ 
/*  552 */     doc.save(RefreshMode.NO_REFRESH);
/*      */ 
/*  554 */     if (ins != null) {
/*  555 */       ContentElementList contentElementList = Factory.ContentElement.createList();
/*  556 */       ContentTransfer transfer = Factory.ContentTransfer.createInstance();
/*      */ 
/*  558 */       transfer.setCaptureSource(ins);
/*  559 */       transfer.set_RetrievalName(documentTitle);
/*      */ 
/*  561 */       contentElementList.add(transfer);
/*      */ 
/*  563 */       setContentElementList(doc, contentElementList);
/*  564 */       doc.save(RefreshMode.NO_REFRESH);
/*      */     }
/*      */ 
/*  567 */     doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
/*  568 */     doc.save(RefreshMode.REFRESH);
/*      */ 
/*  570 */     return doc;
/*      */   }
/*      */ 
/*      */   public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map<String, Object> propMap, Map<String, InputStream> content)
/*      */   {
/*  575 */     Document doc = Factory.Document.createInstance(os, symbolicName);
/*      */ 
/*  577 */     if (propMap != null) {
/*  578 */       Properties props = doc.getProperties();
/*  579 */       String docTitle = "DocumentTitle";
/*  580 */       props.putValue(docTitle, documentTitle);
/*  581 */       if (propMap.get(docTitle) != null) {
/*  582 */         propMap.remove(docTitle);
/*      */       }
/*  584 */       updateAttributes(props, propMap);
/*      */     }
/*      */ 
/*  587 */     doc.save(RefreshMode.NO_REFRESH);
/*      */ 
/*  589 */     if ((content != null) && (!content.isEmpty())) {
/*  590 */       ContentElementList contentElementList = Factory.ContentElement.createList();
/*  591 */       Iterator it = content.keySet().iterator();
/*  592 */       while (it.hasNext()) {
/*  593 */         String name = (String)it.next();
/*  594 */         InputStream ins = (InputStream)content.get(name);
/*  595 */         ContentTransfer transfer = Factory.ContentTransfer.createInstance();
/*  596 */         transfer.setCaptureSource(ins);
/*  597 */         transfer.set_RetrievalName(name);
/*  598 */         contentElementList.add(transfer);
/*      */       }
/*  600 */       setContentElementList(doc, contentElementList);
/*  601 */       doc.save(RefreshMode.NO_REFRESH);
/*      */     }
/*      */ 
/*  604 */     doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
/*  605 */     doc.save(RefreshMode.REFRESH);
/*      */ 
/*  607 */     return doc;
/*      */   }
/*      */ 
/*      */   public static void deleteDocument(Document document) {
/*  611 */     document.delete();
/*  612 */     document.save(RefreshMode.NO_REFRESH);
/*      */   }
/*      */ 
/*      */   public static void deleteDocumentById(ObjectStore os, String docId) {
/*  616 */     Document doc = fetchDocumentById(os, docId);
/*  617 */     deleteDocument(doc);
/*      */   }
/*      */ 
/*      */   public static void deleteDocumentByPath(ObjectStore os, String docPath) {
/*  621 */     Document doc = fetchDocumentByPath(os, docPath);
/*  622 */     deleteDocument(doc);
/*      */   }
/*      */ 
/*      */   public static void deleteDocumentWithAllVersions(ObjectStore os, String docId) {
/*  626 */     Document doc = fetchDocumentById(os, docId);
/*  627 */     deleteDocumentWithAllVersions(doc);
/*      */   }
/*      */ 
/*      */   public static void deleteDocumentWithAllVersions(Document doc) {
/*  631 */     VersionSeries verSeries = doc.get_VersionSeries();
/*  632 */     verSeries.delete();
/*  633 */     verSeries.save(RefreshMode.REFRESH);
/*      */   }
/*      */ 
/*      */   public static Document fetchCurrentVersionDocument(ObjectStore os, String docId) {
/*  637 */     Versionable versionable = fetchDocumentById(os, docId).get_CurrentVersion();
/*  638 */     return versionable == null ? null : (Document)versionable;
/*      */   }
/*      */ 
/*      */   public static Document fetchDocumentById(ObjectStore os, String docId) {
/*  642 */     return fetchDocumentById(os, docId, null);
/*      */   }
/*      */ 
/*      */   public static Document fetchDocumentById(ObjectStore os, String docId, PropertyFilter docPropFilter) {
/*      */     try {
/*  647 */       return Factory.Document.fetchInstance(os, new Id(docId), docPropFilter);
/*      */     } catch (EngineRuntimeException ex) {
/*  649 */       if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND) {
/*  650 */         logger.error(ex.getMessage());
/*  651 */         return null;
/*      */       }
/*      */     }
/*  653 */     throw ex;
/*      */   }
/*      */ 
/*      */   public static Document fetchDocumentByPath(ObjectStore os, String docPath)
/*      */   {
/*  658 */     return fetchDocumentByPath(os, docPath, null);
/*      */   }
/*      */ 
/*      */   public static Document fetchDocumentByPath(ObjectStore os, String docPath, PropertyFilter docPropFilter) {
/*      */     try {
/*  663 */       return Factory.Document.fetchInstance(os, docPath, docPropFilter);
/*      */     } catch (EngineRuntimeException ex) {
/*  665 */       if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND) {
/*  666 */         logger.warn("Document cannot be found by path '" + docPath + "'.");
/*  667 */         return null;
/*      */       }
/*      */     }
/*  669 */     throw ex;
/*      */   }
/*      */ 
/*      */   public static Document fetchReservedDocument(ObjectStore os, String docId)
/*      */   {
/*  674 */     IndependentObject ido = fetchDocumentById(os, docId).get_Reservation();
/*  675 */     return ido == null ? null : (Document)ido;
/*      */   }
/*      */ 
/*      */   public static void file(Document doc, Folder folder) {
/*  679 */     file(null, doc, folder);
/*      */   }
/*      */ 
/*      */   public static void file(UpdatingBatch ub, Document doc, Folder folder)
/*      */   {
/*  685 */     Iterator it = doc.get_FoldersFiledIn().iterator();
/*  686 */     while (it.hasNext()) {
/*  687 */       if (((Folder)it.next()).get_Id().equals(folder.get_Id())) {
/*  688 */         logger.warn("\u95B2\u5D85\uE632File: DocumentID:" + doc.get_Id() + ",FolderId:" + folder.get_Id());
/*  689 */         return;
/*      */       }
/*      */     }
/*      */ 
/*  693 */     ReferentialContainmentRelationship rcr = folder.file(doc, AutoUniqueName.AUTO_UNIQUE, null, DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
/*      */ 
/*  700 */     if (ub == null)
/*  701 */       rcr.save(RefreshMode.NO_REFRESH);
/*  702 */     else if (ub.hasPendingExecute())
/*  703 */       P8CustomObjectDao.addToUpdatingBatchUniquly(ub, rcr);
/*      */   }
/*      */ 
/*      */   public static void file(IndependentlyPersistableObject independentlyPersistableObject, Folder folder, String containmentName)
/*      */   {
/*  708 */     ReferentialContainmentRelationship rcr = folder.file(independentlyPersistableObject, AutoUniqueName.AUTO_UNIQUE, null, DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
/*  709 */     if ((containmentName != null) && (!containmentName.equals("")))
/*  710 */       rcr.set_ContainmentName(containmentName);
/*  711 */     rcr.save(RefreshMode.NO_REFRESH);
/*      */   }
/*      */ 
/*      */   public static void file(ObjectStore os, String docId, String folderId) {
/*  715 */     Folder folder = P8FolderDao.fetchFolderById(os, folderId);
/*  716 */     Document doc = fetchDocumentById(os, docId);
/*  717 */     file(doc, folder);
/*      */   }
/*      */ 
/*      */   public static List<Document> getAllVersionDocuments(ObjectStore os, String docId) {
/*  721 */     List items = new ArrayList();
/*  722 */     Document doc = fetchDocumentById(os, docId);
/*  723 */     VersionableSet versions = doc.get_Versions();
/*  724 */     Iterator it = versions.iterator();
/*  725 */     while (it.hasNext()) {
/*  726 */       Document subDoc = (Document)it.next();
/*  727 */       items.add(subDoc);
/*      */     }
/*  729 */     return items;
/*      */   }
/*      */ 
/*      */   public static Map<String, Object> getCEObjectProperties(ObjectStore os, String docId)
/*      */   {
/*  734 */     Map map = new HashMap();
/*  735 */     Document doc = fetchDocumentById(os, docId);
/*      */ 
/*  737 */     Properties ps = doc.getProperties();
/*  738 */     String className = doc.getClassName();
/*  739 */     ClassDefinition objClzDef = Factory.ClassDefinition.fetchInstance(os, className, null);
/*  740 */     PropertyDefinitionList pdd = objClzDef.get_PropertyDefinitions();
/*  741 */     for (Iterator itp = pdd.iterator(); itp.hasNext(); ) {
/*  742 */       PropertyDefinition pd = (PropertyDefinition)itp.next();
/*  743 */       if (!pd.get_IsSystemOwned().booleanValue()) {
/*  744 */         String propName = pd.get_SymbolicName();
/*  745 */         Object obj = ps.getObjectValue(propName);
/*  746 */         propName = StringUtils.uncapitalize(propName);
/*  747 */         map.put(propName, obj);
/*      */       }
/*      */     }
/*  750 */     map.put("id", docId);
/*      */ 
/*  753 */     return map;
/*      */   }
/*      */ 
/*      */   public static InputStream getContentElement(ObjectStore os, String docId, int index) {
/*  757 */     Document doc = fetchDocumentById(os, docId);
/*  758 */     ContentElementList contentList = doc.get_ContentElements();
/*  759 */     ContentTransfer transfer = (ContentTransfer)contentList.get(index);
/*      */ 
/*  761 */     return transfer.accessContentStream();
/*      */   }
/*      */ 
/*      */   public static boolean isCheckedOut(ObjectStore os, String docId) {
/*  765 */     return fetchReservedDocument(os, docId) != null;
/*      */   }
/*      */ 
/*      */   public static Map<String, Object> iterateDocumentAttributes(ObjectStore os, Document doc) {
/*  769 */     return ObjectStoreUtil.iterateAttributes(os, doc);
/*      */   }
/*      */ 
/*      */   public static Map<String, Object> iterateDocumentAttributesById(ObjectStore os, String docId) {
/*  773 */     Document doc = fetchDocumentById(os, docId);
/*  774 */     return iterateDocumentAttributes(os, doc);
/*      */   }
/*      */ 
/*      */   public static Map<String, Object> iterateDocumentAttributesByPath(ObjectStore os, String docPath) {
/*  778 */     Document doc = fetchDocumentByPath(os, docPath);
/*  779 */     return iterateDocumentAttributes(os, doc);
/*      */   }
/*      */ 
/*      */   public static List<Document> listContainedDocuments(Folder parent) {
/*  783 */     List docList = new ArrayList();
/*      */ 
/*  785 */     DocumentSet docSet = parent.get_ContainedDocuments();
/*      */ 
/*  787 */     Iterator iterator = docSet.iterator();
/*  788 */     while (iterator.hasNext()) {
/*  789 */       Document doc = (Document)iterator.next();
/*  790 */       docList.add(doc);
/*      */     }
/*      */ 
/*  793 */     return docList;
/*      */   }
/*      */ 
/*      */   public static List<Document> listContainedDocumentsById(ObjectStore os, String parentId) {
/*  797 */     Folder parent = P8FolderDao.fetchFolderById(os, parentId);
/*  798 */     return listContainedDocuments(parent);
/*      */   }
/*      */ 
/*      */   public static List<Document> listContainedDocumentsByPath(ObjectStore os, String parentPath) {
/*  802 */     Folder parent = P8FolderDao.fetchFolderByPath(os, parentPath);
/*  803 */     return listContainedDocuments(parent);
/*      */   }
/*      */ 
/*      */   public static List<CustomObject> listCustomObjects(ObjectStore os, String symbolicName) {
/*  807 */     Search search = new Search();
/*  808 */     return search.setObjectSql(symbolicName, false, null, null, "").setScope(os).setPropertyFilter().fetchCustomObjects();
/*      */   }
/*      */ 
/*      */   public static List<Document> listDocuments(ObjectStore os, String symbolicName, boolean includeSubclasses) {
/*  812 */     Search search = new Search();
/*  813 */     return search.setObjectSql(symbolicName, includeSubclasses, null, null, "").setScope(os).setPropertyFilter().fetchDocuments();
/*      */   }
/*      */ 
/*      */   public static List<Document> searchForDocuments(ObjectStore os, String symbolicClassName, String whereClause) {
/*  817 */     Search search = new Search();
/*  818 */     return search.setObjectSql(symbolicClassName, false, whereClause, null, "").setScope(os).setPropertyFilter().fetchDocuments();
/*      */   }
/*      */ 
/*      */   public static List<Document> searchForDocuments(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause) {
/*  822 */     return searchForDocuments(os, symbolicClassName, includeSubclasses, whereClause, null);
/*      */   }
/*      */ 
/*      */   public static List<Document> searchForDocuments(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause, List<String> selectList) {
/*  826 */     return searchForDocuments(os, symbolicClassName, includeSubclasses, whereClause, selectList, -1);
/*      */   }
/*      */ 
/*      */   public static List<Document> searchForDocuments(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause, List<String> selectList, int maxRecords) {
/*  830 */     Search search = new Search();
/*  831 */     return search.setObjectSql(symbolicClassName, includeSubclasses, whereClause, null, selectList, maxRecords).setScope(os).setPropertyFilter().fetchDocuments();
/*      */   }
/*      */ 
/*      */   public static List<Document> searchForDocumentsCount(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause) {
/*  835 */     Search search = new Search();
/*  836 */     return search.setObjectSql("d.Id", symbolicClassName, includeSubclasses, whereClause, null, -1).setScope(os).setPropertyFilter().fetchDocuments();
/*      */   }
/*      */ 
/*      */   public static List<Document> searchForDocuments(ObjectStore os, String selectClause, String symbolicClassName, boolean includeSubclasses, String whereClause, String orderByClause) {
/*  840 */     boolean distinct = true;
/*  841 */     Search search = new Search();
/*  842 */     return search.setObjectSql(distinct, selectClause, symbolicClassName, includeSubclasses, whereClause, orderByClause).setScope(os).setPropertyFilter().fetchDocuments();
/*      */   }
/*      */ 
/*      */   public static List<Document> searchForDocumentsForFullTextSearch(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords, String searchTitle, List<String> selectList)
/*      */   {
/*  867 */     Search search = new Search();
/*  868 */     return search.setObjectSqlForFullTextSearch(symbolicClassName, includeSubclasses, whereClause, orderByClause, maxRecords, searchTitle, selectList).setScope(os).setPropertyFilter().fetchRows();
/*      */   }
/*      */ 
/*      */   public static void unfile(Document doc, Folder folder)
/*      */   {
/*  886 */     unfile(null, doc, folder);
/*      */   }
/*      */ 
/*      */   public static void unfile(UpdatingBatch ub, Document doc, Folder folder) {
/*  890 */     ReferentialContainmentRelationship rcr = folder.unfile(doc);
/*  891 */     if (ub == null)
/*  892 */       rcr.save(RefreshMode.NO_REFRESH);
/*  893 */     else if (ub.hasPendingExecute())
/*  894 */       P8CustomObjectDao.addToUpdatingBatchUniquly(ub, rcr);
/*      */   }
/*      */ 
/*      */   public static void unfile(ObjectStore os, String docId, String folderId)
/*      */   {
/*  899 */     Folder folder = P8FolderDao.fetchFolderById(os, folderId);
/*  900 */     Document doc = fetchDocumentById(os, docId);
/*  901 */     FolderSet folders = doc.get_FoldersFiledIn();
/*      */ 
/*  903 */     Iterator iter = folders.iterator();
/*  904 */     while (iter.hasNext()) {
/*  905 */       Folder eachFolder = (Folder)iter.next();
/*  906 */       if (eachFolder.get_Id().toString().equalsIgnoreCase(folderId))
/*  907 */         unfile(doc, folder);
/*      */     }
/*      */   }
/*      */ 
/*      */   public static boolean updateAttributes(ObjectStore os, IndependentlyPersistableObject ipo, Map<String, Object> updatedAttrs)
/*      */   {
/*  914 */     return updateAttributes(os, ipo, updatedAttrs, null);
/*      */   }
/*      */ 
/*      */   public static boolean updateAttributes(ObjectStore os, IndependentlyPersistableObject ipo, Map<String, Object> updatedAttrs, UpdatingBatch ub) {
/*  918 */     boolean flag = false;
/*      */ 
/*  920 */     if ((updatedAttrs == null) || (updatedAttrs.isEmpty())) {
/*  921 */       return true;
/*      */     }
/*  923 */     Properties props = ipo.getProperties();
/*  924 */     String techProcDocId = "techProcDocId";
/*  925 */     if (updatedAttrs.get(techProcDocId) != null) {
/*  926 */       props.putObjectValue(techProcDocId, new Id(updatedAttrs.get(techProcDocId).toString()));
/*  927 */       updatedAttrs.remove(techProcDocId);
/*      */     }
/*  929 */     updateAttributes(props, updatedAttrs);
/*  930 */     if (ub == null)
/*  931 */       ipo.save(RefreshMode.REFRESH);
/*      */     else {
/*  933 */       P8CustomObjectDao.addToUpdatingBatchUniquly(ub, ipo);
/*      */     }
/*  935 */     flag = true;
/*      */ 
/*  937 */     return flag;
/*      */   }
/*      */ 
/*      */   public static void updateDocumentAttribute(ObjectStore os, Document doc, String propertyName, Object propertyValue) {
/*  941 */     updateDocumentAttribute(os, doc, propertyName, propertyValue, null);
/*      */   }
/*      */ 
/*      */   public static void updateDocumentAttribute(ObjectStore os, Document doc, String propertyName, Object propertyValue, UpdatingBatch ub) {
/*  945 */     Map updatedAttrs = new HashMap();
/*  946 */     updatedAttrs.put(propertyName, propertyValue);
/*  947 */     updateAttributes(os, doc, updatedAttrs, ub);
/*      */   }
/*      */ 
/*      */   public static void updateDocumentAttributes(ObjectStore os, Document doc, Map<String, Object> updatedAttrs) {
/*  951 */     updateAttributes(os, doc, updatedAttrs);
/*      */   }
/*      */ 
/*      */   public static void updateDocumentAttributes(ObjectStore os, String docId, String symbolicClassName, Map<String, Object> updatedAttrs) {
/*  955 */     updateAttributes(os, fetchDocumentById(os, docId), updatedAttrs);
/*      */   }
/*      */ 
/*      */   public static FolderSet getFiledFolders(ObjectStore os, String docId) {
/*  959 */     Document document = fetchDocumentById(os, docId);
/*  960 */     FolderSet result = document.get_FoldersFiledIn();
/*  961 */     return result;
/*      */   }
/*      */ 
/*      */   public static void move(ObjectStore os, Document doc, Folder destFolder, Folder origFolder)
/*      */   {
/*  966 */     UpdatingBatch ub = UpdatingBatch.createUpdatingBatchInstance(os.get_Domain(), RefreshMode.REFRESH);
/*  967 */     ReferentialContainmentRelationship rcr1 = origFolder.unfile(doc);
/*  968 */     P8CustomObjectDao.addToUpdatingBatchUniquly(ub, rcr1);
/*  969 */     ReferentialContainmentRelationship rcr = destFolder.file(doc, AutoUniqueName.AUTO_UNIQUE, null, DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
/*  970 */     rcr.set_ContainmentName(doc.getProperties().getStringValue("DocumentTitle"));
/*      */ 
/*  972 */     P8CustomObjectDao.addToUpdatingBatchUniquly(ub, rcr);
/*  973 */     ub.updateBatch();
/*      */   }
/*      */ 
/*      */   public static void setContentElementList(Document reservation, ContentElementList contentElementList) {
/*  977 */     reservation.set_ContentElements(contentElementList);
/*      */   }
/*      */ 
/*      */   public static ContentElementList copyContentElementList(ContentElementList contentElementList)
/*      */   {
/*  982 */     ContentElementList newEleList = null;
/*  983 */     if ((contentElementList != null) && (contentElementList.size() > 0)) {
/*  984 */       newEleList = Factory.ContentElement.createList();
/*      */ 
/*  986 */       Iterator it = contentElementList.iterator();
/*  987 */       while (it.hasNext()) {
/*  988 */         ContentTransfer originalElement = (ContentTransfer)it.next();
/*  989 */         ContentTransfer newElement = Factory.ContentTransfer.createInstance();
/*  990 */         newElement.setCaptureSource(originalElement.accessContentStream());
/*  991 */         newElement.set_RetrievalName(originalElement.get_RetrievalName());
/*  992 */         newElement.set_ContentType(originalElement.get_ContentType());
/*  993 */         newEleList.add(newElement);
/*      */       }
/*      */     }
/*  996 */     return newEleList;
/*      */   }
/*      */ 
/*      */   public static Document copyDocument(ObjectStore os, Document destDoc, Document origDoc, boolean isDelOrigDoc, boolean isCopyPermission, List<String> ignoreProps)
/*      */   {
/* 1001 */     Document tempDestDoc = destDoc;
/* 1002 */     boolean isCreate = tempDestDoc == null;
/* 1003 */     if (!isCreate) {
/* 1004 */       if (!tempDestDoc.get_IsCurrentVersion().booleanValue()) {
/* 1005 */         tempDestDoc = (Document)tempDestDoc.get_CurrentVersion();
/*      */       }
/* 1007 */       if (!tempDestDoc.get_IsReserved().booleanValue()) {
/* 1008 */         checkOutDocument(os, tempDestDoc);
/*      */       }
/*      */     }
/*      */ 
/* 1012 */     Properties orig = origDoc.getProperties();
/*      */ 
/* 1014 */     if (ignoreProps == null) {
/* 1015 */       ignoreProps = new ArrayList();
/*      */     }
/* 1017 */     Map propMap = new HashMap();
/* 1018 */     Iterator it1 = orig.iterator();
/* 1019 */     while (it1.hasNext()) {
/* 1020 */       Property pro_orig = (Property)it1.next();
/*      */ 
/* 1023 */       if (ignoreProps.contains(pro_orig.getPropertyName()))
/*      */       {
/*      */         continue;
/*      */       }
/* 1027 */       if (((pro_orig instanceof PropertyIndependentObjectSet)) || ((pro_orig instanceof PropertyEngineObject)) || ((pro_orig instanceof PropertyDependentObjectList)) || ((pro_orig instanceof PropertyContent)))
/*      */       {
/*      */         continue;
/*      */       }
/* 1031 */       boolean isSettable = false;
/* 1032 */       if (isCreate)
/* 1033 */         isSettable = pro_orig.isSettable();
/* 1034 */       else if (tempDestDoc.getProperties().isPropertyPresent(pro_orig.getPropertyName()))
/* 1035 */         isSettable = tempDestDoc.getProperties().get(pro_orig.getPropertyName()).isSettable();
/* 1036 */       if (!isSettable) {
/*      */         continue;
/*      */       }
/* 1039 */       if (isCreate) {
/* 1040 */         propMap.put(pro_orig.getPropertyName(), orig.getObjectValue(pro_orig.getPropertyName()));
/*      */       } else {
/* 1042 */         Properties dest = tempDestDoc.getProperties();
/* 1043 */         if (dest.isPropertyPresent(pro_orig.getPropertyName())) {
/* 1044 */           Property pro_dest = dest.get(pro_orig.getPropertyName());
/* 1045 */           if ((pro_dest.isSettable()) && (pro_orig.getClass().equals(pro_dest.getClass()))) {
/* 1046 */             propMap.put(pro_dest.getPropertyName(), orig.getObjectValue(pro_dest.getPropertyName()));
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1053 */     ContentElementList newEleList = copyContentElementList(origDoc.get_ContentElements());
/*      */ 
/* 1055 */     if (isCreate) {
/* 1056 */       String documentTitle = propMap.get("DocumentTitle") == null ? null : propMap.get("DocumentTitle").toString();
/* 1057 */       tempDestDoc = createDocument(os, origDoc.getClassName(), documentTitle, propMap, newEleList);
/*      */     } else {
/* 1059 */       checkInDocumentAsMajor(null, os, tempDestDoc, propMap, newEleList);
/*      */     }
/*      */ 
/* 1062 */     if (isCopyPermission) {
/* 1063 */       tempDestDoc.refresh();
/* 1064 */       tempDestDoc = (Document)tempDestDoc.get_ReleasedVersion();
/* 1065 */       tempDestDoc.set_Permissions(origDoc.get_Permissions());
/*      */     }
/*      */ 
/* 1068 */     if (isDelOrigDoc) {
/* 1069 */       origDoc.delete();
/* 1070 */       origDoc.save(RefreshMode.REFRESH);
/*      */     }
/* 1072 */     return (Document)tempDestDoc.get_CurrentVersion();
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.api.ce.P8DocumentDao
 * JD-Core Version:    0.6.0
 */