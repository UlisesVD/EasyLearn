package ventanas;

import Conection.Base;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pojo.Alumno;
import pojo.Pregunta;
import pojo.Respuesta;

public class Cuestionario extends javax.swing.JFrame {

    ArrayList<Integer> alea = new ArrayList();
    ArrayList<Pregunta> preguntas = new ArrayList();
    ArrayList<Respuesta> respuestas = new ArrayList();

    private int contesta = 1;
    private int cantidadPreguntas;
    private int clave=0;
    private Alumno alum=null;
    Pregunta question;

    Base base = new Base();

    /**
     * Creates new form Cuest
     */
    public Cuestionario(ArrayList<Pregunta> preguntas,String tema,Alumno alum) {
        this.preguntas = preguntas;
        this.alum=alum;
        this.clave=alum.getClave();
        initComponents();
        this.cantidadPreguntas = this.preguntas.size();
        btnFinalizar.setVisible(false);
        tituloLabel.setText(tema.toUpperCase());
        getQuestion();
        
        textArea.setText(textArea.getText());
        
    }
    
    Cuestionario(ArrayList<Pregunta> preguntas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getQuestion() {
        boolean band = true;
        while (band && (alea.size() < cantidadPreguntas - 1)) {
            //General pregunta aleatoria
            int pre = (int) (Math.random() * cantidadPreguntas - 1) + 1;
            while (!alea.contains(pre)) {
                //Agregas la pregunta para no repetirla
                alea.add(pre);
                //fijar pregunta en pantalla
                question = preguntas.get(pre);
                String cortar = question.getPregunta();
                String salida="";
                for (int i = 0; i < cortar.length(); i++) {
                    salida+=cortar.charAt(i);
                    if (i==75) {
                        salida+="-\n";
                    }
                }
                
                textArea.setText("Preunta: " + salida);

                //Generar respuestas aleatorias
                int pre2 = (int) (Math.random() * 3) + 1;

                if (pre2 == 1) {
                    a.setText(question.getRespuestaCorrecta());
                    b.setText(question.getRespuestaIncorrectaUno());
                    c.setText(question.getRespuestaIncorrectaDos());
                }
                if (pre2 == 2) {
                    a.setText(question.getRespuestaIncorrectaUno());
                    b.setText(question.getRespuestaCorrecta());
                    c.setText(question.getRespuestaIncorrectaDos());
                }
                if (pre2 == 3) {
                    a.setText(question.getRespuestaIncorrectaDos());
                    b.setText(question.getRespuestaIncorrectaUno());
                    c.setText(question.getRespuestaCorrecta());
                }
                band = false;
            }
        }

    }

    private Cuestionario() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupR = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnFinalizar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        a = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        b = new javax.swing.JRadioButton();
        c = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tituloLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cantidadContestadas = new javax.swing.JLabel();
        textArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(81, 191, 181));

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("selecciona la respuesta correcta");

        groupR.add(a);
        a.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("a)");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("b)");

        groupR.add(b);
        b.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        groupR.add(c);
        c.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("c)");

        jPanel2.setBackground(new java.awt.Color(81, 191, 181));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("/");

        tituloLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tituloLabel.setText("Titulo");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("10");

        cantidadContestadas.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cantidadContestadas.setText("1");

        textArea.setEditable(false);
        textArea.setBackground(new java.awt.Color(81, 191, 181));
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        textArea.setRows(5);
        textArea.setText("Pregunta: \n");
        textArea.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tituloLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cantidadContestadas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloLabel)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(cantidadContestadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizar)
                .addGap(18, 18, 18)
                .addComponent(btnSiguiente)
                .addGap(272, 272, 272))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(c))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(a))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(b)))
                .addContainerGap(903, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(a))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(b))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(c)
                    .addComponent(jLabel5))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 1220, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed

        if (a.isSelected() || b.isSelected() || c.isSelected()) {
            Respuesta res;
            if (a.isSelected()) {
                int clavePregunta = question.getClave();
                String respuesta = a.getText();
                res = new Respuesta(clavePregunta, respuesta,0);
                respuestas.add(res);
            }

            if (b.isSelected()) {
                int clavePregunta = question.getClave();
                String respuesta = b.getText();
                res = new Respuesta(clavePregunta, respuesta,0);
                respuestas.add(res);
            }

            if (c.isSelected()) {
                int clavePregunta = question.getClave();
                String respuesta = c.getText();
                res = new Respuesta(clavePregunta, respuesta,0);
                respuestas.add(res);
            }

            if (contesta < 10) {
                cantidadContestadas.setText(String.valueOf(++contesta));
                groupR.clearSelection();
                this.getQuestion();
            } else {
                btnFinalizar.setVisible(true);
                btnSiguiente.setVisible(false);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion");
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        for (Respuesta respuestas : respuestas) {
            base.saveAnswers(respuestas,clave);
        }
        Principal p= new Principal(alum);
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Principal p= new Principal(alum);
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cActionPerformed

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
            java.util.logging.Logger.getLogger(Cuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cuestionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton a;
    private javax.swing.JRadioButton b;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JRadioButton c;
    private javax.swing.JLabel cantidadContestadas;
    private javax.swing.ButtonGroup groupR;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}