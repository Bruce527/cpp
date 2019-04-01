/*     */ package com.sinosoft.map.lis.batch;
/*     */ 
/*     */ import com.sinosoft.map.ec.utility.ECPubFun;
/*     */ import com.sinosoft.map.lis.pubfun.MMap;
/*     */ import com.sinosoft.map.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.map.lis.pubfun.SysMaxNoMap;
/*     */ import com.sinosoft.map.lis.schema.CaseFileDownlLogSchema;
/*     */ import com.sinosoft.map.pdf.GetPDF;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class ModifyCaseFileDown
/*     */ {
/*  20 */   private String tCalStatYM = "";
/*     */ 
/*  22 */   private String tCalStartDate = "";
/*     */ 
/*  24 */   private String firstRdxPath = "";
/*  25 */   private String secondRdxPath = "";
/*  26 */   private String newPdfPath = "";
/*  27 */   private String ftpAddress = "";
/*  28 */   private String ftpPort = "";
/*  29 */   private String ftpUserName = "";
/*  30 */   private String ftpPassword = "";
/*     */ 
/*     */   public void getInitPath() {
/*  33 */     ExeSQL tExeSQL = new ExeSQL();
/*  34 */     SSRS tSSRS = new SSRS();
/*  35 */     String sql1 = " select varvalue from msysvar where vartype='casedownloadfile' ";
/*  36 */     tSSRS = tExeSQL.execSQL(sql1);
/*  37 */     this.firstRdxPath = tSSRS.GetText(1, 1);
/*     */ 
/*  39 */     String sql2 = " select varvalue from msysvar where vartype='casexmlfile' ";
/*  40 */     tSSRS = tExeSQL.execSQL(sql2);
/*  41 */     this.secondRdxPath = tSSRS.GetText(1, 1);
/*     */ 
/*  43 */     String sql3 = " select varvalue from msysvar where vartype='casepdffile' ";
/*  44 */     tSSRS = tExeSQL.execSQL(sql3);
/*  45 */     this.newPdfPath = tSSRS.GetText(1, 1);
/*     */ 
/*  47 */     String sql4 = " select varvalue from msysvar where vartype='ftpaddress' ";
/*  48 */     tSSRS = tExeSQL.execSQL(sql4);
/*  49 */     this.ftpAddress = tSSRS.GetText(1, 1);
/*     */ 
/*  51 */     String sql5 = " select varvalue from msysvar where vartype='ftpport' ";
/*  52 */     tSSRS = tExeSQL.execSQL(sql5);
/*  53 */     this.ftpPort = tSSRS.GetText(1, 1);
/*     */ 
/*  55 */     String sql6 = " select varvalue from msysvar where vartype='ftpusername' ";
/*  56 */     tSSRS = tExeSQL.execSQL(sql6);
/*  57 */     this.ftpUserName = tSSRS.GetText(1, 1);
/*     */ 
/*  59 */     String sql7 = " select varvalue from msysvar where vartype='ftppassword' ";
/*  60 */     tSSRS = tExeSQL.execSQL(sql7);
/*  61 */     this.ftpPassword = tSSRS.GetText(1, 1);
/*     */   }
/*     */ 
/*     */   public void newBatch()
/*     */   {
/*  68 */     getInitPath();
/*     */ 
/*  70 */     ExeSQL tExeSQL = new ExeSQL();
/*  71 */     SSRS tSSRS = new SSRS();
/*  72 */     String curDate = ECPubFun.getCurrentDate();
/*  73 */     String sql2 = " select year(dateadd(dd,-1,'" + curDate + "')),month(dateadd(dd,-1,'" + curDate + "')),day(dateadd(dd,-1,'" + curDate + "')) " + 
/*  74 */       " from msysvar where vartype='onerow'";
/*  75 */     tSSRS = tExeSQL.execSQL(sql2);
/*     */ 
/*  77 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/*  78 */       String year = tSSRS.GetText(1, 1);
/*  79 */       String month = tSSRS.GetText(1, 2);
/*  80 */       String day = tSSRS.GetText(1, 3);
/*     */ 
/*  83 */       GetPDF tGetPDF = new GetPDF();
/*     */ 
/*  85 */       tGetPDF.firstRdxPath = this.firstRdxPath;
/*  86 */       tGetPDF.secondRdxPath = this.secondRdxPath;
/*  87 */       tGetPDF.newPdfPath = this.newPdfPath;
/*  88 */       tGetPDF.ftpAddress = this.ftpAddress;
/*  89 */       tGetPDF.ftpPort = this.ftpPort;
/*  90 */       tGetPDF.ftpUserName = this.ftpUserName;
/*  91 */       tGetPDF.ftpPassword = this.ftpPassword;
/*     */ 
/*  95 */       CaseFileDownlLogSchema tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
/*  96 */       PubSubmit pb = new PubSubmit();
/*  97 */       MMap map = new MMap();
/*     */ 
/* 100 */       String fileDate = year + "-" + month + "-" + day;
/* 101 */       String selectSql = " select top 1 id,fileDate,fdowndate,fdowntime from CaseFileDownlLog where fileDate=cast('" + 
/* 102 */         fileDate + "' as datetime) ";
/* 103 */       tSSRS = tExeSQL.execSQL(selectSql);
/* 104 */       if ((tSSRS == null) || (tSSRS.MaxRow == 0)) {
/* 105 */         SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap(
/* 106 */           "MCaseFileDownNO", 10, 1);
/* 107 */         String modifyDate = ECPubFun.getCurrentDate();
/* 108 */         String modifyTime = ECPubFun.getCurrentTime();
/* 109 */         String tID = tSysMaxNoMap.next();
/* 110 */         tCaseFileDownlLogSchema.setId(tID);
/*     */ 
/* 112 */         tCaseFileDownlLogSchema.setFDownDate(modifyDate);
/* 113 */         tCaseFileDownlLogSchema.setFDownTime(modifyTime);
/* 114 */         tCaseFileDownlLogSchema.setFileDate(fileDate);
/* 115 */         tCaseFileDownlLogSchema.setModifyDate(modifyDate);
/* 116 */         tCaseFileDownlLogSchema.setModityTime(modifyTime);
/* 117 */         tCaseFileDownlLogSchema.setLastOperator("sys");
/* 118 */         tCaseFileDownlLogSchema.setFlag("01");
/*     */ 
/* 120 */         map.put(tCaseFileDownlLogSchema, "INSERT");
/* 121 */         VData vd = new VData();
/* 122 */         vd.add(map);
/* 123 */         if (!pb.submitData(vd, "")) {
/* 124 */           System.out.println(" INSERT failed ");
/*     */         }
/*     */       }
/* 127 */       else if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 128 */         tCaseFileDownlLogSchema.setId(tSSRS.GetText(1, 1));
/* 129 */         tCaseFileDownlLogSchema.setFileDate(tSSRS.GetText(1, 2));
/* 130 */         tCaseFileDownlLogSchema.setFDownDate(tSSRS.GetText(1, 3));
/* 131 */         tCaseFileDownlLogSchema.setFDownTime(tSSRS.GetText(1, 4));
/* 132 */         String modifyDate = ECPubFun.getCurrentDate();
/* 133 */         String modifyTime = ECPubFun.getCurrentTime();
/* 134 */         tCaseFileDownlLogSchema.setModifyDate(modifyDate);
/* 135 */         tCaseFileDownlLogSchema.setModityTime(modifyTime);
/* 136 */         tCaseFileDownlLogSchema.setLastOperator("sys");
/* 137 */         tCaseFileDownlLogSchema.setFlag("01");
/*     */ 
/* 139 */         map.put(tCaseFileDownlLogSchema, "UPDATE");
/* 140 */         VData vd = new VData();
/* 141 */         vd.add(map);
/* 142 */         if (!pb.submitData(vd, "")) {
/* 143 */           System.out.println(" update failed ");
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 149 */       boolean flag = tGetPDF.getPdf(year, month, day);
/*     */ 
/* 152 */       if (flag) {
/* 153 */         tCaseFileDownlLogSchema.setFlag("02");
/* 154 */         map.put(tCaseFileDownlLogSchema, "UPDATE");
/* 155 */         VData vd = new VData();
/* 156 */         vd.add(map);
/* 157 */         if (!pb.submitData(vd, ""))
/* 158 */           System.out.println(" update failed ");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void batch()
/*     */   {
/* 171 */     getInitPath();
/*     */ 
/* 173 */     ExeSQL tExeSQL = new ExeSQL();
/* 174 */     SSRS tSSRS = new SSRS();
/* 175 */     String sql = " select max(fileDate),dateadd(dd,-1,getDate())  ,datediff(dd,max(fileDate),dateadd(dd,-1,getDate()))  from CaseFileDownlLog  where flag='02' ";
/*     */ 
/* 179 */     tSSRS = tExeSQL.execSQL(sql);
/*     */ 
/* 181 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 182 */       String finDate = tSSRS.GetText(1, 1);
/* 183 */       int dateCount = Integer.parseInt(tSSRS.GetText(1, 3));
/*     */ 
/* 185 */       if (dateCount > 0)
/* 186 */         for (int i = 1; i <= dateCount; i++) {
/* 187 */           String sql2 = " select year(dateadd(dd," + 
/* 188 */             i + 
/* 189 */             ",cast('" + 
/* 190 */             finDate + 
/* 191 */             "' as datetime))), " + 
/* 192 */             " month(dateadd(dd," + i + ",cast('" + finDate + 
/* 193 */             "' as datetime))), " + " day(dateadd(dd," + i + 
/* 194 */             ",cast('" + finDate + "' as datetime))) " + 
/* 195 */             " from msysvar where vartype='onerow' ";
/* 196 */           tSSRS = tExeSQL.execSQL(sql2);
/*     */ 
/* 198 */           if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 199 */             String year = tSSRS.GetText(1, 1);
/* 200 */             String month = tSSRS.GetText(1, 2);
/* 201 */             String day = tSSRS.GetText(1, 3);
/*     */ 
/* 204 */             GetPDF tGetPDF = new GetPDF();
/*     */ 
/* 206 */             tGetPDF.firstRdxPath = this.firstRdxPath;
/* 207 */             tGetPDF.secondRdxPath = this.secondRdxPath;
/* 208 */             tGetPDF.newPdfPath = this.newPdfPath;
/* 209 */             tGetPDF.ftpAddress = this.ftpAddress;
/* 210 */             tGetPDF.ftpPort = this.ftpPort;
/* 211 */             tGetPDF.ftpUserName = this.ftpUserName;
/* 212 */             tGetPDF.ftpPassword = this.ftpPassword;
/*     */ 
/* 216 */             CaseFileDownlLogSchema tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
/* 217 */             PubSubmit pb = new PubSubmit();
/* 218 */             MMap map = new MMap();
/*     */ 
/* 221 */             String fileDate = year + "-" + month + "-" + day;
/* 222 */             String selectSql = " select top 1 id,fileDate,fdowndate,fdowntime from CaseFileDownlLog where fileDate=cast('" + 
/* 223 */               fileDate + "' as datetime) ";
/* 224 */             tSSRS = tExeSQL.execSQL(selectSql);
/* 225 */             if ((tSSRS == null) || (tSSRS.MaxRow == 0)) {
/* 226 */               SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap(
/* 227 */                 "MCaseFileDownNO", 10, 1);
/* 228 */               String modifyDate = ECPubFun.getCurrentDate();
/* 229 */               String modifyTime = ECPubFun.getCurrentTime();
/* 230 */               String tID = tSysMaxNoMap.next();
/* 231 */               tCaseFileDownlLogSchema.setId(tID);
/*     */ 
/* 233 */               tCaseFileDownlLogSchema.setFDownDate(modifyDate);
/* 234 */               tCaseFileDownlLogSchema.setFDownTime(modifyTime);
/* 235 */               tCaseFileDownlLogSchema.setFileDate(fileDate);
/* 236 */               tCaseFileDownlLogSchema.setModifyDate(modifyDate);
/* 237 */               tCaseFileDownlLogSchema.setModityTime(modifyTime);
/* 238 */               tCaseFileDownlLogSchema.setLastOperator("sys");
/* 239 */               tCaseFileDownlLogSchema.setFlag("01");
/*     */ 
/* 241 */               map.put(tCaseFileDownlLogSchema, "INSERT");
/* 242 */               VData vd = new VData();
/* 243 */               vd.add(map);
/* 244 */               if (!pb.submitData(vd, "")) {
/* 245 */                 System.out.println(" INSERT failed ");
/*     */               }
/*     */             }
/* 248 */             else if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 249 */               tCaseFileDownlLogSchema.setId(tSSRS.GetText(1, 1));
/* 250 */               tCaseFileDownlLogSchema.setFileDate(tSSRS.GetText(1, 2));
/* 251 */               tCaseFileDownlLogSchema.setFDownDate(tSSRS.GetText(1, 3));
/* 252 */               tCaseFileDownlLogSchema.setFDownTime(tSSRS.GetText(1, 4));
/* 253 */               String modifyDate = ECPubFun.getCurrentDate();
/* 254 */               String modifyTime = ECPubFun.getCurrentTime();
/* 255 */               tCaseFileDownlLogSchema.setModifyDate(modifyDate);
/* 256 */               tCaseFileDownlLogSchema.setModityTime(modifyTime);
/* 257 */               tCaseFileDownlLogSchema.setLastOperator("sys");
/* 258 */               tCaseFileDownlLogSchema.setFlag("01");
/*     */ 
/* 260 */               map.put(tCaseFileDownlLogSchema, "UPDATE");
/* 261 */               VData vd = new VData();
/* 262 */               vd.add(map);
/* 263 */               if (!pb.submitData(vd, "")) {
/* 264 */                 System.out.println(" update failed ");
/*     */               }
/*     */ 
/*     */             }
/*     */ 
/* 269 */             boolean flag = tGetPDF.getPdf(year, month, day);
/*     */ 
/* 272 */             if (flag) {
/* 273 */               tCaseFileDownlLogSchema.setFlag("02");
/* 274 */               map.put(tCaseFileDownlLogSchema, "UPDATE");
/* 275 */               VData vd = new VData();
/* 276 */               vd.add(map);
/* 277 */               if (!pb.submitData(vd, ""))
/* 278 */                 System.out.println(" update failed ");
/*     */             }
/*     */           }
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void doBatchByDate(String date)
/*     */   {
/* 291 */     getInitPath();
/*     */ 
/* 294 */     ExeSQL tExeSQL = new ExeSQL();
/* 295 */     SSRS tSSRS = new SSRS();
/*     */ 
/* 297 */     String[] strArr = date.split("-");
/* 298 */     String year = strArr[0];
/* 299 */     String month = strArr[1];
/* 300 */     String day = strArr[2];
/*     */ 
/* 303 */     GetPDF tGetPDF = new GetPDF();
/*     */ 
/* 306 */     tGetPDF.firstRdxPath = this.firstRdxPath;
/* 307 */     tGetPDF.secondRdxPath = this.secondRdxPath;
/* 308 */     tGetPDF.newPdfPath = this.newPdfPath;
/* 309 */     tGetPDF.ftpAddress = this.ftpAddress;
/* 310 */     tGetPDF.ftpPort = this.ftpPort;
/* 311 */     tGetPDF.ftpUserName = this.ftpUserName;
/* 312 */     tGetPDF.ftpPassword = this.ftpPassword;
/*     */ 
/* 318 */     CaseFileDownlLogSchema tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
/* 319 */     PubSubmit pb = new PubSubmit();
/* 320 */     MMap map = new MMap();
/*     */ 
/* 323 */     String fileDate = year + "-" + month + "-" + day;
/* 324 */     String selectSql = " select top 1 id,fileDate,fdowndate,fdowntime from CaseFileDownlLog where fileDate=cast('" + 
/* 325 */       fileDate + "' as datetime) ";
/* 326 */     tSSRS = tExeSQL.execSQL(selectSql);
/* 327 */     if ((tSSRS == null) || (tSSRS.MaxRow == 0)) {
/* 328 */       SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap(
/* 329 */         "MCaseFileDownNO", 10, 1);
/* 330 */       String modifyDate = ECPubFun.getCurrentDate();
/* 331 */       String modifyTime = ECPubFun.getCurrentTime();
/* 332 */       String tID = tSysMaxNoMap.next();
/* 333 */       tCaseFileDownlLogSchema.setId(tID);
/*     */ 
/* 335 */       tCaseFileDownlLogSchema.setFDownDate(modifyDate);
/* 336 */       tCaseFileDownlLogSchema.setFDownTime(modifyTime);
/* 337 */       tCaseFileDownlLogSchema.setFileDate(fileDate);
/* 338 */       tCaseFileDownlLogSchema.setModifyDate(modifyDate);
/* 339 */       tCaseFileDownlLogSchema.setModityTime(modifyTime);
/* 340 */       tCaseFileDownlLogSchema.setLastOperator("sys");
/* 341 */       tCaseFileDownlLogSchema.setFlag("01");
/*     */ 
/* 343 */       map.put(tCaseFileDownlLogSchema, "INSERT");
/* 344 */       VData vd = new VData();
/* 345 */       vd.add(map);
/* 346 */       if (!pb.submitData(vd, "")) {
/* 347 */         System.out.println(" INSERT failed ");
/*     */       }
/*     */     }
/* 350 */     else if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 351 */       tCaseFileDownlLogSchema.setId(tSSRS.GetText(1, 1));
/* 352 */       tCaseFileDownlLogSchema.setFileDate(tSSRS.GetText(1, 2));
/* 353 */       tCaseFileDownlLogSchema.setFDownDate(tSSRS.GetText(1, 3));
/* 354 */       tCaseFileDownlLogSchema.setFDownTime(tSSRS.GetText(1, 4));
/* 355 */       String modifyDate = ECPubFun.getCurrentDate();
/* 356 */       String modifyTime = ECPubFun.getCurrentTime();
/* 357 */       tCaseFileDownlLogSchema.setModifyDate(modifyDate);
/* 358 */       tCaseFileDownlLogSchema.setModityTime(modifyTime);
/* 359 */       tCaseFileDownlLogSchema.setLastOperator("sys");
/* 360 */       tCaseFileDownlLogSchema.setFlag("01");
/*     */ 
/* 362 */       map.put(tCaseFileDownlLogSchema, "UPDATE");
/* 363 */       VData vd = new VData();
/* 364 */       vd.add(map);
/* 365 */       if (!pb.submitData(vd, "")) {
/* 366 */         System.out.println(" update failed ");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 372 */     boolean flag = tGetPDF.getPdf(year, month, day);
/*     */ 
/* 375 */     if (flag) {
/* 376 */       tCaseFileDownlLogSchema.setFlag("02");
/* 377 */       map.put(tCaseFileDownlLogSchema, "UPDATE");
/* 378 */       VData vd = new VData();
/* 379 */       vd.add(map);
/* 380 */       if (!pb.submitData(vd, ""))
/* 381 */         System.out.println(" update failed ");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void doBatchInDays(String beginDate, String endDate)
/*     */   {
/* 390 */     getInitPath();
/*     */ 
/* 392 */     ExeSQL tExeSQL = new ExeSQL();
/* 393 */     SSRS tSSRS = new SSRS();
/* 394 */     String sql = " select datediff(dd,'" + beginDate + "','" + endDate + "')" + 
/* 395 */       " from msysvar where vartype='onerow' ";
/* 396 */     tSSRS = tExeSQL.execSQL(sql);
/*     */ 
/* 398 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0))
/*     */     {
/* 400 */       int dateCount = Integer.parseInt(tSSRS.GetText(1, 1));
/*     */ 
/* 402 */       if (dateCount >= 0)
/* 403 */         for (int i = 0; i <= dateCount; i++) {
/* 404 */           String sql2 = " select year(dateadd(dd," + 
/* 405 */             i + 
/* 406 */             ",cast('" + 
/* 407 */             beginDate + 
/* 408 */             "' as datetime))), " + 
/* 409 */             " month(dateadd(dd," + i + ",cast('" + beginDate + 
/* 410 */             "' as datetime))), " + " day(dateadd(dd," + i + 
/* 411 */             ",cast('" + beginDate + "' as datetime))) " + 
/* 412 */             " from msysvar where vartype='onerow' ";
/*     */ 
/* 414 */           tSSRS = tExeSQL.execSQL(sql2);
/*     */ 
/* 416 */           if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 417 */             String year = tSSRS.GetText(1, 1);
/* 418 */             String month = tSSRS.GetText(1, 2);
/* 419 */             String day = tSSRS.GetText(1, 3);
/*     */ 
/* 422 */             GetPDF tGetPDF = new GetPDF();
/*     */ 
/* 425 */             tGetPDF.firstRdxPath = this.firstRdxPath;
/* 426 */             tGetPDF.secondRdxPath = this.secondRdxPath;
/* 427 */             tGetPDF.newPdfPath = this.newPdfPath;
/* 428 */             tGetPDF.ftpAddress = this.ftpAddress;
/* 429 */             tGetPDF.ftpPort = this.ftpPort;
/* 430 */             tGetPDF.ftpUserName = this.ftpUserName;
/* 431 */             tGetPDF.ftpPassword = this.ftpPassword;
/*     */ 
/* 437 */             CaseFileDownlLogSchema tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
/* 438 */             PubSubmit pb = new PubSubmit();
/* 439 */             MMap map = new MMap();
/*     */ 
/* 442 */             String fileDate = year + "-" + month + "-" + day;
/* 443 */             String selectSql = " select top 1 id,fileDate,fdowndate,fdowntime from CaseFileDownlLog where fileDate=cast('" + 
/* 444 */               fileDate + "' as datetime) ";
/* 445 */             tSSRS = tExeSQL.execSQL(selectSql);
/* 446 */             if ((tSSRS == null) || (tSSRS.MaxRow == 0)) {
/* 447 */               SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap(
/* 448 */                 "MCaseFileDownNO", 10, 1);
/* 449 */               String modifyDate = ECPubFun.getCurrentDate();
/* 450 */               String modifyTime = ECPubFun.getCurrentTime();
/* 451 */               String tID = tSysMaxNoMap.next();
/* 452 */               tCaseFileDownlLogSchema.setId(tID);
/*     */ 
/* 454 */               tCaseFileDownlLogSchema.setFDownDate(modifyDate);
/* 455 */               tCaseFileDownlLogSchema.setFDownTime(modifyTime);
/* 456 */               tCaseFileDownlLogSchema.setFileDate(fileDate);
/* 457 */               tCaseFileDownlLogSchema.setModifyDate(modifyDate);
/* 458 */               tCaseFileDownlLogSchema.setModityTime(modifyTime);
/* 459 */               tCaseFileDownlLogSchema.setLastOperator("sys");
/* 460 */               tCaseFileDownlLogSchema.setFlag("01");
/*     */ 
/* 462 */               map.put(tCaseFileDownlLogSchema, "INSERT");
/* 463 */               VData vd = new VData();
/* 464 */               vd.add(map);
/* 465 */               if (!pb.submitData(vd, "")) {
/* 466 */                 System.out.println(" INSERT failed ");
/*     */               }
/*     */             }
/* 469 */             else if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 470 */               tCaseFileDownlLogSchema.setId(tSSRS.GetText(1, 1));
/* 471 */               tCaseFileDownlLogSchema.setFileDate(tSSRS.GetText(1, 2));
/* 472 */               tCaseFileDownlLogSchema.setFDownDate(tSSRS.GetText(1, 3));
/* 473 */               tCaseFileDownlLogSchema.setFDownTime(tSSRS.GetText(1, 4));
/* 474 */               String modifyDate = ECPubFun.getCurrentDate();
/* 475 */               String modifyTime = ECPubFun.getCurrentTime();
/* 476 */               tCaseFileDownlLogSchema.setModifyDate(modifyDate);
/* 477 */               tCaseFileDownlLogSchema.setModityTime(modifyTime);
/* 478 */               tCaseFileDownlLogSchema.setLastOperator("sys");
/* 479 */               tCaseFileDownlLogSchema.setFlag("01");
/*     */ 
/* 481 */               map.put(tCaseFileDownlLogSchema, "UPDATE");
/* 482 */               VData vd = new VData();
/* 483 */               vd.add(map);
/* 484 */               if (!pb.submitData(vd, "")) {
/* 485 */                 System.out.println(" update failed ");
/*     */               }
/*     */ 
/*     */             }
/*     */ 
/* 491 */             boolean flag = tGetPDF.getPdf(year, month, day);
/*     */ 
/* 494 */             if (flag) {
/* 495 */               tCaseFileDownlLogSchema.setFlag("02");
/* 496 */               map.put(tCaseFileDownlLogSchema, "UPDATE");
/* 497 */               VData vd = new VData();
/* 498 */               vd.add(map);
/* 499 */               if (!pb.submitData(vd, ""))
/* 500 */                 System.out.println(" update failed ");
/*     */             }
/*     */           }
/*     */         }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.batch.ModifyCaseFileDown
 * JD-Core Version:    0.6.0
 */