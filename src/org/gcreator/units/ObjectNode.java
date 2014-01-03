/*    */ package org.gcreator.units;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ import org.gcreator.fileclass.GObject;
/*    */ 
/*    */ public class ObjectNode extends DefaultMutableTreeNode
/*    */   implements Serializable
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public GObject object;
/*    */ 
/*    */   public ObjectNode(GObject object)
/*    */   {
/* 26 */     super(object.name);
/* 27 */     this.object = object;
/* 28 */     object.setObjectNode(this);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.units.ObjectNode
 * JD-Core Version:    0.6.2
 */