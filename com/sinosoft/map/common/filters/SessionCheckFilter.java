/*    */ package com.sinosoft.map.common.filters;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class SessionCheckFilter
/*    */   implements Filter
/*    */ {
/* 16 */   private static int firstRequest = 0;
/*    */ 
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
/* 19 */     HttpServletRequest hreq = (HttpServletRequest)request;
/* 20 */     HttpServletResponse hres = (HttpServletResponse)response;
/* 21 */     HttpSession session = hreq.getSession();
/* 22 */     if (session.isNew()) {
/* 23 */       if (firstRequest == 0) {
/* 24 */         firstRequest += 1;
/*    */       } else {
/* 26 */         System.out.println("--------success---------------------------------------------------");
/* 27 */         hres.sendRedirect("template/doLogin.jsf");
/* 28 */         return;
/*    */       }
/*    */     }
/* 31 */     chain.doFilter(request, response);
/*    */   }
/*    */ 
/*    */   public void init(FilterConfig filterConfig)
/*    */     throws ServletException
/*    */   {
/*    */   }
/*    */ 
/*    */   public void destroy()
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.filters.SessionCheckFilter
 * JD-Core Version:    0.6.0
 */