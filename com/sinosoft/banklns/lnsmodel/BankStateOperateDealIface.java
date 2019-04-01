package com.sinosoft.banklns.lnsmodel;

import java.util.List;

public abstract interface BankStateOperateDealIface
{
  public abstract boolean checkOperate(String paramString1, String paramString2, int paramInt);

  public abstract boolean checkEditOperate(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);

  public abstract List<String> infoOprate(String paramString1, String paramString2, String paramString3, String paramString4);

  public abstract boolean checkEditOperate(String paramString1, String paramString2, String paramString3, String paramString4);

  public abstract boolean checkButtonOperate(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4);

  public abstract String updateEditStateDone(String paramString, int paramInt);

  public abstract String updateEditStateUNDone(String paramString, int paramInt);
}

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BankStateOperateDealIface
 * JD-Core Version:    0.6.0
 */