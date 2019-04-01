/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MRoleInfoBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MRoleInfoBSet;
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
/*      */ public class MRoleInfoBDB extends MRoleInfoBSchema
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
/*      */   public MRoleInfoBDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MRoleInfoB");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MRoleInfoBDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MRoleInfoB");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MRoleInfoBSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MRoleInfoBDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MRoleInfoBSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MRoleInfoBDB";
/*   74 */       tError.functionName = "getCount";
/*   75 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   76 */       this.mErrors.addOneError(tError);
/*      */ 
/*   78 */       return -1;
/*      */     }
/*      */ 
/*   81 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   86 */     PreparedStatement pstmt = null;
/*      */ 
/*   88 */     if (!this.mflag) {
/*   89 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MRoleInfoB WHERE  EdorNo = ?");
/*   95 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*   96 */         pstmt.setNull(1, 12);
/*      */       else {
/*   98 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  100 */       pstmt.executeUpdate();
/*  101 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "MRoleInfoBDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MRoleInfoB SET  ID = ? , RoleCode = ? , Name = ? , Parent = ? , Describe = ? , RoleState = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc3 = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/*  144 */       if ((getID() == null) || (getID().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getID());
/*      */       }
/*  149 */       if ((getRoleCode() == null) || (getRoleCode().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getRoleCode());
/*      */       }
/*  154 */       if ((getName() == null) || (getName().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getName());
/*      */       }
/*  159 */       if ((getParent() == null) || (getParent().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getParent());
/*      */       }
/*  164 */       if ((getDescribe() == null) || (getDescribe().equals("null")))
/*  165 */         pstmt.setNull(5, 12);
/*      */       else {
/*  167 */         pstmt.setString(5, getDescribe());
/*      */       }
/*  169 */       if ((getRoleState() == null) || (getRoleState().equals("null")))
/*  170 */         pstmt.setNull(6, 12);
/*      */       else {
/*  172 */         pstmt.setString(6, getRoleState());
/*      */       }
/*  174 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getOperator());
/*      */       }
/*  179 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  180 */         pstmt.setNull(8, 91);
/*      */       else {
/*  182 */         pstmt.setDate(8, Date.valueOf(getMakeDate()));
/*      */       }
/*  184 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  185 */         pstmt.setNull(9, 12);
/*      */       else {
/*  187 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  189 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  190 */         pstmt.setNull(10, 91);
/*      */       else {
/*  192 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  194 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  195 */         pstmt.setNull(11, 12);
/*      */       else {
/*  197 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*  199 */       pstmt.setInt(12, getInt1());
/*  200 */       pstmt.setInt(13, getInt2());
/*  201 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  202 */         pstmt.setNull(14, 12);
/*      */       else {
/*  204 */         pstmt.setString(14, getVarc1());
/*      */       }
/*  206 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  207 */         pstmt.setNull(15, 12);
/*      */       else {
/*  209 */         pstmt.setString(15, getVarc2());
/*      */       }
/*  211 */       if ((getVarc3() == null) || (getVarc3().equals("null")))
/*  212 */         pstmt.setNull(16, 12);
/*      */       else {
/*  214 */         pstmt.setString(16, getVarc3());
/*      */       }
/*  216 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  217 */         pstmt.setNull(17, 12);
/*      */       else {
/*  219 */         pstmt.setString(17, getEdorNo());
/*      */       }
/*  221 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  222 */         pstmt.setNull(18, 12);
/*      */       else {
/*  224 */         pstmt.setString(18, getEdorType());
/*      */       }
/*  226 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  227 */         pstmt.setNull(19, 12);
/*      */       else {
/*  229 */         pstmt.setString(19, getEdorCase());
/*      */       }
/*  231 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  232 */         pstmt.setNull(20, 12);
/*      */       else {
/*  234 */         pstmt.setString(20, getOperator2());
/*      */       }
/*  236 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  237 */         pstmt.setNull(21, 91);
/*      */       else {
/*  239 */         pstmt.setDate(21, Date.valueOf(getMakeDate2()));
/*      */       }
/*  241 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  242 */         pstmt.setNull(22, 12);
/*      */       else {
/*  244 */         pstmt.setString(22, getMakeTime2());
/*      */       }
/*      */ 
/*  247 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  248 */         pstmt.setNull(23, 12);
/*      */       else {
/*  250 */         pstmt.setString(23, getEdorNo());
/*      */       }
/*  252 */       pstmt.executeUpdate();
/*  253 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  256 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  257 */       CError tError = new CError();
/*  258 */       tError.moduleName = "MRoleInfoBDB";
/*  259 */       tError.functionName = "update()";
/*  260 */       tError.errorMessage = ex.toString();
/*  261 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  264 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  267 */       if (!this.mflag)
/*      */         try {
/*  269 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  273 */       return false;
/*      */     }
/*      */ 
/*  276 */     if (!this.mflag)
/*      */       try {
/*  278 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  282 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  287 */     PreparedStatement pstmt = null;
/*      */ 
/*  289 */     if (!this.mflag) {
/*  290 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  295 */       pstmt = this.con.prepareStatement("INSERT INTO MRoleInfoB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  296 */       if ((getID() == null) || (getID().equals("null")))
/*  297 */         pstmt.setNull(1, 12);
/*      */       else {
/*  299 */         pstmt.setString(1, getID());
/*      */       }
/*  301 */       if ((getRoleCode() == null) || (getRoleCode().equals("null")))
/*  302 */         pstmt.setNull(2, 12);
/*      */       else {
/*  304 */         pstmt.setString(2, getRoleCode());
/*      */       }
/*  306 */       if ((getName() == null) || (getName().equals("null")))
/*  307 */         pstmt.setNull(3, 12);
/*      */       else {
/*  309 */         pstmt.setString(3, getName());
/*      */       }
/*  311 */       if ((getParent() == null) || (getParent().equals("null")))
/*  312 */         pstmt.setNull(4, 12);
/*      */       else {
/*  314 */         pstmt.setString(4, getParent());
/*      */       }
/*  316 */       if ((getDescribe() == null) || (getDescribe().equals("null")))
/*  317 */         pstmt.setNull(5, 12);
/*      */       else {
/*  319 */         pstmt.setString(5, getDescribe());
/*      */       }
/*  321 */       if ((getRoleState() == null) || (getRoleState().equals("null")))
/*  322 */         pstmt.setNull(6, 12);
/*      */       else {
/*  324 */         pstmt.setString(6, getRoleState());
/*      */       }
/*  326 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  327 */         pstmt.setNull(7, 12);
/*      */       else {
/*  329 */         pstmt.setString(7, getOperator());
/*      */       }
/*  331 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  332 */         pstmt.setNull(8, 91);
/*      */       else {
/*  334 */         pstmt.setDate(8, Date.valueOf(getMakeDate()));
/*      */       }
/*  336 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  337 */         pstmt.setNull(9, 12);
/*      */       else {
/*  339 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  341 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  342 */         pstmt.setNull(10, 91);
/*      */       else {
/*  344 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  346 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  347 */         pstmt.setNull(11, 12);
/*      */       else {
/*  349 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*  351 */       pstmt.setInt(12, getInt1());
/*  352 */       pstmt.setInt(13, getInt2());
/*  353 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  354 */         pstmt.setNull(14, 12);
/*      */       else {
/*  356 */         pstmt.setString(14, getVarc1());
/*      */       }
/*  358 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  359 */         pstmt.setNull(15, 12);
/*      */       else {
/*  361 */         pstmt.setString(15, getVarc2());
/*      */       }
/*  363 */       if ((getVarc3() == null) || (getVarc3().equals("null")))
/*  364 */         pstmt.setNull(16, 12);
/*      */       else {
/*  366 */         pstmt.setString(16, getVarc3());
/*      */       }
/*  368 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  369 */         pstmt.setNull(17, 12);
/*      */       else {
/*  371 */         pstmt.setString(17, getEdorNo());
/*      */       }
/*  373 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  374 */         pstmt.setNull(18, 12);
/*      */       else {
/*  376 */         pstmt.setString(18, getEdorType());
/*      */       }
/*  378 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  379 */         pstmt.setNull(19, 12);
/*      */       else {
/*  381 */         pstmt.setString(19, getEdorCase());
/*      */       }
/*  383 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  384 */         pstmt.setNull(20, 12);
/*      */       else {
/*  386 */         pstmt.setString(20, getOperator2());
/*      */       }
/*  388 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  389 */         pstmt.setNull(21, 91);
/*      */       else {
/*  391 */         pstmt.setDate(21, Date.valueOf(getMakeDate2()));
/*      */       }
/*  393 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  394 */         pstmt.setNull(22, 12);
/*      */       else {
/*  396 */         pstmt.setString(22, getMakeTime2());
/*      */       }
/*      */ 
/*  399 */       pstmt.executeUpdate();
/*  400 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  403 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  404 */       CError tError = new CError();
/*  405 */       tError.moduleName = "MRoleInfoBDB";
/*  406 */       tError.functionName = "insert()";
/*  407 */       tError.errorMessage = ex.toString();
/*  408 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  411 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  414 */       if (!this.mflag)
/*      */         try {
/*  416 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  420 */       return false;
/*      */     }
/*      */ 
/*  423 */     if (!this.mflag)
/*      */       try {
/*  425 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  429 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  434 */     PreparedStatement pstmt = null;
/*  435 */     ResultSet rs = null;
/*      */ 
/*  437 */     if (!this.mflag) {
/*  438 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  443 */       pstmt = this.con.prepareStatement("SELECT * FROM MRoleInfoB WHERE  EdorNo = ?", 
/*  444 */         1003, 1007);
/*  445 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  446 */         pstmt.setNull(1, 12);
/*      */       else {
/*  448 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  450 */       rs = pstmt.executeQuery();
/*  451 */       int i = 0;
/*  452 */       if (rs.next())
/*      */       {
/*  454 */         i++;
/*  455 */         if (!setSchema(rs, i))
/*      */         {
/*  458 */           CError tError = new CError();
/*  459 */           tError.moduleName = "MRoleInfoBDB";
/*  460 */           tError.functionName = "getInfo";
/*  461 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  462 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  464 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  467 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  471 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  475 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  479 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  482 */       if (i == 0)
/*      */       {
/*  484 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  488 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  492 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  498 */       CError tError = new CError();
/*  499 */       tError.moduleName = "MRoleInfoBDB";
/*  500 */       tError.functionName = "getInfo";
/*  501 */       tError.errorMessage = e.toString();
/*  502 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  504 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  507 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  511 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  515 */       return false;
/*      */     }
/*      */ 
/*  518 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  522 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  527 */     return true;
/*      */   }
/*      */ 
/*      */   public MRoleInfoBSet query()
/*      */   {
/*  532 */     Statement stmt = null;
/*  533 */     ResultSet rs = null;
/*  534 */     MRoleInfoBSet aMRoleInfoBSet = new MRoleInfoBSet();
/*      */ 
/*  536 */     if (!this.mflag) {
/*  537 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  542 */       stmt = this.con.createStatement(1003, 1007);
/*  543 */       SQLString sqlObj = new SQLString("MRoleInfoB");
/*  544 */       MRoleInfoBSchema aSchema = getSchema();
/*  545 */       sqlObj.setSQL(5, aSchema);
/*  546 */       String sql = sqlObj.getSQL();
/*      */ 
/*  548 */       rs = stmt.executeQuery(sql);
/*  549 */       int i = 0;
/*  550 */       while (rs.next())
/*      */       {
/*  552 */         i++;
/*  553 */         MRoleInfoBSchema s1 = new MRoleInfoBSchema();
/*  554 */         s1.setSchema(rs, i);
/*  555 */         aMRoleInfoBSet.add(s1);
/*      */       }try {
/*  557 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  563 */       CError tError = new CError();
/*  564 */       tError.moduleName = "MRoleInfoBDB";
/*  565 */       tError.functionName = "query";
/*  566 */       tError.errorMessage = e.toString();
/*  567 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  569 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  572 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  576 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  582 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  586 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  591 */     return aMRoleInfoBSet;
/*      */   }
/*      */ 
/*      */   public MRoleInfoBSet executeQuery(String sql)
/*      */   {
/*  596 */     Statement stmt = null;
/*  597 */     ResultSet rs = null;
/*  598 */     MRoleInfoBSet aMRoleInfoBSet = new MRoleInfoBSet();
/*      */ 
/*  600 */     if (!this.mflag) {
/*  601 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  606 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  608 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  609 */       int i = 0;
/*  610 */       while (rs.next())
/*      */       {
/*  612 */         i++;
/*  613 */         MRoleInfoBSchema s1 = new MRoleInfoBSchema();
/*  614 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  617 */           CError tError = new CError();
/*  618 */           tError.moduleName = "MRoleInfoBDB";
/*  619 */           tError.functionName = "executeQuery";
/*  620 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  621 */           this.mErrors.addOneError(tError);
/*      */         }
/*  623 */         aMRoleInfoBSet.add(s1);
/*      */       }try {
/*  625 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  631 */       CError tError = new CError();
/*  632 */       tError.moduleName = "MRoleInfoBDB";
/*  633 */       tError.functionName = "executeQuery";
/*  634 */       tError.errorMessage = e.toString();
/*  635 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  637 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  640 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  644 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  650 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  654 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  659 */     return aMRoleInfoBSet;
/*      */   }
/*      */ 
/*      */   public MRoleInfoBSet query(int nStart, int nCount)
/*      */   {
/*  664 */     Statement stmt = null;
/*  665 */     ResultSet rs = null;
/*  666 */     MRoleInfoBSet aMRoleInfoBSet = new MRoleInfoBSet();
/*      */ 
/*  668 */     if (!this.mflag) {
/*  669 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  674 */       stmt = this.con.createStatement(1003, 1007);
/*  675 */       SQLString sqlObj = new SQLString("MRoleInfoB");
/*  676 */       MRoleInfoBSchema aSchema = getSchema();
/*  677 */       sqlObj.setSQL(5, aSchema);
/*  678 */       String sql = sqlObj.getSQL();
/*      */ 
/*  680 */       rs = stmt.executeQuery(sql);
/*  681 */       int i = 0;
/*  682 */       while (rs.next())
/*      */       {
/*  684 */         i++;
/*      */ 
/*  686 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  690 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  694 */         MRoleInfoBSchema s1 = new MRoleInfoBSchema();
/*  695 */         s1.setSchema(rs, i);
/*  696 */         aMRoleInfoBSet.add(s1);
/*      */       }try {
/*  698 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  704 */       CError tError = new CError();
/*  705 */       tError.moduleName = "MRoleInfoBDB";
/*  706 */       tError.functionName = "query";
/*  707 */       tError.errorMessage = e.toString();
/*  708 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  710 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  713 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  717 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  723 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  727 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  732 */     return aMRoleInfoBSet;
/*      */   }
/*      */ 
/*      */   public MRoleInfoBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  737 */     Statement stmt = null;
/*  738 */     ResultSet rs = null;
/*  739 */     MRoleInfoBSet aMRoleInfoBSet = new MRoleInfoBSet();
/*      */ 
/*  741 */     if (!this.mflag) {
/*  742 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  747 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  749 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  750 */       int i = 0;
/*  751 */       while (rs.next())
/*      */       {
/*  753 */         i++;
/*      */ 
/*  755 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  759 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  763 */         MRoleInfoBSchema s1 = new MRoleInfoBSchema();
/*  764 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  767 */           CError tError = new CError();
/*  768 */           tError.moduleName = "MRoleInfoBDB";
/*  769 */           tError.functionName = "executeQuery";
/*  770 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  771 */           this.mErrors.addOneError(tError);
/*      */         }
/*  773 */         aMRoleInfoBSet.add(s1);
/*      */       }try {
/*  775 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  781 */       CError tError = new CError();
/*  782 */       tError.moduleName = "MRoleInfoBDB";
/*  783 */       tError.functionName = "executeQuery";
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
/*  809 */     return aMRoleInfoBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  814 */     Statement stmt = null;
/*      */ 
/*  816 */     if (!this.mflag) {
/*  817 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  822 */       stmt = this.con.createStatement(1003, 1007);
/*  823 */       SQLString sqlObj = new SQLString("MRoleInfoB");
/*  824 */       MRoleInfoBSchema aSchema = getSchema();
/*  825 */       sqlObj.setSQL(2, aSchema);
/*  826 */       String sql = "update MRoleInfoB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  828 */       int operCount = stmt.executeUpdate(sql);
/*  829 */       if (operCount == 0)
/*      */       {
/*  832 */         CError tError = new CError();
/*  833 */         tError.moduleName = "MRoleInfoBDB";
/*  834 */         tError.functionName = "update";
/*  835 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  836 */         this.mErrors.addOneError(tError);
/*      */ 
/*  838 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  842 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  846 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  852 */       CError tError = new CError();
/*  853 */       tError.moduleName = "MRoleInfoBDB";
/*  854 */       tError.functionName = "update";
/*  855 */       tError.errorMessage = e.toString();
/*  856 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  858 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  860 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  864 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  868 */       return false;
/*      */     }
/*      */ 
/*  871 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  875 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  880 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  886 */     if (this.mResultSet != null)
/*      */     {
/*  889 */       CError tError = new CError();
/*  890 */       tError.moduleName = "MRoleInfoBDB";
/*  891 */       tError.functionName = "prepareData";
/*  892 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  893 */       this.mErrors.addOneError(tError);
/*  894 */       return false;
/*      */     }
/*      */ 
/*  897 */     if (!this.mflag)
/*      */     {
/*  899 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  903 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  904 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  909 */       CError tError = new CError();
/*  910 */       tError.moduleName = "MRoleInfoBDB";
/*  911 */       tError.functionName = "prepareData";
/*  912 */       tError.errorMessage = e.toString();
/*  913 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  916 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  922 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  926 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  930 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  935 */       return false;
/*      */     }
/*      */ 
/*  938 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  942 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  947 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  953 */     boolean flag = true;
/*  954 */     if (this.mResultSet == null)
/*      */     {
/*  956 */       CError tError = new CError();
/*  957 */       tError.moduleName = "MRoleInfoBDB";
/*  958 */       tError.functionName = "hasMoreData";
/*  959 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  960 */       this.mErrors.addOneError(tError);
/*  961 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  965 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  969 */       CError tError = new CError();
/*  970 */       tError.moduleName = "MRoleInfoBDB";
/*  971 */       tError.functionName = "hasMoreData";
/*  972 */       tError.errorMessage = ex.toString();
/*  973 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  976 */         this.mResultSet.close();
/*  977 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  983 */         this.mStatement.close();
/*  984 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  988 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  992 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  997 */       return false;
/*      */     }
/*  999 */     return flag;
/*      */   }
/*      */ 
/*      */   public MRoleInfoBSet getData()
/*      */   {
/* 1004 */     int tCount = 0;
/* 1005 */     MRoleInfoBSet tMRoleInfoBSet = new MRoleInfoBSet();
/* 1006 */     MRoleInfoBSchema tMRoleInfoBSchema = null;
/* 1007 */     if (this.mResultSet == null)
/*      */     {
/* 1009 */       CError tError = new CError();
/* 1010 */       tError.moduleName = "MRoleInfoBDB";
/* 1011 */       tError.functionName = "getData";
/* 1012 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1013 */       this.mErrors.addOneError(tError);
/* 1014 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1018 */       tCount = 1;
/* 1019 */       tMRoleInfoBSchema = new MRoleInfoBSchema();
/* 1020 */       tMRoleInfoBSchema.setSchema(this.mResultSet, 1);
/* 1021 */       tMRoleInfoBSet.add(tMRoleInfoBSchema);
/*      */ 
/* 1023 */       while (tCount++ < 5000)
/*      */       {
/* 1025 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1027 */         tMRoleInfoBSchema = new MRoleInfoBSchema();
/* 1028 */         tMRoleInfoBSchema.setSchema(this.mResultSet, 1);
/* 1029 */         tMRoleInfoBSet.add(tMRoleInfoBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1035 */       CError tError = new CError();
/* 1036 */       tError.moduleName = "MRoleInfoBDB";
/* 1037 */       tError.functionName = "getData";
/* 1038 */       tError.errorMessage = ex.toString();
/* 1039 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1042 */         this.mResultSet.close();
/* 1043 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1049 */         this.mStatement.close();
/* 1050 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1054 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1058 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1063 */       return null;
/*      */     }
/* 1065 */     return tMRoleInfoBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1070 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1073 */       if (this.mResultSet == null)
/*      */       {
/* 1075 */         CError tError = new CError();
/* 1076 */         tError.moduleName = "MRoleInfoBDB";
/* 1077 */         tError.functionName = "closeData";
/* 1078 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1079 */         this.mErrors.addOneError(tError);
/* 1080 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1084 */         this.mResultSet.close();
/* 1085 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1090 */       CError tError = new CError();
/* 1091 */       tError.moduleName = "MRoleInfoBDB";
/* 1092 */       tError.functionName = "closeData";
/* 1093 */       tError.errorMessage = ex2.toString();
/* 1094 */       this.mErrors.addOneError(tError);
/* 1095 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1099 */       if (this.mStatement == null)
/*      */       {
/* 1101 */         CError tError = new CError();
/* 1102 */         tError.moduleName = "MRoleInfoBDB";
/* 1103 */         tError.functionName = "closeData";
/* 1104 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1105 */         this.mErrors.addOneError(tError);
/* 1106 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1110 */         this.mStatement.close();
/* 1111 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1116 */       CError tError = new CError();
/* 1117 */       tError.moduleName = "MRoleInfoBDB";
/* 1118 */       tError.functionName = "closeData";
/* 1119 */       tError.errorMessage = ex3.toString();
/* 1120 */       this.mErrors.addOneError(tError);
/* 1121 */       flag = false;
/*      */     }
/* 1123 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MRoleInfoBDB
 * JD-Core Version:    0.6.0
 */