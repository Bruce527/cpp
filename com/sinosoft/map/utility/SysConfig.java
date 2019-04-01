/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class SysConfig
/*     */ {
/*     */   public static final String ENDOFLINE = "\n";
/*  17 */   public static String TRUEHOST = "http://10.0.22.129:7001/xreport/jsp/";
/*  18 */   public static String FILEPATH = "/export/home/bea/wlserver6.1/config/mydomain/applications/xreport_data/";
/*  19 */   public static String FUNCTIONFILE = "/export/home/bea/wlserver6.1/config/mydomain/applications/xreport_data/conf/function.bsh";
/*     */   public static final String HEADOFXML = "<?xml version=\"1.0\" encoding=\"GB2312\"?>";
/*     */   public static final String SEPARATORONE = "|";
/*     */   public static final String SEPARATORTWO = "^";
/*     */   public static final String SEPARATORTREE = ";";
/*     */   public static final String SEPARATORITEM = "/";
/*     */   public static final String SEPARATORCHECK = "&";
/*     */   public static final String SEPARATORERROR = ";";
/*     */   public static final String DSTABLE = "DSTable";
/*     */   public static final String HEADOFDSTABLE = "<DSTable>";
/*     */   public static final String ENDOFDSTABLE = "</DSTable>";
/*     */   public static final String DSREPORT = "DSReport";
/*     */   public static final String HEADOFDSREPORT = "<DSReport>";
/*     */   public static final String ENDOFDSREPORT = "</DSReport>";
/*     */   public static final String DSREPORTFLAG = "$";
/*     */   public static final String FUNCTION = "Function";
/*     */   public static final String HEADOFFUNCTION = "<Function>";
/*     */   public static final String ENDOFFUNCTION = "</Function>";
/*     */   public static final String FUNCTIONFLAG = "@";
/*     */   public static final String VARIABLE = "Var";
/*     */   public static final String HEADOFVARIABLE = "<Var>";
/*     */   public static final String ENDOFVARIABLE = "</Var>";
/*     */   public static final String VARIABLEFLAG = "&";
/*     */   public static final String REPORTJOINCHAR = "_";
/*  91 */   public static final String FILESEPARATOR = System.getProperty("file.separator");
/*     */   public static final String FUNCREPORT = "report";
/*     */   public static final String FUNCPLUGINS = "plugins";
/*     */   public static final String SESSIONPOOLSIGN = "SESSIONPOOL";
/*     */   public static final String LRSUBJECT = "Subject";
/*     */   public static final String LRSTARTCELL = "StartCell";
/*     */   public static final String LRCOLUMNVIEWS = "ColumnViews";
/*     */   public static final String LRCOLUMNREPLACE = "ColumnReplace";
/*     */   public static final String LRSUMCOLUMNS = "SumColumns";
/*     */   public static final String LRSUMDEPEND = "SumDepend";
/*     */   public static final String LRSTRWHERE = "StrWhere";
/*     */   public static final String LRSTRAPPEND = "StrAppend";
/*     */   public static final boolean NEEDCONVERT = false;
/*     */   public static final String KEYSEPARATOR = ".";
/*     */   public static final String SYSTEMDATEPATTERN = "yyyy-MM-dd";
/*     */   public static final String DYNAMICDS = "[?\u6570\u636E\u6E90?]";
/*     */   public static final String DECIMALPATTERN = "0.00";
/*     */ 
/*     */   static
/*     */   {
/* 155 */     if ((System.getProperty("XR.TRUEHOST") != null) && (!"".equals(System.getProperty("XR.TRUEHOST"))))
/*     */     {
/* 157 */       TRUEHOST = System.getProperty("XR.TRUEHOST");
/*     */     }
/*     */ 
/* 160 */     if ((System.getProperty("XR.FILEPATH") != null) && (!"".equals(System.getProperty("XR.FILEPATH"))))
/*     */     {
/* 162 */       FILEPATH = System.getProperty("XR.FILEPATH");
/*     */ 
/* 164 */       FUNCTIONFILE = FILEPATH + "conf/function.bsh";
/*     */     }
/*     */ 
/* 167 */     System.err.println(FUNCTIONFILE);
/*     */   }
/*     */ 
/*     */   public static String getSystemDatePattern()
/*     */   {
/* 144 */     return "yyyy-MM-dd";
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 175 */     SysConfig sysConfig1 = new SysConfig();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.SysConfig
 * JD-Core Version:    0.6.0
 */