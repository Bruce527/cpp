/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPFAndIImpResultSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPFAndIImpResultSet;
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
/*      */ public class LNPFAndIImpResultDB extends LNPFAndIImpResultSchema
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
/*      */   public LNPFAndIImpResultDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPFAndIImpResult");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpResultDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPFAndIImpResult");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPFAndIImpResultSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPFAndIImpResultDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPFAndIImpResultSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPFAndIImpResultDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPFAndIImpResult WHERE  ResultId = ? AND Grouporder = ?");
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
/*  113 */       tError.moduleName = "LNPFAndIImpResultDB";
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
/*  150 */       pstmt = this.con.prepareStatement("UPDATE LNPFAndIImpResult SET  ResultId = ? , GrpContNo = ? , ContNo = ? , ProposalContNo = ? , ImpartId = ? , Grouporder = ? , QID01 = ? , A01 = ? , QID02 = ? , A02 = ? , QID03 = ? , A03 = ? , QID04 = ? , A04 = ? , QID05 = ? , A05 = ? , QID06 = ? , A06 = ? , QID07 = ? , A07 = ? , QID08 = ? , A08 = ? , QID09 = ? , A09 = ? , QID10 = ? , A10 = ? , QID11 = ? , A11 = ? , QID12 = ? , A12 = ? , QID13 = ? , A13 = ? , QID14 = ? , A14 = ? , QID15 = ? , A15 = ? , QID16 = ? , A16 = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultId = ? AND Grouporder = ?");
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
/*  241 */       if ((getQID07() == null) || (getQID07().equals("null")))
/*  242 */         pstmt.setNull(19, 12);
/*      */       else {
/*  244 */         pstmt.setString(19, getQID07());
/*      */       }
/*  246 */       if ((getA07() == null) || (getA07().equals("null")))
/*  247 */         pstmt.setNull(20, 12);
/*      */       else {
/*  249 */         pstmt.setString(20, getA07());
/*      */       }
/*  251 */       if ((getQID08() == null) || (getQID08().equals("null")))
/*  252 */         pstmt.setNull(21, 12);
/*      */       else {
/*  254 */         pstmt.setString(21, getQID08());
/*      */       }
/*  256 */       if ((getA08() == null) || (getA08().equals("null")))
/*  257 */         pstmt.setNull(22, 12);
/*      */       else {
/*  259 */         pstmt.setString(22, getA08());
/*      */       }
/*  261 */       if ((getQID09() == null) || (getQID09().equals("null")))
/*  262 */         pstmt.setNull(23, 12);
/*      */       else {
/*  264 */         pstmt.setString(23, getQID09());
/*      */       }
/*  266 */       if ((getA09() == null) || (getA09().equals("null")))
/*  267 */         pstmt.setNull(24, 12);
/*      */       else {
/*  269 */         pstmt.setString(24, getA09());
/*      */       }
/*  271 */       if ((getQID10() == null) || (getQID10().equals("null")))
/*  272 */         pstmt.setNull(25, 12);
/*      */       else {
/*  274 */         pstmt.setString(25, getQID10());
/*      */       }
/*  276 */       if ((getA10() == null) || (getA10().equals("null")))
/*  277 */         pstmt.setNull(26, 12);
/*      */       else {
/*  279 */         pstmt.setString(26, getA10());
/*      */       }
/*  281 */       if ((getQID11() == null) || (getQID11().equals("null")))
/*  282 */         pstmt.setNull(27, 12);
/*      */       else {
/*  284 */         pstmt.setString(27, getQID11());
/*      */       }
/*  286 */       if ((getA11() == null) || (getA11().equals("null")))
/*  287 */         pstmt.setNull(28, 12);
/*      */       else {
/*  289 */         pstmt.setString(28, getA11());
/*      */       }
/*  291 */       if ((getQID12() == null) || (getQID12().equals("null")))
/*  292 */         pstmt.setNull(29, 12);
/*      */       else {
/*  294 */         pstmt.setString(29, getQID12());
/*      */       }
/*  296 */       if ((getA12() == null) || (getA12().equals("null")))
/*  297 */         pstmt.setNull(30, 12);
/*      */       else {
/*  299 */         pstmt.setString(30, getA12());
/*      */       }
/*  301 */       if ((getQID13() == null) || (getQID13().equals("null")))
/*  302 */         pstmt.setNull(31, 12);
/*      */       else {
/*  304 */         pstmt.setString(31, getQID13());
/*      */       }
/*  306 */       if ((getA13() == null) || (getA13().equals("null")))
/*  307 */         pstmt.setNull(32, 12);
/*      */       else {
/*  309 */         pstmt.setString(32, getA13());
/*      */       }
/*  311 */       if ((getQID14() == null) || (getQID14().equals("null")))
/*  312 */         pstmt.setNull(33, 12);
/*      */       else {
/*  314 */         pstmt.setString(33, getQID14());
/*      */       }
/*  316 */       if ((getA14() == null) || (getA14().equals("null")))
/*  317 */         pstmt.setNull(34, 12);
/*      */       else {
/*  319 */         pstmt.setString(34, getA14());
/*      */       }
/*  321 */       if ((getQID15() == null) || (getQID15().equals("null")))
/*  322 */         pstmt.setNull(35, 12);
/*      */       else {
/*  324 */         pstmt.setString(35, getQID15());
/*      */       }
/*  326 */       if ((getA15() == null) || (getA15().equals("null")))
/*  327 */         pstmt.setNull(36, 12);
/*      */       else {
/*  329 */         pstmt.setString(36, getA15());
/*      */       }
/*  331 */       if ((getQID16() == null) || (getQID16().equals("null")))
/*  332 */         pstmt.setNull(37, 12);
/*      */       else {
/*  334 */         pstmt.setString(37, getQID16());
/*      */       }
/*  336 */       if ((getA16() == null) || (getA16().equals("null")))
/*  337 */         pstmt.setNull(38, 12);
/*      */       else {
/*  339 */         pstmt.setString(38, getA16());
/*      */       }
/*  341 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  342 */         pstmt.setNull(39, 12);
/*      */       else {
/*  344 */         pstmt.setString(39, getOperator());
/*      */       }
/*  346 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  347 */         pstmt.setNull(40, 12);
/*      */       else {
/*  349 */         pstmt.setString(40, getManageCom());
/*      */       }
/*  351 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  352 */         pstmt.setNull(41, 91);
/*      */       else {
/*  354 */         pstmt.setDate(41, Date.valueOf(getMakeDate()));
/*      */       }
/*  356 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  357 */         pstmt.setNull(42, 12);
/*      */       else {
/*  359 */         pstmt.setString(42, getMakeTime());
/*      */       }
/*  361 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  362 */         pstmt.setNull(43, 91);
/*      */       else {
/*  364 */         pstmt.setDate(43, Date.valueOf(getModifyDate()));
/*      */       }
/*  366 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  367 */         pstmt.setNull(44, 12);
/*      */       else {
/*  369 */         pstmt.setString(44, getModifyTime());
/*      */       }
/*      */ 
/*  372 */       if ((getResultId() == null) || (getResultId().equals("null")))
/*  373 */         pstmt.setNull(45, 12);
/*      */       else {
/*  375 */         pstmt.setString(45, getResultId());
/*      */       }
/*  377 */       if ((getGrouporder() == null) || (getGrouporder().equals("null")))
/*  378 */         pstmt.setNull(46, 12);
/*      */       else {
/*  380 */         pstmt.setString(46, getGrouporder());
/*      */       }
/*  382 */       pstmt.executeUpdate();
/*  383 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  386 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  387 */       CError tError = new CError();
/*  388 */       tError.moduleName = "LNPFAndIImpResultDB";
/*  389 */       tError.functionName = "update()";
/*  390 */       tError.errorMessage = ex.toString();
/*  391 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  394 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  397 */       if (!this.mflag)
/*      */         try {
/*  399 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  403 */       return false;
/*      */     }
/*      */ 
/*  406 */     if (!this.mflag)
/*      */       try {
/*  408 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  412 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  417 */     PreparedStatement pstmt = null;
/*      */ 
/*  419 */     if (!this.mflag) {
/*  420 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  425 */       pstmt = this.con.prepareStatement("INSERT INTO LNPFAndIImpResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  426 */       if ((getResultId() == null) || (getResultId().equals("null")))
/*  427 */         pstmt.setNull(1, 12);
/*      */       else {
/*  429 */         pstmt.setString(1, getResultId());
/*      */       }
/*  431 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  432 */         pstmt.setNull(2, 12);
/*      */       else {
/*  434 */         pstmt.setString(2, getGrpContNo());
/*      */       }
/*  436 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  437 */         pstmt.setNull(3, 12);
/*      */       else {
/*  439 */         pstmt.setString(3, getContNo());
/*      */       }
/*  441 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  442 */         pstmt.setNull(4, 12);
/*      */       else {
/*  444 */         pstmt.setString(4, getProposalContNo());
/*      */       }
/*  446 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  447 */         pstmt.setNull(5, 12);
/*      */       else {
/*  449 */         pstmt.setString(5, getImpartId());
/*      */       }
/*  451 */       if ((getGrouporder() == null) || (getGrouporder().equals("null")))
/*  452 */         pstmt.setNull(6, 12);
/*      */       else {
/*  454 */         pstmt.setString(6, getGrouporder());
/*      */       }
/*  456 */       if ((getQID01() == null) || (getQID01().equals("null")))
/*  457 */         pstmt.setNull(7, 12);
/*      */       else {
/*  459 */         pstmt.setString(7, getQID01());
/*      */       }
/*  461 */       if ((getA01() == null) || (getA01().equals("null")))
/*  462 */         pstmt.setNull(8, 12);
/*      */       else {
/*  464 */         pstmt.setString(8, getA01());
/*      */       }
/*  466 */       if ((getQID02() == null) || (getQID02().equals("null")))
/*  467 */         pstmt.setNull(9, 12);
/*      */       else {
/*  469 */         pstmt.setString(9, getQID02());
/*      */       }
/*  471 */       if ((getA02() == null) || (getA02().equals("null")))
/*  472 */         pstmt.setNull(10, 12);
/*      */       else {
/*  474 */         pstmt.setString(10, getA02());
/*      */       }
/*  476 */       if ((getQID03() == null) || (getQID03().equals("null")))
/*  477 */         pstmt.setNull(11, 12);
/*      */       else {
/*  479 */         pstmt.setString(11, getQID03());
/*      */       }
/*  481 */       if ((getA03() == null) || (getA03().equals("null")))
/*  482 */         pstmt.setNull(12, 12);
/*      */       else {
/*  484 */         pstmt.setString(12, getA03());
/*      */       }
/*  486 */       if ((getQID04() == null) || (getQID04().equals("null")))
/*  487 */         pstmt.setNull(13, 12);
/*      */       else {
/*  489 */         pstmt.setString(13, getQID04());
/*      */       }
/*  491 */       if ((getA04() == null) || (getA04().equals("null")))
/*  492 */         pstmt.setNull(14, 12);
/*      */       else {
/*  494 */         pstmt.setString(14, getA04());
/*      */       }
/*  496 */       if ((getQID05() == null) || (getQID05().equals("null")))
/*  497 */         pstmt.setNull(15, 12);
/*      */       else {
/*  499 */         pstmt.setString(15, getQID05());
/*      */       }
/*  501 */       if ((getA05() == null) || (getA05().equals("null")))
/*  502 */         pstmt.setNull(16, 12);
/*      */       else {
/*  504 */         pstmt.setString(16, getA05());
/*      */       }
/*  506 */       if ((getQID06() == null) || (getQID06().equals("null")))
/*  507 */         pstmt.setNull(17, 12);
/*      */       else {
/*  509 */         pstmt.setString(17, getQID06());
/*      */       }
/*  511 */       if ((getA06() == null) || (getA06().equals("null")))
/*  512 */         pstmt.setNull(18, 12);
/*      */       else {
/*  514 */         pstmt.setString(18, getA06());
/*      */       }
/*  516 */       if ((getQID07() == null) || (getQID07().equals("null")))
/*  517 */         pstmt.setNull(19, 12);
/*      */       else {
/*  519 */         pstmt.setString(19, getQID07());
/*      */       }
/*  521 */       if ((getA07() == null) || (getA07().equals("null")))
/*  522 */         pstmt.setNull(20, 12);
/*      */       else {
/*  524 */         pstmt.setString(20, getA07());
/*      */       }
/*  526 */       if ((getQID08() == null) || (getQID08().equals("null")))
/*  527 */         pstmt.setNull(21, 12);
/*      */       else {
/*  529 */         pstmt.setString(21, getQID08());
/*      */       }
/*  531 */       if ((getA08() == null) || (getA08().equals("null")))
/*  532 */         pstmt.setNull(22, 12);
/*      */       else {
/*  534 */         pstmt.setString(22, getA08());
/*      */       }
/*  536 */       if ((getQID09() == null) || (getQID09().equals("null")))
/*  537 */         pstmt.setNull(23, 12);
/*      */       else {
/*  539 */         pstmt.setString(23, getQID09());
/*      */       }
/*  541 */       if ((getA09() == null) || (getA09().equals("null")))
/*  542 */         pstmt.setNull(24, 12);
/*      */       else {
/*  544 */         pstmt.setString(24, getA09());
/*      */       }
/*  546 */       if ((getQID10() == null) || (getQID10().equals("null")))
/*  547 */         pstmt.setNull(25, 12);
/*      */       else {
/*  549 */         pstmt.setString(25, getQID10());
/*      */       }
/*  551 */       if ((getA10() == null) || (getA10().equals("null")))
/*  552 */         pstmt.setNull(26, 12);
/*      */       else {
/*  554 */         pstmt.setString(26, getA10());
/*      */       }
/*  556 */       if ((getQID11() == null) || (getQID11().equals("null")))
/*  557 */         pstmt.setNull(27, 12);
/*      */       else {
/*  559 */         pstmt.setString(27, getQID11());
/*      */       }
/*  561 */       if ((getA11() == null) || (getA11().equals("null")))
/*  562 */         pstmt.setNull(28, 12);
/*      */       else {
/*  564 */         pstmt.setString(28, getA11());
/*      */       }
/*  566 */       if ((getQID12() == null) || (getQID12().equals("null")))
/*  567 */         pstmt.setNull(29, 12);
/*      */       else {
/*  569 */         pstmt.setString(29, getQID12());
/*      */       }
/*  571 */       if ((getA12() == null) || (getA12().equals("null")))
/*  572 */         pstmt.setNull(30, 12);
/*      */       else {
/*  574 */         pstmt.setString(30, getA12());
/*      */       }
/*  576 */       if ((getQID13() == null) || (getQID13().equals("null")))
/*  577 */         pstmt.setNull(31, 12);
/*      */       else {
/*  579 */         pstmt.setString(31, getQID13());
/*      */       }
/*  581 */       if ((getA13() == null) || (getA13().equals("null")))
/*  582 */         pstmt.setNull(32, 12);
/*      */       else {
/*  584 */         pstmt.setString(32, getA13());
/*      */       }
/*  586 */       if ((getQID14() == null) || (getQID14().equals("null")))
/*  587 */         pstmt.setNull(33, 12);
/*      */       else {
/*  589 */         pstmt.setString(33, getQID14());
/*      */       }
/*  591 */       if ((getA14() == null) || (getA14().equals("null")))
/*  592 */         pstmt.setNull(34, 12);
/*      */       else {
/*  594 */         pstmt.setString(34, getA14());
/*      */       }
/*  596 */       if ((getQID15() == null) || (getQID15().equals("null")))
/*  597 */         pstmt.setNull(35, 12);
/*      */       else {
/*  599 */         pstmt.setString(35, getQID15());
/*      */       }
/*  601 */       if ((getA15() == null) || (getA15().equals("null")))
/*  602 */         pstmt.setNull(36, 12);
/*      */       else {
/*  604 */         pstmt.setString(36, getA15());
/*      */       }
/*  606 */       if ((getQID16() == null) || (getQID16().equals("null")))
/*  607 */         pstmt.setNull(37, 12);
/*      */       else {
/*  609 */         pstmt.setString(37, getQID16());
/*      */       }
/*  611 */       if ((getA16() == null) || (getA16().equals("null")))
/*  612 */         pstmt.setNull(38, 12);
/*      */       else {
/*  614 */         pstmt.setString(38, getA16());
/*      */       }
/*  616 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  617 */         pstmt.setNull(39, 12);
/*      */       else {
/*  619 */         pstmt.setString(39, getOperator());
/*      */       }
/*  621 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  622 */         pstmt.setNull(40, 12);
/*      */       else {
/*  624 */         pstmt.setString(40, getManageCom());
/*      */       }
/*  626 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  627 */         pstmt.setNull(41, 91);
/*      */       else {
/*  629 */         pstmt.setDate(41, Date.valueOf(getMakeDate()));
/*      */       }
/*  631 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  632 */         pstmt.setNull(42, 12);
/*      */       else {
/*  634 */         pstmt.setString(42, getMakeTime());
/*      */       }
/*  636 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  637 */         pstmt.setNull(43, 91);
/*      */       else {
/*  639 */         pstmt.setDate(43, Date.valueOf(getModifyDate()));
/*      */       }
/*  641 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  642 */         pstmt.setNull(44, 12);
/*      */       else {
/*  644 */         pstmt.setString(44, getModifyTime());
/*      */       }
/*      */ 
/*  647 */       pstmt.executeUpdate();
/*  648 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  651 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  652 */       CError tError = new CError();
/*  653 */       tError.moduleName = "LNPFAndIImpResultDB";
/*  654 */       tError.functionName = "insert()";
/*  655 */       tError.errorMessage = ex.toString();
/*  656 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  659 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  662 */       if (!this.mflag)
/*      */         try {
/*  664 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  668 */       return false;
/*      */     }
/*      */ 
/*  671 */     if (!this.mflag)
/*      */       try {
/*  673 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  677 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  682 */     PreparedStatement pstmt = null;
/*  683 */     ResultSet rs = null;
/*      */ 
/*  685 */     if (!this.mflag) {
/*  686 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  691 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPFAndIImpResult WHERE  ResultId = ? AND Grouporder = ?", 
/*  692 */         1003, 1007);
/*  693 */       if ((getResultId() == null) || (getResultId().equals("null")))
/*  694 */         pstmt.setNull(1, 12);
/*      */       else {
/*  696 */         pstmt.setString(1, getResultId());
/*      */       }
/*  698 */       if ((getGrouporder() == null) || (getGrouporder().equals("null")))
/*  699 */         pstmt.setNull(2, 12);
/*      */       else {
/*  701 */         pstmt.setString(2, getGrouporder());
/*      */       }
/*  703 */       rs = pstmt.executeQuery();
/*  704 */       int i = 0;
/*  705 */       if (rs.next())
/*      */       {
/*  707 */         i++;
/*  708 */         if (!setSchema(rs, i))
/*      */         {
/*  711 */           CError tError = new CError();
/*  712 */           tError.moduleName = "LNPFAndIImpResultDB";
/*  713 */           tError.functionName = "getInfo";
/*  714 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  715 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  717 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  720 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  724 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  728 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  732 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  735 */       if (i == 0)
/*      */       {
/*  737 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  741 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  745 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  751 */       CError tError = new CError();
/*  752 */       tError.moduleName = "LNPFAndIImpResultDB";
/*  753 */       tError.functionName = "getInfo";
/*  754 */       tError.errorMessage = e.toString();
/*  755 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  757 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  760 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  764 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  768 */       return false;
/*      */     }
/*      */ 
/*  771 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  775 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  780 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpResultSet query()
/*      */   {
/*  785 */     Statement stmt = null;
/*  786 */     ResultSet rs = null;
/*  787 */     LNPFAndIImpResultSet aLNPFAndIImpResultSet = new LNPFAndIImpResultSet();
/*      */ 
/*  789 */     if (!this.mflag) {
/*  790 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  795 */       stmt = this.con.createStatement(1003, 1007);
/*  796 */       SQLString sqlObj = new SQLString("LNPFAndIImpResult");
/*  797 */       LNPFAndIImpResultSchema aSchema = getSchema();
/*  798 */       sqlObj.setSQL(5, aSchema);
/*  799 */       String sql = sqlObj.getSQL();
/*      */ 
/*  801 */       rs = stmt.executeQuery(sql);
/*  802 */       int i = 0;
/*  803 */       while (rs.next())
/*      */       {
/*  805 */         i++;
/*  806 */         LNPFAndIImpResultSchema s1 = new LNPFAndIImpResultSchema();
/*  807 */         s1.setSchema(rs, i);
/*  808 */         aLNPFAndIImpResultSet.add(s1);
/*      */       }try {
/*  810 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  816 */       CError tError = new CError();
/*  817 */       tError.moduleName = "LNPFAndIImpResultDB";
/*  818 */       tError.functionName = "query";
/*  819 */       tError.errorMessage = e.toString();
/*  820 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  822 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  825 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  829 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  835 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  839 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  844 */     return aLNPFAndIImpResultSet;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpResultSet executeQuery(String sql)
/*      */   {
/*  849 */     Statement stmt = null;
/*  850 */     ResultSet rs = null;
/*  851 */     LNPFAndIImpResultSet aLNPFAndIImpResultSet = new LNPFAndIImpResultSet();
/*      */ 
/*  853 */     if (!this.mflag) {
/*  854 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  859 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  861 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  862 */       int i = 0;
/*  863 */       while (rs.next())
/*      */       {
/*  865 */         i++;
/*  866 */         LNPFAndIImpResultSchema s1 = new LNPFAndIImpResultSchema();
/*  867 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  870 */           CError tError = new CError();
/*  871 */           tError.moduleName = "LNPFAndIImpResultDB";
/*  872 */           tError.functionName = "executeQuery";
/*  873 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  874 */           this.mErrors.addOneError(tError);
/*      */         }
/*  876 */         aLNPFAndIImpResultSet.add(s1);
/*      */       }try {
/*  878 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  884 */       CError tError = new CError();
/*  885 */       tError.moduleName = "LNPFAndIImpResultDB";
/*  886 */       tError.functionName = "executeQuery";
/*  887 */       tError.errorMessage = e.toString();
/*  888 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  890 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  893 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  897 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  903 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  907 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  912 */     return aLNPFAndIImpResultSet;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpResultSet query(int nStart, int nCount)
/*      */   {
/*  917 */     Statement stmt = null;
/*  918 */     ResultSet rs = null;
/*  919 */     LNPFAndIImpResultSet aLNPFAndIImpResultSet = new LNPFAndIImpResultSet();
/*      */ 
/*  921 */     if (!this.mflag) {
/*  922 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  927 */       stmt = this.con.createStatement(1003, 1007);
/*  928 */       SQLString sqlObj = new SQLString("LNPFAndIImpResult");
/*  929 */       LNPFAndIImpResultSchema aSchema = getSchema();
/*  930 */       sqlObj.setSQL(5, aSchema);
/*  931 */       String sql = sqlObj.getSQL();
/*      */ 
/*  933 */       rs = stmt.executeQuery(sql);
/*  934 */       int i = 0;
/*  935 */       while (rs.next())
/*      */       {
/*  937 */         i++;
/*      */ 
/*  939 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  943 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  947 */         LNPFAndIImpResultSchema s1 = new LNPFAndIImpResultSchema();
/*  948 */         s1.setSchema(rs, i);
/*  949 */         aLNPFAndIImpResultSet.add(s1);
/*      */       }try {
/*  951 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  957 */       CError tError = new CError();
/*  958 */       tError.moduleName = "LNPFAndIImpResultDB";
/*  959 */       tError.functionName = "query";
/*  960 */       tError.errorMessage = e.toString();
/*  961 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  963 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  966 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  970 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  976 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  980 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  985 */     return aLNPFAndIImpResultSet;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpResultSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  990 */     Statement stmt = null;
/*  991 */     ResultSet rs = null;
/*  992 */     LNPFAndIImpResultSet aLNPFAndIImpResultSet = new LNPFAndIImpResultSet();
/*      */ 
/*  994 */     if (!this.mflag) {
/*  995 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1000 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/* 1002 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 1003 */       int i = 0;
/* 1004 */       while (rs.next())
/*      */       {
/* 1006 */         i++;
/*      */ 
/* 1008 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/* 1012 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/* 1016 */         LNPFAndIImpResultSchema s1 = new LNPFAndIImpResultSchema();
/* 1017 */         if (!s1.setSchema(rs, i))
/*      */         {
/* 1020 */           CError tError = new CError();
/* 1021 */           tError.moduleName = "LNPFAndIImpResultDB";
/* 1022 */           tError.functionName = "executeQuery";
/* 1023 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 1024 */           this.mErrors.addOneError(tError);
/*      */         }
/* 1026 */         aLNPFAndIImpResultSet.add(s1);
/*      */       }try {
/* 1028 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1034 */       CError tError = new CError();
/* 1035 */       tError.moduleName = "LNPFAndIImpResultDB";
/* 1036 */       tError.functionName = "executeQuery";
/* 1037 */       tError.errorMessage = e.toString();
/* 1038 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1040 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/* 1043 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1047 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/* 1053 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1057 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/* 1062 */     return aLNPFAndIImpResultSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/* 1067 */     Statement stmt = null;
/*      */ 
/* 1069 */     if (!this.mflag) {
/* 1070 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1075 */       stmt = this.con.createStatement(1003, 1007);
/* 1076 */       SQLString sqlObj = new SQLString("LNPFAndIImpResult");
/* 1077 */       LNPFAndIImpResultSchema aSchema = getSchema();
/* 1078 */       sqlObj.setSQL(2, aSchema);
/* 1079 */       String sql = "update LNPFAndIImpResult " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/* 1081 */       int operCount = stmt.executeUpdate(sql);
/* 1082 */       if (operCount == 0)
/*      */       {
/* 1085 */         CError tError = new CError();
/* 1086 */         tError.moduleName = "LNPFAndIImpResultDB";
/* 1087 */         tError.functionName = "update";
/* 1088 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 1089 */         this.mErrors.addOneError(tError);
/*      */ 
/* 1091 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/* 1095 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/* 1099 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1105 */       CError tError = new CError();
/* 1106 */       tError.moduleName = "LNPFAndIImpResultDB";
/* 1107 */       tError.functionName = "update";
/* 1108 */       tError.errorMessage = e.toString();
/* 1109 */       this.mErrors.addOneError(tError);
/*      */       try {
/* 1111 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/* 1113 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1117 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1121 */       return false;
/*      */     }
/*      */ 
/* 1124 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1128 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1133 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/* 1139 */     if (this.mResultSet != null)
/*      */     {
/* 1142 */       CError tError = new CError();
/* 1143 */       tError.moduleName = "LNPFAndIImpResultDB";
/* 1144 */       tError.functionName = "prepareData";
/* 1145 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 1146 */       this.mErrors.addOneError(tError);
/* 1147 */       return false;
/*      */     }
/*      */ 
/* 1150 */     if (!this.mflag)
/*      */     {
/* 1152 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/* 1156 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 1157 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1162 */       CError tError = new CError();
/* 1163 */       tError.moduleName = "LNPFAndIImpResultDB";
/* 1164 */       tError.functionName = "prepareData";
/* 1165 */       tError.errorMessage = e.toString();
/* 1166 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1169 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1175 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1179 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1183 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1188 */       return false;
/*      */     }
/*      */ 
/* 1191 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1195 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1200 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1206 */     boolean flag = true;
/* 1207 */     if (this.mResultSet == null)
/*      */     {
/* 1209 */       CError tError = new CError();
/* 1210 */       tError.moduleName = "LNPFAndIImpResultDB";
/* 1211 */       tError.functionName = "hasMoreData";
/* 1212 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1213 */       this.mErrors.addOneError(tError);
/* 1214 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1218 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1222 */       CError tError = new CError();
/* 1223 */       tError.moduleName = "LNPFAndIImpResultDB";
/* 1224 */       tError.functionName = "hasMoreData";
/* 1225 */       tError.errorMessage = ex.toString();
/* 1226 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1229 */         this.mResultSet.close();
/* 1230 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1236 */         this.mStatement.close();
/* 1237 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1241 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1245 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1250 */       return false;
/*      */     }
/* 1252 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpResultSet getData()
/*      */   {
/* 1257 */     int tCount = 0;
/* 1258 */     LNPFAndIImpResultSet tLNPFAndIImpResultSet = new LNPFAndIImpResultSet();
/* 1259 */     LNPFAndIImpResultSchema tLNPFAndIImpResultSchema = null;
/* 1260 */     if (this.mResultSet == null)
/*      */     {
/* 1262 */       CError tError = new CError();
/* 1263 */       tError.moduleName = "LNPFAndIImpResultDB";
/* 1264 */       tError.functionName = "getData";
/* 1265 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1266 */       this.mErrors.addOneError(tError);
/* 1267 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1271 */       tCount = 1;
/* 1272 */       tLNPFAndIImpResultSchema = new LNPFAndIImpResultSchema();
/* 1273 */       tLNPFAndIImpResultSchema.setSchema(this.mResultSet, 1);
/* 1274 */       tLNPFAndIImpResultSet.add(tLNPFAndIImpResultSchema);
/*      */ 
/* 1276 */       while (tCount++ < 5000)
/*      */       {
/* 1278 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1280 */         tLNPFAndIImpResultSchema = new LNPFAndIImpResultSchema();
/* 1281 */         tLNPFAndIImpResultSchema.setSchema(this.mResultSet, 1);
/* 1282 */         tLNPFAndIImpResultSet.add(tLNPFAndIImpResultSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1288 */       CError tError = new CError();
/* 1289 */       tError.moduleName = "LNPFAndIImpResultDB";
/* 1290 */       tError.functionName = "getData";
/* 1291 */       tError.errorMessage = ex.toString();
/* 1292 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1295 */         this.mResultSet.close();
/* 1296 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1302 */         this.mStatement.close();
/* 1303 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1307 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1311 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1316 */       return null;
/*      */     }
/* 1318 */     return tLNPFAndIImpResultSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1323 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1326 */       if (this.mResultSet == null)
/*      */       {
/* 1328 */         CError tError = new CError();
/* 1329 */         tError.moduleName = "LNPFAndIImpResultDB";
/* 1330 */         tError.functionName = "closeData";
/* 1331 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1332 */         this.mErrors.addOneError(tError);
/* 1333 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1337 */         this.mResultSet.close();
/* 1338 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1343 */       CError tError = new CError();
/* 1344 */       tError.moduleName = "LNPFAndIImpResultDB";
/* 1345 */       tError.functionName = "closeData";
/* 1346 */       tError.errorMessage = ex2.toString();
/* 1347 */       this.mErrors.addOneError(tError);
/* 1348 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1352 */       if (this.mStatement == null)
/*      */       {
/* 1354 */         CError tError = new CError();
/* 1355 */         tError.moduleName = "LNPFAndIImpResultDB";
/* 1356 */         tError.functionName = "closeData";
/* 1357 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1358 */         this.mErrors.addOneError(tError);
/* 1359 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1363 */         this.mStatement.close();
/* 1364 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1369 */       CError tError = new CError();
/* 1370 */       tError.moduleName = "LNPFAndIImpResultDB";
/* 1371 */       tError.functionName = "closeData";
/* 1372 */       tError.errorMessage = ex3.toString();
/* 1373 */       this.mErrors.addOneError(tError);
/* 1374 */       flag = false;
/*      */     }
/* 1376 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPFAndIImpResultDB
 * JD-Core Version:    0.6.0
 */