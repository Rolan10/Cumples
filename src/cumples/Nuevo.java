/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cumples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Roland
 */
public class Nuevo extends javax.swing.JPanel {

    /**
     * Creates new form Nuevo
     *
     */
    File archivo = new File("./cumples.txt");
    JOptionPane alerta = new JOptionPane();

    public Nuevo() {
        initComponents();

        try {
            if (!archivo.exists()) {
              archivo.createNewFile();
            }
        } catch (IOException ex) {
            alerta.showMessageDialog(null,"Error creando fichero "+ex);
            //System.out.println("Excepcion creando fichero" + ex);
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

        jLabel1 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        Selector = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(500, 250));
        setName("Añadir Nuevo Cumple"); // NOI18N

        jLabel1.setText("Nombre:");

        jLabel2.setText("Cumpleaños:");

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel3.setText("Guardar Nueva Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Guardar)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(Selector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Selector, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(Guardar)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Esta función se encarga de almacenar informacion en un fichero
     * ("cumples.txt") la información proporcionada a traves del campo de texto
     * "Nombre" y el JDateChooser "Selector".
     *
     */
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        int mes = -1;
        int dia = -1;
        String nombre = "";
        try {
            mes = Selector.getDate().getMonth() + 1;
            dia = Selector.getDate().getDate();
            nombre = Nombre.getText();
        } catch (Exception ex) {
            alerta.showMessageDialog(null,"Error al leer los datos:" + ex);
            //System.out.println("Excepcion en boton Guardar" + ex);
        }

        String s = "";
        s = nombre + "|" + dia + "/" + mes;

        try {
            FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(s);
            fw.close();
            pw.close();
        } catch (IOException ex) {
            alerta.showMessageDialog(null,"Error al escribir en el fichero:" + ex);
            //System.out.println("Error al escribir en el fichero:" + ex);
            //Logger.getLogger(Nuevo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_GuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JTextField Nombre;
    private com.toedter.calendar.JDateChooser Selector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
