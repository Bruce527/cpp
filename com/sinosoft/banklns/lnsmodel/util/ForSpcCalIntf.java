package com.sinosoft.banklns.lnsmodel.util;

public abstract interface ForSpcCalIntf
{
  public abstract String handlerPTVForCBRA(String paramString, int paramInt);

  public abstract String handlerPYForADR(String paramString, int paramInt);

  public abstract String handlerPYFForADR(String paramString1, String paramString2);

  public abstract String handlerPTVForTLR(String paramString, int paramInt);
}

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.util.ForSpcCalIntf
 * JD-Core Version:    0.6.0
 */