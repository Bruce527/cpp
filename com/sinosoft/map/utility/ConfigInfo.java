/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileWriter;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class ConfigInfo
/*     */ {
/*  16 */   private static String ErrorString = "";
/*  17 */   private static String ConfigFilePath = "AppConfig.properties";
/*     */ 
/*     */   public ConfigInfo()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ConfigInfo(String XmlFilePath)
/*     */   {
/*  27 */     ConfigFilePath = XmlFilePath;
/*     */   }
/*     */ 
/*     */   public static String GetConfigPath()
/*     */   {
/*  33 */     return ConfigFilePath;
/*     */   }
/*     */ 
/*     */   public static void SetConfigPath(String newpath)
/*     */   {
/*  39 */     ConfigFilePath = newpath;
/*     */   }
/*     */ 
/*     */   public static String GetErrorString()
/*     */   {
/*  45 */     return ErrorString;
/*     */   }
/*     */ 
/*     */   public static String GetValuebyName(String inpfieldname)
/*     */   {
/*  51 */     String ConfigValue = "";
/*     */     try
/*     */     {
/*  55 */       FileInputStream readconfig = new FileInputStream(ConfigFilePath);
/*  56 */       byte[] tb = new byte[256];
/*  57 */       int len = 0;
/*  58 */       int i = 0;
/*  59 */       String fieldname = "";
/*  60 */       String fieldvalue = "";
/*     */ 
/*  62 */       while ((len = readconfig.read()) != -1)
/*     */       {
/*  64 */         String tempStr = null;
/*     */ 
/*  66 */         if (len == 10)
/*     */         {
/*  68 */           tempStr = new String(tb);
/*  69 */           tempStr = tempStr.trim();
/*  70 */           fieldname = StrTool.decodeStr(tempStr, "=", 1);
/*     */ 
/*  72 */           if (fieldname.equals(inpfieldname))
/*     */           {
/*  74 */             fieldvalue = tempStr.substring(fieldname.length() + 1);
/*  75 */             break;
/*     */           }
/*     */ 
/*  79 */           i = 0;
/*  80 */           tb = new byte[256];
/*     */         }
/*     */         else
/*     */         {
/*  85 */           Integer reallen = new Integer(len);
/*  86 */           tb[i] = reallen.byteValue();
/*  87 */           i++;
/*     */         }
/*     */       }
/*     */ 
/*  91 */       readconfig.close();
/*  92 */       ConfigValue = fieldvalue.trim();
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/*  97 */       ErrorString = "<Conf.class> Parsing config file error:" + 
/*  98 */         exception.toString();
/*  99 */       UserLog.printException(ErrorString);
/*     */     }
/*     */ 
/* 102 */     return ConfigValue;
/*     */   }
/*     */ 
/*     */   public static String GetValuebyArea(String inpfieldname)
/*     */   {
/* 108 */     String ConfigValue = "";
/*     */     try
/*     */     {
/* 112 */       File tFile = new File(ConfigFilePath);
/* 113 */       System.out.println("AppConfig.properties\u7684\u7EDD\u5BF9\u8DEF\u5F84" + tFile.getAbsolutePath());
/* 114 */       FileInputStream readconfig = new FileInputStream(ConfigFilePath);
/*     */ 
/* 116 */       byte[] tb = new byte[256];
/* 117 */       int len = 0;
/* 118 */       int i = 0;
/* 119 */       String fieldname = "";
/* 120 */       String fieldvalue = "";
/*     */ 
/* 122 */       while ((len = readconfig.read()) != -1)
/*     */       {
/* 124 */         String tempStr = null;
/*     */ 
/* 126 */         if (len == 10)
/*     */         {
/* 128 */           tempStr = new String(tb);
/* 129 */           tempStr = tempStr.trim();
/*     */ 
/* 131 */           fieldname = StrTool.decodeStr(tempStr, "=", 1);
/*     */ 
/* 133 */           if ((tempStr.length() == 0) && (fieldname.length() == 0))
/*     */           {
/* 135 */             i = 0;
/* 136 */             tb = new byte[256];
/*     */           }
/*     */           else
/*     */           {
/* 140 */             if (cmpFieldValue(fieldname, inpfieldname))
/*     */             {
/* 142 */               fieldvalue = tempStr.substring(fieldname.length() + 1);
/* 143 */               break;
/*     */             }
/*     */ 
/* 147 */             i = 0;
/* 148 */             tb = new byte[256];
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 153 */           Integer reallen = new Integer(len);
/* 154 */           tb[i] = reallen.byteValue();
/* 155 */           i++;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 160 */       readconfig.close();
/* 161 */       ConfigValue = fieldvalue.trim();
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/* 166 */       ErrorString = "<Conf.class> Parsing config file error:" + 
/* 167 */         exception.toString();
/* 168 */       UserLog.printException(ErrorString);
/*     */     }
/*     */ 
/* 171 */     return ConfigValue;
/*     */   }
/*     */ 
/*     */   public static boolean cmpFieldValue(String srcFieldName, String tagFieldName)
/*     */   {
/* 178 */     String[] tmpStr = new String[5];
/* 179 */     String[] tmpValue = new String[5];
/* 180 */     int strPos = 0;
/* 181 */     int i = 0;
/*     */ 
/* 183 */     if ((tagFieldName.length() == 0) || (srcFieldName.indexOf(".") == -1))
/*     */     {
/* 185 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 190 */       srcFieldName = srcFieldName.trim() + ".";
/* 191 */       tagFieldName = tagFieldName.trim() + ".";
/*     */ 
/* 193 */       tmpStr[0] = StrTool.decodeStr(srcFieldName, ".", 1);
/* 194 */       tmpStr[1] = StrTool.decodeStr(srcFieldName, ".", 2);
/* 195 */       tmpStr[2] = StrTool.decodeStr(srcFieldName, ".", 3);
/* 196 */       tmpStr[3] = StrTool.decodeStr(srcFieldName, ".", 4);
/* 197 */       tmpStr[4] = StrTool.decodeStr(srcFieldName, ".", 5);
/*     */ 
/* 199 */       tmpValue[0] = StrTool.decodeStr(tagFieldName, ".", 1);
/* 200 */       tmpValue[1] = StrTool.decodeStr(tagFieldName, ".", 2);
/* 201 */       tmpValue[2] = StrTool.decodeStr(tagFieldName, ".", 3);
/* 202 */       tmpValue[3] = StrTool.decodeStr(tagFieldName, ".", 4);
/* 203 */       tmpValue[4] = StrTool.decodeStr(tagFieldName, ".", 5);
/*     */ 
/* 205 */       for (i = 0; i < tmpStr.length; i++)
/*     */       {
/* 207 */         if (!cmp2Value(tmpStr[i], tmpValue[i]))
/*     */         {
/* 212 */           return false;
/*     */         }
/*     */       }
/* 215 */       return true;
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/*     */     }
/* 220 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean cmp2Value(String strSource, String strTarget)
/*     */   {
/* 226 */     String tmpStrValue = "";
/* 227 */     String[] tmpStrArray = new String[2];
/* 228 */     int strPos = strSource.indexOf("-");
/*     */ 
/* 230 */     if (strPos == -1)
/*     */     {
/* 235 */       return (strTarget.equals(strSource.substring(1, strSource.length() - 1))) || 
/* 233 */         (strSource.substring(1, strSource.length() - 1).equals("*"));
/*     */     }
/*     */ 
/* 244 */     tmpStrValue = strSource.substring(1, strSource.length() - 1) + "-";
/* 245 */     tmpStrArray[0] = StrTool.decodeStr(tmpStrValue, "-", 1);
/* 246 */     tmpStrArray[1] = StrTool.decodeStr(tmpStrValue, "-", 2);
/*     */ 
/* 248 */     int intCmp = new Integer(ChgData.chgNumericStr(strTarget)).intValue();
/* 249 */     int intAreaS = new Integer(ChgData.chgNumericStr(tmpStrArray[0]))
/* 250 */       .intValue();
/* 251 */     int intAreaE = new Integer(ChgData.chgNumericStr(tmpStrArray[1]))
/* 252 */       .intValue();
/*     */ 
/* 256 */     return (intCmp >= intAreaS) && (intCmp <= intAreaE);
/*     */   }
/*     */ 
/*     */   public static Vector GetIniByIp(String inpip)
/*     */   {
/* 268 */     String fieldvalue = "";
/* 269 */     Vector Strvector = new Vector();
/*     */     try
/*     */     {
/* 272 */       FileInputStream readconfig = new FileInputStream(ConfigFilePath);
/* 273 */       byte[] tb = new byte[256];
/* 274 */       int len = 0;
/* 275 */       int i = 0;
/* 276 */       int intIndex = 0;
/*     */ 
/* 278 */       String fieldname = "";
/*     */ 
/* 280 */       String inpfieldname = "(" + StrTool.decodeStr(inpip, ".", 1) + ")" + 
/* 281 */         "." + "(" + StrTool.decodeStr(inpip, ".", 2) + 
/* 282 */         ")";
/*     */ 
/* 284 */       while ((len = readconfig.read()) != -1)
/*     */       {
/* 286 */         String tempStr = null;
/* 287 */         if (len == 10)
/*     */         {
/* 289 */           tempStr = new String(tb);
/* 290 */           tempStr = tempStr.trim();
/*     */ 
/* 292 */           fieldname = StrTool.decodeStr(tempStr, ".", 1) + "." + 
/* 293 */             StrTool.decodeStr(tempStr, ".", 2);
/*     */ 
/* 295 */           if (fieldname.equals(inpfieldname))
/*     */           {
/* 297 */             fieldvalue = tempStr;
/* 298 */             Strvector.addElement(fieldvalue);
/* 299 */             i = 0;
/* 300 */             tb = new byte[256];
/*     */           }
/*     */           else
/*     */           {
/* 304 */             i = 0;
/* 305 */             tb = new byte[256];
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 310 */           Integer reallen = new Integer(len);
/* 311 */           tb[i] = reallen.byteValue();
/* 312 */           i++;
/*     */         }
/*     */       }
/*     */ 
/* 316 */       readconfig.close();
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/* 320 */       String ErrorString = "<Conf.class> Parsing config file error:" + 
/* 321 */         exception.toString();
/* 322 */       UserLog.printException(ErrorString);
/*     */     }
/*     */ 
/* 325 */     for (int i = 0; i < Strvector.size(); i++)
/*     */     {
/* 327 */       System.out.println((String)Strvector.get(i));
/*     */     }
/*     */ 
/* 330 */     return Strvector;
/*     */   }
/*     */ 
/*     */   public static boolean DeleteByStr(String inputStr)
/*     */   {
/*     */     try
/*     */     {
/* 340 */       File output = new File("AppConfig.properties.tmp");
/* 341 */       output.createNewFile();
/* 342 */       BufferedWriter out = new BufferedWriter(
/* 343 */         new FileWriter(output
/* 343 */         .getPath(), true));
/* 344 */       File input = new File(ConfigFilePath);
/* 345 */       FileInputStream readconfig = new FileInputStream(input);
/* 346 */       byte[] tb = new byte[256];
/* 347 */       int len = 0;
/* 348 */       int i = 0;
/* 349 */       int intIndex = 0;
/* 350 */       while ((len = readconfig.read()) != -1)
/*     */       {
/* 352 */         String tempStr = null;
/* 353 */         if (len == 10)
/*     */         {
/* 356 */           tempStr = new String(tb);
/*     */ 
/* 358 */           if (!tempStr.substring(0, 
/* 358 */             inputStr.length()).equals(inputStr))
/*     */           {
/* 360 */             tempStr = tempStr.trim();
/* 361 */             System.out.println(tempStr);
/* 362 */             out.write(tempStr);
/* 363 */             out.write(10);
/*     */           }
/*     */ 
/* 366 */           i = 0;
/* 367 */           tb = new byte[256];
/*     */         }
/*     */         else
/*     */         {
/* 372 */           if (len == 10)
/*     */             continue;
/* 374 */           Integer reallen = new Integer(len);
/* 375 */           tb[i] = reallen.byteValue();
/* 376 */           i++;
/*     */         }
/*     */       }
/*     */ 
/* 380 */       readconfig.close();
/* 381 */       input.delete();
/* 382 */       out.close();
/* 383 */       File tempfile = new File(ConfigFilePath);
/*     */ 
/* 385 */       output.renameTo(tempfile);
/* 386 */       return true;
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/* 391 */       String ErrorString = "<Conf.class> Parsing config file error:" + 
/* 392 */         exception.toString();
/* 393 */       UserLog.printException(ErrorString);
/* 394 */     }return false;
/*     */   }
/*     */ 
/*     */   public static SSRS GetValuebyCon()
/*     */   {
/* 401 */     SSRS tSSRS = new SSRS(2);
/*     */     try
/*     */     {
/* 405 */       FileInputStream readconfig = new FileInputStream(ConfigFilePath);
/* 406 */       byte[] tb = new byte[256];
/* 407 */       int len = 0;
/* 408 */       int i = 0;
/*     */ 
/* 410 */       String tempStr = null;
/*     */ 
/* 412 */       while ((len = readconfig.read()) != -1)
/*     */       {
/* 415 */         if (len == 33)
/*     */         {
/* 417 */           tempStr = new String(tb);
/*     */ 
/* 419 */           int position = tempStr.indexOf('|');
/* 420 */           tSSRS.SetText(tempStr.substring(0, position));
/* 421 */           if (tempStr.substring(0, position).equals("\r\n"))
/*     */           {
/* 423 */             tempStr = tempStr.trim();
/* 424 */             tSSRS.SetText(tempStr.substring(position - 1, 
/* 425 */               tempStr.length()));
/*     */           }
/*     */           else
/*     */           {
/* 429 */             tempStr = tempStr.trim();
/* 430 */             tSSRS.SetText(tempStr.substring(position + 1, 
/* 431 */               tempStr.length()));
/*     */           }
/* 433 */           i = 0;
/* 434 */           tb = new byte[256];
/*     */         }
/*     */         else
/*     */         {
/* 438 */           Integer reallen = new Integer(len);
/* 439 */           tb[i] = reallen.byteValue();
/* 440 */           i++;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 445 */       readconfig.close();
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/* 450 */       ErrorString = "<Conf.class> Parsing config file error:" + 
/* 451 */         exception.toString();
/* 452 */       UserLog.printException(ErrorString);
/*     */     }
/*     */ 
/* 455 */     return tSSRS;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.ConfigInfo
 * JD-Core Version:    0.6.0
 */