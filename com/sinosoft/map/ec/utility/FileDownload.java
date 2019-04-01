/*    */ package com.sinosoft.map.ec.utility;
/*    */ 
/*    */ import com.sinosoft.map.lis.excel.ExcelInfo;
/*    */ import com.sinosoft.map.lis.excel.ReportHelper;
/*    */ import java.io.IOException;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class FileDownload
/*    */ {
/*    */   public static String downloadExcel(ReportHelper helper)
/*    */   {
/* 19 */     ExcelInfo info = helper.getInfo();
/*    */ 
/* 21 */     FacesContext context = FacesContext.getCurrentInstance();
/* 22 */     HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
/* 23 */     response.reset();
/* 24 */     response.setContentType("application/OCTET-STREAM");
/*    */     try
/*    */     {
/* 27 */       response.setHeader("Content-disposition", "attachment;filename=" + new String("Excel.xls".getBytes(), "iso-8859-1"));
/*    */ 
/* 29 */       ReportHelper.download(response.getOutputStream(), info.getReportPath());
/*    */     }
/*    */     catch (UnsupportedEncodingException e1)
/*    */     {
/* 33 */       e1.printStackTrace();
/*    */     }
/*    */     catch (IOException e)
/*    */     {
/* 37 */       e.printStackTrace();
/*    */     }
/*    */     finally
/*    */     {
/* 41 */       context.responseComplete();
/*    */     }
/* 43 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.ec.utility.FileDownload
 * JD-Core Version:    0.6.0
 */