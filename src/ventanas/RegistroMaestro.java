package ventanas;

import Conection.Base;
import graficas.Graficar;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import pojo.Alumno;
import pojo.Grupo;
import pojo.Maestro;

public class RegistroMaestro extends javax.swing.JFrame {

    private Base b = new Base();
    private Alumno alum;

    DefaultComboBoxModel<Grupo> modelGrupos;

    public RegistroMaestro() {
        modelGrupos = new DefaultComboBoxModel();
        initComponents();
        this.setLocationRelativeTo(null);
        //addGrupos();
    }

    public void addGrupos() {
        ArrayList<Grupo> listarGrupos;
        listarGrupos = b.obtenerGrupos();
        modelGrupos.removeAllElements();
        for (Grupo g : listarGrupos) {
            modelGrupos.addElement(g);
        }
    }

    public void vaciarCampos() {
        nombre.setText(null);
        apellidoP.setText(null);
        apellidoM.setText(null);
        contra.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellidoP = new javax.swing.JTextField();
        apellidoM = new javax.swing.JTextField();
        edad = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        contra = new javax.swing.JPasswordField();
        contra2 = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        grupo = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(81, 191, 181));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 72, 67));

        jLabel1.setBackground(new java.awt.Color(0, 72, 67));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DEL MAESTRO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(81, 191, 181));

        jPanel2.setBackground(new java.awt.Color(17, 98, 91));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("APELLIDO P.");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("APELLIDO M.");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 145, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("EDAD ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 31, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SEXO");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 22, 180, 37));

        apellidoP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        apellidoP.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(apellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 77, 180, 38));

        apellidoM.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        apellidoM.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(apellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 135, 180, 38));

        edad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        edad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));
        jPanel2.add(edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 41));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("AÑOS");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, 37));

        sexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO" }));
        jPanel2.add(sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, 38));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CONTRASEÑA");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 201, -1, -1));

        contra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        contra.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 191, 180, 38));

        contra2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(contra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 249, 180, 36));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CONFIRMA CONTRA");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 258, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GRUPO");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, 20));

        grupo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        grupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));
        grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupoActionPerformed(evt);
            }
        });
        jPanel2.add(grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        jButton3.setBackground(new java.awt.Color(204, 102, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("INICIO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 80, 40));

        jButton4.setBackground(new java.awt.Color(51, 153, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("REGISTRAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 110, 40));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 41, 700, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grupoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        LogMaestro lM = new LogMaestro();
        lM.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String name = nombre.getText();
        String ap = apellidoP.getText();
        String am = apellidoM.getText();
        String contraseña = contra.getText();
        String contraseña2 = contra2.getText();
        String age = edad.getSelectedItem().toString();
        String sex = sexo.getSelectedItem().toString();
        String group = grupo.getSelectedItem().toString();
        
        if (contraseña.equals(contraseña2)) {
            Maestro maestro = new Maestro(1, name, ap, am, age, sex, contraseña);
            b.insertarMaestro(maestro, group);
            JOptionPane.showMessageDialog(this, "Usuario guardado","3et",JOptionPane.OK_OPTION);
            
            this.setVisible(false);
            LogMaestro gr = new LogMaestro();
            gr.setLocationRelativeTo(null);
            gr.setVisible(true);
            
        }else{
            contra.setText("");
            contra2.setText("");
            JOptionPane.showMessageDialog(this, "Contraseñas no coinciden","3et",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
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
            java.util.logging.Logger.getLogger(RegistroMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroMaestro().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoM;
    private javax.swing.JTextField apellidoP;
    private javax.swing.JPasswordField contra;
    private javax.swing.JPasswordField contra2;
    private javax.swing.JComboBox<String> edad;
    private javax.swing.JComboBox<String> grupo;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> sexo;
    // End of variables declaration//GEN-END:variables
}
