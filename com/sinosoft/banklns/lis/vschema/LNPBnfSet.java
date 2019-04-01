/*    */ package com.sinosoft.banklns.lis.vschema;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
/*    */ import com.sinosoft.banklns.utility.CErrors;
/*    */ import com.sinosoft.banklns.utility.SchemaSet;
/*    */ 
/*    */ public class LNPBnfSet extends SchemaSet
/*    */ {
/*    */   public boolean add(LNPBnfSchema aSchema)
/*    */   {
/* 20 */     return super.add(aSchema);
/*    */   }
/*    */ 
/*    */   public boolean add(LNPBnfSet aSet)
/*    */   {
/* 25 */     return super.add(aSet);
/*    */   }
/*    */ 
/*    */   public boolean remove(LNPBnfSchema aSchema)
/*    */   {
/* 30 */     return super.remove(aSchema);
/*    */   }
/*    */ 
/*    */   public LNPBnfSchema get(int index)
/*    */   {
/* 35 */     LNPBnfSchema tSchema = (LNPBnfSchema)super.getObj(index);
/* 36 */     return tSchema;
/*    */   }
/*    */ 
/*    */   public boolean set(int index, LNPBnfSchema aSchema)
/*    */   {
/* 41 */     return super.set(index, aSchema);
/*    */   }
/*    */ 
/*    */   public boolean set(LNPBnfSet aSet)
/*    */   {
/* 46 */     return super.set(aSet);
/*    */   }
/*    */ 
/*    */   public String encode()
/*    */   {
/* 52 */     String strReturn = "";
/* 53 */     int n = size();
/* 54 */     for (int i = 1; i <= n; i++)
/*    */     {
/* 56 */       LNPBnfSchema aSchema = get(i);
/* 57 */       strReturn = strReturn + aSchema.encode();
/* 58 */       if (i == n) continue; strReturn = strReturn + "^";
/*    */     }
/*    */ 
/* 61 */     return strReturn;
/*    */   }
/*    */ 
/*    */   public boolean decode(String str)
/*    */   {
/* 67 */     int nBeginPos = 0;
/* 68 */     int nEndPos = str.indexOf('^');
/* 69 */     clear();
/*    */ 
/* 71 */     while (nEndPos != -1)
/*    */     {
/* 73 */       LNPBnfSchema aSchema = new LNPBnfSchema();
/* 74 */       if (!aSchema.decode(str.substring(nBeginPos, nEndPos)))
/*    */       {
/* 77 */         this.mErrors.copyAllErrors(aSchema.mErrors);
/* 78 */         return false;
/*    */       }
/* 80 */       add(aSchema);
/* 81 */       nBeginPos = nEndPos + 1;
/* 82 */       nEndPos = str.indexOf('^', nEndPos + 1);
/*    */     }
/* 84 */     LNPBnfSchema tSchema = new LNPBnfSchema();
/* 85 */     if (!tSchema.decode(str.substring(nBeginPos)))
/*    */     {
/* 88 */       this.mErrors.copyAllErrors(tSchema.mErrors);
/* 89 */       return false;
/*    */     }
/* 91 */     add(tSchema);
/*    */ 
/* 93 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vschema.LNPBnfSet
 * JD-Core Version:    0.6.0
 */