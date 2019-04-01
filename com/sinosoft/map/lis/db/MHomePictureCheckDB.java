/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MHomePictureCheckSchema;
/*      */ import com.sinosoft.map.lis.vschema.MHomePictureCheckSet;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.DBConnPool;
/*      */ import com.sinosoft.map.utility.DBOper;
/*      */ import com.sinosoft.map.utility.SQLString;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class MHomePictureCheckDB extends MHomePictureCheckSchema
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
/*      */   public MHomePictureCheckDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MHomePictureCheck");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MHomePictureCheck");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MHomePictureCheckSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MHomePictureCheckDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MHomePictureCheckSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MHomePictureCheckDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MHomePictureCheck WHERE  ID = ?");
/*   96 */       if ((getID() == null) || (getID().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getID());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MHomePictureCheckDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MHomePictureCheck SET  ID = ? , URL = ? , RefURL = ? , Name = ? , Alt = ? , PicOrder = ? , DisplayFlag = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ID = ?");
/*  145 */       if ((getID() == null) || (getID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getID());
/*      */       }
/*  150 */       if ((getURL() == null) || (getURL().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getURL());
/*      */       }
/*  155 */       if ((getRefURL() == null) || (getRefURL().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getRefURL());
/*      */       }
/*  160 */       if ((getName() == null) || (getName().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getName());
/*      */       }
/*  165 */       if ((getAlt() == null) || (getAlt().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getAlt());
/*      */       }
/*  170 */       pstmt.setInt(6, getPicOrder());
/*  171 */       if ((getDisplayFlag() == null) || (getDisplayFlag().equals("null")))
/*  172 */         pstmt.setNull(7, 12);
/*      */       else {
/*  174 */         pstmt.setString(7, getDisplayFlag());
/*      */       }
/*  176 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  177 */         pstmt.setNull(8, 12);
/*      */       else {
/*  179 */         pstmt.setString(8, getCheckState());
/*      */       }
/*  181 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  182 */         pstmt.setNull(9, 12);
/*      */       else {
/*  184 */         pstmt.setString(9, getCheckOperator());
/*      */       }
/*  186 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  187 */         pstmt.setNull(10, 12);
/*      */       else {
/*  189 */         pstmt.setString(10, getCheckReason());
/*      */       }
/*  191 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  192 */         pstmt.setNull(11, 91);
/*      */       else {
/*  194 */         pstmt.setDate(11, Date.valueOf(getCheckDate()));
/*      */       }
/*  196 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  197 */         pstmt.setNull(12, 12);
/*      */       else {
/*  199 */         pstmt.setString(12, getCheckTime());
/*      */       }
/*  201 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  202 */         pstmt.setNull(13, 12);
/*      */       else {
/*  204 */         pstmt.setString(13, getVF01());
/*      */       }
/*  206 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  207 */         pstmt.setNull(14, 12);
/*      */       else {
/*  209 */         pstmt.setString(14, getNF01());
/*      */       }
/*  211 */       pstmt.setInt(15, getIF01());
/*  212 */       pstmt.setDouble(16, getDF02());
/*  213 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  214 */         pstmt.setNull(17, 91);
/*      */       else {
/*  216 */         pstmt.setDate(17, Date.valueOf(getDate01()));
/*      */       }
/*  218 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  219 */         pstmt.setNull(18, 12);
/*      */       else {
/*  221 */         pstmt.setString(18, getModifyOperator());
/*      */       }
/*  223 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  224 */         pstmt.setNull(19, 12);
/*      */       else {
/*  226 */         pstmt.setString(19, getOperator());
/*      */       }
/*  228 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  229 */         pstmt.setNull(20, 91);
/*      */       else {
/*  231 */         pstmt.setDate(20, Date.valueOf(getMakeDate()));
/*      */       }
/*  233 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  234 */         pstmt.setNull(21, 12);
/*      */       else {
/*  236 */         pstmt.setString(21, getMakeTime());
/*      */       }
/*  238 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  239 */         pstmt.setNull(22, 91);
/*      */       else {
/*  241 */         pstmt.setDate(22, Date.valueOf(getModifyDate()));
/*      */       }
/*  243 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  244 */         pstmt.setNull(23, 12);
/*      */       else {
/*  246 */         pstmt.setString(23, getModifyTime());
/*      */       }
/*      */ 
/*  249 */       if ((getID() == null) || (getID().equals("null")))
/*  250 */         pstmt.setNull(24, 12);
/*      */       else {
/*  252 */         pstmt.setString(24, getID());
/*      */       }
/*  254 */       pstmt.executeUpdate();
/*  255 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  258 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  259 */       CError tError = new CError();
/*  260 */       tError.moduleName = "MHomePictureCheckDB";
/*  261 */       tError.functionName = "update()";
/*  262 */       tError.errorMessage = ex.toString();
/*  263 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  266 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  269 */       if (!this.mflag)
/*      */         try {
/*  271 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  275 */       return false;
/*      */     }
/*      */ 
/*  278 */     if (!this.mflag)
/*      */       try {
/*  280 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  284 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  289 */     PreparedStatement pstmt = null;
/*      */ 
/*  291 */     if (!this.mflag) {
/*  292 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  297 */       pstmt = this.con.prepareStatement("INSERT INTO MHomePictureCheck VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  298 */       if ((getID() == null) || (getID().equals("null")))
/*  299 */         pstmt.setNull(1, 12);
/*      */       else {
/*  301 */         pstmt.setString(1, getID());
/*      */       }
/*  303 */       if ((getURL() == null) || (getURL().equals("null")))
/*  304 */         pstmt.setNull(2, 12);
/*      */       else {
/*  306 */         pstmt.setString(2, getURL());
/*      */       }
/*  308 */       if ((getRefURL() == null) || (getRefURL().equals("null")))
/*  309 */         pstmt.setNull(3, 12);
/*      */       else {
/*  311 */         pstmt.setString(3, getRefURL());
/*      */       }
/*  313 */       if ((getName() == null) || (getName().equals("null")))
/*  314 */         pstmt.setNull(4, 12);
/*      */       else {
/*  316 */         pstmt.setString(4, getName());
/*      */       }
/*  318 */       if ((getAlt() == null) || (getAlt().equals("null")))
/*  319 */         pstmt.setNull(5, 12);
/*      */       else {
/*  321 */         pstmt.setString(5, getAlt());
/*      */       }
/*  323 */       pstmt.setInt(6, getPicOrder());
/*  324 */       if ((getDisplayFlag() == null) || (getDisplayFlag().equals("null")))
/*  325 */         pstmt.setNull(7, 12);
/*      */       else {
/*  327 */         pstmt.setString(7, getDisplayFlag());
/*      */       }
/*  329 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  330 */         pstmt.setNull(8, 12);
/*      */       else {
/*  332 */         pstmt.setString(8, getCheckState());
/*      */       }
/*  334 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  335 */         pstmt.setNull(9, 12);
/*      */       else {
/*  337 */         pstmt.setString(9, getCheckOperator());
/*      */       }
/*  339 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  340 */         pstmt.setNull(10, 12);
/*      */       else {
/*  342 */         pstmt.setString(10, getCheckReason());
/*      */       }
/*  344 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  345 */         pstmt.setNull(11, 91);
/*      */       else {
/*  347 */         pstmt.setDate(11, Date.valueOf(getCheckDate()));
/*      */       }
/*  349 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  350 */         pstmt.setNull(12, 12);
/*      */       else {
/*  352 */         pstmt.setString(12, getCheckTime());
/*      */       }
/*  354 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  355 */         pstmt.setNull(13, 12);
/*      */       else {
/*  357 */         pstmt.setString(13, getVF01());
/*      */       }
/*  359 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  360 */         pstmt.setNull(14, 12);
/*      */       else {
/*  362 */         pstmt.setString(14, getNF01());
/*      */       }
/*  364 */       pstmt.setInt(15, getIF01());
/*  365 */       pstmt.setDouble(16, getDF02());
/*  366 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  367 */         pstmt.setNull(17, 91);
/*      */       else {
/*  369 */         pstmt.setDate(17, Date.valueOf(getDate01()));
/*      */       }
/*  371 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  372 */         pstmt.setNull(18, 12);
/*      */       else {
/*  374 */         pstmt.setString(18, getModifyOperator());
/*      */       }
/*  376 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  377 */         pstmt.setNull(19, 12);
/*      */       else {
/*  379 */         pstmt.setString(19, getOperator());
/*      */       }
/*  381 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  382 */         pstmt.setNull(20, 91);
/*      */       else {
/*  384 */         pstmt.setDate(20, Date.valueOf(getMakeDate()));
/*      */       }
/*  386 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  387 */         pstmt.setNull(21, 12);
/*      */       else {
/*  389 */         pstmt.setString(21, getMakeTime());
/*      */       }
/*  391 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  392 */         pstmt.setNull(22, 91);
/*      */       else {
/*  394 */         pstmt.setDate(22, Date.valueOf(getModifyDate()));
/*      */       }
/*  396 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  397 */         pstmt.setNull(23, 12);
/*      */       else {
/*  399 */         pstmt.setString(23, getModifyTime());
/*      */       }
/*      */ 
/*  402 */       pstmt.executeUpdate();
/*  403 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  406 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  407 */       CError tError = new CError();
/*  408 */       tError.moduleName = "MHomePictureCheckDB";
/*  409 */       tError.functionName = "insert()";
/*  410 */       tError.errorMessage = ex.toString();
/*  411 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  414 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  417 */       if (!this.mflag)
/*      */         try {
/*  419 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  423 */       return false;
/*      */     }
/*      */ 
/*  426 */     if (!this.mflag)
/*      */       try {
/*  428 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  432 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  437 */     PreparedStatement pstmt = null;
/*  438 */     ResultSet rs = null;
/*      */ 
/*  440 */     if (!this.mflag) {
/*  441 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  446 */       pstmt = this.con.prepareStatement("SELECT * FROM MHomePictureCheck WHERE  ID = ?", 
/*  447 */         1003, 1007);
/*  448 */       if ((getID() == null) || (getID().equals("null")))
/*  449 */         pstmt.setNull(1, 12);
/*      */       else {
/*  451 */         pstmt.setString(1, getID());
/*      */       }
/*  453 */       rs = pstmt.executeQuery();
/*  454 */       int i = 0;
/*  455 */       if (rs.next())
/*      */       {
/*  457 */         i++;
/*  458 */         if (!setSchema(rs, i))
/*      */         {
/*  461 */           CError tError = new CError();
/*  462 */           tError.moduleName = "MHomePictureCheckDB";
/*  463 */           tError.functionName = "getInfo";
/*  464 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  465 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  467 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  470 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  474 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  478 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  482 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  485 */       if (i == 0)
/*      */       {
/*  487 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  491 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  495 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  501 */       CError tError = new CError();
/*  502 */       tError.moduleName = "MHomePictureCheckDB";
/*  503 */       tError.functionName = "getInfo";
/*  504 */       tError.errorMessage = e.toString();
/*  505 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  507 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  510 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  514 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  518 */       return false;
/*      */     }
/*      */ 
/*  521 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  525 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  530 */     return true;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckSet query()
/*      */   {
/*  535 */     Statement stmt = null;
/*  536 */     ResultSet rs = null;
/*  537 */     MHomePictureCheckSet aMHomePictureCheckSet = new MHomePictureCheckSet();
/*      */ 
/*  539 */     if (!this.mflag) {
/*  540 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  545 */       stmt = this.con.createStatement(1003, 1007);
/*  546 */       SQLString sqlObj = new SQLString("MHomePictureCheck");
/*  547 */       MHomePictureCheckSchema aSchema = getSchema();
/*  548 */       sqlObj.setSQL(5, aSchema);
/*  549 */       String sql = sqlObj.getSQL();
/*      */ 
/*  551 */       rs = stmt.executeQuery(sql);
/*  552 */       int i = 0;
/*  553 */       while (rs.next())
/*      */       {
/*  555 */         i++;
/*  556 */         MHomePictureCheckSchema s1 = new MHomePictureCheckSchema();
/*  557 */         s1.setSchema(rs, i);
/*  558 */         aMHomePictureCheckSet.add(s1);
/*      */       }try {
/*  560 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  566 */       CError tError = new CError();
/*  567 */       tError.moduleName = "MHomePictureCheckDB";
/*  568 */       tError.functionName = "query";
/*  569 */       tError.errorMessage = e.toString();
/*  570 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  572 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  575 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  579 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  585 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  589 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  594 */     return aMHomePictureCheckSet;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckSet executeQuery(String sql)
/*      */   {
/*  599 */     Statement stmt = null;
/*  600 */     ResultSet rs = null;
/*  601 */     MHomePictureCheckSet aMHomePictureCheckSet = new MHomePictureCheckSet();
/*      */ 
/*  603 */     if (!this.mflag) {
/*  604 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  609 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  611 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  612 */       int i = 0;
/*  613 */       while (rs.next())
/*      */       {
/*  615 */         i++;
/*  616 */         MHomePictureCheckSchema s1 = new MHomePictureCheckSchema();
/*  617 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  620 */           CError tError = new CError();
/*  621 */           tError.moduleName = "MHomePictureCheckDB";
/*  622 */           tError.functionName = "executeQuery";
/*  623 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  624 */           this.mErrors.addOneError(tError);
/*      */         }
/*  626 */         aMHomePictureCheckSet.add(s1);
/*      */       }try {
/*  628 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  634 */       CError tError = new CError();
/*  635 */       tError.moduleName = "MHomePictureCheckDB";
/*  636 */       tError.functionName = "executeQuery";
/*  637 */       tError.errorMessage = e.toString();
/*  638 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  640 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  643 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  647 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  653 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  657 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  662 */     return aMHomePictureCheckSet;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckSet query(int nStart, int nCount)
/*      */   {
/*  667 */     Statement stmt = null;
/*  668 */     ResultSet rs = null;
/*  669 */     MHomePictureCheckSet aMHomePictureCheckSet = new MHomePictureCheckSet();
/*      */ 
/*  671 */     if (!this.mflag) {
/*  672 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  677 */       stmt = this.con.createStatement(1003, 1007);
/*  678 */       SQLString sqlObj = new SQLString("MHomePictureCheck");
/*  679 */       MHomePictureCheckSchema aSchema = getSchema();
/*  680 */       sqlObj.setSQL(5, aSchema);
/*  681 */       String sql = sqlObj.getSQL();
/*      */ 
/*  683 */       rs = stmt.executeQuery(sql);
/*  684 */       int i = 0;
/*  685 */       while (rs.next())
/*      */       {
/*  687 */         i++;
/*      */ 
/*  689 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  693 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  697 */         MHomePictureCheckSchema s1 = new MHomePictureCheckSchema();
/*  698 */         s1.setSchema(rs, i);
/*  699 */         aMHomePictureCheckSet.add(s1);
/*      */       }try {
/*  701 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  707 */       CError tError = new CError();
/*  708 */       tError.moduleName = "MHomePictureCheckDB";
/*  709 */       tError.functionName = "query";
/*  710 */       tError.errorMessage = e.toString();
/*  711 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  713 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  716 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  720 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  726 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  730 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  735 */     return aMHomePictureCheckSet;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  740 */     Statement stmt = null;
/*  741 */     ResultSet rs = null;
/*  742 */     MHomePictureCheckSet aMHomePictureCheckSet = new MHomePictureCheckSet();
/*      */ 
/*  744 */     if (!this.mflag) {
/*  745 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  750 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  752 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  753 */       int i = 0;
/*  754 */       while (rs.next())
/*      */       {
/*  756 */         i++;
/*      */ 
/*  758 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  762 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  766 */         MHomePictureCheckSchema s1 = new MHomePictureCheckSchema();
/*  767 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  770 */           CError tError = new CError();
/*  771 */           tError.moduleName = "MHomePictureCheckDB";
/*  772 */           tError.functionName = "executeQuery";
/*  773 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  774 */           this.mErrors.addOneError(tError);
/*      */         }
/*  776 */         aMHomePictureCheckSet.add(s1);
/*      */       }try {
/*  778 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  784 */       CError tError = new CError();
/*  785 */       tError.moduleName = "MHomePictureCheckDB";
/*  786 */       tError.functionName = "executeQuery";
/*  787 */       tError.errorMessage = e.toString();
/*  788 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  790 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  793 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  797 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  803 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  807 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  812 */     return aMHomePictureCheckSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  817 */     Statement stmt = null;
/*      */ 
/*  819 */     if (!this.mflag) {
/*  820 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  825 */       stmt = this.con.createStatement(1003, 1007);
/*  826 */       SQLString sqlObj = new SQLString("MHomePictureCheck");
/*  827 */       MHomePictureCheckSchema aSchema = getSchema();
/*  828 */       sqlObj.setSQL(2, aSchema);
/*  829 */       String sql = "update MHomePictureCheck " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  831 */       int operCount = stmt.executeUpdate(sql);
/*  832 */       if (operCount == 0)
/*      */       {
/*  835 */         CError tError = new CError();
/*  836 */         tError.moduleName = "MHomePictureCheckDB";
/*  837 */         tError.functionName = "update";
/*  838 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  839 */         this.mErrors.addOneError(tError);
/*      */ 
/*  841 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  845 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  849 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  855 */       CError tError = new CError();
/*  856 */       tError.moduleName = "MHomePictureCheckDB";
/*  857 */       tError.functionName = "update";
/*  858 */       tError.errorMessage = e.toString();
/*  859 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  861 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  863 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  867 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  871 */       return false;
/*      */     }
/*      */ 
/*  874 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  878 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  883 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  889 */     if (this.mResultSet != null)
/*      */     {
/*  892 */       CError tError = new CError();
/*  893 */       tError.moduleName = "MHomePictureCheckDB";
/*  894 */       tError.functionName = "prepareData";
/*  895 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  896 */       this.mErrors.addOneError(tError);
/*  897 */       return false;
/*      */     }
/*      */ 
/*  900 */     if (!this.mflag)
/*      */     {
/*  902 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  906 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  907 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  912 */       CError tError = new CError();
/*  913 */       tError.moduleName = "MHomePictureCheckDB";
/*  914 */       tError.functionName = "prepareData";
/*  915 */       tError.errorMessage = e.toString();
/*  916 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  919 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  925 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  929 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  933 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  938 */       return false;
/*      */     }
/*      */ 
/*  941 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  945 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  950 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  956 */     boolean flag = true;
/*  957 */     if (this.mResultSet == null)
/*      */     {
/*  959 */       CError tError = new CError();
/*  960 */       tError.moduleName = "MHomePictureCheckDB";
/*  961 */       tError.functionName = "hasMoreData";
/*  962 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  963 */       this.mErrors.addOneError(tError);
/*  964 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  968 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  972 */       CError tError = new CError();
/*  973 */       tError.moduleName = "MHomePictureCheckDB";
/*  974 */       tError.functionName = "hasMoreData";
/*  975 */       tError.errorMessage = ex.toString();
/*  976 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  979 */         this.mResultSet.close();
/*  980 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  986 */         this.mStatement.close();
/*  987 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  991 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  995 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1000 */       return false;
/*      */     }
/* 1002 */     return flag;
/*      */   }
/*      */ 
/*      */   public MHomePictureCheckSet getData()
/*      */   {
/* 1007 */     int tCount = 0;
/* 1008 */     MHomePictureCheckSet tMHomePictureCheckSet = new MHomePictureCheckSet();
/* 1009 */     MHomePictureCheckSchema tMHomePictureCheckSchema = null;
/* 1010 */     if (this.mResultSet == null)
/*      */     {
/* 1012 */       CError tError = new CError();
/* 1013 */       tError.moduleName = "MHomePictureCheckDB";
/* 1014 */       tError.functionName = "getData";
/* 1015 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1016 */       this.mErrors.addOneError(tError);
/* 1017 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1021 */       tCount = 1;
/* 1022 */       tMHomePictureCheckSchema = new MHomePictureCheckSchema();
/* 1023 */       tMHomePictureCheckSchema.setSchema(this.mResultSet, 1);
/* 1024 */       tMHomePictureCheckSet.add(tMHomePictureCheckSchema);
/*      */ 
/* 1026 */       while (tCount++ < 5000)
/*      */       {
/* 1028 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1030 */         tMHomePictureCheckSchema = new MHomePictureCheckSchema();
/* 1031 */         tMHomePictureCheckSchema.setSchema(this.mResultSet, 1);
/* 1032 */         tMHomePictureCheckSet.add(tMHomePictureCheckSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1038 */       CError tError = new CError();
/* 1039 */       tError.moduleName = "MHomePictureCheckDB";
/* 1040 */       tError.functionName = "getData";
/* 1041 */       tError.errorMessage = ex.toString();
/* 1042 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1045 */         this.mResultSet.close();
/* 1046 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1052 */         this.mStatement.close();
/* 1053 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1057 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1061 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1066 */       return null;
/*      */     }
/* 1068 */     return tMHomePictureCheckSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1073 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1076 */       if (this.mResultSet == null)
/*      */       {
/* 1078 */         CError tError = new CError();
/* 1079 */         tError.moduleName = "MHomePictureCheckDB";
/* 1080 */         tError.functionName = "closeData";
/* 1081 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1082 */         this.mErrors.addOneError(tError);
/* 1083 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1087 */         this.mResultSet.close();
/* 1088 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1093 */       CError tError = new CError();
/* 1094 */       tError.moduleName = "MHomePictureCheckDB";
/* 1095 */       tError.functionName = "closeData";
/* 1096 */       tError.errorMessage = ex2.toString();
/* 1097 */       this.mErrors.addOneError(tError);
/* 1098 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1102 */       if (this.mStatement == null)
/*      */       {
/* 1104 */         CError tError = new CError();
/* 1105 */         tError.moduleName = "MHomePictureCheckDB";
/* 1106 */         tError.functionName = "closeData";
/* 1107 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1108 */         this.mErrors.addOneError(tError);
/* 1109 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1113 */         this.mStatement.close();
/* 1114 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1119 */       CError tError = new CError();
/* 1120 */       tError.moduleName = "MHomePictureCheckDB";
/* 1121 */       tError.functionName = "closeData";
/* 1122 */       tError.errorMessage = ex3.toString();
/* 1123 */       this.mErrors.addOneError(tError);
/* 1124 */       flag = false;
/*      */     }
/* 1126 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MHomePictureCheckDB
 * JD-Core Version:    0.6.0
 */