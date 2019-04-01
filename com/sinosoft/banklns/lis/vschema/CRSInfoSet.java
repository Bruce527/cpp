/*    */ package com.sinosoft.banklns.lis.vschema;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.CRSInfoSchema;
/*    */ import com.sinosoft.banklns.utility.CErrors;
/*    */ import com.sinosoft.banklns.utility.SchemaSet;
/*    */ 
/*    */ public class CRSInfoSet extends SchemaSet
/*    */ {
/*    */   public boolean add(CRSInfoSchema aSchema)
/*    */   {
/* 13 */     return super.add(aSchema);
/*    */   }
/*    */ 
/*    */   public boolean add(CRSInfoSet aSet)
/*    */   {
/* 18 */     return super.add(aSet);
/*    */   }
/*    */ 
/*    */   public boolean remove(CRSInfoSchema aSchema)
/*    */   {
/* 23 */     return super.remove(aSchema);
/*    */   }
/*    */ 
/*    */   public CRSInfoSchema get(int index)
/*    */   {
/* 28 */     CRSInfoSchema tSchema = (CRSInfoSchema)super.getObj(index);
/* 29 */     return tSchema;
/*    */   }
/*    */ 
/*    */   public boolean set(int index, CRSInfoSchema aSchema)
/*    */   {
/* 34 */     return super.set(index, aSchema);
/*    */   }
/*    */ 
/*    */   public boolean set(CRSInfoSet aSet)
/*    */   {
/* 39 */     return super.set(aSet);
/*    */   }
/*    */ 
/*    */   public String encode()
/*    */   {
/* 45 */     StringBuffer strReturn = new StringBuffer("");
/* 46 */     int n = size();
/* 47 */     for (int i = 1; i <= n; i++)
/*    */     {
/* 49 */       CRSInfoSchema aSchema = get(i);
/* 50 */       strReturn.append(aSchema.encode());
/* 51 */       if (i == n) continue; strReturn.append("^");
/*    */     }
/*    */ 
/* 54 */     return strReturn.toString();
/*    */   }
/*    */ 
/*    */   public boolean decode(String str)
/*    */   {
/* 60 */     int nBeginPos = 0;
/* 61 */     int nEndPos = str.indexOf('^');
/* 62 */     clear();
/*    */ 
/* 64 */     while (nEndPos != -1)
/*    */     {
/* 66 */       CRSInfoSchema aSchema = new CRSInfoSchema();
/* 67 */       if (aSchema.decode(str.substring(nBeginPos, nEndPos)))
/*    */       {
/* 69 */         add(aSchema);
/* 70 */         nBeginPos = nEndPos + 1;
/* 71 */         nEndPos = str.indexOf('^', nEndPos + 1);
/*    */       }
/*    */       else
/*    */       {
/* 76 */         this.mErrors.copyAllErrors(aSchema.mErrors);
/* 77 */         return false;
/*    */       }
/*    */     }
/* 80 */     CRSInfoSchema tSchema = new CRSInfoSchema();
/* 81 */     if (tSchema.decode(str.substring(nBeginPos)))
/*    */     {
/* 83 */       add(tSchema);
/* 84 */       return true;
/*    */     }
/*    */ 
/* 89 */     this.mErrors.copyAllErrors(tSchema.mErrors);
/* 90 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vschema.CRSInfoSet
 * JD-Core Version:    0.6.0
 */