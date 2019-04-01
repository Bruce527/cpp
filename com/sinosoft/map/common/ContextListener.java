/*    */ package com.sinosoft.map.common;
/*    */ 
/*    */ import com.sinosoft.banklns.lnsmodel.BankOperateDeal;
/*    */ import com.sinosoft.map.common.logs.WebLoginLogDB;
/*    */ import com.sinosoft.map.user.UserModel;
/*    */ import java.io.PrintStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletContextEvent;
/*    */ import javax.servlet.ServletContextListener;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import javax.servlet.http.HttpSessionEvent;
/*    */ import javax.servlet.http.HttpSessionListener;
/*    */ 
/*    */ public class ContextListener
/*    */   implements ServletContextListener, HttpSessionListener
/*    */ {
/* 17 */   private ServletContext application = null;
/*    */   BankOperateDeal operateDeal;
/*    */ 
/*    */   public void contextInitialized(ServletContextEvent event)
/*    */   {
/* 23 */     ServletContext sc = event.getServletContext();
/* 24 */     this.application = sc;
/* 25 */     String servletContextPath = sc.getRealPath("/");
/* 26 */     WebApplication app = WebApplication.getInstance();
/* 27 */     System.out.println("------------------------------>" + servletContextPath);
/* 28 */     app.init(servletContextPath);
/* 29 */     sc.setAttribute("WebApplication", app);
/*    */   }
/*    */   public void contextDestroyed(ServletContextEvent event) {
/* 32 */     System.out.println("...sessionDestroyed...");
/*    */   }
/*    */   public void sessionCreated(HttpSessionEvent event) {
/* 35 */     System.out.println("...sessionCreated...");
/* 36 */     System.out.println(event.getSession().getId());
/*    */   }
/*    */ 
/*    */   public void sessionDestroyed(HttpSessionEvent arg0)
/*    */   {
/*    */     try
/*    */     {
/* 43 */       if (arg0 != null)
/*    */       {
/* 45 */         System.out.println("######################################session is overtime######################################");
/* 46 */         this.operateDeal = new BankOperateDeal();
/* 47 */         this.operateDeal.turnEditPolicy(arg0.getSession(), null, false);
/*    */ 
/* 50 */         String sessionId = arg0.getSession().getId();
/*    */ 
/* 52 */         WebApplication app = (WebApplication)this.application.getAttribute("WebApplication");
/* 53 */         Map VisitorList = app.get_webVisitorEngine().getVisitors();
/* 54 */         WebVisitor visitor = (WebVisitor)VisitorList.get(arg0.getSession().getId());
/* 55 */         if (visitor != null)
/*    */         {
/* 57 */           String usercode = visitor.getUser().getUserCode();
/* 58 */           app.get_webVisitorEngine().removeVisitor(visitor);
/* 59 */           VisitorList.remove(arg0.getSession().getId());
/*    */ 
/* 61 */           if (MainListener.sessionMap.containsKey(sessionId))
/*    */           {
/* 63 */             MainListener.sessionMap.remove(sessionId);
/* 64 */             WebLoginLogDB.saveLogoutLogOther(sessionId, usercode);
/* 65 */             arg0.getSession().invalidate();
/* 66 */             System.out.println("---sessionDestroyed---");
/* 67 */             System.out.println(arg0.getSession().getId());
/*    */           }
/*    */ 
/* 72 */           if (visitor != null)
/*    */           {
/* 75 */             int onLineNum = app.get_webVisitorEngine().getTotalOnline();
/* 76 */             onLineNum--;
/* 77 */             if (onLineNum < 0) {
/* 78 */               onLineNum = 0;
/*    */             }
/* 80 */             app.get_webVisitorEngine().setTotalOnline(onLineNum);
/*    */           }
/*    */         }
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 88 */       arg0.getSession().invalidate();
/*    */ 
/* 92 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.ContextListener
 * JD-Core Version:    0.6.0
 */