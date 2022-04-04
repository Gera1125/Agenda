import javax.swing.*;
import java.awt.*;
public class JFrameModificar extends JFrame {
    Modificar mostrar = new Modificar();
    public JFrameModificar() {
        initComponents();
    }
    
    private void initComponents() {
        this.setEnabled(true);
        setSize(400, 200);
        setTitle("Modificar Contacto :s");
        setResizable(false);
        setContentPane(mostrar);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
