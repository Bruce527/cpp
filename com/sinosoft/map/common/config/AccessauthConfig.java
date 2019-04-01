/*    */ package com.sinosoft.map.common.config;
/*    */ 
/*    */ import com.sinosoft.map.common.WebVisitor;
/*    */ import com.sinosoft.map.common.logs.ErrorsLog;
/*    */ import com.sinosoft.map.ec.utility.XmlParser;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import org.w3c.dom.Document;
/*    */ import org.w3c.dom.Element;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class AccessauthConfig extends BaseConfig
/*    */ {
/*    */   private Map<String, List<String>> _auths;
/*    */ 
/*    */   public AccessauthConfig(String authsPath)
/*    */   {
/* 21 */     init(authsPath);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 26 */     return "Auth.class";
/*    */   }
/*    */ 
/*    */   public boolean isAllow(String uri, WebVisitor visitor)
/*    */   {
/* 33 */     boolean isOk = true;
/* 34 */     if (this._auths != null) {
/* 35 */       Set keys = this._auths.keySet();
/* 36 */       for (String key : keys) {
/* 37 */         System.out.println(uri + "--------------------------" + key);
/*    */ 
/* 40 */         if (uri.indexOf(key) == -1) {
/*    */           continue;
/*    */         }
/* 43 */         if ((visitor == null) || (!visitor.isLogin()))
/*    */         {
/* 45 */           return false;
/*    */         }
/*    */ 
/* 49 */         isOk = true;
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 58 */     return isOk;
/*    */   }
/*    */ 
/*    */   public Map<String, List<String>> getAuths()
/*    */   {
/* 63 */     return this._auths;
/*    */   }
/*    */ 
/*    */   private void init(String authsPath)
/*    */   {
/*    */     try {
/* 69 */       this._auths = new HashMap();
/* 70 */       Document doc = XmlParser.getDocument(authsPath);
/* 71 */       Element root = doc.getDocumentElement();
/* 72 */       NodeList authorizations = root.getElementsByTagName("auth");
/*    */ 
/* 74 */       for (int i = 0; i < authorizations.getLength(); i++) {
/* 75 */         Element auth = (Element)authorizations.item(i);
/*    */ 
/* 77 */         String uri = auth.getElementsByTagName("uri").item(0).getTextContent().trim();
/* 78 */         List groupsList = new ArrayList();
/* 79 */         Element userGroups = (Element)auth.getElementsByTagName("groups").item(0);
/* 80 */         NodeList groups = userGroups.getElementsByTagName("group");
/* 81 */         for (int n = 0; n < groups.getLength(); n++) {
/* 82 */           String group = groups.item(n).getTextContent().trim();
/* 83 */           if (group != null) {
/* 84 */             groupsList.add(group);
/*    */           }
/*    */         }
/*    */ 
/* 88 */         this._auths.put(uri, groupsList);
/*    */       }
/*    */     }
/*    */     catch (Exception e) {
/* 92 */       ErrorsLog.log("Exception:Auth:init:" + e.getMessage());
/*    */     }
/*    */   }
/*    */ 
/*    */   public void showState() {
/* 97 */     Set keys = this._auths.keySet();
/* 98 */     for (String key : keys) {
/* 99 */       System.out.println("--key:" + key);
/* 100 */       List groups = (List)this._auths.get(key);
/* 101 */       for (String group : groups)
/* 102 */         System.out.println("group:" + group);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.config.AccessauthConfig
 * JD-Core Version:    0.6.0
 */