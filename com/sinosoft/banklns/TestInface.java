/*     */ package com.sinosoft.banklns;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.XMLByJDOM;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelope;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeESBHeader;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeMsgBody;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeResult;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeResultESBHeader;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntry;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntryLocator;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntrySoap_PortType;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.axis.message.MessageElement;
/*     */ import org.apache.axis.types.Time;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.output.DOMOutputter;
/*     */ 
/*     */ public class TestInface
/*     */ {
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/*  34 */     XMLByJDOM tXMLByJDOM = new XMLByJDOM();
/*     */ 
/*  37 */     FDate fDate = new FDate();
/*  38 */     Date tSrvDate = fDate.getDate(PubFun.getCurrentDate());
/*  39 */     Time srvTime = new Time(PubFun.getCurrentTime());
/*     */ 
/*  41 */     String filePath = "D:\\";
/*     */ 
/*  43 */     String xmlFile = filePath + "requestForQuestion1.xml";
/*  44 */     xmlFile = filePath + "out_test.xml";
/*     */ 
/*  46 */     org.jdom.Document doc = tXMLByJDOM.loadXMLFileByJDOM(xmlFile);
/*     */ 
/*  49 */     System.out.println(tXMLByJDOM.transformXMLToString(doc));
/*     */ 
/*  51 */     DOMOutputter converter = new DOMOutputter();
/*  52 */     org.w3c.dom.Document domDocument = converter.output(doc);
/*     */ 
/*  55 */     ESBEnvelopeESBHeader tESBEnvelopeESBHeader = new ESBEnvelopeESBHeader();
/*  56 */     tESBEnvelopeESBHeader.setSenderID("MDES");
/*  57 */     tESBEnvelopeESBHeader.setSrvDate(tSrvDate);
/*  58 */     tESBEnvelopeESBHeader.setSrvTime(srvTime);
/*  59 */     tESBEnvelopeESBHeader.setReceiverID("LA");
/*     */ 
/*  61 */     tESBEnvelopeESBHeader.setSrvOpName("calPremiumservice");
/*     */ 
/*  63 */     ESBEnvelopeMsgBody yESBEnvelopeMsgBody = new ESBEnvelopeMsgBody();
/*  64 */     MessageElement thh = new MessageElement(domDocument.getDocumentElement());
/*  65 */     MessageElement[] _any = { thh };
/*  66 */     yESBEnvelopeMsgBody.set_any(_any);
/*     */ 
/*  71 */     ESBEnvelope tESBEnvelope = new ESBEnvelope();
/*  72 */     tESBEnvelope.setESBHeader(tESBEnvelopeESBHeader);
/*  73 */     tESBEnvelope.setMsgBody(yESBEnvelopeMsgBody);
/*     */ 
/*  76 */     ESBWebEntry trESBWebEntry = new ESBWebEntryLocator();
/*  77 */     ESBWebEntrySoap_PortType soap = trESBWebEntry.getESBWebEntrySoap();
/*  78 */     ESBEnvelopeResult gESBEnvelopeResult = soap.processMessage(tESBEnvelope);
/*  79 */     System.out.println(gESBEnvelopeResult.getESBHeader().getESBRspDec());
/*     */ 
/*  91 */     Element root = doc.getRootElement();
/*  92 */     Element errorN = root.getChild("ERROR");
/*     */ 
/*  94 */     Element reasonN = errorN.getChild("item").getChild("REASON");
/*  95 */     List errorItemNList = reasonN.getChildren();
/*  96 */     String message = "";
/*  97 */     for (Element e : errorItemNList) {
/*  98 */       String valiReason = e.getChild("ERRORDESC").getText();
/*  99 */       message = message + valiReason + "</br>";
/*     */     }
/* 101 */     System.out.println(message);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.TestInface
 * JD-Core Version:    0.6.0
 */