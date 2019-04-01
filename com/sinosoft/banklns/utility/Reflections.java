/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class Reflections
/*     */ {
/*  12 */   Vector mVResult = new Vector();
/*     */ 
/*     */   public static void printConstructors(Class c1)
/*     */   {
/*  17 */     Constructor[] constructors = c1.getDeclaredConstructors();
/*  18 */     System.out.println("------------------print Constructors-----------------");
/*     */ 
/*  20 */     for (int i = 0; i < constructors.length; i++)
/*     */     {
/*  22 */       Constructor c = constructors[i];
/*  23 */       String name = c.getName();
/*  24 */       System.out.print("   " + name + "(");
/*     */ 
/*  26 */       Class[] paramTypes = c.getParameterTypes();
/*  27 */       for (int j = 0; j < paramTypes.length; j++) {
/*  28 */         if (j > 0)
/*  29 */           System.out.print("Par, ");
/*     */       }
/*  31 */       System.out.println(");");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void printMethods(Class c1)
/*     */   {
/*  38 */     Method[] methods = c1.getDeclaredMethods();
/*  39 */     System.out.println("------------------print methods ----------------");
/*     */ 
/*  41 */     for (int i = 0; i < methods.length; i++)
/*     */     {
/*  43 */       Method m = methods[i];
/*  44 */       Class retType = m.getReturnType();
/*  45 */       String name = m.getName();
/*     */ 
/*  47 */       System.out.print(Modifier.toString(m.getModifiers()));
/*  48 */       System.out.println(" | " + retType.getName() + " |" + name + "(");
/*     */ 
/*  50 */       Class[] paramTypes = m.getParameterTypes();
/*  51 */       for (int j = 0; j < paramTypes.length; j++)
/*     */       {
/*  53 */         if (j > 0)
/*  54 */           System.out.print(", ");
/*  55 */         System.out.println(paramTypes[j].getName());
/*     */       }
/*  57 */       System.out.println("):");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void printFields(Class c1)
/*     */   {
/*  64 */     Field[] fields = c1.getDeclaredFields();
/*  65 */     AccessibleObject.setAccessible(fields, true);
/*     */ 
/*  67 */     System.out.println("------------------print Fields ----------------");
/*  68 */     for (int i = 0; i < fields.length; i++)
/*     */     {
/*  70 */       Field f = fields[i];
/*  71 */       Class type = f.getType();
/*  72 */       String name = f.getName();
/*  73 */       System.out.print(Modifier.toString(f.getModifiers()));
/*  74 */       System.out.println(" | " + type.getName() + "| " + name + ";");
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean transFields(SchemaSet a, SchemaSet b)
/*     */   {
/*  81 */     if (a != null)
/*     */     {
/*  83 */       int n = b.size();
/*     */       try
/*     */       {
/*  86 */         Class c1 = a.getObj(1).getClass();
/*  87 */         a.clear();
/*  88 */         System.out.println("====in" + n);
/*  89 */         for (int i = 1; i <= n; i++)
/*     */         {
/*  91 */           System.out.println("---i:" + i);
/*  92 */           Object c = c1.newInstance();
/*  93 */           transFields((Schema)c, (Schema)b.getObj(i));
/*  94 */           a.add((Schema)c);
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*  99 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     else {
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */   public Object transFields(Schema a, Schema b)
/*     */   {
/* 110 */     Class c1 = a.getClass();
/* 111 */     Class c2 = b.getClass();
/*     */ 
/* 113 */     Field[] fieldsDest = c1.getDeclaredFields();
/* 114 */     Field[] fieldsOrg = c2.getDeclaredFields();
/*     */ 
/* 116 */     AccessibleObject.setAccessible(fieldsDest, true);
/* 117 */     AccessibleObject.setAccessible(fieldsOrg, true);
/*     */ 
/* 119 */     System.out.println("------------------trans print Fields ----------------");
/*     */ 
/* 121 */     for (int i = 0; i < fieldsDest.length; i++)
/*     */     {
/* 123 */       Field f = fieldsDest[i];
/* 124 */       Class type = f.getType();
/* 125 */       String name = f.getName();
/* 126 */       String typeName = type.getName();
/*     */ 
/* 128 */       if ((name.equals("FIELDNUM")) || (name.equals("PK")) || (name.equals("mErrors")) || (name.equals("fDate"))) {
/*     */         continue;
/*     */       }
/* 131 */       for (int j = 0; j < fieldsOrg.length; j++)
/*     */       {
/* 134 */         Field f1 = fieldsOrg[j];
/* 135 */         Class type1 = f1.getType();
/* 136 */         String name1 = f1.getName();
/* 137 */         String typeName1 = type.getName();
/*     */ 
/* 141 */         if ((name.equals("FIELDNUM")) || (name.equals("PK")) || (name.equals("mErrors")) || (name.equals("fDate"))) {
/*     */           continue;
/*     */         }
/* 144 */         if ((!typeName.equals(typeName1)) || (!name1.equals(name))) {
/*     */           continue;
/*     */         }
/* 147 */         switch (transType(typeName))
/*     */         {
/*     */         case 3:
/*     */           try
/*     */           {
/* 152 */             f.setDouble(a, f1.getDouble(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 157 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 5:
/*     */           try
/*     */           {
/* 163 */             f.setInt(a, f1.getInt(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 168 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 93:
/*     */           try
/*     */           {
/* 174 */             f.set(a, f1.get(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 179 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         default:
/*     */           try
/*     */           {
/* 185 */             f.set(a, f1.get(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 190 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 198 */     System.out.println("----------------------------end-------");
/* 199 */     return a;
/*     */   }
/*     */ 
/*     */   public boolean compareFields(Schema a, Schema b)
/*     */   {
/* 205 */     boolean aFlag = true;
/*     */ 
/* 207 */     this.mVResult.clear();
/*     */ 
/* 209 */     Class c1 = a.getClass();
/* 210 */     Class c2 = b.getClass();
/*     */ 
/* 212 */     Field[] fieldsDest = c1.getDeclaredFields();
/* 213 */     Field[] fieldsOrg = c2.getDeclaredFields();
/*     */ 
/* 215 */     AccessibleObject.setAccessible(fieldsDest, true);
/* 216 */     AccessibleObject.setAccessible(fieldsOrg, true);
/*     */ 
/* 218 */     System.out.println("------------------comp print Fields ----------------");
/* 219 */     for (int i = 0; i < fieldsDest.length; i++)
/*     */     {
/* 221 */       Field f = fieldsDest[i];
/* 222 */       Class type = f.getType();
/* 223 */       String name = f.getName();
/* 224 */       String typeName = type.getName();
/*     */ 
/* 226 */       if ((name.equals("FIELDNUM")) || (name.equals("PK")) || (name.equals("mErrors")) || (name.equals("fDate"))) {
/*     */         continue;
/*     */       }
/* 229 */       for (int j = 0; j < fieldsOrg.length; j++)
/*     */       {
/* 232 */         Field f1 = fieldsOrg[j];
/* 233 */         Class type1 = f1.getType();
/* 234 */         String name1 = f1.getName();
/* 235 */         String typeName1 = type.getName();
/*     */ 
/* 238 */         if ((name.equals("FIELDNUM")) || (name.equals("PK")) || (name.equals("mErrors")) || (name.equals("fDate"))) {
/*     */           continue;
/*     */         }
/* 241 */         if ((!typeName.equals(typeName1)) || (!name1.equals(name))) {
/*     */           continue;
/*     */         }
/* 244 */         switch (transType(typeName))
/*     */         {
/*     */         case 3:
/*     */           try
/*     */           {
/* 249 */             if (f.getDouble(a) == f1.getDouble(b))
/*     */               break;
/* 251 */             String tStr = name + "^" + f.getDouble(a) + "|" + f1.getDouble(b);
/* 252 */             this.mVResult.addElement(tStr);
/* 253 */             aFlag = false;
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 258 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 5:
/*     */           try
/*     */           {
/* 264 */             if (f.getInt(a) == f1.getInt(b))
/*     */               break;
/* 266 */             String tStr = name + "^" + f.getInt(a) + "|" + f1.getInt(b);
/* 267 */             this.mVResult.addElement(tStr);
/* 268 */             aFlag = false;
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 273 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 93:
/*     */           try
/*     */           {
/* 279 */             if (f.get(a) == f1.get(b))
/*     */               break;
/* 281 */             String tStr = name + "^" + f.get(a) + "|" + f1.get(b);
/* 282 */             this.mVResult.addElement(tStr);
/* 283 */             aFlag = false;
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 288 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         default:
/*     */           try
/*     */           {
/* 294 */             if (f.get(a) == f1.get(b))
/*     */               break;
/* 296 */             String tStr = name + "^" + f.get(a) + "|" + f1.get(b);
/* 297 */             this.mVResult.addElement(tStr);
/* 298 */             aFlag = false;
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 303 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 311 */     System.out.println("---------------------------- compare end-----------------------");
/* 312 */     return aFlag;
/*     */   }
/*     */ 
/*     */   public Object synchronizeFields(Schema a, Schema b)
/*     */   {
/* 318 */     boolean aFlag = true;
/*     */ 
/* 320 */     this.mVResult.clear();
/*     */ 
/* 322 */     Class c1 = a.getClass();
/* 323 */     Class c2 = b.getClass();
/*     */ 
/* 325 */     Field[] fieldsDest = c1.getDeclaredFields();
/* 326 */     Field[] fieldsOrg = c2.getDeclaredFields();
/*     */ 
/* 328 */     AccessibleObject.setAccessible(fieldsDest, true);
/* 329 */     AccessibleObject.setAccessible(fieldsOrg, true);
/*     */ 
/* 331 */     System.out.println("------------------comp print Fields ----------------");
/* 332 */     for (int i = 0; i < fieldsDest.length; i++)
/*     */     {
/* 334 */       Field f = fieldsDest[i];
/* 335 */       Class type = f.getType();
/* 336 */       String name = f.getName();
/* 337 */       String typeName = type.getName();
/*     */ 
/* 339 */       if ((name.equals("FIELDNUM")) || (name.equals("PK")) || (name.equals("mErrors")) || (name.equals("fDate"))) {
/*     */         continue;
/*     */       }
/* 342 */       for (int j = 0; j < fieldsOrg.length; j++)
/*     */       {
/* 345 */         Field f1 = fieldsOrg[j];
/* 346 */         Class type1 = f1.getType();
/* 347 */         String name1 = f1.getName();
/* 348 */         String typeName1 = type.getName();
/*     */ 
/* 351 */         if ((name.equals("FIELDNUM")) || (name.equals("PK")) || (name.equals("mErrors")) || (name.equals("fDate"))) {
/*     */           continue;
/*     */         }
/* 354 */         if ((!typeName.equals(typeName1)) || (!name1.equals(name))) {
/*     */           continue;
/*     */         }
/* 357 */         switch (transType(typeName))
/*     */         {
/*     */         case 3:
/*     */           try
/*     */           {
/* 362 */             if (f.getDouble(a) == f1.getDouble(b))
/*     */               break;
/* 364 */             f.setDouble(a, f1.getDouble(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 369 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 5:
/*     */           try
/*     */           {
/* 375 */             if (f.getInt(a) == f1.getInt(b))
/*     */               break;
/* 377 */             f.setInt(a, f1.getInt(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 382 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 93:
/*     */           try
/*     */           {
/* 388 */             if (f.get(a) == f1.get(b))
/*     */               break;
/* 390 */             f.set(a, f1.get(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 395 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         default:
/*     */           try
/*     */           {
/* 401 */             if (f.get(a) == f1.get(b))
/*     */               break;
/* 403 */             f.set(a, f1.get(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 408 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 415 */     System.out.println("---------------------------- compare end-----------------------");
/* 416 */     return a;
/*     */   }
/*     */ 
/*     */   public void printFields(Object a)
/*     */   {
/* 422 */     Class c1 = a.getClass();
/*     */ 
/* 424 */     Field[] fieldsDest = c1.getDeclaredFields();
/*     */ 
/* 426 */     AccessibleObject.setAccessible(fieldsDest, true);
/*     */ 
/* 429 */     System.out.println("------------------trans print Fields ----------------");
/*     */ 
/* 431 */     for (int i = 0; i < fieldsDest.length; i++)
/*     */     {
/* 433 */       Field f = fieldsDest[i];
/* 434 */       Class type = f.getType();
/* 435 */       String name = f.getName();
/* 436 */       String typeName = type.getName();
/*     */ 
/* 438 */       if ((name.equals("FIELDNUM")) || (name.equals("PK")) || (name.equals("mErrors")) || (name.equals("fDate")))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 443 */       switch (transType(typeName))
/*     */       {
/*     */       case 3:
/*     */         try
/*     */         {
/* 448 */           System.out.println("***************double::" + name + "---" + f.getDouble(a));
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 452 */           e.printStackTrace();
/*     */         }
/*     */ 
/*     */       case 5:
/*     */         try
/*     */         {
/* 458 */           System.out.println("*************************Int::" + name + "---" + f.getInt(a));
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 462 */           e.printStackTrace();
/*     */         }
/*     */ 
/*     */       case 93:
/*     */         try
/*     */         {
/* 468 */           System.out.println("*******************String::" + name + "---" + f.get(a));
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 472 */           e.printStackTrace();
/*     */         }
/*     */ 
/*     */       default:
/*     */         try
/*     */         {
/* 478 */           System.out.println("------Default:" + f.get(a));
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 482 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 488 */     System.out.println("-------- print end-------");
/*     */   }
/*     */ 
/*     */   private int transType(Object type)
/*     */   {
/* 496 */     int typecode = 93;
/* 497 */     if (type.equals("java.lang.String"))
/* 498 */       typecode = 93;
/* 499 */     if (type.equals("double"))
/* 500 */       typecode = 3;
/* 501 */     if (type.equals("int")) {
/* 502 */       typecode = 5;
/*     */     }
/* 504 */     return typecode;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherobject)
/*     */   {
/* 509 */     if (this == otherobject) return true;
/*     */ 
/* 511 */     if (otherobject == null) return false;
/*     */ 
/* 513 */     if (getClass() != otherobject.getClass()) return false;
/*     */ 
/* 515 */     Reflections other = (Reflections)otherobject;
/*     */ 
/* 517 */     return true;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 522 */     Class ref = getClass();
/* 523 */     System.out.println("ref:" + ref);
/* 524 */     System.out.println("--------------------------");
/* 525 */     return getClass().getName();
/*     */   }
/*     */ 
/*     */   public Vector getVResult()
/*     */   {
/* 530 */     return this.mVResult;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     String name;
/*     */     String name;
/* 537 */     if (args.length > 0) {
/* 538 */       name = args[0];
/*     */     }
/*     */     else {
/* 541 */       name = "java.util.Date";
/*     */     }
/*     */     try
/*     */     {
/* 545 */       Reflections localReflections = new Reflections();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 565 */       e.printStackTrace();
/*     */     }
/* 567 */     System.exit(0);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.Reflections
 * JD-Core Version:    0.6.0
 */