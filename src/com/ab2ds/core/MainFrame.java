package com.ab2ds.core;

import com.ab2ds.dialog.AnimatedSpriteDialog;
import com.ab2ds.dialog.AssetManagerDialog;
import com.ab2ds.dialog.ExportAndroidDialog;
import com.ab2ds.dialog.NewProjectDialog;
import com.ab2ds.panels.AnimatedSpritePanel;
import com.ab2ds.panels.TextPropertyPanel;
import com.ab2ds.util.EngineParser;
import com.ab2ds.util.XMLEngine;
import com.falcron.core.GameResource;
import com.falcron.core.Renderable;
import com.falcron.graphics.core.SimpleText;
import com.falcron.graphics.scene.SimpleScene;
import com.falcron.sprite.AnimatedSprite;
import com.falcron.sprite.Entity;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.w3c.dom.Element;

/**
 *
 * @author Antony
 */
public class MainFrame extends javax.swing.JFrame implements MouseMotionListener{

    /**
     * Creates new form MainFrame
     */
    public final JFileChooser filechooser;
    private  PreviewGame previewgame;
    private SimpleScene currentscene;
    public String currentscenestr;
    private TextPropertyPanel textprop;
    private AnimatedSpritePanel animprop;
    private AssetManagerDialog assetdialog;
    public ClassLoader classloader;
    
    public AssetManagerDialog getAssetManager(){
        return assetdialog;
    }
    
    public Vector<String> getSceneList(){
        return this.assetdialog.getSceneList();
    }
    
    public String getProjectAbsPath(){
        return this.assetdialog.getProjectAbsPath();
    }
    
    public SimpleScene getCurrentScene(){
        return this.currentscene;
    }
    
    public void setAnimatedSprite(AnimatedSprite as){
        currentscene.addRenderable(as);
        setAnimspriteButton(false);
    }
    
