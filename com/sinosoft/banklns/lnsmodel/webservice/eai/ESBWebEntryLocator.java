/*     */ package com.sinosoft.banklns.lnsmodel.webservice.eai;
/*     */ 
/*     */ import com.sinosoft.banklns.lnsmodel.util.EAIPropertiesFromDB;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.rmi.Remote;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import javax.xml.namespace.QName;
/*     */ import javax.xml.rpc.ServiceException;
/*     */ import org.apache.axis.AxisFault;
/*     */ import org.apache.axis.EngineConfiguration;
/*     */ import org.apache.axis.client.Service;
/*     */ import org.apache.axis.client.Stub;
/*     */ 
/*     */ public class ESBWebEntryLocator extends Service
/*     */   implements ESBWebEntry
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  30 */   private String ESBWebEntrySoap12_address = EAIPropertiesFromDB.SoapAddress;
/*     */ 
/*  37 */   private String ESBWebEntrySoap12WSDDServiceName = "ESBWebEntrySoap12";
/*     */ 
/*  75 */   private String ESBWebEntrySoap_address = EAIPropertiesFromDB.SoapAddress;
/*     */ 
/*  82 */   private String ESBWebEntrySoapWSDDServiceName = "ESBWebEntrySoap";
/*     */ 
/* 161 */   private HashSet ports = null;
/*     */ 
/*     */   public ESBWebEntryLocator()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ESBWebEntryLocator(EngineConfiguration config)
/*     */   {
/*  22 */     super(config);
/*     */   }
/*     */ 
/*     */   public ESBWebEntryLocator(String wsdlLoc, QName sName) throws ServiceException {
/*  26 */     super(wsdlLoc, sName);
/*     */   }
/*     */ 
/*     */   public String getESBWebEntrySoap12Address()
/*     */   {
/*  33 */     return this.ESBWebEntrySoap12_address;
/*     */   }
/*     */ 
/*     */   public String getESBWebEntrySoap12WSDDServiceName()
/*     */   {
/*  40 */     return this.ESBWebEntrySoap12WSDDServiceName;
/*     */   }
/*     */ 
/*     */   public void setESBWebEntrySoap12WSDDServiceName(String name) {
/*  44 */     this.ESBWebEntrySoap12WSDDServiceName = name;
/*     */   }
/*     */ 
/*     */   public ESBWebEntrySoap_PortType getESBWebEntrySoap12() throws ServiceException
/*     */   {
/*     */     try {
/*  50 */       endpoint = new URL(this.ESBWebEntrySoap12_address);
/*     */     }
/*     */     catch (MalformedURLException e)
/*     */     {
/*     */       URL endpoint;
/*  53 */       throw new ServiceException(e);
/*     */     }
/*     */     URL endpoint;
/*  55 */     return getESBWebEntrySoap12(endpoint);
/*     */   }
/*     */ 
/*     */   public ESBWebEntrySoap_PortType getESBWebEntrySoap12(URL portAddress) throws ServiceException {
/*     */     try {
/*  60 */       ESBWebEntrySoap12Stub _stub = new ESBWebEntrySoap12Stub(portAddress, this);
/*  61 */       _stub.setPortName(getESBWebEntrySoap12WSDDServiceName());
/*  62 */       return _stub;
/*     */     } catch (AxisFault e) {
/*     */     }
/*  65 */     return null;
/*     */   }
/*     */ 
/*     */   public void setESBWebEntrySoap12EndpointAddress(String address)
/*     */   {
/*  70 */     this.ESBWebEntrySoap12_address = address;
/*     */   }
/*     */ 
/*     */   public String getESBWebEntrySoapAddress()
/*     */   {
/*  78 */     return this.ESBWebEntrySoap_address;
/*     */   }
/*     */ 
/*     */   public String getESBWebEntrySoapWSDDServiceName()
/*     */   {
/*  85 */     return this.ESBWebEntrySoapWSDDServiceName;
/*     */   }
/*     */ 
/*     */   public void setESBWebEntrySoapWSDDServiceName(String name) {
/*  89 */     this.ESBWebEntrySoapWSDDServiceName = name;
/*     */   }
/*     */ 
/*     */   public ESBWebEntrySoap_PortType getESBWebEntrySoap() throws ServiceException
/*     */   {
/*     */     try {
/*  95 */       endpoint = new URL(this.ESBWebEntrySoap_address);
/*     */     }
/*     */     catch (MalformedURLException e)
/*     */     {
/*     */       URL endpoint;
/*  98 */       throw new ServiceException(e);
/*     */     }
/*     */     URL endpoint;
/* 100 */     return getESBWebEntrySoap(endpoint);
/*     */   }
/*     */ 
/*     */   public ESBWebEntrySoap_PortType getESBWebEntrySoap(URL portAddress) throws ServiceException {
/*     */     try {
/* 105 */       ESBWebEntrySoap_BindingStub _stub = new ESBWebEntrySoap_BindingStub(portAddress, this);
/* 106 */       _stub.setPortName(getESBWebEntrySoapWSDDServiceName());
/* 107 */       return _stub;
/*     */     } catch (AxisFault e) {
/*     */     }
/* 110 */     return null;
/*     */   }
/*     */ 
/*     */   public void setESBWebEntrySoapEndpointAddress(String address)
/*     */   {
/* 115 */     this.ESBWebEntrySoap_address = address;
/*     */   }
/*     */ 
/*     */   public Remote getPort(Class serviceEndpointInterface) throws ServiceException
/*     */   {
/*     */     try {
/* 121 */       if (ESBWebEntrySoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
/* 122 */         ESBWebEntrySoap12Stub _stub = new ESBWebEntrySoap12Stub(new URL(this.ESBWebEntrySoap12_address), this);
/* 123 */         _stub.setPortName(getESBWebEntrySoap12WSDDServiceName());
/* 124 */         return _stub;
/*     */       }
/* 126 */       if (ESBWebEntrySoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
/* 127 */         ESBWebEntrySoap_BindingStub _stub = new ESBWebEntrySoap_BindingStub(new URL(this.ESBWebEntrySoap_address), this);
/* 128 */         _stub.setPortName(getESBWebEntrySoapWSDDServiceName());
/* 129 */         return _stub;
/*     */       }
/*     */     }
/*     */     catch (Throwable t) {
/* 133 */       throw new ServiceException(t);
/*     */     }
/* 135 */     throw new ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
/*     */   }
/*     */ 
/*     */   public Remote getPort(QName portName, Class serviceEndpointInterface) throws ServiceException
/*     */   {
/* 140 */     if (portName == null) {
/* 141 */       return getPort(serviceEndpointInterface);
/*     */     }
/* 143 */     String inputPortName = portName.getLocalPart();
/* 144 */     if ("ESBWebEntrySoap12".equals(inputPortName)) {
/* 145 */       return getESBWebEntrySoap12();
/*     */     }
/* 147 */     if ("ESBWebEntrySoap".equals(inputPortName)) {
/* 148 */       return getESBWebEntrySoap();
/*     */     }
/*     */ 
/* 151 */     Remote _stub = getPort(serviceEndpointInterface);
/* 152 */     ((Stub)_stub).setPortName(portName);
/* 153 */     return _stub;
/*     */   }
/*     */ 
/*     */   public QName getServiceName()
/*     */   {
/* 158 */     return new QName(EAIPropertiesFromDB.ProcessMessage_ns, "ESBWebEntry");
/*     */   }
/*     */ 
/*     */   public Iterator getPorts()
/*     */   {
/* 164 */     if (this.ports == null) {
/* 165 */       this.ports = new HashSet();
/* 166 */       this.ports.add(new QName(EAIPropertiesFromDB.ProcessMessage_ns, "ESBWebEntrySoap12"));
/* 167 */       this.ports.add(new QName(EAIPropertiesFromDB.ProcessMessage_ns, "ESBWebEntrySoap"));
/*     */     }
/* 169 */     return this.ports.iterator();
/*     */   }
/*     */ 
/*     */   public void setEndpointAddress(String portName, String address)
/*     */     throws ServiceException
/*     */   {
/* 175 */     if ("ESBWebEntrySoap12".equals(portName)) {
/* 176 */       setESBWebEntrySoap12EndpointAddress(address);
/*     */     }
/* 179 */     else if ("ESBWebEntrySoap".equals(portName)) {
/* 180 */       setESBWebEntrySoapEndpointAddress(address);
/*     */     }
/*     */     else
/*     */     {
/* 184 */       throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setEndpointAddress(QName portName, String address) throws ServiceException
/*     */   {
/* 190 */     setEndpointAddress(portName.getLocalPart(), address);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntryLocator
 * JD-Core Version:    0.6.0
 */