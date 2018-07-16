package splash;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import ventanas.VentanaInicio;

public class CargaSplash extends Thread{
    private JProgressBar progresBar;
    private SplashScreen window;
    private JLabel lbProgress;

    public CargaSplash(JProgressBar progresBar, SplashScreen window, JLabel lbProgress) {
        super();
        this.progresBar = progresBar;
        this.window = window;
        this.lbProgress = lbProgress;
    }

    @Override
    public void run() {
        setProgress(0);
        pause(1000);
        setProgress(10);
        pause(2000);
        setProgress(30);
        pause(2000);
        setProgress(45);
        pause(1000);
        setProgress(80);
        pause(2000);
        setProgress(85);
        pause(500);
        setProgress(90);
        pause(500);
        setProgress(92);
        setProgress(98);
        setProgress(100);
        
    }
    
    public void pause(int mls){
        try {
            Thread.sleep(mls);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void setProgress(int valor){
        progresBar.setValue(valor);
        lbProgress.setText(valor+"%");
        
        pause(1000);
        
        if (valor == 100) {
            pause(1000);
            window.dispose();
            new VentanaInicio().setVisible(true);
        }
    }
    
}
