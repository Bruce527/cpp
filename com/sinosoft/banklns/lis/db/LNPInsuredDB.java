/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import com.sinosoft.banklns.utility.SQLString;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class LNPInsuredDB extends LNPInsuredSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   22 */   private boolean mflag = false;
/*      */ 
/*   24 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   27 */   private ResultSet mResultSet = null;
/*   28 */   private Statement mStatement = null;
/*      */ 
/*      */   public LNPInsuredDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPInsured");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPInsuredDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPInsured");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPInsuredSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPInsuredDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPInsuredSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPInsuredDB";
/*   76 */       tError.functionName = "getCount";
/*   77 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   78 */       this.mErrors.addOneError(tError);
/*      */ 
/*   80 */       return -1;
/*      */     }
/*      */ 
/*   83 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   88 */     PreparedStatement pstmt = null;
/*      */ 
/*   90 */     if (!this.mflag) {
/*   91 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPInsured WHERE  ContNo = ? AND InsuredId = ?");
/*   97 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getContNo());
/*      */       }
/*  102 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getInsuredId());
/*      */       }
/*  107 */       pstmt.executeUpdate();
/*  108 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  111 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  112 */       CError tError = new CError();
/*  113 */       tError.moduleName = "LNPInsuredDB";
/*  114 */       tError.functionName = "delete()";
/*  115 */       tError.errorMessage = ex.toString();
/*  116 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  119 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  122 */       if (!this.mflag)
/*      */         try {
/*  124 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  128 */       return false;
/*      */     }
/*      */ 
/*  131 */     if (!this.mflag)
/*      */       try {
/*  133 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  137 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  142 */     PreparedStatement pstmt = null;
/*      */ 
/*  144 */     if (!this.mflag) {
/*  145 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  150 */       pstmt = this.con.prepareStatement("UPDATE LNPInsured SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , InsuredNo = ? , InsuredId = ? , PrtNo = ? , AppntNo = ? , AppntId = ? , ManageCom = ? , SignCity = ? , ExecuteCom = ? , FamilyID = ? , RelationToMainInsured = ? , RelationToAppnt = ? , AddressNo = ? , SequenceNo = ? , Name = ? , Appellation = ? , Sex = ? , Birthday = ? , AppAge = ? , AppAgeType = ? , IDType = ? , IDNo = ? , IDValidity = ? , IDPerpetual = ? , NativePlace = ? , Nationality = ? , RgtAddress = ? , Marriage = ? , MarriageDate = ? , Health = ? , Stature = ? , Avoirdupois = ? , Degree = ? , CreditGrade = ? , BankCode = ? , BankAccNo = ? , AccName = ? , JoinCompanyDate = ? , StartWorkDate = ? , Position = ? , Salary = ? , OccupationType = ? , OccupationCode = ? , PartOccupationType = ? , PartOccupationCode = ? , WorkType = ? , PluralityType = ? , SmokeFlag = ? , ContPlanCode = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , InsuredPeoples = ? WHERE  ContNo = ? AND InsuredId = ?");
/*  151 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  152 */         pstmt.setNull(1, 12);
/*      */       else {
/*  154 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  156 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  157 */         pstmt.setNull(2, 12);
/*      */       else {
/*  159 */         pstmt.setString(2, getContNo());
/*      */       }
/*  161 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  162 */         pstmt.setNull(3, 12);
/*      */       else {
/*  164 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  166 */       if ((getInsuredNo() == null) || (getInsuredNo().equals("null")))
/*  167 */         pstmt.setNull(4, 12);
/*      */       else {
/*  169 */         pstmt.setString(4, getInsuredNo());
/*      */       }
/*  171 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  172 */         pstmt.setNull(5, 12);
/*      */       else {
/*  174 */         pstmt.setString(5, getInsuredId());
/*      */       }
/*  176 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  177 */         pstmt.setNull(6, 12);
/*      */       else {
/*  179 */         pstmt.setString(6, getPrtNo());
/*      */       }
/*  181 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  182 */         pstmt.setNull(7, 12);
/*      */       else {
/*  184 */         pstmt.setString(7, getAppntNo());
/*      */       }
/*  186 */       if ((getAppntId() == null) || (getAppntId().equals("null")))
/*  187 */         pstmt.setNull(8, 12);
/*      */       else {
/*  189 */         pstmt.setString(8, getAppntId());
/*      */       }
/*  191 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  192 */         pstmt.setNull(9, 12);
/*      */       else {
/*  194 */         pstmt.setString(9, getManageCom());
/*      */       }
/*  196 */       if ((getSignCity() == null) || (getSignCity().equals("null")))
/*  197 */         pstmt.setNull(10, 12);
/*      */       else {
/*  199 */         pstmt.setString(10, getSignCity());
/*      */       }
/*  201 */       if ((getExecuteCom() == null) || (getExecuteCom().equals("null")))
/*  202 */         pstmt.setNull(11, 12);
/*      */       else {
/*  204 */         pstmt.setString(11, getExecuteCom());
/*      */       }
/*  206 */       if ((getFamilyID() == null) || (getFamilyID().equals("null")))
/*  207 */         pstmt.setNull(12, 12);
/*      */       else {
/*  209 */         pstmt.setString(12, getFamilyID());
/*      */       }
/*  211 */       if ((getRelationToMainInsured() == null) || (getRelationToMainInsured().equals("null")))
/*  212 */         pstmt.setNull(13, 12);
/*      */       else {
/*  214 */         pstmt.setString(13, getRelationToMainInsured());
/*      */       }
/*  216 */       if ((getRelationToAppnt() == null) || (getRelationToAppnt().equals("null")))
/*  217 */         pstmt.setNull(14, 12);
/*      */       else {
/*  219 */         pstmt.setString(14, getRelationToAppnt());
/*      */       }
/*  221 */       if ((getAddressNo() == null) || (getAddressNo().equals("null")))
/*  222 */         pstmt.setNull(15, 12);
/*      */       else {
/*  224 */         pstmt.setString(15, getAddressNo());
/*      */       }
/*  226 */       if ((getSequenceNo() == null) || (getSequenceNo().equals("null")))
/*  227 */         pstmt.setNull(16, 12);
/*      */       else {
/*  229 */         pstmt.setString(16, getSequenceNo());
/*      */       }
/*  231 */       if ((getName() == null) || (getName().equals("null")))
/*  232 */         pstmt.setNull(17, 12);
/*      */       else {
/*  234 */         pstmt.setString(17, getName());
/*      */       }
/*  236 */       if ((getAppellation() == null) || (getAppellation().equals("null")))
/*  237 */         pstmt.setNull(18, 12);
/*      */       else {
/*  239 */         pstmt.setString(18, getAppellation());
/*      */       }
/*  241 */       if ((getSex() == null) || (getSex().equals("null")))
/*  242 */         pstmt.setNull(19, 12);
/*      */       else {
/*  244 */         pstmt.setString(19, getSex());
/*      */       }
/*  246 */       if ((getBirthday() == null) || (getBirthday().equals("null")))
/*  247 */         pstmt.setNull(20, 91);
/*      */       else {
/*  249 */         pstmt.setDate(20, Date.valueOf(getBirthday()));
/*      */       }
/*  251 */       pstmt.setInt(21, getAppAge());
/*  252 */       if ((getAppAgeType() == null) || (getAppAgeType().equals("null")))
/*  253 */         pstmt.setNull(22, 12);
/*      */       else {
/*  255 */         pstmt.setString(22, getAppAgeType());
/*      */       }
/*  257 */       if ((getIDType() == null) || (getIDType().equals("null")))
/*  258 */         pstmt.setNull(23, 12);
/*      */       else {
/*  260 */         pstmt.setString(23, getIDType());
/*      */       }
/*  262 */       if ((getIDNo() == null) || (getIDNo().equals("null")))
/*  263 */         pstmt.setNull(24, 12);
/*      */       else {
/*  265 */         pstmt.setString(24, getIDNo());
/*      */       }
/*  267 */       if ((getIDValidity() == null) || (getIDValidity().equals("null")))
/*  268 */         pstmt.setNull(25, 91);
/*      */       else {
/*  270 */         pstmt.setDate(25, Date.valueOf(getIDValidity()));
/*      */       }
/*  272 */       if ((getIDPerpetual() == null) || (getIDPerpetual().equals("null")))
/*  273 */         pstmt.setNull(26, 12);
/*      */       else {
/*  275 */         pstmt.setString(26, getIDPerpetual());
/*      */       }
/*  277 */       if ((getNativePlace() == null) || (getNativePlace().equals("null")))
/*  278 */         pstmt.setNull(27, 12);
/*      */       else {
/*  280 */         pstmt.setString(27, getNativePlace());
/*      */       }
/*  282 */       if ((getNationality() == null) || (getNationality().equals("null")))
/*  283 */         pstmt.setNull(28, 12);
/*      */       else {
/*  285 */         pstmt.setString(28, getNationality());
/*      */       }
/*  287 */       if ((getRgtAddress() == null) || (getRgtAddress().equals("null")))
/*  288 */         pstmt.setNull(29, 12);
/*      */       else {
/*  290 */         pstmt.setString(29, getRgtAddress());
/*      */       }
/*  292 */       if ((getMarriage() == null) || (getMarriage().equals("null")))
/*  293 */         pstmt.setNull(30, 12);
/*      */       else {
/*  295 */         pstmt.setString(30, getMarriage());
/*      */       }
/*  297 */       if ((getMarriageDate() == null) || (getMarriageDate().equals("null")))
/*  298 */         pstmt.setNull(31, 91);
/*      */       else {
/*  300 */         pstmt.setDate(31, Date.valueOf(getMarriageDate()));
/*      */       }
/*  302 */       if ((getHealth() == null) || (getHealth().equals("null")))
/*  303 */         pstmt.setNull(32, 12);
/*      */       else {
/*  305 */         pstmt.setString(32, getHealth());
/*      */       }
/*  307 */       pstmt.setDouble(33, getStature());
/*  308 */       pstmt.setDouble(34, getAvoirdupois());
/*  309 */       if ((getDegree() == null) || (getDegree().equals("null")))
/*  310 */         pstmt.setNull(35, 12);
/*      */       else {
/*  312 */         pstmt.setString(35, getDegree());
/*      */       }
/*  314 */       if ((getCreditGrade() == null) || (getCreditGrade().equals("null")))
/*  315 */         pstmt.setNull(36, 12);
/*      */       else {
/*  317 */         pstmt.setString(36, getCreditGrade());
/*      */       }
/*  319 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  320 */         pstmt.setNull(37, 12);
/*      */       else {
/*  322 */         pstmt.setString(37, getBankCode());
/*      */       }
/*  324 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  325 */         pstmt.setNull(38, 12);
/*      */       else {
/*  327 */         pstmt.setString(38, getBankAccNo());
/*      */       }
/*  329 */       if ((getAccName() == null) || (getAccName().equals("null")))
/*  330 */         pstmt.setNull(39, 12);
/*      */       else {
/*  332 */         pstmt.setString(39, getAccName());
/*      */       }
/*  334 */       if ((getJoinCompanyDate() == null) || (getJoinCompanyDate().equals("null")))
/*  335 */         pstmt.setNull(40, 91);
/*      */       else {
/*  337 */         pstmt.setDate(40, Date.valueOf(getJoinCompanyDate()));
/*      */       }
/*  339 */       if ((getStartWorkDate() == null) || (getStartWorkDate().equals("null")))
/*  340 */         pstmt.setNull(41, 91);
/*      */       else {
/*  342 */         pstmt.setDate(41, Date.valueOf(getStartWorkDate()));
/*      */       }
/*  344 */       if ((getPosition() == null) || (getPosition().equals("null")))
/*  345 */         pstmt.setNull(42, 12);
/*      */       else {
/*  347 */         pstmt.setString(42, getPosition());
/*      */       }
/*  349 */       pstmt.setDouble(43, getSalary());
/*  350 */       if ((getOccupationType() == null) || (getOccupationType().equals("null")))
/*  351 */         pstmt.setNull(44, 12);
/*      */       else {
/*  353 */         pstmt.setString(44, getOccupationType());
/*      */       }
/*  355 */       if ((getOccupationCode() == null) || (getOccupationCode().equals("null")))
/*  356 */         pstmt.setNull(45, 12);
/*      */       else {
/*  358 */         pstmt.setString(45, getOccupationCode());
/*      */       }
/*  360 */       if ((getPartOccupationType() == null) || (getPartOccupationType().equals("null")))
/*  361 */         pstmt.setNull(46, 12);
/*      */       else {
/*  363 */         pstmt.setString(46, getPartOccupationType());
/*      */       }
/*  365 */       if ((getPartOccupationCode() == null) || (getPartOccupationCode().equals("null")))
/*  366 */         pstmt.setNull(47, 12);
/*      */       else {
/*  368 */         pstmt.setString(47, getPartOccupationCode());
/*      */       }
/*  370 */       if ((getWorkType() == null) || (getWorkType().equals("null")))
/*  371 */         pstmt.setNull(48, 12);
/*      */       else {
/*  373 */         pstmt.setString(48, getWorkType());
/*      */       }
/*  375 */       if ((getPluralityType() == null) || (getPluralityType().equals("null")))
/*  376 */         pstmt.setNull(49, 12);
/*      */       else {
/*  378 */         pstmt.setString(49, getPluralityType());
/*      */       }
/*  380 */       if ((getSmokeFlag() == null) || (getSmokeFlag().equals("null")))
/*  381 */         pstmt.setNull(50, 12);
/*      */       else {
/*  383 */         pstmt.setString(50, getSmokeFlag());
/*      */       }
/*  385 */       if ((getContPlanCode() == null) || (getContPlanCode().equals("null")))
/*  386 */         pstmt.setNull(51, 12);
/*      */       else {
/*  388 */         pstmt.setString(51, getContPlanCode());
/*      */       }
/*  390 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  391 */         pstmt.setNull(52, 12);
/*      */       else {
/*  393 */         pstmt.setString(52, getOperator());
/*      */       }
/*  395 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  396 */         pstmt.setNull(53, 91);
/*      */       else {
/*  398 */         pstmt.setDate(53, Date.valueOf(getMakeDate()));
/*      */       }
/*  400 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  401 */         pstmt.setNull(54, 12);
/*      */       else {
/*  403 */         pstmt.setString(54, getMakeTime());
/*      */       }
/*  405 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  406 */         pstmt.setNull(55, 91);
/*      */       else {
/*  408 */         pstmt.setDate(55, Date.valueOf(getModifyDate()));
/*      */       }
/*  410 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  411 */         pstmt.setNull(56, 12);
/*      */       else {
/*  413 */         pstmt.setString(56, getModifyTime());
/*      */       }
/*  415 */       pstmt.setInt(57, getInsuredPeoples());
/*      */ 
/*  417 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  418 */         pstmt.setNull(58, 12);
/*      */       else {
/*  420 */         pstmt.setString(58, getContNo());
/*      */       }
/*  422 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  423 */         pstmt.setNull(59, 12);
/*      */       else {
/*  425 */         pstmt.setString(59, getInsuredId());
/*      */       }
/*  427 */       pstmt.executeUpdate();
/*  428 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  431 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  432 */       CError tError = new CError();
/*  433 */       tError.moduleName = "LNPInsuredDB";
/*  434 */       tError.functionName = "update()";
/*  435 */       tError.errorMessage = ex.toString();
/*  436 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  439 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  442 */       if (!this.mflag)
/*      */         try {
/*  444 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  448 */       return false;
/*      */     }
/*      */ 
/*  451 */     if (!this.mflag)
/*      */       try {
/*  453 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  457 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  462 */     PreparedStatement pstmt = null;
/*      */ 
/*  464 */     if (!this.mflag) {
/*  465 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  470 */       pstmt = this.con.prepareStatement("INSERT INTO LNPInsured VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  471 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  472 */         pstmt.setNull(1, 12);
/*      */       else {
/*  474 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  476 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  477 */         pstmt.setNull(2, 12);
/*      */       else {
/*  479 */         pstmt.setString(2, getContNo());
/*      */       }
/*  481 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  482 */         pstmt.setNull(3, 12);
/*      */       else {
/*  484 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  486 */       if ((getInsuredNo() == null) || (getInsuredNo().equals("null")))
/*  487 */         pstmt.setNull(4, 12);
/*      */       else {
/*  489 */         pstmt.setString(4, getInsuredNo());
/*      */       }
/*  491 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  492 */         pstmt.setNull(5, 12);
/*      */       else {
/*  494 */         pstmt.setString(5, getInsuredId());
/*      */       }
/*  496 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  497 */         pstmt.setNull(6, 12);
/*      */       else {
/*  499 */         pstmt.setString(6, getPrtNo());
/*      */       }
/*  501 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  502 */         pstmt.setNull(7, 12);
/*      */       else {
/*  504 */         pstmt.setString(7, getAppntNo());
/*      */       }
/*  506 */       if ((getAppntId() == null) || (getAppntId().equals("null")))
/*  507 */         pstmt.setNull(8, 12);
/*      */       else {
/*  509 */         pstmt.setString(8, getAppntId());
/*      */       }
/*  511 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  512 */         pstmt.setNull(9, 12);
/*      */       else {
/*  514 */         pstmt.setString(9, getManageCom());
/*      */       }
/*  516 */       if ((getSignCity() == null) || (getSignCity().equals("null")))
/*  517 */         pstmt.setNull(10, 12);
/*      */       else {
/*  519 */         pstmt.setString(10, getSignCity());
/*      */       }
/*  521 */       if ((getExecuteCom() == null) || (getExecuteCom().equals("null")))
/*  522 */         pstmt.setNull(11, 12);
/*      */       else {
/*  524 */         pstmt.setString(11, getExecuteCom());
/*      */       }
/*  526 */       if ((getFamilyID() == null) || (getFamilyID().equals("null")))
/*  527 */         pstmt.setNull(12, 12);
/*      */       else {
/*  529 */         pstmt.setString(12, getFamilyID());
/*      */       }
/*  531 */       if ((getRelationToMainInsured() == null) || (getRelationToMainInsured().equals("null")))
/*  532 */         pstmt.setNull(13, 12);
/*      */       else {
/*  534 */         pstmt.setString(13, getRelationToMainInsured());
/*      */       }
/*  536 */       if ((getRelationToAppnt() == null) || (getRelationToAppnt().equals("null")))
/*  537 */         pstmt.setNull(14, 12);
/*      */       else {
/*  539 */         pstmt.setString(14, getRelationToAppnt());
/*      */       }
/*  541 */       if ((getAddressNo() == null) || (getAddressNo().equals("null")))
/*  542 */         pstmt.setNull(15, 12);
/*      */       else {
/*  544 */         pstmt.setString(15, getAddressNo());
/*      */       }
/*  546 */       if ((getSequenceNo() == null) || (getSequenceNo().equals("null")))
/*  547 */         pstmt.setNull(16, 12);
/*      */       else {
/*  549 */         pstmt.setString(16, getSequenceNo());
/*      */       }
/*  551 */       if ((getName() == null) || (getName().equals("null")))
/*  552 */         pstmt.setNull(17, 12);
/*      */       else {
/*  554 */         pstmt.setString(17, getName());
/*      */       }
/*  556 */       if ((getAppellation() == null) || (getAppellation().equals("null")))
/*  557 */         pstmt.setNull(18, 12);
/*      */       else {
/*  559 */         pstmt.setString(18, getAppellation());
/*      */       }
/*  561 */       if ((getSex() == null) || (getSex().equals("null")))
/*  562 */         pstmt.setNull(19, 12);
/*      */       else {
/*  564 */         pstmt.setString(19, getSex());
/*      */       }
/*  566 */       if ((getBirthday() == null) || (getBirthday().equals("null")))
/*  567 */         pstmt.setNull(20, 91);
/*      */       else {
/*  569 */         pstmt.setDate(20, Date.valueOf(getBirthday()));
/*      */       }
/*  571 */       pstmt.setInt(21, getAppAge());
/*  572 */       if ((getAppAgeType() == null) || (getAppAgeType().equals("null")))
/*  573 */         pstmt.setNull(22, 12);
/*      */       else {
/*  575 */         pstmt.setString(22, getAppAgeType());
/*      */       }
/*  577 */       if ((getIDType() == null) || (getIDType().equals("null")))
/*  578 */         pstmt.setNull(23, 12);
/*      */       else {
/*  580 */         pstmt.setString(23, getIDType());
/*      */       }
/*  582 */       if ((getIDNo() == null) || (getIDNo().equals("null")))
/*  583 */         pstmt.setNull(24, 12);
/*      */       else {
/*  585 */         pstmt.setString(24, getIDNo());
/*      */       }
/*  587 */       if ((getIDValidity() == null) || (getIDValidity().equals("null")))
/*  588 */         pstmt.setNull(25, 91);
/*      */       else {
/*  590 */         pstmt.setDate(25, Date.valueOf(getIDValidity()));
/*      */       }
/*  592 */       if ((getIDPerpetual() == null) || (getIDPerpetual().equals("null")))
/*  593 */         pstmt.setNull(26, 12);
/*      */       else {
/*  595 */         pstmt.setString(26, getIDPerpetual());
/*      */       }
/*  597 */       if ((getNativePlace() == null) || (getNativePlace().equals("null")))
/*  598 */         pstmt.setNull(27, 12);
/*      */       else {
/*  600 */         pstmt.setString(27, getNativePlace());
/*      */       }
/*  602 */       if ((getNationality() == null) || (getNationality().equals("null")))
/*  603 */         pstmt.setNull(28, 12);
/*      */       else {
/*  605 */         pstmt.setString(28, getNationality());
/*      */       }
/*  607 */       if ((getRgtAddress() == null) || (getRgtAddress().equals("null")))
/*  608 */         pstmt.setNull(29, 12);
/*      */       else {
/*  610 */         pstmt.setString(29, getRgtAddress());
/*      */       }
/*  612 */       if ((getMarriage() == null) || (getMarriage().equals("null")))
/*  613 */         pstmt.setNull(30, 12);
/*      */       else {
/*  615 */         pstmt.setString(30, getMarriage());
/*      */       }
/*  617 */       if ((getMarriageDate() == null) || (getMarriageDate().equals("null")))
/*  618 */         pstmt.setNull(31, 91);
/*      */       else {
/*  620 */         pstmt.setDate(31, Date.valueOf(getMarriageDate()));
/*      */       }
/*  622 */       if ((getHealth() == null) || (getHealth().equals("null")))
/*  623 */         pstmt.setNull(32, 12);
/*      */       else {
/*  625 */         pstmt.setString(32, getHealth());
/*      */       }
/*  627 */       pstmt.setDouble(33, getStature());
/*  628 */       pstmt.setDouble(34, getAvoirdupois());
/*  629 */       if ((getDegree() == null) || (getDegree().equals("null")))
/*  630 */         pstmt.setNull(35, 12);
/*      */       else {
/*  632 */         pstmt.setString(35, getDegree());
/*      */       }
/*  634 */       if ((getCreditGrade() == null) || (getCreditGrade().equals("null")))
/*  635 */         pstmt.setNull(36, 12);
/*      */       else {
/*  637 */         pstmt.setString(36, getCreditGrade());
/*      */       }
/*  639 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  640 */         pstmt.setNull(37, 12);
/*      */       else {
/*  642 */         pstmt.setString(37, getBankCode());
/*      */       }
/*  644 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  645 */         pstmt.setNull(38, 12);
/*      */       else {
/*  647 */         pstmt.setString(38, getBankAccNo());
/*      */       }
/*  649 */       if ((getAccName() == null) || (getAccName().equals("null")))
/*  650 */         pstmt.setNull(39, 12);
/*      */       else {
/*  652 */         pstmt.setString(39, getAccName());
/*      */       }
/*  654 */       if ((getJoinCompanyDate() == null) || (getJoinCompanyDate().equals("null")))
/*  655 */         pstmt.setNull(40, 91);
/*      */       else {
/*  657 */         pstmt.setDate(40, Date.valueOf(getJoinCompanyDate()));
/*      */       }
/*  659 */       if ((getStartWorkDate() == null) || (getStartWorkDate().equals("null")))
/*  660 */         pstmt.setNull(41, 91);
/*      */       else {
/*  662 */         pstmt.setDate(41, Date.valueOf(getStartWorkDate()));
/*      */       }
/*  664 */       if ((getPosition() == null) || (getPosition().equals("null")))
/*  665 */         pstmt.setNull(42, 12);
/*      */       else {
/*  667 */         pstmt.setString(42, getPosition());
/*      */       }
/*  669 */       pstmt.setDouble(43, getSalary());
/*  670 */       if ((getOccupationType() == null) || (getOccupationType().equals("null")))
/*  671 */         pstmt.setNull(44, 12);
/*      */       else {
/*  673 */         pstmt.setString(44, getOccupationType());
/*      */       }
/*  675 */       if ((getOccupationCode() == null) || (getOccupationCode().equals("null")))
/*  676 */         pstmt.setNull(45, 12);
/*      */       else {
/*  678 */         pstmt.setString(45, getOccupationCode());
/*      */       }
/*  680 */       if ((getPartOccupationType() == null) || (getPartOccupationType().equals("null")))
/*  681 */         pstmt.setNull(46, 12);
/*      */       else {
/*  683 */         pstmt.setString(46, getPartOccupationType());
/*      */       }
/*  685 */       if ((getPartOccupationCode() == null) || (getPartOccupationCode().equals("null")))
/*  686 */         pstmt.setNull(47, 12);
/*      */       else {
/*  688 */         pstmt.setString(47, getPartOccupationCode());
/*      */       }
/*  690 */       if ((getWorkType() == null) || (getWorkType().equals("null")))
/*  691 */         pstmt.setNull(48, 12);
/*      */       else {
/*  693 */         pstmt.setString(48, getWorkType());
/*      */       }
/*  695 */       if ((getPluralityType() == null) || (getPluralityType().equals("null")))
/*  696 */         pstmt.setNull(49, 12);
/*      */       else {
/*  698 */         pstmt.setString(49, getPluralityType());
/*      */       }
/*  700 */       if ((getSmokeFlag() == null) || (getSmokeFlag().equals("null")))
/*  701 */         pstmt.setNull(50, 12);
/*      */       else {
/*  703 */         pstmt.setString(50, getSmokeFlag());
/*      */       }
/*  705 */       if ((getContPlanCode() == null) || (getContPlanCode().equals("null")))
/*  706 */         pstmt.setNull(51, 12);
/*      */       else {
/*  708 */         pstmt.setString(51, getContPlanCode());
/*      */       }
/*  710 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  711 */         pstmt.setNull(52, 12);
/*      */       else {
/*  713 */         pstmt.setString(52, getOperator());
/*      */       }
/*  715 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  716 */         pstmt.setNull(53, 91);
/*      */       else {
/*  718 */         pstmt.setDate(53, Date.valueOf(getMakeDate()));
/*      */       }
/*  720 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  721 */         pstmt.setNull(54, 12);
/*      */       else {
/*  723 */         pstmt.setString(54, getMakeTime());
/*      */       }
/*  725 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  726 */         pstmt.setNull(55, 91);
/*      */       else {
/*  728 */         pstmt.setDate(55, Date.valueOf(getModifyDate()));
/*      */       }
/*  730 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  731 */         pstmt.setNull(56, 12);
/*      */       else {
/*  733 */         pstmt.setString(56, getModifyTime());
/*      */       }
/*  735 */       pstmt.setInt(57, getInsuredPeoples());
/*      */ 
/*  737 */       pstmt.executeUpdate();
/*  738 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  741 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  742 */       CError tError = new CError();
/*  743 */       tError.moduleName = "LNPInsuredDB";
/*  744 */       tError.functionName = "insert()";
/*  745 */       tError.errorMessage = ex.toString();
/*  746 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  749 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  752 */       if (!this.mflag)
/*      */         try {
/*  754 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  758 */       return false;
/*      */     }
/*      */ 
/*  761 */     if (!this.mflag)
/*      */       try {
/*  763 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  767 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  772 */     PreparedStatement pstmt = null;
/*  773 */     ResultSet rs = null;
/*      */ 
/*  775 */     if (!this.mflag) {
/*  776 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  781 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPInsured WHERE  ContNo = ? AND InsuredId = ?", 
/*  782 */         1003, 1007);
/*  783 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  784 */         pstmt.setNull(1, 12);
/*      */       else {
/*  786 */         pstmt.setString(1, getContNo());
/*      */       }
/*  788 */       if ((getInsuredId() == null) || (getInsuredId().equals("null")))
/*  789 */         pstmt.setNull(2, 12);
/*      */       else {
/*  791 */         pstmt.setString(2, getInsuredId());
/*      */       }
/*  793 */       rs = pstmt.executeQuery();
/*  794 */       int i = 0;
/*  795 */       if (rs.next())
/*      */       {
/*  797 */         i++;
/*  798 */         if (!setSchema(rs, i))
/*      */         {
/*  801 */           CError tError = new CError();
/*  802 */           tError.moduleName = "LNPInsuredDB";
/*  803 */           tError.functionName = "getInfo";
/*  804 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  805 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  807 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  810 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  814 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  818 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  822 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  825 */       if (i == 0)
/*      */       {
/*  827 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  831 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  835 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  841 */       CError tError = new CError();
/*  842 */       tError.moduleName = "LNPInsuredDB";
/*  843 */       tError.functionName = "getInfo";
/*  844 */       tError.errorMessage = e.toString();
/*  845 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  847 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  850 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  854 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  858 */       return false;
/*      */     }
/*      */ 
/*  861 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  865 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  870 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInsuredSet query()
/*      */   {
/*  875 */     Statement stmt = null;
/*  876 */     ResultSet rs = null;
/*  877 */     LNPInsuredSet aLNPInsuredSet = new LNPInsuredSet();
/*      */ 
/*  879 */     if (!this.mflag) {
/*  880 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  885 */       stmt = this.con.createStatement(1003, 1007);
/*  886 */       SQLString sqlObj = new SQLString("LNPInsured");
/*  887 */       LNPInsuredSchema aSchema = getSchema();
/*  888 */       sqlObj.setSQL(5, aSchema);
/*  889 */       String sql = sqlObj.getSQL();
/*      */ 
/*  891 */       rs = stmt.executeQuery(sql);
/*  892 */       int i = 0;
/*  893 */       while (rs.next())
/*      */       {
/*  895 */         i++;
/*  896 */         LNPInsuredSchema s1 = new LNPInsuredSchema();
/*  897 */         s1.setSchema(rs, i);
/*  898 */         aLNPInsuredSet.add(s1);
/*      */       }try {
/*  900 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  906 */       CError tError = new CError();
/*  907 */       tError.moduleName = "LNPInsuredDB";
/*  908 */       tError.functionName = "query";
/*  909 */       tError.errorMessage = e.toString();
/*  910 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  912 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  915 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  919 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  925 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  929 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  934 */     return aLNPInsuredSet;
/*      */   }
/*      */ 
/*      */   public LNPInsuredSet executeQuery(String sql)
/*      */   {
/*  939 */     Statement stmt = null;
/*  940 */     ResultSet rs = null;
/*  941 */     LNPInsuredSet aLNPInsuredSet = new LNPInsuredSet();
/*      */ 
/*  943 */     if (!this.mflag) {
/*  944 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  949 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  951 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  952 */       int i = 0;
/*  953 */       while (rs.next())
/*      */       {
/*  955 */         i++;
/*  956 */         LNPInsuredSchema s1 = new LNPInsuredSchema();
/*  957 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  960 */           CError tError = new CError();
/*  961 */           tError.moduleName = "LNPInsuredDB";
/*  962 */           tError.functionName = "executeQuery";
/*  963 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  964 */           this.mErrors.addOneError(tError);
/*      */         }
/*  966 */         aLNPInsuredSet.add(s1);
/*      */       }try {
/*  968 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  974 */       CError tError = new CError();
/*  975 */       tError.moduleName = "LNPInsuredDB";
/*  976 */       tError.functionName = "executeQuery";
/*  977 */       tError.errorMessage = e.toString();
/*  978 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  980 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  983 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  987 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  993 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  997 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1002 */     return aLNPInsuredSet;
/*      */   }
/*      */ 
/*      */   public LNPInsuredSet query(int nStart, int nCount)
/*      */   {
/* 1007 */     Statement stmt = null;
/* 1008 */     ResultSet rs = null;
/* 1009 */     LNPInsuredSet aLNPInsuredSet = new LNPInsuredSet();
/*      */ 
/* 1011 */     if (!this.mflag) {
/* 1012 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1017 */       stmt = this.con.createStatement(1003, 1007);
/* 1018 */       SQLString sqlObj = new SQLString("LNPInsured");
/* 1019 */       LNPInsuredSchema aSchema = getSchema();
/* 1020 */       sqlObj.setSQL(5, aSchema);
/* 1021 */       String sql = sqlObj.getSQL();
/*      */ 
/* 1023 */       rs = stmt.executeQuery(sql);
/* 1024 */       int i = 0;
/* 1025 */       while (rs.next())
/*      */       {
/* 1027 */         i++;
/*      */ 
/* 1029 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1033 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1037 */         LNPInsuredSchema s1 = new LNPInsuredSchema();
/* 1038 */         s1.setSchema(rs, i);
/* 1039 */         aLNPInsuredSet.add(s1);
/*      */       }try {
/* 1041 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1047 */       CError tError = new CError();
/* 1048 */       tError.moduleName = "LNPInsuredDB";
/* 1049 */       tError.functionName = "query";
/* 1050 */       tError.errorMessage = e.toString();
/* 1051 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1053 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1056 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1060 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1066 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1070 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1075 */     return aLNPInsuredSet;
/*      */   }
/*      */ 
/*      */   public LNPInsuredSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/* 1080 */     Statement stmt = null;
/* 1081 */     ResultSet rs = null;
/* 1082 */     LNPInsuredSet aLNPInsuredSet = new LNPInsuredSet();
/*      */ 
/* 1084 */     if (!this.mflag) {
/* 1085 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1090 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1092 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1093 */       int i = 0;
/* 1094 */       while (rs.next())
/*      */       {
/* 1096 */         i++;
/*      */ 
/* 1098 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1102 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1106 */         LNPInsuredSchema s1 = new LNPInsuredSchema();
/* 1107 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1110 */           CError tError = new CError();
/* 1111 */           tError.moduleName = "LNPInsuredDB";
/* 1112 */           tError.functionName = "executeQuery";
/* 1113 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 1114 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1116 */         aLNPInsuredSet.add(s1);
/*      */       }try {
/* 1118 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1124 */       CError tError = new CError();
/* 1125 */       tError.moduleName = "LNPInsuredDB";
/* 1126 */       tError.functionName = "executeQuery";
/* 1127 */       tError.errorMessage = e.toString();
/* 1128 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1130 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1133 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1137 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1143 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1147 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1152 */     return aLNPInsuredSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1157 */     Statement stmt = null;
/*      */ 
/* 1159 */     if (!this.mflag) {
/* 1160 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1165 */       stmt = this.con.createStatement(1003, 1007);
/* 1166 */       SQLString sqlObj = new SQLString("LNPInsured");
/* 1167 */       LNPInsuredSchema aSchema = getSchema();
/* 1168 */       sqlObj.setSQL(2, aSchema);
/* 1169 */       String sql = "update LNPInsured " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1171 */       int operCount = stmt.executeUpdate(sql);
/* 1172 */       if (operCount == 0)
/*      */       {
/* 1175 */         CError tError = new CError();
/* 1176 */         tError.moduleName = "LNPInsuredDB";
/* 1177 */         tError.functionName = "update";
/* 1178 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/* 1179 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1181 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1185 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1189 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1195 */       CError tError = new CError();
/* 1196 */       tError.moduleName = "LNPInsuredDB";
/* 1197 */       tError.functionName = "update";
/* 1198 */       tError.errorMessage = e.toString();
/* 1199 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1201 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1203 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1207 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1211 */       return false;
/*      */     }
/*      */ 
/* 1214 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1218 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1223 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1229 */     if (this.mResultSet != null)
/*      */     {
/* 1232 */       CError tError = new CError();
/* 1233 */       tError.moduleName = "LNPInsuredDB";
/* 1234 */       tError.functionName = "prepareData";
/* 1235 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 1236 */       this.mErrors.addOneError(tError);
/* 1237 */       return false;
/*      */     }
/*      */ 
/* 1240 */     if (!this.mflag)
/*      */     {
/* 1242 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1246 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1247 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1252 */       CError tError = new CError();
/* 1253 */       tError.moduleName = "LNPInsuredDB";
/* 1254 */       tError.functionName = "prepareData";
/* 1255 */       tError.errorMessage = e.toString();
/* 1256 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1259 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1265 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1269 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1273 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1278 */       return false;
/*      */     }
/*      */ 
/* 1281 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1285 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1290 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1296 */     boolean flag = true;
/* 1297 */     if (this.mResultSet == null)
/*      */     {
/* 1299 */       CError tError = new CError();
/* 1300 */       tError.moduleName = "LNPInsuredDB";
/* 1301 */       tError.functionName = "hasMoreData";
/* 1302 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1303 */       this.mErrors.addOneError(tError);
/* 1304 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1308 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1312 */       CError tError = new CError();
/* 1313 */       tError.moduleName = "LNPInsuredDB";
/* 1314 */       tError.functionName = "hasMoreData";
/* 1315 */       tError.errorMessage = ex.toString();
/* 1316 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1319 */         this.mResultSet.close();
/* 1320 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1326 */         this.mStatement.close();
/* 1327 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1331 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1335 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1340 */       return false;
/*      */     }
/* 1342 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPInsuredSet getData()
/*      */   {
/* 1347 */     int tCount = 0;
/* 1348 */     LNPInsuredSet tLNPInsuredSet = new LNPInsuredSet();
/* 1349 */     LNPInsuredSchema tLNPInsuredSchema = null;
/* 1350 */     if (this.mResultSet == null)
/*      */     {
/* 1352 */       CError tError = new CError();
/* 1353 */       tError.moduleName = "LNPInsuredDB";
/* 1354 */       tError.functionName = "getData";
/* 1355 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1356 */       this.mErrors.addOneError(tError);
/* 1357 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1361 */       tCount = 1;
/* 1362 */       tLNPInsuredSchema = new LNPInsuredSchema();
/* 1363 */       tLNPInsuredSchema.setSchema(this.mResultSet, 1);
/* 1364 */       tLNPInsuredSet.add(tLNPInsuredSchema);
/*      */ 
/* 1366 */       while (tCount++ < 5000)
/*      */       {
/* 1368 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1370 */         tLNPInsuredSchema = new LNPInsuredSchema();
/* 1371 */         tLNPInsuredSchema.setSchema(this.mResultSet, 1);
/* 1372 */         tLNPInsuredSet.add(tLNPInsuredSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1378 */       CError tError = new CError();
/* 1379 */       tError.moduleName = "LNPInsuredDB";
/* 1380 */       tError.functionName = "getData";
/* 1381 */       tError.errorMessage = ex.toString();
/* 1382 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1385 */         this.mResultSet.close();
/* 1386 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1392 */         this.mStatement.close();
/* 1393 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1397 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1401 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1406 */       return null;
/*      */     }
/* 1408 */     return tLNPInsuredSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1413 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1416 */       if (this.mResultSet == null)
/*      */       {
/* 1418 */         CError tError = new CError();
/* 1419 */         tError.moduleName = "LNPInsuredDB";
/* 1420 */         tError.functionName = "closeData";
/* 1421 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1422 */         this.mErrors.addOneError(tError);
/* 1423 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1427 */         this.mResultSet.close();
/* 1428 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1433 */       CError tError = new CError();
/* 1434 */       tError.moduleName = "LNPInsuredDB";
/* 1435 */       tError.functionName = "closeData";
/* 1436 */       tError.errorMessage = ex2.toString();
/* 1437 */       this.mErrors.addOneError(tError);
/* 1438 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1442 */       if (this.mStatement == null)
/*      */       {
/* 1444 */         CError tError = new CError();
/* 1445 */         tError.moduleName = "LNPInsuredDB";
/* 1446 */         tError.functionName = "closeData";
/* 1447 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1448 */         this.mErrors.addOneError(tError);
/* 1449 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1453 */         this.mStatement.close();
/* 1454 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1459 */       CError tError = new CError();
/* 1460 */       tError.moduleName = "LNPInsuredDB";
/* 1461 */       tError.functionName = "closeData";
/* 1462 */       tError.errorMessage = ex3.toString();
/* 1463 */       this.mErrors.addOneError(tError);
/* 1464 */       flag = false;
/*      */     }
/* 1466 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPInsuredDB
 * JD-Core Version:    0.6.0
 */