package com.sinosoft.banklns.lnsmodel.webservice.eai;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface ESBWebEntry extends Service
{
  public abstract String getESBWebEntrySoap12Address();

  public abstract ESBWebEntrySoap_PortType getESBWebEntrySoap12()
    throws ServiceException;

  public abstract ESBWebEntrySoap_PortType getESBWebEntrySoap12(URL paramURL)
    throws ServiceException;

  public abstract String getESBWebEntrySoapAddress();

  public abstract ESBWebEntrySoap_PortType getESBWebEntrySoap()
    throws ServiceException;

  public abstract ESBWebEntrySoap_PortType getESBWebEntrySoap(URL paramURL)
    throws ServiceException;
}

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntry
 * JD-Core Version:    0.6.0
 */