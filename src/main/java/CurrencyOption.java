import model.Divisa;
import services.CurrencyService;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;

public class CurrencyOption extends JDialog {
    //private String[] currencies = (String[]) Arrays.stream(Divisa.values()).toArray();
    private final CurrencyService currencyService = new CurrencyService();
    private JPanel contentPane;
    private JButton btnContinuar;
    private JButton btnCancelar;
    private JComboBox cboMonedaOrigen;
    private JComboBox cboMonedaDestino;
    private Divisa divisaOrigen;
    private Divisa divisaDestino;
    private Double valorIngresado;

    public CurrencyOption() {
        this.setSize(340,200);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnContinuar);

        for (Divisa currency : Divisa.values()) cboMonedaOrigen.addItem(currency.getValue(currency));
        rellenarCboDestino();

        setDivisas();

        btnContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
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

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numero = ingresarValor();

                while (!esValido(numero)){
                    numero = ingresarValor();
                }

                valorIngresado = Double.valueOf(numero);
                Double resultado;

                try {
                    resultado = currencyService.convertCurrent(valorIngresado,
                            divisaOrigen,
                            divisaDestino);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                //String resultadoStr = NumberFormat.getCurrencyInstance(getLocale()).format(resultado);

                StringBuilder sb = new StringBuilder();
                sb.append("La conversion de ").append(valorIngresado).append(" ")
                        .append(cboMonedaOrigen.getSelectedItem().toString())
                                .append(" a ").append(cboMonedaDestino.getSelectedItem().toString())
                        .append(" es:\n").append(resultado);

                //System.out.println("Resultado: " + resultado);
                JOptionPane.showConfirmDialog(null, sb.toString(), "Resultado", JOptionPane.DEFAULT_OPTION);
            }
        });

        cboMonedaOrigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(cboMonedaOrigen.getSelectedIndex());
                rellenarCboDestino();
                setDivisas();
                System.out.println(divisaOrigen.toString());
            }
        });

        cboMonedaDestino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDivisas();
                System.out.println(divisaDestino.toString());
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
/*
    public static void main(String[] args) {
        CurrencyOption dialog = new CurrencyOption();
        dialog.setSize(300,160);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }*/

    private void rellenarCboDestino() {
        cboMonedaDestino.removeAllItems();

        for (Divisa currency : Divisa.values()) {
            if (!currency.getValue(currency).equals(cboMonedaOrigen.getSelectedItem())) cboMonedaDestino.addItem(currency.getValue(currency));
        }
    }

    private void setDivisas(){
        divisaOrigen = Divisa.ARS.getDivisa(cboMonedaOrigen.getSelectedItem().toString());
        divisaDestino = Divisa.ARS.getDivisa(cboMonedaDestino.getSelectedItem().toString());
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
