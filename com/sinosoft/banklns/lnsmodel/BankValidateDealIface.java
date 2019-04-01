package com.sinosoft.banklns.lnsmodel;

import java.util.List;

public abstract interface BankValidateDealIface
{
  public abstract boolean validateByContNo(String paramString);

  public abstract List<String> getErroList();

  public abstract String showErrors();
}

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BankValidateDealIface
 * JD-Core Version:    0.6.0
 */