/*    */ package org.gcreator.components.resource;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JComponent;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.gcreator.units.ObjectNode;
/*    */ 
/*    */ public class ResourceChooser extends JComponent
/*    */ {
/*    */   private FileLabel label;
/*    */ 
/*    */   public ResourceChooser(Project p, String key)
/*    */   {
/* 21 */     this.label = new FileLabel(p, key);
/*    */ 
/* 23 */     this.label.setVisible(true);
/*    */ 
/* 25 */     setLayout(new BorderLayout());
/* 26 */     add(this.label, "Center");
/*    */   }
/*    */ 
/*    */   public void setFile(GFile file) {
/* 30 */     this.label.setFile(file);
/*    */   }
/*    */ 
/*    */   public GFile getFile() {
/* 34 */     return this.label.getFile();
/*    */   }
/*    */ 
/*    */   public void addActionListener(ActionListener a) {
/* 38 */     this.label.addActionListener(a);
/*    */   }
/*    */ 
/*    */   /** @deprecated */
/*    */   public ObjectNode getCurrentObject()
/*    */   {
/* 45 */     GFile f = getFile();
/* 46 */     if (f == null)
/* 47 */       return null;
/* 48 */     return f.node;
/*    */   }
/*    */ 
/*    */   public Dimension getPreferredSize() {
/* 52 */     return new Dimension(100, 20);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.resource.ResourceChooser
 * JD-Core Version:    0.6.2
 */