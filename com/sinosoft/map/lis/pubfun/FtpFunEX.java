/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import java.io.DataInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.StringTokenizer;
/*     */ import sun.net.TelnetInputStream;
/*     */ import sun.net.TelnetOutputStream;
/*     */ import sun.net.ftp.FtpClient;
/*     */ import sun.net.ftp.FtpLoginException;
/*     */ import sun.net.ftp.FtpProtocolException;
/*     */ 
/*     */ public class FtpFunEX
/*     */ {
/*  19 */   private FtpClient mFtpClient = null;
/*  20 */   private OutputStream upOS = null;
/*  21 */   private FileInputStream upIS = null;
/*  22 */   private OutputStream downOS = null;
/*  23 */   private FileInputStream downIS = null;
/*  24 */   private String upFileFullName = "";
/*  25 */   private String defPath = "";
/*  26 */   private String downFileFullName = "";
/*  27 */   private List FileList = new ArrayList();
/*  28 */   public boolean downFileIsEmpty = true;
/*     */ 
/*     */   public FtpClient connectFtpServer(String hostname, int port, String username, String password)
/*     */   {
/*     */     try
/*     */     {
/*  42 */       this.mFtpClient = new FtpClient(hostname, port);
/*  43 */       this.mFtpClient.login(username, password);
/*     */     }
/*     */     catch (FtpLoginException e1) {
/*  46 */       System.out.print("...... \u951F\u77EB\u4F19\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD ......");
/*  47 */       e1.printStackTrace();
/*  48 */       return null;
/*     */     }
/*     */     catch (IOException e2) {
/*  51 */       System.out.println("...... \u672A\u77E5\u951F\u65A4\u62F7\u951F\u65A4\u62F7 ......");
/*  52 */       e2.printStackTrace();
/*  53 */       return null;
/*     */     }
/*     */     catch (SecurityException e3) {
/*  56 */       System.out.print("...... \u6743\u951F\u776B\u8BE7\u62F7\u951F\u65A4\u62F7 ......");
/*  57 */       e3.printStackTrace();
/*  58 */       return null;
/*     */     }
/*  60 */     return this.mFtpClient;
/*     */   }
/*     */ 
/*     */   public boolean downloadFile(String ftppath, String ftpname, String aimpath, String aimname)
/*     */   {
/*     */     try
/*     */     {
/*  69 */       if (ftppath.length() != 0)
/*     */       {
/*  71 */         this.mFtpClient.cd(ftppath);
/*     */       }
/*  73 */       this.mFtpClient.binary();
/*  74 */       TelnetInputStream tis = this.mFtpClient.get(ftppath + "/" + ftpname);
/*  75 */       if (aimname.length() == 0)
/*     */       {
/*  77 */         aimname = ftpname;
/*     */       }
/*  79 */       File outFile = new File(aimpath + "/" + aimname);
/*     */ 
/*  81 */       FileOutputStream fos = new FileOutputStream(outFile);
/*  82 */       byte[] bytes = new byte[2048];
/*     */       int c;
/*  84 */       while ((c = tis.read(bytes)) != -1)
/*     */       {
/*     */         int c;
/*  86 */         fos.write(bytes, 0, c);
/*     */       }
/*  88 */       tis.close();
/*  89 */       fos.close();
/*  90 */       this.mFtpClient.closeServer();
/*     */     }
/*     */     catch (IOException ex) {
/*  93 */       System.out.println("...... \u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7\u5931\u951F\u65A4\u62F7 ......");
/*  94 */       ex.printStackTrace();
/*  95 */       return false;
/*     */     }
/*  97 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean uploadFile(String inPath, String inFilename, String outPath, String outFilename)
/*     */   {
/*     */     try
/*     */     {
/* 106 */       if (outPath.length() != 0)
/*     */       {
/* 108 */         this.mFtpClient.cd(outPath);
/*     */       }
/* 110 */       this.mFtpClient.binary();
/*     */ 
/* 112 */       TelnetOutputStream tos = this.mFtpClient.put(outFilename);
/* 113 */       File inFile = new File(inPath + inFilename);
/* 114 */       System.out.println("...... \u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7\u951F\u65A4\u62F7\u5C0F:" + inFile.length() / 1024L + "K ......");
/* 115 */       FileInputStream fis = new FileInputStream(inFile);
/* 116 */       System.out.println("===== uplaodFile===" + inPath + "\\" + inFilename);
/* 117 */       byte[] bytes = new byte[2048];
/*     */       int c;
/* 119 */       while ((c = fis.read(bytes)) != -1)
/*     */       {
/*     */         int c;
/* 121 */         tos.write(bytes, 0, c);
/*     */       }
/* 123 */       fis.close();
/* 124 */       tos.close();
/* 125 */       this.mFtpClient.closeServer();
/*     */     }
/*     */     catch (FtpProtocolException ex1)
/*     */     {
/* 130 */       System.out.println("...... \u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8282\u9769\u62F7\u76EE\u5F55\u951F\u94F0\u8FBE\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7 ......");
/* 131 */       ex1.printStackTrace();
/* 132 */       return false;
/*     */     }
/*     */     catch (IOException ex2) {
/* 135 */       System.out.println("...... \u672A\u77E5\u951F\u65A4\u62F7\u951F\u65A4\u62F7 ......");
/* 136 */       ex2.printStackTrace();
/* 137 */       return false;
/*     */     }
/*     */ 
/* 140 */     return true;
/*     */   }
/*     */ 
/*     */   public String getSystemInfo()
/*     */   {
/* 146 */     String systemInfo = null;
/*     */     try
/*     */     {
/* 149 */       systemInfo = this.mFtpClient.system();
/*     */     }
/*     */     catch (IOException ex) {
/* 152 */       System.out.println("......\u951F\u77EB\u7889\u62F7\u7CFB\u7EDF\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7\u951F\uFFFD......");
/* 153 */       ex.printStackTrace();
/*     */     }
/*     */ 
/* 156 */     return systemInfo;
/*     */   }
/*     */ 
/*     */   public boolean uploadFolder(String upFileFullName, String folderName, String aimPath)
/*     */   {
/* 161 */     this.upFileFullName = upFileFullName;
/*     */     try {
/* 163 */       String savefilename = new String(this.upFileFullName.getBytes("ISO-8859-1"), "UTF-8");
/*     */ 
/* 165 */       File file_in = new File(savefilename);
/*     */ 
/* 168 */       this.mFtpClient.cd(aimPath);
/* 169 */       this.mFtpClient.list();
/* 170 */       processUpFile(file_in, this.mFtpClient);
/* 171 */       if (this.upIS != null) {
/* 172 */         this.upIS.close();
/*     */       }
/* 174 */       if (this.upOS != null) {
/* 175 */         this.upOS.close();
/*     */       }
/*     */ 
/* 180 */       return true;
/*     */     } catch (Exception e) {
/* 182 */       e.printStackTrace();
/* 183 */       System.out.println("Exception e in Ftp upload(): " + e.toString());
/* 184 */     }return false;
/*     */   }
/*     */ 
/*     */   private void processUpFile(File source, FtpClient ftpClient)
/*     */   {
/*     */     try
/*     */     {
/* 193 */       if (source.exists())
/* 194 */         if (source.isDirectory())
/*     */         {
/* 196 */           String tempPaht = source.getPath().substring(this.upFileFullName.length()).replace("\\", "/");
/* 197 */           if (!isFolderExist(tempPaht, ftpClient)) {
/* 198 */             createFolder(tempPaht, ftpClient);
/*     */           }
/*     */           else
/*     */           {
/* 203 */             String[] xxx = tempPaht.split("/");
/* 204 */             for (int n = 0; n < xxx.length; n++)
/*     */             {
/* 206 */               if (xxx[n].equals(""))
/*     */                 continue;
/* 208 */               ftpClient.cdUp();
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/* 213 */           File[] sourceFile = source.listFiles();
/* 214 */           for (int i = 0; i < sourceFile.length; i++) {
/* 215 */             if (sourceFile[i].exists())
/* 216 */               if (sourceFile[i].isDirectory()) {
/* 217 */                 processUpFile(sourceFile[i], ftpClient);
/*     */               } else {
/* 219 */                 String cdPath = cheangPath(sourceFile[i].getPath(), this.upFileFullName);
/*     */ 
/* 222 */                 ftpClient.cd(cdPath);
/*     */ 
/* 224 */                 ftpClient.binary();
/* 225 */                 this.upOS = ftpClient.put(sourceFile[i].getName());
/* 226 */                 byte[] bytes = new byte[5120];
/* 227 */                 this.upIS = new FileInputStream(sourceFile[i]);
/*     */                 int c;
/* 231 */                 while ((c = this.upIS.read(bytes)) != -1)
/*     */                 {
/*     */                   int c;
/* 232 */                   this.upOS.write(bytes, 0, c);
/*     */                 }
/* 234 */                 this.upIS.close();
/* 235 */                 this.upOS.close();
/* 236 */                 String[] mmm = cdPath.split("/");
/* 237 */                 for (int n = 0; n < mmm.length; n++)
/*     */                 {
/* 239 */                   if (mmm[n].equals(""))
/*     */                     continue;
/* 241 */                   ftpClient.cdUp();
/*     */                 }
/*     */               }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 248 */           ftpClient.cd(cheangPath(source.getPath(), this.upFileFullName));
/* 249 */           ftpClient.binary();
/* 250 */           this.upOS = ftpClient.put(source.getName());
/* 251 */           byte[] bytes = new byte[5120];
/* 252 */           this.upIS = new FileInputStream(source);
/*     */           int c;
/* 256 */           while ((c = this.upIS.read(bytes)) != -1)
/*     */           {
/*     */             int c;
/* 257 */             this.upOS.write(bytes, 0, c);
/*     */           }
/* 259 */           this.upIS.close();
/* 260 */           this.upOS.close();
/*     */         }
/*     */     }
/*     */     catch (IOException e) {
/* 264 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String downFolder(String downFileFullName, String toAimPath)
/*     */   {
/* 272 */     System.out.println("================================= FtpFunEX== start downFlolder===root=" + downFileFullName + " ===download to= " + toAimPath);
/* 273 */     this.downFileFullName = downFileFullName;
/* 274 */     String flag = "";
/*     */     try
/*     */     {
/* 281 */       makeFolder(toAimPath + downFileFullName);
/*     */ 
/* 283 */       flag = processDownFile(downFileFullName, toAimPath + downFileFullName, this.mFtpClient);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 295 */       e.printStackTrace();
/* 296 */       System.err.println("Exception e in Ftp download(): " + e.toString());
/* 297 */       flag = "E";
/*     */     }
/* 299 */     return flag;
/*     */   }
/*     */ 
/*     */   public String processDownFile(String source, String toAimPath, FtpClient ftpClient)
/*     */   {
/*     */     try
/*     */     {
/*     */       try
/*     */       {
/* 309 */         ftpClient.cd(source);
/*     */       }
/*     */       catch (FileNotFoundException r) {
/* 312 */         return "N";
/*     */       }
/*     */ 
/* 317 */       DataInputStream tDataInputStream = new DataInputStream(ftpClient.list());
/* 318 */       String filename = "";
/* 319 */       String[] temp = null;
/* 320 */       while ((filename = tDataInputStream.readLine()) != null)
/*     */       {
/* 323 */         filename = new String(filename.getBytes("ISO-8859-1"), "gbk");
/*     */ 
/* 325 */         temp = filename.split(" ");
/* 326 */         String filename2 = temp[(temp.length - 1)].trim();
/*     */ 
/* 328 */         if (filename2.equals(".")) {
/*     */           continue;
/*     */         }
/* 331 */         if (filename2.equals(".."))
/*     */         {
/*     */           continue;
/*     */         }
/* 335 */         if (filename2.indexOf(".") == -1)
/*     */         {
/* 339 */           this.FileList.add("/" + filename2);
/*     */ 
/* 342 */           processDownFile(filename2, toAimPath, ftpClient);
/*     */         }
/*     */         else
/*     */         {
/* 346 */           this.downFileIsEmpty = false;
/*     */ 
/* 350 */           ftpClient.binary();
/* 351 */           String temppath = getWritePath(this.FileList);
/*     */ 
/* 353 */           makeFolder(toAimPath + temppath);
/*     */ 
/* 357 */           TelnetInputStream tis = ftpClient.get(filename2);
/*     */ 
/* 361 */           File outFile = new File(toAimPath + temppath + "/" + filename2);
/* 362 */           FileOutputStream fos = new FileOutputStream(outFile);
/* 363 */           byte[] bytes = new byte[5120];
/*     */           int c;
/* 365 */           while ((c = tis.read(bytes)) != -1)
/*     */           {
/*     */             int c;
/* 367 */             fos.write(bytes, 0, c);
/*     */           }
/* 369 */           tis.close();
/* 370 */           fos.close();
/*     */         }
/*     */       }
/* 373 */       if (!this.FileList.isEmpty())
/*     */       {
/* 375 */         this.FileList.remove(this.FileList.size() - 1);
/*     */       }
/* 377 */       ftpClient.cdUp();
/* 378 */       tDataInputStream.close();
/*     */     } catch (IOException e) {
/* 380 */       e.printStackTrace();
/*     */     }
/* 382 */     return "";
/*     */   }
/*     */ 
/*     */   public boolean renameFolder(String oldname, String newname)
/*     */   {
/*     */     try
/*     */     {
/* 390 */       this.mFtpClient.rename(oldname, newname);
/*     */     } catch (IOException e) {
/* 392 */       e.printStackTrace();
/* 393 */       return false;
/*     */     }
/* 395 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean moveFile(String oldname, String newname)
/*     */   {
/*     */     try
/*     */     {
/* 402 */       this.mFtpClient.rename(oldname, newname);
/*     */     } catch (IOException e) {
/* 404 */       e.printStackTrace();
/* 405 */       return false;
/*     */     }
/* 407 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean createFolder(String folder, FtpClient ftpClient)
/*     */   {
/*     */     try
/*     */     {
/* 414 */       ftpClient.ascii();
/* 415 */       StringTokenizer s = new StringTokenizer(folder, "/");
/* 416 */       s.countTokens();
/* 417 */       String pathName = "";
/* 418 */       while (s.hasMoreElements()) {
/* 419 */         pathName = pathName + "/" + (String)s.nextElement();
/* 420 */         if (pathName.substring(0, 1).equals("/"))
/*     */         {
/* 422 */           pathName = pathName.substring(1);
/*     */         }
/* 424 */         ftpClient.sendServer("MKD " + pathName + "\r\n");
/* 425 */         ftpClient.readServerResponse();
/*     */       }
/* 427 */       ftpClient.binary();
/*     */     } catch (IOException e) {
/* 429 */       e.printStackTrace();
/* 430 */       return false;
/*     */     }
/* 432 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean createFolder(String folder)
/*     */   {
/*     */     try
/*     */     {
/* 439 */       this.mFtpClient.ascii();
/* 440 */       StringTokenizer s = new StringTokenizer(folder, "/");
/* 441 */       s.countTokens();
/* 442 */       String pathName = "";
/* 443 */       while (s.hasMoreElements()) {
/* 444 */         pathName = pathName + "/" + (String)s.nextElement();
/* 445 */         if (pathName.substring(0, 1).equals("/"))
/*     */         {
/* 447 */           pathName = pathName.substring(1);
/*     */         }
/* 449 */         this.mFtpClient.sendServer("MKD " + pathName + "\r\n");
/* 450 */         this.mFtpClient.readServerResponse();
/*     */       }
/* 452 */       this.mFtpClient.binary();
/*     */     } catch (IOException e) {
/* 454 */       e.printStackTrace();
/* 455 */       return false;
/*     */     }
/* 457 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean isFolderExist(String dir, FtpClient ftpClient)
/*     */   {
/*     */     try {
/* 463 */       ftpClient.cd(dir);
/*     */     } catch (Exception e) {
/* 465 */       return false;
/*     */     }
/* 467 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean isFolderExist(String dir)
/*     */   {
/* 472 */     if (this.mFtpClient != null) {
/* 473 */       return isFolderExist(dir, this.mFtpClient);
/*     */     }
/* 475 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean cdFolderIn(String path) {
/*     */     try {
/* 480 */       this.mFtpClient.cd(path);
/*     */     } catch (Exception e) {
/* 482 */       return false;
/*     */     }
/* 484 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean cdFolderUp()
/*     */   {
/*     */     try {
/* 490 */       this.mFtpClient.cdUp();
/*     */     } catch (Exception e) {
/* 492 */       return false;
/*     */     }
/* 494 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean closeConnect()
/*     */   {
/*     */     try
/*     */     {
/* 501 */       this.mFtpClient.closeServer();
/*     */     } catch (IOException e) {
/* 503 */       e.printStackTrace();
/* 504 */       return false;
/*     */     }
/* 506 */     return true;
/*     */   }
/*     */ 
/*     */   private String getWritePath(List list)
/*     */   {
/* 512 */     StringBuffer temp = new StringBuffer();
/* 513 */     for (int i = 0; i < list.size(); i++)
/*     */     {
/* 515 */       temp.append(list.get(i).toString());
/*     */     }
/* 517 */     return temp.toString();
/*     */   }
/*     */ 
/*     */   private String cheangPath(String path, String path2)
/*     */   {
/* 522 */     path = path.substring(path2.length()).replace("\\", "/");
/* 523 */     if ("".equals(path))
/* 524 */       path = "/";
/*     */     else {
/* 526 */       path = path.substring(0, path.lastIndexOf("/") + 1);
/*     */     }
/*     */ 
/* 529 */     if (path.substring(0, 1).equals("/"))
/*     */     {
/* 531 */       path = path.substring(1);
/*     */     }
/* 533 */     return path;
/*     */   }
/*     */ 
/*     */   private void makeFolder(String folderPath)
/*     */   {
/*     */     try
/*     */     {
/* 541 */       StringTokenizer s = new StringTokenizer(folderPath, "/");
/* 542 */       s.countTokens();
/* 543 */       String pathName = "";
/* 544 */       while (s.hasMoreElements()) {
/* 545 */         pathName = pathName + "/" + (String)s.nextElement();
/* 546 */         File folder = new File(pathName);
/* 547 */         if ((folder.exists()) || 
/* 548 */           (folder.mkdirs()))
/*     */           continue;
/* 550 */         System.out.println(" \u951F\u4FA5\u7877\u62F7\u951F\u53EB\u8FBE\u62F7\u951F\u65A4\u62F7\u5931\u951F\u6770\uFF4F\u62F7\u951F\u65A4\u62F7\u786E\u951F\u8F83\u8FBE\u62F7\u951F\u65A4\u62F7\u6CA1\u951F\u65A4\u62F7\u5199\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u63ED\u7A7A\u7877\u62F7\u951F\u59D0\u591F");
/* 551 */         System.exit(1);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception err)
/*     */     {
/* 558 */       System.err.println("\u951F\u4FA5\u7877\u62F7\u951F\u53EB\u8FBE\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u5C4A\u5E38");
/* 559 */       err.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private static boolean test2()
/*     */   {
/* 566 */     String tPath = "D:/lis3.txt";
/* 567 */     File file = new File(tPath);
/* 568 */     if (file.isDirectory())
/*     */     {
/* 570 */       System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7\u951F\u65A4\u62F7");
/*     */     }
/* 572 */     if (file.isFile())
/*     */     {
/* 574 */       System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7");
/*     */     }
/* 576 */     if (file.exists())
/*     */     {
/* 578 */       System.out.println("\u951F\u65A4\u62F7\u8DEF\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7");
/* 579 */       return true;
/*     */     }
/* 581 */     System.out.println("\u951F\u63ED\u8BE7\u62F7\u951F\u65A4\u62F7\u8DEF\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7");
/*     */ 
/* 583 */     return true;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 589 */     FtpFunEX tFtpFun = new FtpFunEX();
/*     */ 
/* 591 */     FtpClient tFtpClient = tFtpFun.connectFtpServer("192.168.2.200", 21, "administrator", "2010");
/* 592 */     if (tFtpClient != null)
/*     */     {
/* 594 */       System.out.println("\u951F\u7A96\u6485\u62F7l\u951F\u65A4\u62F7\u951F\u65A4\u62F7ftp server" + tFtpFun.getSystemInfo());
/*     */ 
/* 597 */       tFtpFun.moveFile("/ReturnData", "/ReturnDataBackup/2009-11-21");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.FtpFunEX
 * JD-Core Version:    0.6.0
 */