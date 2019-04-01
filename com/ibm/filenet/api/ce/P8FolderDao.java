/*     */ package com.ibm.filenet.api.ce;
/*     */ 
/*     */ import com.filenet.api.collection.FolderSet;
/*     */ import com.filenet.api.constants.RefreshMode;
/*     */ import com.filenet.api.core.Factory.Folder;
/*     */ import com.filenet.api.core.Folder;
/*     */ import com.filenet.api.core.ObjectStore;
/*     */ import com.filenet.api.exception.EngineRuntimeException;
/*     */ import com.filenet.api.exception.ExceptionCode;
/*     */ import com.filenet.api.property.Properties;
/*     */ import com.filenet.api.property.PropertyFilter;
/*     */ import com.filenet.api.util.Id;
/*     */ import com.ibm.filenet.api.ce.search.Search;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class P8FolderDao
/*     */ {
/*  26 */   private static final Logger logger = Logger.getLogger(P8FolderDao.class);
/*     */ 
/*     */   public static Folder createFolder(ObjectStore os, Folder parent, String folderName) {
/*  29 */     Folder folder = Factory.Folder.createInstance(os, null);
/*  30 */     folder.set_Parent(parent);
/*  31 */     folder.set_FolderName(folderName);
/*  32 */     folder.save(RefreshMode.REFRESH);
/*     */ 
/*  34 */     return folder;
/*     */   }
/*     */ 
/*     */   public static Folder createFolder(ObjectStore os, String symbolicName, Folder parent, String folderName) {
/*  38 */     Folder folder = Factory.Folder.createInstance(os, symbolicName);
/*  39 */     folder.set_Parent(parent);
/*  40 */     folder.set_FolderName(folderName);
/*  41 */     folder.save(RefreshMode.REFRESH);
/*     */ 
/*  43 */     return folder;
/*     */   }
/*     */ 
/*     */   public static Folder createFolder(ObjectStore os, String symbolicName, Folder parent, String folderName, Map<String, Object> propMap) {
/*  47 */     if ((propMap == null) || (propMap.isEmpty())) {
/*  48 */       throw new RuntimeException("Property map is null or empty.");
/*     */     }
/*  50 */     Folder folder = Factory.Folder.createInstance(os, symbolicName);
/*  51 */     folder.set_Parent(parent);
/*  52 */     folder.set_FolderName(folderName);
/*  53 */     Set propKeySet = propMap.keySet();
/*  54 */     Properties props = folder.getProperties();
/*  55 */     for (String propName : propKeySet) {
/*  56 */       Object obj = propMap.get(propName);
/*  57 */       if (obj != null) {
/*  58 */         props.putObjectValue(propName, propMap.get(propName));
/*     */       }
/*     */     }
/*  61 */     folder.save(RefreshMode.REFRESH);
/*     */ 
/*  63 */     return folder;
/*     */   }
/*     */ 
/*     */   public static Folder createFolderById(ObjectStore os, String parentId, String folderName) {
/*  67 */     Folder parent = fetchFolderById(os, parentId, null);
/*  68 */     return createFolder(os, parent, folderName);
/*     */   }
/*     */ 
/*     */   public static Folder createFolderById(ObjectStore os, String symbolicName, String parentId, String folderName) {
/*  72 */     Folder parent = fetchFolderById(os, parentId, null);
/*  73 */     return createFolder(os, symbolicName, parent, folderName);
/*     */   }
/*     */ 
/*     */   public static Folder createFolderByPath(ObjectStore os, String parentPath, String folderName) {
/*  77 */     Folder parent = fetchFolderByPath(os, parentPath, null);
/*  78 */     return createFolder(os, parent, folderName);
/*     */   }
/*     */ 
/*     */   public static Folder createFolderByPath(ObjectStore os, String symbolicName, String parentPath, String folderName) {
/*  82 */     Folder parent = fetchFolderByPath(os, parentPath, null);
/*  83 */     return createFolder(os, symbolicName, parent, folderName);
/*     */   }
/*     */ 
/*     */   public static void deleteFolder(Folder folder)
/*     */   {
/*  88 */     folder.delete();
/*  89 */     folder.save(RefreshMode.NO_REFRESH);
/*     */   }
/*     */ 
/*     */   public static void deleteFolderById(ObjectStore os, String folderId)
/*     */   {
/*  94 */     Folder folder = fetchFolderById(os, folderId);
/*  95 */     deleteFolder(folder);
/*     */   }
/*     */ 
/*     */   public static Folder fetchFolderById(ObjectStore os, String folderId) {
/*  99 */     return fetchFolderById(os, folderId, null);
/*     */   }
/*     */ 
/*     */   public static Folder fetchFolderById(ObjectStore os, String folderId, PropertyFilter folderPropFilter) {
/*     */     try {
/* 104 */       return Factory.Folder.fetchInstance(os, new Id(folderId), folderPropFilter);
/*     */     } catch (EngineRuntimeException ex) {
/* 106 */       if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND) {
/* 107 */         logger.warn("Folder cannot be found by id '" + folderId + "'.");
/* 108 */         return null;
/*     */       }
/*     */     }
/* 110 */     throw ex;
/*     */   }
/*     */ 
/*     */   public static Folder fetchFolderByPath(ObjectStore os, String folderPath)
/*     */   {
/* 115 */     return fetchFolderByPath(os, folderPath, null);
/*     */   }
/*     */ 
/*     */   public static Folder fetchFolderByPath(ObjectStore os, String folderPath, PropertyFilter folderPropFilter) {
/*     */     try {
/* 120 */       return Factory.Folder.fetchInstance(os, folderPath, folderPropFilter);
/*     */     } catch (EngineRuntimeException ex) {
/* 122 */       if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND) {
/* 123 */         logger.warn("Folder cannot be found by path '" + folderPath + "'.");
/* 124 */         return null;
/*     */       }
/*     */     }
/* 126 */     throw ex;
/*     */   }
/*     */ 
/*     */   public static Folder getRootFolder(ObjectStore os)
/*     */   {
/* 131 */     return os.get_RootFolder();
/*     */   }
/*     */ 
/*     */   public static boolean hasSubfolders(Folder folder) {
/* 135 */     FolderSet folderSet = folder.get_SubFolders();
/*     */ 
/* 137 */     return (folderSet != null) && (!folderSet.isEmpty());
/*     */   }
/*     */ 
/*     */   public static boolean hasSubfoldersById(ObjectStore os, String parentId)
/*     */   {
/* 143 */     Folder parent = fetchFolderById(os, parentId);
/* 144 */     return hasSubfolders(parent);
/*     */   }
/*     */ 
/*     */   public static boolean hasSubfoldersByPath(ObjectStore os, String parentPath) {
/* 148 */     Folder parent = fetchFolderByPath(os, parentPath);
/* 149 */     return hasSubfolders(parent);
/*     */   }
/*     */ 
/*     */   public static List<Folder> listSubfolders(Folder parent) {
/* 153 */     List folderList = new ArrayList();
/*     */ 
/* 155 */     FolderSet folderSet = parent.get_SubFolders();
/*     */ 
/* 157 */     Iterator it = folderSet.iterator();
/* 158 */     while (it.hasNext()) {
/* 159 */       folderList.add((Folder)it.next());
/*     */     }
/*     */ 
/* 162 */     return folderList;
/*     */   }
/*     */ 
/*     */   public static List<Folder> listSubfolders(ObjectStore os) {
/* 166 */     return listSubfolders(getRootFolder(os));
/*     */   }
/*     */ 
/*     */   public static List<Folder> listSubfoldersById(ObjectStore os, String parentId) {
/* 170 */     Folder parent = fetchFolderById(os, parentId);
/* 171 */     return listSubfolders(parent);
/*     */   }
/*     */ 
/*     */   public static List<Folder> listSubfoldersByPath(ObjectStore os, String parentPath) {
/* 175 */     Folder parent = fetchFolderByPath(os, parentPath);
/* 176 */     return listSubfolders(parent);
/*     */   }
/*     */ 
/*     */   public static List<Folder> searchForFolders(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause) {
/* 180 */     Search search = new Search();
/* 181 */     return search.setObjectSql(symbolicClassName, includeSubclasses, whereClause, null, "").setScope(os).setPropertyFilter().fetchFolders();
/*     */   }
/*     */ 
/*     */   public static List<Folder> searchForFolders(ObjectStore os, String symbolicClassName, String whereClause) {
/* 185 */     Search search = new Search();
/* 186 */     return search.setObjectSql(symbolicClassName, false, whereClause, null, "").setScope(os).setPropertyFilter().fetchFolders();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.api.ce.P8FolderDao
 * JD-Core Version:    0.6.0
 */