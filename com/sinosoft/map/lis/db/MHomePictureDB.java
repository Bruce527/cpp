/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MHomePictureSchema;
/*      */ import com.sinosoft.map.lis.vschema.MHomePictureSet;
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
/*      */ public class MHomePictureDB extends MHomePictureSchema
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
/*      */   public MHomePictureDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MHomePicture");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MHomePictureDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MHomePicture");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MHomePictureSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MHomePictureDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MHomePictureSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MHomePictureDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MHomePicture WHERE  ID = ?");
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
/*  107 */       tError.moduleName = "MHomePictureDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MHomePicture SET  ID = ? , URL = ? , RefURL = ? , Name = ? , Alt = ? , PicOrder = ? , DisplayFlag = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Description = ? WHERE  ID = ?");
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
/*  248 */       if ((getDescription() == null) || (getDescription().equals("null")))
/*  249 */         pstmt.setNull(24, 12);
/*      */       else {
/*  251 */         pstmt.setString(24, getDescription());
/*      */       }
/*      */ 
/*  254 */       if ((getID() == null) || (getID().equals("null")))
/*  255 */         pstmt.setNull(25, 12);
/*      */       else {
/*  257 */         pstmt.setString(25, getID());
/*      */       }
/*  259 */       pstmt.executeUpdate();
/*  260 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  263 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  264 */       CError tError = new CError();
/*  265 */       tError.moduleName = "MHomePictureDB";
/*  266 */       tError.functionName = "update()";
/*  267 */       tError.errorMessage = ex.toString();
/*  268 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  271 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  274 */       if (!this.mflag)
/*      */         try {
/*  276 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  280 */       return false;
/*      */     }
/*      */ 
/*  283 */     if (!this.mflag)
/*      */       try {
/*  285 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  289 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  294 */     PreparedStatement pstmt = null;
/*      */ 
/*  296 */     if (!this.mflag) {
/*  297 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  302 */       pstmt = this.con.prepareStatement("INSERT INTO MHomePicture VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  303 */       if ((getID() == null) || (getID().equals("null")))
/*  304 */         pstmt.setNull(1, 12);
/*      */       else {
/*  306 */         pstmt.setString(1, getID());
/*      */       }
/*  308 */       if ((getURL() == null) || (getURL().equals("null")))
/*  309 */         pstmt.setNull(2, 12);
/*      */       else {
/*  311 */         pstmt.setString(2, getURL());
/*      */       }
/*  313 */       if ((getRefURL() == null) || (getRefURL().equals("null")))
/*  314 */         pstmt.setNull(3, 12);
/*      */       else {
/*  316 */         pstmt.setString(3, getRefURL());
/*      */       }
/*  318 */       if ((getName() == null) || (getName().equals("null")))
/*  319 */         pstmt.setNull(4, 12);
/*      */       else {
/*  321 */         pstmt.setString(4, getName());
/*      */       }
/*  323 */       if ((getAlt() == null) || (getAlt().equals("null")))
/*  324 */         pstmt.setNull(5, 12);
/*      */       else {
/*  326 */         pstmt.setString(5, getAlt());
/*      */       }
/*  328 */       pstmt.setInt(6, getPicOrder());
/*  329 */       if ((getDisplayFlag() == null) || (getDisplayFlag().equals("null")))
/*  330 */         pstmt.setNull(7, 12);
/*      */       else {
/*  332 */         pstmt.setString(7, getDisplayFlag());
/*      */       }
/*  334 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  335 */         pstmt.setNull(8, 12);
/*      */       else {
/*  337 */         pstmt.setString(8, getCheckState());
/*      */       }
/*  339 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  340 */         pstmt.setNull(9, 12);
/*      */       else {
/*  342 */         pstmt.setString(9, getCheckOperator());
/*      */       }
/*  344 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  345 */         pstmt.setNull(10, 12);
/*      */       else {
/*  347 */         pstmt.setString(10, getCheckReason());
/*      */       }
/*  349 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  350 */         pstmt.setNull(11, 91);
/*      */       else {
/*  352 */         pstmt.setDate(11, Date.valueOf(getCheckDate()));
/*      */       }
/*  354 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  355 */         pstmt.setNull(12, 12);
/*      */       else {
/*  357 */         pstmt.setString(12, getCheckTime());
/*      */       }
/*  359 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  360 */         pstmt.setNull(13, 12);
/*      */       else {
/*  362 */         pstmt.setString(13, getVF01());
/*      */       }
/*  364 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  365 */         pstmt.setNull(14, 12);
/*      */       else {
/*  367 */         pstmt.setString(14, getNF01());
/*      */       }
/*  369 */       pstmt.setInt(15, getIF01());
/*  370 */       pstmt.setDouble(16, getDF02());
/*  371 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  372 */         pstmt.setNull(17, 91);
/*      */       else {
/*  374 */         pstmt.setDate(17, Date.valueOf(getDate01()));
/*      */       }
/*  376 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  377 */         pstmt.setNull(18, 12);
/*      */       else {
/*  379 */         pstmt.setString(18, getModifyOperator());
/*      */       }
/*  381 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  382 */         pstmt.setNull(19, 12);
/*      */       else {
/*  384 */         pstmt.setString(19, getOperator());
/*      */       }
/*  386 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  387 */         pstmt.setNull(20, 91);
/*      */       else {
/*  389 */         pstmt.setDate(20, Date.valueOf(getMakeDate()));
/*      */       }
/*  391 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  392 */         pstmt.setNull(21, 12);
/*      */       else {
/*  394 */         pstmt.setString(21, getMakeTime());
/*      */       }
/*  396 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  397 */         pstmt.setNull(22, 91);
/*      */       else {
/*  399 */         pstmt.setDate(22, Date.valueOf(getModifyDate()));
/*      */       }
/*  401 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  402 */         pstmt.setNull(23, 12);
/*      */       else {
/*  404 */         pstmt.setString(23, getModifyTime());
/*      */       }
/*  406 */       if ((getDescription() == null) || (getDescription().equals("null")))
/*  407 */         pstmt.setNull(24, 12);
/*      */       else {
/*  409 */         pstmt.setString(24, getDescription());
/*      */       }
/*      */ 
/*  412 */       pstmt.executeUpdate();
/*  413 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  416 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  417 */       CError tError = new CError();
/*  418 */       tError.moduleName = "MHomePictureDB";
/*  419 */       tError.functionName = "insert()";
/*  420 */       tError.errorMessage = ex.toString();
/*  421 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  424 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  427 */       if (!this.mflag)
/*      */         try {
/*  429 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  433 */       return false;
/*      */     }
/*      */ 
/*  436 */     if (!this.mflag)
/*      */       try {
/*  438 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  442 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  447 */     PreparedStatement pstmt = null;
/*  448 */     ResultSet rs = null;
/*      */ 
/*  450 */     if (!this.mflag) {
/*  451 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  456 */       pstmt = this.con.prepareStatement("SELECT * FROM MHomePicture WHERE  ID = ?", 
/*  457 */         1003, 1007);
/*  458 */       if ((getID() == null) || (getID().equals("null")))
/*  459 */         pstmt.setNull(1, 12);
/*      */       else {
/*  461 */         pstmt.setString(1, getID());
/*      */       }
/*  463 */       rs = pstmt.executeQuery();
/*  464 */       int i = 0;
/*  465 */       if (rs.next())
/*      */       {
/*  467 */         i++;
/*  468 */         if (!setSchema(rs, i))
/*      */         {
/*  471 */           CError tError = new CError();
/*  472 */           tError.moduleName = "MHomePictureDB";
/*  473 */           tError.functionName = "getInfo";
/*  474 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  475 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  477 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  480 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  484 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  488 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  492 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  495 */       if (i == 0)
/*      */       {
/*  497 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  501 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  505 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  511 */       CError tError = new CError();
/*  512 */       tError.moduleName = "MHomePictureDB";
/*  513 */       tError.functionName = "getInfo";
/*  514 */       tError.errorMessage = e.toString();
/*  515 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  517 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  520 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  524 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  528 */       return false;
/*      */     }
/*      */ 
/*  531 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  535 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  540 */     return true;
/*      */   }
/*      */ 
/*      */   public MHomePictureSet query()
/*      */   {
/*  545 */     Statement stmt = null;
/*  546 */     ResultSet rs = null;
/*  547 */     MHomePictureSet aMHomePictureSet = new MHomePictureSet();
/*      */ 
/*  549 */     if (!this.mflag) {
/*  550 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  555 */       stmt = this.con.createStatement(1003, 1007);
/*  556 */       SQLString sqlObj = new SQLString("MHomePicture");
/*  557 */       MHomePictureSchema aSchema = getSchema();
/*  558 */       sqlObj.setSQL(5, aSchema);
/*  559 */       String sql = sqlObj.getSQL();
/*      */ 
/*  561 */       rs = stmt.executeQuery(sql);
/*  562 */       int i = 0;
/*  563 */       while (rs.next())
/*      */       {
/*  565 */         i++;
/*  566 */         MHomePictureSchema s1 = new MHomePictureSchema();
/*  567 */         s1.setSchema(rs, i);
/*  568 */         aMHomePictureSet.add(s1);
/*      */       }try {
/*  570 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  576 */       CError tError = new CError();
/*  577 */       tError.moduleName = "MHomePictureDB";
/*  578 */       tError.functionName = "query";
/*  579 */       tError.errorMessage = e.toString();
/*  580 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  582 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  585 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  589 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  595 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  599 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  604 */     return aMHomePictureSet;
/*      */   }
/*      */ 
/*      */   public MHomePictureSet executeQuery(String sql)
/*      */   {
/*  609 */     Statement stmt = null;
/*  610 */     ResultSet rs = null;
/*  611 */     MHomePictureSet aMHomePictureSet = new MHomePictureSet();
/*      */ 
/*  613 */     if (!this.mflag) {
/*  614 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  619 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  621 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  622 */       int i = 0;
/*  623 */       while (rs.next())
/*      */       {
/*  625 */         i++;
/*  626 */         MHomePictureSchema s1 = new MHomePictureSchema();
/*  627 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  630 */           CError tError = new CError();
/*  631 */           tError.moduleName = "MHomePictureDB";
/*  632 */           tError.functionName = "executeQuery";
/*  633 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  634 */           this.mErrors.addOneError(tError);
/*      */         }
/*  636 */         aMHomePictureSet.add(s1);
/*      */       }try {
/*  638 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  644 */       CError tError = new CError();
/*  645 */       tError.moduleName = "MHomePictureDB";
/*  646 */       tError.functionName = "executeQuery";
/*  647 */       tError.errorMessage = e.toString();
/*  648 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  650 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  653 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  657 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  663 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  667 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  672 */     return aMHomePictureSet;
/*      */   }
/*      */ 
/*      */   public MHomePictureSet query(int nStart, int nCount)
/*      */   {
/*  677 */     Statement stmt = null;
/*  678 */     ResultSet rs = null;
/*  679 */     MHomePictureSet aMHomePictureSet = new MHomePictureSet();
/*      */ 
/*  681 */     if (!this.mflag) {
/*  682 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  687 */       stmt = this.con.createStatement(1003, 1007);
/*  688 */       SQLString sqlObj = new SQLString("MHomePicture");
/*  689 */       MHomePictureSchema aSchema = getSchema();
/*  690 */       sqlObj.setSQL(5, aSchema);
/*  691 */       String sql = sqlObj.getSQL();
/*      */ 
/*  693 */       rs = stmt.executeQuery(sql);
/*  694 */       int i = 0;
/*  695 */       while (rs.next())
/*      */       {
/*  697 */         i++;
/*      */ 
/*  699 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  703 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  707 */         MHomePictureSchema s1 = new MHomePictureSchema();
/*  708 */         s1.setSchema(rs, i);
/*  709 */         aMHomePictureSet.add(s1);
/*      */       }try {
/*  711 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  717 */       CError tError = new CError();
/*  718 */       tError.moduleName = "MHomePictureDB";
/*  719 */       tError.functionName = "query";
/*  720 */       tError.errorMessage = e.toString();
/*  721 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  723 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  726 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  730 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  736 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  740 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  745 */     return aMHomePictureSet;
/*      */   }
/*      */ 
/*      */   public MHomePictureSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  750 */     Statement stmt = null;
/*  751 */     ResultSet rs = null;
/*  752 */     MHomePictureSet aMHomePictureSet = new MHomePictureSet();
/*      */ 
/*  754 */     if (!this.mflag) {
/*  755 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  760 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  762 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  763 */       int i = 0;
/*  764 */       while (rs.next())
/*      */       {
/*  766 */         i++;
/*      */ 
/*  768 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  772 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  776 */         MHomePictureSchema s1 = new MHomePictureSchema();
/*  777 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  780 */           CError tError = new CError();
/*  781 */           tError.moduleName = "MHomePictureDB";
/*  782 */           tError.functionName = "executeQuery";
/*  783 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  784 */           this.mErrors.addOneError(tError);
/*      */         }
/*  786 */         aMHomePictureSet.add(s1);
/*      */       }try {
/*  788 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  794 */       CError tError = new CError();
/*  795 */       tError.moduleName = "MHomePictureDB";
/*  796 */       tError.functionName = "executeQuery";
/*  797 */       tError.errorMessage = e.toString();
/*  798 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  800 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  803 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  807 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  813 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  817 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  822 */     return aMHomePictureSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  827 */     Statement stmt = null;
/*      */ 
/*  829 */     if (!this.mflag) {
/*  830 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  835 */       stmt = this.con.createStatement(1003, 1007);
/*  836 */       SQLString sqlObj = new SQLString("MHomePicture");
/*  837 */       MHomePictureSchema aSchema = getSchema();
/*  838 */       sqlObj.setSQL(2, aSchema);
/*  839 */       String sql = "update MHomePicture " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  841 */       int operCount = stmt.executeUpdate(sql);
/*  842 */       if (operCount == 0)
/*      */       {
/*  845 */         CError tError = new CError();
/*  846 */         tError.moduleName = "MHomePictureDB";
/*  847 */         tError.functionName = "update";
/*  848 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  849 */         this.mErrors.addOneError(tError);
/*      */ 
/*  851 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  855 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  859 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  865 */       CError tError = new CError();
/*  866 */       tError.moduleName = "MHomePictureDB";
/*  867 */       tError.functionName = "update";
/*  868 */       tError.errorMessage = e.toString();
/*  869 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  871 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  873 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  877 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  881 */       return false;
/*      */     }
/*      */ 
/*  884 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  888 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  893 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  899 */     if (this.mResultSet != null)
/*      */     {
/*  902 */       CError tError = new CError();
/*  903 */       tError.moduleName = "MHomePictureDB";
/*  904 */       tError.functionName = "prepareData";
/*  905 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  906 */       this.mErrors.addOneError(tError);
/*  907 */       return false;
/*      */     }
/*      */ 
/*  910 */     if (!this.mflag)
/*      */     {
/*  912 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  916 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  917 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  922 */       CError tError = new CError();
/*  923 */       tError.moduleName = "MHomePictureDB";
/*  924 */       tError.functionName = "prepareData";
/*  925 */       tError.errorMessage = e.toString();
/*  926 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  929 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  935 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  939 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  943 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  948 */       return false;
/*      */     }
/*      */ 
/*  951 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  955 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  960 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  966 */     boolean flag = true;
/*  967 */     if (this.mResultSet == null)
/*      */     {
/*  969 */       CError tError = new CError();
/*  970 */       tError.moduleName = "MHomePictureDB";
/*  971 */       tError.functionName = "hasMoreData";
/*  972 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  973 */       this.mErrors.addOneError(tError);
/*  974 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  978 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  982 */       CError tError = new CError();
/*  983 */       tError.moduleName = "MHomePictureDB";
/*  984 */       tError.functionName = "hasMoreData";
/*  985 */       tError.errorMessage = ex.toString();
/*  986 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  989 */         this.mResultSet.close();
/*  990 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  996 */         this.mStatement.close();
/*  997 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1001 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1005 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1010 */       return false;
/*      */     }
/* 1012 */     return flag;
/*      */   }
/*      */ 
/*      */   public MHomePictureSet getData()
/*      */   {
/* 1017 */     int tCount = 0;
/* 1018 */     MHomePictureSet tMHomePictureSet = new MHomePictureSet();
/* 1019 */     MHomePictureSchema tMHomePictureSchema = null;
/* 1020 */     if (this.mResultSet == null)
/*      */     {
/* 1022 */       CError tError = new CError();
/* 1023 */       tError.moduleName = "MHomePictureDB";
/* 1024 */       tError.functionName = "getData";
/* 1025 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1026 */       this.mErrors.addOneError(tError);
/* 1027 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1031 */       tCount = 1;
/* 1032 */       tMHomePictureSchema = new MHomePictureSchema();
/* 1033 */       tMHomePictureSchema.setSchema(this.mResultSet, 1);
/* 1034 */       tMHomePictureSet.add(tMHomePictureSchema);
/*      */ 
/* 1036 */       while (tCount++ < 5000)
/*      */       {
/* 1038 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1040 */         tMHomePictureSchema = new MHomePictureSchema();
/* 1041 */         tMHomePictureSchema.setSchema(this.mResultSet, 1);
/* 1042 */         tMHomePictureSet.add(tMHomePictureSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1048 */       CError tError = new CError();
/* 1049 */       tError.moduleName = "MHomePictureDB";
/* 1050 */       tError.functionName = "getData";
/* 1051 */       tError.errorMessage = ex.toString();
/* 1052 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1055 */         this.mResultSet.close();
/* 1056 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1062 */         this.mStatement.close();
/* 1063 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1067 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1071 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1076 */       return null;
/*      */     }
/* 1078 */     return tMHomePictureSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1083 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1086 */       if (this.mResultSet == null)
/*      */       {
/* 1088 */         CError tError = new CError();
/* 1089 */         tError.moduleName = "MHomePictureDB";
/* 1090 */         tError.functionName = "closeData";
/* 1091 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1092 */         this.mErrors.addOneError(tError);
/* 1093 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1097 */         this.mResultSet.close();
/* 1098 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1103 */       CError tError = new CError();
/* 1104 */       tError.moduleName = "MHomePictureDB";
/* 1105 */       tError.functionName = "closeData";
/* 1106 */       tError.errorMessage = ex2.toString();
/* 1107 */       this.mErrors.addOneError(tError);
/* 1108 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1112 */       if (this.mStatement == null)
/*      */       {
/* 1114 */         CError tError = new CError();
/* 1115 */         tError.moduleName = "MHomePictureDB";
/* 1116 */         tError.functionName = "closeData";
/* 1117 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1118 */         this.mErrors.addOneError(tError);
/* 1119 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1123 */         this.mStatement.close();
/* 1124 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1129 */       CError tError = new CError();
/* 1130 */       tError.moduleName = "MHomePictureDB";
/* 1131 */       tError.functionName = "closeData";
/* 1132 */       tError.errorMessage = ex3.toString();
/* 1133 */       this.mErrors.addOneError(tError);
/* 1134 */       flag = false;
/*      */     }
/* 1136 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MHomePictureDB
 * JD-Core Version:    0.6.0
 */