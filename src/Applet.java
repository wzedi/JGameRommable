/*    */ import java.awt.BorderLayout;
/*    */ import javax.swing.JLabel;
/*    */ import org.gcreator.core.gcreator;
/*    */ 
/*    */ public class Applet extends java.applet.Applet
/*    */ {
/*    */   private JLabel jLabel1;
/*    */ 
/*    */   public void init()
/*    */   {
/* 28 */     initComponents();
/* 29 */     gcreator.__main(null, false, true);
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 40 */     this.jLabel1 = new JLabel();
/*    */ 
/* 42 */     setLayout(new BorderLayout());
/*    */ 
/* 44 */     this.jLabel1.setText("G-Creator should now popup");
/* 45 */     add(this.jLabel1, "West");
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     Applet
 * JD-Core Version:    0.6.2
 */