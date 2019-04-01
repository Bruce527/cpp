/*    */ package com.sinosoft.map.common.filters;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ 
/*    */ public class EncodingSetFilter
/*    */   implements Filter
/*    */ {
/*  9 */   protected String encoding = null;
/* 10 */   protected FilterConfig filterConfig = null;
/* 11 */   protected boolean ignore = true;
/*    */ 
/*    */   public void destroy()
/*    */   {
/* 15 */     this.encoding = null;
/* 16 */     this.filterConfig = null;
/*    */   }
/*    */ 
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/*    */     throws IOException, ServletException
/*    */   {
/* 25 */     if ((this.ignore) || (request.getCharacterEncoding() == null))
/*    */     {
/* 27 */       String encoding = selectEncoding(request);
/* 28 */       if (encoding != null)
/*    */       {
/* 30 */         request.setCharacterEncoding(encoding);
/*    */       }
/*    */     }
/*    */ 
/* 34 */     chain.doFilter(request, response);
/*    */   }
/*    */ 
/*    */   public void init(FilterConfig filterConfig)
/*    */     throws ServletException
/*    */   {
/* 42 */     this.filterConfig = filterConfig;
/* 43 */     this.encoding = filterConfig.getInitParameter("encoding");
/* 44 */     String value = filterConfig.getInitParameter("ignore");
/* 45 */     if (value == null)
/*    */     {
/* 47 */       this.ignore = true;
/*    */     }
/* 49 */     else if (value.equalsIgnoreCase("true"))
/*    */     {
/* 51 */       this.ignore = true;
/*    */     }
/* 53 */     else if (value.equalsIgnoreCase("yes"))
/*    */     {
/* 55 */       this.ignore = true;
/*    */     }
/*    */     else
/*    */     {
/* 59 */       this.ignore = false;
/*    */     }
/*    */   }
/*    */ 
/*    */   protected String selectEncoding(ServletRequest request)
/*    */   {
/* 66 */     return this.encoding;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.filters.EncodingSetFilter
 * JD-Core Version:    0.6.0
 */