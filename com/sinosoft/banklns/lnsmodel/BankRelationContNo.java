/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPAddressDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPBnfDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPCustImpResultDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPPaymentDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPPersonDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.LNPPubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*     */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPCustImpResultSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPPaymentSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPContSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPPersonSet;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class BankRelationContNo
/*     */ {
/*  50 */   private List<LNPRelBean> relContList = new ArrayList();
/*     */   private String relmessage;
/*  53 */   private boolean operateResult = true;
/*     */   private IGlobalInput tempGI;
/*     */   private int relSize;
/*  56 */   private boolean checkflag = true;
/*     */   private String relationvalue;
/*     */   private String relationitem;
/*  59 */   private boolean makecontNoflag = false;
/*  60 */   private boolean delflag = false;
/*  61 */   private boolean relflag = true;
/*     */   private int num;
/*     */   private LNPContSchema contSchema;
/*  66 */   private String contNo = "";
/*     */   private boolean copyFlag;
/*     */ 
/*     */   private void buildMsg(String msgErr)
/*     */   {
/*  69 */     System.out.println("buildError:--after-------------" + msgErr);
/*     */   }
/*     */ 
/*     */   private boolean getInfoFromSession(HttpSession session)
/*     */   {
/*  74 */     boolean flag = false;
/*     */     try {
/*  76 */       if (session == null) session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  77 */       this.tempGI = ((IGlobalInput)session.getAttribute("NPGI"));
/*  78 */       if (((String)session.getAttribute("ContNo") != null) && 
/*  79 */         (!((String)session.getAttribute("ContNo")).equals(""))) {
/*  80 */         this.contNo = ((String)session.getAttribute("ContNo"));
/*  81 */         flag = true;
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  85 */       flag = false;
/*  86 */       buildMsg(e.getMessage());
/*     */     }
/*  88 */     return flag;
/*     */   }
/*     */ 
/*     */   public void initData()
/*     */   {
/*     */     try {
/*  94 */       System.out.println("\u76F8\u5173\u8054\u4FDD\u5355\u521D\u59CB\u5316");
/*  95 */       System.out.println("\u5F53\u524D\u5355\u9009\u9879\u7684\u503C=====" + this.relationitem);
/*  96 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  97 */       if (getInfoFromSession(session)) {
/*  98 */         this.contSchema = getMyLNPContByContNo(this.contNo);
/*  99 */         boolean RelFlag = ((Boolean)session.getAttribute("RelFlag")).booleanValue();
/* 100 */         if (RelFlag)
/* 101 */           this.relflag = false;
/*     */         else {
/* 103 */           this.relflag = true;
/*     */         }
/* 105 */         this.checkflag = true;
/* 106 */         this.operateResult = true;
/* 107 */         this.makecontNoflag = false;
/* 108 */         this.relationitem = "";
/*     */ 
/* 110 */         if ((this.contSchema != null) && (!"".equals(this.contSchema.getAgentCode1())) && (this.contSchema.getAgentCode1() != null)) {
/* 111 */           System.out.println("\u5F53\u524DcontSchema.getAgentCode1()\u7684\u503C====" + this.contSchema.getAgentCode1());
/*     */ 
/* 113 */           this.relationitem = "01";
/* 114 */           this.relContList = getRellist(this.contSchema.getAgentCode1(), this.contNo);
/* 115 */           this.relSize = this.relContList.size();
/* 116 */           System.out.println("\u957F\u5EA6=========================" + this.relContList.size());
/*     */         } else {
/* 118 */           this.relationitem = "";
/* 119 */           System.out.println("\u5F53\u524D\u4FDD\u5355\u4E0D\u5B58\u5728\u5173\u8054\u7EC4");
/*     */         }
/*     */       }
/*     */       else {
/* 123 */         buildMsg("\u5168\u5C40\u6295\u4FDD\u4E66\u4FE1\u606F\u7F3A\u5931!");
/*     */       }
/*     */     } catch (RuntimeException e) {
/* 126 */       e.printStackTrace();
/*     */ 
/* 128 */       System.out.println("\u76F8\u5173\u8054\u4FDD\u5355\u754C\u9762\u521D\u59CB\u5316\u5931\u8D25\uFF01");
/* 129 */       this.operateResult = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void makeRelCode()
/*     */   {
/*     */     try {
/* 136 */       System.out.println("----start-------\u8FDB\u5165\u751F\u4EA7\u76F8\u5173\u8054\u4FDD\u5355\u529F\u80FD\uFF0C\u6B64\u5904\u751F\u6210\u5173\u8054\u7EC4\u53F7\uFF0C\u539F\u5219\uFF1A\u5DF2\u5B58\u5728\u5219\u7EE7\u7EED\u4F7F\u7528\uFF0C\u4E0D\u5B58\u5728\u5219\u65B0\u751F\u6210----------------");
/* 137 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 138 */       String contNo = (String)session.getAttribute("ContNo");
/* 139 */       String date = PubFun.getCurrentDate();
/* 140 */       String time = PubFun.getCurrentTime();
/* 141 */       this.contSchema = getMyLNPContByContNo(contNo);
/* 142 */       if ((this.contSchema.getAgentCode1() != null) && (!this.contSchema.getAgentCode1().equals(""))) {
/* 143 */         System.out.println("\u6B64\u65F6\u5B58\u5728\u76F8\u5173\u8054\u4FDD\u5355\u7EC4\u53F7\u201C" + this.contSchema.getAgentCode1() + "\u201D\uFF0C\u4E0D\u5FC5\u91CD\u65B0\u751F\u6210");
/*     */       } else {
/* 145 */         SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 146 */         this.contSchema.setAgentCode1(maxNoMap.CreateMaxNo("CustomerNo", "").substring(12));
/* 147 */         System.out.println("create new\u5173\u8054\u7F16\u53F7:" + this.contSchema.getAgentCode1());
/* 148 */         this.contSchema.setModifyDate(date);
/* 149 */         this.contSchema.setModifyTime(time);
/* 150 */         this.contSchema.setInputOperator(this.tempGI.Operator);
/* 151 */         PubSubmit ps = new PubSubmit();
/* 152 */         MMap map = new MMap();
/*     */ 
/* 154 */         map.put(this.contSchema, "UPDATE");
/* 155 */         VData vd = new VData();
/* 156 */         vd.add(map);
/* 157 */         if (!ps.submitData(vd, "")) {
/* 158 */           this.relmessage = "\u521B\u5EFA\u5173\u8054\u7F16\u53F7\u5931\u8D25\uFF01";
/* 159 */           this.operateResult = false;
/*     */         } else {
/* 161 */           this.relmessage = "\u521B\u5EFA\u5173\u8054\u7F16\u53F7\u6210\u529F\uFF01";
/* 162 */           this.operateResult = true;
/* 163 */           addOneRel();
/*     */         }
/*     */       }
/* 166 */       System.out.println("---end--------\u8FDB\u5165\u751F\u4EA7\u76F8\u5173\u8054\u4FDD\u5355\u529F\u80FD\uFF0C\u6B64\u5904\u751F\u6210\u5173\u8054\u7EC4\u53F7\uFF0C\u539F\u5219\uFF1A\u5DF2\u5B58\u5728\u5219\u7EE7\u7EED\u4F7F\u7528\uFF0C\u4E0D\u5B58\u5728\u5219\u65B0\u751F\u6210----------------");
/*     */     } catch (RuntimeException e) {
/* 168 */       e.printStackTrace();
/* 169 */       this.relmessage = "\u521B\u5EFA\u5173\u8054\u7F16\u53F7\u5931\u8D25\uFF01";
/* 170 */       this.operateResult = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   private List<LNPRelBean> getRellist(String RelationNo, String contNo)
/*     */   {
/* 176 */     System.out.println("\u8FDB\u5165\u6570\u636E\u5E93\u67E5\u8BE2\u6570\u636E\u76F8\u5173\u8054\u6295\u4FDD\u4E66------------");
/* 177 */     List newRelList = new ArrayList();
/*     */ 
/* 181 */     String sql = "select agentCode1,contno from lnpcont where agentcode1='" + RelationNo + "' and contno<>rtrim('" + contNo + "')";
/* 182 */     ExeSQL tExeSQL = new ExeSQL();
/* 183 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 184 */     for (int i = 1; i <= tSRS.MaxRow; i++) {
/* 185 */       LNPRelBean relbean = new LNPRelBean();
/* 186 */       relbean.setContno(tSRS.GetText(i, 2));
/* 187 */       if (i != tSRS.MaxRow)
/* 188 */         relbean.setDisplay("none");
/*     */       else {
/* 190 */         relbean.setDisplay("inline");
/*     */       }
/* 192 */       relbean.setReadflag(true);
/* 193 */       newRelList.add(relbean);
/*     */     }
/* 195 */     System.out.println("\u8FD9\u4E2A\u65F6\u5019relContList\u7684\u957F\u5EA6" + newRelList.size());
/* 196 */     return newRelList;
/*     */   }
/*     */ 
/*     */   public void makeContNo()
/*     */   {
/*     */     try {
/* 202 */       System.out.println("\u5F00\u59CB\u521B\u5EFA\u5173\u8054\u4FDD\u5355");
/* 203 */       PubSubmit ps = new PubSubmit();
/* 204 */       MMap map = new MMap();
/* 205 */       VData vd = new VData();
/* 206 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 207 */       String contNo = (String)session.getAttribute("ContNo");
/* 208 */       String date = PubFun.getCurrentDate();
/* 209 */       String time = PubFun.getCurrentTime();
/* 210 */       System.out.println("\u521B\u5EFA\u4FDD\u5355\u65F6relContList.size()======" + this.relContList.size() + " | \u521B\u5EFA\u4FDD\u5355\u65F6num============" + this.num);
/* 211 */       String newcont = ((LNPRelBean)this.relContList.get(this.num)).getContno();
/* 212 */       LNPContSchema NewContNo = getMyLNPContByContNo(newcont);
/* 213 */       if (NewContNo == null) {
/* 214 */         System.out.println("\u6CA1\u6709\u5F55\u5165\u7F16\u53F7\u7684\u6295\u4FDD\u5355\uFF0C\u6B64\u65F6\u4E3A\u589E\u52A0");
/* 215 */         NewContNo = new LNPContSchema();
/* 216 */         LNPContSchema contNew = getMyLNPContByContNo(contNo);
/* 217 */         NewContNo.setState("01");
/* 218 */         NewContNo.setContNo(newcont);
/* 219 */         NewContNo.setEditstate("1000000000");
/* 220 */         NewContNo.setProposalContNo(newcont);
/* 221 */         NewContNo.setMakeDate(date);
/* 222 */         NewContNo.setMakeTime(time);
/* 223 */         NewContNo.setModifyDate(date);
/* 224 */         NewContNo.setModifyTime(time);
/* 225 */         NewContNo.setOperator(this.tempGI.Operator);
/* 226 */         NewContNo.setInputOperator(this.tempGI.Operator);
/* 227 */         NewContNo.setPValiDate(date);
/* 228 */         NewContNo.setPSignDate(date);
/* 229 */         NewContNo.setSignCom(contNew.getSignCom());
/* 230 */         NewContNo.setContType("1");
/* 231 */         NewContNo.setPolType("1");
/* 232 */         NewContNo.setCardFlag("0");
/* 233 */         NewContNo.setProposalType("1");
/* 234 */         NewContNo.setApproveFlag("0");
/* 235 */         NewContNo.setUWFlag("0");
/* 236 */         NewContNo.setUWTime("0");
/* 237 */         NewContNo.setInsuredId("");
/* 238 */         NewContNo.setAppntId("");
/* 239 */         NewContNo.setAppntName("");
/* 240 */         NewContNo.setGrpContNo(LNPPubFun.getSysInfo("grpcontno"));
/* 241 */         NewContNo.setPrtNo(LNPPubFun.getSysInfo("prtno"));
/* 242 */         NewContNo.setOperator(this.tempGI.Operator);
/* 243 */         NewContNo.setSaleChnlDetail(this.tempGI.chanlesign);
/* 244 */         NewContNo.setManageCom(contNew.getSignCom());
/* 245 */         NewContNo.setAgentCode1(contNew.getAgentCode1());
/*     */ 
/* 248 */         this.contSchema.setModifyDate(date);
/* 249 */         this.contSchema.setModifyTime(time);
/* 250 */         this.contSchema.setInputOperator(this.tempGI.Operator);
/* 251 */         map.put(NewContNo, "INSERT");
/* 252 */         map.put(this.contSchema, "UPDATE");
/*     */       } else {
/* 254 */         System.out.println("\u6709\u5F55\u5165\u7F16\u53F7\u7684\u6295\u4FDD\u5355\uFF0C\u6B64\u65F6\u4E3A\u4FEE\u6539");
/* 255 */         NewContNo.setAgentCode1(this.contSchema.getAgentCode1());
/* 256 */         NewContNo.setModifyDate(date);
/* 257 */         NewContNo.setModifyTime(time);
/* 258 */         NewContNo.setInputOperator(this.tempGI.Operator);
/*     */ 
/* 260 */         this.contSchema.setModifyDate(date);
/* 261 */         this.contSchema.setModifyTime(time);
/* 262 */         this.contSchema.setInputOperator(this.tempGI.Operator);
/*     */ 
/* 264 */         map.put(NewContNo, "UPDATE");
/* 265 */         map.put(this.contSchema, "UPDATE");
/*     */       }
/* 267 */       if (!this.copyFlag) {
/* 268 */         vd.add(map);
/* 269 */         if (!ps.submitData(vd, "")) {
/* 270 */           this.relmessage = "\u5173\u8054\u6295\u4FDD\u5355\u5931\u8D25";
/* 271 */           this.operateResult = false;
/*     */         } else {
/* 273 */           this.relmessage = "\u5173\u8054\u6295\u4FDD\u5355\u6210\u529F";
/* 274 */           this.operateResult = true;
/* 275 */           this.makecontNoflag = true;
/*     */         }
/*     */       } else {
/* 278 */         saveData(map, NewContNo);
/*     */       }
/*     */     } catch (RuntimeException e) {
/* 281 */       this.relmessage = "\u5173\u8054\u6295\u4FDD\u5355\u5931\u8D25";
/* 282 */       this.operateResult = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void checkcontno()
/*     */   {
/*     */     try {
/* 289 */       this.relmessage = "->\u5173\u8054\u5931\u8D25<-";
/* 290 */       String contno = ((LNPRelBean)this.relContList.get(this.relContList.size() - 1)).getContno();
/* 291 */       System.out.println("-------\u5F00\u59CB\u8FDB\u884C\u6295\u4FDD\u7F16\u53F7" + contno + "\u6821\u9A8C------");
/* 292 */       LNPContSchema contSel = getMyLNPContByContNo(contno);
/* 293 */       if (!Pattern.matches("^[0-9]{12}", contno)) {
/* 294 */         this.relmessage = "\u8BF7\u6309\u7167\u6B63\u786E\u683C\u5F0F\u586B\u5199\u6295\u4FDD\u4E66\u53F7";
/* 295 */         this.checkflag = false;
/* 296 */       } else if ((contSel != null) && (!this.contSchema.getSignCom().equals(contSel.getSignCom()))) {
/* 297 */         this.relmessage = "\u5F55\u5165\u7684\u4FDD\u5355\u53F7\u4E0D\u7B26\u5408\u89C4\u5219";
/* 298 */         this.checkflag = false;
/*     */       }
/* 300 */       else if (this.contSchema.getState().equals("01")) {
/* 301 */         if ((contSel == null) || (contSel.getState().equals("01"))) {
/* 302 */           if ((contSel != null) && (contSel.getAgentCode1() != null) && (!contSel.getAgentCode1().equals(""))) {
/* 303 */             this.relmessage = "\u5F53\u524D\u5F55\u5165\u4FDD\u5355\u53F7\u5B58\u5728\u5173\u8054\u7EC4,\u4E0D\u80FD\u91CD\u590D\u5F55\u5165";
/* 304 */             this.checkflag = false;
/*     */           }
/*     */           else {
/* 307 */             this.relmessage = "\u521B\u5EFA\u6210\u529F";
/* 308 */             this.checkflag = true;
/*     */ 
/* 310 */             System.out.println("--------------\u8BBE\u7F6E\u53EA\u8BFB\u9009\u9879-------------------");
/* 311 */             ((LNPRelBean)this.relContList.get(this.relContList.size() - 1)).setReadflag(true);
/* 312 */             System.out.println("01\u72B6\u6001\uFF1A\u5F53\u524D\u5173\u8054\u6295\u4FDD\u4E66\u521B\u5EFA\u6210\u529Fflag\uFF1A" + this.checkflag);
/*     */           }
/*     */         }
/*     */         else {
/* 316 */           this.relmessage = "\u5F55\u5165\u4FDD\u5355\u7684\u72B6\u6001\u4E0D\u7B26\u5408\u8981\u6C42";
/* 317 */           this.checkflag = false;
/*     */         }
/* 319 */       } else if ((!"05".equals(this.contSchema.getState())) && (!"06".equals(this.contSchema.getState())))
/*     */       {
/* 321 */         if (contSel != null) {
/* 322 */           if (("05".equals(contSel.getState())) || ("06".equals(contSel.getState()))) {
/* 323 */             this.relmessage = "\u5F55\u5165\u4FDD\u5355\u7684\u72B6\u6001\u4E0D\u7B26\u5408\u8981\u6C42";
/* 324 */             this.checkflag = false;
/*     */           }
/* 326 */           else if ((contSel.getAgentCode1() != null) && (!contSel.getAgentCode1().equals(""))) {
/* 327 */             this.relmessage = "\u5F53\u524D\u5F55\u5165\u4FDD\u5355\u53F7\u5B58\u5728\u5173\u8054\u7EC4,\u4E0D\u80FD\u91CD\u590D\u5F55\u5165";
/* 328 */             this.checkflag = false;
/*     */           } else {
/* 330 */             this.relmessage = "\u521B\u5EFA\u6210\u529F";
/* 331 */             this.checkflag = true;
/*     */ 
/* 333 */             System.out.println("--------------\u8BBE\u7F6E\u53EA\u8BFB\u9009\u9879-------------------");
/* 334 */             ((LNPRelBean)this.relContList.get(this.relContList.size() - 1)).setReadflag(true);
/* 335 */             System.out.println("\u5927\u4E8E02\u72B6\u6001\uFF1A\u5F53\u524D\u5173\u8054\u6295\u4FDD\u4E66\u521B\u5EFA\u6210\u529Fflag\uFF1A" + this.checkflag);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 340 */           this.relmessage = "\u521B\u5EFA\u6210\u529F";
/* 341 */           this.checkflag = true;
/*     */ 
/* 343 */           System.out.println("--------------\u8BBE\u7F6E\u53EA\u8BFB\u9009\u9879-------------------");
/* 344 */           ((LNPRelBean)this.relContList.get(this.relContList.size() - 1)).setReadflag(true);
/* 345 */           System.out.println("\u5927\u4E8E02\u72B6\u6001\uFF1A\u5F53\u524D\u5173\u8054\u6295\u4FDD\u4E66\u521B\u5EFA\u6210\u529Fflag\uFF1A" + this.checkflag);
/*     */         }
/*     */       } else {
/* 348 */         this.relmessage = "\u521B\u5EFA\u5931\u8D25,\u5F53\u524D\u88AB\u5173\u8054\u6295\u4FDD\u4E66\u72B6\u6001\u4E0D\u7B26\u5408\u8981\u6C42";
/* 349 */         this.checkflag = false;
/*     */       }
/*     */     }
/*     */     catch (RuntimeException e) {
/* 353 */       e.printStackTrace();
/* 354 */       this.relmessage = "\u521B\u5EFA\u5931\u8D25";
/* 355 */       this.checkflag = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   private LNPContSchema getMyLNPContByContNo(String contNo2)
/*     */   {
/* 362 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 363 */     LNPContSchema aLNPContSchema = mainInfo.getContByContNo(contNo2);
/* 364 */     return aLNPContSchema;
/*     */   }
/*     */ 
/*     */   public void saveData(MMap map1, LNPContSchema newContSchema)
/*     */   {
/* 371 */     System.out.println("\u8FDB\u5165\u6570\u636E\u540C\u6B65\u529F\u80FD");
/* 372 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 373 */     String contNo = (String)session.getAttribute("ContNo");
/* 374 */     String newcontno = ((LNPRelBean)this.relContList.get(this.num)).getContno();
/* 375 */     String date = PubFun.getCurrentDate();
/* 376 */     String time = PubFun.getCurrentTime();
/*     */ 
/* 378 */     LNPAppntSchema appntSchema = getAppntByContNo(contNo);
/* 379 */     LNPAppntSchema newappntSchema = getAppntByContNo(newcontno);
/*     */ 
/* 381 */     LNPInsuredSchema suredSchema = getSuredByContNo(contNo);
/* 382 */     LNPInsuredSchema newsuredSchema = getSuredByContNo(newcontno);
/*     */ 
/* 384 */     LNPBnfSet bnfSet = getBnfByContNo(contNo);
/* 385 */     LNPBnfSet newbnfSet = getBnfByContNo(newcontno);
/* 386 */     System.out.println("\u53D7\u76CA\u4EBA\u4FE1\u606F");
/*     */ 
/* 388 */     LNPPaymentSchema paySchema = getPayByContNo(contNo);
/* 389 */     LNPPaymentSchema newpaySchema = getPayByContNo(newcontno);
/* 390 */     System.out.println("\u6536\u4ED8\u8D39\u4FE1\u606F");
/*     */ 
/* 392 */     LNPAgentInfoSchema agentSchema = getAgentByContNo(contNo);
/* 393 */     LNPAgentInfoSchema newagentSchema = getAgentByContNo(newcontno);
/* 394 */     System.out.println("\u4EE3\u7406\u4EBA\u4FE1\u606F");
/*     */ 
/* 396 */     LNPCustImpResultSet custImpSet = getCustImpByContNo(contNo);
/* 397 */     LNPCustImpResultSet newcustImpSet = getCustImpByContNo(newcontno);
/* 398 */     System.out.println("\u7B54\u6848\u4FE1\u606F");
/*     */ 
/* 401 */     if ((appntSchema != null) && (!appntSchema.equals(""))) {
/* 402 */       System.out.println("\u5F00\u59CB\u540C\u6B65\u6295\u4FDD\u4EBA\u4FE1\u606F");
/* 403 */       LNPAddressSchema addressSchema = getAddressByID(appntSchema.getAppntId());
/* 404 */       LNPPersonSchema personSchema = getPersonByID(appntSchema.getAppntId());
/*     */ 
/* 406 */       appntSchema.setContNo(newcontno);
/* 407 */       appntSchema.setProposalContNo(newcontno);
/* 408 */       appntSchema.setModifyDate(date);
/* 409 */       appntSchema.setModifyTime(time);
/* 410 */       appntSchema.setMakeDate(date);
/* 411 */       appntSchema.setMakeTime(time);
/* 412 */       appntSchema.setOperator(this.tempGI.Operator);
/* 413 */       SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 414 */       addressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
/* 415 */       appntSchema.setAppntId(maxNoMap.CreateMaxNo("CustomerNo", ""));
/* 416 */       appntSchema.setAddressNo(addressSchema.getAddressNo());
/* 417 */       addressSchema.setCustomerId(appntSchema.getAppntId());
/* 418 */       personSchema.setCustomerId(appntSchema.getAppntId());
/* 419 */       personSchema.setAgentCode(appntSchema.getOperator());
/* 420 */       map1.put(newappntSchema, "DELETE");
/* 421 */       map1.put(appntSchema, "INSERT");
/* 422 */       map1.put(addressSchema, "INSERT");
/* 423 */       map1.put(personSchema, "INSERT");
/*     */     }
/* 426 */     else if (newappntSchema != null) {
/* 427 */       LNPAddressSchema addressSchema = getAddressByID(newappntSchema.getAppntId());
/* 428 */       LNPPersonSchema personSchema = getPersonByID(newappntSchema.getAppntId());
/* 429 */       map1.put(personSchema, "DELETE");
/* 430 */       map1.put(addressSchema, "DELETE");
/* 431 */       map1.put(newappntSchema, "DELETE");
/*     */     }
/*     */ 
/* 435 */     if ((suredSchema != null) && (!suredSchema.equals(""))) {
/* 436 */       System.out.println("\u5F00\u59CB\u540C\u6B65\u88AB\u4FDD\u4EBA\u4FE1\u606F");
/* 437 */       LNPAddressSchema addressSchema = getAddressByID(suredSchema.getInsuredId());
/* 438 */       LNPPersonSchema personSchema = getPersonByID(suredSchema.getInsuredId());
/*     */ 
/* 440 */       suredSchema.setContNo(newcontno);
/* 441 */       suredSchema.setProposalContNo(newcontno);
/* 442 */       suredSchema.setMakeDate(date);
/* 443 */       suredSchema.setMakeTime(time);
/* 444 */       suredSchema.setModifyDate(date);
/* 445 */       suredSchema.setModifyTime(time);
/* 446 */       suredSchema.setOperator(this.tempGI.Operator);
/* 447 */       SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 448 */       addressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
/* 449 */       suredSchema.setInsuredId(maxNoMap.CreateMaxNo("CustomerNo", ""));
/* 450 */       suredSchema.setAppntId(appntSchema.getAppntId());
/* 451 */       suredSchema.setAddressNo(addressSchema.getAddressNo());
/* 452 */       addressSchema.setCustomerId(suredSchema.getInsuredId());
/* 453 */       personSchema.setCustomerId(suredSchema.getInsuredId());
/* 454 */       personSchema.setAgentCode(suredSchema.getOperator());
/*     */ 
/* 456 */       map1.put(newsuredSchema, "DELETE");
/* 457 */       map1.put(suredSchema, "INSERT");
/* 458 */       map1.put(personSchema, "INSERT");
/* 459 */       map1.put(addressSchema, "INSERT");
/*     */     }
/* 461 */     else if (newsuredSchema != null) {
/* 462 */       LNPAddressSchema addressSchema = getAddressByID(newsuredSchema.getAppntId());
/* 463 */       LNPPersonSchema personSchema = getPersonByID(newsuredSchema.getAppntId());
/* 464 */       map1.put(addressSchema, "DELETE");
/* 465 */       map1.put(personSchema, "DELETE");
/* 466 */       map1.put(newsuredSchema, "DELETE");
/*     */     }
/*     */ 
/* 471 */     if ((bnfSet != null) && (bnfSet.size() > 0)) {
/* 472 */       System.out.println("\u5F00\u59CB\u540C\u6B65\u53D7\u76CA\u4EBA\u4FE1\u606F");
/* 473 */       SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 474 */       for (int i = 1; i <= bnfSet.size(); i++) {
/* 475 */         bnfSet.get(i).setContNo(newcontno);
/* 476 */         if ((suredSchema != null) && (!suredSchema.equals("")))
/* 477 */           bnfSet.get(i).setInsuredId(suredSchema.getInsuredId());
/*     */         else {
/* 479 */           bnfSet.get(i).setInsuredId("");
/*     */         }
/* 481 */         bnfSet.get(i).setBnfId(maxNoMap.CreateMaxNo("CustomerNo", ""));
/* 482 */         bnfSet.get(i).setMakeDate(date);
/* 483 */         bnfSet.get(i).setMakeTime(time);
/* 484 */         bnfSet.get(i).setModifyDate(date);
/* 485 */         bnfSet.get(i).setModifyTime(time);
/* 486 */         bnfSet.get(i).setOperator(this.tempGI.Operator);
/*     */       }
/*     */ 
/* 489 */       map1.put(newbnfSet, "DELETE");
/* 490 */       map1.put(bnfSet, "INSERT");
/*     */     } else {
/* 492 */       map1.put(newbnfSet, "DELETE");
/*     */     }
/*     */ 
/* 495 */     if ((paySchema != null) && (!paySchema.equals(""))) {
/* 496 */       System.out.println("\u5F00\u59CB\u540C\u6B65\u6536\u4ED8\u8D39\u4FE1\u606F");
/* 497 */       paySchema.setContNo(newcontno);
/* 498 */       paySchema.setMakeDate(date);
/* 499 */       paySchema.setMakeTime(time);
/* 500 */       paySchema.setModifyDate(date);
/* 501 */       paySchema.setModifyTime(time);
/* 502 */       paySchema.setOperator(this.tempGI.Operator);
/* 503 */       if ((appntSchema != null) && (!appntSchema.equals("")))
/* 504 */         paySchema.setAppntID(appntSchema.getAppntId());
/*     */       else {
/* 506 */         paySchema.setAppntID("");
/*     */       }
/* 508 */       if ((suredSchema != null) && (!suredSchema.equals("")))
/* 509 */         paySchema.setInusredID(suredSchema.getInsuredId());
/*     */       else {
/* 511 */         paySchema.setInusredID("");
/*     */       }
/*     */ 
/* 514 */       map1.put(newpaySchema, "DELETE");
/* 515 */       map1.put(paySchema, "INSERT");
/*     */     } else {
/* 517 */       map1.put(newpaySchema, "DELETE");
/*     */     }
/*     */ 
/* 520 */     if ((agentSchema != null) && (!agentSchema.equals(""))) {
/* 521 */       System.out.println("\u5F00\u59CB\u540C\u6B65\u4EE3\u7406\u4EBA\u4FE1\u606F");
/* 522 */       agentSchema.setContNo(newcontno);
/* 523 */       agentSchema.setProposalContNo(newcontno);
/* 524 */       agentSchema.setMakeDate(date);
/* 525 */       agentSchema.setMakeTime(time);
/* 526 */       agentSchema.setModifyDate(date);
/* 527 */       agentSchema.setModifyTime(time);
/* 528 */       agentSchema.setOperator(this.tempGI.Operator);
/*     */ 
/* 530 */       map1.put(newagentSchema, "DELETE");
/* 531 */       map1.put(agentSchema, "INSERT");
/*     */     } else {
/* 533 */       map1.put(newagentSchema, "DELETE");
/*     */     }
/*     */ 
/* 536 */     if ((custImpSet != null) && (custImpSet.size() > 0)) {
/* 537 */       System.out.println("\u5F00\u59CB\u540C\u6B65\u7B54\u6848\u4FE1\u606F");
/* 538 */       SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 539 */       String appresultid = maxNoMap.CreateMaxNo("CustomerNo", "");
/* 540 */       String insresultid = maxNoMap.CreateMaxNo("CustomerNo", "");
/* 541 */       for (int i = 1; i <= custImpSet.size(); i++) {
/* 542 */         custImpSet.get(i).setContNo(newcontno);
/* 543 */         if (custImpSet.get(i).getCustomerNo().equals("appnt"))
/* 544 */           custImpSet.get(i).setResultId(appresultid);
/*     */         else {
/* 546 */           custImpSet.get(i).setResultId(insresultid);
/*     */         }
/* 548 */         custImpSet.get(i).setMakeDate(date);
/* 549 */         custImpSet.get(i).setMakeTime(time);
/* 550 */         custImpSet.get(i).setModifyDate(date);
/* 551 */         custImpSet.get(i).setModifyTime(time);
/* 552 */         custImpSet.get(i).setOperator(this.tempGI.Operator);
/*     */       }
/*     */ 
/* 555 */       map1.put(newcustImpSet, "DELETE");
/* 556 */       map1.put(custImpSet, "INSERT");
/*     */     } else {
/* 558 */       map1.put(newcustImpSet, "DELETE");
/*     */     }
/*     */ 
/* 562 */     System.out.println("\u540C\u6B65\u6570\u636E\u6210\u529F\u540E\uFF0C\u8FDB\u884C\u4FEE\u6539\u4FDD\u5355\u72B6\u6001");
/*     */ 
/* 565 */     if (newContSchema != null) {
/* 566 */       BankOperateDeal stateOperate = new BankOperateDeal();
/* 567 */       List list = stateOperate.relInfoOperate(this.contSchema, newContSchema);
/* 568 */       newContSchema.setState((String)list.get(0));
/* 569 */       newContSchema.setEditstate((String)list.get(1));
/* 570 */       System.out.println("###############current policy\uFF1A" + this.contSchema.getContNo() + " \u88AB\u5173\u8054\u6295\u4FDD\u4E66 \u4FE1\u606F: state:" + this.contSchema.getState() + " | editstate:" + this.contSchema.getEditstate());
/* 571 */       System.out.println("###############current policy\uFF1A" + newContSchema.getContNo() + " \u5173\u8054\u6295\u4FDD\u4E66 \u4FE1\u606F: state:" + newContSchema.getState() + " | editstate:" + newContSchema.getEditstate());
/*     */ 
/* 574 */       if (appntSchema != null)
/*     */       {
/* 576 */         newContSchema.setAppntId(appntSchema.getAppntId());
/*     */ 
/* 578 */         newContSchema.setAppntName(appntSchema.getAppntName());
/*     */ 
/* 580 */         newContSchema.setAppntNo(appntSchema.getAppntNo());
/*     */ 
/* 582 */         newContSchema.setAppntBirthday(appntSchema.getAppntBirthday());
/*     */ 
/* 584 */         newContSchema.setAppntIDType(appntSchema.getIDType());
/*     */ 
/* 586 */         newContSchema.setAppntIDNo(appntSchema.getIDNo());
/*     */ 
/* 588 */         newContSchema.setAppntSex(appntSchema.getAppntSex());
/*     */       }
/*     */       else {
/* 591 */         System.out.println("\u6B64\u65F6\u65E0\u6295\u4FDD\u4EBA\u4FE1\u606F");
/*     */       }
/*     */ 
/* 594 */       if (suredSchema != null) {
/* 595 */         newContSchema.setInsuredId(suredSchema.getInsuredId());
/* 596 */         newContSchema.setInsuredNo(suredSchema.getInsuredNo());
/* 597 */         newContSchema.setInsuredName(suredSchema.getName());
/* 598 */         newContSchema.setInsuredBirthday(suredSchema.getBirthday());
/* 599 */         newContSchema.setInsuredIDType(suredSchema.getIDType());
/* 600 */         newContSchema.setInsuredIDNo(suredSchema.getIDNo());
/* 601 */         newContSchema.setInsuredSex(suredSchema.getSex());
/*     */       } else {
/* 603 */         System.out.println("\u6B64\u65F6\u65E0\u88AB\u4FDD\u4EBA\u4FE1\u606F");
/*     */       }
/*     */ 
/* 606 */       if (agentSchema != null) {
/* 607 */         newContSchema.setAgentCom(agentSchema.getBranchAttr());
/* 608 */         newContSchema.setPSignDate(this.contSchema.getPSignDate());
/* 609 */         newContSchema.setPValiDate(this.contSchema.getPValiDate());
/*     */       } else {
/* 611 */         System.out.println("\u6B64\u65F6\u65E0\u4EE3\u7406\u4EBA\u544A\u77E5\u4FE1\u606F");
/*     */       }
/* 613 */       PubSubmit ps = new PubSubmit();
/* 614 */       VData vd1 = new VData();
/*     */ 
/* 618 */       LNPContSet newLNPContSet = new LNPContSet();
/* 619 */       newLNPContSet.add(newContSchema);
/* 620 */       map1.put(newLNPContSet, "UPDATE");
/* 621 */       vd1.add(map1);
/* 622 */       if (!ps.submitData(vd1, "")) {
/* 623 */         this.relmessage = "\u5173\u8054\u4FDD\u5355\u5931\u8D25";
/* 624 */         this.operateResult = false;
/*     */       } else {
/* 626 */         this.relmessage = "\u5173\u8054\u4FDD\u5355\u6210\u529F";
/* 627 */         this.operateResult = true;
/*     */       }
/*     */     } else {
/* 630 */       this.relmessage = "\u5173\u8054\u4FDD\u5355\u5931\u8D25";
/* 631 */       this.operateResult = false;
/* 632 */       System.out.println("LNPcont state\uFF0C editstate\u5173\u8054\u5931\u8D25~~~~~~~~~~~~~~~~\u00B7\u00B7");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addOneRel()
/*     */   {
/* 639 */     System.out.println("\u80FD\u591F\u8FDB\u5165addonerel()\u4E2D\uFF01");
/* 640 */     System.out.println(this.relContList.size());
/* 641 */     this.operateResult = true;
/* 642 */     boolean check = false;
/*     */ 
/* 645 */     if (this.relContList.size() >= 1) {
/* 646 */       String conNumber = ((LNPRelBean)this.relContList.get(this.relContList.size() - 1)).getContno();
/* 647 */       if ((conNumber == null) || (conNumber.equals("")) || (!this.checkflag))
/* 648 */         check = false;
/*     */       else {
/* 650 */         check = true;
/*     */       }
/*     */ 
/* 653 */       if (!check) {
/* 654 */         this.operateResult = false;
/* 655 */         this.relmessage = "\u672C\u884C\u4FE1\u606F\u5F55\u5165\u540E\u624D\u53EF\u4EE5\u6DFB\u52A0\u4E0B\u4E00\u884C";
/* 656 */         return;
/*     */       }
/* 658 */       System.out.println("\u8FDB\u884C\u4E0B\u5217\u6DFB\u52A0\u7A0B\u5E8F\u4EE3\u78011");
/*     */     }
/*     */     else {
/* 661 */       System.out.println("\u8FDB\u884C\u4E0B\u5217\u6DFB\u52A0\u7A0B\u5E8F\u4EE3\u78012");
/*     */     }
/*     */ 
/* 664 */     if (this.relContList.size() < 50) {
/* 665 */       for (int i = 0; i < this.relContList.size(); i++)
/*     */       {
/* 668 */         if ((!((LNPRelBean)this.relContList.get(i)).getContno().equals("")) && (((LNPRelBean)this.relContList.get(i)).getContno() != null) && (!this.relContList.equals("")))
/* 669 */           ((LNPRelBean)this.relContList.get(i)).setReadflag(true);
/*     */         else {
/* 671 */           ((LNPRelBean)this.relContList.get(i)).setReadflag(false);
/*     */         }
/*     */ 
/* 674 */         if (i != this.relContList.size())
/* 675 */           ((LNPRelBean)this.relContList.get(i)).setDisplay("none");
/*     */         else {
/* 677 */           ((LNPRelBean)this.relContList.get(i)).setDisplay("inline");
/*     */         }
/*     */       }
/* 680 */       LNPRelBean newRel = new LNPRelBean();
/*     */ 
/* 682 */       this.relContList.add(newRel);
/* 683 */       this.relSize = this.relContList.size();
/*     */ 
/* 685 */       System.out.println(this.relContList.size());
/*     */     } else {
/* 687 */       System.out.println("\u5DF2\u8FBE\u4E0A\u9650\uFF0C\u4E0D\u80FD\u518D\u8FDB\u884C\u6DFB\u52A0\u64CD\u4F5C");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delOneRel()
/*     */   {
/* 696 */     System.out.println("\u5F00\u59CB\u5220\u9664\u65F6relContList\u7684size====" + this.relContList.size());
/* 697 */     this.delflag = false;
/* 698 */     this.operateResult = true;
/* 699 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 700 */     String contNo = (String)session.getAttribute("ContNo");
/*     */ 
/* 702 */     System.out.println("\u53D6\u5F97\u70B9\u51FB\u7684\u5220\u9664\u6309\u94AE\u6240\u5728\u7684\u4F4D\u7F6E==" + this.num);
/* 703 */     String contnorel = ((LNPRelBean)this.relContList.get(this.num)).getContno();
/* 704 */     if ((!contnorel.equals("")) && (contnorel != null)) {
/* 705 */       delRelCode(contnorel);
/*     */     } else {
/* 707 */       this.delflag = true;
/* 708 */       System.out.println("\u5F53\u524D\u884C\u6CA1\u6709\u4FDD\u5355\u53F7");
/*     */     }
/*     */ 
/* 712 */     if (this.delflag) {
/* 713 */       if (this.relContList.size() > 1) {
/* 714 */         this.relContList.remove(this.num);
/* 715 */         this.relSize = this.relContList.size();
/*     */       } else {
/* 717 */         this.relContList.remove(this.num);
/* 718 */         delRelCode(contNo);
/* 719 */         this.relationitem = "";
/* 720 */         System.out.println("\u5173\u8054\u4FDD\u5355\u53F7\uFF0C\u4E0D\u80FD\u518D\u8FDB\u884C\u5220\u9664\u64CD\u4F5C");
/*     */       }
/*     */ 
/* 723 */       System.out.println("\u5220\u9664\u7ED3\u675F\u65F6relContList\u7684size====" + this.relContList.size());
/*     */ 
/* 725 */       for (int i = 0; i < this.relContList.size(); i++)
/*     */       {
/* 728 */         if ((!((LNPRelBean)this.relContList.get(i)).getContno().equals("")) && (((LNPRelBean)this.relContList.get(i)).getContno() != null) && (!this.relContList.equals("")))
/* 729 */           ((LNPRelBean)this.relContList.get(i)).setReadflag(true);
/*     */         else {
/* 731 */           ((LNPRelBean)this.relContList.get(i)).setReadflag(false);
/*     */         }
/*     */ 
/* 734 */         if (i == this.relContList.size() - 1)
/* 735 */           ((LNPRelBean)this.relContList.get(i)).setDisplay("inline");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void delRelCode(String contno)
/*     */   {
/* 747 */     System.out.println("\u8FDB\u5165\u5220\u9664\u76F8\u5173\u8054\u7F16\u53F7\u65B9\u6CD5");
/* 748 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 749 */     LNPContSchema aLNPContSchema = mainInfo.getContByContNo(contno);
/* 750 */     if (aLNPContSchema != null) {
/* 751 */       if ("06".equals(aLNPContSchema.getState()))
/*     */       {
/* 753 */         this.relmessage = ("\u5173\u8054\u6295\u4FDD\u5355\u53F7\u201C" + aLNPContSchema.getContNo() + "\u201D\u5F53\u524D\u72B6\u6001\u4E3A <\u5DF2\u5BA1\u6838-\u53D1\u9001\u6210\u529F>,\u4E0D\u53EF\u518D\u5220\u9664\u5173\u8054\u5173\u7CFB");
/* 754 */         this.delflag = false;
/* 755 */       } else if (aLNPContSchema.getAgentCode1().equals(this.contSchema.getAgentCode1())) {
/* 756 */         aLNPContSchema.setAgentCode1("");
/* 757 */         PubSubmit ps = new PubSubmit();
/* 758 */         MMap map = new MMap();
/* 759 */         map.put(aLNPContSchema, "UPDATE");
/* 760 */         VData vd = new VData();
/* 761 */         vd.add(map);
/* 762 */         if (!ps.submitData(vd, "")) {
/* 763 */           this.delflag = false;
/* 764 */           this.relmessage = "\u5220\u9664\u5173\u8054\u4FDD\u5355\u5931\u8D25";
/* 765 */           System.out.println("\u5220\u9664\u76F8\u5173\u8054\u7F16\u53F7\u5931\u8D25");
/*     */         } else {
/* 767 */           this.delflag = true;
/* 768 */           this.relmessage = "\u5220\u9664\u5173\u8054\u4FDD\u5355\u6210\u529F";
/* 769 */           System.out.println("\u5220\u9664\u76F8\u5173\u8054\u7F16\u53F7\u6210\u529F");
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/* 774 */       System.out.println("\u6B64\u65F6lnpcont\u8868\u4E2D\u65E0\u6B64\u4FDD\u5355\u53F7\u4FE1\u606F");
/*     */   }
/*     */ 
/*     */   public LNPAppntSchema getAppntByContNo(String contNo)
/*     */   {
/* 812 */     LNPAppntDB db = new LNPAppntDB();
/* 813 */     db.setContNo(contNo);
/*     */ 
/* 815 */     if (db.getInfo()) {
/* 816 */       return db.getSchema();
/*     */     }
/* 818 */     return null;
/*     */   }
/*     */ 
/*     */   public LNPInsuredSchema getSuredByContNo(String contNo)
/*     */   {
/* 823 */     LNPInsuredDB db = new LNPInsuredDB();
/* 824 */     db.setContNo(contNo);
/* 825 */     LNPInsuredSet insuredSet = db.query();
/* 826 */     if (insuredSet.size() > 0) {
/* 827 */       return insuredSet.get(1).getSchema();
/*     */     }
/*     */ 
/* 830 */     return null;
/*     */   }
/*     */ 
/*     */   public LNPBnfSet getBnfByContNo(String contNo)
/*     */   {
/* 835 */     System.out.println("\u83B7\u53D6\u53D7\u76CA\u4EBA\u4FE1\u606F");
/* 836 */     LNPBnfDB db = new LNPBnfDB();
/* 837 */     db.setContNo(contNo);
/* 838 */     LNPBnfSet bnfSet = db.query();
/* 839 */     if (bnfSet.size() > 0) {
/* 840 */       return bnfSet;
/*     */     }
/* 842 */     return bnfSet;
/*     */   }
/*     */ 
/*     */   public LNPPaymentSchema getPayByContNo(String contNo)
/*     */   {
/* 847 */     LNPPaymentDB db = new LNPPaymentDB();
/* 848 */     db.setContNo(contNo);
/*     */ 
/* 850 */     if (db.getInfo()) {
/* 851 */       return db.getSchema();
/*     */     }
/* 853 */     return null;
/*     */   }
/*     */ 
/*     */   public LNPAgentInfoSchema getAgentByContNo(String contNo)
/*     */   {
/* 858 */     LNPAgentInfoDB db = new LNPAgentInfoDB();
/* 859 */     db.setContNo(contNo);
/* 860 */     LNPAgentInfoSet insuredSet = db.query();
/* 861 */     if (insuredSet.size() > 0) {
/* 862 */       return insuredSet.get(1).getSchema();
/*     */     }
/*     */ 
/* 865 */     return null;
/*     */   }
/*     */ 
/*     */   public LNPCustImpResultSet getCustImpByContNo(String contNo)
/*     */   {
/* 872 */     LNPCustImpResultDB db = new LNPCustImpResultDB();
/* 873 */     db.setContNo(contNo);
/* 874 */     LNPCustImpResultSet custImpSet = db.query();
/* 875 */     if (custImpSet.size() > 0) {
/* 876 */       return custImpSet;
/*     */     }
/* 878 */     return custImpSet;
/*     */   }
/*     */ 
/*     */   public LNPAddressSchema getAddressByID(String id)
/*     */   {
/* 883 */     LNPAddressDB db = new LNPAddressDB();
/* 884 */     db.setCustomerId(id);
/* 885 */     LNPAddressSet addSet = db.query();
/* 886 */     if (addSet.size() > 0) {
/* 887 */       return addSet.get(1).getSchema();
/*     */     }
/* 889 */     return null;
/*     */   }
/*     */ 
/*     */   public LNPPersonSchema getPersonByID(String id)
/*     */   {
/* 894 */     LNPPersonDB db = new LNPPersonDB();
/* 895 */     db.setCustomerId(id);
/* 896 */     LNPPersonSet perSet = db.query();
/* 897 */     if (perSet.size() > 0) {
/* 898 */       return perSet.get(1).getSchema();
/*     */     }
/* 900 */     return null;
/*     */   }
/*     */ 
/*     */   public List<LNPRelBean> getRelContList()
/*     */   {
/* 909 */     return this.relContList;
/*     */   }
/*     */   public String getRelmessage() {
/* 912 */     return this.relmessage;
/*     */   }
/*     */   public void setRelmessage(String relmessage) {
/* 915 */     this.relmessage = relmessage;
/*     */   }
/*     */   public void setRelContList(List<LNPRelBean> relContList) {
/* 918 */     this.relContList = relContList;
/*     */   }
/*     */ 
/*     */   public boolean isOperateResult() {
/* 922 */     return this.operateResult;
/*     */   }
/*     */   public void setOperateResult(boolean operateResult) {
/* 925 */     this.operateResult = operateResult;
/*     */   }
/*     */   public int getRelSize() {
/* 928 */     return this.relSize;
/*     */   }
/*     */   public void setRelSize(int relSize) {
/* 931 */     this.relSize = relSize;
/*     */   }
/*     */   public boolean isCheckflag() {
/* 934 */     return this.checkflag;
/*     */   }
/*     */   public void setCheckflag(boolean checkflag) {
/* 937 */     this.checkflag = checkflag;
/*     */   }
/*     */ 
/*     */   public int getNum()
/*     */   {
/* 946 */     return this.num;
/*     */   }
/*     */   public void setNum(int num) {
/* 949 */     this.num = num;
/*     */   }
/*     */   public String getRelationvalue() {
/* 952 */     return this.relationvalue;
/*     */   }
/*     */   public void setRelationvalue(String relationvalue) {
/* 955 */     this.relationvalue = relationvalue;
/*     */   }
/*     */   public String getRelationitem() {
/* 958 */     return this.relationitem;
/*     */   }
/*     */   public void setRelationitem(String relationitem) {
/* 961 */     this.relationitem = relationitem;
/*     */   }
/*     */   public boolean isMakecontNoflag() {
/* 964 */     return this.makecontNoflag;
/*     */   }
/*     */   public void setMakecontNoflag(boolean makecontNoflag) {
/* 967 */     this.makecontNoflag = makecontNoflag;
/*     */   }
/*     */   public boolean isDelflag() {
/* 970 */     return this.delflag;
/*     */   }
/*     */   public void setDelflag(boolean delflag) {
/* 973 */     this.delflag = delflag;
/*     */   }
/*     */   public boolean isRelflag() {
/* 976 */     return this.relflag;
/*     */   }
/*     */   public void setRelflag(boolean relflag) {
/* 979 */     this.relflag = relflag;
/*     */   }
/*     */   public boolean isCopyFlag() {
/* 982 */     return this.copyFlag;
/*     */   }
/*     */   public void setCopyFlag(boolean copyFlag) {
/* 985 */     this.copyFlag = copyFlag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BankRelationContNo
 * JD-Core Version:    0.6.0
 */