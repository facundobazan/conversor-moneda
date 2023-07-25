package forms;

import model.Currency;
import services.ConverterService;
import services.CurrencyService;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.NumberFormat;

public class CurrencyForm extends JDialog {
    private final CurrencyService currencyService = new CurrencyService();
    private final ConverterService converterService = new ConverterService();
    private JPanel contentPane;
    private JButton btnContinuar;
    private JButton btnRegresar;
    private JComboBox<Currency> cboMonedaOrigen;
    private JComboBox<Currency> cboMonedaDestino;
    private Double valorIngresado;

    public CurrencyForm() {
        this.setSize(360,200);
        this.setResizable(false);
        this.setTitle("Conversor de monedas");
        setComboBox(cboMonedaOrigen);
        updateCboDestino();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnContinuar);

        btnContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numero = ingresarValor();
                if(numero == null) return;

                while (!esValido(numero)){
                    numero = ingresarValor();
                }

                valorIngresado = Double.valueOf(numero);
                Double resultado;

                try {
                    resultado = converterService.converterCurrencies(valorIngresado,
                            ((Currency) cboMonedaOrigen.getSelectedItem()).getAbbreviation(),
                            ((Currency) cboMonedaDestino.getSelectedItem()).getAbbreviation());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String resultadoStr = NumberFormat.getCurrencyInstance(getLocale()).format(resultado);

                String sb = "La conversion de " + valorIngresado + " " +
                        cboMonedaOrigen.getSelectedItem().toString() +
                        " a " + cboMonedaDestino.getSelectedItem().toString() +
                        " es:\n" + resultadoStr;

                JOptionPane.showConfirmDialog(null, sb, "Resultado", JOptionPane.DEFAULT_OPTION);
            }
        });

        cboMonedaOrigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCboDestino();
            }
        });

        cboMonedaDestino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    private void updateCboDestino() {
        cboMonedaDestino.removeAllItems();
        setComboBox(cboMonedaDestino);
        cboMonedaDestino.removeItem(cboMonedaOrigen.getSelectedItem());
    }

    private void setComboBox(JComboBox comboBox){
        comboBox.setModel(new DefaultComboBoxModel<>(currencyService.getArrayCurrencies()));
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
