package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.utility.VData;

public abstract interface SysMaxNo
{
  public abstract String CreateMaxNo(String paramString1, String paramString2, VData paramVData);

  public abstract String CreateMaxNo(String paramString, int paramInt);

  public abstract String CreateMaxNo(String paramString1, String paramString2);
}

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.SysMaxNo
 * JD-Core Version:    0.6.0
 */