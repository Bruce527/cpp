/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPersonSet;
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
/*      */ public class LNPPersonDB extends LNPPersonSchema
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
/*      */   public LNPPersonDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPPerson");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPPersonDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPPerson");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPPersonSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPPersonDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPPersonSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPPersonDB";
/*   76 */       tError.functionName = "getCount";
/*   77 */       tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPPerson WHERE  CustomerId = ? AND AgentCode = ?");
/*   97 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getCustomerId());
/*      */       }
/*  102 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  107 */       pstmt.executeUpdate();
/*  108 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  111 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  112 */       CError tError = new CError();
/*  113 */       tError.moduleName = "LNPPersonDB";
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
/*  150 */       pstmt = this.con.prepareStatement("UPDATE LNPPerson SET  CustomerId = ? , AgentCode = ? , CustomerNo = ? , Appellation = ? , Name = ? , Sex = ? , Birthday = ? , Age = ? , AgeType = ? , AppntType = ? , IDType = ? , IDNo = ? , IDValidity = ? , IDPerpetual = ? , Password = ? , NativePlace = ? , Nationality = ? , RgtAddress = ? , Marriage = ? , MarriageDate = ? , Health = ? , Stature = ? , Avoirdupois = ? , Degree = ? , CreditGrade = ? , BankCode = ? , BankAccNo = ? , AccName = ? , OthIDType = ? , OthIDNo = ? , ICNo = ? , GrpNo = ? , JoinCompanyDate = ? , StartWorkDate = ? , Position = ? , Salary = ? , OccupationType = ? , OccupationCode = ? , PartOccupationType = ? , PartOccupationCode = ? , WorkType = ? , PluralityType = ? , DeathDate = ? , SmokeFlag = ? , BlacklistFlag = ? , Proterty = ? , Remark = ? , State = ? , VIPValue = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , GrpName = ? WHERE  CustomerId = ? AND AgentCode = ?");
/*  151 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  152 */         pstmt.setNull(1, 12);
/*      */       else {
/*  154 */         pstmt.setString(1, getCustomerId());
/*      */       }
/*  156 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  157 */         pstmt.setNull(2, 12);
/*      */       else {
/*  159 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  161 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  162 */         pstmt.setNull(3, 12);
/*      */       else {
/*  164 */         pstmt.setString(3, getCustomerNo());
/*      */       }
/*  166 */       if ((getAppellation() == null) || (getAppellation().equals("null")))
/*  167 */         pstmt.setNull(4, 12);
/*      */       else {
/*  169 */         pstmt.setString(4, getAppellation());
/*      */       }
/*  171 */       if ((getName() == null) || (getName().equals("null")))
/*  172 */         pstmt.setNull(5, 12);
/*      */       else {
/*  174 */         pstmt.setString(5, getName());
/*      */       }
/*  176 */       if ((getSex() == null) || (getSex().equals("null")))
/*  177 */         pstmt.setNull(6, 12);
/*      */       else {
/*  179 */         pstmt.setString(6, getSex());
/*      */       }
/*  181 */       if ((getBirthday() == null) || (getBirthday().equals("null")))
/*  182 */         pstmt.setNull(7, 91);
/*      */       else {
/*  184 */         pstmt.setDate(7, Date.valueOf(getBirthday()));
/*      */       }
/*  186 */       pstmt.setInt(8, getAge());
/*  187 */       if ((getAgeType() == null) || (getAgeType().equals("null")))
/*  188 */         pstmt.setNull(9, 12);
/*      */       else {
/*  190 */         pstmt.setString(9, getAgeType());
/*      */       }
/*  192 */       if ((getAppntType() == null) || (getAppntType().equals("null")))
/*  193 */         pstmt.setNull(10, 12);
/*      */       else {
/*  195 */         pstmt.setString(10, getAppntType());
/*      */       }
/*  197 */       if ((getIDType() == null) || (getIDType().equals("null")))
/*  198 */         pstmt.setNull(11, 12);
/*      */       else {
/*  200 */         pstmt.setString(11, getIDType());
/*      */       }
/*  202 */       if ((getIDNo() == null) || (getIDNo().equals("null")))
/*  203 */         pstmt.setNull(12, 12);
/*      */       else {
/*  205 */         pstmt.setString(12, getIDNo());
/*      */       }
/*  207 */       if ((getIDValidity() == null) || (getIDValidity().equals("null")))
/*  208 */         pstmt.setNull(13, 91);
/*      */       else {
/*  210 */         pstmt.setDate(13, Date.valueOf(getIDValidity()));
/*      */       }
/*  212 */       if ((getIDPerpetual() == null) || (getIDPerpetual().equals("null")))
/*  213 */         pstmt.setNull(14, 12);
/*      */       else {
/*  215 */         pstmt.setString(14, getIDPerpetual());
/*      */       }
/*  217 */       if ((getPassword() == null) || (getPassword().equals("null")))
/*  218 */         pstmt.setNull(15, 12);
/*      */       else {
/*  220 */         pstmt.setString(15, getPassword());
/*      */       }
/*  222 */       if ((getNativePlace() == null) || (getNativePlace().equals("null")))
/*  223 */         pstmt.setNull(16, 12);
/*      */       else {
/*  225 */         pstmt.setString(16, getNativePlace());
/*      */       }
/*  227 */       if ((getNationality() == null) || (getNationality().equals("null")))
/*  228 */         pstmt.setNull(17, 12);
/*      */       else {
/*  230 */         pstmt.setString(17, getNationality());
/*      */       }
/*  232 */       if ((getRgtAddress() == null) || (getRgtAddress().equals("null")))
/*  233 */         pstmt.setNull(18, 12);
/*      */       else {
/*  235 */         pstmt.setString(18, getRgtAddress());
/*      */       }
/*  237 */       if ((getMarriage() == null) || (getMarriage().equals("null")))
/*  238 */         pstmt.setNull(19, 12);
/*      */       else {
/*  240 */         pstmt.setString(19, getMarriage());
/*      */       }
/*  242 */       if ((getMarriageDate() == null) || (getMarriageDate().equals("null")))
/*  243 */         pstmt.setNull(20, 91);
/*      */       else {
/*  245 */         pstmt.setDate(20, Date.valueOf(getMarriageDate()));
/*      */       }
/*  247 */       if ((getHealth() == null) || (getHealth().equals("null")))
/*  248 */         pstmt.setNull(21, 12);
/*      */       else {
/*  250 */         pstmt.setString(21, getHealth());
/*      */       }
/*  252 */       pstmt.setDouble(22, getStature());
/*  253 */       pstmt.setDouble(23, getAvoirdupois());
/*  254 */       if ((getDegree() == null) || (getDegree().equals("null")))
/*  255 */         pstmt.setNull(24, 12);
/*      */       else {
/*  257 */         pstmt.setString(24, getDegree());
/*      */       }
/*  259 */       if ((getCreditGrade() == null) || (getCreditGrade().equals("null")))
/*  260 */         pstmt.setNull(25, 12);
/*      */       else {
/*  262 */         pstmt.setString(25, getCreditGrade());
/*      */       }
/*  264 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  265 */         pstmt.setNull(26, 12);
/*      */       else {
/*  267 */         pstmt.setString(26, getBankCode());
/*      */       }
/*  269 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  270 */         pstmt.setNull(27, 12);
/*      */       else {
/*  272 */         pstmt.setString(27, getBankAccNo());
/*      */       }
/*  274 */       if ((getAccName() == null) || (getAccName().equals("null")))
/*  275 */         pstmt.setNull(28, 12);
/*      */       else {
/*  277 */         pstmt.setString(28, getAccName());
/*      */       }
/*  279 */       if ((getOthIDType() == null) || (getOthIDType().equals("null")))
/*  280 */         pstmt.setNull(29, 12);
/*      */       else {
/*  282 */         pstmt.setString(29, getOthIDType());
/*      */       }
/*  284 */       if ((getOthIDNo() == null) || (getOthIDNo().equals("null")))
/*  285 */         pstmt.setNull(30, 12);
/*      */       else {
/*  287 */         pstmt.setString(30, getOthIDNo());
/*      */       }
/*  289 */       if ((getICNo() == null) || (getICNo().equals("null")))
/*  290 */         pstmt.setNull(31, 12);
/*      */       else {
/*  292 */         pstmt.setString(31, getICNo());
/*      */       }
/*  294 */       if ((getGrpNo() == null) || (getGrpNo().equals("null")))
/*  295 */         pstmt.setNull(32, 12);
/*      */       else {
/*  297 */         pstmt.setString(32, getGrpNo());
/*      */       }
/*  299 */       if ((getJoinCompanyDate() == null) || (getJoinCompanyDate().equals("null")))
/*  300 */         pstmt.setNull(33, 91);
/*      */       else {
/*  302 */         pstmt.setDate(33, Date.valueOf(getJoinCompanyDate()));
/*      */       }
/*  304 */       if ((getStartWorkDate() == null) || (getStartWorkDate().equals("null")))
/*  305 */         pstmt.setNull(34, 91);
/*      */       else {
/*  307 */         pstmt.setDate(34, Date.valueOf(getStartWorkDate()));
/*      */       }
/*  309 */       if ((getPosition() == null) || (getPosition().equals("null")))
/*  310 */         pstmt.setNull(35, 12);
/*      */       else {
/*  312 */         pstmt.setString(35, getPosition());
/*      */       }
/*  314 */       pstmt.setDouble(36, getSalary());
/*  315 */       if ((getOccupationType() == null) || (getOccupationType().equals("null")))
/*  316 */         pstmt.setNull(37, 12);
/*      */       else {
/*  318 */         pstmt.setString(37, getOccupationType());
/*      */       }
/*  320 */       if ((getOccupationCode() == null) || (getOccupationCode().equals("null")))
/*  321 */         pstmt.setNull(38, 12);
/*      */       else {
/*  323 */         pstmt.setString(38, getOccupationCode());
/*      */       }
/*  325 */       if ((getPartOccupationType() == null) || (getPartOccupationType().equals("null")))
/*  326 */         pstmt.setNull(39, 12);
/*      */       else {
/*  328 */         pstmt.setString(39, getPartOccupationType());
/*      */       }
/*  330 */       if ((getPartOccupationCode() == null) || (getPartOccupationCode().equals("null")))
/*  331 */         pstmt.setNull(40, 12);
/*      */       else {
/*  333 */         pstmt.setString(40, getPartOccupationCode());
/*      */       }
/*  335 */       if ((getWorkType() == null) || (getWorkType().equals("null")))
/*  336 */         pstmt.setNull(41, 12);
/*      */       else {
/*  338 */         pstmt.setString(41, getWorkType());
/*      */       }
/*  340 */       if ((getPluralityType() == null) || (getPluralityType().equals("null")))
/*  341 */         pstmt.setNull(42, 12);
/*      */       else {
/*  343 */         pstmt.setString(42, getPluralityType());
/*      */       }
/*  345 */       if ((getDeathDate() == null) || (getDeathDate().equals("null")))
/*  346 */         pstmt.setNull(43, 91);
/*      */       else {
/*  348 */         pstmt.setDate(43, Date.valueOf(getDeathDate()));
/*      */       }
/*  350 */       if ((getSmokeFlag() == null) || (getSmokeFlag().equals("null")))
/*  351 */         pstmt.setNull(44, 12);
/*      */       else {
/*  353 */         pstmt.setString(44, getSmokeFlag());
/*      */       }
/*  355 */       if ((getBlacklistFlag() == null) || (getBlacklistFlag().equals("null")))
/*  356 */         pstmt.setNull(45, 12);
/*      */       else {
/*  358 */         pstmt.setString(45, getBlacklistFlag());
/*      */       }
/*  360 */       if ((getProterty() == null) || (getProterty().equals("null")))
/*  361 */         pstmt.setNull(46, 12);
/*      */       else {
/*  363 */         pstmt.setString(46, getProterty());
/*      */       }
/*  365 */       if ((getRemark() == null) || (getRemark().equals("null")))
/*  366 */         pstmt.setNull(47, 12);
/*      */       else {
/*  368 */         pstmt.setString(47, getRemark());
/*      */       }
/*  370 */       if ((getState() == null) || (getState().equals("null")))
/*  371 */         pstmt.setNull(48, 12);
/*      */       else {
/*  373 */         pstmt.setString(48, getState());
/*      */       }
/*  375 */       if ((getVIPValue() == null) || (getVIPValue().equals("null")))
/*  376 */         pstmt.setNull(49, 12);
/*      */       else {
/*  378 */         pstmt.setString(49, getVIPValue());
/*      */       }
/*  380 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  381 */         pstmt.setNull(50, 12);
/*      */       else {
/*  383 */         pstmt.setString(50, getOperator());
/*      */       }
/*  385 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  386 */         pstmt.setNull(51, 12);
/*      */       else {
/*  388 */         pstmt.setString(51, getManageCom());
/*      */       }
/*  390 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  391 */         pstmt.setNull(52, 91);
/*      */       else {
/*  393 */         pstmt.setDate(52, Date.valueOf(getMakeDate()));
/*      */       }
/*  395 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  396 */         pstmt.setNull(53, 12);
/*      */       else {
/*  398 */         pstmt.setString(53, getMakeTime());
/*      */       }
/*  400 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  401 */         pstmt.setNull(54, 91);
/*      */       else {
/*  403 */         pstmt.setDate(54, Date.valueOf(getModifyDate()));
/*      */       }
/*  405 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  406 */         pstmt.setNull(55, 12);
/*      */       else {
/*  408 */         pstmt.setString(55, getModifyTime());
/*      */       }
/*  410 */       if ((getGrpName() == null) || (getGrpName().equals("null")))
/*  411 */         pstmt.setNull(56, 12);
/*      */       else {
/*  413 */         pstmt.setString(56, getGrpName());
/*      */       }
/*      */ 
/*  416 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  417 */         pstmt.setNull(57, 12);
/*      */       else {
/*  419 */         pstmt.setString(57, getCustomerId());
/*      */       }
/*  421 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  422 */         pstmt.setNull(58, 12);
/*      */       else {
/*  424 */         pstmt.setString(58, getAgentCode());
/*      */       }
/*  426 */       pstmt.executeUpdate();
/*  427 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  430 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  431 */       CError tError = new CError();
/*  432 */       tError.moduleName = "LNPPersonDB";
/*  433 */       tError.functionName = "update()";
/*  434 */       tError.errorMessage = ex.toString();
/*  435 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  438 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  441 */       if (!this.mflag)
/*      */         try {
/*  443 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  447 */       return false;
/*      */     }
/*      */ 
/*  450 */     if (!this.mflag)
/*      */       try {
/*  452 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  456 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  461 */     PreparedStatement pstmt = null;
/*      */ 
/*  463 */     if (!this.mflag) {
/*  464 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  469 */       pstmt = this.con.prepareStatement("INSERT INTO LNPPerson VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  470 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  471 */         pstmt.setNull(1, 12);
/*      */       else {
/*  473 */         pstmt.setString(1, getCustomerId());
/*      */       }
/*  475 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  476 */         pstmt.setNull(2, 12);
/*      */       else {
/*  478 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  480 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  481 */         pstmt.setNull(3, 12);
/*      */       else {
/*  483 */         pstmt.setString(3, getCustomerNo());
/*      */       }
/*  485 */       if ((getAppellation() == null) || (getAppellation().equals("null")))
/*  486 */         pstmt.setNull(4, 12);
/*      */       else {
/*  488 */         pstmt.setString(4, getAppellation());
/*      */       }
/*  490 */       if ((getName() == null) || (getName().equals("null")))
/*  491 */         pstmt.setNull(5, 12);
/*      */       else {
/*  493 */         pstmt.setString(5, getName());
/*      */       }
/*  495 */       if ((getSex() == null) || (getSex().equals("null")))
/*  496 */         pstmt.setNull(6, 12);
/*      */       else {
/*  498 */         pstmt.setString(6, getSex());
/*      */       }
/*  500 */       if ((getBirthday() == null) || (getBirthday().equals("null")))
/*  501 */         pstmt.setNull(7, 91);
/*      */       else {
/*  503 */         pstmt.setDate(7, Date.valueOf(getBirthday()));
/*      */       }
/*  505 */       pstmt.setInt(8, getAge());
/*  506 */       if ((getAgeType() == null) || (getAgeType().equals("null")))
/*  507 */         pstmt.setNull(9, 12);
/*      */       else {
/*  509 */         pstmt.setString(9, getAgeType());
/*      */       }
/*  511 */       if ((getAppntType() == null) || (getAppntType().equals("null")))
/*  512 */         pstmt.setNull(10, 12);
/*      */       else {
/*  514 */         pstmt.setString(10, getAppntType());
/*      */       }
/*  516 */       if ((getIDType() == null) || (getIDType().equals("null")))
/*  517 */         pstmt.setNull(11, 12);
/*      */       else {
/*  519 */         pstmt.setString(11, getIDType());
/*      */       }
/*  521 */       if ((getIDNo() == null) || (getIDNo().equals("null")))
/*  522 */         pstmt.setNull(12, 12);
/*      */       else {
/*  524 */         pstmt.setString(12, getIDNo());
/*      */       }
/*  526 */       if ((getIDValidity() == null) || (getIDValidity().equals("null")))
/*  527 */         pstmt.setNull(13, 91);
/*      */       else {
/*  529 */         pstmt.setDate(13, Date.valueOf(getIDValidity()));
/*      */       }
/*  531 */       if ((getIDPerpetual() == null) || (getIDPerpetual().equals("null")))
/*  532 */         pstmt.setNull(14, 12);
/*      */       else {
/*  534 */         pstmt.setString(14, getIDPerpetual());
/*      */       }
/*  536 */       if ((getPassword() == null) || (getPassword().equals("null")))
/*  537 */         pstmt.setNull(15, 12);
/*      */       else {
/*  539 */         pstmt.setString(15, getPassword());
/*      */       }
/*  541 */       if ((getNativePlace() == null) || (getNativePlace().equals("null")))
/*  542 */         pstmt.setNull(16, 12);
/*      */       else {
/*  544 */         pstmt.setString(16, getNativePlace());
/*      */       }
/*  546 */       if ((getNationality() == null) || (getNationality().equals("null")))
/*  547 */         pstmt.setNull(17, 12);
/*      */       else {
/*  549 */         pstmt.setString(17, getNationality());
/*      */       }
/*  551 */       if ((getRgtAddress() == null) || (getRgtAddress().equals("null")))
/*  552 */         pstmt.setNull(18, 12);
/*      */       else {
/*  554 */         pstmt.setString(18, getRgtAddress());
/*      */       }
/*  556 */       if ((getMarriage() == null) || (getMarriage().equals("null")))
/*  557 */         pstmt.setNull(19, 12);
/*      */       else {
/*  559 */         pstmt.setString(19, getMarriage());
/*      */       }
/*  561 */       if ((getMarriageDate() == null) || (getMarriageDate().equals("null")))
/*  562 */         pstmt.setNull(20, 91);
/*      */       else {
/*  564 */         pstmt.setDate(20, Date.valueOf(getMarriageDate()));
/*      */       }
/*  566 */       if ((getHealth() == null) || (getHealth().equals("null")))
/*  567 */         pstmt.setNull(21, 12);
/*      */       else {
/*  569 */         pstmt.setString(21, getHealth());
/*      */       }
/*  571 */       pstmt.setDouble(22, getStature());
/*  572 */       pstmt.setDouble(23, getAvoirdupois());
/*  573 */       if ((getDegree() == null) || (getDegree().equals("null")))
/*  574 */         pstmt.setNull(24, 12);
/*      */       else {
/*  576 */         pstmt.setString(24, getDegree());
/*      */       }
/*  578 */       if ((getCreditGrade() == null) || (getCreditGrade().equals("null")))
/*  579 */         pstmt.setNull(25, 12);
/*      */       else {
/*  581 */         pstmt.setString(25, getCreditGrade());
/*      */       }
/*  583 */       if ((getBankCode() == null) || (getBankCode().equals("null")))
/*  584 */         pstmt.setNull(26, 12);
/*      */       else {
/*  586 */         pstmt.setString(26, getBankCode());
/*      */       }
/*  588 */       if ((getBankAccNo() == null) || (getBankAccNo().equals("null")))
/*  589 */         pstmt.setNull(27, 12);
/*      */       else {
/*  591 */         pstmt.setString(27, getBankAccNo());
/*      */       }
/*  593 */       if ((getAccName() == null) || (getAccName().equals("null")))
/*  594 */         pstmt.setNull(28, 12);
/*      */       else {
/*  596 */         pstmt.setString(28, getAccName());
/*      */       }
/*  598 */       if ((getOthIDType() == null) || (getOthIDType().equals("null")))
/*  599 */         pstmt.setNull(29, 12);
/*      */       else {
/*  601 */         pstmt.setString(29, getOthIDType());
/*      */       }
/*  603 */       if ((getOthIDNo() == null) || (getOthIDNo().equals("null")))
/*  604 */         pstmt.setNull(30, 12);
/*      */       else {
/*  606 */         pstmt.setString(30, getOthIDNo());
/*      */       }
/*  608 */       if ((getICNo() == null) || (getICNo().equals("null")))
/*  609 */         pstmt.setNull(31, 12);
/*      */       else {
/*  611 */         pstmt.setString(31, getICNo());
/*      */       }
/*  613 */       if ((getGrpNo() == null) || (getGrpNo().equals("null")))
/*  614 */         pstmt.setNull(32, 12);
/*      */       else {
/*  616 */         pstmt.setString(32, getGrpNo());
/*      */       }
/*  618 */       if ((getJoinCompanyDate() == null) || (getJoinCompanyDate().equals("null")))
/*  619 */         pstmt.setNull(33, 91);
/*      */       else {
/*  621 */         pstmt.setDate(33, Date.valueOf(getJoinCompanyDate()));
/*      */       }
/*  623 */       if ((getStartWorkDate() == null) || (getStartWorkDate().equals("null")))
/*  624 */         pstmt.setNull(34, 91);
/*      */       else {
/*  626 */         pstmt.setDate(34, Date.valueOf(getStartWorkDate()));
/*      */       }
/*  628 */       if ((getPosition() == null) || (getPosition().equals("null")))
/*  629 */         pstmt.setNull(35, 12);
/*      */       else {
/*  631 */         pstmt.setString(35, getPosition());
/*      */       }
/*  633 */       pstmt.setDouble(36, getSalary());
/*  634 */       if ((getOccupationType() == null) || (getOccupationType().equals("null")))
/*  635 */         pstmt.setNull(37, 12);
/*      */       else {
/*  637 */         pstmt.setString(37, getOccupationType());
/*      */       }
/*  639 */       if ((getOccupationCode() == null) || (getOccupationCode().equals("null")))
/*  640 */         pstmt.setNull(38, 12);
/*      */       else {
/*  642 */         pstmt.setString(38, getOccupationCode());
/*      */       }
/*  644 */       if ((getPartOccupationType() == null) || (getPartOccupationType().equals("null")))
/*  645 */         pstmt.setNull(39, 12);
/*      */       else {
/*  647 */         pstmt.setString(39, getPartOccupationType());
/*      */       }
/*  649 */       if ((getPartOccupationCode() == null) || (getPartOccupationCode().equals("null")))
/*  650 */         pstmt.setNull(40, 12);
/*      */       else {
/*  652 */         pstmt.setString(40, getPartOccupationCode());
/*      */       }
/*  654 */       if ((getWorkType() == null) || (getWorkType().equals("null")))
/*  655 */         pstmt.setNull(41, 12);
/*      */       else {
/*  657 */         pstmt.setString(41, getWorkType());
/*      */       }
/*  659 */       if ((getPluralityType() == null) || (getPluralityType().equals("null")))
/*  660 */         pstmt.setNull(42, 12);
/*      */       else {
/*  662 */         pstmt.setString(42, getPluralityType());
/*      */       }
/*  664 */       if ((getDeathDate() == null) || (getDeathDate().equals("null")))
/*  665 */         pstmt.setNull(43, 91);
/*      */       else {
/*  667 */         pstmt.setDate(43, Date.valueOf(getDeathDate()));
/*      */       }
/*  669 */       if ((getSmokeFlag() == null) || (getSmokeFlag().equals("null")))
/*  670 */         pstmt.setNull(44, 12);
/*      */       else {
/*  672 */         pstmt.setString(44, getSmokeFlag());
/*      */       }
/*  674 */       if ((getBlacklistFlag() == null) || (getBlacklistFlag().equals("null")))
/*  675 */         pstmt.setNull(45, 12);
/*      */       else {
/*  677 */         pstmt.setString(45, getBlacklistFlag());
/*      */       }
/*  679 */       if ((getProterty() == null) || (getProterty().equals("null")))
/*  680 */         pstmt.setNull(46, 12);
/*      */       else {
/*  682 */         pstmt.setString(46, getProterty());
/*      */       }
/*  684 */       if ((getRemark() == null) || (getRemark().equals("null")))
/*  685 */         pstmt.setNull(47, 12);
/*      */       else {
/*  687 */         pstmt.setString(47, getRemark());
/*      */       }
/*  689 */       if ((getState() == null) || (getState().equals("null")))
/*  690 */         pstmt.setNull(48, 12);
/*      */       else {
/*  692 */         pstmt.setString(48, getState());
/*      */       }
/*  694 */       if ((getVIPValue() == null) || (getVIPValue().equals("null")))
/*  695 */         pstmt.setNull(49, 12);
/*      */       else {
/*  697 */         pstmt.setString(49, getVIPValue());
/*      */       }
/*  699 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  700 */         pstmt.setNull(50, 12);
/*      */       else {
/*  702 */         pstmt.setString(50, getOperator());
/*      */       }
/*  704 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  705 */         pstmt.setNull(51, 12);
/*      */       else {
/*  707 */         pstmt.setString(51, getManageCom());
/*      */       }
/*  709 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  710 */         pstmt.setNull(52, 91);
/*      */       else {
/*  712 */         pstmt.setDate(52, Date.valueOf(getMakeDate()));
/*      */       }
/*  714 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  715 */         pstmt.setNull(53, 12);
/*      */       else {
/*  717 */         pstmt.setString(53, getMakeTime());
/*      */       }
/*  719 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  720 */         pstmt.setNull(54, 91);
/*      */       else {
/*  722 */         pstmt.setDate(54, Date.valueOf(getModifyDate()));
/*      */       }
/*  724 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  725 */         pstmt.setNull(55, 12);
/*      */       else {
/*  727 */         pstmt.setString(55, getModifyTime());
/*      */       }
/*  729 */       if ((getGrpName() == null) || (getGrpName().equals("null")))
/*  730 */         pstmt.setNull(56, 12);
/*      */       else {
/*  732 */         pstmt.setString(56, getGrpName());
/*      */       }
/*      */ 
/*  735 */       pstmt.executeUpdate();
/*  736 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  739 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  740 */       CError tError = new CError();
/*  741 */       tError.moduleName = "LNPPersonDB";
/*  742 */       tError.functionName = "insert()";
/*  743 */       tError.errorMessage = ex.toString();
/*  744 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  747 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  750 */       if (!this.mflag)
/*      */         try {
/*  752 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  756 */       return false;
/*      */     }
/*      */ 
/*  759 */     if (!this.mflag)
/*      */       try {
/*  761 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  765 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  770 */     PreparedStatement pstmt = null;
/*  771 */     ResultSet rs = null;
/*      */ 
/*  773 */     if (!this.mflag) {
/*  774 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  779 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPPerson WHERE  CustomerId = ? AND AgentCode = ?", 
/*  780 */         1003, 1007);
/*  781 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  782 */         pstmt.setNull(1, 12);
/*      */       else {
/*  784 */         pstmt.setString(1, getCustomerId());
/*      */       }
/*  786 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  787 */         pstmt.setNull(2, 12);
/*      */       else {
/*  789 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  791 */       rs = pstmt.executeQuery();
/*  792 */       int i = 0;
/*  793 */       if (rs.next())
/*      */       {
/*  795 */         i++;
/*  796 */         if (!setSchema(rs, i))
/*      */         {
/*  799 */           CError tError = new CError();
/*  800 */           tError.moduleName = "LNPPersonDB";
/*  801 */           tError.functionName = "getInfo";
/*  802 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  803 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  805 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  808 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  812 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  816 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  820 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  823 */       if (i == 0)
/*      */       {
/*  825 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  829 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  833 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  839 */       CError tError = new CError();
/*  840 */       tError.moduleName = "LNPPersonDB";
/*  841 */       tError.functionName = "getInfo";
/*  842 */       tError.errorMessage = e.toString();
/*  843 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  845 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  848 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  852 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  856 */       return false;
/*      */     }
/*      */ 
/*  859 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  863 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  868 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPPersonSet query()
/*      */   {
/*  873 */     Statement stmt = null;
/*  874 */     ResultSet rs = null;
/*  875 */     LNPPersonSet aLNPPersonSet = new LNPPersonSet();
/*      */ 
/*  877 */     if (!this.mflag) {
/*  878 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  883 */       stmt = this.con.createStatement(1003, 1007);
/*  884 */       SQLString sqlObj = new SQLString("LNPPerson");
/*  885 */       LNPPersonSchema aSchema = getSchema();
/*  886 */       sqlObj.setSQL(5, aSchema);
/*  887 */       String sql = sqlObj.getSQL();
/*      */ 
/*  889 */       rs = stmt.executeQuery(sql);
/*  890 */       int i = 0;
/*  891 */       while (rs.next())
/*      */       {
/*  893 */         i++;
/*  894 */         LNPPersonSchema s1 = new LNPPersonSchema();
/*  895 */         s1.setSchema(rs, i);
/*  896 */         aLNPPersonSet.add(s1);
/*      */       }try {
/*  898 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  904 */       CError tError = new CError();
/*  905 */       tError.moduleName = "LNPPersonDB";
/*  906 */       tError.functionName = "query";
/*  907 */       tError.errorMessage = e.toString();
/*  908 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  910 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  913 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  917 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  923 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  927 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  932 */     return aLNPPersonSet;
/*      */   }
/*      */ 
/*      */   public LNPPersonSet executeQuery(String sql)
/*      */   {
/*  937 */     Statement stmt = null;
/*  938 */     ResultSet rs = null;
/*  939 */     LNPPersonSet aLNPPersonSet = new LNPPersonSet();
/*      */ 
/*  941 */     if (!this.mflag) {
/*  942 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  947 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  949 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  950 */       int i = 0;
/*  951 */       while (rs.next())
/*      */       {
/*  953 */         i++;
/*  954 */         LNPPersonSchema s1 = new LNPPersonSchema();
/*  955 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  958 */           CError tError = new CError();
/*  959 */           tError.moduleName = "LNPPersonDB";
/*  960 */           tError.functionName = "executeQuery";
/*  961 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  962 */           this.mErrors.addOneError(tError);
/*      */         }
/*  964 */         aLNPPersonSet.add(s1);
/*      */       }try {
/*  966 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  972 */       CError tError = new CError();
/*  973 */       tError.moduleName = "LNPPersonDB";
/*  974 */       tError.functionName = "executeQuery";
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
/* 1000 */     return aLNPPersonSet;
/*      */   }
/*      */ 
/*      */   public LNPPersonSet query(int nStart, int nCount)
/*      */   {
/* 1005 */     Statement stmt = null;
/* 1006 */     ResultSet rs = null;
/* 1007 */     LNPPersonSet aLNPPersonSet = new LNPPersonSet();
/*      */ 
/* 1009 */     if (!this.mflag) {
/* 1010 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1015 */       stmt = this.con.createStatement(1003, 1007);
/* 1016 */       SQLString sqlObj = new SQLString("LNPPerson");
/* 1017 */       LNPPersonSchema aSchema = getSchema();
/* 1018 */       sqlObj.setSQL(5, aSchema);
/* 1019 */       String sql = sqlObj.getSQL();
/*      */ 
/* 1021 */       rs = stmt.executeQuery(sql);
/* 1022 */       int i = 0;
/* 1023 */       while (rs.next())
/*      */       {
/* 1025 */         i++;
/*      */ 
/* 1027 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1031 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1035 */         LNPPersonSchema s1 = new LNPPersonSchema();
/* 1036 */         s1.setSchema(rs, i);
/* 1037 */         aLNPPersonSet.add(s1);
/*      */       }try {
/* 1039 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1045 */       CError tError = new CError();
/* 1046 */       tError.moduleName = "LNPPersonDB";
/* 1047 */       tError.functionName = "query";
/* 1048 */       tError.errorMessage = e.toString();
/* 1049 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1051 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1054 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1058 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1064 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1068 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1073 */     return aLNPPersonSet;
/*      */   }
/*      */ 
/*      */   public LNPPersonSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/* 1078 */     Statement stmt = null;
/* 1079 */     ResultSet rs = null;
/* 1080 */     LNPPersonSet aLNPPersonSet = new LNPPersonSet();
/*      */ 
/* 1082 */     if (!this.mflag) {
/* 1083 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1088 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1090 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1091 */       int i = 0;
/* 1092 */       while (rs.next())
/*      */       {
/* 1094 */         i++;
/*      */ 
/* 1096 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1100 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1104 */         LNPPersonSchema s1 = new LNPPersonSchema();
/* 1105 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1108 */           CError tError = new CError();
/* 1109 */           tError.moduleName = "LNPPersonDB";
/* 1110 */           tError.functionName = "executeQuery";
/* 1111 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 1112 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1114 */         aLNPPersonSet.add(s1);
/*      */       }try {
/* 1116 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1122 */       CError tError = new CError();
/* 1123 */       tError.moduleName = "LNPPersonDB";
/* 1124 */       tError.functionName = "executeQuery";
/* 1125 */       tError.errorMessage = e.toString();
/* 1126 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1128 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1131 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1135 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1141 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1145 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1150 */     return aLNPPersonSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1155 */     Statement stmt = null;
/*      */ 
/* 1157 */     if (!this.mflag) {
/* 1158 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1163 */       stmt = this.con.createStatement(1003, 1007);
/* 1164 */       SQLString sqlObj = new SQLString("LNPPerson");
/* 1165 */       LNPPersonSchema aSchema = getSchema();
/* 1166 */       sqlObj.setSQL(2, aSchema);
/* 1167 */       String sql = "update LNPPerson " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1169 */       int operCount = stmt.executeUpdate(sql);
/* 1170 */       if (operCount == 0)
/*      */       {
/* 1173 */         CError tError = new CError();
/* 1174 */         tError.moduleName = "LNPPersonDB";
/* 1175 */         tError.functionName = "update";
/* 1176 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 1177 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1179 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1183 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1187 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1193 */       CError tError = new CError();
/* 1194 */       tError.moduleName = "LNPPersonDB";
/* 1195 */       tError.functionName = "update";
/* 1196 */       tError.errorMessage = e.toString();
/* 1197 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1199 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1201 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1205 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1209 */       return false;
/*      */     }
/*      */ 
/* 1212 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1216 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1221 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1227 */     if (this.mResultSet != null)
/*      */     {
/* 1230 */       CError tError = new CError();
/* 1231 */       tError.moduleName = "LNPPersonDB";
/* 1232 */       tError.functionName = "prepareData";
/* 1233 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 1234 */       this.mErrors.addOneError(tError);
/* 1235 */       return false;
/*      */     }
/*      */ 
/* 1238 */     if (!this.mflag)
/*      */     {
/* 1240 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1244 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1245 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1250 */       CError tError = new CError();
/* 1251 */       tError.moduleName = "LNPPersonDB";
/* 1252 */       tError.functionName = "prepareData";
/* 1253 */       tError.errorMessage = e.toString();
/* 1254 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1257 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1263 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1267 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1271 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1276 */       return false;
/*      */     }
/*      */ 
/* 1279 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1283 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1288 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1294 */     boolean flag = true;
/* 1295 */     if (this.mResultSet == null)
/*      */     {
/* 1297 */       CError tError = new CError();
/* 1298 */       tError.moduleName = "LNPPersonDB";
/* 1299 */       tError.functionName = "hasMoreData";
/* 1300 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1301 */       this.mErrors.addOneError(tError);
/* 1302 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1306 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1310 */       CError tError = new CError();
/* 1311 */       tError.moduleName = "LNPPersonDB";
/* 1312 */       tError.functionName = "hasMoreData";
/* 1313 */       tError.errorMessage = ex.toString();
/* 1314 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1317 */         this.mResultSet.close();
/* 1318 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1324 */         this.mStatement.close();
/* 1325 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1329 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1333 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1338 */       return false;
/*      */     }
/* 1340 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPPersonSet getData()
/*      */   {
/* 1345 */     int tCount = 0;
/* 1346 */     LNPPersonSet tLNPPersonSet = new LNPPersonSet();
/* 1347 */     LNPPersonSchema tLNPPersonSchema = null;
/* 1348 */     if (this.mResultSet == null)
/*      */     {
/* 1350 */       CError tError = new CError();
/* 1351 */       tError.moduleName = "LNPPersonDB";
/* 1352 */       tError.functionName = "getData";
/* 1353 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1354 */       this.mErrors.addOneError(tError);
/* 1355 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1359 */       tCount = 1;
/* 1360 */       tLNPPersonSchema = new LNPPersonSchema();
/* 1361 */       tLNPPersonSchema.setSchema(this.mResultSet, 1);
/* 1362 */       tLNPPersonSet.add(tLNPPersonSchema);
/*      */ 
/* 1364 */       while (tCount++ < 5000)
/*      */       {
/* 1366 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1368 */         tLNPPersonSchema = new LNPPersonSchema();
/* 1369 */         tLNPPersonSchema.setSchema(this.mResultSet, 1);
/* 1370 */         tLNPPersonSet.add(tLNPPersonSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1376 */       CError tError = new CError();
/* 1377 */       tError.moduleName = "LNPPersonDB";
/* 1378 */       tError.functionName = "getData";
/* 1379 */       tError.errorMessage = ex.toString();
/* 1380 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1383 */         this.mResultSet.close();
/* 1384 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1390 */         this.mStatement.close();
/* 1391 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1395 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1399 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1404 */       return null;
/*      */     }
/* 1406 */     return tLNPPersonSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1411 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1414 */       if (this.mResultSet == null)
/*      */       {
/* 1416 */         CError tError = new CError();
/* 1417 */         tError.moduleName = "LNPPersonDB";
/* 1418 */         tError.functionName = "closeData";
/* 1419 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1420 */         this.mErrors.addOneError(tError);
/* 1421 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1425 */         this.mResultSet.close();
/* 1426 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1431 */       CError tError = new CError();
/* 1432 */       tError.moduleName = "LNPPersonDB";
/* 1433 */       tError.functionName = "closeData";
/* 1434 */       tError.errorMessage = ex2.toString();
/* 1435 */       this.mErrors.addOneError(tError);
/* 1436 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1440 */       if (this.mStatement == null)
/*      */       {
/* 1442 */         CError tError = new CError();
/* 1443 */         tError.moduleName = "LNPPersonDB";
/* 1444 */         tError.functionName = "closeData";
/* 1445 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1446 */         this.mErrors.addOneError(tError);
/* 1447 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1451 */         this.mStatement.close();
/* 1452 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1457 */       CError tError = new CError();
/* 1458 */       tError.moduleName = "LNPPersonDB";
/* 1459 */       tError.functionName = "closeData";
/* 1460 */       tError.errorMessage = ex3.toString();
/* 1461 */       this.mErrors.addOneError(tError);
/* 1462 */       flag = false;
/*      */     }
/* 1464 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPPersonDB
 * JD-Core Version:    0.6.0
 */