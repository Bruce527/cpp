/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPCustImpResultDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*     */ import com.sinosoft.banklns.lis.pubfun.ValidateTools;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPCustImpResultSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet;
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
/*     */ public class ImpartDeal
/*     */ {
/*     */   private String message;
/*     */ 
/*     */   public boolean dealImpResult(LNPCustImpResultSet relSet, String operateType, LNPContSchema contSch)
/*     */   {
/*  29 */     boolean flag = false;
/*     */ 
/*  31 */     PubSubmit ps = new PubSubmit();
/*  32 */     MMap map = new MMap();
/*     */ 
/*  34 */     if ((relSet != null) && (operateType != null) && (contSch != null)) {
/*     */       try {
/*  36 */         if (operateType.equals("modify")) {
/*  37 */           LNPCustImpResultSchema rSch = relSet.get(1);
/*  38 */           LNPCustImpResultDB db = new LNPCustImpResultDB();
/*  39 */           db.setContNo(rSch.getContNo());
/*  40 */           db.setCustomerId(rSch.getCustomerId());
/*  41 */           db.setImpartId(rSch.getImpartId());
/*     */ 
/*  43 */           LNPCustImpResultSet delSet = db.query();
/*  44 */           map.put(delSet, "DELETE");
/*     */         }
/*     */ 
/*  48 */         StateOperatorDeal operatorDeal = new StateOperatorDeal();
/*  49 */         List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "08");
/*     */ 
/*  51 */         contSch.setState((String)stateList.get(0));
/*  52 */         contSch.setEditstate((String)stateList.get(1));
/*     */ 
/*  55 */         if ("2".equals(contSch.getUWFlag())) {
/*  56 */           contSch.setUWFlag("1");
/*     */         }
/*  58 */         map.put(relSet, "INSERT");
/*  59 */         map.put(contSch, "UPDATE");
/*     */ 
/*  61 */         VData vd = new VData();
/*  62 */         vd.add(map);
/*  63 */         if (!ps.submitData(vd, "")) {
/*  64 */           System.out.println("-ImpartDeal-\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD");
/*  65 */           this.message = "JAVA : \u951F\u65A4\u62F7\u951F\u8857\uE04E\u62F7\u951F\u8F83\uE76E\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7";
/*     */         } else {
/*  67 */           this.message = "JAVA : \u951F\u65A4\u62F7\u951F\u8857\uE04E\u62F7\u951F\u8F83\uE76E\u62F7\u951F\u65A4\u62F7\u951F\u7F34\u7678\u62F7\u951F\u65A4\u62F7";
/*  68 */           flag = true;
/*     */         }
/*     */       }
/*     */       catch (RuntimeException e) {
/*  72 */         e.printStackTrace();
/*     */       }
/*  74 */       System.out.println(this.message);
/*     */     }
/*  76 */     return flag;
/*     */   }
/*     */ 
/*     */   public String getImpartType(HttpSession session) {
/*  80 */     String impartType = "";
/*  81 */     if (session == null) {
/*  82 */       session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*     */     }
/*  84 */     String contNo = (String)session.getAttribute("ContNo");
/*     */ 
/*  87 */     ExeSQL tExeSql = new ExeSQL();
/*  88 */     if ((contNo != null) && (!"".equals(contNo.trim()))) {
/*  89 */       String sqlFromQue = "select top 1 impartid from LNPCustImpResult where contno = '" + contNo + "'";
/*     */ 
/*  91 */       SSRS ssrsFromQue = tExeSql.execSQL(sqlFromQue);
/*  92 */       if ((ssrsFromQue != null) && (ssrsFromQue.MaxRow > 0)) {
/*  93 */         if (ssrsFromQue.GetText(1, 1) != null)
/*  94 */           impartType = ssrsFromQue.GetText(1, 1).trim();
/*     */       }
/*     */       else {
/*  97 */         String sqlFromT = "select top 1 imp.impartid from lnppol pol,lnpriskconfig cfg,lnpcustimpart imp where pol.masterpolno = pol.polno and cfg.riskcode = pol.riskcode and pol.contno='" + 
/*  99 */           contNo + "' " + 
/* 100 */           "and cfg.imparttype = imp.proposaltype order by imp.impartver desc ";
/* 101 */         SSRS ssrsFromT = tExeSql.execSQL(sqlFromT);
/* 102 */         if ((ssrsFromT != null) && (ssrsFromT.MaxRow > 0) && 
/* 103 */           (ssrsFromT.GetText(1, 1) != null)) {
/* 104 */           impartType = ssrsFromT.GetText(1, 1).trim();
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 109 */     return impartType;
/*     */   }
/*     */ 
/*     */   public void saveInsuDiscripImpart(HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 115 */     HttpSession session = request.getSession(true);
/*     */ 
/* 117 */     if (session != null)
/*     */     {
/* 123 */       String ses = (String)session.getAttribute("insuDiscripInformSubmit");
/* 124 */       if (ses == null)
/*     */       {
/* 127 */         session.setAttribute("insuDiscripInformSubmit", "2");
/*     */       }
/*     */       else {
/* 130 */         return;
/*     */       }
/*     */ 
/* 133 */       String impartId = request.getParameter("impartId");
/* 134 */       String contNo = (String)session.getAttribute("ContNo");
/*     */ 
/* 136 */       if (contNo != null) {
/* 137 */         PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 138 */         LNPContSchema contSch = mainInfo.getContByContNo(contNo);
/*     */ 
/* 140 */         String InsuredId = contSch.getInsuredId();
/* 141 */         String operateType = request.getParameter("operateType");
/* 142 */         System.out.println("-- operateType --" + operateType);
/* 143 */         IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/* 144 */         boolean flag = false;
/*     */ 
/* 146 */         String errorMsg = "";
/*     */ 
/* 149 */         boolean isExistUselessCharTag = true;
/* 150 */         LNPCustImpResultSet relSet = new LNPCustImpResultSet();
/*     */         try
/*     */         {
/* 153 */           ExeSQL tExeSql1 = new ExeSQL();
/* 154 */           String sql = "";
/* 155 */           sql = "select distinct questionid  from LNPCustImpQue where impartid='" + 
/* 156 */             impartId + "' and questiontype in('1','2') ";
/*     */ 
/* 158 */           SSRS tSSRS1 = tExeSql1.execSQL(sql);
/*     */ 
/* 160 */           SSRS tSSRS2 = new SSRS();
/*     */ 
/* 162 */           if (tSSRS1.MaxRow > 0) {
/* 163 */             String date = 
/* 164 */               PubFun.getCurrentDate();
/* 165 */             String time = 
/* 166 */               PubFun.getCurrentTime();
/*     */ 
/* 168 */             SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 169 */             LNPCustImpResultSchema relSch = null;
/* 170 */             for (int i = 1; i <= tSSRS1.MaxRow; i++) {
/* 171 */               if ((request.getParameter("R" + tSSRS1.GetText(i, 1)) == null) || 
/* 172 */                 (request.getParameter("R" + tSSRS1.GetText(i, 1)).equals(""))) continue;
/* 173 */               relSch = new LNPCustImpResultSchema();
/*     */ 
/* 177 */               sql = "select questionid,questiontype,queorder,innerorder,innerquenum,childquenum from LNPCustImpQue where impartid='" + 
/* 179 */                 impartId + 
/* 180 */                 "' and questionid='" + 
/* 181 */                 tSSRS1.GetText(i, 1) + "' ;";
/*     */ 
/* 183 */               tSSRS2 = tExeSql1.execSQL(sql);
/* 184 */               if (tSSRS2.MaxRow > 0) {
/* 185 */                 if (tSSRS2.GetText(1, 2).equals("1")) {
/* 186 */                   String optionid = request.getParameter("R" + 
/* 187 */                     tSSRS2.GetText(1, 1));
/* 188 */                   relSch.setOptionId(optionid);
/* 189 */                 } else if (tSSRS2.GetText(1, 2).equals("2")) {
/* 190 */                   relSch.setAnswer(request.getParameter("R" + 
/* 191 */                     tSSRS2.GetText(1, 1)));
/*     */                 }
/* 193 */                 relSch.setResultId(maxNoMap.CreateMaxNo(
/* 194 */                   "ImpReslutId", ""));
/* 195 */                 relSch.setImpartId(impartId);
/* 196 */                 relSch.setQuestionId(tSSRS2.GetText(1, 1));
/* 197 */                 relSch.setContNo(contNo);
/* 198 */                 relSch.setProposalContNo(contNo);
/* 199 */                 relSch.setCustomerId(InsuredId);
/* 200 */                 relSch.setQuestionType(tSSRS2.GetText(1, 2));
/* 201 */                 relSch.setOperator(tempGI.Operator);
/* 202 */                 relSch.setManageCom(tempGI.ComCode);
/* 203 */                 relSch.setMakeDate(date);
/* 204 */                 relSch.setMakeTime(time);
/* 205 */                 relSch.setModifyDate(date);
/* 206 */                 relSch.setModifyTime(time);
/* 207 */                 contSch.setModifyDate(date);
/* 208 */                 contSch.setModifyTime(time);
/*     */ 
/* 210 */                 relSet.add(relSch);
/*     */               } else {
/* 212 */                 errorMsg = "\u951F\u65A4\u62F7\u8BE2\u951F\u65A4\u62F7\u77E5\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD?";
/*     */               }
/* 214 */               if (!ValidateTools.isExistUselessChar(request.getParameter("R" + tSSRS1.GetText(i, 1))))
/* 215 */                 isExistUselessCharTag = false;
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 220 */             errorMsg = "\u951F\u65A4\u62F7\u8BE2\u951F\u65A4\u62F7\u77E5\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD?";
/*     */           }
/*     */ 
/* 223 */           System.out.println("-- relset.size --" + relSet.size());
/* 224 */           if (relSet.size() > 0) {
/* 225 */             if (isExistUselessCharTag) {
/* 226 */               ImpartDeal impartDeal = new ImpartDeal();
/* 227 */               flag = impartDeal.dealImpResult(relSet, operateType, contSch);
/* 228 */               if (flag)
/* 229 */                 errorMsg = "\u951F\u65A4\u62F7\u77E5\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6652\u951F\u65A4\u62F7\u951F\uFFFD";
/*     */               else
/* 231 */                 errorMsg = "\u951F\u65A4\u62F7\u77E5\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*     */             }
/*     */             else {
/* 234 */               errorMsg = " \u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u527F\u9769\u62F7\u77E5\u951F\u82A5\u50A8\u951F\u65A4\u62F7SQL\u951F\u53EB\u5E2E\u62F7\u6B20\u951F\u65A4\u62F7\u5740\u951F\uFFFD \u951F\u65A4\u62F7";
/*     */             }
/*     */           }
/* 237 */           else errorMsg = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5199\u951F\u65A4\u62F7\u77E5\u951F\u65A4\u62F7\u951F\u6377\uFF4F\u62F7";
/*     */ 
/* 239 */           System.out.println(errorMsg);
/*     */         } catch (Exception e) {
/* 241 */           e.printStackTrace();
/*     */         }
/*     */ 
/* 246 */         session.removeAttribute("insuDiscripInformSubmit");
/*     */ 
/* 248 */         session.setAttribute("insuDiscripFalshFlag", "1");
/*     */ 
/* 250 */         request.setAttribute("DisFlag", Boolean.valueOf(flag));
/* 251 */         request.setAttribute("DisMessage", errorMsg);
/* 252 */         String type = "";
/*     */ 
/* 254 */         ImpartDeal iDeal = new ImpartDeal();
/* 255 */         type = iDeal.getImpartType(session);
/* 256 */         response.sendRedirect("insuDiscrip" + type + ".jsf");
/*     */       } else {
/* 258 */         session.invalidate();
/* 259 */         response.sendRedirect("insuDiscripSessionNULL.jsp");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getShowFlag(HttpServletRequest req)
/*     */   {
/* 269 */     String flag = "";
/*     */ 
/* 271 */     HttpSession session = req.getSession(true);
/*     */ 
/* 273 */     if (session != null) {
/* 274 */       String showFlag = new String();
/* 275 */       showFlag = (String)session.getAttribute("insuDiscripFalshFlag");
/* 276 */       if ((showFlag != null) && ("1".equals(showFlag))) {
/* 277 */         flag = showFlag;
/* 278 */         session.removeAttribute("insuDiscripFalshFlag");
/*     */       }
/*     */     }
/* 281 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.ImpartDeal
 * JD-Core Version:    0.6.0
 */