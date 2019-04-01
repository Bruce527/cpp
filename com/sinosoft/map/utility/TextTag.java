/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class TextTag
/*     */ {
/*  15 */   private Vector myVector = new Vector();
/*     */ 
/*     */   public Vector add(String name, String value)
/*     */   {
/*  26 */     if (value != null)
/*     */     {
/*  28 */       String[] temparray = 
/*  29 */         { 
/*  30 */         name, value };
/*  31 */       this.myVector.addElement(temparray);
/*  32 */       return this.myVector;
/*     */     }
/*     */ 
/*  36 */     String[] temparray = 
/*  37 */       { 
/*  38 */       name, "" };
/*  39 */     this.myVector.addElement(temparray);
/*  40 */     return this.myVector;
/*     */   }
/*     */ 
/*     */   public Vector add(String name, int value)
/*     */   {
/*  46 */     Integer ivalue = new Integer(value);
/*  47 */     String svalue = ivalue.toString();
/*  48 */     String[] temparray = 
/*  49 */       { 
/*  50 */       name, svalue };
/*  51 */     this.myVector.addElement(temparray);
/*  52 */     return this.myVector;
/*     */   }
/*     */ 
/*     */   public Vector add(String name, long value)
/*     */   {
/*  58 */     Long ivalue = new Long(value);
/*  59 */     String svalue = ivalue.toString();
/*  60 */     String[] temparray = 
/*  61 */       { 
/*  62 */       name, svalue };
/*  63 */     this.myVector.addElement(temparray);
/*  64 */     return this.myVector;
/*     */   }
/*     */ 
/*     */   public Vector add(String name, float value)
/*     */   {
/*  70 */     Float fvalue = new Float(value);
/*  71 */     String svalue = fvalue.toString();
/*  72 */     String[] temparray = 
/*  73 */       { 
/*  74 */       name, svalue };
/*  75 */     this.myVector.addElement(temparray);
/*  76 */     return this.myVector;
/*     */   }
/*     */ 
/*     */   public Vector add(String name, double value)
/*     */   {
/*  81 */     Double fvalue = new Double(value);
/*  82 */     String svalue = fvalue.toString();
/*  83 */     String[] temparray = 
/*  84 */       { 
/*  85 */       name, svalue };
/*  86 */     this.myVector.addElement(temparray);
/*  87 */     return this.myVector;
/*     */   }
/*     */ 
/*     */   public Object get(int i)
/*     */   {
/*  94 */     return this.myVector.get(i);
/*     */   }
/*     */ 
/*     */   public int size()
/*     */   {
/* 101 */     return this.myVector.size();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.TextTag
 * JD-Core Version:    0.6.0
 */