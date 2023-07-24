package forms;

import services.ConverterService;

import javax.swing.*;
import java.awt.event.*;

public class TemperaturesForm extends JDialog {
    private final ConverterService converterService = new ConverterService();
    private JPanel contentPane;
    private JButton btnContinuar;
    private JButton btnRegresar;
    private JRadioButton rbtCtoF;
    private JRadioButton rbtFtoC;

    public TemperaturesForm() {
        this.setSize(240,180);
        this.setResizable(false);
        this.setTitle("Conversor de temperaturas");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnContinuar);

        btnContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numero = ingresarValor();
                if(numero == null) return;

                while (!esValido(numero)){
                    numero = ingresarValor();
                }

                Double valorIngresado = Double.valueOf(numero);
                Double resultado;
                StringBuilder sb = new StringBuilder();

                if(rbtFtoC.isSelected()){
                    resultado = converterService.fahrenheitToCelsius(valorIngresado);
                    sb.append(valorIngresado.shortValue()).append("º Fahrenheit son ").append(resultado.shortValue()).append("º Celsius.");
                }

                if(rbtCtoF.isSelected()){
                    resultado = converterService.celsiusToFahrenheit(valorIngresado);
                    sb.append(valorIngresado.shortValue()).append("º Celsius son ").append(resultado.shortValue()).append("º Fahrenheit.");
                }

                JOptionPane.showConfirmDialog(null, sb.toString(), "Resultado", JOptionPane.DEFAULT_OPTION);
                onOK();
            }
        });

        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        rbtCtoF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbtFtoC.setSelected(!rbtCtoF.isSelected());
            }
        });

        rbtFtoC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbtCtoF.setSelected(!rbtFtoC.isSelected());
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private String ingresarValor(){
        return JOptionPane.showInputDialog("Ingrese el valor a convertir");
    }

    private Boolean esValido(String value){
        try {
            Double.valueOf(value);
            return true;
        }catch (NumberFormatException numberFormatException){
            JOptionPane.showConfirmDialog(null,"Solo se permiten numeros", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
