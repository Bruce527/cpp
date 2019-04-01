/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import bsh.Interpreter;
/*    */ import java.util.Enumeration;
/*    */ import java.util.Hashtable;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class EvalJavaTool
/*    */ {
/*    */   public String executeByExpress(String expression, Hashtable reHashtable)
/*    */   {
/* 16 */     String result = null;
/*    */     try {
/* 18 */       Interpreter interpreter = new Interpreter();
/* 19 */       if (reHashtable != null) {
/* 20 */         Enumeration enumeration = reHashtable.keys();
/* 21 */         while (enumeration.hasMoreElements()) {
/* 22 */           String key = enumeration.nextElement().toString();
/* 23 */           Object obj = reHashtable.get(key);
/*    */ 
/* 25 */           if ((obj != null) && (Pattern.matches("[0-9.]*", obj.toString())))
/*    */           {
/* 27 */             if (obj.toString().indexOf(".") != -1)
/* 28 */               interpreter.set(key, Double.parseDouble(obj.toString()));
/*    */             else
/* 30 */               interpreter.set(key, Integer.parseInt(obj.toString()));
/*    */           }
/*    */           else {
/* 33 */             interpreter.set(key, obj);
/*    */           }
/*    */ 
/*    */         }
/*    */ 
/*    */       }
/*    */ 
/* 46 */       Object obj = interpreter.eval(expression);
/* 47 */       if (obj != null)
/* 48 */         result = obj.toString();
/*    */     }
/*    */     catch (Exception e) {
/* 51 */       e.printStackTrace();
/*    */     }
/* 53 */     return result;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.EvalJavaTool
 * JD-Core Version:    0.6.0
 */