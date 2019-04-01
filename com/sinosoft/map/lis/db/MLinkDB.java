/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MLinkSchema;
/*      */ import com.sinosoft.map.lis.vschema.MLinkSet;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.DBConnPool;
/*      */ import com.sinosoft.map.utility.DBOper;
/*      */ import com.sinosoft.map.utility.SQLString;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class MLinkDB extends MLinkSchema
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
/*      */   public MLinkDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MLink");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MLinkDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MLink");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MLinkSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MLinkDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MLinkSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MLinkDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MLink WHERE  ID = ?");
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
/*  107 */       tError.moduleName = "MLinkDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MLink SET  ID = ? , AgentCode = ? , RefURL = ? , Target = ? , Name = ? , LinkOrder = ? , State = ? , Type = ? , Icon = ? , ManageCom = ? , BranchType = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Description = ? WHERE  ID = ?");
/*  145 */       if ((getID() == null) || (getID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getID());
/*      */       }
/*  150 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  155 */       if ((getRefURL() == null) || (getRefURL().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getRefURL());
/*      */       }
/*  160 */       if ((getTarget() == null) || (getTarget().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getTarget());
/*      */       }
/*  165 */       if ((getName() == null) || (getName().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getName());
/*      */       }
/*  170 */       pstmt.setInt(6, getLinkOrder());
/*  171 */       if ((getState() == null) || (getState().equals("null")))
/*  172 */         pstmt.setNull(7, 12);
/*      */       else {
/*  174 */         pstmt.setString(7, getState());
/*      */       }
/*  176 */       if ((getType() == null) || (getType().equals("null")))
/*  177 */         pstmt.setNull(8, 12);
/*      */       else {
/*  179 */         pstmt.setString(8, getType());
/*      */       }
/*  181 */       if ((getIcon() == null) || (getIcon().equals("null")))
/*  182 */         pstmt.setNull(9, 12);
/*      */       else {
/*  184 */         pstmt.setString(9, getIcon());
/*      */       }
/*  186 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  187 */         pstmt.setNull(10, 12);
/*      */       else {
/*  189 */         pstmt.setString(10, getManageCom());
/*      */       }
/*  191 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  192 */         pstmt.setNull(11, 12);
/*      */       else {
/*  194 */         pstmt.setString(11, getBranchType());
/*      */       }
/*  196 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  197 */         pstmt.setNull(12, 12);
/*      */       else {
/*  199 */         pstmt.setString(12, getVF01());
/*      */       }
/*  201 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  202 */         pstmt.setNull(13, 12);
/*      */       else {
/*  204 */         pstmt.setString(13, getNF01());
/*      */       }
/*  206 */       pstmt.setInt(14, getIF01());
/*  207 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  208 */         pstmt.setNull(17, 12);
/*      */       else {
/*  210 */         pstmt.setString(17, getModifyOperator());
/*      */       }
/*  212 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  213 */         pstmt.setNull(18, 12);
/*      */       else {
/*  215 */         pstmt.setString(18, getOperator());
/*      */       }
/*  217 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  218 */         pstmt.setNull(20, 12);
/*      */       else {
/*  220 */         pstmt.setString(20, getMakeTime());
/*      */       }
/*  222 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  223 */         pstmt.setNull(22, 12);
/*      */       else {
/*  225 */         pstmt.setString(22, getModifyTime());
/*      */       }
/*  227 */       if ((getDescription() == null) || (getDescription().equals("null")))
/*  228 */         pstmt.setNull(23, 12);
/*      */       else {
/*  230 */         pstmt.setString(23, getDescription());
/*      */       }
/*      */ 
/*  233 */       if ((getID() == null) || (getID().equals("null")))
/*  234 */         pstmt.setNull(24, 12);
/*      */       else {
/*  236 */         pstmt.setString(24, getID());
/*      */       }
/*  238 */       pstmt.executeUpdate();
/*  239 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  242 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  243 */       CError tError = new CError();
/*  244 */       tError.moduleName = "MLinkDB";
/*  245 */       tError.functionName = "update()";
/*  246 */       tError.errorMessage = ex.toString();
/*  247 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  250 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  253 */       if (!this.mflag)
/*      */         try {
/*  255 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  259 */       return false;
/*      */     }
/*      */ 
/*  262 */     if (!this.mflag)
/*      */       try {
/*  264 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  268 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  273 */     PreparedStatement pstmt = null;
/*      */ 
/*  275 */     if (!this.mflag) {
/*  276 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  281 */       pstmt = this.con.prepareStatement("INSERT INTO MLink VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  282 */       if ((getID() == null) || (getID().equals("null")))
/*  283 */         pstmt.setNull(1, 12);
/*      */       else {
/*  285 */         pstmt.setString(1, getID());
/*      */       }
/*  287 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  288 */         pstmt.setNull(2, 12);
/*      */       else {
/*  290 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  292 */       if ((getRefURL() == null) || (getRefURL().equals("null")))
/*  293 */         pstmt.setNull(3, 12);
/*      */       else {
/*  295 */         pstmt.setString(3, getRefURL());
/*      */       }
/*  297 */       if ((getTarget() == null) || (getTarget().equals("null")))
/*  298 */         pstmt.setNull(4, 12);
/*      */       else {
/*  300 */         pstmt.setString(4, getTarget());
/*      */       }
/*  302 */       if ((getName() == null) || (getName().equals("null")))
/*  303 */         pstmt.setNull(5, 12);
/*      */       else {
/*  305 */         pstmt.setString(5, getName());
/*      */       }
/*  307 */       pstmt.setInt(6, getLinkOrder());
/*  308 */       if ((getState() == null) || (getState().equals("null")))
/*  309 */         pstmt.setNull(7, 12);
/*      */       else {
/*  311 */         pstmt.setString(7, getState());
/*      */       }
/*  313 */       if ((getType() == null) || (getType().equals("null")))
/*  314 */         pstmt.setNull(8, 12);
/*      */       else {
/*  316 */         pstmt.setString(8, getType());
/*      */       }
/*  318 */       if ((getIcon() == null) || (getIcon().equals("null")))
/*  319 */         pstmt.setNull(9, 12);
/*      */       else {
/*  321 */         pstmt.setString(9, getIcon());
/*      */       }
/*  323 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  324 */         pstmt.setNull(10, 12);
/*      */       else {
/*  326 */         pstmt.setString(10, getManageCom());
/*      */       }
/*  328 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  329 */         pstmt.setNull(11, 12);
/*      */       else {
/*  331 */         pstmt.setString(11, getBranchType());
/*      */       }
/*  333 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  334 */         pstmt.setNull(12, 12);
/*      */       else {
/*  336 */         pstmt.setString(12, getVF01());
/*      */       }
/*  338 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  339 */         pstmt.setNull(13, 12);
/*      */       else {
/*  341 */         pstmt.setString(13, getNF01());
/*      */       }
/*  343 */       pstmt.setInt(14, getIF01());
/*  344 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  345 */         pstmt.setNull(17, 12);
/*      */       else {
/*  347 */         pstmt.setString(17, getModifyOperator());
/*      */       }
/*  349 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  350 */         pstmt.setNull(18, 12);
/*      */       else {
/*  352 */         pstmt.setString(18, getOperator());
/*      */       }
/*  354 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  355 */         pstmt.setNull(20, 12);
/*      */       else {
/*  357 */         pstmt.setString(20, getMakeTime());
/*      */       }
/*  359 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  360 */         pstmt.setNull(22, 12);
/*      */       else {
/*  362 */         pstmt.setString(22, getModifyTime());
/*      */       }
/*  364 */       if ((getDescription() == null) || (getDescription().equals("null")))
/*  365 */         pstmt.setNull(23, 12);
/*      */       else {
/*  367 */         pstmt.setString(23, getDescription());
/*      */       }
/*      */ 
/*  370 */       pstmt.executeUpdate();
/*  371 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  374 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  375 */       CError tError = new CError();
/*  376 */       tError.moduleName = "MLinkDB";
/*  377 */       tError.functionName = "insert()";
/*  378 */       tError.errorMessage = ex.toString();
/*  379 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  382 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  385 */       if (!this.mflag)
/*      */         try {
/*  387 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  391 */       return false;
/*      */     }
/*      */ 
/*  394 */     if (!this.mflag)
/*      */       try {
/*  396 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  400 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  405 */     PreparedStatement pstmt = null;
/*  406 */     ResultSet rs = null;
/*      */ 
/*  408 */     if (!this.mflag) {
/*  409 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  414 */       pstmt = this.con.prepareStatement("SELECT * FROM MLink WHERE  ID = ?", 
/*  415 */         1003, 1007);
/*  416 */       if ((getID() == null) || (getID().equals("null")))
/*  417 */         pstmt.setNull(1, 12);
/*      */       else {
/*  419 */         pstmt.setString(1, getID());
/*      */       }
/*  421 */       rs = pstmt.executeQuery();
/*  422 */       int i = 0;
/*  423 */       if (rs.next())
/*      */       {
/*  425 */         i++;
/*  426 */         if (!setSchema(rs, i))
/*      */         {
/*  429 */           CError tError = new CError();
/*  430 */           tError.moduleName = "MLinkDB";
/*  431 */           tError.functionName = "getInfo";
/*  432 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  433 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  435 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  438 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  442 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  446 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  450 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  453 */       if (i == 0)
/*      */       {
/*  455 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  459 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  463 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  469 */       CError tError = new CError();
/*  470 */       tError.moduleName = "MLinkDB";
/*  471 */       tError.functionName = "getInfo";
/*  472 */       tError.errorMessage = e.toString();
/*  473 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  475 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  478 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  482 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  486 */       return false;
/*      */     }
/*      */ 
/*  489 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  493 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  498 */     return true;
/*      */   }
/*      */ 
/*      */   public MLinkSet query()
/*      */   {
/*  503 */     Statement stmt = null;
/*  504 */     ResultSet rs = null;
/*  505 */     MLinkSet aMLinkSet = new MLinkSet();
/*      */ 
/*  507 */     if (!this.mflag) {
/*  508 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  513 */       stmt = this.con.createStatement(1003, 1007);
/*  514 */       SQLString sqlObj = new SQLString("MLink");
/*  515 */       MLinkSchema aSchema = getSchema();
/*  516 */       sqlObj.setSQL(5, aSchema);
/*  517 */       String sql = sqlObj.getSQL();
/*      */ 
/*  519 */       rs = stmt.executeQuery(sql);
/*  520 */       int i = 0;
/*  521 */       while (rs.next())
/*      */       {
/*  523 */         i++;
/*  524 */         MLinkSchema s1 = new MLinkSchema();
/*  525 */         s1.setSchema(rs, i);
/*  526 */         aMLinkSet.add(s1);
/*      */       }try {
/*  528 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  534 */       CError tError = new CError();
/*  535 */       tError.moduleName = "MLinkDB";
/*  536 */       tError.functionName = "query";
/*  537 */       tError.errorMessage = e.toString();
/*  538 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  540 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  543 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  547 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  553 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  557 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  562 */     return aMLinkSet;
/*      */   }
/*      */ 
/*      */   public MLinkSet executeQuery(String sql)
/*      */   {
/*  567 */     Statement stmt = null;
/*  568 */     ResultSet rs = null;
/*  569 */     MLinkSet aMLinkSet = new MLinkSet();
/*      */ 
/*  571 */     if (!this.mflag) {
/*  572 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  577 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  579 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  580 */       int i = 0;
/*  581 */       while (rs.next())
/*      */       {
/*  583 */         i++;
/*  584 */         MLinkSchema s1 = new MLinkSchema();
/*  585 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  588 */           CError tError = new CError();
/*  589 */           tError.moduleName = "MLinkDB";
/*  590 */           tError.functionName = "executeQuery";
/*  591 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  592 */           this.mErrors.addOneError(tError);
/*      */         }
/*  594 */         aMLinkSet.add(s1);
/*      */       }try {
/*  596 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  602 */       CError tError = new CError();
/*  603 */       tError.moduleName = "MLinkDB";
/*  604 */       tError.functionName = "executeQuery";
/*  605 */       tError.errorMessage = e.toString();
/*  606 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  608 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  611 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  615 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  621 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  625 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  630 */     return aMLinkSet;
/*      */   }
/*      */ 
/*      */   public MLinkSet query(int nStart, int nCount)
/*      */   {
/*  635 */     Statement stmt = null;
/*  636 */     ResultSet rs = null;
/*  637 */     MLinkSet aMLinkSet = new MLinkSet();
/*      */ 
/*  639 */     if (!this.mflag) {
/*  640 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  645 */       stmt = this.con.createStatement(1003, 1007);
/*  646 */       SQLString sqlObj = new SQLString("MLink");
/*  647 */       MLinkSchema aSchema = getSchema();
/*  648 */       sqlObj.setSQL(5, aSchema);
/*  649 */       String sql = sqlObj.getSQL();
/*      */ 
/*  651 */       rs = stmt.executeQuery(sql);
/*  652 */       int i = 0;
/*  653 */       while (rs.next())
/*      */       {
/*  655 */         i++;
/*      */ 
/*  657 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  661 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  665 */         MLinkSchema s1 = new MLinkSchema();
/*  666 */         s1.setSchema(rs, i);
/*  667 */         aMLinkSet.add(s1);
/*      */       }try {
/*  669 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  675 */       CError tError = new CError();
/*  676 */       tError.moduleName = "MLinkDB";
/*  677 */       tError.functionName = "query";
/*  678 */       tError.errorMessage = e.toString();
/*  679 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  681 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  684 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  688 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  694 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  698 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  703 */     return aMLinkSet;
/*      */   }
/*      */ 
/*      */   public MLinkSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  708 */     Statement stmt = null;
/*  709 */     ResultSet rs = null;
/*  710 */     MLinkSet aMLinkSet = new MLinkSet();
/*      */ 
/*  712 */     if (!this.mflag) {
/*  713 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  718 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  720 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  721 */       int i = 0;
/*  722 */       while (rs.next())
/*      */       {
/*  724 */         i++;
/*      */ 
/*  726 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  730 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  734 */         MLinkSchema s1 = new MLinkSchema();
/*  735 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  738 */           CError tError = new CError();
/*  739 */           tError.moduleName = "MLinkDB";
/*  740 */           tError.functionName = "executeQuery";
/*  741 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  742 */           this.mErrors.addOneError(tError);
/*      */         }
/*  744 */         aMLinkSet.add(s1);
/*      */       }try {
/*  746 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  752 */       CError tError = new CError();
/*  753 */       tError.moduleName = "MLinkDB";
/*  754 */       tError.functionName = "executeQuery";
/*  755 */       tError.errorMessage = e.toString();
/*  756 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  758 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  761 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  765 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  771 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  775 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  780 */     return aMLinkSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  785 */     Statement stmt = null;
/*      */ 
/*  787 */     if (!this.mflag) {
/*  788 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  793 */       stmt = this.con.createStatement(1003, 1007);
/*  794 */       SQLString sqlObj = new SQLString("MLink");
/*  795 */       MLinkSchema aSchema = getSchema();
/*  796 */       sqlObj.setSQL(2, aSchema);
/*  797 */       String sql = "update MLink " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  799 */       int operCount = stmt.executeUpdate(sql);
/*  800 */       if (operCount == 0)
/*      */       {
/*  803 */         CError tError = new CError();
/*  804 */         tError.moduleName = "MLinkDB";
/*  805 */         tError.functionName = "update";
/*  806 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  807 */         this.mErrors.addOneError(tError);
/*      */ 
/*  809 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  813 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  817 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  823 */       CError tError = new CError();
/*  824 */       tError.moduleName = "MLinkDB";
/*  825 */       tError.functionName = "update";
/*  826 */       tError.errorMessage = e.toString();
/*  827 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  829 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  831 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  835 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  839 */       return false;
/*      */     }
/*      */ 
/*  842 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  846 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  851 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  857 */     if (this.mResultSet != null)
/*      */     {
/*  860 */       CError tError = new CError();
/*  861 */       tError.moduleName = "MLinkDB";
/*  862 */       tError.functionName = "prepareData";
/*  863 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  864 */       this.mErrors.addOneError(tError);
/*  865 */       return false;
/*      */     }
/*      */ 
/*  868 */     if (!this.mflag)
/*      */     {
/*  870 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  874 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  875 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  880 */       CError tError = new CError();
/*  881 */       tError.moduleName = "MLinkDB";
/*  882 */       tError.functionName = "prepareData";
/*  883 */       tError.errorMessage = e.toString();
/*  884 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  887 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  893 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  897 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  901 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  906 */       return false;
/*      */     }
/*      */ 
/*  909 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  913 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  918 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  924 */     boolean flag = true;
/*  925 */     if (this.mResultSet == null)
/*      */     {
/*  927 */       CError tError = new CError();
/*  928 */       tError.moduleName = "MLinkDB";
/*  929 */       tError.functionName = "hasMoreData";
/*  930 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  931 */       this.mErrors.addOneError(tError);
/*  932 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  936 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  940 */       CError tError = new CError();
/*  941 */       tError.moduleName = "MLinkDB";
/*  942 */       tError.functionName = "hasMoreData";
/*  943 */       tError.errorMessage = ex.toString();
/*  944 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  947 */         this.mResultSet.close();
/*  948 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  954 */         this.mStatement.close();
/*  955 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  959 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  963 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  968 */       return false;
/*      */     }
/*  970 */     return flag;
/*      */   }
/*      */ 
/*      */   public MLinkSet getData()
/*      */   {
/*  975 */     int tCount = 0;
/*  976 */     MLinkSet tMLinkSet = new MLinkSet();
/*  977 */     MLinkSchema tMLinkSchema = null;
/*  978 */     if (this.mResultSet == null)
/*      */     {
/*  980 */       CError tError = new CError();
/*  981 */       tError.moduleName = "MLinkDB";
/*  982 */       tError.functionName = "getData";
/*  983 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  984 */       this.mErrors.addOneError(tError);
/*  985 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  989 */       tCount = 1;
/*  990 */       tMLinkSchema = new MLinkSchema();
/*  991 */       tMLinkSchema.setSchema(this.mResultSet, 1);
/*  992 */       tMLinkSet.add(tMLinkSchema);
/*      */ 
/*  994 */       while (tCount++ < 5000)
/*      */       {
/*  996 */         if (!this.mResultSet.next())
/*      */           continue;
/*  998 */         tMLinkSchema = new MLinkSchema();
/*  999 */         tMLinkSchema.setSchema(this.mResultSet, 1);
/* 1000 */         tMLinkSet.add(tMLinkSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1006 */       CError tError = new CError();
/* 1007 */       tError.moduleName = "MLinkDB";
/* 1008 */       tError.functionName = "getData";
/* 1009 */       tError.errorMessage = ex.toString();
/* 1010 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1013 */         this.mResultSet.close();
/* 1014 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1020 */         this.mStatement.close();
/* 1021 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1025 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1029 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1034 */       return null;
/*      */     }
/* 1036 */     return tMLinkSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1041 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1044 */       if (this.mResultSet == null)
/*      */       {
/* 1046 */         CError tError = new CError();
/* 1047 */         tError.moduleName = "MLinkDB";
/* 1048 */         tError.functionName = "closeData";
/* 1049 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1050 */         this.mErrors.addOneError(tError);
/* 1051 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1055 */         this.mResultSet.close();
/* 1056 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1061 */       CError tError = new CError();
/* 1062 */       tError.moduleName = "MLinkDB";
/* 1063 */       tError.functionName = "closeData";
/* 1064 */       tError.errorMessage = ex2.toString();
/* 1065 */       this.mErrors.addOneError(tError);
/* 1066 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1070 */       if (this.mStatement == null)
/*      */       {
/* 1072 */         CError tError = new CError();
/* 1073 */         tError.moduleName = "MLinkDB";
/* 1074 */         tError.functionName = "closeData";
/* 1075 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1076 */         this.mErrors.addOneError(tError);
/* 1077 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1081 */         this.mStatement.close();
/* 1082 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1087 */       CError tError = new CError();
/* 1088 */       tError.moduleName = "MLinkDB";
/* 1089 */       tError.functionName = "closeData";
/* 1090 */       tError.errorMessage = ex3.toString();
/* 1091 */       this.mErrors.addOneError(tError);
/* 1092 */       flag = false;
/*      */     }
/* 1094 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MLinkDB
 * JD-Core Version:    0.6.0
 */