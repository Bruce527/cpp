/*     */ package com.sinosoft.banklns.lnsmodel.webservice.eai;
/*     */ 
/*     */ import com.sinosoft.banklns.lnsmodel.util.EAIPropertiesFromDB;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Arrays;
/*     */ import javax.xml.namespace.QName;
/*     */ import org.apache.axis.description.TypeDesc;
/*     */ import org.apache.axis.encoding.AnyContentType;
/*     */ import org.apache.axis.encoding.Deserializer;
/*     */ import org.apache.axis.encoding.Serializer;
/*     */ import org.apache.axis.encoding.ser.BeanDeserializer;
/*     */ import org.apache.axis.encoding.ser.BeanSerializer;
/*     */ import org.apache.axis.message.MessageElement;
/*     */ 
/*     */ public class ESBEnvelopeMsgBody
/*     */   implements Serializable, AnyContentType
/*     */ {
/*     */   private MessageElement[] _any;
/*  35 */   private Object __equalsCalc = null;
/*     */ 
/*  54 */   private boolean __hashCodeCalc = false;
/*     */ 
/*  78 */   private static TypeDesc typeDesc = new TypeDesc(ESBEnvelopeMsgBody.class, true);
/*     */ 
/*     */   static {
/*  81 */     typeDesc.setXmlType(new QName(EAIPropertiesFromDB.ESBEnvelope_ns, ">>ESBEnvelope>MsgBody"));
/*     */   }
/*     */ 
/*     */   public ESBEnvelopeMsgBody()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ESBEnvelopeMsgBody(MessageElement[] _any)
/*     */   {
/*  20 */     this._any = _any;
/*     */   }
/*     */ 
/*     */   public MessageElement[] get_any()
/*     */   {
/*  26 */     return this._any;
/*     */   }
/*     */ 
/*     */   public void set_any(MessageElement[] _any)
/*     */   {
/*  32 */     this._any = _any;
/*     */   }
/*     */ 
/*     */   public synchronized boolean equals(Object obj)
/*     */   {
/*  37 */     if (!(obj instanceof ESBEnvelopeMsgBody)) return false;
/*  38 */     ESBEnvelopeMsgBody other = (ESBEnvelopeMsgBody)obj;
/*  39 */     if (obj == null) return false;
/*  40 */     if (this == obj) return true;
/*  41 */     if (this.__equalsCalc != null) {
/*  42 */       return this.__equalsCalc == obj;
/*     */     }
/*  44 */     this.__equalsCalc = obj;
/*     */ 
/*  46 */     boolean _equals = 
/*  47 */       ((this._any == null) && (other.get_any() == null)) || (
/*  48 */       (this._any != null) && 
/*  49 */       (Arrays.equals(this._any, other.get_any())));
/*  50 */     this.__equalsCalc = null;
/*  51 */     return _equals;
/*     */   }
/*     */ 
/*     */   public synchronized int hashCode()
/*     */   {
/*  56 */     if (this.__hashCodeCalc) {
/*  57 */       return 0;
/*     */     }
/*  59 */     this.__hashCodeCalc = true;
/*  60 */     int _hashCode = 1;
/*  61 */     if (get_any() != null) {
/*  62 */       for (int i = 0; 
/*  63 */         i < Array.getLength(get_any()); )
/*     */       {
/*  65 */         Object obj = Array.get(get_any(), i);
/*  66 */         if ((obj != null) && 
/*  67 */           (!obj.getClass().isArray()))
/*  68 */           _hashCode += obj.hashCode();
/*  64 */         i++;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  72 */     this.__hashCodeCalc = false;
/*  73 */     return _hashCode;
/*     */   }
/*     */ 
/*     */   public static TypeDesc getTypeDesc()
/*     */   {
/*  86 */     return typeDesc;
/*     */   }
/*     */ 
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/*  94 */     return 
/*  95 */       new BeanSerializer(
/*  96 */       _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/* 104 */     return 
/* 105 */       new BeanDeserializer(
/* 106 */       _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeMsgBody
 * JD-Core Version:    0.6.0
 */