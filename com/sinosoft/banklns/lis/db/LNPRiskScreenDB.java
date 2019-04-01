/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskScreenSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskScreenSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import com.sinosoft.banklns.utility.SQLString;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class LNPRiskScreenDB extends LNPRiskScreenSchema
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
/*      */   public LNPRiskScreenDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPRiskScreen");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPRiskScreen");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPRiskScreenSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPRiskScreenDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPRiskScreenSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPRiskScreenDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskScreen WHERE  RiskCode = ? AND CtrlIndex = ?");
/*   97 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  102 */       pstmt.setInt(2, getCtrlIndex());
/*  103 */       pstmt.executeUpdate();
/*  104 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  107 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  108 */       CError tError = new CError();
/*  109 */       tError.moduleName = "LNPRiskScreenDB";
/*  110 */       tError.functionName = "delete()";
/*  111 */       tError.errorMessage = ex.toString();
/*  112 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  115 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  118 */       if (!this.mflag)
/*      */         try {
/*  120 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  124 */       return false;
/*      */     }
/*      */ 
/*  127 */     if (!this.mflag)
/*      */       try {
/*  129 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  133 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  138 */     PreparedStatement pstmt = null;
/*      */ 
/*  140 */     if (!this.mflag) {
/*  141 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  146 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskScreen SET  RiskCode = ? , CtrlIndex = ? , CtrlType = ? , CtrlCode = ? , CtrlName = ? , CtrlLevel = ? , CtrlProperty = ? , CtrlAlignX = ? , CtrlAlignY = ? , CtrlHorizontal = ? , CtrlVertical = ? , CtrlBackground = ? , LabelAlignX = ? , LabelAlignY = ? , LabelHorizontal = ? , LabelVertical = ? , LabelBackground = ? , DefaultValue = ? , DefaultSql = ? , CtrlProperty1 = ? , CtrlProperty2 = ? , Noti = ? WHERE  RiskCode = ? AND CtrlIndex = ?");
/*  147 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  148 */         pstmt.setNull(1, 12);
/*      */       else {
/*  150 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  152 */       pstmt.setInt(2, getCtrlIndex());
/*  153 */       if ((getCtrlType() == null) || (getCtrlType().equals("null")))
/*  154 */         pstmt.setNull(3, 12);
/*      */       else {
/*  156 */         pstmt.setString(3, getCtrlType());
/*      */       }
/*  158 */       if ((getCtrlCode() == null) || (getCtrlCode().equals("null")))
/*  159 */         pstmt.setNull(4, 12);
/*      */       else {
/*  161 */         pstmt.setString(4, getCtrlCode());
/*      */       }
/*  163 */       if ((getCtrlName() == null) || (getCtrlName().equals("null")))
/*  164 */         pstmt.setNull(5, 12);
/*      */       else {
/*  166 */         pstmt.setString(5, getCtrlName());
/*      */       }
/*  168 */       if ((getCtrlLevel() == null) || (getCtrlLevel().equals("null")))
/*  169 */         pstmt.setNull(6, 12);
/*      */       else {
/*  171 */         pstmt.setString(6, getCtrlLevel());
/*      */       }
/*  173 */       if ((getCtrlProperty() == null) || (getCtrlProperty().equals("null")))
/*  174 */         pstmt.setNull(7, 12);
/*      */       else {
/*  176 */         pstmt.setString(7, getCtrlProperty());
/*      */       }
/*  178 */       pstmt.setInt(8, getCtrlAlignX());
/*  179 */       pstmt.setInt(9, getCtrlAlignY());
/*  180 */       pstmt.setInt(10, getCtrlHorizontal());
/*  181 */       pstmt.setInt(11, getCtrlVertical());
/*  182 */       if ((getCtrlBackground() == null) || (getCtrlBackground().equals("null")))
/*  183 */         pstmt.setNull(12, 12);
/*      */       else {
/*  185 */         pstmt.setString(12, getCtrlBackground());
/*      */       }
/*  187 */       pstmt.setInt(13, getLabelAlignX());
/*  188 */       pstmt.setInt(14, getLabelAlignY());
/*  189 */       pstmt.setInt(15, getLabelHorizontal());
/*  190 */       pstmt.setInt(16, getLabelVertical());
/*  191 */       if ((getLabelBackground() == null) || (getLabelBackground().equals("null")))
/*  192 */         pstmt.setNull(17, 12);
/*      */       else {
/*  194 */         pstmt.setString(17, getLabelBackground());
/*      */       }
/*  196 */       if ((getDefaultValue() == null) || (getDefaultValue().equals("null")))
/*  197 */         pstmt.setNull(18, 12);
/*      */       else {
/*  199 */         pstmt.setString(18, getDefaultValue());
/*      */       }
/*  201 */       if ((getDefaultSql() == null) || (getDefaultSql().equals("null")))
/*  202 */         pstmt.setNull(19, 12);
/*      */       else {
/*  204 */         pstmt.setString(19, getDefaultSql());
/*      */       }
/*  206 */       if ((getCtrlProperty1() == null) || (getCtrlProperty1().equals("null")))
/*  207 */         pstmt.setNull(20, 12);
/*      */       else {
/*  209 */         pstmt.setString(20, getCtrlProperty1());
/*      */       }
/*  211 */       if ((getCtrlProperty2() == null) || (getCtrlProperty2().equals("null")))
/*  212 */         pstmt.setNull(21, 12);
/*      */       else {
/*  214 */         pstmt.setString(21, getCtrlProperty2());
/*      */       }
/*  216 */       if ((getNoti() == null) || (getNoti().equals("null")))
/*  217 */         pstmt.setNull(22, 12);
/*      */       else {
/*  219 */         pstmt.setString(22, getNoti());
/*      */       }
/*      */ 
/*  222 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  223 */         pstmt.setNull(23, 12);
/*      */       else {
/*  225 */         pstmt.setString(23, getRiskCode());
/*      */       }
/*  227 */       pstmt.setInt(24, getCtrlIndex());
/*  228 */       pstmt.executeUpdate();
/*  229 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  232 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  233 */       CError tError = new CError();
/*  234 */       tError.moduleName = "LNPRiskScreenDB";
/*  235 */       tError.functionName = "update()";
/*  236 */       tError.errorMessage = ex.toString();
/*  237 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  240 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  243 */       if (!this.mflag)
/*      */         try {
/*  245 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  249 */       return false;
/*      */     }
/*      */ 
/*  252 */     if (!this.mflag)
/*      */       try {
/*  254 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  258 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  263 */     PreparedStatement pstmt = null;
/*      */ 
/*  265 */     if (!this.mflag) {
/*  266 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  271 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskScreen VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  272 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  273 */         pstmt.setNull(1, 12);
/*      */       else {
/*  275 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  277 */       pstmt.setInt(2, getCtrlIndex());
/*  278 */       if ((getCtrlType() == null) || (getCtrlType().equals("null")))
/*  279 */         pstmt.setNull(3, 12);
/*      */       else {
/*  281 */         pstmt.setString(3, getCtrlType());
/*      */       }
/*  283 */       if ((getCtrlCode() == null) || (getCtrlCode().equals("null")))
/*  284 */         pstmt.setNull(4, 12);
/*      */       else {
/*  286 */         pstmt.setString(4, getCtrlCode());
/*      */       }
/*  288 */       if ((getCtrlName() == null) || (getCtrlName().equals("null")))
/*  289 */         pstmt.setNull(5, 12);
/*      */       else {
/*  291 */         pstmt.setString(5, getCtrlName());
/*      */       }
/*  293 */       if ((getCtrlLevel() == null) || (getCtrlLevel().equals("null")))
/*  294 */         pstmt.setNull(6, 12);
/*      */       else {
/*  296 */         pstmt.setString(6, getCtrlLevel());
/*      */       }
/*  298 */       if ((getCtrlProperty() == null) || (getCtrlProperty().equals("null")))
/*  299 */         pstmt.setNull(7, 12);
/*      */       else {
/*  301 */         pstmt.setString(7, getCtrlProperty());
/*      */       }
/*  303 */       pstmt.setInt(8, getCtrlAlignX());
/*  304 */       pstmt.setInt(9, getCtrlAlignY());
/*  305 */       pstmt.setInt(10, getCtrlHorizontal());
/*  306 */       pstmt.setInt(11, getCtrlVertical());
/*  307 */       if ((getCtrlBackground() == null) || (getCtrlBackground().equals("null")))
/*  308 */         pstmt.setNull(12, 12);
/*      */       else {
/*  310 */         pstmt.setString(12, getCtrlBackground());
/*      */       }
/*  312 */       pstmt.setInt(13, getLabelAlignX());
/*  313 */       pstmt.setInt(14, getLabelAlignY());
/*  314 */       pstmt.setInt(15, getLabelHorizontal());
/*  315 */       pstmt.setInt(16, getLabelVertical());
/*  316 */       if ((getLabelBackground() == null) || (getLabelBackground().equals("null")))
/*  317 */         pstmt.setNull(17, 12);
/*      */       else {
/*  319 */         pstmt.setString(17, getLabelBackground());
/*      */       }
/*  321 */       if ((getDefaultValue() == null) || (getDefaultValue().equals("null")))
/*  322 */         pstmt.setNull(18, 12);
/*      */       else {
/*  324 */         pstmt.setString(18, getDefaultValue());
/*      */       }
/*  326 */       if ((getDefaultSql() == null) || (getDefaultSql().equals("null")))
/*  327 */         pstmt.setNull(19, 12);
/*      */       else {
/*  329 */         pstmt.setString(19, getDefaultSql());
/*      */       }
/*  331 */       if ((getCtrlProperty1() == null) || (getCtrlProperty1().equals("null")))
/*  332 */         pstmt.setNull(20, 12);
/*      */       else {
/*  334 */         pstmt.setString(20, getCtrlProperty1());
/*      */       }
/*  336 */       if ((getCtrlProperty2() == null) || (getCtrlProperty2().equals("null")))
/*  337 */         pstmt.setNull(21, 12);
/*      */       else {
/*  339 */         pstmt.setString(21, getCtrlProperty2());
/*      */       }
/*  341 */       if ((getNoti() == null) || (getNoti().equals("null")))
/*  342 */         pstmt.setNull(22, 12);
/*      */       else {
/*  344 */         pstmt.setString(22, getNoti());
/*      */       }
/*      */ 
/*  347 */       pstmt.executeUpdate();
/*  348 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  351 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  352 */       CError tError = new CError();
/*  353 */       tError.moduleName = "LNPRiskScreenDB";
/*  354 */       tError.functionName = "insert()";
/*  355 */       tError.errorMessage = ex.toString();
/*  356 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  359 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  362 */       if (!this.mflag)
/*      */         try {
/*  364 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  368 */       return false;
/*      */     }
/*      */ 
/*  371 */     if (!this.mflag)
/*      */       try {
/*  373 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  377 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  382 */     PreparedStatement pstmt = null;
/*  383 */     ResultSet rs = null;
/*      */ 
/*  385 */     if (!this.mflag) {
/*  386 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  391 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRiskScreen WHERE  RiskCode = ? AND CtrlIndex = ?", 
/*  392 */         1003, 1007);
/*  393 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  394 */         pstmt.setNull(1, 12);
/*      */       else {
/*  396 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  398 */       pstmt.setInt(2, getCtrlIndex());
/*  399 */       rs = pstmt.executeQuery();
/*  400 */       int i = 0;
/*  401 */       if (rs.next())
/*      */       {
/*  403 */         i++;
/*  404 */         if (!setSchema(rs, i))
/*      */         {
/*  407 */           CError tError = new CError();
/*  408 */           tError.moduleName = "LNPRiskScreenDB";
/*  409 */           tError.functionName = "getInfo";
/*  410 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  411 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  413 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  416 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  420 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  424 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  428 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  431 */       if (i == 0)
/*      */       {
/*  433 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  437 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  441 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  447 */       CError tError = new CError();
/*  448 */       tError.moduleName = "LNPRiskScreenDB";
/*  449 */       tError.functionName = "getInfo";
/*  450 */       tError.errorMessage = e.toString();
/*  451 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  453 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  456 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  460 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  464 */       return false;
/*      */     }
/*      */ 
/*  467 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  471 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  476 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenSet query()
/*      */   {
/*  481 */     Statement stmt = null;
/*  482 */     ResultSet rs = null;
/*  483 */     LNPRiskScreenSet aLNPRiskScreenSet = new LNPRiskScreenSet();
/*      */ 
/*  485 */     if (!this.mflag) {
/*  486 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  491 */       stmt = this.con.createStatement(1003, 1007);
/*  492 */       SQLString sqlObj = new SQLString("LNPRiskScreen");
/*  493 */       LNPRiskScreenSchema aSchema = getSchema();
/*  494 */       sqlObj.setSQL(5, aSchema);
/*  495 */       String sql = sqlObj.getSQL();
/*      */ 
/*  497 */       rs = stmt.executeQuery(sql);
/*  498 */       int i = 0;
/*  499 */       while (rs.next())
/*      */       {
/*  501 */         i++;
/*  502 */         LNPRiskScreenSchema s1 = new LNPRiskScreenSchema();
/*  503 */         s1.setSchema(rs, i);
/*  504 */         aLNPRiskScreenSet.add(s1);
/*      */       }try {
/*  506 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  512 */       CError tError = new CError();
/*  513 */       tError.moduleName = "LNPRiskScreenDB";
/*  514 */       tError.functionName = "query";
/*  515 */       tError.errorMessage = e.toString();
/*  516 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  518 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  521 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  525 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  531 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  535 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  540 */     return aLNPRiskScreenSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenSet executeQuery(String sql)
/*      */   {
/*  545 */     Statement stmt = null;
/*  546 */     ResultSet rs = null;
/*  547 */     LNPRiskScreenSet aLNPRiskScreenSet = new LNPRiskScreenSet();
/*      */ 
/*  549 */     if (!this.mflag) {
/*  550 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  555 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  557 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  558 */       int i = 0;
/*  559 */       while (rs.next())
/*      */       {
/*  561 */         i++;
/*  562 */         LNPRiskScreenSchema s1 = new LNPRiskScreenSchema();
/*  563 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  566 */           CError tError = new CError();
/*  567 */           tError.moduleName = "LNPRiskScreenDB";
/*  568 */           tError.functionName = "executeQuery";
/*  569 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  570 */           this.mErrors.addOneError(tError);
/*      */         }
/*  572 */         aLNPRiskScreenSet.add(s1);
/*      */       }try {
/*  574 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  580 */       CError tError = new CError();
/*  581 */       tError.moduleName = "LNPRiskScreenDB";
/*  582 */       tError.functionName = "executeQuery";
/*  583 */       tError.errorMessage = e.toString();
/*  584 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  586 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  589 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  593 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  599 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  603 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  608 */     return aLNPRiskScreenSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenSet query(int nStart, int nCount)
/*      */   {
/*  613 */     Statement stmt = null;
/*  614 */     ResultSet rs = null;
/*  615 */     LNPRiskScreenSet aLNPRiskScreenSet = new LNPRiskScreenSet();
/*      */ 
/*  617 */     if (!this.mflag) {
/*  618 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  623 */       stmt = this.con.createStatement(1003, 1007);
/*  624 */       SQLString sqlObj = new SQLString("LNPRiskScreen");
/*  625 */       LNPRiskScreenSchema aSchema = getSchema();
/*  626 */       sqlObj.setSQL(5, aSchema);
/*  627 */       String sql = sqlObj.getSQL();
/*      */ 
/*  629 */       rs = stmt.executeQuery(sql);
/*  630 */       int i = 0;
/*  631 */       while (rs.next())
/*      */       {
/*  633 */         i++;
/*      */ 
/*  635 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  639 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  643 */         LNPRiskScreenSchema s1 = new LNPRiskScreenSchema();
/*  644 */         s1.setSchema(rs, i);
/*  645 */         aLNPRiskScreenSet.add(s1);
/*      */       }try {
/*  647 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  653 */       CError tError = new CError();
/*  654 */       tError.moduleName = "LNPRiskScreenDB";
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
/*  681 */     return aLNPRiskScreenSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  686 */     Statement stmt = null;
/*  687 */     ResultSet rs = null;
/*  688 */     LNPRiskScreenSet aLNPRiskScreenSet = new LNPRiskScreenSet();
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
/*      */ 
/*  704 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  708 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  712 */         LNPRiskScreenSchema s1 = new LNPRiskScreenSchema();
/*  713 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  716 */           CError tError = new CError();
/*  717 */           tError.moduleName = "LNPRiskScreenDB";
/*  718 */           tError.functionName = "executeQuery";
/*  719 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  720 */           this.mErrors.addOneError(tError);
/*      */         }
/*  722 */         aLNPRiskScreenSet.add(s1);
/*      */       }try {
/*  724 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  730 */       CError tError = new CError();
/*  731 */       tError.moduleName = "LNPRiskScreenDB";
/*  732 */       tError.functionName = "executeQuery";
/*  733 */       tError.errorMessage = e.toString();
/*  734 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  736 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  739 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  743 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  749 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  753 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  758 */     return aLNPRiskScreenSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  763 */     Statement stmt = null;
/*      */ 
/*  765 */     if (!this.mflag) {
/*  766 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  771 */       stmt = this.con.createStatement(1003, 1007);
/*  772 */       SQLString sqlObj = new SQLString("LNPRiskScreen");
/*  773 */       LNPRiskScreenSchema aSchema = getSchema();
/*  774 */       sqlObj.setSQL(2, aSchema);
/*  775 */       String sql = "update LNPRiskScreen " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  777 */       int operCount = stmt.executeUpdate(sql);
/*  778 */       if (operCount == 0)
/*      */       {
/*  781 */         CError tError = new CError();
/*  782 */         tError.moduleName = "LNPRiskScreenDB";
/*  783 */         tError.functionName = "update";
/*  784 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  785 */         this.mErrors.addOneError(tError);
/*      */ 
/*  787 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  791 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  795 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  801 */       CError tError = new CError();
/*  802 */       tError.moduleName = "LNPRiskScreenDB";
/*  803 */       tError.functionName = "update";
/*  804 */       tError.errorMessage = e.toString();
/*  805 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  807 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  809 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  813 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  817 */       return false;
/*      */     }
/*      */ 
/*  820 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  824 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  829 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  835 */     if (this.mResultSet != null)
/*      */     {
/*  838 */       CError tError = new CError();
/*  839 */       tError.moduleName = "LNPRiskScreenDB";
/*  840 */       tError.functionName = "prepareData";
/*  841 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  842 */       this.mErrors.addOneError(tError);
/*  843 */       return false;
/*      */     }
/*      */ 
/*  846 */     if (!this.mflag)
/*      */     {
/*  848 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  852 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  853 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  858 */       CError tError = new CError();
/*  859 */       tError.moduleName = "LNPRiskScreenDB";
/*  860 */       tError.functionName = "prepareData";
/*  861 */       tError.errorMessage = e.toString();
/*  862 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  865 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  871 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  875 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  879 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  884 */       return false;
/*      */     }
/*      */ 
/*  887 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  891 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  896 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  902 */     boolean flag = true;
/*  903 */     if (this.mResultSet == null)
/*      */     {
/*  905 */       CError tError = new CError();
/*  906 */       tError.moduleName = "LNPRiskScreenDB";
/*  907 */       tError.functionName = "hasMoreData";
/*  908 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  909 */       this.mErrors.addOneError(tError);
/*  910 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  914 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  918 */       CError tError = new CError();
/*  919 */       tError.moduleName = "LNPRiskScreenDB";
/*  920 */       tError.functionName = "hasMoreData";
/*  921 */       tError.errorMessage = ex.toString();
/*  922 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  925 */         this.mResultSet.close();
/*  926 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  932 */         this.mStatement.close();
/*  933 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  937 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  941 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  946 */       return false;
/*      */     }
/*  948 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPRiskScreenSet getData()
/*      */   {
/*  953 */     int tCount = 0;
/*  954 */     LNPRiskScreenSet tLNPRiskScreenSet = new LNPRiskScreenSet();
/*  955 */     LNPRiskScreenSchema tLNPRiskScreenSchema = null;
/*  956 */     if (this.mResultSet == null)
/*      */     {
/*  958 */       CError tError = new CError();
/*  959 */       tError.moduleName = "LNPRiskScreenDB";
/*  960 */       tError.functionName = "getData";
/*  961 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  962 */       this.mErrors.addOneError(tError);
/*  963 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  967 */       tCount = 1;
/*  968 */       tLNPRiskScreenSchema = new LNPRiskScreenSchema();
/*  969 */       tLNPRiskScreenSchema.setSchema(this.mResultSet, 1);
/*  970 */       tLNPRiskScreenSet.add(tLNPRiskScreenSchema);
/*      */ 
/*  972 */       while (tCount++ < 5000)
/*      */       {
/*  974 */         if (!this.mResultSet.next())
/*      */           continue;
/*  976 */         tLNPRiskScreenSchema = new LNPRiskScreenSchema();
/*  977 */         tLNPRiskScreenSchema.setSchema(this.mResultSet, 1);
/*  978 */         tLNPRiskScreenSet.add(tLNPRiskScreenSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  984 */       CError tError = new CError();
/*  985 */       tError.moduleName = "LNPRiskScreenDB";
/*  986 */       tError.functionName = "getData";
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
/* 1012 */       return null;
/*      */     }
/* 1014 */     return tLNPRiskScreenSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1019 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1022 */       if (this.mResultSet == null)
/*      */       {
/* 1024 */         CError tError = new CError();
/* 1025 */         tError.moduleName = "LNPRiskScreenDB";
/* 1026 */         tError.functionName = "closeData";
/* 1027 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1028 */         this.mErrors.addOneError(tError);
/* 1029 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1033 */         this.mResultSet.close();
/* 1034 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1039 */       CError tError = new CError();
/* 1040 */       tError.moduleName = "LNPRiskScreenDB";
/* 1041 */       tError.functionName = "closeData";
/* 1042 */       tError.errorMessage = ex2.toString();
/* 1043 */       this.mErrors.addOneError(tError);
/* 1044 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1048 */       if (this.mStatement == null)
/*      */       {
/* 1050 */         CError tError = new CError();
/* 1051 */         tError.moduleName = "LNPRiskScreenDB";
/* 1052 */         tError.functionName = "closeData";
/* 1053 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1054 */         this.mErrors.addOneError(tError);
/* 1055 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1059 */         this.mStatement.close();
/* 1060 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1065 */       CError tError = new CError();
/* 1066 */       tError.moduleName = "LNPRiskScreenDB";
/* 1067 */       tError.functionName = "closeData";
/* 1068 */       tError.errorMessage = ex3.toString();
/* 1069 */       this.mErrors.addOneError(tError);
/* 1070 */       flag = false;
/*      */     }
/* 1072 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskScreenDB
 * JD-Core Version:    0.6.0
 */