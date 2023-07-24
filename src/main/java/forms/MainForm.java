package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainForm extends JFrame {
    private final JPanel panel = new JPanel();
    private JLabel label = new JLabel("Seleccione una tarea");
    private final String[] opciones = {"Conversor de divisas", "Conversor de temperaturas", "Conversor de medidas"};
    private JComboBox cboOpciones = new JComboBox<>(opciones);
    private JButton btnAceptar = new JButton("Aceptar");
    private JButton btnCancelar = new JButton("Cancelar");

    public MainForm() {
        this.setSize(300, 140);
        this.setTitle("Conversor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.add(label);

        btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.add(cboOpciones);
        panel.add(btnAceptar);
        panel.add(btnCancelar);

        this.add(panel);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String opcionSeleccionada = Objects.requireNonNull(cboOpciones.getSelectedItem()).toString();
                JDialog dialog = new JDialog();

                if (opcionSeleccionada.equals(opciones[0])) dialog = new CurrencyForm();
                if (opcionSeleccionada.equals(opciones[1])) dialog = new TemperaturesForm();
                if (opcionSeleccionada.equals(opciones[2])) dialog = new MeasurementsForm();

                dialog.setVisible(true);
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "¿Deseas salir del programa?", "Atención", JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        MainForm f = new MainForm();
        f.setVisible(true);
    }
}
