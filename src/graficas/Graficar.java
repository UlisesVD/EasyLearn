package graficas;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import pojo.Acierto;

public class Graficar extends javax.swing.JFrame {
    float mediaG;
    DefaultComboBoxModel<String> modelThemes;
    ArrayList<Integer> calificaciones = new ArrayList();

    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    Base base = new Base();
    
    String grupo;

    public Graficar(String fullName, String grupo) {
        modelThemes = new DefaultComboBoxModel();
        initComponents();
        this.grupo = grupo;
        ocultar();
        addColumns();
        addThemes();
        llenarTabla();
        llenarDatosMaestro(fullName, grupo);
    }

    public void llenarDatosMaestro(String fullName, String grupo) {
        StringTokenizer st = new StringTokenizer(fullName);
        String nombre = st.nextToken();
        String ap = st.nextToken();
        String am = st.nextToken();
        
        labelApellidos.setText(ap+" "+am);
        labelNombre.setText(nombre);
        labelGrupo.setText("Grupo: "+grupo);
    }

    private Graficar() {
        modelThemes = new DefaultComboBoxModel();
        initComponents();
        ocultar();
        addColumns();
        addThemes();
        llenarTabla();
    }

    public void ocultar() {
        labelMediana.setVisible(false);
        labelMedia.setVisible(false);
        labelModa.setVisible(false);
        btnReciomend.setVisible(false);
    }

    public void addColumns() {
        modeloTabla.addColumn("Numero lista");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Aciertos");
    }

    public void addThemes() {
        ArrayList<String> listarTemas;
        listarTemas = base.obtenerTemas();
        modelThemes.removeAllElements();
        for (String codigo : listarTemas) {
            modelThemes.addElement(codigo);
        }
    }

    private void llenarTabla() {
        ArrayList<Acierto> listaAciertos = base.obtenerAciertos(comboTema.getSelectedItem().toString(), this.grupo);
        int numeroBases = listaAciertos.size();
        modeloTabla.setNumRows(numeroBases);

        for (int i = 0; i < numeroBases; i++) {
            Acierto ac = listaAciertos.get(i);
            
            modeloTabla.setValueAt(i+1, i, 0);
            modeloTabla.setValueAt(ac.getNombre(), i, 1);
            modeloTabla.setValueAt(ac.getAciertos(), i, 2);
        }

        createGraf();
    }