    public void addXMLObject(String name){
        try {
            File f = new File(getProjectAbsPath()+"/project/src/com/objects/"+name+".xml");
            currentscene.addRenderable(currentscene.loadXMLObject(f, getClassLoader()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private MouseAdapter mouseclick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1){
                if(currentscene!=null){
                    if(jbtText.isSelected()){
                        String text = JOptionPane.showInputDialog("Text:");
                        if(text.length()>0){
                            SimpleText tmp = new SimpleText(text, currentscene);
                            tmp.color = Color.yellow;
                            tmp.location.x = e.getX();
                            tmp.location.y = e.getY();
                            currentscene.addRenderable(tmp);
                        }else{
                            JOptionPane.showMessageDialog(null, "Text length must be greater than 0!");
                        }
                    }else if(jbtSprite.isSelected()){
                        AnimatedSpriteDialog asd = new AnimatedSpriteDialog(MainFrame.this, e.getPoint());
                        asd.setVisible(true);
                    }else{
                        Renderable r = ((NewScene)currentscene).checkClick(e);
                        if(r!=null){
                            if(r instanceof SimpleText){
                                jpProp.removeAll();
                                jpProp.setLayout(null);
                                textprop.set((SimpleText)r, currentscene);
                                jpProp.add(textprop);
                                jpProp.updateUI();
                                textprop.setBounds(2, 30, textprop.getWidth(), textprop.getHeight());
                            }else if(r instanceof AnimatedSprite){
                                jpProp.removeAll();
                                jpProp.setLayout(null);
                                animprop.set((AnimatedSprite)r, currentscene);
                                jpProp.add(animprop);
                                jpProp.updateUI();
                                animprop.setBounds(2, 30, animprop.getWidth(), animprop.getHeight());
                            }
                        }
                    }
                }
            }
        }
    };
    
    public MainFrame() {
        initComponents();
        filechooser = new JFileChooser();
        //previewgame = new PreviewGame();
        //Add default newscene
        //previewgame.addScene("newscene", NewScene.class);
        //Make a null layout
        jpScene.setLayout(null);
        //Attach simplegame panel to our preview panel
        //jpScene.add(previewgame.scenepanel);
        //previewgame.scenepanel.addMouseListener(mouseclick);
        //our property
        jpProp.setLayout(new GridLayout(1, 1));
        textprop = new TextPropertyPanel(this);
        animprop = new AnimatedSpritePanel(this);
        assetdialog = new  AssetManagerDialog(this);
       
        
        addMouseMotionListener(this);
        setTitle("AB 2D Studio");
        setSize(1024, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMain = new javax.swing.JPanel();
        jpObjectProp = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelfps = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelups = new javax.swing.JLabel();
        jpProp = new javax.swing.JPanel();
        jpPallete = new javax.swing.JPanel();
        jbtText = new javax.swing.JToggleButton();
        jbtSprite = new javax.swing.JToggleButton();
        jbtImage = new javax.swing.JToggleButton();
        jpScene = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiCreateNP = new javax.swing.JMenuItem();
        jmiOP = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiSaveCurrentScene = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiExit = new javax.swing.JMenuItem();
        jmView = new javax.swing.JMenu();
        jmiAssetManager = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jmiCompileRun = new javax.swing.JMenuItem();
        jmiJAR = new javax.swing.JMenuItem();
        jmiExportAndroid = new javax.swing.JMenuItem();
        jmHelp = new javax.swing.JMenu();
        jmiAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpMain.setBackground(new java.awt.Color(102, 102, 102));
        jpMain.setLayout(new java.awt.BorderLayout());

        jpObjectProp.setBorder(javax.swing.BorderFactory.createTitledBorder("Object Properties"));
        jpObjectProp.setPreferredSize(new java.awt.Dimension(400, 193));

        jLabel1.setText("FPS :");
        jLabel1.setToolTipText("<html>\n<b color=\"blue\">Frame per second</b>\n</html>");

        labelfps.setText("-");

        jLabel2.setText("UPS :");
        jLabel2.setToolTipText("<html>\n<b color=\"blue\">Update per second</b>\n</html>");

        labelups.setText("-");

        javax.swing.GroupLayout jpPropLayout = new javax.swing.GroupLayout(jpProp);
        jpProp.setLayout(jpPropLayout);
        jpPropLayout.setHorizontalGroup(
            jpPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpPropLayout.setVerticalGroup(
            jpPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpObjectPropLayout = new javax.swing.GroupLayout(jpObjectProp);
        jpObjectProp.setLayout(jpObjectPropLayout);
        jpObjectPropLayout.setHorizontalGroup(
            jpObjectPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpObjectPropLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpObjectPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpObjectPropLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelfps))
                    .addGroup(jpObjectPropLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelups)))
                .addContainerGap(339, Short.MAX_VALUE))
            .addComponent(jpProp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpObjectPropLayout.setVerticalGroup(
            jpObjectPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpObjectPropLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpObjectPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelfps))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpObjectPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelups))
                .addGap(18, 18, 18)
                .addComponent(jpProp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpMain.add(jpObjectProp, java.awt.BorderLayout.LINE_END);

        jpPallete.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtText.setText("Text");
        jbtText.setToolTipText("<html>\n<b color=\"blue\">Create a simple text</b>\n</html>");
        jbtText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtTextActionPerformed(evt);
            }
        });
        jpPallete.add(jbtText);

        jbtSprite.setText("Animated Sprite");
        jbtSprite.setToolTipText("<html>\n<b color=\"blue\">Create an animated sprite using a spritesheet</b>\n</html>");
        jbtSprite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSpriteActionPerformed(evt);
            }
        });
        jpPallete.add(jbtSprite);

        jbtImage.setText("Image");
        jpPallete.add(jbtImage);

        jpMain.add(jpPallete, java.awt.BorderLayout.PAGE_START);

        jpScene.setBorder(javax.swing.BorderFactory.createTitledBorder("Current Scene"));
        jpScene.setMaximumSize(new java.awt.Dimension(720, 480));
        jpScene.setPreferredSize(new java.awt.Dimension(600, 320));

        javax.swing.GroupLayout jpSceneLayout = new javax.swing.GroupLayout(jpScene);
        jpScene.setLayout(jpSceneLayout);
        jpSceneLayout.setHorizontalGroup(
            jpSceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        jpSceneLayout.setVerticalGroup(
            jpSceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        jpMain.add(jpScene, java.awt.BorderLayout.CENTER);

        jmFile.setText("File");
        jmFile.setName(""); // NOI18N

        jmiCreateNP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmiCreateNP.setText("Create new project");
        jmiCreateNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCreateNPActionPerformed(evt);
            }
        });
        jmFile.add(jmiCreateNP);

        jmiOP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jmiOP.setText("Open project");
        jmiOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOPActionPerformed(evt);
            }
        });
        jmFile.add(jmiOP);
        jmFile.add(jSeparator1);

        jmiSaveCurrentScene.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiSaveCurrentScene.setText("Save current scene");
        jmiSaveCurrentScene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaveCurrentSceneActionPerformed(evt);
            }
        });
        jmFile.add(jmiSaveCurrentScene);
        jmFile.add(jSeparator2);

        jmiExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jmiExit.setText("Exit");
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmFile.add(jmiExit);

        jMenuBar1.add(jmFile);

        jmView.setText("Project");

        jmiAssetManager.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jmiAssetManager.setText("Asset Manager");
        jmiAssetManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAssetManagerActionPerformed(evt);
            }
        });
        jmView.add(jmiAssetManager);
        jmView.add(jSeparator3);

        jmiCompileRun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jmiCompileRun.setText("Compile and Run");
        jmiCompileRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCompileRunActionPerformed(evt);
            }
        });
        jmView.add(jmiCompileRun);

        jmiJAR.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        jmiJAR.setText("Create JAR");
        jmiJAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiJARActionPerformed(evt);
            }
        });
        jmView.add(jmiJAR);

        jmiExportAndroid.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        jmiExportAndroid.setText("Export asset to Android");
        jmiExportAndroid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExportAndroidActionPerformed(evt);
            }
        });
        jmView.add(jmiExportAndroid);

        jMenuBar1.add(jmView);

        jmHelp.setText("Help");

        jmiAbout.setText("About");
        jmiAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAboutActionPerformed(evt);
            }
        });
        jmHelp.add(jmiAbout);

        jMenuBar1.add(jmHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiExitActionPerformed

    private void saveCurrentScene(File file){
        //File f = new File(assetdialog.getProjectAbsPath()+"/project/src/com/scenes");
        XMLEngine xml = new XMLEngine();
        Element root = xml.appendRoot("renderables");
        Element txts = xml.appendChild(root, "simpletexts");
        Element anims = xml.appendChild(root, "animatedsprites");
        for(Renderable r : ((NewScene)currentscene).getRenderables()){
            //For each supported scene element
            if(r instanceof SimpleText){
                SimpleText st = (SimpleText) r;
                EngineParser.parseSimpleText(xml, txts, st);
            }else if(r instanceof AnimatedSprite){
                AnimatedSprite as = (AnimatedSprite) r;
                EngineParser.parseAnimatedSprite(xml, anims, as, as.imageresource.path, as.imageresource.resourcename);
            }
        }
        xml.save(file.getAbsolutePath()+"/"+currentscenestr);
    }
    
    private void loadProject(File f){
             assetdialog.setProject(f);
             try {
                String abp = getProjectAbsPath()+"/project";
                File file = new File(abp+"/bin");
                URL url = file.toURL();
                URL[] urls = new URL[]{url};
                classloader = new URLClassLoader(urls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            int[]wh = assetdialog.getGameWH();
            previewgame = new PreviewGame(wh[0], wh[1]);
            previewgame.addScene("newscene", NewScene.class);
            jpScene.add(previewgame.scenepanel);
            previewgame.scenepanel.addMouseListener(mouseclick);
            JOptionPane.showMessageDialog(null, "Project loaded");
    }
    
    private void openProject(){
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int n = filechooser.showOpenDialog(null);
        if(n == JFileChooser.APPROVE_OPTION){
            loadProject(filechooser.getSelectedFile());
        }
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }
    
    private boolean checkInt(String s){
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    private void jmiCreateNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCreateNPActionPerformed
        
        
        NewProjectDialog npd = new NewProjectDialog(new NewProjectDialog.NPRunnable() {
            @Override
            public void onSubmit(int w, int h) {
                int input = filechooser.showSaveDialog(null);
                if(input == JFileChooser.APPROVE_OPTION){
                    //Create folder with specified folder name from filechooser
                    File f = filechooser.getSelectedFile();
                    f.mkdir();

                    //Create config xml file
                    XMLEngine xml = new XMLEngine();
                    Element root = xml.appendRoot("config");
                    Element frame = xml.appendChild(root,"frame");
                    Element scenes = xml.appendChild(root, "scenes");
                    Element andro = xml.appendChild(root, "android");
                    Element aproject = xml.appendChild(andro, "project");
                    xml.addAttr(aproject, "path", "");
                    xml.addAttr(frame, "width", w+"");
                    xml.addAttr(frame, "height", h+"");
                    Element mainscene = xml.appendChild(scenes, "scene");
                    xml.addAttr(mainscene, "name", "MainScene");
                    xml.addAttr(mainscene, "xml", "MainScene.xml");
                    xml.save(f.getAbsolutePath()+"/main.xml");

                    //Copy bootstrap project folder
                    Runtime r = Runtime.getRuntime();
                    File ftmp = new File(MainFrame.class.getProtectionDomain().getCodeSource().getLocation().getPath());
                    try {
                        r.exec("cmd /c start cmd.exe /K \""
                                + "cd /d "+ftmp.getParent()+" & "
                                + "xcopy \"project\" \""+f.getAbsolutePath()+"/project\" /s /e /h /i & "
                                + "mkdir \""+f.getAbsolutePath()+"/lib\" & "
                                + "xcopy \"project/FF.jar\" \""+f.getAbsolutePath()+"/lib/\" /k/f/c/y \"");
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }

                    loadProject(f);
                }
            }
        });
        npd.setVisible(true);
        
        
    }//GEN-LAST:event_jmiCreateNPActionPerformed

    public void newScene(){
        if(assetdialog.isLoaded()){
            if(currentscene != null){
                //Stop the current scene safely if it's not null (or running)
                currentscene.stop();
            }
            File f = new File(assetdialog.getProjectAbsPath()+"/project/src/com/scenes/");
            filechooser.setSelectedFile(f);
            int n = filechooser.showSaveDialog(null);
            if(n == JFileChooser.APPROVE_OPTION){
                //Load new scene (auto create new instance of NewScene class)
                currentscene = previewgame.loadScene("newscene");
                previewgame.scenepanel.setBounds(10, 30, currentscene.getWidth(), currentscene.getHeight());
                currentscene.addMouseListener(mouseclick);
                currentscene.addMouseMotionListener(this);
                //Reupdate the panel UI
                jpScene.updateUI();
                currentscenestr = filechooser.getSelectedFile().getName()+".xml";
                this.saveCurrentScene(f);
                assetdialog.addScene(currentscenestr);
                assetdialog.save();
            }
        }else{
            assetdialog.showNotLoaded();
        }
    }
    
    private void jbtTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtTextActionPerformed
        setTextButton(jbtText.isSelected());
    }//GEN-LAST:event_jbtTextActionPerformed

    private void jmiSaveCurrentSceneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveCurrentSceneActionPerformed
       //Save the scene
        if(assetdialog.isLoaded()){
            if(currentscene != null){
                this.saveCurrentScene(new File(assetdialog.getProjectAbsPath()+"/project/src/com/scenes"));
            }else{
                JOptionPane.showMessageDialog(null, "No scene to save");
            }
        }else{
            assetdialog.showNotLoaded();
        }
    }//GEN-LAST:event_jmiSaveCurrentSceneActionPerformed

    public ClassLoader getClassLoader(){
         //Add classpath from the open project
        try {
            String abp = getProjectAbsPath()+"/project";
            File file = new File(abp+"/bin");
            URL url = file.toURL();
            URL[] urls = new URL[]{url};
            ClassLoader cl = new URLClassLoader(urls);
            return cl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
    
    public void openViaAssetManager(String xml){
        GameResource.getInstance().setImageResourcePath(assetdialog.getProjectAbsPath()+"/project/img");
        File f = new File(assetdialog.getProjectName()+"/project/src/com/scenes/"+xml);
        if(!f.exists()){
            JOptionPane.showMessageDialog(null, "Scene XML file isn't found");
        }else{
            try {
                //Load new scene (auto create new instance of NewScene class)
                   currentscene = previewgame.loadScene("newscene");
                   previewgame.scenepanel.setBounds(10, 30, currentscene.getWidth(), currentscene.getHeight());
                   currentscene.addMouseListener(mouseclick);
                   currentscene.addMouseMotionListener(this);
                   currentscene.setFocusable(true);
                   //Reupdate the panel UI
                   jpScene.updateUI();
                   
                   //Add classpath from the open project
                   String abp = getProjectAbsPath()+"/project";
                   File file = new File(abp+"/bin");
                   URL url = file.toURL();
                   URL[] urls = new URL[]{url};
                   ClassLoader cl = new URLClassLoader(urls);
                   currentscene.loadXML(f, cl);
                   currentscenestr = xml;
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void jmiAssetManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAssetManagerActionPerformed

        assetdialog.setVisible(true);
    }//GEN-LAST:event_jmiAssetManagerActionPerformed

    private void jmiOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOPActionPerformed
       if(assetdialog.isLoaded()){
          dispose();
          currentscene.stop();
          MainFrame mf = new MainFrame(); mf.setVisible(true);
          mf.openProject();
       }else{
          this.openProject();
       }
    }//GEN-LAST:event_jmiOPActionPerformed
    
    private void jmiCompileRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCompileRunActionPerformed
       //Save the scene first!
        if(currentscene != null){
            this.saveCurrentScene(new File(assetdialog.getProjectAbsPath()+"/project/src/com/scenes"));
        }
        
        //Compile the project
        Runtime r = Runtime.getRuntime();
        String abp = assetdialog.getProjectAbsPath()+"/project";
        String jpt = abp+"/src/com";
        try {
            r.exec("cmd /c start cmd.exe /K \" "
                    + "echo Compiling source code to class... & "
                    + "javac -d \""+abp+"/bin\" -cp \""+abp+"/FF.jar;\" "+jpt+"/core/*.java "+jpt+"/scenes/*.java "+jpt+"/scripts/*.java & "
                    + "echo Copying resources to bin... & "
                    + "xcopy \""+abp+"/src/com/scenes/*.xml\" \""+abp+"/bin/com/scenes/\" /s/h/e/k/f/c/y & "
                    + "xcopy \""+abp+"/src/com/objects/*.xml\" \""+abp+"/bin/com/objects/\" /s/h/e/k/f/c/y & "
                    + "cd /d "+abp+"/bin & "
                    + "java -cp \""+abp+"/FF.jar;\" com.core.Main\"");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jmiCompileRunActionPerformed

    private void jmiJARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiJARActionPerformed
        File f = new File(assetdialog.getProjectAbsPath()+"/project/bin/manifest.mf");
        String abp1 = assetdialog.getProjectAbsPath()+"/project/bin";
        try {
            //Create the manifest.mf file for JAR
            f.createNewFile();
            PrintWriter pw = new PrintWriter(f);
            pw.println("Class-Path: lib/FF.jar");
            pw.println("Main-Class: com.core.Main");
            pw.println();
            pw.close();
            
            Runtime r = Runtime.getRuntime();
            r.exec("cmd /c start cmd.exe /K \"cd /d "+abp1+" & "
                    + "echo Creating Manifest file... & "
                    + "echo Creating JAR from bin... & "
                    + "jar cvfm "+assetdialog.getProjectAbsPath()+"/Game.jar manifest.mf com/scenes/*.class com/scenes/*.xml com/core/*.class com/scripts/*.class com/objects/*.xml & "
                    + "explorer "+assetdialog.getProjectAbsPath()+"\"");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jmiJARActionPerformed

    private void jmiAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAboutActionPerformed
        JOptionPane.showMessageDialog(null, "AB 2D Studio Alpha v4.0\n"
                + "- New Open Project with game width and height setup\n"
                + "- New animation transition in animated sprite editor\n"
                + "- Exporting xml not required anymore\n"
                + "- New XML Object to store and load object dynamically"
                + "\nCreated by Antony Budianto (AB13-0)\n"
                + "2014", "About AB 2D Studio", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jmiAboutActionPerformed

    private void jbtSpriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSpriteActionPerformed
        setAnimspriteButton(jbtSprite.isSelected());
    }//GEN-LAST:event_jbtSpriteActionPerformed

    private void jmiExportAndroidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExportAndroidActionPerformed
        ExportAndroidDialog ead = new ExportAndroidDialog(this);
        ead.setVisible(true);
    }//GEN-LAST:event_jmiExportAndroidActionPerformed

    private void setAnimspriteButton(boolean b){
        jbtSprite.setSelected(b);
        if(b){
            Image i = Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/com/asset/spritecursor.png"));
            Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(i, new Point(), "img");
            jpScene.setCursor (c);
        }else{
            jpScene.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    private void setTextButton(boolean b){
        jbtText.setSelected(b);
        if(b){
            Image i = Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/com/asset/textcursor.png"));
            Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(i, new Point(), "img");
            jpScene.setCursor (c);
        }else{
            jpScene.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToggleButton jbtImage;
    private javax.swing.JToggleButton jbtSprite;
    private javax.swing.JToggleButton jbtText;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenu jmHelp;
    private javax.swing.JMenu jmView;
    private javax.swing.JMenuItem jmiAbout;
    private javax.swing.JMenuItem jmiAssetManager;
    private javax.swing.JMenuItem jmiCompileRun;
    private javax.swing.JMenuItem jmiCreateNP;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiExportAndroid;
    private javax.swing.JMenuItem jmiJAR;
    private javax.swing.JMenuItem jmiOP;
    private javax.swing.JMenuItem jmiSaveCurrentScene;
    private javax.swing.JPanel jpMain;
    private javax.swing.JPanel jpObjectProp;
    private javax.swing.JPanel jpPallete;
    private javax.swing.JPanel jpProp;
    private javax.swing.JPanel jpScene;
    public static javax.swing.JLabel labelfps;
    public static javax.swing.JLabel labelups;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseDragged(MouseEvent e) {
        if(currentscene!=null){
            for(Renderable r : ((NewScene)currentscene).getRenderables()){
                if(r instanceof Entity){
                    Entity en = (Entity)r;
                    if(en.getBounds().contains(e.getPoint())){
                            en.location.x = e.getX() - en.width/2;
                            en.location.y = e.getY() - en.height/2;
                            break;
                     }
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}