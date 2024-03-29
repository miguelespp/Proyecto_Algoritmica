/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaz;
import Proyecto.Grupo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
/**
 *
 * @author PC
 */
public class crear_Grupo extends javax.swing.JPanel {

    /**
     * Creates new form crear_Grupo
     */
    public crear_Grupo() {
        initComponents();
    }
    private void escribirDatosEnArchivo(Grupo grupo) {
        // Crear el nombre del archivo basado en el código del grupo
        String nombreArchivo = grupo.getCodigoGrupo() + ".txt";

        // Crear una carpeta para almacenar los archivos si no existe
        String carpetaPath = "Grupos";
        File carpeta = new File(carpetaPath);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        // Crear la ruta completa del archivo dentro de la carpeta
        String rutaCompleta = carpetaPath + File.separator + nombreArchivo;

        try (FileWriter writer = new FileWriter(rutaCompleta)) {
            // Escribir los datos en el archivo
            writer.write("Código de grupo: " + grupo.getCodigoGrupo() + "\n");
            writer.write("Nombre de grupo: " + grupo.getNombreGrupo() + "\n");

            // Puedes agregar más información si lo necesitas

            System.out.println("Datos guardados en el archivo " + rutaCompleta);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al escribir en el archivo");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigotexto = new javax.swing.JTextField();
        grupotexto = new javax.swing.JTextField();
        botoncrear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(253, 207, 216));

        jPanel2.setBackground(new java.awt.Color(234, 135, 135));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Codigo de grupo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nombre de grupo");

        codigotexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigotextoActionPerformed(evt);
            }
        });

        grupotexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupotextoActionPerformed(evt);
            }
        });

        botoncrear.setText("Crear");
        botoncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codigotexto)
                    .addComponent(grupotexto, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                .addContainerGap(128, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botoncrear)
                .addGap(55, 55, 55))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codigotexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(grupotexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(botoncrear)
                .addGap(32, 32, 32))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Nuevo grupo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botoncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncrearActionPerformed
        // Obtener los datos del formulario
        String codigoGrupo = codigotexto.getText();
        String nombreGrupo = grupotexto.getText();

        // Crear el objeto Grupo
        Grupo grupo = new Grupo(codigoGrupo, nombreGrupo);

        // Lógica para escribir los datos en un archivo .txt
        escribirDatosEnArchivo(grupo);

        // Limpiar los campos del formulario
        codigotexto.setText("");
        grupotexto.setText("");
    }//GEN-LAST:event_botoncrearActionPerformed

    private void codigotextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigotextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigotextoActionPerformed

    private void grupotextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupotextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grupotextoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoncrear;
    private javax.swing.JTextField codigotexto;
    private javax.swing.JTextField grupotexto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
