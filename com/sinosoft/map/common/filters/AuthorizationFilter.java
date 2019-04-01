/*     */ package com.sinosoft.map.common.filters;
/*     */ 
/*     */ import com.sinosoft.map.common.WebApplication;
/*     */ import com.sinosoft.map.common.WebVisitor;
/*     */ import com.sinosoft.map.common.WebVisitorEngine;
/*     */ import com.sinosoft.map.common.config.AccessauthConfig;
/*     */ import com.sinosoft.map.common.logs.ErrorsLog;
/*     */ import com.sinosoft.map.ec.utility.ECPubFun;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Map;
/*     */ import javax.servlet.Filter;
/*     */ import javax.servlet.FilterChain;
/*     */ import javax.servlet.FilterConfig;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class AuthorizationFilter
/*     */   implements Filter
/*     */ {
/*  27 */   private FilterConfig filterConfig = null;
/*  28 */   private static final String DISAUTH_URI = "/" + WebApplication.getInstance().get_URIPrefix() + "/index.jsf";
/*     */   private static final String DISAUTH_URI_MANAGER = "/admin.jsf";
/*     */ 
/*     */   public AuthorizationFilter()
/*     */   {
/*  31 */     System.out.println("========\u542F\u52A8\u76EE\u5F55\u8BBF\u95EE\u6743\u9650\u8FC7\u6EE4\u5668========");
/*     */   }
/*     */ 
/*     */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/*     */     throws IOException, ServletException
/*     */   {
/*  39 */     HttpServletRequest requestHttp = (HttpServletRequest)request;
/*  40 */     HttpServletResponse responseHttp = (HttpServletResponse)response;
/*     */ 
/*  45 */     if (!checkAuthorization(requestHttp)) {
/*  46 */       System.out.println("\u62D2\u7EDD\u8BBF\u95EE...");
/*  47 */       String uri = requestHttp.getRequestURI();
/*     */ 
/*  50 */       if (uri.indexOf("/sysmanage/") != -1)
/*     */       {
/*  53 */         ECPubFun.redirect2("/admin.jsf");
/*     */       }
/*     */       else
/*     */       {
/*  58 */         ECPubFun.redirect2(DISAUTH_URI);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*     */       try {
/*  64 */         if (!WebApplication.getInstance().getVisitorsOper().checkAllow(requestHttp.getRemoteAddr()))
/*     */         {
/*  68 */           responseHttp.setContentType("text/html; charset=UTF-8");
/*  69 */           PrintWriter out = responseHttp.getWriter();
/*  70 */           out.write("<HTML>\r\n");
/*  71 */           out.write("<HEAD>\r\n");
/*  72 */           out.write("<TITLE>\u8BBF\u95EE\u53D7\u9650</TITLE>\r\n");
/*  73 */           out.write("</HEAD>\r\n");
/*  74 */           out.write("<BODY>\r\n");
/*  75 */           out.write("\r\n");
/*  76 */           out.write("<center>IP\u5730\u5740\uFF1A" + requestHttp.getRemoteAddr() + "\u8BBF\u95EE\u53D7\u9650.</center></BODY>\r\n");
/*  77 */           out.write("</HTML>\r\n");
/*  78 */           out.write("\r\n");
/*  79 */           return;
/*     */         }
/*  81 */         String url = requestHttp.getServletPath();
/*     */ 
/*  83 */         if (WebApplication.getInstance().isWebStatistics())
/*     */         {
/*  85 */           url.indexOf("index.jsf");
/*     */         }
/*     */ 
/*  94 */         if ((url.indexOf("sysmanage") > -1) || (url.indexOf("rightsmanage") > -1) || 
/*  95 */           (url.indexOf("productsmanage") > -1) || (url.indexOf("sysReport") > -1))
/*     */         {
/*  97 */           WebApplication app = WebApplication.getInstance();
/*  98 */           Map VisitorList = app.get_webVisitorEngine().getVisitors();
/*  99 */           if ((VisitorList != null) && (VisitorList.size() > 0))
/*     */           {
/* 101 */             HttpSession session = requestHttp.getSession();
/* 102 */             WebVisitor visitor = (WebVisitor)VisitorList.get(session.getId());
/* 103 */             if ((visitor == null) || (!visitor.isLogin()))
/*     */             {
/* 110 */               responseHttp.sendRedirect(requestHttp.getContextPath() + "/admin.jsf");
/* 111 */               return;
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 116 */             responseHttp.sendRedirect(requestHttp.getContextPath() + "/admin.jsf");
/*     */ 
/* 118 */             return;
/*     */           }
/*     */         }
/*     */ 
/* 122 */         chain.doFilter(request, response);
/*     */       }
/*     */       catch (Throwable t)
/*     */       {
/* 126 */         ErrorsLog.log("AuthorizationFilter:doFilter:" + t.getMessage());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private boolean checkAuthorization(HttpServletRequest request) throws IOException
/*     */   {
/* 133 */     String uri = request.getRequestURI();
/* 134 */     WebVisitor visitor = getVisitor(request);
/*     */ 
/* 137 */     AccessauthConfig auth = WebApplication.getInstance().getAuthConf();
/* 138 */     return auth.isAllow(uri, visitor);
/*     */   }
/*     */ 
/*     */   private WebVisitor getVisitor(HttpServletRequest request)
/*     */   {
/* 143 */     WebVisitor visitor = null;
/*     */ 
/* 145 */     HttpSession session = request.getSession(false);
/*     */     try
/*     */     {
/* 148 */       visitor = (WebVisitor)session.getAttribute("webVisitor");
/*     */     }
/*     */     catch (Exception localException) {
/*     */     }
/* 152 */     return visitor;
/*     */   }
/*     */ 
/*     */   public FilterConfig getFilterConfig()
/*     */   {
/* 157 */     return this.filterConfig;
/*     */   }
/*     */ 
/*     */   public void setFilterConfig(FilterConfig filterConfig)
/*     */   {
/* 162 */     this.filterConfig = filterConfig;
/*     */   }
/*     */ 
/*     */   public void destroy()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void init(FilterConfig filterConfig)
/*     */   {
/* 171 */     this.filterConfig = filterConfig;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.filters.AuthorizationFilter
 * JD-Core Version:    0.6.0
 */