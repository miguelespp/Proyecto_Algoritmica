/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaz;

import Prueba.Prueba2;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author PC
 */
public class ProfesorGrupos extends javax.swing.JPanel {

    public ProfesorGrupos() {
        initComponents();
        actualizarTablaDatos();
        configurarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGrupos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(252, 235, 238));

        jPanel2.setBackground(new java.awt.Color(234, 135, 135));

        tablaGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de grupo", "Nombre de grupo", "# de alumnos", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGruposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGrupos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Mis grupos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void actualizarTablaDatos() {
        File carpetaGrupos = new File("grupos");

        if (carpetaGrupos.exists() && carpetaGrupos.isDirectory()) {
            DefaultTableModel model = (DefaultTableModel) tablaGrupos.getModel();
            model.setRowCount(0);

            File[] archivosGrupos = carpetaGrupos.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

            if (archivosGrupos != null) {
                for (File archivo : archivosGrupos) {
                    try {
                        List<String> lineas = Files.readAllLines(archivo.toPath());

                        if (lineas.size() >= 2) {  // Asegurarse de que hay al menos dos líneas
                            String codigoGrupo = lineas.get(0).replace("Código de grupo: ", "");
                            String nombreGrupo = lineas.get(1).replace("Nombre de grupo: ", "");
                            String numeroAlumnos = "# de alumnos";  // No lees el número de alumnos del archivo

                            Object[] rowData = {codigoGrupo, nombreGrupo, numeroAlumnos, "Ver"};
                            model.addRow(rowData);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    private void configurarTabla() {
        tablaGrupos.setDefaultEditor(Object.class, null); // Hace que todas las celdas no sean editables

        // Desactiva la reorganización de columnas
        tablaGrupos.getTableHeader().setReorderingAllowed(false);
    }
    private void tablaGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGruposMouseClicked
        int columnaBotonVer = 3; // La columna del botón "Ver" en tu modelo de tabla

        if (tablaGrupos.columnAtPoint(evt.getPoint()) == columnaBotonVer) {
            int fila = tablaGrupos.rowAtPoint(evt.getPoint());
            if (fila != -1) {
                String codigoGrupo = (String) tablaGrupos.getValueAt(fila, 0);
                String nombreGrupo = (String) tablaGrupos.getValueAt(fila, 1);
                String numeroAlumnos = (String) tablaGrupos.getValueAt(fila, 2);

                // Obtener el contenedor principal
                Container contenedorPrincipal = SwingUtilities.getWindowAncestor(this);

                if (contenedorPrincipal instanceof JFrame) {

                    // Traverse the hierarchy to find the instance of Principal_Estudiante
                    Container parent = getParent();
                    while (parent != null && !(parent instanceof Principal_Profesor)) {
                        parent = parent.getParent();
                    }

                    if (parent instanceof Principal_Profesor) {
                            Principal_Profesor principalProfesor = (Principal_Profesor) parent;
                            principalProfesor.cambiarPanelEstadisticas();
                        } /*else {
                            System.out.println("Principal_Estudiante not found in the hierarchy");
                        } */


                }
            }
        }

    }//GEN-LAST:event_tablaGruposMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaGrupos;
    // End of variables declaration//GEN-END:variables
}
