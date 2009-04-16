/*
 * @(#)ODGPropertiesPanel.java  1.0 2007-06-24
 *
 * Copyright (c) 2007 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */

package org.jhotdraw.samples.odg;

import org.jhotdraw.text.ScalableNumberFormatter;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jhotdraw.draw.*;
import org.jhotdraw.gui.*;
import org.jhotdraw.util.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * The ODGPropertiesPanel allows to edit properties (attributes and other things)
 * of a ODGFigure.
 * 
 * @author Werner Randelshofer
 * @version 1.0 2007-06-24 Created.
 */
public class ODGPropertiesPanel extends javax.swing.JPanel {
    private ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.odg.Labels");
    private DrawingEditor editor;
    private JAttributeSlider opacitySlider;
    private FigureAttributeEditorHandler opacityFieldHandler;
    private FigureAttributeEditorHandler opacitySliderHandler;
    private FigureAttributeEditorHandler linkFieldHandler;
    
    /** Creates new instance. */
    public ODGPropertiesPanel() {
        initComponents();
        
        opacitySlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 100);
        opacityPopupButton.add(opacitySlider);
        opacityPopupButton.putClientProperty("JButton.buttonType","toolbar");
        add(opacityPopupButton);

        NumberFormatter nf = new NumberFormatter();
        nf.setMaximum(1d);
        nf.setMinimum(0d);
        opacityField.setFormatterFactory(ScalableNumberFormatter.createFormatterFactory(0d, 100d, 100d));
        opacityFieldHandler = new FigureAttributeEditorHandler(OPACITY, opacityField, editor);
        opacitySliderHandler = new FigureAttributeEditorHandler(OPACITY, opacitySlider, editor);
        linkFieldHandler = new FigureAttributeEditorHandler(LINK, linkField, editor);
        
        // set fonts
        Font font = getFont().deriveFont(11f);
        for (Component c : getComponents()) {
            c.setFont(font);
        }
        opacitySlider.setFont(font);
    }
    
    public void setEditor(DrawingEditor editor) {
        this.editor = editor;
        linkFieldHandler.setDrawingEditor(editor);
        opacitySliderHandler.setDrawingEditor(editor);
        opacityFieldHandler.setDrawingEditor(editor);
    }
    
    public void setView(DrawingView view) {
        opacityFieldHandler.setView(view);
        opacitySliderHandler.setView(view);
        linkFieldHandler.setView(view);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        linkLabel = new javax.swing.JLabel();
        linkField = new org.jhotdraw.gui.JAttributeTextField();
        opacityLabel = new javax.swing.JLabel();
        opacityField = new org.jhotdraw.gui.JAttributeTextField();
        opacityPopupButton = new org.jhotdraw.gui.JPopupButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.GridBagLayout());

        linkLabel.setLabelFor(linkField);
        linkLabel.setText(labels.getString("link")); // NOI18N
        add(linkLabel, new java.awt.GridBagConstraints());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(linkField, gridBagConstraints);

        opacityLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jhotdraw/draw/action/images/attributeOpacity.png"))); // NOI18N
        opacityLabel.setToolTipText(labels.getString("opacity")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(opacityLabel, gridBagConstraints);

        opacityField.setColumns(3);
        add(opacityField, new java.awt.GridBagConstraints());

        opacityPopupButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jhotdraw/draw/action/images/popupIcon.png"))); // NOI18N
        add(opacityPopupButton, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jhotdraw.gui.JAttributeTextField linkField;
    private javax.swing.JLabel linkLabel;
    private org.jhotdraw.gui.JAttributeTextField opacityField;
    private javax.swing.JLabel opacityLabel;
    private org.jhotdraw.gui.JPopupButton opacityPopupButton;
    // End of variables declaration//GEN-END:variables
    
}
