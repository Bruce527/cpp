/*     */ package com.sinosoft.banklns.lnsmodel.util;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.jdom.Attribute;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ 
/*     */ public class JSONUtil
/*     */ {
/*     */   public static JSONObject xml2JSON(Document doc)
/*     */   {
/*  28 */     JSONObject obj = new JSONObject();
/*     */     try
/*     */     {
/*  31 */       Element root = doc.getRootElement();
/*  32 */       obj.put(root.getName(), iterateElement(root));
/*  33 */       return obj;
/*     */     } catch (Exception e) {
/*  35 */       e.printStackTrace();
/*  36 */     }return null;
/*     */   }
/*     */ 
/*     */   private static Map iterateElement(Element root)
/*     */   {
/*  42 */     List jiedian = root.getChildren();
/*  43 */     Element et = null;
/*  44 */     Map map = new HashMap();
/*  45 */     List list = null;
/*     */ 
/*  47 */     List attributes = root.getAttributes();
/*  48 */     for (int i = 0; i < attributes.size(); i++) {
/*  49 */       map.put(((Attribute)attributes.get(i)).getName(), ((Attribute)attributes.get(i)).getValue());
/*     */     }
/*     */ 
/*  52 */     for (int i = 0; i < jiedian.size(); i++) {
/*  53 */       list = new LinkedList();
/*  54 */       et = (Element)jiedian.get(i);
/*     */ 
/*  56 */       if (et.getTextTrim().equals("")) {
/*  57 */         if (et.getChildren().size() == 0)
/*     */         {
/*     */           continue;
/*     */         }
/*  61 */         if (map.containsKey(et.getName())) {
/*  62 */           list.add(map.get(et.getName()));
/*     */         }
/*     */ 
/*  65 */         list.add(iterateElement(et));
/*  66 */         if (list.size() > 1)
/*  67 */           map.put(et.getName(), list);
/*     */         else
/*  69 */           map.put(et.getName(), list.get(0));
/*     */       }
/*     */       else
/*     */       {
/*  73 */         List temp_att = et.getAttributes();
/*     */ 
/*  75 */         if (temp_att.size() != 0) {
/*  76 */           Map childMap = new HashMap();
/*  77 */           for (int j = 0; j < temp_att.size(); j++) {
/*  78 */             childMap.put(((Attribute)temp_att.get(j)).getName(), ((Attribute)temp_att.get(j)).getValue());
/*     */           }
/*  80 */           childMap.put("content", et.getTextTrim());
/*  81 */           map.put(et.getName(), childMap);
/*     */         } else {
/*  83 */           if (map.containsKey(et.getName())) {
/*     */             try
/*     */             {
/*  86 */               list = (List)map.get(et.getName());
/*     */             } catch (Exception e) {
/*  88 */               list.add(map.get(et.getName()));
/*     */             }
/*     */           }
/*  91 */           list.add(et.getTextTrim());
/*  92 */           if (list.size() > 1)
/*  93 */             map.put(et.getName(), list);
/*     */           else {
/*  95 */             map.put(et.getName(), list.get(0));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 101 */     return map;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.util.JSONUtil
 * JD-Core Version:    0.6.0
 */