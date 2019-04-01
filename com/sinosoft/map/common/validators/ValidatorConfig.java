/*    */ package com.sinosoft.map.common.validators;
/*    */ 
/*    */ import com.sinosoft.map.common.config.AbstractConfig;
/*    */ 
/*    */ public class ValidatorConfig extends AbstractConfig
/*    */ {
/*    */   public String getBundle()
/*    */   {
/* 17 */     return "com.sinosoft.map.international.message.innermessage";
/*    */   }
/*    */ 
/*    */   public String getStringByID(String sid, Object[] params)
/*    */   {
/* 22 */     return getBundleString(getBundle(), sid, params);
/*    */   }
/*    */ 
/*    */   public String getDatabase()
/*    */   {
/* 28 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.validators.ValidatorConfig
 * JD-Core Version:    0.6.0
 */