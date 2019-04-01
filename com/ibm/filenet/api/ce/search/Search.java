/*     */ package com.ibm.filenet.api.ce.search;
/*     */ 
/*     */ import com.filenet.api.collection.IndependentObjectSet;
/*     */ import com.filenet.api.collection.PageIterator;
/*     */ import com.filenet.api.collection.RepositoryRowSet;
/*     */ import com.filenet.api.constants.FilteredPropertyType;
/*     */ import com.filenet.api.constants.JoinComparison;
/*     */ import com.filenet.api.constants.JoinOperator;
/*     */ import com.filenet.api.constants.MergeMode;
/*     */ import com.filenet.api.core.CustomObject;
/*     */ import com.filenet.api.core.Document;
/*     */ import com.filenet.api.core.Factory.Document;
/*     */ import com.filenet.api.core.Folder;
/*     */ import com.filenet.api.core.IndependentObject;
/*     */ import com.filenet.api.core.Link;
/*     */ import com.filenet.api.core.ObjectStore;
/*     */ import com.filenet.api.exception.EngineRuntimeException;
/*     */ import com.filenet.api.exception.ExceptionCode;
/*     */ import com.filenet.api.property.FilterElement;
/*     */ import com.filenet.api.property.Properties;
/*     */ import com.filenet.api.property.Property;
/*     */ import com.filenet.api.property.PropertyFilter;
/*     */ import com.filenet.api.query.RepositoryRow;
/*     */ import com.filenet.api.query.SearchSQL;
/*     */ import com.filenet.api.query.SearchScope;
/*     */ import com.filenet.api.util.Id;
/*     */ import com.ibm.filenet.api.util.EngineCollectionUtils;
/*     */ import com.ibm.filenet.login.CEConfigOptions;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class Search
/*     */ {
/*  38 */   private Logger logger = Logger.getLogger(getClass());
/*     */   private ObjectStore os;
/*     */   private SearchSQL sql;
/*     */   private SearchScope searchScope;
/*     */   private PropertyFilter filter;
/*     */   private int pageSize;
/*     */   private boolean continuable;
/*     */   private int desiredPageIndex;
/*     */ 
/*     */   public Search()
/*     */   {
/*  50 */     this.pageSize = 100;
/*  51 */     this.continuable = true;
/*  52 */     this.desiredPageIndex = 0;
/*     */   }
/*     */ 
/*     */   public int getPageSize() {
/*  56 */     return this.pageSize;
/*     */   }
/*     */ 
/*     */   public Search setPageSize(int pageSize) {
/*  60 */     this.pageSize = pageSize;
/*  61 */     return this;
/*     */   }
/*     */ 
/*     */   public int getDesiredPageIndex() {
/*  65 */     return this.desiredPageIndex;
/*     */   }
/*     */ 
/*     */   public Search setDesiredPageIndex(int desiredPageIndex) {
/*  69 */     this.desiredPageIndex = desiredPageIndex;
/*  70 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setRowSql(String className, boolean includeSubclasses, String searchExpr)
/*     */   {
/*  75 */     this.sql = new SearchSQL();
/*  76 */     this.sql.setSelectList("*");
/*  77 */     this.sql.setFromClauseInitialValue(className, null, includeSubclasses);
/*  78 */     if (!StringUtils.isEmpty(searchExpr)) {
/*  79 */       this.sql.setContainsRestriction(className, searchExpr);
/*     */     }
/*  81 */     if (this.logger.isDebugEnabled()) {
/*  82 */       this.logger.debug("sql: " + this.sql.toString());
/*     */     }
/*  84 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setRowSql(String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords, boolean isFullText)
/*     */   {
/*  89 */     this.sql = new SearchSQL();
/*  90 */     String alias = "d";
/*  91 */     this.sql.setSelectList(alias + ".*, cs.Rank");
/*  92 */     this.sql.setFromClauseInitialValue(className, alias, includeSubclasses);
/*  93 */     if (isFullText) {
/*  94 */       this.sql.setFromClauseAdditionalJoin(JoinOperator.INNER, "ContentSearch", "cs", "d.This", JoinComparison.EQUAL, "cs.QueriedObject", includeSubclasses);
/*     */     }
/*     */ 
/*  97 */     if (!StringUtils.isEmpty(whereClause)) {
/*  98 */       this.sql.setWhereClause(whereClause);
/*     */     }
/* 100 */     if (!StringUtils.isEmpty(orderByClause)) {
/* 101 */       this.sql.setOrderByClause(orderByClause);
/*     */     }
/*     */ 
/* 104 */     if (maxRecords != -1)
/* 105 */       this.sql.setMaxRecords(maxRecords);
/* 106 */     if (this.logger.isDebugEnabled()) {
/* 107 */       this.logger.debug("Search SQL: " + this.sql.toString());
/*     */     }
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setObjectSql(String className, boolean includeSubclasses, String whereClause, List<String> selectList, String orderProperty)
/*     */   {
/* 114 */     return setObjectSql(className, includeSubclasses, whereClause, orderProperty, selectList, -1);
/*     */   }
/*     */ 
/*     */   public Search setObjectSql(String className, boolean includeSubclasses, String whereClause, String orderByClause, List<String> selectList, int maxRecords)
/*     */   {
/* 119 */     this.sql = new SearchSQL();
/*     */ 
/* 122 */     String alias = "d";
/* 123 */     String selectStr = null;
/* 124 */     if ((selectList == null) || (selectList.size() == 0))
/* 125 */       selectStr = alias + ".*";
/*     */     else {
/* 127 */       for (String prop : selectList) {
/* 128 */         selectStr = selectStr + "," + alias + "." + prop;
/*     */       }
/*     */     }
/* 131 */     this.sql.setSelectList(selectStr);
/*     */ 
/* 134 */     this.sql.setFromClauseInitialValue(className, alias, includeSubclasses);
/* 135 */     if (!StringUtils.isEmpty(whereClause)) {
/* 136 */       this.sql.setWhereClause(whereClause);
/*     */     }
/* 138 */     if (!StringUtils.isEmpty(orderByClause)) {
/* 139 */       this.sql.setOrderByClause(orderByClause);
/*     */     }
/* 141 */     if (maxRecords > 0) {
/* 142 */       this.sql.setMaxRecords(maxRecords);
/*     */     }
/* 144 */     if (this.logger.isDebugEnabled()) {
/* 145 */       this.logger.debug("Search SQL: " + this.sql.toString());
/*     */     }
/* 147 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setObjectSql(String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords)
/*     */   {
/* 152 */     this.sql = new SearchSQL();
/*     */ 
/* 154 */     String alias = "d";
/* 155 */     this.sql.setSelectList(alias + ".*");
/* 156 */     this.sql.setFromClauseInitialValue(className, alias, includeSubclasses);
/* 157 */     if (!StringUtils.isEmpty(whereClause)) {
/* 158 */       this.sql.setWhereClause(whereClause);
/*     */     }
/* 160 */     if (!StringUtils.isEmpty(orderByClause)) {
/* 161 */       this.sql.setOrderByClause(orderByClause);
/*     */     }
/*     */ 
/* 164 */     if (maxRecords != -1) {
/* 165 */       this.sql.setMaxRecords(maxRecords);
/*     */     }
/* 167 */     if (this.logger.isDebugEnabled()) {
/* 168 */       this.logger.debug("Search SQL: " + this.sql.toString());
/*     */     }
/* 170 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setObjectSql(String selectClause, String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords)
/*     */   {
/* 175 */     this.sql = new SearchSQL();
/* 176 */     String alias = "d";
/* 177 */     if (StringUtils.isEmpty(selectClause))
/* 178 */       this.sql.setSelectList(alias + ".*");
/*     */     else {
/* 180 */       this.sql.setSelectList(selectClause);
/*     */     }
/* 182 */     this.sql.setFromClauseInitialValue(className, alias, includeSubclasses);
/* 183 */     if (!StringUtils.isEmpty(whereClause)) {
/* 184 */       this.sql.setWhereClause(whereClause);
/*     */     }
/* 186 */     if (!StringUtils.isEmpty(orderByClause)) {
/* 187 */       this.sql.setOrderByClause(orderByClause);
/*     */     }
/*     */ 
/* 190 */     if (maxRecords != -1)
/* 191 */       this.sql.setMaxRecords(maxRecords);
/* 192 */     if (this.logger.isDebugEnabled()) {
/* 193 */       this.logger.debug("Search SQL: " + this.sql.toString());
/*     */     }
/* 195 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setObjectSql(String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords, boolean isFullText)
/*     */   {
/* 200 */     this.sql = new SearchSQL();
/*     */ 
/* 203 */     String alias = "d";
/* 204 */     this.sql.setSelectList(alias + ".*");
/*     */ 
/* 206 */     this.sql.setFromClauseInitialValue(className, alias, includeSubclasses);
/* 207 */     if (isFullText) {
/* 208 */       this.sql.setFromClauseAdditionalJoin(JoinOperator.INNER, "ContentSearch", "cs", "d.This", JoinComparison.EQUAL, "cs.QueriedObject", includeSubclasses);
/* 209 */       this.sql.setWhereClause(" CONTAINS(d.*, 'com')");
/*     */     }
/* 211 */     if ((!StringUtils.isEmpty(whereClause)) || (whereClause.length() > 0)) {
/* 212 */       this.sql.setWhereClause(whereClause);
/*     */     }
/* 214 */     if (!StringUtils.isEmpty(orderByClause)) {
/* 215 */       this.sql.setOrderByClause(orderByClause);
/*     */     }
/*     */ 
/* 218 */     if (maxRecords != -1)
/* 219 */       this.sql.setMaxRecords(maxRecords);
/* 220 */     if (this.logger.isDebugEnabled()) {
/* 221 */       this.logger.debug("Search SQL: " + this.sql.toString());
/*     */     }
/* 223 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setObjectSqlForFullTextSearch(String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords, String searchTile, List<String> selectList) {
/* 227 */     this.sql = new SearchSQL();
/*     */ 
/* 230 */     String alias = "d";
/* 231 */     String selectStr = null;
/* 232 */     if ((selectList == null) || (selectList.size() == 0))
/* 233 */       selectStr = alias + ".*";
/*     */     else {
/* 235 */       for (String prop : selectList) {
/* 236 */         selectStr = selectStr + "," + alias + "." + prop;
/*     */       }
/*     */     }
/*     */ 
/* 240 */     selectStr = selectStr + " , d.Id, d.DateCreated, d.Creator , cs.ContentSummary ";
/*     */ 
/* 242 */     this.sql.setSelectList(selectStr);
/*     */ 
/* 245 */     this.sql.setFromClauseInitialValue(className, alias, includeSubclasses);
/*     */ 
/* 247 */     this.sql.setFromClauseAdditionalJoin(JoinOperator.INNER, "ContentSearch", "cs", "d.This", JoinComparison.EQUAL, "cs.QueriedObject", includeSubclasses);
/*     */ 
/* 249 */     this.sql.setMaxRecords(maxRecords);
/*     */ 
/* 251 */     String newWhereClause = "CONTAINS(*, '" + searchTile + "')";
/* 252 */     if (StringUtils.isNotEmpty(whereClause))
/* 253 */       whereClause = newWhereClause + " AND (" + whereClause + ")";
/* 254 */     this.sql.setWhereClause(newWhereClause);
/*     */ 
/* 256 */     if (!StringUtils.isEmpty(orderByClause)) {
/* 257 */       this.sql.setOrderByClause(orderByClause);
/*     */     }
/*     */ 
/* 260 */     this.logger.debug("\u934F\u3126\u6783\u59AB\uFFFD\u7EF1\u3222\u6B91\u93BC\u6EC5\u50A8\u7487\uE15E\u5F5E Search SQL: " + this.sql.toString());
/*     */ 
/* 262 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setObjectSql(boolean distinct, String className, boolean includeSubclasses, String whereClause, String orderByClause)
/*     */   {
/* 267 */     this.sql = new SearchSQL();
/* 268 */     if (distinct) {
/* 269 */       this.sql.setDistinct();
/*     */     }
/* 271 */     String alias = "d";
/* 272 */     this.sql.setSelectList(alias + ".*");
/* 273 */     this.sql.setFromClauseInitialValue(className, alias, includeSubclasses);
/* 274 */     if (!StringUtils.isEmpty(whereClause)) {
/* 275 */       this.sql.setWhereClause(whereClause);
/*     */     }
/* 277 */     if (!StringUtils.isEmpty(orderByClause)) {
/* 278 */       this.sql.setOrderByClause(orderByClause);
/*     */     }
/* 280 */     if (this.logger.isDebugEnabled()) {
/* 281 */       this.logger.debug("Search SQL: " + this.sql.toString());
/*     */     }
/* 283 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setObjectSql(boolean distinct, String selectClause, String className, boolean includeSubclasses, String whereClause, String orderByClause)
/*     */   {
/* 288 */     this.sql = new SearchSQL();
/* 289 */     if (distinct) {
/* 290 */       this.sql.setDistinct();
/*     */     }
/* 292 */     String alias = "d";
/* 293 */     if (StringUtils.isEmpty(selectClause))
/* 294 */       this.sql.setSelectList(alias + ".*");
/*     */     else {
/* 296 */       this.sql.setSelectList(selectClause);
/*     */     }
/* 298 */     this.sql.setFromClauseInitialValue(className, alias, includeSubclasses);
/* 299 */     if (!StringUtils.isEmpty(whereClause)) {
/* 300 */       this.sql.setWhereClause(whereClause);
/*     */     }
/* 302 */     if (!StringUtils.isEmpty(orderByClause)) {
/* 303 */       this.sql.setOrderByClause(orderByClause);
/*     */     }
/* 305 */     if (this.logger.isDebugEnabled()) {
/* 306 */       this.logger.debug("Search SQL: " + this.sql.toString());
/*     */     }
/* 308 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setObjectSql(boolean distinct, String selectClause, String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords)
/*     */   {
/* 313 */     this.sql = new SearchSQL();
/* 314 */     if (distinct) {
/* 315 */       this.sql.setDistinct();
/*     */     }
/* 317 */     String alias = "d";
/* 318 */     if (StringUtils.isEmpty(selectClause))
/* 319 */       this.sql.setSelectList(alias + ".*");
/*     */     else {
/* 321 */       this.sql.setSelectList(selectClause);
/*     */     }
/* 323 */     this.sql.setFromClauseInitialValue(className, alias, includeSubclasses);
/* 324 */     if (!StringUtils.isEmpty(whereClause)) {
/* 325 */       this.sql.setWhereClause(whereClause);
/*     */     }
/* 327 */     if (!StringUtils.isEmpty(orderByClause)) {
/* 328 */       this.sql.setOrderByClause(orderByClause);
/*     */     }
/*     */ 
/* 331 */     if (maxRecords != -1)
/* 332 */       this.sql.setMaxRecords(maxRecords);
/* 333 */     if (this.logger.isDebugEnabled()) {
/* 334 */       this.logger.debug("Search SQL: " + this.sql.toString());
/*     */     }
/* 336 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setScope(ObjectStore os)
/*     */   {
/* 341 */     this.os = os;
/* 342 */     this.searchScope = new SearchScope(os);
/* 343 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setScope(ObjectStore[] os) {
/* 347 */     this.searchScope = new SearchScope(os, MergeMode.UNION);
/* 348 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setPropertyFilter()
/*     */   {
/* 353 */     PropertyFilter filter = new PropertyFilter();
/* 354 */     filter.setMaxRecursion(1);
/*     */ 
/* 356 */     filter.addIncludeType(new FilterElement(null, null, null, FilteredPropertyType.ANY, null));
/* 357 */     return this;
/*     */   }
/*     */ 
/*     */   public Search setPropertyFilter(PropertyFilter filter)
/*     */   {
/* 362 */     this.filter = filter;
/* 363 */     return this;
/*     */   }
/*     */ 
/*     */   public IndependentObjectSet fetchIndependentObjectSet()
/*     */   {
/* 368 */     return this.searchScope.fetchObjects(this.sql, Integer.valueOf(this.pageSize), this.filter, Boolean.valueOf(this.continuable));
/*     */   }
/*     */ 
/*     */   public List<IndependentObject> fetchObjects()
/*     */   {
/* 373 */     IndependentObjectSet objects = this.searchScope.fetchObjects(this.sql, Integer.valueOf(this.pageSize), this.filter, Boolean.valueOf(this.continuable));
/* 374 */     List independentObjects = new ArrayList();
/* 375 */     for (IndependentObject doc : EngineCollectionUtils.c(objects, IndependentObject.class)) {
/* 376 */       independentObjects.add(doc);
/*     */     }
/* 378 */     return independentObjects;
/*     */   }
/*     */ 
/*     */   public List<CustomObject> fetchCustomObjects()
/*     */   {
/* 383 */     IndependentObjectSet objects = this.searchScope.fetchObjects(this.sql, Integer.valueOf(this.pageSize), this.filter, Boolean.valueOf(this.continuable));
/* 384 */     List customObjects = new ArrayList();
/* 385 */     for (CustomObject co : EngineCollectionUtils.c(objects, CustomObject.class)) {
/* 386 */       customObjects.add(co);
/*     */     }
/* 388 */     return customObjects;
/*     */   }
/*     */ 
/*     */   public List<Document> fetchDocuments()
/*     */   {
/* 393 */     IndependentObjectSet objects = this.searchScope.fetchObjects(this.sql, Integer.valueOf(this.pageSize), this.filter, Boolean.valueOf(this.continuable));
/* 394 */     List documents = new ArrayList();
/* 395 */     for (Document doc : EngineCollectionUtils.c(objects, Document.class)) {
/* 396 */       documents.add(doc);
/*     */     }
/* 398 */     return documents;
/*     */   }
/*     */ 
/*     */   public List<Folder> fetchFolders()
/*     */   {
/* 403 */     IndependentObjectSet objects = this.searchScope.fetchObjects(this.sql, Integer.valueOf(this.pageSize), this.filter, Boolean.valueOf(this.continuable));
/* 404 */     List folders = new ArrayList();
/* 405 */     for (Folder folder : EngineCollectionUtils.c(objects, Folder.class)) {
/* 406 */       folders.add(folder);
/*     */     }
/* 408 */     return folders;
/*     */   }
/*     */ 
/*     */   public List<Link> fetchLinks()
/*     */   {
/* 413 */     IndependentObjectSet objects = this.searchScope.fetchObjects(this.sql, Integer.valueOf(this.pageSize), this.filter, Boolean.valueOf(this.continuable));
/* 414 */     List links = new ArrayList();
/* 415 */     for (Link doc : EngineCollectionUtils.c(objects, Link.class)) {
/* 416 */       links.add(doc);
/*     */     }
/* 418 */     return links;
/*     */   }
/*     */ 
/*     */   public List<Document> fetchRows()
/*     */   {
/* 423 */     RepositoryRowSet rowSet = this.searchScope.fetchRows(this.sql, Integer.valueOf(this.pageSize), this.filter, Boolean.valueOf(this.continuable));
/* 424 */     List docList = new ArrayList();
/* 425 */     for (RepositoryRow row : EngineCollectionUtils.c(rowSet, RepositoryRow.class)) {
/* 426 */       Id docId = row.getProperties().get("Id").getIdValue();
/* 427 */       Document doc = Factory.Document.fetchInstance(this.os, docId, null);
/* 428 */       docList.add(doc);
/*     */     }
/* 430 */     return docList;
/*     */   }
/*     */ 
/*     */   public List<String> queryDBRowsBySql(String propertyName)
/*     */   {
/* 436 */     List propertyNames = new ArrayList();
/* 437 */     RepositoryRowSet rowSet = null;
/*     */     try
/*     */     {
/* 441 */       rowSet = this.searchScope.fetchRows(this.sql, Integer.valueOf(this.pageSize), this.filter, Boolean.valueOf(false));
/* 442 */       Iterator it = rowSet.iterator();
/* 443 */       while (it.hasNext()) {
/* 444 */         RepositoryRow row = (RepositoryRow)it.next();
/* 445 */         propertyNames.add(row.getProperties().getStringValue(propertyName));
/*     */       }
/*     */     } catch (Exception ex) {
/* 448 */       this.logger.error("Error occurred when executing search ", ex);
/* 449 */       throw new RuntimeException(ex);
/*     */     }
/* 451 */     return propertyNames;
/*     */   }
/*     */ 
/*     */   public Pagination fetchDocumentsWithPagination()
/*     */   {
/* 456 */     if (this.desiredPageIndex <= 0) {
/* 457 */       return null;
/*     */     }
/*     */ 
/* 460 */     long sTime1 = new Date().getTime();
/* 461 */     IndependentObjectSet objects = this.searchScope.fetchObjects(this.sql, Integer.valueOf(this.pageSize), this.filter, Boolean.valueOf(this.continuable));
/* 462 */     long sTime3 = new Date().getTime();
/* 463 */     this.logger.debug("\u93CC\u30E8\uE1D7Document\u9470\u6941\u69021:" + (sTime3 - sTime1) + "ms");
/* 464 */     PageIterator pageIter = objects.pageIterator();
/* 465 */     this.logger.debug("\u93CC\u30E8\uE1D7Document\u9470\u6941\u69022:" + (new Date().getTime() - sTime3) + "ms");
/* 466 */     pageIter.setPageSize(this.pageSize);
/*     */ 
/* 468 */     List docList = new ArrayList();
/*     */ 
/* 470 */     int currentPageIndex = 1;
/* 471 */     int totalPages = 0;
/* 472 */     int totalNum = 0;
/*     */     while (true)
/*     */     {
/* 475 */       long sTime2 = new Date().getTime();
/*     */ 
/* 477 */       if (!pageIter.nextPage())
/*     */         break;
/* 479 */       if (currentPageIndex == this.desiredPageIndex)
/*     */       {
/* 481 */         Object[] docs = pageIter.getCurrentPage();
/*     */ 
/* 483 */         for (Object d : docs) {
/* 484 */           Document document = (Document)d;
/*     */ 
/* 486 */           docList.add(document);
/*     */         }
/*     */       }
/*     */ 
/* 490 */       currentPageIndex++;
/* 491 */       totalPages++;
/* 492 */       totalNum += pageIter.getCurrentPage().length;
/*     */ 
/* 494 */       this.logger.debug("\u947E\u5CF0\u5F47\u7ED7\uFFFD" + currentPageIndex + "\u6924\u4F43\uFFFD\u6941\u6902:" + (new Date().getTime() - sTime2) + "ms");
/*     */     }
/*     */ 
/* 497 */     if (this.desiredPageIndex > totalPages) {
/* 498 */       return null;
/*     */     }
/*     */ 
/* 501 */     return new Pagination(docList, this.pageSize, this.desiredPageIndex, totalNum);
/*     */   }
/*     */ 
/*     */   public Pagination fetchDocumentsWithPagination_modified()
/*     */   {
/* 506 */     if (this.desiredPageIndex <= 0) {
/* 507 */       return null;
/*     */     }
/*     */ 
/* 511 */     int pageSizeOfCE = CEConfigOptions.getSearchMaxPageSize();
/*     */ 
/* 513 */     int totalTopCount = 0;
/* 514 */     if (this.pageSize == 2147483647) {
/* 515 */       totalTopCount = 2147483647;
/*     */     }
/*     */     else {
/* 518 */       totalTopCount = this.desiredPageIndex * this.pageSize / pageSizeOfCE * pageSizeOfCE;
/* 519 */       if (totalTopCount == this.desiredPageIndex * this.pageSize)
/* 520 */         totalTopCount++;
/*     */       else {
/* 522 */         totalTopCount += pageSizeOfCE + 1;
/*     */       }
/* 524 */       this.sql.setMaxRecords(totalTopCount);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 529 */       objects = this.searchScope.fetchObjects(this.sql, Integer.valueOf(totalTopCount), this.filter, Boolean.valueOf(true));
/*     */     }
/*     */     catch (EngineRuntimeException e)
/*     */     {
/*     */       IndependentObjectSet objects;
/* 531 */       if (e.getExceptionCode() == ExceptionCode.E_BAD_CLASSID) {
/* 532 */         throw new RuntimeException("\u93CC\u30E8\uE1D7\u9428\u52EB\u578E\u7EEB\u8BB3\u7B09\u701B\u6A3A\u6E6A", e);
/*     */       }
/* 534 */       throw e;
/*     */     }
/*     */     IndependentObjectSet objects;
/* 538 */     PageIterator pageIter = objects.pageIterator();
/*     */ 
/* 540 */     List docs = new ArrayList();
/* 541 */     while (pageIter.nextPage()) {
/* 542 */       Object[] docsOfPage = pageIter.getCurrentPage();
/*     */ 
/* 544 */       for (Object obj : docsOfPage) {
/* 545 */         docs.add(obj);
/*     */       }
/*     */     }
/* 548 */     int totalNum = docs.size();
/* 549 */     this.logger.debug("\u59AB\uFFFD\u7EF1\u3220\u56AD\u9428\u52EC\u6F6F\u9429\uE1BD\u669F\u951B\uFFFD" + totalNum);
/* 550 */     if (totalTopCount == totalNum)
/*     */     {
/* 552 */       docs.remove(totalNum - 1);
/*     */     }
/*     */ 
/* 556 */     List docList = new ArrayList();
/* 557 */     for (Iterator localIterator = docs.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 558 */       Document document = (Document)object;
/* 559 */       docList.add(document);
/*     */     }
/*     */ 
/* 562 */     return new Pagination(docList, this.pageSize, this.desiredPageIndex, totalNum);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.api.ce.search.Search
 * JD-Core Version:    0.6.0
 */