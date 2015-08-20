/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cumimpactsa;

import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author ast
 */
public class LoadDataForm extends javax.swing.JDialog {

    
    private int dataType;
    //DataGrid grid;
    
    /**
     * Creates new form LoadDataForm
     */
    public LoadDataForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * @summary Set data type - set before showing dialog.
     * @param type Data type constant from GlobalResources (stressor or ecocomp).
     */
   public void setDataType(int type)
   {
       dataType=type;
   }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        listYField = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        listValueField = new javax.swing.JList();
        labelName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listXField = new javax.swing.JList();
        textFieldCsvFile = new javax.swing.JTextField();
        textFieldName = new javax.swing.JTextField();
        buttonCancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonCsvFile = new javax.swing.JButton();
        buttonOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane3.setViewportView(listYField);

        jScrollPane1.setViewportView(listValueField);

        labelName.setText("Name");

        jScrollPane2.setViewportView(listXField);

        textFieldCsvFile.setEditable(false);
        textFieldCsvFile.setText("not selected");

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        jLabel3.setText("Value field");

        jLabel4.setText("X field");

        buttonCsvFile.setText("...");
        buttonCsvFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCsvFileActionPerformed(evt);
            }
        });

        buttonOk.setText("OK");
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        jLabel2.setText("CSV file");

        jLabel5.setText("Y field");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel4))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 116, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel5)
                                    .add(layout.createSequentialGroup()
                                        .add(buttonCancel)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(buttonOk, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 149, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(labelName)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(textFieldCsvFile)
                                    .add(textFieldName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 519, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(buttonCsvFile)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(labelName)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(textFieldName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(textFieldCsvFile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buttonCsvFile))
                .add(3, 3, 3)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel4)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .add(jScrollPane2)
                    .add(jScrollPane1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(buttonCancel)
                    .add(buttonOk))
                .add(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonCsvFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCsvFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File(GlobalResources.lastUsedFolder));//"/Users/ast/Desktop/E-IPER/Projects/CumImpactSA/MappingProjects")); //TODO make adjustable
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {

            File selectedFile = fileChooser.getSelectedFile();
            GlobalResources.lastUsedFolder=selectedFile.getParent();
            this.textFieldCsvFile.setText(selectedFile.getAbsolutePath());
            
            //to save time, save last opened table and re-use it if it's the same file
            CsvTable table;
            if(GlobalResources.lastOpenedTableFile.equals(selectedFile.getAbsolutePath()))
            {
                table = GlobalResources.lastOpenedTable;
            }
            else
            {
                table = new CsvTable();
                table.readFromFile(selectedFile);
                GlobalResources.lastOpenedTable=table;
                GlobalResources.lastOpenedTableFile=selectedFile.getAbsolutePath();
            }
            
           
            ArrayList<String> colNames = table.getColNames();

            DefaultListModel model;
            model = new DefaultListModel();
            for(int i=0; i<colNames.size();i++)
            {
                model.addElement(colNames.get(i));
            }
            this.listValueField.setModel(model);
            this.listXField.setModel(model);
            this.listYField.setModel(model);
        }
    }//GEN-LAST:event_buttonCsvFileActionPerformed

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        //read out information & check
        CsvTable table = null;
        String error = null;
        String name = this.textFieldName.getText();
        if(name==null || "".equals(name) || "not selected".equals(name))
        {error = "Please enter a name for the data set, e.g. \"Shipping\".";}

        try
        {
            
                        //to save time, save last opened table and re-use it if it's the same file

            if(GlobalResources.lastOpenedTableFile.equals(this.textFieldCsvFile.getText()))
            {
                table = GlobalResources.lastOpenedTable;
            }
            else
            {
                table = new CsvTable();
                table.readFromFile(new File(this.textFieldCsvFile.getText()));
                GlobalResources.lastOpenedTableFile=this.textFieldCsvFile.getText();
                GlobalResources.lastOpenedTable=table;
                    if(table.getColNames().isEmpty())
            {error = "Could not read column names from CSV file.";}
            }
            
        
        }
        catch(Exception e)
        {
            error = "Could not read data from CSV file.";
            GlobalResources.lastOpenedTable=new CsvTable();
            GlobalResources.lastOpenedTableFile="";
        }

        String xField=""; String yField=""; String valueField="";
        try
        {
            xField = (String) this.listXField.getSelectedValue();
            yField = (String) this.listYField.getSelectedValue();
            valueField = (String) this.listValueField.getSelectedValue();

            if(xField==null || yField==null || valueField==null)
            error = "Please select value, x and y fields.";
        }
        catch(Exception e)
        {
            error = "Please select value, x and y fields.";
        }

        if(error==null)
        {
            //make mapping grid
            try
            {
                double[] x = Helpers.stringListToDoubleArray(table.getColumn(xField));
                if(!Helpers.OK.equals(Helpers.getError()))
                {
                    error = Helpers.getError();
                }
                double[] y = Helpers.stringListToDoubleArray(table.getColumn(yField));
                if(!Helpers.OK.equals(Helpers.getError()))
                {
                    error = Helpers.getError();
                }
              
                double[] values = Helpers.stringListToDoubleArray(table.getColumn(valueField));
                if(!Helpers.OK.equals(Helpers.getError()))
                {
                    error = Helpers.getError();
                }
                
                /*
                 * 
                 * if(error==null)
        {
            //make mapping grid
            try
            {
                double[] x = Helpers.stringListToDoubleArray(table.getColumn(xField));
                if(!Helpers.OK.equals(Helpers.getError()))
                {
                    error = Helpers.getError();
                }
                double[] y = Helpers.stringListToDoubleArray(table.getColumn(yField));
                if(!Helpers.OK.equals(Helpers.getError()))
                {
                    error = Helpers.getError();
                }
                if(!Helpers.OK.equals(Helpers.getError()))
                {
                    error = Helpers.getError();
                }
                 
                String[] ids = Helpers.stringListToStringArray(table.getColumn(idField));
                
                if(error==null)
                {
                    MappingGrid grid = new MappingGrid(x,y,ids);
                    MappingProject.grid=grid;
                    MappingProject.projectFolder=projFolder;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, error);
                }
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Could not create mapping grid. //// " + e.getMessage() + " //// " + e.getStackTrace());
            }
           
            this.dispose();
                 * 
                 */

                if(error==null)
                {
                    
                    if(MappingProject.grid==null)
                    {
                        //make mapping grid
                        MappingGrid grid = new MappingGrid(x,y);
                        MappingProject.grid=grid;
     
                    }
                    
                    DataGrid grid = MappingProject.grid.createDataGrid(x, y, values);
                    DataSourceInfo info = new DataSourceInfo();
                    info.sourceFile=this.textFieldCsvFile.getText();
                    info.valueField=valueField;
                    info.xField=xField;
                    info.yField=yField;
                    MappingProject.addData(name, grid, dataType, info);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, error);
                }

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Could not load data. //// " + e.getMessage() + " //// " + e.getStackTrace());
            }

            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null, error);
        }
    }//GEN-LAST:event_buttonOkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(LoadDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoadDataForm dialog = new LoadDataForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonCsvFile;
    private javax.swing.JButton buttonOk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelName;
    private javax.swing.JList listValueField;
    private javax.swing.JList listXField;
    private javax.swing.JList listYField;
    private javax.swing.JTextField textFieldCsvFile;
    private javax.swing.JTextField textFieldName;
    // End of variables declaration//GEN-END:variables
}
