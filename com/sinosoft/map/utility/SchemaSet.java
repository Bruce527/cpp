/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ public class SchemaSet
/*     */ {
/*     */   private Object[] elementData;
/*     */   private int elementCount;
/*     */   private int capacityIncrement;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public SchemaSet(int initialCapacity, int capacityIncrement)
/*     */   {
/*  20 */     if (initialCapacity < 0)
/*     */     {
/*  23 */       CError tError = new CError();
/*  24 */       tError.moduleName = "SchemaSet";
/*  25 */       tError.functionName = "SchemaSet";
/*  26 */       tError.errorMessage = ("Illegal Capacity: " + initialCapacity);
/*  27 */       this.mErrors.addOneError(tError);
/*     */     }
/*  29 */     this.elementData = new Object[initialCapacity];
/*  30 */     this.capacityIncrement = capacityIncrement;
/*  31 */     this.elementCount = 0;
/*     */ 
/*  33 */     this.mErrors = new CErrors();
/*     */   }
/*     */ 
/*     */   public SchemaSet(int initialCapacity)
/*     */   {
/*  38 */     this(initialCapacity, 0);
/*     */   }
/*     */ 
/*     */   public SchemaSet()
/*     */   {
/*  43 */     this(10);
/*     */   }
/*     */ 
/*     */   public boolean add(Schema aSchema)
/*     */   {
/*  49 */     if (aSchema == null)
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     ensureCapacityHelper(this.elementCount + 1);
/*  54 */     this.elementData[this.elementCount] = aSchema;
/*  55 */     this.elementCount += 1;
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean add(SchemaSet aSet)
/*     */   {
/*  61 */     if (aSet == null)
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     int n = aSet.size();
/*  66 */     ensureCapacityHelper(this.elementCount + n);
/*  67 */     for (int i = 0; i < n; i++)
/*     */     {
/*  69 */       this.elementData[(this.elementCount + i)] = aSet.getObj(i + 1);
/*     */     }
/*  71 */     this.elementCount += n;
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean remove(Schema aSchema)
/*     */   {
/*  77 */     if (aSchema == null)
/*     */     {
/*  79 */       return false;
/*     */     }
/*  81 */     for (int i = 0; i < this.elementCount; i++)
/*     */     {
/*  83 */       if (!aSchema.equals(this.elementData[i]))
/*     */         continue;
/*  85 */       int j = this.elementCount - i - 1;
/*  86 */       if (j > 0)
/*     */       {
/*  88 */         System.arraycopy(this.elementData, i + 1, this.elementData, i, j);
/*     */       }
/*  90 */       this.elementCount -= 1;
/*  91 */       this.elementData[this.elementCount] = null;
/*  92 */       return true;
/*     */     }
/*     */ 
/*  95 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean removeRange(int begin, int end)
/*     */   {
/* 100 */     if ((begin <= 0) || (end > this.elementCount) || (begin > end))
/*     */     {
/* 102 */       return false;
/*     */     }
/* 104 */     int n = this.elementCount - end;
/* 105 */     if (n > 0)
/*     */     {
/* 107 */       System.arraycopy(this.elementData, end, this.elementData, begin - 1, this.elementCount - end);
/*     */     }
/* 109 */     int m = end - begin + 1;
/* 110 */     for (int i = 1; i <= m; i++)
/*     */     {
/* 112 */       int j = this.elementCount - i;
/* 113 */       this.elementData[j] = null;
/*     */     }
/* 115 */     this.elementCount -= m;
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   public void clear()
/*     */   {
/* 121 */     for (int i = 0; i < this.elementCount; i++)
/*     */     {
/* 123 */       this.elementData[i] = null;
/*     */     }
/* 125 */     this.elementCount = 0;
/*     */   }
/*     */ 
/*     */   public Object getObj(int index)
/*     */   {
/* 130 */     if (index > this.elementCount)
/*     */     {
/* 133 */       CError tError = new CError();
/* 134 */       tError.moduleName = "SchemaSet";
/* 135 */       tError.functionName = "get";
/* 136 */       tError.errorMessage = "Index out of bounds!";
/* 137 */       this.mErrors.addOneError(tError);
/*     */     }
/* 139 */     return this.elementData[(index - 1)];
/*     */   }
/*     */ 
/*     */   public boolean set(int index, Schema aSchema)
/*     */   {
/* 144 */     if (index > this.elementCount)
/*     */     {
/* 147 */       CError tError = new CError();
/* 148 */       tError.moduleName = "SchemaSet";
/* 149 */       tError.functionName = "set";
/* 150 */       tError.errorMessage = "Index out of bounds!";
/* 151 */       this.mErrors.addOneError(tError);
/*     */ 
/* 153 */       return false;
/*     */     }
/* 155 */     this.elementData[(index - 1)] = aSchema;
/* 156 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean set(SchemaSet aSet)
/*     */   {
/* 161 */     clear();
/* 162 */     return add(aSet);
/*     */   }
/*     */ 
/*     */   public int size()
/*     */   {
/* 167 */     return this.elementCount;
/*     */   }
/*     */ 
/*     */   private void ensureCapacityHelper(int minCapacity)
/*     */   {
/* 172 */     int oldCapacity = this.elementData.length;
/* 173 */     if (minCapacity > oldCapacity)
/*     */     {
/* 175 */       Object[] oldData = this.elementData;
/* 176 */       int newCapacity = this.capacityIncrement > 0 ? oldCapacity + this.capacityIncrement : 
/* 177 */         oldCapacity * 2;
/* 178 */       if (newCapacity < minCapacity)
/*     */       {
/* 180 */         newCapacity = minCapacity;
/*     */       }
/* 182 */       this.elementData = new Object[newCapacity];
/* 183 */       System.arraycopy(oldData, 0, this.elementData, 0, this.elementCount);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.SchemaSet
 * JD-Core Version:    0.6.0
 */