import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Modificar extends JPanel implements ActionListener {
    private JButton btnBuscar, btnAceptar;
    private JTextField txtNombre, txtTelefono, txtCorreo, txtFechaCum;
    Agenda v = new Agenda();
    Persona p;
    String nombre, telefono, correo, fechacumple;
    
    public Modificar() {
        setLayout(new GridLayout(7, 2));
        JLabel lblNombre = new JLabel("Nombre o Apodo: ", JLabel.RIGHT);
        txtNombre = new JTextField(15);
        add(lblNombre);
        add(txtNombre);
        
        JLabel lblTelefono = new JLabel("Numero de Celular: ", JLabel.RIGHT);
        txtTelefono = new JTextField(15);
        add(lblTelefono);
        add(txtTelefono);
        
        JLabel lblCorreo = new JLabel("Correo electronico: ", JLabel.RIGHT);
        txtCorreo = new JTextField(20);
        add(lblCorreo);
        add(txtCorreo);
        
        JLabel lblFechaCum = new JLabel("Fecha de naciemiento: ", JLabel.RIGHT);
        txtFechaCum = new JTextField(15);
        add(lblFechaCum);
        add(txtFechaCum);
        
        btnAceptar = new JButton("Guardar");
        btnAceptar.addActionListener(this);
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this);
        add(btnBuscar);
        add(btnAceptar);
        
        txtTelefono.setEditable(false);
        txtCorreo.setEditable(false);
        txtFechaCum.setEditable(false);
        btnAceptar.setEnabled(false);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBuscar) {
            if(txtNombre.getText() == null || txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes de colocar el nombre para modificar",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtNombre.requestFocus();
            } else {
                nombre = txtNombre.getText();
                int n = v.getPersona(nombre);
                if(n != -2) {
                    Persona p = v.consultar(n);
                    txtTelefono.setText(p.getTelefono());
                    txtCorreo.setText(p.getCorreo());
                    txtFechaCum.setText(p.getFechaCumple());
                    txtTelefono.setEditable(true);
                    txtCorreo.setEditable(true);
                    txtFechaCum.setEditable(true);
                    btnAceptar.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "No hay ninguna persona registrada con ese nombre",
                            "ERROR",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if(e.getSource() == btnAceptar) {
            if(txtTelefono.getText() == null || txtNombre.getText().isEmpty() || txtCorreo.getText() == null || txtCorreo.getText().isEmpty() || txtFechaCum.getText() == null || txtFechaCum.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los espacios deben estar completos para poder guardar",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                  nombre = txtNombre.getText();
                  int n = v.getPersona(nombre);
                  nombre = txtNombre.getText();
                  telefono = txtTelefono.getText();
                  correo = txtCorreo.getText();
                  fechacumple = txtFechaCum.getText();
                  setP(new Persona(nombre, telefono, correo, fechacumple));
                  v.modificar(n, p);
                  JOptionPane.showMessageDialog(null, "Se editaron los datos de la persona",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                  txtNombre.setText(null);
                  txtTelefono.setText(null);
                  txtCorreo.setText(null);
                  txtFechaCum.setText(null);
            
                  txtTelefono.setEditable(false);
                  txtCorreo.setEditable(false);
                  txtFechaCum.setEditable(false);
                  btnAceptar.setEnabled(true);
          }
      }
    }
    public Persona getP() {
        return p;
    }
    public void setP(Persona p) {
        this.p = p;
    }
}
