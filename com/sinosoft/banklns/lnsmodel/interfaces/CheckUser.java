/*     */ package com.sinosoft.banklns.lnsmodel.interfaces;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPPersonDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPPersonSet;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.Namespace;
/*     */ 
/*     */ public class CheckUser extends PublicInterfaces
/*     */ {
/*     */   private LNPContSchema tLNPContSchema;
/*     */   private LNPPersonSet tLNPPersonSet;
/*     */   private LNPAppntSchema tLNPAppntSchema;
/*     */   private LNPInsuredSchema tLNPInsuredSchema;
/*     */   private String userName;
/*     */   private String password;
/*     */ 
/*     */   protected void initObject()
/*     */   {
/*  36 */     this.modelFileName = "dupli_in.xml";
/*  37 */     this.sendFileName = "dupli_in";
/*  38 */     this.returnFileName = "dupli_out";
/*  39 */     this.defaultErrorMessage = "\u5BA2\u6237\u76F8\u4F3C\u5EA6\u6821\u9A8C\u5931\u8D25\uFF01";
/*     */ 
/*  45 */     super.initObject();
/*     */   }
/*     */ 
/*     */   protected boolean dealReturn()
/*     */   {
/*     */     try
/*     */     {
/*  52 */       LNPPersonSet bakPersonSet = new LNPPersonSet();
/*  53 */       bakPersonSet.set(this.tLNPPersonSet);
/*     */ 
/*  55 */       LNPContSchema bakLNPContSchema = new LNPContSchema();
/*  56 */       bakLNPContSchema.setSchema(this.tLNPContSchema);
/*     */ 
/*  58 */       LNPAppntSchema bakLNPAppntSchema = new LNPAppntSchema();
/*  59 */       bakLNPAppntSchema.setSchema(this.tLNPAppntSchema);
/*     */ 
/*  61 */       LNPInsuredSchema bakLNPInsuredSchema = new LNPInsuredSchema();
/*  62 */       bakLNPInsuredSchema.setSchema(this.tLNPInsuredSchema);
/*     */ 
/*  64 */       Element returnN = getReturnBody();
/*     */ 
/*  79 */       Namespace err = Namespace.getNamespace("http://www.csc.smart/bo/schemas/Error");
/*  80 */       Element errorN = returnN.getChild("ERROR", err);
/*  81 */       if (errorN != null) {
/*  82 */         System.out.println("EAI\u8C03\u7528LA\u6210\u529F\uFF0C\u4F46\u8FD4\u56DE\u4E86\u9519\u8BEF\uFF01");
/*  83 */         Element statusN = errorN.getChild("STATUS", err);
/*  84 */         Element reason = errorN.getChild("REASON", err);
/*  85 */         String valiReason = reason.getChild("ERROR_DESC", err).getText();
/*  86 */         this.message += valiReason;
/*  87 */         System.out.println("ERROR_DESC==" + this.message);
/*     */ 
/*  89 */         return false;
/*     */       }
/*     */ 
/*  92 */       Element returnInfoN = returnN.getChild("RETURNINFO");
/*  93 */       if (returnInfoN == null) {
/*  94 */         System.out.println("***********************SOAP ERROR**************MSP\u63A5\u53E3CLTService\u8C03\u7528\u51FA\u9519\uFF01");
/*  95 */         return false;
/*     */       }
/*     */ 
/*  98 */       if (("".equals(getValueInXML(returnInfoN, "ERRCODE"))) || (getValueInXML(returnInfoN, "ERRCODE") == null) || ("0".equals(getValueInXML(returnInfoN, "ERRCODE"))))
/*     */       {
/* 101 */         List clientList = returnInfoN.getChildren("CLIENTLIST");
/* 102 */         for (int i = 1; (i <= this.tLNPPersonSet.size()) && (i <= clientList.size()); i++) {
/* 103 */           Element client = ((Element)clientList.get(i - 1)).getChild("CLIENTINFO");
/*     */ 
/* 105 */           String seqnoN = getValueInXML(client, "SEQNO");
/* 106 */           if ("1".equals(seqnoN)) {
/* 107 */             setModifyTime(this.tLNPContSchema);
/* 108 */             this.tLNPContSchema.setAppntNo(getValueInXML(client, "LIFCNUM"));
/* 109 */             setModifyTime(this.tLNPAppntSchema);
/* 110 */             this.tLNPAppntSchema.setAppntNo(getValueInXML(client, "LIFCNUM"));
/* 111 */             for (int j = 1; j <= this.tLNPPersonSet.size(); j++) {
/* 112 */               LNPPersonSchema tempSchema = this.tLNPPersonSet.get(j);
/* 113 */               if ((tempSchema != null) && (this.tLNPAppntSchema.getAppntId().equals(tempSchema.getCustomerId()))) {
/* 114 */                 tempSchema.setCustomerNo(getValueInXML(client, "LIFCNUM"));
/* 115 */                 setModifyTime(tempSchema);
/* 116 */                 break;
/*     */               }
/*     */             }
/*     */           }
/* 119 */           if ("2".equals(seqnoN)) {
/* 120 */             setModifyTime(this.tLNPContSchema);
/* 121 */             this.tLNPContSchema.setInsuredNo(getValueInXML(client, "LIFCNUM"));
/* 122 */             setModifyTime(this.tLNPInsuredSchema);
/* 123 */             this.tLNPInsuredSchema.setInsuredNo(getValueInXML(client, "LIFCNUM"));
/* 124 */             for (int j = 1; j <= this.tLNPPersonSet.size(); j++) {
/* 125 */               LNPPersonSchema tempSchema = this.tLNPPersonSet.get(j);
/* 126 */               if ((tempSchema != null) && (this.tLNPInsuredSchema.getInsuredId().equals(tempSchema.getCustomerId()))) {
/* 127 */                 tempSchema.setCustomerNo(getValueInXML(client, "LIFCNUM"));
/* 128 */                 setModifyTime(tempSchema);
/* 129 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/* 134 */         this.bakMap.put(bakPersonSet, "UPDATE");
/* 135 */         this.bakMap.put(bakLNPContSchema, "UPDATE");
/* 136 */         this.bakMap.put(bakLNPAppntSchema, "UPDATE");
/* 137 */         this.bakMap.put(bakLNPInsuredSchema, "UPDATE");
/*     */ 
/* 139 */         this.map.put(this.tLNPPersonSet, "UPDATE");
/* 140 */         this.map.put(this.tLNPContSchema, "UPDATE");
/* 141 */         this.map.put(this.tLNPAppntSchema, "UPDATE");
/* 142 */         this.map.put(this.tLNPInsuredSchema, "UPDATE");
/* 143 */         return true;
/*     */       }
/* 145 */       this.message = getValueInXML(returnInfoN, "PDESC");
/* 146 */       System.out.println("\u51FA\u73B0\u9519\u8BEF\uFF01");
/* 147 */       return false;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 159 */       e.printStackTrace();
/* 160 */     }return false;
/*     */   }
/*     */ 
/*     */   protected boolean dealSend()
/*     */   {
/*     */     try
/*     */     {
/* 167 */       Element msgBody = getSendBody();
/* 168 */       String company = mappingCode(this.tLNPContSchema.getManageCom(), "BankSigned");
/*     */ 
/* 171 */       Namespace msp = Namespace.getNamespace("http://www.csc.smart/msp/schemas/MSPContext");
/* 172 */       List msgList = msgBody.getChildren();
/* 173 */       Element mspContent = (Element)msgList.get(0);
/*     */ 
/* 175 */       Element userId = mspContent.getChild("UserId", msp);
/* 176 */       userId.setText(this.userName);
/* 177 */       Element uerPassword = mspContent.getChild("UserPassword", msp);
/* 178 */       uerPassword.setText(this.password);
/* 179 */       Element reqps = mspContent.getChild("RequestParameters", msp);
/* 180 */       Element requestParameter = reqps.getChild("RequestParameter", msp);
/* 181 */       requestParameter.setAttribute("name", "BRANCH").setAttribute("value", company);
/*     */ 
/* 193 */       Element app = msgBody.getChild("APPCLIENTLIST");
/* 194 */       updateText(app, "CNTBRANCH", company);
/* 195 */       updateText(app, "TTMPRCNO", this.tLNPContSchema.getContNo());
/* 196 */       Element clientList = app.getChild("CLIENTLIST");
/* 197 */       Element client = clientList.getChild("CLIENTINFO");
/* 198 */       clientList.removeContent();
/*     */ 
/* 201 */       Element tempClient_app = (Element)client.clone();
/* 202 */       updateText(tempClient_app, "SEQNO", "01");
/* 203 */       updateText(tempClient_app, "LSURNAME", this.tLNPAppntSchema.getAppntName());
/* 204 */       updateText(tempClient_app, "DOB", fomartDate(this.tLNPAppntSchema.getAppntBirthday()));
/* 205 */       updateText(tempClient_app, "IDNNUM", this.tLNPAppntSchema.getIDNo());
/* 206 */       updateText(tempClient_app, "IDNPRF", mappingCode(this.tLNPAppntSchema.getIDType(), "BankCertType"));
/* 207 */       updateText(tempClient_app, "NATLTY", this.tLNPAppntSchema.getNativePlace());
/* 208 */       updateText(tempClient_app, "CLTSEX", mappingCode(this.tLNPAppntSchema.getAppntSex(), "BankPolicySex"));
/* 209 */       clientList.addContent(tempClient_app);
/* 210 */       Element tempClient_ins = (Element)client.clone();
/* 211 */       updateText(tempClient_ins, "SEQNO", "02");
/* 212 */       updateText(tempClient_ins, "LSURNAME", this.tLNPInsuredSchema.getName());
/* 213 */       updateText(tempClient_ins, "DOB", fomartDate(this.tLNPInsuredSchema.getBirthday()));
/* 214 */       updateText(tempClient_ins, "IDNNUM", this.tLNPInsuredSchema.getIDNo());
/* 215 */       updateText(tempClient_ins, "IDNPRF", mappingCode(this.tLNPInsuredSchema.getIDType(), "BankCertType"));
/* 216 */       updateText(tempClient_ins, "NATLTY", this.tLNPInsuredSchema.getNativePlace());
/* 217 */       updateText(tempClient_ins, "CLTSEX", mappingCode(this.tLNPInsuredSchema.getSex(), "BankPolicySex"));
/* 218 */       clientList.addContent(tempClient_ins);
/* 219 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/* 222 */       e.printStackTrace();
/* 223 */     }return false;
/*     */   }
/*     */ 
/*     */   protected boolean getInputData(String tContNo)
/*     */   {
/*     */     try {
/* 229 */       this.valiPassFlag = true;
/*     */ 
/* 231 */       ExeSQL exeSQL = new ExeSQL(this.con);
/* 232 */       SSRS ssrs = exeSQL.execSQL("select sysvartype,sysvarvalue from lnpsysvar where SysVar='issue_user_password'");
/* 233 */       if (ssrs.MaxRow > 0) {
/* 234 */         this.userName = ssrs.GetText(1, 1);
/* 235 */         this.password = ssrs.GetText(1, 2);
/*     */       } else {
/* 237 */         this.message = "\u7F3A\u5931\u6743\u9650,\u8BF7\u83B7\u53D6\u6743\u9650\u540E\u7EE7\u7EED\u64CD\u4F5C!";
/* 238 */         return this.valiPassFlag = 0;
/*     */       }
/*     */ 
/* 241 */       LNPContDB ldb = new LNPContDB(this.con);
/* 242 */       ldb.setContNo(tContNo);
/* 243 */       if (!ldb.getInfo()) {
/* 244 */         this.message = "\u83B7\u53D6\u6295\u4FDD\u4E66\u4FE1\u606F\u5931\u8D25\uFF01";
/* 245 */         return this.valiPassFlag = 0;
/*     */       }
/* 247 */       this.tLNPContSchema = ldb.getSchema();
/*     */ 
/* 250 */       LNPAppntDB lpadb = new LNPAppntDB(this.con);
/* 251 */       lpadb.setContNo(tContNo);
/* 252 */       if (lpadb.getInfo()) {
/* 253 */         this.tLNPAppntSchema = lpadb.getSchema();
/*     */       } else {
/* 255 */         this.message = "\u83B7\u53D6\u6295\u4FDD\u4EBA\u4FE1\u606F\u5931\u8D25\uFF01";
/* 256 */         return this.valiPassFlag = 0;
/*     */       }
/*     */ 
/* 259 */       LNPInsuredDB lpidb = new LNPInsuredDB(this.con);
/* 260 */       lpidb.setContNo(tContNo);
/* 261 */       this.tLNPInsuredSchema = lpidb.query().get(1);
/*     */ 
/* 263 */       LNPPersonDB lpdb = new LNPPersonDB(this.con);
/* 264 */       this.tLNPPersonSet = lpdb.executeQuery("select * from lnpperson where CustomerId in ('" + this.tLNPAppntSchema.getAppntId() + "','" + this.tLNPInsuredSchema.getInsuredId() + "')");
/*     */     } catch (Exception e) {
/* 266 */       this.message = "\u83B7\u53D6\u88AB\u4FDD\u4EBA\u4FE1\u606F\u5931\u8D25\uFF01";
/* 267 */       return this.valiPassFlag = 0;
/*     */     }
/*     */ 
/* 270 */     return true;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 274 */     CheckUser cal = new CheckUser();
/* 275 */     String tContNo = "123213213123";
/* 276 */     tContNo = "201805311336";
/*     */ 
/* 278 */     cal.calInterfaces(tContNo);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.interfaces.CheckUser
 * JD-Core Version:    0.6.0
 */