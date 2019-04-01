/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MComSchema;
/*      */ import com.sinosoft.map.lis.vschema.MComSet;
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
/*      */ public class MComDB extends MComSchema
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
/*      */   public MComDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MCom");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MComDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MCom");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MComSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MComDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MComSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MComDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MCom WHERE  ComCode = ?");
/*   96 */       if ((getComCode() == null) || (getComCode().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getComCode());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MComDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MCom SET  ComCode = ? , OutComCode = ? , Name = ? , ShortName = ? , Address = ? , ZipCode = ? , Phone = ? , Fax = ? , EMail = ? , WebAddress = ? , SatrapName = ? , InsuMonitorCode = ? , InsureID = ? , SignID = ? , Country = ? , Province = ? , City = ? , ComNature = ? , ValidCode = ? , Sign = ? WHERE  ComCode = ?");
/*  145 */       if ((getComCode() == null) || (getComCode().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getComCode());
/*      */       }
/*  150 */       if ((getOutComCode() == null) || (getOutComCode().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getOutComCode());
/*      */       }
/*  155 */       if ((getName() == null) || (getName().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getName());
/*      */       }
/*  160 */       if ((getShortName() == null) || (getShortName().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getShortName());
/*      */       }
/*  165 */       if ((getAddress() == null) || (getAddress().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getAddress());
/*      */       }
/*  170 */       if ((getZipCode() == null) || (getZipCode().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getZipCode());
/*      */       }
/*  175 */       if ((getPhone() == null) || (getPhone().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getPhone());
/*      */       }
/*  180 */       if ((getFax() == null) || (getFax().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getFax());
/*      */       }
/*  185 */       if ((getEMail() == null) || (getEMail().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getEMail());
/*      */       }
/*  190 */       if ((getWebAddress() == null) || (getWebAddress().equals("null")))
/*  191 */         pstmt.setNull(10, 12);
/*      */       else {
/*  193 */         pstmt.setString(10, getWebAddress());
/*      */       }
/*  195 */       if ((getSatrapName() == null) || (getSatrapName().equals("null")))
/*  196 */         pstmt.setNull(11, 12);
/*      */       else {
/*  198 */         pstmt.setString(11, getSatrapName());
/*      */       }
/*  200 */       if ((getInsuMonitorCode() == null) || (getInsuMonitorCode().equals("null")))
/*  201 */         pstmt.setNull(12, 12);
/*      */       else {
/*  203 */         pstmt.setString(12, getInsuMonitorCode());
/*      */       }
/*  205 */       if ((getInsureID() == null) || (getInsureID().equals("null")))
/*  206 */         pstmt.setNull(13, 12);
/*      */       else {
/*  208 */         pstmt.setString(13, getInsureID());
/*      */       }
/*  210 */       if ((getSignID() == null) || (getSignID().equals("null")))
/*  211 */         pstmt.setNull(14, 12);
/*      */       else {
/*  213 */         pstmt.setString(14, getSignID());
/*      */       }
/*  215 */       if ((getCountry() == null) || (getCountry().equals("null")))
/*  216 */         pstmt.setNull(15, 12);
/*      */       else {
/*  218 */         pstmt.setString(15, getCountry());
/*      */       }
/*  220 */       if ((getProvince() == null) || (getProvince().equals("null")))
/*  221 */         pstmt.setNull(16, 12);
/*      */       else {
/*  223 */         pstmt.setString(16, getProvince());
/*      */       }
/*  225 */       if ((getCity() == null) || (getCity().equals("null")))
/*  226 */         pstmt.setNull(17, 12);
/*      */       else {
/*  228 */         pstmt.setString(17, getCity());
/*      */       }
/*  230 */       if ((getComNature() == null) || (getComNature().equals("null")))
/*  231 */         pstmt.setNull(18, 12);
/*      */       else {
/*  233 */         pstmt.setString(18, getComNature());
/*      */       }
/*  235 */       if ((getValidCode() == null) || (getValidCode().equals("null")))
/*  236 */         pstmt.setNull(19, 12);
/*      */       else {
/*  238 */         pstmt.setString(19, getValidCode());
/*      */       }
/*  240 */       if ((getSign() == null) || (getSign().equals("null")))
/*  241 */         pstmt.setNull(20, 12);
/*      */       else {
/*  243 */         pstmt.setString(20, getSign());
/*      */       }
/*      */ 
/*  246 */       if ((getComCode() == null) || (getComCode().equals("null")))
/*  247 */         pstmt.setNull(21, 12);
/*      */       else {
/*  249 */         pstmt.setString(21, getComCode());
/*      */       }
/*  251 */       pstmt.executeUpdate();
/*  252 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  255 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  256 */       CError tError = new CError();
/*  257 */       tError.moduleName = "MComDB";
/*  258 */       tError.functionName = "update()";
/*  259 */       tError.errorMessage = ex.toString();
/*  260 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  263 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  266 */       if (!this.mflag)
/*      */         try {
/*  268 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  272 */       return false;
/*      */     }
/*      */ 
/*  275 */     if (!this.mflag)
/*      */       try {
/*  277 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  281 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  286 */     PreparedStatement pstmt = null;
/*      */ 
/*  288 */     if (!this.mflag) {
/*  289 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  294 */       pstmt = this.con.prepareStatement("INSERT INTO MCom VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  295 */       if ((getComCode() == null) || (getComCode().equals("null")))
/*  296 */         pstmt.setNull(1, 12);
/*      */       else {
/*  298 */         pstmt.setString(1, getComCode());
/*      */       }
/*  300 */       if ((getOutComCode() == null) || (getOutComCode().equals("null")))
/*  301 */         pstmt.setNull(2, 12);
/*      */       else {
/*  303 */         pstmt.setString(2, getOutComCode());
/*      */       }
/*  305 */       if ((getName() == null) || (getName().equals("null")))
/*  306 */         pstmt.setNull(3, 12);
/*      */       else {
/*  308 */         pstmt.setString(3, getName());
/*      */       }
/*  310 */       if ((getShortName() == null) || (getShortName().equals("null")))
/*  311 */         pstmt.setNull(4, 12);
/*      */       else {
/*  313 */         pstmt.setString(4, getShortName());
/*      */       }
/*  315 */       if ((getAddress() == null) || (getAddress().equals("null")))
/*  316 */         pstmt.setNull(5, 12);
/*      */       else {
/*  318 */         pstmt.setString(5, getAddress());
/*      */       }
/*  320 */       if ((getZipCode() == null) || (getZipCode().equals("null")))
/*  321 */         pstmt.setNull(6, 12);
/*      */       else {
/*  323 */         pstmt.setString(6, getZipCode());
/*      */       }
/*  325 */       if ((getPhone() == null) || (getPhone().equals("null")))
/*  326 */         pstmt.setNull(7, 12);
/*      */       else {
/*  328 */         pstmt.setString(7, getPhone());
/*      */       }
/*  330 */       if ((getFax() == null) || (getFax().equals("null")))
/*  331 */         pstmt.setNull(8, 12);
/*      */       else {
/*  333 */         pstmt.setString(8, getFax());
/*      */       }
/*  335 */       if ((getEMail() == null) || (getEMail().equals("null")))
/*  336 */         pstmt.setNull(9, 12);
/*      */       else {
/*  338 */         pstmt.setString(9, getEMail());
/*      */       }
/*  340 */       if ((getWebAddress() == null) || (getWebAddress().equals("null")))
/*  341 */         pstmt.setNull(10, 12);
/*      */       else {
/*  343 */         pstmt.setString(10, getWebAddress());
/*      */       }
/*  345 */       if ((getSatrapName() == null) || (getSatrapName().equals("null")))
/*  346 */         pstmt.setNull(11, 12);
/*      */       else {
/*  348 */         pstmt.setString(11, getSatrapName());
/*      */       }
/*  350 */       if ((getInsuMonitorCode() == null) || (getInsuMonitorCode().equals("null")))
/*  351 */         pstmt.setNull(12, 12);
/*      */       else {
/*  353 */         pstmt.setString(12, getInsuMonitorCode());
/*      */       }
/*  355 */       if ((getInsureID() == null) || (getInsureID().equals("null")))
/*  356 */         pstmt.setNull(13, 12);
/*      */       else {
/*  358 */         pstmt.setString(13, getInsureID());
/*      */       }
/*  360 */       if ((getSignID() == null) || (getSignID().equals("null")))
/*  361 */         pstmt.setNull(14, 12);
/*      */       else {
/*  363 */         pstmt.setString(14, getSignID());
/*      */       }
/*  365 */       if ((getCountry() == null) || (getCountry().equals("null")))
/*  366 */         pstmt.setNull(15, 12);
/*      */       else {
/*  368 */         pstmt.setString(15, getCountry());
/*      */       }
/*  370 */       if ((getProvince() == null) || (getProvince().equals("null")))
/*  371 */         pstmt.setNull(16, 12);
/*      */       else {
/*  373 */         pstmt.setString(16, getProvince());
/*      */       }
/*  375 */       if ((getCity() == null) || (getCity().equals("null")))
/*  376 */         pstmt.setNull(17, 12);
/*      */       else {
/*  378 */         pstmt.setString(17, getCity());
/*      */       }
/*  380 */       if ((getComNature() == null) || (getComNature().equals("null")))
/*  381 */         pstmt.setNull(18, 12);
/*      */       else {
/*  383 */         pstmt.setString(18, getComNature());
/*      */       }
/*  385 */       if ((getValidCode() == null) || (getValidCode().equals("null")))
/*  386 */         pstmt.setNull(19, 12);
/*      */       else {
/*  388 */         pstmt.setString(19, getValidCode());
/*      */       }
/*  390 */       if ((getSign() == null) || (getSign().equals("null")))
/*  391 */         pstmt.setNull(20, 12);
/*      */       else {
/*  393 */         pstmt.setString(20, getSign());
/*      */       }
/*      */ 
/*  396 */       pstmt.executeUpdate();
/*  397 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  400 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  401 */       CError tError = new CError();
/*  402 */       tError.moduleName = "MComDB";
/*  403 */       tError.functionName = "insert()";
/*  404 */       tError.errorMessage = ex.toString();
/*  405 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  408 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  411 */       if (!this.mflag)
/*      */         try {
/*  413 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  417 */       return false;
/*      */     }
/*      */ 
/*  420 */     if (!this.mflag)
/*      */       try {
/*  422 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  426 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  431 */     PreparedStatement pstmt = null;
/*  432 */     ResultSet rs = null;
/*      */ 
/*  434 */     if (!this.mflag) {
/*  435 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  440 */       pstmt = this.con.prepareStatement("SELECT * FROM MCom WHERE  ComCode = ?", 
/*  441 */         1003, 1007);
/*  442 */       if ((getComCode() == null) || (getComCode().equals("null")))
/*  443 */         pstmt.setNull(1, 12);
/*      */       else {
/*  445 */         pstmt.setString(1, getComCode());
/*      */       }
/*  447 */       rs = pstmt.executeQuery();
/*  448 */       int i = 0;
/*  449 */       if (rs.next())
/*      */       {
/*  451 */         i++;
/*  452 */         if (!setSchema(rs, i))
/*      */         {
/*  455 */           CError tError = new CError();
/*  456 */           tError.moduleName = "MComDB";
/*  457 */           tError.functionName = "getInfo";
/*  458 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  459 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  461 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  464 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  468 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  472 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  476 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  479 */       if (i == 0)
/*      */       {
/*  481 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  485 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  489 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  495 */       CError tError = new CError();
/*  496 */       tError.moduleName = "MComDB";
/*  497 */       tError.functionName = "getInfo";
/*  498 */       tError.errorMessage = e.toString();
/*  499 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  501 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  504 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  508 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  512 */       return false;
/*      */     }
/*      */ 
/*  515 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  519 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  524 */     return true;
/*      */   }
/*      */ 
/*      */   public MComSet query()
/*      */   {
/*  529 */     Statement stmt = null;
/*  530 */     ResultSet rs = null;
/*  531 */     MComSet aMComSet = new MComSet();
/*      */ 
/*  533 */     if (!this.mflag) {
/*  534 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  539 */       stmt = this.con.createStatement(1003, 1007);
/*  540 */       SQLString sqlObj = new SQLString("MCom");
/*  541 */       MComSchema aSchema = getSchema();
/*  542 */       sqlObj.setSQL(5, aSchema);
/*  543 */       String sql = sqlObj.getSQL();
/*      */ 
/*  545 */       rs = stmt.executeQuery(sql);
/*  546 */       int i = 0;
/*  547 */       while (rs.next())
/*      */       {
/*  549 */         i++;
/*  550 */         MComSchema s1 = new MComSchema();
/*  551 */         s1.setSchema(rs, i);
/*  552 */         aMComSet.add(s1);
/*      */       }try {
/*  554 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  560 */       CError tError = new CError();
/*  561 */       tError.moduleName = "MComDB";
/*  562 */       tError.functionName = "query";
/*  563 */       tError.errorMessage = e.toString();
/*  564 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  566 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  569 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  573 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  579 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  583 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  588 */     return aMComSet;
/*      */   }
/*      */ 
/*      */   public MComSet executeQuery(String sql)
/*      */   {
/*  593 */     Statement stmt = null;
/*  594 */     ResultSet rs = null;
/*  595 */     MComSet aMComSet = new MComSet();
/*      */ 
/*  597 */     if (!this.mflag) {
/*  598 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  603 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  605 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  606 */       int i = 0;
/*  607 */       while (rs.next())
/*      */       {
/*  609 */         i++;
/*  610 */         MComSchema s1 = new MComSchema();
/*  611 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  614 */           CError tError = new CError();
/*  615 */           tError.moduleName = "MComDB";
/*  616 */           tError.functionName = "executeQuery";
/*  617 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  618 */           this.mErrors.addOneError(tError);
/*      */         }
/*  620 */         aMComSet.add(s1);
/*      */       }try {
/*  622 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  628 */       CError tError = new CError();
/*  629 */       tError.moduleName = "MComDB";
/*  630 */       tError.functionName = "executeQuery";
/*  631 */       tError.errorMessage = e.toString();
/*  632 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  634 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  637 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  641 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  647 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  651 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  656 */     return aMComSet;
/*      */   }
/*      */ 
/*      */   public MComSet query(int nStart, int nCount)
/*      */   {
/*  661 */     Statement stmt = null;
/*  662 */     ResultSet rs = null;
/*  663 */     MComSet aMComSet = new MComSet();
/*      */ 
/*  665 */     if (!this.mflag) {
/*  666 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  671 */       stmt = this.con.createStatement(1003, 1007);
/*  672 */       SQLString sqlObj = new SQLString("MCom");
/*  673 */       MComSchema aSchema = getSchema();
/*  674 */       sqlObj.setSQL(5, aSchema);
/*  675 */       String sql = sqlObj.getSQL();
/*      */ 
/*  677 */       rs = stmt.executeQuery(sql);
/*  678 */       int i = 0;
/*  679 */       while (rs.next())
/*      */       {
/*  681 */         i++;
/*      */ 
/*  683 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  687 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  691 */         MComSchema s1 = new MComSchema();
/*  692 */         s1.setSchema(rs, i);
/*  693 */         aMComSet.add(s1);
/*      */       }try {
/*  695 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  701 */       CError tError = new CError();
/*  702 */       tError.moduleName = "MComDB";
/*  703 */       tError.functionName = "query";
/*  704 */       tError.errorMessage = e.toString();
/*  705 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  707 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  710 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  714 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  720 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  724 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  729 */     return aMComSet;
/*      */   }
/*      */ 
/*      */   public MComSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  734 */     Statement stmt = null;
/*  735 */     ResultSet rs = null;
/*  736 */     MComSet aMComSet = new MComSet();
/*      */ 
/*  738 */     if (!this.mflag) {
/*  739 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  744 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  746 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  747 */       int i = 0;
/*  748 */       while (rs.next())
/*      */       {
/*  750 */         i++;
/*      */ 
/*  752 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  756 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  760 */         MComSchema s1 = new MComSchema();
/*  761 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  764 */           CError tError = new CError();
/*  765 */           tError.moduleName = "MComDB";
/*  766 */           tError.functionName = "executeQuery";
/*  767 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  768 */           this.mErrors.addOneError(tError);
/*      */         }
/*  770 */         aMComSet.add(s1);
/*      */       }try {
/*  772 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  778 */       CError tError = new CError();
/*  779 */       tError.moduleName = "MComDB";
/*  780 */       tError.functionName = "executeQuery";
/*  781 */       tError.errorMessage = e.toString();
/*  782 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  784 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  787 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  791 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  797 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  801 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  806 */     return aMComSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  811 */     Statement stmt = null;
/*      */ 
/*  813 */     if (!this.mflag) {
/*  814 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  819 */       stmt = this.con.createStatement(1003, 1007);
/*  820 */       SQLString sqlObj = new SQLString("MCom");
/*  821 */       MComSchema aSchema = getSchema();
/*  822 */       sqlObj.setSQL(2, aSchema);
/*  823 */       String sql = "update MCom " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  825 */       int operCount = stmt.executeUpdate(sql);
/*  826 */       if (operCount == 0)
/*      */       {
/*  829 */         CError tError = new CError();
/*  830 */         tError.moduleName = "MComDB";
/*  831 */         tError.functionName = "update";
/*  832 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  833 */         this.mErrors.addOneError(tError);
/*      */ 
/*  835 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  839 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  843 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  849 */       CError tError = new CError();
/*  850 */       tError.moduleName = "MComDB";
/*  851 */       tError.functionName = "update";
/*  852 */       tError.errorMessage = e.toString();
/*  853 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  855 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  857 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  861 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  865 */       return false;
/*      */     }
/*      */ 
/*  868 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  872 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  877 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  883 */     if (this.mResultSet != null)
/*      */     {
/*  886 */       CError tError = new CError();
/*  887 */       tError.moduleName = "MComDB";
/*  888 */       tError.functionName = "prepareData";
/*  889 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  890 */       this.mErrors.addOneError(tError);
/*  891 */       return false;
/*      */     }
/*      */ 
/*  894 */     if (!this.mflag)
/*      */     {
/*  896 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  900 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  901 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  906 */       CError tError = new CError();
/*  907 */       tError.moduleName = "MComDB";
/*  908 */       tError.functionName = "prepareData";
/*  909 */       tError.errorMessage = e.toString();
/*  910 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  913 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  919 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  923 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  927 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  932 */       return false;
/*      */     }
/*      */ 
/*  935 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  939 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  944 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  950 */     boolean flag = true;
/*  951 */     if (this.mResultSet == null)
/*      */     {
/*  953 */       CError tError = new CError();
/*  954 */       tError.moduleName = "MComDB";
/*  955 */       tError.functionName = "hasMoreData";
/*  956 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  957 */       this.mErrors.addOneError(tError);
/*  958 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  962 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  966 */       CError tError = new CError();
/*  967 */       tError.moduleName = "MComDB";
/*  968 */       tError.functionName = "hasMoreData";
/*  969 */       tError.errorMessage = ex.toString();
/*  970 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  973 */         this.mResultSet.close();
/*  974 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  980 */         this.mStatement.close();
/*  981 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  985 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  989 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  994 */       return false;
/*      */     }
/*  996 */     return flag;
/*      */   }
/*      */ 
/*      */   public MComSet getData()
/*      */   {
/* 1001 */     int tCount = 0;
/* 1002 */     MComSet tMComSet = new MComSet();
/* 1003 */     MComSchema tMComSchema = null;
/* 1004 */     if (this.mResultSet == null)
/*      */     {
/* 1006 */       CError tError = new CError();
/* 1007 */       tError.moduleName = "MComDB";
/* 1008 */       tError.functionName = "getData";
/* 1009 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1010 */       this.mErrors.addOneError(tError);
/* 1011 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1015 */       tCount = 1;
/* 1016 */       tMComSchema = new MComSchema();
/* 1017 */       tMComSchema.setSchema(this.mResultSet, 1);
/* 1018 */       tMComSet.add(tMComSchema);
/*      */ 
/* 1020 */       while (tCount++ < 5000)
/*      */       {
/* 1022 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1024 */         tMComSchema = new MComSchema();
/* 1025 */         tMComSchema.setSchema(this.mResultSet, 1);
/* 1026 */         tMComSet.add(tMComSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1032 */       CError tError = new CError();
/* 1033 */       tError.moduleName = "MComDB";
/* 1034 */       tError.functionName = "getData";
/* 1035 */       tError.errorMessage = ex.toString();
/* 1036 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1039 */         this.mResultSet.close();
/* 1040 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1046 */         this.mStatement.close();
/* 1047 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1051 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1055 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1060 */       return null;
/*      */     }
/* 1062 */     return tMComSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1067 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1070 */       if (this.mResultSet == null)
/*      */       {
/* 1072 */         CError tError = new CError();
/* 1073 */         tError.moduleName = "MComDB";
/* 1074 */         tError.functionName = "closeData";
/* 1075 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1076 */         this.mErrors.addOneError(tError);
/* 1077 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1081 */         this.mResultSet.close();
/* 1082 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1087 */       CError tError = new CError();
/* 1088 */       tError.moduleName = "MComDB";
/* 1089 */       tError.functionName = "closeData";
/* 1090 */       tError.errorMessage = ex2.toString();
/* 1091 */       this.mErrors.addOneError(tError);
/* 1092 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1096 */       if (this.mStatement == null)
/*      */       {
/* 1098 */         CError tError = new CError();
/* 1099 */         tError.moduleName = "MComDB";
/* 1100 */         tError.functionName = "closeData";
/* 1101 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1102 */         this.mErrors.addOneError(tError);
/* 1103 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1107 */         this.mStatement.close();
/* 1108 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1113 */       CError tError = new CError();
/* 1114 */       tError.moduleName = "MComDB";
/* 1115 */       tError.functionName = "closeData";
/* 1116 */       tError.errorMessage = ex3.toString();
/* 1117 */       this.mErrors.addOneError(tError);
/* 1118 */       flag = false;
/*      */     }
/* 1120 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MComDB
 * JD-Core Version:    0.6.0
 */