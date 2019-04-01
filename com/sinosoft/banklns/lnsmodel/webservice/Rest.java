/*     */ package com.sinosoft.banklns.lnsmodel.webservice;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPContSet;
/*     */ import java.io.PrintStream;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @RequestMapping({"/api"})
/*     */ public class Rest
/*     */ {
/*     */   @PostMapping(value={"/GET_POLICYNO.V1"}, produces={"application/json;charset=UTF-8"})
/*     */   public String getPolicyNo(@RequestBody String json)
/*     */   {
/*  52 */     JSONObject returnJson = new JSONObject();
/*  53 */     JSONObject jsonObject = JSONObject.parseObject(json);
/*  54 */     JSONArray RequestBody = (JSONArray)jsonObject.get("REQUESTBODY");
/*  55 */     int status = 0;
/*  56 */     String describtionString = "";
/*  57 */     String contNo = "";
/*  58 */     String policyNo = "";
/*     */     try
/*     */     {
/*  61 */       if (RequestBody != null)
/*     */       {
/*  63 */         JSONObject contnojson = RequestBody.getJSONObject(0);
/*  64 */         contNo = contnojson.getString("CONTNO");
/*  65 */         if (contNo != null)
/*     */         {
/*  68 */           System.out.println("\u8F93\u5165\u62A5\u6587\uFF1A" + jsonObject);
/*  69 */           System.out.println("---------\u540C\u6B65\u6295\u4FDD\u5355\uFF1A" + contNo);
/*     */ 
/*  71 */           if (!"".equals(contNo))
/*     */           {
/*  73 */             policyNo = getPlicyNoByCont(contNo);
/*     */ 
/*  77 */             if (("".equals(policyNo)) || (policyNo == null)) {
/*  78 */               status = -1;
/*  79 */               describtionString = contNo + "\u672A\u67E5\u8BE2\u5230\u4FDD\u5355\u53F7\uFF01";
/*     */             } else {
/*  81 */               status = 0;
/*     */             }
/*     */           } else {
/*  84 */             status = -2;
/*  85 */             describtionString = "\u6295\u4FDD\u5355\u53F7\u4E3A\u7A7A\uFF01";
/*     */           }
/*     */         } else {
/*  88 */           status = -3;
/*  89 */           describtionString = "\u8F93\u5165\u62A5\u6587\u683C\u5F0F\u6709\u8BEF\uFF01";
/*     */         }
/*     */       }
/*     */       else {
/*  93 */         status = -3;
/*  94 */         describtionString = "\u8F93\u5165\u62A5\u6587\u683C\u5F0F\u6709\u8BEF\uFF01";
/*     */       }
/*     */ 
/*  98 */       returnJson.put("MDES_RETURN_STATUS", Integer.valueOf(status));
/*  99 */       if (status != 0) {
/* 100 */         returnJson.put("DESCRIBTION", describtionString);
/*     */       } else {
/* 102 */         returnJson.put("CONTNO", contNo);
/* 103 */         returnJson.put("POLICY_NO", policyNo);
/*     */       }
/*     */     } catch (Exception e) {
/* 106 */       System.out.println("\u6587\u4EF6\u9519\u8BEF\uFF01");
/* 107 */       e.printStackTrace();
/*     */     }
/* 109 */     System.out.println("\u8FD4\u56DE\u62A5\u6587" + returnJson.toJSONString());
/* 110 */     return returnJson.toJSONString();
/*     */   }
/*     */ 
/*     */   private String getPlicyNoByCont(String contNo)
/*     */   {
/* 118 */     LNPContDB tContBDB = new LNPContDB();
/* 119 */     tContBDB.setContNo(contNo);
/* 120 */     LNPContSet tcontDBSet = tContBDB.query();
/* 121 */     String mainPolNo = "";
/* 122 */     if (tcontDBSet.size() > 0) {
/* 123 */       mainPolNo = tcontDBSet.get(1).getMainPolNo();
/*     */     }
/*     */ 
/* 126 */     return mainPolNo;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 130 */     Rest rest = new Rest();
/* 131 */     String mainpolNoString = rest.getPlicyNoByCont("201711220922");
/* 132 */     System.out.println(mainpolNoString);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.webservice.Rest
 * JD-Core Version:    0.6.0
 */