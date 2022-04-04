import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Menu extends JPanel implements ActionListener {
    private JButton btnAlta, btnConsultaIndi, btnConsultaGen, btnEliminar, btnModificar, btnSalir;
    
    public Menu() {
        btnAlta = new JButton("Dar de alta");
        btnAlta.addActionListener(this);
        btnConsultaIndi = new JButton("Consulta Individual");
        btnConsultaIndi.addActionListener(this);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(this);
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(this);
        add(btnAlta);
        add(btnConsultaIndi);
        add(btnEliminar);
        add(btnModificar);
        add(btnSalir);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAlta) {
            JFrameAlta Alta = new JFrameAlta();
        }
        
        if(e.getSource() == btnConsultaIndi) {
            JFrameConsultaIndi conIndi = new JFrameConsultaIndi();
        }
                
        if(e.getSource() == btnModificar) {
            JFrameModificar modificar = new JFrameModificar();
        }
        
        if(e.getSource() == btnEliminar) {
            JFrameEliminar eliminar = new JFrameEliminar();
        }
        
        if(e.getSource() == btnSalir) {
            System.exit(0);      
         }
    }
}
