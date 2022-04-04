import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Eliminar extends JPanel implements ActionListener {
    private JButton btnBuscar, btnEliminar;
    private JTextField txtNombre, txtTelefono, txtCorreo, txtFechaCum;
    Agenda v = new Agenda();
    public Eliminar() {
        setLayout(new GridLayout(7, 2));
        JLabel lblNombre = new JLabel("Nombre o Apodo: ", JLabel.RIGHT);
        txtNombre = new JTextField(15);
        add(lblNombre);
        add(txtNombre);
        
        JLabel lblTelefono = new JLabel("Numero de telefono: ", JLabel.RIGHT);
        txtTelefono = new JTextField(15);
        add(lblTelefono);
        add(txtTelefono);
        
        JLabel lblCorreo = new JLabel("Correo electronico: ", JLabel.RIGHT);
        txtCorreo = new JTextField(20);
        add(lblCorreo);
        add(txtCorreo);
        
        JLabel lblFechaCum = new JLabel("Fecha de nacimiento: ", JLabel.RIGHT);
        txtFechaCum = new JTextField(15);
        add(lblFechaCum);
        add(txtFechaCum);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        add(btnBuscar);
        add(btnEliminar);
        
        txtTelefono.setEditable(false);
        txtCorreo.setEditable(false);
        txtFechaCum.setEditable(false);
        btnEliminar.setEnabled(false);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBuscar) {
            if(txtNombre.getText() == null || txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes de colocar el nombre para eliminar",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtNombre.requestFocus();
            } else {
                String nombre = txtNombre.getText();
                int n = v.getPersona(nombre);
                if(n != -2) {
                    Persona p = v.consultar(n);
                    txtTelefono.setText(p.getTelefono());
                    txtCorreo.setText(p.getCorreo());
                    txtFechaCum.setText(p.getFechaCumple());
                    btnEliminar.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "No hay ninguna persona registrada con ese nombre",
                            "ERROR",
                    JOptionPane.ERROR_MESSAGE);
                    txtNombre.requestFocus();
                }
            }
        }
        
        if(e.getSource() == btnEliminar) {
            String nombre = txtNombre.getText();
            int n = v.getPersona(nombre);
            v.eliminar(n);
            JOptionPane.showMessageDialog(null, "La persona ha sido eliminada de la agenda",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            txtNombre.requestFocus();
            txtNombre.setText(null);
            txtTelefono.setText(null);
            txtCorreo.setText(null);
            txtFechaCum.setText(null);
            
            btnEliminar.setEnabled(true);
        }
    }
}
