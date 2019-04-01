/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MC2BMessageSchema;
/*      */ import com.sinosoft.map.lis.vschema.MC2BMessageSet;
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
/*      */ public class MC2BMessageDB extends MC2BMessageSchema
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
/*      */   public MC2BMessageDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MC2BMessage");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MC2BMessageDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MC2BMessage");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MC2BMessageSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MC2BMessageDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MC2BMessageSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MC2BMessageDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MC2BMessage WHERE  ID = ?");
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
/*  107 */       tError.moduleName = "MC2BMessageDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MC2BMessage SET  ID = ? , ManageCom = ? , BranchType = ? , Message = ? , MessageType = ? , KeyData = ? , KeyData2 = ? , KeyData3 = ? , KeyData4 = ? , URL = ? , Type = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
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
/*      */ 
/*  258 */       if ((getID() == null) || (getID().equals("null")))
/*  259 */         pstmt.setNull(25, 12);
/*      */       else {
/*  261 */         pstmt.setString(25, getID());
/*      */       }
/*  263 */       pstmt.executeUpdate();
/*  264 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  267 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  268 */       CError tError = new CError();
/*  269 */       tError.moduleName = "MC2BMessageDB";
/*  270 */       tError.functionName = "update()";
/*  271 */       tError.errorMessage = ex.toString();
/*  272 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  275 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  278 */       if (!this.mflag)
/*      */         try {
/*  280 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  284 */       return false;
/*      */     }
/*      */ 
/*  287 */     if (!this.mflag)
/*      */       try {
/*  289 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  293 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  298 */     PreparedStatement pstmt = null;
/*      */ 
/*  300 */     if (!this.mflag) {
/*  301 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  306 */       pstmt = this.con.prepareStatement("INSERT INTO MC2BMessage VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  307 */       if ((getID() == null) || (getID().equals("null")))
/*  308 */         pstmt.setNull(1, 12);
/*      */       else {
/*  310 */         pstmt.setString(1, getID());
/*      */       }
/*  312 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  313 */         pstmt.setNull(2, 12);
/*      */       else {
/*  315 */         pstmt.setString(2, getManageCom());
/*      */       }
/*  317 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  318 */         pstmt.setNull(3, 12);
/*      */       else {
/*  320 */         pstmt.setString(3, getBranchType());
/*      */       }
/*  322 */       if ((getMessage() == null) || (getMessage().equals("null")))
/*  323 */         pstmt.setNull(4, 12);
/*      */       else {
/*  325 */         pstmt.setString(4, getMessage());
/*      */       }
/*  327 */       if ((getMessageType() == null) || (getMessageType().equals("null")))
/*  328 */         pstmt.setNull(5, 12);
/*      */       else {
/*  330 */         pstmt.setString(5, getMessageType());
/*      */       }
/*  332 */       if ((getKeyData() == null) || (getKeyData().equals("null")))
/*  333 */         pstmt.setNull(6, 12);
/*      */       else {
/*  335 */         pstmt.setString(6, getKeyData());
/*      */       }
/*  337 */       if ((getKeyData2() == null) || (getKeyData2().equals("null")))
/*  338 */         pstmt.setNull(7, 12);
/*      */       else {
/*  340 */         pstmt.setString(7, getKeyData2());
/*      */       }
/*  342 */       if ((getKeyData3() == null) || (getKeyData3().equals("null")))
/*  343 */         pstmt.setNull(8, 12);
/*      */       else {
/*  345 */         pstmt.setString(8, getKeyData3());
/*      */       }
/*  347 */       if ((getKeyData4() == null) || (getKeyData4().equals("null")))
/*  348 */         pstmt.setNull(9, 12);
/*      */       else {
/*  350 */         pstmt.setString(9, getKeyData4());
/*      */       }
/*  352 */       if ((getURL() == null) || (getURL().equals("null")))
/*  353 */         pstmt.setNull(10, 12);
/*      */       else {
/*  355 */         pstmt.setString(10, getURL());
/*      */       }
/*  357 */       if ((getType() == null) || (getType().equals("null")))
/*  358 */         pstmt.setNull(11, 12);
/*      */       else {
/*  360 */         pstmt.setString(11, getType());
/*      */       }
/*  362 */       if ((getState() == null) || (getState().equals("null")))
/*  363 */         pstmt.setNull(12, 12);
/*      */       else {
/*  365 */         pstmt.setString(12, getState());
/*      */       }
/*  367 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  368 */         pstmt.setNull(13, 91);
/*      */       else {
/*  370 */         pstmt.setDate(13, Date.valueOf(getStartDate()));
/*      */       }
/*  372 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  373 */         pstmt.setNull(14, 91);
/*      */       else {
/*  375 */         pstmt.setDate(14, Date.valueOf(getEndDate()));
/*      */       }
/*  377 */       if ((getStartTime() == null) || (getStartTime().equals("null")))
/*  378 */         pstmt.setNull(15, 12);
/*      */       else {
/*  380 */         pstmt.setString(15, getStartTime());
/*      */       }
/*  382 */       if ((getEndTime() == null) || (getEndTime().equals("null")))
/*  383 */         pstmt.setNull(16, 12);
/*      */       else {
/*  385 */         pstmt.setString(16, getEndTime());
/*      */       }
/*  387 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  388 */         pstmt.setNull(17, 12);
/*      */       else {
/*  390 */         pstmt.setString(17, getVF01());
/*      */       }
/*  392 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  393 */         pstmt.setNull(18, 12);
/*      */       else {
/*  395 */         pstmt.setString(18, getNF01());
/*      */       }
/*  397 */       pstmt.setInt(19, getIF01());
/*  398 */       pstmt.setDouble(20, getDF02());
/*  399 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  400 */         pstmt.setNull(21, 91);
/*      */       else {
/*  402 */         pstmt.setDate(21, Date.valueOf(getDate01()));
/*      */       }
/*  404 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  405 */         pstmt.setNull(22, 12);
/*      */       else {
/*  407 */         pstmt.setString(22, getOperator());
/*      */       }
/*  409 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  410 */         pstmt.setNull(23, 91);
/*      */       else {
/*  412 */         pstmt.setDate(23, Date.valueOf(getMakeDate()));
/*      */       }
/*  414 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  415 */         pstmt.setNull(24, 12);
/*      */       else {
/*  417 */         pstmt.setString(24, getMakeTime());
/*      */       }
/*      */ 
/*  420 */       pstmt.executeUpdate();
/*  421 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  424 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  425 */       CError tError = new CError();
/*  426 */       tError.moduleName = "MC2BMessageDB";
/*  427 */       tError.functionName = "insert()";
/*  428 */       tError.errorMessage = ex.toString();
/*  429 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  432 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  435 */       if (!this.mflag)
/*      */         try {
/*  437 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  441 */       return false;
/*      */     }
/*      */ 
/*  444 */     if (!this.mflag)
/*      */       try {
/*  446 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  450 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  455 */     PreparedStatement pstmt = null;
/*  456 */     ResultSet rs = null;
/*      */ 
/*  458 */     if (!this.mflag) {
/*  459 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  464 */       pstmt = this.con.prepareStatement("SELECT * FROM MC2BMessage WHERE  ID = ?", 
/*  465 */         1003, 1007);
/*  466 */       if ((getID() == null) || (getID().equals("null")))
/*  467 */         pstmt.setNull(1, 12);
/*      */       else {
/*  469 */         pstmt.setString(1, getID());
/*      */       }
/*  471 */       rs = pstmt.executeQuery();
/*  472 */       int i = 0;
/*  473 */       if (rs.next())
/*      */       {
/*  475 */         i++;
/*  476 */         if (!setSchema(rs, i))
/*      */         {
/*  479 */           CError tError = new CError();
/*  480 */           tError.moduleName = "MC2BMessageDB";
/*  481 */           tError.functionName = "getInfo";
/*  482 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  483 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  485 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  488 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  492 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  496 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  500 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  503 */       if (i == 0)
/*      */       {
/*  505 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  509 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  513 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  519 */       CError tError = new CError();
/*  520 */       tError.moduleName = "MC2BMessageDB";
/*  521 */       tError.functionName = "getInfo";
/*  522 */       tError.errorMessage = e.toString();
/*  523 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  525 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  528 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  532 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  536 */       return false;
/*      */     }
/*      */ 
/*  539 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  543 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  548 */     return true;
/*      */   }
/*      */ 
/*      */   public MC2BMessageSet query()
/*      */   {
/*  553 */     Statement stmt = null;
/*  554 */     ResultSet rs = null;
/*  555 */     MC2BMessageSet aMC2BMessageSet = new MC2BMessageSet();
/*      */ 
/*  557 */     if (!this.mflag) {
/*  558 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  563 */       stmt = this.con.createStatement(1003, 1007);
/*  564 */       SQLString sqlObj = new SQLString("MC2BMessage");
/*  565 */       MC2BMessageSchema aSchema = getSchema();
/*  566 */       sqlObj.setSQL(5, aSchema);
/*  567 */       String sql = sqlObj.getSQL();
/*      */ 
/*  569 */       rs = stmt.executeQuery(sql);
/*  570 */       int i = 0;
/*  571 */       while (rs.next())
/*      */       {
/*  573 */         i++;
/*  574 */         MC2BMessageSchema s1 = new MC2BMessageSchema();
/*  575 */         s1.setSchema(rs, i);
/*  576 */         aMC2BMessageSet.add(s1);
/*      */       }try {
/*  578 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  584 */       CError tError = new CError();
/*  585 */       tError.moduleName = "MC2BMessageDB";
/*  586 */       tError.functionName = "query";
/*  587 */       tError.errorMessage = e.toString();
/*  588 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  590 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  593 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  597 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  603 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  607 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  612 */     return aMC2BMessageSet;
/*      */   }
/*      */ 
/*      */   public MC2BMessageSet executeQuery(String sql)
/*      */   {
/*  617 */     Statement stmt = null;
/*  618 */     ResultSet rs = null;
/*  619 */     MC2BMessageSet aMC2BMessageSet = new MC2BMessageSet();
/*      */ 
/*  621 */     if (!this.mflag) {
/*  622 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  627 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  629 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  630 */       int i = 0;
/*  631 */       while (rs.next())
/*      */       {
/*  633 */         i++;
/*  634 */         MC2BMessageSchema s1 = new MC2BMessageSchema();
/*  635 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  638 */           CError tError = new CError();
/*  639 */           tError.moduleName = "MC2BMessageDB";
/*  640 */           tError.functionName = "executeQuery";
/*  641 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  642 */           this.mErrors.addOneError(tError);
/*      */         }
/*  644 */         aMC2BMessageSet.add(s1);
/*      */       }try {
/*  646 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  652 */       CError tError = new CError();
/*  653 */       tError.moduleName = "MC2BMessageDB";
/*  654 */       tError.functionName = "executeQuery";
/*  655 */       tError.errorMessage = e.toString();
/*  656 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  658 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  661 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  665 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  671 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  675 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  680 */     return aMC2BMessageSet;
/*      */   }
/*      */ 
/*      */   public MC2BMessageSet query(int nStart, int nCount)
/*      */   {
/*  685 */     Statement stmt = null;
/*  686 */     ResultSet rs = null;
/*  687 */     MC2BMessageSet aMC2BMessageSet = new MC2BMessageSet();
/*      */ 
/*  689 */     if (!this.mflag) {
/*  690 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  695 */       stmt = this.con.createStatement(1003, 1007);
/*  696 */       SQLString sqlObj = new SQLString("MC2BMessage");
/*  697 */       MC2BMessageSchema aSchema = getSchema();
/*  698 */       sqlObj.setSQL(5, aSchema);
/*  699 */       String sql = sqlObj.getSQL();
/*      */ 
/*  701 */       rs = stmt.executeQuery(sql);
/*  702 */       int i = 0;
/*  703 */       while (rs.next())
/*      */       {
/*  705 */         i++;
/*      */ 
/*  707 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  711 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  715 */         MC2BMessageSchema s1 = new MC2BMessageSchema();
/*  716 */         s1.setSchema(rs, i);
/*  717 */         aMC2BMessageSet.add(s1);
/*      */       }try {
/*  719 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  725 */       CError tError = new CError();
/*  726 */       tError.moduleName = "MC2BMessageDB";
/*  727 */       tError.functionName = "query";
/*  728 */       tError.errorMessage = e.toString();
/*  729 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  731 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  734 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  738 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  744 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  748 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  753 */     return aMC2BMessageSet;
/*      */   }
/*      */ 
/*      */   public MC2BMessageSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  758 */     Statement stmt = null;
/*  759 */     ResultSet rs = null;
/*  760 */     MC2BMessageSet aMC2BMessageSet = new MC2BMessageSet();
/*      */ 
/*  762 */     if (!this.mflag) {
/*  763 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  768 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  770 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  771 */       int i = 0;
/*  772 */       while (rs.next())
/*      */       {
/*  774 */         i++;
/*      */ 
/*  776 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  780 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  784 */         MC2BMessageSchema s1 = new MC2BMessageSchema();
/*  785 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  788 */           CError tError = new CError();
/*  789 */           tError.moduleName = "MC2BMessageDB";
/*  790 */           tError.functionName = "executeQuery";
/*  791 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  792 */           this.mErrors.addOneError(tError);
/*      */         }
/*  794 */         aMC2BMessageSet.add(s1);
/*      */       }try {
/*  796 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  802 */       CError tError = new CError();
/*  803 */       tError.moduleName = "MC2BMessageDB";
/*  804 */       tError.functionName = "executeQuery";
/*  805 */       tError.errorMessage = e.toString();
/*  806 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  808 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  811 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  815 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  821 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  825 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  830 */     return aMC2BMessageSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  835 */     Statement stmt = null;
/*      */ 
/*  837 */     if (!this.mflag) {
/*  838 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  843 */       stmt = this.con.createStatement(1003, 1007);
/*  844 */       SQLString sqlObj = new SQLString("MC2BMessage");
/*  845 */       MC2BMessageSchema aSchema = getSchema();
/*  846 */       sqlObj.setSQL(2, aSchema);
/*  847 */       String sql = "update MC2BMessage " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  849 */       int operCount = stmt.executeUpdate(sql);
/*  850 */       if (operCount == 0)
/*      */       {
/*  853 */         CError tError = new CError();
/*  854 */         tError.moduleName = "MC2BMessageDB";
/*  855 */         tError.functionName = "update";
/*  856 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  857 */         this.mErrors.addOneError(tError);
/*      */ 
/*  859 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  863 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  867 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  873 */       CError tError = new CError();
/*  874 */       tError.moduleName = "MC2BMessageDB";
/*  875 */       tError.functionName = "update";
/*  876 */       tError.errorMessage = e.toString();
/*  877 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  879 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  881 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  885 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  889 */       return false;
/*      */     }
/*      */ 
/*  892 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  896 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  901 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  907 */     if (this.mResultSet != null)
/*      */     {
/*  910 */       CError tError = new CError();
/*  911 */       tError.moduleName = "MC2BMessageDB";
/*  912 */       tError.functionName = "prepareData";
/*  913 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  914 */       this.mErrors.addOneError(tError);
/*  915 */       return false;
/*      */     }
/*      */ 
/*  918 */     if (!this.mflag)
/*      */     {
/*  920 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  924 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  925 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  930 */       CError tError = new CError();
/*  931 */       tError.moduleName = "MC2BMessageDB";
/*  932 */       tError.functionName = "prepareData";
/*  933 */       tError.errorMessage = e.toString();
/*  934 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  937 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  943 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  947 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  951 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  956 */       return false;
/*      */     }
/*      */ 
/*  959 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  963 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  968 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  974 */     boolean flag = true;
/*  975 */     if (this.mResultSet == null)
/*      */     {
/*  977 */       CError tError = new CError();
/*  978 */       tError.moduleName = "MC2BMessageDB";
/*  979 */       tError.functionName = "hasMoreData";
/*  980 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  981 */       this.mErrors.addOneError(tError);
/*  982 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  986 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  990 */       CError tError = new CError();
/*  991 */       tError.moduleName = "MC2BMessageDB";
/*  992 */       tError.functionName = "hasMoreData";
/*  993 */       tError.errorMessage = ex.toString();
/*  994 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  997 */         this.mResultSet.close();
/*  998 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1004 */         this.mStatement.close();
/* 1005 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1009 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1013 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1018 */       return false;
/*      */     }
/* 1020 */     return flag;
/*      */   }
/*      */ 
/*      */   public MC2BMessageSet getData()
/*      */   {
/* 1025 */     int tCount = 0;
/* 1026 */     MC2BMessageSet tMC2BMessageSet = new MC2BMessageSet();
/* 1027 */     MC2BMessageSchema tMC2BMessageSchema = null;
/* 1028 */     if (this.mResultSet == null)
/*      */     {
/* 1030 */       CError tError = new CError();
/* 1031 */       tError.moduleName = "MC2BMessageDB";
/* 1032 */       tError.functionName = "getData";
/* 1033 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1034 */       this.mErrors.addOneError(tError);
/* 1035 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1039 */       tCount = 1;
/* 1040 */       tMC2BMessageSchema = new MC2BMessageSchema();
/* 1041 */       tMC2BMessageSchema.setSchema(this.mResultSet, 1);
/* 1042 */       tMC2BMessageSet.add(tMC2BMessageSchema);
/*      */ 
/* 1044 */       while (tCount++ < 5000)
/*      */       {
/* 1046 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1048 */         tMC2BMessageSchema = new MC2BMessageSchema();
/* 1049 */         tMC2BMessageSchema.setSchema(this.mResultSet, 1);
/* 1050 */         tMC2BMessageSet.add(tMC2BMessageSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1056 */       CError tError = new CError();
/* 1057 */       tError.moduleName = "MC2BMessageDB";
/* 1058 */       tError.functionName = "getData";
/* 1059 */       tError.errorMessage = ex.toString();
/* 1060 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1063 */         this.mResultSet.close();
/* 1064 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1070 */         this.mStatement.close();
/* 1071 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1075 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1079 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1084 */       return null;
/*      */     }
/* 1086 */     return tMC2BMessageSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1091 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1094 */       if (this.mResultSet == null)
/*      */       {
/* 1096 */         CError tError = new CError();
/* 1097 */         tError.moduleName = "MC2BMessageDB";
/* 1098 */         tError.functionName = "closeData";
/* 1099 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1100 */         this.mErrors.addOneError(tError);
/* 1101 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1105 */         this.mResultSet.close();
/* 1106 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1111 */       CError tError = new CError();
/* 1112 */       tError.moduleName = "MC2BMessageDB";
/* 1113 */       tError.functionName = "closeData";
/* 1114 */       tError.errorMessage = ex2.toString();
/* 1115 */       this.mErrors.addOneError(tError);
/* 1116 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1120 */       if (this.mStatement == null)
/*      */       {
/* 1122 */         CError tError = new CError();
/* 1123 */         tError.moduleName = "MC2BMessageDB";
/* 1124 */         tError.functionName = "closeData";
/* 1125 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1126 */         this.mErrors.addOneError(tError);
/* 1127 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1131 */         this.mStatement.close();
/* 1132 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1137 */       CError tError = new CError();
/* 1138 */       tError.moduleName = "MC2BMessageDB";
/* 1139 */       tError.functionName = "closeData";
/* 1140 */       tError.errorMessage = ex3.toString();
/* 1141 */       this.mErrors.addOneError(tError);
/* 1142 */       flag = false;
/*      */     }
/* 1144 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MC2BMessageDB
 * JD-Core Version:    0.6.0
 */