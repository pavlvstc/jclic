/*
 * File    : RevisionEditPanel.java
 * Created : 27-feb-2004 17:13
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

package edu.xtec.jclic.project;

import edu.xtec.jclic.beans.TextListEditor;
import edu.xtec.util.Options;
import edu.xtec.util.StrUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComponent;

/**
 *
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.10.29
 */
public class RevisionEditPanel extends javax.swing.JPanel {
    
    Options options;
    
    /** Creates new form AuthorEditPanel */
    public RevisionEditPanel(Options options) {
        this.options=options;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        javax.swing.JLabel authorLb;
        javax.swing.JLabel commentsLb;
        javax.swing.JScrollPane commentsScroll;
        javax.swing.JLabel dateLb;
        javax.swing.JLabel descLb;
        java.awt.GridBagConstraints gridBagConstraints;

        dateLb = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        descLb = new javax.swing.JLabel();
        descText = new javax.swing.JTextField();
        authorLb = new javax.swing.JLabel();
        authorListEditor = new TextListEditor(options){
            protected Object editItem(Object currentValue, boolean newValue){
                return editAuthor(currentValue, newValue);
            }
        };
        commentsLb = new javax.swing.JLabel();
        commentsScroll = new javax.swing.JScrollPane();
        commentsText = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        dateLb.setLabelFor(dateText);
        dateLb.setText(options.getMsg("edit_project_rev_date"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(dateLb, gridBagConstraints);

        dateText.setToolTipText(options.getMsg("edit_project_rev_date_tooltip"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(dateText, gridBagConstraints);

        descLb.setLabelFor(descText);
        descLb.setText(options.getMsg("edit_project_rev_description"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(descLb, gridBagConstraints);

        descText.setToolTipText(options.getMsg("edit_project_rev_description_tooltip"));
        descText.setPreferredSize(new java.awt.Dimension(300, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(descText, gridBagConstraints);

        authorLb.setLabelFor(authorListEditor);
        authorLb.setText(options.getMsg("edit_project_rev_authors"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(authorLb, gridBagConstraints);

        authorListEditor.setToolTipText(options.getMsg("edit_project_rev_authors_tooltip"));
        authorListEditor.setPreferredSize(new java.awt.Dimension(400, 80));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(authorListEditor, gridBagConstraints);

        commentsLb.setLabelFor(commentsText);
        commentsLb.setText(options.getMsg("edit_project_rev_comments"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(commentsLb, gridBagConstraints);

        commentsScroll.setPreferredSize(new java.awt.Dimension(300, 60));
        commentsText.setLineWrap(true);
        commentsText.setToolTipText(options.getMsg("edit_project_rev_comments_tooltip"));
        commentsText.setWrapStyleWord(true);
        commentsScroll.setViewportView(commentsText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(commentsScroll, gridBagConstraints);

    }//GEN-END:initComponents

    
    public void setRevision(Revision rev){
        dateText.setText(options.getMessages().getShortDateStr(rev==null ? new Date() : rev.date));
        descText.setText(rev!=null ? rev.description : "");
        commentsText.setText(rev!=null ? rev.comments : "");        
        List<Object> v=new ArrayList<Object>();
        if(rev!=null && rev.authors!=null){
            //v.add(Arrays.asList(rev.authors));
            for(Author a : rev.authors)
                v.add(a);
        }
        authorListEditor.setListData(v);        
    }
    
    public Revision getRevision(){
        Revision rev=null;        
        Date date=options.getMessages().parseShortDate(dateText.getText());
        String desc=StrUtils.nullableString(descText.getText().trim());
        if(date==null){
            options.getMessages().showAlert(this, "DATE_INCORRECT");
        } else if(desc==null){
            options.getMessages().showAlert(this, "edit_project_rev_err_nodesc");
        } else{
            rev=new Revision();        
            rev.date=date;
            rev.description=desc;
            rev.comments=StrUtils.nullableString(commentsText.getText().trim());
            List<Object> v=authorListEditor.getListData();
            rev.authors=(Author[])v.toArray(new Author[v.size()]);        
        }
        return rev;
    }
    
    private AuthorEditPanel authorEditPanel;
    private Object editAuthor(Object currentValue, boolean newValue){
        Author result=null;
        if(authorEditPanel==null)
            authorEditPanel=new AuthorEditPanel(options);
        if(newValue)
            currentValue=null;        
        authorEditPanel.setAuthor((Author)currentValue);
        if(options.getMessages().showInputDlg(
        this, new String[] {"edit_project_author_info"}
        , null, new JComponent[]{authorEditPanel}
        , (newValue ? "edit_project_author_add" : "edit_project_author_edit"))){
            result=authorEditPanel.getAuthor();
            if(result.name.length()<1)
                result=null;
        }
        return result;        
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private edu.xtec.jclic.beans.TextListEditor authorListEditor;
    private javax.swing.JTextArea commentsText;
    private javax.swing.JTextField dateText;
    private javax.swing.JTextField descText;
    // End of variables declaration//GEN-END:variables
    
}
