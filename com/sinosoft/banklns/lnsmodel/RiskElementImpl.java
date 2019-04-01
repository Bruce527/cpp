/*      */ package com.sinosoft.banklns.lnsmodel;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPCalModeDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPCheckFieldDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPComGrpToComDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestRiskDataDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskParamDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskScreenDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskScreenValidateDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubFun1;
/*      */ import com.sinosoft.banklns.lis.schema.LNPCheckFieldSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPComGrpToComSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInvestRiskDataSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskParamSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskScreenSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskScreenValidateSchema;
/*      */ import com.sinosoft.banklns.lis.vdb.LNPInvestRiskDataDBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCheckFieldSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPComGrpToComSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestRiskDataSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskParamSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskScreenSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskScreenValidateSet;
/*      */ import com.sinosoft.banklns.lnsmodel.util.ForSpcCalImpl;
/*      */ import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
/*      */ import com.sinosoft.banklns.utility.DBConn;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.EvalJavaTool;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.PubFun;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import com.sinosoft.banklns.utility.VData;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.SQLException;
/*      */ import java.text.DecimalFormat;
/*      */ import java.util.HashMap;
/*      */ import java.util.Hashtable;
/*      */ 
/*      */ public class RiskElementImpl
/*      */ {
/*   60 */   private String RISKCODE = "";
/*      */ 
/*   62 */   private boolean hidePayEndYear = false;
/*      */ 
/*      */   public boolean CheckControlValueValid(String ControlCode, PolElementSchema tPolElementSchema)
/*      */   {
/*   71 */     tPolElementSchema = setAppntAndInsuredInfo(tPolElementSchema);
/*   72 */     boolean flag = true;
/*   73 */     LNPRiskScreenValidateDB ttLNPRiskScreenValidateDB = new LNPRiskScreenValidateDB();
/*   74 */     ttLNPRiskScreenValidateDB.setRiskCode(tPolElementSchema.getRiskCode());
/*   75 */     ttLNPRiskScreenValidateDB.setControlCode(ControlCode);
/*   76 */     ttLNPRiskScreenValidateDB.setFunctionType("0");
/*      */ 
/*   80 */     LNPRiskScreenValidateSet ttLNPRiskScreenValidateSet = ttLNPRiskScreenValidateDB
/*   81 */       .query();
/*   82 */     if (ttLNPRiskScreenValidateSet.size() > 0)
/*      */     {
/*   84 */       ExeSQL rExeSQL = new ExeSQL();
/*      */ 
/*   87 */       for (int i = 1; i <= ttLNPRiskScreenValidateSet.size(); i++) {
/*   88 */         LNPRiskScreenValidateSchema rrLNPRiskScreenValidateSchema = ttLNPRiskScreenValidateSet.get(i);
/*   89 */         String serialno = rrLNPRiskScreenValidateSchema.getCalCode();
/*   90 */         LNPCheckFieldDB ttLNPCheckFieldDB = new LNPCheckFieldDB();
/*   91 */         ttLNPCheckFieldDB.setSerialNo(serialno);
/*      */ 
/*   93 */         ttLNPCheckFieldDB.setRiskCode(tPolElementSchema.getRiskCode());
/*   94 */         LNPCheckFieldSet ttLNPCheckFieldSet = ttLNPCheckFieldDB.query();
/*   95 */         if (ttLNPCheckFieldSet.size() == 0)
/*      */         {
/*   97 */           System.out.println("\u0423\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + serialno + 
/*   98 */             "]\uFFFD\uFFFDLMCheckField\uFFFD\u0432\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD!");
/*      */ 
/*  100 */           return false;
/*      */         }
/*  102 */         LNPCalModeDB ttLNPCalmodeDB = new LNPCalModeDB();
/*  103 */         ttLNPCalmodeDB.setRiskCode(tPolElementSchema.getRiskCode());
/*  104 */         ttLNPCalmodeDB.setCalCode(ttLNPCheckFieldSet.get(1).getCalCode());
/*  105 */         ttLNPCalmodeDB.getInfo();
/*  106 */         String sql = ttLNPCalmodeDB.getCalSQL();
/*  107 */         sql = transeToTypical(sql, tPolElementSchema);
/*  108 */         SSRS ttSSRS = rExeSQL.execSQL(sql);
/*  109 */         if (ttSSRS.GetText(1, 1).equals("1")) {
/*  110 */           flag = false;
/*  111 */           System.out.println("ttLNPCheckFieldSet.get(1).getMsg()");
/*      */         }
/*      */       }
/*      */     }
/*  115 */     return flag;
/*      */   }
/*      */ 
/*      */   public VData getRelaDivShowOrNot(String ControlCode, String ControlValue, PolElementSchema tPolElementSchema)
/*      */   {
/*  120 */     tPolElementSchema = setAppntAndInsuredInfo(tPolElementSchema);
/*  121 */     VData result = new VData();
/*  122 */     LNPRiskScreenValidateDB ttLNPRiskScreenValidateDB = new LNPRiskScreenValidateDB();
/*  123 */     ttLNPRiskScreenValidateDB.setRiskCode(tPolElementSchema.getRiskCode());
/*  124 */     ttLNPRiskScreenValidateDB.setFunctionType("2");
/*  125 */     ttLNPRiskScreenValidateDB.setControlCode(ControlCode);
/*  126 */     ttLNPRiskScreenValidateDB.setControlValue(ControlValue);
/*  127 */     LNPRiskScreenValidateSet rrLBPRiskScreenValidateSet = ttLNPRiskScreenValidateDB
/*  128 */       .query();
/*  129 */     if (rrLBPRiskScreenValidateSet.size() > 0) {
/*  130 */       for (int i = 1; i <= rrLBPRiskScreenValidateSet.size(); i++) {
/*  131 */         String[] rVdata = new String[2];
/*  132 */         rVdata[0] = rrLBPRiskScreenValidateSet.get(i).getRelaDivCode();
/*  133 */         rVdata[1] = rrLBPRiskScreenValidateSet.get(i).getRelaDivShow();
/*      */ 
/*  135 */         result.add(rVdata);
/*      */       }
/*      */     }
/*      */ 
/*  139 */     return result;
/*      */   }
/*      */ 
/*      */   public VData getReleControlValue(String ControlCode, String ControlValue, PolElementSchema tPolElementSchema)
/*      */   {
/*  144 */     tPolElementSchema = setAppntAndInsuredInfo(tPolElementSchema);
/*  145 */     VData result = new VData();
/*  146 */     LNPRiskScreenValidateDB ttLNPRiskScreenValidateDB = new LNPRiskScreenValidateDB();
/*  147 */     ttLNPRiskScreenValidateDB.setRiskCode(tPolElementSchema.getRiskCode());
/*  148 */     ttLNPRiskScreenValidateDB.setFunctionType("1");
/*  149 */     ttLNPRiskScreenValidateDB.setControlCode(ControlCode);
/*  150 */     ttLNPRiskScreenValidateDB.setControlValue(ControlValue);
/*  151 */     LNPRiskScreenValidateSet rrLNPRiskScreenValidateSet = ttLNPRiskScreenValidateDB
/*  152 */       .query();
/*  153 */     if (rrLNPRiskScreenValidateSet.size() > 0) {
/*  154 */       ExeSQL rExeSQL = new ExeSQL();
/*      */ 
/*  156 */       for (int i = 1; i <= rrLNPRiskScreenValidateSet.size(); i++)
/*      */       {
/*  158 */         String[] controlVData = new String[4];
/*  159 */         String value = "=\uFFFD\uFFFD\u0461\uFFFD\uFFFD";
/*  160 */         LNPRiskScreenValidateSchema ttLNPRiskScreenValidateSchema = rrLNPRiskScreenValidateSet
/*  161 */           .get(i);
/*  162 */         controlVData[0] = ttLNPRiskScreenValidateSchema
/*  163 */           .getRelaControlCode();
/*  164 */         controlVData[1] = ttLNPRiskScreenValidateSchema
/*  165 */           .getRelaControlType();
/*      */ 
/*  168 */         String sql = ttLNPRiskScreenValidateSchema.getRelaValueSql();
/*  169 */         sql = transeToTypical(sql, tPolElementSchema);
/*      */ 
/*  172 */         SSRS ttSSRS = rExeSQL.execSQL(sql);
/*      */ 
/*  176 */         if (ttLNPRiskScreenValidateSchema.getRelaControlType().equals(
/*  176 */           "1"))
/*      */         {
/*  178 */           for (int r = 1; r <= ttSSRS.MaxRow; r++) {
/*  179 */             if (ttSSRS.getMaxRow() == 1) {
/*  180 */               value = ttSSRS.GetText(r, 1) + "=" + 
/*  181 */                 ttSSRS.GetText(r, 2);
/*      */             }
/*      */             else {
/*  184 */               value = value + "&" + ttSSRS.GetText(r, 1) + "=" + 
/*  185 */                 ttSSRS.GetText(r, 2);
/*      */             }
/*      */           }
/*      */ 
/*  189 */           if (value != null) {
/*  190 */             String[] temp = value.split("&");
/*  191 */             if (temp.length == 2) {
/*  192 */               value = value.replace("=\uFFFD\uFFFD\u0461\uFFFD\uFFFD&", "");
/*      */             }
/*      */           }
/*  195 */           controlVData[2] = value;
/*      */         }
/*      */         else
/*      */         {
/*  199 */           DecimalFormat myformat = new DecimalFormat("#0.00");
/*      */ 
/*  201 */           value = myformat.format(Double.parseDouble(ttSSRS.GetText(
/*  202 */             1, 1)));
/*  203 */           controlVData[2] = value;
/*      */         }
/*      */ 
/*  206 */         String temp = "";
/*  207 */         if ((rrLNPRiskScreenValidateSet.get(i).getNoti() != null) && 
/*  208 */           (rrLNPRiskScreenValidateSet.get(i).getNoti().length() != 0))
/*      */         {
/*  210 */           temp = rrLNPRiskScreenValidateSet.get(i).getNoti();
/*      */         }
/*  212 */         controlVData[3] = temp;
/*  213 */         result.add(controlVData);
/*      */       }
/*      */     }
/*  216 */     return result;
/*      */   }
/*      */ 
/*      */   public String getRusult(LNPRiskParamSchema inLNPRiskParamSchema, LNPPolSchema mainLNPPolShcema)
/*      */   {
/*  222 */     String expression = inLNPRiskParamSchema.getExpression();
/*  223 */     Hashtable reHashtable = new Hashtable();
/*  224 */     reHashtable.put("Amnt", Double.valueOf(mainLNPPolShcema.getAmnt()));
/*  225 */     reHashtable.put("Get", Double.valueOf(mainLNPPolShcema.getAmnt()));
/*  226 */     reHashtable.put("Prem", Double.valueOf(mainLNPPolShcema.getPrem()));
/*      */ 
/*  228 */     reHashtable.put("TopUpPrem", Double.valueOf(mainLNPPolShcema.getTopUpPrem()));
/*  229 */     reHashtable.put("DeadAmntType", mainLNPPolShcema.getDeadAmntType());
/*      */ 
/*  231 */     reHashtable.put("Mult", Double.valueOf(mainLNPPolShcema.getMult()));
/*  232 */     reHashtable.put("PayIntv", Integer.valueOf(mainLNPPolShcema.getPayIntv()));
/*  233 */     reHashtable.put("InsuYear", Integer.valueOf(mainLNPPolShcema.getInsuYear()));
/*  234 */     reHashtable.put("InsuYearFlag", mainLNPPolShcema.getInsuYearFlag());
/*  235 */     reHashtable.put("PayEndYear", Integer.valueOf(mainLNPPolShcema.getPayEndYear()));
/*  236 */     reHashtable.put("PayEndYearFlag", mainLNPPolShcema.getPayEndYearFlag());
/*      */ 
/*  238 */     reHashtable.put("LiveGetMode", mainLNPPolShcema.getLiveGetMode());
/*  239 */     reHashtable.put("StandbyFlag1", mainLNPPolShcema.getStandbyFlag1());
/*  240 */     reHashtable.put("StandbyFlag2", mainLNPPolShcema.getStandbyFlag2());
/*  241 */     reHashtable.put("StandbyFlag3", mainLNPPolShcema.getStandbyFlag3());
/*      */ 
/*  243 */     reHashtable.put("MainRiskCode", mainLNPPolShcema.getRiskCode());
/*      */ 
/*  245 */     ForSpcCalImpl forSpcCalIntf = new ForSpcCalImpl();
/*  246 */     EvalJavaTool evalJavaTool = new EvalJavaTool();
/*      */ 
/*  248 */     reHashtable.put("SpcCalInst", forSpcCalIntf);
/*  249 */     String result = evalJavaTool.executeByExpress(expression, reHashtable);
/*  250 */     return result;
/*      */   }
/*      */ 
/*      */   public VData getUIElementsData(String contNo, String riskCode, String insuredNo, String CurrentMainPolNo, String operatortype)
/*      */   {
/*  255 */     VData result = new VData();
/*      */     try {
/*  257 */       DBConn conn = DBConnPool.getConnection();
/*  258 */       PolElementSchema tPolElementSchema = new PolElementSchema();
/*  259 */       tPolElementSchema.setContNo(contNo);
/*  260 */       tPolElementSchema.setRiskCode(riskCode);
/*  261 */       tPolElementSchema.setMasterPolNo(CurrentMainPolNo);
/*  262 */       tPolElementSchema.setInsuredId(insuredNo);
/*  263 */       tPolElementSchema = setAppntAndInsuredInfo(tPolElementSchema);
/*      */ 
/*  265 */       LNPRiskScreenDB tLNPRiskScreenDB = new LNPRiskScreenDB(conn);
/*  266 */       String sql = "select * from lnpriskscreen Where riskcode='" + riskCode + 
/*  267 */         "' Order By ctrlindex";
/*      */ 
/*  269 */       LNPRiskScreenSet itLNPRiskScreenSet = tLNPRiskScreenDB.executeQuery(sql);
/*  270 */       ExeSQL rExeSQL = new ExeSQL(conn);
/*      */ 
/*  274 */       for (int i = 1; i <= itLNPRiskScreenSet.size(); i++)
/*      */       {
/*  280 */         VData controlVData = new VData();
/*  281 */         String value = "=\uFFFD\uFFFD\u0461\uFFFD\uFFFD";
/*  282 */         LNPRiskScreenSchema ttLNPRiskScreenSchema = itLNPRiskScreenSet.get(i);
/*      */ 
/*  286 */         LNPRiskParamDB inLNPRiskParamdb = new LNPRiskParamDB(conn);
/*  287 */         inLNPRiskParamdb.setRiskCode(riskCode);
/*  288 */         inLNPRiskParamdb.setType("RelaToMainRisk");
/*  289 */         inLNPRiskParamdb.setParam("PayIntv");
/*      */ 
/*  291 */         LNPRiskParamSet inLNPParamSet = inLNPRiskParamdb.query();
/*      */ 
/*  293 */         LNPPolDB mainLNPPolDB = new LNPPolDB(conn);
/*  294 */         mainLNPPolDB.setPolNo(CurrentMainPolNo);
/*      */ 
/*  299 */         if ((inLNPParamSet != null) && 
/*  300 */           (inLNPParamSet.size() > 0) && 
/*  301 */           (mainLNPPolDB.getInfo()) && (
/*  302 */           (ttLNPRiskScreenSchema.getCtrlCode().equals("PayIntv")) || 
/*  303 */           (ttLNPRiskScreenSchema
/*  303 */           .getCtrlCode().equals("PayEndYear")))) {
/*  304 */           LNPRiskParamSchema inLNPRiskParamSchema = inLNPParamSet.get(1);
/*      */ 
/*  309 */           int b = mainLNPPolDB.getPayIntv();
/*  310 */           String c = mainLNPPolDB.getRiskCode();
/*  311 */           if ((b == 0) && (!c.equals("ULES")) && (!c.equals("ULDX")))
/*      */           {
/*  313 */             String a = getRusult(inLNPRiskParamSchema, mainLNPPolDB);
/*  314 */             if (!a.equals("0"))
/*      */               continue;
/*      */           }
/*      */           else
/*      */           {
/*  319 */             controlVData.add(ttLNPRiskScreenSchema.getCtrlCode());
/*  320 */             controlVData.add(ttLNPRiskScreenSchema.getCtrlName());
/*      */ 
/*  322 */             controlVData.add(ttLNPRiskScreenSchema.getCtrlProperty());
/*  323 */             controlVData.add(ttLNPRiskScreenSchema.getDefaultValue());
/*      */ 
/*  326 */             if (ttLNPRiskScreenSchema.getCtrlProperty1() != null)
/*      */             {
/*  328 */               if (ttLNPRiskScreenSchema.getCtrlProperty1().equals(
/*  328 */                 "02")) {
/*  329 */                 if ((CurrentMainPolNo == null) || 
/*  330 */                   (CurrentMainPolNo.length() == 0)) {
/*  331 */                   System.out.println("\uFFFD\uFFFD\uFFFD\u0571\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + CurrentMainPolNo + 
/*  332 */                     "]\u03AA\uFFFD\uFFFD");
/*  333 */                   return null;
/*      */                 }
/*  335 */                 LNPPolDB rLNPPolDB = new LNPPolDB(conn);
/*  336 */                 rLNPPolDB.setPolNo(CurrentMainPolNo);
/*  337 */                 if (!rLNPPolDB.getInfo()) {
/*  338 */                   System.out.println("\uFFFD\uFFFD\uFFFD\u0571\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + CurrentMainPolNo + 
/*  339 */                     "]\uFFFD\uFFFD\uFFFD\uFFFD\u077F\uFFFD\uFFFD\u0432\uFFFD\uFFFD\uFFFD\uFFFD\u06A3\uFFFD");
/*  340 */                   return null;
/*      */                 }
/*  342 */                 String ctlname = ttLNPRiskScreenSchema
/*  343 */                   .getCtrlBackground();
/*      */ 
/*  345 */                 if (ctlname.equals("PayIntv")) {
/*  346 */                   if (rLNPPolDB.getPayIntv() == 0)
/*  347 */                     value = value + "&0=\uFFFD";
/*  348 */                   else if (rLNPPolDB.getPayIntv() == 1)
/*  349 */                     value = value + "&1=\uFFFD\u00BD\uFFFD";
/*  350 */                   else if (rLNPPolDB.getPayIntv() == 3)
/*  351 */                     value = value + "&3=\uFFFD\uFFFD\uFFFD\uFFFD";
/*  352 */                   else if (rLNPPolDB.getPayIntv() == 6)
/*  353 */                     value = value + "&6=\uFFFD\uFFFD\uFFFD\uAF7B";
/*  354 */                   else if (rLNPPolDB.getPayIntv() == 12)
/*  355 */                     value = value + "&12=\uFFFD\uAF7B";
/*      */                 }
/*  357 */                 else if (ctlname.equals("Prem"))
/*  358 */                   value = rLNPPolDB.getPrem();
/*  359 */                 else if (ctlname.equals("TopUpPrem"))
/*  360 */                   value = rLNPPolDB.getTopUpPrem();
/*  361 */                 else if (ctlname.equals("DeadAmntType")) {
/*  362 */                   if ("1".equals(rLNPPolDB.getDeadAmntType()))
/*  363 */                     value = value + "&1=\u0461\uFFFD\uFFFD\u04BB";
/*  364 */                   else if ("2".equals(rLNPPolDB.getDeadAmntType()))
/*  365 */                     value = value + "&2=\u0461\uFFFD\uFFFD\uFFFD";
/*      */                 }
/*  367 */                 else if (ctlname.equals("Amnt"))
/*      */                 {
/*  369 */                   value = (int)rLNPPolDB.getAmnt();
/*  370 */                 } else if (ctlname.equals("LiveGetMode"))
/*  371 */                   value = value + "&" + rLNPPolDB.getLiveGetMode() + "=\u00FF" + 
/*  372 */                     rLNPPolDB.getLiveGetMode() + "\uFFFD\uFFFD\uFFFD\uFFFD\u0221";
/*  373 */                 else if ((ctlname.equals("BonusGetMode")) && 
/*  374 */                   (rLNPPolDB.getBonusGetMode() != null) && 
/*  375 */                   (rLNPPolDB.getBonusGetMode().length() > 0))
/*      */                 {
/*  380 */                   if (rLNPPolDB.getBonusGetMode().equals("1"))
/*  381 */                     value = value + "&1=\uFFFD\uFFFD\u0221\uFFFD\u05BD\uFFFD";
/*  382 */                   else if (rLNPPolDB.getBonusGetMode().equals("2"))
/*  383 */                     value = value + "&2=\uFFFD\u05BD\u0271\uFFFD\uFFFD\uFFFD";
/*  384 */                   else if (rLNPPolDB.getBonusGetMode().equals("3"))
/*  385 */                     value = value + "&3=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*  386 */                   else if (rLNPPolDB.getBonusGetMode().equals("4"))
/*  387 */                     value = value + "&4=\uFFFD\u06FB\uFFFD\uFFFD\uFFFD\u03E2";
/*      */                 }
/*  389 */                 else if (ctlname.equals("PayEndYear")) {
/*  390 */                   if (rLNPPolDB.getPayEndYearFlag().equals("Y")) {
/*  391 */                     int payendy = rLNPPolDB.getPayEndYear();
/*  392 */                     if (payendy == 1000) {
/*  393 */                       payendy = 0;
/*      */                     }
/*  395 */                     value = value + "&" + payendy + "=" + payendy + "\uFFFD\uFFFD";
/*  396 */                   } else if (rLNPPolDB.getPayEndYearFlag().equals("A")) {
/*  397 */                     value = value + "&" + rLNPPolDB.getPayEndYear() + "=\uFFFD\uFFFD" + 
/*  398 */                       rLNPPolDB.getPayEndYear() + "\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */                   }
/*  400 */                 } else if (ctlname.equals("PayEndYearFlag")) {
/*  401 */                   if (rLNPPolDB.getPayEndYearFlag().equals("Y"))
/*  402 */                     value = value + "&Y=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*  403 */                   else if (rLNPPolDB.getPayEndYearFlag().equals("A"))
/*  404 */                     value = value + "&A=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */                 }
/*  406 */                 else if (ctlname.equals("GetYear")) {
/*  407 */                   if (rLNPPolDB.getGetYearFlag().equals("Y"))
/*  408 */                     value = value + "&" + rLNPPolDB.getGetYear() + "=" + 
/*  409 */                       rLNPPolDB.getGetYear() + "\uFFFD\uFFFD";
/*  410 */                   else if (rLNPPolDB.getGetYearFlag().equals("A"))
/*  411 */                     value = value + "&" + rLNPPolDB.getGetYear() + "=\uFFFD\uFFFD" + 
/*  412 */                       rLNPPolDB.getGetYear() + "\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */                 }
/*  414 */                 else if (ctlname.equals("GetYearFlag")) {
/*  415 */                   if (rLNPPolDB.getGetYearFlag().equals("Y"))
/*  416 */                     value = value + "&Y=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*  417 */                   else if (rLNPPolDB.getGetYearFlag().equals("A"))
/*  418 */                     value = value + "&A=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */                 }
/*  420 */                 else if (ctlname.equals("InsuYear")) {
/*  421 */                   if (rLNPPolDB.getInsuYearFlag().equals("Y")) {
/*  422 */                     int insuy = rLNPPolDB.getInsuYear();
/*  423 */                     if (insuy == 1000) {
/*  424 */                       insuy = 106;
/*      */                     }
/*  426 */                     value = value + "&" + insuy + "=" + insuy + "\uFFFD\uFFFD";
/*  427 */                   } else if (rLNPPolDB.getInsuYearFlag().equals("A")) {
/*  428 */                     value = value + "&" + rLNPPolDB.getInsuYear() + "=\uFFFD\uFFFD" + 
/*  429 */                       rLNPPolDB.getInsuYear() + "\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */                   }
/*  431 */                 } else if (ctlname.equals("InsuYearFlag")) {
/*  432 */                   if (rLNPPolDB.getInsuYearFlag().equals("Y"))
/*  433 */                     value = value + "&Y=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*  434 */                   else if (rLNPPolDB.getInsuYearFlag().equals("A")) {
/*  435 */                     value = value + "&A=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */                   }
/*      */ 
/*      */                 }
/*      */ 
/*  441 */                 String valueSql = ttLNPRiskScreenSchema.getDefaultSql();
/*  442 */                 if ((valueSql != null) && (valueSql.length() > 0)) {
/*  443 */                   valueSql = transeToTypical(valueSql, 
/*  444 */                     tPolElementSchema);
/*      */ 
/*  447 */                   valueSql = StrTool.replace(valueSql, "?MasterPolNo?", 
/*  448 */                     CurrentMainPolNo);
/*  449 */                   SSRS ttSSRS = rExeSQL.execSQL(valueSql);
/*      */ 
/*  454 */                   if (ttLNPRiskScreenSchema.getCtrlProperty().equals(
/*  454 */                     "01")) {
/*  455 */                     if ((ttSSRS != null) && (ttSSRS.getMaxRow() > 0)) {
/*  456 */                       for (int r = 1; r <= ttSSRS.MaxRow; r++)
/*  457 */                         value = value + "&" + ttSSRS.GetText(r, 1) + 
/*  458 */                           "=" + ttSSRS.GetText(r, 2);
/*      */                     }
/*      */                   }
/*      */                   else
/*      */                   {
/*  463 */                     value = "";
/*  464 */                     if ((ttSSRS != null) && (ttSSRS.getMaxRow() > 0)) {
/*  465 */                       value = ttSSRS.GetText(1, 1);
/*      */                     }
/*      */                   }
/*      */                 }
/*      */ 
/*  470 */                 controlVData.add(value);
/*  471 */                 controlVData.add(ttLNPRiskScreenSchema
/*  472 */                   .getCtrlProperty2());
/*  473 */                 result.add(controlVData);
/*  474 */                 continue;
/*      */               }
/*      */             }
/*      */ 
/*  478 */             String valueSql = ttLNPRiskScreenSchema.getDefaultSql();
/*      */ 
/*  480 */             valueSql = transeToTypical(valueSql, tPolElementSchema);
/*      */ 
/*  482 */             if ((valueSql == null) || (valueSql.equals(""))) {
/*  483 */               value = "";
/*      */             } else {
/*  485 */               SSRS ttSSRS = rExeSQL.execSQL(valueSql);
/*      */ 
/*  489 */               if (ttLNPRiskScreenSchema.getCtrlProperty().equals(
/*  489 */                 "01"))
/*      */               {
/*  491 */                 for (int r = 1; r <= ttSSRS.MaxRow; r++) {
/*  492 */                   value = value + "&" + ttSSRS.GetText(r, 1) + "=" + 
/*  493 */                     ttSSRS.GetText(r, 2);
/*      */                 }
/*      */               }
/*      */               else {
/*  497 */                 value = ttSSRS.GetText(1, 1);
/*      */               }
/*      */             }
/*      */ 
/*  501 */             if (value != null) {
/*  502 */               String[] temp = value.split("&");
/*  503 */               if (temp.length == 2) {
/*  504 */                 value = value.replace("=\uFFFD\uFFFD\u0461\uFFFD\uFFFD&", "");
/*      */               }
/*      */             }
/*  507 */             controlVData.add(value);
/*  508 */             controlVData.add(ttLNPRiskScreenSchema
/*  509 */               .getCtrlProperty2());
/*  510 */             result.add(controlVData);
/*      */           }
/*      */ 
/*      */         }
/*  516 */         else if (("add".equals(operatortype)) && 
/*  517 */           (this.hidePayEndYear) && ("PayEndYear".equals(ttLNPRiskScreenSchema.getCtrlCode()))) {
/*  518 */           this.hidePayEndYear = false;
/*      */         }
/*      */         else
/*      */         {
/*  524 */           controlVData.add(ttLNPRiskScreenSchema.getCtrlCode());
/*  525 */           controlVData.add(ttLNPRiskScreenSchema.getCtrlName());
/*      */ 
/*  527 */           controlVData.add(ttLNPRiskScreenSchema.getCtrlProperty());
/*  528 */           controlVData.add(ttLNPRiskScreenSchema.getDefaultValue());
/*      */ 
/*  531 */           if ((ttLNPRiskScreenSchema.getCtrlProperty1() != null) && 
/*  532 */             (ttLNPRiskScreenSchema.getCtrlProperty1().equals("02"))) {
/*  533 */             if ((CurrentMainPolNo == null) || 
/*  534 */               (CurrentMainPolNo.length() == 0)) {
/*  535 */               System.out.println("\uFFFD\uFFFD\uFFFD\u0571\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + CurrentMainPolNo + "]\u03AA\uFFFD\uFFFD");
/*  536 */               return null;
/*      */             }
/*  538 */             LNPPolDB rLNPPolDB = new LNPPolDB(conn);
/*  539 */             rLNPPolDB.setPolNo(CurrentMainPolNo);
/*  540 */             if (!rLNPPolDB.getInfo()) {
/*  541 */               System.out.println("\uFFFD\uFFFD\uFFFD\u0571\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + CurrentMainPolNo + 
/*  542 */                 "]\uFFFD\uFFFD\uFFFD\uFFFD\u077F\uFFFD\uFFFD\u0432\uFFFD\uFFFD\uFFFD\uFFFD\u06A3\uFFFD");
/*  543 */               return null;
/*      */             }
/*  545 */             String ctlname = ttLNPRiskScreenSchema.getCtrlBackground();
/*      */ 
/*  547 */             if (ctlname.equals("PayIntv")) {
/*  548 */               if (rLNPPolDB.getPayIntv() == 0) {
/*  549 */                 value = value + "&0=\uFFFD";
/*      */               }
/*  551 */               if (rLNPPolDB.getPayIntv() == 1) {
/*  552 */                 value = value + "&1=\uFFFD\u00BD\uFFFD";
/*      */               }
/*  554 */               if (rLNPPolDB.getPayIntv() == 3) {
/*  555 */                 value = value + "&3=\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */               }
/*  557 */               if (rLNPPolDB.getPayIntv() == 6) {
/*  558 */                 value = value + "&6=\uFFFD\uFFFD\uFFFD\uAF7B";
/*      */               }
/*  560 */               if (rLNPPolDB.getPayIntv() == 12)
/*  561 */                 value = value + "&12=\uFFFD\uAF7B";
/*      */             }
/*  563 */             else if (ctlname.equals("Prem")) {
/*  564 */               value = rLNPPolDB.getPrem();
/*  565 */             } else if (ctlname.equals("TopUpPrem")) {
/*  566 */               value = rLNPPolDB.getTopUpPrem();
/*  567 */             } else if (ctlname.equals("DeadAmntType")) {
/*  568 */               if ("1".equals(rLNPPolDB.getDeadAmntType()))
/*  569 */                 value = value + "&1=\u0461\uFFFD\uFFFD\u04BB";
/*  570 */               else if ("2".equals(rLNPPolDB.getDeadAmntType()))
/*  571 */                 value = value + "&2=\u0461\uFFFD\uFFFD\uFFFD";
/*      */             }
/*  573 */             else if (ctlname.equals("Amnt")) {
/*  574 */               value = (int)rLNPPolDB.getAmnt();
/*  575 */             } else if (ctlname.equals("LiveGetMode")) {
/*  576 */               value = value + "&" + rLNPPolDB.getLiveGetMode() + "=\u00FF" + 
/*  577 */                 rLNPPolDB.getLiveGetMode() + "\uFFFD\uFFFD\uFFFD\uFFFD\u0221";
/*  578 */             } else if ((ctlname.equals("BonusGetMode")) && 
/*  579 */               (rLNPPolDB.getBonusGetMode() != null) && 
/*  580 */               (rLNPPolDB.getBonusGetMode().length() > 0))
/*      */             {
/*  585 */               if (rLNPPolDB.getBonusGetMode().equals("1")) {
/*  586 */                 value = value + "&1=\uFFFD\uFFFD\u0221\uFFFD\u05BD\uFFFD";
/*      */               }
/*  588 */               if (rLNPPolDB.getBonusGetMode().equals("2")) {
/*  589 */                 value = value + "&2=\uFFFD\u05BD\u0271\uFFFD\uFFFD\uFFFD";
/*      */               }
/*  591 */               if (rLNPPolDB.getBonusGetMode().equals("3")) {
/*  592 */                 value = value + "&3=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */               }
/*  594 */               if (rLNPPolDB.getBonusGetMode().equals("4"))
/*  595 */                 value = value + "&4=\uFFFD\u06FB\uFFFD\uFFFD\uFFFD\u03E2";
/*      */             }
/*  597 */             else if (ctlname.equals("PayEndYear")) {
/*  598 */               if (rLNPPolDB.getPayEndYearFlag().equals("Y")) {
/*  599 */                 int payendy = rLNPPolDB.getPayEndYear();
/*  600 */                 if (payendy == 1000) {
/*  601 */                   payendy = 0;
/*      */                 }
/*  603 */                 value = value + "&" + payendy + "=" + payendy + "\uFFFD\uFFFD";
/*      */               }
/*  605 */               if (rLNPPolDB.getPayEndYearFlag().equals("A"))
/*  606 */                 value = value + "&" + rLNPPolDB.getPayEndYear() + "=\uFFFD\uFFFD" + 
/*  607 */                   rLNPPolDB.getPayEndYear() + "\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */             }
/*  609 */             else if (ctlname.equals("PayEndYearFlag")) {
/*  610 */               if (rLNPPolDB.getPayEndYearFlag().equals("Y")) {
/*  611 */                 value = value + "&Y=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */               }
/*  613 */               if (rLNPPolDB.getPayEndYearFlag().equals("A"))
/*  614 */                 value = value + "&A=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */             }
/*  616 */             else if (ctlname.equals("GetYear")) {
/*  617 */               if (rLNPPolDB.getGetYearFlag().equals("Y")) {
/*  618 */                 value = value + "&" + rLNPPolDB.getGetYear() + "=" + 
/*  619 */                   rLNPPolDB.getGetYear() + "\uFFFD\uFFFD";
/*      */               }
/*  621 */               if (rLNPPolDB.getGetYearFlag().equals("A"))
/*  622 */                 value = value + "&" + rLNPPolDB.getGetYear() + "=\uFFFD\uFFFD" + 
/*  623 */                   rLNPPolDB.getGetYear() + "\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */             }
/*  625 */             else if (ctlname.equals("GetYearFlag")) {
/*  626 */               if (rLNPPolDB.getGetYearFlag().equals("Y")) {
/*  627 */                 value = value + "&Y=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */               }
/*  629 */               if (rLNPPolDB.getGetYearFlag().equals("A"))
/*  630 */                 value = value + "&A=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */             }
/*  632 */             else if (ctlname.equals("InsuYear")) {
/*  633 */               if (rLNPPolDB.getInsuYearFlag().equals("Y")) {
/*  634 */                 int insuy = rLNPPolDB.getInsuYear();
/*  635 */                 if (insuy == 1000) {
/*  636 */                   insuy = 106;
/*      */                 }
/*  638 */                 value = value + "&" + insuy + "=" + insuy + "\uFFFD\uFFFD";
/*      */               }
/*  640 */               if (rLNPPolDB.getInsuYearFlag().equals("A"))
/*  641 */                 value = value + "&" + rLNPPolDB.getInsuYear() + "=\uFFFD\uFFFD" + 
/*  642 */                   rLNPPolDB.getInsuYear() + "\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */             }
/*  644 */             else if (ctlname.equals("InsuYearFlag")) {
/*  645 */               if (rLNPPolDB.getInsuYearFlag().equals("Y")) {
/*  646 */                 value = value + "&Y=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */               }
/*  648 */               if (rLNPPolDB.getInsuYearFlag().equals("A")) {
/*  649 */                 value = value + "&A=\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/*  655 */             String valueSql = ttLNPRiskScreenSchema.getDefaultSql();
/*  656 */             if ((valueSql != null) && (valueSql.length() > 0)) {
/*  657 */               valueSql = transeToTypical(valueSql, tPolElementSchema);
/*      */ 
/*  659 */               valueSql = StrTool.replace(valueSql, "?MasterPolNo?", 
/*  660 */                 CurrentMainPolNo);
/*  661 */               SSRS ttSSRS = rExeSQL.execSQL(valueSql);
/*      */ 
/*  665 */               if (ttLNPRiskScreenSchema.getCtrlProperty().equals("01")) {
/*  666 */                 if ((ttSSRS != null) && (ttSSRS.getMaxRow() > 0)) {
/*  667 */                   for (int r = 1; r <= ttSSRS.MaxRow; r++)
/*  668 */                     value = value + "&" + ttSSRS.GetText(r, 1) + "=" + 
/*  669 */                       ttSSRS.GetText(r, 2);
/*      */                 }
/*      */               }
/*      */               else
/*      */               {
/*  674 */                 value = "";
/*  675 */                 if ((ttSSRS != null) && (ttSSRS.getMaxRow() > 0)) {
/*  676 */                   value = ttSSRS.GetText(1, 1);
/*      */                 }
/*      */ 
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/*  683 */             value = keepPayIntvUnique(value);
/*  684 */             controlVData.add(value);
/*  685 */             controlVData.add(ttLNPRiskScreenSchema.getCtrlProperty2());
/*  686 */             result.add(controlVData);
/*      */           }
/*      */           else
/*      */           {
/*  692 */             String valueSql = ttLNPRiskScreenSchema.getDefaultSql();
/*      */ 
/*  694 */             valueSql = transeToTypical(valueSql, tPolElementSchema);
/*      */ 
/*  696 */             if ((valueSql == null) || (valueSql.equals(""))) {
/*  697 */               value = "";
/*      */             } else {
/*  699 */               SSRS ttSSRS = rExeSQL.execSQL(valueSql);
/*      */ 
/*  702 */               if (ttLNPRiskScreenSchema.getCtrlProperty().equals("01"))
/*      */               {
/*  704 */                 for (int r = 1; r <= ttSSRS.MaxRow; r++) {
/*  705 */                   value = value + "&" + ttSSRS.GetText(r, 1) + "=" + 
/*  706 */                     ttSSRS.GetText(r, 2);
/*      */                 }
/*      */               }
/*      */               else {
/*  710 */                 value = ttSSRS.GetText(1, 1);
/*      */               }
/*      */             }
/*      */ 
/*  714 */             if (value != null) {
/*  715 */               String[] temp = value.split("&");
/*  716 */               if (temp.length == 2) {
/*  717 */                 value = value.replace("=\uFFFD\uFFFD\u0461\uFFFD\uFFFD&", "");
/*      */               }
/*      */             }
/*  720 */             controlVData.add(value);
/*  721 */             controlVData.add(ttLNPRiskScreenSchema.getCtrlProperty2());
/*  722 */             result.add(controlVData);
/*      */           }
/*      */         }
/*      */       }
/*      */       try {
/*  727 */         conn.close();
/*      */       }
/*      */       catch (SQLException e) {
/*  730 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */     catch (Exception ex) {
/*  734 */       ex.printStackTrace();
/*      */     }
/*  736 */     return result;
/*      */   }
/*      */ 
/*      */   public String transeToTypical(String sqlStr, PolElementSchema tPolElementSchema)
/*      */   {
/*  744 */     String tempsql = sqlStr;
/*  745 */     tempsql = StrTool.replace(tempsql, "?PayIntv?", tPolElementSchema
/*  746 */       .getPayIntv());
/*      */ 
/*  748 */     tempsql = StrTool.replace(tempsql, "?GetIntv?", tPolElementSchema
/*  749 */       .getGetIntv());
/*      */ 
/*  751 */     tempsql = StrTool.replace(tempsql, "?Mult?", 
/*  752 */       subStringInt(tPolElementSchema.getMult()));
/*      */ 
/*  754 */     tempsql = StrTool.replace(tempsql, "?DeadAmntType?", 
/*  755 */       tPolElementSchema.getDeadAmntType());
/*      */ 
/*  757 */     tempsql = StrTool.replace(tempsql, "?TopUpPrem?", 
/*  758 */       subStringInt(tPolElementSchema.getTopUpPrem()));
/*      */ 
/*  760 */     tempsql = StrTool.replace(tempsql, "?Prem?", 
/*  761 */       subStringInt(tPolElementSchema.getPrem()));
/*      */ 
/*  763 */     tempsql = StrTool.replace(tempsql, "?AppAge?", tPolElementSchema
/*  764 */       .getAppAge());
/*      */ 
/*  766 */     tempsql = StrTool.replace(tempsql, "?AppAgeType?", tPolElementSchema
/*  767 */       .getAppAgeType());
/*      */ 
/*  769 */     tempsql = StrTool.replace(tempsql, "?Sex?", tPolElementSchema.getSex());
/*  770 */     tempsql = StrTool.replace(tempsql, "?OccupationCode?", 
/*  771 */       tPolElementSchema.getOccupationCode());
/*  772 */     tempsql = StrTool.replace(tempsql, "?PayEndYear?", tPolElementSchema
/*  773 */       .getPayEndYear());
/*      */ 
/*  775 */     tempsql = StrTool.replace(tempsql, "?PayEndYearFlag?", 
/*  776 */       tPolElementSchema.getPayEndYearFlag());
/*      */ 
/*  779 */     tempsql = StrTool.replace(tempsql, "?GetYear?", tPolElementSchema
/*  780 */       .getGetYear());
/*      */ 
/*  782 */     tempsql = StrTool.replace(tempsql, "?GetYearFlag?", tPolElementSchema
/*  783 */       .getGetYearFlag());
/*  784 */     tempsql = StrTool.replace(tempsql, "?Years?", tPolElementSchema
/*  785 */       .getYears());
/*      */ 
/*  787 */     tempsql = StrTool.replace(tempsql, "?InsuYear?", tPolElementSchema
/*  788 */       .getInsuYear());
/*      */ 
/*  790 */     tempsql = StrTool.replace(tempsql, "?InsuYearFlag?", tPolElementSchema
/*  791 */       .getInsuYearFlag());
/*      */ 
/*  793 */     tempsql = StrTool.replace(tempsql, "?LiveGetMode?", tPolElementSchema
/*  794 */       .getLiveGetMode());
/*      */ 
/*  796 */     tempsql = StrTool.replace(tempsql, "?PolNo?", tPolElementSchema
/*  797 */       .getPolNo());
/*      */ 
/*  801 */     tempsql = StrTool.replace(tempsql, "?Amnt?", 
/*  802 */       subStringInt(tPolElementSchema.getAmnt()));
/*      */ 
/*  804 */     tempsql = StrTool.replace(tempsql, "?StandbyFlag1?", tPolElementSchema
/*  805 */       .getStandbyFlag1());
/*  806 */     tempsql = StrTool.replace(tempsql, "?StandbyFlag2?", tPolElementSchema
/*  807 */       .getStandbyFlag2());
/*  808 */     tempsql = StrTool.replace(tempsql, "?StandbyFlag3?", tPolElementSchema
/*  809 */       .getStandbyFlag3());
/*  810 */     tempsql = StrTool.replace(tempsql, "?ContNo?", tPolElementSchema
/*  811 */       .getContNo());
/*  812 */     tempsql = StrTool.replace(tempsql, "?DutyCode?", tPolElementSchema
/*  813 */       .getDutyCode());
/*  814 */     tempsql = StrTool.replace(tempsql, "?BonusGetMode?", tPolElementSchema
/*  815 */       .getBonusGetMode());
/*  816 */     tempsql = StrTool.replace(tempsql, "?MainPolNo?", tPolElementSchema
/*  817 */       .getMainPolNo());
/*  818 */     tempsql = StrTool.replace(tempsql, "?MasterPolNo?", tPolElementSchema
/*  819 */       .getMasterPolNo());
/*  820 */     tempsql = StrTool.replace(tempsql, "?AppntSex?", tPolElementSchema
/*  821 */       .getAppntSex());
/*  822 */     tempsql = StrTool.replace(tempsql, "?AppntAge?", tPolElementSchema
/*  823 */       .getAppntAge());
/*      */ 
/*  825 */     tempsql = StrTool.replace(tempsql, "?AppntAgeType?", tPolElementSchema
/*  826 */       .getAppntAgeType());
/*      */ 
/*  829 */     return tempsql;
/*      */   }
/*      */ 
/*      */   public String subStringInt(double value) {
/*  833 */     if (value == (int)value) {
/*  834 */       return (int)value;
/*      */     }
/*      */ 
/*  837 */     DecimalFormat myformat = new DecimalFormat("#0.00");
/*      */ 
/*  840 */     return myformat.format(value);
/*      */   }
/*      */ 
/*      */   public VData getAllCtrolCurrentValue(String PolNo)
/*      */   {
/*  845 */     if ((PolNo == null) || (PolNo.length() == 0)) {
/*  846 */       return null;
/*      */     }
/*  848 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/*  849 */     reLNPPolDB.setPolNo(PolNo);
/*  850 */     if (reLNPPolDB.getInfo()) {
/*  851 */       VData reuslt = new VData();
/*  852 */       LNPRiskScreenDB reLNPRiskScreenDB = new LNPRiskScreenDB();
/*  853 */       String sql = "select * from lnpriskscreen where riskcode='" + 
/*  854 */         reLNPPolDB.getRiskCode() + "'" + " ORDER BY CtrlIndex";
/*  855 */       LNPRiskScreenSet reLNPRiskScreenDBSet = reLNPRiskScreenDB
/*  856 */         .executeQuery(sql);
/*  857 */       if ((reLNPRiskScreenDBSet != null) && (reLNPRiskScreenDBSet.size() > 0)) {
/*  858 */         LNPRiskScreenSchema rLNPRiskScreenSchema = null;
/*  859 */         for (int i = 1; i <= reLNPRiskScreenDBSet.size(); i++) {
/*  860 */           rLNPRiskScreenSchema = reLNPRiskScreenDBSet.get(i);
/*  861 */           String value = getCtrlInfoFromPol(rLNPRiskScreenSchema
/*  862 */             .getCtrlCode(), reLNPPolDB);
/*  863 */           String[] set = new String[2];
/*  864 */           set[0] = rLNPRiskScreenSchema.getCtrlCode();
/*  865 */           set[1] = value;
/*      */ 
/*  867 */           if ((set[0] != null) && (!set[0].equals("null")) && 
/*  868 */             (set[0].equalsIgnoreCase("PayEndYear")))
/*      */           {
/*      */             int tmp193_192 = 1;
/*      */             String[] tmp193_190 = set; tmp193_190[tmp193_192] = 
/*  870 */               (tmp193_190[tmp193_192] + "/" + 
/*  870 */               getCtrlInfoFromPol("PayEndYearFlag", 
/*  871 */               reLNPPolDB));
/*      */           }
/*  873 */           if ((set[0] != null) && (!set[0].equals("null")) && 
/*  874 */             (set[0].equalsIgnoreCase("InsuYear")))
/*      */           {
/*      */             int tmp263_262 = 1;
/*      */             String[] tmp263_260 = set; tmp263_260[tmp263_262] = 
/*  876 */               (tmp263_260[tmp263_262] + "/" + 
/*  876 */               getCtrlInfoFromPol("InsuYearFlag", reLNPPolDB));
/*      */           }
/*  878 */           if ((set[0] != null) && (!set[0].equals("null")) && 
/*  879 */             (set[0].equalsIgnoreCase("GetYear")))
/*      */           {
/*      */             int tmp333_332 = 1;
/*      */             String[] tmp333_330 = set; tmp333_330[tmp333_332] = 
/*  881 */               (tmp333_330[tmp333_332] + "/" + 
/*  881 */               getCtrlInfoFromPol("GetYearFlag", reLNPPolDB));
/*      */           }
/*  883 */           reuslt.add(set);
/*      */         }
/*      */       }
/*  886 */       return reuslt;
/*      */     }
/*  888 */     return null;
/*      */   }
/*      */ 
/*      */   private String getCtrlInfoFromPol(String controlcode, LNPPolDB rLNPPolDB)
/*      */   {
/*  895 */     if ((controlcode == null) || (controlcode.length() == 0) || 
/*  896 */       (rLNPPolDB == null)) {
/*  897 */       return "";
/*      */     }
/*  899 */     if (controlcode.equals("PayIntv"))
/*      */     {
/*  901 */       return rLNPPolDB.getPayIntv();
/*  902 */     }if (controlcode.equals("GetIntv"))
/*  903 */       return rLNPPolDB.getApproveCode();
/*  904 */     if (controlcode.equals("Mult"))
/*  905 */       return subStringInt(rLNPPolDB.getMult());
/*  906 */     if (controlcode.equals("TopUpPrem"))
/*  907 */       return subStringInt(rLNPPolDB.getTopUpPrem());
/*  908 */     if (controlcode.equals("DeadAmntType"))
/*  909 */       return rLNPPolDB.getDeadAmntType();
/*  910 */     if (controlcode.equals("Prem")) {
/*  911 */       DecimalFormat myformat = new DecimalFormat("#0.00");
/*      */ 
/*  913 */       return myformat.format(rLNPPolDB.getPrem());
/*  914 */     }if (controlcode.equals("PayEndYear"))
/*  915 */       return rLNPPolDB.getPayEndYear();
/*  916 */     if (controlcode.equals("PayEndYearFlag"))
/*  917 */       return rLNPPolDB.getPayEndYearFlag();
/*  918 */     if (controlcode.equals("GetYear"))
/*  919 */       return rLNPPolDB.getGetYear();
/*  920 */     if (controlcode.equals("GetYearFlag"))
/*  921 */       return rLNPPolDB.getGetYearFlag();
/*  922 */     if (controlcode.equals("InsuYear"))
/*  923 */       return rLNPPolDB.getInsuYear();
/*  924 */     if (controlcode.equals("InsuYearFlag"))
/*  925 */       return rLNPPolDB.getInsuYearFlag();
/*  926 */     if (controlcode.equals("LiveGetMode"))
/*  927 */       return rLNPPolDB.getLiveGetMode();
/*  928 */     if (controlcode.equals("Amnt"))
/*  929 */       return subStringInt(rLNPPolDB.getAmnt());
/*  930 */     if (controlcode.equals("StandbyFlag1"))
/*  931 */       return rLNPPolDB.getStandbyFlag1();
/*  932 */     if (controlcode.equals("StandbyFlag2"))
/*  933 */       return rLNPPolDB.getStandbyFlag2();
/*  934 */     if (controlcode.equals("StandbyFlag3"))
/*  935 */       return rLNPPolDB.getStandbyFlag3();
/*  936 */     if (controlcode.equals("DutyCode"))
/*  937 */       return rLNPPolDB.getStandbyFlag2();
/*  938 */     if (controlcode.equals("BonusGetMode")) {
/*  939 */       return rLNPPolDB.getBonusGetMode();
/*      */     }
/*  941 */     return "";
/*      */   }
/*      */ 
/*      */   public PolElementSchema getPolElementSchemaByPolNo(String PolNo) {
/*  945 */     PolElementSchema rrPolElementSchema = new PolElementSchema();
/*  946 */     LNPPolDB wweLNPPolDB = new LNPPolDB();
/*  947 */     wweLNPPolDB.setPolNo(PolNo);
/*  948 */     if (wweLNPPolDB.getInfo()) {
/*  949 */       rrPolElementSchema.setAmnt(wweLNPPolDB.getAmnt());
/*      */ 
/*  952 */       rrPolElementSchema.setDeadAmntType(wweLNPPolDB.getDeadAmntType());
/*  953 */       rrPolElementSchema.setTopUpPrem(wweLNPPolDB.getTopUpPrem());
/*      */ 
/*  955 */       rrPolElementSchema.setPrem(wweLNPPolDB.getPrem());
/*  956 */       rrPolElementSchema.setPayIntv(wweLNPPolDB.getPayIntv());
/*  957 */       String getintvstr = wweLNPPolDB.getApproveCode();
/*  958 */       if ((getintvstr != null) && (getintvstr.length() > 0)) {
/*  959 */         rrPolElementSchema.setGetIntv(Integer.parseInt(getintvstr));
/*      */       }
/*  961 */       rrPolElementSchema.setPayEndYear(wweLNPPolDB.getPayEndYear());
/*  962 */       rrPolElementSchema
/*  963 */         .setPayEndYearFlag(wweLNPPolDB.getPayEndYearFlag());
/*  964 */       rrPolElementSchema.setGetYear(wweLNPPolDB.getGetYear());
/*  965 */       rrPolElementSchema.setGetYearFlag(wweLNPPolDB.getGetYearFlag());
/*  966 */       rrPolElementSchema.setInsuYear(wweLNPPolDB.getInsuYear());
/*  967 */       rrPolElementSchema.setInsuYearFlag(wweLNPPolDB.getInsuYearFlag());
/*      */ 
/*  969 */       rrPolElementSchema.setMasterPolNo(wweLNPPolDB.getMasterPolNo());
/*  970 */       rrPolElementSchema.setRiskCode(wweLNPPolDB.getRiskCode());
/*  971 */       rrPolElementSchema.setStandbyFlag1(wweLNPPolDB.getStandbyFlag1());
/*  972 */       rrPolElementSchema.setStandbyFlag2(wweLNPPolDB.getStandbyFlag2());
/*  973 */       rrPolElementSchema.setStandbyFlag3(wweLNPPolDB.getStandbyFlag3());
/*  974 */       rrPolElementSchema.setLiveGetMode(wweLNPPolDB.getLiveGetMode());
/*  975 */       rrPolElementSchema.setBonusGetMode(wweLNPPolDB.getBonusGetMode());
/*  976 */       rrPolElementSchema.setContNo(wweLNPPolDB.getContNo());
/*  977 */       rrPolElementSchema.setPolNo(wweLNPPolDB.getPolNo());
/*      */ 
/*  980 */       LNPContDB reLNPContDB = new LNPContDB();
/*  981 */       reLNPContDB.setContNo(rrPolElementSchema.getContNo());
/*  982 */       if (reLNPContDB.getInfo())
/*      */       {
/*  984 */         String insuredId = wweLNPPolDB.getInsuredId();
/*  985 */         if ((insuredId != null) && (insuredId.length() > 0) && 
/*  986 */           (!insuredId.equals("null"))) {
/*  987 */           LNPInsuredDB yuLNPInsuredDB = new LNPInsuredDB();
/*  988 */           yuLNPInsuredDB.setContNo(rrPolElementSchema.getContNo());
/*  989 */           yuLNPInsuredDB.setInsuredId(insuredId);
/*  990 */           if (yuLNPInsuredDB.getInfo()) {
/*  991 */             rrPolElementSchema.setSex(yuLNPInsuredDB.getSex());
/*  992 */             rrPolElementSchema.setOccupationCode(yuLNPInsuredDB
/*  993 */               .getOccupationCode());
/*      */ 
/*  995 */             int age = yuLNPInsuredDB.getAppAge();
/*  996 */             rrPolElementSchema.setAppAgeType(yuLNPInsuredDB.getAppAgeType());
/*  997 */             rrPolElementSchema.setAppAge(age);
/*      */           }
/*      */         }
/*      */       }
/* 1001 */       return rrPolElementSchema;
/*      */     }
/* 1003 */     return null;
/*      */   }
/*      */ 
/*      */   public String saveInvestData(VData investData)
/*      */   {
/* 1010 */     String[][] appendPrem = (String[][])investData.get(0);
/*      */ 
/* 1012 */     String[][] someGet = (String[][])investData.get(1);
/*      */ 
/* 1014 */     String[][] changeAmnt = (String[][])investData.get(2);
/*      */ 
/* 1020 */     String originalId = (String)investData.get(3);
/*      */ 
/* 1022 */     LNPInvestRiskDataSet inLNPInvestRiskDataSet = new LNPInvestRiskDataSet();
/*      */ 
/* 1025 */     String newId = PubFun1.CreateMaxNo("InSN", 10);
/*      */ 
/* 1028 */     if ((appendPrem != null) && (appendPrem.length > 0)) {
/* 1029 */       for (int i = 0; i < appendPrem.length; i++) {
/* 1030 */         LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
/* 1031 */         String investDataId = PubFun1.CreateMaxNo("InID", 20);
/* 1032 */         inLNPInvestRiskDataSchema.setDataid(investDataId);
/* 1033 */         inLNPInvestRiskDataSchema.setSignno(newId);
/* 1034 */         inLNPInvestRiskDataSchema.setType("0");
/* 1035 */         inLNPInvestRiskDataSchema.setSerialno(i + 1);
/* 1036 */         inLNPInvestRiskDataSchema.setAge(appendPrem[i][0]);
/* 1037 */         inLNPInvestRiskDataSchema.setDegree(appendPrem[i][1]);
/* 1038 */         inLNPInvestRiskDataSchema.setValue(appendPrem[i][2]);
/* 1039 */         inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
/*      */       }
/*      */     }
/*      */ 
/* 1043 */     if ((someGet != null) && (someGet.length > 0)) {
/* 1044 */       for (int i = 0; i < someGet.length; i++) {
/* 1045 */         LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
/* 1046 */         String investDataId = PubFun1.CreateMaxNo("InID", 20);
/* 1047 */         inLNPInvestRiskDataSchema.setDataid(investDataId);
/* 1048 */         inLNPInvestRiskDataSchema.setSignno(newId);
/* 1049 */         inLNPInvestRiskDataSchema.setType("1");
/* 1050 */         inLNPInvestRiskDataSchema.setSerialno(i + 1);
/* 1051 */         inLNPInvestRiskDataSchema.setAge(someGet[i][0]);
/* 1052 */         inLNPInvestRiskDataSchema.setDegree(someGet[i][1]);
/* 1053 */         inLNPInvestRiskDataSchema.setValue(someGet[i][2]);
/* 1054 */         inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
/*      */       }
/*      */     }
/*      */ 
/* 1058 */     if ((changeAmnt != null) && (changeAmnt.length > 0)) {
/* 1059 */       for (int i = 0; i < changeAmnt.length; i++) {
/* 1060 */         LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
/* 1061 */         String investDataId = PubFun1.CreateMaxNo("InID", 20);
/* 1062 */         inLNPInvestRiskDataSchema.setDataid(investDataId);
/* 1063 */         inLNPInvestRiskDataSchema.setSignno(newId);
/* 1064 */         inLNPInvestRiskDataSchema.setType("2");
/* 1065 */         inLNPInvestRiskDataSchema.setSerialno(i + 1);
/* 1066 */         inLNPInvestRiskDataSchema.setAge(changeAmnt[i][0]);
/* 1067 */         inLNPInvestRiskDataSchema.setDegree(changeAmnt[i][1]);
/* 1068 */         inLNPInvestRiskDataSchema.setValue(changeAmnt[i][2]);
/* 1069 */         inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1091 */     LNPInvestRiskDataDBSet reLNPInvestRiskDataDBSet = new LNPInvestRiskDataDBSet();
/* 1092 */     reLNPInvestRiskDataDBSet.set(inLNPInvestRiskDataSet);
/* 1093 */     if (!reLNPInvestRiskDataDBSet.insert())
/*      */     {
/* 1095 */       newId = "";
/*      */     }
/* 1099 */     else if ((originalId != null) && (newId.length() > 0)) {
/* 1100 */       String sql = "delete from LNPInvestRiskData where signno='" + 
/* 1101 */         originalId + "'";
/* 1102 */       ExeSQL reExeSQL = new ExeSQL();
/* 1103 */       reExeSQL.execUpdateSQL(sql);
/*      */     }
/*      */ 
/* 1107 */     return newId;
/*      */   }
/*      */ 
/*      */   public VData getInvestData(String PolNo) {
/* 1111 */     String signNo = "";
/*      */ 
/* 1113 */     String[][] appendData = null;
/*      */ 
/* 1115 */     String[][] someGetData = null;
/*      */ 
/* 1117 */     String[][] changeAmntData = null;
/*      */ 
/* 1120 */     VData resultVData = new VData();
/*      */ 
/* 1123 */     LNPPolDB ewLNPPolDB = new LNPPolDB();
/* 1124 */     ewLNPPolDB.setPolNo(PolNo);
/* 1125 */     if (ewLNPPolDB.getInfo()) {
/* 1126 */       signNo = ewLNPPolDB.getStandbyFlag3();
/*      */     }
/*      */ 
/* 1130 */     DecimalFormat wannengformat = new DecimalFormat("#,##0");
/*      */ 
/* 1134 */     String sql = "select * from LNPInvestRiskData where signno='" + signNo + "'" + 
/* 1135 */       " and Type='0' order by SerialNo";
/* 1136 */     LNPInvestRiskDataDB reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
/* 1137 */     LNPInvestRiskDataSet reLNPInvestRiskDataSet = reLNPInvestRiskDataDB.executeQuery(sql);
/* 1138 */     if ((reLNPInvestRiskDataSet != null) && (reLNPInvestRiskDataSet.size() > 0)) {
/* 1139 */       appendData = new String[reLNPInvestRiskDataSet.size()][3];
/*      */ 
/* 1141 */       for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++) {
/* 1142 */         LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
/* 1143 */         appendData[(i - 1)][0] = tempLNPInvestRiskDataSchema.getAge();
/* 1144 */         appendData[(i - 1)][1] = tempLNPInvestRiskDataSchema.getDegree();
/* 1145 */         appendData[(i - 1)][2] = wannengformat.format(tempLNPInvestRiskDataSchema.getValue());
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1150 */     sql = "select * from LNPInvestRiskData where signno='" + signNo + "'" + 
/* 1151 */       " and Type='1' order by SerialNo";
/* 1152 */     reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
/* 1153 */     reLNPInvestRiskDataSet = reLNPInvestRiskDataDB.executeQuery(sql);
/* 1154 */     if ((reLNPInvestRiskDataSet != null) && (reLNPInvestRiskDataSet.size() > 0)) {
/* 1155 */       someGetData = new String[reLNPInvestRiskDataSet.size()][3];
/*      */ 
/* 1157 */       for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++) {
/* 1158 */         LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
/* 1159 */         someGetData[(i - 1)][0] = tempLNPInvestRiskDataSchema.getAge();
/* 1160 */         someGetData[(i - 1)][1] = tempLNPInvestRiskDataSchema.getDegree();
/* 1161 */         someGetData[(i - 1)][2] = wannengformat.format(tempLNPInvestRiskDataSchema.getValue());
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1166 */     sql = "select * from LNPInvestRiskData where signno='" + signNo + "'" + 
/* 1167 */       " and Type='2' order by SerialNo";
/* 1168 */     reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
/* 1169 */     reLNPInvestRiskDataSet = reLNPInvestRiskDataDB.executeQuery(sql);
/* 1170 */     if ((reLNPInvestRiskDataSet != null) && (reLNPInvestRiskDataSet.size() > 0)) {
/* 1171 */       changeAmntData = new String[reLNPInvestRiskDataSet.size()][3];
/*      */ 
/* 1173 */       for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++) {
/* 1174 */         LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
/* 1175 */         changeAmntData[(i - 1)][0] = tempLNPInvestRiskDataSchema.getAge();
/* 1176 */         changeAmntData[(i - 1)][1] = tempLNPInvestRiskDataSchema.getDegree();
/* 1177 */         changeAmntData[(i - 1)][2] = wannengformat.format(tempLNPInvestRiskDataSchema.getValue());
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1184 */     resultVData.add(appendData);
/* 1185 */     resultVData.add(someGetData);
/* 1186 */     resultVData.add(changeAmntData);
/* 1187 */     return resultVData;
/*      */   }
/*      */ 
/*      */   public String saveInvestData1(VData investData)
/*      */   {
/* 1194 */     String[][] appendPrem = (String[][])investData.get(0);
/*      */ 
/* 1196 */     String[][] someGet = (String[][])investData.get(1);
/*      */ 
/* 1198 */     String[][] AccountNumber = (String[][])investData.get(2);
/*      */ 
/* 1200 */     String originalId = (String)investData.get(3);
/* 1201 */     LNPInvestRiskDataSet inLNPInvestRiskDataSet = new LNPInvestRiskDataSet();
/*      */ 
/* 1204 */     String newId = PubFun1.CreateMaxNo("InSN", 10);
/*      */ 
/* 1206 */     if ((appendPrem != null) && (appendPrem.length > 0)) {
/* 1207 */       for (int i = 0; i < appendPrem.length; i++) {
/* 1208 */         LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
/* 1209 */         String investDataId = PubFun1.CreateMaxNo("InID", 20);
/* 1210 */         inLNPInvestRiskDataSchema.setDataid(investDataId);
/* 1211 */         inLNPInvestRiskDataSchema.setSignno(newId);
/* 1212 */         inLNPInvestRiskDataSchema.setType("0");
/* 1213 */         inLNPInvestRiskDataSchema.setSerialno(i + 1);
/* 1214 */         inLNPInvestRiskDataSchema.setAge(appendPrem[i][0]);
/* 1215 */         inLNPInvestRiskDataSchema.setDegree(appendPrem[i][1]);
/* 1216 */         inLNPInvestRiskDataSchema.setValue(appendPrem[i][2]);
/* 1217 */         inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
/*      */       }
/*      */     }
/* 1220 */     if ((someGet != null) && (someGet.length > 0)) {
/* 1221 */       for (int i = 0; i < someGet.length; i++) {
/* 1222 */         LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
/* 1223 */         String investDataId = PubFun1.CreateMaxNo("InID", 20);
/* 1224 */         inLNPInvestRiskDataSchema.setDataid(investDataId);
/* 1225 */         inLNPInvestRiskDataSchema.setSignno(newId);
/* 1226 */         inLNPInvestRiskDataSchema.setType("1");
/* 1227 */         inLNPInvestRiskDataSchema.setSerialno(i + 1);
/* 1228 */         inLNPInvestRiskDataSchema.setAge(someGet[i][0]);
/* 1229 */         inLNPInvestRiskDataSchema.setDegree(someGet[i][1]);
/* 1230 */         inLNPInvestRiskDataSchema.setValue(someGet[i][2]);
/* 1231 */         inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
/*      */       }
/*      */     }
/* 1234 */     if ((AccountNumber != null) && (AccountNumber.length > 0)) {
/* 1235 */       for (int i = 0; i < AccountNumber.length; i++) {
/* 1236 */         LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
/* 1237 */         String investDataId = PubFun1.CreateMaxNo("InID", 20);
/* 1238 */         inLNPInvestRiskDataSchema.setDataid(investDataId);
/* 1239 */         inLNPInvestRiskDataSchema.setSignno(newId);
/* 1240 */         inLNPInvestRiskDataSchema.setType("5");
/* 1241 */         inLNPInvestRiskDataSchema.setSerialno(i + 1);
/* 1242 */         inLNPInvestRiskDataSchema.setAge(AccountNumber[i][0]);
/* 1243 */         inLNPInvestRiskDataSchema.setProtagonist(AccountNumber[i][1]);
/* 1244 */         inLNPInvestRiskDataSchema.setExponent(AccountNumber[i][2]);
/* 1245 */         inLNPInvestRiskDataSchema.setBanlance(AccountNumber[i][3]);
/*      */ 
/* 1247 */         inLNPInvestRiskDataSchema.setPrevent(AccountNumber[i][4]);
/* 1248 */         inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
/*      */       }
/*      */     }
/*      */ 
/* 1252 */     LNPInvestRiskDataDBSet reLNPInvestRiskDataDBSet = new LNPInvestRiskDataDBSet();
/* 1253 */     reLNPInvestRiskDataDBSet.set(inLNPInvestRiskDataSet);
/* 1254 */     if (!reLNPInvestRiskDataDBSet.insert())
/*      */     {
/* 1256 */       newId = "";
/*      */     }
/* 1260 */     else if ((originalId != null) && (newId.length() > 0)) {
/* 1261 */       String sql = "delete from LNPInvestRiskData where signno='" + 
/* 1262 */         originalId + "'";
/* 1263 */       ExeSQL reExeSQL = new ExeSQL();
/* 1264 */       reExeSQL.execUpdateSQL(sql);
/*      */     }
/*      */ 
/* 1267 */     return newId;
/*      */   }
/*      */ 
/*      */   public VData getInvestData1(String PolNo)
/*      */   {
/* 1272 */     String signNo = "";
/*      */ 
/* 1274 */     String[][] appendData = null;
/*      */ 
/* 1276 */     String[][] someGetData = null;
/*      */ 
/* 1278 */     String[][] changeAmntData = null;
/*      */ 
/* 1280 */     String[][] AccountData = null;
/*      */ 
/* 1283 */     VData resultVData = new VData();
/*      */ 
/* 1285 */     LNPPolDB ewLNPPolDB = new LNPPolDB();
/* 1286 */     ewLNPPolDB.setPolNo(PolNo);
/* 1287 */     if (ewLNPPolDB.getInfo()) {
/* 1288 */       signNo = ewLNPPolDB.getStandbyFlag3();
/*      */     }
/*      */ 
/* 1292 */     DecimalFormat wannengformat = new DecimalFormat("#,##0");
/*      */ 
/* 1296 */     String sql = "select * from LNPInvestRiskData where signno='" + signNo + 
/* 1297 */       "'" + " and Type='0' order by SerialNo";
/* 1298 */     LNPInvestRiskDataDB reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
/* 1299 */     LNPInvestRiskDataSet reLNPInvestRiskDataSet = reLNPInvestRiskDataDB
/* 1300 */       .executeQuery(sql);
/* 1301 */     if ((reLNPInvestRiskDataSet != null) && (reLNPInvestRiskDataSet.size() > 0)) {
/* 1302 */       appendData = new String[reLNPInvestRiskDataSet.size()][3];
/*      */ 
/* 1304 */       for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++) {
/* 1305 */         LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
/* 1306 */         appendData[(i - 1)][0] = tempLNPInvestRiskDataSchema.getAge();
/* 1307 */         appendData[(i - 1)][1] = tempLNPInvestRiskDataSchema.getDegree();
/*      */ 
/* 1309 */         appendData[(i - 1)][2] = wannengformat
/* 1310 */           .format(tempLNPInvestRiskDataSchema.getValue());
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1316 */     sql = "select * from LNPInvestRiskData where signno='" + signNo + "'" + 
/* 1317 */       " and Type='1' order by SerialNo";
/* 1318 */     reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
/* 1319 */     reLNPInvestRiskDataSet = reLNPInvestRiskDataDB.executeQuery(sql);
/* 1320 */     if ((reLNPInvestRiskDataSet != null) && (reLNPInvestRiskDataSet.size() > 0)) {
/* 1321 */       someGetData = new String[reLNPInvestRiskDataSet.size()][3];
/*      */ 
/* 1323 */       for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++) {
/* 1324 */         LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
/* 1325 */         someGetData[(i - 1)][0] = tempLNPInvestRiskDataSchema.getAge();
/* 1326 */         someGetData[(i - 1)][1] = tempLNPInvestRiskDataSchema.getDegree();
/*      */ 
/* 1328 */         someGetData[(i - 1)][2] = wannengformat
/* 1329 */           .format(tempLNPInvestRiskDataSchema.getValue());
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1334 */     sql = "select * from LNPInvestRiskData where signno='" + signNo + "'" + 
/* 1335 */       " and Type='5' order by SerialNo";
/* 1336 */     reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
/* 1337 */     reLNPInvestRiskDataSet = reLNPInvestRiskDataDB.executeQuery(sql);
/* 1338 */     if ((reLNPInvestRiskDataSet != null) && (reLNPInvestRiskDataSet.size() > 0)) {
/* 1339 */       AccountData = new String[reLNPInvestRiskDataSet.size()][6];
/*      */ 
/* 1341 */       for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++) {
/* 1342 */         LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
/* 1343 */         AccountData[(i - 1)][0] = tempLNPInvestRiskDataSchema.getAge();
/* 1344 */         AccountData[(i - 1)][1] = tempLNPInvestRiskDataSchema
/* 1345 */           .getProtagonist();
/*      */ 
/* 1347 */         AccountData[(i - 1)][2] = wannengformat
/* 1348 */           .format(tempLNPInvestRiskDataSchema.getExponent());
/*      */ 
/* 1350 */         AccountData[(i - 1)][3] = wannengformat
/* 1351 */           .format(tempLNPInvestRiskDataSchema.getBanlance());
/*      */ 
/* 1353 */         AccountData[(i - 1)][4] = wannengformat
/* 1354 */           .format(tempLNPInvestRiskDataSchema.getPrevent());
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1361 */     resultVData.add(appendData);
/* 1362 */     resultVData.add(someGetData);
/* 1363 */     resultVData.add(AccountData);
/* 1364 */     return resultVData;
/*      */   }
/*      */ 
/*      */   public HashMap getLNPInvestRiskData(String polNo) {
/* 1368 */     HashMap result = new HashMap();
/*      */ 
/* 1370 */     LNPPolDB ewLNPPolDB = new LNPPolDB();
/* 1371 */     ewLNPPolDB.setPolNo(polNo);
/* 1372 */     if (ewLNPPolDB.getInfo())
/*      */     {
/* 1374 */       DecimalFormat wannengformat = new DecimalFormat("#,##0");
/* 1375 */       result.put("Amnt", wannengformat.format(ewLNPPolDB.getAmnt()));
/* 1376 */       result.put("Prem", wannengformat.format(ewLNPPolDB.getStandPrem()));
/*      */ 
/* 1378 */       result.put("PayEndYear", wannengformat.format(ewLNPPolDB
/* 1379 */         .getPayEndYear()));
/*      */ 
/* 1382 */       result.put("StandbyFlag2", ewLNPPolDB.getStandbyFlag2());
/*      */ 
/* 1384 */       result.put("StandbyFlag3", ewLNPPolDB.getStandbyFlag3());
/* 1385 */       result.put("StandbyFlag1", ewLNPPolDB.getStandbyFlag1());
/*      */ 
/* 1387 */       LNPContDB rLNPContDB = new LNPContDB();
/* 1388 */       rLNPContDB.setContNo(ewLNPPolDB.getContNo());
/* 1389 */       rLNPContDB.getInfo();
/*      */ 
/* 1393 */       LNPInsuredDB rLNPInsuredDB = new LNPInsuredDB();
/* 1394 */       rLNPInsuredDB.setContNo(ewLNPPolDB.getContNo());
/* 1395 */       rLNPInsuredDB.setInsuredId(ewLNPPolDB.getInsuredId());
/* 1396 */       rLNPInsuredDB.getInfo();
/* 1397 */       String cvalidate = rLNPContDB.getCValiDate();
/*      */ 
/* 1401 */       int appage = rLNPInsuredDB.getAppAge();
/* 1402 */       String appagetype = rLNPInsuredDB.getAppAgeType();
/* 1403 */       result.put("AppAge", appage);
/* 1404 */       result.put("AppAgeType", appagetype);
/*      */ 
/* 1408 */       HashMap agentHashMap = new HashMap();
/* 1409 */       PubFun tPubFun = new PubFun();
/* 1410 */       agentHashMap = tPubFun.getLaagent(ewLNPPolDB.getOperator());
/*      */ 
/* 1412 */       String userManageCom = (String)agentHashMap.get("ManageCom");
/* 1413 */       LNPComGrpToComDB reLNPComGrpToComDB = new LNPComGrpToComDB();
/* 1414 */       reLNPComGrpToComDB.setComGrpCode("100000");
/* 1415 */       LNPComGrpToComSet reLNPComGrpToComSet = reLNPComGrpToComDB.query();
/*      */ 
/* 1418 */       String flag = "0";
/* 1419 */       if ((reLNPComGrpToComSet != null) && (reLNPComGrpToComSet.size() > 0)) {
/* 1420 */         LNPComGrpToComSchema reLNPComGrpToComSchema = null;
/* 1421 */         for (int i = 1; i <= reLNPComGrpToComSet.size(); i++) {
/* 1422 */           reLNPComGrpToComSchema = reLNPComGrpToComSet.get(i);
/* 1423 */           String comcode = reLNPComGrpToComSchema.getComCode();
/* 1424 */           if (userManageCom.indexOf(comcode) == 0) {
/* 1425 */             flag = "1";
/* 1426 */             break;
/*      */           }
/*      */         }
/*      */       }
/* 1430 */       result.put("SpecialZoneFlag", flag);
/*      */ 
/* 1432 */       String str = ewLNPPolDB.getRiskCode();
/* 1433 */       if ((str != null) && (str.trim().equals("UL\uFFFD\uFFFD"))) {
/* 1434 */         String sex = rLNPInsuredDB.getSex();
/* 1435 */         String sql = "select urate from ULIIAMNT where Age=" + appage + "and Sex=" + sex;
/* 1436 */         ExeSQL exeSQL = new ExeSQL();
/* 1437 */         SSRS Rate = new SSRS();
/* 1438 */         Rate = exeSQL.execSQL(sql);
/* 1439 */         String amntRate = Rate.GetText(1, 1);
/* 1440 */         result.put("amntRate", amntRate);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1448 */     return result;
/*      */   }
/*      */ 
/*      */   public HashMap getInvestAddInitData(String insuredId, String contNo, IGlobalInput eGlobalInput) {
/* 1452 */     HashMap result = new HashMap();
/*      */ 
/* 1454 */     LNPContDB ewLNPContDB = new LNPContDB();
/* 1455 */     ewLNPContDB.setContNo(contNo);
/* 1456 */     ewLNPContDB.getInfo();
/*      */ 
/* 1458 */     LNPInsuredDB rLNPInsuredDB = new LNPInsuredDB();
/* 1459 */     ewLNPContDB.setContNo(contNo);
/* 1460 */     ewLNPContDB.setInsuredId(insuredId);
/* 1461 */     ewLNPContDB.getInfo();
/* 1462 */     String cvalidate = ewLNPContDB.getCValiDate();
/*      */ 
/* 1465 */     int appage = rLNPInsuredDB.getAppAge();
/* 1466 */     result.put("AppAge", appage);
/*      */ 
/* 1468 */     if ((this.RISKCODE != null) && (!this.RISKCODE.equals("")) && (this.RISKCODE.trim().equals("UL\uFFFD\uFFFD"))) {
/* 1469 */       String sex = rLNPInsuredDB.getSex();
/* 1470 */       String sql = "select urate from ULIIAMNT where Age=" + appage + "and Sex=" + sex;
/* 1471 */       ExeSQL exeSQL = new ExeSQL();
/* 1472 */       SSRS Rate = new SSRS();
/* 1473 */       Rate = exeSQL.execSQL(sql);
/* 1474 */       String amntRate = Rate.GetText(1, 1);
/* 1475 */       result.put("amntRate", amntRate);
/*      */     }
/*      */ 
/* 1480 */     String userManageCom = eGlobalInput.ComCode;
/*      */ 
/* 1482 */     LNPComGrpToComDB reLNPComGrpToComDB = new LNPComGrpToComDB();
/* 1483 */     reLNPComGrpToComDB.setComGrpCode("100000");
/* 1484 */     LNPComGrpToComSet reLNPComGrpToComSet = reLNPComGrpToComDB.query();
/*      */ 
/* 1488 */     String flag = "0";
/* 1489 */     if ((reLNPComGrpToComSet != null) && (reLNPComGrpToComSet.size() > 0)) {
/* 1490 */       LNPComGrpToComSchema reLNPComGrpToComSchema = null;
/* 1491 */       for (int i = 1; i <= reLNPComGrpToComSet.size(); i++) {
/* 1492 */         reLNPComGrpToComSchema = reLNPComGrpToComSet.get(i);
/* 1493 */         String comcode = reLNPComGrpToComSchema.getComCode();
/* 1494 */         if (userManageCom.indexOf(comcode) == 0) {
/* 1495 */           flag = "1";
/* 1496 */           break;
/*      */         }
/*      */       }
/*      */     }
/* 1500 */     result.put("SpecialZoneFlag", flag);
/* 1501 */     return result;
/*      */   }
/*      */ 
/*      */   private PolElementSchema setAppntAndInsuredInfo(PolElementSchema trPolElementSchema)
/*      */   {
/* 1507 */     LNPAppntDB reLNPAppntDB = new LNPAppntDB();
/* 1508 */     reLNPAppntDB.setContNo(trPolElementSchema.getContNo());
/* 1509 */     if (reLNPAppntDB.getInfo()) {
/* 1510 */       trPolElementSchema.setAppntAge(reLNPAppntDB.getAppntAge());
/* 1511 */       trPolElementSchema.setAppntAgeType(reLNPAppntDB.getAppntAgeType());
/* 1512 */       trPolElementSchema.setAppntSex(reLNPAppntDB.getAppntSex());
/* 1513 */       trPolElementSchema.setAppntId(reLNPAppntDB.getAppntId());
/* 1514 */       trPolElementSchema.setAppntOccupationCode(reLNPAppntDB
/* 1515 */         .getOccupationCode());
/*      */     }
/*      */ 
/* 1518 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/* 1519 */     reLNPInsuredDB.setContNo(trPolElementSchema.getContNo());
/* 1520 */     reLNPInsuredDB.setInsuredId(trPolElementSchema.getInsuredId());
/* 1521 */     if (reLNPInsuredDB.getInfo()) {
/* 1522 */       trPolElementSchema.setAppAge(reLNPInsuredDB.getAppAge());
/* 1523 */       trPolElementSchema.setAppAgeType(reLNPInsuredDB.getAppAgeType());
/* 1524 */       trPolElementSchema.setSex(reLNPInsuredDB.getSex());
/* 1525 */       trPolElementSchema.setOccupationCode(reLNPInsuredDB
/* 1526 */         .getOccupationCode());
/*      */     }
/* 1528 */     return trPolElementSchema;
/*      */   }
/*      */ 
/*      */   private String keepPayIntvUnique(String value)
/*      */   {
/* 1533 */     String[] s = value.split("&");
/* 1534 */     if ((s != null) && (s.length == 2)) {
/* 1535 */       value = value.replaceFirst(s[0] + "&", "");
/* 1536 */       if (value.indexOf("\uFFFD") > 0) {
/* 1537 */         this.hidePayEndYear = true;
/*      */       }
/*      */     }
/* 1540 */     return value;
/*      */   }
/*      */ 
/*      */   public void Setriskcode(String riskcode) {
/* 1544 */     this.RISKCODE = riskcode;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.RiskElementImpl
 * JD-Core Version:    0.6.0
 */