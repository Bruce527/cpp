/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskAppSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskAppSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRiskAppDBSet extends LNPRiskAppSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRiskAppDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRiskApp");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskAppDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRiskApp");
/*  36 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  41 */     if (this.db.deleteSQL(this))
/*     */     {
/*  43 */       return true;
/*     */     }
/*     */ 
/*  48 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  49 */     CError tError = new CError();
/*  50 */     tError.moduleName = "LNPRiskAppDBSet";
/*  51 */     tError.functionName = "deleteSQL";
/*  52 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  53 */     this.mErrors.addOneError(tError);
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  61 */     PreparedStatement pstmt = null;
/*     */ 
/*  63 */     if (!this.mflag) {
/*  64 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  69 */       int tCount = size();
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskApp WHERE  RiskCode = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/*  78 */         pstmt.addBatch();
/*     */       }
/*  80 */       pstmt.executeBatch();
/*  81 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  84 */       ex.printStackTrace();
/*  85 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  86 */       CError tError = new CError();
/*  87 */       tError.moduleName = "LNPRiskAppDBSet";
/*  88 */       tError.functionName = "delete()";
/*  89 */       tError.errorMessage = ex.toString();
/*  90 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  93 */         pstmt.close(); } catch (Exception e) {
/*  94 */         e.printStackTrace();
/*     */       }
/*  96 */       if (!this.mflag) {
/*     */         try {
/*  98 */           this.con.close(); } catch (Exception e) {
/*  99 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 102 */       return false;
/*     */     }
/*     */ 
/* 105 */     if (!this.mflag) {
/*     */       try {
/* 107 */         this.con.close(); } catch (Exception e) {
/* 108 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 117 */     PreparedStatement pstmt = null;
/*     */ 
/* 119 */     if (!this.mflag) {
/* 120 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 125 */       int tCount = size();
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskApp SET  RiskCode = ? , RiskVer = ? , RiskName = ? , KindCode = ? , RiskType = ? , RiskType1 = ? , RiskType2 = ? , RiskProp = ? , RiskPeriod = ? , RiskTypeDetail = ? , RiskFlag = ? , PolType = ? , InvestFlag = ? , BonusFlag = ? , BonusMode = ? , ListFlag = ? , SubRiskFlag = ? , CalDigital = ? , CalChoMode = ? , RiskAmntMult = ? , InsuPeriodFlag = ? , MaxEndPeriod = ? , AgeLmt = ? , SignDateCalMode = ? , ProtocolFlag = ? , GetChgFlag = ? , ProtocolPayFlag = ? , EnsuPlanFlag = ? , EnsuPlanAdjFlag = ? , StartDate = ? , EndDate = ? , MinAppntAge = ? , MaxAppntAge = ? , MaxInsuredAge = ? , MinInsuredAge = ? , AppInterest = ? , AppPremRate = ? , InsuredFlag = ? , ShareFlag = ? , BnfFlag = ? , TempPayFlag = ? , InpPayPlan = ? , ImpartFlag = ? , InsuExpeFlag = ? , LoanFalg = ? , MortagageFlag = ? , IDifReturnFlag = ? , CutAmntStopPay = ? , RinsRate = ? , SaleFlag = ? , FileAppFlag = ? , MngCom = ? , AutoPayFlag = ? , NeedPrintHospital = ? , NeedPrintGet = ? , RiskType3 = ? , RiskType4 = ? , RiskType5 = ? , NotPrintPol = ? , NeedGetPolDate = ? , NeedReReadBank = ? , SpecFlag = ? , InterestDifFlag = ? WHERE  RiskCode = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 134 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/* 139 */         if ((get(i).getRiskName() == null) || (get(i).getRiskName().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getRiskName());
/*     */         }
/* 144 */         if ((get(i).getKindCode() == null) || (get(i).getKindCode().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getKindCode());
/*     */         }
/* 149 */         if ((get(i).getRiskType() == null) || (get(i).getRiskType().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getRiskType());
/*     */         }
/* 154 */         if ((get(i).getRiskType1() == null) || (get(i).getRiskType1().equals("null")))
/* 155 */           pstmt.setString(6, null);
/*     */         else {
/* 157 */           pstmt.setString(6, get(i).getRiskType1());
/*     */         }
/* 159 */         if ((get(i).getRiskType2() == null) || (get(i).getRiskType2().equals("null")))
/* 160 */           pstmt.setString(7, null);
/*     */         else {
/* 162 */           pstmt.setString(7, get(i).getRiskType2());
/*     */         }
/* 164 */         if ((get(i).getRiskProp() == null) || (get(i).getRiskProp().equals("null")))
/* 165 */           pstmt.setString(8, null);
/*     */         else {
/* 167 */           pstmt.setString(8, get(i).getRiskProp());
/*     */         }
/* 169 */         if ((get(i).getRiskPeriod() == null) || (get(i).getRiskPeriod().equals("null")))
/* 170 */           pstmt.setString(9, null);
/*     */         else {
/* 172 */           pstmt.setString(9, get(i).getRiskPeriod());
/*     */         }
/* 174 */         if ((get(i).getRiskTypeDetail() == null) || (get(i).getRiskTypeDetail().equals("null")))
/* 175 */           pstmt.setString(10, null);
/*     */         else {
/* 177 */           pstmt.setString(10, get(i).getRiskTypeDetail());
/*     */         }
/* 179 */         if ((get(i).getRiskFlag() == null) || (get(i).getRiskFlag().equals("null")))
/* 180 */           pstmt.setString(11, null);
/*     */         else {
/* 182 */           pstmt.setString(11, get(i).getRiskFlag());
/*     */         }
/* 184 */         if ((get(i).getPolType() == null) || (get(i).getPolType().equals("null")))
/* 185 */           pstmt.setString(12, null);
/*     */         else {
/* 187 */           pstmt.setString(12, get(i).getPolType());
/*     */         }
/* 189 */         if ((get(i).getInvestFlag() == null) || (get(i).getInvestFlag().equals("null")))
/* 190 */           pstmt.setString(13, null);
/*     */         else {
/* 192 */           pstmt.setString(13, get(i).getInvestFlag());
/*     */         }
/* 194 */         if ((get(i).getBonusFlag() == null) || (get(i).getBonusFlag().equals("null")))
/* 195 */           pstmt.setString(14, null);
/*     */         else {
/* 197 */           pstmt.setString(14, get(i).getBonusFlag());
/*     */         }
/* 199 */         if ((get(i).getBonusMode() == null) || (get(i).getBonusMode().equals("null")))
/* 200 */           pstmt.setString(15, null);
/*     */         else {
/* 202 */           pstmt.setString(15, get(i).getBonusMode());
/*     */         }
/* 204 */         if ((get(i).getListFlag() == null) || (get(i).getListFlag().equals("null")))
/* 205 */           pstmt.setString(16, null);
/*     */         else {
/* 207 */           pstmt.setString(16, get(i).getListFlag());
/*     */         }
/* 209 */         if ((get(i).getSubRiskFlag() == null) || (get(i).getSubRiskFlag().equals("null")))
/* 210 */           pstmt.setString(17, null);
/*     */         else {
/* 212 */           pstmt.setString(17, get(i).getSubRiskFlag());
/*     */         }
/* 214 */         pstmt.setInt(18, get(i).getCalDigital());
/* 215 */         if ((get(i).getCalChoMode() == null) || (get(i).getCalChoMode().equals("null")))
/* 216 */           pstmt.setString(19, null);
/*     */         else {
/* 218 */           pstmt.setString(19, get(i).getCalChoMode());
/*     */         }
/* 220 */         pstmt.setInt(20, get(i).getRiskAmntMult());
/* 221 */         if ((get(i).getInsuPeriodFlag() == null) || (get(i).getInsuPeriodFlag().equals("null")))
/* 222 */           pstmt.setString(21, null);
/*     */         else {
/* 224 */           pstmt.setString(21, get(i).getInsuPeriodFlag());
/*     */         }
/* 226 */         pstmt.setInt(22, get(i).getMaxEndPeriod());
/* 227 */         pstmt.setInt(23, get(i).getAgeLmt());
/* 228 */         pstmt.setInt(24, get(i).getSignDateCalMode());
/* 229 */         if ((get(i).getProtocolFlag() == null) || (get(i).getProtocolFlag().equals("null")))
/* 230 */           pstmt.setString(25, null);
/*     */         else {
/* 232 */           pstmt.setString(25, get(i).getProtocolFlag());
/*     */         }
/* 234 */         if ((get(i).getGetChgFlag() == null) || (get(i).getGetChgFlag().equals("null")))
/* 235 */           pstmt.setString(26, null);
/*     */         else {
/* 237 */           pstmt.setString(26, get(i).getGetChgFlag());
/*     */         }
/* 239 */         if ((get(i).getProtocolPayFlag() == null) || (get(i).getProtocolPayFlag().equals("null")))
/* 240 */           pstmt.setString(27, null);
/*     */         else {
/* 242 */           pstmt.setString(27, get(i).getProtocolPayFlag());
/*     */         }
/* 244 */         if ((get(i).getEnsuPlanFlag() == null) || (get(i).getEnsuPlanFlag().equals("null")))
/* 245 */           pstmt.setString(28, null);
/*     */         else {
/* 247 */           pstmt.setString(28, get(i).getEnsuPlanFlag());
/*     */         }
/* 249 */         if ((get(i).getEnsuPlanAdjFlag() == null) || (get(i).getEnsuPlanAdjFlag().equals("null")))
/* 250 */           pstmt.setString(29, null);
/*     */         else {
/* 252 */           pstmt.setString(29, get(i).getEnsuPlanAdjFlag());
/*     */         }
/* 254 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 255 */           pstmt.setDate(30, null);
/*     */         else {
/* 257 */           pstmt.setDate(30, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 259 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 260 */           pstmt.setDate(31, null);
/*     */         else {
/* 262 */           pstmt.setDate(31, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 264 */         pstmt.setInt(32, get(i).getMinAppntAge());
/* 265 */         pstmt.setInt(33, get(i).getMaxAppntAge());
/* 266 */         pstmt.setInt(34, get(i).getMaxInsuredAge());
/* 267 */         pstmt.setInt(35, get(i).getMinInsuredAge());
/* 268 */         pstmt.setDouble(36, get(i).getAppInterest());
/* 269 */         pstmt.setDouble(37, get(i).getAppPremRate());
/* 270 */         if ((get(i).getInsuredFlag() == null) || (get(i).getInsuredFlag().equals("null")))
/* 271 */           pstmt.setString(38, null);
/*     */         else {
/* 273 */           pstmt.setString(38, get(i).getInsuredFlag());
/*     */         }
/* 275 */         if ((get(i).getShareFlag() == null) || (get(i).getShareFlag().equals("null")))
/* 276 */           pstmt.setString(39, null);
/*     */         else {
/* 278 */           pstmt.setString(39, get(i).getShareFlag());
/*     */         }
/* 280 */         if ((get(i).getBnfFlag() == null) || (get(i).getBnfFlag().equals("null")))
/* 281 */           pstmt.setString(40, null);
/*     */         else {
/* 283 */           pstmt.setString(40, get(i).getBnfFlag());
/*     */         }
/* 285 */         if ((get(i).getTempPayFlag() == null) || (get(i).getTempPayFlag().equals("null")))
/* 286 */           pstmt.setString(41, null);
/*     */         else {
/* 288 */           pstmt.setString(41, get(i).getTempPayFlag());
/*     */         }
/* 290 */         if ((get(i).getInpPayPlan() == null) || (get(i).getInpPayPlan().equals("null")))
/* 291 */           pstmt.setString(42, null);
/*     */         else {
/* 293 */           pstmt.setString(42, get(i).getInpPayPlan());
/*     */         }
/* 295 */         if ((get(i).getImpartFlag() == null) || (get(i).getImpartFlag().equals("null")))
/* 296 */           pstmt.setString(43, null);
/*     */         else {
/* 298 */           pstmt.setString(43, get(i).getImpartFlag());
/*     */         }
/* 300 */         if ((get(i).getInsuExpeFlag() == null) || (get(i).getInsuExpeFlag().equals("null")))
/* 301 */           pstmt.setString(44, null);
/*     */         else {
/* 303 */           pstmt.setString(44, get(i).getInsuExpeFlag());
/*     */         }
/* 305 */         if ((get(i).getLoanFalg() == null) || (get(i).getLoanFalg().equals("null")))
/* 306 */           pstmt.setString(45, null);
/*     */         else {
/* 308 */           pstmt.setString(45, get(i).getLoanFalg());
/*     */         }
/* 310 */         if ((get(i).getMortagageFlag() == null) || (get(i).getMortagageFlag().equals("null")))
/* 311 */           pstmt.setString(46, null);
/*     */         else {
/* 313 */           pstmt.setString(46, get(i).getMortagageFlag());
/*     */         }
/* 315 */         if ((get(i).getIDifReturnFlag() == null) || (get(i).getIDifReturnFlag().equals("null")))
/* 316 */           pstmt.setString(47, null);
/*     */         else {
/* 318 */           pstmt.setString(47, get(i).getIDifReturnFlag());
/*     */         }
/* 320 */         if ((get(i).getCutAmntStopPay() == null) || (get(i).getCutAmntStopPay().equals("null")))
/* 321 */           pstmt.setString(48, null);
/*     */         else {
/* 323 */           pstmt.setString(48, get(i).getCutAmntStopPay());
/*     */         }
/* 325 */         pstmt.setDouble(49, get(i).getRinsRate());
/* 326 */         if ((get(i).getSaleFlag() == null) || (get(i).getSaleFlag().equals("null")))
/* 327 */           pstmt.setString(50, null);
/*     */         else {
/* 329 */           pstmt.setString(50, get(i).getSaleFlag());
/*     */         }
/* 331 */         if ((get(i).getFileAppFlag() == null) || (get(i).getFileAppFlag().equals("null")))
/* 332 */           pstmt.setString(51, null);
/*     */         else {
/* 334 */           pstmt.setString(51, get(i).getFileAppFlag());
/*     */         }
/* 336 */         if ((get(i).getMngCom() == null) || (get(i).getMngCom().equals("null")))
/* 337 */           pstmt.setString(52, null);
/*     */         else {
/* 339 */           pstmt.setString(52, get(i).getMngCom());
/*     */         }
/* 341 */         if ((get(i).getAutoPayFlag() == null) || (get(i).getAutoPayFlag().equals("null")))
/* 342 */           pstmt.setString(53, null);
/*     */         else {
/* 344 */           pstmt.setString(53, get(i).getAutoPayFlag());
/*     */         }
/* 346 */         if ((get(i).getNeedPrintHospital() == null) || (get(i).getNeedPrintHospital().equals("null")))
/* 347 */           pstmt.setString(54, null);
/*     */         else {
/* 349 */           pstmt.setString(54, get(i).getNeedPrintHospital());
/*     */         }
/* 351 */         if ((get(i).getNeedPrintGet() == null) || (get(i).getNeedPrintGet().equals("null")))
/* 352 */           pstmt.setString(55, null);
/*     */         else {
/* 354 */           pstmt.setString(55, get(i).getNeedPrintGet());
/*     */         }
/* 356 */         if ((get(i).getRiskType3() == null) || (get(i).getRiskType3().equals("null")))
/* 357 */           pstmt.setString(56, null);
/*     */         else {
/* 359 */           pstmt.setString(56, get(i).getRiskType3());
/*     */         }
/* 361 */         if ((get(i).getRiskType4() == null) || (get(i).getRiskType4().equals("null")))
/* 362 */           pstmt.setString(57, null);
/*     */         else {
/* 364 */           pstmt.setString(57, get(i).getRiskType4());
/*     */         }
/* 366 */         if ((get(i).getRiskType5() == null) || (get(i).getRiskType5().equals("null")))
/* 367 */           pstmt.setString(58, null);
/*     */         else {
/* 369 */           pstmt.setString(58, get(i).getRiskType5());
/*     */         }
/* 371 */         if ((get(i).getNotPrintPol() == null) || (get(i).getNotPrintPol().equals("null")))
/* 372 */           pstmt.setString(59, null);
/*     */         else {
/* 374 */           pstmt.setString(59, get(i).getNotPrintPol());
/*     */         }
/* 376 */         if ((get(i).getNeedGetPolDate() == null) || (get(i).getNeedGetPolDate().equals("null")))
/* 377 */           pstmt.setString(60, null);
/*     */         else {
/* 379 */           pstmt.setString(60, get(i).getNeedGetPolDate());
/*     */         }
/* 381 */         if ((get(i).getNeedReReadBank() == null) || (get(i).getNeedReReadBank().equals("null")))
/* 382 */           pstmt.setString(61, null);
/*     */         else {
/* 384 */           pstmt.setString(61, get(i).getNeedReReadBank());
/*     */         }
/* 386 */         if ((get(i).getSpecFlag() == null) || (get(i).getSpecFlag().equals("null")))
/* 387 */           pstmt.setString(62, null);
/*     */         else {
/* 389 */           pstmt.setString(62, get(i).getSpecFlag());
/*     */         }
/* 391 */         if ((get(i).getInterestDifFlag() == null) || (get(i).getInterestDifFlag().equals("null")))
/* 392 */           pstmt.setString(63, null);
/*     */         else {
/* 394 */           pstmt.setString(63, get(i).getInterestDifFlag());
/*     */         }
/*     */ 
/* 397 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 398 */           pstmt.setString(64, null);
/*     */         else {
/* 400 */           pstmt.setString(64, get(i).getRiskCode());
/*     */         }
/* 402 */         pstmt.addBatch();
/*     */       }
/* 404 */       pstmt.executeBatch();
/* 405 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 408 */       ex.printStackTrace();
/* 409 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 410 */       CError tError = new CError();
/* 411 */       tError.moduleName = "LNPRiskAppDBSet";
/* 412 */       tError.functionName = "update()";
/* 413 */       tError.errorMessage = ex.toString();
/* 414 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 417 */         pstmt.close(); } catch (Exception e) {
/* 418 */         e.printStackTrace();
/*     */       }
/* 420 */       if (!this.mflag) {
/*     */         try {
/* 422 */           this.con.close(); } catch (Exception e) {
/* 423 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 426 */       return false;
/*     */     }
/*     */ 
/* 429 */     if (!this.mflag) {
/*     */       try {
/* 431 */         this.con.close(); } catch (Exception e) {
/* 432 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 435 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 441 */     PreparedStatement pstmt = null;
/*     */ 
/* 443 */     if (!this.mflag) {
/* 444 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 449 */       int tCount = size();
/* 450 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskApp VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 451 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 453 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 454 */           pstmt.setString(1, null);
/*     */         else {
/* 456 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 458 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 459 */           pstmt.setString(2, null);
/*     */         else {
/* 461 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/* 463 */         if ((get(i).getRiskName() == null) || (get(i).getRiskName().equals("null")))
/* 464 */           pstmt.setString(3, null);
/*     */         else {
/* 466 */           pstmt.setString(3, get(i).getRiskName());
/*     */         }
/* 468 */         if ((get(i).getKindCode() == null) || (get(i).getKindCode().equals("null")))
/* 469 */           pstmt.setString(4, null);
/*     */         else {
/* 471 */           pstmt.setString(4, get(i).getKindCode());
/*     */         }
/* 473 */         if ((get(i).getRiskType() == null) || (get(i).getRiskType().equals("null")))
/* 474 */           pstmt.setString(5, null);
/*     */         else {
/* 476 */           pstmt.setString(5, get(i).getRiskType());
/*     */         }
/* 478 */         if ((get(i).getRiskType1() == null) || (get(i).getRiskType1().equals("null")))
/* 479 */           pstmt.setString(6, null);
/*     */         else {
/* 481 */           pstmt.setString(6, get(i).getRiskType1());
/*     */         }
/* 483 */         if ((get(i).getRiskType2() == null) || (get(i).getRiskType2().equals("null")))
/* 484 */           pstmt.setString(7, null);
/*     */         else {
/* 486 */           pstmt.setString(7, get(i).getRiskType2());
/*     */         }
/* 488 */         if ((get(i).getRiskProp() == null) || (get(i).getRiskProp().equals("null")))
/* 489 */           pstmt.setString(8, null);
/*     */         else {
/* 491 */           pstmt.setString(8, get(i).getRiskProp());
/*     */         }
/* 493 */         if ((get(i).getRiskPeriod() == null) || (get(i).getRiskPeriod().equals("null")))
/* 494 */           pstmt.setString(9, null);
/*     */         else {
/* 496 */           pstmt.setString(9, get(i).getRiskPeriod());
/*     */         }
/* 498 */         if ((get(i).getRiskTypeDetail() == null) || (get(i).getRiskTypeDetail().equals("null")))
/* 499 */           pstmt.setString(10, null);
/*     */         else {
/* 501 */           pstmt.setString(10, get(i).getRiskTypeDetail());
/*     */         }
/* 503 */         if ((get(i).getRiskFlag() == null) || (get(i).getRiskFlag().equals("null")))
/* 504 */           pstmt.setString(11, null);
/*     */         else {
/* 506 */           pstmt.setString(11, get(i).getRiskFlag());
/*     */         }
/* 508 */         if ((get(i).getPolType() == null) || (get(i).getPolType().equals("null")))
/* 509 */           pstmt.setString(12, null);
/*     */         else {
/* 511 */           pstmt.setString(12, get(i).getPolType());
/*     */         }
/* 513 */         if ((get(i).getInvestFlag() == null) || (get(i).getInvestFlag().equals("null")))
/* 514 */           pstmt.setString(13, null);
/*     */         else {
/* 516 */           pstmt.setString(13, get(i).getInvestFlag());
/*     */         }
/* 518 */         if ((get(i).getBonusFlag() == null) || (get(i).getBonusFlag().equals("null")))
/* 519 */           pstmt.setString(14, null);
/*     */         else {
/* 521 */           pstmt.setString(14, get(i).getBonusFlag());
/*     */         }
/* 523 */         if ((get(i).getBonusMode() == null) || (get(i).getBonusMode().equals("null")))
/* 524 */           pstmt.setString(15, null);
/*     */         else {
/* 526 */           pstmt.setString(15, get(i).getBonusMode());
/*     */         }
/* 528 */         if ((get(i).getListFlag() == null) || (get(i).getListFlag().equals("null")))
/* 529 */           pstmt.setString(16, null);
/*     */         else {
/* 531 */           pstmt.setString(16, get(i).getListFlag());
/*     */         }
/* 533 */         if ((get(i).getSubRiskFlag() == null) || (get(i).getSubRiskFlag().equals("null")))
/* 534 */           pstmt.setString(17, null);
/*     */         else {
/* 536 */           pstmt.setString(17, get(i).getSubRiskFlag());
/*     */         }
/* 538 */         pstmt.setInt(18, get(i).getCalDigital());
/* 539 */         if ((get(i).getCalChoMode() == null) || (get(i).getCalChoMode().equals("null")))
/* 540 */           pstmt.setString(19, null);
/*     */         else {
/* 542 */           pstmt.setString(19, get(i).getCalChoMode());
/*     */         }
/* 544 */         pstmt.setInt(20, get(i).getRiskAmntMult());
/* 545 */         if ((get(i).getInsuPeriodFlag() == null) || (get(i).getInsuPeriodFlag().equals("null")))
/* 546 */           pstmt.setString(21, null);
/*     */         else {
/* 548 */           pstmt.setString(21, get(i).getInsuPeriodFlag());
/*     */         }
/* 550 */         pstmt.setInt(22, get(i).getMaxEndPeriod());
/* 551 */         pstmt.setInt(23, get(i).getAgeLmt());
/* 552 */         pstmt.setInt(24, get(i).getSignDateCalMode());
/* 553 */         if ((get(i).getProtocolFlag() == null) || (get(i).getProtocolFlag().equals("null")))
/* 554 */           pstmt.setString(25, null);
/*     */         else {
/* 556 */           pstmt.setString(25, get(i).getProtocolFlag());
/*     */         }
/* 558 */         if ((get(i).getGetChgFlag() == null) || (get(i).getGetChgFlag().equals("null")))
/* 559 */           pstmt.setString(26, null);
/*     */         else {
/* 561 */           pstmt.setString(26, get(i).getGetChgFlag());
/*     */         }
/* 563 */         if ((get(i).getProtocolPayFlag() == null) || (get(i).getProtocolPayFlag().equals("null")))
/* 564 */           pstmt.setString(27, null);
/*     */         else {
/* 566 */           pstmt.setString(27, get(i).getProtocolPayFlag());
/*     */         }
/* 568 */         if ((get(i).getEnsuPlanFlag() == null) || (get(i).getEnsuPlanFlag().equals("null")))
/* 569 */           pstmt.setString(28, null);
/*     */         else {
/* 571 */           pstmt.setString(28, get(i).getEnsuPlanFlag());
/*     */         }
/* 573 */         if ((get(i).getEnsuPlanAdjFlag() == null) || (get(i).getEnsuPlanAdjFlag().equals("null")))
/* 574 */           pstmt.setString(29, null);
/*     */         else {
/* 576 */           pstmt.setString(29, get(i).getEnsuPlanAdjFlag());
/*     */         }
/* 578 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 579 */           pstmt.setDate(30, null);
/*     */         else {
/* 581 */           pstmt.setDate(30, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 583 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 584 */           pstmt.setDate(31, null);
/*     */         else {
/* 586 */           pstmt.setDate(31, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 588 */         pstmt.setInt(32, get(i).getMinAppntAge());
/* 589 */         pstmt.setInt(33, get(i).getMaxAppntAge());
/* 590 */         pstmt.setInt(34, get(i).getMaxInsuredAge());
/* 591 */         pstmt.setInt(35, get(i).getMinInsuredAge());
/* 592 */         pstmt.setDouble(36, get(i).getAppInterest());
/* 593 */         pstmt.setDouble(37, get(i).getAppPremRate());
/* 594 */         if ((get(i).getInsuredFlag() == null) || (get(i).getInsuredFlag().equals("null")))
/* 595 */           pstmt.setString(38, null);
/*     */         else {
/* 597 */           pstmt.setString(38, get(i).getInsuredFlag());
/*     */         }
/* 599 */         if ((get(i).getShareFlag() == null) || (get(i).getShareFlag().equals("null")))
/* 600 */           pstmt.setString(39, null);
/*     */         else {
/* 602 */           pstmt.setString(39, get(i).getShareFlag());
/*     */         }
/* 604 */         if ((get(i).getBnfFlag() == null) || (get(i).getBnfFlag().equals("null")))
/* 605 */           pstmt.setString(40, null);
/*     */         else {
/* 607 */           pstmt.setString(40, get(i).getBnfFlag());
/*     */         }
/* 609 */         if ((get(i).getTempPayFlag() == null) || (get(i).getTempPayFlag().equals("null")))
/* 610 */           pstmt.setString(41, null);
/*     */         else {
/* 612 */           pstmt.setString(41, get(i).getTempPayFlag());
/*     */         }
/* 614 */         if ((get(i).getInpPayPlan() == null) || (get(i).getInpPayPlan().equals("null")))
/* 615 */           pstmt.setString(42, null);
/*     */         else {
/* 617 */           pstmt.setString(42, get(i).getInpPayPlan());
/*     */         }
/* 619 */         if ((get(i).getImpartFlag() == null) || (get(i).getImpartFlag().equals("null")))
/* 620 */           pstmt.setString(43, null);
/*     */         else {
/* 622 */           pstmt.setString(43, get(i).getImpartFlag());
/*     */         }
/* 624 */         if ((get(i).getInsuExpeFlag() == null) || (get(i).getInsuExpeFlag().equals("null")))
/* 625 */           pstmt.setString(44, null);
/*     */         else {
/* 627 */           pstmt.setString(44, get(i).getInsuExpeFlag());
/*     */         }
/* 629 */         if ((get(i).getLoanFalg() == null) || (get(i).getLoanFalg().equals("null")))
/* 630 */           pstmt.setString(45, null);
/*     */         else {
/* 632 */           pstmt.setString(45, get(i).getLoanFalg());
/*     */         }
/* 634 */         if ((get(i).getMortagageFlag() == null) || (get(i).getMortagageFlag().equals("null")))
/* 635 */           pstmt.setString(46, null);
/*     */         else {
/* 637 */           pstmt.setString(46, get(i).getMortagageFlag());
/*     */         }
/* 639 */         if ((get(i).getIDifReturnFlag() == null) || (get(i).getIDifReturnFlag().equals("null")))
/* 640 */           pstmt.setString(47, null);
/*     */         else {
/* 642 */           pstmt.setString(47, get(i).getIDifReturnFlag());
/*     */         }
/* 644 */         if ((get(i).getCutAmntStopPay() == null) || (get(i).getCutAmntStopPay().equals("null")))
/* 645 */           pstmt.setString(48, null);
/*     */         else {
/* 647 */           pstmt.setString(48, get(i).getCutAmntStopPay());
/*     */         }
/* 649 */         pstmt.setDouble(49, get(i).getRinsRate());
/* 650 */         if ((get(i).getSaleFlag() == null) || (get(i).getSaleFlag().equals("null")))
/* 651 */           pstmt.setString(50, null);
/*     */         else {
/* 653 */           pstmt.setString(50, get(i).getSaleFlag());
/*     */         }
/* 655 */         if ((get(i).getFileAppFlag() == null) || (get(i).getFileAppFlag().equals("null")))
/* 656 */           pstmt.setString(51, null);
/*     */         else {
/* 658 */           pstmt.setString(51, get(i).getFileAppFlag());
/*     */         }
/* 660 */         if ((get(i).getMngCom() == null) || (get(i).getMngCom().equals("null")))
/* 661 */           pstmt.setString(52, null);
/*     */         else {
/* 663 */           pstmt.setString(52, get(i).getMngCom());
/*     */         }
/* 665 */         if ((get(i).getAutoPayFlag() == null) || (get(i).getAutoPayFlag().equals("null")))
/* 666 */           pstmt.setString(53, null);
/*     */         else {
/* 668 */           pstmt.setString(53, get(i).getAutoPayFlag());
/*     */         }
/* 670 */         if ((get(i).getNeedPrintHospital() == null) || (get(i).getNeedPrintHospital().equals("null")))
/* 671 */           pstmt.setString(54, null);
/*     */         else {
/* 673 */           pstmt.setString(54, get(i).getNeedPrintHospital());
/*     */         }
/* 675 */         if ((get(i).getNeedPrintGet() == null) || (get(i).getNeedPrintGet().equals("null")))
/* 676 */           pstmt.setString(55, null);
/*     */         else {
/* 678 */           pstmt.setString(55, get(i).getNeedPrintGet());
/*     */         }
/* 680 */         if ((get(i).getRiskType3() == null) || (get(i).getRiskType3().equals("null")))
/* 681 */           pstmt.setString(56, null);
/*     */         else {
/* 683 */           pstmt.setString(56, get(i).getRiskType3());
/*     */         }
/* 685 */         if ((get(i).getRiskType4() == null) || (get(i).getRiskType4().equals("null")))
/* 686 */           pstmt.setString(57, null);
/*     */         else {
/* 688 */           pstmt.setString(57, get(i).getRiskType4());
/*     */         }
/* 690 */         if ((get(i).getRiskType5() == null) || (get(i).getRiskType5().equals("null")))
/* 691 */           pstmt.setString(58, null);
/*     */         else {
/* 693 */           pstmt.setString(58, get(i).getRiskType5());
/*     */         }
/* 695 */         if ((get(i).getNotPrintPol() == null) || (get(i).getNotPrintPol().equals("null")))
/* 696 */           pstmt.setString(59, null);
/*     */         else {
/* 698 */           pstmt.setString(59, get(i).getNotPrintPol());
/*     */         }
/* 700 */         if ((get(i).getNeedGetPolDate() == null) || (get(i).getNeedGetPolDate().equals("null")))
/* 701 */           pstmt.setString(60, null);
/*     */         else {
/* 703 */           pstmt.setString(60, get(i).getNeedGetPolDate());
/*     */         }
/* 705 */         if ((get(i).getNeedReReadBank() == null) || (get(i).getNeedReReadBank().equals("null")))
/* 706 */           pstmt.setString(61, null);
/*     */         else {
/* 708 */           pstmt.setString(61, get(i).getNeedReReadBank());
/*     */         }
/* 710 */         if ((get(i).getSpecFlag() == null) || (get(i).getSpecFlag().equals("null")))
/* 711 */           pstmt.setString(62, null);
/*     */         else {
/* 713 */           pstmt.setString(62, get(i).getSpecFlag());
/*     */         }
/* 715 */         if ((get(i).getInterestDifFlag() == null) || (get(i).getInterestDifFlag().equals("null")))
/* 716 */           pstmt.setString(63, null);
/*     */         else {
/* 718 */           pstmt.setString(63, get(i).getInterestDifFlag());
/*     */         }
/* 720 */         pstmt.addBatch();
/*     */       }
/* 722 */       pstmt.executeBatch();
/* 723 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 726 */       ex.printStackTrace();
/* 727 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 728 */       CError tError = new CError();
/* 729 */       tError.moduleName = "LNPRiskAppDBSet";
/* 730 */       tError.functionName = "insert()";
/* 731 */       tError.errorMessage = ex.toString();
/* 732 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 735 */         pstmt.close(); } catch (Exception e) {
/* 736 */         e.printStackTrace();
/*     */       }
/* 738 */       if (!this.mflag) {
/*     */         try {
/* 740 */           this.con.close(); } catch (Exception e) {
/* 741 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 744 */       return false;
/*     */     }
/*     */ 
/* 747 */     if (!this.mflag) {
/*     */       try {
/* 749 */         this.con.close(); } catch (Exception e) {
/* 750 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 753 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRiskAppDBSet
 * JD-Core Version:    0.6.0
 */