/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MPrivateMessageBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MPrivateMessageBSet;
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
/*      */ public class MPrivateMessageBDB extends MPrivateMessageBSchema
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
/*      */   public MPrivateMessageBDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MPrivateMessageB");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageBDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MPrivateMessageB");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MPrivateMessageBSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MPrivateMessageBDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MPrivateMessageBSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MPrivateMessageBDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MPrivateMessageB WHERE  ID = ?");
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
/*  106 */       tError.moduleName = "MPrivateMessageBDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MPrivateMessageB SET  ID = ? , AgentCode = ? , ManageCom = ? , BranchType = ? , Message = ? , MessageType = ? , KeyData = ? , KeyData2 = ? , KeyData3 = ? , KeyData4 = ? , URL = ? , Type = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  ID = ?");
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
/*  261 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  262 */         pstmt.setNull(26, 12);
/*      */       else {
/*  264 */         pstmt.setString(26, getEdorNo());
/*      */       }
/*  266 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  267 */         pstmt.setNull(27, 12);
/*      */       else {
/*  269 */         pstmt.setString(27, getEdorType());
/*      */       }
/*  271 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  272 */         pstmt.setNull(28, 12);
/*      */       else {
/*  274 */         pstmt.setString(28, getEdorCase());
/*      */       }
/*  276 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  277 */         pstmt.setNull(29, 12);
/*      */       else {
/*  279 */         pstmt.setString(29, getOperator2());
/*      */       }
/*  281 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  282 */         pstmt.setNull(30, 91);
/*      */       else {
/*  284 */         pstmt.setDate(30, Date.valueOf(getMakeDate2()));
/*      */       }
/*  286 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  287 */         pstmt.setNull(31, 12);
/*      */       else {
/*  289 */         pstmt.setString(31, getMakeTime2());
/*      */       }
/*      */ 
/*  292 */       if ((getID() == null) || (getID().equals("null")))
/*  293 */         pstmt.setNull(32, 12);
/*      */       else {
/*  295 */         pstmt.setString(32, getID());
/*      */       }
/*  297 */       pstmt.executeUpdate();
/*  298 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  301 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  302 */       CError tError = new CError();
/*  303 */       tError.moduleName = "MPrivateMessageBDB";
/*  304 */       tError.functionName = "update()";
/*  305 */       tError.errorMessage = ex.toString();
/*  306 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  309 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  312 */       if (!this.mflag)
/*      */         try {
/*  314 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  318 */       return false;
/*      */     }
/*      */ 
/*  321 */     if (!this.mflag)
/*      */       try {
/*  323 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  327 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  332 */     PreparedStatement pstmt = null;
/*      */ 
/*  334 */     if (!this.mflag) {
/*  335 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  340 */       pstmt = this.con.prepareStatement("INSERT INTO MPrivateMessageB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  341 */       if ((getID() == null) || (getID().equals("null")))
/*  342 */         pstmt.setNull(1, 12);
/*      */       else {
/*  344 */         pstmt.setString(1, getID());
/*      */       }
/*  346 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  347 */         pstmt.setNull(2, 12);
/*      */       else {
/*  349 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  351 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  352 */         pstmt.setNull(3, 12);
/*      */       else {
/*  354 */         pstmt.setString(3, getManageCom());
/*      */       }
/*  356 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  357 */         pstmt.setNull(4, 12);
/*      */       else {
/*  359 */         pstmt.setString(4, getBranchType());
/*      */       }
/*  361 */       if ((getMessage() == null) || (getMessage().equals("null")))
/*  362 */         pstmt.setNull(5, 12);
/*      */       else {
/*  364 */         pstmt.setString(5, getMessage());
/*      */       }
/*  366 */       if ((getMessageType() == null) || (getMessageType().equals("null")))
/*  367 */         pstmt.setNull(6, 12);
/*      */       else {
/*  369 */         pstmt.setString(6, getMessageType());
/*      */       }
/*  371 */       if ((getKeyData() == null) || (getKeyData().equals("null")))
/*  372 */         pstmt.setNull(7, 12);
/*      */       else {
/*  374 */         pstmt.setString(7, getKeyData());
/*      */       }
/*  376 */       if ((getKeyData2() == null) || (getKeyData2().equals("null")))
/*  377 */         pstmt.setNull(8, 12);
/*      */       else {
/*  379 */         pstmt.setString(8, getKeyData2());
/*      */       }
/*  381 */       if ((getKeyData3() == null) || (getKeyData3().equals("null")))
/*  382 */         pstmt.setNull(9, 12);
/*      */       else {
/*  384 */         pstmt.setString(9, getKeyData3());
/*      */       }
/*  386 */       if ((getKeyData4() == null) || (getKeyData4().equals("null")))
/*  387 */         pstmt.setNull(10, 12);
/*      */       else {
/*  389 */         pstmt.setString(10, getKeyData4());
/*      */       }
/*  391 */       if ((getURL() == null) || (getURL().equals("null")))
/*  392 */         pstmt.setNull(11, 12);
/*      */       else {
/*  394 */         pstmt.setString(11, getURL());
/*      */       }
/*  396 */       if ((getType() == null) || (getType().equals("null")))
/*  397 */         pstmt.setNull(12, 12);
/*      */       else {
/*  399 */         pstmt.setString(12, getType());
/*      */       }
/*  401 */       if ((getState() == null) || (getState().equals("null")))
/*  402 */         pstmt.setNull(13, 12);
/*      */       else {
/*  404 */         pstmt.setString(13, getState());
/*      */       }
/*  406 */       if ((getStartDate() == null) || (getStartDate().equals("null")))
/*  407 */         pstmt.setNull(14, 91);
/*      */       else {
/*  409 */         pstmt.setDate(14, Date.valueOf(getStartDate()));
/*      */       }
/*  411 */       if ((getEndDate() == null) || (getEndDate().equals("null")))
/*  412 */         pstmt.setNull(15, 91);
/*      */       else {
/*  414 */         pstmt.setDate(15, Date.valueOf(getEndDate()));
/*      */       }
/*  416 */       if ((getStartTime() == null) || (getStartTime().equals("null")))
/*  417 */         pstmt.setNull(16, 12);
/*      */       else {
/*  419 */         pstmt.setString(16, getStartTime());
/*      */       }
/*  421 */       if ((getEndTime() == null) || (getEndTime().equals("null")))
/*  422 */         pstmt.setNull(17, 12);
/*      */       else {
/*  424 */         pstmt.setString(17, getEndTime());
/*      */       }
/*  426 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  427 */         pstmt.setNull(18, 12);
/*      */       else {
/*  429 */         pstmt.setString(18, getVF01());
/*      */       }
/*  431 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  432 */         pstmt.setNull(19, 12);
/*      */       else {
/*  434 */         pstmt.setString(19, getNF01());
/*      */       }
/*  436 */       pstmt.setInt(20, getIF01());
/*  437 */       pstmt.setDouble(21, getDF02());
/*  438 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  439 */         pstmt.setNull(22, 91);
/*      */       else {
/*  441 */         pstmt.setDate(22, Date.valueOf(getDate01()));
/*      */       }
/*  443 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  444 */         pstmt.setNull(23, 12);
/*      */       else {
/*  446 */         pstmt.setString(23, getOperator());
/*      */       }
/*  448 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  449 */         pstmt.setNull(24, 91);
/*      */       else {
/*  451 */         pstmt.setDate(24, Date.valueOf(getMakeDate()));
/*      */       }
/*  453 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  454 */         pstmt.setNull(25, 12);
/*      */       else {
/*  456 */         pstmt.setString(25, getMakeTime());
/*      */       }
/*  458 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  459 */         pstmt.setNull(26, 12);
/*      */       else {
/*  461 */         pstmt.setString(26, getEdorNo());
/*      */       }
/*  463 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  464 */         pstmt.setNull(27, 12);
/*      */       else {
/*  466 */         pstmt.setString(27, getEdorType());
/*      */       }
/*  468 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  469 */         pstmt.setNull(28, 12);
/*      */       else {
/*  471 */         pstmt.setString(28, getEdorCase());
/*      */       }
/*  473 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  474 */         pstmt.setNull(29, 12);
/*      */       else {
/*  476 */         pstmt.setString(29, getOperator2());
/*      */       }
/*  478 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  479 */         pstmt.setNull(30, 91);
/*      */       else {
/*  481 */         pstmt.setDate(30, Date.valueOf(getMakeDate2()));
/*      */       }
/*  483 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  484 */         pstmt.setNull(31, 12);
/*      */       else {
/*  486 */         pstmt.setString(31, getMakeTime2());
/*      */       }
/*      */ 
/*  489 */       pstmt.executeUpdate();
/*  490 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  493 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  494 */       CError tError = new CError();
/*  495 */       tError.moduleName = "MPrivateMessageBDB";
/*  496 */       tError.functionName = "insert()";
/*  497 */       tError.errorMessage = ex.toString();
/*  498 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  501 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  504 */       if (!this.mflag)
/*      */         try {
/*  506 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  510 */       return false;
/*      */     }
/*      */ 
/*  513 */     if (!this.mflag)
/*      */       try {
/*  515 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  519 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  524 */     PreparedStatement pstmt = null;
/*  525 */     ResultSet rs = null;
/*      */ 
/*  527 */     if (!this.mflag) {
/*  528 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  533 */       pstmt = this.con.prepareStatement("SELECT * FROM MPrivateMessageB WHERE  ID = ?", 
/*  534 */         1003, 1007);
/*  535 */       if ((getID() == null) || (getID().equals("null")))
/*  536 */         pstmt.setNull(1, 12);
/*      */       else {
/*  538 */         pstmt.setString(1, getID());
/*      */       }
/*  540 */       rs = pstmt.executeQuery();
/*  541 */       int i = 0;
/*  542 */       if (rs.next())
/*      */       {
/*  544 */         i++;
/*  545 */         if (!setSchema(rs, i))
/*      */         {
/*  548 */           CError tError = new CError();
/*  549 */           tError.moduleName = "MPrivateMessageBDB";
/*  550 */           tError.functionName = "getInfo";
/*  551 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  552 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  554 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  557 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  561 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  565 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  569 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  572 */       if (i == 0)
/*      */       {
/*  574 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  578 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  582 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  588 */       CError tError = new CError();
/*  589 */       tError.moduleName = "MPrivateMessageBDB";
/*  590 */       tError.functionName = "getInfo";
/*  591 */       tError.errorMessage = e.toString();
/*  592 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  594 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  597 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  601 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  605 */       return false;
/*      */     }
/*      */ 
/*  608 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  612 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  617 */     return true;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageBSet query()
/*      */   {
/*  622 */     Statement stmt = null;
/*  623 */     ResultSet rs = null;
/*  624 */     MPrivateMessageBSet aMPrivateMessageBSet = new MPrivateMessageBSet();
/*      */ 
/*  626 */     if (!this.mflag) {
/*  627 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  632 */       stmt = this.con.createStatement(1003, 1007);
/*  633 */       SQLString sqlObj = new SQLString("MPrivateMessageB");
/*  634 */       MPrivateMessageBSchema aSchema = getSchema();
/*  635 */       sqlObj.setSQL(5, aSchema);
/*  636 */       String sql = sqlObj.getSQL();
/*      */ 
/*  638 */       rs = stmt.executeQuery(sql);
/*  639 */       int i = 0;
/*  640 */       while (rs.next())
/*      */       {
/*  642 */         i++;
/*  643 */         MPrivateMessageBSchema s1 = new MPrivateMessageBSchema();
/*  644 */         s1.setSchema(rs, i);
/*  645 */         aMPrivateMessageBSet.add(s1);
/*      */       }try {
/*  647 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  653 */       CError tError = new CError();
/*  654 */       tError.moduleName = "MPrivateMessageBDB";
/*  655 */       tError.functionName = "query";
/*  656 */       tError.errorMessage = e.toString();
/*  657 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  659 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  662 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  666 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  672 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  676 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  681 */     return aMPrivateMessageBSet;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageBSet executeQuery(String sql)
/*      */   {
/*  686 */     Statement stmt = null;
/*  687 */     ResultSet rs = null;
/*  688 */     MPrivateMessageBSet aMPrivateMessageBSet = new MPrivateMessageBSet();
/*      */ 
/*  690 */     if (!this.mflag) {
/*  691 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  696 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  698 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  699 */       int i = 0;
/*  700 */       while (rs.next())
/*      */       {
/*  702 */         i++;
/*  703 */         MPrivateMessageBSchema s1 = new MPrivateMessageBSchema();
/*  704 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  707 */           CError tError = new CError();
/*  708 */           tError.moduleName = "MPrivateMessageBDB";
/*  709 */           tError.functionName = "executeQuery";
/*  710 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  711 */           this.mErrors.addOneError(tError);
/*      */         }
/*  713 */         aMPrivateMessageBSet.add(s1);
/*      */       }try {
/*  715 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  721 */       CError tError = new CError();
/*  722 */       tError.moduleName = "MPrivateMessageBDB";
/*  723 */       tError.functionName = "executeQuery";
/*  724 */       tError.errorMessage = e.toString();
/*  725 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  727 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  730 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  734 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  740 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  744 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  749 */     return aMPrivateMessageBSet;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageBSet query(int nStart, int nCount)
/*      */   {
/*  754 */     Statement stmt = null;
/*  755 */     ResultSet rs = null;
/*  756 */     MPrivateMessageBSet aMPrivateMessageBSet = new MPrivateMessageBSet();
/*      */ 
/*  758 */     if (!this.mflag) {
/*  759 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  764 */       stmt = this.con.createStatement(1003, 1007);
/*  765 */       SQLString sqlObj = new SQLString("MPrivateMessageB");
/*  766 */       MPrivateMessageBSchema aSchema = getSchema();
/*  767 */       sqlObj.setSQL(5, aSchema);
/*  768 */       String sql = sqlObj.getSQL();
/*      */ 
/*  770 */       rs = stmt.executeQuery(sql);
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
/*  784 */         MPrivateMessageBSchema s1 = new MPrivateMessageBSchema();
/*  785 */         s1.setSchema(rs, i);
/*  786 */         aMPrivateMessageBSet.add(s1);
/*      */       }try {
/*  788 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  794 */       CError tError = new CError();
/*  795 */       tError.moduleName = "MPrivateMessageBDB";
/*  796 */       tError.functionName = "query";
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
/*  822 */     return aMPrivateMessageBSet;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  827 */     Statement stmt = null;
/*  828 */     ResultSet rs = null;
/*  829 */     MPrivateMessageBSet aMPrivateMessageBSet = new MPrivateMessageBSet();
/*      */ 
/*  831 */     if (!this.mflag) {
/*  832 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  837 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  839 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  840 */       int i = 0;
/*  841 */       while (rs.next())
/*      */       {
/*  843 */         i++;
/*      */ 
/*  845 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  849 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  853 */         MPrivateMessageBSchema s1 = new MPrivateMessageBSchema();
/*  854 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  857 */           CError tError = new CError();
/*  858 */           tError.moduleName = "MPrivateMessageBDB";
/*  859 */           tError.functionName = "executeQuery";
/*  860 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  861 */           this.mErrors.addOneError(tError);
/*      */         }
/*  863 */         aMPrivateMessageBSet.add(s1);
/*      */       }try {
/*  865 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  871 */       CError tError = new CError();
/*  872 */       tError.moduleName = "MPrivateMessageBDB";
/*  873 */       tError.functionName = "executeQuery";
/*  874 */       tError.errorMessage = e.toString();
/*  875 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  877 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  880 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  884 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  890 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  894 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  899 */     return aMPrivateMessageBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  904 */     Statement stmt = null;
/*      */ 
/*  906 */     if (!this.mflag) {
/*  907 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  912 */       stmt = this.con.createStatement(1003, 1007);
/*  913 */       SQLString sqlObj = new SQLString("MPrivateMessageB");
/*  914 */       MPrivateMessageBSchema aSchema = getSchema();
/*  915 */       sqlObj.setSQL(2, aSchema);
/*  916 */       String sql = "update MPrivateMessageB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  918 */       int operCount = stmt.executeUpdate(sql);
/*  919 */       if (operCount == 0)
/*      */       {
/*  922 */         CError tError = new CError();
/*  923 */         tError.moduleName = "MPrivateMessageBDB";
/*  924 */         tError.functionName = "update";
/*  925 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  926 */         this.mErrors.addOneError(tError);
/*      */ 
/*  928 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  932 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  936 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  942 */       CError tError = new CError();
/*  943 */       tError.moduleName = "MPrivateMessageBDB";
/*  944 */       tError.functionName = "update";
/*  945 */       tError.errorMessage = e.toString();
/*  946 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  948 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  950 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  954 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  958 */       return false;
/*      */     }
/*      */ 
/*  961 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  965 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  970 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  976 */     if (this.mResultSet != null)
/*      */     {
/*  979 */       CError tError = new CError();
/*  980 */       tError.moduleName = "MPrivateMessageBDB";
/*  981 */       tError.functionName = "prepareData";
/*  982 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  983 */       this.mErrors.addOneError(tError);
/*  984 */       return false;
/*      */     }
/*      */ 
/*  987 */     if (!this.mflag)
/*      */     {
/*  989 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  993 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  994 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  999 */       CError tError = new CError();
/* 1000 */       tError.moduleName = "MPrivateMessageBDB";
/* 1001 */       tError.functionName = "prepareData";
/* 1002 */       tError.errorMessage = e.toString();
/* 1003 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1006 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1012 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1016 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1020 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1025 */       return false;
/*      */     }
/*      */ 
/* 1028 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/* 1032 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/* 1037 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/* 1043 */     boolean flag = true;
/* 1044 */     if (this.mResultSet == null)
/*      */     {
/* 1046 */       CError tError = new CError();
/* 1047 */       tError.moduleName = "MPrivateMessageBDB";
/* 1048 */       tError.functionName = "hasMoreData";
/* 1049 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1050 */       this.mErrors.addOneError(tError);
/* 1051 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1055 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1059 */       CError tError = new CError();
/* 1060 */       tError.moduleName = "MPrivateMessageBDB";
/* 1061 */       tError.functionName = "hasMoreData";
/* 1062 */       tError.errorMessage = ex.toString();
/* 1063 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1066 */         this.mResultSet.close();
/* 1067 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1073 */         this.mStatement.close();
/* 1074 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1078 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1082 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1087 */       return false;
/*      */     }
/* 1089 */     return flag;
/*      */   }
/*      */ 
/*      */   public MPrivateMessageBSet getData()
/*      */   {
/* 1094 */     int tCount = 0;
/* 1095 */     MPrivateMessageBSet tMPrivateMessageBSet = new MPrivateMessageBSet();
/* 1096 */     MPrivateMessageBSchema tMPrivateMessageBSchema = null;
/* 1097 */     if (this.mResultSet == null)
/*      */     {
/* 1099 */       CError tError = new CError();
/* 1100 */       tError.moduleName = "MPrivateMessageBDB";
/* 1101 */       tError.functionName = "getData";
/* 1102 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1103 */       this.mErrors.addOneError(tError);
/* 1104 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1108 */       tCount = 1;
/* 1109 */       tMPrivateMessageBSchema = new MPrivateMessageBSchema();
/* 1110 */       tMPrivateMessageBSchema.setSchema(this.mResultSet, 1);
/* 1111 */       tMPrivateMessageBSet.add(tMPrivateMessageBSchema);
/*      */ 
/* 1113 */       while (tCount++ < 5000)
/*      */       {
/* 1115 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1117 */         tMPrivateMessageBSchema = new MPrivateMessageBSchema();
/* 1118 */         tMPrivateMessageBSchema.setSchema(this.mResultSet, 1);
/* 1119 */         tMPrivateMessageBSet.add(tMPrivateMessageBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1125 */       CError tError = new CError();
/* 1126 */       tError.moduleName = "MPrivateMessageBDB";
/* 1127 */       tError.functionName = "getData";
/* 1128 */       tError.errorMessage = ex.toString();
/* 1129 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1132 */         this.mResultSet.close();
/* 1133 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1139 */         this.mStatement.close();
/* 1140 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1144 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1148 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1153 */       return null;
/*      */     }
/* 1155 */     return tMPrivateMessageBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1160 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1163 */       if (this.mResultSet == null)
/*      */       {
/* 1165 */         CError tError = new CError();
/* 1166 */         tError.moduleName = "MPrivateMessageBDB";
/* 1167 */         tError.functionName = "closeData";
/* 1168 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1169 */         this.mErrors.addOneError(tError);
/* 1170 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1174 */         this.mResultSet.close();
/* 1175 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1180 */       CError tError = new CError();
/* 1181 */       tError.moduleName = "MPrivateMessageBDB";
/* 1182 */       tError.functionName = "closeData";
/* 1183 */       tError.errorMessage = ex2.toString();
/* 1184 */       this.mErrors.addOneError(tError);
/* 1185 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1189 */       if (this.mStatement == null)
/*      */       {
/* 1191 */         CError tError = new CError();
/* 1192 */         tError.moduleName = "MPrivateMessageBDB";
/* 1193 */         tError.functionName = "closeData";
/* 1194 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1195 */         this.mErrors.addOneError(tError);
/* 1196 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1200 */         this.mStatement.close();
/* 1201 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1206 */       CError tError = new CError();
/* 1207 */       tError.moduleName = "MPrivateMessageBDB";
/* 1208 */       tError.functionName = "closeData";
/* 1209 */       tError.errorMessage = ex3.toString();
/* 1210 */       this.mErrors.addOneError(tError);
/* 1211 */       flag = false;
/*      */     }
/* 1213 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MPrivateMessageBDB
 * JD-Core Version:    0.6.0
 */