/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.LNPPubFun;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class InterFaceCheck
/*     */ {
/*     */   private String message;
/*     */ 
/*     */   public String getMessage()
/*     */   {
/*  13 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message) {
/*  17 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public boolean checkUnderWritingPass(String contno) {
/*  21 */     System.out.println("\uFFFD\u02F1\uFFFD\u01F0\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD--Start");
/*  22 */     this.message = null;
/*  23 */     boolean flag = false;
/*     */     try {
/*  25 */       StateOperatorDeal stateOperator = new StateOperatorDeal();
/*  26 */       PolicyMainInfo maininfo = new PolicyMainInfo();
/*  27 */       LNPContSchema lnpcont = maininfo.getContByContNo(contno);
/*     */ 
/*  29 */       flag = stateOperator.checkUnderWriteOperate(lnpcont.getState(), lnpcont.getEditstate());
/*  30 */       if (!flag) {
/*  31 */         this.message = "\uFFFD\uFFFD\u01F0\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u073D\uFFFD\uFFFD\u043A\u02F1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD";
/*     */ 
/*  33 */         System.out.println("\uFFFD\uFFFD\u01F0\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u073D\uFFFD\uFFFD\u043A\u02F1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD");
/*  34 */         return false;
/*     */       }
/*     */ 
/*  45 */       ExeSQL tExeSql1 = new ExeSQL();
/*     */ 
/*  47 */       boolean underWriteFlag = false;
/*  48 */       if ("04".equals(lnpcont.getState())) {
/*  49 */         underWriteFlag = true;
/*     */       }
/*     */ 
/*  67 */       if (!underWriteFlag) {
/*  68 */         String errorMsg1 = checkCustImpartDone(contno);
/*  69 */         if (errorMsg1 != null)
/*     */         {
/*  71 */           this.message = errorMsg1;
/*  72 */           return false;
/*     */         }
/*  74 */       } else if (underWriteFlag) {
/*  75 */         String errorMsg1 = checkCustImpartReDone(contno);
/*  76 */         if (errorMsg1 != null) {
/*  77 */           this.message = errorMsg1;
/*  78 */           return false;
/*     */         }
/*     */       } else {
/*  81 */         this.message = "\uFFFD\u02F1\uFFFD\uFFFD\uFFFD\uFFFD\u02A7\uFFFD\u0723\uFFFD";
/*  82 */         return false;
/*     */       }
/*     */ 
/*  86 */       flag = checkAgentExist(contno);
/*  87 */       if (!flag) {
/*  88 */         this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04BB\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02E3\uFFFD";
/*  89 */         return false;
/*     */       }
/*     */ 
/*  93 */       String errorMsg2 = checkSpelDone(contno);
/*  94 */       if (errorMsg2 != null) {
/*  95 */         this.message = errorMsg2;
/*  96 */         return false;
/*     */       }
/*     */     }
/*     */     catch (RuntimeException e)
/*     */     {
/* 101 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 104 */     return flag;
/*     */   }
/*     */ 
/*     */   private boolean checkOccupation(String contNo)
/*     */   {
/* 110 */     String sql = "select * from lnppol a ,lnpinsured b where  a.riskcode in ('PJU','MWL101','MWL102','AHI101','AHI102') and a.contno='" + 
/* 112 */       contNo + "' and a.contno = b.contno " + 
/* 113 */       "and '7' = (select parate from lnpoccupation where occupationcode= b.occupationcode )" + 
/* 114 */       "union " + 
/* 115 */       "select * from lnppol a ,lnpinsured b where " + 
/* 116 */       " a.riskcode in ('AHI101') " + 
/* 117 */       "and a.contno='" + contNo + "' and a.contno = b.contno " + 
/* 118 */       "and ('5' = (select parate from lnpoccupation where occupationcode= b.occupationcode ) " + 
/* 119 */       "or '6'=(select parate from lnpoccupation where occupationcode= b.occupationcode ))";
/*     */ 
/* 121 */     ExeSQL reExeSQL = new ExeSQL();
/* 122 */     SSRS tSSRS = reExeSQL.execSQL(sql);
/*     */ 
/* 124 */     return (tSSRS == null) || (tSSRS.getMaxRow() <= 0);
/*     */   }
/*     */ 
/*     */   private String checkCustImpartDone(String contno)
/*     */   {
/* 131 */     String errorMsg = "";
/* 132 */     String reError = null;
/*     */ 
/* 134 */     PolicyMainInfo tPolicyMainInfo = new PolicyMainInfo();
/* 135 */     LNPContSchema contSch = tPolicyMainInfo.getContByContNo(contno);
/*     */ 
/* 139 */     String checksqlexist = "select distinct impartid from lnpcustimpresult where contno='" + contno + "'";
/*     */ 
/* 142 */     String checksqlnotexsit = "select top 1 imp.impartid from lnppol pol,lnpriskconfig cfg,lnpcustimpart imp where pol.masterpolno = pol.polno and cfg.riskcode = pol.riskcode and pol.contno='" + 
/* 144 */       contno + "' " + 
/* 145 */       "and cfg.imparttype = imp.proposaltype order by imp.impartver desc ";
/*     */ 
/* 149 */     ExeSQL reExeSQL = new ExeSQL();
/* 150 */     SSRS tSSRSexist = reExeSQL.execSQL(checksqlexist);
/* 151 */     SSRS tSSRSnotexsit = reExeSQL.execSQL(checksqlnotexsit);
/* 152 */     String impartId = "";
/* 153 */     if ((tSSRSexist != null) && (tSSRSexist.GetText(1, 1) != null))
/* 154 */       impartId = tSSRSexist.GetText(1, 1);
/* 155 */     else if ((tSSRSnotexsit != null) && (tSSRSnotexsit.GetText(1, 1) != null)) {
/* 156 */       impartId = tSSRSnotexsit.GetText(1, 1);
/*     */     }
/*     */ 
/* 159 */     if ((impartId != null) && (!"".equals(impartId.trim())))
/*     */     {
/* 161 */       String queSQL = "select distinct substring(questionid,5,2) from lnpcustimpque where impartid='" + impartId + "' and " + 
/* 162 */         "checkflag='0' " + 
/* 163 */         "and  (p1<>'1' or p1 is null or p1='') " + 
/* 164 */         "and questiontype<>'0' " + 
/* 165 */         "and questionid not in(select questionid from lnpcustimpresult where contno='" + contno + "')" + 
/* 167 */         "union " + 
/* 168 */         "select distinct substring(questionid,5,2) from  " + 
/* 169 */         "(select questionid,errormsg from lnpcustimpque where (p1<>'1' or p1 is null or p1='') and outqueid in " + 
/* 170 */         "(select questionid from lnpcustimpresult" + 
/* 171 */         " where contno='" + contno + "' and " + 
/* 172 */         "optionid ='1' and " + 
/* 173 */         "questionid in " + 
/* 174 */         "(select distinct outqueid from lnpcustimpque where impartid='" + impartId + "' and checkflag='1' " + 
/* 175 */         "and checkvalue='1' " + 
/* 176 */         "and p1<>'1'" + 
/* 177 */         "and questiontype<>'0'))) c where   questionid not in" + 
/* 178 */         "(select questionid from lnpcustimpresult where contno='" + contno + "')" + 
/* 180 */         ";";
/* 181 */       System.out.println("\uFFFD\uFFFD\u9E6B\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFDsql--" + queSQL);
/*     */ 
/* 185 */       SSRS tSSRS2 = reExeSQL.execSQL(queSQL);
/*     */ 
/* 187 */       if ((tSSRS2 != null) && (tSSRS2.MaxRow > 0))
/*     */       {
/* 194 */         if ((("0101".equals(impartId)) || ("0102".equals(impartId)) || ("0301".equals(impartId))) && (tSSRS2.MaxRow == 1) && ("05".equals(tSSRS2.GetText(1, 1)))) {
/* 195 */           queSQL = "select * from lnpcustimpresult where impartid='" + impartId + "' and contno='" + contno + "' and questionid='" + impartId + "050000' and optionid in ('1','2')";
/* 196 */           SSRS tSSRS3 = reExeSQL.execSQL(queSQL);
/* 197 */           if ((tSSRS3 == null) || (tSSRS3.MaxRow == 0))
/* 198 */             errorMsg = "\uFFFD\uFFFD\uFFFD\uFFFD5";
/*     */         }
/*     */         else
/*     */         {
/* 202 */           for (int i = 1; i <= tSSRS2.MaxRow; i++) {
/* 203 */             if (("05".equals(tSSRS2.GetText(i, 1))) && (
/* 204 */               ("0101".equals(impartId)) || ("0102".equals(impartId)) || ("0301".equals(impartId)))) {
/* 205 */               queSQL = "select * from lnpcustimpresult where impartid='" + impartId + "' and contno='" + contno + "' and questionid='" + impartId + "050000' and optionid in ('1','2')";
/* 206 */               SSRS tSSRS3 = reExeSQL.execSQL(queSQL);
/* 207 */               if ((tSSRS3 == null) || (tSSRS3.MaxRow == 0)) {
/* 208 */                 errorMsg = errorMsg + ",\uFFFD\uFFFD\uFFFD\uFFFD5";
/*     */               }
/*     */ 
/*     */             }
/* 213 */             else if (("0301".equals(impartId)) && (("13".equals(tSSRS2.GetText(i, 1))) || ("14".equals(tSSRS2.GetText(i, 1))))) {
/* 214 */               if ("13".equals(tSSRS2.GetText(i, 1)))
/* 215 */                 errorMsg = errorMsg + ",\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD1";
/* 216 */               else if ("14".equals(tSSRS2.GetText(i, 1)))
/* 217 */                 errorMsg = errorMsg + ",\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD2";
/*     */             }
/*     */             else {
/* 220 */               errorMsg = errorMsg + ",\uFFFD\uFFFD\uFFFD\uFFFD" + Integer.parseInt(tSSRS2.GetText(i, 1));
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/* 225 */           errorMsg = errorMsg + ",";
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 230 */       if ("0101".equals(impartId)) {
/* 231 */         String sql1 = "select * from lnpcustimpresult where impartid = '0101' and questionid='0101050000' and optionid='1' and contno = '" + 
/* 232 */           contno + "';";
/*     */ 
/* 234 */         SSRS tSSRS1 = reExeSQL.execSQL(sql1);
/* 235 */         if ((tSSRS1 != null) && (tSSRS1.MaxRow > 0))
/*     */         {
/* 237 */           String sql2 = "select questionid,optionid from lnpcustimpresult where questionid in ('0101050101','0101050102','0101050210','0101050220','0101050230') and impartid = '0101'  and contno = '" + 
/* 239 */             contno + "';";
/* 240 */           SSRS trSSRS2 = reExeSQL.execSQL(sql2);
/* 241 */           boolean flag = true;
/* 242 */           if ((trSSRS2 != null) && (trSSRS2.MaxRow > 0))
/*     */           {
/* 246 */             String sql31 = "select * from lnpcustimpresult where questionid = '0101050210' and ((select count(*) from lnpcustimpresult where questionid in ('0101050211','0101050212') and contno = '" + 
/* 248 */               contno + "')=0 and optionid='1') " + 
/* 249 */               "and impartid = '0101'  and contno = '" + contno + "';";
/* 250 */             SSRS trSSRS31 = reExeSQL.execSQL(sql31);
/* 251 */             if ((trSSRS31 != null) && (trSSRS31.MaxRow > 0))
/*     */             {
/* 253 */               flag = false;
/*     */             }
/*     */ 
/* 256 */             if (flag)
/*     */             {
/* 258 */               String sql32 = "select * from lnpcustimpresult where questionid = '0101050220' and (select count(*) from lnpcustimpresult where questionid in ('0101050221','0101050222') and contno = '" + 
/* 260 */                 contno + "')=0 and optionid='1'" + 
/* 261 */                 "and impartid = '0101'  and contno = '" + contno + "';";
/* 262 */               SSRS trSSRS32 = reExeSQL.execSQL(sql32);
/* 263 */               if ((trSSRS32 != null) && (trSSRS32.MaxRow > 0))
/*     */               {
/* 265 */                 flag = false;
/*     */               }
/*     */ 
/*     */             }
/*     */ 
/* 270 */             String sql33 = "select * from lnpcustimpresult where questionid = '0101050230' and (select count(*) from lnpcustimpresult where questionid in ('0101050231','0101050232') and contno = '" + 
/* 272 */               contno + "')=0 and optionid='1'" + 
/* 273 */               "and impartid = '0101'  and contno = '" + contno + "';";
/* 274 */             SSRS trSSRS33 = reExeSQL.execSQL(sql33);
/* 275 */             if ((trSSRS33 != null) && (trSSRS33.MaxRow > 0))
/*     */             {
/* 277 */               flag = false;
/*     */             }
/* 279 */             if (!flag) {
/* 280 */               errorMsg = errorMsg + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD,";
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 285 */             errorMsg = errorMsg + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD,";
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 291 */       if ("0102".equals(impartId)) {
/* 292 */         String sql1 = "select * from lnpcustimpresult where impartid = '0102' and questionid='0102050000' and optionid='1' and contno = '" + 
/* 293 */           contno + "';";
/*     */ 
/* 295 */         SSRS tSSRS1 = reExeSQL.execSQL(sql1);
/* 296 */         if ((tSSRS1 != null) && (tSSRS1.MaxRow > 0))
/*     */         {
/* 298 */           String sql2 = "select questionid,optionid from lnpcustimpresult where questionid in ('0102050101','0102050102','0102050210','0102050220','0102050230') and impartid = '0102'  and contno = '" + 
/* 300 */             contno + "';";
/* 301 */           SSRS trSSRS2 = reExeSQL.execSQL(sql2);
/* 302 */           boolean flag = true;
/* 303 */           if ((trSSRS2 != null) && (trSSRS2.MaxRow > 0))
/*     */           {
/* 307 */             String sql31 = "select * from lnpcustimpresult where questionid = '0102050210' and ((select count(*) from lnpcustimpresult where questionid in ('0102050211','0102050212') and contno = '" + 
/* 309 */               contno + "')=0 and optionid='1') " + 
/* 310 */               "and impartid = '0102'  and contno = '" + contno + "';";
/* 311 */             SSRS trSSRS31 = reExeSQL.execSQL(sql31);
/* 312 */             if ((trSSRS31 != null) && (trSSRS31.MaxRow > 0))
/*     */             {
/* 314 */               flag = false;
/*     */             }
/*     */ 
/* 317 */             if (flag)
/*     */             {
/* 319 */               String sql32 = "select * from lnpcustimpresult where questionid = '0102050220' and (select count(*) from lnpcustimpresult where questionid in ('0102050221','0102050222') and contno = '" + 
/* 321 */                 contno + "')=0 and optionid='1'" + 
/* 322 */                 "and impartid = '0102'  and contno = '" + contno + "';";
/* 323 */               SSRS trSSRS32 = reExeSQL.execSQL(sql32);
/* 324 */               if ((trSSRS32 != null) && (trSSRS32.MaxRow > 0))
/*     */               {
/* 326 */                 flag = false;
/*     */               }
/*     */ 
/*     */             }
/*     */ 
/* 331 */             String sql33 = "select * from lnpcustimpresult where questionid = '0102050230' and (select count(*) from lnpcustimpresult where questionid in ('0102050231','0102050232') and contno = '" + 
/* 333 */               contno + "')=0 and optionid='1'" + 
/* 334 */               "and impartid = '0102'  and contno = '" + contno + "';";
/* 335 */             SSRS trSSRS33 = reExeSQL.execSQL(sql33);
/* 336 */             if ((trSSRS33 != null) && (trSSRS33.MaxRow > 0))
/*     */             {
/* 338 */               flag = false;
/*     */             }
/* 340 */             if (!flag) {
/* 341 */               errorMsg = errorMsg + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD,";
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 346 */             errorMsg = errorMsg + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD,";
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 353 */       if ("0301".equals(impartId)) {
/* 354 */         String sql0301 = "select * from lnpcustimpresult where impartid = '0301' and questionid='0301050000' and optionid='1' and contno = '" + 
/* 355 */           contno + "';";
/*     */ 
/* 357 */         SSRS tSSRS0301 = reExeSQL.execSQL(sql0301);
/* 358 */         if ((tSSRS0301 != null) && (tSSRS0301.MaxRow > 0))
/*     */         {
/* 360 */           String sql03012 = "select * from lnpcustimpresult where questionid in ('0301050101','0301050102','0301050210','0301050220','0301050230') and impartid = '0301'  and contno = '" + 
/* 362 */             contno + "';";
/* 363 */           SSRS trSSRS03012 = reExeSQL.execSQL(sql03012);
/* 364 */           boolean flag = true;
/* 365 */           if ((trSSRS03012 != null) && (trSSRS03012.MaxRow > 0))
/*     */           {
/* 368 */             String sql31 = "select * from lnpcustimpresult where questionid = '0301050210' and (select count(*) from lnpcustimpresult where questionid in ('0301050211','0301050212') and contno = '" + 
/* 370 */               contno + "')=0 and optionid='1'" + 
/* 371 */               "and impartid = '0301'  and contno = '" + contno + "';";
/* 372 */             SSRS trSSRS31 = reExeSQL.execSQL(sql31);
/* 373 */             if ((trSSRS31 != null) && (trSSRS31.MaxRow > 0))
/*     */             {
/* 375 */               flag = false;
/*     */             }
/*     */ 
/* 378 */             if (flag)
/*     */             {
/* 380 */               String sql32 = "select * from lnpcustimpresult where questionid = '0301050220' and (select count(*) from lnpcustimpresult where questionid in ('0301050221','0301050222') and contno = '" + 
/* 382 */                 contno + "')=0 and optionid='1'" + 
/* 383 */                 "and impartid = '0301'  and contno = '" + contno + "';";
/* 384 */               SSRS trSSRS32 = reExeSQL.execSQL(sql32);
/* 385 */               if ((trSSRS32 != null) && (trSSRS32.MaxRow > 0))
/*     */               {
/* 387 */                 flag = false;
/*     */               }
/*     */             }
/*     */ 
/* 391 */             if (flag)
/*     */             {
/* 393 */               String sql33 = "select * from lnpcustimpresult where questionid = '0301050230' and (select count(*) from lnpcustimpresult where questionid in ('0301050231','0301050232') and contno = '" + 
/* 395 */                 contno + "')=0 and optionid='1'" + 
/* 396 */                 "and impartid = '0301'  and contno = '" + contno + "';";
/* 397 */               SSRS trSSRS33 = reExeSQL.execSQL(sql33);
/* 398 */               if ((trSSRS33 != null) && (trSSRS33.MaxRow > 0))
/*     */               {
/* 400 */                 flag = false;
/*     */               }
/*     */             }
/* 403 */             if (!flag)
/* 404 */               errorMsg = errorMsg + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD,";
/*     */           }
/*     */           else {
/* 407 */             errorMsg = errorMsg + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD,";
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 413 */       String squeSQL = "select distinct substring(questionid,5,2),checkvalue,errormsg from lnpcustimpque where impartid='" + 
/* 414 */         impartId + "' and checkflag='1' and checkvalue<>'1'  and questiontype not in('0')" + 
/* 415 */         " and ((outqueid is null or (outqueid is not null and '1'=(select optionid from lnpcustimpresult " + 
/* 416 */         "where questionid=outqueid and contno='" + contno + "')))" + 
/* 417 */         " and questionid not in(select questionid from lnpcustimpresult where contno='" + contno + "'));";
/* 418 */       System.out.println("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFDsql--" + squeSQL);
/* 419 */       SSRS tSSRS3 = reExeSQL.execSQL(squeSQL);
/* 420 */       if ((tSSRS3 != null) && (tSSRS3.MaxRow > 0))
/*     */       {
/* 423 */         String spelImpartType = "";
/* 424 */         String age = LNPPubFun.getAgeByBirthdayNew(contSch.getInsuredBirthday(), contSch.getPValiDate());
/*     */         int ageInt;
/*     */         int ageInt;
/* 427 */         if (age.indexOf("\uFFFD\uFFFD") != -1)
/* 428 */           ageInt = 0;
/*     */         else {
/* 430 */           ageInt = Integer.parseInt(age.substring(0, age.indexOf("\uFFFD\uFFFD")));
/*     */         }
/* 432 */         if (!"0101".equals(impartId)) {
/* 433 */           if ((contSch.getInsuredSex().equals("1")) && (ageInt >= 18)) {
/* 434 */             spelImpartType = "female";
/* 435 */             for (int i = 1; i <= tSSRS3.MaxRow; i++)
/*     */             {
/* 437 */               if (tSSRS3.GetText(i, 2).equals(spelImpartType)) {
/* 438 */                 errorMsg = errorMsg + tSSRS3.GetText(i, 3) + ",";
/* 439 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/* 444 */           if (contSch.getInsuredSex().equals("0")) {
/* 445 */             spelImpartType = "male";
/* 446 */             for (int i = 1; i <= tSSRS3.MaxRow; i++)
/*     */             {
/* 448 */               if (tSSRS3.GetText(i, 2).equals(spelImpartType)) {
/* 449 */                 errorMsg = errorMsg + tSSRS3.GetText(i, 3) + ",";
/* 450 */                 break;
/*     */               }
/*     */             }
/*     */           }
/* 454 */           if (ageInt <= 2) {
/* 455 */             spelImpartType = "child";
/* 456 */             for (int i = 1; i <= tSSRS3.MaxRow; i++)
/*     */             {
/* 458 */               if (tSSRS3.GetText(i, 2).equals(spelImpartType)) {
/* 459 */                 errorMsg = errorMsg + tSSRS3.GetText(i, 3) + ",";
/* 460 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */         } else {
/* 465 */           if (ageInt > 2) {
/* 466 */             if ((contSch.getInsuredSex().equals("1")) && (ageInt >= 18)) {
/* 467 */               spelImpartType = "female";
/*     */             }
/*     */ 
/* 470 */             if (contSch.getInsuredSex().equals("0"))
/* 471 */               spelImpartType = "male";
/*     */           }
/*     */           else {
/* 474 */             spelImpartType = "child";
/*     */           }
/*     */ 
/* 477 */           for (int i = 1; i <= tSSRS3.MaxRow; i++)
/*     */           {
/* 479 */             if (tSSRS3.GetText(i, 2).equals(spelImpartType)) {
/* 480 */               errorMsg = errorMsg + tSSRS3.GetText(i, 3) + ",";
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 488 */     if (!errorMsg.equals("")) {
/* 489 */       reError = "\uFFFD\uFFFD\uFFFD\u05AA:" + errorMsg + "\u03B4\uFFFD\uFFFD\u0434\uFFFD\uFFFD\uFFFD\uFFFD,\uFFFD\uFFFD\uFFFD\uFFFD\u0434";
/* 490 */       reError = reError.replaceAll(":,", ":");
/* 491 */       reError = reError.replaceAll(",,", ",");
/*     */     }
/*     */ 
/* 494 */     System.out.println("\uFFFD\uFFFD\u04BB\uFFFD\u03BA\u02F1\uFFFD\u0423\uFFFD\u98FA" + reError);
/*     */ 
/* 496 */     return reError;
/*     */   }
/*     */ 
/*     */   private String checkCustImpartReDone(String contno) {
/* 500 */     String errorMsg = "";
/* 501 */     String reError = null;
/*     */ 
/* 503 */     PolicyMainInfo tPolicyMainInfo = new PolicyMainInfo();
/* 504 */     LNPContSchema contSch = tPolicyMainInfo.getContByContNo(contno);
/*     */ 
/* 507 */     String checksql = "select impartid,max(impartver) from lnpcustimpart where impartid like (select imparttype from lnpriskconfig  where riskcode =(select riskcode from lnppol where contno='" + 
/* 509 */       contno + "' and  polno = masterpolno))+'%' " + 
/* 510 */       "group by impartid;";
/*     */ 
/* 514 */     ExeSQL reExeSQL = new ExeSQL();
/* 515 */     SSRS tSSRS = reExeSQL.execSQL(checksql);
/* 516 */     if ((tSSRS != null) && (tSSRS.GetText(1, 1) != null)) {
/* 517 */       String impartId = tSSRS.GetText(1, 1);
/*     */ 
/* 519 */       String queSQL = "select distinct substring(questionid,5,2) from lnpcustimpque where questiontype='2' and impartid='" + impartId + "' and " + 
/* 520 */         "checkflag='0' " + 
/* 521 */         "and  (p1<>'1' or p1 is null or p1='') " + 
/* 522 */         "and questiontype<>'0' " + 
/* 523 */         "and questionid not in(select questionid from lnpcustimpresult where contno='" + contno + "')" + 
/* 525 */         "union " + 
/* 526 */         "select distinct substring(questionid,5,2) from  " + 
/* 527 */         "(select questionid,errormsg from lnpcustimpque where questiontype='2' and (p1<>'1' or p1 is null or p1='') and outqueid in " + 
/* 528 */         "(select questionid from lnpcustimpresult" + 
/* 529 */         " where contno='" + contno + "' and " + 
/* 530 */         "optionid ='1' and " + 
/* 531 */         "questionid in " + 
/* 532 */         "(select distinct outqueid from lnpcustimpque where impartid='" + impartId + "' and checkflag='1' " + 
/* 533 */         "and checkvalue='1' " + 
/* 534 */         "and p1<>'1'" + 
/* 535 */         "and questiontype<>'0'))) c where   questionid not in" + 
/* 536 */         "(select questionid from lnpcustimpresult where contno='" + contno + "')" + 
/* 538 */         ";";
/* 539 */       System.out.println("\uFFFD\uFFFD\u9E6B\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFDsql--" + queSQL);
/*     */ 
/* 543 */       SSRS tSSRS2 = reExeSQL.execSQL(queSQL);
/*     */ 
/* 545 */       if ((tSSRS2 != null) && (tSSRS2.MaxRow > 0))
/*     */       {
/* 552 */         if (((!"0101".equals(impartId)) && (!"0301".equals(impartId))) || (tSSRS2.MaxRow != 1) || (!"05".equals(tSSRS2.GetText(1, 1))))
/*     */         {
/* 555 */           for (int i = 1; i <= tSSRS2.MaxRow; i++) {
/* 556 */             if (("05".equals(tSSRS2.GetText(i, 1))) && (
/* 557 */               ("0101".equals(impartId)) || ("0301".equals(impartId))))
/*     */             {
/*     */               continue;
/*     */             }
/* 561 */             if (("0301".equals(impartId)) && (("13".equals(tSSRS2.GetText(i, 1))) || ("14".equals(tSSRS2.GetText(i, 1))))) {
/* 562 */               if ("13".equals(tSSRS2.GetText(i, 1)))
/* 563 */                 errorMsg = errorMsg + ",\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD1";
/* 564 */               else if ("14".equals(tSSRS2.GetText(i, 1)))
/* 565 */                 errorMsg = errorMsg + ",\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD2";
/*     */             }
/*     */             else {
/* 568 */               errorMsg = errorMsg + ",\uFFFD\uFFFD\uFFFD\uFFFD" + Integer.parseInt(tSSRS2.GetText(i, 1));
/*     */             }
/*     */           }
/*     */ 
/* 572 */           errorMsg = errorMsg + ",";
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 577 */       if ("0101".equals(impartId)) {
/* 578 */         String sql1 = "select * from lnpcustimpresult where impartid = '0101' and questionid='0101050000' and optionid='1' and contno = '" + 
/* 579 */           contno + "';";
/*     */ 
/* 581 */         SSRS tSSRS1 = reExeSQL.execSQL(sql1);
/* 582 */         if ((tSSRS1 != null) && (tSSRS1.MaxRow > 0))
/*     */         {
/* 584 */           String sql2 = "select questionid,optionid from lnpcustimpresult where  questionid in ('0101050101','0101050102','0101050210','0101050220','0101050230') and impartid = '0101'  and contno = '" + 
/* 586 */             contno + "';";
/* 587 */           SSRS trSSRS2 = reExeSQL.execSQL(sql2);
/* 588 */           boolean flag = true;
/* 589 */           if ((trSSRS2 != null) && (trSSRS2.MaxRow > 0))
/*     */           {
/* 593 */             String sql31 = "select * from lnpcustimpresult where questionid = '0101050210' and ((select count(*) from lnpcustimpresult where questionid in ('0101050211','0101050212') and contno = '" + 
/* 595 */               contno + "')=0 and optionid='1') " + 
/* 596 */               "and impartid = '0101'  and contno = '" + contno + "';";
/* 597 */             SSRS trSSRS31 = reExeSQL.execSQL(sql31);
/* 598 */             if ((trSSRS31 != null) && (trSSRS31.MaxRow > 0))
/*     */             {
/* 600 */               flag = false;
/*     */             }
/*     */ 
/* 603 */             if (flag)
/*     */             {
/* 605 */               String sql32 = "select * from lnpcustimpresult where questionid = '0101050220' and (select count(*) from lnpcustimpresult where questionid in ('0101050221','0101050222') and contno = '" + 
/* 607 */                 contno + "')=0 and optionid='1'" + 
/* 608 */                 "and impartid = '0101'  and contno = '" + contno + "';";
/* 609 */               SSRS trSSRS32 = reExeSQL.execSQL(sql32);
/* 610 */               if ((trSSRS32 != null) && (trSSRS32.MaxRow > 0))
/*     */               {
/* 612 */                 flag = false;
/*     */               }
/*     */ 
/*     */             }
/*     */ 
/* 617 */             String sql33 = "select * from lnpcustimpresult where questionid = '0101050230' and (select count(*) from lnpcustimpresult where questionid in ('0101050231','0101050232') and contno = '" + 
/* 619 */               contno + "')=0 and optionid='1'" + 
/* 620 */               "and impartid = '0101'  and contno = '" + contno + "';";
/* 621 */             SSRS trSSRS33 = reExeSQL.execSQL(sql33);
/* 622 */             if ((trSSRS33 != null) && (trSSRS33.MaxRow > 0))
/*     */             {
/* 624 */               flag = false;
/*     */             }
/* 626 */             if (!flag) {
/* 627 */               errorMsg = errorMsg + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD,";
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 632 */             errorMsg = errorMsg + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD,";
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 639 */       if ("0301".equals(impartId)) {
/* 640 */         String sql0301 = "select * from lnpcustimpresult where impartid = '0301' and questionid='0301050000' and optionid='1' and contno = '" + 
/* 641 */           contno + "';";
/*     */ 
/* 643 */         SSRS tSSRS0301 = reExeSQL.execSQL(sql0301);
/* 644 */         if ((tSSRS0301 != null) && (tSSRS0301.MaxRow > 0))
/*     */         {
/* 646 */           String sql03012 = "select * from lnpcustimpresult where questionid in ('0301050101','0301050102','0301050210','0301050220','0301050230') and impartid = '0301'  and contno = '" + 
/* 648 */             contno + "';";
/* 649 */           SSRS trSSRS03012 = reExeSQL.execSQL(sql03012);
/* 650 */           boolean flag = true;
/* 651 */           if ((trSSRS03012 != null) && (trSSRS03012.MaxRow > 0))
/*     */           {
/* 654 */             String sql31 = "select * from lnpcustimpresult where questionid = '0301050210' and (select count(*) from lnpcustimpresult where questionid in ('0301050211','0301050212') and contno = '" + 
/* 656 */               contno + "')=0 and optionid='1'" + 
/* 657 */               "and impartid = '0301'  and contno = '" + contno + "';";
/* 658 */             SSRS trSSRS31 = reExeSQL.execSQL(sql31);
/* 659 */             if ((trSSRS31 != null) && (trSSRS31.MaxRow > 0))
/*     */             {
/* 661 */               flag = false;
/*     */             }
/*     */ 
/* 664 */             if (flag)
/*     */             {
/* 666 */               String sql32 = "select * from lnpcustimpresult where questionid = '0301050220' and (select count(*) from lnpcustimpresult where questionid in ('0301050221','0301050222') and contno = '" + 
/* 668 */                 contno + "')=0 and optionid='1'" + 
/* 669 */                 "and impartid = '0301'  and contno = '" + contno + "';";
/* 670 */               SSRS trSSRS32 = reExeSQL.execSQL(sql32);
/* 671 */               if ((trSSRS32 != null) && (trSSRS32.MaxRow > 0))
/*     */               {
/* 673 */                 flag = false;
/*     */               }
/*     */             }
/*     */ 
/* 677 */             if (flag)
/*     */             {
/* 679 */               String sql33 = "select * from lnpcustimpresult where questionid = '0301050230' and (select count(*) from lnpcustimpresult where questionid in ('0301050231','0301050232') and contno = '" + 
/* 681 */                 contno + "')=0 and optionid='1'" + 
/* 682 */                 "and impartid = '0301'  and contno = '" + contno + "';";
/* 683 */               SSRS trSSRS33 = reExeSQL.execSQL(sql33);
/* 684 */               if ((trSSRS33 != null) && (trSSRS33.MaxRow > 0))
/*     */               {
/* 686 */                 flag = false;
/*     */               }
/*     */             }
/* 689 */             if (!flag)
/* 690 */               errorMsg = errorMsg + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD,";
/*     */           }
/*     */           else
/*     */           {
/* 694 */             errorMsg = errorMsg + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD,";
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 700 */       String squeSQL = "select distinct substring(questionid,5,2),checkvalue,errormsg from lnpcustimpque where questiontype='2' and impartid='" + 
/* 701 */         impartId + "' and checkflag='1' and checkvalue<>'1'  and questiontype not in('1','0')" + 
/* 702 */         " and (outqueid is null or (outqueid is not null and '1'=(select optionid from lnpcustimpresult " + 
/* 703 */         "where questionid=outqueid and contno='" + contno + "')))" + 
/* 704 */         " and questionid not in(select questionid from lnpcustimpresult where contno='" + contno + "');";
/* 705 */       System.out.println("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFDsql--" + squeSQL);
/* 706 */       SSRS tSSRS3 = reExeSQL.execSQL(squeSQL);
/* 707 */       if ((tSSRS3 != null) && (tSSRS3.MaxRow > 0))
/*     */       {
/* 710 */         String spelImpartType = "";
/* 711 */         String age = LNPPubFun.getAgeByBirthdayNew(contSch.getInsuredBirthday(), contSch.getPValiDate());
/*     */         int ageInt;
/*     */         int ageInt;
/* 714 */         if (age.indexOf("\uFFFD\uFFFD") != -1)
/* 715 */           ageInt = 0;
/*     */         else {
/* 717 */           ageInt = Integer.parseInt(age.substring(0, age.indexOf("\uFFFD\uFFFD")));
/*     */         }
/*     */ 
/* 720 */         if (ageInt > 2) {
/* 721 */           if ((contSch.getInsuredSex().equals("1")) && (ageInt >= 18)) {
/* 722 */             spelImpartType = "female";
/*     */           }
/*     */ 
/* 725 */           if (contSch.getInsuredSex().equals("0"))
/* 726 */             spelImpartType = "male";
/*     */         }
/*     */         else {
/* 729 */           spelImpartType = "child";
/*     */         }
/*     */ 
/* 732 */         for (int i = 1; i <= tSSRS3.MaxRow; i++)
/*     */         {
/* 734 */           if (tSSRS3.GetText(i, 2).equals(spelImpartType)) {
/* 735 */             errorMsg = errorMsg + tSSRS3.GetText(i, 3) + ",";
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 741 */     if (!errorMsg.equals("")) {
/* 742 */       reError = "\uFFFD\uFFFD\uFFFD\u05AA:" + errorMsg + "\u03B4\uFFFD\uFFFD\u0434\uFFFD\uFFFD\uFFFD\uFFFD,\uFFFD\uFFFD\uFFFD\uFFFD\u0434";
/* 743 */       reError = reError.replaceAll(":,", ":");
/* 744 */       reError = reError.replaceAll(",,", ",");
/*     */     }
/*     */ 
/* 747 */     System.out.println("\uFFFD\u06B6\uFFFD\uFFFD\u03BA\u02F1\uFFFD\u0423\uFFFD\u98FA" + reError);
/* 748 */     return reError;
/*     */   }
/*     */ 
/*     */   private boolean checkAgentExist(String contno) {
/* 752 */     boolean flag = false;
/* 753 */     String queSQL = "select count(1) from lnpagentinfo where contno='" + contno + "'";
/*     */ 
/* 755 */     ExeSQL tExeSQL = new ExeSQL();
/* 756 */     SSRS tSSRS = tExeSQL.execSQL(queSQL);
/* 757 */     if ((tSSRS != null) && (Integer.parseInt(tSSRS.GetText(1, 1)) > 0)) {
/* 758 */       flag = true;
/*     */     }
/*     */ 
/* 761 */     return flag;
/*     */   }
/*     */ 
/*     */   private String checkSpelDone(String contno)
/*     */   {
/* 769 */     System.out.println("-- \u0423\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD --");
/* 770 */     String reErrorMsg = "";
/*     */ 
/* 772 */     String sql = "select impartid,questionid,checkflag,checkvalue,errormsg,p1,p2,p3 from LNPSpelCheckConfig;";
/* 773 */     ExeSQL tExeSQL = new ExeSQL();
/*     */ 
/* 775 */     System.out.println("sql --" + sql);
/* 776 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/* 777 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0))
/*     */     {
/* 779 */       SSRS tSSRS2 = new SSRS();
/* 780 */       for (int i = 1; i <= tSSRS.MaxRow; i++)
/*     */       {
/* 782 */         String tempsql = "select 1 from " + tSSRS.GetText(i, 6) + "Result " + 
/* 783 */           " where " + tSSRS.GetText(i, 7) + "='" + tSSRS.GetText(i, 2) + "' and " + tSSRS.GetText(i, 8) + 
/* 784 */           "='" + tSSRS.GetText(i, 4) + "' and impartid='" + tSSRS.GetText(i, 1) + "'  and contno='" + contno + "';";
/* 785 */         System.out.println("tempsql --" + tempsql);
/* 786 */         tSSRS2 = tExeSQL.execSQL(tempsql);
/* 787 */         if (tSSRS2.MaxRow != 1) {
/* 788 */           reErrorMsg = tSSRS.GetText(i, 5) + "!";
/*     */         }
/*     */       }
/*     */     }
/* 792 */     if (reErrorMsg.equals("")) {
/* 793 */       reErrorMsg = null;
/*     */     }
/* 795 */     System.out.println("-- \u0423\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD end--" + reErrorMsg);
/* 796 */     return reErrorMsg;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.InterFaceCheck
 * JD-Core Version:    0.6.0
 */