package splash;

import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import rojerusan.componentes.RSProgressBarSinText;

public class SplashScreen extends javax.swing.JFrame {

    FileInputStream fis;
    int longitudBytes;
    File archivo;

    public SplashScreen() {
        initComponents();
        imageDefault();
        AWTUtilities.setWindowOpaque(this, false);
        this.setLocationRelativeTo(this);
        
        this.bPInicio.setValue(0);
        this.textBPInicio.setText("0%");
        startThread();
    }

    public void imageDefault() {
        try {
            URL url = this.getClass().getResource("/images/easylearnlogo.gif");
            ImageIcon fot = new ImageIcon(url);
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(labelImagen.getWidth(), labelImagen.getHeight(), Image.SCALE_DEFAULT));
            labelImagen.setIcon(icono);
            //archivo = new File("C:/Users/Mauricio/Desktop/SimuladorMatematicas2/src/images/easylearnlogo.gif");
            archivo = new File("C://Users//uli_v//Documents//NetBeansProjects//Splash//src/images/easylearnlogo.gif");
            //archivo = new File(path);

            fis = new FileInputStream(archivo);
            this.repaint();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        rSPanelCircleBorder1 = new rspanelcircleborder.RSPanelCircleBorder();
        rSPanelCircleBorder2 = new rspanelcircleborder.RSPanelCircleBorder();
        jLabel1 = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bPInicio = new rojerusan.componentes.RSProgressBarSinText();
        textBPInicio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        rSPanelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(81, 191, 181));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelCircleBorder1.setColorBorde(new java.awt.Color(0, 72, 67));

        rSPanelCircleBorder2.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelCircleBorder2.setColorBorde(new java.awt.Color(0, 72, 67));

        jLabel1.setBackground(new java.awt.Color(17, 98, 91));
        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EasyLearn");

        javax.swing.GroupLayout rSPanelCircleBorder2Layout = new javax.swing.GroupLayout(rSPanelCircleBorder2);
        rSPanelCircleBorder2.setLayout(rSPanelCircleBorder2Layout);
        rSPanelCircleBorder2Layout.setHorizontalGroup(
            rSPanelCircleBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelCircleBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelCircleBorder2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        rSPanelCircleBorder2Layout.setVerticalGroup(
            rSPanelCircleBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelCircleBorder2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rSPanelCircleBorder1Layout = new javax.swing.GroupLayout(rSPanelCircleBorder1);
        rSPanelCircleBorder1.setLayout(rSPanelCircleBorder1Layout);
        rSPanelCircleBorder1Layout.setHorizontalGroup(
            rSPanelCircleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelCircleBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelCircleBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
        rSPanelCircleBorder1Layout.setVerticalGroup(
            rSPanelCircleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelCircleBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelCircleBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(rSPanelCircleBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 230, 230));

        jPanel2.setBackground(new java.awt.Color(17, 98, 91));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 0, 5, 0, new java.awt.Color(0, 72, 67)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 584, 120));

        bPInicio.setForeground(new java.awt.Color(0, 72, 67));
        bPInicio.setColorForeground(new java.awt.Color(0, 72, 67));
        jPanel1.add(bPInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 300, -1));

        textBPInicio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textBPInicio.setForeground(new java.awt.Color(102, 102, 102));
        textBPInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textBPInicio.setText("50%");
        jPanel1.add(textBPInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 300, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 3, 26)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cargando espere un momento...");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 584, -1));

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.componentes.RSProgressBarSinText bPInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelImagen;
    private rspanelcircleborder.RSPanelCircleBorder rSPanelCircleBorder1;
    private rspanelcircleborder.RSPanelCircleBorder rSPanelCircleBorder2;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private javax.swing.JLabel textBPInicio;
    // End of variables declaration//GEN-END:variables
    CargaSplash hilo;
    
    public RSProgressBarSinText getProgress(){
        return this.bPInicio;
    }
    
    public void setprogress(RSProgressBarSinText progress){
        this.bPInicio = progress;
    }
    
    public void startThread(){
        hilo = new CargaSplash(getProgress(),this, textBPInicio);
        hilo.start();
        hilo = null;
    }
}
