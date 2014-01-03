/*    */ package org.gcreator.fileclass.res;
/*    */ 
/*    */ import java.util.Vector;
/*    */ import org.gcreator.units.StructureField;
/*    */ 
/*    */ public class Structure extends Resource
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 17 */   public Vector<StructureField> structures = new Vector();
/*    */ 
/*    */   public Resource clone() {
/* 20 */     Structure res = new Structure();
/* 21 */     for (StructureField field : res.structures)
/* 22 */       res.structures.add(field.clone());
/* 23 */     return res;
/*    */   }
/*    */ 
/*    */   public String exportToHtml(boolean xhtml) {
/* 27 */     return "";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.Structure
 * JD-Core Version:    0.6.2
 */