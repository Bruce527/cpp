/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MNewClientSchema;
/*      */ import com.sinosoft.map.lis.vschema.MNewClientSet;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.DBConnPool;
/*      */ import com.sinosoft.map.utility.DBOper;
/*      */ import com.sinosoft.map.utility.SQLString;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class MNewClientDB extends MNewClientSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*   23 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   26 */   private ResultSet mResultSet = null;
/*   27 */   private Statement mStatement = null;
/*      */ 
/*      */   public MNewClientDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MNewClient");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MNewClientDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MNewClient");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MNewClientSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MNewClientDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MNewClientSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MNewClientDB";
/*   75 */       tError.functionName = "getCount";
/*   76 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   77 */       this.mErrors.addOneError(tError);
/*      */ 
/*   79 */       return -1;
/*      */     }
/*      */ 
/*   82 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   87 */     PreparedStatement pstmt = null;
/*      */ 
/*   89 */     if (!this.mflag) {
/*   90 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MNewClient WHERE  CustomerNo = ?");
/*   96 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getCustomerNo());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MNewClientDB";
/*  108 */       tError.functionName = "delete()";
/*  109 */       tError.errorMessage = ex.toString();
/*  110 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  113 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  116 */       if (!this.mflag)
/*      */         try {
/*  118 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  122 */       return false;
/*      */     }
/*      */ 
/*  125 */     if (!this.mflag)
/*      */       try {
/*  127 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  131 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  136 */     PreparedStatement pstmt = null;
/*      */ 
/*  138 */     if (!this.mflag) {
/*  139 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MNewClient SET  CustomerNo = ? , CustomerNo2 = ? , ClientName = ? , Gender = ? , Birthday = ? , EMail = ? , GrpZipCode = ? , GrpAddress = ? , GrpNo = ? , BP = ? , GrpAddressCode = ? , Phone2 = ? , GrpName = ? , GrpPhone = ? , Phone = ? , Mobile = ? , OccupationCode = ? , Position = ? , WorkType = ? , OccupationType = ? , HomeAddress = ? , HomeAddressCode = ? , RgtAddress = ? , PostalAddress = ? , ZipCode = ? , HomeZipCode = ? , SequenceNo = ? , Stature = ? , Avoirdupois = ? , SmokeFlag = ? , DeathDate = ? , Marriage = ? , CredentType = ? , CredentNO = ? , OthIDNo = ? , OthIDType = ? , ICNo = ? , Salary = ? , YearSalary = ? , NativePlace = ? , Nationality = ? , MarriageDate = ? , Degree = ? , PolNo = ? , RelationToInsured = ? , PluralityType = ? , StartWorkDate = ? , Health = ? , Password = ? , JoinCompanyDate = ? , AppntGrade = ? , CreditGrade = ? , ClientType = ? , State = ? , Agentcode = ? , SignDate = ? , AddrChoise = ? , CustomeProperty = ? , BirthdayFlag = ? , Appellation = ? , IDDNo = ? , ValidityDate = ? , CountryOrArea = ? , SpecialDate = ? , DeleteFlag = ? , Interest = ? , CustomeType = ? , Introducer = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  CustomerNo = ?");
/*  145 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getCustomerNo());
/*      */       }
/*  150 */       if ((getCustomerNo2() == null) || (getCustomerNo2().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getCustomerNo2());
/*      */       }
/*  155 */       if ((getClientName() == null) || (getClientName().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getClientName());
/*      */       }
/*  160 */       if ((getGender() == null) || (getGender().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getGender());
/*      */       }
/*  165 */       if ((getEMail() == null) || (getEMail().equals("null")))
/*  166 */         pstmt.setNull(6, 12);
/*      */       else {
/*  168 */         pstmt.setString(6, getEMail());
/*      */       }
/*  170 */       if ((getGrpZipCode() == null) || (getGrpZipCode().equals("null")))
/*  171 */         pstmt.setNull(7, 12);
/*      */       else {
/*  173 */         pstmt.setString(7, getGrpZipCode());
/*      */       }
/*  175 */       if ((getGrpAddress() == null) || (getGrpAddress().equals("null")))
/*  176 */         pstmt.setNull(8, 12);
/*      */       else {
/*  178 */         pstmt.setString(8, getGrpAddress());
/*      */       }
/*  180 */       if ((getGrpNo() == null) || (getGrpNo().equals("null")))
/*  181 */         pstmt.setNull(9, 12);
/*      */       else {
/*  183 */         pstmt.setString(9, getGrpNo());
/*      */       }
/*  185 */       if ((getBP() == null) || (getBP().equals("null")))
/*  186 */         pstmt.setNull(10, 12);
/*      */       else {
/*  188 */         pstmt.setString(10, getBP());
/*      */       }
/*  190 */       if ((getGrpAddressCode() == null) || (getGrpAddressCode().equals("null")))
/*  191 */         pstmt.setNull(11, 12);
/*      */       else {
/*  193 */         pstmt.setString(11, getGrpAddressCode());
/*      */       }
/*  195 */       if ((getPhone2() == null) || (getPhone2().equals("null")))
/*  196 */         pstmt.setNull(12, 12);
/*      */       else {
/*  198 */         pstmt.setString(12, getPhone2());
/*      */       }
/*  200 */       if ((getGrpName() == null) || (getGrpName().equals("null")))
/*  201 */         pstmt.setNull(13, 12);
/*      */       else {
/*  203 */         pstmt.setString(13, getGrpName());
/*      */       }
/*  205 */       if ((getGrpPhone() == null) || (getGrpPhone().equals("null")))
/*  206 */         pstmt.setNull(14, 12);
/*      */       else {
/*  208 */         pstmt.setString(14, getGrpPhone());
/*      */       }
/*  210 */       if ((getPhone() == null) || (getPhone().equals("null")))
/*  211 */         pstmt.setNull(15, 12);
/*      */       else {
/*  213 */         pstmt.setString(15, getPhone());
/*      */       }
/*  215 */       if ((getMobile() == null) || (getMobile().equals("null")))
/*  216 */         pstmt.setNull(16, 12);
/*      */       else {
/*  218 */         pstmt.setString(16, getMobile());
/*      */       }
/*  220 */       if ((getOccupationCode() == null) || (getOccupationCode().equals("null")))
/*  221 */         pstmt.setNull(17, 12);
/*      */       else {
/*  223 */         pstmt.setString(17, getOccupationCode());
/*      */       }
/*  225 */       if ((getPosition() == null) || (getPosition().equals("null")))
/*  226 */         pstmt.setNull(18, 12);
/*      */       else {
/*  228 */         pstmt.setString(18, getPosition());
/*      */       }
/*  230 */       if ((getWorkType() == null) || (getWorkType().equals("null")))
/*  231 */         pstmt.setNull(19, 12);
/*      */       else {
/*  233 */         pstmt.setString(19, getWorkType());
/*      */       }
/*  235 */       if ((getOccupationType() == null) || (getOccupationType().equals("null")))
/*  236 */         pstmt.setNull(20, 12);
/*      */       else {
/*  238 */         pstmt.setString(20, getOccupationType());
/*      */       }
/*  240 */       if ((getHomeAddress() == null) || (getHomeAddress().equals("null")))
/*  241 */         pstmt.setNull(21, 12);
/*      */       else {
/*  243 */         pstmt.setString(21, getHomeAddress());
/*      */       }
/*  245 */       if ((getHomeAddressCode() == null) || (getHomeAddressCode().equals("null")))
/*  246 */         pstmt.setNull(22, 12);
/*      */       else {
/*  248 */         pstmt.setString(22, getHomeAddressCode());
/*      */       }
/*  250 */       if ((getRgtAddress() == null) || (getRgtAddress().equals("null")))
/*  251 */         pstmt.setNull(23, 12);
/*      */       else {
/*  253 */         pstmt.setString(23, getRgtAddress());
/*      */       }
/*  255 */       if ((getPostalAddress() == null) || (getPostalAddress().equals("null")))
/*  256 */         pstmt.setNull(24, 12);
/*      */       else {
/*  258 */         pstmt.setString(24, getPostalAddress());
/*      */       }
/*  260 */       if ((getZipCode() == null) || (getZipCode().equals("null")))
/*  261 */         pstmt.setNull(25, 12);
/*      */       else {
/*  263 */         pstmt.setString(25, getZipCode());
/*      */       }
/*  265 */       if ((getHomeZipCode() == null) || (getHomeZipCode().equals("null")))
/*  266 */         pstmt.setNull(26, 12);
/*      */       else {
/*  268 */         pstmt.setString(26, getHomeZipCode());
/*      */       }
/*  270 */       if ((getSequenceNo() == null) || (getSequenceNo().equals("null")))
/*  271 */         pstmt.setNull(27, 12);
/*      */       else {
/*  273 */         pstmt.setString(27, getSequenceNo());
/*      */       }
/*  275 */       pstmt.setDouble(28, getStature());
/*  276 */       pstmt.setDouble(29, getAvoirdupois());
/*  277 */       if ((getSmokeFlag() == null) || (getSmokeFlag().equals("null")))
/*  278 */         pstmt.setNull(30, 12);
/*      */       else {
/*  280 */         pstmt.setString(30, getSmokeFlag());
/*      */       }
/*  282 */       if ((getMarriage() == null) || (getMarriage().equals("null")))
/*  283 */         pstmt.setNull(32, 12);
/*      */       else {
/*  285 */         pstmt.setString(32, getMarriage());
/*      */       }
/*  287 */       if ((getCredentType() == null) || (getCredentType().equals("null")))
/*  288 */         pstmt.setNull(33, 12);
/*      */       else {
/*  290 */         pstmt.setString(33, getCredentType());
/*      */       }
/*  292 */       if ((getCredentNO() == null) || (getCredentNO().equals("null")))
/*  293 */         pstmt.setNull(34, 12);
/*      */       else {
/*  295 */         pstmt.setString(34, getCredentNO());
/*      */       }
/*  297 */       if ((getOthIDNo() == null) || (getOthIDNo().equals("null")))
/*  298 */         pstmt.setNull(35, 12);
/*      */       else {
/*  300 */         pstmt.setString(35, getOthIDNo());
/*      */       }
/*  302 */       if ((getOthIDType() == null) || (getOthIDType().equals("null")))
/*  303 */         pstmt.setNull(36, 12);
/*      */       else {
/*  305 */         pstmt.setString(36, getOthIDType());
/*      */       }
/*  307 */       if ((getICNo() == null) || (getICNo().equals("null")))
/*  308 */         pstmt.setNull(37, 12);
/*      */       else {
/*  310 */         pstmt.setString(37, getICNo());
/*      */       }
/*  312 */       if ((getNativePlace() == null) || (getNativePlace().equals("null")))
/*  313 */         pstmt.setNull(40, 12);
/*      */       else {
/*  315 */         pstmt.setString(40, getNativePlace());
/*      */       }
/*  317 */       if ((getNationality() == null) || (getNationality().equals("null")))
/*  318 */         pstmt.setNull(41, 12);
/*      */       else {
/*  320 */         pstmt.setString(41, getNationality());
/*      */       }
/*  322 */       if ((getDegree() == null) || (getDegree().equals("null")))
/*  323 */         pstmt.setNull(43, 12);
/*      */       else {
/*  325 */         pstmt.setString(43, getDegree());
/*      */       }
/*  327 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  328 */         pstmt.setNull(44, 12);
/*      */       else {
/*  330 */         pstmt.setString(44, getPolNo());
/*      */       }
/*  332 */       if ((getRelationToInsured() == null) || (getRelationToInsured().equals("null")))
/*  333 */         pstmt.setNull(45, 12);
/*      */       else {
/*  335 */         pstmt.setString(45, getRelationToInsured());
/*      */       }
/*  337 */       if ((getPluralityType() == null) || (getPluralityType().equals("null")))
/*  338 */         pstmt.setNull(46, 12);
/*      */       else {
/*  340 */         pstmt.setString(46, getPluralityType());
/*      */       }
/*  342 */       if ((getHealth() == null) || (getHealth().equals("null")))
/*  343 */         pstmt.setNull(48, 12);
/*      */       else {
/*  345 */         pstmt.setString(48, getHealth());
/*      */       }
/*  347 */       if ((getPassword() == null) || (getPassword().equals("null")))
/*  348 */         pstmt.setNull(49, 12);
/*      */       else {
/*  350 */         pstmt.setString(49, getPassword());
/*      */       }
/*  352 */       if ((getAppntGrade() == null) || (getAppntGrade().equals("null")))
/*  353 */         pstmt.setNull(51, 12);
/*      */       else {
/*  355 */         pstmt.setString(51, getAppntGrade());
/*      */       }
/*  357 */       if ((getCreditGrade() == null) || (getCreditGrade().equals("null")))
/*  358 */         pstmt.setNull(52, 12);
/*      */       else {
/*  360 */         pstmt.setString(52, getCreditGrade());
/*      */       }
/*  362 */       if ((getClientType() == null) || (getClientType().equals("null")))
/*  363 */         pstmt.setNull(53, 12);
/*      */       else {
/*  365 */         pstmt.setString(53, getClientType());
/*      */       }
/*  367 */       if ((getState() == null) || (getState().equals("null")))
/*  368 */         pstmt.setNull(54, 12);
/*      */       else {
/*  370 */         pstmt.setString(54, getState());
/*      */       }
/*  372 */       if ((getAgentcode() == null) || (getAgentcode().equals("null")))
/*  373 */         pstmt.setNull(55, 12);
/*      */       else {
/*  375 */         pstmt.setString(55, getAgentcode());
/*      */       }
/*  377 */       if ((getAddrChoise() == null) || (getAddrChoise().equals("null")))
/*  378 */         pstmt.setNull(57, 12);
/*      */       else {
/*  380 */         pstmt.setString(57, getAddrChoise());
/*      */       }
/*  382 */       if ((getCustomeProperty() == null) || (getCustomeProperty().equals("null")))
/*  383 */         pstmt.setNull(58, 12);
/*      */       else {
/*  385 */         pstmt.setString(58, getCustomeProperty());
/*      */       }
/*  387 */       if ((getBirthdayFlag() == null) || (getBirthdayFlag().equals("null")))
/*  388 */         pstmt.setNull(59, 12);
/*      */       else {
/*  390 */         pstmt.setString(59, getBirthdayFlag());
/*      */       }
/*  392 */       if ((getAppellation() == null) || (getAppellation().equals("null")))
/*  393 */         pstmt.setNull(60, 12);
/*      */       else {
/*  395 */         pstmt.setString(60, getAppellation());
/*      */       }
/*  397 */       if ((getIDDNo() == null) || (getIDDNo().equals("null")))
/*  398 */         pstmt.setNull(61, 12);
/*      */       else {
/*  400 */         pstmt.setString(61, getIDDNo());
/*      */       }
/*  402 */       if ((getCountryOrArea() == null) || (getCountryOrArea().equals("null")))
/*  403 */         pstmt.setNull(63, 12);
/*      */       else {
/*  405 */         pstmt.setString(63, getCountryOrArea());
/*      */       }
/*  407 */       if ((getDeleteFlag() == null) || (getDeleteFlag().equals("null")))
/*  408 */         pstmt.setNull(65, 12);
/*      */       else {
/*  410 */         pstmt.setString(65, getDeleteFlag());
/*      */       }
/*  412 */       if ((getInterest() == null) || (getInterest().equals("null")))
/*  413 */         pstmt.setNull(66, 12);
/*      */       else {
/*  415 */         pstmt.setString(66, getInterest());
/*      */       }
/*  417 */       if ((getCustomeType() == null) || (getCustomeType().equals("null")))
/*  418 */         pstmt.setNull(67, 12);
/*      */       else {
/*  420 */         pstmt.setString(67, getCustomeType());
/*      */       }
/*  422 */       if ((getIntroducer() == null) || (getIntroducer().equals("null")))
/*  423 */         pstmt.setNull(68, 12);
/*      */       else {
/*  425 */         pstmt.setString(68, getIntroducer());
/*      */       }
/*  427 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  428 */         pstmt.setNull(69, 12);
/*      */       else {
/*  430 */         pstmt.setString(69, getOperator());
/*      */       }
/*  432 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  433 */         pstmt.setNull(71, 12);
/*      */       else {
/*  435 */         pstmt.setString(71, getMakeTime());
/*      */       }
/*  437 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  438 */         pstmt.setNull(73, 12);
/*      */       else {
/*  440 */         pstmt.setString(73, getModifyTime());
/*      */       }
/*      */ 
/*  443 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  444 */         pstmt.setNull(74, 12);
/*      */       else {
/*  446 */         pstmt.setString(74, getCustomerNo());
/*      */       }
/*  448 */       pstmt.executeUpdate();
/*  449 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  452 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  453 */       CError tError = new CError();
/*  454 */       tError.moduleName = "MNewClientDB";
/*  455 */       tError.functionName = "update()";
/*  456 */       tError.errorMessage = ex.toString();
/*  457 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  460 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  463 */       if (!this.mflag)
/*      */         try {
/*  465 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  469 */       return false;
/*      */     }
/*      */ 
/*  472 */     if (!this.mflag)
/*      */       try {
/*  474 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  478 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  483 */     PreparedStatement pstmt = null;
/*      */ 
/*  485 */     if (!this.mflag) {
/*  486 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  491 */       pstmt = this.con.prepareStatement("INSERT INTO MNewClient VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  492 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  493 */         pstmt.setNull(1, 12);
/*      */       else {
/*  495 */         pstmt.setString(1, getCustomerNo());
/*      */       }
/*  497 */       if ((getCustomerNo2() == null) || (getCustomerNo2().equals("null")))
/*  498 */         pstmt.setNull(2, 12);
/*      */       else {
/*  500 */         pstmt.setString(2, getCustomerNo2());
/*      */       }
/*  502 */       if ((getClientName() == null) || (getClientName().equals("null")))
/*  503 */         pstmt.setNull(3, 12);
/*      */       else {
/*  505 */         pstmt.setString(3, getClientName());
/*      */       }
/*  507 */       if ((getGender() == null) || (getGender().equals("null")))
/*  508 */         pstmt.setNull(4, 12);
/*      */       else {
/*  510 */         pstmt.setString(4, getGender());
/*      */       }
/*  512 */       if ((getEMail() == null) || (getEMail().equals("null")))
/*  513 */         pstmt.setNull(6, 12);
/*      */       else {
/*  515 */         pstmt.setString(6, getEMail());
/*      */       }
/*  517 */       if ((getGrpZipCode() == null) || (getGrpZipCode().equals("null")))
/*  518 */         pstmt.setNull(7, 12);
/*      */       else {
/*  520 */         pstmt.setString(7, getGrpZipCode());
/*      */       }
/*  522 */       if ((getGrpAddress() == null) || (getGrpAddress().equals("null")))
/*  523 */         pstmt.setNull(8, 12);
/*      */       else {
/*  525 */         pstmt.setString(8, getGrpAddress());
/*      */       }
/*  527 */       if ((getGrpNo() == null) || (getGrpNo().equals("null")))
/*  528 */         pstmt.setNull(9, 12);
/*      */       else {
/*  530 */         pstmt.setString(9, getGrpNo());
/*      */       }
/*  532 */       if ((getBP() == null) || (getBP().equals("null")))
/*  533 */         pstmt.setNull(10, 12);
/*      */       else {
/*  535 */         pstmt.setString(10, getBP());
/*      */       }
/*  537 */       if ((getGrpAddressCode() == null) || (getGrpAddressCode().equals("null")))
/*  538 */         pstmt.setNull(11, 12);
/*      */       else {
/*  540 */         pstmt.setString(11, getGrpAddressCode());
/*      */       }
/*  542 */       if ((getPhone2() == null) || (getPhone2().equals("null")))
/*  543 */         pstmt.setNull(12, 12);
/*      */       else {
/*  545 */         pstmt.setString(12, getPhone2());
/*      */       }
/*  547 */       if ((getGrpName() == null) || (getGrpName().equals("null")))
/*  548 */         pstmt.setNull(13, 12);
/*      */       else {
/*  550 */         pstmt.setString(13, getGrpName());
/*      */       }
/*  552 */       if ((getGrpPhone() == null) || (getGrpPhone().equals("null")))
/*  553 */         pstmt.setNull(14, 12);
/*      */       else {
/*  555 */         pstmt.setString(14, getGrpPhone());
/*      */       }
/*  557 */       if ((getPhone() == null) || (getPhone().equals("null")))
/*  558 */         pstmt.setNull(15, 12);
/*      */       else {
/*  560 */         pstmt.setString(15, getPhone());
/*      */       }
/*  562 */       if ((getMobile() == null) || (getMobile().equals("null")))
/*  563 */         pstmt.setNull(16, 12);
/*      */       else {
/*  565 */         pstmt.setString(16, getMobile());
/*      */       }
/*  567 */       if ((getOccupationCode() == null) || (getOccupationCode().equals("null")))
/*  568 */         pstmt.setNull(17, 12);
/*      */       else {
/*  570 */         pstmt.setString(17, getOccupationCode());
/*      */       }
/*  572 */       if ((getPosition() == null) || (getPosition().equals("null")))
/*  573 */         pstmt.setNull(18, 12);
/*      */       else {
/*  575 */         pstmt.setString(18, getPosition());
/*      */       }
/*  577 */       if ((getWorkType() == null) || (getWorkType().equals("null")))
/*  578 */         pstmt.setNull(19, 12);
/*      */       else {
/*  580 */         pstmt.setString(19, getWorkType());
/*      */       }
/*  582 */       if ((getOccupationType() == null) || (getOccupationType().equals("null")))
/*  583 */         pstmt.setNull(20, 12);
/*      */       else {
/*  585 */         pstmt.setString(20, getOccupationType());
/*      */       }
/*  587 */       if ((getHomeAddress() == null) || (getHomeAddress().equals("null")))
/*  588 */         pstmt.setNull(21, 12);
/*      */       else {
/*  590 */         pstmt.setString(21, getHomeAddress());
/*      */       }
/*  592 */       if ((getHomeAddressCode() == null) || (getHomeAddressCode().equals("null")))
/*  593 */         pstmt.setNull(22, 12);
/*      */       else {
/*  595 */         pstmt.setString(22, getHomeAddressCode());
/*      */       }
/*  597 */       if ((getRgtAddress() == null) || (getRgtAddress().equals("null")))
/*  598 */         pstmt.setNull(23, 12);
/*      */       else {
/*  600 */         pstmt.setString(23, getRgtAddress());
/*      */       }
/*  602 */       if ((getPostalAddress() == null) || (getPostalAddress().equals("null")))
/*  603 */         pstmt.setNull(24, 12);
/*      */       else {
/*  605 */         pstmt.setString(24, getPostalAddress());
/*      */       }
/*  607 */       if ((getZipCode() == null) || (getZipCode().equals("null")))
/*  608 */         pstmt.setNull(25, 12);
/*      */       else {
/*  610 */         pstmt.setString(25, getZipCode());
/*      */       }
/*  612 */       if ((getHomeZipCode() == null) || (getHomeZipCode().equals("null")))
/*  613 */         pstmt.setNull(26, 12);
/*      */       else {
/*  615 */         pstmt.setString(26, getHomeZipCode());
/*      */       }
/*  617 */       if ((getSequenceNo() == null) || (getSequenceNo().equals("null")))
/*  618 */         pstmt.setNull(27, 12);
/*      */       else {
/*  620 */         pstmt.setString(27, getSequenceNo());
/*      */       }
/*  622 */       pstmt.setDouble(28, getStature());
/*  623 */       pstmt.setDouble(29, getAvoirdupois());
/*  624 */       if ((getSmokeFlag() == null) || (getSmokeFlag().equals("null")))
/*  625 */         pstmt.setNull(30, 12);
/*      */       else {
/*  627 */         pstmt.setString(30, getSmokeFlag());
/*      */       }
/*  629 */       if ((getMarriage() == null) || (getMarriage().equals("null")))
/*  630 */         pstmt.setNull(32, 12);
/*      */       else {
/*  632 */         pstmt.setString(32, getMarriage());
/*      */       }
/*  634 */       if ((getCredentType() == null) || (getCredentType().equals("null")))
/*  635 */         pstmt.setNull(33, 12);
/*      */       else {
/*  637 */         pstmt.setString(33, getCredentType());
/*      */       }
/*  639 */       if ((getCredentNO() == null) || (getCredentNO().equals("null")))
/*  640 */         pstmt.setNull(34, 12);
/*      */       else {
/*  642 */         pstmt.setString(34, getCredentNO());
/*      */       }
/*  644 */       if ((getOthIDNo() == null) || (getOthIDNo().equals("null")))
/*  645 */         pstmt.setNull(35, 12);
/*      */       else {
/*  647 */         pstmt.setString(35, getOthIDNo());
/*      */       }
/*  649 */       if ((getOthIDType() == null) || (getOthIDType().equals("null")))
/*  650 */         pstmt.setNull(36, 12);
/*      */       else {
/*  652 */         pstmt.setString(36, getOthIDType());
/*      */       }
/*  654 */       if ((getICNo() == null) || (getICNo().equals("null")))
/*  655 */         pstmt.setNull(37, 12);
/*      */       else {
/*  657 */         pstmt.setString(37, getICNo());
/*      */       }
/*  659 */       if ((getNativePlace() == null) || (getNativePlace().equals("null")))
/*  660 */         pstmt.setNull(40, 12);
/*      */       else {
/*  662 */         pstmt.setString(40, getNativePlace());
/*      */       }
/*  664 */       if ((getNationality() == null) || (getNationality().equals("null")))
/*  665 */         pstmt.setNull(41, 12);
/*      */       else {
/*  667 */         pstmt.setString(41, getNationality());
/*      */       }
/*  669 */       if ((getDegree() == null) || (getDegree().equals("null")))
/*  670 */         pstmt.setNull(43, 12);
/*      */       else {
/*  672 */         pstmt.setString(43, getDegree());
/*      */       }
/*  674 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  675 */         pstmt.setNull(44, 12);
/*      */       else {
/*  677 */         pstmt.setString(44, getPolNo());
/*      */       }
/*  679 */       if ((getRelationToInsured() == null) || (getRelationToInsured().equals("null")))
/*  680 */         pstmt.setNull(45, 12);
/*      */       else {
/*  682 */         pstmt.setString(45, getRelationToInsured());
/*      */       }
/*  684 */       if ((getPluralityType() == null) || (getPluralityType().equals("null")))
/*  685 */         pstmt.setNull(46, 12);
/*      */       else {
/*  687 */         pstmt.setString(46, getPluralityType());
/*      */       }
/*  689 */       if ((getHealth() == null) || (getHealth().equals("null")))
/*  690 */         pstmt.setNull(48, 12);
/*      */       else {
/*  692 */         pstmt.setString(48, getHealth());
/*      */       }
/*  694 */       if ((getPassword() == null) || (getPassword().equals("null")))
/*  695 */         pstmt.setNull(49, 12);
/*      */       else {
/*  697 */         pstmt.setString(49, getPassword());
/*      */       }
/*  699 */       if ((getAppntGrade() == null) || (getAppntGrade().equals("null")))
/*  700 */         pstmt.setNull(51, 12);
/*      */       else {
/*  702 */         pstmt.setString(51, getAppntGrade());
/*      */       }
/*  704 */       if ((getCreditGrade() == null) || (getCreditGrade().equals("null")))
/*  705 */         pstmt.setNull(52, 12);
/*      */       else {
/*  707 */         pstmt.setString(52, getCreditGrade());
/*      */       }
/*  709 */       if ((getClientType() == null) || (getClientType().equals("null")))
/*  710 */         pstmt.setNull(53, 12);
/*      */       else {
/*  712 */         pstmt.setString(53, getClientType());
/*      */       }
/*  714 */       if ((getState() == null) || (getState().equals("null")))
/*  715 */         pstmt.setNull(54, 12);
/*      */       else {
/*  717 */         pstmt.setString(54, getState());
/*      */       }
/*  719 */       if ((getAgentcode() == null) || (getAgentcode().equals("null")))
/*  720 */         pstmt.setNull(55, 12);
/*      */       else {
/*  722 */         pstmt.setString(55, getAgentcode());
/*      */       }
/*  724 */       if ((getAddrChoise() == null) || (getAddrChoise().equals("null")))
/*  725 */         pstmt.setNull(57, 12);
/*      */       else {
/*  727 */         pstmt.setString(57, getAddrChoise());
/*      */       }
/*  729 */       if ((getCustomeProperty() == null) || (getCustomeProperty().equals("null")))
/*  730 */         pstmt.setNull(58, 12);
/*      */       else {
/*  732 */         pstmt.setString(58, getCustomeProperty());
/*      */       }
/*  734 */       if ((getBirthdayFlag() == null) || (getBirthdayFlag().equals("null")))
/*  735 */         pstmt.setNull(59, 12);
/*      */       else {
/*  737 */         pstmt.setString(59, getBirthdayFlag());
/*      */       }
/*  739 */       if ((getAppellation() == null) || (getAppellation().equals("null")))
/*  740 */         pstmt.setNull(60, 12);
/*      */       else {
/*  742 */         pstmt.setString(60, getAppellation());
/*      */       }
/*  744 */       if ((getIDDNo() == null) || (getIDDNo().equals("null")))
/*  745 */         pstmt.setNull(61, 12);
/*      */       else {
/*  747 */         pstmt.setString(61, getIDDNo());
/*      */       }
/*  749 */       if ((getCountryOrArea() == null) || (getCountryOrArea().equals("null")))
/*  750 */         pstmt.setNull(63, 12);
/*      */       else {
/*  752 */         pstmt.setString(63, getCountryOrArea());
/*      */       }
/*  754 */       if ((getDeleteFlag() == null) || (getDeleteFlag().equals("null")))
/*  755 */         pstmt.setNull(65, 12);
/*      */       else {
/*  757 */         pstmt.setString(65, getDeleteFlag());
/*      */       }
/*  759 */       if ((getInterest() == null) || (getInterest().equals("null")))
/*  760 */         pstmt.setNull(66, 12);
/*      */       else {
/*  762 */         pstmt.setString(66, getInterest());
/*      */       }
/*  764 */       if ((getCustomeType() == null) || (getCustomeType().equals("null")))
/*  765 */         pstmt.setNull(67, 12);
/*      */       else {
/*  767 */         pstmt.setString(67, getCustomeType());
/*      */       }
/*  769 */       if ((getIntroducer() == null) || (getIntroducer().equals("null")))
/*  770 */         pstmt.setNull(68, 12);
/*      */       else {
/*  772 */         pstmt.setString(68, getIntroducer());
/*      */       }
/*  774 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  775 */         pstmt.setNull(69, 12);
/*      */       else {
/*  777 */         pstmt.setString(69, getOperator());
/*      */       }
/*  779 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  780 */         pstmt.setNull(71, 12);
/*      */       else {
/*  782 */         pstmt.setString(71, getMakeTime());
/*      */       }
/*  784 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  785 */         pstmt.setNull(73, 12);
/*      */       else {
/*  787 */         pstmt.setString(73, getModifyTime());
/*      */       }
/*      */ 
/*  790 */       pstmt.executeUpdate();
/*  791 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  794 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  795 */       CError tError = new CError();
/*  796 */       tError.moduleName = "MNewClientDB";
/*  797 */       tError.functionName = "insert()";
/*  798 */       tError.errorMessage = ex.toString();
/*  799 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  802 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  805 */       if (!this.mflag)
/*      */         try {
/*  807 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  811 */       return false;
/*      */     }
/*      */ 
/*  814 */     if (!this.mflag)
/*      */       try {
/*  816 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  820 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  825 */     PreparedStatement pstmt = null;
/*  826 */     ResultSet rs = null;
/*      */ 
/*  828 */     if (!this.mflag) {
/*  829 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  834 */       pstmt = this.con.prepareStatement("SELECT * FROM MNewClient WHERE  CustomerNo = ?", 
/*  835 */         1003, 1007);
/*  836 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  837 */         pstmt.setNull(1, 12);
/*      */       else {
/*  839 */         pstmt.setString(1, getCustomerNo());
/*      */       }
/*  841 */       rs = pstmt.executeQuery();
/*  842 */       int i = 0;
/*  843 */       if (rs.next())
/*      */       {
/*  845 */         i++;
/*  846 */         if (!setSchema(rs, i))
/*      */         {
/*  849 */           CError tError = new CError();
/*  850 */           tError.moduleName = "MNewClientDB";
/*  851 */           tError.functionName = "getInfo";
/*  852 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  853 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  855 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  858 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  862 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  866 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  870 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  873 */       if (i == 0)
/*      */       {
/*  875 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  879 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  883 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  889 */       CError tError = new CError();
/*  890 */       tError.moduleName = "MNewClientDB";
/*  891 */       tError.functionName = "getInfo";
/*  892 */       tError.errorMessage = e.toString();
/*  893 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  895 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  898 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  902 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  906 */       return false;
/*      */     }
/*      */ 
/*  909 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  913 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  918 */     return true;
/*      */   }
/*      */ 
/*      */   public MNewClientSet query()
/*      */   {
/*  923 */     Statement stmt = null;
/*  924 */     ResultSet rs = null;
/*  925 */     MNewClientSet aMNewClientSet = new MNewClientSet();
/*      */ 
/*  927 */     if (!this.mflag) {
/*  928 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  933 */       stmt = this.con.createStatement(1003, 1007);
/*  934 */       SQLString sqlObj = new SQLString("MNewClient");
/*  935 */       MNewClientSchema aSchema = getSchema();
/*  936 */       sqlObj.setSQL(5, aSchema);
/*  937 */       String sql = sqlObj.getSQL();
/*      */ 
/*  939 */       rs = stmt.executeQuery(sql);
/*  940 */       int i = 0;
/*  941 */       while (rs.next())
/*      */       {
/*  943 */         i++;
/*  944 */         MNewClientSchema s1 = new MNewClientSchema();
/*  945 */         s1.setSchema(rs, i);
/*  946 */         aMNewClientSet.add(s1);
/*      */       }try {
/*  948 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  954 */       CError tError = new CError();
/*  955 */       tError.moduleName = "MNewClientDB";
/*  956 */       tError.functionName = "query";
/*  957 */       tError.errorMessage = e.toString();
/*  958 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  960 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  963 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  967 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  973 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  977 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  982 */     return aMNewClientSet;
/*      */   }
/*      */ 
/*      */   public MNewClientSet executeQuery(String sql)
/*      */   {
/*  987 */     Statement stmt = null;
/*  988 */     ResultSet rs = null;
/*  989 */     MNewClientSet aMNewClientSet = new MNewClientSet();
/*      */ 
/*  991 */     if (!this.mflag) {
/*  992 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  997 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  999 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1000 */       int i = 0;
/* 1001 */       while (rs.next())
/*      */       {
/* 1003 */         i++;
/* 1004 */         MNewClientSchema s1 = new MNewClientSchema();
/* 1005 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1008 */           CError tError = new CError();
/* 1009 */           tError.moduleName = "MNewClientDB";
/* 1010 */           tError.functionName = "executeQuery";
/* 1011 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 1012 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1014 */         aMNewClientSet.add(s1);
/*      */       }try {
/* 1016 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1022 */       CError tError = new CError();
/* 1023 */       tError.moduleName = "MNewClientDB";
/* 1024 */       tError.functionName = "executeQuery";
/* 1025 */       tError.errorMessage = e.toString();
/* 1026 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1028 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1031 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1035 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1041 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1045 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1050 */     return aMNewClientSet;
/*      */   }
/*      */ 
/*      */   public MNewClientSet query(int nStart, int nCount)
/*      */   {
/* 1055 */     Statement stmt = null;
/* 1056 */     ResultSet rs = null;
/* 1057 */     MNewClientSet aMNewClientSet = new MNewClientSet();
/*      */ 
/* 1059 */     if (!this.mflag) {
/* 1060 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1065 */       stmt = this.con.createStatement(1003, 1007);
/* 1066 */       SQLString sqlObj = new SQLString("MNewClient");
/* 1067 */       MNewClientSchema aSchema = getSchema();
/* 1068 */       sqlObj.setSQL(5, aSchema);
/* 1069 */       String sql = sqlObj.getSQL();
/*      */ 
/* 1071 */       rs = stmt.executeQuery(sql);
/* 1072 */       int i = 0;
/* 1073 */       while (rs.next())
/*      */       {
/* 1075 */         i++;
/*      */ 
/* 1077 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1081 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1085 */         MNewClientSchema s1 = new MNewClientSchema();
/* 1086 */         s1.setSchema(rs, i);
/* 1087 */         aMNewClientSet.add(s1);
/*      */       }try {
/* 1089 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1095 */       CError tError = new CError();
/* 1096 */       tError.moduleName = "MNewClientDB";
/* 1097 */       tError.functionName = "query";
/* 1098 */       tError.errorMessage = e.toString();
/* 1099 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1101 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1104 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1108 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1114 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1118 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1123 */     return aMNewClientSet;
/*      */   }
/*      */ 
/*      */   public MNewClientSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/* 1128 */     Statement stmt = null;
/* 1129 */     ResultSet rs = null;
/* 1130 */     MNewClientSet aMNewClientSet = new MNewClientSet();
/*      */ 
/* 1132 */     if (!this.mflag) {
/* 1133 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1138 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1140 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1141 */       int i = 0;
/* 1142 */       while (rs.next())
/*      */       {
/* 1144 */         i++;
/*      */ 
/* 1146 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1150 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1154 */         MNewClientSchema s1 = new MNewClientSchema();
/* 1155 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1158 */           CError tError = new CError();
/* 1159 */           tError.moduleName = "MNewClientDB";
/* 1160 */           tError.functionName = "executeQuery";
/* 1161 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 1162 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1164 */         aMNewClientSet.add(s1);
/*      */       }try {
/* 1166 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1172 */       CError tError = new CError();
/* 1173 */       tError.moduleName = "MNewClientDB";
/* 1174 */       tError.functionName = "executeQuery";
/* 1175 */       tError.errorMessage = e.toString();
/* 1176 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1178 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1181 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1185 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1191 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1195 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1200 */     return aMNewClientSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1205 */     Statement stmt = null;
/*      */ 
/* 1207 */     if (!this.mflag) {
/* 1208 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1213 */       stmt = this.con.createStatement(1003, 1007);
/* 1214 */       SQLString sqlObj = new SQLString("MNewClient");
/* 1215 */       MNewClientSchema aSchema = getSchema();
/* 1216 */       sqlObj.setSQL(2, aSchema);
/* 1217 */       String sql = "update MNewClient " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1219 */       int operCount = stmt.executeUpdate(sql);
/* 1220 */       if (operCount == 0)
/*      */       {
/* 1223 */         CError tError = new CError();
/* 1224 */         tError.moduleName = "MNewClientDB";
/* 1225 */         tError.functionName = "update";
/* 1226 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/* 1227 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1229 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1233 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1237 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1243 */       CError tError = new CError();
/* 1244 */       tError.moduleName = "MNewClientDB";
/* 1245 */       tError.functionName = "update";
/* 1246 */       tError.errorMessage = e.toString();
/* 1247 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1249 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1251 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1255 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1259 */       return false;
/*      */     }
/*      */ 
/* 1262 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1266 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1271 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1277 */     if (this.mResultSet != null)
/*      */     {
/* 1280 */       CError tError = new CError();
/* 1281 */       tError.moduleName = "MNewClientDB";
/* 1282 */       tError.functionName = "prepareData";
/* 1283 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 1284 */       this.mErrors.addOneError(tError);
/* 1285 */       return false;
/*      */     }
/*      */ 
/* 1288 */     if (!this.mflag)
/*      */     {
/* 1290 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1294 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1295 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1300 */       CError tError = new CError();
/* 1301 */       tError.moduleName = "MNewClientDB";
/* 1302 */       tError.functionName = "prepareData";
/* 1303 */       tError.errorMessage = e.toString();
/* 1304 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1307 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1313 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1317 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1321 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1326 */       return false;
/*      */     }
/*      */ 
/* 1329 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1333 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1338 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1344 */     boolean flag = true;
/* 1345 */     if (this.mResultSet == null)
/*      */     {
/* 1347 */       CError tError = new CError();
/* 1348 */       tError.moduleName = "MNewClientDB";
/* 1349 */       tError.functionName = "hasMoreData";
/* 1350 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1351 */       this.mErrors.addOneError(tError);
/* 1352 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1356 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1360 */       CError tError = new CError();
/* 1361 */       tError.moduleName = "MNewClientDB";
/* 1362 */       tError.functionName = "hasMoreData";
/* 1363 */       tError.errorMessage = ex.toString();
/* 1364 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1367 */         this.mResultSet.close();
/* 1368 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1374 */         this.mStatement.close();
/* 1375 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1379 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1383 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1388 */       return false;
/*      */     }
/* 1390 */     return flag;
/*      */   }
/*      */ 
/*      */   public MNewClientSet getData()
/*      */   {
/* 1395 */     int tCount = 0;
/* 1396 */     MNewClientSet tMNewClientSet = new MNewClientSet();
/* 1397 */     MNewClientSchema tMNewClientSchema = null;
/* 1398 */     if (this.mResultSet == null)
/*      */     {
/* 1400 */       CError tError = new CError();
/* 1401 */       tError.moduleName = "MNewClientDB";
/* 1402 */       tError.functionName = "getData";
/* 1403 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1404 */       this.mErrors.addOneError(tError);
/* 1405 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1409 */       tCount = 1;
/* 1410 */       tMNewClientSchema = new MNewClientSchema();
/* 1411 */       tMNewClientSchema.setSchema(this.mResultSet, 1);
/* 1412 */       tMNewClientSet.add(tMNewClientSchema);
/*      */ 
/* 1414 */       while (tCount++ < 5000)
/*      */       {
/* 1416 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1418 */         tMNewClientSchema = new MNewClientSchema();
/* 1419 */         tMNewClientSchema.setSchema(this.mResultSet, 1);
/* 1420 */         tMNewClientSet.add(tMNewClientSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1426 */       CError tError = new CError();
/* 1427 */       tError.moduleName = "MNewClientDB";
/* 1428 */       tError.functionName = "getData";
/* 1429 */       tError.errorMessage = ex.toString();
/* 1430 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1433 */         this.mResultSet.close();
/* 1434 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1440 */         this.mStatement.close();
/* 1441 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1445 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1449 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1454 */       return null;
/*      */     }
/* 1456 */     return tMNewClientSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1461 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1464 */       if (this.mResultSet == null)
/*      */       {
/* 1466 */         CError tError = new CError();
/* 1467 */         tError.moduleName = "MNewClientDB";
/* 1468 */         tError.functionName = "closeData";
/* 1469 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1470 */         this.mErrors.addOneError(tError);
/* 1471 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1475 */         this.mResultSet.close();
/* 1476 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1481 */       CError tError = new CError();
/* 1482 */       tError.moduleName = "MNewClientDB";
/* 1483 */       tError.functionName = "closeData";
/* 1484 */       tError.errorMessage = ex2.toString();
/* 1485 */       this.mErrors.addOneError(tError);
/* 1486 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1490 */       if (this.mStatement == null)
/*      */       {
/* 1492 */         CError tError = new CError();
/* 1493 */         tError.moduleName = "MNewClientDB";
/* 1494 */         tError.functionName = "closeData";
/* 1495 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1496 */         this.mErrors.addOneError(tError);
/* 1497 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1501 */         this.mStatement.close();
/* 1502 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1507 */       CError tError = new CError();
/* 1508 */       tError.moduleName = "MNewClientDB";
/* 1509 */       tError.functionName = "closeData";
/* 1510 */       tError.errorMessage = ex3.toString();
/* 1511 */       this.mErrors.addOneError(tError);
/* 1512 */       flag = false;
/*      */     }
/* 1514 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MNewClientDB
 * JD-Core Version:    0.6.0
 */