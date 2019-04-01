/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.SchemaSet;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class MMap
/*     */ {
/*  19 */   private HashMap mapV = null;
/*     */ 
/*  22 */   private HashMap mapO = null;
/*     */ 
/*  24 */   private int mRepeatCount = 0;
/*     */ 
/*     */   public MMap()
/*     */   {
/*  28 */     this.mapV = new HashMap();
/*  29 */     this.mapO = new HashMap();
/*     */   }
/*     */ 
/*     */   public void put(Object key, Object value)
/*     */   {
/*  35 */     if ((key == null) || (value == null)) {
/*  36 */       return;
/*     */     }
/*     */ 
/*  41 */     this.mapV.put(key, value);
/*  42 */     this.mapO.put(String.valueOf(this.mapV.size()), key);
/*     */   }
/*     */ 
/*     */   public void put(Object key, Object value, boolean DiskFlag)
/*     */   {
/*  48 */     if ((key == null) || (value == null)) {
/*  49 */       return;
/*     */     }
/*     */ 
/*  53 */     if (this.mapV.put(key, value) == null)
/*     */     {
/*  55 */       this.mapO.put(String.valueOf(this.mapV.size()), key);
/*     */     }
/*     */   }
/*     */ 
/*     */   private SchemaSet cloneSchemSet(SchemaSet cOldSchemaSet)
/*     */   {
/*  61 */     String schemaSetName = cOldSchemaSet.getClass().getName();
/*     */     try {
/*  63 */       Class schemaSetClass = Class.forName(schemaSetName);
/*  64 */       SchemaSet newSchemaSet = (SchemaSet)schemaSetClass.newInstance();
/*  65 */       newSchemaSet.add(cOldSchemaSet);
/*  66 */       return newSchemaSet;
/*     */     } catch (ClassNotFoundException ex) {
/*  68 */       System.out.println("\u6CA1\u6709\u627E\u5230\u7C7B" + schemaSetName);
/*  69 */       ex.printStackTrace();
/*  70 */       return cOldSchemaSet;
/*     */     } catch (IllegalAccessException ex) {
/*  72 */       System.out.println("\u65E0\u6CD5Clone Schema");
/*  73 */       ex.printStackTrace();
/*  74 */       return cOldSchemaSet;
/*     */     } catch (InstantiationException ex) {
/*  76 */       System.out.println("\u65E0\u6CD5Clone Schema");
/*  77 */       ex.printStackTrace();
/*  78 */     }return cOldSchemaSet;
/*     */   }
/*     */ 
/*     */   private Schema cloneSchema(Schema cOldSchema)
/*     */   {
/*  84 */     String methodName = "getSchema";
/*  85 */     Class[] paramType = new Class[0];
/*  86 */     Method method = null;
/*     */     try
/*     */     {
/*  89 */       method = cOldSchema.getClass().getMethod(methodName, paramType);
/*  90 */       Object[] args = new Object[0];
/*  91 */       return (Schema)method.invoke(cOldSchema, args);
/*     */     } catch (NoSuchMethodException ex) {
/*  93 */       System.out.println("\u6CA1\u6709\u627E\u5230getSchema\u65B9\u6CD5");
/*  94 */       ex.printStackTrace();
/*  95 */       return cOldSchema;
/*     */     } catch (InvocationTargetException ex) {
/*  97 */       System.out.println("\u65E0\u6CD5Clone Schema");
/*  98 */       ex.printStackTrace();
/*  99 */       return cOldSchema;
/*     */     } catch (IllegalAccessException ex) {
/* 101 */       System.out.println("\u65E0\u6CD5Clone Schema");
/* 102 */       ex.printStackTrace();
/* 103 */     }return cOldSchema;
/*     */   }
/*     */ 
/*     */   public Set keySet()
/*     */   {
/* 109 */     return this.mapV.keySet();
/*     */   }
/*     */ 
/*     */   public Object get(Object key)
/*     */   {
/* 115 */     return this.mapV.get(key);
/*     */   }
/*     */ 
/*     */   public HashMap getOrder()
/*     */   {
/* 121 */     return this.mapO;
/*     */   }
/*     */ 
/*     */   public Object getKeyByOrder(String order)
/*     */   {
/* 127 */     return this.mapO.get(order);
/*     */   }
/*     */ 
/*     */   public void add(MMap srcMap)
/*     */   {
/* 133 */     if (srcMap == null)
/* 134 */       return;
/* 135 */     for (int i = 0; i < srcMap.keySet().size(); i++)
/*     */     {
/* 137 */       Object key = srcMap.getKeyByOrder(String.valueOf(i + 1));
/* 138 */       put(key, srcMap.get(key));
/*     */     }
/*     */   }
/*     */ 
/*     */   public Object getObjectByObjectName(String cObjectName, int cStartPos) {
/* 143 */     int i = 0; int iMax = 0;
/* 144 */     String tStr1 = ""; String tStr2 = "";
/* 145 */     Object tReturn = null;
/* 146 */     if (cStartPos < 0) {
/* 147 */       cStartPos = 0;
/*     */     }
/* 149 */     iMax = keySet().size();
/*     */     try {
/* 151 */       for (i = cStartPos; i < iMax; i++) {
/* 152 */         if (getOrder().get(String.valueOf(i + 1)) == null) {
/*     */           continue;
/*     */         }
/* 155 */         tStr1 = getOrder().get(String.valueOf(i + 1)).getClass().getName()
/* 156 */           .toUpperCase();
/* 157 */         tStr2 = cObjectName.toUpperCase();
/* 158 */         if ((!tStr1.equals(tStr2)) && 
/* 159 */           (!getLastWord(tStr1, ".").equals(tStr2))) continue;
/* 160 */         tReturn = getOrder().get(String.valueOf(i + 1));
/* 161 */         break;
/*     */       }
/*     */     }
/*     */     catch (Exception ex) {
/* 165 */       tReturn = null;
/*     */     }
/* 167 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public Object[] getAllObjectByObjectName(String cObjectName, int cStartPos)
/*     */   {
/* 173 */     int i = 0; int iMax = 0;
/* 174 */     String tStr1 = ""; String tStr2 = "";
/* 175 */     ArrayList tReturn = new ArrayList();
/* 176 */     if (cStartPos < 0) {
/* 177 */       cStartPos = 0;
/*     */     }
/* 179 */     iMax = keySet().size();
/*     */     try {
/* 181 */       for (i = cStartPos; i < iMax; i++) {
/* 182 */         if (getOrder().get(String.valueOf(i + 1)) == null) {
/*     */           continue;
/*     */         }
/* 185 */         tStr1 = getOrder().get(String.valueOf(i + 1)).getClass().getName()
/* 186 */           .toUpperCase();
/* 187 */         tStr2 = cObjectName.toUpperCase();
/* 188 */         if ((!tStr1.equals(tStr2)) && 
/* 189 */           (!getLastWord(tStr1, ".").equals(tStr2))) continue;
/* 190 */         tReturn.add(getOrder().get(String.valueOf(i + 1)));
/*     */       }
/*     */     }
/*     */     catch (Exception ex) {
/* 194 */       tReturn = null;
/*     */     }
/* 196 */     return tReturn.toArray();
/*     */   }
/*     */ 
/*     */   public void add(MMap srcMap, boolean DiskFlag)
/*     */   {
/* 203 */     if (srcMap == null) {
/* 204 */       return;
/*     */     }
/* 206 */     for (int i = 0; i < srcMap.keySet().size(); i++)
/*     */     {
/* 208 */       Object key = srcMap.getKeyByOrder(String.valueOf(i + 1));
/*     */ 
/* 210 */       put(key, srcMap.get(key), DiskFlag);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getLastWord(String cStr, String splitStr)
/*     */   {
/* 216 */     int tIndex = -1; int tIndexOld = -1;
/* 217 */     String tReturn = cStr;
/*     */     try {
/*     */       while (true) {
/* 220 */         tIndex = tReturn.indexOf(splitStr, tIndex + 1);
/* 221 */         if (tIndex <= 0) break;
/* 222 */         tIndexOld = tIndex;
/*     */       }
/*     */ 
/* 227 */       if (tIndexOld > 0)
/* 228 */         tReturn = cStr.substring(tIndexOld + 1, cStr.length());
/*     */       else
/* 230 */         tReturn = cStr;
/*     */     }
/*     */     catch (Exception ex) {
/* 233 */       tReturn = "";
/*     */     }
/* 235 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public int size() {
/* 239 */     return keySet().size();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.MMap
 * JD-Core Version:    0.6.0
 */