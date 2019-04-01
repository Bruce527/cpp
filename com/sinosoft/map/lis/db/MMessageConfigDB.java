/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MMessageConfigSchema;
/*      */ import com.sinosoft.map.lis.vschema.MMessageConfigSet;
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
/*      */ public class MMessageConfigDB extends MMessageConfigSchema
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
/*      */   public MMessageConfigDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MMessageConfig");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MMessageConfigDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MMessageConfig");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MMessageConfigSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MMessageConfigDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MMessageConfigSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MMessageConfigDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MMessageConfig WHERE  ID = ?");
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
/*  107 */       tError.moduleName = "MMessageConfigDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MMessageConfig SET  ID = ? , ManageCom = ? , BranchType = ? , MessageType = ? , MessageName = ? , MessageContent = ? , MessageContent2 = ? , MessageContent3 = ? , MessageContent4 = ? , MessageContent5 = ? , MessageContent6 = ? , BeforeDays = ? , StatDays = ? , StartDate = ? , EndDate = ? , StatCycle = ? , Script = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
/*  145 */       if ((getID() == null) || (getID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getID());
/*      */       }
/*  150 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getManageCom());
/*      */       }
/*  155 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getBranchType());
/*      */       }
/*  160 */       if ((getMessageType() == null) || (getMessageType().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getMessageType());
/*      */       }
/*  165 */       if ((getMessageName() == null) || (getMessageName().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getMessageName());
/*      */       }
/*  170 */       if ((getMessageContent() == null) || (getMessageContent().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getMessageContent());
/*      */       }
/*  175 */       if ((getMessageContent2() == null) || (getMessageContent2().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getMessageContent2());
/*      */       }
/*  180 */       if ((getMessageContent3() == null) || (getMessageContent3().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getMessageContent3());
/*      */       }
/*  185 */       if ((getMessageContent4() == null) || (getMessageContent4().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getMessageContent4());
/*      */       }
/*  190 */       if ((getMessageContent5() == null) || (getMessageContent5().equals("null")))
/*  191 */         pstmt.setNull(10, 12);
/*      */       else {
/*  193 */         pstmt.setString(10, getMessageContent5());
/*      */       }
/*  195 */       if ((getMessageContent6() == null) || (getMessageContent6().equals("null")))
/*  196 */         pstmt.setNull(11, 12);
/*      */       else {
/*  198 */         pstmt.setString(11, getMessageContent6());
/*      */       }
/*  200 */       pstmt.setInt(12, getBeforeDays());
/*  201 */       pstmt.setInt(13, getStatDays());
/*  202 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  203 */         pstmt.setNull(14, 91);
/*      */       else {
/*  205 */         pstmt.setDate(14, Date.valueOf(getStartDate()));
/*      */       }
/*  207 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  208 */         pstmt.setNull(15, 91);
/*      */       else {
/*  210 */         pstmt.setDate(15, Date.valueOf(getEndDate()));
/*      */       }
/*  212 */       if ((getStatCycle() == null) || (getStatCycle().equals("null")))
/*  213 */         pstmt.setNull(16, 12);
/*      */       else {
/*  215 */         pstmt.setString(16, getStatCycle());
/*      */       }
/*  217 */       if ((getScript() == null) || (getScript().equals("null")))
/*  218 */         pstmt.setNull(17, 12);
/*      */       else {
/*  220 */         pstmt.setString(17, getScript());
/*      */       }
/*  222 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  223 */         pstmt.setNull(18, 12);
/*      */       else {
/*  225 */         pstmt.setString(18, getVF01());
/*      */       }
/*  227 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  228 */         pstmt.setNull(19, 12);
/*      */       else {
/*  230 */         pstmt.setString(19, getNF01());
/*      */       }
/*  232 */       pstmt.setInt(20, getIF01());
/*  233 */       pstmt.setDouble(21, getDF02());
/*  234 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  235 */         pstmt.setNull(22, 91);
/*      */       else {
/*  237 */         pstmt.setDate(22, Date.valueOf(getDate01()));
/*      */       }
/*  239 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  240 */         pstmt.setNull(23, 12);
/*      */       else {
/*  242 */         pstmt.setString(23, getOperator());
/*      */       }
/*  244 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  245 */         pstmt.setNull(24, 91);
/*      */       else {
/*  247 */         pstmt.setDate(24, Date.valueOf(getMakeDate()));
/*      */       }
/*  249 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  250 */         pstmt.setNull(25, 12);
/*      */       else {
/*  252 */         pstmt.setString(25, getMakeTime());
/*      */       }
/*      */ 
/*  255 */       if ((getID() == null) || (getID().equals("null")))
/*  256 */         pstmt.setNull(26, 12);
/*      */       else {
/*  258 */         pstmt.setString(26, getID());
/*      */       }
/*  260 */       pstmt.executeUpdate();
/*  261 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  264 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  265 */       CError tError = new CError();
/*  266 */       tError.moduleName = "MMessageConfigDB";
/*  267 */       tError.functionName = "update()";
/*  268 */       tError.errorMessage = ex.toString();
/*  269 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  272 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  275 */       if (!this.mflag)
/*      */         try {
/*  277 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  281 */       return false;
/*      */     }
/*      */ 
/*  284 */     if (!this.mflag)
/*      */       try {
/*  286 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  290 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  295 */     PreparedStatement pstmt = null;
/*      */ 
/*  297 */     if (!this.mflag) {
/*  298 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  303 */       pstmt = this.con.prepareStatement("INSERT INTO MMessageConfig VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  304 */       if ((getID() == null) || (getID().equals("null")))
/*  305 */         pstmt.setNull(1, 12);
/*      */       else {
/*  307 */         pstmt.setString(1, getID());
/*      */       }
/*  309 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  310 */         pstmt.setNull(2, 12);
/*      */       else {
/*  312 */         pstmt.setString(2, getManageCom());
/*      */       }
/*  314 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  315 */         pstmt.setNull(3, 12);
/*      */       else {
/*  317 */         pstmt.setString(3, getBranchType());
/*      */       }
/*  319 */       if ((getMessageType() == null) || (getMessageType().equals("null")))
/*  320 */         pstmt.setNull(4, 12);
/*      */       else {
/*  322 */         pstmt.setString(4, getMessageType());
/*      */       }
/*  324 */       if ((getMessageName() == null) || (getMessageName().equals("null")))
/*  325 */         pstmt.setNull(5, 12);
/*      */       else {
/*  327 */         pstmt.setString(5, getMessageName());
/*      */       }
/*  329 */       if ((getMessageContent() == null) || (getMessageContent().equals("null")))
/*  330 */         pstmt.setNull(6, 12);
/*      */       else {
/*  332 */         pstmt.setString(6, getMessageContent());
/*      */       }
/*  334 */       if ((getMessageContent2() == null) || (getMessageContent2().equals("null")))
/*  335 */         pstmt.setNull(7, 12);
/*      */       else {
/*  337 */         pstmt.setString(7, getMessageContent2());
/*      */       }
/*  339 */       if ((getMessageContent3() == null) || (getMessageContent3().equals("null")))
/*  340 */         pstmt.setNull(8, 12);
/*      */       else {
/*  342 */         pstmt.setString(8, getMessageContent3());
/*      */       }
/*  344 */       if ((getMessageContent4() == null) || (getMessageContent4().equals("null")))
/*  345 */         pstmt.setNull(9, 12);
/*      */       else {
/*  347 */         pstmt.setString(9, getMessageContent4());
/*      */       }
/*  349 */       if ((getMessageContent5() == null) || (getMessageContent5().equals("null")))
/*  350 */         pstmt.setNull(10, 12);
/*      */       else {
/*  352 */         pstmt.setString(10, getMessageContent5());
/*      */       }
/*  354 */       if ((getMessageContent6() == null) || (getMessageContent6().equals("null")))
/*  355 */         pstmt.setNull(11, 12);
/*      */       else {
/*  357 */         pstmt.setString(11, getMessageContent6());
/*      */       }
/*  359 */       pstmt.setInt(12, getBeforeDays());
/*  360 */       pstmt.setInt(13, getStatDays());
/*  361 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  362 */         pstmt.setNull(14, 91);
/*      */       else {
/*  364 */         pstmt.setDate(14, Date.valueOf(getStartDate()));
/*      */       }
/*  366 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  367 */         pstmt.setNull(15, 91);
/*      */       else {
/*  369 */         pstmt.setDate(15, Date.valueOf(getEndDate()));
/*      */       }
/*  371 */       if ((getStatCycle() == null) || (getStatCycle().equals("null")))
/*  372 */         pstmt.setNull(16, 12);
/*      */       else {
/*  374 */         pstmt.setString(16, getStatCycle());
/*      */       }
/*  376 */       if ((getScript() == null) || (getScript().equals("null")))
/*  377 */         pstmt.setNull(17, 12);
/*      */       else {
/*  379 */         pstmt.setString(17, getScript());
/*      */       }
/*  381 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  382 */         pstmt.setNull(18, 12);
/*      */       else {
/*  384 */         pstmt.setString(18, getVF01());
/*      */       }
/*  386 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  387 */         pstmt.setNull(19, 12);
/*      */       else {
/*  389 */         pstmt.setString(19, getNF01());
/*      */       }
/*  391 */       pstmt.setInt(20, getIF01());
/*  392 */       pstmt.setDouble(21, getDF02());
/*  393 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  394 */         pstmt.setNull(22, 91);
/*      */       else {
/*  396 */         pstmt.setDate(22, Date.valueOf(getDate01()));
/*      */       }
/*  398 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  399 */         pstmt.setNull(23, 12);
/*      */       else {
/*  401 */         pstmt.setString(23, getOperator());
/*      */       }
/*  403 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  404 */         pstmt.setNull(24, 91);
/*      */       else {
/*  406 */         pstmt.setDate(24, Date.valueOf(getMakeDate()));
/*      */       }
/*  408 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  409 */         pstmt.setNull(25, 12);
/*      */       else {
/*  411 */         pstmt.setString(25, getMakeTime());
/*      */       }
/*      */ 
/*  414 */       pstmt.executeUpdate();
/*  415 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  418 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  419 */       CError tError = new CError();
/*  420 */       tError.moduleName = "MMessageConfigDB";
/*  421 */       tError.functionName = "insert()";
/*  422 */       tError.errorMessage = ex.toString();
/*  423 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  426 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  429 */       if (!this.mflag)
/*      */         try {
/*  431 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  435 */       return false;
/*      */     }
/*      */ 
/*  438 */     if (!this.mflag)
/*      */       try {
/*  440 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  444 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  449 */     PreparedStatement pstmt = null;
/*  450 */     ResultSet rs = null;
/*      */ 
/*  452 */     if (!this.mflag) {
/*  453 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  458 */       pstmt = this.con.prepareStatement("SELECT * FROM MMessageConfig WHERE  ID = ?", 
/*  459 */         1003, 1007);
/*  460 */       if ((getID() == null) || (getID().equals("null")))
/*  461 */         pstmt.setNull(1, 12);
/*      */       else {
/*  463 */         pstmt.setString(1, getID());
/*      */       }
/*  465 */       rs = pstmt.executeQuery();
/*  466 */       int i = 0;
/*  467 */       if (rs.next())
/*      */       {
/*  469 */         i++;
/*  470 */         if (!setSchema(rs, i))
/*      */         {
/*  473 */           CError tError = new CError();
/*  474 */           tError.moduleName = "MMessageConfigDB";
/*  475 */           tError.functionName = "getInfo";
/*  476 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  477 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  479 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  482 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  486 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  490 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  494 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  497 */       if (i == 0)
/*      */       {
/*  499 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  503 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  507 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  513 */       CError tError = new CError();
/*  514 */       tError.moduleName = "MMessageConfigDB";
/*  515 */       tError.functionName = "getInfo";
/*  516 */       tError.errorMessage = e.toString();
/*  517 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  519 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  522 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  526 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  530 */       return false;
/*      */     }
/*      */ 
/*  533 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  537 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  542 */     return true;
/*      */   }
/*      */ 
/*      */   public MMessageConfigSet query()
/*      */   {
/*  547 */     Statement stmt = null;
/*  548 */     ResultSet rs = null;
/*  549 */     MMessageConfigSet aMMessageConfigSet = new MMessageConfigSet();
/*      */ 
/*  551 */     if (!this.mflag) {
/*  552 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  557 */       stmt = this.con.createStatement(1003, 1007);
/*  558 */       SQLString sqlObj = new SQLString("MMessageConfig");
/*  559 */       MMessageConfigSchema aSchema = getSchema();
/*  560 */       sqlObj.setSQL(5, aSchema);
/*  561 */       String sql = sqlObj.getSQL();
/*      */ 
/*  563 */       rs = stmt.executeQuery(sql);
/*  564 */       int i = 0;
/*  565 */       while (rs.next())
/*      */       {
/*  567 */         i++;
/*  568 */         MMessageConfigSchema s1 = new MMessageConfigSchema();
/*  569 */         s1.setSchema(rs, i);
/*  570 */         aMMessageConfigSet.add(s1);
/*      */       }try {
/*  572 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  578 */       CError tError = new CError();
/*  579 */       tError.moduleName = "MMessageConfigDB";
/*  580 */       tError.functionName = "query";
/*  581 */       tError.errorMessage = e.toString();
/*  582 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  584 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  587 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  591 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  597 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  601 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  606 */     return aMMessageConfigSet;
/*      */   }
/*      */ 
/*      */   public MMessageConfigSet executeQuery(String sql)
/*      */   {
/*  611 */     Statement stmt = null;
/*  612 */     ResultSet rs = null;
/*  613 */     MMessageConfigSet aMMessageConfigSet = new MMessageConfigSet();
/*      */ 
/*  615 */     if (!this.mflag) {
/*  616 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  621 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  623 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  624 */       int i = 0;
/*  625 */       while (rs.next())
/*      */       {
/*  627 */         i++;
/*  628 */         MMessageConfigSchema s1 = new MMessageConfigSchema();
/*  629 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  632 */           CError tError = new CError();
/*  633 */           tError.moduleName = "MMessageConfigDB";
/*  634 */           tError.functionName = "executeQuery";
/*  635 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  636 */           this.mErrors.addOneError(tError);
/*      */         }
/*  638 */         aMMessageConfigSet.add(s1);
/*      */       }try {
/*  640 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  646 */       CError tError = new CError();
/*  647 */       tError.moduleName = "MMessageConfigDB";
/*  648 */       tError.functionName = "executeQuery";
/*  649 */       tError.errorMessage = e.toString();
/*  650 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  652 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  655 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  659 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  665 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  669 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  674 */     return aMMessageConfigSet;
/*      */   }
/*      */ 
/*      */   public MMessageConfigSet query(int nStart, int nCount)
/*      */   {
/*  679 */     Statement stmt = null;
/*  680 */     ResultSet rs = null;
/*  681 */     MMessageConfigSet aMMessageConfigSet = new MMessageConfigSet();
/*      */ 
/*  683 */     if (!this.mflag) {
/*  684 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  689 */       stmt = this.con.createStatement(1003, 1007);
/*  690 */       SQLString sqlObj = new SQLString("MMessageConfig");
/*  691 */       MMessageConfigSchema aSchema = getSchema();
/*  692 */       sqlObj.setSQL(5, aSchema);
/*  693 */       String sql = sqlObj.getSQL();
/*      */ 
/*  695 */       rs = stmt.executeQuery(sql);
/*  696 */       int i = 0;
/*  697 */       while (rs.next())
/*      */       {
/*  699 */         i++;
/*      */ 
/*  701 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  705 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  709 */         MMessageConfigSchema s1 = new MMessageConfigSchema();
/*  710 */         s1.setSchema(rs, i);
/*  711 */         aMMessageConfigSet.add(s1);
/*      */       }try {
/*  713 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  719 */       CError tError = new CError();
/*  720 */       tError.moduleName = "MMessageConfigDB";
/*  721 */       tError.functionName = "query";
/*  722 */       tError.errorMessage = e.toString();
/*  723 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  725 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  728 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  732 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  738 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  742 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  747 */     return aMMessageConfigSet;
/*      */   }
/*      */ 
/*      */   public MMessageConfigSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  752 */     Statement stmt = null;
/*  753 */     ResultSet rs = null;
/*  754 */     MMessageConfigSet aMMessageConfigSet = new MMessageConfigSet();
/*      */ 
/*  756 */     if (!this.mflag) {
/*  757 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  762 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  764 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  765 */       int i = 0;
/*  766 */       while (rs.next())
/*      */       {
/*  768 */         i++;
/*      */ 
/*  770 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  774 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  778 */         MMessageConfigSchema s1 = new MMessageConfigSchema();
/*  779 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  782 */           CError tError = new CError();
/*  783 */           tError.moduleName = "MMessageConfigDB";
/*  784 */           tError.functionName = "executeQuery";
/*  785 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  786 */           this.mErrors.addOneError(tError);
/*      */         }
/*  788 */         aMMessageConfigSet.add(s1);
/*      */       }try {
/*  790 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  796 */       CError tError = new CError();
/*  797 */       tError.moduleName = "MMessageConfigDB";
/*  798 */       tError.functionName = "executeQuery";
/*  799 */       tError.errorMessage = e.toString();
/*  800 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  802 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  805 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  809 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  815 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  819 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  824 */     return aMMessageConfigSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  829 */     Statement stmt = null;
/*      */ 
/*  831 */     if (!this.mflag) {
/*  832 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  837 */       stmt = this.con.createStatement(1003, 1007);
/*  838 */       SQLString sqlObj = new SQLString("MMessageConfig");
/*  839 */       MMessageConfigSchema aSchema = getSchema();
/*  840 */       sqlObj.setSQL(2, aSchema);
/*  841 */       String sql = "update MMessageConfig " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  843 */       int operCount = stmt.executeUpdate(sql);
/*  844 */       if (operCount == 0)
/*      */       {
/*  847 */         CError tError = new CError();
/*  848 */         tError.moduleName = "MMessageConfigDB";
/*  849 */         tError.functionName = "update";
/*  850 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  851 */         this.mErrors.addOneError(tError);
/*      */ 
/*  853 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  857 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  861 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  867 */       CError tError = new CError();
/*  868 */       tError.moduleName = "MMessageConfigDB";
/*  869 */       tError.functionName = "update";
/*  870 */       tError.errorMessage = e.toString();
/*  871 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  873 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  875 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  879 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  883 */       return false;
/*      */     }
/*      */ 
/*  886 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  890 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  895 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  901 */     if (this.mResultSet != null)
/*      */     {
/*  904 */       CError tError = new CError();
/*  905 */       tError.moduleName = "MMessageConfigDB";
/*  906 */       tError.functionName = "prepareData";
/*  907 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  908 */       this.mErrors.addOneError(tError);
/*  909 */       return false;
/*      */     }
/*      */ 
/*  912 */     if (!this.mflag)
/*      */     {
/*  914 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  918 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  919 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  924 */       CError tError = new CError();
/*  925 */       tError.moduleName = "MMessageConfigDB";
/*  926 */       tError.functionName = "prepareData";
/*  927 */       tError.errorMessage = e.toString();
/*  928 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  931 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  937 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  941 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  945 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  950 */       return false;
/*      */     }
/*      */ 
/*  953 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  957 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  962 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  968 */     boolean flag = true;
/*  969 */     if (this.mResultSet == null)
/*      */     {
/*  971 */       CError tError = new CError();
/*  972 */       tError.moduleName = "MMessageConfigDB";
/*  973 */       tError.functionName = "hasMoreData";
/*  974 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  975 */       this.mErrors.addOneError(tError);
/*  976 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  980 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  984 */       CError tError = new CError();
/*  985 */       tError.moduleName = "MMessageConfigDB";
/*  986 */       tError.functionName = "hasMoreData";
/*  987 */       tError.errorMessage = ex.toString();
/*  988 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  991 */         this.mResultSet.close();
/*  992 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  998 */         this.mStatement.close();
/*  999 */         this.mStatement = null;
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
/* 1014 */     return flag;
/*      */   }
/*      */ 
/*      */   public MMessageConfigSet getData()
/*      */   {
/* 1019 */     int tCount = 0;
/* 1020 */     MMessageConfigSet tMMessageConfigSet = new MMessageConfigSet();
/* 1021 */     MMessageConfigSchema tMMessageConfigSchema = null;
/* 1022 */     if (this.mResultSet == null)
/*      */     {
/* 1024 */       CError tError = new CError();
/* 1025 */       tError.moduleName = "MMessageConfigDB";
/* 1026 */       tError.functionName = "getData";
/* 1027 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1028 */       this.mErrors.addOneError(tError);
/* 1029 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1033 */       tCount = 1;
/* 1034 */       tMMessageConfigSchema = new MMessageConfigSchema();
/* 1035 */       tMMessageConfigSchema.setSchema(this.mResultSet, 1);
/* 1036 */       tMMessageConfigSet.add(tMMessageConfigSchema);
/*      */ 
/* 1038 */       while (tCount++ < 5000)
/*      */       {
/* 1040 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1042 */         tMMessageConfigSchema = new MMessageConfigSchema();
/* 1043 */         tMMessageConfigSchema.setSchema(this.mResultSet, 1);
/* 1044 */         tMMessageConfigSet.add(tMMessageConfigSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1050 */       CError tError = new CError();
/* 1051 */       tError.moduleName = "MMessageConfigDB";
/* 1052 */       tError.functionName = "getData";
/* 1053 */       tError.errorMessage = ex.toString();
/* 1054 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1057 */         this.mResultSet.close();
/* 1058 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1064 */         this.mStatement.close();
/* 1065 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1069 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1073 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1078 */       return null;
/*      */     }
/* 1080 */     return tMMessageConfigSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1085 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1088 */       if (this.mResultSet == null)
/*      */       {
/* 1090 */         CError tError = new CError();
/* 1091 */         tError.moduleName = "MMessageConfigDB";
/* 1092 */         tError.functionName = "closeData";
/* 1093 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1094 */         this.mErrors.addOneError(tError);
/* 1095 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1099 */         this.mResultSet.close();
/* 1100 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1105 */       CError tError = new CError();
/* 1106 */       tError.moduleName = "MMessageConfigDB";
/* 1107 */       tError.functionName = "closeData";
/* 1108 */       tError.errorMessage = ex2.toString();
/* 1109 */       this.mErrors.addOneError(tError);
/* 1110 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1114 */       if (this.mStatement == null)
/*      */       {
/* 1116 */         CError tError = new CError();
/* 1117 */         tError.moduleName = "MMessageConfigDB";
/* 1118 */         tError.functionName = "closeData";
/* 1119 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1120 */         this.mErrors.addOneError(tError);
/* 1121 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1125 */         this.mStatement.close();
/* 1126 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1131 */       CError tError = new CError();
/* 1132 */       tError.moduleName = "MMessageConfigDB";
/* 1133 */       tError.functionName = "closeData";
/* 1134 */       tError.errorMessage = ex3.toString();
/* 1135 */       this.mErrors.addOneError(tError);
/* 1136 */       flag = false;
/*      */     }
/* 1138 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MMessageConfigDB
 * JD-Core Version:    0.6.0
 */