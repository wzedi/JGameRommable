/*    */ package org.gcreator.units;
/*    */ 
/*    */ public class StructureField
/*    */ {
/*    */   public String type;
/*    */   public String name;
/*    */   public String value;
/*    */   public boolean constructor;
/*    */ 
/*    */   public StructureField clone()
/*    */   {
/* 19 */     StructureField field = new StructureField();
/* 20 */     field.type = this.type;
/* 21 */     field.name = this.name;
/* 22 */     field.value = this.value;
/* 23 */     field.constructor = this.constructor;
/* 24 */     return field;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.units.StructureField
 * JD-Core Version:    0.6.2
 */