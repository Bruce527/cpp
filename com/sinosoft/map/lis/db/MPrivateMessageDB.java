/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MPrivateMessageSchema;
/*      */ import com.sinosoft.map.lis.vschema.MPrivateMessageSet;
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
/*      */ public class MPrivateMessageDB extends MPrivateMessageSchema
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
/*      */   public MPrivateMessageDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MPrivateMessage");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MPrivateMessage");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MPrivateMessageSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MPrivateMessageDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MPrivateMessageSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MPrivateMessageDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MPrivateMessage WHERE  ID = ?");
/*   95 */       if ((getID() == null) || (getID().equals("null")))
/*   96 */         pstmt.setNull(1, 12);
/*      */       else {
/*   98 */         pstmt.setString(1, getID());
/*      */       }
/*  100 */       pstmt.executeUpdate();
/*  101 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "MPrivateMessageDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MPrivateMessage SET  ID = ? , AgentCode = ? , ManageCom = ? , BranchType = ? , Message = ? , MessageType = ? , KeyData = ? , KeyData2 = ? , KeyData3 = ? , KeyData4 = ? , URL = ? , Type = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
/*  144 */       if ((getID() == null) || (getID().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getID());
/*      */       }
/*  149 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  154 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  159 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  164 */       if ((getMessage() == null) || (getMessage().equals("null")))
/*  165 */         pstmt.setNull(5, 12);
/*      */       else {
/*  167 */         pstmt.setString(5, getMessage());
/*      */       }
/*  169 */       if ((getMessageType() == null) || (getMessageType().equals("null")))
/*  170 */         pstmt.setNull(6, 12);
/*      */       else {
/*  172 */         pstmt.setString(6, getMessageType());
/*      */       }
/*  174 */       if ((getKeyData() == null) || (getKeyData().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getKeyData());
/*      */       }
/*  179 */       if ((getKeyData2() == null) || (getKeyData2().equals("null")))
/*  180 */         pstmt.setNull(8, 12);
/*      */       else {
/*  182 */         pstmt.setString(8, getKeyData2());
/*      */       }
/*  184 */       if ((getKeyData3() == null) || (getKeyData3().equals("null")))
/*  185 */         pstmt.setNull(9, 12);
/*      */       else {
/*  187 */         pstmt.setString(9, getKeyData3());
/*      */       }
/*  189 */       if ((getKeyData4() == null) || (getKeyData4().equals("null")))
/*  190 */         pstmt.setNull(10, 12);
/*      */       else {
/*  192 */         pstmt.setString(10, getKeyData4());
/*      */       }
/*  194 */       if ((getURL() == null) || (getURL().equals("null")))
/*  195 */         pstmt.setNull(11, 12);
/*      */       else {
/*  197 */         pstmt.setString(11, getURL());
/*      */       }
/*  199 */       if ((getType() == null) || (getType().equals("null")))
/*  200 */         pstmt.setNull(12, 12);
/*      */       else {
/*  202 */         pstmt.setString(12, getType());
/*      */       }
/*  204 */       if ((getState() == null) || (getState().equals("null")))
/*  205 */         pstmt.setNull(13, 12);
/*      */       else {
/*  207 */         pstmt.setString(13, getState());
/*      */       }
/*  209 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  210 */         pstmt.setNull(14, 91);
/*      */       else {
/*  212 */         pstmt.setDate(14, Date.valueOf(getStartDate()));
/*      */       }
/*  214 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  215 */         pstmt.setNull(15, 91);
/*      */       else {
/*  217 */         pstmt.setDate(15, Date.valueOf(getEndDate()));
/*      */       }
/*  219 */       if ((getStartTime() == null) || (getStartTime().equals("null")))
/*  220 */         pstmt.setNull(16, 12);
/*      */       else {
/*  222 */         pstmt.setString(16, getStartTime());
/*      */       }
/*  224 */       if ((getEndTime() == null) || (getEndTime().equals("null")))
/*  225 */         pstmt.setNull(17, 12);
/*      */       else {
/*  227 */         pstmt.setString(17, getEndTime());
/*      */       }
/*  229 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  230 */         pstmt.setNull(18, 12);
/*      */       else {
/*  232 */         pstmt.setString(18, getVF01());
/*      */       }
/*  234 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  235 */         pstmt.setNull(19, 12);
/*      */       else {
/*  237 */         pstmt.setString(19, getNF01());
/*      */       }
/*  239 */       pstmt.setInt(20, getIF01());
/*  240 */       pstmt.setDouble(21, getDF02());
/*  241 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  242 */         pstmt.setNull(22, 91);
/*      */       else {
/*  244 */         pstmt.setDate(22, Date.valueOf(getDate01()));
/*      */       }
/*  246 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  247 */         pstmt.setNull(23, 12);
/*      */       else {
/*  249 */         pstmt.setString(23, getOperator());
/*      */       }
/*  251 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  252 */         pstmt.setNull(24, 91);
/*      */       else {
/*  254 */         pstmt.setDate(24, Date.valueOf(getMakeDate()));
/*      */       }
/*  256 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  257 */         pstmt.setNull(25, 12);
/*      */       else {
/*  259 */         pstmt.setString(25, getMakeTime());
/*      */       }
/*      */ 
/*  262 */       if ((getID() == null) || (getID().equals("null")))
/*  263 */         pstmt.setNull(26, 12);
/*      */       else {
/*  265 */         pstmt.setString(26, getID());
/*      */       }
/*  267 */       pstmt.executeUpdate();
/*  268 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  271 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  272 */       CError tError = new CError();
/*  273 */       tError.moduleName = "MPrivateMessageDB";
/*  274 */       tError.functionName = "update()";
/*  275 */       tError.errorMessage = ex.toString();
/*  276 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  279 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  282 */       if (!this.mflag)
/*      */         try {
/*  284 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  288 */       return false;
/*      */     }
/*      */ 
/*  291 */     if (!this.mflag)
/*      */       try {
/*  293 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  297 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  302 */     PreparedStatement pstmt = null;
/*      */ 
/*  304 */     if (!this.mflag) {
/*  305 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  310 */       pstmt = this.con.prepareStatement("INSERT INTO MPrivateMessage VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  311 */       if ((getID() == null) || (getID().equals("null")))
/*  312 */         pstmt.setNull(1, 12);
/*      */       else {
/*  314 */         pstmt.setString(1, getID());
/*      */       }
/*  316 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  317 */         pstmt.setNull(2, 12);
/*      */       else {
/*  319 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  321 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  322 */         pstmt.setNull(3, 12);
/*      */       else {
/*  324 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  326 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  327 */         pstmt.setNull(4, 12);
/*      */       else {
/*  329 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  331 */       if ((getMessage() == null) || (getMessage().equals("null")))
/*  332 */         pstmt.setNull(5, 12);
/*      */       else {
/*  334 */         pstmt.setString(5, getMessage());
/*      */       }
/*  336 */       if ((getMessageType() == null) || (getMessageType().equals("null")))
/*  337 */         pstmt.setNull(6, 12);
/*      */       else {
/*  339 */         pstmt.setString(6, getMessageType());
/*      */       }
/*  341 */       if ((getKeyData() == null) || (getKeyData().equals("null")))
/*  342 */         pstmt.setNull(7, 12);
/*      */       else {
/*  344 */         pstmt.setString(7, getKeyData());
/*      */       }
/*  346 */       if ((getKeyData2() == null) || (getKeyData2().equals("null")))
/*  347 */         pstmt.setNull(8, 12);
/*      */       else {
/*  349 */         pstmt.setString(8, getKeyData2());
/*      */       }
/*  351 */       if ((getKeyData3() == null) || (getKeyData3().equals("null")))
/*  352 */         pstmt.setNull(9, 12);
/*      */       else {
/*  354 */         pstmt.setString(9, getKeyData3());
/*      */       }
/*  356 */       if ((getKeyData4() == null) || (getKeyData4().equals("null")))
/*  357 */         pstmt.setNull(10, 12);
/*      */       else {
/*  359 */         pstmt.setString(10, getKeyData4());
/*      */       }
/*  361 */       if ((getURL() == null) || (getURL().equals("null")))
/*  362 */         pstmt.setNull(11, 12);
/*      */       else {
/*  364 */         pstmt.setString(11, getURL());
/*      */       }
/*  366 */       if ((getType() == null) || (getType().equals("null")))
/*  367 */         pstmt.setNull(12, 12);
/*      */       else {
/*  369 */         pstmt.setString(12, getType());
/*      */       }
/*  371 */       if ((getState() == null) || (getState().equals("null")))
/*  372 */         pstmt.setNull(13, 12);
/*      */       else {
/*  374 */         pstmt.setString(13, getState());
/*      */       }
/*  376 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  377 */         pstmt.setNull(14, 91);
/*      */       else {
/*  379 */         pstmt.setDate(14, Date.valueOf(getStartDate()));
/*      */       }
/*  381 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  382 */         pstmt.setNull(15, 91);
/*      */       else {
/*  384 */         pstmt.setDate(15, Date.valueOf(getEndDate()));
/*      */       }
/*  386 */       if ((getStartTime() == null) || (getStartTime().equals("null")))
/*  387 */         pstmt.setNull(16, 12);
/*      */       else {
/*  389 */         pstmt.setString(16, getStartTime());
/*      */       }
/*  391 */       if ((getEndTime() == null) || (getEndTime().equals("null")))
/*  392 */         pstmt.setNull(17, 12);
/*      */       else {
/*  394 */         pstmt.setString(17, getEndTime());
/*      */       }
/*  396 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  397 */         pstmt.setNull(18, 12);
/*      */       else {
/*  399 */         pstmt.setString(18, getVF01());
/*      */       }
/*  401 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  402 */         pstmt.setNull(19, 12);
/*      */       else {
/*  404 */         pstmt.setString(19, getNF01());
/*      */       }
/*  406 */       pstmt.setInt(20, getIF01());
/*  407 */       pstmt.setDouble(21, getDF02());
/*  408 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  409 */         pstmt.setNull(22, 91);
/*      */       else {
/*  411 */         pstmt.setDate(22, Date.valueOf(getDate01()));
/*      */       }
/*  413 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  414 */         pstmt.setNull(23, 12);
/*      */       else {
/*  416 */         pstmt.setString(23, getOperator());
/*      */       }
/*  418 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  419 */         pstmt.setNull(24, 91);
/*      */       else {
/*  421 */         pstmt.setDate(24, Date.valueOf(getMakeDate()));
/*      */       }
/*  423 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  424 */         pstmt.setNull(25, 12);
/*      */       else {
/*  426 */         pstmt.setString(25, getMakeTime());
/*      */       }
/*      */ 
/*  429 */       pstmt.executeUpdate();
/*  430 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  433 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  434 */       CError tError = new CError();
/*  435 */       tError.moduleName = "MPrivateMessageDB";
/*  436 */       tError.functionName = "insert()";
/*  437 */       tError.errorMessage = ex.toString();
/*  438 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  441 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  444 */       if (!this.mflag)
/*      */         try {
/*  446 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  450 */       return false;
/*      */     }
/*      */ 
/*  453 */     if (!this.mflag)
/*      */       try {
/*  455 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  459 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  464 */     PreparedStatement pstmt = null;
/*  465 */     ResultSet rs = null;
/*      */ 
/*  467 */     if (!this.mflag) {
/*  468 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  473 */       pstmt = this.con.prepareStatement("SELECT * FROM MPrivateMessage WHERE  ID = ?", 
/*  474 */         1003, 1007);
/*  475 */       if ((getID() == null) || (getID().equals("null")))
/*  476 */         pstmt.setNull(1, 12);
/*      */       else {
/*  478 */         pstmt.setString(1, getID());
/*      */       }
/*  480 */       rs = pstmt.executeQuery();
/*  481 */       int i = 0;
/*  482 */       if (rs.next())
/*      */       {
/*  484 */         i++;
/*  485 */         if (!setSchema(rs, i))
/*      */         {
/*  488 */           CError tError = new CError();
/*  489 */           tError.moduleName = "MPrivateMessageDB";
/*  490 */           tError.functionName = "getInfo";
/*  491 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  492 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  494 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  497 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  501 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  505 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  509 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  512 */       if (i == 0)
/*      */       {
/*  514 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  518 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  522 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  528 */       CError tError = new CError();
/*  529 */       tError.moduleName = "MPrivateMessageDB";
/*  530 */       tError.functionName = "getInfo";
/*  531 */       tError.errorMessage = e.toString();
/*  532 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  534 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  537 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  541 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  545 */       return false;
/*      */     }
/*      */ 
/*  548 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  552 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  557 */     return true;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageSet query()
/*      */   {
/*  562 */     Statement stmt = null;
/*  563 */     ResultSet rs = null;
/*  564 */     MPrivateMessageSet aMPrivateMessageSet = new MPrivateMessageSet();
/*      */ 
/*  566 */     if (!this.mflag) {
/*  567 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  572 */       stmt = this.con.createStatement(1003, 1007);
/*  573 */       SQLString sqlObj = new SQLString("MPrivateMessage");
/*  574 */       MPrivateMessageSchema aSchema = getSchema();
/*  575 */       sqlObj.setSQL(5, aSchema);
/*  576 */       String sql = sqlObj.getSQL();
/*      */ 
/*  578 */       rs = stmt.executeQuery(sql);
/*  579 */       int i = 0;
/*  580 */       while (rs.next())
/*      */       {
/*  582 */         i++;
/*  583 */         MPrivateMessageSchema s1 = new MPrivateMessageSchema();
/*  584 */         s1.setSchema(rs, i);
/*  585 */         aMPrivateMessageSet.add(s1);
/*      */       }try {
/*  587 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  593 */       CError tError = new CError();
/*  594 */       tError.moduleName = "MPrivateMessageDB";
/*  595 */       tError.functionName = "query";
/*  596 */       tError.errorMessage = e.toString();
/*  597 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  599 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  602 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  606 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  612 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  616 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  621 */     return aMPrivateMessageSet;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageSet executeQuery(String sql)
/*      */   {
/*  626 */     Statement stmt = null;
/*  627 */     ResultSet rs = null;
/*  628 */     MPrivateMessageSet aMPrivateMessageSet = new MPrivateMessageSet();
/*      */ 
/*  630 */     if (!this.mflag) {
/*  631 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  636 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  638 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  639 */       int i = 0;
/*  640 */       while (rs.next())
/*      */       {
/*  642 */         i++;
/*  643 */         MPrivateMessageSchema s1 = new MPrivateMessageSchema();
/*  644 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  647 */           CError tError = new CError();
/*  648 */           tError.moduleName = "MPrivateMessageDB";
/*  649 */           tError.functionName = "executeQuery";
/*  650 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  651 */           this.mErrors.addOneError(tError);
/*      */         }
/*  653 */         aMPrivateMessageSet.add(s1);
/*      */       }try {
/*  655 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  661 */       CError tError = new CError();
/*  662 */       tError.moduleName = "MPrivateMessageDB";
/*  663 */       tError.functionName = "executeQuery";
/*  664 */       tError.errorMessage = e.toString();
/*  665 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  667 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  670 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  674 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  680 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  684 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  689 */     return aMPrivateMessageSet;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageSet query(int nStart, int nCount)
/*      */   {
/*  694 */     Statement stmt = null;
/*  695 */     ResultSet rs = null;
/*  696 */     MPrivateMessageSet aMPrivateMessageSet = new MPrivateMessageSet();
/*      */ 
/*  698 */     if (!this.mflag) {
/*  699 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  704 */       stmt = this.con.createStatement(1003, 1007);
/*  705 */       SQLString sqlObj = new SQLString("MPrivateMessage");
/*  706 */       MPrivateMessageSchema aSchema = getSchema();
/*  707 */       sqlObj.setSQL(5, aSchema);
/*  708 */       String sql = sqlObj.getSQL();
/*      */ 
/*  710 */       rs = stmt.executeQuery(sql);
/*  711 */       int i = 0;
/*  712 */       while (rs.next())
/*      */       {
/*  714 */         i++;
/*      */ 
/*  716 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  720 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  724 */         MPrivateMessageSchema s1 = new MPrivateMessageSchema();
/*  725 */         s1.setSchema(rs, i);
/*  726 */         aMPrivateMessageSet.add(s1);
/*      */       }try {
/*  728 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  734 */       CError tError = new CError();
/*  735 */       tError.moduleName = "MPrivateMessageDB";
/*  736 */       tError.functionName = "query";
/*  737 */       tError.errorMessage = e.toString();
/*  738 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  740 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  743 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  747 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  753 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  757 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  762 */     return aMPrivateMessageSet;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  767 */     Statement stmt = null;
/*  768 */     ResultSet rs = null;
/*  769 */     MPrivateMessageSet aMPrivateMessageSet = new MPrivateMessageSet();
/*      */ 
/*  771 */     if (!this.mflag) {
/*  772 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  777 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  779 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  780 */       int i = 0;
/*  781 */       while (rs.next())
/*      */       {
/*  783 */         i++;
/*      */ 
/*  785 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  789 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  793 */         MPrivateMessageSchema s1 = new MPrivateMessageSchema();
/*  794 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  797 */           CError tError = new CError();
/*  798 */           tError.moduleName = "MPrivateMessageDB";
/*  799 */           tError.functionName = "executeQuery";
/*  800 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  801 */           this.mErrors.addOneError(tError);
/*      */         }
/*  803 */         aMPrivateMessageSet.add(s1);
/*      */       }try {
/*  805 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  811 */       CError tError = new CError();
/*  812 */       tError.moduleName = "MPrivateMessageDB";
/*  813 */       tError.functionName = "executeQuery";
/*  814 */       tError.errorMessage = e.toString();
/*  815 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  817 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  820 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  824 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  830 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  834 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  839 */     return aMPrivateMessageSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  844 */     Statement stmt = null;
/*      */ 
/*  846 */     if (!this.mflag) {
/*  847 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  852 */       stmt = this.con.createStatement(1003, 1007);
/*  853 */       SQLString sqlObj = new SQLString("MPrivateMessage");
/*  854 */       MPrivateMessageSchema aSchema = getSchema();
/*  855 */       sqlObj.setSQL(2, aSchema);
/*  856 */       String sql = "update MPrivateMessage " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  858 */       int operCount = stmt.executeUpdate(sql);
/*  859 */       if (operCount == 0)
/*      */       {
/*  862 */         CError tError = new CError();
/*  863 */         tError.moduleName = "MPrivateMessageDB";
/*  864 */         tError.functionName = "update";
/*  865 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  866 */         this.mErrors.addOneError(tError);
/*      */ 
/*  868 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  872 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  876 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  882 */       CError tError = new CError();
/*  883 */       tError.moduleName = "MPrivateMessageDB";
/*  884 */       tError.functionName = "update";
/*  885 */       tError.errorMessage = e.toString();
/*  886 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  888 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  890 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  894 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  898 */       return false;
/*      */     }
/*      */ 
/*  901 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  905 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  910 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  916 */     if (this.mResultSet != null)
/*      */     {
/*  919 */       CError tError = new CError();
/*  920 */       tError.moduleName = "MPrivateMessageDB";
/*  921 */       tError.functionName = "prepareData";
/*  922 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  923 */       this.mErrors.addOneError(tError);
/*  924 */       return false;
/*      */     }
/*      */ 
/*  927 */     if (!this.mflag)
/*      */     {
/*  929 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  933 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  934 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  939 */       CError tError = new CError();
/*  940 */       tError.moduleName = "MPrivateMessageDB";
/*  941 */       tError.functionName = "prepareData";
/*  942 */       tError.errorMessage = e.toString();
/*  943 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  946 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  952 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  956 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  960 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  965 */       return false;
/*      */     }
/*      */ 
/*  968 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  972 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  977 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  983 */     boolean flag = true;
/*  984 */     if (this.mResultSet == null)
/*      */     {
/*  986 */       CError tError = new CError();
/*  987 */       tError.moduleName = "MPrivateMessageDB";
/*  988 */       tError.functionName = "hasMoreData";
/*  989 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  990 */       this.mErrors.addOneError(tError);
/*  991 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  995 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  999 */       CError tError = new CError();
/* 1000 */       tError.moduleName = "MPrivateMessageDB";
/* 1001 */       tError.functionName = "hasMoreData";
/* 1002 */       tError.errorMessage = ex.toString();
/* 1003 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1006 */         this.mResultSet.close();
/* 1007 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1013 */         this.mStatement.close();
/* 1014 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1018 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1022 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1027 */       return false;
/*      */     }
/* 1029 */     return flag;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageSet getData()
/*      */   {
/* 1034 */     int tCount = 0;
/* 1035 */     MPrivateMessageSet tMPrivateMessageSet = new MPrivateMessageSet();
/* 1036 */     MPrivateMessageSchema tMPrivateMessageSchema = null;
/* 1037 */     if (this.mResultSet == null)
/*      */     {
/* 1039 */       CError tError = new CError();
/* 1040 */       tError.moduleName = "MPrivateMessageDB";
/* 1041 */       tError.functionName = "getData";
/* 1042 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1043 */       this.mErrors.addOneError(tError);
/* 1044 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1048 */       tCount = 1;
/* 1049 */       tMPrivateMessageSchema = new MPrivateMessageSchema();
/* 1050 */       tMPrivateMessageSchema.setSchema(this.mResultSet, 1);
/* 1051 */       tMPrivateMessageSet.add(tMPrivateMessageSchema);
/*      */ 
/* 1053 */       while (tCount++ < 5000)
/*      */       {
/* 1055 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1057 */         tMPrivateMessageSchema = new MPrivateMessageSchema();
/* 1058 */         tMPrivateMessageSchema.setSchema(this.mResultSet, 1);
/* 1059 */         tMPrivateMessageSet.add(tMPrivateMessageSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1065 */       CError tError = new CError();
/* 1066 */       tError.moduleName = "MPrivateMessageDB";
/* 1067 */       tError.functionName = "getData";
/* 1068 */       tError.errorMessage = ex.toString();
/* 1069 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1072 */         this.mResultSet.close();
/* 1073 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1079 */         this.mStatement.close();
/* 1080 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1084 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1088 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1093 */       return null;
/*      */     }
/* 1095 */     return tMPrivateMessageSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1100 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1103 */       if (this.mResultSet == null)
/*      */       {
/* 1105 */         CError tError = new CError();
/* 1106 */         tError.moduleName = "MPrivateMessageDB";
/* 1107 */         tError.functionName = "closeData";
/* 1108 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1109 */         this.mErrors.addOneError(tError);
/* 1110 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1114 */         this.mResultSet.close();
/* 1115 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1120 */       CError tError = new CError();
/* 1121 */       tError.moduleName = "MPrivateMessageDB";
/* 1122 */       tError.functionName = "closeData";
/* 1123 */       tError.errorMessage = ex2.toString();
/* 1124 */       this.mErrors.addOneError(tError);
/* 1125 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1129 */       if (this.mStatement == null)
/*      */       {
/* 1131 */         CError tError = new CError();
/* 1132 */         tError.moduleName = "MPrivateMessageDB";
/* 1133 */         tError.functionName = "closeData";
/* 1134 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1135 */         this.mErrors.addOneError(tError);
/* 1136 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1140 */         this.mStatement.close();
/* 1141 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1146 */       CError tError = new CError();
/* 1147 */       tError.moduleName = "MPrivateMessageDB";
/* 1148 */       tError.functionName = "closeData";
/* 1149 */       tError.errorMessage = ex3.toString();
/* 1150 */       this.mErrors.addOneError(tError);
/* 1151 */       flag = false;
/*      */     }
/* 1153 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MPrivateMessageDB
 * JD-Core Version:    0.6.0
 */