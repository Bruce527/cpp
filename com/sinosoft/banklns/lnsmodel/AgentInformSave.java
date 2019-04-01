/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPAgentImpResultDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*     */ import com.sinosoft.banklns.lis.pubfun.ValidateTools;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAgentImpResultSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class AgentInformSave
/*     */ {
/*     */   public void saveImpResult(HttpSession session, HttpServletRequest request, HttpServletResponse response, int queNum)
/*     */     throws Exception
/*     */   {
/*  30 */     if (session == null) {
/*  31 */       session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*     */     }
/*  33 */     if (request == null) {
/*  34 */       request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
/*     */     }
/*  36 */     if (response == null) {
/*  37 */       response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
/*     */     }
/*     */ 
/*  40 */     String contNo = (String)session.getAttribute("ContNo");
/*  41 */     String operateType = (String)session.getAttribute("initAgentInformResultOperatType");
/*  42 */     String agentInformResultId = (String)session.getAttribute("agentInformResultId");
/*  43 */     String impartId = request.getParameter("impartId");
/*  44 */     IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/*  45 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  46 */     SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/*  47 */     String resultID = maxNoMap.CreateMaxNo("AgentImpReId", "");
/*  48 */     boolean flag = false;
/*     */ 
/*  50 */     boolean isExistUselessCharTag = true;
/*  51 */     String message = "";
/*  52 */     MMap map = new MMap();
/*     */     try
/*     */     {
/*  55 */       ExeSQL tExeSql = new ExeSQL();
/*  56 */       String sqlfromQue = "";
/*  57 */       if (impartId != null) {
/*  58 */         sqlfromQue = "select distinct questionid,questiontype  from LnpAgentImpQue where impartid='" + impartId + "' order by questionid ";
/*     */       }
/*  60 */       SSRS tSSRSfromDB = tExeSql.execSQL(sqlfromQue);
/*     */ 
/*  62 */       int groupOrderTag = tSSRSfromDB.MaxRow;
/*  63 */       if ((groupOrderTag > 0) && (queNum > 0)) {
/*  64 */         Integer groupOrdercount = new Integer(1);
/*  65 */         if ((groupOrderTag / queNum > 0) && (groupOrderTag % queNum > 0)) {
/*  66 */           String str = String.valueOf(groupOrderTag / queNum) + String.valueOf(groupOrderTag % queNum);
/*  67 */           String strTemp = str.length() > 2 ? str.substring(0, 2) : str;
/*  68 */           groupOrdercount = Integer.valueOf(groupOrdercount.intValue() + new Integer(strTemp).intValue() / 10);
/*     */         }
/*  70 */         for (int i = 1; i <= groupOrdercount.intValue(); i++) {
/*  71 */           String sql = "";
/*     */ 
/*  73 */           int forNum = 0;
/*  74 */           if (1 == i)
/*  75 */             forNum = queNum;
/*     */           else {
/*  77 */             forNum = groupOrderTag - (i - 1) * queNum;
/*     */           }
/*     */ 
/*  80 */           String sqlKeyPre = "ResultId,GrpContNo,ContNo,ProposalContNo,ImpartId,Grouporder,";
/*  81 */           String sqlValuePre = "";
/*     */ 
/*  83 */           if ((operateType != null) && ("modify".equals(operateType.trim())) && (agentInformResultId != null))
/*  84 */             sqlValuePre = sqlValuePre + "'" + agentInformResultId + "',";
/*     */           else {
/*  86 */             sqlValuePre = sqlValuePre + "'" + resultID + "',";
/*     */           }
/*     */ 
/*  90 */           if (contNo != null) {
/*  91 */             LNPContSchema contSch = mainInfo.getContByContNo(contNo);
/*  92 */             sqlValuePre = sqlValuePre + "'" + contSch.getGrpContNo() + "'," + "'" + contNo + "'," + "'" + contNo + "',";
/*     */           }
/*     */ 
/*  95 */           if (impartId != null) {
/*  96 */             sqlValuePre = sqlValuePre + "'" + impartId + "',";
/*     */           }
/*     */ 
/*  99 */           sqlValuePre = sqlValuePre + "'" + String.valueOf(i) + "',";
/*     */ 
/* 101 */           String sqlKeyAft = "Operator,ManageCom,MakeDate,MakeTime,ModifyDate,ModifyTime";
/* 102 */           String sqlValueAft = "";
/*     */ 
/* 105 */           if (tempGI != null)
/* 106 */             sqlValueAft = sqlValueAft + "'" + tempGI.Operator + "'," + "'" + tempGI.ComCode + "',";
/*     */           else {
/* 108 */             sqlValueAft = sqlValueAft + "'','',";
/*     */           }
/*     */ 
/* 111 */           String date = PubFun.getCurrentDate();
/* 112 */           String time = PubFun.getCurrentTime();
/* 113 */           sqlValueAft = sqlValueAft + "'" + date + "'," + "'" + time + "'," + "'" + date + "'," + "'" + time + "'";
/*     */ 
/* 115 */           String sqlKey = "";
/* 116 */           String sqlValue = "";
/* 117 */           for (int j = 1; j <= forNum; j++) {
/* 118 */             String tempId = "";
/* 119 */             if (j < 10) {
/* 120 */               if ((tSSRSfromDB.GetText(j, 1) != null) || ("".equals(tSSRSfromDB.GetText(j, 1)))) {
/* 121 */                 tempId = tSSRSfromDB.GetText(j, 1).substring(1, 9).substring(0, 7) + j;
/* 122 */                 sqlKey = sqlKey + "QID0" + j + "," + "A0" + j + ",";
/* 123 */                 if (!"3".equals(tSSRSfromDB.GetText(j, 2))) {
/* 124 */                   sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + request.getParameter(new StringBuilder("R").append(i).append(tempId).toString()) + "',";
/*     */                 } else {
/* 126 */                   String str = "";
/* 127 */                   String[] ss = request.getParameterValues("R" + i + tempId);
/* 128 */                   if (ss != null) {
/* 129 */                     for (int k = 0; k < ss.length; k++) {
/* 130 */                       str = str + ss[k];
/*     */                     }
/* 132 */                     sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + str + "',";
/*     */                   } else {
/* 134 */                     sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + "',";
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/* 139 */             else if ((tSSRSfromDB.GetText(j, 1) != null) || ("".equals(tSSRSfromDB.GetText(j, 1)))) {
/* 140 */               tempId = tSSRSfromDB.GetText(j, 1).substring(1, 9).substring(0, 6) + j;
/* 141 */               sqlKey = sqlKey + "QID" + j + "," + "A" + j + ",";
/* 142 */               if (!"3".equals(tSSRSfromDB.GetText(j, 2))) {
/* 143 */                 sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + request.getParameter(new StringBuilder("R").append(i).append(tempId).toString()) + "',";
/*     */               } else {
/* 145 */                 String str = "";
/* 146 */                 String[] ss = request.getParameterValues("R" + i + tempId);
/* 147 */                 if (ss != null) {
/* 148 */                   for (int k = 0; k < ss.length; k++) {
/* 149 */                     str = str + ss[k];
/*     */                   }
/* 151 */                   sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + str + "',";
/*     */                 } else {
/* 153 */                   sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + "',";
/*     */                 }
/*     */               }
/*     */             }
/*     */ 
/* 158 */             if ((request.getParameter("R" + i + tempId) == null) || 
/* 159 */               (ValidateTools.isExistUselessChar(request.getParameter("R" + i + tempId)))) continue;
/* 160 */             isExistUselessCharTag = false;
/*     */           }
/*     */ 
/* 164 */           sql = "insert into LnpAgentImpResult (" + sqlKeyPre + sqlKey + sqlKeyAft + ")" + 
/* 165 */             " values (" + sqlValuePre + sqlValue + sqlValueAft + ")";
/*     */ 
/* 167 */           if ((operateType != null) && (contNo != null)) {
/* 168 */             LNPContSchema contSch = mainInfo.getContByContNo(contNo);
/* 169 */             StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 170 */             if (("modify".equals(operateType)) && (agentInformResultId != null)) {
/* 171 */               String strDel = "delete from LnpAgentImpResult where  resultid = '" + agentInformResultId + "'" + " and grouporder = '" + String.valueOf(i) + "'";
/* 172 */               map.put(strDel, "DELETE");
/* 173 */               List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "09");
/* 174 */               contSch.setState((String)stateList.get(0));
/* 175 */               contSch.setEditstate((String)stateList.get(1));
/*     */             }
/* 177 */             if ("add".equals(operateType)) {
/* 178 */               if ((checkDataNum(contNo)) || (checkApprizDataNum(contNo))) {
/* 179 */                 List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "09");
/* 180 */                 contSch.setState((String)stateList.get(0));
/* 181 */                 contSch.setEditstate((String)stateList.get(1));
/*     */               } else {
/* 183 */                 List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "add", "09");
/* 184 */                 contSch.setState((String)stateList.get(0));
/* 185 */                 contSch.setEditstate((String)stateList.get(1));
/*     */               }
/*     */             }
/*     */ 
/* 189 */             if ("2".equals(contSch.getUWFlag())) {
/* 190 */               contSch.setUWFlag("1");
/*     */             }
/* 192 */             map.put(contSch, "UPDATE");
/*     */           }
/* 194 */           map.put(sql, "INSERT");
/*     */         }
/* 196 */         if (isExistUselessCharTag) {
/* 197 */           PubSubmit ps = new PubSubmit();
/* 198 */           VData vd = new VData();
/* 199 */           vd.add(map);
/* 200 */           if (ps.submitData(vd, "")) {
/* 201 */             message = " \u4EE3\u7406\u4EBA\u544A\u77E5\u4FDD\u5B58\u6210\u529F\uFF01";
/* 202 */             flag = true;
/*     */           } else {
/* 204 */             message = " \u4EE3\u7406\u4EBA\u544A\u77E5\u4FDD\u5B58\u5931\u8D25\uFF01";
/* 205 */             flag = false;
/*     */           }
/*     */         } else {
/* 208 */           message = " \u4EE3\u7406\u4EBA\u544A\u77E5\u5B58\u50A8\u7684SQL\u4E2D\u5305\u542B\u975E\u6CD5\u5B57\u7B26 \uFF01";
/*     */         }
/*     */       } else {
/* 211 */         message = " \u67E5\u8BE2\u4EE3\u7406\u4EBA\u544A\u77E5\u95EE\u9898\u51FA\u9519\uFF01";
/*     */       }
/*     */     } catch (Exception e) {
/* 214 */       e.printStackTrace();
/*     */     }
/* 216 */     System.out.println("message:" + message);
/*     */ 
/* 218 */     request.setAttribute("DisFlag", Boolean.valueOf(flag));
/* 219 */     request.setAttribute("DisMessage", message);
/*     */ 
/* 221 */     response.sendRedirect("agentInform.jsf");
/*     */   }
/*     */ 
/*     */   private boolean checkDataNum(String contNoStr)
/*     */   {
/* 229 */     LNPAgentInfoDB db = new LNPAgentInfoDB();
/* 230 */     String sql = "select * from lnpagentinfo where  contno = '" + contNoStr + "'";
/* 231 */     LNPAgentInfoSet iSet = db.executeQuery(sql);
/*     */ 
/* 233 */     return (iSet != null) && (iSet.size() > 0);
/*     */   }
/*     */ 
/*     */   private boolean checkApprizDataNum(String contNoStr)
/*     */   {
/* 241 */     LNPAgentImpResultDB db = new LNPAgentImpResultDB();
/* 242 */     String sql = "select * from LNPAgentImpResult where  ContNo = '" + contNoStr + "'";
/* 243 */     LNPAgentImpResultSet ihSet = db.executeQuery(sql);
/*     */ 
/* 245 */     return (ihSet != null) && (ihSet.size() > 0);
/*     */   }
/*     */ 
/*     */   public String getShowFlag(HttpSession session)
/*     */   {
/* 252 */     String flag = "";
/* 253 */     if (session == null) {
/* 254 */       session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*     */     }
/* 256 */     if (session != null) {
/* 257 */       String showFlag = (String)session.getAttribute("agentInformShowMsg");
/* 258 */       if ((showFlag != null) && ("1".equals(showFlag))) {
/* 259 */         flag = showFlag;
/* 260 */         session.removeAttribute("agentInformShowMsg");
/*     */       }
/*     */     }
/* 263 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.AgentInformSave
 * JD-Core Version:    0.6.0
 */