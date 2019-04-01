/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPCalModeDB;
/*     */ import com.sinosoft.banklns.lis.schema.LNPCalModeSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCalModeSet;
/*     */ import java.io.PrintStream;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class OracleTOMySqlFilter
/*     */ {
/*  11 */   private String[][] oraTable = { { "dual", "survrate" }, 
/*  12 */     { "lcpol", "lspol" }, 
/*  13 */     { "lcinsured", "lsinsured" }, 
/*  14 */     { "lccustomerimpartparams", 
/*  15 */     "lscustomerimpartparams" }, { "lcduty", 
/*  16 */     "lsduty" }, { "lccustomerimpartparams", 
/*  17 */     "lscustomerimpartparams" }, { "lccontstate", "lscontstate" }, 
/*  19 */     { "lccont", "lscont" }, { "lcget", "lsget" } };
/*     */   private Pattern tablePattern;
/*     */   private Pattern interSPattern;
/*     */   private Pattern ptIS;
/*     */   private Pattern ptNull;
/*     */   private Pattern dealEPattern;
/*     */   private Pattern ptDE;
/*     */   private Pattern ptStr;
/*     */ 
/*     */   public OracleTOMySqlFilter()
/*     */   {
/*  38 */     String regStr = "(^|\\W)(";
/*  39 */     for (int count = 0; count < this.oraTable.length; count++) {
/*  40 */       if (count == this.oraTable.length - 1)
/*  41 */         regStr = regStr + this.oraTable[count][0];
/*     */       else
/*  43 */         regStr = regStr + this.oraTable[count][0] + "|";
/*     */     }
/*  45 */     regStr = regStr + ")($|(\\W))";
/*     */ 
/*  47 */     this.tablePattern = Pattern.compile(regStr, 2);
/*  48 */     this.interSPattern = Pattern.compile("\\sintersect\\s", 2);
/*     */ 
/*  50 */     this.ptIS = Pattern.compile("select.+?from.+?where.+?\\sintersect\\sselect.+?(?=\\bfrom)", 2);
/*  51 */     this.ptNull = Pattern.compile("\\s+?is\\s+?(not\\s+?)?null", 2);
/*  52 */     this.dealEPattern = Pattern.compile("exists(\\b)?\\((\\(.+?\\))+\\)", 2);
/*  53 */     this.ptDE = Pattern.compile("\\(|\\)", 2);
/*     */     try {
/*  55 */       jbInit();
/*     */     } catch (Exception ex) {
/*  57 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String filter(String sql)
/*     */   {
/*  64 */     sql = sql.toLowerCase();
/*  65 */     sql = "  " + sql + "  ";
/*     */ 
/*  68 */     sql = conversionTableSql(sql);
/*  69 */     sql = changeInterSect(sql);
/*  70 */     sql = dealExists(sql);
/*  71 */     sql = dealSpecial(sql);
/*     */ 
/*  73 */     return sql.trim();
/*     */   }
/*     */ 
/*     */   private String conversionTableSql(String sql)
/*     */   {
/*  78 */     Matcher matcherTable = this.tablePattern.matcher(sql);
/*  79 */     StringBuffer tempSql = new StringBuffer();
/*     */ 
/*  81 */     int bakEnd = 0;
/*     */ 
/*  84 */     while (matcherTable.find()) {
/*  85 */       String temp = matcherTable.group();
/*  86 */       String tempT = "";
/*  87 */       tempSql.append(sql.substring(bakEnd, matcherTable.start()));
/*     */ 
/*  89 */       tempT = temp.substring(1, temp.length() - 1);
/*     */ 
/*  92 */       tempSql.append(temp.replaceAll(tempT, replaceTable(tempT)));
/*  93 */       bakEnd = matcherTable.end();
/*     */     }
/*  95 */     tempSql.append(sql.substring(bakEnd));
/*     */ 
/*  97 */     return tempSql.toString();
/*     */   }
/*     */ 
/*     */   private String replaceTable(String name)
/*     */   {
/* 102 */     for (int count = 0; count < this.oraTable.length; count++) {
/* 103 */       if (name.equals(this.oraTable[count][0]))
/* 104 */         return this.oraTable[count][1];
/*     */     }
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */   private String changeInterSect(String sql)
/*     */   {
/* 112 */     sql = sql.trim();
/* 113 */     StringBuffer sbSql = new StringBuffer();
/*     */ 
/* 115 */     int bakEnd = 0;
/*     */ 
/* 118 */     Matcher mt = this.interSPattern.matcher(sql);
/*     */ 
/* 120 */     if (!mt.find()) return sql;
/*     */ 
/* 122 */     Matcher mtIS = this.ptIS.matcher(sql);
/* 123 */     if (mtIS.find()) {
/* 124 */       sbSql.append(sql.substring(bakEnd, mtIS.start()));
/*     */ 
/* 127 */       String tempSql = mtIS.group().trim();
/* 128 */       String temp = tempSql.substring(tempSql.lastIndexOf(" ") + 1);
/*     */ 
/* 130 */       String tempStart = tempSql.substring(0, mt.start());
/* 131 */       int SStart = 0;
/* 132 */       int SEnd = 0;
/* 133 */       String tempEnd = tempSql.substring(mt.end());
/* 134 */       Matcher mtS = Pattern.compile("select").matcher(tempStart);
/*     */ 
/* 136 */       while (mtS.find()) {
/* 137 */         SStart = mtS.start();
/* 138 */         SEnd = mtS.end();
/*     */       }
/* 140 */       tempStart = tempStart.substring(0, SStart) + "select Distinct" + tempStart.substring(SEnd);
/* 141 */       sbSql.append(tempStart + " And " + temp + " In( " + tempEnd + " ");
/* 142 */       bakEnd = mtIS.end();
/*     */     }
/*     */ 
/* 146 */     Matcher mtNull = this.ptNull.matcher(sql.substring(bakEnd));
/* 147 */     String sqlEnd = "";
/* 148 */     if (mtNull.find()) {
/* 149 */       sqlEnd = mtNull.replaceAll(") " + mtNull.group());
/*     */     }
/* 151 */     sbSql.append(sqlEnd);
/* 152 */     return sbSql.toString();
/*     */   }
/*     */ 
/*     */   private String dealExists(String sql)
/*     */   {
/* 157 */     Matcher deMatcher = this.dealEPattern.matcher(sql);
/* 158 */     if (!deMatcher.find()) return sql;
/*     */ 
/* 160 */     StringBuffer sbDE = new StringBuffer();
/* 161 */     sbDE.append(sql.substring(0, deMatcher.start()) + " exists(");
/*     */ 
/* 163 */     String tempSql = deMatcher.group().trim();
/* 164 */     tempSql = tempSql.substring(7, tempSql.length() - 1);
/* 165 */     Matcher mhDE = this.ptDE.matcher(tempSql);
/* 166 */     tempSql = mhDE.replaceAll("");
/*     */ 
/* 168 */     sbDE.append(tempSql + ")" + sql.substring(deMatcher.end()));
/* 169 */     return sbDE.toString();
/*     */   }
/*     */ 
/*     */   private String dealSpecial(String sql)
/*     */   {
/* 176 */     String regex = "polapplydate(\\s)*-(\\s)*insuredbirthday";
/* 177 */     Pattern ptSpecial = Pattern.compile(regex, 2);
/* 178 */     Matcher ptMatcher = ptSpecial.matcher(sql);
/* 179 */     if (ptMatcher.find()) {
/* 180 */       sql = ptMatcher.replaceFirst(
/* 181 */         "to_days('?CValiDate?')-to_days('?insuredbirthday?') ");
/*     */     }
/*     */ 
/* 199 */     regex = "lspol\\s*where\\s*polno\\s*=\\s*'\\?polno\\?'";
/* 200 */     Pattern ptLSpol = Pattern.compile(regex);
/* 201 */     Matcher mhLSpol = ptLSpol.matcher(sql);
/* 202 */     regex = "lspol\\s*where";
/* 203 */     Pattern ptLSpoland = Pattern.compile(regex, 2);
/* 204 */     Matcher mhLSpoland = ptLSpoland.matcher(sql);
/* 205 */     if ((!mhLSpol.find()) && (mhLSpoland.find())) {
/* 206 */       sql = mhLSpoland.replaceAll("lspol where contno='?contno?' and ");
/*     */     }
/*     */ 
/* 210 */     regex = "(([_0-9a-zA-Z]+?\\.)|\\s+?)state\\s*((=\\s*'.+?')|(is\\s+?(not\\s+?)?null))";
/* 211 */     Pattern ptState = Pattern.compile(regex, 2);
/* 212 */     Matcher mhState = ptState.matcher(sql);
/* 213 */     if (mhState.find()) {
/* 214 */       sql = mhState.replaceAll(" 1=1 ");
/*     */     }
/*     */ 
/* 220 */     Pattern ptLsinsured = Pattern.compile("\\s+?lsinsured\\s+?where\\s+?", 2);
/* 221 */     Matcher mhLsinsured = ptLsinsured.matcher(sql);
/* 222 */     if (mhLsinsured.find()) {
/* 223 */       sql = mhLsinsured.replaceAll(" lsinsured where contno='?contno?' and ");
/*     */     }
/*     */ 
/* 226 */     return sql;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 231 */     OracleTOMySqlFilter otsf = new OracleTOMySqlFilter();
/* 232 */     LNPCalModeDB rLNPCalmodeDB = new LNPCalModeDB();
/* 233 */     LNPCalModeSet tLNPCalModeSet = rLNPCalmodeDB.executeQuery("select * from lmcalmode");
/* 234 */     if ((tLNPCalModeSet != null) && (tLNPCalModeSet.size() > 0)) {
/* 235 */       LNPCalModeSchema tLNPCalModeSchema = null;
/* 236 */       LNPCalModeDB tempLNPCalModeDB = new LNPCalModeDB();
/* 237 */       for (int i = 1; i <= tLNPCalModeSet.size(); i++) {
/* 238 */         System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7===" + i);
/* 239 */         tLNPCalModeSchema = tLNPCalModeSet.get(i);
/* 240 */         tLNPCalModeSchema.setCalSQL(otsf.filter(tLNPCalModeSchema
/* 241 */           .getCalSQL()));
/* 242 */         tempLNPCalModeDB.setSchema(tLNPCalModeSchema);
/* 243 */         if (tempLNPCalModeDB.update())
/*     */           continue;
/* 245 */         System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7=======:" + tempLNPCalModeDB.mErrors.getFirstError());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jbInit()
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.OracleTOMySqlFilter
 * JD-Core Version:    0.6.0
 */