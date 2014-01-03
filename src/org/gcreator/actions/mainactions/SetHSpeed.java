/*    */ package org.gcreator.actions.mainactions;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JTextField;
/*    */ import org.gcreator.actions.Action;
/*    */ import org.gcreator.actions.ActionPattern;
/*    */ import org.gcreator.actions.components.HSpeedEditor;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class SetHSpeed extends ActionPattern
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 23 */   public String to = "0"; public String with = "this";
/*    */ 
/* 25 */   public static ImageIcon icon = new ImageIcon(SetHSpeed.class.getResource("/org/gcreator/actions/images/hspeed.png"));
/*    */ 
/*    */   public void load(JComponent panel)
/*    */   {
/* 37 */     ((HSpeedEditor)panel).to.setText(this.to);
/* 38 */     ((HSpeedEditor)panel).of.setText(this.with);
/*    */   }
/*    */ 
/*    */   public void save(JComponent panel)
/*    */   {
/* 44 */     this.to = ((HSpeedEditor)panel).to.getText();
/* 45 */     this.with = ((HSpeedEditor)panel).of.getText();
/*    */   }
/*    */ 
/*    */   public ImageIcon getStandardImage()
/*    */   {
/* 52 */     return icon;
/*    */   }
/*    */ 
/*    */   public void setStandardImage(ImageIcon img) {
/* 56 */     icon = img;
/*    */   }
/*    */ 
/*    */   public JComponent createNewPanel(Action action, Project project) {
/* 60 */     return new HSpeedEditor();
/*    */   }
/*    */ 
/*    */   public String getStandardText(JComponent panel) {
/* 64 */     if ((panel != null) && ((panel instanceof HSpeedEditor))) {
/* 65 */       save(panel);
/* 66 */       HSpeedEditor editor = (HSpeedEditor)panel;
/* 67 */       String who = editor.of.getText();
/* 68 */       if (who == null)
/* 69 */         who = "null";
/* 70 */       String what = editor.to.getText();
/* 71 */       if (what == null)
/* 72 */         what = "null";
/* 73 */       return LangSupporter.activeLang.getEntry(224).replaceAll("\\$apply", who).replaceAll("\\$value", what).replaceAll("\\$\\$", "$");
/*    */     }
/*    */ 
/* 77 */     return LangSupporter.activeLang.getEntry(223);
/*    */   }
/*    */ 
/*    */   public String generateGCL(JComponent panel) {
/* 81 */     if ((panel != null) && ((panel instanceof HSpeedEditor))) {
/* 82 */       HSpeedEditor editor = (HSpeedEditor)panel;
/* 83 */       save(panel);
/* 84 */       return "(" + editor.of.getText() + ").hspeed = " + editor.to.getText() + ";";
/*    */     }
/* 86 */     return "";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.mainactions.SetHSpeed
 * JD-Core Version:    0.6.2
 */