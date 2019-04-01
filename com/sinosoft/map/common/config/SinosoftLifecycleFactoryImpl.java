/*   */ package com.sinosoft.map.common.config;
/*   */ 
/*   */ import org.apache.myfaces.lifecycle.LifecycleFactoryImpl;
/*   */ 
/*   */ public class SinosoftLifecycleFactoryImpl extends LifecycleFactoryImpl
/*   */ {
/*   */   public static final String CUSTOM_LIFECYCLE = "SinosoftLifecycleFactoryImpl";
/*   */ 
/*   */   public SinosoftLifecycleFactoryImpl()
/*   */   {
/* 9 */     addLifecycle("SinosoftLifecycleFactoryImpl", new SinosoftLifecycleImpl());
/*   */   }
/*   */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.config.SinosoftLifecycleFactoryImpl
 * JD-Core Version:    0.6.0
 */