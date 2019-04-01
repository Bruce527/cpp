/*    */ package com.ibm.filenet.api.ce;
/*    */ 
/*    */ import com.filenet.api.constants.RefreshMode;
/*    */ import com.filenet.api.core.Factory.Link;
/*    */ import com.filenet.api.core.IndependentObject;
/*    */ import com.filenet.api.core.Link;
/*    */ import com.filenet.api.core.ObjectStore;
/*    */ import com.ibm.filenet.api.ce.search.Search;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class P8LinkDao
/*    */ {
/*    */   public static Link createLink(ObjectStore os, String className, IndependentObject head, IndependentObject tail)
/*    */   {
/* 18 */     return createLink(os, className, head, tail, null);
/*    */   }
/*    */ 
/*    */   public static Link createLink(ObjectStore os, String className, IndependentObject head, IndependentObject tail, Map<String, Object> propMap)
/*    */   {
/* 23 */     Link link = Factory.Link.createInstance(os, className);
/* 24 */     P8DocumentDao.updateAttributes(link.getProperties(), propMap);
/* 25 */     link.set_Head(head);
/* 26 */     link.set_Tail(tail);
/* 27 */     link.save(RefreshMode.REFRESH);
/* 28 */     return link;
/*    */   }
/*    */ 
/*    */   public static List<Link> fetchAllLinks(ObjectStore os, String className, String docId)
/*    */   {
/* 33 */     Search search = new Search();
/* 34 */     String whereClause = "(Head = Object('" + docId + "')) or (Tail = Object('" + docId + "'))";
/* 35 */     return search.setObjectSql(className, true, whereClause, null, "").setScope(os).setPropertyFilter().fetchLinks();
/*    */   }
/*    */ 
/*    */   public static List<Link> fetchLinksByTail(ObjectStore os, String className, String tailId)
/*    */   {
/* 40 */     Search search = new Search();
/* 41 */     String whereClause = "(Tail = Object('" + tailId + "'))";
/* 42 */     return search.setObjectSql(className, true, whereClause, null, "").setScope(os).setPropertyFilter().fetchLinks();
/*    */   }
/*    */ 
/*    */   public static List<Link> fetchLinksByHead(ObjectStore os, String className, String headId)
/*    */   {
/* 47 */     Search search = new Search();
/* 48 */     String whereClause = "(Head = Object('" + headId + "'))";
/* 49 */     return search.setObjectSql(className, true, whereClause, null, "").setScope(os).setPropertyFilter().fetchLinks();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.api.ce.P8LinkDao
 * JD-Core Version:    0.6.0
 */