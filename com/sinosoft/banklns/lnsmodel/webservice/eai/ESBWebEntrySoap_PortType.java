package com.sinosoft.banklns.lnsmodel.webservice.eai;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface ESBWebEntrySoap_PortType extends Remote
{
  public abstract ESBEnvelopeResult processMessage(ESBEnvelope paramESBEnvelope)
    throws RemoteException;
}

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntrySoap_PortType
 * JD-Core Version:    0.6.0
 */