    public void createGraf() {
        DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
        dtsc.clear();

        calificaciones.removeAll(calificaciones);

        
        for (int i = 0; i < tablaAlumnos.getRowCount(); i++) {
            int calificacion = Integer.parseInt(tablaAlumnos.getValueAt(i, 2).toString());
            calificaciones.add(calificacion);    

            dtsc.setValue(calificacion, tablaAlumnos.getValueAt(i, 0).toString(), "");
        }
        //JFreeChart ch = ChartFactory.createBarChart3D("Grafica de barras 3D", "Cantidad", "Genero", dtsc, PlotOrientation.HORIZONTAL, true, true, false);
        JFreeChart ch = ChartFactory.createBarChart3D("Resultados", "Nombre", "Califiaciones", dtsc, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel cp = new ChartPanel(ch);

        panelGrafica.add(cp);

        cp.setBounds(0, 0, 510, 365);

        calculosEstadisticos();
    }

    public void calculosEstadisticos() {
        float media = 0;
        int moda = 0;
        int poblacion = calificaciones.size();

        if (poblacion > 0) {
            for (Integer calificacion : calificaciones) {
                media += calificacion;
            }
            labelMedia.setVisible(true);
            labelMediana.setVisible(true);
            labelModa.setVisible(true);
            btnReciomend.setVisible(true);

            labelMedia.setText("Media: " + media / poblacion);
            mediaG = media / poblacion;
            labelMediana.setText("Mediana: " + (int) media / poblacion);

            calificaciones.sort(null);
            int cant = 0;
            int cont = 0;
            for (int i = 0; i < poblacion - 1; i++) {
                if ((int) calificaciones.get(i) == calificaciones.get(i + 1)) {
                    cont++;
                } else {
                    if (cont > cant) {
                        cant = cont;
                        moda = calificaciones.get(i);
                    }
                }
            }
            labelModa.setText("Moda: " + moda);
        } else {
            ocultar();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelApellidos = new javax.swing.JLabel();
        labelGrupo = new javax.swing.JLabel();
        comboTema = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        panelGrafica = new javax.swing.JPanel();
        labelMediana = new javax.swing.JLabel();
        labelMedia = new javax.swing.JLabel();
        labelModa = new javax.swing.JLabel();
        btnReciomend = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(81, 191, 181));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(17, 98, 91));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("Nombre");

        labelApellidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelApellidos.setForeground(new java.awt.Color(255, 255, 255));
        labelApellidos.setText("Apellidos");

        labelGrupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelGrupo.setForeground(new java.awt.Color(255, 255, 255));
        labelGrupo.setText("Grupo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(labelGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelApellidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(labelGrupo)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 50, 320, -1));

        comboTema.setModel(modelThemes);
        comboTema.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTemaItemStateChanged(evt);
            }
        });
        comboTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTemaActionPerformed(evt);
            }
        });
        jPanel1.add(comboTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 195, 269, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Temas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 168, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Datos tutor");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 17, -1, -1));

        tablaAlumnos.setModel(modeloTabla);
        jScrollPane1.setViewportView(tablaAlumnos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 246, 371, 241));

        panelGrafica.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelGrafica.setForeground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout panelGraficaLayout = new javax.swing.GroupLayout(panelGrafica);
        panelGrafica.setLayout(panelGraficaLayout);
        panelGraficaLayout.setHorizontalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        panelGraficaLayout.setVerticalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jPanel1.add(panelGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 50, -1, -1));

        labelMediana.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelMediana.setForeground(new java.awt.Color(255, 255, 255));
        labelMediana.setText("Mediana: ");
        jPanel1.add(labelMediana, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 150, 30));

        labelMedia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelMedia.setForeground(new java.awt.Color(255, 255, 255));
        labelMedia.setText("Media: ");
        jPanel1.add(labelMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 140, 28));

        labelModa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelModa.setForeground(new java.awt.Color(255, 255, 255));
        labelModa.setText("Moda: ");
        jPanel1.add(labelModa, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 160, 30));

        btnReciomend.setBackground(new java.awt.Color(51, 153, 0));
        btnReciomend.setForeground(new java.awt.Color(255, 255, 255));
        btnReciomend.setText("Recomendacion");
        btnReciomend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReciomendActionPerformed(evt);
            }
        });
        jPanel1.add(btnReciomend, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, -1, 30));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 30, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTemaActionPerformed


    }//GEN-LAST:event_comboTemaActionPerformed

    private void comboTemaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTemaItemStateChanged
        panelGrafica.removeAll();
        llenarTabla();
    }//GEN-LAST:event_comboTemaItemStateChanged

    private void btnReciomendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReciomendActionPerformed
        if (mediaG>1 && mediaG<6) {
            JOptionPane.showMessageDialog(this, "Debes prestar mas atencion al aprenizaje de tus alumnos\nTal vez debas intentar cosas nuevas ","456",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (mediaG>6 && mediaG<8) {
            JOptionPane.showMessageDialog(this, "Tus alumnos son bastante buenos\nAunque aun tiene cosas que aprender, Guialos correctamente","456",JOptionPane.INFORMATION_MESSAGE);
        }
        if (mediaG>8 && mediaG<11) {
            JOptionPane.showMessageDialog(this, "Tus alumnos son muy buenos\nHas hecho un gran trabajo al enseñarles","456",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnReciomendActionPerformed

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
            java.util.logging.Logger.getLogger(Graficar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graficar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graficar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graficar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graficar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReciomend;
    private javax.swing.JComboBox<String> comboTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelGrupo;
    private javax.swing.JLabel labelMedia;
    private javax.swing.JLabel labelMediana;
    private javax.swing.JLabel labelModa;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JPanel panelGrafica;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
