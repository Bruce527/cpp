/*    */ package com.sinosoft.map.common;
/*    */ 
/*    */ import com.sinosoft.map.common.config.AccessauthConfig;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.event.PhaseEvent;
/*    */ import javax.faces.event.PhaseId;
/*    */ import javax.faces.event.PhaseListener;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class MainListener
/*    */   implements PhaseListener
/*    */ {
/* 25 */   private FilterConfig filterConfig = null;
/*    */   private static final String DISAUTH_URI = "/error/404.jsf";
/*    */   private static final String DISAUTH_URI_MANAGER = "/error/404.jsf";
/* 29 */   private static int firstRequest = 0;
/* 30 */   public static HashMap sessionMap = new HashMap();
/*    */ 
/* 32 */   public PhaseId getPhaseId() { return PhaseId.RESTORE_VIEW;
/*    */   }
/*    */ 
/*    */   public void beforePhase(PhaseEvent event)
/*    */   {
/* 38 */     System.out.println("Phase \u4E4B\u524D [" + new Date() + "]: " + event.getSource() + "\t" + event.getPhaseId());
/* 39 */     FacesContext facesContext = event.getFacesContext();
/* 40 */     HttpServletResponse responseHttp = (HttpServletResponse)facesContext.getExternalContext().getResponse();
/* 41 */     HttpServletRequest requestHttp = (HttpServletRequest)facesContext.getExternalContext().getRequest();
/* 42 */     HttpSession session = requestHttp.getSession();
/*    */   }
/*    */ 
/*    */   public void afterPhase(PhaseEvent event)
/*    */   {
/*    */   }
/*    */ 
/*    */   private boolean checkAuthorization(HttpServletRequest request)
/*    */     throws IOException
/*    */   {
/* 77 */     String uri = request.getRequestURI();
/* 78 */     WebVisitor visitor = getVisitor(request);
/*    */ 
/* 81 */     AccessauthConfig auth = WebApplication.getInstance().getAuthConf();
/* 82 */     return auth.isAllow(uri, visitor);
/*    */   }
/*    */ 
/*    */   private WebVisitor getVisitor(HttpServletRequest request)
/*    */   {
/* 87 */     WebVisitor visitor = null;
/*    */ 
/* 89 */     HttpSession session = request.getSession(false);
/*    */     try
/*    */     {
/* 92 */       visitor = (WebVisitor)session.getAttribute("webVisitor");
/*    */     }
/*    */     catch (Exception localException) {
/*    */     }
/* 96 */     return visitor;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.MainListener
 * JD-Core Version:    0.6.0
 */