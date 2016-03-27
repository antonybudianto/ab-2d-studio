/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ab2ds.dialog;

import com.ab2ds.core.MainFrame;
import com.ab2ds.util.XMLEngine;
import java.io.File;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Antony
 */
public class AssetManagerDialog extends javax.swing.JFrame {

    /**
     * Creates new form AssetManagerDialog
     */
    private File currentProject, androidProject;
    private MainFrame mainframe;
    private Vector<String> scenes = new Vector<String>();
    
    public AssetManagerDialog(MainFrame mainframe) {
        initComponents();
        this.mainframe = mainframe;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    public boolean isLoaded(){
        return currentProject != null;
    }
    
    public void showNotLoaded(){
        JOptionPane.showMessageDialog(null, "Please open your project first");
    }
    
    public String getProjectName(){
        return this.currentProject.getPath();
    }
    
    public String getProjectAbsPath(){
        return this.currentProject.getAbsolutePath();
    }
    
    public String getAndroidProjectAbsPath(){
        if(androidProject != null){
            return androidProject.getAbsolutePath();
        }
        return null;
    }
    
    public void setProject(File project){
        this.currentProject = project;
    }
    
    public void setAndroidProject(File androidpath) {
        this.androidProject = androidpath;
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        init();
    }
    
    public void deleteScene(String scene){
        int n = JOptionPane.showConfirmDialog(null, "Are you sure to delete this scene?","Confirm", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            scenes.remove(scene);
            save();
            
            File f = new File(getProjectAbsPath()+"/project/src/com/scenes/"+scene);
            f.delete();
            
            JOptionPane.showMessageDialog(null, "Scene deleted successfully", "Asset Manager", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void addScene(String scene){
        for(String s : scenes){
            if(s.equals(scene)){
                JOptionPane.showMessageDialog(null, "The scene name already exists", "Asset Manager", JOptionPane.WARNING_MESSAGE);
                break;
            }
        }
        scenes.add(scene);
    }
    
    public void save(){
        //Create config xml file
        XMLEngine xml = new XMLEngine();
        Element root = xml.appendRoot("config");
        Element escenes = xml.appendChild(root, "scenes");
        Element eandroid = xml.appendChild(root, "android");
        Element epath = xml.appendChild(eandroid, "project");
        if(androidProject != null){
            xml.addAttr(epath, "path", androidProject.getAbsolutePath());
        }
        for(String s : scenes){
            Element mainscene = xml.appendChild(escenes, "scene");
            xml.addAttr(mainscene, "xml", s);
        }
        xml.save(getProjectAbsPath()+"/main.xml");
        init();
    }
    
    public Vector<String> getSceneList(){
        Vector<String> tmp = new Vector<String>();
        File f = new File(currentProject.getAbsolutePath()+"/main.xml");
         XMLEngine xml = new XMLEngine(f);
        NodeList nodes = xml.getElements("scene");
        for(int i=0;i<nodes.getLength();i++){
            Element e = (Element) nodes.item(i);
            tmp.add(e.getAttribute("xml"));
        }
        return tmp;
    }
    
    public int[] getGameWH(){
        //Load scene from currentProject main.xml for basic config
        int w=0,h=0;
            File f = new File(currentProject.getAbsolutePath()+"/main.xml");
            if(f.exists()){
                XMLEngine xml = new XMLEngine(f);
                Element e = xml.getElement("frame");
                w = Integer.parseInt(e.getAttribute("width"));
                h = Integer.parseInt(e.getAttribute("height"));
            }
            return new int[]{w, h};
    }
    
    public void init(){
        listxmlobj.removeAll();
        listScenes.removeAll();
        scenes.clear();
        if(currentProject == null){
            dispose();
            JOptionPane.showMessageDialog(null, "Please open the project first", "Asset Manager", JOptionPane.WARNING_MESSAGE);
        }else{
            //Load scene from currentProject main.xml for basic config
            File f = new File(currentProject.getAbsolutePath()+"/main.xml");
            if(f.exists()){
                XMLEngine xml = new XMLEngine(f);
                NodeList nodes = xml.getElements("scene");
                
                Element eandroid = (Element) xml.getElements("android").item(0);
                Element eandpro = xml.getElement(eandroid, "project");
                if(!eandpro.getAttribute("path").equals("")){
                    androidProject = new File(eandpro.getAttribute("path"));
                }
                
                DefaultListModel d = new DefaultListModel();
                for(int i=0;i<nodes.getLength();i++){
                    Element e = (Element) nodes.item(i);
                    d.add(i, e.getAttribute("xml"));
                    addScene(e.getAttribute("xml"));
                }
                listScenes.setModel(d);
                
                //Load xml obj 
                DefaultListModel dobj = new DefaultListModel();
                File f2 = new File(currentProject.getAbsolutePath()+"/project/src/com/objects");
                if(f2.isDirectory()){
                    for(File fobj : f2.listFiles()){
                        if(fobj.isFile() && fobj.getName().endsWith(".xml")){
                            dobj.addElement(fobj.getName());
                        }
                    }
                }
                listxmlobj.setModel(dobj);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid project folder, closing the folder", "Asset Manager", JOptionPane.WARNING_MESSAGE);
                currentProject = null;
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listScenes = new javax.swing.JList();
        jmiNewScene = new javax.swing.JButton();
        jmiDelete = new javax.swing.JButton();
        jbtSceneOpen = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbtaddxmlobj = new javax.swing.JButton();
        jbtdelxmlobj = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listxmlobj = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asset Manager");

        listScenes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Scene1", "Scene2", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listScenes);

        jmiNewScene.setText("New");
        jmiNewScene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewSceneActionPerformed(evt);
            }
        });

        jmiDelete.setText("Delete");
        jmiDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDeleteActionPerformed(evt);
            }
        });

        jbtSceneOpen.setText("Open");
        jbtSceneOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSceneOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jmiNewScene)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtSceneOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jmiDelete)
                        .addGap(0, 102, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jmiNewScene)
                    .addComponent(jbtSceneOpen)
                    .addComponent(jmiDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Scenes", jPanel1);

        jbtaddxmlobj.setText("Add to scene");
        jbtaddxmlobj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtaddxmlobjActionPerformed(evt);
            }
        });

        jbtdelxmlobj.setText("Delete");
        jbtdelxmlobj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtdelxmlobjActionPerformed(evt);
            }
        });

        listxmlobj.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listxmlobj);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtaddxmlobj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtdelxmlobj)
                        .addGap(0, 125, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtaddxmlobj)
                    .addComponent(jbtdelxmlobj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("XML Objects", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSceneOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSceneOpenActionPerformed
        // TODO add your handling code here:
        if(scenes.isEmpty()){
            JOptionPane.showMessageDialog(null, "There is no scene in your project","Asset Manager", JOptionPane.INFORMATION_MESSAGE);
        }else{
            mainframe.openViaAssetManager(listScenes.getSelectedValue().toString());
            //mainframe.currentscenestr = listScenes.getSelectedValue().toString();
            dispose();
        }
    }//GEN-LAST:event_jbtSceneOpenActionPerformed

    private void jmiNewSceneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewSceneActionPerformed
        // TODO add your handling code here:
        mainframe.newScene();
    }//GEN-LAST:event_jmiNewSceneActionPerformed

    private void jmiDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDeleteActionPerformed
        // TODO add your handling code here:
        if(listScenes.getSelectedIndex() != -1){
            deleteScene(listScenes.getSelectedValue().toString());
        }
    }//GEN-LAST:event_jmiDeleteActionPerformed

    private void jbtaddxmlobjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtaddxmlobjActionPerformed
        String name = listxmlobj.getSelectedValue().toString().replace(".xml", "");
        mainframe.addXMLObject(name);
    }//GEN-LAST:event_jbtaddxmlobjActionPerformed

    private void jbtdelxmlobjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtdelxmlobjActionPerformed
        if(listxmlobj.getSelectedIndex() > -1){
            int n = JOptionPane.showConfirmDialog(null, "Are you sure to delete this XML Object?", "Asset Manager", JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION){
                File f = new File(mainframe.getProjectAbsPath()+"/project/src/com/objects/"+listxmlobj.getSelectedValue().toString());
                f.delete();
                init();
                JOptionPane.showMessageDialog(null, "XML Object deleted successfully", "Asset Manager", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbtdelxmlobjActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtSceneOpen;
    private javax.swing.JButton jbtaddxmlobj;
    private javax.swing.JButton jbtdelxmlobj;
    private javax.swing.JButton jmiDelete;
    private javax.swing.JButton jmiNewScene;
    private javax.swing.JList listScenes;
    private javax.swing.JList listxmlobj;
    // End of variables declaration//GEN-END:variables

    
}
