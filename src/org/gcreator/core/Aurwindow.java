/*      */ package org.gcreator.core;
/*      */ 
/*      */ import java.awt.BorderLayout;
/*      */ import java.awt.Component;
/*      */ import java.awt.Container;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Point;
/*      */ import java.awt.Robot;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.ComponentEvent;
/*      */ import java.awt.event.ComponentListener;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseListener;
/*      */ import java.awt.event.MouseMotionListener;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.util.Enumeration;
/*      */ import java.util.Iterator;
/*      */ import java.util.Vector;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;

/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JComponent;
/*      */ import javax.swing.JFileChooser;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JInternalFrame;
/*      */ import javax.swing.JLayeredPane;
/*      */ import javax.swing.JMenu;
/*      */ import javax.swing.JMenuBar;
/*      */ import javax.swing.JMenuItem;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSplitPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTextPane;
/*      */ import javax.swing.JToolBar;
/*      */ import javax.swing.event.ChangeEvent;
/*      */ import javax.swing.event.ChangeListener;
/*      */ import javax.swing.event.InternalFrameEvent;
/*      */ import javax.swing.event.InternalFrameListener;
/*      */ import javax.swing.tree.DefaultMutableTreeNode;
/*      */ import javax.swing.tree.TreePath;

/*      */ import net.iharder.dnd.FileDrop;

