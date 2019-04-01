/*    */ package com.sinosoft.map.common.config;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import javax.faces.FacesException;
/*    */ import javax.faces.application.ViewExpiredException;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.myfaces.lifecycle.LifecycleImpl;
/*    */ 
/*    */ public class SinosoftLifecycleImpl extends LifecycleImpl
/*    */ {
/*    */   public void execute(FacesContext context)
/*    */   {
/*    */     try
/*    */     {
/* 18 */       super.execute(context);
/*    */     } catch (ViewExpiredException vee) {
/* 20 */       redirect(context);
/*    */     } catch (FacesException fe) {
/* 22 */       throw fe;
/*    */     }
/*    */   }
/*    */ 
/*    */   private void redirect(FacesContext context) {
/*    */     try {
/* 28 */       context.responseComplete();
/* 29 */       context.renderResponse();
/* 30 */       HttpServletResponse response = (HttpServletResponse)context
/* 31 */         .getExternalContext().getResponse();
/* 32 */       HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
/* 33 */       String url = request.getRequestURI();
/* 34 */       System.out.println("LifecycleSinosoftImpl url=" + url);
/* 35 */       response.sendRedirect(url);
/*    */     } catch (ViewExpiredException vex) {
/* 37 */       System.out.println("url redirect javax.faces.application.ViewExpiredException .");
/* 38 */       vex.printStackTrace();
/*    */     } catch (Exception e) {
/* 40 */       System.out.println("url redirect Exception. ");
/* 41 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.config.SinosoftLifecycleImpl
 * JD-Core Version:    0.6.0
 */