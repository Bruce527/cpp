/*    */ package com.sinosoft.map.common.config;
/*    */ 
/*    */ public class WebConfig
/*    */ {
/*    */   private String _webname;
/*    */   private String _logo;
/*    */   private String _banner;
/*    */   private String _icp;
/*    */   private String _comment;
/*    */ 
/*    */   public void setWebname(String webname)
/*    */   {
/* 14 */     this._webname = webname;
/*    */   }
/*    */ 
/*    */   public String getWebname()
/*    */   {
/* 19 */     return this._webname;
/*    */   }
/*    */ 
/*    */   public void setLogo(String logo)
/*    */   {
/* 24 */     this._logo = logo;
/*    */   }
/*    */ 
/*    */   public String getLogo()
/*    */   {
/* 29 */     return this._logo;
/*    */   }
/*    */ 
/*    */   public void setBanner(String banner)
/*    */   {
/* 34 */     this._banner = banner;
/*    */   }
/*    */ 
/*    */   public String getBanner()
/*    */   {
/* 39 */     return this._banner;
/*    */   }
/*    */ 
/*    */   public void setIcp(String icp)
/*    */   {
/* 44 */     this._icp = icp;
/*    */   }
/*    */ 
/*    */   public String getIcp()
/*    */   {
/* 49 */     return this._icp;
/*    */   }
/*    */ 
/*    */   public void setComment(String comment)
/*    */   {
/* 54 */     this._comment = comment;
/*    */   }
/*    */ 
/*    */   public String getComment()
/*    */   {
/* 59 */     return this._comment;
/*    */   }
/*    */ 
/*    */   public void loadWebConfig()
/*    */   {
/* 65 */     Configurator conf = new Configurator();
/* 66 */     conf.loadWebConfig(this);
/*    */   }
/*    */ 
/*    */   public void updateWebConfig() {
/* 70 */     Configurator conf = new Configurator();
/* 71 */     conf.updateWebConfig(this);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.config.WebConfig
 * JD-Core Version:    0.6.0
 */