/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.BankBasicBL;
/*     */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.LNPPubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.Reflections;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.faces.model.SelectItem;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class PolicyMainInfo extends BankBasicBL
/*     */ {
/*  44 */   private IGlobalInput tempGI = null;
/*     */   private String checkPsignDate;
/*     */   private boolean operateFlag;
/*  48 */   private boolean alertFlag = false;
/*     */ 
/*  50 */   private boolean validateCheckPassFlag = false;
/*     */   private String infoSource;
/*     */   private String message;
/*     */   private boolean editFlag;
/*     */   private String checkedContNo;
/*     */   private boolean isExistsIconFlag;
/*     */   private String iconMsg;
/*     */   private String signCityFirst;
/*     */   private String inputOperator;
/*     */   private String modifyDate;
/*     */   private String consignNo;
/*     */   private String pvaliDate;
/*     */   private String psignDate;
/*     */   private String state;
/*     */   private String relationcode;
/*  73 */   private Map<String, String> stateMap = new HashMap();
/*  74 */   private LNPContSchema lnpcontschema = new LNPContSchema();
/*     */   private LNPContSchema tempLnpContSch;
/*  78 */   private List<SelectItem> signCityList = new ArrayList();
/*     */   private String operType;
/*     */   private String manageCom;
/*     */   private BankPolicyState policyState;
/*     */   private BankOperateDeal operateDeal;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  89 */     PolicyMainInfo p = new PolicyMainInfo();
/*  90 */     p.setState("01");
/*  91 */     LNPContSchema schema = new LNPContSchema();
/*  92 */     schema.setContNo("987000000055");
/*  93 */     p.setLnpcontschema(schema);
/*  94 */     p.isExistsIcon();
/*     */   }
/*     */ 
/*     */   public void isExistsIcon() {
/*  98 */     Connection conn = null;
/*     */     try {
/* 100 */       this.isExistsIconFlag = false;
/* 101 */       this.iconMsg = "";
/* 102 */       if (this.state != null)
/*     */       {
/* 104 */         String mySQLString = "select OutPayFlag from lnpcont where contno='" + this.lnpcontschema.getContNo() + "' and OutPayFlag='Y'";
/*     */ 
/* 108 */         ExeSQL execSQL = new ExeSQL();
/* 109 */         SSRS ssrs = execSQL.execSQL(mySQLString);
/* 110 */         if (ssrs.MaxRow > 0) {
/* 111 */           this.isExistsIconFlag = true;
/*     */         }
/*     */ 
/* 117 */         this.iconMsg = (this.isExistsIconFlag ? "\u5B58\u5728" : "\u4E0D\u5B58\u5728");
/*     */       }
/*     */     } catch (Exception e) {
/* 120 */       e.printStackTrace();
/* 121 */       System.out.println("////////////////////////////////////////////////~~~~~~~`" + e.getLocalizedMessage());
/*     */       try
/*     */       {
/* 124 */         if ((conn != null) && (!conn.isClosed()))
/* 125 */           conn.close();
/*     */       }
/*     */       catch (SQLException e) {
/* 128 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 124 */         if ((conn != null) && (!conn.isClosed()))
/* 125 */           conn.close();
/*     */       }
/*     */       catch (SQLException e) {
/* 128 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private Connection getConn()
/*     */   {
/* 135 */     Connection conn = null;
/*     */ 
/* 137 */     ExeSQL execSQL = new ExeSQL();
/* 138 */     Map keyList = new HashMap();
/* 139 */     SSRS ssrs = execSQL.execSQL("select SysVar, SysVarType from LNPSysVar a where exists (select 1  from LNPSysVar b where b.SysVar='icon_ds_type' and a.SysVarType=b.SysVarValue) and a.SysVar like 'icon_%'");
/*     */     String dbtypekey;
/* 140 */     for (int i = 1; i <= ssrs.MaxRow; i++) {
/* 141 */       dbtypekey = "dbtype";
/* 142 */       if (ssrs.GetText(i, 1).indexOf(dbtypekey) > 0)
/* 143 */         keyList.put(dbtypekey, ssrs.GetText(i, 1) + ssrs.GetText(i, 2));
/* 144 */       String dbnamekey = "dbname";
/* 145 */       if (ssrs.GetText(i, 1).indexOf(dbnamekey) > 0)
/* 146 */         keyList.put(dbnamekey, ssrs.GetText(i, 1) + ssrs.GetText(i, 2));
/* 147 */       String dbportkey = "dbport";
/* 148 */       if (ssrs.GetText(i, 1).indexOf(dbportkey) > 0)
/* 149 */         keyList.put(dbportkey, ssrs.GetText(i, 1) + ssrs.GetText(i, 2));
/* 150 */       String dbuserkey = "dbuser";
/* 151 */       if (ssrs.GetText(i, 1).indexOf(dbuserkey) > 0)
/* 152 */         keyList.put(dbuserkey, ssrs.GetText(i, 1) + ssrs.GetText(i, 2));
/* 153 */       String dbpwdkey = "dbpwd";
/* 154 */       if (ssrs.GetText(i, 1).indexOf(dbpwdkey) > 0)
/* 155 */         keyList.put(dbpwdkey, ssrs.GetText(i, 1) + ssrs.GetText(i, 2));
/* 156 */       String dbipkey = "dbip";
/* 157 */       if (ssrs.GetText(i, 1).indexOf(dbipkey) > 0)
/* 158 */         keyList.put(dbipkey, ssrs.GetText(i, 1) + ssrs.GetText(i, 2));
/* 159 */       String dbdriverkey = "dbdriver";
/* 160 */       if (ssrs.GetText(i, 1).indexOf(dbdriverkey) > 0)
/* 161 */         keyList.put(dbdriverkey, ssrs.GetText(i, 1) + ssrs.GetText(i, 2));
/*     */     }
/* 163 */     for (Map.Entry m : keyList.entrySet()) {
/* 164 */       System.out.println("key:" + (String)m.getKey() + "value:" + (String)m.getValue());
/*     */     }
/* 166 */     conn = BankGetIconDSource.getConn(keyList);
/* 167 */     return conn;
/*     */   }
/*     */ 
/*     */   private String getUnionPolicyNo(String unionCode, String contNo, ExeSQL execSQL) {
/* 171 */     String tmpStrList = "";
/*     */     try {
/* 173 */       if (execSQL == null) {
/* 174 */         execSQL = new ExeSQL();
/*     */       }
/* 176 */       if ((unionCode != null) && (!"".equals(unionCode.trim()))) {
/* 177 */         String sql = "select contno,agentcode1 from lnpcont where agentcode1='" + unionCode + "' and contno<>'" + contNo + "'";
/* 178 */         SSRS ssrs = execSQL.execSQL(sql);
/* 179 */         System.out.println("sql-->:" + sql);
/* 180 */         if (ssrs.MaxRow > 0) {
/* 181 */           for (int i = 1; i <= ssrs.MaxRow; i++)
/* 182 */             tmpStrList = tmpStrList + ssrs.GetText(i, 1) + (i != ssrs.MaxRow ? " | " : "");
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (RuntimeException e)
/*     */     {
/* 188 */       e.printStackTrace();
/*     */     }
/* 190 */     return tmpStrList;
/*     */   }
/*     */ 
/*     */   public void initMainData()
/*     */   {
/*     */     try
/*     */     {
/* 198 */       HttpSession session = (HttpSession)
/* 199 */         FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 200 */       String contNo = (String)session.getAttribute("ContNo");
/* 201 */       String userType = null;
/* 202 */       this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/* 203 */       System.out.println("\u83B7\u53D6\u5F53\u524D\u7684tempGI.LNPRole===============" + this.tempGI.LNPRole);
/* 204 */       if ((this.tempGI != null) && (this.tempGI.LNPRole != null) && (!this.tempGI.LNPRole.equals(""))) {
/* 205 */         System.out.println("\u8FDB\u5165\u4E861\u4E2D-------");
/* 206 */         userType = this.tempGI.LNPRole;
/*     */       } else {
/* 208 */         System.out.println("\u8FDB\u5165\u4E862\u4E2D-------");
/* 209 */         this.alertFlag = true;
/* 210 */         this.message = "\u8BE5\u767B\u5F55\u4EBA\u5458\u6CA1\u6709\u6295\u4FDD\u4E66\u5F55\u5165\u6743\u9650\uFF01";
/* 211 */         return;
/*     */       }
/* 213 */       System.out.println("\u5F53\u524DuserType\u7684\u503C\u4E3A======" + userType);
/* 214 */       initStateMap();
/*     */ 
/* 216 */       if ((contNo != null) && (!contNo.equals(""))) {
/* 217 */         System.out.println("\u5F55\u5165\u540E\u5237\u65B0\u754C\u9762");
/* 218 */         LNPContSchema tempSchema = getContByContNo(contNo);
/* 219 */         if (tempSchema != null) {
/* 220 */           this.lnpcontschema = tempSchema;
/* 221 */           this.tempLnpContSch = this.lnpcontschema;
/* 222 */           this.modifyDate = this.lnpcontschema.getModifyDate();
/* 223 */           this.signCityFirst = this.lnpcontschema.getSignCom();
/* 224 */           this.consignNo = this.lnpcontschema.getConsignNo();
/* 225 */           this.relationcode = getUnionPolicyNo(this.lnpcontschema.getAgentCode1(), contNo, null);
/* 226 */           this.pvaliDate = this.lnpcontschema.getPValiDate();
/* 227 */           this.psignDate = this.lnpcontschema.getPSignDate();
/* 228 */           this.inputOperator = getinputname(this.lnpcontschema.getInputOperator());
/*     */ 
/* 230 */           this.state = getStateFromMap(this.stateMap, this.lnpcontschema);
/*     */ 
/* 232 */           Boolean getEditFlag = (Boolean)session.getAttribute("Queryflag");
/* 233 */           BankOperateDeal stateDeal = new BankOperateDeal();
/* 234 */           Boolean operateFlag = Boolean.valueOf(stateDeal.isEidtSheet(tempSchema.getState(), "01", this.tempGI.LNPRole, contNo));
/* 235 */           if (getEditFlag == null) {
/* 236 */             if (operateFlag.booleanValue())
/* 237 */               this.editFlag = true;
/*     */           }
/* 239 */           else if ((getEditFlag.booleanValue()) && (operateFlag.booleanValue()))
/* 240 */             this.editFlag = true;
/*     */           else {
/* 242 */             this.editFlag = false;
/*     */           }
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 248 */           this.alertFlag = true;
/* 249 */           this.message = "\u6570\u636E\u5E93\u4E2D\u4E0D\u5B58\u5728\u8BE5\u6295\u4FDD\u4E66\uFF01";
/*     */         }
/* 251 */         this.infoSource = "modify";
/*     */       }
/*     */       else {
/* 254 */         System.out.println("\u7B2C\u4E00\u6B21\u521D\u59CB\u5316\u5F00\u59CB");
/* 255 */         System.out.println("\u8FDB\u5165\u4E863\u4E2D-------");
/* 256 */         this.editFlag = true;
/* 257 */         this.lnpcontschema = new LNPContSchema();
/* 258 */         this.lnpcontschema.setOperator(this.tempGI.Operator);
/* 259 */         this.lnpcontschema.setInputOperator(this.tempGI.Operator);
/* 260 */         this.lnpcontschema.setState("01");
/* 261 */         this.relationcode = "";
/* 262 */         this.signCityFirst = "";
/* 263 */         this.inputOperator = "";
/* 264 */         this.modifyDate = "";
/* 265 */         this.consignNo = "";
/* 266 */         this.psignDate = PubFun.getCurrentDate();
/* 267 */         this.pvaliDate = this.psignDate;
/* 268 */         this.state = null;
/* 269 */         this.infoSource = "add";
/*     */       }
/* 271 */       System.out.println("\u5F53\u524DeditFlag\u7684\u503C====" + this.editFlag);
/*     */     }
/*     */     catch (RuntimeException e) {
/* 274 */       e.printStackTrace();
/* 275 */       this.message = "\u8BE5\u6295\u4FDD\u4E66\u57FA\u7840\u4FE1\u606F\u6709\u8BEF\uFF01";
/*     */     }
/*     */   }
/*     */ 
/*     */   public void exit()
/*     */   {
/*     */     try {
/* 282 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 283 */       session.setAttribute("Queryflag", null);
/* 284 */       System.out.println("######################################\u79BB\u5F00\u7F16\u8F91\u9875\u9762######################################");
/* 285 */       this.operateDeal = new BankOperateDeal();
/* 286 */       System.out.println("######################################\u5F00\u59CB\u8C03\u7528\u89E3\u9501######################################");
/*     */ 
/* 288 */       this.operateDeal.turnEditPolicy(session, null, true);
/* 289 */       System.out.println("######################################\u89E3\u9501\u7ED3\u675F\u8C03\u7528######################################");
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   private String getinputname(String inputOperator2)
/*     */   {
/* 299 */     if ((inputOperator2 != null) && (!inputOperator2.equals(""))) {
/*     */       try {
/* 301 */         ExeSQL tExeSQL = new ExeSQL();
/* 302 */         String sql = "select username from muser where usercode='" + inputOperator2 + "'";
/* 303 */         SSRS tSSRS = tExeSQL.execSQL(sql);
/* 304 */         return tSSRS.GetText(1, 1);
/*     */       } catch (Exception e) {
/* 306 */         System.out.println("\u9519\u4E86\u9519\u4E86");
/* 307 */         return "";
/*     */       }
/*     */     }
/*     */ 
/* 311 */     return "";
/*     */   }
/*     */ 
/*     */   private String getStateFromMap(Map<String, String> stateMap2, LNPContSchema lnpcontschema2)
/*     */   {
/* 318 */     return (String)this.stateMap.get(lnpcontschema2.getState());
/*     */   }
/*     */ 
/*     */   private void initStateMap() {
/* 322 */     ExeSQL tExeSQL = new ExeSQL();
/* 323 */     String sql = "select code,codename from lnpcode where codetype='lnpLangState' order by code";
/* 324 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 325 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/* 326 */       this.stateMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*     */   }
/*     */ 
/*     */   public void checkContNo()
/*     */   {
/* 331 */     this.alertFlag = true;
/* 332 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/* 333 */       .getExternalContext().getSession(true);
/* 334 */     IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/*     */ 
/* 336 */     if ((!Pattern.matches("^[a-zA-Z0-9]{12}$", this.checkedContNo.substring(0))) && 
/* 337 */       (!Pattern.matches("^([M|m]{1})+([a-zA-Z0-9]{7})$", this.checkedContNo.substring(0)))) {
/* 338 */       this.lnpcontschema.setContNo("");
/* 339 */       this.message = "\u8BF7\u6309\u7167\u6B63\u786E\u683C\u5F0F\u5F55\u5165\u6295\u4FDD\u4E66\u7F16\u53F7\uFF01";
/* 340 */       this.alertFlag = true;
/* 341 */       return;
/*     */     }
/* 343 */     System.out.println("\u901A\u8FC7\u6295\u4FDD\u4E66\u53F7\u6821\u9A8C" + this.lnpcontschema.getContNo());
/* 344 */     String newContno = this.lnpcontschema.getContNo().toUpperCase();
/* 345 */     this.lnpcontschema.setContNo(newContno);
/* 346 */     this.alertFlag = false;
/*     */ 
/* 350 */     if (!this.alertFlag)
/* 351 */       checkContNoExist();
/*     */   }
/*     */ 
/*     */   public boolean velidatyInfo()
/*     */   {
/* 357 */     System.out.println("\u9875\u9762\u6821\u9A8C\u89C4\u5219\u5F00\u59CB");
/* 358 */     if ((this.lnpcontschema.getContNo() == null) || 
/* 359 */       (this.lnpcontschema.getContNo().trim().equals(""))) {
/* 360 */       this.alertFlag = true;
/* 361 */       this.message = "\u6295\u4FDD\u4E66\u7F16\u53F7\u4E0D\u80FD\u4E3A\u7A7A\uFF01";
/* 362 */       System.out.println(this.message);
/* 363 */       return false;
/*     */     }
/* 365 */     if ((this.infoSource.equals("add")) && 
/* 366 */       (getContByContNo(this.lnpcontschema
/* 367 */       .getContNo()) != null)) {
/* 368 */       System.out.println("infoSource=add------------------------");
/* 369 */       this.alertFlag = true;
/* 370 */       this.message = "\u8BE5\u6295\u4FDD\u4E66\u7F16\u53F7\u5728\u7CFB\u7EDF\u4E2D\u5DF2\u5B58\u5728\uFF01";
/* 371 */       return false;
/*     */     }
/*     */ 
/* 374 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean addInfo()
/*     */   {
/* 381 */     boolean flag = false;
/*     */     try
/*     */     {
/* 384 */       LNPContSchema addContSch = new LNPContSchema();
/*     */ 
/* 388 */       HttpSession session = (HttpSession)
/* 389 */         FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 390 */       IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/*     */ 
/* 392 */       if (tempGI == null)
/*     */       {
/* 395 */         return false;
/*     */       }
/*     */ 
/* 398 */       Reflections reflect = new Reflections();
/* 399 */       reflect.transFields(addContSch, this.lnpcontschema);
/*     */ 
/* 403 */       SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 404 */       addContSch.setProposalContNo(addContSch.getContNo());
/*     */ 
/* 407 */       addContSch.setPValiDate(this.pvaliDate);
/* 408 */       addContSch.setPSignDate(this.psignDate);
/* 409 */       addContSch.setSignCom(this.signCityFirst);
/* 410 */       addContSch.setConsignNo(this.consignNo);
/*     */ 
/* 412 */       addContSch.setContType("1");
/* 413 */       addContSch.setPolType("1");
/* 414 */       addContSch.setCardFlag("0");
/* 415 */       addContSch.setState("01");
/* 416 */       addContSch.setEditstate("1000000000");
/* 417 */       addContSch.setProposalType("1");
/* 418 */       addContSch.setApproveFlag("0");
/* 419 */       addContSch.setUWFlag("0");
/* 420 */       addContSch.setUWTime("0");
/*     */ 
/* 424 */       addContSch.setInsuredId("");
/* 425 */       addContSch.setAppntId("");
/* 426 */       addContSch.setAppntName("");
/*     */ 
/* 431 */       addContSch.setGrpContNo(LNPPubFun.getSysInfo("grpcontno"));
/* 432 */       addContSch.setPrtNo(LNPPubFun.getSysInfo("prtno"));
/*     */ 
/* 434 */       addContSch.setAgentCode(tempGI.Operator);
/* 435 */       addContSch.setOperator(tempGI.Operator);
/* 436 */       addContSch.setSaleChnlDetail(tempGI.chanlesign);
/* 437 */       addContSch.setManageCom(this.signCityFirst);
/*     */ 
/* 441 */       String date = PubFun.getCurrentDate();
/* 442 */       String time = PubFun.getCurrentTime();
/*     */ 
/* 444 */       addContSch.setModifyDate(date);
/* 445 */       addContSch.setModifyTime(time);
/* 446 */       addContSch.setMakeDate(date);
/* 447 */       addContSch.setMakeTime(time);
/*     */ 
/* 449 */       PubSubmit ps = new PubSubmit();
/* 450 */       MMap map = new MMap();
/*     */ 
/* 452 */       map.put(addContSch, "INSERT");
/*     */ 
/* 454 */       VData vd = new VData();
/* 455 */       vd.add(map);
/* 456 */       if (!ps.submitData(vd, "")) {
/* 457 */         this.message = "\u6295\u4FDD\u4E66\u57FA\u7840\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25\uFF01";
/* 458 */         return false;
/*     */       }
/*     */ 
/* 461 */       String sql = "select * from lnpcont where contno='" + addContSch.getContNo() + "'";
/* 462 */       ExeSQL tExesql = new ExeSQL();
/* 463 */       SSRS tSSRS = tExesql.execSQL(sql);
/* 464 */       if ((tSSRS != null) && (tSSRS.getMaxRow() > 0)) {
/* 465 */         flag = true;
/*     */       } else {
/* 467 */         System.out.println("\u6295\u4FDD\u5355\u57FA\u672C\u4FE1\u606F\u4FDD\u5B58\u8BED\u53E5\u6267\u884C\u5931\u8D25\uFF01");
/* 468 */         return false;
/*     */       }
/*     */     }
/*     */     catch (RuntimeException e)
/*     */     {
/* 473 */       e.printStackTrace();
/* 474 */       return false;
/*     */     }
/* 476 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean modifyInfo(LNPContSchema tempSchema)
/*     */   {
/* 484 */     boolean flag = true;
/*     */ 
/* 487 */     PubSubmit ps = new PubSubmit();
/* 488 */     MMap map = new MMap();
/*     */     try
/*     */     {
/* 491 */       tempSchema.setConsignNo(this.consignNo);
/*     */ 
/* 495 */       String date = PubFun.getCurrentDate();
/* 496 */       String time = PubFun.getCurrentTime();
/* 497 */       tempSchema.setModifyDate(date);
/* 498 */       tempSchema.setModifyTime(time);
/* 499 */       tempSchema.setInputOperator(this.tempGI.Operator);
/* 500 */       System.out.println("current signCom is:" + tempSchema.getSignCom() + ",new signCom is:" + this.signCityFirst + " change?");
/* 501 */       map.put(tempSchema, "UPDATE");
/*     */ 
/* 503 */       VData vd = new VData();
/* 504 */       vd.add(map);
/* 505 */       if (!ps.submitData(vd, ""))
/*     */       {
/* 507 */         this.message = "\u6295\u4FDD\u4E66\u57FA\u7840\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25\uFF01";
/*     */ 
/* 509 */         flag = false;
/*     */       }
/*     */     }
/*     */     catch (RuntimeException e) {
/* 513 */       e.printStackTrace();
/*     */ 
/* 515 */       this.message = "\u6295\u4FDD\u4E66\u57FA\u7840\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25\uFF01";
/*     */ 
/* 517 */       flag = false;
/*     */     }
/*     */ 
/* 520 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean saveMainInfo()
/*     */   {
/* 525 */     String date = PubFun.getCurrentDate();
/* 526 */     String time = PubFun.getCurrentTime();
/* 527 */     this.message = "";
/* 528 */     this.operateFlag = false;
/* 529 */     System.out.println("\u4FDD\u5B58\u5F00\u59CB----------------");
/* 530 */     boolean flag = false;
/* 531 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*     */     try {
/* 533 */       turnCurrPolicyLockFlag(session, this.lnpcontschema.getContNo(), "lock");
/* 534 */       if (!velidatyInfo()) {
/*     */         return false;
/*     */       }
/* 537 */       if (this.infoSource.equals("modify")) {
/* 538 */         System.out.println("\u8FD0\u884C\u4E86modify-------");
/* 539 */         LNPContSchema tempSchema = getContByContNo(this.lnpcontschema.getContNo());
/* 540 */         if (tempSchema == null)
/* 541 */           this.infoSource = "add";
/*     */         else {
/* 543 */           flag = modifyInfo(tempSchema);
/*     */         }
/*     */       }
/* 546 */       if (this.infoSource.equals("add")) {
/* 547 */         System.out.println("\u8FD0\u884C\u4E86add-------");
/* 548 */         flag = addInfo();
/* 549 */         this.policyState = new BankPolicyState();
/* 550 */         this.policyState.savePolicyState(this.lnpcontschema.getContNo(), this.lnpcontschema.getState(), "1", date, time);
/*     */       }
/* 552 */       if (flag)
/*     */       {
/* 554 */         session.setAttribute("ContNo", this.lnpcontschema.getContNo());
/* 555 */         session.setAttribute("CONTLOCK", "LOCKED");
/* 556 */         System.out.println("---\u6295\u4FDD\u4E66\u57FA\u7840\u4FE1\u606F\u4FDD\u5B58\u6210\u529F session.getAttribute--contno ---" + session.getAttribute("ContNo"));
/* 557 */         this.state = ((String)this.stateMap.get(this.lnpcontschema.getState()));
/* 558 */         this.message = "\u6295\u4FDD\u4E66\u57FA\u7840\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 559 */         this.operateFlag = true;
/*     */       }
/*     */       else
/*     */       {
/* 564 */         System.out.println("---\u6295\u4FDD\u4E66\u57FA\u7840\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25  " + this.lnpcontschema.getContNo());
/* 565 */         this.message = "\u6295\u4FDD\u4E66\u57FA\u7840\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25\uFF01";
/*     */       }
/*     */       return true;
/*     */     } catch (RuntimeException e) {
/* 569 */       e.printStackTrace();
/* 570 */       this.message = "\u6295\u4FDD\u4E66\u57FA\u7840\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25\uFF01";
/*     */       return false;
/*     */     } finally {
/* 573 */       turnCurrPolicyLockFlag(session, this.lnpcontschema.getContNo(), "unlock");
/* 574 */     }throw localObject;
/*     */   }
/*     */ 
/*     */   public LNPContSchema getContByContNo(String contNo)
/*     */   {
/* 605 */     LNPContDB db = new LNPContDB();
/* 606 */     db.setContNo(contNo);
/*     */ 
/* 608 */     if (db.getInfo()) {
/* 609 */       return db.getSchema();
/*     */     }
/* 611 */     return null;
/*     */   }
/*     */ 
/*     */   public void checkContNoExist()
/*     */   {
/* 620 */     String tempContNo = this.lnpcontschema.getContNo();
/* 621 */     System.out.println("\u5F00\u59CB\u68C0\u67E5\u6295\u4FDD\u4E66\u53F7\u662F\u5426\u5B58\u5728");
/* 622 */     this.alertFlag = false;
/*     */ 
/* 625 */     if (getContByContNo(tempContNo) != null) {
/* 626 */       this.alertFlag = true;
/* 627 */       this.lnpcontschema.setContNo("");
/* 628 */       this.message = "\u8BE5\u6295\u4FDD\u4E66\u7F16\u53F7\u5728\u7CFB\u7EDF\u4E2D\u5DF2\u5B58\u5728\uFF01";
/*     */     } else {
/* 630 */       this.alertFlag = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isAlertFlag()
/*     */   {
/* 636 */     return this.alertFlag;
/*     */   }
/*     */ 
/*     */   public void setAlertFlag(boolean alertFlag) {
/* 640 */     this.alertFlag = alertFlag;
/*     */   }
/*     */ 
/*     */   public String getMessage() {
/* 644 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message) {
/* 648 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public LNPContSchema getLnpcontschema() {
/* 652 */     return this.lnpcontschema;
/*     */   }
/*     */ 
/*     */   public void setLnpcontschema(LNPContSchema lnpcontschema) {
/* 656 */     this.lnpcontschema = lnpcontschema;
/*     */   }
/*     */ 
/*     */   public String getInfoSource() {
/* 660 */     return this.infoSource;
/*     */   }
/*     */ 
/*     */   public void setInfoSource(String infoSource) {
/* 664 */     this.infoSource = infoSource;
/*     */   }
/*     */ 
/*     */   public boolean isEditFlag()
/*     */   {
/* 669 */     return this.editFlag;
/*     */   }
/*     */ 
/*     */   public void setEditFlag(boolean editFlag) {
/* 673 */     this.editFlag = editFlag;
/*     */   }
/*     */ 
/*     */   public boolean isOperateFlag() {
/* 677 */     return this.operateFlag;
/*     */   }
/*     */ 
/*     */   public void setOperateFlag(boolean operateFlag) {
/* 681 */     this.operateFlag = operateFlag;
/*     */   }
/*     */ 
/*     */   public String getCheckPsignDate() {
/* 685 */     return this.checkPsignDate;
/*     */   }
/*     */ 
/*     */   public void setCheckPsignDate(String checkPsignDate) {
/* 689 */     this.checkPsignDate = checkPsignDate;
/*     */   }
/*     */ 
/*     */   public String getPvaliDate() {
/* 693 */     return this.pvaliDate;
/*     */   }
/*     */ 
/*     */   public void setPvaliDate(String pvaliDate) {
/* 697 */     this.pvaliDate = pvaliDate;
/*     */   }
/*     */ 
/*     */   public boolean isValidateCheckPassFlag() {
/* 701 */     return this.validateCheckPassFlag;
/*     */   }
/*     */ 
/*     */   public void setValidateCheckPassFlag(boolean validateCheckPassFlag) {
/* 705 */     this.validateCheckPassFlag = validateCheckPassFlag;
/*     */   }
/*     */ 
/*     */   public String getPsignDate() {
/* 709 */     return this.psignDate;
/*     */   }
/*     */ 
/*     */   public void setPsignDate(String psignDate) {
/* 713 */     this.psignDate = psignDate;
/*     */   }
/*     */ 
/*     */   public String getSignCityFirst()
/*     */   {
/* 719 */     return this.signCityFirst;
/*     */   }
/*     */ 
/*     */   public void setSignCityFirst(String signCityFirst) {
/* 723 */     this.signCityFirst = signCityFirst;
/*     */   }
/*     */ 
/*     */   public String getInputOperator()
/*     */   {
/* 729 */     return this.inputOperator;
/*     */   }
/*     */ 
/*     */   public void setInputOperator(String inputOperator) {
/* 733 */     this.inputOperator = inputOperator;
/*     */   }
/*     */ 
/*     */   public Map<String, String> getStateMap()
/*     */   {
/* 740 */     return this.stateMap;
/*     */   }
/*     */ 
/*     */   public void setStateMap(Map<String, String> stateMap) {
/* 744 */     this.stateMap = stateMap;
/*     */   }
/*     */ 
/*     */   public LNPContSchema getTempLnpContSch() {
/* 748 */     return this.tempLnpContSch;
/*     */   }
/*     */ 
/*     */   public void setTempLnpContSch(LNPContSchema tempLnpContSch) {
/* 752 */     this.tempLnpContSch = tempLnpContSch;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getSignCityList() {
/* 756 */     HttpSession session = (HttpSession)
/* 757 */       FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 758 */     this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/*     */ 
/* 760 */     if (this.tempGI == null) {
/* 761 */       this.message = "\u767B\u5F55\u4EBA\u5458\u4FE1\u606F\u4E22\u5931\uFF0C\u8BF7\u91CD\u65B0\u767B\u9646\uFF01";
/* 762 */       this.alertFlag = true;
/* 763 */       return null;
/*     */     }
/* 765 */     if (this.signCityList != null) {
/* 766 */       this.signCityList.clear();
/*     */     }
/* 768 */     ExeSQL tExeSQL = new ExeSQL();
/* 769 */     String sql = "select code,codename from lnpcode where codetype='BankSigned' and code like '" + this.tempGI.ManageCom + "%' order by othersign";
/* 770 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 771 */     for (int i = 1; i <= tSRS.MaxRow; i++) {
/* 772 */       this.signCityList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */     }
/* 774 */     return this.signCityList;
/*     */   }
/*     */ 
/*     */   public void setSignCityList(List<SelectItem> signCityList) {
/* 778 */     this.signCityList = signCityList;
/*     */   }
/*     */ 
/*     */   public String getCheckedContNo() {
/* 782 */     return this.checkedContNo;
/*     */   }
/*     */ 
/*     */   public void setCheckedContNo(String checkedContNo) {
/* 786 */     this.checkedContNo = checkedContNo;
/*     */   }
/*     */ 
/*     */   public String getState() {
/* 790 */     return this.state;
/*     */   }
/*     */ 
/*     */   public void setState(String state) {
/* 794 */     this.state = state;
/*     */   }
/*     */ 
/*     */   public String getOperType() {
/* 798 */     return this.operType;
/*     */   }
/*     */ 
/*     */   public String getModifyDate()
/*     */   {
/* 804 */     return formatDate(this.modifyDate, "YYYYMMDD");
/*     */   }
/*     */ 
/*     */   public void setModifyDate(String modifyDate) {
/* 808 */     this.modifyDate = modifyDate;
/*     */   }
/*     */ 
/*     */   public String getConsignNo() {
/* 812 */     return this.consignNo;
/*     */   }
/*     */ 
/*     */   public void setConsignNo(String consignNo) {
/* 816 */     this.consignNo = consignNo;
/*     */   }
/*     */ 
/*     */   public void setOperType(String operType) {
/* 820 */     this.operType = operType;
/*     */   }
/*     */ 
/*     */   public String getManageCom() {
/* 824 */     return this.manageCom;
/*     */   }
/*     */ 
/*     */   public void setManageCom(String manageCom) {
/* 828 */     this.manageCom = manageCom;
/*     */   }
/*     */ 
/*     */   public String getRelationcode() {
/* 832 */     return this.relationcode;
/*     */   }
/*     */ 
/*     */   public void setRelationcode(String relationcode) {
/* 836 */     this.relationcode = relationcode;
/*     */   }
/*     */ 
/*     */   public BankPolicyState getPolicyState() {
/* 840 */     return this.policyState;
/*     */   }
/*     */   public void setPolicyState(BankPolicyState policyState) {
/* 843 */     this.policyState = policyState;
/*     */   }
/*     */ 
/*     */   public boolean isExistsIconFlag()
/*     */   {
/* 848 */     return this.isExistsIconFlag;
/*     */   }
/*     */ 
/*     */   public String getIconMsg() {
/* 852 */     return this.iconMsg;
/*     */   }
/*     */ 
/*     */   private String formatDate(String srcDate, String formate)
/*     */   {
/* 859 */     String tDate = srcDate;
/* 860 */     if ((srcDate != null) && (!"".equals(srcDate.trim()))) {
/* 861 */       if (formate.indexOf("-") > 0)
/* 862 */         tDate = srcDate.substring(0, 4) + "-" + srcDate.substring(4, 6) + "-" + srcDate.substring(6, 8);
/*     */       else {
/* 864 */         tDate = srcDate.replaceAll("-", "");
/*     */       }
/*     */     }
/* 867 */     return tDate;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.PolicyMainInfo
 * JD-Core Version:    0.6.0
 */