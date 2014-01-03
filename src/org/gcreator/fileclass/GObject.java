/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.gcreator.units.ObjectNode;
/*    */ 
/*    */ public class GObject
/*    */   implements Serializable
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public String name;
/*    */   public ObjectNode node;
/* 40 */   public boolean editable = true;
/*    */ 
/*    */   public GObject()
/*    */   {
/*    */   }
/*    */ 
/*    */   public GObject(String name)
/*    */   {
/* 29 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public void setObjectNode(ObjectNode node) {
/* 33 */     this.node = node;
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 37 */     return "Object";
/*    */   }
/*    */ 
/*    */   public GObject clone()
/*    */   {
/* 45 */     GObject o = new GObject(this.name);
/* 46 */     o.node = ((ObjectNode)this.node.clone());
/* 47 */     return o;
/*    */   }
/*    */ 
/*    */   public String getPath() {
/* 51 */     return this.name;
/*    */   }
/*    */ 
/*    */   public Project getProject() {
/* 55 */     return null;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.GObject
 * JD-Core Version:    0.6.2
 */