/*    */ package com.sinosoft.banklns.lis.vschema;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.LNPCalModeSchema;
/*    */ import com.sinosoft.banklns.utility.CErrors;
/*    */ import com.sinosoft.banklns.utility.SchemaSet;
/*    */ 
/*    */ public class LNPCalModeSet extends SchemaSet
/*    */ {
/*    */   public boolean add(LNPCalModeSchema aSchema)
/*    */   {
/* 17 */     return super.add(aSchema);
/*    */   }
/*    */ 
/*    */   public boolean add(LNPCalModeSet aSet)
/*    */   {
/* 22 */     return super.add(aSet);
/*    */   }
/*    */ 
/*    */   public boolean remove(LNPCalModeSchema aSchema)
/*    */   {
/* 27 */     return super.remove(aSchema);
/*    */   }
/*    */ 
/*    */   public LNPCalModeSchema get(int index)
/*    */   {
/* 32 */     LNPCalModeSchema tSchema = (LNPCalModeSchema)super.getObj(index);
/* 33 */     return tSchema;
/*    */   }
/*    */ 
/*    */   public boolean set(int index, LNPCalModeSchema aSchema)
/*    */   {
/* 38 */     return super.set(index, aSchema);
/*    */   }
/*    */ 
/*    */   public boolean set(LNPCalModeSet aSet)
/*    */   {
/* 43 */     return super.set(aSet);
/*    */   }
/*    */ 
/*    */   public String encode()
/*    */   {
/* 49 */     StringBuffer strReturn = new StringBuffer("");
/* 50 */     int n = size();
/* 51 */     for (int i = 1; i <= n; i++)
/*    */     {
/* 53 */       LNPCalModeSchema aSchema = get(i);
/* 54 */       strReturn.append(aSchema.encode());
/* 55 */       if (i == n) continue; strReturn.append("^");
/*    */     }
/*    */ 
/* 58 */     return strReturn.toString();
/*    */   }
/*    */ 
/*    */   public boolean decode(String str)
/*    */   {
/* 64 */     int nBeginPos = 0;
/* 65 */     int nEndPos = str.indexOf('^');
/* 66 */     clear();
/*    */ 
/* 68 */     while (nEndPos != -1)
/*    */     {
/* 70 */       LNPCalModeSchema aSchema = new LNPCalModeSchema();
/* 71 */       if (aSchema.decode(str.substring(nBeginPos, nEndPos)))
/*    */       {
/* 73 */         add(aSchema);
/* 74 */         nBeginPos = nEndPos + 1;
/* 75 */         nEndPos = str.indexOf('^', nEndPos + 1);
/*    */       }
/*    */       else
/*    */       {
/* 80 */         this.mErrors.copyAllErrors(aSchema.mErrors);
/* 81 */         return false;
/*    */       }
/*    */     }
/* 84 */     LNPCalModeSchema tSchema = new LNPCalModeSchema();
/* 85 */     if (tSchema.decode(str.substring(nBeginPos)))
/*    */     {
/* 87 */       add(tSchema);
/* 88 */       return true;
/*    */     }
/*    */ 
/* 93 */     this.mErrors.copyAllErrors(tSchema.mErrors);
/* 94 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vschema.LNPCalModeSet
 * JD-Core Version:    0.6.0
 */