/*     */ package com.sinosoft.map.common.logs;
/*     */ 
/*     */ import com.sinosoft.map.ec.utility.ECPubFun;
/*     */ import com.sinosoft.map.ec.utility.XmlParser;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.Text;
/*     */ 
/*     */ public class VisitorLog
/*     */   implements Serializable
/*     */ {
/*  34 */   public static List<LogInfo> webOperateInfoList = new ArrayList();
/*     */ 
/*     */   public static synchronized void logClick(LogInfo tLogInfo)
/*     */   {
/*     */     try
/*     */     {
/*  50 */       int j = 0;
/*  51 */       j = createUserVisitor(tLogInfo);
/*     */ 
/*  53 */       File visitorLogFile = getLogFile(ECPubFun.getCurrentDate());
/*  54 */       Document doc = XmlParser.getDocument(visitorLogFile);
/*  55 */       Element root = doc.getDocumentElement();
/*  56 */       NodeList ips = root.getElementsByTagName("visitor");
/*     */ 
/*  58 */       Element visitorNode = (Element)ips.item(j);
/*  59 */       Element uri = doc.createElement("uri");
/*  60 */       Text eIP_text = doc.createTextNode(tLogInfo.getOperateStr());
/*     */ 
/*  62 */       uri.appendChild(eIP_text);
/*  63 */       uri.setAttribute("time", tLogInfo.getOperateDate() + " " + 
/*  64 */         tLogInfo.getOperateTime());
/*     */ 
/*  66 */       visitorNode.appendChild(uri);
/*     */ 
/*  68 */       String filename = "webvisitorlog" + ECPubFun.getCurrentDate() + ".xml";
/*  69 */       String vlog = getVlogPath() + "/" + filename;
/*  70 */       XmlParser.saveDocument(doc, vlog);
/*     */     } catch (Exception saxe) {
/*  72 */       saxe.printStackTrace();
/*  73 */       ErrorsLog.log("Exception:VisitorLog:log:" + saxe.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public static synchronized void logClick(List<LogInfo> tLogInfos)
/*     */   {
/*  80 */     if ((tLogInfos == null) || (tLogInfos.isEmpty())) {
/*  81 */       return;
/*     */     }
/*     */     try
/*     */     {
/*  85 */       File visitorLogFile = getLogFile(ECPubFun.getCurrentDate());
/*  86 */       Document doc = XmlParser.getDocument(visitorLogFile);
/*  87 */       Element xRoot = doc.getDocumentElement();
/*  88 */       NodeList visitors = xRoot.getElementsByTagName("visitor");
/*  89 */       int len = visitors.getLength();
/*     */ 
/*  91 */       for (LogInfo tLogInfo1 : tLogInfos)
/*     */       {
/*  93 */         String flag = "0";
/*  94 */         for (int i = 0; i < len; i++)
/*     */         {
/*  96 */           Element xVisitor = (Element)visitors.item(i);
/*  97 */           String userCode = xVisitor.getElementsByTagName("user").item(0).getTextContent().trim();
/*     */ 
/*  99 */           if (!tLogInfo1.getUsercode().equals(userCode))
/*     */             continue;
/* 101 */           flag = "1";
/*     */         }
/*     */ 
/* 106 */         if (!flag.equals("0"))
/*     */           continue;
/* 108 */         Element xVisitor = doc.createElement("visitor");
/* 109 */         Element xUser = doc.createElement("user");
/*     */ 
/* 111 */         Text Operate_text = null;
/* 112 */         Operate_text = doc.createTextNode(tLogInfo1.getUsercode());
/* 113 */         xRoot.appendChild(xVisitor);
/* 114 */         xVisitor.appendChild(xUser);
/* 115 */         xUser.appendChild(Operate_text);
/* 116 */         XmlParser.saveDocument(doc, visitorLogFile);
/*     */ 
/* 118 */         len++;
/*     */       }
/*     */ 
/* 123 */       visitorLogFile = getLogFile(ECPubFun.getCurrentDate());
/* 124 */       doc = XmlParser.getDocument(visitorLogFile);
/* 125 */       xRoot = doc.getDocumentElement();
/* 126 */       visitors = xRoot.getElementsByTagName("visitor");
/* 127 */       len = visitors.getLength();
/*     */ 
/* 129 */       for (LogInfo tLogInfo2 : tLogInfos) {
/* 130 */         for (int i = 0; i < len; i++)
/*     */         {
/* 132 */           Element xVisitor = (Element)visitors.item(i);
/* 133 */           String userCode = xVisitor.getElementsByTagName("user").item(0).getTextContent();
/*     */ 
/* 135 */           if (!tLogInfo2.getUsercode().equals(userCode))
/*     */             continue;
/* 137 */           Element uri = doc.createElement("uri");
/* 138 */           Text Operate_text = doc.createTextNode(tLogInfo2.getOperateStr());
/* 139 */           uri.appendChild(Operate_text);
/* 140 */           uri.setAttribute("time", tLogInfo2.getOperateDate() + " " + 
/* 141 */             tLogInfo2.getOperateTime());
/*     */ 
/* 143 */           xVisitor.appendChild(uri);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 148 */       XmlParser.saveDocument(doc, visitorLogFile);
/*     */     }
/*     */     catch (Exception e) {
/* 151 */       ErrorsLog.log("Exception:VisitorLog:logClick(manay):" + 
/* 152 */         e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public static synchronized int createUserVisitor(LogInfo tLogInfo)
/*     */   {
/* 159 */     int reindex = -1;
/*     */     try
/*     */     {
/* 162 */       int flag = -1;
/*     */ 
/* 164 */       File visitorLogFile = getLogFile(ECPubFun.getCurrentDate());
/* 165 */       Document doc = XmlParser.getDocument(visitorLogFile);
/*     */ 
/* 167 */       LogInfo rLogInfo = tLogInfo;
/* 168 */       Element xRoot = doc.getDocumentElement();
/*     */ 
/* 170 */       NodeList ips = xRoot.getElementsByTagName("visitor");
/*     */ 
/* 172 */       for (int i = 0; i < ips.getLength(); i++)
/*     */       {
/* 174 */         Element temp = (Element)ips.item(i);
/* 175 */         NodeList tUser = temp.getElementsByTagName("user");
/* 176 */         Element userCode = (Element)tUser.item(0);
/*     */ 
/* 178 */         if (userCode.getTextContent().trim().equals(rLogInfo.getUsercode())) {
/* 179 */           flag = i;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 184 */       if (flag != -1)
/*     */       {
/* 186 */         reindex = flag;
/*     */       }
/*     */       else
/*     */       {
/* 190 */         Element xVisitor = doc.createElement("visitor");
/* 191 */         Element xUser = doc.createElement("user");
/*     */ 
/* 193 */         Text xUser_text = null;
/* 194 */         xUser_text = doc.createTextNode(rLogInfo.getUsercode());
/*     */ 
/* 196 */         xRoot.appendChild(xVisitor);
/* 197 */         xVisitor.appendChild(xUser);
/* 198 */         xUser.appendChild(xUser_text);
/* 199 */         XmlParser.saveDocument(doc, visitorLogFile);
/*     */ 
/* 201 */         int ttflag = -1;
/*     */ 
/* 203 */         for (int i = 0; i < ips.getLength(); i++)
/*     */         {
/* 205 */           Element temp = (Element)ips.item(i);
/* 206 */           NodeList tUser = temp.getElementsByTagName("user");
/* 207 */           Element userCode = (Element)tUser.item(0);
/*     */ 
/* 209 */           if (userCode.getTextContent().trim().equals(rLogInfo.getUsercode())) {
/* 210 */             ttflag = i;
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 215 */         reindex = ttflag;
/*     */       }
/*     */     }
/*     */     catch (Exception saxe)
/*     */     {
/* 220 */       saxe.printStackTrace();
/* 221 */       ErrorsLog.log("Exception:VisitorLog:log:" + saxe.getMessage());
/*     */     }
/*     */ 
/* 224 */     return reindex;
/*     */   }
/*     */ 
/*     */   private static File getLogFile(String date)
/*     */   {
/* 234 */     String filename = "webvisitorlog" + date + ".xml";
/* 235 */     String vlog = getVlogPath() + File.separator + filename;
/* 236 */     File file = new File(vlog);
/* 237 */     if (!file.exists()) {
/* 238 */       newXML(vlog);
/*     */     }
/*     */ 
/* 241 */     return file;
/*     */   }
/*     */ 
/*     */   private static void newXML(String path)
/*     */   {
/*     */     try
/*     */     {
/* 248 */       Document doc = XmlParser.newDocument();
/* 249 */       Element root = doc.createElement("root");
/* 250 */       doc.appendChild(root);
/* 251 */       XmlParser.saveDocument(doc, path);
/*     */     } catch (Exception e) {
/* 253 */       e.printStackTrace();
/* 254 */       ErrorsLog.log("Exception:VisitorLog:newXML:" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   private static String getVlogPath()
/*     */   {
/* 261 */     String sql = "select varvalue from msysvar where vartype='logsPath' ";
/* 262 */     ExeSQL tExeSQL = new ExeSQL();
/* 263 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/* 264 */     String path = tSSRS.GetText(1, 1);
/*     */ 
/* 266 */     path = path + File.separator + "web" + File.separator + "webvisitorlog";
/* 267 */     return path;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.logs.VisitorLog
 * JD-Core Version:    0.6.0
 */