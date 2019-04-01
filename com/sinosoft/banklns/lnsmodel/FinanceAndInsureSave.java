/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*     */ import com.sinosoft.banklns.lis.pubfun.ValidateTools;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
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
/*     */ public class FinanceAndInsureSave
/*     */ {
/*     */   public boolean saveImpResultWithMMap(MMap map)
/*     */     throws Exception
/*     */   {
/*  27 */     String message = "";
/*  28 */     boolean flag = true;
/*  29 */     PubSubmit ps = new PubSubmit();
/*  30 */     VData vd = new VData();
/*  31 */     vd.add(map);
/*  32 */     if (ps.submitData(vd, "")) {
/*  33 */       message = " \uFFFD\uFFFD\uFFFD\uD9B3\uDC31\uFFFD\uFFFD\u057E\uFFFD\uFFFD\uFFFD\uFFFD\u05AA\uFFFD\uFFFD\uFFFD\uFFFD\u0279\uFFFD\uFFFD\uFFFD";
/*  34 */       flag = true;
/*     */     } else {
/*  36 */       message = " \uFFFD\uFFFD\uFFFD\uD9B3\uDC31\uFFFD\uFFFD\u057E\uFFFD\uFFFD\uFFFD\uFFFD\u05AA\uFFFD\uFFFD\uFFFD\uFFFD\u02A7\uFFFD\u0723\uFFFD";
/*  37 */       flag = false;
/*     */     }
/*  39 */     System.out.println("message:" + message);
/*  40 */     return flag;
/*     */   }
/*     */ 
/*     */   public void saveImpResult(HttpSession session, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  46 */     if (session == null) {
/*  47 */       session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*     */     }
/*  49 */     if (request == null) {
/*  50 */       request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
/*     */     }
/*  52 */     if (response == null) {
/*  53 */       response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
/*     */     }
/*     */ 
/*  56 */     String contNo = (String)session.getAttribute("ContNo");
/*  57 */     String operateType = (String)session.getAttribute("initFAndIImpResultOperatType");
/*  58 */     String fAndIImpResultResultId = (String)session.getAttribute("fAndIImpResultResultId");
/*  59 */     String impartId = request.getParameter("impartId");
/*  60 */     IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/*  61 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  62 */     SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/*  63 */     String resultID = maxNoMap.CreateMaxNo("FAndIImpReId", "");
/*  64 */     boolean flag = false;
/*     */ 
/*  66 */     boolean isExistUselessCharTag = true;
/*  67 */     String message = "";
/*  68 */     MMap map = new MMap();
/*     */     try
/*     */     {
/*  71 */       ExeSQL tExeSql = new ExeSQL();
/*  72 */       String sqlfromQue = "";
/*  73 */       if (impartId != null) {
/*  74 */         sqlfromQue = "select distinct questionid,questiontype  from LnpFAndIImpQue where impartid='" + impartId + "' order by questionid ";
/*     */       }
/*  76 */       SSRS tSSRSfromDB = tExeSql.execSQL(sqlfromQue);
/*     */ 
/*  78 */       int groupOrderTag = tSSRSfromDB.MaxRow;
/*  79 */       if (groupOrderTag > 0) {
/*  80 */         Integer groupOrdercount = new Integer(1);
/*  81 */         if ((groupOrderTag / 16 > 0) && (groupOrderTag % 16 > 0)) {
/*  82 */           String str = String.valueOf(groupOrderTag / 16) + String.valueOf(groupOrderTag % 16);
/*  83 */           String strTemp = str.length() > 2 ? str.substring(0, 2) : str;
/*  84 */           groupOrdercount = Integer.valueOf(groupOrdercount.intValue() + new Integer(strTemp).intValue() / 10);
/*     */         }
/*  86 */         for (int i = 1; i <= groupOrdercount.intValue(); i++) {
/*  87 */           String sql = "";
/*     */ 
/*  89 */           int forNum = 0;
/*  90 */           if (1 == i)
/*  91 */             forNum = 16;
/*     */           else {
/*  93 */             forNum = groupOrderTag - (i - 1) * 16;
/*     */           }
/*     */ 
/*  96 */           String sqlKeyPre = "ResultId,GrpContNo,ContNo,ProposalContNo,ImpartId,Grouporder,";
/*  97 */           String sqlValuePre = "";
/*     */ 
/*  99 */           if ((operateType != null) && ("modify".equals(operateType.trim())) && (fAndIImpResultResultId != null))
/* 100 */             sqlValuePre = sqlValuePre + "'" + fAndIImpResultResultId + "',";
/*     */           else {
/* 102 */             sqlValuePre = sqlValuePre + "'" + resultID + "',";
/*     */           }
/*     */ 
/* 106 */           if (contNo != null) {
/* 107 */             LNPContSchema contSch = mainInfo.getContByContNo(contNo);
/* 108 */             sqlValuePre = sqlValuePre + "'" + contSch.getGrpContNo() + "'," + "'" + contNo + "'," + "'" + contNo + "',";
/*     */           }
/*     */ 
/* 111 */           if (impartId != null) {
/* 112 */             sqlValuePre = sqlValuePre + "'" + impartId + "',";
/*     */           }
/*     */ 
/* 115 */           sqlValuePre = sqlValuePre + "'" + String.valueOf(i) + "',";
/*     */ 
/* 117 */           String sqlKeyAft = "Operator,ManageCom,MakeDate,MakeTime,ModifyDate,ModifyTime";
/* 118 */           String sqlValueAft = "";
/*     */ 
/* 121 */           if (tempGI != null)
/* 122 */             sqlValueAft = sqlValueAft + "'" + tempGI.Operator + "'," + "'" + tempGI.ComCode + "',";
/*     */           else {
/* 124 */             sqlValueAft = sqlValueAft + "'','',";
/*     */           }
/*     */ 
/* 127 */           String date = PubFun.getCurrentDate();
/* 128 */           String time = PubFun.getCurrentTime();
/* 129 */           sqlValueAft = sqlValueAft + "'" + date + "'," + "'" + time + "'," + "'" + date + "'," + "'" + time + "'";
/*     */ 
/* 131 */           String sqlKey = "";
/* 132 */           String sqlValue = "";
/* 133 */           for (int j = 1; j <= forNum; j++) {
/* 134 */             String tempId = "";
/* 135 */             if (j < 10) {
/* 136 */               if (tSSRSfromDB.GetText(j, 1) != null) {
/* 137 */                 tempId = tSSRSfromDB.GetText(j, 1).substring(1, 9).substring(0, 7) + j;
/* 138 */                 sqlKey = sqlKey + "QID0" + j + "," + "A0" + j + ",";
/* 139 */                 if (!"3".equals(tSSRSfromDB.GetText(j, 2))) {
/* 140 */                   sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + request.getParameter(new StringBuilder("R").append(i).append(tempId).toString()) + "',";
/*     */                 } else {
/* 142 */                   String str = "";
/* 143 */                   String[] ss = request.getParameterValues("R" + i + tempId);
/* 144 */                   if (ss != null) {
/* 145 */                     for (int k = 0; k < ss.length; k++) {
/* 146 */                       str = str + ss[k];
/*     */                     }
/* 148 */                     sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + str + "',";
/*     */                   } else {
/* 150 */                     sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + "',";
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/* 155 */             else if (tSSRSfromDB.GetText(j, 1) != null) {
/* 156 */               tempId = tSSRSfromDB.GetText(j, 1).substring(1, 9).substring(0, 6) + j;
/* 157 */               sqlKey = sqlKey + "QID" + j + "," + "A" + j + ",";
/* 158 */               if (!"3".equals(tSSRSfromDB.GetText(j, 2))) {
/* 159 */                 sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + request.getParameter(new StringBuilder("R").append(i).append(tempId).toString()) + "',";
/*     */               } else {
/* 161 */                 String str = "";
/* 162 */                 String[] ss = request.getParameterValues("R" + i + tempId);
/* 163 */                 if (ss != null) {
/* 164 */                   for (int k = 0; k < ss.length; k++) {
/* 165 */                     str = str + ss[k];
/*     */                   }
/* 167 */                   sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + str + "',";
/*     */                 } else {
/* 169 */                   sqlValue = sqlValue + "'" + i + tempId + "'," + "'" + "',";
/*     */                 }
/*     */               }
/*     */             }
/*     */ 
/* 174 */             if ((request.getParameter("R" + i + tempId) == null) || 
/* 175 */               (ValidateTools.isExistUselessChar(request.getParameter("R" + i + tempId)))) continue;
/* 176 */             isExistUselessCharTag = false;
/*     */           }
/*     */ 
/* 179 */           sql = "insert into lnpfandiimpresult (" + sqlKeyPre + sqlKey + sqlKeyAft + ")" + 
/* 180 */             " values (" + sqlValuePre + sqlValue + sqlValueAft + ")";
/*     */ 
/* 182 */           if ((operateType != null) && (contNo != null)) {
/* 183 */             LNPContSchema contSch = mainInfo.getContByContNo(contNo);
/* 184 */             StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 185 */             if (("modify".equals(operateType)) && (fAndIImpResultResultId != null)) {
/* 186 */               String strDel = "delete from lnpfandiimpresult where  resultid = '" + fAndIImpResultResultId + "'" + " and grouporder = '" + String.valueOf(i) + "'";
/* 187 */               map.put(strDel, "DELETE");
/* 188 */               List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "07");
/* 189 */               contSch.setState((String)stateList.get(0));
/* 190 */               contSch.setEditstate((String)stateList.get(1));
/*     */             }
/* 192 */             if ("add".equals(operateType)) {
/* 193 */               List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "add", "07");
/* 194 */               contSch.setState((String)stateList.get(0));
/* 195 */               contSch.setEditstate((String)stateList.get(1));
/*     */             }
/* 197 */             map.put(contSch, "UPDATE");
/*     */           }
/* 199 */           map.put(sql, "INSERT");
/*     */         }
/*     */ 
/* 203 */         if (isExistUselessCharTag)
/* 204 */           flag = saveImpResultWithMMap(map);
/*     */         else
/* 206 */           message = " \uFFFD\uFFFD\uFFFD\uD9B3\uDC31\uFFFD\uFFFD\u057E\uFFFD\uFFFD\uFFFD\uFFFD\u05AA\uFFFD\u6D22\uFFFD\uFFFDSQL\uFFFD\u0430\uFFFD\u01F7\uFFFD\uFFFD\u05B7\uFFFD \uFFFD\uFFFD";
/*     */       }
/*     */       else
/*     */       {
/* 210 */         message = " \uFFFD\uFFFD\u046F\uFFFD\uFFFD\uFFFD\uD9B3\uDC31\uFFFD\uFFFD\u057E\uFFFD\uFFFD\uFFFD\uFFFD\u05AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD?";
/*     */       }
/*     */     } catch (Exception e) {
/* 213 */       e.printStackTrace();
/*     */     }
/* 215 */     System.out.println("message:" + message);
/*     */ 
/* 217 */     request.setAttribute("DisFlag", Boolean.valueOf(flag));
/* 218 */     request.setAttribute("DisMessage", message);
/*     */ 
/* 220 */     response.sendRedirect("financeAndInsure.jsf");
/*     */   }
/*     */ 
/*     */   public String getShowFlag(HttpSession session)
/*     */   {
/* 226 */     String flag = "";
/* 227 */     if (session == null) {
/* 228 */       session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*     */     }
/* 230 */     if (session != null) {
/* 231 */       String showFlag = (String)session.getAttribute("financeInformShowMsg");
/* 232 */       if ((showFlag != null) && ("1".equals(showFlag))) {
/* 233 */         flag = showFlag;
/* 234 */         session.removeAttribute("financeInformShowMsg");
/*     */       }
/*     */     }
/* 237 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.FinanceAndInsureSave
 * JD-Core Version:    0.6.0
 */