/*     */ package com.sinosoft.banklns.lnsmodel.interfaces;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPCodeDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPCustImpResultDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.pubfun.XMLByJDOM;
/*     */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPCustImpResultSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet;
/*     */ import com.sinosoft.banklns.lnsmodel.util.JSONUtil;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.EAIProxy;
/*     */ import com.sinosoft.banklns.lnsmodel.webservice.XMLEncoder;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import com.sinosoft.map.common.WebApplication;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Hashtable;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.jdom.Content;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.JDOMException;
/*     */ import org.jdom.Namespace;
/*     */ import org.jdom.xpath.XPath;
/*     */ 
/*     */ public abstract class PublicInterfaces
/*     */ {
/*  40 */   protected String message = "";
/*     */ 
/*  45 */   protected String defaultErrorMessage = null;
/*  46 */   protected String sendFileName = null;
/*  47 */   protected String returnFileName = null;
/*  48 */   protected String modelFileName = null;
/*     */ 
/*  50 */   protected boolean interfacesFlag = true;
/*  51 */   protected Namespace ns1 = null;
/*  52 */   protected Namespace ns2 = null;
/*  53 */   protected Namespace ns3 = null;
/*     */ 
/*  55 */   protected MMap map = null;
/*  56 */   protected MMap bakMap = null;
/*  57 */   protected String tContNo = null;
/*  58 */   private static Map<String, String> mapQuesKey = new Hashtable();
/*  59 */   private static Map<String, String> mapCodeKey = new Hashtable();
/*  60 */   protected boolean valiPassFlag = true;
/*     */ 
/*  62 */   private String date = PubFun.getCurrentDate();
/*  63 */   private String time = PubFun.getCurrentTime();
/*     */ 
/*  66 */   protected static Hashtable<String, Document> modelList = new Hashtable();
/*     */ 
/*  69 */   protected Document doc = null;
/*     */ 
/*  71 */   protected Document returnDoc = null;
/*     */ 
/*  74 */   protected XMLByJDOM tXMLByJDOM = null;
/*     */ 
/*  76 */   protected Connection con = null;
/*  77 */   protected ExeSQL exe = null;
/*     */ 
/*     */   public boolean calInterfaces(String contNo)
/*     */   {
/*     */     try
/*     */     {
/*  89 */       boolean flag = false;
/*  90 */       this.tContNo = contNo;
/*  91 */       initObject();
/*     */ 
/*  94 */       flag = getInputData(contNo);
/*     */ 
/*  97 */       flag = (flag) && (dealSend());
/*     */ 
/* 100 */       System.out.println("--->has used prepareDoc Func?:" + this.interfacesFlag);
/*     */ 
/* 107 */       flag = (flag) && (sendXML());
/*     */ 
/* 110 */       flag = (flag) && (dealReturn());
/*     */ 
/* 113 */       flag = (saveData()) && (flag);
/*     */ 
/* 115 */       this.message = ((this.message == null) || ("".equals(this.message)) ? this.defaultErrorMessage : this.message);
/* 116 */       boolean bool1 = flag;
/*     */       return bool1;
/*     */     }
/*     */     catch (Exception e) {
/* 119 */       e.printStackTrace();
/*     */       return false;
/*     */     }
/*     */     finally {
/*     */       try {
/* 124 */         this.con.close();
/*     */       }
/*     */       catch (SQLException e) {
/* 127 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 129 */     throw localObject;
/*     */   }
/*     */ 
/*     */   private boolean prepareDoc()
/*     */   {
/* 139 */     Element root = this.doc.getRootElement();
/* 140 */     root.addNamespaceDeclaration(this.ns1);
/* 141 */     root.addNamespaceDeclaration(this.ns2);
/* 142 */     root.addNamespaceDeclaration(this.ns3);
/* 143 */     root.setNamespace(this.ns1);
/* 144 */     List eleList = root.getChildren();
/* 145 */     Iterator it = eleList.iterator();
/* 146 */     while (it.hasNext()) {
/* 147 */       Element tempElement = (Element)it.next();
/* 148 */       if (!prepareElement(tempElement)) {
/* 149 */         return false;
/*     */       }
/*     */     }
/* 152 */     root.removeNamespaceDeclaration(this.ns3);
/* 153 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean prepareElement(Element ele)
/*     */   {
/*     */     try {
/* 159 */       List eleList = ele.getChildren();
/* 160 */       ele.setNamespace(this.ns2);
/* 161 */       Element item = new Element("item", this.ns3);
/* 162 */       if (!eleList.isEmpty()) {
/* 163 */         if ((eleList.size() >= 2) && (((Element)eleList.get(0)).getName().equals(((Element)eleList.get(1)).getName()))) {
/* 164 */           eleList = ele.removeContent();
/* 165 */           Iterator it = eleList.iterator();
/* 166 */           while (it.hasNext()) {
/* 167 */             Content tempElement = (Content)it.next();
/* 168 */             item = new Element("item", this.ns3);
/* 169 */             if ((tempElement instanceof Element)) {
/* 170 */               tempElement = (Element)tempElement;
/* 171 */               item.addContent(tempElement);
/* 172 */               if (!prepareElement((Element)tempElement)) {
/* 173 */                 return false;
/*     */               }
/*     */             }
/* 176 */             ele.addContent(item);
/*     */           }
/*     */         } else {
/* 179 */           eleList = ele.removeContent();
/* 180 */           Iterator it = eleList.iterator();
/* 181 */           while (it.hasNext()) {
/* 182 */             Content tempElement = (Content)it.next();
/* 183 */             if ((tempElement instanceof Element)) {
/* 184 */               tempElement = (Element)tempElement;
/* 185 */               item.addContent(tempElement);
/* 186 */               if (!prepareElement((Element)tempElement)) {
/* 187 */                 return false;
/*     */               }
/*     */             }
/*     */           }
/* 191 */           ele.addContent(item);
/*     */         }
/*     */       }
/* 194 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/* 197 */       e.printStackTrace();
/* 198 */     }return false;
/*     */   }
/*     */ 
/*     */   private boolean saveData()
/*     */   {
/* 305 */     if (!this.map.keySet().isEmpty()) {
/* 306 */       VData tVData = new VData();
/* 307 */       tVData.add(this.map);
/* 308 */       System.out.println("\u5F00\u59CB\u6267\u884C\u6570\u636E\u5E93\u64CD\u4F5C.......");
/* 309 */       PubSubmit tPubSubmit = new PubSubmit();
/* 310 */       if (!tPubSubmit.submitData(tVData, "")) {
/* 311 */         System.out.println("\u6570\u636E\u5E93\u64CD\u4F5C\u6267\u884C\u5931\u8D25\uFF01");
/* 312 */         return false;
/*     */       }
/*     */     }
/* 315 */     System.out.println("\u6570\u636E\u5E93\u64CD\u4F5C\u6267\u884C\u6210\u529F\uFF01");
/* 316 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean rollbakData()
/*     */   {
/* 324 */     if (!this.bakMap.keySet().isEmpty()) {
/* 325 */       VData tVData = new VData();
/* 326 */       tVData.add(this.bakMap);
/* 327 */       System.out.println("\u5F00\u59CB\u6267\u884C\u6570\u636E\u5E93\u64CD\u4F5C.......");
/* 328 */       PubSubmit tPubSubmit = new PubSubmit();
/* 329 */       if (!tPubSubmit.submitData(tVData, "")) {
/* 330 */         System.out.println("\u6570\u636E\u5E93\u64CD\u4F5C\u6267\u884C\u5931\u8D25\uFF01");
/* 331 */         return false;
/*     */       }
/*     */     }
/* 334 */     System.out.println("\u6570\u636E\u5E93\u64CD\u4F5C\u6267\u884C\u6210\u529F\uFF01");
/* 335 */     return true;
/*     */   }
/*     */ 
/*     */   public void rollbakData(VData tVData)
/*     */   {
/* 344 */     if (!this.bakMap.keySet().isEmpty())
/* 345 */       tVData.add(this.bakMap);
/*     */   }
/*     */ 
/*     */   protected abstract boolean dealReturn();
/*     */ 
/*     */   private boolean sendXML()
/*     */   {
/* 359 */     System.out.println("+++++++JSON\u62A5\u6587\uFF1A" + JSONUtil.xml2JSON(this.doc));
/* 360 */     saveCreatedXMLFile(this.doc, this.sendFileName, this.tContNo);
/* 361 */     EAIProxy tTMAProxy = new EAIProxy();
/*     */     try {
/* 363 */       tTMAProxy.setFlag(this.returnFileName);
/* 364 */       String soapReturnStr = tTMAProxy.doProcess(this.doc);
/* 365 */       soapReturnStr = XMLEncoder.toDecode(soapReturnStr);
/* 366 */       this.returnDoc = this.tXMLByJDOM.stringToXML(soapReturnStr);
/*     */ 
/* 369 */       saveCreatedXMLFile(this.returnDoc, this.returnFileName, this.tContNo);
/*     */     }
/*     */     catch (Exception e) {
/* 372 */       e.printStackTrace();
/* 373 */       return false;
/*     */     }
/* 375 */     return true;
/*     */   }
/*     */ 
/*     */   private void saveCreatedXMLFile(Document doc2, String string, String tContNo2) {
/* 379 */     new XMLSaveThread(doc2, string, tContNo2).start();
/*     */   }
/*     */ 
/*     */   protected abstract boolean dealSend();
/*     */ 
/*     */   protected abstract boolean getInputData(String paramString);
/*     */ 
/*     */   protected void initObject()
/*     */   {
/*     */     try
/*     */     {
/* 399 */       this.tXMLByJDOM = new XMLByJDOM();
/* 400 */       String rootPath = WebApplication.getInstance().getServletContextPath();
/*     */ 
/* 403 */       rootPath = "C:";
/* 404 */       String tranPath = (rootPath == null ? "" : rootPath) + File.separator + "templete" + File.separator + this.modelFileName;
/* 405 */       System.out.println("tranPath:" + tranPath);
/*     */ 
/* 408 */       if (!modelList.containsKey(this.modelFileName)) {
/* 409 */         modelList.put(this.modelFileName, this.tXMLByJDOM.loadXMLFileByJDOM(tranPath));
/*     */       }
/* 411 */       this.doc = ((Document)((Document)modelList.get(this.modelFileName)).clone());
/*     */ 
/* 414 */       this.map = new MMap();
/* 415 */       this.bakMap = new MMap();
/* 416 */       this.con = DBConnPool.getConnection();
/* 417 */       this.exe = new ExeSQL(this.con);
/*     */     }
/*     */     catch (Exception e) {
/* 420 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getMessage() {
/* 425 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message) {
/* 429 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public Element getSendBody()
/*     */   {
/* 440 */     return this.doc.getRootElement();
/*     */   }
/*     */ 
/*     */   public Element getReturnBody()
/*     */   {
/* 448 */     Element returnElement = this.returnDoc.getRootElement();
/* 449 */     System.out.println("element--name----------------->" + returnElement.getName() + "<--->" + returnElement.getNamespace());
/* 450 */     return returnElement;
/*     */   }
/*     */ 
/*     */   protected String fomartDate(String date)
/*     */   {
/* 457 */     if (date != null)
/* 458 */       return date.replaceAll("^(\\d+)-(\\d+)-(\\d+).*$", "$1$2$3");
/* 459 */     return null;
/*     */   }
/*     */ 
/*     */   protected String fomartNum(double number)
/*     */   {
/* 470 */     DecimalFormat formatDouble = new DecimalFormat("#0.00");
/* 471 */     return formatDouble.format(number);
/*     */   }
/*     */ 
/*     */   protected String getValueInXML(Document doc, String nodeName) throws JDOMException
/*     */   {
/* 476 */     Element element = (Element)XPath.selectSingleNode(doc, nodeName);
/* 477 */     return element.getText();
/*     */   }
/*     */ 
/*     */   protected String getValueInXML(Element ele, String nodeName) throws JDOMException {
/* 481 */     Element element = ele.getChild(nodeName);
/* 482 */     return element.getText();
/*     */   }
/*     */ 
/*     */   protected void updateText(Element element, String childName, String text) {
/* 486 */     if (element == null) {
/* 487 */       System.out.println("element is null!");
/*     */     }
/* 489 */     if (text != null)
/*     */     {
/* 492 */       if (this.interfacesFlag)
/* 493 */         element.getChild(childName.toUpperCase()).setText(text);
/*     */       else
/* 495 */         element.getChild(childName).setText(text);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void setSaveTime(Schema aschema)
/*     */   {
/* 509 */     aschema.setV("makedate", this.date);
/* 510 */     aschema.setV("maketime", this.time);
/* 511 */     aschema.setV("modifydate", this.date);
/* 512 */     aschema.setV("modifytime", this.time);
/*     */   }
/*     */ 
/*     */   protected void setModifyTime(Schema aschema)
/*     */   {
/* 523 */     aschema.setV("modifydate", this.date);
/* 524 */     aschema.setV("modifytime", this.time);
/*     */   }
/*     */ 
/*     */   protected String turnNullToString(Object object)
/*     */   {
/* 533 */     String rst = "";
/*     */     try {
/* 535 */       rst = object;
/*     */     } catch (Exception e) {
/* 537 */       return rst;
/*     */     }
/* 539 */     return rst.trim();
/*     */   }
/*     */ 
/*     */   protected String mappingCode(String srcCode, String codeType)
/*     */   {
/* 550 */     String tarCode = srcCode;
/* 551 */     LNPCodeDB db = new LNPCodeDB(this.con);
/* 552 */     String tKV = (String)mapCodeKey.get(codeType + srcCode);
/* 553 */     System.out.println("-->key:" + codeType + srcCode + "value:" + tKV);
/* 554 */     if ((tKV != null) && (!"".equals(tKV))) {
/* 555 */       return tKV;
/*     */     }
/* 557 */     String sql = "select * from lnpcode where code='" + srcCode + "' and CodeType='" + codeType + "'";
/* 558 */     LNPCodeSet set = db.executeQuery(sql);
/* 559 */     if (set.size() > 0) {
/* 560 */       tarCode = set.get(1).getCodeAlias();
/* 561 */       tarCode = turnNullToString(tarCode);
/* 562 */       if (mapCodeKey == null)
/* 563 */         mapCodeKey = new Hashtable();
/*     */       else {
/* 565 */         mapCodeKey.put(codeType + srcCode, tarCode);
/*     */       }
/*     */     }
/* 568 */     return tarCode;
/*     */   }
/*     */ 
/*     */   protected String mappingQues(String tarId, String policyType, String contNo, String saleChannel)
/*     */   {
/* 617 */     String answer = "";
/* 618 */     String srcId = "";
/*     */     try
/*     */     {
/* 621 */       srcId = (String)mapQuesKey.get(tarId);
/*     */ 
/* 623 */       if ((srcId != null) && (!"".equals(srcId))) {
/* 624 */         if (!srcId.startsWith(saleChannel.equals("2") ? "0301" : saleChannel.equals("1") ? "0201" : "0101")) {
/* 625 */           mapQuesKey.clear();
/*     */         }
/*     */       }
/*     */ 
/* 629 */       if ((srcId == null) || ("".equals(srcId))) {
/* 630 */         mapQuesKey.clear();
/*     */ 
/* 632 */         ExeSQL execSQL = new ExeSQL(this.con);
/* 633 */         SSRS ssrs = execSQL.execSQL("select codename,codealias from lnpcode where codetype='QueCodeMapping' and comcode='" + saleChannel + "'");
/*     */ 
/* 635 */         if ((ssrs != null) && (ssrs.MaxRow > 0)) {
/* 636 */           for (int i = 1; i <= ssrs.MaxRow; i++) {
/* 637 */             mapQuesKey.put(ssrs.GetText(i, 1), ssrs.GetText(i, 2));
/*     */           }
/*     */         }
/* 640 */         srcId = (String)mapQuesKey.get(tarId);
/*     */       }
/* 642 */       LNPCustImpResultDB db = new LNPCustImpResultDB(this.con);
/* 643 */       String sql = "select * from LNPCustImpResult where QuestionId='" + srcId + "' and ContNo='" + contNo + "' and CustomerNo='" + policyType + "'";
/* 644 */       System.out.println("-->sql\uFF1A" + sql);
/* 645 */       LNPCustImpResultSet set = db.executeQuery(sql);
/* 646 */       if (set.size() > 0) {
/* 647 */         LNPCustImpResultSchema tSchema = set.get(1);
/* 648 */         answer = "1".equals(tSchema.getQuestionType()) ? 
/* 649 */           "" : "2".equals(tSchema.getOptionId()) ? "N" : "1".equals(tSchema.getOptionId()) ? "Y" : tSchema.getAnswer();
/* 650 */         System.out.println("\u4EBA\u5458\u7C7B\u522B\uFF1A" + policyType + "------>\u6838\u5FC3\u95EE\u9898ID\uFF1A" + tarId + " | MDES\u95EE\u9898ID\uFF1A" + srcId + "--->\u95EE\u9898\u7C7B\u578B\uFF1A" + tSchema.getQuestionType() + "--->\u95EE\u9898\u7B54\u6848\uFF1A" + answer);
/*     */       }
/*     */     } catch (RuntimeException e) {
/* 653 */       System.out.println("erro------------->\u6838\u5FC3\u7CFB\u7EDFxml\u4E2D\u95EE\u9898id");
/* 654 */       e.printStackTrace();
/*     */     }
/* 656 */     return answer;
/*     */   }
/*     */   public boolean isValiPassFlag() {
/* 659 */     return this.valiPassFlag;
/*     */   }
/*     */ 
/*     */   public void setValiPassFlag(boolean valiPassFlag) {
/* 663 */     this.valiPassFlag = valiPassFlag;
/*     */   }
/*     */ 
/*     */   public String combAddress(LNPAddressSchema tAddressSchema, String type)
/*     */   {
/* 678 */     String str = "";
/*     */ 
/* 680 */     String province = "";
/* 681 */     String city = "";
/* 682 */     String county = "";
/* 683 */     String road = "";
/* 684 */     String village = "";
/*     */ 
/* 686 */     if ("1".equals(type))
/*     */     {
/* 688 */       province = tAddressSchema.getHomeFax();
/* 689 */       city = tAddressSchema.getBP();
/* 690 */       county = tAddressSchema.getHomePhone();
/* 691 */       road = tAddressSchema.getHomeAddress();
/* 692 */       village = tAddressSchema.getEMail();
/*     */ 
/* 694 */       str = tAddressSchema.getHomeAddress();
/*     */     }
/* 696 */     else if ("2".equals(type))
/*     */     {
/* 698 */       province = tAddressSchema.getCompanyFax();
/* 699 */       city = tAddressSchema.getBP2();
/* 700 */       county = tAddressSchema.getMobile2();
/* 701 */       road = tAddressSchema.getCompanyAddress();
/* 702 */       village = tAddressSchema.getEMail2();
/*     */ 
/* 704 */       str = tAddressSchema.getCompanyAddress();
/*     */     }
/*     */ 
/* 707 */     if ((province != null) && (!"".equals(province)) && (!"-1".equals(province)) && 
/* 708 */       (city != null) && (!"".equals(city)) && (!"-1".equals(city)) && 
/* 709 */       (county != null) && (!"".equals(county)) && (!"-1".equals(county)))
/*     */     {
/* 711 */       String provName = getAddressName(province);
/* 712 */       String cityName = getAddressName(city);
/*     */ 
/* 714 */       if (provName.equals(cityName))
/* 715 */         str = provName + getAddressName(county) + road + village;
/*     */       else {
/* 717 */         str = provName + cityName + getAddressName(county) + road + village;
/*     */       }
/*     */     }
/* 720 */     return str;
/*     */   }
/*     */ 
/*     */   private String getAddressName(String code) {
/* 724 */     String str = "";
/*     */ 
/* 726 */     String sql = "select codename from lnpcode where codetype='provinceCity' and code='" + code + "'";
/* 727 */     ExeSQL tExeSQL = new ExeSQL();
/*     */ 
/* 729 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/* 730 */     if (tSSRS.MaxRow > 0) {
/* 731 */       str = tSSRS.GetText(1, 1);
/*     */     }
/* 733 */     if ("--".equals(str)) {
/* 734 */       str = "";
/*     */     }
/* 736 */     return str;
/*     */   }
/*     */ 
/*     */   public String combPhone(String areaCode, String phone)
/*     */   {
/* 741 */     String str = phone;
/* 742 */     if ((areaCode == null) || ("".equals(areaCode)) || ("-1".equals(areaCode)) || ("null".equals(areaCode)) || 
/* 743 */       (phone == null) || ("".equals(phone))) {
/* 744 */       return str;
/*     */     }
/* 746 */     str = areaCode + "-" + phone;
/*     */ 
/* 748 */     return str;
/*     */   }
/*     */ 
/*     */   protected String turnToCode(String channel)
/*     */   {
/* 753 */     String code = "3";
/*     */ 
/* 755 */     if ("AGY".equals(channel))
/* 756 */       code = "1";
/* 757 */     else if ("TM".equals(channel))
/* 758 */       code = "2";
/* 759 */     else if ("BXS".equals(channel)) {
/* 760 */       code = "3";
/*     */     }
/* 762 */     return code;
/*     */   }
/*     */ 
/*     */   public String getDecryptAccount(String contno)
/*     */   {
/* 770 */     String rStr = "";
/*     */ 
/* 772 */     ExeSQL tExeSQL = new ExeSQL();
/*     */ 
/* 774 */     String sql = "OPEN SYMMETRIC KEY key_encryption DECRYPTION BY CERTIFICATE cert_keyProtection;  SELECT convert(nvarchar(500),DecryptByKey(account)) from lnppayment where contno='" + 
/* 775 */       contno + "' " + 
/* 776 */       " CLOSE SYMMETRIC KEY key_encryption";
/*     */ 
/* 778 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/*     */ 
/* 780 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 781 */       rStr = tSSRS.GetText(1, 1);
/*     */     }
/* 783 */     return rStr;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.interfaces.PublicInterfaces
 * JD-Core Version:    0.6.0
 */