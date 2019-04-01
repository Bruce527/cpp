/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPComDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPComGrpToComDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskAppDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskComCtrlDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskParamDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskRelaDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskRoleDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskSaleGroupToRiskDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPComGrpToComSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPComSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskAppSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskComCtrlSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskRelaSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskRoleSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskSaleGroupToRiskSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPComGrpToComSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPComSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskAppSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskComCtrlSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskRelaSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskRoleSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskSaleGroupToRiskSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskSet;
/*     */ import com.sinosoft.banklns.lnsmodel.riskinfo.RiskInfoImpl;
/*     */ import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
/*     */ import com.sinosoft.banklns.utility.CodeQueryImpl;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class RiskImpl
/*     */ {
/*     */   public LNPRiskSchema getRiskInfo(String riskCode)
/*     */   {
/*  39 */     LNPRiskDB reLNPRiskDB = new LNPRiskDB();
/*  40 */     reLNPRiskDB.setRiskCode(riskCode);
/*  41 */     if (reLNPRiskDB.getInfo()) {
/*  42 */       return reLNPRiskDB.getSchema();
/*     */     }
/*  44 */     return null;
/*     */   }
/*     */ 
/*     */   public String getURLForRisk(String riskcode, String type)
/*     */   {
/*  49 */     String url = null;
/*     */ 
/*  51 */     if ("S".equals(type)) {
/*  52 */       LNPRiskParamDB tLNPRiskParamDB = new LNPRiskParamDB();
/*  53 */       tLNPRiskParamDB.setType("URL");
/*  54 */       tLNPRiskParamDB.setRiskCode(riskcode);
/*  55 */       tLNPRiskParamDB.setParam("elementURL");
/*  56 */       if (tLNPRiskParamDB.getInfo()) {
/*  57 */         url = tLNPRiskParamDB.getExpression();
/*     */       }
/*     */       else
/*     */       {
/*  61 */         tLNPRiskParamDB = new LNPRiskParamDB();
/*  62 */         tLNPRiskParamDB.setType("URL");
/*  63 */         tLNPRiskParamDB.setRiskCode("000000");
/*  64 */         tLNPRiskParamDB.setParam("elementURL");
/*  65 */         tLNPRiskParamDB.getInfo();
/*  66 */         url = tLNPRiskParamDB.getExpression();
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  71 */       RiskInfoImpl riskInfoImpl = new RiskInfoImpl();
/*  72 */       url = riskInfoImpl.getDocument(riskcode, type);
/*  73 */       if (url != null) {
/*  74 */         int end = url.indexOf("=");
/*  75 */         url = url.substring(0, end);
/*     */       }
/*     */     }
/*     */ 
/*  79 */     return url;
/*     */   }
/*     */ 
/*     */   public List getBackShowPolUI(String polNo, IGlobalInput tIGlobalInput)
/*     */   {
/*  84 */     return null;
/*     */   }
/*     */ 
/*     */   public List getRiskUIRelaControl(PolElementSchema inPolElementSchema, String controlCode, String conttrolValue, IGlobalInput tIGlobalInput)
/*     */   {
/*  90 */     return null;
/*     */   }
/*     */ 
/*     */   public List getRiskInitUIData(String riskCode, String contNo, String insuredNo, String mainPolNo, IGlobalInput tIGlobalInput)
/*     */   {
/*  96 */     return null;
/*     */   }
/*     */ 
/*     */   public List getRiskListForType(String riskType, String riskType1, IGlobalInput tIGlobalInput, String insuredNo, String contNo)
/*     */   {
/* 103 */     String polManageCom = contNo.substring(0, 2);
/* 104 */     LNPComDB tLNPComDB = new LNPComDB();
/* 105 */     tLNPComDB.setValidCode(polManageCom);
/* 106 */     LNPComSet tLNPComSet = tLNPComDB.query();
/* 107 */     if (tLNPComSet.get(1) != null)
/*     */     {
/* 109 */       polManageCom = tLNPComSet.get(1).getComCode();
/*     */     }
/*     */     else
/*     */     {
/* 113 */       polManageCom = "";
/*     */     }
/*     */ 
/* 116 */     List list = new ArrayList();
/*     */ 
/* 118 */     Set set = new HashSet();
/*     */ 
/* 121 */     Set set_1 = getMainRiskForTypeExclude(insuredNo, contNo);
/*     */ 
/* 125 */     Set set_2 = getRiskForChnlAreaAge(tIGlobalInput, contNo, insuredNo);
/*     */ 
/* 129 */     Set set_3 = getRiskForRiskType(riskType, riskType1);
/*     */ 
/* 132 */     Set set_4 = getRiskForRiskSaleGroup(tIGlobalInput, polManageCom);
/*     */ 
/* 135 */     Set set_5 = getMainRiskForExist(insuredNo, contNo);
/*     */ 
/* 139 */     Set set_6 = getOneMainRisk(insuredNo, contNo);
/*     */ 
/* 142 */     if ((set_2 != null) && (set_2.size() > 0)) {
/* 143 */       Iterator iterator = set_2.iterator();
/* 144 */       while (iterator.hasNext()) {
/* 145 */         String riskcode = iterator.next().toString();
/* 146 */         if ((set_1 == null) || (!set_1.contains(riskcode)) || (set_3 == null) || 
/* 147 */           (!set_3.contains(riskcode)) || (set_4 == null) || 
/* 148 */           (!set_4.contains(riskcode)) || (set_5 == null) || 
/* 149 */           (!set_5.contains(riskcode)) || (set_6 == null) || 
/* 150 */           (!set_6.contains(riskcode))) continue;
/* 151 */         set.add(riskcode);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 156 */     if (set.size() > 0) {
/* 157 */       String sql = "select * from lnprisk where riskcode in (''";
/* 158 */       Iterator iterator = set.iterator();
/* 159 */       while (iterator.hasNext()) {
/* 160 */         sql = sql + ",'" + iterator.next().toString() + "'";
/*     */       }
/* 162 */       sql = sql + ") order by riskcode";
/* 163 */       LNPRiskDB reLNPRiskDB = new LNPRiskDB();
/* 164 */       LNPRiskSet reLNPRiskSet = reLNPRiskDB.executeQuery(sql);
/* 165 */       for (int i = 1; (reLNPRiskSet != null) && (i <= reLNPRiskSet.size()); i++) {
/* 166 */         list.add(reLNPRiskSet.get(i));
/*     */       }
/*     */     }
/*     */ 
/* 170 */     return list;
/*     */   }
/*     */ 
/*     */   private Set getMainRiskForTypeExclude(String insuredId, String contNo)
/*     */   {
/* 175 */     Set set = null;
/* 176 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 177 */     reLNPPolDB.setContNo(contNo);
/* 178 */     reLNPPolDB.setInsuredId(insuredId);
/* 179 */     reLNPPolDB.setSubFlag("M");
/* 180 */     LNPPolSet teLNPPolSet = reLNPPolDB.query();
/* 181 */     String existType = null;
/* 182 */     if ((teLNPPolSet != null) && (teLNPPolSet.size() > 0)) {
/* 183 */       LNPPolSchema temp = teLNPPolSet.get(1);
/* 184 */       String riskcode = temp.getRiskCode();
/* 185 */       LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
/* 186 */       reLNPRiskAppDB.setRiskCode(riskcode);
/* 187 */       if (reLNPRiskAppDB.getInfo()) {
/* 188 */         existType = reLNPRiskAppDB.getRiskProp();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 193 */     LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
/* 194 */     String sql = "select * from lnpriskapp where SubRiskFlag='M' ";
/* 195 */     if (existType != null)
/*     */     {
/* 197 */       if (existType.equals("U"))
/*     */       {
/* 199 */         sql = sql + " and RiskProp='U' ";
/* 200 */       } else if (existType.equals("I"))
/*     */       {
/* 202 */         sql = sql + " and RiskProp='I' ";
/*     */       }
/*     */       else {
/* 205 */         sql = sql + " and RiskProp<>'I' and  RiskProp<>'U' ";
/*     */       }
/*     */     }
/* 208 */     LNPRiskAppSet reLNPRiskAppSet = reLNPRiskAppDB.executeQuery(sql);
/* 209 */     if ((reLNPRiskAppSet != null) && (reLNPRiskAppSet.size() > 0)) {
/* 210 */       set = new HashSet();
/* 211 */       for (int i = 1; i <= reLNPRiskAppSet.size(); i++) {
/* 212 */         String riskcode = reLNPRiskAppSet.get(i).getRiskCode();
/* 213 */         set.add(riskcode);
/*     */       }
/*     */     }
/* 216 */     return set;
/*     */   }
/*     */ 
/*     */   private Set getRiskForRiskType(String riskType, String riskType1)
/*     */   {
/* 221 */     Set set = null;
/* 222 */     LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
/* 223 */     if ((riskType != null) && (!riskType.equals("")) && (riskType.length() > 0)) {
/* 224 */       reLNPRiskAppDB.setRiskProp(riskType);
/*     */     }
/*     */ 
/* 228 */     if ((riskType1 != null) && (!riskType1.equals("")) && (riskType1.length() > 0)) {
/* 229 */       if ("F".equals(riskType1)) {
/* 230 */         reLNPRiskAppDB.setRiskType1(riskType1);
/*     */       }
/* 232 */       if ("R".equals(riskType1)) {
/* 233 */         reLNPRiskAppDB.setRiskType2(riskType1);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 238 */     LNPRiskAppSet reLNPRiskAppSet = reLNPRiskAppDB.query();
/* 239 */     if ((reLNPRiskAppSet != null) && (reLNPRiskAppSet.size() > 0)) {
/* 240 */       set = new HashSet();
/* 241 */       for (int i = 1; i <= reLNPRiskAppSet.size(); i++) {
/* 242 */         String riskcode = reLNPRiskAppSet.get(i).getRiskCode();
/* 243 */         set.add(riskcode);
/*     */       }
/*     */     }
/* 246 */     return set;
/*     */   }
/*     */ 
/*     */   private Set getMainRiskForExist(String insuredId, String contNo)
/*     */   {
/* 251 */     Set set = null;
/* 252 */     String sql = "select * from lnpriskapp where SubRiskFlag='M' and riskcode not in (select riskcode from lnppol where contno='" + 
/* 254 */       contNo + "' and insuredid='" + insuredId + 
/* 255 */       "' and " + "SubFlag='M')";
/* 256 */     LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
/* 257 */     LNPRiskAppSet reLNPRiskAppSet = reLNPRiskAppDB.executeQuery(sql);
/* 258 */     if ((reLNPRiskAppSet != null) && (reLNPRiskAppSet.size() > 0)) {
/* 259 */       set = new HashSet();
/* 260 */       for (int i = 1; i <= reLNPRiskAppSet.size(); i++) {
/* 261 */         String riskcode = reLNPRiskAppSet.get(i).getRiskCode();
/* 262 */         set.add(riskcode);
/*     */       }
/*     */     }
/* 265 */     return set;
/*     */   }
/*     */ 
/*     */   private Set getOneMainRisk(String insuredId, String contNo)
/*     */   {
/* 270 */     Set set = null;
/* 271 */     String sql = "select * from lnppol where contno='" + contNo + "' and polno = masterpolno";
/* 272 */     LNPPolDB reLNPPolDBDB = new LNPPolDB();
/* 273 */     LNPPolSet reLNPPolSet = reLNPPolDBDB.executeQuery(sql);
/* 274 */     if ((reLNPPolSet != null) && (reLNPPolSet.size() > 0)) {
/* 275 */       set = new HashSet();
/*     */     }
/*     */     else
/*     */     {
/* 279 */       sql = "select * from lnpriskapp where SubRiskFlag='M'";
/* 280 */       LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
/* 281 */       LNPRiskAppSet reLNPRiskAppSet = reLNPRiskAppDB.executeQuery(sql);
/* 282 */       if ((reLNPRiskAppSet != null) && (reLNPRiskAppSet.size() > 0)) {
/* 283 */         set = new HashSet();
/* 284 */         for (int i = 1; i <= reLNPRiskAppSet.size(); i++) {
/* 285 */           String riskcode = reLNPRiskAppSet.get(i).getRiskCode();
/* 286 */           set.add(riskcode);
/*     */         }
/*     */       }
/*     */     }
/* 290 */     return set;
/*     */   }
/*     */ 
/*     */   private Set getRiskForChnlAreaAge(IGlobalInput tIGlobalInput, String contNo, String insuredId)
/*     */   {
/* 297 */     Set set = new HashSet();
/*     */ 
/* 299 */     LNPAppntDB reLNPAppntDB = new LNPAppntDB();
/* 300 */     reLNPAppntDB.setContNo(contNo);
/* 301 */     reLNPAppntDB.getInfo();
/*     */ 
/* 303 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/* 304 */     reLNPInsuredDB.setContNo(contNo);
/* 305 */     reLNPInsuredDB.setInsuredId(insuredId);
/* 306 */     reLNPInsuredDB.getInfo();
/*     */ 
/* 308 */     int appntAge = reLNPAppntDB.getAppntAge();
/* 309 */     int appAge = reLNPInsuredDB.getAppAge();
/* 310 */     String appAgeType = reLNPInsuredDB.getAppAgeType();
/*     */ 
/* 313 */     Set riskappset = null;
/*     */ 
/* 335 */     LNPRiskRoleDB tLNPRiskRoleDB = new LNPRiskRoleDB();
/* 336 */     tLNPRiskRoleDB.setRiskRole("01");
/* 337 */     LNPRiskRoleSet tLNPRiskRoleSet = tLNPRiskRoleDB.query();
/* 338 */     if ((tLNPRiskRoleSet != null) && (tLNPRiskRoleSet.size() > 0)) {
/* 339 */       riskappset = new HashSet();
/* 340 */       for (int i = 1; i <= tLNPRiskRoleSet.size(); i++) {
/* 341 */         String riskCode = tLNPRiskRoleSet.get(i).getRiskCode();
/* 342 */         String tempMinAgeType = tLNPRiskRoleSet.get(i).getMinAppAgeFlag();
/* 343 */         int tempMinAge = tLNPRiskRoleSet.get(i).getMinAppAge();
/* 344 */         String tempMaxAgeType = tLNPRiskRoleSet.get(i).getMAXAppAgeFlag();
/* 345 */         int tempMaxAge = tLNPRiskRoleSet.get(i).getMAXAppAge();
/*     */ 
/* 347 */         if (appAgeType.equals("D")) {
/* 348 */           if ((tempMinAgeType.equals("D")) && (tempMaxAgeType.equals("D")) && 
/* 349 */             (appAge >= tempMinAge) && (appAge <= tempMaxAge)) {
/* 350 */             riskappset.add(riskCode);
/*     */           }
/*     */ 
/* 353 */           if ((!tempMinAgeType.equals("D")) || (!tempMaxAgeType.equals("Y")) || 
/* 354 */             (appAge < tempMinAge)) continue;
/* 355 */           riskappset.add(riskCode);
/*     */         }
/* 358 */         else if (appAgeType.equals("Y")) {
/* 359 */           if ((tempMinAgeType.equals("D")) && (tempMaxAgeType.equals("Y")) && 
/* 360 */             (appAge <= tempMaxAge)) {
/* 361 */             riskappset.add(riskCode);
/*     */           }
/*     */ 
/* 364 */           if ((!tempMinAgeType.equals("Y")) || (!tempMaxAgeType.equals("Y")) || 
/* 365 */             (appAge < tempMinAge) || (appAge > tempMaxAge)) continue;
/* 366 */           riskappset.add(riskCode);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 377 */     LNPRiskComCtrlDB reLMRiskComCtrl = new LNPRiskComCtrlDB();
/* 378 */     reLMRiskComCtrl.setSaleChnl(tIGlobalInput.chanlesign);
/* 379 */     LNPRiskComCtrlSet teLNPRiskComCtrlSet = reLMRiskComCtrl.query();
/* 380 */     for (int i = 1; (teLNPRiskComCtrlSet != null) && (
/* 381 */       i <= teLNPRiskComCtrlSet.size()); )
/*     */     {
/* 382 */       LNPRiskComCtrlSchema reLNPRiskComCtrlSchema = teLNPRiskComCtrlSet
/* 383 */         .get(i);
/* 384 */       String riskcode = reLNPRiskComCtrlSchema.getRiskCode();
/*     */ 
/* 386 */       if ((riskappset != null) && (riskappset.contains(riskcode)))
/*     */       {
/* 388 */         String comGrp = reLNPRiskComCtrlSchema.getManageComGrp();
/*     */ 
/* 390 */         boolean flag = checkComCodeGrp(comGrp, tIGlobalInput.ComCode);
/* 391 */         if (flag)
/* 392 */           set.add(riskcode);
/*     */       }
/* 381 */       i++;
/*     */     }
/*     */ 
/* 396 */     return set;
/*     */   }
/*     */ 
/*     */   private Set getRiskForRiskSaleGroup(IGlobalInput tIGlobalInput, String polManageCom)
/*     */   {
/* 401 */     Set set = null;
/* 402 */     set = new HashSet();
/* 403 */     LNPRiskSaleGroupToRiskDB reLNPRiskSaleGroupToRiskDB = new LNPRiskSaleGroupToRiskDB();
/* 404 */     if ("000000".equals(tIGlobalInput.riskSaleGroup))
/*     */     {
/* 407 */       reLNPRiskSaleGroupToRiskDB.setGroupCode(tIGlobalInput.riskSaleGroup);
/* 408 */       LNPRiskSaleGroupToRiskSet teLNPRiskSaleGroupToRiskSet = reLNPRiskSaleGroupToRiskDB
/* 409 */         .query();
/* 410 */       int i = 1;
/*     */       do {
/* 412 */         set.add(teLNPRiskSaleGroupToRiskSet.get(i).getRiskCode());
/*     */ 
/* 411 */         i++;
/*     */ 
/* 410 */         if (teLNPRiskSaleGroupToRiskSet == null) break; 
/* 410 */       }while (
/* 411 */         i <= teLNPRiskSaleGroupToRiskSet.size());
/*     */     }
/*     */     else
/*     */     {
/* 415 */       reLNPRiskSaleGroupToRiskDB.setGroupCode(tIGlobalInput.riskSaleGroup);
/* 416 */       LNPRiskSaleGroupToRiskSet teLNPRiskSaleGroupToRiskSet = reLNPRiskSaleGroupToRiskDB
/* 417 */         .query();
/* 418 */       for (int i = 1; (teLNPRiskSaleGroupToRiskSet != null) && (
/* 419 */         i <= teLNPRiskSaleGroupToRiskSet.size()); )
/*     */       {
/* 420 */         set.add(teLNPRiskSaleGroupToRiskSet.get(i).getRiskCode());
/*     */ 
/* 419 */         i++;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 424 */     String reRiskSaleGroup = polManageCom;
/* 425 */     if ((reRiskSaleGroup != null) && (!"".equals(reRiskSaleGroup)))
/*     */     {
/* 427 */       reLNPRiskSaleGroupToRiskDB.setGroupCode(reRiskSaleGroup);
/* 428 */       LNPRiskSaleGroupToRiskSet teLNPRiskSaleGroupToRiskSet = reLNPRiskSaleGroupToRiskDB
/* 429 */         .query();
/* 430 */       for (int i = 1; (teLNPRiskSaleGroupToRiskSet != null) && (
/* 431 */         i <= teLNPRiskSaleGroupToRiskSet.size()); )
/*     */       {
/* 432 */         set.add(teLNPRiskSaleGroupToRiskSet.get(i).getRiskCode());
/*     */ 
/* 431 */         i++;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 436 */     return set;
/*     */   }
/*     */ 
/*     */   public List getRiskTypeList(IGlobalInput tIGlobalInput, String contNo, String insuredNo)
/*     */   {
/* 442 */     if (tIGlobalInput == null) {
/* 443 */       return null;
/*     */     }
/*     */ 
/* 447 */     String sql = "select * from lnpcode where codetype='RiskType' and code in ( select distinct riskprop from lnpriskapp where riskcode in( select riskcode from lnpriskcomctrl where salechnl='" + 
/* 450 */       tIGlobalInput.chanlesign + 
/* 451 */       "')" + 
/* 452 */       " and subriskflag='M') order by OTHERSIGN";
/* 453 */     List list = null;
/*     */     try {
/* 455 */       CodeQueryImpl codeQueryImpl = new CodeQueryImpl();
/* 456 */       list = codeQueryImpl.getInfoBySql(sql);
/*     */     } catch (Exception e) {
/* 458 */       e.printStackTrace();
/*     */     }
/* 460 */     List result = new ArrayList();
/* 461 */     LNPCodeSchema temp = new LNPCodeSchema();
/* 462 */     temp.setCode("");
/* 463 */     temp.setCodeName("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/* 464 */     result.add(temp);
/* 465 */     result.addAll(list);
/* 466 */     return result;
/*     */   }
/*     */ 
/*     */   private Set getAllPossibleSubRisk(IGlobalInput tIGlobalInput, String contNo, String insuredId, String flag)
/*     */   {
/* 473 */     Set set = null;
/*     */ 
/* 475 */     LNPAppntDB reLNPAppntDB = new LNPAppntDB();
/* 476 */     reLNPAppntDB.setContNo(contNo);
/* 477 */     reLNPAppntDB.getInfo();
/*     */ 
/* 479 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/* 480 */     reLNPInsuredDB.setContNo(contNo);
/* 481 */     reLNPInsuredDB.setInsuredId(insuredId);
/* 482 */     reLNPInsuredDB.getInfo();
/*     */ 
/* 484 */     int appntAge = reLNPAppntDB.getAppntAge();
/* 485 */     int insuredAge = reLNPInsuredDB.getAppAge();
/*     */ 
/* 487 */     LNPRiskRelaDB reLNPRiskRelaDB = new LNPRiskRelaDB();
/* 488 */     reLNPRiskRelaDB.setRelaCode("01");
/*     */ 
/* 490 */     reLNPRiskRelaDB.setSaleChnl(tIGlobalInput.chanlesign);
/*     */ 
/* 492 */     LNPRiskRelaSet reLNPRiskRelaSet = reLNPRiskRelaDB.query();
/* 493 */     if ((reLNPRiskRelaSet != null) && (reLNPRiskRelaSet.size() > 0)) {
/* 494 */       set = new HashSet();
/* 495 */       for (int i = 1; i <= reLNPRiskRelaSet.size(); i++) {
/* 496 */         String riskcode = null;
/* 497 */         if ("S".equals(flag))
/* 498 */           riskcode = reLNPRiskRelaSet.get(i).getRelaRiskCode();
/*     */         else {
/* 500 */           riskcode = reLNPRiskRelaSet.get(i).getRiskCode();
/*     */         }
/* 502 */         int mininsuage = reLNPRiskRelaSet.get(i).getMinInsuredAge();
/* 503 */         int maxinsuage = reLNPRiskRelaSet.get(i).getMaxInsuredAge();
/*     */ 
/* 505 */         int minappage = reLNPRiskRelaSet.get(i).getMinAppntAge();
/* 506 */         int maxappage = reLNPRiskRelaSet.get(i).getMaxAppntAge();
/*     */ 
/* 510 */         if ((mininsuage > insuredAge) || (minappage > appntAge) || 
/* 511 */           ((maxinsuage > 0) && (maxinsuage < insuredAge)) || (
/* 512 */           (maxappage > 0) && (maxappage < appntAge)))
/*     */         {
/*     */           continue;
/*     */         }
/*     */ 
/* 517 */         String comGrp = reLNPRiskRelaSet.get(i).getManageComGrp();
/*     */ 
/* 519 */         boolean dealflag = checkComCodeGrp(comGrp, tIGlobalInput.ComCode);
/*     */ 
/* 521 */         if (dealflag) {
/* 522 */           set.add(riskcode);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 527 */     return set;
/*     */   }
/*     */ 
/*     */   private Set getSubRiskForCurrentCondition(String contNo, String insuredId, IGlobalInput tIGlobalInput)
/*     */   {
/* 532 */     Set set = new HashSet();
/*     */ 
/* 535 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 536 */     reLNPPolDB.setContNo(contNo);
/* 537 */     reLNPPolDB.setInsuredId(insuredId);
/* 538 */     LNPPolSet reLNPPolSet = reLNPPolDB.query();
/* 539 */     for (int i = 1; (reLNPPolSet != null) && (i <= reLNPPolSet.size()); i++) {
/* 540 */       LNPPolSchema tempLNPPolSchema = reLNPPolSet.get(i);
/* 541 */       String riskcode = tempLNPPolSchema.getRiskCode();
/*     */ 
/* 544 */       int PayEndYear = tempLNPPolSchema.getPayEndYear();
/* 545 */       String PayEndYearFlag = tempLNPPolSchema.getPayEndYearFlag();
/* 546 */       String tsql = "";
/* 547 */       ExeSQL query = new ExeSQL();
/* 548 */       SSRS agentSSRS = null;
/* 549 */       if (PayEndYear == 1000) {
/* 550 */         tsql = "select code from lnpcode where codetype='SRiskPayIntv100'";
/* 551 */         agentSSRS = query.execSQL(tsql);
/*     */       }
/*     */ 
/* 554 */       String polno = tempLNPPolSchema.getPolNo();
/*     */ 
/* 571 */       Set tempSet = new HashSet();
/* 572 */       for (int j = 1; j <= reLNPPolSet.size(); j++) {
/* 573 */         LNPPolSchema tempSubLNPPolSchema = reLNPPolSet.get(j);
/* 574 */         String subriskcode = tempSubLNPPolSchema.getRiskCode();
/* 575 */         String masterpolno = tempSubLNPPolSchema.getMasterPolNo();
/* 576 */         String subpolno = tempSubLNPPolSchema.getPolNo();
/*     */ 
/* 579 */         if ((!masterpolno.equals(subpolno)) && (polno.equals(masterpolno))) {
/* 580 */           tempSet.add(subriskcode);
/*     */         }
/*     */       }
/*     */ 
/* 584 */       LNPRiskRelaDB reLNPRiskRelaDB = new LNPRiskRelaDB();
/* 585 */       reLNPRiskRelaDB.setRiskCode(riskcode);
/* 586 */       reLNPRiskRelaDB.setRelaCode("01");
/*     */ 
/* 588 */       reLNPRiskRelaDB.setSaleChnl(tIGlobalInput.chanlesign);
/* 589 */       LNPRiskRelaSet teLNPRiskRelaSet = reLNPRiskRelaDB.query();
/* 590 */       for (int k = 1; (teLNPRiskRelaSet != null) && (k <= teLNPRiskRelaSet.size()); k++) {
/* 591 */         String releriskcode = teLNPRiskRelaSet.get(k).getRelaRiskCode();
/*     */ 
/* 594 */         boolean sflag = false;
/* 595 */         if ((agentSSRS != null) && (agentSSRS.MaxRow > 0)) {
/* 596 */           for (int j = 1; j <= agentSSRS.MaxRow; j++) {
/* 597 */             if (releriskcode.equals(agentSSRS.GetText(j, 1).trim()))
/* 598 */               sflag = true;
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 603 */           SSRS subSSRS = null;
/* 604 */           String tsql1 = "select 1 from LNPRiskScreen where riskcode='" + releriskcode + "' and CtrlType='PayEndYear' and CtrlProperty1='02'";
/* 605 */           subSSRS = query.execSQL(tsql1);
/*     */           int j;
/* 606 */           if ((subSSRS != null) && (subSSRS.MaxRow > 0)) {
/* 607 */             String tsql2 = "select * from lnpcode where codetype like '%" + releriskcode + "' and codealias is not null and comcode='RE'";
/* 608 */             subSSRS = query.execSQL(tsql2);
/* 609 */             if ((subSSRS == null) || (subSSRS.MaxRow <= 0)) break label486; j = 1;
/*     */           }while (true) if ((PayEndYear == Integer.parseInt(subSSRS.GetText(j, 2))) && (PayEndYearFlag.equals(subSSRS.GetText(j, 4)))) {
/* 612 */               sflag = true;
/*     */             }
/*     */             else
/*     */             {
/* 610 */               j++; if (j <= subSSRS.MaxRow)
/*     */               {
/*     */                 continue;
/*     */               }
/*     */ 
/* 617 */               break;
/* 618 */               sflag = true;
/*     */             }
/*     */         }
/*     */ 
/* 622 */         label486: if ((!tempSet.contains(releriskcode)) && (sflag)) {
/* 623 */           set.add(releriskcode);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 629 */     return set;
/*     */   }
/*     */ 
/*     */   private boolean checkComCodeGrp(String comGrp, String comcode)
/*     */   {
/* 634 */     boolean flag = false;
/* 635 */     if ("000000".equals(comGrp)) {
/* 636 */       flag = true;
/*     */     } else {
/* 638 */       LNPComGrpToComDB rerLNPComGrpToCom = new LNPComGrpToComDB();
/* 639 */       rerLNPComGrpToCom.setComGrpCode(comGrp);
/* 640 */       LNPComGrpToComSet teLNPComGrpToComSet = rerLNPComGrpToCom.query();
/* 641 */       for (int j = 1; (teLNPComGrpToComSet != null) && (
/* 642 */         j <= teLNPComGrpToComSet.size()); )
/*     */       {
/* 643 */         LNPComGrpToComSchema temp = teLNPComGrpToComSet.get(j);
/* 644 */         if ((comcode != null) && (comcode.indexOf(temp.getComCode()) == 0))
/*     */         {
/* 646 */           flag = true;
/* 647 */           break;
/*     */         }
/* 642 */         j++;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 651 */     return flag;
/*     */   }
/*     */ 
/*     */   public List getSubRiskList(IGlobalInput tIGlobalInput, String insuredNo, String contNo)
/*     */   {
/* 658 */     String polManageCom = contNo.substring(0, 2);
/* 659 */     LNPComDB tLNPComDB = new LNPComDB();
/* 660 */     tLNPComDB.setValidCode(polManageCom);
/* 661 */     LNPComSet tLNPComSet = tLNPComDB.query();
/* 662 */     if (tLNPComSet.get(1) != null)
/*     */     {
/* 664 */       polManageCom = tLNPComSet.get(1).getComCode();
/*     */     }
/*     */     else
/*     */     {
/* 668 */       polManageCom = "";
/*     */     }
/*     */ 
/* 672 */     List list = new ArrayList();
/*     */ 
/* 674 */     Set set = new HashSet();
/*     */ 
/* 678 */     Set set_1 = getRiskForChnlAreaAge(tIGlobalInput, contNo, insuredNo);
/*     */ 
/* 681 */     Set set_2 = getRiskForRiskSaleGroup(tIGlobalInput, polManageCom);
/*     */ 
/* 684 */     Set set_3 = getAllPossibleSubRisk(tIGlobalInput, contNo, insuredNo, "S");
/*     */ 
/* 687 */     Set set_4 = getSubRiskForCurrentCondition(contNo, insuredNo, tIGlobalInput);
/*     */ 
/* 690 */     if ((set_4 != null) && (set_4.size() > 0)) {
/* 691 */       Iterator iterator = set_4.iterator();
/* 692 */       while (iterator.hasNext()) {
/* 693 */         String riskcode = iterator.next().toString();
/* 694 */         if ((set_1 == null) || (!set_1.contains(riskcode)) || (set_3 == null) || 
/* 695 */           (!set_3.contains(riskcode)) || (set_2 == null) || 
/* 696 */           (!set_2.contains(riskcode))) continue;
/* 697 */         set.add(riskcode);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 702 */     if (set.size() > 0) {
/* 703 */       String sql = "select * from lnprisk where riskcode in (''";
/* 704 */       Iterator iterator = set.iterator();
/* 705 */       while (iterator.hasNext()) {
/* 706 */         sql = sql + ",'" + iterator.next().toString() + "'";
/*     */       }
/* 708 */       sql = sql + ") order by riskcode";
/* 709 */       LNPRiskDB reLNPRiskDB = new LNPRiskDB();
/* 710 */       LNPRiskSet reLNPRiskSet = reLNPRiskDB.executeQuery(sql);
/* 711 */       for (int i = 1; (reLNPRiskSet != null) && (i <= reLNPRiskSet.size()); i++) {
/* 712 */         list.add(reLNPRiskSet.get(i));
/*     */       }
/*     */     }
/*     */ 
/* 716 */     return list;
/*     */   }
/*     */ 
/*     */   public List getMainRiskInfoList(String subRiskCode, IGlobalInput tIGlobalInput, String insuredNo, String contNo)
/*     */   {
/* 723 */     String polManageCom = contNo.substring(0, 2);
/* 724 */     LNPComDB tLNPComDB = new LNPComDB();
/* 725 */     tLNPComDB.setValidCode(polManageCom);
/* 726 */     LNPComSet tLNPComSet = tLNPComDB.query();
/* 727 */     if (tLNPComSet.get(1) != null)
/*     */     {
/* 729 */       polManageCom = tLNPComSet.get(1).getComCode();
/*     */     }
/*     */     else
/*     */     {
/* 733 */       polManageCom = "";
/*     */     }
/*     */ 
/* 736 */     List list = new ArrayList();
/*     */ 
/* 738 */     Set set = new HashSet();
/*     */ 
/* 742 */     Set set_1 = getRiskForChnlAreaAge(tIGlobalInput, contNo, insuredNo);
/*     */ 
/* 745 */     Set set_2 = getRiskForRiskSaleGroup(tIGlobalInput, polManageCom);
/*     */ 
/* 748 */     Set set_3 = getAllPossibleSubRisk(tIGlobalInput, contNo, insuredNo, "M");
/*     */ 
/* 751 */     if ((set_3 != null) && (set_3.size() > 0)) {
/* 752 */       Iterator iterator = set_3.iterator();
/* 753 */       while (iterator.hasNext()) {
/* 754 */         String riskcode = iterator.next().toString();
/* 755 */         if ((set_1 == null) || (!set_1.contains(riskcode)) || (set_2 == null) || 
/* 756 */           (!set_2.contains(riskcode))) continue;
/* 757 */         set.add(riskcode);
/*     */       }
/*     */ 
/* 761 */       LNPPolDB reLNPPolDB = new LNPPolDB();
/* 762 */       reLNPPolDB.setContNo(contNo);
/* 763 */       reLNPPolDB.setInsuredId(insuredNo);
/*     */ 
/* 765 */       LNPPolSet reLNPPolSet = reLNPPolDB.query();
/*     */ 
/* 767 */       String sql = "select * from lnppol where contno='" + 
/* 768 */         contNo + 
/* 769 */         "' and insuredid='" + 
/* 770 */         insuredNo + 
/* 771 */         "' and " + 
/* 772 */         "riskcode in (select riskcode from LnpRiskRela where relacode='01' " + 
/* 773 */         "and relariskcode='" + subRiskCode + "')";
/* 774 */       LNPPolSet mainLNPPolSet = reLNPPolDB.executeQuery(sql);
/*     */ 
/* 777 */       ExeSQL query = new ExeSQL();
/* 778 */       String tsql = "select code from lnpcode where codetype='SRiskPayIntv100' and code = '" + subRiskCode + "'";
/* 779 */       SSRS agentSSRS = query.execSQL(tsql);
/*     */ 
/* 783 */       for (int i = 1; (mainLNPPolSet != null) && (i <= mainLNPPolSet.size()); i++) {
/* 784 */         LNPPolSchema tempLNPPolSchema = mainLNPPolSet.get(i);
/*     */ 
/* 787 */         if ((set == null) || (!set.contains(tempLNPPolSchema.getRiskCode())))
/*     */           continue;
/* 789 */         boolean sign = false;
/* 790 */         for (int j = 1; j <= reLNPPolSet.size(); j++) {
/* 791 */           if ((reLNPPolSet.get(j).getMasterPolNo().equals(reLNPPolSet.get(j).getPolNo())) || 
/* 792 */             (!reLNPPolSet.get(j).getMasterPolNo().equals(tempLNPPolSchema.getPolNo())) || 
/* 793 */             (!reLNPPolSet.get(j).getRiskCode().equals(subRiskCode)))
/*     */             continue;
/* 795 */           sign = true;
/* 796 */           break;
/*     */         }
/*     */ 
/* 800 */         if ((tempLNPPolSchema.getPayEndYear() == 1000) && (agentSSRS.MaxRow == 0)) sign = true;
/*     */ 
/* 802 */         if (!sign) {
/* 803 */           list.add(tempLNPPolSchema);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 808 */     return list;
/*     */   }
/*     */ 
/*     */   public boolean checkRiskGroup(String mainRiskCode, String subRiskCode, IGlobalInput tIGlobalInput, int insuAge, int appntAge)
/*     */   {
/* 813 */     boolean result = false;
/* 814 */     LNPRiskRelaDB reLNPRiskRelaDB = new LNPRiskRelaDB();
/* 815 */     reLNPRiskRelaDB.setRiskCode(mainRiskCode);
/* 816 */     reLNPRiskRelaDB.setRelaRiskCode(subRiskCode);
/* 817 */     reLNPRiskRelaDB.setRelaCode("02");
/*     */ 
/* 819 */     reLNPRiskRelaDB.setSaleChnl(tIGlobalInput.chanlesign);
/* 820 */     LNPRiskRelaSet etLNPRiskRelaSet = reLNPRiskRelaDB.query();
/* 821 */     for (int i = 1; (etLNPRiskRelaSet != null) && (i <= etLNPRiskRelaSet.size()); i++) {
/* 822 */       LNPRiskRelaSchema temLNPRiskRelaSchema = etLNPRiskRelaSet.get(i);
/* 823 */       String comGrp = temLNPRiskRelaSchema.getManageComGrp();
/*     */ 
/* 825 */       int mininsuage = temLNPRiskRelaSchema.getMinInsuredAge();
/* 826 */       int maxinsuage = temLNPRiskRelaSchema.getMaxInsuredAge();
/*     */ 
/* 828 */       int minappage = temLNPRiskRelaSchema.getMinAppntAge();
/* 829 */       int maxappage = temLNPRiskRelaSchema.getMaxAppntAge();
/*     */ 
/* 833 */       if ((mininsuage > insuAge) || (minappage > appntAge) || 
/* 834 */         ((maxinsuage > 0) && (maxinsuage < insuAge)) || (
/* 835 */         (maxappage > 0) && (maxappage < appntAge)))
/*     */       {
/*     */         continue;
/*     */       }
/* 839 */       boolean flag = checkComCodeGrp(comGrp, tIGlobalInput.ComCode);
/*     */ 
/* 841 */       if (flag) {
/* 842 */         result = true;
/* 843 */         break;
/*     */       }
/*     */     }
/* 846 */     return result;
/*     */   }
/*     */ 
/*     */   public String getSubRiskOfRiskGroup(String mainRiskCode, IGlobalInput tIGlobalInput, int insuAge, int appntAge)
/*     */   {
/* 851 */     String subRiskCode = null;
/* 852 */     LNPRiskRelaDB reLNPRiskRelaDB = new LNPRiskRelaDB();
/* 853 */     reLNPRiskRelaDB.setRiskCode(mainRiskCode);
/* 854 */     reLNPRiskRelaDB.setRelaCode("02");
/*     */ 
/* 856 */     reLNPRiskRelaDB.setSaleChnl(tIGlobalInput.chanlesign);
/* 857 */     LNPRiskRelaSet etLNPRiskRelaSet = reLNPRiskRelaDB.query();
/* 858 */     for (int i = 1; (etLNPRiskRelaSet != null) && (i <= etLNPRiskRelaSet.size()); i++) {
/* 859 */       LNPRiskRelaSchema temLNPRiskRelaSchema = etLNPRiskRelaSet.get(i);
/* 860 */       String comGrp = temLNPRiskRelaSchema.getManageComGrp();
/*     */ 
/* 862 */       int mininsuage = temLNPRiskRelaSchema.getMinInsuredAge();
/* 863 */       int maxinsuage = temLNPRiskRelaSchema.getMaxInsuredAge();
/*     */ 
/* 865 */       int minappage = temLNPRiskRelaSchema.getMinAppntAge();
/* 866 */       int maxappage = temLNPRiskRelaSchema.getMaxAppntAge();
/*     */ 
/* 870 */       if ((mininsuage > insuAge) || (minappage > appntAge) || 
/* 871 */         ((maxinsuage > 0) && (maxinsuage < insuAge)) || (
/* 872 */         (maxappage > 0) && (maxappage < appntAge)))
/*     */       {
/*     */         continue;
/*     */       }
/* 876 */       boolean flag = checkComCodeGrp(comGrp, tIGlobalInput.ComCode);
/*     */ 
/* 878 */       if (flag) {
/* 879 */         subRiskCode = temLNPRiskRelaSchema.getRelaRiskCode();
/*     */ 
/* 881 */         break;
/*     */       }
/*     */     }
/* 884 */     return subRiskCode;
/*     */   }
/*     */ 
/*     */   public boolean checkSubRisk(String mainRiskCode, String subRiskCode, IGlobalInput tIGlobalInput, int insuAge, int appntAge)
/*     */   {
/* 889 */     boolean result = false;
/* 890 */     LNPRiskRelaDB reLNPRiskRelaDB = new LNPRiskRelaDB();
/* 891 */     reLNPRiskRelaDB.setRiskCode(mainRiskCode);
/* 892 */     reLNPRiskRelaDB.setRelaRiskCode(subRiskCode);
/* 893 */     reLNPRiskRelaDB.setRelaCode("01");
/*     */ 
/* 895 */     reLNPRiskRelaDB.setSaleChnl(tIGlobalInput.chanlesign);
/* 896 */     LNPRiskRelaSet etLNPRiskRelaSet = reLNPRiskRelaDB.query();
/* 897 */     for (int i = 1; (etLNPRiskRelaSet != null) && (i <= etLNPRiskRelaSet.size()); i++) {
/* 898 */       LNPRiskRelaSchema temLNPRiskRelaSchema = etLNPRiskRelaSet.get(i);
/* 899 */       String comGrp = temLNPRiskRelaSchema.getManageComGrp();
/*     */ 
/* 901 */       int mininsuage = temLNPRiskRelaSchema.getMinInsuredAge();
/* 902 */       int maxinsuage = temLNPRiskRelaSchema.getMaxInsuredAge();
/*     */ 
/* 904 */       int minappage = temLNPRiskRelaSchema.getMinAppntAge();
/* 905 */       int maxappage = temLNPRiskRelaSchema.getMaxAppntAge();
/*     */ 
/* 909 */       if ((mininsuage > insuAge) || (minappage > appntAge) || 
/* 910 */         ((maxinsuage > 0) && (maxinsuage < insuAge)) || (
/* 911 */         (maxappage > 0) && (maxappage < appntAge)))
/*     */       {
/*     */         continue;
/*     */       }
/* 915 */       boolean flag = checkComCodeGrp(comGrp, tIGlobalInput.ComCode);
/*     */ 
/* 917 */       if (flag) {
/* 918 */         result = true;
/* 919 */         break;
/*     */       }
/*     */     }
/* 922 */     return result;
/*     */   }
/*     */ 
/*     */   public Set getExemptRisk() {
/* 926 */     LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
/* 927 */     reLNPRiskAppDB.setRiskProp("R");
/* 928 */     LNPRiskAppSet reLNPRiskAppSet = reLNPRiskAppDB.query();
/* 929 */     Set set = new HashSet();
/* 930 */     for (int i = 1; (reLNPRiskAppSet != null) && (i <= reLNPRiskAppSet.size()); i++) {
/* 931 */       set.add(reLNPRiskAppSet.get(i).getRiskCode());
/*     */     }
/* 933 */     return set;
/*     */   }
/*     */ 
/*     */   public String getTotalOfSuggest(String contNo)
/*     */   {
/* 939 */     DecimalFormat myformat = new DecimalFormat("#,##0");
/*     */ 
/* 941 */     DecimalFormat myformatdo = new DecimalFormat("#,##0.00");
/*     */ 
/* 943 */     String resultStr = null;
/* 944 */     double result = 0.0D;
/* 945 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 946 */     reLNPPolDB.setContNo(contNo);
/* 947 */     LNPPolSet reLNPPolSet = reLNPPolDB.query();
/* 948 */     if ((reLNPPolSet != null) && (reLNPPolSet.size() > 0)) {
/* 949 */       for (int i = 1; i <= reLNPPolSet.size(); i++) {
/* 950 */         result += reLNPPolSet.get(i).getSumPrem();
/*     */       }
/* 952 */       double check = (int)result;
/* 953 */       if (check == result)
/* 954 */         resultStr = myformatdo.format(result);
/*     */       else {
/* 956 */         resultStr = myformatdo.format(result);
/*     */       }
/*     */     }
/* 959 */     return resultStr;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.RiskImpl
 * JD-Core Version:    0.6.0
 */