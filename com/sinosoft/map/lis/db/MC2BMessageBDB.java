/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MC2BMessageBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MC2BMessageBSet;
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
/*      */ public class MC2BMessageBDB extends MC2BMessageBSchema
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
/*      */   public MC2BMessageBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MC2BMessageB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MC2BMessageBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MC2BMessageB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MC2BMessageBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MC2BMessageBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MC2BMessageBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MC2BMessageBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MC2BMessageB WHERE  ID = ?");
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
/*  107 */       tError.moduleName = "MC2BMessageBDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MC2BMessageB SET  ID = ? , ManageCom = ? , BranchType = ? , Message = ? , MessageType = ? , KeyData = ? , KeyData2 = ? , KeyData3 = ? , KeyData4 = ? , URL = ? , Type = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  ID = ?");
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
/*  160 */       if ((getMessage() == null) || (getMessage().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getMessage());
/*      */       }
/*  165 */       if ((getMessageType() == null) || (getMessageType().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getMessageType());
/*      */       }
/*  170 */       if ((getKeyData() == null) || (getKeyData().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getKeyData());
/*      */       }
/*  175 */       if ((getKeyData2() == null) || (getKeyData2().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getKeyData2());
/*      */       }
/*  180 */       if ((getKeyData3() == null) || (getKeyData3().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getKeyData3());
/*      */       }
/*  185 */       if ((getKeyData4() == null) || (getKeyData4().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getKeyData4());
/*      */       }
/*  190 */       if ((getURL() == null) || (getURL().equals("null")))
/*  191 */         pstmt.setNull(10, 12);
/*      */       else {
/*  193 */         pstmt.setString(10, getURL());
/*      */       }
/*  195 */       if ((getType() == null) || (getType().equals("null")))
/*  196 */         pstmt.setNull(11, 12);
/*      */       else {
/*  198 */         pstmt.setString(11, getType());
/*      */       }
/*  200 */       if ((getState() == null) || (getState().equals("null")))
/*  201 */         pstmt.setNull(12, 12);
/*      */       else {
/*  203 */         pstmt.setString(12, getState());
/*      */       }
/*  205 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  206 */         pstmt.setNull(13, 91);
/*      */       else {
/*  208 */         pstmt.setDate(13, Date.valueOf(getStartDate()));
/*      */       }
/*  210 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  211 */         pstmt.setNull(14, 91);
/*      */       else {
/*  213 */         pstmt.setDate(14, Date.valueOf(getEndDate()));
/*      */       }
/*  215 */       if ((getStartTime() == null) || (getStartTime().equals("null")))
/*  216 */         pstmt.setNull(15, 12);
/*      */       else {
/*  218 */         pstmt.setString(15, getStartTime());
/*      */       }
/*  220 */       if ((getEndTime() == null) || (getEndTime().equals("null")))
/*  221 */         pstmt.setNull(16, 12);
/*      */       else {
/*  223 */         pstmt.setString(16, getEndTime());
/*      */       }
/*  225 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  226 */         pstmt.setNull(17, 12);
/*      */       else {
/*  228 */         pstmt.setString(17, getVF01());
/*      */       }
/*  230 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  231 */         pstmt.setNull(18, 12);
/*      */       else {
/*  233 */         pstmt.setString(18, getNF01());
/*      */       }
/*  235 */       pstmt.setInt(19, getIF01());
/*  236 */       pstmt.setDouble(20, getDF02());
/*  237 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  238 */         pstmt.setNull(21, 91);
/*      */       else {
/*  240 */         pstmt.setDate(21, Date.valueOf(getDate01()));
/*      */       }
/*  242 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  243 */         pstmt.setNull(22, 12);
/*      */       else {
/*  245 */         pstmt.setString(22, getOperator());
/*      */       }
/*  247 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  248 */         pstmt.setNull(23, 91);
/*      */       else {
/*  250 */         pstmt.setDate(23, Date.valueOf(getMakeDate()));
/*      */       }
/*  252 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  253 */         pstmt.setNull(24, 12);
/*      */       else {
/*  255 */         pstmt.setString(24, getMakeTime());
/*      */       }
/*  257 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  258 */         pstmt.setNull(25, 12);
/*      */       else {
/*  260 */         pstmt.setString(25, getEdorNo());
/*      */       }
/*  262 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  263 */         pstmt.setNull(26, 12);
/*      */       else {
/*  265 */         pstmt.setString(26, getEdorType());
/*      */       }
/*  267 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  268 */         pstmt.setNull(27, 12);
/*      */       else {
/*  270 */         pstmt.setString(27, getEdorCase());
/*      */       }
/*  272 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  273 */         pstmt.setNull(28, 12);
/*      */       else {
/*  275 */         pstmt.setString(28, getOperator2());
/*      */       }
/*  277 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  278 */         pstmt.setNull(29, 91);
/*      */       else {
/*  280 */         pstmt.setDate(29, Date.valueOf(getMakeDate2()));
/*      */       }
/*  282 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  283 */         pstmt.setNull(30, 12);
/*      */       else {
/*  285 */         pstmt.setString(30, getMakeTime2());
/*      */       }
/*      */ 
/*  288 */       if ((getID() == null) || (getID().equals("null")))
/*  289 */         pstmt.setNull(31, 12);
/*      */       else {
/*  291 */         pstmt.setString(31, getID());
/*      */       }
/*  293 */       pstmt.executeUpdate();
/*  294 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  297 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  298 */       CError tError = new CError();
/*  299 */       tError.moduleName = "MC2BMessageBDB";
/*  300 */       tError.functionName = "update()";
/*  301 */       tError.errorMessage = ex.toString();
/*  302 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  305 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  308 */       if (!this.mflag)
/*      */         try {
/*  310 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  314 */       return false;
/*      */     }
/*      */ 
/*  317 */     if (!this.mflag)
/*      */       try {
/*  319 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  323 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  328 */     PreparedStatement pstmt = null;
/*      */ 
/*  330 */     if (!this.mflag) {
/*  331 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  336 */       pstmt = this.con.prepareStatement("INSERT INTO MC2BMessageB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  337 */       if ((getID() == null) || (getID().equals("null")))
/*  338 */         pstmt.setNull(1, 12);
/*      */       else {
/*  340 */         pstmt.setString(1, getID());
/*      */       }
/*  342 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  343 */         pstmt.setNull(2, 12);
/*      */       else {
/*  345 */         pstmt.setString(2, getManageCom());
/*      */       }
/*  347 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  348 */         pstmt.setNull(3, 12);
/*      */       else {
/*  350 */         pstmt.setString(3, getBranchType());
/*      */       }
/*  352 */       if ((getMessage() == null) || (getMessage().equals("null")))
/*  353 */         pstmt.setNull(4, 12);
/*      */       else {
/*  355 */         pstmt.setString(4, getMessage());
/*      */       }
/*  357 */       if ((getMessageType() == null) || (getMessageType().equals("null")))
/*  358 */         pstmt.setNull(5, 12);
/*      */       else {
/*  360 */         pstmt.setString(5, getMessageType());
/*      */       }
/*  362 */       if ((getKeyData() == null) || (getKeyData().equals("null")))
/*  363 */         pstmt.setNull(6, 12);
/*      */       else {
/*  365 */         pstmt.setString(6, getKeyData());
/*      */       }
/*  367 */       if ((getKeyData2() == null) || (getKeyData2().equals("null")))
/*  368 */         pstmt.setNull(7, 12);
/*      */       else {
/*  370 */         pstmt.setString(7, getKeyData2());
/*      */       }
/*  372 */       if ((getKeyData3() == null) || (getKeyData3().equals("null")))
/*  373 */         pstmt.setNull(8, 12);
/*      */       else {
/*  375 */         pstmt.setString(8, getKeyData3());
/*      */       }
/*  377 */       if ((getKeyData4() == null) || (getKeyData4().equals("null")))
/*  378 */         pstmt.setNull(9, 12);
/*      */       else {
/*  380 */         pstmt.setString(9, getKeyData4());
/*      */       }
/*  382 */       if ((getURL() == null) || (getURL().equals("null")))
/*  383 */         pstmt.setNull(10, 12);
/*      */       else {
/*  385 */         pstmt.setString(10, getURL());
/*      */       }
/*  387 */       if ((getType() == null) || (getType().equals("null")))
/*  388 */         pstmt.setNull(11, 12);
/*      */       else {
/*  390 */         pstmt.setString(11, getType());
/*      */       }
/*  392 */       if ((getState() == null) || (getState().equals("null")))
/*  393 */         pstmt.setNull(12, 12);
/*      */       else {
/*  395 */         pstmt.setString(12, getState());
/*      */       }
/*  397 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  398 */         pstmt.setNull(13, 91);
/*      */       else {
/*  400 */         pstmt.setDate(13, Date.valueOf(getStartDate()));
/*      */       }
/*  402 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  403 */         pstmt.setNull(14, 91);
/*      */       else {
/*  405 */         pstmt.setDate(14, Date.valueOf(getEndDate()));
/*      */       }
/*  407 */       if ((getStartTime() == null) || (getStartTime().equals("null")))
/*  408 */         pstmt.setNull(15, 12);
/*      */       else {
/*  410 */         pstmt.setString(15, getStartTime());
/*      */       }
/*  412 */       if ((getEndTime() == null) || (getEndTime().equals("null")))
/*  413 */         pstmt.setNull(16, 12);
/*      */       else {
/*  415 */         pstmt.setString(16, getEndTime());
/*      */       }
/*  417 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  418 */         pstmt.setNull(17, 12);
/*      */       else {
/*  420 */         pstmt.setString(17, getVF01());
/*      */       }
/*  422 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  423 */         pstmt.setNull(18, 12);
/*      */       else {
/*  425 */         pstmt.setString(18, getNF01());
/*      */       }
/*  427 */       pstmt.setInt(19, getIF01());
/*  428 */       pstmt.setDouble(20, getDF02());
/*  429 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  430 */         pstmt.setNull(21, 91);
/*      */       else {
/*  432 */         pstmt.setDate(21, Date.valueOf(getDate01()));
/*      */       }
/*  434 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  435 */         pstmt.setNull(22, 12);
/*      */       else {
/*  437 */         pstmt.setString(22, getOperator());
/*      */       }
/*  439 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  440 */         pstmt.setNull(23, 91);
/*      */       else {
/*  442 */         pstmt.setDate(23, Date.valueOf(getMakeDate()));
/*      */       }
/*  444 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  445 */         pstmt.setNull(24, 12);
/*      */       else {
/*  447 */         pstmt.setString(24, getMakeTime());
/*      */       }
/*  449 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  450 */         pstmt.setNull(25, 12);
/*      */       else {
/*  452 */         pstmt.setString(25, getEdorNo());
/*      */       }
/*  454 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  455 */         pstmt.setNull(26, 12);
/*      */       else {
/*  457 */         pstmt.setString(26, getEdorType());
/*      */       }
/*  459 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  460 */         pstmt.setNull(27, 12);
/*      */       else {
/*  462 */         pstmt.setString(27, getEdorCase());
/*      */       }
/*  464 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  465 */         pstmt.setNull(28, 12);
/*      */       else {
/*  467 */         pstmt.setString(28, getOperator2());
/*      */       }
/*  469 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  470 */         pstmt.setNull(29, 91);
/*      */       else {
/*  472 */         pstmt.setDate(29, Date.valueOf(getMakeDate2()));
/*      */       }
/*  474 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  475 */         pstmt.setNull(30, 12);
/*      */       else {
/*  477 */         pstmt.setString(30, getMakeTime2());
/*      */       }
/*      */ 
/*  480 */       pstmt.executeUpdate();
/*  481 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  484 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  485 */       CError tError = new CError();
/*  486 */       tError.moduleName = "MC2BMessageBDB";
/*  487 */       tError.functionName = "insert()";
/*  488 */       tError.errorMessage = ex.toString();
/*  489 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  492 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  495 */       if (!this.mflag)
/*      */         try {
/*  497 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  501 */       return false;
/*      */     }
/*      */ 
/*  504 */     if (!this.mflag)
/*      */       try {
/*  506 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  510 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  515 */     PreparedStatement pstmt = null;
/*  516 */     ResultSet rs = null;
/*      */ 
/*  518 */     if (!this.mflag) {
/*  519 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  524 */       pstmt = this.con.prepareStatement("SELECT * FROM MC2BMessageB WHERE  ID = ?", 
/*  525 */         1003, 1007);
/*  526 */       if ((getID() == null) || (getID().equals("null")))
/*  527 */         pstmt.setNull(1, 12);
/*      */       else {
/*  529 */         pstmt.setString(1, getID());
/*      */       }
/*  531 */       rs = pstmt.executeQuery();
/*  532 */       int i = 0;
/*  533 */       if (rs.next())
/*      */       {
/*  535 */         i++;
/*  536 */         if (!setSchema(rs, i))
/*      */         {
/*  539 */           CError tError = new CError();
/*  540 */           tError.moduleName = "MC2BMessageBDB";
/*  541 */           tError.functionName = "getInfo";
/*  542 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  543 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  545 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  548 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  552 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  556 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  560 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  563 */       if (i == 0)
/*      */       {
/*  565 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  569 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  573 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  579 */       CError tError = new CError();
/*  580 */       tError.moduleName = "MC2BMessageBDB";
/*  581 */       tError.functionName = "getInfo";
/*  582 */       tError.errorMessage = e.toString();
/*  583 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  585 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  588 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  592 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  596 */       return false;
/*      */     }
/*      */ 
/*  599 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  603 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  608 */     return true;
/*      */   }
/*      */ 
/*      */   public MC2BMessageBSet query()
/*      */   {
/*  613 */     Statement stmt = null;
/*  614 */     ResultSet rs = null;
/*  615 */     MC2BMessageBSet aMC2BMessageBSet = new MC2BMessageBSet();
/*      */ 
/*  617 */     if (!this.mflag) {
/*  618 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  623 */       stmt = this.con.createStatement(1003, 1007);
/*  624 */       SQLString sqlObj = new SQLString("MC2BMessageB");
/*  625 */       MC2BMessageBSchema aSchema = getSchema();
/*  626 */       sqlObj.setSQL(5, aSchema);
/*  627 */       String sql = sqlObj.getSQL();
/*      */ 
/*  629 */       rs = stmt.executeQuery(sql);
/*  630 */       int i = 0;
/*  631 */       while (rs.next())
/*      */       {
/*  633 */         i++;
/*  634 */         MC2BMessageBSchema s1 = new MC2BMessageBSchema();
/*  635 */         s1.setSchema(rs, i);
/*  636 */         aMC2BMessageBSet.add(s1);
/*      */       }try {
/*  638 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  644 */       CError tError = new CError();
/*  645 */       tError.moduleName = "MC2BMessageBDB";
/*  646 */       tError.functionName = "query";
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
/*  672 */     return aMC2BMessageBSet;
/*      */   }
/*      */ 
/*      */   public MC2BMessageBSet executeQuery(String sql)
/*      */   {
/*  677 */     Statement stmt = null;
/*  678 */     ResultSet rs = null;
/*  679 */     MC2BMessageBSet aMC2BMessageBSet = new MC2BMessageBSet();
/*      */ 
/*  681 */     if (!this.mflag) {
/*  682 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  687 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  689 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  690 */       int i = 0;
/*  691 */       while (rs.next())
/*      */       {
/*  693 */         i++;
/*  694 */         MC2BMessageBSchema s1 = new MC2BMessageBSchema();
/*  695 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  698 */           CError tError = new CError();
/*  699 */           tError.moduleName = "MC2BMessageBDB";
/*  700 */           tError.functionName = "executeQuery";
/*  701 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  702 */           this.mErrors.addOneError(tError);
/*      */         }
/*  704 */         aMC2BMessageBSet.add(s1);
/*      */       }try {
/*  706 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  712 */       CError tError = new CError();
/*  713 */       tError.moduleName = "MC2BMessageBDB";
/*  714 */       tError.functionName = "executeQuery";
/*  715 */       tError.errorMessage = e.toString();
/*  716 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  718 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  721 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  725 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  731 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  735 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  740 */     return aMC2BMessageBSet;
/*      */   }
/*      */ 
/*      */   public MC2BMessageBSet query(int nStart, int nCount)
/*      */   {
/*  745 */     Statement stmt = null;
/*  746 */     ResultSet rs = null;
/*  747 */     MC2BMessageBSet aMC2BMessageBSet = new MC2BMessageBSet();
/*      */ 
/*  749 */     if (!this.mflag) {
/*  750 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  755 */       stmt = this.con.createStatement(1003, 1007);
/*  756 */       SQLString sqlObj = new SQLString("MC2BMessageB");
/*  757 */       MC2BMessageBSchema aSchema = getSchema();
/*  758 */       sqlObj.setSQL(5, aSchema);
/*  759 */       String sql = sqlObj.getSQL();
/*      */ 
/*  761 */       rs = stmt.executeQuery(sql);
/*  762 */       int i = 0;
/*  763 */       while (rs.next())
/*      */       {
/*  765 */         i++;
/*      */ 
/*  767 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  771 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  775 */         MC2BMessageBSchema s1 = new MC2BMessageBSchema();
/*  776 */         s1.setSchema(rs, i);
/*  777 */         aMC2BMessageBSet.add(s1);
/*      */       }try {
/*  779 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  785 */       CError tError = new CError();
/*  786 */       tError.moduleName = "MC2BMessageBDB";
/*  787 */       tError.functionName = "query";
/*  788 */       tError.errorMessage = e.toString();
/*  789 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  791 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  794 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  798 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  804 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  808 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  813 */     return aMC2BMessageBSet;
/*      */   }
/*      */ 
/*      */   public MC2BMessageBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  818 */     Statement stmt = null;
/*  819 */     ResultSet rs = null;
/*  820 */     MC2BMessageBSet aMC2BMessageBSet = new MC2BMessageBSet();
/*      */ 
/*  822 */     if (!this.mflag) {
/*  823 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  828 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  830 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  831 */       int i = 0;
/*  832 */       while (rs.next())
/*      */       {
/*  834 */         i++;
/*      */ 
/*  836 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  840 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  844 */         MC2BMessageBSchema s1 = new MC2BMessageBSchema();
/*  845 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  848 */           CError tError = new CError();
/*  849 */           tError.moduleName = "MC2BMessageBDB";
/*  850 */           tError.functionName = "executeQuery";
/*  851 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  852 */           this.mErrors.addOneError(tError);
/*      */         }
/*  854 */         aMC2BMessageBSet.add(s1);
/*      */       }try {
/*  856 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  862 */       CError tError = new CError();
/*  863 */       tError.moduleName = "MC2BMessageBDB";
/*  864 */       tError.functionName = "executeQuery";
/*  865 */       tError.errorMessage = e.toString();
/*  866 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  868 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  871 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  875 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  881 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  885 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  890 */     return aMC2BMessageBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  895 */     Statement stmt = null;
/*      */ 
/*  897 */     if (!this.mflag) {
/*  898 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  903 */       stmt = this.con.createStatement(1003, 1007);
/*  904 */       SQLString sqlObj = new SQLString("MC2BMessageB");
/*  905 */       MC2BMessageBSchema aSchema = getSchema();
/*  906 */       sqlObj.setSQL(2, aSchema);
/*  907 */       String sql = "update MC2BMessageB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  909 */       int operCount = stmt.executeUpdate(sql);
/*  910 */       if (operCount == 0)
/*      */       {
/*  913 */         CError tError = new CError();
/*  914 */         tError.moduleName = "MC2BMessageBDB";
/*  915 */         tError.functionName = "update";
/*  916 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  917 */         this.mErrors.addOneError(tError);
/*      */ 
/*  919 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  923 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  927 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  933 */       CError tError = new CError();
/*  934 */       tError.moduleName = "MC2BMessageBDB";
/*  935 */       tError.functionName = "update";
/*  936 */       tError.errorMessage = e.toString();
/*  937 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  939 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  941 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  945 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  949 */       return false;
/*      */     }
/*      */ 
/*  952 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  956 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  961 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  967 */     if (this.mResultSet != null)
/*      */     {
/*  970 */       CError tError = new CError();
/*  971 */       tError.moduleName = "MC2BMessageBDB";
/*  972 */       tError.functionName = "prepareData";
/*  973 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  974 */       this.mErrors.addOneError(tError);
/*  975 */       return false;
/*      */     }
/*      */ 
/*  978 */     if (!this.mflag)
/*      */     {
/*  980 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  984 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  985 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  990 */       CError tError = new CError();
/*  991 */       tError.moduleName = "MC2BMessageBDB";
/*  992 */       tError.functionName = "prepareData";
/*  993 */       tError.errorMessage = e.toString();
/*  994 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  997 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1003 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1007 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1011 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1016 */       return false;
/*      */     }
/*      */ 
/* 1019 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1023 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1028 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1034 */     boolean flag = true;
/* 1035 */     if (this.mResultSet == null)
/*      */     {
/* 1037 */       CError tError = new CError();
/* 1038 */       tError.moduleName = "MC2BMessageBDB";
/* 1039 */       tError.functionName = "hasMoreData";
/* 1040 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1041 */       this.mErrors.addOneError(tError);
/* 1042 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1046 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1050 */       CError tError = new CError();
/* 1051 */       tError.moduleName = "MC2BMessageBDB";
/* 1052 */       tError.functionName = "hasMoreData";
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
/* 1078 */       return false;
/*      */     }
/* 1080 */     return flag;
/*      */   }
/*      */ 
/*      */   public MC2BMessageBSet getData()
/*      */   {
/* 1085 */     int tCount = 0;
/* 1086 */     MC2BMessageBSet tMC2BMessageBSet = new MC2BMessageBSet();
/* 1087 */     MC2BMessageBSchema tMC2BMessageBSchema = null;
/* 1088 */     if (this.mResultSet == null)
/*      */     {
/* 1090 */       CError tError = new CError();
/* 1091 */       tError.moduleName = "MC2BMessageBDB";
/* 1092 */       tError.functionName = "getData";
/* 1093 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1094 */       this.mErrors.addOneError(tError);
/* 1095 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1099 */       tCount = 1;
/* 1100 */       tMC2BMessageBSchema = new MC2BMessageBSchema();
/* 1101 */       tMC2BMessageBSchema.setSchema(this.mResultSet, 1);
/* 1102 */       tMC2BMessageBSet.add(tMC2BMessageBSchema);
/*      */ 
/* 1104 */       while (tCount++ < 5000)
/*      */       {
/* 1106 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1108 */         tMC2BMessageBSchema = new MC2BMessageBSchema();
/* 1109 */         tMC2BMessageBSchema.setSchema(this.mResultSet, 1);
/* 1110 */         tMC2BMessageBSet.add(tMC2BMessageBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1116 */       CError tError = new CError();
/* 1117 */       tError.moduleName = "MC2BMessageBDB";
/* 1118 */       tError.functionName = "getData";
/* 1119 */       tError.errorMessage = ex.toString();
/* 1120 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1123 */         this.mResultSet.close();
/* 1124 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1130 */         this.mStatement.close();
/* 1131 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1135 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1139 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1144 */       return null;
/*      */     }
/* 1146 */     return tMC2BMessageBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1151 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1154 */       if (this.mResultSet == null)
/*      */       {
/* 1156 */         CError tError = new CError();
/* 1157 */         tError.moduleName = "MC2BMessageBDB";
/* 1158 */         tError.functionName = "closeData";
/* 1159 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1160 */         this.mErrors.addOneError(tError);
/* 1161 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1165 */         this.mResultSet.close();
/* 1166 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1171 */       CError tError = new CError();
/* 1172 */       tError.moduleName = "MC2BMessageBDB";
/* 1173 */       tError.functionName = "closeData";
/* 1174 */       tError.errorMessage = ex2.toString();
/* 1175 */       this.mErrors.addOneError(tError);
/* 1176 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1180 */       if (this.mStatement == null)
/*      */       {
/* 1182 */         CError tError = new CError();
/* 1183 */         tError.moduleName = "MC2BMessageBDB";
/* 1184 */         tError.functionName = "closeData";
/* 1185 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1186 */         this.mErrors.addOneError(tError);
/* 1187 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1191 */         this.mStatement.close();
/* 1192 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1197 */       CError tError = new CError();
/* 1198 */       tError.moduleName = "MC2BMessageBDB";
/* 1199 */       tError.functionName = "closeData";
/* 1200 */       tError.errorMessage = ex3.toString();
/* 1201 */       this.mErrors.addOneError(tError);
/* 1202 */       flag = false;
/*      */     }
/* 1204 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MC2BMessageBDB
 * JD-Core Version:    0.6.0
 */