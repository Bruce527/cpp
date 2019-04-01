/*     */ package com.sinosoft.banklns;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Iterator;
/*     */ import javax.faces.application.Application;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.application.FacesMessage.Severity;
/*     */ import javax.faces.application.NavigationHandler;
/*     */ import javax.faces.component.UIViewRoot;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.faces.context.ResponseStream;
/*     */ import javax.faces.context.ResponseWriter;
/*     */ import javax.faces.render.RenderKit;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ public class NavigationHandleWithAuthImpl extends NavigationHandler
/*     */ {
/*     */   public void handleNavigation(FacesContext context, String fromAction, String outcome)
/*     */   {
/*     */     try
/*     */     {
/*  24 */       FacesContext face = FacesContext.getCurrentInstance();
/*  25 */       HttpServletRequest req = (HttpServletRequest)face.getExternalContext().getRequest();
/*  26 */       String ip = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
/*  27 */       System.out.println("--->ip:" + ip);
/*  28 */       HttpServletResponse rsp = (HttpServletResponse)face.getExternalContext().getResponse();
/*  29 */       rsp.sendRedirect("");
/*  30 */       face.responseComplete();
/*     */     }
/*     */     catch (IOException e) {
/*  33 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/*  38 */     NavigationHandleWithAuthImpl i = new NavigationHandleWithAuthImpl();
/*  39 */     FacesContext context = new FacesContext()
/*     */     {
/*     */       public void setViewRoot(UIViewRoot arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void setResponseWriter(ResponseWriter arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void setResponseStream(ResponseStream arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void responseComplete()
/*     */       {
/*     */       }
/*     */ 
/*     */       public void renderResponse()
/*     */       {
/*     */       }
/*     */ 
/*     */       public void release()
/*     */       {
/*     */       }
/*     */ 
/*     */       public UIViewRoot getViewRoot()
/*     */       {
/*  80 */         return null;
/*     */       }
/*     */ 
/*     */       public ResponseWriter getResponseWriter()
/*     */       {
/*  86 */         return null;
/*     */       }
/*     */ 
/*     */       public ResponseStream getResponseStream()
/*     */       {
/*  92 */         return null;
/*     */       }
/*     */ 
/*     */       public boolean getResponseComplete()
/*     */       {
/*  98 */         return false;
/*     */       }
/*     */ 
/*     */       public boolean getRenderResponse()
/*     */       {
/* 104 */         return false;
/*     */       }
/*     */ 
/*     */       public RenderKit getRenderKit()
/*     */       {
/* 110 */         return null;
/*     */       }
/*     */ 
/*     */       public Iterator<FacesMessage> getMessages(String arg0)
/*     */       {
/* 116 */         return null;
/*     */       }
/*     */ 
/*     */       public Iterator<FacesMessage> getMessages()
/*     */       {
/* 122 */         return null;
/*     */       }
/*     */ 
/*     */       public FacesMessage.Severity getMaximumSeverity()
/*     */       {
/* 128 */         return null;
/*     */       }
/*     */ 
/*     */       public ExternalContext getExternalContext()
/*     */       {
/* 134 */         return null;
/*     */       }
/*     */ 
/*     */       public Iterator<String> getClientIdsWithMessages()
/*     */       {
/* 140 */         return null;
/*     */       }
/*     */ 
/*     */       public Application getApplication()
/*     */       {
/* 146 */         return null;
/*     */       }
/*     */ 
/*     */       public void addMessage(String arg0, FacesMessage arg1)
/*     */       {
/*     */       }
/*     */     };
/* 155 */     String fromAction = "";
/* 156 */     String outcome = "";
/* 157 */     i.handleNavigation(context, fromAction, outcome);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.NavigationHandleWithAuthImpl
 * JD-Core Version:    0.6.0
 */