package com.sinosoft.banklns.utility;

import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
import java.util.List;

public abstract interface CodeQueryIntf
{
  public abstract List getInfoByCodeType(String paramString);

  public abstract LNPCodeSchema getinfoById(String paramString1, String paramString2);

  public abstract List getInfoByConditions(LNPCodeSchema paramLNPCodeSchema);

  public abstract List getInfoBySql(String paramString)
    throws Exception;

  public abstract String getTextByCodeAndType(String paramString1, String paramString2);
}

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.CodeQueryIntf
 * JD-Core Version:    0.6.0
 */