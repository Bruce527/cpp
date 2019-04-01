/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import com.filenet.api.collection.ObjectStoreSet;
/*     */ import com.filenet.api.collection.RepositoryRowSet;
/*     */ import com.filenet.api.collection.StringList;
/*     */ import com.filenet.api.core.Domain;
/*     */ import com.filenet.api.core.Factory.Connection;
/*     */ import com.filenet.api.core.Factory.Domain;
/*     */ import com.filenet.api.core.Factory.ObjectStore;
/*     */ import com.filenet.api.core.ObjectStore;
/*     */ import com.filenet.api.property.Properties;
/*     */ import com.filenet.api.query.RepositoryRow;
/*     */ import com.filenet.api.query.SearchSQL;
/*     */ import com.filenet.api.query.SearchScope;
/*     */ import com.filenet.api.util.UserContext;
/*     */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.vdb.LNPContDBSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPContSet;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import javax.security.auth.Subject;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class CEConectionEDU
/*     */ {
/*     */   private static java.sql.Connection dbConn;
/*     */   private static com.filenet.api.core.Connection conn;
/*     */   private static Domain domain;
/*     */   private static ObjectStore os;
/*     */   private ObjectStoreSet OStoreSet;
/*     */ 
/*     */   public CEConectionEDU()
/*     */   {
/*     */     try
/*     */     {
/*  42 */       if ((dbConn == null) || (dbConn.isClosed())) {
/*  43 */         System.out.println("~~~~~~~~~~~~~~~~~dburl:" + CEConfiguration.dbURL + "~~dbNM:" + CEConfiguration.dbUsername + "~~~~~~~~dbPWD:" + CEConfiguration.dbPassword);
/*  44 */         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
/*  45 */         dbConn = DriverManager.getConnection(CEConfiguration.dbURL, CEConfiguration.dbUsername, CEConfiguration.dbPassword);
/*     */       }
/*     */     } catch (Exception e) {
/*  48 */       System.out.println("erro is because of:constracotr CEconnectionEDU");
/*  49 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static com.filenet.api.core.Connection getCEConnEDU() {
/*  54 */     conn = Factory.Connection.getConnection(CEConfiguration.CEUri);
/*     */ 
/*  56 */     Subject subject = UserContext.createSubject(conn, CEConfiguration.User, CEConfiguration.Password, "FileNetP8WSI");
/*     */ 
/*  58 */     UserContext uc = UserContext.get();
/*  59 */     uc.pushSubject(subject);
/*     */ 
/*  61 */     return conn;
/*     */   }
/*     */ 
/*     */   public static Domain getDomainEDU(com.filenet.api.core.Connection conn) {
/*  65 */     domain = Factory.Domain.fetchInstance(conn, CEConfiguration.DomainName, null);
/*     */ 
/*  67 */     return domain;
/*     */   }
/*     */ 
/*     */   public static ObjectStore getDefObjectStoreEDU() {
/*     */     try {
/*  72 */       getDomainEDU(getCEConnEDU());
/*  73 */       os = Factory.ObjectStore.fetchInstance(domain, CEConfiguration.OsName, null);
/*     */     }
/*     */     catch (Exception e) {
/*  76 */       System.out.println("~~~errMSG:" + e.getLocalizedMessage());
/*  77 */       e.printStackTrace();
/*     */     }
/*  79 */     return os;
/*     */   }
/*     */   public ObjectStore getObjectStoreEDUByOSNm(String OSName) {
/*  82 */     ObjectStore store = null;
/*  83 */     getObjectStroeSet();
/*  84 */     Iterator iterator = this.OStoreSet.iterator();
/*  85 */     while (iterator.hasNext()) {
/*  86 */       store = (ObjectStore)iterator.next();
/*  87 */       if ((store != null) && (store.get_Name().equals(OSName))) {
/*  88 */         return store;
/*     */       }
/*     */     }
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */   public ObjectStoreSet getObjectStroeSet() {
/*  95 */     this.OStoreSet = domain.get_ObjectStores();
/*  96 */     return this.OStoreSet;
/*     */   }
/*     */ 
/*     */   public static RepositoryRowSet ExcVQL(String sql) {
/* 100 */     RepositoryRowSet ResultSet = null;
/*     */     try
/*     */     {
/* 103 */       System.out.println("~~~~~~~~~~~~~ExcVQL:" + sql);
/* 104 */       SearchSQL searchSQL = new SearchSQL();
/* 105 */       searchSQL.setQueryString(sql);
/* 106 */       getDefObjectStoreEDU();
/* 107 */       SearchScope sqlObject = new SearchScope(os);
/* 108 */       ResultSet = sqlObject.fetchRows(searchSQL, null, null, null);
/*     */     } catch (Exception e) {
/* 110 */       e.printStackTrace();
/*     */     }
/* 112 */     return ResultSet;
/*     */   }
/*     */ 
/*     */   public static boolean isExistsImgPieces(RepositoryRowSet ResultSet) {
/* 116 */     return (ResultSet != null) && (!ResultSet.isEmpty());
/*     */   }
/*     */ 
/*     */   public void turnMsg()
/*     */   {
/*     */     try {
/* 122 */       long startTime = System.currentTimeMillis();
/* 123 */       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~start time:" + startTime);
/* 124 */       String sql = "SELECT BranchCode,ScanTime,AppNo FROM NBDoc where ScanTime is not null";
/* 125 */       RepositoryRowSet rowSet = ExcVQL(sql);
/* 126 */       long endtime = System.currentTimeMillis();
/* 127 */       System.out.println(calHMS((endtime - startTime) / 1000L));
/* 128 */       LNPContDB db = new LNPContDB(dbConn);
/* 129 */       LNPContDBSet dbSet = new LNPContDBSet(dbConn);
/* 130 */       LNPContSet lnpSet = db.executeQuery("select * from lnpcont where OutPayFlag<>'Y' or OutPayFlag is null");
/* 131 */       Date date = new Date();
/* 132 */       String curDate = new SimpleDateFormat("yyyyMMdd").format(date);
/* 133 */       String curTime = new SimpleDateFormat("HH:mm:ss").format(date);
/* 134 */       for (int i = 1; i <= lnpSet.size(); i++) {
/* 135 */         LNPContSchema tSchema = lnpSet.get(i);
/* 136 */         for (Iterator iterator = rowSet.iterator(); iterator.hasNext(); ) {
/* 137 */           RepositoryRow row = (RepositoryRow)iterator.next();
/*     */ 
/* 139 */           String AppNo = (String)row.getProperties().getStringListValue("AppNo").get(0);
/* 140 */           if ((tSchema.getContNo() != null) && (tSchema.getContNo().equals(AppNo))) {
/* 141 */             lnpSet.get(i).setOutPayFlag("Y");
/* 142 */             lnpSet.get(i).setModifyDate(curDate);
/* 143 */             lnpSet.get(i).setModifyTime(curTime);
/* 144 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 148 */       dbSet.set(lnpSet);
/* 149 */       dbSet.update();
/* 150 */       long endTime = System.currentTimeMillis();
/* 151 */       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~endTime:" + endTime + " | totalTime:" + calHMS((endTime - startTime) / 1000L));
/*     */     } catch (Exception e) {
/* 153 */       e.printStackTrace();
/* 154 */       System.out.println("~~~~~~~~~~~~~~~~~~~~~turnMSG:" + e.getLocalizedMessage());
/*     */ 
/* 156 */       if (dbConn != null)
/*     */         try {
/* 158 */           dbConn.close();
/*     */         } catch (SQLException e) {
/* 160 */           dbConn = null;
/* 161 */           e.printStackTrace();
/*     */         }
/*     */     }
/*     */     finally
/*     */     {
/* 156 */       if (dbConn != null)
/*     */         try {
/* 158 */           dbConn.close();
/*     */         } catch (SQLException e) {
/* 160 */           dbConn = null;
/* 161 */           e.printStackTrace();
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   private String calHMS(long timeInSeconds)
/*     */   {
/* 268 */     long hours = timeInSeconds / 3600L;
/* 269 */     timeInSeconds -= hours * 3600L;
/* 270 */     long minutes = timeInSeconds / 60L;
/* 271 */     timeInSeconds -= minutes * 60L;
/* 272 */     long seconds = timeInSeconds;
/* 273 */     return hours + " hour(s) " + minutes + " minute(s) " + seconds + " second(s)";
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 306 */     String sql = "SELECT TOP 20 * FROM NBDoc where ScanTime is not null";
/* 307 */     RepositoryRowSet rowSet = ExcVQL(sql);
/* 308 */     for (Iterator iterator = rowSet.iterator(); iterator.hasNext(); ) {
/* 309 */       RepositoryRow row = (RepositoryRow)iterator.next();
/* 310 */       Properties props = row.getProperties();
/* 311 */       System.out.println("-----------------------------------///////////////////////////////////////////");
/* 312 */       for (Iterator iterator2 = props.iterator(); iterator2.hasNext(); ) {
/* 313 */         Object o = iterator2.next();
/* 314 */         System.out.println(o);
/*     */       }
/*     */     }
/* 317 */     System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Over");
/* 318 */     new CEConectionEDU().turnMsg();
/*     */   }
/*     */ 
/*     */   private static class CEConfiguration
/*     */   {
/*     */     private static final String URI = "URI";
/*     */     private static final String DOMAINNAME = "DOMAINNAME";
/*     */     private static final String USERNAME = "USERNAME";
/*     */     private static final String PWD = "PWD";
/*     */     private static final String OBJECT_STORE_NM = "OS_NM";
/*     */     private static final String XMLFILEPATH = "WEB-INF/config/dbconn/dbconnection.xml";
/* 175 */     private static String CEUri = "";
/* 176 */     private static String DomainName = "";
/* 177 */     private static String User = "";
/* 178 */     private static String Password = "";
/* 179 */     private static String OsName = "";
/* 180 */     private static String dbURL = "";
/* 181 */     private static String dbUsername = "";
/* 182 */     private static String dbPassword = "";
/* 183 */     private static String dbPort = "";
/* 184 */     private static String dbIP = "";
/* 185 */     private static String dbName = "";
/*     */ 
/*     */     static {
/* 188 */       initDBConfig();
/* 189 */       initCEConfig();
/* 190 */       System.out.println(" init SUCCESS");
/* 191 */       System.out.println(CEUri + "--" + DomainName + "--" + User + "--" + Password + "--" + OsName);
/*     */     }
/*     */ 
/*     */     private static void initCEConfig() {
/* 195 */       java.sql.Connection dbConn = null;
/*     */       try {
/* 197 */         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\u8DEFfinal prama");
/* 198 */         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
/* 199 */         dbConn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
/* 200 */         ExeSQL execSQL = new ExeSQL(dbConn);
/* 201 */         String sql = "select SysVarType,SysVarValue from LNPSysVar where sysvar like 'CE_ARGS%'";
/* 202 */         SSRS ssrs = execSQL.execSQL(sql);
/* 203 */         for (int i = 1; i <= ssrs.MaxRow; i++) {
/* 204 */           if ("URI".equalsIgnoreCase(ssrs.GetText(i, 1))) {
/* 205 */             CEUri = ssrs.GetText(i, 2);
/*     */           }
/* 208 */           else if ("DOMAINNAME".equalsIgnoreCase(ssrs.GetText(i, 1))) {
/* 209 */             DomainName = ssrs.GetText(i, 2);
/*     */           }
/* 212 */           else if ("USERNAME".equalsIgnoreCase(ssrs.GetText(i, 1))) {
/* 213 */             User = ssrs.GetText(i, 2);
/*     */           }
/* 216 */           else if ("PWD".equalsIgnoreCase(ssrs.GetText(i, 1))) {
/* 217 */             Password = ssrs.GetText(i, 2);
/*     */           }
/* 220 */           else if ("OS_NM".equalsIgnoreCase(ssrs.GetText(i, 1)))
/* 221 */             OsName = ssrs.GetText(i, 2);
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 226 */         System.out.println("erro is because of:initCEConfig CEconnectionEDU");
/* 227 */         e.printStackTrace();
/*     */ 
/* 229 */         if (dbConn != null)
/*     */           try {
/* 231 */             dbConn.close();
/*     */           } catch (SQLException e) {
/* 233 */             dbConn = null;
/* 234 */             e.printStackTrace();
/*     */           }
/*     */       }
/*     */       finally
/*     */       {
/* 229 */         if (dbConn != null)
/*     */           try {
/* 231 */             dbConn.close();
/*     */           } catch (SQLException e) {
/* 233 */             dbConn = null;
/* 234 */             e.printStackTrace();
/*     */           }
/*     */       }
/*     */     }
/*     */ 
/*     */     private static void initDBConfig()
/*     */     {
/*     */       try {
/* 242 */         File xmlFile = new File("WEB-INF/config/dbconn/dbconnection.xml");
/* 243 */         SAXReader saxReader = new SAXReader();
/* 244 */         Document doc = saxReader.read(xmlFile);
/* 245 */         Element root = doc.getRootElement();
/* 246 */         for (Iterator iter = root.elementIterator("database"); iter.hasNext(); ) {
/* 247 */           Element foo = (Element)iter.next();
/* 248 */           if ("bak".equals(foo.elementText("Useto"))) {
/* 249 */             dbUsername = foo.elementText("UserName");
/* 250 */             dbPassword = foo.elementText("PassWord");
/* 251 */             dbName = foo.elementText("DBName");
/* 252 */             dbPort = foo.elementText("Port");
/* 253 */             dbIP = foo.elementText("IP");
/* 254 */             dbURL = "jdbc:sqlserver://" + dbIP + "\\SQLEXPRESS:" + dbPort + ";databasename=" + dbName;
/* 255 */             break;
/*     */           }
/*     */         }
/*     */       } catch (Exception e) {
/* 259 */         System.out.println("erro is because of:initDBConfig CEconnectionEDU");
/* 260 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.CEConectionEDU
 * JD-Core Version:    0.6.0
 */