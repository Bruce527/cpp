/*    */ package com.sinosoft.banklns.lis.vschema;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.LNPBnfBSchema;
/*    */ import com.sinosoft.banklns.utility.CErrors;
/*    */ import com.sinosoft.banklns.utility.SchemaSet;
/*    */ 
/*    */ public class LNPBnfBSet extends SchemaSet
/*    */ {
/*    */   public boolean add(LNPBnfBSchema aSchema)
/*    */   {
/* 19 */     return super.add(aSchema);
/*    */   }
/*    */ 
/*    */   public boolean add(LNPBnfBSet aSet)
/*    */   {
/* 24 */     return super.add(aSet);
/*    */   }
/*    */ 
/*    */   public boolean remove(LNPBnfBSchema aSchema)
/*    */   {
/* 29 */     return super.remove(aSchema);
/*    */   }
/*    */ 
/*    */   public LNPBnfBSchema get(int index)
/*    */   {
/* 34 */     LNPBnfBSchema tSchema = (LNPBnfBSchema)super.getObj(index);
/* 35 */     return tSchema;
/*    */   }
/*    */ 
/*    */   public boolean set(int index, LNPBnfBSchema aSchema)
/*    */   {
/* 40 */     return super.set(index, aSchema);
/*    */   }
/*    */ 
/*    */   public boolean set(LNPBnfBSet aSet)
/*    */   {
/* 45 */     return super.set(aSet);
/*    */   }
/*    */ 
/*    */   public String encode()
/*    */   {
/* 51 */     String strReturn = "";
/* 52 */     int n = size();
/* 53 */     for (int i = 1; i <= n; i++)
/*    */     {
/* 55 */       LNPBnfBSchema aSchema = get(i);
/* 56 */       strReturn = strReturn + aSchema.encode();
/* 57 */       if (i == n) continue; strReturn = strReturn + "^";
/*    */     }
/*    */ 
/* 60 */     return strReturn;
/*    */   }
/*    */ 
/*    */   public boolean decode(String str)
/*    */   {
/* 66 */     int nBeginPos = 0;
/* 67 */     int nEndPos = str.indexOf('^');
/* 68 */     clear();
/*    */ 
/* 70 */     while (nEndPos != -1)
/*    */     {
/* 72 */       LNPBnfBSchema aSchema = new LNPBnfBSchema();
/* 73 */       if (!aSchema.decode(str.substring(nBeginPos, nEndPos)))
/*    */       {
/* 76 */         this.mErrors.copyAllErrors(aSchema.mErrors);
/* 77 */         return false;
/*    */       }
/* 79 */       add(aSchema);
/* 80 */       nBeginPos = nEndPos + 1;
/* 81 */       nEndPos = str.indexOf('^', nEndPos + 1);
/*    */     }
/* 83 */     LNPBnfBSchema tSchema = new LNPBnfBSchema();
/* 84 */     if (!tSchema.decode(str.substring(nBeginPos)))
/*    */     {
/* 87 */       this.mErrors.copyAllErrors(tSchema.mErrors);
/* 88 */       return false;
/*    */     }
/* 90 */     add(tSchema);
/*    */ 
/* 92 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vschema.LNPBnfBSet
 * JD-Core Version:    0.6.0
 */