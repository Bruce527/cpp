/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPAgentImpResultSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAgentImpResultSet;
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
/*      */ public class LNPAgentImpResultDB extends LNPAgentImpResultSchema
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
/*      */   public LNPAgentImpResultDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPAgentImpResult");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpResultDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPAgentImpResult");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPAgentImpResultSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPAgentImpResultDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPAgentImpResultSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPAgentImpResultDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAgentImpResult WHERE  ResultId = ? AND Grouporder = ?");
/*   97 */       if ((getResultId() == null) || (getResultId().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getResultId());
/*      */       }
/*  102 */       if ((getGrouporder() == null) || (getGrouporder().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getGrouporder());
/*      */       }
/*  107 */       pstmt.executeUpdate();
/*  108 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  111 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  112 */       CError tError = new CError();
/*  113 */       tError.moduleName = "LNPAgentImpResultDB";
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
/*  150 */       pstmt = this.con.prepareStatement("UPDATE LNPAgentImpResult SET  ResultId = ? , GrpContNo = ? , ContNo = ? , ProposalContNo = ? , ImpartId = ? , Grouporder = ? , QID01 = ? , A01 = ? , QID02 = ? , A02 = ? , QID03 = ? , A03 = ? , QID04 = ? , A04 = ? , QID05 = ? , A05 = ? , QID06 = ? , A06 = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultId = ? AND Grouporder = ?");
/*  151 */       if ((getResultId() == null) || (getResultId().equals("null")))
/*  152 */         pstmt.setNull(1, 12);
/*      */       else {
/*  154 */         pstmt.setString(1, getResultId());
/*      */       }
/*  156 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  157 */         pstmt.setNull(2, 12);
/*      */       else {
/*  159 */         pstmt.setString(2, getGrpContNo());
/*      */       }
/*  161 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  162 */         pstmt.setNull(3, 12);
/*      */       else {
/*  164 */         pstmt.setString(3, getContNo());
/*      */       }
/*  166 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  167 */         pstmt.setNull(4, 12);
/*      */       else {
/*  169 */         pstmt.setString(4, getProposalContNo());
/*      */       }
/*  171 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  172 */         pstmt.setNull(5, 12);
/*      */       else {
/*  174 */         pstmt.setString(5, getImpartId());
/*      */       }
/*  176 */       if ((getGrouporder() == null) || (getGrouporder().equals("null")))
/*  177 */         pstmt.setNull(6, 12);
/*      */       else {
/*  179 */         pstmt.setString(6, getGrouporder());
/*      */       }
/*  181 */       if ((getQID01() == null) || (getQID01().equals("null")))
/*  182 */         pstmt.setNull(7, 12);
/*      */       else {
/*  184 */         pstmt.setString(7, getQID01());
/*      */       }
/*  186 */       if ((getA01() == null) || (getA01().equals("null")))
/*  187 */         pstmt.setNull(8, 12);
/*      */       else {
/*  189 */         pstmt.setString(8, getA01());
/*      */       }
/*  191 */       if ((getQID02() == null) || (getQID02().equals("null")))
/*  192 */         pstmt.setNull(9, 12);
/*      */       else {
/*  194 */         pstmt.setString(9, getQID02());
/*      */       }
/*  196 */       if ((getA02() == null) || (getA02().equals("null")))
/*  197 */         pstmt.setNull(10, 12);
/*      */       else {
/*  199 */         pstmt.setString(10, getA02());
/*      */       }
/*  201 */       if ((getQID03() == null) || (getQID03().equals("null")))
/*  202 */         pstmt.setNull(11, 12);
/*      */       else {
/*  204 */         pstmt.setString(11, getQID03());
/*      */       }
/*  206 */       if ((getA03() == null) || (getA03().equals("null")))
/*  207 */         pstmt.setNull(12, 12);
/*      */       else {
/*  209 */         pstmt.setString(12, getA03());
/*      */       }
/*  211 */       if ((getQID04() == null) || (getQID04().equals("null")))
/*  212 */         pstmt.setNull(13, 12);
/*      */       else {
/*  214 */         pstmt.setString(13, getQID04());
/*      */       }
/*  216 */       if ((getA04() == null) || (getA04().equals("null")))
/*  217 */         pstmt.setNull(14, 12);
/*      */       else {
/*  219 */         pstmt.setString(14, getA04());
/*      */       }
/*  221 */       if ((getQID05() == null) || (getQID05().equals("null")))
/*  222 */         pstmt.setNull(15, 12);
/*      */       else {
/*  224 */         pstmt.setString(15, getQID05());
/*      */       }
/*  226 */       if ((getA05() == null) || (getA05().equals("null")))
/*  227 */         pstmt.setNull(16, 12);
/*      */       else {
/*  229 */         pstmt.setString(16, getA05());
/*      */       }
/*  231 */       if ((getQID06() == null) || (getQID06().equals("null")))
/*  232 */         pstmt.setNull(17, 12);
/*      */       else {
/*  234 */         pstmt.setString(17, getQID06());
/*      */       }
/*  236 */       if ((getA06() == null) || (getA06().equals("null")))
/*  237 */         pstmt.setNull(18, 12);
/*      */       else {
/*  239 */         pstmt.setString(18, getA06());
/*      */       }
/*  241 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  242 */         pstmt.setNull(19, 12);
/*      */       else {
/*  244 */         pstmt.setString(19, getOperator());
/*      */       }
/*  246 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  247 */         pstmt.setNull(20, 12);
/*      */       else {
/*  249 */         pstmt.setString(20, getManageCom());
/*      */       }
/*  251 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  252 */         pstmt.setNull(21, 91);
/*      */       else {
/*  254 */         pstmt.setDate(21, Date.valueOf(getMakeDate()));
/*      */       }
/*  256 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  257 */         pstmt.setNull(22, 12);
/*      */       else {
/*  259 */         pstmt.setString(22, getMakeTime());
/*      */       }
/*  261 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  262 */         pstmt.setNull(23, 91);
/*      */       else {
/*  264 */         pstmt.setDate(23, Date.valueOf(getModifyDate()));
/*      */       }
/*  266 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  267 */         pstmt.setNull(24, 12);
/*      */       else {
/*  269 */         pstmt.setString(24, getModifyTime());
/*      */       }
/*      */ 
/*  272 */       if ((getResultId() == null) || (getResultId().equals("null")))
/*  273 */         pstmt.setNull(25, 12);
/*      */       else {
/*  275 */         pstmt.setString(25, getResultId());
/*      */       }
/*  277 */       if ((getGrouporder() == null) || (getGrouporder().equals("null")))
/*  278 */         pstmt.setNull(26, 12);
/*      */       else {
/*  280 */         pstmt.setString(26, getGrouporder());
/*      */       }
/*  282 */       pstmt.executeUpdate();
/*  283 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  286 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  287 */       CError tError = new CError();
/*  288 */       tError.moduleName = "LNPAgentImpResultDB";
/*  289 */       tError.functionName = "update()";
/*  290 */       tError.errorMessage = ex.toString();
/*  291 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  294 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  297 */       if (!this.mflag)
/*      */         try {
/*  299 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  303 */       return false;
/*      */     }
/*      */ 
/*  306 */     if (!this.mflag)
/*      */       try {
/*  308 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  312 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  317 */     PreparedStatement pstmt = null;
/*      */ 
/*  319 */     if (!this.mflag) {
/*  320 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  325 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAgentImpResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  326 */       if ((getResultId() == null) || (getResultId().equals("null")))
/*  327 */         pstmt.setNull(1, 12);
/*      */       else {
/*  329 */         pstmt.setString(1, getResultId());
/*      */       }
/*  331 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  332 */         pstmt.setNull(2, 12);
/*      */       else {
/*  334 */         pstmt.setString(2, getGrpContNo());
/*      */       }
/*  336 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  337 */         pstmt.setNull(3, 12);
/*      */       else {
/*  339 */         pstmt.setString(3, getContNo());
/*      */       }
/*  341 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  342 */         pstmt.setNull(4, 12);
/*      */       else {
/*  344 */         pstmt.setString(4, getProposalContNo());
/*      */       }
/*  346 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  347 */         pstmt.setNull(5, 12);
/*      */       else {
/*  349 */         pstmt.setString(5, getImpartId());
/*      */       }
/*  351 */       if ((getGrouporder() == null) || (getGrouporder().equals("null")))
/*  352 */         pstmt.setNull(6, 12);
/*      */       else {
/*  354 */         pstmt.setString(6, getGrouporder());
/*      */       }
/*  356 */       if ((getQID01() == null) || (getQID01().equals("null")))
/*  357 */         pstmt.setNull(7, 12);
/*      */       else {
/*  359 */         pstmt.setString(7, getQID01());
/*      */       }
/*  361 */       if ((getA01() == null) || (getA01().equals("null")))
/*  362 */         pstmt.setNull(8, 12);
/*      */       else {
/*  364 */         pstmt.setString(8, getA01());
/*      */       }
/*  366 */       if ((getQID02() == null) || (getQID02().equals("null")))
/*  367 */         pstmt.setNull(9, 12);
/*      */       else {
/*  369 */         pstmt.setString(9, getQID02());
/*      */       }
/*  371 */       if ((getA02() == null) || (getA02().equals("null")))
/*  372 */         pstmt.setNull(10, 12);
/*      */       else {
/*  374 */         pstmt.setString(10, getA02());
/*      */       }
/*  376 */       if ((getQID03() == null) || (getQID03().equals("null")))
/*  377 */         pstmt.setNull(11, 12);
/*      */       else {
/*  379 */         pstmt.setString(11, getQID03());
/*      */       }
/*  381 */       if ((getA03() == null) || (getA03().equals("null")))
/*  382 */         pstmt.setNull(12, 12);
/*      */       else {
/*  384 */         pstmt.setString(12, getA03());
/*      */       }
/*  386 */       if ((getQID04() == null) || (getQID04().equals("null")))
/*  387 */         pstmt.setNull(13, 12);
/*      */       else {
/*  389 */         pstmt.setString(13, getQID04());
/*      */       }
/*  391 */       if ((getA04() == null) || (getA04().equals("null")))
/*  392 */         pstmt.setNull(14, 12);
/*      */       else {
/*  394 */         pstmt.setString(14, getA04());
/*      */       }
/*  396 */       if ((getQID05() == null) || (getQID05().equals("null")))
/*  397 */         pstmt.setNull(15, 12);
/*      */       else {
/*  399 */         pstmt.setString(15, getQID05());
/*      */       }
/*  401 */       if ((getA05() == null) || (getA05().equals("null")))
/*  402 */         pstmt.setNull(16, 12);
/*      */       else {
/*  404 */         pstmt.setString(16, getA05());
/*      */       }
/*  406 */       if ((getQID06() == null) || (getQID06().equals("null")))
/*  407 */         pstmt.setNull(17, 12);
/*      */       else {
/*  409 */         pstmt.setString(17, getQID06());
/*      */       }
/*  411 */       if ((getA06() == null) || (getA06().equals("null")))
/*  412 */         pstmt.setNull(18, 12);
/*      */       else {
/*  414 */         pstmt.setString(18, getA06());
/*      */       }
/*  416 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  417 */         pstmt.setNull(19, 12);
/*      */       else {
/*  419 */         pstmt.setString(19, getOperator());
/*      */       }
/*  421 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  422 */         pstmt.setNull(20, 12);
/*      */       else {
/*  424 */         pstmt.setString(20, getManageCom());
/*      */       }
/*  426 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  427 */         pstmt.setNull(21, 91);
/*      */       else {
/*  429 */         pstmt.setDate(21, Date.valueOf(getMakeDate()));
/*      */       }
/*  431 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  432 */         pstmt.setNull(22, 12);
/*      */       else {
/*  434 */         pstmt.setString(22, getMakeTime());
/*      */       }
/*  436 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  437 */         pstmt.setNull(23, 91);
/*      */       else {
/*  439 */         pstmt.setDate(23, Date.valueOf(getModifyDate()));
/*      */       }
/*  441 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  442 */         pstmt.setNull(24, 12);
/*      */       else {
/*  444 */         pstmt.setString(24, getModifyTime());
/*      */       }
/*      */ 
/*  447 */       pstmt.executeUpdate();
/*  448 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  451 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  452 */       CError tError = new CError();
/*  453 */       tError.moduleName = "LNPAgentImpResultDB";
/*  454 */       tError.functionName = "insert()";
/*  455 */       tError.errorMessage = ex.toString();
/*  456 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  459 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  462 */       if (!this.mflag)
/*      */         try {
/*  464 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  468 */       return false;
/*      */     }
/*      */ 
/*  471 */     if (!this.mflag)
/*      */       try {
/*  473 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  477 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  482 */     PreparedStatement pstmt = null;
/*  483 */     ResultSet rs = null;
/*      */ 
/*  485 */     if (!this.mflag) {
/*  486 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  491 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPAgentImpResult WHERE  ResultId = ? AND Grouporder = ?", 
/*  492 */         1003, 1007);
/*  493 */       if ((getResultId() == null) || (getResultId().equals("null")))
/*  494 */         pstmt.setNull(1, 12);
/*      */       else {
/*  496 */         pstmt.setString(1, getResultId());
/*      */       }
/*  498 */       if ((getGrouporder() == null) || (getGrouporder().equals("null")))
/*  499 */         pstmt.setNull(2, 12);
/*      */       else {
/*  501 */         pstmt.setString(2, getGrouporder());
/*      */       }
/*  503 */       rs = pstmt.executeQuery();
/*  504 */       int i = 0;
/*  505 */       if (rs.next())
/*      */       {
/*  507 */         i++;
/*  508 */         if (!setSchema(rs, i))
/*      */         {
/*  511 */           CError tError = new CError();
/*  512 */           tError.moduleName = "LNPAgentImpResultDB";
/*  513 */           tError.functionName = "getInfo";
/*  514 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
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
/*  552 */       tError.moduleName = "LNPAgentImpResultDB";
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
/*      */   public LNPAgentImpResultSet query()
/*      */   {
/*  585 */     Statement stmt = null;
/*  586 */     ResultSet rs = null;
/*  587 */     LNPAgentImpResultSet aLNPAgentImpResultSet = new LNPAgentImpResultSet();
/*      */ 
/*  589 */     if (!this.mflag) {
/*  590 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  595 */       stmt = this.con.createStatement(1003, 1007);
/*  596 */       SQLString sqlObj = new SQLString("LNPAgentImpResult");
/*  597 */       LNPAgentImpResultSchema aSchema = getSchema();
/*  598 */       sqlObj.setSQL(5, aSchema);
/*  599 */       String sql = sqlObj.getSQL();
/*      */ 
/*  601 */       rs = stmt.executeQuery(sql);
/*  602 */       int i = 0;
/*  603 */       while (rs.next())
/*      */       {
/*  605 */         i++;
/*  606 */         LNPAgentImpResultSchema s1 = new LNPAgentImpResultSchema();
/*  607 */         s1.setSchema(rs, i);
/*  608 */         aLNPAgentImpResultSet.add(s1);
/*      */       }try {
/*  610 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  616 */       CError tError = new CError();
/*  617 */       tError.moduleName = "LNPAgentImpResultDB";
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
/*  644 */     return aLNPAgentImpResultSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpResultSet executeQuery(String sql)
/*      */   {
/*  649 */     Statement stmt = null;
/*  650 */     ResultSet rs = null;
/*  651 */     LNPAgentImpResultSet aLNPAgentImpResultSet = new LNPAgentImpResultSet();
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
/*  666 */         LNPAgentImpResultSchema s1 = new LNPAgentImpResultSchema();
/*  667 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  670 */           CError tError = new CError();
/*  671 */           tError.moduleName = "LNPAgentImpResultDB";
/*  672 */           tError.functionName = "executeQuery";
/*  673 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  674 */           this.mErrors.addOneError(tError);
/*      */         }
/*  676 */         aLNPAgentImpResultSet.add(s1);
/*      */       }try {
/*  678 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  684 */       CError tError = new CError();
/*  685 */       tError.moduleName = "LNPAgentImpResultDB";
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
/*  712 */     return aLNPAgentImpResultSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpResultSet query(int nStart, int nCount)
/*      */   {
/*  717 */     Statement stmt = null;
/*  718 */     ResultSet rs = null;
/*  719 */     LNPAgentImpResultSet aLNPAgentImpResultSet = new LNPAgentImpResultSet();
/*      */ 
/*  721 */     if (!this.mflag) {
/*  722 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  727 */       stmt = this.con.createStatement(1003, 1007);
/*  728 */       SQLString sqlObj = new SQLString("LNPAgentImpResult");
/*  729 */       LNPAgentImpResultSchema aSchema = getSchema();
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
/*  747 */         LNPAgentImpResultSchema s1 = new LNPAgentImpResultSchema();
/*  748 */         s1.setSchema(rs, i);
/*  749 */         aLNPAgentImpResultSet.add(s1);
/*      */       }try {
/*  751 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  757 */       CError tError = new CError();
/*  758 */       tError.moduleName = "LNPAgentImpResultDB";
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
/*  785 */     return aLNPAgentImpResultSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentImpResultSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  790 */     Statement stmt = null;
/*  791 */     ResultSet rs = null;
/*  792 */     LNPAgentImpResultSet aLNPAgentImpResultSet = new LNPAgentImpResultSet();
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
/*  816 */         LNPAgentImpResultSchema s1 = new LNPAgentImpResultSchema();
/*  817 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  820 */           CError tError = new CError();
/*  821 */           tError.moduleName = "LNPAgentImpResultDB";
/*  822 */           tError.functionName = "executeQuery";
/*  823 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  824 */           this.mErrors.addOneError(tError);
/*      */         }
/*  826 */         aLNPAgentImpResultSet.add(s1);
/*      */       }try {
/*  828 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  834 */       CError tError = new CError();
/*  835 */       tError.moduleName = "LNPAgentImpResultDB";
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
/*  862 */     return aLNPAgentImpResultSet;
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
/*  876 */       SQLString sqlObj = new SQLString("LNPAgentImpResult");
/*  877 */       LNPAgentImpResultSchema aSchema = getSchema();
/*  878 */       sqlObj.setSQL(2, aSchema);
/*  879 */       String sql = "update LNPAgentImpResult " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  881 */       int operCount = stmt.executeUpdate(sql);
/*  882 */       if (operCount == 0)
/*      */       {
/*  885 */         CError tError = new CError();
/*  886 */         tError.moduleName = "LNPAgentImpResultDB";
/*  887 */         tError.functionName = "update";
/*  888 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
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
/*  906 */       tError.moduleName = "LNPAgentImpResultDB";
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
/*  943 */       tError.moduleName = "LNPAgentImpResultDB";
/*  944 */       tError.functionName = "prepareData";
/*  945 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
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
/*  963 */       tError.moduleName = "LNPAgentImpResultDB";
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
/* 1010 */       tError.moduleName = "LNPAgentImpResultDB";
/* 1011 */       tError.functionName = "hasMoreData";
/* 1012 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
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
/* 1023 */       tError.moduleName = "LNPAgentImpResultDB";
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
/*      */   public LNPAgentImpResultSet getData()
/*      */   {
/* 1057 */     int tCount = 0;
/* 1058 */     LNPAgentImpResultSet tLNPAgentImpResultSet = new LNPAgentImpResultSet();
/* 1059 */     LNPAgentImpResultSchema tLNPAgentImpResultSchema = null;
/* 1060 */     if (this.mResultSet == null)
/*      */     {
/* 1062 */       CError tError = new CError();
/* 1063 */       tError.moduleName = "LNPAgentImpResultDB";
/* 1064 */       tError.functionName = "getData";
/* 1065 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1066 */       this.mErrors.addOneError(tError);
/* 1067 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1071 */       tCount = 1;
/* 1072 */       tLNPAgentImpResultSchema = new LNPAgentImpResultSchema();
/* 1073 */       tLNPAgentImpResultSchema.setSchema(this.mResultSet, 1);
/* 1074 */       tLNPAgentImpResultSet.add(tLNPAgentImpResultSchema);
/*      */ 
/* 1076 */       while (tCount++ < 5000)
/*      */       {
/* 1078 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1080 */         tLNPAgentImpResultSchema = new LNPAgentImpResultSchema();
/* 1081 */         tLNPAgentImpResultSchema.setSchema(this.mResultSet, 1);
/* 1082 */         tLNPAgentImpResultSet.add(tLNPAgentImpResultSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1088 */       CError tError = new CError();
/* 1089 */       tError.moduleName = "LNPAgentImpResultDB";
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
/* 1118 */     return tLNPAgentImpResultSet;
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
/* 1129 */         tError.moduleName = "LNPAgentImpResultDB";
/* 1130 */         tError.functionName = "closeData";
/* 1131 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
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
/* 1144 */       tError.moduleName = "LNPAgentImpResultDB";
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
/* 1155 */         tError.moduleName = "LNPAgentImpResultDB";
/* 1156 */         tError.functionName = "closeData";
/* 1157 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
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
/* 1170 */       tError.moduleName = "LNPAgentImpResultDB";
/* 1171 */       tError.functionName = "closeData";
/* 1172 */       tError.errorMessage = ex3.toString();
/* 1173 */       this.mErrors.addOneError(tError);
/* 1174 */       flag = false;
/*      */     }
/* 1176 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPAgentImpResultDB
 * JD-Core Version:    0.6.0
 */