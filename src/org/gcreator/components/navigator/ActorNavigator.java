/*    */ package org.gcreator.components.navigator;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.JEditorPane;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.res.Actor;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ 
/*    */ public class ActorNavigator extends JPanel
/*    */ {
/*    */   private GFile actor;
/*    */   private JEditorPane jEditorPane1;
/*    */   private JScrollPane jScrollPane1;
/*    */ 
/*    */   public ActorNavigator(GFile actor)
/*    */   {
/* 20 */     this.actor = actor;
/* 21 */     initComponents();
/*    */   }
/*    */   public Actor getActor() {
/* 24 */     if (this.actor == null)
/* 25 */       return null;
/* 26 */     Object o = this.actor.value;
/* 27 */     if ((o != null) && ((o instanceof Actor)))
/* 28 */       return (Actor)o;
/* 29 */     return null;
/*    */   }
/*    */ 
/*    */   public String getHTML() {
/* 33 */     System.out.println("get HTML");
/* 34 */     Actor actor = getActor();
/* 35 */     if (actor == null) {
/* 36 */       return "<b><font color='red'>Invalid Actor</font></b>";
/*    */     }
/* 38 */     String result = "<b>Name:</b> ";
/* 39 */     result = result + actor.name;
/* 40 */     result = result + "<br/><b>Extends:</b> ";
/* 41 */     result = result + actor.extend;
/* 42 */     result = result + "<br/><b>Sprite:</b> ";
/* 43 */     result = result + actor.sprite;
/* 44 */     result = result + "<br/><b>Mask:</b> ";
/* 45 */     result = result + actor.mask;
/* 46 */     result = result + "<br/><b>Depth:</b> ";
/* 47 */     result = result + actor.depth;
/* 48 */     result = result + "<br/><b>Solid:</b> ";
/* 49 */     result = result + (actor.solid ? "True" : "False");
/* 50 */     result = result + "<br/><b>Visible:</b>: ";
/* 51 */     result = result + (actor.visible ? "True" : "False");
/* 52 */     result = result + "<br/><b>Persistent</b> ";
/* 53 */     result = result + (actor.persistant ? "True" : "False");
/* 54 */     return result;
/*    */   }
/*    */ 
/*    */   public void updateUI() {
/* 58 */     System.out.println("update UI");
/* 59 */     super.updateUI();
/*    */     try {
/* 61 */       this.jEditorPane1.setText(getHTML());
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/*    */     }
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 74 */     this.jScrollPane1 = new JScrollPane();
/* 75 */     this.jEditorPane1 = new JEditorPane();
/*    */ 
/* 77 */     this.jEditorPane1.setContentType("text/html");
/* 78 */     this.jEditorPane1.setEditable(false);
/* 79 */     this.jEditorPane1.setText(getHTML());
/* 80 */     this.jScrollPane1.setViewportView(this.jEditorPane1);
/*    */ 
/* 82 */     GroupLayout layout = new GroupLayout(this);
/* 83 */     setLayout(layout);
/* 84 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 400, 32767));
/*    */ 
/* 88 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 300, 32767));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.navigator.ActorNavigator
 * JD-Core Version:    0.6.2
 */