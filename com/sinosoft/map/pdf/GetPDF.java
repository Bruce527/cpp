/*     */ package com.sinosoft.map.pdf;
/*     */ 
/*     */ import com.sinosoft.map.lis.pubfun.FtpFunEX;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileWriter;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class GetPDF
/*     */ {
/*  19 */   public String firstRdxPath = "";
/*  20 */   public String secondRdxPath = "";
/*  21 */   public String newPdfPath = "";
/*  22 */   private String fullDirPath = "";
/*  23 */   private String newRdxDirpath = "";
/*  24 */   private String newPdfDirPath = "";
/*     */ 
/*  26 */   public String ftpAddress = "";
/*  27 */   public String ftpPort = "";
/*  28 */   public String ftpUserName = "";
/*  29 */   public String ftpPassword = "";
/*     */ 
/*  31 */   private int amount = 0;
/*     */ 
/*     */   public void getInitPath() {
/*  34 */     ExeSQL tExeSQL = new ExeSQL();
/*  35 */     SSRS tSSRS = new SSRS();
/*  36 */     String sql1 = " select varvalue from msysvar where vartype='casedownloadfile' ";
/*  37 */     tSSRS = tExeSQL.execSQL(sql1);
/*  38 */     this.firstRdxPath = tSSRS.GetText(1, 1);
/*     */ 
/*  40 */     String sql2 = " select varvalue from msysvar where vartype='casexmlfile' ";
/*  41 */     tSSRS = tExeSQL.execSQL(sql2);
/*  42 */     this.secondRdxPath = tSSRS.GetText(1, 1);
/*     */ 
/*  44 */     String sql3 = " select varvalue from msysvar where vartype='casepdffile' ";
/*  45 */     tSSRS = tExeSQL.execSQL(sql3);
/*  46 */     this.newPdfPath = tSSRS.GetText(1, 1);
/*     */ 
/*  48 */     String sql4 = " select varvalue from msysvar where vartype='ftpaddress' ";
/*  49 */     tSSRS = tExeSQL.execSQL(sql4);
/*  50 */     this.ftpAddress = tSSRS.GetText(1, 1);
/*     */ 
/*  52 */     String sql5 = " select varvalue from msysvar where vartype='ftpport' ";
/*  53 */     tSSRS = tExeSQL.execSQL(sql5);
/*  54 */     this.ftpPort = tSSRS.GetText(1, 1);
/*     */ 
/*  56 */     String sql6 = " select varvalue from msysvar where vartype='ftpusername' ";
/*  57 */     tSSRS = tExeSQL.execSQL(sql6);
/*  58 */     this.ftpUserName = tSSRS.GetText(1, 1);
/*     */ 
/*  60 */     String sql7 = " select varvalue from msysvar where vartype='ftppassword' ";
/*  61 */     tSSRS = tExeSQL.execSQL(sql7);
/*  62 */     this.ftpPassword = tSSRS.GetText(1, 1);
/*     */   }
/*     */ 
/*     */   public boolean getPdf(String year, String month, String day)
/*     */   {
/*     */     try
/*     */     {
/*  74 */       FtpFunEX tFtpFun = new FtpFunEX();
/*     */ 
/*  80 */       String ftpRoot = "/";
/*  81 */       String strDay = "";
/*  82 */       String strMonth = "";
/*  83 */       if ((!day.equals("")) && (day != null)) {
/*  84 */         int intDay = Integer.parseInt(day);
/*  85 */         strDay = "/" + intDay;
/*     */       }
/*  87 */       if ((!month.equals("")) && (month != null)) {
/*  88 */         int intMonth = Integer.parseInt(month);
/*  89 */         strMonth = "/" + intMonth;
/*     */       }
/*  91 */       if ((year.equals("")) || (year == null)) {
/*  92 */         System.out.println("----------Error:year is nessesary---");
/*  93 */         return false;
/*     */       }
/*  95 */       int intYear = Integer.parseInt(year);
/*     */ 
/*  98 */       String downFileFullName = ftpRoot + intYear + strMonth + strDay;
/*     */ 
/* 102 */       System.out.println("============= start download from ftp ====== downFileFullName==" + downFileFullName);
/*     */ 
/* 104 */       this.firstRdxPath = this.firstRdxPath.replace("\\", "/");
/*     */ 
/* 109 */       tFtpFun.connectFtpServer(this.ftpAddress, Integer.parseInt(this.ftpPort), this.ftpUserName, this.ftpPassword);
/* 110 */       System.out.println("\u5DF2\u7ECF\u8FDE\u63A5\u4E0Aftp server" + tFtpFun.getSystemInfo());
/* 111 */       boolean flagStr = tFtpFun.isFolderExist(downFileFullName);
/* 112 */       tFtpFun.closeConnect();
/* 113 */       if (!flagStr)
/*     */       {
/* 115 */         return true;
/*     */       }
/* 117 */       String startTime = intYear + strMonth + strDay + " 00:00:00.000";
/* 118 */       String endTime = intYear + strMonth + strDay + " 23:59:59.999";
/* 119 */       String downSql = " select rrf.r_rpt_file_rp from r_cv_case rcc  inner join r_case_file rcf on rcc.r_key= rcf.rcf_case_key  inner join R_RPT_FILE  rrf on rrf.r_rpt_file_key =rcf_file_key  inner join tb_application tb_app on  rcc.r_policy_num=tb_app.cd_policy_complement  inner join   tb_application_broker tb_a_b on  tb_app.cd_administrator=tb_a_b.cd_administrator  and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product and tb_app.cd_application=tb_a_b.cd_application  inner join laagent la on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode  where 1=1 and la.branchtype='1'  and rrf.r_rpt_file_btime >= '" + 
/* 126 */         startTime + "' " + 
/* 127 */         " and rrf.r_rpt_file_btime<= '" + endTime + "' ";
/* 128 */       ExeSQL tExeSQL = new ExeSQL();
/* 129 */       SSRS tSSRS = new SSRS();
/* 130 */       tSSRS = tExeSQL.execSQL(downSql);
/*     */ 
/* 132 */       boolean downFileFlag = true;
/*     */ 
/* 134 */       if ((tSSRS == null) || (tSSRS.MaxRow == 0))
/*     */       {
/* 136 */         return true;
/*     */       }
/* 138 */       for (int i = 1; i <= tSSRS.MaxRow; i++)
/*     */       {
/* 141 */         String filePath = tSSRS.GetText(i, 1);
/*     */ 
/* 148 */         String[] filePaths = filePath.split("\\\\");
/* 149 */         String filedir = "";
/* 150 */         String filename = "";
/* 151 */         String aimpath = "";
/* 152 */         String aimname = "";
/* 153 */         System.out.print("--filePath.length()--" + filePaths.length);
/*     */ 
/* 156 */         for (int j = 0; j < filePaths.length - 1; j++)
/*     */         {
/* 159 */           if (j == 0) {
/* 160 */             filedir = filedir + ftpRoot + filePaths[j];
/* 161 */             aimpath = aimpath + this.firstRdxPath + "/" + filePaths[j];
/*     */           } else {
/* 163 */             filedir = filedir + "/" + filePaths[j];
/* 164 */             aimpath = this.firstRdxPath + filedir;
/*     */           }
/*     */ 
/* 167 */           File f = new File(aimpath);
/* 168 */           if (!f.exists()) {
/* 169 */             f.mkdirs();
/*     */           }
/*     */         }
/* 172 */         filename = filePaths[(filePaths.length - 1)];
/* 173 */         aimname = filename;
/*     */ 
/* 176 */         System.out.println("--filedir-FTP\u6587\u4EF6\u8DEF\u5F84 -" + filedir);
/* 177 */         System.out.println("--filename-FTP\u6587\u4EF6\u540D-" + filename);
/* 178 */         System.out.println("--aimpath-" + aimpath);
/* 179 */         System.out.println("--aimname-\u76EE\u6807\u6587\u4EF6\u540D -" + aimname);
/*     */ 
/* 181 */         tFtpFun.connectFtpServer(this.ftpAddress, Integer.parseInt(this.ftpPort), this.ftpUserName, this.ftpPassword);
/* 182 */         System.out.println("\u5DF2\u7ECF\u8FDE\u63A5\u4E0Aftp server" + tFtpFun.getSystemInfo());
/*     */ 
/* 185 */         boolean ifOneFail = tFtpFun.downloadFile(filedir, filename, aimpath, aimname);
/* 186 */         if (!ifOneFail) {
/* 187 */           downFileFlag = false;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 208 */       System.out.println("=============download rdx ok =============== ");
/*     */ 
/* 213 */       this.fullDirPath = downFileFullName;
/*     */ 
/* 216 */       System.out.println("============= start modify root element and save  ====" + this.firstRdxPath + this.fullDirPath);
/*     */ 
/* 218 */       File curDir = new File(this.firstRdxPath + this.fullDirPath);
/*     */ 
/* 220 */       if (!curDir.exists()) curDir.mkdirs();
/*     */ 
/* 223 */       boolean flag = getFile(downFileFullName);
/* 224 */       System.out.println("===========create pdf  ok====");
/*     */ 
/* 226 */       if ((!flag) || (!downFileFlag)) return false; 
/*     */     }
/*     */     catch (Exception e) {
/* 228 */       e.printStackTrace();
/* 229 */       return false;
/*     */     }
/*     */ 
/* 232 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean getFile(File file)
/*     */   {
/* 238 */     this.amount += 1;
/* 239 */     if (file.isDirectory()) {
/* 240 */       if (this.amount > 1)
/*     */       {
/* 242 */         this.fullDirPath = file.getAbsolutePath();
/*     */       }
/*     */ 
/* 245 */       File[] f = file.listFiles();
/*     */ 
/* 248 */       this.newRdxDirpath = this.fullDirPath.replace("download_", "xml_");
/* 249 */       this.newRdxDirpath = this.newRdxDirpath.replace("\\", "/");
/*     */ 
/* 251 */       File newRdxdir = new File(this.newRdxDirpath);
/* 252 */       System.out.println("==new rdx dir=" + this.newRdxDirpath);
/*     */ 
/* 254 */       if (!newRdxdir.exists()) {
/* 255 */         newRdxdir.mkdirs();
/*     */       }
/*     */ 
/* 259 */       this.newPdfDirPath = this.fullDirPath.replace("download_", "pdf_");
/* 260 */       this.newPdfDirPath = this.newPdfDirPath.replace("\\", "/");
/*     */ 
/* 263 */       System.out.println("===new pdf dir===" + this.newPdfDirPath);
/* 264 */       File newpdfdir = new File(this.newPdfDirPath);
/* 265 */       if (!newpdfdir.exists()) {
/* 266 */         newpdfdir.mkdirs();
/*     */       }
/*     */ 
/* 269 */       for (int i = 0; i < f.length; i++) {
/* 270 */         getFile(f[i]);
/* 271 */         this.amount += 1;
/*     */       }
/*     */     }
/* 274 */     if (file.isFile())
/*     */     {
/* 276 */       String newRdx = modifyRdx(file);
/*     */ 
/* 279 */       String newPdf = newRdx.replace("xml_", "pdf_").replace(".xml", ".pdf");
/*     */ 
/* 281 */       if (file.getName().contains(".rdx"))
/*     */       {
/* 283 */         boolean flag1 = changeToPdf(newRdx, newPdf);
/* 284 */         if (!flag1) return false;
/*     */       }
/*     */     }
/*     */ 
/* 288 */     return true;
/*     */   }
/*     */ 
/*     */   private String modifyRdx(File file)
/*     */   {
/* 293 */     String fileName = file.getName();
/*     */ 
/* 296 */     String newXmlFile = file.getAbsolutePath().replace("download_", "xml_").replace(".rdx", ".xml");
/* 297 */     newXmlFile = newXmlFile.replace("\\", "/");
/* 298 */     if (fileName.contains(".rdx"))
/*     */     {
/* 300 */       File f1 = new File(newXmlFile);
/*     */       try
/*     */       {
/* 303 */         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
/* 304 */         FileWriter fw = new FileWriter(f1);
/* 305 */         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f1), "UTF-8"));
/*     */         String text;
/* 308 */         while ((text = br.readLine()) != null)
/*     */         {
/*     */           String text;
/* 309 */           if (text.contains("<Report ")) {
/* 310 */             text = "<Report>";
/*     */           }
/* 312 */           bw.write(text);
/* 313 */           bw.newLine();
/*     */         }
/* 315 */         bw.close();
/* 316 */         fw.close();
/* 317 */         br.close();
/*     */       }
/*     */       catch (Exception localException) {
/*     */       }
/*     */     }
/* 322 */     return newXmlFile;
/*     */   }
/*     */ 
/*     */   public boolean changeToPdf(String rdxpath, String pdfPath)
/*     */   {
/* 329 */     boolean flag = Rdx2Pdf.ChangeToPdf(rdxpath, pdfPath);
/* 330 */     return flag;
/*     */   }
/*     */ 
/*     */   private boolean getFile(String downLoadPath)
/*     */   {
/* 335 */     File rdxFile = new File(this.firstRdxPath + downLoadPath);
/* 336 */     if (!rdxFile.exists()) return false;
/*     */ 
/* 338 */     if (rdxFile.isDirectory())
/*     */     {
/* 340 */       File[] f = rdxFile.listFiles();
/*     */ 
/* 343 */       File newRdxdir = new File(this.secondRdxPath + downLoadPath);
/* 344 */       if (!newRdxdir.exists()) {
/* 345 */         newRdxdir.mkdirs();
/*     */       }
/* 347 */       File newpdfdir = new File(this.newPdfPath + downLoadPath);
/*     */ 
/* 349 */       System.out.println("===new pdf dir===" + newpdfdir);
/*     */ 
/* 351 */       if (!newpdfdir.exists()) {
/* 352 */         newpdfdir.mkdirs();
/*     */       }
/*     */ 
/* 355 */       for (int i = 0; i < f.length; i++)
/*     */       {
/* 357 */         getFile(downLoadPath + "/" + f[i].getName());
/*     */       }
/*     */     }
/*     */ 
/* 361 */     if (rdxFile.isFile())
/*     */     {
/* 363 */       String newRdx = modifyRdx(rdxFile, downLoadPath);
/*     */ 
/* 367 */       if (rdxFile.getName().contains(".rdx")) {
/* 368 */         String newPdf = (this.newPdfPath + downLoadPath).replace(".rdx", ".pdf");
/*     */ 
/* 370 */         boolean flag1 = changeToPdf(newRdx, newPdf);
/* 371 */         if (!flag1) return false;
/*     */       }
/*     */     }
/* 374 */     return true;
/*     */   }
/*     */ 
/*     */   private String modifyRdx(File file, String downLoadPath)
/*     */   {
/* 380 */     String fileName = file.getName();
/*     */ 
/* 385 */     String newXmlFile = (this.secondRdxPath + downLoadPath).replace(".rdx", ".xml");
/*     */ 
/* 387 */     if (fileName.contains(".rdx"))
/*     */     {
/* 391 */       File f1 = new File(newXmlFile);
/*     */       try
/*     */       {
/* 395 */         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
/* 396 */         FileWriter fw = new FileWriter(f1);
/* 397 */         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f1), "UTF-8"));
/*     */         String text;
/* 400 */         while ((text = br.readLine()) != null)
/*     */         {
/*     */           String text;
/* 401 */           if (text.contains("<Report ")) {
/* 402 */             text = "<Report>";
/*     */           }
/* 404 */           bw.write(text);
/* 405 */           bw.newLine();
/*     */         }
/* 407 */         bw.close();
/* 408 */         fw.close();
/* 409 */         br.close();
/*     */       }
/*     */       catch (Exception localException) {
/*     */       }
/*     */     }
/* 414 */     return newXmlFile;
/*     */   }
/*     */ 
/*     */   public static void main(String[] a)
/*     */   {
/* 426 */     File f = new File("D:/1111111111/111.txt");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.pdf.GetPDF
 * JD-Core Version:    0.6.0
 */