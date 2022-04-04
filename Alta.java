import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Alta extends JPanel implements ActionListener {
    private JButton btnBuscar, btnGuardar;
    private JTextField txtNombre, txtTelefono, txtCorreo, txtFechaCum;
    Agenda v = new Agenda();
    
    public Alta() {
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
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(this);
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this);
        add(btnBuscar);
        add(btnGuardar);
        
        txtTelefono.setEditable(false);
        txtCorreo.setEditable(false);
        txtFechaCum.setEditable(false);
        btnGuardar.setEnabled(false);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBuscar) {
            if(txtNombre.getText() == null || txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes de colocar el nombre para registrar",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtNombre.requestFocus();
            } else {
                String nombre = txtNombre.getText();
                int n = v.getPersona(nombre);
                if(n != -2) {
                    JOptionPane.showMessageDialog(this,
                            "El nombre ya esta registrado en la agenda",
                            "Nombre repetido",
                    JOptionPane.ERROR_MESSAGE);
                    txtNombre.requestFocus();
                } else {
                    txtTelefono.setEditable(true);
                    txtCorreo.setEditable(true);
                    txtFechaCum.setEditable(true);
                    btnGuardar.setEnabled(true);
                    txtTelefono.requestFocus();
                }
            }
        }
        if(e.getSource() == btnGuardar) {
            if(txtTelefono.getText() == null || txtNombre.getText().isEmpty() || txtCorreo.getText() == null || txtCorreo.getText().isEmpty() || txtFechaCum.getText() == null || txtFechaCum.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los espacios para poder guardar",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtTelefono.requestFocus();
            } else {
                  v.agregar(txtNombre.getText(), txtTelefono.getText(), txtCorreo.getText(), txtFechaCum.getText());
                  JOptionPane.showMessageDialog(null, "Los Datos se estan guardando",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                  txtNombre.setText(null);
                  txtTelefono.setText(null);
                  txtCorreo.setText(null);
                  txtFechaCum.setText(null);
            
                  txtTelefono.setEditable(false);
                  txtCorreo.setEditable(false);
                  txtFechaCum.setEditable(false);
                  btnGuardar.setEnabled(false);
               }  
        }
   }
}