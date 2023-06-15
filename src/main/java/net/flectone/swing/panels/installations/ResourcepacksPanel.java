/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package net.flectone.swing.panels.installations;

import net.flectone.swing.panels.test.CustomPanel;
import net.flectone.system.Configuration;
import net.flectone.system.Installation;
import net.flectone.utils.Dialog;

import java.io.File;

/**
 *
 * @author TheFaser
 */
public class ResourcepacksPanel extends javax.swing.JPanel {

    /**
     * Creates new form ResourcepacksPanel
     */
    public CustomPanel panel = null;

    public ResourcepacksPanel() {

        panel = new CustomPanel("resourcepacks", ".zip");
        initComponents();

        panel.setUrlToComponents("components/resourcepacks");

        panel.addComponentsToInstallPanel(this);

        new Thread(() -> {
            panel.updateComponents((builder, component) -> {
                builder.addIcon(component + ".png")
                        .addCheckBox(Configuration.getValue("checkbox.install") + Configuration.getValue("resourcepack." + component), component)
                        .addText("label." + component)
                        .addLine();
            });
        }).start();

        installButton.addActionListener(e -> new Thread(() -> {

            installButton.setEnabled(false);

            Installation installation = new Installation("resourcepacks",
                    ".zip",
                    panel.getUrlToComponents() + "/",
                    "resourcepacks" + File.separator,
                    panel.getProgressPanel());

            installation.downloadFiles();
            installation.close();

            installButton.setEnabled(true);

        }).start());

        jButton2.addActionListener(e -> Dialog.showSelectMinecraftFolder());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        installButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setOpaque(false);

        jPanel2.setOpaque(false);

        installButton.setText(Configuration.getValue("label.install"));

        jButton2.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(installButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(installButton)
                    .addComponent(jButton2))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton installButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
