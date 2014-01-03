/*     */ package org.gcreator.fileclass;
/*     */ 
/*     */ import java.awt.Image;
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.awt.datatransfer.UnsupportedFlavorException;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectOutput;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.ObjectStreamField;
/*     */ import java.io.PrintStream;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.ImageIcon;
/*     */ import org.gcreator.components.TabPanel;
/*     */ import org.gcreator.fileclass.res.Resource;
/*     */ import sun.awt.image.ToolkitImage;
/*     */ 
/*     */ public class GFile extends GObject
/*     */   implements Transferable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*  35 */   public static final DataFlavor NODE_FLAVOR = new DataFlavor("application/x-java-jvm-local-objectref", "Node");
/*  36 */   private static DataFlavor[] flavors = { NODE_FLAVOR };
/*     */   public Folder root;
/*     */   public String type;
/*     */   public TabPanel tabPanel;
/*     */   public Object value;
/*  42 */   public String xml = "";
/*     */ 
/*  44 */   private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField("type", String.class), new ObjectStreamField("value", Object.class) };
/*     */ 
/*     */   public GFile(Folder root, String name, String type, GObject value)
/*     */   {
/*  48 */     super(name);
/*  49 */     this.root = root;
/*  50 */     this.type = type;
/*  51 */     this.value = value;
/*  52 */     root.add(this);
/*     */   }
/*     */ 
/*     */   private GFile(String name, String type) {
/*  56 */     super(name);
/*  57 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getObjectType() {
/*  61 */     return "File";
/*     */   }
/*     */ 
/*     */   public void writeToBuffer(ZipOutputStream out)
/*     */     throws IOException
/*     */   {
/* 106 */     if (this.value != null)
/* 107 */       if ((this.value instanceof String)) {
/* 108 */         out.write(this.value.toString().getBytes());
/*     */       }
/* 115 */       else if ((this.value instanceof ImageIcon)) {
/* 116 */         ImageIcon img = (ImageIcon)this.value;
/* 117 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */ 
/* 119 */         BufferedImage ii = null;
/*     */         try {
/* 121 */           if ((img.getImage() instanceof ToolkitImage)) {
/* 122 */             System.out.println("Toolkit");
/* 123 */             ii = ((ToolkitImage)img.getImage()).getBufferedImage();
/*     */           }
/*     */           else {
/* 126 */             ii = (BufferedImage)img.getImage();
/*     */           }
/*     */         } catch (Exception e) {
/* 129 */           System.out.println("Exception " + e.getMessage());
/* 130 */           ii = (BufferedImage)img.getImage();
/*     */         }
/*     */ 
/* 133 */         ImageIO.write(ii, this.type, baos);
/* 134 */         out.write(baos.toByteArray());
/*     */       } else {
/* 136 */         ObjectOutput s = new ObjectOutputStream(out);
/* 137 */         s.writeObject(this.value);
/* 138 */         s.flush();
/*     */       }
/*     */   }
/*     */ 
/*     */   public static ImageIcon getScaledIcon(ImageIcon ii)
/*     */   {
/* 145 */     ImageIcon iii = new ImageIcon();
/* 146 */     if (ii != null) {
/* 147 */       Image i = ii.getImage().getScaledInstance(16, 16, 1);
/* 148 */       iii.setImage(i);
/* 149 */       return iii;
/*     */     }
/* 151 */     return null;
/*     */   }
/*     */ 
/*     */   public GObject clone() {
/* 155 */     GFile o = new GFile(this.name, this.type);
/* 156 */     if ((this.value instanceof Resource))
/* 157 */       o.value = ((Resource)this.value).clone();
/* 158 */     else if ((this.value instanceof ImageIcon))
/* 159 */       o.value = this.value;
/*     */     else {
/* 161 */       o.value = this.value;
/*     */     }
/* 163 */     return null;
/*     */   }
/*     */ 
/*     */   public DataFlavor[] getTransferDataFlavors() {
/* 167 */     return flavors;
/*     */   }
/*     */ 
/*     */   public boolean isDataFlavorSupported(DataFlavor flavor) {
/* 171 */     return flavor == NODE_FLAVOR;
/*     */   }
/*     */ 
/*     */   public GObject getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
/* 175 */     if (flavor != NODE_FLAVOR) {
/* 176 */       throw new UnsupportedFlavorException(flavor);
/*     */     }
/* 178 */     return this;
/*     */   }
/*     */ 
/*     */   public String getPath() {
/* 182 */     return this.root.getPath() + "/" + super.getPath();
/*     */   }
/*     */ 
/*     */   public Project getProject() {
/* 186 */     return this.root.getProject();
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.GFile
 * JD-Core Version:    0.6.2
 */