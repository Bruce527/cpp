/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MInvTopicSchema;
/*      */ import com.sinosoft.map.lis.vschema.MInvTopicSet;
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
/*      */ public class MInvTopicDB extends MInvTopicSchema
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
/*      */   public MInvTopicDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MInvTopic");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MInvTopicDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MInvTopic");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MInvTopicSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MInvTopicDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MInvTopicSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MInvTopicDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MInvTopic WHERE  TopicID = ?");
/*   96 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getTopicID());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MInvTopicDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MInvTopic SET  TopicID = ? , Topic = ? , ManageCom = ? , BranchType = ? , Depiction = ? , Author = ? , Population = ? , StartDate = ? , EndDate = ? , InvType = ? , State = ? , InvState = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  TopicID = ?");
/*  145 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getTopicID());
/*      */       }
/*  150 */       if ((getTopic() == null) || (getTopic().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getTopic());
/*      */       }
/*  155 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  160 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  165 */       if ((getDepiction() == null) || (getDepiction().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getDepiction());
/*      */       }
/*  170 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getAuthor());
/*      */       }
/*  175 */       pstmt.setInt(7, getPopulation());
/*  176 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  177 */         pstmt.setNull(8, 91);
/*      */       else {
/*  179 */         pstmt.setDate(8, Date.valueOf(getStartDate()));
/*      */       }
/*  181 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  182 */         pstmt.setNull(9, 91);
/*      */       else {
/*  184 */         pstmt.setDate(9, Date.valueOf(getEndDate()));
/*      */       }
/*  186 */       if ((getInvType() == null) || (getInvType().equals("null")))
/*  187 */         pstmt.setNull(10, 12);
/*      */       else {
/*  189 */         pstmt.setString(10, getInvType());
/*      */       }
/*  191 */       if ((getState() == null) || (getState().equals("null")))
/*  192 */         pstmt.setNull(11, 12);
/*      */       else {
/*  194 */         pstmt.setString(11, getState());
/*      */       }
/*  196 */       if ((getInvState() == null) || (getInvState().equals("null")))
/*  197 */         pstmt.setNull(12, 12);
/*      */       else {
/*  199 */         pstmt.setString(12, getInvState());
/*      */       }
/*  201 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  202 */         pstmt.setNull(13, 12);
/*      */       else {
/*  204 */         pstmt.setString(13, getCheckState());
/*      */       }
/*  206 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  207 */         pstmt.setNull(14, 12);
/*      */       else {
/*  209 */         pstmt.setString(14, getCheckOperator());
/*      */       }
/*  211 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  212 */         pstmt.setNull(15, 12);
/*      */       else {
/*  214 */         pstmt.setString(15, getCheckReason());
/*      */       }
/*  216 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  217 */         pstmt.setNull(16, 91);
/*      */       else {
/*  219 */         pstmt.setDate(16, Date.valueOf(getCheckDate()));
/*      */       }
/*  221 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  222 */         pstmt.setNull(17, 12);
/*      */       else {
/*  224 */         pstmt.setString(17, getCheckTime());
/*      */       }
/*  226 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  227 */         pstmt.setNull(18, 12);
/*      */       else {
/*  229 */         pstmt.setString(18, getVF01());
/*      */       }
/*  231 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  232 */         pstmt.setNull(19, 12);
/*      */       else {
/*  234 */         pstmt.setString(19, getNF01());
/*      */       }
/*  236 */       pstmt.setInt(20, getIF01());
/*  237 */       pstmt.setDouble(21, getDF02());
/*  238 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  239 */         pstmt.setNull(22, 91);
/*      */       else {
/*  241 */         pstmt.setDate(22, Date.valueOf(getDate01()));
/*      */       }
/*  243 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  244 */         pstmt.setNull(23, 12);
/*      */       else {
/*  246 */         pstmt.setString(23, getModifyOperator());
/*      */       }
/*  248 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  249 */         pstmt.setNull(24, 12);
/*      */       else {
/*  251 */         pstmt.setString(24, getOperator());
/*      */       }
/*  253 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  254 */         pstmt.setNull(25, 91);
/*      */       else {
/*  256 */         pstmt.setDate(25, Date.valueOf(getMakeDate()));
/*      */       }
/*  258 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  259 */         pstmt.setNull(26, 12);
/*      */       else {
/*  261 */         pstmt.setString(26, getMakeTime());
/*      */       }
/*  263 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  264 */         pstmt.setNull(27, 91);
/*      */       else {
/*  266 */         pstmt.setDate(27, Date.valueOf(getModifyDate()));
/*      */       }
/*  268 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  269 */         pstmt.setNull(28, 12);
/*      */       else {
/*  271 */         pstmt.setString(28, getModifyTime());
/*      */       }
/*      */ 
/*  274 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  275 */         pstmt.setNull(29, 12);
/*      */       else {
/*  277 */         pstmt.setString(29, getTopicID());
/*      */       }
/*  279 */       pstmt.executeUpdate();
/*  280 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  283 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  284 */       CError tError = new CError();
/*  285 */       tError.moduleName = "MInvTopicDB";
/*  286 */       tError.functionName = "update()";
/*  287 */       tError.errorMessage = ex.toString();
/*  288 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  291 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  294 */       if (!this.mflag)
/*      */         try {
/*  296 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  300 */       return false;
/*      */     }
/*      */ 
/*  303 */     if (!this.mflag)
/*      */       try {
/*  305 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  309 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  314 */     PreparedStatement pstmt = null;
/*      */ 
/*  316 */     if (!this.mflag) {
/*  317 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  322 */       pstmt = this.con.prepareStatement("INSERT INTO MInvTopic VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  323 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  324 */         pstmt.setNull(1, 12);
/*      */       else {
/*  326 */         pstmt.setString(1, getTopicID());
/*      */       }
/*  328 */       if ((getTopic() == null) || (getTopic().equals("null")))
/*  329 */         pstmt.setNull(2, 12);
/*      */       else {
/*  331 */         pstmt.setString(2, getTopic());
/*      */       }
/*  333 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  334 */         pstmt.setNull(3, 12);
/*      */       else {
/*  336 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  338 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  339 */         pstmt.setNull(4, 12);
/*      */       else {
/*  341 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  343 */       if ((getDepiction() == null) || (getDepiction().equals("null")))
/*  344 */         pstmt.setNull(5, 12);
/*      */       else {
/*  346 */         pstmt.setString(5, getDepiction());
/*      */       }
/*  348 */       if ((getAuthor() == null) || (getAuthor().equals("null")))
/*  349 */         pstmt.setNull(6, 12);
/*      */       else {
/*  351 */         pstmt.setString(6, getAuthor());
/*      */       }
/*  353 */       pstmt.setInt(7, getPopulation());
/*  354 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  355 */         pstmt.setNull(8, 91);
/*      */       else {
/*  357 */         pstmt.setDate(8, Date.valueOf(getStartDate()));
/*      */       }
/*  359 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  360 */         pstmt.setNull(9, 91);
/*      */       else {
/*  362 */         pstmt.setDate(9, Date.valueOf(getEndDate()));
/*      */       }
/*  364 */       if ((getInvType() == null) || (getInvType().equals("null")))
/*  365 */         pstmt.setNull(10, 12);
/*      */       else {
/*  367 */         pstmt.setString(10, getInvType());
/*      */       }
/*  369 */       if ((getState() == null) || (getState().equals("null")))
/*  370 */         pstmt.setNull(11, 12);
/*      */       else {
/*  372 */         pstmt.setString(11, getState());
/*      */       }
/*  374 */       if ((getInvState() == null) || (getInvState().equals("null")))
/*  375 */         pstmt.setNull(12, 12);
/*      */       else {
/*  377 */         pstmt.setString(12, getInvState());
/*      */       }
/*  379 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  380 */         pstmt.setNull(13, 12);
/*      */       else {
/*  382 */         pstmt.setString(13, getCheckState());
/*      */       }
/*  384 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  385 */         pstmt.setNull(14, 12);
/*      */       else {
/*  387 */         pstmt.setString(14, getCheckOperator());
/*      */       }
/*  389 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  390 */         pstmt.setNull(15, 12);
/*      */       else {
/*  392 */         pstmt.setString(15, getCheckReason());
/*      */       }
/*  394 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  395 */         pstmt.setNull(16, 91);
/*      */       else {
/*  397 */         pstmt.setDate(16, Date.valueOf(getCheckDate()));
/*      */       }
/*  399 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  400 */         pstmt.setNull(17, 12);
/*      */       else {
/*  402 */         pstmt.setString(17, getCheckTime());
/*      */       }
/*  404 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  405 */         pstmt.setNull(18, 12);
/*      */       else {
/*  407 */         pstmt.setString(18, getVF01());
/*      */       }
/*  409 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  410 */         pstmt.setNull(19, 12);
/*      */       else {
/*  412 */         pstmt.setString(19, getNF01());
/*      */       }
/*  414 */       pstmt.setInt(20, getIF01());
/*  415 */       pstmt.setDouble(21, getDF02());
/*  416 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  417 */         pstmt.setNull(22, 91);
/*      */       else {
/*  419 */         pstmt.setDate(22, Date.valueOf(getDate01()));
/*      */       }
/*  421 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  422 */         pstmt.setNull(23, 12);
/*      */       else {
/*  424 */         pstmt.setString(23, getModifyOperator());
/*      */       }
/*  426 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  427 */         pstmt.setNull(24, 12);
/*      */       else {
/*  429 */         pstmt.setString(24, getOperator());
/*      */       }
/*  431 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  432 */         pstmt.setNull(25, 91);
/*      */       else {
/*  434 */         pstmt.setDate(25, Date.valueOf(getMakeDate()));
/*      */       }
/*  436 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  437 */         pstmt.setNull(26, 12);
/*      */       else {
/*  439 */         pstmt.setString(26, getMakeTime());
/*      */       }
/*  441 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  442 */         pstmt.setNull(27, 91);
/*      */       else {
/*  444 */         pstmt.setDate(27, Date.valueOf(getModifyDate()));
/*      */       }
/*  446 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  447 */         pstmt.setNull(28, 12);
/*      */       else {
/*  449 */         pstmt.setString(28, getModifyTime());
/*      */       }
/*      */ 
/*  452 */       pstmt.executeUpdate();
/*  453 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  456 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  457 */       CError tError = new CError();
/*  458 */       tError.moduleName = "MInvTopicDB";
/*  459 */       tError.functionName = "insert()";
/*  460 */       tError.errorMessage = ex.toString();
/*  461 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  464 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  467 */       if (!this.mflag)
/*      */         try {
/*  469 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  473 */       return false;
/*      */     }
/*      */ 
/*  476 */     if (!this.mflag)
/*      */       try {
/*  478 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  482 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  487 */     PreparedStatement pstmt = null;
/*  488 */     ResultSet rs = null;
/*      */ 
/*  490 */     if (!this.mflag) {
/*  491 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  496 */       pstmt = this.con.prepareStatement("SELECT * FROM MInvTopic WHERE  TopicID = ?", 
/*  497 */         1003, 1007);
/*  498 */       if ((getTopicID() == null) || (getTopicID().equals("null")))
/*  499 */         pstmt.setNull(1, 12);
/*      */       else {
/*  501 */         pstmt.setString(1, getTopicID());
/*      */       }
/*  503 */       rs = pstmt.executeQuery();
/*  504 */       int i = 0;
/*  505 */       if (rs.next())
/*      */       {
/*  507 */         i++;
/*  508 */         if (!setSchema(rs, i))
/*      */         {
/*  511 */           CError tError = new CError();
/*  512 */           tError.moduleName = "MInvTopicDB";
/*  513 */           tError.functionName = "getInfo";
/*  514 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  515 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  517 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  520 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  524 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  528 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  532 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  535 */       if (i == 0)
/*      */       {
/*  537 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  541 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  545 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  551 */       CError tError = new CError();
/*  552 */       tError.moduleName = "MInvTopicDB";
/*  553 */       tError.functionName = "getInfo";
/*  554 */       tError.errorMessage = e.toString();
/*  555 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  557 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  560 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  564 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  568 */       return false;
/*      */     }
/*      */ 
/*  571 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  575 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  580 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvTopicSet query()
/*      */   {
/*  585 */     Statement stmt = null;
/*  586 */     ResultSet rs = null;
/*  587 */     MInvTopicSet aMInvTopicSet = new MInvTopicSet();
/*      */ 
/*  589 */     if (!this.mflag) {
/*  590 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  595 */       stmt = this.con.createStatement(1003, 1007);
/*  596 */       SQLString sqlObj = new SQLString("MInvTopic");
/*  597 */       MInvTopicSchema aSchema = getSchema();
/*  598 */       sqlObj.setSQL(5, aSchema);
/*  599 */       String sql = sqlObj.getSQL();
/*      */ 
/*  601 */       rs = stmt.executeQuery(sql);
/*  602 */       int i = 0;
/*  603 */       while (rs.next())
/*      */       {
/*  605 */         i++;
/*  606 */         MInvTopicSchema s1 = new MInvTopicSchema();
/*  607 */         s1.setSchema(rs, i);
/*  608 */         aMInvTopicSet.add(s1);
/*      */       }try {
/*  610 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  616 */       CError tError = new CError();
/*  617 */       tError.moduleName = "MInvTopicDB";
/*  618 */       tError.functionName = "query";
/*  619 */       tError.errorMessage = e.toString();
/*  620 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  622 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  625 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  629 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  635 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  639 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  644 */     return aMInvTopicSet;
/*      */   }
/*      */ 
/*      */   public MInvTopicSet executeQuery(String sql)
/*      */   {
/*  649 */     Statement stmt = null;
/*  650 */     ResultSet rs = null;
/*  651 */     MInvTopicSet aMInvTopicSet = new MInvTopicSet();
/*      */ 
/*  653 */     if (!this.mflag) {
/*  654 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  659 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  661 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  662 */       int i = 0;
/*  663 */       while (rs.next())
/*      */       {
/*  665 */         i++;
/*  666 */         MInvTopicSchema s1 = new MInvTopicSchema();
/*  667 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  670 */           CError tError = new CError();
/*  671 */           tError.moduleName = "MInvTopicDB";
/*  672 */           tError.functionName = "executeQuery";
/*  673 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  674 */           this.mErrors.addOneError(tError);
/*      */         }
/*  676 */         aMInvTopicSet.add(s1);
/*      */       }try {
/*  678 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  684 */       CError tError = new CError();
/*  685 */       tError.moduleName = "MInvTopicDB";
/*  686 */       tError.functionName = "executeQuery";
/*  687 */       tError.errorMessage = e.toString();
/*  688 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  690 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  693 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  697 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  703 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  707 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  712 */     return aMInvTopicSet;
/*      */   }
/*      */ 
/*      */   public MInvTopicSet query(int nStart, int nCount)
/*      */   {
/*  717 */     Statement stmt = null;
/*  718 */     ResultSet rs = null;
/*  719 */     MInvTopicSet aMInvTopicSet = new MInvTopicSet();
/*      */ 
/*  721 */     if (!this.mflag) {
/*  722 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  727 */       stmt = this.con.createStatement(1003, 1007);
/*  728 */       SQLString sqlObj = new SQLString("MInvTopic");
/*  729 */       MInvTopicSchema aSchema = getSchema();
/*  730 */       sqlObj.setSQL(5, aSchema);
/*  731 */       String sql = sqlObj.getSQL();
/*      */ 
/*  733 */       rs = stmt.executeQuery(sql);
/*  734 */       int i = 0;
/*  735 */       while (rs.next())
/*      */       {
/*  737 */         i++;
/*      */ 
/*  739 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  743 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  747 */         MInvTopicSchema s1 = new MInvTopicSchema();
/*  748 */         s1.setSchema(rs, i);
/*  749 */         aMInvTopicSet.add(s1);
/*      */       }try {
/*  751 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  757 */       CError tError = new CError();
/*  758 */       tError.moduleName = "MInvTopicDB";
/*  759 */       tError.functionName = "query";
/*  760 */       tError.errorMessage = e.toString();
/*  761 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  763 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  766 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  770 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  776 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  780 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  785 */     return aMInvTopicSet;
/*      */   }
/*      */ 
/*      */   public MInvTopicSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  790 */     Statement stmt = null;
/*  791 */     ResultSet rs = null;
/*  792 */     MInvTopicSet aMInvTopicSet = new MInvTopicSet();
/*      */ 
/*  794 */     if (!this.mflag) {
/*  795 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  800 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  802 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
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
/*  816 */         MInvTopicSchema s1 = new MInvTopicSchema();
/*  817 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  820 */           CError tError = new CError();
/*  821 */           tError.moduleName = "MInvTopicDB";
/*  822 */           tError.functionName = "executeQuery";
/*  823 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  824 */           this.mErrors.addOneError(tError);
/*      */         }
/*  826 */         aMInvTopicSet.add(s1);
/*      */       }try {
/*  828 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  834 */       CError tError = new CError();
/*  835 */       tError.moduleName = "MInvTopicDB";
/*  836 */       tError.functionName = "executeQuery";
/*  837 */       tError.errorMessage = e.toString();
/*  838 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  840 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  843 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  847 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  853 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  857 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  862 */     return aMInvTopicSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  867 */     Statement stmt = null;
/*      */ 
/*  869 */     if (!this.mflag) {
/*  870 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  875 */       stmt = this.con.createStatement(1003, 1007);
/*  876 */       SQLString sqlObj = new SQLString("MInvTopic");
/*  877 */       MInvTopicSchema aSchema = getSchema();
/*  878 */       sqlObj.setSQL(2, aSchema);
/*  879 */       String sql = "update MInvTopic " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  881 */       int operCount = stmt.executeUpdate(sql);
/*  882 */       if (operCount == 0)
/*      */       {
/*  885 */         CError tError = new CError();
/*  886 */         tError.moduleName = "MInvTopicDB";
/*  887 */         tError.functionName = "update";
/*  888 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  889 */         this.mErrors.addOneError(tError);
/*      */ 
/*  891 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  895 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  899 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  905 */       CError tError = new CError();
/*  906 */       tError.moduleName = "MInvTopicDB";
/*  907 */       tError.functionName = "update";
/*  908 */       tError.errorMessage = e.toString();
/*  909 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  911 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  913 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  917 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  921 */       return false;
/*      */     }
/*      */ 
/*  924 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  928 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  933 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  939 */     if (this.mResultSet != null)
/*      */     {
/*  942 */       CError tError = new CError();
/*  943 */       tError.moduleName = "MInvTopicDB";
/*  944 */       tError.functionName = "prepareData";
/*  945 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  946 */       this.mErrors.addOneError(tError);
/*  947 */       return false;
/*      */     }
/*      */ 
/*  950 */     if (!this.mflag)
/*      */     {
/*  952 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  956 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  957 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  962 */       CError tError = new CError();
/*  963 */       tError.moduleName = "MInvTopicDB";
/*  964 */       tError.functionName = "prepareData";
/*  965 */       tError.errorMessage = e.toString();
/*  966 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  969 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  975 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  979 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  983 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  988 */       return false;
/*      */     }
/*      */ 
/*  991 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  995 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1000 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1006 */     boolean flag = true;
/* 1007 */     if (this.mResultSet == null)
/*      */     {
/* 1009 */       CError tError = new CError();
/* 1010 */       tError.moduleName = "MInvTopicDB";
/* 1011 */       tError.functionName = "hasMoreData";
/* 1012 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1013 */       this.mErrors.addOneError(tError);
/* 1014 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1018 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1022 */       CError tError = new CError();
/* 1023 */       tError.moduleName = "MInvTopicDB";
/* 1024 */       tError.functionName = "hasMoreData";
/* 1025 */       tError.errorMessage = ex.toString();
/* 1026 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1029 */         this.mResultSet.close();
/* 1030 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1036 */         this.mStatement.close();
/* 1037 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1041 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1045 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1050 */       return false;
/*      */     }
/* 1052 */     return flag;
/*      */   }
/*      */ 
/*      */   public MInvTopicSet getData()
/*      */   {
/* 1057 */     int tCount = 0;
/* 1058 */     MInvTopicSet tMInvTopicSet = new MInvTopicSet();
/* 1059 */     MInvTopicSchema tMInvTopicSchema = null;
/* 1060 */     if (this.mResultSet == null)
/*      */     {
/* 1062 */       CError tError = new CError();
/* 1063 */       tError.moduleName = "MInvTopicDB";
/* 1064 */       tError.functionName = "getData";
/* 1065 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1066 */       this.mErrors.addOneError(tError);
/* 1067 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1071 */       tCount = 1;
/* 1072 */       tMInvTopicSchema = new MInvTopicSchema();
/* 1073 */       tMInvTopicSchema.setSchema(this.mResultSet, 1);
/* 1074 */       tMInvTopicSet.add(tMInvTopicSchema);
/*      */ 
/* 1076 */       while (tCount++ < 5000)
/*      */       {
/* 1078 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1080 */         tMInvTopicSchema = new MInvTopicSchema();
/* 1081 */         tMInvTopicSchema.setSchema(this.mResultSet, 1);
/* 1082 */         tMInvTopicSet.add(tMInvTopicSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1088 */       CError tError = new CError();
/* 1089 */       tError.moduleName = "MInvTopicDB";
/* 1090 */       tError.functionName = "getData";
/* 1091 */       tError.errorMessage = ex.toString();
/* 1092 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1095 */         this.mResultSet.close();
/* 1096 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1102 */         this.mStatement.close();
/* 1103 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1107 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1111 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1116 */       return null;
/*      */     }
/* 1118 */     return tMInvTopicSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1123 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1126 */       if (this.mResultSet == null)
/*      */       {
/* 1128 */         CError tError = new CError();
/* 1129 */         tError.moduleName = "MInvTopicDB";
/* 1130 */         tError.functionName = "closeData";
/* 1131 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1132 */         this.mErrors.addOneError(tError);
/* 1133 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1137 */         this.mResultSet.close();
/* 1138 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1143 */       CError tError = new CError();
/* 1144 */       tError.moduleName = "MInvTopicDB";
/* 1145 */       tError.functionName = "closeData";
/* 1146 */       tError.errorMessage = ex2.toString();
/* 1147 */       this.mErrors.addOneError(tError);
/* 1148 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1152 */       if (this.mStatement == null)
/*      */       {
/* 1154 */         CError tError = new CError();
/* 1155 */         tError.moduleName = "MInvTopicDB";
/* 1156 */         tError.functionName = "closeData";
/* 1157 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1158 */         this.mErrors.addOneError(tError);
/* 1159 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1163 */         this.mStatement.close();
/* 1164 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1169 */       CError tError = new CError();
/* 1170 */       tError.moduleName = "MInvTopicDB";
/* 1171 */       tError.functionName = "closeData";
/* 1172 */       tError.errorMessage = ex3.toString();
/* 1173 */       this.mErrors.addOneError(tError);
/* 1174 */       flag = false;
/*      */     }
/* 1176 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MInvTopicDB
 * JD-Core Version:    0.6.0
 */