/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class Reflections
/*     */ {
/*  15 */   Vector mVResult = new Vector();
/*     */ 
/*     */   public static void printConstructors(Class c1)
/*     */   {
/*  20 */     Constructor[] constructors = c1.getDeclaredConstructors();
/*     */ 
/*  23 */     for (int i = 0; i < constructors.length; i++)
/*     */     {
/*  25 */       Constructor c = constructors[i];
/*  26 */       String name = c.getName();
/*     */ 
/*  29 */       Class[] arrayOfClass = c.getParameterTypes();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void printMethods(Class c1)
/*     */   {
/*  42 */     Method[] methods = c1.getDeclaredMethods();
/*     */ 
/*  45 */     for (int i = 0; i < methods.length; i++)
/*     */     {
/*  47 */       Method localMethod = methods[i];
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void printFields(Class c1)
/*     */   {
/*  68 */     Field[] fields = c1.getDeclaredFields();
/*  69 */     AccessibleObject.setAccessible(fields, true);
/*     */ 
/*  72 */     for (int i = 0; i < fields.length; i++)
/*     */     {
/*  74 */       Field localField = fields[i];
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean transFields(SchemaSet a, SchemaSet b)
/*     */   {
/*  85 */     if (a != null)
/*     */     {
/*  87 */       int n = b.size();
/*     */       try
/*     */       {
/*  90 */         Class c1 = a.getObj(1).getClass();
/*  91 */         a.clear();
/*     */ 
/*  93 */         for (int i = 1; i <= n; i++)
/*     */         {
/*  96 */           Object c = c1.newInstance();
/*  97 */           transFields((Schema)c, (Schema)b.getObj(i));
/*  98 */           a.add((Schema)c);
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 103 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 108 */       return false;
/*     */     }
/*     */ 
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public Object transFields(Schema a, Schema b)
/*     */   {
/* 117 */     Class c1 = a.getClass();
/* 118 */     Class c2 = b.getClass();
/*     */ 
/* 120 */     Field[] fieldsDest = c1.getDeclaredFields();
/* 121 */     Field[] fieldsOrg = c2.getDeclaredFields();
/*     */ 
/* 123 */     AccessibleObject.setAccessible(fieldsDest, true);
/* 124 */     AccessibleObject.setAccessible(fieldsOrg, true);
/*     */ 
/* 128 */     for (int i = 0; i < fieldsDest.length; i++)
/*     */     {
/* 130 */       Field f = fieldsDest[i];
/* 131 */       Class type = f.getType();
/* 132 */       String name = f.getName();
/* 133 */       String typeName = type.getName();
/*     */ 
/* 135 */       if ((name.equals("FIELDNUM")) || (name.equals("PK")) || 
/* 136 */         (name.equals("mErrors")) || (name.equals("fDate")))
/*     */       {
/*     */         continue;
/*     */       }
/* 140 */       for (int j = 0; j < fieldsOrg.length; j++)
/*     */       {
/* 143 */         Field f1 = fieldsOrg[j];
/*     */ 
/* 145 */         String name1 = f1.getName();
/* 146 */         String typeName1 = type.getName();
/*     */ 
/* 150 */         if ((name.equals("FIELDNUM")) || (name.equals("PK")) || 
/* 151 */           (name.equals("mErrors")) || (name.equals("fDate")))
/*     */         {
/*     */           continue;
/*     */         }
/*     */ 
/* 156 */         if ((!typeName.equals(typeName1)) || (!name1.equals(name))) {
/*     */           continue;
/*     */         }
/* 159 */         switch (transType(typeName))
/*     */         {
/*     */         case 3:
/*     */           try
/*     */           {
/* 164 */             f.setDouble(a, f1.getDouble(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 168 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 5:
/*     */           try
/*     */           {
/* 175 */             f.setInt(a, f1.getInt(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 179 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 93:
/*     */           try
/*     */           {
/* 186 */             f.set(a, f1.get(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 190 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         default:
/*     */           try
/*     */           {
/* 197 */             f.set(a, f1.get(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 202 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 210 */     return a;
/*     */   }
/*     */ 
/*     */   public Object transFields1(Schema a, Schema b)
/*     */   {
/* 216 */     Class c1 = a.getClass();
/* 217 */     Class c2 = b.getClass();
/*     */ 
/* 219 */     Field[] fieldsDest = c1.getFields();
/* 220 */     Field[] fieldsOrg = c2.getFields();
/*     */ 
/* 222 */     AccessibleObject.setAccessible(fieldsDest, true);
/* 223 */     AccessibleObject.setAccessible(fieldsOrg, true);
/*     */ 
/* 225 */     System.out.println("----fieldDest.length:" + fieldsDest.length);
/* 226 */     System.out.println("----fieldsOrg.length:" + fieldsOrg.length);
/* 227 */     for (int i = 0; i < fieldsDest.length; i++)
/*     */     {
/* 229 */       Field f = fieldsDest[i];
/* 230 */       Class type = f.getType();
/* 231 */       String name = f.getName();
/* 232 */       String typeName = type.getName();
/* 233 */       System.out.println("[Time]::" + i + "[colname]:" + name + "[Typename]:" + typeName);
/* 234 */       if ((name.equals("FIELDNUM")) || (name.equals("PK")) || 
/* 235 */         (name.equals("mErrors")) || (name.equals("fDate")))
/*     */       {
/*     */         continue;
/*     */       }
/* 239 */       for (int j = 0; j < fieldsOrg.length; j++)
/*     */       {
/* 242 */         Field f1 = fieldsOrg[j];
/* 243 */         Class type1 = f1.getType();
/* 244 */         String name1 = f1.getName();
/* 245 */         String typeName1 = type1.getName();
/* 246 */         System.out.println("[times]:" + j + "[colname1]:" + name1 + "[Typename1]:" + typeName1);
/*     */ 
/* 249 */         if ((name.equals("FIELDNUM")) || (name.equals("PK")) || 
/* 250 */           (name.equals("mErrors")) || (name.equals("fDate")))
/*     */         {
/*     */           continue;
/*     */         }
/*     */ 
/* 255 */         if ((!typeName.equals(typeName1)) || (!name1.equals(name))) {
/*     */           continue;
/*     */         }
/* 258 */         switch (transType(typeName))
/*     */         {
/*     */         case 3:
/*     */           try
/*     */           {
/* 263 */             f.setDouble(a, f1.getDouble(b));
/*     */           }
/*     */           catch (Exception localException)
/*     */           {
/*     */           }
/*     */ 
/*     */         case 5:
/*     */           try
/*     */           {
/* 274 */             f.setInt(a, f1.getInt(b));
/*     */           }
/*     */           catch (Exception localException1)
/*     */           {
/*     */           }
/*     */ 
/*     */         case 93:
/*     */           try
/*     */           {
/* 285 */             f.set(a, f1.get(b));
/*     */           }
/*     */           catch (Exception localException2)
/*     */           {
/*     */           }
/*     */ 
/*     */         default:
/*     */           try
/*     */           {
/* 296 */             f.set(a, f1.get(b));
/*     */           }
/*     */           catch (Exception localException3)
/*     */           {
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 309 */     return a;
/*     */   }
/*     */ 
/*     */   public boolean compareFields(Schema a, Schema b)
/*     */   {
/* 315 */     boolean aFlag = true;
/*     */ 
/* 317 */     this.mVResult.clear();
/*     */ 
/* 319 */     Class c1 = a.getClass();
/* 320 */     Class c2 = b.getClass();
/*     */ 
/* 322 */     Field[] fieldsDest = c1.getDeclaredFields();
/* 323 */     Field[] fieldsOrg = c2.getDeclaredFields();
/*     */ 
/* 325 */     AccessibleObject.setAccessible(fieldsDest, true);
/* 326 */     AccessibleObject.setAccessible(fieldsOrg, true);
/*     */ 
/* 329 */     for (int i = 0; i < fieldsDest.length; i++)
/*     */     {
/* 331 */       Field f = fieldsDest[i];
/* 332 */       Class type = f.getType();
/* 333 */       String name = f.getName();
/* 334 */       String typeName = type.getName();
/*     */ 
/* 336 */       if ((name.equals("FIELDNUM")) || (name.equals("PK")) || 
/* 337 */         (name.equals("mErrors")) || (name.equals("fDate")))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 342 */       for (int j = 0; j < fieldsOrg.length; j++)
/*     */       {
/* 345 */         Field f1 = fieldsOrg[j];
/*     */ 
/* 347 */         String name1 = f1.getName();
/* 348 */         String typeName1 = type.getName();
/*     */ 
/* 351 */         if ((name.equals("FIELDNUM")) || (name.equals("PK")) || 
/* 352 */           (name.equals("mErrors")) || (name.equals("fDate")))
/*     */         {
/*     */           continue;
/*     */         }
/*     */ 
/* 357 */         if ((!typeName.equals(typeName1)) || (!name1.equals(name))) {
/*     */           continue;
/*     */         }
/* 360 */         switch (transType(typeName))
/*     */         {
/*     */         case 3:
/*     */           try
/*     */           {
/* 365 */             if (f.getDouble(a) == f1.getDouble(b))
/*     */               continue;
/* 367 */             String tStr = name + "^" + 
/* 368 */               f.getDouble(a) + "|" + 
/* 369 */               f1.getDouble(b);
/* 370 */             this.mVResult.addElement(tStr);
/* 371 */             aFlag = false;
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 376 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 5:
/*     */           try
/*     */           {
/* 383 */             if (f.getInt(a) == f1.getInt(b))
/*     */               continue;
/* 385 */             String tStr = name + "^" + f.getInt(a) + 
/* 386 */               "|" + f1.getInt(b);
/* 387 */             this.mVResult.addElement(tStr);
/* 388 */             aFlag = false;
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 393 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 93:
/*     */           try
/*     */           {
/* 400 */             if (f.get(a) == f1.get(b))
/*     */               continue;
/* 402 */             String tStr = name + "^" + f.get(a) + 
/* 403 */               "|" + f1.get(b);
/* 404 */             this.mVResult.addElement(tStr);
/* 405 */             aFlag = false;
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 410 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         default:
/*     */           try
/*     */           {
/* 417 */             if (f.get(a) == f1.get(b))
/*     */               continue;
/* 419 */             String tStr = name + "^" + f.get(a) + 
/* 420 */               "|" + f1.get(b);
/* 421 */             this.mVResult.addElement(tStr);
/* 422 */             aFlag = false;
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 427 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 436 */     return aFlag;
/*     */   }
/*     */ 
/*     */   public Object synchronizeFields(Schema a, Schema b)
/*     */   {
/* 444 */     this.mVResult.clear();
/*     */ 
/* 446 */     Class c1 = a.getClass();
/* 447 */     Class c2 = b.getClass();
/*     */ 
/* 449 */     Field[] fieldsDest = c1.getDeclaredFields();
/* 450 */     Field[] fieldsOrg = c2.getDeclaredFields();
/*     */ 
/* 452 */     AccessibleObject.setAccessible(fieldsDest, true);
/* 453 */     AccessibleObject.setAccessible(fieldsOrg, true);
/*     */ 
/* 456 */     for (int i = 0; i < fieldsDest.length; i++)
/*     */     {
/* 458 */       Field f = fieldsDest[i];
/* 459 */       Class type = f.getType();
/* 460 */       String name = f.getName();
/* 461 */       String typeName = type.getName();
/*     */ 
/* 463 */       if ((name.equals("FIELDNUM")) || (name.equals("PK")) || 
/* 464 */         (name.equals("mErrors")) || (name.equals("fDate")))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 469 */       for (int j = 0; j < fieldsOrg.length; j++)
/*     */       {
/* 472 */         Field f1 = fieldsOrg[j];
/*     */ 
/* 474 */         String name1 = f1.getName();
/* 475 */         String typeName1 = type.getName();
/*     */ 
/* 478 */         if ((name.equals("FIELDNUM")) || (name.equals("PK")) || 
/* 479 */           (name.equals("mErrors")) || (name.equals("fDate")))
/*     */         {
/*     */           continue;
/*     */         }
/*     */ 
/* 484 */         if ((!typeName.equals(typeName1)) || (!name1.equals(name))) {
/*     */           continue;
/*     */         }
/* 487 */         switch (transType(typeName))
/*     */         {
/*     */         case 3:
/*     */           try
/*     */           {
/* 492 */             if (f.getDouble(a) == f1.getDouble(b))
/*     */               continue;
/* 494 */             f.setDouble(a, f1.getDouble(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 499 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 5:
/*     */           try
/*     */           {
/* 506 */             if (f.getInt(a) == f1.getInt(b))
/*     */               continue;
/* 508 */             f.setInt(a, f1.getInt(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 513 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         case 93:
/*     */           try
/*     */           {
/* 520 */             if (f.get(a) == f1.get(b))
/*     */               continue;
/* 522 */             f.set(a, f1.get(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 527 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         default:
/*     */           try
/*     */           {
/* 534 */             if (f.get(a) == f1.get(b))
/*     */               continue;
/* 536 */             f.set(a, f1.get(b));
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 541 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 550 */     return a;
/*     */   }
/*     */ 
/*     */   public void printFields(Object a)
/*     */   {
/* 556 */     Class c1 = a.getClass();
/*     */ 
/* 558 */     Field[] fieldsDest = c1.getDeclaredFields();
/*     */ 
/* 560 */     AccessibleObject.setAccessible(fieldsDest, true);
/*     */ 
/* 564 */     for (int i = 0; i < fieldsDest.length; i++)
/*     */     {
/* 566 */       Field f = fieldsDest[i];
/* 567 */       Class type = f.getType();
/* 568 */       String name = f.getName();
/* 569 */       String typeName = type.getName();
/*     */ 
/* 571 */       if ((name.equals("FIELDNUM")) || (name.equals("PK")) || 
/* 572 */         (name.equals("mErrors")) || (name.equals("fDate")))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 579 */       switch (transType(typeName))
/*     */       {
/*     */       case 3:
/* 591 */         break;
/*     */       case 5:
/* 602 */         break;
/*     */       case 93:
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private static int transType(Object type)
/*     */   {
/* 637 */     int typecode = 93;
/* 638 */     if (type.equals("java.lang.String"))
/*     */     {
/* 640 */       typecode = 93;
/*     */     }
/* 642 */     if (type.equals("double"))
/*     */     {
/* 644 */       typecode = 3;
/*     */     }
/* 646 */     if (type.equals("int"))
/*     */     {
/* 648 */       typecode = 5;
/*     */     }
/*     */ 
/* 651 */     return typecode;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherobject)
/*     */   {
/* 656 */     if (this == otherobject)
/*     */     {
/* 658 */       return true;
/*     */     }
/*     */ 
/* 661 */     if (otherobject == null)
/*     */     {
/* 663 */       return false;
/*     */     }
/*     */ 
/* 666 */     if (getClass() != otherobject.getClass())
/*     */     {
/* 668 */       return false;
/*     */     }
/*     */ 
/* 671 */     Reflections other = (Reflections)otherobject;
/*     */ 
/* 673 */     return true;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 678 */     Class ref = getClass();
/*     */ 
/* 681 */     return getClass().getName();
/*     */   }
/*     */ 
/*     */   public Vector getVResult()
/*     */   {
/* 686 */     return this.mVResult;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.Reflections
 * JD-Core Version:    0.6.0
 */