/*      */ import org.gcreator.components.ButtonTabComponent;
/*      */ import org.gcreator.components.ExtendedFrame;
/*      */ import org.gcreator.components.GlobalSettings;
/*      */ import org.gcreator.components.LanguageTab;
/*      */ import org.gcreator.components.MdiPane;
/*      */ import org.gcreator.components.NewFileGroup;
/*      */ import org.gcreator.components.NewProject;
/*      */ import org.gcreator.components.PlayMacroDialog;
/*      */ import org.gcreator.components.PluginDialog;
/*      */ import org.gcreator.components.PowerPackImporter;
/*      */ import org.gcreator.components.Statusbar;
/*      */ import org.gcreator.components.TabPanel;
/*      */ import org.gcreator.components.Updater;
/*      */ import org.gcreator.components.WorkspaceTree;
/*      */ import org.gcreator.components.custom.MenuGenerator;
/*      */ import org.gcreator.components.impl.CustomFileFilter;
/*      */ import org.gcreator.components.impl.WorkspaceCellRenderer;
/*      */ import org.gcreator.components.navigator.ActorNavigator;
/*      */ import org.gcreator.components.popupmenus.ConsolePopupMenu;
/*      */ import org.gcreator.components.popupmenus.PopupListener;
/*      */ import org.gcreator.components.popupmenus.ToolbarPopupMenu;
/*      */ import org.gcreator.editors.ActorEditor;
/*      */ import org.gcreator.editors.GCLEditor;
/*      */ import org.gcreator.editors.ImageEditor;
/*      */ import org.gcreator.editors.PlainTextEditor;
/*      */ import org.gcreator.editors.SceneEditor;
/*      */ import org.gcreator.editors.ScriptEditor;
/*      */ import org.gcreator.editors.SettingsEditor;
/*      */ import org.gcreator.editors.SoundEditor;
/*      */ import org.gcreator.editors.SpriteEditor;
/*      */ import org.gcreator.editors.StructureEditor;
/*      */ import org.gcreator.editors.TilesetEditor;
/*      */ import org.gcreator.editors.TimelineEditor;
/*      */ import org.gcreator.exceptions.WrongResourceException;
/*      */ import org.gcreator.externproject.ProjectExporter;
/*      */ import org.gcreator.externproject.ProjectImporter;
/*      */ import org.gcreator.externproject.StdImport;
/*      */ import org.gcreator.fileclass.Folder;
/*      */ import org.gcreator.fileclass.GFile;
/*      */ import org.gcreator.fileclass.GObject;
/*      */ import org.gcreator.fileclass.GameProject;
/*      */ import org.gcreator.fileclass.Group;
/*      */ import org.gcreator.fileclass.ModuleProject;
/*      */ import org.gcreator.fileclass.Project;
/*      */ import org.gcreator.help.AboutPanel;
/*      */ import org.gcreator.help.HelpPanel;
/*      */ import org.gcreator.macro.Macro;
/*      */ import org.gcreator.macro.MacroLibrary;
/*      */ import org.gcreator.macro.OpenFileAction;
/*      */ import org.gcreator.managers.LangSupporter;
/*      */ import org.gcreator.managers.MenuSupporter;
/*      */ import org.gcreator.managers.SettingsIO;
/*      */ import org.gcreator.managers.ToolbarManager;
/*      */ import org.gcreator.plugins.FileOpenListener;
/*      */ import org.gcreator.plugins.PanelSelectedListener;
/*      */ import org.gcreator.plugins.Plugger;
/*      */ import org.gcreator.refactoring.DeleteRefactorContext;
/*      */ import org.gcreator.refactoring.Refactorer;
/*      */ import org.gcreator.refactoring.RefactoringMethod;
/*      */ import org.gcreator.units.ObjectNode;
/*      */ import org.jdesktop.layout.GroupLayout;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Aurwindow extends JFrame
/*      */ {
/*      */   public DefaultMutableTreeNode top;
/*   46 */   public JMenuBar menubar = new JMenuBar();
/*   47 */   public JMenu[] menus = new JMenu[30];
/*   48 */   public JMenuItem[] items = new JMenuItem[900];
/*      */   public JSplitPane splitter1;
/*      */   public JSplitPane splitter2;
/*      */   public JTabbedPane navigatorTabs;
/*      */   public static JTabbedPane tabs;
/*      */   public int look;
/*      */   public boolean istabs;
/*      */   public static boolean showToolbars;
/*      */   public MdiPane mdi;
/*      */   public JTextPane console;
/*      */   public JScrollPane scroller;
/*      */   public static JToolBar tool;
/*      */   public static String lang;
/*      */   public static WorkspaceTree workspace;
/*      */   public static JScrollPane treescroll;
/*      */   private static Project mainProject;
/*      */   public ButtonGroup wtreepos;
/*      */   public ToolbarPopupMenu toolpopup;
/*      */   public ConsolePopupMenu consolepopup;
/*      */   public static GlobalSettings globalsettings;
/*      */   public static NewProject newproject;
/*      */   public static NewFileGroup newfilegroup;
/*      */   public static AboutPanel about;
/*      */   public Container topContainer;
/*      */   public Container bottomContainer;
/*      */   public Container leftContainer;
/*      */   public Container rightContainer;
/*      */   private ChangeListener changed;
/*      */   public Statusbar statusbar;
/*   79 */   public JLayeredPane layer = new JLayeredPane();
/*   80 */   private static boolean using = false;
/*   81 */   private Vector<FileOpenListener> listeners = new Vector<FileOpenListener>();
/*   82 */   private JPanel navroot = null;
/*   83 */   private JComponent nav = null;
/*   84 */   private Vector<PanelSelectedListener> psel = new Vector<PanelSelectedListener>();
/*      */   public static JPanel nofileselnavigator;
/*      */   public static JPanel unkresnav;
/*   87 */   private static boolean dragging = false;
/*   88 */   //private int tabsi = 0;
/*   89 */   public static JFileChooser chooseImage = new JFileChooser();
/*      */ 
/*      */   public boolean isWorkspaceLeft()
/*      */   {
/*   96 */     if (this.items[MenuSupporter.GenerateMenuItemId(15, 0)].isSelected()) {
/*   97 */       return true;
/*      */     }
/*   99 */     return false;
/*      */   }
/*      */ 
/*      */   public void deleteFile(GFile o)
/*      */   {
/*  105 */     System.out.println("Delete file");
/*  106 */     Folder root = o.root;
/*  107 */     ObjectNode node = o.node;
/*  108 */     o.node = null;
/*  109 */     node.object = null;
/*  110 */     node.removeFromParent();
/*  111 */     root.remove(o);
/*  112 */     Project p = o.getProject();
/*  113 */     Vector<GFile> files = new Vector<GFile>();
/*  114 */     getFilesFromTo(p.getChildren(), files);
/*  115 */     for (GFile file : files) {
/*  116 */       DeleteRefactorContext context = new DeleteRefactorContext(o, file);
/*  117 */       RefactoringMethod method = Refactorer.getRefactoringMethod(context);
/*  118 */       if (method != null) {
/*  119 */         method.refactor(context);
/*      */       }
/*      */     }
/*  122 */     if (o.tabPanel != null) {
/*  123 */       remove(o.tabPanel, o.tabPanel.frame);
/*      */     }
/*  125 */     workspace.updateUI();
/*      */   }
/*      */ 
/*      */   public void deleteGroup(Group o)
/*      */   {
/*  131 */     Folder root = o.root;
/*  132 */     ObjectNode node = o.node;
/*  133 */     o.node = null;
/*  134 */     node.removeFromParent();
/*  135 */     root.remove(o);
/*  136 */     Project p = o.getProject();
/*  137 */     Vector files = new Vector();
/*  138 */     getFilesFromTo(p.getChildren(), files);
/*  139 */     workspace.updateUI();
/*      */   }
/*      */ 
/*      */   private void closeAllTabs(DefaultMutableTreeNode node)
/*      */   {
/*  145 */     for (int i = 0; i < node.getChildCount(); i++) {
/*  146 */       ObjectNode on = (ObjectNode)node.getChildAt(i);
/*  147 */       GObject go = on.object;
/*      */ 
/*  149 */       if (!(go instanceof GFile)) {
/*  150 */         if ((go instanceof Folder)) {
/*  151 */           closeAllTabs(on);
/*      */         }
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*  158 */         GFile o = (GFile)go;
/*  159 */         if (o.tabPanel != null)
/*  160 */           remove(o.tabPanel, o.tabPanel.frame);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public void getFilesFromTo(Vector from, Vector<GFile> to)
/*      */   {
/*  168 */     for (Iterator i$ = from.iterator(); i$.hasNext(); ) { Object o = i$.next();
/*  169 */       if ((o instanceof GFile)) {
/*  170 */         to.add((GFile)o);
/*      */       }
/*  172 */       if ((o instanceof Folder))
/*  173 */         getFilesFromTo(((Folder)o).getChildren(), to);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void popupTreeMenu(MouseEvent e)
/*      */   {
/*  181 */     System.out.println("popup menu");
/*  182 */     if (!using)
/*      */       try {
/*  184 */         Robot robot = new Robot();
/*  185 */         robot.mousePress(16);
/*  186 */         robot.mouseRelease(16);
/*  187 */         using = true;
/*  188 */         robot.mousePress(4);
/*  189 */         return;
/*      */       }
/*      */       catch (Exception ex)
/*      */       {
/*      */       }
/*  194 */     MenuGenerator m = new MenuGenerator();
/*      */ 
/*  199 */     final GObject o = getCurrentObject();
/*  200 */     if (o == null)
/*      */       return;
/*      */     Object i;
/*  210 */     if ((o instanceof GFile)) {
/*  211 */       if (((GFile)o).root.allowsDelete(o)) {
/*  212 */         i = m.addMenuItem(246, new ImageIcon(getClass().getResource("/org/gcreator/resources/uiplus/delete_filegroup.png")));
/*      */ 
/*  214 */         MenuGenerator.addActionListener(i, new ActionListener()
/*      */         {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  217 */             Aurwindow.this.deleteFile((GFile)o);
/*      */           }
/*      */         });
/*      */       }
/*      */       else {
/*  222 */         i = m.addMenuItem(246, new ImageIcon(getClass().getResource("/org/gcreator/resources/uiplus/grayed_delete_filegroup.png")));
/*      */       }
/*      */     }
/*      */ 
/*  226 */     if ((o instanceof Group))
/*      */     {
/*  227 */       if (((Group)o).root.allowsDelete(o)) {
/*  228 */         i = m.addMenuItem(246, new ImageIcon(getClass().getResource("/org/gcreator/resources/uiplus/delete_filegroup.png")));
/*      */ 
/*  230 */         if (((Group)o).root.allowsDelete(o))
/*  231 */           MenuGenerator.addActionListener(i, new ActionListener()
/*      */           {
/*      */             public void actionPerformed(ActionEvent evt) {
/*  234 */               Aurwindow.this.deleteGroup((Group)o);
/*      */             }
/*      */           });
/*      */       }
/*      */       else
/*      */       {
/*  240 */         i = m.addMenuItem(246, new ImageIcon(getClass().getResource("/org/gcreator/resources/uiplus/grayed_delete_filegroup.png")), false);
/*      */       }
/*      */ 
/*  243 */       //Object k = m.addMenuItem(245, new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/addgroup.png")));
/*      */ 
/*  246 */       //MenuGenerator.addActionListener(k, new ActionListener() {
/*      */         //public void actionPerformed(ActionEvent e) {
/*  248 */           //Folder f = Aurwindow.this.getCurrentFolder();
/*  249 */           //int in = 1;
/*  250 */           //for (Iterator i$ = f.getChildren().iterator(); i$.hasNext(); ) { Object o = i$.next();
/*  251 */             //if (((GObject)o).name.equals("subgroup" + in)) {
/*  252 */               //in++;
/*      */             //}
/*      */ 
/*      */           //}
/*      */ 
/*  257 */           //Aurwindow.this.addGroup(f, f.newGroup("subgroup" + in));
/*      */         //}
/*      */       //});
/*      */     }
/*  261 */     if ((o instanceof Project)) {
/*  262 */       Object j = m.addMenuItem(245, new ImageIcon(getClass().getResource("/org/gcreator/resources/uiplus/close_project.png")));
/*      */ 
/*  264 */       MenuGenerator.addActionListener(j, new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*  267 */           Aurwindow.this.CloseProject((Project)o, true);
/*      */         }
/*      */ 
/*      */       });
/*      */     }
/*      */ 
/*  275 */     m.show(this, e.getX() + workspace.getLocationOnScreen().x, e.getY() + workspace.getLocationOnScreen().y);
/*  276 */     using = false;
/*      */   }
/*      */ 
/*      */   public Object getWindowListElementAt(int pos)
/*      */   {
/*  282 */     if (this.istabs) {
/*  283 */       if (tabs == null) {
/*  284 */         return null;
/*      */       }
/*  286 */       Component[] panels = tabs.getComponents();
/*  287 */       if ((panels[pos] instanceof TabPanel)) {
/*  288 */         return panels[pos];
/*      */       }
/*  290 */       return null;
/*      */     }
/*  292 */     return null;
/*      */   }
/*      */ 
/*      */   public int getWindowListSize()
/*      */   {
/*  299 */     if (this.istabs) {
/*  300 */       return tabs.getComponents().length - 1;
/*      */     }
/*  302 */     return 0;
/*      */   }
/*      */ 
/*      */   public void treeDoubleClicked(MouseEvent e)
/*      */   {
/*  310 */     if (e.getButton() == 1) {
/*  311 */       GObject obj = getCurrentObject();
/*  312 */       if ((obj instanceof GFile))
/*  313 */         Open((GFile)obj);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void Open(GFile file)
/*      */   {
/*  326 */     System.out.println("Open: " + file.name + "." + file.type);
/*  327 */     boolean found = false;
/*  328 */     int iii = 0;
/*  329 */     int foundloc = 0;
/*  330 */     file.type = file.type.toLowerCase();
/*  331 */     FileOpenListener listener = getFileEditor(file.type);
/*  332 */     ImageIcon img = ((WorkspaceCellRenderer)workspace.getCellRenderer()).getImageFor(file.node);
/*  333 */     if (listener != null) {
/*  334 */       listener.openNewFile(file, getCurrentProject(), img);
/*  335 */     } else if (file.type.equals("sprite"))
/*      */     {
/*  337 */       System.out.println("Sprite created");
/*      */ 
/*  350 */       TabPanel tp = new SpriteEditor(file, getCurrentProject());
/*  351 */       file.tabPanel = tp;
/*  352 */       addEWindow(tp, file.name, img);
/*  353 */     } else if (file.type.equals("actor"))
/*      */     {
/*      */       try
/*      */       {
/*  367 */         TabPanel tp = new ActorEditor(file, getCurrentProject());
/*  368 */         file.tabPanel = tp;
/*  369 */         addEWindow(tp, file.name, img);
/*      */       } catch (WrongResourceException e) {
/*      */       }
/*  372 */     } else if (file.type.equals("scene"))
/*      */     {
/*  385 */       TabPanel tp = new SceneEditor(file, getCurrentProject());
/*  386 */       file.tabPanel = tp;
/*  387 */       addEWindow(tp, file.name, img);
/*  388 */     } else if ((file.type.equals("egml")) || (file.type.equals("gcl"))) {
/*  389 */       TabPanel tp = new GCLEditor(file, getCurrentProject());
/*  390 */       file.tabPanel = tp;
/*  391 */       addEWindow(tp, file.name, img);
/*  392 */     } else if (file.type.equals("gs")) {
/*  393 */       TabPanel tp = new ScriptEditor(file, getCurrentProject());
/*  394 */       file.tabPanel = tp;
/*  395 */       addEWindow(tp, file.name, img);
/*  396 */     } else if (file.type.equals("struct")) {
/*  397 */       TabPanel tp = new StructureEditor(file, getCurrentProject());
/*  398 */       file.tabPanel = tp;
/*  399 */       addEWindow(tp, file.name, img);
/*  400 */     } else if ((file.type.equals("bmp")) || (file.type.equals("gif")) || (file.type.equals("jpg")) || (file.type.equals("jpeg")) || (file.type.equals("png")) || (file.type.equals("img"))) {
/*  401 */       TabPanel tp = new ImageEditor(file, getCurrentProject());
/*  402 */       file.tabPanel = tp;
/*  403 */       addEWindow(tp, file.name, img);
/*  404 */     } else if ((file.type.equals("wav")) || (file.type.equals("mid")) || (file.type.equals("ogg"))) {
/*  405 */       TabPanel tp = new SoundEditor(file, getCurrentProject());
/*  406 */       file.tabPanel = tp;
/*  407 */       addEWindow(tp, file.name, img);
/*  408 */     } else if (file.type.equals("settings")) {
/*  409 */       TabPanel tp = new SettingsEditor(getCurrentProject(), file);
/*  410 */       file.tabPanel = tp;
/*  411 */       addEWindow(tp, file.name, img);
/*  412 */     } else if (file.type.equals("timeline")) {
/*      */       try {
/*  414 */         TabPanel tp = new TimelineEditor(file, getCurrentProject());
/*  415 */         file.tabPanel = tp;
/*  416 */         addEWindow(tp, file.name, img);
/*      */       } catch (WrongResourceException e) {
/*      */       }
/*  419 */     } else if (file.type.equals("tileset")) {
/*  420 */       TabPanel tp = new TilesetEditor(file, getCurrentProject());
/*  421 */       file.tabPanel = tp;
/*  422 */       addEWindow(tp, file.name, img);
/*      */     } else {
/*  424 */       TabPanel tp = new PlainTextEditor(file, getCurrentProject());
/*  425 */       file.tabPanel = tp;
/*  426 */       addEWindow(tp, file.name, img);
/*      */     }
/*  428 */     Macro.macroAction(new OpenFileAction(file));
/*      */   }
/*      */ 
/*      */   public static Project getMainProject()
/*      */   {
/*  434 */     return mainProject;
/*      */   }
/*      */ 
/*      */   public static void setMainProject(Project newmain)
/*      */   {
/*  440 */     mainProject = newmain;
/*      */     try {
/*  442 */       workspace.updateUI();
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*      */     }
/*      */   }
/*      */ 
/*      */   public void addWindow(TabPanel panel, int title) {
/*  450 */     addWindow(panel, LangSupporter.activeLang.getEntry(title), null);
/*      */   }
/*      */ 
/*      */   public void addWindow(TabPanel panel, int title, ImageIcon img)
/*      */   {
/*  456 */     addWindow(panel, LangSupporter.activeLang.getEntry(title), img);
/*      */   }
/*      */ 
/*      */   public void addEWindow(TabPanel panel, String title)
/*      */   {
/*  462 */     if (title.charAt(0) == '$')
/*      */       try {
/*  464 */         addWindow(panel, Integer.parseInt(title.substring(1)));
/*      */       } catch (Exception e) {
/*  466 */         addWindow(panel, title, null);
/*      */       }
/*      */     else
/*  469 */       addWindow(panel, title, null);
/*      */   }
/*      */ 
/*      */   public void addEWindow(TabPanel panel, String title, ImageIcon img)
/*      */   {
/*  476 */     if (title.charAt(0) == '$')
/*      */       try {
/*  478 */         addWindow(panel, Integer.parseInt(title.substring(1)));
/*      */       } catch (Exception e) {
/*  480 */         addWindow(panel, title, img);
/*      */       }
/*      */     else
/*  483 */       addWindow(panel, title, img);
/*      */   }
/*      */ 
/*      */   public void addWindow(TabPanel panel, String title, ImageIcon img)
/*      */   {
/*      */     try
/*      */     {
/*  491 */       panel.parent = this;
/*  492 */       panel.title = title;
/*  493 */       int ver = Integer.parseInt(gcreator.getJavaVersion().replaceAll("1\\.([0-9])\\..*", "$1"));
/*  494 */       if ((this.istabs) && (ver >= 6)) {
/*  495 */         for (int i = 0; i < tabs.getTabCount(); i++) {
/*  496 */           if ((tabs.getTitleAt(i).equals(title)) && (((TabPanel)tabs.getComponentAt(i)).project == null)) {
/*  497 */             tabs.setSelectedComponent(tabs.getComponentAt(i));
/*      */ 
/*  499 */             return;
/*  500 */           }if ((tabs.getTitleAt(i).equals(title)) && (((TabPanel)tabs.getComponentAt(i)).project.equals(getCurrentProject())) && (tabs.getComponentAt(i).getClass().getName().equals(panel.getClass().getName()))) {
/*  501 */             tabs.setSelectedComponent(tabs.getComponentAt(i));
/*  502 */             return;
/*      */           }
/*      */         }
/*  505 */         tabs.addTab(panel.title, img, panel, "");
/*  506 */         int index = tabs.indexOfComponent(panel);
/*  507 */         tabs.setTabComponentAt(index, new ButtonTabComponent(tabs));
/*  508 */         tabs.setSelectedComponent(panel);
/*      */       }
/*      */ 
/*  536 */       ExtendedFrame frame = new ExtendedFrame();
/*  537 */       panel.frame = frame;
/*  538 */       frame.setPanel(panel);
/*  539 */       frame.setSize(new Dimension(Math.max(panel.getPreferredSize().width, 300), Math.max(panel.getPreferredSize().height, 300)));
/*      */ 
/*  541 */       frame.setMinimumSize(panel.getPreferredSize());
/*  542 */       frame.updateUI();
/*  543 */       frame.setClosable(true);
/*  544 */       frame.setIconifiable(true);
/*  545 */       frame.setMaximizable(true);
/*  546 */       frame.setResizable(true);
/*  547 */       frame.setVisible(true);
/*  548 */       frame.setTitle(panel.title);
/*  549 */       frame.setFrameIcon(img);
/*  550 */       frame.addInternalFrameListener(new InternalFrameListener()
/*      */       {
/*      */         public void internalFrameDeactivated(InternalFrameEvent evt) {
/*  553 */           Aurwindow.this.changed.stateChanged(null);
/*      */         }
/*      */ 
/*      */         public void internalFrameActivated(InternalFrameEvent evt) {
/*  557 */           Aurwindow.this.changed.stateChanged(null);
/*      */         }
/*      */ 
/*      */         public void internalFrameDeiconified(InternalFrameEvent evt) {
/*  561 */           Aurwindow.this.changed.stateChanged(null);
/*      */         }
/*      */ 
/*      */         public void internalFrameIconified(InternalFrameEvent evt) {
/*  565 */           Aurwindow.this.changed.stateChanged(null);
/*      */         }
/*      */ 
/*      */         public void internalFrameClosed(InternalFrameEvent evt) {
/*  569 */           Aurwindow.this.changed.stateChanged(null);
/*      */         }
/*      */ 
/*      */         public void internalFrameClosing(InternalFrameEvent evt) {
/*      */         }
/*      */ 
/*      */         public void internalFrameOpened(InternalFrameEvent evt) {
/*  576 */           Aurwindow.this.changed.stateChanged(null);
/*      */         }
/*      */       });
/*  579 */       frame.setDefaultCloseOperation(2);
/*  580 */       GroupLayout jInternalFrame1Layout = new GroupLayout(frame.getContentPane());
/*  581 */       frame.getContentPane().setLayout(jInternalFrame1Layout);
/*  582 */       if (!this.istabs) {
/*  583 */         jInternalFrame1Layout.setHorizontalGroup(jInternalFrame1Layout.createParallelGroup(1).add(panel, -1, -1, 32767));
/*  584 */         jInternalFrame1Layout.setVerticalGroup(jInternalFrame1Layout.createParallelGroup(1).add(panel, -1, -1, 32767));
/*      */       }
/*      */ 
/*  587 */       this.mdi.add(frame, JLayeredPane.DEFAULT_LAYER);
/*  588 */       frame.setSelected(true);
/*      */     } catch (Exception ex) {
/*  590 */       Logger.getLogger(Aurwindow.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/*      */   }
/*      */ 
/*      */   public boolean installFileEditor(FileOpenListener listener)
/*      */   {
/*  598 */     return this.listeners.add(listener);
/*      */   }
/*      */ 
/*      */   public boolean unistallFileEditor(FileOpenListener listener)
/*      */   {
/*  604 */     return this.listeners.remove(listener);
/*      */   }
/*      */ 
/*      */   public FileOpenListener getFileEditor(String format)
/*      */   {
/*  610 */     Enumeration enumeration = this.listeners.elements();
/*      */     try
/*      */     {
/*  613 */       while (enumeration.hasMoreElements()) {
/*  614 */         FileOpenListener listener = (FileOpenListener)enumeration.nextElement();
/*  615 */         String[] formats = listener.getFileFormats();
/*  616 */         for (int i = 0; i < formats.length; i++)
/*  617 */           if (formats[i].toLowerCase().equals(format.toLowerCase()))
/*  618 */             return listener;
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*      */     }
/*  624 */     return null;
/*      */   }
/*      */ 
/*      */   public boolean addPanelSelectedListener(PanelSelectedListener psl)
/*      */   {
/*  629 */     return this.psel.add(psl);
/*      */   }
/*      */ 
/*      */   public boolean removePanelSelectedListener(PanelSelectedListener psl) {
/*  633 */     return this.psel.remove(psl);
/*      */   }
/*      */ 
/*      */   public void callAllPanelSelectedListeners(TabPanel panel) {
/*  637 */     for (PanelSelectedListener psl : this.psel)
/*  638 */       psl.panelSelected(panel);
/*      */   }
/*      */ 
/*      */   public JComponent getNavigatorPanel()
/*      */   {
/*  643 */     return this.nav;
/*      */   }
/*      */ 
/*      */   public void updateNavigatorPanel(JComponent panel)
/*      */   {
/*  648 */     this.nav = panel;
/*  649 */     this.navroot.removeAll();
/*  650 */     if (this.nav != null)
/*  651 */       this.navroot.add(this.nav, "Center");
/*      */   }
/*      */ 
/*      */   public void updateToDefaultNavigatorPanel(TabPanel panel)
/*      */   {
/*  657 */     if ((panel == null) || (panel.project == null)) {
/*  658 */       updateNavigatorPanel(nofileselnavigator);
/*  659 */       return;
/*      */     }
/*  661 */     if ((panel instanceof ActorEditor)) {
/*  662 */       updateNavigatorPanel(new ActorNavigator(((ActorEditor)panel).file));
/*  663 */       return;
/*      */     }
/*  665 */     updateNavigatorPanel(unkresnav);
/*      */   }
/*      */ 
/*      */   /** @deprecated */
/*      */   public void setContentPane(Container c)
/*      */   {
/*      */   }
/*      */ 
/*      */   protected Aurwindow(String[] settings)
/*      */   {
/*  675 */     SplashScreen.message = "Initiating window....";
/*  676 */     gcreator.splash.repaint();
/*  677 */     setTitle("G-Creator");
/*  678 */     setDefaultCloseOperation(2);
/*  679 */     setJMenuBar(this.menubar);
/*  680 */     setIconImage(new ImageIcon(getClass().getResource("/org/gcreator/resources/GCreator.png")).getImage());
/*  681 */     super.setContentPane(new JPanel());
/*  682 */     SplashScreen.message = "Starting user interface...";
/*  683 */     gcreator.splash.repaint();
/*  684 */     this.istabs = true;
/*  685 */     this.console = new JTextPane();
/*  686 */     this.topContainer = new Container();
/*  687 */     this.bottomContainer = new Container();
/*  688 */     this.rightContainer = new Container();
/*  689 */     this.leftContainer = new Container();
/*  690 */     this.console.setEditable(false);
/*  691 */     this.console.setBackground(Colorfeel.ConsoleBGColor);
/*  692 */     this.console.setDisabledTextColor(Colorfeel.ConsoleFGColor);
/*  693 */     this.scroller = new JScrollPane();
/*      */ 
/*  696 */     this.console.setEditable(false);
/*  697 */     this.console.setContentType("text/html");
/*  698 */     this.scroller.setViewportView(this.console);
/*  699 */     this.statusbar = new Statusbar();
/*  700 */     this.navigatorTabs = new JTabbedPane();
/*  701 */     this.navroot = new JPanel();
/*  702 */     this.navroot.setLayout(new BorderLayout());
/*      */ 
/*  704 */     int ver = Integer.parseInt(gcreator.getJavaVersion().replaceAll("1\\.([0-9])\\..*", "$1"));
/*  705 */     if (ver >= 6) {
/*  706 */       new FileDrop(this, new FileDrop.Listener()
/*      */       {
/*      */         public void filesDropped(File[] files)
/*      */         {
/*  710 */           for (int i = 0; i < files.length; i++) {
/*  711 */             System.out.println(files[i].getName());
/*      */           }
/*      */         }
/*      */       });
/*      */     }
/*      */ 
/*  717 */     SettingsIO.console = this.console;
/*      */ 
/*  719 */     this.consolepopup = new ConsolePopupMenu();
/*  720 */     this.console.addMouseListener(new PopupListener(this.console, this.consolepopup));
/*  721 */     tabs = new JTabbedPane();
/*  722 */     this.mdi = new MdiPane();
/*  723 */     this.splitter1 = new JSplitPane();
/*  724 */     this.splitter2 = new JSplitPane();
/*  725 */     tabs.setTabLayoutPolicy(1);
/*  726 */     this.changed = new ChangeListener()
/*      */     {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  729 */         if (Aurwindow.this.istabs) {
/*  730 */           Component c = Aurwindow.tabs.getSelectedComponent();
/*  731 */           if (c != null)
/*  732 */             Aurwindow.this.selectedDocumentChanged((TabPanel)c);
/*      */           else
/*  734 */             Aurwindow.this.selectedDocumentChanged(null);
/*      */         }
/*      */         else {
/*  737 */           JInternalFrame f = Aurwindow.this.mdi.getSelectedFrame();
/*  738 */           if (f != null)
/*  739 */             Aurwindow.this.selectedDocumentChanged(((ExtendedFrame)f).getPanel());
/*      */           else
/*  741 */             Aurwindow.this.selectedDocumentChanged(null);
/*      */         }
/*      */       }
/*      */     };
/*  746 */     tabs.addChangeListener(this.changed);
/*      */     try
/*      */     {
/*  749 */       if (LangSupporter.activeLang != null)
/*  750 */         lang = LangSupporter.activeLang.getLanguage();
/*      */       else
/*  752 */         lang = "";
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*      */     }
/*  757 */     createToolBar();
/*      */ 
/*  759 */     this.top = new DefaultMutableTreeNode("<HTML><b>" + LangSupporter.activeLang.getEntry(51));
/*  760 */     this.top.setAllowsChildren(true);
/*      */ 
/*  765 */     workspace = new WorkspaceTree(this.top);
/*  766 */     workspace.setVisible(true);
/*      */ 
/*  768 */     workspace.addKeyListener(new KeyAdapter()
/*      */     {
/*      */       public void keyReleased(KeyEvent e)
/*      */       {
/*  775 */         if (e.getKeyCode() != 127) {
/*  776 */           return;
/*      */         }
/*      */ 
/*  779 */         GObject o = Aurwindow.this.getCurrentObject();
/*  780 */         if (o == null) {
/*  781 */           return;
/*      */         }
/*      */ 
/*  784 */         if (((o instanceof GFile)) && 
/*  785 */           (((GFile)o).root.allowsDelete(o)) && 
/*  786 */           (getConfirmDelete("Are you sure you want to delete this resource?"))) {
/*  787 */           Aurwindow.this.deleteFile((GFile)o);
/*      */         }
/*      */ 
/*  791 */         if (((o instanceof Group)) && 
/*  792 */           (((Group)o).root.allowsDelete(o)) && 
/*  793 */           (((Group)o).root.allowsDelete(o)) && 
/*  794 */           (getConfirmDelete("Are you sure you want to delete this group and all of its contents?")))
/*  795 */           Aurwindow.this.deleteGroup((Group)o);
/*      */       }
/*      */ 
/*      */       public boolean getConfirmDelete(String message)
/*      */       {
/*  803 */         return JOptionPane.showConfirmDialog(Aurwindow.this, message, "Confirmation", 0) == 0;
/*      */       }
/*      */     });
/*  807 */     workspace.addMouseListener(new MouseListener()
/*      */     {
/*      */       public void mouseClicked(MouseEvent e) {
/*  810 */         if (e.getClickCount() == 2)
/*  811 */           Aurwindow.this.treeDoubleClicked(e);
/*      */       }
/*      */ 
/*      */       public void mousePressed(MouseEvent e)
/*      */       {
/*  817 */         if ((e.isPopupTrigger()) || (e.getButton() == 3)) {
/*  818 */           System.out.println("Got here");
/*  819 */           Aurwindow.this.popupTreeMenu(e);
/*      */         }
/*      */       }
/*      */ 
/*      */       public void mouseReleased(MouseEvent e)
/*      */       {
/*      */       }
/*      */ 
/*      */       public void mouseEntered(MouseEvent e)
/*      */       {
/*      */       }
/*      */ 
/*      */       public void mouseExited(MouseEvent e)
/*      */       {
/*      */       }
/*      */     });
/*  832 */     treescroll = new JScrollPane();
/*  833 */     treescroll.setViewportView(workspace);
/*      */ 
/*  835 */     this.menus[0] = MenuSupporter.MakeMenu(this.menubar, 0, "Very important functions such as 'Save', 'Open' and 'Exit' can be found here.");
/*  836 */     this.items[MenuSupporter.GenerateMenuItemId(0, 0)] = MenuSupporter.MakeMenuItem(this.menus[0], 5, "Create a new project");
/*  837 */     this.items[MenuSupporter.GenerateMenuItemId(0, 0)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  840 */         Aurwindow.this.onItemActionPerformed(0, 0, evt);
/*      */       }
/*      */     });
/*  843 */     this.items[MenuSupporter.GenerateMenuItemId(0, 0)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/project_new.png")));
/*  844 */     //this.items[MenuSupporter.GenerateMenuItemId(0, 1)] = MenuSupporter.MakeMenuItem(this.menus[0], 6, "Create a new file");
/*  845 */     //this.items[MenuSupporter.GenerateMenuItemId(0, 1)].addActionListener(new ActionListener()
/*      */     //{
/*      */       //public void actionPerformed(ActionEvent evt) {
/*  848 */         //Aurwindow.this.onItemActionPerformed(0, 1, evt);
/*      */       //}
/*      */     //});
/*  851 */     //this.items[MenuSupporter.GenerateMenuItemId(0, 1)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/file_new.png")));
/*  852 */     this.items[MenuSupporter.GenerateMenuItemId(0, 2)] = MenuSupporter.MakeMenuItem(this.menus[0], 7, "Open a project");
/*  853 */     this.items[MenuSupporter.GenerateMenuItemId(0, 2)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/project_open.png")));
/*  854 */     this.items[MenuSupporter.GenerateMenuItemId(0, 2)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  857 */         Aurwindow.this.onItemActionPerformed(0, 2, evt);
/*      */       }
/*      */     });
/*  860 */     this.items[MenuSupporter.GenerateMenuItemId(0, 3)] = MenuSupporter.MakeMenuItem(this.menus[0], 8, "Save project");
/*  861 */     this.items[MenuSupporter.GenerateMenuItemId(0, 3)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/project_save.png")));
/*  862 */     this.items[MenuSupporter.GenerateMenuItemId(0, 3)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  865 */         Aurwindow.this.onItemActionPerformed(0, 3, evt);
/*      */       }
/*      */     });
/*  868 */     this.items[MenuSupporter.GenerateMenuItemId(0, 4)] = MenuSupporter.MakeMenuItem(this.menus[0], 9, "Save project as...");
/*  869 */     this.items[MenuSupporter.GenerateMenuItemId(0, 4)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/project_saveas.png")));
/*  870 */     this.items[MenuSupporter.GenerateMenuItemId(0, 4)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  873 */         Aurwindow.this.onItemActionPerformed(0, 4, evt);
/*      */       }
/*      */     });
/*  876 */     this.items[MenuSupporter.GenerateMenuItemId(0, 5)] = MenuSupporter.MakeMenuItem(this.menus[0], 53, "Save all projects");
/*  877 */     this.items[MenuSupporter.GenerateMenuItemId(0, 5)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/project_saveall.png")));
/*  878 */     this.items[MenuSupporter.GenerateMenuItemId(0, 6)] = MenuSupporter.MakeMenuItem(this.menus[0], 88, "Save file");
/*  879 */     this.items[MenuSupporter.GenerateMenuItemId(0, 6)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/file_save.png")));
/*  880 */     this.items[MenuSupporter.GenerateMenuItemId(0, 7)] = MenuSupporter.MakeMenuItem(this.menus[0], 89, "Save All files");
/*  881 */     this.items[MenuSupporter.GenerateMenuItemId(0, 7)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/file_saveall.png")));
/*  882 */     this.menus[9] = MenuSupporter.MakeSubMenu(this.menus[0], 10, "Import...");
/*  883 */     this.menus[9].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/import.png")));
/*  884 */     this.menus[10] = MenuSupporter.MakeSubMenu(this.menus[9], 185, "File");
/*  885 */     this.items[MenuSupporter.GenerateMenuItemId(10, 0)] = MenuSupporter.MakeMenuItem(this.menus[10], 189, "Import Image");
/*  886 */     this.items[MenuSupporter.GenerateMenuItemId(10, 0)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  889 */         Aurwindow.this.onItemActionPerformed(10, 0, evt);
/*      */       }
/*      */     });
/*  892 */     //this.menus[11] = MenuSupporter.MakeSubMenu(this.menus[9], 186, "Project");
/*  893 */     //this.menus[12] = MenuSupporter.MakeSubMenu(this.menus[0], 11, "Export...");
/*  894 */     //this.menus[12].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/export.png")));
/*  895 */     //this.menus[13] = MenuSupporter.MakeSubMenu(this.menus[12], 185, "File");
/*  896 */     //this.menus[14] = MenuSupporter.MakeSubMenu(this.menus[12], 186, "Project");
/*  897 */     this.items[MenuSupporter.GenerateMenuItemId(0, 9)] = MenuSupporter.MakeMenuItem(this.menus[0], 12, "Close a project");
/*  898 */     this.items[MenuSupporter.GenerateMenuItemId(0, 9)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/project_close.png")));
/*  899 */     this.items[MenuSupporter.GenerateMenuItemId(0, 9)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  902 */         Aurwindow.this.onItemActionPerformed(0, 9, evt);
/*      */       }
/*      */     });
/*  905 */     this.items[MenuSupporter.GenerateMenuItemId(0, 10)] = MenuSupporter.MakeMenuItem(this.menus[0], 13, "Closes the application");
/*  906 */     this.items[MenuSupporter.GenerateMenuItemId(0, 10)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/file_exit.png")));
/*  907 */     this.items[MenuSupporter.GenerateMenuItemId(0, 10)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  910 */         Aurwindow.this.onItemActionPerformed(0, 10, evt);
/*      */       }
/*      */     });
/*  933 */     this.menus[2] = MenuSupporter.MakeMenu(this.menubar, 2, "Layout and design options are defined here.");
/*      */ 
/*  936 */     this.menus[15] = MenuSupporter.MakeSubMenu(this.menus[2], 193, "Display mode");
/*  937 */     this.items[MenuSupporter.GenerateMenuItemId(2, 0)] = MenuSupporter.MakeCheckMenuItem(this.menus[2], 22, "Display output box");
/*  938 */     this.items[MenuSupporter.GenerateMenuItemId(2, 0)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  941 */         Aurwindow.this.onItemActionPerformed(2, 0, evt);
/*      */       }
/*      */     });
/*  944 */     this.items[MenuSupporter.GenerateMenuItemId(2, 1)] = MenuSupporter.MakeCheckMenuItem(this.menus[2], 75, "Display the toolbar");
/*  945 */     this.items[MenuSupporter.GenerateMenuItemId(2, 1)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  948 */         Aurwindow.this.onItemActionPerformed(2, 1, evt);
/*      */       }
/*      */     });
/*  952 */     //this.menus[3] = MenuSupporter.MakeMenu(this.menubar, 3, "Compile and test your games.");
/*  953 */     //this.items[MenuSupporter.GenerateMenuItemId(3, 0)] = MenuSupporter.MakeMenuItem(this.menus[3], 98, "Set as main project");
/*  954 */     //this.items[MenuSupporter.GenerateMenuItemId(3, 0)].addActionListener(new ActionListener()
/*      */     //{
/*      */       //public void actionPerformed(ActionEvent evt) {
/*  957 */         //Aurwindow.this.onItemActionPerformed(3, 0, evt);
/*      */       //}
/*      */     //});
/*  960 */     //MenuSupporter.MakeSeparator(this.menus[3]);
/*      */ 
/*  977 */     this.menus[7] = MenuSupporter.MakeMenu(this.menubar, 114, "Tools");
/*  978 */     this.items[MenuSupporter.GenerateMenuItemId(7, 0)] = MenuSupporter.MakeMenuItem(this.menus[7], 23, "Select the language");
/*  979 */     this.items[MenuSupporter.GenerateMenuItemId(7, 0)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/tools_language.png")));
/*  980 */     this.items[MenuSupporter.GenerateMenuItemId(7, 0)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  983 */         Aurwindow.this.onItemActionPerformed(7, 0, evt);
/*      */       }
/*      */     });
/*  986 */     //this.items[MenuSupporter.GenerateMenuItemId(7, 1)] = MenuSupporter.MakeMenuItem(this.menus[7], 93, "Update");
/*  987 */     //this.items[MenuSupporter.GenerateMenuItemId(7, 1)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/tools_update.png")));
/*  988 */     //this.items[MenuSupporter.GenerateMenuItemId(7, 1)].addActionListener(new ActionListener()
/*      */     //{
/*      */       //public void actionPerformed(ActionEvent evt) {
/*  991 */         //Aurwindow.this.onItemActionPerformed(7, 1, evt);
/*      */       //}
/*      */     //});
/*  994 */     //this.items[MenuSupporter.GenerateMenuItemId(7, 2)] = MenuSupporter.MakeMenuItem(this.menus[7], 109, "Extensions Manager");
/*  995 */     //this.items[MenuSupporter.GenerateMenuItemId(7, 2)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/tools_plug.png")));
/*  996 */     //this.items[MenuSupporter.GenerateMenuItemId(7, 2)].addActionListener(new ActionListener()
/*      */     //{
/*      */       //public void actionPerformed(ActionEvent evt) {
/*  999 */         //Aurwindow.this.onItemActionPerformed(7, 2, evt);
/*      */       //}
/*      */     //});
/* 1002 */     this.menus[7].addSeparator();
/* 1003 */     this.items[MenuSupporter.GenerateMenuItemId(7, 3)] = MenuSupporter.MakeMenuItem(this.menus[7], 130, "Global options");
/* 1004 */     this.items[MenuSupporter.GenerateMenuItemId(7, 3)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/tools_global.png")));
/* 1005 */     this.items[MenuSupporter.GenerateMenuItemId(7, 3)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1008 */         Aurwindow.this.onItemActionPerformed(7, 3, evt);
/*      */       }
/*      */     });
/* 1011 */     this.menus[7].addSeparator();
/* 1012 */     this.menus[8] = MenuSupporter.MakeSubMenu(this.menus[7], 171, "Macro");
/* 1013 */     this.menus[8].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/tools_macro.png")));
/* 1014 */     //this.items[MenuSupporter.GenerateMenuItemId(7, 4)] = MenuSupporter.MakeMenuItem(this.menus[7], 183, "PowerPack");
/* 1015 */     //this.items[MenuSupporter.GenerateMenuItemId(7, 4)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/tools_powerpack.png")));
/* 1016 */     //this.items[MenuSupporter.GenerateMenuItemId(7, 4)].addActionListener(new ActionListener()
/*      */     //{
/*      */       //public void actionPerformed(ActionEvent evt) {
/* 1019 */         //Aurwindow.this.onItemActionPerformed(7, 4, evt);
/*      */       //}
/*      */     //});
/* 1022 */     this.items[MenuSupporter.GenerateMenuItemId(8, 0)] = MenuSupporter.MakeMenuItem(this.menus[8], 172, "Play macro");
/* 1023 */     this.items[MenuSupporter.GenerateMenuItemId(8, 0)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/tools_macro_play.png")));
/* 1024 */     this.items[MenuSupporter.GenerateMenuItemId(8, 0)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1027 */         Aurwindow.this.onItemActionPerformed(8, 0, evt);
/*      */       }
/*      */     });
/* 1030 */     this.items[MenuSupporter.GenerateMenuItemId(8, 1)] = MenuSupporter.MakeMenuItem(this.menus[8], 173, "Edit macro");
/* 1031 */     this.items[MenuSupporter.GenerateMenuItemId(8, 1)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/tools_macro_edit.png")));
/* 1032 */     this.items[MenuSupporter.GenerateMenuItemId(8, 1)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1035 */         Aurwindow.this.onItemActionPerformed(8, 1, evt);
/*      */       }
/*      */     });
/* 1038 */     this.items[MenuSupporter.GenerateMenuItemId(8, 2)] = MenuSupporter.MakeMenuItem(this.menus[8], 174, "Record new macro");
/* 1039 */     this.items[MenuSupporter.GenerateMenuItemId(8, 2)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/tools_macro_record.png")));
/* 1040 */     this.items[MenuSupporter.GenerateMenuItemId(8, 2)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1043 */         Aurwindow.this.onItemActionPerformed(8, 2, evt);
/*      */       }
/*      */     });
/* 1046 */     this.items[MenuSupporter.GenerateMenuItemId(8, 3)] = MenuSupporter.MakeMenuItem(this.menus[8], 182, "Stop recording macro");
/* 1047 */     this.items[MenuSupporter.GenerateMenuItemId(8, 3)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/tools_macro_stop.png")));
/* 1048 */     this.items[MenuSupporter.GenerateMenuItemId(8, 3)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1051 */         Aurwindow.this.onItemActionPerformed(8, 3, evt);
/*      */       }
/*      */     });
/* 1054 */     this.menus[4] = MenuSupporter.MakeMenu(this.menubar, 4, "Get info about Aurora.");
/* 1055 */     this.items[MenuSupporter.GenerateMenuItemId(4, 0)] = MenuSupporter.MakeMenuItem(this.menus[4], 24, "About Aurora");
/* 1056 */     this.items[MenuSupporter.GenerateMenuItemId(4, 0)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/help_about.png")));
/* 1057 */     this.items[MenuSupporter.GenerateMenuItemId(4, 0)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1060 */         Aurwindow.this.onItemActionPerformed(4, 0, evt);
/*      */       }
/*      */     });
/* 1063 */     this.items[MenuSupporter.GenerateMenuItemId(4, 1)] = MenuSupporter.MakeMenuItem(this.menus[4], 25, "Aurora help");
/* 1064 */     this.items[MenuSupporter.GenerateMenuItemId(4, 1)].setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/help_help.png")));
/* 1065 */     this.items[MenuSupporter.GenerateMenuItemId(4, 1)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1068 */         Aurwindow.this.onItemActionPerformed(4, 1, evt);
/*      */       }
/*      */     });
/* 1115 */     this.wtreepos = new ButtonGroup();
/* 1116 */     this.items[MenuSupporter.GenerateMenuItemId(15, 0)] = MenuSupporter.MakeRadioMenuItem(this.wtreepos, this.menus[15], 194, "Tree Left");
/* 1117 */     this.items[MenuSupporter.GenerateMenuItemId(15, 0)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1120 */         Aurwindow.this.onItemActionPerformed(15, 0, evt);
/*      */       }
/*      */     });
/* 1123 */     this.items[MenuSupporter.GenerateMenuItemId(15, 0)].setSelected(true);
/* 1124 */     this.items[MenuSupporter.GenerateMenuItemId(15, 1)] = MenuSupporter.MakeRadioMenuItem(this.wtreepos, this.menus[15], 195, "Tree Right");
/* 1125 */     this.items[MenuSupporter.GenerateMenuItemId(15, 1)].addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1128 */         Aurwindow.this.onItemActionPerformed(15, 1, evt);
/*      */       }
/*      */     });
/* 1131 */     this.splitter1.setOrientation(0);
/* 1132 */     this.splitter2.setOrientation(1);
/* 1133 */     this.splitter1.setLeftComponent(this.splitter2);
/* 1134 */     this.splitter1.setRightComponent(this.scroller);
/* 1135 */     if ((settings == null) || (settings.length < 6) || (settings[5] == null) || (!settings[5].equals("Right"))) {
/* 1136 */       this.splitter2.setLeftComponent(this.navigatorTabs);
/* 1137 */       this.splitter2.setRightComponent(tabs);
/* 1138 */       this.items[MenuSupporter.GenerateMenuItemId(15, 0)].setSelected(true);
/*      */     } else {
/* 1140 */       this.splitter2.setRightComponent(this.navigatorTabs);
/* 1141 */       this.splitter2.setLeftComponent(tabs);
/* 1142 */       this.items[MenuSupporter.GenerateMenuItemId(15, 1)].setSelected(true);
/*      */     }
/* 1144 */     this.navigatorTabs.add(LangSupporter.activeLang.getEntry(51), treescroll);
/* 1145 */     this.navigatorTabs.add(LangSupporter.activeLang.getEntry(251), this.navroot);
/* 1146 */     this.navigatorTabs.addMouseListener(new MouseListener()
/*      */     {
/*      */       public void mouseExited(MouseEvent evt) {
/*      */       }
/*      */ 
/*      */       public void mouseEntered(MouseEvent evt) {
/*      */       }
/*      */ 
/*      */       public void mouseReleased(MouseEvent evt) {
/* 1155 */         if (evt.getButton() != 1) {
/* 1156 */           return;
/*      */         }
/* 1158 */         //Aurwindow.access$302(false);
/*      */       }
/*      */ 
/*      */       public void mousePressed(MouseEvent evt) {
/* 1162 */         if (evt.getButton() != 1) {
/* 1163 */           return;
/*      */         }
/* 1165 */         if (!Aurwindow.dragging) {}
/* 1166 */           //Aurwindow.access$302(true);
/*      */       }
/*      */ 
/*      */       public void mouseClicked(MouseEvent evt)
/*      */       {
/*      */       }
/*      */     });
/* 1173 */     this.navigatorTabs.addMouseMotionListener(new MouseMotionListener()
/*      */     {
/*      */       public void mouseMoved(MouseEvent evt) {
/*      */       }
/*      */ 
/*      */       public void mouseDragged(MouseEvent evt) {
/* 1179 */         if (!Aurwindow.dragging) {
/* 1180 */           return;
/*      */         }
/* 1182 */         int x = evt.getX() + Aurwindow.this.getLocationOnScreen().x;
/* 1183 */         int y = evt.getY() + Aurwindow.this.getLocationOnScreen().y;
/* 1184 */         Point p = Aurwindow.this.navigatorTabs.getLocationOnScreen();
/* 1185 */         int nx = p.x;
/* 1186 */         int ny = p.y;
/* 1187 */         int w = Aurwindow.this.navigatorTabs.getWidth();
/* 1188 */         int h = Aurwindow.this.navigatorTabs.getHeight();
/* 1189 */         int index = Aurwindow.this.navigatorTabs.getSelectedIndex();
/* 1190 */         if (index == -1) {
/* 1191 */           return;
/*      */         }
/* 1193 */         Component c = Aurwindow.this.navigatorTabs.getSelectedComponent();
/* 1194 */         String title = Aurwindow.this.navigatorTabs.getTitleAt(index);
/* 1195 */         if ((x < nx) || (y < ny) || (x > nx + w) || (y > ny + h)) {
/* 1196 */           Robot r = null;
/*      */           try {
/* 1198 */             r = new Robot();
/*      */           }
/*      */           catch (Exception e) {
/*      */           }
/* 1202 */           if (r != null) {
/* 1203 */             r.mouseRelease(16);
/*      */           }
/* 1205 */           JFrame f = new JFrame()
/*      */           {
/*      */             public void dispose()
/*      */             {
/* 1209 */               Aurwindow.this.navigatorTabs.addTab(getTitle(), getContentPane());
/* 1210 */               super.dispose();
/*      */             }
/*      */           };
/* 1213 */           f.setAlwaysOnTop(true);
/* 1214 */           f.setVisible(true);
/* 1215 */           f.setTitle(title);
/* 1216 */           f.setLayout(new BorderLayout());
/* 1217 */           f.setSize(c.getSize());
/* 1218 */           f.add(c, "Center");
/* 1219 */           f.setDefaultCloseOperation(2);
/* 1220 */           f.setResizable(true);
/* 1221 */           f.setLocation(evt.getX() + Aurwindow.this.getLocationOnScreen().x - 30, evt.getY() + Aurwindow.this.getLocationOnScreen().y - 5);
/* 1222 */           if (r != null)
/* 1223 */             r.mousePress(16);
/*      */         }
/*      */       }
/*      */     });
/* 1228 */     this.splitter2.setDividerLocation(149);
/*      */ 
/* 1234 */     SplashScreen.message = "Creating toolbars";
/* 1235 */     gcreator.splash.repaint();
/* 1236 */     Container cont = getContentPane();
/* 1237 */     Container panel = new Container();
/* 1238 */     panel.setLayout(new BorderLayout());
/* 1239 */     this.topContainer.setLayout(new GridLayout(0, 1));
/* 1240 */     cont.setLayout(new BorderLayout());
/* 1241 */     cont.add(panel, "Center");
/* 1242 */     cont.add(this.statusbar, "South");
/* 1243 */     this.bottomContainer.setLayout(new GridLayout(0, 1));
/* 1244 */     this.rightContainer.setLayout(new GridLayout(1, 0));
/* 1245 */     this.leftContainer.setLayout(new GridLayout(1, 0));
/*      */ 
/* 1249 */     this.layer.setVisible(true);
/* 1250 */     panel.add(this.bottomContainer, "South");
/* 1251 */     panel.add(this.topContainer, "North");
/* 1252 */     panel.add(this.leftContainer, "West");
/* 1253 */     panel.add(this.rightContainer, "East");
/* 1254 */     panel.add(this.layer, "Center");
/* 1255 */     this.splitter1.setVisible(true);
/* 1256 */     this.splitter1.setLocation(0, 0);
/* 1257 */     this.splitter1.setSize(this.layer.getSize());
/* 1258 */     this.layer.add(this.splitter1, JLayeredPane.DEFAULT_LAYER);
/*      */ 
/* 1260 */     this.layer.addComponentListener(new ComponentListener()
/*      */     {
/*      */       public void componentHidden(ComponentEvent evt)
/*      */       {
/*      */       }
/*      */ 
/*      */       public void componentShown(ComponentEvent evt)
/*      */       {
/*      */       }
/*      */ 
/*      */       public void componentMoved(ComponentEvent evt)
/*      */       {
/*      */       }
/*      */ 
/*      */       public void componentResized(ComponentEvent evt)
/*      */       {
/* 1278 */         Aurwindow.this.splitter1.setSize(Aurwindow.this.layer.getSize());
/* 1279 */         Aurwindow.this.splitter1.updateUI();
/*      */       }
/*      */     });
/* 1283 */     if (settings[2].equals("Hidden")) {
/* 1284 */       onItemActionPerformed(2, 0, null);
/*      */     } else {
/* 1286 */       this.items[MenuSupporter.GenerateMenuItemId(2, 0)].setSelected(true);
/* 1287 */       pack();
/* 1288 */       this.splitter1.setDividerLocation(0.66D);
/*      */     }
/*      */ 
/* 1312 */     if (settings[4].equals("Visible")) {
/* 1313 */       showToolbars = true;
/*      */ 
/* 1315 */       this.items[MenuSupporter.GenerateMenuItemId(2, 1)].setSelected(true);
/*      */     }
/*      */     else {
/* 1318 */       showToolbars = false;
/* 1319 */       this.topContainer.setVisible(false);
/* 1320 */       this.bottomContainer.setVisible(false);
/* 1321 */       this.leftContainer.setVisible(false);
/* 1322 */       this.rightContainer.setVisible(false);
/* 1323 */       this.items[MenuSupporter.GenerateMenuItemId(2, 1)].setSelected(false);
/*      */     }
/*      */ 
/* 1327 */     int w = 800;
/* 1328 */     int h = 600;
/*      */     try {
/* 1330 */       w = Integer.parseInt(settings[6].replaceAll("([0-9]+), ([0-9]+)", "$1"));
/* 1331 */       h = Integer.parseInt(settings[6].replaceAll("([0-9]+), ([0-9]+)", "$2"));
/*      */     } catch (Exception e) {
/*      */     }
/* 1334 */     setSize(w, h);
/* 1335 */     this.splitter2.setDividerLocation(159);
/* 1336 */     this.splitter1.setDividerSize(5);
/* 1337 */     this.splitter2.setDividerSize(5);
/* 1338 */     utilities.addMessage(29);
/* 1339 */     //WelcomeTab welcome = new WelcomeTab();
/* 1340 */     //addWindow(welcome, 26);
/* 1341 */     //updateToDefaultNavigatorPanel(welcome);
/* 1342 */     setMinimumSize(new Dimension(200, 200));
/* 1343 */     if (settings[6].equals("True"))
/* 1344 */       setExtendedState(6);
/*      */     else {
/* 1346 */       setExtendedState(0);
/*      */     }
/* 1348 */     this.statusbar.setStandardText("Done");
/* 1349 */     this.statusbar.restoreText();
/* 1350 */     this.statusbar.getProgressBar().setVisible(false);
/* 1351 */     SplashScreen.message = "Displaying application";
/* 1352 */     gcreator.splash.repaint();
/* 1353 */     setVisible(true);
/*      */   }
/*      */ 
/*      */   public JInternalFrame createPaletteFrame()
/*      */   {
/* 1359 */     JInternalFrame f = new JInternalFrame();
/* 1360 */     f.setVisible(true);
/* 1361 */     f.setLocation(50, 50);
/* 1362 */     f.setSize(200, 200);
/* 1363 */     f.setDefaultCloseOperation(2);
/* 1364 */     this.layer.add(f, JLayeredPane.PALETTE_LAYER);
/* 1365 */     return f;
/*      */   }
/*      */ 
/*      */   public JInternalFrame createPaletteFrame(JInternalFrame f)
/*      */   {
/* 1371 */     f.setVisible(true);
/* 1372 */     f.setLocation(50, 50);
/* 1373 */     f.setSize(200, 200);
/* 1374 */     f.setDefaultCloseOperation(2);
/* 1375 */     this.layer.add(f, JLayeredPane.PALETTE_LAYER);
/* 1376 */     return f;
/*      */   }
/*      */ 
/*      */   private void selectedDocumentChanged(TabPanel tabpanel)
/*      */   {
/* 1381 */     updateToDefaultNavigatorPanel(tabpanel);
/* 1382 */     callAllPanelSelectedListeners(tabpanel);
/*      */   }
/*      */ 
/*      */   public void updateUI() {
/* 1386 */     ((JPanel)getContentPane()).updateUI();
/*      */   }
/*      */ 
/*      */   private void onItemActionPerformed(int menu, int item, ActionEvent evt)
/*      */   {
/* 1400 */     if ((menu == 0) && (item == 0)) {
/* 1401 */       addWindow(newproject, 55, (ImageIcon)this.items[MenuSupporter.GenerateMenuItemId(menu, item)].getIcon());
/*      */     }
/* 1403 */     if ((menu == 0) && (item == 1)) {
/* 1404 */       addWindow(newfilegroup, 96, (ImageIcon)this.items[MenuSupporter.GenerateMenuItemId(menu, item)].getIcon());
/*      */     }
/* 1406 */     if ((menu == 0) && (item == 2)) {
/* 1407 */       ProjectImporter.OpenProject(this);
/*      */     }
/* 1409 */     if ((menu == 0) && (item == 3)) {
/* 1410 */       SaveMainProject(false);
/*      */     }
/* 1412 */     if ((menu == 0) && (item == 4)) {
/* 1413 */       SaveMainProject(true);
/*      */     }
/* 1415 */     if ((menu == 0) && (item == 9)) {
/* 1416 */       CloseProject();
/*      */     }
/* 1418 */     if ((menu == 0) && (item == 10)) {
/* 1419 */       dispose();
/*      */     }
/*      */ 
/* 1425 */     if ((menu == 2) && (item == 0)) {
/* 1426 */       Dimension a = getSize();
/* 1427 */       int b = getExtendedState();
/* 1428 */       this.scroller.setVisible(!this.scroller.isVisible());
/*      */ 
/* 1432 */       repaint();
/* 1433 */       this.splitter1.setDividerLocation(0.8D);
/*      */     }
/* 1435 */     if ((menu == 2) && (item == 1)) {
/* 1436 */       Dimension a = getSize();
/*      */ 
/* 1438 */       showToolbars = this.items[MenuSupporter.GenerateMenuItemId(2, 1)].isSelected();
/* 1439 */       this.topContainer.setVisible(showToolbars);
/* 1440 */       this.bottomContainer.setVisible(showToolbars);
/* 1441 */       this.leftContainer.setVisible(showToolbars);
/* 1442 */       this.rightContainer.setVisible(showToolbars);
/* 1443 */       if (!showToolbars)
/*      */       {
/* 1445 */         ToolbarManager.hideAll();
/*      */       }
/*      */       else {
/* 1448 */         ToolbarManager.showAll();
/*      */       }
/*      */ 
/* 1451 */       updateUI();
/*      */     }
/*      */ 
/* 1454 */     if ((menu == 3) && (item == 0)) {
/* 1455 */       setMainProject(getCurrentProject());
/*      */     }
/* 1457 */     if ((menu == 4) && (item == 0)) {
/* 1458 */       addWindow(about, 24);
/*      */     }
/* 1460 */     if ((menu == 4) && (item == 1)) {
/* 1461 */       HelpPanel help = new HelpPanel();
/* 1462 */       addWindow(help, 27);
/*      */     }
/*      */ 
/* 1535 */     if ((menu == 7) && (item == 0)) {
/* 1536 */       LanguageTab lang = new LanguageTab();
/* 1537 */       addWindow(lang, 28, (ImageIcon)this.items[MenuSupporter.GenerateMenuItemId(menu, item)].getIcon());
/*      */     }
/* 1539 */     if ((menu == 7) && (item == 1)) {
/* 1540 */       utilities.addStringMessage("Update");
/* 1541 */       Updater.update();
/*      */     }
/* 1543 */     if ((menu == 7) && (item == 2))
/*      */     {
/* 1545 */       PluginDialog manager = new PluginDialog(this, true);
/* 1546 */       manager.setVisible(true);
/*      */     }
/* 1548 */     if ((menu == 7) && (item == 3)) {
/* 1549 */       addWindow(globalsettings, 131, (ImageIcon)this.items[MenuSupporter.GenerateMenuItemId(menu, item)].getIcon());
/*      */     }
/* 1551 */     if ((menu == 7) && (item == 4)) {
/* 1552 */       addWindow(new PowerPackImporter(), 184, (ImageIcon)this.items[MenuSupporter.GenerateMenuItemId(menu, item)].getIcon());
/*      */     }
/*      */ 
/* 1555 */     if ((menu == 8) && (item == 0)) {
/* 1556 */       PlayMacroDialog dialog = new PlayMacroDialog(this, true);
/* 1557 */       dialog.setVisible(true);
/*      */     }
/* 1559 */     if ((menu == 8) && (item == 2)) {
/* 1560 */       String mname = JOptionPane.showInputDialog(this, LangSupporter.activeLang.getEntry(175));
/* 1561 */       if ((mname != null) && (mname.length() > 0)) {
/* 1562 */         if (MacroLibrary.findMacro(mname) != null) {
/* 1563 */           JOptionPane.showMessageDialog(this, LangSupporter.activeLang.getEntry(177), LangSupporter.activeLang.getEntry(176), 0);
/*      */         }
/*      */         else
/*      */         {
/* 1568 */           MacroLibrary.addMacro(Macro.record(mname));
/*      */         }
/*      */       }
/*      */     }
/* 1572 */     if ((menu == 8) && (item == 3)) {
/* 1573 */       Macro.recordingMacro = null;
/*      */     }
/* 1575 */     if ((menu == 10) && (item == 0)) {
/* 1576 */       chooseImage.showDialog(this, null);
/* 1577 */       File f = chooseImage.getSelectedFile();
/*      */       try {
/* 1579 */         if (f != null)
/* 1580 */           StdImport.importImage(getCurrentFolder(), f);
/*      */       }
/*      */       catch (IOException e) {
/*      */       }
/*      */     }
/* 1585 */     if ((menu == 15) && (item == 0)) {
/* 1586 */       this.splitter2.setRightComponent(null);
/* 1587 */       this.splitter2.setLeftComponent(null);
/* 1588 */       this.splitter2.setRightComponent(this.istabs ? tabs : this.mdi);
/* 1589 */       this.splitter2.setLeftComponent(this.navigatorTabs);
/* 1590 */       tabs.updateUI();
/* 1591 */       this.mdi.updateUI();
/* 1592 */       this.splitter2.updateUI();
/* 1593 */       this.splitter1.updateUI();
/*      */     }
/* 1595 */     if ((menu == 15) && (item == 1)) {
/* 1596 */       this.splitter2.setRightComponent(null);
/* 1597 */       this.splitter2.setLeftComponent(null);
/* 1598 */       this.splitter2.setRightComponent(this.navigatorTabs);
/* 1599 */       this.splitter2.setLeftComponent(this.istabs ? tabs : this.mdi);
/* 1600 */       tabs.updateUI();
/* 1601 */       this.mdi.updateUI();
/* 1602 */       this.splitter2.updateUI();
/* 1603 */       this.splitter1.updateUI();
/*      */     }
/*      */   }
/*      */ 
/*      */   public Project getCurrentProject()
/*      */   {
/* 1612 */     Folder curfol = getCurrentFolder();
/* 1613 */     if (curfol == null) {
/* 1614 */       return null;
/*      */     }
/* 1616 */     while ((curfol instanceof Group)) {
/* 1617 */       curfol = ((Group)curfol).root;
/*      */     }
/* 1619 */     if ((curfol instanceof Project)) {
/* 1620 */       return (Project)curfol;
/*      */     }
/* 1622 */     return null;
/*      */   }
/*      */ 
/*      */   public Folder getCurrentFolder()
/*      */   {
/* 1628 */     if (getCurrentObject() == null) {
/* 1629 */       return null;
/*      */     }
/* 1631 */     if ((getCurrentObject() instanceof Folder)) {
/* 1632 */       return (Folder)getCurrentObject();
/*      */     }
/* 1634 */     if ((getCurrentObject() instanceof GFile)) {
/* 1635 */       return ((GFile)getCurrentObject()).root;
/*      */     }
/* 1637 */     return null;
/*      */   }
/*      */ 
/*      */   public GObject getCurrentObject()
/*      */   {
/* 1644 */     if (workspace.getSelectionCount() != 1) {
/* 1645 */       return null;
/*      */     }
/* 1647 */     TreePath selection = workspace.getSelectionPath();
/* 1648 */     if (!(selection.getLastPathComponent() instanceof ObjectNode)) {
/* 1649 */       return null;
/*      */     }
/* 1651 */     ObjectNode node = (ObjectNode)selection.getLastPathComponent();
/* 1652 */     return node.object;
/*      */   }
/*      */ 
/*      */   public void onToolbarActionPerformed(int item, ActionEvent evt)
/*      */   {
/*      */     Folder a;
/*      */     int i;
/*      */     GFile file;
/* 1660 */     switch (item) {
/*      */     case 1:
/* 1662 */       if (newproject != null)
/* 1663 */         addWindow(newproject, 55, new ImageIcon(getClass().getResource("/org/gcreator/resources/menu/project_new.png"))); break;
/*      */     case 2:
/* 1666 */       ProjectImporter.OpenProject(this);
/* 1667 */       break;
/*      */     case 3:
/* 1669 */       SaveMainProject(false);
/* 1670 */       break;
/*      */     case 4:
/* 1673 */       System.out.println("Saving all...");
/* 1674 */       if (this.istabs) {
/* 1675 */         for (int ii = 0; ii < tabs.getTabCount(); ii++) {
/* 1676 */           if (((TabPanel)tabs.getComponentAt(ii)).wasModified())
/* 1677 */             ((TabPanel)tabs.getComponentAt(ii)).Save();
/*      */         }
/*      */       }
/*      */       else {
/* 1681 */         for (int ii = 0; ii < this.mdi.getComponentCount(); ii++) {
/* 1682 */           if (((ExtendedFrame)this.mdi.getComponent(ii)).getPanel().wasModified()) {
/* 1683 */             ((ExtendedFrame)this.mdi.getComponent(ii)).getPanel().Save();
/*      */           }
/*      */         }
/*      */       }
/* 1687 */       break;
/*      */     case 5:
/* 1689 */       if (!(getCurrentProject() instanceof GameProject)) {
/* 1690 */         return;
/*      */       }
/* 1692 */       a = getCurrentFolder();
/* 1693 */       if (a == null) {
/* 1694 */         JOptionPane.showMessageDialog(null, "Select a folder on the project tree!");
/* 1695 */         return;
/*      */       }
/* 1697 */       addFile(getCurrentFolder(), "newSprite" + ((GameProject)getCurrentProject()).sprites++, "sprite");
/*      */ 
/* 1699 */       break;
/*      */     case 6:
/* 1701 */       if (!(getCurrentProject() instanceof GameProject)) {
/* 1702 */         return;
/*      */       }
/* 1704 */       a = getCurrentFolder();
/* 1705 */       if (a == null) {
/* 1706 */         JOptionPane.showMessageDialog(null, "Select a folder on the project tree!");
/* 1707 */         return;
/*      */       }
/* 1709 */       addFile(getCurrentFolder(), "newSound" + ((GameProject)getCurrentProject()).sounds++, "wav");
/*      */ 
/* 1711 */       break;
/*      */     case 7:
/* 1714 */       if ((getCurrentProject() instanceof GameProject)) {
/* 1715 */         i = ((GameProject)getCurrentProject()).classes;
/*      */       }
/*      */       else
/*      */       {
/* 1716 */         if ((getCurrentProject() instanceof ModuleProject))
/* 1717 */           i = ((ModuleProject)getCurrentProject()).classes;
/* 1718 */         else return; 
/*      */       }
/* 1719 */       a = getCurrentFolder();
/* 1720 */       if (a == null) {
/* 1721 */         JOptionPane.showMessageDialog(null, "Select a folder on the project tree!");
/* 1722 */         return;
/*      */       }
/* 1724 */       addFile(getCurrentFolder(), "newClass" + i, "gcl");
/* 1725 */       if ((getCurrentProject() instanceof GameProject))
/* 1726 */         ((GameProject)getCurrentProject()).classes += 1;
/* 1727 */       else if ((getCurrentProject() instanceof ModuleProject))
/* 1728 */         ((ModuleProject)getCurrentProject()).classes += 1; break;
/*      */     case 8:
/* 1731 */       if (!(getCurrentProject() instanceof GameProject))
/* 1732 */         return;
/* 1733 */       a = getCurrentFolder();
/* 1734 */       if (a == null) {
/* 1735 */         JOptionPane.showMessageDialog(null, "Select a folder on the project tree!");
/* 1736 */         return;
/*      */       }
/*      */ 
/* 1739 */       addFile(getCurrentFolder(), "newObject" + ((GameProject)getCurrentProject()).actors++, "actor");
/* 1740 */       break;
/*      */     case 9:
/* 1742 */       if (!(getCurrentProject() instanceof GameProject))
/* 1743 */         return;
/* 1744 */       a = getCurrentFolder();
/* 1745 */       if (a == null) {
/* 1746 */         JOptionPane.showMessageDialog(null, "Select a folder on the project tree!");
/* 1747 */         return;
/*      */       }
/*      */ 
/* 1750 */       addFile(getCurrentFolder(), "newLevel" + ((GameProject)getCurrentProject()).scenes++, "scene");
/* 1751 */       break;
/*      */     case 10:
/* 1753 */       if (!(getCurrentProject() instanceof GameProject))
/* 1754 */         return;
/* 1755 */       a = getCurrentFolder();
/* 1756 */       if (a == null) {
/* 1757 */         JOptionPane.showMessageDialog(null, "Select a folder on the project tree!");
/* 1758 */         return;
/*      */       }
/*      */ 
/* 1761 */       file = addFile(getCurrentFolder(), "newImage" + ((GameProject)getCurrentProject()).images++, "png");
/* 1762 */       break;
/*      */     case 11:
/* 1764 */       if (!(getCurrentProject() instanceof GameProject))
/* 1765 */         return;
/* 1766 */       a = getCurrentFolder();
/* 1767 */       if (a == null) {
/* 1768 */         JOptionPane.showMessageDialog(null, "Select a folder on the project tree!");
/* 1769 */         return;
/*      */       }
/* 1771 */       addFile(getCurrentFolder(), "newTileset" + ((GameProject)getCurrentProject()).tilesets++, "tileset");
/* 1772 */       break;
/*      */     case 12:
/* 1774 */       if (!(getCurrentProject() instanceof GameProject))
/* 1775 */         return;
/* 1776 */       a = getCurrentFolder();
/* 1777 */       if (a == null) {
/* 1778 */         JOptionPane.showMessageDialog(null, "Select a folder on the project tree!");
/* 1779 */         return;
/*      */       }
/* 1781 */       addFile(getCurrentFolder(), "newTimeline" + ((GameProject)getCurrentProject()).timelines++, "timeline");
/* 1782 */       break;
/*      */     case 13:
/* 1785 */       if ((getCurrentProject() instanceof GameProject)) {
/* 1786 */         i = ((GameProject)getCurrentProject()).scripts;
/*      */       }
/*      */       else
/*      */       {
/* 1787 */         if ((getCurrentProject() instanceof ModuleProject))
/* 1788 */           i = ((ModuleProject)getCurrentProject()).scripts;
/*      */         else
/*      */           return;
/*      */       }
/* 1790 */       a = getCurrentFolder();
/* 1791 */       if (a == null) {
/* 1792 */         JOptionPane.showMessageDialog(null, "Select a folder on the project tree!");
/* 1793 */         return;
/*      */       }
/* 1795 */       addFile(getCurrentFolder(), "newScript" + i, "gs");
/* 1796 */       if ((getCurrentProject() instanceof GameProject))
/* 1797 */         ((GameProject)getCurrentProject()).scripts += 1;
/* 1798 */       else if ((getCurrentProject() instanceof ModuleProject))
/* 1799 */         ((ModuleProject)getCurrentProject()).scripts += 1; break;
/*      */     case 14:
/* 1802 */       Folder f = getCurrentFolder();
/* 1803 */       int in = 1;
/* 1804 */       for (Iterator i$ = f.getChildren().iterator(); i$.hasNext(); ) { Object o = i$.next();
/* 1805 */         if (((GObject)o).name.equals("subgroup" + in)) {
/* 1806 */           in++;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1811 */       addGroup(f, f.newGroup("subgroup" + in));
/*      */     }
/*      */   }
/*      */ 
/*      */   public GFile addFile(Folder folder, String name, String type)
/*      */   {
/* 1822 */     if (folder == null) {
/* 1823 */       return null;
/*      */     }
/* 1825 */     if (!folder.allowsFileType(type)) {
/* 1826 */       folder = folder.magicAddition(type);
/* 1827 */       if (folder == null) {
/* 1828 */         return null;
/*      */       }
/*      */     }
/* 1831 */     GFile file = new GFile(folder, name, type, null);
/*      */ 
/* 1835 */     ObjectNode node = new ObjectNode(file);
/* 1836 */     folder.node.add(node);
/* 1837 */     TreePath tp = new TreePath(node.getPath());
/* 1838 */     workspace.setSelectionPath(tp);
/* 1839 */     Open(file);
/* 1840 */     workspace.updateUI();
/* 1841 */     return file;
/*      */   }
/*      */ 
/*      */   public boolean addGroup(Folder folder, Group group)
/*      */   {
/* 1847 */     if (folder == null) {
/* 1848 */       return false;
/*      */     }
/* 1850 */     if (!folder.allowsGroup(group)) {
/* 1851 */       return false;
/*      */     }
/* 1853 */     ObjectNode node = new ObjectNode(group);
/* 1854 */     folder.node.add(node);
/* 1855 */     workspace.updateUI();
/* 1856 */     return true;
/*      */   }
/*      */ 
/*      */   public void SaveProject()
/*      */   {
/* 1862 */     if (getCurrentProject() != null)
/* 1863 */       ProjectExporter.export(getCurrentProject(), getCurrentProject().name + ".gcp");
/*      */   }
/*      */ 
/*      */   public void SaveProject(Project p)
/*      */   {
/* 1870 */     if (p != null)
/* 1871 */       ProjectExporter.export(p, p.name + ".gcp");
/*      */   }
/*      */ 
/*      */   public void CloseProject(Project p)
/*      */   {
/* 1878 */     utilities.addStringMessage("close project");
/*      */ 
/* 1880 */     closeAllTabs(p.froot);
/*      */ 
/* 1882 */     this.top.remove(getCurrentProject().froot);
/* 1883 */     workspace.updateUI();
/*      */   }
/*      */ 
/*      */   public void CloseProject(Project p, boolean askForConfirmation)
/*      */   {
/* 1889 */     if (!askForConfirmation) {
/* 1890 */       CloseProject(p);
/* 1891 */       return;
/*      */     }
/* 1893 */     if (p == null) {
/* 1894 */       return;
/*      */     }
/* 1896 */     int option = JOptionPane.showConfirmDialog(this, "Do you want to save your project first?");
/* 1897 */     if (option == 2) {
/* 1898 */       return;
/*      */     }
/* 1900 */     if (option == 0) {
/* 1901 */       SaveProject(p);
/*      */     }
/* 1903 */     CloseProject(p);
/*      */   }
/*      */ 
/*      */   public void CloseProject()
/*      */   {
/* 1909 */     if (getCurrentProject() == null) {
/* 1910 */       JOptionPane.showMessageDialog(this, "Please select a project.");
/* 1911 */       return;
/*      */     }
/* 1913 */     int option = JOptionPane.showConfirmDialog(this, "Do you want to save your project first?");
/* 1914 */     if (option == 2) {
/* 1915 */       return;
/*      */     }
/* 1917 */     if (option == 0) {
/* 1918 */       SaveProject();
/*      */     }
/* 1920 */     CloseProject(getCurrentProject());
/*      */   }
/*      */ 
/*      */   public void createToolBar()
/*      */   {
/* 1926 */     this.toolpopup = new ToolbarPopupMenu();
/* 1927 */     ToolbarManager.makeToolbars(this);
/*      */   }
/*      */ 
/*      */   public void dispose()
/*      */   {
/* 1934 */     if ((!gcreator.applet) && (gcreator.plugload)) {
/* 1935 */       Plugger.onMainWindowDispose();
/*      */     }
/* 1937 */     saveSettings();
/* 1938 */     if (this.istabs) {
/* 1939 */       for (Component a : tabs.getComponents()) {
/* 1940 */         if ((a instanceof TabPanel))
/* 1941 */           ((TabPanel)a).dispose();
/*      */         else {
/* 1943 */           for (Component x : this.mdi.getComponents()) {
/* 1944 */             if ((x instanceof ExtendedFrame)) {
/* 1945 */               ((ExtendedFrame)x).dispose();
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 1951 */     System.exit(0);
/* 1952 */     super.dispose();
/*      */   }
/*      */ 
/*      */   public void saveSettings()
/*      */   {
/* 1958 */     SettingsIO.saveSettings(this.look, this.istabs, this.scroller.isVisible());
/*      */     try {
/* 1960 */       ToolbarManager.writeToolbarFile("settings/toolbarList.gctl");
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*      */     }
/*      */   }
/*      */ 
/*      */   public void remove(TabPanel panel, JInternalFrame frame) {
/* 1968 */     tabs.remove(panel);
/*      */     try {
/* 1970 */       this.mdi.remove(frame);
/*      */     }
/*      */     catch (NullPointerException e)
/*      */     {
/*      */     }
/*      */   }
/*      */ 
/*      */   public void SaveMainProject(boolean saveAs)
/*      */   {
/* 1979 */     System.out.println("Saving...");
/* 1980 */     if (this.istabs) {
/* 1981 */       for (int ii = 0; ii < tabs.getTabCount(); ii++) {
/* 1982 */         if ((((TabPanel)tabs.getComponentAt(ii)).project != null) && 
/* 1983 */           (((TabPanel)tabs.getComponentAt(ii)).project.equals(getMainProject())) && (((TabPanel)tabs.getComponentAt(ii)).wasModified()))
/* 1984 */           ((TabPanel)tabs.getComponentAt(ii)).Save();
/*      */       }
/*      */     }
/*      */     else {
/* 1988 */       for (int ii = 0; ii < this.mdi.getComponentCount(); ii++) {
/* 1989 */         if ((((ExtendedFrame)this.mdi.getComponent(ii)).getPanel().project != null) && 
/* 1990 */           (((ExtendedFrame)this.mdi.getComponent(ii)).getPanel().project.equals(getMainProject())) && (((ExtendedFrame)this.mdi.getComponent(ii)).getPanel().wasModified())) {
/* 1991 */           ((ExtendedFrame)this.mdi.getComponent(ii)).getPanel().Save();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 1996 */     if ((mainProject.location == null) || (mainProject.location.equals("")) || (saveAs)) {
/* 1997 */       JFileChooser fc = new JFileChooser();
/* 1998 */       fc.setFileFilter(new CustomFileFilter(".gcp", "G-Creator Project File"));
/* 1999 */       fc.showSaveDialog(gcreator.window);
/* 2000 */       File file = fc.getSelectedFile();
/* 2001 */       if (file == null) {
/* 2002 */         return;
/*      */       }
/* 2004 */       mainProject.location = file.getPath();
/* 2005 */       if (!mainProject.location.contains(".gcp"))
/*      */       {
/* 2007 */         mainProject.location += ".gcp";
/*      */       }
/*      */     }
/* 2010 */     ProjectExporter.export(mainProject, mainProject.location);
/*      */   }
/*      */ 
/*      */   static
/*      */   {
/* 1391 */     chooseImage.setDialogTitle("Select Image");
/* 1392 */     chooseImage.setDialogType(0);
/* 1393 */     chooseImage.setApproveButtonText("OK");
/* 1394 */     chooseImage.setFileSelectionMode(0);
/*      */   }
/*      */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.core.Aurwindow
 * JD-Core Version:    0.6.2
 */