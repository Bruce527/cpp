/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
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
/*      */ public class LNPAddressDB extends LNPAddressSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   20 */   private boolean mflag = false;
/*      */ 
/*   22 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   24 */   private ResultSet mResultSet = null;
/*   25 */   private Statement mStatement = null;
/*      */ 
/*      */   public LNPAddressDB(Connection tConnection)
/*      */   {
/*   29 */     this.con = tConnection;
/*   30 */     this.db = new DBOper(this.con, "LNPAddress");
/*   31 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPAddressDB()
/*      */   {
/*   36 */     this.con = null;
/*   37 */     this.db = new DBOper("LNPAddress");
/*   38 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   43 */     LNPAddressSchema tSchema = getSchema();
/*   44 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   46 */       return true;
/*      */     }
/*      */ 
/*   50 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   51 */     CError tError = new CError();
/*   52 */     tError.moduleName = "LNPAddressDB";
/*   53 */     tError.functionName = "deleteSQL";
/*   54 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   55 */     this.mErrors.addOneError(tError);
/*   56 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   62 */     LNPAddressSchema tSchema = getSchema();
/*      */ 
/*   64 */     int tCount = this.db.getCount(tSchema);
/*   65 */     if (tCount < 0)
/*      */     {
/*   67 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   68 */       CError tError = new CError();
/*   69 */       tError.moduleName = "LNPAddressDB";
/*   70 */       tError.functionName = "getCount";
/*   71 */       tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   72 */       this.mErrors.addOneError(tError);
/*      */ 
/*   74 */       return -1;
/*      */     }
/*      */ 
/*   77 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   82 */     PreparedStatement pstmt = null;
/*      */ 
/*   84 */     if (!this.mflag) {
/*   85 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   90 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAddress WHERE  CustomerId = ? AND AddressNo = ?");
/*   91 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*   92 */         pstmt.setNull(1, 12);
/*      */       else {
/*   94 */         pstmt.setString(1, getCustomerId());
/*      */       }
/*   96 */       if ((getAddressNo() == null) || (getAddressNo().equals("null")))
/*   97 */         pstmt.setNull(2, 12);
/*      */       else {
/*   99 */         pstmt.setString(2, getAddressNo());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     } catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "LNPAddressDB";
/*  107 */       tError.functionName = "delete()";
/*  108 */       tError.errorMessage = ex.toString();
/*  109 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  112 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  115 */       if (!this.mflag)
/*      */         try {
/*  117 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  121 */       return false;
/*      */     }
/*      */ 
/*  124 */     if (!this.mflag)
/*      */       try {
/*  126 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  130 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  135 */     PreparedStatement pstmt = null;
/*      */ 
/*  137 */     if (!this.mflag) {
/*  138 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  143 */       pstmt = this.con.prepareStatement("UPDATE LNPAddress SET  CustomerId = ? , CustomerNo = ? , AddressNo = ? , PostalAddress = ? , ZipCode = ? , Phone = ? , Fax = ? , duchy = ? , HomeAddress = ? , HomeZipCode = ? , HomePhone = ? , HomeFax = ? , CompanyAddress = ? , CompanyZipCode = ? , CompanyPhone = ? , CompanyFax = ? , CompanyMail = ? , Mobile = ? , MobileChs = ? , EMail = ? , BP = ? , Mobile2 = ? , MobileChs2 = ? , EMail2 = ? , BP2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , GrpName = ? , OtherDuchy = ? WHERE  CustomerId = ? AND AddressNo = ?");
/*  144 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getCustomerId());
/*      */       }
/*  149 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getCustomerNo());
/*      */       }
/*  154 */       if ((getAddressNo() == null) || (getAddressNo().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getAddressNo());
/*      */       }
/*  159 */       if ((getPostalAddress() == null) || (getPostalAddress().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getPostalAddress());
/*      */       }
/*  164 */       if ((getZipCode() == null) || (getZipCode().equals("null")))
/*  165 */         pstmt.setNull(5, 12);
/*      */       else {
/*  167 */         pstmt.setString(5, getZipCode());
/*      */       }
/*  169 */       if ((getPhone() == null) || (getPhone().equals("null")))
/*  170 */         pstmt.setNull(6, 12);
/*      */       else {
/*  172 */         pstmt.setString(6, getPhone());
/*      */       }
/*  174 */       if ((getFax() == null) || (getFax().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getFax());
/*      */       }
/*  179 */       if ((getDuchy() == null) || (getDuchy().equals("null")))
/*  180 */         pstmt.setNull(8, 12);
/*      */       else {
/*  182 */         pstmt.setString(8, getDuchy());
/*      */       }
/*  184 */       if ((getHomeAddress() == null) || (getHomeAddress().equals("null")))
/*  185 */         pstmt.setNull(9, 12);
/*      */       else {
/*  187 */         pstmt.setString(9, getHomeAddress());
/*      */       }
/*  189 */       if ((getHomeZipCode() == null) || (getHomeZipCode().equals("null")))
/*  190 */         pstmt.setNull(10, 12);
/*      */       else {
/*  192 */         pstmt.setString(10, getHomeZipCode());
/*      */       }
/*  194 */       if ((getHomePhone() == null) || (getHomePhone().equals("null")))
/*  195 */         pstmt.setNull(11, 12);
/*      */       else {
/*  197 */         pstmt.setString(11, getHomePhone());
/*      */       }
/*  199 */       if ((getHomeFax() == null) || (getHomeFax().equals("null")))
/*  200 */         pstmt.setNull(12, 12);
/*      */       else {
/*  202 */         pstmt.setString(12, getHomeFax());
/*      */       }
/*  204 */       if ((getCompanyAddress() == null) || (getCompanyAddress().equals("null")))
/*  205 */         pstmt.setNull(13, 12);
/*      */       else {
/*  207 */         pstmt.setString(13, getCompanyAddress());
/*      */       }
/*  209 */       if ((getCompanyZipCode() == null) || (getCompanyZipCode().equals("null")))
/*  210 */         pstmt.setNull(14, 12);
/*      */       else {
/*  212 */         pstmt.setString(14, getCompanyZipCode());
/*      */       }
/*  214 */       if ((getCompanyPhone() == null) || (getCompanyPhone().equals("null")))
/*  215 */         pstmt.setNull(15, 12);
/*      */       else {
/*  217 */         pstmt.setString(15, getCompanyPhone());
/*      */       }
/*  219 */       if ((getCompanyFax() == null) || (getCompanyFax().equals("null")))
/*  220 */         pstmt.setNull(16, 12);
/*      */       else {
/*  222 */         pstmt.setString(16, getCompanyFax());
/*      */       }
/*  224 */       if ((getCompanyMail() == null) || (getCompanyMail().equals("null")))
/*  225 */         pstmt.setNull(17, 12);
/*      */       else {
/*  227 */         pstmt.setString(17, getCompanyMail());
/*      */       }
/*  229 */       if ((getMobile() == null) || (getMobile().equals("null")))
/*  230 */         pstmt.setNull(18, 12);
/*      */       else {
/*  232 */         pstmt.setString(18, getMobile());
/*      */       }
/*  234 */       if ((getMobileChs() == null) || (getMobileChs().equals("null")))
/*  235 */         pstmt.setNull(19, 12);
/*      */       else {
/*  237 */         pstmt.setString(19, getMobileChs());
/*      */       }
/*  239 */       if ((getEMail() == null) || (getEMail().equals("null")))
/*  240 */         pstmt.setNull(20, 12);
/*      */       else {
/*  242 */         pstmt.setString(20, getEMail());
/*      */       }
/*  244 */       if ((getBP() == null) || (getBP().equals("null")))
/*  245 */         pstmt.setNull(21, 12);
/*      */       else {
/*  247 */         pstmt.setString(21, getBP());
/*      */       }
/*  249 */       if ((getMobile2() == null) || (getMobile2().equals("null")))
/*  250 */         pstmt.setNull(22, 12);
/*      */       else {
/*  252 */         pstmt.setString(22, getMobile2());
/*      */       }
/*  254 */       if ((getMobileChs2() == null) || (getMobileChs2().equals("null")))
/*  255 */         pstmt.setNull(23, 12);
/*      */       else {
/*  257 */         pstmt.setString(23, getMobileChs2());
/*      */       }
/*  259 */       if ((getEMail2() == null) || (getEMail2().equals("null")))
/*  260 */         pstmt.setNull(24, 12);
/*      */       else {
/*  262 */         pstmt.setString(24, getEMail2());
/*      */       }
/*  264 */       if ((getBP2() == null) || (getBP2().equals("null")))
/*  265 */         pstmt.setNull(25, 12);
/*      */       else {
/*  267 */         pstmt.setString(25, getBP2());
/*      */       }
/*  269 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  270 */         pstmt.setNull(26, 12);
/*      */       else {
/*  272 */         pstmt.setString(26, getOperator());
/*      */       }
/*  274 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  275 */         pstmt.setNull(27, 91);
/*      */       else {
/*  277 */         pstmt.setDate(27, Date.valueOf(getMakeDate()));
/*      */       }
/*  279 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  280 */         pstmt.setNull(28, 12);
/*      */       else {
/*  282 */         pstmt.setString(28, getMakeTime());
/*      */       }
/*  284 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  285 */         pstmt.setNull(29, 91);
/*      */       else {
/*  287 */         pstmt.setDate(29, Date.valueOf(getModifyDate()));
/*      */       }
/*  289 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  290 */         pstmt.setNull(30, 12);
/*      */       else {
/*  292 */         pstmt.setString(30, getModifyTime());
/*      */       }
/*  294 */       if ((getGrpName() == null) || (getGrpName().equals("null")))
/*  295 */         pstmt.setNull(31, 12);
/*      */       else {
/*  297 */         pstmt.setString(31, getGrpName());
/*      */       }
/*  299 */       if ((getOtherDuchy() == null) || (getOtherDuchy().equals("null")))
/*  300 */         pstmt.setNull(32, 12);
/*      */       else {
/*  302 */         pstmt.setString(32, getOtherDuchy());
/*      */       }
/*      */ 
/*  305 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  306 */         pstmt.setNull(33, 12);
/*      */       else {
/*  308 */         pstmt.setString(33, getCustomerId());
/*      */       }
/*  310 */       if ((getAddressNo() == null) || (getAddressNo().equals("null")))
/*  311 */         pstmt.setNull(34, 12);
/*      */       else {
/*  313 */         pstmt.setString(34, getAddressNo());
/*      */       }
/*  315 */       pstmt.executeUpdate();
/*  316 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  319 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  320 */       CError tError = new CError();
/*  321 */       tError.moduleName = "LNPAddressDB";
/*  322 */       tError.functionName = "update()";
/*  323 */       tError.errorMessage = ex.toString();
/*  324 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  327 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  330 */       if (!this.mflag)
/*      */         try {
/*  332 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  336 */       return false;
/*      */     }
/*      */ 
/*  339 */     if (!this.mflag)
/*      */       try {
/*  341 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  345 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  350 */     PreparedStatement pstmt = null;
/*      */ 
/*  352 */     if (!this.mflag) {
/*  353 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  358 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAddress VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  359 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  360 */         pstmt.setNull(1, 12);
/*      */       else {
/*  362 */         pstmt.setString(1, getCustomerId());
/*      */       }
/*  364 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  365 */         pstmt.setNull(2, 12);
/*      */       else {
/*  367 */         pstmt.setString(2, getCustomerNo());
/*      */       }
/*  369 */       if ((getAddressNo() == null) || (getAddressNo().equals("null")))
/*  370 */         pstmt.setNull(3, 12);
/*      */       else {
/*  372 */         pstmt.setString(3, getAddressNo());
/*      */       }
/*  374 */       if ((getPostalAddress() == null) || (getPostalAddress().equals("null")))
/*  375 */         pstmt.setNull(4, 12);
/*      */       else {
/*  377 */         pstmt.setString(4, getPostalAddress());
/*      */       }
/*  379 */       if ((getZipCode() == null) || (getZipCode().equals("null")))
/*  380 */         pstmt.setNull(5, 12);
/*      */       else {
/*  382 */         pstmt.setString(5, getZipCode());
/*      */       }
/*  384 */       if ((getPhone() == null) || (getPhone().equals("null")))
/*  385 */         pstmt.setNull(6, 12);
/*      */       else {
/*  387 */         pstmt.setString(6, getPhone());
/*      */       }
/*  389 */       if ((getFax() == null) || (getFax().equals("null")))
/*  390 */         pstmt.setNull(7, 12);
/*      */       else {
/*  392 */         pstmt.setString(7, getFax());
/*      */       }
/*  394 */       if ((getDuchy() == null) || (getDuchy().equals("null")))
/*  395 */         pstmt.setNull(8, 12);
/*      */       else {
/*  397 */         pstmt.setString(8, getDuchy());
/*      */       }
/*  399 */       if ((getHomeAddress() == null) || (getHomeAddress().equals("null")))
/*  400 */         pstmt.setNull(9, 12);
/*      */       else {
/*  402 */         pstmt.setString(9, getHomeAddress());
/*      */       }
/*  404 */       if ((getHomeZipCode() == null) || (getHomeZipCode().equals("null")))
/*  405 */         pstmt.setNull(10, 12);
/*      */       else {
/*  407 */         pstmt.setString(10, getHomeZipCode());
/*      */       }
/*  409 */       if ((getHomePhone() == null) || (getHomePhone().equals("null")))
/*  410 */         pstmt.setNull(11, 12);
/*      */       else {
/*  412 */         pstmt.setString(11, getHomePhone());
/*      */       }
/*  414 */       if ((getHomeFax() == null) || (getHomeFax().equals("null")))
/*  415 */         pstmt.setNull(12, 12);
/*      */       else {
/*  417 */         pstmt.setString(12, getHomeFax());
/*      */       }
/*  419 */       if ((getCompanyAddress() == null) || (getCompanyAddress().equals("null")))
/*  420 */         pstmt.setNull(13, 12);
/*      */       else {
/*  422 */         pstmt.setString(13, getCompanyAddress());
/*      */       }
/*  424 */       if ((getCompanyZipCode() == null) || (getCompanyZipCode().equals("null")))
/*  425 */         pstmt.setNull(14, 12);
/*      */       else {
/*  427 */         pstmt.setString(14, getCompanyZipCode());
/*      */       }
/*  429 */       if ((getCompanyPhone() == null) || (getCompanyPhone().equals("null")))
/*  430 */         pstmt.setNull(15, 12);
/*      */       else {
/*  432 */         pstmt.setString(15, getCompanyPhone());
/*      */       }
/*  434 */       if ((getCompanyFax() == null) || (getCompanyFax().equals("null")))
/*  435 */         pstmt.setNull(16, 12);
/*      */       else {
/*  437 */         pstmt.setString(16, getCompanyFax());
/*      */       }
/*  439 */       if ((getCompanyMail() == null) || (getCompanyMail().equals("null")))
/*  440 */         pstmt.setNull(17, 12);
/*      */       else {
/*  442 */         pstmt.setString(17, getCompanyMail());
/*      */       }
/*  444 */       if ((getMobile() == null) || (getMobile().equals("null")))
/*  445 */         pstmt.setNull(18, 12);
/*      */       else {
/*  447 */         pstmt.setString(18, getMobile());
/*      */       }
/*  449 */       if ((getMobileChs() == null) || (getMobileChs().equals("null")))
/*  450 */         pstmt.setNull(19, 12);
/*      */       else {
/*  452 */         pstmt.setString(19, getMobileChs());
/*      */       }
/*  454 */       if ((getEMail() == null) || (getEMail().equals("null")))
/*  455 */         pstmt.setNull(20, 12);
/*      */       else {
/*  457 */         pstmt.setString(20, getEMail());
/*      */       }
/*  459 */       if ((getBP() == null) || (getBP().equals("null")))
/*  460 */         pstmt.setNull(21, 12);
/*      */       else {
/*  462 */         pstmt.setString(21, getBP());
/*      */       }
/*  464 */       if ((getMobile2() == null) || (getMobile2().equals("null")))
/*  465 */         pstmt.setNull(22, 12);
/*      */       else {
/*  467 */         pstmt.setString(22, getMobile2());
/*      */       }
/*  469 */       if ((getMobileChs2() == null) || (getMobileChs2().equals("null")))
/*  470 */         pstmt.setNull(23, 12);
/*      */       else {
/*  472 */         pstmt.setString(23, getMobileChs2());
/*      */       }
/*  474 */       if ((getEMail2() == null) || (getEMail2().equals("null")))
/*  475 */         pstmt.setNull(24, 12);
/*      */       else {
/*  477 */         pstmt.setString(24, getEMail2());
/*      */       }
/*  479 */       if ((getBP2() == null) || (getBP2().equals("null")))
/*  480 */         pstmt.setNull(25, 12);
/*      */       else {
/*  482 */         pstmt.setString(25, getBP2());
/*      */       }
/*  484 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  485 */         pstmt.setNull(26, 12);
/*      */       else {
/*  487 */         pstmt.setString(26, getOperator());
/*      */       }
/*  489 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  490 */         pstmt.setNull(27, 91);
/*      */       else {
/*  492 */         pstmt.setDate(27, Date.valueOf(getMakeDate()));
/*      */       }
/*  494 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  495 */         pstmt.setNull(28, 12);
/*      */       else {
/*  497 */         pstmt.setString(28, getMakeTime());
/*      */       }
/*  499 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  500 */         pstmt.setNull(29, 91);
/*      */       else {
/*  502 */         pstmt.setDate(29, Date.valueOf(getModifyDate()));
/*      */       }
/*  504 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  505 */         pstmt.setNull(30, 12);
/*      */       else {
/*  507 */         pstmt.setString(30, getModifyTime());
/*      */       }
/*  509 */       if ((getGrpName() == null) || (getGrpName().equals("null")))
/*  510 */         pstmt.setNull(31, 12);
/*      */       else {
/*  512 */         pstmt.setString(31, getGrpName());
/*      */       }
/*  514 */       if ((getOtherDuchy() == null) || (getOtherDuchy().equals("null")))
/*  515 */         pstmt.setNull(32, 12);
/*      */       else {
/*  517 */         pstmt.setString(32, getOtherDuchy());
/*      */       }
/*  519 */       pstmt.executeUpdate();
/*  520 */       pstmt.close();
/*      */     } catch (Exception ex) {
/*  522 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  523 */       CError tError = new CError();
/*  524 */       tError.moduleName = "LNPAddressDB";
/*  525 */       tError.functionName = "insert()";
/*  526 */       tError.errorMessage = ex.toString();
/*  527 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  530 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  533 */       if (!this.mflag)
/*      */         try {
/*  535 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  539 */       return false;
/*      */     }
/*      */ 
/*  542 */     if (!this.mflag)
/*      */       try {
/*  544 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  548 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  553 */     PreparedStatement pstmt = null;
/*  554 */     ResultSet rs = null;
/*      */ 
/*  556 */     if (!this.mflag) {
/*  557 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  562 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPAddress WHERE  CustomerId = ? AND AddressNo = ?", 
/*  563 */         1003, 1007);
/*  564 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  565 */         pstmt.setNull(1, 12);
/*      */       else {
/*  567 */         pstmt.setString(1, getCustomerId());
/*      */       }
/*  569 */       if ((getAddressNo() == null) || (getAddressNo().equals("null")))
/*  570 */         pstmt.setNull(2, 12);
/*      */       else {
/*  572 */         pstmt.setString(2, getAddressNo());
/*      */       }
/*  574 */       rs = pstmt.executeQuery();
/*  575 */       int i = 0;
/*  576 */       if (rs.next())
/*      */       {
/*  578 */         i++;
/*  579 */         if (!setSchema(rs, i))
/*      */         {
/*  581 */           CError tError = new CError();
/*  582 */           tError.moduleName = "LNPAddressDB";
/*  583 */           tError.functionName = "getInfo";
/*  584 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  585 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  587 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  590 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  594 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  598 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  602 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  605 */       if (i == 0)
/*      */       {
/*  607 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  611 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  615 */         return false;
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  620 */       CError tError = new CError();
/*  621 */       tError.moduleName = "LNPAddressDB";
/*  622 */       tError.functionName = "getInfo";
/*  623 */       tError.errorMessage = e.toString();
/*  624 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  626 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  629 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  633 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  637 */       return false;
/*      */     }
/*      */ 
/*  640 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  644 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  649 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAddressSet query()
/*      */   {
/*  654 */     Statement stmt = null;
/*  655 */     ResultSet rs = null;
/*  656 */     LNPAddressSet aLNPAddressSet = new LNPAddressSet();
/*      */ 
/*  658 */     if (!this.mflag) {
/*  659 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  664 */       stmt = this.con.createStatement(1003, 1007);
/*  665 */       SQLString sqlObj = new SQLString("LNPAddress");
/*  666 */       LNPAddressSchema aSchema = getSchema();
/*  667 */       sqlObj.setSQL(5, aSchema);
/*  668 */       String sql = sqlObj.getSQL();
/*      */ 
/*  670 */       rs = stmt.executeQuery(sql);
/*  671 */       int i = 0;
/*  672 */       while (rs.next())
/*      */       {
/*  674 */         i++;
/*  675 */         LNPAddressSchema s1 = new LNPAddressSchema();
/*  676 */         s1.setSchema(rs, i);
/*  677 */         aLNPAddressSet.add(s1);
/*      */       }try {
/*  679 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  685 */       CError tError = new CError();
/*  686 */       tError.moduleName = "LNPAddressDB";
/*  687 */       tError.functionName = "query";
/*  688 */       tError.errorMessage = e.toString();
/*  689 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  691 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  694 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  698 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  704 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  708 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  713 */     return aLNPAddressSet;
/*      */   }
/*      */ 
/*      */   public LNPAddressSet executeQuery(String sql)
/*      */   {
/*  718 */     Statement stmt = null;
/*  719 */     ResultSet rs = null;
/*  720 */     LNPAddressSet aLNPAddressSet = new LNPAddressSet();
/*      */ 
/*  722 */     if (!this.mflag) {
/*  723 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  728 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  730 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  731 */       int i = 0;
/*  732 */       while (rs.next())
/*      */       {
/*  734 */         i++;
/*  735 */         LNPAddressSchema s1 = new LNPAddressSchema();
/*  736 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  739 */           CError tError = new CError();
/*  740 */           tError.moduleName = "LNPAddressDB";
/*  741 */           tError.functionName = "executeQuery";
/*  742 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  743 */           this.mErrors.addOneError(tError);
/*      */         }
/*  745 */         aLNPAddressSet.add(s1);
/*      */       }try {
/*  747 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  753 */       CError tError = new CError();
/*  754 */       tError.moduleName = "LNPAddressDB";
/*  755 */       tError.functionName = "executeQuery";
/*  756 */       tError.errorMessage = e.toString();
/*  757 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  759 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  762 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  766 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  772 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  776 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  781 */     return aLNPAddressSet;
/*      */   }
/*      */ 
/*      */   public LNPAddressSet query(int nStart, int nCount)
/*      */   {
/*  786 */     Statement stmt = null;
/*  787 */     ResultSet rs = null;
/*  788 */     LNPAddressSet aLNPAddressSet = new LNPAddressSet();
/*      */ 
/*  790 */     if (!this.mflag) {
/*  791 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  796 */       stmt = this.con.createStatement(1003, 1007);
/*  797 */       SQLString sqlObj = new SQLString("LNPAddress");
/*  798 */       LNPAddressSchema aSchema = getSchema();
/*  799 */       sqlObj.setSQL(5, aSchema);
/*  800 */       String sql = sqlObj.getSQL();
/*      */ 
/*  802 */       rs = stmt.executeQuery(sql);
/*  803 */       int i = 0;
/*  804 */       while (rs.next())
/*      */       {
/*  806 */         i++;
/*      */ 
/*  808 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  812 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  816 */         LNPAddressSchema s1 = new LNPAddressSchema();
/*  817 */         s1.setSchema(rs, i);
/*  818 */         aLNPAddressSet.add(s1);
/*      */       }try {
/*  820 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  826 */       CError tError = new CError();
/*  827 */       tError.moduleName = "LNPAddressDB";
/*  828 */       tError.functionName = "query";
/*  829 */       tError.errorMessage = e.toString();
/*  830 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  832 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  835 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  839 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  845 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  849 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  854 */     return aLNPAddressSet;
/*      */   }
/*      */ 
/*      */   public LNPAddressSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  859 */     Statement stmt = null;
/*  860 */     ResultSet rs = null;
/*  861 */     LNPAddressSet aLNPAddressSet = new LNPAddressSet();
/*      */ 
/*  863 */     if (!this.mflag) {
/*  864 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  869 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  871 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  872 */       int i = 0;
/*  873 */       while (rs.next())
/*      */       {
/*  875 */         i++;
/*      */ 
/*  877 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  881 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  885 */         LNPAddressSchema s1 = new LNPAddressSchema();
/*  886 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  889 */           CError tError = new CError();
/*  890 */           tError.moduleName = "LNPAddressDB";
/*  891 */           tError.functionName = "executeQuery";
/*  892 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  893 */           this.mErrors.addOneError(tError);
/*      */         }
/*  895 */         aLNPAddressSet.add(s1);
/*      */       }try {
/*  897 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  903 */       CError tError = new CError();
/*  904 */       tError.moduleName = "LNPAddressDB";
/*  905 */       tError.functionName = "executeQuery";
/*  906 */       tError.errorMessage = e.toString();
/*  907 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  909 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  912 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  916 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  922 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  926 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  931 */     return aLNPAddressSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  936 */     Statement stmt = null;
/*      */ 
/*  938 */     if (!this.mflag) {
/*  939 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  944 */       stmt = this.con.createStatement(1003, 1007);
/*  945 */       SQLString sqlObj = new SQLString("LNPAddress");
/*  946 */       LNPAddressSchema aSchema = getSchema();
/*  947 */       sqlObj.setSQL(2, aSchema);
/*  948 */       String sql = "update LNPAddress " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  950 */       int operCount = stmt.executeUpdate(sql);
/*  951 */       if (operCount == 0)
/*      */       {
/*  954 */         CError tError = new CError();
/*  955 */         tError.moduleName = "LNPAddressDB";
/*  956 */         tError.functionName = "update";
/*  957 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  958 */         this.mErrors.addOneError(tError);
/*      */ 
/*  960 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  964 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  968 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  974 */       CError tError = new CError();
/*  975 */       tError.moduleName = "LNPAddressDB";
/*  976 */       tError.functionName = "update";
/*  977 */       tError.errorMessage = e.toString();
/*  978 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  980 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  982 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  986 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  990 */       return false;
/*      */     }
/*      */ 
/*  993 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  997 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1002 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1008 */     if (this.mResultSet != null)
/*      */     {
/* 1011 */       CError tError = new CError();
/* 1012 */       tError.moduleName = "LNPAddressDB";
/* 1013 */       tError.functionName = "prepareData";
/* 1014 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 1015 */       this.mErrors.addOneError(tError);
/* 1016 */       return false;
/*      */     }
/*      */ 
/* 1019 */     if (!this.mflag)
/*      */     {
/* 1021 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1025 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1026 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1031 */       CError tError = new CError();
/* 1032 */       tError.moduleName = "LNPAddressDB";
/* 1033 */       tError.functionName = "prepareData";
/* 1034 */       tError.errorMessage = e.toString();
/* 1035 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1038 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1044 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1048 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1052 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1057 */       return false;
/*      */     }
/*      */ 
/* 1060 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1064 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1069 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1075 */     boolean flag = true;
/* 1076 */     if (this.mResultSet == null)
/*      */     {
/* 1078 */       CError tError = new CError();
/* 1079 */       tError.moduleName = "LNPAddressDB";
/* 1080 */       tError.functionName = "hasMoreData";
/* 1081 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1082 */       this.mErrors.addOneError(tError);
/* 1083 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1087 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1091 */       CError tError = new CError();
/* 1092 */       tError.moduleName = "LNPAddressDB";
/* 1093 */       tError.functionName = "hasMoreData";
/* 1094 */       tError.errorMessage = ex.toString();
/* 1095 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1098 */         this.mResultSet.close();
/* 1099 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1105 */         this.mStatement.close();
/* 1106 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1110 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1114 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1119 */       return false;
/*      */     }
/* 1121 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPAddressSet getData()
/*      */   {
/* 1126 */     int tCount = 0;
/* 1127 */     LNPAddressSet tLNPAddressSet = new LNPAddressSet();
/* 1128 */     LNPAddressSchema tLNPAddressSchema = null;
/* 1129 */     if (this.mResultSet == null)
/*      */     {
/* 1131 */       CError tError = new CError();
/* 1132 */       tError.moduleName = "LNPAddressDB";
/* 1133 */       tError.functionName = "getData";
/* 1134 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1135 */       this.mErrors.addOneError(tError);
/* 1136 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1140 */       tCount = 1;
/* 1141 */       tLNPAddressSchema = new LNPAddressSchema();
/* 1142 */       tLNPAddressSchema.setSchema(this.mResultSet, 1);
/* 1143 */       tLNPAddressSet.add(tLNPAddressSchema);
/*      */ 
/* 1145 */       while (tCount++ < 5000)
/*      */       {
/* 1147 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1149 */         tLNPAddressSchema = new LNPAddressSchema();
/* 1150 */         tLNPAddressSchema.setSchema(this.mResultSet, 1);
/* 1151 */         tLNPAddressSet.add(tLNPAddressSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1157 */       CError tError = new CError();
/* 1158 */       tError.moduleName = "LNPAddressDB";
/* 1159 */       tError.functionName = "getData";
/* 1160 */       tError.errorMessage = ex.toString();
/* 1161 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1164 */         this.mResultSet.close();
/* 1165 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1171 */         this.mStatement.close();
/* 1172 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1176 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1180 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1185 */       return null;
/*      */     }
/* 1187 */     return tLNPAddressSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1192 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1195 */       if (this.mResultSet == null)
/*      */       {
/* 1197 */         CError tError = new CError();
/* 1198 */         tError.moduleName = "LNPAddressDB";
/* 1199 */         tError.functionName = "closeData";
/* 1200 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1201 */         this.mErrors.addOneError(tError);
/* 1202 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1206 */         this.mResultSet.close();
/* 1207 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1212 */       CError tError = new CError();
/* 1213 */       tError.moduleName = "LNPAddressDB";
/* 1214 */       tError.functionName = "closeData";
/* 1215 */       tError.errorMessage = ex2.toString();
/* 1216 */       this.mErrors.addOneError(tError);
/* 1217 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1221 */       if (this.mStatement == null)
/*      */       {
/* 1223 */         CError tError = new CError();
/* 1224 */         tError.moduleName = "LNPAddressDB";
/* 1225 */         tError.functionName = "closeData";
/* 1226 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1227 */         this.mErrors.addOneError(tError);
/* 1228 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1232 */         this.mStatement.close();
/* 1233 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1238 */       CError tError = new CError();
/* 1239 */       tError.moduleName = "LNPAddressDB";
/* 1240 */       tError.functionName = "closeData";
/* 1241 */       tError.errorMessage = ex3.toString();
/* 1242 */       this.mErrors.addOneError(tError);
/* 1243 */       flag = false;
/*      */     }
/* 1245 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPAddressDB
 * JD-Core Version:    0.6.0
 */