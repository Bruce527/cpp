/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ import com.sinosoft.map.lis.encrypt.LisIDEA;
/*    */ 
/*    */ public class EncryptURL
/*    */ {
/*  8 */   private String url = "";
/*    */ 
/*    */   public String getUrl()
/*    */   {
/* 12 */     return this.url;
/*    */   }
/*    */ 
/*    */   public void setUrl(String url)
/*    */   {
/*    */     try
/*    */     {
/* 19 */       this.url = url;
/*    */ 
/* 21 */       if ((url != null) && (!"".equals(url)))
/*    */       {
/* 23 */         int splitIndex = url.indexOf("?");
/*    */ 
/* 25 */         if (splitIndex > 0)
/*    */         {
/* 27 */           String[] urlArr = new String[2];
/* 28 */           urlArr[0] = url.substring(0, splitIndex);
/* 29 */           urlArr[1] = url.substring(splitIndex + 1);
/*    */ 
/* 31 */           LisIDEA tLisIDEA = new LisIDEA();
/*    */ 
/* 33 */           this.url = (urlArr[0] + "?arg=" + tLisIDEA.encryptString(urlArr[1]));
/*    */         }
/*    */         else
/*    */         {
/* 38 */           this.url = "";
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 43 */         this.url = "";
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception ex)
/*    */     {
/* 49 */       this.url = "";
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.EncryptURL
 * JD-Core Version:    0.6.0
 */