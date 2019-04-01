/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.LAIndexInfoSchema;
/*     */ import com.sinosoft.map.lis.vschema.LAIndexInfoSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LAIndexInfoDBSet extends LAIndexInfoSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public LAIndexInfoDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "LAIndexInfo");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LAIndexInfoDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("LAIndexInfo");
/*  35 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  40 */     if (this.db.deleteSQL(this))
/*     */     {
/*  42 */       return true;
/*     */     }
/*     */ 
/*  47 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  48 */     CError tError = new CError();
/*  49 */     tError.moduleName = "LAIndexInfoDBSet";
/*  50 */     tError.functionName = "deleteSQL";
/*  51 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  52 */     this.mErrors.addOneError(tError);
/*  53 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  60 */     PreparedStatement pstmt = null;
/*     */ 
/*  62 */     if (!this.mflag) {
/*  63 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  68 */       int tCount = size();
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM LAIndexInfo WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getIndexCalNo() == null) || (get(i).getIndexCalNo().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getIndexCalNo());
/*     */         }
/*  77 */         if ((get(i).getIndexType() == null) || (get(i).getIndexType().equals("null")))
/*  78 */           pstmt.setString(2, null);
/*     */         else {
/*  80 */           pstmt.setString(2, get(i).getIndexType());
/*     */         }
/*  82 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*  83 */           pstmt.setString(3, null);
/*     */         else {
/*  85 */           pstmt.setString(3, get(i).getAgentCode());
/*     */         }
/*  87 */         pstmt.addBatch();
/*     */       }
/*  89 */       pstmt.executeBatch();
/*  90 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  93 */       ex.printStackTrace();
/*  94 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  95 */       CError tError = new CError();
/*  96 */       tError.moduleName = "LAIndexInfoDBSet";
/*  97 */       tError.functionName = "delete()";
/*  98 */       tError.errorMessage = ex.toString();
/*  99 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 102 */         pstmt.close(); } catch (Exception e) {
/* 103 */         e.printStackTrace();
/*     */       }
/* 105 */       if (!this.mflag) {
/*     */         try {
/* 107 */           this.con.close(); } catch (Exception e) {
/* 108 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 111 */       return false;
/*     */     }
/*     */ 
/* 114 */     if (!this.mflag) {
/*     */       try {
/* 116 */         this.con.close(); } catch (Exception e) {
/* 117 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 120 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 126 */     PreparedStatement pstmt = null;
/*     */ 
/* 128 */     if (!this.mflag) {
/* 129 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 134 */       int tCount = size();
/* 135 */       pstmt = this.con.prepareStatement("UPDATE LAIndexInfo SET  IndexCalNo = ? , IndexType = ? , AgentCode = ? , AgentGroup = ? , ManageCom = ? , StartDate = ? , StartEnd = ? , QuaBgnMark = ? , ServerMonths = ? , PostMonths = ? , IndMonthFYC = ? , IndMonthSYC = ? , IndMonSignFYC = ? , IndMonSignAFYC = ? , IndMonSignNAFYC = ? , GrpMonSignNAFYC = ? , MonPolCnt = ? , MontCustCnt = ? , IndMonPCount = ? , SMmonPolContin = ? , SMmonProduct = ? , SMworkMon = ? , MonPCount = ? , WSMMonPCount = ? , LPMonForSMMP = ? , LPMonForAMMP = ? , LPpolContinute = ? , MonEligFLPCnt = ? , TSRmonAFYP = ? , TSRmonDedAFYP = ? , TSRmonCompAFYP = ? , TSRMonWorkDays = ? , MonManPower = ? , MonManCount = ? , MonSAFYPSum = ? , MonTLGrpSAFYPSum = ? , IndYearNAFYC = ? , B12IndEffectAFYC = ? , B12IndAllAFYC = ? , B24IndEffectAFYC = ? , B24IndAllAFYC = ? , IndQutFYC = ? , LPproductivity = ? , LPPPRate = ? , LPPPBonus = ? , LPFincSubsidy = ? , SubsidyRate = ? , B12TeamNAFYC = ? , SMOverride = ? , TeamMonAvgPCount = ? , SMBasicSalary = ? , SMproductivity = ? , SMpolContinute = ? , SMPPRate = ? , SMPPBonus = ? , B24TeamEffectAFYC = ? , B24TeamAllAFYC = ? , TeamQutPremSum = ? , SMRRBonus = ? , SMManPowerDBonus = ? , LPB12ForMPDBonus = ? , SMUsualALLCSum = ? , AMBasicSalary = ? , AMproductivity = ? , AMpolContinute = ? , AMPPRate = ? , AMPPBonus = ? , B12DepNAFYC = ? , AMOverride = ? , DepMonAvgPCount = ? , DepQutPremSum = ? , AMRRBonus = ? , AMManPowerDBonus = ? , ProductGrowth = ? , DepQuaFYCSum = ? , AMLiability = ? , ReviOpen = ? , T1 = ? , T2 = ? , T3 = ? , T4 = ? , T5 = ? , T6 = ? , T7 = ? , T8 = ? , T9 = ? , T10 = ? , T11 = ? , T12 = ? , T13 = ? , T14 = ? , T15 = ? , T16 = ? , T17 = ? , T18 = ? , T20 = ? , T19 = ? , MonthIndex = ? , TMonthIndex = ? , ASumIndex = ? , WSMMonthEligible = ? , LPQuaPCount = ? , LPQuaFYCSum = ? , B12LPPCount = ? , B12LPNAFYCSum = ? , WSMMonAFYC = ? , WSMTwoMonAFYC = ? , WSMB6AFYC = ? , WSMB6PCount = ? , NetLiveLPCount = ? , NetComLPCount = ? , WSMTwoMonPCount = ? , LPAllNAFYC = ? , LPAllPCount = ? , MonPerSAFYP = ? , TSRThrMonSAFYP = ? , TLThrMonPerSAFYP = ? , MonSubsistCnt = ? , ThrMonSubsistCnt = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , AssessMonth = ? , BranchAttr = ? , AgentGrade = ? , ClubPromBonus = ? , ClubGradeBonus = ? , ClubAssisBonus = ? , ClubSpecBonus = ? , AdddedMoney = ? , LastMoney = ? , ShouldMoney = ? , BusinessTax = ? , EduTax = ? , BuildTax = ? , BusiCharge = ? , IncomeTax = ? , SumMoney = ? , AfterTaxMoney = ? , OperInCome = ? , T21 = ? , T22 = ? , T23 = ? , T24 = ? , T25 = ? WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
/* 136 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 138 */         if ((get(i).getIndexCalNo() == null) || (get(i).getIndexCalNo().equals("null")))
/* 139 */           pstmt.setString(1, null);
/*     */         else {
/* 141 */           pstmt.setString(1, get(i).getIndexCalNo());
/*     */         }
/* 143 */         if ((get(i).getIndexType() == null) || (get(i).getIndexType().equals("null")))
/* 144 */           pstmt.setString(2, null);
/*     */         else {
/* 146 */           pstmt.setString(2, get(i).getIndexType());
/*     */         }
/* 148 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 149 */           pstmt.setString(3, null);
/*     */         else {
/* 151 */           pstmt.setString(3, get(i).getAgentCode());
/*     */         }
/* 153 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/* 154 */           pstmt.setString(4, null);
/*     */         else {
/* 156 */           pstmt.setString(4, get(i).getAgentGroup());
/*     */         }
/* 158 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 159 */           pstmt.setString(5, null);
/*     */         else {
/* 161 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 163 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 164 */           pstmt.setDate(6, null);
/*     */         else {
/* 166 */           pstmt.setDate(6, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 168 */         if ((get(i).getStartEnd() == null) || (get(i).getStartEnd().equals("null")))
/* 169 */           pstmt.setDate(7, null);
/*     */         else {
/* 171 */           pstmt.setDate(7, Date.valueOf(get(i).getStartEnd()));
/*     */         }
/* 173 */         pstmt.setInt(8, get(i).getQuaBgnMark());
/* 174 */         pstmt.setInt(9, get(i).getServerMonths());
/* 175 */         pstmt.setInt(10, get(i).getPostMonths());
/* 176 */         pstmt.setDouble(11, get(i).getIndMonthFYC());
/* 177 */         pstmt.setDouble(12, get(i).getIndMonthSYC());
/* 178 */         pstmt.setDouble(13, get(i).getIndMonSignFYC());
/* 179 */         pstmt.setDouble(14, get(i).getIndMonSignAFYC());
/* 180 */         pstmt.setDouble(15, get(i).getIndMonSignNAFYC());
/* 181 */         pstmt.setDouble(16, get(i).getGrpMonSignNAFYC());
/* 182 */         pstmt.setDouble(17, get(i).getMonPolCnt());
/* 183 */         pstmt.setDouble(18, get(i).getMontCustCnt());
/* 184 */         pstmt.setDouble(19, get(i).getIndMonPCount());
/* 185 */         pstmt.setDouble(20, get(i).getSMmonPolContin());
/* 186 */         pstmt.setDouble(21, get(i).getSMmonProduct());
/* 187 */         pstmt.setDouble(22, get(i).getSMworkMon());
/* 188 */         pstmt.setDouble(23, get(i).getMonPCount());
/* 189 */         pstmt.setDouble(24, get(i).getWSMMonPCount());
/* 190 */         pstmt.setDouble(25, get(i).getLPMonForSMMP());
/* 191 */         pstmt.setDouble(26, get(i).getLPMonForAMMP());
/* 192 */         pstmt.setDouble(27, get(i).getLPpolContinute());
/* 193 */         pstmt.setDouble(28, get(i).getMonEligFLPCnt());
/* 194 */         pstmt.setDouble(29, get(i).getTSRmonAFYP());
/* 195 */         pstmt.setDouble(30, get(i).getTSRmonDedAFYP());
/* 196 */         pstmt.setDouble(31, get(i).getTSRmonCompAFYP());
/* 197 */         pstmt.setDouble(32, get(i).getTSRMonWorkDays());
/* 198 */         pstmt.setDouble(33, get(i).getMonManPower());
/* 199 */         pstmt.setDouble(34, get(i).getMonManCount());
/* 200 */         pstmt.setDouble(35, get(i).getMonSAFYPSum());
/* 201 */         pstmt.setDouble(36, get(i).getMonTLGrpSAFYPSum());
/* 202 */         pstmt.setDouble(37, get(i).getIndYearNAFYC());
/* 203 */         pstmt.setDouble(38, get(i).getB12IndEffectAFYC());
/* 204 */         pstmt.setDouble(39, get(i).getB12IndAllAFYC());
/* 205 */         pstmt.setDouble(40, get(i).getB24IndEffectAFYC());
/* 206 */         pstmt.setDouble(41, get(i).getB24IndAllAFYC());
/* 207 */         pstmt.setDouble(42, get(i).getIndQutFYC());
/* 208 */         pstmt.setDouble(43, get(i).getLPproductivity());
/* 209 */         pstmt.setDouble(44, get(i).getLPPPRate());
/* 210 */         pstmt.setDouble(45, get(i).getLPPPBonus());
/* 211 */         pstmt.setDouble(46, get(i).getLPFincSubsidy());
/* 212 */         pstmt.setDouble(47, get(i).getSubsidyRate());
/* 213 */         pstmt.setDouble(48, get(i).getB12TeamNAFYC());
/* 214 */         pstmt.setDouble(49, get(i).getSMOverride());
/* 215 */         pstmt.setDouble(50, get(i).getTeamMonAvgPCount());
/* 216 */         pstmt.setDouble(51, get(i).getSMBasicSalary());
/* 217 */         pstmt.setDouble(52, get(i).getSMproductivity());
/* 218 */         pstmt.setDouble(53, get(i).getSMpolContinute());
/* 219 */         pstmt.setDouble(54, get(i).getSMPPRate());
/* 220 */         pstmt.setDouble(55, get(i).getSMPPBonus());
/* 221 */         pstmt.setDouble(56, get(i).getB24TeamEffectAFYC());
/* 222 */         pstmt.setDouble(57, get(i).getB24TeamAllAFYC());
/* 223 */         pstmt.setDouble(58, get(i).getTeamQutPremSum());
/* 224 */         pstmt.setDouble(59, get(i).getSMRRBonus());
/* 225 */         pstmt.setDouble(60, get(i).getSMManPowerDBonus());
/* 226 */         pstmt.setDouble(61, get(i).getLPB12ForMPDBonus());
/* 227 */         pstmt.setDouble(62, get(i).getSMUsualALLCSum());
/* 228 */         pstmt.setDouble(63, get(i).getAMBasicSalary());
/* 229 */         pstmt.setDouble(64, get(i).getAMproductivity());
/* 230 */         pstmt.setDouble(65, get(i).getAMpolContinute());
/* 231 */         pstmt.setDouble(66, get(i).getAMPPRate());
/* 232 */         pstmt.setDouble(67, get(i).getAMPPBonus());
/* 233 */         pstmt.setDouble(68, get(i).getB12DepNAFYC());
/* 234 */         pstmt.setDouble(69, get(i).getAMOverride());
/* 235 */         pstmt.setDouble(70, get(i).getDepMonAvgPCount());
/* 236 */         pstmt.setDouble(71, get(i).getDepQutPremSum());
/* 237 */         pstmt.setDouble(72, get(i).getAMRRBonus());
/* 238 */         pstmt.setDouble(73, get(i).getAMManPowerDBonus());
/* 239 */         pstmt.setDouble(74, get(i).getProductGrowth());
/* 240 */         pstmt.setDouble(75, get(i).getDepQuaFYCSum());
/* 241 */         pstmt.setDouble(76, get(i).getAMLiability());
/* 242 */         pstmt.setDouble(77, get(i).getReviOpen());
/* 243 */         pstmt.setDouble(78, get(i).getT1());
/* 244 */         pstmt.setDouble(79, get(i).getT2());
/* 245 */         pstmt.setDouble(80, get(i).getT3());
/* 246 */         pstmt.setDouble(81, get(i).getT4());
/* 247 */         pstmt.setDouble(82, get(i).getT5());
/* 248 */         pstmt.setDouble(83, get(i).getT6());
/* 249 */         pstmt.setDouble(84, get(i).getT7());
/* 250 */         pstmt.setDouble(85, get(i).getT8());
/* 251 */         pstmt.setDouble(86, get(i).getT9());
/* 252 */         pstmt.setDouble(87, get(i).getT10());
/* 253 */         pstmt.setDouble(88, get(i).getT11());
/* 254 */         pstmt.setDouble(89, get(i).getT12());
/* 255 */         pstmt.setDouble(90, get(i).getT13());
/* 256 */         pstmt.setDouble(91, get(i).getT14());
/* 257 */         pstmt.setDouble(92, get(i).getT15());
/* 258 */         pstmt.setDouble(93, get(i).getT16());
/* 259 */         pstmt.setDouble(94, get(i).getT17());
/* 260 */         pstmt.setDouble(95, get(i).getT18());
/* 261 */         pstmt.setDouble(96, get(i).getT20());
/* 262 */         pstmt.setDouble(97, get(i).getT19());
/* 263 */         pstmt.setDouble(98, get(i).getMonthIndex());
/* 264 */         pstmt.setDouble(99, get(i).getTMonthIndex());
/* 265 */         pstmt.setDouble(100, get(i).getASumIndex());
/* 266 */         pstmt.setDouble(101, get(i).getWSMMonthEligible());
/* 267 */         pstmt.setDouble(102, get(i).getLPQuaPCount());
/* 268 */         pstmt.setDouble(103, get(i).getLPQuaFYCSum());
/* 269 */         pstmt.setDouble(104, get(i).getB12LPPCount());
/* 270 */         pstmt.setDouble(105, get(i).getB12LPNAFYCSum());
/* 271 */         pstmt.setDouble(106, get(i).getWSMMonAFYC());
/* 272 */         pstmt.setDouble(107, get(i).getWSMTwoMonAFYC());
/* 273 */         pstmt.setDouble(108, get(i).getWSMB6AFYC());
/* 274 */         pstmt.setDouble(109, get(i).getWSMB6PCount());
/* 275 */         pstmt.setDouble(110, get(i).getNetLiveLPCount());
/* 276 */         pstmt.setDouble(111, get(i).getNetComLPCount());
/* 277 */         pstmt.setDouble(112, get(i).getWSMTwoMonPCount());
/* 278 */         pstmt.setDouble(113, get(i).getLPAllNAFYC());
/* 279 */         pstmt.setDouble(114, get(i).getLPAllPCount());
/* 280 */         pstmt.setDouble(115, get(i).getMonPerSAFYP());
/* 281 */         pstmt.setDouble(116, get(i).getTSRThrMonSAFYP());
/* 282 */         pstmt.setDouble(117, get(i).getTLThrMonPerSAFYP());
/* 283 */         pstmt.setDouble(118, get(i).getMonSubsistCnt());
/* 284 */         pstmt.setDouble(119, get(i).getThrMonSubsistCnt());
/* 285 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 286 */           pstmt.setString(120, null);
/*     */         else {
/* 288 */           pstmt.setString(120, get(i).getState());
/*     */         }
/* 290 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 291 */           pstmt.setString(121, null);
/*     */         else {
/* 293 */           pstmt.setString(121, get(i).getOperator());
/*     */         }
/* 295 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 296 */           pstmt.setDate(122, null);
/*     */         else {
/* 298 */           pstmt.setDate(122, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 300 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 301 */           pstmt.setString(123, null);
/*     */         else {
/* 303 */           pstmt.setString(123, get(i).getMakeTime());
/*     */         }
/* 305 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 306 */           pstmt.setDate(124, null);
/*     */         else {
/* 308 */           pstmt.setDate(124, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 310 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 311 */           pstmt.setString(125, null);
/*     */         else {
/* 313 */           pstmt.setString(125, get(i).getModifyTime());
/*     */         }
/* 315 */         if ((get(i).getAssessMonth() == null) || (get(i).getAssessMonth().equals("null")))
/* 316 */           pstmt.setString(126, null);
/*     */         else {
/* 318 */           pstmt.setString(126, get(i).getAssessMonth());
/*     */         }
/* 320 */         if ((get(i).getBranchAttr() == null) || (get(i).getBranchAttr().equals("null")))
/* 321 */           pstmt.setString(127, null);
/*     */         else {
/* 323 */           pstmt.setString(127, get(i).getBranchAttr());
/*     */         }
/* 325 */         if ((get(i).getAgentGrade() == null) || (get(i).getAgentGrade().equals("null")))
/* 326 */           pstmt.setString(128, null);
/*     */         else {
/* 328 */           pstmt.setString(128, get(i).getAgentGrade());
/*     */         }
/* 330 */         pstmt.setDouble(129, get(i).getClubPromBonus());
/* 331 */         pstmt.setDouble(130, get(i).getClubGradeBonus());
/* 332 */         pstmt.setDouble(131, get(i).getClubAssisBonus());
/* 333 */         pstmt.setDouble(132, get(i).getClubSpecBonus());
/* 334 */         pstmt.setDouble(133, get(i).getAdddedMoney());
/* 335 */         pstmt.setDouble(134, get(i).getLastMoney());
/* 336 */         pstmt.setDouble(135, get(i).getShouldMoney());
/* 337 */         pstmt.setDouble(136, get(i).getBusinessTax());
/* 338 */         pstmt.setDouble(137, get(i).getEduTax());
/* 339 */         pstmt.setDouble(138, get(i).getBuildTax());
/* 340 */         pstmt.setDouble(139, get(i).getBusiCharge());
/* 341 */         pstmt.setDouble(140, get(i).getIncomeTax());
/* 342 */         pstmt.setDouble(141, get(i).getSumMoney());
/* 343 */         pstmt.setDouble(142, get(i).getAfterTaxMoney());
/* 344 */         pstmt.setDouble(143, get(i).getOperInCome());
/* 345 */         pstmt.setDouble(144, get(i).getT21());
/* 346 */         pstmt.setDouble(145, get(i).getT22());
/* 347 */         pstmt.setDouble(146, get(i).getT23());
/* 348 */         pstmt.setDouble(147, get(i).getT24());
/* 349 */         pstmt.setDouble(148, get(i).getT25());
/*     */ 
/* 351 */         if ((get(i).getIndexCalNo() == null) || (get(i).getIndexCalNo().equals("null")))
/* 352 */           pstmt.setString(149, null);
/*     */         else {
/* 354 */           pstmt.setString(149, get(i).getIndexCalNo());
/*     */         }
/* 356 */         if ((get(i).getIndexType() == null) || (get(i).getIndexType().equals("null")))
/* 357 */           pstmt.setString(150, null);
/*     */         else {
/* 359 */           pstmt.setString(150, get(i).getIndexType());
/*     */         }
/* 361 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 362 */           pstmt.setString(151, null);
/*     */         else {
/* 364 */           pstmt.setString(151, get(i).getAgentCode());
/*     */         }
/* 366 */         pstmt.addBatch();
/*     */       }
/* 368 */       pstmt.executeBatch();
/* 369 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 372 */       ex.printStackTrace();
/* 373 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 374 */       CError tError = new CError();
/* 375 */       tError.moduleName = "LAIndexInfoDBSet";
/* 376 */       tError.functionName = "update()";
/* 377 */       tError.errorMessage = ex.toString();
/* 378 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 381 */         pstmt.close(); } catch (Exception e) {
/* 382 */         e.printStackTrace();
/*     */       }
/* 384 */       if (!this.mflag) {
/*     */         try {
/* 386 */           this.con.close(); } catch (Exception e) {
/* 387 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 390 */       return false;
/*     */     }
/*     */ 
/* 393 */     if (!this.mflag) {
/*     */       try {
/* 395 */         this.con.close(); } catch (Exception e) {
/* 396 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 399 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 405 */     PreparedStatement pstmt = null;
/*     */ 
/* 407 */     if (!this.mflag) {
/* 408 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 413 */       int tCount = size();
/* 414 */       pstmt = this.con.prepareStatement("INSERT INTO LAIndexInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 415 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 417 */         if ((get(i).getIndexCalNo() == null) || (get(i).getIndexCalNo().equals("null")))
/* 418 */           pstmt.setString(1, null);
/*     */         else {
/* 420 */           pstmt.setString(1, get(i).getIndexCalNo());
/*     */         }
/* 422 */         if ((get(i).getIndexType() == null) || (get(i).getIndexType().equals("null")))
/* 423 */           pstmt.setString(2, null);
/*     */         else {
/* 425 */           pstmt.setString(2, get(i).getIndexType());
/*     */         }
/* 427 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 428 */           pstmt.setString(3, null);
/*     */         else {
/* 430 */           pstmt.setString(3, get(i).getAgentCode());
/*     */         }
/* 432 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/* 433 */           pstmt.setString(4, null);
/*     */         else {
/* 435 */           pstmt.setString(4, get(i).getAgentGroup());
/*     */         }
/* 437 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 438 */           pstmt.setString(5, null);
/*     */         else {
/* 440 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 442 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 443 */           pstmt.setDate(6, null);
/*     */         else {
/* 445 */           pstmt.setDate(6, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 447 */         if ((get(i).getStartEnd() == null) || (get(i).getStartEnd().equals("null")))
/* 448 */           pstmt.setDate(7, null);
/*     */         else {
/* 450 */           pstmt.setDate(7, Date.valueOf(get(i).getStartEnd()));
/*     */         }
/* 452 */         pstmt.setInt(8, get(i).getQuaBgnMark());
/* 453 */         pstmt.setInt(9, get(i).getServerMonths());
/* 454 */         pstmt.setInt(10, get(i).getPostMonths());
/* 455 */         pstmt.setDouble(11, get(i).getIndMonthFYC());
/* 456 */         pstmt.setDouble(12, get(i).getIndMonthSYC());
/* 457 */         pstmt.setDouble(13, get(i).getIndMonSignFYC());
/* 458 */         pstmt.setDouble(14, get(i).getIndMonSignAFYC());
/* 459 */         pstmt.setDouble(15, get(i).getIndMonSignNAFYC());
/* 460 */         pstmt.setDouble(16, get(i).getGrpMonSignNAFYC());
/* 461 */         pstmt.setDouble(17, get(i).getMonPolCnt());
/* 462 */         pstmt.setDouble(18, get(i).getMontCustCnt());
/* 463 */         pstmt.setDouble(19, get(i).getIndMonPCount());
/* 464 */         pstmt.setDouble(20, get(i).getSMmonPolContin());
/* 465 */         pstmt.setDouble(21, get(i).getSMmonProduct());
/* 466 */         pstmt.setDouble(22, get(i).getSMworkMon());
/* 467 */         pstmt.setDouble(23, get(i).getMonPCount());
/* 468 */         pstmt.setDouble(24, get(i).getWSMMonPCount());
/* 469 */         pstmt.setDouble(25, get(i).getLPMonForSMMP());
/* 470 */         pstmt.setDouble(26, get(i).getLPMonForAMMP());
/* 471 */         pstmt.setDouble(27, get(i).getLPpolContinute());
/* 472 */         pstmt.setDouble(28, get(i).getMonEligFLPCnt());
/* 473 */         pstmt.setDouble(29, get(i).getTSRmonAFYP());
/* 474 */         pstmt.setDouble(30, get(i).getTSRmonDedAFYP());
/* 475 */         pstmt.setDouble(31, get(i).getTSRmonCompAFYP());
/* 476 */         pstmt.setDouble(32, get(i).getTSRMonWorkDays());
/* 477 */         pstmt.setDouble(33, get(i).getMonManPower());
/* 478 */         pstmt.setDouble(34, get(i).getMonManCount());
/* 479 */         pstmt.setDouble(35, get(i).getMonSAFYPSum());
/* 480 */         pstmt.setDouble(36, get(i).getMonTLGrpSAFYPSum());
/* 481 */         pstmt.setDouble(37, get(i).getIndYearNAFYC());
/* 482 */         pstmt.setDouble(38, get(i).getB12IndEffectAFYC());
/* 483 */         pstmt.setDouble(39, get(i).getB12IndAllAFYC());
/* 484 */         pstmt.setDouble(40, get(i).getB24IndEffectAFYC());
/* 485 */         pstmt.setDouble(41, get(i).getB24IndAllAFYC());
/* 486 */         pstmt.setDouble(42, get(i).getIndQutFYC());
/* 487 */         pstmt.setDouble(43, get(i).getLPproductivity());
/* 488 */         pstmt.setDouble(44, get(i).getLPPPRate());
/* 489 */         pstmt.setDouble(45, get(i).getLPPPBonus());
/* 490 */         pstmt.setDouble(46, get(i).getLPFincSubsidy());
/* 491 */         pstmt.setDouble(47, get(i).getSubsidyRate());
/* 492 */         pstmt.setDouble(48, get(i).getB12TeamNAFYC());
/* 493 */         pstmt.setDouble(49, get(i).getSMOverride());
/* 494 */         pstmt.setDouble(50, get(i).getTeamMonAvgPCount());
/* 495 */         pstmt.setDouble(51, get(i).getSMBasicSalary());
/* 496 */         pstmt.setDouble(52, get(i).getSMproductivity());
/* 497 */         pstmt.setDouble(53, get(i).getSMpolContinute());
/* 498 */         pstmt.setDouble(54, get(i).getSMPPRate());
/* 499 */         pstmt.setDouble(55, get(i).getSMPPBonus());
/* 500 */         pstmt.setDouble(56, get(i).getB24TeamEffectAFYC());
/* 501 */         pstmt.setDouble(57, get(i).getB24TeamAllAFYC());
/* 502 */         pstmt.setDouble(58, get(i).getTeamQutPremSum());
/* 503 */         pstmt.setDouble(59, get(i).getSMRRBonus());
/* 504 */         pstmt.setDouble(60, get(i).getSMManPowerDBonus());
/* 505 */         pstmt.setDouble(61, get(i).getLPB12ForMPDBonus());
/* 506 */         pstmt.setDouble(62, get(i).getSMUsualALLCSum());
/* 507 */         pstmt.setDouble(63, get(i).getAMBasicSalary());
/* 508 */         pstmt.setDouble(64, get(i).getAMproductivity());
/* 509 */         pstmt.setDouble(65, get(i).getAMpolContinute());
/* 510 */         pstmt.setDouble(66, get(i).getAMPPRate());
/* 511 */         pstmt.setDouble(67, get(i).getAMPPBonus());
/* 512 */         pstmt.setDouble(68, get(i).getB12DepNAFYC());
/* 513 */         pstmt.setDouble(69, get(i).getAMOverride());
/* 514 */         pstmt.setDouble(70, get(i).getDepMonAvgPCount());
/* 515 */         pstmt.setDouble(71, get(i).getDepQutPremSum());
/* 516 */         pstmt.setDouble(72, get(i).getAMRRBonus());
/* 517 */         pstmt.setDouble(73, get(i).getAMManPowerDBonus());
/* 518 */         pstmt.setDouble(74, get(i).getProductGrowth());
/* 519 */         pstmt.setDouble(75, get(i).getDepQuaFYCSum());
/* 520 */         pstmt.setDouble(76, get(i).getAMLiability());
/* 521 */         pstmt.setDouble(77, get(i).getReviOpen());
/* 522 */         pstmt.setDouble(78, get(i).getT1());
/* 523 */         pstmt.setDouble(79, get(i).getT2());
/* 524 */         pstmt.setDouble(80, get(i).getT3());
/* 525 */         pstmt.setDouble(81, get(i).getT4());
/* 526 */         pstmt.setDouble(82, get(i).getT5());
/* 527 */         pstmt.setDouble(83, get(i).getT6());
/* 528 */         pstmt.setDouble(84, get(i).getT7());
/* 529 */         pstmt.setDouble(85, get(i).getT8());
/* 530 */         pstmt.setDouble(86, get(i).getT9());
/* 531 */         pstmt.setDouble(87, get(i).getT10());
/* 532 */         pstmt.setDouble(88, get(i).getT11());
/* 533 */         pstmt.setDouble(89, get(i).getT12());
/* 534 */         pstmt.setDouble(90, get(i).getT13());
/* 535 */         pstmt.setDouble(91, get(i).getT14());
/* 536 */         pstmt.setDouble(92, get(i).getT15());
/* 537 */         pstmt.setDouble(93, get(i).getT16());
/* 538 */         pstmt.setDouble(94, get(i).getT17());
/* 539 */         pstmt.setDouble(95, get(i).getT18());
/* 540 */         pstmt.setDouble(96, get(i).getT20());
/* 541 */         pstmt.setDouble(97, get(i).getT19());
/* 542 */         pstmt.setDouble(98, get(i).getMonthIndex());
/* 543 */         pstmt.setDouble(99, get(i).getTMonthIndex());
/* 544 */         pstmt.setDouble(100, get(i).getASumIndex());
/* 545 */         pstmt.setDouble(101, get(i).getWSMMonthEligible());
/* 546 */         pstmt.setDouble(102, get(i).getLPQuaPCount());
/* 547 */         pstmt.setDouble(103, get(i).getLPQuaFYCSum());
/* 548 */         pstmt.setDouble(104, get(i).getB12LPPCount());
/* 549 */         pstmt.setDouble(105, get(i).getB12LPNAFYCSum());
/* 550 */         pstmt.setDouble(106, get(i).getWSMMonAFYC());
/* 551 */         pstmt.setDouble(107, get(i).getWSMTwoMonAFYC());
/* 552 */         pstmt.setDouble(108, get(i).getWSMB6AFYC());
/* 553 */         pstmt.setDouble(109, get(i).getWSMB6PCount());
/* 554 */         pstmt.setDouble(110, get(i).getNetLiveLPCount());
/* 555 */         pstmt.setDouble(111, get(i).getNetComLPCount());
/* 556 */         pstmt.setDouble(112, get(i).getWSMTwoMonPCount());
/* 557 */         pstmt.setDouble(113, get(i).getLPAllNAFYC());
/* 558 */         pstmt.setDouble(114, get(i).getLPAllPCount());
/* 559 */         pstmt.setDouble(115, get(i).getMonPerSAFYP());
/* 560 */         pstmt.setDouble(116, get(i).getTSRThrMonSAFYP());
/* 561 */         pstmt.setDouble(117, get(i).getTLThrMonPerSAFYP());
/* 562 */         pstmt.setDouble(118, get(i).getMonSubsistCnt());
/* 563 */         pstmt.setDouble(119, get(i).getThrMonSubsistCnt());
/* 564 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 565 */           pstmt.setString(120, null);
/*     */         else {
/* 567 */           pstmt.setString(120, get(i).getState());
/*     */         }
/* 569 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 570 */           pstmt.setString(121, null);
/*     */         else {
/* 572 */           pstmt.setString(121, get(i).getOperator());
/*     */         }
/* 574 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 575 */           pstmt.setDate(122, null);
/*     */         else {
/* 577 */           pstmt.setDate(122, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 579 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 580 */           pstmt.setString(123, null);
/*     */         else {
/* 582 */           pstmt.setString(123, get(i).getMakeTime());
/*     */         }
/* 584 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 585 */           pstmt.setDate(124, null);
/*     */         else {
/* 587 */           pstmt.setDate(124, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 589 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 590 */           pstmt.setString(125, null);
/*     */         else {
/* 592 */           pstmt.setString(125, get(i).getModifyTime());
/*     */         }
/* 594 */         if ((get(i).getAssessMonth() == null) || (get(i).getAssessMonth().equals("null")))
/* 595 */           pstmt.setString(126, null);
/*     */         else {
/* 597 */           pstmt.setString(126, get(i).getAssessMonth());
/*     */         }
/* 599 */         if ((get(i).getBranchAttr() == null) || (get(i).getBranchAttr().equals("null")))
/* 600 */           pstmt.setString(127, null);
/*     */         else {
/* 602 */           pstmt.setString(127, get(i).getBranchAttr());
/*     */         }
/* 604 */         if ((get(i).getAgentGrade() == null) || (get(i).getAgentGrade().equals("null")))
/* 605 */           pstmt.setString(128, null);
/*     */         else {
/* 607 */           pstmt.setString(128, get(i).getAgentGrade());
/*     */         }
/* 609 */         pstmt.setDouble(129, get(i).getClubPromBonus());
/* 610 */         pstmt.setDouble(130, get(i).getClubGradeBonus());
/* 611 */         pstmt.setDouble(131, get(i).getClubAssisBonus());
/* 612 */         pstmt.setDouble(132, get(i).getClubSpecBonus());
/* 613 */         pstmt.setDouble(133, get(i).getAdddedMoney());
/* 614 */         pstmt.setDouble(134, get(i).getLastMoney());
/* 615 */         pstmt.setDouble(135, get(i).getShouldMoney());
/* 616 */         pstmt.setDouble(136, get(i).getBusinessTax());
/* 617 */         pstmt.setDouble(137, get(i).getEduTax());
/* 618 */         pstmt.setDouble(138, get(i).getBuildTax());
/* 619 */         pstmt.setDouble(139, get(i).getBusiCharge());
/* 620 */         pstmt.setDouble(140, get(i).getIncomeTax());
/* 621 */         pstmt.setDouble(141, get(i).getSumMoney());
/* 622 */         pstmt.setDouble(142, get(i).getAfterTaxMoney());
/* 623 */         pstmt.setDouble(143, get(i).getOperInCome());
/* 624 */         pstmt.setDouble(144, get(i).getT21());
/* 625 */         pstmt.setDouble(145, get(i).getT22());
/* 626 */         pstmt.setDouble(146, get(i).getT23());
/* 627 */         pstmt.setDouble(147, get(i).getT24());
/* 628 */         pstmt.setDouble(148, get(i).getT25());
/* 629 */         pstmt.addBatch();
/*     */       }
/* 631 */       pstmt.executeBatch();
/* 632 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 635 */       ex.printStackTrace();
/* 636 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 637 */       CError tError = new CError();
/* 638 */       tError.moduleName = "LAIndexInfoDBSet";
/* 639 */       tError.functionName = "insert()";
/* 640 */       tError.errorMessage = ex.toString();
/* 641 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 644 */         pstmt.close(); } catch (Exception e) {
/* 645 */         e.printStackTrace();
/*     */       }
/* 647 */       if (!this.mflag) {
/*     */         try {
/* 649 */           this.con.close(); } catch (Exception e) {
/* 650 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 653 */       return false;
/*     */     }
/*     */ 
/* 656 */     if (!this.mflag) {
/*     */       try {
/* 658 */         this.con.close(); } catch (Exception e) {
/* 659 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 662 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.LAIndexInfoDBSet
 * JD-Core Version:    0.6.0
 */