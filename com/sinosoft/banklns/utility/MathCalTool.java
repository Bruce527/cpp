/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.Arith;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Date;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Stack;
/*     */ 
/*     */ public class MathCalTool
/*     */ {
/*     */   private String expStr;
/*  10 */   private String errorStr = "";
/*     */ 
/*     */   public void setExpress(String strExpress)
/*     */   {
/*  19 */     this.expStr = (strExpress + "+0");
/*     */   }
/*     */ 
/*     */   public double getResult()
/*     */   {
/*  24 */     this.errorStr = "";
/*  25 */     String postfix = TranslateExpress(this.expStr);
/*     */ 
/*  27 */     if ((this.errorStr != null) && (this.errorStr.length() > 0))
/*     */     {
/*  29 */       return 0.0D;
/*     */     }
/*  31 */     Stack stk = new Stack();
/*     */ 
/*  33 */     String[] parts = postfix.split("   +");
/*  34 */     double result = 0.0D;
/*  35 */     for (int i = 0; i < parts.length; i++) {
/*  36 */       char tmp = parts[i].charAt(0);
/*  37 */       if (!isOperator(tmp)) {
/*  38 */         if ((this.errorStr != null) && (this.errorStr.length() > 0))
/*     */         {
/*  40 */           return 0.0D;
/*     */         }
/*  42 */         stk.push(parts[i]);
/*     */       }
/*     */       else {
/*  45 */         double a = Double.parseDouble(stk.pop());
/*  46 */         double b = Double.parseDouble(stk.pop());
/*  47 */         result = calculate(b, a, tmp);
/*  48 */         if ((this.errorStr != null) && (this.errorStr.length() > 0))
/*     */         {
/*  50 */           return 0.0D;
/*     */         }
/*  52 */         stk.push(String.valueOf(result));
/*     */       }
/*     */     }
/*  55 */     return result;
/*     */   }
/*     */ 
/*     */   private boolean isOperator(char op)
/*     */   {
/*  60 */     return (op == '+') || (op == '-') || (op == '*') || (op == '/') || (op == '%') || 
/*  61 */       (op == '^') || (op == '~');
/*     */   }
/*     */ 
/*     */   public double calculate(double a, double b, char op)
/*     */   {
/*  66 */     switch (op) {
/*     */     case '+':
/*  68 */       return Arith.add(a, b);
/*     */     case '-':
/*  70 */       return Arith.sub(a, b);
/*     */     case '*':
/*  72 */       return Arith.mul(a, b);
/*     */     case '/':
/*  74 */       if (b == 0.0D) {
/*  75 */         this.errorStr = ("\u951F\u65A4\u62F7\u951F\u65A4\u62F7[" + b + "]\u4E3A\u951F\u65A4\u62F7");
/*  76 */         return 0.0D;
/*     */       }
/*  78 */       return Arith.div(a, b);
/*     */     case '%':
/*  80 */       return a % b;
/*     */     case '^':
/*  82 */       return Math.pow(a, b);
/*     */     case '~':
/*  84 */       return Math.sqrt(a);
/*     */     }
/*  86 */     this.errorStr = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u811A\u8BE7\u62F7\u652F\u951F\u65A4\u62F7";
/*  87 */     return -1.0D;
/*     */   }
/*     */ 
/*     */   private String TranslateExpress(String expressStr)
/*     */   {
/*  92 */     Stack stk = new Stack();
/*  93 */     String postfix = new String();
/*     */ 
/*  95 */     int i = 0;
/*  96 */     while (i < expressStr.length()) {
/*  97 */       if ((Character.isDigit(expressStr.charAt(i))) || 
/*  98 */         (expressStr.charAt(i) == '.')) {
/*  99 */         postfix = postfix + "   ";
/*     */         do {
/* 101 */           postfix = postfix + expressStr.charAt(i++);
/*     */         }
/* 103 */         while ((i < expressStr.length()) && 
/* 104 */           (Character.isDigit(expressStr.charAt(i))));
/* 105 */         postfix = postfix + "   ";
/*     */       }
/*     */       else
/*     */       {
/*     */         char op;
/* 109 */         switch (op = expressStr.charAt(i++)) {
/*     */         case '(':
/* 111 */           stk.push("(");
/* 112 */           break;
/*     */         case ')':
/* 115 */           while (stk.peek() != "(") {
/* 116 */             String tmp = stk.pop();
/* 117 */             postfix = postfix + tmp;
/* 118 */             if ((tmp.length() == 1) && (isOperator(tmp.charAt(0)))) {
/* 119 */               postfix = postfix + "   ";
/*     */             }
/*     */           }
/* 122 */           stk.pop();
/* 123 */           postfix = postfix + "   ";
/* 124 */           break;
/*     */         case '%':
/*     */         case '*':
/*     */         case '+':
/*     */         case '-':
/*     */         case '/':
/*     */         case '^':
/* 133 */           while ((!stk.empty()) && 
/* 134 */             (stk.peek() != "(") && 
/* 135 */             (checkPrecedence(stk.peek().toString(), new Character(op).toString())))
/*     */           {
/* 137 */             postfix = postfix + stk.pop() + "   ";
/*     */           }
/* 139 */           stk.push(new Character(op).toString());
/* 140 */           break;
/*     */         case '~':
/* 145 */           postfix = postfix + "   2   ~    ";
/*     */ 
/* 147 */           break;
/*     */         default:
/* 149 */           this.errorStr = ("\u951F\u65A4\u62F7\u951F\u8282\u8BE7\u62F7\u652F\u951F\u8857\u7889\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7[" + op + "]");
/* 150 */           return null;
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 155 */     ListIterator it = stk.listIterator(stk.size());
/* 156 */     while (it.hasPrevious()) {
/* 157 */       postfix = postfix + it.previous() + "   ";
/*     */     }
/* 159 */     return postfix.trim().replaceAll("   +\\.", ".");
/*     */   }
/*     */ 
/*     */   private boolean checkPrecedence(String op1, String op2)
/*     */   {
/* 164 */     int op1value = 0;
/* 165 */     int op2value = 0;
/* 166 */     if ((op1.equals("+")) || (op1.equals("-")))
/* 167 */       op1value = 1;
/* 168 */     else if ((op1.equals("*")) || (op1.equals("/")))
/* 169 */       op1value = 2;
/* 170 */     else if (op1.equals("%"))
/* 171 */       op1value = 3;
/* 172 */     else if ((op1.equals("^")) || (op1.equals("~"))) {
/* 173 */       op1value = 4;
/*     */     }
/*     */ 
/* 176 */     if ((op2.equals("+")) || (op2.equals("-")))
/* 177 */       op2value = 1;
/* 178 */     else if ((op2.equals("*")) || (op2.equals("/")))
/* 179 */       op2value = 2;
/* 180 */     else if (op2.equals("%"))
/* 181 */       op2value = 3;
/* 182 */     else if ((op2.equals("^")) || (op2.equals("~"))) {
/* 183 */       op2value = 4;
/*     */     }
/*     */ 
/* 187 */     return op1value >= op2value;
/*     */   }
/*     */ 
/*     */   public String getErrorStr()
/*     */   {
/* 196 */     return this.errorStr;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 201 */     MathCalTool ttCalStr = new MathCalTool();
/*     */ 
/* 205 */     String str = "34*100/10*(65*98)/23";
/* 206 */     str = "98*1000-(230^5)~/76*(1-3~+230*23^3-10/34*10*78/56*100)";
/* 207 */     System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5F0F\u951F\u65A4\u62F7" + str);
/* 208 */     ttCalStr.setExpress(str);
/*     */ 
/* 210 */     long data = new Date().getTime();
/* 211 */     System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7" + ttCalStr.getResult());
/*     */ 
/* 214 */     long data2 = new Date().getTime();
/* 215 */     System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u65F6\u951F\u65A4\u62F7:" + (data2 - data));
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.MathCalTool
 * JD-Core Version:    0.6.0
 */