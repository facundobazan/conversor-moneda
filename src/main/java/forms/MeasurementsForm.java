package forms;

import services.ConverterService;

import javax.swing.*;
import java.awt.event.*;

public class MeasurementsForm extends JDialog {
    private final ConverterService converterService = new ConverterService();
    private final String[] options = {"Milimetos a centimetros", "Centimetros a milimetros", "Centimetros a metros",
            "Metros a centimetros", "Centimetros a pulgadas", "Pulgadas a centimetros", "Metros a pies", "Pies a metros"};
    private JPanel contentPane;
    private JButton btnContinuar;
    private JButton btnRegresar;
    private JComboBox cboMedidas;

    public MeasurementsForm() {
        this.setSize(240,160);
        this.setResizable(false);
        this.setTitle("Conversor de medidas");
        cboMedidas.setModel(new DefaultComboBoxModel(options));
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
                StringBuilder sb = new StringBuilder().append(valorIngresado);
                String selectedItem = cboMedidas.getSelectedItem().toString();

                if(selectedItem == options[0]){
                    resultado = converterService.millimetersToCentimeters(valorIngresado);
                    sb.append("mm equivalen a ").append(resultado).append("cm");
                }

                if(selectedItem == options[1]){
                    resultado = converterService.centimetersToMillimeters(valorIngresado);
                    sb.append("cm equivalen a ").append(resultado).append("mm");
                }

                if(selectedItem == options[2]){
                    resultado = converterService.centimetersToMeters(valorIngresado);
                    sb.append("cm equivalen a ").append(resultado).append("mts");
                }

                if(selectedItem == options[3]){
                    resultado = converterService.metersToCentimeters(valorIngresado);
                    sb.append("mts equivalen a ").append(resultado).append("cm");
                }

                if(selectedItem == options[4]){
                    resultado = converterService.centimetersToInches(valorIngresado);
                    sb.append("cm equivalen a ").append(resultado).append("\"");
                }

                if(selectedItem == options[5]){
                    resultado = converterService.inchesToCentimeters(valorIngresado);
                    sb.append("\" equivalen a ").append(resultado).append("cm");
                }

                if(selectedItem == options[6]){
                    resultado = converterService.metersToFeet(valorIngresado);
                    sb.append("mts equivalen a ").append(resultado).append(" pies");
                }

                if(selectedItem == options[7]){
                    resultado = converterService.feetToMeters(valorIngresado);
                    sb.append(" pies equivalen a ").append(resultado).append("mts");
                }

                JOptionPane.showConfirmDialog(null, sb.toString(), "Resultado", JOptionPane.DEFAULT_OPTION);
                //onOK();
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
