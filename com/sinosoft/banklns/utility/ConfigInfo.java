/*     */ package com.sinosoft.banklns.utility;
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
/*   8 */   private static String ErrorString = "";
/*   9 */   private static String ConfigFilePath = ".//AppConfig.properties";
/*     */ 
/*     */   public ConfigInfo()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ConfigInfo(String XmlFilePath)
/*     */   {
/*  17 */     ConfigFilePath = XmlFilePath;
/*     */   }
/*     */ 
/*     */   public static String GetConfigPath()
/*     */   {
/*  23 */     return ConfigFilePath;
/*     */   }
/*     */ 
/*     */   public static void SetConfigPath(String newpath)
/*     */   {
/*  29 */     ConfigFilePath = newpath;
/*     */   }
/*     */ 
/*     */   public static String GetErrorString()
/*     */   {
/*  35 */     return ErrorString;
/*     */   }
/*     */ 
/*     */   public static String GetValuebyName(String inpfieldname)
/*     */   {
/*  41 */     String ConfigValue = "";
/*     */     try
/*     */     {
/*  45 */       FileInputStream readconfig = new FileInputStream(ConfigFilePath);
/*  46 */       byte[] tb = new byte[256];
/*  47 */       int len = 0;
/*  48 */       int i = 0;
/*  49 */       String fieldname = "";
/*  50 */       String fieldvalue = "";
/*     */ 
/*  52 */       while ((len = readconfig.read()) != -1)
/*     */       {
/*  54 */         String tempStr = null;
/*     */ 
/*  56 */         if (len == 10)
/*     */         {
/*  58 */           tempStr = new String(tb);
/*  59 */           tempStr = tempStr.trim();
/*  60 */           fieldname = StrTool.decodeStr(tempStr, "=", 1);
/*     */ 
/*  63 */           if (fieldname.equals(inpfieldname))
/*     */           {
/*  66 */             fieldvalue = tempStr.substring(fieldname.length() + 1);
/*  67 */             break;
/*     */           }
/*     */ 
/*  71 */           i = 0;
/*  72 */           tb = new byte[256];
/*     */         }
/*     */         else
/*     */         {
/*  77 */           Integer reallen = new Integer(len);
/*  78 */           tb[i] = reallen.byteValue();
/*  79 */           i++;
/*     */         }
/*     */       }
/*     */ 
/*  83 */       readconfig.close();
/*  84 */       ConfigValue = fieldvalue.trim();
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/*  89 */       ErrorString = "<Conf.class> Parsing config file error:" + exception.toString();
/*  90 */       UserLog.printException(ErrorString);
/*     */     }
/*     */ 
/*  93 */     return ConfigValue;
/*     */   }
/*     */ 
/*     */   public static String GetValuebyArea(String inpfieldname)
/*     */   {
/*  99 */     String ConfigValue = "";
/*     */     try
/*     */     {
/* 103 */       FileInputStream readconfig = new FileInputStream(ConfigFilePath);
/* 104 */       byte[] tb = new byte[256];
/* 105 */       int len = 0;
/* 106 */       int i = 0;
/* 107 */       String fieldname = "";
/* 108 */       String fieldvalue = "";
/*     */ 
/* 110 */       while ((len = readconfig.read()) != -1)
/*     */       {
/* 112 */         String tempStr = null;
/*     */ 
/* 114 */         if (len == 10)
/*     */         {
/* 116 */           tempStr = new String(tb);
/* 117 */           tempStr = tempStr.trim();
/*     */ 
/* 119 */           fieldname = StrTool.decodeStr(tempStr, "=", 1);
/*     */ 
/* 122 */           if ((tempStr.length() == 0) && (fieldname.length() == 0))
/*     */           {
/* 124 */             i = 0;
/* 125 */             tb = new byte[256];
/*     */           }
/*     */           else
/*     */           {
/* 129 */             if (cmpFieldValue(fieldname, inpfieldname))
/*     */             {
/* 132 */               fieldvalue = tempStr.substring(fieldname.length() + 1);
/* 133 */               break;
/*     */             }
/*     */ 
/* 137 */             i = 0;
/* 138 */             tb = new byte[256];
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 143 */           Integer reallen = new Integer(len);
/* 144 */           tb[i] = reallen.byteValue();
/* 145 */           i++;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 150 */       readconfig.close();
/* 151 */       ConfigValue = fieldvalue.trim();
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/* 156 */       ErrorString = "<Conf.class> Parsing config file error:" + exception.toString();
/* 157 */       UserLog.printException(ErrorString);
/*     */     }
/*     */ 
/* 160 */     return ConfigValue;
/*     */   }
/*     */ 
/*     */   public static boolean cmpFieldValue(String srcFieldName, String tagFieldName)
/*     */   {
/* 166 */     String[] tmpStr = new String[5];
/* 167 */     String[] tmpValue = new String[5];
/* 168 */     int strPos = 0;
/* 169 */     int i = 0;
/*     */ 
/* 171 */     if ((tagFieldName.length() == 0) || (srcFieldName.indexOf(".") == -1))
/*     */     {
/* 173 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 178 */       srcFieldName = srcFieldName.trim() + ".";
/* 179 */       tagFieldName = tagFieldName.trim() + ".";
/*     */ 
/* 181 */       tmpStr[0] = StrTool.decodeStr(srcFieldName, ".", 1);
/* 182 */       tmpStr[1] = StrTool.decodeStr(srcFieldName, ".", 2);
/* 183 */       tmpStr[2] = StrTool.decodeStr(srcFieldName, ".", 3);
/* 184 */       tmpStr[3] = StrTool.decodeStr(srcFieldName, ".", 4);
/* 185 */       tmpStr[4] = StrTool.decodeStr(srcFieldName, ".", 5);
/*     */ 
/* 187 */       tmpValue[0] = StrTool.decodeStr(tagFieldName, ".", 1);
/* 188 */       tmpValue[1] = StrTool.decodeStr(tagFieldName, ".", 2);
/* 189 */       tmpValue[2] = StrTool.decodeStr(tagFieldName, ".", 3);
/* 190 */       tmpValue[3] = StrTool.decodeStr(tagFieldName, ".", 4);
/* 191 */       tmpValue[4] = StrTool.decodeStr(tagFieldName, ".", 5);
/*     */ 
/* 193 */       for (i = 0; i < tmpStr.length; i++)
/*     */       {
/* 195 */         if (!cmp2Value(tmpStr[i], tmpValue[i]))
/*     */         {
/* 200 */           return false;
/*     */         }
/*     */       }
/* 203 */       return true;
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/*     */     }
/* 208 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean cmp2Value(String strSource, String strTarget)
/*     */   {
/* 214 */     String tmpStrValue = "";
/* 215 */     String[] tmpStrArray = new String[2];
/* 216 */     int strPos = strSource.indexOf("-");
/*     */ 
/* 218 */     if (strPos == -1)
/*     */     {
/* 222 */       return (strTarget.equals(strSource.substring(1, strSource.length() - 1))) || (strSource.substring(1, strSource.length() - 1).equals("*"));
/*     */     }
/*     */ 
/* 231 */     tmpStrValue = strSource.substring(1, strSource.length() - 1) + "-";
/* 232 */     tmpStrArray[0] = StrTool.decodeStr(tmpStrValue, "-", 1);
/* 233 */     tmpStrArray[1] = StrTool.decodeStr(tmpStrValue, "-", 2);
/*     */ 
/* 235 */     int intCmp = new Integer(ChgData.chgNumericStr(strTarget)).intValue();
/* 236 */     int intAreaS = new Integer(ChgData.chgNumericStr(tmpStrArray[0])).intValue();
/* 237 */     int intAreaE = new Integer(ChgData.chgNumericStr(tmpStrArray[1])).intValue();
/*     */ 
/* 241 */     return (intCmp >= intAreaS) && (intCmp <= intAreaE);
/*     */   }
/*     */ 
/*     */   public static Vector GetIniByIp(String inpip)
/*     */   {
/* 251 */     String fieldvalue = "";
/* 252 */     Vector Strvector = new Vector();
/*     */     try
/*     */     {
/* 255 */       FileInputStream readconfig = new FileInputStream(ConfigFilePath);
/* 256 */       byte[] tb = new byte[256];
/* 257 */       int len = 0;
/* 258 */       int i = 0;
/* 259 */       int intIndex = 0;
/*     */ 
/* 261 */       String fieldname = "";
/*     */ 
/* 263 */       String inpfieldname = "(" + StrTool.decodeStr(inpip, ".", 1) + ")" + "." + "(" + StrTool.decodeStr(inpip, ".", 2) + ")";
/*     */ 
/* 265 */       while ((len = readconfig.read()) != -1) {
/* 266 */         String tempStr = null;
/* 267 */         if (len == 10)
/*     */         {
/* 269 */           tempStr = new String(tb);
/* 270 */           tempStr = tempStr.trim();
/*     */ 
/* 273 */           fieldname = StrTool.decodeStr(tempStr, ".", 1) + "." + StrTool.decodeStr(tempStr, ".", 2);
/*     */ 
/* 276 */           if (fieldname.equals(inpfieldname))
/*     */           {
/* 279 */             fieldvalue = tempStr;
/* 280 */             Strvector.addElement(fieldvalue);
/* 281 */             i = 0;
/* 282 */             tb = new byte[256];
/*     */           }
/*     */           else
/*     */           {
/* 286 */             i = 0;
/* 287 */             tb = new byte[256];
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 292 */           Integer reallen = new Integer(len);
/* 293 */           tb[i] = reallen.byteValue();
/* 294 */           i++;
/*     */         }
/*     */       }
/*     */ 
/* 298 */       readconfig.close();
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/* 302 */       String ErrorString = "<Conf.class> Parsing config file error:" + exception.toString();
/* 303 */       UserLog.printException(ErrorString);
/*     */     }
/*     */ 
/* 306 */     for (int i = 0; i < Strvector.size(); i++)
/*     */     {
/* 308 */       System.out.println((String)Strvector.get(i));
/*     */     }
/*     */ 
/* 311 */     return Strvector;
/*     */   }
/*     */ 
/*     */   public static boolean DeleteByStr(String inputStr)
/*     */   {
/*     */     try
/*     */     {
/* 319 */       File output = new File("AppConfig.properties.tmp");
/* 320 */       output.createNewFile();
/* 321 */       BufferedWriter out = new BufferedWriter(new FileWriter(output.getPath(), true));
/* 322 */       File input = new File(ConfigFilePath);
/* 323 */       FileInputStream readconfig = new FileInputStream(input);
/* 324 */       byte[] tb = new byte[256];
/* 325 */       int len = 0;
/* 326 */       int i = 0;
/* 327 */       int intIndex = 0;
/* 328 */       while ((len = readconfig.read()) != -1)
/*     */       {
/* 330 */         String tempStr = null;
/* 331 */         if (len == 10)
/*     */         {
/* 334 */           tempStr = new String(tb);
/* 335 */           if (!tempStr.substring(0, inputStr.length()).equals(inputStr)) {
/* 336 */             tempStr = tempStr.trim();
/* 337 */             System.out.println(tempStr);
/* 338 */             out.write(tempStr);
/* 339 */             out.write(10);
/*     */           }
/*     */ 
/* 342 */           i = 0;
/* 343 */           tb = new byte[256];
/*     */         }
/*     */         else
/*     */         {
/* 348 */           if (len == 10)
/*     */             continue;
/* 350 */           Integer reallen = new Integer(len);
/* 351 */           tb[i] = reallen.byteValue();
/* 352 */           i++;
/*     */         }
/*     */       }
/*     */ 
/* 356 */       readconfig.close();
/* 357 */       input.delete();
/* 358 */       out.close();
/* 359 */       File tempfile = new File(ConfigFilePath);
/*     */ 
/* 361 */       output.renameTo(tempfile);
/* 362 */       return true;
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/* 367 */       String ErrorString = "<Conf.class> Parsing config file error:" + exception.toString();
/* 368 */       UserLog.printException(ErrorString);
/* 369 */     }return false;
/*     */   }
/*     */ 
/*     */   public static SSRS GetValuebyCon()
/*     */   {
/* 376 */     SSRS tSSRS = new SSRS(2);
/*     */     try
/*     */     {
/* 380 */       FileInputStream readconfig = new FileInputStream(ConfigFilePath);
/* 381 */       byte[] tb = new byte[256];
/* 382 */       int len = 0;
/* 383 */       int i = 0;
/*     */ 
/* 385 */       String tempStr = null;
/*     */ 
/* 387 */       while ((len = readconfig.read()) != -1)
/*     */       {
/* 391 */         if (len == 33)
/*     */         {
/* 393 */           tempStr = new String(tb);
/*     */ 
/* 395 */           int position = tempStr.indexOf('|');
/* 396 */           tSSRS.SetText(tempStr.substring(0, position));
/* 397 */           if (tempStr.substring(0, position).equals("\r\n"))
/*     */           {
/* 399 */             tempStr = tempStr.trim();
/* 400 */             tSSRS.SetText(tempStr.substring(position - 1, tempStr.length()));
/*     */           }
/*     */           else
/*     */           {
/* 404 */             tempStr = tempStr.trim();
/* 405 */             tSSRS.SetText(tempStr.substring(position + 1, tempStr.length()));
/*     */           }
/* 407 */           i = 0;
/* 408 */           tb = new byte[256];
/*     */         }
/*     */         else
/*     */         {
/* 412 */           Integer reallen = new Integer(len);
/* 413 */           tb[i] = reallen.byteValue();
/* 414 */           i++;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 419 */       readconfig.close();
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/* 425 */       ErrorString = "<Conf.class> Parsing config file error:" + exception.toString();
/* 426 */       UserLog.printException(ErrorString);
/*     */     }
/*     */ 
/* 429 */     return tSSRS;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 436 */     ConfigInfo test = new ConfigInfo();
/* 437 */     System.out.println(GetValuebyName("userlogpath"));
/* 438 */     System.out.println(System.getProperty("user.home"));
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.ConfigInfo
 * JD-Core Version:    0.6.0
 */