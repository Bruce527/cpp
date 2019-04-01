/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPComDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPUWQuestionDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.schema.LNPComSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*     */ import com.sinosoft.banklns.lis.vdb.LNPPolDBSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPComSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPUWQuestionSet;
/*     */ import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
/*     */ import com.sinosoft.banklns.lnsmodel.util.SugError;
/*     */ import com.sinosoft.banklns.utility.CodeQueryImpl;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.PubFun;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class RiskPolImpl
/*     */ {
/*     */   public SugError addRisk(PolElementSchema inPolElementSchema, IGlobalInput tGlobalInput)
/*     */   {
/*  47 */     RiskImpl riskImpl = new RiskImpl();
/*  48 */     PubFun tPubFun = new PubFun();
/*  49 */     String currentDate = PubFun.getCurrentDate();
/*  50 */     String currentTime = PubFun.getCurrentTime();
/*     */ 
/*  54 */     List result = new ArrayList();
/*     */ 
/*  56 */     List polElementSchemaList = new ArrayList();
/*     */ 
/*  60 */     inPolElementSchema = initPolElementInfo(inPolElementSchema, 
/*  61 */       tGlobalInput);
/*     */ 
/*  65 */     PolElementSchema mainPolElementSchema = (PolElementSchema)inPolElementSchema
/*  66 */       .clone();
/*     */ 
/*  69 */     mainPolElementSchema.setMakeDate(currentDate);
/*  70 */     mainPolElementSchema.setMakeTime(currentTime);
/*     */ 
/*  72 */     InsuCoreImpl insuCoreImpl = new InsuCoreImpl();
/*  73 */     PolElementSchema outPolElementSchema = insuCoreImpl.calcutePol(mainPolElementSchema);
/*     */ 
/*  76 */     polElementSchemaList.add(outPolElementSchema);
/*     */ 
/*  80 */     String subriskcode = riskImpl.getSubRiskOfRiskGroup(outPolElementSchema
/*  81 */       .getRiskCode(), tGlobalInput, inPolElementSchema.getAppAge(), 
/*  82 */       inPolElementSchema.getAppntAge());
/*  83 */     if ((subriskcode != null) && (subriskcode.length() > 0))
/*     */     {
/*  86 */       PolElementSchema subPolElementSchema = (PolElementSchema)inPolElementSchema
/*  87 */         .clone();
/*  88 */       subPolElementSchema.setSubRiskFlag("S");
/*  89 */       subPolElementSchema.setRiskCode(subriskcode);
/*     */ 
/*  92 */       subPolElementSchema.setMasterPolNo(outPolElementSchema.getPolNo());
/*  93 */       subPolElementSchema.setMakeDate(currentDate);
/*  94 */       subPolElementSchema.setMakeTime(currentTime);
/*  95 */       PolElementSchema outsubPolElementSchema = insuCoreImpl
/*  96 */         .calcutePol(subPolElementSchema);
/*  97 */       polElementSchemaList.add(outsubPolElementSchema);
/*     */     }
/*     */ 
/* 105 */     String masterPolno = getTopPolNo(outPolElementSchema.getPolNo());
/* 106 */     dealWithExemptRisk(masterPolno);
/*     */ 
/* 108 */     RiskCheckCenterImpl riskCheckCenterImpl = new RiskCheckCenterImpl();
/* 109 */     SugError sugError = riskCheckCenterImpl.checkForOnePol(
/* 110 */       outPolElementSchema.getPolNo(), tGlobalInput, "");
/*     */ 
/* 115 */     if (sugError.hasError())
/*     */     {
/* 117 */       String sql = "delete from lnppol where polno in (''";
/* 118 */       for (int i = 0; i < polElementSchemaList.size(); i++) {
/* 119 */         sql = sql + ",'" + 
/* 120 */           ((PolElementSchema)polElementSchemaList.get(i))
/* 121 */           .getPolNo() + "'";
/*     */       }
/* 123 */       sql = sql + ")";
/* 124 */       ExeSQL reExeSQL = new ExeSQL();
/*     */ 
/* 126 */       reExeSQL.execUpdateSQL(sql);
/*     */ 
/* 129 */       dealWithExemptRisk(masterPolno);
/*     */     }
/*     */     else
/*     */     {
/* 133 */       afterupdateRisk(inPolElementSchema.getContNo());
/*     */     }
/*     */ 
/* 136 */     return sugError;
/*     */   }
/*     */ 
/*     */   private boolean afterupdateRisk(String contno)
/*     */   {
/* 141 */     System.out.println("----- \u027E\uFFFD\uFFFD\uFFFD\uFFFD\u07B8\uFFFD\uFFFD\uFFFD\uFFFD\u05B9\uFFFD\uFFFD \u027E\uFFFD\uFFFD\u02F1\uFFFD\uFFFD\uFFFD\uFFFD\u06F6\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD ----");
/* 142 */     boolean flag = false;
/*     */     try {
/* 144 */       PubSubmit ps = new PubSubmit();
/* 145 */       MMap mmap = new MMap();
/*     */ 
/* 147 */       LNPUWQuestionDB queDB = new LNPUWQuestionDB();
/*     */ 
/* 149 */       String sql = "select * from LNPUWQuestion where contno='" + contno + "'";
/* 150 */       LNPUWQuestionSet queSet = queDB.executeQuery(sql);
/* 151 */       if ((queSet != null) && (queSet.size() > 0)) {
/* 152 */         mmap.put(queSet, "DELETE");
/*     */       }
/* 154 */       PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 155 */       LNPContSchema tLNPContSchema = mainInfo.getContByContNo(contno);
/* 156 */       if ("2".equals(tLNPContSchema.getUWFlag())) {
/* 157 */         tLNPContSchema.setUWFlag("1");
/*     */       }
/*     */ 
/* 160 */       tLNPContSchema.setApproveFlag("0");
/* 161 */       mmap.put(tLNPContSchema, "UPDATE");
/*     */ 
/* 163 */       VData vd = new VData();
/* 164 */       vd.add(mmap);
/*     */ 
/* 166 */       if (!ps.submitData(vd, ""))
/* 167 */         flag = false;
/*     */       else
/* 169 */         flag = true;
/*     */     }
/*     */     catch (RuntimeException e)
/*     */     {
/* 173 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 176 */     return flag;
/*     */   }
/*     */ 
/*     */   private PolElementSchema initPolElementInfo(PolElementSchema inPolElementSchema, IGlobalInput tGlobalInput)
/*     */   {
/* 191 */     if ((inPolElementSchema != null) && (!"".equals(inPolElementSchema)))
/*     */     {
/* 193 */       String com = inPolElementSchema.getContNo().substring(0, 2);
/* 194 */       LNPComDB tLNPComDB = new LNPComDB();
/* 195 */       tLNPComDB.setValidCode(com);
/* 196 */       LNPComSet tLNPComSet = tLNPComDB.query();
/*     */ 
/* 198 */       if (tLNPComSet.get(1) != null)
/*     */       {
/* 200 */         inPolElementSchema.setManageCom(tLNPComSet.get(1).getComCode());
/*     */       }
/*     */       else
/*     */       {
/* 204 */         inPolElementSchema.setManageCom(tGlobalInput.ComCode);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 209 */       inPolElementSchema.setManageCom(tGlobalInput.ComCode);
/*     */     }
/*     */ 
/* 213 */     inPolElementSchema.setRiskChannel(tGlobalInput.chanlesign);
/* 214 */     inPolElementSchema.setAgentCode(tGlobalInput.Operator);
/* 215 */     inPolElementSchema.setBranchType(tGlobalInput.BranchType);
/*     */ 
/* 218 */     LNPAppntDB reLNPAppntDB = new LNPAppntDB();
/*     */ 
/* 220 */     reLNPAppntDB.setContNo(inPolElementSchema.getContNo());
/* 221 */     if (reLNPAppntDB.getInfo()) {
/* 222 */       inPolElementSchema.setAppntAge(reLNPAppntDB.getAppntAge());
/* 223 */       inPolElementSchema.setAppntAgeType(reLNPAppntDB.getAppntAgeType());
/* 224 */       inPolElementSchema.setAppntNo(reLNPAppntDB.getAppntNo());
/* 225 */       inPolElementSchema.setAppntId(reLNPAppntDB.getAppntId());
/* 226 */       inPolElementSchema.setAppntSex(reLNPAppntDB.getAppntSex());
/* 227 */       inPolElementSchema.setAppntOccupationCode(reLNPAppntDB
/* 228 */         .getOccupationCode());
/* 229 */       inPolElementSchema
/* 230 */         .setAppntNativePlace(reLNPAppntDB.getNativePlace());
/*     */     }
/*     */ 
/* 234 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/* 235 */     reLNPInsuredDB.setContNo(inPolElementSchema.getContNo());
/*     */ 
/* 237 */     reLNPInsuredDB.setInsuredId(inPolElementSchema.getInsuredId());
/* 238 */     if (reLNPInsuredDB.getInfo()) {
/* 239 */       inPolElementSchema.setInsuredId(reLNPInsuredDB.getInsuredId());
/* 240 */       inPolElementSchema.setName(reLNPInsuredDB.getName());
/* 241 */       inPolElementSchema.setAppAge(reLNPInsuredDB.getAppAge());
/* 242 */       inPolElementSchema.setAppAgeType(reLNPInsuredDB.getAppAgeType());
/* 243 */       inPolElementSchema.setSex(reLNPInsuredDB.getSex());
/* 244 */       inPolElementSchema.setBirthday(reLNPInsuredDB.getBirthday());
/* 245 */       inPolElementSchema.setOccupationCode(reLNPInsuredDB
/* 246 */         .getOccupationCode());
/* 247 */       inPolElementSchema.setInsuredNativePlace(reLNPInsuredDB
/* 248 */         .getNationality());
/*     */ 
/* 250 */       inPolElementSchema.setRelationToAppnt(reLNPInsuredDB
/* 251 */         .getRelationToAppnt());
/*     */     }
/* 253 */     return inPolElementSchema;
/*     */   }
/*     */ 
/*     */   private PolElementSchema getInfoFromPol(PolElementSchema inPolElementSchema, LNPPolSchema backLNPPolSchema)
/*     */   {
/* 260 */     inPolElementSchema.setRiskCode(backLNPPolSchema.getRiskCode());
/* 261 */     inPolElementSchema.setAmnt(backLNPPolSchema.getAmnt());
/* 262 */     inPolElementSchema.setPrem(backLNPPolSchema.getPrem());
/*     */ 
/* 264 */     inPolElementSchema.setDeadAmntType(backLNPPolSchema.getDeadAmntType());
/* 265 */     inPolElementSchema.setTopUpPrem(backLNPPolSchema.getTopUpPrem());
/*     */ 
/* 267 */     inPolElementSchema.setMult(backLNPPolSchema.getMult());
/* 268 */     inPolElementSchema.setBonusGetMode(backLNPPolSchema.getBonusGetMode());
/* 269 */     inPolElementSchema.setGet(backLNPPolSchema.getAmnt());
/* 270 */     inPolElementSchema.setLiveGetMode(backLNPPolSchema.getLiveGetMode());
/* 271 */     inPolElementSchema.setGetYear(backLNPPolSchema.getGetYear());
/* 272 */     inPolElementSchema.setGetYearFlag(backLNPPolSchema.getGetYearFlag());
/* 273 */     inPolElementSchema.setInsuYear(backLNPPolSchema.getInsuYear());
/* 274 */     inPolElementSchema.setInsuYearFlag(backLNPPolSchema.getInsuYearFlag());
/* 275 */     inPolElementSchema.setPayEndYear(backLNPPolSchema.getPayEndYear());
/* 276 */     inPolElementSchema.setPayEndYearFlag(backLNPPolSchema
/* 277 */       .getPayEndYearFlag());
/* 278 */     inPolElementSchema.setPayIntv(backLNPPolSchema.getPayIntv());
/* 279 */     inPolElementSchema.setStandbyFlag1(backLNPPolSchema.getStandbyFlag1());
/* 280 */     inPolElementSchema.setStandbyFlag2(backLNPPolSchema.getStandbyFlag2());
/* 281 */     inPolElementSchema.setStandbyFlag3(backLNPPolSchema.getStandbyFlag3());
/* 282 */     inPolElementSchema.setSubRiskFlag(backLNPPolSchema.getSubFlag());
/* 283 */     inPolElementSchema.setPolNo(backLNPPolSchema.getPolNo());
/*     */ 
/* 285 */     inPolElementSchema.setMasterPolNo(backLNPPolSchema.getMasterPolNo());
/* 286 */     inPolElementSchema.setYears(backLNPPolSchema.getYears());
/* 287 */     inPolElementSchema.setPayYears(backLNPPolSchema.getPayYears());
/* 288 */     inPolElementSchema.setMakeDate(backLNPPolSchema.getMakeDate());
/* 289 */     inPolElementSchema.setMakeTime(backLNPPolSchema.getMakeTime());
/*     */ 
/* 291 */     return inPolElementSchema;
/*     */   }
/*     */ 
/*     */   public SugError atvUpdateRisk(PolElementSchema inPolElementSchema, IGlobalInput tGlobalInput)
/*     */   {
/* 297 */     if (tGlobalInput == null) {
/* 298 */       return null;
/*     */     }
/*     */ 
/* 303 */     inPolElementSchema = initPolElementInfo(inPolElementSchema, 
/* 304 */       tGlobalInput);
/*     */ 
/* 307 */     RiskImpl riskImpl = new RiskImpl();
/*     */ 
/* 309 */     String subriskcode = riskImpl.getSubRiskOfRiskGroup(inPolElementSchema
/* 310 */       .getRiskCode(), tGlobalInput, inPolElementSchema.getAppAge(), 
/* 311 */       inPolElementSchema.getAppntAge());
/*     */ 
/* 315 */     List list = getPolList(inPolElementSchema.getPolNo(), 1);
/* 316 */     List polListBack = (List)list.get(1);
/* 317 */     String delSql = " (''";
/* 318 */     for (int f = 0; (polListBack != null) && (f < polListBack.size()); f++) {
/* 319 */       LNPPolSchema reLNPPolSchema = (LNPPolSchema)polListBack.get(f);
/* 320 */       delSql = delSql + ",'" + reLNPPolSchema.getPolNo() + "'";
/*     */     }
/* 322 */     delSql = delSql + ") ";
/*     */ 
/* 328 */     PubSubmit ps1 = new PubSubmit();
/* 329 */     LNPPolDB poldb = new LNPPolDB();
/* 330 */     MMap mmap1 = new MMap();
/* 331 */     LNPPolSet deLNPPolSet1 = poldb.executeQuery("select * from lnppol where polno in " + delSql);
/* 332 */     mmap1.put(deLNPPolSet1, "DELETE");
/* 333 */     VData vd1 = new VData();
/* 334 */     vd1.add(mmap1);
/* 335 */     boolean reflag1 = ps1.submitData(vd1, "");
/*     */ 
/* 341 */     List newPolData = new ArrayList();
/* 342 */     String subGroupPolNo = "";
/* 343 */     for (int f = 0; (polListBack != null) && (f < polListBack.size()); f++) {
/* 344 */       LNPPolSchema reLNPPolSchema = (LNPPolSchema)polListBack.get(f);
/*     */ 
/* 346 */       if (f == 0) {
/* 347 */         PolElementSchema mainPolElementSchema = (PolElementSchema)inPolElementSchema
/* 348 */           .clone();
/* 349 */         mainPolElementSchema.setPolNo(reLNPPolSchema.getPolNo());
/*     */ 
/* 352 */         mainPolElementSchema.setMakeDate(reLNPPolSchema.getMakeDate());
/* 353 */         mainPolElementSchema.setMakeTime(reLNPPolSchema.getMakeTime());
/*     */ 
/* 356 */         InsuCoreImpl insuCoreImpl = new InsuCoreImpl();
/* 357 */         PolElementSchema outPolElementSchema = insuCoreImpl
/* 358 */           .calcutePol(mainPolElementSchema);
/* 359 */         newPolData.add(outPolElementSchema);
/*     */ 
/* 362 */         if ((subriskcode != null) && (subriskcode.length() > 0)) {
/* 363 */           for (int s = 0; s < polListBack.size(); s++) {
/* 364 */             LNPPolSchema ressLNPPolSchema = 
/* 365 */               (LNPPolSchema)polListBack
/* 365 */               .get(s);
/*     */ 
/* 367 */             if (!ressLNPPolSchema.getMasterPolNo().equals(
/* 367 */               reLNPPolSchema.getPolNo()))
/*     */               continue;
/* 369 */             if (ressLNPPolSchema.getRiskCode().equals(
/* 369 */               subriskcode)) {
/* 370 */               subGroupPolNo = ressLNPPolSchema.getPolNo();
/* 371 */               break;
/*     */             }
/*     */           }
/*     */ 
/* 375 */           PolElementSchema subPolElementSchema = (PolElementSchema)inPolElementSchema
/* 376 */             .clone();
/* 377 */           subPolElementSchema.setSubRiskFlag("S");
/* 378 */           subPolElementSchema.setRiskCode(subriskcode);
/* 379 */           subPolElementSchema.setMasterPolNo(outPolElementSchema
/* 380 */             .getPolNo());
/* 381 */           subPolElementSchema.setPolNo(subGroupPolNo);
/*     */ 
/* 385 */           subPolElementSchema.setMakeDate(reLNPPolSchema.getMakeDate());
/* 386 */           subPolElementSchema.setMakeTime(reLNPPolSchema.getMakeTime());
/* 387 */           PolElementSchema outsubPolElementSchema = insuCoreImpl
/* 388 */             .calcutePol(subPolElementSchema);
/* 389 */           newPolData.add(outsubPolElementSchema);
/*     */         }
/*     */       } else {
/* 391 */         if (subGroupPolNo.equals(reLNPPolSchema.getPolNo()))
/*     */         {
/*     */           continue;
/*     */         }
/* 395 */         PolElementSchema tempPolElementSchema = (PolElementSchema)inPolElementSchema
/* 396 */           .clone();
/* 397 */         tempPolElementSchema = getInfoFromPol(tempPolElementSchema, 
/* 398 */           reLNPPolSchema);
/*     */ 
/* 400 */         InsuCoreImpl insuCoreImpl = new InsuCoreImpl();
/* 401 */         PolElementSchema outsubPolElementSchema = insuCoreImpl
/* 402 */           .calcutePol(tempPolElementSchema);
/* 403 */         newPolData.add(outsubPolElementSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 408 */     String mainPolno = getTopPolNo(inPolElementSchema.getPolNo());
/* 409 */     dealWithExemptRisk(mainPolno);
/*     */ 
/* 411 */     List result = new ArrayList();
/*     */ 
/* 413 */     List polList = getPolList(inPolElementSchema.getPolNo(), 1);
/* 414 */     List noList = (List)polList.get(0);
/*     */ 
/* 416 */     List polschemaList = (List)polList.get(1);
/*     */ 
/* 420 */     LNPPolSet reset = new LNPPolSet();
/*     */ 
/* 423 */     boolean flag1 = (inPolElementSchema.getPayIntv() == 0) || (1000 == inPolElementSchema.getPayIntv());
/* 424 */     boolean flag = (inPolElementSchema.getMasterPolNo().equals(inPolElementSchema.getPolNo())) && (flag1);
/* 425 */     if (flag) {
/* 426 */       PubSubmit ps = new PubSubmit();
/* 427 */       MMap mmap = new MMap();
/*     */ 
/* 430 */       LNPPolDB db = new LNPPolDB();
/* 431 */       String sql = "select * from lnppol where masterpolno='" + inPolElementSchema.getMasterPolNo() + "' and masterpolno <>polno " + 
/* 432 */         "and riskcode not in (select code from lnpcode where codetype='SRiskPayIntv100');";
/* 433 */       LNPPolSet set = db.executeQuery(sql);
/*     */ 
/* 435 */       if ((set != null) && (set.size() > 0)) {
/* 436 */         for (int i = 1; i <= set.size(); i++) {
/* 437 */           if ((subriskcode != null) && (subriskcode.length() > 0) && (subriskcode.equals(set.get(i).getRiskCode()))) {
/*     */             continue;
/*     */           }
/* 440 */           mmap.put(set.get(i), "DELETE");
/* 441 */           reset.add(set.get(i));
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 446 */       VData vd = new VData();
/* 447 */       vd.add(mmap);
/*     */ 
/* 449 */       ps.submitData(vd, "");
/*     */     }
/*     */ 
/* 453 */     RiskCheckCenterImpl riskCheckCenterImpl = new RiskCheckCenterImpl();
/* 454 */     SugError tempSugError = riskCheckCenterImpl.checkForOnePol(inPolElementSchema.getPolNo(), tGlobalInput, "");
/*     */ 
/* 456 */     if (tempSugError.hasError())
/*     */     {
/* 461 */       PubSubmit ps = new PubSubmit();
/* 462 */       LNPPolDB poldb2 = new LNPPolDB();
/* 463 */       MMap mmap = new MMap();
/* 464 */       LNPPolSet deLNPPolSet = poldb2.executeQuery("select * from lnppol where polno in " + delSql);
/* 465 */       mmap.put(deLNPPolSet, "DELETE");
/* 466 */       VData vd = new VData();
/* 467 */       vd.add(mmap);
/* 468 */       boolean reflag = ps.submitData(vd, "");
/*     */ 
/* 473 */       LNPPolDBSet recoverLNPPolDBSet = new LNPPolDBSet();
/* 474 */       for (int f = 0; (polListBack != null) && (f < polListBack.size()); f++) {
/* 475 */         LNPPolSchema reLNPPolSchema = (LNPPolSchema)polListBack.get(f);
/*     */ 
/* 477 */         if ((reLNPPolSchema.getStandbyFlag3() != null) && (!reLNPPolSchema.getStandbyFlag3().equals("")) && 
/* 478 */           (!reLNPPolSchema.getRiskCode().equals("CIR(B)")) && 
/* 479 */           (!reLNPPolSchema.getRiskCode().equals("IAA")) && 
/* 480 */           (!reLNPPolSchema.getRiskCode().equals("PEN102")) && 
/* 481 */           (!reLNPPolSchema.getRiskCode().equals("PEN104")) && 
/* 482 */           (!reLNPPolSchema.getRiskCode().equals("ACI103")) && 
/* 483 */           (reLNPPolSchema.getStandbyFlag3() != inPolElementSchema.getStandbyFlag3())) {
/* 484 */           reLNPPolSchema.setStandbyFlag3(inPolElementSchema.getStandbyFlag3());
/*     */         }
/*     */ 
/* 487 */         recoverLNPPolDBSet.add(reLNPPolSchema);
/*     */       }
/*     */ 
/* 490 */       recoverLNPPolDBSet.insert();
/*     */     }
/*     */     else
/*     */     {
/* 495 */       afterupdateRisk(inPolElementSchema.getContNo());
/*     */     }
/*     */ 
/* 498 */     return tempSugError;
/*     */   }
/*     */ 
/*     */   public void psvUpdateRisk(PolElementSchema inPolElementSchema, List oldPolList, IGlobalInput tGlobalInput)
/*     */   {
/* 506 */     InsuCoreImpl insuCoreImpl = new InsuCoreImpl();
/* 507 */     RiskImpl riskImpl = new RiskImpl();
/*     */ 
/* 509 */     List inputpolschemaList = (List)oldPolList.get(1);
/*     */ 
/* 511 */     inPolElementSchema = initPolElementInfo(inPolElementSchema, 
/* 512 */       tGlobalInput);
/*     */ 
/* 514 */     String subGroupPolNo = "";
/* 515 */     String subriskcode = "";
/* 516 */     String mainpolno = "";
/* 517 */     for (int f = 0; (inputpolschemaList != null) && (
/* 518 */       f < inputpolschemaList.size()); )
/*     */     {
/* 519 */       LNPPolSchema reLNPPolSchema = (LNPPolSchema)inputpolschemaList.get(f);
/*     */ 
/* 521 */       if (f == 0) {
/* 522 */         PolElementSchema mainPolElementSchema = (PolElementSchema)inPolElementSchema
/* 523 */           .clone();
/* 524 */         mainPolElementSchema = getInfoFromPol(mainPolElementSchema, 
/* 525 */           reLNPPolSchema);
/* 526 */         mainpolno = mainPolElementSchema.getPolNo();
/* 527 */         PolElementSchema outPolElementSchema = insuCoreImpl
/* 528 */           .calcutePol(mainPolElementSchema);
/* 529 */         subriskcode = riskImpl.getSubRiskOfRiskGroup(
/* 530 */           mainPolElementSchema.getRiskCode(), tGlobalInput, 
/* 531 */           inPolElementSchema.getAppAge(), inPolElementSchema
/* 532 */           .getAppntAge());
/*     */ 
/* 535 */         if ((subriskcode != null) && (subriskcode.length() > 0)) {
/* 536 */           for (int s = 0; s < inputpolschemaList.size(); s++) {
/* 537 */             ressLNPPolSchema = 
/* 538 */               (LNPPolSchema)inputpolschemaList
/* 538 */               .get(s);
/*     */ 
/* 540 */             if (!ressLNPPolSchema.getMasterPolNo().equals(
/* 540 */               reLNPPolSchema.getPolNo()))
/*     */               continue;
/* 542 */             if (ressLNPPolSchema.getRiskCode().equals(
/* 542 */               subriskcode)) {
/* 543 */               subGroupPolNo = ressLNPPolSchema.getPolNo();
/* 544 */               break;
/*     */             }
/*     */           }
/*     */ 
/* 548 */           PolElementSchema subPolElementSchema = (PolElementSchema)mainPolElementSchema
/* 549 */             .clone();
/* 550 */           subPolElementSchema.setSubRiskFlag("S");
/* 551 */           subPolElementSchema.setRiskCode(subriskcode);
/* 552 */           subPolElementSchema.setMasterPolNo(outPolElementSchema
/* 553 */             .getPolNo());
/* 554 */           subPolElementSchema.setPolNo(subGroupPolNo);
/* 555 */           LNPPolSchema ressLNPPolSchema = insuCoreImpl
/* 556 */             .calcutePol(subPolElementSchema);
/*     */         }
/* 558 */       } else if (!subGroupPolNo.equals(reLNPPolSchema.getPolNo()))
/*     */       {
/* 562 */         PolElementSchema tempPolElementSchema = (PolElementSchema)inPolElementSchema
/* 563 */           .clone();
/* 564 */         tempPolElementSchema = getInfoFromPol(tempPolElementSchema, 
/* 565 */           reLNPPolSchema);
/*     */         String mainRiskCode;
/* 568 */         if (!tempPolElementSchema.getPolNo().equals(
/* 568 */           tempPolElementSchema.getMasterPolNo())) { mainRiskCode = getMainRiskCode(inputpolschemaList, 
/* 571 */             tempPolElementSchema.getMasterPolNo());
/* 572 */           String subRiskCode = tempPolElementSchema.getRiskCode();
/* 573 */           int appage = tempPolElementSchema.getAppAge();
/* 574 */           int appntage = tempPolElementSchema.getAppntAge();
/*     */ 
/* 576 */           if ((!riskImpl.checkRiskGroup(mainRiskCode, subRiskCode, 
/* 576 */             tGlobalInput, appage, appntage)) && 
/* 578 */             (!riskImpl
/* 577 */             .checkSubRisk(mainRiskCode, subRiskCode, 
/* 578 */             tGlobalInput, appage, appntage))); } else { mainRiskCode = insuCoreImpl
/* 584 */             .calcutePol(tempPolElementSchema);
/*     */         }
/*     */       }
/* 518 */       f++;
/*     */     }
/*     */ 
/* 589 */     String exemptsql = "select * from lnppol where polno=masterpolno and contNo='" + 
/* 590 */       inPolElementSchema.getContNo() + 
/* 591 */       "' and insuredid='" + 
/* 592 */       inPolElementSchema.getInsuredId() + "'";
/* 593 */     LNPPolDB teLNPPolDB = new LNPPolDB();
/* 594 */     LNPPolSet reLNPPolSet = teLNPPolDB.executeQuery(exemptsql);
/* 595 */     for (int i = 1; (reLNPPolSet != null) && (i <= reLNPPolSet.size()); i++)
/* 596 */       dealWithExemptRisk(reLNPPolSet.get(i).getPolNo());
/*     */   }
/*     */ 
/*     */   private String getMainRiskCode(List polList, String polno)
/*     */   {
/* 603 */     String reuslt = "";
/* 604 */     for (int i = 0; (polList != null) && (i < polList.size()); i++) {
/* 605 */       LNPPolSchema tempLNPpolSchema = (LNPPolSchema)polList.get(i);
/* 606 */       if (polno.equals(tempLNPpolSchema.getPolNo())) {
/* 607 */         reuslt = tempLNPpolSchema.getRiskCode();
/* 608 */         break;
/*     */       }
/*     */     }
/* 611 */     return reuslt;
/*     */   }
/*     */ 
/*     */   public List getPolList(String mainpolNo, int serialNo)
/*     */   {
/* 616 */     List list = new ArrayList();
/* 617 */     List polList = new ArrayList();
/* 618 */     List noList = new ArrayList();
/*     */ 
/* 620 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 621 */     reLNPPolDB.setPolNo(mainpolNo);
/* 622 */     reLNPPolDB.getInfo();
/* 623 */     polList.add(reLNPPolDB.getSchema());
/* 624 */     noList.add(serialNo);
/*     */ 
/* 626 */     LNPPolSet rweLNPPolSet = getSubPolInfo(mainpolNo);
/* 627 */     for (int i = 1; (rweLNPPolSet != null) && (i <= rweLNPPolSet.size()); i++) {
/* 628 */       LNPPolSchema tempLNPPolSchema = rweLNPPolSet.get(i);
/* 629 */       polList.add(tempLNPPolSchema);
/* 630 */       noList.add(serialNo + "." + i);
/*     */ 
/* 633 */       LNPPolSet subLNPPolSet = getSubPolInfo(tempLNPPolSchema.getPolNo());
/* 634 */       for (int j = 1; (subLNPPolSet != null) && (j <= subLNPPolSet.size()); j++) {
/* 635 */         LNPPolSchema tempsubLNPPolSchema = subLNPPolSet.get(i);
/* 636 */         polList.add(tempsubLNPPolSchema);
/* 637 */         noList.add(serialNo + "." + i + "." + j);
/*     */       }
/*     */     }
/* 640 */     list.add(noList);
/* 641 */     list.add(polList);
/*     */ 
/* 643 */     return list;
/*     */   }
/*     */ 
/*     */   private LNPPolSet getSubPolInfo(String mainpolno)
/*     */   {
/* 649 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 650 */     String sql = "select * from lNPpol where masterpolno<>polno and masterpolno='" + 
/* 651 */       mainpolno + "'  order by MakeDate , MakeTime ASC";
/* 652 */     LNPPolSet teLNPPolSet = reLNPPolDB.executeQuery(sql);
/* 653 */     return teLNPPolSet;
/*     */   }
/*     */ 
/*     */   public boolean checkRiskCanBeDeleted(String[] polNoArray, String inusuredNo, String contNo)
/*     */   {
/* 660 */     CodeQueryImpl codeQueryImpl = new CodeQueryImpl();
/*     */ 
/* 662 */     List polList = new ArrayList();
/* 663 */     for (int i = 0; i < polNoArray.length; i++) {
/* 664 */       polList.add(polNoArray[i]);
/*     */     }
/* 666 */     boolean flag = true;
/*     */ 
/* 668 */     String sql = "select * from lnppol where masterpolno<>polno and contNo='" + 
/* 669 */       contNo + "' and insuredid='" + inusuredNo + "'";
/* 670 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 671 */     LNPPolSet reLNPPolSet = reLNPPolDB.executeQuery(sql);
/* 672 */     for (int i = 1; (reLNPPolSet != null) && (i <= reLNPPolSet.size()); i++) {
/* 673 */       LNPPolSchema tempLNPPolSchema = reLNPPolSet.get(i);
/*     */ 
/* 676 */       if (polList.contains(tempLNPPolSchema.getPolNo())) {
/*     */         continue;
/*     */       }
/*     */       try
/*     */       {
/* 681 */         List list = codeQueryImpl
/* 682 */           .getInfoBySql("select * from lnpcode where codetype='RiskGroup' and codealias='" + 
/* 684 */           tempLNPPolSchema.getRiskCode() + "'");
/* 685 */         if ((list == null) || (list.size() <= 0));
/*     */       }
/*     */       catch (Exception e) {
/* 689 */         e.printStackTrace();
/*     */ 
/* 691 */         flag = false;
/* 692 */         break;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 697 */     return flag;
/*     */   }
/*     */ 
/*     */   public void deletRisk(String[] polNoArray, IGlobalInput tGlobalInput)
/*     */     throws Exception
/*     */   {
/* 708 */     String insuredno = "";
/* 709 */     String contNo = "";
/*     */ 
/* 712 */     Set delSet = new HashSet();
/* 713 */     for (int i = 0; (polNoArray != null) && (i < polNoArray.length); i++) {
/* 714 */       String polno = transportPolNo(polNoArray[i], tGlobalInput);
/* 715 */       delSet.add(polno);
/* 716 */       if (i == 0) {
/* 717 */         LNPPolSchema temp = getPolInfo(polno);
/* 718 */         insuredno = temp.getInsuredId();
/* 719 */         contNo = temp.getContNo();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 724 */     if (delSet.size() > 0) {
/* 725 */       String fixsql = " (''";
/* 726 */       Iterator iterator = delSet.iterator();
/* 727 */       while (iterator.hasNext()) {
/* 728 */         String tempStr = iterator.next().toString();
/* 729 */         fixsql = fixsql + ",'" + tempStr + "'";
/*     */       }
/* 731 */       fixsql = fixsql + ") ";
/* 732 */       String sql = "delete from lnppol where polno in " + fixsql + 
/* 733 */         " or masterpolno in " + fixsql;
/* 734 */       ExeSQL reExeSQL = new ExeSQL();
/* 735 */       reExeSQL.execUpdateSQL(sql);
/*     */     }
/*     */ 
/* 739 */     String exemptsql = "select * from lnppol where polno=masterpolno and contNo='" + 
/* 740 */       contNo + "' and insuredid='" + insuredno + "'";
/* 741 */     LNPPolDB teLNPPolDB = new LNPPolDB();
/* 742 */     LNPPolSet reLNPPolSet = teLNPPolDB.executeQuery(exemptsql);
/* 743 */     for (int i = 1; (reLNPPolSet != null) && (i <= reLNPPolSet.size()); i++)
/* 744 */       dealWithExemptRisk(reLNPPolSet.get(i).getPolNo());
/*     */   }
/*     */ 
/*     */   private boolean dealWithSpel_SPA(String contNo, String insuredno)
/*     */   {
/* 752 */     boolean flag = false;
/*     */     try {
/* 754 */       PubSubmit ps = new PubSubmit();
/* 755 */       MMap mmap = new MMap();
/* 756 */       String sql = "select * from lnppol where contNo='" + 
/* 757 */         contNo + "' and insuredid='" + insuredno + "' and riskcode in ('AMR203','AMR204')";
/* 758 */       LNPPolDB teLNPPolDB = new LNPPolDB();
/* 759 */       LNPPolSet reLNPPolSet = teLNPPolDB.executeQuery(sql);
/*     */ 
/* 761 */       sql = "select * from lnppol where contNo='" + 
/* 762 */         contNo + "' and insuredid='" + insuredno + "' and riskcode = 'SPA'";
/* 763 */       LNPPolSet reSPALNPPolSet = teLNPPolDB.executeQuery(sql);
/*     */ 
/* 765 */       if ((reLNPPolSet != null) && (reLNPPolSet.size() > 0) && (
/* 766 */         (reSPALNPPolSet == null) || (reSPALNPPolSet.size() <= 0)))
/*     */       {
/* 769 */         mmap.put(reLNPPolSet, "DELETE");
/*     */       }
/*     */ 
/* 774 */       VData vd = new VData();
/* 775 */       vd.add(mmap);
/*     */ 
/* 777 */       if (!ps.submitData(vd, ""))
/* 778 */         flag = false;
/*     */       else
/* 780 */         flag = true;
/*     */     }
/*     */     catch (RuntimeException e)
/*     */     {
/* 784 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 787 */     return flag;
/*     */   }
/*     */ 
/*     */   public String transportPolNo(String polNo, IGlobalInput tGlobalInput)
/*     */   {
/* 792 */     RiskImpl riskImpl = new RiskImpl();
/*     */ 
/* 794 */     String rs_polno = polNo;
/*     */ 
/* 796 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 797 */     reLNPPolDB.setPolNo(polNo);
/* 798 */     reLNPPolDB.getInfo();
/*     */ 
/* 800 */     LNPAppntDB reLNPAppntDB = new LNPAppntDB();
/* 801 */     reLNPAppntDB.setContNo(reLNPPolDB.getContNo());
/* 802 */     reLNPAppntDB.getInfo();
/*     */ 
/* 804 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/* 805 */     reLNPInsuredDB.setContNo(reLNPPolDB.getContNo());
/* 806 */     reLNPInsuredDB.setInsuredId(reLNPPolDB.getInsuredId());
/* 807 */     reLNPInsuredDB.getInfo();
/*     */ 
/* 809 */     int appntAge = reLNPAppntDB.getAppntAge();
/* 810 */     int insuredAge = reLNPInsuredDB.getAppAge();
/*     */ 
/* 812 */     if (!reLNPPolDB.getPolNo().equals(reLNPPolDB.getMasterPolNo()))
/*     */     {
/* 814 */       LNPPolDB mainLNPPolDB = new LNPPolDB();
/* 815 */       mainLNPPolDB.setPolNo(reLNPPolDB.getMasterPolNo());
/* 816 */       mainLNPPolDB.getInfo();
/* 817 */       boolean flag = riskImpl
/* 818 */         .checkRiskGroup(mainLNPPolDB.getRiskCode(), reLNPPolDB
/* 819 */         .getRiskCode(), tGlobalInput, insuredAge, appntAge);
/* 820 */       if (flag) {
/* 821 */         rs_polno = mainLNPPolDB.getPolNo();
/*     */       }
/*     */     }
/* 824 */     return rs_polno;
/*     */   }
/*     */ 
/*     */   public LNPPolSchema getPolInfo(String polNo)
/*     */   {
/* 829 */     if ((polNo == null) || (polNo.length() == 0)) {
/* 830 */       return null;
/*     */     }
/* 832 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 833 */     reLNPPolDB.setPolNo(polNo);
/* 834 */     if (reLNPPolDB.getInfo()) {
/* 835 */       return reLNPPolDB.getSchema();
/*     */     }
/* 837 */     return null;
/*     */   }
/*     */ 
/*     */   public void dealWithExemptRisk(String masterPolno)
/*     */   {
/* 844 */     RiskImpl riskImpl = new RiskImpl();
/*     */ 
/* 847 */     List list = getPolList(masterPolno, 1);
/* 848 */     List polList = (List)list.get(1);
/* 849 */     List exemptRiskPolList = new ArrayList();
/* 850 */     if ((polList != null) && (polList.size() > 0))
/*     */     {
/* 852 */       Set set = riskImpl.getExemptRisk();
/* 853 */       double totalAmnt = 0.0D;
/* 854 */       HashSet hashSet_Exception = new HashSet();
/* 855 */       hashSet_Exception.add("HIA");
/* 856 */       hashSet_Exception.add("HSA");
/* 857 */       hashSet_Exception.add("SBA");
/* 858 */       hashSet_Exception.add("RBA");
/* 859 */       for (int i = 0; i < polList.size(); i++) {
/* 860 */         LNPPolSchema tempLNPPolSchema = (LNPPolSchema)polList.get(i);
/* 861 */         String riskcode = tempLNPPolSchema.getRiskCode();
/* 862 */         if (set.contains(riskcode)) {
/* 863 */           exemptRiskPolList.add(tempLNPPolSchema); } else {
/* 864 */           if (hashSet_Exception.contains(riskcode))
/*     */           {
/*     */             continue;
/*     */           }
/* 868 */           totalAmnt += tempLNPPolSchema.getPrem();
/*     */         }
/*     */       }
/* 871 */       if (exemptRiskPolList.size() > 0)
/*     */       {
/* 873 */         for (int i = 0; i < exemptRiskPolList.size(); i++) {
/* 874 */           LNPPolSchema tempLNPPolSchema = 
/* 875 */             (LNPPolSchema)exemptRiskPolList
/* 875 */             .get(i);
/* 876 */           if (tempLNPPolSchema.getAmnt() != 0.0D) {
/* 877 */             double prem = totalAmnt * tempLNPPolSchema.getPrem() / 
/* 878 */               tempLNPPolSchema.getAmnt();
/* 879 */             tempLNPPolSchema.setPrem(prem);
/*     */           }
/*     */ 
/* 882 */           tempLNPPolSchema.setAmnt(totalAmnt);
/* 883 */           LNPPolDB reLNPPolDB = new LNPPolDB();
/* 884 */           reLNPPolDB.setSchema(tempLNPPolSchema);
/* 885 */           reLNPPolDB.update();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getTopPolNo(String polno) {
/* 892 */     LNPPolSchema MainPoltemp = getPolInfo(polno);
/* 893 */     if ((MainPoltemp == null) || 
/* 894 */       (MainPoltemp.getMasterPolNo().equals(MainPoltemp.getPolNo()))) {
/* 895 */       return polno;
/*     */     }
/* 897 */     return getTopPolNo(MainPoltemp.getMasterPolNo());
/*     */   }
/*     */ 
/*     */   public List getProfitDoc(String polNo, String type)
/*     */   {
/* 903 */     return null;
/*     */   }
/*     */ 
/*     */   public List getProfitTbl(String polNo, String type)
/*     */   {
/* 908 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.RiskPolImpl
 * JD-Core Version:    0.6.0
 */