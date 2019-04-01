/*    */ package com.sinosoft.map.common.config;
/*    */ 
/*    */ public class BaseConfig extends AbstractConfig
/*    */ {
/*    */   public String getBundle()
/*    */   {
/* 16 */     return "com.sinosoft.map.international.resource.programresource";
/*    */   }
/*    */ 
/*    */   public String getStringByID(String sid, Object[] params)
/*    */   {
/* 21 */     return getBundleString(getBundle(), sid, params);
/*    */   }
/*    */ 
/*    */   public String getDatabase()
/*    */   {
/* 30 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.config.BaseConfig
 * JD-Core Version:    0.6.0
 */