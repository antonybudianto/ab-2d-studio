/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ab2ds.dialog;

import com.ab2ds.core.MainFrame;
import java.io.File;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Antony
 */
public class ExportAndroidDialog extends javax.swing.JFrame {

    /**
     * Creates new form ExportAndroidDialog
     */
    private MainFrame mainframe;
    private File androidpath;
    private Vector<String> scenes;
    
    public ExportAndroidDialog(MainFrame mainframe) {
        initComponents();
        setLocationRelativeTo(null);
        this.mainframe = mainframe;
        scenes = mainframe.getSceneList();
        DefaultListModel d = new DefaultListModel();
        for(String s : scenes){
            d.addElement(s);
        }
        listscene.setModel(d);
        mainframe.getAssetManager().init();
        String path = mainframe.getAssetManager().getAndroidProjectAbsPath();
        if(path != null){
            txtpath.setText(path);
            androidpath = new File(path);
            mainframe.filechooser.setSelectedFile(androidpath);
        }
        loadXMLObjectList();
    }
    
    private void loadXMLObjectList(){
        DefaultListModel d = new DefaultListModel();
        File f = new File(mainframe.getProjectAbsPath()+"/project/src/com/objects");
        if(f.isDirectory()){
            for(File tmp : f.listFiles()){
                if(tmp.isFile() && tmp.getName().endsWith(".xml")){
                    d.addElement(tmp.getName());
                }
            }
        }
        listxmlobj.setModel(d);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtpath = new javax.swing.JTextField();
        jbtbrowse = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbtexport = new javax.swing.JButton();
        jcbsavepath = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listscene = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listxmlobj = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Export asset to Android");

        jLabel1.setText("Android Project Folder Path");

        txtpath.setEditable(false);

        jbtbrowse.setText("Browse");
        jbtbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtbrowseActionPerformed(evt);
            }
        });

        jLabel2.setText("Select asset to export (you can multi select the items)");

        jbtexport.setBackground(new java.awt.Color(0, 102, 102));
        jbtexport.setForeground(new java.awt.Color(255, 255, 255));
        jbtexport.setText("Export");
        jbtexport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtexportActionPerformed(evt);
            }
        });

        jcbsavepath.setText("Save the path");

        listscene.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listscene);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Scene", jPanel1);

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("XML Object", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jcbsavepath)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpath, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtbrowse)
                                .addGap(0, 42, Short.MAX_VALUE))
                            .addComponent(jbtexport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtbrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbsavepath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtexport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtbrowseActionPerformed
        mainframe.filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int n = mainframe.filechooser.showOpenDialog(null);
        if(n == JFileChooser.APPROVE_OPTION){
            androidpath = mainframe.filechooser.getSelectedFile();
            txtpath.setText(androidpath.getAbsolutePath());
        }
    }//GEN-LAST:event_jbtbrowseActionPerformed

    private void jbtexportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtexportActionPerformed
        if(listscene.getSelectedValues().length > 0){
            Runtime r = Runtime.getRuntime();
            String mypath = mainframe.getProjectAbsPath()+"/project/src/com";
            String destfolder = androidpath.getAbsolutePath()+"/src/com";
            
            String from = "";
            try {
                for(Object s : listscene.getSelectedValues()){
                    from += "xcopy \""+mypath+"/scenes/"+s+"\" \""+destfolder+"/scenes/\" /s/h/e/k/f/c/y & ";
                }
                for(Object s : listxmlobj.getSelectedValues()){
                    from += "xcopy \""+mypath+"/objects/"+s+"\" \""+destfolder+"/objects/\" /s/h/e/k/f/c/y & ";
                }
                r.exec("cmd /c start cmd.exe /K \""
                        + from + "\"");

                if(jcbsavepath.isSelected()){
                    mainframe.getAssetManager().setAndroidProject(androidpath);
                    mainframe.getAssetManager().save();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select at least one scene to export", "Scene Export Manager", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbtexportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtbrowse;
    private javax.swing.JButton jbtexport;
    private javax.swing.JCheckBox jcbsavepath;
    private javax.swing.JList listscene;
    private javax.swing.JList listxmlobj;
    private javax.swing.JTextField txtpath;
    // End of variables declaration//GEN-END:variables
}
