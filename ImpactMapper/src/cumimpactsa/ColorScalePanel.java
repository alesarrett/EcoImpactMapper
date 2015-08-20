/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cumimpactsa;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author ast
 */
public class ColorScalePanel extends javax.swing.JPanel {

    /**
     * Creates new form ColorScalePanel
     */
    public ColorScalePanel() {
        initComponents();
    }
    
    @Override public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    ImageCreator creator = new ImageCreator(this.getWidth(),this.getHeight());
    BufferedImage image = creator.createVerticalColorScaleImage();
    this.getGraphics().drawImage(image, 0, 0, this);
  }

    public void  setup()
    {
        ImageCreator creator = new ImageCreator(this.getWidth(),this.getHeight());
        BufferedImage image = creator.createVerticalColorScaleImage();
        this.getGraphics().drawImage(image, 0, 0, this);
    }   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 80, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 180, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
