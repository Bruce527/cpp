/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.LARearRelationNewSchema;
/*      */ import com.sinosoft.map.lis.vschema.LARearRelationNewSet;
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
/*      */ public class LARearRelationNewDB extends LARearRelationNewSchema
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
/*      */   public LARearRelationNewDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "LARearRelationNew");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LARearRelationNewDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("LARearRelationNew");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     LARearRelationNewSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "LARearRelationNewDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     LARearRelationNewSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "LARearRelationNewDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM LARearRelationNew WHERE  AgentCode = ? AND RAgentCode = ? AND Type = ? AND Deep = ? AND State = ?");
/*   96 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getAgentCode());
/*      */       }
/*  101 */       if ((getRAgentCode() == null) || (getRAgentCode().equals("null")))
/*  102 */         pstmt.setNull(2, 12);
/*      */       else {
/*  104 */         pstmt.setString(2, getRAgentCode());
/*      */       }
/*  106 */       if ((getType() == null) || (getType().equals("null")))
/*  107 */         pstmt.setNull(3, 12);
/*      */       else {
/*  109 */         pstmt.setString(3, getType());
/*      */       }
/*  111 */       pstmt.setInt(4, getDeep());
/*  112 */       if ((getState() == null) || (getState().equals("null")))
/*  113 */         pstmt.setNull(5, 12);
/*      */       else {
/*  115 */         pstmt.setString(5, getState());
/*      */       }
/*  117 */       pstmt.executeUpdate();
/*  118 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  121 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  122 */       CError tError = new CError();
/*  123 */       tError.moduleName = "LARearRelationNewDB";
/*  124 */       tError.functionName = "delete()";
/*  125 */       tError.errorMessage = ex.toString();
/*  126 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  129 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  132 */       if (!this.mflag)
/*      */         try {
/*  134 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  138 */       return false;
/*      */     }
/*      */ 
/*  141 */     if (!this.mflag)
/*      */       try {
/*  143 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  147 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  152 */     PreparedStatement pstmt = null;
/*      */ 
/*  154 */     if (!this.mflag) {
/*  155 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  160 */       pstmt = this.con.prepareStatement("UPDATE LARearRelationNew SET  ManageCom = ? , AgentCode = ? , AgentGrade = ? , AgentGroup = ? , SMAgentCode = ? , AMAgentCode = ? , RAgentCode = ? , AgentTitle = ? , RAgentGrade = ? , RAgentTitle = ? , RAgentGroup = ? , RBranchAttr = ? , Type = ? , Deep = ? , StartDate = ? , BreakDate = ? , PBreakDate = ? , BreakType = ? , State = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Operator = ? WHERE  AgentCode = ? AND RAgentCode = ? AND Type = ? AND Deep = ? AND State = ?");
/*  161 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  162 */         pstmt.setNull(1, 12);
/*      */       else {
/*  164 */         pstmt.setString(1, getManageCom());
/*      */       }
/*  166 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  167 */         pstmt.setNull(2, 12);
/*      */       else {
/*  169 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  171 */       if ((getAgentGrade() == null) || (getAgentGrade().equals("null")))
/*  172 */         pstmt.setNull(3, 12);
/*      */       else {
/*  174 */         pstmt.setString(3, getAgentGrade());
/*      */       }
/*  176 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  177 */         pstmt.setNull(4, 12);
/*      */       else {
/*  179 */         pstmt.setString(4, getAgentGroup());
/*      */       }
/*  181 */       if ((getSMAgentCode() == null) || (getSMAgentCode().equals("null")))
/*  182 */         pstmt.setNull(5, 12);
/*      */       else {
/*  184 */         pstmt.setString(5, getSMAgentCode());
/*      */       }
/*  186 */       if ((getAMAgentCode() == null) || (getAMAgentCode().equals("null")))
/*  187 */         pstmt.setNull(6, 12);
/*      */       else {
/*  189 */         pstmt.setString(6, getAMAgentCode());
/*      */       }
/*  191 */       if ((getRAgentCode() == null) || (getRAgentCode().equals("null")))
/*  192 */         pstmt.setNull(7, 12);
/*      */       else {
/*  194 */         pstmt.setString(7, getRAgentCode());
/*      */       }
/*  196 */       if ((getAgentTitle() == null) || (getAgentTitle().equals("null")))
/*  197 */         pstmt.setNull(8, 12);
/*      */       else {
/*  199 */         pstmt.setString(8, getAgentTitle());
/*      */       }
/*  201 */       if ((getRAgentGrade() == null) || (getRAgentGrade().equals("null")))
/*  202 */         pstmt.setNull(9, 12);
/*      */       else {
/*  204 */         pstmt.setString(9, getRAgentGrade());
/*      */       }
/*  206 */       if ((getRAgentTitle() == null) || (getRAgentTitle().equals("null")))
/*  207 */         pstmt.setNull(10, 12);
/*      */       else {
/*  209 */         pstmt.setString(10, getRAgentTitle());
/*      */       }
/*  211 */       if ((getRAgentGroup() == null) || (getRAgentGroup().equals("null")))
/*  212 */         pstmt.setNull(11, 12);
/*      */       else {
/*  214 */         pstmt.setString(11, getRAgentGroup());
/*      */       }
/*  216 */       if ((getRBranchAttr() == null) || (getRBranchAttr().equals("null")))
/*  217 */         pstmt.setNull(12, 12);
/*      */       else {
/*  219 */         pstmt.setString(12, getRBranchAttr());
/*      */       }
/*  221 */       if ((getType() == null) || (getType().equals("null")))
/*  222 */         pstmt.setNull(13, 12);
/*      */       else {
/*  224 */         pstmt.setString(13, getType());
/*      */       }
/*  226 */       pstmt.setInt(14, getDeep());
/*  227 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  228 */         pstmt.setNull(15, 91);
/*      */       else {
/*  230 */         pstmt.setDate(15, Date.valueOf(getStartDate()));
/*      */       }
/*  232 */       if ((getBreakDate() == null) || (getBreakDate().equals("null")))
/*  233 */         pstmt.setNull(16, 91);
/*      */       else {
/*  235 */         pstmt.setDate(16, Date.valueOf(getBreakDate()));
/*      */       }
/*  237 */       if ((getPBreakDate() == null) || (getPBreakDate().equals("null")))
/*  238 */         pstmt.setNull(17, 91);
/*      */       else {
/*  240 */         pstmt.setDate(17, Date.valueOf(getPBreakDate()));
/*      */       }
/*  242 */       if ((getBreakType() == null) || (getBreakType().equals("null")))
/*  243 */         pstmt.setNull(18, 12);
/*      */       else {
/*  245 */         pstmt.setString(18, getBreakType());
/*      */       }
/*  247 */       if ((getState() == null) || (getState().equals("null")))
/*  248 */         pstmt.setNull(19, 12);
/*      */       else {
/*  250 */         pstmt.setString(19, getState());
/*      */       }
/*  252 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  253 */         pstmt.setNull(20, 91);
/*      */       else {
/*  255 */         pstmt.setDate(20, Date.valueOf(getMakeDate()));
/*      */       }
/*  257 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  258 */         pstmt.setNull(21, 12);
/*      */       else {
/*  260 */         pstmt.setString(21, getMakeTime());
/*      */       }
/*  262 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  263 */         pstmt.setNull(22, 91);
/*      */       else {
/*  265 */         pstmt.setDate(22, Date.valueOf(getModifyDate()));
/*      */       }
/*  267 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  268 */         pstmt.setNull(23, 12);
/*      */       else {
/*  270 */         pstmt.setString(23, getModifyTime());
/*      */       }
/*  272 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  273 */         pstmt.setNull(24, 12);
/*      */       else {
/*  275 */         pstmt.setString(24, getOperator());
/*      */       }
/*      */ 
/*  278 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  279 */         pstmt.setNull(25, 12);
/*      */       else {
/*  281 */         pstmt.setString(25, getAgentCode());
/*      */       }
/*  283 */       if ((getRAgentCode() == null) || (getRAgentCode().equals("null")))
/*  284 */         pstmt.setNull(26, 12);
/*      */       else {
/*  286 */         pstmt.setString(26, getRAgentCode());
/*      */       }
/*  288 */       if ((getType() == null) || (getType().equals("null")))
/*  289 */         pstmt.setNull(27, 12);
/*      */       else {
/*  291 */         pstmt.setString(27, getType());
/*      */       }
/*  293 */       pstmt.setInt(28, getDeep());
/*  294 */       if ((getState() == null) || (getState().equals("null")))
/*  295 */         pstmt.setNull(29, 12);
/*      */       else {
/*  297 */         pstmt.setString(29, getState());
/*      */       }
/*  299 */       pstmt.executeUpdate();
/*  300 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  303 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  304 */       CError tError = new CError();
/*  305 */       tError.moduleName = "LARearRelationNewDB";
/*  306 */       tError.functionName = "update()";
/*  307 */       tError.errorMessage = ex.toString();
/*  308 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  311 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  314 */       if (!this.mflag)
/*      */         try {
/*  316 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  320 */       return false;
/*      */     }
/*      */ 
/*  323 */     if (!this.mflag)
/*      */       try {
/*  325 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  329 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  334 */     PreparedStatement pstmt = null;
/*      */ 
/*  336 */     if (!this.mflag) {
/*  337 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  342 */       pstmt = this.con.prepareStatement("INSERT INTO LARearRelationNew VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  343 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  344 */         pstmt.setNull(1, 12);
/*      */       else {
/*  346 */         pstmt.setString(1, getManageCom());
/*      */       }
/*  348 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  349 */         pstmt.setNull(2, 12);
/*      */       else {
/*  351 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  353 */       if ((getAgentGrade() == null) || (getAgentGrade().equals("null")))
/*  354 */         pstmt.setNull(3, 12);
/*      */       else {
/*  356 */         pstmt.setString(3, getAgentGrade());
/*      */       }
/*  358 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  359 */         pstmt.setNull(4, 12);
/*      */       else {
/*  361 */         pstmt.setString(4, getAgentGroup());
/*      */       }
/*  363 */       if ((getSMAgentCode() == null) || (getSMAgentCode().equals("null")))
/*  364 */         pstmt.setNull(5, 12);
/*      */       else {
/*  366 */         pstmt.setString(5, getSMAgentCode());
/*      */       }
/*  368 */       if ((getAMAgentCode() == null) || (getAMAgentCode().equals("null")))
/*  369 */         pstmt.setNull(6, 12);
/*      */       else {
/*  371 */         pstmt.setString(6, getAMAgentCode());
/*      */       }
/*  373 */       if ((getRAgentCode() == null) || (getRAgentCode().equals("null")))
/*  374 */         pstmt.setNull(7, 12);
/*      */       else {
/*  376 */         pstmt.setString(7, getRAgentCode());
/*      */       }
/*  378 */       if ((getAgentTitle() == null) || (getAgentTitle().equals("null")))
/*  379 */         pstmt.setNull(8, 12);
/*      */       else {
/*  381 */         pstmt.setString(8, getAgentTitle());
/*      */       }
/*  383 */       if ((getRAgentGrade() == null) || (getRAgentGrade().equals("null")))
/*  384 */         pstmt.setNull(9, 12);
/*      */       else {
/*  386 */         pstmt.setString(9, getRAgentGrade());
/*      */       }
/*  388 */       if ((getRAgentTitle() == null) || (getRAgentTitle().equals("null")))
/*  389 */         pstmt.setNull(10, 12);
/*      */       else {
/*  391 */         pstmt.setString(10, getRAgentTitle());
/*      */       }
/*  393 */       if ((getRAgentGroup() == null) || (getRAgentGroup().equals("null")))
/*  394 */         pstmt.setNull(11, 12);
/*      */       else {
/*  396 */         pstmt.setString(11, getRAgentGroup());
/*      */       }
/*  398 */       if ((getRBranchAttr() == null) || (getRBranchAttr().equals("null")))
/*  399 */         pstmt.setNull(12, 12);
/*      */       else {
/*  401 */         pstmt.setString(12, getRBranchAttr());
/*      */       }
/*  403 */       if ((getType() == null) || (getType().equals("null")))
/*  404 */         pstmt.setNull(13, 12);
/*      */       else {
/*  406 */         pstmt.setString(13, getType());
/*      */       }
/*  408 */       pstmt.setInt(14, getDeep());
/*  409 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  410 */         pstmt.setNull(15, 91);
/*      */       else {
/*  412 */         pstmt.setDate(15, Date.valueOf(getStartDate()));
/*      */       }
/*  414 */       if ((getBreakDate() == null) || (getBreakDate().equals("null")))
/*  415 */         pstmt.setNull(16, 91);
/*      */       else {
/*  417 */         pstmt.setDate(16, Date.valueOf(getBreakDate()));
/*      */       }
/*  419 */       if ((getPBreakDate() == null) || (getPBreakDate().equals("null")))
/*  420 */         pstmt.setNull(17, 91);
/*      */       else {
/*  422 */         pstmt.setDate(17, Date.valueOf(getPBreakDate()));
/*      */       }
/*  424 */       if ((getBreakType() == null) || (getBreakType().equals("null")))
/*  425 */         pstmt.setNull(18, 12);
/*      */       else {
/*  427 */         pstmt.setString(18, getBreakType());
/*      */       }
/*  429 */       if ((getState() == null) || (getState().equals("null")))
/*  430 */         pstmt.setNull(19, 12);
/*      */       else {
/*  432 */         pstmt.setString(19, getState());
/*      */       }
/*  434 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  435 */         pstmt.setNull(20, 91);
/*      */       else {
/*  437 */         pstmt.setDate(20, Date.valueOf(getMakeDate()));
/*      */       }
/*  439 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  440 */         pstmt.setNull(21, 12);
/*      */       else {
/*  442 */         pstmt.setString(21, getMakeTime());
/*      */       }
/*  444 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  445 */         pstmt.setNull(22, 91);
/*      */       else {
/*  447 */         pstmt.setDate(22, Date.valueOf(getModifyDate()));
/*      */       }
/*  449 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  450 */         pstmt.setNull(23, 12);
/*      */       else {
/*  452 */         pstmt.setString(23, getModifyTime());
/*      */       }
/*  454 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  455 */         pstmt.setNull(24, 12);
/*      */       else {
/*  457 */         pstmt.setString(24, getOperator());
/*      */       }
/*      */ 
/*  460 */       pstmt.executeUpdate();
/*  461 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  464 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  465 */       CError tError = new CError();
/*  466 */       tError.moduleName = "LARearRelationNewDB";
/*  467 */       tError.functionName = "insert()";
/*  468 */       tError.errorMessage = ex.toString();
/*  469 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  472 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  475 */       if (!this.mflag)
/*      */         try {
/*  477 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  481 */       return false;
/*      */     }
/*      */ 
/*  484 */     if (!this.mflag)
/*      */       try {
/*  486 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  490 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  495 */     PreparedStatement pstmt = null;
/*  496 */     ResultSet rs = null;
/*      */ 
/*  498 */     if (!this.mflag) {
/*  499 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  504 */       pstmt = this.con.prepareStatement("SELECT * FROM LARearRelationNew WHERE  AgentCode = ? AND RAgentCode = ? AND Type = ? AND Deep = ? AND State = ?", 
/*  505 */         1003, 1007);
/*  506 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  507 */         pstmt.setNull(1, 12);
/*      */       else {
/*  509 */         pstmt.setString(1, getAgentCode());
/*      */       }
/*  511 */       if ((getRAgentCode() == null) || (getRAgentCode().equals("null")))
/*  512 */         pstmt.setNull(2, 12);
/*      */       else {
/*  514 */         pstmt.setString(2, getRAgentCode());
/*      */       }
/*  516 */       if ((getType() == null) || (getType().equals("null")))
/*  517 */         pstmt.setNull(3, 12);
/*      */       else {
/*  519 */         pstmt.setString(3, getType());
/*      */       }
/*  521 */       pstmt.setInt(4, getDeep());
/*  522 */       if ((getState() == null) || (getState().equals("null")))
/*  523 */         pstmt.setNull(5, 12);
/*      */       else {
/*  525 */         pstmt.setString(5, getState());
/*      */       }
/*  527 */       rs = pstmt.executeQuery();
/*  528 */       int i = 0;
/*  529 */       if (rs.next())
/*      */       {
/*  531 */         i++;
/*  532 */         if (!setSchema(rs, i))
/*      */         {
/*  535 */           CError tError = new CError();
/*  536 */           tError.moduleName = "LARearRelationNewDB";
/*  537 */           tError.functionName = "getInfo";
/*  538 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  539 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  541 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  544 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  548 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  552 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  556 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  559 */       if (i == 0)
/*      */       {
/*  561 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  565 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  569 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  575 */       CError tError = new CError();
/*  576 */       tError.moduleName = "LARearRelationNewDB";
/*  577 */       tError.functionName = "getInfo";
/*  578 */       tError.errorMessage = e.toString();
/*  579 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  581 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  584 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  588 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  592 */       return false;
/*      */     }
/*      */ 
/*  595 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  599 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  604 */     return true;
/*      */   }
/*      */ 
/*      */   public LARearRelationNewSet query()
/*      */   {
/*  609 */     Statement stmt = null;
/*  610 */     ResultSet rs = null;
/*  611 */     LARearRelationNewSet aLARearRelationNewSet = new LARearRelationNewSet();
/*      */ 
/*  613 */     if (!this.mflag) {
/*  614 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  619 */       stmt = this.con.createStatement(1003, 1007);
/*  620 */       SQLString sqlObj = new SQLString("LARearRelationNew");
/*  621 */       LARearRelationNewSchema aSchema = getSchema();
/*  622 */       sqlObj.setSQL(5, aSchema);
/*  623 */       String sql = sqlObj.getSQL();
/*      */ 
/*  625 */       rs = stmt.executeQuery(sql);
/*  626 */       int i = 0;
/*  627 */       while (rs.next())
/*      */       {
/*  629 */         i++;
/*  630 */         LARearRelationNewSchema s1 = new LARearRelationNewSchema();
/*  631 */         s1.setSchema(rs, i);
/*  632 */         aLARearRelationNewSet.add(s1);
/*      */       }try {
/*  634 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  640 */       CError tError = new CError();
/*  641 */       tError.moduleName = "LARearRelationNewDB";
/*  642 */       tError.functionName = "query";
/*  643 */       tError.errorMessage = e.toString();
/*  644 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  646 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  649 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  653 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  659 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  663 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  668 */     return aLARearRelationNewSet;
/*      */   }
/*      */ 
/*      */   public LARearRelationNewSet executeQuery(String sql)
/*      */   {
/*  673 */     Statement stmt = null;
/*  674 */     ResultSet rs = null;
/*  675 */     LARearRelationNewSet aLARearRelationNewSet = new LARearRelationNewSet();
/*      */ 
/*  677 */     if (!this.mflag) {
/*  678 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  683 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  685 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  686 */       int i = 0;
/*  687 */       while (rs.next())
/*      */       {
/*  689 */         i++;
/*  690 */         LARearRelationNewSchema s1 = new LARearRelationNewSchema();
/*  691 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  694 */           CError tError = new CError();
/*  695 */           tError.moduleName = "LARearRelationNewDB";
/*  696 */           tError.functionName = "executeQuery";
/*  697 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  698 */           this.mErrors.addOneError(tError);
/*      */         }
/*  700 */         aLARearRelationNewSet.add(s1);
/*      */       }try {
/*  702 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  708 */       CError tError = new CError();
/*  709 */       tError.moduleName = "LARearRelationNewDB";
/*  710 */       tError.functionName = "executeQuery";
/*  711 */       tError.errorMessage = e.toString();
/*  712 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  714 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  717 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  721 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  727 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  731 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  736 */     return aLARearRelationNewSet;
/*      */   }
/*      */ 
/*      */   public LARearRelationNewSet query(int nStart, int nCount)
/*      */   {
/*  741 */     Statement stmt = null;
/*  742 */     ResultSet rs = null;
/*  743 */     LARearRelationNewSet aLARearRelationNewSet = new LARearRelationNewSet();
/*      */ 
/*  745 */     if (!this.mflag) {
/*  746 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  751 */       stmt = this.con.createStatement(1003, 1007);
/*  752 */       SQLString sqlObj = new SQLString("LARearRelationNew");
/*  753 */       LARearRelationNewSchema aSchema = getSchema();
/*  754 */       sqlObj.setSQL(5, aSchema);
/*  755 */       String sql = sqlObj.getSQL();
/*      */ 
/*  757 */       rs = stmt.executeQuery(sql);
/*  758 */       int i = 0;
/*  759 */       while (rs.next())
/*      */       {
/*  761 */         i++;
/*      */ 
/*  763 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  767 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  771 */         LARearRelationNewSchema s1 = new LARearRelationNewSchema();
/*  772 */         s1.setSchema(rs, i);
/*  773 */         aLARearRelationNewSet.add(s1);
/*      */       }try {
/*  775 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  781 */       CError tError = new CError();
/*  782 */       tError.moduleName = "LARearRelationNewDB";
/*  783 */       tError.functionName = "query";
/*  784 */       tError.errorMessage = e.toString();
/*  785 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  787 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  790 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  794 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  800 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  804 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  809 */     return aLARearRelationNewSet;
/*      */   }
/*      */ 
/*      */   public LARearRelationNewSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  814 */     Statement stmt = null;
/*  815 */     ResultSet rs = null;
/*  816 */     LARearRelationNewSet aLARearRelationNewSet = new LARearRelationNewSet();
/*      */ 
/*  818 */     if (!this.mflag) {
/*  819 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  824 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  826 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  827 */       int i = 0;
/*  828 */       while (rs.next())
/*      */       {
/*  830 */         i++;
/*      */ 
/*  832 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  836 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  840 */         LARearRelationNewSchema s1 = new LARearRelationNewSchema();
/*  841 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  844 */           CError tError = new CError();
/*  845 */           tError.moduleName = "LARearRelationNewDB";
/*  846 */           tError.functionName = "executeQuery";
/*  847 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  848 */           this.mErrors.addOneError(tError);
/*      */         }
/*  850 */         aLARearRelationNewSet.add(s1);
/*      */       }try {
/*  852 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  858 */       CError tError = new CError();
/*  859 */       tError.moduleName = "LARearRelationNewDB";
/*  860 */       tError.functionName = "executeQuery";
/*  861 */       tError.errorMessage = e.toString();
/*  862 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  864 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  867 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  871 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  877 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  881 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  886 */     return aLARearRelationNewSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  891 */     Statement stmt = null;
/*      */ 
/*  893 */     if (!this.mflag) {
/*  894 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  899 */       stmt = this.con.createStatement(1003, 1007);
/*  900 */       SQLString sqlObj = new SQLString("LARearRelationNew");
/*  901 */       LARearRelationNewSchema aSchema = getSchema();
/*  902 */       sqlObj.setSQL(2, aSchema);
/*  903 */       String sql = "update LARearRelationNew " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  905 */       int operCount = stmt.executeUpdate(sql);
/*  906 */       if (operCount == 0)
/*      */       {
/*  909 */         CError tError = new CError();
/*  910 */         tError.moduleName = "LARearRelationNewDB";
/*  911 */         tError.functionName = "update";
/*  912 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  913 */         this.mErrors.addOneError(tError);
/*      */ 
/*  915 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  919 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  923 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  929 */       CError tError = new CError();
/*  930 */       tError.moduleName = "LARearRelationNewDB";
/*  931 */       tError.functionName = "update";
/*  932 */       tError.errorMessage = e.toString();
/*  933 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  935 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  937 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  941 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  945 */       return false;
/*      */     }
/*      */ 
/*  948 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  952 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  957 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  963 */     if (this.mResultSet != null)
/*      */     {
/*  966 */       CError tError = new CError();
/*  967 */       tError.moduleName = "LARearRelationNewDB";
/*  968 */       tError.functionName = "prepareData";
/*  969 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  970 */       this.mErrors.addOneError(tError);
/*  971 */       return false;
/*      */     }
/*      */ 
/*  974 */     if (!this.mflag)
/*      */     {
/*  976 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  980 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  981 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  986 */       CError tError = new CError();
/*  987 */       tError.moduleName = "LARearRelationNewDB";
/*  988 */       tError.functionName = "prepareData";
/*  989 */       tError.errorMessage = e.toString();
/*  990 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  993 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  999 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1003 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1007 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1012 */       return false;
/*      */     }
/*      */ 
/* 1015 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1019 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1024 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1030 */     boolean flag = true;
/* 1031 */     if (this.mResultSet == null)
/*      */     {
/* 1033 */       CError tError = new CError();
/* 1034 */       tError.moduleName = "LARearRelationNewDB";
/* 1035 */       tError.functionName = "hasMoreData";
/* 1036 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1037 */       this.mErrors.addOneError(tError);
/* 1038 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1042 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1046 */       CError tError = new CError();
/* 1047 */       tError.moduleName = "LARearRelationNewDB";
/* 1048 */       tError.functionName = "hasMoreData";
/* 1049 */       tError.errorMessage = ex.toString();
/* 1050 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1053 */         this.mResultSet.close();
/* 1054 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1060 */         this.mStatement.close();
/* 1061 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1065 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1069 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1074 */       return false;
/*      */     }
/* 1076 */     return flag;
/*      */   }
/*      */ 
/*      */   public LARearRelationNewSet getData()
/*      */   {
/* 1081 */     int tCount = 0;
/* 1082 */     LARearRelationNewSet tLARearRelationNewSet = new LARearRelationNewSet();
/* 1083 */     LARearRelationNewSchema tLARearRelationNewSchema = null;
/* 1084 */     if (this.mResultSet == null)
/*      */     {
/* 1086 */       CError tError = new CError();
/* 1087 */       tError.moduleName = "LARearRelationNewDB";
/* 1088 */       tError.functionName = "getData";
/* 1089 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1090 */       this.mErrors.addOneError(tError);
/* 1091 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1095 */       tCount = 1;
/* 1096 */       tLARearRelationNewSchema = new LARearRelationNewSchema();
/* 1097 */       tLARearRelationNewSchema.setSchema(this.mResultSet, 1);
/* 1098 */       tLARearRelationNewSet.add(tLARearRelationNewSchema);
/*      */ 
/* 1100 */       while (tCount++ < 5000)
/*      */       {
/* 1102 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1104 */         tLARearRelationNewSchema = new LARearRelationNewSchema();
/* 1105 */         tLARearRelationNewSchema.setSchema(this.mResultSet, 1);
/* 1106 */         tLARearRelationNewSet.add(tLARearRelationNewSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1112 */       CError tError = new CError();
/* 1113 */       tError.moduleName = "LARearRelationNewDB";
/* 1114 */       tError.functionName = "getData";
/* 1115 */       tError.errorMessage = ex.toString();
/* 1116 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1119 */         this.mResultSet.close();
/* 1120 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1126 */         this.mStatement.close();
/* 1127 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1131 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1135 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1140 */       return null;
/*      */     }
/* 1142 */     return tLARearRelationNewSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1147 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1150 */       if (this.mResultSet == null)
/*      */       {
/* 1152 */         CError tError = new CError();
/* 1153 */         tError.moduleName = "LARearRelationNewDB";
/* 1154 */         tError.functionName = "closeData";
/* 1155 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1156 */         this.mErrors.addOneError(tError);
/* 1157 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1161 */         this.mResultSet.close();
/* 1162 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1167 */       CError tError = new CError();
/* 1168 */       tError.moduleName = "LARearRelationNewDB";
/* 1169 */       tError.functionName = "closeData";
/* 1170 */       tError.errorMessage = ex2.toString();
/* 1171 */       this.mErrors.addOneError(tError);
/* 1172 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1176 */       if (this.mStatement == null)
/*      */       {
/* 1178 */         CError tError = new CError();
/* 1179 */         tError.moduleName = "LARearRelationNewDB";
/* 1180 */         tError.functionName = "closeData";
/* 1181 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1182 */         this.mErrors.addOneError(tError);
/* 1183 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1187 */         this.mStatement.close();
/* 1188 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1193 */       CError tError = new CError();
/* 1194 */       tError.moduleName = "LARearRelationNewDB";
/* 1195 */       tError.functionName = "closeData";
/* 1196 */       tError.errorMessage = ex3.toString();
/* 1197 */       this.mErrors.addOneError(tError);
/* 1198 */       flag = false;
/*      */     }
/* 1200 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.LARearRelationNewDB
 * JD-Core Version:    0.6.0
 */