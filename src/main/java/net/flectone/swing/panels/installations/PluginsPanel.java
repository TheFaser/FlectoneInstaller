/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package net.flectone.swing.panels.installations;

import net.flectone.swing.panels.test.CustomPanel;
import net.flectone.system.Configuration;
import net.flectone.system.Installation;
import net.flectone.system.SystemInfo;
import net.flectone.utils.Dialog;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author TheFaser
 */
public class PluginsPanel extends JPanel {


    public CustomPanel panel;
    /**
     * Creates new form PluginsPanel
     */
    public PluginsPanel() {
        panel = new CustomPanel("plugins", ".jar");
        initComponents();

        jComboBox4.setModel(new DefaultComboBoxModel<>(Configuration.getValues("support.server_cores.versions")));

        panel.setUrlToComponents("components/servers/plugins");

        panel.addComponentsToInstallPanel(this);

        panel.updateComponents((builder, component) -> {
            builder.addIcon("components/" + component + ".png")
                    .addCheckBox(Configuration.getValue("checkbox.install") + Configuration.getValue("plugin." + component), component)
                    .addText("label." + component)
                    .addLine();
        });

        installButton2.addActionListener(e -> new Thread(() -> {

            installButton2.setEnabled(false);

            Installation installation = new Installation("plugins",
                    ".jar",
                    panel.getUrlToComponents() + "/",
                    "server" + File.separator + "plugins" + File.separator,
                    panel.getProgressPanel());

            installation.downloadFiles();

            if(installCoreCheckBox3.isSelected()){
                String fileName = "bestcore-" + jComboBox4.getSelectedItem() + ".jar";
                installation.downloadFile("https://flectone.net/components/servers/" + fileName,
                        SystemInfo.getMinecraftPath() + "server" + File.separator + fileName,
                        fileName);
            }

            installation.close();

            installButton2.setEnabled(true);
        }).start());

        installPropertiesCheckBox3.setEnabled(false);

        jButton6.addActionListener(e -> Dialog.showSelectMinecraftFolder());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        installPanel = new javax.swing.JPanel();
        installPropertiesCheckBox3 = new javax.swing.JCheckBox();
        jComboBox4 = new javax.swing.JComboBox<>();
        installCoreCheckBox3 = new javax.swing.JCheckBox();
        versionLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        installButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setOpaque(false);

        installPanel.setOpaque(false);

        installPropertiesCheckBox3.setText(Configuration.getValue("checkbox.properties"));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        installCoreCheckBox3.setText(Configuration.getValue("checkbox.best_core"));

        versionLabel3.setText(Configuration.getValue("label.server_version"));

        installButton2.setText(Configuration.getValue("label.install"));

        jButton6.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(installButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(installButton2)
                    .addComponent(jButton6))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout installPanelLayout = new javax.swing.GroupLayout(installPanel);
        installPanel.setLayout(installPanelLayout);
        installPanelLayout.setHorizontalGroup(
            installPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(installPanelLayout.createSequentialGroup()
                .addGroup(installPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(installPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(versionLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(installCoreCheckBox3))
                    .addGroup(installPanelLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(installPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(installPropertiesCheckBox3)
                            .addGroup(installPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, 0))
        );
        installPanelLayout.setVerticalGroup(
            installPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, installPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(installPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(installPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(versionLabel3))
                    .addGroup(installPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(installCoreCheckBox3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(installPropertiesCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(installPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(installPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton installButton2;
    private javax.swing.JCheckBox installCoreCheckBox3;
    private javax.swing.JPanel installPanel;
    private javax.swing.JCheckBox installPropertiesCheckBox3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel versionLabel3;
    // End of variables declaration//GEN-END:variables
}
