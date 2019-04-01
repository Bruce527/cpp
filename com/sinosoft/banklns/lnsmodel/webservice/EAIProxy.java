/*     */ package com.sinosoft.banklns.lnsmodel.webservice;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.XMLByJDOM;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelope;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeESBHeader;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeMsgBody;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeResult;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeResultESBHeader;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeResultMsgBody;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntry;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntryLocator;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntrySoap_PortType;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.map.common.WebApplication;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.rmi.RemoteException;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import javax.xml.rpc.ServiceException;
/*     */ import org.apache.axis.message.MessageElement;
/*     */ import org.apache.axis.types.Time;
/*     */ import org.apache.soap.rpc.Call;
/*     */ import org.jdom.JDOMException;
/*     */ import org.jdom.input.SAXBuilder;
/*     */ import org.jdom.output.DOMOutputter;
/*     */ import org.w3c.dom.Element;
/*     */ 
/*     */ public class EAIProxy
/*     */ {
/*  31 */   private Call call = new Call();
/*     */   private String returnFileName;
/*     */ 
/*     */   public void setFlag(String flag)
/*     */   {
/*  36 */     this.returnFileName = flag;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/*  47 */     EAIProxy tma = new EAIProxy();
/*     */ 
/*  49 */     SAXBuilder builder = new SAXBuilder();
/*     */ 
/*  51 */     org.jdom.Document doc = builder.build(new File("src/issue_in11800124652720190221165937.xml"));
/*     */     try {
/*  53 */       Date tSrvDate = new Date();
/*  54 */       Time srvTime = new Time(new GregorianCalendar());
/*  55 */       DOMOutputter converter11 = new DOMOutputter();
/*  56 */       org.w3c.dom.Document domDocument = converter11.output(doc);
/*  57 */       ESBEnvelopeESBHeader tESBEnvelopeESBHeader = new ESBEnvelopeESBHeader();
/*  58 */       tESBEnvelopeESBHeader.setSenderID("MDES");
/*  59 */       tESBEnvelopeESBHeader.setSrvDate(tSrvDate);
/*  60 */       tESBEnvelopeESBHeader.setSrvTime(srvTime);
/*  61 */       tESBEnvelopeESBHeader.setReceiverID("LA");
/*  62 */       tESBEnvelopeESBHeader.setSrvOpVer("");
/*     */ 
/*  65 */       tESBEnvelopeESBHeader.setSrvOpName("NBUPLService");
/*  66 */       System.out.println(tESBEnvelopeESBHeader.getESBRspDec() + "head msg~~~~~~~~~~~~~~~~~~~");
/*  67 */       ESBEnvelopeMsgBody yESBEnvelopeMsgBody = new ESBEnvelopeMsgBody();
/*  68 */       Element root = domDocument.getDocumentElement();
/*  69 */       MessageElement thh = new MessageElement(root);
/*  70 */       MessageElement[] _any = { thh };
/*  71 */       yESBEnvelopeMsgBody.set_any(_any);
/*  72 */       ESBEnvelope tESBEnvelope = new ESBEnvelope();
/*  73 */       tESBEnvelope.setESBHeader(tESBEnvelopeESBHeader);
/*  74 */       tESBEnvelope.setMsgBody(yESBEnvelopeMsgBody);
/*  75 */       ESBWebEntry trESBWebEntry = new ESBWebEntryLocator();
/*  76 */       ESBWebEntrySoap_PortType soap = trESBWebEntry.getESBWebEntrySoap();
/*  77 */       ESBEnvelopeResult gESBEnvelopeResult = soap.processMessage(tESBEnvelope);
/*  78 */       System.out.println(gESBEnvelopeResult.getESBHeader().getESBRspDec());
/*  79 */       MessageElement[] tResult = gESBEnvelopeResult.getMsgBody().get_any();
/*  80 */       MessageElement tResult1 = tResult[0];
/*  81 */       System.out.println(tResult1);
/*     */     } catch (RemoteException e) {
/*  83 */       e.printStackTrace();
/*     */     } catch (JDOMException e) {
/*  85 */       e.printStackTrace();
/*     */     } catch (ServiceException e) {
/*  87 */       e.printStackTrace();
/*     */     } catch (Exception e) {
/*  89 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public synchronized String doProcess(org.jdom.Document doc) throws Exception
/*     */   {
/*  95 */     String returnXml = null;
/*  96 */     String flagSql = null;
/*  97 */     ExeSQL tExeSQL = new ExeSQL();
/*  98 */     SSRS tSSRS = null;
/*  99 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0))
/*     */     {
/* 101 */       if ("test".equals(tSSRS.GetText(1, 1))) {
/* 102 */         returnXml = doProcessTest(doc);
/* 103 */         System.out.println("\u63A5\u53E3\u8FD4\u56DE\u62A5\u6587\uFF1A");
/* 104 */         System.out.println(returnXml);
/* 105 */       } else if ("interface".equals(tSSRS.GetText(1, 1))) {
/* 106 */         returnXml = doProcessByAxis(doc);
/* 107 */       } else if ("interface2".equals(tSSRS.GetText(1, 1))) {
/* 108 */         returnXml = doProcessByStream(doc);
/*     */       }
/*     */     }
/* 111 */     else System.out.println("fail to read the interfaceflag...");
/*     */ 
/* 114 */     if ("prem_out".equals(this.returnFileName))
/* 115 */       flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag_Prem'";
/* 116 */     else if ("dupli_out".equals(this.returnFileName))
/* 117 */       flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag_Dupli'";
/* 118 */     else if ("aura_out".equals(this.returnFileName))
/* 119 */       flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag_Aura'";
/* 120 */     else if ("issue_out".equals(this.returnFileName))
/* 121 */       flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag_Issue'";
/* 122 */     else if ("appnt_out".equals(this.returnFileName)) {
/* 123 */       flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag_Appnt'";
/*     */     }
/*     */ 
/* 126 */     tSSRS = tExeSQL.execSQL(flagSql);
/* 127 */     if ("test".equals(tSSRS.GetText(1, 1))) {
/* 128 */       returnXml = doProcessTest(doc);
/* 129 */       System.out.println("\u63A5\u53E3\u8FD4\u56DE\u62A5\u6587\uFF1A");
/* 130 */       System.out.println(returnXml);
/* 131 */     } else if ("interface".equals(tSSRS.GetText(1, 1))) {
/* 132 */       returnXml = doProcessByAxis(doc);
/*     */     }
/* 134 */     return returnXml;
/*     */   }
/*     */ 
/*     */   private String doProcessTest(org.jdom.Document doc) throws Exception {
/* 138 */     System.out.println("\u8FDB\u5165\u63A5\u53E3\u4EA4\u4E92\u6D4B\u8BD5\u65B9\u6CD5");
/* 139 */     System.out.println("\u4F20\u5165xml\u7684\u503C\uFF1A");
/* 140 */     System.out.println(doc);
/* 141 */     XMLByJDOM tXMLByJDOM = new XMLByJDOM();
/* 142 */     String rootPath = WebApplication.getInstance().getServletContextPath();
/* 143 */     String returnStr = tXMLByJDOM.transformXMLToString(tXMLByJDOM.loadXMLFileByJDOM((rootPath == null ? "" : rootPath) + "returnfile" + File.separator + this.returnFileName + ".xml"));
/* 144 */     System.out.println("\u63A5\u53E3\u8FD4\u56DE\u503C\uFF1A");
/* 145 */     System.out.println(returnStr);
/* 146 */     return returnStr;
/*     */   }
/*     */ 
/*     */   private String doProcessByAxis(org.jdom.Document doc)
/*     */   {
/*     */     try
/*     */     {
/* 153 */       Date tSrvDate = new Date();
/* 154 */       Time srvTime = new Time(new GregorianCalendar());
/*     */ 
/* 157 */       DOMOutputter converter = new DOMOutputter();
/* 158 */       org.w3c.dom.Document domDocument = converter.output(doc);
/*     */ 
/* 161 */       ESBEnvelopeESBHeader tESBEnvelopeESBHeader = new ESBEnvelopeESBHeader();
/* 162 */       tESBEnvelopeESBHeader.setSenderID("MDES");
/* 163 */       tESBEnvelopeESBHeader.setSrvDate(tSrvDate);
/* 164 */       tESBEnvelopeESBHeader.setSrvTime(srvTime);
/* 165 */       tESBEnvelopeESBHeader.setReceiverID("LA");
/* 166 */       tESBEnvelopeESBHeader.setSrvOpVer("");
/*     */ 
/* 168 */       if ("prem_out".equals(this.returnFileName)) {
/* 169 */         tESBEnvelopeESBHeader.setSrvOpName("PRMService");
/* 170 */       } else if ("dupli_out".equals(this.returnFileName)) {
/* 171 */         tESBEnvelopeESBHeader.setSrvOpName("CLTService");
/* 172 */       } else if (("aura_out".equals(this.returnFileName)) || ("appnt_out".equals(this.returnFileName))) {
/* 173 */         tESBEnvelopeESBHeader.setSrvOpName("ValidationPolicy");
/* 174 */         tESBEnvelopeESBHeader.setReceiverID("AURA");
/* 175 */       } else if ("issue_out".equals(this.returnFileName)) {
/* 176 */         tESBEnvelopeESBHeader.setSrvOpName("NBUPLService");
/* 177 */       }System.out.println(tESBEnvelopeESBHeader.getESBRspDec() + "head msg~~~~~~~~~~~~~~~~~~~");
/*     */ 
/* 182 */       ESBEnvelopeMsgBody yESBEnvelopeMsgBody = new ESBEnvelopeMsgBody();
/* 183 */       Element root = domDocument.getDocumentElement();
/*     */ 
/* 185 */       MessageElement thh = new MessageElement(root);
/* 186 */       MessageElement[] _any = { thh };
/*     */ 
/* 203 */       yESBEnvelopeMsgBody.set_any(_any);
/*     */ 
/* 207 */       ESBEnvelope tESBEnvelope = new ESBEnvelope();
/* 208 */       tESBEnvelope.setESBHeader(tESBEnvelopeESBHeader);
/* 209 */       tESBEnvelope.setMsgBody(yESBEnvelopeMsgBody);
/*     */ 
/* 211 */       System.out.println("-------------Soap--ESBHeader " + tESBEnvelope.getESBHeader());
/* 212 */       System.out.println("-------------Soap--MsgBody " + tESBEnvelope.getMsgBody());
/* 213 */       System.out.println("-------------Soap--" + tESBEnvelope.toString());
/*     */ 
/* 216 */       ESBWebEntry trESBWebEntry = new ESBWebEntryLocator();
/* 217 */       ESBWebEntrySoap_PortType soap = trESBWebEntry.getESBWebEntrySoap();
/* 218 */       ESBEnvelopeResult gESBEnvelopeResult = soap.processMessage(tESBEnvelope);
/* 219 */       System.out.println(gESBEnvelopeResult.getESBHeader().getESBRspDec());
/*     */ 
/* 222 */       MessageElement[] tResult = gESBEnvelopeResult.getMsgBody().get_any();
/* 223 */       MessageElement tResult1 = tResult[0];
/* 224 */       System.out.println(tResult1);
/* 225 */       return tResult1.getAsString();
/*     */     }
/*     */     catch (RemoteException e) {
/* 228 */       e.printStackTrace();
/*     */     }
/*     */     catch (JDOMException e) {
/* 231 */       e.printStackTrace();
/*     */     }
/*     */     catch (ServiceException e) {
/* 234 */       e.printStackTrace();
/*     */     }
/*     */     catch (Exception e) {
/* 237 */       e.printStackTrace();
/*     */     }
/* 239 */     return null;
/*     */   }
/*     */ 
/*     */   private String doProcessByStream(org.jdom.Document doc)
/*     */   {
/* 245 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.webservice.EAIProxy
 * JD-Core Version:    0.6.0
 */