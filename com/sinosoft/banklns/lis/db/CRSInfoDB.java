/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.CRSInfoSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.CRSInfoSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import com.sinosoft.banklns.utility.SQLString;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class CRSInfoDB extends CRSInfoSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*   23 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   25 */   private ResultSet mResultSet = null;
/*   26 */   private Statement mStatement = null;
/*      */ 
/*      */   public CRSInfoDB(Connection tConnection) {
/*   29 */     this.con = tConnection;
/*   30 */     this.db = new DBOper("CRSInfo");
/*   31 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public CRSInfoDB() {
/*   35 */     this.con = null;
/*   36 */     this.db = new DBOper("CRSInfo");
/*   37 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public int getCount() {
/*   41 */     CRSInfoSchema oSchema = getSchema();
/*      */ 
/*   43 */     int tCount = this.db.getCount(oSchema);
/*   44 */     if (tCount < 0) {
/*   45 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   46 */       CError tError = new CError();
/*   47 */       tError.moduleName = "CRSInfoDB";
/*   48 */       tError.functionName = "getCount";
/*   49 */       tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   50 */       this.mErrors.addOneError(tError);
/*   51 */       return -1;
/*      */     }
/*      */ 
/*   54 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean update() {
/*   58 */     PreparedStatement pstmt = null;
/*      */ 
/*   60 */     if (!this.mflag) {
/*   61 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*   65 */       pstmt = this.con.prepareStatement("UPDATE CRSInfo SET  contNo=?, CustomerName = ?,taxResidentType=?, firstName=?, lastName=?, birthday=?, currentAddress_Country=?,currentAddress_Province=?,currentAddress_City=?,currentAddress_Detail=?,currentAddress_Country_en=?, currentAddress_Province_en=?, currentAddress_City_en=?,currentAddress_Detail_en=?, birthAddress_Country=?, birthAddress_Province=?,birthAddress_City=?,birthAddress_Detail=?,birthAddress_Country_en=?,birthAddress_Province_en=?,birthAddress_City_en=?,birthAddress_Detail_en=?,taxResidentCountry1=?,taxpayerCode1=?,taxResidentCountry2=?,taxpayerCode2=?,taxResidentCountry3=?,taxpayerCode3=?,noTaxpayercodeReason=?,reasonDescription=?,sourceType=?  WHERE  ContNo = ?");
/*      */ 
/*   70 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*   71 */         pstmt.setNull(1, 12);
/*      */       else {
/*   73 */         pstmt.setString(1, getContNo());
/*      */       }
/*   75 */       if ((getCustomerName() == null) || (getCustomerName().equals("null")))
/*   76 */         pstmt.setNull(2, 12);
/*      */       else {
/*   78 */         pstmt.setString(2, getCustomerName());
/*      */       }
/*   80 */       if ((getTaxResidentType() == null) || (getTaxResidentType().equals("null")))
/*   81 */         pstmt.setNull(3, 12);
/*      */       else {
/*   83 */         pstmt.setString(3, getTaxResidentType());
/*      */       }
/*   85 */       if ((getFirstName() == null) || (getFirstName().equals("null")))
/*   86 */         pstmt.setNull(4, 12);
/*      */       else {
/*   88 */         pstmt.setString(4, getFirstName());
/*      */       }
/*   90 */       if ((getLastName() == null) || (getLastName().equals("null")))
/*   91 */         pstmt.setNull(5, 12);
/*      */       else {
/*   93 */         pstmt.setString(5, getLastName());
/*      */       }
/*   95 */       if ((getBirthday() == null) || (getBirthday().equals("null")))
/*   96 */         pstmt.setNull(6, 12);
/*      */       else {
/*   98 */         pstmt.setString(6, getBirthday());
/*      */       }
/*  100 */       if ((getCurrentAddress_Country() == null) || (getCurrentAddress_Country().equals("null")))
/*  101 */         pstmt.setNull(7, 12);
/*      */       else {
/*  103 */         pstmt.setString(7, getCurrentAddress_Country());
/*      */       }
/*  105 */       if ((getCurrentAddress_Province() == null) || (getCurrentAddress_Province().equals("null")))
/*  106 */         pstmt.setNull(8, 12);
/*      */       else {
/*  108 */         pstmt.setString(8, getCurrentAddress_Province());
/*      */       }
/*  110 */       if ((getCurrentAddress_City() == null) || (getCurrentAddress_City().equals("null")))
/*  111 */         pstmt.setNull(9, 12);
/*      */       else {
/*  113 */         pstmt.setString(9, getCurrentAddress_City());
/*      */       }
/*  115 */       if ((getCurrentAddress_Detail() == null) || (getCurrentAddress_Detail().equals("null")))
/*  116 */         pstmt.setNull(10, 12);
/*      */       else {
/*  118 */         pstmt.setString(10, getCurrentAddress_Detail());
/*      */       }
/*  120 */       if ((getCurrentAddress_Country_en() == null) || (getCurrentAddress_Country_en().equals("null")))
/*  121 */         pstmt.setNull(11, 12);
/*      */       else {
/*  123 */         pstmt.setString(11, getCurrentAddress_Country_en());
/*      */       }
/*  125 */       if ((getCurrentAddress_Province_en() == null) || (getCurrentAddress_Province_en().equals("null")))
/*  126 */         pstmt.setNull(12, 12);
/*      */       else {
/*  128 */         pstmt.setString(12, getCurrentAddress_Province_en());
/*      */       }
/*  130 */       if ((getCurrentAddress_City_en() == null) || (getCurrentAddress_City_en().equals("null")))
/*  131 */         pstmt.setNull(13, 12);
/*      */       else {
/*  133 */         pstmt.setString(13, getCurrentAddress_City_en());
/*      */       }
/*  135 */       if ((getCurrentAddress_Detail_en() == null) || (getCurrentAddress_Detail_en().equals("null")))
/*  136 */         pstmt.setNull(14, 12);
/*      */       else {
/*  138 */         pstmt.setString(14, getCurrentAddress_Detail_en());
/*      */       }
/*  140 */       if ((getBirthAddress_Country() == null) || (getBirthAddress_Country().equals("null")))
/*  141 */         pstmt.setNull(15, 12);
/*      */       else {
/*  143 */         pstmt.setString(15, getBirthAddress_Country());
/*      */       }
/*  145 */       if ((getBirthAddress_Province() == null) || (getBirthAddress_Province().equals("null")))
/*  146 */         pstmt.setNull(16, 12);
/*      */       else {
/*  148 */         pstmt.setString(16, getBirthAddress_Province());
/*      */       }
/*  150 */       if ((getBirthAddress_City() == null) || (getBirthAddress_City().equals("null")))
/*  151 */         pstmt.setNull(17, 12);
/*      */       else {
/*  153 */         pstmt.setString(17, getBirthAddress_City());
/*      */       }
/*  155 */       if ((getBirthAddress_Detail() == null) || (getBirthAddress_Detail().equals("null")))
/*  156 */         pstmt.setNull(18, 12);
/*      */       else {
/*  158 */         pstmt.setString(18, getBirthAddress_Detail());
/*      */       }
/*  160 */       if ((getBirthAddress_Country_en() == null) || (getBirthAddress_Country_en().equals("null")))
/*  161 */         pstmt.setNull(19, 12);
/*      */       else {
/*  163 */         pstmt.setString(19, getBirthAddress_Country_en());
/*      */       }
/*  165 */       if ((getBirthAddress_Province_en() == null) || (getBirthAddress_Province_en().equals("null")))
/*  166 */         pstmt.setNull(20, 12);
/*      */       else {
/*  168 */         pstmt.setString(20, getBirthAddress_Province_en());
/*      */       }
/*  170 */       if ((getBirthAddress_City_en() == null) || (getBirthAddress_City_en().equals("null")))
/*  171 */         pstmt.setNull(21, 12);
/*      */       else {
/*  173 */         pstmt.setString(21, getBirthAddress_City_en());
/*      */       }
/*  175 */       if ((getBirthAddress_Detail_en() == null) || (getBirthAddress_Detail_en().equals("null")))
/*  176 */         pstmt.setNull(22, 12);
/*      */       else {
/*  178 */         pstmt.setString(22, getBirthAddress_Detail_en());
/*      */       }
/*  180 */       if ((getTaxResidentCountry1() == null) || (getTaxResidentCountry1().equals("null")))
/*  181 */         pstmt.setNull(23, 12);
/*      */       else {
/*  183 */         pstmt.setString(23, getTaxResidentCountry1());
/*      */       }
/*  185 */       if ((getTaxpayerCode1() == null) || (getTaxpayerCode1().equals("null")))
/*  186 */         pstmt.setNull(24, 12);
/*      */       else {
/*  188 */         pstmt.setString(24, getTaxpayerCode1());
/*      */       }
/*  190 */       if ((getTaxResidentCountry2() == null) || (getTaxResidentCountry2().equals("null")))
/*  191 */         pstmt.setNull(25, 12);
/*      */       else {
/*  193 */         pstmt.setString(25, getTaxResidentCountry2());
/*      */       }
/*  195 */       if ((getTaxpayerCode2() == null) || (getTaxpayerCode2().equals("null")))
/*  196 */         pstmt.setNull(26, 12);
/*      */       else {
/*  198 */         pstmt.setString(26, getTaxpayerCode2());
/*      */       }
/*  200 */       if ((getTaxResidentCountry3() == null) || (getTaxResidentCountry3().equals("null")))
/*  201 */         pstmt.setNull(27, 12);
/*      */       else {
/*  203 */         pstmt.setString(27, getTaxResidentCountry3());
/*      */       }
/*  205 */       if ((getTaxpayerCode3() == null) || (getTaxpayerCode3().equals("null")))
/*  206 */         pstmt.setNull(28, 12);
/*      */       else {
/*  208 */         pstmt.setString(28, getTaxpayerCode3());
/*      */       }
/*  210 */       if ((getNoTaxpayercodeReason() == null) || (getNoTaxpayercodeReason().equals("null")))
/*  211 */         pstmt.setNull(29, 12);
/*      */       else {
/*  213 */         pstmt.setString(29, getNoTaxpayercodeReason());
/*      */       }
/*  215 */       if ((getReasonDescription() == null) || (getReasonDescription().equals("null")))
/*  216 */         pstmt.setNull(30, 12);
/*      */       else {
/*  218 */         pstmt.setString(30, getReasonDescription());
/*      */       }
/*  220 */       if ((getSourceType() == null) || (getSourceType().equals("null")))
/*  221 */         pstmt.setNull(31, 12);
/*      */       else {
/*  223 */         pstmt.setString(31, getSourceType());
/*      */       }
/*  225 */       if ((getContNo() == null) || (getContNo().equals("null"))) {
/*  226 */         pstmt.setNull(32, 12);
/*      */       } else {
/*  228 */         pstmt.setString(32, getContNo());
/*  229 */         pstmt.executeUpdate();
/*  230 */         pstmt.close();
/*      */       }
/*      */     }
/*      */     catch (Exception ex) {
/*  234 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  235 */       CError tError = new CError();
/*  236 */       tError.moduleName = "CRSInfoDB";
/*  237 */       tError.functionName = "update()";
/*  238 */       tError.errorMessage = ex.toString();
/*  239 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  242 */         pstmt.close();
/*      */       }
/*      */       catch (Exception localException1) {
/*      */       }
/*  246 */       if (!this.mflag)
/*      */         try {
/*  248 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2)
/*      */         {
/*      */         }
/*  253 */       return false;
/*      */     }
/*  255 */     if (!this.mflag)
/*      */       try {
/*  257 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3)
/*      */       {
/*      */       }
/*  262 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert() {
/*  266 */     PreparedStatement pstmt = null;
/*      */ 
/*  268 */     if (!this.mflag) {
/*  269 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  273 */       String sql = "INSERT INTO CRSInfo VALUES(  ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
/*  274 */       pstmt = this.con.prepareStatement(sql);
/*  275 */       System.out.println("\u93BB\u6391\u53C6\u7487\uE15E\u5F5E\u6D93\u7334\u7D30\u951B\uFFFD" + sql);
/*  276 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  277 */         pstmt.setNull(1, 12);
/*      */       else {
/*  279 */         pstmt.setString(1, getContNo());
/*      */       }
/*  281 */       if ((getCustomerName() == null) || (getCustomerName().equals("null")))
/*  282 */         pstmt.setNull(2, 12);
/*      */       else {
/*  284 */         pstmt.setString(2, getCustomerName());
/*      */       }
/*  286 */       if ((getTaxResidentType() == null) || (getTaxResidentType().equals("null")))
/*  287 */         pstmt.setNull(3, 12);
/*      */       else {
/*  289 */         pstmt.setString(3, getTaxResidentType());
/*      */       }
/*  291 */       if ((getFirstName() == null) || (getFirstName().equals("null")))
/*  292 */         pstmt.setNull(4, 12);
/*      */       else {
/*  294 */         pstmt.setString(4, getFirstName());
/*      */       }
/*  296 */       if ((getLastName() == null) || (getLastName().equals("null")))
/*  297 */         pstmt.setNull(5, 12);
/*      */       else {
/*  299 */         pstmt.setString(5, getLastName());
/*      */       }
/*  301 */       if ((getBirthday() == null) || (getBirthday().equals("null")))
/*  302 */         pstmt.setNull(6, 12);
/*      */       else {
/*  304 */         pstmt.setString(6, getBirthday());
/*      */       }
/*  306 */       if ((getCurrentAddress_Country() == null) || (getCurrentAddress_Country().equals("null")))
/*  307 */         pstmt.setNull(7, 12);
/*      */       else {
/*  309 */         pstmt.setString(7, getCurrentAddress_Country());
/*      */       }
/*  311 */       if ((getCurrentAddress_Province() == null) || (getCurrentAddress_Province().equals("null")))
/*  312 */         pstmt.setNull(8, 12);
/*      */       else {
/*  314 */         pstmt.setString(8, getCurrentAddress_Province());
/*      */       }
/*  316 */       if ((getCurrentAddress_City() == null) || (getCurrentAddress_City().equals("null")))
/*  317 */         pstmt.setNull(9, 12);
/*      */       else {
/*  319 */         pstmt.setString(9, getCurrentAddress_City());
/*      */       }
/*  321 */       if ((getCurrentAddress_Detail() == null) || (getCurrentAddress_Detail().equals("null")))
/*  322 */         pstmt.setNull(10, 12);
/*      */       else {
/*  324 */         pstmt.setString(10, getCurrentAddress_Detail());
/*      */       }
/*  326 */       if ((getCurrentAddress_Country_en() == null) || (getCurrentAddress_Country_en().equals("null")))
/*  327 */         pstmt.setNull(11, 12);
/*      */       else {
/*  329 */         pstmt.setString(11, getCurrentAddress_Country_en());
/*      */       }
/*  331 */       if ((getCurrentAddress_Province_en() == null) || (getCurrentAddress_Province_en().equals("null")))
/*  332 */         pstmt.setNull(12, 12);
/*      */       else {
/*  334 */         pstmt.setString(12, getCurrentAddress_Province_en());
/*      */       }
/*  336 */       if ((getCurrentAddress_City_en() == null) || (getCurrentAddress_City_en().equals("null")))
/*  337 */         pstmt.setNull(13, 12);
/*      */       else {
/*  339 */         pstmt.setString(13, getCurrentAddress_City_en());
/*      */       }
/*  341 */       if ((getCurrentAddress_Detail_en() == null) || (getCurrentAddress_Detail_en().equals("null")))
/*  342 */         pstmt.setNull(14, 12);
/*      */       else {
/*  344 */         pstmt.setString(14, getCurrentAddress_Detail_en());
/*      */       }
/*  346 */       if ((getBirthAddress_Country() == null) || (getBirthAddress_Country().equals("null")))
/*  347 */         pstmt.setNull(15, 12);
/*      */       else {
/*  349 */         pstmt.setString(15, getBirthAddress_Country());
/*      */       }
/*  351 */       if ((getBirthAddress_Province() == null) || (getBirthAddress_Province().equals("null")))
/*  352 */         pstmt.setNull(16, 12);
/*      */       else {
/*  354 */         pstmt.setString(16, getBirthAddress_Province());
/*      */       }
/*  356 */       if ((getBirthAddress_City() == null) || (getBirthAddress_City().equals("null")))
/*  357 */         pstmt.setNull(17, 12);
/*      */       else {
/*  359 */         pstmt.setString(17, getBirthAddress_City());
/*      */       }
/*  361 */       if ((getBirthAddress_Detail() == null) || (getBirthAddress_Detail().equals("null")))
/*  362 */         pstmt.setNull(18, 12);
/*      */       else {
/*  364 */         pstmt.setString(18, getBirthAddress_Detail());
/*      */       }
/*  366 */       if ((getBirthAddress_Country_en() == null) || (getBirthAddress_Country_en().equals("null")))
/*  367 */         pstmt.setNull(19, 12);
/*      */       else {
/*  369 */         pstmt.setString(19, getBirthAddress_Country_en());
/*      */       }
/*  371 */       if ((getBirthAddress_Province_en() == null) || (getBirthAddress_Province_en().equals("null")))
/*  372 */         pstmt.setNull(20, 12);
/*      */       else {
/*  374 */         pstmt.setString(20, getBirthAddress_Province_en());
/*      */       }
/*  376 */       if ((getBirthAddress_City_en() == null) || (getBirthAddress_City_en().equals("null")))
/*  377 */         pstmt.setNull(21, 12);
/*      */       else {
/*  379 */         pstmt.setString(21, getBirthAddress_City_en());
/*      */       }
/*  381 */       if ((getBirthAddress_Detail_en() == null) || (getBirthAddress_Detail_en().equals("null")))
/*  382 */         pstmt.setNull(22, 12);
/*      */       else {
/*  384 */         pstmt.setString(22, getBirthAddress_Detail_en());
/*      */       }
/*  386 */       if ((getTaxResidentCountry1() == null) || (getTaxResidentCountry1().equals("null")))
/*  387 */         pstmt.setNull(23, 12);
/*      */       else {
/*  389 */         pstmt.setString(23, getTaxResidentCountry1());
/*      */       }
/*  391 */       if ((getTaxpayerCode1() == null) || (getTaxpayerCode1().equals("null")))
/*  392 */         pstmt.setNull(24, 12);
/*      */       else {
/*  394 */         pstmt.setString(24, getTaxpayerCode1());
/*      */       }
/*  396 */       if ((getTaxResidentCountry2() == null) || (getTaxResidentCountry2().equals("null")))
/*  397 */         pstmt.setNull(25, 12);
/*      */       else {
/*  399 */         pstmt.setString(25, getTaxResidentCountry2());
/*      */       }
/*  401 */       if ((getTaxpayerCode2() == null) || (getTaxpayerCode2().equals("null")))
/*  402 */         pstmt.setNull(26, 12);
/*      */       else {
/*  404 */         pstmt.setString(26, getTaxpayerCode2());
/*      */       }
/*  406 */       if ((getTaxResidentCountry3() == null) || (getTaxResidentCountry3().equals("null")))
/*  407 */         pstmt.setNull(27, 12);
/*      */       else {
/*  409 */         pstmt.setString(27, getTaxResidentCountry3());
/*      */       }
/*  411 */       if ((getTaxpayerCode3() == null) || (getTaxpayerCode3().equals("null")))
/*  412 */         pstmt.setNull(28, 12);
/*      */       else {
/*  414 */         pstmt.setString(28, getTaxpayerCode3());
/*      */       }
/*  416 */       if ((getNoTaxpayercodeReason() == null) || (getNoTaxpayercodeReason().equals("null")))
/*  417 */         pstmt.setNull(29, 12);
/*      */       else {
/*  419 */         pstmt.setString(29, getNoTaxpayercodeReason());
/*      */       }
/*  421 */       if ((getReasonDescription() == null) || (getReasonDescription().equals("null")))
/*  422 */         pstmt.setNull(30, 12);
/*      */       else {
/*  424 */         pstmt.setString(30, getReasonDescription());
/*      */       }
/*  426 */       if ((getSourceType() == null) || (getSourceType().equals("null")))
/*  427 */         pstmt.setNull(31, 12);
/*      */       else {
/*  429 */         pstmt.setString(31, getSourceType());
/*      */       }
/*  431 */       pstmt.executeUpdate();
/*  432 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  435 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  436 */       CError tError = new CError();
/*  437 */       tError.moduleName = "CRSInfoDB";
/*  438 */       tError.functionName = "insert()";
/*  439 */       tError.errorMessage = ex.toString();
/*  440 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  443 */         pstmt.close();
/*      */       }
/*      */       catch (Exception localException1) {
/*      */       }
/*  447 */       if (!this.mflag)
/*      */         try {
/*  449 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2)
/*      */         {
/*      */         }
/*  454 */       return false;
/*      */     }
/*      */ 
/*  457 */     if (!this.mflag)
/*      */       try {
/*  459 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3)
/*      */       {
/*      */       }
/*  464 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo() {
/*  468 */     PreparedStatement pstmt = null;
/*  469 */     ResultSet rs = null;
/*      */ 
/*  471 */     if (!this.mflag) {
/*  472 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  476 */       pstmt = this.con.prepareStatement("SELECT * FROM CRSInfo WHERE  ContNo = ?", 1003, 
/*  477 */         1007);
/*  478 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  479 */         pstmt.setNull(1, 12);
/*      */       else {
/*  481 */         pstmt.setString(1, getContNo());
/*      */       }
/*  483 */       rs = pstmt.executeQuery();
/*  484 */       int i = 0;
/*  485 */       if (rs.next()) {
/*  486 */         i++;
/*  487 */         if (!setSchema(rs, i))
/*      */         {
/*  489 */           CError tError = new CError();
/*  490 */           tError.moduleName = "CRSInfoDB";
/*  491 */           tError.functionName = "getInfo";
/*  492 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  493 */           this.mErrors.addOneError(tError);
/*      */           try
/*      */           {
/*  496 */             rs.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */           try {
/*  500 */             pstmt.close();
/*      */           }
/*      */           catch (Exception localException2) {
/*      */           }
/*  504 */           if (!this.mflag)
/*      */             try {
/*  506 */               this.con.close();
/*      */             }
/*      */             catch (Exception localException3) {
/*      */             }
/*  510 */           return false;
/*      */         }
/*      */       }
/*      */       try
/*      */       {
/*  515 */         rs.close();
/*      */       } catch (Exception localException4) {
/*      */       }
/*      */       try {
/*  519 */         pstmt.close();
/*      */       }
/*      */       catch (Exception localException5) {
/*      */       }
/*  523 */       if (i == 0) {
/*  524 */         if (!this.mflag)
/*      */           try {
/*  526 */             this.con.close();
/*      */           }
/*      */           catch (Exception localException6) {
/*      */           }
/*  530 */         return false;
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  534 */       CError tError = new CError();
/*  535 */       tError.moduleName = "CRSInfoDB";
/*  536 */       tError.functionName = "getInfo";
/*  537 */       tError.errorMessage = e.toString();
/*  538 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  541 */         rs.close();
/*      */       } catch (Exception localException7) {
/*      */       }
/*      */       try {
/*  545 */         pstmt.close();
/*      */       }
/*      */       catch (Exception localException8) {
/*      */       }
/*  549 */       if (!this.mflag)
/*      */         try {
/*  551 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException9) {
/*      */         }
/*  555 */       return false;
/*      */     }
/*      */ 
/*  558 */     if (!this.mflag)
/*      */       try {
/*  560 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10)
/*      */       {
/*      */       }
/*  565 */     return true;
/*      */   }
/*      */ 
/*      */   public CRSInfoSet query() {
/*  569 */     Statement stmt = null;
/*  570 */     ResultSet rs = null;
/*  571 */     CRSInfoSet aCRSInfoSet = new CRSInfoSet();
/*  572 */     System.out.println("\u93B5\u0446\uE511query--flag--false=" + this.mflag);
/*  573 */     if (!this.mflag)
/*      */     {
/*  575 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  579 */       stmt = this.con.createStatement(1003, 1007);
/*  580 */       SQLString sqlObj = new SQLString("CRSInfo");
/*  581 */       CRSInfoSchema aSchema = getSchema();
/*  582 */       String[] a = aSchema.getPK();
/*  583 */       for (String string : a) {
/*  584 */         System.out.println("pk=================" + string);
/*      */       }
/*  586 */       System.out.println("\u6D93\u5A5A\u656D\u93B5\uFFFD\u705E\u701Echema" + aSchema.toString());
/*  587 */       sqlObj.setSQL(6, aSchema);
/*  588 */       String sql = sqlObj.getSQL();
/*  589 */       System.out.println("\u93B5\u0446\uE511sql= " + sql);
/*      */ 
/*  591 */       rs = stmt.executeQuery(sql);
/*  592 */       int i = 0;
/*  593 */       while (rs.next()) {
/*  594 */         i++;
/*  595 */         CRSInfoSchema s1 = new CRSInfoSchema();
/*  596 */         s1.setSchema(rs, i);
/*  597 */         aCRSInfoSet.add(s1);
/*      */       }
/*      */       try {
/*  600 */         rs.close();
/*      */       } catch (Exception localException7) {
/*      */       }
/*      */       try {
/*  604 */         stmt.close();
/*      */       } catch (Exception localException8) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  609 */       CError tError = new CError();
/*  610 */       tError.moduleName = "CRSInfoDB";
/*  611 */       tError.functionName = "query";
/*  612 */       tError.errorMessage = e.toString();
/*  613 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  616 */         rs.close();
/*      */       } catch (Exception localException3) {
/*      */       }
/*      */       try {
/*  620 */         stmt.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*  624 */       if (!this.mflag)
/*      */         try {
/*  626 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5)
/*      */         {
/*      */         }
/*      */     }
/*  632 */     if (!this.mflag)
/*      */       try {
/*  634 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6)
/*      */       {
/*      */       }
/*  639 */     return aCRSInfoSet;
/*      */   }
/*      */ 
/*      */   public CRSInfoSet executeQuery(String sql) {
/*  643 */     Statement stmt = null;
/*  644 */     ResultSet rs = null;
/*  645 */     CRSInfoSet aCRSInfoSet = new CRSInfoSet();
/*      */ 
/*  647 */     if (!this.mflag) {
/*  648 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  652 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  654 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  655 */       int i = 0;
/*  656 */       while (rs.next()) {
/*  657 */         i++;
/*  658 */         CRSInfoSchema s1 = new CRSInfoSchema();
/*  659 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  661 */           CError tError = new CError();
/*  662 */           tError.moduleName = "CRSInfoDB";
/*  663 */           tError.functionName = "executeQuery";
/*  664 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  665 */           this.mErrors.addOneError(tError);
/*      */         }
/*  667 */         aCRSInfoSet.add(s1);
/*      */       }
/*      */       try {
/*  670 */         rs.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*      */       try {
/*  674 */         stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  679 */       CError tError = new CError();
/*  680 */       tError.moduleName = "CRSInfoDB";
/*  681 */       tError.functionName = "executeQuery";
/*  682 */       tError.errorMessage = e.toString();
/*  683 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  686 */         rs.close();
/*      */       } catch (Exception localException3) {
/*      */       }
/*      */       try {
/*  690 */         stmt.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*  694 */       if (!this.mflag)
/*      */         try {
/*  696 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5)
/*      */         {
/*      */         }
/*      */     }
/*  702 */     if (!this.mflag)
/*      */       try {
/*  704 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6)
/*      */       {
/*      */       }
/*  709 */     return aCRSInfoSet;
/*      */   }
/*      */ 
/*      */   public CRSInfoSet query(int nStart, int nCount) {
/*  713 */     Statement stmt = null;
/*  714 */     ResultSet rs = null;
/*  715 */     CRSInfoSet aCRSInfoSet = new CRSInfoSet();
/*      */ 
/*  717 */     if (!this.mflag) {
/*  718 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  722 */       stmt = this.con.createStatement(1003, 1007);
/*  723 */       SQLString sqlObj = new SQLString("CRSInfo");
/*  724 */       CRSInfoSchema aSchema = getSchema();
/*  725 */       sqlObj.setSQL(5, aSchema);
/*  726 */       String sql = sqlObj.getSQL();
/*      */ 
/*  728 */       rs = stmt.executeQuery(sql);
/*  729 */       int i = 0;
/*  730 */       while (rs.next()) {
/*  731 */         i++;
/*      */ 
/*  733 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  737 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  741 */         CRSInfoSchema s1 = new CRSInfoSchema();
/*  742 */         s1.setSchema(rs, i);
/*  743 */         aCRSInfoSet.add(s1);
/*      */       }
/*      */       try {
/*  746 */         rs.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*      */       try {
/*  750 */         stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  755 */       CError tError = new CError();
/*  756 */       tError.moduleName = "CRSInfoDB";
/*  757 */       tError.functionName = "query";
/*  758 */       tError.errorMessage = e.toString();
/*  759 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  762 */         rs.close();
/*      */       } catch (Exception localException3) {
/*      */       }
/*      */       try {
/*  766 */         stmt.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*  770 */       if (!this.mflag)
/*      */         try {
/*  772 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5)
/*      */         {
/*      */         }
/*      */     }
/*  778 */     if (!this.mflag)
/*      */       try {
/*  780 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6)
/*      */       {
/*      */       }
/*  785 */     return aCRSInfoSet;
/*      */   }
/*      */ 
/*      */   public CRSInfoSet executeQuery(String sql, int nStart, int nCount) {
/*  789 */     Statement stmt = null;
/*  790 */     ResultSet rs = null;
/*  791 */     CRSInfoSet aCRSInfoSet = new CRSInfoSet();
/*      */ 
/*  793 */     if (!this.mflag) {
/*  794 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  798 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  800 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  801 */       int i = 0;
/*  802 */       while (rs.next()) {
/*  803 */         i++;
/*      */ 
/*  805 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  809 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  813 */         CRSInfoSchema s1 = new CRSInfoSchema();
/*  814 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  816 */           CError tError = new CError();
/*  817 */           tError.moduleName = "CRSInfoDB";
/*  818 */           tError.functionName = "executeQuery";
/*  819 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  820 */           this.mErrors.addOneError(tError);
/*      */         }
/*  822 */         aCRSInfoSet.add(s1);
/*      */       }
/*      */       try {
/*  825 */         rs.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*      */       try {
/*  829 */         stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  834 */       CError tError = new CError();
/*  835 */       tError.moduleName = "CRSInfoDB";
/*  836 */       tError.functionName = "executeQuery";
/*  837 */       tError.errorMessage = e.toString();
/*  838 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  841 */         rs.close();
/*      */       } catch (Exception localException3) {
/*      */       }
/*      */       try {
/*  845 */         stmt.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*  849 */       if (!this.mflag)
/*      */         try {
/*  851 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5)
/*      */         {
/*      */         }
/*      */     }
/*  857 */     if (!this.mflag)
/*      */       try {
/*  859 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6)
/*      */       {
/*      */       }
/*  864 */     return aCRSInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart) {
/*  868 */     Statement stmt = null;
/*      */ 
/*  870 */     if (!this.mflag) {
/*  871 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  875 */       stmt = this.con.createStatement(1003, 1007);
/*  876 */       SQLString sqlObj = new SQLString("CRSInfo");
/*  877 */       CRSInfoSchema aSchema = getSchema();
/*  878 */       sqlObj.setSQL(2, aSchema);
/*  879 */       String sql = "update CRSInfo " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  881 */       int operCount = stmt.executeUpdate(sql);
/*  882 */       if (operCount == 0)
/*      */       {
/*  884 */         CError tError = new CError();
/*  885 */         tError.moduleName = "CRSInfoDB";
/*  886 */         tError.functionName = "update";
/*  887 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  888 */         this.mErrors.addOneError(tError);
/*      */ 
/*  890 */         if (!this.mflag)
/*      */           try {
/*  892 */             this.con.close();
/*      */           }
/*      */           catch (Exception localException1) {
/*      */           }
/*  896 */         return false;
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  900 */       CError tError = new CError();
/*  901 */       tError.moduleName = "CRSInfoDB";
/*  902 */       tError.functionName = "update";
/*  903 */       tError.errorMessage = e.toString();
/*  904 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  907 */         stmt.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  911 */       if (!this.mflag)
/*      */         try {
/*  913 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*  917 */       return false;
/*      */     }
/*      */ 
/*  920 */     if (!this.mflag)
/*      */       try {
/*  922 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4)
/*      */       {
/*      */       }
/*  927 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL) {
/*  931 */     if (this.mResultSet != null)
/*      */     {
/*  933 */       CError tError = new CError();
/*  934 */       tError.moduleName = "CRSInfoDB";
/*  935 */       tError.functionName = "prepareData";
/*  936 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  937 */       this.mErrors.addOneError(tError);
/*  938 */       return false;
/*      */     }
/*      */ 
/*  941 */     if (!this.mflag)
/*  942 */       this.con = DBConnPool.getConnection();
/*      */     try
/*      */     {
/*  945 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  946 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e) {
/*  949 */       CError tError = new CError();
/*  950 */       tError.moduleName = "CRSInfoDB";
/*  951 */       tError.functionName = "prepareData";
/*  952 */       tError.errorMessage = e.toString();
/*  953 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  955 */         this.mResultSet.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*      */       try {
/*  959 */         this.mStatement.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*  962 */       if (!this.mflag)
/*      */         try {
/*  964 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*  968 */       return false;
/*      */     }
/*      */ 
/*  971 */     if (!this.mflag)
/*      */       try {
/*  973 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*  977 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData() {
/*  981 */     boolean flag = true;
/*  982 */     if (this.mResultSet == null) {
/*  983 */       CError tError = new CError();
/*  984 */       tError.moduleName = "CRSInfoDB";
/*  985 */       tError.functionName = "hasMoreData";
/*  986 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  987 */       this.mErrors.addOneError(tError);
/*  988 */       return false;
/*      */     }
/*      */     try {
/*  991 */       flag = this.mResultSet.next();
/*      */     } catch (Exception ex) {
/*  993 */       CError tError = new CError();
/*  994 */       tError.moduleName = "CRSInfoDB";
/*  995 */       tError.functionName = "hasMoreData";
/*  996 */       tError.errorMessage = ex.toString();
/*  997 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  999 */         this.mResultSet.close();
/* 1000 */         this.mResultSet = null;
/*      */       } catch (Exception localException1) {
/*      */       }
/*      */       try {
/* 1004 */         this.mStatement.close();
/* 1005 */         this.mStatement = null;
/*      */       } catch (Exception localException2) {
/*      */       }
/* 1008 */       if (!this.mflag)
/*      */         try {
/* 1010 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/* 1014 */       return false;
/*      */     }
/* 1016 */     return flag;
/*      */   }
/*      */ 
/*      */   public CRSInfoSet getData() {
/* 1020 */     int tCount = 0;
/* 1021 */     CRSInfoSet tCRSInfoSet = new CRSInfoSet();
/* 1022 */     CRSInfoSchema tCRSInfoSchema = null;
/* 1023 */     if (this.mResultSet == null) {
/* 1024 */       CError tError = new CError();
/* 1025 */       tError.moduleName = "CRSInfoDB";
/* 1026 */       tError.functionName = "getData";
/* 1027 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1028 */       this.mErrors.addOneError(tError);
/* 1029 */       return null;
/*      */     }
/*      */     try {
/* 1032 */       tCount = 1;
/* 1033 */       tCRSInfoSchema = new CRSInfoSchema();
/* 1034 */       tCRSInfoSchema.setSchema(this.mResultSet, 1);
/* 1035 */       tCRSInfoSet.add(tCRSInfoSchema);
/*      */ 
/* 1037 */       while (tCount++ < 5000)
/* 1038 */         if (this.mResultSet.next()) {
/* 1039 */           tCRSInfoSchema = new CRSInfoSchema();
/* 1040 */           tCRSInfoSchema.setSchema(this.mResultSet, 1);
/* 1041 */           tCRSInfoSet.add(tCRSInfoSchema);
/*      */         }
/*      */     }
/*      */     catch (Exception ex) {
/* 1045 */       CError tError = new CError();
/* 1046 */       tError.moduleName = "CRSInfoDB";
/* 1047 */       tError.functionName = "getData";
/* 1048 */       tError.errorMessage = ex.toString();
/* 1049 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1051 */         this.mResultSet.close();
/* 1052 */         this.mResultSet = null;
/*      */       } catch (Exception localException1) {
/*      */       }
/*      */       try {
/* 1056 */         this.mStatement.close();
/* 1057 */         this.mStatement = null;
/*      */       } catch (Exception localException2) {
/*      */       }
/* 1060 */       if (!this.mflag)
/*      */         try {
/* 1062 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/* 1066 */       return null;
/*      */     }
/* 1068 */     return tCRSInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData() {
/* 1072 */     boolean flag = true;
/*      */     try {
/* 1074 */       if (this.mResultSet == null) {
/* 1075 */         CError tError = new CError();
/* 1076 */         tError.moduleName = "CRSInfoDB";
/* 1077 */         tError.functionName = "closeData";
/* 1078 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1079 */         this.mErrors.addOneError(tError);
/* 1080 */         flag = false;
/*      */       } else {
/* 1082 */         this.mResultSet.close();
/* 1083 */         this.mResultSet = null;
/*      */       }
/*      */     } catch (Exception ex2) {
/* 1086 */       CError tError = new CError();
/* 1087 */       tError.moduleName = "CRSInfoDB";
/* 1088 */       tError.functionName = "closeData";
/* 1089 */       tError.errorMessage = ex2.toString();
/* 1090 */       this.mErrors.addOneError(tError);
/* 1091 */       flag = false;
/*      */     }
/*      */     try {
/* 1094 */       if (this.mStatement == null) {
/* 1095 */         CError tError = new CError();
/* 1096 */         tError.moduleName = "CRSInfoDB";
/* 1097 */         tError.functionName = "closeData";
/* 1098 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1099 */         this.mErrors.addOneError(tError);
/* 1100 */         flag = false;
/*      */       } else {
/* 1102 */         this.mStatement.close();
/* 1103 */         this.mStatement = null;
/*      */       }
/*      */     } catch (Exception ex3) {
/* 1106 */       CError tError = new CError();
/* 1107 */       tError.moduleName = "CRSInfoDB";
/* 1108 */       tError.functionName = "closeData";
/* 1109 */       tError.errorMessage = ex3.toString();
/* 1110 */       this.mErrors.addOneError(tError);
/* 1111 */       flag = false;
/*      */     }
/* 1113 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.CRSInfoDB
 * JD-Core Version:    0.6.0
 */