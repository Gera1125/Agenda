import javax.swing.*;
import java.awt.*;
public class JFrameConsultaIndi extends JFrame {
    ConsultaIndi mostrar = new ConsultaIndi();
    
    public JFrameConsultaIndi() {
        initComponents();
    }
    
    private void initComponents() {
        this.setEnabled(true);
        setSize(400, 200);
        setTitle("Consultar Contacto *w*");
        setResizable(false);
        setContentPane(mostrar);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
