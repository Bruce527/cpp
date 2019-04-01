package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.VData;

public abstract interface PubBLInterface
{
  public abstract VData getResult();

  public abstract CErrors getErrors();

  public abstract boolean dealData();

  public abstract boolean checkData();

  public abstract boolean getInputData(VData paramVData);

  public abstract boolean submitData(VData paramVData, String paramString);
}

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.PubBLInterface
 * JD-Core Version:    0.6.0
 */