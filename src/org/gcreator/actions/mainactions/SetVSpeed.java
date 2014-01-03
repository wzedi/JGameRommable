/*    */ package org.gcreator.actions.mainactions;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JTextField;
/*    */ import org.gcreator.actions.Action;
/*    */ import org.gcreator.actions.ActionPattern;
/*    */ import org.gcreator.actions.components.VSpeedEditor;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class SetVSpeed extends ActionPattern
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 23 */   public String to = "0"; public String with = "this";
/*    */ 
/* 25 */   public static ImageIcon icon = new ImageIcon(SetVSpeed.class.getResource("/org/gcreator/actions/images/hspeed.png"));
/*    */ 
/*    */   public void load(JComponent panel)
/*    */   {
/* 37 */     ((VSpeedEditor)panel).to.setText(this.to);
/* 38 */     ((VSpeedEditor)panel).of.setText(this.with);
/*    */   }
/*    */ 
/*    */   public void save(JComponent panel)
/*    */   {
/* 44 */     this.to = ((VSpeedEditor)panel).to.getText();
/* 45 */     this.with = ((VSpeedEditor)panel).of.getText();
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
/* 60 */     return new VSpeedEditor();
/*    */   }
/*    */ 
/*    */   public String getStandardText(JComponent panel) {
/* 64 */     if ((panel != null) && ((panel instanceof VSpeedEditor))) {
/* 65 */       save(panel);
/* 66 */       VSpeedEditor editor = (VSpeedEditor)panel;
/* 67 */       String who = editor.of.getText();
/* 68 */       if (who == null)
/* 69 */         who = "null";
/* 70 */       String what = editor.to.getText();
/* 71 */       if (what == null)
/* 72 */         what = "null";
/* 73 */       return LangSupporter.activeLang.getEntry(226).replaceAll("\\$apply", who).replaceAll("\\$value", what).replaceAll("\\$\\$", "$");
/*    */     }
/*    */ 
/* 77 */     return LangSupporter.activeLang.getEntry(225);
/*    */   }
/*    */ 
/*    */   public String generateGCL(JComponent panel) {
/* 81 */     if ((panel != null) && ((panel instanceof VSpeedEditor))) {
/* 82 */       VSpeedEditor editor = (VSpeedEditor)panel;
/* 83 */       save(panel);
/* 84 */       return "(" + editor.of.getText() + ").vspeed = " + editor.to.getText() + ";";
/*    */     }
/* 86 */     return "";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.mainactions.SetVSpeed
 * JD-Core Version:    0.6.2
 */