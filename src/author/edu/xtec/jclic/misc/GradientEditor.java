/*
 * File    : GradientEditor.java
 * Created : 25-sep-2002 19:18
 * By      : fbusquets
 *
 * JClic - Authoring and playing system for educational activities
 *
 * Copyright (C) 2000 - 2005 Francesc Busquets & Departament
 * d'Educacio de la Generalitat de Catalunya
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details (see the LICENSE file).
 */

package edu.xtec.jclic.misc;

import edu.xtec.jclic.beans.ColorButton;
import edu.xtec.util.Messages;
import edu.xtec.util.Options;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author  Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.09.17
 */
public class GradientEditor extends javax.swing.JPanel {
    
    Options options;
    Gradient gradient;    
    
    /** Creates new form GradientEditor */
    public GradientEditor(Options options, Gradient gradient) {
        this.options=options;
        initComponents();  
        setGradient(gradient);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        javax.swing.JLabel endColorLb;
        javax.swing.JLabel orientationLb;
        java.awt.GridBagConstraints gridBagConstraints;
        javax.swing.JLabel cyclesLb;
        javax.swing.JLabel startColorLb;

        previewPanel = new GradientPreview();
        startColorLb = new javax.swing.JLabel();
        startColorBtn = new edu.xtec.jclic.beans.ColorButton();
        startColorBtn.setOptions(options);
        endColorLb = new javax.swing.JLabel();
        endColorBtn = new edu.xtec.jclic.beans.ColorButton();
        endColorBtn.setOptions(options);
        cyclesLb = new javax.swing.JLabel();
        cyclesTxt = new javax.swing.JTextField();
        cyclesSlider = new javax.swing.JSlider();
        orientationLb = new javax.swing.JLabel();
        orientationTxt = new javax.swing.JTextField();
        orientationSlider = new javax.swing.JSlider();

        setLayout(new java.awt.GridBagLayout());

        previewPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        previewPanel.setPreferredSize(new java.awt.Dimension(100, 100));
        previewPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(previewPanel, gridBagConstraints);

        startColorLb.setText(options.getMsg("edit_gradient_startColor"));
        startColorLb.setLabelFor(startColorBtn);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(startColorLb, gridBagConstraints);

        startColorBtn.setToolTipText(options.getMsg("edit_gradient_startColor_tooltip"));
        startColorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startColorBtnActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(startColorBtn, gridBagConstraints);

        endColorLb.setText(options.getMsg("edit_gradient_endColor"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(endColorLb, gridBagConstraints);

        endColorBtn.setToolTipText(options.getMsg("edit_gradient_endColor_tooltip"));
        endColorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endColorBtnActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(endColorBtn, gridBagConstraints);

        cyclesLb.setText(options.getMsg("edit_gradient_cycles"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(cyclesLb, gridBagConstraints);

        cyclesTxt.setToolTipText(options.getMsg("edit_gradient_cycles_tooltip"));
        cyclesTxt.setPreferredSize(new java.awt.Dimension(40, 21));
        cyclesTxt.setMinimumSize(new java.awt.Dimension(40, 21));
        cyclesTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cyclesTxtActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(cyclesTxt, gridBagConstraints);

        cyclesSlider.setMinorTickSpacing(10);
        cyclesSlider.setPaintTicks(true);
        cyclesSlider.setMinimum(1);
        cyclesSlider.setMajorTickSpacing(10);
        cyclesSlider.setToolTipText(options.getMsg("edit_gradient_cycles_tooltip"));
        cyclesSlider.setMaximum(50);
        cyclesSlider.setPreferredSize(new java.awt.Dimension(100, 27));
        cyclesSlider.setMinimumSize(new java.awt.Dimension(100, 27));
        cyclesSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cyclesSliderStateChanged(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(cyclesSlider, gridBagConstraints);

        orientationLb.setText(options.getMsg("edit_gradient_orientation"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(orientationLb, gridBagConstraints);

        orientationTxt.setToolTipText(options.getMsg("edit_gradient_orientation_tooltip"));
        orientationTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orientationTxtActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(orientationTxt, gridBagConstraints);

        orientationSlider.setMinorTickSpacing(30);
        orientationSlider.setPaintTicks(true);
        orientationSlider.setMajorTickSpacing(90);
        orientationSlider.setToolTipText(options.getMsg("edit_gradient_orientation_tooltip"));
        orientationSlider.setMaximum(360);
        orientationSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                orientationSliderStateChanged(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(orientationSlider, gridBagConstraints);

    }//GEN-END:initComponents

    private void endColorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endColorBtnActionPerformed

        gradient.setColors(((ColorButton)startColorBtn).getColor(), ((ColorButton)endColorBtn).getColor());
        previewPanel.repaint();

    }//GEN-LAST:event_endColorBtnActionPerformed

    private void startColorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startColorBtnActionPerformed
        
        gradient.setColors(((ColorButton)startColorBtn).getColor(), ((ColorButton)endColorBtn).getColor());
        previewPanel.repaint();
        
    }//GEN-LAST:event_startColorBtnActionPerformed

    private void orientationSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_orientationSliderStateChanged

        int v=orientationSlider.getValue();
        orientationTxt.setText(Integer.toString(v));
        orientationSlider.setValue(v);
        gradient.setAngle(v);
        previewPanel.repaint();        
        
    }//GEN-LAST:event_orientationSliderStateChanged

    private void cyclesSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cyclesSliderStateChanged

        int v=cyclesSlider.getValue();
        cyclesTxt.setText(Integer.toString(v));
        cyclesSlider.setValue(v);
        gradient.setCycles(v);
        previewPanel.repaint();        
        
    }//GEN-LAST:event_cyclesSliderStateChanged

    private void orientationTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orientationTxtActionPerformed

        int v=gradient.angle;
        try{
            v=Math.max(0, Integer.parseInt(orientationTxt.getText()))%360;
        } catch(Exception ex){
           options.getMessages().showErrorWarning(this, "ERROR", ex);
        }        
        orientationTxt.setText(Integer.toString(v));
        orientationSlider.setValue(v);
        gradient.setAngle(v);
        previewPanel.repaint();
        
    }//GEN-LAST:event_orientationTxtActionPerformed

    private void cyclesTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cyclesTxtActionPerformed

        int v=gradient.cycles;
        try{
            v=Math.max(1, Integer.parseInt(cyclesTxt.getText()));
        } catch(Exception ex){
           options.getMessages().showErrorWarning(this, "ERROR", ex);           
        }
        cyclesTxt.setText(Integer.toString(v));
        cyclesSlider.setValue(v);
        gradient.setCycles(v);
        previewPanel.repaint();
        
    }//GEN-LAST:event_cyclesTxtActionPerformed
    
    public void setGradient(Gradient g){
        if(g==null)
            g=new Gradient();
        gradient=new Gradient(g.getColors()[0], g.getColors()[1], g.getAngle(), g.getCycles());
        ((ColorButton)startColorBtn).setColor(gradient.c1);        
        ((ColorButton)endColorBtn).setColor(gradient.c2);
        cyclesSlider.setValue(gradient.cycles);
        cyclesTxt.setText(Integer.toString(gradient.cycles));
        orientationSlider.setValue(gradient.angle);
        orientationTxt.setText(Integer.toString(gradient.angle));
    }
    
    class GradientPreview extends javax.swing.JPanel{
        GradientPreview(){
            super();
            //setOpaque(false);
        }
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2=(Graphics2D)g;
            RenderingHints rh=g2.getRenderingHints();
            g2.setRenderingHints(edu.xtec.jclic.Constants.DEFAULT_RENDERING_HINTS);
            gradient.paint(g2, new Rectangle(0, 0, getWidth(), getHeight()));
            g2.setRenderingHints(rh);
        }
        
    }
    
    private static Map<Options, GradientEditor> panels=new HashMap<Options, GradientEditor>();
    public static Gradient getGradient(Gradient initialGradient, Component parent, Options options){
        Messages msg=options.getMessages();
        GradientEditor ge=panels.get(options);
        if(ge==null){
            ge=new GradientEditor(options, initialGradient);
            panels.put(options, ge);
        } else{
            ge.setGradient(initialGradient);
        }
        boolean b=msg.showInputDlg(parent, ge, "edit_gradient_title");
        return b ? ge.gradient : null;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private edu.xtec.jclic.beans.ColorButton startColorBtn;
    private javax.swing.JTextField cyclesTxt;
    private edu.xtec.jclic.beans.ColorButton endColorBtn;
    private javax.swing.JSlider cyclesSlider;
    private javax.swing.JPanel previewPanel;
    private javax.swing.JSlider orientationSlider;
    private javax.swing.JTextField orientationTxt;
    // End of variables declaration//GEN-END:variables
    
}