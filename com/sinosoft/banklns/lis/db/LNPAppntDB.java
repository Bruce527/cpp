/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAppntSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import com.sinosoft.banklns.utility.SQLString;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class LNPAppntDB extends LNPAppntSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   29 */   private boolean mflag = false;
/*      */ 
/*   31 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   34 */   private ResultSet mResultSet = null;
/*   35 */   private Statement mStatement = null;
/*      */ 
/*      */   public LNPAppntDB(Connection tConnection)
/*      */   {
/*   39 */     this.con = tConnection;
/*   40 */     this.db = new DBOper(this.con, "LNPAppnt");
/*   41 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPAppntDB()
/*      */   {
/*   46 */     this.con = null;
/*   47 */     this.db = new DBOper("LNPAppnt");
/*   48 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   54 */     LNPAppntSchema tSchema = getSchema();
/*   55 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   57 */       return true;
/*      */     }
/*      */ 
/*   62 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   63 */     CError tError = new CError();
/*   64 */     tError.moduleName = "LNPAppntDB";
/*   65 */     tError.functionName = "deleteSQL";
/*   66 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   67 */     this.mErrors.addOneError(tError);
/*   68 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   74 */     LNPAppntSchema tSchema = getSchema();
/*      */ 
/*   76 */     int tCount = this.db.getCount(tSchema);
/*   77 */     if (tCount < 0)
/*      */     {
/*   80 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   81 */       CError tError = new CError();
/*   82 */       tError.moduleName = "LNPAppntDB";
/*   83 */       tError.functionName = "getCount";
/*   84 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   85 */       this.mErrors.addOneError(tError);
/*      */ 
/*   87 */       return -1;
/*      */     }
/*      */ 
/*   90 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   95 */     PreparedStatement pstmt = null;
/*      */ 
/*   97 */     if (!this.mflag) {
/*   98 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  103 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAppnt WHERE  ContNo = ?");
/*  104 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  105 */         pstmt.setNull(1, 12);
/*      */       else {
/*  107 */         pstmt.setString(1, getContNo());
/*      */       }
/*  109 */       pstmt.executeUpdate();
/*  110 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  113 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  114 */       CError tError = new CError();
/*  115 */       tError.moduleName = "LNPAppntDB";
/*  116 */       tError.functionName = "delete()";
/*  117 */       tError.errorMessage = ex.toString();
/*  118 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  121 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  124 */       if (!this.mflag)
/*      */         try {
/*  126 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  130 */       return false;
/*      */     }
/*      */ 
/*  133 */     if (!this.mflag)
/*      */       try {
/*  135 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  139 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  144 */     PreparedStatement pstmt = null;
/*      */ 
/*  146 */     if (!this.mflag) {
/*  147 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  152 */       pstmt = this.con.prepareStatement("UPDATE LNPAppnt SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , AppntNo = ? , AppntId = ? , RelationToInsured = ? , AppntGrade = ? , Appellation = ? , AppntName = ? , AppntSex = ? , AppntBirthday = ? , AppntAge = ? , AppntAgeType = ? , AppntType = ? , AddressNo = ? , SequenceNo = ? , IDType = ? , IDNo = ? , IDValidity = ? , IDPerpetual = ? , NativePlace = ? , Nationality = ? , RgtAddress = ? , Marriage = ? , MarriageDate = ? , Health = ? , Stature = ? , Avoirdupois = ? , Degree = ? , CreditGrade = ? , BankCode = ? , BankAccNo = ? , AccName = ? , JoinCompanyDate = ? , StartWorkDate = ? , Position = ? , Salary = ? , OccupationType = ? , OccupationCode = ? , WorkType = ? , PluralityType = ? , SmokeFlag = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ?");
/*  153 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  154 */         pstmt.setNull(1, 12);
/*      */       else {
/*  156 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  158 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  159 */         pstmt.setNull(2, 12);
/*      */       else {
/*  161 */         pstmt.setString(2, getContNo());
/*      */       }
/*  163 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  164 */         pstmt.setNull(3, 12);
/*      */       else {
/*  166 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  168 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  169 */         pstmt.setNull(4, 12);
/*      */       else {
/*  171 */         pstmt.setString(4, getPrtNo());
/*      */       }
/*  173 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  174 */         pstmt.setNull(5, 12);
/*      */       else {
/*  176 */         pstmt.setString(5, getAppntNo());
/*      */       }
/*  178 */       if ((getAppntId() == null) || (getAppntId().equals("null")))
/*  179 */         pstmt.setNull(6, 12);
/*      */       else {
/*  181 */         pstmt.setString(6, getAppntId());
/*      */       }
/*  183 */       if ((getRelationToInsured() == null) || (getRelationToInsured().equals("null")))
/*  184 */         pstmt.setNull(7, 12);
/*      */       else {
/*  186 */         pstmt.setString(7, getRelationToInsured());
/*      */       }
/*  188 */       if ((getAppntGrade() == null) || (getAppntGrade().equals("null")))
/*  189 */         pstmt.setNull(8, 12);
/*      */       else {
/*  191 */         pstmt.setString(8, getAppntGrade());
/*      */       }
/*  193 */       if ((getAppellation() == null) || (getAppellation().equals("null")))
/*  194 */         pstmt.setNull(9, 12);
/*      */       else {
/*  196 */         pstmt.setString(9, getAppellation());
/*      */       }
/*  198 */       if ((getAppntName() == null) || (getAppntName().equals("null")))
/*  199 */         pstmt.setNull(10, 12);
/*      */       else {
/*  201 */         pstmt.setString(10, getAppntName());
/*      */       }
/*  203 */       if ((getAppntSex() == null) || (getAppntSex().equals("null")))
/*  204 */         pstmt.setNull(11, 12);
/*      */       else {
/*  206 */         pstmt.setString(11, getAppntSex());
/*      */       }
/*  208 */       if ((getAppntBirthday() == null) || (getAppntBirthday().equals("null")))
/*  209 */         pstmt.setNull(12, 91);
/*      */       else {
/*  211 */         pstmt.setDate(12, Date.valueOf(getAppntBirthday()));
/*      */       }
/*  213 */       pstmt.setInt(13, getAppntAge());
/*  214 */       if ((getAppntAgeType() == null) || (getAppntAgeType().equals("null")))
/*  215 */         pstmt.setNull(14, 12);
/*      */       else {
/*  217 */         pstmt.setString(14, getAppntAgeType());
/*      */       }
/*  219 */       if ((getAppntType() == null) || (getAppntType().equals("null")))
/*  220 */         pstmt.setNull(15, 12);
/*      */       else {
/*  222 */         pstmt.setString(15, getAppntType());
/*      */       }
/*  224 */       if ((getAddressNo() == null) || (getAddressNo().equals("null")))
/*  225 */         pstmt.setNull(16, 12);
/*      */       else {
/*  227 */         pstmt.setString(16, getAddressNo());
/*      */       }
/*  229 */       if ((getSequenceNo() == null) || (getSequenceNo().equals("null")))
/*  230 */         pstmt.setNull(17, 12);
/*      */       else {
/*  232 */         pstmt.setString(17, getSequenceNo());
/*      */       }
/*  234 */       if ((getIDType() == null) || (getIDType().equals("null")))
/*  235 */         pstmt.setNull(18, 12);
/*      */       else {
/*  237 */         pstmt.setString(18, getIDType());
/*      */       }
/*  239 */       if ((getIDNo() == null) || (getIDNo().equals("null")))
/*  240 */         pstmt.setNull(19, 12);
/*      */       else {
/*  242 */         pstmt.setString(19, getIDNo());
/*      */       }
/*  244 */       if ((getIDValidity() == null) || (getIDValidity().equals("null")))
/*  245 */         pstmt.setNull(20, 91);
/*      */       else {
/*  247 */         pstmt.setDate(20, Date.valueOf(getIDValidity()));
/*      */       }
/*  249 */       if ((getIDPerpetual() == null) || (getIDPerpetual().equals("null")))
/*  250 */         pstmt.setNull(21, 12);
/*      */       else {
/*  252 */         pstmt.setString(21, getIDPerpetual());
/*      */       }
/*  254 */       if ((getNativePlace() == null) || (getNativePlace().equals("null")))
/*  255 */         pstmt.setNull(22, 12);
/*      */       else {
/*  257 */         pstmt.setString(22, getNativePlace());
/*      */       }
/*  259 */       if ((getNationality() == null) || (getNationality().equals("null")))
/*  260 */         pstmt.setNull(23, 12);
/*      */       else {
/*  262 */         pstmt.setString(23, getNationality());
/*      */       }
/*  264 */       if ((getRgtAddress() == null) || (getRgtAddress().equals("null")))
/*  265 */         pstmt.setNull(24, 12);
/*      */       else {
/*  267 */         pstmt.setString(24, getRgtAddress());
/*      */       }
/*  269 */       if ((getMarriage() == null) || (getMarriage().equals("null")))
/*  270 */         pstmt.setNull(25, 12);
/*      */       else {
/*  272 */         pstmt.setString(25, getMarriage());
/*      */       }
/*  274 */       if ((getMarriageDate() == null) || (getMarriageDate().equals("null")))
/*  275 */         pstmt.setNull(26, 91);
/*      */       else {
/*  277 */         pstmt.setDate(26, Date.valueOf(getMarriageDate()));
/*      */       }
/*  279 */       if ((getHealth() == null) || (getHealth().equals("null")))
/*  280 */         pstmt.setNull(27, 12);
/*      */       else {
/*  282 */         pstmt.setString(27, getHealth());
/*      */       }
/*  284 */       pstmt.setDouble(28, getStature());
/*  285 */       pstmt.setDouble(29, getAvoirdupois());
/*  286 */       if ((getDegree() == null) || (getDegree().equals("null")))
/*  287 */         pstmt.setNull(30, 12);
/*      */       else {
/*  289 */         pstmt.setString(30, getDegree());
/*      */       }
/*  291 */       if ((getCreditGrade() == null) || (getCreditGrade().equals("null")))
/*  292 */         pstmt.setNull(31, 12);
/*      */       else {
/*  294 */         pstmt.setString(31, getCreditGrade());
/*      */       }
/*  296 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  297 */         pstmt.setNull(32, 12);
/*      */       else {
/*  299 */         pstmt.setString(32, getBankCode());
/*      */       }
/*  301 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  302 */         pstmt.setNull(33, 12);
/*      */       else {
/*  304 */         pstmt.setString(33, getBankAccNo());
/*      */       }
/*  306 */       if ((getAccName() == null) || (getAccName().equals("null")))
/*  307 */         pstmt.setNull(34, 12);
/*      */       else {
/*  309 */         pstmt.setString(34, getAccName());
/*      */       }
/*  311 */       if ((getJoinCompanyDate() == null) || (getJoinCompanyDate().equals("null")))
/*  312 */         pstmt.setNull(35, 91);
/*      */       else {
/*  314 */         pstmt.setDate(35, Date.valueOf(getJoinCompanyDate()));
/*      */       }
/*  316 */       if ((getStartWorkDate() == null) || (getStartWorkDate().equals("null")))
/*  317 */         pstmt.setNull(36, 91);
/*      */       else {
/*  319 */         pstmt.setDate(36, Date.valueOf(getStartWorkDate()));
/*      */       }
/*  321 */       if ((getPosition() == null) || (getPosition().equals("null")))
/*  322 */         pstmt.setNull(37, 12);
/*      */       else {
/*  324 */         pstmt.setString(37, getPosition());
/*      */       }
/*  326 */       pstmt.setDouble(38, getSalary());
/*  327 */       if ((getOccupationType() == null) || (getOccupationType().equals("null")))
/*  328 */         pstmt.setNull(39, 12);
/*      */       else {
/*  330 */         pstmt.setString(39, getOccupationType());
/*      */       }
/*  332 */       if ((getOccupationCode() == null) || (getOccupationCode().equals("null")))
/*  333 */         pstmt.setNull(40, 12);
/*      */       else {
/*  335 */         pstmt.setString(40, getOccupationCode());
/*      */       }
/*  337 */       if ((getWorkType() == null) || (getWorkType().equals("null")))
/*  338 */         pstmt.setNull(41, 12);
/*      */       else {
/*  340 */         pstmt.setString(41, getWorkType());
/*      */       }
/*  342 */       if ((getPluralityType() == null) || (getPluralityType().equals("null")))
/*  343 */         pstmt.setNull(42, 12);
/*      */       else {
/*  345 */         pstmt.setString(42, getPluralityType());
/*      */       }
/*  347 */       if ((getSmokeFlag() == null) || (getSmokeFlag().equals("null")))
/*  348 */         pstmt.setNull(43, 12);
/*      */       else {
/*  350 */         pstmt.setString(43, getSmokeFlag());
/*      */       }
/*  352 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  353 */         pstmt.setNull(44, 12);
/*      */       else {
/*  355 */         pstmt.setString(44, getOperator());
/*      */       }
/*  357 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  358 */         pstmt.setNull(45, 12);
/*      */       else {
/*  360 */         pstmt.setString(45, getManageCom());
/*      */       }
/*  362 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  363 */         pstmt.setNull(46, 91);
/*      */       else {
/*  365 */         pstmt.setDate(46, Date.valueOf(getMakeDate()));
/*      */       }
/*  367 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  368 */         pstmt.setNull(47, 12);
/*      */       else {
/*  370 */         pstmt.setString(47, getMakeTime());
/*      */       }
/*  372 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  373 */         pstmt.setNull(48, 91);
/*      */       else {
/*  375 */         pstmt.setDate(48, Date.valueOf(getModifyDate()));
/*      */       }
/*  377 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  378 */         pstmt.setNull(49, 12);
/*      */       else {
/*  380 */         pstmt.setString(49, getModifyTime());
/*      */       }
/*      */ 
/*  383 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  384 */         pstmt.setNull(50, 12);
/*      */       else {
/*  386 */         pstmt.setString(50, getContNo());
/*      */       }
/*  388 */       pstmt.executeUpdate();
/*  389 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  392 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  393 */       CError tError = new CError();
/*  394 */       tError.moduleName = "LNPAppntDB";
/*  395 */       tError.functionName = "update()";
/*  396 */       tError.errorMessage = ex.toString();
/*  397 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  400 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  403 */       if (!this.mflag)
/*      */         try {
/*  405 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  409 */       return false;
/*      */     }
/*      */ 
/*  412 */     if (!this.mflag)
/*      */       try {
/*  414 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  418 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  423 */     PreparedStatement pstmt = null;
/*      */ 
/*  425 */     if (!this.mflag) {
/*  426 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  431 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAppnt VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  432 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  433 */         pstmt.setNull(1, 12);
/*      */       else {
/*  435 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  437 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  438 */         pstmt.setNull(2, 12);
/*      */       else {
/*  440 */         pstmt.setString(2, getContNo());
/*      */       }
/*  442 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  443 */         pstmt.setNull(3, 12);
/*      */       else {
/*  445 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  447 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  448 */         pstmt.setNull(4, 12);
/*      */       else {
/*  450 */         pstmt.setString(4, getPrtNo());
/*      */       }
/*  452 */       if ((getAppntNo() == null) || (getAppntNo().equals("null")))
/*  453 */         pstmt.setNull(5, 12);
/*      */       else {
/*  455 */         pstmt.setString(5, getAppntNo());
/*      */       }
/*  457 */       if ((getAppntId() == null) || (getAppntId().equals("null"))) {
/*  458 */         System.out.println("appntid\u4E3A\u7A7A");
/*      */ 
/*  460 */         pstmt.setNull(6, 12);
/*      */       } else {
/*  462 */         System.out.println("appntid\u4E0D\u4E3A\u7A7A--" + getAppntId());
/*  463 */         pstmt.setString(6, getAppntId());
/*      */       }
/*  465 */       if ((getRelationToInsured() == null) || (getRelationToInsured().equals("null")))
/*  466 */         pstmt.setNull(7, 12);
/*      */       else {
/*  468 */         pstmt.setString(7, getRelationToInsured());
/*      */       }
/*  470 */       if ((getAppntGrade() == null) || (getAppntGrade().equals("null")))
/*  471 */         pstmt.setNull(8, 12);
/*      */       else {
/*  473 */         pstmt.setString(8, getAppntGrade());
/*      */       }
/*  475 */       if ((getAppellation() == null) || (getAppellation().equals("null")))
/*  476 */         pstmt.setNull(9, 12);
/*      */       else {
/*  478 */         pstmt.setString(9, getAppellation());
/*      */       }
/*  480 */       if ((getAppntName() == null) || (getAppntName().equals("null")))
/*  481 */         pstmt.setNull(10, 12);
/*      */       else {
/*  483 */         pstmt.setString(10, getAppntName());
/*      */       }
/*  485 */       if ((getAppntSex() == null) || (getAppntSex().equals("null")))
/*  486 */         pstmt.setNull(11, 12);
/*      */       else {
/*  488 */         pstmt.setString(11, getAppntSex());
/*      */       }
/*  490 */       if ((getAppntBirthday() == null) || (getAppntBirthday().equals("null")))
/*  491 */         pstmt.setNull(12, 91);
/*      */       else {
/*  493 */         pstmt.setDate(12, Date.valueOf(getAppntBirthday()));
/*      */       }
/*  495 */       pstmt.setInt(13, getAppntAge());
/*  496 */       if ((getAppntAgeType() == null) || (getAppntAgeType().equals("null")))
/*  497 */         pstmt.setNull(14, 12);
/*      */       else {
/*  499 */         pstmt.setString(14, getAppntAgeType());
/*      */       }
/*  501 */       if ((getAppntType() == null) || (getAppntType().equals("null")))
/*  502 */         pstmt.setNull(15, 12);
/*      */       else {
/*  504 */         pstmt.setString(15, getAppntType());
/*      */       }
/*  506 */       if ((getAddressNo() == null) || (getAddressNo().equals("null")))
/*  507 */         pstmt.setNull(16, 12);
/*      */       else {
/*  509 */         pstmt.setString(16, getAddressNo());
/*      */       }
/*  511 */       if ((getSequenceNo() == null) || (getSequenceNo().equals("null")))
/*  512 */         pstmt.setNull(17, 12);
/*      */       else {
/*  514 */         pstmt.setString(17, getSequenceNo());
/*      */       }
/*  516 */       if ((getIDType() == null) || (getIDType().equals("null")))
/*  517 */         pstmt.setNull(18, 12);
/*      */       else {
/*  519 */         pstmt.setString(18, getIDType());
/*      */       }
/*  521 */       if ((getIDNo() == null) || (getIDNo().equals("null")))
/*  522 */         pstmt.setNull(19, 12);
/*      */       else {
/*  524 */         pstmt.setString(19, getIDNo());
/*      */       }
/*  526 */       if ((getIDValidity() == null) || (getIDValidity().equals("null")))
/*  527 */         pstmt.setNull(20, 91);
/*      */       else {
/*  529 */         pstmt.setDate(20, Date.valueOf(getIDValidity()));
/*      */       }
/*  531 */       if ((getIDPerpetual() == null) || (getIDPerpetual().equals("null")))
/*  532 */         pstmt.setNull(21, 12);
/*      */       else {
/*  534 */         pstmt.setString(21, getIDPerpetual());
/*      */       }
/*  536 */       if ((getNativePlace() == null) || (getNativePlace().equals("null")))
/*  537 */         pstmt.setNull(22, 12);
/*      */       else {
/*  539 */         pstmt.setString(22, getNativePlace());
/*      */       }
/*  541 */       if ((getNationality() == null) || (getNationality().equals("null")))
/*  542 */         pstmt.setNull(23, 12);
/*      */       else {
/*  544 */         pstmt.setString(23, getNationality());
/*      */       }
/*  546 */       if ((getRgtAddress() == null) || (getRgtAddress().equals("null")))
/*  547 */         pstmt.setNull(24, 12);
/*      */       else {
/*  549 */         pstmt.setString(24, getRgtAddress());
/*      */       }
/*  551 */       if ((getMarriage() == null) || (getMarriage().equals("null")))
/*  552 */         pstmt.setNull(25, 12);
/*      */       else {
/*  554 */         pstmt.setString(25, getMarriage());
/*      */       }
/*  556 */       if ((getMarriageDate() == null) || (getMarriageDate().equals("null")))
/*  557 */         pstmt.setNull(26, 91);
/*      */       else {
/*  559 */         pstmt.setDate(26, Date.valueOf(getMarriageDate()));
/*      */       }
/*  561 */       if ((getHealth() == null) || (getHealth().equals("null")))
/*  562 */         pstmt.setNull(27, 12);
/*      */       else {
/*  564 */         pstmt.setString(27, getHealth());
/*      */       }
/*  566 */       pstmt.setDouble(28, getStature());
/*  567 */       pstmt.setDouble(29, getAvoirdupois());
/*  568 */       if ((getDegree() == null) || (getDegree().equals("null")))
/*  569 */         pstmt.setNull(30, 12);
/*      */       else {
/*  571 */         pstmt.setString(30, getDegree());
/*      */       }
/*  573 */       if ((getCreditGrade() == null) || (getCreditGrade().equals("null")))
/*  574 */         pstmt.setNull(31, 12);
/*      */       else {
/*  576 */         pstmt.setString(31, getCreditGrade());
/*      */       }
/*  578 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  579 */         pstmt.setNull(32, 12);
/*      */       else {
/*  581 */         pstmt.setString(32, getBankCode());
/*      */       }
/*  583 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  584 */         pstmt.setNull(33, 12);
/*      */       else {
/*  586 */         pstmt.setString(33, getBankAccNo());
/*      */       }
/*  588 */       if ((getAccName() == null) || (getAccName().equals("null")))
/*  589 */         pstmt.setNull(34, 12);
/*      */       else {
/*  591 */         pstmt.setString(34, getAccName());
/*      */       }
/*  593 */       if ((getJoinCompanyDate() == null) || (getJoinCompanyDate().equals("null")))
/*  594 */         pstmt.setNull(35, 91);
/*      */       else {
/*  596 */         pstmt.setDate(35, Date.valueOf(getJoinCompanyDate()));
/*      */       }
/*  598 */       if ((getStartWorkDate() == null) || (getStartWorkDate().equals("null")))
/*  599 */         pstmt.setNull(36, 91);
/*      */       else {
/*  601 */         pstmt.setDate(36, Date.valueOf(getStartWorkDate()));
/*      */       }
/*  603 */       if ((getPosition() == null) || (getPosition().equals("null")))
/*  604 */         pstmt.setNull(37, 12);
/*      */       else {
/*  606 */         pstmt.setString(37, getPosition());
/*      */       }
/*  608 */       pstmt.setDouble(38, getSalary());
/*  609 */       if ((getOccupationType() == null) || (getOccupationType().equals("null")))
/*  610 */         pstmt.setNull(39, 12);
/*      */       else {
/*  612 */         pstmt.setString(39, getOccupationType());
/*      */       }
/*  614 */       if ((getOccupationCode() == null) || (getOccupationCode().equals("null")))
/*  615 */         pstmt.setNull(40, 12);
/*      */       else {
/*  617 */         pstmt.setString(40, getOccupationCode());
/*      */       }
/*  619 */       if ((getWorkType() == null) || (getWorkType().equals("null")))
/*  620 */         pstmt.setNull(41, 12);
/*      */       else {
/*  622 */         pstmt.setString(41, getWorkType());
/*      */       }
/*  624 */       if ((getPluralityType() == null) || (getPluralityType().equals("null")))
/*  625 */         pstmt.setNull(42, 12);
/*      */       else {
/*  627 */         pstmt.setString(42, getPluralityType());
/*      */       }
/*  629 */       if ((getSmokeFlag() == null) || (getSmokeFlag().equals("null")))
/*  630 */         pstmt.setNull(43, 12);
/*      */       else {
/*  632 */         pstmt.setString(43, getSmokeFlag());
/*      */       }
/*  634 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  635 */         pstmt.setNull(44, 12);
/*      */       else {
/*  637 */         pstmt.setString(44, getOperator());
/*      */       }
/*  639 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  640 */         pstmt.setNull(45, 12);
/*      */       else {
/*  642 */         pstmt.setString(45, getManageCom());
/*      */       }
/*  644 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  645 */         pstmt.setNull(46, 91);
/*      */       else {
/*  647 */         pstmt.setDate(46, Date.valueOf(getMakeDate()));
/*      */       }
/*  649 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  650 */         pstmt.setNull(47, 12);
/*      */       else {
/*  652 */         pstmt.setString(47, getMakeTime());
/*      */       }
/*  654 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  655 */         pstmt.setNull(48, 91);
/*      */       else {
/*  657 */         pstmt.setDate(48, Date.valueOf(getModifyDate()));
/*      */       }
/*  659 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  660 */         pstmt.setNull(49, 12);
/*      */       else {
/*  662 */         pstmt.setString(49, getModifyTime());
/*      */       }
/*      */ 
/*  667 */       pstmt.executeUpdate();
/*  668 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  671 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  672 */       CError tError = new CError();
/*  673 */       tError.moduleName = "LNPAppntDB";
/*  674 */       tError.functionName = "insert()";
/*  675 */       tError.errorMessage = ex.toString();
/*  676 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  679 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  682 */       if (!this.mflag)
/*      */         try {
/*  684 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  688 */       return false;
/*      */     }
/*      */ 
/*  691 */     if (!this.mflag)
/*      */       try {
/*  693 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  697 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  702 */     PreparedStatement pstmt = null;
/*  703 */     ResultSet rs = null;
/*      */ 
/*  705 */     if (!this.mflag) {
/*  706 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  711 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPAppnt WHERE  ContNo = ?", 
/*  712 */         1003, 1007);
/*  713 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  714 */         pstmt.setNull(1, 12);
/*      */       else {
/*  716 */         pstmt.setString(1, getContNo());
/*      */       }
/*  718 */       rs = pstmt.executeQuery();
/*  719 */       int i = 0;
/*  720 */       if (rs.next())
/*      */       {
/*  722 */         i++;
/*  723 */         if (!setSchema(rs, i))
/*      */         {
/*  726 */           CError tError = new CError();
/*  727 */           tError.moduleName = "LNPAppntDB";
/*  728 */           tError.functionName = "getInfo";
/*  729 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  730 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  732 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  735 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  739 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  743 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  747 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  750 */       if (i == 0)
/*      */       {
/*  752 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  756 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  760 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  766 */       CError tError = new CError();
/*  767 */       tError.moduleName = "LNPAppntDB";
/*  768 */       tError.functionName = "getInfo";
/*  769 */       tError.errorMessage = e.toString();
/*  770 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  772 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  775 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  779 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  783 */       return false;
/*      */     }
/*      */ 
/*  786 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  790 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  795 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAppntSet query()
/*      */   {
/*  800 */     Statement stmt = null;
/*  801 */     ResultSet rs = null;
/*  802 */     LNPAppntSet aLNPAppntSet = new LNPAppntSet();
/*      */ 
/*  804 */     if (!this.mflag) {
/*  805 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  810 */       stmt = this.con.createStatement(1003, 1007);
/*  811 */       SQLString sqlObj = new SQLString("LNPAppnt");
/*  812 */       LNPAppntSchema aSchema = getSchema();
/*  813 */       sqlObj.setSQL(5, aSchema);
/*  814 */       String sql = sqlObj.getSQL();
/*      */ 
/*  816 */       rs = stmt.executeQuery(sql);
/*  817 */       int i = 0;
/*  818 */       while (rs.next())
/*      */       {
/*  820 */         i++;
/*  821 */         LNPAppntSchema s1 = new LNPAppntSchema();
/*  822 */         s1.setSchema(rs, i);
/*  823 */         aLNPAppntSet.add(s1);
/*      */       }try {
/*  825 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  831 */       CError tError = new CError();
/*  832 */       tError.moduleName = "LNPAppntDB";
/*  833 */       tError.functionName = "query";
/*  834 */       tError.errorMessage = e.toString();
/*  835 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  837 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  840 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  844 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  850 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  854 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  859 */     return aLNPAppntSet;
/*      */   }
/*      */ 
/*      */   public LNPAppntSet executeQuery(String sql)
/*      */   {
/*  864 */     Statement stmt = null;
/*  865 */     ResultSet rs = null;
/*  866 */     LNPAppntSet aLNPAppntSet = new LNPAppntSet();
/*      */ 
/*  868 */     if (!this.mflag) {
/*  869 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  874 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  876 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  877 */       int i = 0;
/*  878 */       while (rs.next())
/*      */       {
/*  880 */         i++;
/*  881 */         LNPAppntSchema s1 = new LNPAppntSchema();
/*  882 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  885 */           CError tError = new CError();
/*  886 */           tError.moduleName = "LNPAppntDB";
/*  887 */           tError.functionName = "executeQuery";
/*  888 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  889 */           this.mErrors.addOneError(tError);
/*      */         }
/*  891 */         aLNPAppntSet.add(s1);
/*      */       }try {
/*  893 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  899 */       CError tError = new CError();
/*  900 */       tError.moduleName = "LNPAppntDB";
/*  901 */       tError.functionName = "executeQuery";
/*  902 */       tError.errorMessage = e.toString();
/*  903 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  905 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  908 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  912 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  918 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  922 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  927 */     return aLNPAppntSet;
/*      */   }
/*      */ 
/*      */   public LNPAppntSet query(int nStart, int nCount)
/*      */   {
/*  932 */     Statement stmt = null;
/*  933 */     ResultSet rs = null;
/*  934 */     LNPAppntSet aLNPAppntSet = new LNPAppntSet();
/*      */ 
/*  936 */     if (!this.mflag) {
/*  937 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  942 */       stmt = this.con.createStatement(1003, 1007);
/*  943 */       SQLString sqlObj = new SQLString("LNPAppnt");
/*  944 */       LNPAppntSchema aSchema = getSchema();
/*  945 */       sqlObj.setSQL(5, aSchema);
/*  946 */       String sql = sqlObj.getSQL();
/*      */ 
/*  948 */       rs = stmt.executeQuery(sql);
/*  949 */       int i = 0;
/*  950 */       while (rs.next())
/*      */       {
/*  952 */         i++;
/*      */ 
/*  954 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  958 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  962 */         LNPAppntSchema s1 = new LNPAppntSchema();
/*  963 */         s1.setSchema(rs, i);
/*  964 */         aLNPAppntSet.add(s1);
/*      */       }try {
/*  966 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  972 */       CError tError = new CError();
/*  973 */       tError.moduleName = "LNPAppntDB";
/*  974 */       tError.functionName = "query";
/*  975 */       tError.errorMessage = e.toString();
/*  976 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  978 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  981 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  985 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  991 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  995 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1000 */     return aLNPAppntSet;
/*      */   }
/*      */ 
/*      */   public LNPAppntSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/* 1005 */     Statement stmt = null;
/* 1006 */     ResultSet rs = null;
/* 1007 */     LNPAppntSet aLNPAppntSet = new LNPAppntSet();
/*      */ 
/* 1009 */     if (!this.mflag) {
/* 1010 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1015 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1017 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1018 */       int i = 0;
/* 1019 */       while (rs.next())
/*      */       {
/* 1021 */         i++;
/*      */ 
/* 1023 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1027 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1031 */         LNPAppntSchema s1 = new LNPAppntSchema();
/* 1032 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1035 */           CError tError = new CError();
/* 1036 */           tError.moduleName = "LNPAppntDB";
/* 1037 */           tError.functionName = "executeQuery";
/* 1038 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 1039 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1041 */         aLNPAppntSet.add(s1);
/*      */       }try {
/* 1043 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1049 */       CError tError = new CError();
/* 1050 */       tError.moduleName = "LNPAppntDB";
/* 1051 */       tError.functionName = "executeQuery";
/* 1052 */       tError.errorMessage = e.toString();
/* 1053 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1055 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1058 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1062 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1068 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1072 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1077 */     return aLNPAppntSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1082 */     Statement stmt = null;
/*      */ 
/* 1084 */     if (!this.mflag) {
/* 1085 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1090 */       stmt = this.con.createStatement(1003, 1007);
/* 1091 */       SQLString sqlObj = new SQLString("LNPAppnt");
/* 1092 */       LNPAppntSchema aSchema = getSchema();
/* 1093 */       sqlObj.setSQL(2, aSchema);
/* 1094 */       String sql = "update LNPAppnt " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1096 */       int operCount = stmt.executeUpdate(sql);
/* 1097 */       if (operCount == 0)
/*      */       {
/* 1100 */         CError tError = new CError();
/* 1101 */         tError.moduleName = "LNPAppntDB";
/* 1102 */         tError.functionName = "update";
/* 1103 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/* 1104 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1106 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1110 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1114 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1120 */       CError tError = new CError();
/* 1121 */       tError.moduleName = "LNPAppntDB";
/* 1122 */       tError.functionName = "update";
/* 1123 */       tError.errorMessage = e.toString();
/* 1124 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1126 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1128 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1132 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1136 */       return false;
/*      */     }
/*      */ 
/* 1139 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1143 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1148 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1154 */     if (this.mResultSet != null)
/*      */     {
/* 1157 */       CError tError = new CError();
/* 1158 */       tError.moduleName = "LNPAppntDB";
/* 1159 */       tError.functionName = "prepareData";
/* 1160 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 1161 */       this.mErrors.addOneError(tError);
/* 1162 */       return false;
/*      */     }
/*      */ 
/* 1165 */     if (!this.mflag)
/*      */     {
/* 1167 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1171 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1172 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1177 */       CError tError = new CError();
/* 1178 */       tError.moduleName = "LNPAppntDB";
/* 1179 */       tError.functionName = "prepareData";
/* 1180 */       tError.errorMessage = e.toString();
/* 1181 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1184 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1190 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1194 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1198 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1203 */       return false;
/*      */     }
/*      */ 
/* 1206 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1210 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1215 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1221 */     boolean flag = true;
/* 1222 */     if (this.mResultSet == null)
/*      */     {
/* 1224 */       CError tError = new CError();
/* 1225 */       tError.moduleName = "LNPAppntDB";
/* 1226 */       tError.functionName = "hasMoreData";
/* 1227 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1228 */       this.mErrors.addOneError(tError);
/* 1229 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1233 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1237 */       CError tError = new CError();
/* 1238 */       tError.moduleName = "LNPAppntDB";
/* 1239 */       tError.functionName = "hasMoreData";
/* 1240 */       tError.errorMessage = ex.toString();
/* 1241 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1244 */         this.mResultSet.close();
/* 1245 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1251 */         this.mStatement.close();
/* 1252 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1256 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1260 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1265 */       return false;
/*      */     }
/* 1267 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPAppntSet getData()
/*      */   {
/* 1272 */     int tCount = 0;
/* 1273 */     LNPAppntSet tLNPAppntSet = new LNPAppntSet();
/* 1274 */     LNPAppntSchema tLNPAppntSchema = null;
/* 1275 */     if (this.mResultSet == null)
/*      */     {
/* 1277 */       CError tError = new CError();
/* 1278 */       tError.moduleName = "LNPAppntDB";
/* 1279 */       tError.functionName = "getData";
/* 1280 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1281 */       this.mErrors.addOneError(tError);
/* 1282 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1286 */       tCount = 1;
/* 1287 */       tLNPAppntSchema = new LNPAppntSchema();
/* 1288 */       tLNPAppntSchema.setSchema(this.mResultSet, 1);
/* 1289 */       tLNPAppntSet.add(tLNPAppntSchema);
/*      */ 
/* 1291 */       while (tCount++ < 5000)
/*      */       {
/* 1293 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1295 */         tLNPAppntSchema = new LNPAppntSchema();
/* 1296 */         tLNPAppntSchema.setSchema(this.mResultSet, 1);
/* 1297 */         tLNPAppntSet.add(tLNPAppntSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1303 */       CError tError = new CError();
/* 1304 */       tError.moduleName = "LNPAppntDB";
/* 1305 */       tError.functionName = "getData";
/* 1306 */       tError.errorMessage = ex.toString();
/* 1307 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1310 */         this.mResultSet.close();
/* 1311 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1317 */         this.mStatement.close();
/* 1318 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1322 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1326 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1331 */       return null;
/*      */     }
/* 1333 */     return tLNPAppntSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1338 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1341 */       if (this.mResultSet == null)
/*      */       {
/* 1343 */         CError tError = new CError();
/* 1344 */         tError.moduleName = "LNPAppntDB";
/* 1345 */         tError.functionName = "closeData";
/* 1346 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1347 */         this.mErrors.addOneError(tError);
/* 1348 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1352 */         this.mResultSet.close();
/* 1353 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1358 */       CError tError = new CError();
/* 1359 */       tError.moduleName = "LNPAppntDB";
/* 1360 */       tError.functionName = "closeData";
/* 1361 */       tError.errorMessage = ex2.toString();
/* 1362 */       this.mErrors.addOneError(tError);
/* 1363 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1367 */       if (this.mStatement == null)
/*      */       {
/* 1369 */         CError tError = new CError();
/* 1370 */         tError.moduleName = "LNPAppntDB";
/* 1371 */         tError.functionName = "closeData";
/* 1372 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1373 */         this.mErrors.addOneError(tError);
/* 1374 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1378 */         this.mStatement.close();
/* 1379 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1384 */       CError tError = new CError();
/* 1385 */       tError.moduleName = "LNPAppntDB";
/* 1386 */       tError.functionName = "closeData";
/* 1387 */       tError.errorMessage = ex3.toString();
/* 1388 */       this.mErrors.addOneError(tError);
/* 1389 */       flag = false;
/*      */     }
/* 1391 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPAppntDB
 * JD-Core Version:    0.6.0
 */