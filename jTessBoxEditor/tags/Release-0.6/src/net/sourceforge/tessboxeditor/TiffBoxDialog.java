/**
 * Copyright @ 2009 Quan Nguyen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sourceforge.tessboxeditor;

import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import net.sourceforge.vietpad.components.FontDialog;
import net.sourceforge.vietpad.components.SimpleFilter;

public class TiffBoxDialog extends javax.swing.JDialog {

    File selectedFile;
    Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();

    /** Creates new form TiffBoxDialog */
    public TiffBoxDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // DnD support
        new DropTarget(this.jTextArea1, new FileDropTargetListener(TiffBoxDialog.this));

        // Set font
        attributes.put(TextAttribute.TRACKING, this.jSpinnerTracking.getValue());
        Font font = this.jTextArea1.getFont().deriveFont(36f).deriveFont(attributes);
        this.jTextArea1.setFont(font);
        this.jButtonFont.setText(fontDesc(font));
        this.jTextFieldFileName.setText(createFileName(font));

        setLocationRelativeTo(getOwner());

        //  Handle escape key to hide the dialog
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction =
                new AbstractAction() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        FileFilter textFilter = new SimpleFilter("txt", "Text Files");
        jFileChooser1.addChoosableFileFilter(textFilter);
        jFileChooser1.setAcceptAllFileFilterUsed(false);
        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jButtonInput = new javax.swing.JButton();
        jLabelOutput = new javax.swing.JLabel();
        jTextFieldFileName = new javax.swing.JTextField();
        jButtonFont = new javax.swing.JButton();
        jLabelTracking = new javax.swing.JLabel();
        jSpinnerTracking = new javax.swing.JSpinner();
        jLabelW = new javax.swing.JLabel();
        jSpinnerW = new javax.swing.JSpinner();
        jLabelH = new javax.swing.JLabel();
        jSpinnerH = new javax.swing.JSpinner();
        jButtonGenerate = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setTitle("Generate TIFF/Box");
        setMinimumSize(new java.awt.Dimension(800, 600));

        jToolBar1.setRollover(true);

        jButtonInput.setText("Input");
        jButtonInput.setToolTipText("Load Text File");
        jButtonInput.setFocusable(false);
        jButtonInput.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonInput.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInputActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInput);

        jLabelOutput.setText("Output");
        jPanel1.add(jLabelOutput);

        jTextFieldFileName.setPreferredSize(new java.awt.Dimension(150, 24));
        jPanel1.add(jTextFieldFileName);

        jButtonFont.setText("Font");
        jButtonFont.setToolTipText("Select Font");
        jButtonFont.setFocusable(false);
        jButtonFont.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFont.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonFont.setText(fontDesc(UIManager.getFont("TextArea.font")));
        jButtonFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFontActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonFont);

        jLabelTracking.setText("Tracking");
        jLabelTracking.setToolTipText("Letter Tracking");
        jPanel1.add(jLabelTracking);

        jSpinnerTracking.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-0.04f), Float.valueOf(0.1f), Float.valueOf(0.01f)));
        jSpinnerTracking.setPreferredSize(new java.awt.Dimension(64, 22));
        jSpinnerTracking.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerTrackingStateChanged(evt);
            }
        });
        jPanel1.add(jSpinnerTracking);

        jLabelW.setText("W");
        jLabelW.setToolTipText("Image Width");
        jPanel1.add(jLabelW);

        jSpinnerW.setModel(new javax.swing.SpinnerNumberModel(2550, 600, 2550, 1));
        jSpinnerW.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinnerW, "#"));
        jSpinnerW.setPreferredSize(new java.awt.Dimension(63, 22));
        jPanel1.add(jSpinnerW);

        jLabelH.setText("H");
        jLabelH.setToolTipText("Image Height");
        jPanel1.add(jLabelH);

        jSpinnerH.setModel(new javax.swing.SpinnerNumberModel(3300, 400, 3300, 1));
        jSpinnerH.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinnerH, "#"));
        jSpinnerH.setPreferredSize(new java.awt.Dimension(63, 22));
        jPanel1.add(jSpinnerH);

        jButtonGenerate.setText("Generate");
        jButtonGenerate.setToolTipText("Generate TIFF/Box");
        jButtonGenerate.setFocusable(false);
        jButtonGenerate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGenerate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGenerate);

        jButtonClear.setText("Clear");
        jButtonClear.setToolTipText("Clear Textarea");
        jButtonClear.setFocusable(false);
        jButtonClear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonClear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonClear);

        jToolBar1.add(jPanel1);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setMargin(new java.awt.Insets(5, 5, 2, 2));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInputActionPerformed
        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            getGlassPane().setVisible(true);

            try {
                selectedFile = jFileChooser1.getSelectedFile();
                openFile(selectedFile);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                SwingUtilities.invokeLater(
                        new Runnable() {

                            @Override
                            public void run() {
                                getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                getGlassPane().setVisible(false);
                            }
                        });
            }
        }
    }//GEN-LAST:event_jButtonInputActionPerformed

    void openFile(final File selectedFile) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), "UTF8"));
            this.jTextArea1.read(in, null);
            in.close();
        } catch (IOException e) {
        }
    }

    private void jButtonFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFontActionPerformed
        FontDialog dlg = new FontDialog((JFrame) this.getParent());
        Font font = this.jTextArea1.getFont();
        dlg.setAttributes(font);
        dlg.setVisible(true);

        if (dlg.succeeded()) {
            getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            getGlassPane().setVisible(true);

            try {
                font = dlg.getFont().deriveFont(attributes);
                this.jTextArea1.setFont(font);
                this.jTextArea1.validate();
                this.jButtonFont.setText(fontDesc(font));
                this.jTextFieldFileName.setText(createFileName(font));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                SwingUtilities.invokeLater(
                        new Runnable() {

                            @Override
                            public void run() {
                                getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                getGlassPane().setVisible(false);
                            }
                        });
            }
        }
    }//GEN-LAST:event_jButtonFontActionPerformed

    private String fontDesc(Font font) {
        return font.getName() + (font.isBold() ? " Bold" : "") + (font.isItalic() ? " Italic" : "") + " " + font.getSize() + "pt";
    }

    private String createFileName(Font font) {
        return font.getName().replace(" ", "").toLowerCase() + (font.isBold() ? "bold" : "") + (font.isItalic() ? "italic" : "") + ".exp0.tif";
    }

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        this.jTextArea1.setText(null);
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        if (this.jTextArea1.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please load some text.");
            return;
        }

        TiffBoxGenerator generator = new TiffBoxGenerator(this.jTextArea1.getText(), this.jTextArea1.getFont(), (Integer) this.jSpinnerW.getValue(), (Integer) this.jSpinnerH.getValue());
        File outputFolder;

        if (selectedFile != null) {
            outputFolder = selectedFile.getParentFile();
        } else {
            outputFolder = new File(System.getProperty("user.home"));
        }
        generator.setOutputFolder(outputFolder);
        generator.setFileName(this.jTextFieldFileName.getText());
        generator.setTracking((Float) this.jSpinnerTracking.getValue());
        try {
            generator.create();
            JOptionPane.showMessageDialog(this, String.format("Tiff/Box files have been generated and saved in %s folder.", outputFolder.getPath()));
        } catch (OutOfMemoryError oome) {
            JOptionPane.showMessageDialog(this, "The input text was probably too large. Please reduce it to a more manageable amount.", "Out-Of-Memory Exception", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonGenerateActionPerformed

    private void jSpinnerTrackingStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerTrackingStateChanged
        attributes.put(TextAttribute.TRACKING, this.jSpinnerTracking.getValue());
        this.jTextArea1.setFont(this.jTextArea1.getFont().deriveFont(attributes));
    }//GEN-LAST:event_jSpinnerTrackingStateChanged

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
            java.util.logging.Logger.getLogger(TiffBoxDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TiffBoxDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TiffBoxDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TiffBoxDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                TiffBoxDialog dialog = new TiffBoxDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonFont;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonInput;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabelH;
    private javax.swing.JLabel jLabelOutput;
    private javax.swing.JLabel jLabelTracking;
    private javax.swing.JLabel jLabelW;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerH;
    private javax.swing.JSpinner jSpinnerTracking;
    private javax.swing.JSpinner jSpinnerW;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldFileName;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
