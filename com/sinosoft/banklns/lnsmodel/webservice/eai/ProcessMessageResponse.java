/*     */ package com.sinosoft.banklns.lnsmodel.webservice.eai;
/*     */ 
/*     */ import com.sinosoft.banklns.lnsmodel.util.EAIPropertiesFromDB;
/*     */ import java.io.Serializable;
/*     */ import javax.xml.namespace.QName;
/*     */ import org.apache.axis.description.ElementDesc;
/*     */ import org.apache.axis.description.TypeDesc;
/*     */ import org.apache.axis.encoding.Deserializer;
/*     */ import org.apache.axis.encoding.Serializer;
/*     */ import org.apache.axis.encoding.ser.BeanDeserializer;
/*     */ import org.apache.axis.encoding.ser.BeanSerializer;
/*     */ 
/*     */ public class ProcessMessageResponse
/*     */   implements Serializable
/*     */ {
/*     */   private ESBEnvelopeResult ESBEnvelopeResult;
/*  35 */   private Object __equalsCalc = null;
/*     */ 
/*  54 */   private boolean __hashCodeCalc = false;
/*     */ 
/*  70 */   private static TypeDesc typeDesc = new TypeDesc(ProcessMessageResponse.class, true);
/*     */ 
/*     */   static {
/*  73 */     typeDesc.setXmlType(new QName(EAIPropertiesFromDB.ProcessMessage_ns, ">ProcessMessageResponse"));
/*  74 */     ElementDesc elemField = new ElementDesc();
/*  75 */     elemField.setFieldName("ESBEnvelopeResult");
/*  76 */     elemField.setXmlName(new QName(EAIPropertiesFromDB.ESBEnvelope_ns, "ESBEnvelopeResult"));
/*  77 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.ESBEnvelope_ns, ">ESBEnvelopeResult"));
/*  78 */     elemField.setMinOccurs(0);
/*  79 */     elemField.setNillable(false);
/*  80 */     typeDesc.addFieldDesc(elemField);
/*     */   }
/*     */ 
/*     */   public ProcessMessageResponse()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ProcessMessageResponse(ESBEnvelopeResult ESBEnvelopeResult)
/*     */   {
/*  20 */     this.ESBEnvelopeResult = ESBEnvelopeResult;
/*     */   }
/*     */ 
/*     */   public ESBEnvelopeResult getESBEnvelopeResult()
/*     */   {
/*  26 */     return this.ESBEnvelopeResult;
/*     */   }
/*     */ 
/*     */   public void setESBEnvelopeResult(ESBEnvelopeResult ESBEnvelopeResult)
/*     */   {
/*  32 */     this.ESBEnvelopeResult = ESBEnvelopeResult;
/*     */   }
/*     */ 
/*     */   public synchronized boolean equals(Object obj)
/*     */   {
/*  37 */     if (!(obj instanceof ProcessMessageResponse)) return false;
/*  38 */     ProcessMessageResponse other = (ProcessMessageResponse)obj;
/*  39 */     if (obj == null) return false;
/*  40 */     if (this == obj) return true;
/*  41 */     if (this.__equalsCalc != null) {
/*  42 */       return this.__equalsCalc == obj;
/*     */     }
/*  44 */     this.__equalsCalc = obj;
/*     */ 
/*  46 */     boolean _equals = 
/*  47 */       ((this.ESBEnvelopeResult == null) && (other.getESBEnvelopeResult() == null)) || (
/*  48 */       (this.ESBEnvelopeResult != null) && 
/*  49 */       (this.ESBEnvelopeResult.equals(other.getESBEnvelopeResult())));
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
/*  61 */     if (getESBEnvelopeResult() != null) {
/*  62 */       _hashCode += getESBEnvelopeResult().hashCode();
/*     */     }
/*  64 */     this.__hashCodeCalc = false;
/*  65 */     return _hashCode;
/*     */   }
/*     */ 
/*     */   public static TypeDesc getTypeDesc()
/*     */   {
/*  85 */     return typeDesc;
/*     */   }
/*     */ 
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/*  93 */     return 
/*  94 */       new BeanSerializer(
/*  95 */       _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/* 103 */     return 
/* 104 */       new BeanDeserializer(
/* 105 */       _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.webservice.eai.ProcessMessageResponse
 * JD-Core Version:    0.6.0
 */